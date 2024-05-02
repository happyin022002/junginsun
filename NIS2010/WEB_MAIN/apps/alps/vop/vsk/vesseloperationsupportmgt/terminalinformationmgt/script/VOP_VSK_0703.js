/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_vsk_0703.js
*@FileTitle : Berth window input 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.06.01 장석현
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author 한진해운
     */

    /**
     * @extends 
     * @class vop_vsk_0703 : vop_vsk_0703 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_vsk_0703() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
		this.setComboObject			= setComboObject;
    }
    
   	/* 개발자 작업	*/

// 공통전역변수

var sheetObjects = new Array();
var sheetCnt = 0;


var comboObjects = new Array();
var comboCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		        var sheetObject1  = sheetObjects[0];   //sheet1
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

					switch(srcName) {
						case "btn_ok":
							setOpnerValue();
							window.close();
					
						case "btn_close":
							window.close();
						break;

            } // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
    }

    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){

       sheetObjects[sheetCnt++] = sheet_obj;

    }

	function initCombo(comboObj, comboNo) {
		var i=0;
		with(comboObj) {
			style.width = 100;

			var arrWeek = window.dialogArguments.marrWeekNm;
			for(var cnt = 0; cnt < arrWeek.length; cnt++){
				InsertItem(i++,  arrWeek[cnt].toUpperCase(),   arrWeek[cnt].toUpperCase());
			}
		}
	}

	/**
     * IBCombo Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
	function setComboObject(combo_obj){
	   comboObjects[comboCnt++] = combo_obj;
	}
    /**
     * vop_vsk_0007.ui에서 넘어온 값을 세팅...
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}

		var openerSheet = window.dialogArguments.document.t4sheet1;
		var frm = document.form;
		with(openerSheet){
			frm.loc_cd.value			=	CellValue(SelectRow, "t4sheet1_loc_cd");
			frm.yd_cd.value             =	CellValue(SelectRow, "t4sheet1_yd_cd");
			frm.skd_dir_cd.value        =	CellValue(SelectRow, "t4sheet1_skd_dir_cd");
			frm.crr_cd.value            =	CellValue(SelectRow, "t4sheet1_crr_cd");
			frm.etb_dy_cd.Code			=	CellValue(SelectRow, "t4sheet1_etb_dy_cd");
			frm.etd_dy_cd.Code			=	CellValue(SelectRow, "t4sheet1_etd_dy_cd");
			frm.etb_tm_hrmnt.value		=	CellText(SelectRow, "t4sheet1_etb_tm_hrmnt").substring(0, 2);
			frm.etd_tm_hrmnt.value		=	CellText(SelectRow, "t4sheet1_etd_tm_hrmnt").substring(0, 2);
		}
		axon_event.addListenerForm  ('blur',		'obj_deactivate',  form); //- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
        axon_event.addListenerFormat('focus',		'obj_activate',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate(focus)이벤트에 코드 처리
        axon_event.addListenerFormat('keypress',    'obj_keypress', 	form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		if(document.form.enableForm.value == "N"){
			frm.etb_dy_cd.Enable = false;
			frm.etd_dy_cd.Enable = false;
			frm.etb_tm_hrmnt.disabled = true;
			frm.etd_tm_hrmnt.disabled = true;
		}
    }
    /**
     * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
     **/
    function obj_activate(){
        //마스크구분자 없애기
        ComClearSeparator(event.srcElement);
		event.srcElement.select();
    }
    /**
     * HTML Control의 onfocus이벤트에서 마스크 구분자를 살려주며. Validate를 체크하여준다.
     **/
	function obj_deactivate(){
		if(event.srcElement.name == "etb_tm_hrmnt" || event.srcElement.name == "etd_tm_hrmnt"){
			if(parseInt(event.srcElement.value) < 10){
				event.srcElement.value = "0" + parseInt(event.srcElement.value);
			}else if(parseInt(event.srcElement.value) > 23){
				var sMsg = "'" + event.srcElement.caption + "' is not valid. Please enter a correct Hour."
				ComShowMessage(sMsg);
				event.srcElement.select();
			}
		}
	}
    /**
     * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
     **/
    function obj_keypress(){
    	switch(event.srcElement.dataformat){
			case "int":
		        //숫자 만입력하기
		        ComKeyOnlyNumber(event.srcElement);
				break;
			case "float":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
			default:
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
    	}
    }

	function setOpnerValue(){
		var openerSheet = window.dialogArguments.document.t4sheet1;
		var frm = document.form;
		with(openerSheet){
			var prefix = "t4sheet1_";

			CellValue(SelectRow, prefix + "etb_dy_cd")  	=	frm.etb_dy_cd.Code;			
			CellValue(SelectRow, prefix + "etd_dy_cd")  	=	frm.etd_dy_cd.Code;			
			CellText(SelectRow, prefix + "etb_tm_hrmnt")	=	frm.etb_tm_hrmnt.value + "00";		
			CellText(SelectRow, prefix + "etd_tm_hrmnt")	=	frm.etd_tm_hrmnt.value + "00";		
			
			for(var col = parseInt(SaveNameCol(prefix + "etd_tm_hrmnt")) + 1; col <= LastCol; col++){
				//색상변경시 에디트 가능은 EditableColor 불능은 UnEditableColor 
				CellBackColor(SelectRow, col) = UnEditableColor;
				CellValue(SelectRow, col) = "";
			}

			var amPmS = parseInt(CellValue(SelectRow, prefix + "etb_tm_hrmnt").substring(0, 2)) < 12 ? "am" : "pm";
			var amPmE = parseInt(CellValue(SelectRow, prefix + "etd_tm_hrmnt").substring(0, 2)) < 12 ? "am" : "pm";
			var colName3 = prefix +  "etd_tm_" + CellValue(SelectRow, prefix + "etb_dy_cd").toLowerCase() + "_"  + amPmS;
			var colName4 = prefix +  "etd_tm_" + CellValue(SelectRow, prefix + "etd_dy_cd").toLowerCase() + "_"  + amPmE;

			window.dialogArguments.sheetSetBackColor(openerSheet, SelectRow, colName3, colName4);

			for(var col = SaveNameCol(prefix + "etd_tm_sun_am"); 
					col <= SaveNameCol(prefix + "etd_tm_sat_pm"); col++){
				CellValue(SelectRow, col) = "    ";
			}
			
			if(colName3 == colName4){
				CellValue(SelectRow, colName3) = CellValue(SelectRow, prefix + "etb_tm_hrmnt").substring(0, 2) + "/" + CellValue(SelectRow, prefix + "etd_tm_hrmnt").substring(0, 2);
			}else{
				CellValue(SelectRow, colName3) = CellValue(SelectRow, prefix + "etb_tm_hrmnt").substring(0, 2);
				CellValue(SelectRow, colName4) = CellValue(SelectRow, prefix + "etd_tm_hrmnt").substring(0, 2);
			}
			
			window.dialogArguments.sheetSetForeColor(openerSheet, SelectRow, colName3, colName4);
		}
		
	}
	/* 개발자 작업  끝 */