/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0141.js
*@FileTitle  : Popup about the Unit Price of standard by Link
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/01
=========================================================*/
/* Grobal Variable */
//var calPop = new calendarPopupGrid();
var sheetObjects=new Array();
var sheetCnt=0;
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
				case "btn_DownExcel":
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;
				case "btn_Remark":
					document.form.f_cmd.value=SEARCHLIST01;
				    //SJH.20141107.MOD : SIZE MOD
				    ComOpenWindow2('ESM_COA_4007.do?' 
				    + coaFormQueryString(document.form), '_RMK', 'width=1200,height=660,menubar=0,status=0,scrollbars=0,resizable=1');
					break;
                case "btn_Close":
                	ComClosePopup(); 
                    break;
			} // end switch
		}catch(e) {
            if( e == "[object Error]") {
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
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
* initializing sheet
* implementing onLoad event handler in body tag
* adding first-served functions after loading screen.
	*/
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			//Sheet configuration setting function(start)
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			//Sheet configuration setting function(end)
			ComEndConfigSheet(sheetObjects[i]);
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
			case 1:		//sheet1 init
				with (sheetObj) {
				var HeadTitle="Node Link|Activity Group|Cost Group/Cost Element|Feeder Term|Feeder Term|Amt|Lvl" ;
				var HeadTitle1="Node Link|Activity Group|Cost Group/Cost Element|Rev_Term|Del_Term|Amt|Lvl" ;
				SetConfig( { SearchMode:2, MergeSheet:7, Page:999, DataRowMerge:0 } );
				var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"},
				                { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);
				var cols = [ {Type:"Text",     Hidden:0,  Width:250,  Align:"Center",  ColMerge:1,   SaveName:"nod_cd" },
				             {Type:"Text",     Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"grp" },
				             {Type:"Text",     Hidden:0,  Width:220,  Align:"Left",    ColMerge:0,   SaveName:"tree_col" },
				             {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"wtr_rcv_term_cd" },
				             {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"wtr_de_term_cd" },
				             {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"amt",               KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
				             {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"lvl" }];
				 
				InitColumns(cols);
				SetEditable(0);
				SetRangeBackColor(1, 3, 1, 5,"#555555");
//				InitTreeInfo("tree_col", "", "#0000FFNAN");
				SetSheetHeight(500); 
				}
				break;
		}
	}
	/**
	 * Setting the top of the information after retrieved sheet1
	*/
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
//        sheetObj.ShowTreeLevel(0, 1);
        for (i=1;i<=sheetObj.RowCount()+1;i++) {
			if (sheetObj.GetCellValue(i,"lvl") == "1") {
				sheetObj.SetCellValue(i,"tree_col", "+ " + sheetObj.GetCellValue(i,"tree_col"));
			} else if (sheetObj.GetCellValue(i,"lvl") == "2") {		//child 데이터는 ' -'를 앞에 달고, 최초에는 숨기기
				sheetObj.SetCellValue(i,"tree_col", "  └ " + sheetObj.GetCellValue(i,"tree_col"));
				sheetObj.SetRowHidden(i,1);
			}
		}
//		sheetObj.ShowTreeLevel(0, 1);
//        sheetObj.SetSumText(0,0, "TOTAL");
		sheetObj.SetDataMerge();
	}
	
	/**
	 * Setting the top of the information after retrieved sheet1
	*/
	function sheet1_OnClick(sheetObj, row, col){
		switch(sheetObj.ColSaveName(col)){
    	case "tree_col":
    		var mark=sheetObj.GetCellValue(row, "lvl");
    		var status=sheetObj.GetRowStatus(row);
    		if(mark == "3"){
				var startRow = row + 1;
				var endRow = sheetObj.GetMergedEndCell(row+1, "lvl").split(",")[0];
				sheetObj.SetCellValue(row,"lvl","1");
				sheetObj.SetCellValue(row,"tree_col", "+"+sheetObj.GetCellValue(row,"tree_col").substr(1));
				for(;startRow <= endRow;startRow++){
					sheetObj.SetRowHidden(startRow,1);
				}
    		}
    		else if(mark == "1"){
				var startRow = row + 1;
				var endRow = sheetObj.GetMergedEndCell(row+1, "lvl").split(",")[0];
				for(;startRow <= endRow;startRow++){
					sheetObj.SetRowHidden(startRow,0);
				}
				sheetObj.SetCellValue(row,"tree_col", "-"+sheetObj.GetCellValue(row,"tree_col").substr(1));
   				sheetObj.SetCellValue(row, "lvl", "3");
    		}
			sheetObj.SetDataMerge();
    		break;
    	}
	}
	// Handling process about the sheet object
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBSEARCH:		//Inquiry
				if(validateForm(sheetObj,formObj,sAction)){
					// Prohibit button click when a business transaction is processing 
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
					formObj.f_cmd.value=SEARCH;
					sheetObj.DoSearch("ESM_COA_0141GS.do", coaFormQueryString(formObj) );
					ComOpenWait(false);
				}
				break;
			case IBDOWNEXCEL:		// Excell download
				var excelType=selectDownExcelMethod(sheetObj);
				break;
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
		    	sheetObj.Down2Excel({ HiddenColumn:1, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
		    	break;
		    case "DN":
		    	sheetObj.Down2Excel({ HiddenColumn:1, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
		    	break;
		}            
	}

	
	/*To retrieve when the screen is loaded */
	function setRetrieveAction(){
		sheetObject=sheetObjects[0];
		formObject=document.form;
		doActionIBSheet(sheetObject,formObject,IBSEARCH);
	}
	/**
	* Handling process for form object input validation
	*/
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
		}
		return true;
	}
