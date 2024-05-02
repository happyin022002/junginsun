/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0036.jsp
*@FileTitle  : QTA Establishing Status
*@author     : CLT
*@version    : 1.0
*@since      : 2015/01/21
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends 
 * @class ESM_CSQ_0036 : ESM_CSQ_0036 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
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
				case "f_bse_tp_cd":
					f_bse_tp_cd_OnChange();
					break;
				case "btn_Retrieve":
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
					break;
				case "btn_GrpbCreation":
					doActionIBSheet(sheetObj, formObj, "GrpbCreation");
					break;
				case "btn_HoCreation":
					doActionIBSheet(sheetObj, formObj, "HoCreation");
					break;
				case "btn_RhqCreation":
					doActionIBSheet(sheetObj, formObj, "RhqCreation");
					break;
				case "btn_QtaFreezing":
					doActionIBSheet(sheetObj, formObj, "QtaFreezing");
					break;
				case "btn_CancelConfirm":
					doActionIBSheet(sheetObj, formObj, "CancelConfirm");
					break;
				case "btn_DownExcel":
					if (sheetObj.RowCount() < 1){//no data
			          ComShowCodeMessage("COM132501");
			        } else{
			        	doActionIBSheet(sheetObj, formObj, IBDOWNEXCEL);
			        }
					break;
				case "btn_Transfer":
					doActionIBSheet(sheetObj, formObj, "Transfer");
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
		toggleButtons();
		setTradeCombo();
		loadingMode=false;
		resizeSheet();
	}
	
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetNo) {
			case 1:		//sheet1 init
			    with(sheetObj){
		        var HeadTitle1="SEQ|Step|Office View|Status|HO Teams|Trade|Trade Bound|Org.|Updated|Confirm Cancel|STS|Ver";
		        SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:1 } );
		        var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
		        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		        InitHeaders(headers, info);
		        var cols = [ {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"qta_step_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:280,  Align:"Center",  ColMerge:1,   SaveName:"qta_step_desc",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Combo",     Hidden:0, Width:110,   Align:"Center",  ColMerge:1,   SaveName:"ofc_vw_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"csq_ver_sts_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"team_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"conv_dir_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"cre_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:1,   SaveName:"upd_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"CheckBox",  Hidden:0, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"confirm_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"qta_ver_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
		       
		        InitColumns(cols);
		        SetEditable(1);
		      	SetSheetHeight(300);
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
				var sXml=sheetObj.GetSearchData("ESM_CSQ_0036GS.do", FormQueryString(formObj));
				var arrXml=sXml.split("|$$|");
				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], f_bse_yr, "code", "name");
				if (arrXml.length > 1)
					ComXml2ComboItem(arrXml[1], f_bse_qtr_cd, "code", "name");
				if (arrXml.length > 2)
					ComSetYearQta(arrXml[2]);
				if (arrXml.length > 3)
					ComXml2ComboItem(arrXml[3], f_qta_step_cd, "code", "name");
				if (arrXml.length > 4)
					ComXml2ComboItem(arrXml[4], f_dir_cd, "code", "name");
				if (arrXml.length > 5)
					ComXml2ComboItem(arrXml[5], f_ho_team_cd, "code", "name");
				if (arrXml.length > 6)
					ComXml2ComboItem(arrXml[6], f_org_cd, "code", "name");
				if (arrXml.length > 7)
					ComCsqSetIBCombo(sheetObj, arrXml[7], "ofc_vw_cd", true);
				ComOpenWait(false);
				break;
				
			case IBSEARCH:          // 화면 조회
				ComOpenWait(true);
				toggleButtons();
				formObj.f_cmd.value=SEARCH;
				searchParams=FormQueryString(formObj);
				var rtnXml=sheetObj.GetSearchData("ESM_CSQ_0036GS.do", searchParams);
				sheetObj.LoadSearchData(rtnXml,{Sync:1} );
				var etcData=getEtcData(rtnXml);
				var td_trans=document.getElementById("td_trans");
				var bse_tp_cd=ComGetObjValue(document.form.f_bse_tp_cd[0]);
				if (bse_tp_cd == "Y" ) {
					 td_trans.style.display="inline";
				} else {
					 td_trans.style.display="none";
				}
				// Setp 01 이 없거나 Data 가 존재 하지 않을 때
				if ( etcData["step01Cnt"] == 0 || etcData["NODATA"] == "Y" )	toggleButtons("GRPB");
				// 연간 Data 조회하면서 Rlse 정보가 존재할 때(Freeze 되었을때), 전환 할 1Q의 Data 가 존재 하지 않을 때
				if ( etcData["rlseFlg"] == "Y" && bse_tp_cd == "Y" && etcData["transFlg"] == "N")	toggleButtons("TRANS");
				// Step 02 이 없을 때
				if ( etcData["step02Cnt"] == 0 )	toggleButtons("HO");
				// Step 03 이 없을 때
				if ( etcData["step03Cnt"] == 0 )	toggleButtons("RHQ");
				// Rlse 가 존재 하지 않으면서 Freeze 가능 할때(모든 Step 이 Confirm 일 경우) 
				if ( etcData["freezeFlg"] == "Y" && etcData["rlseFlg"] == "N")	toggleButtons("FREEZE");
				// Rlse 가 존재 하지 않으면서 Data 가 존재할 경우
				if ( sheetObj.SearchRows()!= 0 && etcData["rlseFlg"] == "N")	toggleButtons("CANCEL");
				if ( sheetObj.SearchRows()!= 0 )		toggleButtons("SEARCH");
				
				ComOpenWait(false);
				break;
				
			case "CancelConfirm":
				if (sheetObj.IsDataModified()== false) {
					ComShowCodeMessage("CSQ00006");
			        return false;
			    } else if (ComShowConfirm (ComGetMsg("CSQ00012", "Cancel Confirm")) != 1) {
					return false;
			    }
				ComOpenWait(true);
				ComSetSearchParams("f_cmd", MULTI);
				var saveStr=sheetObj.GetSaveString(false, true, "ibflag");
				var sXml = sheetObj.GetSaveData("ESM_CSQ_0036GS.do", searchParams + "&" + saveStr);
				var State= ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
				ComOpenWait(false);
				if (State == "S") {
					ComShowCodeMessage("CSQ00001", "Data");
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
				}
				break;
				
			case "GrpbCreation":
				if (ComShowConfirm (ComGetMsg("CSQ00012", "L/F & G.RPB Creation")) != 1) {
					return false;
			    }
				ComOpenWait(true);
				ComSetSearchParams("f_cmd", MULTI01);
				var sXml=sheetObj.GetSaveData("ESM_CSQ_0036GS.do", searchParams);
				ComOpenWait(false);
				var State=ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
				if ( State == "S" ) {
					ComShowCodeMessage("CSQ00010", "Data");
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
				} else if ( State != "S" ) {
					ComShowMessage(ComResultMessage(sXml));
					return false;
				}
				break;
				
			case "HoCreation":
				if (ComShowConfirm (ComGetMsg("CSQ00012", "HO Creation")) != 1) {
					return false;
			    }
				ComOpenWait(true);
				ComSetSearchParams("f_cmd", MULTI02);
				var sXml=sheetObj.GetSaveData("ESM_CSQ_0036GS.do", searchParams);
				ComOpenWait(false);
				var State=ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
				if ( State == "S" ) {
					ComShowCodeMessage("CSQ00010", "Data");
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
				} else if ( State != "S" ) {
					ComShowMessage(ComResultMessage(sXml));
					return false;
				}
				break;
				
			case "RhqCreation":
				if (ComShowConfirm (ComGetMsg("CSQ00012", "RHQ Creation")) != 1) {
					return false;
			    }
				ComOpenWait(true);
				ComSetSearchParams("f_cmd", MULTI03);
				var sXml=sheetObj.GetSaveData("ESM_CSQ_0036GS.do", searchParams);
				ComOpenWait(false);
				var State=ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
				if ( State == "S" ) {
					ComShowCodeMessage("CSQ00010", "Data");
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
				} else if ( State != "S" ) {
					ComShowMessage(ComResultMessage(sXml));
					return false;
				}
				break;
				
			case "QtaFreezing":
				if (ComShowConfirm (ComGetMsg("CSQ00012", "QTA Freezing")) != 1) {
					return false;
			    }
				ComOpenWait(true);
				ComSetSearchParams("f_cmd", MULTI04);
				var sXml=sheetObj.GetSaveData("ESM_CSQ_0036GS.do", searchParams);
				var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey");
				if (backendJobKey != null && backendJobKey.length > 0) {
					ComSetObjValue(formObj.backendjob_key, backendJobKey);
					sheetObj.SetWaitTimeOut(3600);//초 - 1시간
					backEndJobTimer=setInterval(getBackEndJobStatus, 5000);	//밀리초  - 10초
				}
				break;
				
			case "Transfer":
				if (ComShowConfirm (ComGetMsg("CSQ00012", "1Q Transfer")) != 1) {
					return false;
			    }
				ComOpenWait(true);
				ComSetSearchParams("f_cmd", MULTI05);
				var sXml=sheetObj.GetSaveData("ESM_CSQ_0036GS.do", searchParams);
				var State=ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
				var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey");
				if (backendJobKey != null && backendJobKey.length > 0) {
					ComSetObjValue(formObj.backendjob_key, backendJobKey);
					sheetObj.SetWaitTimeOut(3600);//초 - 1시간
					backEndJobTimer=setInterval(getBackEndJobStatus, 5000);	//밀리초  - 10초
				}
				break;
				
			case IBDOWNEXCEL:		// 엑셀 다운로드
				ComOpenWait(true);
				sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(			sheetObj), SheetDesign:1,Merge:1 });
				ComOpenWait(false);
				break;
	    }
	}
	/**
	 * 화면의 모든 버튼들의 Enable/Disable 을 처리
	 */
	function toggleButtons(step) {
		switch (step) {
			case "GRPB":
				ComBtnEnable("btn_GrpbCreation");
				break;
			case "HO":
				ComBtnEnable("btn_HoCreation");
				break;
			case "RHQ":
				ComBtnEnable("btn_RhqCreation");
				break;
			case "FREEZE":
				ComBtnEnable("btn_QtaFreezing");
				break;
			case "TRANS":
				ComBtnEnable("btn_Transfer");
				break;
			case "CANCEL":
				ComBtnEnable("btn_CancelConfirm");
				break;
			case "SEARCH":
				ComBtnEnable("btn_DownExcel");
				break;
			default:
				ComBtnDisable("btn_GrpbCreation");
				ComBtnDisable("btn_HoCreation");
				ComBtnDisable("btn_RhqCreation");
				ComBtnDisable("btn_QtaFreezing");
				ComBtnDisable("btn_CancelConfirm");
				ComBtnDisable("btn_DownExcel");
				ComBtnDisable("btn_Transfer");
				break;
		}
	}
	/**
	* BackEndJob 관련 Status='3' 이 될때까지 확인한다.<br>
	*/     
	function getBackEndJobStatus() {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		ComOpenWait(true);
		var sXml=sheetObj.GetSearchData("ESM_CSQ_0036GS.do", "f_cmd=" + SEARCH01 + "&backendjob_key=" + formObj.backendjob_key.value);
		var jobState=ComGetEtcData(sXml, "jb_sts_flg");
		var errMsg=ComGetEtcData(sXml, "jb_usr_err_msg");
		if (jobState == "3") {
			ComShowCodeMessage("CSQ00010", "Data");
			clearInterval(backEndJobTimer);
			ComOpenWait(false);
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
		} else if (jobState == "4") {
			ComShowCodeMessage("CSQ00038", errMsg);
			ComOpenWait(false);
			clearInterval(backEndJobTimer);
		} else if (jobState == "5") {
			ComShowCodeMessage("CSQ00039");
			ComOpenWait(false);
			clearInterval(backEndJobTimer);
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
	 	var sXml=sheetObj.GetSearchData("CommonGS.do",param);
		ComXml2ComboItem(sXml, f_trd_cd, "code", "name");
		// 변경된 Combo box에서 이전선택된 코드의 Index를 구해서 세팅한다.
		var index=SearchIndex(f_trd_cd, trd_cd);
		f_trd_cd.SetSelectIndex(index);
	}
	
	function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
}
	
	/* 개발자 작업  끝 */
