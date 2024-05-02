/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAR_3001.js
*@FileTitle  : Outstanding Adjustment 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
/*******************************************************************************
 * Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3; MODIFY=4; REMOVE=5;
 * REMOVELIST=6 MULTI=7 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ******************************************************************************/
var sheetObjects=new Array();
var sheetCnt=0;

var comboObjects=new Array();        
var comboCnt=0;

var gCurRow=0;
var prefix1="sheet1_";
var prefix2="sheet2_";
var acctTpCdXml="";
var amtSgnCdXml="";
var payAcctCd="";
var acctTpNm="";
var selIndex="";
var sheet1ClickOnOff = ""; 

// Event handler processing by button click event */
document.onclick=processButtonClick;

// Event handler processing by button name */
function processButtonClick() {
	/** *** setting sheet object **** */
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	/** **************************************************** */
	
	var formObj=document.form;
	
	try {
		var srcName=ComGetEvent("name");
		
		if(ComGetBtnDisable(srcName)) return false;
		
		switch (srcName) {
			case "btn_retrieve":
				if(!ComIsEmpty(formObj.adj_no)){
					// Retrieve New ASA NO 
					comboObjects[3].RemoveAll();
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC07);
									
					doActionIBSheet(sheetObject1, formObj, IBSEARCH);
				}								
				break;
				
			case "btn_otsadd":
				if(!ComIsEmpty(formObj.bl_no) || !ComIsEmpty(formObj.inv_no)){
					// Retrieve New ASA NO
					comboObjects[3].RemoveAll();
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC07);
					
					doActionIBSheet(sheetObject1, formObj, IBSEARCHAPPEND);
				}				
				break;	
				
			case "btn_new":
				removeAll(formObj);
				formObj.curr_cd.value="";			 
				formObj.curr_cd_chg.value="0";  
				doActionIBSheet(sheetObject1, formObj, IBSEARCH_ASYNC06); 
				break;
				
			case "btn_save":
				doActionIBSheet(sheetObject1, formObj, IBSAVE);
				break;
				
			case "btn_Reverse":
				doActionIBSheet(sheetObject1, formObj, IBSEARCH_ASYNC04);
				break;
				
			case "btn_rowdelete_hdr":	
				var sheet1_key=""; 
				var sheet2_key_name="";
				
				// get kind of sheet1 key
				if(formObj.search_tp.value == "1"){
					sheet1_key=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), prefix1+"ots_adj_seq");
					sheet2_key_name=prefix2+"ots_adj_seq";
				}else if(formObj.search_tp.value == "2"){
					sheet1_key=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), prefix1+"ots_hdr_key");
					sheet2_key_name=prefix2+"ots_dtl_key";
				}
				// delete sheet1
				sheetObjects[0].RowDelete(sheetObjects[0].GetSelectRow(), false);
				
				// delete sheet2
				if(sheetObjects[1].RowCount()!= 0){
					for(var i=sheetObjects[1].LastRow(); i>=sheetObjects[1].HeaderRows(); i--){
						if(sheet1_key == sheetObjects[1].GetCellValue(i, sheet2_key_name)){
							sheetObjects[1].RowDelete(i, false);
						}
					}
				}
				
				dtlSheetSetup();
				break;
				
			case "btn_rowdelete_dtl":
				sheetObjects[1].RowDelete(sheetObjects[1].GetSelectRow(), false);
				getGlAmt();
				break;
				
			case "btns_adj_cal":
				var cal=new ComCalendar();
				cal.select(formObj.adj_dt, 'yyyy-MM-dd');
				break;	
				
			case "btns_vndr_no":
				if(payAcctCd[selIndex] != "" && payAcctCd[selIndex] != undefined && sheetObject1.RowCount()> 0){
					var param="?vndr_seq=" + formObj.vndr_no.value + "&delt_fla=";
					ComOpenPopup("STM_SAR_0002.do" + param, 900, 400, "setSupplier", "0,0", true, false);
				}				
				break;	
				
			case "btns_ap_ofc_cd":
				if(payAcctCd[selIndex] != "" && payAcctCd[selIndex] != undefined && sheetObject1.RowCount()> 0){
					var param="?ofc_cd=" + formObj.ap_ofc_cd.value;
					ComOpenPopupWithTarget('STM_SAR_0001.do' + param, 480, 550,"ap_ofc_cd:ap_ofc_cd", "0,0", true);
					sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), prefix1+"ap_ofc_cd", formObj.ap_ofc_cd.value, 0);
				}				
				break;		
				
			case "btn_view_accounting":
				if (ComIsNull(formObj.adj_no.value)) {
					ComShowCodeMessage('COM130403', 'ADJUST No');
					ComSetFocus(formObj.adj_no);
					return;
				}
				var param = "adj_no=" + formObj.adj_no.value + "&ots_ofc_cd=" + comboObjects[1].GetSelectText()+ "&action_type=ADJ";
				var popupWin=ComOpenWindowCenter("/opuscntr/STM_SAR_3004.do?" + param, "asa_view_accounting_popup", 1000, 550, false, "no");
				popupWin.focus();
				break;	
		}
	} catch (e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
 		} else {
 			ComShowMessage(e.message);
 		}
	}
}

/**
 * registering IBSheet Object as list adding process for list in case of needing
 * batch processing with other items defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}

/**
 * registering IBCombo Object as list param : combo_obj adding process for list
 * in case of needing batch processing with other items defining list on the top
 * of source
 */ 
function setComboObject(combo_obj) {  
    comboObjects[comboCnt++]=combo_obj;  
}

/**
 * initializing sheet implementing onLoad event handler in body tag adding
 * first-served functions after loading screen.
 */
function loadPage() {
	var sheetObject1=sheetObjects[0];	
	var formObj=document.form;
	
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);		
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	for(var k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],k+1);
	}
	
    initControl();
    
    ComBtnDisable("btn_Reverse");
    ComEnableObject(formObj.btns_vndr_no,false);
    ComEnableObject(formObj.btns_ap_ofc_cd,false);
    
    // set combo
    doActionIBSheet(sheetObject1, formObj, IBSEARCH_ASYNC01);
    //doActionIBSheet(sheetObject1, formObj, IBSEARCH_ASYNC02);
    doActionIBSheet(sheetObject1, formObj, IBSEARCH_ASYNC03);
    doActionIBSheet(sheetObject1, formObj, IBSEARCH_ASYNC06);
    
    // Ap info - disabled
    ComEnableObject(formObj.ap_ofc_cd,false);
    formObj.ap_ofc_cd.className="input1";
    ComEnableObject(formObj.vndr_no,false);
    formObj.vndr_no.className="input1";
    ComEnableObject(formObj.ap_rmk,false);
    formObj.ap_rmk.className="input1";
    
    adj_tp_cd.SetEnable(0);
    ap_curr_cd.SetEnable(0);
    asa_no.SetEnable(0);
}

/**
 * loading HTML Control event <br>
 * {@link #loadPage} function call this. so IBSheet Object is initialized. <br>
 * 
 * @param {ibsheet} sheetObj IBSheet Object
 * @param {int} sheetNo sequence number in sheetObjects array
 */
function initControl() {
	var formObj=document.form;
	axon_event.addListener('click', 		'change_event_radio', 'adj_tp');
	axon_event.addListenerForm ('blur', 	'obj_blur', formObj);
	axon_event.addListenerForm ('change', 'obj_onchange', formObj);
}

function obj_onchange(){
	var formObj=document.form;
	var sheetObject=sheetObjects[0];
	var apOfcCd = formObj.ap_ofc_cd.value;
	var vndrNo = formObj.vndr_no.value;
	var cnt = 0;
	
	switch(ComGetEvent("name")){
		case "ap_ofc_cd":
			if (!ComIsEmpty(apOfcCd)) {
				
				var param="f_cmd=" + SEARCH + "&ofc_cd=" + apOfcCd;
				var sXml=sheetObject.GetSearchData("STM_SAR_0001GS.do", param);
				var rows = ComGetTotalRows(sXml)
				
				if(rows > 0){
					/*
					var arrStr = SarXmlToArray(sXml);
					for(var i = 0; i < arrStr.length; i++){
						if(arrStr[i][0] == apOfcCd) cnt++;
					}
					*/
					var apOfcSeq = ComGetEtcData(sXml,"ap_ofc_cd");
					if(apOfcSeq == apOfcCd) cnt++;
				}
				
				if(rows == 0 || cnt == 0){
					ComShowCodeMessage("SAR00052", apOfcCd);
					ComClearObject(formObj.ap_ofc_cd);
					ComSetFocus(formObj.ap_ofc_cd);
				}			
			} 
			
			break;
			
		case "vndr_no":
			if (!ComIsEmpty(vndrNo)) {
				
				var param="f_cmd=" + SEARCH + "&vndr_seq=" + vndrNo;
				var sXml=sheetObject.GetSearchData("STM_SAR_0002GS.do", param);
				var rows = ComGetTotalRows(sXml)
				
				if(rows > 0){
					/*
					var arrStr = SarXmlToArray(sXml);
					for(var i = 0; i < arrStr.length; i++){
						if(arrStr[i][5] == vndrNo) cnt++;
					}
					*/
					var vndrSeq = ComGetEtcData(sXml,"vndr_seq");
					if(vndrSeq == vndrNo) cnt++;
				}
				
				if(rows == 0 || cnt == 0){
					ComShowCodeMessage("SAR00052", vndrNo);
					ComClearObject(formObj.vndr_no);
					ComSetFocus(formObj.vndr_no);
				}			
			} 
			
			break;	
	}
}

/**
 * Handling business javascript OnChange event
 */
