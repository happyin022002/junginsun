/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0009.js
*@FileTitle  : Basic Data Creation Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2015/01/20
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends 
 * @class ESM_CSQ_0009 : ESM_CSQ_0009 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
/* 개발자 작업	*/
var backEndJobKey="";
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick; 
function processButtonClick(){
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "f_bse_tp_cd":
				f_bse_tp_cd_OnChange();
			break;
			case "btn_Creation":
				doActionIBSheet(formObj, IBCREATE);
				break;
			case "btn_Close":
    	    	ComClosePopup(); 
    	        break;
		}
	} catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(ComGetMsg("COM12111", "", ""));
		} else {
			ComShowMessage(e.message);
		}
	}
}

function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++]=sheet_obj;
}

function loadPage(){
	var formObj=document.form;
	loadingMode=true;
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	ComSetObjValue(document.form.f_bse_tp_cd[0], p_bse_tp_cd);
	f_bse_tp_cd_OnChange();
	formObj.f_year.focus();
	initcontrol();
	loadingMode=false;
}
/**
 * Sheet 관련 프로세스 처리
 */
function doActionIBSheet(formObj, sAction) {
	switch(sAction) {
		case IBCREATE:          // Data Create 시
			if (!validateForm(formObj, sAction)) {
				return false;
			}
			ComOpenWait(true);
			formObj.f_cmd.value=MULTI;
			var sXml=sheet1.GetSearchData("ESM_CSQ_0009GS.do?", FormQueryString(formObj));
			var BatchStatus=ComGetEtcData(sXml, "BatchStatus");
			var State=ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
			ComOpenWait(false);
			if ( State == "S" ) {
				if ( BatchStatus == "13" ) {
					// 생성된 정보가 있습니다.
					ComShowCodeMessage('CSQ00018');
				} else if ( BatchStatus == "14" ) {
					// 사전 데이터가 존재하지 않습니다.
					ComShowCodeMessage('CSQ00019');
				} else if ( BatchStatus == "3" ) {
					// 배치가 수행되었습니다.
					ComShowCodeMessage('CSQ00020');
				}
			} else if ( State != "S" ) {
				ComShowMessage(ComResultMessage(sXml));
				ComClosePopup(); 
				return false;
			}
			break;
    }
}
/**
 *  f_year, f_week, f_duration 바뀌었을때 period 의 week 기간변경
 */
function period_OnChange(){
	var formObj=document.form;
	var year=formObj.f_year.value;
	var week=formObj.f_week.value;
	var dur=formObj.f_duration.value;
	if (week.length == 1) {
		week="0" + week;
		formObj.f_week.value=week;
	}
	if (year != "" && !ComIsNumber(year)) {
		ComShowMessage(ComGetMsg('CSQ00008', 'Year', 'YYYY'));
		formObj.f_year.value="";
		formObj.f_year.focus();
		return false;
	}
	if (week != "" && !ComIsNumber(week)) {
		ComShowMessage(ComGetMsg('CSQ00008', 'week', 'WW'));
		formObj.f_week.value="";
		formObj.f_week.focus();
		return false;
	}
	if (dur != "" && !ComIsNumber(dur)) {
		ComShowMessage(ComGetMsg('CSQ00007', 'Duration'));
		formObj.f_duration.value="";
		formObj.f_duration.focus();
		return false;
	}
	var param=year + week + "|" + dur;
	if(year != "" && week != "" && dur != ""){				
		var sXml=sheet1.GetSearchData("CommonGS.do", "f_cmd="+ SEARCH01 + "&code_name=cPeriod&code_param=" + param);
		var arrXml=sXml.split("|$$|");
		var arrData=ComXml2ComboString(arrXml[0], "code", "name");
		var arrWk=arrData[0].split("~");
		formObj.f_fm_wk.value=arrWk[0];
		formObj.f_to_wk.value=arrWk[1];
		document.getElementById("div_period2").innerHTML="(" + arrData[1] + ")";
	} else {
		document.getElementById("div_period2").innerHTML="&nbsp;";
	}
}

function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:		//sheet1 init
		    with(sheetObj){
				var HeadTitle="Status|Seq.|Code|Name";
				SetConfig( { SearchMode:2, MergeSheet:2, Page:20} );

				var info    = { Sort:1, ColMove:0, ColResize:1, HeaderCheck:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ {Type:"Status",    Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"FLG",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"SEQ",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"CODE",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"TEXT",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			      
				InitColumns(cols);
				SetSheetHeight(300);
				SetVisible(0);
				SetEditable(1);
			}
		    break;
	}
}
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(formObj, sAction){
	switch(sAction) {
		case IBCREATE:
			var year=formObj.f_year.value;
			var week=formObj.f_week.value;
			var dur=formObj.f_duration.value;
			if (!(year.length == 4) || !(ComParseInt(year) >= 1900 && ComParseInt(year) <= 9999)) {
				// msg1 + '을(를)  정확하게 입력하세요. 입력형식:' + msg2
				ComShowMessage(ComGetMsg('CSQ00008', 'Year', 'YYYY'));
				formObj.f_year.focus();
				return false;
			}
			if (!(week.length == 2) || !ComIsWeek(week)) {
				// msg1 + '을(를)  정확하게 입력하세요. 입력형식:' + msg2
				ComShowMessage(ComGetMsg('CSQ00008', 'Week', 'WW'));
				formObj.f_week.focus();
				return false;
			}
			if (dur == "") {
				// msg1 + '을(를)  정확하게 입력하세요. 입력형식:' + msg2
				ComShowMessage(ComGetMsg('CSQ00007', 'Duration'));
				formObj.f_duration.focus();
				return false;
			}
    		break;
	}
	return true;
}
/**
 * f_bse_tp_cd 바뀌었을때 qtr_cd, week 변경
 */
function f_bse_tp_cd_OnChange() {
	var formObj=document.form;
	var bse_tp_cd=ComGetObjValue(formObj.f_bse_tp_cd[0]);
	var div_qtr=document.getElementById("div_qtr");
	var div_period=document.getElementById("div_period");
	if (bse_tp_cd == "Y") {
		div_qtr.style.display="none";
		div_period.style.display="none";
		formObj.f_bse_qtr_cd.style.display="none";
	} else {
		div_qtr.style.display="inline";
		div_period.style.display="inline";
		formObj.f_bse_qtr_cd.style.display="inline";
	}
	period_change();
}
/* 개발자 작업  끝 */
