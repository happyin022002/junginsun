/*=========================================================
 *Copyright(c) 2014 CyberLogitec All Rights Reserved
 *@FileName : esm_bkg_0025.js
 *@FileTitle : Customer Code Entry
 *@author : CLT
 *@version : 1.0
 *@since : 2014.04.24
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// global variable
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var rdObjects=new Array();
var rdCnt=0;
var headCount;
// Event handler processing by button click event  */
document.onclick=processButtonClick;
/**
 * Event handler processing by button name */
function processButtonClick() {
	/***** using extra sheet valuable if there are more 2 sheets  *****/
	var sheetObject=sheetObjects[0];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObject, formObject, SEARCH);
			break;
		case "btn_Save":
			doActionIBSheet(sheetObject, formObject, MODIFY);
			break;
		case "btn_excel": 			
 			
 			if(sheetObject.RowCount() < 1){
 			  ComShowCodeMessage("COM132501");
 			}else{
// 				sheetObject.Down2Excel({ HiddenColumn:-1,TreeLevel:false});
 				sheetObject.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1 });
 			} 			
 			
			break;
		case "btn_listPrint":
			if (sheetObject.RowCount()== 0) {
				ComShowCodeMessage("BKG00889");
				return;
			}
			ComOpenWindowCenter("/opuscntr/ESM_BKG_0023.do?pgmNo=ESM_BKG_0023" + "&vvd_cd=" + formObject.vvd_cd.value + "&pod_cd=" + formObject.pod_cd.value
					+ "&del_cd=" + formObject.del_cd.value + "&bl_no=" + formObject.sch_bl_no.value + "&rd_title=Advice notes List Print", "0023", 1024, 768, false);
			break;
		case "btn_previewPrint":
			if (sheetObject.CheckedRows("chk") == 0) {
				ComShowCodeMessage('BKG00333');
				return;
			}
			bl_no="";
			tmp_bl_no="";
			
			var vStart=true;
			var vComma=false;
			for ( var i=1; i < sheetObject.RowCount()+ 1; i++) {
				if (vStart) {
					bl_no="(";
					tmp_bl_no="'";
				}
				if (sheetObject.GetCellValue(i, "chk") == "1") {
					if (vComma) {
						bl_no += ",";
						tmp_bl_no += ",";
					}
					bl_no += "'" + sheetObject.GetCellValue(i, "bl_no") + "'";
					tmp_bl_no += sheetObject.GetCellValue(i, "bl_no") + sheetObject.GetCellValue(i, "show_pu_flg");
					vComma=true;
				}
				if (i == sheetObject.RowCount()) {
					bl_no += ")";
					tmp_bl_no += "'";
				}
				vStart=false;
			}
			
			formObject.com_mrdPath.value="apps/opus/esm/bkg/customsdeclaration/customsreport/canada/report/ESM_BKG_0026.mrd";
			var strArg="/rv form_blNo[" + bl_no + "] form_ofcCd[" + formObject.ofc_cd.value + "] form_tmpBlNo[" + tmp_bl_no + "]";
			strArg = strArg + " /riprnmargin /rprncenteropt [3] /roldarithop";

			formObject.com_mrdArguments.value=strArg;
			ComOpenRDPopup();
			break;
		case "btn_fax":
			doActionIBSheet(sheetObject, formObject, MODIFY01);
			break;
		case "btn_mail":
			if (validateForm(sheetObject, formObject, MODIFY02)) {
				// Opening Pop up when B/L check and mail address are numerous
//				if (sheetObject.CheckedRows("eml_flg1") + sheetObject.CheckedRows("eml_flg2") + sheetObject.CheckedRows("eml_flg3")
//						+ sheetObject.CheckedRows("eml_flg4") + sheetObject.CheckedRows("eml_flg5") > 1) {
//					var sUrl="/opuscntr/ESM_BKG_1061.do?pgmNo=ESM_BKG_1061";
//					ComOpenPopup(sUrl, 750, 200, "SendMail", "1,0", true);
//					/*if (returnObj == undefined || returnObj == null) break;
//					formObject.attach_flg.value=returnObj.attach_flg;
//					formObject.attach_max_cnt.value=returnObj.attach_max_cnt;
//				 	doActionIBSheet(sheetObject, formObject, MODIFY02);*/
//				} else {
					formObject.attach_flg.value = "false";
					formObject.attach_max_cnt.value = 0;
					doActionIBSheet(sheetObject, formObject, MODIFY02);
//				}
			}
			break;
		case "btn_anSetup": //Code Validate
			//saving 
			doActionIBSheet(sheetObject, formObject, MULTI);
			var vvd=formObject.vvd_cd.value;
			var pod_cd=formObject.pod_cd.value;
			var del_cd=formObject.del_cd.value;
			var bl_no=formObject.sch_bl_no.value;
//			var iWidth=1040;
//			var iHeight=700;
//			var leftpos=(screen.width - iWidth) / 2;
//			if (leftpos < 0)
//				leftpos=0;
//			var toppos=(screen.height - iHeight) / 2;
//			if (toppos < 0)
//				toppos=0;
			var autoSearchFlg="N";
			if (sheetObject.RowCount()> 0 || vvd != "" || bl_no != "") autoSearchFlg="Y";
			var url="/opuscntr/ESM_BKG_1054_POP.do?mainPage=true&pgmNo=ESM_BKG_1054-1&autoSearchFlg="+ autoSearchFlg +"&";
			if (bl_no == "") {
				url=url + "&sch_tp=V" + "&vvd=" + vvd + "&pod_cd=" + pod_cd + "&del_cd=" + del_cd;
			} else {
				url=url + "&sch_tp=B" + "&bl_no=" + bl_no;
			}
