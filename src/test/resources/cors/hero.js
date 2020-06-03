$(document).ready(function() {
    $.ajax({
        url: "http://localhost:9000/"
    }).then(function(data, status, jqxhr) {
        $('.data').append(data.responseText);
        console.log(jqxhr);
    });
});