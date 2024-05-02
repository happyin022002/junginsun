/*=========================================================
*Copyright(c) 2009 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0144.js
*@FileTitle  : Shipper Table
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/03
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// Grobla Variable
var sheetObjects=new Array();
var sheetCnt=0;

/* Event handler processing by button click event */
document.onclick=processButtonClick;

/**
 *  Event handler processing by button name 
 */
function processButtonClick(){
    var sheetObject=sheetObjects[0];
    var formObject=document.form;
    
    try {
    	var srcName=ComGetEvent("name");
        if(ComGetBtnDisable(srcName)) return false;
        
        switch(srcName) {
            case "btn_retrieve":
                doActionIBSheet(sheetObject, formObject, IBSEARCH);
                break;
            case "btn_confirm":
                sendValue();
                //SJH.20141128.MOD
//                var row=sheetObject.GetSelectRow(); 
//                if(row > 0 ) {
//                	parent.getShipperCode(sheetObject.GetCellValue(row, "cust_cnt_cd") + sheetObject.GetCellValue(row, "cust_seq"));
//                }
                ComClosePopup(); 
                break;
            case "btn_close":
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
* initializing sheet
* implementing onLoad event handler in body tag
* adding first-served functions after loading screen.
 */
function loadPage() {
    var sheetObject=sheetObjects[0];
    var formObject=document.form;
    for(i=0;i<sheetObjects.length;i++){
        //Sheet configuration setting function(start)
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        //Sheet configuration setting function(end)
        ComEndConfigSheet(sheetObjects[i]);
    }
    if(formObject.f_cust_cnt_cd.value != ""){
        doActionIBSheet(sheetObject,formObject,IBSEARCH);  
    }
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetNo) {
        case 1:      //sheet1 init
            with(sheetObj){
                var HeadTitle="code|seq|name|modi_cust_cd|modi_cust_seq|cntr_cust_tp_cd|ofc_cd" ;
                
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cust_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:1,   SaveName:"cust_lgl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"modi_cust_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"modi_cust_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_cust_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                                                                   
                InitColumns(cols);
                
                SetEditable(0);//Editkind[optional,Defaultfalse]
                SetCountPosition(0);
//                SetSheetHeight(ComGetSheetHeight(sheetObj, 12));
				  resizeSheet();
            }

            break;
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
function sendValue(){
    var sheetObj=sheetObjects[0];
    var row=sheetObj.GetSelectRow();
    opener.document.form.txtShipper.value=sheetObj.GetCellValue(row, "cust_cnt_cd") + sheetObj.GetCellValue(row, "cust_seq");
}
/**
 *  Add to the sheet2 the selected information from sheet1
 */
function sheet1_OnDblClick(sheetObj , row, col , value) {
    sendValue();
    ComClosePopup(); 
}
/**
 * Handling process about the sheet object
 */ 
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
        case IBSEARCH:      //Inquiry
            if(!validateForm(sheetObj,formObj,IBSEARCH)) return false;
            // Prohibit button click when a business transaction is processing 
            sheetObj.SetWaitImageVisible(1);
            ComOpenWait(true);
            formObj.f_cmd.value=SEARCHLIST01;
            sheetObj.DoSearch("ESM_COA_0144GS.do", coaFormQueryString(formObj) );
            ComOpenWait(false);
            break;
    }
}

function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
    ComOpenWait(false);
}

/**
 * Handling process for form object input validation
 */
function validateForm(sheetObj,formObj,sAction){
    with(formObj){
        if(f_cust_cnt_cd.value == ""){
            // [COM12114] : Check the country
            ComShowMessage(ComGetMsg('COM12114','Country'));
            f_cust_cnt_cd.focus();
            return false;
        }
    }
    return true;
}

function resizeSheet(){
	 ComResizeSheet(sheetObjects[0]);
}