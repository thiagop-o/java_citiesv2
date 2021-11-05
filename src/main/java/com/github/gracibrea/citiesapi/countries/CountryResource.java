package com.github.gracibrea.citiesapi.countries;

import com.github.gracibrea.citiesapi.countries.repository.CountryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountryResource {

    //@Autowired
    private CountryRepository repository;

    //Com construtor
    public CountryResource(CountryRepository repository) {
        this.repository = repository;
    }

    @GetMapping
//    public List<Country> countries() {
//        return repository.findAll();
//    }
    public Page<Country> countries(Pageable page) {
        return repository.findAll(page);
    }

    @GetMapping("/{id}")
    public Optional<Country> getOne(@PathVariable Long id) {
        Optional<Country> optional = repository.findById(id);
        return Optional.of(optional.get());
    }

//    public ResponseEntity getOne(@PathVariable Long id) {
//        Optional<Country> optional = repository.findById(id);
//
//        if (optional.isPresent()) {
//            return ResponseEntity.ok().body(optional.get());
//        } else {
//        return ResponseEntity.notFound().build();
//        }
//    Com este trecho ativo dá o erro "reached end of file while parsing"
}
