/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0217.js
*@FileTitle  : QTA Inquiry_Yearly Planning_IAS Sector
*@author     : CLT
*@version    : 1.0
*@since      : 2015/02/09
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends
 * @class ESM_CSQ_0217 : ESM_CSQ_0217 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
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
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_Retrieve":
				doActionIBSheet(sheetObject, formObj, IBSEARCH);
				break;
			case "btn_DownExcel":
				if(sheetObject.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
				}else{
					doActionIBSheet(sheetObject, formObj, IBDOWNEXCEL);
				}
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
	initcontrol();
	loadingMode=false;
	resizeSheet();
}
 function initcontrol(){
		var formObj=document.form;
		axon_event.addListenerForm  ("KeyUp",    "obj_KeyUp", 	formObj);
		axon_event.addListenerForm  ('click',    'obj_click',   formObj);
		axon_event.addListenerForm  ('change', 	 'obj_change',  formObj);
	    axon_event.addListenerFormat('keypress', 'obj_keypress',formObj); //- 키보드 입력할때
}
 /**
 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
 **/
 function obj_keypress(){
	switch(ComGetEvent("dataformat")){
    	case "num":
	        //숫자만입력하기
	        ComKeyOnlyNumber(ComGetEvent());
	        break;
        default:
            //숫자만입력하기(정수,날짜,시간)
            ComKeyOnlyNumber(ComGetEvent());
    }
}
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:		//sheet1 init
		    with(sheetObj){
	        	var HeadTitle1="SEQ|Year|Office View|Trade|Sub Trade|R.Lane|Lane Bound|Month|Supply|VVD Count|RHQ|Office|POL|POD|Main/Sector|Load|G.RPB|G.REV|CM Cost(PA)|CM Cost(RA)|CMCB(PA)|CMCB(RA)|CM(PA)|CM(RA)|CMPB(PA)|CMPB(RA)";
	        	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

	        	var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
	        	var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        	InitHeaders(headers, info);

	        	var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bse_yr",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ofc_vw_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bse_mon",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"AutoSum",   Hidden:0, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"tot_bsa_capa",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vvd_cnt",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rhq_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rgn_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"csq_mn_sctr_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"lod_qty",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"rev_rpb",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"grs_rev",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"pa_cm_cost",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"ra_cm_cost",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"pa_cmcb",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"ra_cmcb",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"pa_cm",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"ra_cm",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"pa_cmpb",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"ra_cmpb",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	        	InitColumns(cols);
	        	SetSheetHeight(360);
	        	SetEditable(1);
	        	SetRangeBackColor(0, 15,0, 17,"#555555");
	        	SetRangeBackColor(0, 22,0, 25,"#555555");
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
 * onChange event
 * f_rhq_cd 바뀌었을때  f_rgn_ofc_cd 콤보조회
 */
function f_rhq_cd_OnChange(obj, OldIdx, OldTxt, OldCd, NewIdx, NewTxt, NewCd) {
	var formObj=document.form;
	if (NewCd != "All") {
	 	var param="f_cmd=" + SEARCH01
	     + "&code_name=officeForPlan"
	     + "&code_param=" + NewCd
	     + "&all_flag=All";	// Trade
	 	var xmlStr=sheetObjects[0].GetSearchData("CommonGS.do", param);
	 	ComXml2ComboItem(xmlStr, f_rgn_ofc_cd, "code", "name");
	} else {
		f_rgn_ofc_cd.RemoveAll();
		f_rgn_ofc_cd.InsertItem(0, "All", "All");
	}
 	comboObjects[4].SetSelectIndex(0);
}
/**
 *  f_bse_yr, f_bse_qtr_cd, f_trd_cd  변경시 f_sub_trd_cd를 변경한다.
 */
function setSubTradeCombo(){
 	var formObj=document.form;
	var f_bse_tp_cd  = "Y";
	var f_bse_yr 	 = ComGetObjValue(formObj.f_bse_yr);
	var f_bse_qtr_cd = "00";
	var trd_cd 		 = ComGetObjValue(formObj.f_trd_cd);
	
 	if ( trd_cd != ""  && trd_cd != "All" ) {
	 	var param="f_cmd=" + SEARCH01
	     + "&code_name=subTradeSector"
	     + "&code_param="+trd_cd+"|"
	     				+f_bse_tp_cd+"|"
	     				+f_bse_yr+"|"
	     				+f_bse_qtr_cd
	     + "&all_flag=All";
        var xmlStr=sheetObjects[0].GetSearchData("CommonGS.do", param);
	 	ComXml2ComboItem(xmlStr, f_sub_trd_cd, "code", "name");
	 	f_sub_trd_cd.SetSelectIndex(0);
 	} else {
 		f_sub_trd_cd.RemoveAll();
 		f_sub_trd_cd.InsertItem(0, "All", "All");
 		f_sub_trd_cd.SetSelectIndex(0);
 	}
}
/**
* onChange event
* f_sub_trd_cd 바뀌었을때  f_lane_cd 콤보조회
*/	
function f_sub_trd_cd_OnChange(obj, value, text) {
	setLaneCombo();
 }

/**
 *  f_sub_trd_cd 변경시 f_rlane_cd를 변경한다.
 */
function setLaneCombo(){
 	var formObj=document.form;
 	var sub_trd_cd   = ComGetObjValue(f_sub_trd_cd);
	var f_bse_tp_cd  = "Y";
	var f_bse_yr 	 = ComGetObjValue(formObj.f_bse_yr);
	var f_bse_qtr_cd = "00";
	var trd_cd 		 = ComGetObjValue(formObj.f_trd_cd);
	
 	if (sub_trd_cd != ""  && sub_trd_cd != "All") {
	 	var param="f_cmd=" + SEARCH01
	     + "&code_name=rLaneSector"
	     + "&code_param="+trd_cd+"|"
	     				+f_bse_tp_cd+"|"
	     				+f_bse_yr+"|"
	     				+f_bse_qtr_cd+"|"
	     			    +f_sub_trd_cd.GetSelectCode()
	     + "&all_flag=All";
	 	var xmlStr=sheetObjects[0].GetSearchData("CommonGS.do", param);
	 	ComXml2ComboItem(xmlStr, f_rlane_cd, "code", "name");
	 	f_rlane_cd.SetSelectIndex(0);
 	} else {
		f_rlane_cd.RemoveAll();
		f_rlane_cd.InsertItem(0, "All", "All");
		f_rlane_cd.SetSelectIndex(0);
 	}
}
/**
 * f_rlane_cd 바뀌었을때 POL, POD 변경
 */
function f_rlane_cd_OnChange(obj, OldIdx, OldTxt, OldCd, NewIdx, NewTxt, NewCd) {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	if(NewCd != "" && NewCd != "All") {
		var code_name=new Array("polCdSector", "podCdSector");
		var code_param=new Array(NewCd, NewCd);
		var all_flag=new Array("All", "All");
		var param="f_cmd="		+ SEARCH02
		          + "&code_name="	+ code_name
		          + "&code_param="	+ code_param
		          + "&all_flag="	+ all_flag
		          + "&" + FormQueryString(formObj);	
		var sXml=sheetObj.GetSearchData("CommonGS.do", param);
		var arrXml=sXml.split("|$$|");
		if (arrXml.length > 0) {
			ComXml2ComboItem(arrXml[0], f_pol_cd, "code", "name");
			f_pol_cd.SetSelectIndex(0);
		}
		if (arrXml.length > 1) {
			ComXml2ComboItem(arrXml[1], f_pod_cd, "code", "name");
			f_pod_cd.SetSelectIndex(0);
		}
	} else {
		f_pol_cd.RemoveAll();
		f_pol_cd.InsertItem(0, "All", "All");
		f_pol_cd.SetSelectIndex(0);
		f_pod_cd.RemoveAll();
		f_pod_cd.InsertItem(0, "All", "All");
		f_pod_cd.SetSelectIndex(0);
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
			var sXml=sheetObj.GetSearchData("ESM_CSQ_0217GS.do", FormQueryString(formObj));
			//var State=ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
			var arrXml=sXml.split("|$$|");
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], f_bse_yr, "code", "name");
			if (arrXml.length > 1)
				ComSetYear(arrXml[1]);
			if (arrXml.length > 2)
				ComXml2ComboItem(arrXml[2], f_ofc_vw_cd, "code", "name");
			if (arrXml.length > 3)
				ComXml2ComboItem(arrXml[3], f_ofc_lvl, "code", "name");
			if (arrXml.length > 4)
				ComXml2ComboItem(arrXml[4], f_rhq_cd, "code", "name");
			if (arrXml.length > 5)
				ComXml2ComboItem(arrXml[5], f_dir_cd, "code", "name");
			ComOpenWait(false);
			break;
		case IBSEARCH:          //화면 조회시
			if (!validateForm(sheetObj, formObj, sAction)) return;
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
			setTimeout(function(){
				searchParams=FormQueryString(formObj);
				var rtnXml=sheetObj.GetSearchData("ESM_CSQ_0217GS.do", searchParams);
				sheetObj.LoadSearchData(rtnXml,{Sync:1} );
				ComOpenWait(false);
			},100);
			break;
		case IBDOWNEXCEL:		// 엑셀 다운로드
			ComOpenWait(true);
			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
			ComOpenWait(false);
			break;
    }
}
/**
 * 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
 *
 * @param sheetObj
 * @param ErrMsg
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	var formObj=document.form;
	var ofc_lvl=ComGetObjValue(f_ofc_lvl);
	var chk_pair=formObj.f_chk_pair.checked;
	if ( ofc_lvl == "01" ) {
		sheetObj.SetColHidden("rhq_cd",1);
		sheetObj.SetColHidden("rgn_ofc_cd",1);
	} else if ( ofc_lvl == "02" ) {
		sheetObj.SetColHidden("rhq_cd",0);
		sheetObj.SetColHidden("rgn_ofc_cd",1);
		sheetObj.SetSumText(0, "fnl_bsa_capa","");
	} else if ( ofc_lvl == "03" ) {
		sheetObj.SetColHidden("rhq_cd",0);
		sheetObj.SetColHidden("rgn_ofc_cd",0);
		sheetObj.SetSumText(0, "fnl_bsa_capa","");
	}
	if ( chk_pair ) {
		sheetObjects[0].SetColHidden("pol_cd",0);
		sheetObjects[0].SetColHidden("pod_cd",0);
		sheetObjects[0].SetColHidden("csq_mn_sctr_flg",0);
	} else {
		sheetObjects[0].SetColHidden("pol_cd",1);
		sheetObjects[0].SetColHidden("pod_cd",1);
		sheetObjects[0].SetColHidden("csq_mn_sctr_flg",1);
	}
	sheetObj.SetSumText(0, "rev_rpb",ComAddComma((sheetObj.GetSumValue(0, "grs_rev")   / sheetObj.GetSumValue(0, "lod_qty")).toFixed(0)));
	sheetObj.SetSumText(0, "pa_cmcb",ComAddComma((sheetObj.GetSumValue(0, "pa_cm_cost") / sheetObj.GetSumValue(0, "lod_qty")).toFixed(0)));
	sheetObj.SetSumText(0, "ra_cmcb",ComAddComma((sheetObj.GetSumValue(0, "ra_cm_cost") / sheetObj.GetSumValue(0, "lod_qty")).toFixed(0)));
	sheetObj.SetSumText(0, "pa_cmpb",ComAddComma((sheetObj.GetSumValue(0, "pa_cm")   / sheetObj.GetSumValue(0, "lod_qty")).toFixed(0)));
	sheetObj.SetSumText(0, "ra_cmpb",ComAddComma((sheetObj.GetSumValue(0, "ra_cm")   / sheetObj.GetSumValue(0, "lod_qty")).toFixed(0)));
	sheetObj.SetSumText(0, "seq","");
	sheetObj.SetSumText(0, "trd_cd","TOTAL");
}
 /**
  * 화면 오픈시 Year, Quarter 세팅
  */
 function ComSetYear(xml) {
 	var formObj=document.form;
 	var arrData=ComCsqGetXmlValue(xml);
 	var arrCode=arrData.split("-");
 	f_bse_yr.SetSelectCode(arrCode[0]);
 }
  /**
   * f_ofc_lvl 바뀌었을때 sheet change
   */
   function f_ofc_lvl_OnChange(obj, OldIdx, OldTxt, OldCd, NewIdx, NewTxt, NewCd) {
   	  var formObj=document.form;
   	  var div_rhq=document.getElementById("div_rhq");
   	  var div_ofc=document.getElementById("div_ofc");
   	  if(NewCd == "01"){//Head Office일때
		  div_rhq.style.display="none";
		  div_ofc.style.display="none";
		  f_rhq_cd.SetVisible(0);
		  f_rgn_ofc_cd.SetVisible(0);
   	  }else if(NewCd == "02"){//RHQ일때
   		  div_rhq.style.display="inline";
   		  div_ofc.style.display="none";
   		  f_rhq_cd.SetVisible(1);
   		  f_rgn_ofc_cd.SetVisible(0);
	  }else{//Office일때
		  div_rhq.style.display="inline";
		  div_ofc.style.display="inline";
		  f_rhq_cd.SetVisible(1);
		  f_rgn_ofc_cd.SetVisible(1);
   	  }
   }
