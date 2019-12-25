	//var url='http://127.0.0.1:8080';
	//var url='http://localhost:8080';
	//封装请求
	function MyAjax(api,type,data){
		return new Promise((resolve,reject)=>{
			$.ajax({
					url : api,
					type :type,
					data : data,
					success : function(res) {
						resolve(res)
					 },
					 error : function(e){
						reject(e)
					}
			 })
		})
	}