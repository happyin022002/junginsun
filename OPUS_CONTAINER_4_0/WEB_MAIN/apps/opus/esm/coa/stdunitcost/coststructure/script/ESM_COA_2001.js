/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_2001.js
*@FileTitle  : Register Main Group Cost Code 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

   	/* Developer's task	*/
 // Grobla Variable
/**
 * @extends 
 * @class ESM_COA_2002 : ESM_COA_2002 Business script for the UI
 */
// Grobla Variable
var sheetObjects=new Array();
var sheetCnt=0;
var G_YEAR_MONTH="";
var comboObjects=new Array();
var comboCnt=0;
/* Event handler processing by button click event */
document.onclick=processButtonClick;
	/* Event handler processing by button name */
	function processButtonClick(){
		var sheetObject=sheetObjects[0];
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
				case "btn_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;
				case "btn_rowadd":
					doActionIBSheet(sheetObject,formObject,IBINSERT);
					break;
				case "btn_downexcel":
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(ComGetMsg(OBJECT_ERROR));
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	/**
* initializing sheet
* implementing onLoad event handler in body tag
* adding first-served functions after loading screen.
	*/
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet(sheetObjects[i]);//Sheet configuration setting function(start)
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);//Sheet configuration setting function(end)
		}
		axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
    	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    	axon_event.addListenerForm('change', 'obj_change', document.form); // change
    	axon_event.addListenerForm('click', 'obj_click', document.form); // click
    	// initializing
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
	}
	/**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
	*/
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetNo) {
			case 1:	//sheet1 init
			    with(sheetObj){
					var HeadTitle1="Del.|STS|Profit Level|Main Group Cost Code|Main Group Cost Code Description";
					var headCount=ComCountHeadTitle(HeadTitle1);

					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:3, DataRowMerge:1 } );

					var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);

					var cols = [ {Type:"DelCheck",  Hidden:0, Width:25,   Align:"Left",    ColMerge:0,   SaveName:"delt_flg" },
					             {Type:"Status",    Hidden:0, Width:25,   Align:"Left",    ColMerge:0,   SaveName:"ibflag" },
					             {Type:"Combo",     Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:"stnd_cost_tp_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"mgrp_cost_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
					             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"mgrp_cost_cd_desc",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000 } ];
		       
					InitColumns(cols);

					SetEditable(1);
					SetWaitImageVisible(0);
		            SetRangeBackColor(1, 2, 1, 8,"#555555");
		            SetColProperty(0 ,"mgrp_cost_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
//		            SetSheetHeight(430);
					resizeSheet();
		      }
		      break;


		}
	}
	function initCombo() {
	 	var formObj=document.form;
	 	switch(comboObj.options.id) { 
	 		case "f_profitLevelCombo":
	 			with (comboObj) {
	 				SetMultiSelect(0);
	 				SetDropHeight(190);
	 				SetUseAutoComplete(1);
	 				GetColWidth=50;
	 			}
	 		break;
	 	}
	 }
	/**
      * init
      * @return
      */
     function initPage() {
     }
	/**
      * registering IBSheet Object as list
      * adding process for list in case of needing batch processing with other items 
      * defining list on the top of source
	*/
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	// Handling process about the sheet object
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBCLEAR:          //Inquiry
		        sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				formObj.f_cmd.value=INIT;
				var sParam=coaFormQueryString(formObj, 'f_profitLevelCombo');	 				  				
