!function ($) {
  $(document).on("click","ul.nav li.parent > a ", function(){
      $(this).find('em').toggleClass("fa-minus");
  });
  $(".sidebar span.icon").find('em:first').addClass("fa-plus");
}
(window.jQuery);
$(window).on('resize', function () {
if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
})
$(window).on('resize', function () {
if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
})

$(document).on('click', '.panel-heading span.clickable', function(e){
  var $this = $(this);
if(!$this.hasClass('panel-collapsed')) {
  $this.parents('.panel').find('.panel-body').slideUp();
  $this.addClass('panel-collapsed');
  $this.find('em').removeClass('fa-toggle-up').addClass('fa-toggle-down');
} else {
  $this.parents('.panel').find('.panel-body').slideDown();
  $this.removeClass('panel-collapsed');
  $this.find('em').removeClass('fa-toggle-down').addClass('fa-toggle-up');
}
})

$(function() {

  $('#easypiechart-teal').easyPieChart({
      scaleColor: false,
      barColor: '#1ebfae'
  });

  $('#easypiechart-blue').easyPieChart({
      scaleColor: false,
      barColor: '#30a5ff'
  });

  $('#easypiechart-orange').easyPieChart({
      scaleColor: false,
      barColor: '#ffb53e'
  });

  $('#easypiechart-red').easyPieChart({
      scaleColor: false,
      barColor: '#f9243f'
  });
});

$(document).ready(function() {
  $('#calendar').fullCalendar({
    header: {
      left: 'prev,next today',
      center: 'title',
      right: 'listDay,listWeek,month'
    },
     // customize the button names,
    // otherwise they'd all just say "list"
    views: {
      listDay: { buttonText: 'list day' },
      listWeek: { buttonText: 'list week' }
    },
    defaultView: 'listWeek',
    defaultDate: moment(),
    navLinks: true, // can click day/week names to navigate views
    editable: true,
    eventLimit: true, // allow "more" link when too many events
    events: {
      url: './api/calendar/events',
      error: function() {
        $('#script-warning').show();
      }
    },
    loading: function(bool) {
      $('#loading').toggle(bool);
    }
  });
});
