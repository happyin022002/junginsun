/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName : esm_bkg_0106.js
 *@FileTitle : Break Bulk Cargo Application
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================*/
/****************************************************************************************
   Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
           MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
           Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------These code are for making JSDoc well ------------------*/
/**
 * @fileoverview 
 * @author 
 */
// public variable
var sheetObjects=new Array();
var sheetCnt=0;
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var comboObjects=new Array();
var comboCnt=0; 
var reqFlag="";
var cancelFlg="";
var retFlag="";
var cmdtFlg="";
var messageFlg="";
var chkFlg="";

// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	/***** If sheets are more than 2 in one tab, use additional sheet variables *****/
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	var sheetObject3=sheetObjects[2];
	var sheetObject4=sheetObjects[3];
	var sheetObject5=sheetObjects[4];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if (srcName != "btn_splitPop") {
			if (layList.style.display == "") {
				layList.style.display="none";
			}
		}
		switch (srcName) {
		case "btn_splitPop":
			doActionIBSheet(sheetObject1, formObject, COMMAND04);
			break;
		case "btn_cntr_add":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				cntrAdd();
			}
			break;
		case "btn_cntr_delete":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				cntrDelete();
			}
			break;
		case "btn_cargo_add":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				cargoAdd();
			}
			break;
		case "btn_cargo_delete":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				cargoDelete();
			}
			break;
		case "btn_cmdt":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				ComOpenPopup("ESM_BKG_0653.do?cmdt_cd=" + formObject.cmdt_cd.value, 820, 550, "getCOM_CMDT_POPUP", '1,0,1,1,1,1,1', true, false, 0, 0, 0, "ESM_BKG_0653");
			}
			break;
		case "dg_container_seq":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				var cnt=0;
				for ( var i=2; i <= sheetObjects[2].RowCount()+ 1; i++) {
					if (sheetObjects[2].GetCellValue(i, "ibflag") != "D") {
						cnt++;
					}
				}
				if (cnt == "0") {
					ComShowMessage(ComGetMsg("BKG00624"));
				} else {
					var bkgNo=document.getElementById("bkg_no").value;
					var cntrNo=document.getElementById("temp_cntr_no").value;
					var url="ESM_BKG_0754.do?modalFlg=Y&bkgNo=" + bkgNo + "&cntrNo=" + cntrNo;
					ComOpenWindowCenter(url, "ESM_BKG_0754", 805, 500, true);
				}
			}
			break;
		case "btn_pol_cd":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				var pol_cd=document.getElementById("pol_cd").value;
				if (pol_cd == "") {
				} else {
					ComOpenPopup("VOP_VSK_0509Pop.do?loc_cd=" + pol_cd, 1100, 700, "", '0,0', true);
				}
			}
			break;
		case "btn_pod_cd":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				var pod_cd=document.getElementById("pod_cd").value;
				if (pod_cd == "") {
				} else {
					ComOpenPopup("VOP_VSK_0509Pop.do?loc_cd=" + pod_cd, 1100, 700, "", '0,0', true);
				}
			}
			break;
		case "btn_Copy":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				var url="ESM_BKG_0720.do";
				ComOpenWindowCenter(url, "ESM_BKG_0720", 320, 180, true);
			}
			break;
		case "btn_Remark":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				var url="ESM_BKG_0757.do";
				ComOpenWindowCenter(url, "ESM_BKG_0757", 420, 350, true);
			}
			break;
		case "btn_Retrieve":
			if (document.getElementById("bkg_no").value != "" || document.getElementById("bl_no").value != "") {
				doActionIBSheet(sheetObjects[0], document.form, SEARCH);
			}
			break;
		case "btn_Save":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				var bkgNo=ComGetObjValue(formObject.bkg_no);
				if(!ComIsNull(formObject.old_bkg_no) && ComGetObjValue(formObject.old_bkg_no) != bkgNo){	
					ComShowMessage(ComGetMsg("BKG08356"));
					ComSetFocus(formObject.bkg_no);
    				return;    				
    			}				
				ComOpenWait(true);
				setTimeout( function () {
					messageFlg="save";
					reqFlag="Y";
					retFlag="";
					doActionIBSheet(sheetObjects[0], document.form, MULTI);
					if (retFlag == "Y") {
						doActionIBSheet(sheetObjects[0], document.form, SEARCH);
					}
					ComOpenWait(false);
				} , 100);
			}
			break;
		case "btn_attach_file":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				var bkgNo=ComGetObjValue(formObject.bkg_no);
				if(!ComIsNull(formObject.old_bkg_no) && ComGetObjValue(formObject.old_bkg_no) != bkgNo){	
					ComShowMessage(ComGetMsg("BKG08356"));
					ComSetFocus(formObject.bkg_no);
    				return;    				
    			}
				ComOpenPopup("ESM_BKG_0207.do?bkg_no=" + document.getElementById("bkg_no").value + "&ridr_tp_cd=B", 580, 520, "", "1,0", true);
			}
			break;
		case "btn_Request":
			document.getElementById("button").value="N";
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				var bkgNo=ComGetObjValue(formObject.bkg_no);
				if(!ComIsNull(formObject.old_bkg_no) && ComGetObjValue(formObject.old_bkg_no) != bkgNo){	
					ComShowMessage(ComGetMsg("BKG08356"));
					ComSetFocus(formObject.bkg_no);
    				return;    				
    			}
// move to btnRequestProcess() function
//				chkFlg="N";
//				messageFlg="request";
//				reqFlag="N";
//				retFlag="";
//				var iCnt1=0;
//				var uCnt1=0;
//				var dCnt1=0;
//				var iCnt2=0;
//				var uCnt2=0;
//				var dCnt2=0;
//				var reqCnt=0;
//				for ( var i=2; i <= sheetObjects[2].RowCount()+ 1; i++) {
//					if (sheetObjects[2].GetCellValue(i, "spcl_cgo_apro_cd") != "C") {
//						reqCnt++;
//					}
//				}
//				if (reqCnt < 1) {
//					ComShowMessage(ComGetMsg("BKG08107"));
//					return;
//				}
//				if (sheetObjects[3].GetCellValue(1, "bdr_flg") == "Y" && sheetObjects[3].GetCellValue(1, "corr_no") != "") {
//					ComShowMessage(ComGetMsg("BKG08076"));
//					return;
//				}
//				iCnt1=sheetObjects[1].FindText("ibflag", "I", 0, 2);
//				uCnt1=sheetObjects[1].FindText("ibflag", "U", 0, 2);
//				dCnt1=sheetObjects[1].FindText("ibflag", "D", 0, 2);
//				iCnt2=sheetObjects[2].FindText("ibflag", "I", 0, 2);
//				uCnt2=sheetObjects[2].FindText("ibflag", "U", 0, 2);
//				dCnt2=sheetObjects[2].FindText("ibflag", "D", 0, 2);
//				if (iCnt1 > 0 || uCnt1 > 0 || dCnt1 > 0 || iCnt2 > 0 || uCnt2 > 0 || dCnt2 > 0) {
//					if (sheetObjects[3].GetCellValue(1, "bdr_flg") != "Y" && sheetObjects[3].GetCellValue(1, "corr_no") == "") {
//						//if(ComShowConfirm(ComGetMsg("BKG00824"))){
//						doActionIBSheet(sheetObjects[0], document.form, MULTI);
//						//}else{
//						//	return;
//						//} 					 				
//					}
//					if (sheetObjects[3].GetCellValue(1, "bdr_flg") == "Y" && sheetObjects[3].GetCellValue(1, "corr_no") == "" && sheetObjects[3].GetCellValue(1, "vsl_pre_pst_cd") != "") {
//						ComShowMessage(ComGetMsg("BKG08074"));
//						return;
//					}
//					if (sheetObjects[3].GetCellValue(1, "bdr_flg") == "Y" && sheetObjects[3].GetCellValue(1, "corr_no") == "" && sheetObjects[3].GetCellValue(1, "vsl_pre_pst_cd") == "") {
//						ComShowMessage(ComGetMsg("BKG08075"));
//						return;
//					}
//				}
//				if (chkFlg != "Y") {
//					var rowCnt=0;
//					for ( var i=1; i <= sheetObjects[1].RowCount(); i++) {
//						if (sheetObjects[1].GetCellValue(i, "ibflag") != "D") {
//							rowCnt++;
//						}
//					}
//					document.getElementById("row_cnt").value=rowCnt;
//					var ncCnt=0;
//					var rCnt=0;
//					var yCnt=0;
//					for ( var i=2; i <= sheetObjects[2].RowCount()+ 1; i++) {
//						if (sheetObjects[2].GetCellValue(i, "spcl_cgo_apro_cd") == "P") {
//							ComShowMessage(ComGetMsg("BKG00500"));
//							return;
//						}
//						if (sheetObjects[2].GetCellValue(i, "spcl_cgo_apro_cd") == "N" || sheetObjects[2].GetCellValue(i, "spcl_cgo_apro_cd") == "C") {
//							ncCnt++;
//						}
//						if (sheetObjects[2].GetCellValue(i, "spcl_cgo_apro_cd") == "R") {
//							rCnt++;
//						}
//						if (sheetObjects[2].GetCellValue(i, "spcl_cgo_apro_cd") == "Y") {
//							yCnt++;
//						}
//					}
//					if (ncCnt > 0) {
//						if (ComShowConfirm(ComGetMsg("BKG00521"))) {
//						} else {
//							return;
//						}
//					}
//					if (rCnt > 0) {
//						if (ComShowConfirm(ComGetMsg("BKG00522", document.getElementById("bkg_no").value))) {
//						} else {
//							return;
//						}
//					}
//					if (yCnt > 0) {
//						if (ComShowConfirm(ComGetMsg("BKG00523", document.getElementById("bkg_no").value))) {
//						} else {
//							return;
//						}
//					}
//					for ( var i=2; i <= sheetObjects[2].RowCount()+ 1; i++) {
//						if (sheetObjects[2].GetCellValue(i, "spcl_cgo_apro_cd") != "C") {
//							sheetObjects[2].SetCellValue(i, "apro_cd","R",0);
//						}
//					}
//					doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
//					if (retFlag == "Y") {
//						doActionIBSheet(sheetObjects[0], document.form, SEARCH);
//					}
//				}
				ComOpenWait(true);
				setTimeout( function () {
					btnRequestProcess();
				ComOpenWait(false);
				} , 100);
			}
			break;
		case "btn_RequestCancel":
			document.getElementById("button").value="Y";
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				var bkgNo=ComGetObjValue(formObject.bkg_no);
				if(!ComIsNull(formObject.old_bkg_no) && ComGetObjValue(formObject.old_bkg_no) != bkgNo){	
					ComShowMessage(ComGetMsg("BKG08356"));
					ComSetFocus(formObject.bkg_no);
    				return;    				
    			}
