/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESD_TRS_0910.js
*@FileTitle : Currency Change Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.01
*@LastModifier : 최 선
*@LastVersion : 1.1
* 2010.03.18 조풍연
* 1.0 최초 생성
*----------------------------------------------------------
* History
* 2010.12.01 최 선     1.1 [] INV. Exchange Rate Validiation 변경
=========================================================*/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0910 : Booking ??? ?? ???? ???? ?? ????? ????.
 */
function ESD_TRS_0910() {
    this.processButtonClick     = processButtonClick;
    this.setSheetObject         = setSheetObject;
    this.setComboObject         = setComboObject;
    this.setTabObject           = setTabObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;        
    this.initControl            = initControl;
    this.initTab                = initTab;
    this.doActionIBSheet        = doActionIBSheet;
    this.validateForm           = validateForm;
}
/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/

// 공통전역변수

var sheetObjects = new Array();
var sheetCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	 var sheetObject = sheetObjects[0];

	 /*******************************************************/
	 var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

			 case "btn_ok":
				if(formObject.ex_rate.value == ''){
					ComShowCodeMessage('TRS90214');
					break;
				}

				var cal_logic = formObject.woamount[0].checked ? formObject.woamount[0].value : formObject.woamount[1].value;
				opener.setCurrencyChange(
				formObject.sel_invoicemode.value, 
				formObject.ex_rate.value,
				cal_logic);
				window.close();
				break;

			case "btn_close":
				  window.close();
			  break;



		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage('COM12111');
		} else {
			ComShowMessage(e);
		}
	}
}


/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

	var formObject = document.form;
	formObject.sel_invoicemode.value = formObject.hid_invoicemode.value;
	formObject.sel_invoicemode.disabled = true;
	//html컨트롤 이벤트초기화
	initControl();
	
}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 **/
function initControl() {
    //Axon ??? ??1. ???catch
    /*
    axon_event.addListener  ('keypress', 'engnum_keypress', 'boo_bkg_no', 'vvd_vvd');
    axon_event.addListener  ('click', 'manual_click', 'manual');    //BKG Creation탭의 manual이 바뀐경우
    axon_event.addListener  ('keyup', 'bkgno_keyup', 'boo_bkg_no'); //BKG Creation탭의 Booking No가 바뀐경우
    axon_event.addListenerFormat('blur',    'obj_blur',     form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onblur이벤트에 코드 처리
    axon_event.addListenerFormat('focus',   'obj_focus',    form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onfocus이벤트에 코드 처리
    axon_event.addListenerFormat('keypress','obj_keypress', form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리 
    axon_event.addListener  ('change', 'customer_change', 'cus_cust_nm');     //Cust탭의 Cusromer_nm이 바뀐경우
    */
}

//Axon ??? ??2. ??????? --- start
/**
* HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
 **/
function engnum_keypress() {
    //???? ????
//            ComKeyOnlyAlphabet('uppernum');
}

/**
 * BKG Creation?? manual? ???? ??? ????. <br>
 **/
function manual_click() {
    //manual이 체크된 경우만 Bkg_no를 편집 가능으로 한다.
//            form.boo_bkg_no.readOnly =!form.manual.checked;
}

/**
 * BKG Creation탭의 Booking No가 바뀐경우 기능을 처리한다. <br>
 **/
function bkgno_keyup() {
    //bkg_no를 수정해서 저장된값과 다른경우 bl_no를 지우고, 같은경우 bl_no를 살린다.
    /*
    if (form.boo_bkg_no.value != form.hdn_boo_bkg_no.value) 
	form.boo_bl_no.value = "";
    else
	form.boo_bl_no.value = form.hdn_boo_bl_no.value;
	*/
}

/**
 * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
 **/
function obj_blur(){
    //입력Validation 확인하기
//            return ComChkObjValid(event.srcElement);
}

/**
 * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
 **/
function obj_focus(){
    //?????? ???
//            ComClearSeparator(event.srcElement);
}

/**
 * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
 **/
function obj_keypress(){
    //???????
//            ComKeyOnlyNumber(event.srcElement);
}

//Axon 이벤트 처리2. 이벤트처리함수 --- end


function fun_addcomma() {
	var formObject = document.form;

	str = formObject.ex_rate.value;
	num = "";

	for( var i=0; i < str.length; i++ ) {
		if( str.charAt(i) != ",") {
			num = num+str.charAt(i);
		} else {
			break;
		}
	}

	formObject.ex_rate.value = num + str.substring(i, i+3);
}


function del_comma(str) {
	num ="";
	for( var i=0 ; i < str.length ; i++){
		if( str.charAt(i) != "," ) {
			num=num+str.charAt(i);
		}
	}
	return num ;
}




/**
 * SOcheck.
 */
function fn_check(obj,val){

	var formObject = document.form;
	var inputStr=obj.value;
	var value=obj.value;
	var charval = "Y";
	var lvobj = doSepRemove(obj.value.toUpperCase(), " ");
	var numExRate = Number(inputStr);
	
	lvobj=obj.value;

	if( lvobj != "" ) {
		for (var i = 0; i < inputStr.length; i++)
		{
			 var oneChar = inputStr.charAt(i);
			 if (oneChar != "" && numExRate > 0)
			 {
				   if (   (oneChar >= "0" && oneChar <= "9") || (oneChar == "," )  || (oneChar == "." )   ){
				   }else {
					   charval ="N";
					   break;
				   }
			 }else{
				charval ="N";
				break;
			 }
		}

		if(charval=="Y"){
			formObject.ex_rate.value = chkAmtPos(formObject.ex_rate.value, 4);		  //Exchange Rate
			fn_checknum();
		}else{
			var errMessage = ComGetMsg('COM12122',val,'','');  
			ComShowMessage(errMessage);
			obj.value = "";
			obj.focus();
		}
	}

}



/**
 * 라디오버튼을 누를시 period
 */
function change_amount(){
	fn_checknum();
}


/**
 * 콤보박스 -bound
 */
function invoice_OnChang(obj){
	var codeval =obj.value;
	var formObject = document.form;

	formObject.hid_invoicemode.value=codeval;
	fn_checknum();
}



function fn_checknum(){

	var formObject = document.form;

	var x1 = formObject.ex_rate.value;		  //Exchange Rate
	var x2 = formObject.wo_totamount.value;   //W/O Total Amount 

	if( (x1 =="" && x2 =="") || (x1 =="" || x2 =="")  ){
		formObject.invoice_amount.value="";
	}else{
		if(formObject.woamount[0].checked){
			var tot_gum = x2*x1
		}else{
			if(x1 == "0"){
				var tot_gum = 0;
			}else{
				var tot_gum = x2/x1 ;
			}
		}
		formObject.invoice_amount.value=chkAmtPos(tot_gum, 4);
	}

}

/**
 * enter check
 **/
function enterCheck(obj)
{
	var formObj = document.form;

	if(event.keyCode == 13)
	{
		switch(obj.name){
			case 'ex_rate':
				fn_checknum();
				break;
		}
	}
}
