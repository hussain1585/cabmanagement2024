package com.expatrio.cabmanagement.api;

import com.expatrio.cabmanagement.dto.customer.*;
import com.expatrio.cabmanagement.mappers.CustomerToCustomerEntityMapper;
import com.expatrio.cabmanagement.ports.jpa.entity.CustomerEntity;
import com.expatrio.cabmanagement.usecases.GetCustomerUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/customer")
public class CustomerController {

    private final GetCustomerUseCase getCustomerUseCase;

    private final CustomerToCustomerEntityMapper mapper;

    @GetMapping("/getCustomerById")
    public GetCustomerByIdResponse gerCustomerById(@RequestParam int id) {
        CustomerEntity customerEntity = getCustomerUseCase.getCustomerById(id);
        CustomerDTO customerDTO = mapper.customerEntityToCustomerDTO(customerEntity);
        return GetCustomerByIdResponse.builder().customerDTO(customerDTO).build();
    }

    @GetMapping("/getAllCustomers")
    public GetAllCustomerResponse getAllCustomers() {
        List<CustomerEntity> customerEntityList = getCustomerUseCase.getAllCustomers();
        List<CustomerDTO> customerDTOList = mapper.customerEntityListToCustomerDTOList(customerEntityList);
        return GetAllCustomerResponse.builder().customerDTOList(customerDTOList).build();
    }

    @PostMapping("/addCustomer")
    public AddCustomerResponse addCustomer(@RequestBody AddCustomerRequest addCustomerRequest) {
        CustomerEntity customerEntity = getCustomerUseCase.addCustomer(addCustomerRequest.getCustomerDTO());
        CustomerDTO customerDTO = mapper.customerEntityToCustomerDTO(customerEntity);
        return AddCustomerResponse.builder().customerDTO(customerDTO).build();
    }

    @PostMapping("/addCustomers")
    public AddCustomersResponse addCustomerList(@RequestBody AddCustomersRequest addCustomersRequest) {
        List<CustomerEntity> customerEntityList = getCustomerUseCase.addCustomerList(addCustomersRequest.getCustomers());
        List<CustomerDTO> customers = mapper.customerEntityListToCustomerDTOList(customerEntityList);
        return AddCustomersResponse.builder().customers(customers).build();
    }

    @PutMapping("/updateCustomer")
    public UpdateCustomerResponse updateCustomer(@RequestBody UpdateCustomerRequest updateCustomerRequest) {
        CustomerEntity customerEntity = getCustomerUseCase.updateCustomer(updateCustomerRequest.getCustomerDTO());
        CustomerDTO customerDTO = mapper.customerEntityToCustomerDTO(customerEntity);
        return UpdateCustomerResponse.builder().customerDTO(customerDTO).build();
    }

    @DeleteMapping("/deleteCustomer")
    public void deleteCustomer(@RequestParam int customerId) {
        getCustomerUseCase.deleteCustomer(customerId);
    }
}
