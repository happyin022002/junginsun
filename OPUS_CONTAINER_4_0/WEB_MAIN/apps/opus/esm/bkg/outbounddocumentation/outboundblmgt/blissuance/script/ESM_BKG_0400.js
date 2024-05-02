/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0400.js
*@FileTitle  : O.B/L Surrender Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/28
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/* developer job    */
// common global variables
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var prefix1="sheet1_";
var save_success=false;
var bf_frm_sheet1_diff_rmk="";
var bf_frm_sheet1_obl_rdem_ofc_cd="";
var bf_frm_sheet1_obl_rdem_usr_id="";
var bf_frm_sheet1_obl_rdem_dt="";
var bf_frm_sheet1_obl_rdem_knt="";
var dirty_flag="N";
var search_flag="N";
window.onunload=function(){ if(save_success) try{ opener.bkg_search();} catch (ex) {} }

// Event handler processing by button click event */
document.onclick=processButtonClick;

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
    initControl();  

    for (i=0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }

    if('Y' == ComGetObjValue(document.form.inquery_only)){
        ComBtnDisable("btn_Save");
    }

    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/**
 * Dynamically load HTML Control event in page. <br>
 * Initialize IBSheet Object by calling this function from {@link #loadPage} function.
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects list in turn
 **/
function initControl() {
    DATE_SEPARATOR="-";
    var formObj=document.form;
    axon_event.addListenerFormat('beforeactivate', 'obj_activate', formObj); // -포커스들어갈때
    axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', formObj); // - 포커스나갈때
    //axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObj); //- 키보드 입력할때
    //axon_event.addListener('keydown', 'check_Enter', 'form');
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
    var cnt=0;
    var sheetID=sheetObj.id;
    try {
        switch (sheetNo) {
        case 1: //t1sheet1 init
            with(sheetObj){
                var HeadTitle1="|||||||||||||";
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);
                var cols = [{Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"ibflag" },
                            {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"bkg_no" },
                            {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"bl_no" },
                            {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"obl_rdem_ofc_cd" },
                            {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"obl_rdem_dt" },
                            {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"obl_rdem_knt" },
                            {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"obl_rdem_usr_id" },
                            {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"diff_rmk" },
                            {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"obl_srnd_flg" },
                            {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"obl_iss_knt" },
                            {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"obl_rlse_flg" },
                            {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"bl_tp_cd" },
                            {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"cust_to_ord_flg" },
                            {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"del_cd" },
                            {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"bkg_sts_cd" },
                            {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"obl_iss_dt" },
                            {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"obl_iss_ofc_cd" },
                            {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"do_isuue" },
                            {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"cnt_cd" } ];
                InitColumns(cols);
                SetEditable(1);
//                SetVisible(false);
                ComResizeSheet(sheetObj);
            }

            break;
        }
    } catch (ex) {
        bkg_error_alert('initSheet', ex);
    }
}

