package br.com.adatask.Controller;

import br.com.adatask.Domain.BaseTask;
import br.com.adatask.Domain.Enums.Status;
import br.com.adatask.Domain.PersonalTask;
import br.com.adatask.Service.TaskService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PersonalTaskController implements UserInterface{
    private TaskService taskService;


    public PersonalTaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @Override
    public void start(Scanner scanner){
        System.out.println("----------------------------");
        System.out.println("------Tarefas Pessoais------");
        System.out.println("----------------------------");
        System.out.println("1. Adicionar Tarefa");
        System.out.println("2. Editar Tarefa");
        System.out.println("3. Remover Tarefa");
        System.out.println("4. Listar todas as Tarefas");
        System.out.println("0. Sair");
        System.out.println("---------------------------");
        System.out.print("Escolha uma opção: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                createTask(scanner);
                break;
            case 2:
                updateTask(scanner);
                break;
            case 3:
                deleteTask(scanner);
                break;
            case 4:
                listAllTasks();
                break;
            case 0:
                System.out.println("--SAINDO DO ADATASK APP--");
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }
    public void createTask(Scanner scanner) {
        System.out.println("---------------------------------");
        System.out.println("Digite o título da tarefa pessoal: ");
        String title = scanner.nextLine();

        System.out.println("Digite a descrição da tarefa pessoal: ");
        String description = scanner.nextLine();

        System.out.println("Digite o prazo da tarefa pessoal no formato DD/MM/YYYY ");
        String deadlineInformed = scanner.nextLine();

        DateTimeFormatter deadlineFormatted = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate deadline = LocalDate.parse(deadlineInformed, deadlineFormatted);

        PersonalTask personalTask = new PersonalTask(title, description, deadline);

        personalTask.setTitle(title);
        personalTask.setDescription(description);
        personalTask.setDeadline(deadline);

        taskService.addNewTask(personalTask);
        System.out.println("Tarefa adicionada com sucesso!");
    }


    protected void updateTask(Scanner scanner) {
        System.out.println("Digite o ID da tarefa");
        String id = scanner.nextLine();
        scanner.nextLine();

        BaseTask savedTask = taskService.getTaskById(id);

        if(savedTask instanceof PersonalTask){
            System.out.println("Escolha a opção que deseja atualizar");
            System.out.println("1. Título");
            System.out.println("2. Descripcao");
            System.out.println("3. Deadline");
            System.out.println("4. Status");
            System.out.print("Escolha uma opção: ");


            int userChoice = scanner.nextInt();
            switch (userChoice) {
                case 1:
                    System.out.println("Digite o novo título: ");
                    String newTitle = scanner.nextLine();
                    savedTask.setTitle(newTitle);
                    scanner.nextLine();
                    break;

                case 2:
                    System.out.println("Digite a nova descripção: ");
                    String newDescription = scanner.nextLine();
                    savedTask.setTitle(newDescription);
                    scanner.nextLine();
                    break;
                case 3:
                    System.out.println("Digite o novo prazo: ");
                    String newDeadline = scanner.nextLine();
                    DateTimeFormatter deadlineFormatted = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate newDeadlineDate = LocalDate.parse(newDeadline, deadlineFormatted);
                    savedTask.setDeadline(newDeadlineDate);
                    scanner.nextLine();
                    break;
                case 4:
                    System.out.println("Digite o novo Status: ");
                    scanner.nextLine();
                    String newStatus = String.valueOf(Status.valueOf(scanner.nextLine().toUpperCase()));
                    savedTask.setStatus(Status.valueOf(newStatus.toUpperCase()));
                    break;
                default:
                    System.out.println("Opção inválida");

            }
            taskService.updateTask(savedTask);
        }else {
            System.out.println("Não existe a tarefa!");
        }
    }


    public void deleteTask(Scanner scanner) {
        System.out.println("Digite o ID da tarefa");
        String id = scanner.nextLine();
        scanner.nextLine();

        PersonalTask taskToDelete = (PersonalTask) taskService.getTaskById(id);
        if(taskToDelete == null){
            System.out.println("Tarefa não identificada");
        } else{
            taskService.removeTask(taskToDelete);
            System.out.println("Tarefa removida com sucesso!");
        }
    }


    public List<PersonalTask> listAllTasks(){
        List<BaseTask> allTasks = taskService.getAllTasks();
        List<PersonalTask> personalTasks = allTasks.stream()
                .filter(task -> task instanceof PersonalTask)
                .map(task -> (PersonalTask) task)
                .collect(Collectors.toList());

        printAllTask(personalTasks);
        return personalTasks;
    }
    protected void printAllTask(List<PersonalTask> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("A lista de tarefas pessoais está vazia");

        } else {
            System.out.println("--Lista de tarefas--");
            for (PersonalTask task : tasks) {
                System.out.println("ID: " + task.getRandomID());
                System.out.println("Título: " + task.getTitle());
                System.out.println("Descripção: " + task.getDescription());
                System.out.println("Prazo: " + task.getDeadline());
                System.out.println("Status: " + task.getStatus());
            }
        }
    }
}
