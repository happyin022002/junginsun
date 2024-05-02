/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : ESM_BKG_0578.js
 *@FileTitle : ESM_BKG_0578
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.24
 *@LastModifier :
 *@LastVersion : 1.0
 * 2009.08.24
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
 * @class ESM_BKG_0578 : ESM_BKG_0578 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0578() {
	this.processButtonClick=processButtonClick;
	this.setSheetObject=setSheetObject;
	this.loadPage=loadPage;
	this.initSheet=initSheet;
	this.initControl=initControl;
	this.doActionIBSheet=doActionIBSheet;
	this.setTabObject=setTabObject;
	this.validateForm=validateForm;
}
//공통전역변수
var sheetObjects=new Array();
var sheetCnt=0;
//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	 var sheetObject=sheetObjects[0];
	 /*******************************************************/
	 var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn1_Retrieve":
					doActionIBSheet(sheetObject, formObject, IBSEARCH);
					break;
				case "btn1_DownExcel":
					doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
					break;
				case "btn_calendar":
					var cal=new ComCalendarFromTo();
					cal.select(formObject.snd_dt_from, formObject.snd_dt_to, 'yyyy-MM-dd');
					break;
					break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * 조회조건 visible
 * @param searchType ()
 * @return
 */
function visibleFalse() {
	var formObject=document.form;
	//날짜 셋팅
	if(formObject.snd_dt_from.value == "" && formObject.snd_dt_to.value == "") {
		initSearchDate();
	}
}
/**
 * IBSheet Object를 배열로 등록
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
function loadPage() {
	var formObj=document.form;
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	//화면에서 필요한 이벤트
	axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	//alert("dtype : " + dType);
}
/**
 * 화면 로딩 완료 후 이벤트
 * @param sheetObj
 * @return
 */
///////////////////////////////////////////no support[check again]CLT function sheet1_OnLoadFinish(sheetObj) {
	var formObj=document.form;
	//  선택적 필수 조회조건 셋팅
	visibleFalse();
 }
/**
 * declaration 필드 선택값 리턴
 *
 * @return
 */
function declarationCheckValue() {
	var formObj=document.form;
	var retVal="";
	for ( var i=0; i <= 5; i++) {
		var dTypeFlag="formObj.d_type" + i + ".checked";
		var dTypeValue="formObj.d_type" + i + ".value";
		if (eval(dTypeFlag)) {
			retVal += eval(dTypeValue);
		}
	} // end for(i)
	return retVal;
}
/**
 * 날자 셋팅
 * @return
 */
function initSearchDate() {
	document.form.snd_dt_from.value=ComGetDateAdd(null, 'd', -7, '-');
	document.form.snd_dt_to.value=ComGetNowInfo('ymd','-');
}
/**
 * 날자 범위 검증(한달)
 * @return
 */
function validateSearchDate() {
//	document.form.snd_dt_from.value=ComGetDateAdd(null, 'd', -7, '-');
//	document.form.snd_dt_to.value=ComGetNowInfo('ymd','-');
	var formObj=document.form;
	var fromDt=formObj.snd_dt_from.value;
	var toDt=formObj.snd_dt_to.value;
	var retVal=ComGetDaysBetween(fromDt, toDt);
	//alert("retVal : " + retVal);
}
/**
  * 시트 초기설정값, 헤더 정의
  * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
  * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
  */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	var sheetId=sheetObj.id;
	switch(sheetId) {
		case "sheet1":
							with(sheetObj){
														SetSheetHeight(380);
										  var HeadTitle1="|Seq|Vessel Name|I/VVD|O/VVD|Declaration\nType|Status|ACK Date|Error MSG|Error Cntr No.|Total\nSubmitted Count|Total\nError|Total\nSucess";
										  var headCount=ComCountHeadTitle(HeadTitle1);
										  (headCount, 0, 0, true);

										  SetConfig( { SearchMode:2, FrozenCol:6, MergeSheet:5, Page:20, DataRowMerge:1 } );

										  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
										  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
										  InitHeaders(headers, info);

										  var cols = [ {Type:"Status",    Hidden:1, Width:1,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"rcv_log_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"psa_vsl_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ib_vvd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ob_vvd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_hndl_knd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"err_cntr_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cre_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:270,  Align:"Left",    ColMerge:1,   SaveName:"cstms_err_msg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"cntr_ttl_knt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_ttl_err_knt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_ttl_scs_knt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];

										  InitColumns(cols);

										  SetEditable(1);
										  SetGetCountPosition()(2);
																					InitViewFormat(0, "cre_dt", "yyyymmdd");
										  SetGetShowButtonImage()(1);


		}
		break;
	}
}
// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH:      //조회
			if(!validateForm(sheetObj,formObj,sAction)) return false;
			formObj.f_cmd.value=SEARCH;
//parameter changed[check again]CLT 			var sXml=sheetObj.GetSearchData("ESM_BKG_0578GS.do", FormQueryString(formObj));
			sheetObj.LoadSearchData(sXml,{Sync:1} );
			break;
		case IBDOWNEXCEL: // 엑셀
			if(!validateForm(sheetObj,formObj,sAction)) return false;
//method change[check again]CLT 			sheetObj.Down2Excel({ HiddenColumn:0,TreeLevel:false});
			break;
	}
}
/**
 * 시트를 클릭했을 때 처리
 */
function sheet1_OnClick(sheetObj, row, col) {
	var rowCnt=sheetObj.RowCount();
	var colSaveName=sheetObj.ColSaveName(col);
	/* Row Focus 색상 및 글자  기본값으로 변경 */
//no support[implemented common]CLT 	sheetObj.SelectFontBold=false;
//no support[implemented common]CLT 	sheetObj.SelectBackColor="16186087";
	switch(colSaveName) {
		/* 긴 문자열 MemoPad 처리*/
		case "cstms_err_msg" :
if(sheetObj.GetCellValue(row,col) == "") return false;
			ComShowMemoPad(sheetObj, null, null, true, 400, 100);
			break;
	} // end switch
}
/**
 * 조회 후 이벤트
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	if(ErrMsg == "") {
		var rowCnt=sheetObj.RowCount();
		/*
		 * status 값 셋팅
		 */
//		for(var i = 0; i <= rowCnt; i++) {
//
//
//
//		} // end for(i)
	}
}
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	switch (sAction) {
		case IBSEARCH:
			if(!ComChkObjValid(formObj.snd_dt_from) || !ComChkObjValid(formObj.snd_dt_to)) return false;
			// from - to 범위값이 31일이 넘으면 오류
			if(ComGetDaysBetween(formObj.snd_dt_from.value, formObj.snd_dt_to.value) > 30) {
				ComShowCodeMessage('BKG00605');
				ComSetFocus(formObj.snd_dt_to);
				return false;
			}
			break;
		case IBDOWNEXCEL:
			var rowCnt=sheetObj.RowCount();
			if(rowCnt == 0) {
				ComShowCodeMessage('BKG00095');
				return false;
			}
			break;
	} // end switch
	return true;
}
