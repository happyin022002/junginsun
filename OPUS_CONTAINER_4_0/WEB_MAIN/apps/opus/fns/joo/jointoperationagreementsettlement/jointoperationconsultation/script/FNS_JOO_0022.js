/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName : fns_joo_0022.js
 *@FileTitle: CSR Approval
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
 * @class fns_joo_0022 : business script for fns_joo_0022
 */

// common global variable
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects = new Array();
var comboCnt = 0;
var prefix="sheet1_";
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	/***** setting sheet object *****/
	var sheetObject1=sheetObjects[0];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
				break;
			case "btn_calendar":
				var cal=new ComCalendar();
	            cal.setEndFunction("calFr"); 
				cal.select(formObject.slp_iss_dt, 'yyyy-MM-dd');
				break;
			case "btn_downexcel":
				if(sheetObject1.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
				}else{
					sheetObject1.Down2Excel({ HiddenColumn:1,Merge:1});
				}		
				break;
			case "btn_new":
				formObject.csr_no.value="";
				formObject.if_flg[0].checked=true;
				formObject.slp_iss_dt.value=formObject.sysdate.value;
				sheetObject1.RemoveAll();
                comboObjects[0].SetSelectIndex(0);
				formObject.if_flg[1].focus();
				break;
			case "btn_csr":
				if (sheetObject1.GetSelectRow()== undefined || sheetObject1.GetSelectRow()== null){
					ComShowCodeMessage('JOO00072');
					return;
				}
				if (sheetObject1.RowCount()== 0){
					ComShowCodeMessage('JOO00073');
					return;
				}
				var row=sheetObject1.GetSelectRow();
				var csrNo=sheetObject1.GetCellValue(row, prefix+"csr_no");
				if (csrNo == ""){
					ComShowCodeMessage('JOO00074');
					return;
				}
				var param='?csrNo='+csrNo;
				//ComOpenPopup('/opuscntr/FNS_JOO_0024.do'+param, 835, 450, 'popupFinish', '1,0,1,1,1,1,1,1', true);
				//ComOpenPopup('/opuscntr/FNS_JOO_0024.do'+param, 835, 450, '', 'none', false);
				//ComOpenPopup("/opuscntr/FNS_JOO_0024.do"+param, 835, 450, "popupFinish", "none", false, false, 0, 0, 0, "pop1");
				ComJooCsrDetailPopup(param);
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
function popupFinish(aryPopupData){
	///alert("popUpFinish");
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
    // initializing IBMultiCombo
    for (var k = 0; k < comboObjects.length; k++) {
        initCombo(comboObjects[k], k + 1);
    }
    initControl();
    document.form.if_flg[1].focus()
}
/**
 * registering IBCombo Object as list param : combo_obj adding process for list
 * in case of needing batch processing with other items defining list on the top
 * of source
 */
function setComboObject(combo_obj) {
    comboObjects[comboCnt++] = combo_obj;
}

/**
 * setting Combo basic info
 * 
 * @param comboObj
 * @param comboIndex
 *            Number
 */
