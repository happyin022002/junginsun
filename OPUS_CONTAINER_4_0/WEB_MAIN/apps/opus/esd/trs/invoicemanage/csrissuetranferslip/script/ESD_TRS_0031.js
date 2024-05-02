/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0031.js
*@FileTitle  : Terminal invoice CSR Creation - Summary
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/29
=========================================================*/
var sheetObjects=new Array();
var sheetCnt=0;
document.onclick=processButtonClick;
function processButtonClick(){
    var sheetObject=sheetObjects[0];
    /*******************************************************/
    var formObject=document.form;
    var formObject1=document.form1;
    try {
        var srcName=ComGetEvent("name");
        switch(srcName) {
		    case "btn_retrieve":
		        if (!checkCntCd(cnt_cd))  return;
		        doActionIBSheet(sheetObject,formObject,IBSEARCH);
		        break;
		    case "btn_new":
		        sheetObject.RemoveAll();
		        formObject.reset();
		        break;
		    case "btng_provider":          
		        rep_OnPopupClick();
		        break;       
		    case "btng_detail":
		    	var v_selectRow = sheetObjects[0].GetSelectRow();
		        if( v_selectRow < 0){
		            errMsg=ComGetMsg("TRS90036" );
		            ComShowMessage(errMsg);
		            return false;   
		        }
		        formObject1.vndr_seq.value=sheetObjects[0].GetCellValue(v_selectRow, "vndr_no");
		        formObject1.vndr_seq_name.value=sheetObjects[0].GetCellValue(v_selectRow, "vndr_seq_name");
		        formObject1.curr_cd.value=sheetObjects[0].GetCellValue(v_selectRow, "curr_cd");
		        formObject1.gen_pay_term_cd.value=sheetObjects[0].GetCellValue(v_selectRow, "gen_pay_term_cd");
		        formObject1.pay_term_tp_cd.value=sheetObjects[0].GetCellValue(v_selectRow, "pay_term_tp_cd");
		        formObject1.payment_due_dt.value=sheetObjects[0].GetCellValue(v_selectRow, "payment_due_dt");
		        formObject1.asanogb.value=getElementValue(formObject, 'radio', 'asanogb');
		        formObject1.cost_office_cd.value=sheetObjects[0].GetCellValue(v_selectRow, "so_ofc_cd");
		        formObject1.conti_cd.value=sheetObjects[0].GetCellValue(v_selectRow, "conti_cd");
		        formObject1.form_inv_cfm_dt.value=formObject.inv_cfm_dt.value;
		        formObject1.pgmNo.value="ESD_TRS_0032"; 
		        /** Only 'SZPBB' + 'CANBS' */
		        formObject1.paymenttype.value=getElementValue(formObject, 'radio', 'paymenttype'); 
		        ComPostOpenWindow("about:blank", "noRtnPopup", "width=1060,height=470,menubar=0,status=0,scrollbars=0,resizable=0");
		        formObject1.action= "ESD_TRS_0032.do"
		        formObject1.target='noRtnPopup';
		        formObject1.submit();
		      break;
		    case "btns_calendar1":
		            var cal=new ComCalendar();
		            cal.select(formObject.inv_cfm_dt, 'yyyy-MM-dd');
		            break;
        } 
    }catch(e) {
        if( e == "[object Error]") {
            errMsg=ComGetMsg("TRS90392" );
            ComShowMessage(errMsg);
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
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
        doActionIBSheet2(sheetObjects[1] , document.form , IBSEARCH);
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
/**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
*/
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetNo) {
        case 1:  
            with(sheetObj){
                var HeadTitle="Seq.|Cost Office|S/P Code|S/P Name|No of Invoice|Invoice Currency|Total Amount" ;
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:1, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                var cols = [{Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"so_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vndr_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"vndr_seq_name",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cnt_inv",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"curr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"total_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:0,   SaveName:"gen_pay_term_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:0,   SaveName:"pay_term_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:0,   SaveName:"payment_due_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:0,   SaveName:"conti_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                                           
                InitColumns(cols);
                SetEditable(0);
                ComResizeSheet(sheetObj);
            }
            break;
        case 2:      //hidden sheet
            with(sheetObj){
                var HeadTitle1="Del.|STS|Liv" ;
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);
                var cols = [{Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0 },
                            {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
                            {Type:"Popup",     Hidden:0, Width:40,   Align:"Left",    ColMerge:1,   SaveName:"vndr_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:100 } ];
                                                               
                InitColumns(cols);
                SetEditable(1);
                SetVisible(0);
            }
        break;
    }
}
/*
* handling of Sheet 
*/
function doActionIBSheet(sheetObj,formObj,sAction) {
    switch(sAction) {
       case IBSEARCH:      
            formObj.f_cmd.value=SEARCHLIST;                  
            sheetObj.DoSearch("ESD_TRS_0031GS.do", TrsFrmQryString(formObj) );
            break;
        }
    }
/*
* handling of Sheet 
*/
function doActionIBSheet2(sheetObj,formObj,sAction) {
    switch(sAction) {
        case IBSEARCH:     
            formObj.f_cmd.value=SEARCH01;                  
            sheetObj.DoSearch("ESD_TRS_0031GS.do", TrsFrmQryString(formObj) );
        break;
    }
}   

function sheet2_OnSearchEnd(sheetObj , ErrMsg) {
    if ( ErrMsg != "") return;
    var asaFlag=sheetObj.GetEtcData("asaFlag");
    var cost_ofc_cd=document.form.cost_ofc_cd.value;
    cost_ofc_cd = cost_ofc_cd != undefined && cost_ofc_cd != null ? cost_ofc_cd : '';
//    if (asaFlag == "O") { //  O : "Open"
//        if (cost_ofc_cd == 'SZPBB' || cost_ofc_cd == 'CANBS') {
//            document.form.asanogb[0].disabled=false;
//            document.form.asanogb[1].disabled=false;  
//        } else {
//            document.form.asanogb[0].disabled=true;
//            document.form.asanogb[1].disabled=false;
//        }
//        document.form.asanogb[1].checked=true;    //JSK 2007-07-25
//    } else {
//        document.form.asanogb[0].disabled=false;        
//        document.form.asanogb[1].disabled=true;
//        document.form.asanogb[0].checked=true;    //JSK 2007-07-25
//    }        
    if (cost_ofc_cd == 'SZPBB' || cost_ofc_cd == 'CANBS') {
        document.form.asanogb[0].disabled=false;
        document.form.asanogb[1].disabled=true;  
        document.form.asanogb[0].checked=true; 
    } else {
    	if (asaFlag == "O") {
    		 document.form.asanogb[0].disabled=true;
             document.form.asanogb[1].disabled=false;
             document.form.asanogb[1].checked=true; 
    	} else {
    		 document.form.asanogb[0].disabled=false;        
    		 document.form.asanogb[1].disabled=true;
    	     document.form.asanogb[0].checked=true; 
    	}
    }
}
/**
 * validateForm
 */
function validateForm(sheetObj, formObj, sAction){
    with(formObj){
    }
    return true;
}
function isNum(obj){
    if (!ComIsNumber(obj)){
        obj.value='';
    }
}
function isNum1(obj){
    if (!isNumDash(obj)){
        obj.value='';
    }
}       
function isDate1(obj){
    if (!ComIsDate(obj)){
        obj.value='';
            }
        }                   
function getVender(rowArray) {  
    var colArray=rowArray[0];
    document.form.vndr_seq.value=colArray[2];
    document.form.vndr_seq_name.value=colArray[4];
}       
function getElementCnt(formObject, eleTp, eleNm) {
    var cnt=0;
    var element;
    var numOfEle=formObject.elements.length;
    for (var i=0; i < numOfEle; i++){
        if (formObject.elements[i].type == eleTp && formObject.elements[i].name == eleNm){
            cnt++;
        }
    }
    return cnt;
}
function getElementValue(formObject, eleTp, eleNm) {
    var element;
    var numOfEle=formObject.elements.length;
    for (var i=0; i < numOfEle; i++){
        if (formObject.elements[i].type == eleTp && formObject.elements[i].name == eleNm){
            if (formObject.elements[i].checked == true){ 
                var ele_value=formObject.elements[i].value;
                break;
            }           
        }
    }
    return ele_value;
}    
function checkCntCd(cnt_cd){
    if(cnt_cd==""){
        errMsg=ComGetMsg("TRS90112" );
        ComShowMessage(errMsg);     
        return false;   
    }
    return true;
}           
/**
 * Service Provider PopUp
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
    ComOpenPopup('/opuscntr/COM_ENS_0C1.do' + param, 650, 520, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');
}   
/**
 * getCOM_ENS_rep
 */
function getCOM_ENS_rep(rowArray) {
    var formObj=document.form;
    for(var i=0; i<rowArray.length; i++)
    {
        var colArray=rowArray[0];
        var colArray2=colArray[2];
        var colArray3=colArray[4];
        formObj.combo_svc_provider.value=colArray2;
        formObj.svc_provider.value=colArray3;
    }
}
/**
 * enter check
 **/
function enterCheck(obj)
{   
    var sheetObj=sheetObjects[0];
    var formObj=document.form;
    if(ComGetEvent("keycode") == 13)
    {
        switch(ComGetEvent("name")){
            case 'combo_svc_provider':
                getTextVendorSeq(sheetObj, formObj, obj.value);
                break;          
        }
    }
}  