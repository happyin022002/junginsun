/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAQ_0112.js
*@FileTitle  : Regional Group Vs. Trade Group
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class ESM_SAQ_0112 : business script for ESM_SAQ_0112.
 */
var sheetObjects = new Array();
var sheetCnt = 0;
var pWindow = "";
var rtnVal = new Array();

// Event handler processing by button click event */
document.onclick = processButtonClick;

// Event handler processing by button name */
function processButtonClick() {
    var sheetObject = sheetObjects[0];
    var formObject = document.form;
    try {
        var srcName = ComGetEvent("name");
        if (ComGetBtnDisable(srcName)) return false;
        switch (srcName) {
            case "btn_new":
                //					if (!ComIsBtnEnable(btn_new)) return;        	    
                doActionIBSheet(sheetObject, formObject, IBCLEAR);
                break;
            case "btn_save":
                //					if (!ComIsBtnEnable(btn_save)) return;
                rtnVal[0] = "OK";
                doActionIBSheet(sheetObject, formObject, IBSAVE);
                break;
            case "btn_close":
                //					if (!ComIsBtnEnable(btn_close)) return;        	    
                //ComClosePopup();					
                ComPopUpReturnValue(rtnVal);
                break;
        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            ComShowCodeMessage("COM12111");
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
    sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
    pWindow = window.dialogArguments;
    if (!pWindow) var pWindow = parent;
    pWindow.isRemarkRefresh = false;
    for (i = 0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    //        ComBtnDisable("btn_new");
    //        ComBtnDisable("btn_save");
    //        ComBtnDisable("btn_close");
    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    //		ComBtnEnable("btn_new");
    //		ComBtnEnable("btn_save");
    //		ComBtnEnable("btn_close");					    	
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:      //sheet1 init
		    with(sheetObj){	        
				var HeadTitle="Mqta Step Cd|"
				+ "Bse Yr|"
				+ "Rep Mon|"
				+ "Trd Cd|"
				+ "Dir Cd|"
				+ "Mqta Ver No.|"
				+ "Rlane Cd|"
				+ "Sprt Grp Cd|"
				+ "Bsa GrpvCd|"
				+ "Rhq Cd|"
				+ "Bse Mon|"
				+ "Rgn Ofc Cd|"
				+ "Subj Ctnt|"
				+ "Cre Ofc Cd|"
				+ "Cmt Ctnt|"
				+ "Rmk Cre Gdt|"
				+ "SEQ Sts Cd|"
				+ "Pol Cd|"
				+ "Pod Cd|"    ;
				
				SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:1 } );
				
				var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"mqta_step_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"bse_yr",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"bse_qtr_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"trd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"dir_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"mqta_ver_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"rlane_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"sprt_grp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"bsa_grp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"rhq_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"bse_mon",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"rgn_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"subj_ctnt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"cre_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"cmt_ctnt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"rmk_cre_gdt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"saq_sts_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Status",    Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"ibflag",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"pol_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"pod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				
				InitColumns(cols);
				
				SetEditable(1);
				SetSheetHeight(200 );
		}
	      break;
	}    
}

// handling process after ending sheet1 retrieve
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH:
            ComOpenWait(true);
            document.getElementById("remark").innerHTML = "";
            if (formObj.mqta_step_cd.value == '01' ||
                formObj.mqta_step_cd.value == '02') {
                formObj.f_cmd.value = SEARCHLIST01;
            } else if (formObj.mqta_step_cd.value == '04' ||
                formObj.mqta_step_cd.value == '05') {
                formObj.f_cmd.value = SEARCHLIST02;
            } else {
                formObj.f_cmd.value = SEARCHLIST03;
            }
            sheetObj.ReDraw = false;
            sheetObj.RemoveAll();
            sheetObj.DoSearch("ESM_SAQ_0112GS.do", saqFormString(formObj), {
                Append: false
            });
            sheetObj.ReDraw = true;
            break;
        case IBSAVE:
            if (!validateCheck("SAVE")) return false;
            ComOpenWait(true);
            if (formObj.mqta_step_cd.value == '01' || formObj.mqta_step_cd.value == '02') {
                formObj.f_cmd.value = MODIFY01;
            } else if (formObj.mqta_step_cd.value == '04' || formObj.mqta_step_cd.value == '05') {
                formObj.f_cmd.value = MODIFY02;
            } else {
                formObj.f_cmd.value = MODIFY03;
            }
            var newRow = sheetObj.DataInsert();
            sheetObj.SetCellValue(newRow, "subj_ctnt", formObj.subject.value, 0);
            sheetObj.SetCellValue(newRow, "cmt_ctnt", formObj.contents.value, 0);
            sheetObj.SetCellValue(newRow, "mqta_step_cd", formObj.mqta_step_cd.value, 0);
            sheetObj.SetCellValue(newRow, "bse_yr", formObj.bse_yr.value, 0);
            sheetObj.SetCellValue(newRow, "bse_qtr_cd", formObj.bse_qtr_cd.value, 0);
            sheetObj.SetCellValue(newRow, "trd_cd", formObj.trd_cd.value, 0);
            sheetObj.SetCellValue(newRow, "dir_cd", formObj.dir_cd.value, 0);
            sheetObj.SetCellValue(newRow, "mqta_ver_no", formObj.mqta_ver_no.value, 0);
            sheetObj.SetCellValue(newRow, "rlane_cd", formObj.rlane_cd.value, 0);
            sheetObj.SetCellValue(newRow, "sprt_grp_cd", formObj.sprt_grp_cd.value, 0);
            sheetObj.SetCellValue(newRow, "bsa_grp_cd", formObj.bsa_grp_cd.value, 0);
            sheetObj.SetCellValue(newRow, "rhq_cd", formObj.rhq_cd.value, 0);
            sheetObj.SetCellValue(newRow, "bse_mon", formObj.bse_mon.value, 0);
            sheetObj.SetCellValue(newRow, "cre_ofc_cd", formObj.cre_ofc_cd.value, 0);
            sheetObj.SetCellValue(newRow, "rgn_ofc_cd", formObj.rgn_ofc_cd.value, 0);
            sheetObj.SetCellValue(newRow, "pol_cd", formObj.pol_cd.value, 0);
            sheetObj.SetCellValue(newRow, "pod_cd", formObj.pod_cd.value, 0);
            sheetObj.SetCellValue(newRow, "saq_sts_cd", formObj.saq_sts_cd.value, 0);
            var rtn = doSaveSheet(sheetObj, "ESM_SAQ_0112GS.do", "f_cmd=" + formObj.f_cmd.value);
            if (rtn == "CANCEL") {
                sheetObj.RowDelete(newRow, false);
            }
            break;
        case IBCLEAR:
            formObj.reset();
            break;
    }
}