function obj_click() {
	var formObj=document.form;
	var srcName=ComGetEvent("name");
	with(formObj) {
		switch(srcName) {
			case "f_chk_pair":
		    	if(formObj.f_chk_pair.checked){
		    		div_main.style.display="inline";
		    		div_main_sel.style.display="inline";
		    	}else{
		    		div_main.style.display="none";
		    		div_main_sel.style.display="none";
		    	}
		    break;
		}
	}
}
/**
* 화면 폼입력값에 대한 유효성검증 프로세스 처리
*/
function validateForm(sheetObj, formObj, sAction){
	switch(sAction) {
		case IBSEARCH:  // 화면 조회시에
			if((formObj.f_fm_mon.value == "" && formObj.f_to_mon.value != "") || (formObj.f_fm_mon.value != "" && formObj.f_to_mon.value == "")){
				ComShowCodeMessage('CSQ00024','Month');
				return false;
			}
			//pair check 시 필수 입력 체크
			if(formObj.f_chk_pair.checked){
				if(f_sub_trd_cd.GetSelectCode()== "" || f_sub_trd_cd.GetSelectCode()== "All"){
					ComShowCodeMessage('CSQ00013','Sub Trade');
					return false;
				}
				if(f_rlane_cd.GetSelectCode()== "" || f_rlane_cd.GetSelectCode()== "All"){
					ComShowCodeMessage('CSQ00013','R/Lane');
					return false;
				}
					
				if(f_dir_cd.GetSelectCode()== "" || f_dir_cd.GetSelectCode()== "All"){
						ComShowCodeMessage('CSQ00013','Lane Bound');
						return false;
				}
			}
			break;
	}
	return true;
}
/**
* f_fm_mon,f_to_mon 가 두자리수로 표시되도록 onchange
*/
function obj_change(){
	var formObj=document.form;
	var srcName=ComGetEvent("name");
	var srcVal=ComGetEvent("value");
	if(srcName == "f_fm_mon" || srcName == "f_to_mon"){
		if(srcVal != ""){
			if(srcVal.length < 2){
				formObj.elements[srcName].value="0" + srcVal;
			}
			//Month 형식체크
			if(!ComIsMonth(srcVal)){
				ComShowCodeMessage('CSQ00008', 'Month', 'MM');
				formObj.elements[srcName].value="";
			}
			// To month 가 From month 보다 큰지 체크
			if(formObj.f_fm_mon.value!="" && formObj.f_to_mon.value!=""){
				if ( formObj.f_fm_mon.value > formObj.f_to_mon.value ) {
					ComShowCodeMessage("COM12133", "To month", "from month", "later");
					formObj.f_to_mon.value="";
					formObj.f_to_mon.focus();
				}
			}
		}
	}
}

function resizeSheet(){
    for (i=0; i<sheetObjects.length; i++){
        ComResizeSheet(sheetObjects[i]);
    }
}

function f_bse_yr_OnChange(obj, value, text) {
	setSubTradeCombo();
}

/* 개발자 작업  끝 */