function initCombo(comboObj, comboNo) {
    var formObject = document.form;
    switch (comboObj.options.id) {
        case "auth_ofc_cd":
            with (comboObj) {
                SetMultiSelect(0);
                SetUseAutoComplete(1);
                SetColAlign(0, "left");
                // SetColWidth(0, "60");
                ValidChar(2, 1); // Uppercase
                SetDropHeight(160);
                SetMaxLength(3);
            }
            var comboItems = gAuthOfcCdComboItems.split("|");
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
		        var HeadTitle="status|Register No.|Issue Date|Effective Date|Currency|Amount|Issuer|Description|LastAproFlg";
		        var headCount=ComCountHeadTitle(HeadTitle);
	//	        (headCount, 0, 0, true);
		        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		        var headers = [ { Text:HeadTitle, Align:"Center"} ];
		        InitHeaders(headers, info);
	
		        var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		                     {Type:"Text",      Hidden:0,  Width:170,    Align:"Center",  ColMerge:1,   SaveName:prefix+"csr_no",           KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Date",      Hidden:0,  Width:120,    Align:"Center",  ColMerge:1,   SaveName:prefix+"slp_iss_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd" },
		                     {Type:"Date",      Hidden:0,  Width:120,    Align:"Center",  ColMerge:1,   SaveName:prefix+"eff_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd" },
		                     {Type:"Text",      Hidden:0,  Width:120,    Align:"Center",  ColMerge:1,   SaveName:prefix+"csr_locl_curr_cd", KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Float",     Hidden:0,  Width:130,    Align:"Right",   ColMerge:1,   SaveName:prefix+"csr_locl_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
		                     {Type:"Text",      Hidden:0,  Width:140,    Align:"Center",  ColMerge:1,   SaveName:prefix+"issuer",           KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:0,  Width:260,    Align:"Left",    ColMerge:1,   SaveName:prefix+"csr_desc",         KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:1, Width:250,    Align:"Left",    ColMerge:1,   SaveName:prefix+"lst_apro_flg",     KeyField:0,   CalcLogic:"",   Format:"" } ];
		         
		        InitColumns(cols);	
		        SetEditable(0);
//		        SetSheetHeight(530);
		        resizeSheet();
		       // FitColWidth("0|15|9|9|10|10|12|12");
			}
		break;
	}
}
function initControl() {
	//** Date Separator **/
	DATE_SEPARATOR="-";
	var formObject=document.form;
    //handling Axon event. event catch
	axon_event.addListenerFormat('beforedeactivate', 'obj_blur' , formObject); 	//- handling code when OnBeforeDeactivate(blur) event
    axon_event.addListener  ('click', 'change_event_radio', 'if_flg');   
    axon_event.addListenerForm  ('keyup', 'obj_keyup', form);     
}
//handling Axon event 2
function obj_blur(){
    ComChkObjValid(event.srcElement);
}
function obj_keyup(){
    var eleObj=event.srcElement;
    var form=document.form;
    switch (eleObj.name) {
        case "slp_iss_dt":
            var slpIssDt=ComReplaceStr(form.slp_iss_dt.value,"-","");
            if (slpIssDt.length == 8){
                sheetObjects[0].RemoveAll();
                doActionIBSheet(sheetObjects[0], form, IBROWSEARCH);
            }
            break; 
    }
}
/*function obj_focus(){
    ComClearSeparator(event.srcElement);
}
function csr_no_keypress(){
    //converting to upper case
    ComKeyOnlyAlphabet('uppernum');
    if (ComTrim(document.form.slp_iss_dt.value) != "")
    	document.form.slp_iss_dt.value="";
    sheetObjects[0].RemoveAll();
}*/
function change_event_radio(){
	sheetObjects[0].RemoveAll();

    doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH);
}
/*function slp_iss_dt_keypress(){
    ComKeyOnlyNumber(document.form.slp_iss_dt);
}*/
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	if (!validateForm(sheetObj, formObj, sAction))
		return;
	//formObj.slp_iss_dt.value=ComReplaceStr(formObj.slp_iss_dt,"-","");
	switch (sAction) {
		case IBSEARCH: //retrieve
			if (formObj.csr_no.value.length >= gDefaultCsrLength){
				var param='?csrNo='+formObj.csr_no.value+"&editable=Y";
				ComOpenPopup("/opuscntr/FNS_JOO_0023.do"+param, 1024, 410, "popupFinish1", "1,0,1,1,1,1,1,1", false);
			}else{
				formObj.f_cmd.value=SEARCH;
 				sheetObj.DoSearch("FNS_JOO_0022GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix) );
			}
			break;
			
        case IBROWSEARCH: //setting OFFICE LIST combo
            comboObjects[0].RemoveAll();
            formObj.f_cmd.value=SEARCHLIST01;
            var sXml=sheetObj.GetSearchData("FNS_JOO_0022GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
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
	}
	
	formObj.slp_iss_dt.focus();
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
		case IBSEARCH: //retrieve
			var csrNo=formObj.csr_no.value; 
			if (csrNo.length > 0 && csrNo.length < gDefaultCsrLength){
				ComShowCodeMessage("JOO00075");
				formObj.csr_no.focus();
				return false;
			}
			var slpIssDt=ComReplaceStr(formObj.slp_iss_dt,"-","");
			if (csrNo.length == 0 && slpIssDt.length == 0){
				ComShowCodeMessage("JOO00076");
				formObj.csr_no.focus();
				return false;
			}
		break;
        case IBROWSEARCH:
            var slpIssDt=ComReplaceStr(formObj.slp_iss_dt,"-","");
            if (slpIssDt.length == 0){
                ComShowCodeMessage("JOO00076");
                //formObj.csr_no.focus();
                return false;
            }                  
            break;
	}
	return true;
}
/**
 * double Click 시
 * @param sheetObj
 * @param Row
 * @param Col
 * @param CellX
 * @param CellY
 * @param CellW
 * @param CellH
 * @return
 */
//function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
function sheet1_OnDblClick(sheetObj, Row, Col) {
var param='?csrNo='+sheetObj.GetCellValue(Row, prefix+'csr_no')+'&editable=Y';
	ComOpenPopup('/opuscntr/FNS_JOO_0023.do'+param, 1024, 410, 'popupFinish1', '1,0,1,1,1,1,1,1', true);
}
/**
 * pop up window is closed
 * @param arry
 * @return
 */
function popupFinish1(arry){
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

function auth_ofc_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
    var formObj = document.form;
    sheetObjects[0].RemoveAll();
    
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

function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}
