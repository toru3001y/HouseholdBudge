package com.example.householdbudget.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.householdbudget.model.entity.TransactionEntity;

@Mapper
public interface TransactionRepository {

    /**
     * 登録されている全ての取引履歴を取得する。
     * @return
     */
    List<TransactionEntity> select();
}
