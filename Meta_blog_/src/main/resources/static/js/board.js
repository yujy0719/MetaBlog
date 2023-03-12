let index = {
	init : function() {

		$("#btn-save").on("click", ()=>{
			alert("글등록을 하시겠습니까?");
			this.save();
		});
	},
	
	save:function() {
		let data = {
			title:$("#title").val(),
			content:$("#content").val()
		}
		
		console.log(data);
		
		$.ajax({
	        type    : "POST",
	        url : "/api/board",
	        data     : JSON.stringify(data),
	        contentType: "application/json",
	    })
	    .done(function (data) {
	        console.log(data)
	        alert("글쓰기 완료." );
	        location.href = "/";

	    })
	    .fail(function(error){
		console.log(error)
	       alert("오류" + error);
	       // console.log("fail in get addr");
	    })
	}
}

index.init();