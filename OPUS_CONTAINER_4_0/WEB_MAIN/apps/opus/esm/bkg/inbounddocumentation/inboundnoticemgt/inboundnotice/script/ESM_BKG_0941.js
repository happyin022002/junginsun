/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0941.js
*@FileTitle  : Consignee Code Error Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/18
=========================================================*/
/****************************************************************************************
  Event distinction code: [Initialization]INIT=0; [Input]ADD=1; [Retrieve]SEARCH=2; [Retrieving List]SEARCHLIST=3;
					[Modification]MODIFY=4; [Delete]REMOVE=5; [Deleting list]REMOVELIST=6 [Multi-Processing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------The following code is added to make a good JSDoc ------------------*/
// Common global variables
var sheetObjects=new Array();
var sheetCnt=0;
var sheetNames=new Array("sheet1", "sheet2");
var sheetInits=new Array(   false,    false);
// Event Handler definition for Button Click event */
document.onclick=processButtonClick;
/**
 * Event Handler for branch processing by judging button name<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return {void}
 * @author
 * @version 2009.10.01
 */
function processButtonClick(){
    var sheetObject=sheetObjects[0];
    /*******************************************************/
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
        if (!ComIsBtnEnable(srcName)) {return;}
        switch(srcName) {
            case "btn_bkg_cre_dt":
                var cal=new ComCalendarFromTo();
                cal.select(formObject.bkg_cre_dt_s, formObject.bkg_cre_dt_e, 'yyyy-MM-dd');
                break;
            case "btn_val_dt":
                var cal=new ComCalendarFromTo();
                cal.select(formObject.val_dt_s, formObject.val_dt_e, 'yyyy-MM-dd');
                break;
            case "btn_retrieve":
            	doActionIBSheet(sheetObject, formObject, IBSEARCH, "", "");
                break;
            case "btn_Save":
            	doActionIBSheet(sheetObject, formObject, IBSAVE, "", "");
            	break;
            case "btn_DownExcel":
                doActionIBSheet(sheetObjects[1],formObject,IBDOWNEXCEL,"","");
                break;
            case "code_ofc_cd_inq":
            	ComOpenPopupWithTarget('/opuscntr/COM_ENS_071.do', 800, 500, "ofc_cd:code_ofc_cd", '0,0,1,1,1,1,1', true);
            	break;
            case "val_ofc_cd_inq":
            	ComOpenPopupWithTarget('/opuscntr/COM_ENS_071.do', 800, 500, "ofc_cd:val_ofc_cd", '0,0,1,1,1,1,1', true);
            	break;
            case "bkg_ofc_cd_inq":
            	ComOpenPopupWithTarget('/opuscntr/COM_ENS_071.do', 800, 500, "ofc_cd:bkg_ofc_cd", '0,0,1,1,1,1,1', true);
            	break;
            case "cust_cd_inq":
            	ComOpenPopupWithTarget('/opuscntr/COM_ENS_041.do', 800, 500, "cust_cd:cust_cd", '0,0,1,1,1,1,1', true);
            	break;
            case "doc_usr_id_inq":
            	ComOpenPopupWithTarget('/opuscntr/COM_ENS_091.do', 1000, 560, "usr_id:doc_usr_id", '0,0,1,1,1,1,1', true);
            	break;
            case "val_usr_id_inq":
            	ComOpenPopupWithTarget('/opuscntr/COM_ENS_091.do', 1000, 560, "usr_id:val_usr_id", '0,0,1,1,1,1,1', true);
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
 * Registering IBSheet Object in to Array<br>
 * Afterwards, when other items need to be batch processed,it can add to the process that stores in to array<br>
 * The array is defined at upper part of source<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheet_obj mandatory, Sheet object
 * @return {void}
 * @author
 * @version
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++]=sheet_obj;
}
     /**
      * Sheet basic setting & initializing
      * onLoad Event HandlerImplementation of body tag
      * After loading screen in the browser, add function in pre-processing
      */
