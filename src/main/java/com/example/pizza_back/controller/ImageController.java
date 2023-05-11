package com.example.pizza_back.controller;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.UrlResource;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * The type Image controller.
 */
@RestController
public class ImageController {
    /**
     * Serve existing pizza image response entity.
     *
     * @param filename the filename
     * @return the response entity
     */
    @GetMapping("/ServExistingPizzaImage/{filename:.+}")
    public ResponseEntity<Resource> serveExistingPizzaImage(@PathVariable String filename) {

        Path path = Paths.get("assets/img/pizzas/" + filename);
        Resource resource = null;
        try {
            resource = new UrlResource(path.toUri());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok().body(resource);
    }
}
