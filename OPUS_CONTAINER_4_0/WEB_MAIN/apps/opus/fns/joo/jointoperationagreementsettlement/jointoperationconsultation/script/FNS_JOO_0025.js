/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved
 *@FileName : FNS_JOO_0025.js
 *@FileTitle: CSR Inquiry
 *@author   : CLT
 *@version  : 1.0
 *@since    : 2014/06/18
 =========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
              MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
              OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class fns_joo_0025 : business script for fns_joo_0025
 */

// common global variable
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var prefix="sheet1_";
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	/***** setting sheet object *****/
	var sheetObj1=sheetObjects[0];
	/*******************************************************/
	var form=document.form;
	try {
		var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
		if (srcName == null || srcName == "gubun") {
			return;
		}
		// return in case class is btn1_1
		if (!JooBtnClickEnable(srcName)) {
			return;
		}
		switch (srcName) {
		case "btnCalFr":
			var cal=new ComCalendar();
			cal.setEndFunction("calFr"); 			
			cal.select(form.fr_dt, 'yyyy-MM-dd');
			break;
		case "btnCalTo":
			var cal=new ComCalendar();
			cal.setEndFunction("calTo"); 			
			cal.select(form.to_dt, 'yyyy-MM-dd');
			break;
		case "btn_retrieve":
			doActionIBSheet(sheetObj1, form, IBSEARCH);
			break;
		case "btn_downexcel":
			if(sheetObj1.RowCount() < 1){//no data
       		 ComShowCodeMessage("COM132501");
	   		}else{
	   			sheetObj1.Down2Excel({ HiddenColumn:1,Merge:1});
	   		}	
 			
			break;
		case "btn_new":
			sheetObj1.RemoveAll();
			form.gubun[0].checked=true;
			form.fr_dt.value=gSysDate;
			form.to_dt.value=gSysDate;
			auth_ofc_cd.SetSelectIndex(0);
			form.csr_no.value="";
			break;
		case "btn_csr":
			if (sheetObj1.GetSelectRow()== undefined || sheetObj1.GetSelectRow()== null){
				ComShowCodeMessage("JOO00072");
				return;
			}
			if (sheetObj1.RowCount()== 0){
				ComShowCodeMessage("JOO00073");
				return;
			}
			var row=sheetObj1.GetSelectRow();
			var csrNo=sheetObj1.GetCellValue(row, prefix+"csr_no");
			if (csrNo == ""){
				ComShowCodeMessage("JOO00074");
				return;
			}
			var param='?csrNo='+csrNo;
			//ComOpenPopup("/opuscntr/FNS_JOO_0024.do"+param, 835, 450, "popupFinish", "1,0,1,1,1,1,1,1", false, false, 0, 0, 0, "pop1");
			//ComOpenPopup("/opuscntr/FNS_JOO_0024.do"+param, 835, 450, "popupFinish", "none", false, false, 0, 0, 0, "pop1");
			ComJooCsrDetailPopup(param, true, "CSR Detail Popup");
			break;
        case "btn_print":
            if (sheetObj1.GetSelectRow()== undefined || sheetObj1.GetSelectRow()== null){
                ComShowCodeMessage("JOO00072");
                return;
            }
            if (sheetObj1.RowCount()== 0){
                ComShowCodeMessage("JOO00073");
                return;
            }
            var row=sheetObj1.GetSelectRow();
            var csrNo=sheetObj1.GetCellValue(row, prefix+"csr_no");
            if (csrNo == ""){
                ComShowCodeMessage("JOO00074");
                return;
            }
            rdOpen(csrNo);
            break;
			
			//NYK Modify 2014.11.10
		case "btn_reject":
			if (sheetObj1.GetSelectRow()== undefined || sheetObj1.GetSelectRow()== null || sheetObj1.RowCount()== 0){
				ComShowCodeMessage("JOO00190"); //Please select CSR No. to CSR Reject.
				return;
			}
			var row=sheetObj1.GetSelectRow();
			var csrNo=sheetObj1.GetCellValue(row, prefix+"csr_no");
			var apRcvErrFlg=sheetObj1.GetCellValue(row, prefix+"ap_rcv_err_flg");
			if (csrNo == "" || apRcvErrFlg == "" || apRcvErrFlg != "E"){
				ComShowCodeMessage("JOO00191");//There is no CSR information to CSR Reject.
				return;
			}
			
			
			
			//alert("CSR Reject");
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * calling after selecting calendar
 * @return
 */
function calFr(){
	var form=document.form;
	sheetObjects[0].RemoveAll();
	doActionIBSheet(sheetObjects[0], form, IBROWSEARCH);
}
/**
 * calling after selecting calendar
 * @return
 */
function calTo(){
	var form=document.form;
	sheetObjects[0].RemoveAll();
	doActionIBSheet(sheetObjects[0], form, IBROWSEARCH);
}
/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
function setSheetObject(sheet_obj) {
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
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	//retriving only trade at the first time. retriving lane in case trade is changed.
    for(var k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],k+1);
    }
    initControl();
}
/**
 * loading HTML Control event <br>
 * {@link #loadPage} function call this. so IBSheet Object is initialized. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sequence number in sheetObjects array
 **/
