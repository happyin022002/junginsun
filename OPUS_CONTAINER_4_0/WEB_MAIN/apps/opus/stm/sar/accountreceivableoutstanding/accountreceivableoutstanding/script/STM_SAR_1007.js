/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAR_1007.js
*@FileTitle  : Outstanding Item Correction
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
/**
 * [STM_SAR-1007] Outstanding Item Correction
 * @extends
 * @class Outstanding Item Correction 
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
var combo1=null;
var combo2=null;
var combo3=null;
var comboCnt=0;
// html form
var frm=null;
var combo1defindex = 0;
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
// 2> initializing
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
	// sheet initializeR
	for (var i=0; i < sheetCnt; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	// IBMultiCombo초기화
    combo1=comboObjects[0];
    combo2=comboObjects[1];
    combo3=comboObjects[2];
	comboCnt=comboObjects.length;
	for (var k=0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k]);
	}
    //Form event register
    initControl();
    // combo 및 초기 데이타 취득
    doActionIBSheet(INIT);
//    SetSelectIndex(0);
//    combo1.SetSelectIndex(0);
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch (sheetObj.id) {
		case "sheet1": 
		    with(sheetObj){
			      var HeadTitle1="|CUR|B/L No|Invoice No|Charge|Customer|Invoice|Receipt|Adjust|Balances" +
			      "|LCL.Rate|LCL Balances|USD.Rate|USD Balances|inv_upd_dt|rct_upd_dt|adj_upd_dt|bal_upd_dt";
			      var headCount=ComCountHeadTitle(HeadTitle1);
			      (headCount, 5, 0, true);
		
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
			      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
		
			      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bl_curr_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
			             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
			             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"inv_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"chg_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cust_num",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
			             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"inv_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"rct_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"adj_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"bal_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"locl_xch_rt",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:6,   UpdateEdit:0,   InsertEdit:0,   EditLen:13 },
			             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"bal_locl_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"usd_xch_rt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:6,   UpdateEdit:0,   InsertEdit:0,   EditLen:13 },
			             {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"bal_usd_amt",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"inv_upd_dt",    KeyField:0,   CalcLogic:"",   Format:"" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"rct_upd_dt",    KeyField:0,   CalcLogic:"",   Format:"" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"adj_upd_dt",    KeyField:0,   CalcLogic:"",   Format:"" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"bal_upd_dt",    KeyField:0,   CalcLogic:"",   Format:"" } ];
			       
			      InitColumns(cols);
			      SetEditable(0);
			      SetColProperty("inv_upd_dt", {Format:"Ymd"} );
			      SetColProperty("rct_upd_dt", {Format:"Ymd"} );
			      SetColProperty("adj_upd_dt", {Format:"Ymd"} );
			      SetColProperty("bal_upd_dt", {Format:"Ymd"} );
//			      SetSheetHeight(160);
			      resizeSheet();
			      }
			break;
	}
}

function resizeSheet(){
	ComResizeSheet(sheetObjects[0], 130);
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
	comboObj.Style=1;
	comboObj.SetUseAutoComplete(1);
//    combo3.SetSelectIndex(0);
}
// ===================================================================================
// Private function
// ===================================================================================
 /**
  * handling process for input validation
  */
 function validateForm() {
	 if (ComIsNull(frm.cond_bl_no.value) && ComIsNull(frm.cond_inv_no.value) && ComIsNull(frm.cond_bkg_no.value)) {
		 //msgs['COM130403'] = 'Mandatory field is missing. Please enter {?msg1}.';
		 ComShowCodeMessage('COM130403', 'B/L No or INV No or BKG No');
		 frm.cond_bl_no.focus();
		 return false;
	 }
     return true;
 }
 /**
  * reset form ==> new 
  */
 function clearForm() {
	 var curOfcCd = combo1.GetSelectText();
		frm.reset();
		combo1.SetSelectText(curOfcCd, 0);
		combo2.SetSelectText("");
		combo3.SetSelectText("");
		sheet1.RemoveAll();
		$("#udt_inv").text("");
		$("#udt_rct").text("");
		$("#udt_adj").text("");
		$("#udt_bal").text("");
		$("#lcl_inv").text("");
		$("#lcl_rct").text("");
		$("#lcl_adj").text("");
		$("#lcl_bal").text("");
		$("#usd_inv").text("");
		$("#usd_rct").text("");
		$("#usd_adj").text("");
		$("#usd_bal").text("");		
 }
 /**
  *  <br>
  * ComComboObject에 item 추가  <br>
  * jsp에서 ComComboObject() 함수 사용시 <br>
  * <br><b>Example : </b>
  * <pre>
  *     var currComboItems = SarGetComboItems(sheetObj, "SAR_TAX_CHARGE");
 			SarAddComboItem(comboObjects[0], currComboItems, "1", "ALL", "ALL") 				
  * </pre>
  * @param comboObj
  * @param comboItems (SarGetComboItems 에서 얻은 리턴값)
  * @param type ( 1: code, 2 : code, name )
  * @param appendStr (ALL, SELECT 등 문자열 추가시 codedesc)
  * @param appendCode (ALL, SELECT 등 문자열 추가시 추가된 code)
  * @see SarGetComboItems
  */ 	
 function SarAddSelectComboItem(comboObj, comboItems, type, appendStr, appendCode) {
 	if (appendStr != "" ) { 
 		comboObj.InsertItem(0, appendStr, appendCode);
 	}
 	for (var i=0 ; i < comboItems.length ; i++) {
         var comboItem=comboItems[i].split(FIELDMARK);     
         if ( type == "1" ) {
         	comboObj.InsertItem(i+1, comboItem[0] , comboItem[0]);    
         } else  if ( type == "2" ) {            	
         	comboObj.InsertItem(i+1, comboItem[0] + "|" + comboItem[1] , comboItem[0]);    
         } else  if ( type == "3" ) {            	
         	comboObj.InsertItem(i+1, comboItem[2] + "|" + comboItem[1] + "|" + comboItem[0] , comboItem[0]);    
         } else  if ( type == "4" ) {            	
         	comboObj.InsertItem(i+1, comboItem[0] + "|" + comboItem[1] + "|" + comboItem[2] + "|" + comboItem[3] , comboItem[0]);    
         }
     }     
 }
 function SarGetSelectComboItems(sheetObj, sCondition, param) {
 	if (param == undefined ) param="";
  	var sXml=sheetObj.GetSearchData("STMCommonGS.do", "f_cmd=" + COMMAND01 + "&lu_tp_cd=" + sCondition + param);
 	//alert("sXml"+sXml);
 	var comboItems=ComGetEtcData(sXml, "lu_cd_list").split(ROWMARK);	
 	//alert("comboItems"+comboItems);
 	return comboItems
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
	case "btn_history":
		if (sheet1.RowCount()== 0) {
			//msgs['COM12189'] = 'Nothing selected';
			ComShowCodeMessage("COM12189");
			return;
		}
		var param="rhq_cd=" + frm.rhq_cd.value+ "&ots_ofc_cd=" + frm.ots_ofc_cd.value + 
		            "&inv_no=" + frm.inv_no.value+"&bl_no=" + frm.bl_no.value;
		var popupWin=ComOpenWindowCenter("/opuscntr/STM_SAR_1003.do?" + param, "history_popup", 800, 550, false, "no");
		popupWin.focus();
		break;		
	case "btn_searchlist":
		doActionIBSheet(SEARCHLIST);
		break;			
	case "btn_print":				
		break;		
	case "btn_new":
		clearForm();		
		break;
	case "btn_view_accounting":
		if (sheet1.RowCount()== 0) {
			//msgs['COM12189'] = 'Nothing selected';
			ComShowCodeMessage("COM12189");
			return;
		}
		var param="rhq_cd=" + frm.rhq_cd.value+ "&ots_ofc_cd=" + frm.ots_ofc_cd.value + 
		            "&inv_no=" + frm.inv_no.value+"&bl_no=" + frm.bl_no.value;
		var popupWin=ComOpenWindowCenter("/opuscntr/STM_SAR_1008.do?" + param, "view_accounting_popup", 800, 550, false, "no");
		popupWin.focus();
		break;
	case "btn_save":
		doActionIBSheet(MULTI);	
		break;
	}
}
/**
 * Form Event register
 */
