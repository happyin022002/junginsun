/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_PRI_0057_01.js
 *@FileTitle  : Amendment History Inquiry - Duration
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/27
=========================================================*/
/****************************************************************************************
  Event code: [Initial]INIT=0; [ADD]ADD=1; [SEARCH]SEARCH=2; [SEARCHLIST]SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					Other extra variable  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
 * @
 * @author 
 */
/**
 * @extends
 * @class ESM_PRI_0057_01 : Business Script for ESM_PRI_0057_01
 */
function ESM_PRI_0057_01() {
	this.processButtonClick=tprocessButtonClick;
	this.setSheetObject=setSheetObject;
	this.loadPage=loadPage;
	this.initSheet=initSheet;
	this.initControl=initControl;
	this.doActionIBSheet=doActionIBSheet;
	this.setTabObject=setTabObject;
	this.validateForm=validateForm;
}
// common global variables
//var tabObjects = new Array();
//var tabCnt = 0 ;
//var beforetab = 1;
var sheetObjects=new Array();
var sheetCnt=0;
//var tabLoad = new Array();
//tabLoad[0]= 0;
//tabLoad[1]= 0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
/**
 * Event handler processing by button name  <br>
 * <br><b>Example :</b>
 * <pre>
 *     processButtonClick();
 * </pre>
 * @return void
 * @author 
 * @version 2009.04.17
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
 * adding process for list in case of needing batch processing with other items<br>
 * defining list on the top of source <br>
 * <br><b>Example :</b>
 * <pre>
 *     setSheetObject(sheetObj);
 * </pre>
 * @param {ibsheet} sheet_obj mandatory IBSheet Object
 * @return void
 * @author 
 * @version 2009.04.17
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * initializing sheet <br>
 * implementing onLoad event handler in body tag <br>
 * adding first-served functions after loading screen. <br>
 * <br><b>Example :</b>
 * <pre>
 *     loadPage();
 * </pre>
 * @return void
 * @author 
 * @version 2009.04.17
 */
function loadPage() {
    for(i=0;i<sheetObjects.length;i++){
    //Modify Environment Setting Function's name
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
    // Add Environment Setting Function 
        ComEndConfigSheet(sheetObjects[i]);
    } 
    resizeSheet();
    loadSts=true;
    parent.loadTabPage();
}
// /**
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
//	 parent.loadTabPage();
//}   
/**
 * setting sheet initial values and header <br>
 * adding case as numbers of counting sheets  <br>
 * <br><b>Example :</b>
 * <pre>
 *     initSheet(sheetObj,1);
 * </pre>
 * @param {ibsheet} sheetObj mandatory IBSheet Object
 * @param {int} sheetNo mandatory IBSheet Object Serial No
 * @return void
 * @author 
 * @version 2009.04.17
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
	 var sheetID=sheetObj.id;
    switch(sheetID) {
        case "sheet1":
			with(sheetObj){
				var HeadTitle1="|Seq.|Duration|Duration|Effective Date|Expiry Date|Source|Status|Accept Staff/Team|Accept Date||";
				var headCount=ComCountHeadTitle(HeadTitle1);
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				 {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
				 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ctrt_eff_dt",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ctrt_exp_dt",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eff_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"exp_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"src_info_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"prc_prog_sts_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:0,   SaveName:"acpt_usr_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"amdt_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n1st_cmnc_amdt_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
				   
				InitColumns(cols);
				resizeSheet(); //SetSheetHeight(300);
				SetEditable(0);
				SetWaitImageVisible(0);
			}
            break;
    }
}

function resizeSheet() {
    ComResizeSheet(sheetObjects[0]);
}

/**
 * Handling sheet's processes <br>
 * <br><b>Example :</b>
 * <pre>
 *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
 * </pre>
 * @param {ibsheet} sheetObj mandatory IBSheet Object
 * @param {form} formObj mandatory html form object
 * @param {int} sAction mandatory,Constant Variable
 * @return void
 * @author 
 * @version 2009.04.17
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    try{
        switch(sAction) {	
		    case IBSEARCH: // retrieving
		    	ComOpenWait(true); //->waiting->start
		    	formObj.f_cmd.value=SEARCH;
		    	sheetObj.DoSearch("ESM_PRI_0057_01GS.do", FormQueryString(formObj) );
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
  * handling process for input validation <br>
  * <br><b>Example :</b>
  * <pre>
  *     if (validateForm(sheetObj,document.form,IBSAVE)) {
  *        handling logic
  *     }
  * </pre>
  * @param {ibsheet} sheetObj mandatory IBSheet Object
  * @param {form} formObj mandatory html form object
  * @param {int} sAction mandatory,Constant Variable
  * @returns bool <br>
  *          true  : valid<br>
  *          false : inValid
  * @author 
  * @version 2009.04.17
  */
 function validateForm(sheetObj,formObj,sAction){
	switch (sAction) {
	case IBSEARCH: // retrieving		
  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
			return false;
		}
		break;    
	}
   return true;
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
		var formObj=document.form;
		formObj.eff_dt.value=sheetObj.GetCellValue(sheetObj.RowCount(),"eff_dt");
		var sCols="";
		searchEndFontChange(sheetObj, sCols, formObj.lgcy_if_flg.value);
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
  * @param {string} sLgcyIfFlg Mandatory lgcy_if_flg value  
  * @return void
  * @author 
  * @version 2009.05.21
  */ 
 function tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sConChk, sLgcyIfFlg) {
 	var formObject=document.form;
 	if (formObject.prop_no.value != sPropNo || formObject.amdt_seq.value != sAmdtSeq || formObject.svc_scp_cd.value != sSvcScpCd) {
 		formObject.prop_no.value=sPropNo;
 		formObject.amdt_seq.value=sAmdtSeq;
 		formObject.svc_scp_cd.value=sSvcScpCd;
 		formObject.lgcy_if_flg.value=sLgcyIfFlg;
 		doActionIBSheet(sheetObjects[0], document.form,IBSEARCH); 		
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
	formObject.svc_scp_cd.value="";	
	sheetObjects[0].RemoveAll();
}
var enableFlag=true;
/**
 * Calling function from main<br>
 * Prohibiting from adding,modifying,deleting in case of Confirmation=YES<br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * tabEnableSheet(flag)
 * </pre>
 * 
 * @param {boolean}
 *            flag Mandatory. Pass it from Main window
 * @return void
 * @author 
 * @version 2009.04.17
 */
function tabEnableSheet(flag) {
	var formObject=document.form;	
	enableFlag=flag;	
	sheetObjects[0].SetEditable(flag);
}
// Variable to check whether page loading is completed (At main.)
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