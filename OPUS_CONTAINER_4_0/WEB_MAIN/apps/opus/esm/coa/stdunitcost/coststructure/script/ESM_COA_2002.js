/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_2002.js
*@FileTitle  : Register Sub Group Cost Code
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/27
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_COA_2002 : ESM_COA_2002 business script for
     */
/* developer job	*/
 // common global variables
/**
 * @extends 
 * @class ESM_COA_2002 : ESM_COA_2002 business script for
 */
// common global variables
var sheetObjects=new Array();
var sheetCnt=0;
var G_YEAR_MONTH="";
var comboXml=new Array();
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
//					doActionIBSheet(sheetObject,formObject,MULTI);
					break;
				case "btn_rowadd":
					doActionIBSheet(sheetObject,formObject,IBINSERT);
					var Row = sheetObject.LastRow();
					sheetObject.SetCellValue(Row, "stnd_cost_tp_cd", "");
					sheetObject.SetCellValue(Row, "mgrp_cost_cd_desc","");
					sheetObject.SetCellValue(Row, "mgrp_cost_cd","");
					break;
				case "btn_downexcel":
					if(sheetObject.RowCount() < 1){//no data	
						ComShowCodeMessage("COM132501");
					}else{	
						doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					}	
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
			ComConfigSheet(sheetObjects[i]);//
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);//
		}
