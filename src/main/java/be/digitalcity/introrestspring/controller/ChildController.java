package be.digitalcity.introrestspring.controller;

import be.digitalcity.introrestspring.mapper.ChildMapper;
import be.digitalcity.introrestspring.model.dto.ChildDTO;
import be.digitalcity.introrestspring.model.entities.Child;
import be.digitalcity.introrestspring.services.ChildService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/child")
public class ChildController {
    private final ChildService childService;
    private final ChildMapper childMapper;

    public ChildController(ChildService childService, ChildMapper childMapper) {
        this.childService = childService;
        this.childMapper = childMapper;
    }

    @GetMapping("/{id}")
    public Child getOne(@PathVariable long id){
        return childService.getOne(id);
    }

    @GetMapping("/all")
    public List<ChildDTO> getAll(){
        return childService.getAll().stream().map(childMapper::toChildDTO).collect(Collectors.toList());
    }

    @PostMapping("/insert")
    public ChildDTO insert(@RequestBody Child child){
        childService.insert(child);
        return childMapper.toChildDTO(child);
    }

    @PutMapping("/update")
    public ChildDTO update(@RequestBody ChildDTO childDTO){
        childService.save(childMapper.toChilEntity(childDTO));
        return childDTO;
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestParam Long id){
        return childService.delete(id);
    }
}
