package com.yong.orders.config;

import com.yong.orders.constant.PathConstant;
import com.yong.orders.dao.UserDao;
import com.yong.orders.model.Address;
import com.yong.orders.model.DepartmentGroup;
import com.yong.orders.model.User;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.separator.DefaultRecordSeparatorPolicy;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Created by yong.a.liang on 8/8/2017.
 *
 */
//@Component
public class UserInitializer {

    private static final Logger log = LoggerFactory.getLogger(UserInitializer.class);

    @Autowired
    public UserInitializer(UserDao userDao, MongoOperations operations) throws Exception{
        long count = userDao.count();
        log.info("User Repository count {} ",count);
        if(count != 0){
            return;
        }
        log.info("start init User Repository ...");
        List<User> users = readUsers();

        log.info("users count = {}",users.size());
        userDao.save(users);

    }

    public static List<User> readUsers() throws Exception {

        ClassPathResource resource = new ClassPathResource(PathConstant.INIT_USER_SCRIPT);
        Scanner scanner = new Scanner(resource.getInputStream());
        String line = scanner.nextLine();
        scanner.close();

        FlatFileItemReader<User> itemReader = new FlatFileItemReader<User>();
        itemReader.setResource(resource);

//        DelimitedLineTokenizer defaults to comma as its delimiter
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setNames(line.split(","));
        tokenizer.setStrict(false);

        DefaultLineMapper<User> lineMapper = new DefaultLineMapper<User>();
        lineMapper.setLineTokenizer(tokenizer);
        lineMapper.setFieldSetMapper(UserFieldSetMapper.INSTANCE);
        itemReader.setLineMapper(lineMapper);
        itemReader.setRecordSeparatorPolicy(new DefaultRecordSeparatorPolicy());
        itemReader.setLinesToSkip(1);
        itemReader.open(new ExecutionContext());

        List<User> stores = new ArrayList<>();
        User store = null;

        do {

            store = itemReader.read();

            if (store != null) {
                stores.add(store);
            }

        } while (store != null);

        return stores;
    }

    private static enum UserFieldSetMapper implements FieldSetMapper<User>{

        INSTANCE;

        /*
         * (non-Javadoc)
         * @see org.springframework.batch.item.file.mapping.FieldSetMapper#mapFieldSet(org.springframework.batch.item.file.transform.FieldSet)
         */
        @Override
        public User mapFieldSet(FieldSet fieldSet) throws BindException {
//            log.info("fieldSet = {}",fieldSet.toString());
//            log.info("id = {}",fieldSet.readString("Number"));
//            try {
//                Address address = new Address(fieldSet.readString("Add"), fieldSet.readString("Location"), fieldSet.readString("Country"));
//                List<DepartmentGroup> list = new ArrayList<>();
//                User user = new User();
//                user.setId(fieldSet.readString("Number"));
//                user.setName(fieldSet.readString("Name"));
//                user.setAge(fieldSet.readInt("Age"));
//                user.setAddress(address);
//                user.setCreatedDate(fieldSet.readDate("CreatedDate", "yyyy-MM-dd"));
//                user.setLastModifiedDate(fieldSet.readDate("LastModifiedDate"));
//                user.setCreatedBy(fieldSet.readString("CreatedBy"));
//                user.setLastModifiedBy(fieldSet.readString("LastModifiedBy"));
//                user.setActive(fieldSet.readBoolean("IsActive"));
//                return user;
//            }catch (Exception ex){
//                log.error("readUser failed, {}",ex);
//                return null;
            return null;
            }
        }
    }







