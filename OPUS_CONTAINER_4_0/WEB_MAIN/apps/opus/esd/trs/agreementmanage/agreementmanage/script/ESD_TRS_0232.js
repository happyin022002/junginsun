/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESD_TRS_0232.js
*@FileTitle  : Agreement Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/27
=========================================================*/

function initSheet(sheetObj, sheetNo) {
  var sheetObject=sheetObjects[0];
  var cnt=0;
  switch(sheetNo) {
      case 1: //sheet_main init
            with(sheetObj){

    var HeadTitle1="||Seq|AGMT NO|Service Provider|Service Provider|Cost\nMode|Trans\nMode|T/Ship|Cargo\nType|Cargo\nNature|Surcharge|Customer\nCode|Commodity\nGroup Code|Rail\nService|Reference No|Remarks|Contract\nOffice|Update\nDate|Update\nUser|Update\nOffice" ;
    var HeadTitle2="||Seq|AGMT NO|Code|Name|Cost\nMode|Trans\nMode|T/Ship|Cargo\nType|Cargo\nNature|Surcharge|Customer\nCode|Commodity\nGroup Code|Rail\nService|Reference No|Remarks|Contract\nOffice|Update\nDate|Update\nUser|Update\nOffice" ;

    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:4, DataRowMerge:1 } );

    var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
    var headers = [ { Text:HeadTitle1, Align:"Center"},
                      { Text:HeadTitle2, Align:"Center"} ];
    InitHeaders(headers, info);

    var cols = [ {Type:"CheckBox",  Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Status",    Hidden:1,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0 },
                 {Type:"Seq",       Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"seq",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0 },
                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"agmt_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
                 {Type:"Text",      Hidden:0,  Width:210,  Align:"Left",    ColMerge:1,   SaveName:"vndr_nm",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"trsp_cost_mod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"agmt_trsp_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"trsp_bnd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cgo_tp_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cgo_cntr_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"scg_exist_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cust_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_grp_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rail_svc_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"agmt_ref_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"inter_rmk",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1000},
                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ctrt_ofc_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
                 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"upd_dt",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cre_ofc_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
                 {Type:"Text",      Hidden:1,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rate_tot_cnt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
                 {Type:"Text",      Hidden:1,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"trsp_agmt_ofc_cty_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
                 {Type:"Text",      Hidden:1,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"trsp_agmt_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
                 {Type:"Text",      Hidden:1,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"trsp_agmt_rt_tp_ser_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
                 {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eq_knd_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 } ];
           
        InitColumns(cols);

        SetEditable(1);
        SetMergeCell(0, 4, 1, 2);
        resizeSheet();
              }
            break;
  }
}

// UI 표준화관련 하단 여백 설정
function resizeSheet() {
    ComResizeSheet(sheetObjects[0]);
}

/**
* Setting sheets and initialization 
* Implementing the onLoad event handler of body tag
* Adding the preceding function after loading page
*/
function loadPage() {
    for(i=0;i<sheetObjects.length;i++) {
        ComConfigSheet(sheetObjects[i] ); 
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]); 
    }
}

/*------------------ Defining general java script function   ------------------*/

/* General global variable */
var openWindownm='AGMT';
var sheetObjects=new Array();
var sheetCnt=0;

document.onclick=processButtonClick;

var Mincount=0;

/* Branch processing event handler with the name of button */
function processButtonClick() {
    var sheetObject=sheetObjects[0];
    /*******************************************************/
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        switch(srcName) {
        case "btn_retrieve":
            if( validateFormSearch() ) {
                doActionIBSheet(sheetObject,formObject,IBSEARCH);
            }
            break;
        case "btn_minimize":
            Mincount=(Mincount+1)%2;
            Minimize(Mincount);
            break;
        case "btn_serviceprovider":
            rep_OnPopupClick();
            break;
        case "btn_reset":
            reset_all();
            break;
        case "btn_agmtno":
            openAgmtNo();
            break;
        case "btng_allrateinquiry":
            openAllRateInquiry();
            break;
        case "btng_rateinquiry":
            openRateInquiry();
            break;
        case "btng_allsurchargeinquiry":
            openAllScgRateInquiry();
            break;
        case "btng_surchargeinquiry":
            openScgRateInquiry();
            break;
        case "btng_downexcel":
            if(sheetObject.RowCount() < 1){//no data
                ComShowCodeMessage("COM132501");
            }else{
            	sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol_TRS(sheetObject), CheckBoxOnValue:'Y', CheckBoxOffValue:'N', SheetDesign:1, Merge:1 });
            }
            break;
        } // end switch
    }catch(e) {
        if( e == "[object Error]") {
            ComShowCodeMessage('TRS90031');
        } else {
            ComShowMessage(e.message);
        }
    }
}

