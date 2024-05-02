/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0112.js
*@FileTitle  : Invoice Preview 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/24
=========================================================*/
/****************************************************************************************
  Event Code: [Initializing]INIT=0; [Insert]ADD=1; [Retrieve]SEARCH=2; [List retrieve]SEARCHLIST=3;
			  [Modify]MODIFY=4; [Remove]REMOVE=5; [List remove]REMOVELIST=6 [Multi process]MULTI=7
			  [Constant]  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class ESD_TPB_0112 : business script for ESD_TPB_0112
 */
/* Global Variables */
var curTab = 1;
var beforetab = 0;
var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;
// RD
//var rdObjects = new Array();  //2016.07.05 HTML5 RD 주석처리
//var rdCnt = 0;                //2016.07.05 HTML5 RD 주석처리
var CNT_CD = "";

/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * registering IBCombo Object array
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setComboObject(combo_obj) {
    comboObjects[comboCnt++] = combo_obj;
}

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
    //RD
    rdOpen();
    //initRdConfig(rdObjects[0]); //2016.07.05 HTML5 RD 주석처리
    //rdOpen(rdObjects[0], document.form); //2016.07.05 HTML5 RD 주석처리
    
    //Sheet
    for (i = 0; i < sheetObjects.length; i++) {
        //Setting startup environment. Change the name of the function
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        //Setting final environment.
        ComEndConfigSheet(sheetObjects[i]);
    }
    
    for (p = 0; p < comboObjects.length; p++) {
        initCombo(comboObjects[p], p + 1);
    }
    
    try {
        document.form.s_n3pty_inv_if_tp_cd.onchange = s_n3pty_inv_if_tp_cd_OnChange;
        $("#s_n3pty_inv_if_tp_cd option[value='T']").remove();
    } catch (e) {}

    resizeSheet();
    
    doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	sheetObj.UseUtf8=true;
	switch(sheetNo) {
		case 1:	  //IBSheet1 init
			with (sheetObj) {
				var cnt=0;
				var HeadTitle="result1|result2";
				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"dummy",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
				
				InitColumns(cols);
				
				SetEditable(1);
				DataInsert();
				//				    SetSheetHeight(280);
			}
		break;
	}    
}

/**
 *  auto resize
 */
function resizeSheet() {
    for (i = 0; i < sheetObjects.length; i++) {
        ComResizeSheet(sheetObjects[i]);
    }
}

/**
 * Setting Combo
 */
function initCombo(comboObj, comboNo) {
    switch (comboNo) {
        case 1:
            with(comboObj) {
                SetEnable(0);
                SetTitle("E-Mail Address|Available");
                SetColWidth(0, "200");
                SetColWidth(1, "100");
                SetItemHeight(7);
                SetDropHeight(150);
                DisabledBackColor = "#EEEEEE";
                SetColAlign(0, "left");
                SetColAlign(1, "center");
            }
            break;
    }
}

/* Event handler defined process to button click event */
document.onclick = processButtonClick;

function processButtonClick() {
    var sheetObject = sheetObjects[curTab - 1];
    //var rdObject = rdObjects[0]; //2016.07.05 HTML5 RD 주석처리
    var formObject = document.form;
    try {
        var srcName = ComGetEvent("name");
        switch (srcName) {
            //					case "btn_printN" :
            //						doActionIBSheet(sheetObject,formObject,MODIFY);
            //						break;
            //					case "btn_printY" :
            //						ComShowCodeMessage("TPB90010","Issue ","","");
            //						return;
            //						break;
            case "btn_issue":    
                setIndiaEmailAddress();
                doActionIBSheet(sheetObject, formObject, MODIFY);
                break;

            case "btn_print_only":
                viewer.print({isServerSide:true});
                //rdObject.PrintDialog(); //2016.07.05 HTML5 RD 주석처리
                break;

            case "btn_erpInterface":
                if (ComShowConfirm(ComGetMsg("TPB90008", "", "", ""))) {
                    doActionIBSheet(sheetObject, formObject, ADD);
                }
                break;

            case "btn_first":
                First_OnClick();
                break;

            case "btn_back":
                Prev_OnClick();
                break;

            case "btn_next":
                Next_OnClick();
                break;

            case "btn_last":
                Last_OnClick();
                break;

            case "btn_zoomIn":
                ZoomIn_OnClick();
                break;

            case "btn_zoomOut":
                ZoomOut_OnClick();
                break;

            case "btn_close":
                ComClosePopup();
                break;
        } // end switch
    } catch (e) {
        if (e = "[object Error]") {
            ComShowCodeMessage('COM12111');
        } else {
            ComShowMessage(e.message);
        }
    }
}

