/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_3303.js
*@FileTitle  : Actual Activity Mapping
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
                    [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
                    character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------The following code is added to make a good JSDoc ------------------*/
/**
 * @fileoverview JavaScript is commonly used in business as a calendar-related functions have been defined.
 */
/**
 * @extends 
 * @class ESD_SCE_3303 : ESD_SCE_3303 business script.
 */
// global variable
var sheetObjects=new Array();
var sheetCnt=0;
var delCheckCnt;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick(){
     /***** using extra sheet valuable if there are more 2 sheets *****/
     var sheetObject=sheetObjects[0];
     /*******************************************************/
     var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        switch(srcName) {
        case "btn_retrieve":
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
            break;
        case "btn_RowAdd":
            addRow(formObject);
            break;
        case "btn_RowDel":
        	delCheckCnt=0;
        	for(i=1; i<sheetObject.RowCount()+1; i++){
        		if(sheetObject.GetCellValue(i,"ibflag")!="D" && sheetObject.GetCellValue(i,"check")==1){
        			delCheckCnt++;
        		}
        	}
            if(delCheckCnt=='0' ){
                ComShowCodeMessage('COM12176');
                return false;
            } 
            deleteRow();
            sheetObject.CheckAll('check',0,1);
            break;
        case "btn_save":
            doActionIBSheet(sheetObjects[0],document.form,MULTI);
            break;
        case "btn_exceldown":
            if(sheetObjects[0].RowCount() < 1){//no data
                ComShowCodeMessage("COM132501");
            }else{
                doActionIBSheet(sheetObjects[0],document.form,"btn_exceldown","","");
            }
            break;
        case "btn_excelup":
            sheetObject.RemoveAll();
            sheetObject.LoadExcel({ Mode:"HeaderMatch"});
            break;
        } // end switch
    }catch(e) {
        if( e == "[object Error]") {
            ComShowCodeMessage(OBJECT_ERROR);
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
    axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
    axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
    axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    axon_event.addListenerForm('change', 'obj_change', document.form); // change
    axon_event.addListenerForm('click', 'obj_click', document.form); // click
//      initPage();
    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 }
 function initControl() {
     var formObj=document.form;
     axon_event.addListenerForm     ('focus'    , 'obj_focus'       , formObj);
     axon_event.addListenerFormat   ('keypress' , 'obj_keypress'    , form);
     axon_event.addListenerFormat   ('keyup'    , 'obj_change'      , form);
 }
 function obj_focus() {
    if(ComGetEvent("options")){
        event.srcElement.focus();
    }else{
        event.srcElement.select();
    }
}
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetNo) {
        case 1:      // sheet1 init
            with(sheetObj){
                var HeadTitle="|Sel.|Seq|Act Code|COP Dtl Grp Cd|Act Grp Seq";
                var headCount=ComCountHeadTitle(HeadTitle);
                
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                 {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"check" },
                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
                 {Type:"PopupEdit", Hidden:0, Width:125,  Align:"Center",  ColMerge:1,   SaveName:"act_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6 },
                 {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:1,   SaveName:"cop_dtl_grp_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6 },
                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"act_grp_seq",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 } ];
           
                InitColumns(cols);
                
                SetEditable(1);
                SetWaitImageVisible(0);
                SetColProperty(0 ,"act_cd"         , {AcceptKeys:"E"     , InputCaseSensitive:1});
                SetColProperty(0 ,"cop_dtl_grp_cd" , {AcceptKeys:"E"     , InputCaseSensitive:1});
                SetColProperty(0 ,"mphn_no"        , {AcceptKeys:"N"});
                SetAutoRowHeight(0);
                SetDataRowHeight(22);
//              SetSheetHeight(440);
                resizeSheet(); 
            }
            break;
    }
}
/**
* initial init
* @return
*/
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
       case IBSEARCH:
           //2013505 박은정 수정된 데이타 있을 경우 무시하고 리트리브 진행할것인지 물어봄 
           if(sheetObj.IsDataModified()== true){
               if(!ComShowConfirm("There are changed data. Do you still want to retrieve?")){
                   return false;
               }
           }
           //
            ComOpenWait(true);
            formObj.f_cmd.value=SEARCH;
            var sParam=FormQueryString(formObj);
            sheetObj.DoSearch("ESD_SCE_3303GS.do",sParam );
            ComOpenWait(false);
            break;
        case COMMAND01:      //Act_cd Check 
                  formObj.f_cmd.value=COMMAND01;
                  var sXml=sheetObj.GetSaveData("ESD_SCE_3303GS.do", FormQueryString(formObj));
                  var valResult=ComGetEtcData(sXml, "knt");
                  if(valResult == '0'){
                      var Msg=formObj.chk_act_cd.value;
                      ComShowCodeMessage('SCE01221', Msg);
                      sheetObj.SetCellValue(sheetObj.GetSelectRow(), "act_cd",'',0);
                  }
                break;
        case COMMAND02:      //Act_cd Check 
                formObj.f_cmd.value=COMMAND02;
                var sXml=sheetObj.GetSaveData("ESD_SCE_3303GS.do", FormQueryString(formObj));
                var valResult=ComGetEtcData(sXml, "knt2");
                if(valResult == '0'){
                    var Msg=formObj.chk_act_cd.value;
                    ComShowCodeMessage('SCE01221', Msg);
                    sheetObj.SetCellValue(sheetObj.GetSelectRow(), "cop_dtl_grp_cd",'',0);
                }
        break;
        case COMMAND03:      //Primary Key Check 
            formObj.f_cmd.value=COMMAND03;
            var sXml=sheetObj.GetSaveData("ESD_SCE_3303GS.do", FormQueryString(formObj));
            var valResult=ComGetEtcData(sXml, "chk");
    //          alert(valResult);
            if(valResult != '0'){
              var Msg="Act Code and COP Dtl Grp Cd";
              ComShowCodeMessage('SCE01221', Msg);
              sheetObj.SetCellValue(sheetObj.GetSelectRow(), "act_cd",'',0);
              sheetObj.SetCellValue(sheetObj.GetSelectRow(), "cop_dtl_grp_cd",'',0);
            }
        break;
       case MULTI: // Save
           //중복 데이터 체크 함 
           if(checkDuple()!=""){
               return false;
           }
           formObj.f_cmd.value=MULTI;
           var cnt=sheetObjects[0].DoSave("ESD_SCE_3303GS.do", FormQueryString(formObj));
           if (cnt > 0){
                formObj.f_cmd.value=SEARCH;
                sheetObj.DoSearch("ESD_SCE_3303GS.do",FormQueryString(formObj) );
            }
            ComOpenWait(false, false);
            break;
       case "btn_exceldown":
           sheetObj.Down2Excel({ HiddenColumn:1});
            break;
    }
}

