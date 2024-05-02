/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0337
*@FileTitle  : MSN Create
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/08
=========================================================*/

var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
document.onclick=processButtonClick;
function processButtonClick(){
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
		case "btn_Retrieve":
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;
		case "btn_ManifestGeneration":
			doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
			break;
		case "btn_EDISend":
			doActionIBSheet(sheetObjects[2], document.form, COMMAND02);
			break;
		case "btn_Inquiry":
//			var params="mrn_no="+formObject.in_mrn_no.value +
//			"&vvd="+formObject.in_vvd.value+
//			"&port_cd="+formObject.in_port.value +
//			"&pgmNo=ESM_BKG_0358";
//			var rtnObj=ComOpenWindowCenter("ESM_BKG_0358.do?"+params,'MrnInquiry' ,1024,600, false);
//			if (rtnObj) {
//				formObject.in_mrn_no.value=rtnObj.mrn_no;
//				formObject.in_mrn_chk_no.value=rtnObj.mrn_chk_no;
//				formObject.in_vvd.value=rtnObj.vvd;
//				formObject.in_port.value=rtnObj.port_cd;
//			}
			var params="mrn_no="+formObject.in_mrn_no.value +
			"&vvd="+formObject.in_vvd.value+
			"&port_cd="+formObject.in_port.value +
			"&pgmNo=ESM_BKG_0358";
			//var rtnObj=ComOpenWindowCenter("ESM_BKG_0358_POP.do?"+params,'MrnInquiry' ,1024,600, true);

			ComOpenPopup("ESM_BKG_0358_POP.do?"+params, 1024, 600, "searchMrnNo", "1,0", true);
//

//			var params="mrn_no="+formObject.in_mrn_no.value +
//			"&vvd="+formObject.in_vvd.value+
//			"&port_cd="+formObject.in_port.value +
//			"&pgmNo=ESM_BKG_0358";
//			var rtnObj = ComOpenWindowCenter("ESM_BKG_0358_POP.do?"+params,"ESM_BKG_0358" ,1024,600, true);
//			if (rtnObj) {
//				formObject.in_mrn_no.value=rtnObj.mrn_no;
//				formObject.in_mrn_chk_no.value=rtnObj.mrn_chk_no;
//				formObject.in_vvd.value=rtnObj.vvd;
//				formObject.in_port.value=rtnObj.port_cd;
//			}
			break;
		}
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}

function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++]=sheet_obj;
}

function loadPage() {
	for(i=0;i<sheetObjects.length;i++) {
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	for(k=0;k<tabObjects.length;k++) {
		initTab(tabObjects[k],k+1);
		tabObjects[k].SetSelectedIndex(0);
	}
	ComBtnDisable("btn_EDISend");
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
}

function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	var sheetid=sheetObj.id;
	switch(sheetid) {
	case "t1sheet1":
		with(sheetObj){
			var HeadTitle1="Sel|Seq.|VVD|POL|ETD|POD|Yard|ETA|B/L Record";
			var headCount=ComCountHeadTitle(HeadTitle1);

			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"Radio",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Sel"                },
						 {Type:"Seq",       Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"t1SEQ",      Edit:0 },
						 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"vvd",        Edit:0 },
						 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",     Edit:0 },
						 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vps_etd_dt", Edit:0 },
						 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",     Edit:0 },
						 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pod_yd_cd",  Edit:0 },
						 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vps_eta_dt", Edit:0 },
						 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cnt_bl_no",  Edit:0 } ];

			InitColumns(cols);
			SetEditable(1);
			SetCountPosition(0);
			SetSheetHeight(380);
		}
		break;

	case "t2sheet1":
		with(sheetObj){
			var HeadTitle1="Sel|Seq.|VVD|POL|ETD|POD|Yard|ETA|B/L Record";
			var headCount=ComCountHeadTitle(HeadTitle1);

			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"Radio",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Sel"               },
						 {Type:"Seq",       Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"t2SEQ",      Edit:0 },
						 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"vvd",        Edit:0 },
						 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",     Edit:0 },
						 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vps_etd_dt", Edit:0 },
						 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",     Edit:0 },
						 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pod_yd_cd",  Edit:0 },
						 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vps_eta_dt", Edit:0 },
						 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cnt_bl_no",  Edit:0 } ];

			InitColumns(cols);
			SetEditable(1);
			SetCountPosition(0);
			SetSheetHeight(380);
		}
		break;

	case "sheet3":
		with(sheetObj){
			var HeadTitle1="|Sel";
			var headCount=ComCountHeadTitle(HeadTitle1);

			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag"  },
						 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Sel"     } ];

			InitColumns(cols);
			SetEditable(1);
			SetCountPosition(0);
			SetVisible(false);
		}
		break;
	}
}

