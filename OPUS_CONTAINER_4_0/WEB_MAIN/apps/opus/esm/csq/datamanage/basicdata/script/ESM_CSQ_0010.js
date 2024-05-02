/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0010.js
*@FileTitle  : Target VVD Fix
*@author     : CLT
*@version    : 1.0
*@since      : 2015/01/20
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
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
			case "btn_Retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
			case "btn_Retrieve1":
				//SKD & BSA Inquiry
				doActionIBSheet(sheetObject,formObject,SEARCH01);
				break;
			case "btn_Creation":
				doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC01); 
				break;
			case "btn_Save":
				doActionIBSheet(sheetObject,formObject,IBSAVE);
				break;
			case "btn_DisLane":
				var bseTpCd=(formObject.f_bse_tp_cd[0].checked)? "Y":"Q";
				var param=searchParams + "&div_period=" + document.getElementById("div_period").innerHTML;
				ComOpenPopup("/opuscntr/ESM_CSQ_0011.do?"+param, 700, 550,'setLaneDisableCallBack','0,1,1,1,1,1,1,1',false);
				break;
			case "btn_Downexcel":
				if(sheetObject.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
		        } else{
		        	sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1 });
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
	resizeSheet();
}
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:		//sheet1 init
			with (sheetObj) {
				var HeadTitle1="STS|Trade|Lane Bound|Sub-Trade|Lane|Year|Quarter|Week|Month|VVD|vsl_cd|skd_voy_no|skd_dir_cd|BSA(TEU)|Disable|";
				SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 ,PrevColumnMergeMode:0} );
	
				var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);
	
				var cols = [ {Type:"Status",    Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
//				             {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bse_yr",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bse_qtr_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bse_wk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bse_mon",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"vvd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"fnl_bsa_capa",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"delt_flg",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"blank",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
			       
			      InitColumns(cols);
	
			      SetEditable(1);
			      SetColProperty("delt_flg", {ComboText:"N|Y", ComboCode:"N|Y"} );
			      SetSheetHeight(362);
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
			ComOpenWait(true);
			formObj.f_cmd.value=INIT;
			var sXml=sheetObj.GetSearchData("ESM_CSQ_0010GS.do", FormQueryString(formObj));
//			var State=ComGetEtcData(sXml, ComWebKey.Trans_Result_Key); // State is not used in this case.
			var arrXml=sXml.split("|$$|");
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], f_bse_yr, "code", "name");
			if (arrXml.length > 1)
				ComXml2ComboItem(arrXml[1], f_bse_qtr_cd, "code", "name");
			if (arrXml.length > 2)
				ComSetYearQta(arrXml[2]);
			if (arrXml.length > 3)
				ComXml2ComboItem(arrXml[3], f_dir_cd, "code", "name");
			doActionIBSheet(sheetObj,formObj,SEARCH02);
			ComOpenWait(false);
			break;
		case IBSEARCH_ASYNC01:          // Creation시에
		 	if (ComShowConfirm (ComGetMsg("CSQ00041")) != 1) {
				return false;
			}
			ComOpenWait(true);
			formObj.f_cmd.value=MULTI01;
			//변수 세팅
			formObj.f_fm_wk.value=qtaWeekArr[ComGetObjValue(f_bse_qtr_cd)][0].substring(3,5);
			formObj.f_to_wk.value=qtaWeekArr[ComGetObjValue(f_bse_qtr_cd)][1].substring(3,5);
			
			var rtnXml=sheetObj.GetSearchData("ESM_CSQ_0010GS.do", FormQueryString(formObj));
			sheetObj.LoadSearchData(rtnXml,{Sync:1} );
			var State= ComGetEtcData(rtnXml, ComWebKey.Trans_Result_Key);
			ComOpenWait(false);
			if(State != "S"){
				//ComShowMessage(ComResultMessage(sXml));
				return false;
			}else if(State == "S"){
				ComShowCodeMessage('CSQ00001','Data');
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}
			break;
		case IBSEARCH:          // 화면 조회 시
			//disable컬럼 히든처리
			sheetObj.SetColHidden("delt_flg",0);