//Event handler processing by button name */
function processButtonClick() {
    var formObj=document.form;

    span_bkg_no.style.display="none";
    span_bl_no.style.display="none";

    try {
        var srcName=ComGetEvent("name");
        if(ComGetBtnDisable(srcName)) return false;
        switch (srcName) {
        /** * POP UP BL ISSUE (S) ** */
        case "pop_bkg_no":
            fnSetSelectNumberBox('span_bkg_no', 'text_bkg_no');
            break;
        case "pop_bl_no":
            fnSetSelectNumberBox('span_bl_no', 'text_bl_no');
            break;
        /** * BUTTON BL ISSUE (r) ** */         
        case "btn_retrieve":
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
            break;
        case "btn_new":
            ComResetAll();
            search_flag="Y";
            break;
        case "btn_save":
            if (ComGetObjValue(formObj.frm_sheet1_bkg_no) == '' && ComGetObjValue(formObj.frm_sheet1_bl_no) == '') {
                ComShowCodeMessage("BKG00445");
                ComSetFocus(formObj.frm_sheet1_bkg_no);
                return false;
            }
            ComSetObjValue(formObj.setupfocoblflag, 'Y');//  indicator set for inbound cargo release call
            doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
            break;
        case "btn_cancel":
            if (ComGetObjValue(formObj.frm_sheet1_bkg_no) == '' && ComGetObjValue(formObj.frm_sheet1_bl_no) == '') {
                ComShowCodeMessage("BKG00445");
                ComSetFocus(formObj.frm_sheet1_bkg_no);
                return false;
            }
            // 2010.02.25 surrender creation office와 cancel office간의 일치 여부 확인
            if( ComGetObjValue(formObj.frm_sheet1_obl_rdem_ofc_cd) != ComGetObjValue(formObj.strOfc_cd)){
                ComShowCodeMessage("BKG08138"); //User office does not correspond with surrender creation office.
                ComSetFocus(formObj.frm_sheet1_bkg_no);
                return false
            }
            ComSetObjValue(formObj.setupfocoblflag, 'Y');//  indicator set for inbound cargo release call
            doActionIBSheet(sheetObjects[0], document.form, REMOVE);
            break;
        case "btn_close":
            var obj=new Object();
            obj.obl_rdem_knt=ComGetObjValue(formObj.frm_sheet1_obl_rdem_knt); //No
            obj.obl_rdem_dt=ComGetObjValue(formObj.frm_sheet1_obl_rdem_dt); //Date
            obj.obl_rdem_ofc_cd=ComGetObjValue(formObj.frm_sheet1_obl_rdem_ofc_cd); //At
            obj.obl_rdem_usr_id=ComGetObjValue(formObj.frm_sheet1_obl_rdem_usr_id); //By
            try{
                window.returnValue=obj;//retVal 변수값 설정.
            }catch(e){}
            ComClosePopup(); 
            break;
        /** * BUTTON BL ISSUE (l) ** */
        case "btn_clausesetup":
            if(ComShowConfirm(ComGetMsg("BKG00430"))){
                //<EXCEPTION>1.a Yes를 선택한 경우 Remark를 아래 항목으로 대체
                var clause_msg="FULL SET OF ORIGINAL B/L WERE SURRENDERED TO US BY SHIPPER.\nPLEASE RELEASE CARGO WITHOUT OB/L PRESENTATION TO MANIFESTED \nCONSIGNEE WITH DUE FREIGHT COLLECTION.";
                ComSetObjValue(formObj.frm_sheet1_diff_rmk, clause_msg);
            }else{
            	ComSetObjValue(formObj.frm_sheet1_diff_rmk, "");
                return;
            }
            break;
        case "btn_preview":
            if (ComGetObjValue(formObj.frm_sheet1_bkg_no) == '' && ComGetObjValue(formObj.frm_sheet1_bl_no) == '') {
                ComShowCodeMessage("BKG00445");
                ComSetFocus(formObj.frm_sheet1_bkg_no);
                return false;
            }
            formObj.com_mrdTitle.value="O.B/L Surrender Preview"; // header.
            formObj.com_mrdBodyTitle.value="O.B/L Surrender Preview"; // body.
            formObj.com_mrdPath.value="apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0866.mrd";
            formObj.com_mrdArguments.value="/rp [" + ComGetObjValue(formObj.bkg_no) + "] [Y]";
            ComOpenRDPopup("width=800, height=620");
            break;
        case "btn_print":
            if (ComGetObjValue(formObj.frm_sheet1_bkg_no) == '' && ComGetObjValue(formObj.frm_sheet1_bl_no) == '') {
                ComShowCodeMessage("BKG00445");
                ComSetFocus(formObj.frm_sheet1_bkg_no);
                return false;
            }
            // RD Viewer 생성
            var rdParam="";
            if(ComShowConfirm(ComGetMsg("BKG00431"))){
                rdParam="/rp [" + ComGetObjValue(formObj.bkg_no) + "] [Y]"; 
            }else{
                rdParam="/rp [" + ComGetObjValue(formObj.bkg_no) + "] [N]"; 
            }
            var appendReport = [];
    		var mrdPath = RD_path+"apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0866.mrd";    
    		var mrdParam = RDServer + rdParam;
    		appendReport.push({mrdPath:mrdPath,mrdParam:mrdParam});
    		directReportDownload(appendReport); 
            break;
        case "btn_faxemail":
        	if (ComGetObjValue(formObj.frm_sheet1_bkg_no) == '' && ComGetObjValue(formObj.frm_sheet1_bl_no) == '') {
				ComShowCodeMessage("BKG00445");
				ComSetFocus(formObj.frm_sheet1_bkg_no);
				return false;
			}

			var param = 'f_cmd=SEARCH&bkg_no='+ComGetObjValue(formObj.bkg_no)+"&docType=S&signFlag=Y";
			var url = "ESM_BKG_0095.do?" + param;
			ComOpenPopup(url, 980, 600, "","1,0", false);
			
			break;

        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            bkg_error_alert('fnOnSearchEnd', e);
        } else {
            ComShowMessage(e);
        }
    }
}
var sXml;
var arrXml;
//handling of Sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    var aryPrefix=new Array(prefix1);
    if (!validateForm(sheetObj, formObj, sAction)) { return;
    }
    switch (sAction) {
    case IBSEARCH: // search
        if("Y" != search_flag && ( "Y" == dirty_flag || bf_frm_sheet1_diff_rmk != formObj.frm_sheet1_diff_rmk.value
                 || bf_frm_sheet1_obl_rdem_ofc_cd != formObj.frm_sheet1_obl_rdem_ofc_cd.value
                 || bf_frm_sheet1_obl_rdem_usr_id != formObj.frm_sheet1_obl_rdem_usr_id.value
                 || bf_frm_sheet1_obl_rdem_dt != formObj.frm_sheet1_obl_rdem_dt.value
                 || bf_frm_sheet1_obl_rdem_knt != formObj.frm_sheet1_obl_rdem_knt.value) ) {
            if(confirm(ComGetMsg("BKG95056"))){
                doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
                return ;
            }
        }
        formClearAll();
        ComSetObjValue(formObj.f_cmd, SEARCH);
        ComSetObjValue(formObj.application_date, ComGetObjValue(formObj.frm_sheet1_obl_rdem_dt).split('-').join(""));

        sXml=sheetObj.GetSearchData("ESM_BKG_0400GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
        arrXml=sXml.split("|$$|");
        var State=ComGetEtcData(arrXml[0],"TRANS_RESULT_KEY");
        if ( State == "S" ) {
            for ( var inx=0; inx < arrXml.length; inx++) {
                sheetObjects[inx].LoadSearchData(arrXml[inx],{Sync:0} );
            }   
            //fnOnSearchEnd();
        }else{
            fnExceptionMessage(sXml);
        }
        dirty_flag="N";
        break;
    case IBSAVE: // save
        ComSetObjValue(formObj.f_cmd, MULTI);
        ComSetObjValue(formObj.frm_sheet1_obl_srnd_flg,"Y");
        if (IBS_CopyFormToRow(formObj, sheetObj, 1, "frm_")) {
        }
        var sParam=ComGetSaveString(sheetObjects);
        sParam += "&" + FormQueryString(formObj); 
        sParam += "&" + ComGetPrefixParam(aryPrefix);
        if(!ComShowConfirm(ComGetMsg("BKG00498"))){
            return;
        }
        var sParam=ComGetSaveString(sheetObjects);
        sParam += "&" + FormQueryString(formObj); 
        sParam += "&" + ComGetPrefixParam(aryPrefix);

        sXml=sheetObj.GetSaveData("ESM_BKG_0400GS.do", sParam);
        State=ComGetEtcData(sXml,"TRANS_RESULT_KEY");
        if ( State == "S" ) {   
            ComShowMessage(ComGetMsg("BKG06071"));
            save_success=true;
            sheetObj.LoadSaveData(sXml);
            dirty_flag="N"
            search_flag="Y";
            doActionIBSheet(sheetObj, formObj, IBSEARCH);
        }else{
            fnExceptionMessage(sXml);
        }
        break;
    case REMOVE: //Cancle  
        ComSetObjValue(formObj.f_cmd, REMOVE);
        var sParam=FormQueryString(formObj);
        if(!ComShowConfirm(ComGetMsg("BKG00575"))){
            return;
        }
        var sParam=ComGetSaveString(sheetObjects);
        sParam += "&" + FormQueryString(formObj);
        sParam += "&" + ComGetPrefixParam(aryPrefix);
        sXml=sheetObj.GetSaveData("ESM_BKG_0400GS.do", sParam);
        State=ComGetEtcData(sXml,"TRANS_RESULT_KEY");
        if ( State == "S" ) {   
            ComShowMessage(ComGetMsg("BKG06071"));
            save_success=true;
            sheetObj.LoadSaveData(sXml);
            doActionIBSheet(sheetObj, formObj, IBSEARCH);
        }else{
            fnExceptionMessage(sXml);
        }
        break;
    }
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	var State=ComGetEtcData(arrXml[0],"TRANS_RESULT_KEY");
    if ( State == "S" ) {
//        for ( var inx=0; inx < arrXml.length; inx++) {
//            sheetObjects[inx].LoadSearchData(arrXml[inx],{Sync:0} );
//        }   
        fnOnSearchEnd();
    }else{
        fnExceptionMessage(sXml);
    }
}
/**
* Clear form value
*/
function formClearAll(){
    var formObj=document.form;
    ComSetObjValue(formObj.frm_sheet1_obl_rdem_ofc_cd, '');
    ComSetObjValue(formObj.frm_sheet1_obl_rdem_dt, '');
    ComSetObjValue(formObj.frm_sheet1_obl_rdem_knt, '');
    ComSetObjValue(formObj.frm_sheet1_obl_rdem_usr_id, '');
}