//			var sFeatures="status=no, width=" + iWidth + ", height=" + iHeight + ", resizable=yes, scrollbars=yes, left=" + leftpos
//					+ ", top=" + toppos;
//			var winObj=window.open(url, "0672");
//			winObj.focus();
			
			ComOpenWindowCenter(url, "0023", 1024, 800, false);			
			break;
		case "btn_history":
			var vvd=formObject.vvd_cd.value;
			var pod_cd=formObject.pod_cd.value;
			var del_cd=formObject.del_cd.value;
			var bl_no=formObject.sch_bl_no.value;
//			var iWidth=1040;
//			var iHeight=700;
//			var leftpos=(screen.width - iWidth) / 2;
//			if (leftpos < 0)
//				leftpos=0;
//			var toppos=(screen.height - iHeight) / 2;
//			if (toppos < 0)
//				toppos=0;
			var autoSearchFlg="N";
			if (sheetObject.RowCount()> 0 || vvd != "" || bl_no != "") autoSearchFlg="Y";
			var url="/opuscntr/ESM_BKG_0001_POP.do?mainPage=false&pgmNo=ESM_BKG_0001&autoSearchFlg="+ autoSearchFlg +"&";
			if (bl_no == "") {
				url=url + "&sch_tp=V" + "&vvd=" + vvd + "&pod_cd=" + pod_cd + "&del_cd=" + del_cd;
			} else {
				url=url + "&sch_tp=B" + "&bl_no=" + bl_no;
			}
//			var sFeatures="status=no, width=" + iWidth + ", height=" + iHeight + ", resizable=yes, scrollbars=yes, left=" + leftpos
//					+ ", top=" + toppos;
//			var winObj=window.open(url, "0001");
//			winObj.focus();
			ComOpenWindowCenter(url, "0023", 1024, 670, false);
			break;
		case "btn_arrival":
			var vChkRows=sheetObject.FindCheckedRow("chk");
			if (vChkRows == "") {
				ComShowCodeMessage("BKG00333");
				return;
			} else {
				var iRow=vChkRows.split("|")[0];
				var param="?pgmNo=ESM_BKG_0020&vvd_cd=" + formObject.vvd_cd.value + "&eta_dt=" + sheetObject.GetCellValue(iRow, "eta_dt");
				ComOpenWindowCenter("/opuscntr/ESM_BKG_0020.do" + param, "0020", 500, 220, true);
			}
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComFuncErrMsg(e);
		} else {
			ComFuncErrMsg(e);
		}
	}
}

function SendMail(rtnVal) {
	var formObject = document.form;
	var sheetObject=sheetObjects[0];
	if (rtnVal == undefined || rtnVal == null) return;
	formObject.attach_flg.value=rtnVal.attach_flg;
	formObject.attach_max_cnt.value=rtnVal.attach_max_cnt;
 	doActionIBSheet(sheetObject, formObject, MODIFY02);
}

/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 * @param sheet_obj IBSheet Object
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
  * initializing sheet
  * implementing onLoad event handler in body tag
  * adding first-served functions after loading screen.
 */
function loadPage() {
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
		sheetObjects[i].SetWaitImageVisible(0);
	}
	for ( var k=0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
		tabObjects[k].SetSelectedIndex(0);
	}
	doActionIBSheet(sheetObjects[0], document.form, INIT);
	document.form.vvd_cd.focus();
	/*axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);*/
	axon_event.addListener('keydown', 'obj_KeyDown', 'form');
}
/**
 * registering IB Tab Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 * @param tab_obj tab Object
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++]=tab_obj;
}
/**
 * initializing Tab
 * setting Tab items
 * @param tabObj tab Object
 * @param tabNo tab Number
 */
function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {			
			InsertItem( "Pick up Data", "");
			InsertItem( "Fax", "");
			InsertItem( "E-Mail", "");
		}
		break;
	}
}
/**
 * Event when clicking Tab
 * activating selected tab items
 * @param tabObj tab Object
 * @param nItem tab Number
 */
