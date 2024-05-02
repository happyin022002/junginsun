/**
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0003.js
*@FileTitle  :  물류비용 코드 등록
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
 
/**
 * @fileoverview 
 */ 
/**
 * @extends 
 * @class ESM_COA_0003 : ESM_COA_0003 Business script for the UI
 */
// Grobla Variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var loadingMode=false;
/* Event handler processing by button click event */
document.onclick=processButtonClick;
	/* Event handler processing by button name */
	function processButtonClick(){
		/***** Specify additional sheet variable in case of using more than two sheet per tab *****/
		var sheetObject=sheetObjects[0];
		/*******************************************************/
		var formObject=document.form; 
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
				case "btng_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;
				case "btng_rowadd":
					doActionIBSheet(sheetObject,formObject,IBINSERT);
					break;
				case "btn_downexcel":
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;
				case "btng_hidecheckbox":
					openHideCheckBox();
					break;
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage(OBJECT_ERROR);
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
	function loadPage(hdCode, hdText) {
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet(sheetObjects[i]);//Sheet configuration setting function(start)
			initSheet(sheetObjects[i],i+1, hdCode, hdText);
			ComEndConfigSheet(sheetObjects[i]);//Sheet configuration setting function(end)
		}
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		// handling multi-combo object
        //---------------------------------------------
		f_sgrp_cost_cd.InsertItem(0, 'All' ,'');
        for(k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],comboObjects[k].id);
        }
        loadingMode=false;
        sheetObjects[0].SetExtendLastCol(0); 	//SJH.20150109.ADD : 공통문의답
	}
	/**
     * Setting multicombo items
     */
     function initCombo(comboObj, comboId) {
    	 with (comboObj) {
	    	 SetDropHeight(300);
	    	 comboObj.SetSelectIndex(0);
	    	 Index=0;
    	 }
     }	
	/**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
	*/
	function initSheet(sheetObj,sheetNo, hdCode, hdText) {
		var cnt=0;
		switch(sheetNo) {
			case 1:
			    with(sheetObj){
		        var HeadTitle0="Del.|STS|Seq.|Sub Grouping|H_SG|PA View Code|PA View Code|Owner\nship|SRC\nSYS|SRC\nMon|Source Code|Source Code_Description" +
		      "|C/A|UOM|CGO\nType|UOM\nCode1|UOM\nCode2|" +
		      "OTD1|OTD2|OTD3|OTD4|OTD5|OTD6|OTD7|OTD8|OTD9|OTD10|OTD11|OTD12|OTD13|OTD14|OTD15|OTD16|OTD17|OTD18|OTD19|OTD20|OTD21|OTD22|OTD23|OTD24|OTD25|OTD26|OTD27|OTD28|OTD29|OTD30|OTD31" +
		      "|Spcial Cargo Type|Spcial Cargo Type|Spcial Cargo Type|Spcial Cargo Type|Cost Deleted|Cost Deleted|Cost Deleted|Node_Avg only\nCreation" ;
		      var HeadTitle1="Del.|STS|Seq.|Sub Grouping|H_SG|Description|Code|Owner\nship|SRC\nSYS|SRC\nMon|Source Code|Source Code_Description" +
		      "|C/A|UOM|CGO\nType|UOM\nCode1|UOM\nCode2|" +
		      "OTD1|OTD2|OTD3|OTD4|OTD5|OTD6|OTD7|OTD8|OTD9|OTD10|OTD11|OTD12|OTD13|OTD14|OTD15|OTD16|OTD17|OTD18|OTD19|OTD20|OTD21|OTD22|OTD23|OTD24|OTD25|OTD26|OTD27|OTD28|OTD29|OTD30|OTD31" +
		      "|DG|RF|AWK|BB|Rev_MT|SOC|Node_Avg only\nCreation" ;
		      var aryNm=null;
		      var aryCd=null;
		      var aryCnt=0;
		      if(hdCode != '' && hdText != ''){
		      aryNm=hdText.split("|");
		      aryCd=hdCode.split("|");
		      aryCnt=aryNm.length;
		      HeadTitle0="Del.|STS|Seq.|Sub Grouping| |PA View Code|PA View Code|Owner\nship|SRC\nSYS|SRC\nMon|Source\nCode|Source Code_Description|C/A|UOM|CGO\nType|UOM\nCode1|UOM\nCode2|";
		      HeadTitle1="Del.|STS|Seq.|Sub Grouping| |Description|Code|Owner\nship|SRC\nSYS|SRC\nMon|Source\nCode|Source Code_Description|C/A|UOM|CGO\nType|UOM\nCode1|UOM\nCode2|";
		      for(var k=0; k<aryCnt; k++) {
		      HeadTitle0=HeadTitle0 + aryNm[k]+ "|";
		      HeadTitle1=HeadTitle1 + aryCd[k]+ "|";
		      }
		      HeadTitle0 += "Spcial Cargo Type|Spcial Cargo Type|Spcial Cargo Type|Spcial Cargo Type|Cost Deleted|Cost Deleted|Node_Avg only\nCreation";
		      HeadTitle1 += "DG|RF|AWK|BB|Rev_MT|SOC|Node_Avg only\nCreation" ;
		      }

		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1, ComboMaxHeight:400 } );

		      var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle0, Align:"Center"},{ Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		      
		      //SJH.20141127.MOD
		      var cols = [ {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"delt_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1, TrueValue:"Y", FalseValue:"N"  },
		             {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
		             {Type:"Text",      Hidden:1, Width:27,   Align:"Center",  ColMerge:1,   SaveName:"seq",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Combo",     Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"sgrp_cost_cd_desc",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"sgrp_cost_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Combo",     Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"stnd_cost_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"stnd_cost_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"coa_cost_src_prt_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cost_src_sys_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cost_src_mon",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"coa_cost_src_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
		             {Type:"Text",      Hidden:0,  Width:160,  Align:"Left",    ColMerge:1,   SaveName:"coa_cost_src_cd_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cost_ass_bse_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cost_ut_amt_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"full_mty_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cost_vol_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cost_vol_cd1",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 } ];
		            if(hdCode != '' && hdText != ''){
				      for(var k=0; k<aryCnt; k++){
				      aryCd[k]=aryCd[k].toLowerCase();
				      cols.push({Type:"CheckBox",  Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:aryCd[k],                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1, TrueValue:"Y", FalseValue:"N" });
				      }
				      } else {
				      for(var k=1; k<32; k++){
				      cols.push({Type:"CheckBox",  Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"otd"+k,                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1, TrueValue:"Y", FalseValue:"N" });
				      }
				      }
				      cols.push({Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cgo_dg_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1, TrueValue:"Y", FalseValue:"N" });
				      cols.push({Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cgo_rf_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1, TrueValue:"Y", FalseValue:"N" });
				      cols.push({Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cgo_awk_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1, TrueValue:"Y", FalseValue:"N" });
				      cols.push({Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cgo_bb_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1, TrueValue:"Y", FalseValue:"N" });
				      cols.push({Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_rev_mcgo_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1, TrueValue:"Y", FalseValue:"N" });
				      cols.push({Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_full_soc_cgo_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1, TrueValue:"Y", FalseValue:"N" });
				      cols.push({Type:"CheckBox",  Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"bkg_mcgo_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1, TrueValue:"Y", FalseValue:"N" });
				      if(hdCode != '' && hdText != ''){
				      SetRangeBackColor(1, 17, 1, 21+aryCnt-1+3,"#555555");
				      } else {
				      SetRangeBackColor(1, 17, 1, 54,"#555555");
				      }
		 
		      InitColumns(cols);
		      SetEditable(1);//Editkind[optional,Defaultfalse]
              SetColProperty(0 ,"coa_cost_src_prt_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
              SetColProperty(0 ,"cost_src_sys_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
              SetColProperty(0 ,"coa_cost_src_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
              SetColProperty(0 ,"cost_src_mon" , {AcceptKeys:"N" , InputCaseSensitive:1});
		      //SetSheetHeight(500);
//		      SetSheetHeight(ComGetSheetHeight(sheetObj, 23))
//		      SetRangeBackColor(1, 5, 1, 7,"#555555");
			  resizeSheet();
		      
		      }


			break;
		}
	}
	/**
      * registering IBSheet Object as list
      * adding process for list in case of needing batch processing with other items 
      * defining list on the top of source
	*/
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
* registering IBCombo Object as list
* adding process for list in case of needing batch processing with other items 
* defining list on the top of source
     */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++]=combo_obj;
    }
// window change-over
	function goURL( kind ){
		//PCM.20141222.MOD
		if ( kind == "1" )	{
			document.location.href="/opuscntr/ESM_COA_0002.do?pgmNo=ESM_COA_0002&parentPgmNo=ESM_COA_M001";
		} else if ( kind == "2") {
			document.location.href="/opuscntr/ESM_COA_0003.do";
		}
	}
	/**
     * Change Header information of the sheet when the f_selgroup is changed
     */
    function f_sgrp_cost_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
   	 	if (loadingMode == true) return; 
	   	var formObj=document.form;
	    var sheetObj=sheetObjects[0];
	  	formObj.f_cmd.value=SEARCHLIST10;
 		var sXml=sheetObj.GetSearchData("ESM_COA_0003_1GS.do", FormQueryString(formObj));
		var arrXml=sXml.split("|$$|");
		if (ComGetTotalRows(sXml) > 0) {
			ComXml2ComboItem(arrXml[0], f_stnd_cost_cd, "code", "name");
			f_stnd_cost_cd.InsertItem(0, 'All' ,'');
			f_stnd_cost_cd.SetSelectIndex(0);
		}		
//		comboObj.SetUseAutoComplete(1);				//20150713.MOD
		comboObj.ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
    }
	function openHideCheckBox(){
		ComOpenWindow('ESM_COA_0124.do?headerCode='+document.form.f_header_code.value, 'Hide Pop', 'width=370,height=410,menubar=0,status=0,scrollbars=0,resizable=0');
		//noRtnPopup('ESM_COA_0124.do?headerCode='+document.form.header_code.value, 'width=300,height=430,menubar=0,status=0,scrollbars=0,resizable=0')
	}
	function columnHideByChild(colName, val){
		sheetObjects[0].SetColHidden(colName,val);
	}
	// Change stndard cost code of the combo when the sgrp_cost_cd is changed
	function sheet1_OnChange(sheetObj, Row, Col, value){
		var formObj=document.form;
		var param="";
		if(sheetObj.ColSaveName(Col) == "sgrp_cost_cd_desc"){
			param=param+"&f_cmd="+SEARCHLIST10;
			param=param+"&f_sgrp_cost_cd="+sheetObj.GetCellValue(Row,Col);
 			var sXml=sheetObj.GetSearchData("ESM_COA_0003_1GS.do", param);
			var arrXml=sXml.split("|$$|");
			if (arrXml.length > 0)
				ComCoaSetIBCombo(sheetObj, arrXml[0], "stnd_cost_nm", true,0,Row);
			sheetObj.SetCellValue(Row,"sgrp_cost_cd",value,0);
		}else if(sheetObj.ColSaveName(Col) == "stnd_cost_nm"){
			sheetObj.SetCellValue(Row,"stnd_cost_cd",value,0);
		}
	}
	/*
	 * Provide header code to the popup for the hidden column
	 */
	function getHeadCodeByChild(){
		return document.form.f_header_code.value;
	}
	/*
	 * Provide header text to the popup for the hidden column
	 */
	function getHeadTextByChild(){
	  return document.form.f_header_text.value;
	}
	// Handling process about the sheet object
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBCLEAR:          //Inquiry
		        sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				formObj.f_cmd.value=INIT;
 				var sXml=sheetObj.GetSearchData("ESM_COA_0003_1GS.do", coaFormQueryString(formObj));
				var arrXml=sXml.split("|$$|");
				if (arrXml.length > 0) {
					ComXml2ComboItem(arrXml[0], f_sgrp_cost_cd, "code", "code|name");
					ComCoaSetIBCombo(sheetObj, arrXml[0], "sgrp_cost_cd_desc", false, 0);
				}
				if (arrXml.length > 1) {
					ComCoaSetIBCombo(sheetObj, arrXml[1], "stnd_cost_nm", false, 0);
				}
				if (arrXml.length > 2) {
					ComCoaSetIBCombo(sheetObj, arrXml[2], "cost_ass_bse_cd", true, 0);
					comboObjects[1].ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
				}
				ComOpenWait(false);
				break	
			case IBSEARCH:	//Inquiry
				if(validateForm(sheetObj,formObj,sAction)){
					// Prohibit button click when a business transaction is processing 
//					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
					formObj.f_cmd.value=SEARCHLIST;
 					sheetObj.DoSearch("ESM_COA_0003GS.do", coaFormQueryString(formObj) );
//					ComOpenWait(false);
				}
				break;
			case IBSAVE:		//Save
				if(validateForm(sheetObj,formObj,sAction)){
					// Prohibit button click when a business transaction is processing 
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
					formObj.f_cmd.value=MULTI;
					sheetObj.DoSave("ESM_COA_0003GS.do", coaFormQueryString(formObj, 'code'));
					//sheetObj.DoAllSave("ESM_COA_0003GS.do", FormQueryString(formObj));
					ComOpenWait(false);
				}
				break;
			case IBINSERT:	// Insert
				sheetObj.DataInsert(-1);
				//sheetObj.CellValue2(sheetObj.LastRow, "delt_flg") = "N";
				sheetObj.SetCellValue(sheetObj.LastRow(), "sgrp_cost_cd_desc",getIbComboObjValue(f_sgrp_cost_cd),0);
				sheetObj.SetCellValue(sheetObj.LastRow(), "stnd_cost_nm",getIbComboObjValue(f_stnd_cost_cd),0);
				sheetObj.SetCellValue(sheetObj.LastRow(), "sgrp_cost_cd",getIbComboObjValue(f_sgrp_cost_cd),0);
				sheetObj.SetCellValue(sheetObj.LastRow(), "stnd_cost_cd",getIbComboObjValue(f_stnd_cost_cd),0);
				break;
			case IBDOWNEXCEL:	// Excell download
				selectDownExcelMethod(sheetObj);
				break;
		}
	}
	
	
	function callBackExcelMethod(excelType) {
		var sheetObj = sheet1;
		if(sheetObj.RowCount() < 1){//no data
			ComShowCodeMessage("COM132501");
			return;
		}
		
		//SJH.20141222.MOD : 포맷에 따라 다르게 나오기..
		switch (excelType) {
			case "AY":
				sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
				break;
			case "AN":
				sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
				break;
			case "DY":
				sheetObj.Down2Excel({ HiddenColumn:1, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
				break;
			case "DN":
				sheetObj.Down2Excel( {HiddenColumn:1, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });	
				break;
		}
	}

    function sheet1_OnSearchEnd(shtObj, ErrMsg) {
		ComOpenWait(false);
    }			
	/**
	* Handling process for form object input validation
	*/
	function validateForm(sheetObj,formObj,sAction){
		switch(sAction){		
		case IBSEARCH :
//			if(ComTrim(formObj.f_sgrp_cost_cd.Code) == ""){
//				ComShowCodeMessage('COM12113', 'Sub Group');//key field missing
//				ComSetFocus(formObj.f_sgrp_cost_cd);
//				return false;
//			} 
//			if(ComTrim(formObj.f_stnd_cost_cd.Code) == ""){
//				ComShowCodeMessage('COM12113', 'COA Code');//key field missing
//				ComSetFocus(formObj.f_stnd_cost_cd);
//				return false;
//			} 
			break;
		case IBSAVE:
			var dup=sheetObj.ColValueDup("sgrp_cost_cd_desc|sgrp_cost_cd|stnd_cost_cd|coa_cost_src_cd")
			if(dup != -1){
				ComShowCodeMessage('COM131302', 'Code');
				return false;
			}
//			if(ComTrim(f_sgrp_cost_cd.GetSelectCode()) == ""){
//				ComShowCodeMessage('COM12113', 'Sub Group');//key field missing
//				ComSetFocus(f_sgrp_cost_cd);
//				return false;
//			} 
//			if(ComTrim(f_stnd_cost_cd.GetSelectCode()) == ""){
//				ComShowCodeMessage('COM12113', 'COA Code');//key field missing
//				ComSetFocus(f_stnd_cost_cd);
//				return false;
//			} 
			break;
		}
		return true;
	}
	function getIbComboObjValue(obj){
	  	if (ComGetObjValue(obj) == "All" ){
	  		return "";
	  	}
	  	return ComGetObjValue(obj);
	  } 	

    function resizeSheet(){
   	 ComResizeSheet(sheetObjects[0]);
    }
    
    //SJH.20121222.ADD : 저장후 메시지 추가
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
        if(ErrMsg == ""){
            // [COM130102] : Success
        	ComShowMessage(ComGetMsg("COM130102","Data"));
        }else{
            ComShowMessage(ComGetMsg("COM132101"));
        }	
        doActionIBSheet(sheetObj,document.form,IBSEARCH);
    }    