function validateCheck(type) {
    var formObj = document.form;
    var subj = formObj.subject.value;
    var contents = formObj.contents.value;
    if (type == "SAVE") {
        if (subj.length == 0) {
            ComShowMessage(getMsg("SAQ90117", "subject"));
            return false;
        }
        if (contents.length == 0) {
            ComShowMessage(getMsg("SAQ90117", "content"));
            return false;
        }
        //} else if( type == "CLOSE"){
        //        if( subj.length != 0
        //            || contents.length != 0 ){
        //            if( ComShowConfirm(getMsg("SAQ90129")) != 1 ){
        //                return false;
        //            }
        //        }        
    }
    return true;
}

function sheet1_OnSearchEnd(sheetObj, errMsg) {
    //array data,Control Name ,Title1,Title2
    ComOpenWait(false);
    if (sheetObj.GetEtcData("status") != "OK" && sheetObj.GetEtcData("status") != undefined) {
        ComShowMessage(errMsg);
    } else {
        var cnt = sheetObj.RowCount();
        for (var i = 1; i <= cnt; i++) {
            gdt = sheetObj.GetCellValue(i, "rmk_cre_gdt");
            org = sheetObj.GetCellValue(i, "cre_ofc_cd");
            subject = sheetObj.GetCellValue(i, "subj_ctnt");
            content = sheetObj.GetCellValue(i, "cmt_ctnt");
            appendRemark(gdt, org, subject, content)
        }
    }
}

function sheet1_OnSaveEnd(sheetObj, errMsg) {
    ComOpenWait(false);
    if (sheetObj.GetEtcData("status") == "OK") {
        var formObj = document.form;
        //pWindow.isRemarkRefresh = true;
		//pWindow.remarkRefreshParam = "rlane_grp=" + formObj.rlane_cd.value + "-" + formObj.sprt_grp_cd.value + formObj.bsa_grp_cd.value + "&pol_cd=" + formObj.pol_cd.value + "&pod_cd=" + formObj.pod_cd.value + "&ctrt_rhq_cd=" + formObj.rhq_cd.value;
        
        rtnVal[1] = formObj.rlane_cd.value + "-" + formObj.sprt_grp_cd.value + formObj.bsa_grp_cd.value; //rlane_grp
        rtnVal[2] = formObj.rhq_cd.value;//ctrt_rhq_cd
        rtnVal[3] = formObj.pol_cd.value;//pol_cd
        rtnVal[4] = formObj.pod_cd.value;//pod_cd
        rtnVal[5] = formObj.rgn_ofc_cd.value;//sls_rgn_ofc_cd
    } else {
        var sRow = sheetObj.FindStatusRow("I");
        var arRow = sRow.split(";");
        if (arRow.length - 1 > 0) {
            sheetObj.RowDelete(arRow[0], false);
        }
    }
    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    formObj.subject.value = '';
    formObj.contents.value = '';
}

var num = 1;

function appendRemark(gdt, org, subject, content) {
    var html="	<table style='border-collapse: collapse;width:100%; border:1px solid #A3A4C7;' border='1'  >  \n"
				+"		<tr>  \n"
	 			+"			<td width='100' style='height:23;font-family: Arial; font-weight:800;  font-size: 10px;text-align:center; color: #000000;background-color:#C0EBA3; border:1px solid #A3A4C7;border:1px solid #A3A4C7;'>\n"
	 			+"				Remark #"+num+" \n"
	 			+"			</td>  \n"
	 			+"			<td width='250'  style='height:23; font-size: 10px;text-align:left; color: #636363;background-color:#FFFFFF;border:1px solid #A3A4C7;border:1px solid #A3A4C7;'> \n"
				+"				<B>Date : </B>"+gdt+"<br> \n"
				+"				<B>Org  : </B>"+org+"<br> \n"
				+"				<B>Subject : </B><br>"+subject+"<br> \n"
				+"				<B>Content : </B><br>"+content+"<br> \n"
				+"			</td>  \n"
		 		+"		</tr> 			\n"					
				+"		</table> ";
    var obj=document.getElementById("remark");		
    var div=document.createElement("DIV");		
    div.innerHTML=html;
    div.style.display="";
    obj.appendChild(div);
    num++;
}

function closeMe() {
    if (!validateCheck("CLOSE")) return false;
    ComClosePopup();
}