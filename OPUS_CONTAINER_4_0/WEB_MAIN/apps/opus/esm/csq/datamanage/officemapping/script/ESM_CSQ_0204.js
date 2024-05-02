/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0204.js
*@FileTitle  : Sector-Office Relation Setting for IAS Sector
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
	 * @class ESM_CSQ_0204 : ESM_CSQ_0204 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
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
					ComOpenPopup("ESM_CSQ_0205.do?"+searchParams, 890, 450, "callbackPopup", "0,0", true);
					break;
				case "btn_PairAdd":
					ComOpenPopup("ESM_CSQ_0206.do?"+searchParams, 890, 450, "callbackPopup", "0,0", true);
					break;	
				case "btn_Downexcel":
					if(sheetObject.RowCount() < 1) {
						 ComShowCodeMessage("COM132501");
					} else{
						doActionIBSheet(sheetObject, formObj, IBDOWNEXCEL);
					}
					break;
				case "btn_Loadexcel":
					if(sheetObject.RowCount() < 1) {
						 ComShowCodeMessage("COM132501");
					} else{
						doActionIBSheet(sheetObject, formObj, IBLOADEXCEL);
					}
					
					break;
				case "btn_RawDataDownExcel":
					if(sheetObject.RowCount() < 1) {
						 ComShowCodeMessage("COM132501");
					} else{
						doActionIBSheet(sheetObject, formObj, "RawDataDownExcel");
					}
					break;	
	            case "btn_close":
	            	window.close();
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
		// 팝업에서 받은 리턴값이 S일때 그리드를 다시 조회한다.
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
			tabObjects[k].SetSelectedIndex(0);
		}
		doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);
		for(k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],comboObjects[k].id);
		}
		toggleButtons("INIT");
		//팝업으로 열렸을때 부모창 조건 세팅
	    if(formObj.popMode.value == "Y"){
	    	ComSetObjValue(f_bse_yr, formObj.p_bse_yr.value);
	    	ComSetObjValue(f_bse_qtr_cd, formObj.p_bse_qtr_cd.value);
	    	ComSetObjValue(f_ofc_vw_cd, formObj.p_ofc_vw_cd.value);
			ComSetObjValue(f_sub_trd_cd, formObj.p_sub_trd_cd.value);
			ComSetObjValue(f_dir_cd, formObj.p_dir_cd.value);
			ComSetObjValue(f_rlane_cd, formObj.p_rlane_cd.value);
		}
		loadingMode=false;
		resizeSheet();
	}
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetNo) {
			case 1:		//sheet1 init
			    with(sheetObj){
			        var HeadTitle1="STS|SEQ|Year|Quarter|Office View|Trade|Sub Trade|R.Lane|Lane Bound|RHQ|Office|POL|POD|Active|Main|";
			        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			        var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
			        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			        InitHeaders(headers, info);
			      	var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bse_yr",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bse_qtr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ofc_vw_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rhq_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rgn_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"CheckBox",  Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"csq_act_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"CheckBox",  Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"csq_mn_sctr_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
			      	InitColumns(cols);
			      	SetEditable(1);
			      	SetSheetHeight(400);
		            }
				break;
			case 2:		//sheet2 init
			    with(sheetObj){
			        var HeadTitle1="STS|SEQ|Year|Quarter|Office View|Trade|Sub Trade|R.Lane|Lane Bound|P/F SKD\nGroup|RHQ|Office|POL|POD|Active|Main";
			        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			        var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
			        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			        InitHeaders(headers, info);
			        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bse_yr",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bse_qtr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ofc_vw_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"pf_grp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rhq_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rgn_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"CheckBox",  Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"csq_act_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"csq_mn_sctr_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
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
			case "f_pf_grp_cd":
				with (comboObj) {
					SetTitleVisible(1);
					SetTitle("R/Lane|Group"); 
					SetColAlign(0, "center");
					SetColAlign(1, "center");
					SetColWidth(0, "100");
					SetColWidth(1, "100");
				}
				break;		
			case "f_rlane_cd":
				with (comboObj) {
					SetDropHeight(300);
					InsertItem(0, '', '');
					SetSelectIndex(0);
				}	
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
		tabObjects[0].SetSelectedIndex(0);
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
	 			var sXml=sheetObj.GetSearchData("ESM_CSQ_0204GS.do", FormQueryString(formObj));
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
				if (arrXml.length > 4)
					ComXml2ComboItem(arrXml[4], f_ofc_vw_cd, "code", "name");
				if (arrXml.length > 5)
					ComXml2ComboItem(arrXml[5], f_rhq_cd, "code", "name");
				ComOpenWait(false);
				break;
			case IBSEARCH:          // 화면 조회 시
				if (!validateForm(sheetObj, formObj, sAction))
					return;
				formObj.f_cmd.value=SEARCH;
				searchParams=FormQueryString(formObj);
				ComOpenWait(true);
				var rtnXml=sheetObj.GetSearchData("ESM_CSQ_0204GS.do",searchParams, {Sync:2});
				var arrXml=rtnXml.split("|$$|");
				sheetObj.LoadSearchData(arrXml[0],{Sync:1} );
				sheetObj1.LoadSearchData(arrXml[1],{Sync:1} );
				var etcData=getEtcData(arrXml[0]);
				formObj.dataCnt.value=etcData["dataCnt"];
				if (formObj.dataCnt.value == 0) {
					toggleButtons("SEARCH01");
				} else {
					toggleButtons("SEARCH02");
				}
				ComOpenWait(false);
				break;
			case IBDOWNEXCEL:		// 엑셀 다운로드
				ComOpenWait(true);
				sheetObj.Down2Excel({ CheckBoxOffValue:" ", CheckBoxOnValue:"Y", HiddenColumn:1 });
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
				var sXml = sheetObj.GetSaveData("ESM_CSQ_0204GS.do", searchParams + "&" + saveStr);
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
				if (!validateForm(sheetObj, formObj, sAction)) return;
				if (ComShowConfirm (ComGetMsg("CSQ00009")) != 1) {
					return false;
			    }
				ComOpenWait(true);
				ComSetSearchParams("f_cmd", MULTI01);
	 			var sXml=sheetObj.GetSaveData("ESM_CSQ_0204GS.do", searchParams);
				var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey");
				if (backendJobKey != null && backendJobKey.length > 0) {
					ComSetObjValue(formObj.backendjob_key, backendJobKey);
					sheetObj.SetWaitTimeOut(3600);//초 - 1시간
					backEndJobTimer=setInterval(getBackEndJobStatus, 5000);	//밀리초  - 10초
				}
				break;
			case IBSEARCH_ASYNC01:
				ComSetSearchParams("f_cmd", SEARCH02);
	 			var sXml=sheetObj.GetSearchData("ESM_CSQ_0204GS.do",searchParams);
				return sXml;
				break;
			case IBLOADEXCEL:		// 엑셀 업로드
				loadExcelRowCnt=sheetObj.HeaderRows()+ sheetObj.GetTotalRows();
				loadExcelTotFlg=false;		// 화면에 Total Row 존재 여부
				loadExcelExField="|csq_act_flg|";		// 비교 제외 필드
				loadExcelAplyField="|csq_act_flg|";		// 반영 필드
				loadExcelsectorFlg="Y";
				loadExcelPageNumber=0204;
	        	ComOpenPopup("ESM_CSQ_1001.do?", 1050, 620, "", "0,0", true);
	        	
				break;
			case "RawDataDownExcel":		// Raw Data 엑셀 다운로드
				ComOpenWait(true);
	           //Year, Quarter, Office view user 선택. office level은 항상 office. week, vvd, pol-pod pair check.
				var param="f_cmd="         + COMMAND01
				          + "&f_bse_tp_cd="  + ComGetObjValue(formObj.f_bse_tp_cd)
				          + "&f_bse_yr="     + ComGetObjValue(f_bse_yr)
				          + "&f_bse_qtr_cd=" + ComGetObjValue(f_bse_qtr_cd)
				          + "&f_ofc_vw_cd="  + ComGetObjValue(f_ofc_vw_cd)
						  + "&f_gubun=Y";
				document.location.href="ESM_CSQ_0204DL.do?" + param;
				ComOpenWait(false);
				break;	
	  }
	}
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction){
		switch(sAction) {
			case MULTI01:  // Creation
				var arrXml=doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
				var nActList=ComGetEtcData(arrXml, "nActList");
				if(nActList != null && nActList != ""){
					ComShowCodeMessage("CSQ00047", nActList.substr(1));
					return false;
				}
				break;
			case IBSEARCH: 
				if(f_sub_trd_cd.GetSelectCode()== ""){
					ComShowCodeMessage('CSQ00013','Sub Trade');
					return false;
				}
				break;
				if(f_rlane_cd.GetSelectCode()== ""){
					ComShowCodeMessage('CSQ00013','R/Lane');
					return false;
				}
				break;
		}
		return true;
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
		     + "&all_flag=";
	        var xmlStr=sheetObjects[0].GetSearchData("CommonGS.do", param);
		 	ComXml2ComboItem(xmlStr, f_sub_trd_cd, "code", "name");
		 	f_sub_trd_cd.SetSelectIndex(0);
	 	} else {
	 		f_sub_trd_cd.RemoveAll();
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
	 * f_rlane_cd 바뀌었을때 POL, POD 변경
	 */
	function f_rlane_cd_OnChange(obj, value, text) {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		//POL
		var param1="f_cmd=" + SEARCH02
	    + "&code_name=polCdSectorOfc"
	    + "&code_param=" 
	    + "&all_flag=All"
	    + "&" + FormQueryString(formObj);	// R/Lane
	 	var xmlStr1=sheetObjects[0].GetSearchData("CommonGS.do", param1);
		ComXml2ComboItem(xmlStr1, f_pol_cd, "code", "name");
		f_pol_cd.SetSelectIndex(0);
		//POD
		var param2="f_cmd=" + SEARCH02
	    + "&code_name=podCdSectorOfc"
	    + "&code_param=" 
	    + "&all_flag=All"
	    + "&" + FormQueryString(formObj);	// R/Lane
	 	var xmlStr2=sheetObjects[0].GetSearchData("CommonGS.do", param2);
		ComXml2ComboItem(xmlStr2, f_pod_cd, "code", "name");
		f_pod_cd.SetSelectIndex(0);
		//P/F Group 
	 	var rlaneCd=f_rlane_cd.GetSelectCode();
	 	var param="f_cmd=" + SEARCH01
	     + "&code_name=pfGroupOfc"
	     + "&code_param="+rlaneCd
	     + "&all_flag=";
	  	var xmlStr=sheetObjects[0].GetSearchData("CommonGS.do", param);
	 	ComXml2ComboItem(xmlStr, f_pf_grp_cd, "code", "name");
	 	f_pf_grp_cd.InsertItem(0, "All", "");
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
			//f_bse_qtr_cd.style.display="none";
			f_bse_qtr_cd.SetVisible(0);
		} else {
			div_qtr.style.display="inline";
			div_period.style.display="inline";
			//f_bse_qtr_cd.style.display="inline";
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
	 * 화면의 모든 버튼들의 Enable/Disable을 처리
	 */
	function toggleButtons(step) {
	   switch (step) {
		   case "INIT":
		       ComBtnEnable("btn_Retrieve");
		       ComBtnDisable("btn_Save");
		       ComBtnDisable("btn_Creation");
		       ComBtnDisable("btn_AddCreation");
		       ComBtnDisable("btn_PairAdd");
		       ComBtnDisable("btn_Downexcel");
		       ComBtnDisable("btn_Loadexcel");
		       ComBtnDisable("btn_RawDataDownExcel");
		       break;
		   case "SEARCH01": // dataCnt 가 0일 때
		       ComBtnEnable("btn_Retrieve");
		       ComBtnDisable("btn_Save");
		       ComBtnEnable("btn_Creation");
		       ComBtnDisable("btn_AddCreation");
		       ComBtnDisable("btn_PairAdd");
		       ComBtnDisable("btn_Downexcel");
		       ComBtnDisable("btn_Loadexcel");
		       ComBtnDisable("btn_RawDataDownExcel");
		       break;
		   case "SEARCH02": // dataCnt 가 0이 아닐 때
		       ComBtnEnable("btn_Retrieve");
		       ComBtnEnable("btn_Save");
		       ComBtnDisable("btn_Creation");
		       ComBtnEnable("btn_AddCreation");
		       ComBtnEnable("btn_PairAdd");
		       ComBtnEnable("btn_Downexcel");
		       ComBtnEnable("btn_Loadexcel");
		       ComBtnEnable("btn_RawDataDownExcel");
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
	 	var sXml=sheetObj.GetSearchData("ESM_CSQ_0204GS.do", "f_cmd=" + SEARCH01 + "&backendjob_key=" + formObj.backendjob_key.value);
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
	/* 개발자 작업  끝 *
	 */