function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    var formObject=document.form;
    var x1="";
    switch(sAction) {
    case IBSEARCH:
        formObj.f_cmd.value=SEARCH01;
        sheetObj.DoSearch("ESD_TRS_0224GS.do", TrsFrmQryString(formObj) );
        break;
    case IBDELETE:
        if( sheetObj.CheckedRows("chk") < 1 ) {
            errMsg=ComGetMsg("TRS90036");
            ComShowMessage(errMsg);
            return false;
        } else {
            formObj.f_cmd.value=REMOVE02;
            sheetObj.DoSave("ESD_TRS_0224GS.do", TrsFrmQryString(formObj), -1, false, true);
        }
        break;
    }
}

/**
 * Register IBSheet Object with array
 * call from comSheetObject(id)
 */
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++]=sheet_obj;
}

function getSubOffice() {
    var doc_office=document.form.chk_office;
    var prm_office=doSepRemove(document.form.fm_ctrt_ofc_cd.value.toUpperCase(), " "); //input text
    if( prm_office == "" ) {
        doc_office.checked=false;
        document.form.fm_ctrt_ofc_cd.value="";
        ComShowMessage("Please input the 'Contract Office'!!");
        return false;
    }
    if( doc_office.checked == true ) {
        var url="ESD_TRS_0221GS.do?f_cmd="+SEARCH07+"&fm_ctrt_ofc_cd="+prm_office;
        document.form.old_ofc_cd.value=prm_office;
        createHttpRequest();
        request.open("GET", url, false);
        request.onreadystatechange=subCntorlOffice;
        request.send(null);
    } else {
        document.form.fm_ctrt_ofc_cd.value=document.form.old_ofc_cd.value;
    }
}

// Handling the Include Office
var request=null;
function createHttpRequest() {
    try{
        request=new XMLHttpRequest();
    } catch(trymicrosoft) {
        try{
            request=new ActiveXObject("Msxml2.XMLHTTP");
        } catch(othermicosoft) {
            try{
                request=new ActiveXObject("Microsoft.XMLHTTP");
            } catch(failed) {
                request=null;
            }
        }
    }
    if( request == null ) {
        ComShowMessage("Erroe Request XMLHttp");
    }
}

