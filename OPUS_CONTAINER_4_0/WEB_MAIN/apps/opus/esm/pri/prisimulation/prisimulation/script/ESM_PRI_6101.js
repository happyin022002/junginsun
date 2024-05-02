/*
 *=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_PRI_6101.js
 *@FileTitle  : Find Contract
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/12/10
 *=========================================================
 */

/****************************************************************************************
*<Usage>
* Call Contract Info Popup
ComOpenPopup("/opuscntr/ESM_PRI_6101.do?peff_dt=2014-12-01", 1048, 700, "callBackCntrInfo", '1,0', true);

* CallBack
* CntrType(S/C,RFA,TAA), CntrNo(Contract Number) 
function callBackCntrInfo (returnObj) {
	if(returnObj != null){
		var cntrNo = returnObj.CntrNo;

    }  
}

 ***************************************************************************************/

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
var gcbo_svc_scp;
var gcbo_cgo_tp;
var gcbo_scp_srep;
var gcustelement;

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

    for(var k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],k+1);
    }
    
    for(i=0;i<sheetObjects.length;i++){
        //Modify Environment Setting Function's name
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        //Add Environment Setting Function
        ComEndConfigSheet(sheetObjects[i]);
    }
    
    //Set Combo Object
    gcbo_svc_scp 	= comboObjects[0];
    gcbo_cgo_tp 	= comboObjects[1];
    gcbo_scp_srep 	= comboObjects[2];
    //Set Sheet Object
    gSheetObj      	= sheetObjects[0];
    
    //Set the initial value on the form objects
    initFormControls();
    
    // Axon Event Initialize
    initControl();
    
    
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
 * initializing combo, header <br>
 * adding case in case of multiple combo <br>
 */
