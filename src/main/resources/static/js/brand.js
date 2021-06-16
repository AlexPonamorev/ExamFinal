$(function(){
    src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"
    $('#brandSelect').on('change', function(){
        let brand =  $(this).val();
        console.log(brand);

        $.ajax({
            type: "GET",
            dataType: 'json',
            url: '/{brand}?brand=' + brand
        }).done(function(models){
            fillSelect(models, "modelSelect");
        })
    })
})

//Функция заполняет выпадающий список
function fillSelect(arr, nameSelect){
    var select = document.getElementById(nameSelect);
    select.options.length = 1;
    var textContent;
    var value;
    for(var i = 0; i < arr.length; i++) {
        if(nameSelect == "modelSelect"){
            textContent = arr[i].nameValue;
            value = arr[i].model_id;
        }
        var el = document.createElement("option");
        el.textContent = textContent;
        el.value = value;
        select.appendChild(el);
    }
}

//GET
// 	http://localhost:8086/%7Bbrand%7D/brand?brand=brilliance