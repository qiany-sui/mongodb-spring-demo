package com.example.mongodbspringdemo.controller.demo;

import com.example.mongodbspringdemo.bean.demo.PersonJpa;
import com.example.mongodbspringdemo.dao.PersonJpaDao;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.query.UntypedExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * 使用JPA方式调用MongoDB的demo-2
 * @author qianyuqi
 * @create 2021-08-13 09:38
 */
@RestController
@RequestMapping("jpa")
public class PersonJpaController {
    @Resource
    private PersonJpaDao personJpaDao;

    // 增加数据
    @PostMapping("/insertPerson")
    public ResponseEntity<String> insertPerson(@RequestBody PersonJpa personJpa) {
        PersonJpa save = personJpaDao.save(personJpa);
        return ResponseEntity.ok("添加成功,添加后的用户id为：" + save.getId());
    }

    // 修改数据
    @PostMapping("updatePersonByName")
    public ResponseEntity<String> updatePersonByName(@RequestBody PersonJpa personJpa) {
        Example<PersonJpa> of = Example.of(personJpa, UntypedExampleMatcher.matchingAny());
        Optional<PersonJpa> findOne = personJpaDao.findOne(of);
        PersonJpa findByName = personJpaDao.findByName(personJpa.getName());// 使用这个方式也可以实现
        PersonJpa update = findOne.get();
        if (update != null) {
            update.setAge(personJpa.getAge());
            update.setName(personJpa.getName());
            personJpaDao.save(update);
            return ResponseEntity.ok("修改成功,修改数量：1");
        }
        return ResponseEntity.ok("修改失败,当前的 【" + personJpa.getName() + "】 不存在！");

    }

    // 删除数据
    @DeleteMapping("/deletePersonById/{id}")
    public ResponseEntity<String> deletePersonById(@PathVariable("id") String id) {
        Optional<PersonJpa> findById = personJpaDao.findById(id);
        PersonJpa personJpa = findById.get();
        if (personJpa != null) {
            personJpaDao.delete(personJpa);
            /* personJpaDao.deleteAll(entities); */
            return ResponseEntity.ok("删除成功,删除的数据为：" + personJpa);
        }

        return ResponseEntity.ok("删除成功,当前需要删除的id不存在：" + id);
    }

    // 分页查询
    @GetMapping("/findPersonPage")
    public Object findPersonPage(Integer currentPageNo, Integer pageSize) {
        /* ExampleMatcher matcher=new */
        return personJpaDao.findAll(PageRequest.of(currentPageNo - 1, pageSize));
    }

    // 查询所有的数据
    @GetMapping("/findAll")
    public Object findAll() {
        return personJpaDao.findAll();
    }

}
