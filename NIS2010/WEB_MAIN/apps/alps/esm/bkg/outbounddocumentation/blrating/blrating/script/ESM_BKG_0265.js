/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0265.js
 *@FileTitle : Freight & Charge_Freight & Charge Remark
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.26
 *@LastModifier : 이진서
 *@LastVersion : 1.0
 * 2009.06.26 이진서
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2012.11.08 조정민 [CHM-201220929] BKG History 추가 (Charge remark)
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
 * @class esm_bkg_0265 : esm_bkg_0265 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0265() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	
}

/* 개발자 작업	*/

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;
var sheetObjects = new Array();
var sheetCnt = 0;
var URL_ESM_BKG = 'ESM_BKG_0265GS.do';
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

//	document.form.bkg_no.value = 'SEL000101306';
	
	if (document.form.bkg_no.value == '') {
		ComShowCodeMessage("BKG00463");// 조회를 위한 BKG no가 없습니다.
		self.close();
	}
	initControl();
	
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}

	//[기능추가] by 신자영  [readOnly = Y]   save 버튼 비활성 
	//by 2010.2.22  김태경  주석처리요망  
	var formObj = document.form;	
	/*
	if("Y" == ComGetObjValue(formObj.readOnly)){
		ComBtnDisable("btn_save");// btn_save버튼막기 
		ComBtnDisable("btn_clause");// btn_clause 버튼막기
		formObj.inter_rmk.readOnly=true;//입력불가 		
		formObj.diff_rmk.readOnly=true;//입력불가 		
	}
	*/
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/**
* 초기 컨트롤 설정하기 
**/
function initControl() {
	axon_event.addListenerFormat('keypress','bkg0265_keypress',document.form); //- 키보드 입력할때
	axon_event.addListenerFormat('beforedeactivate','bkg0265_fncCheckLength',document.form); //- 키보드 입력할때
	axon_event.addListenerFormat('beforedeactivate','bkg0265_fncCheckLength',document.form); //- 키보드 입력할때
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	switch (sheetNo) {
	case 1: //t1sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 0;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(2, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			var HeadTitle1 = "";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtStatus,       60,   daLeft,    false,    "ibflag");
			InitDataProperty(0, cnt++, dtData, 0, daLeft, true, "no", false, "", dfNone, 0, false, false);
		}
		break;
	}
}

var Freight_Charge_Remark = '';
//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
	case IBSEARCH: //조회
		ComSetObjValue(formObj.f_cmd, SEARCH);
		var sXml = sheetObj.GetSearchXml(URL_ESM_BKG, FormQueryString(formObj));

		var BKG_NO = ComGetEtcData(sXml, "BKG_NO");
		if (BKG_NO == '')
			return;

		var BL_CVRD_TP_CD = ComGetEtcData(sXml, "BL_CVRD_TP_CD");
		var INTER_RMK = ComGetEtcData(sXml, "INTER_RMK");
		var DIFF_RMK = ComGetEtcData(sXml, "DIFF_RMK");
		var DOC_INTER_RMK = ComGetEtcData(sXml, "DOC_INTER_RMK");
		var MST_CVRD_BL_NO = ComGetEtcData(sXml, "MST_CVRD_BL_NO");
		var THIRD_PARTY_FREIGHT = ComGetEtcData(sXml, "THIRD_PARTY_FREIGHT");
		//1. Internal Memo for Reference
		if (typeof INTER_RMK != null && typeof INTER_RMK != "undefined" && INTER_RMK != "") {
			ComSetObjValue(formObj.inter_rmk, INTER_RMK);
		}
		//2. Freight & Charge Remark
		if (typeof DIFF_RMK != null && typeof DIFF_RMK != "undefined" && DIFF_RMK != "") {
			ComSetObjValue(formObj.diff_rmk, DIFF_RMK);
		}
		//3. MST_CVRD_BL_NO
		if (typeof MST_CVRD_BL_NO != null && typeof MST_CVRD_BL_NO != "undefined" && MST_CVRD_BL_NO != "") {
			Freight_Charge_Remark = Freight_Charge_Remark + MST_CVRD_BL_NO;
		}
		//4. THIRD_PARTY_FREIGHT
		if (typeof THIRD_PARTY_FREIGHT != null && typeof THIRD_PARTY_FREIGHT != "undefined" && THIRD_PARTY_FREIGHT != "") {
			Freight_Charge_Remark = Freight_Charge_Remark + '\r\n' + THIRD_PARTY_FREIGHT;
		}
		//Freight_Charge_Remark = Freight_Charge_Remark.split('\r\n').join("");
		//5. DOC CENTER Remark
		if (typeof DOC_INTER_RMK != null && typeof DOC_INTER_RMK != "undefined" && DOC_INTER_RMK != "") {
			ComSetObjValue(formObj.doc_inter_rmk, DOC_INTER_RMK);
		}
		break;

	case IBSAVE: //저장
	if (!ComShowConfirm(ComGetMsg("BKG00350")))
		return; // Are you sure to save the changes?

		ComSetObjValue(formObj.f_cmd, MULTI);
		var sXml = sheetObj.GetSaveXml(URL_ESM_BKG, FormQueryString(formObj));
		// 3.저장후 결과처리
		var State = ComGetEtcData(sXml,"TRANS_RESULT_KEY");
		if ( State == "S" ) {
			sheetObj.LoadSaveXml(sXml);
			ComShowMessage(ComGetMsg("BKG06071"));
		}else{
			fnExceptionMessage(sXml);
		}
		break;
	}
}

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	/*******************************************************/
	var formObject = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_save":
			doActionIBSheet(sheetObject, formObject, IBSAVE);
			break;

		case "btn_clause":
			if (!ComShowConfirm(ComGetMsg("BKG00197")))
				return; // Are you sure to save the changes?
			ComSetObjValue(formObject.diff_rmk, Freight_Charge_Remark);
			formObject.diff_rmk.focus();
			break;

		case "btn_close":
			window.close();
			break;

		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}