function initCombo(comboObj, code) {
    switch (comboObj.options.id) {
        // svc scope
        case "ssvc_scp_cd":
            var i=0;
            with (comboObj) {
                SetDropHeight(200);
                SetUseAutoComplete(1);
                ValidChar(2);
                SetMaxLength(3);
            }
            break;
    
            // cargo type
        case "sprc_cgo_tp_cd":
            var i=0;
            with (comboObj) {
                SetDropHeight(200);
                SetUseAutoComplete(1);
                ValidChar(2);
                SetMaxLength(2);
            }
            break;
            //customer type
        case "sprc_ctrt_cust_tp_cd":
            var i=0;
            with (comboObj) {
                SetDropHeight(200);
                SetUseAutoComplete(1);
            }
            break;
          
    }
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
                var HeadTitle="Seq.|Contract\nType|Contract No.|Customer|Actual Customer|Sales Rep|Commodity|Origin|Origin Via|Dest Via|Dest|Cargo\nType";
                var headCount=ComCountHeadTitle(HeadTitle);
                
                SetConfig( { MergeSheet:1, Page:20} );
                
                var info    = { Sort:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [
                            {Type:"Seq",    	Hidden:0, 	Width:40,   Align:"Center", 	ColMerge:0, SaveName:"seq"		},
                            {Type:"Text",   	Hidden:0, 	Width:60,   Align:"Center", 	ColMerge:0, SaveName:"cntr_tp",			KeyField:0, CalcLogic:"",   Format:"",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",   	Hidden:0, 	Width:80,   Align:"Center", 	ColMerge:0, SaveName:"cntr_no",			KeyField:0, CalcLogic:"",   Format:"",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",   	Hidden:0, 	Width:200,  Align:"Left", 		ColMerge:0, SaveName:"cust_nm", 		KeyField:0, CalcLogic:"",   Format:"",          PointCount:0,   UpdateEdit:0,   InsertEdit:0, ToolTip:1 },
                            {Type:"Text",  		Hidden:0, 	Width:200,  Align:"Left", 		ColMerge:0, SaveName:"act_cust_nm",     KeyField:0, CalcLogic:"",   Format:"",         	PointCount:0,   UpdateEdit:0,   InsertEdit:0, ToolTip:1 },
                            {Type:"Text", 		Hidden:0, 	Width:60,   Align:"Center", 	ColMerge:0, SaveName:"srep_cd",   		KeyField:0, CalcLogic:"",   Format:"",			PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text", 		Hidden:0, 	Width:105,  Align:"Left", 		ColMerge:0, SaveName:"cmdt_nm",   		KeyField:0, CalcLogic:"",   Format:"",   		PointCount:0,   UpdateEdit:0,   InsertEdit:0, ToolTip:1 },
                            {Type:"Text",    	Hidden:0, 	Width:105,  Align:"Left", 		ColMerge:0, SaveName:"org_cd",   		KeyField:0, CalcLogic:"",   Format:"",   		PointCount:0,   UpdateEdit:0,   InsertEdit:0, ToolTip:1 },
                            {Type:"Text",   	Hidden:0, 	Width:105,  Align:"Left", 		ColMerge:0, SaveName:"org_via_cd",		KeyField:0, CalcLogic:"",   Format:"",          PointCount:0,   UpdateEdit:0,   InsertEdit:0, ToolTip:1 },
                            {Type:"Text",    	Hidden:0, 	Width:105,  Align:"Left", 		ColMerge:0, SaveName:"dest_via_cd",  	KeyField:0, CalcLogic:"",   Format:"",   		PointCount:0,   UpdateEdit:0,   InsertEdit:0, ToolTip:1 },
                            {Type:"Text",   	Hidden:0, 	Width:105,  Align:"Left", 		ColMerge:0, SaveName:"dest_cd",			KeyField:0, CalcLogic:"",   Format:"",          PointCount:0,   UpdateEdit:0,   InsertEdit:0, ToolTip:1 },
                            {Type:"Text",   	Hidden:0, 	Width:70,   Align:"Center", 	ColMerge:0, SaveName:"prc_cgo_tp_cd",	KeyField:0, CalcLogic:"",   Format:"",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
                ];
                   
                InitColumns(cols);

                SetEditable(0);		//All Cell <none-Editible>
                SetSelectionMode(1);//select <Row> Mode
                SetAutoRowHeight(0);//fix One Row Height
                resizeSheet();
                //SetSheetHeight(500);
            }
            break;

   
    }
}

/**
 * Set the initial value on the form objects  <br>
 * @return void
 */
function initFormControls() {
	//get from opener by parameter
	//$("#seff_dt").val(setInitDate());
	
	initIBComboItem();
}

/**
 * setting Item in IBMultiCombo<br>
 */
function initIBComboItem() {
    ComPriTextCode2ComboItem(svcScpCdComboValue,     svcScpCdComboText,    	getComboObject(comboObjects, 'ssvc_scp_cd'),       	 "|", "\t" );      
    ComPriTextCode2ComboItem(cargoTypeComboValue,    cargoTypeComboText,    getComboObject(comboObjects, 'sprc_cgo_tp_cd'),       "|", "\t" );    
    ComPriTextCode2ComboItem(customerTypeComboValue, customerTypeComboText, getComboObject(comboObjects, 'sprc_ctrt_cust_tp_cd'), "|", "\t" );     
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
	    if(ComGetBtnDisable(srcName)) return false;
      	switch(srcName) {
      	    //Popup buttons ========================
	  		case "btn_sctrt_cust":
	  			var tmpCust    = $("#sctrt_cust").val();
	  			var tmpCustSeq = $("#sctrt_cust_seq").val();
	  			var cust = getCustCode(tmpCust,tmpCustSeq);
	        	gcustelement = "sctrt_cust";
	        	ComOpenPopup("/opuscntr/COM_ENS_041.do?cust_cd="+cust, 770, 470, "callBackCustInfo", '1,0,1,1,1,1,1', true);
	  			break;
	  		
	  		case "btn_scust":
	  			var tmpCust    = $("#scust").val();
	  			var tmpCustSeq = $("#scust_seq").val();
	  			var cust = getCustCode(tmpCust,tmpCustSeq);
	        	gcustelement = "scust";
	        	ComOpenPopup("/opuscntr/COM_ENS_041.do?cust_cd="+cust, 770, 470, "callBackCustInfo", '1,0,1,1,1,1,1', true);
	  			break;
	  		
	  		case "btn_sprop_scp_ofc":
	  			ComOpenPopupWithTarget('/opuscntr/COM_ENS_071.do', 800, 500, "ofc_cd:sprop_scp_ofc_cd", "1,0,1,1,1,1,1,1", true);
	  			break;	
	  			
	  		//Main buttons ========================
	  		case "btn_close":
	  			ComClosePopup();
    	        break;
	  		case "btn_Ok":
	  			setParentValue(gSheetObj);
    	        break;
	  		case "btn_New":
	            gSheetObj.RemoveAll();
	            gFormObj.reset();
	            $("#seff_dt").val(setInitDate());
    	        break;
	  		case "btn_retrieve":
	  			doActionIBSheet(gSheetObj,gFormObj,IBSEARCH);
    	        break;
    	        
    	    //ETC buttons calendar ========================
            case "btns_calendar1": 
	            var cal=new ComCalendar();                
	            cal.select(gFormObj.seff_dt, 'yyyy-MM-dd');
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
 * calling function in case of OnDbClick event <br>
 * <br><b>Example :</b>
 * <pre>
 *    
 * </pre>
 * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
 * @param {int} Row mandatory Onclick ,Cell's Row Index
 * @param {int} Col mandatory Onclick ,Cell's Column Index
 * @returns void
 * @author 
 * @version 2009.04.29
 */ 
function sheet1_OnDblClick(sheetObj, Row, Col) {
    try{
    	setParentValue(sheetObj);
    	return false;
    }catch(e){}
}

/**
 * send the object contained the selected contract infomaton to caller <br>
 * <br><b>Example :</b>
 * <pre>
 *    
 * </pre>
 * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
 * @returns {object} : CntrType(S/C,RFA,TAA), CntrNo, 
 * @author 
 * @version 2009.04.29
 */ 
function setParentValue(sheetObj) {
	var rtnObject=new Object(); 
	var Row=sheetObj.GetSelectRow();
	if(Row < 1) {
		ComShowCodeMessage("PRI04006");
		return;
	}
	
	rtnObject.CntrType=sheetObj.GetCellValue(Row, "cntr_tp");
	rtnObject.CntrNo=sheetObj.GetCellValue(Row, "cntr_no");

	
	ComPopUpReturnValue(rtnObject);
}


/**
* make full cust code  <br>
* @return {String} customer code
* @version 2014.12.10
*/
function getCustCode(custObjVal, custSeqObjVal) {
	var cust 		= "";
	
	if(isNotEmpty(custObjVal) && isNotEmpty(custSeqObjVal)) {
		cust      	= custObjVal + custSeqObjVal;
	} else if(isNotEmpty(custObjVal) && !isNotEmpty(custSeqObjVal)) {
		cust      	= custObjVal;
	}
	
	return cust;
}

/**
* set the customer value on the cust and seq tag from the return value of the Customer Inquiery  <br>
* @return {String} customer code
* @version 2014.12.10
*/
function callBackCustInfo(rArray){
    if(rArray != null){
        var colArray=rArray[0];
        var ctrtCustCntCd=colArray[3].substring(0,2); 
        var ctrtCustSeq=ComLpad(colArray[3].substring(2),6,"0");
        
        $("#"+gcustelement).val(ctrtCustCntCd);
        $("#"+gcustelement+"_seq").val(ctrtCustSeq);
    }                   
}




/**
 * Calling Function in case of OnChange event <br>
 * Showing description by svc_scp_cd value <br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param {object} comboObj Mandatory IBMultiCombo Object
 * @param {string} value Mandatory, value of selected item
 * @param {string} text Mandatory selected item's text
 * @returns void
 * @author 
 * @version 2009.06.04
 */
function ssvc_scp_cd_OnChange(comboObj, OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {

    if (NewTxt != null && NewTxt.length > 0) {
    	$("#ssvc_scp_nm").val(comboObj.GetText(NewCod, 1));
    } else {
    	$("#ssvc_scp_nm").val("");      	
    }

}

/**
  * calling function in case of OnKeyDown event in IBMultiCombo   <br>
  * When Enter Key pressed, Retrieve again. <br>
  * <br><b>Example :</b>
  * <pre>
  *
  * </pre>
  * @param   {object} comboObj Mandatory IBMultiCombo Object
  * @param   {string} KeyCode Mandatory Ascii code Value
  * @param   {string} Shift   Displaying whether Mandatory shift is keyup
  * @returns void
  * @author  
  * @version 2009.06.04
  */          
function ssvc_scp_cd_OnKeyDown(comboObj,KeyCode, Shift) {
    if (KeyCode == 13){
        doActionIBSheet(gSheetObj, gFormObj, IBSEARCH);
    }
}


/**
 * Handling Onbeforedeactivate  event <br>
 * <br><b>Example :</b>
 * <pre>
 *     obj_deactivate()
 * </pre>
 * @param N/A
 * @return N/A
 * @author 
 * @version 2014.12.10
 */   
 function obj_deactivate() {
	 var obj=event.srcElement;
     var eleName=ComGetEvent("name");
     switch(eleName){
	     case "sctrt_cust_seq":
	    	 var objVal = $("#"+eleName).val();
	         if (objVal.length < 6 && objVal.length != 0 ){
	        	 obj.value=ComLpad(objVal, 6, "0");
	         }
	         break;
	     case "scust_seq":
	    	 var objVal = $("#"+eleName).val();
	         if (objVal.length < 6 && objVal.length != 0 ){
	        	 obj.value=ComLpad(objVal, 6, "0");
	         }
	         break;
         default:
        	 break;

     }
	 
	 
}
 




//-------------------------------------
//User Function Area
//-------------------------------------

/**
 * Check whether the object's value is null or not  <br>
 * @param {object} object
 * @return {bool} true/false
 */
function isNotEmpty(val) {
	var result = false;
	
	if(val != null && val != undefined && val != "" ) {
		result = true;
	}
	
	return result;
}


/**
 * get today.<br> 
 * @return N/A
 * @version 2014.12.10
 */
function setInitDate() {
	//DEFAULT SEARCH DATE SET
    var rDate = new Date();
    var yy = rDate.getFullYear();
    var mm = rDate.getMonth() + 1 +"";
    var dd = rDate.getDate() +"";
    if (mm.length == 1) mm = "0" + mm;
    if (dd.length == 1) dd = "0" + dd;  
    return ComGetMaskedValue(yy+mm+dd,"ymd","-");
}

/**
 * resize sheet.<br> 
 * @return N/A
 * @version 2014.12.10
 */
function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
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
    //------------------------------------
        
       
    case IBSEARCH: // Save
    	
    	if (ComTrim(ssvc_scp_cd.GetSelectCode()) == "" ){
    		ComShowCodeMessage("PRI01029");
    		ssvc_scp_cd.Focus();
    		return false;
       	}
    	if (ComTrim(formObj.seff_dt.value) == "" ){
    		ComShowCodeMessage("PRI01042", "Access Date");
    		formObj.seff_dt.focus();
    		return false;
       	}
    	if (ComTrim(formObj.sctrt_cust.value) == "" || ComTrim(formObj.sctrt_cust_seq.value) == "" ){
    		ComShowCodeMessage("PRI01042", "Customer");
    		if (ComTrim(formObj.sctrt_cust.value) == "") {
    			formObj.sctrt_cust.focus();
    			return false;
    		}
    		if (ComTrim(formObj.sctrt_cust_seq.value) == "") {
    			formObj.sctrt_cust_seq.focus();
    			return false;
    		}
    		
       	}

        break;
        
        
      //------------------------------------    
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
            	searchContractInfo();
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




/**
 *  search the custer name <br>
 * @param {ibsheet} sheetObj Mandatory IBSheet Object
 * @param {integer} sheetObj Row index
 * @param {string}  sheetObj Cell Value
 * @return {string} customer name
 * @version 2014.11.18
 */ 
function searchContractInfo() {

	gFormObj.f_cmd.value=SEARCH;
	var param = FormQueryString(gFormObj);
	gSheetObj.DoSearch("ESM_PRI_6101GS.do" , param);
	
}
