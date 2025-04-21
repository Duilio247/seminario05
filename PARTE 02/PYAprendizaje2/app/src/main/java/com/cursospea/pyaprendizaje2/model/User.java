package com.cursospea.pyaprendizaje2.model;

public class User {
    private String id;
    private String name;
    private String profession;
    private String email;
    private String phone;
    private String bio;
    private String avatarUri;

    public User() {
        // Constructor vacío requerido para algunas operaciones
    }

    public User(String id, String name, String profession, String email, String phone, String bio, String avatarUri) {
        this.id = id;
        this.name = name;
        this.profession = profession;
        this.email = email;
        this.phone = phone;
        this.bio = bio;
        this.avatarUri = avatarUri;
    }

    // Getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBio() {

        return bio;
    }

    public void setBio(String bio) {

        this.bio = bio;
    }

    public String getAvatarUri() {
        return avatarUri;
    }

    public void setAvatarUri(String avatarUri) {
        this.avatarUri = avatarUri;
    }

}
