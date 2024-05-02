/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0346.js
*@FileTitle  : Trans Cancellation To Korea Customs
*@author     : CLT
*@version    : 1.0
*@since      : 2014/10/07
=========================================================*/

/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/**
 * 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0431() {
	this.processButtonClick=processButtonClick;
	this.setSheetObject=setSheetObject;
	this.loadPage=loadPage;
	this.initSheet=initSheet;
	this.initControl=initControl;
	this.doActionIBSheet=doActionIBSheet;
	this.setTabObject=setTabObject;
	this.validateForm=validateForm;
	this.sheet1_OnClick=sheet1_OnClick;
	this.sheet1_OnMouseMove=sheet1_OnMouseMove;
}
/* 개발자 작업	*/
// 공통전역변수
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject=sheetObjects[0];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_transmit":
			doActionIBSheet(sheetObject, formObject, MULTI01);
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComFuncErrMsg(e);
		} else {
			ComFuncErrMsg(e);
		}
	}
}
/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 * @param sheet_obj IBSheet Object
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 * @param sAction 작업처리코드
 */
function loadPage(sAction) {
	for (i=0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
		sheetObjects[i].SetWaitImageVisible(0);
	}
	initControl();
}
function initControl() {
	var formObj=document.form;
	// 화면에서 필요한 이벤트
//	axon_event.addListenerForm("KeyUp", "obj_KeyUp", formObj);
//	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", formObj);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	// Request Date를 현재 날짜로 셋팅
	formObj.rqst_dt.value=ComGetNowInfo('ymd','-');
}
/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 * @param sheetObj 시트오브젝트
 * @param sheetNo 시트오브젝트 태그의 아이디에 붙인 일련번호
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch (sheetID) {
	case "sheet1": //sheet1 init
		with(sheetObj){

		  var HeadTitle="|Seq.|VVD|MRN No.|POL|ETD|RQST DATE|Local Customs||Master B/L Total|Empty B/L Total|Consol B/L Total|Simple B/L Total";
		  //var headCount=ComCountHeadTitle(HeadTitle);

		  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

		  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		  var headers = [ { Text:HeadTitle, Align:"Center"} ];
		  InitHeaders(headers, info);

		  var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"vvd" },
				 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"mrn_no" },
				 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"pol_cd" },
				 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"etd_dt" },
				 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"rqst_dt" },
				 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"locl_cstms_cd" },
				 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"locl_cstms_prt_cd" },
				 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"mst_bl_knt" },
				 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"mty_bl_knt" },
				 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cnsl_bl_knt" },
				 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"smp_bl_knt" } ];

		  InitColumns(cols);

		  SetEditable(0);
		  SetSheetHeight(380);
	   }
	break;
	}
}
/**
 * Sheet관련 프로세스 처리
 * @param sheetObj Sheet
 * @param formObj form객체
 * @param sAction 작업처리코드
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	//sheetObj.ShowDebugMsg = false;
	switch (sAction) {
	case MULTI01: // EDI Transmit
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			formObj.f_cmd.value=MULTI;
			saveParam(sheetObj);
			var sXml=sheetObj.GetSaveData("ESM_BKG_0346GS.do", FormQueryString(formObj));
			sheetObj.LoadSearchData(sXml,{Sync:1} );
			ComOpenWait(false);
		}
	break;
	}
}
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 * @param sheetObj Sheet
 * @param formObj form객체
 * @param sAction 작업처리코드
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case MULTI01:
		//기본포멧체크
		if (!ComChkValid(formObj))
			return false;
		if(!ComShowCodeConfirm("BKG08214"))
			return false;
	break;
	}
	return true;
}
/**
 * 조회조건 입력할 때 처리
 */
