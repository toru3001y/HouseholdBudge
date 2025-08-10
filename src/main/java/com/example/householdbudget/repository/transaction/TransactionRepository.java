package com.example.householdbudget.repository.transaction;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.householdbudget.model.entity.transaction.TransactionEntity;
import com.example.householdbudget.model.entity.transaction.TransactionSummaryEntity;

@Mapper
public interface TransactionRepository {

    TransactionSummaryEntity summary();

    /**
     * 登録されている全ての取引履歴を取得する。
     * @return
     */
    List<TransactionEntity> select();

    /**
     * 指定されたIDの取引履歴を取得する。
     * @param id
     * @return
     */
    Optional<TransactionEntity> selectById(@Param("id") long id);

    /**
     * 
     * @param newEntity
     */
    void insert(@Param("transaction") TransactionEntity newEntity);

    /**
     * 
     * @param updateEntity
     */
    void update(@Param("transaction") TransactionEntity updateEntity);

    /**
     * 
     * @param id
     */
    void delete(@Param("id") long id);
}
