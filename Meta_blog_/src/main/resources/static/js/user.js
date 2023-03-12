let index = {
	init : function() {

		$("#btn-save").on("click", ()=>{
			alert("회원가입하시겠습니까");
			this.save();
		});
	},
	
	save:function() {
		let data = {
			username:$("#username").val(),
			password:$("#password").val(),
			email:$("#email").val()
		}
		
		console.log(data);
		
		$.ajax({
	        type    : "POST",
	        url        : "/auth/joinProc",
	        data     : JSON.stringify(data),
	        contentType: "application/json",
	       // dataType:"json",  // 응답으로 온 데이터 형식이 어떤지
	    })
	    .done(function (data) {
		//+ JSON.stringify(data)
	        console.log(data)
	        alert("회원가입 완료." );
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