//			sheetObj.SetColHidden("blank",1);
			formObj.f_cmd.value=SEARCH;
			searchParams=FormQueryString(formObj);
			ComOpenWait(true);
			var rtnXml=sheetObj.GetSearchData("ESM_CSQ_0010GS.do", searchParams);
			sheetObj.LoadSearchData(rtnXml,{Sync:1} );
			var etcData = getEtcData(rtnXml);
			if (etcData["dataCnt"] == 0) {
				toggleButtons("INIT");
				ComBtnEnable("btn_Creation");
			} else {
				toggleButtons("SEARCH");
			}
			sheetObj.ReDraw=true;
			break;
		case SEARCH02:          // 화면 오픈시
			formObj.f_cmd.value=SEARCH02;
			var rtnXml=sheetObj.GetSearchData("ESM_CSQ_0010GS.do", FormQueryString(formObj));
			var etcData = getEtcData(rtnXml);
			if (etcData["dataCnt"] == 0) {
				toggleButtons("INIT");
			} else {
				toggleButtons("SEARCH");
			}
			break;
		case SEARCH01:          //SKD & BSA Inquiry
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH01;
			//변수 세팅
			formObj.f_fm_wk.value=qtaWeekArr[ComGetObjValue(f_bse_qtr_cd)][0].substring(3,5);
			formObj.f_to_wk.value=qtaWeekArr[ComGetObjValue(f_bse_qtr_cd)][1].substring(3,5);
			var rtnXml=sheetObj.GetSearchData("ESM_CSQ_0010GS.do", FormQueryString(formObj));
			sheetObj.LoadSearchData(rtnXml,{Sync:1} );
			//disable컬럼 히든처리
			sheetObj.SetColHidden("delt_flg",1);
//			sheetObj.SetColHidden("blank",0);
	 	    if (sheetObj.RowCount()>0)
	 	    	ComBtnEnable("btn_Downexcel");
	 	    else
	 	    	ComBtnDisable("btn_Downexcel");
			ComOpenWait(false);
			break;
		case IBSAVE:          // 화면 저장시
			if (sheetObj.IsDataModified()== false) {
				ComShowCodeMessage("CSQ00006");
			    return false;
			} else if (ComShowConfirm (ComGetMsg("CSQ00004")) != 1) {
				return false;
			}
			ComSetSearchParams("f_cmd", MULTI);
			var sParam=sheetObj.GetSaveString(false, true, "ibflag");
			var sXml=sheetObjects[0].GetSaveData("ESM_CSQ_0010GS.do", searchParams + "&" +sParam);
			var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
			if(State != "S"){
				ComShowMessage(ComResultMessage(sXml));
				return false;
			}else if(State == "S"){
				ComShowCodeMessage('CSQ00001','Data');
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			}
			break;
    }
}
 /**
 * onChange event
 * f_trd_cd 바뀌었을때  f_lane_cd 콤보조회
 */
 function f_trd_cd_OnChange(obj, OldIdx, OldTxt, OldCd, NewIdx, NewTxt, NewCd) {
		var formObj=document.form;
		var trd_cd		 = ComGetObjValue(f_trd_cd);
		var f_bse_tp_cd  = ComGetObjValue(formObj.f_bse_tp_cd[0]);
		var f_bse_yr 	 = ComGetObjValue(formObj.f_bse_yr);
		var f_bse_qtr_cd = ComGetObjValue(formObj.f_bse_qtr_cd);
		var sector_include = "Y"; //sub trade 조회시 sector도 포함
		var param="f_cmd=" + SEARCH01
	    		+ "&code_name=subTrade"
	    		+ "&code_param="+trd_cd+"|"
     							+f_bse_tp_cd+"|"
     							+f_bse_yr+"|"
     							+f_bse_qtr_cd+"|"
    							+sector_include
	            + "&all_flag=All";	// Trade
		var xmlStr=sheetObjects[0].GetSearchData("CommonGS.do", param);
	 	ComXml2ComboItem(xmlStr, f_sub_trd_cd, "code", "name");
	 	f_sub_trd_cd.SetSelectIndex(0);
	}
 /**
 * onChange event
 * f_sub_trd_cd 바뀌었을때  f_lane_cd 콤보조회
 */	 
 function f_sub_trd_cd_OnChange(obj, value, text) {
		var formObj=document.form;
		var trd_cd		 = ComGetObjValue(f_trd_cd);
		var sub_trd_cd	 = ComGetObjValue(f_sub_trd_cd);
		var f_bse_tp_cd  = ComGetObjValue(formObj.f_bse_tp_cd[0]);
		var f_bse_yr 	 = ComGetObjValue(formObj.f_bse_yr);
		var f_bse_qtr_cd = ComGetObjValue(formObj.f_bse_qtr_cd);
		var sector_include = "Y"; //rlane 조회시 sector도 포함
		if( trd_cd != "All" || sub_trd_cd != "All"){
		 	var param="f_cmd=" + SEARCH01
		     		+ "&code_name=rLane"
		     		+ "&code_param="+trd_cd+"|"
		     						+f_bse_tp_cd+"|"
		     						+f_bse_yr+"|"
		     						+f_bse_qtr_cd+"|"
		     						+sub_trd_cd+"|"
		     						+sector_include
		            + "&all_flag=All";
			var xmlStr=sheetObjects[0].GetSearchData("CommonGS.do", param);
			ComXml2ComboItem(xmlStr, f_rlane_cd, "code", "name");
			f_rlane_cd.SetSelectIndex(0);
		}else{
			f_rlane_cd.RemoveAll();
			f_rlane_cd.InsertItem(0, "All", "All");
			f_rlane_cd.SetSelectIndex(0);
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
		case "delt_flg":
			setCancelLine(sheetObj,row,value);
			break;
	}
}
 /**
 * setLaneDisableCallBack
 * 팝업화면에서 선택된 노선을 all disable
 * @param aryPopupData
 */
