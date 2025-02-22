package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.WorkshopRegistration;

public interface WorkshopRegistrationRepository extends JpaRepository<WorkshopRegistration, Long> {
}