function obj_KeyUp() {
	 var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	 var formObject=document.form;
	var srcName=ComGetEvent("name");
	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
	var srcValue=window.event.srcElement.getAttribute("value");
	if (keyValue != 9 && keyValue !=16 &&ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}
/**
 * 마우스가 Sheet 위에서 움직일 때 발생하는 Event
 * @param sheetObj 시트오브젝트
 * @param Button 마우스버튼 방향
 * @param Shift Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
 * @param X X 좌표
 * @param Y Y 좌표
 */
function sheet1_OnMouseMove(Button, Shift, X, Y) {
	var sheetObj=sheetObjects[0];
	var row=sheetObj.MouseRow();
	var col=sheetObj.MouseCol();
	if (row > 0) {
		if (sheetObj.ColSaveName(col) == "cnd_ack_rcv_id") {
			sheetObj.SetToolTipText(row, col,sheetObj.GetCellText(row, "ack_desc"));
		} else if (sheetObj.ColSaveName(col) == "cnd_ack_sub_cd") {
			sheetObj.SetToolTipText(row, col,sheetObj.GetCellText(row, "result_desc"));
		} else if (sheetObj.ColSaveName(col) == "cstms_rjct_msg") {
			sheetObj.SetToolTipText(row, col,sheetObj.GetCellText(row, "err_cd_desc"));
		}
	}
}
/**
	 * 조회 완료후 실행
	 * Fax,Email에서 공통으로 사용하는 Customer Name을 해당 시트에 셋팅.
	 * @param sheetObj
	 * @param ErrMsg
	 */
	function saveParam(sheetObj) {
		var formObject=document.form;
		var maxRow=sheetObj.LastRow();
		var cellValue="";
		for(i=1;i <=maxRow ; i++){
			sheetObj.SetCellValue( i, "vvd",formObject.vvd.value,0);
			sheetObj.SetCellValue( i, "mrn_no",formObject.mrn_no.value,0);
			sheetObj.SetCellValue( i, "pol_cd",formObject.pol_cd.value,0);
			sheetObj.SetCellValue( i, "etd_dt",formObject.etd_dt.value,0);
			sheetObj.SetCellValue( i, "rqst_dt",formObject.rqst_dt.value,0);
			sheetObj.SetCellValue( i, "locl_cstms_cd",formObject.locl_cstms_cd.value,0);
			sheetObj.SetCellValue( i, "locl_cstms_prt_cd",formObject.locl_cstms_prt_cd.value,0);
			sheetObj.SetCellValue( i, "mst_bl_knt",formObject.mst_bl_knt.value,0);
			sheetObj.SetCellValue( i, "mty_bl_knt",formObject.mty_bl_knt.value,0);
			sheetObj.SetCellValue( i, "cnsl_bl_knt",formObject.cnsl_bl_knt.value,0);
			sheetObj.SetCellValue( i, "smp_bl_knt",formObject.smp_bl_knt.value,0);
			sheetObj.SetCellValue( i, "ibflag","U",0);
		}
	}
/**
 * 데이터 영역의 셀을 마우스로 더블클릭했을 때 발생하는 Event
 * @param sheetObj 시트오브젝트
 * @param row row Index
 * @param col col Index
 */
function sheet1_OnDblClick(sheetObj, row, col) {
var p1=sheetObj.GetCellValue(row, "cnd_ack_rcv_id");
var p2=sheetObj.GetCellValue(row, "ack_desc");
var p3=sheetObj.GetCellValue(row, "cnd_ack_sub_cd");
var p4=sheetObj.GetCellValue(row, "result_desc");
var p5=sheetObj.GetCellValue(row, "cnd_ack_err_note_desc");
var p6=sheetObj.GetCellValue(row, "cstms_rjct_msg");
var p7=sheetObj.GetCellValue(row, "err_cd_desc");
var p8=sheetObj.GetCellValue(row, "err_tp_ctnt");
var rcv_dt=sheetObj.GetCellValue(row, "dtl_rcv_dt");
var rcv_seq=sheetObj.GetCellValue(row, "rcv_seq");
	ComOpenWindowCenter("/clt/ESM_BKG_0433.do?pgmNo=ESM_BKG_0433&p1=" + p1 + "&p2=" + p2 + "&p3=" + p3 + "&p4=" + p4 + "&p5=" + p5 + "&p6=" + p6 + "&p7="
			+ p7 + "&p8=" + p8 + "&rcv_dt=" + rcv_dt + "&rcv_seq=" + rcv_seq, "04331", 520, 450, true);
}
