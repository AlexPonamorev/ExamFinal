$(function(){
  $('#country').on('change', function(){
    let countryId =  $(this).val();
    $.ajax({
      type: "GET",
      dataType: 'JSON',
      url: '/' + countryId
    }).done(function(cities){
      let citiesOptions = '';
      cities.forEach((city) => {
        citiesOptions += `<option

         value="${brandMap}">${
        <div th:each="brandKey : ${brandMap.keySet()}">
            <a th:href="@{/suggestHtml/{brand}(brand=${brandMap.get(brandKey)}) }"
               th:text="${brandMap.get(brandKey)}"> VALUE
            </a>
        </div>
        }
        </option>`;
      });
      $('#city').html(citiesOptions);
    }).fail(function() {
      alert("Для использования функций сайта выполните авторизацию");
    });
  });
})