package br.com.adatask.Domain;

import br.com.adatask.Domain.Enums.Status;

import java.time.LocalDate;

public class StudyTask extends BaseTask{

    public StudyTask(String title, String description, LocalDate deadline) {
        super(title, description, deadline);
    }

    @Override
    public String toString() {
        return "--StudyTask--\n" +
                "ID: " + getRandomID() + "\n" +
                "Título: " + getTitle() + "\n" +
                "Descripção: " + getDescription() + "\n" +
                "Prazo: " + getDeadline() +"\n" +
                "Status: " + getStatus() + "\n";
    }
}