// move to btnRequestCancelProcess() function
//				chkFlg="N";
//				messageFlg="requestCancel";
//				reqFlag="N";
//				retFlag="";
//				var iCnt1=0;
//				var uCnt1=0;
//				var dCnt1=0;
//				var iCnt2=0;
//				var uCnt2=0;
//				var dCnt2=0;
//				if (cancelFlg == "Y") {
//					return;
//				}
//				if (sheetObjects[3].GetCellValue(1, "bdr_flg") == "Y" && sheetObjects[3].GetCellValue(1, "corr_no") != "") {
//					ComShowMessage(ComGetMsg("BKG08076"));
//					return;
//				}
//				iCnt1=sheetObjects[1].FindText("ibflag", "I", 0, 2);
//				uCnt1=sheetObjects[1].FindText("ibflag", "U", 0, 2);
//				dCnt1=sheetObjects[1].FindText("ibflag", "D", 0, 2);
//				iCnt2=sheetObjects[2].FindText("ibflag", "I", 0, 2);
//				uCnt2=sheetObjects[2].FindText("ibflag", "U", 0, 2);
//				dCnt2=sheetObjects[2].FindText("ibflag", "D", 0, 2);
//				if (iCnt1 > 0 || uCnt1 > 0 || dCnt1 > 0 || iCnt2 > 0 || uCnt2 > 0 || dCnt2 > 0) {
//					if (sheetObjects[3].GetCellValue(1, "bdr_flg") != "Y" && sheetObjects[3].GetCellValue(1, "corr_no") == "") {
//						//if(ComShowConfirm(ComGetMsg("BKG00824"))){
//						doActionIBSheet(sheetObjects[0], document.form, MULTI);
//						//}else{
//						//	return;
//						//} 					 				
//					}
//					if (sheetObjects[3].GetCellValue(1, "bdr_flg") == "Y" && sheetObjects[3].GetCellValue(1, "corr_no") == "" && sheetObjects[3].GetCellValue(1, "vsl_pre_pst_cd") != "") {
//						ComShowMessage(ComGetMsg("BKG08074"));
//						return;
//					}
//					if (sheetObjects[3].GetCellValue(1, "bdr_flg") == "Y" && sheetObjects[3].GetCellValue(1, "corr_no") == "" && sheetObjects[3].GetCellValue(1, "vsl_pre_pst_cd") == "") {
//						ComShowMessage(ComGetMsg("BKG08075"));
//						return;
//					}
//				}
//				if (chkFlg != "Y") {
//					if (ComShowConfirm(ComGetMsg("BKG00613", sheetObjects[2].GetCellValue(sheetObjects[2].GetSelectRow(), "Seq")))) {
//						var rowCnt=0;
//						for ( var i=1; i <= sheetObjects[1].RowCount(); i++) {
//							if (sheetObjects[1].GetCellValue(i, "ibflag") != "D") {
//								rowCnt++;
//							}
//						}
//						document.getElementById("row_cnt").value=rowCnt;
//						/*
//						for(var i=2; i<=sheetObjects[2].RowCount()+1; i++){
//if(sheetObjects[2].GetCellValue(i,"spcl_cgo_apro_cd") != "C"){
//								sheetObjects[2].SetCellValue(i,"apro_cd","R",0);
//							}else{
//								sheetObjects[2].SetCellValue(i,"apro_cd","C",0);
//							}
//						}
//						 */
//						sheetObjects[2].SetCellValue(sheetObjects[2].GetSelectRow(), "apro_cd","C",0);
//						//In case of cancel request, don't request
//						doActionIBSheet(sheetObjects[0], document.form, COMMAND02);
//						if (retFlag == "Y") {
//							doActionIBSheet(sheetObjects[0], document.form, SEARCH);
//						}
//					} else {
//						return;
//					}
//				}
				ComOpenWait(true);
				setTimeout( function () {
					btnRequestCancelProcess();
				ComOpenWait(false);
				} , 100);
			}
			break;
		case "btn_approval":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				var bkgNo=ComGetObjValue(formObject.bkg_no);
				if(!ComIsNull(formObject.old_bkg_no) && ComGetObjValue(formObject.old_bkg_no) != bkgNo){	
					ComShowMessage(ComGetMsg("BKG08356"));
					ComSetFocus(formObject.bkg_no);
    				return;    				
    			}
				ComOpenPopup("VOP_SCG_1017.do?scg_flg=BB&bkg_no=" + formObject.bkg_no.value, 1000, 490, "", '0,0', true);
			}
			break;
		case "btn_terminal_information":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				var bkgNo=ComGetObjValue(formObject.bkg_no);
				if(!ComIsNull(formObject.old_bkg_no) && ComGetObjValue(formObject.old_bkg_no) != bkgNo){	
					ComShowMessage(ComGetMsg("BKG08356"));
					ComSetFocus(formObject.bkg_no);
    				return;    				
    			}
				ComOpenPopup("VOP_VSK_0509Pop.do", 1020, 670, "", '0,0', true);
			}
			break;
		}
	} catch (e) {
		if (e == "[object Error]") {
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
	}
	for(var j=0; j<comboObjects.length; j++){
        initCombo(comboObjects[j]);
    }
	rcv_term_cd.SetDropHeight(250);
	rcv_term_cd.SetColWidth(0, "20");
	rcv_term_cd.SetColWidth(1, "80");
	de_term_cd.SetDropHeight(250);
	de_term_cd.SetColWidth(0, "20");
	de_term_cd.SetColWidth(1, "80");
	doActionIBSheet(sheetObjects[5],document.form,INIT);
	if (document.getElementById("bkg_no").value != "" || document.getElementById("bl_no").value != "") {
		doActionIBSheet(sheetObjects[0], document.form, SEARCH);
	}
	//------------------------------------------------>
	//setInquiryDisableButton Event calling
	if (ComGetObjValue(document.form.isInquiry) == "Y") {
		setInquiryDisableButton();
	}
	initControl();
}
function initControl() {
	//Axon Event process1 Event catch(Develoer can change)
	axon_event.addListenerForm('click', 'obj_click', form);
	axon_event.addListenerForm('blur', 'obj_blur', form);
	axon_event.addListenerForm('keyup', 'obj_keyup', form);
	axon_event.addListenerForm('keypress', 'obj_keypress', form);
	axon_event.addListenerForm('change', 'obj_change', form);
	axon_event.addListenerForm('keydown', 'obj_keydown', form);
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form); //- focus in
	applyShortcut();
}
function obj_deactivate() {
	var row=sheetObjects[1].GetSelectRow();
	switch (event.srcElement.name) {
	case "cmdt_cd":
		if (document.getElementById("bkg_no").value != "") {
			if (document.getElementById("cmdt_cd").value.length < 6) {
				var cmdt_cd="";
				var len=6 - Number(document.getElementById("cmdt_cd").value.length);
				cmdt_cd=document.getElementById("cmdt_cd").value;
				for ( var i=1; i <= len; i++) {
					cmdt_cd="0" + cmdt_cd;
				}
				document.getElementById("cmdt_cd").value=cmdt_cd;
				sheetObjects[2].SetCellValue(row, "cmdt_cd",cmdt_cd,0);
			}
			if (cmdtFlg == "") {
				doActionIBSheet(sheetObjects[0], document.form, COMMAND05);
			}
		}
		break;
	}
}
function bkgSplitNoList(split_list) {
	document.form.bkg_no.value=split_list.options[split_list.selectedIndex].value;
	layList.style.display="none";
}
function obj_keyup() {
	var row=sheetObjects[2].GetSelectRow();
	switch (event.srcElement.name) {
	case "cmdt_cd":
		sheetObjects[2].SetCellValue(row, "cmdt_cd",document.getElementById("cmdt_cd").value,0);
		break;
	case "cmdt_nm":
		sheetObjects[2].SetCellValue(row, "cmdt_nm",document.getElementById("cmdt_nm").value,0);
		break;
	case "grav_ctr_desc":
		sheetObjects[2].SetCellValue(row, "grav_ctr_desc",document.getElementById("grav_ctr_desc").value,0);
		break;
	case "pck_dtl_desc":
		sheetObjects[2].SetCellValue(row, "pck_dtl_desc",document.getElementById("pck_dtl_desc").value,0);
		break;
	case "scr_dng_ctnt":
		sheetObjects[2].SetCellValue(row, "scr_dng_ctnt",document.getElementById("scr_dng_ctnt").value,0);
		break;
	case "spcl_rqst_desc":
		sheetObjects[2].SetCellValue(row, "spcl_rqst_desc",document.getElementById("spcl_rqst_desc").value,0);
		break;
	case "bb_dcgo_seq":
		sheetObjects[2].SetCellValue(row, "cntr_cgo_seq",document.getElementById("bb_dcgo_seq").value,0);
		sheetObjects[2].SetCellValue(row, "bb_dcgo_seq",document.getElementById("bb_dcgo_seq").value,0);
		break;
	}
}
function obj_keydown() {
	if (event.keyCode == 13) { // Enter Key 			
		switch (event.srcElement.name) {
		case "bkg_no":
			document.getElementById("bkg_no").value=(document.getElementById("bkg_no").value).toUpperCase();
			doActionIBSheet(sheetObjects[0], document.form, SEARCH);
			break;
		case "bl_no":
			document.getElementById("bl_no").value=(document.getElementById("bl_no").value).toUpperCase();
			doActionIBSheet(sheetObjects[0], document.form, SEARCH);
			break;
		}
	}
}

