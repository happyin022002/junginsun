/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0498.js
*@FileTitle  : Awakward Cargo Application
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/22
=========================================================
*/

/****************************************************************************************
 Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
 [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
 character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class esm_bkg_0498 : business script for esm_bkg_0498
 */
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
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
	/***** using extra sheet valuable if there are more 2 sheets *****/
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	var sheetObject3=sheetObjects[2];
	var sheetObject4=sheetObjects[3];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		if (srcName != "btn_splitPop") {
			if (layList.style.display == "") {
				layList.style.display="none";
			}
		}
		switch (srcName) {
		case "btn_splitPop":
			doActionIBSheet(sheetObject1, formObject, COMMAND04);
			break;
		case "btn_Retrieve":
			if (document.getElementById("bkg_no").value != "" || document.getElementById("bl_no").value != "") {
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
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
					doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
					if (retFlag == "Y") {
						doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
					}
					
					ComOpenWait(false);
				} , 100);
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
//				var iCnt=0;
//				var uCnt=0;
//				var dCnt=0;
//				var ncCnt=0;
//				var rCnt=0;
//				var yCnt=0;
//				var reqCnt=0;
//				for ( var i=1; i <= sheetObjects[1].RowCount(); i++) {
//					if (sheetObjects[1].GetCellValue(i, "spcl_cgo_apro_cd") != "C") {
//						reqCnt++;
//					}
//				}
//				if (reqCnt < 1) {
//					ComShowMessage(ComGetMsg("BKG08107"));
//					return;
//				}
//				var cntR=0;
//				for ( var i=1; i <= sheetObjects[1].RowCount(); i++) {
//					if (sheetObjects[1].GetCellValue(i, "ibflag") != "R") {
//						cntR++;
//					}
//				}
//				if (cntR > 0 && sheetObjects[2].GetCellValue(1, "bdr_flg") == "Y" && sheetObjects[2].GetCellValue(1, "corr_no") != "") {
//					ComShowMessage(ComGetMsg("BKG08076"));
//					return;
//				}
//				iCnt=sheetObjects[1].FindText("ibflag", "I", 0, 2);
//				uCnt=sheetObjects[1].FindText("ibflag", "U", 0, 2);
//				dCnt=sheetObjects[1].FindText("ibflag", "D", 0, 2);
//				if (iCnt > 0 || uCnt > 0 || dCnt > 0) {
//					if (sheetObjects[2].GetCellValue(1, "bdr_flg") != "Y" && sheetObjects[2].GetCellValue(1, "corr_no") == "") {
//						//if(ComShowConfirm(ComGetMsg("BKG00824"))){
//						doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
//						//}else{
//						//	return;
//						//} 					 				
//					}
//					if (sheetObjects[2].GetCellValue(1, "bdr_flg") == "Y" && sheetObjects[2].GetCellValue(1, "corr_no") == "" && sheetObjects[2].GetCellValue(1, "vsl_pre_pst_cd") != "") {
//						ComShowMessage(ComGetMsg("BKG08074"));
//						return;
//					}
//					if (sheetObjects[2].GetCellValue(1, "bdr_flg") == "Y" && sheetObjects[2].GetCellValue(1, "corr_no") == "" && sheetObjects[2].GetCellValue(1, "vsl_pre_pst_cd") == "") {
//						ComShowMessage(ComGetMsg("BKG08075"));
//						return;
//					}
//				}
//				if (chkFlg != "Y") {
//					for ( var i=1; i <= sheetObjects[1].RowCount(); i++) {
//						if (sheetObjects[1].GetCellValue(i, "spcl_cgo_apro_cd") == "P") {
//							ComShowMessage(ComGetMsg("BKG00500"));
//							return;
//						}
//						if (sheetObjects[1].GetCellValue(i, "spcl_cgo_apro_cd") == "N" || sheetObjects[1].GetCellValue(i, "spcl_cgo_apro_cd") == "C") {
//							ncCnt++;
//						}
//						if (sheetObjects[1].GetCellValue(i, "spcl_cgo_apro_cd") == "R") {
//							rCnt++;
//						}
//						if (sheetObjects[1].GetCellValue(i, "spcl_cgo_apro_cd") == "Y") {
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
//					for ( var i=1; i <= sheetObjects[1].RowCount(); i++) {
//						if (sheetObjects[1].GetCellValue(i, "spcl_cgo_apro_cd") != "C") {
//							sheetObjects[1].SetCellValue(i, "apro_cd","R",0);
//						}
//					}
//					doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
//					if (retFlag == "Y") {
//						doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
//					}
//				}
				ComOpenWait(true);
				setTimeout( function () {
					btnRequestProcess();
				} , 100);
				ComOpenWait(false);
			}
			break;
		case "btn_RequestCancel":
			document.getElementById("button").value="Y";
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
// move to btnRequestCancelProcess() function
//				messageFlg="requestCancel";
//				reqFlag="N";
//				retFlag="";
//				var iCnt=0;
//				var uCnt=0;
//				var dCnt=0;
//				if (cancelFlg == "Y") {
//					return;
//				}
//				if (sheetObjects[2].GetCellValue(1, "bdr_flg") == "Y" && sheetObjects[2].GetCellValue(1, "corr_no") != "") {
//					ComShowMessage(ComGetMsg("BKG08076"));
//					return;
//				}
//				iCnt=sheetObjects[1].FindText("ibflag", "I", 0, 2);
//				uCnt=sheetObjects[1].FindText("ibflag", "U", 0, 2);
//				dCnt=sheetObjects[1].FindText("ibflag", "D", 0, 2);
//				if (iCnt > 0 || uCnt > 0 || dCnt > 0) {
//					if (sheetObjects[2].GetCellValue(1, "bdr_flg") != "Y" && sheetObjects[2].GetCellValue(1, "corr_no") == "") {
//						//if(ComShowConfirm(ComGetMsg("BKG00824"))){
//						doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
//						//}else{
//						//	return;
//						//} 					 				
//					}
//					if (sheetObjects[2].GetCellValue(1, "bdr_flg") == "Y" && sheetObjects[2].GetCellValue(1, "corr_no") == "" && sheetObjects[2].GetCellValue(1, "vsl_pre_pst_cd") != "") {
//						ComShowMessage(ComGetMsg("BKG08074"));
//						return;
//					}
//					if (sheetObjects[2].GetCellValue(1, "bdr_flg") == "Y" && sheetObjects[2].GetCellValue(1, "corr_no") == "" && sheetObjects[2].GetCellValue(1, "vsl_pre_pst_cd") == "") {
//						ComShowMessage(ComGetMsg("BKG08075"));
//						return;
//					}
//				}
//				if (ComShowConfirm(ComGetMsg("BKG00613", sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "Seq")))) {
//					/*
//					for(var i=1; i<=sheetObjects[1].RowCount(); i++){
//if(sheetObjects[1].GetCellValue(i,"spcl_cgo_apro_cd") != "C"){
//							  sheetObjects[1].SetCellValue(i,"apro_cd","R",0);
//						  }else{
//							  sheetObjects[1].SetCellValue(i,"apro_cd","C",0);
//						  }
//					}	
//					 */
//					sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "apro_cd","C",0);
//					doActionIBSheet(sheetObjects[0], document.form, COMMAND02);
//					if (retFlag == "Y") {
//						doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
//					}
//				} else {
//					return;
//				}
				ComOpenWait(true);
				setTimeout( function () {
					btnRequestCancelProcess();
				ComOpenWait(false);
				} , 100);
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
		case "btn_add":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				checkAdd();
			}
			break;
		case "btn_delete":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				deleteRows();
			}
			break;
		case "cmdt_button":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				ComOpenPopup("ESM_BKG_0653.do?cmdt_cd=" + formObject.cmdt_cd.value, 820, 550, "getCOM_CMDT_POPUP", '1,0,1,1,1,1,1', true, false, 0, 0, 0, "ESM_BKG_0653");
			}
			break;
		case "pck_button":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				comBkgCallModal0696("callbackPckTp", formObject.pck_tp_cd.value);
			}
			break;
		case "btn_approval":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				ComOpenPopup("VOP_SCG_1018.do?scg_flg=RF&bkg_no=" + formObject.bkg_no.value, 1000, 490, "", '0,0', true);
			}
			break;
		case "dg_container_seq":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				var cnt=0;
				for ( var i=1; i <= sheetObjects[1].RowCount(); i++) {
					if (sheetObjects[1].GetCellValue(i, "ibflag") != "D") {
						cnt++;
					}
				}
				if (cnt == "0") {
					ComShowMessage(ComGetMsg("BKG00624"));
				} else {
					var bkgNo=document.getElementById("bkg_no").value;
					var cntrNo=document.getElementById("temp_cntr_no").value;
					var cntrTpszCd=document.getElementById("cntr_tpsz_cd").value;
					var url="ESM_BKG_0754.do?modalFlg=Y&bkgNo=" + bkgNo + "&cntrNo=" + cntrNo + "&cntrTpszCd=" + cntrTpszCd;
					ComOpenWindowCenter(url, "ESM_BKG_0754", 800, 320, true);
				}
			}
			break;
		case "btn_dg_seq_del":
			document.getElementById("rf_dcgo_seq").value = "";
			var row=sheetObjects[1].GetSelectRow();
			sheetObjects[1].SetCellValue(row, "rf_dcgo_seq",document.getElementById("rf_dcgo_seq").value,0);
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
	//------------------------------------------------>
	//calling setInquiryDisableButton event
	if (ComGetObjValue(document.form.isInquiry) == "Y") {
		setInquiryDisableButton();
	}
	sheet2_OnLoadFinish(sheetObjects[0]);
	initControl();
}
function bkgSplitNoList(split_list) {
	document.form.bkg_no.value=split_list.options[split_list.selectedIndex].value;
	layList.style.display="none";
}
function getCOM_CMDT_POPUP(rowArray) {
	var formObject=document.form;
	var colArray=rowArray[0];
	formObject.cmdt_cd.value=colArray[3];
	sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "cmdt_cd",colArray[3],0);
	formObject.cmdt_nm.value=colArray[4];
	sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "cmdt_desc",colArray[4],0);
	sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "modifyaproflg","Y",0);
}
function callbackPckTp(returnVal) {
	document.form.pck_tp_cd.value=returnVal.cd;
	sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "pck_tp_cd",returnVal.cd,0);
}

