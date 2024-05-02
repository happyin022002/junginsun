/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0001.js
*@FileTitle  : Basic Data Relation Setting
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

/* 개발자 작업	*/
//공통전역변수
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
function processButtonClick(){
	var sheetObj=sheetObjects[0];
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "f_bse_tp_cd":
				f_bse_tp_cd_OnChange();
				break;
			case "btn_Retrieve":
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
				break;
			case "btn_Save":
				doActionIBSheet(sheetObj, formObj, IBSAVE);
				break;
			case "btn_PreQTACopy":
				doActionIBSheet(sheetObj, formObj, "IBCOPY");
				break;
			case "btn_DownExcel":
				if(sheetObj.RowCount() < 1){
					ComShowCodeMessage("COM132501");
		        } else{
		        	doActionIBSheet(sheetObj, formObj, IBDOWNEXCEL);
		        }
				break;
			case "btn_RowAdd":
				doActionIBSheet(sheetObj, formObj, IBINSERT);
				break;
		}
	} catch(e) {
		if ( e == "[object Error]") {
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
	var formObj=document.form;
	loadingMode=true;
	for(i=0;i<sheetObjects.length;i++){
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);
	for(k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],comboObjects[k].id);
	}
	toggleButtons("INIT");
	loadingMode=false;
	resizeSheet();
}
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:		//sheet1 init
		    with(sheetObj){
				var bse_tp_cd = ComGetObjValue(document.form.f_bse_tp_cd[0]);
				var HeadTitle="DEL|STS|SEQ|Year|Quarter|Office View|Trade|Lane Bound|RHQ|HO teams|N.OB/OB|";
				var headCount = ComCountHeadTitle(HeadTitle);
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
				var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ {Type:"DelCheck",  Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Status",    Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bse_yr",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bse_qtr_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"ComboEdit", Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"ofc_vw_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Combo", Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
				             {Type:"ComboEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"conv_dir_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
				             {Type:"ComboEdit", Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rhq_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
				             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"team_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
				             {Type:"ComboEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ob_div_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"",  		Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 }];
   
				InitColumns(cols);
				SetSheetHeight(400);
				SetColProperty(0 ,"team_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
				SetColProperty(0 ,"trd_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
				SetColProperty(0 ,"conv_dir_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
				SetColProperty(0 ,"rhq_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
				SetColProperty(0 ,"ob_div_cd" , {AcceptKeys:"E|[/.]" , InputCaseSensitive:1});
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
		case "f_ofc_vw_cd":
			with (comboObj) {
				SetDropHeight(300);
				SetSelectIndex(1);
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
		case IBCLEAR:           // 화면 접속 시
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.f_cmd.value=INIT;
			
			var sXml=sheetObj.GetSearchData("ESM_CSQ_0001GS.do", FormQueryString(formObj));
			var arrXml=sXml.split("|$$|");
			
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], f_bse_yr, "code", "name");
			if (arrXml.length > 1)
				ComXml2ComboItem(arrXml[1], f_bse_qtr_cd, "code", "name");
			if (arrXml.length > 2)
				ComSetYearQta(arrXml[2]);
			if (arrXml.length > 3)
				ComXml2ComboItem(arrXml[3], f_ofc_vw_cd, "code", "name");
			if (arrXml.length > 4)
				ComXml2ComboItem(arrXml[4], f_trd_cd, "code", "name");
			if (arrXml.length > 5)
				ComXml2ComboItem(arrXml[5], f_dir_cd, "code", "name");
			if (arrXml.length > 6)
				ComXml2ComboItem(arrXml[6], f_ho_team_cd, "code", "name");
			if (arrXml.length > 7)
				ComXml2ComboItem(arrXml[7], f_rhq_cd, "code", "name");
			if (arrXml.length > 8)
				ComXml2ComboItem(arrXml[8], f_ob_div_cd, "code", "name");
			
			// Row Add 세팅
			if (arrXml.length > 3)
				ComCsqSetIBCombo(sheetObj, arrXml[3], "ofc_vw_cd");
			if (arrXml.length > 9)
				ComCsqSetIBCombo(sheetObj, arrXml[9], "trd_cd", true);
			if (arrXml.length > 10)
				ComCsqSetIBCombo(sheetObj, arrXml[10], "conv_dir_cd", true);
			if (arrXml.length > 11)
				ComCsqSetIBCombo(sheetObj, arrXml[11], "rhq_cd", true);
			if (arrXml.length > 12)
				ComCsqSetIBCombo(sheetObj, arrXml[12], "ob_div_cd", true);
			ComOpenWait(false);
			break;
		case IBSEARCH:          // 화면 조회
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
			toggleButtons("INIT");
			searchParams=FormQueryString(formObj);
			
			var rtnXml=sheetObj.GetSearchData("ESM_CSQ_0001GS.do", searchParams);
			sheetObj.LoadSearchData(rtnXml,{Sync:1} );
			
			if (ComGetObjValue(document.form.f_bse_tp_cd[0]) == "Y") {
				sheetObj.SetColHidden("bse_qtr_cd",1);
			} else {
				sheetObj.SetColHidden("bse_qtr_cd",0);
			}
			var etcData=getEtcData(rtnXml);
			if (etcData["dataCnt"] == 0) {
				toggleButtons("COPY");
			} else {
				toggleButtons("SEARCH");
			}
			
			ComOpenWait(false);
			break;
		case IBSAVE:			// 저장
			if (!validateForm(sheetObj, formObj, sAction)) {
				return false;
			}
			var saveStr = sheetObj.GetSaveString(false, true, "ibflag");
			if ( saveStr == "" ) {
				return;
			}
			if (sheetObj.IsDataModified()== false) {
				ComShowCodeMessage("CSQ00006");
		        return false;
		    } else if (ComShowConfirm (ComGetMsg("CSQ00004")) != 1) {
				return false;
		    }
			
			ComSetSearchParams("f_cmd", MULTI);
			ComOpenWait(true);
			var sXml=sheetObj.GetSaveData("ESM_CSQ_0001GS.do", searchParams + "&" + saveStr);
			ComOpenWait(false);
			
			var State=ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
			if ( State == "S" ) {
				ComShowCodeMessage("CSQ00001", "Data");
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			} else if ( State != "S" ){
				ComShowMessage(ComResultMessage(sXml));
				return false;
			}
			
			break;
		case "IBCOPY":			// 최근 이전 분기의 데이터를 복사
			if (!validateForm(sheetObj, formObj, sAction)) {
				return false;
			}
			if (ComShowConfirm (ComGetMsg("CSQ00005")) != 1) {
				return false;
		    }
			
			ComOpenWait(true);
			ComSetSearchParams("f_cmd", MULTI01);
			var sXml = sheetObj.GetSaveData("ESM_CSQ_0001GS.do", searchParams);
			ComOpenWait(false);
			
			var State=ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
			if ( State == "S" ) {
				ComShowCodeMessage("CSQ00003", "Data");
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			} else if ( State != "S" ) {
				ComShowMessage(ComResultMessage(sXml));
				return false;
			}
			break;
			
		case IBDOWNEXCEL:		// 엑셀 다운로드
			ComOpenWait(true);
			sheetObj.Down2Excel({ HiddenColumn:-1, Merge:true});
			ComOpenWait(false);
			break;
			
		case IBINSERT:          // Row Add
			var row = sheetObj.DataInsert();
			sheetObj.RenderSheet(1);
			sheetObj.SetCellEditable(row, "trd_cd",1);
			sheetObj.SetCellEditable(row, "conv_dir_cd",1);
			sheetObj.SetCellEditable(row, "rhq_cd",1);
			sheetObj.SetCellEditable(row, "team_cd",1);
			sheetObj.SetCellEditable(row, "ob_div_cd",1);
			sheetObj.SetCellValue(row, "bse_yr", ComGetObjValue(f_bse_yr),0);
			if (ComGetObjValue(formObj.f_bse_tp_cd[0]) == "Q") sheetObj.SetCellValue(row, "bse_qtr_cd",ComGetObjValue(f_bse_qtr_cd),0);
			sheetObj.SetCellValue(row, "ofc_vw_cd",ComGetObjValue(f_ofc_vw_cd),0);
			break;
    }
}
/**
 * Sheet1 값 변경시
 *
 * @param sheetObj
 * @param row
 * @param col
 * @param value
 */
function sheet1_OnChange(sheetObj, row, col, value){
	var formObj=document.form;
	var sName=sheetObj.ColSaveName(col);
	switch(sName){
		case "conv_dir_cd":
		case "rhq_cd":
		case "ob_div_cd":
			var text=getSheetComboCode(sheetObj, row, col);
			sheetObj.SetCellValue(row, col,text,0);
			break;
	}
}

/**
 *  화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction){
	switch(sAction) {
		case IBSAVE:
			if (sheetObj.IsDataModified()== false) {
				ComShowCodeMessage("CSQ00006");
		        return false;
		    }
			
			var sList=sheetObj.FindStatusRow("I");
			if(sList != ""){
				var sArr=sList.split(";");
				var team_cd="";
				for (var i=0; i < sArr.length; i++) {
					team_cd=sheetObj.GetCellValue(sArr[i], "team_cd");
					if (team_cd.length != 6) {
						ComShowMessage(ComGetMsg("CSQ00002"));
						sheetObj.SelectCell(sArr[i], "team_cd");
						return false;
					}
				}
			}
			
    		break;
	}
	return true;
}
/**
 * 화면의 모든 버튼들의 Enable/Disable 을 처리
 */
function toggleButtons(step) {
	switch (step) {
		case "INIT":
			ComBtnDisable("btn_Save");
			ComBtnDisable("btn_PreQTACopy");
			ComBtnDisable("btn_DownExcel");
			ComBtnDisable("btn_RowAdd");
			break;
		case "COPY":
			// 조회한 Year, Quarter 에 해당하는 Data 의 Count 가 0 일 경우
			ComBtnEnable("btn_PreQTACopy");
			break;
		case "SEARCH":
			ComBtnEnable("btn_Save");
			ComBtnEnable("btn_DownExcel");
			ComBtnEnable("btn_RowAdd");
			break;
	}
}

/**
 * f_bse_tp_cd 바뀌었을때 qtr_cd, week 변경
 */
function f_bse_tp_cd_OnChange() {
	var formObj   = document.form;
	var bse_tp_cd = ComGetObjValue(formObj.f_bse_tp_cd[0]);
	var div_qtr   = document.getElementById("div_qtr");
	var div_period= document.getElementById("div_period");
	
	if (bse_tp_cd == "Y") {
		div_qtr.style.display="none";
		div_period.style.display="none";
//		f_bse_qtr_cd.style.display="none";
		f_bse_qtr_cd.SetVisible(0);
	} else {
		div_qtr.style.display="inline";
		div_period.style.display="inline";
//		f_bse_qtr_cd.style.display="inline";
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

/**
 * sheet의 높이를 자동조절해 준다.
 */
function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
}
/* 개발자 작업  끝 */