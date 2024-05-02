/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_3301.js
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
 * @class ESM_BKG_2003 : ESM_BKG_2003 business script.
 */
/* Developer Work   */
// global variable
var sheetObjects=new Array();
var sheetCnt=0;
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
            if(sheetObject.CheckedRows('check')=='0' ){
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
   // axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
   // axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
    //axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    axon_event.addListenerForm('change', 'obj_change', document.form); // change
    axon_event.addListenerForm('click', 'obj_click', document.form); // click
    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 }
 function initControl() {
    var formObj=document.form;
     axon_event.addListenerForm     ('focus'    , 'obj_focus'       , formObj);
    //axon_event.addListenerFormat   ('keypress' , 'obj_keypress'    , form);
   //axon_event.addListenerFormat   ('keyup'    , 'obj_change'      , form);
 }
 function obj_focus() {
    if(event.srcElement.options){
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
                  var HeadTitle="|Sel.|Seq|Act Code|Act Rcv Tp Cd|Act Sts Mapg Cd|Act Flg|Rail ITCH CHK";
                  var headCount=ComCountHeadTitle(HeadTitle);

                  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

                  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                  var headers = [ { Text:HeadTitle, Align:"Center"} ];
                  InitHeaders(headers, info);

                  var cols = 
                	  [ {Type:"Status",     Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                        {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"check" },
                        {Type:"Seq",        Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
                        {Type:"PopupEdit",  Hidden:0, Width:125,  Align:"Center",  ColMerge:1,   SaveName:"act_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6 },
                        {Type:"Text",       Hidden:0, Width:125,  Align:"Center",  ColMerge:1,   SaveName:"act_rcv_tp_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
                        {Type:"Text",       Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"act_sts_mapg_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6 },
                        {Type:"Combo",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"act_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:40 },
                        {Type:"Combo",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rail_itchg_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:40 } ];
                   
                  InitColumns(cols);

                  SetEditable(1);
                  SetWaitImageVisible(0);
                  SetColProperty(0 ,"act_cd"         , {AcceptKeys:"E", InputCaseSensitive:1});
                  SetColProperty(0 ,"act_rcv_tp_cd"  , {AcceptKeys:"N"});
                  SetColProperty(0 ,"act_sts_mapg_cd", {AcceptKeys:"E", InputCaseSensitive:1});
                  SetAutoRowHeight(0);
                  SetDataRowHeight(22);
                  SetColProperty("act_flg",        {ComboText:"Yes|No", ComboCode:"Y|N"} );
                  SetColProperty("rail_itchg_flg", {ComboText:"Yes|No", ComboCode:"Y|N"} );
//                SetSheetHeight(440);
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
            if(validateForm(sheetObj,formObj,sAction)!= true){
                break;
            }
            formObj.f_cmd.value=SEARCH;
            var sParam=FormQueryString(formObj);
            sheetObj.DoSearch("ESD_SCE_3301GS.do",sParam );
            break;
        case COMMAND01:      //Act_cd Check 
                  formObj.f_cmd.value=COMMAND01;
                  var sXml=sheetObj.GetSaveData("ESD_SCE_3301GS.do", FormQueryString(formObj));
                  var valResult=ComGetEtcData(sXml, "knt");
                  if(valResult == '0'){
                      var Msg=formObj.chk_act_cd.value;
                      ComShowCodeMessage('SCE01221', Msg);
                      sheetObj.SetCellValue(sheetObj.GetSelectRow(), "act_cd",'',0);
                  }
                break;
        case COMMAND02:      //Primary Key Check 
            formObj.f_cmd.value=COMMAND02;
            var sXml=sheetObj.GetSaveData("ESD_SCE_3301GS.do", FormQueryString(formObj));
            var valResult=ComGetEtcData(sXml, "chk");
            if(valResult != '0'){
              var Msg="Act Code and Act Rcv Tp Code and Act sts Mapg Cd";
              ComShowCodeMessage('SCE01221', Msg);
              sheetObj.SetCellValue(sheetObj.GetSelectRow(), "act_cd",'',0);
              sheetObj.SetCellValue(sheetObj.GetSelectRow(), "act_sts_mapg_cd",'',0);
              sheetObj.SetCellValue(sheetObj.GetSelectRow(), "act_rcv_tp_cd",'',0);
            }
        break;
        case MULTI: // Save
            //2013505 박은정 validation 추가
            //저장값없으면 리턴 시킴
            if(sheetObj.FindStatusRow('I|U|D') ==""){
                ComShowCodeMessage('SCE01222');
                return false;
            } 
            //mandatory 체크 
            if (sheetObj.GetSaveString() == "") return;
            if(validateForm(sheetObj,formObj,sAction) != true){
                ComShowCodeMessage('BKG00167');
                break;
            }
            formObj.f_cmd.value=MULTI;
           
            sheetObjects[0].DoSave("ESD_SCE_3301GS.do", FormQueryString(formObj));
          
            break;
        case "btn_exceldown":
            sheetObj.Down2Excel({ HiddenColumn:1});
            break;
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
                if(sheetObj.GetCellValue(i,"act_cd")=="" || sheetObj.GetCellValue(i,"act_rcv_tp_cd")=="" || sheetObj.GetCellValue(i,"act_sts_mapg_cd")==""){
                    var Msg="Actual Code or Act Rcv Tp Cd or Act Sts Mapg Cd.";
                    ComShowCodeMessage('BKG00626',  Msg);
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
    var srcMaxLength=ComGetEvent("maxlength");
    var srcValue=ComGetEvent("value");
}
/**
 * Add row Event Handling
 */ 
function addRow(formObj) {
    with (sheetObjects[0]) {
        var nowRow=GetSelectRow();
        nowRow=DataInsert(-1);
        SetCellValue(nowRow, "rail_itchg_flg", "N", 0);
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
      if(sheetObj.GetCellValue(Row,"act_cd")!="" && sheetObj.GetCellValue(Row,"act_rcv_tp_cd")!="" && sheetObj.GetCellValue(Row,"act_sts_mapg_cd")!=""){
          formObj.chk_act_cd.value=sheetObj.GetCellValue(Row, "act_cd");
          formObj.chk_act_rcv_tp_cd.value=sheetObj.GetCellValue(Row, "act_rcv_tp_cd");
          formObj.chk_act_sts_mapg_cd.value=sheetObj.GetCellValue(Row, "act_sts_mapg_cd");
          doActionIBSheet(sheetObj, formObj, COMMAND02);
      }
  }
  if(sheetObj.ColSaveName(Col) == "act_rcv_tp_cd" || sheetObj.ColSaveName(Col) == "act_sts_mapg_cd"){
      if(sheetObj.GetCellValue(Row,"act_cd")!="" && sheetObj.GetCellValue(Row,"act_rcv_tp_cd")!="" && sheetObj.GetCellValue(Row,"act_sts_mapg_cd")!=""){
          formObj.chk_act_cd.value=sheetObj.GetCellValue(Row, "act_cd");
          formObj.chk_act_rcv_tp_cd.value=sheetObj.GetCellValue(Row, "act_rcv_tp_cd");
          formObj.chk_act_sts_mapg_cd.value=sheetObj.GetCellValue(Row, "act_sts_mapg_cd");
          doActionIBSheet(sheetObj, formObj, COMMAND02);
      }
  }
}
function sheet1_OnSaveEnd(sheetObj,Code,errMsg) {
    var formObj=document.form;
      if( formObj.f_cmd.value == MULTI && errMsg.length ==0) {
          ComShowCodeMessage('COM130102', "Data");
          formObj.f_cmd.value=SEARCH;
          var sParam=FormQueryString(formObj);
          sheetObj.DoSearch("ESD_SCE_3301GS.do",sParam );
      }
// 	 if(Code == 0){
// 		  ComShowCodeMessage("COM132601");
// 		}
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
/* Developer Work End */
function dmtGetMsgText(xmlStr){
    try {
//        var xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
    	var xmlDoc = ComGetXmlDoc(xmlStr);
    	if (xmlDoc == null) return;
//        xmlDoc.loadXML(xmlStr);
        var xmlRoot = xmlDoc.documentElement;
        if(xmlRoot == null) return;
        var msgNode=xmlRoot.getElementsByTagName("MESSAGE").item(0);
        if(msgNode == null) 
         return;
        else
         return msgNode.firstChild.nodeValue;
   } catch(err) { ComFuncErrMsg(err.message); }
}
function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}