function initControl() {
	//** Date Separator **/
	DATE_SEPARATOR="-";
	var form=document.form;   
	//axon_event.addListener  ('keypress', 'csr_no_keypress' , 'csr_no');		
	//axon_event.addListener  ('keyup', 'csr_no_keyup', 'csr_no');	
	//axon_event.addListener  ('blur', 'to_dt_blur', 'to_dt');
	axon_event.addListener  ('click', 'change_event_radio', 'gubun');  
    axon_event.addListenerForm  ('keyup', 'obj_keyup', form);   
}
function obj_keyup(){
    var eleObj=event.srcElement;
    var form=document.form;
    switch (eleObj.name) {
        case "csr_no":
            var val=ComGetEvent().value;
            var bPop=false;
            if (val.length == 19){
                sheetObjects[0].RemoveAll();
                if (ComIsNumber(val.substring(8,9))){
                    bPop=true;
                }
            }else if (val.length == 20){
                sheetObjects[0].RemoveAll();
                bPop=true;
            }
            if (bPop){
                var param='?csrNo='+val;
                ComOpenPopup("/opuscntr/FNS_JOO_0068.do"+param, 850, 500, "popupFinish1", "1,0,1,1,1,1,1,1", true, true);
            }
            break;
        case "fr_dt":
            var frDt=ComReplaceStr(form.fr_dt.value,"-","");
            if (frDt.length == 8){
                sheetObjects[0].RemoveAll();
                doActionIBSheet(sheetObjects[0], form, IBROWSEARCH);
            }
            break; 
        case "to_dt":
            var form=document.form;
            var toDt=ComReplaceStr(form.to_dt.value,"-",""); 
            if (toDt.length == 8){
                sheetObjects[0].RemoveAll();
                doActionIBSheet(sheetObjects[0], form, IBROWSEARCH);
            }
            break;
    }
}
//handling Axon event 2
/*function obj_blur(){
    ComChkObjValid(ComGetEvent());
}
function fr_dt_keypress(){
    ComKeyOnlyNumber(document.form.fr_dt);
}
function to_dt_keypress(){
    ComKeyOnlyNumber(document.form.to_dt);
}
function csr_no_keyup(){
	var val=ComGetEvent().value;
	var bPop=false;
	if (val.length == 19){
		sheetObjects[0].RemoveAll();
		if (ComIsNumber(val.substring(8,9))){
			bPop=true;
		}
	}else if (val.length == 20){
		sheetObjects[0].RemoveAll();
		bPop=true;
	}
	if (bPop){
		var param='?csrNo='+val;
		ComOpenPopup("/opuscntr/FNS_JOO_0068.do"+param, 850, 500, "popupFinish1", "1,0,1,1,1,1,1,1", true, true);
	}
}*/
/*function csr_no_keypress(){
    //converting upper case
    ComKeyOnlyAlphabet('uppernum');
}*/
function change_event_radio(){
	//var src = window.ComGetEvent().getAttribute("name")
	sheetObjects[0].RemoveAll();
	var form=document.form;
	doActionIBSheet(sheetObjects[0], form, IBROWSEARCH);
}
/*function fr_dt_keyup(){
	var form=document.form;
	var frDt=ComReplaceStr(form.fr_dt.value,"-","");
	if (frDt.length == 8){
		sheetObjects[0].RemoveAll();
		doActionIBSheet(sheetObjects[0], form, IBROWSEARCH);
	}
}
function to_dt_keyup(){
	var form=document.form;
	var toDt=ComReplaceStr(form.to_dt.value,"-",""); 
	if (toDt.length == 8){
		sheetObjects[0].RemoveAll();
		doActionIBSheet(sheetObjects[0], form, IBROWSEARCH);
	}
}*/
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch (sheetNo) {
	case 1: //t1sheet1 init
		with (sheetObj) {     
	        if (location.hostname != "")
	        var HeadTitle="Approval|Register No.|Off-set No.|Issue Date|Effective Date|Currency|Issue Amount|Issuer|Description|AP/AR Status|Reject Description|Reject Flag";
	        var headCount=ComCountHeadTitle(HeadTitle);
//	        (headCount, 0, 0, true);
	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );	
	        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	        var headers = [ { Text:HeadTitle, Align:"Center"} ];
	        InitHeaders(headers, info);
	
	        var cols = [ {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"apro_flg",         KeyField:0,   CalcLogic:"",   Format:"" },
		               {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"csr_no",           KeyField:0,   CalcLogic:"",   Format:"" },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"csr_offst_no",     KeyField:0,   CalcLogic:"",   Format:"" },
		               {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"slp_iss_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd" },
		               {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"eff_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd" },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"csr_locl_curr_cd", KeyField:0,   CalcLogic:"",   Format:"" },
		               {Type:"Float",     Hidden:0,  Width:95,   Align:"Right",   ColMerge:1,   SaveName:prefix+"csr_locl_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"issuer",           KeyField:0,   CalcLogic:"",   Format:"" },
		               {Type:"Text",      Hidden:0,  Width:250,   Align:"Left",    ColMerge:1,   SaveName:prefix+"csr_desc",         KeyField:0,   CalcLogic:"",   Format:"" },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:prefix+"inv_sts_cd",         KeyField:0,   CalcLogic:"",   Format:"" },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:prefix+"ap_rcv_err_rsn",         KeyField:0,   CalcLogic:"",   Format:"" },
		               {Type:"Text",      Hidden:1,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:prefix+"ap_rcv_err_flg",         KeyField:0,   CalcLogic:"",   Format:"" }];    
	        InitColumns(cols);
	        SetEditable(0);
