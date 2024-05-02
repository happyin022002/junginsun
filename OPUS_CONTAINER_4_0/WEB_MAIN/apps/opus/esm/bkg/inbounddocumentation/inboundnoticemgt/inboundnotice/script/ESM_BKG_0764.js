/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0764.jsp
*@FileTitle  : Customer Data Management Update History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/

var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var sheetNames=new Array("sheet1", "sheet2");
// Event handler processing by button click event */
document.onclick=processButtonClick;
/**
 * Event handler processing by button name<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return {void}
 * @author
 * @version 2009.10.01
 */
function processButtonClick(){
    /***** using extra sheet valuable if there are more 2 sheets *****/
    var sheetObject1=sheetObjects[0];
    var sheetObject2=sheetObjects[1];
    /*******************************************************/
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        switch(srcName) {
            case "btn_cng_dt":
                var cal=new ComCalendarFromTo();
                cal.select(formObject.cng_dt_s, formObject.cng_dt_e, 'yyyy-MM-dd');
                break;
            case "btn_Retrieve":
                doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
                break;
            case "btn_Close":
            	ComClosePopup(); 
                break;
        } // end switch
    }catch(e) {
        if( e == "[object Error]") {
            ComShowMessage(OBJECT_ERROR);
        } else {
            ComShowMessage(e.message);
        }
    }
}
/**
 * registering IBSheet Object as list<br>
 * adding process for list in case of needing batch processing with other items<br>
 * defining list on the top of source<br>
 * @param  sheet_obj
 * @return {void}
 */
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * initializing sheet<br>
 * implementing onLoad event handler in body tag<br>
 * adding first-served functions after loading screen.<br>
 * @param {void}
 * @return {void}
 * @author
 * @version 2009.10.01
 */