function setLaneDisableCallBack(aryPopupData) {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	ComOpenWait(true);
	
	for(var i=0;i<aryPopupData.length;i++){
		for(var j=sheetObj.HeaderRows();j<sheetObj.RowCount()+sheetObj.HeaderRows();j++){
			if((aryPopupData[i][1] == sheetObj.GetCellValue(j,"trd_cd"))
					&&(aryPopupData[i][2] == sheetObj.GetCellValue(j,"dir_cd"))
					&&(aryPopupData[i][3] == sheetObj.GetCellValue(j,"sub_trd_cd"))
					&&(aryPopupData[i][4] == sheetObj.GetCellValue(j,"rlane_cd"))){
				sheetObj.SetCellValue(j,"delt_flg","Y");
			}
		}
	}
	ComOpenWait(false);
	ComShowCodeMessage('CSQ00053');
}
 /**
 * delt_flg값에 따라 취소선 설정
 * @param sheetObj
 * @param row
 * @param value
 */
 function setCancelLine(sheetObj,row,value) {
	if(value == "Y"){
		//취소선
		sheetObj.SetCellFont("FontStrike", row, 6,	row, 14,1);
	}else {
		sheetObj.SetCellFont("FontStrike", row, 6,	row, 14,0);
	}
}
 /**
 *조회 함수를 이용하여 조회가 완료되고 발생하는 Event
 * @param sheetObj
 * @param ErrMsg
 */
 function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	ComOpenWait(false);
	var row=0;
	while((row=sheetObj.FindText("delt_flg", "Y", row + 1)) > 0){
		setCancelLine(sheetObj,row,"Y");
	}
}
	/**
	 * 화면의 모든 버튼들의 Enable/Disable을 처리
	 */
function toggleButtons(step) {
	var formObj=document.form;
    switch (step) {
    case "INIT":
        ComBtnDisable("btn_Save");
        ComBtnDisable("btn_DisLane");
        ComBtnDisable("btn_Downexcel");
        if(formObj.cre_flg.value == "Y")
        	ComBtnEnable("btn_Creation");
        else
        	ComBtnDisable("btn_Creation");
 	    ComBtnEnable("btn_Retrieve1");
        break;
    case "SEARCH":
 	   ComBtnEnable("btn_Save");
 	   ComBtnDisable("btn_Creation");
 	   ComBtnEnable("btn_Downexcel");
 	   ComBtnEnable("btn_DisLane");
 	   ComBtnDisable("btn_Retrieve1");
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
 	if (bse_tp_cd == "Y") {
 		f_bse_qtr_cd.SetEnable(0);
 		sheetObjects[0].SetColHidden("bse_qtr_cd",1);
 	} else {
 		f_bse_qtr_cd.SetEnable(1);
 		sheetObjects[0].SetColHidden("bse_qtr_cd",0);
 	}
 	period_change();
 	setTradeCombo();
 	if(comboObjects[0].GetSelectCode()!=""&&comboObjects[1].GetSelectCode()!="")
 		doActionIBSheet(sheetObjects[0],formObj,SEARCH02);
 }
  /**
   * f_bse_yr가 바뀌었을때 period 의 year 변경
   */
  function f_bse_yr_OnChange(obj, value, text) {
	var formObj=document.form;
  	period_change();
  	setTradeCombo();
  	if(comboObjects[1].GetSelectCode()!="")
  		doActionIBSheet(sheetObjects[0],formObj,SEARCH02);
  }
  /**
   * f_bse_qtr_cd 바뀌었을때 period 의 week 기간변경
   */
  function f_bse_qtr_cd_OnChange(obj, value, text) {
	var formObj=document.form;
  	period_change();
  	setTradeCombo();
  	doActionIBSheet(sheetObjects[0],formObj,SEARCH02);
  }
  
  function resizeSheet(){
      ComResizeSheet(sheetObjects[0]);
  }
/* 개발자 작업  끝 */
