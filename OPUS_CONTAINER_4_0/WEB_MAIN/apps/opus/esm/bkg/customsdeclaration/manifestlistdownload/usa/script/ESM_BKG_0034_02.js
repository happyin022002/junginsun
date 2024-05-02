/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0034_02.js
*@FileTitle  : B/L Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/09
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * @extends
	 * @class ESM_BKG_0034_02 : business script for ESM_BKG_0034_02 
	 */
	function ESM_BKG_0034_02() {
		this.processButtonClick=tprocessButtonClick;
		this.setSheetObject=setSheetObject;
		this.loadPage=loadPage;
		this.initSheet=initSheet;
		this.doActionIBSheet=doActionIBSheet;
		this.validateForm=validateForm;
	}
	// Common global variable
	var tabObjects=new Array();
	var tabCnt=0;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick() {
		var sheetObject1=sheetObjects[0];
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch (srcName) {
				case "btn_cust_f":
					document.form.cust_tp.value="F";
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCHAPPEND);
					break;
				case "btn_cust_a":
					document.form.cust_tp.value="A";
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
	 * registering IBSheet Object as list 
	 * adding process for list in case of needing batch processing with other items 
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
		// loading tab to retrieve data after loading screen
    	//parent.loadTabPage(1);
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
	            var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                   {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"bkg_cust_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                   {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cust_cnt_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                   {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cust_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                   {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"phn_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                   {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"fax_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                   {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cust_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                   {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cust_addr",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	            InitColumns(cols);
			}
			break;
		}
	}
	/**
	 * t2sheet1 - handling event after retrieving
	 */
	function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        var formObj = document.form;
        if (sheetObj.RowCount() == 2) {
            IBS_CopyRowToForm(sheetObj, document.form, 1, "antf_");
            IBS_CopyRowToForm(sheetObj, document.form, 2, "fwdr_");
        } else {
            formObj.reset();
        }
	}
	/**
	 * t2sheet2 - handling event after retrieving
	 */
	function t2sheet2_OnSearchEnd(sheetObj2, ErrMsg)  {
		var formObj=document.form;
		var custTp=formObj.cust_tp.value;	
		 if (ErrMsg == "") {
			if(custTp == "A"){
				formObj.antf_cust_nm.value=sheetObj2.GetEtcData("cust_nm");
				formObj.antf_cust_addr.value=sheetObj2.GetEtcData("cust_addr");
			}
			else if(custTp == "F"){
				formObj.fwdr_cust_nm.value=sheetObj2.GetEtcData("cust_nm");
				formObj.fwdr_cust_addr.value=sheetObj2.GetEtcData("cust_addr");
			}
		 }
		 else{
			if(custTp == "A"){
				formObj.antf_cust_nm.value="";
				formObj.antf_cust_addr.value="";
			}
			else if(custTp == "F"){
				formObj.fwdr_cust_nm.value="";
				formObj.fwdr_cust_addr.value="";
			}
		 }
	}
	/**
	 * handling process for Sheet
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		//sheetObj.ShowDebugMsg = false;
		switch (sAction) {
			case IBSEARCH: // 
				if (validateForm(sheetObj,formObj,sAction)) {
					//ComOpenWait(true);
					formObj.f_cmd.value=SEARCH01;
 					//sheetObj.DoSearch("ESM_BKG_0034_02GS.do", FormQueryString(formObj) );
					var sXml = sheetObj.GetSearchData("ESM_BKG_0034_02GS.do", FormQueryString(formObj));
					if (sXml != "") sheetObj.LoadSearchData(sXml,{Sync:1} );
				}
				break;
			case IBSEARCHAPPEND: //
				if (!validateForm(sheetObj,formObj,sAction)) return false;
//				ComOpenWait(true);
				formObj.f_cmd.value=MODIFY02;
				var custTp=formObj.cust_tp.value;
				var sheetObj2=sheetObjects[1];
				sheetObj2.RemoveEtcData();
 				sheetObj2.DoSearch("ESM_BKG_0034_02GS.do", FormQueryString(formObj) );
//				ComOpenWait(false);
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSEARCH: // 
			if (formObj.bl_no.value == "") {
				return false;
			}
			return true;
			break;
		case IBSEARCHAPPEND: // 
			var cust_cnt;
			var cust_seq;
			if (formObj.cust_tp.value == "F"){
				cust_cnt=formObj.fwdr_cust_cnt_cd;
				cust_seq=formObj.fwdr_cust_seq;
			}
			else if (formObj.cust_tp.value == "A"){
				cust_cnt=formObj.antf_cust_cnt_cd;
				cust_seq=formObj.antf_cust_seq;
			}
	    	if (!ComChkObjValid(cust_cnt) || !ComChkObjValid(cust_seq, true, true, false)) return false;
	    	return true;
			break;
		}
	}
	/**
	 * retrieving when clicking tab
	 */
	function tabLoadSheet(strBlNo) {
		var formObject=document.form;
		formObject.bl_no.value=strBlNo;
		doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
	}
	/**
	 * initializing data
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
	 * activating tab 
	 */
	var enableFlag=true;
	function tabEnableSheet(flag) {
		var formObject=document.form;
		enableFlag=flag;
		sheetObjects[0].SetEditable(flag);
	}
	/**
	 * creating data string to save
	 */
	function getSaveString() {
		var newParam=ComSetPrifix(FormQueryString(document.form), "t2_new_");
		var oldParam=ComSetPrifix(sheetObjects[0].GetSaveString(true), "t2_old_");
		return newParam + "&" + oldParam;
	}
	/**
	 * getting form data 
	 */
	function getFormString(str) {
		var obj=document.getElementsByName(str);
		return ComReplaceStr(ComReplaceStr(obj[0].value, '[', '('), ']', ')');
	}
    /**
     * onKeyPress event : limiting the number of TextArea line
     */
    function fncTextareaMaxLine(obj, maxLine) {
   	    var str_len=obj.value;
   	    line=str_len.split("\r\n");
   	    ln=line.length;
   	    if(ln == maxLine && event.keyCode == 13) { 	  
   		    event.returnValue=false;
   	    }
    }
    
  
