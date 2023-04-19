package by.kuchinskiy.speczmachine.controller;

import by.kuchinskiy.speczmachine.entity.Images;
import by.kuchinskiy.speczmachine.service.ImagesService;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/images")
@RequiredArgsConstructor
@Slf4j
public class ImageController {
        private final ImagesService imagesService;

        @GetMapping(value = "{id}")
        public void showImage(@PathVariable Long id, HttpServletResponse response) throws IOException {
            Images images = imagesService.findFirstForMachine(id);
            response.setContentType("image/jpeg,image/png,image/jpg");
            response.getOutputStream().write(images.getImage());
            response.getOutputStream().close();
        }

        @GetMapping(value = "sneaker-img/{id}")
        public void showAllImageForSneakers(@PathVariable Long id, HttpServletResponse response) throws IOException {
            response.setContentType("image/jpeg,image/png,image/jpg");

            response.getOutputStream().write(imagesService.findById(id).getImage());
            response.getOutputStream().close();
        }


}
