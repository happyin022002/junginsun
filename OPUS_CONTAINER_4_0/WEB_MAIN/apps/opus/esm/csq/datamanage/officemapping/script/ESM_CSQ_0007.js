/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0007.js
*@FileTitle  : Lane-Office Relation Setting_New Lane Add Pop-up
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
 * @class ESM_CSQ_0007 : ESM_CSQ_0007 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
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
	var sheetObj=sheetObjects[0];
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_Retrieve":
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
				break;
			case "btn_Apply":
				doActionIBSheet(sheetObj, formObj, "Apply");
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
	ComSetObjValue(formObj.f_bse_tp_cd[0], p_bse_tp_cd);
	f_bse_tp_cd_OnChange();
	setTradeCombo();
	loadingMode=false;
}
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:		// sheet1 init
		    with(sheetObj){
	        	var HeadTitle="RHQ|Office|Active||";
	        	var headCount=ComCountHeadTitle(HeadTitle);
	        	SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );

	        	var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
	        	var headers = [ { Text:HeadTitle, Align:"Center"} ];
	        	InitHeaders(headers, info);

	        	var cols = [ {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"rhq_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0   },
	        	             {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"csq_act_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lvl",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   TreeCol:1 ,  LevelSaveName:"lvl"},
	        	             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Status",    Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0} ];
	       
	        	InitColumns(cols);
	        	SetSheetHeight(300);
	        	SetEditable(1);
	        	SetImageList(0,"img/nolines_plus.gif");
	        	SetImageList(1,"img/nolines_minus.gif");
//	            InitTreeInfo(4, "lvl", "#0000FFNAN");
	      }
		  break;
	}
}
/**
 * 멀티콤보 항목을 설정한다.
 */
function initCombo(comboObj, comboId) {
	switch(comboObj.options.id) {
		case "f_rlane_cd":
			with (comboObj) {
				SetDropHeight(300);
				SetSelectIndex(0);
				ValidChar(2,1);
			}
			break;
		default:
			with (comboObj) {
				SetDropHeight(300);
				SetSelectIndex(0);
				ValidChar(2);
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
		case IBCLEAR:          // 화면 접속 시
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.f_cmd.value=INIT;
			var sXml=sheetObj.GetSearchData("ESM_CSQ_0007GS.do", FormQueryString(formObj));
			var arrXml=sXml.split("|$$|");
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], f_dir_cd, "code", "name");
			ComOpenWait(false);
			break;
		case IBSEARCH:          // 화면 조회
			if (!validateForm(sheetObj, formObj, sAction)) {
				return false;
			}
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
			searchParams=FormQueryString(formObj);
			sheetObj.DoSearch("ESM_CSQ_0007GS2.do", searchParams );
			// Tree 모두 접기
//			sheetObj.ShowTreeLevel(0, 1);
			ComOpenWait(false);
			break;
		case "Apply":          // Apply 버튼 클릭
			if (sheetObj.GetTotalRows()<= 0) {
				ComShowCodeMessage("CSQ00026");
				return false;
			}
			ComOpenWait(true);
			if (ComShowConfirm (ComGetMsg("CSQ00012", "Apply")) != 1) {
				ComOpenWait(false);
				return false;
		    }
			var opener=window.dialogArguments;
			if (!opener)  opener = window.opener;  //이 코드 추가할것
			if (!opener) opener = parent; //이 코드 추가할것
			
			var rows=sheetObj.FindStatusRow("U");
			var rowArr=rows.split(";");
			var arr=new Array();
			var sub_trd_cd="";
			for (var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
				if ( ComTrim(sheetObj.GetCellValue(i, "ofc_cd")).length == 5 ) {
					sub_trd_cd=ComGetObjValue(f_sub_trd_cd);
					arr[0]=ComGetObjValue(f_trd_cd);
					arr[1]=ComTrim(sub_trd_cd)=="All"?"":sub_trd_cd;
					arr[2]=ComGetObjValue(f_dir_cd);
					arr[3]=ComGetObjValue(f_rlane_cd);
					arr[4]=sheetObj.GetCellValue(i, "rhq_cd");
					arr[5]=sheetObj.GetCellValue(i, "ofc_cd");
					arr[6]=sheetObj.GetCellValue(i, "csq_act_flg");
					arr[7]="Y";
					opener.newLaneAdd( arr );
				}
			}
			ComOpenWait(false);
			ComShowCodeMessage("CSQ00011", "Lane");
			ComClosePopup(); 
			break;
    }
}
/**
 * Sheet1 클릭 시
 *
 * @param sheetObj
 * @param row
 * @param col
 * @param value
 */
function sheet1_OnClick(sheetObj, row, col){
	switch(sheetObj.ColSaveName(col)){
		case "ofc_cd":
			var mark=sheetObj.GetCellValue(row, 'lvl');
			if(mark == "0"){
				sheetObj.SetRowExpanded(row,1);
				sheetObj.SetCellImage(row, col,1);
				sheetObj.SetCellValue(row, 'lvl',"1",0);
			} else if(mark == "1"){
				sheetObj.SetRowExpanded(row,0);
				sheetObj.SetCellImage(row, col,0);
				sheetObj.SetCellValue(row, 'lvl',"0",0);
			}
			break;
	}
}
/**
 * f_bse_yr, f_bse_qtr_cd  바뀌었을때 f_trd_cd 콤보조회
 */
