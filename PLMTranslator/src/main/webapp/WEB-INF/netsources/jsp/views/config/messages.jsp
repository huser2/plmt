

<div id="plmt_tabs" style="width: 100%;"></div>
<div id="selected-tab" style="padding: 10px 0px"></div>

<script type="text/javascript">
$(function () {
    $('#plmt_tabs').w2tabs({
        name: 'plmt_tabs',
        active: 'completed',
        tabs: [
            { id: 'config/completed.list', caption: 'Completed' },
            { id: 'config/failed.list', caption: 'Failed' }
        ],
        onClick: function (event) {
        $.ajax({
        url: event.target,
        type:'GET',
        success: function(data){
            //w2ui['plmt_layout'].content('main',data);
           // alert(data);
          $('#selected-tab').html(data);
        }
   		 });
          // $('#selected-tab').html(event.target);
        }
    });
});
</script>
