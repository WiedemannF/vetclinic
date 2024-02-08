insert into clinics(name, address) values ('Максивет','Пермитина, 24а');
insert into clinics(name, address) values ('Интерра','Стартовая, 1');

insert into doctors(name, address, phone_number) values ('Пётр Петрович', 'Московская 163', '9132546785');
insert into doctors(name, address, phone_number) values ('Сан Саныч', 'Кирова 11', '9136548216');
insert into doctors(name, address, phone_number) values ('Татьяна Викторовна', 'Ленина 206', '9133334587');
insert into doctors(name, address, phone_number) values ('Ульяна Сергеевна', 'Кирова 39', '9132564528');
insert into doctors(name, address, phone_number) values ('Виктория Григорьевна', 'Маркса 57', '9139994852');

insert into doctor_clinics(clinic_id, doctor_id) values (1, 1);
insert into doctor_clinics(clinic_id, doctor_id) values (1, 2);
insert into doctor_clinics(clinic_id, doctor_id) values (1, 3);
insert into doctor_clinics(clinic_id, doctor_id) values (2, 2);
insert into doctor_clinics(clinic_id, doctor_id) values (2, 4);
insert into doctor_clinics(clinic_id, doctor_id) values (2, 5);

insert into owners(name, address, phone_number) values ('Владелец1', 'Улица1', '9991111111');
insert into owners(name, address, phone_number) values ('Владелец2', 'Улица2', '9992222222');
insert into owners(name, address, phone_number) values ('Владелец3', 'Улица3', '9993333333');
insert into owners(name, address, phone_number) values ('Владелец4', 'Улица4', '9994444444');
insert into owners(name, address, phone_number) values ('Владелец5', 'Улица5', '9995555555');
insert into owners(name, address, phone_number) values ('Владелец6', 'Улица6', '9996666666');
insert into owners(name, address, phone_number) values ('Владелец7', 'Улица7', '9997777777');
insert into owners(name, address, phone_number) values ('Владелец8', 'Улица8', '9998888888');

insert into pets(name, breed, sex, date_of_birth, owner_id) values ('Рекс', 'Овчарка', 'М', '2018-10-10', 1);
insert into pets(name, breed, sex, date_of_birth, owner_id) values ('Мухтар', 'Овчарка', 'М', '2017-12-15', 1);
insert into pets(name, breed, sex, date_of_birth, owner_id) values ('Паскаль', 'Метис', 'М', '2021-11-25', 2);
insert into pets(name, breed, sex, date_of_birth, owner_id) values ('Питомец4', 'Порода4', 'Ж', '2014-10-10', 3);
insert into pets(name, breed, sex, date_of_birth, owner_id) values ('Питомец5', 'Порода5', 'М', '2015-10-10', 4);
insert into pets(name, breed, sex, date_of_birth, owner_id) values ('Питомец6', 'Порода6', 'Ж', '2016-10-10', 5);
insert into pets(name, breed, sex, date_of_birth, owner_id) values ('Питомец7', 'Порода7', 'М', '2017-10-10', 6);
insert into pets(name, breed, sex, date_of_birth, owner_id) values ('Питомец8', 'Порода8', 'Ж', '2018-10-10', 7);
insert into pets(name, breed, sex, date_of_birth, owner_id) values ('Питомец9', 'Порода9', 'М', '2019-10-10', 8);
insert into pets(name, breed, sex, date_of_birth, owner_id) values ('Питомец10', 'Порода10', 'Ж', '2020-10-10', 3);
insert into pets(name, breed, sex, date_of_birth, owner_id) values ('Питомец11', 'Порода11', 'М', '2021-10-10', 4);
insert into pets(name, breed, sex, date_of_birth, owner_id) values ('Питомец12', 'Порода12', 'Ж', '2022-10-10', 5);
insert into pets(name, breed, sex, date_of_birth, owner_id) values ('Питомец13', 'Порода13', 'М', '2023-10-10', 6);
insert into pets(name, breed, sex, date_of_birth, owner_id) values ('Питомец14', 'Порода14', 'Ж', '2024-01-01', 7);

insert into disease_histories(pet_id) values (1);
insert into disease_histories(pet_id) values (2);
insert into disease_histories(pet_id) values (3);
insert into disease_histories(pet_id) values (4);
insert into disease_histories(pet_id) values (5);
insert into disease_histories(pet_id) values (6);
insert into disease_histories(pet_id) values (7);
insert into disease_histories(pet_id) values (8);
insert into disease_histories(pet_id) values (9);
insert into disease_histories(pet_id) values (10);
insert into disease_histories(pet_id) values (11);
insert into disease_histories(pet_id) values (12);
insert into disease_histories(pet_id) values (13);
insert into disease_histories(pet_id) values (14);

insert into disease_cases(case_description, date, doctor_id, disease_history_id) values ('Заболела лапа, вылечили', '2024-07-02', 1, 1);
insert into disease_cases(case_description, date, doctor_id, disease_history_id) values ('Заболело ухо, вылечили', '2024-06-02', 1, 2);
insert into disease_cases(case_description, date, doctor_id, disease_history_id) values ('Заболел живот, вылечили', '2024-05-02', 2, 3);
insert into disease_cases(case_description, date, doctor_id, disease_history_id) values ('Заболел глаз, вылечили', '2024-04-02', 3, 2);
insert into disease_cases(case_description, date, doctor_id, disease_history_id) values ('Заболел хвост, вылечили', '2024-03-02', 2, 5);

commit



