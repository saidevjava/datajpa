package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Accounts;

public interface AccountsRepo extends JpaRepository<Accounts, Integer>{

}
