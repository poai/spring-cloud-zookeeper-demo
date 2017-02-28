$(function() {

	$("#info").click(function() {
		$.get("/user/1", function(content) {
			alert(content);
		});
		return false;
	});
	$("#list").click(function() {
		$.get("/user", "id=100", function(content) {
			alert(content);
		});
		return false;
	});
});