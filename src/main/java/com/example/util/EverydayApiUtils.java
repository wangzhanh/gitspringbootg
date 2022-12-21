package com.example.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.TypeReference;
import com.example.test.entity.Node;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author wangzhanhui
 * @version 1.0
 * @date 2022/11/27 16:43
 * @desc 常用API
 */
public class EverydayApiUtils {

    public static void test() {
        //Lists API(com.google.common.collect.Lists)
        ArrayList<Object> list = Lists.newArrayListWithCapacity(8);
        //集合判空API(org.apache.commons.collections4.CollectionUtils)
        CollectionUtils.isNotEmpty(list);
        //map
        HashMap<Object, Object> objectHashMap = Maps.newHashMap();

        //对象判空(java.util.Objects)
        Objects.isNull(new Object());

        //字符串判空API(org.apache.commons.lang3.StringUtils)
        StringUtils.isNotBlank("test");
        //多参判空
        StringUtils.isAnyBlank("test", "");

        //linkedHashSet集合去重
        LinkedHashSet<Object> hashSet = new LinkedHashSet<>(list);
        ArrayList<Object> listWithoutDuplicates = new ArrayList<>(hashSet);

        //提取对象集合中某个字段集合并去重
        List<Node> nodes = Lists.newArrayList();
        List<Long> idList = nodes.stream().map(Node::getId).distinct().collect(Collectors.toList());

        //根据多个字段去重复
        ArrayList<Node> collect = nodes.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(o -> o.getId() + o.getName()))), ArrayList::new));

        //集合转map key:name. Value:id  有相同key取k1(去重)
        Map<String, Long> nameMap = nodes.stream().collect(Collectors.toMap(Node::getName,Node::getId, (k1,k2) -> k1));
        //key:name value: Obj
        Map<String, Node> nodeMap = nodes.stream().collect(Collectors.toMap(Node::getName, Function.identity()));
        //排序
        TreeMap<Long, String> collect1 = nodes.stream().collect(Collectors.toMap(Node::getId, Node::getName, (n1, n2) -> n1, TreeMap::new));

        //LIst allMatch anyMatch使用
        boolean result = list.stream().allMatch(e -> {
            boolean isMeet = false;
            if (e.toString().equals("test")) {
                isMeet = true;
            }
            return isMeet;
        });

        //500一批分批
        List<List<Long>> mobileSubList = Lists.partition(idList, 500);


        //CollectionUtils API封装取代List原有API
        List<String> listA = Lists.newArrayList();
        List<String> listB = Lists.newArrayList();
        //并集
        Collection<String> union = CollectionUtils.union(listA, listB);
        //交集
        Collection<String> intersection = CollectionUtils.intersection(listA, listB);
        //交集的补集
        Collection<String> disjunction = CollectionUtils.disjunction(listA, listB);
        //差集(集合相减)
        Collection<String> subtract = CollectionUtils.subtract(listA, listB);

        //转为自定义任意泛型(com.alibaba.fastjson.JSON)
        String rule = JSON.toJSONString("[{\"1\":[\"1\",\"2\"]},{\"7\":[\"福建省\",\"泰安市\"]}]");
        List<Map<Integer, List<String>>> ruleMap = JSON.parseObject(rule, new TypeReference<List<Map<Integer, List<String>>>>() {} );

        //集合转换
        List<Node> lists= JSONArray.parseArray("").toJavaList(Node.class);

        //map集合value和
        nameMap.values().stream().mapToInt(Long::intValue).sum();

        //集合中第一个值返回
        Object test = list.stream().filter(e -> e.toString().equals("test")).findFirst().orElse(null);

        //日期API (org.joda.time.DateTime)不能拉取三天之前的消息
        Date timeLimit = new Date();
        if(timeLimit.before(DateTime.now().minusDays(3).toDate())){
            timeLimit = DateTime.now().minusDays(3).toDate();
        }
        //验证身份证号,转换不成证明不合验
        try{
            timeLimit.getTime();
        }catch (Exception e){
            //身份证号不正确
        }
        //实体bean copy
        Node currentNode = new Node(1L, "a");
        Node will = new Node();
        BeanUtils.copyProperties(currentNode, will);
    }

}