function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
	case IBSEARCH:
		tabObjects[0].SetSelectedIndex(0);
		//sheetObjects[0].focus();
		formObj.f_cmd.value=SEARCH;
		if(validateForm(sheetObj,formObj,sAction)) {
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			var sXml=sheetObj.GetSearchData("ESM_BKG_0337GS.do", FormQueryString(formObj) );
			var arrXml=sXml.split("|$$|");
			for(var i=0; i < arrXml.length; i++)
			{
//				sheetObjects[i].RenderSheet(0);
				if(i > 0) sheetObjects[i].SetWaitImageVisible(0);
				sheetObjects[i].LoadSearchData(arrXml[i],{Sync:1} );
//				sheetObjects[i].RenderSheet(1);
			}
			for(var i=0; i < sheetObj.RowCount(); i++)
			{
				sheetObj.SetRowHidden(i,0);
			}
			if(sheetObj.GetEtcData('mrn_no')!=null) {
				formObj.in_mrn_no.value=sheetObj.GetEtcData('mrn_no').substring(0,10);
				formObj.in_mrn_chk_no.value=sheetObj.GetEtcData('mrn_no').substring(10,11);
			}
			formObj.snd_dt.value=sheetObj.GetEtcData('snd_dt')==null? '':sheetObj.GetEtcData('snd_dt');
			formObj.rslt_dt.value=sheetObj.GetEtcData('rslt_dt')==null? '':sheetObj.GetEtcData('rslt_dt');
			formObj.rslt.value=sheetObj.GetEtcData('rslt')==null? '':sheetObj.GetEtcData('rslt');
			formObj.err_msg.value=sheetObj.GetEtcData('err_msg')==null? '':sheetObj.GetEtcData('err_msg');
			formObj.in_vvd.value=sheetObj.GetEtcData('vvd')==null? '':sheetObj.GetEtcData('vvd');
			formObj.in_port.value=sheetObj.GetEtcData('port')==null? '':sheetObj.GetEtcData('port');
			document.all.t1simple.innerHTML=sheetObj.GetEtcData('local_bl_tp_simple')==null? '0':sheetObj.GetEtcData('local_bl_tp_simple');
			document.all.t1console.innerHTML=sheetObj.GetEtcData('local_bl_tp_console')==null? '0':sheetObj.GetEtcData('local_bl_tp_console');
			document.all.t1empty.innerHTML=sheetObj.GetEtcData('local_bl_tp_empty')==null? '0':sheetObj.GetEtcData('local_bl_tp_empty');
			document.all.t2simple.innerHTML=sheetObj.GetEtcData('ts_bl_tp_simple')==null? '0':sheetObj.GetEtcData('ts_bl_tp_simple');
			document.all.t2console.innerHTML=sheetObj.GetEtcData('ts_bl_tp_console')==null? '0':sheetObj.GetEtcData('ts_bl_tp_console');
			document.all.t2empty.innerHTML=sheetObj.GetEtcData('ts_bl_tp_empty')==null? '0':sheetObj.GetEtcData('ts_bl_tp_empty');
			if (sheetObj.GetEtcData('edi_snd_ind')!=null && sheetObj.GetEtcData('edi_snd_ind') > 7) {
				ComBtnDisable("btn_EDISend");
			}else {
				ComBtnEnable("btn_EDISend");
			}
			ComOpenWait(false);
		}
		break;
	case COMMAND01:
		if(validateForm(sheetObj,formObj,sAction)){
			if (sheetObjects[beforetab].RowCount()< 1 || sheetObjects[beforetab].GetSelectRow()< 1) {
				ComShowCodeMessage('BKG00249');
			}else {
				var params="?type=";
				if (beforetab==0) {
					params=params + "Local";
				}else {
					params=params + "T/S";
				}
				var Row=sheetObjects[beforetab].GetSelectRow();
				if (sheetObjects[beforetab].GetCellValue(Row, "Sel")==0) {
					ComShowCodeMessage('BKG00249');
				}else {
					params=params + "&vvd=" + sheetObjects[beforetab].GetCellValue(Row, "vvd");
					params=params + "&mrn_no=" + formObj.in_mrn_no.value;
					params=params + "&mrn_chk_no=" + formObj.in_mrn_chk_no.value;
					params=params + "&mode=Inbound";
					params=params + "&pol=" + sheetObjects[beforetab].GetCellValue(Row, "pol_cd");
					params=params + "&etd=" + sheetObjects[beforetab].GetCellValue(Row, "vps_etd_dt");
					params=params + "&pod=" + sheetObjects[beforetab].GetCellValue(Row, "pod_cd");
					params=params + "&eta=" + sheetObjects[beforetab].GetCellValue(Row, "vps_eta_dt");
					params=params + "&cnt_bl_no=" + sheetObjects[beforetab].GetCellValue(Row, "cnt_bl_no");
					params=params + "&yard=" + sheetObjects[beforetab].GetCellValue(Row, "pod_yd_cd");
					params=params + "&pgmNo=ESM_BKG_0338";
					ComOpenWindowCenter('/opuscntr/ESM_BKG_0338.do'+params, 'msnCreatePop' ,1010,650, false);
				}
			}
		}
		break;
	case COMMAND02:
		if(validateForm(sheetObj,formObj,sAction)){
			if(ComShowCodeConfirm('BKG95003', 'Transmit')){
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				formObj.f_cmd.value=COMMAND02;
				sheetObj.RemoveAll();
				sheetObj.DataInsert();
				var sXml=sheetObj.doSave("ESM_BKG_0337GS.do", FormQueryString(formObj), -1, false);
				ComOpenWait(false);
			}
		}
		break;
	}
}

