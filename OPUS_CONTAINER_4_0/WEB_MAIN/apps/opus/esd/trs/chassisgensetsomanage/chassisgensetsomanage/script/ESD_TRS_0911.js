/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0911.js
*@FileTitle  : Service Order Creation screen - Chassis or Genset
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/04
=========================================================*/
// Common global variable
var sheetObjects=new Array();
var sheetCnt=0;
var sheetObjSingle;
var Mincount=0;
var winOpenObj = opener;
if(!winOpenObj) winOpenObj = parent;
var cntrck = false;
	/**
	 * Register as an array IBSheet Object
	 * setSheetObject
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/** 
	 * loadPage
	 * After loading in your browser should display the ability to add pre-processing
	 */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet(sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		//html controls the initialization event
		sheetObjSingle = winOpenObj.sheetObjects[0];
		initControl();		
	}
	/**
	 * initControl
	 **/
	function initControl() {
	    //Axon 이벤트 처리1. 이벤트catch
	//		axon_event.addListener  ('keypress', 'engnum_keypress', 'boo_bkg_no', 'vvd_vvd');
	//		axon_event.addListener  ('click', 'manual_click', 'manual');    
	//		axon_event.addListener  ('keyup', 'bkgno_keyup', 'boo_bkg_no'); 
	//		axon_event.addListenerFormat('blur',    'obj_blur',     form);  
	//		axon_event.addListenerFormat('focus',   'obj_focus',    form);  
	//		axon_event.addListenerFormat('keypress','obj_keypress', form);     
	//		axon_event.addListener  ('change', 'customer_change', 'cus_cust_nm');     
	}
	/**
	 * Only numeric input is handled in English. <br>
	 **/
//	function engnum_keypress() {
//	//    ComKeyOnlyAlphabet('uppernum');
//	}
	/**
	 * manual_click <br>
	 **/
	function manual_click() {
	    // Bkg_no checked the manual only be editable.
	//    form.boo_bkg_no.readOnly =!form.manual.checked;
	}
	/**
	 * Booking No BKG Creation tab function changed to handle cases. <br>
	 **/
	function bkgno_keyup() {
	    //bkg_no modify and erase the stored value and if different bl_no, bl_no rescue this case.
	    /*
	    if (form.boo_bkg_no.value != form.hdn_boo_bkg_no.value) 
		form.boo_bl_no.value="";
	    else
		form.boo_bl_no.value=form.hdn_boo_bl_no.value;
		*/
	}
	/**
	 * Validation of HTML Control will check in the onblur event. <br>
	 **/
	function obj_blur(){
	    //Input Validation to check
	//    return ComChkObjValid(event.srcElement);
	}
	/**
	 * HTML Control for the separator to remove the mask from the onfocus event. <br>
	 **/
	function obj_focus(){
	//    ComClearSeparator(event.srcElement);
	}
	/**
	 * HTML Control from the onkeypress event should be numeric only. <br>
	 **/
	function obj_keypress(){
	//    ComKeyOnlyNumber(event.srcElement);
	}
/* Click the button to define an event handler that receives and processes events */
	document.onclick=processButtonClick;
