/*=========================================================
 *Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0202.js
*@FileTitle  : POL-POD Management for IAS Sector
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
	 * @class ESM_CSQ_0202 : ESM_CSQ_0202 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	/* 개발자 작업	*/
	//공통전역변수
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var tabLoad=new Array();
	tabLoad[0]=0;
	tabLoad[1]=0;
	var rowCnt=0;
	var loadExcelsectorFlg="";
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
				case "btn_Creation":
					doActionIBSheet(sheetObject, formObj, MULTI01);
					break;
				case "btn_AddCreation":
					ComOpenPopup("ESM_CSQ_0203.do?"+searchParams, 890, 530, "callbackPopup", "0,0", true);
					break;
				case "btn_Downexcel":
					if(sheetObject.RowCount() < 1) {
						 ComShowCodeMessage("COM132501");
					} else{
						doActionIBSheet(sheetObject, formObj, IBDOWNEXCEL);
					}
					break;
				case "btn_Loadexcel":
						doActionIBSheet(sheetObject, formObj, IBLOADEXCEL);
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
	
	function callbackPopup(value){
	    if(value == "S"){
	    	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
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
	/**
	 * IBTab Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setTabObject(tab_obj){
		tabObjects[tabCnt++]=tab_obj;
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
		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1);
			tabObjects[k].SetSelectedIndex(0); // Huy.mai
		}
		doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);
		for(k=0;k<comboObjects.length;k++){
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
		        var HeadTitle1="STS|SEQ|Trade|Sub Trade|R.Lane|Lane Bound|POL|POD|Active|sctr_ofc_cre_flg|Main|";
		        SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:0 } );
		        var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
		        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		        InitHeaders(headers, info);
		        var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Seq",       Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rlane_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"dir_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"pol_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"pod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"CheckBox",  Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"csq_act_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"sctr_ofc_cre_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"CheckBox",  Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"csq_mn_sctr_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"",  					KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
		      InitColumns(cols);
		      SetEditable(1);
		      SetSheetHeight(400);
		            }
				break;
			case 2:		//sheet2 init
			    with(sheetObj){
		        var HeadTitle1="STS|SEQ|Trade|Sub Trade|R.Lane|Lane Bound|P/F SKD Group|POL|POL(Seq)|POD|POD(Seq)|Active|Main|";
		        SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0} );
		        var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
		        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		        InitHeaders(headers, info);
		        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rlane_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"dir_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"pf_grp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pol_call_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pod_call_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"csq_act_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"csq_mn_sctr_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
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
			case "f_pf_grp_cd":
				with (comboObj) {
					SetTitleVisible(1);
					SetTitle("R/Lane|Group"); 
					SetColAlign(0, "center");
					SetColAlign(1, "center");
					SetColWidth(0, "100");
					SetColWidth(1, "100");
					ValidChar(2,1);
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
	 * Tab 기본 설정
	 * 탭의 항목을 설정한다.
	 */
	function initTab(tabObj , tabNo) {
		switch(tabNo) {
			case 1:
				with (tabObj) {
					var cnt=0 ;
					InsertItem( "Pair Active Edit" , "");
					InsertItem( "Pair by P/F SKD Group" , "");
				}
				break;
		}
		tabObjects[0].SetSelectedIndex(0);// Huy.Mai
	}
	/**
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	 */
	function tab1_OnChange(tabObj , tabIndex) {
//		var objs=document.all.item("tabLayer");
//		var formObj=document.form;
//		objs[nItem].style.display="inline";
//		objs[beforetab].style.display="none";
//		//--------------- 요기가 중요 --------------------------//
//		objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
//		//------------------------------------------------------//
//		// 두번째 tab 일 때 loadExcel 버튼 비활성화
//		if(formObj.dataCnt.value > 0 ){
//			if(nItem == "1"){
//				ComBtnDisable("btn_Loadexcel");
//			}else{
//			    ComBtnEnable("btn_Loadexcel");
//			}
//		}
//		beforetab=nItem;
		//Huy.Mai
		var formObj=document.form;
		var objs=document.all.item("tabLayer");
		objs[tabIndex].style.display="Inline";
		for(var i = 0; i<objs.length; i++){
			if(i != tabIndex){
				objs[i].style.display="none";
				objs[beforetab].style.zIndex=objs[tabIndex].style.zIndex - 1 ;
			}
		}
		if(formObj.dataCnt.value > 0 ){
			if(tabIndex == "1"){
				ComBtnDisable("btn_Loadexcel");
			}else{
			    ComBtnEnable("btn_Loadexcel");
			}
		}
		beforetab=tabIndex;
		
		resizeSheet2();
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
		var sheetObj1=sheetObjects[1];
		switch(sAction) {
			case IBCLEAR:          // 화면 접속 시
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				formObj.f_cmd.value=INIT;
				var sXml=sheetObj.GetSearchData("ESM_CSQ_0202GS.do", FormQueryString(formObj));
				//var State=ComGetEtcData(sXml, ComWebKey.Trans_Result_Key); 
				var arrXml=sXml.split("|$$|");
				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], f_bse_yr, "code", "name");
				if (arrXml.length > 1)
					ComXml2ComboItem(arrXml[1], f_bse_qtr_cd, "code", "name");
				if (arrXml.length > 2)
					ComSetYearQta(arrXml[2]);
				if (arrXml.length > 3)
					ComXml2ComboItem(arrXml[3], f_dir_cd, "code", "name");
				ComOpenWait(false);
				break;
			case IBSEARCH:          // 화면 조회 시
				//Tab1 조회 View Adapter가 달라서 서버를 2번 탐.
				formObj.f_cmd.value=SEARCH;
				searchParams=FormQueryString(formObj);
				ComOpenWait(true);
				setTimeout(function(){
					var rtnXml=sheetObj.GetSearchData("ESM_CSQ_0202GS2.do",searchParams);
					sheetObj.LoadSearchData(rtnXml,{Sync:1} );
					var etcData=getEtcData(rtnXml);
					ComSetSearchParams("f_cmd", SEARCH01);
		 			var rtnXml1=sheetObj.GetSearchData("ESM_CSQ_0202GS.do",searchParams);
					sheetObj1.LoadSearchData(rtnXml1,{Sync:1} );
					formObj.dataCnt.value=etcData["dataCnt"];
					if (formObj.dataCnt.value == 0) {
						toggleButtons("SEARCH01");
					} else {
						toggleButtons("SEARCH02");
						//Main Flag가 All이거나 N 일때 Main Flag가 하나도 체크 안된 Lane/Bound 조회
						if(ComGetSearchParams("f_csq_mn_sctr_flg") != "Y"){
							doActionIBSheet(sheetObjects[0], document.form, SEARCH03);
						}
					}
				}, 100);
				ComOpenWait(false);
				break;
			case SEARCH03:          // 화면 조회 후 Main flag가 하나도 체크되어 있지 않은 Lane, Bound 조회
				ComSetSearchParams("f_cmd", SEARCH03);
				ComOpenWait(true);
	 			var sXml=sheetObj.GetSearchData("ESM_CSQ_0202GS.do",searchParams);
				var nMainList=ComGetEtcData(sXml, "nMainList");
				if(nMainList != null && nMainList != ""){
					ComShowCodeMessage("CSQ00049", nMainList.substr(1));
				}
				ComOpenWait(false);
				break;	
			case IBDOWNEXCEL:		// 엑셀 다운로드
				ComOpenWait(true);
				sheetObj.MergeSheet=msNone;
//	 			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
	 			sheetObj.Down2Excel({ CheckBoxOffValue:" ", CheckBoxOnValue:"Y", HiddenColumn:1 });
				sheetObj.MergeSheet=msAll;
				ComOpenWait(false);
				break;
			case IBSAVE:          // 화면 저장시
				if (sheetObj.IsDataModified()== false) {
					ComShowCodeMessage("CSQ00006");
			        return false;
			    }
				if (ComShowConfirm (ComGetMsg("CSQ00004")) != 1) {
					return false;
			    }
				ComOpenWait(true);
				ComSetSearchParams("f_cmd", MULTI);
				var saveStr=sheetObj.GetSaveString(false, true, "ibflag");
				var sXml = sheetObj.GetSaveData("ESM_CSQ_0202GS.do", searchParams + "&" + saveStr);
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
			case MULTI01:		// Creation시에
				if (ComShowConfirm (ComGetMsg("CSQ00009")) != 1) {
					return false;
			    }
				ComOpenWait(true);
				ComSetSearchParams("f_cmd", MULTI01);
	 			var sXml=sheetObj.GetSaveData("ESM_CSQ_0202GS.do", searchParams);
				var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey");
				if (backendJobKey != null && backendJobKey.length > 0) {
					ComSetObjValue(formObj.backendjob_key, backendJobKey);
					sheetObj.SetWaitTimeOut(3600);//초 - 1시간
					backEndJobTimer=setInterval(getBackEndJobStatus, 5000);	//밀리초  - 10초
				}
				break;
			case IBLOADEXCEL:		// 엑셀 업로드
				loadExcelRowCnt=sheetObj.HeaderRows()+ sheetObj.GetTotalRows();
				loadExcelTotFlg=false;		// 화면에 Total Row 존재 여부
				loadExcelExField="|csq_act_flg|csq_mn_sctr_flg|sctr_ofc_cre_flg|";		// 비교 제외 필드
				loadExcelAplyField="|csq_act_flg|csq_mn_sctr_flg|";		// 반영 필드
				loadExcelsectorFlg="Y";
				loadExcelPageNumber=0202;
	        	ComOpenPopup("ESM_CSQ_1001.do?", 1050, 620, "", "0,0", true);
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
	 	var formObj=document.form;
		var f_bse_tp_cd  = ComGetObjValue(formObj.f_bse_tp_cd[0]);
		var f_bse_yr 	 = ComGetObjValue(formObj.f_bse_yr);
		var f_bse_qtr_cd = ComGetObjValue(formObj.f_bse_qtr_cd);
		var trd_cd 		 = ComGetObjValue(formObj.f_trd_cd);
		
	 	if(f_sub_trd_cd.GetSelectText()== "All" ){
	 		f_rlane_cd.RemoveAll();
	 	}else{
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
		 	f_rlane_cd.SetMultiSelect(1);
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
			//formObj.f_bse_qtr_cd.style.display="none";
			f_bse_qtr_cd.SetVisible(0);
		} else {
			div_qtr.style.display="inline";
			div_period.style.display="inline";
			//formObj.f_bse_qtr_cd.style.display="inline";
			f_bse_qtr_cd.SetVisible(1);
		}
		period_change();
		setSubTradeCombo();
	}
	/**
	* onBlur event
	* f_rlane_cd 바뀌었을때  f_pf_grp_cd 콤보조회
	*/	
	function f_rlane_cd_OnBlur(obj, value, text) {
	 	var formObj=document.form;
	 	var rlaneCd=f_rlane_cd.GetSelectCode();
	 	rlaneCd=rlaneCd.replace(/,/gi,"-");
	 	var param="f_cmd=" + SEARCH01
	     + "&code_name=pfGroupPair"
	     + "&code_param="+rlaneCd
	     + "&all_flag=";
	  	var xmlStr=sheetObjects[0].GetSearchData("CommonGS.do", param);
	 	ComXml2ComboItem(xmlStr, f_pf_grp_cd, "code", "name");
	 	f_pf_grp_cd.InsertItem(0, "All", "");
	 }
	/**
	 * 화면의 모든 버튼들의 Enable/Disable을 처리
	 */
	function toggleButtons(step) {
	   switch (step) {
		   case "INIT":
		       ComBtnEnable("btn_Retrieve");
		       ComBtnDisable("btn_Save");
		       ComBtnDisable("btn_Creation");
		       ComBtnDisable("btn_AddCreation");
		       ComBtnDisable("btn_Downexcel");
		       ComBtnDisable("btn_Loadexcel");
		       break;
		   case "SEARCH01": //조회 후 Cnt가 0 일때 
		       ComBtnEnable("btn_Retrieve");
		       ComBtnDisable("btn_Save");
		       ComBtnEnable("btn_Creation");
		       ComBtnDisable("btn_AddCreation");
		       ComBtnDisable("btn_Downexcel");
		       ComBtnDisable("btn_Loadexcel");
		       break;
		   case "SEARCH02": //조회 후 Cnt가 0이 아닐때 
		       ComBtnEnable("btn_Retrieve");
		       ComBtnEnable("btn_Save");
		       ComBtnDisable("btn_Creation");
		       ComBtnEnable("btn_AddCreation");
		       ComBtnEnable("btn_Downexcel");
		       ComBtnEnable("btn_Loadexcel");
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
	 	var sXml=sheetObj.GetSearchData("ESM_CSQ_0202GS.do", "f_cmd=" + SEARCH02 + "&backendjob_key=" + formObj.backendjob_key.value);
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
	
	function resizeSheet(){
	    ComResizeSheet(sheetObjects[0]);
	}
	
	function resizeSheet2(){
	    ComResizeSheet(sheetObjects[1]);
	}
	/* 개발자 작업  끝 */