function initControl() {
    // focus in
   // axon_event.addListenerFormat('beforeactivate', 'obj_activate', frm);
   // axon_event.addListenerFormat('change', 'obj_change', frm);
    //axon_event.addListenerFormat ('keydown', 'obj_keydown', frm);
    //axon_event.addListenerForm('keypress', 'obj_keypress', frm);
    //axon_event.addListenerFormat('blur', 'obj_blur', frm);
//    combo1.SetSelectIndex(0);
}

//===================================================================================
//Sheet Event
//===================================================================================
function sheet1_OnClick(sheetObj, row, col, value) {	
	$("#udt_inv").text(sheet1.GetCellText(row, "inv_upd_dt"));
	$("#udt_rct").text(sheet1.GetCellText(row, "rct_upd_dt"));
	$("#udt_adj").text(sheet1.GetCellText(row, "adj_upd_dt"));
	$("#udt_bal").text(sheet1.GetCellText(row, "bal_upd_dt"));
}
//===================================================================================
//IBCombo Event
//===================================================================================
/**
 * onchange Event OTS Group
 **/
function combo2_OnChange(comboObj, oldindex, oldtext, oldcode, newindex, newtext, newcode) {
    combo3.RemoveAll();  
    frm.ots_tp_cd_nm.value = "";	  	   
    frm.ots_grp_tp_cd_nm.value = "";
	var code = comboObj.GetSelectCode();
	if (code != null && code != "") {
		frm.ots_grp_tp_cd_nm.value = comboObj.GetText(code, 1);		
		comboloadOtsType();
		combo3.Enable = true;
	} else {
		combo3.Enable = false;
	}
}