function tab1_OnChange(tabObj, nItem) {
	with (sheetObjects[0]) {
		switch (nItem) {
		case 0:
			RenderSheet(0);
			ComBtnEnable("btn_arrival");
			ComBtnDisable("btn_fax");
			ComBtnDisable("btn_mail");
			SetColHidden("por_cd",0);
			SetColHidden("pol_cd",0);
			SetColHidden("pod_cd",0);
			SetColHidden("del_cd",0);
			SetColHidden("hub_loc_cd",0);
			SetColHidden("trsp_mod_id",0);
			SetColHidden("it_chk",0);
			SetColHidden("bl_cntr_cnt",0);
			SetColHidden("it_no_cntr_cnt",0);
			SetColHidden("p_mib_no",0);
			SetColHidden("ibd_loc_gds_desc",0);
			SetColHidden("avc_note_tp_id",0);
			SetColHidden("fax_ofc_cd",0);
			// ColHidden("mtch_flg") = false;
			// ColHidden("cust_seq") = false;
			// ColHidden("cust_nm") = false;
			SetColHidden("fax_flg1",1);
			SetColHidden("fax_no1",1);
			SetColHidden("fax_flg2",1);
			SetColHidden("fax_no2",1);
			SetColHidden("fax_flg3",1);
			SetColHidden("fax_no3",1);
			SetColHidden("fax_flg4",1);
			SetColHidden("fax_no4",1);
			SetColHidden("fax_flg5",1);
			SetColHidden("fax_no5",1);
			SetColHidden("fax_snd_dt",1);
			SetColHidden("fax_snd_usr_id",1);
			SetColHidden("fax_snd_usr_nm",1);
			SetColHidden("eml_flg1",1);
			SetColHidden("ntc_eml1",1);
			SetColHidden("eml_flg2",1);
			SetColHidden("ntc_eml2",1);
			SetColHidden("eml_flg3",1);
			SetColHidden("ntc_eml3",1);
			SetColHidden("eml_flg4",1);
			SetColHidden("ntc_eml4",1);
			SetColHidden("eml_flg5",1);
			SetColHidden("ntc_eml5",1);
			SetColHidden("eml_snd_dt",1);
			SetColHidden("eml_snd_usr_id",1);
			SetColHidden("eml_snd_usr_nm",1);
			RenderSheet(1);
			break;
		case 1:
			RenderSheet(0);
			ComBtnDisable("btn_arrival");
			ComBtnEnable("btn_fax");
			ComBtnDisable("btn_mail");
			SetColHidden("por_cd",1);
			SetColHidden("pol_cd",1);
			SetColHidden("pod_cd",1);
			SetColHidden("del_cd",1);
			SetColHidden("hub_loc_cd",1);
			SetColHidden("trsp_mod_id",1);
			SetColHidden("it_chk",1);
			SetColHidden("bl_cntr_cnt",1);
			SetColHidden("it_no_cntr_cnt",1);
			SetColHidden("p_mib_no",1);
			SetColHidden("ibd_loc_gds_desc",1);
			SetColHidden("avc_note_tp_id",1);
			SetColHidden("fax_ofc_cd",1);
			SetColHidden("fax_flg1",0);
			SetColHidden("fax_no1",0);
			SetColHidden("fax_flg2",0);
			SetColHidden("fax_no2",0);
			SetColHidden("fax_flg3",0);
			SetColHidden("fax_no3",0);
			SetColHidden("fax_flg4",0);
			SetColHidden("fax_no4",0);
			SetColHidden("fax_flg5",0);
			SetColHidden("fax_no5",0);
			SetColHidden("fax_snd_dt",0);
			SetColHidden("fax_snd_usr_id",0);
			SetColHidden("fax_snd_usr_nm",0);
			SetColHidden("eml_flg1",1);
			SetColHidden("ntc_eml1",1);
			SetColHidden("eml_flg2",1);
			SetColHidden("ntc_eml2",1);
			SetColHidden("eml_flg3",1);
			SetColHidden("ntc_eml3",1);
			SetColHidden("eml_flg4",1);
			SetColHidden("ntc_eml4",1);
			SetColHidden("eml_flg5",1);
			SetColHidden("ntc_eml5",1);
			SetColHidden("eml_snd_dt",1);
			SetColHidden("eml_snd_usr_id",1);
			SetColHidden("eml_snd_usr_nm",1);
			RenderSheet(1);
			break;
		case 2:
			RenderSheet(0);
			ComBtnDisable("btn_arrival");
			ComBtnDisable("btn_fax");
			ComBtnEnable("btn_mail");
			SetColHidden("por_cd",1);
			SetColHidden("pol_cd",1);
			SetColHidden("pod_cd",1);
			SetColHidden("del_cd",1);
			SetColHidden("hub_loc_cd",1);
			SetColHidden("trsp_mod_id",1);
			SetColHidden("it_chk",1);
			SetColHidden("bl_cntr_cnt",1);
			SetColHidden("it_no_cntr_cnt",1);
			SetColHidden("p_mib_no",1);
			SetColHidden("ibd_loc_gds_desc",1);
			SetColHidden("avc_note_tp_id",1);
			SetColHidden("fax_ofc_cd",1);
			SetColHidden("fax_flg1",1);
			SetColHidden("fax_no1",1);
			SetColHidden("fax_flg2",1);
			SetColHidden("fax_no2",1);
			SetColHidden("fax_flg3",1);
			SetColHidden("fax_no3",1);
			SetColHidden("fax_flg4",1);
			SetColHidden("fax_no4",1);
			SetColHidden("fax_flg5",1);
			SetColHidden("fax_no5",1);
			SetColHidden("fax_snd_dt",1);
			SetColHidden("fax_snd_usr_id",1);
			SetColHidden("fax_snd_usr_nm",1);
			SetColHidden("eml_flg1",0);
			SetColHidden("ntc_eml1",0);
			SetColHidden("eml_flg2",0);
			SetColHidden("ntc_eml2",0);
			SetColHidden("eml_flg3",0);
			SetColHidden("ntc_eml3",0);
			SetColHidden("eml_flg4",0);
			SetColHidden("ntc_eml4",0);
			SetColHidden("eml_flg5",0);
			SetColHidden("ntc_eml5",0);
			SetColHidden("eml_snd_dt",0);
			SetColHidden("eml_snd_usr_id",0);
			SetColHidden("eml_snd_usr_nm",0);
			RenderSheet(1);
			break;
		}
	}
}


function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}


