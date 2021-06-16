$(function(){
    src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"
    $('#brandSelect').on('change', function(){
        let brand =  $(this).val();
        console.log(brand);

        $.ajax({
            type: "GET",
            dataType: 'json',
            url: '/brand',
            data:{
                brand: brand,
            }
        }).done(function(models){
            fillSelect(models, "modelSelect");
        })
    })
})

// функция подгружает список поколений
$(function(){
    src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"
    $('#modelSelect').on('change', function(){
        let brand = $('#brandSelect').val();
        console.log(brand);
        let model =  $(this).val();
        console.log(model);
        $.ajax({
            type: "GET",
            dataType: 'json',
            url: '/model',
            data:{
                brand: brand,
                model: model
            }
        }).done(function(generations){
            fillSelect(generations, "generationSelect");
        })
    })
})


// функция подгружает список запчастей
$(function(){
    src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"
    $('#generationSelect').on('change', function(){
        let generation =  $(this).val();
        let brand = $('#brandSelect').val();
        let model =  $('#modelSelect').val();
        // console.log('generations =  ' + generation );
        $.ajax({
            type: "GET",
            dataType: 'json',
            url: '/generation',
            data:{
                brand: brand,
                model: model,
                generation: generation
            }
        }).done(function(autoParts){
            fillSelect(autoParts, "autoPartsSelect");
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
            value = arr[i].nameKey;
            console.log(textContent);
        }
        if(nameSelect == "generationSelect"){
            textContent = arr[i].nameValue;
            value = arr[i].nameKey;
            console.log(textContent);
        }
        if(nameSelect == "autoPartsSelect"){
            textContent = arr[i].nameValue;
            value = arr[i].nameKey;
        }
        var el = document.createElement("option");
        el.textContent = textContent;
        el.value = value;
        select.appendChild(el);
    }
}

//GET
// 	http://localhost:8086/%7Bbrand%7D/brand?brand=brilliance