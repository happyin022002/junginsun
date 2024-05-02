/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0034_01.js
*@FileTitle  : B/L Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/09
=========================================================*/
/****************************************************************************************
Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * @extends
	 * @class business script for ESM_BKG_0034_01
	 */
	function ESM_BKG_0034_01() {
		this.processButtonClick=tprocessButtonClick;
		this.setSheetObject=setSheetObject;
		this.loadPage=loadPage;
		this.initSheet=initSheet;
		this.doActionIBSheet=doActionIBSheet;
		this.validateForm=validateForm;
	}
	/* developer job	*/
	// common global variables
	var tabObjects=new Array();
	var tabCnt=0;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Event handler processing by button click event
	document.onclick=processButtonClick;
	// Event handler processing by button name
	function processButtonClick() {
		var sheetObject1=sheetObjects[0];
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch (srcName) {
				case "btn_cust_s":
					document.form.cust_tp.value="S";
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCHAPPEND);
					break;
				case "btn_cust_c":
					document.form.cust_tp.value="C";
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCHAPPEND);
					break;
				case "btn_cust_n":
					document.form.cust_tp.value="N";
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCHAPPEND);
					break;
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	/**
	 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items 
	 * defining list on the top of source
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
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
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		//parent.loadTabPage();
	}

	/**
 	 * setting sheet initial values and header
 	 * param : sheetObj, sheetNo
 	 * adding case as numbers of counting sheets
 	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		switch(sheetNo) {
		case 1:
		case 2:
			with (sheetObj) {
		    if (location.hostname != "")
		    	   var HeadTitle="|cust_tp_cd|cust_cnt_cd|cust_seq|phn|fax|name|address";
		    	   SetConfig( { SearchMode:2, Page:20, DataRowMerge:1 } );
		    	   var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		    	   var headers = [ { Text:HeadTitle, Align:"Center"} ];
		    	   InitHeaders(headers, info);
		    	   var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		    	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"bkg_cust_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cust_cnt_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cust_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"phn_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"fax_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cust_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cust_cty_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cust_ste_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cstms_decl_cnt_cd",KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cust_zip_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"eur_cstms_st_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cust_addr",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		    	    
		    	   InitColumns(cols);

		}
			break;
		}
	}
	// handling of Sheet process
	function doActionIBSheet(sheetObj, formObj, sAction) {
		//sheetObj.ShowDebugMsg = false;
		switch (sAction) {
			case IBSEARCH: // retrieve
				if (validateForm(sheetObj,formObj,sAction)) {
					//ComOpenWait(true);
					formObj.f_cmd.value=SEARCH01;
 					//sheetObj.DoSearch("ESM_BKG_0034_01GS.do", FormQueryString(formObj) );
					var sXml = sheetObj.GetSearchData("ESM_BKG_0034_01GS.do", FormQueryString(formObj) );
					if (sXml != "") sheetObj.LoadSearchData(sXml,{Sync:1} );

					//ComOpenWait(false);
				}
				break;
			case IBSEARCHAPPEND: 
				if (!validateForm(sheetObj,formObj,sAction)) return false;
//				ComOpenWait(true);
				formObj.f_cmd.value=MODIFY01;
				var custTp=formObj.cust_tp.value;
				var sheetObj2=sheetObjects[1];
				sheetObj2.RemoveEtcData();
 				sheetObj2.DoSearch("ESM_BKG_0034_01GS.do", FormQueryString(formObj) );
//				ComOpenWait(false);
		}
	}
    /**
     * handling process for input validation
     */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSEARCH: // retrieve
			if (formObj.bl_no.value == "") {
				return false;
			} else {
				return true;
			}
			break;
		case IBSEARCHAPPEND: 
			var cust_cnt;
			var cust_seq;
			if (formObj.cust_tp.value == "S"){
				cust_cnt=formObj.shpr_cust_cnt_cd;
				cust_seq=formObj.shpr_cust_seq;
			}
			else if (formObj.cust_tp.value == "C"){
				cust_cnt=formObj.cnee_cust_cnt_cd;
				cust_seq=formObj.cnee_cust_seq;
			}
			else if (formObj.cust_tp.value == "N"){
				cust_cnt=formObj.ntfy_cust_cnt_cd;
				cust_seq=formObj.ntfy_cust_seq;
			}
	    	if (!ComChkObjValid(cust_cnt) || !ComChkObjValid(cust_seq, true, true, false)) return false;
	    	return true;
			break;
		}
	}
	/**
	 * process of retrieve end
	 */
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg)  {
		var idx;
		var formObj = document.form; 
		if( sheetObj.RowCount()> 0 ) {
			
			idx=sheetObj.FindText("bkg_cust_tp_cd", "C");
			if(idx > 0) IBS_CopyRowToForm(sheetObj, document.form, idx, "cnee_");
			idx=sheetObj.FindText("bkg_cust_tp_cd", "N");
			if(idx > 0) IBS_CopyRowToForm(sheetObj,  document.form, idx, "ntfy_");
			idx=sheetObj.FindText("bkg_cust_tp_cd", "S");
			if(idx > 0) IBS_CopyRowToForm(sheetObj,  document.form, idx, "shpr_");
		}else{
			formObj.reset();
		}
		
		if (sheetObj.GetTotalRows()== 0) {
			sheetObj.RemoveAll();
			var row=sheetObj.DataInsert();
			sheetObj.SetCellValue(row,"bkg_cust_tp_cd","C");
			row=sheetObj.DataInsert();
			sheetObj.SetCellValue(row,"bkg_cust_tp_cd","N");
			row=sheetObj.DataInsert();
			sheetObj.SetCellValue(row,"bkg_cust_tp_cd","S");
		}
		
	}
	/**
	 *After you click the arrow key to set the queried data
	 */
	function t1sheet2_OnSearchEnd(sheetObj2, ErrMsg)  {
		 if (ErrMsg == "") {
			var formObj=document.form;
			var custTp=formObj.cust_tp.value;	
			if(custTp == "C"){
				formObj.cnee_cust_nm.value=sheetObj2.GetEtcData("cust_nm");
				formObj.cnee_cust_addr.value=sheetObj2.GetEtcData("cust_addr");
			}
			else if(custTp == "N"){
				formObj.ntfy_cust_nm.value=sheetObj2.GetEtcData("cust_nm");
				formObj.ntfy_cust_addr.value=sheetObj2.GetEtcData("cust_addr");
			}
			else if(custTp == "S"){
				formObj.shpr_cust_nm.value=sheetObj2.GetEtcData("cust_nm");
				formObj.shpr_cust_addr.value=sheetObj2.GetEtcData("cust_addr");
			}
		}
	}
	/**
	 * Click the tab of a query
	 */
	function tabLoadSheet(strBlNo) {
		var formObject=document.form;
		formObject.bl_no.value=strBlNo;
		doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
	}
	/**
	 * Entry forms, sheets initialization
	 */
	function tabClearSheet() {
		var frmChild=document.getElementsByTagName("input");
		for(var i=0; i<frmChild.length; i++){
			if(frmChild[i].type != "hidden") {
	    		frmChild[i].value="";
			}
	    }
		var frmChild2=document.getElementsByTagName("textarea");
		for(var i=0; i<frmChild2.length; i++){
    		frmChild2[i].value="";
	    }
		sheetObjects[0].RemoveAll();
	}
	/**
	 * Activation Tab
	 */
	var enableFlag=true;
	function tabEnableSheet(flag) {
		var formObject=document.form;
		enableFlag=flag;
		sheetObjects[0].SetEditable(flag);
	}
	/**
	 * To save the generated data strings
	 */
	function getSaveString() {
		var newParam=ComSetPrifix(FormQueryString(document.form), "t1_new_");
		var oldParam=ComSetPrifix(sheetObjects[0].GetSaveString(true), "t1_old_");
		return newParam + "&" + oldParam;
	}
	/**
	 * form returns the data value
	 */
	function getFormString(str) {
		var obj=document.getElementsByName(str);
		return ComReplaceStr(ComReplaceStr(obj[0].value, '[', '('), ']', ')');
	}
    /**
     * TextArea to limit the number of lines<br>
     */
    function fncTextareaMaxLine(obj, maxLine) {
   	    var str_len=obj.value;
   	    line=str_len.split("\r\n");
   	    ln=line.length;
   	    if(ln == maxLine && event.keyCode == 13) { 	  
   		    event.returnValue=false;
   	    }
    }
     /* developers work end */