/**
  * setting sheet initial values and header
  * param : sheetObj, sheetNo
  * adding case as numbers of counting sheets
 * @param sheetObj sheet Object
 * @param sheetNo 
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch (sheetID) {
	case "sheet1": //sheet1 init
        with(sheetObj){
        
		if (location.hostname != "")
		
		var HeadTitle1="|Sel.|Show PU#|Seq.|B/L NO.|TP|POR|POL|POD|DEL|HUB|T/M|IT CHK|ACI|BKG|P/MIB No.|LOCATION OF GOODS|A/N Type|Office|Code\nValidate|Code|Customer Name|"
		+ "|Consignee||Consignee#2||Broker/Agent #1||Broker/Agent #2||A. Notify|Result Date|Sent ID|User Name|"
		+ "|Consignee||Consignee#2||Broker/Agent #1||Broker/Agent #2||A. Notify|Result Date|Sent ID|User Name"
		headCount=ComCountHeadTitle(HeadTitle1) + 25;
		
		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:4, DataRowMerge:1 } );
		
		var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		InitHeaders(headers, info);
		
		var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		{Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
        {Type:"CheckBox",  Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"show_pu_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
		{Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		{Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		{Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_cust_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		{Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"por_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		{Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		{Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		{Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		{Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hub_loc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		{Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"trsp_mod_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		{Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"it_chk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		{Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bl_cntr_cnt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		{Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"it_no_cntr_cnt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		{Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"p_mib_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20, InputCaseSensitive:1 },
		{Type:"Text",      Hidden:0, Width:140,  Align:"Left",    ColMerge:1,   SaveName:"ibd_loc_gds_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100, InputCaseSensitive:1 },
		{Type:"Combo",     Hidden:0, Width:120,  Align:"Left",    ColMerge:1,   SaveName:"avc_note_tp_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		{Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"fax_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		{Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"chk_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cust_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		{Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:"cust_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		{Type:"DummyCheck", Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"fax_flg1",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		{Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"fax_no1",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, AcceptKeys : "N|[-]" },
		{Type:"DummyCheck", Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"fax_flg2",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		{Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"fax_no2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, AcceptKeys : "N|[-]" },
		{Type:"DummyCheck", Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"fax_flg3",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		{Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"fax_no3",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, AcceptKeys : "N|[-]" },
		{Type:"DummyCheck", Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"fax_flg4",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		{Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"fax_no4",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, AcceptKeys : "N|[-]" },
		{Type:"DummyCheck", Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"fax_flg5",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		{Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"fax_no5",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, AcceptKeys : "N|[-]" },
		{Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"fax_snd_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		{Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"fax_snd_usr_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		{Type:"Text",      Hidden:0, Width:90,   Align:"Left",    ColMerge:1,   SaveName:"fax_snd_usr_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		{Type:"DummyCheck", Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"eml_flg1",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		{Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ntc_eml1",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		{Type:"DummyCheck", Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"eml_flg2",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		{Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ntc_eml2",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		{Type:"DummyCheck", Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"eml_flg3",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		{Type:"Text",      Hidden:0, Width:110,  Align:"Left",    ColMerge:1,   SaveName:"ntc_eml3",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		{Type:"DummyCheck", Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"eml_flg4",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		{Type:"Text",      Hidden:0, Width:110,  Align:"Left",    ColMerge:1,   SaveName:"ntc_eml4",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		{Type:"DummyCheck", Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"eml_flg5",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		{Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ntc_eml5",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		{Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eml_snd_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		{Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"eml_snd_usr_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		{Type:"Text",      Hidden:0, Width:90,   Align:"Left",    ColMerge:1,   SaveName:"eml_snd_usr_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		{Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
//		{Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"chk_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		{Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"fax_snd_flg1",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		{Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"fax_snd_flg2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		{Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"fax_snd_flg3",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		{Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"fax_snd_flg4",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		{Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"fax_snd_flg5",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		{Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"eml_snd_flg1",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		{Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"eml_snd_flg2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		{Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"eml_snd_flg3",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		{Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"eml_snd_flg4",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		{Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"eml_snd_flg5",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		{Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cust_cntc_tp_cd1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		{Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cust_cntc_tp_cd2",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		{Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cust_cntc_tp_cd3",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		{Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cust_cntc_tp_cd4",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		{Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cust_cntc_tp_cd5",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		{Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		{Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		{Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"eta_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		{Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"input_vvd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		{Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"input_eta_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		{Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"val_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		//{Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bkg_cust_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		{Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"eml_proc_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		{Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"fax_proc_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		
		InitColumns(cols);
		
		SetEditable(1);
		//conversion of function[check again]CLT 			InitDataValid(0, "p_mib_no", vtEngUpOther, "1234567890");
		//conversion of function[check again]CLT 			InitDataValid(0, "fax_no1", vtNumericOther, "-");
		//conversion of function[check again]CLT 			InitDataValid(0, "fax_no2", vtNumericOther, "-");
		//conversion of function[check again]CLT 			InitDataValid(0, "fax_no3", vtNumericOther, "-");
		//conversion of function[check again]CLT 			InitDataValid(0, "fax_no4", vtNumericOther, "-");
		//conversion of function[check again]CLT 			InitDataValid(0, "fax_no5", vtNumericOther, "-");

//		SetSheetHeight(400);
//		ComResizeSheet(sheetObj);
		resizeSheet();
		}
		

		break;
	}
}
/**
 * handling sheet process
 * @param sheetObj Sheet
 * @param formObj form Object
 * @param sAction 
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	formObj.f_cmd.value=sAction;
	switch (sAction) {
	case INIT:
		//AN Type Combo
 		var sXml=sheetObj.GetSearchData("ESM_BKG_0025GS.do", FormQueryString(formObj));
		var arrCombo=ComXml2ComboString(sXml, "attr_ctnt2", "attr_ctnt1");
		sheetObj.SetColProperty("avc_note_tp_id", {ComboText:arrCombo[0], ComboCode:arrCombo[1]} );
		break;
	case SEARCH: //Retrieve
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
 			sheetObj.DoSearch("ESM_BKG_0025GS.do", FormQueryString(formObj) );
			ComOpenWait(false);
		}
		break;
	case SEARCH01: //input Customer Code , take a Name 
var param=FormQueryString(formObj) + "&cust_seq=" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "cust_seq");
 		var sXml=sheetObj.GetSearchData("ESM_BKG_0025GS.do", param);
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "cust_nm",ComGetEtcData(sXml, "cust_nm"),0);
		break;
	case MODIFY: //Save
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			if (sheetObj.IsDataModified()) {
				sheetObj.DoSave("ESM_BKG_0025GS.do", FormQueryString(formObj), -1, false);
			} else {
				ComShowCodeMessage('BKG00743');
			}
			ComOpenWait(false);
		}
		break;
	case MULTI: //Code Validate
		if (sheetObj.IsDataModified()) {
			formObj.f_cmd.value=MODIFY;
 			sheetObj.GetSaveData("ESM_BKG_0025GS.do", FormQueryString(formObj) + "&" + sheetObj.GetSaveString(false));
		}
		break;
	case MODIFY01: //Fax
		if (validateForm(sheetObj, formObj, sAction)) {
			var sXml;
			ComOpenWait(true);
			if (sheetObj.IsDataModified()) {
				// saving in case modified data exists
				formObj.f_cmd.value=MODIFY;
 				sXml=sheetObj.GetSaveData("ESM_BKG_0025GS.do", FormQueryString(formObj) + "&" + sheetObj.GetSaveString(false));
			}
			if (ComBkgErrMessage(sheetObj, sXml)) {
				for ( var i=1; i < sheetObj.RowCount()+ 1; i++) {
				if (sheetObj.GetCellValue(i, "fax_flg1") + sheetObj.GetCellValue(i, "fax_flg2") + sheetObj.GetCellValue(i, "fax_flg3")
				+ sheetObj.GetCellValue(i, "fax_flg4") + sheetObj.GetCellValue(i, "fax_flg5") > 0) {
						sheetObj.SetRowStatus(i,"U");
					} else {
						sheetObj.SetRowStatus(i,"R");
					}
				}
				// sending fax
				formObj.f_cmd.value=MODIFY01;
 				sXml=sheetObj.GetSaveData("ESM_BKG_0025GS.do", FormQueryString(formObj) + "&" + sheetObj.GetSaveString(false));
				if (ComBkgErrMessage(sheetObj, sXml)) {
//					sheetObj.loadSaveXml(sXml);
					sheetObj.LoadSaveData(sXml);
					doActionIBSheet(sheetObj, formObj, SEARCH);
				}
			}
			ComOpenWait(false);
		}
		break;
	case MODIFY02: //Mail
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			var sXml;
			if (sheetObj.IsDataModified()) {
				// saving in case modified data exists
				formObj.f_cmd.value=MODIFY;
 				sXml=sheetObj.GetSaveData("ESM_BKG_0025GS.do", FormQueryString(formObj) + "&" + sheetObj.GetSaveString(false));
			}
			if (ComBkgErrMessage(sheetObj, sXml)) {
				for ( var i=1; i < sheetObj.RowCount()+ 1; i++) {
				if (sheetObj.GetCellValue(i, "eml_flg1") + sheetObj.GetCellValue(i, "eml_flg2") + sheetObj.GetCellValue(i, "eml_flg3")
				+ sheetObj.GetCellValue(i, "eml_flg4") + sheetObj.GetCellValue(i, "eml_flg5") > 0) {
						sheetObj.SetRowStatus(i,"U");
					} else {
						sheetObj.SetRowStatus(i,"R");
					}
				}
				// sending Email
				formObj.f_cmd.value=MODIFY02;
				sXml=sheetObj.GetSaveData("ESM_BKG_0025GS.do", FormQueryString(formObj) + "&" + sheetObj.GetSaveString(false));
				if (ComBkgErrMessage(sheetObj, sXml)) {
//					sheetObj.loadSaveXml(sXml);
					sheetObj.LoadSaveData(sXml);
					doActionIBSheet(sheetObj, formObj, SEARCH);
				}
			}
			ComOpenWait(false);
		}
		break;
	}
}
/**
 * execute after search sheet1
 * @param sheetObj sheet Object
 * @param ErrMsg error message
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    if(sheetObj.RowCount()> 0){
   	 	sheetObj.CheckAll("show_pu_flg",1);
    }	
	
	with (sheetObj) {
		for (i=1; i < RowCount()+ 1; i++) {
			//whole check box Disabled
			if (GetCellValue(i, "chk_flg") == 'N') {
				SetRowBackColor(i,"#FFECD0");
				SetCellEditable(i, "fax_flg1",0);
				SetCellEditable(i, "fax_flg2",0);
				SetCellEditable(i, "fax_flg3",0);
				SetCellEditable(i, "fax_flg4",0);
				SetCellEditable(i, "fax_flg5",0);
				SetCellEditable(i, "eml_flg1",0);
				SetCellEditable(i, "eml_flg2",0);
				SetCellEditable(i, "eml_flg3",0);
				SetCellEditable(i, "eml_flg4",0);
				SetCellEditable(i, "eml_flg5",0);
			} else {
				//Fax check box Disabled(Do Not Send)
				if (GetCellValue(i, "fax_snd_flg1") == 'N') {
					SetCellEditable(i, "fax_flg1",0);
				}
				if (GetCellValue(i, "fax_snd_flg2") == 'N') {
					SetCellEditable(i, "fax_flg2",0);
				}
				if (GetCellValue(i, "fax_snd_flg3") == 'N') {
					SetCellEditable(i, "fax_flg3",0);
				}
				if (GetCellValue(i, "fax_snd_flg4") == 'N') {
					SetCellEditable(i, "fax_flg4",0);
				}
				if (GetCellValue(i, "fax_snd_flg5") == 'N') {
					SetCellEditable(i, "fax_flg5",0);
				}
				//Mail check box  Disabled(Do Not Send)
				if (GetCellValue(i, "eml_snd_flg1") == 'N') {
					SetCellEditable(i, "eml_flg1",0);
				}
				if (GetCellValue(i, "eml_snd_flg2") == 'N') {
					SetCellEditable(i, "eml_flg2",0);
				}
				if (GetCellValue(i, "eml_snd_flg3") == 'N') {
					SetCellEditable(i, "eml_flg3",0);
				}
				if (GetCellValue(i, "eml_snd_flg4") == 'N') {
					SetCellEditable(i, "eml_flg4",0);
				}
				if (GetCellValue(i, "eml_snd_flg5") == 'N') {
					SetCellEditable(i, "eml_flg5",0);
				}
			}
			//  Unmatch the number of BKG Container of Target B/L No. and the number of transmitted Container at ACI  : yellow
			if (GetCellValue(i, "bl_cntr_cnt") != GetCellValue(i, "it_no_cntr_cnt")) {
				SetCellBackColor(i, "bl_cntr_cnt","#FFFFCC");
				SetCellBackColor(i, "it_no_cntr_cnt","#FFFFCC");
			}
			if (GetCellValue(i, "p_mib_no") != "") {
				if (GetCellValue(i, "p_mib_no").substring(GetCellValue(i, "p_mib_no").length - 3) == "...") {
					SetCellEditable(i, "p_mib_no",0);
				}
			}
			// font color according to Sending result (success: blue, fail:red, running:pink)
			if (GetCellValue(i, "eml_proc_sts_cd") == "3") {
				// success
				SetCellFontColor(i, "eml_snd_dt","#0000FF");
				SetCellFontColor(i, "eml_snd_usr_id","#0000FF");
				SetCellFontColor(i, "eml_snd_usr_nm","#0000FF");
			} else if (GetCellValue(i, "eml_proc_sts_cd") == "4") {
				// fail
				SetCellFontColor(i, "eml_snd_dt","#FF0000");
				SetCellFontColor(i, "eml_snd_usr_id","#FF0000");
				SetCellFontColor(i, "eml_snd_usr_nm","#FF0000");
			} else {
				// running
				SetCellFontColor(i, "eml_snd_dt","#FF00C0");
				SetCellFontColor(i, "eml_snd_usr_id","#FF00C0");
				SetCellFontColor(i, "eml_snd_usr_nm","#FF00C0");
			}
			if (GetCellValue(i, "fax_proc_sts_cd") == "5") {
				// success
				SetCellFontColor(i, "fax_snd_dt","#0000FF");
				SetCellFontColor(i, "fax_snd_usr_id","#0000FF");
				SetCellFontColor(i, "fax_snd_usr_nm","#0000FF");
			} else if (GetCellValue(i, "fax_proc_sts_cd") == "6") {
				// fail
				SetCellFontColor(i, "fax_snd_dt","#FF0000");
				SetCellFontColor(i, "fax_snd_usr_id","#FF0000");
				SetCellFontColor(i, "fax_snd_usr_nm","#FF0000");
			} else {
				// running
				SetCellFontColor(i, "fax_snd_dt","#FF00C0");
				SetCellFontColor(i, "fax_snd_usr_id","#FF00C0");
				SetCellFontColor(i, "fax_snd_usr_nm","#FF00C0");
			}
		}
	}
}
/**
 * clicking first check box 
 * @param sheetObj sheet Object
 * @param row Row Index
 * @param col Column Index
 */
