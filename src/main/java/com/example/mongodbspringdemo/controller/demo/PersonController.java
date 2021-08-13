package com.example.mongodbspringdemo.controller.demo;

import com.example.mongodbspringdemo.bean.demo.Person;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 最原始方式调用MongoDB的demo-1
 * @author qianyuqi
 * @create 2021-08-12 19:49
 */
@RestController

public class PersonController {

    @Autowired
    MongoTemplate mongoTemplate;

    // 增加数据
    @PostMapping("/insertPerson")
    public ResponseEntity<String> insertPerson(@RequestBody Person person) {
        Person insert = mongoTemplate.insert(person);
        return ResponseEntity.ok("添加成功,添加后的用户id为：" + insert.getId());
    }

    // 修改数据
    @PostMapping("updatePersonByName")
    public ResponseEntity<String> updatePersonByName(String name, Integer age) {
        UpdateResult updateResult = mongoTemplate.updateFirst(Query.query(Criteria.where("name").is(name)),
                Update.update("age", age), Person.class);
        long modifiedCount = updateResult.getModifiedCount();
        return ResponseEntity.ok("修改成功,修改数量：" + modifiedCount);
    }

    // 分页查询
    @GetMapping("/findPersonPage")
    public Object findPersonPage(Integer currentPageNo, Integer pageSize) {
        Query limit = new Query().skip((long) (currentPageNo - 1) * pageSize).limit(pageSize);
        return mongoTemplate.find(limit, Person.class);
    }

    // 查询所有的数据
    @GetMapping("/findAll")
    public Object findAll() {
        return mongoTemplate.findAll(Person.class);
    }

    // 删除数据
    @DeleteMapping("/deletePersonById/{id}")
    public ResponseEntity<String> deletePersonById(@PathVariable("id") String id) {
        Person findAndRemove = mongoTemplate.findAndRemove(Query.query(Criteria.where("id").is(id)), Person.class);
        return ResponseEntity.ok("删除成功,删除的数据为：" + findAndRemove);
    }
}
