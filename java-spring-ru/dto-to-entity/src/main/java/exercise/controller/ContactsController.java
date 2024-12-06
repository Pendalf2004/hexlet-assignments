package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import exercise.model.Contact;
import exercise.repository.ContactRepository;
import exercise.dto.ContactDTO;
import exercise.dto.ContactCreateDTO;

@RestController
@RequestMapping("/contacts")
public class ContactsController {

    @Autowired
    private ContactRepository contactRepository;

    // BEGIN
    public ContactCreateDTO toCreateContactDTO(Contact contact) {
        var newContact = new ContactCreateDTO();
        newContact.setFirstName(contact.getFirstName());
        newContact.setLastName(contact.getLastName());
        newContact.setPhone(contact.getPhone());
        return newContact;
    }

    public ContactDTO toContactDTO(Contact contact) {
        var newContact = new ContactDTO();
        newContact.setFirstName(contact.getFirstName());
        newContact.setLastName(contact.getLastName());
        newContact.setPhone(contact.getPhone());
        newContact.setId(contact.getId());
        newContact.setCreatedAt(contact.getCreatedAt());
        newContact.setUpdatedAt(contact.getUpdatedAt());
        return newContact;
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public ContactDTO save(@RequestBody ContactCreateDTO inputContact) {
        var contact = new Contact();
        contact.setFirstName(inputContact.getFirstName());
        contact.setLastName(inputContact.getLastName());
        contact.setPhone(inputContact.getPhone());
        contactRepository.save(contact);
        return toContactDTO(contact);
    }

    // END
}