/* Processing Sheet */
function doActionIBSheet(sheetObj, formObj, sAction) {    
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case MODIFY: //Save
            //				if(document.all.btn_print.disabled){
            //					ComShowCodeMessage("TPB90010","Issue ","","");
            //					return;
            //				}
            
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            
            if (!ComShowConfirm(ComGetMsg("COM12147", "Issue", "", ""))) {
                return;
            }
            
            // document.all.btn_print.disabled = true;
            formObj.f_cmd.value = MODIFY;
            
            var saveXml = sheetObj.GetSaveData("ESD_TPB_0112GS.do", tpbFrmQryStr(formObj));
            sheetObj.LoadSaveData(saveXml);
            //				sheetObj.DoSave("ESD_TPB_0112GS.do", tpbFrmQryStr(formObj), -1, false);
            //				document.all.btn_print.style.display = "none";
            break;
            
        case ADD: //ERP
            formObj.f_cmd.value = ADD;
            div_processing_show(); // show processing image
            sheetObj.DoSave("ESD_TPB_0112GS.do", tpbFrmQryStr(formObj), -1, false);
            div_processing_hide(); // hide processing image
            break;
            
        case SEARCH01: //Office Cd 에 해당하는 Contry Code를 조회한다.        
            formObj.f_cmd.value = SEARCH01;
            var searchXml = sheetObj.GetSearchData("ESD_TPB_0112GS.do", tpbFrmQryStr(formObj));                   
    		CNT_CD = ComGetEtcData(searchXml, "CNT_CD");
            break;
    }
}

/**
 * Defined by DataSheetObject.prototype.event_OnSaveEnd
 */
function sheet1_OnSaveEnd(sheetObj, errMsg) {
    ComEtcDataToForm(document.form, sheetObj);
    if (errMsg == null || errMsg == '') {
        var s_clt_agn_flg = sheetObj.GetEtcData("s_clt_agn_flg");
        var s_n3pty_inv_sts_cd = sheetObj.GetEtcData("s_n3pty_inv_sts_cd");
        var s_issue_yn = sheetObj.GetEtcData("s_issue_yn");
        var s_erpif_yn = sheetObj.GetEtcData("s_erpif_yn");

        // deactivating button in case of ERP I/F
        if (s_erpif_yn != 'Y') {
            //				ComShowCodeMessage('COM12149','ERP Interface','','');
            //document.getElementById('btn_erpInterface_t').style.display = 'none';
            //	  			document.all.btn_erpif_left.style.display="none";
            if (document.all.btn_erpif != null || document.all.btn_erpif != undefined) document.all.btn_erpif.style.display = "none";
            //	  		    document.all.btn_erpif_right.style.display="none";
        }
        // deactivating button in case of ISSUE
        if (s_issue_yn != 'Y') {
            //document.getElementById('btn_issue_t').style.display = 'none';
            //	  			document.all.btn_issue_left.style.display="none";
            document.all.btn_issue.style.display = "none";
            //	  		    document.all.btn_issue_right.style.display="none";
        }
        if (document.all.f_cmd.value == ADD) {
            //document.getElementById('btn_erpInterface_t').style.display = 'none';
            //	  			document.all.btn_erpif_left.style.display="none";
            document.all.btn_erpif.style.display = "none";
            //	  		    document.all.btn_erpif_right.style.display="none";
            ComShowCodeMessage('COM12149', 'AR Interface', '', '');
        }
        // deactivating button in case of ISSUE
        else if (document.all.f_cmd.value == MODIFY) {
            //document.getElementById('btn_issue_t').style.display = 'none';
            //	  			document.all.btn_issue_left.style.display="none";
            document.all.btn_issue.style.display = "none";
            //	  		    document.all.btn_issue_right.style.display="none";
            ComShowCodeMessage('COM12149', 'Issue Type', '', '');
            // hard copy 
            if (document.form.s_n3pty_inv_if_tp_cd.value == 'H') {
                rdObjects[0].PrintDialog();
            }
        }
    }
}

