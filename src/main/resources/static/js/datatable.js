$(document).ready( function () {
	 var table = $('#konsumenTable').DataTable({
			"sAjaxSource": "/api/konsumen/",
			"sAjaxDataProp": "",
			"order": [[ 0, 'desc' ]],
			"aoColumns": [
			      { "mData": "id"},
		          { "mData": "nama" },
				  { "mData": "alamat" },
                  { "mData": "kota" },
                  { "mData": "provinsi" },
                  { "mData": "tgl_registrasi" },
                  { "mData": "status" }
        ]
	 })
});