/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0004_01.js
*@FileTitle  : S/C Proposal Org/Dst Location Infomation - Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event code: [Initial]INIT=0; [ADD]ADD=1; [SEARCH]SEARCH=2; [SEARCHLIST]SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					Other extra variable  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// common global variables
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var tabLoad=new Array();
tabLoad[0]=0;
tabLoad[1]=0;
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
 * @version 2009.10.28
 */
function processButtonClick(){
     var sheetObject1=sheetObjects[0];
     var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		
        switch(srcName) {
			case "btn_retrieve":
				if(validateForm(sheetObject1,formObject,IBSEARCH)) {
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
				} 
			break;
        } // end switch
	}catch(e) {
		if (e == "[object Error]") {
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
 * @version 2009.10.28
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
 * @version 2009.05.17
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
    initControl(); 
	loadSts=true;
    parent.loadTabPage();
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
 * @version 2009.05.22
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
	 var sheetID=sheetObj.id;
    switch(sheetID) {
        case "sheet1":
            with(sheetObj){
	          var HeadTitle="|Sel.|Seq.|amdt_seq|rout_pnt_seq|Location Type|Location Code|Description|EFF Date|EXP Date|Source|Status|Accept Staff/Team|Accept Date" +
	          "|1|2|3|4|5|6";
	          var headCount=ComCountHeadTitle(HeadTitle);
	
	          SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	          var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
	          var headers = [ { Text:HeadTitle, Align:"Center"} ];
	          InitHeaders(headers, info);
	
	          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
	                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
	                 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq" },
	                 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_seq" },
	                 {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
	                 {Type:"Text",      Hidden:0,  Width:270,  Align:"Left",    ColMerge:0,   SaveName:"rout_pnt_loc_def_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:270,  Align:"Left",    ColMerge:0,   SaveName:"acpt_usr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
	                 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"prop_no" },
	                 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd" },
	                 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"src_info_dtl" },
	                 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_dtl" },
	                 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq" } ];
	           
	          InitColumns(cols);
	
	          SetEditable(0);
	          SetColProperty("rout_pnt_loc_tp_cd", {ComboText:LOCATION_TYPE1[1] ,ComboCode:LOCATION_TYPE1[0]} );
	          SetColProperty("src_info_cd", {ComboText:srcInfoCdComboText, ComboCode:srcInfoCdComboValue} );
	          SetColProperty("prc_prog_sts_cd", {ComboText:prcProgStsCdComboText, ComboCode:prcProgStsCdComboValue} );
	          SetWaitImageVisible(0);
	          SetColProperty(0 ,"rout_pnt_loc_def_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
	          //SetShowButtonImage(2);
	          resizeSheet(); //SetSheetHeight(290);
          }


             break;
    }
}

function resizeSheet() {
	ComResizeSheet(sheetObjects[0]);
}


function sheet1_OnSearchEnd(sheetObj , code, msg){
	ComOpenWait(false);
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
 * @version 2009.05.22
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
	try {
	    sheetObj.ShowDebugMsg(false);
	    switch(sAction) {
	     case IBSEARCH_ASYNC01: 
	 		ComOpenWait(true);
	    	formObj.f_cmd.value=SEARCH02;
	    	
 			var sXml=sheetObj.GetSearchData("ESM_PRI_0004_01GS.do" , FormQueryString(formObj));
			var arrData=ComPriXml2Array(sXml, "org_dest_tp_cd|amend_cnt");
			var origin=0;
			var destin=0;
			var oriRed=false;
			var destRed=false;
			if(arrData != null && arrData.length > 0) {
				for(var i=0; i<arrData.length; i++ ){
					if(arrData[i][0] == "D") {
						destin ++;
						if(arrData[i][1] > 0) {
							destRed=true;
						}
					} else {
						origin ++;
						if(arrData[i][1] > 0) {
							oriRed=true;
						}
					}
				}
			}
			if(origin == 0 && destin > 0) {
				formObj.org_dest_tp_cd[1].checked=true;
			} else {
				formObj.org_dest_tp_cd[0].checked=true;
			}
			if(origin > 0) {
				document.getElementById("org_dest_tp_cd1").style.fontWeight="bold";
			} else {
				document.getElementById("org_dest_tp_cd1").style.fontWeight=""; 
			}
			if(destin > 0) {
				document.getElementById("org_dest_tp_cd2").style.fontWeight="bold";
			}else {
				document.getElementById("org_dest_tp_cd2").style.fontWeight="";
			}
			ComOpenWait(false);
			break;
	    case IBSEARCH: // retrieving
	     	formObj.f_cmd.value=SEARCH01;
			ComOpenWait(true);
 			sheetObj.DoSearch("ESM_PRI_0004_01GS.do", FormQueryString(formObj) );
			
			break;
	    }
	}catch(e){
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}finally {
		 ComOpenWait(false);
	}
}
 /**
	* registering IBTab Object as list <br>
	* adding process for list in case of needing batch processing with other items<br>
	* defining list on the top of source <br>
	* <br><b>Example :</b>
	* <pre>
	*     setTabObject(tab_obj);
	* </pre>
	* @param {ibtab} tab_obj Mandatory IBTab Object
	* @return void
	* @author 
	* @version 2009.10.28
	*/
function setTabObject(tab_obj){
    tabObjects[tabCnt++]=tab_obj;
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
 * Loading HTML control's event on page dynamically<br>
 * <br><b>Example :</b>
 * @return void
 * @author 
 * @version 2009.04.17
 **/
function initControl() {    	
	// Process Axon Event No.1, Event Catch 
	axon_event.addListenerForm  ('click', 'obj_OnClick', form); 
}
 /**
  * Check validation on onClick event of HTML Control. <br>
  * @return void
  * @author 
  * @version 2009.04.17
 **/
function obj_OnClick(){
	var sheetObj=sheetObjects[0];
	var formObj=document.form;
	if (event.srcElement.name == "org_dest_tp_cd") {   	   			
		formObj.org_dest_tp_cd.value=ComGetObjValue(formObj.org_dest_tp_cd);
		doActionIBSheet(sheetObj, formObj, IBSEARCH);
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
  * @return void
  * @author 
  * @version 2009.05.21
  */ 
 function tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sConChk) {
 	var formObject=document.form;
 	if (formObject.prop_no.value != sPropNo || formObject.amdt_seq.value != sAmdtSeq || formObject.svc_scp_cd.value != sSvcScpCd) {
 		formObject.prop_no.value=sPropNo;
 		formObject.amdt_seq.value=sAmdtSeq;
 		formObject.svc_scp_cd.value=sSvcScpCd;
 		formObject.con_chk.value=sConChk;
		document.getElementById("org_dest_tp_cd1").style.fontWeight="";
		document.getElementById("org_dest_tp_cd1").style.color="black";  	  			
		document.getElementById("org_dest_tp_cd2").style.fontWeight="";
		document.getElementById("org_dest_tp_cd2").style.color="black";
		//doActionIBSheet(sheetObjects[0], document.form,IBCLEAR); 
		// When page loading, Automatically select Route type that has data.
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
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
}
var loadSts=false;
/**
  * Calling function from main<br>
  * Prohibiting from adding,modifying,deleting in case of Confirmation=YES<br>
  * <br><b>Example :</b>
  * <pre>
  * tabEnableSheet(flag)
  * </pre>
  * @param {boolean} flag Mandatory from Main screen
  * @return void
  * @author 
  * @version 2009.04.17
  */
function loadFinishCheck(){
    return loadSts;
}     
