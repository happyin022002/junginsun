﻿/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0341.js
*@FileTitle  : Korea Manifest Print
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/28
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
	MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
	 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
//Event handler processing by button click event  */
document.onclick=processButtonClick;
//Event handler processing by button name */
function processButtonClick(){
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			break;
		case "btn_listprint":
			var exceptLines="";
			var chkCnt=0;
			for(var i=1; i <= sheetObject1.RowCount(); i++) {
				if (sheetObject1.GetCellValue(i, "Sel")==0)
					exceptLines=exceptLines + "|" + i;
				else
					chkCnt++;
			}
			if (chkCnt > 0) {
				var xmlUrl="http://"+location.hostname +":"+ location.port + "/opuscntr/apps/opus/esm/bkg/customsdeclaration/customsreport/korea/script/ESM_BKG_0341.xml";
				//sheetObjects[0].RenderSheet(0);
				if(sheetObject1.RowCount() < 1){//no data
				  ComShowCodeMessage("COM132501");
				}else{
				  //sheetObject1.Down2Excel({ HiddenColumn:1,URL:"xmlUrl",TreeLevel:false});
				  sheetObject1.Down2Excel({ HiddenColumn:1,SheetDesign:1, Merge:1});
				}
				//sheetObjects[0].RenderSheet(1);
			}else {
				ComShowCodeMessage('BKG00394');
			}
			break;
		case "btn_formprint":
			var chkCnt=0;
			var params="f_cmd="+SEARCH03;
			for(var i=1; i <= sheetObject1.RowCount(); i++) {
				if (sheetObject1.GetCellValue(i, "Sel")==1) {
					params=params + "&ibflag=R"+
							 "&vsl_cd=" + formObject.vsl_cd.value +
							 "&skd_voy_no="+formObject.skd_voy_no.value +
							 "&io_bnd_cd="+formObject.io_bnd_cd.value +
							 "&skd_dir_cd="+formObject.skd_dir_cd.value +
							 "&port_cd="+formObject.port_cd.value+
							 "&mrn_no="+formObject.mrn_no.value+formObject.mrn_chk_no.value+
							 "&bkg_no="+sheetObject1.GetCellValue(i, "bkg_no")+
							 "&pol_cd="+sheetObject1.GetCellValue(i, "pol_cd")+
							 "&pod_cd="+sheetObject1.GetCellValue(i, "pod_cd")+
							 "&fnl_pod_cd="+sheetObject1.GetCellValue(i, "fnl_pod_cd")+
							 "&mrn_bl_ts_cd="+sheetObject1.GetCellValue(i, "mrn_bl_ts_cd");
					chkCnt++;
				}
			}
			if (chkCnt > 0) {
				sheetObject2.SetWaitImageVisible(0);
				var sXml=sheetObject2.GetSearchData("ESM_BKG_0341GS.do", params);
				sheetObject2.LoadSearchData(sXml,{Sync:1} );
				sheetObject2.ColumnSort("msn_no");
				if (formObject.io_bnd_cd.value=="I") {
					ComOpenWindowCenter("/opuscntr/ESM_BKG_0827.do?pgmNo=ESM_BKG_0827", "0827", 1024, 750, false);
				}else {
					ComOpenWindowCenter("/opuscntr/ESM_BKG_5029.do?pgmNo=ESM_BKG_5029", "5029", 1024, 750, false);
				}
			}else {
				ComShowCodeMessage('BKG00394');
			}
			break;
		case "btn_selectAll":
			for(var i=1; i <= sheetObjects[0].RowCount(); i++) {
				sheetObjects[0].SetCellValue(i, "Sel",1);
			}
			break;
		case "btn_deselectAll":
			for(var i=1; i <= sheetObjects[0].RowCount(); i++) {
				sheetObjects[0].SetCellValue(i, "Sel",0);
			}
			break;
		case "mrn_no":
			formObject.search_type[1].checked=true;
			checkSearchType();
			break;
		case "vvd":
			formObject.search_type[0].checked=true;
			checkSearchType();
			break;
		case "port_cd":
			formObject.search_type[0].checked=true;
			checkSearchType();
			formObject.port_cd.focus();
			break;
		case "btn_mrn_search":
			var sUrl="ESM_BKG_0358_POP.do?mrn_no="+formObject.mrn_no.value;
			sUrl=sUrl + "&pgmNo=ESM_BKG_0358";
			//var rtnVal=ComOpenWindowCenter(sUrl, "ESM_BKG_0358", 1024, 600, true);

			ComOpenPopup(sUrl, 800, 500, "searchMrn", "1,0,1,1,1,1,1", true);

			//if (rtnVal != null) {
			//    formObject.mrn_no.value=rtnVal.mrn_no;
			//    formObject.mrn_chk_no.value=rtnVal.mrn_chk_no;
			//    formObject.search_type[1].checked=true;
			//}
			break;
		case "search_type": // handling disable true or false
			checkSearchType();
			break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

function searchMrn(rtnVal) {

	var formObject=document.form;

	if (rtnVal != null) {
		formObject.mrn_no.value=rtnVal.mrn_no;
		formObject.mrn_chk_no.value=rtnVal.mrn_chk_no;
		formObject.search_type[1].checked=true;
	}
}


/**
* check enable checkbox
* @return
*/
function checkSearchType()
{
	var formObject=document.form;
	if (formObject.search_type[1].checked) {
		formObject.mrn_no.className="input1";
		formObject.vvd.className="input2";
		formObject.port_cd.className="input2";
		formObject.mrn_no.focus();
	}else {
		formObject.vvd.className="input1";
		formObject.port_cd.className="input1";
		formObject.mrn_no.className="input2";
		formObject.vvd.focus();
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
* adding first-served functions after loading screen
*/
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	checkSearchType();
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
		with(sheetObj){

		  var HeadTitle="|Sel.|Seq|MSN|BKG No.|B/L No.|Local\n/T/S|POL|POD|Type|Final\nPOD|Consignee Name|Notify Name|DG\nClass|Bonded W/H Detail";

		  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

		  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		  var headers = [ { Text:HeadTitle, Align:"Center"} ];
		  InitHeaders(headers, info);

		  var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"Status" },
				 {Type:"CheckBox",  Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"Sel",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:0 },
				 {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"Seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
				 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"mf_seq_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:95,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"mrn_bl_ts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"kr_cstms_bl_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"fnl_pod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:180,  Align:"Left",    ColMerge:0,   SaveName:"cust_c_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:180,  Align:"Left",    ColMerge:0,   SaveName:"cust_n_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"imdg_clss_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"wh_name",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"con_vvd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];

		  InitColumns(cols);

		  SetEditable(1);
		  SetSheetHeight(410);
			}


	break;
	case "sheet2":      //sheet1 init
		with(sheetObj){

	  var HeadTitle="|MRN_NO|MRN_BL_TS_CD|VSL_ENG_NM|SKD_VOY_NO|CALL_SGN_NO|CNT_NM|LOC1_INFO|LOC2_INFO|VPS_ETB_DT|MSN_NO|BL_TP_CD|BL_NO|BKG_CUST_TP_CD|CUST_INFO|C_INFO|N_INFO|S_INFO|CNTR_INFO|CSTMS_DESC|PCK_QTY|TOT_WGT|IMDG_UN_NO|WH_NM|VPS_ETD_DT";
	  var headCount=ComCountHeadTitle(HeadTitle);

	  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

	  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	  var headers = [ { Text:HeadTitle, Align:"Center"} ];
	  InitHeaders(headers, info);

	  var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"mrn_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"mrn_bl_ts_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vsl_eng_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"call_sgn_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cnt_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"loc1_info",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"loc2_info",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vps_etb_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"msn_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_cust_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cust_info",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"c_cust_info",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n_cust_info",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"s_cust_info",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_info",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cstms_desc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"pck_qty",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"tot_wgt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"imdg_un_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"wh_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vps_etd_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];

	  InitColumns(cols);

	  SetEditable(1);
	  //SetSheetHeight(0);
	  SetVisible(0);
			}


	break;
	}
}
//handling sheet process
function doActionIBSheet(sheetObj,formObj,sAction) {
	switch(sAction) {
	case IBSEARCH:
		formObj.f_cmd.value=SEARCH;
		if(validateForm(sheetObj,formObj,sAction)) {
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			if (formObj.io_bnd_cd.value=="O") {
				if (formObj.mrn_bl_ts_cd2.value=="I") {
					formObj.mrn_bl_ts_cd.value="E";
				}else if (formObj.mrn_bl_ts_cd2.value=="T") {
					formObj.mrn_bl_ts_cd.value="R";
				}else {
					formObj.mrn_bl_ts_cd.value="";
				}
			}else {
				formObj.mrn_bl_ts_cd.value=formObj.mrn_bl_ts_cd2.value;
			}
			var sXml=sheetObj.GetSearchData("ESM_BKG_0341GS.do", FormQueryString(formObj));
			//sheetObjects[0].RenderSheet(0);
			sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
			//checked all
			sheetObjects[0].CheckAll(1,1);
			//sheetObjects[0].RenderSheet(1);
			ComEtcDataToForm(formObj, sheetObj);
			formObj.mrn_no.value     = sheetObj.GetEtcData("mrn_no")!=null?sheetObj.GetEtcData("mrn_no"):"";
			formObj.vvd.value        = sheetObj.GetEtcData("vvd")!=null?sheetObj.GetEtcData("vvd"):"";
			formObj.vsl_cd.value=formObj.vvd.value.substring(0,4);
			formObj.skd_voy_no.value=formObj.vvd.value.substring(4,8);
			formObj.skd_dir_cd.value=formObj.vvd.value.substring(8,9);
			// change title by Bound division
			if (formObj.io_bnd_cd.value=='I') {
				sheetObjects[0].SetCellValue(0, "cust_c_nm","Consignee Name");
				sheetObjects[0].SetCellValue(0, "cust_n_nm","Notify Name");
			}else {
				sheetObjects[0].SetCellValue(0, "cust_c_nm","Shipper Name");
				sheetObjects[0].SetCellValue(0, "cust_n_nm","Consignee Name");
			}
			//ComOpenWait(false);
		}
		break;
	}
}

