$(window).on('load', function(){

    moment.locale('es-mx');

    // bbva.showNotification('danger', 'Esta página se encuentra en desarrollo, algunas funciones no estarán disponibles.');

});

$('#loader-table').hide();

var confirmSweetAlert;
const executeSweetAlert = async (title, text, btnSuccess, btnCancel ) => {
    const swalWithBootstrapButtons = await Swal.mixin({
        customClass: {
            confirmButton: 'btn btn-primary btn-bbva',
            cancelButton: 'btn btn-light btn-bbva-cancel'
        },
        buttonsStyling: false
    });

    await swalWithBootstrapButtons.fire({
        title: title,
        text: text,
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: btnSuccess,
        cancelButtonText: btnCancel,
        reverseButtons: true,

    }).then( res => { confirmSweetAlert = res.isConfirmed; } );

};

function executeDatatable(id) {
    $(id).DataTable({
        language: {
            url: '//cdn.datatables.net/plug-ins/1.10.16/i18n/Spanish.json',
        },
    });
}

function getUUID() {
    return ([1e7]+-1e3+-4e3+-8e3+-1e11).replace(/[018]/g, c =>
        (c ^ crypto.getRandomValues(new Uint8Array(1))[0] & 15 >> c / 4).toString(16)
    );
}

function restoreProperties(){

    $('#footer').show();
    document.getElementById('logo-sec-arch-gov').src = '../img/LOGO_Sec-ArchGov-color.png';
    document.getElementById('logo-sec-arch-gov').width = '100';

    document.getElementById('bar-area').innerHTML = 'Banking Architecture';

}

function loadDataEmployee(){

    document.getElementById("img-profile").src = localStorage.getItem("session_picture");
    document.getElementById("img-profile-label").title = localStorage.getItem("session_email");

}

loadDataEmployee();