function subCntorlOffice() {
    if( request.readyState == 4 ) {
        if( request.status == 200 ) {
            var docXml=request.responseXML;
            var rowXml=docXml.getElementsByTagName("row-count")[0];
            var subXml=null;
            var text_ofc="";
            for( var n=0; n < rowXml.firstChild.nodeValue; n++ ) {
                subXml=docXml.getElementsByTagName("sub-office")[n];
                text_ofc=text_ofc+subXml.firstChild.nodeValue+",";
            }
            if( text_ofc.length < 1 ) {
                ComShowMessage("No Data!");
            }
            document.form.fm_ctrt_ofc_cd.value=text_ofc.substring(0, text_ofc.length-1);
        }
    }
}
function openAllRateInquiry() {
    var sheetObject=sheetObjects[0];
    var checkList=sheetObject.FindCheckedRow('chk');
    var checkArray=checkList.split('|');
    var resultcheck=0;
    if(checkList.length < 1) {
        ComShowCodeMessage('TRS90215'); 
        return;
    }
    var chk_agmt_no=sheetObject.GetCellValue(checkArray[0], 'agmt_no');
    var chk_trsp_agmt_rt_tp_ser_no=sheetObject.GetCellValue(checkArray[0], 'trsp_agmt_rt_tp_ser_no');
    var chk_trsp_agmt_rt_tp_cd=sheetObject.GetCellValue(checkArray[0], 'trsp_agmt_rt_tp_cd');
    var formObj=document.form;
    formObj.chk_agmt_no.value=chk_agmt_no;
    formObj.chk_trsp_agmt_rt_tp_ser_no.value="";
    formObj.chk_trsp_agmt_rt_tp_cd.value=chk_trsp_agmt_rt_tp_cd;
    formObj.eq_knd_cd.value = sheetObject.GetCellValue(checkArray[0], 'eq_knd_cd');
    if(checkArray.length > 0){
        resultcheck=1;
        for(var i=0; i<checkArray.length; i++){
            if(sheetObject.GetCellValue(checkArray[0], 'agmt_no')+ sheetObject.GetCellValue(checkArray[0], 'trsp_agmt_rt_tp_ser_no')
                    == sheetObject.GetCellValue(checkArray[i], 'agmt_no') + sheetObject.GetCellValue(checkArray[i], 'trsp_agmt_rt_tp_ser_no') ){
            }else{
                resultcheck++;
            }
        }
    }
    if(resultcheck == 1){
        var myOption="width=1100px,height=670px,menubar=0,status=0,scrollbars=0,resizable=1";
        var param="?"+TrsFrmQryString(formObj);
        myWin=window.open('/opuscntr/ESD_TRS_0226.do' + param, "popup", myOption);          
    }else if(resultcheck == 0){
        ComShowCodeMessage('TRS90215');
    }else if(resultcheck > 1){
        ComShowCodeMessage('TRS90357');
    }
}

function openRateInquiry() {
    var sheetObject=sheetObjects[0];
    var checkList=sheetObject.FindCheckedRow('chk');
    var checkArray=checkList.split('|');
    var resultcheck=0;
    if(checkList.length < 1) {
        ComShowCodeMessage('TRS90215'); 
        return;
    }
    var chk_agmt_no=sheetObject.GetCellValue(checkArray[0], 'agmt_no');
    var chk_trsp_agmt_rt_tp_ser_no=sheetObject.GetCellValue(checkArray[0], 'trsp_agmt_rt_tp_ser_no');
    var chk_trsp_agmt_rt_tp_cd=sheetObject.GetCellValue(checkArray[0], 'trsp_agmt_rt_tp_cd');
    var formObj=document.form;
    formObj.chk_agmt_no.value=chk_agmt_no;
    formObj.chk_trsp_agmt_rt_tp_ser_no.value=chk_trsp_agmt_rt_tp_ser_no;
    formObj.chk_trsp_agmt_rt_tp_cd.value=chk_trsp_agmt_rt_tp_cd;
    formObj.eq_knd_cd.value = sheetObject.GetCellValue(checkArray[0], 'eq_knd_cd');
    if(checkArray.length > 0){
        resultcheck=1;
        for(var i=0; i<checkArray.length; i++){
            if(sheetObject.GetCellValue(checkArray[0], 'agmt_no')+ sheetObject.GetCellValue(checkArray[0], 'trsp_agmt_rt_tp_ser_no')
                    == sheetObject.GetCellValue(checkArray[i], 'agmt_no') + sheetObject.GetCellValue(checkArray[i], 'trsp_agmt_rt_tp_ser_no') ){
            }else{
                resultcheck++;
            }
        }
    }
    if(resultcheck == 1){
        var myOption="width=1100,height=670,menubar=0,status=0,scrollbars=0,resizable=1";
        var param="?"+TrsFrmQryString(formObj);
        myWin=window.open('/opuscntr/ESD_TRS_0226.do' + param, "popup", myOption);          
    }else if(resultcheck == 0){
        ComShowCodeMessage('TRS90215');
    }else if(resultcheck > 1){
        ComShowCodeMessage('TRS90357');
    }
}