function sheet1_OnBeforeCheck(sheetObj, row, col) {
	var value="";
	
	if (col == 1) {
		if (sheetObj.GetCellValue(row, "chk") == "0") {
			sheetObj.SetCellValue(row, "fax_flg1","1",0);
			sheet1_OnChange(sheetObj, row, sheetObj.SaveNameCol("fax_flg1"), value)
			sheetObj.SetCellValue(row, "fax_flg2","1",0);
			sheet1_OnChange(sheetObj, row, sheetObj.SaveNameCol("fax_flg2"), value)
			sheetObj.SetCellValue(row, "fax_flg3","1",0);
			sheet1_OnChange(sheetObj, row, sheetObj.SaveNameCol("fax_flg3"), value)
			sheetObj.SetCellValue(row, "fax_flg4","1",0);
			sheet1_OnChange(sheetObj, row, sheetObj.SaveNameCol("fax_flg4"), value)
			sheetObj.SetCellValue(row, "fax_flg5","1",0);
			sheet1_OnChange(sheetObj, row, sheetObj.SaveNameCol("fax_flg5"), value)
			sheetObj.SetCellValue(row, "eml_flg1","1",0);
			sheet1_OnChange(sheetObj, row, sheetObj.SaveNameCol("eml_flg1"), value)
			sheetObj.SetCellValue(row, "eml_flg2","1",0);
			sheet1_OnChange(sheetObj, row, sheetObj.SaveNameCol("eml_flg2"), value)
			sheetObj.SetCellValue(row, "eml_flg3","1",0);
			sheet1_OnChange(sheetObj, row, sheetObj.SaveNameCol("eml_flg3"), value)
			sheetObj.SetCellValue(row, "eml_flg4","1",0);
			sheet1_OnChange(sheetObj, row, sheetObj.SaveNameCol("eml_flg4"), value)
			sheetObj.SetCellValue(row, "eml_flg5","1",0);
			sheet1_OnChange(sheetObj, row, sheetObj.SaveNameCol("eml_flg5"), value)
		} else {
			sheetObj.SetCellValue(row, "fax_flg1","0",0);
			sheet1_OnChange(sheetObj, row, sheetObj.SaveNameCol("fax_flg1"), value)
			sheetObj.SetCellValue(row, "fax_flg2","0",0);
			sheet1_OnChange(sheetObj, row, sheetObj.SaveNameCol("fax_flg2"), value)
			sheetObj.SetCellValue(row, "fax_flg3","0",0);
			sheet1_OnChange(sheetObj, row, sheetObj.SaveNameCol("fax_flg3"), value)
			sheetObj.SetCellValue(row, "fax_flg4","0",0);
			sheet1_OnChange(sheetObj, row, sheetObj.SaveNameCol("fax_flg4"), value)
			sheetObj.SetCellValue(row, "fax_flg5","0",0);
			sheet1_OnChange(sheetObj, row, sheetObj.SaveNameCol("fax_flg5"), value)
			sheetObj.SetCellValue(row, "eml_flg1","0",0);
			sheet1_OnChange(sheetObj, row, sheetObj.SaveNameCol("eml_flg1"), value)
			sheetObj.SetCellValue(row, "eml_flg2","0",0);
			sheet1_OnChange(sheetObj, row, sheetObj.SaveNameCol("eml_flg2"), value)
			sheetObj.SetCellValue(row, "eml_flg3","0",0);
			sheet1_OnChange(sheetObj, row, sheetObj.SaveNameCol("eml_flg3"), value)
			sheetObj.SetCellValue(row, "eml_flg4","0",0);
			sheet1_OnChange(sheetObj, row, sheetObj.SaveNameCol("eml_flg4"), value)
			sheetObj.SetCellValue(row, "eml_flg5","0",0);
			sheet1_OnChange(sheetObj, row, sheetObj.SaveNameCol("eml_flg5"), value)
		}
	}
}

