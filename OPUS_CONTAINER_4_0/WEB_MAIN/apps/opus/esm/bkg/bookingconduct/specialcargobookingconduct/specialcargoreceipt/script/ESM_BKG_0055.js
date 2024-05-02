/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   esm_bkg_0055.js
*@FileTitle  : Awakward Cargo Application 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
   Event distinction code: [Initialization]INIT=0; [Input]ADD=1; [Retrieve]SEARCH=2; [Retrieving List]SEARCHLIST=3;
					[Modification]MODIFY=4; [Delete]REMOVE=5; [Deleting list]REMOVELIST=6 [Multi-Processing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------The following code is added to make a good JSDoc ------------------*/
/**
 * @fileoverview As a java script file that uses common on business, it has been defined about calendar-related functions.
 * @author 
 */
/**
 * @extends
 * @class esm_bkg_0055 : It defines business script that using screen for
 *        esm_bkg_0055 creation.
 */
// Common global variables
var sheetObjects=new Array();
var sheetCnt=0;
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var comboObjects=new Array();
var comboCnt=0; 
var ttlCnt=0;
var reqFlag="";
var cancelFlg="";
var retFlag="";
var cmdtFlg="";
var messageFlg="";
var chkFlg="";
var sheet2SelectedRow=0;
var saveSuccess = "";

   /**
	 * Sheet basic setting & initializing onLoad Event HandlerImplementation of
	 * body tag After loading screen in the browser, add function in
	 * pre-processing
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
	rcv_term_cd.SetDropHeight(107);
	rcv_term_cd.SetColWidth(0, "20");
	rcv_term_cd.SetColWidth(1, "80");
	de_term_cd.SetDropHeight(107);
	de_term_cd.SetColWidth(0, "20");
	de_term_cd.SetColWidth(1, "80");
	crn_pst_sts_cd.SetDropHeight(150);
	crn_pst_sts_cd.SetColWidth(0, "20");
	crn_pst_sts_cd.SetColWidth(1, "150");
	doActionIBSheet(sheetObjects[5],document.form,INIT);
	// ------------------------------------------------>
	// setInquiryDisableButton event calling
	if (ComGetObjValue(document.form.isInquiry) == "Y") {
		setInquiryDisableButton();
	}
	initControl();
	
	if (document.getElementById("bkg_no").value != "" || document.getElementById("bl_no").value != "") {
		doActionIBSheet(sheetObjects[5], document.form, SEARCH);
	}
}
/**
 * Initializing ComboBox.
 * 
 * @param {IBMultiCombo}
 *            comboObj comboObj
 */
function initCombo(comboObj) {
	comboObj.SetMultiSelect(0);
	comboObj.SetColAlign(0, "left");
	comboObj.SetColAlign(1, "left");
	comboObj.SetMultiSeparator("|");
}
/**
 * Registering IBCombo Object in to comboObjects Array
 * 
 * @param {IBMultiCombo}
 *            combo_obj IBMultiCombo Object
 */
function setComboObject(combo_obj){
    comboObjects[comboCnt++]=combo_obj;
}
function initControl() {
	// Axon event processing1 event catch
	axon_event.addListenerForm('blur', 'obj_blur', form);
	axon_event.addListenerForm('click', 'obj_click', form);
	axon_event.addListenerForm('change', 'obj_change', form);
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form); 
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListenerForm('keyup', 'obj_keyup', form);
	axon_event.addListenerForm('keypress', 'obj_keypress', form);
	
	applyShortcut();
}
// Event Handler definition for Button Click event */
document.onclick=processButtonClick;
// Event Handler for branch processing by judging button name */
function processButtonClick() {
	 /** *** using extra sheet valuable if there are more 2 sheets **** */
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	var sheetObject3=sheetObjects[2];
	var sheetObject4=sheetObjects[3];
	var sheetObject5=sheetObjects[4];
	/** **************************************************** */
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
		// when bkg_split_no searching
		case "btn_splitPop":
			doActionIBSheet(sheetObject1, formObject, COMMAND04);
			break;
		// when searching
		case "btn_Retrieve":
			if (document.getElementById("bkg_no").value != "" || document.getElementById("bl_no").value != "") {
				doActionIBSheet(sheetObjects[0], document.form, SEARCH);
			}
			break;
		// when saving
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
					// Applying request logic in case reqFlag = N
					reqFlag="Y";
					// Applying request logic in case retFlag = Y
					retFlag="";
					// saving logic
					doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
					// in case save completed and searches again
					if (retFlag == "Y") {
						doActionIBSheet(sheetObjects[0], document.form, SEARCH);
					}
					ComOpenWait(false);
				} , 100);
			}
			break;
		// when Request
		case "btn_Request":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				var bkgNo=ComGetObjValue(formObject.bkg_no);
				if(!ComIsNull(formObject.old_bkg_no) && ComGetObjValue(formObject.old_bkg_no) != bkgNo){	
					ComShowMessage(ComGetMsg("BKG08356"));
					ComSetFocus(formObject.bkg_no);
    				return;    				
    			}
				
// move to btnRequestProcess() function
//				messageFlg="request";
//				chkFlg="N";
//				var iCnt=0;
//				var uCnt=0;
//				var dCnt=0;
//				// Applying request logic in case reqFlag = N
//				reqFlag="N";
//				// Applying request logic in case retFlag = Y
//				retFlag="";
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
//				for ( var i=1; i <= sheetObjects[3].RowCount(); i++) {
//					if (sheetObjects[3].GetCellValue(i, "ibflag") != "R") {
//						cntR++;
//					}
//				}
//				if (cntR > 0 && sheetObjects[2].GetCellValue(1, "bdr_flg") == "Y" && sheetObjects[2].GetCellValue(1, "corr_no") != "") {
//					ComShowMessage(ComGetMsg("BKG08076"));
//					return;
//				}
//				// whether inserted data exists
//				iCnt=sheetObjects[1].FindText("ibflag", "I", 0, 2);
//				// whether updated data exists
//				uCnt=sheetObjects[1].FindText("ibflag", "U", 0, 2);
//				// whether deleted data exists
//				dCnt=sheetObjects[1].FindText("ibflag", "D", 0, 2);
//				// in case insert, update, delete data exists
//				if (iCnt > 0 || uCnt > 0 || dCnt > 0) {
//					if (sheetObjects[2].GetCellValue(1, "bdr_flg") != "Y" && sheetObjects[2].GetCellValue(1, "corr_no") == "") {
//						// if(ComShowConfirm(ComGetMsg("BKG00824"))){
//						doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
//						// }else{
//						// return;
//						// }
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
//				var ncCnt=0;
//				var rCnt=0;
//				var yCnt=0;
//				for ( var i=1; i <= sheetObjects[1].RowCount(); i++) {
//					if (sheetObjects[1].GetCellValue(i, "spcl_cgo_apro_cd") == "P") {
//						ComShowMessage(ComGetMsg("BKG00500"));
//						return;
//					}
//					if (sheetObjects[1].GetCellValue(i, "spcl_cgo_apro_cd") == "N" || sheetObjects[1].GetCellValue(i, "spcl_cgo_apro_cd") == "C") {
//						// adds 1 a value in case appr. value is 'N' or 'P'
//						ncCnt++;
//					}
//					if (sheetObjects[1].GetCellValue(i, "spcl_cgo_apro_cd") == "R") {
//						// adds 1 rCnt value in case appr. value is 'R'
//						rCnt++;
//					}
//					if (sheetObjects[1].GetCellValue(i, "spcl_cgo_apro_cd") == "Y") {
//						// adds 1 yCnt value in case appr. value is 'Y'
//						yCnt++;
//					}
//				}
//				if (chkFlg != "Y") {
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
//					// saveEnd = Y in case saving logic is completed
//					// successfully or no saving data.
//					for ( var i=1; i <= sheetObjects[1].RowCount(); i++) {
//						// Setting apro_cd with 'R' in case appr. value is not
//						// 'C'
//						if (sheetObjects[1].GetCellValue(i, "spcl_cgo_apro_cd") != "C") {
//							sheetObjects[1].SetCellValue(i, "apro_cd","R",0);
//						}
//					}
//					doActionIBSheet(sheetObjects[0], document.form, COMMAND02);
//					// Applying inquiry logic in case request completed
//					// successfully
//					if (retFlag == "Y") {
//						// saving logic
//						doActionIBSheet(sheetObjects[0], document.form, SEARCH);
//					}
//				}
						
				//calculate OverDimension when Booking was uploaded from e-Booking 
				for(var i=1; i <= sheetObjects[1].RowCount(); i++){
					if(sheetObjects[1].GetCellValue(i, "spcl_cgo_apro_cd") == ""
						&& sheetObjects[1].GetCellValue(i, "ovr_fwrd_len") =="0"
						&& sheetObjects[1].GetCellValue(i, "ovr_bkwd_len") =="0"
						&& sheetObjects[1].GetCellValue(i, "ovr_rt_len") =="0"
						&& sheetObjects[1].GetCellValue(i, "ovr_lf_len") =="0"
						&& sheetObjects[1].GetCellValue(i, "ovr_hgt") =="0"
						&& sheetObjects[1].GetCellValue(i, "in_ga_flg") == "N"){
						sheetObjects[1].SetSelectRow(i);
						//calculate OverDimension
						overDimensionSettingHeight();
						overDimensionSettingWidth();
						overDimensionSettingLength();
					}
				}
				
				ComOpenWait(true);
				setTimeout( function () {
					btnRequestProcess();
				ComOpenWait(false);
				} , 100);
			}
			break;
		// when request cancel
		case "btn_RequestCancel":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
