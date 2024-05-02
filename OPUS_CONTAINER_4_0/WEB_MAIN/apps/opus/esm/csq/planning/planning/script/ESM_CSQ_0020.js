/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0020.js
*@FileTitle  : QTA Simulation by Head Office 
*@author     : CLT
*@version    : 1.0
*@since      : 2015/02/06
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends 
 * @class ESM_CSQ_0020 : ESM_CSQ_0020 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
	/* 개발자 작업	*/
	//공통전역변수
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var msg="";
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
				case "btn_Save":
					doActionIBSheet(sheetObject, formObj, IBSAVE);
					break;
				case "btn_Confirm":
					doActionIBSheet(sheetObject, formObj, MULTI01);
					break;
				case "btn_Downexcel":
					if (sheetObject.RowCount() < 1) {
						 ComShowCodeMessage("COM132501");
					} else{
						doActionIBSheet(sheetObject,formObj,IBDOWNEXCEL);
					}
					break;
				case "btn_Loadexcel":
					doActionIBSheet(sheetObject,formObj,IBLOADEXCEL);
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
		for (k=0;k<comboObjects.length;k++){
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
			        var HeadTitle1="STS|SEQ|Year|Quarter|Trade|Sub Trade|R.Lane|Lane\nBound|Trade\nBound|Week|VVD||||Supply|Unit REV / Cost (TEU)|Unit REV / Cost (TEU)|Unit REV / Cost (TEU)|Unit REV / Cost (TEU)|Unit REV / Cost (TEU)|Unit REV / Cost (TEU)|TTL Sales QTA|TTL Sales QTA|TTL Sales QTA|TTL Sales QTA|TTL Sales QTA|TTL Sales QTA";
			        var HeadTitle2="STS|SEQ|Year|Quarter|Trade|Sub Trade|R.Lane|Lane\nBound|Trade\nBound|Week|VVD||||Supply|L/F(%)|GRPB|CMCB(PA)|CMCB(RA)|CMPB(PA)|CMPB(RA)|Load|REV|CM cost(PA)|CM cost(RA)|CM(PA)|CM(RA)";
			        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			        var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
			        var headers = [ { Text:HeadTitle1, Align:"Center"},
			                        { Text:HeadTitle2, Align:"Center"} ];
			        InitHeaders(headers, info);
			        var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bse_yr",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		            if (loadExcelVal=="Y"){
		            	cols.push({Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bse_qtr_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		            }else{
		            	cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bse_qtr_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		            }
		            cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		            cols.push({Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		            cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		            cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		            cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"conv_dir_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		            cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bse_wk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		            cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		            cols.push({Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		            cols.push({Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		            cols.push({Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		            cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"fnl_bsa_capa",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		            cols.push({Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"ldf_rto",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, MinimumValue:0, MaximumValue:100 });
		            cols.push({Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"grs_rpb_rev",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		            cols.push({Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"pa_cm_uc_amt",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		            cols.push({Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"ra_cm_uc_amt",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		            cols.push({Type:"AutoSum",   Hidden:0, Width:110,  Align:"Right",   ColMerge:1,   SaveName:"pa_cm_u_amt",   KeyField:0,   CalcLogic:"pa_cm_u_amt_m(|ldf_rto|, |grs_rpb_rev|, |pa_cm_uc_amt|)",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		            cols.push({Type:"AutoSum",   Hidden:0, Width:110,  Align:"Right",   ColMerge:1,   SaveName:"ra_cm_u_amt",   KeyField:0,   CalcLogic:"ra_cm_u_amt_m(|ldf_rto|, |grs_rpb_rev|, |ra_cm_uc_amt|)",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		            cols.push({Type:"AutoSum",   Hidden:0, Width:110,  Align:"Right",   ColMerge:1,   SaveName:"load",          KeyField:0,   CalcLogic:"|fnl_bsa_capa|*|ldf_rto|*0.01",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		            cols.push({Type:"AutoSum",   Hidden:0, Width:110,  Align:"Right",   ColMerge:1,   SaveName:"g_rev",         KeyField:0,   CalcLogic:"|grs_rpb_rev|*|load|",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		            cols.push({Type:"AutoSum",   Hidden:0, Width:110,  Align:"Right",   ColMerge:1,   SaveName:"pa_cm_c",       KeyField:0,   CalcLogic:"|pa_cm_uc_amt|*|load|",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		            cols.push({Type:"AutoSum",   Hidden:0, Width:110,  Align:"Right",   ColMerge:1,   SaveName:"ra_cm_c",       KeyField:0,   CalcLogic:"|ra_cm_uc_amt|*|load|",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		            cols.push({Type:"AutoSum",   Hidden:0, Width:110,  Align:"Right",   ColMerge:1,   SaveName:"pa_cm",         KeyField:0,   CalcLogic:"pa_cm_m(|ldf_rto|, |grs_rpb_rev|, |g_rev|, |pa_cm_c|)",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			     	cols.push({Type:"AutoSum",   Hidden:0, Width:110,  Align:"Right",   ColMerge:1,   SaveName:"ra_cm",         KeyField:0,   CalcLogic:"ra_cm_m(|ldf_rto|, |grs_rpb_rev|, |g_rev|, |ra_cm_c|)",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			     	
			     	InitColumns(cols);
				    SetEditable(1);
				    SetRangeBackColor(1, 9, 1, 30, "#555555");
				    SetSheetHeight(400);
		      	}
			break;
		}
	}
	//CalcLogic:"IF(|ldf_rto| == 0, 0, IF(|grs_rpb_rev|==0, 0, |grs_rpb_rev|-|pa_cm_uc_amt|))"
    function pa_cm_u_amt_m(ldf_rto, grs_rpb_rev, pa_cm_uc_amt){
    	if(ldf_rto == 0 || grs_rpb_rev == 0){
    		return 0;
    	}else{
    		return grs_rpb_rev-pa_cm_uc_amt;
    	}
    }
	//CalcLogic:"IF(|ldf_rto| == 0, 0, IF(|grs_rpb_rev|==0, 0, |grs_rpb_rev|-|ra_cm_uc_amt|))"
    function ra_cm_u_amt_m(ldf_rto, grs_rpb_rev, ra_cm_uc_amt){
    	if(ldf_rto == 0 || grs_rpb_rev == 0){
    		return 0;
    	}else{
    		return grs_rpb_rev-ra_cm_uc_amt;
    	}
    }
    
	//CalcLogic:"IF(|ldf_rto| == 0, 0, IF(|grs_rpb_rev|==0, 0, |g_rev|-|pa_cm_c|))"
    function pa_cm_m(ldf_rto, grs_rpb_rev, g_rev, pa_cm_c){
    	if(ldf_rto == 0 || grs_rpb_rev == 0){
    		return 0;
    	}else{
    		return g_rev-pa_cm_c;
    	}
    }
    
	//CalcLogic:"IF(|ldf_rto| == 0, 0, IF(|grs_rpb_rev|==0, 0, |g_rev|-|ra_cm_c|))"
    function ra_cm_m(ldf_rto, grs_rpb_rev, g_rev, ra_cm_c){
    	if(ldf_rto == 0 || grs_rpb_rev == 0){
    		return 0;
    	}else{
    		return g_rev-ra_cm_c;
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
	 	} else {
	 		f_bse_qtr_cd.SetEnable(1);
	 	}
		period_change();
		setTradeCombo();
		toggleButtons("INIT");
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
	 /**
	  * f_bse_tp_cd,f_bse_qtr_cd,f_bse_yr가 바뀌었을때 trade콤보 settting
	  */
	 function setTradeCombo() {
		 	var formObj=document.form;
		 	var trd_cd=ComGetObjValue(f_trd_cd);
		    var bse_qtr_cd=ComGetObjValue(f_bse_qtr_cd);
		    var bse_yr=ComGetObjValue(f_bse_yr);
		 	if(bse_qtr_cd !="" && bse_yr !=""){
			 	var param="f_cmd=" + SEARCH02
			     + "&code_name=tradeControl"
			     + "&code_param=" 
			     + "&all_flag="
			     + "&" + FormQueryString(formObj);
			 	var xmlStr=sheetObjects[0].GetSearchData("CommonGS.do", param);
			 	ComXml2ComboItem(xmlStr, f_trd_cd, "code", "name");	
				var index=SearchIndex(f_trd_cd, trd_cd);
		 		f_trd_cd.SetSelectIndex(index);
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
				var sXml=sheetObj.GetSearchData("ESM_CSQ_0020GS.do", FormQueryString(formObj));
				// var State=ComGetEtcData(sXml, ComWebKey.Trans_Result_Key); 
				var arrXml=sXml.split("|$$|");
				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], f_bse_yr, "code", "name");
				if (arrXml.length > 1)
					ComXml2ComboItem(arrXml[1], f_bse_qtr_cd, "code", "name");
				if (arrXml.length > 2)
					ComSetYearQta(arrXml[2]);
				setTradeCombo();
				ComOpenWait(false);
				break;
			case IBSEARCH:          // 화면 조회 시
				if(ComGetObjValue(f_trd_cd) == ""){
					ComShowCodeMessage("CSQ00013",'Trade');
			        return false;
				}
				ComOpenWait(true);
				formObj.f_cmd.value=SEARCH;
				searchParams=FormQueryString(formObj);
				var rtnXml=sheetObj.GetSearchData("ESM_CSQ_0020GS.do",searchParams);
				sheetObj.LoadSearchData(rtnXml,{Sync:1} );
				if (ComGetObjValue(document.form.f_bse_tp_cd[0]) == "Y") {
					sheetObj.SetColHidden("bse_qtr_cd",1);
				} else {
					sheetObj.SetColHidden("bse_qtr_cd",0);
				}
				var etcData=getEtcData(rtnXml);
				if(etcData["dataCnt"] == 1 ){ 
					toggleButtons("AllConfirm");
				}else {
					toggleButtons("SEARCH");
				}
				if (sheetObj.SearchRows()== 0) {
					toggleButtons("INIT");
				}
				ComOpenWait(false);
				break;
			case IBSAVE:          // 화면 저장시
				if (!validateForm(sheetObj, formObj, sAction)) return false;
				if (sheetObj.IsDataModified()== false) {
					ComShowCodeMessage("CSQ00006");
			        return false;
			    } else if (ComShowConfirm (ComGetMsg("CSQ00004")) != 1) {
					return false;
			    }
				ComOpenWait(true);
				ComSetSearchParams("f_cmd", MULTI);
				var saveStr=sheetObj.GetSaveString(false, true, "ibflag");
				var sXml = sheetObj.GetSaveData("ESM_CSQ_0020GS.do", searchParams + "&" + saveStr);
				var State= ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
				ComOpenWait(false);
				if(State != "S"){
					ComShowMessage(ComResultMessage(sXml));
					return false;
				}else if(State == "S"){
					ComShowCodeMessage('CSQ00001','Data');
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
				}
				break;
			case MULTI01:          // 화면 confirm시
				if (sheetObj.IsDataModified()== true) {
					ComShowCodeMessage("CSQ00030",'confirm');
			        return false;
				}
			 	if (ComShowConfirm (ComGetMsg('CSQ00012','Confirm')) != 1) {
					return false;
			    }
				ComOpenWait(true);
				ComSetSearchParams("f_cmd", MULTI01);
				var sXml = sheetObj.GetSearchData("ESM_CSQ_0020GS.do",searchParams);
				var State= ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
				ComOpenWait(false);
				if(State != "S"){
					ComShowMessage(ComResultMessage(sXml));
					return false;
				}else if(State == "S"){
					ComShowCodeMessage('CSQ00016','Data');
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
				}
				break;
			case IBLOADEXCEL:		// 엑셀 업로드
				loadExcelRowCnt=sheetObj.HeaderRows()+ sheetObj.GetTotalRows();
				loadExcelTotFlg=true;		// 화면에 Total Row 존재 여부
				loadExcelVal=ComGetObjValue(formObj.f_bse_tp_cd[0]); //자식창 inisheet시에 bse_tp_cd히든 여부 설정
				if(ComGetObjValue(formObj.f_bse_tp_cd[0])=="Y")
					loadExcelExField="|bse_qtr_cd|dir_cd|vsl_cd|skd_voy_no|skd_dir_cd|ldf_rto|grs_rpb_rev|pa_cm_u_amt|ra_cm_u_amt|load|g_rev|pa_cm_c|ra_cm_c|pa_cm|ra_cm|";		// 비교 제외 필드
				else
					loadExcelExField="|dir_cd|vsl_cd|skd_voy_no|skd_dir_cd|ldf_rto|grs_rpb_rev|pa_cm_u_amt|ra_cm_u_amt|load|g_rev|pa_cm_c|ra_cm_c|pa_cm|ra_cm|";		// 비교 제외 필드
				loadExcelAplyField="|ldf_rto|grs_rpb_rev|";		// 반영 필드
	        	ComOpenPopup("ESM_CSQ_1001.do?", 1050, 620, "", "0,0", true);
				break;
			case IBDOWNEXCEL:		// 엑셀 다운로드
				ComOpenWait(true);
				sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
				ComOpenWait(false);
				break;
	    }
	}
	
	 /**
	 *조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 * @param sheetObj
	 * @param ErrMsg
	 */
	 function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		 setSumText(sheetObj);
	}
	 
	 function setSumText(sheetObj){
		 sheetObj.SetSumText(0, "ibflag","");
		 sheetObj.SetSumText(0, "bse_yr","TOTAL");
		//단가 total값 set
		 if(sheetObj.GetSumValue(0, "load")!=0){
			sheetObj.SetSumText(0, "pa_cm_uc_amt",AddComma(Math.round(sheetObj.GetSumValue(0, "pa_cm_c")/sheetObj.GetSumValue(0, "load"))));
			sheetObj.SetSumText(0, "ra_cm_uc_amt",AddComma(Math.round(sheetObj.GetSumValue(0, "ra_cm_c")/sheetObj.GetSumValue(0, "load"))));
			sheetObj.SetSumText(0, "pa_cm_u_amt",AddComma(Math.round(sheetObj.GetSumValue(0, "pa_cm")/sheetObj.GetSumValue(0, "load"))));
			sheetObj.SetSumText(0, "ra_cm_u_amt",AddComma(Math.round(sheetObj.GetSumValue(0, "ra_cm")/sheetObj.GetSumValue(0, "load"))));
		} else {
			sheetObj.SetSumText(0, "pa_cm_uc_amt",0);
			sheetObj.SetSumText(0, "ra_cm_uc_amt",0);
			sheetObj.SetSumText(0, "pa_cm_u_amt",0);
			sheetObj.SetSumText(0, "ra_cm_u_amt",0);
		}
	}
	 
	 /**
	  * 천단위마다 콤마를 찍어주는 함수
	  */
	 function AddComma(number){
		 var str=new Array(); 
		 number=String(number);
		 for(var i=1;i<=number.length;i++){
		  if(i%3) 
			  str[number.length-i]=number.charAt(number.length-i); //자리수가 아니면 숫자만삽입
		  else  
			  str[number.length-i]=','+number.charAt(number.length-i); //자리수 이면 콤마까지 삽입
		 }
		 return str.join('').replace(/^,/,'');
	} 
	/**
	 * onChange event
	 * f_trd_cd 바뀌었을때  f_lane_cd 콤보조회
	 */	
	 function f_trd_cd_OnChange(obj, value, text) {
		 setLaneCombo();
	}
	 /**
	  *   f_bse_yr, f_bse_qtr_cd, f_trd_cd 바뀌었을때  f_lane_cd, f_dir_cd 콤보조회
	  */
	 function setLaneCombo(){
		 	var formObj=document.form;
		 	var trd_cd=ComGetObjValue(f_trd_cd);	// trade code
		    var rlane_cd=ComGetObjValue(f_rlane_cd);
		    var dir_cd=ComGetObjValue(f_dir_cd);
			if (trd_cd != "All" && trd_cd != "") {	
			 	var param="f_cmd=" + SEARCH02
			     + "&code_name=rLaneControl,BoundControl"
			     + "&code_param=null,null" 
			     + "&all_flag=All,All"
			     + "&" + FormQueryString(formObj);	// Trade
			 	var xmlStr=sheetObjects[0].GetSearchData("CommonGS.do", param);
				var arrXml=xmlStr.split("|$$|");
				if (arrXml.length > 0) ComXml2ComboItem(arrXml[0], f_rlane_cd, "code", "name");		
				if (arrXml.length > 1)ComXml2ComboItem(arrXml[1], f_dir_cd, "code", "name");
				// 변경된 Combo box에서 이전선택된 코드의 Index를 구해서 세팅한다.
				var rlane_index=SearchIndex(f_rlane_cd, rlane_cd);
				var dir_index=SearchIndex(f_dir_cd, dir_cd);
				f_rlane_cd.SetSelectIndex(rlane_index);
				f_dir_cd.SetSelectIndex(dir_index);
			} else {
				f_rlane_cd.RemoveAll();
				f_rlane_cd.InsertItem(0, "All", "All");
				f_dir_cd.RemoveAll();
				f_dir_cd.InsertItem(0, "All", "All");
			}
	 }
	 
	 /**
	  * 화면의 모든 버튼들의 Enable/Disable 을 처리
	  */
	 function toggleButtons(step) {
	 	switch (step) {
	 		case "INIT":
	 			ComBtnDisable("btn_Save");
	 			ComBtnDisable("btn_Confirm");
	 			ComBtnDisable("btn_Downexcel");
	 			ComBtnDisable("btn_Loadexcel");
	 			break;
	 		case "SEARCH":
	 			ComBtnEnable("btn_Save");
	 			ComBtnEnable("btn_Downexcel");
	 			ComBtnEnable("btn_Loadexcel");
	 			ComBtnEnable("btn_Confirm");
	 			break;
	 		case "AllConfirm":
	 			ComBtnDisable("btn_Save");
	 			ComBtnDisable("btn_Confirm");
	 			ComBtnEnable("btn_Downexcel");
	 			ComBtnDisable("btn_Loadexcel");
	 			break;
	 	}
	 }  
	  /**
	  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	  */
	 function validateForm(sheetObj, formObj, sAction){
	 	switch(sAction) {
	 		case IBSAVE:  // save시 
	 			var upRow=sheetObj.FindStatusRow("U");
	 			var uRow=upRow.split(";");
	 			var sMsg="";
	 			for(var i=0;i<uRow.length;i++){ 			
	 				if(eval(sheetObj.GetCellValue(uRow[i],"ldf_rto")) != 0 && eval(sheetObj.GetCellValue(uRow[i],"grs_rpb_rev")) == 0 ){
	 					sMsg=sMsg + "\n" + sheetObj.GetCellValue(uRow[i],"trd_cd")
	 					+ "-" + sheetObj.GetCellValue(uRow[i],"rlane_cd")
	 					+"-" + sheetObj.GetCellValue(uRow[i],"conv_dir_cd")
	 					+"-" + sheetObj.GetCellValue(uRow[i],"bse_wk");
	 				}
	 			}
	 			if(sMsg!=""){
					ComShowCodeMessage("CSQ00037","Trade-Rlane-Bound-Week",sMsg);
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
	/* 개발자 작업  끝 */