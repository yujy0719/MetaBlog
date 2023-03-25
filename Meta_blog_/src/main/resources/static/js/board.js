let index = {
	init : function() {
		$("#btn-save").on("click", ()=>{
			alert("글등록 하시겠습니까");
			this.save();
		});
		
		$("#btn-update").on("click", ()=>{
			alert("글수정을 하시겠습니까?");
			this.update();
		});
		
		$("#btn-delete").on("click", ()=>{
			alert("글삭제를 하시겠습니까?");
			this.delete();
		});
		
	},
	
	save:function() {
		let data = {	
			title:$("#title").val(),
			content:$("#content").val()
		}
		
		$.ajax({
	        type    : "POST",
	        url : "/api/board",
	        data     : JSON.stringify(data),
	        contentType: "application/json",
	    })
	    .done(function (data) {
	        console.log(data)
	        alert("글등록 완료." );
	        location.href = "/";

	    })
	    .fail(function(error){
		console.log(error)
	       alert("오류" + error);
	       // console.log("fail in get addr");
	    })
	},
	
	update:function() {
		var id = $('#id').val();
		let data = {	
			id : $('#id').val(),
			title:$("#title").val(),
			content:$("#content").val()
		}
		
		$.ajax({
	        type    : "PATCH",
	        url : "/api/update/"+id,
	        data     : JSON.stringify(data),
	        contentType: "application/json",
	    })
	    .done(function (data) {
	        console.log(data)
	        alert("글수정 완료." );
	        location.href = "/board/" + id;

	    })
	    .fail(function(error){
		console.log(error)
	       alert("오류" + error);
	       // console.log("fail in get addr");
	    })
	},
	
	
	delete:function() {
		var id = $('#id').val();
		$.ajax({
	        type    : "DELETE",
	        url : "/api/delete/"+ id,
	       // data     : JSON.stringify(data),
	        contentType: "application/json",
	    })
	    .done(function (data) {
	        console.log(data)
	        alert("글삭제 완료." );
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
