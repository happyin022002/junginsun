/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName : EES_EQR_1008.js
 *@FileTitle : Empty Repo Guideline Creation.
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/16
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author 
 */
/* 개발자 작업 */
// 공통전역변수
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0 ;
var comObjects=new Array();
var pri_combo_cd="";
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
document.onclick=processButtonClick;
/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * IBCombo Object를 배열로 등록
* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setComboObject(combo_obj){
    comboObjects[comboCnt++]=combo_obj;
}
/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage(mainpage) {
	var formObj=document.form;
	//Trade, Sub Trade, Lane Multi Select ComboBox
	searchOptionTrade("trade", true, true,"","","",true);
	searchOptionSubTrade("subtrade", true, true,"","","","",true);
	searchOptionLane("lane",true, true,"","","","","",true);
	trade.SetSelectCode("");
	subtrade.SetSelectCode("");
	lane.SetSelectCode("");
	
	//CNTR TY/SZ DRY로 설정
	formObj.tpsz.value="D";
	//tpszChange("D");
	formObj.cntr_tpsz_cd.value=("D2,D4,D5,D7,R2,R5,R9,O2,O4,O5,S2,S4,F2,F4,F5,A2,A4").toLowerCase();
	
    for(i=0;i<sheetObjects.length;i++){
    	//시작 환경 설정 함수 이름 변경
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
		//마지막 환경 설정 함수 추가
        ComEndConfigSheet(sheetObjects[i]);
    }
	// multi combo box setting
	for(var p=0; p< comboObjects.length; p++) {
    	initCombo(comboObjects[p], p+1);
	}
//	comboObjects[0].Enable = false;
	//화면 권한 제어
	if(mainpage == "true"){ // EES_EQR_1008 에서 오픈
		ComBtnEnable("btn_save");
		ComBtnEnable("btn_email");		
		ComBtnEnable("btn_guideline_add");
		ComBtnEnable("btn_guideline_amend");
		ComBtnEnable("btn_guideline_del");
		ComBtnEnable("btn_pod_add");
		ComBtnEnable("btn_pod_del");
	}else{  // EES_EQR_1011 에서 오픈
		ComBtnDisable("btn_save");
		ComBtnDisable("btn_email");		
		ComBtnDisable("btn_guideline_add");
		ComBtnDisable("btn_guideline_amend");
		ComBtnDisable("btn_guideline_del");
		ComBtnDisable("btn_pod_add");
		ComBtnDisable("btn_pod_del");
	}
	//Grid Header Hidden
	setGridHidden(comboObjects[3].GetSelectCode());
	ComEnableObject(formObj.s_eff_st_dt,false);
	ComEnableObject(formObj.s_eff_end_dt,false);
	ComEnableObject(formObj.btns_calendar,false);
	tpszChange("D");

}
// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject=sheetObjects[0];
	/** **************************************************** */
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		
		switch (srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObj,IBSEARCH);
			break;
			case "btn_save":
			    if(validateSave()){
					doActionIBSheet(sheetObject, formObj, MULTI);
				}
			break;
			case "btn_new":
				init_form();//화면 초기화.
			break;
			case "btn_downexcel":
				doActionIBSheet(sheetObject,formObj,IBDOWNEXCEL);
			break;
			case "btn_guideline_add":
			    var url="EES_EQR_1009.do"
      					+ "?f_cmd=-1"   // DEFAULT 호출
      					+ "&event_div=A" // Guideline Add
      		            ;
				ComOpenWindowCenter(url,"EES_EQR_1009",850,150, true);
			break;
			case "btn_guideline_amend":
				if (sheetObject.RowCount()> 0) {
					var trade=sheetObject.cellValue(sheetObject.GetSelectRow(), "trd_cd");
					var subtrade=sheetObject.cellValue(sheetObject.GetSelectRow(), "sub_trd_cd");
					var lane=sheetObject.cellValue(sheetObject.GetSelectRow(), "vsl_lane_cd")
					if(validateAmend()){
						var url="EES_EQR_1009.do" 
								+"?f_cmd=-1" // DEFAULT 호출
								+"&event_div=M" // Guideline Amend
								+"&trade=" +trade // Trade Code
								+"&subtrade=" +trade+subtrade// Sub Trade Code
	 							+"&lane=" +trade+subtrade+lane // Lane Code
	 							+"&h_eta_dt=" +sheetObject.cellValue(sheetObject.GetSelectRow(), "eff_st_dt") // Effective start date
								;
						ComOpenWindowCenter(url,"EES_EQR_1009",850,150, true);	
					}
				}else{
					ComShowCodeMessage("EQR01104");//조회된 데이터가 없습니다
				}
			break;
			case "btn_guideline_del":
				if (sheetObject.RowCount()> 0) {
					doActionIBSheet(sheetObject, formObj, REMOVE01);
				}else{
					ComShowCodeMessage("EQR01104");//조회된 데이터가 없습니다
				}
			break;
			case "btn_pod_add":
				if (check_confirm()) {
					pod_row_add(sheetObject);
				}else{
					ComShowCodeMessage("EQR01116"); //Confirm된 Guideline을  수정할 수 없습니다.
				}
			break;
			case "btn_pod_del":
				if (check_confirm()) {
					if (sheetObject.RowCount()> 0) {
						doActionIBSheet(sheetObject, formObj, REMOVE02);
					}
					else {
						ComShowCodeMessage("EQR01104");//조회된 데이터가 없습니다
					}
				}else{
					ComShowCodeMessage("EQR01116"); //Confirm된 Guideline을  수정할 수 없습니다.
				}
			break;
			case "btns_calendar":
				if (formObj.s_dt_tp_cd[1].checked) {
					var cal=new ComCalendarFromTo();
					cal.select(formObj.s_eff_st_dt, formObj.s_eff_end_dt, 'yyyy-MM-dd');
				}
            break;
			case "btn_loc_cd":	//Location By 조회 팝업
    			ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 457, "s_loc_cd:s_sub_loc_cd", "0,1,1,1,1,1", true);
			break;  
			case "btn_Lane":
				ComOpenPopupWithTarget("/opuscntr/COM_ENS_081.do", 780, 420, "col1:lane_direct", '1,0,1,1,1,1,1,1', true);
			break;	
			case "btn_email":  // EMAIL SEND 화면 호출
			    var url="EES_EQR_1031.do"
      		            ;
				ComOpenWindowCenter(url,self,500,200, true);
		} // end switch
	} catch (e) { 
		if (e == "[object Error]") {
			ComShowCodeMessage("EQR01109");//The service is not available now
		} else {
			alert(e);
		}
	}
}
// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
       case IBSEARCH:      //조회
       		if(validateForm()){
				sheetObj.RemoveAll();
	       		formObj.f_cmd.value=SEARCH;
 				sheetObj.DoSearch("EES_EQR_1008GS.do", FormQueryString(formObj) );
			}
       break;
	   case MULTI:	// Save
		    formObj.f_cmd.value=MULTI;
			sheetObj.DoSave("EES_EQR_1008GS.do",FormQueryString(formObj));
	   break;
	   case REMOVE01:   //Guideline Delete
		   	var mrg_fm_row=Number(sheetObj.GetMergedStartCell(sheetObj.GetSelectRow(), "pol_cd").split(",")[0]);
			var mrg_to_row=Number(sheetObj.GetMergedEndCell(sheetObj.GetSelectRow(),"pol_cd").split(",")[0]);
			if(check_confirm()){
				for(var i=mrg_fm_row; i<=mrg_to_row;i++){
					sheetObj.cellValue(i,"ibflag")="D";
					sheetObj.SetRowHidden(i,1);
				}
			}else{
				ComShowCodeMessage("EQR01116"); //Confirm된 Guideline을  수정할 수 없습니다.
			}
	   break;
	   case REMOVE02:  // POD Delete
	   		//POD 입력하지 않는 ROW 모두 삭제
	  		if (sheetObj.cellValue(sheetObj.GetSelectRow(), "pod_cd") == "") {
				sheetObj.RowDelete(sheetObj.GetSelectRow(), false);
			}else{
				if(sheetObj.cellValue(sheetObj.GetSelectRow(),"sort_id")=="3"){
					sheetObj.GetRowHidden(sheetObj.SetSelectRow)(1);
					sheetObj.cellValue(sheetObj.SetSelectRow,"ibflag")("D");
				}else{
					ComShowCodeMessage("EQR01102","POD");//POD를 선택하세요.
				}	
			}
	   break;
       case IBDOWNEXCEL:   //엑셀 다운로드
       		if(sheetObj.RowCount()>0){
 	       		sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1, CheckBoxOnValue:"Y", CheckBoxOffValue:"N" });
			}else{
				ComShowCodeMessage("EQR01104");//조회된 데이터가 없습니다
			}
       break;
    }
}
/**
 * 조회 조건 유효성 체크
 */