function ap_curr_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	// CHECK OLD CODE: OnChange(comboObj, code, text) {
	var formObj=document.form;
	
	if(!ComIsNull(newCode)){
		if(payAcctCd[selIndex] != "" && payAcctCd[selIndex] != undefined){		
			// set Detail info(set adjust type rows of sheet)
			for(var i=sheetObjects[1].HeaderRows(); i<= sheetObjects[1].LastRow(); i++){
				if(sheetObjects[1].GetRowHidden(i) == false){
					sheetObjects[1].SetCellValue(i, prefix2+"adj_crs_curr_cd",newCode,0);
				}
			}
				
			// set Header info(set adjust type rows of sheet)
			sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), prefix1+"ap_curr_cd",newCode,0);
				
			formObj.curr_cd.value=newCode;
			formObj.curr_cd_chg.value="1";
				
			doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC06);
			doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC05);
				
		}
	} else {
		formObj.curr_cd.value="";			 
		formObj.curr_cd_chg.value="0";  
		for(var j=sheetObjects[1].HeaderRows(); j<= sheetObjects[1].LastRow(); j++){
			if(sheetObjects[1].GetRowHidden(j) == false){
				sheetObjects[1].SetCellValue(j, prefix2+"adj_xch_rt", "", 0);
				sheetObjects[1].SetCellValue(j, prefix2+"adj_xch_rt_tmp","",0);  
				sheetObjects[1].SetCellValue(j, prefix2+"adj_crs_curr_cd", "", 0);
				sheetObjects[1].SetCellValue(j, prefix2+"adj_crs_curr_amt", "", 0);
				sheetObjects[1].SetCellValue(j, prefix2+"adj_crs_curr_amt_tmp", "", 0);
				sheetObjects[1].SetCellValue(j, prefix2+"dp_prcs_knt","",0);
			}
		}
		
		sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), prefix1+"ap_curr_cd","",0);
		sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), prefix1+"adj_crs_curr_cd","",0); 
		sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), prefix1+"ap_crs_curr_amt", "0.00", 0);
		sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), prefix1+"gain_and_lss_amt", "0.00", 0);	
		
		formObj.ap_crs_curr_amt.value="0.00";  
		formObj.gain_and_lss_amt.value="0.00";
	}
}

/**
 * Handling business javascript OnChange event
 */
function ots_ofc_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	// CHECK OLD CODE: OnChange(comboObj, code, text) {	
	var formObj=document.form;
	
	var xml=formObj.ots_ofc_cd_xml.value;
	var arrStr=xml.split("|");
	
	for (var i=1; i < arrStr.length; i++ ) {
		var arrStr2=arrStr[i].split("^");
		
		if(ots_ofc_cd.GetSelectText() == arrStr2[0]){
			
			formObj.adjt_ofc_cd.value=arrStr2[0];
			formObj.rhq_cd.value=arrStr2[2];
			formObj.ots_smry_cd.value=arrStr2[3]; 
			formObj.ots_cd.value=arrStr2[4]; 
			formObj.rep_ots_ofc_cd.value=arrStr2[5]; 
			formObj.adjt_tp_cd.value=arrStr2[6]; 
			formObj.adjt_unapy_flg.value=arrStr2[7]; 
			formObj.ofc_entr_lvl_cd.value=arrStr2[8]; 
			formObj.adjt_curr_cd.value=arrStr2[9]; 
			formObj.dp_prcs_knt.value=arrStr2[10]; 
		}
	}		
	
	if (formObj.ots_smry_cd.value == "INV"){
		displayObject("bl_label", false);
		displayObject("bl_inp", false);
		displayObject("inv_label", true);
		displayObject("inv_inp", true); 
	}else{
		displayObject("bl_label", true);
		displayObject("bl_inp", true);
		displayObject("inv_label", false);
		displayObject("inv_inp", false);
	}
	
	// reset Items
	sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
	comboObjects[0].RemoveAll();
	comboObjects[2].RemoveAll();

	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC02);

	formObj.adj_tp[1].checked=true;
	adj_tp_cd.SetSelectText("")	
	formObj.adj_no.value="";
	formObj.bl_no.value="";
	formObj.inv_no.value="";
	dtl_adj_tp_cd.SetSelectText("");
	formObj.rvs_flg.value="";
	formObj.adj_rmk.value=""; 
	formObj.ap_ofc_cd.value="";
	asa_no.SetSelectText("");
	formObj.vndr_no.value="";
	ap_curr_cd.SetSelectText("");
	formObj.ap_crs_curr_amt.value="";
	formObj.gain_and_lss_amt.value="";
	formObj.ap_rmk.value="";
	selIndex="";
	
	adj_tp_cd.SetEnable(0);
	dtl_adj_tp_cd.SetEnable(1);
	ComEnableObject(formObj.adj_rmk,true);
	ComEnableObject(formObj.ap_ofc_cd,false);
	formObj.ap_ofc_cd.className="input1";
	ComEnableObject(formObj.vndr_no,false);
	formObj.vndr_no.className="input1";
	ComEnableObject(formObj.ap_rmk,false);
	formObj.ap_rmk.className="input1";
	ComEnableObject(formObj.btns_vndr_no,false);
	ComEnableObject(formObj.btns_ap_ofc_cd,false);
	
	asa_no.SetEnable(0);
	ap_curr_cd.SetEnable(0);
	
    ComBtnEnable("btn_otsadd");
    ComBtnEnable("btn_retrieve");
    ComBtnEnable("btn_save");
}

/**
 * Handling business javascript OnChange event
 */
function asa_no_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	// CHECK OLD CODE: OnChange(comboObj, code, text) {
	var formObj=document.form;
	 
	if(newCode != "" && formObj.search_tp.value == "2") {
		if(payAcctCd[selIndex] != "" && payAcctCd[selIndex] != undefined){	
			sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), prefix1+"asa_no", asa_no.GetSelectText(), 0);
		}
	}
}

/**
 * Handling business javascript OnChange event
 */
function dtl_adj_tp_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	// CHECK OLD CODE: OnChange(comboObj, code, text) {
	var formObj=document.form;
	 
	if(newCode != "") {
		for(var i=0; i<acctTpCdXml.length; i++){
			if(acctTpCdXml[i] == dtl_adj_tp_cd.GetSelectText()){
				selIndex=i;
			}
		}
		 
		for(var i=sheetObjects[1].HeaderRows(); i<= sheetObjects[1].LastRow(); i++){
			if(sheetObjects[1].GetRowHidden(i) == false){
				sheetObjects[1].SetCellValue(i, prefix2+"adj_tp_cd", dtl_adj_tp_cd.GetSelectText(), 0);
				 
				if(payAcctCd[selIndex] == ""){
					// IBSHEET Amount 초끼화 오류 때문에 소수점 1자리로 초기화 함 제대로 돌아가면 필요없음. START
					sheetObjects[1].InitCellProperty(i, prefix2+"adj_crs_curr_amt", { Type:"Float",Align:"Right",Format:"NullFloat",PointCount:1} );
					sheetObjects[1].InitCellProperty(i, prefix2+"adj_crs_curr_amt_tmp", { Type:"Float",Align:"Right",Format:"NullFloat",PointCount:1} );
					// IBSHEET Amount 초끼화 오류 때문에 소수점 1자리로 초기화 함 제대로 돌아가면 필요없음. END
					 
					sheetObjects[1].SetCellValue(i, prefix2+"adj_xch_rt", "", 0);
					sheetObjects[1].SetCellValue(i, prefix2+"adj_crs_curr_cd", "", 0);
					sheetObjects[1].SetCellValue(i, prefix2+"adj_crs_curr_amt", "", 0);
					sheetObjects[1].SetCellValue(i, prefix2+"adj_xch_rt_tmp", "", 0);
					sheetObjects[1].SetCellValue(i, prefix2+"adj_crs_curr_amt_tmp", "", 0);
					sheetObjects[1].SetRowEditable(i, 1);
				}
				
				if(sheet1ClickOnOff == ""){
					 sheetObjects[1].SetCellValue(i, prefix2+"ots_adj_bal_amt", "");
				}
			}
		}

		sheet1ClickOnOff = "";
		 
		// set Header info(set adjust type rows of sheet)
		sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), prefix1+"adj_tp_cd", dtl_adj_tp_cd.GetSelectText(), 0);
		sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), prefix1+"pay_acct_cd", payAcctCd[selIndex], 0);
		 
		// if payAcctCd is not null then ==> ar/ap info enable
		if(payAcctCd[selIndex] != ""){
			changeApIfForm(formObj);
		}else{
			if(newCode == ""){
				sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), prefix1+"adj_rmk", "", 0);
				 
				formObj.rvs_flg.value="N";
				formObj.adj_rmk.value=""; 
			}
			 
			sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), prefix1+"ap_ofc_cd", "", 0);
			sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), prefix1+"asa_no", "", 0);
			sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), prefix1+"vndr_no", "", 0);
			sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), prefix1+"ap_curr_cd", "", 0);
			sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), prefix1+"ap_crs_curr_amt", "", 0);
			sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), prefix1+"gain_and_lss_amt", "", 0);
			sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), prefix1+"ap_rmk", "", 0);
			 
			formObj.ap_ofc_cd.value="";
			asa_no.SetSelectText("");
			formObj.vndr_no.value="";
			ap_curr_cd.SetSelectText("");
			formObj.ap_crs_curr_amt.value="";
			formObj.gain_and_lss_amt.value="";
			formObj.ap_rmk.value="";	
			 
			changeApIfForm(formObj);
		}
	}
}

/**
 * Handling business javascript OnChange event
 */
