/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0015.js
*@FileTitle  : Vessel Arrival Transmit (A6)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/09
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
// Event handler processing by button click event  */
document.onclick=processButtonClick;
/** 
 * Event handler processing by button name */
function processButtonClick() {
    /***** using extra sheet valuable if there are more 2 sheets *****/
    var sheetObject=sheetObjects[0];
    /** **************************************************** */
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        switch (srcName) {
        case "btn_retrieve":
            doActionIBSheet(sheetObjects[0], document.form, SEARCH);
            break;
        case "btn_save":
            doActionIBSheet(sheetObject, formObject, MULTI);
            break;
        case "btn_transmit":
            doActionIBSheet(sheetObject, formObject, ADD);
            break;
        case "btn_arr_transmit":
			doActionIBSheet(sheetObject, formObject, MULTI01);
			break;
        case "btn_delete":
            doActionIBSheet(sheetObject, formObject, REMOVE);
            break;
		case "btn_terminal":
			doActionIBSheet(sheetObject, formObject, MULTI02);
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
    doActionIBSheet(sheetObjects[0], document.form, INIT);
    document.form.vvd_cd.focus();
    // event 
    //axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
    //axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
    axon_event.addListener('keydown', 'ComKeyEnter', 'form');
}

/**
  * setting sheet initial values and header
  * param : sheetObj, sheetNo
  * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
    var cnt=0;
    var sheetID=sheetObj.id;
    switch (sheetID) {
    case "sheet1": //sheet1 init
        with(sheetObj){
            var HeadTitle1="|vsl_cd|skd_voy_no|skd_dir_cd|VPS_PORT_CD|Carrier Code|Arrival Date|Actual Arrival Date|CRN|Captain Name|Total WGT|TEU Full|FEU Full|OTH Full|TEU Empty|FEU Empty|OTH Empty|crr_cd_val|cnd_vsl_cd|CREW|del_flag";
            var headCount=ComCountHeadTitle(HeadTitle1);
            
            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
            
            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            InitHeaders(headers, info);
            
            var cols = [{Type:"Status",    Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                        {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vps_port_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"crr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vps_eta_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"act_arr_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"cvy_ref_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"cap_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Float",     Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"cgo_wgt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Float",     Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"teu_ful",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Float",     Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"feu_ful",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Float",     Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"oth_ful",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Float",     Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"teu_mty",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Float",     Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"feu_mty",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Float",     Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"oth_mty",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"attr_ctnt2",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"cnd_vsl_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"crw_knt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"del_flag",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                               
            InitColumns(cols);
            
            SetEditable(1);
            SetSheetHeight(100);
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
    switch (sAction) {
    case SEARCH: //Retrieve
        if (validateForm(sheetObj, formObj, sAction)) {
            ComOpenWait(true);
            formObj.f_cmd.value=SEARCH;
            sheetObj.DoSearch("ESM_BKG_0015GS.do", FormQueryString(formObj) );
        }
        break;
    case MULTI: //Save
        if (validateForm(sheetObj, formObj, sAction)) {
        	
        	 if(!ComShowCodeConfirm("BKG00350")) {
             	return false;
             }
        	
            ComOpenWait(true);
            formObj.f_cmd.value=MULTI;
            IBS_CopyFormToRow(formObj, sheetObj, 1, "frm_");
            if (sheetObj.GetRowStatus(1) == "U" && sheetObj.GetCellValue(1, "cnd_vsl_cd") == "") {
                sheetObj.SetRowStatus(1,"I");
            }
            sheetObj.DoSave("ESM_BKG_0015GS.do", FormQueryString(formObj), -1, false);
            ComOpenWait(false);
        }
        break;
    case ADD:
        if (validateForm(sheetObj, formObj, sAction)) {
            if (ComShowCodeConfirm("BKG01023", "A6", "Canada Customs")) {
                ComOpenWait(true);
                IBS_CopyFormToRow(formObj, sheetObj, 1, "frm_");
                formObj.f_cmd.value=ADD;
                sheetObj.SetRowStatus(1,"U");
                // Delete flag setting
                sheetObj.SetCellValue(1, "del_flag","",0);
                sheetObj.DoSave("ESM_BKG_0015GS.do", FormQueryString(formObj), -1, false);
                ComOpenWait(false);
            }
        }
        break;
    case MULTI01:
		// date + " " + time (요렇게 해야함)
    	formObj.frm_act_arr_dt.value = formObj.frm_act_arr_da.value + " " +formObj.frm_act_arr_tm.value;
		if (!validateForm(sheetObj, formObj, sAction)) return false;

		if (ComShowCodeConfirm("BKG01023", "ATA", "Canada Customs")) {
			ComOpenWait(true);
			IBS_CopyFormToRow(formObj, sheetObj, 1, "frm_");
			formObj.f_cmd.value = MULTI01;
			sheetObj.SetRowStatus(1,"U");
			// 삭제 flag 세팅
			sheetObj.SetCellValue(1, "del_flag","",0);
			sheetObj.DoSave("ESM_BKG_0015GS.do", FormQueryString(formObj), -1, false);
			ComOpenWait(false);
		}
		break;
    case REMOVE:
        if (validateForm(sheetObj, formObj, sAction)) {
            if (ComShowCodeConfirm("COM12165", "Vessel Arrival Manifest")) {
                ComOpenWait(true);
                IBS_CopyFormToRow(formObj, sheetObj, 1, "frm_");
                formObj.f_cmd.value=ADD;
                sheetObj.SetRowStatus(1,"U");
                // Delete flag setting
                sheetObj.SetCellValue(1, "del_flag","D",0);
                sheetObj.DoSave("ESM_BKG_0015GS.do", FormQueryString(formObj), -1, false);
                ComOpenWait(false);
            }
        }
        break;
        

	case MULTI02:
		
        if (validateForm(sheetObj, formObj, sAction)) {
            if (ComShowCodeConfirm("BKG01023", "A6", "Terminal")) {
                ComOpenWait(true);
                IBS_CopyFormToRow(formObj, sheetObj, 1, "frm_");
                formObj.f_cmd.value=MULTI02;
                sheetObj.SetRowStatus(1,"U");
                // Delete flag setting
                sheetObj.SetCellValue(1, "del_flag","",0);
                sheetObj.DoSave("ESM_BKG_0015GS.do", FormQueryString(formObj), -1, false);
                ComOpenWait(false);
            }
        }
		break;
    }
}

/**
 * handling process for input validation
 * @param sheetObj Sheet
 * @param formObj form Object
 * @param sAction 
 */
function validateForm(sheetObj, formObj, sAction) {
    switch (sAction) {
    case SEARCH: //Retrieve
        // checking format
        if (!ComChkValid(formObj))
            return false;
        if (sheetObj.RowCount()> 0)
            IBS_CopyFormToRow(formObj, sheetObj, 1, "frm_");
        // searching after saving in case modified data exists
        if (sheetObj.IsDataModified()) {
            if (ComShowCodeConfirm("BKG00386")) {
                doActionIBSheet(sheetObj, formObj, MULTI);
                return false;
            }
        }
        break;
    case MULTI01:
    	if (sheetObj.RowCount()< 1) {
            ComShowCodeMessage('BKG00395');
            return false;
        }
    	break;
    case MULTI: //modify
        // checking format
    	if (sheetObj.RowCount()< 1) {
            ComShowCodeMessage('BKG00395');
            return false;
        } else {
	        if (!ComChkValid(formObj))
	            return false;
	        if (sheetObj.RowCount()< 1) {
	            ComShowCodeMessage('BKG00395');
	            return false;
	        }
            formObj.frm_act_arr_dt.value = formObj.frm_act_arr_da.value + " " +formObj.frm_act_arr_tm.value;
	        IBS_CopyFormToRow(formObj, sheetObj, 1, "frm_");
	        if (!sheetObj.IsDataModified())
	        {
	            ComShowCodeMessage("BKG95005");
	            return false;
	        }
        }
        break;
    case MULTI02:
    case ADD:
    case REMOVE:
        if (sheetObj.RowCount()< 1) {
            ComShowCodeMessage('BKG00395');
            return false;
        } else {
            if (ComIsNull(formObj.frm_cvy_ref_no)) {
                ComShowCodeMessage('BKG00717', formObj.frm_cvy_ref_no.getAttribute("caption"));
                return false;
            }
            if (ComIsNull(formObj.frm_cap_nm)) {
                ComShowCodeMessage('BKG00717', formObj.frm_cap_nm.getAttribute("caption"));
                return false;
            }
        }
        break;
    }
    return true;
}

/**
 * moving next item after input search condition 
 */
function obj_KeyUp() {
    var formObject=document.form;
    var srcName=ComGetEvent("name");
    var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
    var srcValue=window.event.srcElement.getAttribute("value");
    if (srcName == "vvd_cd" && ComChkLen(srcValue, srcMaxLength) == "2") {
        ComSetNextFocus();
    }
}

function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    ComOpenWait(false);
    var formObj= document.form;
    if (sheetObj.RowCount()> 0) {
        IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_");
        formObj.frm_cgo_wgt.value=ComAddComma2(formObj.frm_cgo_wgt, "#,###");
        formObj.frm_teu_ful.value=ComAddComma2(formObj.frm_teu_ful, "#,###");
        formObj.frm_feu_ful.value=ComAddComma2(formObj.frm_feu_ful, "#,###");
        formObj.frm_oth_ful.value=ComAddComma2(formObj.frm_oth_ful, "#,###");
        formObj.frm_teu_mty.value=ComAddComma2(formObj.frm_teu_mty, "#,###");
        formObj.frm_feu_mty.value=ComAddComma2(formObj.frm_feu_mty, "#,###");
        formObj.frm_oth_mty.value=ComAddComma2(formObj.frm_oth_mty, "#,###");
        
        if (formObj.frm_act_arr_dt.value != "")
    	{
            formObj.frm_act_arr_da.value = formObj.frm_act_arr_dt.value.substr(0, 10);
            formObj.frm_act_arr_tm.value = formObj.frm_act_arr_dt.value.substr(11);
    	}
    } else {
        //Setting all field to "", if there are no result data. Except search condition 
        for ( var i=0; i < formObj.getElementsByTagName("input").length; i++) {
            if (formObj.getElementsByTagName("input")[i].name != "vvd_cd"
                    && formObj.getElementsByTagName("input")[i].name != "pod_cd") {
                formObj.getElementsByTagName("input")[i].value="";
            }
        }
    }
}

function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    ComOpenWait(false);
}
