package com.yong.orders.yongorders;

import com.yong.orders.model.Color;
import com.yong.orders.model.Person;
import com.yong.orders.model.Transaction;
import com.yong.orders.model.Widget;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by LiangYong on 2017/8/31.
 */

public class PersonLambdaTest {

    Logger log = LoggerFactory.getLogger(PersonLambdaTest.class);

    @Test
    public void pringPersonTest(){
        System.out.print("start test");
        Assert.assertTrue(true);
        Person p1 = new Person();
        p1.setAge(20);
        p1.setNamue("Liangyong");
        Person p2 = new Person();
        p2.setAge(30);
        p2.setNamue("Tester");
        Person p3 = new Person();
        p3.setAge(40);
        p3.setNamue("ZhangShan");
        List<Person> persons = new ArrayList<>();
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);

        List<Person> people = printPersonsOlderThan(persons, 20);
        Assert.assertEquals(1,people.size());
        Assert.assertEquals(p1,people.get(0));
    }

    public List<Person> printPersonsOlderThan(List<Person> persons,int age){
        List<Person> list = new ArrayList<>();
        for(Person person :persons){
            if(person.getAge()<=age){
                list.add(person);
            }
        }
        return list;
    }

    @Test
    public void streamTrainingTest(){
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(1, 10, Transaction.Type.GEOCERY));
        transactions.add(new Transaction(3, 30, Transaction.Type.GEOCERY));
        transactions.add(new Transaction(6, 60, Transaction.Type.GEOCERY));
        transactions.add(new Transaction(5, 50, Transaction.Type.GEOCERY));
        transactions.add(new Transaction(2, 20, Transaction.Type.A));
        transactions.add(new Transaction(4, 40, Transaction.Type.C));

        // JDK 7 发现type为grocery的所有交易
        List<Transaction> result = new ArrayList<>();
        for(Transaction transaction : transactions){
            if(transaction.getType().equals(Transaction.Type.GEOCERY)){
                result.add(transaction);
            }
        }
        Assert.assertEquals(4,result.size());
        // 集合排序 交易值降序排序
        Collections.sort(result, new Comparator<Transaction>() {
            @Override
            public int compare(Transaction o1, Transaction o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        log.debug(result.toString());
        log.debug("value = {} ",result.get(0).getValue());
        Integer value = result.get(0).getValue();
        Integer i = new Integer(60);
        Assert.assertEquals(value,i);


        //交易id 获取
        List<Integer> ids = new ArrayList<Integer>();
        for(Transaction transaction :result){
            ids.add(transaction.getId());
        }
        log.debug("id = {}",ids);

        List<Integer> collects = transactions.parallelStream()
                .filter(t -> t.getType() == Transaction.Type.GEOCERY)
                .sorted(Comparator.comparing(Transaction::getValue).reversed())
                .map(Transaction::getId)
                .collect(Collectors.toList());
        log.debug("use JDK1.8, get ids = {}",collects);
        Assert.assertEquals(ids,collects);

    }

    @Test
    public void WidgetStreamTest(){
        List<Widget> widgets = new ArrayList<>();
        widgets.add(new Widget(Color.RED, 1));
        widgets.add(new Widget(Color.RED, 2));
        widgets.add(new Widget(Color.BLACK, 3));
        widgets.add(new Widget(Color.BLUE, 4));
        // stream() 获取当前的source, filter 和 mapToInt为intermediate操作, 进行数据筛选和转换,
        // 最后一个sum为terminal操作，对符合条件的全部widget做重量求和
        int sum = widgets.stream()
                .filter(w -> w.getColor() == Color.RED)
                .mapToInt(Widget::getWeight)
//                .mapToInt(w -> w.getWeight()) //  与上面写法同样效果
                .sum();
        Assert.assertEquals(3,sum);
    }

    @Test
    public void MarkStreamTest(){
        // 1. Individual values 单独值
        Stream stream = Stream.of("a1", "b1", "c1");
        stream.forEach(System.out::print);//打印 a1b1c1
        System.out.println("");
        // 2. Arrays 数组
        String[] strArray = new String[] {"a2", "b2", "c2"};
        stream = Stream.of(strArray);
        stream.forEach(System.out::print);
        System.out.println("");
        stream = Arrays.stream(strArray);
//        System.out.println(stream.collect(Collectors.joining(",")).toString());//打印 a2,b2,c2

        // 3. Collections 集合
        List<String> list = Arrays.asList(strArray);
        stream = list.stream();

    }
}