function btnRequestProcess() {

	chkFlg="N";
	messageFlg="request";
	reqFlag="N";
	retFlag="";
	var iCnt1=0;
	var uCnt1=0;
	var dCnt1=0;
	var iCnt2=0;
	var uCnt2=0;
	var dCnt2=0;
	var reqCnt=0;
	for ( var i=2; i <= sheetObjects[2].RowCount()+ 1; i++) {
		if (sheetObjects[2].GetCellValue(i, "spcl_cgo_apro_cd") != "C") {
			reqCnt++;
		}
	}
	if (reqCnt < 1) {
		ComShowMessage(ComGetMsg("BKG08107"));
		return;
	}
	if (sheetObjects[3].GetCellValue(1, "bdr_flg") == "Y" && sheetObjects[3].GetCellValue(1, "corr_no") != "") {
		ComShowMessage(ComGetMsg("BKG08076"));
		return;
	}
	iCnt1=sheetObjects[1].FindText("ibflag", "I", 0, 2);
	uCnt1=sheetObjects[1].FindText("ibflag", "U", 0, 2);
	dCnt1=sheetObjects[1].FindText("ibflag", "D", 0, 2);
	iCnt2=sheetObjects[2].FindText("ibflag", "I", 0, 2);
	uCnt2=sheetObjects[2].FindText("ibflag", "U", 0, 2);
	dCnt2=sheetObjects[2].FindText("ibflag", "D", 0, 2);
	if (iCnt1 > 0 || uCnt1 > 0 || dCnt1 > 0 || iCnt2 > 0 || uCnt2 > 0 || dCnt2 > 0) {
		if (sheetObjects[3].GetCellValue(1, "bdr_flg") != "Y" && sheetObjects[3].GetCellValue(1, "corr_no") == "") {
			//if(ComShowConfirm(ComGetMsg("BKG00824"))){
			doActionIBSheet(sheetObjects[0], document.form, MULTI);
			//}else{
			//	return;
			//} 					 				
		}
		if (sheetObjects[3].GetCellValue(1, "bdr_flg") == "Y" && sheetObjects[3].GetCellValue(1, "corr_no") == "" && sheetObjects[3].GetCellValue(1, "vsl_pre_pst_cd") != "") {
			ComShowMessage(ComGetMsg("BKG08074"));
			return;
		}
		if (sheetObjects[3].GetCellValue(1, "bdr_flg") == "Y" && sheetObjects[3].GetCellValue(1, "corr_no") == "" && sheetObjects[3].GetCellValue(1, "vsl_pre_pst_cd") == "") {
			ComShowMessage(ComGetMsg("BKG08075"));
			return;
		}
	}
	if (chkFlg != "Y") {
		var rowCnt=0;
		for ( var i=1; i <= sheetObjects[1].RowCount(); i++) {
			if (sheetObjects[1].GetCellValue(i, "ibflag") != "D") {
				rowCnt++;
			}
		}
		document.getElementById("row_cnt").value=rowCnt;
		var ncCnt=0;
		var rCnt=0;
		var yCnt=0;
		for ( var i=2; i <= sheetObjects[2].RowCount()+ 1; i++) {
			if (sheetObjects[2].GetCellValue(i, "spcl_cgo_apro_cd") == "P") {
				ComShowMessage(ComGetMsg("BKG00500"));
				return;
			}
			if (sheetObjects[2].GetCellValue(i, "spcl_cgo_apro_cd") == "N" || sheetObjects[2].GetCellValue(i, "spcl_cgo_apro_cd") == "C") {
				ncCnt++;
			}
			if (sheetObjects[2].GetCellValue(i, "spcl_cgo_apro_cd") == "R") {
				rCnt++;
			}
			if (sheetObjects[2].GetCellValue(i, "spcl_cgo_apro_cd") == "Y") {
				yCnt++;
			}
		}
		if (ncCnt > 0) {
			if (ComShowConfirm(ComGetMsg("BKG00521"))) {
			} else {
				return;
			}
		}
		if (rCnt > 0) {
			if (ComShowConfirm(ComGetMsg("BKG00522", document.getElementById("bkg_no").value))) {
			} else {
				return;
			}
		}
		if (yCnt > 0) {
			if (ComShowConfirm(ComGetMsg("BKG00523", document.getElementById("bkg_no").value))) {
			} else {
				return;
			}
		}
		for ( var i=2; i <= sheetObjects[2].RowCount()+ 1; i++) {
			if (sheetObjects[2].GetCellValue(i, "spcl_cgo_apro_cd") != "C") {
				sheetObjects[2].SetCellValue(i, "apro_cd","R",0);
			}
		}
		doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
		if (retFlag == "Y") {
			doActionIBSheet(sheetObjects[0], document.form, SEARCH);
		}
	}		
}

function btnRequestCancelProcess() {

	chkFlg="N";
	messageFlg="requestCancel";
	reqFlag="N";
	retFlag="";
	var iCnt1=0;
	var uCnt1=0;
	var dCnt1=0;
	var iCnt2=0;
	var uCnt2=0;
	var dCnt2=0;
	if (cancelFlg == "Y") {
		return;
	}
	if (sheetObjects[3].GetCellValue(1, "bdr_flg") == "Y" && sheetObjects[3].GetCellValue(1, "corr_no") != "") {
		ComShowMessage(ComGetMsg("BKG08076"));
		return;
	}
	iCnt1=sheetObjects[1].FindText("ibflag", "I", 0, 2);
	uCnt1=sheetObjects[1].FindText("ibflag", "U", 0, 2);
	dCnt1=sheetObjects[1].FindText("ibflag", "D", 0, 2);
	iCnt2=sheetObjects[2].FindText("ibflag", "I", 0, 2);
	uCnt2=sheetObjects[2].FindText("ibflag", "U", 0, 2);
	dCnt2=sheetObjects[2].FindText("ibflag", "D", 0, 2);
	if (iCnt1 > 0 || uCnt1 > 0 || dCnt1 > 0 || iCnt2 > 0 || uCnt2 > 0 || dCnt2 > 0) {
		if (sheetObjects[3].GetCellValue(1, "bdr_flg") != "Y" && sheetObjects[3].GetCellValue(1, "corr_no") == "") {
			//if(ComShowConfirm(ComGetMsg("BKG00824"))){
			doActionIBSheet(sheetObjects[0], document.form, MULTI);
			//}else{
			//	return;
			//} 					 				
		}
		if (sheetObjects[3].GetCellValue(1, "bdr_flg") == "Y" && sheetObjects[3].GetCellValue(1, "corr_no") == "" && sheetObjects[3].GetCellValue(1, "vsl_pre_pst_cd") != "") {
			ComShowMessage(ComGetMsg("BKG08074"));
			return;
		}
		if (sheetObjects[3].GetCellValue(1, "bdr_flg") == "Y" && sheetObjects[3].GetCellValue(1, "corr_no") == "" && sheetObjects[3].GetCellValue(1, "vsl_pre_pst_cd") == "") {
			ComShowMessage(ComGetMsg("BKG08075"));
			return;
		}
	}
	if (chkFlg != "Y") {
		if (ComShowConfirm(ComGetMsg("BKG00613", sheetObjects[2].GetCellValue(sheetObjects[2].GetSelectRow(), "Seq")))) {
			var rowCnt=0;
			for ( var i=1; i <= sheetObjects[1].RowCount(); i++) {
				if (sheetObjects[1].GetCellValue(i, "ibflag") != "D") {
					rowCnt++;
				}
			}
			document.getElementById("row_cnt").value=rowCnt;

			sheetObjects[2].SetCellValue(sheetObjects[2].GetSelectRow(), "apro_cd","C",0);
			//In case of cancel request, don't request
			doActionIBSheet(sheetObjects[0], document.form, COMMAND02);
			if (retFlag == "Y") {
				doActionIBSheet(sheetObjects[0], document.form, SEARCH);
			}
		} else {
			return;
		}
	}
}

