/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CTM_0442.js
*@FileTitle  : Detail Information 
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
 * @class ees_ctm_0442 : business script for ees_ctm_0442 
 */
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	    function processButtonClick(){
	        var frmObject=document.form;
	        try {
	            var srcName=ComGetEvent("name");
				if(ComGetBtnDisable(srcName)) return false;
	            switch(srcName) {
	                case "btn_close":
	                	ComClosePopup(); 
	                    break;
	            } // end switch
	        } catch(e) {
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
	    function setSheetObject(sheetObj){
	       sheetObjects[sheetCnt++]=sheetObj;
	    }
	    /**
	     * initializing sheet
	     * implementing onLoad event handler in body tag
	     * adding first-served functions after loading screen.
	     */
	    function loadPage() {
	        for(i=0;i<sheetObjects.length;i++){
	            ComConfigSheet (sheetObjects[i] );
	            initSheet(sheetObjects[i], i+1);
	            ComEndConfigSheet(sheetObjects[i]);
	        }
	        if (document.form.mvmt_edi_msg_area_cd.value &&
	            document.form.mvmt_edi_msg_seq.value &&
	            document.form.mvmt_edi_msg_tp_id.value &&
	            document.form.mvmt_edi_msg_yrmondy.value &&
	            document.form.mvmt_edi_tp_cd.value) {
	            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	        }
	    }
	    /**
	     * setting sheet initial values and header
	     * param : sheetObj, sheetNo
	     * adding case as numbers of counting sheets
	     */
	    function initSheet(sheetObj, sheetNo) {
	        var cnt=0;
	        switch(sheetNo) {
	            case 1:      //sheet1 init
	                with(sheetObj){
			              var HeadTitle="Retry|Retry Date|STS|I/O|F/M|VVD Code|Result Error Message|Booking No.|Container No.|Yard";
			              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			              var headers = [ { Text:HeadTitle, Align:"Center"} ];
			              InitHeaders(headers, info);
			              var cols = [ {Type:"Text",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"rty_knt",           KeyField:0,  UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",     Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"cre_locl_dt",       KeyField:0,  UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"edi_mvmt_sts_cd",   KeyField:0,  UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"edi_gate_io_cd",    KeyField:0,  UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_full_sts_cd",  KeyField:0,  UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vvd_cd",            KeyField:0,  UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",     Hidden:0,  Width:340,  Align:"Left",    ColMerge:0,   SaveName:"edi_rmk",           KeyField:0,  UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",     Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",            KeyField:0,  UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",     Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",           KeyField:0,  UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"evnt_yd_cd",        KeyField:0,  UpdateEdit:0,   InsertEdit:0 } ];
			              InitColumns(cols);
			              SetEditable(1);
			              SetSheetHeight(160);
	                    }
	                break;
	        }
	    }
	    function doActionIBSheet(sheetObj, frmObj, sAction) {
	        sheetObj.ShowDebugMsg(false);
	        switch(sAction) {
	            case IBSEARCH:   
	                if (validateForm(sheetObj, frmObj, sAction)) {
	                    sheetObj.SetWaitImageVisible(0);
	                    ComOpenWait(true);
	                    frmObj.f_cmd.value=SEARCH;
	                    sheetObj.DoSearch("EES_CTM_0442GS.do", FormQueryString(frmObj), {Sync:2});
	                    ComEtcDataToForm(frmObj, sheetObj);
	                }
	        }
	    }
	    /**
	     * handling OnSearchEnd event in Sheet1
	     */
	    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	        ComOpenWait(false);
	        sheetObj.SetWaitImageVisible(1);
	    }
	    /**
	     * handling process for input validation
	     */
	    function validateForm(sheetObj, frmObj, sAction){
	        with(frmObj){
	        }
	        return true;
	    }