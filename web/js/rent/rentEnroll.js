/**
 *
 */

var facSeq = 0;
var coutionSeq = 0;
var detAddrSeq = 0;

$(document).ready(function () {
    //Initialize tooltips
    $('.nav-tabs > li a[title]').tooltip();

    //Wizard
    $('a[data-toggle="tab"]').on('show.bs.tab', function (e) {

        var $target = $(e.target);

        if ($target.parent().hasClass('disabled')) {
            return false;
        }
    });

    $(".next-step").click(function (e) {

        var $active = $('.wizard .nav-tabs li.active');
        $active.next().removeClass('disabled');
        nextTab($active);
		scroll(0,0);
    });
    $(".prev-step").click(function (e) {

        var $active = $('.wizard .nav-tabs li.active');
        prevTab($active);

    });


	$("#facInfoContentAddBtn").click(function(){

		console.log("facInfoContentAddBtn");
		console.log("facSeq::"+facSeq);

		var facInfoContent = $.trim($("#facInfoContent").val())
		if(facInfoContent != "" && facInfoContent != null && facSeq < 5){
			facSeq++;
			$("#facInfoContent").clone(true).attr({"name" : "facInfoContentReq", "id" : "facInfoContent"+facSeq, "value" : $("facInfoContent").val(), "readonly" : "true"}).appendTo($(".facInfo"));

			$("#facInfoContent").val("");
			$("#facInfoContent").focus();
			/* $("#facInfoContentAddBtn").append($("<br>")); */
			$(".facInfo").append($("<br>"));
		}

		if(facSeq == 5){

			$("#facInfoContent").attr({"readonly" : "true"});
			$("#facInfoContentAddBtn").attr("disabled", "true");

			/*
			$("#facInfoContent").attr({"style" : "display:none"});
			$("#facInfoContentAddBtn").attr({"style" : "display:none"});
			 */
		}
	});


	$("#cautionContentAddBtn").click(function(){

		console.log("cautionContentAddBtn");
		console.log("coutionSeq::"+coutionSeq);

		var facInfoContent = $.trim($("#cautionContent").val())
		if(facInfoContent != "" && facInfoContent != null && coutionSeq < 5){
			coutionSeq++;
			$("#cautionContent").clone(true).attr({"name" : "cautionContentReq", "id" : "cautionContent"+coutionSeq, "value" : $("cautionContent").val(), "readonly" : "true"}).appendTo($(".caution"));
			$("#cautionContent").val("");
			$("#cautionContent").focus();
			/* $("#facInfoContentAddBtn").append($("<br>")); */
			$(".caution").append($("<br>"));
		}

		if(coutionSeq == 5){
			$("#cautionContent").attr("readonly", "true");
			$("#cautionContentAddBtn").attr("disabled", "true");
		}
	});


	$("#detAddressAddBtn").click(function(){

		console.log("detAddressAddBtn");
		console.log("detAddrSeq::"+detAddrSeq);

		var facInfoContent = $.trim($("#detAddress").val())
		if(facInfoContent != "" && facInfoContent != null && detAddrSeq < 5){
			detAddrSeq++;
			$("#detAddress").clone(true).attr({"name" : "detAddressReq", "id" : "detAddress"+detAddrSeq, "value" : $("detAddress").val(), "readonly" : "true"}).appendTo($(".detAddr"));
			$("#detAddress").val("");
			$("#detAddress").focus();
			/* $("#facInfoContentAddBtn").append($("<br>")); */
			$(".detAddr").append($("<br>"));
		}

		if(detAddrSeq == 5){
			$("#detAddress").attr("readonly", "true");
			$("#detAddressAddBtn").attr("disabled", "true");
		}
	});

});

function nextTab(elem) {
    $(elem).next().find('a[data-toggle="tab"]').click();
}
function prevTab(elem) {
    $(elem).prev().find('a[data-toggle="tab"]').click();
}