function setTradeCombo() {
    var formObj=document.form;
    var sheetObj=sheetObjects[0];
    var param="";
	var f_bse_tp_cd  = ComGetObjValue(formObj.f_bse_tp_cd[0]);
	var f_bse_yr 	 = ComGetObjValue(formObj.f_bse_yr);
	var f_bse_qtr_cd = ComGetObjValue(formObj.f_bse_qtr_cd);
	var sector_include = "Y"; //trade 조회시 sector도 포함
    param="f_cmd=" + SEARCH01
     + "&code_name=trade"
     + "&code_param="  + f_bse_tp_cd + "|" + f_bse_yr + "|" + f_bse_qtr_cd+ "|" +sector_include
     + "&all_flag=All";    // Trade
    var sXml=sheetObj.GetSearchData("CommonGS.do",param);
    if (sXml != "") {
        ComXml2ComboItem(sXml, f_trd_cd, "code", "name");
        f_trd_cd.SetSelectIndex(0);
    } else {
        f_trd_cd.RemoveAll();
        f_trd_cd.InsertItem(0, "All", "All");
        f_trd_cd.SetSelectIndex(0);
    }
}
/**
 *  선택된 Trade 에 해당하는 Sub Trade, R/Lane 정보 가져와서 ComboBox 셋팅
 */
function f_trd_cd_OnChange(obj, OldIdx, OldTxt, OldCd, NewIdx, NewTxt, NewCd) {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	var trd_cd		 = ComGetObjValue(f_trd_cd);
	var f_bse_tp_cd  = ComGetObjValue(formObj.f_bse_tp_cd[0]);
	var f_bse_yr 	 = ComGetObjValue(formObj.f_bse_yr);
	var f_bse_qtr_cd = ComGetObjValue(formObj.f_bse_qtr_cd);
	var sector_include = "Y"; //sub trade 조회시 sector도 포함
	if( trd_cd != "All"){
		var param="f_cmd=" + SEARCH01 
	     		+ "&code_name=subTrade"
	     		+ "&code_param="+trd_cd+"|"
	     						+f_bse_tp_cd+"|"
	     						+f_bse_yr+"|"
	     						+f_bse_qtr_cd+"|"
	     						+sector_include
				+ "&all_flag=All";
	 	var sXml=sheetObj.GetSearchData("CommonGS.do", param);
	 	ComXml2ComboItem(sXml, f_sub_trd_cd, "code", "name");
		f_sub_trd_cd.SetSelectIndex(0);
	}else{
		f_sub_trd_cd.RemoveAll();
		f_sub_trd_cd.InsertItem(0, "All", "All");
		f_sub_trd_cd.SetSelectIndex(0);
	}
}
/**
 *  선택된 Sub Trade 에 해당하는 R/Lane 정보 가져와서 ComboBox 셋팅
 */
function f_sub_trd_cd_OnChange(obj, OldIdx, OldTxt, OldCd, NewIdx, NewTxt, NewCd) {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	var trd_cd		 = ComGetObjValue(f_trd_cd);
	var f_bse_tp_cd  = ComGetObjValue(formObj.f_bse_tp_cd[0]);
	var f_bse_yr 	 = ComGetObjValue(formObj.f_bse_yr);
	var f_bse_qtr_cd = ComGetObjValue(formObj.f_bse_qtr_cd);
	var sector_include = "Y"; //rlane 조회시 sector도 포함
	if (NewCd != "All") {
 		var param="f_cmd=" + SEARCH01
	    + "&code_name=rLane"
	    + "&code_param="+trd_cd+"|"
	    				+f_bse_tp_cd+"|"
	    				+f_bse_yr+"|"
	    				+f_bse_qtr_cd+"|"
	    				+ NewCd+"|"
						+sector_include
	    + "&all_flag=All";
		var sXml=sheetObj.GetSearchData("CommonGS.do", param);
		ComXml2ComboItem(sXml, f_rlane_cd, "code", "name");
		f_rlane_cd.SetSelectIndex(0);
	} else {
		f_rlane_cd.RemoveAll();
		f_rlane_cd.InsertItem(0, "All", "All");
		f_rlane_cd.SetSelectIndex(0);
	}
}
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction){
	switch(sAction) {
		case IBSEARCH:
			var trd_cd=ComGetObjValue(f_trd_cd);
			var sub_trd_cd=ComGetObjValue(f_sub_trd_cd);
			var dir_cd=ComGetObjValue(f_dir_cd);
			var rlane_cd=ComGetObjValue(f_rlane_cd);
			if (trd_cd == "All") {
				ComShowCodeMessage("CSQ00013", "Trade");
				f_trd_cd.Focus();
				return false;
			}
			if (sub_trd_cd == "All") {
				ComShowCodeMessage("CSQ00013", "Sub Trade");
				f_sub_trd_cd.Focus();
				return false;
			}
			if (dir_cd == "All") {
				ComShowCodeMessage("CSQ00013", "Bound");
				f_dir_cd.Focus();
				return false;
			}
			if (rlane_cd == "All") {
				ComShowCodeMessage("CSQ00013", "R/Lane");
				f_rlane_cd.Focus();
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

/**
 * 데이터 조회 후 Tree에 이미지 추가(1레벨에만 추가하도록 함)
 * @param sheetObj
 * @param ErrMsg
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	sheetObj.ShowTreeLevel(0, 1);

	var iRow = sheetObj.FindText("lvl", "1");
	while(iRow > 0 && iRow > sheetObj.HeaderRows()-1){
		sheetObj.SetCellImage(iRow, "ofc_cd",0);
		sheetObj.SetCellValue(iRow, "lvl","0",0);
		iRow = sheetObj.FindText("lvl", "1", iRow+1);
	}
}
/* 개발자 작업  끝 */
