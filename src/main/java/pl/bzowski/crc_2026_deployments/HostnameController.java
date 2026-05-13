package pl.bzowski.crc_2026_deployments;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.jar.Manifest;
import java.io.InputStream;

@RestController
public class HostnameController {

    private static final String BUILD_TIMESTAMP = loadBuildTimestamp();

    private static String loadBuildTimestamp() {
        try {
            Class<?> clazz = HostnameController.class;
            String resource = "/" + clazz.getName().replace(".", "/") + ".class";
            InputStream inputStream = clazz.getResourceAsStream(resource);
            if (inputStream != null) {
                inputStream.close();
            }

            InputStream manifestStream = clazz.getClassLoader()
                    .getResourceAsStream("META-INF/MANIFEST.MF");
            if (manifestStream != null) {
                Manifest manifest = new Manifest(manifestStream);
                String timestamp = manifest.getMainAttributes().getValue("Build-Timestamp");
                manifestStream.close();
                return timestamp != null ? timestamp : "unknown";
            }
        } catch (Exception e) {
            // Fallback if MANIFEST.MF cannot be read
        }
        return "unknown";
    }

    @GetMapping("/")
    public HostnameResponse getHostname() throws UnknownHostException {
        String hostname = InetAddress.getLocalHost().getHostName();
        return new HostnameResponse(hostname, BUILD_TIMESTAMP);
    }

    public static class HostnameResponse {
        private final String hostname;
        private final String version;

        public HostnameResponse(String hostname, String version) {
            this.hostname = hostname;
            this.version = version;
        }

        public String getHostname() {
            return hostname;
        }

        public String getVersion() {
            return version;
        }
    }
}