function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
    ComOpenWait(false);
}

function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) {
    ComOpenWait(false, false);
    if(Code == 0){
        ComShowCodeMessage("COM132601");
    }
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
     var sheet1RowCnt=sheetObj.RowCount();
    switch(sAction) {
        case IBSEARCH: { // retrieve
            break;
        }
        case MULTI : {
            if (!ComChkValid(formObj)) return false;
            for(var i=1; i <= sheet1RowCnt; i++) {
                if(sheetObj.GetCellValue(i,"act_cd")=="" || sheetObj.GetCellValue(i,"cop_dtl_grp_cd")=="" || sheetObj.GetCellValue(i,"act_grp_seq")==""){
                    var Msg="Actual Code or COP Dtl Grp Cd or Act Grp Seq.";
                    ComShowCodeMessage('SCE01221',  Msg);
                    return false;
                }
            }
            break;
        }
    } // end switch()
    return true;
}
/**
 * KeyUp Event Handling
 */
function obj_KeyUp() {
    var formObject=document.form;
    var srcName=ComGetEvent("name");
    var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
    var srcValue=window.event.srcElement.getAttribute("value");
}
 /**
  * Add row Event Handling
  */ 
function addRow(formObj) {
    with (sheetObjects[0]) {
        var nowRow=GetSelectRow();
        nowRow=DataInsert(-1);
        //SetCellValue(nowRow, "cnt_cd",formObj.frm_cnt_cd.value,0);
//          RowBackColor(nowRow) = "#FFCCFF";
       return true;
   }
}
/**
 * Row Delete Event Handling
 */  
