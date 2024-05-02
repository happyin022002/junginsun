/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0125.js
*@FileTitle  : Route Exception
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                     OTHER CASEOTHER CASE: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
var sheetObjects=new Array();
var sheetCnt=0;
var prefix="sheet1_";
var btnEnable="X";  //deactivating button
// Event handler processing by button click event */
document.onclick=processButtonClick;
/*
 * {@link #loadPage} IBSheet Object  initializing. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 
 */
function initControl() {
    var form=document.form; 
    axon_event.addListenerFormat('change',   'obj_change',   form); 
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
                formObj.cust_trd_prnr_id.value= formObj.cust_trd_prnr_id.value.toUpperCase();
                formObj.partner_id.value= formObj.cust_trd_prnr_id.value.toUpperCase();
                var sXml=sheetObj.GetSearchData("ESD_SCE_0120GS.do" , SceFrmQryString(document.form));
                
                if(document.form.cust_trd_prnr_id.value == "" ){
                       //showErrMessage(getMsg("COM12114" ,"TP ID",'',''));
                       return false;
                }
                //텍스트 가져오기[partnerName]
                var partnerName=ComGetEtcData(sXml,"partner_name") == "" ? "" : ComGetEtcData(sXml,"partner_name");
                var ediSvcTpNm=ComGetEtcData(sXml,"ediSvcTpNm");
                formObj.partnerName.value=partnerName;
                /*
                if(ediSvcTpNm.substring(0,4) == "PORT"){    
                    doActionBtnEnable('S');
                }else{  
                    doActionBtnEnable('X');
                }*/
                
                
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
 * Action button is enabled / disabled to set the. <br>
 * @param  invStatus String
 * @param  statusCd String
 * @return 
 * @author 
 * @version 
 */ 
function doActionBtnEnable (invStatus){
    // Invoice Confirm button to activate / deactivate
    if(invStatus == 'S'){
        //Global Variables
        btnEnable="S";
    } else {
        //Global Variables
        btnEnable="X";
        sheetObjects[0].RemoveAll();
    }
}
// Event handler processing by button name */
function processButtonClick() {
    var sheetObject=sheetObjects[0];
    /*******************************************************/
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        switch (srcName) { 
        case "btn_retrieve":
            doActionIBSheet(sheetObject,formObject,IBSEARCH);
            break;
        case "btn_new":
            sheetObject.RemoveAll();
            formObject.reset();
            break;
        case "btn_save":
            doActionIBSheet(sheetObject,formObject,IBSAVE);
            break;
        case "btn_save_partner":
            doActionIBSheet(sheetObject,formObject, MULTI01);
            break;                  
        case "btn_por_port_cd":
            selectPort(formObject, 'POR');
            break;
        case "btn_pol_port_cd":
            selectPort(formObject, 'POL');
            break;
        case "btn_pod_port_cd":
            selectPort(formObject, 'POD');
            break;
        case "btn_del_port_cd":
            selectPort(formObject, 'DEL');
            break;
        case "btn_RowAdd":
            if(formObject.cust_trd_prnr_id.value == ""){
                  ComShowCodeMessage("COM12114" ,"TP ID",'','');
                  return false;
            }
            var iRow=sheetObject.DataInsert();
            var i=sheetObject.GetSelectRow();
            //key setting
            
            sheetObject.SetCellValue(i,prefix+"cust_trd_prnr_id",formObject.cust_trd_prnr_id.value,0);
            sheetObject.SetCellValue(i, prefix+"lnk_knt","1");
            
        break;
        case "btn_RowCopy":
            sheetObject.DataCopy();
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
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
 function initSheet(sheetObj, sheetNo) {
    var cnt=0;
    switch (sheetNo) {
    case 1: 
        with(sheetObj){
          var HeadTitle="SEQ|No \nUse|STS|POR|POL|Lane|Dir.|1st T/S|1st T/S|1st T/S|2nd T/S|2nd T/S|2nd T/S|POD|DEL|Remarks";
          var HeadTitle1="SEQ|No \nUse|STS|POR|POL|Lane|Dir.|Port|Lane|Dir.|Port|Lane|Dir.|POD|DEL|Remarks";

          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:4, DataRowMerge:1 } );

          var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
          var headers = [ { Text:HeadTitle, Align:"Center"},
                      { Text:HeadTitle1, Align:"Center"} ];
          InitHeaders(headers, info);

          var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
                 {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"check",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
                 {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"por_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"org_loc_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"n1st_lane_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
                 {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"n1st_skd_dir_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"n2nd_pol_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"n2nd_lane_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
                 {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"n2nd_skd_dir_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"n3rd_pol_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"n3rd_lane_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
                 {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"n3rd_skd_dir_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"dest_loc_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"usr_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:498 },
                 {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"lnk_knt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
                 {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cust_trd_prnr_id", KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
                 {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rout_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:12 },
                 {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:12 },
                 {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 } ];
           
          InitColumns(cols);

          SetEditable(1);
          SetColProperty(prefix+"n1st_skd_dir_cd", {ComboText:"|E|W|S|N", ComboCode:"|E|W|S|N"} );
          SetColProperty(prefix+"n2nd_skd_dir_cd", {ComboText:"|E|W|S|N", ComboCode:"|E|W|S|N"} );
          SetColProperty(prefix+"n3rd_skd_dir_cd", {ComboText:"|E|W|S|N", ComboCode:"|E|W|S|N"} );
          SetColProperty(prefix+"cre_dt", {Format:"####-##-####:##"} );
          SetColProperty(prefix+"upd_dt", {Format:"####-##-####:##"} );
          SetColProperty(0 ,prefix+"por_cd"     , {AcceptKeys:"E|N", InputCaseSensitive:1});
          SetColProperty(0 ,prefix+"org_loc_cd" , {AcceptKeys:"E|N", InputCaseSensitive:1});
          SetColProperty(0 ,prefix+"n1st_lane_cd" , {AcceptKeys:"E", InputCaseSensitive:1});
          SetColProperty(0 ,prefix+"n2nd_pol_cd", {AcceptKeys:"E|N", InputCaseSensitive:1});
          SetColProperty(0 ,prefix+"n3rd_pol_cd", {AcceptKeys:"E|N", InputCaseSensitive:1});
          SetColProperty(0 ,prefix+"dest_loc_cd", {AcceptKeys:"E|N", InputCaseSensitive:1});
          SetColProperty(0 ,prefix+"del_cd", {AcceptKeys:"E|N", InputCaseSensitive:1});
          //SetRangeBackColor(1, 5, 1, 9,"#DEFBF8");
          SetHeaderRowHeight(20 );
//        SetSheetHeight(260);
          resizeSheet();
      }


        break;
    }
 }
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) { 
    case IBSEARCH: //조회
        if (validateForm(sheetObj, formObj, sAction)){
            //if(!mandatoryChk(formObj)) break;
            formObj.f_cmd.value=SEARCH;
            sheetObj.DoSearch("ESD_SCE_0125GS.do", SceFrmQryString(formObj) + "&" + ComGetPrefixParam(prefix) );
        }
        break;
    case IBSAVE: //저장 
    	if (validateForm(sheetObj, formObj, sAction)){
			var SaveStr=ComGetSaveString(sheetObj);

			if (SaveStr == ""){
				ComShowCodeMessage("SCE01222");
				return;
			} 
			formObj.f_cmd.value=MULTI;
			var aryPrefix=new Array("sheet1_");
			var sXml=sheetObj.GetSaveData("ESD_SCE_0125GS.do", SaveStr + "&" + SceFrmQryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
			sheetObj.LoadSearchData(sXml,{Sync:0} );
	 		doActionIBSheet(sheetObj, formObj, IBSEARCH);
    	}
        break;
    case SEARCH01:
        document.getElementById('cust_trd_prnr_id').value=document.getElementById('cust_trd_prnr_id').value.toUpperCase();
        sheetObj.ShowDebugMsg(false);
        formObj.f_cmd.value=SEARCH01; 
        //sheetObj.DoSearch("ESD_SCE_120GS.do",SceFrmQryString(formObj));
        var sXml=sheetObj.GetSearchData("ESD_SCE_0120GS.do", SceFrmQryString(formObj));
        var partnerName=ComGetEtcData(sXml, "partnerName");
        //var partnerName = sheetObj.EtcData("partnerName");
        document.getElementById('partnerName').value=partnerName;
        ComEtcDataToForm(formObj,sheetObj) ;            
        sheetObj.RemoveAll();
        break; 
   case MULTI01:
        if(!validateForm(sheetObj,formObj,sAction)) return;           
        formObj.f_cmd.value=MULTI01;
        sheetObj.DoSearch("ESD_SCE_0125GS.do", SceFrmQryString(formObj) );
        break;
    }
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBCREATE: 
        case IBSEARCH: 
           if(formObj.cust_trd_prnr_id.value == ""){
               ComShowCodeMessage("COM12114" ,"TP ID",'','');
               return false;           
           } 
           break;
        case IBSAVE:
           if(formObj.cust_trd_prnr_id.value == ""){
               ComShowCodeMessage("COM12114" ,"TP ID",'','');
               return false;           
           } 
        /*
           if(formObj.partnerName.value == ""){
               ComShowCodeMessage("COM12114" ,"TP NAME",'','');
               return false;
           }*/  
    }
    return true;
}
/**
* @param sheetObj
* @param row
* @param col
* @return
*/
function sheet1_OnChange(sheetObj , row , col, value){
var formObj=document.form;
var sName=sheetObj.ColSaveName(col);
var rows=sheetObj.Rows;

if(sheetObj.GetCellValue(row, prefix+"n2nd_pol_cd") != "") {
    sheetObj.SetCellValue(row, prefix+"lnk_knt","2",0);
    if(sheetObj.GetCellValue(row, prefix+"n3rd_pol_cd")!="") {
        sheetObj.SetCellValue(row, prefix+"lnk_knt","3",0);
    }
}else{
    sheetObj.SetCellValue(row, prefix+"lnk_knt","1",0);
}
sheetObj.SetCellValue(row,col,value,0);
switch (sName) {
    //1 org_loc_cd
    case prefix+"org_loc_cd" : 
        if(row >= 0 && row <= rows) {
            if(sheetObj.cellvalue(row, prefix+"por_cd") == ""){
                sheetObj.SetCellValue(row, prefix+"por_cd")=sheetObj.SetCellValue(row, prefix+"org_loc_cd");
            }
        }
    break;
    //2 dest_loc_cd
    case prefix+"dest_loc_cd" : 
        if(row >= 0 && row <= rows) {
            if(sheetObj.SetCellValue(row, prefix+"del_cd", "")){
                sheetObj.SetCellValue(row, prefix+"del_cd")=sheetObj.SetCellValue(row, prefix+"dest_loc_cd");
            }
        }
    break; 
 }

   
}
function mandatoryChk(formObj) {
   if(formObj.cust_trd_prnr_id.value == "" ){   //|| formObj.partnerName.value == ""
      ComShowCodeMessage("COM12114" ,"TP ID",'','');
      return false;        
   }
  return true;
}
function getPartnerName(){
   var sheetObject=sheetObjects[0];
   /*******************************************************/
   var formObj=document.form;
   if(formObj.cust_trd_prnr_id.value == "" ){
      ComShowCodeMessage("COM12114" ,"TP ID",'','');
      return false;        
   }
    doActionIBSheet(sheetObject,formObj,SEARCH01);
}   
function changeSelect(gubun) {
    var frm=document.form;
    var val=frm.select1[frm.select1.selectedIndex].value;
    frm.ts_type.value=val; 
}
function selectType() {
    var frm=document.form;
   var ts_type=frm.ts_type.value;
    var param='?&ts_type='+ts_type;
  //comPopup('/opuscntr/COM_ENS_081.do' + param, 770, 470, 'getLane', "1,0,1,1,1,1,1,1,1,1,1,1");
}
var portInd='';
function selectPort(frm, pt){
    portInd=pt;
    var param='';
    if(pt == 'POR') param='?loc_cd='+frm.por_port_cd.value;
    if(pt == 'POL') param='?loc_cd='+frm.pol_port_cd.value;
    if(pt == 'POD') param='?loc_cd='+frm.pod_port_cd.value;
    if(pt == 'DEL') param='?loc_cd='+frm.del_port_cd.value;
    //ComShowCodeMessage("o param : " + param);
    ComOpenPopup('/opuscntr/COM_ENS_051.do' + param, 900, 470, 'getCOM_ENS_051', '1,0,1,1,1,1,1,1,1,1,1,1'); 
}
function getCOM_ENS_051(rArray) {
    var cArray=rArray [0];
    var frm=document.form;
    if(portInd == 'POR'){
         frm.por_port_cd.value=cArray[3];
    }       
    if(portInd == 'POL'){
         frm.pol_port_cd.value=cArray[3];
    }
    if(portInd == 'POD'){
         frm.pod_port_cd.value=cArray[3];
    }
    if(portInd == 'DEL'){
         frm.del_port_cd.value=cArray[3];
    }   
}
/**
 * Object of the Keypress event processing   <br>
 * Depending on the object's dataformat check the validity of input  <br>
 * @param  
 * @return 
 * @author 
 * @version 
 */ 
/*function obj_keypress(){
    obj=ComGetEvent();
    if(obj.dataformat == null) return;
    window.defaultStatus=obj.dataformat;
    switch(ComGetEvent("dataformat")) {
        case "engup":
            ComKeyOnlyAlphabet('upper');
            break;
    }
}    */
/**  
 * Object of the Keypress event processing  <br>
 * Depending on the object's dataformat check the validity of input  <br>
 * @param  
 * @return 
 * @author 
 * @version 
 */ 
/*function obj_keyup(){
    var formObj=document.form;
    obj=ComGetEvent();
    if(ComGetEvent("dataformat") == null) return;
    window.defaultStatus=obj.dataformat;
    switch(ComGetEvent("dataformat")) {
        case "engup":
            break; 
    }
}*/

function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
} 