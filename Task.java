import java.time.LocalDateTime;
import java.util.UUID;

public class Task {
    private final String id;
    private String descricao;
    private Status status;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public Task(String descricao) {

        this.id = UUID.randomUUID().toString();
        this.descricao = descricao;
        this.status = Status.PENDENTE;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();

    }

    public Status getStatus() {
        return status;
    }
    public String getId() {
        return id;
    }
    public String getDescricao() {
        return descricao;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


}