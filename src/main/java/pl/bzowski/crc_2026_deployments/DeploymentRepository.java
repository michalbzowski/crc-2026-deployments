package pl.bzowski.crc_2026_deployments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface DeploymentRepository extends JpaRepository<Deployment, Long> {
    List<Deployment> findByHostname(String hostname);
    Optional<Deployment> findFirstByHostnameOrderByCreatedAtDesc(String hostname);
    List<Deployment> findAllByOrderByCreatedAtDesc();
}

