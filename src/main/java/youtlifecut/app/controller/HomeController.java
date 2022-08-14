package youtlifecut.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import youtlifecut.app.domain.Banner;
import youtlifecut.app.domain.Curation;
import youtlifecut.app.domain.Image;
import youtlifecut.app.dto.CurationDto;
import youtlifecut.app.service.HomeService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {
    private final HomeService homeService;

    @GetMapping("/banner")
    public List<Banner> getBanner(){
        return homeService.getBanner();
    }

    @GetMapping("/curation")
    public List<CurationDto> getCuration(){
        return homeService.getCuration();
    }

    @GetMapping("/search")
    public void h(){}
}
