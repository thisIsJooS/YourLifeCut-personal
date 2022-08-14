package youtlifecut.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import youtlifecut.app.domain.Banner;
import youtlifecut.app.domain.Curation;
import youtlifecut.app.repository.BannerRepository;
import youtlifecut.app.repository.CurationRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class HomeService {
    private final BannerRepository bannerRepository;
    private final CurationRepository curationRepository;
    public List<Banner> getBanner(){
        return bannerRepository.findAll();
    }

    public List<Curation> getCuration(){
        return curationRepository.findAll();
    }
}