function btnRequestProcess() {
	
	chkFlg="N";
	messageFlg="request";
	reqFlag="N";
	retFlag="";
	var iCnt=0;
	var uCnt=0;
	var dCnt=0;
	var ncCnt=0;
	var rCnt=0;
	var yCnt=0;
	var reqCnt=0;
	for ( var i=1; i <= sheetObjects[1].RowCount(); i++) {
		if (sheetObjects[1].GetCellValue(i, "spcl_cgo_apro_cd") != "C") {
			reqCnt++;
		}
		if (sheetObjects[1].GetCellValue(i, "cdo_temp") == "" || sheetObjects[1].GetCellValue(i, "fdo_temp") == "") {
			var seq=sheetObjects[1].GetCellValue(i, "Seq");
//			ComShowCodeMessage("BKG00611", "[" + seq + "]");
			ComShowCodeMessage("BKG95025", "Temperature [Seq : " + seq + " ]");
			chkFlg="Y";
			return;
		}
	}
	if (reqCnt < 1) {
		ComShowMessage(ComGetMsg("BKG08107"));
		return;
	}
	var cntR=0;
	for ( var i=1; i <= sheetObjects[1].RowCount(); i++) {
		if (sheetObjects[1].GetCellValue(i, "ibflag") != "R") {
			cntR++;
		}
	}
	if (cntR > 0 && sheetObjects[2].GetCellValue(1, "bdr_flg") == "Y" && sheetObjects[2].GetCellValue(1, "corr_no") != "") {
		ComShowMessage(ComGetMsg("BKG08076"));
		return;
	}
	iCnt=sheetObjects[1].FindText("ibflag", "I", 0, 2);
	uCnt=sheetObjects[1].FindText("ibflag", "U", 0, 2);
	dCnt=sheetObjects[1].FindText("ibflag", "D", 0, 2);
	if (iCnt > 0 || uCnt > 0 || dCnt > 0) {
		if (sheetObjects[2].GetCellValue(1, "bdr_flg") != "Y" && sheetObjects[2].GetCellValue(1, "corr_no") == "") {
			//if(ComShowConfirm(ComGetMsg("BKG00824"))){
			doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
			//}else{
			//	return;
			//} 					 				
		}
		if (sheetObjects[2].GetCellValue(1, "bdr_flg") == "Y" && sheetObjects[2].GetCellValue(1, "corr_no") == "" && sheetObjects[2].GetCellValue(1, "vsl_pre_pst_cd") != "") {
			ComShowMessage(ComGetMsg("BKG08074"));
			return;
		}
		if (sheetObjects[2].GetCellValue(1, "bdr_flg") == "Y" && sheetObjects[2].GetCellValue(1, "corr_no") == "" && sheetObjects[2].GetCellValue(1, "vsl_pre_pst_cd") == "") {
			ComShowMessage(ComGetMsg("BKG08075"));
			return;
		}
	}
	if (chkFlg != "Y") {
		for ( var i=1; i <= sheetObjects[1].RowCount(); i++) {
			if (sheetObjects[1].GetCellValue(i, "spcl_cgo_apro_cd") == "P") {
				ComShowMessage(ComGetMsg("BKG00500"));
				return;
			}
			if (sheetObjects[1].GetCellValue(i, "spcl_cgo_apro_cd") == "N" || sheetObjects[1].GetCellValue(i, "spcl_cgo_apro_cd") == "C") {
				ncCnt++;
			}
			if (sheetObjects[1].GetCellValue(i, "spcl_cgo_apro_cd") == "R") {
				rCnt++;
			}
			if (sheetObjects[1].GetCellValue(i, "spcl_cgo_apro_cd") == "Y") {
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
		for ( var i=1; i <= sheetObjects[1].RowCount(); i++) {
			if (sheetObjects[1].GetCellValue(i, "spcl_cgo_apro_cd") != "C") {
				sheetObjects[1].SetCellValue(i, "apro_cd","R",0);
			}
		}
		doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
		if (retFlag == "Y") {
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}	
	
}

function btnRequestCancelProcess() {

	messageFlg="requestCancel";
	reqFlag="N";
	retFlag="";
	var iCnt=0;
	var uCnt=0;
	var dCnt=0;
	if (cancelFlg == "Y") {
		return;
	}
	if (sheetObjects[2].GetCellValue(1, "bdr_flg") == "Y" && sheetObjects[2].GetCellValue(1, "corr_no") != "") {
		ComShowMessage(ComGetMsg("BKG08076"));
		return;
	}
	iCnt=sheetObjects[1].FindText("ibflag", "I", 0, 2);
	uCnt=sheetObjects[1].FindText("ibflag", "U", 0, 2);
	dCnt=sheetObjects[1].FindText("ibflag", "D", 0, 2);
	if (iCnt > 0 || uCnt > 0 || dCnt > 0) {
		if (sheetObjects[2].GetCellValue(1, "bdr_flg") != "Y" && sheetObjects[2].GetCellValue(1, "corr_no") == "") {
			//if(ComShowConfirm(ComGetMsg("BKG00824"))){
			doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
			//}else{
			//	return;
			//} 					 				
		}
		if (sheetObjects[2].GetCellValue(1, "bdr_flg") == "Y" && sheetObjects[2].GetCellValue(1, "corr_no") == "" && sheetObjects[2].GetCellValue(1, "vsl_pre_pst_cd") != "") {
			ComShowMessage(ComGetMsg("BKG08074"));
			return;
		}
		if (sheetObjects[2].GetCellValue(1, "bdr_flg") == "Y" && sheetObjects[2].GetCellValue(1, "corr_no") == "" && sheetObjects[2].GetCellValue(1, "vsl_pre_pst_cd") == "") {
			ComShowMessage(ComGetMsg("BKG08075"));
			return;
		}
	}
	if (ComShowConfirm(ComGetMsg("BKG00613", sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "Seq")))) {

		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "apro_cd","C",0);
		doActionIBSheet(sheetObjects[0], document.form, COMMAND02);
		if (retFlag == "Y") {
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	} else {
		return;
	}
}

function checkAdd() {
	if (sheetObjects[1].RowCount()> 0) {
		var seqVal=Number(sheetObjects[1].GetCellValue(1, "rc_seq"));
	} else {
		var seqVal=0;
	}
	for ( var k=1; k <= sheetObjects[1].RowCount(); k++) {
		if (seqVal < Number(sheetObjects[1].GetCellValue(k, "rc_seq"))) {
			seqVal=sheetObjects[1].GetCellValue(k, "rc_seq");
		}
	}
	var Row=sheetObjects[1].DataInsert(-1);
	sheetObjects[1].SetCellValue(Row, "rc_seq",Number(seqVal) + 1,0);
	sheetObjects[1].SetCellValue(Row, "bkg_no",document.getElementById("bkg_no").value,0);
	sheetObjects[1].SetCellValue(Row, "ctrl_atms_flg","N",0);
	sheetObjects[1].SetCellValue(Row, "modi_atms_flg","N",0);
	sheetObjects[1].SetCellValue(Row, "humid_ctrl_flg","N",0);
//	sheetObjects[1].CellValue2(Row, "cdo_temp") = "0";  
//	sheetObjects[1].CellValue2(Row, "fdo_temp") = "32";
//	document.getElementById("cdo_temp").value = "0";
//	document.getElementById("fdo_temp").value = "32";
	sheetObjects[1].SetCellValue(Row, "cdo_temp","",0);
	sheetObjects[1].SetCellValue(Row, "fdo_temp","",0);
	document.getElementById("cdo_temp").value="";
	document.getElementById("fdo_temp").value="";
	sheetObjects[1].SetCellValue(Row, "cmdt_cd",sheetObjects[2].GetCellValue(1, "cmdt_cd"),0);
	sheetObjects[1].SetCellValue(Row, "cmdt_desc",sheetObjects[2].GetCellValue(1, "cmdt_nm"),0);
	sheetObjects[1].SetCellValue(Row, "cntr_vent_tp_cd","P",0);
	document.getElementById("cntr_vent_tp_cd").value="P";
	sheetObjects[1].SetCellValue(Row, "vent_rto","",0);
	document.getElementById("vent_rto").value="";
	sheetObjects[1].SetCellValue(Row, "vltg_no","0",0);
	var row=0;
	for ( var i=1; i <= sheetObjects[1].RowCount(); i++) {
		if (sheetObjects[1].GetCellValue(i, "ibflag") != "D") {
			row++;
			sheetObjects[1].SetCellValue(i, "Seq",row,0);
		}
	}
	htmlSheetSync();
	var cntr_name="";
	var cntr_val="";
	for ( var j=1; j <= sheetObjects[3].RowCount(); j++) {
		if (sheetObjects[3].GetCellValue(j, "DelChk") == "0") {
			cntr_name += sheetObjects[3].GetCellValue(j, "name") + "|";
			cntr_val += sheetObjects[3].GetCellValue(j, "val") + "|";
		}
	}
	cntr_val=cntr_val.substr(0, cntr_val.length - 1);
	cntr_name=cntr_name.substr(0, cntr_name.length - 1);
	sheetObjects[1].CellComboItem(Row,"cntr_no", {ComboText:"|"+cntr_name, ComboCode:"|"+cntr_val} );
}

function deleteRows() {
	for ( var k=1; k <= sheetObjects[1].RowCount(); k++) {
		if (sheetObjects[1].GetCellValue(k, "DelChk") == "1") {
			if (sheetObjects[1].GetCellValue(k, "spcl_cgo_apro_cd") == "P" || sheetObjects[1].GetCellValue(k, "spcl_cgo_apro_cd") == "R" || sheetObjects[1].GetCellValue(k, "spcl_cgo_apro_cd") == "Y" || sheetObjects[1].GetCellValue(k, "spcl_cgo_apro_cd") == "N") {
				ComShowMessage(ComGetMsg("BKG00525"));
				return;
			}
		}
	}
	var find_row=0;
	for ( var i=1; i <= sheetObjects[1].RowCount(); i++) {
		if (sheetObjects[1].GetCellValue(i, "DelChk") == "1") {
			var temp_cntr_no=sheetObjects[1].GetCellValue(i, "cntr_no");
			var temp_find_row=sheetObjects[3].FindText("name", temp_cntr_no, 0, 2);
			if (temp_cntr_no != "") {
				sheetObjects[3].SetCellValue(temp_find_row, "DelChk","0");
			}
		}
	}
	var drow=ComRowHideDelete(sheetObjects[1], "DelChk");
	var cntr_name="";
	var cntr_val="";
	for ( var j=1; j <= sheetObjects[3].RowCount(); j++) {
		if (sheetObjects[3].GetCellValue(j, "DelChk") == "0") {
			cntr_name += sheetObjects[3].GetCellValue(j, "name") + "|";
			cntr_val += sheetObjects[3].GetCellValue(j, "val") + "|";
		}
	}
	cntr_val=cntr_val.substr(0, cntr_val.length - 1);
	cntr_name=cntr_name.substr(0, cntr_name.length - 1);
	var cnt=0;
	for ( var i=1; i <= sheetObjects[1].RowCount(); i++) {
		//sheetObjects[1].CellComboItem(i,"cntr_no", {ComboText:sheetObjects[1].CellValue(i, ComboCode:"cntr_no")+"|"+cntr_name+"|"} );
		if (sheetObjects[1].GetCellValue(i, "ibflag") != "D") {
			cnt++;
			sheetObjects[1].SetCellValue(i, "Seq",cnt,0);
		}
	}
	for ( var i=1; i <= sheetObjects[1].RowCount(); i++) {
		if (sheetObjects[1].GetCellValue(i, "ibflag") != "D") {
			sheetObjects[1].SelectCell(i, 0, false);
			htmlSheetSync();
			return;
		} else {
			find_row++;
		}
	}
	if (find_row == sheetObjects[1].RowCount()) {
		document.getElementById("seq").value="0";
		document.getElementById("cmdt_cd").value="";
		document.getElementById("cmdt_nm").value="";
		document.getElementById("cdo_temp").value="";
		document.getElementById("fdo_temp").value="";
		document.getElementById("vent_rto").value="";
		document.getElementById("humid_no").value="0";
		document.getElementById("pck_qty").value="0";
		document.getElementById("grs_wgt").value="0";
		document.getElementById("net_wgt").value="0";
		document.getElementById("wgt_ut_cd1").value="KGS";
		document.getElementById("wgt_ut_cd2").value="KGS";
		document.getElementById("ctrl_atms_flg").checked=false;
		document.getElementById("modi_atms_flg").checked=false;
		document.getElementById("humid_ctrl_flg").checked=false;
		document.getElementById("cntr_drn_cd").value="N";
		document.getElementById("clng_tp_cd").value="";
		document.getElementById("aply_no").value="";
	}
}
function initControl() {
	axon_event.addListenerForm('click', 'obj_click', form);
	axon_event.addListenerForm('blur', 'obj_blur', form);
	axon_event.addListenerForm('keyup', 'obj_keyup', form);
	axon_event.addListenerForm('keypress', 'obj_keypress', form);
	axon_event.addListenerForm('change', 'obj_change', form);
	axon_event.addListenerForm('keydown', 'obj_keydown', form);
	axon_event.addListenerForm('blur', 'obj_deactivate', form); //- focus out
	applyShortcut();
}
function obj_deactivate() {
	var row=sheetObjects[1].GetSelectRow();
	switch (event.srcElement.name) {
	case "cmdt_cd":
		if (document.getElementById("bkg_no").value != "") {
			if(document.getElementById("cmdt_cd").value == ""){
				document.getElementById("cmdt_nm").value = "";
				sheetObjects[1].SetCellValue(row, "cmdt_cd","",0);
				sheetObjects[1].SetCellValue(row, "cmdt_nm","",0);
			}else{
				if (document.getElementById("cmdt_cd").value.length < 6) {
					var cmdt_cd="";
					var len=6 - Number(document.getElementById("cmdt_cd").value.length);
					cmdt_cd=document.getElementById("cmdt_cd").value;
					for ( var i=1; i <= len; i++) {
						cmdt_cd="0" + cmdt_cd;
					}
					document.getElementById("cmdt_cd").value=cmdt_cd;
					sheetObjects[1].SetCellValue(row, "cmdt_cd",cmdt_cd,0);
				}
				if (cmdtFlg == "") {
					doActionIBSheet(sheetObjects[0], document.form, COMMAND05);
					sheetObjects[1].SetCellValue(row, "cmdt_desc",document.getElementById("cmdt_nm").value,0);
				}
			}
		}
		break;
	}
}
function copyCnt(copyCnt) {
	for ( var i=1; i <= copyCnt; i++) {
		var seqVal=Number(sheetObjects[1].GetCellValue(1, "rc_seq"));
		for ( var k=1; k <= sheetObjects[1].RowCount(); k++) {
			if (seqVal < Number(sheetObjects[1].GetCellValue(k, "rc_seq"))) {
				seqVal=sheetObjects[1].GetCellValue(k, "rc_seq");
			}
		}
		var selRow=sheetObjects[1].GetSelectRow();
		var Row=sheetObjects[1].DataInsert(-1);
		for ( var ic=0; ic <= sheetObjects[1].LastCol(); ic++) {
			if (sheetObjects[1].ColSaveName(ic) == "ibflag" || sheetObjects[1].ColSaveName(ic) == "seq")
				continue;
			sheetObjects[1].SetCellValue(Row, ic,sheetObjects[1].GetCellValue(selRow, ic),0);
		}
		sheetObjects[1].SetCellValue(Row, "cntr_no","",0);
		sheetObjects[1].SetCellValue(Row, "rc_seq",Number(seqVal) + 1,0);
		sheetObjects[1].SetCellValue(Row, "spcl_cgo_apro_cd","",0);
		sheetObjects[1].SetCellValue(Row, "DelChk","0",0);
		var rows=0;
		for ( var m=1; m <= sheetObjects[1].RowCount(); m++) {
			if (sheetObjects[1].GetCellValue(m, "ibflag") != "D") {
				rows++;
				sheetObjects[1].SetCellValue(m, "Seq",rows,0);
			}
		}
		var cntr_name="";
		var cntr_val="";
		var temp_cntr_no=sheetObjects[1].GetCellValue(Row, "cntr_no");
		var temp_find_row=sheetObjects[3].FindText("name", temp_cntr_no, 0, 2);
		for ( var j=1; j <= sheetObjects[3].RowCount(); j++) {
			if (sheetObjects[3].GetCellValue(j, "DelChk") == "0") {
				cntr_name += sheetObjects[3].GetCellValue(j, "name") + "|";
				cntr_val += sheetObjects[3].GetCellValue(j, "val") + "|";
			}
		}
		cntr_val=cntr_val.substr(0, cntr_val.length - 1);
		cntr_name=cntr_name.substr(0, cntr_name.length - 1);
		sheetObjects[1].CellComboItem(Row,"cntr_no", {ComboText:"|"+cntr_name, ComboCode:"|"+cntr_val} );
	}
}
function obj_keydown() {
	if (event.keyCode == 13) { // Enter Key 			
		switch (event.srcElement.name) {
		case "bkg_no":
			document.getElementById("bkg_no").value=(document.getElementById("bkg_no").value).toUpperCase();
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;
		case "bl_no":
			document.getElementById("bl_no").value=(document.getElementById("bl_no").value).toUpperCase();
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;
		}
	}
}
function obj_keypress() {
	switch (event.srcElement.name) {
	case "pck_qty":
		ComKeyOnlyNumber(event.srcElement);
		break;
	case "grs_wgt":
		ComKeyOnlyNumber(event.srcElement, "-.");
		break;
	case "net_wgt":
		ComKeyOnlyNumber(event.srcElement, "-.");
		break;
	case "cdo_temp":
		ComKeyOnlyNumber(event.srcElement, ".");
		break;
	case "fdo_temp":
		ComKeyOnlyNumber(event.srcElement, ".");
		break;
	case "cmdt_cd":
		ComKeyOnlyNumber(event.srcElement);
		break;
	case "vent_rto":
		ComKeyOnlyNumber(event.srcElement, ".");
		break;
	case "humid_no":
		ComKeyOnlyNumber(event.srcElement);
		break;
	case "rf_dcgo_seq":
		ComKeyOnlyNumber(event.srcElement);
		break;
	}
}
function obj_keyup() {
	var row=sheetObjects[1].GetSelectRow();
	
	switch (event.srcElement.name) {
	case "grs_wgt":
		if (document.getElementById("grs_wgt").value.length > 7) {
			if (document.getElementById("grs_wgt").value.indexOf(".") > -1) {
			} else {
				document.getElementById("grs_wgt").value=document.getElementById("grs_wgt").value.substr(0, 7);
			}
		}
		sheetObjects[1].SetCellValue(row, "grs_wgt",document.getElementById("grs_wgt").value,0);
		break;
	case "net_wgt":
		if (document.getElementById("net_wgt").value.length > 7) {
			if (document.getElementById("net_wgt").value.indexOf(".") > -1) {
			} else {
				document.getElementById("net_wgt").value=document.getElementById("net_wgt").value.substr(0, 7);
			}
		}
		sheetObjects[1].SetCellValue(row, "net_wgt",document.getElementById("net_wgt").value,0);
		break;
	case "cmdt_cd":
		sheetObjects[1].SetCellValue(row, "cmdt_cd",document.getElementById("cmdt_cd").value,0);
		break;
	case "cmdt_nm":
		sheetObjects[1].SetCellValue(row, "cmdt_desc",document.getElementById("cmdt_nm").value,0);
		break;
	case "cdo_temp":
		sheetObjects[1].SetCellValue(row, "cdo_temp",document.getElementById("plusMinus1").value+document.getElementById("cdo_temp").value,0);
		break;
	case "fdo_temp":
		sheetObjects[1].SetCellValue(row, "fdo_temp",document.getElementById("plusMinus2").value+document.getElementById("fdo_temp").value,0);
		break;
	case "vent_rto":
		if (sheetObjects[1].GetCellValue(row, "cntr_vent_tp_cd") == "P") {
			sheetObjects[1].SetCellValue(row, "vent_rto",document.getElementById("vent_rto").value,0);
		} else {
			sheetObjects[1].SetCellValue(row, "cbm_per_hr_qty",document.getElementById("vent_rto").value,0);
		}
		break;
	case "pck_tp_cd":
		sheetObjects[1].SetCellValue(row, "pck_tp_cd",document.getElementById("pck_tp_cd").value,0);
		break;
	case "humid_no":
		sheetObjects[1].SetCellValue(row, "humid_no",document.getElementById("humid_no").value,0);
		break;
	case "pck_qty":
		sheetObjects[1].SetCellValue(row, "pck_qty",document.getElementById("pck_qty").value,0);
		break;
	case "pck_tp_cd":
		sheetObjects[1].SetCellValue(row, "pck_tp_cd",document.getElementById("pck_tp_cd").value,0);
		break;
	case "rf_dcgo_seq":
		sheetObjects[1].SetCellValue(row, "cntr_cgo_seq",document.getElementById("rf_dcgo_seq").value,0);
		sheetObjects[1].SetCellValue(row, "rf_dcgo_seq",document.getElementById("rf_dcgo_seq").value,0);
		break;
	case "sns_cgo_knd_cd":
		sheetObjects[1].SetCellValue(row, "sns_cgo_knd_cd",document.getElementById("sns_cgo_knd_cd").value,0);
		break;
	case "oxgn_rto":
		sheetObjects[1].SetCellValue(row, "oxgn_rto",document.getElementById("oxgn_rto").value,0);
		break;
	case "crbn_dxd_rto":
		sheetObjects[1].SetCellValue(row, "crbn_dxd_rto",document.getElementById("crbn_dxd_rto").value,0);
		break;
	}
}
function obj_blur() {
	var row=sheetObjects[1].GetSelectRow();
	switch (event.srcElement.name) {
	case "net_wgt":
		if (document.getElementById("bkg_no").value != "") {
			document.getElementById("net_wgt").value=sheetObjects[1].GetCellText(row, "net_wgt");
			if (Number(document.getElementById("grs_wgt").value.replaceStr(",")) < Number(document.getElementById("net_wgt").value.replaceStr(","))) {
				ComAlertFocus(document.getElementById("net_wgt"), ComGetMsg("BKG00491"));
				document.getElementById("net_wgt").value=document.getElementById("temp_net_wgt").value;
				sheetObjects[1].SetCellValue(row, "net_wgt",document.getElementById("temp_net_wgt").value);
			} else {
				document.getElementById("temp_net_wgt").value=sheetObjects[1].GetCellText(row, "net_wgt");
			}
			sheetObjects[1].SetCellValue(row, "modifyaproflg","Y",0);
		}
		break;
	case "grs_wgt":
		if (document.getElementById("bkg_no").value != "") {
			document.getElementById("grs_wgt").value=sheetObjects[1].GetCellText(row, "grs_wgt");
			if (Number(document.getElementById("grs_wgt").value.replaceStr(",")) < Number(document.getElementById("net_wgt").value.replaceStr(","))) {
				ComAlertFocus(document.getElementById("grs_wgt"), ComGetMsg("BKG00491"));
				document.getElementById("grs_wgt").value=document.getElementById("temp_grs_wgt").value;
				sheetObjects[1].SetCellValue(row, "grs_wgt",document.getElementById("temp_grs_wgt").value);
			} else {
				document.getElementById("temp_grs_wgt").value=sheetObjects[1].GetCellText(row, "grs_wgt")
			}
			sheetObjects[1].SetCellValue(row, "modifyaproflg","Y",0);
		}
		break;
	case "vent_rto":
		if (document.getElementById("cntr_vent_tp_cd").value == "P") {
			sheetObjects[1].SetCellValue(row, "vent_rto",document.getElementById("vent_rto").value,0);
		} else {
			sheetObjects[1].SetCellValue(row, "cbm_per_hr_qty",document.getElementById("vent_rto").value,0);
		}
	
	}
}
function obj_change() {
	var row=sheetObjects[1].GetSelectRow();
	var temp=0;
	switch (event.srcElement.name) {
	case "cntr_vent_tp_cd":
		sheetObjects[1].SetCellValue(Row, "cntr_vent_tp_cd",document.getElementById("cntr_vent_tp_cd").value);
		if (sheetObjects[1].GetCellValue(Row, "cntr_vent_tp_cd") == "P") {
			sheetObjects[1].SetCellValue(row, "vent_rto",document.getElementById("vent_rto").value,0);
			sheetObjects[1].SetCellValue(row, "cbm_per_hr_qty","",0);
		} else {
			sheetObjects[1].SetCellValue(row, "cbm_per_hr_qty",document.getElementById("vent_rto").value,0);
			sheetObjects[1].SetCellValue(row, "vent_rto","",0);
		}
		break;
	case "wgt_ut_cd1":
		document.getElementById("wgt_ut_cd2").value=document.getElementById("wgt_ut_cd1").value;
		sheetObjects[1].SetCellValue(row, "wgt_ut_cd",document.getElementById("wgt_ut_cd1").value,0);
		break;
	case "cntr_drn_cd":
		sheetObjects[1].SetCellValue(row, "cntr_drn_cd",document.getElementById("cntr_drn_cd").value,0);
		break;
	case "pck_tp_cd":
		sheetObjects[1].SetCellValue(row, "pck_tp_cd",(document.getElementById("pck_tp_cd").value).toUpperCase(),0);
		document.getElementById("pck_tp_cd").value=sheetObjects[1].GetCellValue(row, "pck_tp_cd");
		break;
	case "clng_tp_cd":
		sheetObjects[1].SetCellValue(row, "clng_tp_cd",document.getElementById("clng_tp_cd").value,0);
		break;
	case "plusMinus1":
		if (document.getElementById("plusMinus1").value == "-") {
			sheetObjects[1].SetCellValue(row, "cdo_temp",document.getElementById("plusMinus1").value + document.getElementById("cdo_temp").value,0);
		} else {
			sheetObjects[1].SetCellValue(row, "cdo_temp",document.getElementById("cdo_temp").value,0);
		}
		if (document.getElementById("cdo_temp").value == "0") {
			sheetObjects[1].SetCellValue(row, "cdo_temp",document.getElementById("cdo_temp").value,0);
		}
		if (document.getElementById("plusMinus1").value == "-") {
			temp=document.getElementById("plusMinus1").value + document.getElementById("cdo_temp").value;
		} else {
			temp=document.getElementById("cdo_temp").value;
		}
		if(document.getElementById("cdo_temp").value==""){
			sheetObjects[1].SetCellValue(row, "fdo_temp","",0);
			document.getElementById("fdo_temp").value = "";
			break;
		}
//		var fdo_temp=(9 / 5) * parseFloat(temp) + 32; 
//		var fdo_temp=(Math.round(((9 / 5) * parseFloat(temp) + 32) * 10)/10).toFixed(1);
		var fdo_temp=getFtempFromC(temp); //Get Fahrenheit temperature
		if (String(fdo_temp).indexOf("-") > -1) {
			document.getElementById("plusMinus2").value="-";
			sheetObjects[1].SetCellValue(row, "fdo_temp",fdo_temp,0);
			document.getElementById("fdo_temp").value=sheetObjects[1].GetCellValue(row, "fdo_temp").replace("-", "");
		} else {
			document.getElementById("plusMinus2").value="+";
			sheetObjects[1].SetCellValue(row, "fdo_temp",fdo_temp,0);
			document.getElementById("fdo_temp").value=sheetObjects[1].GetCellValue(row, "fdo_temp");
		}
		break;
	case "plusMinus2":
		if (document.getElementById("plusMinus2").value == "-") {
			sheetObjects[1].SetCellValue(row, "fdo_temp",document.getElementById("plusMinus2").value + document.getElementById("fdo_temp").value,0);
		} else {
			sheetObjects[1].SetCellValue(row, "fdo_temp",document.getElementById("fdo_temp").value,0);
		}
		if (document.getElementById("fdo_temp").value == "0") {
			sheetObjects[1].SetCellValue(row, "fdo_temp",document.getElementById("fdo_temp").value,0);
		}
		if (document.getElementById("plusMinus2").value == "-") {
			temp=document.getElementById("plusMinus2").value + document.getElementById("fdo_temp").value;
		} else {
			temp=document.getElementById("fdo_temp").value;
		}
		if(document.getElementById("fdo_temp").value==""){
			sheetObjects[1].SetCellValue(row, "cdo_temp","",0);
			document.getElementById("cdo_temp").value = "";
			break;
		}
//		var cdo_temp=((5 * parseFloat(temp) ) - 160) / 9; 
//		var cdo_temp=(Math.round(((5 * parseFloat(temp)) - 160) / 9 * 10)/10).toFixed(1);
		var cdo_temp=getCtempFromF(temp); //Get Celsius temperature
		if (String(cdo_temp).indexOf("-") > -1) {
			document.getElementById("plusMinus1").value="-";
			sheetObjects[1].SetCellValue(row, "cdo_temp",cdo_temp,0);
			document.getElementById("cdo_temp").value=sheetObjects[1].GetCellValue(row, "cdo_temp").replace("-", "");
		} else {
			document.getElementById("plusMinus1").value="+";
			sheetObjects[1].SetCellValue(row, "cdo_temp",cdo_temp,0);
			document.getElementById("cdo_temp").value=sheetObjects[1].GetCellValue(row, "cdo_temp");
		}
		break;
	case "cdo_temp":
		if (document.getElementById("plusMinus1").value == "-") {
			sheetObjects[1].SetCellValue(row, "cdo_temp",document.getElementById("plusMinus1").value + document.getElementById("cdo_temp").value,0);
		} else {
			sheetObjects[1].SetCellValue(row, "cdo_temp",document.getElementById("cdo_temp").value,0);
		}
		if (document.getElementById("cdo_temp").value == "0") {
			sheetObjects[1].SetCellValue(row, "cdo_temp",document.getElementById("cdo_temp").value,0);
		}
		if (document.getElementById("plusMinus1").value == "-") {
			temp=document.getElementById("plusMinus1").value + document.getElementById("cdo_temp").value;
		} else {
			temp=document.getElementById("cdo_temp").value;
		}
		if(document.getElementById("cdo_temp").value==""){
			sheetObjects[1].SetCellValue(row, "fdo_temp","",0);
			document.getElementById("fdo_temp").value = "";
			break;
		}
//	  var fdo_temp=(9 / 5) * parseFloat(temp) + 32;  
//	  var fdo_temp=(Math.round(((9 / 5) * parseFloat(temp) + 32) * 10)/10).toFixed(1);
		var fdo_temp=getFtempFromC(temp); //Get Fahrenheit temperature
		if (String(fdo_temp).indexOf("-") > -1) {
			document.getElementById("plusMinus2").value="-";
			sheetObjects[1].SetCellValue(row, "fdo_temp",fdo_temp,0);
			document.getElementById("fdo_temp").value=sheetObjects[1].GetCellValue(row, "fdo_temp").replace("-", "");
		} else {
			document.getElementById("plusMinus2").value="+";
			sheetObjects[1].SetCellValue(row, "fdo_temp",fdo_temp,0);
			document.getElementById("fdo_temp").value=sheetObjects[1].GetCellValue(row, "fdo_temp");
		}
		break;
	case "fdo_temp":
		if (document.getElementById("plusMinus2").value == "-") {
			sheetObjects[1].SetCellValue(row, "fdo_temp",document.getElementById("plusMinus2").value + document.getElementById("fdo_temp").value,0);
		} else {
			sheetObjects[1].SetCellValue(row, "fdo_temp",document.getElementById("fdo_temp").value,0);
		}
		if (document.getElementById("fdo_temp").value == "0") {
			sheetObjects[1].SetCellValue(row, "fdo_temp",document.getElementById("fdo_temp").value,0);
		}
		if (document.getElementById("plusMinus2").value == "-") {
			temp=document.getElementById("plusMinus2").value + document.getElementById("fdo_temp").value;
		} else {
			temp=document.getElementById("fdo_temp").value;
		}
		if(document.getElementById("fdo_temp").value==""){
			sheetObjects[1].SetCellValue(row, "cdo_temp","",0);
			document.getElementById("cdo_temp").value = "";
			break;
		}
//		var cdo_temp=((5 * parseFloat(temp)) - 160) / 9
//		var cdo_temp=(Math.round(((5 * parseFloat(temp)) - 160) / 9 * 10)/10).toFixed(1); 
		var cdo_temp=getCtempFromF(temp); //Get Celsius temperature
		if (String(cdo_temp).indexOf("-") > -1) {
			document.getElementById("plusMinus1").value="-";
			sheetObjects[1].SetCellValue(row, "cdo_temp",cdo_temp);
			document.getElementById("cdo_temp").value=sheetObjects[1].GetCellValue(row, "cdo_temp").replace("-", "");
		} else {
			document.getElementById("plusMinus1").value="+";
			sheetObjects[1].SetCellValue(row, "cdo_temp",cdo_temp,0);
			document.getElementById("cdo_temp").value=sheetObjects[1].GetCellValue(row, "cdo_temp");
		}
		break;

	case "grs_wgt":
		sheetObjects[1].SetCellValue(row, "grs_wgt",document.getElementById("grs_wgt").value,0);
		break;
	case "net_wgt":
		sheetObjects[1].SetCellValue(row, "net_wgt",document.getElementById("net_wgt").value,0);
		break;
	case "sns_cgo_knd_cd":
		sheetObjects[1].SetCellValue(row, "sns_cgo_knd_cd",document.getElementById("sns_cgo_knd_cd").value,0);
		break;
	
	}
}
function obj_click() {
	var row=sheetObjects[1].GetSelectRow();
	switch (event.srcElement.name) {
	case "ctrl_atms_flg":
		if (document.getElementById("ctrl_atms_flg").checked == true) {
			sheetObjects[1].SetCellValue(row, "ctrl_atms_flg","Y");
			$('#oxgn_rto').attr('disabled',false);
			$('#crbn_dxd_rto').attr('disabled',false);
		} else {
			sheetObjects[1].SetCellValue(row, "ctrl_atms_flg","N");
			$('#oxgn_rto').attr('disabled',true);
			$('#crbn_dxd_rto').attr('disabled',true);
			$('#oxgn_rto').val('');
			$('#crbn_dxd_rto').val('');
			sheetObjects[1].SetCellValue(row, "oxgn_rto",'',0);
			sheetObjects[1].SetCellValue(row, "crbn_dxd_rto",'',0);
		}
		break;
	case "modi_atms_flg":
		if (document.getElementById("modi_atms_flg").checked == true) {
			sheetObjects[1].SetCellValue(row, "modi_atms_flg","Y");
		} else {
			sheetObjects[1].SetCellValue(row, "modi_atms_flg","N");
		}
		break;
	case "humid_ctrl_flg":
		if (document.getElementById("humid_ctrl_flg").checked == true) {
			sheetObjects[1].SetCellValue(row, "humid_ctrl_flg","Y");
		} else {
			sheetObjects[1].SetCellValue(row, "humid_ctrl_flg","N");
		}
		break;
	case "grs_wgt":
		if (sheetObjects[1].GetCellValue(row, "grs_wgt") == "0") {
			document.getElementById("grs_wgt").value="";
		}
		break;
	case "net_wgt":
		if (sheetObjects[1].GetCellValue(row, "net_wgt") == "0") {
			document.getElementById("net_wgt").value="";
		}
		break;
	}
}
/**
* setting sheet initial values and header
* @param sheetObj
* @param sheetNo
* @return
*/
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch (sheetNo) {
	case 1: //sheet1 init
	    with(sheetObj){
        
	      var HeadTitle1="TP/SZ|BKG Q'ty|RF Q'ty";
	
	      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	      InitHeaders(headers, info);
	
	      var cols = [ {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:"op_cntr_qty",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:0,   SaveName:"rf_cgo_qty",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 } ];
	       
	      InitColumns(cols);
	
	      SetEditable(1);
	      SetSheetHeight(102);
	   }

		break;
	case 2: //sheet2 init
	    with(sheetObj){
        
     var HeadTitle1="|ibflag|Seq.|Container No.|TS|Vol.|Genset|Volt|Appr.|bkg_no|rc_seq|cmdt_cd|cmdt_nm|cdo_temp|" + "fdo_temp|clng_tp_cd|cntr_vent_tp_cd|vent_rto|cbm_per_hr_qty|humid_no|pck_qty|grs_wgt|pck_tp_cd|net_wgt|wgt_ut_cd|" + "rf_dcgo_seq|ctrl_atms_flg|modi_atms_flg|humid_ctrl_flg|cntr_drn_cd|diff_rmk|modifyaproflg|por_cd|del_cd|rcv_term_cd|de_term_cd|apro_cd";

      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
      InitHeaders(headers, info);

      var cols = [ {Type:"DummyCheck", Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"DelChk" },
             {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
             {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
             {Type:"Combo",     Hidden:0, Width:95,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
             {Type:"Float",     Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"cntr_vol_qty",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"CheckBox",  Hidden:0, Width:65,   Align:"Center",  ColMerge:0,   SaveName:"pwr_spl_cbl_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"vltg_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_apro_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 ,InsertEdit:0},
             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"rc_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"cmdt_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"cmdt_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"cdo_temp",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1 },
             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"fdo_temp",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1 },
             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"clng_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"cntr_vent_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"vent_rto",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"cbm_per_hr_qty",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"humid_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"pck_qty",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
             {Type:"Float",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"grs_wgt",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:3,   UpdateEdit:1 },
             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"pck_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
             {Type:"Float",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"net_wgt",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:3,   UpdateEdit:1 },
             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"wgt_ut_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"rf_dcgo_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ctrl_atms_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"modi_atms_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"humid_ctrl_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"cntr_drn_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"diff_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"modifyaproflg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"cntr_cgo_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"por_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"del_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"rcv_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"de_term_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"apro_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"rqst_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"aply_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"sns_cgo_knd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"oxgn_rto",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"crbn_dxd_rto",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 } ];
       
      InitColumns(cols);
      SetSheetHeight(170);
      SetEditable(1);
            }


		break;
	case 3: //sheet3 init
	    with(sheetObj){
        
      var HeadTitle1="bkg_no|bl_no|tvvd|pol_cd|pol_nod_cd|pod_cd|pod_nod_cd|rcv_term_cd|de_term_cd|bkg_sts_cd|corr_n1st_dt|bdr_flg|pck_qty|pck_tp_cd|grs_wgt|wgt_ut_cd|corr_no";

      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:0 } );

      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
      InitHeaders(headers, info);

      var cols = [ {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"bl_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"vsl_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"pol_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"pol_nod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"pod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"pod_nod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rcv_term_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"de_term_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"bkg_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"corr_n1st_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"bdr_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"pck_qty",         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"pck_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"grs_wgt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"wgt_ut_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"corr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"cmdt_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"cmdt_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"vsl_pre_pst_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
       
      InitColumns(cols);
      SetVisible(false);
      SetEditable(1);
      
            }


		break;
	case 4: //sheet4 init
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
      SetVisible(false);
      SetEditable(1);
      //SetSheetHeight(80);
            }
		break;
	}
}
// /**
// * calling fnCheckFdoTemp function<br>
// * @param _val
// * @return string
// */
// function fnCheckFdoTemp(_val) {
//	var r_fvalue=(9 / 5) * parseFloat(_val) + 32; 
// 	return r_fvalue;
// }
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: //retrieve
		if (validateForm(sheetObj, formObj, sAction))
			formObj.f_cmd.value=SEARCH;
		var resultXml=sheetObj.GetSearchData("ESM_BKG_0498GS.do", FormQueryString(formObj));
		var arrXml=resultXml.split("|$$|");
		if (arrXml.length == 4) {
			var etcXml=arrXml[0];
			if (ComGetEtcData(etcXml, "rqst_dt") == "null" || ComGetEtcData(etcXml, "rqst_dt") == "") {
				 $("#rqst_dt").val("");
				 $("#rqst_gdt").val("");
				 $("#rqst_usr_id").val("");
				//document.getElementById("rqst_dt").innerText="";
				//document.getElementById("rqst_gdt").innerText="";
				//document.getElementById("rqst_usr_id").innerText="";
			} else {
				 $("#rqst_dt").val(ComGetEtcData(etcXml, "rqst_dt"));
				 $("#rqst_gdt").val(ComGetEtcData(etcXml, "rqst_gdt"));
				 $("#rqst_usr_id").val(ComGetEtcData(etcXml, "rqst_usr_id"));
				 
				//document.getElementById("rqst_dt").innerText=ComGetEtcData(etcXml, "rqst_dt");
				//document.getElementById("rqst_gdt").innerText=ComGetEtcData(etcXml, "rqst_gdt");
				//document.getElementById("rqst_usr_id").innerText=ComGetEtcData(etcXml, "rqst_usr_id");
			}
			if (arrXml[3].indexOf("TOTAL='0'") < 1) {
				var arrCombo=ComXml2ComboString(arrXml[3], "val", "name");
				sheetObjects[1].SetColProperty("cntr_no", {ComboText:"|"+arrCombo[0], ComboCode:"|"+arrCombo[1]} );
			}
			sheetObjects[0].LoadSearchData(arrXml[1],{Sync:1} );
			sheetObjects[1].LoadSearchData(arrXml[0],{Sync:1} );
			sheetObjects[2].LoadSearchData(arrXml[2],{Sync:1} );
			sheetObjects[3].LoadSearchData(arrXml[3],{Sync:1} );
//			if(sheetObjects[1].GetCellValue(1, "bkg_no") == -1){
//				ComShowCodeMessage("BKG00273");
//				return false;
//			}
			if(sheetObjects[0].RowCount() < 1){
				ComShowMessage(ComGetMsg("BKG00502"));
//				ComResetAll();
				return;
			}
			if (document.getElementById("bkg_no").value == "") {
				document.getElementById("bkg_no").value=sheetObjects[1].GetCellValue(1, "bkg_no");
			}
			document.getElementById("bl_no").value=(sheetObjects[2].GetCellValue(1, "bl_no")==-1)?"":sheetObjects[2].GetCellValue(1, "bl_no");
			document.getElementById("tvvd").value=(sheetObjects[2].GetCellValue(1, "vsl_cd")==-1)?"":sheetObjects[2].GetCellValue(1, "vsl_cd");
			document.getElementById("pol_cd").value=(sheetObjects[2].GetCellValue(1, "pol_cd")==-1)?"":sheetObjects[2].GetCellValue(1, "pol_cd");
			document.getElementById("pod_cd").value=(sheetObjects[2].GetCellValue(1, "pod_cd")==-1)?"":sheetObjects[2].GetCellValue(1, "pod_cd");
			document.getElementById("pol_nod_cd").value=(sheetObjects[2].GetCellValue(1, "pol_nod_cd")==-1)?"":sheetObjects[2].GetCellValue(1, "pol_nod_cd");
			document.getElementById("pod_nod_cd").value=(sheetObjects[2].GetCellValue(1, "pod_nod_cd")==-1)?"":sheetObjects[2].GetCellValue(1, "pod_nod_cd");
			document.getElementById("package_sum").value=(sheetObjects[2].GetCellText(1, "pck_qty")==-1)?"":sheetObjects[2].GetCellText(1, "pck_qty");
			document.getElementById("pck_type_cd").value=(sheetObjects[2].GetCellValue(1, "pck_tp_cd")==-1)?"":sheetObjects[2].GetCellValue(1, "pck_tp_cd");
			document.getElementById("weight_sum").value=(sheetObjects[2].GetCellText(1, "grs_wgt")==-1)?"":sheetObjects[2].GetCellText(1, "grs_wgt");
			document.getElementById("wgt_ut").value=(sheetObjects[2].GetCellValue(1, "wgt_ut_cd")==-1)?"":sheetObjects[2].GetCellValue(1, "wgt_ut_cd");
			document.getElementById("old_bkg_no").value=(sheetObjects[2].GetCellValue(1, "bkg_no")==-1)?"":sheetObjects[2].GetCellValue(1, "bkg_no");
			for ( var j=1; j <= sheetObjects[1].RowCount(); j++) {
				if (sheetObjects[1].GetCellValue(j, "spcl_cgo_apro_cd") == "N") {
					sheetObjects[1].SetCellFontColor(j, "spcl_cgo_apro_cd","#FF0000");
					sheetObjects[1].SetCellFont("FontBold", j, "spcl_cgo_apro_cd",1);
				}
				sheetObjects[1].SetCellValue(j, "Seq",j,0);
				sheetObjects[1].SetCellValue(j, "ibflag","R",0);
				if (sheetObjects[1].GetCellValue(j, "cntr_no") != "") {
					var cntr_no=sheetObjects[1].GetCellValue(j, "cntr_no");
					var find_row=sheetObjects[3].FindText("name", cntr_no, 0, 2);
					sheetObjects[3].SetCellValue(find_row, "DelChk","1",0);
				}
			}
			htmlSheetSync();
			/*
			var cntr_name="";
			var cntr_val="";														
			for (var j=1; j<=sheetObjects[3].RowCount(); j++){
if(sheetObjects[3].GetCellValue(j, "DelChk") == "0"){
cntr_name += sheetObjects[3].GetCellValue(j, "name")+"|";
cntr_val += sheetObjects[3].GetCellValue(j, "val")+"|";
				} 									
			}							
			cntr_val=cntr_val.substr(0,cntr_val.length-1);	
			cntr_name=cntr_name.substr(0,cntr_name.length-1);							    
			var checkCntr=sheetObjects[3].FindText("DelChk", "0", 0, 2);
			for (var i=1; i<=sheetObjects[1].RowCount(); i++){
			   if(checkCntr > 0) {
if(sheetObjects[1].GetCellValue(i, "cntr_no") != ""){
					   sheetObjects[1].CellComboItem(i,"cntr_no", {ComboText:"|"+sheetObjects[1].CellValue(i, ComboCode:"cntr_no")+"|"+cntr_name} );
					   sheetObjects[1].SetCellEditable(i,"cntr_tpsz_cd",0);
					   sheetObjects[1].SetCellEditable(i,"cntr_vol_qty",0);
				   }else{									   
					  sheetObjects[1].CellComboItem(i,"cntr_no", {ComboText:"|"+cntr_name, ComboCode:"|"+cntr_val} );
					  sheetObjects[1].SetCellEditable(i,"cntr_tpsz_cd",1);
					  sheetObjects[1].SetCellEditable(i,"cntr_vol_qty",1);
				   }
			   }else{
if(sheetObjects[1].GetCellValue(i, "cntr_no") != ""){
					   sheetObjects[1].CellComboItem(i,"cntr_no", {ComboText:"|"+sheetObjects[1].CellValue(i, ComboCode:"cntr_no")+"|"+cntr_name} );
					   sheetObjects[1].SetCellEditable(i,"cntr_tpsz_cd",0);
					   sheetObjects[1].SetCellEditable(i,"cntr_vol_qty",0);
				   }else{									   
					  sheetObjects[1].CellComboItem(i,"cntr_no", {ComboText:"|"+cntr_name, ComboCode:"|"+cntr_val} );
					  sheetObjects[1].SetCellEditable(i,"cntr_tpsz_cd",1);
					  sheetObjects[1].SetCellEditable(i,"cntr_vol_qty",1);
				   }								   
			   }
			}						   
			 */
			var tpszN=sheetObjects[1].FindText("spcl_cgo_apro_cd", "N", 0, 2);
			var tpszP=sheetObjects[1].FindText("spcl_cgo_apro_cd", "P", 0, 2);
			var tpszR=sheetObjects[1].FindText("spcl_cgo_apro_cd", "R", 0, 2);
			var tpszY=sheetObjects[1].FindText("spcl_cgo_apro_cd", "Y", 0, 2);
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
			if (sheetObjects[1].RowCount()< 1 && document.getElementById("bl_no").value != "") {
				document.getElementById("auth_cd").value="";
				checkAdd();
			} else if (sheetObjects[1].RowCount()< 1 && document.getElementById("auth_cd").value == "") {
				ComShowCodeMessage("BKG00183", document.getElementById("bkg_no").value);
				return;
			}
		}
		//------------------------------------------------>
		//calling setInquiryDisableButton event
		if (ComGetObjValue(document.form.isInquiry) == "Y") {
			setInquiryDisableButton();
		}
		break;
	case COMMAND04: //booking split noretrieve 
		formObj.f_cmd.value=COMMAND03;
		var param="&f_cmd=" + COMMAND03 + "&bkg_no=" + ComGetObjValue(formObj.bkg_no);
		var sXml=sheetObj.GetSearchData("ESM_BKG_0079_01GS.do", param);
		var bkg_split_no_list=ComGetEtcData(sXml, "bkg_split_no_list");
		bkgSplitNoListPop(formObj.bkg_no, bkg_split_no_list, 20);
		break;
	case IBSAVE: 
		if (validateForm(sheetObj, formObj, sAction)){
			if (sheetObjects[2].GetCellValue(1, "corr_no") == "" && sheetObjects[2].GetCellValue(1, "bdr_flg") == "Y") {
				ComShowMessage(ComGetMsg("BKG00004"));
				chkFlg="Y";
				return;
			}
		}

		var r_cnt=0;
		var d_cnt=0;
		var chilled_cnt=0;
		var frozen_cnt=0;
		var fresh_cnt=0;
		var cdo_temp=0;
		var fdo_temp=0;
		var chilled_seq=0;
		var frozen_seq=0;
		var fresh_seq=0;
		var cntrNo="";
		var oldCntrNo="";
		var rfChkFlg="N";
		for ( var i=1; i <= sheetObjects[1].RowCount(); i++) {
			//Validate Skip in case of delete
			if( sheetObjects[1].GetRowHidden(i) || sheetObjects[1].GetCellValue(i, "ibflag") == "D"){
				continue;
			}
			if (sheetObjects[1].GetCellValue(i, "apro_cd") != "C" || sheetObjects[1].GetCellValue(i, "spcl_cgo_apro_cd") != "C") {
				var seq=sheetObjects[1].GetCellValue(i, "Seq");
				if (sheetObjects[1].GetCellValue(i, "ibflag") == "R") {
					r_cnt++;
				}
				if (sheetObjects[1].GetCellValue(i, "ibflag") != "D") {
					d_cnt++;
				}
				if (sheetObjects[1].GetCellValue(i, "spcl_cgo_apro_cd") == "P") {
					ComShowMessage(ComGetMsg("BKG00500"));
					chkFlg="Y";
					return;
				}
				if (sheetObjects[1].GetCellValue(i, "cntr_tpsz_cd") == "") {
					ComShowCodeMessage("BKG08126", "[" + seq + "]");
					chkFlg="Y";
					sheetObjects[1].SelectCell(i, "cntr_tpsz_cd");
					return;
				}
				if (sheetObjects[1].GetCellValue(i, "cmdt_cd") == "") {
//					ComShowCodeMessage("BKG00510", "[" + seq + "]");
					ComShowCodeMessage("BKG95025", "Commodity [Seq : " + seq + " ]");
					
					chkFlg="Y";
					return;
				}
				if (sheetObjects[1].GetCellValue(i, "cdo_temp") == "" || sheetObjects[1].GetCellValue(i, "fdo_temp") == "") {
//					ComShowCodeMessage("BKG00611", "[" + seq + "]");
					ComShowCodeMessage("BKG95025", "Temperature [Seq : " + seq + " ]");
					chkFlg="Y";
					return;
				}
				if (ComTrim(sheetObjects[1].GetCellValue(i, "vent_rto")," ") == ""  && ComTrim(sheetObjects[1].GetCellValue(i, "cbm_per_hr_qty")," ") == ""){
					ComShowCodeMessage("BKG02089"); 
					chkFlg="Y";
					return;
				}
				if(sheetObjects[1].GetCellValue(i, "cntr_vent_tp_cd") == "P"){
					if(sheetObjects[1].GetCellValue(i, "vent_rto") > 100){
						ComShowCodeMessage("BKG00445", "less than 100 in Ventilation [Seq : " + seq + " ]"); 
						chkFlg="Y";
						return;
					}
				}
				if (sheetObjects[1].GetCellValue(i, "clng_tp_cd") == "") {
//					ComShowCodeMessage("BKG00612", "[" + seq + "]");
					ComShowCodeMessage("BKG95031", "Nature [Seq : " + seq + " ]");
					chkFlg="Y";
					return;
				}
				if (sheetObjects[1].GetCellValue(i, "grs_wgt") == "" || sheetObjects[1].GetCellValue(i, "grs_wgt") == "0") {
//					ComShowMessage(ComGetMsg("BKG00506"));
					ComShowCodeMessage("BKG95025", "Gross Weight [Seq : " + seq + " ]");
					chkFlg="Y";
					return;
				}
				if (sheetObjects[1].GetCellValue(i, "wgt_ut_cd") == "") {
//					ComShowMessage(ComGetMsg("BKG00507"));
					ComShowCodeMessage("BKG95031", "Gross Weight Type [Seq : " + seq + " ]");
					chkFlg="Y";
					return;
				}
				if (sheetObjects[1].GetCellValue(i, "clng_tp_cd") == "C" && Number(sheetObjects[1].GetCellValue(i, "cdo_temp")) < -5 && Number(sheetObjects[1].GetCellValue(i, "cdo_temp")) > 5) {
					chilled_cnt++;
					chilled_cdo_temp=Number(sheetObjects[1].GetCellValue(i, "cdo_temp"));
					chilled_fdo_temp=Number(sheetObjects[1].GetCellValue(i, "fdo_temp"));
					chilled_seq=seq;
				}
				if (sheetObjects[1].GetCellValue(i, "clng_tp_cd") == "F" && Number(sheetObjects[1].GetCellValue(i, "cdo_temp")) > -5) {
					frozen_cnt++;
					frozen_cdo_temp=Number(sheetObjects[1].GetCellValue(i, "cdo_temp"));
					frozen_fdo_temp=Number(sheetObjects[1].GetCellValue(i, "fdo_temp"));
					frozen_seq=seq;
				}
				if (sheetObjects[1].GetCellValue(i, "clng_tp_cd") == "S" && Number(sheetObjects[1].GetCellValue(i, "cdo_temp")) < 0) {
					fresh_cnt++;
					fresh_cdo_temp=Number(sheetObjects[1].GetCellValue(i, "cdo_temp"));
					fresh_fdo_temp=Number(sheetObjects[1].GetCellValue(i, "fdo_temp"));
					fresh_seq=seq;
				}
			}
			cntrNo=sheetObjects[1].GetCellValue(i, "cntr_no");
			oldCntrNo=sheetObjects[1].CellSearchValue(i, "cntr_no");
			if ( rfChkFlg == "N" && cntrNo != oldCntrNo ) {
				rfChkFlg="Y";
			}
		}

		if (r_cnt == sheetObjects[1].RowCount()) {
			if (reqFlag != "N") {
				ComShowMessage(ComGetMsg("BKG00501"));
			}
			chkFlg="Y";
			return;
		}
		if (chilled_cnt > 0) {
			ComShowCodeMessage("BKG00615", chilled_cdo_temp, chilled_fdo_temp, "[" + chilled_seq + "]");
			chkFlg="Y";
			return;
		}
		if (frozen_cnt > 0) {
			ComShowCodeMessage("BKG00616", frozen_cdo_temp, frozen_fdo_temp, "[" + frozen_seq + "]");
			chkFlg="Y";
			return;
		}
		if (fresh_cnt > 0) {
			ComShowCodeMessage("BKG00617", fresh_cdo_temp, fresh_fdo_temp, "[" + fresh_seq + "]");
			chkFlg="Y";
			return;
		}
		for ( var j=1; j <= sheetObjects[0].RowCount(); j++) {
			var cnt=0;
			var rcnt=0;
			var find_tpsz_cd="";
			for ( var m=1; m <= sheetObjects[1].RowCount(); m++) {
				if (sheetObjects[1].GetCellValue(m, "apro_cd") != "C" && sheetObjects[1].GetCellValue(m, "spcl_cgo_apro_cd") != "C"
					&& sheetObjects[1].GetCellValue(m, "ibflag") != "D") {
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
			if (cntr_tpsz_cd > 0) {
				if (Number(sheetObjects[0].GetCellValue(j, "rf_cgo_qty")) > cnt) {
					if (ComShowConfirm(ComGetMsg("BKG00678", "RF"))) {
						cnt=0;
					} else {
						chkFlg="Y";
						return;
					}
				}
				if (Number(sheetObjects[0].GetCellValue(j, "rf_cgo_qty")) < cnt) {
					ComShowCodeMessage("BKG00679", "RF");
					chkFlg="Y";
					return;
				}
			}
		}
		var sum=0;
		if (sheetObjects[0].RowCount()> 0) {
			sum=sheetObjects[0].ComputeSum("|2|");
		}
		if (sum == "0") {
			if (d_cnt > 0) {
				ComShowMessage(ComGetMsg("BKG00502", "RF"));
				chkFlg="Y";
				return;
			}
		}
		/*
		//var find_row = sheetObjects[1].FindText("modifyaproflg", "Y", 0, 2); 
		var requestCnt=0;
		for(var c=1; c <= sheetObjects[1].RowCount(); c++){
if(sheetObjects[1].GetCellValue(c, "spcl_cgo_apro_cd") != "P" && sheetObjects[1].GetCellValue(c, "spcl_cgo_apro_cd") != "C" && sheetObjects[1].GetCellValue(c, "spcl_cgo_apro_cd") != ""){
if(sheetObjects[1].GetCellValue(c, "modifyaproflg") == "Y"){
				requestCnt++; 	
			}
		}
		}  							
		if(requestCnt > 0 && reqFlag == "Y"){								
		if(ComShowConfirm(ComGetMsg("BKG00532"))){		 										 					
			reqFlag="N";
			}else{	
				chkFlg="Y";
				return;
			}
		}
		 */
		 var r_value=0;
		 var r_fdo_temp=0;
		 var r_cdo_temp=0;
		 var r_cnt=sheetObjects[1].RowCount();
		 if(r_cnt>0){
			 for(var c=1; c <= r_cnt; c++){
				//Validate Skip in case of delete
				if( sheetObjects[1].GetRowHidden(c) || sheetObjects[1].GetCellValue(c, "ibflag") == "D"){
					continue;
				}
//				r_fdo_temp=sheetObjects[1].GetCellValue(c, "fdo_temp");
//				r_cdo_temp=sheetObjects[1].GetCellValue(c, "cdo_temp");
				r_fdo_temp=parseFloat(sheetObjects[1].GetCellValue(c, "fdo_temp")).toFixed(1); // to compare by string
				r_cdo_temp=parseFloat(sheetObjects[1].GetCellValue(c, "cdo_temp")).toFixed(1);
//				r_value=fnCheckFdoTemp(r_cdo_temp);
//				if(Math.round(r_fdo_temp) != Math.round(r_value) ){
				//Check temperature values from both side to eliminate the effect of decimal rounding error
				if(getFtempFromC(r_cdo_temp)!=r_fdo_temp){
					if(getCtempFromF(r_fdo_temp)!=r_cdo_temp){
						ComShowCodeMessage("BKG08177", r_fdo_temp, r_value, "[" + c + "]");
						return ;
					}
				}
			 }
		 }
		formObj.f_cmd.value=MULTI;
		var sParam=FormQueryString(formObj);
		sParam=sParam + "&" + "rf_chk_flg=" + rfChkFlg;
		var sParamSheet1=sheetObjects[1].GetSaveString();
		sParam=sParam + "&sheet1_" + sParamSheet1.replace(/&/g, '&sheet1_');
		var rXml=sheetObj.GetSaveData("ESM_BKG_0498GS.do", sParam);
		var rMsg=ComResultMessage(rXml);
		var State=ComGetEtcData(rXml, ComWebKey.Trans_Result_Key);
		if(ComGetEtcData(rXml, "psaValCode") != "Y" && ComGetEtcData(rXml, "psaValCode") != undefined){						
			var errMsg01=ComGetEtcData(rXml,"psaValCode");
			/*
			 * null error
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
		var sParamSheet1=sheetObjects[1].GetSaveString();
		if (sParamSheet1 != "") {
			sParam=sParam + "&sheet1_" + sParamSheet1.replace(/&/g, '&sheet1_');
		}
		var rXml=sheetObj.GetSaveData("ESM_BKG_0498GS.do", sParam);
		var rMsg=ComResultMessage(rXml);
		var State=ComGetEtcData(rXml, ComWebKey.Trans_Result_Key);
		
		if(ComGetEtcData(rXml, "psaValCode") != "Y" && ComGetEtcData(rXml, "psaValCode") != undefined){						
			var errMsg01=ComGetEtcData(rXml,"psaValCode");
	    	var rmsg=errMsg01.split("<||>");
	    	if(rmsg[1] != undefined && rmsg[1].length > 0 && rmsg[1] == "BKG95027" ) {
	    		ComShowCodeMessage("BKG06125");
	    	}else if ( rmsg[1] != "BKG95025" ){
	    		ComShowMessage(rmsg[3]);
	    	}	
		}
		if (rMsg == '' && reqFlag == "N" && messageFlg == "request") {
			ComShowMessage(ComGetMsg("BKG08102"));
			retFlag="Y";
		} else if (rMsg == '' && reqFlag == "N" && messageFlg == "save") {
			//ComShowMessage(ComGetMsg("BKG00166"));
			retFlag="Y";
		} else if (rMsg == '' && reqFlag == "Y") {
		} else {
			sheetObj.LoadSearchData(rXml,{Sync:1} );
		}
		break;
	case COMMAND02:
		if (validateForm(sheetObj, formObj, sAction))
			formObj.f_cmd.value=COMMAND01;
		var sParam=FormQueryString(formObj);
		var sParamSheet1=sheetObjects[1].GetSaveString();
		if (sParamSheet1 != "") {
			sParam=sParam + "&sheet1_" + sParamSheet1.replace(/&/g, '&sheet1_');
		}
		var rXml=sheetObj.GetSaveData("ESM_BKG_0498GS.do", sParam);
		var rMsg=ComResultMessage(rXml);
		
		var State=ComGetEtcData(rXml, ComWebKey.Trans_Result_Key);
		if (rMsg == '' && reqFlag == "N" && messageFlg == "requestCancel") {
			ComShowMessage(ComGetMsg("BKG08103"));
			retFlag="Y";
		} else if (rMsg == '' && reqFlag == "N" && messageFlg == "save") {
			//ComShowMessage(ComGetMsg("BKG00166"));
			retFlag="Y";
		} else if (rMsg == '' && reqFlag == "Y") {
		} else {
			sheetObj.LoadSearchData(rXml,{Sync:1} );
		}
		break;
	case COMMAND05: //booking split noretrieve 
		if (validateForm(sheetObj, formObj, sAction)) {
			sheetObj.SetWaitImageVisible(0);
			cmdtFlg="1";
			formObj.f_cmd.value=COMMAND05;
			var rXml=sheetObj.GetSearchData("ESM_BKG_0498GS.do", FormQueryString(formObj));
			var cmdt_nm=ComGetEtcData(rXml, "cmdt_nm");
			document.getElementById("cmdt_nm").value=cmdt_nm;
			sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "cmdt_nm",cmdt_nm);
			sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "modifyaproflg","Y",0);
			sheetObj.SetWaitImageVisible(1);
			cmdtFlg="";
		} else {
			return false;
		}
		break;
	}
}
function htmlSheetSync() {
	Row=sheetObjects[1].GetSelectRow();
	if(Row<1)	return;
	
	document.getElementById("temp_cntr_no").value=sheetObjects[1].GetCellValue(Row, "cntr_no");
	document.getElementById("seq").value=sheetObjects[1].GetCellValue(Row, "Seq");
	document.getElementById("cmdt_cd").value=sheetObjects[1].GetCellValue(Row, "cmdt_cd");
	document.getElementById("cmdt_nm").value=sheetObjects[1].GetCellValue(Row, "cmdt_desc");
	document.getElementById("cntr_tpsz_cd").value=sheetObjects[1].GetCellValue(Row, "cntr_tpsz_cd");
	document.getElementById("aply_no").value=sheetObjects[1].GetCellValue(Row, "aply_no");
	
	if(Row>0){
		if (sheetObjects[1].GetCellValue(Row, "cdo_temp").indexOf("-") == 0) {
			document.getElementById("cdo_temp").value=sheetObjects[1].GetCellValue(Row, "cdo_temp").replace("-", "");
			document.getElementById("plusMinus1").value="-";
		} else {
			document.getElementById("cdo_temp").value=sheetObjects[1].GetCellValue(Row, "cdo_temp");
			document.getElementById("plusMinus1").value="+"; 
		}
		if (sheetObjects[1].GetCellValue(Row, "fdo_temp").indexOf("-") == 0) {
			document.getElementById("fdo_temp").value=sheetObjects[1].GetCellValue(Row, "fdo_temp").replace("-", "");
			document.getElementById("plusMinus2").value="-";
		} else {
			document.getElementById("fdo_temp").value=sheetObjects[1].GetCellValue(Row, "fdo_temp");
			document.getElementById("plusMinus2").value="+";
		}
		if (sheetObjects[1].GetCellValue(Row, "cdo_temp") == "0" && sheetObjects[1].GetCellValue(Row, "fdo_temp") == "0") {
			document.getElementById("cdo_temp").value="";
			document.getElementById("fdo_temp").value="";
		} 	
	}
	document.getElementById("clng_tp_cd").value=sheetObjects[1].GetCellValue(Row, "clng_tp_cd");
	document.getElementById("cntr_vent_tp_cd").value=sheetObjects[1].GetCellValue(Row, "cntr_vent_tp_cd");
	if (sheetObjects[1].GetCellValue(Row, "cntr_vent_tp_cd") == "P") {
		document.getElementById("vent_rto").value=sheetObjects[1].GetCellValue(Row, "vent_rto");
	} else {
		document.getElementById("vent_rto").value=sheetObjects[1].GetCellValue(Row, "cbm_per_hr_qty");
	}
	if (sheetObjects[1].GetCellValue(Row, "ctrl_atms_flg") == "Y") {
		document.getElementById("ctrl_atms_flg").checked=true;
		$('#oxgn_rto').attr('disabled',false);					//by kimtk. 2015.06.12 : O2,CO2 ,Sensitive Cargo 추가
		$('#crbn_dxd_rto').attr('disabled',false);
		$('#oxgn_rto').val(sheetObjects[1].GetCellValue(Row, "oxgn_rto"));
		$('#crbn_dxd_rto').val(sheetObjects[1].GetCellValue(Row, "crbn_dxd_rto"));
	} else {
		document.getElementById("ctrl_atms_flg").checked=false;
		$('#oxgn_rto').attr('disabled',true);					//by kimtk. 2015.06.12 : O2,CO2 ,Sensitive Cargo 추가
		$('#crbn_dxd_rto').attr('disabled',true);
		$('#oxgn_rto').val("");
		$('#crbn_dxd_rto').val("");
	}
	if (sheetObjects[1].GetCellValue(Row, "modi_atms_flg") == "Y") {
		document.getElementById("modi_atms_flg").checked=true;
	} else {
		document.getElementById("modi_atms_flg").checked=false;
	}
	if (sheetObjects[1].GetCellValue(Row, "humid_ctrl_flg") == "Y") {
		document.getElementById("humid_ctrl_flg").checked=true;
	} else {
		document.getElementById("humid_ctrl_flg").checked=false;
	}
	if (sheetObjects[1].GetCellValue(Row, "ctrl_atms_flg") == "Y") {
		document.getElementById("ctrl_atms_flg").checked=true;
	} else {
		document.getElementById("ctrl_atms_flg").checked=false;
	}
	if (sheetObjects[1].GetCellValue(Row, "modi_atms_flg") == "Y") {
		document.getElementById("modi_atms_flg").checked=true;
	} else {
		document.getElementById("modi_atms_flg").checked=false;
	}
	if (sheetObjects[1].GetCellValue(Row, "humid_ctrl_flg") == "Y") {
		document.getElementById("humid_ctrl_flg").checked=true;
	} else {
		document.getElementById("humid_ctrl_flg").checked=false;
	}
	document.getElementById("humid_no").value=sheetObjects[1].GetCellValue(Row, "humid_no");
	document.getElementById("pck_qty").value=sheetObjects[1].GetCellValue(Row, "pck_qty");
	document.getElementById("pck_tp_cd").value=sheetObjects[1].GetCellValue(Row, "pck_tp_cd");
	document.getElementById("grs_wgt").value=sheetObjects[1].GetCellText(Row, "grs_wgt");
	document.getElementById("temp_grs_wgt").value=sheetObjects[1].GetCellText(Row, "grs_wgt");
	document.getElementById("net_wgt").value=sheetObjects[1].GetCellText(Row, "net_wgt");
	document.getElementById("temp_net_wgt").value=sheetObjects[1].GetCellText(Row, "net_wgt");
	document.getElementById("wgt_ut_cd1").value=sheetObjects[1].GetCellValue(Row, "wgt_ut_cd");
	document.getElementById("wgt_ut_cd2").value=sheetObjects[1].GetCellValue(Row, "wgt_ut_cd");
	document.getElementById("rf_dcgo_seq").value=sheetObjects[1].GetCellValue(Row, "rf_dcgo_seq");
	document.getElementById("cntr_drn_cd").value=sheetObjects[1].GetCellValue(Row, "cntr_drn_cd");
	document.getElementById("diff_rmk").value=sheetObjects[1].GetCellValue(Row, "diff_rmk");
if (sheetObjects[1].RowCount()> 0 && sheetObjects[1].GetCellValue(Row, "diff_rmk").length > 0) {
		document.getElementById("btn_Remark").setAttribute("style", "font-weight: bold;color:blue!important");
	} else {
		document.getElementById("btn_Remark").setAttribute("style", "color:##A0BAED!important");
	}
if (sheetObjects[1].GetCellValue(Row, "spcl_cgo_apro_cd") == "C" || sheetObjects[1].GetCellValue(Row, "spcl_cgo_apro_cd") == "") {
		//document.getElementById("btn_RequestCancel").className="btn2_1";
		cancelFlg="Y";
	} else {
		//document.getElementById("btn_RequestCancel").className="btn2";
		cancelFlg="N";
	}

	//by kimtk. 2015.06.12 : O2,CO2 ,Sensitive Cargo 추가
	document.getElementById("sns_cgo_knd_cd").value=sheetObjects[1].GetCellValue(Row, "sns_cgo_knd_cd");
}
/**
 * fnCntrComboItem action event handling
 * @param sheetObj, Row, Col, Value
 */
function fnCntrComboItem(sheetObj, row, col, val) {
	var cntr_name="";
	var cntr_val="";
	for ( var j=1; j <= sheetObjects[3].RowCount(); j++) {
		if (sheetObjects[3].GetCellValue(j, "DelChk") == "0") {
			cntr_name += sheetObjects[3].GetCellValue(j, "name") + "|";
			cntr_val += sheetObjects[3].GetCellValue(j, "val") + "|";
		}
	}
	cntr_val=cntr_val.substr(0, cntr_val.length - 1);
	cntr_name=cntr_name.substr(0, cntr_name.length - 1);
	var checkCntr=sheetObjects[3].FindText("DelChk", "0", 0, 2);
	var i=row;
	if (checkCntr > 0) {
		if (val != "") {
			//sheetObjects[1].CellComboItem(i,"cntr_no", {ComboText:"|"+sheetObjects[1].CellValue(i, ComboCode:"cntr_no")+"|"+cntr_name} );  /*PARK*/
			sheetObjects[1].CellComboItem(i,"cntr_no", {ComboText:"|"+sheetObjects[1].GetCellValue(i, "cntr_no")+"|"+cntr_name, ComboCode:"|"+sheetObjects[1].GetCellValue(i, "cntr_no")+"|"+cntr_val} );  /*PARK*/
			sheetObjects[1].SetCellEditable(i, "cntr_tpsz_cd",0);
			sheetObjects[1].SetCellEditable(i, "cntr_vol_qty",0);
		} else {
			sheetObjects[1].CellComboItem(i,"cntr_no", {ComboText:"|"+cntr_name, ComboCode:"|"+cntr_val} );
			sheetObjects[1].SetCellEditable(i, "cntr_tpsz_cd",1);
			sheetObjects[1].SetCellEditable(i, "cntr_vol_qty",1);
		}
	} else {
		if (val != "") {
			//sheetObjects[1].CellComboItem(i,"cntr_no", {ComboText:"|"+sheetObjects[1].CellValue(i, ComboCode:"cntr_no")} );/*PARK*/
			sheetObjects[1].CellComboItem(i,"cntr_no", {ComboText:"|"+sheetObjects[1].GetCellValue(i, "cntr_no"), ComboCode:"|"+sheetObjects[1].GetCellValue(i, "cntr_no")} );/*PARK*/
			sheetObjects[1].SetCellEditable(i, "cntr_tpsz_cd",0);
			sheetObjects[1].SetCellEditable(i, "cntr_vol_qty",0);
		} else {
			sheetObjects[1].CellComboItem(i,"cntr_no", {ComboText:" |", ComboCode:"|"} );
			sheetObjects[1].SetCellEditable(i, "cntr_tpsz_cd",1);
			sheetObjects[1].SetCellEditable(i, "cntr_vol_qty",1);
		}
	}
}
/**
 * sheet2_OnClick action event handling
 * @param sheetObj, Row, Col, Value
 */
function sheet2_OnClick(sheetObj, row, col, val) {
	var col_name=sheetObj.ColSaveName(col);
	htmlSheetSync();
	switch (col_name) {
	case "cntr_no":
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
			var temp_find_row=sheetObjects[3].FindText("name", temp_cntr_no, 0, 2);
			if (temp_cntr_no != "") {
				sheetObjects[3].SetCellValue(temp_find_row, "DelChk","0");
			}
			var cntr_no=sheetObjects[1].GetCellValue(row, "cntr_no");
			var find_row=sheetObjects[3].FindText("name", cntr_no, 0, 2);
			if (sheetObjects[1].GetCellValue(row, "cntr_no") != "" && sheetObjects[1].GetCellValue(row, "cntr_tpsz_cd") != "" && sheetObjects[1].GetCellValue(row, "cntr_tpsz_cd") != sheetObjects[3].GetCellValue(find_row, "cntr_tpsz_cd")) {
				if (ComShowConfirm(ComGetMsg("BKG00570"))) {
					sheetObjects[1].SetCellValue(row, "cntr_tpsz_cd",sheetObjects[3].GetCellValue(find_row, "cntr_tpsz_cd"),0);
					document.getElementById("cntr_tpsz_cd").value=sheetObjects[3].GetCellValue(find_row, "cntr_tpsz_cd");
				} else {
					sheetObjects[1].SetCellValue(row, "cntr_no","",0);
					cntr_no="";
				}
			} else if (sheetObjects[1].GetCellValue(row, "cntr_tpsz_cd") == "") {
				sheetObjects[1].SetCellValue(row, "cntr_tpsz_cd",sheetObjects[3].GetCellValue(find_row, "cntr_tpsz_cd"),0);
				document.getElementById("cntr_tpsz_cd").value=sheetObjects[3].GetCellValue(find_row, "cntr_tpsz_cd");
			}
			sheetObjects[1].SetCellValue(row, "cntr_vol_qty",sheetObjects[3].GetCellValue(find_row, "cntr_vol_qty"),0);
			if (cntr_no != "") {
				sheetObjects[3].SetCellValue(find_row, "DelChk","1",0);
			}
			document.getElementById("temp_cntr_no").value=cntr_no;
			/*
			var cntr_name="";
			var cntr_val="";															
			for (var j=1; j<=sheetObjects[3].RowCount(); j++){
if(sheetObjects[3].GetCellValue(j, "DelChk") == "0"){
cntr_name += sheetObjects[3].GetCellValue(j, "name")+"|";
cntr_val += sheetObjects[3].GetCellValue(j, "val")+"|";
				} 									
			}											
			cntr_val=cntr_val.substr(0,cntr_val.length-1);	
			cntr_name=cntr_name.substr(0,cntr_name.length-1);					
			for (var i=1; i<=sheetObjects[1].RowCount(); i++){
if(sheetObjects[1].GetCellValue(i, "cntr_no") != ""){
					sheetObjects[1].CellComboItem(i,"cntr_no", {ComboText:"|"+sheetObjects[1].CellValue(i, ComboCode:"cntr_no")+"|"+cntr_name} );
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
			var temp_find_row=sheetObjects[3].FindText("name", temp_cntr_no, 0, 2);
			if (temp_cntr_no != "") {
				sheetObjects[3].SetCellValue(temp_find_row, "DelChk","0");
			}
			document.getElementById("temp_cntr_no").value="";
			/*
			var cntr_name="";
			var cntr_val="";															
			for (var j=1; j<=sheetObjects[3].LastRow(); j++){
if(sheetObjects[3].GetCellValue(j, "DelChk") == "0"){
cntr_name += sheetObjects[3].GetCellValue(j, "name")+"|";
cntr_val += sheetObjects[3].GetCellValue(j, "val")+"|";
				} 									
			}															
			cntr_val=cntr_val.substr(0,cntr_val.length-1);	
			cntr_name=cntr_name.substr(0,cntr_name.length-1);														
			for (var i=1; i<=sheetObjects[1].RowCount(); i++){
if(sheetObjects[1].GetCellValue(i, "cntr_no") != ""){
					   sheetObjects[1].CellComboItem(i,"cntr_no", {ComboText:"|"+sheetObjects[1].CellValue(i, ComboCode:"cntr_no")+"|"+cntr_name} );
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
	case "cntr_tpsz_cd":
		sheetObjects[1].SetCellValue(row, "cntr_tpsz_cd",(sheetObjects[1].GetCellValue(row, "cntr_tpsz_cd")).toUpperCase(),0);
		document.getElementById("cntr_tpsz_cd").value=sheetObjects[1].GetCellValue(row, "cntr_tpsz_cd");
		var find_row=sheetObjects[0].FindText("cntr_tpsz_cd", sheetObjects[1].GetCellValue(row, "cntr_tpsz_cd"), 0, 2);
		if (find_row > 0) {
			var cntrVolQty=Number(sheetObjects[0].GetCellValue(find_row, "rf_cgo_qty"));
		} else {
			var cntrVolQty="0";
		}
		if (cntrVolQty >= 1) {
			sheetObjects[1].SetCellValue(row, "cntr_vol_qty","1",0);
		} else if (cntrVolQty > 0 && cntrVolQty < 1) {
			sheetObjects[1].SetCellValue(row, "cntr_vol_qty",cntr_vol_qty,0);
		} else {
			sheetObjects[1].SetCellValue(row, "cntr_vol_qty","0",0);
		}
		break;
	case "cntr_vol_qty":
		if (Number(sheetObjects[1].GetCellValue(row, "cntr_vol_qty")) > 1) {
			ComShowMessage(ComGetMsg("BKG08013"));
		}
		var find_row=sheetObjects[0].FindText("cntr_tpsz_cd", sheetObjects[1].GetCellValue(row, "cntr_tpsz_cd"), 0, 2);
		if (sheetObjects[1].GetCellValue(row, "cntr_tpsz_cd") != "" && find_row > 0) {
			var cntrVolQty=Number(sheetObjects[0].GetCellValue(find_row, "rf_cgo_qty"));
		} else {
			var cntrVolQty="0";
		}
		if (cntrVolQty > 0) {
			if (Number(sheetObjects[1].GetCellValue(row, "cntr_vol_qty")) > 0 && Number(sheetObjects[1].GetCellValue(row, "cntr_vol_qty")) <= 1) {
			} else {
				sheetObjects[1].SetCellValue(row, "cntr_vol_qty","1",0);
			}
		} else {
			sheetObjects[1].SetCellValue(row, "cntr_vol_qty","0",0);
		}
		break;
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		//            if (!isNumber(formObj.iPage)) {
		//                return false;
		//            }
	}
	return true;
}
// Event after retrieve
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		SetColBackColor("RFQTY","#CCFFFD");
	}
}
	function sheet2_OnLoadFinish(sheetObj) {
	if (document.getElementById("bkg_no").value != "" || document.getElementById("bl_no").value != "") {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
}
/**
 * calling setInquiryDisableButton event .<br>
 * deactivating in case of ComBtnDisable
 * @param 
 */
function setInquiryDisableButton() {
	ComBtnDisable("btn_Save");
	ComBtnDisable("btn_Request");
}

/**
 * Get Fahrenheit temperature from Celsius <br>
 * @param _val (Celsius)
 * @return String (Fahrenheit)
 */
 function getFtempFromC(_val) {
	var f_temp=Math.round(((9 / 5) * parseFloat(_val) + 32) * 10) / 10; 
 	return f_temp.toFixed(1);
 }
 
 /**
  * Get Celsius temperature from Fahrenheit <br>
  * @param _val (Fahrenheit)
  * @return String (Celsius)
  */
  function getCtempFromF(_val) {
 	var c_temp=Math.round(((5 * parseFloat(_val)) - 160) / 9 * 10) / 10;
  	return c_temp.toFixed(1);
  }
