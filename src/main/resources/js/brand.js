$(function(){
  $('#country').on('change', function(){
    let countryId =  $(this).val();
    $.ajax({
      type: "GET",
      dataType: 'JSON',
      url: '/suggest' + countryId
    }).done(function(cities){
      let citiesOptions = '';
      cities.forEach((city) => {
        citiesOptions += <option value="${city.id}">${city.name}</option>;
      });
      $('#city').html(citiesOptions);
    }).fail(function() {
      alert("Для использования функций сайта выполните авторизацию");
    });
  });
})

