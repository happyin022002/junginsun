/**
 * Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 * @FileName   : EES_CTM_0451.js
 * @FileTitle  : Release/Re-delivery Order
 * @author     : CLT
 * @version    : 1.0
 * @since      : 2014/08/29
 */

// common global variables
var httpRequestXml = ""
var rdObjects = new Array();
var rdCnt = 0;
if (!opener) opener = window.dialogArguments;
if (!opener) opener = window.opener;
if (!opener) opener = parent;
var opnfrmObj = opener.document.form;
var opnSheetObj0 = opener.sheetObjects[0];
var opnSheetObj1 = opener.sheetObjects[1];

// Event handler processing by button click event */
document.onclick=processButtonClick;

// Event handler processing by button name */
function processButtonClick(){
    var frmObj = document.form;
    var rdObj = document.getElementById("rd");

    try {
        var srcName=ComGetEvent("name");
        switch(srcName) {
            case "btn_print":
                rdObj.PrintDialog();
                break;
            case "btn_close":
                ComClosePopup(); 
                break;
            case "btn_confirm":
                if (ComShowCodeConfirm("CTM30006")) {
                    opnSheetObj0.SetWaitImageVisible(0);
                    opnSheetObj1.SetWaitImageVisible(0);
                    ComOpenWait(true);
                    /* {issue_flag} I:Issue , R:Reissue , C:cancel */
                    opnfrmObj.issue_flag.value=frmObj.issue_flag.value;
                    /* {issue_type} F:FAX , E:EMAIL, P:PRINT, D:EDI */
                    if (frmObj.issue_type[0].checked) {    // PRINT
                        opnfrmObj.issue_type.value=frmObj.issue_type[0].value;
                        rdObj.CMPrint();
                    } else {
                        if (frmObj.issue_type[1].checked) {    // FAX
                            opnfrmObj.issue_type.value=frmObj.issue_type[1].value;
                            //opnSheetObj1.RenderSheet(0);
                            for (var i=1; i<opnSheetObj1.RowCount()+1; i++) {
                                opnSheetObj1.SetCellValue(i, "fax_no",opnfrmObj.receiver_fax.value);
                            }
                            //opnSheetObj1.RenderSheet(1);
                        } else if (frmObj.issue_type[2].checked) {    // E-MAIL
                            opnfrmObj.issue_type.value=frmObj.issue_type[2].value;
                            //opnSheetObj1.RenderSheet(0);
                            for (var i=1; i<opnSheetObj1.RowCount()+1; i++) {
                                opnSheetObj1.SetCellValue(i, "email",opnfrmObj.receiver_eml.value);
                            }
                            //opnSheetObj1.RenderSheet(1);
						} else if (frmObj.issue_type[3].checked) { // EDI
							opnfrmObj.issue_type.value = frmObj.issue_type[3].value;
                        }
                    }
                    var issueFlagText=frmObj.issue_flag[frmObj.issue_flag.selectedIndex].text;
                    opnfrmObj.tmpl_param.value="/rpaper [A4]  /rp [" + issueFlagText + "]  /rfn [" + RDServerIP + "/EES_CTM_0451_RD.do]";
                    // calling doActionIBSheet method (saving and sending Fax/Mail)
                    opener.doActionIBSheet(opnSheetObj1, opnfrmObj, MULTI02);
                    ComOpenWait(false);
                    opnSheetObj0.SetWaitImageVisible(1);
                    opnSheetObj1.SetWaitImageVisible(1);
                    if (opener.sheet2_errMsg == "") {
                        opnSheetObj1.RemoveAll();
                        var pageTitle="";
                        if (opnfrmObj.type.value == "RDV") {    // in case of Re-Delivery
                            pageTitle="Empty Container Redelivery Order";
                        } else {
                            pageTitle="Empty Container Release Order";
                        }
                        ComShowCodeMessage("CTM30010", pageTitle);
                        opener.doActionIBSheet(opnSheetObj0, opnfrmObj, IBSEARCH);
                        ComClosePopup(); 
                    }
                }
                break;
        } // end switch
    } catch(e) {
        if ( e == "[object Error]") {
            ComShowMessage(OBJECT_ERROR);
        } else {
            ComShowMessage(e.message);
        }
    }
}

function loadPage() {
	var rdObject = document.getElementById("rd");

    axon_event.addListener("change", "rdOpen", "issue_flag");
    if (opnfrmObj.issued.value == "N") {
        document.form.issue_flag[3]=new Option("", "I", true, true);
        ComEnableObject(document.form.issue_flag, false);
    }
    var header="";
    for (var j=0; j <= opnSheetObj0.LastCol(); j++) {
        header += (opnSheetObj0.ColSaveName(j) + "|");
    }
    var opnSheet0Xml=ComMakeSearchXml(opnSheetObj0, false, "Sel", header);
    opnSheetObj1.RemoveAll();
    opnSheetObj1.LoadSearchData(opnSheet0Xml,{Sync:1} );
    opnSheetObj1.ColumnSort("bkg_no|bl_no|wo_no|tp|shpr|pd_date|mode_cd|vndr_lgl_eng_nm|spcl_inst", "ASC", "", true);
    opnfrmObj.receiver_fax.value=opnSheetObj0.GetCellValue(opnSheetObj0.FindCheckedRow("Sel").split("|")[0], "fax_no");
    opnfrmObj.receiver_eml.value=opnSheetObj0.GetCellValue(opnSheetObj0.FindCheckedRow("Sel").split("|")[0], "email");
    opnfrmObj.f_cmd.value=PRINT;
    rdObject.AutoAdjust = false;
    rdObject.ViewShowMode(0);
    rdObject.SetBackgroundColor(128,128,128);
    rdObject.SetPageLineColor(128,128,128);
    var xml=opnSheetObj1.GetSearchData("EES_CTM_0451_PRV.do", opnSheetObj1.GetSaveString(true, true) + "&" + FormQueryString(opnfrmObj));
    if (ComGetEtcData(xml, "RD") == "undefined") {
        LoadSearchData(xml,{Sync:1} );
    } else {
        opnfrmObj.rd_content.value=ComGetEtcData(xml, "RD").trim();
        rdOpen();
    }
}

/**
 * loadPage() / calling in OnChange event
 */
function rdOpen() {
	var rdObject = document.getElementById("rd");

	rdObject.ApplyLicense("0.0.0.0");
	rdObject.SetRData(opnfrmObj.rd_content.value);
    var issueFlagText=document.form.issue_flag[document.form.issue_flag.selectedIndex].text;
    rdObject.FileOpen(RD_path + "rpt/report/EES_CTM_0451.mrd", "/rpaper [A4]  /rp [" + issueFlagText + "]");
}
