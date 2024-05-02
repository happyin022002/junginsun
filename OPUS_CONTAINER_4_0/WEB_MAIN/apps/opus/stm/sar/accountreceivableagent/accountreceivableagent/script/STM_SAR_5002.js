/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAR_5002.js
*@FileTitle  : [STM_SAR-5002] Agent Statement of Account Entry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
/**
 * [STM_SAR-5002] Agent Statement of Account Entry
 * @extends
 * @class Agent Statement of Account Entry
 */
// ===================================================================================
// 1> global variable
// ===================================================================================
// IBSheet 
var sheetObjects=new Array();
var sheetCnt=0;
var sheet1=null;
//IBMultiCombo
var comboObjects=new Array();
//var combo1=null
var comboCnt=0;
// html form
var frm = document.form;
var currencyPoint = 0;

/**
 * IBSheet Object를 배열로 등록
 * @param {ibsheet} sheetObj    IBSheet Object  
 **/
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}
/**
* 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
* @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
**/
function setComboObject(combo_obj){
	comboObjects[comboCnt++]=combo_obj;
}
// ===================================================================================
// 2. initializing
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
	// sheet initialize
	for (var i=0; i < sheetCnt; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	// IBMultiCombo초기화
	combo1=comboObjects[0];
	comboCnt=comboObjects.length;
	for (var k=0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k]);
	}
	
    //Form event register
    initControl();
    // combo 및 초기 데이타 취득
    doActionIBSheet(INIT);
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
            var HeadTitle1="|Seq|Description|Debit Amount|Credit Amount|Effective Date|asa_no";
            var headCount=ComCountHeadTitle(HeadTitle1);

            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:5, DataRowMerge:1 } );

            var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            InitHeaders(headers, info);

            var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
                   {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"asa_dtl_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
                   {Type:"Text",      Hidden:0,  Width:400,  Align:"Left",    ColMerge:1,   SaveName:"asa_dtl_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
                   {Type:"Float",     Hidden:0,  Width:200,  Align:"Right",   ColMerge:1,   SaveName:"asa_dr_amt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
                   {Type:"Float",     Hidden:0,  Width:200,  Align:"Right",   ColMerge:1,   SaveName:"asa_cr_amt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
                   {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"asa_no" } ];
             
            InitColumns(cols);
            //SetSheetHeight(300);
            SetDataRowHeight(25);
            SetEditable(0);
            SetColProperty("eff_dt", {Format:"####-##-##"} );
            resizeSheet(); 
            break;
		}
	}
}

