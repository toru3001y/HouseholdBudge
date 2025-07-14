package com.example.householdbudget.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.householdbudget.model.entity.TransactionEntity;
import com.example.householdbudget.repository.TransactionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class TransactionService {

    private final TransactionRepository repository;
    /**
     * 登録されている全ての取引履歴を取得する。
     * @return
     */
    public List<TransactionEntity> search() {
        var list = repository.select();
        return list;
    }
}
