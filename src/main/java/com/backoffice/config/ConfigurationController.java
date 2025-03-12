package com.backoffice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class ConfigurationController {

    @Autowired
    private ConfigurationService configurationService;

    @GetMapping("/config")
    public ModelAndView prepare (){
        ModelAndView modelAndView = new ModelAndView("configuration");
        Configuration configuration = configurationService.findById("CFGE00001");

        modelAndView.addObject("configuration", configuration);
        return modelAndView;
    }

    @PostMapping("/config")
    public String execute(@RequestParam("id") String id,
                          @RequestParam("age") int age,
                          @RequestParam("pourcentage") double pourcentage,
                          RedirectAttributes redirectAttributes) {
        try {
            Configuration configuration = new Configuration();
            configuration.setId(id);
            configuration.setAge(age);
            configuration.setPourcentage_prix(pourcentage);

            configurationService.save(configuration);

            redirectAttributes.addFlashAttribute("success", "Configuration mise à jour avec succès !");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/admin/config";
    }
}