//	        SetSheetHeight(530);
	        resizeSheet();
		}
		break;
	}
}
/**
 * setting Combo basic info 
 * param : comboObj, comboNo
 * initializing sheet 
 */ 
function initCombo(comboObj, comboNo) {
    var formObj=document.form
    switch(comboNo) {  
    	case 1: 
           with (comboObj) { 
				SetMultiSelect(0);
				SetUseAutoComplete(1);
				SetColAlign(0, "left");
				//SetColWidth(0, "30");
 				SetDropHeight(160);
 				ValidChar(2,1);//only upper case
 				SetMaxLength(6);
 		    }
            var comboItems=gAuthOfcCdComboItems.split("|");
            addComboItem(comboObj, comboItems);
            comboObj.SetSelectIndex(0,false);
            if (comboItems.length == 1){
            	comboObj.SetEnable(0);
            }else{
            	comboObj.SetEnable(1);
            }
 			break; 
 	} 
}
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	if(!validateForm(sheetObj,formObj,sAction)){
		return false;
	}
	switch (sAction) {
		case IBSEARCH: //retrieve
			formObj.f_cmd.value=SEARCH;
			var sXml=sheetObj.GetSearchData("FNS_JOO_0025GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			sheetObj.LoadSearchData(sXml,{Sync:1} );
			break;
		case IBROWSEARCH: //setting OFFICE LIST combo
			comboObjects[0].RemoveAll();
			formObj.f_cmd.value=SEARCHLIST01;
 			var sXml=sheetObj.GetSearchData("FNS_JOO_0025GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			var authOfcList=ComGetEtcData(sXml,"auth_ofc_cds");
			
			var comboItems=authOfcList.split("|");
            addComboItem(comboObjects[0], comboItems);
            comboObjects[0].SetSelectIndex(0,false);
            if (comboItems.length == 1){
                comboObjects[0].SetEnable(0);
            }else{
                comboObjects[0].SetEnable(1);
            }
			break;
		case IBDOWNEXCEL: // excel download
 			sheetObj.Down2Excel({ HiddenColumn:1});
			break;
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
		case IBROWSEARCH:
			var frDt=ComReplaceStr(formObj.fr_dt,"-","");
			if (!ComIsDate(frDt,"ymd")){
				return false;
			}
			var toDt=ComReplaceStr(formObj.to_dt,"-","");
			if (!ComIsDate(toDt,"ymd")){
				return false;
			}
			if (ComGetDaysBetween(frDt, toDt) < 0){
				return false;
			}					
			break;
		case IBSEARCH: //retrieve
			var frDt=ComReplaceStr(formObj.fr_dt,"-","");
			var toDt=ComReplaceStr(formObj.to_dt,"-","");
			if (ComGetDaysBetween(frDt, toDt) < 0){
				ComShowCodeMessage("JOO00078");
//				formObj.to_dt.focus();
				return false;
			}
			break;
	}
	return true;
}
function sheet1_OnSearchEnd(sheetObj, errMsg){
	if (sheetObj.RowCount()> 0) {
		JooSetBtnClass("P", true); // activating CSR Detail, Print button in case of existing data
	} else {
		JooSetBtnClass("P", false);// deactivating CSR Detail, Print button in case of existing data
	}	
}
/**
 * double Click
 * @param sheetObj
 * @param Row
 * @param Col
 * @param CellX
 * @param CellY
 * @param CellW
 * @param CellH
 * @return
 */
function sheet1_OnDblClick(sheetObj, Row, Col) {
    var param='?csrNo='+sheetObj.GetCellValue(Row, prefix+"csr_no");
	ComOpenPopup("/opuscntr/FNS_JOO_0068.do"+param, 850, 500, "popupFinish1", "none", true, true);
	//ComOpenPopup("/opuscntr/FNS_JOO_0068.do"+param, 850, 500, "popupFinish1", "1,0,1,1,1,1,1,1", false);
}
/**
 * pop up window is closed
 * @param arry
 * @return
 */
function popupFinish1(arry){
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}
function auth_ofc_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, idx_cd, text){
	sheetObjects[0].RemoveAll();
}

function rdOpen(csrNo) {
    var formObj = document.form;
    var queryStr="";
        queryStr += " [" + csrNo + "]";
    
    
    var rdParam='/rp ' + queryStr;
    var strPath="apps/opus/fns/joo/jointoperationagreementsettlement/jointoperationconsultation/report/FNS_JOO_0019.mrd";
    if (csrNo.substring(0, 2) == "18") {
        strPath="apps/opus/fns/joo/jointoperationagreementsettlement/jointoperationconsultation/report/FNS_JOO_0021.mrd";
    }
    formObj.com_mrdPath.value=strPath;
    formObj.com_mrdArguments.value=rdParam;
    ComOpenRDPopup();
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}