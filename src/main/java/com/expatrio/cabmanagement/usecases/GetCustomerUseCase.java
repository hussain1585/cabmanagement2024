package com.expatrio.cabmanagement.usecases;

import com.expatrio.cabmanagement.dto.customer.*;
import com.expatrio.cabmanagement.exceptions.CarNotFoundException;
import com.expatrio.cabmanagement.exceptions.CustomerNotFoundException;
import com.expatrio.cabmanagement.mappers.CustomerDtoToEntityMapper;
import com.expatrio.cabmanagement.ports.jpa.entity.customer.CustomerEntity;
import com.expatrio.cabmanagement.ports.jpa.repository.customer.CustomerEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GetCustomerUseCase {

    private final CustomerEntityRepository customerEntityRepository;

    private final CustomerDtoToEntityMapper mapper;

    public CustomerEntity getCustomerById(Integer id) {
        return customerEntityRepository.findById(id)
                .orElseThrow(() -> new CarNotFoundException("Customer not found with Id " + id));
    }

    public List<CustomerEntity> getAllCustomers() {
        return customerEntityRepository.findAll();
    }

    public List<CustomerEntity> getCustomersByEmail(String email) {
        return customerEntityRepository.findByEmail(email);
    }

    public CustomerEntity addCustomer(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = mapper.dtoToEntity(customerDTO);
        return customerEntityRepository.save(customerEntity);
    }

    public List<CustomerEntity> addCustomerList(List<CustomerDTO> customers) {
        return customers.stream().map(customerDTO -> addCustomer(customerDTO)).toList();
    }

    public CustomerEntity updateCustomer(CustomerDTO customerDTO) {
        customerEntityRepository.findById(customerDTO.getId())
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with Id " + customerDTO.getId()));
        CustomerEntity updatedCustomerEntity = mapper.dtoToEntity(customerDTO);
        return customerEntityRepository.save(updatedCustomerEntity);
    }

    public void deleteCustomer(int customerId) {
        customerEntityRepository.deleteById(customerId);
    }
}
