package com.example.addressbook.controller;

import com.example.addressbook.model.AddressBook;
import com.example.addressbook.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/AddressBookApp")
public class AddressBookController {
    @Autowired
    AddressBookRepository repository;

    //Print welcome message

    @GetMapping("")
    public String getMessage() {
        return "Welcome to addressBook App";
    }


     // Create api call to save data to repository

    @PostMapping("/post")
    public AddressBook postAddress(@RequestBody AddressBook addressBook) {
        AddressBook newAddressBook = new AddressBook(addressBook);
        repository.save(newAddressBook);
        return newAddressBook;
    }


     // Get all data to repository

    @GetMapping("/get")
    public List<AddressBook> getAddress() {
        List<AddressBook> addressBook = repository.findAll();
        return addressBook;
    }


      //To get data by id to repository

    @GetMapping("/get/{id}")
    public AddressBook getAddressById(@PathVariable Integer id) {
        Optional<AddressBook> addressBook = repository.findById(id);
        return addressBook.get();
    }


     // Update  data in the repository by id

    @PutMapping("/update/{id}")
    public AddressBook updateById(@PathVariable Integer id, @RequestBody AddressBook addressBook) {
        AddressBook newAddressBook = new AddressBook(addressBook, id);
        repository.save(newAddressBook);
        return newAddressBook;
    }


     // Delete  data by id in the repository

    @GetMapping("/delete/{id}")
    public String deleteAddress(@PathVariable Integer id) {
        repository.deleteById(id);
        return "Address of id: " + id + " has been deleted";
    }
}
