package br.com.adatask;

import br.com.adatask.Controller.PersonalTaskController;
import br.com.adatask.Controller.StudyTaskController;
import br.com.adatask.Controller.WorkTaskController;
import br.com.adatask.Domain.PersonalTask;
import br.com.adatask.Repository.BaseTaskRepository;
import br.com.adatask.Repository.TaskRepository;
import br.com.adatask.Service.BaseTaskService;
import br.com.adatask.Service.TaskService;

import java.time.LocalDate;
import java.util.Scanner;

public class AdaTaskApp {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        TaskRepository taskRepository = new BaseTaskRepository();
        TaskService taskService = new BaseTaskService(taskRepository);

        PersonalTaskController personalTaskController = new PersonalTaskController(taskService);
        WorkTaskController workTaskController = new WorkTaskController(taskService);
        StudyTaskController studyTaskController = new StudyTaskController(taskService);

        int taskType;
        do {
            System.out.println("---------------------------------");
            System.out.println("-----BEMVINDO AO ADATASK APP-----");
            System.out.println("---------------------------------");
            System.out.println("Escolha o tipo de tarefa:");
            System.out.println("1. Tarefa Pessoal");
            System.out.println("2. Tarefa Profissional");
            System.out.println("3. Tarefa de Estudo");
            System.out.println("4. Sair do APP");
            System.out.println("---------------------------------");
            System.out.print("Escolha uma opção: ");

            taskType = scanner.nextInt();

            switch (taskType) {
                case 1:
                    personalTaskController.start(scanner);
                    break;
                case 2:
                    workTaskController.start(scanner);
                    break;
                case 3:
                    studyTaskController.start(scanner);
                    break;
                case 4:
                    System.out.println("--SAINDO DO ADATASK APP--");
                    System.exit(4);
                    break;

            }


        } while(taskType != 4);

    }
}
