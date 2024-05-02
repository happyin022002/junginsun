/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0008.js
*@FileTitle  : Basic Data Creation
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
 * @class ESM_CSQ_0008 : ESM_CSQ_0008 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
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
			var srcName = ComGetEvent("name");
			switch(srcName) {
				case "f_bse_tp_cd":
					f_bse_tp_cd_OnChange();
					break;
				case "btn_Retrieve":
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
					break;
				case "btn_Create":
					doActionIBSheet(sheetObj, formObj, IBCREATE);
					break;
				case "btn_DownExcel":
					if(sheet1.RowCount() < 1){
			          ComShowCodeMessage("COM132501");
			        } else{
			        	doActionIBSheet(sheet1, formObj, IBDOWNEXCEL);
			        }
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
		for (k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],comboObjects[k].id);
		}
		toggleButtons("INIT");
		setTradeCombo();
		resizeSheet();
		loadingMode=false;
	}
	
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		switch(sheetNo) {
			case 1:		//sheet1 init
			    with(sheetObj){
		        	var f_ofc_lvl = ComGetObjValue(document.form.f_ofc_lvl);
		        	var HeadTitle="SEQ|Year|Quarter|Office Level|Office View|Trade|Sub Trade|R.Lane|Lane Bound|RHQ|";
		        	if (f_ofc_lvl == "1" || f_ofc_lvl == "") {
		        		HeadTitle=HeadTitle + "Volume|G.REV|VVD Count|Volume (%)|G.REV (%)";
		        	} else {
		        		HeadTitle=HeadTitle + "Office|Volume|G.REV|RA CM|PA CM|RA CM Cost|PA CM Cost|VVD Count|Volume (%)|G.REV (%)";
		        	}
		        	SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
		        	var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
		        	var headers = [ { Text:HeadTitle, Align:"Center"} ];
		        	InitHeaders(headers, info);
		        	var cols = [ {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bse_yr",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"bse_qtr_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ofc_lvl",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ofc_vw_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rhq_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		        	if (f_ofc_lvl == "1" || f_ofc_lvl == "") {
					      cols.push({Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"lod_vol",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
					      cols.push({Type:"AutoSum",   Hidden:0, Width:110,  Align:"Right",   ColMerge:1,   SaveName:"grs_rev",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
					      cols.push({Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"vvd_cnt",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
					      cols.push({Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"vol_rto",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
					      cols.push({Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"grs_rto",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
		        	} else {
					      cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
					      cols.push({Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"lod_vol",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
					      cols.push({Type:"AutoSum",   Hidden:0, Width:110,  Align:"Right",   ColMerge:1,   SaveName:"grs_rev",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
					      cols.push({Type:"AutoSum",   Hidden:0, Width:110,  Align:"Right",   ColMerge:1,   SaveName:"ra_cm",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
					      cols.push({Type:"AutoSum",   Hidden:0, Width:110,  Align:"Right",   ColMerge:1,   SaveName:"pa_cm",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
					      cols.push({Type:"AutoSum",   Hidden:0, Width:110,  Align:"Right",   ColMerge:1,   SaveName:"ra_cm_cost",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
					      cols.push({Type:"AutoSum",   Hidden:0, Width:110,  Align:"Right",   ColMerge:1,   SaveName:"pa_cm_cost",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
					      cols.push({Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"vvd_cnt",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
					      cols.push({Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"vol_rto",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
					      cols.push({Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"grs_rto",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
		        	}
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
	 * Sheet 관련 프로세스 처리
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBCLEAR:          // 화면 접속 시
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				formObj.f_cmd.value=INIT;
				var sXml=sheetObj.GetSearchData("ESM_CSQ_0008GS.do", FormQueryString(formObj));
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
					ComXml2ComboItem(arrXml[4], f_dir_cd, "code", "name");
				if (arrXml.length > 5)
					ComXml2ComboItem(arrXml[5], f_ofc_lvl, "code", "name");
				if (arrXml.length > 6)
					ComXml2ComboItem(arrXml[6], f_rhq_cd, "code", "name");
				ComOpenWait(false);
				break;
			case IBSEARCH:          // 화면 조회
				ComOpenWait(true);
				formObj.f_cmd.value=SEARCH;
				ComBtnDisable("btn_Create");
				searchParams=FormQueryString(formObj);
				sheetObj = sheetObj.Reset();
				initSheet(sheetObj, 1);
				resizeSheet();
				var rtnXml=sheetObj.GetSearchData("ESM_CSQ_0008GS.do", searchParams);
				sheetObj.LoadSearchData(rtnXml,{Sync:1} );
				if (ComGetObjValue(document.form.f_bse_tp_cd[0]) == "Y") {
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
				if (ComTrim(etcData["aplyFmYrwk"]) != "" && ComTrim(etcData["aplyToYrwk"]) != "") {
					span_period.innerHTML=etcData["aplyFmYrwk"].substring(0, 4)
					                      + ".wk" + etcData["aplyFmYrwk"].substring(4)
					                      + " ~ " + etcData["aplyToYrwk"].substring(0, 4)
					                      + ".wk" + etcData["aplyToYrwk"].substring(4);
				} else {
					span_period.innerHTML="&nbsp;";
				}
				sheetObj.SetSumText(0,0,"");
				sheetObj.SetSumText(0,3,"TOTAL");
				ComOpenWait(false);
				break;
			case IBCREATE:          // 생성 화면 Pop-up
				 ComOpenWindow("ESM_CSQ_0009.do?" + searchParams,  null,  "dialogHeight:245px;dialogWidth:600px;center:yes;resizable:yes;scroll:yes;status:no;unadorned:yes;" , true);
				break;
			case IBDOWNEXCEL:		// 엑셀 다운로드
				ComOpenWait(true);
				sheet1.Down2Excel({DownCols: makeHiddenSkipCol(sheet1), SheetDesign:1,Merge:1 });
				ComOpenWait(false);
				break;
	    }
	}
	
	function sheet1_OnSearchEnd(sheetObj, errMsg) {
		sheetObj.SetWaitImageVisible(0);
	}
	/**
	 *  선택된 Trade 에 해당하는 R.Lane 정보 가져와서 Combo Box 셋팅
	 */
	function f_trd_cd_OnChange(obj, value, text){
		setLaneCombo();
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
	    var trd_cd		 = ComGetObjValue(f_trd_cd);

	 	param="f_cmd=" + SEARCH01
	     + "&code_name=trade"
	     + "&code_param=" + f_bse_tp_cd + "|" + f_bse_yr + "|" + f_bse_qtr_cd
	     + "&all_flag=All";	// Trade
	 	var sXml = sheetObj.GetSearchData("CommonGS.do",param);
		ComXml2ComboItem(sXml, f_trd_cd, "code", "name");
		// 변경된 Combo box에서 이전선택된 코드의 Index를 구해서 세팅한다.
		var index = SearchIndex(f_trd_cd, trd_cd);
		f_trd_cd.SetSelectIndex(index);
	}
	/**
	 * f_bse_yr, f_bse_qtr_cd, f_trd_cd 바뀌었을때  f_lane_cd 콤보조회
	 */
	function setLaneCombo() {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		var param="";
		var trd_cd		 = ComGetObjValue(f_trd_cd);
		var rlane_cd	 = ComGetObjValue(f_rlane_cd);
		var f_bse_tp_cd  = ComGetObjValue(formObj.f_bse_tp_cd[0]);
		var f_bse_yr 	 = ComGetObjValue(formObj.f_bse_yr);
		var f_bse_qtr_cd = ComGetObjValue(formObj.f_bse_qtr_cd);
		if (trd_cd != "All") {
		 	param="f_cmd=" + SEARCH01
		     	+ "&code_name=rLane"
		     	+ "&code_param="+trd_cd+"|"
		     					+f_bse_tp_cd+"|"
		     					+f_bse_yr+"|"
		     					+f_bse_qtr_cd
		     	+ "&all_flag=All";
		 	var sXml=sheetObj.GetSearchData("CommonGS.do",param);
			ComXml2ComboItem(sXml, f_rlane_cd, "code", "name");
			// 변경된 Combo box에서 이전선택된 코드의 Index를 구해서 세팅한다.
			var index=SearchIndex(f_rlane_cd, rlane_cd);
			f_rlane_cd.SetSelectIndex(index);
		} else {
			f_rlane_cd.RemoveAll();
			f_rlane_cd.InsertItem(0, "All", "All");
			f_rlane_cd.SetSelectIndex(0);
		}
	}
	/**
	 * 화면의 모든 버튼들의 Enable/Disable 을 처리
	 */
	function toggleButtons(step) {
		switch (step) {
			case "INIT":
				ComBtnDisable("btn_Create");
				ComBtnDisable("btn_DownExcel");
				break;
			case "CREATE":
				ComBtnEnable("btn_Create");
				break;
			case "SEARCH":
				ComBtnEnable("btn_DownExcel");
				break;
		}
	}
	/**
	 * f_bse_tp_cd 바뀌었을때 qtr_cd, week 변경
	 */
	function f_bse_tp_cd_OnChange() {
		var formObj=document.form;
		var bse_tp_cd = ComGetObjValue(formObj.f_bse_tp_cd[0]);
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
		setTradeCombo();
	}
	/**
	 * f_bse_yr가 바뀌었을때 period 의 year 변경
	 */
	function f_bse_yr_OnChange(obj, value, text) {
		period_change();
		setTradeCombo();
	}
	/**
	 * f_bse_qtr_cd 바뀌었을때 period 의 week 기간변경
	 */
	function f_bse_qtr_cd_OnChange(obj, value, text) {
		period_change();
		setTradeCombo();
	}
	
	function resizeSheet(){
	    for (i=0; i<sheetObjects.length; i++){
	        ComResizeSheet(sheetObjects[i]);
	    }
	}
	/* 개발자 작업  끝 */