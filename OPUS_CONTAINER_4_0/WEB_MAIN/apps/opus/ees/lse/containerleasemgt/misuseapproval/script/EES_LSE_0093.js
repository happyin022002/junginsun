/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0093.js
*@FileTitle  : Mis Use In & Out Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/16

=========================================================*/
/****************************************************************************************
    Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class EES_LSE_0093 : business script for EES_LSE_0093
     */

   	/* developer job */
	// common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	//Event handler processing by button click event */
	document.onclick=processButtonClick;
	//Event handler processing by button name */
    function processButtonClick(){
         /**********/
         var sheetObject1=sheetObjects[0];
         /*******************************************************/
         var formObj=document.form;
    	try {
    		var srcObj=ComGetEvent();
    		var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,formObj,IBSEARCH);
					break;
				case "btn_New":
					ComResetAll();
		    		ComSetFocus(formObj.rqst_ofc_cd);
					break;
				case "btn_downExcel":
					if(sheetObject1.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
						}else{
							sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
						}
					
					break;
				case "btns_search":		//Office Code
 					openPopup("1");
 					break;
 				case "btns_calendar":		// Request Duration (FromTo)
					if ( srcObj.style.filter == "" ) {
						var cal=new ComCalendarFromTo();
						cal.select(formObj.str_rqst_dt, formObj.end_rqst_dt, 'yyyy-MM-dd');
					}
					break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
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
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
		var formObj=document.form;
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        /* Axon Control Setting*/
    	initControl();
		/* Focus Setting */
		ComSetFocus(formObj.rqst_ofc_cd);
    }
	/** registering initial event */
  	function initControl() {
  		var formObj=document.form;
  		axon_event.addListenerFormat('blur',		'obj_blur',		formObj); 
//		axon_event.addListenerFormat('focus',		'obj_focus',	formObj); 
//  		axon_event.addListenerFormat('keypress',	'obj_keypress',	formObj); 
//		axon_event.addListenerFormat('keyup',		'obj_keyup',	formObj); 
//		axon_event.addListenerForm('keydown',		'obj_keydown',	formObj); 
		axon_event.addListenerFormat('change',  	'obj_change',  	formObj); 
  	}
	//setting event Duplicate
	var preEventType=null;
  	/**
	 * handling Location blur event
	 **/
	function obj_blur() {
		var obj=ComGetEvent();
		if(preEventType == event.type) {
			//preEventType = null;
			//return;
		}
	    switch(ComGetEvent("name")) {
	    	default:
	            /* checking Validation */
	            ComChkObjValid(obj);
	        	break;
	    }
	    preEventType=event.type;
	}

	/**
	 * handling event in case of Change
	 */
	function obj_change() {
		var obj=event.srcElement;
		var formObj=document.form;
  		switch(ComGetEvent("name")) {
  			case "rqst_ofc_cd":			//Office Code
  				if ( ComTrim(obj.value) != "" ) {
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC01);
  				}
				break;
  			case "str_rqst_dt":
    		case "end_rqst_dt":
    			checkDurationDate(obj);
	    		break;
		}
	}
  	/**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with (sheetObj) {

	                var HeadTitle1="Seq.|Case|Status|Request No.|Approval No.|CNTR No.|TP/SZ|Lease\nTerm|APP AGMT No.|MU Date|MU By / From|MU Place|Return SCC|Return SCC|Return SCC|Return SCC|Per Diem|Handle On\nCharge|Liable Party|Request Reason|Request File Attachment||APP/REJ Reason|APP/REJ File Attachment||Cancel Reason|Cancel File Attachment|";
	                var headCount=ComCountHeadTitle(HeadTitle1);
	                (headCount, 5, 0, true);
	
	                SetConfig( { SearchMode:2, FrozenCol: 5, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq_no" },
	                       {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"mss_rqst_io_mod_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"mss_usd_apro_mod_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"rqst_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"apro_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"apro_agmt_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"mss_usd_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:240,  Align:"Left",    ColMerge:1,   SaveName:"mss_usd_fm_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"mss_use_plc_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n1st_ref_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n2nd_ref_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n3rd_ref_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n4th_ref_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"pd_chg_rt_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"lft_chg_rt_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:240,  Align:"Left",    ColMerge:1,   SaveName:"libor_pty_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"rqst_rsn_desc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:270,  Align:"Left",    ColMerge:0,   SaveName:"rqst_file_sav_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:1, Width:200,  Align:"Left",    ColMerge:0,   SaveName:"rqst_file_sav_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"apro_rsn_desc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:270,  Align:"Left",    ColMerge:0,   SaveName:"apro_file_sav_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:1, Width:200,  Align:"Left",    ColMerge:0,   SaveName:"apro_file_sav_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"cxl_rsn_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Popup",     Hidden:0, Width:200,  Align:"Left",    ColMerge:0,   SaveName:"cxl_file_sav_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:1, Width:200,  Align:"Left",    ColMerge:0,   SaveName:"cxl_file_sav_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	                 
	                InitColumns(cols);
	
	                SetEditable(0);
	                SetColProperty("mss_rqst_io_mod_cd", {ComboText:"MUI|MUO", ComboCode:"I|O"} );
	                SetCountFormat("[SELECTDATAROW / TOTALROWS]");
	                //SetSheetHeight(368);
	                ComResizeSheet(sheetObj);
				}
                break;
        }
    }
  	/**
	 * handling process for Sheet
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @param CondParam
	 * @param PageNo
	 */
    function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH:
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet1") {
						formObj.f_cmd.value=SEARCH;
						sheetObj.SetWaitImageVisible(0);
						ComOpenWait(true);
						sheetObj.DoSearch("EES_LSE_0093GS.do",FormQueryString(formObj) );
						
					}
				}
				break;
			case IBSEARCH_ASYNC01:	// checking Office Code validation
				if(validateForm(sheetObj,formObj,sAction)) {
		        	var param="f_cmd="+SEARCH16+"&ofc_cd="+ComGetObjValue(formObj.rqst_ofc_cd);
					sheetObj.SetWaitImageVisible(0);
					var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",param);
					sheetObj.SetWaitImageVisible(1);
					if ( sXml != "" ) {
						if ( ComGetEtcData(sXml, "ofc_cd") != undefined ) {
							if ( ComGetEtcData(sXml, "ofc_cd") != "" ) {
								formObj.rqst_ofc_cd.value=ComGetEtcData(sXml, "ofc_cd") ;
								ComSetNextFocus(formObj.rqst_ofc_cd);
							}else{
								ComShowCodeMessage("LSE01035");
								formObj.rqst_ofc_cd.value="";
								ComSetFocus(formObj.rqst_ofc_cd);
							}
						} else {
							var errMsg=LseComGetErrMsg(sXml);
							if ( errMsg != "" ) {
								ComShowMessage(errMsg);
							}
							formObj.rqst_ofc_cd.value="";
							ComSetFocus(formObj.rqst_ofc_cd);
						}
					}
				}
	        	break;
        }
    }
	/**
	 * handling event in case of Scroll-Next sheet<br>
	 * @param sheetObj
	 * @param CondParam
	 * @param PageNo
	 * @param OnePageRows
	 */