/**
* handling process for input validation
*/
function validateForm(sheetObj, formObj, sAction) {
    if (    ComGetObjValue(formObj.frm_sheet1_bkg_no) == '' 
        &&  ComGetObjValue(formObj.frm_sheet1_bl_no) == '') {
        ComSetFocus(formObj.frm_sheet1_bkg_no);
        return false;
    }
    switch (sAction) {
    case IBSEARCH: // search   
        ComSetObjValue(formObj.bkg_no, ComGetObjValue(formObj.frm_sheet1_bkg_no));
        ComSetObjValue(formObj.bl_no, ComGetObjValue(formObj.frm_sheet1_bl_no));
        break;
    case IBSAVE: // save
            if('W' == ComGetObjValue(formObj.frm_sheet1_bl_tp_cd)){
                ComShowCodeMessage("BKG00372");
                return false;
            }
            if('Y' != ComGetObjValue(formObj.frm_sheet1_obl_rlse_flg)){
                ComShowCodeMessage("BKG08081");
                return false;
            }
            if('N' == ComGetObjValue(formObj.frm_sheet1_obl_rlse_flg)){
                ComShowCodeMessage("BKG00373");
                return false;
            }
            if('Y' == ComGetObjValue(formObj.frm_sheet1_cust_to_ord_flg)){
                ComShowCodeMessage("BKG00374");
                return false;
            }
            if(
                'B' == ComGetObjValue(formObj.frm_sheet1_bl_tp_cd)
                && 'N' == ComGetObjValue(formObj.frm_sheet1_cust_to_ord_flg)
                && 'Y' == ComGetObjValue(formObj.frm_sheet1_obl_rlse_flg)
            ){
                ComBtnEnable("btn_Save");
            }
            if( ComGetObjValue(formObj.bkg_no) != ComGetObjValue(formObj.frm_sheet1_bkg_no)){
                ComShowCodeMessage("BKG00048");
                return false;
            }
            if( ComGetObjValue(formObj.frm_sheet1_del_cd) == ComGetObjValue(formObj.strOfc_cd)){
                ComShowCodeMessage("BKG00435");
                return false;
            }
            var today=ComGetNowInfo().split('-').join("");
            var valday=ComGetObjValue(formObj.frm_sheet1_obl_rdem_dt).split('-').join("");
            if (ComGetDaysBetween(valday, today) > 0) {
                ComShowCodeMessage("BKG00375");
                return false;
            }
            if(!frm_sheet1_obl_rdem_knt_onChange()){
                ComSetFocus(formObj.frm_sheet1_obl_rdem_knt);
                return false;
            }
            ComSetObjValue(formObj.frm_sheet1_obl_rdem_usr_id, ComGetObjValue(formObj.strUsr_id) );
            if(ComGetLenByByte(formObj.frm_sheet1_diff_rmk.value) > 4000){
                ComShowCodeMessage('BKG00107', '[maximum:4000]');
                return false;
            }
            if(bf_frm_sheet1_diff_rmk == formObj.frm_sheet1_diff_rmk.value 
               && bf_frm_sheet1_obl_rdem_ofc_cd == formObj.frm_sheet1_obl_rdem_ofc_cd.value
               && bf_frm_sheet1_obl_rdem_usr_id == formObj.frm_sheet1_obl_rdem_usr_id.value
               && bf_frm_sheet1_obl_rdem_dt == formObj.frm_sheet1_obl_rdem_dt.value 
               && bf_frm_sheet1_obl_rdem_knt == formObj.frm_sheet1_obl_rdem_knt.value) {
                ComShowMessage(ComGetMsg("BKG00737"));
                return;
            }
        break;
    case REMOVE: // cancel   
	        if('Y' != ComGetObjValue(formObj.frm_sheet1_obl_srnd_flg)){
	            ComShowCodeMessage("BKG08083");
	            return false;
	        }
            if( ComGetObjValue(formObj.bkg_no) != ComGetObjValue(formObj.frm_sheet1_bkg_no)){
                ComShowCodeMessage("BKG00429");
                return false;
            }
        break;
    }
    return true;
}