function obj_change() {
	var row=sheetObjects[2].GetSelectRow();
	switch (event.srcElement.name) {
	case "rcv_term_cd":
		sheetObjects[2].SetCellValue(row, "rcv_term_cd",document.getElementById("rcv_term_cd").value,0);
		break;
	case "de_term_cd":
		sheetObjects[2].SetCellValue(row, "de_term_cd",document.getElementById("de_term_cd").value,0);
		break;
	case "slng_pnt_flg":
		sheetObjects[2].SetCellValue(row, "slng_pnt_flg",document.getElementById("slng_pnt_flg").value,0);
		break;
	case "cgo_lodg_mzd_cd":
		sheetObjects[2].SetCellValue(row, "cgo_lodg_mzd_cd",document.getElementById("cgo_lodg_mzd_cd").value,0);
		break;
	case "ovr_void_slt_qty":
		if (document.getElementById("bkg_no").value != "") {
			for ( var i=2; i <= sheetObjects[2].RowCount()+ 1; i++) {
				sheetObjects[2].SetCellValue(i, "modifyaproflg","Y",0);
				//2015.01.14 Insert, Update 구분 처리 로직 수정 bug
				if(sheetObjects[2].GetCellValue(i,"ibflag") == "I"){
					sheetObjects[2].SetCellValue(i, "ibflag","I",0);
				}else{
					sheetObjects[2].SetCellValue(i, "ibflag","U",0);
				}
			}
		}
		break;
	case "cmdt_cd":
		if (document.getElementById("bkg_no").value != "") {
			if (document.getElementById("cmdt_cd").value.length < 6) {
				var cmdt_cd="";
				var len=6 - Number(document.getElementById("cmdt_cd").value.length);
				cmdt_cd=document.getElementById("cmdt_cd").value;
				for ( var i=1; i <= len; i++) {
					cmdt_cd="0" + cmdt_cd;
				}
				document.getElementById("cmdt_cd").value=cmdt_cd;
				sheetObjects[2].SetCellValue(row, "cmdt_cd",cmdt_cd,0);
			}
			if (cmdtFlg == "") {
				doActionIBSheet(sheetObjects[0], document.form, COMMAND05);
			}
		}
		break;	
	}
}
function cntrAdd() {
	document.getElementById("temp_cntr_no").value="";
	var rowCount = Number(sheetObjects[1].RowCount()) - Number(sheetObjects[1].RowCount("D"));
	if (rowCount < sheetObjects[4].RowCount()) {
		var Row=sheetObjects[1].DataInsert(-1);
		var cntr_name="";
		var cntr_val="";
		var rowCnt=0;
		for ( var i=1; i <= sheetObjects[1].RowCount(); i++) {
			if (sheetObjects[1].GetCellValue(i, "ibflag") != "D") {
				rowCnt++;
				sheetObjects[1].SetCellValue(i, "Seq",rowCnt,0);
			}
		}
		for ( var j=1; j <= sheetObjects[4].RowCount(); j++) {
			if (sheetObjects[4].GetCellValue(j, "DelChk") == "0") {
				cntr_name += sheetObjects[4].GetCellValue(j, "name") + "|";
				cntr_val += sheetObjects[4].GetCellValue(j, "val") + "|";
			}
		}
		cntr_val=cntr_val.substr(0, cntr_val.length - 1);
		cntr_name=cntr_name.substr(0, cntr_name.length - 1);
		sheetObjects[1].CellComboItem(Row,"cntr_no", {ComboText:cntr_name, ComboCode:cntr_val} );
	} else {
		ComShowMessage(ComGetMsg("BKG08085"));
	}
}
function cntrDelete() {
	for ( var i=1; i <= sheetObjects[1].RowCount(); i++) {
		if (sheetObjects[1].GetCellValue(i, "DelChk") == "1") {
			var temp_cntr_no=sheetObjects[1].GetCellValue(i, "cntr_no");
			var temp_find_row=sheetObjects[4].FindText("name", temp_cntr_no, 0, 2);
			if (temp_cntr_no != "") {
				sheetObjects[4].SetCellValue(temp_find_row, "DelChk","0");
			}
		}
	}
	var drow=ComRowHideDelete(sheetObjects[1], "DelChk");
	var rowCnt=0;
	for ( var i=1; i <= sheetObjects[1].RowCount(); i++) {
		if (sheetObjects[1].GetCellValue(i, "ibflag") != "D") {
			rowCnt++;
			sheetObjects[1].SetCellValue(i, "Seq",rowCnt,0);
		}
	}
	var cntr_name="";
	var cntr_val="";
	for ( var j=1; j <= sheetObjects[4].RowCount(); j++) {
		if (sheetObjects[4].GetCellValue(j, "DelChk") == "0") {
			cntr_name += sheetObjects[4].GetCellValue(j, "name") + "|";
			cntr_val += sheetObjects[4].GetCellValue(j, "val") + "|";
		}
	}
	cntr_val=cntr_val.substr(0, cntr_val.length - 1);
	cntr_name=cntr_name.substr(0, cntr_name.length - 1);
	var cnt=0;
	for ( var i=1; i <= sheetObjects[1].RowCount(); i++) {
		//sheetObjects[1].CellComboItem(i,"cntr_no", {ComboText:sheetObjects[1].GetCellValue(i, ComboCode:"cntr_no")+"|"+cntr_name, ComboText:sheetObjects[1].GetCellValue(i, ComboCode:"cntr_no")+"|"+cntr_val} );
		//sheetObjects[1].CellComboItem(Row,"cntr_no", {ComboText:cntr_name, ComboCode:cntr_val} );
		sheetObjects[1].CellComboItem(i, "cntr_no", sheetObjects[1].GetCellValue(i, "cntr_no") + "|" + cntr_name, sheetObjects[1].GetCellValue(i, "cntr_no") + "|" + cntr_val);
	}
}
function cargoAdd() {
	var cnt=0;
	if(sheetObjects[2].RowCount() > 0){
		cnt=sheetObjects[2].GetCellValue(2, "bb_cgo_seq");
	}
	if(sheetObjects[2].RowCount() > 0){
		for ( var i=2; i <= sheetObjects[2].RowCount()+ 1; i++) {
			if (cnt < Number(sheetObjects[2].GetCellValue(i, "bb_cgo_seq"))) {
				cnt=Number(sheetObjects[2].GetCellValue(i, "bb_cgo_seq"));
			}
		}
	}
	var Row=sheetObjects[2].DataInsert(-1);
	sheetObjects[2].SetCellValue(Row, "bkg_no",document.getElementById("bkg_no").value,0);
	sheetObjects[2].SetCellValue(Row, "pck_qty","1",0);
	sheetObjects[2].SetCellValue(Row, "bb_cgo_seq",Number(cnt) + 1,0);
	sheetObjects[2].SetCellValue(Row, "rcv_term_cd",sheetObjects[3].GetCellValue(1, "rcv_term_cd"),0);
	sheetObjects[2].SetCellValue(Row, "de_term_cd",sheetObjects[3].GetCellValue(1, "de_term_cd"),0);
	sheetObjects[2].SetCellValue(Row, "slng_pnt_flg","N",0);
	sheetObjects[2].SetCellValue(Row, "cgo_lodg_mzd_cd","",0);
	sheetObjects[2].SetCellValue(Row, "wgt_ut_cd",wgt_ut_cd.GetSelectCode(),0);
	sheetObjects[2].SetCellValue(Row, "cmdt_cd",sheetObjects[3].GetCellValue(1, "cmdt_cd"),0);
	sheetObjects[2].SetCellValue(Row, "cmdt_nm",sheetObjects[3].GetCellValue(1, "cmdt_nm"),0);
	var rowCnt=0;
	for ( var i=2; i <= sheetObjects[2].RowCount()+ 1; i++) {
		if (sheetObjects[2].GetCellValue(i, "ibflag") != "D") {
			rowCnt++;
			sheetObjects[2].SetCellValue(i, "Seq",rowCnt,0);
		}
	}
	htmlSheetSync();
}
function cargoDelete() {
	for ( var i=2; i <= sheetObjects[2].RowCount()+ 1; i++) {
		if (sheetObjects[2].GetCellValue(i, "DelChk") == "1") {
			if (sheetObjects[2].GetCellValue(i, "spcl_cgo_apro_cd") == "P" || sheetObjects[2].GetCellValue(i, "spcl_cgo_apro_cd") == "R" || sheetObjects[2].GetCellValue(i, "spcl_cgo_apro_cd") == "Y" || sheetObjects[2].GetCellValue(i, "spcl_cgo_apro_cd") == "N") {
				ComShowMessage(ComGetMsg("BKG00525"));
				return;
			}
		}
	}
	var drow=ComRowHideDelete(sheetObjects[2], "DelChk");
	var rowCnt=0;
	var rCnt=0;
	for ( var i=2; i <= sheetObjects[2].RowCount()+ 1; i++) {
		if (sheetObjects[2].GetCellValue(i, "ibflag") != "D") {
			rowCnt++;
			rCnt++;
			sheetObjects[2].SetCellValue(i, "Seq",rowCnt,0);
		}
	}
	if (rCnt < 1) {
		document.getElementById("Seq").value="";
		document.getElementById("bb_dcgo_seq").value="";
		document.getElementById("rcv_term_cd").value="";
		document.getElementById("de_term_cd").value="";
		document.getElementById("slng_pnt_flg").value="";
		document.getElementById("grav_ctr_desc").value="";
		document.getElementById("cmdt_cd").value="";
		document.getElementById("cmdt_nm").value="";
		document.getElementById("pck_dtl_desc").value="";
		document.getElementById("cgo_lodg_mzd_cd").value="";
		document.getElementById("scr_dng_ctnt").value="";
		document.getElementById("spcl_rqst_desc").value="";
		document.getElementById("temp_grs_wgt").value="";
		document.getElementById("temp_net_wgt").value="";
		document.getElementById("diff_rmk").value="";
		document.getElementById("aply_no").value="";
		document.getElementById("btn_Remark").style.color="";
	}
}
function copyCnt(copyCnt) {
	var seqVal=0;
	
	for (i=1; i <= copyCnt; i++) {
		if(sheetObjects[2].RowCount() > 0){		//2015.01.23. kimtaekyun. seq=0 처리 되는 오류 수정
			seqVal=Number(sheetObjects[2].GetCellValue(2, "bb_cgo_seq"));
		}else{
			seqVal=0;
		}
		
		for ( var k=2; k <= sheetObjects[2].RowCount()+ 1; k++) {
			if (seqVal < Number(sheetObjects[2].GetCellValue(k, "bb_cgo_seq"))) {
				seqVal=sheetObjects[2].GetCellValue(k, "bb_cgo_seq");
			}
		}
		var selRow=sheetObjects[2].GetSelectRow();
		var Row=sheetObjects[2].DataInsert(-1);
		for ( var ic=0; ic <= sheetObjects[2].LastCol(); ic++) {
			if (sheetObjects[2].ColSaveName(ic) == "ibflag" || sheetObjects[2].ColSaveName(ic) == "seq")
				continue;
			sheetObjects[2].SetCellValue(Row, ic,sheetObjects[2].GetCellValue(selRow, ic),0);
		}
		sheetObjects[2].SetCellValue(Row, "bb_cgo_seq",Number(seqVal) + 1,0);
		sheetObjects[2].SetCellValue(Row, "DelChk","0",0);
		sheetObjects[2].SetCellValue(Row, "spcl_cgo_apro_cd","",0);
	}
	var rowCnt=0;
	for ( var i=2; i <= sheetObjects[2].RowCount()+ 1; i++) {
		if (sheetObjects[2].GetCellValue(i, "ibflag") != "D") {
			rowCnt++;
			sheetObjects[2].SetCellValue(i, "Seq",rowCnt,0);
		}
	}
}
function callbackPckTp(returnVal) {
	sheetObjects[2].SetCellValue(sheetObjects[2].GetSelectRow(), "pck_tp_cd",returnVal.cd);
}
function getCOM_CMDT_POPUP(rowArray) {
	var formObject=document.form;
	var colArray=rowArray[0];
	formObject.cmdt_cd.value=colArray[3];
	sheetObjects[2].SetCellValue(sheetObjects[2].GetSelectRow(), "cmdt_cd",colArray[3],0);
	formObject.cmdt_nm.value=colArray[4];
	sheetObjects[2].SetCellValue(sheetObjects[2].GetSelectRow(), "cmdt_nm",colArray[4],0);
	sheetObjects[2].SetCellValue(sheetObjects[2].GetSelectRow(), "modifyaproflg","Y",0);
}
/**
 * setting sheet initial values and header
 * 
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch (sheetNo) {
	case 1: //sheet1 init
	    with(sheetObj){

      var HeadTitle1="TP/SZ|BKG Q'ty|BB Q'ty";

      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
      InitHeaders(headers, info);

      var cols = [ {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:1,   SaveName:"op_cntr_qty",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
             {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:0,   SaveName:"bb_cgo_qty",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];
       
      InitColumns(cols);

      SetEditable(1);
      SetCountPosition(0);
      SetSheetHeight(82);//82
            }
		break;
	case 2: //sheet2 init
	    with(sheetObj){
        
      var HeadTitle1="|Sel.|Seq|Container List|TS|Vol.|bb_cgo_flg|bkg_no";

      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
      InitHeaders(headers, info);

      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"DelChk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Combo",     Hidden:0, Width:95,   Align:"Left",    ColMerge:1,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Float",     Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"cntr_vol_qty",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bb_cgo_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
       
      InitColumns(cols);

      SetEditable(1);
      SetCountPosition(0);
      SetSheetHeight(122);//122
            }
		break;
	case 3: //sheet3 init
	    with(sheetObj){
        
      var HeadTitle1="||Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information";
      var HeadTitle2="|Sel.|Seq.|Length|Width|Height|Grs Weight|Net Weight|Unit.|PKG|Appr.|bb_dcgo_seq|rcv_term_cd|de_term_cd|cmdt_cd|cmdt_nm|slng_pnt_flg|grav_ctr_desc|pck_dtl_desc|cgo_lodg_mzd_cd|scr_dng_ctnt|spcl_rqst_desc|diff_rmk|modifyaproflg|bkg_no|bb_cgo_seq|pck_qty|por_cd|del_cd|apro_cd";

      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
      var headers = [ { Text:HeadTitle1, Align:"Center"},
                  { Text:HeadTitle2, Align:"Center"} ];
      InitHeaders(headers, info);

      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
             {Type:"CheckBox",  Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"DelChk" },
             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"Seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Int",       Hidden:0,  Width:58,   Align:"Right",   ColMerge:1,   SaveName:"dim_len",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Int",       Hidden:0,  Width:58,   Align:"Right",   ColMerge:1,   SaveName:"dim_wdt",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Int",       Hidden:0,  Width:58,   Align:"Right",   ColMerge:1,   SaveName:"dim_hgt",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Float",     Hidden:0,  Width:87,   Align:"Right",   ColMerge:1,   SaveName:"grs_wgt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 },
             {Type:"Text",      Hidden:1, Width:77,   Align:"Right",   ColMerge:1,   SaveName:"net_wgt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 },
             {Type:"Text",      Hidden:0,  Width:39,   Align:"Left",    ColMerge:0,   SaveName:"wgt_ut_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"PopupEdit", Hidden:0, Width:45,   Align:"Left",    ColMerge:1,   SaveName:"pck_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_apro_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"bb_dcgo_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"rcv_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"de_term_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"cmdt_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"cmdt_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"slng_pnt_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"grav_ctr_desc",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"pck_dtl_desc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"cgo_lodg_mzd_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"scr_dng_ctnt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"spcl_rqst_desc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"diff_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"modifyaproflg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"bb_cgo_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"pck_qty",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"cntr_cgo_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"por_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"del_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"apro_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"aply_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:3,   UpdateEdit:1,   InsertEdit:1 } ];
       
      InitColumns(cols);

      SetEditable(1);
      SetCountPosition(0);
      //conversion of function[check again]CLT 			InitDataValid(0, "pck_tp_cd", vtEngUpOnly, "");
      SetColProperty(0 ,"pck_tp_cd" , {AcceptKeys:"E|[]",InputCaseSensitive:1});
      SetSheetHeight(190);
      }
		break;
	case 4: //sheet1 init
	    with(sheetObj){
        
      var HeadTitle1="bkg_no|bl_no|tvvd|pol_cd|pol_nod_cd|pod_cd|pod_nod_cd|rcv_term_cd|de_term_cd|bkg_sts_cd|corr_n1st_dt|bdr_flg|pck_qty|pck_tp_cd|grs_wgt|wgt_ut_cd|corr_no|ovr_void_slt_qty";

      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:0 } );

      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
      InitHeaders(headers, info);

      var cols = [ {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"bl_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"vsl_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"pol_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"pol_nod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"pod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"pod_nod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rcv_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"de_term_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"bkg_sts_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"corr_n1st_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"bdr_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"pck_qty",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"pck_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"grs_wgt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"wgt_ut_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"corr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"ovr_void_slt_qty",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"cmdt_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"cmdt_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"vsl_pre_pst_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"img_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
       
      InitColumns(cols);

      SetEditable(1);
      SetCountPosition(0);
      //SetSheetHeight(0);
      SetVisible(0);
            }
		break;
	case 5: //sheet1 init
	    with(sheetObj){
        
      var HeadTitle1="|value|name|TpszCd";
      var headCount=ComCountHeadTitle(HeadTitle1);

      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
      InitHeaders(headers, info);

      var cols = [ {Type:"DummyCheck", Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"DelChk" },
             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"val",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"name",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_vol_qty",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
       
      InitColumns(cols);

      SetEditable(1);
      //SetSheetHeight(0);
      SetVisible(0);
            }
		break;
	case 6:
	    with(sheetObj){        
      
      var HeadTitle="|";

      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
      var headers = [ { Text:HeadTitle, Align:"Center"} ];
      InitHeaders(headers, info);

      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
             {Type:"Radio",     Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"chk" } ];
       
      InitColumns(cols);

      SetEditable(1);
      //SetSheetHeight(0);
      SetVisible(0);
            }

		break;
	}
}
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case INIT:      //Default
		sheetObjects[0].SetWaitImageVisible(1);
		formObj.f_cmd.value=INIT;
 		var sXml=sheetObj.GetSearchData("ESM_BKG_0106GS.do", FormQueryString(formObj));
		var arrXml=sXml.split("|$$|");
		if (0 < arrXml.length) {
			//ComBkgXml2ComboItem(arrXml[0], document.getElementById("wgt_ut_cd"), "val", "name");
			ComBkgXml2ComboItem(arrXml[0], wgt_ut_cd, "val", "name");
			//document.getElementById("wgt_ut_cd").SetSelectIndex(0);
			wgt_ut_cd.SetSelectIndex(0);
		}
		if (1 < arrXml.length) {
			ComBkgXml2ComboItem(arrXml[1], rcv_term_cd, "val", "name");
			rcv_term_cd.SetSelectIndex(0);
		}
		if (2 < arrXml.length) {
			ComBkgXml2ComboItem(arrXml[2], de_term_cd, "val", "name");
			de_term_cd.SetSelectIndex(0);
		}
		if (3 < arrXml.length) {
			ComBkgXml2ComboItem(arrXml[3], cgo_lodg_mzd_cd, "val", "name");
			cgo_lodg_mzd_cd.SetSelectIndex(0);
		}
		sheetObjects[0].SetWaitImageVisible(0);
		break;
	case SEARCH: //조회
		
		if (validateForm(sheetObj, formObj, sAction))
			formObj.f_cmd.value=SEARCH;
 		var resultXml=sheetObj.GetSearchData("ESM_BKG_0106GS.do", FormQueryString(formObj));
		var arrXml=resultXml.split("|$$|");		
		if (arrXml.length == 5) {			
			var etcXml=arrXml[0];

			if (ComGetEtcData(etcXml, "rqst_dt") == "null" || ComGetEtcData(etcXml, "rqst_dt") == "") {				
				//document.getElementById("rqst_dt").innerText="";
				document.getElementById("rqst_dt").value="";
				//document.getElementById("rqst_usr_id").innerText="";
				document.getElementById("rqst_usr_id").value="";
				//document.getElementById("rqst_gdt").innerText="";
				document.getElementById("rqst_gdt").value="";
			} else {				
				//document.getElementById("rqst_dt").innerText=ComGetEtcData(etcXml, "rqst_dt");
				document.getElementById("rqst_dt").value=ComGetEtcData(etcXml, "rqst_dt");
				//document.getElementById("rqst_gdt").innerText=ComGetEtcData(etcXml, "rqst_gdt");
				document.getElementById("rqst_gdt").value=ComGetEtcData(etcXml, "rqst_gdt");
				//document.getElementById("rqst_usr_id").innerText=ComGetEtcData(etcXml, "rqst_usr_id");
				document.getElementById("rqst_usr_id").value=ComGetEtcData(etcXml, "rqst_usr_id");
			}			
			if (arrXml[4].indexOf("TOTAL='0'") < 1) {				
				var arrCombo=ComXml2ComboString(arrXml[4], "val", "name");
				sheetObjects[1].SetColProperty("cntr_no", {ComboText:"|"+arrCombo[0], ComboCode:"|"+arrCombo[1]} );
			}
			sheetObjects[0].LoadSearchData(arrXml[1],{Sync:1} );
			sheetObjects[1].LoadSearchData(arrXml[3],{Sync:1} );
			sheetObjects[2].LoadSearchData(arrXml[0],{Sync:1} );
			sheetObjects[3].LoadSearchData(arrXml[2],{Sync:1} );
			sheetObjects[4].LoadSearchData(arrXml[4],{Sync:1} );
//			if(sheetObjects[3].GetCellValue(1, "bkg_no") == -1){
//				ComShowCodeMessage("BKG00273");
//				return false;
//			}
			if(sheetObjects[0].RowCount() < 1){
				ComShowMessage(ComGetMsg("BKG00502"));
//				ComResetAll();
				return;
			}
			if (sheetObjects[3].GetCellValue(1, "de_term_cd") == "M") {
				document.getElementById("de_term_cd").disabled=false;
			} else {
				document.getElementById("de_term_cd").disabled=true;
			}
			if (sheetObjects[3].GetCellValue(1, "rcv_term_cd") == "M") {
				document.getElementById("rcv_term_cd").disabled=false;
			} else {
				document.getElementById("rcv_term_cd").disabled=true;
			}
			if (document.getElementById("bkg_no").value == "") {
				document.getElementById("bkg_no").value=sheetObjects[3].GetCellValue(1, "bkg_no");
			}
			
			if (sheetObjects[3].RowCount()> 0) { //nodata -1 값 처리
				document.getElementById("bl_no").value=sheetObjects[3].GetCellValue(1, "bl_no");
				document.getElementById("tvvd").value=sheetObjects[3].GetCellValue(1, "vsl_cd");
				document.getElementById("pol_cd").value=sheetObjects[3].GetCellValue(1, "pol_cd");
				document.getElementById("pod_cd").value=sheetObjects[3].GetCellValue(1, "pod_cd");
				document.getElementById("pol_nod_cd").value=sheetObjects[3].GetCellValue(1, "pol_nod_cd");
				document.getElementById("pod_nod_cd").value=sheetObjects[3].GetCellValue(1, "pod_nod_cd");
				document.getElementById("weight_sum").value=sheetObjects[3].GetCellText(1, "grs_wgt");				
				document.getElementById("wgt_ut_cd").value=sheetObjects[3].GetCellValue(1, "wgt_ut_cd");				
				document.getElementById("ovr_void_slt_qty").value=sheetObjects[3].GetCellValue(1, "ovr_void_slt_qty");
				document.getElementById("old_bkg_no").value = sheetObjects[3].GetCellValue(1,"bkg_no");
			}			
			for ( var j=1; j <= sheetObjects[1].RowCount(); j++) {
				var cntr_no=sheetObjects[1].GetCellValue(j, "cntr_no");
				var find_row=sheetObjects[4].FindText("name", cntr_no, 0, 2);
				sheetObjects[4].SetCellValue(find_row, "DelChk","1",0);
			}			
			/* by 이진서  memory lose
			var cntr_name="";
			var cntr_val="";														
			for (var j=1; j<=sheetObjects[4].RowCount(); j++){
if(sheetObjects[4].GetCellValue(j, "DelChk") == "0"){
cntr_name += sheetObjects[4].GetCellValue(j, "name")+"|";
cntr_val += sheetObjects[4].GetCellValue(j, "val")+"|";
				} 									
			}						
			cntr_val=cntr_val.substr(0,cntr_val.length-1);	
			cntr_name=cntr_name.substr(0,cntr_name.length-1);					    					  
			for (var i=1; i<=sheetObjects[1].RowCount(); i++){
if(sheetObjects[1].GetCellValue(i, "cntr_no") != ""){
				   sheetObjects[1].CellComboItem(i,"cntr_no", {ComboText:sheetObjects[1].CellValue(i, ComboCode:"cntr_no")+"|"+cntr_name} );
				   sheetObjects[1].SetCellEditable(i,"cntr_tpsz_cd",0);
				   sheetObjects[1].SetCellEditable(i,"cntr_vol_qty",0);
			   }else{							   
				  sheetObjects[1].CellComboItem(i,"cntr_no", {ComboText:"|"+cntr_name, ComboCode:"|"+cntr_val} );
				  sheetObjects[1].SetCellEditable(i,"cntr_tpsz_cd",1);
				  sheetObjects[1].SetCellEditable(i,"cntr_vol_qty",1);
			   } 							  
			}	
			 */
			if (sheetObjects[2].RowCount()> 0) { //nodata -1 값 처리
				var tpszN=sheetObjects[2].FindText("spcl_cgo_apro_cd", "N", 0, 2);
				var tpszP=sheetObjects[2].FindText("spcl_cgo_apro_cd", "P", 0, 2);
				var tpszR=sheetObjects[2].FindText("spcl_cgo_apro_cd", "R", 0, 2);
				var tpszY=sheetObjects[2].FindText("spcl_cgo_apro_cd", "Y", 0, 2);
				
				if (tpszN > 0) {
					document.getElementById("auth_cd").value="N";
					document.getElementById("auth_cd").style.color="red";
					document.getElementById("auth_cd").style.fontWeight="bold";
				} else if (tpszP > 0 && tpszN < 0) {
					document.getElementById("auth_cd").style.color="black";
					document.getElementById("auth_cd").value="P";
					document.getElementById("auth_cd").style.fontWeight="bold";
				} else if (tpszR > 0 && tpszN < 0 && tpszP < 0) {
					document.getElementById("auth_cd").style.color="black";
					document.getElementById("auth_cd").value="R";
					document.getElementById("auth_cd").style.fontWeight="bold";
				} else if (tpszY > 0 && tpszR < 0 && tpszN < 0 && tpszP < 0) {
					document.getElementById("auth_cd").style.color="black";
					document.getElementById("auth_cd").value="Y";
					document.getElementById("auth_cd").style.fontWeight="bold";
				} else {
					document.getElementById("auth_cd").style.color="";
					document.getElementById("auth_cd").value="";
					document.getElementById("auth_cd").style.fontWeight="";
				}
			}
			
			for ( var i=1; i <= sheetObjects[1].RowCount(); i++) {
				sheetObjects[1].SetCellValue(i, "Seq",i,0);
				sheetObjects[1].SetCellValue(i, "ibflag","R",0);
			}			
			for ( var i=2; i <= sheetObjects[2].RowCount()+ 1; i++) {
				if (sheetObjects[2].GetCellValue(i, "spcl_cgo_apro_cd") == "N") {
//parameter changed[check again]CLT 					sheetObjects[2].SetCellFontColor(i, "spcl_cgo_apro_cd","#FF0000");
//parameter changed[check again]CLT 					sheetObjects[2].SetCellFont("FontBold", i, "spcl_cgo_apro_cd",1);
				}
				sheetObjects[2].SetCellValue(i, "Seq",i - 1,0);
				sheetObjects[2].SetCellValue(i, "ibflag","R",0);
			}			
			if (sheetObjects[2].RowCount()> 0) { //nodata -1 값 처리
				htmlSheetSync();
			}	
			
			if (sheetObjects[2].RowCount()< 1 && document.getElementById("bl_no").value != "") {
				document.getElementById("auth_cd").value="";
				cargoAdd();
			} else if (sheetObjects[2].RowCount()< 1 && document.getElementById("bl_no").value == "") {
				ComShowCodeMessage("BKG00183", document.getElementById("bkg_no").value);
				return;
			}						
		}		
		//------------------------------------------------>
		//setInquiryDisableButton event calling
		if (ComGetObjValue(document.form.isInquiry) == "Y") {
			setInquiryDisableButton();
		}		
		
		break;
	case COMMAND04: //booking split no retrieve 
		formObj.f_cmd.value=COMMAND03;
		var param="&f_cmd=" + COMMAND03 + "&bkg_no=" + ComGetObjValue(formObj.bkg_no);
 		var sXml=sheetObj.GetSearchData("ESM_BKG_0079_01GS.do", param);
		var bkg_split_no_list=ComGetEtcData(sXml, "bkg_split_no_list");
		bkgSplitNoListPop(formObj.bkg_no, bkg_split_no_list, 25);
		break;
	case MULTI: //SAve
		if (validateForm(sheetObj, formObj, sAction))
			formObj.f_cmd.value=MULTI;
		if (sheetObjects[3].GetCellValue(1, "corr_no") == "" && sheetObjects[3].GetCellValue(1, "bdr_flg") == "Y") {
			ComShowMessage(ComGetMsg("BKG00004"));
			chkFlg="Y";
			return;
		}
		var retCnt1=0;
		var retCnt2=0;
		var delCnt=0;
		var iudCnt=0;
		var cntrNo="";
		var oldCntrNo="";
		var bbChkFlg="N";
		var tempI = 0;
		var tempU = 0;
		var tempD = 0;
		for ( var i=1; i <= sheetObjects[1].RowCount(); i++) {
			if (sheetObjects[1].GetCellValue(i, "ibflag") == "R") {
				retCnt1++;
			}
			if (sheetObjects[1].GetCellValue(i, "ibflag") == "I" || sheetObjects[1].GetCellValue(i, "ibflag") == "U" || sheetObjects[1].GetCellValue(i, "ibflag") == "D") {
				iudCnt++;
			}
			if (sheetObjects[1].GetCellValue(i, "cntr_tpsz_cd") == "") {
//				ComShowMessage(ComGetMsg("BKG00502", "BB"));
				ComShowMessage(ComGetMsg("BKG00446"));
				chkFlg="Y";
				return;
			}
			// Cntr No When it is modified in order to be sent Vender 301 Flg Was created.
			cntrNo=sheetObjects[1].GetCellValue(i, "cntr_no");
			oldCntrNo=sheetObjects[1].CellSearchValue(i, "cntr_no");
			if ( bbChkFlg == "N" && cntrNo != oldCntrNo ) {
				bbChkFlg="Y";
			}
		}
		if (iudCnt > 0) {
			for ( var i=1; i <= sheetObjects[1].RowCount(); i++) {
				if (sheetObjects[1].GetCellValue(i, "ibflag") != "D") {
//					sheetObjects[1].SetCellValue(i, "ibflag") = "I";
					sheetObjects[1].SetCellValue(i, "ibflag", "I", 0);
				}
			}
		}
		for ( var k=2; k <= sheetObjects[2].RowCount()+ 1; k++) {
			//if(sheetObjects[2].CellValue(k, "spcl_cgo_apro_cd") != "C" || sheetObjects[2].CellValue(k, "apro_cd") != "C"){					
			if (sheetObjects[2].GetCellValue(k, "ibflag") == "R") {
				retCnt2++;
			}
			if (sheetObjects[2].GetCellValue(k, "ibflag") != "D") {
				delCnt++;
			}
			if (sheetObjects[2].GetCellValue(k, "spcl_cgo_apro_cd") == "P") {
				ComShowMessage(ComGetMsg("BKG00500"));
				chkFlg="Y";
				return;
			}
			if (sheetObjects[2].GetCellValue(k, "grs_wgt") == "" || sheetObjects[2].GetCellValue(k, "grs_wgt") == "0") {
				ComShowMessage(ComGetMsg("BKG00506"));
				chkFlg="Y";
				return;
			}
			if (sheetObjects[2].GetCellValue(k, "wgt_ut_cd") == "") {
				ComShowMessage(ComGetMsg("BKG00509"));
				chkFlg="Y";
				return;
			}
			if (sheetObjects[2].GetCellValue(k, "cmdt_cd") == "") {
				ComShowMessage(ComGetMsg("BKG00510"));
				chkFlg="Y";
				return;
			}
			//}
		}
		var sum=0;
		if (sheetObjects[0].RowCount()> 0) {
			sum=sheetObjects[0].ComputeSum("|2|");
		}
		if (sum == "0") {
			if (delCnt > 0) {
				ComShowMessage(ComGetMsg("BKG00502", "BB"));
				chkFlg="Y";
				return;
			}
		}
		if (retCnt1 == sheetObjects[1].RowCount()&& retCnt2 == sheetObjects[2].RowCount()+ 1) {
			if (reqFlag != "N") {
				ComShowMessage(ComGetMsg("BKG00501"));
				chkFlg="Y";
				return;
			}
		}
		for ( var j=1; j <= sheetObjects[0].RowCount(); j++) {
			var cnt=0;
			var rcnt=0;
			var find_tpsz_cd="";
			for ( var m=1; m <= sheetObjects[1].RowCount(); m++) {
				// except Cancel and delete row
				if (sheetObjects[1].GetCellValue(m, "spcl_cgo_apro_cd") != "C" && sheetObjects[1].GetCellValue(m, "ibflag") != "D") {
					if (sheetObjects[0].GetCellValue(j, "cntr_tpsz_cd") == sheetObjects[1].GetCellValue(m, "cntr_tpsz_cd")) {
						cnt += Number(sheetObjects[1].GetCellValue(m, "cntr_vol_qty"));
					}
					var find_tpsz_row=sheetObjects[0].FindText("cntr_tpsz_cd", sheetObjects[1].GetCellValue(m, "cntr_tpsz_cd"), 0, 2);
					if (find_tpsz_row < 0) {
						rcnt++;
						find_tpsz_cd += sheetObjects[1].GetCellValue(m, "cntr_tpsz_cd") + ",";
					}
				}
			}
			if (rcnt > 0) {
				find_tpsz_cd=find_tpsz_cd.substr(0, find_tpsz_cd.length - 1);
				ComShowCodeMessage("BKG08023", find_tpsz_cd);
				chkFlg="Y";
				return;
			}
			var cntr_tpsz_cd=sheetObjects[1].FindText("cntr_tpsz_cd", sheetObjects[0].GetCellValue(j, "cntr_tpsz_cd"), 0, 2);
			if (cntr_tpsz_cd > 0 || cntr_tpsz_cd == "-1") {
				if (Number(sheetObjects[0].GetCellValue(j, "bb_cgo_qty")) > cnt) {
					if (ComShowConfirm(ComGetMsg("BKG00678", "BB"))) {
						cnt=0;
					} else {
						chkFlg="Y";
						return;
					}
				}
				if (Number(sheetObjects[0].GetCellValue(j, "bb_cgo_qty")) < cnt) {
					ComShowCodeMessage("BKG00679", "BB");
					chkFlg="Y";
					return;
				}
			}
		}
		var sParam=FormQueryString(formObj);
		// Cntr No When it is modified in order to be sent Vender 301 Flg Was created. 
		sParam=sParam + "&" + "bb_chk_flg=" + bbChkFlg;
		var sParamSheet1=sheetObjects[1].GetSaveString();
		var sParamSheet2=sheetObjects[2].GetSaveString();
		if (sParamSheet1 != "") {
			sParam=sParam + "&sheet1_" + sParamSheet1.replace(/&/g, '&sheet1_');
		}
		if (sParamSheet2 != "") {
			sParam=sParam + "&sheet2_" + sParamSheet2.replace(/&/g, '&sheet2_');
		}
		
 		var rXml=sheetObj.GetSaveData("ESM_BKG_0106GS.do", sParam);
		var rMsg=ComResultMessage(rXml);
		var State=ComGetEtcData(rXml, ComWebKey.Trans_Result_Key);
		// BB 저장시에 PSA 전송되도록 수정함. [CHM-201006332-01]
		if(ComGetEtcData(rXml, "psaValCode") != "Y" && ComGetEtcData(rXml, "psaValCode") != undefined){						
			var errMsg01=ComGetEtcData(rXml,"psaValCode");
			/*
			 * 2010.10.13
			 * null problem
			 * if(errMsg01 != undefined && errMsg01 != null && errMsg01 != "") { }
			 */
			if(errMsg01 != undefined && errMsg01 != null && errMsg01 != "") {
				var rmsg=errMsg01.split("<||>");
		    	if(rmsg[1] != undefined && rmsg[1].length > 0 && rmsg[1] == "BKG95027" ) {
		    		ComShowCodeMessage("BKG06125");
		    	}else if ( rmsg[1] != "BKG95025" ){
		    		ComShowMessage(rmsg[3]);
		    	}
			}
		}
		if (rMsg == '' && reqFlag == "Y") {
			ComShowMessage(ComGetMsg("BKG00166"));
			retFlag="Y";
		} else if (rMsg == '' && reqFlag == "N") {
		} else {
			sheetObj.LoadSearchData(rXml,{Sync:1} );
			return false;
		}
		break;
	case COMMAND01:
		if (validateForm(sheetObj, formObj, sAction))
			formObj.f_cmd.value=COMMAND01;
		var sParam=FormQueryString(formObj);
		var sParamSheet1=sheetObjects[2].GetSaveString();
		if (sParamSheet1 != "") {
			sParam=sParam + "&sheet2_" + sParamSheet1.replace(/&/g, '&sheet2_');
		}
 		var rXml=sheetObj.GetSaveData("ESM_BKG_0106GS.do", sParam);
		var rMsg=ComResultMessage(rXml);
		var State=ComGetEtcData(rXml, ComWebKey.Trans_Result_Key);
		//Corrected PSA should be sent at the BB store.[CHM-201006332-01]
		if(ComGetEtcData(rXml, "psaValCode") != "Y" && ComGetEtcData(rXml, "psaValCode") != undefined){						
			var errMsg01=ComGetEtcData(rXml,"psaValCode");
	    	var rmsg=errMsg01.split("<||>");
	    	if(rmsg[1] != undefined && rmsg[1].length > 0 && rmsg[1] == "BKG95027" ) {
	    		ComShowCodeMessage("BKG06125");
	    	}else if ( rmsg[1] != "BKG95025" ){
	    		ComShowMessage(rmsg[3]);
	    	}	
		}
		if (rMsg == '' && reqFlag == "N" && messageFlg == "save") {
			//ComShowMessage(ComGetMsg("BKG00166"));
			retFlag="Y";
		} else if (rMsg == '' && reqFlag == "N" && messageFlg == "request") {
			ComShowMessage(ComGetMsg("BKG08102"));
			retFlag="Y";
		} else if (rMsg == '' && reqFlag == "Y") {
		} else {
			sheetObj.LoadSearchData(rXml,{Sync:1} );
			return;
		}
		break;
	case COMMAND02:
		if (validateForm(sheetObj, formObj, sAction))
			formObj.f_cmd.value=COMMAND01;
		var sParam=FormQueryString(formObj);
		var sParamSheet1=sheetObjects[2].GetSaveString();
		if (sParamSheet1 != "") {
			sParam=sParam + "&sheet2_" + sParamSheet1.replace(/&/g, '&sheet2_');
		}
 		var rXml=sheetObj.GetSaveData("ESM_BKG_0106GS.do", sParam);
		var rMsg=ComResultMessage(rXml);
		var State=ComGetEtcData(rXml, ComWebKey.Trans_Result_Key);
		if (rMsg == '' && reqFlag == "N" && messageFlg == "save") {
			//ComShowMessage(ComGetMsg("BKG00166"));
			retFlag="Y";
		} else if (rMsg == '' && reqFlag == "N" && messageFlg == "requestCancel") {
			ComShowMessage(ComGetMsg("BKG08103"));
			retFlag="Y";
		} else if (rMsg == '' && reqFlag == "Y") {
		} else {
			sheetObj.LoadSearchData(rXml,{Sync:1} );
			return;
		}
		break;
	case COMMAND05: //booking split no retrieve 
		if (validateForm(sheetObj, formObj, sAction)) {
			sheetObj.SetWaitImageVisible(0);
			cmdtFlg="1";
			formObj.f_cmd.value=COMMAND05;
			var sXml = sheetObj.GetSearchData("ESM_BKG_0498GS.do", FormQueryString(formObj));
//			if (sXml != "") sheetObj.LoadSearchData(sXml,{Sync:1} );

			var cmdt_nm = ComGetEtcData(sXml, "cmdt_nm");
			if(cmdt_nm != 'undefind' && cmdt_nm != null) {
				document.getElementById("cmdt_nm").value=ComGetEtcData(sXml, "cmdt_nm");
			} else {
				document.getElementById("cmdt_nm").value="";
			}
			
			sheetObjects[2].SetCellValue(sheetObjects[2].GetSelectRow(), "cmdt_nm",cmdt_nm, 0);
			sheetObjects[2].SetCellValue(sheetObjects[2].GetSelectRow(), "modifyaproflg","Y",0);
			sheetObj.SetWaitImageVisible(1);
			cmdtFlg="";
		} else {
			return false;
		}
		break;
	}
}
//Using a lookup function lookup is complete, an Event occurs
function sheet4_OnSearchEnd(sheetObj, ErrMsg){
	with (sheetObj) {
		if(sheetObjects[3].RowCount() > 0 ){
			
			if(sheetObjects[3].GetCellValue(1,"img_flg") == "Y"){
//				document.getElementById('btn_attach_file').style.color = 'blue';
				ComGetObject("btn_attach_file").style.setProperty("color", BTN_BLUE, "important");
			}else{
//				document.getElementById('btn_attach_file').style.color = '';
				ComGetObject("btn_attach_file").style.setProperty("color", "", "");
			}
		}
	}
}
function htmlSheetSync() {
	Row=sheetObjects[2].GetSelectRow();
	document.getElementById("Seq").value=sheetObjects[2].GetCellValue(Row, "Seq");
	document.getElementById("bb_dcgo_seq").value=sheetObjects[2].GetCellValue(Row, "bb_dcgo_seq");
	document.getElementById("rcv_term_cd").value=sheetObjects[2].GetCellValue(Row, "rcv_term_cd");
	document.getElementById("de_term_cd").value=sheetObjects[2].GetCellValue(Row, "de_term_cd");
	document.getElementById("slng_pnt_flg").value=sheetObjects[2].GetCellValue(Row, "slng_pnt_flg");
	document.getElementById("grav_ctr_desc").value=sheetObjects[2].GetCellValue(Row, "grav_ctr_desc");
	document.getElementById("cmdt_cd").value=sheetObjects[2].GetCellValue(Row, "cmdt_cd");
	document.getElementById("cmdt_nm").value=sheetObjects[2].GetCellValue(Row, "cmdt_nm");
	document.getElementById("pck_dtl_desc").value=sheetObjects[2].GetCellValue(Row, "pck_dtl_desc");
	document.getElementById("cgo_lodg_mzd_cd").value=sheetObjects[2].GetCellValue(Row, "cgo_lodg_mzd_cd");
	document.getElementById("scr_dng_ctnt").value=sheetObjects[2].GetCellValue(Row, "scr_dng_ctnt");
	document.getElementById("spcl_rqst_desc").value=sheetObjects[2].GetCellValue(Row, "spcl_rqst_desc");
	document.getElementById("temp_grs_wgt").value=sheetObjects[2].GetCellValue(Row, "grs_wgt");
	document.getElementById("temp_net_wgt").value=sheetObjects[2].GetCellValue(Row, "net_wgt");
	document.getElementById("diff_rmk").value=sheetObjects[2].GetCellValue(Row, "diff_rmk");
	document.getElementById("aply_no").value=sheetObjects[2].GetCellValue(Row, "aply_no");
	if (sheetObjects[2].RowCount()> 0 && sheetObjects[2].GetCellValue(Row, "diff_rmk").length > 0) {
			document.getElementById("btn_Remark").style.color="blue";
		} else {
			document.getElementById("btn_Remark").style.color="";
		}
	if (sheetObjects[2].GetCellValue(Row, "spcl_cgo_apro_cd") == "C" || sheetObjects[2].GetCellValue(Row, "spcl_cgo_apro_cd") == "") {
//			document.getElementById("btn_RequestCancel").className="btn2_1";
			cancelFlg="Y";
		} else {
//			document.getElementById("btn_RequestCancel").className="btn2";
			cancelFlg="N";
		}
}
/**
 *  fnCntrComboItem Action event handling
 * @param sheetObj, Row, Col, Value
 */
