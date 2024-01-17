package com.puraskar.website.Puraskaar.Data.Management.repository;

import com.puraskar.website.Puraskaar.Data.Management.entity.RegistrationForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationFormRepository extends JpaRepository <RegistrationForm, String> {
}