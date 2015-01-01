<!DOCTYPE html>
<html>
<body>

<div id="form" style="width: 750px;"></div>

<script type="text/javascript">
$(function () {

var formId = w2ui['form'];
if (typeof formId !== 'undefined') {
		formId.destroy();
	}

    $('#form').w2form({ 
        name   : 'form',
        header : 'Auto-Generated Form',
        url    : 'server/post',
        fields : [
            { field: 'first_name', type: 'text', required: true, html: { caption: 'First Name', attr: 'style="width: 300px"' } },
            { field: 'last_name',  type: 'text', required: true, html: { caption: 'Last Name', attr: 'style="width: 300px"' } },
            { field: 'comments',   type: 'textarea', html: { caption: 'Comments', attr: 'style="width: 300px; height: 90px"' } }
        ],
        actions: {
            'Save': function (event) {
                console.log('save', event);
                this.save();
            },
            'Clear': function (event) {
                console.log('clear', event);
                this.clear();
            },
        }
    });
});
</script>

</body>
</html>