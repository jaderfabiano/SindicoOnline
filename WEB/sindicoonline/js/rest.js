(function($) {
	
$.fn.ajaxSubmit.debug = true;

$(document).ajaxError(function(ev,xhr,o,err) {
    alert(err);
    if (window.console && window.console.log) console.log(err);
});

$(function() {
    // initialize page tabs (../malsup-tabs-init.js)


    $('#jsonForm').ajaxForm({
        dataType: 'json',
        success:  processJson
    });

    

    function processJson(data) {
        alert(data.message);
    }

});

})(jQuery);