function validateForm() {
	var formObj=document.form;
	var rtn_val=true;
	if(formObj.s_dt_tp_cd[0].checked){
		if (ComIsEmpty(formObj.s_eta_dt)) {
			ComShowCodeMessage('EQR01105','Latest Date');
			formObj.s_eta_dt.focus() ;
			return false ;
		}
	}else if(formObj.s_dt_tp_cd[1].checked){
		if (ComIsEmpty(formObj.s_eff_st_dt)) {
			ComShowCodeMessage('EQR01105','Duration From date') ;
			formObj.s_eff_st_dt.focus() ;
			return false ;
		}
		if (ComIsEmpty(formObj.s_eff_end_dt)) {
			ComShowCodeMessage('EQR01105','Duration To Date') ;
			formObj.s_eff_end_dt.focus() ;
			return false ;
		}
		var diffDay=ComGetDaysBetween(formObj.s_eff_st_dt, formObj.s_eff_end_dt);
		if(diffDay < 0){
			ComShowCodeMessage('EQR01118') ;
			formObj.s_eff_end_dt.value="";
			formObj.s_eff_end_dt.focus() ;
			return false ;
		}
//		if(diffDay > 30){
//			ComShowCodeMessage('EQR01106','30') ;
//			formObj.s_eff_end_dt.focus() ;
//			return false ;
//		}
	}
	if(comboObjects[3].GetSelectCode()== ""){
		ComShowCodeMessage("EQR01101");
		rtn_val=false;
	}
	return rtn_val;
}
/**
 * 저장시 유효성 체크
 */