function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
	ComOpenWait(false);
}

function sheet2_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
	ComOpenWait(false);
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		if (formObj.search_type[0].checked) {
			if (formObj.vvd.value.length < 9 ) {
				ComShowCodeMessage('BKG00203');
				formObj.vvd.focus();
				return false;
			}
			if (formObj.port_cd.value.length < 5) {
				ComShowCodeMessage('BKG00203');
				formObj.port_cd.focus();
				return false;
			}
			formObj.vsl_cd.value=formObj.vvd.value.substring(0,4);
			formObj.skd_voy_no.value=formObj.vvd.value.substring(4,8);
			formObj.skd_dir_cd.value=formObj.vvd.value.substring(8,9);
		}else {
			if (formObj.mrn_no.value.length < 9) {
				ComShowCodeMessage('BKG00689');
				formObj.mrn_no.focus();
				return false;
			}
		}
	}
	return true;
}
/**
 * handling keypress
 * @return
 */
function obj_keypress(){
	obj=event.srcElement;
	if(obj.dataformat == null) return;
	window.defaultStatus=obj.dataformat;
	switch(obj.dataformat) {
	case "ymd":
	case "ym":
	case "hms":
	case "hm":
	case "jumin":
	case "num":
		ComKeyOnlyNumber(obj);
		break;
	case "saupja":
		ComKeyOnlyNumber(obj);
		break;
	case "int":
		if(obj.name=="txtInt") ComKeyOnlyNumber(obj, "-")
		else ComKeyOnlyNumber(obj);
		break;
	case "float":
		ComKeyOnlyNumber(obj, "-.");
		break;
	case "eng":
		ComKeyOnlyAlphabet(); break;
	case "engup":
		ComKeyOnlyAlphabet('upper'); break;
	case "engupnum":
		ComKeyOnlyAlphabet('uppernum'); break;
	case "engdn":
		if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
		else ComKeyOnlyAlphabet('lower');
		break;
	}
}