function openAllScgRateInquiry() {
    var sheetObject=sheetObjects[0];
    var checkList=sheetObject.FindCheckedRow('chk');
    var checkArray=checkList.split('|');
    var resultcheck=0;
    if(checkList.length < 1) {
        ComShowCodeMessage('TRS90215'); 
        return;
    }
    var chk_agmt_no=sheetObject.GetCellValue(checkArray[0], 'agmt_no');
    var chk_trsp_agmt_rt_tp_ser_no=sheetObject.GetCellValue(checkArray[0], 'trsp_agmt_rt_tp_ser_no');
    var chk_trsp_agmt_rt_tp_cd=sheetObject.GetCellValue(checkArray[0], 'trsp_agmt_rt_tp_cd');
    var formObj=document.form;
    formObj.chk_agmt_no.value=chk_agmt_no;
    formObj.chk_trsp_agmt_rt_tp_ser_no.value="";
    formObj.chk_trsp_agmt_rt_tp_cd.value=chk_trsp_agmt_rt_tp_cd;
    formObj.eq_knd_cd.value = sheetObject.GetCellValue(checkArray[0], 'eq_knd_cd');
    if(checkArray.length > 0){
        resultcheck=1;
        for(var i=0; i < checkArray.length; i++){
            if(sheetObject.GetCellValue(checkArray[0], 'agmt_no')+ sheetObject.GetCellValue(checkArray[0], 'trsp_agmt_rt_tp_ser_no')
                    == sheetObject.GetCellValue(checkArray[i], 'agmt_no') + sheetObject.GetCellValue(checkArray[i], 'trsp_agmt_rt_tp_ser_no') ){
            }else{
                resultcheck++;
            }
        }
    }
    if(resultcheck == 1){
        var myOption="width=1200,height=645,menubar=0,status=0,scrollbars=0,resizable=1";
        var param="?"+TrsFrmQryString(formObj);
        myWin=window.open('/opuscntr/ESD_TRS_0229.do' + param, "popup", myOption);          
    }else if(resultcheck == 0){
        ComShowCodeMessage('TRS90215');
    }else if(resultcheck > 1){
        ComShowCodeMessage('TRS90357');
    }
}

function openScgRateInquiry() {
    var sheetObject=sheetObjects[0];
    var checkList=sheetObject.FindCheckedRow('chk');
    var checkArray=checkList.split('|');
    var resultcheck=0;
    if(checkList.length < 1) {
        ComShowCodeMessage('TRS90215'); 
        return;
    }
    var chk_agmt_no=sheetObject.GetCellValue(checkArray[0], 'agmt_no');
    var chk_trsp_agmt_rt_tp_ser_no=sheetObject.GetCellValue(checkArray[0], 'trsp_agmt_rt_tp_ser_no');
    var chk_trsp_agmt_rt_tp_cd=sheetObject.GetCellValue(checkArray[0], 'trsp_agmt_rt_tp_cd');
    var formObj=document.form;
    formObj.chk_agmt_no.value=chk_agmt_no;
    formObj.chk_trsp_agmt_rt_tp_ser_no.value=chk_trsp_agmt_rt_tp_ser_no;
    formObj.chk_trsp_agmt_rt_tp_cd.value=chk_trsp_agmt_rt_tp_cd;
    formObj.eq_knd_cd.value = sheetObject.GetCellValue(checkArray[0], 'eq_knd_cd');
    if(checkArray.length > 0){
        resultcheck=1;
        for(var i=0; i<checkArray.length; i++){
            if(sheetObject.GetCellValue(checkArray[0], 'agmt_no')+ sheetObject.GetCellValue(checkArray[0], 'trsp_agmt_rt_tp_ser_no')
                    == sheetObject.GetCellValue(checkArray[i], 'agmt_no') + sheetObject.GetCellValue(checkArray[i], 'trsp_agmt_rt_tp_ser_no') ){
            }else{
                resultcheck++;
            }
        }
    }
    if(resultcheck == 1){
        var myOption="width=1200,height=645,menubar=0,status=0,scrollbars=0,resizable=1";
        var param="?"+TrsFrmQryString(formObj);
        myWin=window.open('/opuscntr/ESD_TRS_0229.do' + param, "popup", myOption);          
    }else if(resultcheck == 0){
        ComShowCodeMessage('TRS90215');
    }else if(resultcheck > 1){
        ComShowCodeMessage('TRS90357');
    }
}

