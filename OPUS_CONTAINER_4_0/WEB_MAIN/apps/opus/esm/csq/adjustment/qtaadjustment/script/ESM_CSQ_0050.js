/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0050.js
*@FileTitle  : QTA Adjustment by VVD
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
 * @class ESM_CSQ_0050 : ESM_CSQ_0050 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
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
				case "btn_Retrieve":
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
					break;
				case "btn_DownExcel":
					if(sheetObj.RowCount() < 1){//no data
			          ComShowCodeMessage("COM132501");
			        } else {
			        	doActionIBSheet(sheetObj, formObj, IBDOWNEXCEL);
			        }
					break;
				case "btn_Creation":
					doActionIBSheet(sheetObj, formObj, IBCREATE);
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
		setTradeCombo();
		loadingMode=false;
		resizeSheet();
	}
	
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetNo) {
			case 1:		//sheet1 init
			    with(sheetObj){
		        var HeadTitle="Trade|Sub Trade|Lane|Lane\nBound|Ver|IOC|Flg|STS|Currently Updated|Currently Updated|Currently Updated|Currently Updated|Currently Updated|Currently Updated|Need to be Updated|Need to be Updated|Need to be Updated|Need to be Updated|Need to be Updated|Need to be Updated|Update Option|Update Option|Update Option";
		        var HeadTitle2="Trade|Sub Trade|Lane|Lane\nBound|Ver|IOC|Flg|STS|Month|Week|VVD|Supply|Load|G.REV|Month|Week|VVD|Supply|Load|G.REV|Portion\nConnected|COPY VVD|Adjusting VVD\nSelect";
		        SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0, PrevColumnMergeMode:0  } );
		        var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
		        var headers = [ { Text:HeadTitle, Align:"Center"},
		                        { Text:HeadTitle2, Align:"Center"} ];
		        InitHeaders(headers, info);
		        var cols = [ {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"qta_rlse_ver_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ioc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"flag",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bse_mon",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bse_wk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vvd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Int",       Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"fnl_bsa_capa",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"lod_qty",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Int",       Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"grs_rev",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"coa_bse_mon",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"coa_bse_wk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"coa_vvd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Int",       Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"coa_fnl_bsa_capa",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"coa_lod_qty",       KeyField:1,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
				             {Type:"Int",       Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"coa_grs_rev",       KeyField:1,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:12 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"potn_lnk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"copy_vvd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"CheckBox",  Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"adj_chk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		        InitColumns(cols);
		        SetEditable(1);
		        SetRangeBackColor(1, 4, 1, 25, "#555555");
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
				var sXml=sheetObj.GetSearchData("ESM_CSQ_0050GS.do", FormQueryString(formObj));
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
					ComXml2ComboItem(arrXml[4], f_portion_link, "code", "name");
				formObj.f_crnt_bse_yr.value=f_bse_yr.GetSelectCode();
				formObj.f_crnt_qta_cd.value=f_bse_qtr_cd.GetSelectCode();
				ComOpenWait(false);
				break;
			case IBSEARCH:          // 화면 조회 시
				formObj.f_cmd.value=SEARCH;
				formObj.f_fm_wk.value=qtaWeekArr[ComGetObjValue(f_bse_qtr_cd)][0].substring(3,5);
				formObj.f_to_wk.value=qtaWeekArr[ComGetObjValue(f_bse_qtr_cd)][1].substring(3,5);
				searchParams=FormQueryString(formObj);
				
				sheetObj.SetWaitImageVisible(1);
				sheetObj.DoSearch("ESM_CSQ_0050GS2.do", searchParams);
				break;
			case IBCREATE:          // 생성
				if (sheetObj.IsDataModified()== false) {
					ComShowCodeMessage("CSQ00006"); //"There is no data to save.";
					return false;
				}
				if (ComShowConfirm (ComGetMsg("CSQ00009")) != 1) { //"Do you want to create data?"
					return false;
			    }
				var saveStr=sheetObj.GetSaveString(false, true, "ibflag");
				if ( saveStr == "" ) {
					return;
				}
				ComOpenWait(true);
				ComSetSearchParams("f_cmd", MULTI);
				var sXml = sheetObj.GetSaveData("ESM_CSQ_0050GS.do", searchParams + "&" + saveStr);
				var State=ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
				if ( State == "S" ) {
					ComShowCodeMessage("CSQ00010", "Data");
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
				} else if ( State != "S" ){
					ComShowMessage(ComResultMessage(sXml));
					return false;
				}
				ComOpenWait(false);
				break;
			case IBDOWNEXCEL:		// 엑셀 다운로드
				ComOpenWait(true);
				sheetObj.MergeSheet=msNone;
				sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
				sheetObj.MergeSheet=msHeaderOnly;
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
		sheetObj.SetWaitImageVisible(0);
		var formObj=document.form;
		var bse_yr=ComGetObjValue(f_bse_yr);
		var bse_qtr_cd=ComGetObjValue(f_bse_qtr_cd);
		var trd_cd="";
		var sub_trd_cd="";
		var dir_cd="";
		var rlane_cd="";
		var param="";
		var sXml="";
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
			case "coa_lod_qty":
			case "coa_grs_rev":
				var c_lod_qty=sheetObj.GetCellValue(row, "coa_lod_qty");
				var c_grs_rev=sheetObj.GetCellValue(row, "coa_grs_rev");
				var c_fnl_bsa_capa=sheetObj.GetCellValue(row, "coa_fnl_bsa_capa");
				var s_flag=sheetObj.CellSearchValue(row, "flag");
				var s_lod_qty=sheetObj.CellSearchValue(row, "coa_lod_qty");
				var s_grs_rev=sheetObj.CellSearchValue(row, "coa_grs_rev");
				var lod_qty=sheetObj.GetCellValue(row, "lod_qty");
				var grs_rev=sheetObj.GetCellValue(row, "grs_rev");
				// WEEK, MON, BSA 가 변경되었을 경우만 수행
				if ( s_flag == "W" || s_flag == "M"  ) {
					if ( c_lod_qty == s_lod_qty && c_grs_rev == s_grs_rev ) {
						sheetObj.SetCellValue(row, "flag",sheetObj.CellSearchValue(row, "flag"),0);
						sheetObj.SetCellValue(row, "ibflag","U",0);
					} else {
						sheetObj.SetCellValue(row, "flag","C",0);
					}
				} else if ( s_flag == "B" ){
					if (c_fnl_bsa_capa != "0" ) {
						if ( c_lod_qty == lod_qty && c_grs_rev == grs_rev ) {
							sheetObj.SetCellValue(row, "flag","R",0);
						} else {
							sheetObj.SetCellValue(row, "flag",s_flag ,0);
						}
					}
				} else {
					if (sheetObj.GetCellValue(row, "adj_chk") == 1 ) {
						if ( lod_qty == c_lod_qty && grs_rev == c_grs_rev) {
							sheetObj.SetCellValue(row, "flag","R",0);
							sheetObj.SetCellValue(row, "ibflag","R",0);
						} else {
							sheetObj.SetCellValue(row, "flag","C",0);
							sheetObj.SetCellValue(row, "ibflag","U",0);
						}
					}
				}
				break;
			case "copy_vvd":
				// Copy VVD 가 선택 가능하다는건 Data 가 I 일 경우
				if ( sheetObj.GetCellValue(row, "coa_fnl_bsa_capa") == "0") {
					sheetObj.SetCellValue(row, "coa_lod_qty",0);
					sheetObj.SetCellValue(row, "coa_grs_rev",0);
				} else {
					if ( ComTrim(value) == "" ) {
						sheetObj.SetCellEditable(row, "coa_lod_qty",1);
						sheetObj.SetCellEditable(row, "coa_grs_rev",1);
						sheetObj.SetCellValue(row, "coa_lod_qty","");
						sheetObj.SetCellValue(row, "coa_grs_rev","");
					} else {
						sheetObj.SetCellValue(row, "coa_lod_qty",0);
						sheetObj.SetCellValue(row, "coa_grs_rev",0);
						sheetObj.SetCellEditable(row, "coa_lod_qty",0);
						sheetObj.SetCellEditable(row, "coa_grs_rev",0);
					}
				}
				break;

			case "adj_chk": //Adjustment VVD Select 가 변경되면
				var s_flag=sheetObj.CellSearchValue(row, "flag");
				if ( value == 1 ) { //선택되면 BSA=0 인것을제외하고 Current 정보를 옮겨준다
					if ( s_flag == "R" ){
						sheetObj.SetCellValue(row, "coa_bse_mon",sheetObj.CellSearchValue(row, "bse_mon"));
						sheetObj.SetCellValue(row, "coa_bse_wk",sheetObj.CellSearchValue(row, "bse_wk"));
						sheetObj.SetCellValue(row, "coa_vvd",sheetObj.CellSearchValue(row, "vvd"));
						sheetObj.SetCellValue(row, "coa_fnl_bsa_capa",sheetObj.CellSearchValue(row, "fnl_bsa_capa"));
						sheetObj.SetCellValue(row, "coa_lod_qty",sheetObj.CellSearchValue(row, "lod_qty"));
						sheetObj.SetCellValue(row, "coa_grs_rev",sheetObj.CellSearchValue(row, "grs_rev"));
					}
					sheetObj.SetCellEditable(row, "coa_lod_qty",1);
					sheetObj.SetCellEditable(row, "coa_grs_rev",1);
				} else {
					if ( s_flag == "R" ){
						sheetObj.SetCellValue(row, "coa_bse_mon","");
						sheetObj.SetCellValue(row, "coa_bse_wk","");
						sheetObj.SetCellValue(row, "coa_vvd","");
						sheetObj.SetCellValue(row, "coa_fnl_bsa_capa","");
						sheetObj.SetCellValue(row, "coa_lod_qty","");
						sheetObj.SetCellValue(row, "coa_grs_rev","");
					}
					sheetObj.SetCellEditable(row, "coa_lod_qty",0);
					sheetObj.SetCellEditable(row, "coa_grs_rev",0);
					sheetObj.SetCellValue(row, "flag",s_flag,0);
					sheetObj.SetCellValue(row, "ibflag","R",0);
				}
				break;
		}
	}
	/**
	 * f_bse_yr가 바뀌었을때 Lane 재조회
	 */
	function f_bse_yr_OnChange(obj, value, text) {
		period_change();
		setTradeCombo();
	}
	/**
	 * f_bse_qtr_cd 바뀌었을때 Lane 재조회
	 */
	function f_bse_qtr_cd_OnChange(obj, value, text) {
		period_change();
		setTradeCombo();
	}
	/**
	 * f_trd_cd 바뀌었을때 f_lane_cd 콤보조회
	 */
	function f_trd_cd_OnChange(obj, value, text) {
		setLaneCombo();
	}
	/**
	 * f_bse_yr, f_bse_qtr_cd  바뀌었을때 f_trd_cd 콤보조회
	 */
	function setTradeCombo() {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		var param="";
		var f_bse_tp_cd  = "Q";
		var f_bse_yr 	 = ComGetObjValue(formObj.f_bse_yr);
		var f_bse_qtr_cd = ComGetObjValue(formObj.f_bse_qtr_cd);
	    var trd_cd		 = ComGetObjValue(f_trd_cd);

	 	param="f_cmd=" + SEARCH01
	     + "&code_name=trade"
	     + "&code_param=" + f_bse_tp_cd + "|" + f_bse_yr + "|" + f_bse_qtr_cd
	     + "&all_flag=";	// Trade
	 	var sXml=sheetObj.GetSearchData("CommonGS.do",param);
		ComXml2ComboItem(sXml, f_trd_cd, "code", "name");
		// 변경된 Combo box에서 이전선택된 코드의 Index를 구해서 세팅한다.
		var rlane_index=SearchIndex(f_trd_cd, trd_cd);
		f_trd_cd.SetSelectIndex(rlane_index);
	}
	/**
	 * Trade에 따른 RLane 정보를 보여줌
	 * @returns
	 */
	function setLaneCombo() {
	 	var formObj=document.form;
	 	var trd_cd		 = ComGetObjValue(f_trd_cd);
	 	var rlane_cd	 = ComGetObjValue(f_rlane_cd);
		var f_bse_tp_cd  = "Q";
		var f_bse_yr 	 = ComGetObjValue(formObj.f_bse_yr);
		var f_bse_qtr_cd = ComGetObjValue(formObj.f_bse_qtr_cd);
		if (trd_cd != "All" && trd_cd != "" ) {	
		 	var param="f_cmd=" + SEARCH01
		     + "&code_name=rLane"
		     + "&code_param="+trd_cd+"|"
		     				+f_bse_tp_cd+"|"
		     				+f_bse_yr+"|"
		     				+f_bse_qtr_cd
		     + "&all_flag=All";
		 	var xmlStr=sheetObjects[0].GetSearchData("CommonGS.do", param);
		 	ComXml2ComboItem(xmlStr, f_rlane_cd, "code", "name");
		 // 변경된 Combo box에서 이전선택된 코드의 Index를 구해서 세팅한다.
		 	var rlane_index=SearchIndex(f_rlane_cd, rlane_cd);
			f_rlane_cd.SetSelectIndex(rlane_index);
		} else {
			f_rlane_cd.RemoveAll();
			f_rlane_cd.InsertItem(0, "All", "All");
			f_rlane_cd.SetSelectIndex(0);
		}
	 }
	
	function resizeSheet(){
	    for (i=0; i<sheetObjects.length; i++){
	        ComResizeSheet(sheetObjects[i]);
	    }
	}
	
	/* 개발자 작업  끝 */