function deleteRow() {
    with (sheetObjects[0]) {
        var sRowStr=FindCheckedRow("check");
        var arr=sRowStr.split("|");
        for (var i=0; i<arr.length; i++) {
            SetRowStatus(arr[i],"D");
            SetRowHidden(arr[i],"1");
        }
    }         
}
/*
 * KeyPress Event Handling
 */
function obj_KeyPress(){
    var keyValue=ComGetEvent("keyCode") ? ComGetEvent("keyCode") : ComGetEvent("which") ? ComGetEvent("which") : ComGetEvent("charCode");
    var srcName=ComGetEvent("name");
    var srcValue=ComGetEvent("value");
    switch(ComGetEvent("dataformat")) {
        case "engup":  
        ComKeyOnlyAlphabet('upper'); break;
    }
}
/**
 * Actual Code Check, Primary Key Check
 */
function sheet1_OnChange(sheetObj, Row, Col, Value){
    var formObj=document.form;
    // Actual Code Check
    if(sheetObj.ColSaveName(Col) == "act_cd"){
        formObj.f_cmd.value=SEARCH01;
        formObj.chk_act_cd.value=sheetObj.GetCellValue(Row, Col);
        doActionIBSheet(sheetObj, formObj, COMMAND01);
        if(sheetObj.GetCellValue(Row,"act_cd")!="" && sheetObj.GetCellValue(Row,"cop_dtl_grp_cd")!=""){
            formObj.chk_act_cd.value=sheetObj.GetCellValue(Row, "act_cd");
            formObj.chk_cop_dtl_grp_cd.value=sheetObj.GetCellValue(Row, "cop_dtl_grp_cd");
            doActionIBSheet(sheetObj, formObj, COMMAND03);
        }
    }
    if(sheetObj.ColSaveName(Col) ==  "cop_dtl_grp_cd"){
        formObj.chk_cop_dtl_grp_cd.value=sheetObj.GetCellValue(Row, "cop_dtl_grp_cd");
        doActionIBSheet(sheetObj, formObj, COMMAND02);
        if(sheetObj.GetCellValue(Row,"act_cd")!="" && sheetObj.GetCellValue(Row,"cop_dtl_grp_cd")!=""){
            formObj.chk_act_cd.value=sheetObj.GetCellValue(Row, "act_cd");
            formObj.chk_cop_dtl_grp_cd.value=sheetObj.GetCellValue(Row, "cop_dtl_grp_cd");
            doActionIBSheet(sheetObj, formObj, COMMAND03);
        }
    }
}

function sheet1_OnPopupClick(sheetObj, Row, Col, Value) {
    var colname=sheetObj.ColSaveName(Col);
    switch(colname)
    {
        case "act_cd":
        param='?classId=COM_COM_0009';
        ComOpenPopup('/opuscntr/COM_COM_0009.do' + param, 1024, 650, 'getactcd', "1,0,1,1,1,1,1,1,1,1,1,1", true);
                break;
    }
}   
function getactcd(rowArray, row, col) {
    var sheetObj=sheetObjects[0];
    var colArray=rowArray[0];
    sheetObj.SetCellValue(sheetObj.GetSelectRow(), "act_cd",colArray[2]);
}
function checkDuple(){
    var sheetObj=sheetObjects[0];
    var sheet1RowCnt=sheetObjects[0].RowCount();
    var chkDul=0;
    var dupRowArray = sheetObj.ColValueDupRows('cop_dtl_grp_cd|act_grp_seq');
    if(dupRowArray==""){
        return "";
    }
    else{
       //checkNull
       alert( 'There are duplicate data at ' +dupRowArray);
       dupRowArray=dupRowArray.split(",");
       return dupRowArray;
    }
    return "";
}
function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}
/* Developer Work End */