function adj_tp_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	// CHECK OLD CODE: OnChange(comboObj, code, text) {
	var formObj=document.form;
	 
	if(newCode != "" && formObj.search_tp.value == "2") {
		 
		dtl_adj_tp_cd.SetSelectText(adj_tp_cd.GetSelectText());
		dtl_adj_tp_cd.SetEnable(0);
		
		// set Detail info(set all adjust type rows of sheet) 
		for(var i=sheetObjects[1].HeaderRows(); i<= sheetObjects[1].LastRow(); i++){
			sheetObjects[1].SetCellValue(i, prefix2+"adj_tp_cd", adj_tp_cd.GetSelectText(), 0);
			
			if(payAcctCd[selIndex] == ""){
				// IBSHEET Amount 초끼화 오류 때문에 소수점 1자리로 초기화 함 제대로 돌아가면 필요없음. START
				sheetObjects[1].InitCellProperty(i, prefix2+"adj_crs_curr_amt", { Type:"Float",Align:"Right",Format:"NullFloat",PointCount:1} );
				sheetObjects[1].InitCellProperty(i, prefix2+"adj_crs_curr_amt_tmp", { Type:"Float",Align:"Right",Format:"NullFloat",PointCount:1} );
				// IBSHEET Amount 초끼화 오류 때문에 소수점 1자리로 초기화 함 제대로 돌아가면 필요없음. END
				
				sheetObjects[1].SetCellValue(i, prefix2+"adj_xch_rt", "", 0);
				sheetObjects[1].SetCellValue(i, prefix2+"adj_crs_curr_cd", "", 0);
				sheetObjects[1].SetCellValue(i, prefix2+"adj_crs_curr_amt", "", 0);
				sheetObjects[1].SetCellValue(i, prefix2+"adj_xch_rt_tmp", "", 0);
				sheetObjects[1].SetCellValue(i, prefix2+"adj_crs_curr_amt_tmp", "", 0);
				sheetObjects[1].SetRowEditable(i, 1);
			}
			
			sheetObjects[1].SetCellValue(i, prefix2+"ots_adj_bal_amt", "");
		}
		
		// set Header info(set all adjust type rows of sheet)
		for(var i=sheetObjects[0].HeaderRows(); i<= sheetObjects[0].LastRow(); i++){
			if(newCode == ""){
				sheetObjects[0].SetCellValue(i, prefix1+"adj_rmk", "", 0);
			}
			
			sheetObjects[0].SetCellValue(i, prefix1+"adj_tp_cd", adj_tp_cd.GetSelectText(), 0);
			sheetObjects[0].SetCellValue(i, prefix1+"pay_acct_cd", payAcctCd[selIndex], 0);
			
			if(payAcctCd[selIndex] == ""){
				sheetObjects[0].SetCellValue(i, prefix1+"ap_ofc_cd", "", 0);
				sheetObjects[0].SetCellValue(i, prefix1+"asa_no", "", 0);
				sheetObjects[0].SetCellValue(i, prefix1+"vndr_no", "", 0);
				sheetObjects[0].SetCellValue(i, prefix1+"ap_curr_cd", "", 0);
				sheetObjects[0].SetCellValue(i, prefix1+"ap_crs_curr_amt", "", 0);
				sheetObjects[0].SetCellValue(i, prefix1+"gain_and_lss_amt", "", 0);
				sheetObjects[0].SetCellValue(i, prefix1+"ap_rmk", "", 0);
			}
		}
	}
}

/**
 * Handling business javascript OnChange event
 */
function change_event_radio() {
	var formObj=document.form;
	
	if(formObj.search_tp.value != "1"){
		if (formObj.adj_tp[0].checked == true){
			reSetSameType(formObj);
			
			adj_tp_cd.SetSelectText("");
			dtl_adj_tp_cd.SetSelectText("");
			selIndex="";
			
			adj_tp_cd.SetEnable(1);
			dtl_adj_tp_cd.SetEnable(0);
		}else if(formObj.adj_tp[1].checked == true){
			adj_tp_cd.SetSelectText("");
			
			if(dtl_adj_tp_cd.GetSelectText() == ""){
				selIndex="";
			}
			
			adj_tp_cd.SetEnable(0);
			dtl_adj_tp_cd.SetEnable(1);
		}
		
		changeApIfForm(formObj);
	}
}

/**
 * HTML Control의 onfocus이벤트에서 마스크 구분자를 살려주며. Validate를 체크하여준다.
 */
function obj_blur(){
	
	var formObj=document.form;
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	
	switch(ComGetEvent("name")){
		case "adj_dt":
			ComChkObjValid(ComGetEvent());
			
			if(formObj.tmp_adj_dt.value != formObj.adj_dt.value){
				//ap_curr_cd.SetSelectText("");
				formObj.tmp_adj_dt.value=formObj.adj_dt.value;
				
				doActionIBSheet(sheetObject2, formObj, IBSEARCH_ASYNC08);
			}
			break;
	}
	
	if(ComGetEvent("name") == "adj_rmk" || ComGetEvent("name") == "ap_ofc_cd" || ComGetEvent("name") == "vndr_no" || ComGetEvent("name") == "ap_rmk" ){		
		for(var i=sheetObject1.HeaderRows(); i<= sheetObject1.LastRow(); i++){
			var sheet1_key=sheetObject1.GetCellValue(i, prefix1+"ots_hdr_key");
			var sheet2_key=sheetObject2.GetCellValue(sheetObject2.GetSelectRow(), prefix2+"ots_dtl_key");
			
			if(dtl_adj_tp_cd.GetSelectText() != ""){
				if(sheet1_key == sheet2_key){
					// AR/AP Info to sheet1's hidden column
					sheetObject1.SetCellValue(i, prefix1+"adj_rmk", formObj.adj_rmk.value, 0);
					sheetObject1.SetCellValue(i, prefix1+"ap_ofc_cd", formObj.ap_ofc_cd.value, 0);
					sheetObject1.SetCellValue(i, prefix1+"asa_no", asa_no.GetSelectText(), 0);
					sheetObject1.SetCellValue(i, prefix1+"vndr_no", formObj.vndr_no.value, 0);
					sheetObject1.SetCellValue(i, prefix1+"ap_curr_cd", ap_curr_cd.GetSelectText(), 0);
					sheetObject1.SetCellValue(i, prefix1+"ap_crs_curr_amt", formObj.ap_crs_curr_amt.value, 0);
					sheetObject1.SetCellValue(i, prefix1+"gain_and_lss_amt", formObj.gain_and_lss_amt.value, 0);
					sheetObject1.SetCellValue(i, prefix1+"ap_rmk", formObj.ap_rmk.value, 0);
				}
			}else{
				sheetObject1.SetCellValue(i, prefix1+"adj_rmk", formObj.adj_rmk.value, 0);
			}
		}
	}
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
	   case "ap_curr_cd":
			with (comboObj) {
		   		SetDropHeight(200);
		   		SetMultiSelect(0);
		   		SetUseAutoComplete(1);
		   		SetMaxSelect(1);
		   		SetColAlign(0, "left");
		   		SetColWidth(0, "83");
		   		SetUseEdit(0);
		   		ValidChar(2);
			   }
            break;	
	}
}
	
