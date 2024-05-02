/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_PRD_0001.js
*@FileTitle  : Some Title 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

var sheetObjects=new Array();
var sheetCnt=0;
var retValidate=0;
/* Event handler processing by button click event */
document.onclick=processButtonClick;

/* Event handler processing by button name */
function processButtonClick(){
	var sheetObject=sheetObjects[0];
	var formObject=document.form;
	var param ;
	try {
		var srcName=ComGetEvent("name");
		/****************************
             handling enterKey
            *****************************/
		var srcObj=ComGetEvent("nodeName");
		var keyObj=window.event.keyCode;
		if(srcObj =='INPUT' && keyObj ==13) {
			srcName='btn_retrieve';
		}
		/****************************/
		switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
			case "btn_new":
				sheetObject.RemoveAll();
				var opts=formObject.select2;
				  for(var i=opts.length-1; i>0 ; i--) {
				   opts[i].parentNode.removeChild(opts[i]);
				  }
				formObject.reset();
				break;
			case "btn_location":
				param='?classId=COM_ENS_051&loc_cd='+formObject.location_code.value;
				ComOpenPopup('/opuscntr/COM_ENS_051.do' + param, 800, 550, 'getLocation', "1,0,1,1,1,1,1,1,1,1,1,1", true);
				break;
			case "btn_country":
				param='?classId=COM_ENS_051&cnt_cd='+formObject.country_code.value;
				ComOpenPopup('/opuscntr/COM_ENS_0M1.do' + param, 770, 510, 'getCountry', "1,0,1,1,1,1,1,1,1,1,1,1", true);
				break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(ComGetMsg('COM12111'));
		} else {
			ComShowMessage(e.message);
		}
	}
}

function getCountry(rowArray) {
	var colArray=rowArray[0];
	document.form.country_code.value=colArray[3];
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
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); 
	axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form);
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:      //IBSheet1 init
		    with(sheetObj){
				var HeadTitle="No.|Continent|Continent|Sub Continent|Sub Continent|Country Code|Country Code|Country Code|Region|Region|Location|Location|Remarks|"+
				"SteCd|SteNm|UnLocFlg|UnLocCd|LocGrdNo|RccCd|LccCd|EccCd|SccCd|LocChrCd|"+
				"SlsOfcCd|EqCtrlOfcCd|FincCtrlOfcCd|BkgBlPfxCd|ComercialZone|"+
				"Customers|RepZdnCd|EqRtnYdCd|LocAmsPortCd|GmtHrs|PortInlndCd|CallPortFlg" ;
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"conti_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"conti_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"sconti_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"sconti_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cnt_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"cnt_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bsel_co",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rgn_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:125,  Align:"Left",    ColMerge:1,   SaveName:"rgn_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"loc_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"remark",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ste_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ste_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"un_loc_ind_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"un_loc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"loc_grd_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rcc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"lcc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ecc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"scc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"loc_chr_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"sls_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"eq_ctrl_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"finc_ctrl_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"bkg_bl_pfx_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"comercial_zone",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"customers",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rep_zn_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"eq_rtn_yd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"loc_ams_port_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"gmt_hrs",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"port_inlnd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"call_port_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"mty_pkup_yd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	       
				InitColumns(cols);
				SetEditable(0);
		        SetSheetHeight(140 );
			}
		    break;
	}
}

// handling of Sheet process
function doActionIBSheet(sheetObj,formObj,sAction) {
	var sXml ;
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH:      
			form_clear();
			if(formObj.subconti_code.value=='' && formObj.country_code.value=='' && formObj.region_code.value=='' && formObj.location_code.value==''){
				ComShowMessage(ComGetMsg("PRD90001"));
				return;
			}
			if(validateForm(sheetObj,formObj,sAction))
				formObj.f_cmd.value=SEARCH;
			sheetObj.DoSearch("ESD_PRD_0001GS.do", PrdFQString(formObj) , {Sync:2});
			break;
		case IBSAVE:        
			if(validateForm(sheetObj,formObj,sAction))
				break;
		case IBINSERT:      
			if(validateForm(sheetObj,formObj,sAction))
				sheetObj.DataInsert();
			break;
		case IBCOPYROW:        
			sheetObj.DataCopy();
			break;
		case IBDOWNEXCEL:        
			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
			break;
		case SEARCH02:
			formObj.f_cmd.value=SEARCH02;
			sXml=sheetObj.GetSaveData("PRD_VALIDATE.do","uid=ESD_PRD_0001&check_data="+validateData+"&"+PrdFQString(formObj));
			retValidate=ComGetEtcData(sXml, "rowCount");
			break;
	}
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
	}
	return true;
}

