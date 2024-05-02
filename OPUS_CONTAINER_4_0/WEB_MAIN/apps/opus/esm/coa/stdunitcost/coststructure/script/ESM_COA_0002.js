/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0002.js
*@FileTitle  : Register C/A Code 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/03
=========================================================*/
/**
 * @extends 
 * @class ESM_COA_0002 : ESM_COA_0002 Business script for the UI
 */
// Grobla Variable
var sheetObjects=new Array();
var sheetCnt=0;
var G_YEAR_MONTH="";
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
				case "btn_officecreation":
					doActionIBSheet(sheetObject,formObject,IBCREATE);
					break;

				case "btng_update":
					doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC01);
					break;		
					
				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
				case "btng_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;
				case "btng_rowadd":
					doActionIBSheet(sheetObject,formObject,IBINSERT);
					break;
				case "btng_report":
					ComOpenWindow2('ESM_COA_0130.do','','width=800,height=400, menubar=0, scrollbars=0, resizable=yes');
					break;
				case "btng_setlist":
					ComOpenWindow2('ESM_COA_0001.do','','width=500,height=500, menubar=0, scrollbars=0, resizable=yes');
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
// window change-over
	function goURL( kind ){
		if ( kind == "1" )	{
			document.location.href="/opuscntr/ESM_COA_0002.do";
		} else if ( kind == "2") {
			document.location.href="/opuscntr/ESM_COA_0003.do?pgmNo=ESM_COA_0003&parentPgmNo=ESM_COA_M001"; 	//SJH.20141231.MOD
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
        doActionIBSheet(sheetObjects[0], document.form,IBCLEAR);
        document.form.btn_retrieve.focus();
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
		        	//no support[check again]CLT 					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);	//setting Host information[mandatory][HostIp, Port, PagePath]
					var HeadTitle0="||Profit Level" + 
								   "|Profitability-related View|Profitability-related View|Profitability-related View|Profitability-related View" +
							   	   "|Profitability-related View|Profitability-related View||" +
							       "|";
					var HeadTitle1="Del.|STS|Profit Level" +
						           "|Main Grouping|H_MG|Sub Grouping|Grp\nCode|Performance View Code|Performance View Code" +
							       "|View\nHierarchy|DISP SEQ|Hire-Cost\nSelect";

					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:3, DataRowMerge:1 } );

					var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle0, Align:"Center"}, { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);

					var cols = [ {Type:"CheckBox",  Hidden:0, Width:25,   Align:"Left",    ColMerge:0,   SaveName:"delt_flg", TrueValue:"Y", FalseValue:"N" },
					             {Type:"Status",    Hidden:0, Width:25,   Align:"Left",    ColMerge:0,   SaveName:"ibflag" },
					             {Type:"Combo",     Hidden:0, Width:140,  Align:"Left",    ColMerge:1,   SaveName:"stnd_cost_tp_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Combo",     Hidden:0, Width:160,  Align:"Left",    ColMerge:1,   SaveName:"mgrp_cost_nm",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"mgrp_cost_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Combo",     Hidden:0, Width:170,  Align:"Left",    ColMerge:1,   SaveName:"sgrp_cost_nm",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"sgrp_cost_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:220,  Align:"Left",    ColMerge:0,   SaveName:"stnd_cost_nm",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000 },
					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"stnd_cost_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
					             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"perf_vw_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"acct_dp_seq",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
					             {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"hir_scp_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N"} ];
		       
					InitColumns(cols);

					SetEditable(1);//Editkind[optional,Defaultfalse]
					//SetCountPosition(1);
		            SetColProperty(0 ,"acct_dp_seq" , {AcceptKeys:"N"});
		            SetColProperty(0 ,"perf_vw_cd" , {AcceptKeys:"E", InputCaseSensitive:1});
					SetWaitImageVisible(0);
//					SetSheetHeight(500);
					resizeSheet();
		      //no support[check again]CLT 					style.height=GetSheetHeight(23) ;
		      //conversion of function[check again]CLT 					InitDataValid(0, "stnd_cost_nm", vtEngOther, " "); //stnd_cost_nm
		      //conversion of function[check again]CLT 					InitDataValid(0, "stnd_cost_cd", vtEngOther, "0123456789"); //stnd_cost_cd
		      //conversion of function[check again]CLT 					InitDataValid(0, "perf_vw_cd", vtEngUpOnly); //perf_vw_cd
		      //conversion of function[check again]CLT 					InitDataValid(0, "acct_dp_seq", vtNumericOnly); //acct_dp_seq
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
	// Change the mnGroup when a stnd_cost_tp_cd, mgrp_cost_cd is changed
	function sheet1_OnChange(sheetObj, row, col, value){
		var formObj=document.hiddenF;
		var tmpSN=sheetObj.ColSaveName(col);
		formObj.sRow.value=row;

		if(tmpSN == "stnd_cost_tp_cd")	{
			formObj.changeCol.value="stnd_cost_tp_cd";
			formObj.changeValue.value=value;
			doActionIBSheet(sheetObj,formObj,IBROWSEARCH);
		} else if(tmpSN == "mgrp_cost_nm") {
			sheetObj.SetCellValue(row, "mgrp_cost_cd",value);
			formObj.changeCol.value="mgrp_cost_cd";
			formObj.changeValue.value=value;
			sheetObj.CellComboItem(row,"sgrp_cost_nm", {ComboText:"", ComboCode:""} );
			sheetObj.SetCellValue(row,"mgrp_cost_cd",value,0);
			doActionIBSheet(sheetObj,formObj, IBROWSEARCH);
//			if(sheetObj.GetCellValue(row,"sgrp_cost_nm")==""){
//				ComShowCodeMessage('COA10068', sheetObj.GetCellText(row,"mgrp_cost_nm"));
//			}
			sheetObj.SetCellValue(row,"sgrp_cost_cd",sheetObj.GetCellValue(row,"sgrp_cost_nm"));
		} else if(tmpSN == "sgrp_cost_nm"){
			sheetObj.SetCellValue(row,"sgrp_cost_cd",value,0);
		}
	}
	// Handling process about the sheet object
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBCLEAR:          //Inquiry
				ComOpenWait(true);
				formObj.f_cmd.value=INIT;
//parameter changed[check again]CLT 				
				var sXml=sheetObj.GetSearchData("ESM_COA_0002_1GS.do", coaFormQueryString(formObj));
				var arrXml=sXml.split("|$$|");
				if (arrXml.length > 0)
					ComCoaSetIBCombo(sheetObj, arrXml[0], "stnd_cost_tp_cd", false, 0);
				if (arrXml.length > 1)
					ComCoaSetIBCombo(sheetObj, arrXml[1], "mgrp_cost_nm", false, 0);
				if (arrXml.length > 2)
					ComCoaSetIBCombo(sheetObj, arrXml[2], "sgrp_cost_nm", false, 0);
				ComOpenWait(false);
				break	
			case IBCREATE:		// Office Creation
				if(!validateForm(sheetObj, formObj, sAction)){
					return false;
				}
				if (!ComShowCodeConfirm("COA10020")) {
					return false;
				}
				// Prohibit button click when a business transaction is processing 
				ComOpenWait(true);

				formObj.f_cost_yrmon.value = ComGetNowInfo("ym").replace("-","");
				
				var sParam="f_cmd=" + COMMAND01 + "&f_cost_yrmon=" + ComGetUnMaskedValue(formObj.f_cost_yrmon.value, "ym");
//parameter changed[check again]CLT 				
				var sXml=sheetObj.GetSaveData("ESM_COA_0002GS.do", sParam);
				if(sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
					ComShowCodeMessage('COM12116', 'Office Creation');
				}				
				ComOpenWait(false);			
				break;
			case IBSEARCH:	//Inquiry
				if (sheetObj.IsDataModified()&& ComShowCodeConfirm("COM130504")) {
	   				//validation check
	   				if(!doActionIBSheet(sheetObj,formObj,IBSAVE)) { 
	   					return false;
	   				}
				}
				if(!validateForm(sheetObj,formObj,sAction)){
					return false;
				}
				// Prohibit button click when a business transaction is processing 
				ComOpenWait(true);
	            setTimeout( function () {
					formObj.f_cmd.value=SEARCHLIST;					
					var sParam=coaFormQueryString(formObj, 'cond1|code');	 				  				
	//parameter changed[check again]CLT   				
					var sXml=sheetObj.GetSearchData("ESM_COA_0002GS.do", sParam);
	  				var tYearMonth=ComGetEtcData(sXml,"T_YEAR_MONTH");
	  				formObj.f_cost_yrmon.value=ComGetMaskedValue(tYearMonth, "ym");
	  				G_YEAR_MONTH=ComGetMaskedValue(tYearMonth, "ym");
	  				sheetObj.LoadSearchData(sXml,{Sync:1} );
					ComOpenWait(false);		
	            }, 100);		
				break;
			case IBSAVE: // Save
				if (!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
/*
				if (!ComShowCodeConfirm("COA10061")) {
					return false;
				}
				if (!ComChkValid(formObj)) {
					alert(3);
					return false;
				}
*/
				ComOpenWait(true);

				var insertRows = new Array();
				for (var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++) {
					if (sheetObj.GetRowStatus(i) == "I") {
						insertRows.push(i);
					}
				}

				var sParam = "f_cmd=" + MULTI;
				if (formObj.f_cost_yrmon.value != G_YEAR_MONTH) {
					sParam += "&f_cost_yrmon=" + ComGetUnMaskedValue(formObj.f_cost_yrmon.value, "ym");
				} else {
					sParam += "&f_cost_yrmon=";
				}

				sheetObj.DoSave("ESM_COA_0002GS.do", sParam);
				G_YEAR_MONTH = formObj.f_cost_yrmon.value;		

				for (var i=0; i<insertRows.length; i++) {
					sheetObj.SetCellValue(insertRows[i], "delt_flg", false);
				}

				ComOpenWait(false);
				break;
			case IBSEARCH_ASYNC01:
				if(!validateForm(sheetObj,formObj,sAction)){
					return false;
				}

				if (!ComShowCodeConfirm("COA10061")) {
					return false;
				}
				
				ComOpenWait(true);				
				var sParam = "f_cmd=" + MULTI;
				if(formObj.f_cost_yrmon.value != G_YEAR_MONTH) {
					sParam += "&f_cost_yrmon=" + ComGetUnMaskedValue(formObj.f_cost_yrmon.value, "ym");
				} else {
					sParam += "&f_cost_yrmon=";
				}
				

 				var sXml=sheetObj.GetSaveData("ESM_COA_0002GS.do", sParam );
 				sheetObj.LoadSaveData(sXml, {Sync:1});
			
				G_YEAR_MONTH = formObj.f_cost_yrmon.value;	
				
				ComOpenWait(false);				
				break;
				
			case IBROWSEARCH: 
				// Prohibit button click when a business transaction is processing 
				ComOpenWait(true);
				var formObj2=document.hiddenF;
				formObj2.f_cmd.value=MULTI02;
//				alert();
//conversion of function[check again]CLT 				
				sheetObj.DoRowSearch(sheetObj.GetSelectRow(),"ESM_COA_0002GS2.do",coaFormQueryString(formObj2));
//				var sXml = sheetObj.GetSearchData("ESM_COA_0002GS2.do", coaFormQueryString(formObj2));
//				alert(sXml);
				ComOpenWait(false);
				break;
			case IBINSERT:	// Insert
				sheetObj.DataInsert(-1);
				//20150610.ADD
				sheetObj.SetCellValue(sheetObj.LastRow(), "stnd_cost_tp_cd","",0);
				sheetObj.SetCellValue(sheetObj.LastRow(), "mgrp_cost_nm","",0);
				sheetObj.SetCellValue(sheetObj.LastRow(), "mgrp_cost_cd","",0);
				sheetObj.SetCellValue(sheetObj.LastRow(), "sgrp_cost_nm","",0);
				break;
			case IBCOPYROW:	// Row copy
				sheetObj.DataCopy();
				break;
			case IBDOWNEXCEL:	// Excell download
				var excelType=selectDownExcelMethod(sheetObj);
		}
	}
	
	function callBackExcelMethod(excelType){
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

    function sheet1_OnSearchEnd(shtObj, ErrMsg) {
//    	ComOpenWait(false);	
    }
	/**
	* Handling process for form object input validation
	*/
	function validateForm(sheetObj,formObj,sAction){
		var rtn=true;
		with(formObj){			
			var dr=sheetObj.ColValueDup("stnd_cost_cd");
			if(dr>0){	//If there is duplicate values			
				ComShowCodeMessage('COM12115', 'PA View_Code');
				sheetObj.SelectCell(dr,"stnd_cost_cd");
				rtn=false;
			}
			switch (sAction) {
		 		case IBCREATE:		 			
		 			/*if(f_cost_yrmon.value == "") {
		 				ComShowCodeMessage('COA10002', 'Cost Year Month');
		 				return false;
		 			}*/
					break;
		 		case IBSAVE:
		 			if(f_cost_yrmon.value == G_YEAR_MONTH && !sheetObj.IsDataModified()) {
		 				ComShowCodeMessage('COM130503');
		 				return false;
		 			}
					break;
			}
		}
		return rtn;
	}

    function resizeSheet(){
   	 ComResizeSheet(sheetObjects[0]);
    }
