/**
 * 
 */
//ckeditor setting
var ckeditor_config = { 
	language : 'ko',
	uiColor: '#AADC6E',
 // skin : 'moono-lisa',
	resize_enabled : false, // 에디터 크기를 조절하지 않음 
	enterMode : CKEDITOR.ENTER_BR , // 엔터키를 <br> 로 적용함. 
	shiftEnterMode : CKEDITOR.ENTER_P , // 쉬프트 + 엔터를 <p> 로 적용함. 
	toolbarCanCollapse : true , 
	removePlugins : "elementspath", // DOM 출력하지 않음 
	filebrowserUploadUrl: '/member/memberJoin', // 파일 업로드를 처리 할 경로 설정. 
	// 에디터에 사용할 기능들 정의 
	toolbar : [ 
		[ 'Source', '-' , 'NewPage', 'Preview' ], 
		[ 'Cut', 'Copy', 'Paste', 'PasteText', '-', 'Undo', 'Redo' ], 
		[ 'Bold', 'Italic', 'Underline', 'Strike', 'Subscript', 'Superscript'], 
		[ 'JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock' ], 
		'/', 
		[ 'Styles', 'Format', 'Font', 'FontSize' ], 
		[ 'TextColor', 'BGColor' ], 
		[ 'Image', 'Flash', 'Table' , 'SpecialChar' , 'Link', 'Unlink'] 
		] 
}; 

var editor = null; 