/**
 * Resizing sheet
 */
function Minimize(nItem) {
    var objs=document.all.item("MiniLayer");
    if( nItem == "1" ) {
        objs.style.display="none";
        sheet0.SetSheetHeight(ComGetSheetHeight(sheet0, 20));
    } else {
        objs.style.display="inline";
        sheet0.SetSheetHeight(ComGetSheetHeight(sheet0, 15));
    }
}

// Agreement No. onKeyup Event
function doSearchEnter() {
    if( event.keyCode == 13 ) {
        if( validateFormSearch() ) {
            var sheetObject=sheetObjects[0];
            var formObject=document.form;
            setgetUpper(formObject.fm_agmtno);
            doActionIBSheet(sheetObject, formObject, IBSEARCH);
        }
    }
}

 /*
  * Calling rep_commodity pop-up
  */
 function rep_OnPopupClick() {
     var formObject=document.form;
     var cmdt_cd_val="";   
     var rep_cmdt_cd_val="";   
     var cmdt_desc_val="";   
     var classId="getCOM_ENS_rep";
     var xx1="";  //CONTI
     var xx2="";  //SUB CONTI
     var xx3="";  //COUNTRY
     var xx4="";  //STATE
     var xx5="";  //CONTROL OFFIC
     var xx6="";  //LOC CODE
     var xx7="";  //LOC NAME
     var xx8="";
     var xx9="";
     var param="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
     ComOpenPopup('/opuscntr/COM_ENS_0C1.do' + param, 772, 515, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');
 }

/**
 * Service Provider popup : The case selecting one item at pop-up page
 */
function getCOM_ENS_rep(rowArray) {
    var formObj=document.form;
    for(var i=0; i<rowArray.length; i++) {
        var colArray=rowArray[0];
        var colArray2=colArray[2];
        var colArray3=colArray[3];
        var colArray4=colArray[4];
        formObj.fm_vndr_prmry_seq.value=colArray2;
        formObj.fm_vndr_prmry_nm.value=colArray4;
    }
}

/**
 * Return from Service Provider popup
 */
function vndr_OnPopupClick() {
    var formObject=document.form;
    var cmdt_cd_val="";   
    var rep_cmdt_cd_val="";   
    var cmdt_desc_val="";   
    var classId="getCOM_ENS_vndr";
    var xx1="";  //CONTI
    var xx2="";  //SUB CONTI
    var xx3="";  //COUNTRY
    var xx4="";  //STATE
    var xx5="";  //CONTROL OFFIC
    var xx6="";  //LOC CODE
    var xx7="";  //LOC NAME
    var xx8="";
    var xx9="";
    var param="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
    ComOpenPopup('/opuscntr/COM_ENS_041.do' + param, 772, 460, 'getCOM_ENS_vndr', '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
 * Return from Customer popup
 */
function getCOM_ENS_vndr(rowArray) {
    var formObject=document.form;
    for(var i=0; i<rowArray.length; i++) {
        var colArray=rowArray[0];
        var colArray2=colArray[2];
        var colArray3=colArray[3];
        document.form.fm_cust_cd.value=colArray3;    
    }
}

/**
*  Container Reset
*/
function reset_all() {
    var formObject=document.form;
    formObject.fm_agmtno.value="";
    formObject.fm_vndr_prmry_seq.value="";
    formObject.fm_vndr_prmry_nm.value="";
    formObject.fm_ctrt_ofc_cd.value="";
    formObject.chk_office.value="";
    formObject.old_ofc_cd.value="";
    formObject.chk_office.value="";
    formObject.fm_trsp_agmt_rt_tp_cd.value="A";
    formObject.fm_effective_agmt.value="A";
    formObject.fm_cust_cd.value="";
    formObject.fm_trsp_cost_mod_cd.value="A";
    formObject.fm_agmt_trsp_tp_cd.value="";
    formObject.fm_cgo_tp_cd.value="";
    formObject.fm_rail_svc_tp_cd.value="";
    formObject.fm_cmdt_grp_cd.value="";
    formObject.fm_trsp_scg_cd.value="A";
    sheet0.RemoveAll();
}

/**
* validation
*/
function validateFormSearch() {
    var formObj=document.form;
    var agmtno=formObj.fm_agmtno.value;
    var vndr_prmry_seq=formObj.fm_vndr_prmry_seq.value;
    var ctrt_ofc_cd=formObj.fm_ctrt_ofc_cd.value;
    var cust_cd=formObj.fm_cust_cd.value;
    var cmdt_grp_cd=formObj.fm_cmdt_grp_cd.value;
    if( agmtno == "" && vndr_prmry_seq == "" && ctrt_ofc_cd == "" && cust_cd == "" && cmdt_grp_cd == "") { 
            errMsg=ComGetMsg("TRS90124");
            ComShowMessage(errMsg);
            formObj.fm_agmtno.focus();
            return false;
    }

    if( agmtno != ""  && agmtno.length < 4 ) { 
        errMsg=ComGetMsg("TRS90066");
        ComShowMessage(errMsg);
        formObj.fm_agmtno.focus();
        return false;
    }    

    if( agmtno != ""  &&  ! ComIsMoneyNumber( agmtno.substring(3) , false, true, true) ) { 
        errMsg=ComGetMsg("TRS90066");
        ComShowMessage(errMsg);
        formObj.fm_agmtno.focus();
        return false;
    }
    
    return true;
}

/*
* Opening Agreement No popup 
*/
function openAgmtNo() {
    var formObject=document.form;
    var Option="width=700,height=420,menubar=0,status=0,scrollbars=0,resizable=1";
    var agmt_no=formObject.fm_agmtno.value;   
    var param="?agmt_no="+agmt_no;
    var sUrl = '/opuscntr/ESD_TRS_0233.do' + param;
    ComOpenPopup(sUrl, 700, 450, "popupAgmtHdrList", "0,0", true);
}

/*
* Getting the Agreement No from Agreement No popup
*/
function getAgmtNo( value, vndr_seq, vndr_nm, agmt_ref_no, row ){
    var formObject=document.form;
    formObject.fm_agmtno.value=value;
}

/**
* Getting S/P info
*/
function  vender_blur(){
    var formObj=document.form;
    var error_val="";
    var lvobj=formObj.fm_vndr_prmry_seq.value;
    if(lvobj !=""){
        for (var i=0; i < lvobj.length; i++) {
            var oneChar=lvobj.charAt(i)
            if (oneChar != "") {
                if (  (oneChar >= "0" && oneChar <= "9" )  ) {
                } else {
                    error_val="Y";
                    break;
                }
            }
        }
    }
    if(error_val =="Y" ){
    	formObj.fm_vndr_prmry_seq.value = "";
        return;
    }
    sheet0.RemoveEtcData();
    formObj.f_cmd.value=SEARCH07;
    var sXml =sheetObjects[0].GetSearchData( "ESD_TRS_0220GS.do",TrsFrmQryString(formObj) );
    x1=ComGetEtcData(sXml,'VNDR_NM');
    if(x1 !="" && x1 != undefined){ //
        formObj.fm_vndr_prmry_nm.value=x1;
    }else{
        formObj.fm_vndr_prmry_nm.value="";
    }
}

function sheet0_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    ComOpenWait(false);
}
