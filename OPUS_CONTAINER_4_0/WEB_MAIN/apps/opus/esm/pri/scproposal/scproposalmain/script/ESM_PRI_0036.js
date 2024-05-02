/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0036.js
*@FileTitle  : Amendment Request
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/28
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
               MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
               OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_PRI_0036 :business script for ESM_PRI_0036.
     */
	var sheetObjects=new Array();
	var sheetCnt=0;
	var sysdate="";
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
    /**
     * Event handler processing by button name <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return N/A
     * @author 
     * @version 2009.04.17
     */
	function processButtonClick() {
		var sheetObject1=sheetObjects[0];
		/** **************************************************** */
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
				case "btn_ok":
					var rtn=doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
					if(rtn){
						ComPopUpReturnValue(rtn);
					}
					break;
				case "btn_close":
					ComPopUpReturnValue(false);
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
    * registering IBSheet Object as list <br>
    * adding process for list in case of needing batch processing with other items  <br>
    * defining list on the top of source <br>
    * <br><b>Example :</b>
    * <pre>
    *     setSheetObject(sheetObj);
    * </pre>
    * @param {ibsheet} sheet_obj Mandatory IBSheet Object
    * @return N/A
    * @author 
    * @version 2009.04.17
    */   
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
    /**
    * initializing sheet <br>
    * implementing onLoad event handler in body tag <br>
    * adding first-served functions after loading screen. <br>
    * <br><b>Example :</b>
    * <pre>
    *     loadPage();
    * </pre>
    * @return N/A
    * @author 
    * @version 2009.04.17
    */
	function loadPage() {
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}		
//		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);	
		initControl();
//		sheet1_OnLoadFinish(sheet1);
		sheetObj.SetWaitImageVisible(0);
  	 	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);	
        sheetObj.SetWaitImageVisible(1);
		var formObj=document.form;
	}
	  /**
	    *event in case of succesful creating Object instance<br>
	    * <br><b>Example :</b>
	    * <pre>
	    *    
	    * </pre>
	    * @param {ibsheet} sheetObj Mandatory IBSheet Object
	    * @return N/A
	    * @author 
	    * @version 2009.04.17
	    */      
