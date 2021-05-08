$(function(){
  $('#country').on('change', function(){
    let countryId =  $(this).val();
    $.ajax({
      type: "GET",
      dataType: 'JSON',
      url: '/suggestH' + countryId
    }).done(function(cities){
      let citiesOptions = '';
      cities.forEach((city) => {
        citiesOptions += <option value="${model}">${city.name}</option>;
      });
      $('#city').html(citiesOptions);
    }).fail(function() {
      alert("Для использования функций сайта выполните авторизацию");
    });
  });
})