function fnCntrComboItem(sheetObj, row, col, val) {
	var cntr_name="";
	var cntr_val="";
	for ( var j=1; j <= sheetObjects[4].RowCount(); j++) {
		if (sheetObjects[4].GetCellValue(j, "DelChk") == "0") {
			cntr_name += sheetObjects[4].GetCellValue(j, "name") + "|";
			cntr_val += sheetObjects[4].GetCellValue(j, "val") + "|";
		}
	}
	cntr_val=cntr_val.substr(0, cntr_val.length - 1);
	cntr_name=cntr_name.substr(0, cntr_name.length - 1);
	var checkCntr=sheetObjects[4].FindText("DelChk", "0", 0, 2);
	var i=row;
	if (checkCntr > 0) {
		if (val != "") {
			//sheetObjects[1].CellComboItem(i,"cntr_no", {ComboText:"|"+sheetObjects[1].CellValue(i, ComboCode:"cntr_no")+"|"+cntr_name} );
//			sheetObjects[1].CellComboItem(i, "cntr_no", " |" + sheetObjects[1].GetCellValue(i, "cntr_no") + "|" + cntr_name, " |" + sheetObjects[1].GetCellValue(i, "cntr_no") + "|" + cntr_val);
			sheetObjects[1].CellComboItem(i, "cntr_no",{ComboText: " |" + sheetObjects[1].GetCellValue(i, "cntr_no") + "|" + cntr_name, ComboCode:" |" + sheetObjects[1].GetCellValue(i, "cntr_no") + "|" + cntr_val});
			sheetObjects[1].SetCellEditable(i, "cntr_tpsz_cd",0);
			sheetObjects[1].SetCellEditable(i, "cntr_vol_qty",0);
		} else {
			sheetObjects[1].CellComboItem(i,"cntr_no", {ComboText:"|"+cntr_name, ComboCode:"|"+cntr_val} );
			sheetObjects[1].SetCellEditable(i, "cntr_tpsz_cd",1);
			sheetObjects[1].SetCellEditable(i, "cntr_vol_qty",1);
		}
	} else {
		if (val != "") {
			//sheetObjects[1].CellComboItem(i,"cntr_no", {ComboText:"|"+sheetObjects[1].CellValue(i, ComboCode:"cntr_no")} );
//			sheetObjects[1].CellComboItem(i, "cntr_no", " |" + sheetObjects[1].GetCellValue(i, "cntr_no"), " |" + sheetObjects[1].GetCellValue(i, "cntr_no"));
			sheetObjects[1].CellComboItem(i, "cntr_no", {ComboText:" |" + sheetObjects[1].GetCellValue(i, "cntr_no"), ComboCode:" |" + sheetObjects[1].GetCellValue(i, "cntr_no")});
			sheetObjects[1].SetCellEditable(i, "cntr_tpsz_cd",0);
			sheetObjects[1].SetCellEditable(i, "cntr_vol_qty",0);
		} else {
//			sheetObjects[1].CellComboItem(i,"cntr_no", {ComboText:"", ComboCode:""} );
			sheetObjects[1].CellComboItem(i,"cntr_no", {ComboText:" |", ComboCode:"|"} );
			sheetObjects[1].SetCellEditable(i, "cntr_tpsz_cd",1);
			sheetObjects[1].SetCellEditable(i, "cntr_vol_qty",1);
		}
	}
}
/**
 * sheet2_OnClick Action event handling
 * @param sheetObj, Row, Col, Value
 */
