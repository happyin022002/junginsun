/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0045.js
*@FileTitle  : Receivable Invoice Inquiry and Cancel 
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
	 * @class EES_LSE_0045 :  business script for EES_LSE_0045
	 */
	function EES_LSE_0045() {
		this.processButtonClick=processButtonClick;
		this.setSheetObject=setSheetObject;
		this.loadPage=loadPage;
		this.sheet1_OnLoadFinish=sheet1_OnLoadFinish;
		this.initControl=initControl;
		this.obj_blur=obj_blur;
		this.obj_focus=obj_focus;
		this.obj_change=obj_change;
		this.obj_keypress=obj_keypress;
		this.obj_keyup=obj_keyup;
		this.obj_keydown=obj_keydown;
		this.initSheet=initSheet;
		this.doActionIBSheet=doActionIBSheet;
		this.sheet1_OnMouseMove=sheet1_OnMouseMove;
		this.sheet1_OnDblClick=sheet1_OnDblClick;
		this.sheet1_OnSearchEnd=sheet1_OnSearchEnd;
		this.sheet1_OnValidation=sheet1_OnValidation;
		this.sheet1_OnSaveEnd=sheet1_OnSaveEnd;
		this.openPopup=openPopup;
		this.setPopData_Lessor=setPopData_Lessor;
		this.validateForm=validateForm;
		this.clearForm=clearForm;
	}
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
    		var srcObj= ComGetEvent();
    		var srcName=ComGetEvent("name");
           	switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject1, formObj, IBSEARCH);
					break;
				case "btn_new":
					ComResetAll();
					// calling event after Load-Finish
					sheet1_OnLoadFinish(sheetObject1);
					break;
				case "btn_cancel":
					doActionIBSheet(sheetObject1, formObj, IBSAVE);
					break;
				case "btn_downexcel":
					if(sheetObject1.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
						}else{
							sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
						}
					break;
				case "btns_calendar1":
 					var cal=new ComCalendar();
					cal.setDisplayType('month');
					cal.select(formObj.qty_yrmon, 'yyyy-MM');
             	 	break;
				case "btns_search1": 	// Form Lessor Search
					openPopup("1");
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
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        sheet1_OnLoadFinish(sheet1);
    }
	/**
	 * calling event after Load-Finish
	 */
    function sheet1_OnLoadFinish(sheetObj) {
		var formObj=document.form;
		/* Axon Control Setting*/
		initControl();
		/* Focus Setting */
		ComSetFocus(formObj.vndr_seq);
    }
	/** registering initial event */
  	function initControl() {
  		var formObj=document.form;
  		axon_event.addListenerFormat('blur',		'obj_blur',		formObj); 
//		axon_event.addListenerForm('focus',			'obj_focus',	formObj); 
  	//axon_event.addListenerFormat('keypress',	'obj_keypress',	formObj); 
//		axon_event.addListenerFormat('keyup',		'obj_keyup',	formObj); 
//		axon_event.addListenerForm('keydown',		'obj_keydown',	formObj); 
		axon_event.addListenerFormat('change',		'obj_change',	formObj); 
  	}
  	
  	
  	
	//setting event Duplicate
	var preEventType=null;
  	/**
	 * handling Location blur event
	 */
	function obj_blur(){
		var obj=ComGetEvent();
		if(preEventType == event.type) {
			preEventType=null;
			return;
		}
	    switch(ComGetEvent("name")){
	    	case "qty_yrmon" :
	    		//checking Validation
	            ComChkObjValid(obj);
	            break;
	        case "vndr_seq" :
	    		/* checking number */
	            ComChkObjValid(obj, true, false, false);
	            break;
	        default:
	            //checking Validation
	            ComChkObjValid(obj);
	        	break;
	    }
	}
	
	/**
	 * handling event in case of Key-Press
	 */
  	function goKeyCheck() {
  		var obj = event.srcElement;
  		var formObj  = document.form;
  		if(Number(formObj.inv_no.value.length) < 3) {
        	ComKeyOnlyAlphabet('upper');
    	} else {
    		ComKeyOnlyNumber(formObj.inv_no);
    	}
  	}
  	
  	
  	
  	
	/**
	 * Onhandling event in case of Change
	 */
	function obj_change(){
		var obj=ComGetEvent();
		var formObj=document.form;
		switch(ComGetEvent("name")) {
			case "vndr_seq":	//Lessor Code
  				if ( ComTrim(obj.value) != "" ) {
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC01);
  				}
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
		var sheetId=sheetObj.id;
        switch(sheetId) {
             case "sheet1":      //sheet1 init
                with (sheetObj) {
            	    var HeadTitle="|Sel.||Invoice No.|Lessee\nCode|Lessee Name|Issued Date|LSE\nCURR.|Invoice\nAmount|ERP\nCURR.|ERP\nLCL Amount|ERP\nUSD Amount|OTS Settle\nStatus|Invoice\nStatus|ERP\nStatus|I/F Date|Created|||||";
            	    var headCount=ComCountHeadTitle(HeadTitle);
            	    SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
            	    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            	    var headers = [ { Text:HeadTitle, Align:"Center"} ];
            	    InitHeaders(headers, info);
            	    var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
            	              {Type:"Radio",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
            	              {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cost_yrmon",      KeyField:0,   CalcLogic:"",   Format:"" },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"inv_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"vndr_abbr_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"inv_isu_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Float",     Hidden:0,  Width:95,   Align:"Right",   ColMerge:0,   SaveName:"inv_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"ofc_curr_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Float",     Hidden:0,  Width:95,   Align:"Right",   ColMerge:0,   SaveName:"erp_lcl_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Float",     Hidden:0,  Width:95,   Align:"Right",   ColMerge:0,   SaveName:"erp_usd_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ots_stl_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Combo",     Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"bl_inv_if_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Combo",     Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"erp_if_sts",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"src_if_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"inv_cre_usr_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"if_err_rsn",      KeyField:0,   CalcLogic:"",   Format:"" },
            	              {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"erp_if_rsn",      KeyField:0,   CalcLogic:"",   Format:"" },
            	              {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"src_if_seq",      KeyField:0,   CalcLogic:"",   Format:"" },
            	              {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cfm_flg",         KeyField:0,   CalcLogic:"",   Format:"" },
            	              {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"inv_cre_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"" } ];
            	    InitColumns(cols);
            	    SetEditable(1);
            	    SetColProperty("ots_stl_flg", {ComboText:"|Settled|NotSettled", ComboCode:"|Y|N"} );
            	    SetColProperty("bl_inv_if_flg", {ComboText:"|InvoiceI/FSuccess|InvoiceI/FSending|InvoiceI/FError", ComboCode:"|Y|N|E"} );
            	    SetColProperty("erp_if_sts", {ComboText:"|ERPI/FSuccess|NotERPI/F|ARInvoicingFail|ERPI/FError", ComboCode:"|Y|N|F|E"} );
            	    SetCountFormat("[SELECTDATAROW / TOTALROWS]");
            	    //SetSheetHeight(410);
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
	 */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        	switch(sAction) {
				case IBSEARCH:
					if(validateForm(sheetObj, formObj, sAction)) {
						if(sheetObj.id == "sheet1") {
							formObj.f_cmd.value=SEARCH;
							sheetObj.SetWaitImageVisible(0);
							ComOpenWait(true);
							sheetObj.DoSearch("EES_LSE_0045GS.do",FormQueryString(formObj) );
							ComOpenWait(false);
						}
					}
					break;
				case IBSEARCH_ASYNC01:	//retrieving when input Form Lessor No.
					if ( validateForm(sheetObj, formObj, sAction) ) {
						var param="f_cmd="+SEARCH06+"&vndr_seq="+ComGetObjValue(formObj.vndr_seq);
						sheetObj.SetWaitImageVisible(0);
						var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do", param);
						sheetObj.SetWaitImageVisible(1);
						if ( sXml != "" ) {
							if ( ComGetEtcData(sXml, "vndr_lgl_eng_nm") != undefined ) {
								ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
								ComSetObjValue(formObj.vndr_abbr_nm, ComGetEtcData(sXml, "vndr_abbr_nm"));
								ComSetFocus(formObj.vndr_nm);
	 						} else {
	 							ComShowCodeMessage("LSE01019");
	 							clearForm("vndr_seq");
	 						}
						} else {
							var errMsg=LseComGetErrMsg(sXml);
							if ( errMsg != "" ) {
								ComShowMessage(errMsg);
							}
							clearForm("vndr_seq");;
						}
					}
					break;
				case IBSAVE:        //저장
					if(validateForm(sheetObj, formObj, sAction)) {
						if(sheetObj.id == "sheet1") {
							ComOpenWait(true);
							formObj.f_cmd.value=MULTI;
							
							if(sheetObj.DoSave("EES_LSE_0045GS.do", FormQueryString(formObj)) == false) {
								ComOpenWait(false);
							}
						}
					}
					
					break;
        	}
    }
	/**
	 * handling event when OnMouseMove Sheet.
	 */
	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
		with(sheetObj) {
			Row=MouseRow();
			Col=MouseCol();
			if(Row >= HeaderRows()&& ColSaveName(Col) == "bl_inv_if_flg") {
//no support[check again]CLT 				MouseToolTipText=GetCellText(Row,"if_err_rsn");
			} else if(Row >= HeaderRows()&& ColSaveName(Col) == "erp_if_sts") {
//no support[check again]CLT 				MouseToolTipText=GetCellText(Row,"erp_if_rsn");
			} else {
//no support[check again]CLT 				MouseToolTipText="";
			}
			SetDataLinkMouse("inv_cre_usr_id",GetCellValue(MouseRow(), MouseCol()) != "");
			//SetDataLinkMouse("acct_cd",1);
		}
	}
	/**
	 * sheet1_OnDblClick
	 */
	function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
		var formObj=document.form;
		var sName=sheetObj.ColSaveName(Col);
		with(sheetObj) {
			switch(sName) {
//			if(sheetObj.GetMousePointer()== "Hand") {
			case "inv_cre_usr_id":
				ComOpenWindowCenter("/opuscntr/UserInfo.do?usr_id="+GetCellValue(Row, Col)+"&f_cmd=104", "UserInfo", "550", "350", true);
				break;
//			}
			}
		}
	}
	/**
     * calling event after retrieving Sheet
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var formObj=document.form;
    	with(sheetObj) {
    		SetColFontColor("inv_cre_usr_id","#0000FF");
    		for(var i=0; i <= SearchRows(); i++) {
    			var vCreOfcCd=GetCellValue(i, "inv_cre_ofc_cd");
    			//var vInvIfFlg = CellValue(i, "bl_inv_if_flg");
    			//CellEditable(i, "del_chk") = vInvIfFlg == "N";
    			if(GetCellValue(i, "cfm_flg") == "N") {
    				SetRowFontColor(i,"#858585");//GRAY
    			}
				//canceling for Invoice 
    			SetCellEditable(i, "del_chk",(formObj.ofc_cd.value == vCreOfcCd));
    		}
    	}
    }
    /**
     * calling event after retrieving Sheet
     * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
     */
    function sheet1_OnValidation(sheetObj, Row, Col, Value) {
    	with(sheetObj) {
	    	//do nothing
    	}
    }
    /**
     * handling after saving
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	ComOpenWait(false);
		sheetObj.SetWaitImageVisible(1);
		
    	if(!/Error/.test(ErrMsg)) {
    		//ComShowCodeMessage("LSE10001");
    		doActionIBSheet(sheetObj, document.form, IBSEARCH);
    	}
    }
    /**
     * handing process Pop-up<br>
     * @param type 1:Agreement(include Ver.) for FORM, 2:Lessor for FORM, 3:Currency for FORM
     * @param object
     * @param Row index
     */
    function openPopup(type, Row, Col) {
    	if ( type == "1" ) {
    		ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 715, 560, 'setPopData_Lessor', '1,0,1,1,1,1,1,1', true);
    	}
    	return;
    }
	/**
     * handing process Lessor(Service Provider) Pop-up Return Value <br>
     * @param Return value array
     * @param Row index
     * @param Col index
     * @param Sheet Array index
	 */
	function setPopData_Lessor(aryPopupData, Row, Col, SheetIdx) {
		var sheetObj=sheetObjects[SheetIdx];
		var formObj=document.form;
		if ( aryPopupData.length > 0 ) {
			ComSetObjValue(formObj.vndr_seq, ComLtrim(aryPopupData[0][2],"0"));
			ComSetObjValue(formObj.vndr_abbr_nm,  aryPopupData[0][5]);
			ComSetObjValue(formObj.vndr_nm,  aryPopupData[0][4]);
		}
	}
    /**
	 * handling process for input validation
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 */
	function validateForm(sheetObj, formObj, sAction) {
    	with(formObj) {
    		switch(sAction) {
    			case IBSEARCH:
    				return ComChkValid(formObj, false);
    				break;
				default :	//do nothing
    		}
    	}
	    with(sheetObj) {
    		switch(sAction) {
	    		case IBSAVE:
	    			return true;
	    			break;
	    		default : 	//do nothing
    		}
    	}
        return true;
	}
    /**
	 * handling process for Form Element Clear<br>
	 * @param fieldName
	 */
	function clearForm(fieldName) {
		var formObj=document.form;
		switch(fieldName) {
			case "vndr_seq":
				ComSetObjValue(formObj.vndr_seq, 	"");
				ComSetObjValue(formObj.vndr_nm,  	"");
				ComSetObjValue(formObj.vndr_abbr_nm,"");
				ComSetFocus(formObj.vndr_seq);
				break;
		}
	}
	/* end of developer job */