/**
 * setting sheet initial values and header param : sheetObj, sheetNo adding case
 * as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;	
	
	switch (sheetNo) {
		case 1: // t1sheet1 init
		    with(sheetObj){			
			      var HeadTitle1="|BL NO|Booking No|Invoice No|Office Code|Customer|Local VVD|||||||||||||||||||||||||||||";			      
			      var headCount=ComCountHeadTitle(HeadTitle1);
			      
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      
			      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };			      
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];			      
			      InitHeaders(headers, info);
			      
			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"ibflag" },
			                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"bl_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"bkg_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"inv_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"inv_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"bil_to_cust_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"locl_vvd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"ots_adj_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"rhq_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"bil_to_cust_cnt_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"bil_to_cust_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"ots_hdr_key",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"adj_rmk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"rvs_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"ap_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"asa_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"vndr_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"ap_curr_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"ap_crs_curr_amt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"gain_and_lss_amt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"ap_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"shp_bil_to_cust_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"trnk_vvd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"sail_arr_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"io_bnd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"due_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"srep_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"ots_rmk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"xch_rt_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"xch_rt_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"cr_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"ar_finc_src_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"max_ar_if_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"adj_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"adj_no_hdr",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"pay_acct_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			      InitColumns(cols);
			      SetEditable(1);
//			      SetSheetHeight(420);
			      SetCountPosition(0);
			      resizeSheet();
	            }
		    break;
		    
	   case 2: // t2sheet2 init
		    with(sheetObj){
			      var HeadTitle1="|Charge|S.CUR|OTS Balance|Amount|EX.Rate|CUR|ADJ Amount||||||||||||||";
			      var headCount=ComCountHeadTitle(HeadTitle1);
			      
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      
			      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
			      
			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"ibflag" },
			                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"chg_tp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"bl_curr_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix2+"ots_bal_amt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix2+"ots_adj_bal_amt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                   {Type:"Text",      Hidden:0,  Width:130,  Align:"Right",   ColMerge:1,   SaveName:prefix2+"adj_xch_rt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"adj_crs_curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix2+"adj_crs_curr_amt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix2+"ots_adj_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix2+"rhq_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix2+"inv_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix2+"bl_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix2+"inv_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix2+"ots_dtl_key",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix2+"adj_tp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix2+"dp_prcs_knt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix2+"curr_dp_prcs_knt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:1,  Width:130,  Align:"Right",   ColMerge:1,   SaveName:prefix2+"adj_xch_rt_tmp",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:1,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix2+"adj_crs_curr_amt_tmp", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:1,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix2+"ofc_curr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:1,  Width:130,  Align:"Right",   ColMerge:1,   SaveName:prefix2+"locl_xch_rt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:1,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix2+"usd_xch_rt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			      InitColumns(cols);
			      SetEditable(1);
//			      SetSheetHeight(200);
			      SetCountPosition(0);
			      resizeSheet();
	            }
	   break;
	}
}

// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction, hideYn) {
	sheetObj.ShowDebugMsg(false);
	
	switch (sAction) {
	
		case IBSEARCH: // retrieve adjust no
			if (!validateForm(sheetObj,formObj,sAction)) {
	    		return false;
	    	}
			
			sheetObj.WaitImageVisible=false;
			if(hideYn){
				SarOpenWait(true,true);
			} else {
				ComOpenWait(true); 
			}	
			
			setTimeout( function () {
				sheet1ClickOnOff = "1";	 
				formObj.f_cmd.value = SEARCH;
				
	    		var prefixArr = new Array(prefix1, prefix2);
	    		
	    		var sXml=sheetObj.GetSearchData("STM_SAR_3001GS.do",  FormQueryString(formObj) + "&" + ComGetPrefixParam(prefixArr));
	    		var rtnValue=sXml.split("|$$|");
	    		
	    		//2014.08.18 add adj_dt
	    		var adjDt = ComGetEtcData(rtnValue[0],"adj_dt");
	    		if(!ComIsEmpty(adjDt)) {
	    			formObj.adj_dt.value = ComGetMaskedValue(adjDt, "ymd");
	    		}	
	    		
	    		sheetObj.LoadSearchData(rtnValue[0],{Sync:1} );
	    		sheetObjects[1].LoadSearchData(rtnValue[1],{Sync:1} );
	    		
	    		for(var i = sheetObjects[1].HeaderRows(); i <= sheetObjects[1].LastRow(); i++){
	    			sheetObjects[1].InitCellProperty(i, 4, {Type:"Text", Format:"", PointCount:0, Edit:0 });
	    			sheetObjects[1].InitCellProperty(i, 5, {Type:"Text", Format:"", PointCount:0, Edit:0 });
	    		}
				
	    		dtl_adj_tp_cd.SetEnable(0);
	    		
	    		if(formObj.rvs_flg.value == "Y"){
	    			ComBtnDisable("btn_Reverse");
	    		}
	    		ComBtnDisable("btn_rowdelete_hdr");
				ComBtnDisable("btn_rowdelete_dtl");
				ComOpenWait(false);  
			} , 100);	
    		break;
    		
		case IBSEARCHAPPEND: // retrieve bl no or inv no
			if (!validateForm(sheetObj,formObj,sAction)) {
	    		return false;
	    	}
			
			sheetObj.WaitImageVisible=false;
			ComOpenWait(true); 
			setTimeout( function () {
				sheet1ClickOnOff = "1";	
				formObj.f_cmd.value = SEARCH01;
				
				var prefixArr = new Array(prefix1, prefix2);
				
				var sXml = sheetObj.GetSearchData("STM_SAR_3001GS.do",  FormQueryString(formObj) + "&" + ComGetPrefixParam(prefixArr));
	    		var rtnValue=sXml.split("|$$|");
	    		
	    		sheetObj.LoadSearchData(rtnValue[0],{Append:1 , Sync:1} );
	    		sheetObj.SetSelectRow(1);
	    		sheetObjects[1].LoadSearchData(rtnValue[1],{Append:1 , Sync:1} );
	    		
	    		for(var i = sheetObjects[1].HeaderRows(); i <= sheetObjects[1].LastRow(); i++){    			
	    			if(sheetObjects[1].GetCellValue(i, prefix2+"curr_dp_prcs_knt") == "0" || sheetObjects[1].GetCellValue(i, prefix2+"curr_dp_prcs_knt") == "" ){
	    				sheetObjects[1].InitCellProperty(i, 4, {Type:"Int", Format:"NullInteger", PointCount:0, Edit:1 });    				
	    			}else{
	    				sheetObjects[1].InitCellProperty(i, 4, {Type:"Float", Format:"NullFloat", PointCount:sheetObjects[1].GetCellValue(i, prefix2+"curr_dp_prcs_knt"), Edit:1 });
	    			}
	    			
	    			sheetObjects[1].InitCellProperty(i, 5, {Type:"Float", Format:"NullFloat", PointCount:6, Edit:1 });
	    			sheetObjects[1].InitCellProperty(i, 17, {Type:"Float", Format:"NullFloat", PointCount:6, Edit:0 });
	    		}
	    		
	    		formObj.bl_no.value = "";
	    		formObj.inv_no.value = ""; 
	    		ComOpenWait(false);  
			} , 100);	
    		break;
    		
		case IBSAVE: // save
			if (!validateForm(sheetObj,formObj,sAction)) {
	    		return false;
	    	}
			
			formObj.f_cmd.value = MULTI;
			
			var sParam1 = ComGetSaveString(sheetObjects[0], true, true);
			if(sParam1 == "" ){
				return;
			}
			
			var sParam2 = ComGetSaveString(sheetObjects[1], true, true);
			if(sParam2 == "" ){
				return;
			}
			
			sheetObj.WaitImageVisible=false;
			var sXml;
			ComOpenWait(true); 
			setTimeout( function () {
				var sParam = sParam1 + "&" + sParam2 + "&" + FormQueryString(formObj);
			    sXml = sheetObj.GetSaveData("STM_SAR_3001GS.do", sParam);  
			    SarOpenWait(false,true);
		    } , 100);
			
			setTimeout( function () {
				if(SarShowXmlMessage(sXml) != "") {
	 				ComShowMessage(SarShowXmlMessage(sXml));
				}
				
				if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
					var sStr = ComGetEtcData(sXml, "adj_no_hdr");
					var arrStr = new Array();
					if (sStr) arrStr = sStr.split("|");
								
					if(sStr != undefined && sStr != ""){
						for (var i=0; i < arrStr.length; i++ ) {
							sheetObj.SetCellValue(i+1, prefix1+"adj_no_hdr",arrStr[i],0);
						}
						
						var temp = sheetObj.GetCellValue(sheetObj.HeaderRows(), prefix1+"adj_no_hdr");
						var temp2 = sheetObj.GetCellValue(sheetObj.HeaderRows(), prefix1+"inv_ofc_cd");				
						removeAll(formObj); 
						ots_ofc_cd.SetSelectText(temp2);
						formObj.adj_no.value=temp;
						
						// Retrieve New ASA NO
						doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC07);				
						doActionIBSheet(sheetObj, formObj, IBSEARCH,true);
						ComBtnDisable("btn_rowdelete_hdr");
						ComBtnDisable("btn_rowdelete_dtl");
					} 
				}
			} , 110);
			break;
			
		case IBSEARCH_ASYNC01: // retrieve AR_OFFICE_LIST
			formObj.f_cmd.value = SEARCH03;
			var sXml = sheetObj.GetSearchData("SARCommonGS.do", FormQueryString(formObj));
			var sStr = ComGetEtcData(sXml,"ots_ofc_cd");
			var arrStr = sStr.split("|");
			
			formObj.ots_ofc_cd_xml.value=sStr;
			MakeRctOfcComboObject(ots_ofc_cd, arrStr);
			
			for (var i = 1; i < arrStr.length; i++ ) {
				var arrStr2 = arrStr[i].split("^");
				
				if(arrStr2[0] == arrStr2[1]){
					ots_ofc_cd.SetSelectText(arrStr2[0]);
					formObj.adjt_ofc_cd.value = arrStr2[0];
					formObj.rhq_cd.value = arrStr2[2];
					formObj.ots_smry_cd.value = arrStr2[3]; 
					formObj.ots_cd.value = arrStr2[4]; 
					formObj.rep_ots_ofc_cd.value = arrStr2[5]; 
					formObj.adjt_tp_cd.value = arrStr2[6]; 
					formObj.adjt_unapy_flg.value = arrStr2[7]; 
					formObj.ofc_entr_lvl_cd.value = arrStr2[8]; 
					formObj.adjt_curr_cd.value = arrStr2[9]; 
					formObj.dp_prcs_knt.value = arrStr2[10]; 
				}
			}		
			
			if (formObj.ots_smry_cd.value == "INV"){
				displayObject("bl_label", false);
				displayObject("bl_inp", false);
				displayObject("inv_label", true);
				displayObject("inv_inp", true); 
			}else{
				displayObject("bl_label", true);
				displayObject("bl_inp", true);
				displayObject("inv_label", false);
				displayObject("inv_inp", false);
			}
			break;
			
		case IBSEARCH_ASYNC02: // retrieve ADJUST TYPE
			formObj.f_cmd.value = SEARCH05;
			var sXml=sheetObj.GetSearchData("SARCommonGS.do", FormQueryString(formObj));
			var sStr=ComGetEtcData(sXml,"acct_tp_cd");
			var sStr2=ComGetEtcData(sXml,"amt_sgn_cd");			
			var sStr3=ComGetEtcData(sXml,"pay_acct_cd");
			var sStr4=ComGetEtcData(sXml,"acct_tp_nm");
			
			if(sStr==null||sStr==undefined)return;
			var arrStr = sStr.split("|");
			
			if(sStr2==null||sStr2==undefined)return;
			var arrStr2 = sStr2.split("|");
			
			if(sStr3==null||sStr3==undefined)return;
			var arrStr3 = sStr3.split("|");
			
			if(sStr4==null||sStr4==undefined)return;
			var arrStr4 = sStr4.split("|");
			
			acctTpCdXml = arrStr;
			amtSgnCdXml = arrStr2;
			payAcctCd = arrStr3;
			acctTpNm = arrStr4;
			
			MakeRctOfcMultiComboObject(adj_tp_cd, arrStr4);
			MakeRctOfcMultiComboObject(dtl_adj_tp_cd, arrStr4);
			break;
			
		case IBSEARCH_ASYNC03: // retrieve Local Time
			formObj.f_cmd.value = SEARCH07;
			var sXml = sheetObj.GetSearchData("SARCommonGS.do", FormQueryString(formObj));
			var sStr = ComGetEtcData(sXml,"lcl_time");
			
			formObj.adj_dt.value = ComGetMaskedValue(sStr,"ymd");		
			formObj.tmp_adj_dt.value = formObj.adj_dt.value;
			break;
			
		case IBSEARCH_ASYNC04: // reverse
			formObj.f_cmd.value = MULTI01;
			
			var sParam1 = ComGetSaveString(sheetObjects[0], true, true);			
			if(sParam1 == "" ){
				return;
			}
			
			var sParam2 = ComGetSaveString(sheetObjects[1], true, true);			
			if(sParam2 == "" ){
				return;
			}
			
			if(!ComShowCodeConfirm("COM12154", "reverse data"))return;  
				
			var sXml;
			sheetObj.WaitImageVisible=false;
			ComOpenWait(true); 
			setTimeout( function () {
				var sParam = sParam1 + "&" + sParam2 + "&" +FormQueryString(formObj);
				sXml = sheetObj.GetSaveData("STM_SAR_3001GS.do", sParam);
				SarOpenWait(false,true);
			} , 100);
			
			setTimeout( function () {
				if(SarShowXmlMessage(sXml) != "") {
	 				ComShowMessage(SarShowXmlMessage(sXml));
				}
				
				if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
					doActionIBSheet(sheetObj, formObj, IBSEARCH,true);	
				}  
			} , 110);	
			break;
			
		case IBSEARCH_ASYNC05: // Ex.Rate
			formObj.f_cmd.value = SEARCH02;
			
			var sParam2 = ComGetSaveString(sheetObjects[1], true, true);
			
			if(sParam2 == "" ){
				return;
			}
			
			var sParam = sParam2 + "&" +FormQueryString(formObj);
			
			var sXml = sheetObj.GetSearchData("STM_SAR_3001GS.do", sParam);
			
			var sStr = ComGetEtcData(sXml,"legr_xch_rt");
			var arrStr = sStr.split("|");
			
			var i=0;
			
			if(payAcctCd[selIndex] != "" && payAcctCd[selIndex] != undefined){
				for(var j=sheetObjects[1].HeaderRows(); j<= sheetObjects[1].LastRow(); j++){
					if(sheetObjects[1].GetRowHidden(j) == false){
						sheetObjects[1].SetCellValue(j, prefix2+"adj_xch_rt_tmp",arrStr[i]);
						
						if( ap_curr_cd.GetSelectText() == "USD" ){
							sheetObjects[1].SetCellValue(j, prefix2+"adj_xch_rt",sheetObjects[1].GetCellValue(j, prefix2+"usd_xch_rt"));
						} else if( ap_curr_cd.GetSelectText() == sheetObjects[1].GetCellValue(j, prefix2+"ofc_curr_cd") ){
							sheetObjects[1].SetCellValue(j, prefix2+"adj_xch_rt",sheetObjects[1].GetCellValue(j, prefix2+"locl_xch_rt"));
						} else{
							sheetObjects[1].SetCellValue(j, prefix2+"adj_xch_rt",arrStr[i]);
						}
						
						if(sheetObjects[1].GetCellValue(j, prefix2+"adj_crs_curr_cd") != "" && sheetObjects[1].GetCellValue(j, prefix2+"adj_xch_rt") == ""){
							sheetObjects[1].SetRowEditable(j,0);
						}else{
							sheetObjects[1].SetRowEditable(j,1);
						}
						
						//추가 입력분 
						var point=sheetObj.GetCellValue(j, prefix2+"dp_prcs_knt");
						var crsamt = sheetObjects[1].GetCellValue(j, prefix2+"ots_adj_bal_amt") * sheetObjects[1].GetCellValue(j, prefix2+"adj_xch_rt");
						var crsAmtTemp = sheetObjects[1].GetCellValue(j, prefix2+"ots_adj_bal_amt") * sheetObjects[1].GetCellValue(j, prefix2+"adj_xch_rt_tmp");
	
						sheetObjects[1].SetCellValue(j, prefix2+"adj_crs_curr_amt", SarRound(crsamt,point), 0);
						sheetObjects[1].SetCellValue(j, prefix2+"adj_crs_curr_amt_tmp", SarRound(crsAmtTemp,point), 0);
					}
					
					i++;
				}
			}
			getGlAmt(); 
			break;
			
		case IBSEARCH_ASYNC06: // AP Currency
			formObj.f_cmd.value = SEARCH08; 
			var sXml = sheetObj.GetSearchData("SARCommonGS.do", FormQueryString(formObj));
			var sStr = ComGetEtcData(sXml,"curr_cd_list");
			var sStr2 = ComGetEtcData(sXml,"dp_prcs_knt");
			var arrStr = sStr.split("|");
			
			if(formObj.curr_cd_chg.value != "1"){
				ap_curr_cd.RemoveAll();   
				MakeRctOfcComboObject(ap_curr_cd, arrStr);
			}
			
			formObj.dp_prcs_knt.value=sStr2;
			
			for(var j=sheetObjects[1].HeaderRows(); j<= sheetObjects[1].LastRow(); j++){
				if(sheetObjects[1].GetRowHidden(j) == false){
					sheetObjects[1].SetCellValue(j, prefix2+"dp_prcs_knt",formObj.dp_prcs_knt.value,0);
				}
			}
			
			formObj.curr_cd_chg.value = "0";
			break;
			
		case IBSEARCH_ASYNC07: // ASA No
			formObj.f_cmd.value = SEARCH03;
			var sXml = sheetObj.GetSearchData("STM_SAR_3001GS.do", FormQueryString(formObj));
			var sStr = ComGetEtcData(sXml,"p_asa_no_curr_cd");
			
			if(sStr==null || sStr==undefined)return;
			var arrStr = sStr.split("|");
			
			MakeRctOfcMultiComboObject(asa_no, arrStr);
			break;
			
		case IBSEARCH_ASYNC08: // Ex.Rate
			formObj.f_cmd.value = SEARCH02;
			
			var sParam2 = ComGetSaveString(sheetObjects[1], true, true);
			
			if(sParam2 == "" ){
				return;
			}
			
			var sParam = sParam2 + "&" +FormQueryString(formObj);
			
			var sXml = sheetObj.GetSearchData("STM_SAR_3001GS.do", sParam);
			
			var sStr = ComGetEtcData(sXml,"legr_xch_rt");
			var arrStr = sStr.split("|");
			
			var i=0;
			
			for(var j=sheetObjects[1].HeaderRows(); j<= sheetObjects[1].LastRow(); j++){
				if(sheetObjects[1].GetCellValue(j, prefix2+"adj_crs_curr_cd") != ""){
					sheetObjects[1].SetCellValue(j, prefix2+"adj_xch_rt_tmp",arrStr[i]);
					
					var point=sheetObj.GetCellValue(j, prefix2+"dp_prcs_knt");
					var crsAmtTemp = sheetObjects[1].GetCellValue(j, prefix2+"ots_adj_bal_amt") * sheetObjects[1].GetCellValue(j, prefix2+"adj_xch_rt_tmp");

					sheetObjects[1].SetCellValue(j, prefix2+"adj_crs_curr_amt_tmp", SarRound(crsAmtTemp,point), 0);
				}
				
				i++;
			}
			
			getGlAmt(); 
			break;
	}
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj, frmObj, sAction) {
	 var cnt=0;
	 
  	 switch (sAction) {
		   	case IBSEARCH:
					frmObj.search_tp.value = "1";
					ComBtnDisable("btn_otsadd");
					ComBtnDisable("btn_save");
					ComBtnEnable("btn_Reverse");
			break;
			
		   	case IBSEARCHAPPEND: // Retrieve
				// Check Duplication
				for(var i = sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++){
					if(frmObj.bl_no.value != ""){
						if(sheetObj.GetCellValue(i, prefix1+"bl_no") == frmObj.bl_no.value){
							ComShowCodeMessage("COM131302", "BL No");
		    				ComSetFocus(frmObj.bl_no);
		    				return false
						}
					}else if(frmObj.inv_no.value != ""){
						if(sheetObj.GetCellValue(i, prefix1+"inv_no") ==  frmObj.inv_no.value){
							ComShowCodeMessage("COM131302", "Invoice No");
		    				ComSetFocus(frmObj.inv_no);
		    				return false
						}
					}
				}				
				frmObj.search_tp.value = "2";
				ComBtnDisable("btn_retrieve");				
			break;
			
		   	case IBSAVE: // Save
		   		if(frmObj.search_tp.value != "2"){
					ComShowCodeMessage("COM130503", "");		
					return false;
				}else if(dtl_adj_tp_cd.GetSelectText() == ""){
					ComShowCodeMessage("COM130403", "Adjust Type Code");
					return false;
				}
		   		
		   		for(var i = sheetObjects[0].HeaderRows(); i <= sheetObjects[0].LastRow(); i++){
		   			if( sheetObjects[0].GetCellValue(i, prefix1+"pay_acct_cd") != "" && sheetObjects[0].GetCellValue(i, prefix1+"vndr_no") == "" ){
						ComShowCodeMessage("SAR00013", "AP Vendor");
						return false;
		   			}else if( sheetObjects[0].GetCellValue(i, prefix1+"pay_acct_cd") != "" && sheetObjects[0].GetCellValue(i, prefix1+"ap_ofc_cd") == "" ){
						ComShowCodeMessage("SAR00013", "AP Office");
						return false;
		   			}else if( sheetObjects[0].GetCellValue(i, prefix1+"pay_acct_cd") != "" && sheetObjects[0].GetCellValue(i, prefix1+"ap_curr_cd") == "" ){
						ComShowCodeMessage("SAR00013", "AP Currency");
						return false;
		   			}else if( sheetObjects[0].GetCellValue(i, prefix1+"pay_acct_cd") != "" && sheetObjects[0].GetCellValue(i, prefix1+"ap_rmk") == "" ){
						ComShowCodeMessage("SAR00013", "AP Remark");
						return false;
					}
		   		}
		   		
		   		for(var i = sheetObjects[0].HeaderRows(); i <= sheetObjects[0].LastRow(); i++){
		   			var sheet1_key = sheetObjects[0].GetCellValue(i, prefix1+"ots_hdr_key");
		   			var crsCurrAmt = 0;
		   			
					for(var j = sheetObjects[1].HeaderRows(); j <= sheetObjects[1].LastRow(); j++){
						var sheet2_key = sheetObjects[1].GetCellValue(j, prefix2+"ots_dtl_key");
						
						if(sheet1_key == sheet2_key){
							if( (sheetObjects[1].GetCellValue(j, prefix2+"ots_adj_bal_amt") != ""
								&& (sheetObjects[1].GetCellValue(j, prefix2+"adj_xch_rt") == "" || sheetObjects[1].GetCellValue(j, prefix2+"adj_xch_rt") == 0))
									&& sheetObjects[0].GetCellValue(i, prefix1+"pay_acct_cd") != ""){
								sheetObjects[1].SelectCell(j, prefix2+"adj_xch_rt");
								ComShowCodeMessage("SAR00016", "");
								return false;
							}
							
							if(sheetObjects[1].GetCellValue(j, prefix2+"ots_adj_bal_amt") != ""){
								cnt++;
							}
							
							//2016.01.15 check balance for RFD
							if(sheetObjects[1].GetCellValue(j, prefix2+"adj_tp_cd") == "RFD"){
								crsCurrAmt = parseFloat(crsCurrAmt) + parseFloat(ComReplaceStr(sheetObjects[1].GetCellValue(j, prefix2+"adj_crs_curr_amt"), ",", ""));
							}
						}
					}
					
					if(crsCurrAmt < 0){
						ComShowCodeMessage("SAR00073", "RFD");
						return false;
					}
		   		}
		   		
		   		if(cnt == 0){
					ComShowCodeMessage("SAR00006", "Amount");
					return false;
				}
				
			break;
  	 } 
	return true;
}   

function sheet1_OnClick(sheetObj, Row, Col, Value) {
	var formObj = document.form;
	
	sheet1ClickOnOff = "1";
	
	dtlSheetSetup();
	
	// sheet1's hidden column to AR/AP Info
	formObj.adj_rmk.value = sheetObj.GetCellValue(Row, prefix1+"adj_rmk");
	formObj.ap_ofc_cd.value = sheetObj.GetCellValue(Row, prefix1+"ap_ofc_cd");
	asa_no.SetSelectText(sheetObj.GetCellValue(Row, prefix1+"asa_no"));
	formObj.vndr_no.value = sheetObj.GetCellValue(Row, prefix1+"vndr_no");
	ap_curr_cd.SetSelectText(sheetObj.GetCellValue(Row, prefix1+"ap_curr_cd"));
	formObj.ap_crs_curr_amt.value = sheetObj.GetCellValue(Row, prefix1+"ap_crs_curr_amt");
	formObj.gain_and_lss_amt.value = sheetObj.GetCellValue(Row, prefix1+"gain_and_lss_amt");
	formObj.ap_rmk.value = sheetObj.GetCellValue(Row, prefix1+"ap_rmk");
	
	if(formObj.search_tp.value == "2"){
		formObj.adj_no.value = sheetObj.GetCellValue(Row, prefix1+"adj_no_hdr");
	}
	
	changeApIfForm(formObj);	
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {	
	var formObj = document.form;
	
	if(formObj.search_tp.value == "2" && formObj.adj_tp[0].checked == true && (payAcctCd[selIndex] != "" || payAcctCd[selIndex] != undefined)){	
		// set Header info(set all adjust type rows of sheet)
		sheetObjects[0].SetCellValue(sheetObjects[0].LastRow(), prefix1+"adj_tp_cd", adj_tp_cd.GetSelectText(), 0);
		sheetObjects[0].SetCellValue(sheetObjects[0].LastRow(), prefix1+"pay_acct_cd", payAcctCd[selIndex], 0);
	}
	
	if(sheetObj.RowCount()!= 0){
		// After Retrieve adj no, set sheet1 value to Form and ar/ap info disabled
		if (formObj.search_tp.value == "1"){
			formObj.rvs_flg.value = sheetObj.GetCellValue(sheetObj.HeaderRows(), prefix1+"rvs_flg");
			formObj.adj_rmk.value = sheetObj.GetCellValue(sheetObj.HeaderRows(), prefix1+"adj_rmk");
			formObj.ap_ofc_cd.value = sheetObj.GetCellValue(sheetObj.HeaderRows(), prefix1+"ap_ofc_cd");
			asa_no.SetSelectText(sheetObj.GetCellValue(sheetObj.HeaderRows(), prefix1+"asa_no"));
			formObj.vndr_no.value = sheetObj.GetCellValue(sheetObj.HeaderRows(), prefix1+"vndr_no");
			ap_curr_cd.SetSelectText(sheetObj.GetCellValue(sheetObj.HeaderRows(), prefix1+"ap_curr_cd"));
			formObj.ap_crs_curr_amt.value = sheetObj.GetCellValue(sheetObj.HeaderRows(), prefix1+"ap_crs_curr_amt");
			formObj.gain_and_lss_amt.value = sheetObj.GetCellValue(sheetObj.HeaderRows(), prefix1+"gain_and_lss_amt");
			formObj.ap_rmk.value = sheetObj.GetCellValue(sheetObj.HeaderRows(), prefix1+"ap_rmk");
			
			sheetObj.SetCellValue(sheetObj.HeaderRows(), prefix1+"pay_acct_cd",payAcctCd[selIndex],0);
			
			ComEnableObject(formObj.adj_rmk,false);
		} else{ // After Retrieve bl no of inv no, ar/ap info disabled
			formObj.rvs_flg.value = "N";
			sheetObj.SetCellValue(sheetObj.LastRow(), prefix1+"rvs_flg","N",0);
		}
		
		changeApIfForm(formObj);	
	}
}

function sheet2_OnClick(sheetObj, Row, Col, Value) {
	var formObj=document.form;
	
	changeApIfForm(formObj);	
 }

function sheet2_OnSearchEnd(sheetObj, ErrMsg) {	
	var formObj = document.form;
	
	if(formObj.search_tp.value == "2" && formObj.adj_tp[0].checked == true && (payAcctCd[selIndex] != "" || payAcctCd[selIndex] != undefined)){
		 
		// set Detail info(set all adjust type rows of sheet) 
		for(var i=sheetObjects[1].HeaderRows(); i<= sheetObjects[1].LastRow(); i++){
			if(sheetObjects[0].GetCellValue(sheetObjects[0].LastRow(), prefix1+"ots_hdr_key") == sheetObjects[1].GetCellValue(i, prefix2+"ots_dtl_key")){
				sheetObjects[1].SetCellValue(i, prefix2+"adj_tp_cd", adj_tp_cd.GetSelectText(), 0);				
			}
		}
	}
	
	dtlSheetSetup();
}

function sheet2_OnChange(sheetObj, Row, Col, Value) {
	var formObj=document.form; 
	
	if(sheetObj.ColSaveName(Col) == prefix2+"ots_adj_bal_amt"){
		if(dtl_adj_tp_cd.GetSelectText() == ""){
			ComShowCodeMessage("COM130403", "Adjust Type Code");
			sheetObj.SetCellValue(Row, prefix2+"ots_adj_bal_amt","",0);
			return
		} else{		
			
			var chgCurrPoint=sheetObj.GetCellValue(Row, prefix2+"curr_dp_prcs_knt");
			sheetObj.SetCellValue(Row, prefix2+"ots_adj_bal_amt",ComTrunc(sheetObj.GetCellValue(Row, prefix2+"ots_adj_bal_amt"), chgCurrPoint),0);
			
			if(amtSgnCdXml[selIndex] == "M" && sheetObj.GetCellValue(Row,  prefix2+"ots_adj_bal_amt") > 0 && sheetObj.GetCellValue(Row,  prefix2+"ots_adj_bal_amt") != ""){
				ComShowCodeMessage("SAR00027", sheetObj.GetCellValue(Row,  prefix2+"adj_tp_cd"));
				sheetObj.SetCellValue(Row, prefix2+"ots_adj_bal_amt","",0);
				sheetObj.SelectCell(Row, 0);
				return;
			} else if(amtSgnCdXml[selIndex] == "M" && parseFloat(ComReplaceStr(sheetObj.GetCellValue(Row,  prefix2+"ots_bal_amt"), ",", "")) < 0 && sheetObj.GetCellValue(Row,  prefix2+"ots_adj_bal_amt") != ""){
				ComShowCodeMessage("SAR00026", "Balance");
				sheetObj.SetCellValue(Row,  prefix2+"ots_adj_bal_amt","",0);
				sheetObj.SelectCell(Row, 0);
				return;
			}
			
			//2016.01.15 Skip in case of RFD
			if(sheetObj.GetCellValue(Row, prefix2+"adj_tp_cd") != "RFD"){
				if (amtSgnCdXml[selIndex] == "P" && sheetObj.GetCellValue(Row,  prefix2+"ots_adj_bal_amt") < 0 && sheetObj.GetCellValue(Row,  prefix2+"ots_adj_bal_amt") != ""){
					ComShowCodeMessage("SAR00026", sheetObj.GetCellValue(Row,  prefix2+"adj_tp_cd"));
					sheetObj.SetCellValue(Row,  prefix2+"ots_adj_bal_amt","",0);
					sheetObj.SelectCell(Row, 0);
					return;
				} else if(amtSgnCdXml[selIndex] == "P" && parseFloat(ComReplaceStr(sheetObj.GetCellValue(Row,  prefix2+"ots_bal_amt"), ",", "")) > 0 && sheetObj.GetCellValue(Row,  prefix2+"ots_adj_bal_amt") != ""){
					ComShowCodeMessage("SAR00027", "Balance");
					sheetObj.SetCellValue(Row,  prefix2+"ots_adj_bal_amt","",0);
					sheetObj.SelectCell(Row, 0);
					return;
				}
			} else {
				if (parseFloat(ComReplaceStr(sheetObj.GetCellValue(Row,  prefix2+"ots_bal_amt"), ",", "")) < 0 && sheetObj.GetCellValue(Row,  prefix2+"ots_adj_bal_amt") < 0 && sheetObj.GetCellValue(Row,  prefix2+"ots_adj_bal_amt") != ""){
					ComShowCodeMessage("SAR00026", sheetObj.GetCellValue(Row,  prefix2+"chg_tp_cd"));
					sheetObj.SetCellValue(Row,  prefix2+"ots_adj_bal_amt","",0);
					sheetObj.SelectCell(Row, 0);
					return;
				} else if(parseFloat(ComReplaceStr(sheetObj.GetCellValue(Row,  prefix2+"ots_bal_amt"), ",", "")) > 0 && sheetObj.GetCellValue(Row,  prefix2+"ots_adj_bal_amt") > 0 && sheetObj.GetCellValue(Row,  prefix2+"ots_adj_bal_amt") != ""){
					ComShowCodeMessage("SAR00027", sheetObj.GetCellValue(Row,  prefix2+"chg_tp_cd"));
					sheetObj.SetCellValue(Row,  prefix2+"ots_adj_bal_amt","",0);
					sheetObj.SelectCell(Row, 0);
					return;
				}
			}
			
			//Check MI/ML Limit Amount
			if((sheetObj.GetCellValue(Row, prefix2+"adj_tp_cd") == "MI" || sheetObj.GetCellValue(Row, prefix2+"adj_tp_cd") == "ML") && 
			    sheetObj.GetCellValue(Row, prefix2+"ots_adj_bal_amt") != "0" && sheetObj.GetCellValue(Row, prefix2+"ots_adj_bal_amt") != ""){
				formObj.misc_ofc_cd.value = formObj.adjt_ofc_cd.value;
				formObj.misc_tp_cd.value = sheetObj.GetCellValue(Row, prefix2+"adj_tp_cd");
				formObj.misc_xch_rt_dt.value = formObj.adj_dt.value;
				formObj.misc_amt.value = sheetObj.GetCellValue(Row, prefix2+"ots_adj_bal_amt");
				formObj.misc_curr_cd.value = sheetObj.GetCellValue(Row, prefix2+"bl_curr_cd");
				
				formObj.f_cmd.value = SEARCH13;
				var sXml = sheetObj.GetSearchData("SARCommonGS.do", FormQueryString(formObj));
				var chkMiscLmt = ComGetEtcData(sXml,"chk_misc_lmt");
				
				if(chkMiscLmt != "Y") {
					if(chkMiscLmt == "R") ComShowCodeMessage("SAR00025");
					else if(chkMiscLmt == "X") ComShowCodeMessage("SAR00045");
					else if(chkMiscLmt == "N") ComShowCodeMessage("SAR00046", sheetObj.GetCellValue(Row, prefix2+"adj_tp_cd"));
				
					sheetObj.SetCellValue(Row, prefix2+"ots_adj_bal_amt", "", 0);
					sheetObj.SelectCell(Row, prefix2+"ots_adj_bal_amt", true, "");
					return;
				}
			}
			
			if(!(sheetObj.GetCellValue(Row, prefix2+"adj_tp_cd") == "RFD" && 
			    (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), prefix1+"ar_finc_src_cd") == "STM AR" ||
			     sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), prefix1+"ar_finc_src_cd") == "STM AP"))){
				if(sheetObj.GetCellValue(Row, prefix2+"ots_adj_bal_amt") != "0" && sheetObj.GetCellValue(Row, prefix2+"ots_adj_bal_amt") != ""){
					var otsbal = sheetObj.GetCellValue(Row,  prefix2+"ots_bal_amt").replace(",", "");
					var adjbal = sheetObj.GetCellValue(Row, prefix2+"ots_adj_bal_amt");
					if(Math.abs(otsbal) < Math.abs(adjbal)){
						ComShowCodeMessage("SAR00061");
						sheetObj.SetCellValue(Row, prefix2+"ots_adj_bal_amt", "", 0);
						sheetObj.SelectCell(Row, prefix2+"ots_adj_bal_amt", true, "");
						return;
					}
				}
			}
		}
	} else if(sheetObj.ColSaveName(Col) == prefix2+"adj_xch_rt"){
		if(dtl_adj_tp_cd.GetSelectText() == ""){
			ComShowCodeMessage("COM130403", "Adjust Type Code");
			sheetObj.SetCellValue(Row, prefix2+"adj_xch_rt","",0);
			return
		}else if((payAcctCd[selIndex] == "" || payAcctCd[selIndex] == undefined) && sheetObj.GetCellValue(Row,  prefix2+"adj_crs_curr_cd") == ""){
			ComShowCodeMessage("COM130403", "Adjust Currency");
			sheetObj.SetCellValue(Row, prefix2+"adj_xch_rt","",0);
			return
		}else if( sheetObj.GetCellValue(Row,  prefix2+"bl_curr_cd") == sheetObj.GetCellValue(Row,  prefix2+"adj_crs_curr_cd")){
			sheetObj.SetCellValue(Row,  prefix2+"adj_xch_rt",1);
		}else{
			sheetObj.SetCellValue(Row, prefix2+"adj_xch_rt",ComTrunc(sheetObj.GetCellValue(Row, prefix2+"adj_xch_rt"), 6),0);
		}
	}
	
	if(sheetObj.ColSaveName(Col) == prefix2+"ots_adj_bal_amt" || sheetObj.ColSaveName(Col) == prefix2+"adj_xch_rt" || sheetObj.ColSaveName(Col) == prefix2+"adj_crs_curr_cd"){
		var curr_point=sheetObj.GetCellValue(Row, prefix2+"curr_dp_prcs_knt");
		var point=sheetObj.GetCellValue(Row, prefix2+"dp_prcs_knt");
		
		// set amount balance amount
		if(curr_point == '0' || curr_point == undefined || curr_point == "") {
			sheetObj.InitCellProperty(Row, prefix2+"ots_adj_bal_amt",{ Type:"Int",Align:"Right",Format:"NullInteger"} );
		} else {
			sheetObj.InitCellProperty(Row, prefix2+"ots_adj_bal_amt",{ Type:"Float",Align:"Right",Format:"NullFloat",PointCount:curr_point} );
		}
		
		// set amount with Ex.Rate
		if(point == '0' || point == undefined || point == "") {
			sheetObj.InitCellProperty(Row, prefix2+"adj_crs_curr_amt",{ Type:"Int",Align:"Right",Format:"NullInteger",PointCount:point} );
			sheetObj.InitCellProperty(Row, prefix2+"adj_crs_curr_amt_tmp",{ Type:"Int",Align:"Right",Format:"NullInteger",PointCount:point} );
		} else {
			sheetObj.InitCellProperty(Row, prefix2+"adj_crs_curr_amt",{ Type:"Float",Align:"Right",Format:"NullFloat",PointCount:point} );
			sheetObj.InitCellProperty(Row, prefix2+"adj_crs_curr_amt_tmp",{ Type:"Float",Align:"Right",Format:"NullFloat",PointCount:point} );
		}
		
		if (sheetObj.GetCellValue(Row, prefix2+"ots_adj_bal_amt") == "" || sheetObj.GetCellValue(Row, prefix2+"adj_xch_rt") == ""){
			sheetObj.InitCellProperty(Row, prefix2+"adj_crs_curr_amt",{ Type:"Float",Align:"Right",Format:"NullFloat",PointCount:1} );
			sheetObj.InitCellProperty(Row, prefix2+"adj_crs_curr_amt_tmp",{ Type:"Float",Align:"Right",Format:"NullFloat",PointCount:1} );
			sheetObj.SetCellValue(Row, prefix2+"adj_crs_curr_amt","",0);
			sheetObj.SetCellValue(Row, prefix2+"adj_crs_curr_amt_tmp","",0);
		} else{			
			var crsamt = sheetObj.GetCellValue(Row, prefix2+"ots_adj_bal_amt") * sheetObj.GetCellValue(Row, prefix2+"adj_xch_rt");
			var crsAmtTemp = sheetObj.GetCellValue(Row, prefix2+"ots_adj_bal_amt") * sheetObj.GetCellValue(Row, prefix2+"adj_xch_rt_tmp");

			sheetObj.SetCellValue(Row, prefix2+"adj_crs_curr_amt", SarRound(crsamt,point), 0);
			sheetObj.SetCellValue(Row, prefix2+"adj_crs_curr_amt_tmp", SarRound(crsAmtTemp,point), 0);
		}
		
		getGlAmt();
	}
}

/**
 * Initialize screen.<br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * </pre>
 * 
 * @param {object}
 *            formObj
 * @return none.
 */