function sheet1_OnDblClick(sheetObj, row, col, value) {
	var formObj=document.form ;
	formObj.g_cnti_cd.value=sheetObj.GetCellValue(row, "conti_cd");
	formObj.g_cnti_nm.value=sheetObj.GetCellValue(row, "conti_nm");
	formObj.g_ste_cd.value=sheetObj.GetCellValue(row, "ste_cd");
	formObj.g_ste_nm.value=sheetObj.GetCellValue(row, "ste_nm");
	formObj.g_subcnti_cd.value=sheetObj.GetCellValue(row, "sconti_cd");
	formObj.g_subcnti_nm.value=sheetObj.GetCellValue(row, "sconti_nm");
	formObj.g_loc_cd.value=sheetObj.GetCellValue(row, "loc_cd");
	formObj.g_loc_nm.value=sheetObj.GetCellValue(row, "loc_nm");
	formObj.g_cntr_cd.value=sheetObj.GetCellValue(row, "cnt_cd");
	formObj.g_cntr_nm.value=sheetObj.GetCellValue(row, "cnt_nm");
	formObj.g_un_flag.value=sheetObj.GetCellValue(row, "un_loc_ind_cd");
	formObj.g_un_cd.value=sheetObj.GetCellValue(row, "un_loc_cd");
	formObj.g_rgn_cd.value=sheetObj.GetCellValue(row, "rgn_cd");
	formObj.g_rgn_nm.value=sheetObj.GetCellValue(row, "rgn_nm");
	formObj.loc_grid.value=sheetObj.GetCellValue(row, "loc_grd_no");
	formObj.sls_ofc.value=sheetObj.GetCellValue(row, "sls_ofc_cd");
	formObj.rcc_cd.value=sheetObj.GetCellValue(row, "rcc_cd");
	formObj.bl_frefix.value=sheetObj.GetCellValue(row, "bkg_bl_pfx_cd");
	formObj.cms_zone.value=sheetObj.GetCellValue(row, "comercial_zone");
	formObj.eq_ofc.value=sheetObj.GetCellValue(row, "eq_ctrl_ofc_cd");
	formObj.lcc_cd.value=sheetObj.GetCellValue(row, "lcc_cd");
	formObj.custms.value=sheetObj.GetCellValue(row, "customers");
	formObj.rep_zn_cd.value=sheetObj.GetCellValue(row, "rep_zn_cd");
	formObj.fin_ofc.value=sheetObj.GetCellValue(row, "finc_ctrl_ofc_cd");
	formObj.ecc_cd.value=sheetObj.GetCellValue(row, "ecc_cd");
	formObj.loc_char.value=sheetObj.GetCellValue(row, "loc_chr_cd");
	formObj.refre_cy.value=sheetObj.GetCellValue(row, "eq_rtn_yd_cd");
	formObj.scc_cd.value=sheetObj.GetCellValue(row, "scc_cd");
	formObj.gmt.value=sheetObj.GetCellValue(row, "gmt_hrs");
	formObj.ams_cd.value=sheetObj.GetCellValue(row, "loc_ams_port_cd");
	formObj.port_cd.value=sheetObj.GetCellValue(row, "port_inlnd_cd");
	formObj.coll_port.value=sheetObj.GetCellValue(row, "call_port_flg");
	formObj.mty_pkup_yd_cd.value=sheetObj.GetCellValue(row, "mty_pkup_yd_cd");
}

//////////////////////////////////////////////////////////////
function changeContinent() {
	var list=document.form.select1;
	var c_code=list.options[list.selectedIndex].value;
	if(c_code!='0'){
		document.form.f_cmd.value=SEARCH19;
		document.form.conti_code.value=c_code ;
		document.form.subconti_code.value='' ;
		document.form.action="ESD_PRD_COM_0002.do";
		document.form.target="HiddenFrame";
		document.form.submit();
	} else {
		document.form.conti_code.value='' ;
		document.form.subconti_code.value='' ;
		var opts=document.form.select2;
		  for(var i=opts.length-1; i>0 ; i--) {
		   opts[i].parentNode.removeChild(opts[i]);
		  }
	}
}

function changeSubContinent() {
	var list=document.form.select2;
	var c_code=list.options[list.selectedIndex].value;
	if(c_code!='0'){
		document.form.f_cmd.value='101';
		document.form.subconti_code.value=c_code ;
	}else{
		document.form.subconti_code.value='' ;
	}
}

// calling from location input
function getLocation(rowArray) {
	var colArray=rowArray[0];
	document.form.location_code.value=colArray[3];
}

function form_clear() {
	var formObj=document.form ;
	formObj.g_cnti_cd.value="";
	formObj.g_cnti_nm.value="";
	formObj.g_ste_cd.value="";
	formObj.g_ste_nm.value="";
	formObj.g_subcnti_cd.value="";
	formObj.g_subcnti_nm.value="";
	formObj.g_loc_cd.value="";
	formObj.g_loc_nm.value="";
	formObj.g_cntr_cd.value="";
	formObj.g_cntr_nm.value="";
	formObj.g_un_flag.value="";
	formObj.g_un_cd.value="";
	formObj.g_rgn_cd.value="";
	formObj.g_rgn_nm.value="";
	formObj.loc_grid.value="";
	formObj.sls_ofc.value="";
	formObj.rcc_cd.value="";
	formObj.bl_frefix.value="";
	formObj.cms_zone.value="";
	formObj.eq_ofc.value="";
	formObj.lcc_cd.value="";
	formObj.custms.value="";
	formObj.rep_zn_cd.value="";
	formObj.fin_ofc.value="";
	formObj.ecc_cd.value="";
	formObj.loc_char.value="";
	formObj.refre_cy.value="";
	formObj.scc_cd.value="";
	formObj.gmt.value="";
	formObj.ams_cd.value="";
	formObj.port_cd.value="";
	formObj.coll_port.value="";
}