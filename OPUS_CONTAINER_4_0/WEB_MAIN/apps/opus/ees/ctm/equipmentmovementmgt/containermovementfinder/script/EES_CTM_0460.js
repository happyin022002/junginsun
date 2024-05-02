/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CTM_0460.js
*@FileTitle  : VL/VD update status
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/27
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// common global variables
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event  */
document.onclick=processButtonClick;
// Event handler processing by button name */
 function processButtonClick(){
      var sheetObject=sheetObjects[0];
      /*******************************************************/
      var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
         switch(srcName) {
            case "btn_retrieve":
                    if (checkFormField())
                        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                        break;
            case "btn_Detl":
                 row=sheetObjects[0].GetSelectRow();
                 if (row < 2) return;
                 etdDt=sheetObjects[0].GetCellText(row, "etd");
                 stsCd=document.form.p_status.value;
                 yard=sheetObjects[0].GetCellValue(row, "port");
                 vvdCd=sheetObjects[0].GetCellValue(row, "vvd");
                 url="EES_CTM_0413_POP.do?etdDt=" + etdDt + "&stsCd=" + stsCd + "&yard=" + yard + "&vvdCd=" + vvdCd;
                 rtnValue=ComOpenPopup(url, 1280, 682, "", "0,1");
                break;
            case "btn_New":
                    document.form.reset();
                    sheetObjects[0].RemoveAll();
                    break;
             case "btn_Calendar1":
             case "btn_Calendar2":
                var cal=new ComCalendarFromTo();
                    cal.select(formObject.p_date1, formObject.p_date2, 'yyyy-MM-dd');
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
  * registering IBSheet Object as list
  * adding process for list in case of needing batch processing with other items 
  * defining list on the top of source
  */
 function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
 }
 /**
  * initializing sheet
  * implementing onLoad event handler in body tag
  * adding first-served functions after loading screen.
  */
 function loadPage() {
     for(i=0;i<sheetObjects.length;i++){
         ComConfigSheet (sheetObjects[i] );
         initSheet(sheetObjects[i],i+1);
         ComEndConfigSheet(sheetObjects[i]);
     }
     setEventProcess("p_vvd");
     // OnKeyPress event (common function)
     axon_event.addListener("blur", "vvd_change", "p_vvd");
     axon_event.addListener("keyup", "vvd_keyUp", "p_vvd");
     axon_event.addListener("keypress", "obj_keypress", "p_vvd");
     document.form.p_date1.focus();
     ComBtnDisable("btn_Detl");
 }
/**
 * focusing on VVD in case inputed value is not 9 characters
 * @param event
 */
function vvd_change(event) {
    eventElement=ComGetEvent();
    var vvdCode=eventElement.value;
    if (vvdCode == '') return;
    if (vvdCode.length != 9) {
        eventElement.select();
        eventElement.focus();
    }
}
/**
 * validating VVD Code on Keyboard Event
 * @param event
 */
function vvd_keyUp(event) {
    eventElement=ComGetEvent();
    var vvdCode=eventElement.value;
    if (vvdCode.length == 9) {
        vvd_check(event);
    }
}
/**
 * validating VVD Code
 */
function vvd_check() {
    formObj=document.form;
    sheetObj=sheetObjects[0];
    strQuery="f_cmd=" + SEARCH02 + "&p_vvd=" + formObj.p_vvd.value
    if (formObj.p_status.value="VL")
        strQuery=strQuery + "&p_pol=" + formObj.p_yard1.value;
    else
        strQuery=strQuery + "&p_pod=" + formObj.p_yard1.value;
        rtnXml=sheetObj.GetSearchData("EES_CTM_0406GS.do",  strQuery );
    rtnValue=ComGetEtcData(rtnXml, "rtnStr");
    rtnStr=rtnValue.split("|");
    status=document.form.p_status.value;
    if (rtnStr.length == 2) {
        if (status == 'VL' || status == 'VD') {
            str=rtnStr[0];
        }
        etaEtdPass=true;
    } else {
        etaEtdPass=false;
        ComShowCodeMessage("CTM20073");
        //alert ("VVD Code is Not Exists")
        formObj.p_vvd.select();
        formObj.p_vvd.focus();
        return false;
    }
    return true;
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetNo) {
        case 1:      //t1sheet1 init
            with(sheetObj){
                var HeadTitle1="|Seq.|VVD Code|Lane|ETA(VD) or ETD(VL)|Port|Full|Full|Full|Full|Full|Empty|Empty|Empty|Empty|Empty";
                var HeadTitle2="|Seq.|VVD Code|Lane|ETA(VD) or ETD(VL)|Port|Plan (BKG)|EDI|Manual|Total|Result|Plan (BKG)|EDI|Manual|Total|Result";
                
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Status",    Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"ibflag" },
                            {Type:"Seq",       Hidden:0, Width:30,   Align:"Right",   ColMerge:0,   SaveName:"SEQ" },
                            {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vvd" },
                            {Type:"Text",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"lane" },
                            {Type:"Text",     Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"etd" },
                            {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"port" },
                            {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bkg1" },
                            {Type:"Text",     Hidden:0,  Width:57,   Align:"Center",  ColMerge:1,   SaveName:"edi1" },
                            {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"man1" },
                            {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"total1" },
                            {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"result1" },
                            {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bkg2" },
                            {Type:"Text",     Hidden:0,  Width:57,   Align:"Center",  ColMerge:1,   SaveName:"edi2" },
                            {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"man2" },
                            {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"total2" },
                            {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"result2" } ];

                InitColumns(cols);
                
                SetEditable(0);
                SetCountPosition(0);
                SetWaitTimeOut(6000);
                SetMergeCell(0,1, 2,1);
//                SetSheetHeight(460);
                resizeSheet();
            }

            break;
     }
}
//handling process for Sheet
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
        case IBSEARCH:     
            if(validateForm(sheetObj,formObj,sAction)) {
                if (ComGetUnMaskedValue(ComGetDateAdd(formObj.p_date1.value, "M", 1),'ymd') < ComGetUnMaskedValue(formObj.p_date2.value, 'ymd')) {
                    ComShowCodeMessage("CTM30012", "1 month");
                    return;
                }
                sheetObj.RemoveAll();
                ComBtnDisable("btn_retrieve");
                ComBtnDisable("btn_New");
                ComBtnDisable("btn_Detl");
                // calling BackEnd Job. 
                ComOpenWait(true);
                sheetObj.SetWaitImageVisible(0);
                formObj.f_cmd.value=COMMAND01;
                var sXml=sheetObj.GetSearchData("EES_CTM_0460GS.do", FormQueryString(formObj));
                var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey")
                if (backendJobKey.length > 0) {
                    formObj.backendjob_key.value=backendJobKey;
                    sheetObj.SetWaitImageVisible(0);
                    sheetObj.SetWaitTimeOut(10000);
                    // calling getBackEndJobStatus every 3 seconds by setInterval
                    timer=setInterval(getBackEndJobStatus, 3000); //calling getBackEndJobStatus function in 3 seconds
                }
            }
            break;
    }
}
/**
* handling process for input validation
*/
function validateForm(sheetObj,formObj,sAction){
    with(formObj){
        var date1=formObj.p_date1.value;
        var date2=formObj.p_date2.value;
        date1=ComGetUnMaskedValue(date1, "ymd");
        date2=ComGetUnMaskedValue(date2, "ymd");
        if (date1 == '' || date2 == '') return false;
        if (date1 > date2) {
             ComShowCodeMessage("COM12133","From Date","To Date","earlier");
            formObj.p_date1.focus();
            return false;
        }
    }
    return true;
}
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    sheetObj.SetCellBackColor(i, "EventDate","#CCFFFD");
}
/**
 * checking until Status='3'
 */
