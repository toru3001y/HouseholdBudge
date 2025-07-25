package com.example.householdbudget.service.transaction;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.householdbudget.model.entity.transaction.TransactionEntity;
import com.example.householdbudget.model.entity.transaction.TransactionSummaryEntity;
import com.example.householdbudget.repository.transaction.TransactionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class TransactionService {

    private final TransactionRepository repository;

    /**
     * 財務サマリーを取得する。
     * @return
     */
    public TransactionSummaryEntity getFinancialSummary() {
        return repository.summary();
    }

    /**
     * 登録されている全ての取引履歴を取得する。
     * @return
     */
    public List<TransactionEntity> search() {
        return repository.select();
    }

    public Optional<TransactionEntity> findById(long id) {
        return repository.selectById(id);
    }

    public void create(TransactionEntity newEntity) {
        repository.insert(newEntity);
    }

    public void update(TransactionEntity updateEntity) {
        repository.update(updateEntity);
    }

    public void delete(long id) {
        repository.delete(id);
    }
}
