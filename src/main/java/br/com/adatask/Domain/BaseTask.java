package br.com.adatask.Domain;

import br.com.adatask.Domain.Enums.Status;

import java.time.LocalDate;
import java.util.UUID;

public abstract class BaseTask {
    private String randomID;
    private String title;
    private String description;
    private LocalDate deadline;
    private final LocalDate createdDate;

    private Status status;

    public BaseTask(String title, String description, LocalDate deadline) {
        this.randomID = generateRandomID();
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.createdDate = LocalDate.now();
        this.status = Status.TO_DO;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    private String generateRandomID(){
        return UUID.randomUUID().toString();
    }

    public String getRandomID() {
        return randomID;
    }

}
