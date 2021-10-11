package com.example.ic206iecireol.models;

public class UserMapper {
    private IUser user;

    public UserMapper(IUser user){
        this.user = user;
    }

    public UserEntity toEntity() {
        return new UserEntity(
                this.user.getId(),
                this.user.getFirsName(),
                this.user.getUserName(),
                this.user.getLastName(),
                this.user.getBirthDate(),
                this.user.getHeight(),
                this.user.getPassword()
        );
    }

    public User toBase() {
        User userBase = new User(
                this.user.getFirsName(),
                this.user.getUserName(),
                this.user.getLastName(),
                this.user.getBirthDate(),
                this.user.getHeight()

        );
        userBase.setPassword(this.user.getPassword());
        userBase.setId(this.user.getId());
        return userBase;
    }
}