/* Button to process certain filename, separated on a quarterly event handler to handle */
    function processButtonClick(){
         var sheetObject=sheetObjects[0];
         var sheetObject2=sheetObjects[1];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
			switch(srcName) {
        	    case "btn_retrieve":
    	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	        break;
				case "btng_fileimport":
					doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
					break;
				case "btng_delete":
    	            doActionIBSheet(sheetObject,formObject,IBDELETE);
        	        break;
				case "btng_verify":
					importEqNo(sheetObject, sheetObject2, formObject);
					break;
				case "btng_apply":
					doCNTRapply(sheetObject, sheetObjSingle);
					break;
				case "btn_close":
					ComClosePopup(); 
					break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage('COM12111');
    		} else {
    			ComShowMessage(e.message);
    		}
    	}
    }
   /**
     * Sheet, the initial setting, the header definition
     * initSheet
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {
                var HeadTitle="Seq.|STS||EQ No|EQ TP/SZ|Verify Result" ;
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"eq_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                    {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibcheck" },
                    {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eq_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eq_tpsz_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"verify_result",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"fm_loc_value",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
                    {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"fm_yard_value",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
                    {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"to_loc_value",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
                    {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"to_yard_value",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
                    {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vndr_seq" },
                    {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vndr_abbr_nm" },
                    {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"lstm_cd" },
                    {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ownr_co_cd" },
                    {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"usr_co_cd" },
                    {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"mvmt_sts_cd" },
                    {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"lst_sts_yd_cd" },
                    {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"mvmt_dt" } ];
                InitColumns(cols);
                SetEditable(1);
                SetSheetHeight(220);
                }
                break;
            case 2:      //sheet2 init
                with (sheetObj) {
                var HeadTitle="Seq.|STS||EQ No|EQ TP/SZ|Verify Result" ;
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"eq_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                    {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibcheck" },
                    {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eq_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eq_tpsz_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"verify_result",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"fm_loc_value",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
                    {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"fm_yard_value",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
                    {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"to_loc_value",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
                    {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"to_yard_value",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
                    {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vndr_seq" },
                    {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vndr_abbr_nm" },
                    {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"lstm_cd" },
                    {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ownr_co_cd" },
                    {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"usr_co_cd" },
                    {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"mvmt_sts_cd" },
                    {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"lst_sts_yd_cd" },
                    {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"mvmt_dt" } ];
                InitColumns(cols);
                SetEditable(1);
                SetVisible(false);
                }
                break;
        }
    }
     /**
      * Sheet processing-related processes
      */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBSEARCH:
        		if(validateForm(sheetObj,formObj,sAction))
        			sheetObj.DoSearch("UI_ESD_TRS_0911_DATA.html" );
        		break;
            case IBDELETE:
            	var checkList=sheetObj.FindCheckedRow('ibcheck');
				var checkArray=checkList.split('|');
				for(var k=checkArray.length-2; k>=0; k--)
				{
					sheetObj.RowDelete(checkArray[k], false);
				}
                break;
           case IBINSERT:      
                sheetObj.DataInsert();
                break;
           case IBCOPYROW:      
              sheetObj.DataCopy();
              break;
           case IBDOWNEXCEL:    
        	   if(sheetObj.RowCount() < 1){//no data
        		   ComShowCodeMessage("COM132501");
        		   }else{
        			   sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol_TRS(sheetObj), SheetDesign:1, Merge:1 });
        		   }
              break;
           case IBLOADEXCEL:    
			  sheetObj.RemoveAll();
			  sheetObj.LoadExcel();
              break;
        }
    }
   /**
     * Pomipryeokgape screen validation process for handling
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!ComIsNumber(iPage)) {
//
//                return false;
//            }
        }
        return true;
    }
	/**
     * Click on event-related MInimize
     */
    function Minimize(nItem)
    {
        var objs=document.all.item("showMin");
        if ( nItem == "1" )
        {
    	    objs.style.display="none";
			sheetObjects[0].focus();
		}
    	else
    	{
    	    objs.style.display="inline";
			sheetObjects[0].focus();
    	}
    }
	function importEqNo(sheetObj, sheetObj2, formObj)
	{
		var checkList = sheetObj.FindCheckedRow('ibcheck');
		if(checkList == ''){
			ComShowCodeMessage('COM12176');
			return false;
		}
		var queryStr = sheetObj.GetSaveString(false, false, "ibcheck");
		if(queryStr == '') {
			return false;
		}
		
		if(winOpenObj.document.form.kind_chassis[0].checked){
			formObj.f_cmd.value = SEARCH04;
		}else{
			formObj.f_cmd.value = SEARCH05;
		}
		
		sheetObj2.DoSearch("ESD_TRS_0014GS.do", queryStr + '&' + TrsFrmQryString(formObj), {Sync:2} );
		doCNTRcheck(sheetObj, sheetObj2, sheetObjSingle);
	}

	function sheet1_OnLoadExcel(sheetObj, result, code, msg){
	    if(isExceedMaxRow(msg))return;
	}
	
	/**
	 * doCNTRcheck
	 * @param frmSheet
	 * @param toSheet
	 * @param bodySheet
	 * @returns {Boolean}
	 */
	function doCNTRcheck(frmSheet, toSheet, bodySheet) {
		cntrck = true;
		var lvcheck = false;
		if (frmSheet.RowCount("U") < 1) {
			ComShowMessage(ComGetMsg("TRS90036"));
			return false;
		}
		var sRow = frmSheet.FindCheckedRow("ibcheck");
		var arrRow = sRow.split("|");
		for ( var i = 0; i < arrRow.length; i++) {
			lvcheck = false;
			var lvcntr = frmSheet.GetCellValue(arrRow[i], "eq_no");
			for ( var j = 1; j < toSheet.RowCount() + 2; j++) {
				if (lvcntr == toSheet.GetCellValue(j, "eq_no")) {
					frmSheet.SetCellValue(arrRow[i], "eq_tpsz_cd", toSheet.GetCellValue(j, "eq_tpsz_cd"), 0);
					frmSheet.SetCellValue(arrRow[i], "fm_loc_value", toSheet.GetCellValue(j, "fm_loc_value"), 0);
					frmSheet.SetCellValue(arrRow[i], "fm_yard_value", toSheet.GetCellValue(j, "fm_yard_value"), 0);
					frmSheet.SetCellValue(arrRow[i], "to_loc_value", toSheet.GetCellValue(j, "to_loc_value"), 0);
					frmSheet.SetCellValue(arrRow[i], "to_yard_value", toSheet.GetCellValue(j, "to_yard_value"), 0);
					frmSheet.SetCellValue(arrRow[i], "vndr_seq", toSheet.GetCellValue(j, "vndr_seq"), 0);
					frmSheet.SetCellValue(arrRow[i], "vndr_abbr_nm", toSheet.GetCellValue(j, "vndr_abbr_nm"), 0);
					frmSheet.SetCellValue(arrRow[i], "lstm_cd", toSheet.GetCellValue(j, "lstm_cd"), 0);
					frmSheet.SetCellValue(arrRow[i], "ownr_co_cd", toSheet.GetCellValue(j, "ownr_co_cd"), 0);
					frmSheet.SetCellValue(arrRow[i], "usr_co_cd", toSheet.GetCellValue(j, "usr_co_cd"), 0);
					frmSheet.SetCellValue(arrRow[i], "mvmt_sts_cd", toSheet.GetCellValue(j, "mvmt_sts_cd"), 0);
					frmSheet.SetCellValue(arrRow[i], "lst_sts_yd_cd", toSheet.GetCellValue(j, "lst_sts_yd_cd"), 0);
					frmSheet.SetCellValue(arrRow[i], "mvmt_dt", toSheet.GetCellValue(j, "mvmt_dt"), 0);
					frmSheet.SetCellValue(arrRow[i], "verify_result", "OK", 0);
					lvcheck = true;
					break;
				}
			}
			if (!lvcheck) {
				frmSheet.SetCellValue(arrRow[i], "ibcheck", "0", 0);
				frmSheet.SetRowStatus(arrRow[i], "R");
				frmSheet.SetCellValue(arrRow[i], "verify_result", "No Data", 0);
				frmSheet.SetRowBackColor(arrRow[i], "#NANNANNAN");
			}
		}
		for ( var i = 0; i < arrRow.length; i++) {
			var lvcntr = frmSheet.GetCellValue(arrRow[i], "eq_no");
			for ( var j = (i + 1); j < arrRow.length; j++) {
				if (lvcntr == frmSheet.GetCellValue(arrRow[j], "eq_no")) {
					frmSheet.SetCellValue(arrRow[j], "ibcheck", "0", 0);
					frmSheet.SetRowStatus(arrRow[j], "R");
					frmSheet.SetCellValue(arrRow[j], "verify_result", "Same Data", 0);
					frmSheet.SetRowBackColor(arrRow[j], "#NANNANNAN");
				}
			}
		}
		var sRow2 = frmSheet.FindCheckedRow("ibcheck");
		var arrRow2 = sRow.split("|");
		for ( var i = 0; i < arrRow2.length; i++) {
			var doceqno = frmSheet.GetCellValue(arrRow2[i], "eq_no");
			for ( var j = 1; j < bodySheet.RowCount(); j++) {
				if (doceqno == bodySheet.GetCellValue(j, "eq_no")) {
					frmSheet.SetCellValue(arrRow2[i], "ibcheck", "0", 0);
					frmSheet.SetRowStatus(arrRow2[i], "R");
					frmSheet.SetCellValue(arrRow2[i], "verify_result", "Body Same Data", 0);
					frmSheet.SetRowBackColor(arrRow2[i], "#NANNANNAN");
					break;
				}
			}
		}
	}
	
	/**
	 * doCNTRapply
	 * @param frmSheet
	 * @param toSheet
	 * @returns {Boolean}
	 */
	function doCNTRapply(frmSheet, toSheet) { // child Sheet, Body Sheet
		if (!cntrck) {
			ComShowMessage(ComGetMsg("TRS90055"));
			return false;
		}
		cntrck = false;
		var lvcheck = false;
		if (frmSheet.RowCount("U") < 1) {
			ComShowMessage(ComGetMsg("TRS90036"));
			return false;
		}
		var fromRow = 0;
		var toRow = 0;
		var sFromRow = frmSheet.FindCheckedRow("ibcheck");
		var sToRow = toSheet.FindCheckedRow("ibcheck");
		var arrFRow = sFromRow.split("|");
		var arrTRow = sToRow.split("|");
		for ( var i = 0; i < arrFRow.length; i++) {
			var docEqtpszcd = frmSheet.GetCellValue(arrFRow[i], "eq_tpsz_cd");
			for ( var j = 0; j < arrTRow.length; j++) {
				var doceqno2 = toSheet.GetCellValue(arrTRow[j], "eq_no");
				var doceqtpszcd2 = toSheet.GetCellValue(arrTRow[j], "eq_tpsz_cd");
				if (docEqtpszcd == doceqtpszcd2 && doceqno2 == "") {
					toSheet.SetCellValue(arrTRow[j], "eq_no", frmSheet.GetCellValue(arrFRow[i], "eq_no"), 0);
					toSheet.SetCellValue(arrTRow[j], "eq_tpsz_cd", doceqtpszcd2, 0);
					toSheet.SetCellValue(arrTRow[i], "fm_loc_value", frmSheet.GetCellValue(arrFRow[i], "fm_loc_value"), 0);
					toSheet.SetCellValue(arrTRow[i], "fm_yard_value", frmSheet.GetCellValue(arrFRow[i], "fm_yard_value"), 0);
					toSheet.SetCellValue(arrTRow[i], "to_loc_value", frmSheet.GetCellValue(arrFRow[i], "to_loc_value"), 0);
					toSheet.SetCellValue(arrTRow[i], "to_yard_value", frmSheet.GetCellValue(arrFRow[i], "to_yard_value"), 0);
					toSheet.SetCellValue(arrTRow[j], "vndr_seq", frmSheet.GetCellValue(arrFRow[i], "vndr_seq"), 0);
					toSheet.SetCellValue(arrTRow[j], "vndr_abbr_nm", frmSheet.GetCellValue(arrFRow[i], "vndr_abbr_nm"), 0);
					toSheet.SetCellValue(arrTRow[j], "lstm_cd", frmSheet.GetCellValue(arrFRow[i], "lstm_cd"), 0);
					toSheet.SetCellValue(arrTRow[j], "ownr_co_cd", frmSheet.GetCellValue(arrFRow[i], "ownr_co_cd"), 0);
					toSheet.SetCellValue(arrTRow[j], "usr_co_cd", frmSheet.GetCellValue(arrFRow[i], "usr_co_cd"), 0);
					toSheet.SetCellValue(arrTRow[j], "mvmt_sts_cd", frmSheet.GetCellValue(arrFRow[i], "mvmt_sts_cd"), 0);
					toSheet.SetCellValue(arrTRow[j], "lst_sts_yd_cd", frmSheet.GetCellValue(arrFRow[i], "lst_sts_yd_cd"), 0);
					toSheet.SetCellValue(arrTRow[j], "mvmt_dt", frmSheet.GetCellValue(arrFRow[i], "mvmt_dt"), 0);
					break;
				}
			}
		}
		ComClosePopup();
	}
	
	/**
	 * OnChange event of Sheet1
	 * @param sheetObj
	 * @param row
	 * @param col
	 * @param value
	 */
	function sheet1_OnChange(sheetObj, row, col, value) {
		if (sheetObj.ColSaveName(col) == "ibcheck") {
			if (sheetObj.GetCellValue(row, "verify_result").length > 4) {
				sheetObj.SetCellValue(row, "ibcheck", "0", 0);
				sheetObj.SetRowStatus(row, "R");
			} else {
				if (value == "1") {
					sheetObj.SetRowStatus(row, "U");
				} else {
					sheetObj.SetRowStatus(row, "R");
				}
			}
		}
	}