function loadPage() {
    var formObj=document.form;
    fnInSetComboBox(formObj.cust_cntc_tp_cd, evtCode, evtValue, "|", "", "All", true, "");
    for(i=0;i<sheetNames.length;i++){
    	if(sheetNames[i] == "sheet1") {
	        ComConfigSheet (sheetObjects[i] );
    	}
        initSheet(sheetObjects[i],i+1);
        if(sheetNames[i] == "sheet1") {
	        ComEndConfigSheet(sheetObjects[i]);
        }
    }
    sheetObjects[0].SetRangeBackColor(1,3,1,4,"#555555");
    initControl();
    var formObj=document.form;
    formObj.cust_cnt_cd.value=parCustCntCd;
    formObj.cust_seq.value=parCustSeq;
    formObj.ofc_cd.value=strOfc_cd;
    if (formObj.cust_cnt_cd.value.trim() != ""
         && formObj.cust_seq.value.trim() != ""
         && formObj.ofc_cd.value.trim() != "") {
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
}
/**
 * initializing : register event<br>
 * @param {void}
 * @return void
 * @author
 * @version 2009.10.01
 */
function initControl() {
    var formObj=document.form;
    axon_event.addListenerForm ('change', 'obj_change', form);
    axon_event.addListenerForm ('blur', 'obj_deactivate', form);
    //axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
    //axon_event.addListenerForm('keypress', 'objKeyPress', form);
    //axon_event.addListenerForm('keyup', 'objKeyUp', form);
    formObj.cng_dt_s.value=ComGetDateAdd(null, 'd', -14, '-');
    formObj.cng_dt_e.value=ComGetNowInfo('ymd','-');
}
/**
 * setting sheet initial values and header<br>
 * @param  sheetObj
 * @param  sheetNo
 * @return {void}
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    var sheetID=sheetObj.id;
    switch(sheetID) {
        case "sheet1":
            with (sheetObj) {
	            
	            var HeadTitle1="|SEQ|Concerned Party|Fax No./E-Mail Address|Fax No./E-Mail Address|Manual\n/ Auto|B/L No|Do Not\nSend|Update Time|User ID|Office|User Name";
	            var HeadTitle2="|SEQ|Concerned Party|New|Old|Manual\n/ Auto|B/L No|Do Not\nSend|Update Time|User ID|Office|User Name";
	            var headCount=ComCountHeadTitle(HeadTitle1);
	            (headCount, 0, 0, true);
	
	            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	            var headers = [ { Text:HeadTitle1, Align:"Center"},
	                        { Text:HeadTitle2, Align:"Center"} ];
	            InitHeaders(headers, info);
	
	            var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"hdnStatus" },
	                   {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"SEQ" },
	                   {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"cust_cntc_tp_cd_desc",  KeyField:0,   CalcLogic:"",   Format:"",                 PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
	                   {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"new_cntc_ctnt",         KeyField:0,   CalcLogic:"",   Format:"",                 PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
	                   {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"old_cntc_ctnt",         KeyField:0,   CalcLogic:"",   Format:"",                 PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
	                   {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"auto_mnl_flg_desc",     KeyField:0,   CalcLogic:"",   Format:"",                 PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
	                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",                 KeyField:0,   CalcLogic:"",   Format:"",                 PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
	                   {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"snd_sel_flg_desc",      KeyField:0,   CalcLogic:"",   Format:"",                 PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
	                   {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"cng_dt",                KeyField:0,   CalcLogic:"",   Format:"",                 PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
	                   {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cng_usr_id",            KeyField:0,   CalcLogic:"",   Format:"",                 PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
	                   {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",                KeyField:0,   CalcLogic:"",   Format:"",                 PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
	                   {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cng_usr_nm",            KeyField:0,   CalcLogic:"",   Format:"",                 PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 } ];
	             
	            InitColumns(cols);
	
	            SetEditable(1);
	            SetCountPosition(0);
	            SetEllipsis(1);
	            SetWaitImageVisible(0);
	            SetColProperty("cng_dt", {Format:"####-##-## ##:##"} );
	            SetShowButtonImage(2);
	            //SetRowHeight(0,10);
	            //SetRowHeight(1,10);
	            SetSheetHeight(282);
            }
            break;
        case "sheet2":
            with (sheetObj) {
	            
	            var HeadTitle1="|SEQ|Concerned Party|Fax No./E-Mail Address|Fax No./E-Mail Address|Manual\n/ Auto|B/L No|Do Not\nSend|Update Time|User ID|Office|User Name";
	            var headCount=ComCountHeadTitle(HeadTitle1);
	            (headCount, 0, 0, true);
	
	            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	            var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	            InitHeaders(headers, info);
	
	            var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"hdnStatus" } ];
	             
	            InitColumns(cols);
	
	            SetEditable(1);
	            SetVisible(0);
	            //SetSheetHeight(0);
            }
            break;
    }
}
/**
 * handling sheet process
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return void
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
    //sheetObj.ShowDebugMsg = false;
    switch(sAction) {
        case IBSEARCH:      //retrieve
            if(!validateForm(sheetObj,formObj,sAction)) {return; }
            formObj.f_cmd.value=SEARCH;
            ComOpenWait(true,true);
            sheetObj.DoSearch("ESM_BKG_0764GS.do", FormQueryString(formObj) );
            break;
        case SEARCH01: // retrieve Customer's name
            // checking the customer's code
            if ((formObj.cust_cnt_cd.value == null || formObj.cust_cnt_cd.value == "" )
                    &&( formObj.cust_seq.value == null || formObj.cust_seq.value == "" )) {
                return;
            } else {
                if (formObj.cust_cnt_cd.value.length < 2) {
                    ComShowCodeMessage("BKG00186");
                    formObj.cust_cnt_cd.focus();
                    return;
                } else if(formObj.cust_seq.value.value="") {
                    ComShowCodeMessage("BKG00187");
                    formObj.cust_seq.focus();
                    return;
                }
            }
            formObj.f_cmd.value=SEARCH01;
            var sXml=sheetObjects[1].GetSearchData("ESM_BKG_0764GS.do", FormQueryString(formObj));
            sheetObjects[1].LoadSearchData(sXml,{Sync:1} );
            var isError=sXml.substring(1,6);
            if (isError == "ERROR") {
                formObj.cust_nm.value="";
                return;
            }
            var sCustNm=ComGetEtcData(sXml, "cust_nm");
            if (sCustNm == null ) {
                axon_event.removeListener ("cust_seq", "beforedeactivate", "obj_deactivate");
                formObj.cust_seq.focus();
                axon_event.addListenerForm ('beforedeactivate', 'obj_deactivate', form);
                return;
            }
            formObj.cust_nm.value=sCustNm;
        break;
    }
}
/**
 * handling process for input validation<br>
 * @param  sheetObj
 * @param  formObj
 * @param  sAction
 * @return boolean
 */
function validateForm(sheetObj,formObj,sAction){
    with(formObj){
        if(!ComChkValid(formObj)) return false;
        if(!ComBkgMonthsBetweenCheck(formObj.cng_dt_s.value,formObj.cng_dt_e.value, 3)) {
            ComShowCodeMessage("BKG40013", 3);
            ComSetFocus(formObj.cng_dt_e);
            return false;
        }
    }
    return true;
}
/**
 * keyboard event handling from formObject<br>
 * @param {void}
 * @return void
 */
function obj_keydown() {
    var objName=ComGetEvent("name");
    var formObj=document.form;
    var evtCode=(window.netscape) ? ev.which : event.keyCode;
    switch(objName) {
        case "cust_seq":
            break;
        default:
            ComKeyEnter();
            break;
    }
}
/**
 * event handling in case of changing form object<br>
 * @param {void}
 * @return void
 * @author
 * @version 2009.10.01
 */
function obj_change() {
    var objName=ComGetEvent("name");
    var formObj=document.form;
    switch(objName) {
        case "auto_mnl_flg":
            if (formObj.auto_mnl_flg.value == "Y") {
                formObj.snd_sel_flg.disabled=true;
            } else {
                formObj.snd_sel_flg[0].selected=true;
                formObj.snd_sel_flg.disabled=false;
            }
            break;
    }
}
/**
 * event handling when typing the keyboard
 * @param {void}
 * @return void
 */
//function objKeyPress() {
//    var objName=ComGetEvent("name");
//    var formObj=document.form;
//    switch(objName) {
//        case "cust_cnt_cd":
//	        ComKeyOnlyAlphabet('upper');
//            break;
//	    case "cust_seq":
//	    	ComKeyOnlyNumber(ComGetEvent());
//		    break;
//	    case "cng_dt_s":
//	   	    obj_KeyPress(ComGetEvent());
//		    break;
//	    case "cng_dt_e":
//	   	    obj_KeyPress(ComGetEvent());
//		    break;
//    }
//}
/**
 * event handling when typing off the keyboard<br>
 * @param {void}
 * @return void
 */
function objKeyUp() {
    ComKeyEnter('LengthNextFocus');
}
/**
 * event handling when deactivating the form object
 * @param {void}
 * @return void
 * @author
 * @version 2009.10.01
 */
function obj_deactivate(){
    var objName=ComGetEvent("name");
    var formObj=document.form;
    switch(objName) {
        case "cust_seq":
            if (formObj.cust_seq.value != "") {
                doActionIBSheet(sheetObjects[0],formObj,SEARCH01);
            }
            break;
    }
}
/**
 * process after retrieve
 * @param  sheetObj
 * @param  errStr
 * @returns void
 */
function sheet1_OnSearchEnd(sheetObj, errXml) {
	ComOpenWait(false);
}