function getBackEndJobStatus() {
    formObj=document.form;
    var sheetObject1=sheetObjects[0];
    formObj.f_cmd.value=SEARCH;
    sheetObject1.SetWaitImageVisible(0);
    var sXml=sheetObject1.GetSearchData("EES_CTM_0460GS.do", FormQueryString(formObj));
    var jobState=ComGetEtcData(sXml, "jb_sts_flg")
    if (jobState == "3") {
        getBackEndJobLoadFile();
        clearInterval(timer);
        ComBtnEnable("btn_retrieve");
        ComBtnEnable("btn_New");
        //ComBtnEnable("btn_Detl");
    } else if (jobState == "4") {
        // BackEndJob failed
        ComShowCodeMessage('CTM10024');
        ComOpenWait(false);
        clearInterval(timer);
        ComBtnEnable("btn_retrieve");
        ComBtnEnable("btn_New");
    } else if (jobState == "5") {
        // already read BackEndJob result file
        ComShowCodeMessage('CTM10024');
        ComOpenWait(false);
        clearInterval(timer);
        ComBtnEnable("btn_retrieve");
        ComBtnEnable("btn_New");
    }
    if (sheetObjects[0].LastRow()> 2)
        ComBtnEnable("btn_Detl");
    else
    {
        if(sheetObjects[0].GetCellValue(2, "SEQ") == 1)
        {
            ComBtnEnable("btn_Detl");
        }
        else    
        ComBtnDisable("btn_Detl");
    }
 }
/**
 * downloading Excle after BackEndJob end (Request Expense Inital)
 */
function getBackEndJobLoadFile() {
    formObj=document.form;
    formObj.f_cmd.value=SEARCHLIST;
    var sheetObj=sheetObjects[0];
    sheetObj.ShowDebugMsg(false);
    sheetObj.SetWaitImageVisible(0);

    var sXml=sheetObj.GetSearchData("EES_CTM_0460GS.do ", FormQueryString(formObj));
    if (sXml != "") sheetObj.LoadSearchData(sXml,{Sync:1} );

    
    
    
    ComOpenWait(false);
}
function sheet1_OnDblClick(Row, Col, CellX, CellY, CellW, CellH) {
    row=sheetObjects[0].GetSelectRow();
    if (row < 2) return;
    etdDt=sheetObjects[0].GetCellText(row, "etd");
    stsCd=document.form.p_status.value;
    yard=sheetObjects[0].GetCellValue(row, "port");
    vvdCd=sheetObjects[0].GetCellValue(row, "vvd");
    url="EES_CTM_0413_POP.do?etdDt=" + etdDt + "&stsCd=" + stsCd + "&yard=" + yard + "&vvdCd=" + vvdCd;
    rtnValue=ComOpenPopup(url, 1280, 682, "", "0,1");
}
function resizeSheet(){
	ComResizeSheet(sheetObjects[0]);
}