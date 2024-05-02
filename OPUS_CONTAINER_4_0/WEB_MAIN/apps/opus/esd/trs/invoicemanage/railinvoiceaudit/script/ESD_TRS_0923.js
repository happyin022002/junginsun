/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESD_TRS_0923.js
*@FileTitle  : USA Rail Invoice File Import
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30
=========================================================*/
/**
* @extends 
* @class ESD_TRS_0923 : business script for ESD_TRS_0923
*/
var sheetObjects=new Array();
var sheetCnt=0;
document.onclick=processButtonClick;
function processButtonClick(){
	 var sheetObject=sheetObjects[0];
	 /*******************************************************/
	 var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btng_select":
				doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
				break;
			case "btng_verify":
				doActionIBSheet(sheetObject,formObject,IBSAVE);
				break;
			case "btn_apply":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
			case "btn_close":
				ComClosePopup(); 
				break;
		} 
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage("TRS90392");
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * Register as an array IBTab Object
 * The next batch of other items when you need treatment of fiberglass can add to an array that holds the process
 * Array defined at the top of the source
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
			with (sheetObj) {
		        var HeadTitle="STS|Seq.|S|A|CNTR No.|Waybill No.|Waybill Date|Origin|Destination|Amount|Verify Result|1||||||||||||||||||||||||coincidence_check|descrepancy_check|inv_only_check|pay_flg|wo_exe_dt|org_gate_out_dt|dest_gate_in_dt|" +
		        		"Internal\nRemark|Internal\nRemark|BKG No.";
	
		        SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
		        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		        var headers = [ { Text:HeadTitle, Align:"Center"} ];
		        InitHeaders(headers, info);
	
		        var cols = [ 
		                   {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			               {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq",                       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibcheck",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"apply_check",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"wbl_no",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
			               {Type:"Date",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"wbl_dt",                    KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:0, Width:120,  Align:"Left",    ColMerge:0,   SaveName:"inv_org_nod_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:0, Width:120,  Align:"Left",    ColMerge:0,   SaveName:"inv_dest_nod_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Float",     Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"inv_bil_amt",               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:0,   SaveName:"result",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eq_no",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			               {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cgo_tp_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"fm_nod_cd1",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
			               {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"fm_nod_cd2",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"to_nod_cd1",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
			               {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"to_nod_cd2",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			               {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"bzc_amt",                   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"fuel_scg_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"hzd_mtrl_scg_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"etc_add_amt",               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"ovr_wgt_scg_amt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"inv_curr_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"inv_etc_add_amt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"inv_bzc_amt",               KeyField:0,   CalcLogic:"|bzc_amt|+|fuel_scg_amt|+|hzd_mtrl_scg_amt|+|etc_add_amt|+|ovr_wgt_scg_amt|",Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rail_bil_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"org_trsp_rail_inv_aud_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"fm_nod_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"to_nod_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"trsp_so_ofc_cty_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"trsp_so_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"trsp_inv_tp_cd" },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"trsp_inv_co_ind_cd" },
			               {Type:"CheckBox",  Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:"coincidence_check" },
			               {Type:"CheckBox",  Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:"descrepancy_check" },
			               {Type:"CheckBox",  Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:"inv_only_check" },
			               {Type:"CheckBox",  Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"pay_flg" },
			               {Type:"Text",  	  Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"wo_exe_dt",				KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0  },
			               {Type:"Text",  	  Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"org_gate_out_dt",			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0  },
			               {Type:"Text",  	  Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"dest_gate_in_dt",			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0  },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"inter_rmk",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0  },
				           {Type:"Image",     Hidden:1, Width:20,   Align:"Center",	 ColMerge:0,   SaveName:"pop_img",				    UpdateEdit:0, InsertEdit:0,   ImgHeight:20,         ImgWidth:19 },
				           {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0  }
			              ];
		        InitColumns(cols);
		        SetEditable(1);
		        SetImageList(1, "img/btns_search_g.gif");
		        ComResizeSheet(sheetObjects[0]);
		   }
		   break;
	}
}

/*
* handling of Sheet 
*/
function doActionIBSheet(sheetObj,formObj,sAction) {
	switch(sAction) {
		case IBSAVE: 
			formObj.f_cmd.value=SEARCH01;
			var param='';
			var iCheckCount = sheetObj.CheckedRows('ibcheck');
			if(iCheckCount == 0 ) {
					ComShowCodeMessage('COM12176');					
					ComOpenWait(false);
					return false;
			}
			var checkList=sheetObj.FindCheckedRow('ibcheck');
			var checkArray=checkList.split('|');
			for(var i=0; i<checkArray.length; i++){
				param	+= '&ibflag=R&result=';
				param	+= '&seq='+sheetObj.GetCellValue(checkArray[i], 'seq');
				param	+= '&cntr_no='+sheetObj.GetCellValue(checkArray[i], 'cntr_no');
				param	+= '&wbl_dt='+sheetObj.GetCellValue(checkArray[i], 'wbl_dt');
				param	+= '&inv_bil_amt='+sheetObj.GetCellValue(checkArray[i], 'inv_bil_amt');
				param	+= '&wbl_no='+sheetObj.GetCellValue(checkArray[i], 'wbl_no');
				param	+= '&inv_org_nod_nm='+sheetObj.GetCellValue(checkArray[i], 'inv_org_nod_nm');
				param	+= '&inv_dest_nod_nm='+sheetObj.GetCellValue(checkArray[i], 'inv_dest_nod_nm');
			}
			var sXml=sheetObj.GetSaveData("ESD_TRS_0923GS.do", param+"&"+TrsFrmQryString(formObj));
			if (sXml != "") sheetObj.LoadSearchData(sXml,{Sync:1});
		break;
	   case IBSEARCH:
			apply(sheetObj);
		   break;
	   case IBLOADEXCEL:       
		   sheetObj.LoadExcel();
		  var cntr_no=null;
		  for(var row=1; row< sheetObj.RowCount()+1; row++){
			  cntr_no=sheetObj.GetCellValue(row, 'cntr_no') != null && sheetObj.GetCellValue(row, 'cntr_no') != "" ? ComTrim(sheetObj.GetCellValue(row, 'cntr_no')) : sheetObj.GetCellValue(row, 'cntr_no');
			if( cntr_no.length == 10 ){
				sheetObj.SetCellValue(row, 'cntr_no',ComGetCntrNoFull(cntr_no),0);
			}
		  }
		  //sheetObj.CheckAll('ibcheck','1');
		  break;
	}
}
function sheet1_OnSearchEnd(sheetObj , ErrMsg)
{
	var formObj=document.form;
	if( ErrMsg != null && ErrMsg != ''&& ErrMsg != 0 && ErrMsg != -1 ) {
		ComShowMessage(ErrMsg);
	}else{
		if(formObj.f_cmd.value == SEARCH01){
			setMainControl();
		}
	}
}

function sheet1_OnLoadExcel(sheetObj, result, code, msg){
    if(isExceedMaxRow(msg))return;
	if(code==1) {
		sheetObj.CheckAll('ibcheck','1');
	}
}

function sheet1_OnChange(sheetObj, row, col, value){
	var colName=sheetObj.ColSaveName(col);
	var formObj=document.form;
	switch(colName) {
		case('cntr_no'):
			sheetObj.SetCellValue(row, colName,ComGetCntrNoFull(value),0);
			break;
		case('apply_check'):
			if(value == 1 && sheetObj.GetCellValue(row, 'result') == '') {
				sheetObj.SetCellValue(row, col,0,0);
			}
			break;
	}
}
function setMainControl(){
	opener.document.form.inv_no.readOnly=true ;
	opener.document.form.currency.disabled=true;
	opener.rail_road_code.SetEnable(false);
}

function apply(sheetObj){
	for (idx=1; idx<sheetObj.RowCount()+1; idx++){
		if(sheetObj.GetCellValue(idx, 'apply_check') == '0'){
			sheetObj.SetCellValue(idx, 'coincidence_check','0',0);
			sheetObj.SetCellValue(idx, 'descrepancy_check','0',0);
			sheetObj.SetCellValue(idx, 'inv_only_check','0',0);
		}
	}
	var applyFlag = false;
	var queryStr=sheetObj.GetSaveString(false, false, 'coincidence_check');
	var xml=null;
	if(queryStr !=''){
		xml=sheetObj.GetSearchData("ESD_TRS_0969.screen", queryStr,'', true);
		opener.t1sheet1.LoadSearchData(xml,{Sync:1} );
		applyFlag = true;
	}
	queryStr=sheetObj.GetSaveString(false, false, 'descrepancy_check');
	if(queryStr !=''){
		xml=sheetObj.GetSearchData("ESD_TRS_0969.screen", queryStr,'', true);
		opener.t2sheet1.LoadSearchData(xml,{Sync:1} );
		applyFlag = true;
	}
	
//	queryStr=sheetObj.GetSaveString(false, false, 'inv_only_check');
//	if(queryStr !=''){
//		xml=sheetObj.GetSearchData("ESD_TRS_0969.screen", queryStr,'', true);
//		opener.t3sheet1.LoadSearchData(xml,{Sync:1} );
//		applyFlag = true;
//	}
	
	if(applyFlag) {
		opener.document.form.sts_cd.value="FI";
		opener.setTotalAmtForPayment();
		ComShowCodeMessage('COM12116', 'Apply');
		ComClosePopup();	
	} else {
		ComShowCodeMessage('TRS90007');
		return false;
	}
}


function getInvoiceOnlyStr(sheetObj){
	var checkList		= sheetObj.FindCheckedRow('inv_only_check');
	var checkArray		= checkList.split('|');
	var queryStr		= '';
	var result			= '';
	for(var i=0; i<checkArray.length-1; i++){
		if(i!=0){
			queryStr += '&'
		}
		queryStr += 'ibflag='+sheetObj.GetCellValue(checkArray[i], 'ibflag');
		queryStr += '&trsp_inv_co_ind_cd='+sheetObj.GetCellValue(checkArray[i], 'trsp_inv_co_ind_cd');
		queryStr += '&eq_no='+sheetObj.GetCellValue(checkArray[i], 'eq_no');
		queryStr += '&eq_tpsz_cd='+sheetObj.GetCellValue(checkArray[i], 'eq_tpsz_cd');
		queryStr += '&wbl_no='+sheetObj.GetCellValue(checkArray[i], 'wbl_no');
		queryStr += '&wbl_dt='+sheetObj.GetCellValue(checkArray[i], 'wbl_dt');
		queryStr += '&inv_org_nod_nm='+sheetObj.GetCellValue(checkArray[i], 'inv_org_nod_nm');
		queryStr += '&inv_dest_nod_nm='+sheetObj.GetCellValue(checkArray[i], 'inv_dest_nod_nm');
		queryStr += '&inv_bil_amt='+sheetObj.GetCellValue(checkArray[i], 'inv_bil_amt');
		queryStr += '&result='+sheetObj.GetCellValue(checkArray[i], 'result');
		queryStr += '&inv_curr_cd='+sheetObj.GetCellValue(checkArray[i], 'inv_curr_cd');		
	}
	return queryStr;
}