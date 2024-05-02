/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0037.js
*@FileTitle  : B/L Inquiry: Container Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/04
=========================================================*/
//Common global variable
var sheetObjects=new Array();
var sheetCnt=0;
var seal_knd_str="M|E";
var seal_pty_tp_str="CA|SH|AA|CU|AB|AC|TO";
//Event handler processing by button click event */
document.onclick=processButtonClick;
//Event handler processing by button name */
 function processButtonClick(){
      /*****  Tab ->two or more sheet : sheet  a variable assignment *****/
	  var sheetObject=sheetObjects[0];
      /*******************************************************/
      var formObject=document.form;
 	try {
 		var srcName=ComGetEvent("name");
 		if(ComGetBtnDisable(srcName)) return false;
        switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				doActionIBSheet(sheetObjects[2],document.form,IBROWSEARCH);								
			break; 
			case "btn_save":
				doActionIBSheet(sheetObjects[0],document.form,IBSAVE);	
			break;
			case "btn_add":
				doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
			break;
			case "btn_del":
				doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
			break;																					
			case "btn_close":
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
         ComConfigSheet (sheetObjects[i] );
         initSheet(sheetObjects[i],i+1);
         ComEndConfigSheet(sheetObjects[i]);
     }
	 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
//	 doActionIBSheet(sheetObjects[2],document.form,IBROWSEARCH);
//	axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
//	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
//	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
}
/**
  * setting sheet initial values and header
  * param : sheetObj, sheetNo
  * adding case as numbers of counting sheets
  */
 function initSheet(sheetObj,sheetNo) {
     var cnt=0;
     var sheetID=sheetObj.id;
     switch(sheetID) {
         case "sheet1":      //sheet1 init
             with (sheetObj) {
             SetFocusEditMode(2);
             SetFocusAfterProcess(1);
             var HeadTitle1="|Sel.|Seq.|B/L No.|CONTAINER|TY/SZ|SEAL No. 1|SEAL No. 2|SEAL No. 2|Type|";
             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
             var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
             var headers = [ { Text:HeadTitle1, Align:"Center"} ];
             InitHeaders(headers, info);
             var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                    {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Sel" },
                    {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
                    {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"bl_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
                    {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"seal_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"seal_no2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Popup",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"seal_no3",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"full_mty_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Text",      Hidden:1, Width:130,  Align:"Center",  ColMerge:0,   SaveName:"bak_cntr_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
             InitColumns(cols);
             SetEditable(1);
             SetShowButtonImage(2);
             SetColProperty("full_mty_cd", {ComboText:"F\tFull|P\tEmpty", ComboCode:"F|M"} );
             SetSheetHeight(240);
             }
             break;
         case "sheet2":
         case "sheet3":
             with (sheetObj) {
             var HeadTitle="||BL NO|Container|Seal Seq|Seal No|knd_cd|pty_tp";
             SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
             var headers = [ { Text:HeadTitle, Align:"Center"} ];
             InitHeaders(headers, info);
             var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                 {Type:"DummyCheck", Hidden:0, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"sel" },
                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bl_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:140,  Align:"Right",   ColMerge:0,   SaveName:"cntr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:140,  Align:"Right",   ColMerge:0,   SaveName:"seal_no_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:140,  Align:"Right",   ColMerge:0,   SaveName:"seal_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seal_knd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seal_pty_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
             InitColumns(cols);
             SetEditable(1);
             SetDataAutoTrim(0);
             SetSheetHeight(200);
             }
         break;
     }
 }
/**
 * Sheet handling process
 */ 
function doActionIBSheet(sheetObj,formObj,sAction,Row,Col) {
	switch(sAction) {
		case IBSEARCH:      //Retrieve
			if(!validateForm(sheetObj,formObj,sAction)) return false;
    		ComOpenWait(true);
	        formObj.f_cmd.value=SEARCH;
	        formObj.sheet_id.value=sheetObj.id;
	        sheetObj.DoSearch("ESM_BKG_0037GS.do", FormQueryString(formObj) );
    		ComOpenWait(false);
			break;
		case IBROWSEARCH:
	        formObj.f_cmd.value=SEARCH;
	        formObj.sheet_id.value=sheetObj.id;
	        sheetObj.DoSearch("ESM_BKG_0037GS.do", FormQueryString(formObj) );
			if(sheetObj.RowCount()== 0) sheetObj.RemoveAll();
		 	break;
		case IBSAVE:        //Save
			if(!validateForm(sheetObj,formObj,sAction)) return false;
		 	if(ComShowCodeConfirm('BKG95003', 'save')){   // Do you want to ...?
	    		ComOpenWait(true);
		        formObj.f_cmd.value=MULTI;
        		var sheetObj2=sheetObjects[2];
		        var sheet1Xml="";
		        var sheet2Xml="";
		        // Container storage changes
		        if(sheetObj.GetSaveString() != ""){
	    	        formObj.sheet_id.value=sheetObj.id;
		        	var params=FormQueryString(formObj)+"&"+sheetObj.GetSaveString();
		        	sheet1Xml=sheetObj.GetSaveData("ESM_BKG_0037GS.do", params);
			        var state=ComGetEtcData(sheet1Xml,ComWebKey.Trans_Result_Key);
			        if (state == "S") {
				        // Seal No.Container storage changes
				        if(sheetObj2.GetSaveString() != ""){
			    	        formObj.sheet_id.value=sheetObj2.id;
			    	        sheetObj2.ColumnSort("bl_no|cntr_no", "ASC");
			    	        for(var i=0; i<sheetObj2.RowCount()+1; i++){
			    	        	if(sheetObj2.GetRowStatus(i) == "R"){
			    	        		sheetObj2.SetRowStatus(i,"U");
			    	        	}
			    	        }
				        	sheetObj2.DoSave("ESM_BKG_0037GS.do", FormQueryString(formObj), -1, false);
				        }
//		        		doActionIBSheet(sheetObj,formObj,IBSEARCH);
//		        		doActionIBSheet(sheetObj2,formObj,IBROWSEARCH);
			        }else{
			        	return false;
			        }
		        }
	    		ComOpenWait(false);
		 	}
		 	break;
		case IBINSERT:     
			sheetObj.DataInsert(-1);
			sheetObj.SetCellValue(sheetObj.GetSelectRow(), "bl_no",formObj.bl_no.value);
			sheetObj.SetCellValue(sheetObj.GetSelectRow(), "full_mty_cd","");
			break;
		case IBDELETE:    
			if(sheetObj.CheckedRows(1) == 0){
				ComShowCodeMessage('BKG00249'); // No Selected Row
				return;
			}
			ComShowCodeMessage('BKG03037');
			ComRowHideDelete(sheetObj,"Sel");
			break;
		case SEARCH01:
			if(!validateForm(sheetObj,formObj,sAction,Row,Col))return false;
			formObj.f_cmd.value=SEARCH01;
			var val=sheetObj.GetCellValue(Row,Col);
			var params=FormQueryString(formObj)+"&"+sheetObj.GetSaveString();
			var sXml=sheetObj.GetSearchData("ESM_BKG_0037GS.do", params);
    		var cntr_no=ComGetEtcData(sXml, "cntr_no");
    		var cntr_tpsz_cd=ComGetEtcData(sXml, "cntr_tpsz_cd");
    		if(cntr_no == undefined){
    			ComShowCodeMessage("BKG06012", val);
    			sheetObj.SetCellValue(Row, "cntr_no","",0);
    			sheetObj.SetCellValue(Row, "cntr_tpsz_cd","",0);
    			//sheetObj.ReturnCellData(Row, "cntr_no");
    			sheetObj.SelectCell(Row, "cntr_no");
    		}else{
				sheetObj.SetCellValue(Row, "cntr_tpsz_cd",cntr_tpsz_cd,0);
				sheetObj.SetCellValue(Row, "cntr_no",cntr_no,0);
    		}
			break;
    }
}
 /**
  * handling process for input validation
  */
 function validateForm(sheetObj,formObj,sAction){
	    switch(sAction) {
		case IBSEARCH: { 
			//Check the default format
	    	if (!ComChkObjValid(formObj.bl_no)) return false;
			break;
		}
		case IBSAVE: { 
			//Check the default format
			var sheetObj1=sheetObjects[0];
			var sheetObj2=sheetObjects[2];
	    	if (!ComChkObjValid(formObj.bl_no)) return false;
			if (sheetObj1.GetSaveString() == "" && sheetObj2.GetSaveString() == ""){
				ComShowCodeMessage('BKG00743'); 
				return false;
			}
			else{
				for( var i=sheetObj2.HeaderRows(); i<=sheetObj2.LastRow(); i++ ){
					if(sheetObj2.GetCellText(i, "bl_no") == ""){
						sheetObj2.SetCellValue(i, "bl_no",formObj.bl_no.value,0);
					}
				}
			}
			break;
		}
		case SEARCH01: {
			return true;
			break;
		}
     }
     return true;
 }
/**
 * Sheet Change Event Processing
 */
 function sheet1_OnChange(sheetObj, row, col, val){
	var formObject=document.form;
    var col_save_name=sheetObj.ColSaveName(col);
 	if (col_save_name != "Sel"){
		var bl_no=sheetObj.GetCellValue(row, "bl_no");
		var cntr_no=sheetObj.GetCellValue(row, "cntr_no").toUpperCase();
 	}
 	if (col_save_name == "cntr_no"){
 		if(cntr_no == 'NC') {
 			sheetObj.SetCellValue(row, "cntr_tpsz_cd","",0);
 			sheetObj.SetCellValue(row, "seal_no","");
 			sheetObj.SetCellValue(row, "seal_no2","");
 			return;
 		}
 		for(i=1; i<sheetObj.RowCount()+1; i++){
 			if(i != row && sheetObj.GetCellValue(i, "cntr_no") == val){
 				//Container No. {?msg1} is duplicated. Check container number.
 				ComShowCodeMessage("BKG00965", val);
 				sheetObj.SetCellValue(row, col,"",0);
 				return;
 			}
 		}
 		doActionIBSheet(sheetObj,formObject,SEARCH01,row,col);
 	}
	/* seal_no */
	if (col_save_name == "seal_no" || col_save_name == "seal_no2") {
		var fmObject=sheetObjects[2];
		var arrRow=findText(fmObject, "cntr_no", cntr_no);
		var len=arrRow.length;
		if(len <= 1){
			if(val != ''){
				var newRow=fmObject.DataInsert(-1);
				fmObject.SetCellValue(newRow, "bl_no",bl_no,0);
				fmObject.SetCellValue(newRow, "cntr_no",cntr_no,0);
				fmObject.SetCellValue(newRow, "seal_no",val,0);
			}
			else{
				if (col_save_name == "seal_no") {
					fmObject.SetCellValue(arrRow[0], "seal_no",val,0);
				}
				else{
					fmObject.SetCellValue(arrRow[0], "seal_no",val,0);
				}
			}
		} else {
			if (col_save_name == "seal_no") {
				fmObject.SetCellValue(arrRow[0], "seal_no",val,0);
			}
			else{
				fmObject.SetCellValue(arrRow[1], "seal_no",val,0);
			}
		}
		rowDelete(fmObject, "seal_no", '');
		setAllSealNo();			
	}
 }
/**
 * IBSheet cell click  popup
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet1_OnPopupClick(sheetObj, Row, Col) {
var bl_no=sheetObj.GetCellValue(Row, "bl_no");
var cntr_no=sheetObj.GetCellValue(Row, "cntr_no");
	var url="ESM_BKG_0697.do?bl_no=" +bl_no+ "&cntr_no=" + cntr_no;
	ComOpenWindowCenter(url, "ESM_BKG_0697", 500, 400, true);
}
/**
 * Multi Seal No. Related function for pop-up.
 */ 
function rowDelete(sheetObj, colName, colValue){
	var arrRow=findText(sheetObj, colName, colValue);
	for (ir=0; ir < arrRow.length; ir++) {
		if(arrRow[arrRow.length-1-ir]=='') continue;
		sheetObj.SetRowStatus(arrRow[arrRow.length-1-ir],'D');
	}
}
/**
 * sheetObject The index generation function.
 */
function findText(sheetObj, colName, colValue){
	var idxs=new Array();
	var rcnt=sheetObj.RowCount()+ 1;
	for (ix=1; ix < rcnt; ix++) {
		if(sheetObj.GetRowStatus(ix) != 'D' && sheetObj.GetCellValue(ix, colName) == colValue){
			idxs.push(''+ix);
		}
	}
	return idxs;
}
/**
 * All Container Seal_No setting
 */
function setAllSealNo(){
	var cntrObj=sheetObjects[0];
	var cntrCount=cntrObj.RowCount()+ 1;
	for(idx=1;idx<cntrCount;idx++){
		setSealNo(cntrObj.GetCellValue(idx, "cntr_no"));
	}
}
/**
 * (Hidden Seal_No ,Container) sheet reflects
 */
function setSealNo(cntr_no){
	var fmObject=sheetObjects[2]; // SealNo Hidden Sheet
	var toObject=sheetObjects[0]; // Container Sheet
	// Container Row Count
	var arrToRow=findText(toObject, "cntr_no", cntr_no);
	if(arrToRow.length == 0){
		return;
	}
	if(arrToRow.length > 1){
		return;
	}		
	// SealNo Grid Row Count
	var arrFmRow=findText(fmObject, "cntr_no", cntr_no);
	if(arrFmRow.length == 1){
		toObject.SetCellValue(arrToRow[0], "seal_no",arrFmRow[0] == '' ? "" : fmObject.GetCellValue(arrFmRow[0], "seal_no"),0);
		toObject.SetCellValue(arrToRow[0], "seal_no2",'',0);
	} else if(arrFmRow.length > 1){
		toObject.SetCellValue(arrToRow[0], "seal_no",arrFmRow[0] == '' ? "" : fmObject.GetCellValue(arrFmRow[0], "seal_no"),0);
		toObject.SetCellValue(arrToRow[0], "seal_no2",arrFmRow[1] == '' ? "" : fmObject.GetCellValue(arrFmRow[1], "seal_no"),0);
		
	} else {
		toObject.SetCellValue(arrToRow[0], "seal_no",'',0);
		toObject.SetCellValue(arrToRow[0], "seal_no2",'',0);
	}
}

/*
 * sheet1 - 트랜잭션 설정
 */
function saveSeal(flg, cntr_no){
	if(flg != null && flg == 'Y'){
		var cntrObj = sheetObjects[0];
		var arrRow = ComFindText(cntrObj, "cntr_no", cntr_no);
		
		// Insert인 경우는 유지하게 변경
		if(cntrObj.GetRowStatus(arrRow) != "I") {
//			cntrObj.CellValue2(arrRow,"ibflag") = "U";
			cntrObj.SetRowStatus(arrRow,'U');
		}
	}
	
}



/**
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet3_OnSaveEnd(sheetObj, ErrMsg) {
	if (ErrMsg == "") {
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		doActionIBSheet(sheetObjects[2],document.form,IBROWSEARCH);	
	}
}

/**
* After retrieve event
* @param sheetObj
* @param ErrMsg
* @return
*/
function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	var formObj=document.form;
	var selRow = 0;
	if (ErrMsg == "") {					
//		selRow = sheetObjects[0].GetSelectRow();
//		if(selRow > 0 ) {
			doActionIBSheet(sheetObjects[2],document.form,IBROWSEARCH);
//		}
	}
}