//parameter changed[check again]CLT
				var sXml=sheetObj.GetSearchData("ESM_COA_2001GS.do", sParam);
  				var arrXml=sXml.split("|$$|");
  				if (arrXml.length > 0)
					ComCoaSetIBCombo(sheetObj, arrXml[0], "stnd_cost_tp_cd", false, 0);
  				setProfitLevelCombo(sXml);					
				ComOpenWait(false);
				break	
			case IBSEARCH:  // retrieve
				if (sheetObj.IsDataModified()&& ComShowCodeConfirm("COM130504")) {
	   				//validation check
	   				if(!doActionIBSheet(sheetObj,formObj,IBSAVE)) { 
	   					return false;
	   				}
				}
				if(validateForm(sheetObj,formObj,IBSEARCH)){
					ComOpenWait(true);
					formObj.f_cmd.value=SEARCH;
					var sParam=FormQueryString(formObj);
//parameter changed[check again]CLT
					sheetObj.DoSearch("ESM_COA_2001GS.do", sParam );
					ComOpenWait(false);
				}
				break;
			case IBSAVE:		//Save
				if(validateForm(sheetObj,formObj,IBSAVE)){
					ComOpenWait(true);
					sheetObj.SetWaitImageVisible(0);
	     			formObj.f_cmd.value=MULTI;
//	     			var sParam=sheetObj.GetSaveString(false, true, "check");
	     			var sParam=sheetObj.GetSaveString(0);
//parameter changed[check again]CLT
	     			var sXml=sheetObj.GetSaveData("ESM_COA_2001GS.do", "f_cmd=" + MULTI + "&" +sParam);
	     			var dupChk=ComGetEtcData(sXml, "dup_chk");
	     			var transResultKey=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
					if((dupChk == "S"||dupChk=="") && transResultKey == "S"){
						ComShowCodeMessage("COM130102","Data");//Success
					}else if(dupChk == "Dup"){
						ComShowCodeMessage('COM12115', 'Main Group Cost Code');//Dup
						ComOpenWait(false);
						break;
					}else if(dupChk == "DescDup"){
						ComShowCodeMessage('COM12115', 'Main Group Cost Code Desc');//Desc Dup
						ComOpenWait(false);
						break;	
					}else if(dupChk == "SubEx"){
						ComShowCodeMessage('COA10064');//Child data exist
						ComOpenWait(false);
					}else{
						ComShowCodeMessage("COM12151",'Data'); //Failed 
					}
					ComOpenWait(true);
					formObj.f_cmd.value=SEARCH;
					var sParam=FormQueryString(formObj);
//parameter changed[check again]CLT
					sheetObj.DoSearch("ESM_COA_2001GS.do", sParam );
					ComOpenWait(false);
				}
	     		break;
			case IBINSERT:	// Insert
				with (sheetObjects[0]) {
			         var nowRow=GetSelectRow();
			       	 nowRow=DataInsert(-1);
			         return true;
			    }
				break;
			case IBCOPYROW:	// Row copy
				sheetObj.DataCopy();
				break;
			case IBDOWNEXCEL:	// Excell download
				if(sheetObj.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
				}else{
					var excelType=selectDownExcelMethod(sheetObj);
				}
				
				break;
		}
	}	
	function callBackExcelMethod(excelType){
		var sheetObj=sheetObjects[0];
		switch (excelType) {
	        case "AY":
	            sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
	            break;
	        case "AN":
		    	sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
		    	break;
	        case "DY":
	        	sheetObj.Down2Excel({HiddenColumn:1, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
	        	break;
	        case "DN":
		    	sheetObj.Down2Excel({HiddenColumn:1, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
		    	break;
		}
		
	}
	function setComboObject(combo_obj) {  
		comboObjects[comboCnt++]=combo_obj;  
	}
	function setProfitLevelCombo(sXml){
		var combObj=f_profitLevelCombo;
		var arrData=ComXml2ComboString(sXml, "code", "name");
		combObj.InsertItem(0, "All", "All");
		if (arrData != null){
            var arrCode=arrData[0].split("|");
            var arrName=arrData[1].split("|");
            for(i=0; i < arrName.length;i++){
    			combObj.InsertItem(i+1, arrName[i], arrCode[i]);        
            }
        }
        combObj.SetSelectText("All");
 		combObj.ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
	}
	/**
	* Handling process for form object input validation
	*/
	function validateForm(sheetObj,formObj,sAction){
		switch(sAction){	
			case IBSEARCH:
				if(ComTrim(f_profitLevelCombo.GetSelectCode()) == ""){
					ComShowCodeMessage('COM12113', 'Profit Level');//key field missing
					ComSetFocus(f_profitLevelCombo);
					return false;
				} 
				break;
			case IBSAVE:
				// key field filled ? 
				with(sheetObj){
					var j=0;
					for(var i=1;i<=sheetObj.LastRow();i++){
						if(GetCellValue(i, "ibflag")=='I'){
							j=j+1;
							if(GetCellValue(i, "stnd_cost_tp_cd")==null || GetCellValue(i, "stnd_cost_tp_cd")==""){
								ComShowCodeMessage('COM130403', 'Profit Level');//key field missing
								sheetObj.SelectCell(i, "stnd_cost_tp_cd");
								return false;
								break;
							}else if(GetCellValue(i, "mgrp_cost_cd")==null || GetCellValue(i, "mgrp_cost_cd")=="" ){
								ComShowCodeMessage('COM130403', 'Main Group Cost Code');//key field missing
								sheetObj.SelectCell(i, "mgrp_cost_cd");
								return false;
								break;
							}else if(GetCellValue(i, "mgrp_cost_cd").length!=2){
								ComShowCodeMessage('COA10067', 'Main Group Cost Code', '2');//'{?msg1} must be {?msg2} characters long.'
								sheetObj.SelectCell(i, "mgrp_cost_cd");
								return false;
								break;
							}
						}else if(GetCellValue(i, "ibflag")=='U'||GetCellValue(i, "ibflag")=='D'){
							j=j+1;
						}
					}
					if(j==0){
						ComShowCodeMessage('COA10065');
						return false;
					}
				}
				var dr=sheetObj.ColValueDup("mgrp_cost_cd");
				if(dr>0){	 	//When there are duplicate values on the sheet				
					ComShowCodeMessage('COM12115', 'Main Group Cost Code');
					sheetObj.SelectCell(dr,"mgrp_cost_cd");
					return false;
					break;
				}
				return true;
				break;
		}
		return true;
	}	

    function resizeSheet(){
   	 ComResizeSheet(sheetObjects[0]);
    }
	/* Developer's task ends */
