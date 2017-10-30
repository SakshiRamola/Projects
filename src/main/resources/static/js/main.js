$(document).ready(function () {

    getBetType();

    $("#selectBetType").change(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        getRaces();

    });

});

function getBetType() {
     $.ajax({
            type: "GET",
            contentType: "application/json",
            url: "/gameType",
            cache: false,
            timeout: 600000,
            success: function (json) {

               $.each(json, function(i, value){
                             $('#selectBetType').append(
                            '<option>' + value + '</option>')
                          });

            },
        });
}

function getRaces(gameId) {

    var search = {}

    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/races/"+ gameId,
        cache: false,
        timeout: 600000,
        success: function (data) {

        },
        error: function (e) {

        }
    });

}