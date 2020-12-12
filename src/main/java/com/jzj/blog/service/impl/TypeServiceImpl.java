package com.jzj.blog.service.impl;

import com.jzj.blog.NotFoundException;
import com.jzj.blog.dao.TypeRepository;
import com.jzj.blog.po.Type;
import com.jzj.blog.service.TypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository typeRepository;

    @Transactional
    @Override
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    @Transactional
    @Override
    public Type getType(Long id) {
        return typeRepository.findById(id).get();
    }

    @Transactional
    @Override
    public Page<Type> listType(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    @Override
    public List<Type> listType() {
        return typeRepository.findAll();
    }

    @Override
    public List<Type> listTypeTop(Integer size) {

        Sort sort = Sort.by(Sort.Direction.DESC,"blogs.size");
        Pageable pageable = PageRequest.of(0,size,sort);
        return typeRepository.findTop(pageable);
    }

    @Transactional
    @Override
    public Type updateType(Long id, Type type) {
//        Optional<Type> t = typeRepository.findById(id);
//        if(!t.isPresent()){
//            throw new NotFoundException("不存在该类型");
//        }
//        BeanUtils.copyProperties(type,t.get());
//        return typeRepository.save(t.get());

//        Type t = typeRepository.findById(id).get();
//        Assert.notNull(t,"空");
//        BeanUtils.copyProperties(type,t);
//        return typeRepository.save(t);
        Optional<Type> t = typeRepository.findById(id);
        t.orElseThrow(() -> new NotFoundException("错误"));
        BeanUtils.copyProperties(type, t.get());
        return typeRepository.save(t.get());

    }

    @Override
    public Type getTypeByName(String name) {
        return typeRepository.findByName(name);
    }

    @Transactional
    @Override
    public void deleteType(Long id) {
        typeRepository.deleteById(id);
    }
}
