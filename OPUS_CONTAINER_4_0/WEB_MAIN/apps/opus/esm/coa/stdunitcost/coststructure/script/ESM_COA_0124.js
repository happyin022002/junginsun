/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0124.js
*@FileTitle  : So Cost Code Column hide
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
	// Grobla Variable
	var sheetObjects=new Array();
	var sheetCnt=0;
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
				//SJH.20150109.ADD : 공통
				case "btn_apply":
					openerColumnHiddenMng();
					break;
				case "btn_close":
					ComClosePopup(); 
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
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			//Sheet configuration setting function(start)
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i]);
			//Sheet configuration setting function(end)
			ComEndConfigSheet(sheetObjects[i]);
		}
	}
	/**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj) {
		  with(sheetObj){
			    var cnt=0;
			   var HeadTitle="Column|H|Hide" ;
			   SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			   var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
			   var headers = [ { Text:HeadTitle, Align:"Center"} ];
			   InitHeaders(headers, info);
			   var cols = [ {Type:"Text",     Hidden:0,  Width:160,  Align:"Left",    ColMerge:1,   SaveName:"header" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"col_nm" },
			             {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"flag",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 } ];
			   InitColumns(cols);
			   SetEditable(1);//Editkind[optional,Defaultfalse]
//			   SetSheetHeight(287);
				  resizeSheet();
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
	/* Hide column of the parent window if you select check-box.*/
	function sheet1_OnChange(sheetObj , Row, Col, Val) {
//		var sName=sheetObj.ColSaveName(Col);
//		if ( sName == "flag") {
//			if(Val == "1"){
//				opener.columnHideByChild(sheetObj.GetCellValue(Row, Col-1), true);
//				} else { //parent.document.getElementById("sheet1").GetCellValue(Row, Col-1)
//				opener.columnHideByChild(sheetObj.GetCellValue(Row, Col-1), false);
//			}
//		}
	}
