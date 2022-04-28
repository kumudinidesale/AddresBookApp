package com.example.addressbook.service;

import com.example.addressbook.dto.AddressBookDTO;
import com.example.addressbook.model.AddressBook;

import java.util.List;
import java.util.Optional;

public interface  IAddressBookService {

    public AddressBook saveAddress(AddressBookDTO addressBookDTO);

    public List<AddressBook> getListOfAddresses();

    public Optional<AddressBook> getDataById(Integer id);

    public AddressBook updateDateById(Integer id, AddressBookDTO addressBookDTO);

    public void deleteContact(Integer id);
}