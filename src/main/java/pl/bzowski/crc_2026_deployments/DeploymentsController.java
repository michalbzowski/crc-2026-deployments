package pl.bzowski.crc_2026_deployments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DeploymentsController {

    @Autowired
    private DeploymentRepository deploymentRepository;

    @GetMapping("/deployments")
    public List<Deployment> getAllDeployments() {
        System.out.println("✓ GET /deployments called");
        return deploymentRepository.findAll();
    }

    @GetMapping("/deployments/{id}")
    public Map<String, String> getDeploymentById(@PathVariable Long id) {
        System.out.println("✓ GET /deployments/" + id + " called");
        Map<String, String> response = new HashMap<>();
        response.put("message", "Get deployment by ID: " + id);
        response.put("id", String.valueOf(id));
        return response;
    }

    @GetMapping("/deployments/hostname/{hostname}")
    public Map<String, Object> getDeploymentsByHostname(@PathVariable String hostname) {
        System.out.println("✓ GET /deployments/hostname/" + hostname + " called");
        Map<String, Object> response = new HashMap<>();
        response.put("hostname", hostname);
        response.put("message", "Get deployments by hostname: " + hostname);
        response.put("deployments", List.of());
        return response;
    }

    @GetMapping("/deployments/latest/{hostname}")
    public Map<String, Object> getLatestDeploymentByHostname(@PathVariable String hostname) {
        System.out.println("✓ GET /deployments/latest/" + hostname + " called");
        Map<String, Object> response = new HashMap<>();
        response.put("hostname", hostname);
        response.put("message", "Get latest deployment by hostname: " + hostname);
        return response;
    }
}