function removeAll(formObj) {
	var sheetObject1 = sheetObjects[0];	
	var formObj = document.form;
	
	formObj.reset();
	
	sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
	comboObjects[0].RemoveAll();
	comboObjects[1].RemoveAll();
	comboObjects[2].RemoveAll();
	comboObjects[3].RemoveAll();
	comboObjects[4].RemoveAll();
	
	sheetObjects[0].RemoveEtcData();
	sheetObjects[1].RemoveEtcData();
	
	doActionIBSheet(sheetObject1, formObj, IBSEARCH_ASYNC01);
    //doActionIBSheet(sheetObject1, formObj, IBSEARCH_ASYNC02);
    doActionIBSheet(sheetObject1, formObj, IBSEARCH_ASYNC03);
    doActionIBSheet(sheetObject1, formObj, IBSEARCH_ASYNC06);
    
    ComEnableObject(formObj.adj_rmk,true);
    ComEnableObject(formObj.ap_ofc_cd,false);
    formObj.ap_ofc_cd.className="input1";
    ComEnableObject(formObj.vndr_no,false);
    formObj.vndr_no.className="input1";
    ComEnableObject(formObj.ap_rmk,false);
    formObj.ap_rmk.className="input1";
    
    ComBtnEnable("btn_otsadd");
    ComBtnEnable("btn_retrieve");
    ComBtnEnable("btn_save");
    ComBtnEnable("btn_rowdelete_hdr");
    ComBtnEnable("btn_rowdelete_dtl");
    
    asa_no.SetEnable(0);
    ap_curr_cd.SetEnable(0);
    adj_tp_cd.SetEnable(0);
    dtl_adj_tp_cd.SetEnable(1);
    ap_curr_cd.SetSelectText("");
    dtl_adj_tp_cd.SetSelectText("");
    selIndex="";
}

