
	//let url='http://localhost:8080';
	let url='';
	//封装请求
	function MyAjax(api,type,data){
		return new Promise((resolve,reject)=>{
			$.ajax({
					url : url+api,
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
	//封装数据验证
	function Verification(data){
		if(data.name==undefined||data.name==''){
			return false
		}
		if(data.pwd==undefined||data.pwd==''){
			return false
		}
		return true
	}
	
