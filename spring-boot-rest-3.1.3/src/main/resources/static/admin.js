$(document).ready(function () {

    usersTable()

    fetch('http://localhost:8080/user-rest')
        .then((response) => {
            return response.json()
        })
        .then((user) => {
            //navbar
            $('#navbarUsername').text(user.username)
            $('#navbarRoles').text(user.rolesWithoutPrefix)
        })
})

$('.AddUserButton').on('click', function () {

    let user = {
        name: $('#name').val(),
        surname: $('#surname').val(),
        username: $('#username').val(),
        profession: $('#profession').val(),
        password: $('#password').val(),
        roles: createRoles('#roles')
    }

    if (user.name != '' && user.surname != '' && user.username != '' && user.profession != '' && user.password != '') {
        fetch("admin-rest/createNewUser", {
            method: "POST",
            headers: {
                "Content-Type": "application/json; charset=utf-8"
            },
            body: JSON.stringify(user)
        }).then(() => refreshAllUser())
            .then(() => document.getElementById('goToUserTable').click())
        $('input').val('')
    } else {
        alert('Не все поля заполнены')
    }
})

function usersTable() {
    fetch('http://localhost:8080/admin-rest')
        .then((response) => {
            return response.json();
        })
        .then((userTable) => {
            $('#bodyOfUsersTable').empty()
            userTable.forEach((user) => {
                $('#bodyOfUsersTable').append(createRowForUser(user))
            })
        })
}

function createRowForUser(user) {
    return `<tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.surname}</td>
                <td>${user.username}</td>
                <td>${user.profession}</td>
                <td>${user.rolesWithoutPrefix}</td>
                <td> 
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalEdit"
                                            data-ID="${user.id}"
                                            data-Name="${user.name}"
                                            data-Surname="${user.surname}"
                                            data-Username="${user.username}"
                                            data-Profession="${user.profession}" 
                                            >
                        <div>Edit</div>
                    </button>
                </td>
                </td>
                <td>
                                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#modalDelete"
                                            data-ID="${user.id}"
                                            data-Name="${user.name}"
                                            data-Surname="${user.surname}"
                                            data-Username="${user.username}"
                                            data-Profession="${user.profession}"
                                            data-Roles="${user.rolesWithoutPrefix}">
                    Delete        
                    </button>

                </td>
            </tr>`
}

$('#modalDelete').on('show.bs.modal', function (event) {
    const button = $(event.relatedTarget);
    const idDelete = button.data('id');
    const nameDelete = button.data('name');
    const surnameDelete = button.data('surname');
    const usernameDelete = button.data('username');
    const professionDelete = button.data('profession');
    const rolesDelete = button.data('roles');
    const modal = $(this);

    modal.find('#idDelete').val(idDelete);
    modal.find('#nameDelete').val(nameDelete);
    modal.find('#surnameDelete').val(surnameDelete);
    modal.find('#usernameDelete').val(usernameDelete);
    modal.find('#professionDelete').val(professionDelete);
    modal.find('#rolesDelete').val(rolesDelete);
})

$('#modalEdit').on('show.bs.modal', function (event) {
    const button = $(event.relatedTarget);
    const idEdit = button.data('id');
    const nameEdit = button.data('name');
    const surnameEdit = button.data('surname');
    const usernameEdit = button.data('username');
    const professionEdit = button.data('profession');
    const modal = $(this);

    modal.find('#idEdit').val(idEdit);
    modal.find('#nameEdit').val(nameEdit);
    modal.find('#surnameEdit').val(surnameEdit);
    modal.find('#usernameEdit').val(usernameEdit);
    modal.find('#professionEdit').val(professionEdit);
})

$('#deleteUserButton').on('click', function () {
    fetch('http://localhost:8080/admin-rest/delete', {
        method: 'delete',
        headers: {
            "Content-Type": "application/json; charset=utf-8"
        },
        body: JSON.stringify($('#idDelete').val())
    }).then(() => refreshAllUser())
})

$('#editUserButton').on('click', function () {

    let userEdit = {
        id: $('#idEdit').val(),
        name: $('#nameEdit').val(),
        surname: $('#surnameEdit').val(),
        username: $('#usernameEdit').val(),
        profession: $('#professionEdit').val(),
        password: $('#passwordEdit').val(),
        roles: createRoles('#rolesEdit')
    }

    if (userEdit.name != '' && userEdit.surname != '' && userEdit.username != '' && userEdit.profession != '' && userEdit.password != '') {
        fetch('http://localhost:8080/admin-rest/edit', {
            method: "POST",
            headers: {
                "Content-Type": "application/json; charset=utf-8"
            },
            body: JSON.stringify(userEdit)
        }).then(() => refreshAllUser())
            .then(() => document.getElementById('closeEditModal').click())
        $('input').val('')
    } else {
        alert('Не все поля заполнены')
    }
})

$('#closeEditModal').on('click', function () {
    $('input').val('')
})

function createRoles(selector) {
    let roles = [];
    $(selector).find('option:selected').each(function () {
        roles.push({
            id: $(this).val(),
            nameOfRole: $(this).attr('name')
        })
    })
    return roles
}

function refreshAllUser() {
    let UserTableBody = $("#bodyOfUsersTable")
    UserTableBody.children().remove().append(usersTable());
}