///**
// * in case of clicking header
// * @param sheetObj sheet Object
// * @param Button mouse button direction
// * @param Shift in case of clicking Shift key 1,in case of clicking Ctrl key 2, ETC 0
// * @param X X coordinate
// * @param Y Y coordinate
// */
//function sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y) {
//	// in case of clicking header
//	if (sheetObj.GetCellValue(sheetObj.MouseRow(), sheetObj.MouseCol()) == "Sel.") {
//		// in case of clicking check box
//		if (sheetObj.CheckAll("chk") == 0) {
//			sheetObj.CheckAll("fax_flg1","1");
//			sheetObj.CheckAll("fax_flg2","1");
//			sheetObj.CheckAll("fax_flg3","1");
//			sheetObj.CheckAll("fax_flg4","1");
//			sheetObj.CheckAll("fax_flg5","1");
//			sheetObj.CheckAll("eml_flg1","1");
//			sheetObj.CheckAll("eml_flg2","1");
//			sheetObj.CheckAll("eml_flg3","1");
//			sheetObj.CheckAll("eml_flg4","1");
//			sheetObj.CheckAll("eml_flg5","1");
//		} else {
//			sheetObj.CheckAll("fax_flg1","0");
//			sheetObj.CheckAll("fax_flg2","0");
//			sheetObj.CheckAll("fax_flg3","0");
//			sheetObj.CheckAll("fax_flg4","0");
//			sheetObj.CheckAll("fax_flg5","0");
//			sheetObj.CheckAll("eml_flg1","0");
//			sheetObj.CheckAll("eml_flg2","0");
//			sheetObj.CheckAll("eml_flg3","0");
//			sheetObj.CheckAll("eml_flg4","0");
//			sheetObj.CheckAll("eml_flg5","0");
//		}
//	}
//}

