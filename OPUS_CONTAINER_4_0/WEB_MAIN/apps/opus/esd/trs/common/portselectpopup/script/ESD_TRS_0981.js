/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0981.js
*@FileTitle  : Port Code Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2015/04/13
=========================================================*/
/****************************************************************************************
  Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
              MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
              Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// public variable
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
//Event handler processing by button name */
function processButtonClick(){
    var sheetObj=sheetObjects[0];
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
         switch(srcName) {
            case "btn_ok":
            	var returnVal = new Array();
            	returnVal[0] = sheetObj.GetCellValue(sheetObj.GetSelectRow(), 'loc_cd');
            	returnVal[1] = sheetObj.GetCellValue(sheetObj.GetSelectRow(), 'loc_nm');
            	ComPopUpReturnValue(returnVal);
                break;
            case "btn_close":
                ComClosePopup(); 
                break;
            case "btn_Retrieve":
                if(formObject.port_cd.value!=''){
                    formObject.loc_cd.value=formObject.cnt_cd.value + formObject.port_cd.value;
                }else{
                    formObject.loc_cd.value='';
                }
                if(validateForm(sheetObj, document.form, IBSEARCH)){
                    doActionIBSheet(sheetObj,document.form,IBSEARCH);
                }
                break;
            case "btn_popup":
                var cnt_cd=formObject.cnt_cd.value;
                var port_cd=formObject.port_cd.value;
                var param="?cnt_cd=" + cnt_cd + "&loc_cd=" + port_cd;
                var sUrl="/opuscntr/COM_ENS_0M1.do?"
				ComOpenPopup(sUrl, 800, 550, "countryCodeHelp", "1,0,1,1,1,1,1,1", false);
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

function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    ComOpenWait(false);
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
 function initSheet(sheetObj,sheetNo) {
     var cnt=0;
     switch(sheetNo) {
        case 1:      // sheet1 init
            with(sheetObj){
                tabIndex=-1;
                var HeadTitle="|Seq|Port Code|Port Name";
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:0 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                var cols = [{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                            {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
                            {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"loc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:170,  Align:"Left",    ColMerge:0,   SaveName:"loc_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                                                          
                InitColumns(cols);
                SetWaitImageVisible(0);
                SetSheetHeight(310);
            }
            break;
    }
}
// handling sheet process
 function doActionIBSheet(sheetObj,formObj,sAction) {
     switch(sAction) {
        case IBSEARCH:      //Retrieve
        	ComOpenWait(true);
            formObj.f_cmd.value=SEARCH;
            if(validateForm(sheetObj,formObj,sAction))
                if ( sheetObj.id == "sheet1"){
                    ComOpenWait(true);
                    var sParam=FormQueryString(formObj);
                    var rXml=sheetObj.GetSearchData("ESD_TRS_0981GS.do", sParam);
                    var total = ComGetTotalRows(rXml);
                    if(total > 0) {
                        sheetObj.LoadSearchData(rXml,{Sync:1} );
                    }
                    else {
                    	ComShowCodeMessage("COM130402", "Port");  
                    }
                    ComOpenWait(false);
                }
            break;
        case SEARCH01:  // Country Name Retrieve
            ComOpenWait(true);
            formObj.f_cmd.value=SEARCH01;
            var sParam=FormQueryString(formObj);
            var sXml=sheetObj.GetSearchData("ESD_TRS_0981GS.do", sParam);
            var nm=ComGetEtcData(sXml, "cnt_nm");
            if(nm!=null){
                formObj.tmp_cnt_cd.value=formObj.cnt_cd.value;
                ComSetNextFocus();
            }else{
                ComShowCodeMessage('COM130402', formObj.cnt_cd.value);
                formObj.cnt_cd.value=formObj.tmp_cnt_cd.value;
                formObj.cnt_cd.focus();
            }
            ComOpenWait(false);
            
            break;
     }
 }
 /**
  * handling process for input validation
  */
 function validateForm(sheetObj,formObj,sAction){
     with(formObj){
     }
     return true;
 }
 
 function sheet1_OnDblClick(sheetObj, Row, Col){
 	var returnVal = new Array();
	returnVal[0] = sheetObj.GetCellValue(sheetObj.GetSelectRow(), 'loc_cd');
	returnVal[1] = sheetObj.GetCellValue(sheetObj.GetSelectRow(), 'loc_nm');
	ComPopUpReturnValue(returnVal);
}//end sheet1_OnDblClick

function initControl() {
     var formObj=document.form;
     axon_event.addListenerForm('change', 'obj_change', formObj);
     axon_event.addListener('keydown', 'ComKeyEnter', 'form');// Enter key
     //axon_event.addListener  ('keypress', 'eng_keypress' , 'cnt_cd', 'port_cd', 'loc_nm');
     //axon_event.addListener ('keypress', 'enter_keypress', 'form');       //- Enter
     //axon_event.addListener ('keyup', "VskKeyFocus", 'form');         //- focus
}
function obj_change(){
    var formObj=document.form;
    try {
        var srcName=ComGetEvent("name");
         switch(srcName) {
            case "cnt_cd":
                with(formObj){
                    if(cnt_cd.value==''){
                        port_cd.value='';
                        loc_nm.value='';
                        tmp_cnt_cd.value='';
                    }else{
                        if(ComChkLen(cnt_cd.value, 2)==2){      
                            // in case length is 2, Retrieving Country Code
                            if(tmp_cnt_cd.value!=cnt_cd.value){
                                doActionIBSheet(sheetObjects[0], formObj, SEARCH01);
                            }
                        }
                    }
                }
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
  * Handling English of onkeypress
  **/
 function eng_keypress() {
     var obj=ComGetEvent();
     switch(ComGetEvent("name")){
        case "loc_nm":
            if(ComGetEvent("keycode")!=32){
            //  ComKeyOnlyAlphabet('upper');
            }
            break;
        default:
            ComKeyOnlyAlphabet('upper');        
     }
 }
 
 /**
  * Handling enter key
  */
 function enter_keypress(){
 	// TODO
    VskKeyEnter();
 }

/**
 * Setting Country Code from Location by loc_cd popup
 * 
 * @param rtnObjs
 * @param row
 * @param col
 * @param sheetIdx
 * @return
 */
function countryCodeHelp(rtnObjs, row, col, sheetIdx) {
    var formObj=document.form;
    formObj.cnt_cd.value=rtnObjs[0][3];
    formObj.port_cd.focus();
}
