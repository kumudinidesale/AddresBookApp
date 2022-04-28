package com.example.addressbook.service;

import com.example.addressbook.dto.AddressBookDTO;
import com.example.addressbook.model.AddressBook;
import com.example.addressbook.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService implements IAddressBookService  {
    //Autowired repository class to inject its dependency
    @Autowired
    AddressBookRepository repository;

    //Created service method which serves controller api to retrieve all records
    public List<AddressBook> getListOfAddresses() {
        List<AddressBook> addressBooks = repository.findAll();
        return addressBooks;
    }



    //Created service method which serves controller api to post data
    public AddressBook saveAddress(AddressBookDTO addressBookDTO) {
        AddressBook addressBook = new AddressBook(addressBookDTO);
        repository.save(addressBook);
        return addressBook;
    }

    //Created service method which serves controller api to get record by id
    public Optional<AddressBook> getDataById(Integer id) {
        Optional<AddressBook> addressBook = repository.findById(id);
        return addressBook;
    }

    //Created service method which serves controller api to update record by id
    public AddressBook updateDateById(Integer id, AddressBookDTO addressBookDTO) {
        AddressBook addressBook = new AddressBook(id, addressBookDTO);
        repository.save(addressBook);
        return addressBook;
    }

    //Created service method which serves controller api to delete record by id
    public void deleteContact(Integer id) {
        repository.deleteById(id);
    }
}
