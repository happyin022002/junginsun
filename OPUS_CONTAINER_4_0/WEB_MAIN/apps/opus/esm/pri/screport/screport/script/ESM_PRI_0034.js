/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0034.js
*@FileTitle  : SC(RFA) NOTE(CNote, RNote, Special Note) Conversion
*@author     : CLT
*@version    : 1.0
*@since      : 2016/06/07
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
  OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
***************************************************************************************/
//  ===================================================================================
//  Global Variable
//  ===================================================================================
var sheetObjects=new Array();
var sheetCnt=0;
var sheet1;

//  ===================================================================================
//  Initializing page
//  ===================================================================================
/** 
 * registering IBSheet Object as list</b>
 * <br><b>Example :</b>
 * <pre>
 * </pre>
 * @param  {IBSheet} sheetObj IBSheet Object
 * @return void
 * @see #
 * @author 
 * @version 2009.08.12
 */ 
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}

//Event handler processing by button click event */
document.onclick=processButtonClick;

/**
 * Event handler processing by button name  <br>
 */
function processButtonClick(){
    var sheetObject1=sheetObjects[0];
    /*******************************************************/
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        if(ComGetBtnDisable(srcName)) return false;
        switch(srcName) {
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
 * implementing onLoad event handler in body tag <br>
 * adding first-served functions after loading screen. <br> 
 * <br><b>Example :</b>
 * <pre>
 * </pre>
 * @param  void
 * @return void
 * @see #
 * @author 
 * @version 2016.06.07
 */ 
function loadPage() {
	 var form=document.form;	
     sheet1=sheetObjects[0];
     sheetCnt=sheetObjects.length ;
     //Initializing IBSheet
     for(i=0;i<sheetCnt;i++){
         ComConfigSheet(sheetObjects[i]); 
         initSheet(sheetObjects[i],i+1);
         ComEndConfigSheet(sheetObjects[i]);
     }
     
     doActionIBSheet(sheet1, form, IBSEARCH);
}

function initSheet(sheetObj, sheetNo) {
    var cnt=0;
    var sheetID=sheetObj.id;
    switch(sheetID) {
        case "sheet1": //
            with(sheet1){
        		var HeadTitle1="f_text1"

        			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

        		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
        		var headers = [ { Text:HeadTitle1, Align:"Center"} ];
        		InitHeaders(headers, info);

        		var cols = [ {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"f_text1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 } ];
           
        		InitColumns(cols);

        		SetEditable(0);
        		SetVisible(0);
                SetSheetHeight(100);
        	}
            break;
    }
}

/** 
 * Retrieivng and saving <br>
 * <br><b>Example :</b>
 * <pre>
 * </pre>
 * @param  {IBSheet} sheetObj : Sheet Object  
 * @param  {object} formObj :form Object
 * @param  {sAction} sAction Mandatory ,Process Contant value
 * @return void
 * @see #
 * @author 
 * @version 2009.08.12
 */ 
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheet1.ShowDebugMsg(false);
    switch(sAction) {
        case IBSEARCH: 
            ComOpenWait(true);
            
            setTimeout(function(){
            	
	            formObj.f_cmd.value=SEARCH;
	            var sXml=sheet1.GetSearchData("ESM_PRI_0034GS.do", FormQueryString(formObj));
	            var notectnt=ComGetEtcData(sXml, "NOTE_CTNT");
	            if(notectnt != undefined && notectnt != null && notectnt != ""){
	            	formObj.note_ctnt.value = notectnt;
	            } else {
	            	formObj.note_ctnt.value = "";
	            }
	            
	            
	            ComOpenWait(false);
            
            },100);
            break;
    }
}