/* Setting the data from the header of the parent window after loding*/
	function setDataFromParentHeader() {
		//sheet setting
		//HeadTitle1 = "Del.|STS|Seq.|Sub Grouping1 & 2| |Description|Code|Owner\nship|SRC\nSYS|SRC\nMon|Source\nCode|Source Code_Description|C/A|UOM|CGO\nType|UOM\nCode1|UOM\nCode2|";
		//sgrp_cost_cd_desc, , stnd_cost_nm, stnd_cost_cd, coa_cost_src_prt_cd, cost_src_sys_cd, cost_src_mon, coa_cost_src_cd, coa_cost_src_cd_nm, cost_ass_bse_cd, cost_ut_amt_cd, bkg_cgo_tp_cd, cost_vol_cd, cost_vol_cd1
		var sheetObj=sheetObjects[0];
		var currentRow=sheetObj.DataInsert(-1);
		sheetObj.SetCellValue(currentRow, 0,"Sub Grouping",0,0);sheetObj.SetCellValue(currentRow, 1,"sgrp_cost_cd_desc");
		currentRow=sheetObj.DataInsert(-1,0,0);sheetObj.SetCellValue(currentRow, 0,"Description");sheetObj.SetCellValue(currentRow, 1,"stnd_cost_nm");
		currentRow=sheetObj.DataInsert(-1,0,0);sheetObj.SetCellValue(currentRow, 0,"Code");sheetObj.SetCellValue(currentRow, 1,"stnd_cost_cd");
		currentRow=sheetObj.DataInsert(-1,0,0);sheetObj.SetCellValue(currentRow, 0,"Owner ship");sheetObj.SetCellValue(currentRow, 1,"coa_cost_src_prt_cd");
		currentRow=sheetObj.DataInsert(-1,0,0);sheetObj.SetCellValue(currentRow, 0,"SRC SYS");sheetObj.SetCellValue(currentRow, 1,"cost_src_sys_cd");
		currentRow=sheetObj.DataInsert(-1,0,0);sheetObj.SetCellValue(currentRow, 0,"SRC Mon");sheetObj.SetCellValue(currentRow, 1,"cost_src_mon");
		currentRow=sheetObj.DataInsert(-1,0,0);sheetObj.SetCellValue(currentRow, 0,"Source Code");sheetObj.SetCellValue(currentRow, 1,"coa_cost_src_cd");
		currentRow=sheetObj.DataInsert(-1,0,0);sheetObj.SetCellValue(currentRow, 0,"Source Code_Description");sheetObj.SetCellValue(currentRow, 1,"coa_cost_src_cd_nm");
		currentRow=sheetObj.DataInsert(-1,0,0);sheetObj.SetCellValue(currentRow, 0,"C/A");sheetObj.SetCellValue(currentRow, 1,"cost_ass_bse_cd");
		currentRow=sheetObj.DataInsert(-1,0,0);sheetObj.SetCellValue(currentRow, 0,"UOM");sheetObj.SetCellValue(currentRow, 1,"cost_ut_amt_cd");
		currentRow=sheetObj.DataInsert(-1,0,0);sheetObj.SetCellValue(currentRow, 0,"CGO Type");sheetObj.SetCellValue(currentRow, 1,"full_mty_cd");//bkg_cgo_tp_cd -> full_mty_cd로 컬럼명 변경
		currentRow=sheetObj.DataInsert(-1,0,0);sheetObj.SetCellValue(currentRow, 0,"UOM Code1");sheetObj.SetCellValue(currentRow,1,"cost_vol_cd");
		currentRow=sheetObj.DataInsert(-1,0,0);sheetObj.SetCellValue(currentRow, 0,"UOM Code2");sheetObj.SetCellValue(currentRow, 1,"cost_vol_cd1");
		if(opener != null){
			var hdCdArr=opener.getHeadCodeByChild().split("|");
			var hdTxtArr=opener.getHeadTextByChild().split("|");
			for(var k=0; k<hdCdArr.length; k++){
				currentRow=sheetObj.DataInsert(-1);
				sheetObj.SetCellValue(currentRow, 0,hdTxtArr[k],0);//row, col
				sheetObj.SetCellValue(currentRow, 1,hdCdArr[k].toLowerCase(),0);//row, col
			}
		} 
		//HeadTitle1 += "DG|RF|AWK|BB|Rev_MT|SOC|Node_Avg only\nCreation" ;
		//spcl_cgo_dg_flg,spcl_cgo_rf_flg,spcl_cgo_awk_flg,spcl_cgo_bb_flg,bkg_full_soc_cgo_flg,bkg_rev_mcgo_flg,bkg_mcgo_flg
		currentRow=sheetObj.DataInsert(-1,0,0);sheetObj.SetCellValue(currentRow, 0,"DG");sheetObj.SetCellValue(currentRow, 1,"spcl_cgo_dg_flg");
		currentRow=sheetObj.DataInsert(-1,0,0);sheetObj.SetCellValue(currentRow, 0,"RF");sheetObj.SetCellValue(currentRow, 1,"spcl_cgo_rf_flg");
		currentRow=sheetObj.DataInsert(-1,0,0);sheetObj.SetCellValue(currentRow, 0,"AWK");sheetObj.SetCellValue(currentRow, 1,"spcl_cgo_awk_flg");
		currentRow=sheetObj.DataInsert(-1,0,0);sheetObj.SetCellValue(currentRow, 0,"BB");sheetObj.SetCellValue(currentRow, 1,"spcl_cgo_bb_flg");
		//SJH.20141207.MOD : flg name mod
		currentRow=sheetObj.DataInsert(-1,0,0);sheetObj.SetCellValue(currentRow, 0,"Rev_MT");sheetObj.SetCellValue(currentRow, 1,"bkg_rev_mcgo_flg");
		currentRow=sheetObj.DataInsert(-1,0,0);sheetObj.SetCellValue(currentRow, 0,"SOC");sheetObj.SetCellValue(currentRow, 1,"bkg_full_soc_cgo_flg");
		currentRow=sheetObj.DataInsert(-1,0,0);sheetObj.SetCellValue(currentRow, 0,"Node_Avg only\nCreation");sheetObj.SetCellValue(currentRow, 1,"bkg_mcgo_flg");
		sheetObj.SelectCell(1,2);
	}

    function resizeSheet(){
   	 ComResizeSheet(sheetObjects[0]);
    }
    
    //SJH.20150109.ADD : 공통
    function openerColumnHiddenMng() {
    	var sheetOjb01 = sheetObjects[0];
    	var lastCol = "";
  
    	opener.sheet1.RenderSheet(0);
    	for(var i=0; i<sheetOjb01.RowCount(); i++) {
    		if(sheetOjb01.GetCellValue(i+1,"flag") == "1") {
    			opener.columnHideByChild(sheetObj.GetCellValue(i+1, 1), true);
    			lastCol = sheetObj.GetCellValue(i+1, 1);
    		} else {
    			opener.columnHideByChild(sheetObj.GetCellValue(i+1, 1), false);
    		}
    	}
    	opener.sheet1.RenderSheet(1);
    }