/**
 * Setup ALL Detail to Partitial Detail.<br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * </pre>
 * 
 * @param {var}
 *            sheet1_key
 * @return none.
 */
function dtlSheetSetup(){
	var formObj = document.form;
	
	var sheet1_key = "";
	var sheet2_key_name = "";
	var sheet2_firstRow = 0;
	
	// get kind of sheet1 key
	if(sheetObjects[1].RowCount()!= 0){
		if(formObj.search_tp.value == "1"){
			sheet1_key = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), prefix1+"ots_adj_seq");
			sheet2_key_name = prefix2+"ots_adj_seq";			
		}else if(formObj.search_tp.value == "2"){
			sheet1_key = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), prefix1+"ots_hdr_key");
			sheet2_key_name = prefix2+"ots_dtl_key";
		}
		
		// set Detail info(hide Detail info row)
		for (var i = sheetObjects[1].HeaderRows(); i <= sheetObjects[1].LastRow(); i++){
			if(sheet1_key != sheetObjects[1].GetCellValue(i, sheet2_key_name)){
				sheetObjects[1].SetRowHidden(i,1);
			}else{
				sheetObjects[1].SetRowHidden(i,0);
				if(sheet2_firstRow == 0){
					sheet2_firstRow = i;					
					sheetObjects[1].SelectCell(i, prefix2+"chg_tp_cd")
					sheetObjects[0].SelectCell(sheetObjects[0].GetSelectRow(), prefix1+"bl_no")
				}				
			}	
		}
		
		// Set Detail Sheet Adjust Type to Combo.
		dtl_adj_tp_cd.SetSelectText(sheetObjects[1].GetCellValue(sheet2_firstRow, prefix2+"adj_tp_cd"));
		
		if(dtl_adj_tp_cd.GetSelectText() != sheetObjects[1].GetCellValue(sheet2_firstRow, prefix2+"adj_tp_cd")){
			selIndex = ""; 
			dtl_adj_tp_cd.SetSelectText(""); 
			dtl_adj_tp_cd.SetViewText(sheetObjects[1].GetCellValue(sheet2_firstRow, prefix2+"adj_tp_cd"));
		}
	}
}