function resizeSheet(){
	ComResizeSheet(sheetObjects[0], 90);
}
/**
* 콤보 초기설정값
* @param {IBMultiCombo} comboObj  comboObj
*/
function initCombo(comboObj) {
	comboObj.SetMultiSelect(0);
//no support[check again]CLT 	comboObj.UseCode=true;
//no support[check again]CLT 	comboObj.LineColor="#7896B1";	
	comboObj.SetMultiSeparator(",");
	comboObj.SetDropHeight(240);
	comboObj.SetBackColor("#CCFFFD");
}
// ===================================================================================
// Private function
// ===================================================================================
 /**
  * handling process for input validation
  */
 function validateForm() {
	 if (ComIsNull(combo1.GetSelectText())) {
		 //msgs['COM12113'] = 'Please select {?msg1}';
		 ComShowCodeMessage("COM12113" , "Office");
		 return false;
	 }
     return true;
 }
 /**
  * set form foramt data
  */ 
 function setFormFormat(asaInfo) {
	 if(ComIsNull(asaInfo["act_bal_amt"])) {
		 frm.act_bal_amt.value = ComGetMaskedValue(asaInfo["act_bal_amt"], "float");
	 } else {
		 var bal = ComRound(asaInfo["act_bal_amt"], currencyPoint) + "";
		 var balStr = "";
		 var p = bal.split(".");
		 p[0] = ComAddComma(p[0]);
		 if(p.length == 1){
			 balStr = p[0];
			 if(currencyPoint != 0){
				 balStr = balStr + "." + ComRpad("",currencyPoint, "0");
			 }
		 } else if(p.length == 2) {
			 balStr = p[0] + "." + ComRpad(p[1],currencyPoint, "0");
		 }  
		 frm.act_bal_amt.value = balStr;
	 }
	 
	 document.form.asa_prd_fm_dt.value=ComGetMaskedValue(asaInfo["asa_prd_fm_dt"], "ymd");
	 document.form.asa_prd_to_dt.value=ComGetMaskedValue(asaInfo["asa_prd_to_dt"], "ymd");
	 document.form.asa_fsh_dt.value=asaInfo["asa_fsh_dt"] == undefined ? '' : asaInfo["asa_fsh_dt"];
	 document.form.asa_apro_dt.value=asaInfo["asa_apro_dt"] == undefined ? '' : asaInfo["asa_apro_dt"];
			 
 }
 /**
  * reset form
  */ 
 function resetForm() {
	 var frm = document.form;
	 var currCd=frm.curr_cd.value;
	 var combo1_TEXT = combo1.GetSelectText();
	 frm.reset();
	 frm.curr_cd.value=currCd;
	 combo1.SetSelectText(combo1_TEXT,false);
	 
	 sheet1.RemoveAll();
	 // set ASA CNTR
	 var selOfcInfo=combo1.GetSelectCode().split("^");
	 if(ComIsNull(selOfcInfo[13])) {
		 var ofcCd = selOfcInfo[0];
		 frm.asa_no_ctnt1.value = ofcCd.substring(0, 3);
	 } else {
		 frm.asa_no_ctnt1.value = selOfcInfo[13];
     }	
	 ComEnableObject(frm.asa_no_ctnt2, true);
	 ComEnableObject(frm.asa_no_ctnt3, true);
	 
	 ComEnableObject(frm.asa_prd_fm_dt,false);
	 frm.asa_prd_fm_dt.className = "input2";
	 ComSetDisplay("btn_asa_prd_fm_dt",false); 

	 ComEnableObject(frm.asa_prd_to_dt,false);
	 frm.asa_prd_to_dt.className = "input2";
	 ComSetDisplay("btn_asa_prd_to_dt",false); 
	 
	 ComBtnEnable("btn_retrieve");
	 ComBtnEnable("btn_new");
	 ComBtnDisable("btn_creation");
	 ComBtnDisable("btn_finish");
	 ComBtnDisable("btn_reopen");			
	 ComBtnDisable("btn_approve");
 }
 /**
  * convert date -> yyyymmdd
  */
 function toFmDate(dt) {
	 var fmDt=dt;
	 if (fmDt == null) {
		 fmDt="";
	 }
	 fmDt=fmDt.replace(/\-/g, "");
	 if (fmDt.length >  8) {
		 fmDt=fmDt.substring(0, 8);
	 } else {
		 fmDt="";
	 }
	 return fmDt; 
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
	switch (srcName) {
	case "btn_asa_prd_fm_dt":
		var cal=new ComCalendar();
        cal.select(frm.asa_prd_fm_dt, 'yyyy-MM-dd');
		break;	
	case "btn_asa_prd_to_dt":
		var cal=new ComCalendar();
        cal.select(frm.asa_prd_to_dt, 'yyyy-MM-dd');
		break;
	case "btn_find":
		doActionIBSheet(SEARCHLIST);
		break;
	case "btn_new":		
		doActionIBSheet(COMMAND01);
		break;		
	case "btn_creation":
		doActionIBSheet(COMMAND02);
		break;
	case "btn_finish":
		doActionIBSheet(COMMAND03);
		break;
	case "btn_reopen":
		doActionIBSheet(COMMAND04);
		break;		
	case "btn_approve":
		doActionIBSheet(COMMAND05);
		break;
	case "btn_view_accounting":
		frm.asa_no.value="";
		if (!ComIsNull(frm.asa_no_ctnt2.value) || !ComIsNull(frm.asa_no_ctnt3.value)) {
			frm.asa_no.value=frm.asa_no_ctnt1.value + frm.asa_no_ctnt2.value  + frm.asa_no_ctnt3.value;
		}			
		if (ComIsNull(frm.asa_no.value)) {
			 //msgs['COM130403'] = 'Mandatory field is missing. Please enter {?msg1}.';
			 ComShowCodeMessage('COM130403', 'ASA No');
			 frm.asa_no_ctnt2.focus();
			return;
		}
		var param= ("adj_no=" + frm.asa_no.value + "&ots_ofc_cd=" + combo1.GetSelectText() + "&action_type=ASA");
		var popupWin=ComOpenWindowCenter("/opuscntr/STM_SAR_3004.do?" + param, "asa_view_accounting_popup", 1000, 550, false, "no");		
		popupWin.focus();
		break;		
	case "btn_excel":
		if (sheet1.RowCount()<= 0 ) {
			// msgs["SAR00030"] = "There is no data to search.";
			ComShowCodeMessage("SAR00030");
			return false;
		}
	 		sheet1.Down2Excel({ HiddenColumn:1,TreeLevel:false,SheetName:"Agent"});
		break;		
	}
}
/**
 * Form Event register
 */