function sheet2_OnClick(sheetObj, row, col, val) {
	var col_name=sheetObj.ColSaveName(col);
	switch (col_name) {
	case "cntr_no":
		document.getElementById("temp_cntr_no").value=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "cntr_no");
		fnCntrComboItem(sheetObj, row, col, val);
		break;
	}
}
function sheet2_OnChange(sheetObj, row, col, val) {
	var col_name=sheetObj.ColSaveName(col);
	switch (col_name) {
	case "cntr_no":
		if (sheetObjects[1].GetCellValue(row, "cntr_no") != "") {
			var temp_cntr_no=document.getElementById("temp_cntr_no").value;
			var temp_find_row=sheetObjects[4].FindText("name", temp_cntr_no, 0, 2);
			if (temp_cntr_no != "") {
				sheetObjects[4].SetCellValue(temp_find_row, "DelChk","0");
			}
			var cntr_no=sheetObjects[1].GetCellValue(row, "cntr_no");
			var find_row=sheetObjects[4].FindText("name", cntr_no, 0, 2);
			if (sheetObjects[1].GetCellValue(row, "cntr_no") != "" && sheetObjects[1].GetCellValue(row, "cntr_tpsz_cd") != "" && sheetObjects[1].GetCellValue(row, "cntr_tpsz_cd") != sheetObjects[4].GetCellValue(find_row, "cntr_tpsz_cd")) {
				if (ComShowConfirm(ComGetMsg("BKG00570"))) {
					sheetObjects[1].SetCellValue(row, "cntr_tpsz_cd",sheetObjects[4].GetCellValue(find_row, "cntr_tpsz_cd"),0);
				} else {
					sheetObjects[1].SetCellValue(row, "cntr_no","",0);
					cntr_no="";
				}
			} else if (sheetObjects[1].GetCellValue(row, "cntr_tpsz_cd") == "") {
				sheetObjects[1].SetCellValue(row, "cntr_tpsz_cd",sheetObjects[4].GetCellValue(find_row, "cntr_tpsz_cd"),0);
			}
			sheetObjects[1].SetCellValue(row, "cntr_vol_qty",sheetObjects[4].GetCellValue(find_row, "cntr_vol_qty"),0);
			if (cntr_no != "") {
				sheetObjects[4].SetCellValue(find_row, "DelChk","1",0);
			}
			document.getElementById("temp_cntr_no").value=cntr_no;
			/*
			var cntr_name="";
			var cntr_val="";									 						
			for (var j=1; j<=sheetObjects[4].RowCount(); j++){
if(sheetObjects[4].GetCellValue(j, "DelChk") == "0"){
cntr_name += sheetObjects[4].GetCellValue(j, "name")+"|";
cntr_val += sheetObjects[4].GetCellValue(j, "val")+"|";
				} 									
			}							 					
			cntr_val=cntr_val.substr(0,cntr_val.length-1);	
			cntr_name=cntr_name.substr(0,cntr_name.length-1); 					
			for (var i=1; i<=sheetObjects[1].RowCount(); i++){
if(sheetObjects[1].GetCellValue(i, "cntr_no") != ""){
					sheetObjects[1].CellComboItem(i,"cntr_no", {ComboText:sheetObjects[1].CellValue(i, ComboCode:"cntr_no")+"|"+cntr_name} );
					sheetObjects[1].SetCellEditable(i,"cntr_tpsz_cd",0);
					sheetObjects[1].SetCellEditable(i,"cntr_vol_qty",0);
				}else{ 							 
					sheetObjects[1].CellComboItem(i,"cntr_no", {ComboText:"|"+cntr_name, ComboCode:"|"+cntr_val} );
					sheetObjects[1].SetCellEditable(i,"cntr_tpsz_cd",1);
					sheetObjects[1].SetCellEditable(i,"cntr_vol_qty",1);
				} 												   
			}	
			 */
		} else {
			var temp_cntr_no=document.getElementById("temp_cntr_no").value;
			var temp_find_row=sheetObjects[4].FindText("name", temp_cntr_no, 0, 2);
			if (temp_cntr_no != "") {
				sheetObjects[4].SetCellValue(temp_find_row, "DelChk","0");
			}
			document.getElementById("temp_cntr_no").value="";
			/*
			var cntr_name="";
			var cntr_val="";							 						
			for (var j=1; j<=sheetObjects[4].LastRow(); j++){
if(sheetObjects[4].GetCellValue(j, "DelChk") == "0"){
cntr_name += sheetObjects[4].GetCellValue(j, "name")+"|";
cntr_val += sheetObjects[4].GetCellValue(j, "val")+"|";
				} 									
			}
			cntr_val=cntr_val.substr(0,cntr_val.length-1);	
			cntr_name=cntr_name.substr(0,cntr_name.length-1);										 					
			for (var i=1; i<=sheetObjects[1].RowCount(); i++){
if(sheetObjects[1].GetCellValue(i, "cntr_no") != ""){
					   sheetObjects[1].CellComboItem(i,"cntr_no", {ComboText:sheetObjects[1].CellValue(i, ComboCode:"cntr_no")+"|"+cntr_name} );
					   sheetObjects[1].SetCellEditable(i,"cntr_tpsz_cd",0);
					   sheetObjects[1].SetCellEditable(i,"cntr_vol_qty",0);
				}else{ 							 
					  sheetObjects[1].CellComboItem(i,"cntr_no", {ComboText:"|"+cntr_name, ComboCode:"|"+cntr_val} );
					  sheetObjects[1].SetCellEditable(i,"cntr_tpsz_cd",1);
					  sheetObjects[1].SetCellEditable(i,"cntr_vol_qty",1);
				}													
			}
			 */
		}
		break;
	}
}
function sheet3_OnChange(sheetObj, row, col, val) {
	var col_name=sheetObj.ColSaveName(col);
	switch (col_name) {
	case "grs_wgt":
		if (Number(sheetObjects[2].GetCellValue(row, "grs_wgt")) < Number(sheetObjects[2].GetCellValue(row, "net_wgt"))) {
			sheetObjects[2].SetCellValue(row, "grs_wgt",document.getElementById("temp_grs_wgt").value);
			ComShowMessage(ComGetMsg("BKG00491"));
		}
		sheetObjects[2].SetCellValue(row, "modifyaproflg","Y",0);
		sheetObjects[3].SetCellValue(1, "grs_wgt",sheetObjects[2].ComputeSum("|6|"),0);
		document.getElementById("weight_sum").value=sheetObjects[3].GetCellText(1, "grs_wgt")
		break;
	case "net_wgt":
		if (Number(sheetObjects[2].GetCellValue(row, "grs_wgt")) < Number(sheetObjects[2].GetCellValue(row, "net_wgt"))) {
			sheetObjects[2].SetCellValue(row, "net_wgt",document.getElementById("temp_net_wgt").value);
			ComShowMessage(ComGetMsg("BKG00491"));
		}
		sheetObjects[2].SetCellValue(row, "modifyaproflg","Y",0);
		break;
	}
}
function sheet3_OnClick(sheetObj, Row, Col, Value) {
	htmlSheetSync();
}
function sheet3_OnPopupClick(sheetObj, row, col, Value) {
	var col_name=sheetObj.ColSaveName(col);
	switch (col_name) {
	case "pck_tp_cd":
		sheetObjects[2].SetCellValue(row, "pck_tp_cd",(sheetObjects[2].GetCellValue(row, "pck_tp_cd")).toUpperCase(),0);
		comBkgCallModal0696("callbackPckTp", sheetObjects[2].GetCellValue(row, "pck_tp_cd"));
		
		break;
	}
}
/**
 * Inc case of changing wgt_ut_cd 
 */
function wgt_ut_cd_OnChange(Code, Text){
	var wgt_ut_cd=document.getElementById("wgt_ut_cd").value;
	for ( var i=2; i <= sheetObjects[2].RowCount()+ 1; i++) {
		sheetObjects[2].SetCellValue(i, "wgt_ut_cd",wgt_ut_cd,0);
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
	}
	return true;
}
/**
 * setInquiryDisableButton event calling .<br>
 * ComBtnDisable-> Disabled
 * @param 
 */
function setInquiryDisableButton() {
//	ComBtnDisable("btn_attach_file");
	ComBtnDisable("btn_terminal_information");
	ComBtnDisable("btn_Save");
	ComBtnDisable("btn_Request");
}
