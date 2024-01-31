package br.com.adatask.Controller;

import br.com.adatask.Domain.BaseTask;
import br.com.adatask.Domain.Enums.Status;
import br.com.adatask.Domain.PersonalTask;
import br.com.adatask.Domain.StudyTask;
import br.com.adatask.Service.TaskService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StudyTaskController implements UserInterface{

    private TaskService taskService;

    public StudyTaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public void start(Scanner scanner){
        System.out.println("---------------------------");
        System.out.println("-----Tarefas de Estudo-----");
        System.out.println("---------------------------");
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
        System.out.println("Digite o título da tarefa de estudos: ");
        String title = scanner.nextLine();

        System.out.println("Digite a descrição da tarefa de estudos: ");
        String description = scanner.nextLine();

        System.out.println("Digite o prazo da tarefa de estudos no formato DD/MM/YYYY ");
        String deadlineInformed = scanner.nextLine();

        DateTimeFormatter deadlineFormatted = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate deadline = LocalDate.parse(deadlineInformed, deadlineFormatted);

        StudyTask studyTask = new StudyTask(title, description, deadline);

        studyTask.setTitle(title);
        studyTask.setDescription(description);
        studyTask.setDeadline(deadline);

        taskService.addNewTask(studyTask);
        System.out.println("Tarefa adicionada com sucesso!");
    }

    protected void updateTask(Scanner scanner) {
        System.out.println("Digite o ID da tarefa");
        String id = scanner.nextLine();
        scanner.nextLine();

        BaseTask savedTask = taskService.getTaskById(id);

        if(savedTask instanceof StudyTask){
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

        StudyTask taskToDelete = (StudyTask) taskService.getTaskById(id);
        if(taskToDelete == null){
            System.out.println("Tarefa não identificada");
        } else{
            taskService.removeTask(taskToDelete);
            System.out.println("Tarefa removida com sucesso!");
        }
    }

    public List<StudyTask> listAllTasks(){
        List<BaseTask> allTasks = taskService.getAllTasks();
        List<StudyTask> studyTasks = allTasks.stream()
                .filter(task -> task instanceof StudyTask)
                .map(task -> (StudyTask) task)
                .collect(Collectors.toList());

        printAllTask(studyTasks);
        return studyTasks;
    }

    protected void printAllTask(List<StudyTask> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("A lista de tarefas pessoais está vazia");

        } else {
            System.out.println("--Lista de tarefas de estudo--");
            for (StudyTask task : tasks) {
                System.out.println("ID: " + task.getRandomID());
                System.out.println("Título: " + task.getTitle());
                System.out.println("Descripção: " + task.getDescription());
                System.out.println("Prazo: " + task.getDeadline());
                System.out.println("Status: " + task.getStatus());
            }
        }
    }

}
