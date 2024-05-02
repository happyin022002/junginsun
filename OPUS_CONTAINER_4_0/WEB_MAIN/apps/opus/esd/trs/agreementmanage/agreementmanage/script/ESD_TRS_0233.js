/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0233.js
*@FileTitle  : Agreement Header Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/27
=========================================================*/
/**
 * Define the initial values and headers of sheets
 * European S/O
 */
function initSheet(sheetObj, sheetNo)
{
    var sheetObject=sheetObjects[0]; 
    var cnt=0;
    switch(sheetNo) {
        case 1: //sheet0 init ( Child S/P )
            with(sheetObj)
            {
                var HeadTitle1="Chk.|S/P SEQ|S/P NAME|AGMT NO|Reference No|Contract Office|Remark" ;

                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"CheckBox", Hidden:0, Width:30,  Align:"Center", ColMerge:1, SaveName:"check",       KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",     Hidden:0, Width:60,  Align:"Center", ColMerge:1, SaveName:"vndr_seq",    KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
                             {Type:"Text",     Hidden:0, Width:140, Align:"Left",   ColMerge:1, SaveName:"vndr_nm",     KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0,   InsertEdit:0,   EditLen:200 },
                             {Type:"Text",     Hidden:0, Width:70,  Align:"Center", ColMerge:1, SaveName:"agmt_no",     KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
                             {Type:"Text",     Hidden:0, Width:100, Align:"Left",   ColMerge:1, SaveName:"agmt_ref_no", KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0,   InsertEdit:0,   EditLen:200 },
                             {Type:"Text",     Hidden:0, Width:100, Align:"Center", ColMerge:1, SaveName:"ctrt_ofc_cd", KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0,   InsertEdit:0,   EditLen:200 },
                             {Type:"Text",     Hidden:0, Width:140, Align:"Left",   ColMerge:1, SaveName:"inter_rmk",   KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0,   InsertEdit:0,   EditLen:200 } ];

                InitColumns(cols);
                SetWaitImageVisible(0);
                SetEditable(1);
                SetSheetHeight(240);
            }
    break;
    }
}

/**
* Setting sheets and initialization 
* Implementing the onLoad event handler of body tag
* Adding the preceding function after loading page
*/
function loadPage()
{
    for(var i=0;i<sheetObjects.length;i++)
    {
        ComConfigSheet(sheetObjects[i] ); 
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]); 
    }

    var sheetObject=sheetObjects[0];

    var formObject=document.form;
    
//    doActionIBSheet(sheetObject,formObject,IBSEARCH);    
}

/*------------------ Defining general java script function   ------------------*/

/* General global variable */
var sheetObjects=new Array();
var sheetCnt=0;

document.onclick=processButtonClick;

