package br.com.adatask.Domain;

import br.com.adatask.Domain.Enums.Status;

import java.time.LocalDate;

public class WorkTask extends BaseTask{
    public WorkTask(String title, String description, LocalDate deadline) {
        super(title, description, deadline);
    }

    @Override
    public String toString() {
        return "WorkTask\n" +
                "ID: " + getRandomID() + "\n" +
                "Título: " + getTitle() + "\n" +
                "Descripção: " + getDescription() + "\n" +
                "Prazo: " + getDeadline() +"\n" +
                "Status: " + getStatus() + "\n";

    }
}
