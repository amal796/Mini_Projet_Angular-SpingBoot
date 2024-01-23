package com.example.premierprojettest.Controller;

import com.example.premierprojettest.Service.UniversiteService;
import com.example.premierprojettest.model.Bloc;
import com.example.premierprojettest.model.Universite;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.itextpdf.text.Document;

import java.io.IOException;
import java.util.List;

//@Tag(name = "Gestion Universite")
@RestController
@AllArgsConstructor
@RequestMapping("/Universite")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UniversiteController {
    @Autowired
    private final UniversiteService universiteService;

    @GetMapping("/retrieve-all-Universites")
    public List<Universite> getUniversites() {
        List<Universite> listUniversites = universiteService.getUniversite();
        return listUniversites;
    }

    @PostMapping("/add-Universite")
    public Universite addUniversite(@RequestBody Universite universite) {
        Universite newUniversite = universiteService.addUniversite(universite);
        return newUniversite;
    }

    @DeleteMapping("/remove-Universite/{Universite-id}")
    public void removeUniversite(@PathVariable("Universite-id") Long universiteId) {
        universiteService.deleteUniversite(universiteId);
    }

    @PutMapping("/modify-Universite")
    public Universite modifyUniversite(@RequestBody Universite universite) {
        Universite updatedUniversite = universiteService.updateUniversite(universite);
        return updatedUniversite;
    }

    @GetMapping("/getUniversiteById/{id}")
    public Universite getUniversiteById(@PathVariable Long id) {
        return universiteService.getUniversiteById(id);
    }

    @GetMapping("/pdf")
    public void exportUniversitesPdf(HttpServletResponse response) throws IOException, DocumentException {
        // Set the content type and attachment header
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"universites.pdf\"");

        // Create a new document
        Document document = new Document();

        // Create a PDF writer to write the document to the response's output stream
        PdfWriter.getInstance(document, response.getOutputStream());

        // Open the document
        document.open();

        // Fetch the list of universities from the service
        List<Universite> universites = universiteService.getUniversite();

        // Add content to the document
        for (Universite universite : universites) {
            document.add(new Paragraph("Nom: " + universite.getNomUniversite()));
            document.add(new Paragraph("Adresse: " + universite.getAdresse()));
            document.add(new Paragraph(" "));
        }

        // Close the document
        document.close();
    }

    @GetMapping("/search/by-nom/{nom}")
    public List<Universite> searchByNom(@PathVariable String nom) {
        return universiteService.searchUniversites(nom);
    }

    @GetMapping("/retrieve-all-Universites/par-adresse")
    public List<Universite> getUniversitesTrieesParAdresse() {
        return universiteService.getUniversitesTrieesParAdresse();
    }

    @GetMapping("/retrieve-all-Universites/par-nom")
    public List<Universite> getUniversitesTrieesParNom() {
        return universiteService.getUniversitesTrieesParNom();
    }
}