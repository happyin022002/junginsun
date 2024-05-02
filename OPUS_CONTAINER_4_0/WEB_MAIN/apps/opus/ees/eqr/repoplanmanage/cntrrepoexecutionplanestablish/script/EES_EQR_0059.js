/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName : EES_EQR_0059.js
 *@FileTitle : Execution Plan
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/23
=========================================================*/
/**
 * @fileoverview
 * @author
 */
// common static variable
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;
var tabName = new Array();
tabName[0] = "        T.VVD       ";
tabName[1] = "Truck & Rail & Water";
tabName[2] = "  On-Hire & Off-Hire  ";
tabName[3] = "     LCC Internal     ";
tabName[4] = "        Total        ";
var sheetObjects = new Array();
var sheetCnt = 0; 
var comboObjects = new Array();
var comboCnt = 0;
// RD-TEST
var rdObjects = new Array();
var rdCnt = 0;
var parmObj = new Array();
var frmObj = new Array();
// var consTpszArr = null; // tpsz type sheet
var oldValue = null; // original value in the cell
var linkPageNum = null; // selected tab from EES_EQR_0051
// var tabObjects = new Array();
var allTpszCnt = null; // amount if TP/SZ=ALL
var ComboData = "N";
var strLoading = false;
var tab2ArrSoAlert = "";
var tab4ArrSoAlert = "";
var sendToRefNo    = "";
var strMinimizeYN = true;

// Event handler processing by button click event */
document.onclick = processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	var sheetObject2 = sheetObjects[2];
	var sheetObject3 = sheetObjects[3];
	var sheetObject4 = sheetObjects[4];
	var tabObject = tabObjects[0];
	var formObject = document.form;
	// initailizing so send
	formObject.so_action.value = "";
	try {
		var srcName = ComGetEvent("name");
		if (ComGetBtnDisable(srcName))
			return false;
		// var selectedTab=tabObject.selectedIndex; // selected tab
		var selectedTab = tabObject.GetSelectedIndex(); // selected tab
		switch (srcName) {
		case "btn_new":
			
			if(strMinimizeYN == false) {				
				var minHeight1 = sheetObjects[0].GetSheetHeight()-200;		
				var minHeight2 = sheetObjects[1].GetSheetHeight()-200;		
				var minHeight3 = sheetObjects[2].GetSheetHeight()-200;		
				var minHeight4 = sheetObjects[3].GetSheetHeight()-200;		
				var minHeight5 = sheetObjects[4].GetSheetHeight()-200;
				
				document.getElementById("searchLayer").style.display = "Inline";
		    	sheetObjects[0].SetSheetHeight(minHeight1);
		    	sheetObjects[1].SetSheetHeight(minHeight2);
		    	sheetObjects[2].SetSheetHeight(minHeight3);
		    	sheetObjects[3].SetSheetHeight(minHeight4);
		    	sheetObjects[4].SetSheetHeight(minHeight5);
		    	
		    	strMinimizeYN= true;
		    	document.getElementById("btn_minimize").innerText = "Maximize";    		
			}
			
			// FM/TO LOC
			document.all.fmToLayer.style.display = "inline";
			document.all.atLayer.style.display = "none";

			ComBtnDisable("btn_create");
            ComBtnDisable("btn_delete");
            
			formObject.reset();
			tpszChange(''); // ALL 선택
			// Retieving Repo.PlanID
			// goSearchRepoid();
			formObject.yyyyww.value = "";
			formObject.seq.value = "";
			formObject.repo_rmk.value = "";
			// tpsz initializing
			comboObjects[1].SetSelectCode(consTpsz);

			// Item initializing
			comboObjects[0].RemoveAll();
			initCombo(comboObjects[0], 2);
			t1sheet1.RemoveAll();
			t2sheet1.RemoveAll();
			t3sheet1.RemoveAll();
			t4sheet1.RemoveAll();
			t5sheet1.RemoveAll();
			break;
		case "btn_retrieve":
			if (selectedTab == 0)
				doActionIBSheet(sheetObject, formObject, IBSEARCH);
			if (selectedTab == 1)
				doActionIBSheet2(sheetObject1, formObject, IBSEARCH);
			if (selectedTab == 2)
				doActionIBSheet3(sheetObject2, formObject, IBSEARCH);
			if (selectedTab == 3)
				doActionIBSheet4(sheetObject3, formObject, IBSEARCH);
			if (selectedTab == 4)
				doActionIBSheet5(sheetObject4, formObject, IBSEARCH);
			break;
		case "btn_save":
			if (selectedTab == 0)
				doActionIBSheet(sheetObject, formObject, IBSAVE);
			if (selectedTab == 1)
				doActionIBSheet2(sheetObject1, formObject, IBSAVE);
			if (selectedTab == 2)
				doActionIBSheet3(sheetObject2, formObject, IBSAVE);
			if (selectedTab == 3)
				doActionIBSheet4(sheetObject3, formObject, IBSAVE);
			if (selectedTab == 4)
				doActionIBSheet5(sheetObject4, formObject, IBSAVE);
			break;
		case "btn_downexcel":
			if (selectedTab == 0) {
				if (sheetObject.RowCount() > 0)
					doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
				else
					ComShowCodeMessage("EQR90039");
			} else if (selectedTab == 1) {
				if (sheetObject1.RowCount() > 0)
					doActionIBSheet2(sheetObject1, formObject, IBDOWNEXCEL);
				else
					ComShowCodeMessage("EQR90039");
			} else if (selectedTab == 2) {
				if (sheetObject2.RowCount() > 0)
					doActionIBSheet3(sheetObject2, formObject, IBDOWNEXCEL);
				else
					ComShowCodeMessage("EQR90039");
			} else if (selectedTab == 3) {
				if (sheetObject3.RowCount() > 0)
					doActionIBSheet4(sheetObject3, formObject, IBDOWNEXCEL);
				else
					ComShowCodeMessage("EQR90039");
			} else if (selectedTab == 4) {
				if (sheetObject4.RowCount() > 0)
					doActionIBSheet5(sheetObject4, formObject, IBDOWNEXCEL);
				else
					ComShowCodeMessage("EQR90039");
			}
			break;
		case "btn_create":
	        	doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC03);
 	    	break;
 	    case "btn_delete":
	        	doActionIBSheet(sheetObjects[0], formObject, IBDELETE);
 	    	break;
		case "btn_lane":
			var v_scnr_id = formObject.repo_pln_id.value;
			var v_display = "0,1";
			if (v_scnr_id == "") {
				ComShowCodeMessage("EQR90001", "Repo Pln ID");
				return false;
			}
			var targetObjList = "lane:lane";
			var param = "?classId=COM_ENS_0P1&scnr_id=" + v_scnr_id
					+ "&depth=2&chkDepth=2";
			ComOpenPopupWithTarget('/opuscntr/COM_ENS_0P1.do' + param, 500,
					450, targetObjList, v_display, true);
			break;
		case "btn_eqorg":
			// calling EQR Organization Chart as pop-up
			// var modal = ComOpenWindow('EES_EQR_0139.do', self,
			// "dialogLeft:0px; dialogTop:0px; dialogWidth:500px;
			// dialogHeight:574px; scroll:no; status:no" , true);
			ComOpenWindowCenter('EES_EQR_0139.do', "ESM_BKG_0139", 500, 550,
					false);
			break;
		case "btn_vvd":
			var v_scnr_id = formObject.repo_pln_id.value;
			var v_display = "0,1";
			if (v_scnr_id == "") {
				ComShowCodeMessage("EQR90001", "Repo Pln ID");
				return false;
			}
			var targetObjList = "vvd:vvd";
			var param = "?classId=COM_ENS_0P1&scnr_id=" + v_scnr_id
					+ "&depth=3&chkDepth=3";
			ComOpenPopupWithTarget('/opuscntr/COM_ENS_0P1.do' + param, 500,
					450, targetObjList, v_display, true);
			break;
		case "frloc_btn":
			var display = "0,1,1,1,1,1";
			var targetObjList = "loc_dpth_cd:fromStatus|loc_cd:fromLocation";
			var param = "?depth=4&classId=COM_ENS_0O1";
			ComOpenPopupWithTarget('/opuscntr/COM_ENS_0O1.do' + param, 500,
					440, targetObjList, display);
			break;
		case "toloc_btn":
			if (selectedTab == 2) {
				// to location disalbe at On-Hire & Off-Hire
			} else {
				var display = "0,1,1,1,1,1";
				var targetObjList = "loc_dpth_cd:toStatus|loc_cd:toLocation";
				var param = "?depth=4&classId=COM_ENS_0O1";
				ComOpenPopupWithTarget('/opuscntr/COM_ENS_0O1.do' + param, 500,
						450, targetObjList, display);
			}
			break;
		case "atloc_btn":
			var display = "0,1,1,1,1,1";
			var targetObjList = "loc_dpth_cd:atStatus|loc_cd:atLocation";
			var param = "?depth=4&classId=COM_ENS_0O1";
			ComOpenPopupWithTarget('/opuscntr/COM_ENS_0O1.do' + param, 500,
					500, targetObjList, display);
			break;
		case "fmToAt":
			if (document.all.fmToAt[1].checked == true) {
				document.all.fmToLayer.style.display = "none";
				document.all.atLayer.style.display = "inline";
			} else {
				document.all.atLayer.style.display = "none";
				document.all.fmToLayer.style.display = "inline";
			}
			break;
		case "btn_print":
			if (sheetObjects[0].RowCount('') > 0) {
				sheetObjects[0].DoPrint();
			}
			if (sheetObjects[1].RowCount('') > 0) {
				sheetObjects[1].DoPrint();
			}
			if (sheetObjects[2].RowCount('') > 0) {
				sheetObjects[2].DoPrint();
			}
			if (sheetObjects[3].RowCount('') > 0) {
				sheetObjects[4].DoPrint();
			}
			if (sheetObjects[4].RowCount('') > 0) {
				sheetObjects[4].DoPrint();
			}
			if (sheetObjects[0].RowCount('') == 0
					&& sheetObjects[1].RowCount('') == 0
					&& sheetObjects[2].RowCount('') == 0
					&& sheetObjects[3].RowCount('') == 0
					&& sheetObjects[4].RowCount('') == 0) {
				ComShowCodeMessage("EQR90095");
			}
			break;
		case "t1btng_faxsend":
			// var Row1=sheetObject.FindCheckedRow("t1_mailfax");
			var Row1 = sheetObject.FindText("t1_mailfax", "1");
			if (Row1 < 0 || Row1 == "") {
				ComShowCodeMessage("EQR90016", "Row");
				return false;
			}
			// RD
			ComOpenWindowCenter('EES_EQR_0131.do?btn_mode=F', 'EesEqr0131',
					'1000', '750', false);
			// window.showModelessDialog('EES_EQR_0131.do?btn_mode=F&pgmNo=EES_EQR_0131',
			// window,
			// "scroll:no;status:no;help:no;dialogWidth:1000px;dialogHeight:750px");
			break;
		case "t1btng_emilsend":
			// var Row2=sheetObject.FindCheckedRow("t1_mailfax");
			var Row2 = sheetObject.FindText("t1_mailfax", "1");
			if (Row2 < 0 || Row2 == "") {
				ComShowCodeMessage("EQR90016", "Row");
				return false;
			}
			// RD
			ComOpenWindowCenter('EES_EQR_0131.do?btn_mode=E', 'EesEqr0131',
					'1000', '750', false);
			// window.showModelessDialog('EES_EQR_0131.do?btn_mode=E&pgmNo=EES_EQR_0131',
			// window,
			// "scroll:no;status:no;help:no;dialogWidth:1000px;dialogHeight:900px");
			break;
		case "t1btng_rowadd":
			doActionIBSheet(sheetObject, formObject, IBINSERT);
			break;
		case "t1btng_split":
			doActionIBSheet_2(sheetObject, formObject, IBINSERT);
			break;
		case "t1btng_save":
			doActionIBSheet(sheetObject, formObject, IBSAVE);
			break;
		case "t1btng_rowcopy":
			doActionIBSheet(sheetObject, formObject, IBCOPYROW);
			break;
		case "t1btng_sort":
			ComShowMessage("t1btng_sort");
			break;
		case "t1btng_repobkg":
			doActionIBSheet_1(sheetObject, formObject, IBSAVE);
			break;
		case "t1btng_splitbkg":
			// doActionIBSheet_3(sheetObject,formObject,IBSAVE);
			// break;
		case "t1btng_forecast":
			openFcstInvWindow();
			break;
		case "t1btng_vslresidual":
			openVslResWindow();
			break;
		case "t1btng_combinedexec":
			openCombinedWindow(sheetObject, formObject, 1);
			break;
		case "t1btng_gobkgupdate":
			openMtyBkgUpdate(sheetObject, formObject);
			break;
		case "t2btng_rowadd":
			doActionIBSheet2(sheetObject1, formObject, IBINSERT);
			break;
		case "t2btng_save":
			doActionIBSheet2(sheetObject1, formObject, IBSAVE);
			break;
		case "t2btng_rowcopy":
			doActionIBSheet2(sheetObject1, formObject, IBCOPYROW);
			break;
		case "t2btng_sort":
			ComShowMessage("t2btng_sort");
			break;
		case "t2btng_repobkg":
			doActionIBSheet2_3(sheetObject1, formObject, IBSAVE);
			break;
		case "t2btng_sendtoso":
			doActionIBSheet2_1(sheetObject1, formObject, IBSAVE);
			break;
		case "t2btng_cancelsoreq":
			doActionIBSheet2_2(sheetObject1, formObject, IBSAVE);
			break;
		case "t2btng_rowadd_plan":
			doActionIBSheet2_4(sheetObject1, formObject, IBINSERT);
			break;
		case "t2btng_forecast":
			// Fcst Inventory popup
			openFcstInvWindow();
			break;
		case "t2btng_combinedexec":
			openCombinedWindow(sheetObject1, formObject, 2);
			break;
		case "t2btng_irg":
			// IRG (PRD open)
			openIrgWindow();
			break;
		case "t3btng_rowadd":
			doActionIBSheet3(sheetObject2, formObject, IBINSERT);

			// Row Add is same Lease_term Code of Plan.
			var selRow = sheetObject2.GetSelectRow();
			sheetObject2.SetCellValue(selRow, "t3_lease_term", "", 0);
			sheetObject2.SetCellEditable(selRow, "t3_lease_term", 0);// lease_term
																		// modifying
																		// disable

			break;
		case "t3btng_rowadd_plan":
			doActionIBSheet3_3(sheetObject2, formObject, IBINSERT);
			break;
		case "t3btng_save":
			doActionIBSheet3(sheetObject2, formObject, IBSAVE);
			break;
		case "t3btng_rowcopy":
			doActionIBSheet3(sheetObject2, formObject, IBCOPYROW);
			break;
		case "t3btng_sort":
			ComShowMessage("t3btng_sort");
			break;
		case "t3btng_sendtoso":
			doActionIBSheet3_1(sheetObject2, formObject, IBSAVE);
			break;
		case "t3btng_cancelsoreq":
			doActionIBSheet3_2(sheetObject2, formObject, IBSAVE);
			break;
		case "t3btng_forecast":
			// Fcst Inventory popup
			openFcstInvWindow();
			break;
		case "t3btng_onhireappinquiry":
			ComShowMessage("t3btng_onhireappinquiry");
			break;
		case "t3btng_availoffhireequip":
			ComShowMessage("t3btng_availoffhireequip");
			break;
		case "t3btng_irg":
			// IRG (PRD open)
			openIrgWindow();
			break;
		case "t4btng_rowadd":
			doActionIBSheet4(sheetObject3, formObject, IBINSERT);
			break;
		case "t4btng_save":
			doActionIBSheet4(sheetObject3, formObject, IBSAVE);
			break;
		case "t4btng_rowcopy":
			doActionIBSheet4(sheetObject3, formObject, IBCOPYROW);
			break;
		case "t4btng_sort":
			ComShowMessage("t4btng_sort");
			break;
		case "t4btng_sendtoso":
			doActionIBSheet4_1(sheetObject3, formObject, IBSAVE);
			break;
		case "t4btng_cancelsoreq":
			doActionIBSheet4_2(sheetObject3, formObject, IBSAVE);
			break;
		case "t4btng_forecast":
			// Fcst Inventory popup
			openFcstInvWindow();
			break;
		case "t4btng_irg":
			// IRG (PRD open)
			openIrgWindow();
			break;
		case "btn_repolist":
			var week = formObject.yyyyww.value;
			if (week != "") {
				var toWeek = week.substr(4, 2);
				var fmWeek = toWeek - 3;
				if (fmWeek <= 0) {
					fmWeek = "";
				}

				fmWeek = "" + fmWeek;
				if (fmWeek.length == 1) {
					fmWeek = "0" + fmWeek;
				}
				var repo_SWeek = "repo_SWeek=" + fmWeek;
				var repo_EWeek = "repo_EWeek=" + toWeek;
			} else {
				var repo_SWeek = "repo_SWeek=";
				var repo_EWeek = "repo_EWeek=";
			}
			// ComOpenWindow('EES_EQR_0107.do', window,
			// "scroll:no;status:no;help:no;dialogWidth:900px;dialogHeight:450px"
			// , true);
			ComOpenWindow(
					'/opuscntr/EES_EQR_0107.do?' + repo_SWeek + "&"
							+ repo_EWeek,
					window,
					"scroll:no;status:no;help:no;dialogWidth:1000px;dialogHeight:600px",
					true);

			break;
		case "btn_eqr_week":
			// ComOpenWindow('EES_EQR_0008.do', window,
			// "scroll:no;status:no;help:no;dialogWidth:1500px;dialogHeight:900px"
			// , false);
			// ComOpenWindowCenter('EES_EQR_0008_POP.do', "EES_EQR_0008", 1000,
			// 700, false);
			// ComOpenPopup('/opuscntr/EES_EQR_0008_POP.do?pop_mode=y', 1000,
			// 600, "EES_EQR_0008", "1,0", true, false);
			ComOpenWindow(
					'EES_EQR_0008_POP.do?pop_mode=Y',
					window,
					"scroll:no;status:no;help:no;dialogWidth:1000px;dialogHeight:600px",
					true);
			break;
		case "btn_minimize":
			 sheet_HgtChange();
			 break;   
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			// ComShowMessage(OBJECT_ERROR);
			ComShowCodeMessage("EQR90004");
		} else {
			ComShowMessage(e.message);
		}
	}
}

// SHEET1 ONCLICK EVENT
function openMtyBkgUpdate(sheetObj, formObj) {
	var bkgno = "";
	var bkgdiv = "";
	var selRow = "";
	if (sheetObj.RowCount() > 0) {
		selRow = sheetObj.GetSelectRow(); // 선택된 ROW
		if (selRow != null) {
			bkgno = sheetObj.GetCellValue(selRow, "t1_mty_bkg_no"); // lane copy
			bkgdiv = sheetObj.GetCellValue(selRow, "vl_vd_div"); // lane copy
		}
	}
	var param = "";
	param = "?pop_mode=Y&mainPage=false&pgmNo=ESM_BKG_9424&bkgno=" + bkgno;
	ComOpenPopupWithTarget('/opuscntr/ESM_BKG_9424_POP.do' + param, 1124, 580,
			"ESM_BKG_9424", "0,1,1,1,1,1,1", true);
	// ComOpenWindowCenter("/opuscntr/ESM_BKG_9424.do?pop_mode=Y&mainPage=false&pgmNo=ESM_BKG_9424&bkgno="+bkgno,
	// "ESM_BKG_9424", 1024, 650, true, "yes");
}

/**
 * registering IBSheet Object as list adding process for list in case of needing
 * batch processing with other items defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * registering IBCombo Object as list adding process for list in case of needing
 * batch processing with other items defining list on the top of source
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}

/**
 * initializing sheet adding first-served functions after loading screen. flag :
 * tab info from EES_EQR_0051
 */
function loadPage(flag) {
	allTpszCnt = consTpsz.split(',').length; // amount TP/SZ=ALL
	// var formObject = document.form;
	// showProgressPop(sheetObjects[0], formObject);

	// setTimeout( function () {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1, comboObjects[0].GetSelectText());
		ComEndConfigSheet(sheetObjects[i]);
	}

	resizeSheet();

	if (flag == "" || flag == undefined) {
		flag = 0;
	}

	ComBtnDisable("btn_create");
    ComBtnDisable("btn_delete");
    
	if (flag != "search") {
		// tab setting
		for (k = 0; k < tabObjects.length; k++) {
			initTab(tabObjects[k], k + 1);
			tabObjects[k].SetSelectedIndex(0);
		}
		// all location modifying disable when first retrieving
		document.form.fromLocation.disabled = true;
		document.form.toLocation.disabled = true;
		document.form.atLocation.disabled = true;
		document.form.sosend.disabled = true;
		// type size modifying disable when first retrieving
		document.form.tpsztype.disabled = true;
		// selecting tab with EES_EQR_0051 data
		tabObjects[0].SetSelectedIndex((flag != "") ? flag : 0);
		if (flag == 0 || flag == 1 || flag == 2 || flag == 3 || flag == 4) {
			linkPageNum = flag;
			if (flag == 1) {
				document.form.toStatus.value = document.form.link_toStatus.value;
			} else {
				document.form.fromStatus.value = document.form.link_fromStatus.value;
			}
			// retrieving automatically at page load
			goSearchRepoid("Loading");
		}
		// multi combo box setting
		for (p = 0; p < comboObjects.length; p++) {
			initCombo(comboObjects[p], p + 1);
		}
		tpszChange(''); // ALL 선택
		t1sheet1_OnLoadFinish(sheetObjects[0]);
	}
	// } , 100);
}

/**
 * setting sheet initial values and header param : sheetObj, sheetNo adding case
 * as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo, tpszValue) {
	var cnt = 0;
	// sheetObj.onlyTextTriggerForOnEdit = true; // for windows english ver.
	switch (sheetNo) {
	case 1: // t1sheet1 init
		with (sheetObj) {
			var HeadTitle0 = "Del.|STS|Mail\nFax|Week|Co.|Div.|Item|Lane|VVD|Load|Load|Discharge|Discharge|TS|Purpose|CNTR No.\nInput|MTY\nRepo BKG|BKG No.|Reason|Reason Remark|";
			var HeadTitle1 = "Del.|STS|Mail\nFax|Week|Co.|Div.|Item|Lane|VVD|LOC.|ETD|LOC.|ETB|TS|Purpose|CNTR No.\nInput|MTY\nRepo BKG|BKG No.|Reason|Reason Remark|";
			if ((tpszValue != '' && tpszValue != null))
				consTpszArr = tpszValue.split(',');
			HeadTitle0 = HeadTitle0 + "Total Vol|";
			HeadTitle1 = HeadTitle1 + "Total Vol|";
			for (i = 0; i < consTpszArr.length; i++) {
				HeadTitle0 = HeadTitle0 + "Vol.|";
				HeadTitle1 = HeadTitle1 + consTpszArr[i] + "|";
			}

			/*HeadTitle0 = HeadTitle0 + "Total Cost|";
			HeadTitle1 = HeadTitle1 + "Total Cost|";
			for (i = 0; i < consTpszArr.length; i++) {
				HeadTitle0 = HeadTitle0 + "Cost|";
				HeadTitle1 = HeadTitle1 + consTpszArr[i] + "|";
			}*/

			// 2014.10.14 Park Young Jin Start
			HeadTitle0 = HeadTitle0 + "||||||||||||||";
			HeadTitle1 = HeadTitle1 + "||||||||||||||";

			

			for (i = 0; i < consTpszArr.length; i++) {
				HeadTitle0 = HeadTitle0 + "|";
				HeadTitle1 = HeadTitle1 + "|";
			}

			HeadTitle0 = HeadTitle0 + "|||||||";
			HeadTitle1 = HeadTitle1 + "|||||||";

			

			/*for (i = 0; i < consTpszArr.length; i++) {
				HeadTitle0 = HeadTitle0 + "|";
				HeadTitle1 = HeadTitle1 + "|";
			}
			for (i = 0; i < consTpszArr.length; i++) {
				HeadTitle0 = HeadTitle0 + "|";
				HeadTitle1 = HeadTitle1 + "|";
			}

			for (i = 0; i < consTpszArr.length; i++) {
				HeadTitle0 = HeadTitle0 + "|";
				HeadTitle1 = HeadTitle1 + "|";
			}*/

			HeadTitle0 = HeadTitle0 + "||||";
			HeadTitle1 = HeadTitle1 + "||||";

			HeadTitle0 = HeadTitle0 + "Update OFC|Update User|Update Date|";
			HeadTitle1 = HeadTitle1 + "Update OFC|Update User|Update Date|";

			var columnCount = 21 + eval(consTpszArr.length * 4)
					+ eval(consTpszArr.length * 4)
					+ eval(consTpszArr.length * 3) + 32;

			SetConfig({
				SearchMode : 2,
				MergeSheet : 5,
				Page : 20,
				FrozenCol : 3,
				DataRowMerge : 1
			});

			var info = {
				Sort : 0,
				ColMove : 1,
				HeaderCheck : 0,
				ColResize : 1
			};
			var headers = [ {
				Text : HeadTitle0,
				Align : "Center"
			}, {
				Text : HeadTitle1,
				Align : "Center"
			} ];
			InitHeaders(headers, info);

			var cols = [ {
				Type : "DelCheck",
				Hidden : 0,
				Width : 30,
				Align : "Center",
				ColMerge : 1,
				SaveName : "t1_check"
			}, {
				Type : "Status",
				Hidden : 0,
				Width : 30,
				Align : "Center",
				ColMerge : 1,
				SaveName : "t1_ibflag"
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 30,
				Align : "Center",
				ColMerge : 1,
				SaveName : "t1_mailfax",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 0
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 80,
				Align : "Center",
				ColMerge : 1,
				SaveName : "t1_pln_yrwk",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 7
			}, {
				Type : "Combo",
				Hidden : 0,
				Width : 40,
				Align : "Left",
				ColMerge : 1,
				SaveName : "t1_co_cd",
				KeyField : 1,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 4
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 70,
				Align : "Left",
				ColMerge : 1,
				SaveName : "t1_div",
				KeyField : 1,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 8
			}, {
				Type : "Combo",
				Hidden : 0,
				Width : 60,
				Align : "Center",
				ColMerge : 1,
				SaveName : "t1_trsp_mod_cd",
				KeyField : 1,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 1
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 50,
				Align : "Center",
				ColMerge : 1,
				SaveName : "t1_vsl_lane_cd",
				KeyField : 1,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 1,
				EditLen : 3
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 85,
				Align : "Center",
				ColMerge : 1,
				SaveName : "t1_vvd",
				KeyField : 1,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 1,
				EditLen : 9
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 80,
				Align : "Center",
				ColMerge : 0,
				SaveName : "t1_fm_yd_cd",
				KeyField : 1,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 1,
				EditLen : 7
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 130,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t1_fm_etd_dt",
				KeyField : 1,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 80,
				Align : "Center",
				ColMerge : 0,
				SaveName : "t1_to_yd_cd",
				KeyField : 1,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 1,
				EditLen : 30
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 130,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t1_to_eta_dt",
				KeyField : 1,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Center",
				ColMerge : 1,
				SaveName : "t1_ts",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 2
			}, {
				Type : "Combo",
				Hidden : 1,
				Width : 90,
				Align : "Center",
				ColMerge : 1,
				SaveName : "t1_eq_repo_purp_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 15
			}, {
				Type : "Image",
				Hidden : 0,
				Width : 70,
				Align : "Center",
				ColMerge : 1,
				SaveName : "t1_cntrimage",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 0,
				EditLen : 9
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 60,
				Align : "Center",
				ColMerge : 1,
				SaveName : "t1_repo_mty_bkg_flg",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 0,
				EditLen : 1
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 90,
				Align : "Left",
				ColMerge : 1,
				SaveName : "t1_mty_bkg_no",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 1,
				EditLen : 13
			}, {
				Type : "Combo",
				Hidden : 0,
				Width : 90,
				Align : "Left",
				ColMerge : 1,
				SaveName : "t1_repo_pln_fb_rsn_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 2
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 150,
				Align : "Left",
				ColMerge : 1,
				SaveName : "t1_repo_pln_fb_rmk",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 1
			}, {
				Type : "Int",
				Hidden : 0,
				Width : 70,
				Align : "Right",
				ColMerge : 1,
				SaveName : "t1_totalvol",
				KeyField : 0,
				CalcLogic : "",
				Format : "Integer",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 11
			} ];
			for ( var i = 0; i < consTpszArr.length; i++) {
				cols.push({
					Type : "Int",
					Hidden : 0,
					Width : 60,
					Align : "Right",
					ColMerge : 0,
					SaveName : "t1_vol" + consTpszArr[i],
					KeyField : 0,
					CalcLogic : "",
					Format : "Integer",
					PointCount : 0,
					UpdateEdit : 1,
					InsertEdit : 1,
					EditLen : 6
				});
			}
			/*cols.push({
				Type : "Float",
				Hidden : 1,
				Width : 90,
				Align : "Right",
				ColMerge : 1,
				SaveName : "t1_totalcost",
				KeyField : 0,
				CalcLogic : "",
				Format : "Float",
				PointCount : 2,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 13
			});
			for ( var i = 0; i < consTpszArr.length; i++) {
				cols.push({
					Type : "Float",
					Hidden : 1,
					Width : 80,
					Align : "Right",
					ColMerge : 0,
					SaveName : "t1_cost" + consTpszArr[i],
					KeyField : 0,
					CalcLogic : "",
					Format : "Float",
					PointCount : 2,
					UpdateEdit : 0,
					InsertEdit : 0,
					EditLen : 13
				});
			}*/
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t1_repo_pln_id",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t1_ref_id",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t1_sortnum",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t1_num",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t1_past_repo_pln_flg",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t1_split_repo_pln_flg",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t1_fm_rcc",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t1_to_rcc",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t1_fm_lcc",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t1_to_lcc",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t1_fm_ecc",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t1_to_ecc",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t1_cntrno",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t1_tpszno",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			
			for ( var i = 0; i < consTpszArr.length; i++) {
				cols.push({
					Type : "Text",
					Hidden : 1,
					Width : 10,
					Align : "Right",
					ColMerge : 0,
					SaveName : "t1_flag" + consTpszArr[i],
					KeyField : 0,
					CalcLogic : "",
					Format : "",
					PointCount : 0,
					UpdateEdit : 1,
					InsertEdit : 1,
					EditLen : 9
				});
			}
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t1_vvd_cnt",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t1_repobkg_flag",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t1_sort_frloc",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t1_sort_toloc",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t1_sort",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t1_eta_week",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t1_pln_yrwk_next",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			});
			/*for ( var i = 0; i < consTpszArr.length; i++) {
				cols.push({
					Type : "Text",
					Hidden : 1,
					Width : 40,
					Align : "Right",
					ColMerge : 0,
					SaveName : "t1_maxvol" + consTpszArr[i],
					KeyField : 0,
					CalcLogic : "",
					Format : "",
					PointCount : 0,
					UpdateEdit : 1,
					InsertEdit : 1,
					EditLen : 9
				});
			}*/
			
			/*for ( var i = 0; i < consTpszArr.length; i++) {
				cols.push({
					Type : "Text",
					Hidden : 1,
					Width : 40,
					Align : "Right",
					ColMerge : 0,
					SaveName : "t1_unitcost" + consTpszArr[i],
					KeyField : 0,
					CalcLogic : "",
					Format : "Float",
					PointCount : 2,
					UpdateEdit : 1,
					InsertEdit : 1,
					EditLen : 13
				});
				cols.push({
					Type : "Text",
					Hidden : 1,
					Width : 40,
					Align : "Right",
					ColMerge : 0,
					SaveName : "t1_fromcost" + consTpszArr[i],
					KeyField : 0,
					CalcLogic : "",
					Format : "Float",
					PointCount : 2,
					UpdateEdit : 1,
					InsertEdit : 1
				});
				cols.push({
					Type : "Text",
					Hidden : 1,
					Width : 40,
					Align : "Right",
					ColMerge : 0,
					SaveName : "t1_tocost" + consTpszArr[i],
					KeyField : 0,
					CalcLogic : "",
					Format : "Float",
					PointCount : 2,
					UpdateEdit : 1,
					InsertEdit : 1
				});
			}*/
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t1_pln_seq",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t1_to_yard",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			// 2014.10.14 Park Young Jin Start
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t1_fm_chk_flg",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t1_to_chk_flg",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});

			cols.push({
				Type : "Text",
				Hidden : 0,
				Width : 100,
				Align : "Center",
				ColMerge : 0,
				SaveName : "t1_ofc_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			});
			cols.push({
				Type : "Text",
				Hidden : 0,
				Width : 100,
				Align : "Center",
				ColMerge : 0,
				SaveName : "t1_upd_usr_id",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			});
			cols.push({
				Type : "Text",
				Hidden : 0,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "t1_upd_dt",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			});

			
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Right",
				ColMerge : 0,
				SaveName : "t1_pass_final",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 9
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t1_cntrstatus",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t1_cntrdel",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			for ( var i = 6; i < 13; i++) {
				SetCellBackColor(1, i, "#555555");// = GetCellBackColor(1,5);
			}
			for ( var i = 14; i < 53; i++) {
				SetCellBackColor(1, i, "#555555");// = GetCellBackColor(1,5);
			}

			InitColumns(cols);

			SetEditable(1);
			SetImageList(0, "/opuscntr/img/button/btns_cntrinput.gif");// data0,CNTRNOexists
			SetImageList(1, "/opuscntr/img/button/btns_cntrinput_c.gif");// data1,CNTRNOdoesn'texists
			// SetColProperty("t1_fm_etd_dt", {Format:"####-##-####:##:##"} );
			// SetColProperty("t1_to_eta_dt", {Format:"####-##-####:##:##"} );
			SetCellBackColor(1, 5, "#555555");
			SetCellBackColor(1, i, GetCellBackColor(1, 5));
			SetCellBackColor(1, i, GetCellBackColor(1, 5));
			SetHeaderRowHeight(10);
			sheetObj.SetShowButtonImage(3);// in case of editable, showin combo
											// & pop-up image
			SetColHidden("t1_repo_pln_fb_rsn_cd", 1);
			SetColProperty("t1_trsp_mod_cd", {
				ComboText : itemText,
				ComboCode : itemCode
			});
			SetColProperty("t1_co_cd", {
				ComboText : companyText,
				ComboCode : companyCode
			});
			SetColProperty("t1_eq_repo_purp_cd", {
				ComboText : purposeText,
				ComboCode : purposeCode
			});
			SetColProperty("t1_fm_yd_cd", {
				AcceptKeys : "E|N",
				InputCaseSensitive : 1
			});
			SetColProperty("t1_to_yd_cd", {
				AcceptKeys : "E|N",
				InputCaseSensitive : 1
			});
			// SetSheetHeight(ComGetSheetHeight(sheetObj, 1));
			ComResizeSheet(sheetObj);
			SetRangeBackColor(1, 2, 1, 36, "#777777");
		}
		break;
	case 2: // t2sheet1 init
		with (sheetObj) {
			var HeadTitle0 = "Del.|STS|Week|Co.|Div.|Item|Lane|VVD|From|From|To|To|Purpose|CNTR No.\nInput|S/O\nSend|MTY\nRepo BKG|Ref No.|BKG No.|Reason|Reason Remark|";
			var HeadTitle1 = "Del.|STS|Week|Co.|Div.|Item|Lane|VVD|LOC.|ETD|LOC.|ETA|Purpose|CNTR No.\nInput|S/O\nSend|MTY\nRepo BKG|Ref No.|BKG No.|Reason|Reason Remark|";
			if ((tpszValue != '' && tpszValue != null))
				consTpszArr = tpszValue.split(',');
			HeadTitle0 = HeadTitle0 + "Total Vol|";
			HeadTitle1 = HeadTitle1 + "Total Vol|";
			for (i = 0; i < consTpszArr.length; i++) {
				HeadTitle0 = HeadTitle0 + "Vol.|";
				HeadTitle1 = HeadTitle1 + consTpszArr[i] + "|";
			}
			/*HeadTitle0 = HeadTitle0 + "Total Cost|";
			HeadTitle1 = HeadTitle1 + "Total Cost|";

			for (i = 0; i < consTpszArr.length; i++) {
				HeadTitle0 = HeadTitle0 + "Cost|";
				HeadTitle1 = HeadTitle1 + consTpszArr[i] + "|";
			}*/

			// 2014.10.14 Park Young Jin Start
			HeadTitle0 = HeadTitle0 + "|||||||||||||";
			HeadTitle1 = HeadTitle1 + "|||||||||||||";

			for (i = 0; i < consTpszArr.length; i++) {
				HeadTitle0 = HeadTitle0 + "|";
				HeadTitle1 = HeadTitle1 + "|";
			}


			HeadTitle0 = HeadTitle0 + "||||||||||||";
			HeadTitle1 = HeadTitle1 + "||||||||||||";

			

			HeadTitle0 = HeadTitle0 + "||";
			HeadTitle1 = HeadTitle1 + "||";

			HeadTitle0 = HeadTitle0 + "Update OFC|Update User|Update Date|";
			HeadTitle1 = HeadTitle1 + "Update OFC|Update User|Update Date|";

			var columnCount = 21 + eval(consTpszArr.length * 4)
					+ eval(consTpszArr.length * 4)
					+ eval(consTpszArr.length * 3) + 35;

			SetConfig({
				SearchMode : 2,
				MergeSheet : 5,
				Page : 20,
				FrozenCol : 2,
				DataRowMerge : 1
			});

			var info = {
				Sort : 0,
				ColMove : 1,
				HeaderCheck : 0,
				ColResize : 1
			};
			var headers = [ {
				Text : HeadTitle0,
				Align : "Center"
			}, {
				Text : HeadTitle1,
				Align : "Center"
			} ];
			InitHeaders(headers, info);

			var cols = [ {
				Type : "DelCheck",
				Hidden : 0,
				Width : 30,
				Align : "Center",
				ColMerge : 1,
				SaveName : "t2_check"
			}, {
				Type : "Status",
				Hidden : 0,
				Width : 30,
				Align : "Center",
				ColMerge : 1,
				SaveName : "t2_ibflag"
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 80,
				Align : "Center",
				ColMerge : 1,
				SaveName : "t2_pln_yrwk",
				KeyField : 1,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 7
			}, {
				Type : "Combo",
				Hidden : 0,
				Width : 40,
				Align : "Left",
				ColMerge : 1,
				SaveName : "t2_co_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 4
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 70,
				Align : "Left",
				ColMerge : 1,
				SaveName : "t2_div",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 15
			}, {
				Type : "Combo",
				Hidden : 0,
				Width : 60,
				Align : "Left",
				ColMerge : 1,
				SaveName : "t2_trsp_mod_cd",
				KeyField : 1,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 7
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 40,
				Align : "Left",
				ColMerge : 1,
				SaveName : "t2_vsl_lane_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 3
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 85,
				Align : "Center",
				ColMerge : 1,
				SaveName : "t2_vvd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 1,
				EditLen : 9
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 80,
				Align : "Center",
				ColMerge : 0,
				SaveName : "t2_fm_yd_cd",
				KeyField : 1,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 1,
				EditLen : 7
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 70,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t2_fm_etd_dt",
				KeyField : 1,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 10
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 80,
				Align : "Center",
				ColMerge : 0,
				SaveName : "t2_to_yd_cd",
				KeyField : 1,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 1,
				EditLen : 7
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 70,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t2_to_eta_dt",
				KeyField : 1,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 10
			}, {
				Type : "Combo",
				Hidden : 1,
				Width : 90,
				Align : "Center",
				ColMerge : 1,
				SaveName : "t2_eq_repo_purp_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 15
			}, {
				Type : "Image",
				Hidden : 0,
				Width : 70,
				Align : "Center",
				ColMerge : 1,
				SaveName : "t2_cntrimage",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 0,
				EditLen : 9
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 40,
				Align : "Center",
				ColMerge : 1,
				SaveName : "t2_so_iss_flg",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 0,
				EditLen : 1
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 60,
				Align : "Center",
				ColMerge : 1,
				SaveName : "t2_repo_mty_bkg_flg",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 0,
				EditLen : 1
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 110,
				Align : "Left",
				ColMerge : 1,
				SaveName : "t2_ref_id",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 15
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 80,
				Align : "Left",
				ColMerge : 1,
				SaveName : "t2_bkg_no",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 15
			}, {
				Type : "Combo",
				Hidden : 0,
				Width : 90,
				Align : "Left",
				ColMerge : 1,
				SaveName : "t2_repo_pln_fb_rsn_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 2
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 150,
				Align : "Left",
				ColMerge : 1,
				SaveName : "t2_repo_pln_fb_rmk",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 1
			}, {
				Type : "Int",
				Hidden : 0,
				Width : 70,
				Align : "Right",
				ColMerge : 1,
				SaveName : "t2_totalvol",
				KeyField : 0,
				CalcLogic : "",
				Format : "Integer",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 11
			} ];
			for ( var i = 0; i < consTpszArr.length; i++) {
				cols.push({
					Type : "Int",
					Hidden : 0,
					Width : 60,
					Align : "Right",
					ColMerge : 0,
					SaveName : "t2_vol" + consTpszArr[i],
					KeyField : 0,
					CalcLogic : "",
					Format : "Integer",
					PointCount : 0,
					UpdateEdit : 1,
					InsertEdit : 1,
					EditLen : 6
				});
			}
			/*cols.push({
				Type : "Float",
				Hidden : 1,
				Width : 90,
				Align : "Right",
				ColMerge : 1,
				SaveName : "t2_totalcost",
				KeyField : 0,
				CalcLogic : "",
				Format : "Float",
				PointCount : 2,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 13
			});
			for ( var i = 0; i < consTpszArr.length; i++) {
				cols.push({
					Type : "Float",
					Hidden : 1,
					Width : 80,
					Align : "Right",
					ColMerge : 0,
					SaveName : "t2_cost" + consTpszArr[i],
					KeyField : 0,
					CalcLogic : "",
					Format : "Float",
					PointCount : 2,
					UpdateEdit : 0,
					InsertEdit : 0,
					EditLen : 13
				});
			}*/
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 80,
				Align : "Left",
				ColMerge : 1,
				SaveName : "t2_pln_seq",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 15
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t2_repo_pln_id",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t2_sortnum",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t2_num",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t2_past_repo_pln_flg",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t2_fm_rcc",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t2_to_rcc",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t2_fm_lcc",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t2_to_lcc",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t2_fm_ecc",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t2_to_ecc",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t2_cntrno",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t2_tpszno",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			/*for ( var i = 0; i < consTpszArr.length; i++) {
				cols.push({
					Type : "Text",
					Hidden : 1,
					Width : 10,
					Align : "Right",
					ColMerge : 0,
					SaveName : "t2_cntrvol" + consTpszArr[i],
					KeyField : 0,
					CalcLogic : "",
					Format : "Integer",
					PointCount : 0,
					UpdateEdit : 1,
					InsertEdit : 1,
					EditLen : 9
				});
			}*/
			for ( var i = 0; i < consTpszArr.length; i++) {
				cols.push({
					Type : "Text",
					Hidden : 1,
					Width : 10,
					Align : "Right",
					ColMerge : 0,
					SaveName : "t2_flag" + consTpszArr[i],
					KeyField : 0,
					CalcLogic : "",
					Format : "",
					PointCount : 0,
					UpdateEdit : 1,
					InsertEdit : 1,
					EditLen : 9
				});
			}
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t2_vvd_cnt",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t2_so_cancel_flag",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t2_repobkg_flag",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t2_sort",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t2_week_fromdate",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t2_week_todate",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t2_week_maxdate",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t2_trspno_p",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t2_trspno_d",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t2_trspno_a",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			});
			/*for ( var i = 0; i < consTpszArr.length; i++) {
				cols.push({
					Type : "Text",
					Hidden : 1,
					Width : 40,
					Align : "Right",
					ColMerge : 0,
					SaveName : "t2_maxvol" + consTpszArr[i],
					KeyField : 0,
					CalcLogic : "",
					Format : "",
					PointCount : 0,
					UpdateEdit : 1,
					InsertEdit : 1,
					EditLen : 9
				});
			}
			for ( var i = 0; i < consTpszArr.length; i++) {
				cols.push({
					Type : "Text",
					Hidden : 1,
					Width : 40,
					Align : "Right",
					ColMerge : 0,
					SaveName : "t2_basicratio" + consTpszArr[i],
					KeyField : 0,
					CalcLogic : "",
					Format : "",
					PointCount : 0,
					UpdateEdit : 1,
					InsertEdit : 1,
					EditLen : 9
				});
				cols.push({
					Type : "Text",
					Hidden : 1,
					Width : 40,
					Align : "Right",
					ColMerge : 0,
					SaveName : "t2_basicvol" + consTpszArr[i],
					KeyField : 0,
					CalcLogic : "",
					Format : "",
					PointCount : 0,
					UpdateEdit : 1,
					InsertEdit : 1,
					EditLen : 9
				});
			}*/
			/*for ( var i = 0; i < consTpszArr.length; i++) {
				cols.push({
					Type : "Text",
					Hidden : 1,
					Width : 40,
					Align : "Right",
					ColMerge : 0,
					SaveName : "t2_unitcost" + consTpszArr[i],
					KeyField : 0,
					CalcLogic : "",
					Format : "Float",
					PointCount : 2,
					UpdateEdit : 1,
					InsertEdit : 1,
					EditLen : 13
				});
				cols.push({
					Type : "Text",
					Hidden : 1,
					Width : 40,
					Align : "Right",
					ColMerge : 0,
					SaveName : "t2_fromcost" + consTpszArr[i],
					KeyField : 0,
					CalcLogic : "",
					Format : "Float",
					PointCount : 2,
					UpdateEdit : 1,
					InsertEdit : 1,
					EditLen : 13
				});
				cols.push({
					Type : "Text",
					Hidden : 1,
					Width : 40,
					Align : "Right",
					ColMerge : 0,
					SaveName : "t2_tocost" + consTpszArr[i],
					KeyField : 0,
					CalcLogic : "",
					Format : "Float",
					PointCount : 2,
					UpdateEdit : 1,
					InsertEdit : 1,
					EditLen : 13
				});
			}*/
			// 2014.10.14 Park Young Jin Start
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t2_fm_chk_flg",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t2_to_chk_flg",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});

			cols.push({
				Type : "Text",
				Hidden : 0,
				Width : 100,
				Align : "Center",
				ColMerge : 0,
				SaveName : "t2_ofc_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			});
			cols.push({
				Type : "Text",
				Hidden : 0,
				Width : 100,
				Align : "Center",
				ColMerge : 0,
				SaveName : "t2_upd_usr_id",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			});
			cols.push({
				Type : "Text",
				Hidden : 0,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "t2_upd_dt",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			});

			/*for ( var i = 0; i < consTpszArr.length; i++) {
				cols.push({
					Type : "Text",
					Hidden : 1,
					Width : 40,
					Align : "Right",
					ColMerge : 0,
					SaveName : "t2_pass" + consTpszArr[i],
					KeyField : 0,
					CalcLogic : "",
					Format : "",
					PointCount : 0,
					UpdateEdit : 1,
					InsertEdit : 1,
					EditLen : 9
				});
			}*/
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Right",
				ColMerge : 0,
				SaveName : "t2_pass_final",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 9
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t2_eccresult",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t2_newplan",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t2_cntrdel",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			});
			for ( var i = 5; i < 53; i++) {
				SetCellBackColor(1, i, "#555555"); // = GetCellBackColor(1,5);
			}

			InitColumns(cols);

			SetEditable(1);
			SetImageList(0, "/opuscntr/img/button/btns_cntrinput.gif");
			SetImageList(1, "/opuscntr/img/button/btns_cntrinput_c.gif");

			SetColProperty("t2_pln_yrwk", {
				Format : "######"
			});

			SetCellBackColor(1, 5, "#555555");
			SetCellBackColor(1, i, GetCellBackColor(1, 5));
			SetHeaderRowHeight(10);
			SetShowButtonImage(3);// in case of editable, showin combo &
									// pop-up image
			SetColHidden("t2_repo_pln_fb_rsn_cd", 1);
			// SetSheetHeight(ComGetSheetHeight(sheetObj, 14));
			// ComResizeSheet(sheetObj);
			SetColProperty("t2_trsp_mod_cd", {
				ComboText : item_inlandText,
				ComboCode : item_inlandCode
			});
			SetColProperty("t2_co_cd", {
				ComboText : companyText,
				ComboCode : companyCode
			});
			SetColProperty("t2_eq_repo_purp_cd", {
				ComboText : purposeText,
				ComboCode : purposeCode
			});
			SetColProperty(0, "t2_vvd", {
				AcceptKeys : "E|N",
				InputCaseSensitive : 1
			});
			SetColProperty(0, "t2_fm_yd_cd", {
				AcceptKeys : "E|N",
				InputCaseSensitive : 1
			});
			SetColProperty(0, "t2_to_yd_cd", {
				AcceptKeys : "E|N",
				InputCaseSensitive : 1
			});
			SetRangeBackColor(1, 2, 1, 36, "#777777");
		}
		break;
	case 3: // t3sheet1 init
		with (sheetObj) {

			var HeadTitle0 = "Del.|STS|Week|Co.|Div.|Item|LEASE|LSR|From|From|To|To|CNTR No.\nInput|S/O\nSend|NO S/O\nSend|Ref No.|Reason|Reason Remark|";
			var HeadTitle1 = "Del.|STS|Week|Co.|Div.|Item|LEASE|LSR|LCC.|ETD|LCC.|ETA|CNTR No.\nInput|S/O\nSend|NO S/O\nSend|Ref No.|Reason|Reason Remark|";

			if ((tpszValue != '' && tpszValue != null))
				consTpszArr = tpszValue.split(',');

			HeadTitle0 = HeadTitle0 + "Total Vol|";
			HeadTitle1 = HeadTitle1 + "Total Vol|";

			for (i = 0; i < consTpszArr.length; i++) {
				HeadTitle0 = HeadTitle0 + "Vol.|";
				HeadTitle1 = HeadTitle1 + consTpszArr[i] + "|";
			}

			/*HeadTitle0 = HeadTitle0 + "Total Cost|";
			HeadTitle1 = HeadTitle1 + "Total Cost|";

			for (i = 0; i < consTpszArr.length; i++) {
				HeadTitle0 = HeadTitle0 + "Cost|";
				HeadTitle1 = HeadTitle1 + consTpszArr[i] + "|";
			}*/

			// 2014.10.14 Park Young Jin Start
			HeadTitle0 = HeadTitle0 + "||||||||||||||||";
			HeadTitle1 = HeadTitle1 + "||||||||||||||||";

			for (i = 0; i < consTpszArr.length; i++) {
				HeadTitle0 = HeadTitle0 + "|";
				HeadTitle1 = HeadTitle1 + "|";
			}

			HeadTitle0 = HeadTitle0 + "||||||";
			HeadTitle1 = HeadTitle1 + "||||||";

			/*for (i = 0; i < consTpszArr.length; i++) {
				HeadTitle0 = HeadTitle0 + "|";
				HeadTitle1 = HeadTitle1 + "|";
			}

			for (i = 0; i < consTpszArr.length; i++) {
				HeadTitle0 = HeadTitle0 + "|";
				HeadTitle1 = HeadTitle1 + "|";
			}

			for (i = 0; i < consTpszArr.length; i++) {
				HeadTitle0 = HeadTitle0 + "|";
				HeadTitle1 = HeadTitle1 + "|";
			}*/

			/*for (i = 0; i < consTpszArr.length; i++) {
				HeadTitle0 = HeadTitle0 + "|";
				HeadTitle1 = HeadTitle1 + "|";
			}*/

			HeadTitle0 = HeadTitle0 + "||";
			HeadTitle1 = HeadTitle1 + "||";

			HeadTitle0 = HeadTitle0 + "Update OFC|Update User|Update Date|";
			HeadTitle1 = HeadTitle1 + "Update OFC|Update User|Update Date|";
			// 2014.10.14 Park Young Jin Start
			var columnCount = 20 + eval(consTpszArr.length * 3)
					+ eval(consTpszArr.length * 4)
					+ eval(consTpszArr.length * 1) + 31;

			SetConfig({
				SearchMode : 2,
				MergeSheet : 5,
				Page : 20,
				FrozenCol : 2,
				DataRowMerge : 1
			});

			var info = {
				Sort : 0,
				ColMove : 1,
				HeaderCheck : 0,
				ColResize : 1
			};
			var headers = [ {
				Text : HeadTitle0,
				Align : "Center"
			}, {
				Text : HeadTitle1,
				Align : "Center"
			} ];
			InitHeaders(headers, info);

			var cols = [ {
				Type : "DelCheck",
				Hidden : 0,
				Width : 30,
				Align : "Center",
				ColMerge : 1,
				SaveName : "t3_check"
			}, {
				Type : "Status",
				Hidden : 0,
				Width : 30,
				Align : "Center",
				ColMerge : 1,
				SaveName : "t3_ibflag"
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 80,
				Align : "Center",
				ColMerge : 1,
				SaveName : "t3_pln_yrwk",
				KeyField : 1,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 6
			}, {
				Type : "Combo",
				Hidden : 0,
				Width : 40,
				Align : "Center",
				ColMerge : 1,
				SaveName : "t3_co_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 4
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 60,
				Align : "Left",
				ColMerge : 1,
				SaveName : "t3_div",
				KeyField : 1,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 10
			}, {
				Type : "Combo",
				Hidden : 0,
				Width : 60,
				Align : "Center",
				ColMerge : 1,
				SaveName : "t3_onf_hir_div_cd",
				KeyField : 1,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 8
			}, {
				Type : "Combo",
				Hidden : 1,
				Width : 50,
				Align : "Center",
				ColMerge : 1,
				SaveName : "t3_lease_term",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 1,
				EditLen : 2
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 50,
				Align : "Left",
				ColMerge : 1,
				SaveName : "t3_vndr",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 1,
				ShowCol : 0
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 80,
				Align : "Center",
				ColMerge : 0,
				SaveName : "t3_fm_yd_cd",
				KeyField : 1,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 1,
				EditLen : 7
			}, {
				Type : "Date",
				Hidden : 0,
				Width : 100,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t3_fm_loc_dt",
				KeyField : 1,
				CalcLogic : "",
				Format : "Ymd",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 10
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 80,
				Align : "Center",
				ColMerge : 0,
				SaveName : "t3_to_yd_cd",
				KeyField : 1,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 1,
				EditLen : 7
			}, {
				Type : "Date",
				Hidden : 0,
				Width : 100,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t3_to_loc_dt",
				KeyField : 1,
				CalcLogic : "",
				Format : "Ymd",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 10
			}, {
				Type : "Image",
				Hidden : 0,
				Width : 80,
				Align : "Center",
				ColMerge : 1,
				SaveName : "t3_cntrimage",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 9
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 45,
				Align : "Center",
				ColMerge : 1,
				SaveName : "t3_so_iss_flg",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 0,
				EditLen : 1
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 45,
				Align : "Center",
				ColMerge : 1,
				SaveName : "t3_noso_iss_flg",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 0,
				EditLen : 1
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 110,
				Align : "Left",
				ColMerge : 1,
				SaveName : "t3_ref_id",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 15
			}, {
				Type : "Combo",
				Hidden : 0,
				Width : 90,
				Align : "Left",
				ColMerge : 1,
				SaveName : "t3_repo_pln_fb_rsn_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 2
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 150,
				Align : "Left",
				ColMerge : 1,
				SaveName : "t3_repo_pln_fb_rmk",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 1
			}, {
				Type : "Int",
				Hidden : 0,
				Width : 70,
				Align : "Right",
				ColMerge : 1,
				SaveName : "t3_totalvol",
				KeyField : 0,
				CalcLogic : "",
				Format : "Integer",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 11
			} ];
			for ( var i = 0; i < consTpszArr.length; i++) {
				cols.push({
					Type : "Int",
					Hidden : 0,
					Width : 60,
					Align : "Right",
					ColMerge : 0,
					SaveName : "t3_vol" + consTpszArr[i],
					KeyField : 0,
					CalcLogic : "",
					Format : "Integer",
					PointCount : 0,
					UpdateEdit : 1,
					InsertEdit : 1,
					EditLen : 6
				});
			}
			/*cols.push({
				Type : "Float",
				Hidden : 1,
				Width : 90,
				Align : "Right",
				ColMerge : 1,
				SaveName : "t3_totalcost",
				KeyField : 0,
				CalcLogic : "",
				Format : "Float",
				PointCount : 2,
				UpdateEdit : 0,
				InsertEdit : 0
			});
			for ( var i = 0; i < consTpszArr.length; i++) {
				cols.push({
					Type : "Float",
					Hidden : 1,
					Width : 80,
					Align : "Right",
					ColMerge : 0,
					SaveName : "t3_cost" + consTpszArr[i],
					KeyField : 0,
					CalcLogic : "",
					Format : "Float",
					PointCount : 2,
					UpdateEdit : 0,
					InsertEdit : 0,
					EditLen : 13
				});
			}*/
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t3_repo_pln_id",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t3_pln_seq",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t3_vndr_abbr_nm",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t3_vndr_cnt_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 2
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t3_vndr_seq",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 10
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t3_sortnum",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t3_num",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t3_fm_rcc",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t3_to_rcc",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t3_fm_lcc",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t3_to_lcc",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t3_fm_ecc",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t3_to_ecc",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t3_cntrno",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t3_tpszno",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			});
			for ( var i = 0; i < consTpszArr.length; i++) {
				cols.push({
					Type : "Text",
					Hidden : 1,
					Width : 10,
					Align : "Right",
					ColMerge : 0,
					SaveName : "t3_flag" + consTpszArr[i],
					KeyField : 0,
					CalcLogic : "",
					Format : "",
					PointCount : 0,
					UpdateEdit : 1,
					InsertEdit : 1,
					EditLen : 9
				});
			}
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t3_so_cancel_flag",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t3_week_fromdate",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t3_week_todate",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t3_week_maxdate",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t3_trspno_p",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t3_trspno_d",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			});
			/*for ( var i = 0; i < consTpszArr.length; i++) {
				cols.push({
					Type : "Text",
					Hidden : 1,
					Width : 40,
					Align : "Right",
					ColMerge : 0,
					SaveName : "t3_maxvol" + consTpszArr[i],
					KeyField : 0,
					CalcLogic : "",
					Format : "",
					PointCount : 0,
					UpdateEdit : 1,
					InsertEdit : 1,
					EditLen : 9
				});
			}
			for ( var i = 0; i < consTpszArr.length; i++) {
				cols.push({
					Type : "Text",
					Hidden : 1,
					Width : 40,
					Align : "Right",
					ColMerge : 0,
					SaveName : "t3_basicratio" + consTpszArr[i],
					KeyField : 0,
					CalcLogic : "",
					Format : "",
					PointCount : 0,
					UpdateEdit : 1,
					InsertEdit : 1,
					EditLen : 9
				});
				cols.push({
					Type : "Text",
					Hidden : 1,
					Width : 40,
					Align : "Right",
					ColMerge : 0,
					SaveName : "t3_basicvol" + consTpszArr[i],
					KeyField : 0,
					CalcLogic : "",
					Format : "",
					PointCount : 0,
					UpdateEdit : 1,
					InsertEdit : 1,
					EditLen : 9
				});
			}*/
			/*for ( var i = 0; i < consTpszArr.length; i++) {
				cols.push({
					Type : "Text",
					Hidden : 1,
					Width : 40,
					Align : "Right",
					ColMerge : 0,
					SaveName : "t3_unitcost" + consTpszArr[i],
					KeyField : 0,
					CalcLogic : "",
					Format : "Float",
					PointCount : 2,
					UpdateEdit : 1,
					InsertEdit : 1,
					EditLen : 13
				});
			}*/

			// 2014.10.14 Park Young Jin Start
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t3_fm_chk_flg",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t3_to_chk_flg",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});

			cols.push({
				Type : "Text",
				Hidden : 0,
				Width : 100,
				Align : "Center",
				ColMerge : 0,
				SaveName : "t3_ofc_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			});
			cols.push({
				Type : "Text",
				Hidden : 0,
				Width : 100,
				Align : "Center",
				ColMerge : 0,
				SaveName : "t3_upd_usr_id",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			});
			cols.push({
				Type : "Text",
				Hidden : 0,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "t3_upd_dt",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			});

			for ( var i = 0; i < consTpszArr.length; i++) {
				cols.push({
					Type : "Text",
					Hidden : 1,
					Width : 40,
					Align : "Right",
					ColMerge : 0,
					SaveName : "t3_pass" + consTpszArr[i],
					KeyField : 0,
					CalcLogic : "",
					Format : "",
					PointCount : 0,
					UpdateEdit : 1,
					InsertEdit : 1,
					EditLen : 9
				});
			}
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Right",
				ColMerge : 0,
				SaveName : "t3_pass_final",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 9
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t3_eccresult",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t3_newplan",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t3_cntrdel",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			});

			for ( var i = 5; i < 49; i++) {
				GetCellBackColor(1, i, "#555555");// = GetCellBackColor(1,5);
			}

			InitColumns(cols);

			SetEditable(1);
			SetImageList(0, "/opuscntr/img/button/btns_cntrinput.gif");// data0,CNTRNOexists
			SetImageList(1, "/opuscntr/img/button/btns_cntrinput_c.gif");// data1,CNTRNOdoesn'texists
			SetColProperty("t3_pln_yrwk", {
				Format : "######"
			});
			SetCellBackColor(1, 5, "#555555");
			SetCellBackColor(1, i, GetCellBackColor(1, 5));
			SetHeaderRowHeight(10);
			SetShowButtonImage(3);// in case of editable, showin combo &
									// pop-up image
			SetColHidden("t3_repo_pln_fb_rsn_cd", 1);
			// SetSheetHeight(ComGetSheetHeight(sheetObj, 14));
			// ComResizeSheet(sheetObj);
			SetColProperty("t3_onf_hir_div_cd", {
				ComboText : item_hireText,
				ComboCode : item_hireCode
			});
			SetColProperty("t3_lease_term", {
				ComboText : item_leaseText,
				ComboCode : item_leaseCode
			});
			SetColProperty("t3_co_cd", {
				ComboText : companyText,
				ComboCode : companyCode
			});
			SetColProperty(0, "t3_fm_yd_cd", {
				AcceptKeys : "E|N",
				InputCaseSensitive : 1
			});
			SetColProperty(0, "t3_to_yd_cd", {
				AcceptKeys : "E|N",
				InputCaseSensitive : 1
			});
			SetColProperty(0, "t3_vndr", {
				AcceptKeys : "E",
				InputCaseSensitive : 1
			});

			SetRangeBackColor(1, 2, 1, 36, "#777777");
		}
		break;
	case 4: // t4sheet1 init
		with (sheetObj) {

			var HeadTitle0 = "Del.|STS|Week|Co.|Div.|Item|From|From|To|To|Purpose|CNTR No.|S/O\nSend|Ref No.|Combined Ref No.|";
			var HeadTitle1 = "Del.|STS|Week|Co.|Div.|Item|LCC.|ETD|LCC.|ETA|Purpose|CNTR No.|S/O\nSend|Ref No.|Combined Ref No.|";
			if ((tpszValue != '' && tpszValue != null))
				consTpszArr = tpszValue.split(',');
			HeadTitle0 = HeadTitle0 + "Total Vol|";
			HeadTitle1 = HeadTitle1 + "Total Vol|";
			for (i = 0; i < consTpszArr.length; i++) {
				HeadTitle0 = HeadTitle0 + "Vol.|";
				HeadTitle1 = HeadTitle1 + consTpszArr[i] + "|";
			}
			/*HeadTitle0 = HeadTitle0 + "Total Cost|";
			HeadTitle1 = HeadTitle1 + "Total Cost|";

			for (i = 0; i < consTpszArr.length; i++) {
				HeadTitle0 = HeadTitle0 + "Cost|";
				HeadTitle1 = HeadTitle1 + consTpszArr[i] + "|";
			}*/

			// 2014.10.14 Park Young Jin Start
			HeadTitle0 = HeadTitle0 + "|||||";
			HeadTitle1 = HeadTitle1 + "|||||";

			/*for (i = 0; i < consTpszArr.length; i++) {
				HeadTitle0 = HeadTitle0 + "|";
				HeadTitle1 = HeadTitle1 + "|";
			}*/

			for (i = 0; i < consTpszArr.length; i++) {
				HeadTitle0 = HeadTitle0 + "|";
				HeadTitle1 = HeadTitle1 + "|";
			}

			HeadTitle0 = HeadTitle0 + "|||||||||||||";
			HeadTitle1 = HeadTitle1 + "|||||||||||||";

			HeadTitle0 = HeadTitle0 + "Update OFC|Update User|Update Date|";
			HeadTitle1 = HeadTitle1 + "Update OFC|Update User|Update Date|";

			var columnCount = 17 + eval(consTpszArr.length * 4) + 21; // 12 :
																		// hidden
																		// value

			SetConfig({
				SearchMode : 2,
				MergeSheet : 5,
				Page : 20,
				FrozenCol : 2,
				DataRowMerge : 1
			});

			var info = {
				Sort : 0,
				ColMove : 1,
				HeaderCheck : 0,
				ColResize : 1
			};
			var headers = [ {
				Text : HeadTitle0,
				Align : "Center"
			}, {
				Text : HeadTitle1,
				Align : "Center"
			} ];
			InitHeaders(headers, info);

			var cols = [ {
				Type : "DelCheck",
				Hidden : 0,
				Width : 30,
				Align : "Center",
				ColMerge : 1,
				SaveName : "t4_check"
			}, {
				Type : "Status",
				Hidden : 0,
				Width : 30,
				Align : "Center",
				ColMerge : 1,
				SaveName : "t4_ibflag"
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 80,
				Align : "Center",
				ColMerge : 1,
				SaveName : "t4_pln_yrwk",
				KeyField : 1,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 1,
				EditLen : 6
			}, {
				Type : "Combo",
				Hidden : 0,
				Width : 40,
				Align : "Left",
				ColMerge : 1,
				SaveName : "t4_co_cd",
				KeyField : 1,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 4
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 70,
				Align : "Left",
				ColMerge : 1,
				SaveName : "t4_div",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 15
			}, {
				Type : "Combo",
				Hidden : 0,
				Width : 50,
				Align : "Left",
				ColMerge : 1,
				SaveName : "t4_trsp_mod_cd",
				KeyField : 1,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 1,
				EditLen : 7
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 90,
				Align : "Center",
				ColMerge : 0,
				SaveName : "t4_fm_yd_cd",
				KeyField : 1,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 7,
				ShowCol : 0
			}, {
				Type : "Date",
				Hidden : 0,
				Width : 100,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t4_fm_etd_dt",
				KeyField : 1,
				CalcLogic : "",
				Format : "Ymd",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 10
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 90,
				Align : "Center",
				ColMerge : 0,
				SaveName : "t4_to_yd_cd",
				KeyField : 1,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 7 
			}, {
				Type : "Date",
				Hidden : 0,
				Width : 100,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t4_to_eta_dt",
				KeyField : 1,
				CalcLogic : "",
				Format : "Ymd",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 10
			}, {
				Type : "Combo",
				Hidden : 1,
				Width : 90,
				Align : "Left",
				ColMerge : 1,
				SaveName : "t4_eq_repo_purp_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 15
			}, {
				Type : "Image",
				Hidden : 0,
				Width : 70,
				Align : "Center",
				ColMerge : 1,
				SaveName : "t4_cntrimage",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 9
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 40,
				Align : "Center",
				ColMerge : 1,
				SaveName : "t4_so_iss_flg",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 0,
				EditLen : 1
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 110,
				Align : "Left",
				ColMerge : 1,
				SaveName : "t4_ref_id",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 15
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 110,
				Align : "Left",
				ColMerge : 1,
				SaveName : "",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 15
			}, {
				Type : "Int",
				Hidden : 0,
				Width : 70,
				Align : "Right",
				ColMerge : 1,
				SaveName : "t4_totalvol",
				KeyField : 0,
				CalcLogic : "",
				Format : "Integer",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 11
			} ];
			for ( var i = 0; i < consTpszArr.length; i++) {
				cols.push({
					Type : "Int",
					Hidden : 0,
					Width : 60,
					Align : "Right",
					ColMerge : 0,
					SaveName : "t4_vol" + consTpszArr[i],
					KeyField : 0,
					CalcLogic : "",
					Format : "Integer",
					PointCount : 0,
					UpdateEdit : 1,
					InsertEdit : 1,
					EditLen : 6
				});
			}
			/*cols.push({
				Type : "Float",
				Hidden : 1,
				Width : 90,
				Align : "Right",
				ColMerge : 1,
				SaveName : "t4_totalcost",
				KeyField : 0,
				CalcLogic : "",
				Format : "Float",
				PointCount : 2,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 13
			});
			for ( var i = 0; i < consTpszArr.length; i++) {
				cols.push({
					Type : "Float",
					Hidden : 1,
					Width : 80,
					Align : "Right",
					ColMerge : 0,
					SaveName : "t4_cost" + consTpszArr[i],
					KeyField : 0,
					CalcLogic : "",
					Format : "Float",
					PointCount : 2,
					UpdateEdit : 0,
					InsertEdit : 0,
					EditLen : 13
				});
			}*/
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t4_repo_pln_id",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t4_sortnum",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t4_num",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t4_cntrno",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t4_tpszno",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			/*for ( var i = 0; i < consTpszArr.length; i++) {
				cols.push({
					Type : "Text",
					Hidden : 1,
					Width : 10,
					Align : "Right",
					ColMerge : 0,
					SaveName : "t4_cntrvol" + consTpszArr[i],
					KeyField : 0,
					CalcLogic : "",
					Format : "Integer",
					PointCount : 0,
					UpdateEdit : 1,
					InsertEdit : 1,
					EditLen : 9
				});
			}*/
			for ( var i = 0; i < consTpszArr.length; i++) {
				cols.push({
					Type : "Text",
					Hidden : 1,
					Width : 10,
					Align : "Right",
					ColMerge : 0,
					SaveName : "t4_flag" + consTpszArr[i],
					KeyField : 0,
					CalcLogic : "",
					Format : "",
					PointCount : 0,
					UpdateEdit : 1,
					InsertEdit : 1,
					EditLen : 9
				});
			}
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t4_week_fromdate",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 10
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t4_week_todate",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 10
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t4_week_maxdate",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t4_frloc_rcc",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t4_fm_ecc",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 5
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t4_to_ecc",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 5
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t4_trspno_p",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t4_trspno_d",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t4_so_cancel_flag",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t4_cntrdel",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			});

			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t4_sort1",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 1,
				UpdateEdit : 1
			});
			// 2014.10.14 Park Young Jin Start
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t4_fm_chk_flg",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t4_to_chk_flg",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});

			cols.push({
				Type : "Text",
				Hidden : 0,
				Width : 100,
				Align : "Center",
				ColMerge : 0,
				SaveName : "t4_ofc_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			});
			cols.push({
				Type : "Text",
				Hidden : 0,
				Width : 100,
				Align : "Center",
				ColMerge : 0,
				SaveName : "t4_upd_usr_id",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			});
			cols.push({
				Type : "Text",
				Hidden : 0,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "t4_upd_dt",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			});

			for ( var i = 5; i < 47; i++) {
				GetCellBackColor(1, i, "#555555");// = GetCellBackColor(1,4);
			}

			InitColumns(cols);

			SetEditable(1);
			SetImageList(0, "/opuscntr/img/button/btns_cntrinput.gif");
			SetImageList(1, "/opuscntr/img/button/btns_cntrinput_c.gif");
			SetCellBackColor(1, 4, "#555555");
			SetCellBackColor(1, i, GetCellBackColor(1, 4));
			SetHeaderRowHeight(10);
			SetShowButtonImage(3);// in case of editable, showin combo &
									// pop-up image
			// SetSheetHeight(ComGetSheetHeight(sheetObj, 14));
			// ComResizeSheet(sheetObj);
			SetColProperty("t4_co_cd", {
				ComboText : companyText,
				ComboCode : companyCode
			});
			SetColProperty("t4_eq_repo_purp_cd", {
				ComboText : purposeText,
				ComboCode : purposeCode
			});
			SetColProperty("t4_trsp_mod_cd", {
				ComboText : item_shuttleText,
				ComboCode : item_shuttleCode
			});
			SetColProperty("t4_fm_yd_cd", {
				AcceptKeys : "E|N",
				InputCaseSensitive : 1
			});
			SetColProperty("t4_to_yd_cd", {
				AcceptKeys : "E|N",
				InputCaseSensitive : 1
			});
			SetRangeBackColor(1, 2, 1, 36, "#777777");
		}
		break;
	case 5: // t5sheet1 init
		with (sheetObj) {

			var HeadTitle0 = "Week|Co.|Div.|Item|Lane|VVD|From|From|To|To|LSR|S/O\nSend|MTY\nRepo BKG|Ref No.|BKG No.|Purpose|Reason|Reason Remark|";
			var HeadTitle1 = "Week|Co.|Div.|Item|Lane|VVD|Loc.|ETD|Loc.|ETB(VVD)/ETA|LSR|S/O\nSend|MTY\nRepo BKG|Ref No.|BKG No.|Purpose|Reason|Reason Remark|";
			if ((tpszValue != '' && tpszValue != null))
				consTpszArr = tpszValue.split(',');
			HeadTitle0 = HeadTitle0 + "Total Vol|";
			HeadTitle1 = HeadTitle1 + "Total Vol|";
			for (i = 0; i < consTpszArr.length; i++) {
				HeadTitle0 = HeadTitle0 + "Vol.|";
				HeadTitle1 = HeadTitle1 + consTpszArr[i] + "|";
			}
			/*HeadTitle0 = HeadTitle0 + "Total Cost|";
			HeadTitle1 = HeadTitle1 + "Total Cost|";
			for (i = 0; i < consTpszArr.length; i++) {
				HeadTitle0 = HeadTitle0 + "Cost|";
				HeadTitle1 = HeadTitle1 + consTpszArr[i] + "|";
			}*/
			var columnCount = 20 + eval(consTpszArr.length * 2);

			SetConfig({
				SearchMode : 2,
				MergeSheet : 5,
				Page : 20,
				FrozenCol : 2,
				DataRowMerge : 1
			});

			var info = {
				Sort : 0,
				ColMove : 1,
				HeaderCheck : 0,
				ColResize : 1
			};
			var headers = [ {
				Text : HeadTitle0,
				Align : "Center"
			}, {
				Text : HeadTitle1,
				Align : "Center"
			} ];
			InitHeaders(headers, info);

			var cols = [ {
				Type : "Text",
				Hidden : 0,
				Width : 80,
				Align : "Center",
				ColMerge : 1,
				SaveName : "t5_pln_yrwk",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 7
			}, {
				Type : "Combo",
				Hidden : 0,
				Width : 40,
				Align : "Left",
				ColMerge : 1,
				SaveName : "t5_co_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 4
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 70,
				Align : "Left",
				ColMerge : 1,
				SaveName : "t5_div",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 9
			}, {
				Type : "Combo",
				Hidden : 0,
				Width : 75,
				Align : "Left",
				ColMerge : 1,
				SaveName : "t5_trsp_mod_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 7
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 60,
				Align : "Left",
				ColMerge : 1,
				SaveName : "t5_lane",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 3
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 80,
				Align : "Center",
				ColMerge : 1,
				SaveName : "t5_vvd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 9
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 70,
				Align : "Center",
				ColMerge : 0,
				SaveName : "t5_fm_yd_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 7
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 70,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t5_fm_etd_dt",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 8
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 70,
				Align : "Center",
				ColMerge : 0,
				SaveName : "t5_to_yd_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 7
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 70,
				Align : "Left",
				ColMerge : 0,
				SaveName : "t5_to_eta_dt",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 8
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 1,
				SaveName : "t5_lsr",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 5
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 40,
				Align : "Center",
				ColMerge : 1,
				SaveName : "t5_so_iss_flg",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 1
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 60,
				Align : "Center",
				ColMerge : 1,
				SaveName : "t5_mty_flg",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 1
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 120,
				Align : "Left",
				ColMerge : 1,
				SaveName : "t5_ref_id",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 15
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 100,
				Align : "Left",
				ColMerge : 1,
				SaveName : "",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 15
			}, {
				Type : "Combo",
				Hidden : 1,
				Width : 80,
				Align : "Left",
				ColMerge : 1,
				SaveName : "t5_eq_repo_purp_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 3
			}, {
				Type : "Combo",
				Hidden : 0,
				Width : 90,
				Align : "Left",
				ColMerge : 1,
				SaveName : "t5_reason",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 2
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 150,
				Align : "Left",
				ColMerge : 1,
				SaveName : "t5_reasonrmk",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			}, {
				Type : "Int",
				Hidden : 0,
				Width : 70,
				Align : "Right",
				ColMerge : 1,
				SaveName : "t5_totalvol",
				KeyField : 0,
				CalcLogic : "",
				Format : "Integer",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 11
			} ];
			for ( var i = 0; i < consTpszArr.length; i++) {
				cols.push({
					Type : "Int",
					Hidden : 0,
					Width : 60,
					Align : "Right",
					ColMerge : 0,
					SaveName : "t5_vol" + consTpszArr[i],
					KeyField : 0,
					CalcLogic : "",
					Format : "Integer",
					PointCount : 0,
					UpdateEdit : 0,
					InsertEdit : 0,
					EditLen : 9
				});
			}
			/*cols.push({
				Type : "Float",
				Hidden : 1,
				Width : 90,
				Align : "Right",
				ColMerge : 1,
				SaveName : "t5_totalcost",
				KeyField : 0,
				CalcLogic : "",
				Format : "Float",
				PointCount : 2,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 13
			});
			for ( var i = 0; i < consTpszArr.length; i++) {
				cols.push({
					Type : "Float",
					Hidden : 1,
					Width : 80,
					Align : "Right",
					ColMerge : 0,
					SaveName : "t5_cost" + consTpszArr[i],
					KeyField : 0,
					CalcLogic : "",
					Format : "Float",
					PointCount : 2,
					UpdateEdit : 0,
					InsertEdit : 0,
					EditLen : 13
				});
			}*/
			for ( var i = 5; i < 52; i++) {
				GetCellBackColor(1, i, "#555555");// = GetCellBackColor(1,4);
			}

			InitColumns(cols);

			SetEditable(1);
			SetImageList(0, "/opuscntr/img/button/btns_cntrinput.gif");
			SetImageList(1, "/opuscntr/img/button/btns_cntrinput_c.gif");
			SetImageList(0, "/opuscntr/img/button/btns_cntrinput.gif");
			SetCellBackColor(1, 4, "#555555");
			SetCellBackColor(1, i, GetCellBackColor(1, 4));
			SetHeaderRowHeight(10);
			SetColHidden("t5_reason", 1);
			// SetSheetHeight(ComGetSheetHeight(sheetObj, 14));
			// ComResizeSheet(sheetObj);
			SetColProperty("t5_trsp_mod_cd", {
				ComboText : itemText,
				ComboCode : itemCode
			});
			SetColProperty("t5_co_cd", {
				ComboText : companyText,
				ComboCode : companyCode
			});
			SetColProperty("t5_eq_repo_purp_cd", {
				ComboText : purposeText,
				ComboCode : purposeCode
			});
			SetRangeBackColor(1, 2, 1, 36, "#777777");
		}
		break;
	}
}
function resizeSheet() {
	for ( var x = 0; x < sheetObjects.length; x++)
		ComResizeSheet(sheetObjects[x]);
}
/**
 * initializing Tab setting Tab items
 */
function initCombo(comboObj, comboNo) {
	var cnt = 0;
	switch (comboNo) {
	// Reason
	// case 1:
	// with (comboObj) {
	//
	// DropHeight = 9 * 20;
	//
	// var menuname = reasonText.split('|');
	// var menucode = reasonCode.split('|');
	//
	// MultiSelect = true;
	// MaxSelect = menuname.length;
	// Multiseparator = ",";
	//
	// for(i=0; i<menuname.length; i++) {
	// InsertItem(cnt++, menuname[i], menucode[i]);
	// }
	// }
	// break;
	// Item
	case 1:
		with (comboObj) {
			SetDropHeight(8 * 20);
			var menuname = itemText.split('|');
			var menucode = itemCode.split('|');
			SetMultiSelect(1);
			SetMaxSelect(menuname.length);
			Multiseparator = ",";
			for (i = 0; i < menuname.length; i++) {
				InsertItem(cnt++, menuname[i], menucode[i]);
			}
		}
		break;
	// Type Size
	case 2:
		with (comboObj) {
			SetDropHeight(12 * 20);
			var menuname = tpszallText.split('|');
			var menucode = tpszallCode.split('|');
			SetMultiSelect(1);
			SetMaxSelect(menuname.length);
			Multiseparator = ",";
			for (i = 0; i < menuname.length; i++) {
				InsertItem(cnt++, menuname[i], menucode[i]);
			}
		}
		break;
	}
}
// handling process for Sheet
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: // retrieve

		if (validateForm(sheetObj, formObj, sAction, 1)) {
			document.form.dataselect[0].checked = true;
			ComOpenWait(true);
			sheetObj.SetWaitImageVisible();
			setTimeout(function() {
				t1sheet1.SetVisible(0);
				t1sheet1.RemoveAll();
				sheetObjects[0] = t1sheet1.Reset();// keyfied reset
				ComConfigSheet(t1sheet1);
				initSheet(t1sheet1, 1, comboObjects[1].GetSelectText());
				t1sheet1.SetWaitImageVisible(1);
				formObj.f_cmd.value = SEARCHLIST;
				var sXml = t1sheet1.GetSearchData("EES_EQR_0059GS.do",
						eqrFormQryStr(formObj));
				t1sheet1.LoadSearchData(sXml, {
					Sync : 1
				});
				t1sheet1_ChangeXml(sXml);
				// formObj.t1_plnWeek.value=sheetObj.GetEtcData("t1_plnWeek");
				// formObj.t1_plnNextWeek.value=sheetObj.GetEtcData("t1_plnNextWeek");
				t1sheet1.SetVisible(1);
				t1sheet1.SetExtendLastCol(0);
				formObj.pre_repo_rmk.value = formObj.repo_rmk.value;

			}, 100);
		}
		break;
	case IBSAVE: // saving
		var sRow = sheetObj.FindStatusRow("I");
		var arRow = sRow.split(";");
		var split_count = 0;
		if (sRow != "" && sRow != null) {
			// for(var i=0; i<arRow.length-1; i++) {
			for ( var i = 0; i < arRow.length; i++) {
				if (sheetObj.GetCellValue(arRow[i], "t1_split_repo_pln_flg") == "Y") {
					split_count++;
				}
			}
		}
		// in case of VD ADD ROW existing, cancel
		if (split_count > 0) {
			ComShowCodeMessage("EQR90161", "Save");
			return false;
		}
		if (validateForm(sheetObj, formObj, sAction, 1)) {
			/*var sIURow = sheetObj.FindStatusRow("I|U");
			if (sIURow != "" && sIURow != null) {
				//중복체크 VVD, Yard
				var lastNum = 0;
				for ( var i = 2; i < sheetObj.RowCount(); i++) {
					if(sheetObj.GetCellValue(i, "t1_fm_yd_cd") == "" && sheetObj.GetRowStatus(i) !="D") {
						lastNum = lastNum+1;
					}
				}
				
				var chkDup = sheetObj.ColValueDupRows("t1_vvd|t1_fm_yd_cd|t1_to_yd_cd",1,0,1,sheetObj.RowCount()-lastNum);
				var strRepoId = "REPO"+formObj.yyyyww.value+"W"+formObj.seq.value;
				if(chkDup > 0) {
					ComShowCodeMessage("EQR01153", strRepoId);
					return false;
				}
			}
			*/
			
			var sRow = sheetObj.FindStatusRow("I|U|D");
			var arRow = sRow.split(";");
			var flag = true;
			if (sRow != "" && sRow != null) {
				// for(var i=0; i<arRow.length-1; i++) {
				for ( var i = 0; i < arRow.length; i++) {
					// in case of EXECUTE VOL=0 && PLAN VOL!=0, pass=F &
					// background color = red
					for ( var j = 0; j < consTpszArr.length; j++) {
						if (sheetObj.GetCellValue(arRow[i], "t1_vol"
								+ consTpszArr[j]) == '0') {
							// retrieving for plan row
							var week = sheetObj.GetCellValue(arRow[i],
									"t1_pln_yrwk");
							var item = sheetObj.GetCellValue(arRow[i],
									"t1_trsp_mod_cd");
							var fm_ecc = sheetObj.GetCellValue(arRow[i],
									"t1_fm_ecc");
							var to_ecc = sheetObj.GetCellValue(arRow[i],
									"t1_to_ecc");
							var planVol = 0;
							var planRow = 0;
							for ( var k = 0; k < sheetObj.RowCount(); k++) {
								if (sheetObj.GetCellValue(k, "t1_sortnum") == 1
										&& sheetObj.GetCellValue(k, "t1_num") == 1
										&& sheetObj.GetCellValue(k,
												"t1_pln_yrwk") == week
										&& sheetObj.GetCellValue(k,
												"t1_trsp_mod_cd") == item
										&& sheetObj
												.GetCellValue(k, "t1_fm_ecc") == fm_ecc
										&& sheetObj
												.GetCellValue(k, "t1_to_ecc") == to_ecc) {
									planRow = k;
									break;
								}
							}
							if (planRow != 0) {
								planVol = eval(sheetObj.GetCellValue(planRow,
										"t1_vol" + consTpszArr[j]));
								if (planVol > 0) {
									//sheetObj.SetCellValue(arRow[i], "t1_pass"+ consTpszArr[j], 'F', 0);
									// sheetObj.SetCellFontColor(arRow[i],"t1_vol"+consTpszArr[j],"#F1541F");
								}
							}
						}
					}
					// --------- cheking each flag, final flag
					var passCount = 0;
					/*
					for ( var z = 0; z < consTpszArr.length; z++) {
						if (sheetObj.GetCellValue(arRow[i], "t1_pass"+ consTpszArr[z]) == 'F') {
							passCount++;
							break;
						}
					}
                    */
					if (passCount > 0) {
						sheetObj.SetCellValue(arRow[i], "t1_pass_final", 'F', 0);
					} else {
						sheetObj.SetCellValue(arRow[i], "t1_pass_final", '', 0);
					}
				}
			}
			 
			var strtolen = "";
			var strtoCd = "";
			for(var i=2;i<=sheetObj.RowCount()+1;i++) {
				
				strtoCd = sheetObj.GetCellValue(i,"t1_to_yd_cd");
				strtolen = strtoCd.length;
				if(strtolen == 10) {
					sheetObj.InitCellProperty(i,"t1_to_yd_cd",{ Type:"Text"});
					sheetObj.SetCellValue(i,"t1_to_yd_cd","",0);
					sheetObj.SetCellValue(i,"t1_to_yd_cd",strtoCd.substring(3,10),0);
				}
			}     
            	
			
			if (flag) {
				if (sRow != "" && sRow != null) {
					var formObj = document.form; 
		        	var f_cmd =SEARCHLIST02;
		        	var saveStr = sheetObj.GetSaveString();
					if (saveStr == "")
						return;
					
		        	var sXml= sheetObj.GetSearchData("EES_EQR_0080GS.do",saveStr+"&f_cmd=" + f_cmd);
		        	var strDataYN=ComGetEtcData(sXml, "dataYN");
		        	if(strDataYN != "") {
		        		ComShowCodeMessage("EQR01153", strDataYN);
		        		return false;
		        	}
		        	
		        	
					formObj.f_cmd.value = MULTI;
					// sheetObj.DoSave("EES_EQR_0059GS.do",
					// eqrFormQryStr(formObj));
					var saveStr = sheetObj.GetSaveString();
					if (saveStr == "")
						return;
					var sXml = sheetObj.GetSaveData("EES_EQR_0059GS.do",
							saveStr, eqrFormQryStr(formObj));
					sheetObj.LoadSaveData(sXml, {
						Sync : 1
					});
					t1sheet1_ChangeXml(sXml);
				}

				if (formObj.pre_repo_rmk.value != formObj.repo_rmk.value) {
					ComShowConfirm(ComGetMsg("EQR90236"));
					formObj.f_cmd.value = MULTI03;
					ComOpenWait(true);
					var sXml = sheetObj.GetSaveData("EES_EQR_0012GS.do",
							eqrFormQryStr(formObj));
					ComOpenWait(false);
					sheetObj.LoadSaveData(sXml, {
						Sync : 1
					});
					formObj.pre_repo_rmk.value = formObj.repo_rmk.value;
					ComEtcDataToForm(document.form, sheetObj);
					// document.form.checksave.value ="Y";
					// ComShowMessage(ComGetMsg("EQR90106")); //
				}
			}
		}
		break;
	case IBSEARCH_ASYNC03: //
		sheetObj.SetWaitImageVisible(0);
		formObj.f_cmd.value = MULTI02;
		formObj.pre_repo_rmk.value = formObj.repo_rmk.value;
		sheetObj.DoSearch("EES_EQR_0012GS6.do", eqrFormQryStr(formObj));
		goSearchRepoid();
		break;

	case IBINSERT:
		if (sheetObj.RowCount() > 0) {
			var selRow = sheetObj.GetSelectRow(); // selected ROW
			var sourceWeek = sheetObj.GetCellValue(selRow, 't1_pln_yrwk');
			var repoPlnWeek = formObj.t1_plnWeek.value;
			var repoPlnNextWeek = formObj.t1_plnNextWeek.value;
			// in case of Plan(except old plan), REPO BKG, normal Row, copy
			// available
			// except FIXED, SPLIT
			if ((sheetObj.GetCellValue(selRow, 't1_sortnum') == 1 || sheetObj
					.GetCellValue(selRow, 't1_sortnum') == 2)
					&& sheetObj.GetCellValue(selRow, 't1_num') == 1
					&& sheetObj.GetCellValue(selRow, 't1_past_repo_pln_flg') != 'Y'
					&& sheetObj.GetCellValue(selRow, 't1_split_repo_pln_flg') != 'Y') {
				// in case of repo plan id, +1,+2 week, executable
				if (sourceWeek == repoPlnWeek || sourceWeek == repoPlnNextWeek) {
					// checking user athority
					if (!userAreaCheck(sheetObj, "VL Add", "from", 1, selRow)) {
						// return false;
					}
					// in case of TPSZ = ALL, VL addable
					if (consTpszArr.length < allTpszCnt) {
						ComShowCodeMessage("EQR90045", "VL Add", "ALL");
						return false;
					}

					if ((sheetObj.GetCellValue(selRow, 't1_fm_chk_flg') != "Y")) {
						// ComShowCodeMessage("EQR90244",sheetObj.GetCellValue(selRow,
						// 't1_fm_yd_cd'));
						// return false;
					}

					// var Row=sheetObj.DataInsert(selRow);
					var Row = sheetObj.DataInsert();
					sheetObj.SetRowBackColor(Row, "#F7FB59");
					sheetObj.SetCellValue(Row, 't1_pln_yrwk', sheetObj
							.GetCellValue(selRow, 't1_pln_yrwk'), 0);// week
																		// copying
					sheetObj.SetCellValue(Row, 't1_div', "REPO BKG", 0);// REPO
																		// BKG
																		// setting
					sheetObj.SetCellValue(Row, 't1_repo_pln_id', sheetObj
							.GetCellValue(selRow, 't1_repo_pln_id'), 0);// repo_plan_id
																		// copying
					sheetObj.SetCellValue(Row, "t1_vsl_lane_cd", sheetObj
							.GetCellValue(selRow, "t1_vsl_lane_cd"), 0);// lane
																		// copy
					sheetObj.SetCellValue(Row, "t1_vvd", sheetObj.GetCellValue(
							selRow, "t1_vvd"), 0);// vvd copy
					sheetObj.SetCellValue(Row, "t1_fm_yd_cd", sheetObj
							.GetCellValue(selRow, "t1_fm_ecc"), 0);// from loc
																	// copying
					sheetObj.SetCellValue(Row, "t1_to_yd_cd", sheetObj
							.GetCellValue(selRow, "t1_to_ecc"), 0);// to loc
																	// copying
					sheetObj.SetCellValue(Row, "t1_fm_etd_dt", sheetObj
							.GetCellValue(selRow, "t1_fm_etd_dt"), 0);// from
																		// etd
																		// copying
					sheetObj.SetCellValue(Row, "t1_to_eta_dt", sheetObj
							.GetCellValue(selRow, "t1_to_eta_dt"), 0);// to
																		// eta
																		// copying
					sheetObj.SetCellValue(Row, 't1_trsp_mod_cd', sheetObj
							.GetCellValue(selRow, 't1_trsp_mod_cd'), 0);// item
																		// copying
					sheetObj.SetCellValue(Row, 't1_eq_repo_purp_cd', "", 0);// Purpose
																			// resetting
					sheetObj.SetCellValue(Row, 't1_repo_pln_fb_rsn_cd', "", 0);// Reason
																				// resetting
					//sheetObj.SetCellEditable(Row, 't1_fm_yd_cd', 0);
					sheetObj.SetCellEditable(Row, 't1_repo_pln_fb_rmk', 0);// Reason
																			// Remark
																			// modifying
																			// disable
					sheetObj.SetCellEditable(Row, 't1_mty_bkg_no', 0);// BKG
																		// NO
																		// modifying
																		// disable
					sheetObj.SetCellValue(Row, "t1_cntrimage", "1", 0);// cntr
																		// image
																		// initializing
					// sheetObj.SetCellValue(Row, "t1_sortnum")="2"; // REPO BKG
					// Rowsetting
					sheetObj.SetCellValue(Row, "t1_sortnum", "2", 0);// REPO
																		// BKG
																		// Rowsetting
					sheetObj.SetCellValue(Row, "t1_num", "1", 0);// normal
																	// rowsetting
					sheetObj.SetCellValue(Row, "t1_fm_rcc", sheetObj
							.GetCellValue(selRow, "t1_fm_rcc"), 0);// t1_fm_rcc
																	// copying
					sheetObj.SetCellValue(Row, "t1_to_rcc", sheetObj
							.GetCellValue(selRow, "t1_to_rcc"), 0);// t1_to_rcc
																	// copying
					sheetObj.SetCellValue(Row, "t1_fm_lcc", sheetObj
							.GetCellValue(selRow, "t1_fm_lcc"), 0);// t1_fm_lcc
																	// copying
					sheetObj.SetCellValue(Row, "t1_to_lcc", sheetObj
							.GetCellValue(selRow, "t1_to_lcc"), 0);// t1_to_lcc
																	// copying
					sheetObj.SetCellValue(Row, "t1_fm_ecc", sheetObj
							.GetCellValue(selRow, "t1_fm_ecc"), 0);// fm ecc
																	// copying
					sheetObj.SetCellValue(Row, "t1_to_ecc", sheetObj
							.GetCellValue(selRow, "t1_to_ecc"), 0);// to ecc
																	// copying
					sheetObj.SetCellValue(Row, "t1_split_repo_pln_flg", "N", 0);
					// t1_past_repo_pln_flg copying
					sheetObj.SetCellValue(Row, "t1_past_repo_pln_flg", sheetObj
							.GetCellValue(selRow, "t1_past_repo_pln_flg"), 0);
					// copying pln_seq of selected plan
					sheetObj.SetCellValue(Row, "t1_pln_seq", sheetObj
							.GetCellValue(selRow, "t1_pln_seq"), 0);

					// modifying disable
					sheetObj.SetCellEditable(Row, 't1_mailfax', 0);// MAIL FAX
																	// modifying
																	// disable
					// Add By 2010.02.01 disable 컬럼 추가
					sheetObj.SetCellEditable(Row, 't1_vsl_lane_cd', 0);// LANE
																		// modifying
																		// disable
					sheetObj.SetCellEditable(Row, 't1_vvd', 0);// VVD modifying
																// disable
					// ------ FM LOC YARD retreive [START] -----------
					var f_cmd = SEARCH01;
					var vsl = sheetObj.GetCellValue(selRow, "t1_vvd");
					var from_ecc = sheetObj.GetCellValue(selRow, "t1_fm_ecc");
					// sheetObj.DoRowSearch(
					// ROW,row=Row&colname=t1_fm_yd_cd&vsl=vsl&ecc=from_ecc&item=V&f_cmd=f_cmd"&false"
					// );
					// sheetObj.DoRowSearch2("EES_LOCYARDINITIAL_COMMON.do"
					// ,"row="+Row+"&colname=t1_fm_yd_cd&vsl="+vsl+"&ecc="+from_ecc+"&item=V&f_cmd="+f_cmd);
					var sXml = sheetObj.GetSearchData(
							"EES_LOCYARDINITIAL_COMMON.do", "row=" + Row
									+ "&colname=t1_fm_yd_cd&vsl=" + vsl
									+ "&ecc=" + from_ecc + "&item=V&f_cmd="
									+ f_cmd);
					changeViewCombo(sheetObj, sXml);

					// ------ FM LOC YARD retreive [END] -----------
					
					
					
					
					// ------ TO LOC YARD retreive [START] -----------
					// SEARCH01 ==> SEARCH17 Change
					var f_cmd = SEARCH17;
					var vsl = sheetObj.GetCellValue(selRow, "t1_vvd");
					var to_ecc = sheetObj.GetCellValue(selRow, "t1_fm_yd_cd");
					sheetObj.InitCellProperty(Row, "t1_to_yd_cd", {
						Type : "Combo"
					});
					
					sheetObj.DoRowSearch2("EES_LOCYARDINITIAL_COMMON.do",
							"row=" + Row + "&colname=t1_to_yd_cd&vsl=" + vsl
									+ "&ecc=" + to_ecc + "&item=V&f_cmd="
									+ f_cmd);
					sheetObj.SetCellValue(Row, "t1_to_yd_cd", sheetObj.GetCellValue(selRow, "t1_to_yd_cd"),0);
					
					if (sheetObj.GetCellValue(Row, "t1_to_yd_cd") == "") {
						var strI = sheetObj.GetCellValue(selRow,"t1_to_yd_cd").replace(/\s/gi, ''); 
						var strcomboInfo = sheetObj.GetComboInfo(Row, "t1_to_yd_cd","Code");
						var strcomboTextInfo = sheetObj.GetComboInfo(Row, "t1_to_yd_cd","Text");
						var comboInfoarr = strcomboInfo.split("|");
						var comboInfoTextarr = strcomboTextInfo.split("|");
						if(comboInfoarr.length > -1) {
							for(var k=0;k<comboInfoarr.length;k++) {
								var strLoc = comboInfoarr[k];
								//if(strLoc.indexOf(strI) > -1) {
									sheetObj.SetCellValue(Row, "t1_to_yd_cd", comboInfoarr[0],0);
									var etaDt = comboInfoTextarr[0].split("\t");
									sheetObj.SetCellValue(Row, "t1_to_eta_dt", etaDt[1],0);
									/*var strIndex = sheetObj.GetComboInfo(Row,"t1_to_yd_cd", "SelectedIndex");
									var strLoc = comboInfoTextarr[strIndex].split("\t");
									sheetObj.SetCellValue(Row, "t1_to_eta_dt", strLoc[1],0);*/
									break;
								//}
							}
						}
					}
					
					
					// Loc 값 확인하여 값이 없으면 디폴트로 Loc값 넣기위해 아래조건 실행시킨다.
					// t1_to_yd_cd 값이 하나인경우 아래로직 처리
					if (sheetObj.GetCellValue(Row, "t1_to_yd_cd") == "") {
						var f_cmd = SEARCH17;
						//var f_cmd = SEARCH01;
						var vsl = sheetObj.GetCellValue(selRow, "t1_vvd");
						//var to_ecc = sheetObj.GetCellValue(selRow, "t1_to_ecc");
						var to_ecc = sheetObj.GetCellValue(selRow, "t1_fm_yd_cd");
						var sXml = sheetObj.GetSearchData(
								"EES_LOCYARDINITIAL_COMMON.do", "row=" + Row
										+ "&colname=t1_to_yd_cd&vsl=" + vsl
										+ "&ecc=" + to_ecc + "&item=V&f_cmd="
										+ f_cmd);
						//changeViewCombo(sheetObj, sXml);
						//************* Notice ************************
						//Park Young Jin 2015 05 20 데이타가 하나인경우 viewdata에서 Type이 dtData로 변환되므로 콤보에서는 데이타가 출력이 안된다.
						//그러므로 t1_to_yd_cd값이 없을경우 Type을 TEXT로 변경 후 changeViewCombo로 데이타 가져와야한다. 
						//그런데 t1_to_yd_cd 셀이 click할 경우 Click 이벤트에서 type이 TEXT이면 콥보로 변경하는 if 문이 있으므로 
						//if문이 진행되지 않도록 TEXT를 콤보로 다시 변경한후 설정해준다.
						if(sheetObj.GetCellValue(Row, "t1_to_yd_cd") == "") {
							//Loc가 하나 인 경우
							sheetObj.InitCellProperty(Row, "t1_to_yd_cd", {Type : "Text"});
							changeViewCombo(sheetObj, sXml);
							var CellPro = sheetObj.GetCellProperty(Row, "t1_to_yd_cd", "Type");
							if(CellPro == "Text") {
								var strT1ToYdCd = sheetObj.GetCellValue(Row, "t1_to_yd_cd");
								var strT1ToYdText = sheetObj.GetCellValue(Row, "t1_to_yd_cd");
								sheetObj.InitCellProperty(Row, "t1_to_yd_cd", {Type : "Combo", ComboCode:strT1ToYdCd, ComboText:strT1ToYdText});
							}else{
								
							}
						}else{
							
						}
					}
					// ------ TO LOC YARD retreive [END] -----------
					// insert row
					var strPlan = sheetObj.GetCellValue(selRow,"t1_to_yd_cd");
					var strChkCellType = sheetObj.GetCellProperty(Row, "t1_to_yd_cd", "Type");
					if(strChkCellType == "Combo") {
						var strcomboInfo = sheetObj.GetComboInfo(Row, "t1_to_yd_cd","Code");
						var strcomboTextInfo = sheetObj.GetComboInfo(Row, "t1_to_yd_cd","Text");
						var comboInfoarr = strcomboInfo.split("|");
						var comboInfoTextarr = strcomboTextInfo.split("|");
						var chkLocYN = false;
						if(comboInfoarr.length > -1) {
							for(var k=0;k<comboInfoarr.length;k++) {
								var strLoc = comboInfoarr[k];
								if(comboInfoarr[k].indexOf(strPlan) > -1) {
									sheetObj.SetCellValue(Row,"t1_to_yd_cd",comboInfoarr[k]);
									//var etaDt = comboInfoTextarr[k].split("\t");
									//sheetObj.SetCellValue(Row, "t1_to_eta_dt", etaDt[1],0);
									chkLocYN = true
									break;
								}
							}
						}
						
						if(chkLocYN == false) {
							sheetObj.SelectCell(Row,"t1_to_yd_cd",true);
						}
					}
					document.form.position_row1.value = Row;
				} else {
					ComShowCodeMessage("EQR90151", "VL Add", repoPlnWeek,
							repoPlnNextWeek);
				}
			} else {
				ComShowCodeMessage("EQR90040");
			}
		}
		break;
	case IBSEARCH_ASYNC04:
		sheetObjects[0].SetWaitImageVisible(2);
        ComOpenWait(true);
        
    	formObj.f_cmd.value=SEARCH18;
        var sXml=sheetObjects[0].GetSearchData("EES_REPO_COMMONGS.do" , FormQueryString(formObj));        
        var strDataYN		=	ComGetEtcData(sXml, "DataYN");
        //Search01
        var strScnrId01		=	"";
        var strRepoRmk01	=	"";
        var strType01			=	"";
        var strRepoPlnId01	=	"";
        var strDtrbFlg01		=	"";
        var strReplPlnYn01	=	"";     
        //Search02
        var strStYear02		=	"";
        var strStWeekly02	=	"";
        var strStMonth02		=	"";
        var strEndYear02		=	"";
        var strEndWeekly02	=	"";
        var strEndMonth02		=	"";      
        //Search03
        var strPerFixMonth03	=	"";
        var strTitleMonth03		=	"";    
        //Search04
        var strPerFixWeekly04	=	"";
        var strTitleWeekly04		=	"";
        var strPerFixMonthly04	=	"";    
        //Search05
        var strMonthlyCount05	=	"";  
        //Search06
        var strMaxPlyYr06	=	"";
        var strMaxWeekly06	=	"";
        var strMaxPlnMon06	=	"";     
        //Search07
        var strFromToPlnId07	=	"";                        
        //Search08
        var strScnrIdList08		=	"";
        var strReplPlnIdList08	=	"";    
        //Search09
        var strTodayWeekly09	=	"";  
        //Searhc10
        var strExePlnEditFlg10	=	"";                    
        //Search11
        var strMaxWkStr11		= "";                    
        //Search12
        var strRepoPlnNextWeek12	=	"";                    
        //Search13
        var strExePlnEditFlgSplit13	=	"";	                    
        var max_plnYrWk = strMaxPlyYr06 + strMaxWeekly06; 
        
        if(strDataYN == "Y") {
            //Search01
            strScnrId01		=	ComGetEtcData(sXml, "scnr_id");
            strRepoRmk01	=	ComGetEtcData(sXml, "repo_rmk");
            strType01			=	ComGetEtcData(sXml, "type");
            strRepoPlnId01	=	ComGetEtcData(sXml, "repo_pln_id");
            strDtrbFlg01		=	ComGetEtcData(sXml, "dtrb_flg");
            strReplPlnYn01	=	ComGetEtcData(sXml, "replPlnYn");     
            //Search02
            strStYear02		=	ComGetEtcData(sXml, "st_year");
            strStWeekly02	=	ComGetEtcData(sXml, "st_weekly");
            strStMonth02		=	ComGetEtcData(sXml, "st_month");
            strEndYear02		=	ComGetEtcData(sXml, "end_year");
            strEndWeekly02	=	ComGetEtcData(sXml, "end_weekly");
            strEndMonth02		=	ComGetEtcData(sXml, "end_month");      
            //Search03
            strPerFixMonth03	=	ComGetEtcData(sXml, "perfix_month");
            strTitleMonth03		=	ComGetEtcData(sXml, "title_month");    
            //Search04
            strPerFixWeekly04	=	ComGetEtcData(sXml, "perfix_weekly");
            strTitleWeekly04		=	ComGetEtcData(sXml, "title_weekly");
            strPerFixMonthly04	=	ComGetEtcData(sXml, "perfix_monthly");    
            //Search05
            strMonthlyCount05	=	ComGetEtcData(sXml, "monthly_count");  
            //Search06
            strMaxPlyYr06	=	ComGetEtcData(sXml, "max_plnYr");
            strMaxWeekly06	=	ComGetEtcData(sXml, "max_weekly");
            strMaxPlnMon06	=	ComGetEtcData(sXml, "max_plnMon");     
            //Search07
            strFromToPlnId07	=	ComGetEtcData(sXml, "fromToPlnId");                        
            //Search08
            strScnrIdList08		=	ComGetEtcData(sXml, "scnrIdList");
            strReplPlnIdList08	=	ComGetEtcData(sXml, "repoPlnIdList");    
            //Search09
            strTodayWeekly09	=	ComGetEtcData(sXml, "todayWeekly");  
            //Searhc10
            strExePlnEditFlg10	=	ComGetEtcData(sXml, "exePlnEditFlg");                    
            //Search11
            strMaxWkStr11		=ComGetEtcData(sXml, "maxWkStr");                    
            //Search12
            strRepoPlnNextWeek12	=	ComGetEtcData(sXml, "repoPlnNextWeek");                    
            //Search13
            strExePlnEditFlgSplit13	=	ComGetEtcData(sXml, "exePlnEditFlg_split");	                    
            max_plnYrWk = strMaxPlyYr06 + strMaxWeekly06; 
        }
        
        	formObj.scnr_id.value = strScnrId01;
			formObj.repo_rmk.value = strRepoRmk01;
			formObj.repo_rmk.title = strRepoRmk01;
			formObj.st_year.value = strStYear02;
			formObj.st_month.value = strStMonth02;
			formObj.st_weekly.value = strStWeekly02;
			formObj.end_year.value =	strEndYear02;
			formObj.end_month.value = strEndMonth02;
			formObj.end_weekly.value = strEndWeekly02;
			formObj.perfix_month.value = strPerFixMonth03;
			formObj.title_month.value = strTitleMonth03;
			formObj.perfix_weekly.value =strPerFixWeekly04;
			formObj.title_weekly.value = strTitleWeekly04;
			formObj.monthly_count.value = strMonthlyCount05;
			formObj.status_type.value = strType01;
			formObj.dtrb_flg.value = strDtrbFlg01;
			formObj.max_weekly.value = strMaxWeekly06;
			formObj.fromToPlnId.value = strFromToPlnId07;
			formObj.max_plnYrWk.value = max_plnYrWk;
			if(formObj.scnrIdList != null )  	formObj.scnrIdList.value 	= strScnrIdList08;
			if(formObj.repoPlnIdList != null ) formObj.repoPlnIdList.value= strReplPlnIdList08;
			if(formObj.max_plnYr != null )  	formObj.max_plnYr.value 	= strMaxPlyYr06;
			if(formObj.max_plnMon != null )  	formObj.max_plnMon.value 	= strMaxPlnMon06;
			if(formObj.todayWeekly != null )  	formObj.todayWeekly.value 	= strTodayWeekly09;
			if(formObj.exePlnEditFlg != null ) formObj.exePlnEditFlg.value= strExePlnEditFlg10;
			if(formObj.exePlnEditFlg_split != null ) formObj.exePlnEditFlg_split.value= strExePlnEditFlgSplit13;
			if(formObj.repoPlnNextWeek != null ) formObj.repoPlnNextWeek.value = strRepoPlnNextWeek12;
			if(strReplPlnYn01 == "Y") {
				ComBtnDisable("btn_create");
				ComBtnDisable("btn_delete");
			}else{				
				ComBtnDisable("btn_create");
				ComBtnEnable("btn_delete");
			}
			
			formObj.maxWkStr.value = strMaxWkStr11;  
			ibSearchAsync03();
			sheetObjects[0].RemoveAll();
			setEccCommon();
			ComOpenWait(false);
    	break;
	case IBDELETE:
 	   if(ComShowConfirm(ComGetMsg("EQR90193"))) {
 		   if(!validateForm(sheetObj,formObj,sAction)){
                return false;
             }
 		   
     	   formObj.f_cmd.value=MULTI04;
     	   var sXml= sheetObj.GetSaveData("EES_EQR_0012GS.do", FormQueryString(formObj));
     	   var strDelYn=ComGetEtcData(sXml, "delYN");
            if (strDelYn == "Y" || strDelYn == "E") {
         	   if(strDelYn == "E") {
        		   ComShowCodeMessage("EQR01150");
        	   }
         	   formObj.yyyyww.value = "";
         	   formObj.seq.value = "";
         	   formObj.repo_rmk.value = "";
         	  	              
			// FM/TO LOC
				document.all.fmToLayer.style.display = "inline";
				document.all.atLayer.style.display = "none";

				ComBtnDisable("btn_create");
	            ComBtnDisable("btn_delete");
	            
	            formObj.reset();
				tpszChange(''); // ALL 선택
				// Retieving Repo.PlanID
				// goSearchRepoid();
				formObj.yyyyww.value = "";
				formObj.seq.value = "";
				formObj.repo_rmk.value = "";
				// tpsz initializing
				comboObjects[1].SetSelectCode(consTpsz);

				// Item initializing
				comboObjects[0].RemoveAll();
				initCombo(comboObjects[0], 2);
				t1sheet1.RemoveAll();
				t2sheet1.RemoveAll();
				t3sheet1.RemoveAll();
				t4sheet1.RemoveAll();
				t5sheet1.RemoveAll();
				
				ComShowCodeMessage("EQR01151");
       	   }else{
        	   ComShowCodeMessage("EQR01150");
          	   doActionIBSheet(sheetObj,formObj,IBSEARCH);
          	   ComBtnDisable("btn_create");
			   ComBtnDisable("btn_delete");
           }
 	   }
 	   break;
	case IBDOWNEXCEL:
		sheetObj.Down2Excel({
			DownCols : makeHiddenSkipCol(sheetObj),
			SheetDesign : 1,
			Merge : 1
		});
		break;
	}
}
function doActionIBSheet_1(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSAVE:
		if (consTpszArr.length < allTpszCnt) {
			ComShowCodeMessage("EQR90045", "Repo BKG", "ALL");
			return false;
		}
		// ------------------------ START
		var sRow = sheetObj.FindStatusRow("I");
		var arRow = sRow.split(";");
		var split_count = 0;
		if (sRow != "" && sRow != null) {
			// for(var i=0; i<arRow.length-1; i++) {
			for ( var i = 0; i < arRow.length; i++) {
				if (sheetObj.GetCellValue(arRow[i], "t1_split_repo_pln_flg") == "Y") {
					split_count++;
				}
			}
		}
		// in case of VD ADD ROW existing, cancel
		if (split_count > 0) {
			ComShowCodeMessage("EQR90161", "Repo BKG Cre.");
			return false;
		}
		// --------------------- END
		// checking repo bkg checked(one or multi)
		var sRow = sheetObj.FindStatusRow("U");
		var arRow = sRow.split(";");
		var repobkg_count = 0;
		var selRow = 0;
		if (sRow != "" && sRow != null) {
			// for(var i=0; i<arRow.length-1; i++) {
			for ( var i = 0; i < arRow.length; i++) {
				if (sheetObj.GetCellValue(arRow[i], "t1_repobkg_flag") == "T") {
					// update row
					document.form.position_row1.value = arRow[i];
					selRow = arRow[i];
					repobkg_count++;
				}
			}
		}

		if (repobkg_count == 1) {
			//var selRow = sheetObj.GetSelectRow(); // selected ROW
			
			var fmYdLoc = sheetObj.GetCellValue(selRow, 't1_fm_yd_cd');
			var toYdLoc = sheetObj.GetCellValue(selRow, 't1_to_yd_cd');
			var volTotal = sheetObj.GetCellValue(selRow, 't1_totalvol');
			var vCode = "";
			var vCodeNm = "";
			
			formObj.f_cmd.value=SEARCH01;
			var intgCdId='CD30101';
			var param="&intgCdId="+intgCdId;
			var xml=sheetObj.GetSearchData("EES_CIM_COMGS.do", FormQueryString(formObj)+param);
			
			if (xml != "") {
				var arrStrCode=ComGetEtcData(xml, "code_nm");
				var arrCode = arrStrCode.split("@");
				var strAllCode="";
				var arrAllCode="";
				for(var i=0;i<arrCode.length;i++) {						
					strAllCode = arrCode[i].split("@");
					for(var j=0;j<strAllCode.length;j++) {
						arrAllCode = strAllCode[j].split("|");
						strCode = arrAllCode[0];
						strCodeNm = arrAllCode[1];
						
						if(i == 0) {
							vCode =  strCode;
							vCodeNm =  strCodeNm; 
						}else{
							vCode = vCode + "|" + strCode; 
							vCodeNm = vCodeNm + "|" + strCodeNm; 
						}
					}
				}
			}
			var chkVolRtn = chkLocationVol(vCode,vCodeNm,fmYdLoc,toYdLoc,volTotal);
			if(chkVolRtn == false) {
				return false;
			}
			
			if ((sheetObj.GetCellValue(selRow, 't1_fm_chk_flg') != "Y")) {
				// ComShowCodeMessage("EQR90244",sheetObj.GetCellValue(selRow,
				// 't1_fm_yd_cd'));
				// return false;
			}
			
			if (ComShowConfirm(ComGetMsg("EQR90053"))) {
				if (validateForm(sheetObj, formObj, sAction, 1)) {
					for ( var i = 0; i < arRow.length; i++) {
						
						if (selRow != arRow[i]) {
							sheetObj.SetCellValue(arRow[i],"t1_ibflag","R");
						}
					}
					formObj.f_cmd.value = MULTI01;
					// sheetObj.DoSave("EES_EQR_0059GS.do",
					// eqrFormQryStr(formObj));
					var saveStr = sheetObj.GetSaveString();
					if (saveStr == "")
						return;
					var sXml = sheetObj.GetSaveData("EES_EQR_0059GS.do",
							saveStr, eqrFormQryStr(formObj));
					sheetObj.LoadSaveData(sXml, {
						Sync : 1
					});
					t1sheet1_ChangeXml(sXml);
				}
			}
		} else if (repobkg_count > 1) {
			ComShowCodeMessage("EQR90152", "Repo BKG Cre.");
		} else {
			ComShowCodeMessage("EQR90123");
		}
		break;
	}
}

function doActionIBSheet_2(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBINSERT:
		if (consTpszArr.length < allTpszCnt) {
			ComShowCodeMessage("EQR90045", "Repo BKG Split", "ALL");
			return false;
		}
		if (sheetObj.RowCount() > 0) {
			var selRow = sheetObj.GetSelectRow(); // selected ROW
			var sourceWeek = sheetObj.GetCellValue(selRow, 't1_pln_yrwk');
			var repoPlnWeek = formObj.t1_plnWeek.value;
			var repoPlnNextWeek = formObj.t1_plnNextWeek.value;
			var sRow = sheetObj.FindStatusRow("I");
			var arRow = sRow.split(";");
			var split_count = 0;

			var selDivValue = sheetObj.GetCellValue(selRow, 't1_div');
			if (selDivValue == "Plan") {
				ComShowCodeMessage("EQR01123");
				return false;
			}

			// 2014.10.14 Park Young Jin
			if ((sheetObj.GetCellValue(selRow, 't1_to_chk_flg') != "Y")) {
				// ComShowCodeMessage("EQR90245",sheetObj.GetCellValue(selRow,
				// 't1_to_yd_cd'));
				// return false;
			}

			if (sRow != "" && sRow != null) {
				// for(var i=0; i<arRow.length-1; i++) {
				for ( var i = 0; i < arRow.length; i++) {
					if (sheetObj
							.GetCellValue(arRow[i], "t1_split_repo_pln_flg") == "Y") {
						split_count++;
					}
				}
			}
			if (split_count > 0) {
				ComShowCodeMessage("EQR90152", "VD Add(Booking Split)");
				return false;
			}

			if (sheetObj.GetCellValue(selRow, 't1_sortnum') == 1
					&& sheetObj.GetCellValue(selRow, 't1_num') == 1 // &&
			// sheetObj.CellValue(selRow, 't1_past_repo_pln_flg')=='Y'
			) {
				// in case of repo plan id, +1,+2 week, executable
				if (sourceWeek == repoPlnWeek || sourceWeek == repoPlnNextWeek) {
					// checking user athority
					if (!userAreaCheck(sheetObj, "VD Add", "to", 1, selRow)) {
						// return false;
					}
					if (sheetObj.GetCellValue(selRow, 't1_past_repo_pln_flg') == 'Y') {
						if (sheetObj.GetCellValue(selRow, 't1_pln_yrwk') != sheetObj
								.GetCellValue(selRow, 't1_eta_week')
								&& sheetObj.GetCellValue(selRow,
										't1_pln_yrwk_next') != sheetObj
										.GetCellValue(selRow, 't1_eta_week')) {
							ComShowCodeMessage("EQR90168");
							return false;
						}
					}

					// 2014.10.14 Park Young Jin
					if ((sheetObj.GetCellValue(selRow, 't1_to_chk_flg') != "Y")) {
						// ComShowCodeMessage("EQR90245",sheetObj.GetCellValue(selRow,
						// 't1_to_yd_cd'));
						// return false;
					}

					// var Row=sheetObj.DataInsert(selRow);
					var Row = sheetObj.DataInsert();
					// color modifying
					sheetObj.SetRowBackColor(Row, "#D7D7D5");
					sheetObj.SetCellEditable(Row, 't1_fm_yd_cd', 0);
					sheetObj.SetCellBackColor(Row, 't1_to_yd_cd', sheetObj
							.GetDataBackColor());
					sheetObj.SetCellBackColor(Row, 't1_eq_repo_purp_cd',
							sheetObj.GetDataBackColor());
					sheetObj.SetCellBackColor(Row, 't1_repo_pln_fb_rsn_cd',
							sheetObj.GetDataBackColor());
					sheetObj.SetCellBackColor(Row, 't1_repo_pln_fb_rmk',
							sheetObj.GetDataBackColor());
					sheetObj.SetCellBackColor(Row, 't1_mty_bkg_no', sheetObj
							.GetDataBackColor());
					// modifying disable
					sheetObj.SetCellEditable(Row, 't1_mailfax', 0);// MAIL FAX
																	// modifying
																	// disable
					sheetObj.SetCellEditable(Row, 't1_co_cd', 0);// COMPANY
																	// modifying
																	// disable
					sheetObj.SetCellEditable(Row, 't1_vsl_lane_cd', 0);// LANE
																		// modifying
																		// disable
					sheetObj.SetCellEditable(Row, 't1_vvd', 0);// VVD modifying
																// disable
					sheetObj.SetCellEditable(Row, 't1_fm_yd_cd', 0);// FROM
																	// LOCATION
																	// modifying
																	// disable
					sheetObj.SetCellEditable(Row, 't1_repo_pln_fb_rmk', 0);// Reason
																			// Remark
																			// modifying
																			// disable
					for ( var i = 0; i < consTpszArr.length; i++) {
						sheetObj.SetCellEditable(Row,
								't1_vol' + consTpszArr[i], 0);// VOL modifying
																// disable
					}
					// copying data
					sheetObj.SetCellValue(Row, "t1_pln_yrwk", sheetObj
							.GetCellValue(selRow, "t1_pln_yrwk"), 0);// WEEK
																		// copying
					sheetObj.SetCellValue(Row, 't1_div', "REPO BKG", 0);// REPO
																		// BKG
																		// setting
					sheetObj.SetCellValue(Row, 't1_repo_pln_id', sheetObj
							.GetCellValue(selRow, 't1_repo_pln_id'), 0);// repo_plan_id
																		// copying
					sheetObj.SetCellValue(Row, "t1_co_cd", "", 0);// company
																	// initializing
					sheetObj.SetCellValue(Row, "t1_cntrimage", "1", 0);// cntr
																		// image
																		// initializing
					sheetObj.SetCellValue(Row, 't1_trsp_mod_cd', sheetObj
							.GetCellValue(selRow, 't1_trsp_mod_cd'), 0);// item
																		// copying
					sheetObj.SetCellValue(Row, "t1_vsl_lane_cd", sheetObj
							.GetCellValue(selRow, "t1_vsl_lane_cd"), 0);// lane
																		// copy
					sheetObj.SetCellValue(Row, "t1_vvd", sheetObj.GetCellValue(
							selRow, "t1_vvd"), 0);// vvd copy
					sheetObj.SetCellValue(Row, "t1_to_yd_cd", sheetObj
							.GetCellValue(selRow, "t1_to_ecc"), 0);// to loc
																	// copying
					sheetObj.SetCellValue(Row, "t1_to_eta_dt", sheetObj
							.GetCellValue(selRow, "t1_to_eta_dt"), 0);// to
																		// eta
																		// copying
					sheetObj.InitCellProperty(Row, 't1_repo_mty_bkg_flg', {
						Type : "CheckBox"
					});
					sheetObj.SetCellValue(Row, 't1_repo_mty_bkg_flg', '1', 0);// mty
																				// repobkg
																				// check로
																				// modifying
					// no support[check again]CLT sheetObj.CellValue2(Row,
					// "t1_sortnum")="2"; // REPO BKG Rowsetting
					sheetObj.SetCellValue(Row, "t1_sortnum", "2", 0);// REPO
																		// BKG
																		// Rowsetting
					sheetObj.SetCellValue(Row, "t1_num", "1", 0);// normal
																	// rowsetting
					sheetObj.SetCellValue(Row, "t1_split_repo_pln_flg", "Y", 0);// SPLIT
																				// rowsetting
					sheetObj.SetCellValue(Row, "t1_fm_rcc", sheetObj
							.GetCellValue(selRow, "t1_fm_rcc"), 0);// t1_fm_rcc
																	// copying
					sheetObj.SetCellValue(Row, "t1_to_rcc", sheetObj
							.GetCellValue(selRow, "t1_to_rcc"), 0);// t1_to_rcc
																	// copying
					sheetObj.SetCellValue(Row, "t1_fm_lcc", sheetObj
							.GetCellValue(selRow, "t1_fm_lcc"), 0);// t1_fm_lcc
																	// copying
					sheetObj.SetCellValue(Row, "t1_to_lcc", sheetObj
							.GetCellValue(selRow, "t1_to_lcc"), 0);// t1_to_lcc
																	// copying
					sheetObj.SetCellValue(Row, "t1_fm_ecc", sheetObj
							.GetCellValue(selRow, "t1_fm_ecc"), 0);// fm ecc
																	// copying
					sheetObj.SetCellValue(Row, "t1_to_ecc", sheetObj
							.GetCellValue(selRow, "t1_to_ecc"), 0);// to ecc
																	// copying
					// t1_past_repo_pln_flg copying
					sheetObj.SetCellValue(Row, "t1_past_repo_pln_flg", sheetObj
							.GetCellValue(selRow, "t1_past_repo_pln_flg"), 0);
					// copying pln_seq of selected plan
					sheetObj.SetCellValue(Row, "t1_pln_seq", sheetObj
							.GetCellValue(selRow, "t1_pln_seq"), 0);
					// ------ BOOKING retreive [START] -----------
					var f_cmd = SEARCH01;
					var lane = sheetObj.GetCellValue(selRow, "t1_vsl_lane_cd");
					var vvd = sheetObj.GetCellValue(selRow, "t1_vvd");
					var from_ecc = sheetObj.GetCellValue(selRow, "t1_fm_yd_cd");
					// sheetObj.DoRowSearch(
					// ROW,row=Row&search_lane=lane&search_vvd=vvd&search_fromecc=from_ecc&colname=t1_mty_bkg_no&repoPlnWeek=repoPlnWeek&f_cmd=f_cmd"&false"
					// );
					// sheetObj.DoRowSearch2("EES_EQR_0059GS1.do"
					// ,"row="+Row+"&search_lane="+lane+"&search_vvd="+vvd+"&search_fromecc="+from_ecc+"&colname=t1_mty_bkg_no&repoPlnWeek="+repoPlnWeek+"&f_cmd="+f_cmd);
					// sheetObj.SetCellValue(Row, 't1_mty_bkg_no',"",0);
					var sXml = sheetObj.GetSearchData("EES_EQR_0059GS1.do",
							"row=" + Row + "&search_lane=" + lane
									+ "&search_vvd=" + vvd + "&search_fromecc="
									+ from_ecc
									+ "&colname=t1_mty_bkg_no&repoPlnWeek="
									+ repoPlnWeek + "&f_cmd=" + f_cmd);
					changeViewCombo(sheetObj, sXml);
					// ------ BOOKING retreive [END] -----------
					// ------ TO LOC YARD retreive [START] -----------
					var f_cmd = SEARCH01;
					var vsl = sheetObj.GetCellValue(selRow, "t1_vvd");
					var to_ecc = sheetObj.GetCellValue(selRow, "t1_to_ecc");
					// sheetObj.DoRowSearch(
					// ROW,row=Row&colname=t1_to_yd_cd&vsl=vsl&ecc=to_ecc&item=V&f_cmd=f_cmd
					// );
					// sheetObj.DoRowSearch2("EES_LOCYARDINITIAL_COMMON.do"
					// ,"row="+Row+"&colname=t1_to_yd_cd&vsl="+vsl+"&ecc="+to_ecc+"&item=V&f_cmd="+f_cmd);
					var sXml = sheetObj.GetSearchData(
							"EES_LOCYARDINITIAL_COMMON.do", "row=" + Row
									+ "&colname=t1_to_yd_cd&vsl=" + vsl
									+ "&ecc=" + to_ecc + "&item=V&f_cmd="
									+ f_cmd);
					changeViewCombo(sheetObj, sXml);
					// ------ TO LOC YARD retreive [END] -----------
					// insert row
					document.form.position_row1.value = Row;
				} else {
					ComShowCodeMessage("EQR90151", "VD Add", repoPlnWeek,
							repoPlnNextWeek);
				}
				/*
				 * SPLIT ROW ADD( VD ) normal, repo bkg, booking_no!='' -->
				 * INSERT ACTION --> VOL disable
				 */
			} else if (sheetObj.GetCellValue(selRow, 't1_sortnum') == 2
					&& sheetObj.GetCellValue(selRow, 't1_num') == 1
					&& sheetObj.GetCellValue(selRow, 't1_mty_bkg_no') != ''
					&&
					// sheetObj.CellValue(selRow, 't1_cntrimage')=='0' &&
					sheetObj.GetCellValue(selRow, 't1_split_repo_pln_flg') != 'Y') {
				// in case of repo plan id, +1,+2 week, executable
				if (sourceWeek == repoPlnWeek || sourceWeek == repoPlnNextWeek) {
					// checking user athority
					if (!userAreaCheck(sheetObj, "VD Add", "to", 1, selRow)) {
						// return false;
					}
					// var Row=sheetObj.DataInsert(selRow);
					var Row = sheetObj.DataInsert();
					// color modifying
					sheetObj.SetRowBackColor(Row, "#D7D7D5");
					sheetObj.SetCellBackColor(Row, 't1_to_yd_cd', sheetObj
							.GetDataBackColor());
					sheetObj.SetCellBackColor(Row, 't1_eq_repo_purp_cd',
							sheetObj.GetDataBackColor());
					sheetObj.SetCellBackColor(Row, 't1_repo_pln_fb_rsn_cd',
							sheetObj.GetDataBackColor());
					sheetObj.SetCellBackColor(Row, 't1_repo_pln_fb_rmk',
							sheetObj.GetDataBackColor());
					sheetObj.SetCellValue(Row, 't1_pln_yrwk', sheetObj
							.GetCellValue(selRow, 't1_pln_yrwk'), 0);// week
																		// copying
					sheetObj.SetCellValue(Row, 't1_co_cd', sheetObj
							.GetCellValue(selRow, 't1_co_cd'), 0);// week
																	// copying
					sheetObj.SetCellValue(Row, 't1_div', "REPO BKG", 0);// REPO
																		// BKG
																		// setting
					sheetObj.SetCellValue(Row, 't1_repo_pln_id', sheetObj
							.GetCellValue(selRow, 't1_repo_pln_id'), 0);// repo_plan_id
																		// copying
					sheetObj.SetCellValue(Row, "t1_vsl_lane_cd", sheetObj
							.GetCellValue(selRow, "t1_vsl_lane_cd"), 0);// lane
																		// copy
					sheetObj.SetCellValue(Row, "t1_vvd", sheetObj.GetCellValue(
							selRow, "t1_vvd"), 0);// vvd copy
					sheetObj.SetCellValue(Row, "t1_fm_yd_cd", sheetObj
							.GetCellValue(selRow, "t1_fm_yd_cd"), 0);// from
																		// yard
																		// copying
					sheetObj.SetCellValue(Row, "t1_to_yd_cd", sheetObj
							.GetCellValue(selRow, "t1_to_ecc"), 0);// to loc
																	// copying
					sheetObj.SetCellValue(Row, "t1_fm_etd_dt", sheetObj
							.GetCellValue(selRow, "t1_fm_etd_dt"), 0);// from
																		// etd
																		// copying
					sheetObj.SetCellValue(Row, "t1_to_eta_dt", sheetObj
							.GetCellValue(selRow, "t1_to_eta_dt"), 0);// to
																		// eta
																		// copying
					sheetObj.SetCellValue(Row, 't1_trsp_mod_cd', sheetObj
							.GetCellValue(selRow, 't1_trsp_mod_cd'), 0);// item
																		// copying
					sheetObj.SetCellValue(Row, 't1_eq_repo_purp_cd', "", 0);// Purpose
																			// resetting
					sheetObj.SetCellValue(Row, 't1_repo_pln_fb_rsn_cd', "", 0);// Reason
																				// resetting
					sheetObj.SetCellValue(Row, "t1_cntrimage", "1", 0);// cntr
																		// image
																		// initializing
					sheetObj.InitCellProperty(Row, 't1_repo_mty_bkg_flg', {
						Type : "CheckBox"
					});
					sheetObj.SetCellValue(Row, 't1_repo_mty_bkg_flg', '1', 0);// item
																				// copying
					sheetObj.SetCellValue(Row, 't1_mty_bkg_no', sheetObj
							.GetCellValue(selRow, 't1_mty_bkg_no'), 0);// item
																		// copying
					sheetObj.SetCellEditable(Row, "t1_mty_bkg_no", 0); // VD`s
																		// BKG
																		// No.
																		// Uneditable.
					// no support[check again]CLT sheetObj.CellValue2(Row,
					// "t1_sortnum")="2"; // REPO BKG Rowsetting
					sheetObj.SetCellValue(Row, "t1_sortnum", "2", 0);// REPO
																		// BKG
																		// Rowsetting
					sheetObj.SetCellValue(Row, "t1_num", "1", 0);// normal
																	// rowsetting
					sheetObj.SetCellValue(Row, "t1_split_repo_pln_flg", "Y", 0);// SPLIT
																				// rowsetting
					sheetObj.SetCellValue(Row, "t1_fm_rcc", sheetObj
							.GetCellValue(selRow, "t1_fm_rcc"), 0);// t1_fm_rcc
																	// copying
					sheetObj.SetCellValue(Row, "t1_to_rcc", sheetObj
							.GetCellValue(selRow, "t1_to_rcc"), 0);// t1_to_rcc
																	// copying
					sheetObj.SetCellValue(Row, "t1_fm_lcc", sheetObj
							.GetCellValue(selRow, "t1_fm_lcc"), 0);// t1_fm_lcc
																	// copying
					sheetObj.SetCellValue(Row, "t1_to_lcc", sheetObj
							.GetCellValue(selRow, "t1_to_lcc"), 0);// t1_to_lcc
																	// copying
					sheetObj.SetCellValue(Row, "t1_fm_ecc", sheetObj
							.GetCellValue(selRow, "t1_fm_ecc"), 0);// fm ecc
																	// copying
					sheetObj.SetCellValue(Row, "t1_to_ecc", sheetObj
							.GetCellValue(selRow, "t1_to_ecc"), 0);// to ecc
																	// copying
					// t1_past_repo_pln_flg copying
					sheetObj.SetCellValue(Row, "t1_past_repo_pln_flg", sheetObj
							.GetCellValue(selRow, "t1_past_repo_pln_flg"), 0);

					// modifying disable
					sheetObj.SetCellEditable(Row, 't1_mailfax', 0);// MAIL FAX
																	// modifying
																	// disable
					sheetObj.SetCellEditable(Row, 't1_co_cd', 0);// COMPANY
																	// modifying
																	// disable
					sheetObj.SetCellEditable(Row, 't1_vsl_lane_cd', 0);// LANE
																		// modifying
																		// disable
					sheetObj.SetCellEditable(Row, 't1_vvd', 0);// VVD modifying
																// disable
					sheetObj.SetCellEditable(Row, 't1_fm_yd_cd', 0);// FROM
																	// LOCATION
																	// modifying
																	// disable
					sheetObj.SetCellEditable(Row, 't1_repo_pln_fb_rmk', 0);// Reason
																			// Remark
																			// modifying
																			// disable
					for ( var i = 0; i < consTpszArr.length; i++) {
						sheetObj.SetCellEditable(Row,
								't1_vol' + consTpszArr[i], 0);// VOL modifying
																// disable
					}
					// copying pln_seq of selected plan
					sheetObj.SetCellValue(Row, "t1_pln_seq", sheetObj
							.GetCellValue(selRow, "t1_pln_seq"), 0);
					// ------ TO LOC YARD retreive [START] -----------

					var f_cmd = SEARCH17;
					var vsl = sheetObj.GetCellValue(selRow, "t1_vvd");
					var to_ecc = sheetObj.GetCellValue(selRow, "t1_fm_yd_cd");
					sheetObj.InitCellProperty(Row, "t1_to_yd_cd", {
						Type : "Combo"
					});
					// sheetObj.DoRowSearch(
					// ROW,row=Row&colname=t1_to_yd_cd&vsl=vsl&ecc=to_ecc&item=V&f_cmd=f_cmd
					// );
					// sheetObj.DoRowSearch2("EES_LOCYARDINITIAL_COMMON.do"
					// ,"row="+Row+"&colname=t1_to_yd_cd&vsl="+vsl+"&ecc="+to_ecc+"&item=V&f_cmd="+f_cmd);
					sheetObj.DoRowSearch2("EES_LOCYARDINITIAL_COMMON.do",
							"row=" + Row + "&colname=t1_to_yd_cd&vsl=" + vsl
									+ "&ecc=" + to_ecc + "&item=V&f_cmd="
									+ f_cmd);
					// changeViewCombo(sheetObj, sXml);
					// ------ TO LOC YARD retreive [END] -----------
					// insert row
					sheetObj.SetCellValue(Row, "t1_to_eta_dt", "");
					document.form.position_row1.value = Row;
				} else {
					ComShowCodeMessage("EQR90151", "Row Add", repoPlnWeek,
							repoPlnNextWeek);
				}
			} else {
				ComShowCodeMessage("EQR90248");
			}
		}
		break;
	}
}
function doActionIBSheet_3(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSAVE:
		// ComShowMessage("GOGO ");
		formObj.f_cmd.value = MULTI02;
		// sheetObj.DoSave("EES_EQR_0059GS.do", eqrFormQryStr(formObj));
		var saveStr = sheetObj.GetSaveString();
		if (saveStr == "")
			return;
		var sXml = sheetObj.GetSaveData("EES_EQR_0059GS.do", saveStr,
				eqrFormQryStr(formObj));
		sheetObj.LoadSaveData(sXml, {
			Sync : 1
		});
		t1sheet1_ChangeXml(sXml);
		break;
	}
}

// handling process for Sheet
function doActionIBSheet2(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: // retrieve
		if (validateForm(sheetObj, formObj, sAction, 2)) {
			// showing again after initailizing sheet for dyanamic view
			document.form.dataselect1[0].checked = true;
			ComOpenWait(true);
			sheetObj.SetWaitImageVisible(1);
			setTimeout(function() {
				t2sheet1.SetVisible(0);
				t2sheet1.RemoveAll();
				sheetObjects[1] = t2sheet1.Reset();// keyfied
				t2sheet1.SetWaitTimeOut(300);// retrieve
				// ComConfigSheet (sheetObj);
				initSheet(t2sheet1, 2, comboObjects[1].GetSelectText());
				ComEndConfigSheet(t2sheet1);
				t2sheet1.SetWaitImageVisible(1);
				// no support[check again]CLT
				// sheetObj.SpeedOption="NOFIT,NOSUM,NOSEQ,NOCALC,NOROWHEIGHT,NOTRIM";
				formObj.f_cmd.value = SEARCHLIST;
				// t2sheet1.DoSearch("EES_EQR_0080GS.do",
				// eqrFormQryStr(formObj), {Sync:2} );
				var sXml = t2sheet1.GetSearchData("EES_EQR_0080GS.do",
						eqrFormQryStr(formObj));
				t2sheet1.LoadSearchData(sXml, {
					Sync : 1
				});
				t2sheet1_ChangeXml(sXml);
				// formObj.t2_plnWeek.value=sheetObj.GetEtcData("t2_plnWeek");
				// formObj.t2_plnNextWeek.value=sheetObj.GetEtcData("t2_plnNextWeek");
				ComEtcDataToForm(formObj, t2sheet1);
				sheetObj.SetVisible(1);
				sheetObj.SetExtendLastCol(0);
				formObj.pre_repo_rmk.value = formObj.repo_rmk.value;
			}, 100);
		}
		break;
	case IBSAVE: // saving
		if (validateForm(sheetObj, formObj, sAction, 2)) {
			/*var sIURow = sheetObj.FindStatusRow("I|U");
			if (sIURow != "" && sIURow != null) {
				//중복체크 VVD, Yard
				var lastNum = 0;
				var strChkRow = "";
				var strAllChkRow = "";
				var chkDup = 0;
				for ( var i = 2; i < sheetObj.RowCount(); i++) {
					if(sheetObj.GetCellValue(i, "t2_fm_yd_cd") == "" && sheetObj.GetRowStatus(i) !="D") {
						lastNum = lastNum+1;
					}
					
					if(sheetObj.GetCellValue(i,"t2_vvd") != "" && (sheetObj.GetRowStatus(i) =="I" || sheetObj.GetRowStatus(i) =="U")) {
						strChkRow = sheetObj.GetCellValue(i,"t2_vvd")+"_"+sheetObj.GetCellValue(i,"t2_fm_yd_cd")+"_"+sheetObj.GetCellValue(i,"t2_to_yd_cd");
						for ( var k = 2; k < sheetObj.RowCount(); k++) {
							if(i != k) {
								strAllChkRow = sheetObj.GetCellValue(k,"t2_vvd")+"_"+sheetObj.GetCellValue(k,"t2_fm_yd_cd")+"_"+sheetObj.GetCellValue(k,"t2_to_yd_cd");
								
								if(strChkRow == strAllChkRow) {
									chkDup = 1;
									break;
								}
							}
						}
					}
				}
				
				//var chkDup = sheetObj.ColValueDupRows("t2_vvd|t2_fm_yd_cd|t2_to_yd_cd",1,0,1,sheetObj.RowCount()-lastNum);
				var strRepoId = "REPO"+formObj.yyyyww.value+"W"+formObj.seq.value;
				if(chkDup > 0) {
					ComShowCodeMessage("EQR01153", strRepoId);
					return false;
				}
			}*/
			
			var sRow = sheetObj.FindStatusRow("I|U|D");
			var arRow = sRow.split(";");
			var flag = true;
			if (sRow != "" && sRow != null) {
				// for(var i=0; i<arRow.length-1; i++) {
				for ( var i = 0; i < arRow.length; i++) {
					// in case of EXECUTE VOL=0 && PLAN VOL!=0, pass=F &
					// background color = red
					for ( var j = 0; j < consTpszArr.length; j++) {
						if (sheetObj.GetCellValue(arRow[i], "t2_vol"
								+ consTpszArr[j]) == '0') {
							// retrieving for plan row
							var week = sheetObj.GetCellValue(arRow[i],
									"t2_pln_yrwk");
							var item = sheetObj.GetCellValue(arRow[i],
									"t2_trsp_mod_cd");
							var fm_ecc = sheetObj.GetCellValue(arRow[i],
									"t2_fm_ecc");
							var to_ecc = sheetObj.GetCellValue(arRow[i],
									"t2_to_ecc");
							var planVol = 0;
							var planRow = 0;
							for ( var k = 0; k < sheetObj.RowCount(); k++) {
								if (sheetObj.GetCellValue(k, "t2_sortnum") == 1
										&& sheetObj.GetCellValue(k, "t2_num") == 1
										&& sheetObj.GetCellValue(k,
												"t2_pln_yrwk") == week
										&& sheetObj.GetCellValue(k,
												"t2_trsp_mod_cd") == item
										&& sheetObj
												.GetCellValue(k, "t2_fm_ecc") == fm_ecc
										&& sheetObj
												.GetCellValue(k, "t2_to_ecc") == to_ecc) {
									planRow = k;
									break;
								}
							}
							if (planRow != 0) {
								planVol = eval(sheetObj.GetCellValue(planRow,
										"t2_vol" + consTpszArr[j]));
								if (planVol > 0) {
									sheetObj.SetCellValue(arRow[i], "t2_pass"
											+ consTpszArr[j], 'F', 0);
									// sheetObj.SetCellFontColor(arRow[i],"t2_vol"+consTpszArr[j],"#F1541F");
								}
							}
						}
					}
					// --------- cheking each flag, final flag
					var passCount = 0;
					for ( var z = 0; z < consTpszArr.length; z++) {
						if (sheetObj.GetCellValue(arRow[i], "t2_pass"
								+ consTpszArr[z]) == 'F') {
							passCount++;
							break;
						}
					}
					if (passCount > 0) {
						sheetObj
								.SetCellValue(arRow[i], "t2_pass_final", 'F', 0);
					} else {
						sheetObj.SetCellValue(arRow[i], "t2_pass_final", '', 0);
					}
					if (sheetObj.GetCellValue(arRow[i], "t2_fm_yd_cd").length < 7
							&& sheetObj.GetCellValue(arRow[i], "t2_sortnum") == "2") {
						ComShowCodeMessage("EQR90126", (arRow[i] - 1),
								"FROM LOC");
						flag = false;
						break;
					} else if (sheetObj.GetCellValue(arRow[i], "t2_to_yd_cd").length < 7
							&& sheetObj.GetCellValue(arRow[i], "t2_sortnum") == "2") {
						ComShowCodeMessage("EQR90126", (arRow[i] - 1), "TO LOC");
						flag = false;
						break;
					}
				}
			}
			if (flag) {
				if (sRow != "" && sRow != null) {	
					var formObj = document.form; 
		        	var f_cmd =SEARCHLIST01;
		        	var saveStr = sheetObj.GetSaveString();
					if (saveStr == "")
						return;
					
		        	var sXml= sheetObj.GetSearchData("EES_EQR_0080GS.do",saveStr+"&f_cmd=" + f_cmd);
		        	var strDataYN=ComGetEtcData(sXml, "dataYN");
		        	if(strDataYN != "") {
		        		ComShowCodeMessage("EQR01153", strDataYN);
		        		return false;
		        	}
					
					formObj.f_cmd.value = MULTI;
					// sheetObj.DoSave("EES_EQR_0080GS.do",
					// eqrFormQryStr(formObj));
					
					var saveStr = sheetObj.GetSaveString();
					if (saveStr == "")
						return;
					var sXml = sheetObj.GetSaveData("EES_EQR_0080GS.do",
							saveStr, eqrFormQryStr(formObj));
					
					if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
						sheetObj.LoadSaveData(sXml, {
							Sync : 1
						});
						t2sheet1_ChangeXml(sXml);
					}
					else {
						var msg=EqrGetMsgText(sXml);
			            if ( msg != 'undefined' && msg != '') {	
				           ComShowMessage(msg);
				           sheetObj.SelectCell(arRow[0],"t2_fm_yd_cd");
				           return false;
			            }
					}
				}

				if (formObj.pre_repo_rmk.value != formObj.repo_rmk.value) {
					ComShowConfirm(ComGetMsg("EQR90236"));
					formObj.f_cmd.value = MULTI03;
					ComOpenWait(true);
					var sXml = sheetObj.GetSaveData("EES_EQR_0012GS.do",
							eqrFormQryStr(formObj));
					ComOpenWait(false);
					sheetObj.LoadSaveData(sXml, {
						Sync : 1
					});
					formObj.pre_repo_rmk.value = formObj.repo_rmk.value;
					ComEtcDataToForm(document.form, sheetObj);
					// document.form.checksave.value ="Y";
					// ComShowMessage(ComGetMsg("EQR90106")); // ??옣?꾨즺
				}
			}
		}
		break;
	case IBINSERT:
		if (sheetObj.RowCount() > 0) {
			var selRow = sheetObj.GetSelectRow(); // selected ROW
			var sourceWeek = sheetObj.GetCellValue(selRow, 't2_pln_yrwk');
			var repoPlnWeek = formObj.t2_plnWeek.value;
			var repoPlnNextWeek = formObj.t2_plnNextWeek.value;
			if (sheetObj.GetCellValue(selRow, 't2_sortnum') == 1
					&& sheetObj.GetCellValue(selRow, 't2_num') == 1
					&& sheetObj.GetCellValue(selRow, 't2_newplan') != "T"
					&& (sheetObj.GetCellValue(selRow, 't2_past_repo_pln_flg') != 'Y' || (sheetObj
							.GetCellValue(selRow, 't2_past_repo_pln_flg') == 'Y' && sheetObj
							.GetCellValue(selRow, 't2_trsp_mod_cd') == 'W'))) {
				// in case of repo plan id, +1,+2 week, executable
				if (sourceWeek == repoPlnWeek || sourceWeek == repoPlnNextWeek) {
					if (consTpszArr.length < allTpszCnt) {
						ComShowCodeMessage("EQR90045", "Row Add", "ALL");
						return false;
					}
					// checking user athority
					if (!userAreaCheck(sheetObj, "Row Add", "from", 2, selRow)) {
						// return false;
					}

					if ((sheetObj.GetCellValue(selRow, 't2_fm_chk_flg') != "Y")) {
						// ComShowCodeMessage("EQR90239",sheetObj.GetCellValue(selRow,
						// 't2_fm_yd_cd'));
						// return false;
					}

					var popOpenYn = "";
					if((sheetObj.GetCellValue(selRow, 't2_trsp_mod_cd') == "R" || sheetObj.GetCellValue(selRow, 't2_trsp_mod_cd') == "T") && 
							(sheetObj.GetCellValue(selRow, 't2_fm_yd_cd').substr(0, 2) == "US" || sheetObj.GetCellValue(selRow, 't2_fm_yd_cd').substr(0, 2) == "CA" ) &&
							(sheetObj.GetCellValue(selRow, 't2_to_yd_cd').substr(0, 2) == "US" || sheetObj.GetCellValue(selRow, 't2_to_yd_cd').substr(0, 2) == "CA" )) {

						popOpenYn = "Y";
					}
					
					// var Row=sheetObj.DataInsert(selRow);
					var Row = "";
					if(popOpenYn != "Y") {
						Row = sheetObj.DataInsert();
						sheetObj.SetRowBackColor(Row, "#F7FB59");
					}
					// NORMAL PLAN
					if(popOpenYn != "Y") {
						if (sheetObj.GetCellValue(selRow, 't2_past_repo_pln_flg') != 'Y') {
							sheetObj.SetCellValue(Row, 't2_pln_yrwk', sheetObj
									.GetCellValue(selRow, 't2_pln_yrwk'), 0);// week
																				// copying
							sheetObj.SetCellValue(Row, 't2_week_fromdate', sheetObj
									.GetCellValue(selRow, 't2_week_fromdate'), 0);// from
																					// date
																					// copying
							sheetObj.SetCellValue(Row, 't2_week_todate', sheetObj
									.GetCellValue(selRow, 't2_week_todate'), 0);// to
																				// date
																				// copying
							sheetObj.SetCellValue(Row, 't2_week_maxdate', sheetObj
									.GetCellValue(selRow, 't2_week_maxdate'), 0);// max
																					// date
																					// copying
							sheetObj.SetCellValue(Row, 't2_div', "Execution", 0);// REPO
																					// BKG
																					// setting
							sheetObj.SetCellValue(Row, 't2_repo_pln_id', sheetObj
									.GetCellValue(selRow, 't2_repo_pln_id'), 0);// repo_plan_id
																				// copying
							// sheetObj.CellValue2(Row, 't2_vsl_lane_cd') =
							// sheetObj.CellValue(selRow, 't2_vsl_lane_cd'); // lane
							// copy
							// sheetObj.CellValue2(Row, 't2_vvd') =
							// sheetObj.CellValue(selRow, 't2_vvd'); // vvd copy
							if (sheetObj.GetCellValue(selRow, 't2_trsp_mod_cd') != 'W') { // RAIL,
																							// TRUCK
																							// 은
																							// VVD,
																							// LANE
																							// disable
								sheetObj.SetCellEditable(Row, 't2_vsl_lane_cd', 0);// LANE
																					// modifying
																					// disable
								sheetObj.SetCellEditable(Row, 't2_vvd', 0);// VVD
																			// modifying
																			// disable
							}
							sheetObj.SetCellValue(Row, "t2_fm_yd_cd", sheetObj
									.GetCellValue(selRow, "t2_fm_ecc"), 0);// from
																			// loc
																			// copying
							sheetObj.SetCellValue(Row, "t2_to_yd_cd", sheetObj
									.GetCellValue(selRow, "t2_to_ecc"), 0);// to
																			// loc
																			// copying
							sheetObj.SetCellValue(Row, 't2_trsp_mod_cd', sheetObj
									.GetCellValue(selRow, 't2_trsp_mod_cd'), 0);// item
																				// copying
							sheetObj.SetCellValue(Row, 't2_eq_repo_purp_cd', "", 0);// Purpose
																					// resetting
							sheetObj.SetCellValue(Row, 't2_repo_pln_fb_rsn_cd', "",
									0);// Reason resetting
							sheetObj.SetCellValue(Row, "t2_repo_pln_fb_rsn_cd", "",
									0);// Reason resetting
							sheetObj.SetCellEditable(Row, 't2_repo_pln_fb_rmk', 0);// Reason
																					// Remark
																					// modifying
																					// disable
							sheetObj.SetCellValue(Row, "t2_cntrimage", "1", 0);// cntr
																				// image
																				// initializing
							// no support[check again]CLT sheetObj.CellValue2(Row,
							// "t2_sortnum")="2"; // REPO BKG Rowsetting
							sheetObj.SetCellValue(Row, "t2_sortnum", "2", 0);// REPO
																				// BKG
																				// Rowsetting
							sheetObj.SetCellValue(Row, "t2_num", "1", 0);// normal
																			// rowsetting
							sheetObj.SetCellValue(Row, "t2_fm_rcc", sheetObj
									.GetCellValue(selRow, "t2_fm_rcc"), 0);// fm
																			// rcc
																			// copying
							sheetObj.SetCellValue(Row, "t2_to_rcc", sheetObj
									.GetCellValue(selRow, "t2_to_rcc"), 0);// to
																			// rcc
																			// copying
							sheetObj.SetCellValue(Row, "t2_fm_lcc", sheetObj
									.GetCellValue(selRow, "t2_fm_lcc"), 0);// fm
																			// lcc
																			// copying
							sheetObj.SetCellValue(Row, "t2_to_lcc", sheetObj
									.GetCellValue(selRow, "t2_to_lcc"), 0);// to
																			// lcc
																			// copying
							sheetObj.SetCellValue(Row, "t2_fm_ecc", sheetObj
									.GetCellValue(selRow, "t2_fm_ecc"), 0);// fm
																			// ecc
																			// copying
							sheetObj.SetCellValue(Row, "t2_to_ecc", sheetObj
									.GetCellValue(selRow, "t2_to_ecc"), 0);// to
																			// ecc
																			// copying
							sheetObj.SetCellValue(Row, "t2_pln_seq", sheetObj
									.GetCellValue(selRow, "t2_pln_seq"), 0);// pln_seq
																			// copying
							// t2_past_repo_pln_flg copying
							sheetObj.SetCellValue(Row, "t2_past_repo_pln_flg",
									sheetObj.GetCellValue(selRow,
											"t2_past_repo_pln_flg"), 0);
							// // UNIT, FROM, TO COST copying
							// for(var i=0; i<consTpszArr.length; i++) {
							// sheetObj.CellValue2(Row,
							// "t2_unitcost"+consTpszArr[i]) =
							// sheetObj.CellValue(selRow,
							// "t2_unitcost"+consTpszArr[i]);
							// sheetObj.CellValue2(Row,
							// "t2_fromcost"+consTpszArr[i]) =
							// sheetObj.CellValue(selRow,
							// "t2_fromcost"+consTpszArr[i]);
							// sheetObj.CellValue2(Row, "t2_tocost"+consTpszArr[i])
							// = sheetObj.CellValue(selRow,
							// "t2_tocost"+consTpszArr[i]);
							// }
							// Item ='Water'인 경우
							if (sheetObj.GetCellValue(selRow, 't2_trsp_mod_cd') == 'W') {
								// ------ FM LOC YARD retreive [START] -----------
								var f_cmd = SEARCH01;
								var vsl = sheetObj.GetCellValue(selRow, "t2_vvd");
								var from_ecc = sheetObj.GetCellValue(selRow,
										"t2_fm_ecc");
								// sheetObj.DoRowSearch(
								// ROW,row=Row&colname=t2_fm_yd_cd&vsl=vsl&ecc=from_ecc&item=W&f_cmd=f_cmd"&false"
								// );
								// sheetObj.DoRowSearch2("EES_LOCYARDINITIAL_COMMON.do"
								// ,"row="+Row+"&colname=t2_fm_yd_cd&vsl="+vsl+"&ecc="+from_ecc+"&item=W&f_cmd="+f_cmd);
	
								sheetObj.InitCellProperty(Row, "t2_fm_yd_cd", {
									Type : "Combo"
								});
								sheetObj.DoRowSearch2(
										"EES_LOCYARDINITIAL_COMMON.do", "row="
												+ Row + "&colname=t2_fm_yd_cd&vsl="
												+ vsl + "&ecc=" + from_ecc
												+ "&item=W&f_cmd=" + f_cmd);
								// var sXml =
								// sheetObj.GetSearchData("EES_LOCYARDINITIAL_COMMON.do",
								// "row="+Row+"&colname=t2_fm_yd_cd&vsl="+vsl+"&ecc="+from_ecc+"&item=W&f_cmd="+f_cmd);
								// changeViewCombo(sheetObj, sXml);
	
								// ------ FM LOC YARD retreive [END] -----------
	
								// ------ TO LOC YARD retreive [START] -----------
								var f_cmd = SEARCH01;
								var vsl = sheetObj.GetCellValue(selRow, "t2_vvd");
								var to_ecc = sheetObj.GetCellValue(selRow,
										"t2_to_ecc");
								// sheetObj.DoRowSearch(
								// ROW,row=Row&colname=t2_to_yd_cd&vsl=vsl&ecc=to_ecc&item=W&f_cmd=f_cmd
								// );
								// sheetObj.DoRowSearch2("EES_LOCYARDINITIAL_COMMON.do"
								// ,"row="+Row+"&colname=t2_to_yd_cd&vsl="+vsl+"&ecc="+to_ecc+"&item=W&f_cmd="+f_cmd);
								sheetObj.InitCellProperty(Row, "t2_to_yd_cd", {
									Type : "Combo"
								});
								sheetObj.DoRowSearch2(
										"EES_LOCYARDINITIAL_COMMON.do", "row="
												+ Row + "&colname=t2_to_yd_cd&vsl="
												+ vsl + "&ecc=" + to_ecc
												+ "&item=W&f_cmd=" + f_cmd);
								// var sXml =
								// sheetObj.GetSearchData("EES_LOCYARDINITIAL_COMMON.do",
								// "row="+Row+"&colname=t2_to_yd_cd&vsl="+vsl+"&ecc="+to_ecc+"&item=W&f_cmd="+f_cmd);
								// changeViewCombo(sheetObj, sXml);
								// ------ TO LOC YARD retreive [END] -----------
								sheetObj.SetCellValue(Row, "t2_fm_yd_cd", "", 0);
								sheetObj.SetCellValue(Row, "t2_to_yd_cd", "", 0);
							} else { // TRUCK, RAIL
								var f_cmd = SEARCH15;
								var from_ecc = sheetObj.GetCellValue(selRow,
										"t2_fm_ecc");
								// sheetObj.DoRowSearch(
								// ROW,row=Row&searchword=from_ecc&colname=t2_fm_yd_cd&f_cmd=f_cmd
								// );
								// sheetObj.DoRowSearch2("EES_LOCYARD_COMMON.do"
								// ,"row="+Row+"&searchword="+from_ecc+"&colname=t2_fm_yd_cd&f_cmd="+f_cmd);
								// var sXml =
								// sheetObj.GetSearchData("EES_LOCYARD_COMMON.do",
								// "row="+Row+"&searchword="+from_ecc+"&colname=t2_fm_yd_cd&f_cmd="+f_cmd);
								// changeViewCombo(sheetObj, sXml);
								sheetObj.InitCellProperty(Row, "t2_fm_yd_cd", {
									Type : "Combo"
								});
								sheetObj.DoRowSearch2("EES_LOCYARD_COMMON.do",
										"row=" + Row + "&searchword=" + from_ecc
												+ "&colname=t2_fm_yd_cd&f_cmd="
												+ f_cmd);
	
								var f_cmd = SEARCH15;
								var to_ecc = sheetObj.GetCellValue(selRow,
										"t2_to_ecc");
								// sheetObj.DoRowSearch(
								// ROW,row=Row&searchword=to_ecc&colname=t2_to_yd_cd&f_cmd=f_cmd
								// );
								// sheetObj.DoRowSearch2("EES_LOCYARD_COMMON.do"
								// ,"row="+Row+"&searchword="+to_ecc+"&colname=t2_to_yd_cd&f_cmd="+f_cmd);
								// var sXml =
								// sheetObj.GetSearchData("EES_LOCYARD_COMMON.do",
								// "row="+Row+"&searchword="+to_ecc+"&colname=t2_to_yd_cd&f_cmd="+f_cmd);
								// changeViewCombo(sheetObj, sXml);
								sheetObj.InitCellProperty(Row, "t2_to_yd_cd", {
									Type : "Combo"
								});
								sheetObj.DoRowSearch2("EES_LOCYARD_COMMON.do",
										"row=" + Row + "&searchword=" + to_ecc
												+ "&colname=t2_to_yd_cd&f_cmd="
												+ f_cmd);
	
								sheetObj.SetCellValue(Row, "t2_fm_yd_cd", "", 0);
								sheetObj.SetCellValue(Row, "t2_to_yd_cd", "", 0);
							}
							// insert row
							document.form.position_row2.value = Row;
							// FIXED PLAN && TRSP MODE = WATER
						} else if (sheetObj.GetCellValue(selRow,
								't2_past_repo_pln_flg') == 'Y'
								&& sheetObj.GetCellValue(selRow, 't2_trsp_mod_cd') == 'W') { // FIXED
																								// PLAN
							sheetObj.SetCellValue(Row, 't2_pln_yrwk', sheetObj
									.GetCellValue(selRow, 't2_pln_yrwk'), 0);// week
																				// copying
							sheetObj.SetCellValue(Row, 't2_week_fromdate', sheetObj
									.GetCellValue(selRow, 't2_week_fromdate'), 0);// from
																					// date
																					// copying
							sheetObj.SetCellValue(Row, 't2_week_todate', sheetObj
									.GetCellValue(selRow, 't2_week_todate'), 0);// to
																				// date
																				// copying
							sheetObj.SetCellValue(Row, 't2_week_maxdate', sheetObj
									.GetCellValue(selRow, 't2_week_maxdate'), 0);// max
																					// date
																					// copying
							sheetObj.SetCellValue(Row, 't2_div', "Execution", 0);// REPO
																					// BKG
																					// setting
							sheetObj.SetCellValue(Row, 't2_repo_pln_id', sheetObj
									.GetCellValue(selRow, 't2_repo_pln_id'), 0);// repo_plan_id
																				// copying
							sheetObj.SetCellValue(Row, "t2_pln_seq", sheetObj
									.GetCellValue(selRow, "t2_pln_seq"), 0);// pln_seq
																			// copying
							sheetObj.SetCellEditable(Row, 't2_fm_yd_cd', 0);// from
																			// loc
																			// inserting
																			// disable
							sheetObj.SetCellEditable(Row, 't2_fm_etd_dt', 0);// from
																				// etd
																				// inserting
																				// disable
							// sheetObj.CellEditable(Row, 't2_to_eta_dt') = false;
							// // to eta inserting disable
							sheetObj.SetCellValue(Row, 't2_trsp_mod_cd', sheetObj
									.GetCellValue(selRow, 't2_trsp_mod_cd'), 0);// item
																				// copying
							sheetObj.SetCellValue(Row, 't2_eq_repo_purp_cd', "", 0);// Purpose
																					// resetting
							sheetObj.SetCellValue(Row, 't2_repo_pln_fb_rsn_cd', "",
									0);// Reason resetting
							sheetObj.SetCellValue(Row, "t2_repo_pln_fb_rsn_cd", "",
									0);// Reason resetting
							sheetObj.SetCellEditable(Row, 't2_repo_pln_fb_rmk', 0);// Reason
																					// Remark
																					// modifying
																					// disable
							sheetObj.SetCellValue(Row, "t2_cntrimage", "1", 0);// cntr
																				// image
																				// initializing
							// no support[check again]CLT sheetObj.CellValue2(Row,
							// "t2_sortnum")="2"; // REPO BKG Rowsetting
							sheetObj.SetCellValue(Row, "t2_sortnum", "2", 0);// REPO
																				// BKG
																				// Rowsetting
							sheetObj.SetCellValue(Row, "t2_num", "1", 0);// normal
																			// rowsetting
							sheetObj.SetCellValue(Row, "t2_fm_rcc", sheetObj
									.GetCellValue(selRow, "t2_fm_rcc"), 0);// fm
																			// rcc
																			// copying
							sheetObj.SetCellValue(Row, "t2_to_rcc", sheetObj
									.GetCellValue(selRow, "t2_to_rcc"), 0);// to
																			// rcc
																			// copying
							sheetObj.SetCellValue(Row, "t2_fm_lcc", sheetObj
									.GetCellValue(selRow, "t2_fm_lcc"), 0);// fm
																			// lcc
																			// copying
							sheetObj.SetCellValue(Row, "t2_to_lcc", sheetObj
									.GetCellValue(selRow, "t2_to_lcc"), 0);// to
																			// lcc
																			// copying
							sheetObj.SetCellValue(Row, "t2_fm_ecc", sheetObj
									.GetCellValue(selRow, "t2_fm_ecc"), 0);// fm
																			// ecc
																			// copying
							sheetObj.SetCellValue(Row, "t2_to_ecc", sheetObj
									.GetCellValue(selRow, "t2_to_ecc"), 0);// to
																			// ecc
																			// copying
							// t2_past_repo_pln_flg copying
							sheetObj.SetCellValue(Row, "t2_past_repo_pln_flg",
									sheetObj.GetCellValue(selRow,
											"t2_past_repo_pln_flg"), 0);
							// // UNIT, FROM, TO COST copying
							// for(var i=0; i<consTpszArr.length; i++) {
							// sheetObj.CellValue2(Row,
							// "t2_unitcost"+consTpszArr[i]) =
							// sheetObj.CellValue(selRow,
							// "t2_unitcost"+consTpszArr[i]);
							// sheetObj.CellValue2(Row,
							// "t2_fromcost"+consTpszArr[i]) =
							// sheetObj.CellValue(selRow,
							// "t2_fromcost"+consTpszArr[i]);
							// sheetObj.CellValue2(Row, "t2_tocost"+consTpszArr[i])
							// = sheetObj.CellValue(selRow,
							// "t2_tocost"+consTpszArr[i]);
							// }
							// ------ VVD retreive -----------
							var f_cmd = SEARCH06;
							var fm_ecc = sheetObj.GetCellValue(selRow,
									"t2_fm_yd_cd");
							var to_ecc = sheetObj.GetCellValue(selRow,
									"t2_to_yd_cd");
							var eta_week = sheetObj.GetCellValue(selRow,
									"t2_to_eta_dt");
							// sheetObj.DoRowSearch(
							// ROW,row=Row&colname=t2_vvd&fm_ecc=fm_ecc&to_ecc=to_ecc&eta_week=eta_week&f_cmd=f_cmd"&false"
							// );
							// sheetObj.DoRowSearch2("EES_VVDINLAND_COMMON.do"
							// ,"row="+Row+"&colname=t2_vvd&fm_ecc="+fm_ecc+"&to_ecc="+to_ecc+"&eta_week="+eta_week+"&f_cmd="+f_cmd);
							var sXml = sheetObj.GetSearchData(
									"EES_VVDINLAND_COMMON.do", "row=" + Row
											+ "&colname=t2_vvd&fm_ecc=" + fm_ecc
											+ "&to_ecc=" + to_ecc + "&eta_week="
											+ eta_week + "&f_cmd=" + f_cmd);
							changeViewCombo(sheetObj, sXml);
							sheetObj.SetCellValue(Row, "t2_vvd", "", 0);
							// insert row
							document.form.position_row2.value = Row;
						}

	
						// 2014.10.14 Park Young Jin
						// sheetObj.CellEditable(Row, 't2_pln_yrwk') = true;
						sheetObj.SetCellEditable(Row, 't2_pln_yrwk', 0);
						sheetObj.SetCellValue(Row, 't2_fm_etd_dt', sheetObj
								.GetCellValue(selRow, "t2_week_fromdate"));
						sheetObj.SetCellValue(Row, 't2_to_eta_dt', sheetObj
								.GetCellValue(selRow, "t2_week_maxdate"));
					} else { //POPOPENYN != 'Y'
						if (ComShowConfirm(ComGetMsg("EQR01146"))) {
							var strFmYdCd = sheetObj.GetCellValue(selRow,"t2_fm_yd_cd");
							var strToYdCd = sheetObj.GetCellText(selRow,"t2_to_yd_cd");
							var strFmEtdDt = sheetObj.GetCellText(selRow,"t2_fm_etd_dt");
							var strToEtaDt = sheetObj.GetCellText(selRow,"t2_to_eta_dt");
							
							var selRow = sheetObj.GetSelectRow(); // selected ROW
							var selRow = sheetObj.GetSelectCol(); // selected ROW
							var tpszValue = "";
							
							for(var k=0; k<consTpszArr.length; k++) {
								if(k==0) {
									tpszValue = consTpszArr[k];
								}else{
									tpszValue = tpszValue+","+consTpszArr[k];
								}
							}
							
							ComOpenPopup('EES_EQR_0059_POP.do?tpsz_value='+tpszValue+'&fm_yd_cd='+strFmYdCd+'&to_yd_cd='+strToYdCd+'&fm_etd_dt='+strFmEtdDt+'&to_eta_dt='+strToEtaDt, 1350, 650, 'setPopupParam', '0,0', true, false, selRow, selRow, 1);
						}else{
							return false;
						}
						  
					}
				} else {
					ComShowCodeMessage("EQR90151", "Row Add", repoPlnWeek,
							repoPlnNextWeek);
				}
				
			} else {
				ComShowCodeMessage("EQR90040");

			}
		}
		break;
	case IBDOWNEXCEL:
		sheetObj.Down2Excel({
			DownCols : makeHiddenSkipCol(sheetObj),
			SheetDesign : 1,
			Merge : 1
		});
		break;
	}
}

function doActionIBSheet2_1(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSAVE: // saving
		// if(validateForm(sheetObj,formObj,sAction))
		if (consTpszArr.length >= allTpszCnt) {
			var sRow = sheetObj.FindStatusRow("U");
			var arRow = sRow.split(";");
			var so_count = 0; // so send checked row
			var so_row = 0; // so send checked vol total
			var tab2SOAlert = "";
			tab2ArrSoAlert = "";
			sendToRefNo = "";
			if (sRow != "" && sRow != null) {
				// for(var i=0; i<arRow.length-1; i++) {
				for ( var i = 0; i < arRow.length; i++) {
					if (sheetObj.GetCellValue(arRow[i], "t2_so_iss_flg") == "1") {
						// item Rail
						if (sheetObj.GetCellValue(arRow[i], "t2_trsp_mod_cd") == "R") {
							if (sheetObj.GetCellValue(arRow[i], "t2_fm_yd_cd")
									.substr(0, 2) == "US"
									|| sheetObj.GetCellValue(arRow[i],
											"t2_fm_yd_cd").substr(0, 2) == "CA") {
								tab2SOAlert = "N";
								tab2ArrSoAlert = tab2ArrSoAlert + "|"
										+ tab2SOAlert;
							}
						}
						sendToRefNo = sendToRefNo + ","+ sheetObj.GetCellValue(arRow[i], "t2_ref_id");
						
						// so send row
						document.form.position_row2.value = arRow[i];
						so_count++;
						if (sheetObj.GetCellValue(arRow[i], "t2_co_cd") == "S") {
							so_row = eval(so_row)
									+ eval(sheetObj.GetCellValue(arRow[i],
											"t2_totalvol"));
						}
					}
				}
			}

			// if(sRow!="" && sRow!=null) {
			if (so_count > 0) {
				if (ComShowConfirm(ComGetMsg("EQR90054"))) {
					var selRow = sheetObj.GetSelectRow(); // selected ROW

					if ((sheetObj.GetCellValue(selRow, 't2_fm_chk_flg') != "Y")) {
						// ComShowCodeMessage("EQR90239",sheetObj.GetCellValue(selRow,
						// 't2_fm_yd_cd'));
						// return false;
					}

					if (validateForm(sheetObj, formObj, sAction, 2)) {
						formObj.so_action.value = "SEND"; // so send action
															// 샐행을 의미함.
						formObj.f_cmd.value = MULTI01;
						// sheetObj.DoSave("EES_EQR_0080GS.do?soFlag=Y",
						// eqrFormQryStr(formObj));
						var saveStr = sheetObj.GetSaveString();
						if (saveStr == "")
							return;
						var sXml = sheetObj.GetSaveData(
								"EES_EQR_0080GS.do?soFlag=Y", saveStr,
								eqrFormQryStr(formObj));
						sheetObj.LoadSaveData(sXml, {
							Sync : 1
						});
						t2sheet1_ChangeXml(sXml);
					}
				}
			} else {
				ComShowCodeMessage("EQR90044");
			}
		} else {
			ComShowCodeMessage("EQR90045", "S/O Send", "ALL");
		}
		break;
	}
}

function doActionIBSheet2_2(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSAVE: // saving
		var selRow = sheetObj.GetSelectRow(); // selected ROW
		var cancelOK = false;
		var totalvol = sheetObj.CellSearchValue(selRow, 't2_totalvol'); // total
																		// volume
		var co_cd = sheetObj.CellSearchValue(selRow, 't2_co_cd'); // company
																	// code - H,
																	// S
		var fm_rcc = sheetObj.CellSearchValue(selRow, 't2_fm_rcc'); // from rcc
																	// -
		var trspno_p = sheetObj.CellSearchValue(selRow, 't2_trspno_p');
		var trspno_d = sheetObj.CellSearchValue(selRow, 't2_trspno_d');
		var trspno_a = sheetObj.CellSearchValue(selRow, 't2_trspno_a');
		var trsp_sum = eval(trspno_p) + eval(trspno_d);
		if (sheetObj.GetCellValue(selRow, 't2_trsp_mod_cd') == 'W') { // WATER
			if (co_cd == 'H') { //
				if (trspno_p == trspno_a)
					cancelOK = true;
			} else { //
				if (fm_rcc == 'DEHAM') { // 구주 지역만 D까지 포함
					if (trsp_sum == totalvol)
						cancelOK = true;
				} else {
					if (trspno_p == totalvol)
						cancelOK = true;
				}
			}
		} else { // TRUCK, RAIL
			if (co_cd == 'H') { //
				if (trspno_p == totalvol)
					cancelOK = true;
			} else { //
				if (fm_rcc == 'DEHAM') {
					if (trsp_sum == totalvol)
						cancelOK = true;
				} else {
					if (trspno_p == totalvol)
						cancelOK = true;
				}
			}
		}
		if (sheetObj.GetCellValue(selRow, 't2_so_iss_flg') == "1") {
			if (cancelOK) {
				// checking user athority
				if (!userAreaCheck(sheetObj, "Cancel S/O Req.", "from", 2,
						selRow)) {
					// return false;
				}
				if (ComShowConfirm(ComGetMsg("EQR90055"))) {

					if ((sheetObj.GetCellValue(selRow, 't2_fm_chk_flg') != "Y")) {
						// ComShowCodeMessage("EQR90239",sheetObj.GetCellValue(selRow,
						// 't2_fm_yd_cd'));
						// return false;
					}

					if (validateForm(sheetObj, formObj, sAction, 2)) {
						sheetObj.SetCellValue(selRow, 't2_so_cancel_flag', "T");// so
																				// cancel
						// so cancel row
						document.form.position_row2.value = selRow;
						formObj.f_cmd.value = MULTI02;
						// sheetObj.DoSave("EES_EQR_0080GS.do",
						// eqrFormQryStr(formObj));
						var saveStr = sheetObj.GetSaveString();
						if (saveStr == "")
							return;
						var sXml = sheetObj.GetSaveData("EES_EQR_0080GS.do",
								saveStr, eqrFormQryStr(formObj));
						sheetObj.LoadSaveData(sXml, {
							Sync : 1
						});
						t2sheet1_ChangeXml(sXml);
					}
				}
			} else { // cancelOk=false
				ComShowCodeMessage("EQR90142");
				// rollback
				sheetObj.SetCellValue(selRow, 't2_so_iss_flg', sheetObj
						.GetCellValue(selRow, 't2_so_iss_flg'), 0);
				sheetObj.SetCellValue(selRow, 't2_so_cancel_flag', sheetObj
						.GetCellValue(selRow, 't2_so_cancel_flag'), 0);
			}
		} else {
			ComShowCodeMessage("EQR90047");
			// rollback
			sheetObj.SetCellValue(selRow, 't2_so_iss_flg', sheetObj
					.GetCellValue(selRow, 't2_so_iss_flg'), 0);
			sheetObj.SetCellValue(selRow, 't2_so_cancel_flag', sheetObj
					.GetCellValue(selRow, 't2_so_cancel_flag'), 0);
		}
		break;
	}
}

function doActionIBSheet2_3(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSAVE: // saving
		if (consTpszArr.length >= allTpszCnt) {
			// checking repo bkg checked(one or multi)
			/*var sRow = sheetObj.FindStatusRow("U");
			var arRow = sRow.split(";");
			var repobkg_count = 0;
			// var so_count = 0; // so send checked row
			// var so_row = 0; // so send checked vol total
			// SO SEND checking
			if (sRow != "" && sRow != null) {
				// for(var i=0; i<arRow.length-1; i++) {
				for ( var i = 0; i < arRow.length; i++) {
					if (sheetObj.GetCellValue(arRow[i], "t2_repobkg_flag") == "T") {
						// update row
						document.form.position_row2.value = arRow[i];
						repobkg_count++;
					}
				}
			}*/
			
			
			var strBkgChk = "";
			var strBkgNo = "";
			var repobkg_count = 0;
			var delRow = 0;
			var selRow = 0;
			for ( var i = 2; i < sheetObj.RowCount(); i++) {
				strBkgChk = sheetObj.GetCellValue(i,"t2_repo_mty_bkg_flg");
				strBkgNo = sheetObj.GetCellValue(i,"t2_bkg_no");
				//sheetObj.GetCellValue(i, "t2_repobkg_flag")>> Mty Repo BKG Check하면 T로 Set이 되어진다.
				//document.form.position_row2.value >> 체크된 row 위치표시
				if(strBkgNo == "" && strBkgChk == "1") {
					document.form.position_row2.value = i;
					selRow = i;
					repobkg_count++;
				}
				
			}
			
			// BKG CRE 로직 start
			if (repobkg_count == 1) {				
				//var selRow = sheetObj.GetSelectRow(); // selected ROW
				
				var fmYdLoc = sheetObj.GetCellValue(selRow, 't2_fm_yd_cd');
				var toYdLoc = sheetObj.GetCellValue(selRow, 't2_to_yd_cd');
				var volTotal = sheetObj.GetCellValue(selRow, 't2_totalvol');
				var vCode = "";
				var vCodeNm = "";
				
				formObj.f_cmd.value=SEARCH01;
				var intgCdId='CD30101';
				var param="&intgCdId="+intgCdId;
				var xml=sheetObj.GetSearchData("EES_CIM_COMGS.do", FormQueryString(formObj)+param);
				
				if (xml != "") {
					var arrStrCode=ComGetEtcData(xml, "code_nm");
					var arrCode = arrStrCode.split("@");
					var strAllCode="";
					var arrAllCode="";
					for(var i=0;i<arrCode.length;i++) {						
						strAllCode = arrCode[i].split("@");
						for(var j=0;j<strAllCode.length;j++) {
							arrAllCode = strAllCode[j].split("|");
							strCode = arrAllCode[0];
							strCodeNm = arrAllCode[1];
							
							if(i == 0) {
								vCode =  strCode;
								vCodeNm =  strCodeNm; 
							}else{
								vCode = vCode + "|" + strCode; 
								vCodeNm = vCodeNm + "|" + strCodeNm; 
							}
						}
					}
				}
				var chkVolRtn = chkLocationVol(vCode,vCodeNm,fmYdLoc,toYdLoc,volTotal);
				if(chkVolRtn == false) {
					return false;
				}				
				
				if (ComShowConfirm(ComGetMsg("EQR90053"))) {
					if ((sheetObj.GetCellValue(selRow, 't2_fm_chk_flg') != "Y")) {
						// ComShowCodeMessage("EQR90239",sheetObj.GetCellValue(selRow,
						// 't2_fm_yd_cd'));
						// return false;
					}

					if (validateForm(sheetObj, formObj, sAction, 2)) {
						for ( var i = 2; i < sheetObj.RowCount(); i++) {
							if(selRow != i) {
								sheetObj.SetCellValue(i,"t2_ibflag","R");
							}
							
						}						
						formObj.f_cmd.value = MULTI03;
						// sheetObj.DoSave("EES_EQR_0080GS.do?soFlag=Y",
						// eqrFormQryStr(formObj));
						var saveStr = sheetObj.GetSaveString();
						if (saveStr == "")
							return;
						var sXml = sheetObj.GetSaveData(
								"EES_EQR_0080GS.do?soFlag=Y", saveStr,
								eqrFormQryStr(formObj));
						
						sheetObj.LoadSaveData(sXml, {
							Sync : 1
						});
						t2sheet1_ChangeXml(sXml);
					}
				}
			} else if (repobkg_count > 1) {
				ComShowCodeMessage("EQR90152", "Repo BKG Cre.");
				return false;
			} else {
				ComShowCodeMessage("EQR90123");
			}
		} else {
			ComShowCodeMessage("EQR90045", "Repo BKG", "ALL");
		}
		break;
	}
}

function doActionIBSheet2_4(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBINSERT:
		var yyyyww = formObj.yyyyww.value;
		var seq = formObj.seq.value;
		if (formObj.nowWeek.value > formObj.yyyyww.value) {
			// row add 비활성
			// ComShowCodeMessage("EQR01144");
			// Modify 20150117 추후에 아래 주석 제거
			// return false;
		}

		if (formObj.dtrb_flg.value == 'Y' && yyyyww.length == 6
				&& seq.length == 4) {
			var selRow = sheetObj.GetSelectRow(); // selected ROW
			if (sheetObj.RowCount() == 0
					|| sheetObj.GetCellValue(selRow, "t2_num") == 1) {
				// var Row=sheetObj.DataInsert(selRow);
				var Row = sheetObj.DataInsert();
				// -------------- color modifying
				// [START]-----------------------------------------
				// PLAN ROW modifying
				sheetObj.SetRowBackColor(Row, "#CBEFEA");
				// inserting CELL original color
				/*
				 * sheetObj.SetCellBackColor(Row,
				 * 't2_pln_yrwk',sheetObj.GetDataBackColor());
				 * sheetObj.SetCellBackColor(Row,
				 * 't2_trsp_mod_cd',sheetObj.GetDataBackColor());
				 * sheetObj.SetCellBackColor(Row,
				 * 't2_fm_yd_cd',sheetObj.GetDataBackColor());
				 * sheetObj.SetCellBackColor(Row,
				 * 't2_fm_etd_dt',sheetObj.GetDataBackColor());
				 * sheetObj.SetCellBackColor(Row,
				 * 't2_to_yd_cd',sheetObj.GetDataBackColor());
				 * sheetObj.SetCellBackColor(Row,
				 * 't2_to_eta_dt',sheetObj.GetDataBackColor());
				 */
				// -------------- color modifying
				// [END]-----------------------------------------
				sheetObj.SetCellValue(Row, 't2_repo_pln_id', repoword
						+ document.form.yyyyww.value + repoweek
						+ document.form.seq.value, 0);

				sheetObj.SetCellEditable(Row, "t2_pln_yrwk", 0);
				sheetObj.SetCellValue(Row, "t2_pln_yrwk", yyyyww, 0);

				sheetObj.InitCellProperty(Row, "t2_co_cd", {
					Type : "Text"
				});
				sheetObj.SetCellEditable(Row, "t2_co_cd", 0);
				sheetObj.SetCellValue(Row, "t2_co_cd", "");
				sheetObj.SetCellValue(Row, "t2_div", "Plan");
				sheetObj.SetCellEditable(Row, "t2_trsp_mod_cd", 1);
				// sheetObj.InitCellProperty(Row, "t2_fm_etd_dt",{
				// Type:"Text",Align:"Center",Format:"",PointCount:0,EditLen:6}
				// );
				// sheetObj.InitCellProperty(Row, "t2_to_eta_dt",{
				// Type:"Text",Align:"Center",Format:"",PointCount:0,EditLen:6}
				// );

				sheetObj.InitCellProperty(Row, "t2_fm_etd_dt", {
					Type : "Text",
					Align : "Center",
					Format : "dfNone",
					PointCount : 0,
					EditLen : 6
				});
				sheetObj.InitCellProperty(Row, "t2_to_eta_dt", {
					Type : "Text",
					Align : "Center",
					Format : "dfNone",
					PointCount : 0,
					EditLen : 6
				});
				sheetObj.SetCellValue(Row, "t2_fm_etd_dt", yyyyww, 0);

				formObj.f_cmd.value = SEARCH03;
				var sXml = sheetObj.GetSearchData("EES_EQR_0059GS4.do",
						FormQueryString(formObj));
				var sEta = ComGetEtcData(sXml, "strToEta");
				formObj.hidToEta.value = sEta;
				sheetObj.SetCellValue(Row, "t2_to_eta_dt", sEta);

				sheetObj.SetCellEditable(Row, "t2_vvd", 0);
				sheetObj.SetCellEditable(Row, "t2_vsl_lane_cd", 0);
				sheetObj.SetCellEditable(Row, "t2_eq_repo_purp_cd", 0);
				sheetObj.SetCellValue(Row, "t2_eq_repo_purp_cd", "");
				sheetObj.SetCellEditable(Row, "t2_repo_pln_fb_rsn_cd", 0);
				sheetObj.SetCellValue(Row, "t2_repo_pln_fb_rsn_cd", "");
				sheetObj.SetCellEditable(Row, "t2_repo_pln_fb_rmk", 0);
				sheetObj.SetCellValue(Row, "t2_sortnum", "1", 0); // Plan
																	// Rowsetting
				sheetObj.SetCellValue(Row, "t2_num", "1", 0);// normal
																// rowsetting
				sheetObj.SetCellValue(Row, "t2_newplan", "T", 0);// add plan
				for ( var i = 0; i < consTpszArr.length; i++) {
					sheetObj.SetCellEditable(Row, "t2_vol" + consTpszArr[i], 1);
				}
			}
		} else {
			ComShowCodeMessage("EQR90124");
			return false;
		}
		break;
	}
}

function doActionIBSheet3(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: // retrieve
		if (document.form.fmToAt[1].checked) {
			ComShowCodeMessage("EQR90125", tabName[2]);
		} else {
			if (validateForm(sheetObj, formObj, sAction, 3)) {
				document.form.dataselect2[0].checked = true;
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(1);
				setTimeout(function() {
					t3sheet1.SetVisible(0);
					t3sheet1.RemoveAll();
					sheetObjects[2] = t3sheet1.Reset();// keyfied
					ComConfigSheet(t3sheet1);
					initSheet(t3sheet1, 3, comboObjects[1].GetSelectText());
					ComEndConfigSheet(t3sheet1);
					t3sheet1.SetWaitImageVisible(1);
					formObj.f_cmd.value = SEARCHLIST;
					// t3sheet1.DoSearch("EES_EQR_0081GS.do",
					// eqrFormQryStr(formObj), {Sync:2} );
					var sXml = t3sheet1.GetSearchData("EES_EQR_0081GS.do",
							eqrFormQryStr(formObj));
					t3sheet1.LoadSearchData(sXml, {
						Sync : 1
					});
					t3sheet1_ChangeXml(sXml);
					// formObj.t3_plnWeek.value=sheetObj.GetEtcData("t3_plnWeek");
					// formObj.t3_plnNextWeek.value=sheetObj.GetEtcData("t3_plnNextWeek");
					ComEtcDataToForm(formObj, t3sheet1);
					sheetObj.SetVisible(1);
					sheetObj.SetExtendLastCol(0);
					formObj.pre_repo_rmk.value = formObj.repo_rmk.value;

				}, 100);
			}
		}
		break;
	case IBSAVE: // saving
		if (validateForm(sheetObj, formObj, sAction, 3)) {
			var tRow = sheetObj.FindStatusRow("I|U|D");
			var arRow = tRow.split(";");
			var flag = true;
			if (tRow != "" && tRow != null) {
				// for(var i=0; i<arRow.length-1; i++) {
				for ( var i = 0; i < arRow.length; i++) {
					if (sheetObj.GetCellValue(arRow[i], "t3_sortnum") == "1") {
						sheetObj.SetColProperty(0, "t3_vndr", {
							KeyField : 0
						});
						sheetObj.SetColProperty(0, "t3_fm_loc_dt", {
							KeyField : 0
						});
						sheetObj.SetColProperty(0, "t3_to_loc_dt", {
							KeyField : 0
						});
						sheetObj.SetCellValue(arRow[i], 't3_vndr', "OOO");
						sheetObj.SetCellValue(arRow[i], 't3_vndr_seq', "XX");
						sheetObj.SetCellValue(arRow[i], 't3_vndr_cnt_cd', "XX");
						sheetObj.SetCellValue(arRow[i], 't3_fm_loc_dt', "",0);
						sheetObj.SetCellValue(arRow[i], 't3_to_loc_dt', "",0);
						
					} else {
						sheetObj.SetColProperty(0, "t3_vndr", {
							KeyField : 0
						});
						sheetObj.SetColProperty(0, "t3_fm_loc_dt", {
							KeyField : 1
						});
						sheetObj.SetColProperty(0, "t3_to_loc_dt", {
							KeyField : 1
						});
					}
				}
			}
			var sRow = sheetObj.FindStatusRow("I|U|D");
			var arRow = sRow.split(";");
			var flag = true;
			if (sRow != "" && sRow != null) {
				// for(var i=0; i<arRow.length-1; i++) {
				for ( var i = 0; i < arRow.length; i++) {
					// in case of EXECUTE VOL=0 && PLAN VOL!=0, pass=F &
					// background color = red
					for ( var j = 0; j < consTpszArr.length; j++) {
						if (sheetObj.GetCellValue(arRow[i], "t3_vol"
								+ consTpszArr[j]) == '0') {
							// retrieving for plan row
							var week = sheetObj.GetCellValue(arRow[i],
									"t3_pln_yrwk");
							var item = sheetObj.GetCellValue(arRow[i],
									"t3_onf_hir_div_cd");
							var fm_ecc = sheetObj.GetCellValue(arRow[i],
									"t3_fm_ecc");
							var to_ecc = sheetObj.GetCellValue(arRow[i],
									"t3_to_ecc");
							var planVol = 0;
							var planRow = 0;
							if (item == "O")
								fm_ecc = "";
							else
								to_ecc = "";
							for ( var k = 0; k < sheetObj.RowCount(); k++) {
								if (sheetObj.GetCellValue(k, "t3_sortnum") == 1
										&& sheetObj.GetCellValue(k, "t3_num") == 1
										&& sheetObj.GetCellValue(k,
												"t3_pln_yrwk") == week
										&& sheetObj.GetCellValue(k,
												"t3_onf_hir_div_cd") == item
										&& sheetObj
												.GetCellValue(k, "t3_fm_ecc") == fm_ecc
										&& sheetObj
												.GetCellValue(k, "t3_to_ecc") == to_ecc) {
									planRow = k;
									break;
								}
							}
							if (planRow != 0) {
								planVol = eval(sheetObj.GetCellValue(planRow,
										"t3_vol" + consTpszArr[j]));
								if (planVol > 0) {
									sheetObj.SetCellValue(arRow[i], "t3_pass"
											+ consTpszArr[j], 'F', 0);
									// sheetObj.SetCellFontColor(arRow[i],"t3_vol"+consTpszArr[j],"#F1541F");
								}
							}
						}
					}
					// --------- cheking each flag, final flag
					var passCount = 0;
					for ( var z = 0; z < consTpszArr.length; z++) {
						if (sheetObj.GetCellValue(arRow[i], "t3_pass"
								+ consTpszArr[z]) == 'F') {
							passCount++;
							break;
						}
					}
					if (passCount > 0) {
						sheetObj
								.SetCellValue(arRow[i], "t3_pass_final", 'F', 0);
					} else {
						sheetObj.SetCellValue(arRow[i], "t3_pass_final", '', 0);
					}
					if (sheetObj.GetCellValue(arRow[i], "t3_vndr_seq") == ""
							|| sheetObj
									.GetCellValue(arRow[i], "t3_vndr_cnt_cd") == "") {
						// ComShowMessage("LINE "+(arRow[i]-1)+ " LSR info를
						// optional해 주세요 ! ");
						/*ComShowCodeMessage("EQR90126", (arRow[i] - 1), "LSR");
						flag = false;
						break;*/
					} else if (sheetObj.GetCellValue(arRow[i], "t3_fm_yd_cd").length < 7
							&& sheetObj.GetCellValue(arRow[i], "t3_sortnum") == "2") {
						ComShowCodeMessage("EQR90126", (arRow[i] - 1),
								"FROM LOC");
						flag = false;
						break;
					} else if (sheetObj.GetCellValue(arRow[i], "t3_to_yd_cd").length < 7
							&& sheetObj.GetCellValue(arRow[i], "t3_sortnum") == "2") {
						ComShowCodeMessage("EQR90126", (arRow[i] - 1), "TO LOC");
						flag = false;
						break;
					}
				}
			}

			if (flag) {
				if (sRow != "" && sRow != null) {
					formObj.f_cmd.value = MULTI;
					// sheetObj.DoSave("EES_EQR_0081GS.do",
					// eqrFormQryStr(formObj));
					// var saveStr = sheetObj.GetSaveString();

					var saveStr = sheetObj.GetSaveString();
					if (saveStr == "")
						return;

					var sXml = sheetObj.GetSaveData("EES_EQR_0081GS.do",
							saveStr, eqrFormQryStr(formObj));
					sheetObj.LoadSaveData(sXml, {
						Sync : 1
					});
					t3sheet1_ChangeXml(sXml);
				}
			}

			if (formObj.pre_repo_rmk.value != formObj.repo_rmk.value) {
				ComShowConfirm(ComGetMsg("EQR90236"));
				formObj.f_cmd.value = MULTI03;
				ComOpenWait(true);
				var sXml = sheetObj.GetSaveData("EES_EQR_0012GS.do",
						eqrFormQryStr(formObj));
				ComOpenWait(false);
				sheetObj.LoadSaveData(sXml, {
					Sync : 1
				});
				formObj.pre_repo_rmk.value = formObj.repo_rmk.value;
				ComEtcDataToForm(document.form, sheetObj);
				// document.form.checksave.value ="Y";
				// ComShowMessage(ComGetMsg("EQR90106")); // ??옣?꾨즺
			}

		}
		break;
	case IBINSERT:
		if (sheetObj.RowCount() > 0) {
			var selRow = sheetObj.GetSelectRow(); // selected ROW
			var sourceWeek = sheetObj.GetCellValue(selRow, 't3_pln_yrwk');
			var repoPlnWeek = formObj.t3_plnWeek.value;
			var repoPlnNextWeek = formObj.t3_plnNextWeek.value;
			// in case of Plan, Execution, normal Row, copying
			if ((sheetObj.GetCellValue(selRow, 't3_sortnum') == 1 || sheetObj
					.GetCellValue(selRow, 't3_sortnum') == 2)
					&& sheetObj.GetCellValue(selRow, 't3_num') == 1
					&& sheetObj.GetCellValue(selRow, 't3_newplan') != "T") {
				// in case of repo plan id, +1,+2 week, executable
				if (sourceWeek == repoPlnWeek || sourceWeek == repoPlnNextWeek) {
					if (consTpszArr.length < allTpszCnt) {
						ComShowCodeMessage("EQR90045", "Row Add", "ALL");
						return false;
					}

					// checking user athority
					var direction = null;
					if (sheetObj.GetCellValue(selRow, "t3_onf_hir_div_cd") == "F")
						direction = "from";
					else
						direction = "to";
					if (!userAreaCheck(sheetObj, "Row Add", direction, "3",
							selRow)) {
						// return false;
					}

					if ((sheetObj.GetCellValue(selRow, 't3_fm_chk_flg') != "Y")
							&& (sheetObj.GetCellValue(selRow, 't3_to_chk_flg') != "Y")) {
						var message = "";
						if (sheetObj.GetCellValue(selRow, 't3_fm_yd_cd') != "") {
							message = sheetObj.GetCellValue(selRow,
									't3_fm_yd_cd');
						}

						if (sheetObj.GetCellValue(selRow, 't3_to_yd_cd') != "") {
							if (message != "") {
								message = message
										+ ","
										+ sheetObj.GetCellValue(selRow,
												't3_to_yd_cd')
							} else {
								message = sheetObj.GetCellValue(selRow,
										't3_to_yd_cd')
							}
						}
						// ComShowCodeMessage("EQR90241",message);
						// return false;
					}

					// var Row=sheetObj.DataInsert(selRow);
					var Row = sheetObj.DataInsert();
					sheetObj.SetRowBackColor(Row, "#F7FB59");
					var ecc_info = null;
					if (sheetObj.GetCellValue(selRow, "t3_onf_hir_div_cd") == "F")
						ecc_info = sheetObj.GetCellValue(selRow, "t3_fm_ecc");
					else
						ecc_info = sheetObj.GetCellValue(selRow, "t3_to_ecc");
					sheetObj.SetCellValue(Row, "t3_pln_yrwk", sheetObj
							.GetCellValue(selRow, "t3_pln_yrwk"), 0);// week
																		// copying
					sheetObj.SetCellValue(Row, "t3_pln_seq", sheetObj
							.GetCellValue(selRow, "t3_pln_seq"), 0);// pln_seq
																	// copying
					sheetObj.SetCellValue(Row, 't3_week_fromdate', sheetObj
							.GetCellValue(selRow, 't3_week_fromdate'), 0);// from
																			// date
																			// copying
					sheetObj.SetCellValue(Row, 't3_week_todate', sheetObj
							.GetCellValue(selRow, 't3_week_todate'), 0);// to
																		// date
																		// copying
					sheetObj.SetCellValue(Row, 't3_week_maxdate', sheetObj
							.GetCellValue(selRow, 't3_week_maxdate'), 0);// to
																			// date
																			// copying
					sheetObj.SetCellValue(Row, "t3_div", "Execution", 0);// Execution
																			// setting
					sheetObj.SetCellValue(Row, "t3_onf_hir_div_cd", sheetObj
							.GetCellValue(selRow, "t3_onf_hir_div_cd"), 0);// item
																			// copying
					// sheetObj.CellValue2(Row, "t3_fm_yd_cd") = ecc_info; //
					// from loc copying
					// sheetObj.CellValue2(Row, "t3_to_yd_cd") = ecc_info; // to
					// loc copying
					// sheetObj.CellValue2(Row, "t3_fm_loc_dt") =
					// formObj.localDate.value; // ETD info
					// sheetObj.CellValue2(Row, "t3_to_loc_dt") =
					// formObj.localDate.value; // ETA info
					sheetObj.SetCellValue(Row, "t3_repo_pln_id", sheetObj
							.GetCellValue(selRow, "t3_repo_pln_id"), 0);// repo_plan_id
																		// copying
					sheetObj.SetCellValue(Row, "t3_repo_pln_fb_rsn_cd", "", 0);// Reason
																				// resetting
					sheetObj.SetCellEditable(Row, "t3_repo_pln_fb_rmk", 0);// Reason
																			// Remark
																			// modifying
																			// disable
					sheetObj.SetCellEditable(Row, "t3_lease_term", 0);// lease_term
																		// modifying
																		// disable
					// sheetObj.InitCellProperty(Row, "t3_so_iss_flg",
					// dtCheckBox); // check box
					sheetObj.SetCellValue(Row, "t3_cntrimage", "1", 0);// cntr
																		// image
																		// initializing
					// no support[check again]CLT sheetObj.CellValue2(Row,
					// "t3_sortnum")="2"; // Execution Rowsetting
					sheetObj.SetCellValue(Row, "t3_sortnum", "2", 0);// Execution
																		// Rowsetting
					sheetObj.SetCellValue(Row, "t3_num", "1", 0);// normal
																	// rowsetting
					// Item Off-Hire인 경우는 vol을 inserting할수 없다. ( cntr no로만 제어가능)
					if (sheetObj.GetCellValue(Row, "t3_onf_hir_div_cd") == "F") {
						for ( var i = 0; i < consTpszArr.length; i++) {
							sheetObj.SetCellEditable(Row, "t3_vol"
									+ consTpszArr[i], 1);
						}
					}
					sheetObj.SetCellValue(Row, "t3_fm_rcc", sheetObj
							.GetCellValue(selRow, "t3_fm_rcc"), 0);// fm rcc
																	// copying
					sheetObj.SetCellValue(Row, "t3_to_rcc", sheetObj
							.GetCellValue(selRow, "t3_to_rcc"), 0);// to rcc
																	// copying
					sheetObj.SetCellValue(Row, "t3_fm_lcc", sheetObj
							.GetCellValue(selRow, "t3_fm_lcc"), 0);// fm lcc
																	// copying
					sheetObj.SetCellValue(Row, "t3_to_lcc", sheetObj
							.GetCellValue(selRow, "t3_to_lcc"), 0);// to lcc
																	// copying
					sheetObj.SetCellValue(Row, "t3_fm_ecc", sheetObj
							.GetCellValue(selRow, "t3_fm_ecc"), 0);// fm ecc
																	// copying
					sheetObj.SetCellValue(Row, "t3_to_ecc", sheetObj
							.GetCellValue(selRow, "t3_to_ecc"), 0);// to ecc
																	// copying
					// insert row
					document.form.position_row3.value = Row;
					if (sheetObj.GetCellValue(Row, "t3_onf_hir_div_cd") == "F") { // OFF
																					// HIRE
						// FROM YARD automatically retreive
						// var f_cmd=SEARCHLIST05; // MDM_YARD
						var f_cmd = SEARCHLIST05; // MDM_YARD
						// sheetObj.DoRowSearch(
						// ROW,row=Row&searchword=ecc_info&colname=t3_fm_yd_cd&f_cmd=f_cmd
						// );
						// sheetObj.DoRowSearch2("EES_LOCYARD_COMMON.do"
						// ,"row="+Row+"&searchword="+ecc_info+"&colname=t3_to_yd_cd&f_cmd="+f_cmd);
						/*
						 * var sXml =
						 * sheetObj.GetSearchData("EES_LOCYARD_COMMON.do",
						 * "row="+Row+"&searchword="+ecc_info+"&colname=t3_fm_yd_cd&f_cmd="+f_cmd);
						 * changeViewCombo(sheetObj, sXml);
						 */
						// ECC Yard List로 변경하기 위하여 이벤트 삭제 By Mark 2015.09.01
						sheetObj.InitCellProperty(Row, "t3_fm_yd_cd", {
							Type : "Combo"
						});
						sheetObj.InitCellProperty(Row, "t3_to_yd_cd", {
							Type : "Combo"
						});						
						sheetObj.DoRowSearch2("EES_LOCYARD_COMMON.do", "row="
								+ Row + "&searchword=" + ecc_info
								+ "&colname=t3_fm_yd_cd&f_cmd=" + f_cmd);

						sheetObj.SetCellValue(Row, "t3_fm_yd_cd", "", 0);
						sheetObj.DoRowSearch2("EES_LOCYARD_COMMON.do", "row="
								+ Row + "&searchword=" + ecc_info
								+ "&colname=t3_to_yd_cd&f_cmd=" + f_cmd);

						sheetObj.SetCellValue(Row, "t3_to_yd_cd", "", 0);						
					} else {
						// TO YARD automatically retreive
						var f_cmd = SEARCHLIST05; // MDM_YARD
						// sheetObj.DoRowSearch(
						// ROW,row=Row&searchword=ecc_info&colname=t3_to_yd_cd&f_cmd=f_cmd
						// );
						// sheetObj.DoRowSearch2("EES_LOCYARD_COMMON.do"
						// ,"row="+Row+"&searchword="+ecc_info+"&colname=t3_to_yd_cd&f_cmd="+f_cmd);
						// var sXml =
						// sheetObj.GetSearchData("EES_LOCYARD_COMMON.do",
						// "row="+Row+"&searchword="+ecc_info+"&colname=t3_to_yd_cd&f_cmd="+f_cmd);
						// changeViewCombo(sheetObj, sXml);
						sheetObj.InitCellProperty(Row, "t3_fm_yd_cd", {
							Type : "Combo"
						});
						sheetObj.InitCellProperty(Row, "t3_to_yd_cd", {
							Type : "Combo"
						});						
						sheetObj.DoRowSearch2("EES_LOCYARD_COMMON.do", "row="
								+ Row + "&searchword=" + ecc_info
								+ "&colname=t3_fm_yd_cd&f_cmd=" + f_cmd);

						sheetObj.SetCellValue(Row, "t3_fm_yd_cd", "", 0);
						sheetObj.DoRowSearch2("EES_LOCYARD_COMMON.do", "row="
								+ Row + "&searchword=" + ecc_info
								+ "&colname=t3_to_yd_cd&f_cmd=" + f_cmd);

						sheetObj.SetCellValue(Row, "t3_to_yd_cd", "", 0);	
					}

					var f_cmd = SEARCHLIST06;
					sheetObj.InitCellProperty(Row, "t3_vndr", {
						Type : "Combo"
					});
					sheetObj.DoRowSearch2("EES_VENDOR_COMMON.do", "row=" + Row
							+ "&searchword=&colname=t3_vndr&f_cmd=" + f_cmd);

					var yyyyww = formObj.yyyyww.value;
					var f_cmd = SEARCHLIST17;
					// ETD retrieve
					sheetObj
							.DoRowSearch2(
									"EES_WEEKDATEPERIOD.do",
									"row="
											+ Row
											+ "&searchword="
											+ yyyyww
											+ "&colname1=t3_week_fromdate&colname2=t3_week_todate&f_cmd="
											+ f_cmd);
					// ETA retrieve
					sheetObj
							.DoRowSearch2(
									"EES_WEEKDATEPERIOD.do",
									"row="
											+ Row
											+ "&searchword="
											+ yyyyww
											+ "&colname1=t3_week_fromdate&colname2=t3_week_maxdate&division=WIDE&f_cmd="
											+ f_cmd);
					sheetObj.SetCellValue(Row, "t3_fm_loc_dt", sheetObj
							.GetCellValue(Row, "t3_week_fromdate"), 0);
					sheetObj.SetCellValue(Row, "t3_to_loc_dt", sheetObj
							.GetCellValue(Row, "t3_week_todate"), 0);

				} else {
					ComShowCodeMessage("EQR90151", "Row Add", repoPlnWeek,
							repoPlnNextWeek);
				}
			} else {
				ComShowCodeMessage("EQR90040");
			}
		}
		break;
	case IBDOWNEXCEL:
		sheetObj.Down2Excel({
			DownCols : makeHiddenSkipCol(sheetObj),
			SheetDesign : 1,
			Merge : 1
		});
		break;
	}
}

function doActionIBSheet3_1(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSAVE: // saving
		// if(validateForm(sheetObj,formObj,sAction))
		if (consTpszArr.length >= allTpszCnt) {
			var sRow = sheetObj.FindStatusRow("U");
			var arRow = sRow.split(";");
			var so_count = 0; // so send checked row
			var so_row = 0; // so send checked vol total
			var so_action_row = 0; // so send
			sendToRefNo = "";
			if (sRow != "" && sRow != null) {
				// for(var i=0; i<arRow.length-1; i++) {
				for ( var i = 0; i < arRow.length; i++) {
					if (sheetObj.GetCellValue(arRow[i], "t3_so_iss_flg") == "1"
							|| sheetObj.GetCellValue(arRow[i],
									"t3_noso_iss_flg") == "1") {
						
						sendToRefNo = sendToRefNo + ","+ sheetObj.GetCellValue(arRow[i], "t3_ref_id");
						// so send row
						document.form.position_row3.value = arRow[i];
						so_count++;
						if (sheetObj.GetCellValue(arRow[i], "t3_co_cd") == "S"
								&& sheetObj.GetCellValue(arRow[i],
										"t3_so_iss_flg") == "1") {
							so_row = eval(so_row)
									+ eval(sheetObj.GetCellValue(arRow[i],
											"t3_totalvol"));
						}
						if (sheetObj.GetCellValue(arRow[i], "t3_so_iss_flg") == "1") {
							so_action_row++;
						}
					}
				}
			}
			// if(sRow!="" && sRow!=null) {
			if (so_count > 0) {
				if (ComShowConfirm(ComGetMsg("EQR90054"))) {

					var selRow = sheetObj.GetSelectRow(); // selected ROW

					if ((sheetObj.GetCellValue(selRow, 't3_fm_chk_flg') != "Y")
							&& (sheetObj.GetCellValue(selRow, 't3_to_chk_flg') != "Y")) {
						var message = "";
						if (sheetObj.GetCellValue(selRow, 't3_fm_yd_cd') != "") {
							message = sheetObj.GetCellValue(selRow,
									't3_fm_yd_cd');
						}

						if (sheetObj.GetCellValue(selRow, 't3_to_yd_cd') != "") {
							if (message != "") {
								message = message
										+ ","
										+ sheetObj.GetCellValue(selRow,
												't3_to_yd_cd')
							} else {
								message = sheetObj.GetCellValue(selRow,
										't3_to_yd_cd')
							}
						}
						// ComShowCodeMessage("EQR90241",message);
						// return false;
					}

					if (validateForm(sheetObj, formObj, sAction, 3)) {
						if (so_action_row > 0)
							formObj.so_action.value = "SEND";
						formObj.f_cmd.value = MULTI01;
						// sheetObj.DoSave("EES_EQR_0081GS.do?soFlag=Y",
						// eqrFormQryStr(formObj));
						var saveStr = sheetObj.GetSaveString();
						if (saveStr == "")
							return;
						var sXml = sheetObj.GetSaveData(
								"EES_EQR_0081GS.do?soFlag=Y", saveStr,
								eqrFormQryStr(formObj));
						sheetObj.LoadSaveData(sXml, {
							Sync : 1
						});
						t3sheet1_ChangeXml(sXml);
					}
				}
			} else {
				ComShowCodeMessage("EQR90044");
			}
		} else {
			ComShowCodeMessage("EQR90045", "S/O Send", "ALL");
		}
		break;
	}
}

function doActionIBSheet3_2(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSAVE: // saving
		var selRow = sheetObj.GetSelectRow(); // selected ROW
		var cancelOK = false;
		var totalvol = sheetObj.CellSearchValue(selRow, 't3_totalvol'); // total
																		// volume
		var co_cd = sheetObj.CellSearchValue(selRow, 't3_co_cd'); // company
																	// code - H,
																	// S
		var fm_rcc = sheetObj.CellSearchValue(selRow, 't3_fm_rcc'); // from rcc
																	// -
		var trspno_p = sheetObj.CellSearchValue(selRow, 't3_trspno_p'); // TRSP_SO_STS_CD='P'
		var trspno_d = sheetObj.CellSearchValue(selRow, 't3_trspno_d'); // TRSP_SO_STS_CD='D'
		var trsp_sum = eval(trspno_p) + eval(trspno_d);
		if (co_cd == 'H') { //
			if (trspno_p == totalvol)
				cancelOK = true;
		} else { //
			if (fm_rcc == 'DEHAM') {
				if (trsp_sum == totalvol)
					cancelOK = true;
			} else {
				if (trspno_p == totalvol)
					cancelOK = true;
			}
		}
		if ((sheetObj.GetCellValue(selRow, 't3_so_iss_flg') == "1" && cancelOK)
				|| sheetObj.GetCellValue(selRow, 't3_noso_iss_flg') == "1") {
			if (ComShowConfirm(ComGetMsg("EQR90055"))) {

				if ((sheetObj.GetCellValue(selRow, 't3_fm_chk_flg') != "Y")
						&& (sheetObj.GetCellValue(selRow, 't3_to_chk_flg') != "Y")) {
					var message = "";
					if (sheetObj.GetCellValue(selRow, 't3_fm_yd_cd') != "") {
						message = sheetObj.GetCellValue(selRow, 't3_fm_yd_cd');
					}

					if (sheetObj.GetCellValue(selRow, 't3_to_yd_cd') != "") {
						if (message != "") {
							message = message
									+ ","
									+ sheetObj.GetCellValue(selRow,
											't3_to_yd_cd')
						} else {
							message = sheetObj.GetCellValue(selRow,
									't3_to_yd_cd')
						}
					}
					// ComShowCodeMessage("EQR90241",message);
					// return false;
				}

				if (validateForm(sheetObj, formObj, sAction, 3)) {
					// sheetObj.RowStatus(selRow) = "U";
					sheetObj.SetCellValue(selRow, 't3_so_cancel_flag', "T");
					// so cancel row
					document.form.position_row3.value = selRow;
					formObj.f_cmd.value = MULTI02;
					// sheetObj.DoSave("EES_EQR_0081GS.do",
					// eqrFormQryStr(formObj));
					var saveStr = sheetObj.GetSaveString();
					if (saveStr == "")
						return;
					var sXml = sheetObj.GetSaveData("EES_EQR_0081GS.do",
							saveStr, eqrFormQryStr(formObj));
					sheetObj.LoadSaveData(sXml, {
						Sync : 1
					});
					t3sheet1_ChangeXml(sXml);
				}
			}
		} else {
			if (sheetObj.GetCellValue(selRow, 't3_so_iss_flg') == "1"
					&& !cancelOK) {
				ComShowCodeMessage("EQR90142");
			} else {
				ComShowCodeMessage("EQR90047");
			}
			// rollback
			sheetObj.SetCellValue(selRow, 't3_so_iss_flg', sheetObj
					.GetCellValue(selRow, 't3_so_iss_flg'), 0);
			sheetObj.SetCellValue(selRow, 't3_so_cancel_flag', sheetObj
					.GetCellValue(selRow, 't3_so_cancel_flag'), 0);
		}
		break;
	}
}
function doActionIBSheet3_3(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBINSERT:
		var yyyyww = formObj.yyyyww.value;
		var seq = formObj.seq.value;

		if (formObj.nowWeek.value > formObj.yyyyww.value) {
			// row add 비활성
			// ComShowCodeMessage("EQR01144");
			// Modify 20150117 추후에 아래 주석 제거
			// return false;
		}

		if (formObj.dtrb_flg.value == 'Y' && yyyyww.length == 6
				&& seq.length == 4) {
			// var Row = sheetObj.DataInsert(0);
			var selRow = sheetObj.GetSelectRow(); // selected ROW

			if (sheetObj.RowCount() == 0
					|| sheetObj.GetCellValue(selRow, "t3_num") == 1) {
				// var Row=sheetObj.DataInsert(selRow);
				var Row = sheetObj.DataInsert();
				// -------------- color modifying
				// [START]-----------------------------------------
				// PLAN ROW로 modifying
				sheetObj.SetRowBackColor(Row, "#CBEFEA");
				// sheetObj.SetCellBackColor(Row,
				// 't3_pln_yrwk',sheetObj.GetDataBackColor());
				// sheetObj.SetCellBackColor(Row,
				// 't3_onf_hir_div_cd',sheetObj.GetDataBackColor());
				// sheetObj.SetCellBackColor(Row,
				// 't3_fm_yd_cd',sheetObj.GetDataBackColor());
				// sheetObj.SetCellBackColor(Row,
				// 't3_to_yd_cd',sheetObj.GetDataBackColor());
				// -------------- color modifying
				// [END]-----------------------------------------

				sheetObj.SetCellValue(Row, 't3_repo_pln_id', repoword
						+ document.form.yyyyww.value + repoweek
						+ document.form.seq.value, 0);
				// sheetObj.SetCellEditable(Row, "t3_pln_yrwk",1);
				sheetObj.SetCellEditable(Row, "t3_pln_yrwk", 0);
				sheetObj.SetCellValue(Row, 't3_pln_yrwk', yyyyww, 0);

				sheetObj.InitCellProperty(Row, "t3_co_cd", {
					Type : "Text"
				});
				sheetObj.SetCellEditable(Row, "t3_co_cd", 0);
				sheetObj.SetCellValue(Row, "t3_co_cd", "");
				sheetObj.SetCellValue(Row, "t3_div", "Plan");
				sheetObj.SetCellEditable(Row, "t3_onf_hir_div_cd", 1);
				sheetObj.SetCellEditable(Row, "t3_vndr", 0);
				sheetObj.SetCellEditable(Row, "t3_fm_loc_dt", 0);
				sheetObj.SetCellEditable(Row, "t3_to_loc_dt", 0);
				sheetObj.SetCellValue(Row, "t3_repo_pln_fb_rsn_cd", "");
				sheetObj.SetCellEditable(Row, "t3_repo_pln_fb_rsn_cd", 0);
				sheetObj.SetCellEditable(Row, "t3_repo_pln_fb_rmk", 0);
				sheetObj.SetCellValue(Row, "t3_sortnum", "1", 0); // Plan
																	// Rowsetting
				sheetObj.SetCellValue(Row, "t3_num", "1", 0);// normal
																// rowsetting
				sheetObj.SetCellValue(Row, "t3_newplan", "T", 0);// add plan
				// sheetObj.SetCellValue(Row, "t3_lease_term","XX",0);//
				// default.
				for ( var i = 0; i < consTpszArr.length; i++) {
					sheetObj.SetCellEditable(Row, "t3_vol" + consTpszArr[i], 1);
				}
				
				sheetObj.InitCellProperty(Row, "t3_fm_loc_dt", {
					Type : "Text",
					Align : "Center",
					Format : "dfNone",
					PointCount : 0,
					EditLen : 6
				});
				sheetObj.InitCellProperty(Row, "t3_to_loc_dt", {
					Type : "Text",
					Align : "Center",
					Format : "dfNone",
					PointCount : 0,
					EditLen : 6
				});
				sheetObj.SetCellValue(Row, "t3_fm_loc_dt", sheetObj.GetCellValue(Row, "t3_pln_yrwk"), 0);
				sheetObj.SetCellValue(Row, "t3_to_loc_dt", sheetObj.GetCellValue(Row, "t3_pln_yrwk"), 0);
				
			}
		} else {
			ComShowCodeMessage("EQR90124");
			return false;
		}
		break;
	}
}
function doActionIBSheet4(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: // retrieve
		if (validateForm(sheetObj, formObj, sAction, 4)) {
			document.form.dataselect3[0].checked = true;
			ComOpenWait(true);
			sheetObj.SetWaitImageVisible(1);
			setTimeout(function() {
				t4sheet1.SetWaitTimeOut(300);// retrieve
				t4sheet1.SetVisible(0);
				t4sheet1.RemoveAll();
				t4sheet1 = t4sheet1.Reset();// keyfied
				sheetObjects[3] = t4sheet1;
				ComConfigSheet(t4sheet1);
				initSheet(t4sheet1, 4, comboObjects[1].GetSelectText());
				ComEndConfigSheet(t4sheet1);
				t4sheet1.SetWaitImageVisible(1);
				formObj.f_cmd.value = SEARCHLIST;
				// t4sheet1.DoSearch("EES_EQR_0083GS.do",
				// eqrFormQryStr(formObj), {Sync:2} );
				var sXml = t4sheet1.GetSearchData("EES_EQR_0083GS.do",
						eqrFormQryStr(formObj));
				t4sheet1.LoadSearchData(sXml, {
					Sync : 1
				});
				t4sheet1_ChangeXml(sXml);
				t4sheet1.SetVisible(1);
				sheetObj.SetExtendLastCol(0);
				formObj.pre_repo_rmk.value = formObj.repo_rmk.value;
			}, 100);
		}
		break;
	case IBSAVE: // saving
		if (validateForm(sheetObj, formObj, sAction, 4)) {

			var sRow = sheetObj.FindStatusRow("I|U|D");
			var arRow = sRow.split(";");
			var flag = true;

			if (flag) {
				if (sRow != "" && sRow != null) {
					formObj.f_cmd.value = MULTI;
					// sheetObj.DoSave("EES_EQR_0083GS.do",
					// eqrFormQryStr(formObj));
					var saveStr = sheetObj.GetSaveString();
					if (saveStr == "")
						return;
					var sXml = sheetObj.GetSaveData("EES_EQR_0083GS.do",
							saveStr, eqrFormQryStr(formObj));
					sheetObj.LoadSaveData(sXml, {
						Sync : 1
					});
					t4sheet1_ChangeXml(sXml);
				}
			}

			if (formObj.pre_repo_rmk.value != formObj.repo_rmk.value) {
				ComShowConfirm(ComGetMsg("EQR90236"));
				formObj.f_cmd.value = MULTI03;
				ComOpenWait(true);
				var sXml = sheetObj.GetSaveData("EES_EQR_0012GS.do",
						eqrFormQryStr(formObj));
				ComOpenWait(false);
				sheetObj.LoadSaveData(sXml, {
					Sync : 1
				});
				formObj.pre_repo_rmk.value = formObj.repo_rmk.value;
				ComEtcDataToForm(document.form, sheetObj);
				// document.form.checksave.value ="Y";
				// ComShowMessage(ComGetMsg("EQR90106")); // ??옣?꾨즺
			}
		}
		break;
	case IBINSERT:
		var yyyyww = formObj.yyyyww.value;
		var seq = formObj.seq.value;
		if (formObj.dtrb_flg.value == 'Y' && yyyyww.length == 6
				&& seq.length == 4) {
			// var Row = sheetObj.DataInsert(0);
			var selRow = sheetObj.GetSelectRow(); // selected ROW
			if (sheetObj.RowCount() == 0
					|| sheetObj.GetCellValue(selRow, "t4_num") == 1) {
				if (consTpszArr.length < allTpszCnt) {
					ComShowCodeMessage("EQR90045", "Row Add", "ALL");
					return false;
				}
				// var Row=sheetObj.DataInsert(selRow);
				var Row = sheetObj.DataInsert();
				sheetObj.SetRowBackColor(Row, "#F7FB59");
				sheetObj.SetCellValue(Row, 't4_pln_yrwk', yyyyww, 0);
				sheetObj.SetCellEditable(Row, "t4_pln_yrwk", 0);

				sheetObj.SetCellValue(Row, 't4_div', "Execution", 0);// REPO
																		// BKG
																		// setting
				sheetObj.SetCellValue(Row, 't4_repo_pln_id', repoword
						+ document.form.yyyyww.value + repoweek
						+ document.form.seq.value, 0);
				// sheetObj.CellValue2(Row, 't4_trsp_mod_cd') = "S"; // Shuttle
				sheetObj.SetCellValue(Row, 't4_eq_repo_purp_cd', "", 0);// Purpose
																		// resetting
				sheetObj.SetCellValue(Row, "t4_cntrimage", "1", 0);// cntr
																	// image
																	// initializing
				// no support[check again]CLT sheetObj.CellValue2(Row,
				// "t4_sortnum")="2"; // Execution Rowsetting
				sheetObj.SetCellValue(Row, "t4_sortnum", "2", 0);// Execution
																	// Rowsetting
				sheetObj.SetCellValue(Row, "t4_num", "1", 0);// normal
																// rowsetting
				// insert row
				document.form.position_row4.value = Row;

				var f_cmd = SEARCHLIST17;
				// var searchword = sheetObj.EditText;
				// ETD retrieve
				// var sXml = sheetObj.GetSearchData(
				// "EES_WEEKDATEPERIOD.do","row="+Row+"&searchword="+yyyyww+"&colname1=t4_week_fromdate&colname2=t4_week_todate&f_cmd="+f_cmd);
				// var xmlDoc = ComGetXmlDoc(sXml);
				sheetObj
						.DoRowSearch2(
								"EES_WEEKDATEPERIOD.do",
								"row="
										+ Row
										+ "&searchword="
										+ yyyyww
										+ "&colname1=t4_week_fromdate&colname2=t4_week_todate&f_cmd="
										+ f_cmd);

				// ETA retrieve
				// var sXml1 = sheetObj.GetSearchData(
				// "EES_WEEKDATEPERIOD.do","row="+Row+"&searchword="+yyyyww+"&colname1=t4_week_fromdate&colname2=t4_week_maxdate&division=WIDE&f_cmd="+f_cmd);
				sheetObj
				.DoRowSearch2(
						"EES_WEEKDATEPERIOD.do",
						"row="
								+ Row
								+ "&searchword="
								+ yyyyww
								+ "&colname1=t4_week_fromdate&colname2=t4_week_maxdate&division=WIDE&f_cmd="
								+ f_cmd);	
				sheetObj.SetCellValue(Row, "t4_fm_etd_dt", sheetObj
						.GetCellValue(Row, "t4_week_fromdate"), 0);
				sheetObj.SetCellValue(Row, "t4_to_eta_dt", sheetObj
						.GetCellValue(Row, "t4_week_todate"), 0);

			}
		} else {
			ComShowCodeMessage("EQR90124");
		}
		break;
	case IBDOWNEXCEL:
		sheetObj.Down2Excel({
			DownCols : makeHiddenSkipCol(sheetObj),
			SheetDesign : 1,
			Merge : 1
		});
		break;
	}
}

function doActionIBSheet4_1(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSAVE: // saving
		// if(validateForm(sheetObj,formObj,sAction))
		if (consTpszArr.length >= allTpszCnt) {
			var sRow = sheetObj.FindStatusRow("U");
			var arRow = sRow.split(";");
			var so_count = 0; // so send checked row
			var so_row = 0; // so send checked vol total
			var tab4SOAlert = "";
			tab4ArrSoAlert = "";
			sendToRefNo = "";
			if (sRow != "" && sRow != null) {
				// for(var i=0; i<arRow.length-1; i++) {
				for ( var i = 0; i < arRow.length; i++) {
					if (sheetObj.GetCellValue(arRow[i], "t4_so_iss_flg") == "1") {
						if (sheetObj.GetCellValue(arRow[i], "t4_trsp_mod_cd") == "R") {
							if (sheetObj.GetCellValue(arRow[i], "t4_fm_yd_cd")
									.substr(0, 2) == "US"
									|| sheetObj.GetCellValue(arRow[i],
											"t4_fm_yd_cd").substr(0, 2) == "CA") {
								tab4SOAlert = "N";
								tab4ArrSoAlert = tab4ArrSoAlert + "|"
										+ tab4SOAlert;
							}
						}
						sendToRefNo=sendToRefNo + ","+ sheetObj.GetCellValue(arRow[i], "t4_ref_id");
						
						// SO SEND row
						document.form.position_row4.value = arRow[i];
						so_count++;
						if (sheetObj.GetCellValue(arRow[i], "t4_co_cd") == "S") {
							so_row = eval(so_row)
									+ eval(sheetObj.GetCellValue(arRow[i],
											"t4_totalvol"));
						}
					}
				}
			}
			// if(sRow!="" && sRow!=null) {
			if (so_count > 0) {
				if (ComShowConfirm(ComGetMsg("EQR90054"))) {
					var selRow = sheetObj.GetSelectRow(); // selected ROW

					if ((sheetObj.GetCellValue(selRow, 't4_fm_chk_flg') != "Y")) {
						// ComShowCodeMessage("EQR90243",sheetObj.GetCellValue(selRow,
						// 't4_fm_yd_cd'));
						// return false;
					}

					if (validateForm(sheetObj, formObj, sAction, 4)) {
						formObj.so_action.value = "SEND"; // so send action
						formObj.f_cmd.value = MULTI01;
						// sheetObj.DoSave("EES_EQR_0083GS.do?soFlag=Y",
						// eqrFormQryStr(formObj));
						var saveStr = sheetObj.GetSaveString();
						if (saveStr == "")
							return;
						var sXml = sheetObj.GetSaveData(
								"EES_EQR_0083GS.do?soFlag=Y", saveStr,
								eqrFormQryStr(formObj));
						sheetObj.LoadSaveData(sXml, {
							Sync : 1
						});
						t4sheet1_ChangeXml(sXml);
					}
				}
			} else {
				ComShowCodeMessage("EQR90044");
			}
		} else {
			ComShowCodeMessage("EQR90045", "S/O Send", "ALL");
		}
		break;
	}
}

function doActionIBSheet4_2(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSAVE: // saving
		var selRow = sheetObj.GetSelectRow(); // selected ROW
		var cancelOK = false;
		var totalvol = sheetObj.CellSearchValue(selRow, 't4_totalvol'); // total
																		// volume
		// var trspno = sheetObj.CellSearchValue(selRow, 't4_trspno'); //
		// TRSP_SO_STS_CD = 'P'
		var co_cd = sheetObj.CellSearchValue(selRow, 't4_co_cd'); // company
																	// code - H,
																	// S
		var fm_rcc = sheetObj.CellSearchValue(selRow, 't4_frloc_rcc'); // from
																		// rcc -
		var trspno_p = sheetObj.CellSearchValue(selRow, 't4_trspno_p'); // TRSP_SO_STS_CD='P'
		var trspno_d = sheetObj.CellSearchValue(selRow, 't4_trspno_d'); // TRSP_SO_STS_CD='D'
		var trsp_sum = eval(trspno_p) + eval(trspno_d);
		if (co_cd == 'H') { //
			if (trspno_p == totalvol)
				cancelOK = true;
		} else { //
			if (fm_rcc == 'DEHAM') {
				if (trsp_sum == totalvol)
					cancelOK = true;
			} else {
				if (trspno_p == totalvol)
					cancelOK = true;
			}
		}

		if (sheetObj.GetCellValue(selRow, 't4_so_iss_flg') == "1" && cancelOK) {
			if (ComShowConfirm(ComGetMsg("EQR90055"))) {
				if ((sheetObj.GetCellValue(selRow, 't4_fm_chk_flg') != "Y")) {
					// ComShowCodeMessage("EQR90243",sheetObj.GetCellValue(selRow,
					// 't4_fm_yd_cd'));
					// return false;
				}

				if (validateForm(sheetObj, formObj, sAction, 4)) {
					// sheetObj.RowStatus(selRow) = "U";
					sheetObj.SetCellValue(selRow, 't4_so_cancel_flag', "T");// so
																			// cancel
					// SO CANCEL row
					document.form.position_row4.value = selRow;
					formObj.f_cmd.value = MULTI02;
					// sheetObj.DoSave("EES_EQR_0083GS.do",
					// eqrFormQryStr(formObj));
					var saveStr = sheetObj.GetSaveString();
					if (saveStr == "")
						return;
					var sXml = sheetObj.GetSaveData("EES_EQR_0083GS.do",
							saveStr, eqrFormQryStr(formObj));
					sheetObj.LoadSaveData(sXml, {
						Sync : 1
					});
					t4sheet1_ChangeXml(sXml);
				}
			}
		} else {
			if (sheetObj.GetCellValue(selRow, 't4_so_iss_flg') == "1"
					&& !cancelOK) {
				ComShowCodeMessage("EQR90142");
			} else {
				ComShowCodeMessage("EQR90047");
			}
			sheetObj.SetCellValue(selRow, 't4_so_iss_flg', sheetObj
					.GetCellValue(selRow, 't4_so_iss_flg'), 0);
			sheetObj.SetCellValue(selRow, 't4_so_cancel_flag', sheetObj
					.GetCellValue(selRow, 't4_so_cancel_flag'), 0);
		}
		break;
	}
}
// handling process for Sheet
function doActionIBSheet5(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: // retrieve
		if (validateForm(sheetObj, formObj, sAction, 5)) {
			document.form.dataselect4[0].checked = true;
			ComOpenWait(true);
			sheetObj.SetWaitImageVisible(1);
			setTimeout(function() {
				t5sheet1.SetVisible(0);
				t5sheet1.RemoveAll();
				sheetObjects[4] = t5sheet1.Reset();// keyfied
				ComConfigSheet(t5sheet1);
				initSheet(t5sheet1, 5, comboObjects[1].GetSelectText());
				ComEndConfigSheet(t5sheet1);
				t5sheet1.SetWaitImageVisible(1);
				// no support[check again]CLT
				// sheetObj.SpeedOption="NOFIT,NOSUM,NOSEQ,NOCALC,NOROWHEIGHT,NOTRIM";
				formObj.f_cmd.value = SEARCHLIST;
				// t5sheet1.DoSearch("EES_EQR_0092GS.do",
				// eqrFormQryStr(formObj), {Sync:2} );
				var sXml = t5sheet1.GetSearchData("EES_EQR_0092GS.do",
						eqrFormQryStr(formObj));
				t5sheet1.LoadSearchData(sXml, {
					Sync : 1
				});
				t5sheet1_ChangeXml(sXml);
				t5sheet1.SetVisible(1);
				sheetObj.SetExtendLastCol(0);
				formObj.pre_repo_rmk.value = formObj.repo_rmk.value;
			}, 100);
		}
		break;
	case IBSAVE: // saving
		// if(validateForm(sheetObj,formObj,sAction))
		if (formObj.pre_repo_rmk.value != formObj.repo_rmk.value) {
			ComShowConfirm(ComGetMsg("EQR90236"));
			formObj.f_cmd.value = MULTI03;
			ComOpenWait(true);
			var sXml = sheetObj.GetSaveData("EES_EQR_0012GS.do",
					eqrFormQryStr(formObj));
			ComOpenWait(false);
			sheetObj.LoadSaveData(sXml, {
				Sync : 1
			});
			formObj.pre_repo_rmk.value = formObj.repo_rmk.value;
			ComEtcDataToForm(document.form, sheetObj);
			// document.form.checksave.value ="Y";
			// ComShowMessage(ComGetMsg("EQR90106")); // ??옣?꾨즺
		}

		break;
	case IBINSERT:
		var Row = sheetObj.DataInsert();
		sheetObj.SetRowBackColor(Row, "#F7FB59");
		break;
	case IBDOWNEXCEL:
		sheetObj.Down2Excel({
			DownCols : makeHiddenSkipCol(sheetObj),
			SheetDesign : 1,
			Merge : 1
		});
		break;
	case IBCOPYROW:
		sheetObj.DataCopy();
		break;
	}
}
// calcuating sub total after retrieve
function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	sheetObj.SetWaitImageVisible(0);
	ComOpenWait(false);
	ComEtcDataToForm(document.form, sheetObj);
	var totalRow = sheetObj.RowCount();
	
	for (i = 2; i <= totalRow; i++) {
		if (sheetObj.GetCellValue(i,"t1_repo_mty_bkg_flg") == "" && sheetObj.GetCellValue(i,"t1_div") != "Plan" && sheetObj.GetCellValue(i,"t1_vvd") != "") {
			sheetObj.SetCellEditable(i, 't1_to_yd_cd', 1);
			sheetObj.SetCellEditable(i, 't1_to_eta_dt', 1);
		}
	}
	
	strLoading = true;
	tab1.SetSelectedIndex(0);
}

// calcuating sub total after retrieve
function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	sheetObj.SetWaitImageVisible(0);
	ComOpenWait(false);
	var formObject = document.form;
	
	var totalRow = sheetObj.RowCount();
	
	for (i = 2; i <= totalRow; i++) {
		if (sheetObj.GetCellValue(i,"t2_so_iss_flg") == "" && sheetObj.GetCellValue(i,"t2_repo_mty_bkg_flg") == "" && sheetObj.GetCellValue(i,"t2_div") != "Plan") {
			sheetObj.SetCellEditable(i, 't2_vvd', 1);
			
			sheetObj.SetCellEditable(i, 't2_fm_yd_cd', 1);
			sheetObj.SetCellEditable(i, 't2_fm_etd_dt', 1);
			
			sheetObj.SetCellEditable(i, 't2_to_yd_cd', 1);
			sheetObj.SetCellEditable(i, 't2_to_eta_dt', 1);
		}
		
		if(sheetObj.GetCellValue(i,"t2_past_repo_pln_flg") == "Y" && sheetObj.GetCellValue(i, "t2_div") != "Plan") {
			sheetObj.SetCellEditable(i, 't2_fm_yd_cd', 0);
			sheetObj.SetCellEditable(i, 't2_to_yd_cd', 0);
		}
		
		
		if (sheetObj.GetCellValue(i, "t2_div") == "Plan"
			&& sheetObj.GetCellValue(i, "t2_pln_yrwk").length == 6) {
			//sheetObj.SetCellEditable(Row, "t2_check", 1);
			var prvPlnSeq = "";
			prvPlnSeq = sheetObj.GetCellValue(i, "t2_pln_seq");
			var prvPlnWeek = "";
			prvPlnWeek = sheetObj.GetCellValue(i, "t2_pln_yrwk");
			var PlanChild = false;
			for ( var j = 2; j < sheetObj.RowCount(); j++) {
				if (i != j) {
					if (prvPlnSeq == sheetObj.GetCellValue(j, "t2_pln_seq")
							&& prvPlnWeek == sheetObj
									.GetCellValue(j, "t2_pln_yrwk")) {
						PlanChild = true;
						break;
					}
				}
			}
			
			if (PlanChild == false) {
				sheetObj.SetCellEditable(i, "t2_check", 1);
			}
		}
		
		if (sheetObj.GetCellValue(i, "t2_div") == "W/O Issue") {
			sheetObj.SetRowEditable(i,0);
		}
	}
}

// calcuating sub total after retrieve
function t3sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	sheetObj.SetWaitImageVisible(0);
	ComOpenWait(false);
	var formObject = document.form;
	
	var totalRow = sheetObj.RowCount();	
	
	for (i = 2; i <= totalRow; i++) {		
		if (sheetObj.GetCellValue(i, "t3_div") == "Plan"
			&& sheetObj.GetCellValue(i, "t3_pln_yrwk").length == 6) {
			//sheetObj.SetCellEditable(Row, "t2_check", 1);
			var prvPlnSeq = "";
			prvPlnSeq = sheetObj.GetCellValue(i, "t3_pln_seq");
			var prvPlnWeek = "";
			prvPlnWeek = sheetObj.GetCellValue(i, "t3_pln_yrwk");
			var PlanChild = false;
			for ( var j = 2; j < sheetObj.RowCount(); j++) {
				if (i != j) {
					if (prvPlnSeq == sheetObj.GetCellValue(j, "t3_pln_seq")
							&& prvPlnWeek == sheetObj
									.GetCellValue(j, "t3_pln_yrwk")) {
						PlanChild = true;
						break;
					}
				}
			}
			
			var strStatus = sheetObj.GetRowStatus(i);
			if(strStatus != "I") {
				sheetObj.InitCellProperty(i, "t3_fm_loc_dt", {Type:"Text",Format : ""});
				sheetObj.InitCellProperty(i, "t3_to_loc_dt", {Type:"Text",Format : ""});
				sheetObj.SetCellValue(i,"t3_fm_loc_dt",sheetObj.GetCellValue(i, "t3_pln_yrwk"),0);
				sheetObj.SetCellValue(i,"t3_to_loc_dt",sheetObj.GetCellValue(i, "t3_pln_yrwk"),0);
				sheetObj.SetRowStatus(i, "R");
			}else{
				sheetObj.SetRowStatus(i, "I");
			}
			
			if (PlanChild == false) {
				sheetObj.SetCellEditable(i, "t3_check", 1);
			}
		}
		
		if (sheetObj.GetCellValue(i, "t3_div") == "Execution" && sheetObj.GetCellValue(i, "t3_onf_hir_div_cd") == "F" && sheetObj.GetCellValue(i, "t3_so_iss_flg") != "Y") {
			for ( var j = 0; j < consTpszArr.length; j++) {
				sheetObj.SetCellEditable(i, "t3_vol"
						+ consTpszArr[j], 1);
			}
		}
		
		if (sheetObj.GetCellValue(i, "t3_div") == "W/O Issue") {
			sheetObj.SetRowEditable(i,0);
		}
	}
}

// SHEET1 ONCHANGE EVENT
function t1sheet1_OnChange(sheetObj, Row, Col, Val) {
	var colName = sheetObj.ColSaveName(Col);
	if (colName == "t1_fm_yd_cd" || colName == "t1_to_yd_cd") { // LOC YARD
		var idx = sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
		var searchword = sheetObj.GetCellValue(Row, colName);		// COMBO BOX
		var eccTmpCdArr = "";
		var eccTmpTextArr = "";
		if(colName == "t1_to_yd_cd") {			
			//var searchword = sheetObj.GetCellText(Row, colName);
			var eccCdTmp = sheetObj.GetComboInfo(Row, "t1_to_yd_cd" , "Code");
			var eccTextTmp = sheetObj.GetComboInfo(Row, "t1_to_yd_cd" , "Text");
			eccTmpCdArr = eccCdTmp.split("|");
			eccTmpTextArr = eccTextTmp.split("|");
			var strDtValue = "";
			var strDefault = "";
			
			for(var k=0;k<eccTmpCdArr.length;k++) {
				var strTempArrDefaultCd = eccTmpCdArr[k].replace(/\s/gi, '');
				var strTempArrDefaultText = eccTmpTextArr[k].split("\t");
				
				if(searchword == strTempArrDefaultCd) {
					sheetObj.InitCellProperty(Row,"t1_to_yd_cd",{ Type:"Text"}); 
					if(strTempArrDefaultCd.length == 7) {
						sheetObj.SetCellValue(Row, "t1_to_yd_cd", strTempArrDefaultCd.replace(/\s/gi, ''),0);
					}else{
						sheetObj.SetCellValue(Row, "t1_to_yd_cd", strTempArrDefaultCd.replace(/\s/gi, '').substring(3,10),0);
					}
					
					//sheetObj.SetCellValue(Row, "t1_to_yd_cd_tmp", strTempArrDefaultCd[0].replace(/\s/gi, '').substring(0,3),0);
					strDtValue = ComLtrim(strTempArrDefaultText[1]);
					idx = k;
					break;
				}
			}
		}
		
		if (idx == -1 && searchword != "") {
			// searchword.length >= 5 && searchword.substr(0,5)==ecc, YARD
			// retreive
			var basic_ecc = "";
			if (colName == "t1_fm_yd_cd")
				basic_ecc = sheetObj.GetCellValue(Row, "t1_fm_ecc");
			else if (colName == "t1_to_yd_cd")
				basic_ecc = sheetObj.GetCellValue(Row, "t1_to_ecc");
				
			if (searchword.length == 7) {
				var f_cmd = SEARCH02;
				sheetObj.InitCellProperty(Row, colName, {
					Type : "Text",
					AcceptKeys : "E|N",
					InputCaseSensitive : 1
				});
				sheetObj.SetCellValue(Row, colName, "", 0);
				// var str=sheetObj.GetSearchData("EES_LOCYARDEXIST_COMMON.do"
				// ,"row="+Row+"&locyard="+searchword+"&ecc="+basic_ecc+"&colname="+colName+"&f_cmd="+f_cmd);
				// sheetObj.LoadSearchData(str,{Sync:1} );
				sheetObj.DoRowSearch2("EES_LOCYARDEXIST_COMMON.do", "row="
						+ Row + "&locyard=" + searchword + "&ecc=" + basic_ecc
						+ "&colname=" + colName + "&f_cmd=" + f_cmd);
			} else if (searchword.length >= 5 && searchword.substr(0, 5) == basic_ecc) {
				var f_cmd = SEARCHLIST20;
				// sheetObj.DoRowSearch(
				// ROW,row=Row&searchword=searchword&colname=colName&f_cmd=f_cmd
				// );
				// sheetObj.DoRowSearch2("EES_LOCYARD_COMMON.do"
				// ,"row="+Row+"&searchword="+searchword+"&colname="+colName+"&f_cmd="+f_cmd);
				var sXml = sheetObj.GetSearchData("EES_LOCYARD_COMMON.do",
						"row=" + Row + "&searchword=" + searchword
								+ "&colname=" + colName + "&f_cmd=" + f_cmd);
				changeViewCombo(sheetObj, sXml);
				sheetObj.SetCellValue(Row, colName, "", 0);
			} else {
				ComShowCodeMessage("EQR90171", basic_ecc);
				sheetObj.SetCellValue(Row, colName, "", 0);
			}
		} else {
			/*var strIndex = sheetObj.GetComboInfo(Row, colName, "SelectedIndex");
			var strText = sheetObj.GetComboInfo(Row, colName, "Text")
					.split("|");

			var strLoc = strText[strIndex].split("\t");
			sheetObj.SetCellValue(Row, "t1_to_eta_dt", strLoc[1]);*/
			sheetObj.SetCellValue(Row, "t1_to_eta_dt",strDtValue,0);
		}
		if(sheetObj.GetRowStatus(Row) == "I" && eccTmpCdArr.length == 1 && colName == "t1_to_yd_cd") {
			sheetObj.SetSelectRow(Row-1, true);
		}
	}

	// ------- in case of vol modified
	// ----------------------------------------------------------
	// - Total Vol, Sub Total, Grand Total
	if (sheetObj.ColSaveName(Col).substring(0, 6) == "t1_vol") {
		var limitFlag = false;
		var cntrVol = 0;
		var tpszName = sheetObj.ColSaveName(Col).substring(6, 8);
		if (sheetObj.GetCellValue(Row, "t1_cntrimage") == "0") {
			//cntrVol = sheetObj.GetCellValue(Row, "t1_cntrvol" + tpszName); // cntrVol = 0 변수선언
			// ComShowMessage("1 Val : "+Val+", CNTR : "+cntrVol);
			if (eval(Val) < eval(cntrVol)) {
				limitFlag = true;
			}
		} else if (sheetObj.GetCellValue(Row, "t1_cntrimage") == "1"
				&& sheetObj.GetCellValue(Row, "t1_cntrno") != "") {
			var tpszConArr = sheetObj.GetCellValue(Row, "t1_tpszno").split(",");
			for ( var j = 0; j < tpszConArr.length; j++) {
				if (tpszName == tpszConArr[j])
					cntrVol++;
			}
			if (eval(Val) < eval(cntrVol)) {
				limitFlag = true;
			}
		}
		if (limitFlag) {
			ComShowCodeMessage("EQR90048", tpszName, cntrVol);
			// sheetObj.CellValue(Row,Col) = sheetObj.CellSearchValue(Row,Col);
			// // inserting값 rollback
			sheetObj.SetCellValue(Row, Col, oldValue, 0);// inserting값
															// rollback
		} else {
			// var diffVol = eval(Val - sheetObj.CellSearchValue(Row,Col));
			var diffVol = eval(Val - oldValue);
			// ----- checking pass feedback for each tpsz vol (START) ----
			var week = sheetObj.GetCellValue(Row, "t1_pln_yrwk");
			var item = sheetObj.GetCellValue(Row, "t1_trsp_mod_cd");
			var fm_ecc = sheetObj.GetCellValue(Row, "t1_fm_ecc");
			var to_ecc = sheetObj.GetCellValue(Row, "t1_to_ecc");
			var tpsz = sheetObj.ColSaveName(Col).substring(6, 8);
			var planVol = 0;
			var exeMaxVol = 0;
			var exeFinalVol = 0;
			var basicRatio = 0;
			var basicVol = 0;
			var targetVol = 0;
			var targetRatio = 0;
			var planRow = 0;
			for ( var i = 0; i < sheetObj.RowCount(); i++) {
				/*
				 * if(sheetObj.GetCellValue(i, "t1_sortnum")==1 &&
				 * sheetObj.GetCellValue(i, "t1_num")==1 &&
				 * sheetObj.GetCellValue(i, "t1_pln_yrwk")==week &&
				 * sheetObj.GetCellValue(i, "t1_trsp_mod_cd")==item &&
				 * sheetObj.GetCellValue(i, "t1_fm_ecc")==fm_ecc &&
				 * sheetObj.GetCellValue(i, "t1_to_ecc")==to_ecc ) { planRow=i;
				 * break; }
				 */
				if (sheetObj.GetCellValue(i, "t1_num") == 1
						&& sheetObj.GetCellValue(i, "t1_pln_yrwk") == week
						&& sheetObj.GetCellValue(i, "t1_trsp_mod_cd") == item
						&& sheetObj.GetCellValue(i, "t1_fm_ecc") == fm_ecc
						&& sheetObj.GetCellValue(i, "t1_to_ecc") == to_ecc) {
					planRow = i;
					break;
				}
			}
			if (planRow == 0) {
				// ComShowCodeMessage("EQR90067");
			} else {
				planVol = sheetObj.GetCellValue(planRow, "t1_vol" + tpsz);
				//exeMaxVol = sheetObj.GetCellValue(planRow, "t1_maxvol" + tpsz);
				//basicRatio = sheetObj.GetCellValue(planRow, "t1_basicratio"+ tpsz);
				//basicVol = sheetObj.GetCellValue(planRow, "t1_basicvol" + tpsz);
				
				exeMaxVol = 0;
				basicRatio = 0;
				basicVol = 0;
				// ComShowMessage("planRow : "+ planRow+ ", planVol :
				// "+planVol+", exeMaxVol : "+exeMaxVol+", basicRatio :
				// "+basicRatio+", basicVol : "+basicVol);
				// vol calculation
				exeFinalVol = eval(exeMaxVol) + eval(diffVol);
				if (exeFinalVol < 0)
					exeFinalVol = 0;
				targetVol = Math.abs(eval(planVol) - eval(exeFinalVol));
				// if(targetVol < 0) targetVol = 0;
				// ratio calculation
				if (exeFinalVol == 0 || planVol == 0) {
					targetRatio = 0;
				} else {
					targetRatio = Math
							.round((eval(exeFinalVol) / eval(planVol)) * 100);
				}
				/*sheetObj.SetCellValue(planRow, "t1_maxvol" + tpsz, exeFinalVol,
						0);*/

				if (sheetObj.GetCellValue(Row, "t1_div") != "Plan") {
					sheetObj.SetRowStatus(planRow, "R");
				}
				// sheetObj.SetRowStatus(planRow,"R");

				sheetObj.SetRowBackColor(planRow, "#CBEFEA");
				var formula_result = "";
				if (basicVol > targetVol && basicRatio < targetRatio) {
					formula_result = "SUCCESS";
					//sheetObj.SetCellValue(Row, "t1_pass" + tpsz, '', 0);
					sheetObj.SetCellFontColor(Row, "t1_vol" + tpsz, sheetObj
							.GetDataFontColor());
				} else {
					formula_result = "FAILURE";
					//sheetObj.SetCellValue(Row, "t1_pass" + tpsz, 'F', 0);
					// sheetObj.SetCellFontColor(Row,"t1_vol"+tpsz,"#F1541F");
				}

				var grandTotalRow = 0;
				var subTotalRow = 0;
				while (true) {
					grandTotalRow = sheetObj.FindText("t1_num", 3,
							grandTotalRow + 1); // TOTAL ROW retreive
					if (grandTotalRow == -1) {
						break;
					} else {
						if (sheetObj.GetCellValue(grandTotalRow, "t1_sortnum") == 2) { // Execution
																						// Row
																						// retreive
							
							sheetObj.SetCellValue(grandTotalRow, "t1_totalvol",
									eval(sheetObj.GetCellValue(grandTotalRow,
											"t1_totalvol"))
											+ eval(diffVol), 0);
							sheetObj.SetRowStatus(grandTotalRow, "R");
							sheetObj.SetRowBackColor(grandTotalRow, "#FEBDB6");
						}
					}
				}
				while (true) {
					subTotalRow = sheetObj.FindText("t1_num", 2,
							subTotalRow + 1); // SUB ROW retreive
					if (subTotalRow == -1) {
						break;
					} else {
						if (sheetObj.GetCellValue(subTotalRow, "t1_sortnum") == 2) { // Execution
																						// Row
																						// retreive
							if (sheetObj.GetCellValue(subTotalRow,
									"t1_pln_yrwk").substr(0, 6) == sheetObj
									.GetCellValue(Row, "t1_pln_yrwk")) {
								sheetObj.SetCellValue(subTotalRow, Col,
										eval(sheetObj.GetCellValue(subTotalRow,
												Col))
												+ eval(diffVol), 0);

								sheetObj.SetCellValue(subTotalRow,
										"t1_totalvol", eval(sheetObj
												.GetCellValue(subTotalRow,
														"t1_totalvol"))
												+ eval(diffVol), 0);
								
								sheetObj.SetRowStatus(subTotalRow, "R");
								sheetObj
										.SetRowBackColor(subTotalRow, "#F9DF9B");
							}
						}
					}
				}
				sheetObj.SetCellValue(Row, "t1_totalvol", eval(sheetObj
						.GetCellValue(Row, "t1_totalvol"))
						+ eval(diffVol), 0);
				
				sheetObj.SetCellValue(Row, "t1_flag"
						+ sheetObj.ColSaveName(Col).substring(6, 8), "T", 0);
				oldValue = Val;
			}
		}
	}
	// ------------- Mail / Fax checkbox checking시
	// ------------------------------------------------------------------
	if (sheetObj.ColSaveName(Col) == "t1_mailfax") {
		sheetObj.SetRowStatus(Row, "R");
	}
	// ------------- Reason
	// modifying------------------------------------------------------------------
	if (sheetObj.ColSaveName(Col) == "t1_repo_pln_fb_rsn_cd") {
		if ((sheetObj.GetRowStatus(Row) == "I" || sheetObj.GetRowStatus(Row) == "U")
				&& sheetObj.GetCellValue(Row, "t1_pass_final") == "F") {
			var week = sheetObj.GetCellValue(Row, "t1_pln_yrwk");
			var item = sheetObj.GetCellValue(Row, "t1_trsp_mod_cd");
			var fm_ecc = sheetObj.GetCellValue(Row, "t1_fm_ecc");
			var to_ecc = sheetObj.GetCellValue(Row, "t1_to_ecc");
			var sRow = sheetObj.FindStatusRow("I|U");
			var arRow = sRow.split(";");
			if (sRow != "" && sRow != null) {
				// for(var i=0; i<arRow.length-1; i++) {
				for ( var i = 0; i < arRow.length; i++) {
					if (sheetObj.GetCellValue(arRow[i], "t1_sortnum") == 2
							&& sheetObj.GetCellValue(arRow[i], "t1_num") == 1
							&& sheetObj.GetCellValue(arRow[i], "t1_pln_yrwk") == week
							&& sheetObj
									.GetCellValue(arRow[i], "t1_trsp_mod_cd") == item
							&& sheetObj.GetCellValue(arRow[i], "t1_to_ecc") == to_ecc
							&& sheetObj.GetCellValue(arRow[i], "t1_fm_ecc") == fm_ecc
							&& sheetObj.GetCellValue(arRow[i], "t1_pass_final") == "F") {
						sheetObj.SetCellValue(arRow[i],
								"t1_repo_pln_fb_rsn_cd", sheetObj.GetCellValue(
										Row, "t1_repo_pln_fb_rsn_cd"));
						otherCombo(sheetObj, Row, Col);
					}
				}
			}
		} else {
			otherCombo(sheetObj, Row, Col);
		}
	}
	if (sheetObj.ColSaveName(Col) == "t1_tpszno") {
		var tpszConArr = Val.split(",");
		var vol = 0;
		for ( var i = 0; i < consTpszArr.length; i++) {
			for ( var j = 0; j < tpszConArr.length; j++) {
				if (consTpszArr[i] == tpszConArr[j])
					vol++;
			}
			// if(vol > sheetObj.GetCellValue(Row, "t1_vol"+consTpszArr[i])) {
			oldValue = sheetObj.GetCellValue(Row, "t1_vol" + consTpszArr[i]);
			sheetObj.SetCellValue(Row, "t1_vol" + consTpszArr[i], vol);
			// }
			vol = 0;
		}
	}
	// MTY Repo BKG check box
	if (sheetObj.ColSaveName(Col) == "t1_repo_mty_bkg_flg") {
		var sRow = sheetObj.FindStatusRow("U");
		var arRow = sRow.split(";");
		var cntr_all = "";
		var bkg_count = 0;
		if (sRow != "" && sRow != null) {
			// for(var i=0; i<arRow.length-1; i++) {
			for ( var i = 0; i < arRow.length; i++) {
				if (sheetObj.GetCellValue(arRow[i], "t1_repo_mty_bkg_flg") == "1") {
					bkg_count++;
				}
			}
		}
		if (bkg_count > 1) {
			ComShowCodeMessage("EQR90152", "MTY Repo BKG");
			sheetObj.SetCellValue(Row, "t1_repo_mty_bkg_flg", 0, 0);
			return false;
		}
		// if(sRow!="" && sRow!=null && sheetObj.GetCellValue(Row,
		// "t1_repo_mty_bkg_flg")==1 && arRow.length>1) {
		if (sRow != "" && sRow != null
				&& sheetObj.GetCellValue(Row, "t1_repo_mty_bkg_flg") == 1
				&& arRow.length > 0) {
			var year_week = sheetObj.GetCellValue(Row, "t1_pln_yrwk"); // week
			var load_loc = sheetObj.GetCellValue(Row, "t1_sort")
					.substring(0, 5); // from yard ecc
			var vvd = sheetObj.GetCellValue(Row, "t1_vvd"); // vvd
			var co_cd = sheetObj.GetCellValue(Row, "t1_co_cd"); // company
			// for(var i=0; i<arRow.length-1; i++) {
			for ( var i = 0; i < arRow.length; i++) {
				if (sheetObj.GetCellValue(arRow[i], "t1_repo_mty_bkg_flg") == 1) { // BKG
																					// CHECK
																					// BOX
																					// checked
																					// ROW
					if (year_week == sheetObj.GetCellValue(arRow[i],
							"t1_pln_yrwk")
							&& load_loc == sheetObj.GetCellValue(arRow[i],
									"t1_sort").substring(0, 5)
							&& vvd == sheetObj.GetCellValue(arRow[i], "t1_vvd")
							&& co_cd == sheetObj.GetCellValue(arRow[i],
									"t1_co_cd")) {
						sheetObj.SetCellValue(Row, 't1_repobkg_flag', "T");// repobkg
					} else {
						ComShowCodeMessage("EQR90121");
						sheetObj.SetCellValue(Row, "t1_repo_mty_bkg_flg", 0, 0);
						break;
					}
				}
			}
		}
		if (sheetObj.GetCellValue(Row, "t1_repo_mty_bkg_flg") == 0) {
			sheetObj.SetCellValue(Row, 't1_repobkg_flag', "F", 0);
		}
	}
	// SPLIT BOOKING NO SELECT BOX
	if (sheetObj.ColSaveName(Col) == "t1_mty_bkg_no") {
		// BOOKING info
		// code[0] : booking no
		// code[1] : company code
		// code[2] : from yard
		// code[3] : etd
		// code[4] : eta
		// ------ BOOKING의 EXECUTEinfo retreive [START] -----------
		var bkg_no = sheetObj.GetCellValue(Row, "t1_mty_bkg_no");
		var f_cmd = SEARCH02;
		if (bkg_no != null && bkg_no != "") {
			// sheetObj.DoRowSearch("EES_EQR_0059GS2.do"
			// ,"row="+Row+"&search_bkgno="+bkg_no+"&f_cmd="+f_cmd);
			// sheetObj.DoRowSearch(
			// ROW,row=Row&search_bkgno=bkg_no&tpsztype=consTpsz&f_cmd=f_cmd );
			sheetObj.DoRowSearch2("EES_EQR_0059GS2.do", "row=" + Row
					+ "&search_bkgno=" + bkg_no + "&tpsztype=" + consTpsz
					+ "&f_cmd=" + f_cmd);
		}
		// ------ BOOKING의 EXECUTE info retreive [END] -----------
	}
	// total vol
	if (sheetObj.ColSaveName(Col) == "t1_totalvol") {
		// ComShowMessage("here 1" );
		// doActionIBSheet_3(sheetObjects[0], document.form, "IBSAVE");
	}

}
function t1sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
	if (sheetObj.ColSaveName(NewCol).substring(0, 6) == "t1_vol") {
		oldValue = sheetObj.GetCellValue(NewRow, NewCol);
	}
}
// SHEET1 ONCLICK EVENT
function t1sheet1_OnClick(sheetObj, Row, Col, Val) {
	// if(sheetObj.ColSaveName(Col).substring(0,6) == "t1_vol") oldValue = Val;
	if (sheetObj.GetRowStatus(Row) == "I"
			&& sheetObj.ColSaveName(Col) == "t1_check") {
		sheetObj.SetCellValue(Row, "t1_cntrno", "");// CNTR initializing
		for ( var i = 0; i < consTpszArr.length; i++) {
			oldValue = sheetObj.GetCellValue(Row, "t1_vol" + consTpszArr[i]); // old
																				// value
																				// setting
			sheetObj.SetCellValue(Row, "t1_vol" + consTpszArr[i], "0");// '0'
		}
	}
	
	// ----------- cntr image ----------------------
	if (sheetObj.ColSaveName(Col) == "t1_cntrimage") {
		var name = sheetObj.GetCellValue(Row, Col);
		// hidden value setting
		if (sheetObj.GetCellValue(Row, "t1_sortnum") == "2"
				&& sheetObj.GetCellValue(Row, "t1_num") == "1") {
			// split='y', inserting row, calling pop-up
			if (sheetObj.GetCellValue(Row, "t1_split_repo_pln_flg") == "Y"
			// && sheetObj.CellValue(Row,"t1_ibflag") == "I"
			&& sheetObj.GetRowStatus(Row) == "I") {
				if (sheetObj.GetCellValue(Row, "t1_mty_bkg_no") != ""
						&& sheetObj.GetCellValue(Row, "t1_to_yd_cd").length > 5
						&& sheetObj.GetCellValue(Row, "t1_co_cd") != ""
						&& sheetObj.GetCellValue(Row, "t1_fm_yd_cd") != ""
						&& sheetObj.GetCellValue(Row, "t1_fm_etd_dt") != "") {
					oldValue = 0; // oldvalue initializing
					var url = "EES_EQR_0130.do" + "?f_cmd=-1" // DEFAULT
							+ "&targetRow=" + Row // row
							+ "&co_cd="
							+ sheetObj.GetCellValue(Row, "t1_co_cd") // company
																		// code
							+ "&bkg_no="
							+ sheetObj.GetCellValue(Row, "t1_mty_bkg_no") // booking
																			// no
					;
					// var styleInfo="dialogLeft:0px; dialogTop:0px;
					// dialogWidth:1075px;
					// dialogHeight:552px;scroll:no;status:no";
					// var modal = ComOpenWindow(url, self, styleInfo , true);
					ComOpenWindowCenter(url, "EES_EQR_0130", 1075, 602, true,
							"");
				} else if (sheetObj.GetCellValue(Row, "t1_mty_bkg_no") == "") {
					ComShowCodeMessage("EQR90016", "BKG No");
					sheetObj.SelectCell(Row, 't1_mty_bkg_no'); // cell focus
				} else if (sheetObj.GetCellValue(Row, "t1_to_yd_cd").length <= 5) {
					ComShowCodeMessage("EQR90016", "Discharge LOC");
					sheetObj.SelectCell(Row, 't1_to_yd_cd'); // cell focus
				} else if (sheetObj.GetCellValue(Row, "t1_co_cd") == ""
						|| sheetObj.GetCellValue(Row, "t1_fm_yd_cd") == ""
						|| sheetObj.GetCellValue(Row, "t1_fm_etd_dt") == "") {
					ComShowCodeMessage("EQR90229");
				}
			} else {
				var view = false; // false(normal cntr popup)
				// true (only view cntr popup)
				if (sheetObj.GetCellValue(Row, "t1_mty_bkg_no") == "") {
					view = false;
				} else {
					view = true;
				}
				if (!userAreaCheck(sheetObj, "CNTR", "from", "1", Row)) {
					view = true;
				}
				document.form.cntrno.value = sheetObj.GetCellValue(Row,
						"t1_cntrno");
				var sRow = sheetObj.FindStatusRow("I|U");
				var arRow = sRow.split(";");
				var cntr_all = "";
				if (sRow != "" && sRow != null) {
					// for(var i=0; i<arRow.length-1; i++) {
					for ( var i = 0; i < arRow.length; i++) {
						if (sheetObj.GetCellValue(arRow[i], "t1_cntrno") != ""
								&& arRow[i] != Row
								&& sheetObj.GetCellValue(Row, "t1_pln_yrwk") == sheetObj
										.GetCellValue(arRow[i], "t1_pln_yrwk")
								&& sheetObj.GetCellValue(Row, "t1_trsp_mod_cd") == sheetObj
										.GetCellValue(arRow[i],
												"t1_trsp_mod_cd")
								&& sheetObj.GetCellValue(Row, "t1_to_ecc") == sheetObj
										.GetCellValue(arRow[i], "t1_to_ecc")
								&& sheetObj.GetCellValue(Row, "t1_fm_ecc") == sheetObj
										.GetCellValue(arRow[i], "t1_fm_ecc")) {
							cntr_all = cntr_all
									+ sheetObj.GetCellValue(arRow[i],
											"t1_cntrno") + ",";
						}
					}
				}
				document.form.cntrno_all.value = cntr_all;
				oldValue = 0; // oldvalue initializing
				var url = "EES_EQR_0094.do" + "?f_cmd=-1" // DEFAULT
						+ "&repoplan_id="
						+ sheetObj.GetCellValue(Row, "t1_repo_pln_id")
						+ "&ref_id=" + sheetObj.GetCellValue(Row, "t1_ref_id")
						+ "&bkgno="
						+ sheetObj.GetCellValue(Row, "t1_mty_bkg_no")
						+ "&targetSheet=1" + "&targetRow=" + Row
						// + "&view=false"
						+ "&view=" + view + "&fm_ecc="
						+ sheetObj.GetCellValue(Row, "t1_fm_ecc") + "&to_ecc="
						+ sheetObj.GetCellValue(Row, "t1_to_ecc")
						+ "&pln_yrwk="
						+ sheetObj.GetCellValue(Row, "t1_pln_yrwk")
						+ "&trsp_mode="
						+ sheetObj.GetCellValue(Row, "t1_trsp_mod_cd");
				// var styleInfo="dialogLeft:0px; dialogTop:0px;
				// dialogWidth:800px; dialogHeight:570px; scroll:no; status:no";
				// var modal = ComOpenWindow(url, self, styleInfo , true);
				ComOpenWindowCenter(url, "EES_EQR_0094", 800, 570, true);
			}
		}
	}
	
	if (sheetObj.ColSaveName(Col) == "t1_to_yd_cd") {
		var CellPro = sheetObj.GetCellProperty(Row, "t1_to_yd_cd", "Type");
		
		if ((sheetObj.GetCellValue(Row,"t1_repo_mty_bkg_flg") == "" || sheetObj.GetCellEditable(Row, "t1_to_yd_cd") == true) && sheetObj.GetCellValue(Row,"t1_div") != "Plan" && sheetObj.GetCellValue(Row,"t1_vvd") != "" && CellPro == "Text") {
			//sheetObj.SetCellValue(Row, "t1_to_eta_dt", "");
			var f_cmd = SEARCH17;
			var vsl = sheetObj.GetCellValue(Row, "t1_vvd");
			var to_ecc = sheetObj.GetCellValue(Row, "t1_fm_yd_cd");
			var t1tocd = sheetObj.GetCellValue(Row, "t1_to_yd_cd")
			var t1cd = sheetObj.GetCellValue(Row, "t1_to_yd_cd")
			var t1todt = sheetObj.GetCellValue(Row, "t1_to_eta_dt")			
			//var t1tocd = sheetObj.GetCellValue(Row, "t1_to_yd_cd")
			sheetObj.InitCellProperty(Row, "t1_to_yd_cd", {
				Type : "Combo"
			});
			
			sheetObj.DoRowSearch2("EES_LOCYARDINITIAL_COMMON.do",
					"row=" + Row + "&colname=t1_to_yd_cd&vsl=" + vsl
							+ "&ecc=" + to_ecc + "&item=V&f_cmd="
							+ f_cmd);
			if (sheetObj.GetCellValue(Row, "t1_to_yd_cd") == "") {
				var strcomboInfo = sheetObj.GetComboInfo(Row, "t1_to_yd_cd","Code");
				var strcomboTextInfo = sheetObj.GetComboInfo(Row, "t1_to_yd_cd","Text");
				var comboInfoarr = strcomboInfo.split("|");
				var comboInfoTextarr = strcomboTextInfo.split("|");
				if(comboInfoarr.length > 1) { //다중
					for(var k=0;k<comboInfoarr.length;k++) {
						var strAllLoc = comboInfoTextarr[k];
						var strLoc = comboInfoarr[k];
						if(strAllLoc.indexOf(t1todt) > -1 && strAllLoc.indexOf(t1cd) > -1) {
							
							sheetObj.SetCellValue(Row, "t1_to_yd_cd", strLoc,0);							
							break;
						}
					}
				}else if(comboInfoarr.length == 1){ //하나
					sheetObj.InitCellProperty(Row, "t1_to_yd_cd", {Type : "Text"});
					
					var CellPro = sheetObj.GetCellProperty(Row, "t1_to_yd_cd", "Type");
					if(CellPro == "Text") {
						var strT1ToYdCd = sheetObj.GetCellValue(Row, "t1_to_yd_cd");
						var strT1ToYdText = sheetObj.GetCellValue(Row, "t1_to_yd_cd");
						var arrT1ToYdCd = strT1ToYdCd.split("\t")
						var strToYdCoded = "";
						if(arrT1ToYdCd.length > 0) {
							strToYdCoded = arrT1ToYdCd[0].replace(/\s/gi, '');
						}
						
						sheetObj.InitCellProperty(Row, "t1_to_yd_cd", {Type : "Combo", ComboCode:strToYdCoded, ComboText: strT1ToYdText});
						
					}
				}
			}
			
			if(sheetObj.GetRowStatus(Row) != "I") {
				sheetObj.SetRowStatus(Row,"R");
			}
			var Val = "";
			
			sheetObj.SetComboOpenMode(1);
			sheetObj.SelectCell(Row,"t1_to_yd_cd",true);
		}
	}
}
/*
 * ToolTip
 */
function t1sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
	Row = sheetObj.MouseRow();
	// no support[check again]CLT
	// sheetObj.ToolTipOption="balloon:true;width:300;backcolor:#FFFFA5;forecolor:#450693;icon:0;title:To
	// Yard";
	if (sheetObj.MouseCol() == sheetObj.SaveNameCol("t1_to_yd_cd")) {
		var check = "N";
		if (sheetObj.GetCellText(Row, "t1_sortnum") == "1"
				&& sheetObj.GetCellText(Row, "t1_num") == "1"
				&& sheetObj.GetCellText(Row, "t1_past_repo_pln_flg") == "Y") {
			check = "Y";
		}
		if (check == "Y") {
			sText = sheetObj.GetCellText(Row, "t1_to_yard");
			sheetObj.SetMousePointer("Hand");
			// no support[check again]CLT sheetObj.MouseToolTipText=sText;
		} else {
			sheetObj.SetMousePointer("Default");
			// no support[check again]CLT if (sheetObj.MouseToolTipText != "") {
			// no support[check again]CLT sheetObj.MouseToolTipText="";
			// no support[check again]CLT }
		}
	} else {
		sheetObj.SetMousePointer("Default");
		// no support[check again]CLT if (sheetObj.MouseToolTipText != "") {
		// no support[check again]CLT sheetObj.MouseToolTipText="";
		// no support[check again]CLT }
	}
}
// SHEET1 ONCLICK EVENT
function t1sheet1_OnDblClick(sheetObj, Row, Col, Val) {
	if (sheetObj.ColSaveName(Col) != "t1_to_yd_cd") {
		var repo_pln_id = sheetObj.GetCellValue(Row, "t1_repo_pln_id");
		var pln_yrwk = sheetObj.GetCellValue(Row, "t1_pln_yrwk");
		var fm_loc = sheetObj.GetCellValue(Row, "t1_fm_yd_cd");
		var to_loc = sheetObj.GetCellValue(Row, "t1_to_yd_cd");
		var vsl_lane_cd = sheetObj.GetCellValue(Row, "t1_vsl_lane_cd");
		var vvd = sheetObj.GetCellValue(Row, "t1_vvd");
		// var fmTypeBy = document.form.fmTypeBy_2Old.value;
		// var toTypeBy = document.form.toTypeBy_2Old.value;
		// var atTypeBy = document.form.atTypeBy_2Old.value;
		var fmToAt = document.form.fmToAt.value;
		var param = 'repo_pln_id=' + repo_pln_id + '&pln_yrwk=' + pln_yrwk
				+ '&fm_loc=' + fm_loc + '&to_loc=' + to_loc + '&vsl_lane_cd='
				+ vsl_lane_cd + '&vvd=' + vvd
				// +'&fmTypeBy='+fmTypeBy
				// +'&toTypeBy='+toTypeBy
				// +'&atTypeBy='+atTypeBy
				+ '&fmToAt=' + fmToAt;
		if (sheetObj.GetCellValue(Row, "t1_sortnum") == '1'
				&& sheetObj.GetCellValue(Row, "t1_num") == '1'
				&& (fm_loc != '' || to_loc != '')
				&& sheetObj.ColSaveName(Col) == "t1_ts"
				&& sheetObj.GetCellValue(Row, "t1_ts") == 'Y') {
			// ComOpenWindow('EES_EQR_0129.do?'+param, window,
			// "scroll:no;status:no;help:no;dialogWidth:500px;dialogHeight:375px" ,
			// true);
			ComOpenWindowCenter('EES_EQR_0129.do?' + param, "EES_EQR_0129", 500,
					375, true);
		}
		var colName = sheetObj.ColSaveName(Col);
		var idx = sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
		if ((colName == "t1_fm_yd_cd" || colName == "t1_to_yd_cd")
				&& sheetObj.GetCellEditable(Row, colName) && idx != -1) {
			sheetObj.GetCellValue = "";
		}
	}
}

function t2sheet1_OnDblClick(sheetObj, Row, Col) {
	/*var colName = sheetObj.ColSaveName(Col);
	var idx = sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
	if ((colName == "t2_fm_yd_cd" || colName == "t2_to_yd_cd") && sheetObj.GetCellEditable(Row, colName) && idx != -1) {
		sheetObj.GetCellValue = "";
	}*/
}
// SHEET2 ONCHANGE EVENT
function t2sheet1_OnChange(sheetObj, Row, Col, Val) {
	var colName = sheetObj.ColSaveName(Col);
	// ------------- FROM-TO LOC
	// modifying----------------------------------------------------
	if (colName == "t2_fm_yd_cd" || colName == "t2_to_yd_cd") {

		if (sheetObj.GetCellValue(Row, "t2_sortnum") == "1") {
			var colname = sheetObj.ColSaveName(Col);
			var seachword = sheetObj.GetCellValue(Row, colname);

			if (seachword != "") {
				var f_cmd = SEARCHLIST04;
				// sheetObj.DoRowSearch(
				// ROW,Row=Row&searchword=seachword&Col1=t2_eccresult&f_cmd=f_cmd
				// );
				sheetObj.DoRowSearch2("EES_EQR_0020GS3.do", "Row=" + Row
						+ "&searchword=" + seachword
						+ "&Col1=t2_eccresult&f_cmd=" + f_cmd);
				// 2014.10.14 Park Young Jin
				// 존재하지 않는 ECC
				if (sheetObj.GetCellText(Row, "t2_eccresult") == "") {
					// ComShowCodeMessage("EQR90098");
					ComShowCodeMessage("EQR90238", seachword);
					sheetObj.SetCellValue(Row, colname, "", 0);
				} else if (sheetObj.GetCellValue(Row, "t2_fm_yd_cd") == sheetObj
						.GetCellValue(Row, "t2_to_yd_cd")) {
					// ComShowCodeMessage("EQR90098");
					ComShowCodeMessage("EQR70017", seachword);
					sheetObj.SetCellValue(Row, colname, "", 0);
				} else {
					sheetObj.SetCellValue(Row, colname, seachword, 0);
				}
			}
		} else if (sheetObj.GetCellValue(Row, "t2_sortnum") == "2") {
			var searchword = sheetObj.GetCellValue(Row, colName);
			var idx = sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
			if (idx == -1) {
				if (searchword != "") {
					// searchword.length >= 5 && searchword.substr(0,5)==ecc
					// 이어야만 YARD retreive가능
					var basic_ecc = "";
					if (colName == "t2_fm_yd_cd")
						basic_ecc = sheetObj.GetCellValue(Row, "t2_fm_ecc");
					else if (colName == "t2_to_yd_cd")
						basic_ecc = sheetObj.GetCellValue(Row, "t2_to_ecc");
					if (searchword.length == 7) {
						var f_cmd = SEARCH02;
						// sheetObj.InitCellProperty(Row, colName,{ Type:"Text"}
						// );
						// sheetObj.SetCellValue(Row, colName,"",0);

						// var
						// str=sheetObj.GetSearchData("EES_LOCYARDEXIST_COMMON.do"
						// ,"row="+Row+"&locyard="+searchword+"&ecc="+basic_ecc+"&colname="+colName+"&f_cmd="+f_cmd);
						// sheetObj.LoadSearchData(str,{Sync:1} );
						// sheetObj.DoRowSearch2("EES_LOCYARDEXIST_COMMON.do"
						// ,"row="+Row+"&locyard="+searchword+"&ecc="+basic_ecc+"&colname="+colName+"&f_cmd="+f_cmd);
					} else if (searchword.length >= 5
							&& searchword.substr(0, 5) == basic_ecc) {
						if (sheetObj.GetCellValue(Row, "t2_trsp_mod_cd") == "W") { // ITEM
																					// ->
																					// WATER,
																					// SEARCHLIST20
							var f_cmd = SEARCHLIST20;
							// sheetObj.DoRowSearch(
							// ROW,row=Row&searchword=searchword&colname=colName&f_cmd=f_cmd
							// );
							// sheetObj.DoRowSearch2("EES_LOCYARD_COMMON.do"
							// ,"row="+Row+"&searchword="+searchword+"&colname="+colName+"&f_cmd="+f_cmd);
							var sXml = sheetObj.GetSearchData(
									"EES_LOCYARD_COMMON.do", "row=" + Row
											+ "&searchword=" + searchword
											+ "&colname=" + colName + "&f_cmd="
											+ f_cmd);
							changeViewCombo(sheetObj, sXml);
							// sheetObj.CellValue2(row, colName) = searchword;
							sheetObj.SetCellValue(Row, colName, "", 0);
						} else { // ITEM -> TRUCK, RAIL SEARCHLIST05
							var f_cmd = SEARCHLIST05;
							// sheetObj.DoRowSearch(
							// ROW,row=Row&searchword=searchword&colname=colName&f_cmd=f_cmd
							// );
							// sheetObj.DoRowSearch2("EES_LOCYARD_COMMON.do"
							// ,"row="+Row+"&searchword="+searchword+"&colname="+colName+"&f_cmd="+f_cmd);
							var sXml = sheetObj.GetSearchData(
									"EES_LOCYARD_COMMON.do", "row=" + Row
											+ "&searchword=" + searchword
											+ "&colname=" + colName + "&f_cmd="
											+ f_cmd);
							changeViewCombo(sheetObj, sXml);
							// sheetObj.CellValue2(row, colName) = searchword;
							sheetObj.SetCellValue(Row, colName, "", 0);
						}
					} else {
						ComShowCodeMessage("EQR90171", basic_ecc);
						sheetObj.SetCellValue(Row, colName, "", 0);
					}
				}
			} else {
				var fmetd = sheetObj.GetCellValue(Row, "t2_fm_etd_dt");
				var fryard = sheetObj.GetCellValue(Row, "t2_fm_yd_cd");
				var toyard = sheetObj.GetCellValue(Row, "t2_to_yd_cd");
				var item = sheetObj.GetCellValue(Row, "t2_trsp_mod_cd");
				if (fryard.length == 7 && toyard.length == 7
						&& fmetd.length == 8) {
					if (fmetd != ""
							&& sheetObj.GetCellValue(Row, "t2_vvd") == "") {
						sheetObj.SetCellValue(Row, "t2_to_eta_dt", "", 0);// eta
																			// initializing
						var f_cmd = SEARCHLIST18;
						// sheetObj.DoRowSearch(
						// ROW,row=Row&searchword=fmetd&fryard=fryard&toyard=toyard&item=item&colname=t2_to_eta_dt&f_cmd=f_cmd
						// );
						sheetObj.DoRowSearch2("EES_SEARCH_ETA.do", "row=" + Row
								+ "&searchword=" + fmetd + "&fryard=" + fryard
								+ "&toyard=" + toyard + "&item=" + item
								+ "&colname=t2_to_eta_dt&f_cmd=" + f_cmd);
					}
				}
			}
		}
	}
	// VVD inserting existing retreive (ADD ROW)
	if (colName == "t2_vvd" && sheetObj.GetCellValue(Row, "t2_sortnum") == "2") {
		var searchword = sheetObj.GetCellValue(Row, colName);
		var idx = sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
		var vvd_length = searchword.length;
		if (idx == -1) {
			if (searchword != "") {
				if (vvd_length < 9) {
					// Please enter ' + msg1 + ' digits long data.
					ComShowCodeMessage("EQR90078", "9");
					sheetObj.SetCellValue(Row, "t2_vsl_lane_cd", "");
					sheetObj.SetCellValue(Row, "t2_fm_etd_dt", "");
					sheetObj.SetCellValue(Row, "t2_to_eta_dt", "");
					sheetObj.SetCellEditable(Row, "t2_fm_etd_dt", 1);
					sheetObj.SetCellEditable(Row, "t2_to_eta_dt", 1);
					sheetObj.SetCellValue(Row, "t2_vvd", "");
					sheetObj.SelectCell(Row, "t2_vvd");
				} else {
					var f_cmd = SEARCH05;
					// sheetObj.InitCellProperty(row, colName, dtData);
					// sheetObj.CellValue2(Row, colName) = "";
					sheetObj.SetCellValue(Row, "t2_vsl_lane_cd", "", 0);
					var division = "etd";
					var repoplnid = sheetObj
							.GetCellValue(Row, "t2_repo_pln_id");
					var plnyrwk = sheetObj.GetCellValue(Row, "t2_pln_yrwk");
					var ecccd = sheetObj.GetCellValue(Row, "t2_fm_ecc");
					var scnr_id = document.form.scnr_id.value;
					var actionUrl = "EES_VVDEXIST_IFRAME.do?row=" + Row
							+ "&vvd=" + searchword + "&colname=" + colName;
					actionUrl += "&colname1=t2_vsl_lane_cd&f_cmd=" + f_cmd;
					actionUrl += "&division=" + division;
					actionUrl += "&repoplnid=" + repoplnid;
					actionUrl += "&ecccd=" + ecccd;
					actionUrl += "&plnyrwk=" + plnyrwk;
					actionUrl += "&scnr_id=" + scnr_id;
					// document.iframe059_vvdexist.location.href=actionUrl;
					
					if (sheetObj.GetCellValue(Row,"t2_trsp_mod_cd") == "W" && sheetObj.GetCellValue(Row,"t2_div") != "Plan") {
						
						var f_cmd = SEARCH19;
						var from_ecc = sheetObj.GetCellValue(Row,"t2_fm_ecc");
						var t2fromcd = sheetObj.GetCellValue(Row,"t2_fm_yd_cd");						
						var vsl = sheetObj.GetCellValue(Row, "t2_vvd");
						
						var to_ecc = sheetObj.GetCellValue(Row,"t2_to_ecc");
						var t2tocd = sheetObj.GetCellValue(Row,"t2_to_yd_cd");
						
						var from_CellPro = sheetObj.GetCellProperty(Row, "t2_fm_yd_cd", "Type");
						var to_CellPro = sheetObj.GetCellProperty(Row, "t2_to_yd_cd", "Type");
						
						if(from_CellPro == "Text") {
							sheetObj.InitCellProperty(Row, "t2_fm_yd_cd", {
								Type : "Combo"
							});
						}
						
						if(to_CellPro == "Text") {
							sheetObj.InitCellProperty(Row, "t2_to_yd_cd", {
								Type : "Combo"
							});
						}
						
						sheetObj.DoRowSearch2("EES_LOCYARDINITIAL_COMMON.do",
								"row=" + Row + "&colname=t2_fm_yd_cd&vsl="
										+ vsl + "&ecc="+ from_ecc 
										+ "&item=W&f_cmd=" + f_cmd);
						
						
						sheetObj.DoRowSearch2("EES_LOCYARDINITIAL_COMMON.do", 
								"row=" + Row + "&colname=t2_to_yd_cd&vsl="
										+ vsl + "&ecc=" + to_ecc +"&from_ecc=" +  from_ecc
										+ "&item=W&f_cmd=" + f_cmd);
						
						sheetObj.SetCellValue(Row, "t2_fm_yd_cd", "", 0);
						sheetObj.SetCellValue(Row, "t2_to_yd_cd", "", 0);
					}
				}
			}else{
				if (sheetObj.GetCellValue(Row,"t2_trsp_mod_cd") == "W" && sheetObj.GetCellValue(Row,"t2_div") != "Plan") {
					
					var f_cmd = SEARCH19;
					var from_ecc = sheetObj.GetCellValue(Row,"t2_fm_ecc");
					var t2fromcd = sheetObj.GetCellValue(Row,"t2_fm_yd_cd");						
					var vsl = sheetObj.GetCellValue(Row, "t2_vvd");
					
					var to_ecc = sheetObj.GetCellValue(Row,"t2_to_ecc");
					var t2tocd = sheetObj.GetCellValue(Row,"t2_to_yd_cd");
					
					var from_CellPro = sheetObj.GetCellProperty(Row, "t2_fm_yd_cd", "Type");
					var to_CellPro = sheetObj.GetCellProperty(Row, "t2_to_yd_cd", "Type");
					
					if(from_CellPro == "Text") {
						sheetObj.InitCellProperty(Row, "t2_fm_yd_cd", {
							Type : "Combo"
						});
					}
					
					if(to_CellPro == "Text") {
						sheetObj.InitCellProperty(Row, "t2_to_yd_cd", {
							Type : "Combo"
						});
					}
					
					sheetObj.DoRowSearch2("EES_LOCYARDINITIAL_COMMON.do",
							"row=" + Row + "&colname=t2_fm_yd_cd&vsl="
									+ vsl + "&ecc="+ from_ecc 
									+ "&item=W&f_cmd=" + f_cmd);
					
					
					sheetObj.DoRowSearch2("EES_LOCYARDINITIAL_COMMON.do", 
							"row=" + Row + "&colname=t2_to_yd_cd&vsl="
									+ vsl + "&ecc=" + to_ecc +"&from_ecc=" +  from_ecc
									+ "&item=W&f_cmd=" + f_cmd);
					
					sheetObj.SetCellValue(Row, "t2_fm_yd_cd", "", 0);
					sheetObj.SetCellValue(Row, "t2_to_yd_cd", "", 0);
				}
			}
		} else {
			if (sheetObj.GetCellValue(Row, "t2_vvd").length > 9) {
				if (sheetObj.GetCellValue(Row, "t2_vvd").substr(0, 6) == "MANUAL") {
					sheetObj.SetCellValue(Row, "t2_vvd", "", 0);
					sheetObj.SetCellValue(Row, "t2_vsl_lane_cd", "", 0);
					sheetObj.SetCellValue(Row, "t2_fm_etd_dt", "", 0);
					sheetObj.SetCellValue(Row, "t2_to_eta_dt", "", 0);
					sheetObj.SetCellValue(Row, "t2_fm_yd_cd", "", 0);
					sheetObj.SetCellValue(Row, "t2_to_yd_cd", "", 0);
					sheetObj.SetCellEditable(Row, "t2_vsl_lane_cd", 0);// lane
																		// insertingdisable
					sheetObj.SetCellEditable(Row, "t2_vvd", 0);// vvd
																// insertingdisable
					sheetObj.SetCellEditable(Row, "t2_fm_yd_cd", 1);
					sheetObj.SetCellEditable(Row, "t2_fm_etd_dt", 1);
				} else {
					// && sheetObj.CellValue(Row,"t2_vvd").length > 9
					var vvd = sheetObj.GetCellValue(Row, "t2_vvd").substr(0, 9);
					var lane = sheetObj.GetCellValue(Row, "t2_vvd").substr(10,
							3);
					var etd = sheetObj.GetCellValue(Row, "t2_vvd")
							.substr(14, 8);
					var eta = sheetObj.GetCellValue(Row, "t2_vvd")
							.substr(23, 8);
					var fm_yd = sheetObj.GetCellValue(Row, "t2_vvd").substr(32,
							7);
					var to_yd = sheetObj.GetCellValue(Row, "t2_vvd").substr(40,
							7);
					// ETD ,FM YD automatically inserting
					sheetObj.SetCellEditable(Row, "t2_fm_yd_cd", 0);
					sheetObj.SetCellEditable(Row, "t2_fm_etd_dt", 0);
					// sheetObj.CellValue2(Row,"t2_vvd") = vvd;
					sheetObj.SetCellValue(Row, "t2_vsl_lane_cd", lane, 0);
					sheetObj.SetCellValue(Row, "t2_fm_etd_dt", etd, 0);
					sheetObj.SetCellValue(Row, "t2_to_eta_dt", eta, 0);
					sheetObj.SetCellValue(Row, "t2_fm_yd_cd", fm_yd, 0);
					sheetObj.SetCellValue(Row, "t2_to_yd_cd", to_yd, 0);
				}
			}
		}
	}
	// ------ LANE modifying (EXECUTE ROW, WATER
	// ITEM)-------------------------------------------------------------
	if (sheetObj.ColSaveName(Col) == "t2_vsl_lane_cd"
			&& sheetObj.GetCellValue(Row, "t2_trsp_mod_cd") == "W"
			&& sheetObj.GetCellValue(Row, "t2_sortnum") == "2"
			&& sheetObj.GetCellValue(Row, "t2_vsl_lane_cd").length == 3) {
		// ------ FM LOC YARD retreive [START] -----------
		var f_cmd = SEARCH01;
		var vsl = sheetObj.GetCellValue(Row, "t2_vvd");
		var from_ecc = sheetObj.GetCellValue(Row, "t2_fm_ecc");
		sheetObj.InitCellProperty(Row, "t2_fm_yd_cd", {
			Type : "Text",
			AcceptKeys : "E|N",
			InputCaseSensitive : 1
		});
		sheetObj.SetCellValue(Row, "t2_fm_yd_cd", "", 0);
		// sheetObj.DoRowSearch(
		// ROW,row=Row&colname=t2_fm_yd_cd&vsl=vsl&ecc=from_ecc&item=W&f_cmd=f_cmd"&false"
		// );
		// sheetObj.DoRowSearch2("EES_LOCYARDINITIAL_COMMON.do"
		// ,"row="+Row+"&colname=t2_fm_yd_cd&vsl="+vsl+"&ecc="+from_ecc+"&item=W&f_cmd="+f_cmd);
		var sXml = sheetObj.GetSearchData("EES_LOCYARDINITIAL_COMMON.do",
				"row=" + Row + "&colname=t2_fm_yd_cd&vsl=" + vsl + "&ecc="
						+ from_ecc + "&item=W&f_cmd=" + f_cmd);
		changeViewCombo(sheetObj, sXml);
		// ------ FM LOC YARD retreive [END] -----------
		// ------ TO LOC YARD retreive [START] -----------
		var f_cmd = SEARCH01;
		var vsl = sheetObj.GetCellValue(Row, "t2_vvd");
		var to_ecc = sheetObj.GetCellValue(Row, "t2_to_ecc");
		sheetObj.InitCellProperty(Row, "t2_to_yd_cd", {
			Type : "Text",
			AcceptKeys : "E|N",
			InputCaseSensitive : 1
		});
		sheetObj.SetCellValue(Row, "t2_to_yd_cd", "", 0);
		// sheetObj.DoRowSearch(
		// ROW,row=Row&colname=t2_to_yd_cd&vsl=vsl&ecc=to_ecc&item=W&f_cmd=f_cmd
		// );
		// sheetObj.DoRowSearch2("EES_LOCYARDINITIAL_COMMON.do"
		// ,"row="+Row+"&colname=t2_to_yd_cd&vsl="+vsl+"&ecc="+to_ecc+"&item=W&f_cmd="+f_cmd);
		var sXml = sheetObj.GetSearchData("EES_LOCYARDINITIAL_COMMON.do",
				"row=" + Row + "&colname=t2_to_yd_cd&vsl=" + vsl + "&ecc="
						+ to_ecc + "&item=W&f_cmd=" + f_cmd);
		changeViewCombo(sheetObj, sXml);
		// ------ TO LOC YARD retreive [END] -----------
	}
	// ------ WEEK modifying (PLAN
	// ROW)-------------------------------------------------------------
	if (sheetObj.ColSaveName(Col) == "t2_pln_yrwk"
			&& sheetObj.GetCellValue(Row, "t2_sortnum") == "1") {
		weekInput = sheetObj.GetCellValue(Row, Col); // input data week
		// 1) checking from is week
		if (weekInput.length < 6) {
			// ComShowMessage("please input week data format ! ");
			ComShowCodeMessage("EQR90056");
			sheetObj.SetCellValue(Row, Col, "", 0);
			sheetObj.SelectCell(Row, Col);
			return false;
		} else {
			if (weekInput.substring(4, 6) < 01
					|| weekInput.substring(4, 6) > 53) {
				// ComShowMessage("please input week data format ! ");
				ComShowCodeMessage("EQR90056");
				sheetObj.SetCellValue(Row, Col, "", 0);
				sheetObj.SelectCell(Row, Col);
				return false;
			} else {
				// 2) FROM WEEK <= weekInput <=TO WEEK
				var fromWeek = document.form.st_year.value
						+ document.form.st_weekly.value;
				var toWeek = document.form.max_plnYr.value
						+ document.form.max_weekly.value;
				if (weekInput < fromWeek || weekInput > toWeek) {
					ComShowCodeMessage("EQR90127", fromWeek, toWeek);
					sheetObj.SetCellValue(Row, Col, "", 0);
					sheetObj.SelectCell(Row, Col);
					return false;
				}
			}
		}
	}

	if (sheetObj.ColSaveName(Col) == "t2_fm_etd_dt") {
		var etd = sheetObj.GetCellValue(Row, "t2_fm_etd_dt");
		var eta = sheetObj.GetCellValue(Row, "t2_to_eta_dt");
		if (document.form.nowDay.value > etd) {
			// row add 비활성
			//ComShowCodeMessage("EQR01144");
			//return false;
		}
	}

	if (sheetObj.ColSaveName(Col) == "t2_to_eta_dt") {
		if (document.form.nowDay.value > eta) {
			// row add 비활성
			//ComShowCodeMessage("EQR01144");
			//return false;
		}
	}

	// ------------- ETD, ETA modifying(PLAN, EXECUTE ROW
	// ------------------------------------------------
	if (sheetObj.ColSaveName(Col) == "t2_fm_etd_dt"
			|| sheetObj.ColSaveName(Col) == "t2_to_eta_dt") {
		var etd = sheetObj.GetCellValue(Row, "t2_fm_etd_dt");
		var eta = sheetObj.GetCellValue(Row, "t2_to_eta_dt");

		// -- PLAN ROW (week inserting.modifying)
		if (sheetObj.GetCellValue(Row, "t2_sortnum") == "1") {
			var weekInput = sheetObj.GetCellValue(Row, Col); // input data
																// week
			var pln_yrwk = sheetObj.GetCellValue(Row, "t2_pln_yrwk"); // pln
																		// yrwk
			var maxWeek = document.form.max_plnYr.value
					+ document.form.max_weekly.value;
			if (pln_yrwk.length != 6) {
				// pln yrwk 를 inserting하세요.
				ComShowCodeMessage("EQR90001", "Week");
				sheetObj.SetCellValue(Row, Col, "", 0);
				sheetObj.SelectCell(Row, "t2_pln_yrwk");
				return false;
			}
			if (weekInput.length < 6) {
				// ComShowMessage("please input week data format ! ");
				ComShowCodeMessage("EQR90056");
				sheetObj.SetCellValue(Row, Col, "", 0);
				sheetObj.SelectCell(Row, Col);
				return false;
			} else {
				for ( var i = 0; i < weekInput.length; i++) {
					if (!('0' <= weekInput.charAt(i) && weekInput.charAt(i) <= '9')) {
						// ComShowMessage("please input week data format ! ");
						ComShowCodeMessage("EQR90056");
						sheetObj.SetCellValue(Row, Col, "", 0);
						sheetObj.SelectCell(Row, Col);
						sheetObj.SelectCell(Row, Col);
						return false;
					}
				}
				if (weekInput.substring(4, 6) < 01
						|| weekInput.substring(4, 6) > 53) {
					// ComShowMessage("please input week data format ! ");
					ComShowCodeMessage("EQR90056");
					sheetObj.SetCellValue(Row, Col, "", 0);
					sheetObj.SelectCell(Row, Col);
					return false;
				}
				if (weekInput < pln_yrwk || weekInput > maxWeek) {
					ComShowCodeMessage("EQR90127", pln_yrwk, maxWeek);
					sheetObj.SetCellValue(Row, Col, "", 0);
					sheetObj.SelectCell(Row, Col);
					return false;
				}
				if (etd.length == 6 && eta.length == 6) {
					if (etd > eta) {
						ComShowCodeMessage("EQR90077");
						sheetObj.SetCellValue(Row, Col, "", 0);
						sheetObj.SelectCell(Row, Col);
					}
				}
			}
			// -- EXECUTE ROW (date modifying)
		} else if (sheetObj.GetCellValue(Row, "t2_sortnum") == "2") {
			if (etd.length == 8 && eta.length == 8) {
				if (etd > eta) {
					ComShowCodeMessage("EQR90077");
					sheetObj.SetCellValue(Row, Col, "", 0);
					sheetObj.SelectCell(Row, Col);
				}
			}
		}
	}
	// ------------- Reason
	// modifying----------------------------------------------------
	if (sheetObj.ColSaveName(Col) == "t2_repo_pln_fb_rsn_cd") {
		if ((sheetObj.GetRowStatus(Row) == "I" || sheetObj.GetRowStatus(Row) == "U")
				&& sheetObj.GetCellValue(Row, "t2_pass_final") == "F") {
			var week = sheetObj.GetCellValue(Row, "t2_pln_yrwk");
			var item = sheetObj.GetCellValue(Row, "t2_trsp_mod_cd");
			var fm_ecc = sheetObj.GetCellValue(Row, "t2_fm_ecc");
			var to_ecc = sheetObj.GetCellValue(Row, "t2_to_ecc");
			var sRow = sheetObj.FindStatusRow("I|U");
			var arRow = sRow.split(";");
			if (sRow != "" && sRow != null) {
				// for(var i=0; i<arRow.length-1; i++) {
				for ( var i = 0; i < arRow.length; i++) {
					if (sheetObj.GetCellValue(arRow[i], "t2_sortnum") == 2
							&& sheetObj.GetCellValue(arRow[i], "t2_num") == 1
							&& sheetObj.GetCellValue(arRow[i], "t2_pln_yrwk") == week
							&& sheetObj
									.GetCellValue(arRow[i], "t2_trsp_mod_cd") == item
							&& sheetObj.GetCellValue(arRow[i], "t2_to_ecc") == to_ecc
							&& sheetObj.GetCellValue(arRow[i], "t2_fm_ecc") == fm_ecc
							&& sheetObj.GetCellValue(arRow[i], "t2_pass_final") == "F") {
						sheetObj.SetCellValue(arRow[i],
								"t2_repo_pln_fb_rsn_cd", sheetObj.GetCellValue(
										Row, "t2_repo_pln_fb_rsn_cd"));
						otherCombo(sheetObj, Row, Col);
					}
				}
			}
		} else {
			otherCombo(sheetObj, Row, Col);
		}
	}
	// ---------------------- CNTR NO optional
	// ----------------------------------------------------------------
	if (sheetObj.ColSaveName(Col) == "t2_tpszno") {
		var tpszConArr = Val.split(",");
		var vol = 0;
		for ( var i = 0; i < consTpszArr.length; i++) {
			for ( var j = 0; j < tpszConArr.length; j++) {
				if (consTpszArr[i] == tpszConArr[j])
					vol++;
			}
			// if(vol > sheetObj.GetCellValue(Row, "t2_vol"+consTpszArr[i])) {
			oldValue = sheetObj.GetCellValue(Row, "t2_vol" + consTpszArr[i]);
			sheetObj.SetCellValue(Row, "t2_vol" + consTpszArr[i], vol);// onchange
																		// event
			// }
			vol = 0;
		}
	}
	// ------- in case of vol modified
	// ----------------------------------------------------------
	if (sheetObj.ColSaveName(Col).substring(0, 6) == "t2_vol") {
		var limitFlag = false;
		var cntrVol = 0;
		var tpszName = sheetObj.ColSaveName(Col).substring(6, 8);
		if (sheetObj.GetCellValue(Row, "t2_cntrimage") == "0") {
			cntrVol = sheetObj.GetCellValue(Row, "t2_cntrvol" + tpszName);
			// ComShowMessage("1 Val : "+Val+", CNTR : "+cntrVol);
			if (eval(Val) < eval(cntrVol)) {
				limitFlag = true;
			}
		} else if (sheetObj.GetCellValue(Row, "t2_cntrimage") == "1"
				&& sheetObj.GetCellValue(Row, "t2_cntrno") != "") {
			var tpszConArr = sheetObj.GetCellValue(Row, "t2_tpszno").split(",");
			for ( var j = 0; j < tpszConArr.length; j++) {
				if (tpszName == tpszConArr[j])
					cntrVol++;
			}
			if (eval(Val) < eval(cntrVol)) {
				limitFlag = true;
			}
		}
		if (limitFlag) {
			ComShowCodeMessage("EQR90048", tpszName, cntrVol);
			sheetObj.SetCellValue(Row, Col, oldValue, 0);// rollback
		} else {
			// var diffVol = eval(Val - sheetObj.CellSearchValue(Row,Col));
			var diffVol = eval(Val - oldValue);
			// ----- checking pass feedback for each tpsz vol (START) ----
			var week = sheetObj.GetCellValue(Row, "t2_pln_yrwk");
			var item = sheetObj.GetCellValue(Row, "t2_trsp_mod_cd");
			var fm_ecc = sheetObj.GetCellValue(Row, "t2_fm_ecc");
			var to_ecc = sheetObj.GetCellValue(Row, "t2_to_ecc");
			var tpsz = sheetObj.ColSaveName(Col).substring(6, 8);
			var planVol = 0;
			var exeMaxVol = 0;
			var exeFinalVol = 0;
			var basicRatio = 0;
			var basicVol = 0;
			var targetVol = 0;
			var targetRatio = 0;
			var planRow = 0;
			for ( var i = 0; i < sheetObj.RowCount(); i++) {
				if (sheetObj.GetCellValue(i, "t2_sortnum") == 1
						&& sheetObj.GetCellValue(i, "t2_num") == 1
						&& sheetObj.GetCellValue(i, "t2_pln_yrwk") == week
						&& sheetObj.GetCellValue(i, "t2_trsp_mod_cd") == item
						&& sheetObj.GetCellValue(i, "t2_fm_ecc") == fm_ecc
						&& sheetObj.GetCellValue(i, "t2_to_ecc") == to_ecc) {
					// planRow=i;
					planRow = i;
					break;
				}
			}
			if (planRow == 0) {
				// ComShowCodeMessage("EQR90067");
			} else {

				planVol = sheetObj.GetCellValue(planRow, "t2_vol" + tpsz);
				exeMaxVol = sheetObj.GetCellValue(planRow, "t2_maxvol" + tpsz);
				basicRatio = sheetObj.GetCellValue(planRow, "t2_basicratio"
						+ tpsz);
				basicVol = sheetObj.GetCellValue(planRow, "t2_basicvol" + tpsz);
				// ComShowMessage("planRow : "+ planRow+ ", planVol :
				// "+planVol+", exeMaxVol : "+exeMaxVol+", basicRatio :
				// "+basicRatio+", basicVol : "+basicVol);
				// vol calculation
				exeFinalVol = eval(exeMaxVol) + eval(diffVol);
				if (exeFinalVol < 0)
					exeFinalVol = 0;
				targetVol = Math.abs(eval(planVol) - eval(exeFinalVol));
				// if(targetVol < 0) targetVol = 0;
				// ratio calculation
				if (exeFinalVol == 0 || planVol == 0) {
					targetRatio = 0;
				} else {
					targetRatio = Math
							.round((eval(exeFinalVol) / eval(planVol)) * 100);
				}
				sheetObj.SetCellValue(planRow, "t2_maxvol" + tpsz, exeFinalVol,
						0);

				if (sheetObj.GetCellValue(Row, "t2_div") != "Plan") {
					sheetObj.SetRowStatus(planRow, "R");
				}
				sheetObj.SetRowBackColor(planRow, "#CBEFEA");
				var formula_result = "";
				if (basicVol > targetVol && basicRatio < targetRatio) {
					formula_result = "SUCCESS";
					sheetObj.SetCellValue(Row, "t2_pass" + tpsz, '', 0);
					sheetObj.SetCellFontColor(Row, "t2_vol" + tpsz, sheetObj
							.GetDataFontColor());
				} else {
					formula_result = "FAILURE";
					sheetObj.SetCellValue(Row, "t2_pass" + tpsz, 'F', 0);
					// sheetObj.SetCellFontColor(Row,"t2_vol"+tpsz,"#F1541F");
				}

			}
			// ---- checking pass feedback for each tpsz vol (END) ----
			// -----------------------------------------------------------------------------------------
			// --- (fomula : amt = vol * unit cost)
			
			// --- type size total vol, amt calculation
			// --- sub total vol, amt calculation
			// --- grand total vol, amt calculation
			var grandTotalRow = 0;
			var subTotalRow = 0;
			// Grand Total
			while (true) {
				grandTotalRow = sheetObj.FindText("t2_num", 3,
						grandTotalRow + 1); // TOTAL ROW retreive
				if (grandTotalRow == -1) {
					break;
				} else {
					if (sheetObj.GetCellValue(grandTotalRow, "t2_sortnum") == 2) { // Execution
																					// Row
																					// retreive
						sheetObj.SetCellValue(grandTotalRow, Col, eval(sheetObj
								.GetCellValue(grandTotalRow, Col))
								+ eval(diffVol), 0);
						
						sheetObj.SetCellValue(grandTotalRow, "t2_totalvol",
								eval(sheetObj.GetCellValue(grandTotalRow,
										"t2_totalvol"))
										+ eval(diffVol), 0);
						
						// sheetObj.SetRowStatus(grandTotalRow,"R");
						sheetObj.SetRowBackColor(grandTotalRow, "#FEBDB6");
					}
				}
			}
			while (true) {
				subTotalRow = sheetObj.FindText("t2_num", 2, subTotalRow + 1); // SUB
																				// ROW
																				// retreive
				if (subTotalRow == -1) {
					break;
				} else {
					if (sheetObj.GetCellValue(subTotalRow, "t2_sortnum") == 2) { // Execution
																					// Row
																					// retreive
						if (sheetObj.GetCellValue(subTotalRow, "t2_pln_yrwk")
								.substr(0, 6) == sheetObj.GetCellValue(Row,
								"t2_pln_yrwk")) {
							sheetObj.SetCellValue(subTotalRow, Col,
									eval(sheetObj
											.GetCellValue(subTotalRow, Col))
											+ eval(diffVol), 0);
							
							sheetObj.SetCellValue(subTotalRow, "t2_totalvol",
									eval(sheetObj.GetCellValue(subTotalRow,
											"t2_totalvol"))
											+ eval(diffVol), 0);
							
							// sheetObj.SetRowStatus(subTotalRow,"R");
							sheetObj.SetRowBackColor(subTotalRow, "#F9DF9B");
						}
					}
				}
			}
			sheetObj.SetCellValue(Row, "t2_totalvol", eval(sheetObj
					.GetCellValue(Row, "t2_totalvol"))
					+ eval(diffVol), 0);
			
			sheetObj.SetCellValue(Row, "t2_flag"
					+ sheetObj.ColSaveName(Col).substring(6, 8), "T", 0);
			oldValue = Val;
		}
		if (sheetObj.GetCellValue(Row, "t2_div") == "Plan") {
			sheetObj.SetRowStatus(Row, "I");
		}
	}

	// ---------------------- MTY Repo BKG check box ------------------------
	if (sheetObj.ColSaveName(Col) == "t2_repo_mty_bkg_flg") {
		// MTY Repo BKG checked 다른 row를 retreive
		var sRow = sheetObj.FindStatusRow("U");
		var arRow = sRow.split(";");
		var cntr_all = "";
		var year_week = sheetObj.GetCellValue(Row, "t2_pln_yrwk"); // week
		var load_loc = sheetObj.GetCellValue(Row, "t2_sort").substring(0, 5); // from
																				// yard
																				// ecc
		var vvd = sheetObj.GetCellValue(Row, "t2_vvd"); // vvd
		var co_cd = sheetObj.GetCellValue(Row, "t2_co_cd"); // company
		var bkg_count = 0;
		if (sRow != "" && sRow != null) {
			// for(var i=0; i<arRow.length-1; i++) {
			for ( var i = 0; i < arRow.length; i++) {
				if (sheetObj.GetCellValue(arRow[i], "t2_repo_mty_bkg_flg") == "1") {
					bkg_count++;
				}
			}
		}
		if (bkg_count > 1) {
			ComShowCodeMessage("EQR90152", "MTY Repo BKG");
			sheetObj.SetCellValue(Row, "t2_repo_mty_bkg_flg", 0, 0);
			return false;
		}
		if (vvd == "" || vvd == null) {
			ComShowCodeMessage("EQR90122");
			sheetObj.SetCellValue(Row, "t2_repo_mty_bkg_flg", 0, 0);
			// }else if(sRow!="" && sRow!=null && sheetObj.GetCellValue(Row,
			// "t2_repo_mty_bkg_flg")==1 && arRow.length>1) {
		} else if (sRow != "" && sRow != null
				&& sheetObj.GetCellValue(Row, "t2_repo_mty_bkg_flg") == 1
				&& arRow.length > 0) {
			// for(var i=0; i<arRow.length-1; i++) {
			for ( var i = 0; i < arRow.length; i++) {
				if (sheetObj.GetCellValue(arRow[i], "t2_repo_mty_bkg_flg") == 1) {
					if (year_week == sheetObj.GetCellValue(arRow[i],
							"t2_pln_yrwk")
							&& load_loc == sheetObj.GetCellValue(arRow[i],
									"t2_sort").substring(0, 5)
							&& sheetObj.GetCellValue(arRow[i], "t2_vvd") != ""
							&& vvd == sheetObj.GetCellValue(arRow[i], "t2_vvd")
							&& co_cd == sheetObj.GetCellValue(arRow[i],
									"t2_co_cd")) {
						sheetObj.SetCellValue(Row, 't2_repobkg_flag', "T");// repobkg
						sheetObj.SetCellEditable(Row, 't2_so_iss_flg', 0);// so
																			// send
																			// check
																			// box
																			// disable
						// sheetObj.CellValue2(Row, 't2_so_iss_flg') = 1; // so
						// send checked modifying
					} else {
						if (sheetObj.GetCellValue(arRow[i], "t2_vvd") == "") {
							ComShowCodeMessage("EQR90122");
						} else {
							ComShowCodeMessage("EQR90121");
						}
						sheetObj.SetCellValue(Row, "t2_repo_mty_bkg_flg", 0, 0);
						break;
					}
				}
			}
		}
		if (sheetObj.GetCellValue(Row, "t2_repo_mty_bkg_flg") == 0) {
			sheetObj.SetCellValue(Row, 't2_repobkg_flag', "F", 0);
			if (sheetObj.GetCellValue(Row, "t2_so_iss_flg") != 1)
				sheetObj.SetCellEditable(Row, 't2_so_iss_flg', 1);// so send
																	// check box
																	// enable
			// sheetObj.CellValue2(Row, 't2_so_iss_flg') = 0; // so send
			// unchecked
		}
	}
	// -------- SO SEND check box -----
	if (sheetObj.ColSaveName(Col) == "t2_so_iss_flg"
			&& sheetObj.GetCellValue(Row, "t2_trsp_mod_cd") == "W") { // so
																		// send
																		// image
																		// cell
		if (sheetObj.GetCellValue(Row, "t2_so_iss_flg") == "1") { // BKG check
																	// box
																	// disable
			sheetObj.SetCellEditable(Row, "t2_repo_mty_bkg_flg", "FALSE");
		} else { // BKG check box enable
			// if(sheetObj.SetCellValue(Row,"t2_repo_mty_bkg_flg")!=1 )
			// sheetObj.GetCellEditable(Row, "t2_repo_mty_bkg_flg","TRUE");
			if (sheetObj.GetCellValue(Row, "t2_repo_mty_bkg_flg") != 1)
				sheetObj.SetCellEditable(Row, "t2_repo_mty_bkg_flg", 1);
		}
	}
	// ---------- ETD modifying (EXECUTE ROW)
	// ----------------------------------------------
	if (sheetObj.ColSaveName(Col) == "t2_fm_etd_dt"
			&& sheetObj.GetCellValue(Row, "t2_sortnum") == "2"
			&& sheetObj.GetCellValue(Row, "t2_fm_etd_dt") != "") { // ETD
																	// modifying
		var etd = sheetObj.GetCellValue(Row, "t2_fm_etd_dt");
		var frdate = sheetObj.GetCellValue(Row, "t2_week_fromdate");
		var todate = sheetObj.GetCellValue(Row, "t2_week_todate");
		// var searchword = sheetObj.EditText;
		var searchword = sheetObj.GetCellValue(Row, "t2_fm_etd_dt");
		var colname = sheetObj.ColSaveName(Col);
		var fryard = sheetObj.GetCellValue(Row, "t2_fm_yd_cd");
		var toyard = sheetObj.GetCellValue(Row, "t2_to_yd_cd");
		var item = sheetObj.GetCellValue(Row, "t2_trsp_mod_cd");
		if (etd < frdate || etd > todate) {
			ComShowCodeMessage("EQR90141", "ETD", frdate, todate);
			sheetObj.SetCellValue(Row, "t2_fm_etd_dt", "");
			sheetObj.SetCellEditable(Row, "t2_fm_etd_dt", 1);
			return false;
		} else {
			if (fryard.length == 7 && toyard.length == 7 && searchword != "") {
				if (sheetObj.GetCellValue(Row, "t2_vvd").length >= 9) {
					var f_cmd = SEARCH05;
					var division = "eta";
					var repoplnid = sheetObj
							.GetCellValue(Row, "t2_repo_pln_id");
					var plnyrwk = sheetObj.GetCellValue(Row, "t2_pln_yrwk");
					var ecccd = sheetObj.GetCellValue(Row, "t2_to_ecc");
					var actionUrl = "EES_VVDEXIST_IFRAME.do?row=" + Row
							+ "&vvd=" + sheetObj.GetCellValue(Row, "t2_vvd")
							+ "&colname=t2_fm_eta_dt";
					actionUrl += "&colname1=t2_vsl_lane_cd&f_cmd=" + f_cmd;
					actionUrl += "&division=" + division;
					actionUrl += "&repoplnid=" + repoplnid;
					actionUrl += "&ecccd=" + ecccd;
					actionUrl += "&plnyrwk="
							+ sheetObj.GetCellValue(Row, "t2_fm_etd_dt");
					// document.iframe059_vvdexist.location.href=actionUrl;
				} else {
					sheetObj.SetCellValue(Row, "t2_to_eta_dt", "", 0);// eta
																		// initializing
					var f_cmd = SEARCHLIST18;
					// sheetObj.DoRowSearch(
					// ROW,row=Row&searchword=searchword&fryard=fryard&toyard=toyard&item=item&colname=t2_to_eta_dt&f_cmd=f_cmd
					// );
					sheetObj.DoRowSearch2("EES_SEARCH_ETA.do", "row=" + Row
							+ "&searchword=" + searchword + "&fryard=" + fryard
							+ "&toyard=" + toyard + "&item=" + item
							+ "&colname=t2_to_eta_dt&f_cmd=" + f_cmd);
				}
			} else {
			}
		}
	}
	// ---------- ETA modifying (EXECUTE ROW)
	// ----------------------------------------------
	if (sheetObj.ColSaveName(Col) == "t2_to_eta_dt"
			&& sheetObj.GetCellValue(Row, "t2_sortnum") == "2"
			&& sheetObj.GetCellValue(Row, "t2_to_eta_dt") != "") {
		var eta = sheetObj.GetCellValue(Row, "t2_to_eta_dt");
		var frdate = sheetObj.GetCellValue(Row, "t2_week_fromdate");
		var maxdate = sheetObj.GetCellValue(Row, "t2_week_maxdate"); // week
																		// fromdate
																		// + 7주
		if (eta < frdate || eta > maxdate) {
			ComShowCodeMessage("EQR90141", "ETA", frdate, maxdate);
			sheetObj.SetCellValue(Row, "t2_to_eta_dt", "");
			sheetObj.SetCellEditable(Row, "t2_to_eta_dt", 1);
			return false;
		}
	}
	/*
	 * if (sheetObj.ColSaveName(Col) == "t2_vsl_lane_cd"){ //no support[check
	 * again]CLT var seachword=sheetObj.EditText; var
	 * repo_id=sheetObj.GetCellValue(Row,"t2_repo_pln_id"); var
	 * pln_yrwk=sheetObj.GetCellValue(Row,"t2_pln_yrwk"); var
	 * vsl_lane_cd=sheetObj.GetCellValue(Row,"t2_vsl_lane_cd"); var
	 * colname="t2_vvd"; var f_cmd=SEARCHLIST08; //conversion of function[check
	 * again]CLT sheetObj.DoRowSearch(
	 * ROW,row=Row&searchword=vsl_lane_cd&repo_id=repo_id&pln_yrwk=pln_yrwk&colname=colname&f_cmd=f_cmd ); }
	 */
}
function t2sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
	if (sheetObj.ColSaveName(NewCol).substring(0, 6) == "t2_vol") {
		oldValue = sheetObj.GetCellValue(NewRow, NewCol);
		// alert("oldValue : " +oldValue);
	}
}

// SHEET2 ONCLICK EVENT
function t2sheet1_OnClick(sheetObj, Row, Col, Val) {
	// if(sheetObj.ColSaveName(Col).substring(0,6) == "t2_vol") {
	// }

	// var colName=sheetObj.ColSaveName(Col);
	// if(colName == "t2_vvd" && sheetObj.GetRowStatus(Row)=="I") {
	// sheetObj.SelectCell(Row, 't2_vvd');
	// }

	if (sheetObj.GetRowStatus(Row) == "I"
			&& sheetObj.ColSaveName(Col) == "t2_check") {
		sheetObj.SetCellValue(Row, "t2_cntrno", "");// CNTR initializing
		for ( var i = 0; i < consTpszArr.length; i++) {
			oldValue = sheetObj.GetCellValue(Row, "t2_vol" + consTpszArr[i]); // old
																				// value
																				// setting
			sheetObj.SetCellValue(Row, "t2_vol" + consTpszArr[i], "0");// '0'
		}
	}

	/*if (sheetObj.GetCellValue(Row, "t2_div") == "Plan"
		&& sheetObj.ColSaveName(Col) == "t2_check"
		&& sheetObj.GetCellValue(Row, "t2_pln_yrwk").length == 6) {
	
		var prvPlnSeq = "";
		prvPlnSeq = sheetObj.GetCellValue(Row, "t2_pln_seq");
		var prvPlnWeek = "";
		prvPlnWeek = sheetObj.GetCellValue(Row, "t2_pln_yrwk");
		var PlanChild = false;
		for ( var i = 2; i < sheetObj.RowCount(); i++) {
			if (Row != i) {
				if (prvPlnSeq == sheetObj.GetCellValue(i, "t2_pln_seq")
						&& prvPlnWeek == sheetObj
								.GetCellValue(i, "t2_pln_yrwk")) {
					PlanChild = true;
					break;
				}
			}
		}
		
		if (PlanChild == false) {
			if (sheetObj.GetCellValue(Row, "t2_check") == 1) {
				sheetObj.SetCellEditable(Row, "t2_check", 1);
				sheetObj.SetCellValue(Row, "t2_check", 0);
			} else {
				sheetObj.SetCellEditable(Row, "t2_check", 1);
				sheetObj.SetCellValue(Row, "t2_check", 1);
			}
		}
	}*/

	// CNTR NO POPUP이동
	if (sheetObj.ColSaveName(Col) == "t2_cntrimage") { // cntr input image cell
		var name = sheetObj.GetCellValue(Row, Col);
		// hidden value setting
		if (sheetObj.GetCellValue(Row, "t2_sortnum") == "2"
				&& sheetObj.GetCellValue(Row, "t2_num") == "1") {
			var view = false;
			if (sheetObj.GetCellValue(Row, "t2_so_iss_flg") != "1"
					&& sheetObj.GetCellValue(Row, "t2_repo_mty_bkg_flg") != "1") { // so
																					// send
																					// &&
																					// bkg
																					// cntr
																					// optional
				view = false;
			} else { // so send || bkg (cntr retrieve)
				view = true;
			}
			if (!userAreaCheck(sheetObj, "CNTR", "from", "2", Row)) {
				view = true;
			}
			document.form.cntrno.value = sheetObj
					.GetCellValue(Row, "t2_cntrno");
			var sRow = sheetObj.FindStatusRow("I|U");
			var arRow = sRow.split(";");
			var cntr_all = "";
			if (sRow != "" && sRow != null) {
				// for(var i=0; i<arRow.length-1; i++) {
				for ( var i = 0; i < arRow.length; i++) {
					if (sheetObj.GetCellValue(arRow[i], "t2_cntrno") != ""
							&& arRow[i] != Row
							&& sheetObj.GetCellValue(Row, "t2_pln_yrwk") == sheetObj
									.GetCellValue(arRow[i], "t2_pln_yrwk")
							&& sheetObj.GetCellValue(Row, "t2_trsp_mod_cd") == sheetObj
									.GetCellValue(arRow[i], "t2_trsp_mod_cd")
							&& sheetObj.GetCellValue(Row, "t2_to_ecc") == sheetObj
									.GetCellValue(arRow[i], "t2_to_ecc")
							&& sheetObj.GetCellValue(Row, "t2_fm_ecc") == sheetObj
									.GetCellValue(arRow[i], "t2_fm_ecc")) {
						cntr_all = cntr_all
								+ sheetObj.GetCellValue(arRow[i], "t2_cntrno")
								+ ",";
					}
				}
			}
			document.form.cntrno_all.value = cntr_all;
			oldValue = 0; // oldvalue initializing
			var url = "EES_EQR_0094.do" + "?f_cmd=-1" // DEFAULT
					+ "&repoplan_id="
					+ sheetObj.GetCellValue(Row, "t2_repo_pln_id") + "&ref_id="
					+ sheetObj.GetCellValue(Row, "t2_ref_id") + "&bkgno="
					+ sheetObj.GetCellValue(Row, "t2_bkg_no") + "&pln_seq="
					+ sheetObj.GetCellValue(Row, "t2_pln_seq")
					+ "&targetSheet=2" + "&targetRow=" + Row + "&view=" + view
					+ "&fm_ecc=" + sheetObj.GetCellValue(Row, "t2_fm_ecc")
					+ "&to_ecc=" + sheetObj.GetCellValue(Row, "t2_to_ecc")
					+ "&pln_yrwk=" + sheetObj.GetCellValue(Row, "t2_pln_yrwk")
					+ "&trsp_mode="
					+ sheetObj.GetCellValue(Row, "t2_trsp_mod_cd");
			// var styleInfo="dialogLeft:0px; dialogTop:0px; dialogWidth:800px;
			// dialogHeight:570px;scroll:no; status:no";
			// var modal = ComOpenWindow(url, self, styleInfo , true);
			ComOpenWindowCenter(url, "EES_EQR_0094", 800, 570, true);
		}
	}
	
	if (sheetObj.GetCellValue(Row, 't2_trsp_mod_cd') == 'W') {
		if (sheetObj.ColSaveName(Col) == "t2_fm_yd_cd") {
			var CellPro = sheetObj.GetCellProperty(Row, "t2_fm_yd_cd", "Type");
			if (sheetObj.GetCellValue(Row,"t2_so_iss_flg") == "" && sheetObj.GetCellValue(Row,"t2_repo_mty_bkg_flg") == "" && sheetObj.GetCellValue(Row,"t2_div") != "Plan" && CellPro == "Text") {
				var f_cmd = SEARCH19;
				var vsl = sheetObj.GetCellValue(Row, "t2_vvd");
				var from_ecc = sheetObj.GetCellValue(Row,"t2_fm_ecc");
				var t2fromcd = sheetObj.GetCellValue(Row,"t2_fm_yd_cd");
				sheetObj.InitCellProperty(Row, "t2_fm_yd_cd", {
					Type : "Combo"
				});
				
				sheetObj.DoRowSearch2("EES_LOCYARDINITIAL_COMMON.do",
						"row=" + Row + "&colname=t2_fm_yd_cd&vsl="
								+ vsl + "&ecc="+ from_ecc 
								+ "&item=W&f_cmd=" + f_cmd);
				
				sheetObj.SetCellValue(Row, "t2_fm_yd_cd", t2fromcd);
				//sheetObj.SetCellValue(Row, "t2_fm_yd_cd", "", 0);
				sheetObj.SetRowStatus(Row,"R");
			}
		}
		
		if (sheetObj.ColSaveName(Col) == "t2_to_yd_cd") {
			var CellPro = sheetObj.GetCellProperty(Row, "t2_to_yd_cd", "Type");
			
			if (sheetObj.GetCellValue(Row,"t2_so_iss_flg") == "" && sheetObj.GetCellValue(Row,"t2_repo_mty_bkg_flg") == "" && sheetObj.GetCellValue(Row,"t2_div") != "Plan" && CellPro == "Text") {
				var f_cmd = SEARCH19;
				var vsl = sheetObj.GetCellValue(Row, "t2_vvd");
				var to_ecc = sheetObj.GetCellValue(Row, "t2_to_ecc");
				var from_ecc = sheetObj.GetCellValue(Row,"t2_fm_ecc");
				var t2tocd = sheetObj.GetCellValue(Row,"t2_to_yd_cd");
				sheetObj.InitCellProperty(Row, "t2_to_yd_cd", {
					Type : "Combo"
				});
				sheetObj.DoRowSearch2("EES_LOCYARDINITIAL_COMMON.do", 
						"row=" + Row + "&colname=t2_to_yd_cd&vsl="
								+ vsl + "&ecc=" + to_ecc +"&from_ecc=" +  from_ecc
								+ "&item=W&f_cmd=" + f_cmd);
				

				sheetObj.SetCellValue(Row, "t2_to_yd_cd", t2tocd);
				sheetObj.SetRowStatus(Row,"R");
			}
		}
		
	}else{
		if (sheetObj.ColSaveName(Col) == "t2_fm_yd_cd" && sheetObj.GetCellEditable(Row, "t2_fm_yd_cd") == 1) {
			var CellPro = sheetObj.GetCellProperty(Row, "t2_fm_yd_cd", "Type");
			if (sheetObj.GetCellValue(Row,"t2_so_iss_flg") == "" && sheetObj.GetCellValue(Row,"t2_repo_mty_bkg_flg") == "" && sheetObj.GetCellValue(Row,"t2_div") != "Plan" && CellPro == "Text") {
				var f_cmd = SEARCH15;
				var from_ecc = sheetObj.GetCellValue(Row,"t2_fm_ecc");
				var t2fromcd = sheetObj.GetCellValue(Row,"t2_fm_yd_cd");
				sheetObj.InitCellProperty(Row, "t2_fm_yd_cd", {
					Type : "Combo"
				});
				
				sheetObj.DoRowSearch2("EES_LOCYARD_COMMON.do",
						"row=" + Row + "&searchword=" + from_ecc
								+ "&colname=t2_fm_yd_cd&f_cmd="
								+ f_cmd);
				
				sheetObj.SetCellValue(Row, "t2_fm_yd_cd", t2fromcd);
				sheetObj.SetRowStatus(Row,"R");
			}
		}
		
		if (sheetObj.ColSaveName(Col) == "t2_to_yd_cd" && sheetObj.GetCellEditable(Row, "t2_to_yd_cd") == 1) {
			var CellPro = sheetObj.GetCellProperty(Row, "t2_to_yd_cd", "Type");
			if (sheetObj.GetCellValue(Row,"t2_so_iss_flg") == "" && sheetObj.GetCellValue(Row,"t2_repo_mty_bkg_flg") == "" && sheetObj.GetCellValue(Row,"t2_div") != "Plan" && CellPro == "Text") {
				var f_cmd = SEARCH15;
				var to_ecc = sheetObj.GetCellValue(Row,"t2_to_ecc");
				var t2tocd = sheetObj.GetCellValue(Row,"t2_to_yd_cd");
				sheetObj.InitCellProperty(Row, "t2_to_yd_cd", {
					Type : "Combo"
				});
				sheetObj.DoRowSearch2("EES_LOCYARD_COMMON.do",
						"row=" + Row + "&searchword=" + to_ecc
								+ "&colname=t2_to_yd_cd&f_cmd="
								+ f_cmd);
				

				sheetObj.SetCellValue(Row, "t2_to_yd_cd", t2tocd);
				sheetObj.SetRowStatus(Row,"R");
			}
		}
	}
}

function t3sheet1_OnDblClick(sheetObj, Row, Col) {
	var colName = sheetObj.ColSaveName(Col);
	var idx = sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
	if ((colName == "t3_fm_yd_cd" || colName == "t3_to_yd_cd")
			&& sheetObj.GetCellEditable(Row, colName) && idx != -1) {
		sheetObj.GetCellValue = "";
	}
}

function t3sheet1_OnChange(sheetObj, Row, Col, Val) {
	var colName = sheetObj.ColSaveName(Col);
	// ----------------- LOCretreive LOC
	// --------------------------------------------------
	if (sheetObj.ColSaveName(Col) == "t3_fm_yd_cd"
			|| sheetObj.ColSaveName(Col) == "t3_to_yd_cd") {
		if (sheetObj.GetCellValue(Row, "t3_sortnum") == "1") { // PLAN LINE
			var colname = sheetObj.ColSaveName(Col);
			var seachword = sheetObj.GetCellValue(Row, colname);

			if (seachword != "") {
				var f_cmd = SEARCHLIST03;
				// sheetObj.DoRowSearch(
				// ROW,Row=Row&searchword=seachword&Col1=t3_eccresult&f_cmd=f_cmd
				// );
				sheetObj.DoRowSearch2("EES_EQR_0020GS3.do", "Row=" + Row
						+ "&searchword=" + seachword
						+ "&Col1=t3_eccresult&f_cmd=" + f_cmd);
				if (sheetObj.GetCellText(Row, "t3_eccresult") == "") {
					// 2014.10.14 Park Young Jin
					ComShowCodeMessage("EQR70012", seachword);
					sheetObj.SetCellValue(Row, "t3_fm_yd_cd", "", 0);
					sheetObj.SetCellValue(Row, "t3_to_yd_cd", "", 0);
				} else {
					sheetObj.SetCellValue(Row, "t3_fm_yd_cd", seachword, 0);
					sheetObj.SetCellValue(Row, "t3_to_yd_cd", seachword, 0);
				}
			}
		} else if (sheetObj.GetCellValue(Row, "t3_sortnum") == "2") { // EXECUTION
																		// LINE
			// --- FM YARD, TO YARD retreive
			// ---------------------------------------------
			var searchword = sheetObj.GetCellValue(Row, colName);
			var idx = sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
			if (idx == -1) {
				if (searchword != "") {
					// searchword.length >= 5 && searchword.substr(0,5)==ecc,
					// YARD retreive
					var basic_ecc = "";
					if (sheetObj.GetCellValue(Row, "t3_onf_hir_div_cd") == "F")
						basic_ecc = sheetObj.GetCellValue(Row, "t3_fm_ecc"); // OFF
																				// HIRE
					else
						basic_ecc = sheetObj.GetCellValue(Row, "t3_to_ecc"); // ON
																				// HIRE
					if (searchword.length == 7) { // FULL YARD CODE
						if (sheetObj.GetCellValue(Row, "t3_onf_hir_div_cd") == "F") { // OFF
																						// HIRE
							if (colName == "t3_fm_yd_cd") {
								var f_cmd = SEARCH02; // MDM_YARD
								// sheetObj.InitCellProperty(Row, colName,{
								// Type:"Text"} );
								sheetObj.SetCellValue(Row, colName, "", 0);
								// var
								// str=sheetObj.GetSearchData("EES_LOCYARDEXIST_COMMON.do"
								// ,"row="+Row+"&locyard="+searchword+"&ecc="+basic_ecc+"&colname="+colName+"&f_cmd="+f_cmd);
								// sheetObj.LoadSearchData(str,{Sync:1} );
								sheetObj.DoRowSearch2(
										"EES_LOCYARDEXIST_COMMON.do", "row="
												+ Row + "&locyard="
												+ searchword + "&ecc="
												+ basic_ecc + "&colname="
												+ colName + "&f_cmd=" + f_cmd);
							} else {
								var f_cmd = SEARCH03; // LSE_CO_YD_CD
								// sheetObj.InitCellProperty(Row, colName,{
								// Type:"Text"} );
								sheetObj.SetCellValue(Row, colName, "", 0);
								// var
								// str=sheetObj.GetSearchData("EES_LOCYARDEXISTCOMPANY_COMMON.do"
								// ,"row="+Row+"&locyard="+searchword+"&ecc="+basic_ecc+"&colname="+colName+"&f_cmd="+f_cmd);
								// sheetObj.LoadSearchData(str,{Sync:1} );
								sheetObj.DoRowSearch2(
										"EES_LOCYARDEXISTCOMPANY_COMMON.do",
										"row=" + Row + "&locyard=" + searchword
												+ "&ecc=" + basic_ecc
												+ "&colname=" + colName
												+ "&f_cmd=" + f_cmd);

								var fmlocdt = sheetObj.GetCellValue(Row,
										"t3_fm_loc_dt");
								var fryard = sheetObj.GetCellValue(Row,
										"t3_fm_yd_cd");
								var toyard = sheetObj.GetCellValue(Row,
										"t3_to_yd_cd");
								var item = "T"; // on off hire는 trsp mode를 T로
												// 생각함.(important)
								if (fryard.length == 7 && toyard.length == 7
										&& fmlocdt.length == 8) {
									// sheetObj.SetCellValue(Row,
									// "t3_to_loc_dt","",0);// eta initializing
									var toEtaDate = sheetObj.GetCellValue(Row,
											"t3_to_loc_dt");
									var f_cmd = SEARCHLIST18;
									// sheetObj.DoRowSearch(
									// ROW,row=Row&searchword=fmlocdt&fryard=fryard&toyard=toyard&item=item&colname=t3_to_loc_dt&f_cmd=f_cmd
									// );
									sheetObj
											.DoRowSearch2(
													"EES_SEARCH_ETA.do",
													"row="
															+ Row
															+ "&searchword="
															+ fmlocdt
															+ "&fryard="
															+ fryard
															+ "&toyard="
															+ toyard
															+ "&item="
															+ item
															+ "&colname=t3_to_loc_dt&f_cmd="
															+ f_cmd);

									if (sheetObj.GetCellValue(Row,
											"t3_to_loc_dt") == "") {
										sheetObj.SetCellValue(Row,
												"t3_to_loc_dt", toEtaDate);// eta
																			// initializing
									}
								}
							}
						} else { // ON HIRE
							if (colName == "t3_fm_yd_cd") {
								var f_cmd = SEARCH03; // LSE_CO_YD_CD
								// sheetObj.InitCellProperty(Row, colName,{
								// Type:"Text"} );
								sheetObj.SetCellValue(Row, colName, "", 0);
								// var
								// str=sheetObj.GetSearchData("EES_LOCYARDEXISTCOMPANY_COMMON.do"
								// ,"row="+Row+"&locyard="+searchword+"&ecc="+basic_ecc+"&colname="+colName+"&f_cmd="+f_cmd);
								// sheetObj.LoadSearchData(str,{Sync:1} );
								sheetObj.DoRowSearch2(
										"EES_LOCYARDEXISTCOMPANY_COMMON.do",
										"row=" + Row + "&locyard=" + searchword
												+ "&ecc=" + basic_ecc
												+ "&colname=" + colName
												+ "&f_cmd=" + f_cmd);
								var fmlocdt = sheetObj.GetCellValue(Row,
										"t3_fm_loc_dt");
								var fryard = sheetObj.GetCellValue(Row,
										"t3_fm_yd_cd");
								var toyard = sheetObj.GetCellValue(Row,
										"t3_to_yd_cd");
								var item = "T";
								if (fryard.length == 7 && toyard.length == 7
										&& fmlocdt.length == 8) {

									// sheetObj.SetCellValue(Row,
									// "t3_to_loc_dt","",0);// eta initializing
									var toEtaDate = sheetObj.GetCellValue(Row,
											"t3_to_loc_dt");

									var f_cmd = SEARCHLIST18;
									// sheetObj.DoRowSearch(
									// ROW,row=Row&searchword=fmlocdt&fryard=fryard&toyard=toyard&item=item&colname=t3_to_loc_dt&f_cmd=f_cmd
									// );
									sheetObj
											.DoRowSearch2(
													"EES_SEARCH_ETA.do",
													"row="
															+ Row
															+ "&searchword="
															+ fmlocdt
															+ "&fryard="
															+ fryard
															+ "&toyard="
															+ toyard
															+ "&item="
															+ item
															+ "&colname=t3_to_loc_dt&f_cmd="
															+ f_cmd);
									if (sheetObj.GetCellValue(Row,
											"t3_to_loc_dt") == "") {
										sheetObj.SetCellValue(Row,
												"t3_to_loc_dt", toEtaDate);// eta
																			// initializing
									}
								}
							} else {
								var f_cmd = SEARCH02; // MDM_YARD
								// sheetObj.InitCellProperty(Row, colName,{
								// Type:"Text"} );
								// sheetObj.SetCellValue(Row, colName,"",0);
								// var
								// str=sheetObj.GetSearchData("EES_LOCYARDEXIST_COMMON.do"
								// ,"row="+Row+"&locyard="+searchword+"&ecc="+basic_ecc+"&colname="+colName+"&f_cmd="+f_cmd);
								// sheetObj.LoadSearchData(str,{Sync:1} );
								// sheetObj.DoRowSearch2("EES_LOCYARDEXIST_COMMON.do"
								// ,"row="+Row+"&locyard="+searchword+"&ecc="+basic_ecc+"&colname="+colName+"&f_cmd="+f_cmd);
							}
						}
					} else if (searchword.length >= 5
							&& searchword.substr(0, 5) == basic_ecc) {
						if (sheetObj.GetCellValue(Row, "t3_onf_hir_div_cd") == "F") { // OFF
																						// HIRE
							if (colName == "t3_fm_yd_cd") {
								// var f_cmd=SEARCHLIST05; // MDM_YARD
								var f_cmd = SEARCHLIST20; // MDM_YARD
								// sheetObj.DoRowSearch(
								// ROW,row=Row&searchword=searchword&colname=colName&f_cmd=f_cmd
								// );
								// sheetObj.DoRowSearch2("EES_LOCYARD_COMMON.do"
								// ,"row="+Row+"&searchword="+searchword+"&colname="+colName+"&f_cmd="+f_cmd);

								sheetObj.DoRowSearch2("EES_LOCYARD_COMMON.do",
										"row=" + Row + "&searchword="
												+ searchword + "&colname="
												+ colName + "&f_cmd=" + f_cmd);
								// var sXml =
								// sheetObj.GetSearchData("EES_LOCYARD_COMMON.do",
								// "row="+Row+"&searchword="+searchword+"&colname="+colName+"&f_cmd="+f_cmd);
								// changeViewCombo(sheetObj, sXml);
								// sheetObj.SetCellValue(Row, colName,"",0);

							}
						} else { // ON HIRE
							if (colName == "t3_to_yd_cd") {
								// var f_cmd=SEARCHLIST05; // MDM_YARD
								var f_cmd = SEARCHLIST20; // MDM_YARD
								// sheetObj.DoRowSearch(
								// ROW,row=Row&searchword=searchword&colname=colName&f_cmd=f_cmd
								// );
								// sheetObj.DoRowSearch2("EES_LOCYARD_COMMON.do"
								// ,"row="+Row+"&searchword="+searchword+"&colname="+colName+"&f_cmd="+f_cmd);

								sheetObj.DoRowSearch2("EES_LOCYARD_COMMON.do",
										"row=" + Row + "&searchword="
												+ searchword + "&colname="
												+ colName + "&f_cmd=" + f_cmd);
								// var sXml =
								// sheetObj.GetSearchData("EES_LOCYARD_COMMON.do",
								// "row="+Row+"&searchword="+searchword+"&colname="+colName+"&f_cmd="+f_cmd);
								// changeViewCombo(sheetObj, sXml);
								// sheetObj.SetCellValue(Row, colName,"",0);
							}
						}
					} else {
						ComShowCodeMessage("EQR90171", basic_ecc);
						sheetObj.SetCellValue(Row, colName, "", 0);
					}
				}
			} else {
				var fmlocdt = sheetObj.GetCellValue(Row, "t3_fm_loc_dt");
				var fryard = sheetObj.GetCellValue(Row, "t3_fm_yd_cd");
				var toyard = sheetObj.GetCellValue(Row, "t3_to_yd_cd");
				var item = "T";
				if (fryard.length == 7 && toyard.length == 7
						&& fmlocdt.length == 8) {
					// sheetObj.SetCellValue(Row, "t3_to_loc_dt","",0);// eta
					// initializing
					var toEtaDate = sheetObj.GetCellValue(Row, "t3_to_loc_dt");
					var f_cmd = SEARCHLIST18;
					// sheetObj.DoRowSearch(
					// ROW,row=Row&searchword=fmlocdt&fryard=fryard&toyard=toyard&item=item&colname=t3_to_loc_dt&f_cmd=f_cmd
					// );
					sheetObj.DoRowSearch2("EES_SEARCH_ETA.do", "row=" + Row
							+ "&searchword=" + fmlocdt + "&fryard=" + fryard
							+ "&toyard=" + toyard + "&item=" + item
							+ "&colname=t3_to_loc_dt&f_cmd=" + f_cmd);

					if (sheetObj.GetCellValue(Row, "t3_to_loc_dt") == "") {
						sheetObj.SetCellValue(Row, "t3_to_loc_dt", toEtaDate);// eta
																				// initializing
					}
				}
			}
		}
	}
	// VENDOR retreive
	if (colName == "t3_vndr") { // VENDOR COMBO BOX
		var searchword = sheetObj.GetCellValue(Row, colName);
		var idx = sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
		var CellPro = sheetObj.GetCellProperty(Row, colName, "Type");
		if (CellPro == "Text") {
			if (searchword != "") {
				var f_cmd = SEARCHLIST06;
				// sheetObj.DoRowSearch(
				// ROW,row=Row&searchword=searchword&colname=colName&f_cmd=f_cmd
				// );
				// sheetObj.DoRowSearch2("EES_VENDOR_COMMON.do"
				// ,"row="+Row+"&searchword="+searchword+"&colname="+colName+"&f_cmd="+f_cmd);
				// var sXml = sheetObj.GetSearchData("EES_VENDOR_COMMON.do",
				// "row="+Row+"&searchword="+searchword+"&colname="+colName+"&f_cmd="+f_cmd);
				// changeViewCombo(sheetObj, sXml);
				sheetObj.InitCellProperty(Row, colName, {
					Type : "Combo"
				});
				sheetObj.DoRowSearch2("EES_VENDOR_COMMON.do", "row=" + Row
						+ "&searchword=" + searchword + "&colname=" + colName
						+ "&f_cmd=" + f_cmd);

				if (sheetObj.GetCellValue(Row, "t3_vndr") == "") {
					// sheetObj.InitCellProperty(Row,colName,{ Type:"Text"});
				} else {
					// sheetObj.SetCellValue(Row,"t3_vndr","");
					sheetObj.SetCellValue(Row, "t3_vndr_seq", "");
					sheetObj.SetCellValue(Row, "t3_vndr_abbr_nm", "");
				}
			}
		} else {
			var name = sheetObj.GetCellValue(Row, Col);
			// hidden value setting
			if (name.length >= 8) {
				sheetObj.SetCellValue(Row, "t3_vndr_abbr_nm", sheetObj
						.GetCellText(Row, "t3_vndr").substr(0, 20), 0);
				sheetObj.SetCellValue(Row, "t3_vndr_seq", name.substr(2,
						name.length), 0);
				sheetObj.SetCellValue(Row, "t3_vndr_cnt_cd", name.substr(0, 2),
						0);
			} else {
				sheetObj.InitCellProperty(Row, colName, {
					Type : "Text"
				});
			}
			var searchword = ''; // ECC INFO
			var div_cd = sheetObj.GetCellValue(Row, "t3_onf_hir_div_cd");
			var vndr = sheetObj.GetCellValue(Row, "t3_vndr");
			var vndr_seq = sheetObj.GetCellValue(Row, "t3_vndr_seq");
			var colName = null;
			if (div_cd == "F") {
				colName = "t3_to_yd_cd"; // OFF-HIRE
				searchword = sheetObj.GetCellValue(Row, "t3_fm_ecc"); // OFF
																		// HIRE
			} else {
				colName = "t3_fm_yd_cd"; // ON-HIRE
				searchword = sheetObj.GetCellValue(Row, "t3_to_ecc"); // ON
																		// HIRE
			}
			if (vndr_seq != "") {
				/*  -- ECC Yard List로 변경하기 위하여 이벤트 삭제 By Mark 2015.09.01
				if (sheetObj.GetCellValue(Row, "t3_sortnum") == "2") {

					var f_cmd = SEARCHLIST19;
					sheetObj.InitCellProperty(Row, colName, {
						Type : "Combo"
					});
					sheetObj.DoRowSearch2("EES_LOCYARD_COMMON.do", "row=" + Row
							+ "&searchword=" + searchword + "&div_cd=" + div_cd
							+ "&vndr_seq=" + vndr_seq + "&colname=" + colName
							+ "&f_cmd=" + f_cmd);
				}
				*/
			}
		}
	}
	// ------------------- so send, no so send modifying시 ----------------------
	if (sheetObj.ColSaveName(Col) == "t3_so_iss_flg") {
		sheetObj.SetCellValue(Row, "t3_noso_iss_flg", "0", 0);
	} else if (sheetObj.ColSaveName(Col) == "t3_noso_iss_flg") {
		sheetObj.SetCellValue(Row, "t3_so_iss_flg", "0", 0);
	}
	// ------------------- week modifying ----------------------------
	if (sheetObj.ColSaveName(Col) == "t3_pln_yrwk"
			&& sheetObj.GetCellValue(Row, "t3_sortnum") == "1") {
		weekInput = sheetObj.GetCellValue(Row, Col); // input data week
		// 1) checking from is week
		if (weekInput.length < 6) {
			// ComShowMessage("please input week data format ! ");
			ComShowCodeMessage("EQR90056");
			sheetObj.SetCellValue(Row, Col, "", 0);
			return false;
		} else {
			if (weekInput.substring(4, 6) < 01
					|| weekInput.substring(4, 6) > 53) {
				// ComShowMessage("please input week data format ! ");
				ComShowCodeMessage("EQR90056");
				sheetObj.SetCellValue(Row, Col, "", 0);
				return false;
			} else {
				// 2) FROM WEEK <= weekInput <=TO WEEK 확인
				var fromWeek = document.form.st_year.value
						+ document.form.st_weekly.value;
				var toWeek = document.form.max_plnYr.value
						+ document.form.max_weekly.value;
				if (weekInput < fromWeek || weekInput > toWeek) {
					ComShowCodeMessage("EQR90127", fromWeek, toWeek);
					sheetObj.SetCellValue(Row, Col, "", 0);
					return false;
				}
			}
		}
	}

	if (sheetObj.ColSaveName(Col) == "t3_fm_loc_dt") {
		var etd = sheetObj.GetCellValue(Row, "t3_fm_loc_dt");
		var eta = sheetObj.GetCellValue(Row, "t3_to_loc_dt");
		if (document.form.nowDay.value > etd) {
			// row add 비활성
			//ComShowCodeMessage("EQR01144");
			//return false;
		}
	}

	if (sheetObj.ColSaveName(Col) == "t3_to_loc_dt") {
		if (document.form.nowDay.value > eta) {
			// row add 비활성
			//ComShowCodeMessage("EQR01144");
			//return false;
		}
	}

	// ------------- ETD, ETA modifying(PLAN, EXECUTE ROW )
	// ------------------------------------------------
	if (sheetObj.ColSaveName(Col) == "t3_fm_loc_dt"
			|| sheetObj.ColSaveName(Col) == "t3_to_loc_dt") {
		var etd = sheetObj.GetCellValue(Row, "t3_fm_loc_dt");
		var eta = sheetObj.GetCellValue(Row, "t3_to_loc_dt");

		// -- EXECUTE ROW (DATE modifying)
		if (sheetObj.GetCellValue(Row, "t3_sortnum") == "2") {
			if (etd.length == 8 && eta.length == 8) {
				if (etd > eta) {
					ComShowCodeMessage("EQR90077");
					sheetObj.SetCellValue(Row, Col, "", 0);
				}
			}
		}
	}

	// ----------------- Execution ETD info -------------------------------
	// Week 의 start일~end일 사이에 들어와야 한다.
	if (sheetObj.ColSaveName(Col) == "t3_fm_loc_dt"
			&& sheetObj.GetCellValue(Row, "t3_sortnum") == "2"
			&& sheetObj.GetCellValue(Row, "t3_fm_loc_dt") != "") { // ETD
																	// modifying
		var etd = sheetObj.GetCellValue(Row, "t3_fm_loc_dt");
		var frdate = sheetObj.GetCellValue(Row, "t3_week_fromdate");
		var todate = sheetObj.GetCellValue(Row, "t3_week_todate");
		// var searchword = sheetObj.EditText;
		var searchword = sheetObj.GetCellValue(Row, "t3_fm_loc_dt");
		var colname = sheetObj.ColSaveName(Col);
		var fryard = sheetObj.GetCellValue(Row, "t3_fm_yd_cd");
		var toyard = sheetObj.GetCellValue(Row, "t3_to_yd_cd");
		var item = "T";
		// ETD가 FRDATE, TODATE
		if (etd < frdate || etd > todate) {
			ComShowCodeMessage("EQR90141", "ETD", frdate, todate);
			sheetObj.SetCellValue(Row, "t3_fm_loc_dt", "", 0);
			return false;
		} else {
			if (fryard.length == 7 && toyard.length == 7) { // FROM LOC, TO LOC,
															// eta retreive
				if (searchword != "") {
					sheetObj.SetCellValue(Row, "t3_to_loc_dt", "", 0);// eta
																		// initializing
					var f_cmd = SEARCHLIST18;
					// sheetObj.DoRowSearch(
					// ROW,row=Row&searchword=searchword&fryard=fryard&toyard=toyard&item=item&colname=t3_to_loc_dt&f_cmd=f_cmd
					// );
					sheetObj.DoRowSearch2("EES_SEARCH_ETA.do", "row=" + Row
							+ "&searchword=" + searchword + "&fryard=" + fryard
							+ "&toyard=" + toyard + "&item=" + item
							+ "&colname=t3_to_loc_dt&f_cmd=" + f_cmd);
				}
			} else {
			}
		}
	}

	// ---------- ETA modifying (EXECUTE ROW)
	// ----------------------------------------------
	if (sheetObj.ColSaveName(Col) == "t3_to_loc_dt"
			&& sheetObj.GetCellValue(Row, "t3_sortnum") == "2"
			&& sheetObj.GetCellValue(Row, "t3_to_loc_dt") != "") { // ETD
																	// modifying
		var eta = sheetObj.GetCellValue(Row, "t3_to_loc_dt");
		var frdate = sheetObj.GetCellValue(Row, "t3_week_fromdate");
		var maxdate = sheetObj.GetCellValue(Row, "t3_week_maxdate"); // week
																		// fromdate
																		// + 7주
		if (eta < frdate || eta > maxdate) {
			ComShowCodeMessage("EQR90141", "ETA", frdate, maxdate);
			sheetObj.SetCellValue(Row, "t3_to_loc_dt", "");
			sheetObj.SetCellEditable(Row, "t3_to_loc_dt", 1);
			return false;
		}
	}
	// ------------- Reason
	// modifying------------------------------------------------------------------
	if (sheetObj.ColSaveName(Col) == "t3_repo_pln_fb_rsn_cd") {
		if ((sheetObj.GetRowStatus(Row) == "I" || sheetObj.GetRowStatus(Row) == "U")
				&& sheetObj.GetCellValue(Row, "t3_pass_final") == "F") {
			var week = sheetObj.GetCellValue(Row, "t3_pln_yrwk");
			var item = sheetObj.GetCellValue(Row, "t3_onf_hir_div_cd");
			var fm_ecc = sheetObj.GetCellValue(Row, "t3_fm_ecc");
			var to_ecc = sheetObj.GetCellValue(Row, "t3_to_ecc");
			if (item == "O")
				fm_ecc = "";
			else
				to_ecc = "";
			var sRow = sheetObj.FindStatusRow("I|U");
			var arRow = sRow.split(";");
			if (sRow != "" && sRow != null) {
				// for(var i=0; i<arRow.length-1; i++) {
				for ( var i = 0; i < arRow.length; i++) {
					if (sheetObj.GetCellValue(arRow[i], "t3_sortnum") == 2
							&& sheetObj.GetCellValue(arRow[i], "t3_num") == 1
							&& sheetObj.GetCellValue(arRow[i], "t3_pln_yrwk") == week
							&& sheetObj.GetCellValue(arRow[i],
									"t3_onf_hir_div_cd") == item
							&& sheetObj.GetCellValue(arRow[i], "t3_pass_final") == "F") {
						if (item == "O") {
							if (sheetObj.GetCellValue(arRow[i], "t3_to_ecc") == to_ecc)
								sheetObj.SetCellValue(arRow[i],
										"t3_repo_pln_fb_rsn_cd",
										sheetObj.GetCellValue(Row,
												"t3_repo_pln_fb_rsn_cd"));
							otherCombo(sheetObj, Row, Col);
						} else {
							if (sheetObj.GetCellValue(arRow[i], "t3_fm_ecc") == fm_ecc)
								sheetObj.SetCellValue(arRow[i],
										"t3_repo_pln_fb_rsn_cd",
										sheetObj.GetCellValue(Row,
												"t3_repo_pln_fb_rsn_cd"));
							otherCombo(sheetObj, Row, Col);
						}
					}
				}
			}
		} else {
			otherCombo(sheetObj, Row, Col);
		}
	}
	// ---------------------- CNTR NO optional
	// ----------------------------------------------------------------
	if (sheetObj.ColSaveName(Col) == "t3_tpszno") {
		var tpszConArr = Val.split(",");
		var vol = 0;
		for ( var i = 0; i < consTpszArr.length; i++) {
			for ( var j = 0; j < tpszConArr.length; j++) {
				if (consTpszArr[i] == tpszConArr[j])
					vol++;
			}
			// if(eval(vol) > eval(sheetObj.GetCellValue(Row,
			// "t3_vol"+consTpszArr[i]))) {
			oldValue = sheetObj.GetCellValue(Row, "t3_vol" + consTpszArr[i]);
			sheetObj.SetCellValue(Row, "t3_vol" + consTpszArr[i], vol);
			// }
			vol = 0;
		}
	}

	// ------- in case of vol modified
	// ----------------------------------------------------------
	if (sheetObj.ColSaveName(Col).substring(0, 6) == "t3_vol") {
		// var diffVol = eval(Val - sheetObj.CellSearchValue(Row,Col));
		var diffVol = eval(Val - oldValue);
		var tpszName = sheetObj.ColSaveName(Col).substring(6, 8);
		// ----- checking pass feedback for each tpsz vol (START) ----
		var week = sheetObj.GetCellValue(Row, "t3_pln_yrwk");
		var item = sheetObj.GetCellValue(Row, "t3_onf_hir_div_cd");
		var fm_ecc = sheetObj.GetCellValue(Row, "t3_fm_ecc");
		var to_ecc = sheetObj.GetCellValue(Row, "t3_to_ecc");
		var tpsz = sheetObj.ColSaveName(Col).substring(6, 8);
		if (item == "O")
			fm_ecc = "";
		else
			to_ecc = "";
		var planVol = 0;
		var exeMaxVol = 0;
		var exeFinalVol = 0;
		var basicRatio = 0;
		var basicVol = 0;
		var targetVol = 0;
		var targetRatio = 0;
		var planRow = 0;
		for ( var i = 0; i < sheetObj.RowCount(); i++) {
			if (sheetObj.GetCellValue(i, "t3_sortnum") == 1
					&& sheetObj.GetCellValue(i, "t3_num") == 1
					&& sheetObj.GetCellValue(i, "t3_pln_yrwk") == week
					&& sheetObj.GetCellValue(i, "t3_onf_hir_div_cd") == item
					&& sheetObj.GetCellValue(i, "t3_fm_ecc") == fm_ecc
					&& sheetObj.GetCellValue(i, "t3_to_ecc") == to_ecc) {
				planRow = i;
				break;
			}
		}
		if (planRow == 0) {
			// ComShowCodeMessage("EQR90067");
		} else {
			planVol = Number(sheetObj.GetCellValue(planRow, "t3_vol" + tpsz));
			exeMaxVol = Number(sheetObj.GetCellValue(planRow, "t3_maxvol"
					+ tpsz));
			basicRatio = Number(sheetObj.GetCellValue(planRow, "t3_basicratio"
					+ tpsz));
			basicVol = Number(sheetObj.GetCellValue(planRow, "t3_basicvol"
					+ tpsz));
			// ComShowMessage("planRow : "+ planRow+ ", planVol : "+planVol+",
			// exeMaxVol : "+exeMaxVol+", basicRatio : "+basicRatio+", basicVol
			// : "+basicVol);
			// vol calculation

			exeFinalVol = eval(exeMaxVol) + eval(diffVol);
			// ComShowMessage(" 1 targetVol : "+targetVol);
			if (exeFinalVol < 0)
				exeFinalVol = 0;

			targetVol = Math.abs(eval(planVol) - eval(exeFinalVol));
			// if(targetVol < 0) targetVol = 0;
			// ratio calculation
			if (exeFinalVol == 0 || planVol == 0) {
				targetRatio = 0;
			} else {
				targetRatio = Math
						.round((eval(exeFinalVol) / eval(planVol)) * 100);
			}
			sheetObj.SetCellValue(planRow, "t3_maxvol" + tpsz, exeFinalVol, 0);

			if (sheetObj.GetCellValue(Row, "t3_div") != "Plan") {
				sheetObj.SetRowStatus(planRow, "R");
			}

			sheetObj.SetRowBackColor(planRow, "#CBEFEA");
			var formula_result = "";
			if (basicVol > targetVol && basicRatio < targetRatio) {
				formula_result = "SUCCESS";
				sheetObj.SetCellValue(Row, "t3_pass" + tpsz, '', 0);
				sheetObj.SetCellFontColor(Row, "t3_vol" + tpsz, sheetObj
						.GetDataFontColor());
			} else {
				formula_result = "FAILURE";
				sheetObj.SetCellValue(Row, "t3_pass" + tpsz, 'F', 0);
				// sheetObj.SetCellFontColor(Row,"t3_vol"+tpsz,"#F1541F");
			}
		}

		// ---- checking pass feedback for each tpsz vol (END) ----
		// --- vol amt calculation (fomula : amt = vol * unit cost)
		
		// --- type size total vol, amt calculation
		// --- sub total vol, amt calculation
		// --- grand total vol, amt calculation
		var grandTotalRow = 0;
		var subTotalRow = 0;
		// Grand Total 합산
		while (true) {
			grandTotalRow = sheetObj.FindText("t3_num", 3, grandTotalRow + 1); // TOTAL
																				// ROW
																				// retreive
			if (grandTotalRow == -1) {
				break;
			} else {
				if (sheetObj.GetCellValue(grandTotalRow, "t3_sortnum") == 2) { // Execution
																				// Row
																				// retreive
					sheetObj.SetCellValue(grandTotalRow, Col, eval(sheetObj
							.GetCellValue(grandTotalRow, Col))
							+ eval(diffVol), 0);
					
					sheetObj.SetCellValue(grandTotalRow, "t3_totalvol",
							eval(sheetObj.GetCellValue(grandTotalRow,
									"t3_totalvol"))
									+ eval(diffVol), 0);
					
					// sheetObj.SetRowStatus(grandTotalRow,"R");
					sheetObj.SetRowBackColor(grandTotalRow, "#FEBDB6");
				}
			}
		}
		while (true) {
			subTotalRow = sheetObj.FindText("t3_num", 2, subTotalRow + 1); // SUB
																			// ROW
																			// retreive
			if (subTotalRow == -1) {
				break;
			} else {
				if (sheetObj.GetCellValue(subTotalRow, "t3_sortnum") == 2) { // Execution
																				// Row
																				// retreive
					if (sheetObj.GetCellValue(subTotalRow, "t3_pln_yrwk")
							.substr(0, 6) == sheetObj.GetCellValue(Row,
							"t3_pln_yrwk")) {
						sheetObj.SetCellValue(subTotalRow, Col, eval(sheetObj
								.GetCellValue(subTotalRow, Col))
								+ eval(diffVol), 0);
						
						sheetObj.SetCellValue(subTotalRow, "t3_totalvol",
								eval(sheetObj.GetCellValue(subTotalRow,
										"t3_totalvol"))
										+ eval(diffVol), 0);
						
						// sheetObj.SetRowStatus(subTotalRow,"R");
						sheetObj.SetRowBackColor(subTotalRow, "#F9DF9B");
					}
				}
			}
		}
		sheetObj.SetCellValue(Row, "t3_totalvol", eval(sheetObj.GetCellValue(
				Row, "t3_totalvol"))
				+ eval(diffVol));
		
		sheetObj.SetCellValue(Row, "t3_flag"
				+ sheetObj.ColSaveName(Col).substring(6, 8), "T");
		oldValue = Val;
	}
}

function t3sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
	if (sheetObj.ColSaveName(NewCol).substring(0, 6) == "t3_vol") {
		oldValue = sheetObj.GetCellValue(NewRow, NewCol);
		// alert("oldValue : " +oldValue);
	}
}

//
function t3sheet1_OnClick(sheetObj, Row, Col, Val) {
	// if(sheetObj.ColSaveName(Col).substring(0,6) == "t3_vol") {
	// oldValue = Val;
	// }
	if (sheetObj.GetRowStatus(Row) == "I"
			&& sheetObj.ColSaveName(Col) == "t3_check") {
		sheetObj.SetCellValue(Row, "t3_cntrno", "");// CNTR initializing
		for ( var i = 0; i < consTpszArr.length; i++) {
			oldValue = sheetObj.GetCellValue(Row, "t3_vol" + consTpszArr[i]); // old
																				// value
																				// setting
			sheetObj.SetCellValue(Row, "t3_vol" + consTpszArr[i], "0");// '0'
																		// 으로
																		// modifying
		}
	}

	/*if (sheetObj.GetCellValue(Row, "t3_div") == "Plan"
			&& sheetObj.ColSaveName(Col) == "t3_check"
			&& sheetObj.GetCellValue(Row, "t3_pln_yrwk").length == 6) {
		var prvPlnSeq = "";
		prvPlnSeq = sheetObj.GetCellValue(Row, "t3_pln_seq");
		var prvPlnWeek = "";
		prvPlnWeek = sheetObj.GetCellValue(Row, "t3_pln_yrwk");
		var PlanChild = false;
		for ( var i = 2; i < sheetObj.RowCount(); i++) {
			if (Row != i) {
				if (prvPlnSeq == sheetObj.GetCellValue(i, "t3_pln_seq")
						&& prvPlnWeek == sheetObj
								.GetCellValue(i, "t3_pln_yrwk")) {
					PlanChild = true;
					break;
				}
			}
		}
		if (PlanChild == false) {
			if (sheetObj.GetCellValue(Row, "t3_check") == 1) {
				sheetObj.SetCellEditable(Row, "t3_check", 1);
				sheetObj.SetCellValue(Row, "t3_check", 0);
			} else {
				sheetObj.SetCellEditable(Row, "t3_check", 1);
				sheetObj.SetCellValue(Row, "t3_check", 1);
			}
		}
	}*/

	if (sheetObj.ColSaveName(Col) == "t3_cntrimage") {
		var name = sheetObj.GetCellValue(Row, Col);
		// hidden value setting
		if (sheetObj.GetCellValue(Row, "t3_sortnum") == "2"
				&& sheetObj.GetCellValue(Row, "t3_num") == "1") {
			var view = false;
			if (sheetObj.GetCellValue(Row, "t3_onf_hir_div_cd") == "F"
					&& sheetObj.GetCellValue(Row, "t3_so_iss_flg") != "1"
					&& sheetObj.GetCellValue(Row, "t3_noso_iss_flg") != "1")
				view = false;
			else {
				view = true;
			}
		} else {
			view = true;
		}
		if (!userAreaCheck(sheetObj, "CNTR", "from", "3", Row)
				&& !userAreaCheck(sheetObj, "CNTR", "to", "3", Row)) {
			view = true;
		}
		document.form.cntrno.value = sheetObj.GetCellValue(Row, "t3_cntrno");
		var sRow = sheetObj.FindStatusRow("I|U");
		var arRow = sRow.split(";");
		var cntr_all = "";
		if (sRow != "" && sRow != null) {
			// for(var i=0; i<arRow.length-1; i++) {
			for ( var i = 0; i < arRow.length; i++) {
				if (sheetObj.GetCellValue(arRow[i], "t3_cntrno") != ""
						&& arRow[i] != Row
						&& sheetObj.GetCellValue(Row, "t3_pln_yrwk") == sheetObj
								.GetCellValue(arRow[i], "t3_pln_yrwk")
						&& sheetObj.GetCellValue(Row, "t3_trsp_mod_cd") == sheetObj
								.GetCellValue(arRow[i], "t3_trsp_mod_cd")
						&& sheetObj.GetCellValue(Row, "t3_to_ecc") == sheetObj
								.GetCellValue(arRow[i], "t3_to_ecc")
						&& sheetObj.GetCellValue(Row, "t3_fm_ecc") == sheetObj
								.GetCellValue(arRow[i], "t3_fm_ecc")) {
					cntr_all = cntr_all
							+ sheetObj.GetCellValue(arRow[i], "t3_cntrno")
							+ ",";
				}
			}
		}
		document.form.cntrno_all.value = cntr_all;
		oldValue = 0; // oldvalue initializing
		var fm_ecc = "";
		var to_ecc = "";
		if (sheetObj.GetCellValue(Row, "t3_onf_hir_div_cd") == "F") {
			fm_ecc = sheetObj.GetCellValue(Row, "t3_fm_ecc");
			to_ecc = "XXXXX";
		} else {
			fm_ecc = "XXXXX";
			to_ecc = sheetObj.GetCellValue(Row, "t3_to_ecc");
		}
		var url = "EES_EQR_0094.do" + "?f_cmd=-1" // DEFAULT
				+ "&repoplan_id="
				+ sheetObj.GetCellValue(Row, "t3_repo_pln_id") + "&ref_id="
				+ sheetObj.GetCellValue(Row, "t3_ref_id") + "&targetSheet=3"
				+ "&targetRow=" + Row + "&view=" + view + "&fm_ecc=" + fm_ecc
				+ "&to_ecc=" + to_ecc + "&pln_yrwk="
				+ sheetObj.GetCellValue(Row, "t3_pln_yrwk") + "&trsp_mode="
				+ sheetObj.GetCellValue(Row, "t3_onf_hir_div_cd");
		// var styleInfo="dialogLeft:0px; dialogTop:0px; dialogWidth:800px;
		// dialogHeight:570px;scroll:no; status:no";
		// var modal = ComOpenWindow(url, self, styleInfo , true);
		ComOpenWindowCenter(url, "EES_EQR_0094", 800, 570, true);
	}
}

function t4sheet1_OnDblClick(sheetObj, Row, Col) {
	var colName = sheetObj.ColSaveName(Col);
	var idx = sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
	if ((colName == "t4_fm_yd_cd" || colName == "t4_to_yd_cd")
			&& sheetObj.GetCellEditable(Row, colName) && idx != -1) {
		sheetObj.GetCellValue = "";
	}
}

function t4sheet1_OnChange(sheetObj, Row, Col, Val) {
	var colName = sheetObj.ColSaveName(Col);
	if (colName == "t4_fm_yd_cd" || colName == "t4_to_yd_cd") {
		var searchfmword = sheetObj.GetCellValue(Row, "t4_fm_yd_cd");
		var searchtoword = sheetObj.GetCellValue(Row, "t4_to_yd_cd");
		var searchword = sheetObj.GetCellValue(Row, colName);
		searchword = searchword.toUpperCase();
		var idx = sheetObj.GetComboInfo(Row, Col, "SelectedIndex");

		if (idx == -1 && searchword != "") {
			var basic_ecc = "";
			if (colName == "t4_fm_yd_cd") {
				basic_ecc = sheetObj.GetCellValue(Row, "t4_fm_ecc");
				if (basic_ecc == "" || basic_ecc == null)
					basic_ecc = sheetObj.GetCellValue(Row, "t4_to_ecc");
				colName1 = "t4_fm_ecc";
			} else if (colName == "t4_to_yd_cd") {
				basic_ecc = sheetObj.GetCellValue(Row, "t4_to_ecc");
				if (basic_ecc == "" || basic_ecc == null)
					basic_ecc = sheetObj.GetCellValue(Row, "t4_fm_ecc");
				colName1 = "t4_to_ecc";
			}

			var basic_lcc_cd = "";
			if (colName == "t4_fm_yd_cd") {
				basic_lcc_cd = sheetObj.GetCellValue(Row, "t4_fm_yd_cd");
				if (basic_lcc_cd == "" || basic_lcc_cd == null)
					basic_lcc_cd = sheetObj.GetCellValue(Row, "t4_fm_yd_cd");
			} else if (colName == "t4_to_yd_cd") {
				basic_lcc_cd = sheetObj.GetCellValue(Row, "t4_to_yd_cd");
				if (basic_lcc_cd == "" || basic_lcc_cd == null)
					basic_lcc_cd = sheetObj.GetCellValue(Row, "t4_to_yd_cd");
			}

			var CellPro = sheetObj.GetCellProperty(Row, colName, "Type");
			if (searchword.length == 7) { // LOC YARD
				var f_cmd = SEARCH16;
				sheetObj.InitCellProperty(Row, colName, {
					Type : "Text",
					AcceptKeys : "E|N",
					InputCaseSensitive : 1
				});
				var sXml = sheetObj.GetSearchData("EES_LOCYARDLCC_COMMON.do",
						"row=" + Row + "&locfmyard=" + searchfmword
								+ "&loctoyard=" + searchtoword + "&locyard="
								+ searchword + "&ecc=" + basic_ecc
								+ "&colname=" + colName + "&colname1="
								+ colName1 + "&f_cmd=" + f_cmd + "&lcc_cd="
								+ basic_lcc_cd);
				var strYardYn = ComGetEtcData(sXml, "strYardYn");

				if (strYardYn == "") {
					ComShowCodeMessage("EQR70014", searchword);
					sheetObj.SetCellValue(Row, colName, "", 0);
				} else if (strYardYn == "Y") {
				} else if (strYardYn == "N") {
					ComShowCodeMessage("EQR70015", searchword);
					sheetObj.SetCellValue(Row, colName, "", 0);
				}
				/*
				 * var searchword=sheetObj.GetCellValue(Row, colName);
				 * if(sheetObj.GetCellValue(Row, "t4_ibflag") == "I") {
				 * ComShowCodeMessage("EQR70012",searchword); }else{
				 * ComShowCodeMessage("EQR70012",searchword); }
				 * 
				 * sheetObj.SetCellValue(Row,colName,"",0);
				 */

			} else { // LOC YARD COMBO BOX
				var f_cmd = SEARCHLIST01;
				// sheetObj.DoRowSearch(
				// ROW,row=Row&searchword=searchword&colname=t4_fm_yd_cd&f_cmd=f_cmd
				// );
				// sheetObj.DoRowSearch2("EES_LOCYARD_COMMON.do"
				// ,"row="+Row+"&searchword="+searchword+"&colname=t4_fm_yd_cd&f_cmd="+f_cmd);
				// var sXml = sheetObj.GetSearchData("EES_LOCYARD_COMMON.do",
				// "row="+Row+"&searchword="+searchword+"&colname=t4_fm_yd_cd&f_cmd="+f_cmd);
				var sXml = sheetObj
						.GetSearchData("EES_EQR_0059GS3.do", "locyard_row="
								+ Row + "&locyard_searchword=" + searchword
								+ "&locyard_colname=t4_fm_yd_cd&f_cmd=" + f_cmd);

				changeViewComboChange(sheetObj, sXml);
				if (ComboData == "Y") {
					sheetObj.InitCellProperty(Row, "t4_fm_yd_cd", {
						Type : "Combo"
					});
					sheetObj.DoRowSearch2("EES_EQR_0059GS3.do", "locyard_row="
							+ Row + "&locyard_searchword=" + searchword
							+ "&locyard_colname=t4_fm_yd_cd&f_cmd=" + f_cmd);
					// var sXml = sheetObj.GetSearchData("EES_EQR_0059GS3.do",
					// "locyard_row="+Row+"&locyard_searchword="+searchword+"&locyard_colname=t4_fm_yd_cd&f_cmd="+f_cmd);
					// changeViewComboChange(sheetObj, sXml);

					// sheetObj.DoRowSearch(
					// ROW,row=Row&searchword=searchword&colname=t4_to_yd_cd&f_cmd=f_cmd
					// );
					// sheetObj.DoRowSearch2("EES_LOCYARD_COMMON.do"
					// ,"row="+Row+"&searchword="+searchword+"&colname=t4_to_yd_cd&f_cmd="+f_cmd);
					sheetObj.InitCellProperty(Row, "t4_to_yd_cd", {
						Type : "Combo"
					});
					sheetObj.DoRowSearch2("EES_EQR_0059GS3.do", "locyard_row="
							+ Row + "&locyard_searchword=" + searchword
							+ "&locyard_colname=t4_to_yd_cd&f_cmd=" + f_cmd);

					// sheetObj.CellValue2(row, colName) = searchword;
					sheetObj.SetCellValue(Row, "t4_fm_yd_cd", "");
					sheetObj.SetCellValue(Row, "t4_to_yd_cd", "");
					sheetObj.SetCellValue(Row, "t4_fm_ecc", searchword
							.substring(0, 5));
					sheetObj.SetCellValue(Row, "t4_to_ecc", searchword
							.substring(0, 5));
					/*
					 * sheetObj.InitCellProperty(Row,"t4_fm_yd_cd",{
					 * Type:"ComboEdit"} );
					 * sheetObj.InitCellProperty(Row,"t4_to_yd_cd",{
					 * Type:"ComboEdit"} );
					 */
				} else {
					sheetObj.SetColProperty("t4_fm_yd_cd", {
						AcceptKeys : "E|N",
						InputCaseSensitive : 1
					});
					sheetObj.SetColProperty("t4_to_yd_cd", {
						AcceptKeys : "E|N",
						InputCaseSensitive : 1
					});
					ComShowCodeMessage("EQR70012", searchword);
				}
			}
		}
	}
	// ---------------------- WEEK modifying
	// ----------------------------------------------------------------
	if (sheetObj.ColSaveName(Col) == "t4_pln_yrwk") {
		var weekInput = sheetObj.GetCellValue(Row, Col); // input data week
		var repoPlnWeek = document.form.yyyyww.value;
		var repoPlnNextWeek = document.form.repoPlnNextWeek.value;
		// 1) checking from is week
		if (weekInput.length < 6) {
			// ComShowMessage("please input week data format ! ");
			ComShowCodeMessage("EQR90056");
			sheetObj.SetCellValue(Row, Col, "", 0);
			return false;
		} else {
			if (weekInput.substring(4, 6) < 01
					|| weekInput.substring(4, 6) > 53) {
				// ComShowMessage("please input week data format ! ");
				ComShowCodeMessage("EQR90056");
				sheetObj.SetCellValue(Row, Col, "", 0);
				sheetObj.SelectCell(Row, Col);
				return false;
			} else {
				// in case of repo plan id, +1,+2 week, executable
				if (weekInput == repoPlnWeek || weekInput == repoPlnNextWeek) {
					var f_cmd = SEARCHLIST17;
					// var searchword = sheetObj.EditText;
					// ETD retrieve
					// sheetObj.DoRowSearch(
					// ROW,row=Row&searchword=weekInput&colname1=t4_week_fromdate&colname2=t4_week_todate&f_cmd=f_cmd
					// );
					sheetObj
							.DoRowSearch2(
									"EES_WEEKDATEPERIOD.do",
									"row="
											+ Row
											+ "&searchword="
											+ weekInput
											+ "&colname1=t4_week_fromdate&colname2=t4_week_todate&f_cmd="
											+ f_cmd);
					// ETA retrieve
					// sheetObj.DoRowSearch(
					// ROW,row=Row&searchword=weekInput&colname1=t4_week_fromdate&colname2=t4_week_maxdate&division=WIDE&f_cmd=f_cmd
					// );
					sheetObj
							.DoRowSearch2(
									"EES_WEEKDATEPERIOD.do",
									"row="
											+ Row
											+ "&searchword="
											+ weekInput
											+ "&colname1=t4_week_fromdate&colname2=t4_week_maxdate&division=WIDE&f_cmd="
											+ f_cmd);
					sheetObj.SetCellValue(Row, "t4_fm_etd_dt", "", 0);
					sheetObj.SetCellValue(Row, "t4_to_eta_dt", "", 0);
				} else {
					ComShowCodeMessage("EQR90151", "Week", repoPlnWeek,
							repoPlnNextWeek);
					sheetObj.SetCellValue(Row, Col, "", 0);
					sheetObj.SelectCell(Row, Col);
				}
			}
		}
	}
	if (sheetObj.ColSaveName(Col) == "t4_fm_etd_dt"
			&& sheetObj.GetCellValue(Row, "t4_sortnum") == "2"
			&& sheetObj.GetCellValue(Row, "t4_fm_etd_dt") != "") { // ETD
																	// modifying
		var etd = sheetObj.GetCellValue(Row, "t4_fm_etd_dt");
		var frdate = sheetObj.GetCellValue(Row, "t4_week_fromdate");
		var todate = sheetObj.GetCellValue(Row, "t4_week_todate");
		if (sheetObj.GetCellValue(Row, "t4_pln_yrwk").length == 6) {
			if (etd < frdate || etd > todate) {
				ComShowCodeMessage("EQR90141", "ETD", frdate, todate);
				sheetObj.SetCellValue(Row, "t4_fm_etd_dt", "", 0);
				return false;
			}
		} else {
			ComShowCodeMessage("EQR90001", "Week "); // please input week
														// information
			sheetObj.SetCellValue(Row, "t4_fm_etd_dt", "", 0);
			sheetObj.SelectCell(Row, "t4_pln_yrwk");
			return false;
		}
	}
	// ---------- ETA modifying (EXECUTE ROW)
	// ----------------------------------------------
	if (sheetObj.ColSaveName(Col) == "t4_to_eta_dt"
			&& sheetObj.GetCellValue(Row, "t4_sortnum") == "2"
			&& sheetObj.GetCellValue(Row, "t4_to_eta_dt") != "") { // ETD
																	// modifying한
																	// 경우
		var eta = sheetObj.GetCellValue(Row, "t4_to_eta_dt");
		var frdate = sheetObj.GetCellValue(Row, "t4_week_fromdate");
		var maxdate = sheetObj.GetCellValue(Row, "t4_week_maxdate"); // week
																		// fromdate
																		// + 7주
		if (sheetObj.GetCellValue(Row, "t4_pln_yrwk").length == 6) {
			if (eta < frdate || eta > maxdate) {
				ComShowCodeMessage("EQR90141", "ETA", frdate, maxdate);
				sheetObj.SetCellValue(Row, "t4_to_eta_dt", "");
				sheetObj.SetCellEditable(Row, "t4_to_eta_dt", 1);
				return false;
			}
		} else {
			ComShowCodeMessage("EQR90001", "Week "); // please input week
														// information
			sheetObj.SetCellValue(Row, "t4_to_eta_dt", "", 0);
			sheetObj.SelectCell(Row, "t4_pln_yrwk");
			return false;
		}
	}
	// ------------- ETD, ETA modifying(PLAN, EXECUTE ROW )
	// ------------------------------------------------
	if (sheetObj.ColSaveName(Col) == "t4_fm_etd_dt"
			|| sheetObj.ColSaveName(Col) == "t4_to_eta_dt") {
		var etd = sheetObj.GetCellValue(Row, "t4_fm_etd_dt");
		var eta = sheetObj.GetCellValue(Row, "t4_to_eta_dt");
		// -- EXECUTE ROW (DATE modifying)
		if (sheetObj.GetCellValue(Row, "t4_sortnum") == "2") {
			if (etd.length == 8 && eta.length == 8) {
				if (etd > eta) {
					ComShowCodeMessage("EQR90077");
					sheetObj.SetCellValue(Row, Col, "", 0);
				}
			}
		}
	}

	// ---------------------- CNTR NO optional
	// ----------------------------------------------------------------
	if (sheetObj.ColSaveName(Col) == "t4_tpszno") {
		var tpszConArr = Val.split(",");
		var vol = 0;
		for ( var i = 0; i < consTpszArr.length; i++) { // tysz
			for ( var j = 0; j < tpszConArr.length; j++) {
				if (consTpszArr[i] == tpszConArr[j])
					vol++;
			}
			// if(eval(vol) > eval(sheetObj.GetCellValue(Row,
			// "t4_vol"+consTpszArr[i]))) {
			oldValue = sheetObj.GetCellValue(Row, "t4_vol" + consTpszArr[i]);
			sheetObj.SetCellValue(Row, "t4_vol" + consTpszArr[i], vol);// onchange
																		// event
			// }
			vol = 0;
		}
	}
	// ------- in case of vol modified
	// ----------------------------------------------------------
	if (sheetObj.ColSaveName(Col).substring(0, 6) == "t4_vol") {
		var limitFlag = false;
		var cntrVol = 0;
		var tpszName = sheetObj.ColSaveName(Col).substring(6, 8);
		if (sheetObj.GetCellValue(Row, "t4_cntrimage") == "0") {
			cntrVol = sheetObj.GetCellValue(Row, "t4_cntrvol" + tpszName);
			// ComShowMessage("1 Val : "+Val+", CNTR : "+cntrVol);
			if (eval(Val) < eval(cntrVol)) {
				limitFlag = true;
			}
		} else if (sheetObj.GetCellValue(Row, "t4_cntrimage") == "1"
				&& sheetObj.GetCellValue(Row, "t4_cntrno") != "") {
			var tpszConArr = sheetObj.GetCellValue(Row, "t4_tpszno").split(",");
			for ( var j = 0; j < tpszConArr.length; j++) {
				if (tpszName == tpszConArr[j])
					cntrVol++;
			}
			if (eval(Val) < eval(cntrVol)) {
				limitFlag = true;
			}
		}
		if (limitFlag) {
			ComShowCodeMessage("EQR90048", tpszName, cntrVol);
			// sheetObj.CellValue(Row,Col) = sheetObj.CellSearchValue(Row,Col);
			// // rollback
			sheetObj.SetCellValue(Row, Col, oldValue, 0);// rollback
		} else {
			// ComShowMessage("Val : " + Val +
			// ",sheetObj.CellSearchValue(Row,Col) : " +
			// sheetObj.CellSearchValue(Row,Col));
			// ComShowMessage("Val : " + Val + ",oldValue : " + oldValue);
			// var diffVol = eval(Val - sheetObj.CellSearchValue(Row,Col));
			var diffVol = eval(Val - oldValue);
			var grandTotalRow = 0;
			var subTotalRow = 0;
			// Grand Total 합산
			while (true) {
				grandTotalRow = sheetObj.FindText("t4_num", 3,
						grandTotalRow + 1); // TOTAL ROW retreive
				if (grandTotalRow == -1) {
					break;
				} else {
					if (sheetObj.GetCellValue(grandTotalRow, "t4_sortnum") == 2) { // Execution
																					// Row
																					// retreive
						sheetObj.SetCellValue(grandTotalRow, Col, eval(sheetObj
								.GetCellValue(grandTotalRow, Col))
								+ eval(diffVol), 0);
						sheetObj.SetCellValue(grandTotalRow, "t4_totalvol",
								eval(sheetObj.GetCellValue(grandTotalRow,
										"t4_totalvol"))
										+ eval(diffVol), 0);
						sheetObj.SetRowStatus(grandTotalRow, "R");
						sheetObj.SetRowBackColor(grandTotalRow, "#FEBDB6");
					}
				}
			}
			while (true) {
				subTotalRow = sheetObj.FindText("t4_num", 2, subTotalRow + 1); // SUB
																				// ROW
																				// retreive
				if (subTotalRow == -1) {
					break;
				} else {
					if (sheetObj.GetCellValue(subTotalRow, "t4_sortnum") == 2) { // Execution
																					// Row
																					// retreive
						if (sheetObj.GetCellValue(subTotalRow, "t4_pln_yrwk")
								.substr(0, 6) == sheetObj.GetCellValue(Row,
								"t4_pln_yrwk")) {
							sheetObj.SetCellValue(subTotalRow, Col,
									eval(sheetObj
											.GetCellValue(subTotalRow, Col))
											+ eval(diffVol), 0);
							sheetObj.SetCellValue(subTotalRow, "t4_totalvol",
									eval(sheetObj.GetCellValue(subTotalRow,
											"t4_totalvol"))
											+ eval(diffVol), 0);
							sheetObj.SetRowStatus(subTotalRow, "R");
							sheetObj.SetRowBackColor(subTotalRow, "#F9DF9B");
						}
					}
				}
			}
			// Total Vol
			sheetObj.SetCellValue(Row, "t4_totalvol", eval(sheetObj
					.GetCellValue(Row, "t4_totalvol"))
					+ eval(diffVol), 0);
			sheetObj.SetCellValue(Row, "t4_flag"
					+ sheetObj.ColSaveName(Col).substring(6, 8), "T", 0);
			oldValue = Val;
		}
	}
}

function t4sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
	if (sheetObj.ColSaveName(NewCol).substring(0, 6) == "t4_vol") {
		oldValue = sheetObj.GetCellValue(NewRow, NewCol);
		// alert("oldValue : " +oldValue);
	}
}
//
function t4sheet1_OnClick(sheetObj, Row, Col, Val) {
	// if(sheetObj.ColSaveName(Col).substring(0,6) == "t4_vol") oldValue = Val;
	if (sheetObj.GetRowStatus(Row) == "I"
			&& sheetObj.ColSaveName(Col) == "t4_check") {
		sheetObj.SetCellValue(Row, "t4_cntrno", "");// CNTR initializing
		for ( var i = 0; i < consTpszArr.length; i++) {
			oldValue = sheetObj.GetCellValue(Row, "t4_vol" + consTpszArr[i]); // old
																				// value
																				// setting
			sheetObj.SetCellValue(Row, "t4_vol" + consTpszArr[i], "0");// '0'
		}
	}

	if (sheetObj.ColSaveName(Col) == "t4_cntrimage") { // cntr input image cell
		var name = sheetObj.GetCellValue(Row, Col);
		// hidden value setting
		if (sheetObj.GetCellValue(Row, "t4_pln_yrwk").length != 6) {
			ComShowCodeMessage("EQR90001", "Week "); // please input week
														// information
			sheetObj.SetCellValue(Row, "t4_fm_etd_dt", "", 0);
			sheetObj.SelectCell(Row, "t4_pln_yrwk");
			return false;
		}
		if (sheetObj.GetCellValue(Row, "t4_sortnum") == "2"
				&& sheetObj.GetCellValue(Row, "t4_num") == "1") {
			var view = false;
			if (sheetObj.GetCellValue(Row, "t4_so_iss_flg") != "1") {
				view = false;
			} else {
				view = true;
			}
			document.form.cntrno.value = sheetObj
					.GetCellValue(Row, "t4_cntrno");
			var sRow = sheetObj.FindStatusRow("I|U");
			var arRow = sRow.split(";");
			var cntr_all = "";
			// if(sRow!="" && sRow!=null) {
			// for(var i=0; i<arRow.length-1; i++) {
			// if(sheetObj.CellValue(arRow[i], "t4_cntrno")!="" &&
			// arRow[i]!=Row) {
			// cntr_all = cntr_all + sheetObj.CellValue(arRow[i],
			// "t4_cntrno")+",";
			// }
			// }
			// }
			document.form.cntrno_all.value = cntr_all;
			oldValue = 0; // oldvalue initializing
			var url = "EES_EQR_0094.do" + "?f_cmd=-1" // DEFAULT
					+ "&repoplan_id="
					+ sheetObj.GetCellValue(Row, "t4_repo_pln_id") + "&ref_id="
					+ sheetObj.GetCellValue(Row, "t4_ref_id")
					+ "&targetSheet=4" + "&targetRow=" + Row + "&view=" + view
					+ "&fm_ecc=XXXXX" + "&to_ecc=XXXXX" + "&pln_yrwk="
					+ sheetObj.GetCellValue(Row, "t4_pln_yrwk")
					+ "&trsp_mode=S";
			// var styleInfo="dialogLeft:0px; dialogTop:0px; dialogWidth:800px;
			// dialogHeight:570px;scroll:no; status:no";
			// var modal = ComOpenWindow(url, self, styleInfo , true);
			ComOpenWindowCenter(url, "EES_EQR_0094", 800, 570, true);
		}
	}
}
// calcuating sub total after retrieve
function t4sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var totalRow = sheetObj.RowCount();	
	
	for (i = 2; i <= totalRow; i++) {	
		if (sheetObj.GetCellValue(i, "t4_div") == "W/O Issue") {
			sheetObj.SetRowEditable(i,0);
		}
	}
	
	sheetObj.SetWaitImageVisible(0);
	ComOpenWait(false);
}

// calcuating sub total after retrieve
function t5sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	sheetObj.SetWaitImageVisible(0);
	ComOpenWait(false);
	
	var formObj = document.form; 
	formObj.f_cmd.value=SEARCHLIST10;
	var sXml= sheetObj.GetSearchData("EES_EQR_0012GS.do", FormQueryString(formObj));
	
	var strDataYN=ComGetEtcData(sXml, "dataYN");
	if(strDataYN == "Y") {
		ComBtnDisable("btn_create");
        ComBtnDisable("btn_delete");
	}else{
		ComBtnDisable("btn_create");
        ComBtnEnable("btn_delete");
	}
	
	if (document.form.exePlnEditFlg.value.toUpperCase() == "FALSE") {
		sheetObj.SetEditable(0);
	}
}
function t5sheet1_OnChange(sheetObj, Row, Col, Val) {
}
/**
 * registering IBTab Object as list adding process for list in case of needing
 * batch processing with other items defining list on the top of source
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++] = tab_obj;
}
/**
 * initializing Tab setting Tab items
 */
function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {
			var cnt = 0;
			InsertItem(tabName[0], "");
			InsertItem(tabName[1], "");
			InsertItem(tabName[2], "");
			InsertItem(tabName[3], "");
			InsertItem(tabName[4], "");
		}
		break;
	}
}
/**
 * handling changing event on tab
 */
function tab1_OnChange(tabObj, nItem) {
	var formObject = document.form;
	var beforeRow = sheetObjects[beforetab].FindStatusRow("U|D|I");
	if (beforeRow != "") {
		if (ComShowConfirm(ComGetMsg("EQR90120", tabName[beforetab]))) {
			if (beforetab == 0)
				doActionIBSheet(sheetObjects[beforetab], formObject, IBSAVE);
			if (beforetab == 1)
				doActionIBSheet2(sheetObjects[beforetab], formObject, IBSAVE);
			if (beforetab == 2)
				doActionIBSheet3(sheetObjects[beforetab], formObject, IBSAVE);
			if (beforetab == 3)
				doActionIBSheet4(sheetObjects[beforetab], formObject, IBSAVE);
			if (beforetab == 4)
				doActionIBSheet5(sheetObjects[beforetab], formObject, IBSAVE);
		}
	}
	var sel_tab = tab1.GetSelectedIndex();
	if (sel_tab == 0 && sheetObjects[sel_tab].RowCount() == 0) {
		sheetObjects[sel_tab].SetWaitImageVisible(1);

		setTimeout(function() {
			if (formObject.yyyyww.value != "" && formObject.seq.value != "") {
				doActionIBSheet(sheetObjects[sel_tab], formObject, IBSEARCH);
			}
			sheetObjects[sel_tab].SetWaitImageVisible(0);
		}, 100);
	}
	if (sel_tab == 1 && sheetObjects[sel_tab].RowCount() == 0) {
		sheetObjects[sel_tab].SetWaitImageVisible(1);

		setTimeout(function() {
			if (formObject.yyyyww.value != "" && formObject.seq.value != "") {
				doActionIBSheet2(sheetObjects[sel_tab], formObject, IBSEARCH);
			}
			sheetObjects[sel_tab].SetWaitImageVisible(0);
		}, 100);
	}
	if (sel_tab == 2 && sheetObjects[sel_tab].RowCount() == 0) {
		sheetObjects[sel_tab].SetWaitImageVisible(1);
		setTimeout(function() {
			if (formObject.yyyyww.value != "" && formObject.seq.value != "") {
				doActionIBSheet3(sheetObjects[sel_tab], formObject, IBSEARCH);
			}
			sheetObjects[sel_tab].SetWaitImageVisible(0);
		}, 100);
	}
	if (sel_tab == 3 && sheetObjects[sel_tab].RowCount() == 0) {
		sheetObjects[sel_tab].SetWaitImageVisible(1);
		setTimeout(function() {
			if (formObject.yyyyww.value != "" && formObject.seq.value != "") {
				doActionIBSheet4(sheetObjects[sel_tab], formObject, IBSEARCH);
			}
			sheetObjects[sel_tab].SetWaitImageVisible(0);
		}, 100);
	}
	if (sel_tab == 4 && sheetObjects[sel_tab].RowCount() == 0) {
		sheetObjects[sel_tab].SetWaitImageVisible(1);
		setTimeout(function() {
			if (formObject.yyyyww.value != "" && formObject.seq.value != "") {
				doActionIBSheet5(sheetObjects[sel_tab], formObject, IBSEARCH);
			}
			sheetObjects[sel_tab].SetWaitImageVisible(0);
		}, 100);
	}

	// ------------- tab start -----------------
	var objs = document.all.item("tabLayer");
	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";
	// --------------- Important --------------------------//
	objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
	// ------------------------------------------------------//
	beforetab = nItem;
	var selectedTab = tabObj.GetSelectedIndex(); // tabinfo
	// alert(tabObj);
	if (selectedTab == 0) { // 0, T.VVD & D.VVD
		document.form.sosend.disabled = true;
		// document.form.socreation.disabled = true;
		document.form.mty.disabled = false;
		document.form.lane.disabled = false;
		document.form.vvd.disabled = false;
		// document.form.reason.disabled = false;
		document.form.toStatus.disabled = false;
		if (document.form.toStatus.value != "")
			document.form.toLocation.disabled = false;
		document.form.atStatus.disabled = false;
		if (document.form.atStatus.value != "")
			document.form.atLocation.disabled = false;
		document.form.fmToAt[1].disabled = false;
		document.form.dataselect[0].checked = true;
	} else if (selectedTab == 1) { // 1, TRUCK & RAIL & WATER
		// document.form.socreation.disabled = true;
		document.form.sosend.disabled = false;
		document.form.mty.disabled = false;
		document.form.lane.disabled = false;
		document.form.vvd.disabled = false;
		// document.form.reason.disabled = false;
		document.form.toStatus.disabled = false;
		if (document.form.toStatus.value != "")
			document.form.toLocation.disabled = false;
		document.form.atStatus.disabled = false;
		if (document.form.atStatus.value != "")
			document.form.atLocation.disabled = false;
		document.form.fmToAt[1].disabled = false;
		document.form.dataselect1[0].checked = true;
	} else if (selectedTab == 2) { // 2, ON-HIRE & OFF-HIRE
		// document.form.socreation.disabled = true;
		document.form.mty.disabled = true;
		document.form.lane.disabled = true;
		document.form.vvd.disabled = true;
		document.form.toStatus.disabled = true;
		document.form.toLocation.disabled = true;
		document.form.atStatus.disabled = true;
		document.form.atLocation.disabled = true;
		document.form.fmToAt[1].disabled = true;
		// document.form.fmToAt[0].checked = true;
		// document.all.fmToLayer.style.display = "inline";
		// document.all.atLayer.style.display = "none";
		document.form.sosend.disabled = false;
		// document.form.reason.disabled = false;
		document.form.dataselect2[0].checked = true;
		/*
		 * if(formObject.nowWeek.value < formObject.yyyyww.value) { //row add
		 * 비활성 ComBtnEnable("t3btng_rowadd_plan"); }
		 */
	} else if (selectedTab == 3) {
		// document.form.socreation.disabled = true;
		document.form.mty.disabled = true;
		document.form.lane.disabled = true;
		document.form.vvd.disabled = true;
		// document.form.reason.disabled = true;
		document.form.sosend.disabled = false;
		document.form.toStatus.disabled = false;
		if (document.form.toStatus.value != "")
			document.form.toLocation.disabled = false;
		document.form.atStatus.disabled = false;
		if (document.form.atStatus.value != "")
			document.form.atLocation.disabled = false;
		document.form.fmToAt[1].disabled = false;
		document.form.dataselect3[0].checked = true;
	} else if (selectedTab == 4) { // 4, TOTAL
		// document.form.socreation.disabled = false;
		document.form.mty.disabled = false;
		document.form.lane.disabled = false;
		document.form.vvd.disabled = false;
		// document.form.reason.disabled = false;
		document.form.sosend.disabled = false;
		document.form.toStatus.disabled = false;
		if (document.form.toStatus.value != "")
			document.form.toLocation.disabled = false;
		document.form.atStatus.disabled = false;
		if (document.form.atStatus.value != "")
			document.form.atLocation.disabled = false;
		document.form.fmToAt[1].disabled = false;
		document.form.dataselect4[0].checked = true;
	}
	resizeSheet();
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction, tabNum) {
	var formObj = document.form;
	with (formObj) {
		// btn_retrieve
		if (sAction == 0) {
			// repo plan id inserting
			if (!chkRepoplanId(formObj, 'yyyyww', 'seq')) {
				return false;
			}
			// REPO_PLAN_ID retreive
			if (formObj.dtrb_flg.value != 'Y') {
				// ComShowCodeMessage("EQR90049");
				// return false;
			}
			if (fmToAt[1].checked == true) {
				if (!checkLocItem(formObj, 'atStatus', 'atLocation')) {
					return false;
				}
			} else {
				if (!checkLocItem(formObj, 'fromStatus', 'fromLocation')) {
					return false;
				}
				if (!checkLocItem(formObj, 'toStatus', 'toLocation')) {
					return false;
				}
			}
			if (!checkTpszCombo(2)) {
				return false;
			}
			if(strLoading != false) {
				if (!chkFromToWeek(formObj, 'fmPlnYr', 'fmPlnWk', 'FROM')) {
					return false;
				}
				if (!chkFromToWeek(formObj, 'toPlnYr', 'toPlnWk', 'TO')) {
					return false;
				}
			}
		} else if (sAction == 2) { // save
			var sRow = sheetObj.FindStatusRow("I|U");
			var arRow = sRow.split(";");
			var cntr_all = "";

			if (sRow != "" && sRow != null) {
				// for(var i=0; i<arRow.length-1; i++) {
				for ( var i = 0; i < arRow.length; i++) {

					/*
					 * if(sheetObj.GetCellValue(arRow[i],
					 * "t"+tabNum+"_totalvol")=="0" &&
					 * sheetObj.GetCellValue(arRow[i],
					 * "t"+tabNum+"_sortnum")!="1"
					 *  ) { ComShowCodeMessage("EQR90128", eval(arRow[i])-1);
					 * return false; }
					 */

					if (sheetObj.GetCellValue(arRow[i], "t" + tabNum
							+ "_totalvol") == "0") {
						ComShowCodeMessage("EQR90128", eval(arRow[i]) - 1);
						return false;
					} else {
						if (sheetObj.GetCellValue(arRow[i], "t" + tabNum
								+ "_totalvol") == "0"
								&& sheetObj.GetCellValue(arRow[i], "t" + tabNum
										+ "_sortnum") != "1") {
							ComShowCodeMessage("EQR90128", eval(arRow[i]) - 1);
							return false;
						}
					}
				}
			}
		}
	}
	return true;
}
// Reason Reason Remark
function otherCombo(sheet, Row, Col) {
	var sText = sheet.GetCellText(Row, Col); // text
	var sValue = sheet.GetCellValue(Row, Col); // code
	if (sValue == 99) { // Others
		sheet.SetCellValue(Row, Col + 1, '', 0);
		sheet.SetCellEditable(Row, Col + 1, 1);
		sheet.SelectCell(Row, Col + 1, true);
	} else {
		sheet.SetCellValue(Row, Col + 1, "", 0);
		sheet.SetCellEditable(Row, Col + 1, 0);
	}
}
function goSearchRepoid(Type) {
	var formObject = document.form;
	var result = "";
	if (formObject.yyyyww.value.length != '6') {

		if (Type != "Loading") {
			ComShowCodeMessage("EQR70011");
		}
		ComSetFocus(formObject.yyyyww);
		sheetObjects[0].SetWaitImageVisible(0);
		ComOpenWait(false);

		result = false;
		return false;
	}

	if (formObject.seq.value.length == 4) {
		var yyyymmdd = new Date();
		// var year=yyyymmdd.getYear();
		var year = yyyymmdd.getFullYear();
		var month = yyyymmdd.getMonth() + 1;
		var date = yyyymmdd.getDate();
		year = "" + year;
		month = "" + month;
		date = "" + date;
		if (month.length == 1) {
			month = "0" + month;
		}
		if (date.length == 1) {
			date = "0" + date;
		}
		ComOpenWait(true);
		var localDate = year + month + date;
		formObject.localDate.value = localDate;
		// ComShowMessage("localDate : " + localDate);
		/*formObject.f_cmd.value = SEARCHLIST03;
		formObject.target = "059iframe";
		formObject.action = "EES_REPO_COMMON.do";
		result = formObject.submit();*/
		// setTimeout(ibSearchAsync03, 10000);

		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
		sheetObjects[3].RemoveAll();
		sheetObjects[4].RemoveAll();
		if (formObject.yyyyww.value.length == 6
				&& formObject.seq.value.length == 4) {
			formObject.repo_pln_id.value = repoword + formObject.yyyyww.value
					+ repoweek + formObject.seq.value;
		} else {
			//ComShowMessage(ComGetMsg("EQR90001", "Repoplan ID"));
			//formObject.seq.value = "";
			//formObject.repo_rmk.value = "";
			// ComSetFocus(formObject.seq);
		}
		ComOpenWait(true);
        doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC04);
	} else {
		if (formObject.seq.value.length > 0 && formObject.seq.value.length < 4) {
			ComShowCodeMessage("EQR70011");
			formObject.seq.value = "";
			formObject.repo_rmk.value = "";
			ComSetFocus(formObject.seq);
		} else if (formObject.seq.value.length == 0) {
			formObject.repo_rmk.value = "";
			// ComSetFocus(formObject.seq);
		}
	}

	return result;
}

function ibSearchAsync03() {
	var formObject = document.form;
	if (formObject.status_type.value == "" || formObject.status_type.value == "null") {
		/*if (ComShowConfirm(ComGetMsg("EQR90237"))) {
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC03);
		} else {
			formObject.yyyyww.value = "";
			formObject.seq.value = "";
			formObject.repo_rmk.value = "";
			ComOpenWait(false);
			return false;
		}*/
		
		ComBtnEnable("btn_create");
		ComBtnDisable("btn_delete");
		
		ComShowCodeMessage("EQR01149");
		
		ComOpenWait(false);
	}

}

function setEccCommon() {
	linkPageNum = 0;
	if (document.form.dtrb_flg.value == "N") {
		// ComShowCodeMessage("EQR90049");
		// document.form.yyyyww.value="";
		// document.form.seq.value="";
		// document.form.repo_rmk.value="";
	} else {
		if (document.form.dtrb_flg.value != "") {
			document.form.fmPlnYr.value = document.form.st_year.value;
			document.form.fmPlnWk.value = document.form.st_weekly.value;
			document.form.toPlnYr.value = document.form.end_year.value;
			document.form.toPlnWk.value = document.form.end_weekly.value;
		} else {
			linkPageNum = null;
		}
	}

	var sel_tab = tab1.GetSelectedIndex();
	setTimeout(function() {
		if (linkPageNum != null) {
			if (sel_tab == 0)
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			else if (sel_tab == 1)
				doActionIBSheet2(sheetObjects[1], document.form, IBSEARCH);
			else if (sel_tab == 2)
				doActionIBSheet3(sheetObjects[2], document.form, IBSEARCH);
			else if (sel_tab == 3)
				doActionIBSheet4(sheetObjects[3], document.form, IBSEARCH);
			else if (sel_tab == 4)
				doActionIBSheet5(sheetObjects[4], document.form, IBSEARCH);
		}
	}, 500);
	// initializing
	checkTapButton();
}
// setting location
function frLocChange(key) {
	var gubun = key;
	if (gubun == "") {
		document.form.fromLocation.value = "";
		document.form.fromLocation.disabled = true;
	} else {
		document.form.fromLocation.value = "";
		document.form.fromLocation.disabled = false;
	}
}
// setting location
function toLocChange(key) {
	var gubun = key;
	if (gubun == "") {
		document.form.toLocation.value = "";
		document.form.toLocation.disabled = true;
	} else {
		document.form.toLocation.value = "";
		document.form.toLocation.disabled = false;
	}
}
// setting location
function atLocChange(key) {
	var gubun = key;
	if (gubun == "") {
		document.form.atLocation.value = "";
		document.form.atLocation.disabled = true;
	} else {
		document.form.atLocation.value = "";
		document.form.atLocation.disabled = false;
	}
}
function tpszChange(key) {
	switch (key) {
	case "":
		comboObjects[1].SetSelectCode(-1);
		comboObjects[1].SetSelectCode(consTpsz);
		break;
	case "D":
		comboObjects[1].SetSelectCode(-1);
		comboObjects[1].SetSelectCode(consTpszDry);
		break;
	case "S":
    	comboObjects[1].SetSelectCode(-1);
        comboObjects[1].SetSelectCode(consTpszSpc);
    	break;
    case "R":
    	comboObjects[1].SetSelectCode(-1);
        comboObjects[1].SetSelectCode(consTpszZrb);
    	break;
	/*case "R":
		comboObjects[1].SetSelectCode(-1);
		comboObjects[1].SetSelectCode(consTpszRfr);
		break;
	case "O":
		comboObjects[1].SetSelectCode(-1);
		comboObjects[1].SetSelectCode(consTpszOt);
		break;
	case "F":
		comboObjects[1].SetSelectCode(-1);
		comboObjects[1].SetSelectCode(consTpszFr);
		break;*/
	}
}

function settingCntrDelValue(targetSheet, targetRow) {
	var CheckYN = "N";
	if (targetSheet == 1) {
		CheckYN = sheetObjects[0].GetCellValue(targetRow, "t1_cntrdel");
	} else if (targetSheet == 2) {
		CheckYN = sheetObjects[1].GetCellValue(targetRow, "t2_cntrdel");
	} else if (targetSheet == 3) {
		CheckYN = sheetObjects[2].GetCellValue(targetRow, "t3_cntrdel");

	} else if (targetSheet == 4) {
		CheckYN = sheetObjects[3].GetCellValue(targetRow, "t4_cntrdel");
	}
	return CheckYN;
}

function settingValue(cntrno, tpszno, targetSheet, targetRow) {
	if (targetSheet == 1) {
		if (cntrno == "" && tpszno == "") {
			sheetObjects[0].SetCellValue(targetRow, "t1_cntrdel", "Y", 0);
			cntrno = "xxx";
			tpszno = "xxx";
		} else {
			sheetObjects[0].SetCellValue(targetRow, "t1_cntrdel", "", 0);
		}
		sheetObjects[0].SetCellValue(targetRow, "t1_cntrno", cntrno);
		sheetObjects[0].SetCellValue(targetRow, "t1_tpszno", tpszno);

	} else if (targetSheet == 2) {
		if (cntrno == "" && tpszno == "") {
			sheetObjects[1].SetCellValue(targetRow, "t2_cntrdel", "Y", 0);
			cntrno = "xxx";
			tpszno = "xxx";
		} else {
			sheetObjects[1].SetCellValue(targetRow, "t2_cntrdel", "", 0);
		}

		sheetObjects[1].SetCellValue(targetRow, "t2_cntrno", cntrno);
		sheetObjects[1].SetCellValue(targetRow, "t2_tpszno", tpszno);

	} else if (targetSheet == 3) {
		if (cntrno == "" && tpszno == "") {
			sheetObjects[2].SetCellValue(targetRow, "t3_cntrdel", "Y", 0);
			cntrno = "xxx";
			tpszno = "xxx";
		} else {
			sheetObjects[2].SetCellValue(targetRow, "t3_cntrdel", "", 0);
		}
		sheetObjects[2].SetCellValue(targetRow, "t3_cntrno", cntrno);
		sheetObjects[2].SetCellValue(targetRow, "t3_tpszno", tpszno);

	} else if (targetSheet == 4) {
		if (cntrno == "" && tpszno == "") {
			sheetObjects[3].SetCellValue(targetRow, "t4_cntrdel", "Y", 0);
			cntrno = "xxx";
			tpszno = "xxx";
		} else {
			sheetObjects[3].SetCellValue(targetRow, "t4_cntrdel", "", 0);
		}

		sheetObjects[3].SetCellValue(targetRow, "t4_cntrno", cntrno);
		sheetObjects[3].SetCellValue(targetRow, "t4_tpszno", tpszno);

	}
}

function settingValue_split(cntr_no, cntr_type, cntr_status, targetRow) {
	sheetObjects[0].SetCellValue(targetRow, "t1_cntrno", cntr_no);
	sheetObjects[0].SetCellValue(targetRow, "t1_tpszno", cntr_type);
	sheetObjects[0].SetCellValue(targetRow, "t1_cntrstatus", cntr_status);
	// ComShowMessage("here 1" );
	doActionIBSheet_3(sheetObjects[0], document.form, IBSAVE);
}

/*
 * Fcst Inventory popup ( 112 )
 */
function openFcstInvWindow() {
	window.showModelessDialog('EES_EQR_0112.do?type=2', window,
			"scroll:no;status:no;help:no;dialogWidth:800px;dialogHeight:640px");
}

/*
 * IRG popup ( PRD )
 */
function openIrgWindow() {
	var from_loc = document.form.fromLocation.value;
	var to_loc = document.form.toLocation.value;
	var url = "ESD_PRD_0055_POP.do?mainPage=false&f_cmd=-1&i_org_cd=" + from_loc + "&i_dest_cd=&pop_mode=Y"
			+ to_loc;
	var styleInfo = "dialogLeft:0px; dialogTop:0px; dialogWidth:1020px; dialogHeight:765x; scroll:no;";
	
	ComOpenWindowCenter(url, "ESD_PRD_0055", 1350, 650, false, "yes");
}

/*
 * Vsl Residual Capa popup ( 113 )
 */
function openVslResWindow() {
	ComOpenWindowCenter('EES_EQR_0113.do', 'EesEqr0113', '800', '600', true);
	// window.showModelessDialog('EES_EQR_0113.do', window,
	// "scroll:no;status:no;help:no;dialogWidth:800px;dialogHeight:600px");
}

/*
 * Combined popup ( 108 )
 */
function openCombinedWindow(sheetObj, formObj, tab) {
	var repo_pln_id = repoword + document.form.yyyyww.value + repoweek
			+ document.form.seq.value;
	if (document.form.yyyyww.value == "" || document.form.seq.value == "") {
		ComShowCodeMessage("EQR90001", "Repo Pln ID");
		// return false;
	} else if (sheetObj.RowCount() == 0) {
		ComShowCodeMessage("EQR90051");
	} else {
		var selRow = sheetObj.GetSelectRow(); // selected ROW
		var colName = null;
		var colName1 = null;
		var colName2 = null;
		var sourceWeek = sheetObj.GetCellValue(selRow, "t" + tab + "_pln_yrwk");
		var repoPlnWeek = "";
		var repoPlnNextWeek = "";
		if (tab == 1) {
			colName = "t1_sortnum";
			colName1 = "t1_num";
			colName2 = "t1_past_repo_pln_flg";
			repoPlnWeek = formObj.t1_plnWeek.value;
			repoPlnNextWeek = formObj.t1_plnNextWeek.value;
		} else {
			colName = "t2_sortnum";
			colName1 = "t2_num";
			colName2 = "t2_past_repo_pln_flg";
			repoPlnWeek = formObj.t2_plnWeek.value;
			repoPlnNextWeek = formObj.t2_plnNextWeek.value;
		}
		if (sheetObj.GetCellValue(selRow, colName) == "1"
				&& sheetObj.GetCellValue(selRow, colName1) == "1"
				&& sourceWeek != ""
				&& ((tab == 1 && sheetObj.GetCellValue(selRow, colName2) != 'Y') || (tab == 2 && sheetObj
						.GetCellValue(selRow, colName2) != 'Y'))) {

			if (consTpszArr.length < allTpszCnt) {
				ComShowCodeMessage("EQR90045", "Combined Exec.", "ALL");
				return false;
			}

			// 2014.10.14 Park Young Jin
			if (tab == 1) {
				if ((sheetObj.GetCellValue(selRow, 't1_fm_chk_flg') != "Y")) {
					// ComShowCodeMessage("EQR90244",sheetObj.GetCellValue(selRow,
					// 't1_fm_yd_cd'));
					// return false;
				}
			} else {
				if ((sheetObj.GetCellValue(selRow, 't2_fm_chk_flg') != "Y")) {
					// ComShowCodeMessage("EQR90239",sheetObj.GetCellValue(selRow,
					// 't2_fm_yd_cd'));
					// return false;
				}
			}

			// in case of repo plan id, +1,+2 week, executable
			if (sourceWeek == repoPlnWeek || sourceWeek == repoPlnNextWeek) {
				// checking user athority
				if (!userAreaCheck(sheetObj, "Combined Execution", "from", tab,
						selRow)) {
					// return false;
				}
				var week = sheetObj.GetCellValue(selRow, "t" + tab
						+ "_pln_yrwk");
				var fromecc = sheetObj.GetCellValue(selRow, "t" + tab
						+ "_fm_yd_cd");
				var toecc = sheetObj.GetCellValue(selRow, "t" + tab
						+ "_to_yd_cd");
				var etd = sheetObj.GetCellValue(selRow, "t" + tab
						+ "_fm_etd_dt");
				var eta = sheetObj.GetCellValue(selRow, "t" + tab
						+ "_to_eta_dt");
				var trspmode = sheetObj.GetCellValue(selRow, "t" + tab
						+ "_trsp_mod_cd");
				var vvd = sheetObj.GetCellValue(selRow, "t" + tab + "_vvd");
				var lane = sheetObj.GetCellValue(selRow, "t" + tab
						+ "_vsl_lane_cd");
				var pastplan = sheetObj.GetCellValue(selRow, "t" + tab
						+ "_past_repo_pln_flg");
				// 키값 modifying으로 인해 PLN_SEQ 추가 ADDED BY 090902
				var pln_seq = sheetObj.GetCellValue(selRow, "t" + tab
						+ "_pln_seq");
				var week_fromdate = sheetObj.GetCellValue(selRow,
						"t2_week_fromdate");
				var week_todate = sheetObj.GetCellValue(selRow,
						"t2_week_todate");
				var week_maxdate = sheetObj.GetCellValue(selRow,
						"t2_week_maxdate");
				var unit_cost = "0";
				var from_cost = "0";
				var to_cost = "0";
				
				var sRow = sheetObj.FindStatusRow("I|U");
				var arRow = sRow.split(";");
				var cntr_all = "";
				if (sRow != "" && sRow != null) {
					// for(var i=0; i<arRow.length-1; i++) {
					for ( var i = 0; i < arRow.length; i++) {
						if (sheetObj.GetCellValue(selRow, "t" + tab
								+ "_pln_yrwk") == sheetObj.GetCellValue(
								arRow[i], "t" + tab + "_pln_yrwk")
								&& sheetObj.GetCellValue(selRow, "t" + tab
										+ "_trsp_mod_cd") == sheetObj
										.GetCellValue(arRow[i], "t" + tab
												+ "_trsp_mod_cd")
								&& sheetObj.GetCellValue(selRow, "t" + tab
										+ "_to_ecc") == sheetObj.GetCellValue(
										arRow[i], "t" + tab + "_to_ecc")
								&& sheetObj.GetCellValue(selRow, "t" + tab
										+ "_fm_ecc") == sheetObj.GetCellValue(
										arRow[i], "t" + tab + "_fm_ecc")) {
							cntr_all = cntr_all
									+ sheetObj.GetCellValue(arRow[i], "t" + tab
											+ "_cntrno") + ",";
						}
					}
				}
				document.form.cntrno_all.value = cntr_all;
				var url = "EES_EQR_0108.do?repo_pln_id=" + repo_pln_id
						+ "&tab=" + tab + "&week=" + week + "&fromecc="
						+ fromecc + "&toecc=" + toecc + "&etd=" + etd + "&eta="
						+ eta + "&week_fromdate=" + week_fromdate
						+ "&week_todate=" + week_todate + "&week_maxdate="
						+ week_maxdate + "&trspmode=" + trspmode + "&vvd="
						+ vvd + "&lane=" + lane + "&pastplan=" + pastplan
						+ "&scnr_id=" + document.form.scnr_id.value
						+ "&unit_cost=" + unit_cost + "&from_cost=" + from_cost
						+ "&to_cost=" + to_cost + "&pln_seq=" + pln_seq;
				// window.showModelessDialog(url, window,
				// "scroll:no;status:no;help:no;dialogWidth:800px;dialogHeight:440px");
				// ComOpenWindow(url ,null,
				// "scroll:no;status:no;help:no;dialogWidth:800px;dialogHeight:440px"
				// , true);
				ComOpenWindowCenter(url, "EES_EQR_0108", 800, 440, true);
				// window.open("EES_EQR_108.do?repo_pln_id="+repo_pln_id+"&tab="+tab,
				// "combine",
				// "scroll:no;status:no;help:no;dialogWidth:800px;dialogHeight:440px");
			} else {
				ComShowCodeMessage("EQR90151", "Combined Exec", repoPlnWeek,
						repoPlnNextWeek);
			}
		} else {
			ComShowCodeMessage("EQR90052");
		}
	}
}

// messageing after saving
function t1sheet1_OnSaveEnd(sheetObj, errMsg) {
	if (errMsg == '')
		ComShowCodeMessage("EQR90106");
		if (document.form.position_row1.value != 1) {
			var row = eval(document.form.position_row1.value) + eval(8);
			sheetObj.SelectCell(row, "t1_pln_yrwk");
			sheetObj.SelectCell(document.form.position_row1.value, "t1_pln_yrwk");
			// color modifying
			//sheetObj.SetRowBackColor(document.form.position_row1.value, "#F7FB59");
			// sheetObj.CellBackColor(row, 't1_check') = "#F7FB59";
			// sheetObj.CellBackColor(row, 't1_ibflag') = "#F7FB59";
		}
		
		var formObj = document.form; 
		formObj.f_cmd.value=SEARCHLIST10;
		var sXml= sheetObj.GetSearchData("EES_EQR_0012GS.do", FormQueryString(formObj));
		
		var strDataYN=ComGetEtcData(sXml, "dataYN");
		if(strDataYN == "Y") {
			ComBtnDisable("btn_create");
	        ComBtnDisable("btn_delete");
		}else{
			ComBtnDisable("btn_create");
	        ComBtnEnable("btn_delete");
		}
		
		var totalRow = sheetObj.RowCount();
		
		for (i = 2; i <= totalRow; i++) {
			if (sheetObj.GetCellValue(i,"t1_repo_mty_bkg_flg") == "" && sheetObj.GetCellValue(i,"t1_div") != "Plan" && sheetObj.GetCellValue(i,"t1_vvd") != "") {
				sheetObj.SetCellEditable(i, 't1_to_yd_cd', 1);
				sheetObj.SetCellEditable(i, 't1_to_eta_dt', 1);
			}
		}
		// initializing
		document.form.position_row1.value = 1;
		var formObject = document.form;
		//doActionIBSheet(sheetObj, formObject, IBSEARCH);
}

// messageing after saving
function t2sheet1_OnSaveEnd(sheetObj, errMsg) {
	if (errMsg == '')
		ComShowCodeMessage("EQR90106");
		if (document.form.so_action.value.toUpperCase() == "SEND") {
			if (tab2ArrSoAlert.indexOf("N") > 0) {
			} else {
				if (ComShowConfirm(ComGetMsg("EQR90172"))) { // confirm("TRS 화면으로
																// 가시겠습니까?")
					//location.href = "ESD_TRS_0012.do?pgmNo=ESD_TRS_0012"; // URL
																			// modifying되면서
																			// f_cmd=-1
																			// 파라메타
																			// modifying됨
					ComOpenWindowCenter("ESD_TRS_0012.do?pgmNo=ESD_TRS_0012&refNo="+sendToRefNo
							,"ESD_TRS_0012", 1380, 650, false, 'yes');				
				}
			}
			document.form.so_action.value = "";
		}
		if (document.form.position_row2.value != 1) {
			var row = eval(document.form.position_row2.value) + eval(8);
			sheetObj.SelectCell(row, "t2_pln_yrwk");
			sheetObj.SelectCell(document.form.position_row2.value, "t2_pln_yrwk");
			// color modifying
			//sheetObj.SetRowBackColor(document.form.position_row2.value, "#F7FB59");
			// sheetObj.CellBackColor(row, 't1_check') = "#FF0000";
			// sheetObj.CellBackColor(row, 't1_ibflag') = "#FF0000";
		}
		// initializing
		document.form.position_row2.value = 1;
		
		var formObj = document.form; 
		formObj.f_cmd.value=SEARCHLIST10;
		var sXml= sheetObj.GetSearchData("EES_EQR_0012GS.do", FormQueryString(formObj));
		
		var strDataYN=ComGetEtcData(sXml, "dataYN");
		if(strDataYN == "Y") {
			ComBtnDisable("btn_create");
	        ComBtnDisable("btn_delete");
		}else{
			ComBtnDisable("btn_create");
	        ComBtnEnable("btn_delete");
		}
	
		var formObject = document.form;
		//doActionIBSheet2(sheetObj, formObject, IBSEARCH);
}

// messageing after saving
function t3sheet1_OnSaveEnd(sheetObj, errMsg) {
	if (errMsg == '')
		ComShowCodeMessage("EQR90106");
		if (document.form.so_action.value.toUpperCase() == "SEND") {
			if (ComShowConfirm(ComGetMsg("EQR90172"))) {
				//location.href = "ESD_TRS_0012.do?pgmNo=ESD_TRS_0012";
				ComOpenWindowCenter("ESD_TRS_0012.do?pgmNo=ESD_TRS_0012&refNo="+sendToRefNo
						,"ESD_TRS_0012", 1380, 650, false, 'yes');
			}
			document.form.so_action.value = "";
		}
		if (document.form.position_row3.value != 1) {
			var row = eval(document.form.position_row3.value) + eval(8);
			sheetObj.SelectCell(row, "t3_pln_yrwk");
			sheetObj.SelectCell(document.form.position_row3.value, "t3_pln_yrwk");
			// color modifying
			//sheetObj.SetRowBackColor(document.form.position_row3.value, "#F7FB59");
		}
		
		var formObj = document.form; 
		formObj.f_cmd.value=SEARCHLIST10;
		var sXml= sheetObj.GetSearchData("EES_EQR_0012GS.do", FormQueryString(formObj));
		
		var strDataYN=ComGetEtcData(sXml, "dataYN");
		if(strDataYN == "Y") {
			ComBtnDisable("btn_create");
	        ComBtnDisable("btn_delete");
		}else{
			ComBtnDisable("btn_create");
	        ComBtnEnable("btn_delete");
		}
		
		var totalRow = sheetObj.RowCount();			
		for (i = 2; i <= totalRow; i++) {		
			if (sheetObj.GetCellValue(i, "t3_div") == "Execution" && sheetObj.GetCellValue(i, "t3_onf_hir_div_cd") == "F" && sheetObj.GetCellValue(i, "t3_so_iss_flg") != "Y") {
				for ( var j = 0; j < consTpszArr.length; j++) {
					sheetObj.SetCellEditable(i, "t3_vol"+ consTpszArr[j], 1);
				}
			}
			
			if (sheetObj.GetCellValue(i, "t3_div") == "Plan" && sheetObj.GetCellValue(i, "t3_pln_yrwk").length == 6) {
				var strStatus = sheetObj.GetRowStatus(i);
				
				sheetObj.InitCellProperty(i, "t3_fm_loc_dt", {Type:"Text",Format : ""});
				sheetObj.InitCellProperty(i, "t3_to_loc_dt", {Type:"Text",Format : ""});
				sheetObj.SetCellValue(i,"t3_fm_loc_dt",sheetObj.GetCellValue(i, "t3_pln_yrwk"),0);
				sheetObj.SetCellValue(i,"t3_to_loc_dt",sheetObj.GetCellValue(i, "t3_pln_yrwk"),0);
				
				if(errMsg != "0") {
					sheetObj.SetRowStatus(i, "I");
				}else{
					sheetObj.SetRowStatus(i, "R");
				}
				
				
			}
		}
		
	// initializing
	document.form.position_row3.value = 1;
	var formObject = document.form;
	//doActionIBSheet3(sheetObj, formObject, IBSEARCH);
}

// messageing after saving
function t4sheet1_OnSaveEnd(sheetObj, errMsg) {
	if (errMsg == '')
		ComShowCodeMessage("EQR90106");
		if (document.form.so_action.value.toUpperCase() == "SEND") {
			if (tab4ArrSoAlert.indexOf("N") > 0) {
			} else {
				if (ComShowConfirm(ComGetMsg("EQR90172"))) {
					//location.href = "ESD_TRS_0012.do?pgmNo=ESD_TRS_0012";
					ComOpenWindowCenter("ESD_TRS_0012.do?pgmNo=ESD_TRS_0012&refNo="+sendToRefNo
							,"ESD_TRS_0012", 1380, 650, false, 'yes');
				}
			}
			document.form.so_action.value = "";
		}
		if (document.form.position_row4.value != 1) {
			var row = eval(document.form.position_row4.value) + eval(8);
			sheetObj.SelectCell(row, "t4_pln_yrwk");
			sheetObj.SelectCell(document.form.position_row4.value, "t4_pln_yrwk");
			// color modifying
			//sheetObj.SetRowBackColor(document.form.position_row4.value, "#F7FB59");
		}
		
		var formObj = document.form; 
		formObj.f_cmd.value=SEARCHLIST10;
		var sXml= sheetObj.GetSearchData("EES_EQR_0012GS.do", FormQueryString(formObj));
		
		var strDataYN=ComGetEtcData(sXml, "dataYN");
		if(strDataYN == "Y") {
			ComBtnDisable("btn_create");
	        ComBtnDisable("btn_delete");
		}else{
			ComBtnDisable("btn_create");
	        ComBtnEnable("btn_delete");
		}
	// initializing
	document.form.position_row4.value = 1;
	var formObject = document.form;
	
	//doActionIBSheet4(sheetObj, formObject, IBSEARCH);
}

// messageing after saving
function t5sheet1_OnSaveEnd(sheetObj, errMsg) {
	if (errMsg == '')
		ComShowCodeMessage("EQR90106");
}

function checkTapButton() {
	var user_access = document.form.user_access.value;
	var exePlnEditFlg = document.form.exePlnEditFlg.value.toUpperCase();
	var exePlnEditFlg_split = document.form.exePlnEditFlg_split.value
			.toUpperCase();
	var saveFlag = document.form.saveFlag.value.toUpperCase();
	var tabObj = tabObjects[0].selectedIndex;
	var button_flag = "X";
	if (saveFlag == "TRUE") {
		if (user_access == "TRUE") {
			button_flag = "F";
		} else {
			if (exePlnEditFlg == "TRUE") {
				button_flag = "F";
			} else if (exePlnEditFlg_split == "TRUE") {
				button_flag = "S";
			} else {
				button_flag = "X";
			}
		}
	} else { // LEVEL 3,4, 기타
		button_flag = "X";
	}

	if (button_flag == "F") {
		sheetObjects[0].SetEditable(1);
		sheetObjects[1].SetEditable(1);
		sheetObjects[2].SetEditable(1);
		sheetObjects[3].SetEditable(1);
		sheetObjects[4].SetEditable(1);
		ComBtnEnable("btn_save");
		ComBtnEnable("t1btng_rowadd");
		ComBtnEnable("t1btng_split");
		ComBtnEnable("t1btng_repobkg");
		ComBtnEnable("t1btng_combinedexec");
		ComBtnEnable("t2btng_rowadd");
		ComBtnEnable("t2btng_rowadd_plan");
		ComBtnEnable("t2btng_repobkg");
		ComBtnEnable("t2btng_sendtoso");
		ComBtnEnable("t2btng_cancelsoreq");
		ComBtnEnable("t2btng_combinedexec");
		ComBtnEnable("t3btng_rowadd");
		ComBtnEnable("t3btng_rowadd_plan");
		ComBtnEnable("t3btng_sendtoso");
		ComBtnEnable("t3btng_cancelsoreq");
		ComBtnEnable("t4btng_rowadd");
		ComBtnEnable("t4btng_sendtoso");
		ComBtnEnable("t4btng_cancelsoreq");
	} else if (button_flag == "S") {
		sheetObjects[0].SetEditable(0);
		sheetObjects[1].SetEditable(1);
		sheetObjects[2].SetEditable(1);
		sheetObjects[3].SetEditable(1);
		sheetObjects[4].SetEditable(0);
		ComBtnEnable("btn_save");

		// Modify 20150118 -- need to check
		// T.VVD
		/*
		 * ComBtnDisable("t1btng_rowadd"); ComBtnEnable("t1btng_split");
		 * ComBtnDisable("t1btng_repobkg");
		 * ComBtnDisable("t1btng_combinedexec"); // TRUCK & RAIL & WATER
		 * ComBtnEnable("t2btng_rowadd"); ComBtnDisable("t2btng_rowadd_plan");
		 * ComBtnEnable("t2btng_repobkg"); ComBtnEnable("t2btng_sendtoso");
		 * ComBtnEnable("t2btng_cancelsoreq");
		 * ComBtnEnable("t2btng_combinedexec"); // ON-HIRE & OFF-HIRE
		 * ComBtnEnable("t3btng_rowadd"); ComBtnDisable("t3btng_rowadd_plan");
		 * ComBtnEnable("t3btng_sendtoso"); ComBtnEnable("t3btng_cancelsoreq"); //
		 * SHUTTLE ComBtnEnable("t4btng_rowadd");
		 * ComBtnEnable("t4btng_sendtoso"); ComBtnEnable("t4btng_cancelsoreq");
		 */

		ComBtnEnable("t1btng_rowadd");
		ComBtnEnable("t1btng_split");
		ComBtnEnable("t1btng_repobkg");
		ComBtnEnable("t1btng_combinedexec");
		// TRUCK & RAIL & WATER
		ComBtnEnable("t2btng_rowadd");
		ComBtnEnable("t2btng_rowadd_plan");
		ComBtnEnable("t2btng_repobkg");
		ComBtnEnable("t2btng_sendtoso");
		ComBtnEnable("t2btng_cancelsoreq");
		ComBtnEnable("t2btng_combinedexec");
		// ON-HIRE & OFF-HIRE
		ComBtnEnable("t3btng_rowadd");
		ComBtnEnable("t3btng_rowadd_plan");
		ComBtnEnable("t3btng_sendtoso");
		ComBtnEnable("t3btng_cancelsoreq");
		// SHUTTLE
		ComBtnEnable("t4btng_rowadd");
		ComBtnEnable("t4btng_sendtoso");
		ComBtnEnable("t4btng_cancelsoreq");
	} else if (button_flag == "X") {
		sheetObjects[0].SetEditable(0);
		sheetObjects[1].SetEditable(0);
		sheetObjects[2].SetEditable(0);
		sheetObjects[3].SetEditable(0);
		sheetObjects[4].SetEditable(0);
		// Modify 20150118 -- need to check
		/*
		 * ComBtnDisable("btn_save"); ComBtnDisable("t1btng_rowadd");
		 * ComBtnDisable("t1btng_split"); ComBtnDisable("t1btng_repobkg");
		 * ComBtnDisable("t1btng_combinedexec"); ComBtnDisable("t2btng_rowadd");
		 * ComBtnDisable("t2btng_rowadd_plan"); ComBtnDisable("t2btng_repobkg");
		 * ComBtnDisable("t2btng_sendtoso");
		 * ComBtnDisable("t2btng_cancelsoreq");
		 * ComBtnDisable("t2btng_combinedexec"); ComBtnDisable("t3btng_rowadd");
		 * ComBtnDisable("t3btng_rowadd_plan");
		 * ComBtnDisable("t3btng_sendtoso");
		 * ComBtnDisable("t3btng_cancelsoreq"); ComBtnDisable("t4btng_rowadd");
		 * ComBtnDisable("t4btng_sendtoso");
		 * ComBtnDisable("t4btng_cancelsoreq");
		 */

		ComBtnEnable("btn_save");
		ComBtnEnable("t1btng_rowadd");
		ComBtnEnable("t1btng_split");
		ComBtnEnable("t1btng_repobkg");
		ComBtnEnable("t1btng_combinedexec");
		ComBtnEnable("t2btng_rowadd");
		ComBtnEnable("t2btng_rowadd_plan");
		ComBtnEnable("t2btng_repobkg");
		ComBtnEnable("t2btng_sendtoso");
		ComBtnEnable("t2btng_cancelsoreq");
		ComBtnEnable("t2btng_combinedexec");
		ComBtnEnable("t3btng_rowadd");
		ComBtnEnable("t3btng_rowadd_plan");
		ComBtnEnable("t3btng_sendtoso");
		ComBtnEnable("t3btng_cancelsoreq");
		ComBtnEnable("t4btng_rowadd");
		ComBtnEnable("t4btng_sendtoso");
		ComBtnEnable("t4btng_cancelsoreq");
	}

	// Modify 20150118 -- need to check
	if (document.form.nowWeek.value < document.form.yyyyww.value) {
		// row add 비활성
		// ComBtnEnable("t2btng_rowadd_plan");
		// ComBtnEnable("t3btng_rowadd_plan");
	} else {
		// row add 비활성
		// ComBtnDisable("t2btng_rowadd_plan");
		// ComBtnDisable("t3btng_rowadd_plan");
	}

}

function userAreaCheck(sheetObj, action, direction, tab_div, selRow) {
	// Authority Check Remove
	/*
	 * var rccName=null; var lccName=null; var
	 * user_level=document.form.user_level.value; var
	 * user_location=document.form.user_modify_location.value; var
	 * cell_location_rcc=null; var cell_location_lcc=null; var
	 * directionmes=null; if(direction=="from") { rccName="t"+tab_div+"_fm_rcc";
	 * lccName="t"+tab_div+"_fm_lcc"; directionmes="From"; }else {
	 * rccName="t"+tab_div+"_to_rcc"; lccName="t"+tab_div+"_to_lcc";
	 * directionmes="To"; } cell_location_rcc=sheetObj.GetCellValue(selRow,
	 * rccName); cell_location_lcc=sheetObj.GetCellValue(selRow, lccName);
	 * if(tab_div=="2") { // inland(FROM, TO 중 한개만 일치해도 작업 허용) if( (user_level
	 * =="2" && (user_location==sheetObj.GetCellValue(selRow, "t2_fm_rcc") ||
	 * user_location==sheetObj.GetCellValue(selRow, "t2_to_rcc"))) ||
	 * (user_level =="5" && (user_location==sheetObj.GetCellValue(selRow,
	 * "t2_fm_lcc") || user_location==sheetObj.GetCellValue(selRow,
	 * "t2_to_lcc"))) || user_level =="1" ) { return true; }else { if(action !=
	 * "CNTR") { if(user_level=="5") { // You can take a necessary action under
	 * '+msg1+' '+msg2+'('+msg3+'). ' ComShowCodeMessage("EQR90160", "", "LCC",
	 * user_location); }else if(user_level=="2") { // You can take a necessary
	 * action under '+msg1+' '+msg2+'('+msg3+'). '
	 * ComShowCodeMessage("EQR90160", "", "RCC", user_location); } } return
	 * false; } }else { //tab 1, 3, 4 ( VESSEL, ON-OFF, SHUTTLE) if( (user_level
	 * =="2" && user_location == cell_location_rcc) || (user_level =="5" &&
	 * user_location == cell_location_lcc) || user_level =="1" ) { return true;
	 * }else { if(action != "CNTR") { if(user_level=="5") { // You can take a
	 * necessary action under '+msg1+' '+msg2+'('+msg3+'). '
	 * ComShowCodeMessage("EQR90160", directionmes, "LCC", user_location); }else
	 * if(user_level=="2") { // You can take a necessary action under '+msg1+'
	 * '+msg2+'('+msg3+'). ' ComShowCodeMessage("EQR90160", directionmes, "RCC",
	 * user_location); } } return false; } }
	 */

	// 권한 때문에 변경
	return true;
}

function copyLogicControl(sheetObj, row, col) {
	var colName = sheetObj.ColSaveName(col);
	// alert("value : " +sheetObj.CellValue(row, colName));
	sheetObj.SetCellValue(row, colName, "", 0);
}

function checkYardCode_iframe(row, search_ecc, yard_col, ecc_col, yard_code,
		ecc_code) {
	if (yard_code == "") {
		// ComShowMessage("Please input yard code under 'USNYC' ECC.");
		ComShowCodeMessage("EQR90242", search_ecc);
		sheetObjects[3].SetCellValue(row, yard_col, '');// ecc internal yard
														// cell valuemodifying
		sheetObjects[3].SetCellValue(row, ecc_col, '');// ecc internal ecc cell
														// valuemodifying
		sheetObjects[3].SelectCell(row, yard_col);
	} else {
		sheetObjects[3].SetCellValue(row, yard_col, yard_code);// ecc internal
																// yard cell
																// valuemodifying
		sheetObjects[3].SetCellValue(row, ecc_col, ecc_code);// ecc internal
																// ecc cell
																// valuemodifying
	}
	document.form.target = "";
}

function checkVvdExist_iframe(division, row, vvd_col, slan_col, vvd_code,
		slan_code, vsl_dt, vvd_check) {
	if (division == "etd") {
		if (vvd_check == "FALSE") {
			ComShowCodeMessage("EQR90173");
			sheetObjects[1].SetCellValue(row, vvd_col, '');// vvd cell
															// valuemodifying
			sheetObjects[1].SetCellValue(row, slan_col, '');// lane cell
															// valuemodifying
			sheetObjects[1].SelectCell(row, vvd_col);
			sheetObjects[1].SetCellEditable(row, "t2_fm_etd_dt", 1);
		} else {
			if (vvd_code == "" || vvd_code == null) {
				// ComShowMessage("Please input accurate vvd code.");
				ComShowCodeMessage("EQR90001", "accurate vvd code");
				sheetObjects[1].SetCellValue(row, vvd_col, '');// vvd cell
																// valuemodifying
				sheetObjects[1].SetCellValue(row, slan_col, '');// lane cell
																// valuemodifying
				sheetObjects[1].SelectCell(row, vvd_col);
				sheetObjects[1].SetCellEditable(row, "t2_fm_etd_dt", 1);
			} else {
				sheetObjects[1].SetCellValue(row, vvd_col, vvd_code);// vvd
																		// cell
																		// valuemodifying
				sheetObjects[1].SetCellValue(row, slan_col, slan_code);// lane
																		// cell
																		// valuemodifying
				if (vsl_dt == "null" || vsl_dt == "") {
					sheetObjects[1].SetCellValue(row, "t2_fm_etd_dt", "");
					sheetObjects[1].SetCellEditable(row, "t2_fm_etd_dt", 1);
				} else {
					sheetObjects[1].SetCellEditable(row, "t2_fm_etd_dt", 0);
					sheetObjects[1].SetCellValue(row, "t2_fm_etd_dt", vsl_dt);
				}
			}
		}
	} else { // eta retreive
		if (vsl_dt == "" || vsl_dt == "null") {
			sheetObjects[1].SelectCell(row, "t2_to_eta_dt");
			sheetObjects[1].SetCellEditable(row, "t2_to_eta_dt", 1);
		} else {
			sheetObjects[1].SetCellEditable(row, "t2_to_eta_dt", 0);
			sheetObjects[1].SetCellValue(row, "t2_to_eta_dt", vsl_dt);// to_eta_dt
																		// modifying
		}
	}
	document.form.target = "";
}

function toggleSheetSize_059() {
	var obj = ComGetEvent();
	var status = "N";
	if (obj.maxStatus == undefined || obj.maxStatus == "N") {
		status = "M";
	}
	if (status == "M") {
		document.all.searchLayer.style.display = "none";
		t1sheet1.SetSheetHeight(520);
		t2sheet1.SetSheetHeight(520);
		t3sheet1.SetSheetHeight(520);
		t4sheet1.SetSheetHeight(520);
		t5sheet1.SetSheetHeight(520);
		obj.maxStatus = "M";
		obj.className = "btn_down";
	} else {
		document.all.searchLayer.style.display = "inline";
		t1sheet1.SetSheetHeight(297);
		t2sheet1.SetSheetHeight(297);
		t3sheet1.SetSheetHeight(297);
		t4sheet1.SetSheetHeight(297);
		t5sheet1.SetSheetHeight(297);
		obj.maxStatus = "N";
		obj.className = "btn_up";
	}
}

function dataSelectionTvvdDvvd(gubun) {
	var sheetObject = sheetObjects[0];
	var totalRow = sheetObject.RowCount() + 2;
	// ALL
	if (gubun == '1') {
		for (i = 0; i < totalRow; i++) {
			if (sheetObject.GetRowHidden(i)) {
				sheetObject.SetRowHidden(i, 0);
			}
		}
		// Plan
	} else if (gubun == '2') {
		for (i = 0; i < totalRow; i++) {
			if (sheetObject.GetCellValue(i, "t1_div") == "REPO BKG") {
				sheetObject.SetRowHidden(i, 1);
			} else {
				sheetObject.SetRowHidden(i, 0);
			}
		}
		// REPO BKG
	} else if (gubun == '3') {
		for (i = 0; i < totalRow; i++) {
			if (sheetObject.GetCellValue(i, "t1_div") == "Plan  (VD)"
					|| sheetObject.GetCellValue(i, "t1_div") == "Plan") {
				sheetObject.SetRowHidden(i, 1);
			} else {
				sheetObject.SetRowHidden(i, 0);
			} // if
		} // for
		// Execution & W/O issue
	}
}

// TruckRailWater Data Selection
function dataSelectionTrunkRailWater(gubun) {
	var sheetObject = sheetObjects[1];
	var totalRow = sheetObject.RowCount() + 2;
	// ALL
	if (gubun == '1') {
		for (i = 0; i < totalRow; i++) {
			if (sheetObject.GetRowHidden(i)) {
				sheetObject.SetRowHidden(i, 0);
			}
		}
		// Execution
	} else if (gubun == '2') {
		for (i = 0; i < totalRow; i++) {
			if (sheetObject.GetCellValue(i, "t2_div") == "W/O Issue"
					|| sheetObject.GetCellValue(i, "t2_div") == "Plan"
					|| sheetObject.GetCellValue(i, "t2_div") == "Plan  (Fixed)") {
				sheetObject.SetRowHidden(i, 1);
			} else {
				sheetObject.SetRowHidden(i, 0);
			}
		}
		// W/O issue
	} else if (gubun == '3') {
		for (i = 0; i < totalRow; i++) {
			if (sheetObject.GetCellValue(i, "t2_div") == "Execution"
					|| sheetObject.GetCellValue(i, "t2_div") == "Plan"
					|| sheetObject.GetCellValue(i, "t2_div") == "Plan  (Fixed)") {
				sheetObject.SetRowHidden(i, 1);
			} else {
				sheetObject.SetRowHidden(i, 0);
			} // if
		} // for
		// Execution & W/O issue
	} else if (gubun == '4') {
		for (i = 0; i < totalRow; i++) {
			if (sheetObject.GetCellValue(i, "t2_div") == "Plan"
					|| sheetObject.GetCellValue(i, "t2_div") == "Plan  (Fixed)") {
				sheetObject.SetRowHidden(i, 1);
			} else {
				sheetObject.SetRowHidden(i, 0);
			} // if
		} // for
	}
}

// On-Hire,Off-Hire Data Selection
function dataSelectionOnhire_Offhire(gubun) {
	var sheetObject = sheetObjects[2];
	var totalRow = sheetObject.RowCount() + 2;
	// ALL
	if (gubun == '1') {
		for (i = 0; i < totalRow; i++) {
			if (sheetObject.GetRowHidden(i)) {
				sheetObject.SetRowHidden(i, 0);
			}
		}
		// Execution
	} else if (gubun == '2') {
		for (i = 0; i < totalRow; i++) {
			if (sheetObject.GetCellValue(i, "t3_div") == "W/O Issue"
					|| sheetObject.GetCellValue(i, "t3_div") == "Plan") {
				sheetObject.SetRowHidden(i, 1);
			} else {
				sheetObject.SetRowHidden(i, 0);
			}
		}
		// W/O issue
	} else if (gubun == '3') {
		for (i = 0; i < totalRow; i++) {
			if (sheetObject.GetCellValue(i, "t3_div") == "Execution"
					|| sheetObject.GetCellValue(i, "t3_div") == "Plan") {
				sheetObject.SetRowHidden(i, 1);
			} else {
				sheetObject.SetRowHidden(i, 0);
			} // if
		} // for
		// Execution & W/O issue
	} else if (gubun == '4') {
		for (i = 0; i < totalRow; i++) {
			if (sheetObject.GetCellValue(i, "t3_div") == "Plan") {
				sheetObject.SetRowHidden(i, 1);
			} else {
				sheetObject.SetRowHidden(i, 0);
			} // if
		} // for
	}
}
// ECC_Internal DataSelction
function dataSelectionECC_Internal(gubun) {
	var sheetObject = sheetObjects[3];
	var totalRow = sheetObject.RowCount() + 2;
	// ALL
	if (gubun == '1') {
		for (i = 0; i < totalRow; i++) {
			if (sheetObject.GetRowHidden(i)) {
				sheetObject.SetRowHidden(i, 0);
			}
		}
		// Execution
	} else if (gubun == '2') {
		for (i = 0; i < totalRow; i++) {
			if (sheetObject.GetCellValue(i, "t4_div") == "W/O Issue") {
				sheetObject.SetRowHidden(i, 1);
			} else {
				sheetObject.SetRowHidden(i, 0);
			}
		}
		// W/O issue
	} else if (gubun == '3') {
		for (i = 0; i < totalRow; i++) {
			if (sheetObject.GetCellValue(i, "t4_div") == "Execution") {
				sheetObject.SetRowHidden(i, 1);
			} else {
				sheetObject.SetRowHidden(i, 0);
			} // if
		} // for
	}
}
// Total DataSelection
function dataSelection_Total(gubun) {
	var sheetObject = sheetObjects[4];
	var totalRow = sheetObject.RowCount() + 2;
	// ALL
	if (gubun == '1') {
		totalRow = sheetObject.RowCount() + 1;
		for (i = 0; i <= totalRow; i++) {
			if (sheetObject.GetRowHidden(i)) {
				sheetObject.SetRowHidden(i, 0);
			}
		}
		// plan
	} else if (gubun == '2') {
		for (i = 0; i <= totalRow; i++) {
			if (sheetObject.GetCellValue(i, "t5_div") == "Execution"
					|| sheetObject.GetCellValue(i, "t5_div") == "W/O Issue"
					|| sheetObject.GetCellValue(i, "t5_div") == "REPO BKG") {
				sheetObject.SetRowHidden(i, 1);
			} else {
				sheetObject.SetRowHidden(i, 0);
			}
		}
		// Execution
	} else if (gubun == '3') {
		for (i = 0; i <= totalRow; i++) {
			if (sheetObject.GetCellValue(i, "t5_div") == "W/O Issue"
					|| sheetObject.GetCellValue(i, "t5_div") == "Plan"
					|| sheetObject.GetCellValue(i, "t5_div") == "REPO BKG") {
				sheetObject.SetRowHidden(i, 1);
			} else {
				sheetObject.SetRowHidden(i, 0);
			}
		}
		// W/O Issue
	} else if (gubun == '4') {
		for (i = 0; i <= totalRow; i++) {
			if (sheetObject.GetCellValue(i, "t5_div") == "Execution"
					|| sheetObject.GetCellValue(i, "t5_div") == "Plan"
					|| sheetObject.GetCellValue(i, "t5_div") == "REPO BKG") {
				sheetObject.SetRowHidden(i, 1);
			} else {
				sheetObject.SetRowHidden(i, 0);
			} // if
		} // for
		// REPO BKG
	} else if (gubun == '5') {
		for (i = 0; i <= totalRow; i++) {
			if (sheetObject.GetCellValue(i, "t5_div") == "Execution"
					|| sheetObject.GetCellValue(i, "t5_div") == "Plan"
					|| sheetObject.GetCellValue(i, "t5_div") == "W/O Issue") {
				sheetObject.SetRowHidden(i, 1);
			} else {
				sheetObject.SetRowHidden(i, 0);
			} // if
		} // for
		// Execution & W/O Issue & REPO BKG
	} else if (gubun == '6') {
		for (i = 0; i <= totalRow; i++) {
			if (sheetObject.GetCellValue(i, "t5_div") == "Plan") {
				sheetObject.SetRowHidden(i, 1);
			} else {
				sheetObject.SetRowHidden(i, 0);
			}// if
		} // for
	}
}

function t1sheet1_ChangeXml(sXml) {
	var xmlDoc = ComGetXmlDoc(sXml);
	var xmlRoot = xmlDoc.documentElement;
	var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
	if (dataNode == null) {
		return;
	}
	var trDataChildNodes = dataNode.childNodes;
	var rowIndex = 2;
	for ( var i = 0; i < trDataChildNodes.length; i++) {
		if (trDataChildNodes[i] == null) {
			return;
		} else {
			var tdDataChildNodes = trDataChildNodes[i].childNodes;
			if (tdDataChildNodes[2] != null) {
				var dataType = tdDataChildNodes[2].getAttribute("DATA-TYPE");
				if (dataType == "dtCheckBox") {
					t1sheet1.InitCellProperty(rowIndex, "t1_mailfax", {
						Type : "CheckBox"
					});
				}
			}

			if (tdDataChildNodes[16] != null) {
				var dataType = tdDataChildNodes[16].getAttribute("DATA-TYPE");
				var tdValue = t1sheet1.GetCellValue(rowIndex,
						"t1_repo_mty_bkg_flg");
				if (dataType == "dtCheckBox") {
					t1sheet1.InitCellProperty(rowIndex, "t1_repo_mty_bkg_flg",
							{
								Type : "CheckBox"
							});

					if (tdValue == "Y") {
						t1sheet1.SetCellValue(rowIndex, "t1_repo_mty_bkg_flg",
								"1", 0);
						t1sheet1.SetCellValue(rowIndex, "t1_ibflag", "", 0);
					}
				}
			}
		}

		if (trDataChildNodes[i].nodeType == 1) {
			rowIndex++;
		}
	}
}

function t2sheet1_ChangeXml(sXml) {
	var xmlDoc = ComGetXmlDoc(sXml);
	var xmlRoot = xmlDoc.documentElement;
	var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
	if (dataNode == null) {
		return;
	}
	var trDataChildNodes = dataNode.childNodes;
	var rowIndex = 2;
	for ( var i = 0; i < trDataChildNodes.length; i++) {

		if (trDataChildNodes[i] == null) {
			return;
		} else {
			var tdDataChildNodes = trDataChildNodes[i].childNodes;

			if (tdDataChildNodes[15] != null) {
				var dataType = tdDataChildNodes[15].getAttribute("DATA-TYPE");
				var tdValue = t2sheet1.GetCellValue(rowIndex, "t2_so_iss_flg");
				if (dataType == "dtCheckBox") {
					t2sheet1.InitCellProperty(rowIndex, "t2_so_iss_flg", {Type : "CheckBox"});
					if (tdValue == "Y") { 
						t2sheet1.SetCellValue(rowIndex, "t2_so_iss_flg", "1", 0);
						t2sheet1.SetCellValue(rowIndex, "t2_ibflag", "", 0);
					}
				}
			}

			if (tdDataChildNodes[16] != null) {
				var dataType = tdDataChildNodes[16].getAttribute("DATA-TYPE");
				var tdValue = t2sheet1.GetCellValue(rowIndex, "t2_repo_mty_bkg_flg");
				if (dataType == "dtCheckBox") {
					t2sheet1.InitCellProperty(rowIndex, "t2_repo_mty_bkg_flg",{Type : "CheckBox"});
					if (tdValue == "Y") {
						t2sheet1.SetCellValue(rowIndex, "t2_repo_mty_bkg_flg", "1", 0);
						t2sheet1.SetCellValue(rowIndex, "t2_ibflag", "", 0);
					}
				}
			}

		}

		if (trDataChildNodes[i].nodeType == 1) {
			rowIndex++;
		}
	}
}

function t3sheet1_ChangeXml(sXml) {
	var xmlDoc = ComGetXmlDoc(sXml);
	var xmlRoot = xmlDoc.documentElement;
	var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
	if (dataNode == null) {
		return;
	}
	var trDataChildNodes = dataNode.childNodes;
	var rowIndex = 2;
	for ( var i = 0; i < trDataChildNodes.length; i++) {
		if (trDataChildNodes[i] == null) {
			return;
		} else {
			var tdDataChildNodes = trDataChildNodes[i].childNodes;

			if (tdDataChildNodes[14] != null) {
				var dataType = tdDataChildNodes[14].getAttribute("DATA-TYPE");
				var tdValue = t3sheet1.GetCellValue(rowIndex, "t3_so_iss_flg");
				var tdValue1 = t3sheet1.GetCellValue(rowIndex,
						"t3_noso_iss_flg");

				if (dataType == "dtCheckBox") {
					t3sheet1.InitCellProperty(rowIndex, "t3_so_iss_flg", {
						Type : "CheckBox"
					});
					t3sheet1.InitCellProperty(rowIndex, "t3_noso_iss_flg", {
						Type : "CheckBox"
					});
					if (tdValue == "Y") {
						t3sheet1
								.SetCellValue(rowIndex, "t3_so_iss_flg", "1", 0);
						t3sheet1.SetCellValue(rowIndex, "t3_ibflag", "", 0);
					}

					if (tdValue1 == "Y") {
						t3sheet1.SetCellValue(rowIndex, "t3_noso_iss_flg", "1",
								0);
						t3sheet1.SetCellValue(rowIndex, "t3_ibflag", "", 0);
					}
				}
			}

			if (tdDataChildNodes[15] != null) {
				var dataType = tdDataChildNodes[15].getAttribute("DATA-TYPE");
				if (dataType == "dtCheckBox") {
					t3sheet1.InitCellProperty(rowIndex, "t3_noso_iss_flg", {
						Type : "CheckBox"
					});
				}
			}
		}

		if (trDataChildNodes[i].nodeType == 1) {
			rowIndex++;
		}
	}
}

function t4sheet1_ChangeXml(sXml) {
	var xmlDoc = ComGetXmlDoc(sXml);
	var xmlRoot = xmlDoc.documentElement;
	var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
	if (dataNode == null) {
		return;
	}
	var trDataChildNodes = dataNode.childNodes;
	var rowIndex = 2;
	for ( var i = 0; i < trDataChildNodes.length; i++) {
		if (trDataChildNodes[i] == null) {
			return;
		} else {
			var tdDataChildNodes = trDataChildNodes[i].childNodes;

			if (tdDataChildNodes[13] != null) {
				var dataType = tdDataChildNodes[13].getAttribute("DATA-TYPE");
				var tdValue = t4sheet1.GetCellValue(rowIndex, "t4_so_iss_flg");
				if (dataType == "dtCheckBox") {
					t4sheet1.InitCellProperty(rowIndex, "t4_so_iss_flg", {
						Type : "CheckBox"
					});
					if (tdValue == "Y") {
						t4sheet1.SetCellValue(rowIndex, "t4_so_iss_flg", "1");
						t4sheet1.SetCellValue(rowIndex, "t4_ibflag", "");

					}
				}
			}
		}

		if (trDataChildNodes[i].nodeType == 1) {
			rowIndex++;
		}
	}
}

function t5sheet1_ChangeXml(sXml) {
	var xmlDoc = ComGetXmlDoc(sXml);
	var xmlRoot = xmlDoc.documentElement;
	var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
	if (dataNode == null) {
		return;
	}
	var trDataChildNodes = dataNode.childNodes;
	var rowIndex = 2;
	for ( var i = 0; i < trDataChildNodes.length; i++) {
		if (trDataChildNodes[i] == null) {
			return;
		} else {
			var tdDataChildNodes = trDataChildNodes[i].childNodes;

			if (tdDataChildNodes[11] != null) {
				var dataType = tdDataChildNodes[11].getAttribute("DATA-TYPE");
				var tdValue = t5sheet1.GetCellValue(rowIndex, 11);
				if (dataType == "dtCheckBox") {
					t5sheet1.InitCellProperty(rowIndex, 11, {
						Type : "CheckBox"
					});
					if (tdValue == "Y") {
						t5sheet1.SetCellValue(rowIndex, 11, "1", 0);
					}
				}
			}

			if (tdDataChildNodes[12] != null) {
				var dataType = tdDataChildNodes[12].getAttribute("DATA-TYPE");
				var tdValue = t5sheet1.GetCellValue(rowIndex, 12);
				if (dataType == "dtCheckBox") {
					t5sheet1.InitCellProperty(rowIndex, 12, {
						Type : "CheckBox"
					});
					if (tdValue == "Y") {
						t5sheet1.SetCellValue(rowIndex, 12, "1", 0);
					}
				}
			}
		}

		if (trDataChildNodes[i].nodeType == 1) {
			rowIndex++;
		}
	}
}

function t1sheet1_OnLoadFinish(sheetObj) {
	// var contents = "";
	// progressPop.innerHTML = contents;
	// document.all.progressPop.style.display = "none";
	sheetObjects[0].SetWaitImageVisible(1);
	var newDate = new Date();
	var stryy = newDate.getFullYear();
	var strmm = newDate.getMonth() + 1;
	var strdd = newDate.getDate();
	if (strmm < 10)
		strmm = "0" + strmm;
	if (strdd < 10)
		strdd = "0" + strdd;

	var strNowDay = "" + stryy + strmm + strdd;
	var formObject = document.form;
	
	formObject.f_cmd.value = SEARCH04;
	var sheetObj = sheetObjects[0];
	var sXml = sheetObj.GetSearchData("EES_EQR_0059GS4.do",
			FormQueryString(formObject) + "&nowdate=" + strNowDay);

	var strNowWeek = ComGetEtcData(sXml, "strNowWeek");
	formObject.nowWeek.value = strNowWeek; // 로딩시 현재 주 조회
	formObject.nowDay.value = strNowDay; // 로딩시 현재 주 조회

}

/**
 * Progress Pop-Up of Pre-checking
 */
function showProgressPop(sheetObj, formObj) {
	var layerWidth = 249;
	var layerHeight = 350;
	var sheetHeight = sheetObj.GetSheetHeight(14) + 60;
	var pX = (document.body.clientWidth - layerWidth) / 2
			+ document.body.scrollLeft;
	var pY = ((document.body.clientHeight + sheetHeight) - layerHeight) / 2
			+ document.body.scrollTop + 10;
	if (pY < 320) {
		pY = 320;
	}
	var layerUrl = "";
	var contents = "";
	contents = contents
			+ "<div id=\"popWindow\" style=\"left:"
			+ pX
			+ "px; top:"
			+ pY
			+ "px; width:"
			+ layerWidth
			+ "px;height:"
			+ layerHeight
			+ "px;position:absolute;cursor:move ; border:0px solid #9999c1; z-index:1;visibility:visible\">";
	contents = contents
			+ "<table class=\"popup\" width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">";
	contents = contents + "	<tr>";
	contents = contents + "		<td>";
	contents = contents
			+ "			<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">";
	contents = contents + "				<tr>";
	contents = contents
			+ "					<td><img name=\"progressBar\" src=\"/opuscntr/img/waiting.gif\" width=\"249\" height=\"76\" border=\"0\" align=\"absmiddle\"></td>";
	contents = contents + "				</tr>";
	contents = contents + "			</table>";
	contents = contents + "		</td>";
	contents = contents + "	</tr>";
	contents = contents + "</table>";
	contents = contents + "</div>";
	progressPop.innerHTML = contents;
	// window.document.body.style.cursor = "wait";
}

function changeViewComboChange(sheetObj, sXml) {
	var xmlDoc = ComGetXmlDoc(sXml);
	var xmlRoot = xmlDoc.documentElement;
	var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);

	if (dataNode == null) {
		return;
	}

	var trDataChildNodes = dataNode.childNodes;

	for ( var i = 0; i < trDataChildNodes.length; i++) {
		if (trDataChildNodes[i] == null) {
			return;
		} else {
			if (trDataChildNodes[i].nodeName == "TR") {
				var tdDataChildNodes = trDataChildNodes[i].childNodes;
				var targetRow = trDataChildNodes[i].getAttribute("ROW");

				for ( var j = 0; i < tdDataChildNodes.length; j++) {
					if (tdDataChildNodes[j] == null) {
						return;
					} else {
						if (tdDataChildNodes[j].nodeName == "TD") {
							var targetCol = tdDataChildNodes[j]
									.getAttribute("COL");
							var dataType = tdDataChildNodes[j]
									.getAttribute("DATA-TYPE");

							if (targetCol == null || dataType == null) {
								return;
							} else {
								if (dataType == "dtComboEdit") {
									var comboCode = tdDataChildNodes[j]
											.getAttribute("COMBO-CODE");
									var comboText = tdDataChildNodes[j]
											.getAttribute("COMBO-TEXT");

									if (comboText != "") {
										ComboData = "Y";
									} else {
										ComboData = "N";
										sheetObj.InitCellProperty(targetRow,
												"t4_fm_yd_cd", {
													Type : "Text",
													AcceptKeys : "E|N",
													InputCaseSensitive : 1
												});
										sheetObj.InitCellProperty(targetRow,
												"t4_to_yd_cd", {
													Type : "Text",
													AcceptKeys : "E|N",
													InputCaseSensitive : 1
												});
										sheetObj.SetCellValue(targetRow,
												"t4_fm_yd_cd", "");
										sheetObj.SetCellValue(targetRow,
												"t4_to_yd_cd", "");
									}
								}
							}
						}
					}
				}
			}
		}
	}

}


/**
 * function get parameter from popup
 * @param aryPopupData
 * @param Row
 * @param Col
 * @param SheetIdx
 * @return
 */
function setPopupParam(aryPopupData, Row, Col, SheetIdx) {
}



function getPopUp(opener_row, planNum) {
	var formObj = document.form;
	var sheetObj = sheetObjects[1];
	
	
	if (sheetObj.RowCount() > 0) {
		var selRow = planNum; // selected ROW
		var sourceWeek = sheetObj.GetCellValue(selRow, 't2_pln_yrwk');
		var repoPlnWeek = formObj.t2_plnWeek.value;
		var repoPlnNextWeek = formObj.t2_plnNextWeek.value;
		if (sheetObj.GetCellValue(selRow, 't2_sortnum') == 1 && sheetObj.GetCellValue(selRow, 't2_num') == 1 && sheetObj.GetCellValue(selRow, 't2_newplan') != "T"
				&& (sheetObj.GetCellValue(selRow, 't2_past_repo_pln_flg') != 'Y' || (sheetObj
						.GetCellValue(selRow, 't2_past_repo_pln_flg') == 'Y' && sheetObj
						.GetCellValue(selRow, 't2_trsp_mod_cd') == 'W'))) {
			
			if (sourceWeek == repoPlnWeek || sourceWeek == repoPlnNextWeek) {
				if (consTpszArr.length < allTpszCnt) {
					ComShowCodeMessage("EQR90045", "Row Add", "ALL");
					return false;
				}
				
				// checking user athority
				if (!userAreaCheck(sheetObj, "Row Add", "from", 2, selRow)) {
					// return false;
				}

				if ((sheetObj.GetCellValue(selRow, 't2_fm_chk_flg') != "Y")) {
				}

				var Row = "";
				Row = sheetObj.DataInsert(opener_row);
				
				// NORMAL PLAN
				if (sheetObj.GetCellValue(selRow, 't2_past_repo_pln_flg') != 'Y') {
					sheetObj.SetCellValue(Row, 't2_pln_yrwk', sheetObj.GetCellValue(selRow, 't2_pln_yrwk'), 0);// week // copying
					sheetObj.SetCellValue(Row, 't2_week_fromdate', sheetObj.GetCellValue(selRow, 't2_week_fromdate'), 0);// from
					sheetObj.SetCellValue(Row, 't2_week_todate', sheetObj.GetCellValue(selRow, 't2_week_todate'), 0);// to// date
					sheetObj.SetCellValue(Row, 't2_week_maxdate', sheetObj.GetCellValue(selRow, 't2_week_maxdate'), 0);// max
					sheetObj.SetCellValue(Row, 't2_div', "Execution", 0);// REPO
					sheetObj.SetCellValue(Row, 't2_repo_pln_id', sheetObj.GetCellValue(selRow, 't2_repo_pln_id'), 0);// repo_plan_id
					
					if (sheetObj.GetCellValue(selRow, 't2_trsp_mod_cd') != 'W') {
						sheetObj.SetCellEditable(Row, 't2_vsl_lane_cd', 0);
						sheetObj.SetCellEditable(Row, 't2_vvd', 0);
					}
					
					sheetObj.SetCellValue(Row, "t2_fm_yd_cd", sheetObj.GetCellValue(selRow, "t2_fm_ecc"), 0);// from																	
					sheetObj.SetCellValue(Row, "t2_to_yd_cd", sheetObj.GetCellValue(selRow, "t2_to_ecc"), 0);// to
					sheetObj.SetCellValue(Row, 't2_trsp_mod_cd', sheetObj.GetCellValue(selRow, 't2_trsp_mod_cd'), 0);// item
					sheetObj.SetCellValue(Row, 't2_eq_repo_purp_cd', "", 0);// Purpose
					sheetObj.SetCellValue(Row, 't2_repo_pln_fb_rsn_cd', "",0);// Reason resetting
					sheetObj.SetCellValue(Row, "t2_repo_pln_fb_rsn_cd", "",0);// Reason resetting
					sheetObj.SetCellEditable(Row, 't2_repo_pln_fb_rmk', 0);// Reason
					sheetObj.SetCellValue(Row, "t2_cntrimage", "1", 0);// cntr
					// no support[check again]CLT sheetObj.CellValue2(Row,
					// "t2_sortnum")="2"; // REPO BKG Rowsetting
					sheetObj.SetCellValue(Row, "t2_sortnum", "2", 0);// REPOBKGRowsetting
					sheetObj.SetCellValue(Row, "t2_num", "1", 0);// normal
					sheetObj.SetCellValue(Row, "t2_fm_rcc", sheetObj.GetCellValue(selRow, "t2_fm_rcc"), 0);// fm
					sheetObj.SetCellValue(Row, "t2_to_rcc", sheetObj.GetCellValue(selRow, "t2_to_rcc"), 0);// to
					sheetObj.SetCellValue(Row, "t2_fm_lcc", sheetObj.GetCellValue(selRow, "t2_fm_lcc"), 0);// fm
					sheetObj.SetCellValue(Row, "t2_to_lcc", sheetObj.GetCellValue(selRow, "t2_to_lcc"), 0);// to
					sheetObj.SetCellValue(Row, "t2_fm_ecc", sheetObj.GetCellValue(selRow, "t2_fm_ecc"), 0);// fm
					sheetObj.SetCellValue(Row, "t2_to_ecc", sheetObj.GetCellValue(selRow, "t2_to_ecc"), 0);// to
					sheetObj.SetCellValue(Row, "t2_pln_seq", sheetObj.GetCellValue(selRow, "t2_pln_seq"), 0);// pln_seq
					// t2_past_repo_pln_flg copying
					sheetObj.SetCellValue(Row, "t2_past_repo_pln_flg",sheetObj.GetCellValue(selRow,"t2_past_repo_pln_flg"), 0);
					
					sheetObj.SetCellValue(Row, "t2_fm_yd_cd", "", 0);
					sheetObj.SetCellValue(Row, "t2_to_yd_cd", "", 0);
					
					sheetObj.SetCellEditable(Row, "t2_fm_yd_cd", 0);// lease_term
					sheetObj.SetCellEditable(Row, "t2_to_yd_cd", 0);// lease_term
					// Item ='Water'인 경우
					if (sheetObj.GetCellValue(selRow, 't2_trsp_mod_cd') == 'W') {
						/*// ------ FM LOC YARD retreive [START] -----------
						var f_cmd = SEARCH01;
						var vsl = sheetObj.GetCellValue(selRow, "t2_vvd");
						var from_ecc = sheetObj.GetCellValue(selRow,"t2_fm_ecc");
						

						sheetObj.InitCellProperty(Row, "t2_fm_yd_cd", {
							Type : "Combo"
						});
						
						sheetObj.DoRowSearch2(
								"EES_LOCYARDINITIAL_COMMON.do", "row="
										+ Row + "&colname=t2_fm_yd_cd&vsl="
										+ vsl + "&ecc=" + from_ecc
										+ "&item=W&f_cmd=" + f_cmd);

						// ------ FM LOC YARD retreive [END] -----------

						// ------ TO LOC YARD retreive [START] -----------
						var f_cmd = SEARCH01;
						var vsl = sheetObj.GetCellValue(selRow, "t2_vvd");
						var to_ecc = sheetObj.GetCellValue(selRow,"t2_to_ecc");
						
						sheetObj.InitCellProperty(Row, "t2_to_yd_cd", {
							Type : "Combo"
						});
						
						sheetObj.DoRowSearch2(
								"EES_LOCYARDINITIAL_COMMON.do", "row="
										+ Row + "&colname=t2_to_yd_cd&vsl="
										+ vsl + "&ecc=" + to_ecc
										+ "&item=W&f_cmd=" + f_cmd);
						// ------ TO LOC YARD retreive [END] -----------
						sheetObj.SetCellValue(Row, "t2_fm_yd_cd", "", 0);
						sheetObj.SetCellValue(Row, "t2_to_yd_cd", "", 0);*/
						
					} else { // TRUCK, RAIL
						/*var f_cmd = SEARCH15;
						var from_ecc = sheetObj.GetCellValue(selRow,"t2_fm_ecc");
						
						sheetObj.InitCellProperty(Row, "t2_fm_yd_cd", {
							Type : "Combo"
						});
						sheetObj.DoRowSearch2("EES_LOCYARD_COMMON.do",
								"row=" + Row + "&searchword=" + from_ecc
										+ "&colname=t2_fm_yd_cd&f_cmd="
										+ f_cmd);

						var f_cmd = SEARCH15;
						var to_ecc = sheetObj.GetCellValue(selRow,"t2_to_ecc");
						
						sheetObj.InitCellProperty(Row, "t2_to_yd_cd", {
							Type : "Combo"
						});
						sheetObj.DoRowSearch2("EES_LOCYARD_COMMON.do",
								"row=" + Row + "&searchword=" + to_ecc
										+ "&colname=t2_to_yd_cd&f_cmd="
										+ f_cmd);

						sheetObj.SetCellValue(Row, "t2_fm_yd_cd", "", 0);
						sheetObj.SetCellValue(Row, "t2_to_yd_cd", "", 0);*/
					}
					// insert row
					document.form.position_row2.value = Row;
					// FIXED PLAN && TRSP MODE = WATER
				} else if (sheetObj.GetCellValue(selRow,'t2_past_repo_pln_flg') == 'Y' && sheetObj.GetCellValue(selRow, 't2_trsp_mod_cd') == 'W') { // FIXED// PLAN
					
					sheetObj.SetCellValue(Row, 't2_pln_yrwk', sheetObj.GetCellValue(selRow, 't2_pln_yrwk'), 0);// week
					sheetObj.SetCellValue(Row, 't2_week_fromdate', sheetObj.GetCellValue(selRow, 't2_week_fromdate'), 0);// from
					sheetObj.SetCellValue(Row, 't2_week_todate', sheetObj.GetCellValue(selRow, 't2_week_todate'), 0);// to
					sheetObj.SetCellValue(Row, 't2_week_maxdate', sheetObj.GetCellValue(selRow, 't2_week_maxdate'), 0);// max
					sheetObj.SetCellValue(Row, 't2_div', "Execution", 0);// REPO
					sheetObj.SetCellValue(Row, 't2_repo_pln_id', sheetObj.GetCellValue(selRow, 't2_repo_pln_id'), 0);// repo_plan_id
					sheetObj.SetCellValue(Row, "t2_pln_seq", sheetObj.GetCellValue(selRow, "t2_pln_seq"), 0);// pln_seq
					sheetObj.SetCellEditable(Row, 't2_fm_yd_cd', 0);// from
					sheetObj.SetCellEditable(Row, 't2_fm_etd_dt', 0);// from
																		
					// // to eta inserting disable
					sheetObj.SetCellValue(Row, 't2_trsp_mod_cd', sheetObj.GetCellValue(selRow, 't2_trsp_mod_cd'), 0);// item
					sheetObj.SetCellValue(Row, 't2_eq_repo_purp_cd', "", 0);// Purpose
					sheetObj.SetCellValue(Row, 't2_repo_pln_fb_rsn_cd', "",0);// Reason resetting
					sheetObj.SetCellValue(Row, "t2_repo_pln_fb_rsn_cd", "",0);// Reason resetting
					sheetObj.SetCellEditable(Row, 't2_repo_pln_fb_rmk', 0);// Reason
					sheetObj.SetCellValue(Row, "t2_cntrimage", "1", 0);// cntr
																		
					sheetObj.SetCellValue(Row, "t2_sortnum", "2", 0);// REPO
																		
					sheetObj.SetCellValue(Row, "t2_num", "1", 0);// normal
					sheetObj.SetCellValue(Row, "t2_fm_rcc", sheetObj.GetCellValue(selRow, "t2_fm_rcc"), 0);// fm
					sheetObj.SetCellValue(Row, "t2_to_rcc", sheetObj.GetCellValue(selRow, "t2_to_rcc"), 0);// to
					sheetObj.SetCellValue(Row, "t2_fm_lcc", sheetObj.GetCellValue(selRow, "t2_fm_lcc"), 0);// fm
					sheetObj.SetCellValue(Row, "t2_to_lcc", sheetObj.GetCellValue(selRow, "t2_to_lcc"), 0);// to
					sheetObj.SetCellValue(Row, "t2_fm_ecc", sheetObj.GetCellValue(selRow, "t2_fm_ecc"), 0);// fm
					sheetObj.SetCellValue(Row, "t2_to_ecc", sheetObj.GetCellValue(selRow, "t2_to_ecc"), 0);// to
					// t2_past_repo_pln_flg copying
					sheetObj.SetCellValue(Row, "t2_past_repo_pln_flg",sheetObj.GetCellValue(selRow,"t2_past_repo_pln_flg"), 0);
					
					// ------ VVD retreive -----------
					var f_cmd = SEARCH06;
					var fm_ecc = sheetObj.GetCellValue(selRow,"t2_fm_yd_cd");
					var to_ecc = sheetObj.GetCellValue(selRow,"t2_to_yd_cd");
					var eta_week = sheetObj.GetCellValue(selRow,"t2_to_eta_dt");
					
					var sXml = sheetObj.GetSearchData(
							"EES_VVDINLAND_COMMON.do", "row=" + Row
									+ "&colname=t2_vvd&fm_ecc=" + fm_ecc
									+ "&to_ecc=" + to_ecc + "&eta_week="
									+ eta_week + "&f_cmd=" + f_cmd);
					changeViewCombo(sheetObj, sXml);
					sheetObj.SetCellValue(Row, "t2_vvd", "", 0);
					// insert row
					document.form.position_row2.value = Row;
				}


				// 2014.10.14 Park Young Jin
				// sheetObj.CellEditable(Row, 't2_pln_yrwk') = true;
				sheetObj.SetCellEditable(Row, 't2_pln_yrwk', 0);
				sheetObj.SetCellValue(Row, 't2_fm_etd_dt', sheetObj.GetCellValue(selRow, "t2_week_fromdate"));
				sheetObj.SetCellValue(Row, 't2_to_eta_dt', sheetObj.GetCellValue(selRow, "t2_week_maxdate"));
			}
		} else {
			ComShowCodeMessage("EQR90151", "Row Add", repoPlnWeek,
					repoPlnNextWeek);
		}
		
	} else {
		ComShowCodeMessage("EQR90040");

	}
}

function sheet_HgtChange() {
	var minHeight1 = 0;
	var maxHeight1 = 0;	
	var minHeight2 = 0;
	var maxHeight2 = 0;	
	var minHeight3 = 0;
	var maxHeight3 = 0;	
	var minHeight4 = 0;
	var maxHeight4 = 0;	
	var minHeight5 = 0;
	var maxHeight5 = 0;
	
	if(strMinimizeYN == true) {
		maxHeight1 = sheetObjects[0].GetSheetHeight()+200;		
		maxHeight2 = sheetObjects[1].GetSheetHeight()+200;		
		maxHeight3 = sheetObjects[2].GetSheetHeight()+200;		
		maxHeight4 = sheetObjects[3].GetSheetHeight()+200;		
		maxHeight5 = sheetObjects[4].GetSheetHeight()+200;
		
		document.getElementById("searchLayer").style.display = "none";
    	sheetObjects[0].SetSheetHeight(maxHeight1);
    	sheetObjects[1].SetSheetHeight(maxHeight2);
    	sheetObjects[2].SetSheetHeight(maxHeight3);
    	sheetObjects[3].SetSheetHeight(maxHeight4);
    	sheetObjects[4].SetSheetHeight(maxHeight5);
    	
		strMinimizeYN= false;
		document.getElementById("btn_minimize").innerText = "Minimize";
	} else {
		
		minHeight1 = sheetObjects[0].GetSheetHeight()-200;		
		minHeight2 = sheetObjects[1].GetSheetHeight()-200;		
		minHeight3 = sheetObjects[2].GetSheetHeight()-200;		
		minHeight4 = sheetObjects[3].GetSheetHeight()-200;		
		minHeight5 = sheetObjects[4].GetSheetHeight()-200;
		
		document.getElementById("searchLayer").style.display = "Inline";
    	sheetObjects[0].SetSheetHeight(minHeight1);
    	sheetObjects[1].SetSheetHeight(minHeight2);
    	sheetObjects[2].SetSheetHeight(minHeight3);
    	sheetObjects[3].SetSheetHeight(minHeight4);
    	sheetObjects[4].SetSheetHeight(minHeight5);
    	
    	strMinimizeYN= true;
    	document.getElementById("btn_minimize").innerText = "Maximize";    		
	}
}