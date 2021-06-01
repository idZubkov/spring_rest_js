$(document).ready(function () {
    fetch('http://localhost:8080/user-rest')
        .then((response) => {
            return response.json()
        })
        .then((user) => {
            //table
            $('#tableID').text(user.id)
            $('#tableName').text(user.name)
            $('#tableSurname').text(user.surname)
            $('#tableUsername').text(user.username)
            $('#tableProfession').text(user.profession)
            $('#tableRoles').text(user.rolesWithoutPrefix)
            //navbar
            $('#navbarUsername').text(user.username)
            $('#navbarRoles').text(user.rolesWithoutPrefix)
            // link
            if (user.rolesWithoutPrefix.indexOf('ADMIN') < 0) {
                document.getElementById('linkAdmin').style.display = "none"
            }
        })
})