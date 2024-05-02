/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0311.js
*@FileTitle  : Credit Card Search Popup 
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
 * @class STM_SAP_0311 : business script for STM_SAP_0311
 */
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();        
	var comboCnt=0;
	var gCurRow=0;
	var prefix="sheet1_";
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
				case "btn_OK":
					if(sheetObject1.RowCount()== 0){
						ComClosePopup(); 
					}else{
						comPopupOK();
					}
					break;
				case "btn_cnt" :
	        	    var v_cnt_cd=form.brnc_cnt_cd.value;
	        	    var classId="COM_ENS_0M1";
	    		    var param='?cnt_cd='+v_cnt_cd+'&classId='+classId;
	    		    var v_display="1,0,1,1,1,0,0";
	    		    var chkStr=v_display.substring(0,3)
	    		    if(chkStr == "1,0") {
	    		    	ComOpenPopup('/opuscntr/COM_ENS_0M1.do' + param, 700, 500, 'getCOM_ENS_0M1', v_display, true);
	    		    } else {
	    			    return;
	    		    }				
					break;
				case "btns_search_ctrl_ofc":
					ComOpenPopupWithTarget('STM_SAP_0001.do?ofc_cd='+document.form.crd_dtrb_ofc_cd.value, 400, 430,"ap_ofc_cd:crd_dtrb_ofc_cd", "0,0", true);
					break;
				case "btn_new":			
	    	    	formObj.reset();
					formObj.crd_no.value="";
					formObj.crd_pgm_nm.value="";
					ComSetObjValue(form.crd_pgm_cd, "");
					formObj.crd_mbr_nm.value="";
					formObj.crd_dtrb_ofc_cd.value="";
	    	    	sheetObject1.RemoveAll();
	    	        break;    	        
				case "btn_Close":
					ComClosePopup(); 
	    	        break;										
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowCodeMessage('SAP00311');
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
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);		
			ComEndConfigSheet(sheetObjects[i]);
		}
		for(var k=0; k<comboObjects.length; k++){
			initCombo(comboObjects[k],k+1);
		}		
	    initControl();
	    //doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);  //combo_jsw mod
	    doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
	}
	//combo_jsw start
	/**
	 * Combo Setting default
	 * @param	{IBMultiCombo}	combo_obj.
	 * @param	{Number}	comboNo		Sequence number from combo object tag id
	 */
	function initCombo (comboObj, comboNo) {
	    var formObject=document.form
	    switch(comboNo) {
			   case 1:
				   with (comboObj) {
		        	   	SetDropHeight(200);
		 			   	SetMultiSelect(0);
		 			   	SetUseAutoComplete(1);
		 			   	SetMaxSelect(1);
		 			   	SetTitle("Code|Desc");
		 			   	SetTitleVisible(true);
						SetColAlign(0, "left");
						SetColAlign(1, "left");
						SetColWidth(0, "60");
						SetColWidth(1, "120");
			       }
	               break;
			   default :
		           with (comboObj) {
			       }
	           break;
	     }
	}
	//combo_jsw end
	/**
	 * loading HTML Control event <br>
	 * {@link #loadPage} function call this. so IBSheet Object is initialized. <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {int}     sheetNo     sequence number in sheetObjects array
	 **/
	function initControl() {
		DATE_SEPARATOR="-";
		var formObj=document.form;
		axon_event.addListenerFormat('beforedeactivate', 'obj_blur'    , formObj);
	//	  axon_event.addListenerFormat('beforeactivate'  , 'obj_focus'   , formObj);
	//    axon_event.addListenerFormat('keypress'        , 'obj_keypress', formObj);
	//    axon_event.addListenerFormat('keyup'           , 'form_keyup'  , formObj);
	}
	function obj_blur(){
	    ComChkObjValid(ComGetEvent());
		var src=ComGetEvent("name")
	}
