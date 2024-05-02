/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_fms_0038.js
*@FileTitle  : Revenue VVD Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19
=========================================================*/
/****************************************************************************************
  event classification code : [initializing]INIT=0; [inputting]ADD=1; [retrieving]SEARCH=2; [list retrieving]SEARCHLIST=3;
					[modifying]MODIFY=4; [deleting]REMOVE=5; [list deleting]REMOVELIST=6 [multiple handling]MULTI=7
					etc extra codes  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class esm_fms_0038 : esm_fms_0038 definition of biz script for creation screen
 */
// common global variables 
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1; 
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event*/
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick(){
	var sheetObject=sheetObjects[0];
   var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
      	switch(srcName) {
        	case "btn_retrieve":
             	if(!CoFmsInitConfirm(sheetObject)) return;
             	doActionIBSheet(sheetObject,formObject,IBSEARCH);
            break;
			case "btn_new":
             	if(!CoFmsInitConfirm(sheetObject)) return;
				ComResetAll();
				
		        var nowYrMon = ComGetNowInfo("ym","-")+"-01";
			    
		    	var tmpFrYm = ComGetDateAdd(nowYrMon,"M", -1);
		    	var tmpToYm = ComGetDateAdd(nowYrMon,"M", 0);
		    	
		    	document.form.rev_yrmon_from.value=gf_GetDateFormat(tmpFrYm,"ym");
		    	document.form.rev_yrmon_to.value=gf_GetDateFormat(tmpToYm,"ym");
		    	
            break;
			case "btn_savetofile":
				if(sheetObject.RowCount() < 1){//no data	
					ComShowCodeMessage("COM132501");
				}else{	
					sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1 });
				}	
            break;
 			case "btn_period_from":
 				var cal=new ComCalendar();
				cal.setDisplayType('month');
				cal.select(form.rev_yrmon_from, 'yyyy-MM');
				break;					
 			case "btn_period_to":
 				var cal=new ComCalendar();
				cal.setDisplayType('month');
				cal.select(form.rev_yrmon_to, 'yyyy-MM');
				break;					
			case "btn_lanepop":
				ComOpenPopup("ESM_FMS_0036.do", 620, 440,"setLaneCd", "1,0,1,1,1", true, false, null, null, 0, "ESM_FMS_0036");
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
 * Loading Event of HTML_Control existing on page dynamically <br>
 * Calling the function from {@link #loadPage} to initialize IBSheet Object<br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sequence of sheetObjects array
 **/
function initControl() {
    //Axon Event Handling1. Event catch
	axon_event.addListener  ('change'  , 'lane_cd_change', 'slan_cd');				//- Verifying Code after inputting Service Lane Code
    
    var nowYrMon = ComGetNowInfo("ym","-")+"-01";
    
	var tmpFrYm = ComGetDateAdd(nowYrMon,"M", -1);
	var tmpToYm = ComGetDateAdd(nowYrMon,"M", 0);
	
	document.form.rev_yrmon_from.value=gf_GetDateFormat(tmpFrYm,"ym");
	document.form.rev_yrmon_to.value=gf_GetDateFormat(tmpToYm,"ym");
}
/**
 * Handling screen by Event <br>
 * @param {String} flag  
 **/
function inputReadOnly(flag) {
	var readOnly=true;
	var cursor="default";
	var img="no_";
	if(flag == "New") {
		readOnly=false;
		cursor="hand";
		img="";
	}
	form.rev_yrmon.readOnly=readOnly;
	form.slan_cd.readOnly=readOnly;
	
	form.btn_period_from.name=img+"btn_period_from";
	form.btn_period_to.name=img+"btn_period_to";
	form.btn_lanepop.name=img+"btn_lanepop";
	
	form.btn_period_from.style.cursor=cursor;
	form.btn_period_to.style.cursor=cursor;
	form.btn_lanepop.style.cursor=cursor;
}
 /**
 * setting sheet initial values and header <br>
 * adding case as numbers of counting sheets <br>
 * <br><b>Example :</b>
 * <pre>
 *     initSheet(sheetObj,1);
 * </pre>
 * @param {ibsheet} sheetObj Mandatory IBSheet Object
 * @param {int} sheetNo Mandatory IBSheet Object Tag's ID Serial No
 * @return N/A
 * @author 
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetNo) {
        case 1:      //sheet1 init
            with(sheetObj){
//		              (9, 0, 0, true);
	              var HeadTitle="|Seq|Revenue Month|Service Lane|Revenue Lane|Service Lane Direction|VVD Code|Start Date|End Date";
	
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                     {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
	                     {Type:"Date",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"rev_yrmon",   KeyField:0,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"slan_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"rlane_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vst_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ved_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	               
	              InitColumns(cols);
	              SetEditable(1);
//		              SetSheetHeight(420);
	              resizeSheet();
                }
            break;
     }
 }
/**
 * Handling IBSheet's process(Retrieve, Save) <br>
 * @param {ibsheet} sheetObj Mandatory IBSheet Object
 * @param {form}    formObj Mandatory html form object
 * @param {int}     sAction mandatory,Constant Variable
 * @param {String}  gubun     	gubun value
 **/ 
function doActionIBSheet(sheetObj,formObj, sAction, Col, Row) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
     	case IBSEARCH:      
 			if(!validateForm(sheetObj,formObj,sAction))return;
     		formObj.f_cmd.value=SEARCH;
//         	   	sheetObj.DoSearch("ESM_FMS_0038GS.do", ComReplaceStr(FormQueryString(formObj)+"&"+"-",{Append:)} );
     		sheetObj.DoSearch("ESM_FMS_0038GS.do", ComReplaceStr(FormQueryString(formObj),"-",""));
            break;
		case IBROWSEARCH:   	
    		if (Col == "slan_cd") {//Checking Service Lane Code
				var param='f_cmd='+SEARCH05;
				if(typeof Row == "undefined" || Row == "" ) {
					param += "&lane_cd="+formObj.slan_cd.value;		//Calling from form
				} else {
					param += "&lane_cd="+sheetObj.GetCellValue(Row, Col);//Calling from grid
				}
	   			var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do" , param);
	   			var cdName=ComGetEtcData(sXml, "cdName");
	   			if(typeof cdName == "undefined" || cdName == "" ) {
					if(typeof Row == "undefined" || Row == "" ) {
						formObj.slan_cd.value="";
						ComAlertFocus(formObj.slan_cd, ComGetMsg("FMS01237"));
					} else {
						ComShowCodeMessage("FMS01237");
						sheetObj.SetCellValue(Row, Col,"",0);
						sheetObj.SelectCell(Row, Col);
					}
				}
    		}	
            break;
    }
}
/**
 * Inserting Lane Code<br>
 * @param {arry} aryPopupData
 */
function setLaneCd(aryPopupData){
	form.slan_cd.value=aryPopupData[0][3];
}
/**
 * Checking corresponding Lane Code when changing Service LaneCd <br>
 **/
function lane_cd_change() {
	if (form.slan_cd.value != "") {
		doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'slan_cd');
	}
}

/**
  * Handling process for input validation
  */
function validateForm(sheetObj,formObj,sAction){
	if (!ComChkValid(formObj)) return false;
 return true;
}
/**
  * In case of clicking Popup in IBSheet Object
  */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {

}	

function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
} 	