// move to btnRequestCancelProcess() function
//				chkFlg="N";
//				messageFlg="requestCancel";
//				// Applying request logic in case reqFlag = N
//				reqFlag="N";
//				// Applying inquiry logic in case retFlag = Y
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
//				// whether inserted data exists
//				iCnt=sheetObjects[1].FindText("ibflag", "I", 0, 2);
//				// whether updated data exists
//				uCnt=sheetObjects[1].FindText("ibflag", "U", 0, 2);
//				// whether deleted data exists
//				dCnt=sheetObjects[1].FindText("ibflag", "D", 0, 2);
//				// //in case insert, update, delete data exists
//				if (iCnt > 0 || uCnt > 0 || dCnt > 0) {
//					if (sheetObjects[2].GetCellValue(1, "bdr_flg") != "Y" && sheetObjects[2].GetCellValue(1, "corr_no") == "") {
//						// if(ComShowConfirm(ComGetMsg("BKG00824"))){
//						doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
//						// }else{
//						// return;
//						// }
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
//					if (ComShowConfirm(ComGetMsg("BKG00613", sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "seq")))) {
//						sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "apro_cd","C",0);
//						// request cancel logic
//						doActionIBSheet(sheetObjects[0], document.form, COMMAND03);
//						// Applying inquiry logic in case request cancel logic
//						// completed successfully
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
		// file attached pop-up
		case "btn_attach":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				var bkgNo=ComGetObjValue(formObject.bkg_no);
				if(!ComIsNull(formObject.old_bkg_no) && ComGetObjValue(formObject.old_bkg_no) != bkgNo){	
					ComShowMessage(ComGetMsg("BKG08356"));
					ComSetFocus(formObject.bkg_no);
    				return;    				
    			}
				
				// assigning ridr_tp_cd value to 'A' in case value is awk
				ComOpenPopup("ESM_BKG_0207.do?bkg_no=" + document.getElementById("bkg_no").value + "&ridr_tp_cd=A", 580, 520, "", "1,0", true);
			}
			break;
		// selected sheet data row copy pop-up
		case "btn_Copy":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				copyRowPopup();
			}
			break;
		// remark input pop-up
		case "btn_Remark":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				var url="ESM_BKG_0757.do";
				ComOpenWindowCenter(url, "ESM_BKG_0757", 420, 350, true);
			}
			break;
		// pol_cd pop-up
		case "btn_pol_cd":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				var pol_cd=document.getElementById("pol_cd").value;
				if (pol_cd == "") {
				} else {
					ComOpenPopup("VOP_VSK_0509Pop.do?loc_cd=" + pol_cd, 1200, 660, "", '0,0', false);
				}
			}
			break;
		// pod_cd pop-up
		case "btn_pod_cd":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				var pod_cd=document.getElementById("pod_cd").value;
				if (pod_cd == "") {
				} else {
					ComOpenPopup("VOP_VSK_0509Pop.do?loc_cd=" + pod_cd, 1200, 660, "", '0,0', false);
				}
			}
			break;
		// when add button click
		case "add_button":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				checkAdd();
			}
			break;
		// package type pop-up
		case "pck_button":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				comBkgCallModal0696("callbackPckTp", formObject.frm_pck_tp_cd.value);
			}
			break;
		// comodity code searching pop-up
		case "cmdt_button":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				ComOpenPopup("ESM_BKG_0653.do?cmdt_cd=" + formObject.cmdt_cd.value, 820, 530, "getCOM_CMDT_POPUP", '1,0,1,1,1,1,1', true, false, 0, 0, 0, "ESM_BKG_0653");
			}
			break;
		// when del button click
		case "del_button":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				deleteRows();
			}
			break;
		// criteria pop-up...
		case "criteria_button":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				var url="ESM_BKG_0057.do";
				ComOpenWindowCenter(url, "ESM_BKG_0057", 550, 450, true);
			}
			break;
		// when details button click ... dimension valut input/modify/delete
		// pop-up
		case "details_button":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				var url="ESM_BKG_0756.do?modalFlg=Y&sheetRow=" + sheetObject2.GetSelectRow();
				ComOpenWindowCenter(url, "ESM_BKG_0756", 470, 340, true);
				// ComOpenWindowCenter("ESM_BKG_0756.do?bkgNo=SHAZSX00018&awkCgoSeq=1",
				// "ESM_BKG_0756", 400, 300, true);
			}
			break;
		// approval inquiry pop-up...
		case "btn_approval":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				ComOpenPopup("VOP_SCG_1016.do?scg_flg=AK&bkg_no=" + formObject.bkg_no.value, 1100, 550, "", '0,0', true);
			}
			break;
		// DG container inquiry pop-up...
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
					var bkgNodata=document.getElementById("bkg_no").value;
					var cntrNo=document.getElementById("temp_cntr_no").value;
					var cntrTpszCd=document.getElementById("cntr_tpsz_cd").value;
					var url="ESM_BKG_0754.do?modalFlg=Y&bkgNo=" + bkgNodata + "&cntrNo=" + cntrNo + "&cntrTpszCd=" + cntrTpszCd;
					ComOpenWindowCenter(url, "ESM_BKG_0754", 805, 480, true);
					// ComOpenWindowCenter("ESM_BKG_0754.do?bkgNo="+bkgNo+"&cntrNo="+cntrNo+"&cntrTpszCd="+cntrTpszCd,
					// "ESM_BKG_0754", 805, 310, true);
				}
			}
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}
// selected data value from comodity pop-up setting function
function getCOM_CMDT_POPUP(rowArray) {
	var formObject=document.form;
	var colArray=rowArray[0];
	formObject.cmdt_cd.value=colArray[3];
	sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "cmdt_cd",colArray[3],0);
	formObject.cmdt_nm.value=colArray[4];
	sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "cmdt_nm",colArray[4],0);
	sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "modifyaproflg","Y",0);
}
// bkg_no setting function in case bkg_split_no value selected.
function bkgSplitNoList(split_list) {
	document.form.bkg_no.value=split_list.options[split_list.selectedIndex].value;
	layList.style.display="none";
}
// selected data value from package type code pop-up setting function
function callbackPckTp(returnVal) {
	document.form.frm_pck_tp_cd.value=returnVal.cd;
	sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "pck_tp_cd",returnVal.cd,0);
}
/**
 * Registering IBSheet Object in to Array<br>
 * Afterwards, when other items need to be batch processed,it can add to the
 * process that stores in to array<br>
 * The array is defined at upper part of source<br>
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}

function btnRequestProcess() {

	messageFlg="request";
	chkFlg="N";
	var iCnt=0;
	var uCnt=0;
	var dCnt=0;
	// Applying request logic in case reqFlag = N
	reqFlag="N";
	// Applying request logic in case retFlag = Y
	retFlag="";
	var reqCnt=0;
	for ( var i=1; i <= sheetObjects[1].RowCount(); i++) {
		if (sheetObjects[1].GetCellValue(i, "spcl_cgo_apro_cd") != "C") {
			reqCnt++;
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
	for ( var i=1; i <= sheetObjects[3].RowCount(); i++) {
		if (sheetObjects[3].GetCellValue(i, "ibflag") != "R") {
			cntR++;
		}
	}
	if (cntR > 0 && sheetObjects[2].GetCellValue(1, "bdr_flg") == "Y" && sheetObjects[2].GetCellValue(1, "corr_no") != "") {
		ComShowMessage(ComGetMsg("BKG08076"));
		return;
	}
////	setTimeout( function () {
//		
//	//calculate OverDimension when Booking was uploaded from e-Booking 
//	for(var i=1; i <= sheetObjects[1].RowCount(); i++){
////		if(sheetObjects[1].GetCellValue(i, "spcl_cgo_apro_cd") == ""
////			&& sheetObjects[1].GetCellValue(i, "ovr_fwrd_len") =="0"
////			&& sheetObjects[1].GetCellValue(i, "ovr_bkwd_len") =="0"
////			&& sheetObjects[1].GetCellValue(i, "ovr_rt_len") =="0"
////			&& sheetObjects[1].GetCellValue(i, "ovr_lf_len") =="0"
////			&& sheetObjects[1].GetCellValue(i, "ovr_hgt") =="0"
////			&& sheetObjects[1].GetCellValue(i, "in_ga_flg") == "N"){
////			sheetObjects[1].SetSelectRow(i);
//			//calculate OverDimension
//			overDimensionSettingLength();
//			overDimensionSettingWidth();
//			overDimensionSettingHeight();
//			
//			ComShowMessage(ComGetMsg("BKG08034"));
//			
////		}
//	}
////	ComOpenWait(false);
////	} , 100);
	

	// whether inserted data exists
	iCnt=sheetObjects[1].FindText("ibflag", "I", 0, 2);
	// whether updated data exists
	uCnt=sheetObjects[1].FindText("ibflag", "U", 0, 2);
	// whether deleted data exists
	dCnt=sheetObjects[1].FindText("ibflag", "D", 0, 2);
	// in case insert, update, delete data exists
	if (iCnt > 0 || uCnt > 0 || dCnt > 0) {
		if (sheetObjects[2].GetCellValue(1, "bdr_flg") != "Y" && sheetObjects[2].GetCellValue(1, "corr_no") == "") {
			// if(ComShowConfirm(ComGetMsg("BKG00824"))){
			saveSuccess="N";
			doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
			// }else{
			// return;
			// }
			if(saveSuccess!="Y"){
				return;
			}
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
	var ncCnt=0;
	var rCnt=0;
	var yCnt=0;
	for ( var i=1; i <= sheetObjects[1].RowCount(); i++) {
		if (sheetObjects[1].GetCellValue(i, "spcl_cgo_apro_cd") == "P") {
			ComShowMessage(ComGetMsg("BKG00500"));
			return;
		}
		if (sheetObjects[1].GetCellValue(i, "spcl_cgo_apro_cd") == "N" || sheetObjects[1].GetCellValue(i, "spcl_cgo_apro_cd") == "C") {
			// adds 1 a value in case appr. value is 'N' or 'P'
			ncCnt++;
		}
		if (sheetObjects[1].GetCellValue(i, "spcl_cgo_apro_cd") == "R") {
			// adds 1 rCnt value in case appr. value is 'R'
			rCnt++;
		}
		if (sheetObjects[1].GetCellValue(i, "spcl_cgo_apro_cd") == "Y") {
			// adds 1 yCnt value in case appr. value is 'Y'
			yCnt++;
		}
	}
	if (chkFlg != "Y") {
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
		// saveEnd = Y in case saving logic is completed
		// successfully or no saving data.
		for ( var i=1; i <= sheetObjects[1].RowCount(); i++) {
			// Setting apro_cd with 'R' in case appr. value is not
			// 'C'
			if (sheetObjects[1].GetCellValue(i, "spcl_cgo_apro_cd") != "C") {
				sheetObjects[1].SetCellValue(i, "apro_cd","R",0);
			}
		}
		doActionIBSheet(sheetObjects[0], document.form, COMMAND02);
		// Applying inquiry logic in case request completed
		// successfully
		if (retFlag == "Y") {
			// saving logic
			doActionIBSheet(sheetObjects[0], document.form, SEARCH);
		}
	}	
}

function btnRequestCancelProcess() {

	chkFlg="N";
	messageFlg="requestCancel";
	// Applying request logic in case reqFlag = N
	reqFlag="N";
	// Applying inquiry logic in case retFlag = Y
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
	// whether inserted data exists
	iCnt=sheetObjects[1].FindText("ibflag", "I", 0, 2);
	// whether updated data exists
	uCnt=sheetObjects[1].FindText("ibflag", "U", 0, 2);
	// whether deleted data exists
	dCnt=sheetObjects[1].FindText("ibflag", "D", 0, 2);
	// //in case insert, update, delete data exists
	if (iCnt > 0 || uCnt > 0 || dCnt > 0) {
		if (sheetObjects[2].GetCellValue(1, "bdr_flg") != "Y" && sheetObjects[2].GetCellValue(1, "corr_no") == "") {
			// if(ComShowConfirm(ComGetMsg("BKG00824"))){
			doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
			// }else{
			// return;
			// }
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
		if (ComShowConfirm(ComGetMsg("BKG00613", sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "seq")))) {
			sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "apro_cd","C",0);
			// request cancel logic
			doActionIBSheet(sheetObjects[0], document.form, COMMAND03);
			// Applying inquiry logic in case request cancel logic
			// completed successfully
			if (retFlag == "Y") {
				doActionIBSheet(sheetObjects[0], document.form, SEARCH);
			}
		} else {
			return;
		}
	}
}

// add line when add button clicks
function checkAdd() {
	// getting max value of awk_cgo_seq
	var seqVal = 0;
	//sheetObjects[1].GetCellValue(1, "awk_cgo_seq") == -1일때
	if(sheetObjects[1].RowCount() > 0){
		seqVal=Number(sheetObjects[1].GetCellValue(1, "awk_cgo_seq"));
	}else{
		seqVal=0;
	}
	for ( var k=1; k <= sheetObjects[1].RowCount(); k++) {
		if (seqVal < Number(sheetObjects[1].GetCellValue(k, "awk_cgo_seq"))) {
			seqVal=sheetObjects[1].GetCellValue(k, "awk_cgo_seq");
		}
	}
	
	// Adding row in case bkg_no value is not null.
	if (document.getElementById("bkg_no").value != "") {
		document.getElementById("temp_cntr_no").value="";
		var Row=sheetObjects[1].DataInsert(-1);
		// after adds row, setting default value in each items.
		sheetObjects[1].SetCellValue(Row, "cntr_no","",0);
		sheetObjects[1].SetCellValue(Row, "bkg_no",document.getElementById("bkg_no").value,0);
		// setting value adding seqVal(result from max value) to 1
		sheetObjects[1].SetCellValue(Row, "awk_cgo_seq",Number(seqVal) + 1,0);
		sheetObjects[1].SetCellValue(Row, "cntr_vol_qty","1",0);
		sheetObjects[1].SetCellValue(Row, "in_ga_flg","Y",0);
		sheetObjects[1].SetCellValue(Row, "rcv_term_cd",sheetObjects[2].GetCellValue(1, "rcv_term_cd"),0);
		sheetObjects[1].SetCellValue(Row, "de_term_cd",sheetObjects[2].GetCellValue(1, "de_term_cd"),0);
		sheetObjects[1].SetCellValue(Row, "cmdt_cd",sheetObjects[2].GetCellValue(1, "cmdt_cd"),0);
		sheetObjects[1].SetCellValue(Row, "cmdt_nm",sheetObjects[2].GetCellValue(1, "cmdt_nm"),0);
		// synchronizing html with ibsheet
		// htmlSheetSync();
		// setting selectbox value of ibsheet cntr_no items
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
		// setting add row with selectbox value
		var checkCntr=sheetObjects[4].FindText("DelChk", "0", 0, 2);
		if (checkCntr > 0) {
			sheetObjects[1].CellComboItem(Row,"cntr_no", {ComboText:"|"+cntr_name, ComboCode:"|"+cntr_val} );
		} else {
			sheetObjects[1].CellComboItem(Row,"cntr_no", {ComboText:"", ComboCode:""} );
		}
	}
	htmlSheetSync();
}
// when del button clicks after ibsheet checkbox checks
function deleteRows() {
	for ( var k=1; k <= sheetObjects[1].RowCount(); k++) {
		// if checked item exists
		if (sheetObjects[1].GetCellValue(k, "DelChk") == "1") {
			// Suspending delete operation in case values of Appr. item are P,
			// R, Y, N
			if (sheetObjects[1].GetCellValue(k, "spcl_cgo_apro_cd") == "P" || sheetObjects[1].GetCellValue(k, "spcl_cgo_apro_cd") == "R" || sheetObjects[1].GetCellValue(k, "spcl_cgo_apro_cd") == "Y" || sheetObjects[1].GetCellValue(k, "spcl_cgo_apro_cd") == "N") {
				ComShowMessage(ComGetMsg("BKG00525"));
				return;
			}
		}
	}
	var find_row=0;
	for ( var i=1; i <= sheetObjects[1].RowCount(); i++) {
		// if checked item exists...
		if (sheetObjects[1].GetCellValue(i, "DelChk") == "1") {
			// put cntr_no value of will-be delete item into temp_cntr_no에
			var temp_cntr_no=sheetObjects[1].GetCellValue(i, "cntr_no");
			var temp_find_row=sheetObjects[4].FindText("name", temp_cntr_no, 0, 2);
			if (temp_cntr_no != "") {
				sheetObjects[4].SetCellValue(temp_find_row, "DelChk","0");
			}
			// AWK_CGO_DIM Delete
			var temp_awk_cgo_seq=sheetObjects[1].GetCellValue(i, "awk_cgo_seq");
			for ( var k=sheetObjects[3].RowCount(); k > 0; k--) {
				if (temp_awk_cgo_seq == sheetObjects[3].GetCellValue(k, "awk_cgo_seq")) {
					sheetObjects[3].RowDelete(k, false);
				}
			}
		}
	}
	// Deleting checked row for delete.
	var drow=ComRowHideDelete(sheetObjects[1], "DelChk");
	// Getting cntr_no values of deleted items again
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
	var cntr_no="";
	// Setting cntr_no value into cntr_no selectbox value of each row.
	for ( var i=1; i <= sheetObjects[1].RowCount(); i++) {
		cntr_no=sheetObjects[1].GetCellValue(i, "cntr_no");
		sheetObjects[1].CellComboItem(i,"cntr_no", {ComboText:"|"+cntr_no+"|"+cntr_name, ComboCode:"|"+cntr_no+"|"+cntr_val} );
		sheetObjects[1].SetCellValue(i, "cntr_no",cntr_no,0);
		if (sheetObjects[1].GetCellValue(i, "ibflag") != "D") {
			cnt++;
			sheetObjects[1].SetCellValue(i, "seq",cnt,0);
		}
	}
	// Because it doesn't get value of deleted items properly, getting row
	// number of the actual remains.
	for ( var i=1; i <= sheetObjects[1].RowCount(); i++) {
		if (sheetObjects[1].GetCellValue(i, "ibflag") != "D") {
			sheetObjects[1].SelectCell(i, 0, false);
			htmlSheetSync();
			return;
		} else {
			find_row++;
		}
	}
	// Setting html value into null in case actual row is 0
	if (find_row == sheetObjects[1].RowCount()) {
		document.getElementById("frm_pck_qty").value= "";
		document.getElementById("frm_grs_wgt").value= "";
		document.getElementById("frm_net_wgt").value= "";
		document.getElementById("temp_grs_wgt").value="";
		document.getElementById("temp_net_wgt").value="";
		document.getElementById("ttl_dim_len").value="";
		document.getElementById("ttl_dim_wdt").value="";
		document.getElementById("ttl_dim_hgt").value="";
		document.getElementById("ovr_fwrd_len").value="";
		document.getElementById("ovr_bkwd_len").value="";
		document.getElementById("ovr_lf_len").value="";
		document.getElementById("ovr_rt_len").value="";
		document.getElementById("ovr_hgt").value="";
		document.getElementById("ovr_void_slt_qty").value="";
		rcv_term_cd.SetSelectCode("");
		de_term_cd.SetSelectCode("");
		document.getElementById("wgt_ut_cd1").value="";
		document.getElementById("wgt_ut_cd2").value="";
		crn_pst_sts_cd.SetSelectCode("");
		document.getElementById("pst_lck_pin_flg").value="";
		document.getElementById("temp_cntr_no").value="";
		document.getElementById("cntr_tpsz_cd").value="";
		document.getElementById("frm_seq").value="";
		document.getElementById("frm_pck_tp_cd").value="";
		document.getElementById("cmdt_cd").value="";
		document.getElementById("cmdt_nm").value="";
		document.getElementById("aply_no").value="";
	}
}
// when copy button click
function copyRowPopup() {
	var url="ESM_BKG_0720.do";
	ComOpenWindowCenter(url, "ESM_BKG_0720", 400, 150, true);
}
// calling function in ESM_BKG_0720.js as opener.
function copyCnt(copyCnt) {
	var seqVal=0;
	for (var i=1; i <= copyCnt; i++) {
		if(sheetObjects[1].RowCount() > 0){
			seqVal=Number(sheetObjects[1].GetCellValue(1, "awk_cgo_seq"));	
		}else{
			seqVal=0;
		}
		
		for ( var k=1; k <= sheetObjects[1].RowCount(); k++) {
			if (seqVal < Number(sheetObjects[1].GetCellValue(k, "awk_cgo_seq"))) {
				seqVal=sheetObjects[1].GetCellValue(k, "awk_cgo_seq");
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
		sheetObjects[1].SetCellValue(Row, "awk_cgo_seq",Number(seqVal) + 1,0);
		sheetObjects[1].SetCellValue(Row, "spcl_cgo_apro_cd","",0);
		sheetObjects[1].SetCellValue(Row, "DelChk","0",0);
		// setting selectbox value of cntr_no of copied item.
		var cntr_name="";
		var cntr_val="";
		var temp_cntr_no=sheetObjects[1].GetCellValue(Row, "cntr_no");
		var temp_find_row=sheetObjects[4].FindText("name", temp_cntr_no, 0, 2);
		for ( var j=1; j <= sheetObjects[4].RowCount(); j++) {
			if (sheetObjects[4].GetCellValue(j, "DelChk") == "0") {
				cntr_name += sheetObjects[4].GetCellValue(j, "name") + "|";
				cntr_val += sheetObjects[4].GetCellValue(j, "val") + "|";
			}
		}
		cntr_val=cntr_val.substr(0, cntr_val.length - 1);
		cntr_name=cntr_name.substr(0, cntr_name.length - 1);
		sheetObjects[1].CellComboItem(Row,"cntr_no", {ComboText:"|"+cntr_name, ComboCode:"|"+cntr_val} );
	}
	var rowCnt=0;
	for ( var i=2; i <= sheetObjects[1].RowCount()+ 1; i++) {
		if (sheetObjects[1].GetCellValue(i, "ibflag") != "D") {
			rowCnt++;
			sheetObjects[1].SetCellValue(i, "seq",rowCnt,0);
		}
	}
}
function obj_click() {
	var row=sheetObjects[1].GetSelectRow();
	switch (ComGetEvent("name")) {
	case "und_deck_top_flg":
		if (document.getElementById("und_deck_top_flg").checked == true) {
			sheetObjects[1].SetCellValue(row, "und_deck_top_flg","Y",0);
		} else {
			sheetObjects[1].SetCellValue(row, "und_deck_top_flg","N",0);
			if (document.getElementById("ovr_hgt").value > 0 && document.getElementById("ovr_void_slt_qty").value == "0") {
				ComAlertFocus(document.getElementById("ovr_void_slt_qty"), ComGetMsg("BKG00494"));
				if ((sheetObjects[1].GetCellValue(row, "cntr_tpsz_cd")).indexOf("2") > -1) {
					voidSpaceValue2();
				} else {
					voidSpaceValue();
				}
				if (document.getElementById("ovr_void_slt_qty").value == "0") {
					document.getElementById("inGauge").checked=true;
					sheetObjects[1].SetCellValue(row, "in_ga_flg","Y",0);
				} else {
					document.getElementById("inGauge").checked=false;
					sheetObjects[1].SetCellValue(row, "in_ga_flg","N",0);
				}
			}
		}
		break;
	case "frm_net_wgt":
		if (sheetObjects[1].GetCellValue(row, "net_wgt") == "0") {
			document.getElementById("frm_net_wgt").value="";
		}
		break;
	case "frm_grs_wgt":
		if (sheetObjects[1].GetCellValue(row, "grs_wgt") == "0") {
			document.getElementById("frm_grs_wgt").value="";
		}
		break;
	case "ttl_dim_len":
		if (sheetObjects[1].GetCellValue(row, "ttl_dim_len") == "0") {
			document.getElementById("ttl_dim_len").value="";
		}
		break;
	case "ttl_dim_wdt":
		if (sheetObjects[1].GetCellValue(row, "ttl_dim_wdt") == "0") {
			document.getElementById("ttl_dim_wdt").value="";
		}
		break;
	case "ttl_dim_hgt":
		if (sheetObjects[1].GetCellValue(row, "ttl_dim_hgt") == "0") {
			document.getElementById("ttl_dim_hgt").value="";
		}
		break;
	case "ovr_fwrd_len":
		if (sheetObjects[1].GetCellValue(row, "ovr_fwrd_len") == "0") {
			document.getElementById("ovr_fwrd_len").value="";
		}
		break;
	case "ovr_bkwd_len":
		if (sheetObjects[1].GetCellValue(row, "ovr_bkwd_len") == "0") {
			document.getElementById("ovr_bkwd_len").value="";
		}
		break;
	case "ovr_lf_len":
		if (sheetObjects[1].GetCellValue(row, "ovr_lf_len") == "0") {
			document.getElementById("ovr_lf_len").value="";
		}
		break;
	case "ovr_rt_len":
		if (sheetObjects[1].GetCellValue(row, "ovr_rt_len") == "0") {
			document.getElementById("ovr_rt_len").value="";
		}
		break;
	case "ovr_hgt":
		if (sheetObjects[1].GetCellValue(row, "ovr_hgt") == "0") {
			document.getElementById("ovr_hgt").value="";
		}
		break;
	}
}
function obj_deactivate() {
	var row=sheetObjects[1].GetSelectRow();
	switch (ComGetEvent("name")) {
	// After inputting cmdt_cd value, when mouse click somewhere, setting value
	// cmdt_nm.
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
				sheetObjects[1].SetCellValue(row, "cmdt_cd",cmdt_cd,0);
			}
			if (cmdtFlg == "") {
				doActionIBSheet(sheetObjects[0], document.form, COMMAND05);
			}
		}
	case "ovr_lf_len":
		if (document.getElementById("ovr_lf_len").value == "") {
			document.getElementById("ovr_lf_len").value="0";
		}else{
			document.getElementById("ovr_lf_len").value=Math.round(parseFloat(document.getElementById("ovr_lf_len").value)) ;
		}
		break;
	case "ovr_rt_len":
		if (document.getElementById("ovr_rt_len").value == "") {
			document.getElementById("ovr_rt_len").value="0";
		}else{
			document.getElementById("ovr_rt_len").value=Math.round(parseFloat(document.getElementById("ovr_rt_len").value)) ;
		}
		break;
	case "ovr_fwrd_len":
		if (document.getElementById("ovr_fwrd_len").value == "") {
			document.getElementById("ovr_fwrd_len").value="0";
		}else{
			document.getElementById("ovr_fwrd_len").value=Math.round(parseFloat(document.getElementById("ovr_fwrd_len").value)) ;
		}
		break;
	case "ovr_bkwd_len":
		if (document.getElementById("ovr_bkwd_len").value == "") {
			document.getElementById("ovr_bkwd_len").value="0";
		}else{
			document.getElementById("ovr_bkwd_len").value=Math.round(parseFloat(document.getElementById("ovr_bkwd_len").value)) ;
		}
		break;
	case "ovr_hgt":
		if (document.getElementById("ovr_hgt").value == "") {
			document.getElementById("ovr_hgt").value="0";
		}else{
			document.getElementById("ovr_hgt").value=Math.round(parseFloat(document.getElementById("ovr_hgt").value)) ;
		}
		break;
	}
}
function obj_blur() {
	var row=sheetObjects[1].GetSelectRow();
	switch (ComGetEvent("name")) {
	case "frm_pck_qty":
		if (document.getElementById("bkg_no").value != "") {
			document.getElementById("frm_pck_qty").value=sheetObjects[1].GetCellText(row, "pck_qty");
		}
		break;
	case "frm_net_wgt":
		if (document.getElementById("bkg_no").value != "") {
			document.getElementById("frm_net_wgt").value=sheetObjects[1].GetCellText(row, "net_wgt");
			if (Number(document.getElementById("frm_grs_wgt").value.replaceStr(",")) < Number(document.getElementById("frm_net_wgt").value.replaceStr(","))) {
				ComAlertFocus(document.getElementById("frm_net_wgt"), ComGetMsg("BKG00491"));
				document.getElementById("frm_net_wgt").value=document.getElementById("temp_net_wgt").value;
				sheetObjects[1].SetCellValue(row, "net_wgt",document.getElementById("temp_net_wgt").value);
			} else {
				document.getElementById("temp_net_wgt").value=sheetObjects[1].GetCellText(row, "net_wgt");
			}
			sheetObjects[1].SetCellValue(row, "modifyaproflg","Y",0);
		}
		break;
	case "frm_grs_wgt":
		if (document.getElementById("bkg_no").value != "") {
			document.getElementById("frm_grs_wgt").value=sheetObjects[1].GetCellText(row, "grs_wgt");
			if (Number(document.getElementById("frm_grs_wgt").value.replaceStr(",")) < Number(document.getElementById("frm_net_wgt").value.replaceStr(","))) {
				ComAlertFocus(document.getElementById("frm_grs_wgt"), ComGetMsg("BKG00491"));
				document.getElementById("frm_grs_wgt").value=document.getElementById("temp_grs_wgt").value;
				sheetObjects[1].SetCellValue(row, "grs_wgt",document.getElementById("temp_grs_wgt").value);
			} else {
				document.getElementById("temp_grs_wgt").value=sheetObjects[1].GetCellText(row, "grs_wgt")
			}
			sheetObjects[1].SetCellValue(row, "modifyaproflg","Y",0);
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
				sheetObjects[1].SetCellValue(row, "cmdt_cd",cmdt_cd,0);
			}
			if (cmdtFlg == "") {
				doActionIBSheet(sheetObjects[0], document.form, COMMAND05);
			}
		}
		
	}
}

function obj_keyup() {
	pendingSaveFlg = "N"; //Approval이 Pending 상태일 때는 Container No를 제외한 나머지 모든 값은 신규 또는 수정이 되지 않게 상태 확인하는 Flag
	
	var row = sheetObjects[1].GetSelectRow();
	switch (event.srcElement.name) {
		case "frm_pck_qty":
			sheetObjects[1].SetCellValue(row, "pck_qty", document.getElementById("frm_pck_qty").value, 0);
			break;
	
		case "frm_pck_tp_cd":
			sheetObjects[1].SetCellValue(row, "pck_tp_cd", document.getElementById("frm_pck_tp_cd").value, 0);
			break;
	
		case "frm_grs_wgt":
			if (document.getElementById("frm_grs_wgt").value.length > 7) {
				if (document.getElementById("frm_grs_wgt").value.indexOf(".") > -1) {
				} else {
					document.getElementById("frm_grs_wgt").value = document.getElementById("frm_grs_wgt").value.substr(0, 7);
				}
			}
			sheetObjects[1].SetCellValue(row, "grs_wgt",document.getElementById("frm_grs_wgt").value,0);
			break;
	
		case "frm_net_wgt":
			if (document.getElementById("frm_net_wgt").value.length > 7) {
				if (document.getElementById("frm_net_wgt").value.indexOf(".") > -1) {
				} else {
					document.getElementById("frm_net_wgt").value = document.getElementById("frm_net_wgt").value.substr(0, 7);
				}
			}
			sheetObjects[1].SetCellValue(row, "net_wgt",document.getElementById("frm_net_wgt").value,0);
			break;
	
		case "cmdt_cd":
			sheetObjects[1].SetCellValue(row, "cmdt_cd",document.getElementById("cmdt_cd").value,0);
			break;
	
		case "cmdt_nm":
			sheetObjects[1].SetCellValue(row, "cmdt_nm",document.getElementById("cmdt_nm").value,0);
			break;
	
		case "frm_xtd_ovr_qty":
			sheetObjects[1].SetCellValue(row, "xtd_ovr_qty",document.getElementById("frm_xtd_ovr_qty").value,0);
			break;
	
		case "frm_grav_ctr_desc":
			sheetObjects[1].SetCellValue(row, "grav_ctr_desc",document.getElementById("frm_grav_ctr_desc").value,0);
			break;
	
		case "frm_stwg_rqst_desc":
			sheetObjects[1].SetCellValue(row, "stwg_rqst_desc",document.getElementById("frm_stwg_rqst_desc").value,0);
			break;
	
		case "ttl_dim_len":
			sheetObjects[1].SetCellValue(row, "ttl_dim_len", document.getElementById("ttl_dim_len").value,0);
			break;
	
		case "ttl_dim_wdt":
			sheetObjects[1].SetCellValue(row, "ttl_dim_wdt",document.getElementById("ttl_dim_wdt").value,0);
			break;
	
		case "ttl_dim_hgt":
			sheetObjects[1].SetCellValue(row, "ttl_dim_hgt",document.getElementById("ttl_dim_hgt").value,0);
			break;	
	
		case "ovr_fwrd_len":
			var s_value =Math.round(parseFloat(document.getElementById("ovr_fwrd_len").value)) ;
			//if (!ComIsNumber(s_value)) return;
			//document.getElementById("ovr_fwrd_len").value	= s_value;
			sheetObjects[1].SetCellValue(row, "ovr_fwrd_len",s_value,0);			
			break;
	
		case "ovr_bkwd_len":
			var s_value =Math.round(parseFloat(document.getElementById("ovr_bkwd_len").value)) ;
			//if (!ComIsNumber(s_value)) return;
			//document.getElementById("ovr_bkwd_len").value	= s_value;
			sheetObjects[1].SetCellValue(row, "ovr_bkwd_len", s_value,0);		
			break;
	
		case "ovr_lf_len":
			var s_value =Math.round(parseFloat(document.getElementById("ovr_lf_len").value)) ;
			//if (!ComIsNumber(s_value)) return;
			//document.getElementById("ovr_lf_len").value		= s_value;
			sheetObjects[1].SetCellValue(row, "ovr_lf_len",s_value,0);			
			break;
	
		case "ovr_rt_len":
			var s_value =Math.round(parseFloat(document.getElementById("ovr_rt_len").value)) ;
			//if (!ComIsNumber(s_value)) return;
			//document.getElementById("ovr_rt_len").value		= s_value;
			sheetObjects[1].SetCellValue(row, "ovr_rt_len",s_value,0);
			break;
			
		case "ovr_hgt":
			var s_value =Math.round(parseFloat(document.getElementById("ovr_hgt").value)) ;
			//if (!ComIsNumber(s_value)) return;
			//document.getElementById("ovr_hgt").value= s_value;
			sheetObjects[1].SetCellValue(row, "ovr_hgt",s_value,0);		
			break;
	
		case "ovr_void_slt_qty":
			var s_value =parseFloat(document.getElementById("ovr_void_slt_qty").value) ;
			//if (!ComIsNumber(s_value)) return;
			//document.getElementById("ovr_void_slt_qty").value= s_value;
			sheetObjects[1].SetCellValue(row, "ovr_void_slt_qty",s_value,0);	
			break;
	
		case "frm_cntr_cgo_seq":
			sheetObjects[1].SetCellValue(row, "cntr_cgo_seq",document.getElementById("frm_cntr_cgo_seq").value,0) ;
			sheetObjects[1].SetCellValue(row, "awk_dcgo_seq",document.getElementById("frm_cntr_cgo_seq").value,0) ;
			break;
	}
}

function obj_keypress() {
	switch (event.srcElement.name) {
		case "frm_pck_qty":
			ComKeyOnlyNumber(event.srcElement);
			break;
	
		case "frm_grs_wgt":
			ComKeyOnlyNumber(event.srcElement, "-.");
			break;
	
		case "frm_net_wgt":
			ComKeyOnlyNumber(event.srcElement, "-.");
			break;
	
		case "cmdt_cd":
			ComKeyOnlyNumber(event.srcElement, "-.");
			break;
	
		case "ttl_dim_len":
			ComKeyOnlyNumber(event.srcElement, "-.");
			break;
	
		case "ttl_dim_wdt":
			ComKeyOnlyNumber(event.srcElement, "-.");
			break;
	
		case "ttl_dim_hgt":
			ComKeyOnlyNumber(event.srcElement, "-.");
			break;
	
		case "ovr_fwrd_len":
			ComKeyOnlyNumber(event.srcElement, "-."); 	
			break;
	
		case "ovr_bkwd_len":
			ComKeyOnlyNumber(event.srcElement, "-.");			
			break;
	
		case "ovr_lf_len":
			ComKeyOnlyNumber(event.srcElement, "-.");			
			break;
	
		case "ovr_rt_len":
			ComKeyOnlyNumber(event.srcElement, "-.");		
			break;
	
		case "ovr_hgt":
			ComKeyOnlyNumber(event.srcElement, "-.");			
			break;
	
		case "ovr_void_slt_qty":
			ComKeyOnlyNumber(event.srcElement, "-.");	
			break;
	}
}


function obj_change() {
	var row=sheetObjects[1].GetSelectRow();
	switch (ComGetEvent("name")) {
//	case "frm_pck_qty":
//		sheetObjects[1].SetCellValue(row, "frm_pck_qty",document.getElementById("frm_pck_qty").value,0);
//		break;
//	case "frm_pck_tp_cd":
//		document.getElementById("frm_pck_tp_cd").value=(document.getElementById("frm_pck_tp_cd").value).toUpperCase();
//		sheetObjects[1].SetCellValue(row, "pck_tp_cd",document.getElementById("frm_pck_tp_cd").value,0);
//		break;
	
//	case "frm_grs_wgt":
//		alert('a')
//		sheetObjects[1].SetCellValue(row, "frm_grs_wgt",document.getElementById("frm_grs_wgt").value,0);
//		break;
	case "wgt_ut_cd1":
		sheetObjects[1].SetCellValue(row, "wgt_ut_cd",document.getElementById("wgt_ut_cd1").value,0);
		document.getElementById("wgt_ut_cd2").value=document.getElementById("wgt_ut_cd1").value;
		break;
//	case "frm_net_wgt":	
//		sheetObjects[1].SetCellValue(row, "frm_net_wgt",document.getElementById("frm_net_wgt").value,0);
//		break;
//	case "cmdt_cd":	
//		sheetObjects[1].SetCellValue(row, "cmdt_cd",document.getElementById("cmdt_cd").value,0);
//		break;
//	case "cmdt_nm":	
//		sheetObjects[1].SetCellValue(row, "cmdt_nm",document.getElementById("cmdt_nm").value,0);
//		break;
//	case "frm_cntr_cgo_seq":	
//		sheetObjects[1].SetCellValue(row, "frm_cntr_cgo_seq",document.getElementById("frm_cntr_cgo_seq").value,0);
//		break;
//	case "crn_pst_sts_cd":
//		sheetObjects[1].SetCellValue(row, "crn_pst_sts_cd",crn_pst_sts_cd.value,1);
//		if (sheetObjects[1].GetCellValue(row, "crn_pst_sts_cd") != "E" && sheetObjects[1].GetCellValue(row, "crn_pst_sts_cd") != "F" && sheetObjects[1].GetCellValue(row, "crn_pst_sts_cd") != "") {
//			document.getElementById("frm_xtd_ovr_qty").disabled=false;
//		} else {
//			document.getElementById("frm_xtd_ovr_qty").disabled=true;
//		}
//		break;
	case "pst_lck_pin_flg":
		if (document.getElementById("pst_lck_pin_flg").value == "") {
			ComAlertFocus(document.getElementById("pst_lck_pin_flg"), ComGetMsg("BKG08025"));
			document.getElementById("pst_lck_pin_flg").value=sheetObjects[1].GetCellValue(row, "pst_lck_pin_flg");
		} else {
			sheetObjects[1].SetCellValue(row, "pst_lck_pin_flg",document.getElementById("pst_lck_pin_flg").value,0);
		}
		break;
//	case "rcv_term_cd":
//		sheetObjects[1].SetCellValue(row, "rcv_term_cd",rcv_term_cd.GetSelectCode(),0);
//		break;
//	case "de_term_cd":
//		sheetObjects[1].SetCellValue(row, "de_term_cd",de_term_cd.GetSelectCode(),0);
//		break;
	case "ttl_dim_len":
		overDimensionSettingLength();
		sheetObjects[1].SetCellValue(row, "ttl_dim_len",document.getElementById("ttl_dim_len").value,0);
		break;
	case "ttl_dim_wdt":
		overDimensionSettingWidth();
		sheetObjects[1].SetCellValue(row, "ttl_dim_wdt",document.getElementById("ttl_dim_wdt").value,0);
		break;
	case "ttl_dim_hgt":
		overDimensionSettingHeight();
		sheetObjects[1].SetCellValue(row, "ttl_dim_hgt",document.getElementById("ttl_dim_hgt").value,0);
		break;
	case "ovr_lf_len":
		if ((sheetObjects[1].GetCellValue(row, "cntr_tpsz_cd")).indexOf("2") > -1) {
			voidSpaceValue2();
		} else {
			voidSpaceValue();
		}
		break;
	case "ovr_rt_len":
		if ((sheetObjects[1].GetCellValue(row, "cntr_tpsz_cd")).indexOf("2") > -1) {
			voidSpaceValue2();
		} else {
			voidSpaceValue();
		}
		break;
	case "ovr_hgt":
		if ((sheetObjects[1].GetCellValue(row, "cntr_tpsz_cd")).indexOf("2") > -1) {
			voidSpaceValue2();
		} else {
			voidSpaceValue();
		}
		cornerPostStatus();
		break;
	case "ovr_void_slt_qty":
		if (document.getElementById("ovr_hgt").value > 0 && document.getElementById("ovr_void_slt_qty").value == "0" && document.getElementById("und_deck_top_flg").checked == false) {
			ComAlertFocus(document.getElementById("ovr_void_slt_qty"), ComGetMsg("BKG00494"));
			document.getElementById("ovr_void_slt_qty").value=sheetObjects[1].GetCellValue(row, "temp_ovr_void_qty");
		} else {
			sheetObjects[1].SetCellValue(row, "temp_ovr_void_qty",document.getElementById("ovr_void_slt_qty").value);
		}
		if (document.getElementById("ovr_void_slt_qty").value == "0") {
			document.getElementById("inGauge").checked=true;
			sheetObjects[1].SetCellValue(row, "in_ga_flg","Y",0);
		} else {
			document.getElementById("inGauge").checked=false;
			sheetObjects[1].SetCellValue(row, "in_ga_flg","N",0);
		}
		sheetObjects[1].SetCellValue(row, "modifyaproflg","Y");
		break;
	case "frm_stwg_rqst_desc":
		sheetObjects[1].SetCellValue(row, "modifyaproflg","Y");
		break;
	case "bkg_no":
		document.getElementById("bkg_no").value=(document.getElementById("bkg_no").value).toUpperCase();
		break;
	case "bl_no":
		document.getElementById("bl_no").value=(document.getElementById("bl_no").value).toUpperCase();
		break;
	}
	
}


function crn_pst_sts_cd_OnChange(comboObj, oldindex, oldtext, oldcode, newindex, newtext, newcode){//(comboObj, value, text) {
	var formObj=document.form;
	var row=sheetObjects[1].GetSelectRow();
	sheetObjects[1].SetCellValue(row, "crn_pst_sts_cd",formObj.crn_pst_sts_cd.value,0);
	if (sheetObjects[1].GetCellValue(row, "crn_pst_sts_cd") != "E" && sheetObjects[1].GetCellValue(row, "crn_pst_sts_cd") != "F" && sheetObjects[1].GetCellValue(row, "crn_pst_sts_cd") != "") {
		document.getElementById("frm_xtd_ovr_qty").disabled=false;
	} else {
		document.getElementById("frm_xtd_ovr_qty").disabled=true;
	}
	if(sheetObjects[1].GetCellValue(row,"xtd_ovr_qty") == 0){
		document.form.frm_xtd_ovr_qty.value = "";
	}
 } 


function rcv_term_cd_OnChange(comboObj, oldindex, oldtext, oldcode, newindex, newtext, newcode){//(comboObj, value, text) {
	var formObj=document.form;
	var row=sheetObjects[1].GetSelectRow();
	sheetObjects[1].SetCellValue(row, "rcv_term_cd",rcv_term_cd.GetSelectCode(),0);
} 


function de_term_cd_OnChange(comboObj, oldindex, oldtext, oldcode, newindex, newtext, newcode){//(comboObj, value, text) {
	var formObj=document.form;
	var row=sheetObjects[1].GetSelectRow();
	sheetObjects[1].SetCellValue(row, "de_term_cd",de_term_cd.GetSelectCode(),0);
} 



function overDimensionSettingLength() {
	var row=sheetObjects[1].GetSelectRow();
	var SumLength=document.getElementById("ttl_dim_len").value;
	var cntr_tpsz_cd=sheetObjects[1].GetCellText(row, "cntr_tpsz_cd");
	var front=0;
	var rear=0;
	var lengthCnt=0;
	if (cntr_tpsz_cd == "O2") {
		front=(SumLength - 589.3) / 2;
		rear=(SumLength - 589.3) / 2;
	}
	if (cntr_tpsz_cd == "O4" || cntr_tpsz_cd == "S4") {
		front=(SumLength - 1203.2) / 2;
		rear=(SumLength - 1203.2) / 2;
	}
	if (cntr_tpsz_cd == "S2") {
		front=(SumLength - 589.3) / 2;
		rear=(SumLength - 589.3) / 2;
	}
	if (cntr_tpsz_cd == "A2" || cntr_tpsz_cd == "F2" || cntr_tpsz_cd == "P2") {
		front=(SumLength - 605.8) / 2;
		rear=(SumLength - 605.8) / 2;
	}
	if (cntr_tpsz_cd == "F4" || cntr_tpsz_cd == "P4") {
		front=(SumLength - 1219.2) / 2;
		rear=(SumLength - 1219.2) / 2;
	}
	if (cntr_tpsz_cd == "A4") {
		front=(SumLength - 1219.2) / 2;
		rear=(SumLength - 1219.2) / 2;
	}
	if (cntr_tpsz_cd == "F5") {
		front=(SumLength - 1219.2) / 2;
		rear=(SumLength - 1219.2) / 2;
	}
	if (front > 0) {
		front=Math.round(parseFloat(front)) ;
		sheetObjects[1].SetCellValue(row, "ovr_fwrd_len",front);
		document.getElementById("ovr_fwrd_len").value=sheetObjects[1].GetCellValue(row, "ovr_fwrd_len");
		lengthCnt++
	} else {
		sheetObjects[1].SetCellValue(row, "ovr_fwrd_len","0");
		document.getElementById("ovr_fwrd_len").value="0";
	}
	if (rear > 0) {
		rear=Math.round(parseFloat(rear)) ;
		sheetObjects[1].SetCellValue(row, "ovr_bkwd_len",rear);
		document.getElementById("ovr_bkwd_len").value=sheetObjects[1].GetCellValue(row, "ovr_bkwd_len");
		lengthCnt++
	} else {
		sheetObjects[1].SetCellValue(row, "ovr_bkwd_len","0");
		document.getElementById("ovr_bkwd_len").value="0";
	}
	if (lengthCnt > 0) {
		ComShowMessage(ComGetMsg("BKG08034"));
	}
}
function overDimensionSettingWidth() {
	var row=sheetObjects[1].GetSelectRow();
	var SumWidth=document.getElementById("ttl_dim_wdt").value;
	var cntr_tpsz_cd=sheetObjects[1].GetCellText(row, "cntr_tpsz_cd");
	var left=0;
	var right=0;
	if (cntr_tpsz_cd == "O2") {
		left=(SumWidth - 234.6) / 2;
		right=(SumWidth - 234.6) / 2;
	}
	if (cntr_tpsz_cd == "O4" || cntr_tpsz_cd == "S4") {
		left=(SumWidth - 234.6) / 2;
		right=(SumWidth - 234.6) / 2;
	}
	if (cntr_tpsz_cd == "S2") {
		left=(SumWidth - 234.6) / 2;
		right=(SumWidth - 234.6) / 2;
	}
	if (cntr_tpsz_cd == "A2" || cntr_tpsz_cd == "F2" || cntr_tpsz_cd == "P2") {
		left=(SumWidth - 243.8) / 2;
		right=(SumWidth - 243.8) / 2;
	}
	if (cntr_tpsz_cd == "F4" || cntr_tpsz_cd == "P4") {
		left=(SumWidth - 243.8) / 2;
		right=(SumWidth - 243.8) / 2;
	}
	if (cntr_tpsz_cd == "A4") {
		left=(SumWidth - 243.8) / 2;
		right=(SumWidth - 243.8) / 2;
	}
	if (cntr_tpsz_cd == "F5") {
		left=(SumWidth - 243.8) / 2;
		right=(SumWidth - 243.8) / 2;
	}
	if (left > 0) {
		left=Math.round(parseFloat(left)) ;
		sheetObjects[1].SetCellValue(row, "ovr_lf_len",left);
		document.getElementById("ovr_lf_len").value=sheetObjects[1].GetCellValue(row, "ovr_lf_len");
	} else {
		sheetObjects[1].SetCellValue(row, "ovr_lf_len","0");
		document.getElementById("ovr_lf_len").value="0";
	}
	if (right > 0) {
		right=Math.round(parseFloat(right)) ;
		sheetObjects[1].SetCellValue(row, "ovr_rt_len",right);
		document.getElementById("ovr_rt_len").value=sheetObjects[1].GetCellValue(row, "ovr_rt_len");
	} else {
		sheetObjects[1].SetCellValue(row, "ovr_rt_len","0");
		document.getElementById("ovr_rt_len").value="0";
	}
	if (cntr_tpsz_cd.indexOf("2") > -1) {
		voidSpaceValue2();
	} else {
		voidSpaceValue();
	}
}
function overDimensionSettingHeight() {
	var row=sheetObjects[1].GetSelectRow();
	var SumHeight=document.getElementById("ttl_dim_hgt").value;
	var cntr_tpsz_cd=sheetObjects[1].GetCellText(row, "cntr_tpsz_cd");
	var height=0;
	if (cntr_tpsz_cd == "O2") {
		height=SumHeight - 238.4;
	}
	if (cntr_tpsz_cd == "O4" || cntr_tpsz_cd == "S4") {
		height=SumHeight - 238.1;
	}
	if (cntr_tpsz_cd == "S2") {
		height=SumHeight - 236.4;
	}
	if (cntr_tpsz_cd == "A2" || cntr_tpsz_cd == "F2" || cntr_tpsz_cd == "P2") {
		height=SumHeight - 207.7;
	}
	if (cntr_tpsz_cd == "F4" || cntr_tpsz_cd == "P4") {
		height=SumHeight - 196.8;
	}
	if (cntr_tpsz_cd == "A4") {
		height=SumHeight - 196.8;
	}
	if (cntr_tpsz_cd == "F5") {
		height=SumHeight - 226.4;
	}
	if (height > 0) {
		height=Math.round(parseFloat(height)) ;
		sheetObjects[1].SetCellValue(row, "ovr_hgt",height);
		document.getElementById("ovr_hgt").value=sheetObjects[1].GetCellValue(row, "ovr_hgt");
	} else {
		sheetObjects[1].SetCellValue(row, "ovr_hgt","0");
		document.getElementById("ovr_hgt").value="0";
	}
	if (cntr_tpsz_cd.indexOf("2") > -1) {
		voidSpaceValue2();
	} else {
		voidSpaceValue();
	}
	cornerPostStatus();
}
function voidSpaceValue() {
	var width1=document.getElementById("ovr_lf_len").value;
	var width2=document.getElementById("ovr_rt_len").value;
	var height=document.getElementById("ovr_hgt").value;
	var row=sheetObjects[1].GetSelectRow();
	if (width1 > 0 && width2 > 0 && height > 0) {
		sheetObjects[1].SetCellValue(row, "ovr_void_slt_qty","5",0);
		sheetObjects[1].SetCellValue(row, "temp_ovr_void_qty","5",0);
		document.getElementById("ovr_void_slt_qty").value="5";
	} else if (width1 > 0 && width2 > 0 && height == 0) {
		sheetObjects[1].SetCellValue(row, "ovr_void_slt_qty","2",0);
		sheetObjects[1].SetCellValue(row, "temp_ovr_void_qty","2",0);
		document.getElementById("ovr_void_slt_qty").value="2";
	} else if (width1 > 0 && width2 == 0 && height > 0) {
		sheetObjects[1].SetCellValue(row, "ovr_void_slt_qty","3",0);
		sheetObjects[1].SetCellValue(row, "temp_ovr_void_qty","3",0);
		document.getElementById("ovr_void_slt_qty").value="3";
	} else if (width1 == 0 && width2 > 0 && height > 0) {
		sheetObjects[1].SetCellValue(row, "ovr_void_slt_qty","3",0);
		sheetObjects[1].SetCellValue(row, "temp_ovr_void_qty","3",0);
		document.getElementById("ovr_void_slt_qty").value="3";
	} else if (width1 > 0 && width2 == 0 && height == 0) {
		sheetObjects[1].SetCellValue(row, "ovr_void_slt_qty","1",0);
		sheetObjects[1].SetCellValue(row, "temp_ovr_void_qty","1",0);
		document.getElementById("ovr_void_slt_qty").value="1";
	} else if (width1 == 0 && width2 > 0 && height == 0) {
		sheetObjects[1].SetCellValue(row, "ovr_void_slt_qty","1",0);
		sheetObjects[1].SetCellValue(row, "temp_ovr_void_qty","1",0);
		document.getElementById("ovr_void_slt_qty").value="1";
	} else if (width1 == 0 && width2 == 0 && height > 0) {
		sheetObjects[1].SetCellValue(row, "ovr_void_slt_qty","1",0);
		sheetObjects[1].SetCellValue(row, "temp_ovr_void_qty","1",0);
		document.getElementById("ovr_void_slt_qty").value="1";
	} else {
		sheetObjects[1].SetCellValue(row, "ovr_void_slt_qty","0",0);
		sheetObjects[1].SetCellValue(row, "temp_ovr_void_qty","0",0);
		document.getElementById("ovr_void_slt_qty").value="0";
	}
	if (sheetObjects[1].GetCellValue(row, "ovr_void_slt_qty") == "0") {
		document.getElementById("inGauge").checked=true;
		sheetObjects[1].SetCellValue(row, "in_ga_flg","Y",0);
	} else {
		document.getElementById("inGauge").checked=false;
		sheetObjects[1].SetCellValue(row, "in_ga_flg","N",0);
	}
}
function voidSpaceValue2() {
	var width1=document.getElementById("ovr_lf_len").value;
	var width2=document.getElementById("ovr_rt_len").value;
	var height=document.getElementById("ovr_hgt").value;
	var row=sheetObjects[1].GetSelectRow();
	if (width1 > 0 && width2 > 0 && height > 0) {
		sheetObjects[1].SetCellValue(row, "ovr_void_slt_qty","2.5",0);
		sheetObjects[1].SetCellValue(row, "temp_ovr_void_qty","2.5",0);
		document.getElementById("ovr_void_slt_qty").value="2.5";
	} else if (width1 > 0 && width2 > 0 && height == 0) {
		sheetObjects[1].SetCellValue(row, "ovr_void_slt_qty","1",0);
		sheetObjects[1].SetCellValue(row, "temp_ovr_void_qty","1",0);
		document.getElementById("ovr_void_slt_qty").value="1";
	} else if (width1 > 0 && width2 == 0 && height > 0) {
		sheetObjects[1].SetCellValue(row, "ovr_void_slt_qty","1.5",0);
		sheetObjects[1].SetCellValue(row, "temp_ovr_void_qty","1.5",0);
		document.getElementById("ovr_void_slt_qty").value="1.5";
	} else if (width1 == 0 && width2 > 0 && height > 0) {
		sheetObjects[1].SetCellValue(row, "ovr_void_slt_qty","1.5",0);
		sheetObjects[1].SetCellValue(row, "temp_ovr_void_qty","1.5",0);
		document.getElementById("ovr_void_slt_qty").value="1.5";
	} else if (width1 > 0 && width2 == 0 && height == 0) {
		sheetObjects[1].SetCellValue(row, "ovr_void_slt_qty","0.5",0);
		sheetObjects[1].SetCellValue(row, "temp_ovr_void_qty","0.5",0);
		document.getElementById("ovr_void_slt_qty").value="0.5";
	} else if (width1 == 0 && width2 > 0 && height == 0) {
		sheetObjects[1].SetCellValue(row, "ovr_void_slt_qty","0.5",0);
		sheetObjects[1].SetCellValue(row, "temp_ovr_void_qty","0.5",0);
		document.getElementById("ovr_void_slt_qty").value="0.5";
	} else if (width1 == 0 && width2 == 0 && height > 0) {
		sheetObjects[1].SetCellValue(row, "ovr_void_slt_qty","0.5",0);
		sheetObjects[1].SetCellValue(row, "temp_ovr_void_qty","0.5",0);
		document.getElementById("ovr_void_slt_qty").value="0.5";
	} else {
		sheetObjects[1].SetCellValue(row, "ovr_void_slt_qty","0",0);
		sheetObjects[1].SetCellValue(row, "temp_ovr_void_qty","0",0);
		document.getElementById("ovr_void_slt_qty").value="0";
	}
	if (sheetObjects[1].GetCellValue(row, "ovr_void_slt_qty") == "0") {
		document.getElementById("inGauge").checked=true;
		sheetObjects[1].SetCellValue(row, "in_ga_flg","Y",0);
	} else {
		document.getElementById("inGauge").checked=false;
		sheetObjects[1].SetCellValue(row, "in_ga_flg","N",0);
	}
}
function cornerPostStatus() {
	var ovr_hgt=document.getElementById("ovr_hgt").value;
	var row=sheetObjects[1].GetSelectRow();
	if (sheetObjects[1].GetCellValue(row, "cntr_tpsz_cd").indexOf("A") > -1) {
		if (ovr_hgt > 0 && ovr_hgt <= 30) {
			crn_pst_sts_cd.SetSelectCode("1");
			document.getElementById("pst_lck_pin_flg").value="Y";
			if (crn_pst_sts_cd.GetSelectCode() != sheetObjects[1].GetCellValue(row, "crn_pst_sts_cd")) {
				ComShowMessage(ComGetMsg("BKG08024"));
			}
			sheetObjects[1].SetCellValue(row, "crn_pst_sts_cd","1");
			sheetObjects[1].SetCellValue(row, "pst_lck_pin_flg","Y");
			document.getElementById("frm_xtd_ovr_qty").disabled=false;
		} else if (ovr_hgt > 30 && ovr_hgt <= 60) {
			crn_pst_sts_cd.SetSelectCode("2");
			document.getElementById("pst_lck_pin_flg").value="Y";
			if (crn_pst_sts_cd.GetSelectCode() != sheetObjects[1].GetCellValue(row, "crn_pst_sts_cd")) {
				ComShowMessage(ComGetMsg("BKG08024"));
			}
			sheetObjects[1].SetCellValue(row, "crn_pst_sts_cd","2");
			sheetObjects[1].SetCellValue(row, "pst_lck_pin_flg","Y");
			document.getElementById("frm_xtd_ovr_qty").disabled=false;
		} else if (ovr_hgt > 60 && ovr_hgt <= 90) {
			crn_pst_sts_cd.SetSelectCode("3");
			document.getElementById("pst_lck_pin_flg").value="Y";
			if (crn_pst_sts_cd.GetSelectCode() != sheetObjects[1].GetCellValue(row, "crn_pst_sts_cd")) {
				ComShowMessage(ComGetMsg("BKG08024"));
			}
			sheetObjects[1].SetCellValue(row, "crn_pst_sts_cd","3");
			sheetObjects[1].SetCellValue(row, "pst_lck_pin_flg","Y");
			document.getElementById("frm_xtd_ovr_qty").disabled=false;
		} else if (ovr_hgt > 90 && ovr_hgt <= 120) {
			crn_pst_sts_cd.SetSelectCode("4");
			document.getElementById("pst_lck_pin_flg").value="Y";
			if (crn_pst_sts_cd.GetSelectCode() != sheetObjects[1].GetCellValue(row, "crn_pst_sts_cd")) {
				ComShowMessage(ComGetMsg("BKG08024"));
			}
			sheetObjects[1].SetCellValue(row, "crn_pst_sts_cd","4");
			sheetObjects[1].SetCellValue(row, "pst_lck_pin_flg","Y");
			document.getElementById("frm_xtd_ovr_qty").disabled=false;
		} else if (ovr_hgt > 120) {
			crn_pst_sts_cd.SetSelectCode("5");
			document.getElementById("pst_lck_pin_flg").value="Y";
			if (crn_pst_sts_cd.GetSelectCode() != sheetObjects[1].GetCellValue(row, "crn_pst_sts_cd")) {
				ComShowMessage(ComGetMsg("BKG08024"));
			}
			sheetObjects[1].SetCellValue(row, "crn_pst_sts_cd","5");
			sheetObjects[1].SetCellValue(row, "pst_lck_pin_flg","Y");
			document.getElementById("frm_xtd_ovr_qty").disabled=false;
		} else {
			crn_pst_sts_cd.SetSelectCode("E");
			document.getElementById("pst_lck_pin_flg").value="Y";
			sheetObjects[1].SetCellValue(row, "crn_pst_sts_cd","E");
			sheetObjects[1].SetCellValue(row, "pst_lck_pin_flg","Y");
			document.getElementById("frm_xtd_ovr_qty").disabled=true;
		}
	}
	if (sheetObjects[1].GetCellValue(row, "cntr_tpsz_cd") == "A2" || sheetObjects[1].GetCellValue(row, "cntr_tpsz_cd") == "A4") {
		crn_pst_sts_cd.disabled=false;
		document.getElementById("pst_lck_pin_flg").disabled=false;
	} else if (sheetObjects[1].GetCellValue(row, "cntr_tpsz_cd") == "F2" || sheetObjects[1].GetCellValue(row, "cntr_tpsz_cd") == "F4" || sheetObjects[1].GetCellValue(row, "cntr_tpsz_cd") == "F5") {
	} else {
		crn_pst_sts_cd.disabled=true;
		document.getElementById("pst_lck_pin_flg").disabled=true;
	}
}
     /**
		 * Definition for sheet initial setting value, header param : sheetObj
		 * ==> sheet object, sheetNo ==> If the serial number ID tag attached to
		 * the sheet are many, adding 'Case' clause as a number of sheets,
		 * configures initial module.
		 */	
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch (sheetNo) {
	case 1: // sheet1 init
	    with(sheetObj){
		      var HeadTitle1="TP/SZ|BKG Q'ty|AK Q'ty";
		
		      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Float",      Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"op_cntr_qty",   KeyField:0,   CalcLogic:"",   Format:"",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Float",      Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"awk_cgo_qty",   KeyField:0,   CalcLogic:"",   Format:"",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 } ];
		       
		      InitColumns(cols);
		
		      SetEditable(1);
		      SetSheetHeight(99);
        }
		break;
	case 2: // sheet2 init
	    with(sheetObj){
		      var HeadTitle1="Sel.|Seq||Container No.|TS|Vol.|Appr.||bkg_no|rcv_term_cd|de_term_cd|pck_qty|pck_tp_cd|grs_wgt|wgt_ut_cd|net_wgt|cmdt_cd|cmdt_nm|awk_dcgo_seq" + "|ttl_dim_len|ttl_dim_wdt|ttl_dim_hgt|ovr_fwrd_len|ovr_bkwd_len|ovr_lf_len|ovr_rt_len|ovr_hgt|in_ga_flg|ovr_void_slt_qty|crn_pst_sts_cd|xtd_ovr_qty|pst_lck_pin_flg|grav_ctr_desc"
		      + "|stwg_rqst_desc|diff_rmk|modifyAproFlg|cntr_cgo_seq|por_cd|del_cd|apro_cd|und_deck_top_flg|aply_no";
		
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		
		      var cols = [ {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"DelChk" },
		             {Type:"Seq",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",KeyField:0 ,CalcLogic:"",   Format:"",            PointCount:0,UpdateEdit:1,   InsertEdit:1},
		             {Type:"Combo",     Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
		             {Type:"Float",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_vol_qty",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_apro_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"awk_cgo_seq" },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rcv_term_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"de_term_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Int",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pck_qty",            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pck_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Float",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"grs_wgt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"wgt_ut_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Float",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"net_wgt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cmdt_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cmdt_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"awk_dcgo_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Float",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ttl_dim_len",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Float",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ttl_dim_wdt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Float",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ttl_dim_hgt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Float",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ovr_fwrd_len",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Float",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ovr_bkwd_len",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Float",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ovr_lf_len",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Float",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ovr_rt_len",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Float",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ovr_hgt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"in_ga_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Float",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ovr_void_slt_qty",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"crn_pst_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Float",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"xtd_ovr_qty",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",  PointCount:3,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pst_lck_pin_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"grav_ctr_desc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"stwg_rqst_desc",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"diff_rmk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"modifyaproflg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"temp_ovr_void_qty",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_cgo_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"por_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"apro_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"und_deck_top_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"aply_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		       
		      InitColumns(cols);
		
		      SetEditable(1);
		      SetSheetHeight(175);
       	}
		break;
	case 3: // sheet1 init
	    with(sheetObj){
		      var HeadTitle1="bkg_no|bl_no|tvvd|pol_cd|pol_nod_cd|pod_cd|pod_nod_cd|rcv_term_cd|de_term_cd|bkg_sts_cd|corr_n1st_dt|bdr_flg|pck_qty|pck_tp_cd|grs_wgt|grs_ut_cd|act_wgt|wgt_ut_cd";
		
		      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:0 } );
		
		      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		
		      var cols = [ {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"bl_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"vsl_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"pol_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"pol_nod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"pod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"pod_nod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rcv_term_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"de_term_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"bkg_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"corr_n1st_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"corr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"bdr_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Int",      Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"pck_qty",         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"pck_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Float",      Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"grs_wgt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"wgt_ut_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"cmdt_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"cmdt_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"vsl_pre_pst_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"act_wgt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"wgt_ut_cd2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"img_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
		       
		      InitColumns(cols);
		
		      SetEditable(1);
		      SetVisible(false);
        }
		break;
	// dimension pop-up을 클릭할 경우... 항목에 맞는 sheet값을 구하여 pop-up으로 넘긴다.
	case 4: // sheet1 init
	    with(sheetObj){
		      var HeadTitle1="|||Length(CM)|Width(CM)|Height(CM)||awk_cgo_seq|bkg_no|dim_seq";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		
		      var cols = [ {Type:"DummyCheck", Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"DelChk" },
		             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		             {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"Text",      Hidden:0, Width:105,  Align:"Center",  ColMerge:1,   SaveName:"dim_len",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"dim_wdt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dim_hgt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"indiv_pck_wgt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"awk_cgo_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dim_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		       
		      InitColumns(cols);
		      SetEditable(1);

		      SetVisible(false);
        }
		break;
	// cntr_no의 select 값을 셋팅하기 위한 hidden sheet... 체크되지 않은 row의 값을 구하여 cntr_no에
	// 값을 셋팅한다.
	case 5: // sheet1 init
	    with(sheetObj){
		      if (location.hostname != "")
		      var HeadTitle1="|value|name|TpszCd|Vol.|rcvTerm|deTerm";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      (7, 0, 0, true);
		
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		
		      var cols = [ {Type:"DummyCheck", Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"DelChk" },
		             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"val",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"name",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_vol_qty",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rcv_term_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"de_term_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		       
		      InitColumns(cols);
		      SetEditable(1);
		      SetVisible(false)
        }
		break;
	case 6:
	    with(sheetObj){
		      (2, 0, 0, true);
		      var HeadTitle="|";
		
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);
		
		      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		             {Type:"Radio",     Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"chk" } ];
		       
		      InitColumns(cols);
		      SetEditable(1);
		      SetVisible(false)
        }
		break;
	}
}
// Handling process about Sheet
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case INIT:      // Default
		sheetObjects[0].SetWaitImageVisible(1);
		formObj.f_cmd.value=INIT;
		var sXml=sheetObj.GetSearchData("ESM_BKG_0055GS.do", FormQueryString(formObj));
		var arrXml=sXml.split("|$$|");
		if (0 < arrXml.length) {
			ComBkgXml2ComboItem(arrXml[0], rcv_term_cd, "val", "name");
		}
		if (1 < arrXml.length) {
			ComBkgXml2ComboItem(arrXml[1], de_term_cd, "val", "name");
		}
		if (2 < arrXml.length) {
			ComBkgXml2ComboItem(arrXml[2], crn_pst_sts_cd, "val", "name");
		}
		var rcvTermCd=ComGetEtcData(arrXml[0],"rcv_term_cd");
		var deTermCd=ComGetEtcData(arrXml[0],"de_term_cd");
		comboObjects[0].SetSelectCode(rcvTermCd != "" ? rcvTermCd : "Y",false);
		comboObjects[1].SetSelectCode(deTermCd != "" ? deTermCd : "Y",false);
		//sheetObjects[0].SetWaitImageVisible(0);
		sheetObjects[0].WaitImageVisible=false;
		break;
	case SEARCH: // inquiry
		ComOpenWait(true);
		if (validateForm(sheetObj, formObj, sAction))
		sheetObjects[0].SetWaitImageVisible(1);
		formObj.f_cmd.value=SEARCH;
		var resultXml=sheetObj.GetSearchData("ESM_BKG_0055GS.do",FormQueryString(formObj));
		var arrXml=resultXml.split("|$$|");
		if (arrXml.length == 5) {
			var etcXml=arrXml[0];
			if (ComGetEtcData(etcXml, "rqst_dt") == "null" || ComGetEtcData(etcXml, "rqst_dt") == "") {
				document.getElementById("rqst_dt").value = "";
				document.getElementById("rqst_gdt").value = "";
				document.getElementById("rqst_usr_id").value = "";
			} else {
				document.getElementById("rqst_dt").value = ComGetEtcData(etcXml, "rqst_dt");
				document.getElementById("rqst_gdt").value = ComGetEtcData(etcXml, "rqst_gdt");
				document.getElementById("rqst_usr_id").value = ComGetEtcData(etcXml, "rqst_usr_id");
			}
			// ibsheet combo part
			if (arrXml[3].indexOf("TOTAL='0'") < 1) {
				var arrCombo=ComXml2ComboString(arrXml[3], "val", "name");
				sheetObjects[1].SetColProperty("cntr_no", {ComboText:arrCombo[0], ComboCode:arrCombo[1]} );
			}
			// Setting retrieved xmml value in to each sheet.
			sheetObjects[0].LoadSearchData(arrXml[1],{Sync:1} );
			sheetObjects[1].LoadSearchData(arrXml[0],{Sync:1} );
			sheetObjects[2].LoadSearchData(arrXml[2],{Sync:1} );
			sheetObjects[3].LoadSearchData(arrXml[4],{Sync:1} );
			sheetObjects[4].LoadSearchData(arrXml[3],{Sync:1} );
//			if(sheetObjects[1].GetCellValue(1, "bkg_no") == -1){
//				ComShowCodeMessage("BKG00273");
//				ComOpenWait(false);
//				return false;
//			}
			if(sheetObjects[0].RowCount() < 1){
				ComShowMessage(ComGetMsg("BKG00502"));
//				ComResetAll();
				return;
			}
			if(sheetObjects[2].RowCount() > 0){
				document.getElementById("bkg_no").value = sheetObjects[2].GetCellValue(1,"bkg_no");
				document.getElementById("old_bkg_no").value = sheetObjects[2].GetCellValue(1,"bkg_no");
				document.getElementById("bl_no").value = sheetObjects[2].GetCellValue(1, "bl_no");
			}else{
				document.getElementById("bl_no").value = "";
				document.getElementById("old_bkg_no").value = "";
			}
//			var d7Type=sheetObjects[0].FindText("cntr_tpsz_cd", "D7", 0, 2);
//			// adding row in case rowcount is 0 and D7 as belows.
//			if (sheetObjects[1].RowCount()< 1 && d7Type > 0 && document.getElementById("bl_no").value != "") {
//				document.getElementById("auth_cd").value="";
//				checkAdd();
//				alert('checkAdd')
//				sheetObjects[1].SetCellValue(1, "cntr_tpsz_cd","D7",0);
//				document.getElementById("cntr_tpsz_cd").value="D7";
//				sheetObjects[1].SetCellValue(1, "grs_wgt",sheetObjects[2].GetCellValue(1, "act_wgt"),0);
//				sheetObjects[1].SetCellValue(1, "net_wgt",sheetObjects[2].GetCellValue(1, "act_wgt"),0);
//				sheetObjects[1].SetCellValue(1, "wgt_ut_cd",sheetObjects[2].GetCellValue(1, "wgt_ut_cd"),0);
//				sheetObjects[1].SetCellValue(1, "in_ga_flg","Y",0);
//				document.getElementById("inGauge").checked=true;
//				// htmlSheetSync();
//			} else if (sheetObjects[1].RowCount()< 1 && d7Type < 1 && document.getElementById("bl_no").value != "") {
//				document.getElementById("auth_cd").value="";
//				checkAdd();
//			} else if (sheetObjects[1].RowCount()< 1 && document.getElementById("bl_no").value == "") {
//				ComShowCodeMessage("BKG00183", document.getElementById("bkg_no").value);
//				ComResetAll();
//				return;
//			}
			
			// readOnly in case de_term_cd is 'M'
			if (sheetObjects[2].GetCellValue(1, "de_term_cd") == "M") {
				// de_term_cd.disabled = false;
			} else {
				// de_term_cd.disabled = true;
			}
			// readOnly in case rcv_term_cd is 'M'
			if (sheetObjects[2].GetCellValue(1, "rcv_term_cd") == "M") {
				rcv_term_cd.Enable = true;
			} else {
				rcv_term_cd.Enable = false;
			}
			for ( var i=1; i <= sheetObjects[3].RowCount(); i++) {
				sheetObjects[3].SetCellValue(i, "ibflag","I");
			}
//			if (document.getElementById("bkg_no").value == "") {
//				document.getElementById("bkg_no").value=sheetObjects[1].GetCellValue(1, "bkg_no");
//			}
			if(sheetObjects[2].RowCount() > 0){
				document.getElementById("tvvd").value = sheetObjects[2].GetCellValue(1, "vsl_cd");
				document.getElementById("pol_cd").value = sheetObjects[2].GetCellValue(1, "pol_cd");
				document.getElementById("pol_nod_cd").value = sheetObjects[2].GetCellValue(1, "pol_nod_cd");
				document.getElementById("pod_cd").value = sheetObjects[2].GetCellValue(1, "pod_cd");
				document.getElementById("pod_nod_cd").value = sheetObjects[2].GetCellValue(1, "pod_nod_cd");
				document.getElementById("package_sum").value = sheetObjects[2].GetCellValue(1, "pck_qty");
				document.getElementById("pck_tp_cd").value = sheetObjects[2].GetCellValue(1, "pck_tp_cd");
				document.getElementById("weight_sum").value = sheetObjects[2].GetCellText(1, "grs_wgt");
				document.getElementById("wgt_ut_cd").value = sheetObjects[2].GetCellValue(1, "wgt_ut_cd");
				document.getElementById("frm_xtd_ovr_qty").value = sheetObjects[1].GetCellText(1, "xtd_ovr_qty");
			}
			for ( var j=1; j <= sheetObjects[1].RowCount(); j++) {
				// checking value of retrieved cntr_no in sheetObjects[4]
				if (sheetObjects[1].GetCellValue(j, "cntr_no") != "") {
					var cntr_no=sheetObjects[1].GetCellValue(j, "cntr_no");
					var find_row=sheetObjects[4].FindText("name", cntr_no, 0, 2);
					sheetObjects[4].SetCellValue(find_row, "DelChk","1");
				}
				// changing bold & red color in case appr. is 'N'
				if (sheetObjects[1].GetCellValue(j, "spcl_cgo_apro_cd") == "N") {
					sheetObjects[1].SetCellFontColor(j,"spcl_cgo_apro_cd","#FF0000");
					sheetObjects[1].SetCellFont("FontBold", j,"spcl_cgo_apro_cd",1);
				}
			}
			var cnt=0;
			// Setting auth_cd value depending on appr. value.
			// if 'N', bold red colr, if not, bold black colors.
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
				document.getElementById("auth_cd").style.fontWeight="bold";
			}
			for ( var i=1; i <= sheetObjects[1].RowCount(); i++) {
				sheetObjects[1].SetCellValue(i, "seq",i,0);
// if (sheetObjects[1].CellValue(i, "cntr_tpsz_cd") != "") {
					sheetObjects[1].SetCellValue(i, "ibflag","R",0);
// }
					if (sheetObjects[1].GetCellValue(i, "spcl_cgo_apro_cd") == "Y") {
					cnt++;
				}
			}
			// htmlSheetSync();
			// Checking whether D7 exists in sheetObjects[0]
			var d7Type=sheetObjects[0].FindText("cntr_tpsz_cd", "D7", 0, 2);
			// adding row in case rowcount is 0 and D7 as belows.
			if (sheetObjects[1].RowCount()< 1 && d7Type > 0 && document.getElementById("bl_no").value != "") {
				document.getElementById("auth_cd").value="";
				checkAdd();
				sheetObjects[1].SetCellValue(1, "cntr_tpsz_cd","D7",0);
				document.getElementById("cntr_tpsz_cd").value="D7";
				sheetObjects[1].SetCellValue(1, "grs_wgt",sheetObjects[2].GetCellValue(1, "act_wgt"),0);
				sheetObjects[1].SetCellValue(1, "net_wgt",sheetObjects[2].GetCellValue(1, "act_wgt"),0);
				sheetObjects[1].SetCellValue(1, "wgt_ut_cd",sheetObjects[2].GetCellValue(1, "wgt_ut_cd"),0);
				sheetObjects[1].SetCellValue(1, "in_ga_flg","Y",0);
				document.getElementById("inGauge").checked=true;
				// htmlSheetSync();
			} else if (sheetObjects[1].RowCount()< 1 && d7Type < 1 && document.getElementById("bl_no").value != "") {
				document.getElementById("auth_cd").value="";
				checkAdd();
			} else if (sheetObjects[1].RowCount()< 1 && document.getElementById("bl_no").value == "") {
				ComShowCodeMessage("BKG00183", document.getElementById("bkg_no").value);
				ComResetAll();
				return;
			}
			htmlSheetSync();
			document.getElementById("frm_seq").value=sheetObjects[1].GetCellValue(1, "seq");
			sheet2SelectedRow=0;
		}
		// ------------------------------------------------>
		// setInquiryDisableButton event calling
		if (ComGetObjValue(document.form.isInquiry) == "Y") {
			setInquiryDisableButton();
		}
		break;
	// bkg_split_no inquiry & setting
	case COMMAND04: // booking split noinquiry
		formObj.f_cmd.value=COMMAND03;
		var param="&f_cmd=" + COMMAND03 + "&bkg_no=" + ComGetObjValue(formObj.bkg_no);
		var sXml=sheetObj.GetSearchData("ESM_BKG_0079_01GS.do", param);
		var bkg_split_no_list=ComGetEtcData(sXml, "bkg_split_no_list");
		bkgSplitNoListPop(formObj.bkg_no, bkg_split_no_list, 20);
		break;
	// saving logic
	case COMMAND01:
		if (validateForm(sheetObj, formObj, sAction))
			if (sheetObjects[2].GetCellValue(1, "corr_no") == "" && sheetObjects[2].GetCellValue(1, "bdr_flg") == "Y") {
				ComShowMessage(ComGetMsg("BKG00004"));
				chkFlg="Y";
				return;
			}
		// saving validation check part
		var r_row=0;
		var d_row=0;
		var voidSpaceSum=0;
		var bkg0520Cnt=0;
		var requestCnt=0;
		var awkChkFlg="N";
		var cntrNo="";
		var oldCntrNo="";
		for ( var i=1; i <= sheetObjects[1].RowCount(); i++) {
			// Skipping validate in case of deleting
			if(sheetObjects[1].GetRowHidden(i)||sheetObjects[1].GetCellValue(i, "ibflag") == "D"){
				continue;
			}
			// if (sheetObjects[1].CellValue(i, "ibflag") == "D") continue;
			if (sheetObjects[1].GetCellValue(i, "apro_cd") != "C" || sheetObjects[1].GetCellValue(i, "spcl_cgo_apro_cd") != "") {
				if (sheetObjects[1].GetCellValue(i, "spcl_cgo_apro_cd") == "P") {
					ComShowMessage(ComGetMsg("BKG00500"));
					chkFlg="Y";
					return;
				}
				if (sheetObjects[1].GetCellValue(i, "ibflag") == "R") {
					r_row++;
				}
				if (sheetObjects[1].GetCellValue(i, "ibflag") == "D") {
					d_row++;
				}
				if (sheetObjects[1].GetCellValue(i, "ibflag") != "D") {
					voidSpaceSum += Number(sheetObjects[1].GetCellValue(i, "ovr_void_slt_qty"));
				}
				if (sheetObjects[1].GetCellValue(i, "cntr_tpsz_cd") == "") {
					ComShowMessage(ComGetMsg("BKG08126"));
					chkFlg="Y";
					sheetObjects[1].SelectCell(i, "cntr_tpsz_cd");
					return;
				}
				if (sheetObjects[1].GetCellValue(i, "ttl_dim_len") == "" || sheetObjects[1].GetCellValue(i, "ttl_dim_wdt") == "" || sheetObjects[1].GetCellValue(i, "ttl_dim_hgt") == "" || sheetObjects[1].GetCellValue(i, "ttl_dim_len") == "0" || sheetObjects[1].GetCellValue(i, "ttl_dim_wdt") == "0" || sheetObjects[1].GetCellValue(i, "ttl_dim_hgt") == "0") {
					ComShowMessage(ComGetMsg("BKG08026"));
					chkFlg="Y";
					return;
				}
				if (sheetObjects[1].GetCellValue(i, "cntr_tpsz_cd") != "D7") {
					if (sheetObjects[1].GetCellValue(i, "pck_qty") == "0") {
						ComShowMessage(ComGetMsg("BKG00504"));
						chkFlg="Y";
						return;
					}
					if (sheetObjects[1].GetCellValue(i, "pck_tp_cd") == "") {
						ComShowMessage(ComGetMsg("BKG00505"));
						chkFlg="Y";
						return;
					}
					if (sheetObjects[1].GetCellValue(i, "grs_wgt") == "" || sheetObjects[1].GetCellValue(i, "grs_wgt") == "0") {
						ComShowMessage(ComGetMsg("BKG00506"));
						chkFlg="Y";
						return;
					}
					if (sheetObjects[1].GetCellValue(i, "wgt_ut_cd") == "") {
						ComShowMessage(ComGetMsg("BKG00507"));
						chkFlg="Y";
						return;
					}
					if (sheetObjects[1].GetCellValue(i, "net_wgt") == "" || sheetObjects[1].GetCellValue(i, "net_wgt") == "0") {
						ComShowMessage(ComGetMsg("BKG00508"));
						chkFlg="Y";
						return;
					}
					if (sheetObjects[1].GetCellValue(i, "cmdt_cd") == "") {
						ComShowMessage(ComGetMsg("BKG00510"));
						chkFlg="Y";
						return;
					}
					if (sheetObjects[1].GetCellValue(i, "ttl_dim_len") == "" || sheetObjects[1].GetCellValue(i, "ttl_dim_len") == 0 || sheetObjects[1].GetCellValue(i, "ttl_dim_wdt") == "" || sheetObjects[1].GetCellValue(i, "ttl_dim_wdt") == 0 || sheetObjects[1].GetCellValue(i, "ttl_dim_hgt") == "" || sheetObjects[1].GetCellValue(i, "ttl_dim_hgt") == 0) {
						ComShowMessage(ComGetMsg("BKG00511"));
						chkFlg="Y";
						return;
					}
					
					if (sheetObjects[1].GetCellValue(i, "crn_pst_sts_cd") != "" && sheetObjects[1].GetCellValue(i, "crn_pst_sts_cd") != "E" && sheetObjects[1].GetCellValue(i, "cntr_tpsz_cd") != "P4" && sheetObjects[1].GetCellValue(i, "cntr_tpsz_cd") != "P2" && sheetObjects[1].GetCellValue(i, "cntr_tpsz_cd") != "F4" && sheetObjects[1].GetCellValue(i, "cntr_tpsz_cd") != "F2"
						&& sheetObjects[1].GetCellValue(i, "cntr_tpsz_cd") != "A4" && sheetObjects[1].GetCellValue(i, "cntr_tpsz_cd") != "A2" && sheetObjects[1].GetCellValue(i, "cntr_tpsz_cd") != "F5") {
						ComShowMessage(ComGetMsg("BKG00516"));
						chkFlg="Y";
						return;
					}
					if (sheetObjects[1].GetCellValue(i, "cntr_tpsz_cd").indexOf("A") > -1 && sheetObjects[1].GetCellValue(i, "crn_pst_sts_cd") == "") {
						ComShowMessage(ComGetMsg("BKG00517"));
						chkFlg="Y";
						return;
					}
					if (sheetObjects[1].GetCellValue(i, "cntr_tpsz_cd").indexOf("A") > -1 && sheetObjects[1].GetCellValue(i, "pst_lck_pin_flg") == "") {
						if (sheetObjects[1].GetCellValue(i, "crn_pst_sts_cd") != "E" && sheetObjects[1].GetCellValue(i, "crn_pst_sts_cd") != "F" && sheetObjects[1].GetCellValue(i, "crn_pst_sts_cd") != "") {
							ComShowMessage(ComGetMsg("BKG00519"));
							chkFlg="Y";
							return;
						}
					}
					// Making Flg to transfer Vendor 301 when Cntr No modified.
					cntrNo=sheetObjects[1].GetCellValue(i, "cntr_no");
					oldCntrNo=sheetObjects[1].CellSearchValue(i, "cntr_no");
					if ( awkChkFlg == "N" && cntrNo != oldCntrNo ) {
						awkChkFlg="Y";
					}
				}
			}
		}
		var o_cnt=0;
		for ( var j=1; j <= sheetObjects[0].RowCount(); j++) {
			if (sheetObjects[0].GetCellValue(j, "cntr_tpsz_cd") == "Q2") {
				o_cnt += Number(sheetObjects[0].GetCellValue(j, "awk_cgo_qty")) / 2;
			}
			if (sheetObjects[0].GetCellValue(j, "cntr_tpsz_cd") == "Q4") {
				o_cnt += Number(sheetObjects[0].GetCellValue(j, "awk_cgo_qty"));
			}
			if (sheetObjects[0].GetCellValue(j, "awk_cgo_qty") == 0 && d_row > 0) {
				ComShowCodeMessage("BKG00502", "AK");
				chkFlg="Y";
				return;
			}
			var cnt=0;
			var rcnt=0;
			var find_tpsz_cd="";
			for ( var m=1; m <= sheetObjects[1].RowCount(); m++) {
				// Excluding cancelled or deleted row
				if (sheetObjects[1].GetCellValue(m, "apro_cd") != "C" && sheetObjects[1].GetCellValue(m, "spcl_cgo_apro_cd") != "C" && sheetObjects[1].GetCellValue(m, "ibflag") != "D") {
					if (sheetObjects[1].GetCellValue(m, "cntr_tpsz_cd").indexOf("Q") > -1) {
						ComShowMessage(ComGetMsg("BKG08023"));
						chkFlg="Y";
						return;
					}
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
			var find_tpsz_cd=sheetObjects[1].FindText("cntr_tpsz_cd", sheetObjects[0].GetCellValue(j, "cntr_tpsz_cd"), 0, 2);
			if (find_tpsz_cd > 0) {
				if (Number(sheetObjects[0].GetCellValue(j, "awk_cgo_qty")) > cnt) {
					if (ComShowConfirm(ComGetMsg("BKG00678", "AK"))) {
						cnt=0;
					} else {
						chkFlg="Y";
						return;
					}
				}
				if (Number(sheetObjects[0].GetCellValue(j, "awk_cgo_qty")) < cnt) {
					ComShowCodeMessage("BKG00679", "AK");
					chkFlg="Y";
					return;
				}
			}
		}
		var dimRow = sheetObjects[3].RowCount("R");
		if (sheetObjects[1].RowCount()== r_row && sheetObjects[3].RowCount()== dimRow) {
			// if(reqFlag != "N"){
			ComShowMessage(ComGetMsg("BKG00501"));
			chkFlg="Y";
			// }
			return;
		}
		if (o_cnt != voidSpaceSum) {
			ComShowMessage(ComGetMsg("BKG00964"));
		}
		// var find_row = sheetObjects[1].FindText("modifyaproflg", "Y", 0, 2);
		formObj.f_cmd.value=MULTI;
		var sParam=FormQueryString(formObj);
		// Making Flg to transfer Vendor 301 when Cntr No modified.
		sParam=sParam + "&" + "awk_chk_flg=" + awkChkFlg;
		var sParamSheet1=sheetObjects[1].GetSaveString();
		var sParamSheet2=sheetObjects[3].GetSaveString();
		if (sParamSheet1 != "") {
			sParam=sParam + "&sheet1_" + sParamSheet1.replace(/&/g, '&sheet1_');
		}
		if (sParamSheet2 != "") {
			sParam=sParam + "&sheet2_" + sParamSheet2.replace(/&/g, '&sheet2_');
		} else {
			var Row=sheetObjects[3].DataInsert(-1);
			sheetObjects[3].SetCellValue(Row, "DelChk","0",0);
			sheetObjects[3].SetCellValue(Row, "ibflag","U",0);
			sheetObjects[3].SetCellValue(Row, "dim_len","0",0);
			sheetObjects[3].SetCellValue(Row, "dim_wdt","0",0);
			sheetObjects[3].SetCellValue(Row, "dim_hgt","0",0);
			sheetObjects[3].SetCellValue(Row, "indiv_pck_wgt","0",0);
			sheetObjects[3].SetCellValue(Row, "awk_cgo_seq","0",0);
			sheetObjects[3].SetCellValue(Row, "bkg_no",document.getElementById("bkg_no").value,0);
			sheetObjects[3].SetCellValue(Row, "dim_seq","1",0);
			var sParamSheet3=sheetObjects[3].GetSaveString();
			sParam=sParam + "&sheet2_" + sParamSheet3.replace(/&/g, '&sheet2_');
		}
		var rXml=sheetObj.GetSaveData("ESM_BKG_0055GS.do", sParam);
		var rMsg=ComResultMessage(rXml);
		var State=ComGetEtcData(rXml, ComWebKey.Trans_Result_Key);
		// AK 저장시에 PSA 전송되도록 수정함. [CHM-201006332-01]
		if(ComGetEtcData(rXml, "psaValCode") != "Y" && ComGetEtcData(rXml, "psaValCode") != undefined){						
			var errMsg01=ComGetEtcData(rXml,"psaValCode");
			if(errMsg01 != undefined && errMsg01 != null && errMsg01 != "") {
		    	var rmsg=errMsg01.split("<||>");
		    	if(rmsg[1] != undefined && rmsg[1].length > 0 && rmsg[1] == "BKG95027" ) {
		    		ComShowCodeMessage("BKG06125");
		    	}else if ( rmsg[1] != "BKG95025" ){
		    		ComShowMessage(rmsg[3]);
		    	}
			}		    	
		}
		if (State == "S") {
			ComShowMessage(ComGetMsg("BKG00166"));
			// After saving completed normally, screen viewed again in case
			// retFlag is 'Y'.
			retFlag="Y";
			saveSuccess="Y";
		} else if (rMsg == '' && reqFlag == "N") {
			ComShowMessage(ComGetMsg("BKG00167"));
			return false;
		} else if (State == undefined) {
			ComShowMessage(ComGetMsg("BKG00167"));
			return false;
		} else {
//			sheetObj.LoadSearchData(rXml,{Sync:1} );
			ComShowMessage(rMsg);
			return false;
		}
		break;
	// When request button click
	case COMMAND02: // request...
		formObj.button.value="N";
		if (validateForm(sheetObj, formObj, sAction))
			formObj.f_cmd.value=COMMAND02;
		var sParam=FormQueryString(formObj);
		var sParamSheet1=sheetObjects[1].GetSaveString();
		if (sParamSheet1 != "") {
			sParam=sParam + "&sheet1_" + sParamSheet1.replace(/&/g, '&sheet1_');
		}
		var rXml=sheetObj.GetSaveData("ESM_BKG_0055GS.do", sParam);
		var rMsg=ComResultMessage(rXml);
		var State=ComGetEtcData(rXml, ComWebKey.Trans_Result_Key);
		// Modified to transfer PAS when saving AK
		if(ComGetEtcData(rXml, "psaValCode") != "Y" && ComGetEtcData(rXml, "psaValCode") != undefined){						
			var errMsg01=ComGetEtcData(rXml,"psaValCode");
	    	var rmsg=errMsg01.split("<||>");
	    	if(rmsg[1] != undefined && rmsg[1].length > 0 && rmsg[1] == "BKG95027" ) {
	    		ComShowCodeMessage("BKG06125");
	    	}else if ( rmsg[1] != "BKG95025" ){
	    		ComShowMessage(rmsg[3]);
	    	}
		}
		if (rMsg == '' && messageFlg == "save") {
			// ComShowMessage(ComGetMsg("BKG00166"));
			// After saving completed normally, screen viewed again in case
			// retFlag is 'Y'.
			retFlag="Y";
		} else if (rMsg == '' && messageFlg == "request") {
			ComShowMessage(ComGetMsg("BKG08102"));
			retFlag="Y";
		} else if (rMsg == '' && messageFlg == "requestCancel") {
			ComShowMessage(ComGetMsg("BKG08103"));
			retFlag="Y";
		} else {
			sheetObj.LoadSearchData(rXml,{Sync:1} );
			return false;
		}
		break;
	// When request cancel을 button click
	case COMMAND03: // request cancel...
		formObj.button.value="Y";
		if (validateForm(sheetObj, formObj, sAction))
			formObj.f_cmd.value=COMMAND02;
		var sParam=FormQueryString(formObj);
		var sParamSheet1=sheetObjects[1].GetSaveString();
		if (sParamSheet1 != "") {
			sParam=sParam + "&sheet1_" + sParamSheet1.replace(/&/g, '&sheet1_');
		}
		var rXml=sheetObj.GetSaveData("ESM_BKG_0055GS.do", sParam);
		var rMsg=ComResultMessage(rXml);
		var State=ComGetEtcData(rXml, ComWebKey.Trans_Result_Key);
		if (rMsg == '' && messageFlg == "save") {
			// ComShowMessage(ComGetMsg("BKG00166"));
			// After saving completed normally, screen viewed again in case
			// retFlag is 'Y'.
			retFlag="Y";
		} else if (rMsg == '' && messageFlg == "request") {
			ComShowMessage(ComGetMsg("BKG08102"));
			retFlag="Y";
		} else if (rMsg == '' && messageFlg == "requestCancel") {
			ComShowMessage(ComGetMsg("BKG08103"));
			retFlag="Y";
		} else {
			sheetObj.LoadSearchData(rXml,{Sync:1} );
			return false;
		}
		break;
	// After inquiry using cmdt_cd value, setting value in cmdt_nm
	case COMMAND05:
		if (validateForm(sheetObj, formObj, sAction)) {
			//sheetObj.SetWaitImageVisible(0);

			sheetObj.WaitImageVisible=false;
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
			sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "cmdt_nm",cmdt_nm,0);
			sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "modifyaproflg","Y",0);
			sheetObj.SetWaitImageVisible(1);
			cmdtFlg="";
		} else {
			return false;
		}
		break;
	}
}
// Setting sheet data of clicked row in html in case sheet click.
function htmlSheetSync() {
	var formObject=document.form;
	Row=sheetObjects[1].GetSelectRow();
	IBS_CopyRowToForm(sheetObjects[1], form, Row);
	document.getElementById("frm_pck_qty").value=sheetObjects[1].GetCellText(Row, "pck_qty");
	document.getElementById("frm_grs_wgt").value=sheetObjects[1].GetCellText(Row, "grs_wgt");
	document.getElementById("frm_net_wgt").value=sheetObjects[1].GetCellText(Row, "net_wgt");
	document.getElementById("temp_grs_wgt").value=sheetObjects[1].GetCellText(Row, "grs_wgt");
	document.getElementById("temp_net_wgt").value=sheetObjects[1].GetCellText(Row, "net_wgt");
	document.getElementById("temp_cntr_no").value=sheetObjects[1].GetCellValue(Row, "cntr_no");
	rcv_term_cd.SetSelectCode(sheetObjects[1].GetCellValue(Row, "rcv_term_cd"));
	de_term_cd.SetSelectCode(sheetObjects[1].GetCellValue(Row, "de_term_cd"));
	document.getElementById("frm_cntr_cgo_seq").value=sheetObjects[1].GetCellValue(Row, "awk_dcgo_seq");
	document.getElementById("cmdt_cd").value=sheetObjects[1].GetCellValue(Row, "cmdt_cd");
	document.getElementById("cmdt_nm").value=sheetObjects[1].GetCellValue(Row, "cmdt_nm");
	document.getElementById("aply_no").value=sheetObjects[1].GetCellValue(Row, "aply_no");
	if (sheetObjects[1].GetCellValue(Row, "cntr_no") != "") {
		de_term_cd.Enable = false
		rcv_term_cd.Enable = false;
		sheetObjects[1].SetCellEditable(Row, "cntr_vol_qty",0);
	} else {
		sheetObjects[1].SetCellEditable(Row, "cntr_vol_qty",1);
		if (sheetObjects[2].GetCellValue(1, "de_term_cd") == "M") {
			de_term_cd.Enable= true;
		} else {
			de_term_cd.Enable= false;
		}
		if (sheetObjects[2].GetCellValue(1, "rcv_term_cd") == "M") {
			rcv_term_cd.Enable= true;
		} else {
			rcv_term_cd.Enable= false;
		}
	}
	// temporary saving
	var v_ibflag=sheetObjects[1].GetCellValue(Row, "ibflag");
	// Setting below value in to default in html & sheet in case type/size value
	// is D7.
	if (sheetObjects[1].GetCellValue(Row, "cntr_tpsz_cd") == "D7") {
		if(sheetObjects[1].GetCellValue(Row, "ttl_dim_len") == 0){
			document.getElementById("ttl_dim_len").value="1317.6";
		}else{	document.getElementById("ttl_dim_len").value=sheetObjects[1].GetCellValue(Row, "ttl_dim_len");
		}
		if(sheetObjects[1].GetCellValue(Row, "ttl_dim_wdt") == 0){
			document.getElementById("ttl_dim_wdt").value="243.8";
		}else{	document.getElementById("ttl_dim_wdt").value=sheetObjects[1].GetCellValue(Row, "ttl_dim_wdt");
		}
		if(sheetObjects[1].GetCellValue(Row, "ttl_dim_hgt") == 0){
			document.getElementById("ttl_dim_hgt").value="289.6";
		}else{	document.getElementById("ttl_dim_hgt").value=sheetObjects[1].GetCellValue(Row, "ttl_dim_hgt");
		}
		if(sheetObjects[1].GetCellValue(Row, "ovr_fwrd_len") == 0){
			document.getElementById("ovr_fwrd_len").value="0";
		}else{	document.getElementById("ovr_fwrd_len").value=sheetObjects[1].GetCellValue(Row, "ovr_fwrd_len");
		}
		if(sheetObjects[1].GetCellValue(Row, "ovr_bkwd_len") == 0){
			document.getElementById("ovr_bkwd_len").value="0";
		}else{	document.getElementById("ovr_bkwd_len").value=sheetObjects[1].GetCellValue(Row, "ovr_bkwd_len");
		}	
		if(sheetObjects[1].GetCellValue(Row, "ovr_lf_len") == 0){
			document.getElementById("ovr_lf_len").value="0";
		}else{	document.getElementById("ovr_lf_len").value=sheetObjects[1].GetCellValue(Row, "ovr_lf_len");
		}
		if(sheetObjects[1].GetCellValue(Row, "ovr_rt_len") == 0){
			document.getElementById("ovr_rt_len").value="0";
		}else{	document.getElementById("ovr_rt_len").value=sheetObjects[1].GetCellValue(Row, "ovr_rt_len");
		}
		if(sheetObjects[1].GetCellValue(Row, "ovr_hgt") == 0){
			document.getElementById("ovr_hgt").value="0";
		}else{	document.getElementById("ovr_hgt").value=sheetObjects[1].GetCellValue(Row, "ovr_hgt");
		}
		if(sheetObjects[1].GetCellValue(Row, "ovr_void_slt_qty") == 0){
			document.getElementById("ovr_void_slt_qty").value="0";
		}else{	document.getElementById("ovr_void_slt_qty").value=sheetObjects[1].GetCellValue(Row, "ovr_void_slt_qty");
		}
		sheetObjects[1].SetCellValue(Row, "ttl_dim_len",Math.round(parseFloat(document.getElementById("ttl_dim_len").value)) ,0);
		sheetObjects[1].SetCellValue(Row, "ttl_dim_wdt",Math.round(parseFloat(document.getElementById("ttl_dim_wdt").value)) ,0);
		sheetObjects[1].SetCellValue(Row, "ttl_dim_hgt",Math.round(parseFloat(document.getElementById("ttl_dim_hgt").value)) ,0);
		sheetObjects[1].SetCellValue(Row, "ovr_fwrd_len",document.getElementById("ovr_fwrd_len").value,0);
		sheetObjects[1].SetCellValue(Row, "ovr_bkwd_len",document.getElementById("ovr_bkwd_len").value,0);
		sheetObjects[1].SetCellValue(Row, "ovr_lf_len",document.getElementById("ovr_lf_len").value,0);
		sheetObjects[1].SetCellValue(Row, "ovr_rt_len",document.getElementById("ovr_rt_len").value,0);
		sheetObjects[1].SetCellValue(Row, "ovr_hgt",document.getElementById("ovr_hgt").value,0);
		sheetObjects[1].SetCellValue(Row, "ovr_void_slt_qty",document.getElementById("ovr_void_slt_qty").value,0);
	} else {
		document.getElementById("ttl_dim_len").value=Math.round(parseFloat(sheetObjects[1].GetCellValue(Row, "ttl_dim_len"))) ;
		document.getElementById("ttl_dim_wdt").value=Math.round(parseFloat(sheetObjects[1].GetCellValue(Row, "ttl_dim_wdt"))) ;
		document.getElementById("ttl_dim_hgt").value=Math.round(parseFloat(sheetObjects[1].GetCellValue(Row, "ttl_dim_hgt"))) ;
		document.getElementById("ovr_fwrd_len").value=Math.round(parseFloat(sheetObjects[1].GetCellValue(Row, "ovr_fwrd_len"))) ;
		document.getElementById("ovr_bkwd_len").value=Math.round(parseFloat(sheetObjects[1].GetCellValue(Row, "ovr_bkwd_len"))) ;
		document.getElementById("ovr_lf_len").value=Math.round(parseFloat(sheetObjects[1].GetCellValue(Row, "ovr_lf_len"))) ;
		document.getElementById("ovr_rt_len").value=Math.round(parseFloat(sheetObjects[1].GetCellValue(Row, "ovr_rt_len"))) ;
		document.getElementById("ovr_hgt").value=Math.round(parseFloat(sheetObjects[1].GetCellValue(Row, "ovr_hgt"))) ;
		document.getElementById("ovr_void_slt_qty").value=sheetObjects[1].GetCellValue(Row, "ovr_void_slt_qty");
		sheetObjects[1].SetCellValue(Row, "temp_ovr_void_qty",sheetObjects[1].GetCellValue(Row, "ovr_void_slt_qty"),0);		
	}
		sheetObjects[1].SetCellValue(Row, "ibflag",v_ibflag,0);
		document.getElementById("wgt_ut_cd1").value=sheetObjects[1].GetCellValue(Row, "wgt_ut_cd");
		document.getElementById("wgt_ut_cd2").value=sheetObjects[1].GetCellValue(Row, "wgt_ut_cd");
		crn_pst_sts_cd.SetSelectCode(sheetObjects[1].GetCellValue(Row, "crn_pst_sts_cd"));
		document.getElementById("pst_lck_pin_flg").value=sheetObjects[1].GetCellValue(Row, "pst_lck_pin_flg");
		document.getElementById("temp_cntr_no").value=sheetObjects[1].GetCellValue(Row, "cntr_no");
		document.getElementById("cntr_tpsz_cd").value=sheetObjects[1].GetCellValue(Row, "cntr_tpsz_cd");
		if (sheetObjects[1].GetCellValue(Row, "in_ga_flg") == "Y") {
			document.getElementById("inGauge").checked=true;
		} else {
			document.getElementById("inGauge").checked=false;
		}
		if (sheetObjects[1].GetCellValue(Row, "und_deck_top_flg") == "Y") {
			document.getElementById("und_deck_top_flg").checked=true;
		} else {
			document.getElementById("und_deck_top_flg").checked=false;
		}
	var awk_cgo_seq=sheetObjects[1].GetCellValue(Row, "awk_cgo_seq")
	var findDetail=sheetObjects[3].FindText("awk_cgo_seq", awk_cgo_seq, 0, 2);
	if (sheetObjects[1].RowCount()> 0 && findDetail > 0) {
		document.getElementById("details_button").setAttribute("style", "font-weight: bold;color:blue!important");
	} else {
		document.getElementById("details_button").setAttribute("style", "color:##A0BAED!important");
	}
	if (sheetObjects[1].RowCount()> 0 && sheetObjects[1].GetCellValue(Row, "diff_rmk").length > 1) {
		document.getElementById("btn_Remark").setAttribute("style", "font-weight: bold;color:blue!important");
	} else {
		document.getElementById("btn_Remark").setAttribute("style", "color:##A0BAED!important");
	}
	if (crn_pst_sts_cd.GetSelectCode() == "E" || crn_pst_sts_cd.GetSelectCode() == "F") {
		document.getElementById("frm_xtd_ovr_qty").disabled="true";
	} else {
		document.getElementById("frm_xtd_ovr_qty").enabled="true";
	}
	if (sheetObjects[1].GetCellValue(Row, "cntr_tpsz_cd").indexOf("A") > -1) {
		crn_pst_sts_cd.disabled=false;
		document.getElementById("pst_lck_pin_flg").disabled=false;
	} else if (sheetObjects[1].GetCellValue(Row, "cntr_tpsz_cd").indexOf("F") > -1) {
		crn_pst_sts_cd.disabled=false;
		document.getElementById("pst_lck_pin_flg").disabled=true;
	} else {
		crn_pst_sts_cd.disabled=true;
		document.getElementById("pst_lck_pin_flg").disabled=true;
	}
	if (sheetObjects[1].GetCellValue(Row, "spcl_cgo_apro_cd") == "C" || sheetObjects[1].GetCellValue(Row, "spcl_cgo_apro_cd") == "") {
		document.getElementById("btn_RequestCancel").disabled = true;
		cancelFlg="Y";
	} else {
		document.getElementById("btn_RequestCancel").disabled = false;
		cancelFlg="N";
	}
}
/**
 * Handling fnCntrComboItem action event related Sheet column
 * 
 * @param sheetObj,
 *            Row, Col, Value
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
			//sheetObjects[1].CellComboItem(Row,"cntr_no", {ComboText:"|"+cntr_name, ComboCode:"|"+cntr_val} );
			//sheetObjects[1].CellComboItem(i,"cntr_no", {ComboText:"|"+sheetObjects[1].CellValue(i, ComboCode:"cntr_no")+"|"+cntr_name} );
//			sheetObjects[1].CellComboItem(i, "cntr_no", " |" + sheetObjects[1].GetCellValue(i, "cntr_no") + "|" + cntr_name, " |" + sheetObjects[1].GetCellValue(i, "cntr_no") + "|" + cntr_val);
			sheetObjects[1].CellComboItem(i, "cntr_no", {ComboText:" |" + sheetObjects[1].GetCellValue(i, "cntr_no") + "|" + cntr_name, ComboCode:" |" + sheetObjects[1].GetCellValue(i, "cntr_no") + "|" + cntr_val});
			sheetObjects[1].SetCellEditable(i, "cntr_tpsz_cd",0);
		} else {
			sheetObjects[1].CellComboItem(i,"cntr_no", {ComboText:"|"+cntr_name, ComboCode:"|"+cntr_val} );
			sheetObjects[1].SetCellEditable(i, "cntr_tpsz_cd",1);
		}
	} else {
		if (val != "") {
			//sheetObjects[1].CellComboItem(i,"cntr_no", {ComboText:"|"+sheetObjects[1].CellValue(i, ComboCode:"cntr_no")} );
//			sheetObjects[1].CellComboItem(i, "cntr_no", " |" + sheetObjects[1].GetCellValue(i, "cntr_no"), " |" + sheetObjects[1].GetCellValue(i, "cntr_no"));
			sheetObjects[1].CellComboItem(i, "cntr_no", {ComboText:" |" + sheetObjects[1].GetCellValue(i, "cntr_no"), ComboCode:" |" + sheetObjects[1].GetCellValue(i, "cntr_no")});
			sheetObjects[1].SetCellEditable(i, "cntr_tpsz_cd",0);
		} else {
//			sheetObjects[1].CellComboItem(i,"cntr_no", {ComboText:"", ComboCode:""} );
			sheetObjects[1].CellComboItem(i,"cntr_no", {ComboText:" |", ComboCode:"|"} );
			sheetObjects[1].SetCellEditable(i, "cntr_tpsz_cd",1);
		}
	}
}
// when shet click
function sheet2_OnClick(sheetObj, row, col, val) {
	if (row != sheet2SelectedRow) {　// avoid twice execution to show container dropdown correctly
	var col_name=sheetObj.ColSaveName(col);
	htmlSheetSync();
	switch (col_name) {
	case "cntr_no":
		fnCntrComboItem(sheetObj, row, col, val);
		break;
	}
	}
	sheet2SelectedRow = row;
}

//function sheet2_OnMouseDown(sheetObj, Button, Shift, xpos, ypos) {
//    var row = sheet2.MouseRow();
//    var col = sheet2.MouseCol();
//    var val = sheet2.GetCellValue(row, col);
//    var col_name=sheetObj.ColSaveName(col);
//    htmlSheetSync();
//    switch (col_name) {
//    case "cntr_no":
//          fnCntrComboItem(sheetObj, row, col, val);
//          break;
//    }
//}

// when sheet value changes
function sheet2_OnChange(sheetObj, row, col, val) {
	var col_name=sheetObj.ColSaveName(col);
	switch (col_name) {
	case "cntr_no":
		if (sheetObjects[1].GetCellValue(row, "cntr_no") != "") {
			var temp_cntr_no=document.getElementById("temp_cntr_no").value;
			var temp_find_row=sheetObjects[4].FindText("name", temp_cntr_no, 0, 2);
			// Releasing check with searching cntr_no in case cntr_no have a
			// value.
			if (temp_cntr_no != "") {
				sheetObjects[4].SetCellValue(temp_find_row, "DelChk","0");
			}
			var cntr_no=sheetObjects[1].GetCellValue(row, "cntr_no");
			var find_row=sheetObjects[4].FindText("name", cntr_no, 0, 2);
			if (sheetObjects[1].GetCellValue(row, "cntr_no") != "" && sheetObjects[1].GetCellValue(row, "cntr_tpsz_cd") != "" && sheetObjects[1].GetCellValue(row, "cntr_tpsz_cd") != sheetObjects[4].GetCellValue(find_row, "cntr_tpsz_cd")) {
				if (ComShowConfirm(ComGetMsg("BKG00570"))) {
					sheetObjects[1].SetCellValue(row, "cntr_tpsz_cd",sheetObjects[4].GetCellValue(find_row, "cntr_tpsz_cd"),0);
					document.getElementById("cntr_tpsz_cd").value=sheetObjects[4].GetCellValue(find_row, "cntr_tpsz_cd");
				} else {
					sheetObjects[1].SetCellValue(row, "cntr_no","",0);
					cntr_no="";
				}
			} else if (sheetObjects[1].GetCellValue(row, "cntr_tpsz_cd") == "") {
				sheetObjects[1].SetCellValue(row, "cntr_tpsz_cd",sheetObjects[4].GetCellValue(find_row, "cntr_tpsz_cd"),0);
				document.getElementById("cntr_tpsz_cd").value=sheetObjects[4].GetCellValue(find_row, "cntr_tpsz_cd");
			}
			sheetObjects[1].SetCellValue(row, "cntr_vol_qty",sheetObjects[4].GetCellValue(find_row, "cntr_vol_qty"),0);
			sheetObjects[1].SetCellValue(row, "rcv_term_cd",sheetObjects[4].GetCellValue(find_row, "rcv_term_cd"),0);
			sheetObjects[1].SetCellValue(row, "de_term_cd",sheetObjects[4].GetCellValue(find_row, "de_term_cd"),0);
			rcv_term_cd.SetSelectCode(sheetObjects[4].GetCellValue(find_row, "rcv_term_cd"));
			de_term_cd.SetSelectCode(sheetObjects[4].GetCellValue(find_row, "de_term_cd"));
			de_term_cd.Enable = false;
			rcv_term_cd.Enable = false;
			if (sheetObjects[1].GetCellValue(row, "cntr_tpsz_cd").indexOf("A") > -1) {
				crn_pst_sts_cd.disabled=false;
				document.getElementById("pst_lck_pin_flg").disabled=false;
			} else if (sheetObjects[1].GetCellValue(row, "cntr_tpsz_cd").indexOf("F") > -1) {
				//crn_pst_sts_cd.GetSelectCode()="E";
				crn_pst_sts_cd.SetSelectCode("E");
				document.getElementById("pst_lck_pin_flg").value="";
				sheetObjects[1].SetCellValue(row, "crn_pst_sts_cd","E",0);
				sheetObjects[1].SetCellValue(row, "pst_lck_pin_flg","",0);
				crn_pst_sts_cd.disabled=false;
				document.getElementById("pst_lck_pin_flg").disabled=true;
			} else {
				//crn_pst_sts_cd.GetSelectCode()="";
				crn_pst_sts_cd.SetSelectCode("");
				document.getElementById("pst_lck_pin_flg").value="";
				sheetObjects[1].SetCellValue(row, "crn_pst_sts_cd","",0);
				sheetObjects[1].SetCellValue(row, "pst_lck_pin_flg","",0);
				crn_pst_sts_cd.disabled=true;
				document.getElementById("pst_lck_pin_flg").disabled=true;
			}
			if (cntr_no != "") {
				sheetObjects[4].SetCellValue(find_row, "DelChk","1",0);
			}
			// document.getElementById("temp_cntr_no").value = cntr_no;
		} else {
			var temp_cntr_no=document.getElementById("temp_cntr_no").value;
			var temp_find_row=sheetObjects[4].FindText("name", temp_cntr_no, 0, 2);
			if (temp_cntr_no != "") {
				sheetObjects[4].SetCellValue(temp_find_row, "DelChk","0");
			}
			if (sheetObjects[2].GetCellValue(1, "de_term_cd") == "M") {
				de_term_cd.Enable = true;
			} else {
				de_term_cd.Enable = false;
			}
			if (sheetObjects[2].GetCellValue(1, "rcv_term_cd") == "M") {
				rcv_term_cd.Enable = true;
			} else {
				rcv_term_cd.Enable = false;
			}
			document.getElementById("temp_cntr_no").value="";
		}
		document.getElementById("frm_cntr_cgo_seq").value="";
		sheetObjects[1].SetCellValue(row, "awk_dcgo_seq","");
		sheetObjects[1].SetCellValue(row, "cntr_cgo_seq","");
		break;
	case "cntr_tpsz_cd":
		sheetObjects[1].SetCellValue(row, "cntr_tpsz_cd",(sheetObjects[1].GetCellValue(row, "cntr_tpsz_cd")).toUpperCase(),0);
		document.getElementById("cntr_tpsz_cd").value=sheetObjects[1].GetCellValue(row, "cntr_tpsz_cd");
		var find_row=sheetObjects[0].FindText("cntr_tpsz_cd", sheetObjects[1].GetCellValue(row, "cntr_tpsz_cd"), 0, 2);
		if (find_row > 0) {
			var cntrVolQty=Number(sheetObjects[0].GetCellValue(find_row, "awk_cgo_qty"));
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
		if (sheetObjects[1].GetCellValue(row, "cntr_tpsz_cd").indexOf("A") > -1) {
			crn_pst_sts_cd.disabled=false;
			document.getElementById("pst_lck_pin_flg").disabled=false;
		} else if (sheetObjects[1].GetCellValue(row, "cntr_tpsz_cd").indexOf("F") > -1) {
			//crn_pst_sts_cd.GetSelectCode()="E";
			crn_pst_sts_cd.SetSelectCode("E");
			document.getElementById("pst_lck_pin_flg").value="";
			sheetObjects[1].SetCellValue(row, "crn_pst_sts_cd","E",0);
			sheetObjects[1].SetCellValue(row, "pst_lck_pin_flg","",0);
			crn_pst_sts_cd.disabled=false;
			document.getElementById("pst_lck_pin_flg").disabled=true;
		} else {
			//crn_pst_sts_cd.GetSelectCode()="";
			crn_pst_sts_cd.SetSelectCode("");
			document.getElementById("pst_lck_pin_flg").value="";
			sheetObjects[1].SetCellValue(row, "crn_pst_sts_cd","",0);
			sheetObjects[1].SetCellValue(row, "pst_lck_pin_flg","",0);
			crn_pst_sts_cd.disabled=true;
			document.getElementById("pst_lck_pin_flg").disabled=true;
		}
		if (sheetObjects[1].GetCellValue(row, "cntr_tpsz_cd") == "D7") {
			if(sheetObjects[1].GetCellValue(row, "ttl_dim_len") == 0){
				document.getElementById("ttl_dim_len").value="1317.6";
			}else{	document.getElementById("ttl_dim_len").value=sheetObjects[1].GetCellValue(row, "ttl_dim_len");
			}
			if(sheetObjects[1].GetCellValue(row, "ttl_dim_wdt") == 0){
				document.getElementById("ttl_dim_wdt").value="243.8";
			}else{	document.getElementById("ttl_dim_wdt").value=sheetObjects[1].GetCellValue(row, "ttl_dim_wdt");
			}
			if(sheetObjects[1].GetCellValue(row, "ttl_dim_hgt") == 0){
				document.getElementById("ttl_dim_hgt").value="289.6";
			}else{	document.getElementById("ttl_dim_hgt").value=sheetObjects[1].GetCellValue(row, "ttl_dim_hgt");
			}
			if(sheetObjects[1].GetCellValue(row, "ovr_fwrd_len") == 0){
				document.getElementById("ovr_fwrd_len").value="0";
			}else{	document.getElementById("ovr_fwrd_len").value=sheetObjects[1].GetCellValue(row, "ovr_fwrd_len");
			}
			if(sheetObjects[1].GetCellValue(row, "ovr_bkwd_len") == 0){
				document.getElementById("ovr_bkwd_len").value="0";
			}else{	document.getElementById("ovr_bkwd_len").value=sheetObjects[1].GetCellValue(row, "ovr_bkwd_len");
			}	
			if(sheetObjects[1].GetCellValue(row, "ovr_lf_len") == 0){
				document.getElementById("ovr_lf_len").value="0";
			}else{	document.getElementById("ovr_lf_len").value=sheetObjects[1].GetCellValue(row, "ovr_lf_len");
			}
			if(sheetObjects[1].GetCellValue(row, "ovr_rt_len") == 0){
				document.getElementById("ovr_rt_len").value="0";
			}else{	document.getElementById("ovr_rt_len").value=sheetObjects[1].GetCellValue(row, "ovr_rt_len");
			}
			if(sheetObjects[1].GetCellValue(row, "ovr_hgt") == 0){
				document.getElementById("ovr_hgt").value="0";
			}else{	document.getElementById("ovr_hgt").value=sheetObjects[1].GetCellValue(row, "ovr_hgt");
			}
			if(sheetObjects[1].GetCellValue(row, "ovr_void_slt_qty") == 0){
				document.getElementById("ovr_void_slt_qty").value="0";
			}else{	document.getElementById("ovr_void_slt_qty").value=sheetObjects[1].GetCellValue(row, "ovr_void_slt_qty");
			}
			sheetObjects[1].SetCellValue(row, "ttl_dim_len",Math.round(parseFloat(document.getElementById("ttl_dim_len").value)) ,0);
			sheetObjects[1].SetCellValue(row, "ttl_dim_wdt",Math.round(parseFloat(document.getElementById("ttl_dim_wdt").value)) ,0);
			sheetObjects[1].SetCellValue(row, "ttl_dim_hgt",Math.round(parseFloat(document.getElementById("ttl_dim_hgt").value)) ,0);
			sheetObjects[1].SetCellValue(row, "ovr_fwrd_len",document.getElementById("ovr_fwrd_len").value,0);
			sheetObjects[1].SetCellValue(row, "ovr_bkwd_len",document.getElementById("ovr_bkwd_len").value,0);
			sheetObjects[1].SetCellValue(row, "ovr_lf_len",document.getElementById("ovr_lf_len").value,0);
			sheetObjects[1].SetCellValue(row, "ovr_rt_len",document.getElementById("ovr_rt_len").value,0);
			sheetObjects[1].SetCellValue(row, "ovr_hgt",document.getElementById("ovr_hgt").value,0);
			sheetObjects[1].SetCellValue(row, "ovr_void_slt_qty",document.getElementById("ovr_void_slt_qty").value,0);
		}
		overDimensionSettingLength();
		overDimensionSettingWidth();
		overDimensionSettingHeight();
		break;
	case "cntr_vol_qty":
		if (Number(sheetObjects[1].GetCellValue(row, "cntr_vol_qty")) > 1) {
			ComShowMessage(ComGetMsg("BKG08013"));
		}
		var find_row=sheetObjects[0].FindText("cntr_tpsz_cd", sheetObjects[1].GetCellValue(row, "cntr_tpsz_cd"), 0, 2);
		if (sheetObjects[1].GetCellValue(row, "cntr_tpsz_cd") != "" && find_row > 0) {
			var cntrVolQty=Number(sheetObjects[0].GetCellValue(find_row, "awk_cgo_qty"));
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
 * Handling validity verification process about screen form input value.
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		// if (!isNumber(formObj.iPage)) {
		// return false;
		// }
	}
	return true;
}
// Using inquiry function inquiry completed & occurred Event
function sheet2_OnSearchEnd(sheetObj, code, ErrMsg) {
	ComOpenWait(false);
	with (sheetObj) {
		SetColBackColor("RFQTY","#CCFFFD");
	}
}

//조회 함수를 이용하여 조회가 완료되고 발생하는 Event
function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		/* Image Storage 에 AK 항목에 해당 image 가 한건이라도 첨부 되어 있으면 버튼 색상 변경 추가 */
		if(sheetObjects[2].RowCount() > 0 ){
			if(sheetObjects[2].GetCellValue(1,"img_flg") == 'Y'){
//				document.getElementById('btn_attach').style.color = 'blue';
				ComGetObject("btn_attach").style.setProperty("color", BTN_BLUE, "important");
			}else{
//				document.getElementById('btn_attach').style.color = '';
				ComGetObject("btn_attach").style.setProperty("color", "", "");
			}
		}
	}
}

/**
 * Calling setInquiryDisableButton Event.<br>
 * Deactivating in case ComBtnDisable selected
 * 
 * @param
 */
function setInquiryDisableButton() {
//	ComBtnDisable("btn_attach");
	ComBtnDisable("btn_Save");
	ComBtnDisable("btn_Request");
}