//method change[check again]CLT 	function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
		//doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, CondParam, PageNo);
//	}
	/**
     * calling event after retrieving Sheet
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	ComOpenWait(false);
    	with(sheetObj) {
    		SetColFontColor("rqst_file_sav_nm","#0000FF");
    		SetColFontColor("apro_file_sav_nm","#0000FF");
    		SetColFontColor("cxl_file_sav_nm","#0000FF");
    	}
    }
    /**
	 * handling event in case of Mouse-Move sheet
	 */
	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
		with(sheetObj) {
			var linkFlag=GetCellValue(MouseRow(), MouseCol()) != "";
			SetDataLinkMouse("rqst_file_sav_nm",linkFlag);
			SetDataLinkMouse("apro_file_sav_nm",linkFlag);
			SetDataLinkMouse("cxl_file_sav_nm",linkFlag);
		}
	}
	/**
	 * handling event in case of click sheet
	 */
	function sheet1_OnClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
		var formObj=document.form;
		var sName=sheetObj.ColSaveName(Col);
//		if(sheetObj.GetMousePointer!= "Hand") return;
		with(sheetObj) {
			if(GetCellText(Row, sName.replace("_nm", "_id")) != "") {
                switch(sName) {
                    case "rqst_file_sav_nm":
                        location.href="/opuscntr/FileDownload?key="+GetCellText(Row, "rqst_file_sav_id");
                        break;
                    case "apro_file_sav_nm":
                        location.href="/opuscntr/FileDownload?key="+GetCellText(Row, "apro_file_sav_id");
                        break;
                    case "cxl_file_sav_nm":
                        location.href="/opuscntr/FileDownload?key="+GetCellText(Row, "cxl_file_sav_id");
                        break;
                }
			}
		}
	}
    /**
     * handing process Pop-up<br>
     * @param type 1:Agreement No. Popup for FORM, 2:Office Code Popup for FORM
     * @param Row index
     * @param Col index
     */
    function openPopup(type, Row, Col) {
    	if ( type == "1" ) {
			ComOpenPopupWithTarget('/opuscntr/COM_ENS_071.do', 755, 520, "ofc_cd:rqst_ofc_cd", "1,0,1,1,1,1,1,1", true);
    	}
    	return;
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj) {
    		switch(sAction) {
    			case IBSEARCH:
    				if (!checkDurationDate()) {
    					return false;
    				}
    				return ComChkValid(formObj, true);
    				break;
				default :	//do nothing
    		}
    	}
        return true;
    }
	/**
	 * handling process for Duration Date Validation<br>
	 */
    function checkDurationDate(eventObj) {
    	var formObj=document.form;
    	var vEffDt=ComReplaceStr(ComGetObjValue(formObj.str_rqst_dt),"-","");
		var vExpDt=ComReplaceStr(ComGetObjValue(formObj.end_rqst_dt),"-","");
    	if( vEffDt == "" && vExpDt == "" ) {
    		return true;
    	}
		/* Duration Date Validation(str_rqst_dt) */
		if(vEffDt == "" && eventObj == null) {
			ComShowCodeMessage("LSE01078");
			ComSetFocus(formObj.str_rqst_dt);
			return false;
		} else if(vEffDt == "" && eventObj.name == "str_rqst_dt") {
			ComShowCodeMessage("LSE01078");
			ComSetFocus(formObj.str_rqst_dt);
			return false;
		} else if (vEffDt != "" && !ComIsDate(formObj.str_rqst_dt) ) {
			ComShowCodeMessage("LSE01080");
			ComSetObjValue(formObj.str_rqst_dt,"");
			ComSetFocus(formObj.str_rqst_dt);
			return false;
		}
		/* Duration Date Validation(end_rqst_dt) */
		if(vExpDt == "" && eventObj == null) {
			ComShowCodeMessage("LSE01079");
			ComSetFocus(formObj.end_rqst_dt);
			return false;
		} else if(vExpDt == "" && eventObj.name == "end_rqst_dt") {
			ComShowCodeMessage("LSE01079");
			ComSetFocus(formObj.end_rqst_dt);
			return false;
		} else if (vExpDt != "" && !ComIsDate(formObj.end_rqst_dt) ) {
			ComShowCodeMessage("LSE01081");
			ComSetObjValue(formObj.end_rqst_dt,"");
			ComSetFocus(formObj.end_rqst_dt);
			return false;
		}
		/* Duration Date Validation(str_rqst_dt < end_rqst_dt) */
		if(vEffDt != "" && vExpDt != "") {
			if ( ComChkPeriod(vEffDt, vExpDt) != 1 ) {
				ComShowCodeMessage("LSE01082");
				if(eventObj == null) {
					ComSetObjValue(formObj.end_rqst_dt,"");
					ComSetFocus(formObj.end_rqst_dt);
				} else {
					ComSetObjValue(eventObj,"");
					ComSetFocus(eventObj);
				}
				return false;
			}
		}
		return true;
    }
	/* end of developer job */
