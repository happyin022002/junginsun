/*========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_TRS_0922.js
*@FileTitle  : The Transportation Service Order Management
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
// Common global variable
var verifyFlag=false;
var sheetObjects=new Array();
var sheetCnt=0;
/* Click the button to define an event handler that receives and processes events */
document.onclick=processButtonClick;
/* Button to process certain filename, separated on a quarterly event handler to handle */
function processButtonClick(){
	 var sheetObject=sheetObjects[0];
	 /*******************************************************/
	 var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case 'btng_downexcel':
				if(sheetObject.RowCount() < 1){
					ComShowCodeMessage("COM132501");
				}else{
					sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol_TRS(sheetObject), SheetDesign:1, Merge:1 });
				} 				
			break;
			case 'btn_apply':
				var checkList=sheetObject.FindCheckedRow('ibcheck');
				if(checkList == ''){
					ComShowCodeMessage('COM12176');
					return false;
				}
				ComOpenWait(true);
				sheetObject.DoSearch("ESD_TRS_0969.screen", '',{Sync:2,Append:true} );
				if(!verifyFlag){
					ComShowCodeMessage('TRS90055');
					ComOpenWait(false);
					return;
				}
				importInvoiceFile(sheetObject);
				ComOpenWait(false);
				ComClosePopup(); 
				break;
			case "btn_fileselect":
 				sheetObject.LoadExcel({ Mode:"HeaderMatch",WorkSheetNo:"1",WorkSheetName:"",Append:false});
				break;
			case "btn_verify":
				if(sheetObject.RowCount()< 1) return;
				getVerifyEqNo(sheetObject, formObject);
				break;
			case "btn_close":
				ComClosePopup(); 
				break;
		} 
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage('COM12111');
		} else {
			ComShowMessage(e.message);
		}
	}
}

/**
 * Register as an array IBSheet Object
 * setSheetObject
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
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
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
		 case 1:      //sheet1 init
			    with(sheetObj){
				      var HeadTitle="|Seq.| |Verify Result|EQ No|EQ TP/SZ|S/O No|W/O No|Reference No|Invoice Total Amount|trsp_wo_ofc_cty_cd|trsp_wo_seq|trsp_so_ofc_cty_cd|trsp_so_seq|nis_check|cntr_sub_flg";
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ 
				                     {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
						             {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trsp_so_cmb_seq" },
						             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibcheck",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"Text",      Hidden:0, Width:240,  Align:"Left",    ColMerge:1,   SaveName:"inv_rmk",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2000,UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_no",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"prnt_trsp_so_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"prnt_trsp_so_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:"ref_inv_no",               KeyField:0,   CalcLogic:"",   Format:"",       	  PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Float",     Hidden:0, Width:130,  Align:"right",   ColMerge:1,   SaveName:"inv_bzc_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"trsp_wo_ofc_cty_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"trsp_wo_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:"trsp_so_ofc_cty_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:"trsp_so_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"CheckBox",  Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:"nis_check" },
						             {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:"cntr_sub_flg" } 
						          ];
				       
				      InitColumns(cols);
				      SetEditable(1);
				      SetColHidden('ibflag',1);
				      ComResizeSheet(sheetObj);
		      }
		   break;
	}
}
/*
 * Numbers can be used
 */
function get_only_num(obj) {
	var str=escape(obj);
	var returnNum='';
	for (i=0; i<str.length; i++){
		if (str.charCodeAt(i) >= 48 && str.charCodeAt(i) <= 57 )
		returnNum += str.charAt(i);
	}
	return returnNum;
}
function sheet1_OnChange(sheetObj, row, col, value){
	var formObject=document.form;
	var colName=sheetObj.ColSaveName(col);
	switch(colName){
	case 'trsp_so_ofc_cty_cd_seq':
		if(value != ''){
			sheetObj.SetCellValue(i, 'trsp_so_ofc_cty_cd',value.substring(0,3),0);
			sheetObj.SetCellValue(i, 'trsp_so_seq',value.substring(3),0);
		}
		break;
	case 'trsp_wo_ofc_cty_cd_seq':
		if(value != ''){
			sheetObj.SetCellValue(i, 'trsp_wo_ofc_cty_cd',value.substring(0,3),0);
			sheetObj.SetCellValue(i, 'trsp_wo_seq',value.substring(3),0);
		}
		break;
	}
}
function getVerifyEqNo(sheetObj, formObj){
	var checkList=sheetObj.FindCheckedRow('ibcheck');
	var checkArray=checkList.split('|');
	if(checkList == '') return;
	ComOpenWait(true);
 	sheetObj.DoSearch("ESD_TRS_0969.screen", '', {Sync:2,Append:true} );
	var opener_queryStr=getOpenerData();
	ComOpenWait(false);
	formObj.f_cmd.value=SEARCH14;
    var queryStr = sheetObj.GetSaveString(0, 1, "ibcheck");
    var rtnData = sheetObj.GetSaveData("ESD_TRS_0033_01GS.do", queryStr+'&'+TrsFrmQryString(formObj)+'&'+opener_queryStr, "ibcheck", false, true);
    sheetObj.LoadSaveData(rtnData);
}