function setTabObject(tab_obj){
	tabObjects[tabCnt++]=tab_obj;
}

function initTab(tabObj , tabNo) {
	switch(tabNo) {
	case 1:
		with (tabObj) {
			var cnt=0 ;
			InsertItem( "LOCAL" , "");
			InsertItem( "T/S" , "");
		}
		break;
	}
}

function tab1_OnChange(tabObj , nItem)
{
	var objs=document.all.item("tabLayer");
	objs[nItem].style.display="Inline";
	objs[beforetab].style.display="none";
	objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
	beforetab=nItem;
	if (nItem==0 && sheetObjects[0].GetEtcData("edi_snd_ind")!=null && sheetObjects[0].GetEtcData("edi_snd_ind") < 8 ) {
		ComBtnEnable("btn_EDISend");
	}else {
		ComBtnDisable("btn_EDISend");
	}
}

function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		if (formObj.in_vvd.value < 9) {
			ComShowCodeMessage("COM130201", "VVD");
			formObj.in_vvd.focus();
			return false;
		}
		if (formObj.in_port.value < 5) {
			ComShowCodeMessage("COM130201", "Port");
			formObj.in_port.focus();
			return false;
		}
		if (formObj.in_vvd.value.length==9) {
			formObj.in_vsl_cd.value=formObj.in_vvd.value.substring(0,4);
			formObj.in_skd_voyage_no.value=formObj.in_vvd.value.substring(4,8);
			formObj.in_skd_dir_cd.value=formObj.in_vvd.value.substring(8,9);
		}else {
			formObj.in_vsl_cd.value='';
			formObj.in_skd_voyage_no.value='';
			formObj.in_skd_dir_cd.value='';
		}
	}
	return true;
}

function t2sheet1_OnClick(sheetObj,Row, Col, Value)
{
	sheetObj.SetCellValue(Row,"Sel",1);
}

function t1sheet1_OnClick(sheetObj,Row, Col, Value)
{
	sheetObj.SetCellValue(Row,"Sel",1);
}

function t1sheet1_OnDblClick(sheetObj, Row, Col, Value) {
	doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
}

function t2sheet1_OnDblClick(sheetObj, Row, Col, Value) {
	doActionIBSheet(sheetObjects[1], document.form, COMMAND01);
}

function searchMrnNo(rtnObj){
	var formObject=document.form;

	if (rtnObj) {
		formObject.in_mrn_no.value=rtnObj.mrn_no;
		formObject.in_mrn_chk_no.value=rtnObj.mrn_chk_no;
		formObject.in_vvd.value=rtnObj.vvd;
		formObject.in_port.value=rtnObj.port_cd;
	}

}
