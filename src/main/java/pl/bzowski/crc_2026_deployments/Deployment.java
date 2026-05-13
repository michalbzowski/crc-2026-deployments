package pl.bzowski.crc_2026_deployments;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "deployments")
public class Deployment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hostname", nullable = false)
    private String hostname;

    @Column(name = "version", nullable = false)
    private String version;

    @Column(name = "deployment_time")
    private LocalDateTime deploymentTime;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Deployment() {
    }

    public Deployment(String hostname, String version) {
        this.hostname = hostname;
        this.version = version;
        this.deploymentTime = LocalDateTime.now();
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public LocalDateTime getDeploymentTime() {
        return deploymentTime;
    }

    public void setDeploymentTime(LocalDateTime deploymentTime) {
        this.deploymentTime = deploymentTime;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Deployment{" +
                "id=" + id +
                ", hostname='" + hostname + '\'' +
                ", version='" + version + '\'' +
                ", deploymentTime=" + deploymentTime +
                ", createdAt=" + createdAt +
                '}';
    }
}

