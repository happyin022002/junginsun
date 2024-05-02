/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAR_1003.js
*@FileTitle  : Outstanding history Inquiry by Date 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
/**
 * [STM_SAR-1003] Outstanding history Inquiry by Date
 * @extends
 * @class Outstanding history Inquiry by Date 
 */
// ===================================================================================
// global variable
// ===================================================================================
// IBSheet 
var sheetObjects=new Array();
var comboObjects=new Array();   
var sheetCnt=0;
var comboCnt=0;
var sheet1=null;
// html form
var frm=null;
/**
 * IBSheet Object를 배열로 등록
 * @param {ibsheet} sheetObj    IBSheet Object  
 **/
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}

/** 
 * registering IBCombo Object as list
 * param : combo_obj
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */ 
function setComboObject(combo_obj) {  
    comboObjects[comboCnt++]=combo_obj;  
}
// ===================================================================================
// initializing
// ===================================================================================
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 **/
function loadPage() {
    //global variable set 
    frm=document.form;
    sheet1=sheetObjects[0];
    sheetCnt=sheetObjects.length ;
    //sheet initialize
    for(var i=0 ; i < sheetCnt ; i++) {
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);              
    }
    
    for(var k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],k+1);
	}
    //Form event register
    doActionIBSheet(IBSEARCH_ASYNC01);
    initControl();
    doActionIBSheet(SEARCHLIST);
}


/**
 * @param {IBMultiCombo} comboObj comboObj
 * @return none
 * @see #
 * @author
 * @version 2014 04 02
 */
function initCombo(comboObj, comboNo) { 
	switch (comboObj.options.id) {
	   case "curr_cd":
			with (comboObj) { 
		   		ValidChar(2); 
			}
            break;	
	}
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	with (sheetObj) {
		switch (sheetObj.id) {
		case "sheet1": 
	       
	        var HeadTitle1="|Office|IF Date|Transaction Type|CUR|Amount|G/L Date|Ref No|Transaction Source|Revenue Type|Remark|User ID";
	        var headCount=ComCountHeadTitle(HeadTitle1);

	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

	        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);

	        var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
	               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"inv_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
	               {Type:"Text",      Hidden:0,  Width:120,   Align:"Center",  ColMerge:1,   SaveName:"if_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
	               {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"ots_his_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
	               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
	               {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"ots_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
	               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"gl_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
	               {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"ref_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
	               {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"tj_src_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
	               {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"rev_tp_src_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
	               {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:"ots_rmk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
	        	   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 } ];
	         
	        InitColumns(cols);

	        SetEditable(0); 
	        SetColProperty("gl_dt", {Format:"####-##-##"} ); 
	        SetSheetHeight(340);


			break;
		}
	}
}
// ===================================================================================
// Private function
// ===================================================================================
 /**
  * handling process for input validation
  */
 function validateForm() {
	 if (!ComChkObjValid(frm.cond_dt)) {
		 return false;
	 }
     return true;
 }
// ===================================================================================
// Form Event Processing
// ===================================================================================
// Button event handler
document.onclick=processButtonClick;
/**
 * Button event handler function
 */
function processButtonClick() {
	var srcName=ComGetEvent("name");
	if(ComGetBtnDisable(srcName)) return false;
	var chkALL=frm.chkALL;
	var chkBRH=frm.chkBRH;
	var chkAGT=frm.chkAGT;
	switch (srcName) {
	case "btn_cond_dt": //calendar from
		var cal=new ComCalendar();
        cal.select(frm.cond_dt, 'yyyy-MM-dd');
		break;	
	case "btn_search":		
		doActionIBSheet(SEARCHLIST);
		break;			
	case "btn_excel":
		if (sheet1.RowCount()<= 0 ) {
			// msgs["SAR00030"] = "There is no data to search.";
			ComShowCodeMessage("SAR00030");
			return false;
		}
		sheet1.Down2Excel({ HiddenColumn:{HiddenColumn:1}});
		break;		
	case "btn_close":
		ComClosePopup(); 
		break;
	}
}
/**
 * Form Event register
 */
function initControl() {
    //keypress
   // axon_event.addListenerForm('keypress', 'obj_keypress', frm);        
    // focus in
    //axon_event.addListenerFormat('beforeactivate', 'obj_activate',    frm);
    //axon_event.addListenerFormat('change', 'obj_change', frm);
  //  axon_event.addListenerFormat ('keydown', 'obj_keydown', frm);
}

//===================================================================================
//Sheet Event
//===================================================================================
//===================================================================================
//do Action Processing 
//===================================================================================
/**
 * Do action 
 * @param {string} sAction
 */
function doActionIBSheet(sAction) {
	if (sAction == SEARCHLIST) {	
		if (validateForm()) {
			sheet1.WaitImageVisible=false;
			ComOpenWait(true); 
			setTimeout( function () {
				frm.f_cmd.value=SEARCHLIST;		
	 			var sXml=sheet1.GetSearchData("STM_SAR_1003GS.do", FormQueryString(frm));
				sheet1.LoadSearchData(sXml,{Sync:0} );
				ComOpenWait(false);  
		    } , 100);	
				
		}
	} else if(sAction == IBSEARCH_ASYNC01){
		//retrieve Currency Code
		frm.f_cmd.value=SEARCH08;
		var sXml=sheetObj.GetSearchData("SARCommonGS.do", FormQueryString(frm));
		var sStr=ComGetEtcData(sXml,"curr_cd_list");
		var arrStr=sStr.split("|");
		MakeCurrCdComboObject(curr_cd, arrStr); 
	}
}

/**
 * create combo box<br>
 * <br><b>Example : </b>
 * <pre>
 *    MakeCurrCdComboObject(cmbObj, arrStr);
 * </pre>
 * @param object cmbObj
 * @param String arrStr
 * @author Park sung yong
 * @version 2014.03.24
 */
function MakeCurrCdComboObject(cmbObj, arrStr) {
	cmbObj.InsertItem(0, 'ALL', '');	
	for (var i=1; i < arrStr.length; i++ ) {
		cmbObj.InsertItem(i, arrStr[i], arrStr[i]);			 
	}
	cmbObj.SetDropHeight(190);
	cmbObj.SetSelectIndex(0, false);

}  