/**
* TEXTAREA의 자리수를 제한하기 위한 함수 정의.<br>
* @param {object} bytes
* @return number <br>
*/
function fncCheckLength(_obj, _maxlen) {
	var objname = _obj;
	cols = parseInt(objname.cols);
	rows = parseInt(objname.rows)-2;
	//var maxlen = cols * rows;
	var maxlen = _maxlen;
	var objstr = objname.value; // 입력된 문자열을 담을 변수 
	var objstrlen = objstr.length; // 전체길이 

	// 변수초기화 
	var bytesize = 0; // 바이트크기 
	var strlen = 0; // 입력된 문자열의 크기
	var onechar = ""; // char단위로 추출시 필요한 변수 
	var objstr2 = ""; // 허용된 글자수까지만 포함한 최종문자열

	try {
		// 입력된 문자열의 총바이트수 구하기
		for (i = 0; i < objstrlen; i++) {
			// 한글자추출 
			onechar = objstr.charAt(i);
			if (escape(onechar).length > 4) {
				bytesize += 2; // 한글이면 2를 더한다. 
			} else {
				bytesize++; // 그밗의 경우는 1을 더한다.
			}
			if (bytesize <= maxlen) { // 전체 크기가 maxlen를 넘지않으면 
				strlen = i + 1; // 1씩 증가
			}
		}
		// 총바이트수가 허용된 문자열의 최대값을 초과하면 
		if (bytesize > maxlen) { 
			objstr2 = objstr.substr(0, strlen);
			objname.value = objstr2;
		}
	} catch (ex) {
		return false;
	}
	objname.focus();
}
/**
 * ENTER 키값을 제한하기 위한 함수 정의.<br>
 * @param {object} bytes
 * @return number <br>
 */
function bkg0265_fncCheckLength() {
	var srcName = window.event.srcElement.getAttribute("name");
	if(srcName == "inter_rmk"){
		fncCheckLength(document.form.inter_rmk,'1000');
	}else if(srcName == "diff_rmk"){
		fncCheckLength(document.form.diff_rmk,'1000');
	}else if(srcName == "doc_inter_rmk"){
		fncCheckLength(document.form.doc_inter_rmk,'1000');
	}
}
/**
 * 한글, 영문길이를 알아내기 위한 함수 정의.<br>
 * @param {object} bytes
 * @return number <br>
 */
String.prototype.bytes = function() {
	var str = this;
	var l = 0;
	for ( var i = 0; i < str.length; i++)
		l += (str.charCodeAt(i) > 128) ? 2 : 1;
	return l;
}
 /**
  * 대문자 변환 함수 정의.<br>
  * @param 
  * @return  <br>
  */
 function bkg0265_keypress(){
 	var srcName = window.event.srcElement.getAttribute("name");
 	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
 	 if(keyValue >= 97 && keyValue <= 122) {//소문자
          event.keyCode = keyValue + 65 - 97;
      }
 }
  /**
  * fnExceptionMessage  
  * 에러처리 메세지 Alert
  * @param 
  * @return 
  */
  function fnExceptionMessage(rXml){
  	var rMsg = ComGetEtcData(rXml,"Exception");
  	var rmsg = rMsg.split("<||>");
  	if(rmsg[3] != undefined && rmsg[3].length > 0) {
  		ComShowMessage(rmsg[3]);
  	}else{
  		sheetObjects[0].LoadSaveXml(rXml);
  	}
  }
/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}
/* 개발자 작업  끝 */