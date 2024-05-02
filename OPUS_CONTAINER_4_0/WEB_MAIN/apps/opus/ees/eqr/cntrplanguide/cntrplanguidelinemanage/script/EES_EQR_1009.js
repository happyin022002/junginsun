/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_1009.js
*@FileTitle  : Empty Repo Guideline Add/Amend.
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/15
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
/**
 * @extends
 * @class EES_EQR_1009 : EES_EQR_1009 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
/* 개발자 작업 */
// 공통전역변수
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0 ;
var comObjects=new Array();
var all_cntr_tpsz_cd="";
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
document.onclick=processButtonClick;
// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject=sheetObjects[0];
	/** **************************************************** */
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
			case "btn_apply":
				if (formObj.event_div.value == "A") {//Guideline Add
					if(valid_form("A")){
						ComOpenWait(true);
						doActionIBSheet(sheetObject, formObj, IBSEARCH);						
					}
				}else if(formObj.event_div.value == "M"){//Guideline Amend
					if (valid_form("M")) {
						ComOpenWait(true);
						doActionIBSheet(sheetObject, formObj, SEARCH06);	
						//setAmendData();
					}
				}
			break;
			case "btn_close":
				ComClosePopup(); 
			break;
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
       		formObj.f_cmd.value=SEARCH;
       		sheetObj.DoSearch("EES_EQR_1009GS.do", FormQueryString(formObj) );
       break;
	   case SEARCH06:      //조회
       		formObj.f_cmd.value=SEARCH06;
       		sheetObj.DoSearch("EES_EQR_1009GS.do", FormQueryString(formObj) );
       break;
	   case SEARCH10:      // LANE 선택시 VVD, PORT, ETA 조회 (TRADE, SUB TRADE 선택 완료 필수)
      		formObj.f_cmd.value=SEARCH10; 
      		var sXml=sheetObj.GetSearchData("EES_EQR_1009GS.do", FormQueryString(formObj));
			if (ComGetEtcData(sXml, "vvd_cd") !="" && ComGetEtcData(sXml, "vvd_cd") != "null") {
	      		formObj.s_vvd_cd.value=ComGetEtcData(sXml, "vvd_cd");
	      		formObj.s_pol_cd.value=ComGetEtcData(sXml, "pol_cd");
	      		formObj.s_eff_st_dt.value=ComGetEtcData(sXml, "eff_st_dt");
	      		formObj.s_eta_dt.value=ComGetEtcData(sXml, "etd_dt");
				set_pol_cd_combo(); //POL COMBO LIST SEARCH
			}else { // vvd 검색값이 없음.
				ComShowCodeMessage("EQR01139");  //Can''/t found VVD (bound to Asia Area)
	      		formObj.s_vvd_cd.value="";
	      		formObj.s_pol_cd.value="";
	      		formObj.s_eff_st_dt.value="";
	      		formObj.s_eta_dt.value="";				
			}      		
      break;       
    }
}
/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * MultiSelectCombo Object를 배열로 등록
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
function loadPage() {
	var formObj=document.form;
	var opener=window;
	var opener_sheetobj=opener.document.sheet1;
	searchOptionTrade("trade", true, true); 		// Trade Combo box
	searchOptionSubTrade("subtrade", true, true); 	// Sub Trade Combo box
	searchOptionLane("lane", true, true); 			// Service Lane Combo box
	for(i=0;i<sheetObjects.length;i++){
    	//시작 환경 설정 함수 이름 변경
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
		//마지막 환경 설정 함수 추가
        ComEndConfigSheet(sheetObjects[i]);
    }
	if(formObj.event_div.value=="M"){
		var trd_cd=opener_sheetobj.GetCellValue(opener_sheetobj.GetSelectRow(),"trd_cd");
		var sub_trd_cd=opener_sheetobj.GetCellValue(opener_sheetobj.GetSelectRow(),"sub_trd_cd");
		var vsl_lane_cd=opener_sheetobj.GetCellValue(opener_sheetobj.GetSelectRow(),"vsl_lane_cd");
		comboObjects[0].SetSelectCode(trd_cd);
		comboObjects[1].SetSelectCode(trd_cd+sub_trd_cd);
		comboObjects[2].SetSelectCode(trd_cd+sub_trd_cd+vsl_lane_cd);
	//	getAmendData();
		ComOpenWait(false);
		comboObjects[0].SetEnable(0);
		comboObjects[1].SetEnable(0);
		comboObjects[2].SetEnable(0);
		// POL ComboBox Setting
		set_pol_cd_combo();
	}else{
		ComOpenWait(false);
	}
	form.cntr_tpsz_cd.value=("D2,D4,D5,D7,R2,R5,R9,O2,O4,O5,S2,S4,F2,F4,F5,A2,A4").toLowerCase();
	all_cntr_tpsz_cd=(opener.document.form.cntr_tpsz_cd.value).split(","); 
}
/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo){
	var cnt=0;
	switch (sheetNo) {
		case 1: // sheet1 init
			with (sheetObj) {
		        var HeadTitle0="Trade|Sub|LANE|Effective|Effective|Effective|Effective|Effective|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Remark|Expiration\nDate|Update\nDate|Update\nUser|Confirm|";
		        var HeadTitle1="Trade|Sub|LANE|VVD|POL|ETA|GLINE_SEQ|POD|D2|D2|D4|D4|D5|D5|D7|D7|R2|R2|R5|R5|R9|R9|O2|O2|O4|O4|O5|O5|S2|S2|S4|S4|F2|F2|F4|F4|F5|F5|A2|A2|A4|A4|Remark|Expiration\nDate|Update\nDate|Update\nUser|Confirm|";
	
		        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
		        var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
		        var headers = [ { Text:HeadTitle0, Align:"Center"},
		                    { Text:HeadTitle1, Align:"Center"} ];
		        InitHeaders(headers, info);
	
		        var cols = [ {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vsl_lane_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vvd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eta_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eq_gline_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
			               {Type:"Int",       Hidden:0,  Width:30,   Align:"Right",   ColMerge:0,   SaveName:"qty_d2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:true,UpdateEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:30,   Align:"Right",   ColMerge:0,   SaveName:"ut_d2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
			               {Type:"Int",       Hidden:0,  Width:30,   Align:"Right",   ColMerge:0,   SaveName:"qty_d4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:true,UpdateEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:30,   Align:"Right",   ColMerge:0,   SaveName:"ut_d4",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
			               {Type:"Int",       Hidden:0,  Width:30,   Align:"Right",   ColMerge:0,   SaveName:"qty_d5",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:true,UpdateEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:30,   Align:"Right",   ColMerge:0,   SaveName:"ut_d5",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
			               {Type:"Int",       Hidden:0,  Width:30,   Align:"Right",   ColMerge:0,   SaveName:"qty_d7",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:true,UpdateEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:30,   Align:"Right",   ColMerge:0,   SaveName:"ut_d7",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
			               {Type:"Int",       Hidden:0,  Width:30,   Align:"Right",   ColMerge:1,   SaveName:"qty_r2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:true,UpdateEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:30,   Align:"Right",   ColMerge:1,   SaveName:"ut_r2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
			               {Type:"Int",       Hidden:0,  Width:30,   Align:"Right",   ColMerge:1,   SaveName:"qty_r5",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:true,UpdateEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:30,   Align:"Right",   ColMerge:1,   SaveName:"ut_r5",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
			               {Type:"Int",       Hidden:0,  Width:30,   Align:"Right",   ColMerge:1,   SaveName:"qty_r9",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:true,UpdateEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:30,   Align:"Right",   ColMerge:1,   SaveName:"ut_r9",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
			               {Type:"Int",       Hidden:0,  Width:30,   Align:"Right",   ColMerge:1,   SaveName:"qty_o2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:true,UpdateEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:30,   Align:"Right",   ColMerge:1,   SaveName:"ut_o2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
			               {Type:"Int",       Hidden:0,  Width:30,   Align:"Right",   ColMerge:1,   SaveName:"qty_o4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:true,UpdateEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:30,   Align:"Right",   ColMerge:1,   SaveName:"ut_o4",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
			               {Type:"Int",       Hidden:0,  Width:30,   Align:"Right",   ColMerge:1,   SaveName:"qty_o5",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:true,UpdateEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:30,   Align:"Right",   ColMerge:1,   SaveName:"ut_o5",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
			               {Type:"Int",       Hidden:0,  Width:30,   Align:"Right",   ColMerge:1,   SaveName:"qty_s2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:true,UpdateEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:30,   Align:"Right",   ColMerge:1,   SaveName:"ut_s2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
			               {Type:"Int",       Hidden:0,  Width:30,   Align:"Right",   ColMerge:1,   SaveName:"qty_s4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:true,UpdateEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:30,   Align:"Right",   ColMerge:1,   SaveName:"ut_s4",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
			               {Type:"Int",       Hidden:0,  Width:30,   Align:"Right",   ColMerge:1,   SaveName:"qty_f2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:true,UpdateEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:30,   Align:"Right",   ColMerge:1,   SaveName:"ut_f2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
			               {Type:"Int",       Hidden:0,  Width:30,   Align:"Right",   ColMerge:1,   SaveName:"qty_f4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:true,UpdateEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:30,   Align:"Right",   ColMerge:1,   SaveName:"ut_f4",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
			               {Type:"Int",       Hidden:0,  Width:30,   Align:"Right",   ColMerge:1,   SaveName:"qty_f5",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:true,UpdateEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:30,   Align:"Right",   ColMerge:1,   SaveName:"ut_f5",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
			               {Type:"Int",       Hidden:0,  Width:30,   Align:"Right",   ColMerge:1,   SaveName:"qty_a2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:true,UpdateEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:30,   Align:"Right",   ColMerge:1,   SaveName:"ut_a2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
			               {Type:"Int",       Hidden:0,  Width:30,   Align:"Right",   ColMerge:1,   SaveName:"qty_a4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:true,UpdateEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:30,   Align:"Right",   ColMerge:1,   SaveName:"ut_a4",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"repo_gline_rmk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"eff_end_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"upd_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"upd_usr_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"upd_usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"cfm_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eff_st_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"col_div",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"vsl_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"skd_voy_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"skd_dir_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"sort_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 } ];
		         
		        InitColumns(cols);
	
		        SetEditable(1);
		        SetEditableColorDiff(0);
//		        SetSheetHeight(0);
		        SetVisible(false);
			}
		break;
	}
}
/**
 * OnSearchEnd 이벤트 발생시 호출되는 function <br>
 * @author 
 * @version
 */ 
function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	var opener=window;
	var opener_sheetobj=opener.document.sheet1;
	var formObj=document.form;
	var opn_last_row=parseInt(opener_sheetobj.LastRow());
	var cntr_tpsz_cd=opener.document.form.cntr_tpsz_cd.value;
	var mrg_fm_row=0;
	var mrg_to_row=0;
	var arr_tp_sz=cntr_tpsz_cd.split(",");
	if(opener_sheetobj.RowCount()>0 ){
		mrg_fm_row=Number(opener_sheetobj.GetMergedStartCell(opener_sheetobj.GetSelectRow(), "pol_cd").split(",")[0]);
		mrg_to_row=Number(opener_sheetobj.GetMergedEndCell(opener_sheetobj.GetSelectRow(),"pol_cd").split(",")[0]);
	}
	if(formObj.event_div.value=="A"){	// Guideline Amend일 경우
		if(sheetObj.RowCount()> 0){
			opn_last_row=opn_last_row+1;
			for(var i=0;i<sheetObj.RowCount();i++){
		      opener_sheetobj.DataInsert(-1);
			  opener_sheetobj.SetCellValue(opener_sheetobj.LastRow(),"trd_cd",sheetObj.GetCellValue(i+2,"trd_cd"));
			  opener_sheetobj.SetCellFont("FontBold",opener_sheetobj.LastRow(),"trd_cd",1);
			  opener_sheetobj.SetCellValue(opener_sheetobj.LastRow(),"sub_trd_cd", sheetObj.GetCellValue(i+2,"sub_trd_cd"));
			  opener_sheetobj.SetCellFont("FontBold",opener_sheetobj.LastRow(),"sub_trd_cd",1);
			  opener_sheetobj.SetCellValue(opener_sheetobj.LastRow(),"vsl_lane_cd",sheetObj.GetCellValue(i+2,"vsl_lane_cd"));
			  opener_sheetobj.SetCellFont("FontBold",opener_sheetobj.LastRow(),"vsl_lane_cd",1);
			  opener_sheetobj.SetCellValue(opener_sheetobj.LastRow(),"eq_gline_seq",opn_last_row);
			  opener_sheetobj.SetCellFont("FontBold",opener_sheetobj.LastRow(),"eq_gline_seq",1);
			  opener_sheetobj.SetCellValue(opener_sheetobj.LastRow(),"vvd",sheetObj.GetCellValue(i+2,"vvd"));
			  opener_sheetobj.SetCellFont("FontBold",opener_sheetobj.LastRow(),"vvd",1);
			  opener_sheetobj.SetCellValue(opener_sheetobj.LastRow(),"pol_cd",sheetObj.GetCellValue(i+2,"pol_cd"));
			  opener_sheetobj.SetCellFont("FontBold",opener_sheetobj.LastRow(),"pol_cd",1);
			  //Priority, % 비활성화.
			  if (sheetObj.GetCellValue(i + 2, "sort_id") == "1" || sheetObj.GetCellValue(i + 2, "sort_id") == "2") {
			  	opener_sheetobj.SetCellEditable(opener_sheetobj.GetSelectRow(),"pod_cd",0);
			  }
			  opener_sheetobj.SetCellValue(opener_sheetobj.LastRow(),"eta_dt", sheetObj.GetCellValue(i+2,"eta_dt"));
			  opener_sheetobj.SetCellFont("FontBold",opener_sheetobj.LastRow(),"eta_dt",1);
			  opener_sheetobj.SetCellValue(opener_sheetobj.LastRow(),"repo_gline_rmk", sheetObj.GetCellValue(i+2,"repo_gline_rmk"));
			  opener_sheetobj.SetCellFont("FontBold",opener_sheetobj.LastRow(),"repo_gline_rmk",1);
			  opener_sheetobj.SetCellValue(opener_sheetobj.LastRow(),"eff_st_dt", sheetObj.GetCellValue(i+2,"eff_st_dt"));
			  opener_sheetobj.SetCellFont("FontBold",opener_sheetobj.LastRow(),"eff_st_dt",1);
			  opener_sheetobj.SetCellValue(opener_sheetobj.LastRow(),"pod_cd", sheetObj.GetCellValue(i+2,"pod_cd"));
			  opener_sheetobj.SetCellFont("FontBold",opener_sheetobj.LastRow(),"pod_cd",1);
			  opener_sheetobj.SetCellValue(opener_sheetobj.LastRow(),"vsl_cd", sheetObj.GetCellValue(i+2,"vsl_cd"));
			  opener_sheetobj.SetCellFont("FontBold",opener_sheetobj.LastRow(),"vsl_cd",1);
			  //Container Type Size별 Column Font Bold설정
			  for(var j=0;j<arr_tp_sz.length;j++){
			  	var col_qty=arr_tp_sz[j]+"_qty";
				var col_ut=arr_tp_sz[j]+"_ut";
			  	if(sheetObj.SetCellValue(i+2,"sort_id")=="1"){
					opener_sheetobj.SetCellEditable(opener_sheetobj.LastRow(),col_qty,0);
				}
			  	opener_sheetobj.SetCellFont("FontBold",opener_sheetobj.LastRow(),col_qty,1);
			  	opener_sheetobj.SetCellFont("FontBold",opener_sheetobj.LastRow(),col_ut,1);
			  }
			  if (sheetObj.SetCellValue(i + 2, "sort_id") == "1" || sheetObj.SetCellValue(i + 2, "sort_id") == "2") {
			  	opener_sheetobj.SetCellEditable(opener_sheetobj.GetSelectRow(),"cfm_flg",0);
			  }
			  opener_sheetobj.SetCellValue(opener_sheetobj.LastRow(),"skd_voy_no",sheetObj.GetCellValue(i+2,"skd_voy_no"));
			  opener_sheetobj.SetCellValue(opener_sheetobj.LastRow(),"skd_dir_cd",sheetObj.GetCellValue(i+2,"skd_dir_cd"));
			  opener_sheetobj.SetCellValue(opener_sheetobj.LastRow(),"sort_id",sheetObj.GetCellValue(i+2,"sort_id"));
			  opener_sheetobj.SetRowFontColor(opener_sheetobj.LastRow(),"#FF0000");
			}
			ComClosePopup(); 
		}
		ComOpenWait(false);
	}else{  // GuideLine New
		if(sheetObj.RowCount()== 0){
			getAmendData();
		}else{
			//Guideline Header Copy Start 
			sheetObj.SetCellValue(sheetObj.SetTopRow,"eq_gline_seq",opn_last_row);
			sheetObj.SetCellValue(sheetObj.SetTopRow,"repo_gline_rmk", opener_sheetobj.GetCellValue(mrg_fm_row,"repo_gline_rmk"))();
			sheetObj.SetCellValue(sheetObj.SetTopRow,"sort_id","2");
			sheetObj.DataInsert(0);
			sheetObj.SetCellValue(sheetObj.SetSelectRow,"trd_cd",opener_sheetobj.GetCellValue(mrg_fm_row,"trd_cd"));
			sheetObj.SetCellValue(sheetObj.SetSelectRow,"sub_trd_cd",opener_sheetobj.GetCellValue(mrg_fm_row,"sub_trd_cd"));
			sheetObj.SetCellValue(sheetObj.SetSelectRow,"vsl_lane_cd",opener_sheetobj.GetCellValue(mrg_fm_row,"vsl_lane_cd"));
			sheetObj.SetCellValue(sheetObj.SetSelectRow,"eq_gline_seq",opn_last_row);
			sheetObj.SetCellValue(sheetObj.SetSelectRow,"vvd",formObj.s_vvd_cd.value);
			sheetObj.SetCellValue(sheetObj.SetSelectRow,"pol_cd",opener_sheetobj.GetCellValue(mrg_fm_row,"pol_cd"));
			sheetObj.SetCellValue(sheetObj.SetSelectRow,"eta_dt",formObj.s_eta_dt.value);
			sheetObj.SetCellValue(sheetObj.SetSelectRow,"repo_gline_rmk",opener_sheetobj.GetCellValue(mrg_fm_row,"repo_gline_rmk"));
			sheetObj.SetCellValue(sheetObj.SetSelectRow,"eff_st_dt",opener_sheetobj.GetCellValue(mrg_fm_row,"eff_st_dt"));
			sheetObj.SetCellValue(sheetObj.SetSelectRow,"pod_cd",opener_sheetobj.GetCellValue(mrg_fm_row,"pod_cd"));
			sheetObj.SetCellValue(sheetObj.SetSelectRow,"vsl_cd",opener_sheetobj.GetCellValue(mrg_fm_row,"vsl_cd"));
			for(var i=0; i <all_cntr_tpsz_cd.length;i++){
				var ut="ut_"
				var qty="qty_"
				var opn_ut="_ut";
				var opn_qty="_qty";
				sheetObj.SetCellValue(sheetObj.SetSelectRow,qty+all_cntr_tpsz_cd[i], opener_sheetobj.GetCellValue(mrg_fm_row,all_cntr_tpsz_cd[i]+opn_qty));
				sheetObj.SetCellValue(sheetObj.SetSelectRow,ut+all_cntr_tpsz_cd[i], opener_sheetobj.GetCellValue(mrg_fm_row,all_cntr_tpsz_cd[i]+opn_ut));
			}
			 sheetObj.SetCellValue(sheetObj.SetSelectRow,"eff_end_dt")("");
			 sheetObj.SetCellValue(sheetObj.SetSelectRow,"vsl_cd",(formObj.s_vvd_cd.value).substring(0,4));
			 sheetObj.SetCellValue(sheetObj.SetSelectRow,"skd_voy_no",(formObj.s_vvd_cd.value).substring(4,8));
			 sheetObj.SetCellValue(sheetObj.SetSelectRow,"skd_dir_cd",(formObj.s_vvd_cd.value).substring(8,9));
			 sheetObj.SetCellValue(sheetObj.SetSelectRow,"sort_id","1");
			//Guideline Header Copy End 
			//POD COPY
			for(var i=mrg_fm_row;i<=mrg_to_row;i++ ){
				if(opener_sheetobj.SetCellValue(i,"sort_id")=="3"){
					 sheetObj.DataInsert(-1);
					 sheetObj.SetCellValue(sheetObj.LastRow(),"trd_cd",opener_sheetobj.GetCellValue(i,"trd_cd"));
					 sheetObj.SetCellValue(sheetObj.LastRow(),"sub_trd_cd",opener_sheetobj.GettCellValue(i,"sub_trd_cd"));
					 sheetObj.SetCellValue(sheetObj.LastRow(),"vsl_lane_cd",opener_sheetobj.SetCellValue(i,"vsl_lane_cd"));
					 sheetObj.SetCellValue(sheetObj.LastRow(),"vvd",formObj.s_vvd_cd.value);
					 sheetObj.SetCellValue(sheetObj.LastRow(),"pol_cd",formObj.s_pol_cd.value);
					 sheetObj.SetCellValue(sheetObj.LastRow(),"eta_dt", formObj.s_eta_dt.value);
					 sheetObj.SetCellValue(sheetObj.LastRow(),"eff_st_dt", formObj.s_eff_st_dt.value);
					 sheetObj.SetCellValue(sheetObj.LastRow(),"eq_gline_seq",opn_last_row);
					 sheetObj.SetCellValue(sheetObj.LastRow(),"pod_cd",opener_sheetobj.GetCellValue(i,"pod_cd"));
					 sheetObj.SetCellValue(sheetObj.LastRow(),"vsl_lane_cd",opener_sheetobj.GetCellValue(i,"vsl_lane_cd"));
					 sheetObj.SetCellValue(sheetObj.LastRow(),"vsl_cd", opener_sheetobj.GetCellValue(i,"vsl_cd"));
					 sheetObj.SetCellValue(sheetObj.LastRow(),"skd_voy_no",opener_sheetobj.GetCellValue(i,"skd_voy_no"));
					 sheetObj.SetCellValue(sheetObj.LastRow(),"skd_dir_cd",opener_sheetobj.GetCellValue(i,"skd_dir_cd"));
					for(var j=0; j <all_cntr_tpsz_cd.length;j++){
						var ut="ut_";
						var qty="qty_";
						var opn_ut="_ut";
						var opn_qty="_qty";
						sheetObj.SetCellValue(sheetObj.LastRow(),qty+all_cntr_tpsz_cd[j], opener_sheetobj.GetCellValue(i,all_cntr_tpsz_cd[j]+opn_qty));
						sheetObj.SetCellValue(sheetObj.LastRow(),ut+all_cntr_tpsz_cd[j], opener_sheetobj.GetCellValue(i,all_cntr_tpsz_cd[j]+opn_ut));
					}
					 sheetObj.SetCellValue(sheetObj.LastRow(),"repo_gline_rmk",opener_sheetobj.GetCellValue(i,"repo_gline_rmk"));
					 sheetObj.SetCellValue(sheetObj.LastRow(),"eff_end_dt",opener_sheetobj.GetCellValue(i,"eff_end_dt"));
					 sheetObj.SetCellValue(sheetObj.LastRow(),"vsl_cd",(formObj.s_vvd_cd.value).substring(0,4));
					 sheetObj.SetCellValue(sheetObj.LastRow(),"skd_voy_no",(formObj.s_vvd_cd.value).substring(4,8));
					 sheetObj.SetCellValue(sheetObj.LastRow(),"skd_dir_cd",(formObj.s_vvd_cd.value).substring(8,9));
					 sheetObj.SetCellValue(sheetObj.LastRow(),"sort_id","3");
				}
			}//end for(var i=mrg_fm_row;i<=mrg_to_row;i++ )
		}
		//최종 데이터 MAIN창에 적용
		setAmendData();
		ComOpenWait(false);
  ComClosePopup(); 
	}
}
/** 
 * Guideline Amend시 main화면의 데이터를 팝업으로 데이터 카피
 */
function getAmendData() {
	var sheetObj=sheetObjects[0];
	var opener=window;
	var opener_sheetobj=opener.document.sheet1;
	var formObj=document.form;
	var mrg_fm_row=Number(opener_sheetobj.GetMergedStartCell(opener_sheetobj.GetSelectRow(), "pol_cd").split(",")[0]);
	var mrg_to_row=Number(opener_sheetobj.GetMergedEndCell(opener_sheetobj.GetSelectRow(),"pol_cd").split(",")[0]);
	for(var i=mrg_fm_row;i<=mrg_to_row;i++ ){
		 sheetObj.DataInsert(-1);
		 sheetObj.SetCellValue(sheetObj.LastRow(),"trd_cd",opener_sheetobj.GetCellValue(i,"trd_cd"));
		 sheetObj.SetCellValue(sheetObj.LastRow(),"sub_trd_cd",opener_sheetobj.GetCellValue(i,"sub_trd_cd"));
		 sheetObj.SetCellValue(sheetObj.LastRow(),"vsl_lane_cd",opener_sheetobj.GetCellValue(i,"vsl_lane_cd"));
		 sheetObj.SetCellValue(sheetObj.LastRow(),"vvd",formObj.s_vvd_cd.value);
		 sheetObj.SetCellValue(sheetObj.LastRow(),"pol_cd",formObj.s_pol_cd.value);
		 sheetObj.SetCellValue(sheetObj.LastRow(),"eta_dt",formObj.s_eta_dt.value);
		 sheetObj.SetCellValue(sheetObj.LastRow(),"eff_st_dt",formObj.s_eff_st_dt.value);
		 sheetObj.SetCellValue(sheetObj.LastRow(),"eq_gline_seq",parseInt(opener_sheetobj.LastRow())+1);
		 sheetObj.SetCellValue(sheetObj.LastRow(),"repo_gline_rmk",opener_sheetobj.GetCellValue(i,"repo_gline_rmk"));
		 sheetObj.SetCellValue(sheetObj.LastRow(),"pod_cd",opener_sheetobj.GetCellValue(i,"pod_cd"));
		 sheetObj.SetCellValue(sheetObj.LastRow(),"vsl_lane_cd",opener_sheetobj.GetCellValue(i,"vsl_lane_cd"));
		 sheetObj.SetCellValue(sheetObj.LastRow(),"vsl_cd",opener_sheetobj.GetCellValue(i,"vsl_cd"));
		 sheetObj.SetCellValue(sheetObj.LastRow(),"skd_voy_no",opener_sheetobj.GetCellValue(i,"skd_voy_no"));
		 sheetObj.SetCellValue(sheetObj.LastRow(),"skd_dir_cd",opener_sheetobj.GetCellValue(i,"skd_dir_cd"));
		for(var j=0; j <all_cntr_tpsz_cd.length;j++){
			var ut="ut_"
			var qty="qty_"
			var opn_ut="_ut"
			var opn_qty="_qty"
			if(opener_sheetobj.SetCellValue(i,"sort_id")=="2"){
				sheetObj.SetCellValue(sheetObj.LastRow(),qty+all_cntr_tpsz_cd[j],"");
				sheetObj.SetCellValue(sheetObj.LastRow(),ut+all_cntr_tpsz_cd[j],"");
			}else{
				sheetObj.SetCellValue(sheetObj.LastRow(),qty+all_cntr_tpsz_cd[j],opener_sheetobj.GetCellValue(i,all_cntr_tpsz_cd[j]+opn_qty));
				sheetObj.SetCellValue(sheetObj.LastRow(),ut+all_cntr_tpsz_cd[j],opener_sheetobj.GetCellValue(i,all_cntr_tpsz_cd[j]+opn_ut));
			}
		}
		sheetObj.SetCellValue(sheetObj.LastRow(),"eff_end_dt",opener_sheetobj.GetCellValue(i,"eff_end_dt"));
		sheetObj.SetCellValue(sheetObj.LastRow(),"vsl_cd",(formObj.s_vvd_cd.value).substring(0,4));
		sheetObj.SetCellValue(sheetObj.LastRow(),"skd_voy_no",(formObj.s_vvd_cd.value).substring(4,8));
		sheetObj.SetCellValue(sheetObj.LastRow(),"skd_dir_cd",(formObj.s_vvd_cd.value).substring(8,9));
		sheetObj.SetCellValue(sheetObj.LastRow(),"sort_id",opener_sheetobj.GetCellValue(i,"sort_id"));
	}
}
/** 
 * Guideline Amend시 팝업의 그리드 데이터를 main화면으로 데이터 카피
 * Main화면의 선택한 Row의 Merge끝 셀로 퍼커스 이동 후 Grid Add한다.
 * Note : DataInsert() 후 Add된 Row로 focus가 이동하므로 SelectRow 사용함.
 */
function setAmendData() {
	var sheetObj=sheetObjects[0];
	var opener=window;
	var opener_sheetobj=opener.document.sheet1;
	var formObj=document.form;
	var mrg_to_row=Number(opener_sheetobj.GetMergedEndCell(opener_sheetobj.GetSelectRow(),"pol_cd").split(",")[0]);
	opener_sheetobj.SelectCell(mrg_to_row,"pod_cd"); //DataInsert()하기 위해 Focus이동
	for(var i=0;i<sheetObj.RowCount();i++ ){
		 opener_sheetobj.DataInsert();
		 opener_sheetobj.SetCellValue(opener_sheetobj.SetSelectRow,"trd_cd",sheetObj.GetCellValue(i+2,"trd_cd"));
		 opener_sheetobj.SetCellValue(opener_sheetobj.SetSelectRow,"sub_trd_cd",sheetObj.GetCellValue(i+2,"sub_trd_cd"));
		 opener_sheetobj.SetCellValue(opener_sheetobj.SetSelectRow,"vsl_lane_cd",sheetObj.GetCellValue(i+2,"vsl_lane_cd"));
		 opener_sheetobj.SetCellValue(opener_sheetobj.SetSelectRow,"vvd",formObj.s_vvd_cd.value);
		 opener_sheetobj.SetCellValue(opener_sheetobj.SetSelectRow,"pol_cd",formObj.s_pol_cd.value);
		 opener_sheetobj.SetCellValue(opener_sheetobj.SetSelectRow,"eta_dt",formObj.s_eta_dt.value);
		 opener_sheetobj.SetCellValue(opener_sheetobj.SetSelectRow,"eff_st_dt",formObj.s_eff_st_dt.value);
		 opener_sheetobj.SetCellValue(opener_sheetobj.SetSelectRow,"eq_gline_seq",sheetObj.GetCellValue(i+2,"eq_gline_seq"));
		 opener_sheetobj.SetCellValue(opener_sheetobj.SetSelectRow,"pod_cd",sheetObj.GetCellValue(i+2,"pod_cd"));
		 //Priority, % 비활성화.
		 if (sheetObj.GetCellValue(i + 2, "sort_id") == "1" || sheetObj.GetCellValue(i + 2, "sort_id") == "2") {
		 	 opener_sheetobj.SetCellEditable(opener_sheetobj.GetSelectRow(),"pod_cd",0);
		 }
		 opener_sheetobj.SetCellValue(opener_sheetobj.SetSelectRow,"vsl_cd",sheetObj.GetCellValue(i+2,"vsl_cd"));
		 opener_sheetobj.SetCellValue(opener_sheetobj.SetSelectRow,"skd_voy_no",sheetObj.GetCellValue(i+2,"skd_voy_no"));
		 opener_sheetobj.SetCellValue(opener_sheetobj.SetSelectRow,"skd_dir_cd",sheetObj.GetCellValue(i+2,"skd_dir_cd"));
		for(var j=0; j<all_cntr_tpsz_cd.length;j++){
			var ut="ut_";
			var qty="qty_";
			var opn_ut="_ut";
			var opn_qty="_qty";
			if(sheetObj.SetCellValue(i+2,"sort_id")=="1"){
				opener_sheetobj.SetCellEditable(opener_sheetobj.GetSelectRow(),all_cntr_tpsz_cd[j]+opn_qty,0);
			}
			opener_sheetobj.SetCellValue(opener_sheetobj.SetSelectRow,all_cntr_tpsz_cd[j]+opn_qty,sheetObj.GetCellValue(i+2,qty+all_cntr_tpsz_cd[j]));
		 	opener_sheetobj.SetCellValue(opener_sheetobj.SetSelectRow,all_cntr_tpsz_cd[j]+opn_ut,sheetObj.GetCellValue(i+2,ut+all_cntr_tpsz_cd[j]));
		}
		 opener_sheetobj.SetCellEditable(opener_sheetobj.GetSelectRow(),"cfm_flg",0);
		 opener_sheetobj.SetCellValue(opener_sheetobj.SetSelectRow,"repo_gline_rmk",sheetObj.GetCellValue(i+2,"repo_gline_rmk"));
		 opener_sheetobj.SetCellValue(opener_sheetobj.SetSelectRow,"eff_end_dt",sheetObj.GetCellValue(i+2,"eff_end_dt"));
		 opener_sheetobj.SetCellValue(opener_sheetobj.SetSelectRow,"vsl_cd",(formObj.s_vvd_cd.value).substring(0,4));
		 opener_sheetobj.SetCellValue(opener_sheetobj.SetSelectRow,"skd_voy_no",(formObj.s_vvd_cd.value).substring(4,8));
		 opener_sheetobj.SetCellValue(opener_sheetobj.SetSelectRow,"skd_dir_cd",(formObj.s_vvd_cd.value).substring(8,9));
		 opener_sheetobj.SetCellValue(opener_sheetobj.SetSelectRow,"sort_id",sheetObj.SetCellValue(i+2,"sort_id"));
	}
}
/**
 * OnChange 이벤트 발생시 호출되는 function <br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
 * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
 * @param {int} text 필수 화면에 표시된 글자
 * @return 없음
 * @author 
 * @version
 */ 
function trade_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	if (newCode != null && newCode != "") {  			
		subtrade.SetSelectCode("",false);
		lane.SetSelectCode("",false);
	}
	searchOptionSubTrade("subtrade",true,false,"","",newCode);			
	searchOptionLane("lane",true,true,'',newCode,'',true);	
}
/**
 * OnChange 이벤트 발생시 호출되는 function <br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
 * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
 * @param {int} text 필수 화면에 표시된 글자
 * @return 없음
 * @author 
 * @version
 */ 
//Find or create function combo_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode)
//function subtrade_OnChange(comboObj, value, text) {
function subtrade_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	searchOptionLane("lane",true,true,'',trade.GetSelectCode(),newCode,true);
	if(newCode == ""){
		comboObjects[0].SetSelectCode('');
		return;
	} 
//	alert(newCode+subtrade.GetText(newCode,0));
	var arrTrade=newCode;
	var str_trd_cd="";
	if(arrTrade.length > 1) {
//		for(var i=0; i<arrTrade.length;i++){
//			str_trd_cd=str_trd_cd+ (arrTrade[i]).substring(0,3)+",";
//		}
//		str_trd_cd=str_trd_cd.substring(0,str_trd_cd.length-1);
		comboObjects[0].SetSelectCode(newCode.substring(0,3),false);
		comboObjects[2].SetSelectCode('',false);
	} else {
		comboObjects[0].SetSelectCode(newCode.substring(0,3),false);
		comboObjects[2].SetSelectCode('',false);
	}
//	document.getElemementById("subtrade_text")
	document.form.subtrade_text.value = newCode;
}
/**
 * OnChange 이벤트 발생시 호출되는 function <br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
 * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
 * @param {int} text 필수 화면에 표시된 글자
 * @return 없음
 * @author 
 * @version
 */ 
function lane_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	var sheetObject=sheetObjects[0];
	var formObj=document.form;
	if (comboObjects[0].GetSelectCode()== "") {
		formObj.s_vvd_cd.value="";
		ComShowCodeMessage("EQR01110", "Trade");//Trade를 입력하세요.';
		return;
	}else if (comboObjects[1].GetSelectCode()== "") {
		formObj.s_vvd_cd.value="";
		ComShowCodeMessage("EQR01110", "Sub Trade");//Sub Trade를 입력하세요.';
		return;
	}	
	doActionIBSheet(sheetObject, formObj, SEARCH10);				
}
/**
 * form의 VVD Code변경시 유호한 VVD인지를 검증한다.
 */
function change_vvd() {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	var sXml="";
	var rtn_val="";
	if (comboObjects[0].GetSelectCode()== "") {
		formObj.s_vvd_cd.value="";
		ComShowCodeMessage("EQR01110", "Trade");//Trade를 입력하세요.';
		return;
	}else if (comboObjects[1].GetSelectCode()== "") {
		formObj.s_vvd_cd.value="";
		ComShowCodeMessage("EQR01110", "Sub Trade");//Sub Trade를 입력하세요.';
		return;
	}else if (comboObjects[2].GetSelectCode()== "") {
		formObj.s_vvd_cd.value="";
		ComShowCodeMessage("EQR01110", "Lane");//Lane를 입력하세요.';
		return;
	}
	ComOpenWait(true);
	ComClearCombo(formObj.s_pol_cd); //POL CD COMBO초기화
	if(comboObjects[2].GetSelectCode()!= ''){ //lane comboBox가 Null이 아닐경우
		 // VVD 유효성 체크
		 formObj.f_cmd.value=SEARCH01;
		 sXml=sheetObj.GetSearchData("EES_EQR_1009GS.do" , FormQueryString(formObj));
		 rtn_val=ComGetEtcData(sXml,"vvd_check");
		 if(rtn_val !="T"){
		 	formObj.s_vvd_cd.value="";
			ComClearCombo(formObj.s_pol_cd); //POL CD COMBO초기화
			formObj.s_eta_dt.value="";
			formObj.s_eff_st_dt.value="";
			ComOpenWait(false);
		 	ComShowCodeMessage("EQR01103","VVD"); //유효하지 않은 VVD입니다.
			return;
		 }else if(rtn_val =="T"){
		 	// VVD ETA, POL조회
		 	formObj.f_cmd.value=SEARCH02;
		 	sXml=sheetObj.GetSearchData("EES_EQR_1009GS.do" , FormQueryString(formObj));
			var str_vvd_cd=ComGetEtcData(sXml,"vvd_cd");
			var str_pol_cd=ComGetEtcData(sXml,"pol_cd");
			var str_eff_st_dt=ComGetEtcData(sXml,"eff_st_dt");
			var str_eta_dt=ComGetEtcData(sXml,"eta_dt");
			if (str_vvd_cd !="" && str_vvd_cd != "null") {
				formObj.s_vvd_cd.value=str_vvd_cd;
				set_pol_cd_combo(); //POL COMBO LIST SETTING
			}else{
				formObj.s_vvd_cd.value="";
			}
			if (str_pol_cd != "" && str_pol_cd != "null" ) {
				formObj.s_pol_cd.value=str_pol_cd;
				change_pol();		//POL COMBO 변경시 ETA조회
			}else{
				formObj.s_pol_cd.value="";
			}
			if(str_eff_st_dt != "" && str_eff_st_dt != "null"){
				formObj.s_eff_st_dt.value=str_eff_st_dt;	
			}else{
				formObj.s_eff_st_dt.value="";
			}
			if(str_eta_dt!="" && str_eta_dt != "null"){
				formObj.s_eta_dt.value=str_eta_dt;			
			}else{
				formObj.s_eta_dt.value="";
			}
		 }
	 }
	 ComOpenWait(false);
}
/**
 * KeyPress 변경시 이벤트 처리
 * @author SHIN DONG IL
 * @version 2013.07.15 
 */
//function form_keypress(){
//	var formObj=document.form;
//	switch (event.srcElement.name) {
//		case "s_vvd_cd":
//			ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자,숫자만 입력허용
//		break;
//	}
//}
/**
 * form의 POL Code변경시 ETA 조회하여 결과값 설정한다.
 */
function change_pol(){
	var formObj=document.form;
	var sheetObj=sheetObjects[0];	
	formObj.f_cmd.value=SEARCH05;
	sXml=sheetObj.GetSearchData("EES_EQR_1009GS.do" , FormQueryString(formObj));
	var str_eta_dt=ComGetEtcData(sXml,"eta_dt");
	var str_eff_st_dt=ComGetEtcData(sXml,"eff_st_dt");
	if(str_eta_dt == "" ||  str_eta_dt == "null"){
		formObj.s_eta_dt.value="";
	}else{
		formObj.s_eta_dt.value=str_eta_dt;
	}
	if(str_eff_st_dt == "" ||  str_eff_st_dt == "null"){
		formObj.s_eff_st_dt.value="";
	}else{
		formObj.s_eff_st_dt.value=str_eff_st_dt;
	}
}
/**
 * form의 Pol Cd Combo.
 */
function set_pol_cd_combo() {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	var sXml="";
	var rtn_val="";
	var arr_pol_cd="";
	 formObj.f_cmd.value=SEARCH03;
	 sXml=sheetObj.GetSearchData("EES_EQR_1009GS.do" , FormQueryString(formObj));
	 rtn_val=ComGetEtcData(sXml,"pol_cd");
	 if (rtn_val != "" && rtn_val != "null") {
	 	arr_pol_cd=rtn_val.split("|");
	 	if (arr_pol_cd.length > 0) {
	 		for (var i=0; i < arr_pol_cd.length; i++) {
	 			ComAddComboItem(formObj.s_pol_cd, arr_pol_cd[i], arr_pol_cd[i]);
	 		}
	 	}
	 }
}
//APPLY 버튼 적용시 유효성 체크
function valid_form(evt_div){
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	var opener=window;
	var opener_sheetobj=opener.document.sheet1;
	var rtn_val=true;
	var trd_cd=comboObjects[0].GetSelectCode();
	var sub_trd_cd=comboObjects[1].GetSelectCode();
	var vsl_lane_cd=comboObjects[2].GetSelectCode();
	var eff_st_dt=ComTrimAll(formObj.s_eff_st_dt);
	var pol_cd=ComTrimAll(formObj.s_pol_cd); //POL CD
	if (trd_cd == "") {
		ComShowCodeMessage("EQR01110", "Trade");//Trade를 입력하세요.';
		rtn_val=false;
	}else if (sub_trd_cd == "") {
			ComShowCodeMessage("EQR01110", "Sub Trade");//Sub Trade를 입력하세요.';
			rtn_val=false;
	}else if (vsl_lane_cd == "") {
		ComShowCodeMessage("EQR01110", "Lane");//Lane를 입력하세요.';
		rtn_val=false;
	}else if (ComTrimAll(formObj.s_vvd_cd) == "") {
		ComShowCodeMessage("EQR01110", "VVD");//VVD를 입력하세요.';
		formObj.s_vvd_cd.focus();
		rtn_val=false;
	}else if (pol_cd == "") {
		ComShowCodeMessage("EQR01110", "POL");//POL를 입력하세요.';
		formObj.s_pol_cd.focus();
		rtn_val=false;
	}else if (formObj.s_eta_dt.value == "") {
		ComShowCodeMessage("EQR01110", "ETA");//POL를 입력하세요.';
		rtn_val=false;
	}
	if(evt_div == "A"){	//Guideline Add일 경우의 유효성 체크
		formObj.f_cmd.value=SEARCH07; // GUIDELINE 중복체크
		sXml=sheetObj.GetSearchData("EES_EQR_1009GS.do", FormQueryString(formObj));
		var chk_gline=ComGetEtcData(sXml, "chk_gline");
		if(chk_gline == "F"){
			ComShowCodeMessage("EQR01113", "Guideline Add");//Guideline Add 중복된 Lane이 있습니다.'
			rtn_val=false;	
		}
	}else if(evt_div == "M"){ //Guideline Amend일 경우의 유효성 체크
		var dup_cnt=0;	
		for(var i=0; i <opener_sheetobj.RowCount(); i++){ //main창 중복체크
			var opn_trd_cd=opener_sheetobj.GetCellValue(i+2,"trd_cd");
			var opn_sub_trd_cd=opener_sheetobj.GetCellValue(i+2,"sub_trd_cd");
			var opn_vsl_lane_cd=opener_sheetobj.GetCellValue(i+2,"vsl_lane_cd");
			var opn_eff_st_dt=opener_sheetobj.GetCellValue(i+2,"eff_st_dt");
			if(trd_cd == opn_trd_cd 
			&& sub_trd_cd ==opn_sub_trd_cd 
			&& vsl_lane_cd == opn_vsl_lane_cd
			&& eff_st_dt == opn_eff_st_dt ){
				dup_cnt++;
			}
		}	
		if(dup_cnt > 0){
			ComShowCodeMessage("EQR01113", "Guideline Amend");//Guideline Amend 중복된 Lane이 있습니다.';
			rtn_val=false;	
		}
	}
	return 	rtn_val
}
/**
	 * Combo Object의 ID 값을 가져오는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {string} id combo id 값
	 * @return 없음
	 * @author 
	 * @version 
	 */
function comboID(id) {
	return document.getElementById(id);
}