//   sheet1_OnLoadFinish(sheetObj){   
//  	 	sheetObj.SetWaitImageVisible(0);
//  	 	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);	
//        sheetObj.SetWaitImageVisible(1);
//   }      
    /**
    * Catching event to handle Axon event.<br>
    * <br><b>Example :</b>
    * <pre>
    *     initControl()
    * </pre>
    * @param N/A
    * @return N/A
    * @author 
    * @version 2009.04.17
    */ 	    
    function initControl() {            
       axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
       axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);       
    }
    /**
    * handling OnBeforeActivate event <br>
    * <br><b>Example :</b>
    * <pre>
    *     obj_activate()
    * </pre>
    * @param N/A
    * @return N/A
    * @author 
    * @version 2009.04.17
    */   
    function obj_activate() {
        var formObj=document.form;
        var srcName=ComGetEvent("name");
        ComClearSeparator (ComGetEvent());
    }  
   /**
    * handling Onbeforedeactivate event. <br>
    * <br><b>Example :</b>
    * <pre>
    *     obj_deactivate()
    * </pre>
    * @param N/A
    * @return N/A
    * @author 
    * @version 2009.04.17
    */   
    function obj_deactivate() {
        var eleName=ComGetEvent("name");
        var formObj=document.form;
        var obj=ComGetEvent();
        switch(ComGetEvent("name")){ 	    	
	   		case "ctrt_eff_dt":
	   			ComChkObjValid(ComGetEvent());
	   			ComAddSeparator(obj, "ymd");
	   			break;
	   		case "ctrt_exp_dt":
	   			ComChkObjValid(ComGetEvent());
	   			ComAddSeparator(obj, "ymd");
	   			break;
		}
    }
    /**
    * setting sheet initial values and header <br>
    * adding case as numbers of counting sheets <br>
    * <br><b>Example :</b>
    * <pre>
    *     initSheet(sheetObj,1);
    * </pre>
    * @param {ibsheet} sheetObj Mandatory IBSheet Object
    * @param {int} sheetNo Mandatory IBSheet Object Tag's ID Serial No
    * @return N/A
    * @author 
    * @version 2009.04.17
    */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch (sheetID) {
			case "sheet1":
				with (sheetObj) {
			        var HeadTitle="|SC No|Prop No|Amend No.|Eff Dt|Exp Dt|Amend Effective Date";
	
			        SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
			        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			        var headers = [ { Text:HeadTitle, Align:"Center"} ];
			        InitHeaders(headers, info);
	
			        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				               {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"sc_no",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"ctrt_eff_dt",  KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"ctrt_exp_dt",  KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",       KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:0 } ];
			         
			        InitColumns(cols);
	
			        SetEditable(1);
			        SetShowButtonImage(2);
			        resizeSheet(); //SetSheetHeight(92);
				}
				break;
		}
	}
	
	function resizeSheet(){
	   	ComResizeSheet(sheetObjects[0]);
	}
	
    /**
    * Handling Sheet's process <br>
    * <br><b>Example :</b>
    * <pre>
    *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
    * </pre>
    * @param {ibsheet} sheetObj Mandatory IBSheet Object
    * @param {form} formObj Mandatory html form object
    * @param {int} sAction Mandatory ,process constant variable
    * @return N/A
    * @author 
    * @version 2009.04.17
    */ 
	function doActionIBSheet(sheetObj, formObj, sAction) {
    	try{
			sheetObj.ShowDebugMsg(false);
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);		
			switch (sAction) {
				case IBSEARCH:
					if (validateForm(sheetObj,document.form,sAction)) {
						formObj.f_cmd.value=SEARCH01;
						sheetObj.DoSearch("ESM_PRI_0036GS.do", FormQueryString(formObj) );
					} else {
						ComShowCodeMessage('PRI08001');
					}
					break;
				case IBSAVE:
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					formObj.f_cmd.value=MULTI01;
//					sheetObj.CellValue(1,"ibflag")="I";
					sheetObj.SetRowStatus(1,"I");
					var sParam=FormQueryString(formObj);
					    sParam += "&" + sheetObjects[0].GetSaveString();
					    var sXml=sheetObj.GetSaveData("ESM_PRI_0036GS.do", sParam);
					    sheetObjects[0].LoadSaveData(sXml);
					ComPriSaveCompleted();
					return true;
					break;
			}
	    } catch (e) {
	        if (e == "[object Error]") {
	            ComShowMessage(OBJECT_ERROR);
	        } else {
	            ComShowMessage(e.message);
	        }
	    } finally {
	    	ComOpenWait(false);
	    	sheetObj.SetWaitImageVisible(1);
	    }		
	}
    /**
    * handling process for input validation <br>
    * <br><b>Example :</b>
    * <pre>
    *     if (validateForm(sheetObj,document.form,IBSAVE)) {
    *     }
    * </pre>
    * @param {ibsheet} sheetObj Mandatory IBSheet Object
    * @param {form} formObj Mandatory html form object
    * @param {int} sAction Mandatory ,process constant variable
    * @return bool <br>
    *          true  : Valid<br>
    *          false : Invalid
    * @author 
    * @version 2009.04.17
    */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSEARCH: 
			if (formObj.sc_no.value == "" ) {
				return false;
			} else {
				return true;
			}
			break;
		case IBSAVE: 
			var sEffDt=document.form.sEffDt.value;
			var sExpDt=document.form.sExpDt.value;
			var value=sheetObjects[0].GetCellValue(1,"eff_dt");
			if(sEffDt>=value||sExpDt<value){
				ComShowCodeMessage("PRI01018","["+sEffDt+"]","["+sExpDt+"]");				
				sheetObj.SetCellValue(1,"eff_dt",sEffDt,0);
				sheetObj.SelectCell(1,"eff_dt", true);
				return false;
			}
			return true;
			break;
		}
	}
    /**
    * calling function in case of OnSearchEnd event <br>
    * Setting sheet's value to Html Object after retrieving<br>
    * <br><b>Example :</b>
    * <pre>
    * 	sheet1_OnSearchEnd(sheetObj, errMsg)
    * </pre>
    * @param {ibsheet} sheetObj Mandatory IBSheet Object
    * @param {string} ErrMsg Mandatory from server
    * @return N/A
    * @author 
    * @version 2009.05.20
    */ 	
	function sheet1_OnSearchEnd(sheetObj, errMsg){
		var formObj=document.form;
		formObj.ctrt_eff_dt.value=ComGetMaskedValue(sheetObj.GetCellValue(1,"ctrt_eff_dt"),"ymd");
		formObj.ctrt_exp_dt.value=ComGetMaskedValue(sheetObj.GetCellValue(1,"ctrt_exp_dt"),"ymd");
		sheetObj.SelectCell(1,"eff_dt", true);
		sysdate=sheetObj.GetCellValue(1,"eff_dt");
	}
    /**
    * Calling function in case of Onchange Event <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj Mandatory IBSheet Object
    * @param {int} Row Mandatory Onclick ,Cell's Row Index
    * @param {int} Col Mandatory Onclick ,Cell's Column Index
    * @return N/A
    * @author 
    * @version 2009.04.17
    */	
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var sEffDt=document.form.sEffDt.value;
		var sExpDt=document.form.sExpDt.value;
		if(sEffDt>=Value||sExpDt<Value){
			ComShowCodeMessage("PRI01018","["+sEffDt+"]","["+sExpDt+"]");
			sheetObj.SetCellValue(1,"eff_dt",sysdate,0);
			sheetObj.SelectCell(1,"eff_dt", true);
			return;
		}
	}