/**
 * fnOnSearchEnd
 * param :sheetObj, ErrMsg
 */
function fnOnSearchEnd() {
    var formObj=document.form;
    var sheetObj=sheetObjects[0];
    try {
        if (sheetObj.GetTotalRows()== 0) return;
        /** =====================================
         *  FORM VALUE BINDING
         *  ===================================== */ 
        if (IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_")) {};
        ComSetObjValue(formObj.frm_sheet1_obl_rdem_ofc_cd,fnNullToBlank(ComGetObjValue(formObj.frm_sheet1_obl_rdem_ofc_cd),ComGetObjValue(formObj.strOfc_cd)));
        ComSetObjValue(formObj.frm_sheet1_obl_rdem_usr_id,fnNullToBlank(ComGetObjValue(formObj.frm_sheet1_obl_rdem_usr_id),ComGetObjValue(formObj.strUsr_id)));
        ComSetObjValue(formObj.frm_sheet1_obl_rdem_dt, fnNullToBlank(ComGetObjValue(formObj.frm_sheet1_obl_rdem_dt),ComGetNowInfo())); 
        bf_frm_sheet1_diff_rmk=formObj.frm_sheet1_diff_rmk.value;
        bf_frm_sheet1_obl_rdem_ofc_cd=formObj.frm_sheet1_obl_rdem_ofc_cd.value;
        bf_frm_sheet1_obl_rdem_usr_id=formObj.frm_sheet1_obl_rdem_usr_id.value;
        bf_frm_sheet1_obl_rdem_dt=formObj.frm_sheet1_obl_rdem_dt.value;
        bf_frm_sheet1_obl_rdem_knt=formObj.frm_sheet1_obl_rdem_knt.value;
        search_flag="N";
        if('Y' == ComGetObjValue(formObj.frm_sheet1_obl_srnd_flg)){
            ComBtnEnable("btn_print");
            ComBtnEnable("btn_faxemail");
        }else{
            ComBtnDisable("btn_print");
            ComBtnDisable("btn_faxemail");
        }
    } catch (ex) {
        bkg_error_alert('fnOnSearchEnd', ex);
        return false;
    }
}

/**
* bkgSplitNoList BKG_list event
* param :split_list
*/
function bkgSplitNoList(split_list){
    document.form.frm_sheet1_bkg_no.value=split_list.options[split_list.selectedIndex].value;
    span_bkg_no.style.display="none";
}

/**
* blSplitNoList BKG_list event
* param :split_list
*/
function blSplitNoList(split_list){
    document.form.frm_sheet1_bl_no.value=split_list.options[split_list.selectedIndex].value;
    span_bl_no.style.display="none";
}

var Select_Bkg_No_Html=null;
var Select_Bl_No_Html=null;

/**
 * fnSetSelectNumberBox create table event 
 */
function fnSetSelectNumberBox(_name, _type) {
    var vobj=eval("document.all." + _name); 
    var sheetObj=sheetObjects[0];
    var formObj=document.form;
    var html="";

    try {
        switch (_type) {
        case 'text_bkg_no': //text
            if (ComIsEmpty(formObj.frm_sheet1_bkg_no.value)) {
                ComShowMessage(ComGetMsg("BKG00463"));
                formObj.frm_sheet1_bkg_no.focus();
                return false;
            }

            if (null == Select_Bkg_No_Html || ComGetObjValue(formObj.bkg_no) != ComGetObjValue(formObj.frm_sheet1_bkg_no)) {
                var param="&f_cmd=" + COMMAND03 + "&bkg_no=" + ComGetObjValue(formObj.frm_sheet1_bkg_no);
                var rXml=sheetObj.GetSearchData("ESM_BKG_0079_01GS.do", param);
                Select_Bkg_No_Html=ComGetEtcData(rXml, "bkg_split_no_list");

                if (Select_Bkg_No_Html.indexOf("<option") < 0)
                    return false;
            }

            var obj=formObj.frm_sheet1_bkg_no;
            var top=document.body.clientTop + obj.offsetParent.offsetTop + obj.offsetTop + obj.offsetParent.offsetHeight + 50;
            var left=document.body.clientLeft + obj.offsetParent.offsetLeft + obj.offsetLeft + 10;
            vobj.innerHTML=Select_Bkg_No_Html;
            vobj.style.top=top;
            vobj.style.left=left;
            vobj.style.display="inline";
            return;
            break;
        case 'text_bl_no': //text
            if (ComIsEmpty(formObj.frm_sheet1_bl_no.value)) {
                ComShowMessage(ComGetMsg("BKG00609"));
                formObj.frm_sheet1_bl_no.focus();
                return false;
            }

            if (null == Select_Bl_No_Html || ComGetObjValue(formObj.bl_no) != ComGetObjValue(formObj.frm_sheet1_bl_no)) {
                fnSetBlNoStringCheck(ComGetObjValue(formObj.frm_sheet1_bl_no));
                var param=param + "&f_cmd=" + SEARCHLIST15 + "&input_text=" + ComGetObjValue(formObj.bl_no);
                var sXml=sheetObj.GetSearchData("ESM_Booking_UtilGS.do", param);
                var output_text=ComGetEtcData(sXml, "output_text");
                output_text=output_text + '^' + output_text;
                Select_Bl_No_Html=fnSetSelectString('fnSetBlNo', output_text);
            }

            var obj=formObj.frm_sheet1_bl_no;
            var top=document.body.clientTop + obj.offsetParent.offsetTop + obj.offsetTop + obj.offsetParent.offsetHeight + 50;
            var left=document.body.clientLeft + obj.offsetParent.offsetLeft + obj.offsetLeft + 10;
            vobj.innerHTML=Select_Bl_No_Html;
            vobj.style.top=top;
            vobj.style.left=left;
            vobj.style.display="inline";
            break;
        }
    } catch (ex) {
        bkg_error_alert('fnSetSelectNumberBox', ex);
    }
}

/**
* fnSetBlNoStringCheck BL_Number check
* ComGetObjValue(formObj.frm_t11sheet1_bl_no)
* param :
*/
function fnSetBlNoStringCheck(t_bl_no) {
    var formObj=document.form;
        if(t_bl_no.length>12){
             ComSetObjValue(formObj.bl_no, t_bl_no.substr(0,12));
        }else{
            ComSetObjValue(formObj.bl_no, t_bl_no);
        }
}

/**
 * fnSetSelectString create table event
 */
function fnSetSelectString(_name, _value) {
    var html="";
    try {
        var aList=_value.split("^");
        var aCode, aName;
        var aCode=aList[0].split("$");
        var aName=aList[1].split("$");
        var len=aCode.length;
        if (len == 0)
            return;
        html="<select style='width:120;' class='input' size=5 multiple onChange='javascript:blSplitNoList(this);' name='" + _name + "'>"
        for ( var z=0; z < len; z++) {
            html += "<option value='" + aCode[z] + "'>" + aName[z] + "</option>";
        }
        html += "</table>";
    } catch (ex) {
        bkg_error_alert('fnSetSelectString', ex);
    }
    return html;
}

function check_Enter() {
    var formObj=document.form;
    if (ComGetEvent("keycode") == 13) {
        span_bkg_no.style.display="none";
        span_bl_no.style.display="none";
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    }
}

/**
* frm_sheet1_obl_rdem_knt_onChange <br>
* 1. Compare No. of B/L Issued to No. of O.B/L
* <EXCEPTION>
* param : obj
**/
function frm_sheet1_obl_rdem_knt_onChange(obj){
    var formObj=document.form;  
    var obl_rdem_knt=fnNullToBlank(ComGetObjValue(formObj.frm_sheet1_obl_rdem_knt),0); //No1
    var obl_iss_knt=fnNullToBlank(ComGetObjValue(formObj.frm_sheet1_obl_iss_knt),0); //No2
    if(obl_rdem_knt != obl_iss_knt){
        ComShowCodeMessage("BKG00376");
        return false; 
    }
    return true; 
}

/**
 *  Check Validation onblur event. <br>
 **/
function obj_deactivate() {
    switch (ComGetEvent("name")) {
        case "frm_sheet1_obl_rdem_dt":
            ComAddSeparator(ComGetEvent());
            break;
        default:
            break;
    }
}

/**
 *  Check Validation onblur event. <br>
**/
function obj_activate() {
    var formObj=document.form;
    switch (ComGetEvent("name")) {
        case "frm_sheet1_obl_rdem_dt":
            ComClearSeparator(ComGetEvent());
            break;
        default:
            break;
    }
}

/**
* fnNullToBlank
* param : xval,yval
*/
function fnNullToBlank(xval, yval) {
    return (xval != null && xval != "") ? xval : yval;
}

/**
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++]=sheet_obj;
}

/**
 * bkg_error_alert 
 */
function bkg_error_alert(msg, ex) {
    alert('[ ' + msg + ' ]=[ ' + ex.name + ' ][ ' + ex.number + ' ][ ' + ex.description + ' ]');
}

/**
* fnExceptionMessage 
*/
function fnExceptionMessage(rXml){
    var formObj=document.form;
    var rMsg=ComGetEtcData(rXml,"Exception")
    var rmsg=rMsg.split("<||>");
    if(rmsg[3] != undefined && rmsg[3].length > 0) {
        ComShowMessage(rmsg[3]);
    }else{
        sheetObjects[0].LoadSaveData(rXml);
    }
    ComResetAll();
    ComSetFocus(formObj.frm_sheet1_bkg_no);
}
/* end developer job*/
