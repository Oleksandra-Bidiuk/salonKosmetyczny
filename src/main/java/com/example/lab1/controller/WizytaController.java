package com.example.lab1.controller;

import com.example.lab1.domain.wizyta;
import com.example.lab1.formatter.AdresFormatter;
import com.example.lab1.validation.WizytaValidator;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
public class WizytaController {

    @InitBinder("wizyta")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(new WizytaValidator());
        binder.addCustomFormatter(new AdresFormatter());
        binder.setDisallowedFields("id");
    }

    // Wyświetlanie listy wizyt
    @GetMapping("/wizyty")
    public String pokazWizyty(Model model) {
        model.addAttribute("wizyty", DatabaseDump.getAllWizyty());
        return "wizyty";
    }

    // Formularz dodawania nowej wizyty
    @GetMapping("/formularz")
    public String pokazFormularz(Model model) {
        model.addAttribute("wizyta", new wizyta());
        return "formularz";
    }

    // Zapis nowej wizyty
    @PostMapping("/formularz")
    public String zatwierdzFormularz(@Valid @ModelAttribute("wizyta") wizyta wizyta, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "formularz";
        }
        DatabaseDump.save(wizyta);
        return "redirect:/wizyty";
    }

    // Szczegóły wizyty
    @GetMapping("/wizyty/szczegoly/{id}")
    public String pokazSzczegoly(@PathVariable("id") Long id, Model model) {
        wizyta wizyta = DatabaseDump.findById(id);
        if (wizyta == null) {
            return "redirect:/wizyty";
        }
        model.addAttribute("wizyta", wizyta);
        return "szczegoly";
    }

    // Formularz edycji wizyty
    @GetMapping("/wizyty/edytuj/{id}")
    public String pokazFormularzEdycji(@PathVariable("id") Long id, Model model) {
        wizyta wizyta = DatabaseDump.findById(id);
        if (wizyta == null) {
            return "redirect:/wizyty";
        }
        model.addAttribute("wizyta", wizyta);
        return "edycja";
    }

    // Zapis zedytowanej wizyty
    @PostMapping("/wizyty/edytuj/{id}")
    public String zaktualizujWizyte(@PathVariable("id") Long id, @Valid @ModelAttribute("wizyta") wizyta wizyta, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edycja";
        }
        wizyta.setId(id); // upewniamy się, że ID pozostaje bez zmian
        DatabaseDump.save(wizyta);
        return "redirect:/wizyty";
    }

    // Usuwanie wizyty
    @PostMapping("/wizyty/usun/{id}")
    public String usunWizyte(@PathVariable("id") Long id) {
        DatabaseDump.deleteById(id);
        return "redirect:/wizyty";
    }
}