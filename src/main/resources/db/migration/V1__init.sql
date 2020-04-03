-- INSERT ROLE_GROUP ADMIN
insert into role_group
(id, description, name, user_type)
values
(nextval('hibernate_sequence'), 'Has access to all.', 'ADMINISTRATORS','ADMINISTER');

-- INSERT ADMIN (Password: 123senha123)
insert into appuser
(id, change_password_next_access, create_at, email, name, password, status, user_type, role_group_id)
values
(nextval('hibernate_sequence'), FALSE, now(), 'marceloazvedo1@gmail.com', 'Marcelo Santos de Azevedo', '$2a$10$mCBPmzt6orQusY0M3fGvAepSY5NMERZooXiHNHyRbnXuTUuZNEGU2', false, 'ADMINISTER',
    (
        select rg.id
        from role_group rg
        where user_type = 'ADMINISTER'
        limit 1
    )
);
insert into admin_user
(id)
values
((select admin.id from appuser admin where user_type = 'ADMINISTER' limit 1));