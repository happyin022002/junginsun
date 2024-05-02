﻿/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_3015.js
*@FileTitle : Publication Date Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
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
    function ESM_PRI_3015() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
	// global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
    var bIsReqUsr=false;
    var bIsAproUsr=false;
    var beforeIndex=-1;
    var curPntViaType="";
    var curOrgDestType="";
	//Event handler processing by button click event */
	document.onclick=processButtonClick;
	/**
	 * Event handler processing by button name  <br>
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
	 * adding process for list in case of needing batch processing with other items  <br>
	 * defining list on the top of source <br>
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * Initializing and setting Sheet basics <br>
	 * Setting body tag's onLoad event handler <br>
	 * Adding pre-handling function after loading screen on the browser  <br>
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
		bIsReqUsr=document.form.is_req_usr.value.toLowerCase() == "true" ? true : false;
		bIsAproUsr=document.form.is_apro_usr.value.toLowerCase() == "true" ? true : false;
    	if (bIsAproUsr
    			&& document.form.prop_sts_cd.value == "A") {
        	enableButton("btn_ok");
    	} else {
    		disableButton("btn_ok");    	
    	}
//    	if (document.form.amdt_seq.value == "0") {
//    		document.form.exp_dt.readOnly = false;
//    	} else {
//    		document.form.exp_dt.readOnly = true;
//    	}
		axon_event.addListenerFormat('keypress', 'obj_keypress', document.form);
		document.form.pub_dt.focus();
	}
	/**
	 * handling OnKeyPress events <br>
	 */
	function obj_keypress() {
		switch (event.srcElement.dataformat) {
		case "float":
				ComKeyOnlyNumber(event.srcElement, ".");
				break;
		default:
			ComKeyOnlyNumber(event.srcElement);
			break;
		}
	}
	
	/**
	 * setting sheet initial values and header <br>
	 * adding case as numbers of counting sheets <br>
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch (sheetID) {
		case "sheet1":
		    with(sheetObj){
			        if (location.hostname != "")
			      var HeadTitle="status";
		
			     
		
			      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
		
			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" } ];
			       
			      InitColumns(cols);
			      SetConfig( { SearchMode:2, Page:20, DataRowMerge:1 } );
			      SetVisible(0);
	            }


			break;
		}
	}
	/**
	 * Handling sheet process <br>
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
        try {
            if (ComGetEvent() == null ||$(ComGetEvent()).attr('suppressWait')!= "Y") {
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
	            formObj.f_cmd.value=MODIFY05;
	            var sParam=FormQueryString(formObj)+"&eff_dt="+formObj.disp_eff_dt.value+"&exp_dt="+formObj.disp_exp_dt.value;
	            var sXml=sheetObj.GetSaveData("ESM_PRI_3015GS.do", sParam);
	            sheetObjects[0].LoadSaveData(sXml);
	            opener.reloadRateReverse();
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
	 * checking validation process of inputed form data <br>
	 */
    function validateForm(sheetObj, formObj, sAction) {
        switch (sAction) {
        case IBSAVE: // save
        	if (formObj.tri_prop_no.value == "" || formObj.tri_no.value == "") {
        		return false;
        	}
			if (formObj.pub_dt.value == "") {
				ComShowCodeMessage('PRI00316', '[New Publication Date]');
				return false;
			}
			if (formObj.exp_dt.value == "") {
				ComShowCodeMessage('PRI00316', '[New Expiration Date]');
				return false;
			}
			if (formObj.last_pub_dt.value != "" && formObj.last_pub_dt.value >= formObj.pub_dt.value) {
				ComShowCodeMessage('PRI00321', '[New Publication Date]', '[Last Publication Date]');
				return false;
			}
			if (formObj.pub_dt.value >= formObj.exp_dt.value) {
				ComShowCodeMessage('PRI00347');
				return false;
			}
            if (document.form.amdt_seq.value == "0") {
            	/*if (sheetObj.EvalDateDiff("D", formObj.pub_dt.value, formObj.exp_dt.value) < 29) {
	            	ComShowCodeMessage("PRI05014");
                    return false;
	            }*/
            	if(ComGetDaysBetween(formObj.pub_dt.value, formObj.exp_dt.value) < 30){
            		ComShowCodeMessage("PRI05014");
                    return false;
            	}
            }
            
            return true;
            break;
        }
    }
    
    