/**
 * Checking validation of input value
 */
function validateForm(sheetObj, formObj, sAction) {
    with(formObj) {
        if (!ComChkValid(formObj)) return false;
        /// contact info check
        var n3pty_inv_if_tp_cd = formObj.s_n3pty_inv_if_tp_cd.value;
        var contact_info = formObj.s_contact_info.value;
        if (ComTrim(contact_info).length == 0) {
            if (n3pty_inv_if_tp_cd == "E") {
            	//2017.01.03 India도 email 주소를 ftp txt 파일로 보내기 때문에 체크 로직 원복함.
                //if(CNT_CD != "IN"){ // Office Code의 Country Code 가 India 인 경우 FTP 전송, 이메일 체크 하지 않음
					ComShowCodeMessage("TPB90028");
                	return false;	
				//}         
            } else if (n3pty_inv_if_tp_cd == "F") {
                ComShowCodeMessage("TPB90027");
                return false;
            }
        }
        formObj.s_n3pty_inv_if_tp_nm.value = formObj.s_n3pty_inv_if_tp_cd.options[formObj.s_n3pty_inv_if_tp_cd.selectedIndex].text;
    }
    return true;
}

/**
 * s_n3pty_inv_if_tp_cd onchange event 
 */
function s_n3pty_inv_if_tp_cd_OnChange() {
    var val = document.form.s_n3pty_inv_if_tp_cd.value;
    // ComShowMessage(val);
    if (val == 'E') {
    	if(CNT_CD == "IN"){    		
    		document.getElementById("contact_info_combo").style.display = "none";
    		document.getElementById("contact_info_input").style.display = "inline";
    	} else {
    		getEmailContactPoint();
        	comboObjects[0].SetEnable(1);
        	document.getElementById("contact_info_combo").style.display = "inline";
    		document.getElementById("contact_info_input").style.display = "none";
    	}
    	   
    } else if (val == 'F') {
       	document.getElementById("contact_info_combo").style.display = "inline";
    	document.getElementById("contact_info_input").style.display = "none";
        getFaxContactPoint();
        comboObjects[0].SetEnable(1);
        
    } else {
    	document.getElementById("contact_info_combo").style.display = "inline";
    	document.getElementById("contact_info_input").style.display = "none";
        document.form.s_contact_info.value = "";
        //comboObjects[0].SetEnable(0);
        //comboObjects[0].RemoveAll();
    }
}

/*
 * Processing combo in case of Email selecting 
 */
function getEmailContactPoint() {
    var comboObj = comboObjects[0];
    comboObj.RemoveAll();
    comboObj.SetTitle("E-Mail Address|Avaiable");
    comboObj.SetColWidth(0, 200);
    comboObj.SetColWidth(1, 94);
    var idx = 0;
    comboObj.InsertItem(idx++, "-- Select --|", "0");
    for (var i = 0; i < emailRnArr.length; i++) { // emailRnArr  emailCntcInfoArr  emailValidYnArr  
        comboObj.InsertItem(idx++, emailCntcInfoArr[i] + "|" + emailValidYnArr[i], emailCntcInfoArr[i]);
    }
    comboObj.SetSelectCode("0");
}

