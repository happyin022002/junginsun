/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_gem_0110.js
 *@FileTitle : Expense Matrix Copy
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.15
 *@LastModifier : 최정미
 *@LastVersion : 1.0
 * 2009.05.15 최정미
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
 * @class Expense Matrix per Office : Expense Matrix per Office 생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function cps_gem_0110(){
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.doActionIBSheet = doActionIBSheet;
	this.initControl = initControl;
	this.processButtonClick = processButtonClick;
	this.validateForm = validateForm;
	
	// add
	this.obj_keypress = obj_keypress;
	this.obj_deactivate = obj_deactivate;
	this.obj_activate = obj_activate;
	
	this.newButtonClear = newButtonClear;
	this.getMatrixDiv = getMatrixDiv;
	this.isMatrixDivCheck = isMatrixDivCheck;
	
	// sheet
		
}

/* 개발자 작업 */

//===================================================================================
//공통전역변수
//===================================================================================
var sheetObjects = new Array();
var sheetCnt = 0;

var sheet1 = null;
var frm = null;

/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++] = sheet_obj;
}

//===================================================================================
//초기화 
//===================================================================================
/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
	frm = document.form;
	sheet1 = sheetObjects[0];	
	sheetCnt = sheetObjects.length ;
	
	// 시트의 초기화
	for(i=0;i<sheetCnt;i++){
		initSheet(sheetObjects[i],i+1);
        
	}

	// html컨트롤 이벤트초기화
    initControl();
}

/**
* 시트 초기설정값, 헤더 정의
* @param {ibsheet} sheetObj  sheet
* @param {int} sheetNo 시트번호
*/
function initSheet(sheetObj, sheetNo) {
	with (sheetObj) {
		switch (sheetObj.id) {
		case "sheet1":
          if (location.hostname != "") {
          	InitHostInfo(location.hostname, location.port, page_path);
          }
			break;
		}
	}
}

//Sheet관련 프로세스 처리
function doActionIBSheet(sAction) {
	switch (sAction) {		
		case IBINSERT: // 입력
			if(validateForm(sAction)) {				
				// GEM00014	ENG	I	Do you want to execute?
				if(!ComShowCodeConfirm("GEM00014")) return;
				
				frm.f_cmd.value = MULTI;
				var sXml = sheet1.GetSearchXml("CPS_GEM_0110GS.do", FormQueryString(frm),-1,false);
				var insCnt = ComGetEtcData(sXml, "insCnt");
				if(insCnt=="0") {
					//GEM01087	ENG	W	There is no contents to save.
					ComShowCodeMessage("GEM01087");
				} else {
					//GEM00008	ENG	W	Data was saved successfully.
					ComShowCodeMessage("GEM00008");
					
					// sheet1
					sheet1.LoadSearchXml(arrXml[0]);
				}			
			}
			break;
		case SEARCHLIST01: // From Office Code 조회
			var obj = frm.from_ofc_cd;
			var ofc_cd = obj.value;
			if(ofc_cd.length >= 4) {
				frm.f_cmd.value = SEARCHLIST07;
				var sXml = sheet1.GetSearchXml("CPS_GEM_0007GS.do?ofc_cd=" + ofc_cd, FormQueryString(frm));
				var errCode = ComGetEtcData(sXml, "code");
				frm.errCode.value = errCode;
				
				if(!isOfficeCodeChk('1')) return;
			}			
			break;
		case SEARCHLIST02: // To Office Code 조회
			var obj = frm.to_ofc_cd;
			var ofc_cd = obj.value;
			if(ofc_cd.length >= 4) {
				frm.f_cmd.value = SEARCHLIST07;
				var sXml = sheet1.GetSearchXml("CPS_GEM_0007GS.do?ofc_cd=" + ofc_cd, FormQueryString(frm));
				var errCode = ComGetEtcData(sXml, "code");
				frm.errCode.value = errCode;
				
				if(!isOfficeCodeChk('2')) return;
			}			
			break;
	}
}

