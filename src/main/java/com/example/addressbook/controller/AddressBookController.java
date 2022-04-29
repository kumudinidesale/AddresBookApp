package com.example.addressbook.controller;

import com.example.addressbook.dto.AddressBookDTO;
import com.example.addressbook.dto.ResponseDTO;
import com.example.addressbook.model.AddressBook;

import com.example.addressbook.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/AddressBookApp")
public class AddressBookController {
    @Autowired  //Autowired AddressBookService so we can inject its dependency here
    IAddressBookService service;

    //Print welcome message

    @GetMapping("")
    public String welcomeUser() {
        return "Welcome to  address book app development";
    }

     // Ability to get all address book data by findAll() method

    @GetMapping("/get")
    public ResponseEntity<String> getAllData() {
        List<AddressBook> listOfContacts = service.getListOfAddresses();
        ResponseDTO response = new ResponseDTO("Address book :", listOfContacts);
        return new ResponseEntity(response, HttpStatus.OK);
    }


     //Create api call to save data to repository

    @PostMapping("/post")
    public ResponseEntity<ResponseDTO> postData(@RequestBody  @Valid AddressBookDTO addressBookDTO) {
        AddressBook newContact = service.saveAddress(addressBookDTO);
        ResponseDTO response = new ResponseDTO("New Contact Added in Address book : ", newContact);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }


     //Ability to get person data by id

    @GetMapping("/get/{id}")
    public ResponseEntity<AddressBook> getDataFromRepoById(@PathVariable Integer id) {
        Optional<AddressBook> addressBook = service.getDataById(id);
        ResponseDTO dto = new ResponseDTO("Data",addressBook);
        return new ResponseEntity(dto, HttpStatus.OK);
    }


     // Ability to update address book person data for particular id

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateById(@PathVariable Integer id, @RequestBody @Valid AddressBookDTO addressBookDTO) {
        AddressBook newContact = service.updateDateById(id, addressBookDTO);
        ResponseDTO response = new ResponseDTO("Addressbook updated : ", newContact);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }


     // Ability to delete person data for particular id

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDataById(@PathVariable Integer id) {
        service.deleteContact(id);
        return new ResponseEntity<String>("Contact deleted succesfully", HttpStatus.OK);
    }
}
