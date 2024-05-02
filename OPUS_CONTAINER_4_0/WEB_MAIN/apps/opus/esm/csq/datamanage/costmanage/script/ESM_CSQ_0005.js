/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName       : ESM_CSQ_0005.js
*@FileTitle      : New Office Creation
*@LastVersion    : 1.0
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends 
 * @class ESM_CSQ_0005 : ESM_CSQ_0005 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
	/* 개발자 작업	*/
	//공통전역변수
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick=processButtonClick;
	function processButtonClick(){
		var sheetObject=sheetObjects[0];
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
			case "f_bse_tp_cd":
				f_bse_tp_cd_OnChange();
				break;
			case "btn_Creation":
				doActionIBSheet(sheetObject, formObject, COMMAND01);
				break;
			case "btn_close":
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
	/**
	 * IBSheet Object 를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj){
	   sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * IBSheet Object 를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
	}
	
	function loadPage(){
		var formObject=document.form;
		loadingMode=true;
		doActionIBSheet(sheetObjects[0], formObject, IBCLEAR);
		for(k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],comboObjects[k].id);
		}
		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		loadingMode=false;
	}
	
	function initSheet(sheetObj, sheetNo) {
		var cnt = 0;
		switch(sheetNo) {
			case 1:		//sheet1 init
			    with(sheetObj){
		        var HeadTitle1="|bse_tp_cd|bse_yr|bse_qtr_cd";
		        SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );
		        var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
		        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		     	InitHeaders(headers, info);
		     	var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bse_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bse_yr",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"bse_qtr_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		     	InitColumns(cols);
		     	SetEditable(1);
        	}
		    break;
		}
	}
	/**
	* 멀티콤보 항목을 설정한다.
	*/
	function initCombo(comboObj, comboId) {
		switch(comboObj.options.id) {
			case "f_bse_yr":
			case "f_bse_qtr_cd":
				with (comboObj) {
					SetDropHeight(300);
				}
				break;
			default:
				with (comboObj) {
					SetDropHeight(300);
					SetSelectIndex(0);
				}
				break;
		}
	}
	/**
	 * Sheet 관련 프로세스 처리
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
		case IBCLEAR:          //조회
			sheetObj.SetWaitImageVisible(0);
			formObj.f_cmd.value=INIT;
			var sXml=sheetObj.GetSearchData("ESM_CSQ_0005GS.do", FormQueryString(formObj));
			// var State=ComGetEtcData(sXml, ComWebKey.Trans_Result_Key); 
			var arrXml=sXml.split("|$$|");
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], f_bse_yr, "code", "name");
			if (arrXml.length > 1)
				ComXml2ComboItem(arrXml[1], f_bse_qtr_cd, "code", "name");
			if (arrXml.length > 2)
				ComSetYearQta(arrXml[2]);
			break;
			
		case COMMAND01:          //  Creation
			if (ComShowConfirm (ComGetMsg("CSQ00009")) != 1) {
				return false;
			}
			ComOpenWait(true);
			formObj.f_cmd.value=COMMAND01;
			
			var opener=window.dialogArguments;
			if (!opener) opener = window.opener;  //이 코드 추가할것
			if (!opener) opener = parent; //이 코드 추가할것
			
			opener_sheet = opener.sheetObjects[0];
			var sParam = opener_sheet.GetSaveString(false, true, "sel");
			var sXml = sheetObjects[0].GetSaveData("ESM_CSQ_0005GS.do",FormQueryString(formObj) + "&" +sParam);
			var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
			ComOpenWait(false);
			if (State != "S"){
				ComShowMessage(ComResultMessage(sXml));
				return false;
			} else if(State == "S"){
				ComShowCodeMessage('CSQ00010','Data');
				ComClosePopup(); 
			}
			break;
	    }
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
			f_bse_qtr_cd.SetVisible(0);
		} else {
			div_qtr.style.display="inline";
			div_period.style.display="inline";
			f_bse_qtr_cd.SetVisible(1);
		}
		period_change();
	}
	/**
	 * f_bse_yr가 바뀌었을때 period 의 year 변경
	 */
	function f_bse_yr_OnChange(obj, value, text) {
		period_change();
	}
	/**
	 * f_bse_qtr_cd 바뀌었을때 period 의 week 기간변경
	 */
	function f_bse_qtr_cd_OnChange(obj, value, text) {
		period_change();
	}
	/* 개발자 작업  끝 */