function combo3_OnChange(comboObj, oldindex, oldtext, oldcode, newindex, newtext, newcode) {
	var code = comboObj.GetSelectCode();
	frm.ots_tp_cd_nm.value = comboObj.GetText(code, 1);
}


function comboloadOtsType() {	   
	   var code = combo2.GetSelectCode();
	   if (code != null && code != "") {				   
		   var otsTypeComboItems = SarGetSelectComboItems(sheet1, "OTS TYPE",  "&attr_ctnt2=" + code);
		   SarAddSelectComboItem(combo3, otsTypeComboItems, "2");
	   }
}


function  combo1_OnChange(comboObj, oldindex, oldtext, oldcode, newindex, newtext, newcode) {
	// ---------------------------------------------------------------
	//|OtsOfcCd^RhqCd^OtsSmryCd^OtsCd^RepOtsOfcCd^OfcBrncAgnTpCd
	//|0       ^1    ^2        ^3    ^4          ^5
	// ----------------------------------------------------------------
	var ofcInfos = combo1.GetSelectCode().split("^");
	var ots_smry_cd = ofcInfos[2];
	
	if(ots_smry_cd == "INV") {
		frm.cond_inv_no.className = "";
		frm.cond_inv_no.readOnly = false;		
	} else {
		frm.cond_inv_no.className = "input2";
		frm.cond_inv_no.readOnly = true;
	}
	
	clearForm();
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
			// ---------------------------------------------------------------
			//|OtsOfcCd^RhqCd^OtsSmryCd^OtsCd^RepOtsOfcCd^OfcBrncAgnTpCd
			//|0       ^1    ^2        ^3    ^4          ^5
			// ----------------------------------------------------------------
			var ofcInfos=combo1.GetSelectCode().split("^");
			var ots_smry_cd=ofcInfos[2];
			var rhq_cd=ofcInfos[1];
			var ots_cd=ofcInfos[3];
			var rep_ots_ofc_cd=ofcInfos[4];
			var ots_ofc_cd=ofcInfos[0];
			if (ComIsNull(combo1.GetSelectText())) {
				ComShowCodeMessage("SAR00013", "Office");				
				return;			
			}
			frm.f_cmd.value=SEARCHLIST;			
			frm.bl_no.value=frm.cond_bl_no.value;
			frm.inv_no.value=frm.cond_inv_no.value;
			var param="ots_cd="+ ots_cd + "&rep_ots_ofc_cd="+ rep_ots_ofc_cd +"&ots_ofc_cd="+ ots_ofc_cd;
			param += "&" + FormQueryString(frm);
			
			var sXml = "";
			var arrXml = "";
			sheet1.WaitImageVisible=false;
			ComOpenWait(true); 
			setTimeout(function(){
				sXml=sheet1.GetSearchData("STM_SAR_1001GS.do", param);
				SarOpenWait(false,true); 
			},100);		
			
			setTimeout(function(){	
				var errCode;
				if (sXml.indexOf("|$$|") < 0 && !ComIsNull(sXml)) {
					errCode=ComGetEtcData(sXml,"errCode"); 
				}
				
				if (!ComIsNull(errCode)) {
					ComShowCodeMessage(errCode);
					var cond_bl_no=frm.cond_bl_no.value;
					var cond_inv_no=frm.cond_inv_no.value;				
					var cond_bkg_no=frm.cond_bkg_no.value;
					var curOfcCd = combo1.GetSelectText();
					frm.reset();
					combo1.SetSelectText(curOfcCd, 0);
					frm.cond_bl_no.value=cond_bl_no;
					frm.cond_inv_no.value=cond_inv_no;
					frm.cond_bkg_no.value=cond_bkg_no;
					combo2.SetSelectCode("");
					combo3.SetSelectCode("");
					sheet1.RemoveAll();
					$("#udt_inv").text("");
					$("#udt_rct").text("");
					$("#udt_adj").text("");
					$("#udt_bal").text("");
					$("#lcl_inv").text("");
					$("#lcl_rct").text("");
					$("#lcl_adj").text("");
					$("#lcl_bal").text("");
					$("#usd_inv").text("");
					$("#usd_rct").text("");
					$("#usd_adj").text("");
					$("#usd_bal").text("");			
					return;
				}
				var arrXml=sXml.split("|$$|");		
				// form mapping
				if (arrXml.length > 0) {
					var list=SarXml2ListMap(arrXml[0]);
					// form set
					SarMapToForm(frm, list[0]);
					// B/L set
					frm.cond_bl_no.value=frm.bl_no.value;
					frm.cond_inv_no.value=frm.inv_no.value;
					frm.cond_bkg_no.value = frm.bkg_no.value;
					// set combo1 , combo2 
					combo2.SetSelectText(list[0]["ots_grp_tp_cd"]);
					combo3.SetSelectText(list[0]["ots_tp_cd"]);
					
					frm.inv_curr_cd.value = list[0]["inv_curr_cd"];
				}
				// sheet1 load 
				if (arrXml.length > 1) {
					sheet1.LoadSearchData(arrXml[1],{Sync:1} );
				}
				// summary load 
				if (arrXml.length > 2) {
					var list=SarXml2ListMap(arrXml[2]);				
					var map=list[0];
					sheet1_OnClick(sheet1, 1); //update				
					$("#lcl_inv").text(ComGetMaskedValue(map["inv_locl_amt"], "float"));    
					$("#lcl_rct").text(ComGetMaskedValue(map["rct_locl_amt"], "float"));
					$("#lcl_adj").text(ComGetMaskedValue(map["adj_locl_amt"], "float"));
					$("#lcl_bal").text(ComGetMaskedValue(map["bal_locl_amt"], "float"));
					$("#usd_inv").text(ComGetMaskedValue(map["inv_usd_amt"] , "float"));
					$("#usd_rct").text(ComGetMaskedValue(map["rct_usd_amt"] , "float"));
					$("#usd_adj").text(ComGetMaskedValue(map["adj_usd_amt"] , "float"));
					$("#usd_bal").text(ComGetMaskedValue(map["bal_usd_amt"] , "float"));
				}
			},110);	
		}
	//[open]	 	
	} else if (sAction == INIT) {
		{
			var otsGroupComboItems=SarGetSelectComboItems(sheet1, "OTS GROUP");				
			SarAddSelectComboItem(combo2, otsGroupComboItems, "3");
		}
		// set combo outstanding offfice code
		{
			frm.f_cmd.value=SEARCH16;		
			var param="f_cmd=" + SEARCH16 + "&ofc_lvl_tp=QUERY";
 			var sXml=sheet1.GetSearchData("SARCommonGS.do", param);
			var strOtsOfcCd=ComGetEtcData(sXml,"ots_ofc_cd");			
			if (!ComIsNull(strOtsOfcCd)) {
				var ofcList=strOtsOfcCd.split("|");				
				// ---------------------------------------------------------------
				//|OtsOfcCd^RhqCd^OtsSmryCd^OtsCd^RepOtsOfcCd^OfcBrncAgnTpCd
				//|0       ^1    ^2        ^3    ^4          ^5
				// ----------------------------------------------------------------
				for (var i=1; i < ofcList.length; i++ ) {
					var ofcInfo=ofcList[i].split("^");				
					combo1.InsertItem(i-1, ofcInfo[0], ofcList[i]);			 
				}	
				for (var i=1; i < ofcList.length; i++ ) {
					var ofcInfo=ofcList[i].split("^"); 
					if(ofcInfo[4] == strUsr_ofc_cd){ 
						combo1defindex = (i - 1);  
					}
				}
				combo1.SetSelectText(strUsr_ofc_cd);
			}
			if(combo1.GetSelectText() == ""){ 
				combo1.SetSelectIndex(combo1defindex,false);    	
			}
			
			// call popup
			if (!ComIsNull(frm.cond_bl_no.value) || 
					!ComIsNull(frm.cond_inv_no.value) || 
					!ComIsNull(frm.cond_bkg_no.value)) {
				doActionIBSheet(SEARCHLIST);
			}
//			combo1.SetSelectIndex(0);
		}	
		//[save]	 	
	} else if (sAction == MULTI) {
		if (ComIsNull(frm.bl_no.value) && ComIsNull(frm.inv_no.value)) {
			 //msgs['COM130403'] = 'Mandatory field is missing. Please enter {?msg1}.';
			 ComShowCodeMessage('COM130403', 'B/L No or INV No');
			 frm.cond_bl_no.focus();
			 return false;
		}
		if (ComIsNull(combo2.GetSelectCode())) {
    		//msgs['COM130403'] = 'Mandatory field is missing. Please enter {?msg1}.';
			ComShowCodeMessage('COM130403', 'OTS Group');
			return;			
		}
		if (ComIsNull(combo3.GetSelectCode())) {
			//msgs['COM130403'] = 'Mandatory field is missing. Please enter {?msg1}.';
     		ComShowCodeMessage('COM130403', 'OTS Type');
			return;			
		}
		if (ComIsNull(frm.ots_rmk.value)) {
			//msgs['COM130403'] = 'Mandatory field is missing. Please enter {?msg1}.';
			ComShowCodeMessage('COM130403', 'RMK');
			frm.ots_rmk.focus();
			return;			
		}
		
		var otsRmk = new String(frm.ots_rmk.value);
		var len = otsRmk.length;
		
		for (var i = 0; i < len; i++){
			var chCode = otsRmk.charCodeAt(i);
			
			if(chCode < 32 || chCode > 126){
				ComShowCodeMessage('SAR00077');
				frm.ots_rmk.focus();
				return;
			}			
		}
		
		// 저장하시겠습니까?
		//msgs['COM130101'] = 'Do you want to save {?msg1}?';		
		if(!ComShowCodeConfirm("COM130101", "changes")) return;
		
		sheet1.WaitImageVisible=false;
		ComOpenWait(true); 
		setTimeout( function () {
			frm.f_cmd.value=sAction;		
			frm.ots_grp_tp_cd.value=combo2.GetSelectCode();
			frm.ots_tp_cd.value=combo3.GetSelectCode();
			var param=FormQueryString(frm);
			param += "&ots_grp_tp_cd=" + combo2.GetSelectCode();
			param += "&ots_tp_cd=" + combo3.GetSelectCode();
			var sXml=sheet1.GetSaveData("STM_SAR_1007GS.do", param);
			SarOpenWait(false,true);
					
			if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
				doActionIBSheet(SEARCHLIST);
			} 
	    } , 100);
		
	}
}