/**
 * handling process for input validation
 * @param sheetObj sheet Object
 * @param formObj  form Object
 * @param sAction 
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case SEARCH:
		if (!ComChkValid(formObj))
			return false;
		if (ComIsNull(formObj.sch_bl_no) && (ComIsNull(formObj.vvd_cd) || ComIsNull(formObj.pod_cd))) {
			ComShowCodeMessage('BKG00626', '(VVD and POD) or (B/L No.)');
			return false;
		}
		break;
	case MODIFY01: //Fax
		if (sheetObj.CheckedRows("fax_flg1") + sheetObj.CheckedRows("fax_flg2") + sheetObj.CheckedRows("fax_flg3")
				+ sheetObj.CheckedRows("fax_flg4") + sheetObj.CheckedRows("fax_flg5") == 0) {
			ComShowCodeMessage('BKG00333');
			return false;
		}
		break;
	case MODIFY02: //Mail
		if (sheetObj.CheckedRows("eml_flg1") + sheetObj.CheckedRows("eml_flg2") + sheetObj.CheckedRows("eml_flg3")
				+ sheetObj.CheckedRows("eml_flg4") + sheetObj.CheckedRows("eml_flg5") == 0) {
			ComShowCodeMessage('BKG00333');
			return false;
		}
		break;
	}
	return true;
}
/**
 * Event in case of changing the cell 
 * @param sheetObj sheet Object
 * @param row Row Index
 * @param col Column Index
 * @param value 
 */
