 $(document).ready(function(){
        var grid = $("#grid-data").bootgrid({
            ajax:true,
            post: function ()
            {
                return {
                    id: "b0df282a-0d67-40e5-8558-c9e93b7befed"
                };
            },
            url:"/book/bookList",
            formatters: {
                "commands": function(column, row)
                {
                    return "<button type=\"button\" class=\"btn btn-xs btn-success command-edit\" data-row-id=\"" + row.bookId + "\">编辑<span class=\"fa fa-pencil\"></span></button> " +
                        "<button type=\"button\" class=\"btn btn-xs btn-danger command-delete\" data-row-id=\"" + row.bookId + "\">删除<span class=\"fa fa-trash-o\"></span></button>";
                }
            },
           
        }).on("loaded.rs.jquery.bootgrid", function()
		{
            grid.find(".command-edit").on("click", function(e)
            {
                $(".bookmodal").modal();
                alert("You pressed update on row: " + $(this).data("row-id"));
                $.post("/book/getBookInfo",{bookId:$(this).data("row-id")},function(str){
                    $("#bookId2").val(str.bookId);
                    $("#bookName2").val(str.bookName);
                    $("#storagetime2").val(str.storagetime);
                    $("#state2").val(str.state);
                    $("#author2").val(str.author);
                    $("#publishingHouse2").val(str.publishingHouse);
                });
            }).end().find(".command-delete").on("click", function(e)
            {
                alert("You pressed delete on row: " + $(this).data("row-id"));
                $.post("/book/delBook",{bookId:$(this).data("row-id")},function(){
                    alert("删除成功");
                    $("#grid-data").bootgrid("reload");
                });
            });
        });
    });

$(document).ready(function(){
        $("#add").click(function(){
            $(".addmodal").modal();
        });
    });



function save() {
	var bookId=$("#bookId2").val();
	var bookName=$("#bookName2").val();
	var storagetime=$("#storagetime2").val();
	var state=$("#state2").val();
	var author=$("#author2").val();
	var publishingHouse=$("#publishingHouse2").val();
	var nAp=bookId+"-"+bookName+"-"+storagetime+"-"+state+"-"+author+"-"+publishingHouse; 
	alert(nAp);
	$.ajax({
		url:"/book/updateBook",
		data:"nAp="+nAp,
		success:function(data) {
			alert("跳转到控制器成功！");
			if (data) {
				alert("success!");
				window.location.href="BookInf.html";
			}
			else{
				alert("failed");
			}
		},
		error:function(){
			alert("加载失败")
		}
	});
}

function add() {
	
	var bookName=$("#bookName1").val();

	var state=$("#state1").val();
	var author=$("#author1").val();
	var publishingHouse=$("#publishingHouse1").val();
	var nAp=bookName+"-"+state+"-"+author+"-"+publishingHouse; 
	alert(nAp);
	$.ajax({
		url:"/book/addBook",
		data:"nAp="+nAp,
		success:function(data) {
			alert("跳转到控制器成功！");
			if (data) {
				alert("success!");
				window.location.href="BookInf.html";
			}
			else{
				alert("failed");
			}
		},
		error:function(){
			alert("加载失败")
		}
	});
}

function logout() {
	window.location.href="index.html";			
}	
