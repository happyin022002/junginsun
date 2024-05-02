/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName 	 : ESD_PRD_0020.js
 *@FileTitle  : Product Catalog Inquiry 
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/22
=========================================================*/
var sheetObjects = new Array();
var sheetCnt = 0;
var retValidate = 0;
var succFlag = "";
var strErrMsg = "";
var validateData = "";
var forcusField = "";

document.onclick = processButtonClick;
/* Event handler processing by button name */
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	var formObject = document.form;
	var por = document.getElementById('por');
	var rcv_t = document.getElementById('rcv_t');
	var del_t = document.getElementById('del_t');
	try {
		var srcName = ComGetEvent("name");
		if (ComGetBtnDisable(srcName))
			return false;
		switch (srcName) {
			case "btn_retrieve":
				sheetObject.RemoveAll();
				sheetObject1.RemoveAll();
				doActionIBSheet(sheetObject, formObject, IBSEARCH);
				document.form.search_pctl_no.value = '';
				break;
			case "btn_downexcel":
				if (sheetObject.RowCount() < 1) {
					ComShowCodeMessage("COM132501");
				} else {
					doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
				}

				break;
			case "btn_new":
				sheetObject.RemoveAll();
				sheetObject1.RemoveAll();
				formObject.reset();
				por.setAttribute('required', '');
				por.className = 'input1';
				rcv_t.className = 'input1';
				del_t.className = 'input1';
				break;
			case "btn_por":
				selectNode('POR');
				break;
			case "btn_del":
				selectNode('DEL');
				break;
			case "btn_pol":
				selectLoc('POL');
				break;
			case "btn_pod":
				selectLoc('POD');
				break;
			case "btn_com":
				selectCom('COM');
				break;
			case "btn_calendar":
				var cal = new ComCalendar();
				cal.select(formObject.skd_date_fm, 'yyyy-MM-dd');
				break;
			case "btng_costdetail": {
				var pctl_no = document.form.search_pctl_no.value;
				if (pctl_no == '') {
					ComShowCodeMessage("PRD90026");
					return;
				}
				ComOpenPopup('ESM_COA_0141.do?f_pctl_no=' + pctl_no, 905, 640, '', "1,0", true);
				break;
			}
			case "btng_dtl": {
				funcPopupPrdInquiryDetail(formObject);
				break;
			}
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(ComGetMsg('COM12111'));
		} else {
			ComShowMessage(e.message);
		}
	}
}
/*----------------------------------------------------------------*/
var portInd = '';
function selectNode(pt) {
	var param = '?loc_port_ind=1';
	portInd = pt;
	if (portInd == 'POR') {
		param = param + '&node_cd=' + form.por.value;
	}
	if (portInd == 'DEL') {
		param = param + '&node_cd=' + form.del.value;
	}
	ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 810, 550, 'getNode', "1,0,1,1,1,1,1,1,1,1,1,1", true);
}
function getNode(rowArray) {
	var colArray = rowArray[0];
	if (portInd == 'POR') {
		document.all.por.value = colArray[3].substring(0, 5);
		document.all.por_yd_cd.value = colArray[3].substring(5);
	}
	if (portInd == 'DEL') {
		document.all.del.value = colArray[3].substring(0, 5);
		document.all.del_yd_cd.value = colArray[3].substring(5);
	}
}
/*----------------------------------------------------------------*/
var locInd = '';
function selectLoc(pt) {
	var param = '?loc_port_ind=1';
	locInd = pt;
	if (locInd == 'POL') {
		param = param + '&node_cd=' + form.pol.value;
	}
	if (locInd == 'POD') {
		param = param + '&node_cd=' + form.pod.value;
	}
	ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 810, 500, 'getLoc', "1,0,1,1,1,1,1,1,1,1,1,1", true);
}
function getLoc(rowArray) {
	var frm = document.form;
	var colArray = rowArray[0];
	if (locInd == 'POL') {
		frm.pol.value = colArray[3].substring(0, 5);
		frm.pol_yd_cd.value = colArray[3].substring(5);
	}
	if (locInd == 'POD') {
		frm.pod.value = colArray[3].substring(0, 5);
		frm.pod_yd_cd.value = colArray[3].substring(5);
	}
}
/*----------------------------------------------------------------*/
var comInd = '';
function selectCom(pt) {
	var param = '';
	comInd = pt;
	if (comInd == 'COM') {
		param = param + '?cmdt_cd=' + form.com.value;
	}
	ComOpenPopup('/opuscntr/COM_ENS_011.do' + param, 770, 470, 'getCom', "1,0,1,1,1,1,1,1,1,1,1,1", true);
}
function getCom(rowArray) {
	var colArray = rowArray[0];
	if (comInd == 'COM') {
		document.form.com.value = colArray[2];// .substring(0,5);
	}
}
/*----------------------------------------------------------------*/
/**
 * registering IBSheet Object as list adding process for list <br>
 * in case of needing batch processing with other items defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}
/**
 * initializing sheet implementing onLoad event handler in body tag adding first-served functions after loading screen.
 */
