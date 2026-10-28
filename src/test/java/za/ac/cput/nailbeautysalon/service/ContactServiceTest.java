package za.ac.cput.nailbeautysalon.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import za.ac.cput.nailbeautysalon.domain.Address;
import za.ac.cput.nailbeautysalon.domain.Contact;
import za.ac.cput.nailbeautysalon.factory.ContactFactory;
import za.ac.cput.nailbeautysalon.repository.AddressRepository;

import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class ContactServiceTest {

    @Autowired
    private ContactService service;

    @Autowired
    private AddressRepository addressRepository;

    // Create an address, save it, and then create a contact.
    private Contact createTestContact() {

        Address address = new Address.Builder()
                .setStreetNumber("12")
                .setStreetName("Long Street")
                .setCity("Cape Town")
                .setSuburb("Foreshore")
                .setProvince("Western Cape")
                .setPostalCode(8001)
                .build();

        Address savedAddress = addressRepository.save(address);

        return ContactFactory.createContact(
                savedAddress,
                "0821234567",
                "salon@gmail.com",
                LocalTime.of(8, 0)
        );
    }

    @Test
    void a_create() {
        Contact contact = createTestContact();

        Contact created = service.create(contact);

        assertNotNull(created);
        assertNotNull(created.getContactId());
        System.out.println(created);
    }

    @Test
    void b_read() {
        Contact contact = createTestContact();

        Contact created = service.create(contact);

        Contact read = service.read(created.getContactId());

        assertNotNull(read);
        assertEquals(created.getContactId(), read.getContactId());
        System.out.println(read);
    }

    @Test
    void c_update() {
        Contact contact = createTestContact();

        Contact created = service.create(contact);

        Contact updatedContact = new Contact.Builder()
                .copy(created)
                .setPhone("0839876543")
                .build();

        Contact updated = service.update(updatedContact);

        assertNotNull(updated);
        assertEquals("0839876543", updated.getPhone());
        System.out.println(updated);
    }

    @Test
    @Disabled
    void d_delete() {
        Contact contact = createTestContact();

        Contact created = service.create(contact);

        boolean deleted = service.delete(created.getContactId());

        assertTrue(deleted);
        System.out.println("Deleted: " + deleted);
    }

    @Test
    void e_getAll() {
        List<Contact> contacts = service.getAll();

        assertNotNull(contacts);
        System.out.println(contacts);
    }

    @Test
    void f_findContactByAddressProvinceIn() {
        // Ensure a contact exists for the province query.
        Contact contact = createTestContact();
        service.create(contact);

        List<Contact> contacts =
                service.findContactByAddressProvinceIn(
                        List.of("Western Cape")
                );

        assertNotNull(contacts);
        System.out.println(contacts);
    }
}