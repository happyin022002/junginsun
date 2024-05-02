/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0122.js
*@FileTitle  : Bottleneck Input
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/18
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                     COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @fileoverview 
 * @author 
 */
/**
 * @extends 
 * @class ESD_SCE_0122 :  business script for ESD_SCE_0122
 */
var sheetObjects=new Array();
var sheetCnt=0;
var prefix="sheet1_";
var btnEnable="X";  
// Event handler processing by button click event */
document.onclick=processButtonClick;
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
    initControl();
}
/*
* {@link #loadPage. <br>
* @param {ibsheet} sheetObj    IBSheet Object
* @param {int}     sheetNo     sheetObjects 
*/
function initControl() {
    //** Date 구분자 **/
    DATE_SEPARATOR="/";
    var formObj=document.form; 
    axon_event.addListenerForm  ('keypress', 'fnObjKeyPress',  formObj );
    axon_event.addListenerFormat('change',  'obj_change',   formObj); //- 변경될때
}
/**
 * <pre>
 *   
 * </pre>
 * @return
 */ 
function fnObjKeyPress(){
    var obj=ComGetEvent();
    var formObj=document.form;
    var attr=obj.getAttribute("dataformat");
    switch (attr){
        case  '':
            break;
        case  'ymd':
            ComKeyOnlyNumber( obj );
            break;
        case  'engup':
            ComKeyOnlyAlphabet( 'upper' );
            break;     
        case  'engupnum':
            ComKeyOnlyAlphabet( 'uppernum' );
            break;   
    }
}
// Event handler processing by button name */
function processButtonClick() {
    var sheetObject1=sheetObjects[0];
    /*******************************************************/
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        switch (srcName) { 
        case "btn_retrieve":
            if(btnEnable == "S"){
                doActionIBSheet(sheetObject1, formObject, IBSEARCH);
            }else if(btnEnable == "X"){
            	ComShowCodeMessage("SCE02002");
            }
            break;
        case "btn_new":
            if(btnEnable == "S"){
                sheetObject1.RemoveAll();
                formObject.cust_trd_prnr_id.value="";
                formObject.partnerName.value="";
            }
            //formObject.cust_trd_prnr_id.focus();
            break;
        case "btn_save":
            if(btnEnable == "S"){
                doActionIBSheet(sheetObject1, formObject, IBSAVE);
            }
            break;
        case "btn_downExcel":
            if(btnEnable == "S"){
                if(sheetObject1.RowCount() < 1){//no data
                    ComShowCodeMessage("COM132501");
                }else{
                    sheetObject1.Down2Excel();
                }
            }
            break;
        case "btn_RowAdd":
            if(btnEnable == "S"){
                doRowAdd(sheetObject1, formObject);
            }
            break;
        case "btn_RowDelete":
            if(btnEnable == "S"){
                ComRowHideDelete(sheetObject1,prefix+"del_chk");
            }
        break;
        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            ComShowCodeMessage('JOO00001');
        } else {
            ComShowMessage(e);
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
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo, rlaneSheetList) {
    var cnt=0;
    switch (sheetNo) {
    case 1: 
        with(sheetObj){
          var HeadTitle="STS|Del.|SEQ|Lane|Lane Name|rout_rcv_dt|rout_seq|cust_trd_prnr_id";

          SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

          var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
          var headers = [ { Text:HeadTitle, Align:"Center"} ];
          InitHeaders(headers, info);

          var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_chk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Seq",       Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"Seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"PopupEdit", Hidden:0, Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"vsl_slan_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
                 {Type:"Text",      Hidden:0,  Width:320,  Align:"Left",    ColMerge:0,   SaveName:prefix+"vsl_slan_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:140,  Align:"Center",  ColMerge:0,   SaveName:prefix+"rout_rcv_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:1, Width:140,  Align:"Center",  ColMerge:0,   SaveName:prefix+"rout_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:1, Width:140,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cust_trd_prnr_id", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
           
          InitColumns(cols);

          SetEditable(1);
          SetColProperty(prefix+"rout_rcv_dt", {Format:"####-##-##"} );
//        SetSheetHeight(382);
          resizeSheet();
        }


        break;
    }
}
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
    switch (sAction) { 
    case IBSEARCH: //조회
        if (validateForm(sheetObj, formObj, sAction)){
            formObj.f_cmd.value=SEARCH;
            sheetObj.DoSearch("ESD_SCE_0122GS.do", SceFrmQryString(formObj) + "&" + ComGetPrefixParam(prefix) );
        }
    break;
    case IBSAVE: //Save
        if (validateForm(sheetObj, formObj, sAction)){ 
            //var sName = sheetObj.ColSaveName(Col);
            var SaveStr=ComGetSaveString(sheetObj);
            if (SaveStr == ""){
                ComShowCodeMessage("SCE01222");
                return;
            }
            formObj.f_cmd.value=MULTI;
            var aryPrefix=new Array("sheet1_"); 
            var sXml=sheetObj.GetSaveData("ESD_SCE_0122GS.do", SaveStr + "&" + SceFrmQryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
            sheetObj.LoadSearchData(sXml,{Sync:1} );
            doActionIBSheet(sheetObj,formObj,IBSEARCH);
        }
    break;
    }
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: 
            if (formObj.cust_trd_prnr_id.value.length < 1){
                ComShowMessage(ComGetMsg('SCE01221', "TP_ID"));
                return false;
            }
        break;
        case IBSAVE:   
            //
        break;
        case SEARCH01: 
            //
        break;
    }
    return true;
}
function obj_change(){
    var obj=ComGetEvent();
    var formObj=document.form;
    var sheetObj=sheetObjects[0];
    if ( ComTrim(ComGetEvent("value")) != "" ) {
        switch(ComGetEvent("name")) {
            case "cust_trd_prnr_id":
                form.f_cmd.value=SEARCH01;
                sheetObjects[0].SetWaitImageVisible(0);
                var formObj=document.form;
                var sXml=sheetObj.GetSearchData("ESD_SCE_0122GS.do" , SceFrmQryString(form));
                if(document.form.cust_trd_prnr_id.value == "" ){
                       //showErrMessage(getMsg("COM12114" ,"TP ID",'',''));
                       return false;
                }
                //텍스트 가져오기[partnerName]
                var partnerName=ComGetEtcData(sXml,"partnerName") == "" ? "" : ComGetEtcData(sXml,"partnerName");
                var ediSvcTpNm=ComGetEtcData(sXml,"ediSvcTpNm");
                formObj.partnerName.value=partnerName;
                if(ediSvcTpNm.substring(0,4) == "LANE"){    
                    doActionBtnEnable('S');
                }else{  
                    doActionBtnEnable('X');
                }
                break;
        }
    } else {
        switch(ComGetEvent("name")) {
            case "cust_trd_prnr_id":
                formObj.vndr_nm.value="";
                break;
        }
    }
}
/**
 * registering IBTab Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
function setTabObject(tab_obj){
    tabObjects[tabCnt++]=tab_obj;
}
function checkNumber(sValue){
  try{
    var value=sValue.search(/^\d*(\.?\d*)$/gi);
    if(value !=-1){
        return true;
    }else{
        return false;
    }
  }catch(errorObject){
    showErrorDig("checkNumber()", errorObject);
  }
}
function ComGetDateAdd2(sDate, sFlag, iVal, sDelim){
    try {
        if (sDelim==null || sDelim==undefined) sDelim="-";
        if (sDate==null || sDate==undefined) {
            sDate=new Date();
        } else {
            sDate=getArgValue(sDate); 
        }
        var yy=eval(sDate); 
        iVal=ComParseInt(iVal); 
        switch(sFlag.toLowerCase()) {
            case "y":   yy += eval(iVal);    break;
        }
        return yy ;
    } catch(err) { ComFuncErrMsg(err.message); }
}
/**
* @param sheetObj
* @param row
* @param col
* @return
*/
function sheet1_OnChange(sheetObj, row, col, value) { 
     switch (sheetObj.ColSaveName(col)) {
        case prefix+"vsl_slan_cd":
            var dup=0;
            if(value == ""){
                return;
            }
            sheetObj.SetCellValue(row,col,value.toUpperCase(),0);
            
            for(var i=0; i<sheetObj.RowCount(); i++) {
                if(sheetObj.GetCellValue(i + 1, prefix+"vsl_slan_cd") == value) {
                    dup++;
                }
                if(dup > 1){
                    ComShowMessage(value + " is already added");
                    sheetObj.SetCellValue(i + 1, prefix+"vsl_slan_cd","");
                    return;
                }
            }
        break; 
     }
  // 그리드 입력시 대문자로변환
          
 }
/**
 * @param sheetObj
 * @param formObj
 * @return
 */
function doRowAdd(sheetObj, formObj){
    var iRow=sheetObj.DataInsert(-1);
    sheetObj.SetCellValue(iRow,  sheetObj.SaveNameCol(prefix+"rout_rcv_dt"),formObj.yyyyMM.value,0);
    sheetObj.SetCellValue(iRow,  sheetObj.SaveNameCol(prefix+"cust_trd_prnr_id"),formObj.cust_trd_prnr_id.value,0);
}
/**
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet1_OnPopupClick(sheetObj, Row, Col){
//    var formObj=document.form;
//    var sUrl="/opuscntr/VOP_VSK_0202.do";
//    ComOpenPopupWithTarget(sUrl, 428, 430, "sheet1_vsl_slan_cd:tmp_vsl_slan_cd|sheet1_vsl_slan_nm:tmp_vsl_slan_nm", "0,0", true);
//    
	var formObj=document.form;
	var sUrl="/opuscntr/VOP_VSK_0202.do";
	ComOpenPopup(sUrl, 600, 500, "pickLaneCallBack", "0,0", true);
	
	
    //ComOpenPopupWithTarget(sUrl, 428, 430, "sheet1_vsl_slan_cd:tmp_vsl_slan_cd", "0,0", true);
//    if(formObj.tmp_vsl_slan_cd.value != ""){
//        sheetObj.SetCellValue(Row, Col,formObj.tmp_vsl_slan_cd.value);
//        sheetObj.SetCellValue(Row, Col+1,formObj.tmp_vsl_slan_nm.value);
//        if(sheetObj.GetCellValue(Row, Col) == ""){
//            sheetObj.SetCellValue(Row, Col+1,"");
//        }
//    }
}

function pickLaneCallBack(rtnVal) {
	var curRow = sheetObjects[0].GetSelectRow();
	if(rtnVal.length==0){
	}else{
		var arrData = rtnVal+"";
		var tempData = arrData.split(",")
		sheetObjects[0].SetCellValue(curRow, 'sheet1_vsl_slan_cd', tempData[1]);
		sheetObjects[0].SetCellValue(curRow, 'sheet1_vsl_slan_nm', tempData[2]);
		
	}
}


/**
 * @param  invStatus String
 * @param  statusCd String
 * @return 
 * @author 
 * @version
 */ 
function doActionBtnEnable (invStatus){
    if(invStatus == 'S'){
        //ComBtnEnable("btn_save");
        //ComBtnEnable("btn_RowAdd");
        //ComBtnEnable("btn_RowDelete");
        //ComBtnEnable("btn_new");
        //ComBtnEnable("btn_retrieve");
        btnEnable="S";
    } else {
        //ComBtnDisable("btn_save");
        //ComBtnDisable("btn_RowAdd");
        //ComBtnDisable("btn_RowDelete");
        //ComBtnDisable("btn_new");
        //ComBtnDisable("btn_retrieve");
        btnEnable="X";
        sheetObjects[0].RemoveAll();
        //document.form.cust_trd_prnr_id.focus();
    }
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
} 