/**
 * create combo box<br>
 * <br>
 * <b>Example : </b>
 * 
 * <pre>
 * MakeRctOfcComboObject(cmbObj, arrStr);
 * </pre>
 * 
 * @param object
 *            cmbObj
 * @param String
 *            arrStr
 * @author Park sung yong
 * @version 2014.03.24
 */
function MakeRctOfcComboObject(cmbObj, arrStr) {
	for (var i = 1; i < arrStr.length; i++) {
		var arrStr2 = arrStr[i].split("^");
		var otsOfcCd = arrStr2[0];
		cmbObj.InsertItem(i-1, otsOfcCd, arrStr[i]);			 
	}
	cmbObj.SetDropHeight(190);
}  

/**
 * create combo box<br>
 * <br>
 * <b>Example : </b>
 * 
 * <pre>
 * MakeRctOfcMultiComboObject(cmbObj, arrStr);
 * </pre>
 * 
 * @param object
 *            cmbObj
 * @param String
 *            arrStr
 * @author Park sung yong
 * @version 2014.03.24
 */
function MakeRctOfcMultiComboObject(cmbObj, arrStr) {
	var arrItem = new Array(arrStr.length);
	for (var i = 1; i < arrStr.length; i++ ) {
		var arrStr2 = arrStr[i].split("\t");
		var arrCd = arrStr2[0];
		var arrNm = arrStr2[1];
		
		cmbObj.InsertItem(i-1, arrCd + "|" + arrNm, arrStr[i]);
	}
	
	cmbObj.SetDropHeight(190);
}  

