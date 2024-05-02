	/*=========================================================
	*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
	*@FileName   : ESM_CSQ_0203.js
	*@FileTitle  : POL-POD Management for IAS Sector_Add-Creation
	*@author     : CLT
	*@version    : 1.0
	*@since      : 2015/02/05
	=========================================================*/	
	/****************************************************************************************
	 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
	 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
	 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
	 ***************************************************************************************/
	/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
	/**
	 * @extends
	 * @class ESM_CSQ_0203 : ESM_CSQ_0203 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	/* 개발자 작업 */
	// 공통전역변수
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var qtaWeekArr=new Array();
	qtaWeekArr["1Q"]=new Array(".wk00", ".wk13");
	qtaWeekArr["2Q"]=new Array(".wk14", ".wk26");
	qtaWeekArr["3Q"]=new Array(".wk27", ".wk39");
	qtaWeekArr["4Q"]=new Array(".wk40", ".wk53");
	var rowCnt=0;
	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick=processButtonClick;
	function processButtonClick() {
		var sheetObject=sheetObjects[0];
		var formObj=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch (srcName) {
			case "btn_Retrieve":
				doActionIBSheet(sheetObject, formObj, IBSEARCH);
				break;
			case "btn_Creation":
				doActionIBSheet(sheetObject, formObj, MULTI01);
				break;
			case "btn_Close":
				ComClosePopup(); 
				break;
			}
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(ComGetMsg("COM12111", "", ""));
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	/**
	 * IBSheet Object 를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은
	 * 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * IBSheet Object 를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은
	 * 소스 상단에 정의
	 */
	function setComboObject(combo_obj) {
		comboObjects[comboCnt++]=combo_obj;
	}
	function loadPage() {
		var formObj=document.form;
		var temp = document.getElementById("div_period");
		loadingMode=true;
		for (i=0; i < sheetObjects.length; i++) {
			// khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		for (k=0; k < comboObjects.length; k++) {
			initCombo(comboObjects[k], comboObjects[k].id);
		}
		ComSetObjValue(formObj.f_bse_tp_cd[0], formObj.p_bse_tp_cd.value);
		setSubTradeCombo();
		if (formObj.p_bse_tp_cd.value == "Q") {
			var year=formObj.f_bse_yr.value;
			var qta=formObj.f_bse_qtr_cd.value;
			temp.innerHTML = "(" + year + qtaWeekArr[qta][0] + " ~ " + year + qtaWeekArr[qta][1] + ")";
		} else {
			var year=formObj.f_bse_yr.value;
			temp.innerHTML = "(" + year + ")";
			formObj.f_bse_qtr_cd.value="All";
		}
		
		loadingMode=false;
		resizeSheet();
	}
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		switch (sheetNo) {
		case 1: // sheet1 init
		    with(sheetObj){
	        if (location.hostname != "")
	        var HeadTitle1="STS|Trade|Sub\nTrade|R.Lane|Bound|P/F SKD\nGroup|new_rlane_flg|P/F SKD Ver.|Route|SEL";
	        SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:1 } );
	        var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);
	        var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pf_grp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"new_rlane_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"pf_svc_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:420,  Align:"Left",    ColMerge:0,   SaveName:"pf_rout_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sel_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	      InitColumns(cols);
	      SetEditable(1);
	      SetSheetHeight(180);
	            }
			break;
		}
	}
	/**
	 * 멀티콤보 항목을 설정한다.
	 */
	function initCombo(comboObj, comboId) {
		switch (comboObj.options.id) {
		case "f_sub_trd_cd":
			with (comboObj) {
				SetDropHeight(300);
				SetSelectIndex(0);
				ValidChar(2);
			}
			break;
		case "f_rlane_cd":
			with (comboObj) {
				SetDropHeight(300);
				SetSelectIndex(0);
				ValidChar(2,1);
			}
			break;
		}
	}
	/**
	 * Sheet 관련 프로세스 처리
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
		case IBSEARCH: // 화면 조회 시
			if (!validateForm(sheetObj, formObj, sAction)) return;
			formObj.f_cmd.value=SEARCH;
			searchParams=FormQueryString(formObj);
			ComOpenWait(true);
			var rtnXml=sheetObj.GetSearchData("ESM_CSQ_0203GS.do", searchParams);
			sheetObj.LoadSearchData(rtnXml,{Sync:1} );
			ComOpenWait(false);
			break;
		case MULTI01: // Creation시에
			if (!validateForm(sheetObj, formObj, sAction))
				return;
			if (ComShowConfirm(ComGetMsg("CSQ00009")) != 1) {
				return false;
			}
			ComOpenWait(true);
			ComSetSearchParams("f_cmd", MULTI01);
//			sheetObj.DoSave("ESM_CSQ_0203GS.do", searchParams, -1, false);
			var saveStr=sheetObj.GetSaveString(false, true, "ibflag");
			var sXml = sheetObj.GetSaveData("ESM_CSQ_0203GS.do", searchParams + "&" + saveStr);
			var State= ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
			ComOpenWait(false);
			if (State != "S") {
				ComShowMessage(ComResultMessage(sXml));
				return false;
			} else if (State == "S") {
				ComShowCodeMessage('CSQ00001', 'Data');
				var rtnValue = "S";
	            ComPopUpReturnValue(rtnValue);
			}
			break;
		}
	}
	/**
	 *  f_bse_yr, f_bse_qtr_cd, f_trd_cd  변경시 f_sub_trd_cd를 변경한다.
	 */
	function setSubTradeCombo(){
	 	var formObj=document.form;
		var f_bse_tp_cd  = formObj.p_bse_tp_cd.value;  
		var f_bse_yr 	 = ComGetObjValue(formObj.f_bse_yr);
		var f_bse_qtr_cd = ComGetObjValue(formObj.f_bse_qtr_cd);
		var trd_cd 		 = ComGetObjValue(formObj.f_trd_cd);
		
	 	if ( trd_cd != ""  && trd_cd != "All" ) {
		 	var param="f_cmd=" + SEARCH01
		     + "&code_name=subTradeSector"
		     + "&code_param="+trd_cd+"|"
		     				+f_bse_tp_cd+"|"
		     				+f_bse_yr+"|"
		     				+f_bse_qtr_cd
		     + "&all_flag=";
	        var xmlStr=sheetObjects[0].GetSearchData("CommonGS.do", param);
		 	ComXml2ComboItem(xmlStr, f_sub_trd_cd, "code", "name");
		 	f_sub_trd_cd.SetSelectIndex(0);
	 	} else {
	 		f_sub_trd_cd.RemoveAll();
	 	}
	}
	/**
	 * onChange event f_sub_trd_cd 바뀌었을때 f_lane_cd 콤보조회
	 */
	function f_sub_trd_cd_OnChange(obj, value, text) {
		var formObj=document.form;
		var f_bse_tp_cd  = formObj.p_bse_tp_cd.value;  
		var f_bse_yr 	 = ComGetObjValue(formObj.f_bse_yr);
		var f_bse_qtr_cd = ComGetObjValue(formObj.f_bse_qtr_cd);
		var trd_cd 		 = ComGetObjValue(formObj.f_trd_cd);
		
	 	var param="f_cmd=" + SEARCH01
	     + "&code_name=rLaneSector"
	     + "&code_param="+trd_cd+"|"
	     				+f_bse_tp_cd+"|"
	     				+f_bse_yr+"|"
	     				+f_bse_qtr_cd+"|"
	     			    +f_sub_trd_cd.GetSelectCode()
	     + "&all_flag=";
	 	var xmlStr=sheetObjects[0].GetSearchData("CommonGS.do", param);
		ComXml2ComboItem(xmlStr, f_rlane_cd, "code", "name");
		f_rlane_cd.SetSelectIndex(0);
	}
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
			case MULTI01: // Add-Creation
				if(f_rlane_cd.GetSelectCode()== ""){
					ComShowCodeMessage('CSQ00013','R/Lane');
					return false;
				}
				if (sheetObj.CheckedRows("sel_flg") < 1) {
					ComShowCodeMessage("CSQ00046");
					return false;
				}
				break;
			case IBSEARCH: 
				if(f_rlane_cd.GetSelectCode()== ""){
					ComShowCodeMessage('CSQ00013','R/Lane');
					return false;
				}
				break;
		}
		return true;
	}
	
	function resizeSheet(){
	    for (i=0; i<sheetObjects.length; i++){
	        ComResizeSheet(sheetObjects[i]);
	    }
	}
	/* 개발자 작업 끝 */
