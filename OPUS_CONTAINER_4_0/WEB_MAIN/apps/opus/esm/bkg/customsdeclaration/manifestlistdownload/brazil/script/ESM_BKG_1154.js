/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1154.jsp
*@FileTitle  :  Multi NCM Input
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/19
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
     * @class ESM_BKG_1154 : esm_bkg_1154 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
// 공통전역변수
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){

	var opener=window.dialogArguments;
	if (!opener) opener=window.opener;
	if (!opener) opener = parent;

	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject=sheetObjects[0];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_add":
				sheetObject.DataInsert(-1);
				break;
			case "btn_delete":
				for( var idx=sheetObject.LastRow(); idx >= 0 + parseInt(sheetObject.HeaderRows()); idx-- ){
					if( sheetObject.GetCellValue(idx,"chk") == "1" ){
						sheetObject.RowDelete(idx, false);
					}
				}
				break;
			case "btn_apply":
				if (sheetObject.RowCount() == 0) {
					ComShowMessage(ComGetMsg("BKG00788", 'NCM'));
					return;
				}
				
				var dupNcm = sheetObject.ColValueDupRows("ncm_no", false, true);
				if (dupNcm != null && dupNcm != "") {	// 동일한 ncm no가 입력된경우
					ComShowCodeMessage("BKG00764","NCM code");
					return;
				}

				var ncmMultiStr = "";
				for ( var i = sheetObject.HeaderRows(); i <= sheetObject.LastRow(); i++) {
					if (sheetObject.GetCellValue(i, "ncm_no") == "") {
						ComShowMessage(ComGetMsg("BKG00788", 'NCM'));
						return;
					}
					ncmMultiStr = ncmMultiStr + sheetObject.GetCellValue(i, "ncm_no") + ",";
				}
				ncmMultiStr = ncmMultiStr.substr(0, ncmMultiStr.length - 1);

				// Apply 대상이 0건인지 여부 판단
				var org_sheet = opener.sheetObjects[0];
				 if (formObject.org_sheet.value == "1") {
					org_sheet = opener.sheetObjects[1];
				}
				 
				var org_row = formObject.org_row.value;

				org_sheet.SetCellValue(org_row, "ncm_multi_no", ncmMultiStr);
				org_sheet.SetCellValue(org_row, "ncm_no", ncmMultiStr.split(",")[0]);

				if (formObject.org_ui_id.value == "ESM_BKG_0079_07") {
					// 데이타 수정 여부 기록
					opener.form.dirty_flag.value = 'Y'
				} else {
					// Cell의 분홍색 지정 여부 판단
					if (ncmMultiStr.split(",").length > 1) {
						org_sheet.SetCellValue(org_row, "ncm_multi_flg", "Y", 0);
						org_sheet.SetCellBackColor(org_row, "ncm_no", "#FCC4F5");
					} else {
						org_sheet.SetCellValue(org_row, "ncm_multi_flg", "N", 0);
						org_sheet.SetCellBackColor(org_row, "ncm_no", "#FFFFFF");
					}
				}
				ComClosePopup(); 
				break;
			case "btn_close":
				ComClosePopup(); 
				break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * IBSheet Object를 배열로 등록
 * comSheetObject(id)에서 호출한다
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage(){
	for(i=0;i<sheetObjects.length;i++){
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
	initSet();
}
/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 */
function initControl() {
}
/**
 * HTML Control의 objClick이벤트에서 영문숫자만 입력 처리한다. <br>
 */
function obj_click() {
}
/**
 * HTML Control의 objKeyup이벤트에서 영문숫자만 입력 처리한다. <br>
 */
function obj_keyup() {
}
/**
 * HTML Control의 onBlur이벤트에서 Validation을 체크한다. <br>
 */
function obj_blur(){
}
/**
 * HTML Control의 onFocus이벤트에서 마스크 구분자를 제거한다. <br>
 */
function obj_focus(){
//            ComClearSeparator(event.srcElement);
}
//Axon 이벤트 처리2. 이벤트처리함수 --- end
/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:      //sheet1 init
			with (sheetObj) {
		    var HeadTitle1="|No.|NCM.";
		    var headCount=ComCountHeadTitle(HeadTitle1);

		    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

		    var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
		    var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		    InitHeaders(headers, info);

		    var cols = [ {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"chk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
		              {Type:"Seq",       Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
		              {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ncm_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4,	AcceptKeys:"N"} ];
		     
		    InitColumns(cols);
		    SetSheetHeight(300);
			SetEditable(1);
			
//conversion of function[check again]CLT 				InitDataValid(0, "ncm_no",  vtNumericOnly);
			}
		break;
	}
}
// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction,Row,Col) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case SEARCH02:		//Validation Check
				formObj.f_cmd.value=SEARCH02;
	 			var sXml=sheetObj.GetSearchData("ESM_BKG_0127GS.do", FormQueryString(formObj));
				var cmdt_desc=ComGetEtcData(sXml, "cmdt_desc");
				if( cmdt_desc == "" && sheetObj.GetCellValue(Row, "ncm_no") != "" ){
					ComShowCodeMessage("BKG06060", sheetObj.GetCellValue(Row, "ncm_no"));	//Invalid NCM Code(?msg1)
	    			sheetObj.SetCellValue(Row, "ncm_no","",0);
	    			sheetObj.SelectCell(Row, "ncm_no"); // 셀 포커스 주기
				}
		   		break;
		}
	}
/**
* 화면 폼입력값에 대한 유효성검증 프로세스 처리
*/
	function validateForm(sheetObj,formObj,sAction){
	//	switch(sAction){
	//		case MULTI:
	//			//그리드 데이터 없을 경우
	//			if( sheetObj.RowCount <= 0 ){
	//				return false;
	//			}
	//			break;
	//	}
		return true;
	}
	function initSet(){
		var ncmArr=document.form.ncm_multi_no.value.split(",");
		for( var idx=0; idx < ncmArr.length; idx++ ){
			sheetObjects[0].DataInsert(-1);
			sheetObjects[0].SetCellValue(idx+1,"ncm_no",ncmArr[idx],0);
		}
	}
/**
 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
	function sheet1_OnSearchEnd(sheetObj,errMsg) {
	}
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var formObject=document.form;
	    var colName=sheetObj.ColSaveName(Col);
	    switch(colName) {
	    	case "ncm_no" :
	    		formObject.brz_cmdt_cd.value=Value;
	    		doActionIBSheet(sheetObj, formObject, SEARCH02, Row, Col);
	    		break;
	    }
	}
	function sheet1_OnPopupClick(sheetObj, Row, Col)	{
	var colName=sheetObj.ColSaveName(Col);
  	switch(colName)
  	{
    	case "ncm_no":
    		var sUrl="/opuscntr/ESM_BKG_0745_P.do?page_gubun=popup&ncm_no="+sheetObj.GetCellValue(Row, 'ncm_no');
			var rtnVal=ComOpenWindowCenter(sUrl, "ESM_BKG_0745_P", 1024, 520, true);
			if( rtnVal != null ){
				sheetObj.SetCellValue(Row, 'ncm_no',rtnVal.cd,0);
				sheetObj.SetCellValue(Row, 'cstms_desc',rtnVal.nm,0);
				if( rtnVal.cd != "" ){
					sheetObj.SetCellValue(Row, 'ncm_multi_pop',"1",0);
				}
			}
			break;
  	}
}
	
function sheet1_SetValues(obj) {
	sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "ncm_no", obj.cd, 0);
	sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "cstms_desc", obj.nm, 0);
}
