package com.imlinker.storage.user;

import com.imlinker.storage.common.model.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Builder
@AllArgsConstructor
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "oauth_vendor")
    private String oauthVendor;

    @Column(name = "oauth_identifier")
    private String oauthIdentifier;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "refresh_token")
    private String refreshToken;

    @Column(name = "profile_img_url")
    private String profileImgUrl;
}