//===================================================================================
//Form 이벤트 처리
//===================================================================================
/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 **/
function initControl() {
	//** Date 구분자 **/
 	DATE_SEPARATOR = "/";
 	
    //Axon 이벤트 처리1. 이벤트catch
	//axon_event.addListenerForm('beforedeactivate',	'obj_deactivate',	form); //- 포커스 나갈때
	//axon_event.addListenerForm('beforeactivate',	'obj_activate',		form); //- 포커스 들어갈때
	axon_event.addListenerForm('keypress',			'obj_keypress',		form); //- 키 눌렸을때
	//axon_event.addListenerForm('keyup',				'obj_keyup',		form); //- 키 올라올때
	//axon_event.addListener('change',   'obj_change',  'agmt_seq'); //- 변경될때.
}

/**
* HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
**/
function obj_keypress(){
	switch (event.srcElement.name) {    
	    case "from_ofc_cd":
	    	ComKeyOnlyAlphabet('upper');
	    	
	    	if(event.keyCode == 13) {
	    		var obj1 = frm.from_ofc_cd;
				if(obj1.value == "") {
					// {?msg1} 를 입력하여주시기 바랍니다
					ComShowCodeMessage("GEM00009","From Office");
					obj1.focus();
					return;
				}
				
	    		frm.to_ofc_cd.focus();
	    		doActionIBSheet(SEARCHLIST01);
	    	}
	    	
			break;
	    case "to_ofc_cd":
	    	ComKeyOnlyAlphabet('upper');
	    	
	    	if(event.keyCode == 13) {
	    		var obj2 = frm.to_ofc_cd;
				if(obj2.value == "") {
					// {?msg1} 를 입력하여주시기 바랍니다
					ComShowCodeMessage("GEM00009","To Office");
					obj2.focus();
					return;
				}
				
	    		doActionIBSheet(SEARCHLIST02);
	    	}
	    	
			break;
	}
}

/**
* HTML Control Focus out
**/
function obj_deactivate() {
	/*
	alert("obj_deactivate");
	switch (event.srcElement.name) {
		case "from_ofc_cd":
			doActionIBSheet(SEARCHLIST01);
			break;
		case "to_ofc_cd":
			doActionIBSheet(SEARCHLIST02);
			break;
		default:
			//ComChkObjValid(event.srcElement);
	}
	*/
}

/**
* HTML Control Foucs in
*/
function obj_activate(){
	/*
	alert("obj_activate");
	switch (event.srcElement.name) {
		case "from_ofc_cd":
			if(!isOfficeCodeChk('1')) return;
			//doActionIBSheet(SEARCHLIST01);
			break;
		case "to_ofc_cd":
			if(!isOfficeCodeChk('2')) return;
			//doActionIBSheet(SEARCHLIST02);
			break;
		default:
			//ComChkObjValid(event.srcElement);
	}
	*/
}

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	try	{
		var srcName = window.event.srcElement.getAttribute("name");
		
		switch (srcName) {	
			case "btn_Confirm":		
				doActionIBSheet(IBINSERT);
				break;
			case "btn_Reset":
				// Do you want to initialize unsaved data?
				if(!ComCodeMsgByInitializeUnsaved()) return;
				ComResetAll();
				newButtonClear();
				break;
			case "btn_Close":		
				self.close();	
				break;
		}
	}
	catch (e){
		if (e == "[object Error]") {
			// 지금은 사용하실 수가 없습니다.
			ComCodeMsgByNoUsed();
		}
	}
}

