/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SCO_0050.js
*@FileTitle  : Ledger Code Combination 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
              MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
              OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class STM_SCO_0050 : business script for STM_SCO_0050
 */
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();        
	var comboCnt=0;
	var gCurRow=0;
	var now_select_sheet1=0 ;
	var max_lu_tp_cd=0 ;
	var searchYN="N";
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick() {
		/***** setting sheet object *****/
		var sheetObject1=sheetObjects[0];
		/*******************************************************/
		var formObj=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
				case "btn_retrieve":				
					doActionIBSheet(sheetObject1, formObj, IBSEARCH);
					break;
				case "btn_new":
					doActionIBSheet(sheetObject1, formObj, IBCLEAR);
					break;
				case "btn_DownExcel":
					if(sheetObject1.RowCount() < 1){//no data
	        	     	ComShowCodeMessage("COM132501");
	        	    } else{
	        	    	doActionIBSheet(sheetObject1,formObj,IBDOWNEXCEL);
	        	    }
		    		break;
				case "btn_save":
					doActionIBSheet(sheetObject1, formObj, IBSAVE);
					break;
				case "btn_RowAdd":
					if (searchYN == "N") {
						ComShowCodeMessage("SCO00005"); 
						break;
					}
					var row=sheetObject1.DataInsert(-1);
					sheetObject1.SetCellValue(row, "sgm_ctnt1",formObj.f_company.value);
					sheetObject1.SetCellValue(row, "sgm_ctnt2",formObj.f_region.value);
					sheetObject1.SetCellValue(row, "sgm_ctnt3",formObj.f_center.value);
					break;
				case "btn_RowDelete":
					rowRemove(sheetObject1);
					break;	
				case "btns_search_company":
	        		//Company
	        		var param="?lu_cd=" + formObj.f_company.value;
	        		ComOpenPopup("STM_SAP_0420.do" + param, 500, 420, "setCompany", "0,0", true, false);
	        		break;	
	    	    case "btns_search_region":
	        		//Region
	    	    	var param="?lu_cd=" + formObj.f_region.value;
	        		ComOpenPopup("STM_SAP_0430.do" + param, 400, 400, "setRegion", "0,0", true, false);            		
	        		break;		
	    	    case "btns_search_center":
	        		//Center
	        		var param="?f_center=" + formObj.f_center.value;
	        		ComOpenPopup("STM_SAP_0440.do" + param, 500, 400, "setCenter", "0,0", true, false);
	        		break;	
	    	    case "btns_search_account":
	        		//Account
	        		var param="?acct_cd=" + formObj.f_account.value;
	        		ComOpenPopup("STM_SCO_0090.do" + param, 500, 400, "setAccount", "0,0", true, false);
	        		break;	
	    	    case "btns_search_inter_company":
	        		//Inter Company
	        		var param="?f_intercom=" + formObj.f_inter_company.value;
	        		ComOpenPopup("STM_SAP_0460.do" + param, 500, 400, "setInterCompany", "0,0", true, false);
	        		break;	
	    	    case "btns_search_vvd":
	        		//VVD
	        		var param="?vvd_cd=" + formObj.f_vvd.value;
	        		ComOpenPopup("STM_SAP_0470.do" + param, 500, 400, "setVvd", "0,0", true, false);
	        		break;	
	        	/*	
				case "btns_search_region":
					ComOpenPopup("STM_SCO_0052.do", 400, 400, "setRegion", "0,0", true, false);
					break;
				case "btns_search_center":
					ComOpenPopup("STM_SCO_0053.do", 500, 400, "setCenter", "0,0", true, false);
					break;
				case "btns_search_account":
					ComOpenPopup("STM_SCO_0054.do", 500, 400, "setAccount", "0,0", true, false);
					break;
				case "btns_search_inter_company":
					ComOpenPopup("STM_SCO_0055.do", 500, 400, "setInterCompany", "0,0", true, false);
					break;
				case "btns_search_vvd":
					ComOpenPopup("STM_SCO_0056.do", 500, 400, "setVvd", "0,0", true, false);
					break;
				*/
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowCodeMessage('SAP00001');
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	/**
	 * registering IBSheet Object as list
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/** 
	 * registering IBCombo Object as list
	 * param : combo_obj
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */ 
	function setComboObject(combo_obj) {  
	    comboObjects[comboCnt++]=combo_obj;  
	}
	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
	function loadPage() {
		var formObj=document.form;
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
	    initControl();
	    doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);
	}
	/**
	 * loading HTML Control event <br>
	 * {@link #loadPage} function call this. so IBSheet Object is initialized. <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {int}     sheetNo     sequence number in sheetObjects array
	 **/
	function initControl() {
		DATE_SEPARATOR="-";
		var formObj=document.form;
		axon_event.addListenerFormat('beforedeactivate', 'obj_blur'    , formObj); 	//- handling code when OnBeforeDeactivate(blur) event
	// 	  axon_event.addListenerFormat('beforeactivate'  , 'obj_focus'   , formObj);  //- handling code when OnBeforeActivate event in case of existing dataformat property
	//    axon_event.addListenerFormat('keypress'        , 'obj_keypress', formObj); 	//- handling code when onkeypress event in case of existing dataformat property
	//    axon_event.addListenerFormat('keyup'           , 'form_keyup'  , formObj);
	//    axon_event.addListenerForm  ('change'          , 'obj_onchange', formObj);
	//    axon_event.addListenerForm  ('keypress'        , 'obj_keypress', formObj);
	}
	//handling Axon event 2
	function obj_blur(){
	}
	function obj_focus(){
	    ComClearSeparator(ComGetEvent());
	}
