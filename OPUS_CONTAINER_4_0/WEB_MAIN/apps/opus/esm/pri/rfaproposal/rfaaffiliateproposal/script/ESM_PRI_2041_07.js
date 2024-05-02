/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_PRI_2041_07.jsp
*@FileTitle  : Amendment History Inquiry - Affiliate Company
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/06
=========================================================*/
/**
 * @fileoverview Amendment History Inquiry - Business Script for Affiliate Company 
 * @author 
 */
/**
 * @extends  
 * @class ESM_PRI_2041_07 : Business Script for ESM_PRI_2041_07
 */
function ESM_PRI_2041_07() {
	this.setSheetObject=setSheetObject;
	this.loadPage=loadPage;
	this.initSheet=initSheet;
	this.processButtonClick=processButtonClick;
	this.doActionIBSheet=doActionIBSheet;
}
//===================================================================================
// Global Variables
//===================================================================================
// Common Global Variables
var sheetObjects=new Array();
var sheetCnt=0;
var sheet1;
var comboObjects=new Array();
var comboCnt=0;
// Global Variables for business logic
//===================================================================================
// Initialize page
//===================================================================================
/** 
* registering IBSheet Object as list</b>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} sheetObj IBSheet Object
* @return void
* @see #
* @author 
* @version 2009.09.15
*/ 
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
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
* @version 2009.09.15
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
    resizeSheet();
    loadSts=true;
	doActionIBSheet(sheet1, form, IBCLEAR);
	parent.loadTabPage();
}
///**
// * The event triggered when creation of object instance is completed. <br>
// * <br><b>Example :</b>
// * <pre>
// *    
// * </pre>
// * @param {ibsheet} sheetObj mandatory IBSheet Object
// * @return void
// * @author 
// * @version 2009.04.17
// */      
//function sheet1_OnLoadFinish(sheetObj) {   
//	  doActionIBSheet(sheet1, form, IBCLEAR);
//	  parent.loadTabPage();
//}   
/** 
* initializing sheet <br>
* adding first-served functions after loading screen. <br>
* adding case as numbers of counting sheets  <br> 
* <br><b>Example :</b>
* <pre>
* </pre>
* @param {IBSheet} sheetObj : sheet Object
* @param {int} sheetNo : Sheet Serial No  
* @return void
* @see #
* @author 
* @version 2009.09.15
*/ 
function initSheet(sheetObj, sheetNo) {
	var form=document.form;
	var cnt=0;
	var sheetID=sheetObj.id;
    var amdtSeq=form.amdt_seq.value;
	switch(sheetID) {
		case "sheet1":
			with(sheet1){
				var HeadTitle1="|Seq.|Customer Code|Customer Code|Customer Name|Location|EFF Date|EXP Date|Souce|Status|Accepted|Accepted||";
				var HeadTitle2="|Seq.|Customer Code|Customer Code|Customer Name|Location|EFF Date|EXP Date|Souce|Status|By|On||";
				var headCount=ComCountHeadTitle(HeadTitle1);
				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				
				var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
				InitHeaders(headers, info);
				
				  var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				 {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
				 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
				 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cust_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
				 {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"cust_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
				 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cust_loc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
				 {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"src_info_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"prc_prog_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"acpt_usr_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"amdt_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n1st_cmnc_amdt_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
				   
				InitColumns(cols);
				resizeSheet(); //SetSheetHeight(260);
				SetEditable(0);
				SetEllipsis(1);
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
 * Calling function in case of clicking tabl on parent screen <br>
 * It shows screen and process retrieve <br>
 * <br><b>Example :</b>
 * <pre>
 * tabLoadSheet("ACE", "1")
 * </pre>
 * @param {string} sPropNo Mandatory prop_no 
 * @param {string} sAmdtSeq Mandatory amdt_seq 
 * @param {string} sSvcScpCd Mandatory svc_scp_cd 
 * @param {string} sConChk Mandatory Conversion check 
 * @return void
 * @author 
 * @version 2009.05.21
 */ 
function tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sConChk) {
	//alert(sPropNo +"<>"+ sAmdtSeq +"<>"+ sSvcScpCd +"<>"+ sConChk);
	var form=document.form;
	if (form.prop_no.value != sPropNo || form.svc_scp_cd.value != sSvcScpCd || form.amdt_seq.value != sAmdtSeq) {
		form.prop_no.value=sPropNo;
		form.amdt_seq.value=sAmdtSeq;
		form.svc_scp_cd.value=sSvcScpCd;
        doActionIBSheet(sheet1, form, IBSEARCH);
	}
}	
//===================================================================================
//Handling Button event
//===================================================================================
document.onclick=processButtonClick;
/** 
* Event handler processing by button name  <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  void  
* @return void
* @see #
* @author 
* @version 2009.09.15
*/ 
function processButtonClick(){
	var form=document.form;
    try {
	    var srcName=ComGetEvent("name");
	    if(ComGetBtnDisable(srcName)) return false;
	    
	    switch(srcName) {
	    	case "btn_retrieve":
    			doActionIBSheet(sheet1, form, IBSEARCH);
	    		break;
	    } //end switch
    }catch(e) {
    	if( e == "[object Error]") {
    		ComShowMessage(OBJECT_ERROR);
 		} else {
 			ComShowMessage(e.message);
 		}
 	}
}
//===================================================================================
//Axson Event Handler
//===================================================================================
//===================================================================================
//UI Object Event Handler
//===================================================================================
//===================================================================================
//Retrieving/Saving
//===================================================================================
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
* @version 2009.09.15
*/ 
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheet1.ShowDebugMsg(false);
	try{
		switch(sAction) {
		case IBCLEAR: //  When screen is loading
			formObj.f_cmd.value=COMMAND13;
			// common Source // Common Status
			formObj.cd.value="CD02064:N:CD01719:N";
			// "Y" in case of code|desc
			var sXml=sheetObj.GetSearchData("PRICommonGS.do" , FormQueryString(formObj));
			var arrXml=sXml.split("|$$|");
			if ( arrXml[0] != null)	setIBCombo(sheetObj,arrXml[0],"src_info_cd", false, 0, "NW"); 				
			if ( arrXml[1] != null)	setIBCombo(sheetObj,arrXml[1],"prc_prog_sts_cd", false, 0, "I");			
			break;
        case IBSEARCH: 
        	ComOpenWait(true); //->waiting->start
        	formObj.f_cmd.value=SEARCH01;
        	sheet1.DoSearch("ESM_PRI_2041_07GS.do", FormQueryString(formObj) );
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
 * Calling Function in case of OnSearchEnd event <br>
 * <br><b>Example :</b>
 * <pre>
 * 
 * </pre>
 * @param {ibsheet} sheetObj mandatory IBSheet Object
 * @param {string} ErrMsg mandatory from server
 * @return void
 * @author 
 * @version 2009.05.20
 */ 	   
function sheet1_OnSearchEnd(sheetObj, errMsg){
	var sCols="";
	searchEndFont(sheetObj, sCols);
}  	
 /**
  * calling function in case of OnSelectCell event <br>
  * <br><b>Example :</b>
  * <pre>
  *		
  * </pre>
  * @param {ibsheet} sheetObj mandatory IBSheet Object
  * @param {int} OldRow Mandatory ,previous selected cell's Row Index
  * @param {int} OldCol Mandatory Previous selected Cell's Column Index
  * @param {int} NewRow Mandatory ,current selected cell's Row Index
  * @param {int} NewCol Mandatory ,current selected cell's Column Index
  * @return void
  * @author 
  * @version 2009.04.17
  */        	
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
      if (OldRow != NewRow) {

      }
	}   
/**
* Change the Font setting after sheet retrieve.  <br>
* <br><b>Example :</b>
* <pre>
*     searchEndFontChange(sheetObj, "ctrt_exp_dt");
* </pre>
* @param {ibsheet} sheetObj mandatory IBSheet Object
* @param {string} colName Mandatory, Search Condtion Key Column Name). Seperated using "|"
* @return void
* @author 
* @version 2009.06.12
*/
function searchEndFont(sheetObj, sCols){
    var arrCols=sCols.split("|");
    var amdt_seq=document.form.amdt_seq.value;
    if(amdt_seq==0){
        return;
    }
	for(i=2 ; i < sheetObj.RowCount(); i++){
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
/**
* Function to clear control of tab screen on parent <br>
* <br><b>Example :</b>
* <pre>
* tabClearSheet()
* </pre>
* @param  void
* @return void
* @author 
* @version 2009.05.20
*/ 
function tabClearSheet() {
	var formObject=document.form;
	formObject.prop_no.value="";
	formObject.amdt_seq.value="";
	sheetObjects[0].RemoveAll();
}
var loadSts=false;
/**
* Function to check whether Tab screen of Parent is loaded from Frame or not<br>
* <br><b>Example :</b>
* <pre>
* 		loadFinishCheck()
* </pre>
* @param  void
* @return bool  loadSts  <br>
*               true  : load completed
*               false : load not completed
* @author 
* @version 2009.05.20
*/ 	
function loadFinishCheck(){
    return loadSts;
} 