function getSearchRowData(sheetObj, Row) {
	var queryStr = '';
	queryStr += '&ibflag='	+sheetObj.GetCellValue(Row, 'ibflag');
	queryStr += '&trsp_so_cmb_seq='	+sheetObj.GetCellValue(Row, 'trsp_so_cmb_seq');
	queryStr += '&ibcheck='	+sheetObj.GetCellValue(Row, 'ibcheck');
	queryStr += '&inv_rmk='	+sheetObj.GetCellValue(Row, 'inv_rmk');
	queryStr += '&eq_no='	+sheetObj.GetCellValue(Row, 'eq_no');
	queryStr += '&eq_tpsz_cd='	+sheetObj.GetCellValue(Row, 'eq_tpsz_cd');
	queryStr += '&prnt_trsp_so_ofc_cty_cd='	+sheetObj.GetCellValue(Row, 'prnt_trsp_so_ofc_cty_cd');
	queryStr += '&prnt_trsp_so_seq='	+sheetObj.GetCellValue(Row, 'prnt_trsp_so_seq');
	queryStr += '&ref_inv_no='	+sheetObj.GetCellValue(Row, 'ref_inv_no');
	queryStr += '&inv_bzc_amt='	+sheetObj.GetCellValue(Row, 'inv_bzc_amt');
	queryStr += '&trsp_wo_ofc_cty_cd='	+sheetObj.GetCellValue(Row, 'trsp_wo_ofc_cty_cd');
	queryStr += '&trsp_wo_seq='	+sheetObj.GetCellValue(Row, 'trsp_wo_seq');
	queryStr += '&trsp_so_ofc_cty_cd='	+sheetObj.GetCellValue(Row, 'trsp_so_ofc_cty_cd');
	queryStr += '&trsp_so_seq='	+sheetObj.GetCellValue(Row, 'trsp_so_seq');
	queryStr += '&nis_check='	+sheetObj.GetCellValue(Row, 'nis_check');
	queryStr += '&cntr_sub_flg='	+sheetObj.GetCellValue(Row, 'cntr_sub_flg');
	return queryStr;
}
/**
 * When an error occurs, save the results to a common processing function
 */
function sheet1_OnSearchEnd(sheetObj, errMsg) {
	var formObj=document.form;
	if( errMsg != null && errMsg != '' ) {
	} else {
		if(formObj.f_cmd.value == SEARCH14){
			verifyFlag=true;
		}
	}
}
function getOpenerData(){
	var sheetObj_audit=opener.sheetObjects[0];
	var sheetObj_confirm=opener.sheetObjects[1];
	var prefix='opener_';
	var queryStr='';
	for(var i=2; i< sheetObj_audit.RowCount()+2; i++){
		queryStr += '&'+prefix+'trsp_so_ofc_cty_cd='	+sheetObj_audit.GetCellValue(i, 'trsp_so_ofc_cty_cd');
		queryStr += '&'+prefix+'trsp_so_seq='			+sheetObj_audit.GetCellValue(i, 'trsp_so_seq');
		queryStr += '&'+prefix+'trsp_wo_ofc_cty_cd='	+sheetObj_audit.GetCellValue(i, 'trsp_wo_ofc_cty_cd');
		queryStr += '&'+prefix+'trsp_wo_seq='			+sheetObj_audit.GetCellValue(i, 'trsp_wo_seq');
		queryStr += '&'+prefix+'eq_no='					+sheetObj_audit.GetCellValue(i, 'eq_no');
		queryStr += '&'+prefix+'trsp_so_cmb_seq='		+i;
		queryStr += '&'+prefix+'ibflag=R'
	}
	for(var i=2; i< sheetObj_confirm.RowCount()+2; i++){
		queryStr += '&'+prefix+'trsp_so_ofc_cty_cd='	+sheetObj_confirm.GetCellValue(i, 'trsp_so_ofc_cty_cd');
		queryStr += '&'+prefix+'trsp_so_seq='			+sheetObj_confirm.GetCellValue(i, 'trsp_so_seq');
		queryStr += '&'+prefix+'trsp_wo_ofc_cty_cd='	+sheetObj_confirm.GetCellValue(i, 'trsp_wo_ofc_cty_cd');
		queryStr += '&'+prefix+'trsp_wo_seq='			+sheetObj_confirm.GetCellValue(i, 'trsp_wo_seq');
		queryStr += '&'+prefix+'eq_no='					+sheetObj_confirm.GetCellValue(i, 'eq_no');
		queryStr += '&'+prefix+'trsp_so_cmb_seq='		+i;
		queryStr += '&'+prefix+'ibflag=R'
	}
	return queryStr;
}
function importInvoiceFile(sheetObj_popup){
	var sheetObj_main=opener.sheetObjects[0];
	var formObj=document.form;
	var queryStr=sheetObj_popup.GetSaveString(false, true, "ibcheck");
	if(queryStr=='') return false;
	formObj.f_cmd.value=SEARCH15;
	opener.form.f_cmd.value=SEARCH15;
	sheetObj_main.DoSearch("ESD_TRS_0033GS.do", queryStr+"&"+ TrsFrmQryString(formObj),{Sync:2, Append:true} );
}

function sheet1_OnLoadExcel(sheetObj, result, code, msg){
    if(isExceedMaxRow(msg))return;

	sheetObjects[0].CheckAll('ibcheck',1,1);
	for(var i=1; i<sheetObjects[0].RowCount()+1; i++){
		sheetObjects[0].SetCellValue(i, 'inv_rmk','',0);
	}
	for(var a=sheetObjects[0].RowCount(); a > 0 ;a--){
		if(sheetObjects[0].GetCellValue(a, 'eq_no') == '' && sheetObjects[0].GetCellValue(a, 'prnt_trsp_so_ofc_cty_cd') == '' && sheetObjects[0].GetCellValue(a, 'prnt_trsp_so_seq') == '') {
			sheetObjects[0].RowDelete(a, false);
		}
	}
}