function sheet1_OnChange(sheetObj, row, col, value) {
	if (sheetObj.ColSaveName(col) == "cust_seq") {
		if (sheetObj.GetCellValue(row, "cust_seq").length < 8) {
			ComShowCodeMessage("BKG00381");
			sheetObj.SelectCell(row, "cust_seq");
			return false;
		}
		doActionIBSheet(sheetObj, document.form, SEARCH01);
	}
	if (sheetObj.ColSaveName(col) == "fax_no1" || sheetObj.ColSaveName(col) == "fax_no2" || sheetObj.ColSaveName(col) == "fax_no3"
			|| sheetObj.ColSaveName(col) == "fax_no4" || sheetObj.ColSaveName(col) == "fax_no5") {
		if (sheetObj.GetCellEditable(row, col - 1)) {
			if (sheetObj.GetCellValue(row, col) != "") {
				sheetObj.SetCellValue(row, col - 1,"1",0);
			} else {
				sheetObj.SetCellValue(row, col - 1,"0",0);
			}
		}
	}
	if (sheetObj.ColSaveName(col) == "ntc_eml1" || sheetObj.ColSaveName(col) == "ntc_eml2" || sheetObj.ColSaveName(col) == "ntc_eml3"
			|| sheetObj.ColSaveName(col) == "ntc_eml4" || sheetObj.ColSaveName(col) == "ntc_eml5") {
		if (sheetObj.GetCellValue(row, col) != "" && !ComIsEmailAddr(sheetObj.GetCellValue(row, col))) {
			ComShowCodeMessage("BKG40021", sheetObj.GetCellValue(row, col));
			sheetObj.SelectCell(row, col);
			return;
		}
		if (sheetObj.GetCellEditable(row, col - 1)) {
			if (sheetObj.GetCellValue(row, col) != "") {
				sheetObj.SetCellValue(row, col - 1,"1",0);
			} else {
				sheetObj.SetCellValue(row, col - 1,"0",0);
			}
		}
	}
	if (sheetObj.ColSaveName(col) == "fax_flg1" || sheetObj.ColSaveName(col) == "fax_flg2" || sheetObj.ColSaveName(col) == "fax_flg3"
			|| sheetObj.ColSaveName(col) == "fax_flg4" || sheetObj.ColSaveName(col) == "fax_flg5"
			|| sheetObj.ColSaveName(col) == "eml_flg1" || sheetObj.ColSaveName(col) == "eml_flg2"
			|| sheetObj.ColSaveName(col) == "eml_flg3" || sheetObj.ColSaveName(col) == "eml_flg4"
			|| sheetObj.ColSaveName(col) == "eml_flg5") {
		if (sheetObj.GetCellValue(row, col + 1) == "") {
			sheetObj.SetCellValue(row, col,"0",0);
		}
	}
}
/**
 * clicking Arrival Info button. 
 * @param vvd VVD
 * @param eta ETA
 * @param antype ANTYPE
 */
function setAnType(vvd, eta, antype) {
	for ( var iChk=1; iChk < sheetObjects[0].RowCount()+1; iChk++) {
if (sheetObjects[0].GetCellValue(iChk, "chk") == "1" && sheetObjects[0].GetCellValue(iChk, "chk_flg") == "Y") {
			if (vvd != "") {
				sheetObjects[0].SetCellValue(iChk, "input_vvd_cd",vvd,0);
			}
			if (eta != "") {
				sheetObjects[0].SetCellValue(iChk, "input_eta_dt",eta,0);
			}
			if (antype != "") {
				sheetObjects[0].SetCellValue(iChk, "avc_note_tp_id",antype,0);
			}
		}
	}
}

/**
 * Event in case of double clicking Cell of data area
 * @param sheetObj sheet Object
 * @param row row Index
 * @param col col Index
 */
function sheet1_OnDblClick(sheetObj, row, col) {
	if (col > 2) {
		var bl_no=sheetObj.GetCellValue(row, "bl_no");
		ComOpenWindowCenter("/opuscntr/ESM_BKG_0029_POP.do?mainPage=false&pgmNo=ESM_BKG_0029_2&type=edit&bl_no=" + bl_no, "0029", 1200, 750);
	}
}

/**
 * moving next item after input search condition
 */
function obj_KeyUp() {
	var formObject=document.form;
	var srcName=ComGetEvent("name");
	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
	var srcValue=window.event.srcElement.getAttribute("value");
	if (ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}
/**
 * search after inputing search condition
 */
function obj_KeyDown() {
	var srcName=ComGetEvent("name");
	switch (srcName) {
	case "vvd_cd":
	case "pod_cd":
	case "del_cd":
	case "sch_bl_no":
	case "mtch_flg":
		ComKeyEnter();
		break;
	}
}
