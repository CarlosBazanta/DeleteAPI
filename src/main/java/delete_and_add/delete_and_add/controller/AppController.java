package delete_and_add.delete_and_add.controller;

import delete_and_add.delete_and_add.entity.UserEntity;
import delete_and_add.delete_and_add.repository.WorkRepository;
import delete_and_add.delete_and_add.service.ExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")

public class AppController {

    @Autowired
    private WorkRepository workRepository;

    @GetMapping("/work")
    public List<UserEntity> workList(){
        return workRepository.findAll();
    }

    @PostMapping("/work")
    public UserEntity saveUser(@RequestBody UserEntity userEntity){
        return workRepository.save(userEntity);
    }

    @GetMapping("/work/{id}")
    public ResponseEntity<UserEntity> idUser(@PathVariable Long id){
        UserEntity userEntity = workRepository.findById(id)
                .orElseThrow(()-> new ExceptionService("Error Usuario de id:"+id+" no encontrado"));
        return ResponseEntity.ok(userEntity);
    }

    @PutMapping("/work/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable Long id, @RequestBody UserEntity detailsUserEntity){
        UserEntity userEntity = workRepository.findById(id)
                .orElseThrow(()-> new ExceptionService("Error Usuario de id:"+id+" no encontrado"));
        userEntity.setName(detailsUserEntity.getName());
        userEntity.setLastName(detailsUserEntity.getLastName());
        userEntity.setEmail(detailsUserEntity.getEmail());

        UserEntity updateUser = workRepository.save(userEntity);
        return ResponseEntity.ok(updateUser);
    }

    @DeleteMapping("/work/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteUser(@PathVariable Long id){

        UserEntity userEntity = workRepository.findById(id)
                .orElseThrow(()-> new ExceptionService("Error Usuario de id:"+id+" no encontrado"));

        workRepository.delete(userEntity);
        Map<String,Boolean> check = new HashMap<>();
        check.put("Delete",Boolean.TRUE);
        return ResponseEntity.ok(check);

    }

}