//	function obj_keypress(){
//	}
//	function form_keyup(){
//		//ComKeyEnter('lengthnextfocus');
//	}
	function obj_onclick(){
	}
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;	
		switch (sheetObj.id) {
		case "sheet1": //t1sheet1 init
		    with(sheetObj){
			      var HeadTitle1="|Del|Company|Region|Center|Account|Inter Company|VVD|Future1|Future2|Account Type|End Date|Enable|PK";
			      var headCount=ComCountHeadTitle(HeadTitle1);
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			             {Type:"CheckBox",  Hidden:0, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"del_chk" },
			             {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"sgm_ctnt1",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
			             {Type:"PopupEdit", Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sgm_ctnt2",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
			             {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"sgm_ctnt3",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
			             {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"sgm_ctnt4",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
			             {Type:"PopupEdit", Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"sgm_ctnt5",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
			             {Type:"PopupEdit", Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"sgm_ctnt6",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"sgm_ctnt7",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"sgm_ctnt8",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"legr_acct_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"coa_end_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"enbl_flg",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cd_cmb_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			      InitColumns(cols);
			      SetEditable(1);
			      SetColProperty("enbl_flg", {ComboText:"Y|N", ComboCode:"Y|N"} );
			      //SetSheetHeight(360);
			      resizeSheet();
	      		}
		    break;   
		}
	}
	// handling sheet process
	function doActionIBSheet(sheetObj, formObj, sAction) {
		switch (sAction) {	
		    case IBCLEAR:
		       formObj.f_company.value="01";
			   formObj.f_region.value="";
			   formObj.f_center.value="";
			   formObj.f_account.value="";
			   formObj.f_inter_company.value="";
			   formObj.f_vvd.value="";
			   sheetObj.RemoveAll();
			break;	
			case IBSEARCH: //retrieve
				if (!ComChkValid(formObj)) return false;
				if (!validateForm(sheetObj,formObj,sAction)) {	
					return false;
				}
				formObj.f_cmd.value=SEARCH;	
				ComOpenWait(true);			
				var sXml=sheetObj.GetSearchData("STM_SCO_0050GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				ComOpenWait(false);
				break;	
			case IBSAVE: //save
				if (!validateForm(sheetObj,formObj,sAction)) {	
					return false;
				}
				formObj.f_cmd.value=MULTI01;
				var sParam1=ComGetSaveString(sheetObjects[0], true, true);
				if(sParam1 == "" ){
					return;
				}
				var sParam=sParam1 + "&" +FormQueryString(formObj);
				ComOpenWait(true);
				var sXml=sheetObj.GetSaveData("STM_SCO_0050GS.do", sParam);
				sheetObj.LoadSaveData(sXml);
				ComOpenWait(false);
				var result=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
	            if(result != "F"){
	            	ComShowCodeMessage("COM130102", "Data"); 
	    			doActionIBSheet(sheetObj, document.form, IBSEARCH);
	            }  
				break;
			case IBDOWNEXCEL:	//엑셀다운로드
				sheetObj.Down2Excel();
				break;
		  }
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
			case IBSAVE: //SAVE
				if (sheetObj.IsDataModified()== true ) {
					//필수항목체크 
					var sParam=ComGetSaveString(sheetObjects[0], true, true);
					if(sParam == "" ){
						return false;
					}
		    		var dupRow=sheetObj.ColValueDup("sgm_ctnt1|sgm_ctnt2|sgm_ctnt3|sgm_ctnt4|sgm_ctnt5|sgm_ctnt6", false);
		            if(dupRow != -1) {
		            	ComShowCodeMessage("COM131302", "Data");
		            	sheetObj.Se
		            	sheetObj.SetSelectRow(dupRow);
		            	return false;
		            }
		            return true;
				}
				break;
		}
		return true;
	}
	/**
	 * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event<br>
	 * @param {sheetObj} String : 해당 IBSheet셀 명
	 * @param {Row} Long : 해당 셀의 Row Index
	 * @param {Col} Long : 해당 셀의 Column Index
	 * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
	 */	
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		if (Value == "") return;
		var sheetID=sheetObj.id;
		var formObj=document.form;
	    with (sheetObj) {
	        switch (ColSaveName(Col)) {
		        case  "sgm_ctnt1":    //Company
		        	var sXml=sheetObj.GetSearchData("STMCommonGS.do", "f_cmd=" + COMMAND01 + "&lu_tp_cd=GL COMPANY&lu_cd=" + Value );
		        	var result=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
		            if(result != "F"){
		            	if ( Value != ComGetEtcData(sXml, "one_lu_cd") ) {
		           			ComShowCodeMessage("COM132201", "Company" );  
		           			sheetObj.SetCellValue(Row,Col,"");
	     					sheetObj.SelectCell(Row,Col, true, "");
	     					break;		
		           		}
		            }  
		    		break;
		        case  "sgm_ctnt2":    //Region
		        	var sXml=sheetObj.GetSearchData("STMCommonGS.do", "f_cmd=" + COMMAND01 + "&lu_tp_cd=GL REGION&lu_cd=" + Value );
		        	var result=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
		            if(result != "F"){
		            	if ( Value != ComGetEtcData(sXml, "one_lu_cd") ) {
		           			ComShowCodeMessage("COM132201", "Region" ); 
		           			sheetObj.SetCellValue(Row,Col,"");
	     					sheetObj.SelectCell(Row,Col, true, "");
	     					break;		
		           		}
		            }  
		    		break;
		        case  "sgm_ctnt3":    //Center
		        	var sXml=sheetObj.GetSearchData("STM_SAP_0440GS.do", "f_cmd=" + SEARCH + "&f_center=" + Value );
		        	var result=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
		            if(result != "F"){
		            	if ( Value != ComGetEtcData(sXml, "ctr_erp_no") ) {
		           			ComShowCodeMessage("COM132201", "Center" ); 
		           			sheetObj.SetCellValue(Row,Col,"");
	     					sheetObj.SelectCell(Row,Col, true, "");
	     					break;		
		           		}
		            }  
		    		break;
		        case  "sgm_ctnt4":    //Account
		        	var sXml=sheetObj.GetSearchData("STM_SCO_0090GS.do", "f_cmd=" + SEARCH + "&acct_cd=" + Value);
		        	var result=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
		        	if(result != "F"){
		            	if ( Value != ComGetEtcData(sXml, "acct_cd") ) {
		           			ComShowCodeMessage("COM132201", "Account" ); 
		           			sheetObj.SetCellValue(Row,Col,"");
	     					sheetObj.SelectCell(Row,Col, true, "");
	     					break;		
		           		}
		            }  
		    		break;
		        case  "sgm_ctnt5":    //Inter Company
		        	var sXml=sheetObj.GetSearchData("STMCommonGS.do", "f_cmd=" + COMMAND01 + "&lu_tp_cd=GL INTER COMPANY&lu_cd=" + Value );
		        	var result=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
		            if(result != "F"){
		            	if ( Value != ComGetEtcData(sXml, "one_lu_cd") ) {
		           			ComShowCodeMessage("COM132201", "Inter Company" ); 
		           			sheetObj.SetCellValue(Row,Col,"");
	     					sheetObj.SelectCell(Row,Col, true, "");
	     					break;		
		           		}
		            }  
		    		break;
		        case  "sgm_ctnt6":    //VVD
		        	var sXml=sheetObj.GetSearchData("STM_SAP_0470GS.do", "f_cmd=" + SEARCH + "&vvd_cd=" + Value );
		        	var result=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
		            if(result != "F"){
		            	if ( Value != ComGetEtcData(sXml, "vvd_cd") ) {
		           			ComShowCodeMessage("COM132201", "VVD" );
		           			sheetObj.SetCellValue(Row,Col,"");
	     					sheetObj.SelectCell(Row,Col, true, "");
	     					break;		
		           		}
		            }  
		    		break;
	        }
	    }
	}	
	/**
	 * IBSeet내의 데이터 셀의 팝업 버튼이 눌러졌을 때 발생하는 Event<br>
	 * @param {sheetObj} String : 해당 IBSheet셀 명
	 * @param {Row} Long : 해당 셀의 Row Index
	 * @param {Col} Long : 해당 셀의 Column Index
	 */	
	function sheet1_OnPopupClick(sheetObj, Row, Col){
		var sheetID=sheetObj.id;
		var prefix=sheetID + "_";
		var param="";
		with (sheetObj) {
	        switch (ColSaveName(Col)) {
	            case  "sgm_ctnt1":    //Company
	            	var param="?lu_cd="+ encodeURIComponent(sheetObj.GetCellValue(Row, Col));
					ComOpenPopup("STM_SAP_0420.do" + param, 500, 400, "setPopupData", "0,0", true, false, Row, Col, 0);
	            	break;
	            case  "sgm_ctnt2":    //Region
	            	var param="?lu_cd="+ encodeURIComponent(sheetObj.GetCellValue(Row, Col));
					ComOpenPopup("STM_SAP_0430.do" + param, 400, 400, "setPopupData", "0,0", true, false, Row, Col, 0);
	            	break;
	            case  "sgm_ctnt3":    //Center
	            	var param="?f_center="+ encodeURIComponent(sheetObj.GetCellValue(Row, Col));
					ComOpenPopup("STM_SAP_0440.do" + param, 500, 400, "setPopupData", "0,0", true, false, Row, Col, 0);
	            	break;
	            case  "sgm_ctnt4":    //Account
	            	var param="?acct_cd="+ encodeURIComponent(sheetObj.GetCellValue(Row, Col));
	            	ComOpenPopup("STM_SCO_0090.do" + param, 500, 400, "setPopupData", "0,0", true, false, Row, Col, 0);
	            	break;
	            case  "sgm_ctnt5":    //Inter Company
	            	var param="?f_intercom="+ encodeURIComponent(sheetObj.GetCellValue(Row, Col));
					ComOpenPopup("STM_SAP_0460.do" + param, 500, 400, "setPopupData", "0,0", true, false, Row, Col, 0);
	            	break;
	            case  "sgm_ctnt6":    //VVD
	            	var param="?vvd_cd="+ encodeURIComponent(sheetObj.GetCellValue(Row, Col));
					ComOpenPopup("STM_SAP_0470.do" + param, 500, 400, "setPopupData", "0,0", true, false, Row, Col, 0);
	            	break;
	            case  "coa_end_dt": 
	            	var cal=new ComCalendarGrid("coa_end_dt");
	            	cal.endFunction="ComCalendar_EndFunction_coa_end_dt";
	    			cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');        			
	            	break;
	        }
	    }
	}
	/**
	 * After completing calendar input, execute function.<br>
	 */
	function ComCalendar_EndFunction_coa_end_dt(){
		with(sheetObjects[0]) {
			sheet1_OnChange(sheetObjects[0], GetSelectRow(), SaveNameCol("coa_end_dt"), GetCellValue(GetSelectRow(), "coa_end_dt"));
		}
	}
	/**
	 * setCompany 조회 후 값 Return 받아 셋팅한다.
	 */
	function setCompany(aryPopupData) {
		document.form.f_company.value=aryPopupData[0][1];
	}
	/**
	 * setRegion 조회 후 값 Return 받아 셋팅한다.
	 */
	function setRegion(aryPopupData) {
	    document.form.f_region.value=aryPopupData[0][1];
	}
	/**
	 * setCenter 조회 후 값 Return 받아 셋팅한다.
	 */
	function setCenter(aryPopupData) {
	    document.form.f_center.value=aryPopupData[0][1];
	}
	/**
	 * setAccount 조회 후 값 Return 받아 셋팅한다.
	 */
	function setAccount(aryPopupData) {
	    document.form.f_account.value=aryPopupData[0][1];
	}
	/**
	 * setInterCompany 조회 후 값 Return 받아 셋팅한다.
	 */
	function setInterCompany(aryPopupData) {
	    document.form.f_inter_company.value=aryPopupData[0][1];
	}
	/**
	 * setVvd 조회 후 값 Return 받아 셋팅한다.
	 */
	function setVvd(aryPopupData) {
	    document.form.f_vvd.value=aryPopupData[0][1];
	}
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		this.searchYN="Y";
		if(sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
		}
	}
	/**
	 * Pop-Up Return Value 처리 부분<br>
	 * @param aryPopupData : {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row : 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col : 대상Object가 IBSheet일 경우 해당 Col index
	 * @param ShtIdx : 대상IBSheet의 Sheet Array index
	 */
	function setPopupData(aryPopupData, Row, Col, ShtIdx) {
	    if (aryPopupData.length > 0 ) {
	        with (sheetObjects[ShtIdx]) {
	        	var sheetObj=sheetObjects[ShtIdx];
	            switch (ColSaveName(Col)) {
	                default:
	                    SetCellValue(Row, Col,aryPopupData[0][1]);
	                    break;
	            }
	        }
	    }
	}
	/**
	 * Removing IBSheet Row
	 **/
	function rowRemove(sheetObj){
		ComRowHideDelete(sheetObj, "del_chk");
	} 
	
	function resizeSheet(){
		ComResizeSheet(sheetObjects[0]);
	}