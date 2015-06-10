/**
 * Created by zaporozhec on 4/30/15.
 */
$(document).ready(function () {

    $("#edit-note-form").on("submit", function () {
        $(".alert").hide();
        $.ajax({
            url: "/note",
            type: "POST",
            dataType: "text",
            contentType: "application/json",
            data: toJson(),
            success: function (data, status, jqXHR) {
                $(".alert-success").show()
                location.reload(true);
            },
            error: function (data) {
                $(".alert-error").show()
            }
        });
        return false;
    });
});

function toJson() {
    return JSON.stringify({
        noteName: $("#noteName").val(),
        noteId: $("#noteId").val(),
        noteBody: $("#noteBody").val(),
        date: $("#date").val()
    });

}