//	function obj_focus(){
//	    ComClearSeparator(ComGetEvent());
//	}
//	function obj_keypress(){
//		var src=ComGetEvent("name")
//	}
//	function form_keyup(){
//		ComKeyEnter('lengthnextfocus');
//	}
	function obj_onclick(){
		var src=ComGetEvent("name")
	}
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;	
		switch (sheetNo) {
		case 1: //t1sheet1 init
		    with(sheetObj){
			      var HeadTitle1="||Card Number|Card Program Name|Card Program Code|Card Currency|Card Brand|Card Member Name|Department Name|Distribute Date|Card Receipt Office|Inactive On|Card Program Type|Card Supplier No|Card Supplier Name|Card COA Sequence|Coa Company Code|Coa Region Code|Coa Center Code|Coa Account Code|Coa InterCompany Code|Coa VVD Code|Card Description|Expiration Date";
			      var headCount=ComCountHeadTitle(HeadTitle1);
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			             {Type:"Text",      Hidden:1, Width:200,  Align:"Center",  ColMerge:1,   SaveName:"crd_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:1,   SaveName:"crd_no",           KeyField:0,   CalcLogic:"",   Format:"CardNo",      PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:1,   SaveName:"crd_pgm_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"crd_pgm_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"crd_pgm_curr_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"crd_brnd_lu_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"crd_mbr_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"crd_dept_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"crd_dtrb_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"crd_dtrb_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"crd_inact_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:200,  Align:"Center",  ColMerge:1,   SaveName:"crd_tp_lu_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:200,  Align:"Center",  ColMerge:1,   SaveName:"vndr_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:200,  Align:"Center",  ColMerge:1,   SaveName:"vndr_lgl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:200,  Align:"Center",  ColMerge:1,   SaveName:"crd_cd_cmb_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:200,  Align:"Center",  ColMerge:1,   SaveName:"sgm_ctnt1",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:200,  Align:"Center",  ColMerge:1,   SaveName:"sgm_ctnt2",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:200,  Align:"Center",  ColMerge:1,   SaveName:"sgm_ctnt3",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:200,  Align:"Center",  ColMerge:1,   SaveName:"sgm_ctnt4",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:200,  Align:"Center",  ColMerge:1,   SaveName:"sgm_ctnt5",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:200,  Align:"Center",  ColMerge:1,   SaveName:"sgm_ctnt6",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:200,  Align:"Left",    ColMerge:1,   SaveName:"crd_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:200,  Align:"Center",  ColMerge:1,   SaveName:"crd_exp_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			      InitColumns(cols);
			      SetEditable(1);
			      //etSheetHeight(330);
			      resizeSheet();
	            }
		    break;
		}
	}
	// handling sheet process, 서버 호출 펑션
	function doActionIBSheet(sheetObj, formObj, sAction) {
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		switch (sAction) {		
	    case IBCLEAR: // open
	    	//combo_jsw start
	 		var crdPgmComboItems=SapGetComboItems(sheetObjects[0], "CARD COMPANY CODE", "");
	 		SapAddComboItem(comboObjects[0], crdPgmComboItems, "2", "", ""); 
	    	break;    		
	    	//combo_jsw end
		case IBSEARCH: //retrieve
			formObj.f_cmd.value=SEARCH;			
			sheetObj.DoSearch("STM_SAP_0311GS.do", FormQueryString(formObj) );
			break;
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
			case IBSEARCH: //retrieve
				break;
		}
		return true;
	}
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		for (var i=sheetObj.HeaderRows(); i<= sheetObj.LastRow(); i++){
			}
	}
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var sName=sheetObj.ColSaveName(Col);
		var formObj=document.form;
	}
	//PARAMETER
	function sheet1_OnDblClick(sheetObj, Row, Col) {
		 comPopupOK();
	}
	//PARAMETER
	function sheet1_OnClick(sheetObj, Row, Col){
		window.returnValue=sheetObj.GetCellValue(sheetObj.GetSelectRow(), 'crd_no');
		window.returnValue=sheetObj.GetCellValue(sheetObj.GetSelectRow(), 'crd_seq');
	}
	/**
	 * Only one Optional check by Radio button from Pop-up
	 */
	function getCOM_ENS_0M1(rowArray) {
		var colArray=rowArray[0];	
		document.all.brnc_cnt_cd.value=colArray[3];
	}
	/**
	 *  card company code - OnChange
	 */
	function crd_pgm_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj) {
		var formObj=document.form;
		var code=comboObj.FindItem(comboObj.GetSelectCode(), 0);
		if (code != null && code != "") {
			formObj.crd_pgm_cd.value=comboObj.GetText(code, 0);
			//formObj.crd_pgm_cd_text.value=comboObj.GetText(code, 1);
		}
	}
	function resizeSheet(){
	    ComResizeSheet(sheetObjects[0]);
	}
	