function loadPage() {
    for(i=0;i<sheetNames.length;i++){
    	if(sheetNames[i] == "sheet1") {
    		sheetInit(i);
        }
    }
    initControl();
    initComboBoxValCd();
    var formObj=document.form;
    fnInSetComboBox(formObj.cust_tp_cd, gCustCode, gCustValue, "|", "", "ALL", true, "");
}
/**
 * Definition for sheet initial setting value, header
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {int} idx mandatory, Index of Sheet
 * @return {void}
 * @author
 * @version
 */
function sheetInit(idx) {
	if (sheetInits[idx] == false) {
        ComConfigSheet (sheetObjects[idx] );
        initSheet(sheetObjects[idx],idx+1);
        ComEndConfigSheet(sheetObjects[idx]);
        sheetInits[idx]=true;
    }
}
/**
 * Initializing ComboBox.<br>
 * Evaluation Result Combo<br>
 * There is a requirement that 'Wrong' located on the top, 'All' located on the bottom
 * As below, adjusting order about basic Option.<br>
 * @param {void}
 * @return void
 */
function initComboBoxValCd() {
    var formObj=document.form;
	var codeArr=evtCode.split("|");
    var valueArr=evtValue.split("|");
	// Handling for 'Wrong' to be in the Default
    for(var m=1; m<codeArr.length -1; m++) {
        if (codeArr[m] == "W") {
	       var oOption=document.createElement("OPTION");
	       formObj.val_cd.options.add(oOption);                     
	       oOption.innerText=valueArr[m];       
	       oOption.value=codeArr[m];
           oOption.selected=true;
        }
    }
    for(var m=1; m<codeArr.length -1; m++) {
        if (codeArr[m] != "W" ) {
	        var oOption=document.createElement("OPTION");
	        formObj.val_cd.options.add(oOption);                     
	        oOption.innerText=valueArr[m];       
	        oOption.value=codeArr[m];
        }
     }
	 // 'All' located on the bottom
     var oOption=document.createElement("OPTION");
     formObj.val_cd.options.add(oOption);                     
     oOption.innerText="All";       
     oOption.value="";
}
     /**
      * Definition for sheet initial setting value, header
      * param : sheetObj ==> sheet object, 
      * sheetNo ==> If the serial number ID tag attached to the sheet are many,
      * adding 'Case' clause as a number of sheets, configures initial module.
      */	 
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    var sheetId=sheetObj.id;
    switch(sheetId) {
        case "sheet1":
            with (sheetObj) {
            var HeadTitle="|Seq.|B/L No.|Customer\nType|Error\nCode|Correct\nCode|Evaluation\nResult|Code Input\nOFC|Inputter ID|Code\nInput Date|BKG OFC|Report OFC|Reporter ID|Rep. Date|Wrong\nEvaluation|I/B\nConfirm|H/Q\nConfirm|||";

            SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            var headers = [ { Text:HeadTitle, Align:"Center"} ];
            InitHeaders(headers, info);

            var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                      {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",    ColMerge:1,   SaveName:"bl_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"cust_tp_cd_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"err_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"crt_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
//                      {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cd_cre_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"evl_rst_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cd_input_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cd_input_usr_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cd_input_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bkg_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"evl_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"evl_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"evl_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"CheckBox",  Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ob_ev_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
                      {Type:"CheckBox",  Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ib_ev_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
                      {Type:"CheckBox",  Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"hq_ev_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"bkg_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"bkg_cust_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"data_changed",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
             
            	InitColumns(cols);

            	SetEditable(1);
            	SetColProperty("cd_cre_dt", {Format:"####-##-##"} );
            	SetColProperty("cd_input_dt", {Format:"####-##-##"} );
            	SetColProperty("evl_dt", {Format:"####-##-##"} );
            	SetWaitImageVisible(0);
            	SetCountFormat("[SELECTDATAROW / TOTALROWS]");
            	SetSheetHeight(410);
            }
            break;
        case "sheet2":
            with (sheetObj) {
	            var HeadTitle="Seq.|B/L No.|Customer\nType|Error\nCode|Correct\nCode|Code Create\nDate|Evaluation\nResult|Code Input\nOFC|Inputter ID|Code\nInput Date|Report OFC|Reporter ID|Rep. Date";
	
	            SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	            var headers = [ { Text:HeadTitle, Align:"Center"} ];
	            InitHeaders(headers, info);
	
	            var cols = [ {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
	                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"bl_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"cust_tp_cd_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"err_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"crt_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cd_cre_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"evl_rst_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cd_input_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cd_input_usr_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cd_input_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"evl_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"evl_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"evl_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	             
	            InitColumns(cols);
	
	            SetEditable(1);
	            SetColProperty("cd_cre_dt", {Format:"####-##-##"} );
	            SetColProperty("cd_input_dt", {Format:"####-##-##"} );
	            SetColProperty("evl_dt", {Format:"####-##-##"} );
	            SetVisible(0);
            }
            break;
    }
}
/**
 * Sheet관련 프로세스 처리<br>
 * Handling process about Sheet
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj mandatory, Sheet object
 * @param {Object} formObj mandatory, form object
 * @param {String} sAction mandatory, job code
 * @param {String} Selection CondParam, previous inquiry conditions information
 * @param {int} Selection pageNo, Page number
 * @return {void}
 * @author
 * @version 
 */
function doActionIBSheet(sheetObj,formObj,sAction, sCondParam, PageNo) {
    //sheetObj.ShowDebugMsg = false;
    switch(sAction) {
        case IBSEARCH:  
            if(!validateForm(sheetObj,formObj,sAction)) {return; }
 		    formObj.f_cmd.value=SEARCH;
 		    ComOpenWait(true);
 		    iPageNo = 1;
 		    sheetObj.DoSearch("ESM_BKG_0941GS.do", FormQueryString(formObj) + "&page_no=1", {Append:false});
 		    //sheetObj.DoSearch("ESM_BKG_0941GS.do", FormQueryString(formObj) + "&iPage=" + PageNo, {Append:false}); 		    
            break;
        case IBSEARCHAPPEND:
        	formObj.f_cmd.value=SEARCH;
        	ComOpenWait(true);
        	//sheetObj.DoSearch("ESM_BKG_0941GS.do", sCondParam + "&" + "iPage=" + PageNo ,{Append:true} );
        	sheetObj.DoSearch("ESM_BKG_0941GS.do", sCondParam + "&" + "&page_no=1" ,{Append:true} );
        	break;
        case IBSAVE:
        	if(!validateForm(sheetObj,formObj,sAction)) {return; }
        	if(!ComShowCodeConfirm("BKG00254")) {return;}
        	formObj.f_cmd.value=MODIFY;
            var statusRow=sheetObj.FindStatusRow("U");
            var statusArray=statusRow.split(";");
            var sheetParam="";
            //alert(FormQueryString(formObj));
            for (var idx=0; idx < statusArray.length; idx++) {
            	sheetParam=sheetParam + "&ibflag=" + sheetObj.GetCellValue(statusArray[idx], "ibflag")
            	+ "&bkg_no=" + sheetObj.GetCellValue(statusArray[idx], "bkg_no")
            	+ "&bkg_cust_tp_cd=" + sheetObj.GetCellValue(statusArray[idx], "bkg_cust_tp_cd")
            	+ "&ob_ev_cd=" + sheetObj.GetCellValue(statusArray[idx], "ob_ev_cd")
            	+ "&ib_ev_cd=" + sheetObj.GetCellValue(statusArray[idx], "ib_ev_cd")
            	+ "&hq_ev_cd=" + sheetObj.GetCellValue(statusArray[idx], "hq_ev_cd");
            }
        	var sXml=sheetObj.GetSaveData("ESM_BKG_0941GS.do", "f_cmd=" + formObj.f_cmd.value + sheetParam );
        	var txState=ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
            if (txState == "S") {
        		for (var i=0; i < statusArray.length -1; i++) {
        			sheetObj.SetCellEditable(statusArray[i], "ib_ev_cd",(sheetObj.GetCellValue(statusArray[i], "ob_ev_cd") == "1" && sheetObj.GetCellValue(statusArray[i], "evl_ofc_cd") == gUsrOfcCd));
        			sheetObj.SetCellEditable(statusArray[i], "hq_ev_cd",(sheetObj.GetCellValue(statusArray[i], "ob_ev_cd") == "1" && isHeadOfficeCode));// SELHO오피스만 수정 가능
        			sheetObj.SetCellValue(statusArray[i], "data_changed","");
        			sheetObj.SetRowStatus(statusArray[i],"R");
        			sheetObj.SetCellValue(statusArray[i], "ibflag","R");
        		}
        		ComShowCodeMessage("BKG00102");
            }
        	break;
        case IBDOWNEXCEL:
        	if(!validateForm(sheetObj,formObj,sAction)) {return; }
        	formObj.f_cmd.value=SEARCH;
        	ComOpenWait(true);
        	sheetInit(1);
        	sheetObj.DoSearch("ESM_BKG_0941GS.do", FormQueryString(formObj) + "&excel_flg=Y");
            break;
    }
}
/**
 * Initialization : Registering Event.<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return {void}
 * @author
 * @version
 */
function initControl() {
    //Handling Axon Event, catching event.
//    axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
//    axon_event.addListenerForm('keypress', 'objKeyPress', form);
//    axon_event.addListenerForm('keyup', 'objKeyUp', form);
    axon_event.addListenerForm('click', 'objClick', form);
    axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
}
/**
 * Handling validity verification process about screen form input value.<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj mandatory, Sheet object
 * @param {Object} formObj mandatory, form object
 * @param {int} sAction mandatory, job code
 * @return {boolean} Validation result value
 * @author
 * @version
 */
function validateForm(sheetObj,formObj,sAction){
	switch(sAction) {
		case IBSEARCH:
		    with(formObj){
				if (formObj.dt_option[0].checked){
					if (formObj.bkg_cre_dt_s.value.length != 10) {
						ComShowCodeMessage("BKG00870");
//						formObj.bkg_cre_dt_s.focus();
						formObj.bkg_cre_dt_s.value="";
						return false;
					}
					if (formObj.bkg_cre_dt_e.value.length != 10) {
						ComShowCodeMessage("BKG00871");
//						formObj.bkg_cre_dt_e.focus();
						formObj.bkg_cre_dt_e.value="";
						return false;
					}
				} else {
					if (formObj.val_dt_s.value.length != 10) {
						ComShowCodeMessage("BKG00870");
//						formObj.val_dt_s.focus();
						formObj.val_dt_s.value="";
						return false;
					}
					if (formObj.val_dt_e.value.length != 10) {
						ComShowCodeMessage("BKG00871");
//						formObj.val_dt_e.focus();
						formObj.val_dt_e.value="";
						return false;
					}
				}
		    	if (!ComChkValid(formObj)) {return false; }
		    	if (formObj.dt_option[0].checked){
		    		var fromDate=formObj.bkg_cre_dt_s.value;
			    	var toDate=formObj.bkg_cre_dt_e.value;
		    	} else {
		    		var fromDate=formObj.val_dt_s.value;
			    	var toDate=formObj.val_dt_e.value;
		    	}
		    	if(!ComBkgMonthsBetweenCheck(fromDate, toDate, 6)) {
		    		ComShowCodeMessage("BKG40013", "6"); //only less than {?msg1}-month periods allowed
		    		return false;
		    	}
		    }
		    break;
		case IBSAVE:
			var statusRow=sheetObj.FindStatusRow("U");
			if (statusRow == "") {
				//Nothing changed
				ComShowCodeMessage("BKG00233");
				return false;
			}
			break;
	}
    return true;
}
/**
 * When vertical scroll bar reaches the bottom,event occurs.<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj mandatory, sheet object
 * @param {String} Disabled CondParam,
 * @param {String} Disabled PageNo,
 * @param {String} Disabled OnePageRows,
 * @return {void}
 * @author
 * @version
 */
var iPageNo = 1;
function sheet1_OnVScroll(sheetObj, vpos, oldvpos, isTop, isBottom) {
    if (!isBottom || sheetObj.RowCount() >= sheetObj.GetTotalRows()) return;
    doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, true, ++iPageNo);
}
/**
 * After inquiry completion for 'Excel Down', downloads Excel<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj mandatory, Sheet object
 * @param {String} errStr mandatory, message character set
 * @returns void
 * @author
 * @version
 */
function sheet2_OnSearchEnd(sheetObj, errXml) {
	ComOpenWait(false); 
	if (sheetObj.RowCount() < 1) {
		ComShowCodeMessage("COM132501");
		return;
	}
	sheetObj.SetHeaderBackColor("#CCCCCC");
	sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
	sheetObj.SetHeaderBackColor("#333333");
}
/**
 * Sheet1의 조회후 처리<br>
 * After retrieving of Sheet1, handling it.<br>
 * Setting column color.
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj mandatory, object
 * @param {String} errStr mandatory, message character set
 * @returns void
 * @author
 * @version
 */
function sheet1_OnSearchEnd(sheetObj, errXml) {
	var formObj=document.form;
	if (formObj.mtch_flg[1].checked) { 
		sheetObj.SetColHidden("ob_ev_cd",1);
		sheetObj.SetColHidden("ib_ev_cd",1);
		sheetObj.SetColHidden("hq_ev_cd",1);
	} else {
		sheetObj.SetColHidden("ob_ev_cd",0);
		sheetObj.SetColHidden("ib_ev_cd",0);
		sheetObj.SetColHidden("hq_ev_cd",0);
		sheetObj.SetColWidth("evl_dt", 80);
		var isBlInputOfc=(formObj.bkg_ofc_cd.value == gUsrOfcCd);
	    var startRow=1;
	    var maxRow=sheetObj.LastRow();
	    if (maxRow < 100) {
	        startRow=1;
	    } else if ((maxRow%100.0) == 0 ) {
	        startRow=maxRow - 100 ;
	        if (startRow < 1) {
	            startRow=1;
	        }
	    } else {
	        startRow=maxRow - ((maxRow - 1.0)%100.0);
	    }
		for (var i=startRow; i <= maxRow; i ++) {
			sheetObj.SetCellEditable(i, "ob_ev_cd",isBlInputOfc && ((sheetObj.GetCellValue(i, "ib_ev_cd") != "1") && (sheetObj.GetCellValue(i, "hq_ev_cd") != "1")));
			sheetObj.SetCellEditable(i, "ib_ev_cd",(sheetObj.GetCellValue(i, "ob_ev_cd") == "1" && sheetObj.GetCellValue(i, "evl_ofc_cd") == gUsrOfcCd));
			sheetObj.SetCellEditable(i, "hq_ev_cd",(sheetObj.GetCellValue(i, "ob_ev_cd") == "1" && isHeadOfficeCode));// SELHO오피스만 수정 가능
		}
	}
	ComOpenWait(false);
}
/**
 * When click 'Customer Validation Sheet', occurs event.<br>
 * 
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Objet} sheetObj mandatory, Sheet object
 * @param {int} row mandatory, row
 * @param {int} col mandatory, column
 * @return {void}
 * @author
 * @version
 */
function sheet1_OnClick(sheetObj, row, col) {
    var colName=sheetObj.ColSaveName(col);
    var dtValue=sheetObj.GetCellValue(row,col);
    switch(colName) {
        case "ob_ev_cd":
        	if (sheetObj.GetCellEditable(row,col)) {
        		if (sheetObj.GetCellValue(row, "data_changed") == "") {
        			sheetObj.SetCellValue(row, "data_changed","C");
        		}
        	}
        	break;
        case "ib_ev_cd":
        	if (sheetObj.GetCellEditable(row,col)) {
        		if (sheetObj.GetCellValue(row, "data_changed") == "") {
        			sheetObj.SetCellValue(row, "data_changed","C");
        		}
        	}
        	break;
        case "hq_ev_cd":
        	if (sheetObj.GetCellEditable(row,col)) {
        		if (sheetObj.GetCellValue(row, "data_changed") == "") {
        			sheetObj.SetCellValue(row, "data_changed","C");
        		}
        	}
        	break;
    }
}
/**
 * When click object on the screen, handles occurring event.<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return {void}
* @author
 * @version
 */
function objClick() {
    var objName=event.srcElement.name;
    var formObj=document.form;
    switch(objName) {
		case "mtch_flg":
			if (formObj.mtch_flg[0].checked) {
				formObj.val_cd.disabled=false;
				formObj.ob_ev_cd.disabled=false;
				formObj.ib_ev_cd.disabled=false;
				formObj.hq_ev_cd.disabled=false;
			} else {
				formObj.val_cd.disabled=true;
				formObj.ob_ev_cd.disabled=true;
				formObj.ib_ev_cd.disabled=true;
				formObj.hq_ev_cd.disabled=true;
			}
			break;
		case "dt_option":
			if (formObj.dt_option[0].checked) {						//BKG Period
				formObj.bkg_cre_dt_s.required=true;
				formObj.bkg_cre_dt_s.className="input1";
				formObj.bkg_cre_dt_e.required=true;
				formObj.bkg_cre_dt_e.className="input1";
				formObj.val_dt_s.required=null;
				formObj.val_dt_s.className="input";
				formObj.val_dt_e.required=null;
				formObj.val_dt_e.className="input";
				formObj.val_dt_s.value="";
				formObj.val_dt_e.value="";
				document.getElementById("bkg_dt").style.display="Inline";
				document.getElementById("rpt_dt").style.display="none";
			} else{													//Report Period
				formObj.bkg_cre_dt_s.required=null;
				formObj.bkg_cre_dt_s.className="input";
				formObj.bkg_cre_dt_e.required=null;
				formObj.bkg_cre_dt_e.className="input";
				formObj.val_dt_s.required=true;
				formObj.val_dt_s.className="input1";
				formObj.val_dt_e.required=true;
				formObj.val_dt_e.className="input1";
				formObj.bkg_cre_dt_s.value="";
				formObj.bkg_cre_dt_e.value="";
				document.getElementById("bkg_dt").style.display="none";
				document.getElementById("rpt_dt").style.display="Inline";
			}
			break;
    }
}
/**
 * When pressed the keyboard in the object, handles occurring event.<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return void
 * @author
 * @version 2009.10.01
 */
function objKeyPress() {
    var objName=event.srcElement.name;
    var formObj=document.form;
    switch(objName) {
	   case "bkg_cre_dt_s":
 	       obj_KeyPress(event.srcElement);
 		   break;
 	   case "bkg_cre_dt_e":
 	       obj_KeyPress(event.srcElement);
 		   break;
       case "bkg_ofc_cd":
 	       ComKeyOnlyAlphabet('upper');
           break;
	   case "val_dt_s":
 	       obj_KeyPress(event.srcElement);
 		   break;
 	   case "val_dt_e":
 	       obj_KeyPress(event.srcElement);
 		   break;
       case "val_ofc_cd":
 	       ComKeyOnlyAlphabet('upper');
           break;
       case "code_ofc_cd":
 	       ComKeyOnlyAlphabet('upper');
           break;
       case "cust_cd":
 	       ComKeyOnlyAlphabet('uppernum');
           break;
       case "bl_no":
 	       ComKeyOnlyAlphabet('uppernum');
           break;
    }
}
/**
 * When release the keyboard in the object, handles occurring event.<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return void
 * @author
 * @version
 */
function objKeyUp() {
    ComKeyEnter('LengthNextFocus');
}