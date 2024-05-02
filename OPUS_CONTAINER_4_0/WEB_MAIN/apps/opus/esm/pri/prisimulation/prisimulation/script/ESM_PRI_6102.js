/*
 *=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_PRI_6102.js
 *@FileTitle  : Revenue Detail
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/12/10
 *=========================================================
 */

/****************************************************************************************
  Event code: [Initial]INIT=0; [ADD]ADD=1; [SEARCH]SEARCH=2; [SEARCHLIST]SEARCHLIST=3;
                    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                    Other extra variable  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/


var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;

var gFormObj;
var gSheetObj;

//-------------------------------------
//Event handler processing by button click event
//-------------------------------------
document.onclick=processButtonClick;

//-------------------------------------
//Init Area
//-------------------------------------
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
* @version 2014.12.10
*/
function loadPage() {
	
	if (!opener) opener = window.dialogArguments;
	if (!opener) opener = window.opener;
	if (!opener) opener = parent;
	
	//Set Form Object
	gFormObj = document.form;

	for(i=0;i<sheetObjects.length;i++){
        //Modify Environment Setting Function's name
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        //Add Environment Setting Function
        ComEndConfigSheet(sheetObjects[i]);
    }
    
    //Set Sheet Object
    gSheetObj      	= sheetObjects[0];
    // Axon Event Initialize
    initControl();
    doActionIBSheet(gSheetObj, gFormObj, IBSEARCH);
}

//-------------------------------------
//Common Function Area for Init
//-------------------------------------
/**
* registering IBSheet Object as list <br>
* <pre>
*     setSheetObject(sheetObj);
* </pre>
* @param {ibsheet} sheet_obj mandatory IBSheet Object
* @return void
* @author 
* @version 2014.12.10
*/
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}

/**
* registering IBCombo Object as list  <br>
* adding process for list in case of needing batch processing with other items  <br>
* defining list on the top of source <br>
*/
function setComboObject(combo_obj) {
    comboObjects[comboCnt++]=combo_obj;
}


