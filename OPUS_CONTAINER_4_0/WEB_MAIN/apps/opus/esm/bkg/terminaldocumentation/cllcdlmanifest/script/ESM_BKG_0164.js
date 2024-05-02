/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0164.js
*@FileTitle  : Container Loading/Discharging Cross-Check 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/08
=========================================================
*/

/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------Added code to make a good JSDoc ------------------*/
/**
 * @fileoverview JavaScript File is commonly using. calendar functions have is defined.
 * @author 
 */
/**
 * @extends
 * @class ESM_BKG_0164 : business script for ESM_BKG_0164 
 */
	
	// Common global variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	var searchFlag=false;
	var loadExcelFlg=false;
	var oldType="";
	var columnCount=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick() {
		/** ***  Tab ->two or more sheet : sheet  a variable assignment **** */
		var sheetObject=sheetObjects[0];
		/** **************************************************** */
		var formObject=document.form;
		try {
			var srcName = ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);	
				break; 
				case "btn_new":
					doActionIBSheet(sheetObjects[0],document.form,IBRESET);	
				break; 
				case "btn_loadExcel":
					doActionIBSheet(sheetObjects[0],document.form,IBLOADEXCEL);	
				break; 
				case "btn_downExcel":
					doActionIBSheet(sheetObjects[0],document.form,IBDOWNEXCEL);	
				break; 
				case "btn_print":
		        	rdOpen();		        	
				break; 
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}
	/**
	 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items  
	 * defining list on the top of source
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * initializing sheet implementing onLoad event handler in body tag 
	 * adding first-served functions after loading screen.
	 */
	function loadPage() {
		ComBtnDisable("btn_loadExcel");
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);						
		}
		
		//The required events on the screen
		axon_event.addListenerForm("click","obj_Click", document.form);
		axon_event.addListenerForm("change","obj_Change", document.form);
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		
		document.form.vvd.focus();
	}
	/**
	 * Form control  click
	 * radio button click:Match, Unmatch 
	 */ 
	function obj_Click() {
		var formObject=document.form;
		var srcObj = ComGetEvent();
		var srcValue = ComGetEvent("value");
		var srcName= ComGetEvent("name");
		if ( srcName == "inc_mty_chk" ) {
			if(srcObj.checked){
				formObject.inc_mty.value="Y";
			}else{
				formObject.inc_mty.value="N";
			}
		}
		if ( srcName == "data_chk") {
			var sheetObj=sheetObjects[0];
			if(sheetObjects[5].RowCount()== 0 && sheetObjects[1].RowCount()== 0) {
				ComShowCodeMessage('BKG00889'); // No Data Found
				formObject.data_chk[0].checked=true;
				return;
			}
			if(!loadExcelFlg) {
				formObject.data_chk[0].checked=true;
				return;
			}
			ComOpenWait(true);
			sheetObj.RemoveAll();
			var rowCnt=1;
			if(formObject.data_chk[1].checked){ // Matched
				copySheet(sheetObj, sheetObjects[5], null, "M");
				for(var i=1; i<=sheetObj.RowCount(); i=i+2){
					sheetObj.SetCellValue(i, "rnum",rowCnt,0);
					sheetObj.SetCellValue(i+1, "rnum",rowCnt,0);
					sheetObj.SetRowBackColor(i,"#EFF0F3");
					sheetObj.SetRowBackColor(i+1,"#EFF0F3");
					rowCnt++;
				}
			}
			else if(formObject.data_chk[2].checked){ // UnMatched
				copySheet(sheetObj, sheetObjects[5], null, "U");
				for(var i=1; i<=sheetObj.LastRow(); i=i+2){
					sheetObj.SetCellValue(i, "rnum",rowCnt,0);
					sheetObj.SetCellValue(i+1, "rnum",rowCnt,0);
					sheetObj.SetRowBackColor(i,"#FFFFAC");
					sheetObj.SetRowBackColor(i+1,"#FFFFAC");
					rowCnt++;
				}
			}
			else{
				copySheet(sheetObj, sheetObjects[5]);
				for(var i=1; i<=sheetObj.LastRow(); i=i+2){
					if(sheetObj.GetCellValue(i, "match")=="U"){
						sheetObj.SetRowBackColor(i,"#FFFFAC");
						sheetObj.SetRowBackColor(i+1,"#FFFFAC");
					}else if(sheetObj.GetCellValue(i, "match")=="M"){
						sheetObj.SetRowBackColor(i,"#EFF0F3");
						sheetObj.SetRowBackColor(i+1,"#EFF0F3");
					}
					rowCnt++;
				}
			}
			sheetObj.SelectCell(0,0);
			ComOpenWait(false);
		}
	}
	
	/**
	 * Terminal type change handling 
	 */ 
	function obj_Change() {
		var formObject=document.form;
		var srcValue= ComGetEvent("value");
		var srcName=ComGetEvent("name");
		if ( srcName == "tmnl_type") {
			if(srcValue != oldType) {
				searchFlag=false;
				loadExcelFlg=false;
				ComBtnEnable("btn_retrieve");
				ComBtnDisable("btn_loadExcel");
				oldType=srcValue;
			}
		}
	}
	/**
	 * setting sheet initial values and header param : sheetObj ==> Sheet Object
	 * sheetNo 
	 * The serial number
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;				
	    switch(sheetID) {
	    case "sheet1":
	    case "sheet4":
	    case "sheet5":
	    case "sheet6":
		    with(sheetObj){
		      var HeadTitle1="|M|K|Booking No.|BKG Q'ty|BKG Q'ty|Shipper|POD|Container No.|Commodity|Special";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      columnCount=headCount;
		      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0, UseNoDataRow:1 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ //{Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },	//저장 로직 없으므로 ibflag 사용하지 않음. 추가시 RD 도 변경해야 함
				     {Type:"Int",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rnum",      KeyField:0,   CalcLogic:"",   Format:"NullInteger",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"match",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"kind",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"bkg_qty1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bkg_qty2",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:220,  Align:"Left",    ColMerge:0,   SaveName:"shpr_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"fpod",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:95,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:220,  Align:"Left",    ColMerge:0,   SaveName:"cmdt_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"special",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	      		InitColumns(cols);
	      		SetEditable(1);
	      		SetSheetHeight(340);
	      		SetCountPosition(0);
            }
		break;
		
		case "sheet2":      //sheet2 init
		    with(sheetObj){
	        	var HeadTitle1="Total|BKG|20'|40'|45'";
	        	SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		        InitHeaders(headers, info);
		        var cols = [ {Type:"Text",      Hidden:0, Width:105,  Align:"Center",  ColMerge:0,   SaveName:"Total",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"BKG",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:0,   SaveName:"Qty20",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:0,   SaveName:"Qty40",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:0,   SaveName:"Qty45",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];      
			     InitColumns(cols);
			     SetSheetHeight(100);
			     SetEditable(1);
		      	 SetCountPosition(0);
	        }
		break;
		
		case "sheet3":      //sheet3 init
		    with(sheetObj){
		      var HeadTitle1="Total|Matched|Un-matched";
		      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"Total",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:"Matched",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:"Unmatched",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		      InitColumns(cols);
		      SetSheetHeight(100);
		      SetEditable(1);
       		  SetCountPosition(0);
	        }
		break;
		}
	}

	/**
	 * Sheet handling process
	 */ 
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
			case IBSEARCH: 
				if(!validateForm(sheetObj, formObj, sAction)) return false;
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
				sheetObjects[2].RemoveAll();
				sheetObjects[3].RemoveAll();
				sheetObjects[4].RemoveAll();
				formObj.data_chk[0].checked=true;
				formObj.f_cmd.value=SEARCH;	
				
				var sXml=sheetObj.GetSearchData("ESM_BKG_0164GS.do", FormQueryString(formObj));
				
				searchFlag=true;
				loadExcelFlg=false;
				ComBtnEnable("btn_loadExcel");
				var sheetObj4 = sheetObjects[3];

				var arrXml=sXml.split("|$$|");
        		if (arrXml.length > 0) {
        			sheetObj.LoadSearchData(arrXml[0],{Sync:1} );
        			sheetObj4.LoadSearchData(arrXml[1],{Sync:1} );
        		}
        		
				var dataCount=ComGetTotalRows(arrXml[0]);
				if( dataCount < 1 ) {
					return;
				}
				
				var tot_bkg=sheetObj.GetCellValue(sheetObj.LastRow(), "rnum");
				var tot_20=0;
				var tot_40=0;
				var tot_45=0;	
				for(var i=1; i<sheetObj.RowCount()+1; i=i+2){
					if(sheetObj.GetCellValue(i, "bkg_qty1") == "20") tot_20++;
					if(sheetObj.GetCellValue(i, "bkg_qty1") == "40") tot_40++;
					if(sheetObj.GetCellValue(i, "bkg_qty1") == "45") tot_45++;
				}
				
				// Sheet2 - OPUSPUS, Terminal value
				var sheetObj2=sheetObjects[1];
                sheetObj2.RemoveAll();					           	
                var row=sheetObj2.DataInsert(-1);	               
				sheetObj2.SetCellValue(row, "Total","OPUS",0);
				sheetObj2.SetCellBackColor(row, "Total","#C1C4E8");
				sheetObj2.SetCellValue(row, "BKG",tot_bkg,0);
				sheetObj2.SetCellValue(row, "Qty20",tot_20,0);
				sheetObj2.SetCellValue(row, "Qty40",tot_40,0);
				sheetObj2.SetCellValue(row, "Qty45",tot_45,0);					
								
				row=sheetObj2.DataInsert(-1);
				sheetObj2.SetCellValue(row, "Total","Terminal",0);
				sheetObj2.SetCellBackColor(row, "Total","#C1C4E8");
				
				var sheetObj3=sheetObjects[2];					
                row=sheetObj3.DataInsert(-1);
	               
			break;	
			
			case IBRESET: // New
				formObj.reset();
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
				sheetObjects[2].RemoveAll();
				sheetObjects[3].RemoveAll();
				sheetObjects[4].RemoveAll();
				sheetObjects[5].RemoveAll();
				searchFlag=false;
				loadExcelFlg=false;
				ComBtnDisable('btn_loadExcel');
				formObj.vvd.focus();
			break;		
			
			case IBLOADEXCEL: // Load Excel
				if(!searchFlag) return;
	            sheetObjects[4].LoadExcel();
			break;
			
			case IBDOWNEXCEL: // Down Excel
	            sheetObj.SetWaitImageVisible(0);
				
	            ComOpenWait(true); 
	     
	            if(loadExcelFlg){
	            	if(sheetObjects[0].RowCount() < 1){//no data
	            		  ComShowCodeMessage("COM132501");
	            	}else{
	            		sheetObjects[0].Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1 });
	            	}
				}else{
					if(sheetObjects[3].RowCount() < 1){//no data
	            		  ComShowCodeMessage("COM132501");
	            	}else{
	            		sheetObjects[3].Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1 });
	            	}
				} 
				ComOpenWait(false); 
	            sheetObj.SetWaitImageVisible(1);
			break;
			
		}
	}
	
	function sheet5_OnLoadExcel(sheetObj, result, code, msg) {
		if(isExceedMaxRow(msg)) return;
		matchCnt=0;
		unMatchCnt=0;
		
		if(result){
			searchFlag=false;
		    sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true); 
			loadExcelFlg=true;
			ComBtnDisable("btn_loadExcel");
			
			for(var i=1; i<=sheetObj.RowCount(); i++){
				if(sheetObj.GetCellValue(i, "bkg_no") == "" && sheetObj.GetCellValue(i, "bkg_qty1") == "" &&
						sheetObj.GetCellValue(i, "fpod") == "" && sheetObj.GetCellValue(i, "cntr_no") == "") {
				sheetObj.RowDelete(i, false);
				i--;
				continue;
				}
				sheetObj.SetCellValue(i, "rnum", "");
				sheetObj.SetCellValue(i, "kind", "T");
				sheetObj.SetCellValue(i, "match", "");
			}
			sheetObjects[0].RemoveAll();

			copySheet(sheetObjects[0], sheetObjects[3], sheetObjects[4]);
			rearrangeData(sheetObjects[0]);
		} else {
        	formObj.reset();
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
			sheetObjects[2].RemoveAll();
			sheetObjects[3].RemoveAll();
			sheetObjects[4].RemoveAll();
			searchFlag=false;
			loadExcelFlg=false;
			ComBtnDisable('btn_loadExcel');
			formObj.vvd.focus();
		}
	}
	
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSEARCH: // retrieve
			if (formObj.vvd.value == "" || formObj.vvd.value.length != 9) {
				ComShowCodeMessage('BKG00213');
				formObj.vvd.focus();
				return false;
			}
			if (formObj.pol_cd.value == "" || formObj.pol_cd.value.length != 5) {
				ComShowCodeMessage('BKG00213');
				formObj.pol_cd.focus();
				return false;
			}
			return true;
		break;	
		}
		return true;
	}
	/**
	 * RD print
	 */
	function rdOpen(){
		var appendReport = [];
		var mrdParam = "";
		var sXml="<?xml version='1.0' ?><SHEET>";
		sXml += RD_GetDataSearchXml(sheetObjects[0], 1);
		sXml += "</SHEET>";
		var strPath=RD_path+'apps/opus/esm/bkg/terminaldocumentation/cllcdlmanifest/report/ESM_BKG_0784.mrd';
		mrdParam = "/rdata ["+sXml+"]";

		appendReport.push({mrdPath: strPath, mrdParam: mrdParam});
		directReportDownload(appendReport);
	}
	
	function copySheet(targetSheet, fromSheet1, fromSheet2, match)  {
		try {
			var allXml="";
			var hColSep="|";
			var sColSep="☜☞";
			var sColOrder="";
			var aryTD=new Array(columnCount);
			var k=0;
			for(var i=0; i < columnCount; i++){
				if (targetSheet.ColSaveName(i) != -1)
					aryTD[i]=targetSheet.ColSaveName(i);
			}
			sColOrder=aryTD.join(hColSep);
			allXml="<?xml version='1.0'  ?>\n" 
				   + "<SHEET>\n"
			       + "  <DATA COLORDER='" + sColOrder + "' COLSEPARATOR='" + sColSep + "'>\n";
			var aryTR=new Array();
			for( var ir=fromSheet1.HeaderRows(); ir<fromSheet1.RowCount()+ fromSheet1.HeaderRows(); ir++ ) {
				if(match=="M" && fromSheet1.GetCellValue(ir, "match")!="M"){
					continue;
				}else if(match=="U" && fromSheet1.GetCellValue(ir, "match")!="U"){
					continue;
				}
				for(var ic=0; ic<columnCount; ic++){
					aryTD[ic]=fromSheet1.GetCellValue(ir, ic);
				}
				aryTR[k++]="    <TR><![CDATA[" + aryTD.join(sColSep)+ "]]></TR>";
			}
			if(fromSheet2!=null && fromSheet2!=""){
				for( var ir=fromSheet2.HeaderRows(); ir<fromSheet2.RowCount()+ fromSheet2.HeaderRows(); ir++ ) {
					for(var ic=0; ic<columnCount; ic++){
						aryTD[ic]=fromSheet2.GetCellValue(ir, ic);
					}
					aryTR[k++]="    <TR><![CDATA[" + aryTD.join(sColSep)+ "]]></TR>";
				}
			}
			allXml += aryTR.join("\n");
			allXml += "  \n</DATA>\n"
			       +  "</SHEET>";
				aryTD=new Array();
				aryTR=new Array();
			targetSheet.LoadSearchData(allXml, {Sync:1});
		} catch(err) { ComFuncErrMsg(err.message); }
	}  
	
	function rearrangeData(sheetObj){
		for(var i=1; i<=sheetObj.RowCount(); i++){
			if(sheetObj.GetCellValue(i, "bkg_no") == "") {
				sheetObj.SetCellValue(i, "bkg_no",sheetObj.GetCellValue(i-1, "bkg_no"),0);
			}
		}
		sheetObj.ColumnSort("bkg_no|cntr_no", "ASC", "ASC|ASC", 1);
	}
	
	var matchCnt;
	var unMatchCnt;
	function sheet1_OnSort(sheetObj, Col, SortArrow) {
		var sheet_load = sheetObj;
		var sheet_temp = sheetObjects[4];
		var colName = "";
		var ColArray = Col.split("|");
		for(var s=0; s<ColArray.length; s++){
			if(s==0){
				colName = sheetObj.ColSaveName(0, ColArray[s]);
			}else{
				colName = colName + "|" + sheetObj.ColSaveName(0, ColArray[s]);
			}
		}
		
		if(colName == "bkg_no|cntr_no") {
		
			/******************************************
			 *  loaded Data Seq,Kind(T) value setting
			 ******************************************/
			
			for(var i=1; i<=sheetObj.RowCount(); i++){
				if(sheetObj.GetCellValue(i, "rnum") == ""){					
					sheetObj.SetCellValue(i, "rnum",sheet_load.GetCellValue(i-1, "rnum"),0);
					
				}
			}
			
			sheet_load.ColumnSort("rnum|kind", "ASC", "ASC|ASC", 1);
			
		}else if(colName == "rnum|kind"){
			
			var addRow;
			for(var i=1; i<=sheetObj.RowCount(); i++){
				
				if(sheetObj.GetCellValue(i, "kind") == "T"){
					/******************************************************************************* 
					 * If no matching data found between loaded data and retrieved data
					 * row add -> Seq, Kind(A) value setting 
					 * - UnMatch show, UnMatch count
					 *******************************************************************************/					
					if( sheetObj.GetCellValue(i, "bkg_no") != sheetObj.GetCellValue(i-1, "bkg_no") 
							|| sheetObj.GetCellValue(i, "cntr_no") != sheetObj.GetCellValue(i-1, "cntr_no") ) {
						sheet_load.SelectCell(i,0);
						addRow=sheet_load.DataInsert(i);
						i++;
						sheetObj.SetCellValue(addRow, "kind","A",0);
						sheetObj.SetCellValue(addRow, "rnum",sheet_load.GetCellValue(i, "rnum"),0);
						sheetObj.SetCellValue(addRow, "match","U",0);
						sheetObj.SetCellValue(i, "match","U",0);
						sheetObj.SetRowBackColor(addRow,"#FFFFAC");
						sheetObj.SetRowBackColor(i,"#FFFFAC");
						unMatchCnt++;
					}
					
					/******************************************************************************* 
					 * If matching data found between loaded data and retrieved data
					 * - Match show, Match count
					 * In other cases
					 * - UnMatch show, UnMatch count
					 *******************************************************************************/ 
					else {						
						if( sheetObj.GetCellValue(i, "bkg_no")   == sheetObj.GetCellValue(i-1, "bkg_no")   &&
							sheetObj.GetCellValue(i, "bkg_qty1") == sheetObj.GetCellValue(i-1, "bkg_qty1") &&
							sheetObj.GetCellValue(i, "fpod")     == sheetObj.GetCellValue(i-1, "fpod")     &&
							sheetObj.GetCellValue(i, "cntr_no")  == sheetObj.GetCellValue(i-1, "cntr_no") ) 
						{
						    sheetObj.SetCellValue(i-1, "match","M",0);
							sheetObj.SetCellValue(i, "match","M",0);
							matchCnt++;
						}else{
							sheetObj.SetCellValue(i-1, "match","U",0);
							sheetObj.SetCellValue(i, "match","U",0);
							sheetObj.SetRowBackColor(i-1,"#FFFFAC");
							sheetObj.SetRowBackColor(i,"#FFFFAC");
							unMatchCnt++;
						}
						
					}
					
				}				
			}

			/******************************************************************************* 
			 * If no matching data found between loaded data and retrieved data
			 * row add -> Seq, Kind(T) value setting 
			 * - UnMatch show, UnMatch count
			 *******************************************************************************/
			for(var i=1; i<=sheet_load.RowCount(); i++){
				if(sheet_load.GetCellValue(i, "match") == " "){
					sheet_load.SelectCell(i,0);
					addRow=sheet_load.DataInsert(i+1);
					sheet_load.SetCellValue(addRow, "kind","T",0);
					sheet_load.SetCellValue(addRow, "rnum",sheet_load.GetCellValue(i, "rnum"),0);
					sheet_load.SetCellValue(addRow, "match","U",0);
					sheet_load.SetCellValue(i, "match","U",0);
					sheet_load.SetRowBackColor(addRow,"#FFFFAC");
					sheet_load.SetRowBackColor(i,"#FFFFAC");
					unMatchCnt++;
				}
			}
			/****************************************************
			 * key value again duplicate set Seq 
			 ****************************************************/
			var rowCnt=1;
			for(var i=1; i<=sheet_load.RowCount(); i=i+2){
				sheet_load.SetCellValue(i, "rnum",rowCnt,0);
				sheet_load.SetCellValue(i+1, "rnum",rowCnt,0);
				rowCnt++;
			}
			sheet_load.ColumnSort("rnum|match|kind", "ASC", "ASC|ASC|ASC", 1);
			
		}else if(colName == "rnum|match|kind"){
			sheet_load.SelectCell(1,1);
			sheet_load.SelectCell(0,0);
			/****************************************************
			 * Sheet2 - Terminal BkgQty Value count
			 ****************************************************/
			var tmnlBkgNoCnt=0;
			var tmnlBkg20Cnt=0;
			var tmnlBkg40Cnt=0;
			var tmnlBkg45Cnt=0;
			for(var i=1; i<=sheet_temp.RowCount(); i++){
				if( ComTrim(sheet_temp.GetCellValue(i, "bkg_no")).length == 0 && ComTrim(sheet_temp.GetCellValue(i, "bkg_qty1")).length == 0 && ComTrim(sheet_temp.GetCellValue(i, "fpod")).length == 0 && ComTrim(sheet_temp.GetCellValue(i, "cntr_no")).length == 0 ) {
					sheet_temp.RowDelete(i, false);
				}
				if(sheet_temp.GetCellValue(i, "bkg_no") != "" || sheet_temp.GetCellValue(i, "cntr_no") != ""){
					if(sheet_temp.GetCellValue(i, "bkg_qty1") == "20") tmnlBkg20Cnt++;
					if(sheet_temp.GetCellValue(i, "bkg_qty1") == "40") tmnlBkg40Cnt++;
					if(sheet_temp.GetCellValue(i, "bkg_qty1") == "45") tmnlBkg45Cnt++;
				}
			}
			findIdx=sheet_temp.FindText("cntr_no", "Total");
			if(findIdx > 0) tmnlBkgNoCnt=findIdx-1;
			else tmnlBkgNoCnt=sheet_temp.RowCount();
			/********************************************************
			 * Sheet2,Sheet3 - Total, BkgQty, Match, UnMatch value setting
			 ********************************************************/
			sheetObjects[1].SetCellValue(2, "BKG",tmnlBkgNoCnt,0);
			sheetObjects[1].SetCellValue(2, "Qty20",tmnlBkg20Cnt,0);
			sheetObjects[1].SetCellValue(2, "Qty40",tmnlBkg40Cnt,0);
			sheetObjects[1].SetCellValue(2, "Qty45",tmnlBkg45Cnt,0);
			sheetObjects[2].SetCellValue(1, "Total",matchCnt+unMatchCnt,0);
			sheetObjects[2].SetCellValue(1, "Matched",matchCnt,0);
			sheetObjects[2].SetCellValue(1, "Unmatched",unMatchCnt,0);
			
			for(var i=1; i<=sheet_load.RowCount(); i++){
				sheet_load.SetCellValue(i, "seq", i);
			}
			ComOpenWait(false); 
			sheetObj.SetWaitImageVisible(1);
			
			copySheet(sheetObjects[5], sheetObjects[0]);
		}
	}
	
