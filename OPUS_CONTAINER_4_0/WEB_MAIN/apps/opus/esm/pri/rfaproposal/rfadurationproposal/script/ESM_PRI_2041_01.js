/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_PRI_2041_01.js
*@FileTitle  : Amendment History Inquiry - Duration
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/06
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class ESM_PRI_2041_01 : business script for ESM_PRI_2041_01 
 */
function ESM_PRI_2041_01() {
	this.processButtonClick=tprocessButtonClick;
	this.setSheetObject=setSheetObject;
	this.loadPage=loadPage;
	this.initSheet=initSheet;
	this.initControl=initControl;
	this.doActionIBSheet=doActionIBSheet;
	this.setTabObject=setTabObject;
	this.validateForm=validateForm;
}
// global variables
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var tabLoad=new Array();
tabLoad[0]=0;
tabLoad[1]=0;
//Event handler processing by button click event */
document.onclick=processButtonClick;
/**
 * Event handler processing by button name  <br>
 */
function processButtonClick(){
     var sheetObject1=sheetObjects[0];
     var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
        switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject1,formObject,IBSEARCH);
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
 * registering IBSheet Object as list <br>
 * adding process for list in case of needing batch processing with other items  <br>
 * defining list on the top of source <br>
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * Initializing and setting Sheet basics <br>
 * Setting body tag's onLoad event handler <br>
 * Adding pre-handling function after loading screen on the browser  <br>
 */
function loadPage() {
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    } 
    	resizeSheet();
        loadSts=true;
        parent.loadTabPage();
	}
/**
 * setting sheet initial values and header <br>
 * adding case as numbers of counting sheets <br>
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
	var sheetID=sheetObj.id;
    switch(sheetID) {
        case "sheet1":
			with(sheetObj){
				var HeadTitle1="|Seq.|Duration|Duration|Effective Date|Expiry Date|Source|Status|Accepted|Accepted||";
				var HeadTitle2="|Seq.|Duration|Duration|Effective Date|Expiry Date|Source|Status|By|On||";
				var headCount=ComCountHeadTitle(HeadTitle1);
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				
				var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				 {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
				 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ctrt_eff_dt",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ctrt_exp_dt",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eff_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"exp_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"src_info_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"prc_prog_sts_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:0,   SaveName:"acpt_usr_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"amdt_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n1st_cmnc_amdt_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
				   
				InitColumns(cols);
				resizeSheet(); //SetSheetHeight(260);
				SetEditable(0);
				SetWaitImageVisible(0);
				SetMergeCell(0, 2, 2, 2);
			}
            break;
    }
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}

/**
 * Handling sheet process <br>
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    try{
        switch(sAction) {	
		    case IBSEARCH: // retrieve
		    	ComOpenWait(true); //->waiting->start
		     	formObj.f_cmd.value=SEARCH;
		     	sheetObj.DoSearch("ESM_PRI_2041_01GS.do", FormQueryString(formObj) );
				ComOpenWait(false); //->waiting->End
				break;	    			
	    }    	
    } catch (e) {
       	if (e == "[object Error]") {
           ComShowMessage(OBJECT_ERROR);
        } else {
           ComShowMessage(e.message);
        }
    }finally{
        ComOpenWait(false); //->waiting->End
    }
}
 /**
  * calling function when occurring OnSearchEnd Event <br>
  *  setting Sheet's Font Style
  */ 		
	function sheet1_OnSearchEnd(sheetObj, errMsg){
		var formObj=document.form;
		formObj.eff_dt.value=sheetObj.GetCellValue(sheetObj.RowCount(),"eff_dt");
		var sCols="";
		searchEndFont(sheetObj, sCols);
	} 
  /**
   * calling function when occurring OnSelectCell Event <br>
   */        	
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
       if (OldRow != NewRow) {

       }
	}    
 /**
  * calling function when clicking parent's screen tab <br>
  * showing retrieved data<br>
  */ 
 function tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sConChk) {
 	var formObject=document.form;
 	if (formObject.prop_no.value != sPropNo || formObject.amdt_seq.value != sAmdtSeq || formObject.svc_scp_cd.value != sSvcScpCd) {
 		formObject.prop_no.value=sPropNo;
 		formObject.amdt_seq.value=sAmdtSeq;
 		formObject.svc_scp_cd.value=sSvcScpCd;
 		doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
 	}
 }	
/**
 * initializing parent's screen tab control <br>
 */ 
function tabClearSheet() {
	var formObject=document.form;
	formObject.prop_no.value="";
	formObject.amdt_seq.value="";
	formObject.svc_scp_cd.value="";
	sheetObjects[0].RemoveAll();
}
var enableFlag=true;
/**
 * calling function from main screen <br>
 * prohibiting insert, update, delete in case or Confirmation = YES  <br>
 */
function tabEnableSheet(flag) {
	var formObject=document.form;
	enableFlag=flag;
	sheetObjects[0].SetEditable(flag);
}
/**
 * setting font after retrieving sheet  <br>
 */
function searchEndFont(sheetObj, sCols){
    var arrCols=sCols.split("|");
    var amdt_seq=document.form.amdt_seq.value;
    if(amdt_seq==0){
        return;
    }
    var sRowIdx = sheetObj.HeaderRows();
    var eRowIdx = sheetObj.LastRow();
	for(i=sRowIdx ; i <= eRowIdx; i++){
		if(sheetObj.GetCellValue(i, "amdt_seq") != amdt_seq){
			sheetObj.SetCellFont("FontStrike", i, 1, i, sheetObj.LastCol(), true);
              for (j=0; j < arrCols.length; j++){
                  sheetObj.SetCellEditable(i,arrCols[j],0);
              }
        }
		else if(sheetObj.GetCellValue(i,"n1st_cmnc_amdt_seq") == amdt_seq){
			sheetObj.SetCellFont("FontColor", i, 1, i, sheetObj.LastCol(),"#FF0000");
			if (sheetObj.GetCellValue(i, "src_info_cd") != "AD"){
                  for (j=0; j < arrCols.length; j++){
                      sheetObj.SetCellEditable(i,arrCols[j],1);
                  }
              }
          }
      }
 }
 var loadSts=false;
 /**
 * checking tab screen load  <br>
 */ 	
function loadFinishCheck(){
  return loadSts;
}  