function initControl() {
    // focus in
	axon_event.addListenerFormat('focus', 'obj_activate',    frm);
    axon_event.addListenerFormat('change', 'obj_change', frm);
    axon_event.addListenerFormat ('keydown', 'obj_keydown', frm);
    axon_event.addListenerForm('keypress', 'obj_keypress', frm);
    axon_event.addListenerFormat('blur', 'obj_blur', frm);
}
/**
 * HTML Control onChange
 */
function obj_change() {
    switch (ComGetEvent("name")) {
    default:
		break;
	}	
}
/**
 * HTML Control KeyPress
 */
function obj_keypress() {		
	switch(ComGetEvent().dataformat) {	
	case "engup":
		ComKeyOnlyAlphabet('upper'); 
		break;
	case "engnum":
		ComKeyOnlyAlphabet('uppernum'); 
		break;
	case "num":
    	//only number
		ComKeyOnlyNumber('num');
        break;
	case "int":
		ComKeyOnlyNumber(ComGetEvent());
		break;
	case "ymd":
		ComKeyOnlyNumber(ComGetEvent());
		break;
	case "float":
		ComKeyOnlyNumber(ComGetEvent(), "-.");
		break;
	default:
		//common standard: recognization only number, english
		var keycode="32";
		for(var i=33;  i <= 47; i++) keycode += "|" + i;
		for(var i=58;  i <= 64; i++) keycode += "|" + i;		
		for(var i=91;  i <= 96; i++) keycode += "|" + i;
		for(var i=123;  i <= 127; i++) keycode += "|" + i;
		ComKeyOnlyAlphabet('uppernum' , keycode);
		break;     
	}
}
/**
 * Handling OnKeyDown even <br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param N/A
 * @return N/A
 * @author 
 * @version 2009.04.17
 */       
function obj_keydown(){
   //Proposal No,S/C No.,Retrieving by enter key
   var eleName=ComGetEvent("name");
   var keyValue=null;
   if(event == undefined || event == null) {
	   keyValue=13;
   } else {
	   keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
   }
   // 20140901 - make 4 digit number for asa_no_ctnt3 
   if ((keyValue == 9 || keyValue == 13)  && eleName == "asa_no_ctnt3") {
	   if(frm.asa_no_ctnt3.value.length == "1"){
		   frm.asa_no_ctnt3.value = "000" + frm.asa_no_ctnt3.value;		   
	   }else if(frm.asa_no_ctnt3.value.length == "2"){
		   frm.asa_no_ctnt3.value = "00" + frm.asa_no_ctnt3.value;
	   }else if(frm.asa_no_ctnt3.value.length == "3"){
		   frm.asa_no_ctnt3.value = "0" + frm.asa_no_ctnt3.value;
	   }
   }
   if (keyValue == 13 && (eleName == "asa_no_ctnt2" || eleName == "asa_no_ctnt3")) {
	   doActionIBSheet(SEARCHLIST);
   } 
}
/**
 * HTML Control Focus out
 **/
function obj_blur() {
	ComAddSeparator(form.asa_prd_to_dt, "ymd");
	ComAddSeparator(form.asa_prd_fm_dt, "ymd");
	switch (ComGetEvent("name")) {
	case "asa_no_ctnt3":
		 if(form.asa_no_ctnt3.value.length == "1"){
			 form.asa_no_ctnt3.value = "000" + form.asa_no_ctnt3.value;		   
		 }else if(frm.asa_no_ctnt3.value.length == "2"){
			 form.asa_no_ctnt3.value = "00" + form.asa_no_ctnt3.value;
		 }else if(frm.asa_no_ctnt3.value.length == "3"){
			 form.asa_no_ctnt3.value = "0" + form.asa_no_ctnt3.value;
		 }
	case "asa_prd_fm_dt":
	case "asa_prd_to_dt":		
		ComChkObjValid(ComGetEvent());
		break;	
	default:
		break;
	}
}                                         
/**
 * HTML Control Foucs in
 */
function obj_activate(){
    ComClearSeparator(ComGetEvent());
}
//===================================================================================
//Sheet Event
//===================================================================================
function sheet1_OnClick(sheetObj, row, col, value) {	
	return false;
}
//===================================================================================
//IBCombo Event
//===================================================================================
function combo1_OnChange(comboObj, oldindex, oldtext, oldcode, newindex, newtext, newcode) {
	var frm = document.form;
	var selOfcInfo=combo1.GetSelectCode().split("^");
	if (typeof selOfcInfo.length != "undefined") {
		resetForm();
		currencyPoint = selOfcInfo[10];
		/*frm.curr_cd.length=0;
		ComAddComboItem(frm.curr_cd, selOfcInfo[9],  selOfcInfo[9]);
		// if multi agent then add USD currency
		if (selOfcInfo[16] == "MULTI" && frm.curr_cd.value != 'USD') {				
			ComAddComboItem(frm.curr_cd, "USD",  "USD");
		}*/
		frm.curr_cd.value=selOfcInfo[9];			
		if(ComIsNull(selOfcInfo[13])) {
			var ofcCd=selOfcInfo[0];
			frm.asa_no_ctnt1.value=ofcCd.substring(0, 3);
		} else {
			frm.asa_no_ctnt1.value=selOfcInfo[13];
		}
	}	
}
//===================================================================================
//do Action Processing 
//===================================================================================
/**
 * Do action 
 * @param {string} sAction
 */