/*
 * Processing combo in case of Email selecting Fax selecting
 */
function getFaxContactPoint() {
    var comboObj = comboObjects[0];
    comboObj.RemoveAll();
    comboObj.SetTitle("Fax No.|Avaiable");
    comboObj.SetColWidth(0, 200);
    comboObj.SetColWidth(1, 94);
    var idx = 0;
    comboObj.InsertItem(idx++, "-- Select --|", "0");
    for (var i = 0; i < faxnoRnArr.length; i++) { // emailRnArr  emailCntcInfoArr  emailValidYnArr  
        comboObj.InsertItem(idx++, faxnoCntcInfoArr[i] + "|" + faxnoValidYnArr[i], faxnoRnArr[i]);
    }
    comboObj.SetSelectCode("0");
}

/*
 * combo1 OnChange event
 */
//Find or create function combo_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode)
function combo1_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
    // ComShowMessage(Text + " / " + Index_Code );
    document.form.s_contact_info.value = "";
    if (newCode != "0") {
        if (comboObj.GetText(newCode, 1) == "Yes") {
            // document.form.s_contact_info.value = Text; 
            document.form.s_contact_info.value = comboObj.GetText(newCode, 0);
        } else {
            var val = document.form.s_n3pty_inv_if_tp_cd.value;
            if (val == "E") {
                ComShowCodeMessage("TPB90028");
            } else if (val == "F") {
                ComShowCodeMessage("TPB90027");
            }
        }
    }
}

// show processing image 
function div_processing_show() {
    document.all.div_processing.style.display = '';
    // setTimeout("div_processing_hide();", 1000);
}

// hide processing image 
function div_processing_hide() {
    document.all.div_processing.style.display = 'none';
}

function rdOpen() {
    var formObject = document.form;
    var s_bil_loc = formObject.s_bil_loc.value;
    var s_his_seq = formObject.s_his_seq.value;
    var s_is_au = formObject.s_is_au.value;
    if (s_bil_loc == '') s_bil_loc = "L";
    if (s_his_seq == '') s_his_seq = formObject.s_n3pty_inv_his_seq.value;

    var rdParam = "/rp [" + formObject.s_n3pty_inv_no.value + "] " + //$1
        "[" + formObject.s_dao_n3pty_bil_tp_cd.value + "] " + //$2
        "[" + s_bil_loc + "] " + //$3
        "[" + s_his_seq + "] " + //$4
        "[" + s_is_au + "]";
    viewer.openFile(RD_path + "apps/opus/esd/tpb/processmanage/invoicemanage/report/REP_ESD_TPB_0112.mrd", RDServer + rdParam, {timeout:1800});
}