function validateSave() {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	var row_cnt=sheetObj.RowCount();
	var rtn_val=true;
	var cnt=0;
	var pod_cnt=0;
	var pod_leng=0;
	var str_cfm_flg="";
	for(var i=0 ; i<row_cnt; i++){
		if(sheetObj.GetRowStatus(i+2) != "R"){    //변경된 건  일 경우
			//ETA가 현재일자보다 클 경우 Confirm된 건은 Confirm Cancel할 수 없다.
			str_cfm_flg=sheetObj.CellSearchValue(i+2, "cfm_flg");
			if (sheetObj.GetCellValue(i + 2, "sort_id") == "1") {	// Guideline Header
				if (str_cfm_flg == "1" && sheetObj.GetCellValue(i + 2, "sort_id") == "1") { //confirm flag가 Y이고 Guideline Header일 경우
					if (sheetObj.GetCellValue(i + 2, "cfm_flg") == "0") {
						if (ComGetDaysBetween(sheetObj.GetCellValue(i + 2, "eff_st_dt"), formObj.h_eta_dt.value) > 0) {
							sheetObj.SetCellValue(i+2, "cfm_flg",'1',0);
							ComShowCodeMessage("EQR01108");//Confirm 취소할 수 없습니다.
							rtn_val=false;
						}
					}
				}
			}
			if(sheetObj.GetCellValue(i + 2, "sort_id") == "3"){
				//POD 입력 여부 체크.
				if (sheetObj.GetCellValue(i + 2, "pod_cd") == "") {
					pod_cnt++;
				}
				//POD 입력 여부 체크.
				if ((sheetObj.GetCellValue(i + 2, "pod_cd")).length <5) {
					pod_leng++;
				}
			}
			cnt++;
		}
	}
	if (row_cnt == 0) {
		ComShowCodeMessage("EQR01104");//조회된 데이터가 없습니다
		rtn_val=false;
	}else if (cnt == 0) {//데이터 변경 유무체크
		ComShowCodeMessage("EQR01107");
		rtn_val=false;
	}else if (pod_cnt > 0) { //POD 입력 여부 체크. 
		ComShowCodeMessage("EQR01102","POD");//'POD를 선택하세요.';
		rtn_val=false;
	}else if (pod_leng > 0) {
		ComShowCodeMessage("EQR01115");//'POD를 선택하세요.';
		rtn_val=false;	
	}
	return rtn_val;
}
/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo){
	var cnt=0;
	switch (sheetNo) {
		case 1: // sheet1 init
		    with(sheetObj){
				        
			      var HeadTitle0="Trade|Sub|LANE|Effective|Effective|Effective|Effective|Effective|Effective|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Expiration\nDate|Confirm|Update\nDate|Update\nUser|";
			      var HeadTitle1="Trade|Sub|LANE||VVD|POL|ETA|Remark|POD|D2|D2|D4|D4|D5|D5|D7|D7|R2|R2|R5|R5|R9|R9|O2|O2|O4|O4|O5|O5|S2|S2|S4|S4|F2|F2|F4|F4|F5|F5|A2|A2|A4|A4|Expiration\nDate|Confirm|Update\nDate|Update\nUser|";
			      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:9, DataRowMerge:0 } );
			      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle0, Align:"Center"},
			                      { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"vsl_lane_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eq_gline_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"vvd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"eta_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 ,MultiLineText:1},
			             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"repo_gline_rmk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5,     Wrap:1 },
			             {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"d2_qty",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5,     Wrap:1 },
			             {Type:"ComboEdit", Hidden:0, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"d2_ut",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
			             {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"d4_qty",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5,     Wrap:1 },
			             {Type:"ComboEdit", Hidden:0, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"d4_ut",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
			             {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"d5_qty",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5,     Wrap:1 },
			             {Type:"ComboEdit", Hidden:0, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"d5_ut",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
			             {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"d7_qty",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5,     Wrap:1 },
			             {Type:"ComboEdit", Hidden:0, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"d7_ut",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
			             {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"r2_qty",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5,     Wrap:1 },
			             {Type:"ComboEdit", Hidden:0, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"r2_ut",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
			             {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"r5_qty",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5,     Wrap:1 },
			             {Type:"ComboEdit", Hidden:0, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"r5_ut",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
			             {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"r9_qty",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5,     Wrap:1 },
			             {Type:"ComboEdit", Hidden:0, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"r9_ut",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
			             {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"o2_qty",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5,     Wrap:1 },
			             {Type:"ComboEdit", Hidden:0, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"o2_ut",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
			             {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"o4_qty",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5,     Wrap:1 },
			             {Type:"ComboEdit", Hidden:0, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"o4_ut",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
			             {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"o5_qty",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5,     Wrap:1 },
			             {Type:"ComboEdit", Hidden:0, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"o5_ut",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
			             {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"s2_qty",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5,     Wrap:1 },
			             {Type:"ComboEdit", Hidden:0, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"s2_ut",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
			             {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"s4_qty",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5,     Wrap:1 },
			             {Type:"ComboEdit", Hidden:0, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"s4_ut",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
			             {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"f2_qty",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5,     Wrap:1 },
			             {Type:"ComboEdit", Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"f2_ut",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
			             {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"f4_qty",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5,     Wrap:1 },
			             {Type:"ComboEdit", Hidden:0, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"f4_ut",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
			             {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"f5_qty",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5,     Wrap:1 },
			             {Type:"ComboEdit", Hidden:0, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"f5_ut",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
			             {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"a2_qty",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5,     Wrap:1 },
			             {Type:"ComboEdit", Hidden:0, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"a2_ut",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
			             {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"a4_qty",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5,     Wrap:1 },
			             {Type:"ComboEdit", Hidden:0, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"a4_ut",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"eff_end_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"CheckBox",  Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cfm_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1,  TrueValue:"Y", FalseValue:"N" },
			             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"upd_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"upd_usr_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eff_st_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Text",      Hidden:1, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"upd_usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Text",      Hidden:1, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"vsl_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Text",      Hidden:1, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"skd_voy_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Text",      Hidden:1, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"skd_dir_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sort_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Status",    Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 } ];
			      InitColumns(cols);
			      SetEditable(1);
			      SetEditableColorDiff(0);
			      SetColProperty("eff_end_dt", {Format:"####-##-##"} );
			      SetColProperty("upd_dt", {Format:"####-##-####:##:##"} );
			      SetColProperty(0 ,"pod_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
			      SetColProperty("d2_ut", {ComboText:"|"+glinetpText, ComboCode:"|"+glinetpCode} );
			      SetColProperty("d4_ut", {ComboText:"|"+glinetpText, ComboCode:"|"+glinetpCode} );
			      SetColProperty("d5_ut", {ComboText:"|"+glinetpText, ComboCode:"|"+glinetpCode} );
			      SetColProperty("d7_ut", {ComboText:"|"+glinetpText, ComboCode:"|"+glinetpCode} );
			      SetColProperty("r2_ut", {ComboText:"|"+glinetpText, ComboCode:"|"+glinetpCode} );
			      SetColProperty("r5_ut", {ComboText:"|"+glinetpText, ComboCode:"|"+glinetpCode} );
			      SetColProperty("r9_ut", {ComboText:"|"+glinetpText, ComboCode:"|"+glinetpCode} );
			      SetColProperty("o2_ut", {ComboText:"|"+glinetpText, ComboCode:"|"+glinetpCode} );
			      SetColProperty("o4_ut", {ComboText:"|"+glinetpText, ComboCode:"|"+glinetpCode} );
			      SetColProperty("o5_ut", {ComboText:"|"+glinetpText, ComboCode:"|"+glinetpCode} );
			      SetColProperty("s2_ut", {ComboText:"|"+glinetpText, ComboCode:"|"+glinetpCode} );
			      SetColProperty("s4_ut", {ComboText:"|"+glinetpText, ComboCode:"|"+glinetpCode} );
			      SetColProperty("f2_ut", {ComboText:"|"+glinetpText, ComboCode:"|"+glinetpCode} );
			      SetColProperty("f4_ut", {ComboText:"|"+glinetpText, ComboCode:"|"+glinetpCode} );
			      SetColProperty("f5_ut", {ComboText:"|"+glinetpText, ComboCode:"|"+glinetpCode} );
			      SetColProperty("a2_ut", {ComboText:"|"+glinetpText, ComboCode:"|"+glinetpCode} );
			      SetColProperty("a4_ut", {ComboText:"|"+glinetpText, ComboCode:"|"+glinetpCode} );
			      SetSheetHeight(410);			      
			      }
		break;
	}
}
function form_focus(){
	var formObj=document.form;
	srcName=ComGetEvent("name");
	switch (srcName) {
		case "s_eta_dt":
			formObj.s_eta_dt.value=ComTrimAll(formObj.s_eta_dt.value, "-");
		break;
		case "s_eff_st_dt":
			formObj.s_eff_st_dt.value=ComTrimAll(formObj.s_eff_st_dt.value, "-");
		break;
		case "s_eff_end_dt":
			formObj.s_eff_end_dt.value=ComTrimAll(formObj.s_eff_end_dt.value, "-");
		break;
	}
}
/**
 * 설  명 : Form Object Event - onBlur <br>
 * @author SHIN DONG IL
 * @version 2013.05.27
 */
function form_blur(){
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	srcName=ComGetEvent("name");
	switch (srcName) {
		case "s_eta_dt":
			formObj.s_eta_dt.value=ComGetMaskedValue(formObj.s_eta_dt.value, "ymd");
		break;
		case "s_eff_st_dt":
			formObj.s_eff_st_dt.value=ComGetMaskedValue(formObj.s_eff_st_dt.value, "ymd");
			// 기준일로부터 30일 이후 일자 자동 셋팅
			if (ComTrimAll(formObj.s_eff_st_dt) != "") {
				formObj.s_eff_end_dt.value=ComGetDateAdd(formObj.s_eff_st_dt.value, "D", 30, "-");
			}
			var diffDay=ComGetDaysBetween(formObj.s_eff_st_dt, formObj.s_eff_end_dt);
			if (ComTrimAll(formObj.s_eff_st_dt) != "" && ComTrimAll(formObj.s_eff_end_dt) != "") {
				if (diffDay < 0) {
					ComShowCodeMessage('EQR01118');
					formObj.s_eff_end_dt.value="";
					formObj.s_eff_end_dt.focus();
					return false;
				}
			}
		break;
		case "s_eff_end_dt":
			formObj.s_eff_end_dt.value=ComGetMaskedValue(formObj.s_eff_end_dt.value, "ymd");
			if (ComTrimAll(formObj.s_eff_st_dt) != "" && ComTrimAll(formObj.s_eff_end_dt) != "") {
				var diffDay=ComGetDaysBetween(formObj.s_eff_st_dt, formObj.s_eff_end_dt);
				if (diffDay < 0) {
					ComShowCodeMessage('EQR01118');
					formObj.s_eff_end_dt.value="";
					formObj.s_eff_end_dt.focus();
					return false;
				}
			}
		break;
		case "s_sub_loc_cd":
			if (ComTrimAll(formObj.s_sub_loc_cd) != "") {
				formObj.f_cmd.value=SEARCH01;
 				var sXml=sheetObj.GetSearchData("EES_EQR_1008GS.do", FormQueryString(formObj));
				var sCheck=ComGetEtcData(sXml, "check");
				if (sCheck != "T") {
					ComShowCodeMessage("EQR01005");
					formObj.s_sub_loc_cd.value="";
				}
			}
		break;
	}
}
/*
 * Container Type Combo OnChange Event
 * */
function tpszChange(key){		
	switch (key){    
        case "":
        	comboObjects[3].SetSelectCode(-1);
            comboObjects[3].SetSelectCode(consTpsz);
        break;
        case "D":
        	comboObjects[3].SetSelectCode(-1);
            comboObjects[3].SetSelectCode(consTpszDry);
        break;
        case "R":
        	comboObjects[3].SetSelectCode(-1);
            comboObjects[3].SetSelectCode(consTpszRfr);
        break;
        case "O":
        	comboObjects[3].SetSelectCode(-1);
            comboObjects[3].SetSelectCode(consTpszOt);
        break;
        case "F":
        	comboObjects[3].SetSelectCode(-1);
            comboObjects[3].SetSelectCode(consTpszFr);
        break;
    }
}
/**
 * MultiSelectCombo 기본 설정
 * 탭의 항목을 설정한다.
 */
function initCombo (comboObj, comboNo) {
    var cnt=0 ;
	var formObj=document.form;
	with (comboObj) {
		//var strId=comboObj.id;
		var strId=options.id;
		switch (strId) {
			case "tpsztype":
				SetDropHeight(9 * 20);
				var menuname=tpszallText.split('|');
				var menucode=tpszallCode.split('|')
				SetMultiSelect(1);
				SetMaxSelect(menuname.length);
				SetMultiSeparator(",");
				for (i=0; i < menuname.length; i++) {
					InsertItem(cnt++, menuname[i], menucode[i]);
				}
			break;
		}
	}
}
//선택된 CONTAINER TYPE/SIZE에 따라 그리드의 헤더를 변경한다.
function tpsztype_OnChange(comboObj, value, text) {
	//조회 완료 후 선택된 Container Type/Size 이외 Hidden
	setGridHidden(comboObj.GetSelectCode());
	var arr_combo_cd=value.split(",");
	//Priority ComboBox Code 설정
	pri_combo_cd="";
	for (var i=0; i < arr_combo_cd.length; i++) {
		pri_combo_cd=pri_combo_cd + (i + 1) + "|";
	}
	pri_combo_cd=pri_combo_cd.substring(0, pri_combo_cd.length - 1);
}
/**
 * OnChange 이벤트 발생시 호출되는 function <br>
 *
 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
 * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
 * @param {int} text 필수 화면에 표시된 글자
 * @return 없음
 * @author
 * @version
 */
function trade_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	searchOptionSubTrade("subtrade", true, true, "",  "",  newCode,   "", true);
	searchOptionLane("lane",true, true, "", newCode,"", true,"",true);
}
/**
 * OnChange 이벤트 발생시 호출되는 function <br>
 *
 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
 * @param {int} code 필수 Onclick 이벤트가 발생한 해당 sub trade code
 * @param {int} text 필수 화면에 표시된 글자(Trade code)
 * @return 없음
 * @author
 * @version
 */
function subtrade_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	searchOptionLane("lane",true,true,"",trade.GetSelectCode(),newCode,true,"",true);
}
/*
 * Container Type/Size에 따라 Grid의 컬럼을 활성화 Hidden처리
 * OnloadPage,OnSearchEnd event에서 호출
 * @param {String} tpsz_cd
 * DESC : 전체의 Container Type/Size중 선택된 Container Type/Size만 활성화 한다.
 */
function setGridHidden(tpsz_cd){
	var sheetObj=sheetObjects[0];
	var arr_tpsz=tpsz_cd.split(",");
	sheetObjects[0].RenderSheet(0);
	for(var i=0;i<consTpszArr.length;i++){ //전체의 Container Type/Size
		sheetObj.SetColHidden(consTpszArr[i].toLowerCase()+"_qty",!isValidEQRCntrTpSz(arr_tpsz,consTpszArr[i].toLowerCase()));
		sheetObj.SetColHidden(consTpszArr[i].toLowerCase()+"_ut",!isValidEQRCntrTpSz(arr_tpsz,consTpszArr[i].toLowerCase()));
	}//end for(var i=0;i<consTpszArr.length;i++)
	sheetObjects[0].RenderSheet(1);
}
 /**
  * EQR: EQR에서 취급하는 CNTR TP SZ가 맞는지 확인  
  **/
function isValidEQRCntrTpSz(arr_tpsz, tpsz) {
	for (var i=0; tpsz!=undefined && tpsz!=null && tpsz!='' && arr_tpsz!=null && i<arr_tpsz.length; i++){
  		if (arr_tpsz[i]!=undefined && arr_tpsz[i]!='' && arr_tpsz[i].toLowerCase()==tpsz.toLowerCase()){
    		return true;
   		}
	  }
	return false;
 }
 /**
 * 조회 완료 이벤트 후 로직 <br>
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
}
 /**
 * 셀을 마우스 클릭했을때 발생하는 이벤트 <br>
 */
function sheet1_OnClick(sheetObj, Row, Col, Value) {
	var formObj=document.form;
    switch (sheetObj.ColSaveName(Col)) {
        case "repo_gline_rmk":
			var mrg_fm_row=Number(sheetObj.GetMergedStartCell(sheetObj.GetSelectRow(), "pol_cd").split(",")[0]);			
			if(sheetObj.GetCellValue(mrg_fm_row,"cfm_flg")!="1"){ // Guideline Header일 경우만.
	            sheetObj.SetCellEditable(Row, Col,0);
			 	//ComShowMemoPad(sheetObj, row, col, bReadOnly, iWidth, iHeight, iMax, bEventRaise)
			 	if (formObj.main_page.value == "true") {//Guideline Creation 화면일 경우
					ComShowMemoPad(sheetObj, Row, Col, false, 300, 200, 1000, true);
				}else {//Guideline Inquiry 화면일 경우
					ComShowMemoPad(sheetObj, Row, Col, true, 300, 200, 1000, true);
				}
			}
        break;
		case "d2_ut":
		case "d4_ut":
		case "d5_ut":
		case "d7_ut":
		case "r2_ut":
		case "r5_ut":
		case "r9_ut":
		case "o2_ut":
		case "o4_ut":
		case "o5_ut":
		case "s2_ut":
		case "s4_ut":
		case "f2_ut":
		case "f4_ut":
		case "f5_ut":
		case "a2_ut":
		case "a4_ut":
			
			if (sheetObj.GetCellValue(Row, "sort_id") == "1") {// Gudideline Header일 경우 콤보박스
				sheetObj.CellComboItem(Row,Col, {ComboText:"|"+pri_combo_cd, ComboCode:"|"+pri_combo_cd} );
			}else {
				sheetObj.CellComboItem (Row, sheetObj.ColSaveName(Col), " |"+glinetpText," |"+glinetpCode);
			}
		break;
    }
}
// Grid Change Event
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var formObj=document.form;
	//Priority와 % rate는 같은 Table에 들어가야 하기때문에  Ibflag 상태는 한쌍으로 변경한다.
	if(sheetObj.GetCellValue(Row,"sort_id")=="1" && sheetObj.GetCellValue(Row,"ibflag") == "U"){
		sheetObj.SetCellValue(Row+1,"ibflag","U");
	}if (sheetObj.GetCellValue(Row, "sort_id") == "2" && sheetObj.GetCellValue(Row,"ibflag") == "U") {
		sheetObj.SetCellValue(Row-1,"ibflag","U");
	}
	 switch (sheetObj.ColSaveName(Col)) {
	 	case "pod_cd":
			var mrg_fm_row=Number(sheetObj.GetMergedStartCell(sheetObj.GetSelectRow(), "pol_cd").split(",")[0]);
			var mrg_to_row=Number(sheetObj.GetMergedEndCell(sheetObj.GetSelectRow(),"pol_cd").split(",")[0]);
			var dup_cnt=0;
			var chk_pol_cd="";
			for(var i=mrg_fm_row; i <=mrg_to_row; i++){
				if(sheetObj.GetCellValue(i,"pod_cd") == Value){
					dup_cnt++
				}
			}
			if(dup_cnt > 1){//중복 POD Chcek
				sheetObj.SetCellValue(Row,"pod_cd","");
				ComShowCodeMessage("EQR01114");//중복된 POD가 있습니다.';				
			}
			// POD CD 유효성 체크
			if(sheetObj.GetCellValue(Row, "sort_id") == "3"){  //POD열일경우
				if (Value != "") {
					formObj.f_cmd.value=SEARCH03;
 					sXml=sheetObj.GetSearchData("EES_EQR_1008GS.do", FormQueryString(formObj) + "&pod_cd=" + Value);
					chk_pol_cd=ComGetEtcData(sXml, "chk_pod_cd");
				}
			}
			if(dup_cnt > 1){//중복 POD Chcek
				sheetObj.SetCellValue(Row,"pod_cd","");
				ComShowCodeMessage("EQR01114");//중복된 POD가 있습니다.';				
			}else if(chk_pol_cd == "F"){
					ComShowCodeMessage('EQR01103',"POD"); //유효하지 않은 POD입니다.
					sheetObj.SetCellValue(Row,"pod_cd","",0);
					return;		
			}
		break;
		case "repo_gline_rmk":
			var mrg_fm_row=Number(sheetObj.GetMergedStartCell(sheetObj.GetSelectRow(), "pol_cd").split(",")[0]);
			var mrg_to_row=Number(sheetObj.GetMergedEndCell(sheetObj.GetSelectRow(),"pol_cd").split(",")[0]);
			sheetObj.MergeSheet=msNone;
			for (var i=mrg_fm_row; i <= mrg_to_row; i++) {
				sheetObj.SetCellValue(i,"repo_gline_rmk",Value,0);
			}
			sheetObj.MergeSheet=msPrevColumnMerge + msHeaderOnly;
		break;
		case "d2_ut":
		case "d4_ut":
		case "d5_ut":
		case "d7_ut":
		case "r2_ut":
		case "r5_ut":
		case "r9_ut":
		case "o2_ut":
		case "o4_ut":
		case "o5_ut":
		case "s2_ut":
		case "s4_ut":
		case "f2_ut":
		case "f4_ut":
		case "f5_ut":
		case "a2_ut":
		case "a4_ut":
		    //Unit Code가 REST일 경우 QTY항목을 초기화 한다.
			if(Value=="R"){
				var col_nm=(sheetObj.ColSaveName(Col)).substring(0,2)+'_qty';
				sheetObj.SetCellValue(Row,col_nm,"");
			}
		break;
		case "cfm_flg":			
			if(sheetObj.GetCellValue(Row,"sort_id")=="1"){
				var search_cfm_flg=sheetObj.CellSearchValue(Row, "cfm_flg");				
				if(search_cfm_flg == "1" && search_cfm_flg != Value){					
					if (ComGetDaysBetween(sheetObj.GetCellValue(Row, "eff_st_dt"), formObj.h_eta_dt.value) > 0) {						
						sheetObj.SetCellValue(Row, "cfm_flg",'1',0);
						ComShowCodeMessage("EQR01108");//Confirm 취소할 수 없습니다.
					}
				}
			}
		break;		
	}
}
// 저장후 메세지 표현
function sheet1_OnSaveEnd(sheetObj, code, errMsg){
	var formObj=document.form;
	ComOpenWait(false);// 무조건 가장 첫 라인
	if (errMsg == "") {
		ComShowCodeMessage("EQR01001");
		doActionIBSheet(sheetObj,formObj,IBSEARCH);
	}
}
// POD Add버튼 클릭시 Row Add
function pod_row_add(sheetObj){
	if(sheetObj.RowCount()> 0){
		if(sheetObj.cellvalue(sheetObj.GetSelectRow(),"sort_id")!="1"){
			sheetObj.DataInsert();
			sheetObj.SetCellEditable(sheetObj.GetSelectRow(), "pol_cd",1);
			sheetObj.cellvalue(sheetObj.SetSelectRow,"trd_cd")(sheetObj.cellvalue(sheetObj.GetSelectRow()-1,"trd_cd"));
			sheetObj.cellvalue(sheetObj.SetSelectRow,"sub_trd_cd")(sheetObj.cellvalue(sheetObj.GetSelectRow()-1,"sub_trd_cd"));
			sheetObj.cellvalue(sheetObj.SetSelectRow,"vsl_lane_cd")(sheetObj.cellvalue(sheetObj.GetSelectRow()-1,"vsl_lane_cd"));
			sheetObj.cellvalue(sheetObj.SetSelectRow,"vvd")(sheetObj.cellvalue(sheetObj.GetSelectRow()-1,"vvd"));
			sheetObj.cellvalue(sheetObj.SetSelectRow,"eta_dt")(sheetObj.cellvalue(sheetObj.GetSelectRow()-1,"eta_dt"));
			sheetObj.cellvalue(sheetObj.SetSelectRow,"repo_gline_rmk")(sheetObj.cellvalue(sheetObj.GetSelectRow()-1,"repo_gline_rmk"));
			sheetObj.cellvalue(sheetObj.SetSelectRow,"eff_st_dt")(sheetObj.cellvalue(sheetObj.GetSelectRow()-1,"eff_st_dt"));
			sheetObj.cellvalue(sheetObj.SetSelectRow,"eff_end_dt")(sheetObj.cellvalue(sheetObj.GetSelectRow()-1,"eff_end_dt"));
			sheetObj.cellvalue(sheetObj.SetSelectRow,"pol_cd")(sheetObj.cellvalue(sheetObj.GetSelectRow()-1,"pol_cd"));
			sheetObj.cellvalue(sheetObj.SetSelectRow,"eq_gline_seq")(sheetObj.cellvalue(sheetObj.GetSelectRow()-1,"eq_gline_seq"));
			sheetObj.cellvalue(sheetObj.SetSelectRow,"sort_id")("3");
			sheetObj.cellvalue(sheetObj.SetSelectRow,"vsl_cd")(sheetObj.cellvalue(sheetObj.GetSelectRow()-1,"vsl_cd"));
			sheetObj.cellvalue(sheetObj.SetSelectRow,"skd_voy_no")(sheetObj.cellvalue(sheetObj.GetSelectRow()-1,"skd_voy_no"));
			sheetObj.cellvalue(sheetObj.SetSelectRow,"skd_dir_cd")(sheetObj.cellvalue(sheetObj.GetSelectRow()-1,"skd_dir_cd"));
			//Confirm flag 비활성화
			sheetObj.SetCellEditable(sheetObj.GetSelectRow(),"cfm_flg",0);
		}
	}else{
		ComShowCodeMessage("EQR01104");//조회된 데이터가 없습니다
		return;
	}
}
/**
 * Amend Button Click시 제약조건
 * 조회된 TRADE, SUB TRADE,LANE의 마지막 차수에서만 AMEND가능하다. 
 */
function validateAmend() {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	var rtn_val=true;
	var str_trd_cd=sheetObj.cellvalue(sheetObj.GetSelectRow(),"trd_cd") ;
	var str_sub_trd_cd=sheetObj.cellvalue(sheetObj.GetSelectRow(),"sub_trd_cd");
	var str_vsl_lane_cd=sheetObj.cellvalue(sheetObj.GetSelectRow(),"vsl_lane_cd");
	var str_eq_gline_seq=sheetObj.cellvalue(sheetObj.GetSelectRow(),"eq_gline_seq");
	var mrg_fm_row=Number(sheetObj.GetMergedStartCell(sheetObj.GetSelectRow(), "pol_cd").split(",")[0]);
	formObj.f_cmd.value=SEARCH02;
    sXml=sheetObj.GetSearchData("EES_EQR_1008GS.do" ,FormQueryString(formObj)+"&str_trd_cd="+str_trd_cd+"&str_sub_trd_cd="+str_sub_trd_cd+"&str_vsl_lane_cd="+str_vsl_lane_cd+"&str_eq_gline_seq="+str_eq_gline_seq);
	//선택된 ROW가 최종 CONFIRM여부 확인
	var max_gline_seq=ComGetEtcData(sXml,"max_gline_seq");
	if(sheetObj.GetCellValue(mrg_fm_row,"cfm_flg") == "0"){
		ComShowCodeMessage('EQR01112');
		rtn_val=false;		
	}else if(str_eq_gline_seq != max_gline_seq){
		ComShowCodeMessage('EQR01117');
		rtn_val=false;
	}
	return rtn_val;
}
/**
 * New 버튼 클릭시 화면 초기화.
 */
function init_form() {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	formObj.s_dt_tp_cd[0].checked=true;	
	formObj.s_eta_dt.value=formObj.h_eta_dt.value;
	formObj.s_eff_st_dt.value="";
	formObj.s_eff_end_dt.value="";
	trade.SetSelectIndex("");
	subtrade.SetSelectIndex("");
	lane.SetSelectIndex("");
	formObj.lane_direct.value=""; // lane code 입력값 초기화
	//CNTR TY/SZ DRY로 설정
	formObj.tpsz.value="D";
	tpszChange("D");
	formObj.s_cfm_flg.value="";
	formObj.s_loc_cd.value="";
	formObj.s_sub_loc_cd.value="";
	sheetObj.RemoveAll();
}
/**
 * Guideline Del, POD Add, POD Del시 
 * Confirm 유무 체크
 * Confirm된 건은 수정불가.
 * */
function check_confirm() {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	var rtn_val=true;
	var mrg_fm_row=0 ;
	if (sheetObj.RowCount()> 0) {
		var mrg_fm_row=Number(sheetObj.GetMergedStartCell(sheetObj.GetSelectRow(), "pol_cd").split(",")[0]);
		if (sheetObj.GetCellValue(mrg_fm_row, "cfm_flg") == "1") {
			rtn_val=false;
		}
	}
	return rtn_val;
}
/**
 * Date Type 변경시 이벤트 처리 
 */
function chg_dt_tp() {
	var formObj=document.form;
	if(formObj.s_dt_tp_cd[0].checked){
		formObj.s_eta_dt.value=formObj.h_eta_dt.value;
		formObj.s_eff_st_dt.value="";
		formObj.s_eff_end_dt.value="";
		ComEnableObject(formObj.s_eta_dt,true);
		ComEnableObject(formObj.s_eff_st_dt,false);
		ComEnableObject(formObj.s_eff_end_dt,false);
		ComEnableObject(formObj.btns_calendar,false);
		document.getElementById("s_eta_dt").className="input1";
	}else if(formObj.s_dt_tp_cd[1].checked){
		formObj.s_eta_dt.value="";
		ComEnableObject(formObj.s_eta_dt,false);
		ComEnableObject(formObj.s_eff_st_dt,true);
		ComEnableObject(formObj.s_eff_end_dt,true);
		ComEnableObject(formObj.btns_calendar,true);
		document.getElementById("s_eff_st_dt").className="input1";
		document.getElementById("s_eff_end_dt").className="input1";
	}
}
/**
 * 설  명 : To Date = From Date + 30  <br>
 * <br><b>Example : </b>
 * <pre>
 *     calToDate()
 * </pre>
 * @see #링크연결
 * @author 작성자
 * @version 2009.01.01
 */
function calToDate(){
	formObj=document.form;
	var to_dt=calc_Date(formObj.eff_st_dt.value,30,true);
	if (formObj.eff_st_dt.value != "" && to_dt == "") {
		ComShowCodeMessage('EQR90222','YYYY-MM-DD');
		formObj.eff_st_dt.value="";
		formObj.eff_end_dt.value="";
		formObj.eff_st_dt.focus();
		return false;
	} else {
		formObj.eff_end_dt.value=to_dt;
	}
}

function sheet1_OnSearchEnd(sheetObj, code, errMsg){
	var startRow =1;
	var findRow = "";
	/*sheetObj.RenderSheet(0);
	for( var cnt =2 ; cnt < sheetObj.RowCount()+2 ; cnt++){
		if(sheetObj.GetCellValue(cnt , "cfm_flg") == "Y" ){
			var info = {Type: "CheckBox"};
		    sheetObj.InitCellProperty(cnt, "cfm_flg", info);
		    sheetObj.SetCellValue(cnt , "cfm_flg" , 1);
		} else if (sheetObj.GetCellValue(cnt , "cfm_flg") == "N"){
			var info = {Type: "CheckBox"};
		    sheetObj.InitCellProperty(cnt, "cfm_flg", info);
		    sheetObj.SetCellValue(cnt , "cfm_flg" , 0);
		}
	}
	sheetObj.RenderSheet(1);*/
	sheetObj.RenderSheet(0);
	if(sheetObj.RowCount() > 0){
		while(findRow != "-1"){
			findRow  = sheetObj.FindText("cfm_flg" , "Y" , startRow);
			if (findRow == -1) break;
			//alert(findRow+ "  " + startRow);
		    var info = {Type: "CheckBox", TrueValue:"Y", FalseValue:"N"};
		    sheetObj.InitCellProperty(findRow, "cfm_flg", info);
		    sheetObj.SetCellValue( findRow, "cfm_flg" , "1" , 0 );
		    startRow = parseInt(findRow, 10)+1;
		}
	}
	sheetObj.RenderSheet(1);
}