function doActionIBSheet(sAction) {
	//[Search]
	if (sAction == SEARCHLIST) {
		if (validateForm()) {	
			frm.f_cmd.value=sAction;
			var ofcInfo=combo1.GetSelectCode().split("^");
			frm.agn_cd.value=ofcInfo[0];
			frm.ofc_cd.value=ofcInfo[0];
			frm.asa_no.value="";
			if (!ComIsNull(frm.asa_no_ctnt2.value) || !ComIsNull(frm.asa_no_ctnt3.value)) {
				frm.asa_no.value=frm.asa_no_ctnt1.value + frm.asa_no_ctnt2.value  + frm.asa_no_ctnt3.value;
			}			 			
			sheet1.WaitImageVisible=false;
			ComOpenWait(true);
			setTimeout( function () {
				var param=FormQueryString(frm);		
	 			var sXml=sheet1.GetSearchData("STM_SAR_5002GS.do", param);
				var arrXml=sXml.split("|$$|");
				if (arrXml.length > 0) {
					var list=SarXml2ListMap(arrXml[0]);
					// initial button
					ComBtnDisable("btn_new");
					ComBtnDisable("btn_creation");						
					ComBtnDisable("btn_finish");
					ComBtnDisable("btn_reopen");			
					ComBtnDisable("btn_approve");
					if (list.length > 0) {					
						// form 설정
						SarMapToForm(frm, list[0]);
						var asaInfo=list[0];					
						debugConsole("asaInfo"+asaInfo);					
						setFormFormat(asaInfo);					
						var asa_sts_cd=asaInfo["asa_sts_cd"];						
						if (asa_sts_cd == "O") {
							ComBtnEnable("btn_new");												
							ComBtnEnable("btn_finish");						
						} else if (asa_sts_cd == "F") {
							ComBtnEnable("btn_new");
							ComBtnEnable("btn_reopen");			
							ComBtnEnable("btn_approve");
						} else if (asa_sts_cd == "A") {	
							ComBtnEnable("btn_new");	
							combo1.SetEnable(1);
						} 
						//set currency code
						frm.curr_cd.value=asaInfo["curr_cd"];
					} else {
						ComBtnEnable("btn_new");
					} 
				}
				if (arrXml.length > 1) {
					sheet1.LoadSearchData(arrXml[1],{Sync:1} );
				} 
				if(sheet1.RowCount()== 0) {
					frm.asa_prd_fm_dt.value="";
					frm.asa_prd_to_dt.value="";
					frm.pre_asa_no.value="";
					frm.act_bal_amt.value="";
					frm.asa_fsh_dt.value="";
					frm.asa_fsh_usr_id.value="";
					frm.asa_apro_usr_id.value="";
					frm.asa_apro_dt.value="";
				}
				for(var i=1; i <= sheet1.RowCount(); i++) {
	 				sheet1.SetCellFont("FontBold", i, "asa_dtl_seq",1);
	 				sheet1.SetCellFont("FontBold", i, "asa_dtl_desc",1);
	 				sheet1.SetCellFont("FontBold", i, "asa_dr_amt",1);
	 				sheet1.SetCellFont("FontBold", i, "asa_cr_amt",1);
	 				sheet1.SetCellFont("FontBold", i, "eff_dt",1);
	 				sheet1.SetCellFont("FontSize", i, "asa_dtl_desc",10);
				}	
				 
				ComEnableObject(frm.asa_prd_fm_dt,false);
				frm.asa_prd_fm_dt.className = "input2";
				ComSetDisplay("btn_asa_prd_fm_dt",false); 
				ComEnableObject(frm.asa_prd_to_dt,false);
				frm.asa_prd_to_dt.className = "input2";
				ComSetDisplay("btn_asa_prd_to_dt",false); 
				ComEnableObject(frm.asa_no_ctnt2, true);
				ComEnableObject(frm.asa_no_ctnt3, true);	
				combo1.SetEnable(1);
				ComOpenWait(false);   
			} , 100);
		}
	//[open]	 	
	} else if (sAction == INIT) {
		// set combo outstanding offfice code
		{
			frm.f_cmd.value=SEARCH03;		
			var param="f_cmd=" + SEARCH03 + "&ofc_lvl_tp=ENTRY&ofc_brnc_agn_tp_cd=AGT";
			sheet1.WaitImageVisible=false;
			ComOpenWait(true);
			var sXml=sheet1.GetSearchData("SARCommonGS.do", param);
			var strOtsOfcCd=ComGetEtcData(sXml,"ots_ofc_cd");			
			if (!ComIsNull(strOtsOfcCd)) {
				var ofcList=strOtsOfcCd.split("|");				
				// -------------------------------------------------------------------------------------------------------------------
				//|OtsOfcCd^ArOfcCd^RhqCd^OtsSmryCd^OtsCd^RepOtsOfcCd^RctTpCd^RctUnapyFlg^OfcEntrLvlCd^ArCurrCd^DpPrcsKnt^BankCtrlCd^agnCurrCd^agnPfxCd^agnOtsLmtAmt^getOfcBrncAgnTpCd^getAgnCmbCd
				//|0       ^1      ^2    ^3        ^4    ^5          ^6      ^7          ^8           ^9       ^10       ^11        ^12       ^13      ^14                 ^15            ^16
				// -------------------------------------------------------------------------------------------------------------------
				for (var i=1; i < ofcList.length; i++ ) {
					var ofcInfo=ofcList[i].split("^");				
					combo1.InsertItem(i-1, ofcInfo[0], ofcList[i]);			 
				}				
				combo1.SetSelectIndex(0);
			}
			combo1.SetSelectText(strUsr_ofc_cd); 
			ComBtnDisable("btn_creation");
			ComBtnDisable("btn_finish");
			ComBtnDisable("btn_reopen");			
			ComBtnDisable("btn_approve");
			
			ComEnableObject(frm.asa_prd_fm_dt,false);
			frm.asa_prd_fm_dt.className = "input2";
			ComSetDisplay("btn_asa_prd_fm_dt",false); 
			ComEnableObject(frm.asa_prd_to_dt,false);
			frm.asa_prd_to_dt.className = "input2";
			ComSetDisplay("btn_asa_prd_to_dt",false); 
			ComOpenWait(false);  
			
			//Login User's Office Type Code
			param="f_cmd=" + SEARCH18;
			var sXml=sheet1.GetSearchData("SARCommonGS.do", param);
			var loginUserOfcTpCd=ComGetEtcData(sXml,"login_user_ofc_tp_cd");			
			frm.login_user_ofc_tp_cd.value = loginUserOfcTpCd;
			
		}
	//[new ASA]	 	
	} else if (sAction == COMMAND01) {
		if (!validateForm()) {	
			return;
		}
		frm.f_cmd.value=sAction;
		var ofcInfo=combo1.GetSelectCode().split("^");
		frm.agn_cd.value=ofcInfo[0];
		frm.ofc_cd.value=ofcInfo[0];
		var param=FormQueryString(frm);			
		var sXml=sheet1.GetSearchData("STM_SAR_5002GS.do", param);
		var ERROR=ComGetEtcData(sXml, "ERROR"); 
		if (!ComIsNull(ERROR)) {
			//SAR00033 "Closed already opened ASA!"
			ComShowCodeMessage(ERROR);			
			return;
		}
		var currCd=frm.curr_cd.value;		
		//frm.reset();
		sheet1.RemoveAll();
		frm.curr_cd.value=currCd;
		// form mapping		
		var list=SarXml2ListMap(sXml);
		var asaInfo=list[0];
		// set ASA CNTR1
		var selOfcInfo=combo1.GetSelectCode().split("^");
		if(ComIsNull(selOfcInfo[13])) {
			var ofcCd = selOfcInfo[0];
			frm.asa_no_ctnt1.value = ofcCd.substring(0, 3);
		} else {
			frm.asa_no_ctnt1.value = selOfcInfo[13];
		}				 
		setFormFormat(asaInfo);
		ComBtnDisable("btn_new");								
		ComBtnDisable("btn_finish");
		ComBtnDisable("btn_reopen");			
		ComBtnDisable("btn_approve");
		ComBtnEnable("btn_creation");	
		frm.curr_cd.disabled=true;
		frm.curr_cd.className="";
		combo1.SetEnable(0);
	     
		ComEnableObject(frm.asa_prd_fm_dt,true);
		frm.asa_prd_fm_dt.className = "input1";
		ComSetDisplay("btn_asa_prd_fm_dt",true); 
		
		ComEnableObject(frm.asa_prd_to_dt,true);
		frm.asa_prd_to_dt.className = "input1";
		ComSetDisplay("btn_asa_prd_to_dt",true); 
		
		// 20140901 - change able Item to enable Item
		ComEnableObject(frm.asa_no_ctnt2,false);
		ComEnableObject(frm.asa_no_ctnt3,false);
		ComEnableObject(frm.curr_cd,false);
		
		frm.asa_no_ctnt2.value = "";
		frm.asa_no_ctnt3.value = "";
	//[create ASA]	 	
	} else if (sAction == COMMAND02) {
		var asa_prd_fm_dt=frm.asa_prd_fm_dt.value;
		var asa_prd_to_dt=frm.asa_prd_to_dt.value;
		if (ComIsNull(asa_prd_fm_dt)) {			
			ComShowCodeMessage("SAR00013", "Period From");	
			frm.asa_prd_fm_dt.focus();
			return;	
		}
		if (ComIsNull(asa_prd_to_dt)) {			
			ComShowCodeMessage("SAR00013", "Period TO");	
			frm.asa_prd_to_dt.focus();
			return;	
		}
		asa_prd_fm_dt=asa_prd_fm_dt.replace(/\-/g, "");
		asa_prd_to_dt=asa_prd_to_dt.replace(/\-/g, "");
		
		if (asa_prd_fm_dt > asa_prd_to_dt) {
			//msgs['COM12133'] = '{?msg1} must be {?msg3} than {?msg2}.';
			ComShowCodeMessage('COM12133','To date','From date','greater');	
			frm.asa_prd_to_dt.focus();
			return;
		}
		if (asa_prd_fm_dt.substring(0,6) != asa_prd_to_dt.substring(0,6)) {
			//msgs['SAR00037'] = '{?msg1} should be in same month.';
			ComShowCodeMessage("SAR00037", "Period From_TO");	
			frm.asa_prd_to_dt.focus();
			return;
		}
		
		//peorid check 
		frm.f_cmd.value=COMMAND06;
		var param=FormQueryString(frm);	
		
		var sXml2=sheet1.GetSearchData("STM_SAR_5002GS.do", param);
		var validResult=ComGetEtcData(sXml2, "valid_result"); 
		
		//console.log(validResult);
		if(validResult == 'N'){ 
			ComShowCodeMessage("SAR00047",asa_prd_to_dt);
			frm.asa_prd_to_dt.focus();
			return;  
		} 
		
		// form mapping		
		var list = SarXml2ListMap(sXml2);
		var asaInfo = list[0];
		var preAsaPrdToDt = asaInfo["max_asa_prd_to_dt"];
		var maxAsaNo = asaInfo["max_asa_no"];
		
		if (asa_prd_fm_dt < preAsaPrdToDt) {
			//msgs['SAR00054'] = 'Check period from(Previous ASA : {?msg1} , Period To : {?msg2})';
			ComShowCodeMessage('SAR00054',maxAsaNo,preAsaPrdToDt); 	
			frm.asa_prd_fm_dt.focus();
			return;
		}	
 		
		// 저장하시겠습니까?
		//msgs['SAR00038'] = 'Do you want to {?msg1}?';		
		if(!ComShowCodeConfirm("SAR00038", "create ASA")) {
			return;
		}
		sheet1.WaitImageVisible=false;
		ComOpenWait(true);
		frm.f_cmd.value=sAction;				
		var ofcInfo=combo1.GetSelectCode().split("^");
		frm.agn_cd.value=ofcInfo[0];
		frm.ofc_cd.value=ofcInfo[0];
		var param=FormQueryString(frm);			
		var sXml=sheet1.GetSaveData("STM_SAR_5002GS.do", param); 
		var ERROR=ComGetEtcData(sXml, "ERROR");
		ComOpenWait(false); 
		if (!ComIsNull(ERROR)) {
			// SAR00033 "Closed already opened ASA!"
			if (ERROR == "COM12133") {
				ComShowCodeMessage('COM12133', 'To date', 'From date','greater');
			} else {
				ComShowCodeMessage(ERROR);
			}
			return;
		}  		
		var list=SarXml2ListMap(sXml);
		if (list.length > 0) {
			// form 설정			
			SarMapToForm(frm, list[0]);
			var asaInfo=list[0];
			setFormFormat(asaInfo);
		}
		// find
		doActionIBSheet(SEARCHLIST);
		combo1.SetEnable(0);
		
		ComSetDisplay("btn_asa_prd_fm_dt", false);	
		frm.asa_prd_fm_dt.className = "input2"; 
		
		ComSetDisplay("btn_asa_prd_to_dt", false);	
		frm.asa_prd_to_dt.className = "input2"; 
	//[finish ASA]	 	
	} else if (sAction == COMMAND03) {
		frm.f_cmd.value=sAction;				
		var ofcInfo=combo1.GetSelectCode().split("^");
		frm.agn_cd.value=ofcInfo[0];
		frm.ofc_cd.value=ofcInfo[0];
		if (!ComIsNull(frm.asa_no_ctnt2.value) || !ComIsNull(frm.asa_no_ctnt3.value)) {
			frm.asa_no.value=frm.asa_no_ctnt1.value + frm.asa_no_ctnt2.value  + frm.asa_no_ctnt3.value;
		}			 			
		var asaNo=sheet1.GetCellValue(1, "asa_no");
		if (asaNo != frm.asa_no.value) {
			//msgs['SAR00031'] = 'Please, {?msg1} !';
			ComShowCodeMessage("SAR00031", "check 'ASA No.' has been changed");	
			return;
		}
		
		if (!ComIsNull(frm.pre_asa_no.value)){
			frm.f_cmd.value=COMMAND07;
			var param=FormQueryString(frm);	
			var previous_asa_status=ComSearchEtcData(sheet1, "STM_SAR_5002GS.do",param, 'previous_asa_status');
			//console.log(previous_asa_status);
			if(previous_asa_status != 'A'){ 
				ComShowCodeMessage("SAR00050",frm.pre_asa_no.value);
				return;  
			} 
		} 
		
		//peorid check 
		frm.f_cmd.value=COMMAND06;
		var param=FormQueryString(frm);	
		var sXml2 = sheet1.GetSearchData("STM_SAR_5002GS.do", param);
		var validResult=ComGetEtcData(sXml2, "valid_result");
		if(validResult == 'N'){ 
			var loginUsrOfcTpCd = frm.login_user_ofc_tp_cd.value;
			if(loginUsrOfcTpCd == "HQ" || strUsr_ofc_cd == "SINHO") {
				//msgs['SAR00078'] = "Period of ({?msg1}) was closed. So System entered 1st day of next opend month.\nIf required, please change 'To Period' date.";
				ComShowCodeMessage("SAR00078",frm.asa_prd_to_dt.value);
				frm.asa_prd_to_dt.value = ComGetMaskedValue(ComGetEtcData(sXml2, "new_eff_dt"), "ymd");
				ComEnableObject(frm.asa_prd_to_dt,true);
				//frm.asa_prd_to_dt.focus();				
			}			  
		} 
		
		// 저장하시겠습니까?
		//msgs['SAR00038'] = 'Do you want to {?msg1}?';		
		if(!ComShowCodeConfirm("SAR00038", "finish ASA")) return;
		frm.f_cmd.value=COMMAND03;
		var param=FormQueryString(frm);	
		sheet1.WaitImageVisible=false;
		ComOpenWait(true);
		var sXml=sheet1.GetSaveData("STM_SAR_5002GS.do", param);
		ComOpenWait(false); 
		var ERROR=ComGetEtcData(sXml, "ERROR");
		var ERROR_MSG=ComGetEtcData(sXml, "ERROR_MSG");
		if (!ComIsNull(ERROR)) {
			//msgs['SAR00036'] = 'Please Check Overdue Unreported OTS';"
			if(!ComIsNull(ERROR_MSG)) ComShowCodeMessage(ERROR, ERROR_MSG);
			else ComShowCodeMessage(ERROR);			
			return;
		}		
		var exception=ComGetEtcData(sXml, "Exception");
		if (!ComIsNull(exception)) {
			ComShowCodeMessage(exception);			
			return;
		}		
		// find
		doActionIBSheet(SEARCHLIST);
	//[reopen ASA]	 	
	} else if (sAction == COMMAND04) {		
		frm.f_cmd.value=sAction;				
		var ofcInfo=combo1.GetSelectCode().split("^");
		frm.agn_cd.value=ofcInfo[0];
		frm.ofc_cd.value=ofcInfo[0];
		if (!ComIsNull(frm.asa_no_ctnt2.value) || !ComIsNull(frm.asa_no_ctnt3.value)) {
			frm.asa_no.value=frm.asa_no_ctnt1.value + frm.asa_no_ctnt2.value  + frm.asa_no_ctnt3.value;
		}			 			
		var asaNo=sheet1.GetCellValue(1, "asa_no");
		if (asaNo != frm.asa_no.value) {
			//msgs['SAR00031'] = 'Please, {?msg1} !';
			ComShowCodeMessage("SAR00031", "check 'ASA No.' has been changed");	
		}
		//msgs['SAR00038'] = 'Do you want to {?msg1}?';		
		if(!ComShowCodeConfirm("SAR00038", "reopen ASA")) return;
		var param=FormQueryString(frm);	
		sheet1.WaitImageVisible=false;
		ComOpenWait(true); 
		var sXml=sheet1.GetSaveData("STM_SAR_5002GS.do", param);
		ComOpenWait(false); 
		var exception=ComGetEtcData(sXml, "Exception");
		if (!ComIsNull(exception)) {
			ComShowCodeMessage(exception);			
			return;
		}
		// find
		doActionIBSheet(SEARCHLIST);		
    //[approve ASA]	 	
	} else if (sAction == COMMAND05) {		
						
		var ofcInfo=combo1.GetSelectCode().split("^");
		frm.agn_cd.value=ofcInfo[0];
		frm.ofc_cd.value=ofcInfo[0];
		if (!ComIsNull(frm.asa_no_ctnt2.value) || !ComIsNull(frm.asa_no_ctnt3.value)) {
			frm.asa_no.value=frm.asa_no_ctnt1.value + frm.asa_no_ctnt2.value  + frm.asa_no_ctnt3.value;
		}			 			
		var asaNo=sheet1.GetCellValue(1, "asa_no");
		if (asaNo != frm.asa_no.value) {
			//msgs['SAR00031'] = 'Please, {?msg1} !';
			ComShowCodeMessage("SAR00031", "check 'ASA No.' has been changed");	
		}
		
		//peorid check 
		frm.f_cmd.value=COMMAND06;
		var param=FormQueryString(frm);	
		var sXml2 = sheet1.GetSearchData("STM_SAR_5002GS.do", param);
		var validResult=ComGetEtcData(sXml2, "valid_result");
		if(validResult == 'N'){ 
			var loginUsrOfcTpCd = frm.login_user_ofc_tp_cd.value;
			if(loginUsrOfcTpCd == "HQ" || strUsr_ofc_cd == "SINHO") {
				//msgs['SAR00078'] = "Period of ({?msg1}) was closed. So System entered 1st day of next opend month.\nIf required, please change 'To Period' date.";
				ComShowCodeMessage("SAR00078",frm.asa_prd_to_dt.value);
				frm.asa_prd_to_dt.value = ComGetMaskedValue(ComGetEtcData(sXml2, "new_eff_dt"), "ymd");
				ComEnableObject(frm.asa_prd_to_dt,true);
				//frm.asa_prd_to_dt.focus();				
			} else {
				//msgs['SAR00047'] = 'Check ASA Period - Not Opened AR Period ({?msg1})';	
				ComShowCodeMessage("SAR00047",frm.asa_prd_to_dt.value);
				frm.asa_prd_to_dt.focus();
				return;  
			}			
		} 
		
		//msgs['SAR00038'] = 'Do you want to {?msg1}?';		
		if(!ComShowCodeConfirm("SAR00038", "approve ASA")) return;
		
		frm.f_cmd.value=sAction;
		var param=FormQueryString(frm);	
		
		var sXml=sheet1.GetSaveData("STM_SAR_5002GS.do", param);  
		if(SarShowXmlMessage(sXml) != "") {
			ComShowCodeConfirm("COM132101");
			return;
		}else{
			var STATUS =ComGetEtcData(sXml, "ERROR_STATUS");
			if (!ComIsNull(STATUS)) { 
				if(STATUS == "S"){
					doActionIBSheet(SEARCHLIST);
					return; 
				} else {
					//There is already approval execution in progress. You cannot execute double.
					ComShowCodeMessage("SAR00065");		
					return;
				}
			}
			// batch 가 running 상태일 경우, message 호출
			var batStsCd = ComGetEtcData(sXml, "batStsCd");
			if (!ComIsNull(batStsCd)) {
				if(batStsCd == "R"){
					//There is other {?msg1} execution in progress. Please try again after a few minutes.
					ComShowCodeMessage("SAR00079", "approval");		
					return;					
				}
			}
			
		}
		
		var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey");
		if (backendJobKey.length > 0) {
			frm.backendjob_key.value=backendJobKey; 
			sheet1.SetWaitImageVisible(0);
			ComOpenWait(true);		 	
			sheet1.SetWaitTimeOut(10000);
			timer=setInterval(getBackEndJobStatus, 3000); //3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
		}						
	}
}

/**
 * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
 */
function getBackEndJobStatus() {
	var formObj=document.form;
	var sheetObject=sheetObjects[0]; 
	formObj.f_cmd.value=SEARCH04;
	var param=FormQueryString(formObj);
	var sXml=sheetObject.GetSearchData("STM_SAR_5002GS.do", param);
 	var jobState=ComGetEtcData(sXml, "jb_sts_flg");
 	if(jobState == "3") {
    	clearInterval(timer);
    	ComOpenWait(false);
    	ComShowCodeMessage('SAR00004');
    	//조회
    	doActionIBSheet(SEARCHLIST);		
    } else if(jobState == "4") {
    	// BackEndJob을 실패 하였습니다.
    	clearInterval(timer);
    	ComOpenWait(false);
    	ComShowCodeMessage('SAR00032');
    }
}
