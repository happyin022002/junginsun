/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0207.js
*@FileTitle  : Basic Data Creation for IAS Sector
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
 * @class ESM_CSQ_0207 : ESM_CSQ_0207 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
	/* 개발자 작업	*/
	//공통전역변수
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var rowCnt=0;
	var max=0;
	var params="";
	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick=processButtonClick;
	function processButtonClick(){
		var sheetObject=sheetObjects[0];
		var formObj=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
				case "f_bse_tp_cd":
					f_bse_tp_cd_OnChange();
					break;	
				case "btn_Retrieve":
					doActionIBSheet(sheetObject, formObj, IBSEARCH);
					break;
				case "btn_Creation":
					doActionIBSheet(sheetObject, formObj, IBCREATE);
					break;
				case "btn_Downexcel":
					if (sheetObject.RowCount() < 1) {
						 ComShowCodeMessage("COM132501");
					} else{
						doActionIBSheet(sheetObject,formObj,IBDOWNEXCEL);
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
		for (i=0; i<sheetObjects.length; i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);
		for(k=0; k<comboObjects.length; k++){
			initCombo(comboObjects[k],comboObjects[k].id);
		}
		toggleButtons("INIT");
		loadingMode=false;
		resizeSheet();
	}
	
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetNo) {
			case 1:		//sheet1 init
			    with(sheetObj){
		        var HeadTitle1="STS|SEQ|Year|Quarter|Office View|Trade|Sub Trade|R.Lane|Lane Bound|RHQ|Office|POL|POD|Main/Sector|Volume|G.REV|RA CM|PA CM|RA CM Cost|PA CM Cost|period";
		        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		        var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
		        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		        InitHeaders(headers, info);
		        var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bse_yr",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bse_qtr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ofc_vw_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"rhq_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"rgn_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"csq_mn_sctr_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"AutoSum",   Hidden:0, Width:95,   Align:"Right",   ColMerge:1,   SaveName:"lod_qty",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"AutoSum",   Hidden:0, Width:95,   Align:"Right",   ColMerge:1,   SaveName:"grs_ttl_rev",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"AutoSum",   Hidden:0, Width:95,   Align:"Right",   ColMerge:1,   SaveName:"ra_cm",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"AutoSum",   Hidden:0, Width:95,   Align:"Right",   ColMerge:1,   SaveName:"pa_cm",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"AutoSum",   Hidden:0, Width:95,   Align:"Right",   ColMerge:1,   SaveName:"ra_cm_uc_amt",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"AutoSum",   Hidden:0, Width:95,   Align:"Right",   ColMerge:1,   SaveName:"pa_cm_uc_amt",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:1,   SaveName:"period",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		        InitColumns(cols);
		        SetEditable(1);
		        SetSheetHeight(400);
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
	* f_bse_yr가 바뀌었을때 period 의 year 변경
	*/
	function f_bse_yr_OnChange(obj, value, text) {
		period_change();
		setSubTradeCombo();
	}
	/**
	* f_bse_qtr_cd 바뀌었을때 period 의 week 기간변경
	*/
	function f_bse_qtr_cd_OnChange(obj, value, text) {
		period_change();
		setSubTradeCombo();
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
				var sXml=sheetObj.GetSearchData("ESM_CSQ_0207GS.do", FormQueryString(formObj));
				var arrXml=sXml.split("|$$|");
				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], f_bse_yr, "code", "name");
				if (arrXml.length > 1)
					ComXml2ComboItem(arrXml[1], f_bse_qtr_cd, "code", "name");
				if (arrXml.length > 2)
					ComSetYearQta(arrXml[2]);
				if (arrXml.length > 3)
					ComXml2ComboItem(arrXml[3], f_dir_cd, "code", "name");
				if (arrXml.length > 4)
					ComXml2ComboItem(arrXml[4], f_ofc_vw_cd, "code", "name");
				if (arrXml.length > 5)
					ComXml2ComboItem(arrXml[5], f_rhq_cd, "code", "name");
				ComOpenWait(false);
				break;
			case IBSEARCH:          // 화면 조회 시
				ComOpenWait(true);
				formObj.f_cmd.value=SEARCH;
				ComBtnDisable("btn_Create");
				searchParams=FormQueryString(formObj);
				var rtnXml=sheetObj.GetSearchData("ESM_CSQ_0207GS.do", searchParams);
				sheetObj.LoadSearchData(rtnXml,{Sync:1} );
				if (ComGetObjValue(document.form.f_bse_tp_cd) == "Y") {
					sheetObj.SetColHidden("bse_qtr_cd",1);
				} else {
					sheetObj.SetColHidden("bse_qtr_cd",0);
				}
				var etcData=getEtcData(rtnXml);
				if (etcData["dataCnt"] == 0) {
					toggleButtons("CREATE");
				} else {
					toggleButtons("SEARCH");
				}
				var span_period=document.getElementById("span_period");
				if (sheetObj.RowCount()> 0) {
					span_period.innerHTML=sheetObj.GetCellValue(sheetObj.HeaderRows(), "period");
				} else {
					span_period.innerHTML="&nbsp;";
				}
				sheetObj.SetSumText(0,0,"");
				sheetObj.SetSumText(0,3,"TOTAL");
				sheetObj.RemoveEtcData();
				ComOpenWait(false);
				break;
			case IBDOWNEXCEL:		// 엑셀 다운로드
				ComOpenWait(true);
				sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
				ComOpenWait(false);
				break;
			case IBCREATE:          // 생성 화면 Pop-up
				ComOpenWindow("ESM_CSQ_0208.do?" + searchParams,  null,  "dialogHeight:260px;dialogWidth:600px;center:yes;resizable:no;scroll:yes;status:no;unadorned:yes;" , true);
				break;	
	  }
	}
	/**
	 *  f_bse_yr, f_bse_qtr_cd, f_trd_cd  변경시 f_sub_trd_cd를 변경한다.
	 */
	function setSubTradeCombo(){
	 	var formObj=document.form;
		var f_bse_tp_cd  = ComGetObjValue(formObj.f_bse_tp_cd[0]);
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
	 	var sub_trd_cd	 = ComGetObjValue(f_sub_trd_cd);
		var f_bse_tp_cd  = ComGetObjValue(formObj.f_bse_tp_cd[0]);
		var f_bse_yr 	 = ComGetObjValue(formObj.f_bse_yr);
		var f_bse_qtr_cd = ComGetObjValue(formObj.f_bse_qtr_cd);
		var trd_cd 		 = ComGetObjValue(formObj.f_trd_cd);
		
	 	if ( sub_trd_cd != ""  && sub_trd_cd != "All") {
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
	function f_rlane_cd_OnChange(obj, value, text) {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		var f_rlane_cd=ComGetObjValue(formObj.f_rlane_cd);

		if(f_rlane_cd != "" && f_rlane_cd != "All") {
			var code_name=new Array("polCdSector", "podCdSector");
			var code_param=new Array(f_rlane_cd, f_rlane_cd);
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
		setSubTradeCombo();
	}
	/**
	 *  선택된 RHQ 에 해당하는 Office 정보 가져와서 ComboBox 셋팅
	 */
	function f_rhq_cd_OnChange(obj, value, text) {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		var rhqCd=ComGetObjValue(formObj.f_rhq_cd);

		if (rhqCd != "All") {
			var sXml=sheetObj.GetSearchData("CommonGS.do", "f_cmd="+ SEARCH01 + "&code_name=officeForPlan&code_param=" + rhqCd + "&all_flag=All");
			var arrXml=sXml.split("|$$|");
			if (arrXml.length > 0) {
				ComXml2ComboItem(arrXml[0], f_rgn_ofc_cd, "code", "name");
				f_rgn_ofc_cd.SetSelectIndex(0);
			}
		} else {
			f_rgn_ofc_cd.RemoveAll();
			f_rgn_ofc_cd.SetSelectIndex(0);
		}
	}
	/**
	*조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	* @param sheetObj
	* @param ErrMsg
	*/
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){	
		var formObj=document.form;
	}  
	/**
	 * 화면의 모든 버튼들의 Enable/Disable 을 처리
	 */
	function toggleButtons(step) {
		switch (step) {
			case "INIT":
				ComBtnDisable("btn_Creation");
				ComBtnDisable("btn_Downexcel");
				break;
			case "CREATE":
				ComBtnEnable("btn_Creation");
				break;
			case "SEARCH":
				ComBtnDisable("btn_Creation");
				ComBtnEnable("btn_Downexcel");
				break;
		}
	}
	function resizeSheet(){
	    for (i=0; i<sheetObjects.length; i++){
	        ComResizeSheet(sheetObjects[i]);
	    }
	}
	/* 개발자 작업  끝 */