/**
* Catching events for Axon event.<br>
* <br><b>Example :</b>
* <pre>
*     initControl()
* </pre>
* @param  void
* @return void
* @author 
* @version 2010.10.13
*/         
function initControl() {
	 // Process Axon Event No.1, Event Catch            
	 axon_event.addListenerForm('blur', 'obj_deactivate', document.form);
}

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
 * @version 2014.12.10
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    var sheetID=sheetObj.id;
    switch(sheetID) {
        case "sheet1":
            with(sheetObj){
                var HeadTitle="|Charge|Cur|Rate|Per|Rate As|Amount\n(Local Cur)|Ex. Rate|Amount\n(USD)|IN|Net Amount\n(USD)|Term|Cargo|Tariff Service Scope";
                var headCount=ComCountHeadTitle(HeadTitle);
                
                SetConfig( { MergeSheet:1, Page:20} );
                
                var info    = { Sort:1, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [
                            {Type:"Status",		Hidden:1,	Width:30,	Align:"Center",  	ColMerge:0, SaveName:"ibflag" },
                            {Type:"Text",   	Hidden:0, 	Width:80,   Align:"Center", 	ColMerge:0, SaveName:"chg_cd",			KeyField:0, CalcLogic:"",   Format:"",             UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",   	Hidden:0, 	Width:60,   Align:"Center", 	ColMerge:0, SaveName:"curr_cd",			KeyField:0, CalcLogic:"",   Format:"",             UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Float",   	Hidden:0, 	Width:90,   Align:"Right", 		ColMerge:0, SaveName:"chg_ut_amt", 		KeyField:0, CalcLogic:"",   Format:"Float",        UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",  		Hidden:0, 	Width:50,   Align:"Center", 	ColMerge:0, SaveName:"rat_ut_cd",     	KeyField:0, CalcLogic:"",   Format:"",         	   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text", 		Hidden:0, 	Width:70,   Align:"Right", 		ColMerge:0, SaveName:"rat_as_qty",   	KeyField:0, CalcLogic:"",   Format:"",			   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Float", 		Hidden:0, 	Width:90,   Align:"Right", 		ColMerge:0, SaveName:"chg_amt",   		KeyField:0, CalcLogic:"",   Format:"Float",   	   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Float",    	Hidden:0, 	Width:90,   Align:"Right", 		ColMerge:0, SaveName:"aply_xch_rto",   	KeyField:0, CalcLogic:"",   Format:"Float",   	   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Float",   	Hidden:0, 	Width:90,   Align:"Right", 		ColMerge:0, SaveName:"chg_amt_usd",		KeyField:0, CalcLogic:"",   Format:"Float",        UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",    	Hidden:0, 	Width:50,   Align:"Center", 	ColMerge:0, SaveName:"frt_incl_xcld_div_cd",  	KeyField:0, CalcLogic:"",   Format:"",     UpdateEdit:0,   InsertEdit:0 },
                            {Type:"AutoSum",   	Hidden:0, 	Width:90,   Align:"Right", 		ColMerge:0, SaveName:"net_amt_usd",		KeyField:0, CalcLogic:"",   Format:"",             UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",   	Hidden:0, 	Width:60,   Align:"Center", 	ColMerge:0, SaveName:"frt_term_cd",		KeyField:0, CalcLogic:"",   Format:"",             UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",   	Hidden:0, 	Width:70,   Align:"Center", 	ColMerge:0, SaveName:"cgo_tp_cd",		KeyField:0, CalcLogic:"",   Format:"",             UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",   	Hidden:0, 	Width:200,  Align:"Left", 		ColMerge:0, SaveName:"svc_scp_cd",		KeyField:0, CalcLogic:"",   Format:"",             UpdateEdit:0,   InsertEdit:0 }
                ];
                   
                InitColumns(cols);

                SetEditable(0);		//All Cell <none-Editible>
                SetSelectionMode(1);//select <Row> Mode
                SetAutoRowHeight(0);//fix One Row Height
                SetSheetHeight(500);
            }
            break;

   
    }
}

//-------------------------------------
//Event Area
//-------------------------------------
/**
* Event handler processing by button name  <br>
* <br><b>Example :</b>
* <pre>
*     processButtonClick();
* </pre>
* @return void
* @author 
* @version 2014.12.10
*/
function processButtonClick() {
  try {
	    var srcName=ComGetEvent("name");
      	switch(srcName) {
	  		case "btn_close":
	  			ComClosePopup();
    	        break;
      	}
  } catch (e) {
      if (e == "[object Error]") {
          ComShowMessage(OBJECT_ERROR);
      } else {
          ComShowMessage(e);
      }
  }
}


/**
 * handling process for input validation <br>
 * <br><b>Example :</b>
 * <pre>
 *     if (validateForm(sheetObj,document.form,IBSAVE)) {
 *         handling logic;
 *     }
 * </pre>
 * @param {ibsheet} sheetObj Mandatory IBSheet Object
 * @param {form} formObj Mandatory html form object
 * @param {int} sAction Mandatory ,Process Flag constant variable
 * @returns bool <br>
 *          true  : valid<br>
 *          false : invalid
 * @author 
 * @version 2014.12.10
 */
function validateForm(sheetObj, formObj, sAction) {

    switch (sAction) {
    case IBSEARCH: // Save
    	if (ComTrim(formObj.pctl_no.value) == "" || ComTrim(formObj.cntr_sz_cd.value) == "" || ComTrim(formObj.cmdt_cd.value) == "" ){
    		ComShowCodeMessage("COM132101");
    		return false;
       	}
        break;
    } //end switch
    
    return true;
} 

//-------------------------------------
//User Function Area - Data
//-------------------------------------
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
* @version 2014.11.18
*/
function doActionIBSheet(sheetObj, formObj, sAction) {
    try {

        switch (sAction) { 
        	//Main Button
            case IBSEARCH:
            	if(!validateForm(sheetObj, formObj, sAction)) {
            		return;
            	}
            	ComOpenWait(true);                  
                formObj.f_cmd.value=SEARCH;           
                var sXml=sheetObj.GetSearchData("ESM_PRI_6102GS.do", FormQueryString(formObj));
                sheetObj.LoadSearchData(sXml,{Sync:1} );
                break;              
        }
    }catch(e){
        if (e == "[object Error]") {
            ComShowMessage(OBJECT_ERROR);
        } else {
            ComShowMessage(e);
        }
    }finally {
         ComOpenWait(false);
    }
}


function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    sheetObj.SetSumText(0, "chg_cd", "TOTAL");
    sheetObj.SetSumText(0, "curr_cd", "USD");
    sheetObj.SetSumBackColor("#FFFF99")
}