function loadPage() {
	var formObject = document.form;
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	formObject.skd_date_fm.value = ComGetNowInfo("ymd", "-");
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form);
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
	axon_event.addListenerForm('change', 'form_onChange', form);
}

function form_onChange(evt, el) {
	var formObj = document.form;
	var xml = "";
	var srcName;
	var srcValue;
	if (el) {
		srcName = el.getAttribute("name");
		srcValue = el.getAttribute("value");
	} else {
		srcName = ComGetEvent("name");
		srcValue = ComGetEvent("value");
	}
	if (srcName == "por") {
		forcusField = document.form.por;
		inputChkUpper(document.form.por, 0, 'SEARCH02');
	} else if (srcName == "pol") {
		forcusField = document.form.pol;
		inputChkUpper(document.form.pol, 0, 'SEARCH02');
	} else if (srcName == "pod") {
		forcusField = document.form.pod;
		inputChkUpper(document.form.pod, 0, 'SEARCH02');
	} else if (srcName == "del") {
		forcusField = document.form.del;
		inputChkUpper(document.form.del, 0, 'SEARCH02');
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
        case 1:      //IBSheet1 init
            with(sheetObj){
		             var HeadTitle ="SEQ|Constraint\n/Ref.|SVC(Y/N)|Ocean\nFlag|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Trunk\nLane|Ocean\nPriority|eComm T/T|eComm T/T|Cut Off Info|Cut Off Info|Last CY Avail.|T/Time\n(day/HR)|Total Cost|" ;
		             var HeadTitle1="SEQ|Constraint\n/Ref.|SVC(Y/N)|Ocean\nFlag|POR|POR|Inter Change|POL|POL|T/S Route|POD|POD|Inter Change|DEL|DEL|Trunk\nLane|Ocean\nPriority|Ocean|Total|1st CY|POL|Last CY Avail.|T/Time\n(day/HR)|Total Cost|" ;
		             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );			
		             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		             var headers = [ { Text:HeadTitle, Align:"Center"},{ Text:HeadTitle1, Align:"Center"} ];
		             InitHeaders(headers, info);			
		             var cols = [ 
			                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Image",     Hidden:0, Width:70,   	Align:"Center",  ColMerge:1,  SaveName:"remark_img",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:60,   	Align:"Center",  ColMerge:1,  SaveName:"remark",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:70,   	Align:"Center",  ColMerge:1,  SaveName:"rout_flag",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1,  Width:60,   	Align:"Center",  ColMerge:1,  SaveName:"por_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:80,   	Align:"Center",  ColMerge:1,  SaveName:"por_nod_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:130,  	Align:"Center",  ColMerge:1,  SaveName:"ob_itchg_ctnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1,  Width:60,   	Align:"Center",  ColMerge:1,  SaveName:"pol_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:80,   	Align:"Center",  ColMerge:1,  SaveName:"pol_nod_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:180,  	Align:"Center",  ColMerge:1,  SaveName:"ts_route",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1,  Width:60,   	Align:"Center",  ColMerge:1,  SaveName:"pod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:80,   	Align:"Center",  ColMerge:1,  SaveName:"pod_nod_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:130,  	Align:"Center",  ColMerge:1,  SaveName:"ib_itchg_ctnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1,  Width:60,   	Align:"Center",  ColMerge:1,  SaveName:"del_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:80,   	Align:"Center",  ColMerge:1,  SaveName:"del_nod_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:120,   Align:"Center",  ColMerge:1,  SaveName:"trnk_vvd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:0,   	Align:"Center",  ColMerge:1,  SaveName:"ocn_rout_prio_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:0,   	Align:"Center",  ColMerge:1,  SaveName:"cml_ocn_tztm_hrs", KeyField:0, CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:0,   	Align:"Center",  ColMerge:1,  SaveName:"cml_inlnd_tztm_hrs", KeyField:0, CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 
			                 {Type:"Text",      Hidden:0,  Width:90,   	Align:"Center",  ColMerge:1,  SaveName:"ful_rtn_cct", 	KeyField:0,    CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:90,   	Align:"Center",  ColMerge:1,  SaveName:"port_cct", 		KeyField:0,    CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:90,    Align:"Center",  ColMerge:1,  SaveName:"last_avail_dt", KeyField:0,    CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 
			                 {Type:"Text",      Hidden:0,  Width:60,   	Align:"Center",  ColMerge:1,  SaveName:"ttl_tztm_hrs",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Float",     Hidden:0,  Width:50,   	Align:"Center",  ColMerge:1,  SaveName:"total_cost",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1,  Width:50,   	Align:"Center",  ColMerge:1,  SaveName:"pctl_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1,  Width:70,   	Align:"Center",  ColMerge:1,  SaveName:"rout_cnst_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1,  Width:70,   	Align:"Center",  ColMerge:1,  SaveName:"trnk_lane",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1,  Width:50,  	Align:"Center",  ColMerge:1,  SaveName:"cnst_rmk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1,  Width:50,  	Align:"Center",  ColMerge:1,  SaveName:"skd_date_fm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 }
		                 ];
		              
		             InitColumns(cols);
		             SetEditable(1);
		             SetImageList(0,"/opuscntr/img/opus/ico_b.gif");
		             SetImageList(1,"/opuscntr/img/opus/ico_r.gif");
		             SetHeaderRowHeight("10" );
		             SetColProperty("ttl_tztm_hrs", {AcceptKeys:"N", Format:"##D##H"} );
		             SetColProperty("cml_ocn_tztm_hrs", {AcceptKeys:"N", Format:"##D"} );
		             SetColProperty("cml_inlnd_tztm_hrs", {AcceptKeys:"N", Format:"##D"} );
		             SetSheetHeight(150);
         }
         break;
          case 2:      //IBSheet2 init
              with(sheetObj){                
		               var HeadTitle="Ref|SVC(Y/N)|Node / Link|Lane / VVD|Mode|T. Time / D. Time|Arr. Time|Dep. Time" ;
		               SetConfig( { SearchMode:2, MergeSheet:5, Page:20} );
		               var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		               var headers = [ { Text:HeadTitle, Align:"Center"} ];
		               InitHeaders(headers, info);
		               var cols = [ {Type:"Image",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"remark_img",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                   {Type:"Text",      Hidden:0, Width:60,  Align:"Center",  ColMerge:1,   SaveName:"remark",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                   {Type:"Text",      Hidden:0,  Width:350,  Align:"Center",  ColMerge:0,   SaveName:"node_link",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                   {Type:"Text",      Hidden:0,  Width:350,  Align:"Center",  ColMerge:0,   SaveName:"vvd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"trsp_mod_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                   {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"fmt_tz_dwll_tm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                   {Type:"Text",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:0,   SaveName:"arr_time",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                   {Type:"Text",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:0,   SaveName:"dep_time",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                   {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pctl_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                   {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cnst_rmk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                   {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:"org_nod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                   {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:"dest_nod_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		                
		               InitColumns(cols);
		               SetEditable(0);
		               SetImageList(0,"/opuscntr/img/opus/ico_b.gif");
		               SetImageList(1,"/opuscntr/img/opus/ico_r.gif");
		               SetSheetHeight(210);
		               SetColProperty("fmt_tz_dwll_tm", {Format:"##D##H"} );
		               SetDataAlternateBackColor("#EBF5E1");
		               ComResizeSheet(sheetObj, 30);
           }
            break;
          case 3: {
        	  with(sheetObj){                
            	  var HeadTitle="T" ;
            	  SetConfig( { SearchMode:2, MergeSheet:5, Page:20} );
            	  var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
            	  var headers = [ { Text:HeadTitle, Align:"Center"} ];
            	  InitHeaders(headers, info);
            	  var cols = [ {Type:"Text",      Hidden:1, Width:130,  Align:"Center",  ColMerge:1,   SaveName:"t",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }];
            	  InitColumns(cols);
            	  SetEditable(0);
            	  SetSheetHeight(210 );
            	  sheetObj.SetVisible(false);
          		}
        	  break;
          }
    }
}

// changing column color
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var rowCount = sheetObj.RowCount();
	var routFlag = '';
	for (i = 0 + parseInt(sheetObj.HeaderRows()); i < rowCount + parseInt(sheetObj.HeaderRows()); i++) {
		routFlag = sheetObj.GetCellValue(i, "routFlag");
		if (routFlag == 'Validation') {
			sheetObj.SetRowBackColor(i, "#FFFFCC");
		} else if (routFlag == 'Temporary') {
			sheetObj.SetRowBackColor(i, "#FFCCCC");
		} else if (routFlag == 'Add Call') {
			sheetObj.SetRowBackColor(i, "#CCCCFF");
		}
	}
}
// changing column color
function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
	sheetObj.SetColBackColor("section", "#FFFFFF");
	sheetObj.SetSumText(0, "td_time", ComGetMsg('PRD90131'));
}
// handling of Sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	var uid;
	var sXml;
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
		case IBSEARCH:
			if (!ComChkRequired(formObj))
				return;
			formObj.f_cmd.value = SEARCHLIST;
			/**
			 * set por+por_yd_cd into por_n<br>
			 */
			if (formObj.por_yd_cd.value.length == 2 && formObj.por.value.length == 5) {
				formObj.por_n.value = formObj.por.value + formObj.por_yd_cd.value
			} else {
				formObj.por_n.value = "";
			}
			
			if (formObj.pol_yd_cd.value.length == 2 && formObj.pol.value.length == 5) {
				formObj.pol_n.value = formObj.pol.value + formObj.pol_yd_cd.value
			} else {
				formObj.pol_n.value = "";
			}
			
			if (formObj.pod_yd_cd.value.length == 2 && formObj.pod.value.length == 5) {
				formObj.pod_n.value = formObj.pod.value + formObj.pod_yd_cd.value
			} else {
				formObj.pod_n.value = "";
			}
			
			/**
			 * set del+del_yd_cd into del_n<br>
			 */
			if (formObj.del_yd_cd.value.length == 2 && formObj.del.value.length == 5) {
				formObj.del_n.value = formObj.del.value + formObj.del_yd_cd.value
			} else {
				formObj.del_n.value = "";
			}
			formObj.ld_dt.value = formObj.skd_date_fm.value.split("-").join("");
			if (!ComIsDate(formObj.skd_date_fm.value, "ymd")) {
				ComShowCodeMessage('COM132401');
				ComClearObject(formObj.skd_date_fm);
				ComSetFocus(formObj.skd_date_fm);
				return false;
			}
			ComOpenWait(true);
			setTimeout(function() {
				sheetObj.DoSearch("ESD_PRD_0020GS.do", PrdFQString(formObj), { Sync : 2 });
				ComOpenWait(false);

				var costResult = sheetObj.GetEtcData("costResult");
				succFlag = sheetObj.GetEtcData("succFlag");
				strErrMsg = sheetObj.GetEtcData("strErrMsg");
				if (succFlag == "FAIL") {
					ComShowMessage(strErrMsg);
				}
				if (costResult == "N") {
					ComShowCodeMessage('PRD90036');
				}
			}, 100);
			break;
		case IBDOWNEXCEL:
			sheetObj.Down2Excel({ DownCols : makeExcelDownSkipColumn(sheetObj, true, ["total_cost"]), SheetDesign : 1, Merge : 1 });
			break;
		case SEARCH02:
			formObj.f_cmd.value = SEARCH02;
			uid = "ESD_PRD_0020";
			sXml = sheetObj.GetSaveData("PRD_VALIDATE.do", "uid=" + uid + "&check_data=" + validateData + "&" + PrdFQString(formObj));
			retValidate = ComGetEtcData(sXml, "rowCount");
			if (retValidate < 1) {
				ComShowCodeMessage('PRD00091');
				forcusField.value = '';

			}
			break;
		case "CNSTSEARCH":
			formObj.f_cmd.value = SEARCH10;
			var row = sheetObj.GetSelectRow();
			var params = "f_cmd=" + SEARCH10 + "&prdCtlNo=" + sheetObj.GetCellValue(row, "pctl_no");
			params += "&pol=" + sheetObj.GetCellValue(row, "pol_cd") + "&pod=" + sheetObj.GetCellValue(row, "pod_cd");
			params += "&del=" + sheetObj.GetCellValue(row, "del_cd");
			params += "&trnkLane=" + sheetObj.GetCellValue(row, "trnk_lane") + "&cnst_seq=" + sheetObj.GetCellValue(row, "rout_cnst_seq");
			params += "&row=" + row + "&cnstFlg=" + sheetObj.GetCellValue(row, "remark");

			sXml = sheetObj.GetSearchData("ESD_PRD_0020GS.do", params)
			var arrXml = sXml.split("|$$|");
			if (arrXml.length == 1) {
				var cnst_remark = ComGetEtcData(arrXml[0], "cnst_rmk");
				ComShowMessage(cnst_remark);
			}
			break;
	}
}
function doActionIBSheet2(sheetObj, formObj, sAction) {
	switch (sAction) {
		case IBSEARCH:
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("ESD_PRD_0020_DETAIL.do", PrdFQString(formObj), { Sync : 2 });
			break;
		case "CNSTSEARCH2":
			formObj.f_cmd.value = SEARCH10;
			var row = sheetObj.GetSelectRow();
			var params  = "f_cmd=" + SEARCH10 + "&prdCtlNo=" + sheetObj.GetCellValue(row, "pctl_no");
				params +=  "&row=" + row + "&cnstFlg=" + sheetObj.GetCellValue(row, "remark");
				params +=  "&nod_cd=" + sheetObj.GetCellValue(row, "node_link");
				params +=  "&org_nod_cd=" + sheetObj.GetCellValue(row, "org_nod_cd") + "&dest_nod_cd=" + sheetObj.GetCellValue(row, "dest_nod_cd");
				
			var sXml = sheetObj.GetSearchData("ESD_PRD_0020GS.do",  params);
			var arrXml = sXml.split("|$$|");
			if (arrXml.length == 1) {
				ComShowMessage(ComGetEtcData(arrXml[0], "cnst_rmk"));
			}
			break;
	}
}

// double click event
function sheet1_OnDblClick(sheetObj, row, col) {
	var formObj = document.form;
	switch (sheetObj.ColSaveName(col)) {
		case "remark" :
		case "remark_img": {
			if (sheetObj.GetCellValue(row, "remark") == 'N' || sheetObj.GetCellValue(row, "remark") == 'Y') {
				doActionIBSheet(sheetObjects[0], formObj, "CNSTSEARCH");
				ComShowMessage(sheetObj.GetCellValue(row, "cnst_rmk"));
			}
			break;
		}
		default: {
			if (parseInt(sheetObjects[1].LastRow()) == 0 || (parseInt(sheetObjects[1].LastRow()) > 0 && sheetObj.GetCellValue(row, "pctl_no") != formObj.search_pctl_no.value)) {
				formObj.search_pctl_no.value = sheetObj.GetCellValue(row, "pctl_no");
				doActionIBSheet2(sheetObjects[1], formObj, IBSEARCH);
			}
			break;
		}
	}
}

// double click event
function sheet2_OnDblClick(sheetObj, row, col) {
	var formObj = document.form;
	switch(sheetObj.ColSaveName(col)) {
		case "remark_img" :
		case "remark" : {
			if (sheetObj.GetCellValue(row, "remark") == 'N' || sheetObj.GetCellValue(row, "remark") == 'Y') {
				doActionIBSheet2(sheetObjects[1], document.form, "CNSTSEARCH2");
				ComShowMessage(sheetObj.GetCellValue(row, "cnst_rmk"));
			}
			break;
		}
	}
}
// handling popup open
function sheet1_OnPopupClick(sheetObj, row, col) {
	if (sheetObj.ColSaveName(col) == "from") {
		ComShowMessage("From Search Popup Open!! row=" + row);
	}
	if (sheetObj.ColSaveName(col) == "to") {
		ComShowMessage("To Search Popup Open!! row=" + row);
	}
	if (sheetObj.ColSaveName(col) == "sp") {
		ComShowMessage("S/P Search Popup Open!! row=" + row);
	}
}

/**
 * 
 * @param obj
 */
function FuncCheckTpSz(obj) {
	sheetObjects[2].RemoveEtcData();
	if (!ComIsNull(obj)) {
		var sXml = sheetObjects[2].GetSearchData("ESD_PRD_0020GS.do", "f_cmd=" + SEARCH02 + "&cntr_tpsz_cd=" + obj.value, { sync : 2 });
		var IsExisFlg = ComGetEtcData(sXml, "is_exis_flg");
		if (IsExisFlg == "0") {
			obj.value = '';
			obj.focus();
		}
	}
	return;
}

/**
 * 
 * @returns {Boolean}
 */
function funcPopupPrdInquiryDetail(formObject) {
	if (sheetObjects[0].RowCount() <= 0) {
		ComShowCodeMessage('COM130401');
		return false;

	}
	var selectRow = sheetObjects[0].GetSelectRow();
	if (selectRow == '' || selectRow < 0) {
		ComShowCodeMessage('COM12176');
		return false;
	}
	var pctl_no = sheetObjects[0].GetCellValue(selectRow, "pctl_no");
	if (pctl_no == '') {
		ComShowCodeMessage("PRD90026");
		return false;
	}
	pctl_no = pctl_no.substr(0, 16);
	var ld_dt = formObject.ld_dt.value;
	var por = sheetObjects[0].GetCellValue(selectRow, "por_cd");
	var pol = sheetObjects[0].GetCellValue(selectRow, "pol_cd").substr(0, 5);
	var pol_n = sheetObjects[0].GetCellValue(selectRow, "pol_cd");

	var param = "?pctl_no=" + pctl_no + "&ldd=" + ld_dt + "&por=" + por + "&pol=" + pol + "&pol_n=" + pol_n;
	ComOpenPopup('/opuscntr/ESD_PRD_0080_POP.do' + param, 1000, 750, 'ESD_PRD_0080_POP', "1,0,1,1,1,1,1,1,1,1,1,1", true);
}