/* Branch processing event handler with the name of button */
function processButtonClick()
{
    var sheetObject=sheetObjects[0];
    /*******************************************************/
    var formObject=document.form;
   try {
       var opener=window.dialogArguments;
       if (!opener) opener = parent;
       var srcName=ComGetEvent("name");
       switch(srcName) {
            case "btng_retrieve":
                if( validateFormSearch() )
                {
                    doActionIBSheet(sheetObject,formObject,IBSEARCH);    
                }
            break;
            case "btng_ok":                
                if( validateForm(sheetObject, formObject) ) {
                    var checkList=sheetObject.FindCheckedRow('check');
                    var checkArray=checkList.split('|');
                    var opener=window.dialogArguments;
                    if (!opener) {
                        opener=window.parent;
                    }
                    if (!opener) opener=window.opener;
                    opener.getAgmtNo(sheetObject.GetCellValue(checkArray[0], 'agmt_no'),
                                     sheetObject.GetCellValue(checkArray[0], 'vndr_seq'),
                                     sheetObject.GetCellValue(checkArray[0], 'vndr_nm'),
                                     sheetObject.GetCellValue(checkArray[0], 'agmt_ref_no'),
                                     formObject.mainRow.value
                                     );
                    ComClosePopup(); 
                }
            break;
            case "btng_close":
                ComClosePopup(); 
                break;
            break;
            case "btn_provider":
                rep_OnPopupClick();
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

function doActionIBSheet(sheetObj,formObj,sAction)
{
    sheetObj.ShowDebugMsg(false);
    var formObject=document.form;
    switch(sAction)
    {       
       case IBSEARCH:
            ComOpenWait(true);
            formObj.f_cmd.value=SEARCH01;
            sheetObj.DoSearch("ESD_TRS_0233GS.do", TrsFrmQryString(formObj) );
        break;
    }
}

function doSearchEnter()
{
    if( event.keyCode == 13 )
    {
        if( validateFormSearch() )
        {
            var sheetObject=sheetObjects[0];
            var formObject=document.form;
            doActionIBSheet(sheetObject, formObject, IBSEARCH, "", "");
        }
    }
}

/**
 * Register IBSheet Object with array
 * call from comSheetObject(id)
 */
function setSheetObject(sheet_obj)
{
    sheetObjects[sheetCnt++]=sheet_obj;
}

/**
 * Getting S/P info
 */
/**
 * S/P Code Change Event시 호출
 * TRS 공통(getTextVendorSeq)으로 교체하여 주석처리함.
function getVendorSeq(sheetObj, formObj, vndr_seq){
    formObj.f_cmd.value=SEARCH11;
    formObj.combo_svc_provider.value=get_only_num(vndr_seq);
    sheetObj.RemoveEtcData();
    sheetObj.DoRowSearch( ROW,TrsFrmQryString(formObj) );
    var vendorNoList=sheetObj.GetEtcData('vndr_no');
    var vendorNmList=sheetObj.GetEtcData('vndr_nm_eng');
    if (vendorNoList == undefined || vendorNoList == ''){
        formObj.combo_svc_provider.value='';
        formObj.svc_provider.value='';
        return false;
    }
    formObj.combo_svc_provider.value=lpad(vendorNoList, 6, '0') ;
    formObj.svc_provider.value=vendorNmList;
    return true;
}
*/

/**
 * validation
 */
function validateForm(sheetObj, formObj)
{
    if( sheetObj.CheckedRows("check") < 1 )
    {
        errMsg=ComGetMsg("TRS90036");
        ComShowMessage(errMsg);
        return false;
    }
    if( sheetObj.CheckedRows("check") > 1 )
    {
        errMsg=ComGetMsg("COM12177" );
        ComShowMessage(errMsg);
        return false;
    }
    return true;
}

/**
* Lookups required validation
*/
function validateFormSearch()
{
    var formObj=document.form;
    var agmtno=formObj.agmt_no.value;

    if( agmtno != ""  && agmtno.length < 4 )
    { 
        errMsg=ComGetMsg("TRS90066");
        ComShowMessage(errMsg);
        formObj.agmt_no.focus();
        return false;
    }    

    if( agmtno != ""  &&  ! ComIsMoneyNumber( agmtno.substring(3) , false, true, true) )
    { 
        errMsg=ComGetMsg("TRS90066");
        ComShowMessage(errMsg);
        formObj.agmt_no.focus();
        return false;
    }

    return true;
}

/**
 * Calling rep_commodity pop-up
 */
function rep_OnPopupClick()
{
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
    ComOpenPopup('/opuscntr/COM_ENS_0C1.do' + param, 699, 515, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1',false);
}

/**
 * Calling rep_commodity pop-up : The case selecting one item at pop-up page
 */
function getCOM_ENS_rep(rowArray)
{
    var formObj=document.form;
    for(var i=0; i<rowArray.length; i++) 
    {
        var colArray=rowArray[0];
        var colArray2=colArray[2];
        var colArray3=colArray[3];
        var colArray4=colArray[4];
        formObj.combo_svc_provider.value=colArray2;
        formObj.svc_provider.value=colArray4;
    }
}

function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg)
{ 
    ComOpenWait(false);
}