//===================================================================================
//Private function
//===================================================================================
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sAction) {
	if (!ComChkValid(frm)) return false;
	
	if(sAction == IBINSERT) {
		if(getMatrixDiv("matrix_div") == "I") {
			var obj = frm.to_ofc_cd;
			if(obj.value == "") {
				// {?msg1} 를 입력하여주시기 바랍니다
				ComShowCodeMessage("GEM00009","To Office");
				obj.focus();
				return false;
			}
		} else {
			var obj1 = frm.from_ofc_cd;
			if(obj1.value == "") {
				// {?msg1} 를 입력하여주시기 바랍니다
				ComShowCodeMessage("GEM00009","From Office");
				obj1.focus();
				return false;
			}
			if(obj1.value.length < 4) {
				// {?msg1} 를 입력하여주시기 바랍니다
				ComShowCodeMessage("GEM00001","From Office");
				obj1.focus();
				return false;
			}
			var obj2 = frm.to_ofc_cd;
			if(obj2.value == "") {
				// {?msg1} 를 입력하여주시기 바랍니다
				ComShowCodeMessage("GEM00009","To Office");
				obj2.focus();
				return false;
			}
			if(obj2.value.length < 4) {
				// {?msg1} 를 입력하여주시기 바랍니다
				ComShowCodeMessage("GEM00001","To Office");
				obj2.focus();
				return false;
			}
			if(obj1.value == obj2.value) {
				// {?msg1} 입력 데이터가 중복되었습니다.
				ComShowCodeMessage("GEM00002","Office Code");
				obj2.focus();
				return false;
			}
			if(frm.errCode.value != "2") {
				//GEM01015	ENG	W	오피스코드가 존재 하지 않습니다.
				ComShowCodeMessage("GEM01015");
				obj2.focus();
				return false;
			}
		}		
	} 
	return true;
}

/**
* New버튼 클릭시 초기화 이벤트
*/
function newButtonClear() {
	// from_ofc_cd
	// 초기 Disabled
	ComEnableObject(frm.from_ofc_cd, true);
	var obj = frm.from_ofc_cd;
	obj.value = "";
	obj.focus();
}

/**
 * Matrix Div값 Check
 * @param col
 * @return
 */
function getMatrixDiv(col) {
	var matrixDiv = "";
	var c = document.getElementsByName(col);
	for (var i = 0; i < c.length; i++)	{
		if(c[i].checked == true) {
			matrixDiv = c[i].value;
			break;
		}
	}
	return matrixDiv;
}

/**
 * Matrix Div 값을 Check해서 Office Code활성화 구분
 * @param val
 * @return
 */
function isMatrixDivCheck(val) {
	var getName = val.name;
	var getValue = val.value;
	
	if(getValue == "I") {
		ComEnableObject(frm.from_ofc_cd,  false);
		var obj = frm.from_ofc_cd;
		obj.value = "";
		frm.to_ofc_cd.focus();
	} else if(getValue == "C"){
		ComEnableObject(frm.from_ofc_cd,  true);
		var obj = frm.from_ofc_cd;
		obj.focus();
	}
}

function isErrorCodeChk(arg) {
	if(arg=="1") {
		var obj1 = frm.from_ofc_cd;
		if(obj1.value == "") {
			// {?msg1} 를 입력하여주시기 바랍니다
			ComShowCodeMessage("GEM00009","From Office");
			obj1.focus();
			return;
		}

		frm.to_ofc_cd.focus();
		doActionIBSheet(SEARCHLIST01);		
	} else {
		var obj2 = frm.to_ofc_cd;
		if(obj2.value == "") {
			// {?msg1} 를 입력하여주시기 바랍니다
			ComShowCodeMessage("GEM00009","To Office");
			obj2.focus();
			return;
		}
		
		doActionIBSheet(SEARCHLIST02);
	}
}

function isOfficeCodeChk(arg) {
	if(frm.from_ofc_cd.value == "" && frm.to_ofc_cd.value == "") {
		frm.errCode.value = "";
	}
	var errCode = frm.errCode.value;
	if(errCode == "2") {
		frm.to_ofc_cd.focus();
	} else {
		if (errCode == "0") {
			//GEM01015	ENG	W	오피스코드가 존재 하지 않습니다.
			ComShowCodeMessage("GEM01015");
			if(arg=="1") {
				frm.from_ofc_cd.value = "";
				frm.from_ofc_cd.focus();
			} else {
				frm.to_ofc_cd.value = "";
				frm.to_ofc_cd.focus();
			}
			return false;
		} else if (errCode == "1") {
			//GEM01016	ENG	W	삭제된 오피스코드 입니다.
			ComShowCodeMessage("GEM01016");
			if(arg=="1") {
				frm.from_ofc_cd.value = "";
				frm.from_ofc_cd.focus();
			} else {
				frm.to_ofc_cd.value = "";
				frm.to_ofc_cd.focus();
			}
			return false;
		}
	}
	return true;
}
//===================================================================================
//Sheet 이벤트 처리
//===================================================================================

/* 개발자 작업 끝 */