//		axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
//    	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
//    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    	axon_event.addListenerForm('change', 'obj_change', document.form); // change
    	axon_event.addListenerForm('click', 'obj_click', document.form); // click
    	//initial setting
    	//initPage();
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
//		btn_retrieve.focus();
		for ( var k=0; k < comboObjects.length; k++) {
			initCombo(comboObjects[k]);
			//SetSelectedIndex(0);
		}
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
//		        (7, 3, 0, true);
			      var HeadTitle1="Del.|STS|Profit Level|Main Group Cost Code|Main Group Cost Code Description|Sub Group Cost Code|Sub Group Cost Code Description";
			      var headCount=ComCountHeadTitle(HeadTitle1);
	
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
			      var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
	
			      var cols = [ {Type:"DelCheck",  Hidden:0, Width:25,   Align:"Left",    ColMerge:0,   SaveName:"delt_flg" },
			             {Type:"Status",    Hidden:0, Width:25,   Align:"Left",    ColMerge:0,   SaveName:"ibflag" },
			             {Type:"Combo",     Hidden:0, Width:140,  Align:"Left",    ColMerge:1,   SaveName:"stnd_cost_tp_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"mgrp_cost_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Combo",     Hidden:0, Width:240,  Align:"Left",    ColMerge:1,   SaveName:"mgrp_cost_cd_desc",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"sgrp_cost_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 },
			             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"sgrp_cost_cd_desc",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000 } ];
			       
			      InitColumns(cols);
	
			      SetEditable(1);
			      SetWaitImageVisible(0);
			      SetRangeBackColor(1, 2, 1, 8,"#555555");
	              SetColProperty(0 ,"sgrp_cost_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
//			      SetSheetHeight(470);
				  resizeSheet();
			      InitComboNoMatchText(1,"",1);
		      }

			break;
		}
	}
	function sheet1_OnChange(sheetObj , Row, Col, Val){
		if(Col=="stnd_cost_tp_cd"||Col==2){
			if(sheetObj.GetCellValue(Row, "ibflag")=='I'){
				FromComCoaSetIBCombo(Val,sheetObj, comboXml[1], "mgrp_cost_cd_desc", false, 0, Row);
				sheetObj.SetCellValue(Row, "mgrp_cost_cd_desc","",0);
				sheetObj.SetCellValue(Row, "mgrp_cost_cd","",0);
			}
		}
		if(Col=="mgrp_cost_cd_desc"||Col==4){
			
			sheetObj.SetCellValue(Row,"mgrp_cost_cd",Val,0);
		}
	}
	function initCombo(comboObj) {
//	 	var comboObj = document.form;
	 	switch(comboObj.options.id) { 
	 		case "f_profitLevelCombo":
	 			with (comboObj) {
	 				SetMultiSelect(0);
	 				SetUseAutoComplete(1);
	 				SetDropHeight(190);
	 				SetSelectIndex(0);
	 			}
	 		break;
	 		case "f_mainGroupCombo":
	 			with (comboObj) {
	 				SetMultiSelect(0);
	 				SetUseAutoComplete(1);
	 				SetDropHeight(190);
	 				SetSelectIndex(0);
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
	* registering IBCombo Object as list
	* adding process for list in case of needing batch processing with other items
	* defining list on the top of source
	*/
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	// handling process for Sheet
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBCLEAR:          //retrieve
		        sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				formObj.f_cmd.value=INIT;
				var sParam=coaFormQueryString(formObj);
   				var sXml=sheetObj.GetSearchData("ESM_COA_2002GS.do", sParam);
  				comboXml=sXml.split("|$$|");
  				if (comboXml.length > 0){
					ComCoaSetIBCombo(sheetObj, comboXml[0], "stnd_cost_tp_cd", false, 0);
	       			FromComCoaSetIBCombo("C",sheetObj, comboXml[1], "mgrp_cost_cd_desc", false, 0,0);
	       		}
  				setProfitLevelCombo(comboXml[0]);
  				setMainGroupCombo(comboXml[1]);					
				ComOpenWait(false);
				break;	
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
 					sheetObj.DoSearch("ESM_COA_2002GS.do", sParam );
					ComOpenWait(false);
				}
				break;
			case IBSAVE:		//saving
				if(validateForm(sheetObj,formObj,IBSAVE)){
					ComOpenWait(true);
					sheetObj.SetWaitImageVisible(0);
	     			formObj.f_cmd.value=MULTI;

	     			var sParam=sheetObj.GetSaveString(false);
	     			var sXml=sheetObj.GetSaveData("ESM_COA_2002GS.do", "f_cmd=" + MULTI + "&" +sParam);
	     			var dupChk=ComGetEtcData(sXml, "dup_chk");
	     			var transResultKey=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
					if((dupChk == "S"||dupChk=="") && transResultKey == "S"){
						ComShowCodeMessage("COM130102","Data");//Success
					}else if(dupChk == "Dup"){
						ComShowCodeMessage('COM12115', 'Sub Group Cost Code');//Duplication
						ComOpenWait(false);
						break;
					}else if(dupChk == "DescDup"){
						ComShowCodeMessage('COM12115', 'Sub Group Cost Code Desc');//Desc Dup
						ComOpenWait(false);
						break;	
					}else if(dupChk == "CaEx"){
						ComShowCodeMessage('COA10066');//There is child data on C/A code.
						ComOpenWait(false);
					}else{
						ComShowCodeMessage("COM12151",'Data'); //Failed
					}
					ComOpenWait(true);
					formObj.f_cmd.value=SEARCH;
					var sParam=FormQueryString(formObj);
					sheetObj.DoSearch("ESM_COA_2002GS.do", sParam );
					ComOpenWait(false);
				}

	     		break;
			case IBINSERT:	// inserting
				sheetObj.DataInsert(-1);
				//sheet1_OnChange(sheetObj, sheetObj.LastRow(), "stnd_cost_tp_cd", sheetObj.GetCellValue(sheetObj.LastRow(), "stnd_cost_tp_cd"));
				//sheet1_OnChange(sheetObj, sheetObj.LastRow(), "mgrp_cost_cd", 	 sheetObj.GetCellValue(sheetObj.LastRow(), "mgrp_cost_cd_desc"));
				break;
			case IBCOPYROW:	//copy row
				sheetObj.DataCopy();
				break;
			case IBDOWNEXCEL:	//down excel
				var excelType=selectDownExcelMethod(sheetObj);

				break;
		}
	}

	

	function callBackExcelMethod(excelType) {
	    var sheetObj = sheetObjects[0];
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
		combObj.InsertItem(0, "All", "");
		if (arrData != null){
            var arrCode=arrData[0].split("|");
            var arrName=arrData[1].split("|");
            for(i=0; i < arrName.length;i++){
    			combObj.InsertItem(i+1, arrName[i], arrCode[i]);        
            }
        }
		combObj.SetUseAutoComplete(1);
		combObj.SetDropHeight(190);
        combObj.SetSelectText("All");
	}
	function setMainGroupCombo(sXml, level){
		var combObj=f_mainGroupCombo;
		var arrData=CoaXml2ComboString(sXml, "mgrp_cost_cd", "mgrp_cost_cd_desc", level);
		combObj.RemoveAll();
		combObj.InsertItem(0, "All", "");
		if (arrData != null){
            var arrCode=arrData[0].split("|");
            var arrName=arrData[1].split("|");
            for(i=0; i < arrName.length;i++){
    			combObj.InsertItem(i+1, arrCode[i]+"|"+arrName[i], arrCode[i]);        
            }
        }
		combObj.SetUseAutoComplete(1);
		combObj.SetDropHeight(190);
        combObj.SetSelectText("All");
	}
	function CoaXml2ComboString(xmlStr, codeCol, textCol, level){
		var rtnArr=new Array();
		if (xmlStr == null || xmlStr == "") {
			return;
		}
		if (codeCol == null || codeCol == "" || textCol == null || textCol == "") {
			return;
		}
		try {
			var xmlDoc = ComGetXmlDoc(xmlStr);
			if (xmlDoc == null) return;
			var xmlRoot = xmlDoc.documentElement;
			
			if (xmlRoot == null) {
				return;
			}
			var dataNode=xmlRoot.getElementsByTagName("DATA").item(0);
			if (dataNode == null || dataNode.attributes.length < 3) {
				return;
			}
			var col=dataNode.getAttribute("COLORDER");
			var colArr=col.split("|");
			var sep=dataNode.getAttribute("COLSEPARATOR");
			var total=dataNode.getAttribute("TOTAL");
			var dataChildNodes=dataNode.childNodes;
			if (dataChildNodes == null) {
				return;
			}
			var colListIdx=Array();
			for ( var i=0; i < colArr.length; i++) {
				if (colArr[i] == codeCol) {
					colListIdx[0]=i;
				}
				if (colArr[i] == textCol) {
					colListIdx[1]=i;
				}
				if (level != null && level != "" && level != undefined && colArr[i] == "stnd_cost_tp_cd") {
					colListIdx[2]=i;
				}
			}
			var sCode="";
			var sText="";
			var j=0
			for ( var i=0; i < dataChildNodes.length; i++) {
				if (dataChildNodes[i].nodeType != 1) {
					continue;
				}
				var arrData=dataChildNodes[i].firstChild.nodeValue.split(sep);
				if(level == null || level == "" || level == undefined || level == arrData[colListIdx[2]]){
					if(j>0){
						sCode += "|" + arrData[colListIdx[0]];
						sText += "|" + arrData[colListIdx[1]];
					}else{
						sCode += arrData[colListIdx[0]];
						sText += arrData[colListIdx[1]];
					}
					j++;
				}
			}
			rtnArr.push(sCode);
			rtnArr.push(sText);
		} catch (err) {
			ComFuncErrMsg(err.message);
		}
		return rtnArr;
	}
	/**
	 * Main Group Combo Setting in case of  ProfitLevel Combo chage
	 */
	function f_profitLevelCombo_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		form.f_profitLevelCombo_text.value = f_profitLevelCombo.GetText(parseInt(newIndex), 0);
		setMainGroupCombo(comboXml[1], newCode);
		comboObj.SetDropHeight(190);
		comboObj.ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
	}
	function f_mainGroupCombo_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		comboObj.SetDropHeight(190);
		comboObj.ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
	}
	function f_profitLevelCombo_OnBlur() {
//		 document.form.f_profitLevelCombo_text.value = f_profitLevelCombo.GetText(parseInt(f_profitLevelCombo.GetSelectIndex()), 0);
		}
	/**
	* handling process for input validation
	*/
	function validateForm(sheetObj,formObj,sAction){
		switch(sAction){		
//		case IBSEARCH :
//			if(ComTrim(f_profitLevelCombo.GetSelectCode()) == ""){
//				ComShowCodeMessage('COM12113', 'Profit Level');//key field missing
//				ComSetFocus(f_profitLevelCombo);
//				return false;
//			} 
//			if(ComTrim(f_mainGroupCombo.GetSelectCode()) == ""){
//				ComShowCodeMessage('COM12113', 'Main Group');//key field missing
//				ComSetFocus(f_mainGroupCombo);
//				return false;
//			} 
//			break;
		case IBSAVE:
			// key field fill ? & matched code rule ?
			with(sheetObj){
				var j=0;
				for(var i = 1; i<= LastRow(); i++){
					if(GetCellValue(i, "ibflag")=='I'){
						j=j+1;
						//CellValue(i, "mgrp_cost_cd_desc")=CellValue(i, "mgrp_cost_cd");
						if(GetCellValue(i, "stnd_cost_tp_cd")==null || GetCellValue(i, "stnd_cost_tp_cd")==""){
							ComShowCodeMessage('COM130403', 'Profit Level');//key field missing
							sheetObj.SelectCell(i, "stnd_cost_tp_cd");
							return false;
							break;
						}else if(GetCellValue(i, "mgrp_cost_cd")==null || GetCellValue(i, "mgrp_cost_cd")==""){
							//CellValue(i, "mgrp_cost_cd_desc")=CellValue(i, "mgrp_cost_cd");
							ComShowCodeMessage('COM130403', 'Main Group Cost Code');//key field missing
							sheetObj.SelectCell(i, "mgrp_cost_cd_desc");
							return false;
							break;
						}else if(GetCellValue(i, "sgrp_cost_cd")==null || GetCellValue(i, "sgrp_cost_cd")=="" ){
							ComShowCodeMessage('COM130403', 'Sub Group Cost Code');//key field missing
							sheetObj.SelectCell(i, "sgrp_cost_cd");
							return false;
							break;
						//20150601.ADD
						}else if(GetCellValue(i, "sgrp_cost_cd_desc")==null || GetCellValue(i, "sgrp_cost_cd_desc")=="" ){
							ComShowCodeMessage('COM130403', 'Sub Group Cost Code Desc');//key field missing
							sheetObj.SelectCell(i, "sgrp_cost_cd_desc");
							return false;
							break;							
						}else if(GetCellValue(i, "mgrp_cost_cd").substr(0,2)!=GetCellValue(i, "sgrp_cost_cd").substr(0,2)){
							ComShowCodeMessage('COA10063', 'Data');//Firts 2 charactor of Sub group cost code must be same with Main group cost code			
							return false;
							break;
						}else if(GetCellValue(i, "sgrp_cost_cd").length!=4){
							ComShowCodeMessage('COA10067', 'Sub Group Cost Code', '4');//'{?msg1} must be {?msg2} characters long.'
							sheetObj.SelectCell(i, "sgrp_cost_cd");
							return false;
							break;
						}
					}else if(GetCellValue(i, "ibflag")=='U'){
						SetCellValue(i, "mgrp_cost_cd_desc",GetCellValue(i, "mgrp_cost_cd"));
						j=j+1;
					}else if(GetCellValue(i, "ibflag")=='D'){
						j=j+1;
					}
				}
				if(j==0){
						ComShowCodeMessage('COA10065');
						return false;
						break;
				}
			}
			var dr=sheetObj.ColValueDup("sgrp_cost_cd");
			if(dr>0){//Duplication				
				ComShowCodeMessage('COM12115', 'Sub Group Cost Code');
				sheetObj.SelectCell(dr,"sgrp_cost_cd");
				return false;
				break;
			}
			return true;
			break;
		}
		return true;
	}
	function FromComCoaSetIBCombo(level,sheetObj, sXml, title, iBlank, sCol,iRow, dCode, dText, bFlag){
        var showCol=0;
        if (ComGetTotalRows(sXml) == "0") return;
        if (bFlag == undefined || bFlag == ""){
            bFlag=false;
        }
        if (sCol != undefined && sCol !=""){
            showCol=sCol;
        }
        if (iBlank == undefined || iBlank == ""){
            iBlank=false;
        }
        if (iRow == undefined || iRow == ""){
        	iRow=0;
        }
        var arrData=CoaXml2ComboString(sXml, "mgrp_cost_cd", "mgrp_cost_cd_desc",level);
        if (bFlag == true && arrData != null){
            var arrCode=arrData[0].split("|");
            var arrName=arrData[1].split("|");
            var conData="";
            for(i=0; i < arrName.length;i++){
                if(i==0){
                    arrName[i]=arrCode[i]+"\t"+arrName[i];
                }else{
                    arrName[i]="|"+arrCode[i]+"\t"+arrName[i];
                }
                conData=conData.concat(arrName[i]);
            }
        }
        if(iBlank){
            arrData[0]=" |" + arrData[0];
            arrData[1]=" |" + arrData[1];
        }
        if (arrData != null){
        	if (iRow == 0){
        		sheetObj.SetColProperty(title, {ComboText:arrData[1] , ComboCode:arrData[0]} );
        	}else{
        		sheetObj.CellComboItem(iRow,title, {ComboText:arrData[1], ComboCode:arrData[0]} );
        	}
        }
       // 
    }

    function resizeSheet(){
   	 ComResizeSheet(sheetObjects[0]);
    }
	/* developer job end */