//2016.07.05 HTML5 RD 주석처리
/*
function initRdConfig(rdObject) {
    var Rdviewer = rdObject;
    Rdviewer.AutoAdjust = false;
    // Rdviewer.HideToolBar(); // show tool bar
    Rdviewer.ZoomRatio = 140;
    Rdviewer.SetSaveDialogEx("", "", "pdf", "pdf");
    Rdviewer.DisableToolbar(13);
    Rdviewer.DisableToolbar(14);
    Rdviewer.DisableToolbar(16);
    Rdviewer.DisableToolbar(17);

    Rdviewer.HideStatusBar();
    //		Rdviewer.ViewShowMode(2);

    Rdviewer.SetBackgroundColor(255, 255, 255);
    Rdviewer.SetPageLineColor(255, 255, 255);
    Rdviewer.ApplyLicense("0.0.0.0");
}

function rdOpen(rdObject, formObject) {
    var Rdviewer = rdObject;
    var s_bil_loc = formObject.s_bil_loc.value;
    var s_his_seq = formObject.s_his_seq.value;
    var s_is_au = formObject.s_is_au.value;
    if (s_bil_loc == '') s_bil_loc = "L";
    if (s_his_seq == '') s_his_seq = formObject.s_n3pty_inv_his_seq.value;

    var rdParam = "/rp [" + formObject.s_n3pty_inv_no.value + "] " + //$1
        "[" + formObject.s_dao_n3pty_bil_tp_cd.value + "] " + //$2
        "[" + s_bil_loc + "] " + //$3
        "[" + s_his_seq + "] " + //$4
        "[" + s_is_au + "]";
    //						  "/rfonttype60";   		
    //alert("rdParam====>"+rdParam);
    //var rdParam = "/rp [PUS091TR001] [CD] [L] [1] [Y]"
    //prompt('', rdParam);
    //Rdviewer.AutoAdjust = false;
    //Rdviewer.ZoomRatio = 130;
    //if(s_his_seq == ""){
    //	Rdviewer.FileOpen( RD_path + "apps/opus/esd/tpb/processmanage/invoicemanage/report/REP_ESD_TPB_0112Form.mrd", RDServer + rdParam);
    //}else{
    Rdviewer.FileOpen(RD_path + "apps/opus/esd/tpb/processmanage/invoicemanage/report/REP_ESD_TPB_0112.mrd", RDServer + rdParam);
    //Rdviewer.FileOpen( "http://127.0.0.1:9001/opuscntr/apps/opus/esd/tpb/processmanage/invoicemanage/report/REP_ESD_TPB_0112.mrd", RDServer + rdParam);
    //Rdviewer.FileOpen( "http://localhost:9001/opuscntr/" + "apps/opus/esd/tpb/processmanage/invoicemanage/report/REP_ESD_TPB_0112.mrd", RDServer + rdParam);
    //}
}
*/
//---------- RD Control button--------------------------------
function Save_OnClick() {
    ComOpenPopup("rdSaveFile.do", 250, 150,"rdSaveFileCallBack", "1,0", false);
    //rdObjects[0].SaveAsDialog(); //2016.07.05 HTML5 RD 주석처리
}

function Print_OnClick() {
    viewer.print({isServerSide:true});
    //rdObjects[0].PrintDialog(); //2016.07.05 HTML5 RD 주석처리
}

function First_OnClick() {
    viewer.moveFirstPage();
    //rdObjects[0].FirstPage(); //2016.07.05 HTML5 RD 주석처리
}

function Prev_OnClick() {
    viewer.prevPage();
    //rdObjects[0].PrevPage(); //2016.07.05 HTML5 RD 주석처리
}

function Next_OnClick() {
    viewer.nextpage();
    //var p = rdObjects[0].NextPage(); //2016.07.05 HTML5 RD 주석처리
}

function Last_OnClick() {
    viewer.moveLastPage();
    //rdObjects[0].LastPage(); //2016.07.05 HTML5 RD 주석처리
}

function ZoomIn_OnClick() {
    viewer.zoomIn();
    //rdObjects[0].ZoomIn(); //2016.07.05 HTML5 RD 주석처리
}

function ZoomOut_OnClick() {
    viewer.zoomOut();
    //rdObjects[0].ZoomOut(); //2016.07.05 HTML5 RD 주석처리
}

function Close_OnClick() {
    ComClosePopup();
}

//2017.01.03 India FTP전송시 Email 도 txt 파일로 전송하기 위한 셋팅값.
function setIndiaEmailAddress(){
    if(CNT_CD == "IN"){ 
        ComSetObjValue(document.form.s_contact_info, "");
        var tmpIndiaEmail = ComGetObjValue(document.form.contact_info_email);
        ComSetObjValue(document.form.s_contact_info, tmpIndiaEmail);
    }
}
//---------- RD Control button--------------------------------
/* Finishing work */