package ru.karelin.tmweb.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends AbstractEntity {
    private String login;
    private String passHash;
    private String username;
}