function changeApIfForm(formObj) {
	// after retrieve bl no or inv no
	if(formObj.search_tp.value == "2"){
		// if payAcctCd is not null then ==> ar/ap info enable
		if( selIndex != "" && payAcctCd[selIndex] != "" && payAcctCd[selIndex] != undefined){
			 ComEnableObject(formObj.adj_rmk,true);
			 ComEnableObject(formObj.ap_ofc_cd,true);
			 formObj.ap_ofc_cd.className="input1";
			 ComEnableObject(formObj.vndr_no,true);
			 formObj.vndr_no.className="input1";
			 ComEnableObject(formObj.ap_rmk,true);
			 formObj.ap_rmk.className="input1";
			 ComEnableObject(formObj.btns_vndr_no,true);
			 ComEnableObject(formObj.btns_ap_ofc_cd,true);
			 asa_no.SetEnable(1);
			 ap_curr_cd.SetEnable(1);
		 }else{ // ar/ap info disabled
			 ComEnableObject(formObj.adj_rmk,true);
			 ComEnableObject(formObj.ap_ofc_cd,false);
			 ComEnableObject(formObj.vndr_no,false);
			 ComEnableObject(formObj.ap_rmk,false);
			 ComEnableObject(formObj.btns_vndr_no,false);
			 ComEnableObject(formObj.btns_ap_ofc_cd,false);
			 
			 asa_no.SetEnable(0);
			 ap_curr_cd.SetEnable(0);
		 }	
	}else if(formObj.search_tp.value == "1"){
		 ComEnableObject(formObj.adj_rmk,true);
		 formObj.ap_ofc_cd.className = "input1";
		 ComEnableObject(formObj.ap_ofc_cd,false);
		 formObj.vndr_no.className = "input1";
		 ComEnableObject(formObj.vndr_no,false);
		 ComEnableObject(formObj.ap_rmk,false);
		 ComEnableObject(formObj.btns_vndr_no,false);
		 ComEnableObject(formObj.btns_ap_ofc_cd,false);
		 
		 asa_no.SetEnable(0);
		 ap_curr_cd.SetEnable(0);
	}
}  

/**
 * Setting supplier by popup
 */
function setSupplier(aryPopupData) {
	var formObj=document.form;
	var sheetObject1=sheetObjects[0];
	document.form.vndr_no.value = aryPopupData[0][1];
	sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), prefix1+"vndr_no", formObj.vndr_no.value, 0);
}  

/**
 * Getting G/L Amount
 */
function getGlAmt(){
	var formObj = document.form;
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	
	var ttl_adj_amt = 0;
	var ttl_adj_amt2 = 0;
	var ttl_gl_amt = 0;	 
	var dpPrcsKntRow ="";
	
	var str_ttl_adj_amt = "";
	var str_gl_amt = "";
	 
	for(var i=sheetObject1.HeaderRows(); i<= sheetObject1.LastRow(); i++){
		ttl_adj_amt = 0;
		ttl_adj_amt2 = 0;
		ttl_gl_amt = 0;	
		dpPrcsKntRow ="";
		str_ttl_adj_amt = "";
		str_gl_amt = "";
		for(var j=sheetObject2.HeaderRows(); j<= sheetObject2.LastRow(); j++){
			 if(sheetObject1.GetCellValue(i, prefix1+"ots_hdr_key") == sheetObject2.GetCellValue(j, prefix2+"ots_dtl_key")){
				 ttl_adj_amt = parseFloat(ttl_adj_amt) + parseFloat(Number(sheetObject2.GetCellValue(j, prefix2+"adj_crs_curr_amt")));
				 ttl_adj_amt2 = parseFloat(ttl_adj_amt2) + parseFloat(Number(sheetObject2.GetCellValue(j, prefix2+"adj_crs_curr_amt_tmp")));
				 dpPrcsKntRow = sheetObject2.GetCellValue(j, prefix2+"dp_prcs_knt");
			 }
		}
		ttl_adj_amt = SarRound(ttl_adj_amt,dpPrcsKntRow);
		ttl_gl_amt = SarRound(ttl_adj_amt2 - ttl_adj_amt,dpPrcsKntRow);
		
		str_ttl_adj_amt = String(ttl_adj_amt);
		str_gl_amt = String(ttl_gl_amt);
		
		sheetObject1.SetCellValue(i, prefix1+"ap_crs_curr_amt",  str_ttl_adj_amt, 0); 
		sheetObject1.SetCellValue(i, prefix1+"gain_and_lss_amt", str_gl_amt, 0); 
		
		if(dpPrcsKntRow == "0"){
			str_ttl_adj_amt = ComAddComma2(str_ttl_adj_amt, "#,###");
			str_gl_amt = ComAddComma2(str_gl_amt, "#,###");	
		}else if(dpPrcsKntRow == "1"){
			str_ttl_adj_amt = ComAddComma2(str_ttl_adj_amt, "#,###.0");
			str_gl_amt = ComAddComma2(str_gl_amt, "#,###.0");
		}else if(dpPrcsKntRow == "" || dpPrcsKntRow == "2"){
			str_ttl_adj_amt = ComAddComma2(str_ttl_adj_amt, "#,###.00");
			str_gl_amt = ComAddComma2(str_gl_amt, "#,###.00");
		}
		
		if(i == sheetObject1.GetSelectRow()){
			formObj.ap_crs_curr_amt.value = str_ttl_adj_amt;
			formObj.gain_and_lss_amt.value = str_gl_amt; 
		}
	}
}

/**
 * Reset Same Type
 */
function reSetSameType(formObj) {
	 if(formObj.search_tp.value == "2") {		 
		// set Detail info(set all adjust type rows of sheet)
		for(var i=sheetObjects[1].HeaderRows(); i<= sheetObjects[1].LastRow(); i++){
			sheetObjects[1].SetCellValue(i, prefix2+"adj_tp_cd", "", 0);
			
			sheetObjects[1].InitCellProperty(i, prefix2+"adj_crs_curr_amt",{ Type:"Float",Align:"Right",Format:"NullFloat",PointCount:1} );
			sheetObjects[1].InitCellProperty(i, prefix2+"adj_crs_curr_amt_tmp",{ Type:"Float",Align:"Right",Format:"NullFloat",PointCount:1} );
			
			sheetObjects[1].SetCellValue(i, prefix2+"adj_xch_rt", "", 0);
			sheetObjects[1].SetCellValue(i, prefix2+"adj_crs_curr_cd", "", 0);
			sheetObjects[1].SetCellValue(i, prefix2+"adj_crs_curr_amt", "", 0);
			sheetObjects[1].SetCellValue(i, prefix2+"adj_xch_rt_tmp", "", 0);
			sheetObjects[1].SetCellValue(i, prefix2+"adj_crs_curr_amt_tmp", "", 0);
		}
		
		// set Header info(set all adjust type rows of sheet)
		for(var i=sheetObjects[0].HeaderRows(); i<= sheetObjects[0].LastRow(); i++){
			sheetObjects[0].SetCellValue(i, prefix1+"adj_tp_cd", "", 0);
			sheetObjects[0].SetCellValue(i, prefix1+"pay_acct_cd", "", 0);
			sheetObjects[0].SetCellValue(i, prefix1+"adj_rmk", "", 0);
			sheetObjects[0].SetCellValue(i, prefix1+"ap_ofc_cd", "", 0);
			sheetObjects[0].SetCellValue(i, prefix1+"asa_no", "", 0);
			sheetObjects[0].SetCellValue(i, prefix1+"vndr_no", "", 0);
			sheetObjects[0].SetCellValue(i, prefix1+"ap_curr_cd", "", 0);
			sheetObjects[0].SetCellValue(i, prefix1+"ap_crs_curr_amt", "", 0);
			sheetObjects[0].SetCellValue(i, prefix1+"gain_and_lss_amt", "", 0);
			sheetObjects[0].SetCellValue(i, prefix1+"ap_rmk", "", 0);
		}
	    formObj.adj_rmk.value="";
	    formObj.ap_ofc_cd.value="";
	    asa_no.SetSelectText("");
	    formObj.vndr_no.value="";
	    ap_curr_cd.SetSelectText("");
	    formObj.ap_crs_curr_amt.value="";
	    formObj.gain_and_lss_amt.value="";
	    formObj.ap_rmk.value="";
	 }
}

function displayObject(objNm, flg) {
	$obj = $('#' + objNm);
	if (!$obj[0] || flg == undefined) return;
	if (flg == true)
		$obj.show();
	else
		$obj.hide();
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[0], 240);
    ComResizeSheet(sheetObjects[1], 240);
}