/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_3018.js
*@FileTitle  : Publication Date Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/17
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class Commodity Group : business script for Commodity Group 
     */
    function ESM_PRI_3018() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
	// Common Global Variable
	var sheetObjects=new Array();
	var sheetCnt=0;
    var beforeIndex=-1;
    var curPntViaType="";
    var curOrgDestType="";
	// Event handler processing by button click event*/
	document.onclick=processButtonClick;
	/**
	 * Event handler processing by button name  <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     processButtonClick();
	 * </pre>
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
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
				doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
				break;
			case "btn_close":
				ComClosePopup(); 
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
	 * adding process for list in case of needing batch processing with other items<br>
	 * defining list on the top of source <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     setSheetObject(sheetObj);
	 * </pre>
	 * @param {ibsheet} sheet_obj Mandatory IBSheet Object
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
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
	 * @version 2009.05.01
	 */
	function loadPage() {
		
		if (!opener) opener = window.dialogArguments;
		if (!opener) opener = window.opener;
		if (!opener) opener = parent;
		
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
            sheetObjects[i].SetWaitImageVisible(0);
			ComEndConfigSheet(sheetObjects[i]);
		}
		document.form.pub_dt.focus();
	}
		
	/**
	 * handling Onbeforedeactivate event<br>
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
		ComChkObjValid(event.srcElement);
	}
	/**
	 * setting sheet initial values and header <br>
	 * adding case as numbers of counting sheets  <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     initSheet(sheetObj,1);
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {int} sheetNo Mandatory IBSheet Object ,Serial no for Tag's ID
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch (sheetID) {
		case "sheet1":
		    with(sheetObj){
	      
	      var HeadTitle="status";

	      SetConfig( { SearchMode:2, Page:20, FrozenCol:0, DataRowMerge:1 } );

	      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
	      InitHeaders(headers, info);

	      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" } ];
	       
	      InitColumns(cols);

	      SetVisible(0);
	         }

			break;
		}
	}
	/**
	 * Handling sheet's processes <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {form} formObj Mandatory html form object
	 * @param {int} sAction Mandatory ,Process Flag constant variable
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
        try {
            if (window.event == null || window.event.srcElement == null || window.event.srcElement.getAttribute("suppressWait") != "Y") {
                ComOpenWait(true);
            }
			switch (sAction) {
	        case IBSAVE: // OK
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	            if (!ComShowCodeConfirm("PRI01032", "Publish")) {
	                return false;
	            }
	            formObj.f_cmd.value=MODIFY13;
	            var sParam=FormQueryString(formObj) + "&" + ComPriSetPrifix(opener.sheetObjects[0].GetSaveString(false, true, "chk"), "sheet1_");
 	            var sXml=sheetObj.GetSaveData("ESM_PRI_3018GS.do", sParam);
 	            sheetObjects[0].LoadSaveData(sXml);
	            opener.reloadRate4PublishAll(formObj.pub_dt.value);
	            ComShowCodeMessage("PRI05007");
	            ComClosePopup(); 
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
        }
	}
	/**
	 * handling process for input validation <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     if (validateForm(sheetObj,document.form,IBSAVE)) {
	 *         handling logic;
	 *     }
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {form} formObj Mandatory html form object
	 * @param {int} sAction Mandatory ,Process Flag constant variable
	 * @returns bool <br>
	 *          true  : valid<br>
	 *          false : invalid
	 * @author 
	 * @version 2009.05.01
	 */
    function validateForm(sheetObj, formObj, sAction) {
        switch (sAction) {
        case IBSAVE: // Saving
			if (formObj.pub_dt.value == "") {
				ComShowCodeMessage('PRI00316', '[New Publication Date]');
				return false;
			}
            var sCheckedRows=opener.sheetObjects[0].FindCheckedRow("chk");
            var arrCheckedRows=sCheckedRows.split("|");
        	for (var i=0; i < arrCheckedRows.length; i++) {
        		var amdt_seq=opener.sheetObjects[0].GetCellValue(arrCheckedRows[i], "amdt_seq");
        		var lastPubDt=ComGetMaskedValue(opener.sheetObjects[0].GetCellValue(arrCheckedRows[i], "last_pub_dt"), "ymd");
        		var expDt=ComGetMaskedValue(opener.sheetObjects[0].GetCellValue(arrCheckedRows[i], "exp_dt"), "ymd");
    			if (lastPubDt != "" && lastPubDt >= formObj.pub_dt.value) {
    				ComShowCodeMessage('PRI00321', '[New Publication Date]', '[Last Publication Date]');
    				return false;
    			}
    			if (formObj.pub_dt.value >= expDt) {
    				ComShowCodeMessage('PRI00347');
    				return false;
    			}
                if (amdt_seq == "0") {
 	            if (sheet_dateDiff(formObj.pub_dt.value, expDt, "D") < 29) {
    	            	ComShowCodeMessage("PRI05013");
                        return false;
    	            }
                }
        	}
        	return true;
            break;
        }
    }
