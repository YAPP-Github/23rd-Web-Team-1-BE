package com.imlinker.domain.contacts;

import com.imlinker.domain.contacts.model.ContactInterest;
import com.imlinker.domain.contacts.model.ContactProfile;
import com.imlinker.domain.contacts.model.Contacts;
import com.imlinker.domain.tag.Tag;
import com.imlinker.enums.OperationResult;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ContactsService {
    private final ContactsReader contactsReader;
    private final ContactsUpdater contactsUpdater;
    private final ContactInterestReader contactInterestReader;
    private final ContactInterestUpdater contactInterestUpdater;

    public ContactProfile getContactProfile(Long contactId, Long userId) {
        Contacts contact = contactsReader.findContactByIdAndUserId(userId, contactId);
        List<Tag> contactInterests = contactInterestReader.findAllByContact(contact);

        return new ContactProfile(contact, contactInterests);
    }

    public List<Contacts> getAllContacts(Long userId) {
        return contactsReader.findContactsByUserId(userId);
    }

    @Transactional
    public OperationResult createContact(CreateContactParam param) {
        Contacts contact =
                contactsUpdater.create(
                        param.name(),
                        param.userId(),
                        param.profileImgUrl(),
                        param.job(),
                        param.association(),
                        param.description());

        List<ContactInterest> contactInterests =
                contactInterestUpdater.update(contact.id(), param.interests());

        return OperationResult.SUCCESS;
    }
}