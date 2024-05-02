	/*=========================================================
	*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
	*@FileName   : stm_sar_1001.js
	*@FileTitle  : [STM_SAR-1001] Outstanding Inquiry by B/L(Invoice)
	*@author     : CLT
	*@version    : 1.0
	*@since      : 2014/04/08
	=========================================================*/
	/**
	 * [STM_SAR-1001] Outstanding Inquiry by B/L(Invoice)
	 * @extends
	 * @class Outstanding Inquiry by B/L(Invoice) 
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
	var combo1=null
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
			        var HeadTitle1="|CUR|B/L No|Invoice No|Charge|Customer|Invoice|Receipt|Adjust|Balances" +
			        "|LCL.Rate|LCL Balances|USD.Rate|USD Balances|inv_upd_dt|rct_upd_dt|adj_upd_dt|bal_upd_dt";
			        var headCount=ComCountHeadTitle(HeadTitle1);
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
			               {Type:"Float",     Hidden:0,  Width:70,  Align:"Right",   ColMerge:1,   SaveName:"locl_xch_rt",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:6,   UpdateEdit:0,   InsertEdit:0,   EditLen:13 },
			               {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"bal_locl_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			               {Type:"Float",     Hidden:0,  Width:70,  Align:"Right",   ColMerge:1,   SaveName:"usd_xch_rt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:6,   UpdateEdit:0,   InsertEdit:0,   EditLen:13 },
			               {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"bal_usd_amt",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
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
			        SetCountPosition(0);
			        //SetSheetHeight(190);
			        resizeSheet();
				break;	
			}
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
		//comboObj.SetDropHeight(240);
		comboObj.SetBackColor("#CCFFFD");
		comboObj.Style=1;
		comboObj.SetUseAutoComplete(1);
		comboObj.SetEnable=false
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
			frm.reset();
			sheet1.RemoveAll();
			document.getElementById("udt_inv").innerText="";
			document.getElementById("udt_rct").innerText="";
			document.getElementById("udt_adj").innerText="";
			document.getElementById("udt_bal").innerText="";
			document.getElementById("lcl_inv").innerText="";
			document.getElementById("lcl_rct").innerText="";
			document.getElementById("lcl_adj").innerText="";
			document.getElementById("lcl_bal").innerText="";
			document.getElementById("usd_inv").innerText="";
			document.getElementById("usd_rct").innerText="";
			document.getElementById("usd_adj").innerText="";
			document.getElementById("usd_bal").innerText="";
			combo1.SetSelectText(strUsr_ofc_cd, false);
			if(combo1.GetSelectText() == ""){
				combo1.SetSelectIndex(combo1defindex,false);   	
			}
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
		case "btn_downexcel":
			if(sheet1.RowCount() < 1){//no data
				ComShowCodeMessage("COM132501");
			}else{
				sheet1.Down2Excel({ HiddenColumn:1,TreeLevel:false,SheetName:"Outstanding Inquery By B/L(Invoice)"}); 
			}
	    	break;	
		case "btn_view_accounting":
			if (sheet1.RowCount()== 0) {
				//msgs['COM12189'] = 'Nothing selected';
				ComShowCodeMessage("COM12189");
				return;
			}
			
			// ---------------------------------------------------------------
			//|OtsOfcCd^RhqCd^OtsSmryCd^OtsCd^RepOtsOfcCd^OfcBrncAgnTpCd
			//|0       ^1    ^2        ^3    ^4          ^5
			// ----------------------------------------------------------------
			var ofcInfos=combo1.GetSelectCode().split("^");
			var ots_smry_cd=ofcInfos[2];
			
			var param="rhq_cd=" + frm.rhq_cd.value+ "&ots_ofc_cd=" + frm.ots_ofc_cd.value + 
			            "&inv_no=" + frm.inv_no.value+"&bl_no=" + frm.bl_no.value + "&ots_smry_cd=" + ots_smry_cd;
			var popupWin=ComOpenWindowCenter("/opuscntr/STM_SAR_1008.do?" + param, "view_accounting_popup", 800, 550, false, "no");
			popupWin.focus();
			break;
		}
	}
	/**
	 * Form Event register
	 */
	function initControl() {
	//  axon_event.addListenerFormat('blur', 'obj_activate',    frm);
	//    axon_event.addListenerFormat('change', 'obj_change', frm);
	//  axon_event.addListenerFormat ('keydown', 'obj_keydown', frm);
	//  axon_event.addListenerForm('keypress', 'obj_keypress', frm);
	//    axon_event.addListenerFormat('blur', 'obj_blur', frm);
	}
	
	//===================================================================================
	//Sheet Event
	//===================================================================================
	function sheet1_OnClick(sheetObj, row, col, value) {	
		document.getElementById("udt_inv").innerText=sheet1.GetCellText(row, "inv_upd_dt");
		document.getElementById("udt_rct").innerText=sheet1.GetCellText(row, "rct_upd_dt");
		document.getElementById("udt_adj").innerText=sheet1.GetCellText(row, "adj_upd_dt");
		document.getElementById("udt_bal").innerText=sheet1.GetCellText(row, "bal_upd_dt");
	}
	//===================================================================================
	//IBCombo Event
	//===================================================================================
	function  combo1_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		// ---------------------------------------------------------------
		//|OtsOfcCd^RhqCd^OtsSmryCd^OtsCd^RepOtsOfcCd^OfcBrncAgnTpCd
		//|0       ^1    ^2        ^3    ^4          ^5
		// ----------------------------------------------------------------
		var ofcInfos=combo1.GetSelectCode().split("^");
		var ots_smry_cd=ofcInfos[2];
		combo1.SetSelectText(comboObj.GetText(parseInt(newIndex), 0),false);
		if(ots_smry_cd == "INV") {		
			frm.cond_inv_no.className="";
			frm.cond_inv_no.readOnly=false;
		} else {
			frm.cond_inv_no.className="input2";
			frm.cond_inv_no.readOnly=true;
		}
		strUsr_ofc_cd = comboObj.GetSelectText();
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
				var errCode;
				var sXml;
				
				sheet1.WaitImageVisible=false;
				ComOpenWait(true); 
				setTimeout( function () {
					sXml=sheet1.GetSearchData("STM_SAR_1001GS.do", param);
					var sXmlTest = "";
					
					if (sXml.indexOf("|$$|") >= 0) {
						sXmlTest = sXml.split("|$$|");
						if (sXmlTest)
							if (sXmlTest.length > 1)
								sXmlTest = sXmlTest[1];
					}
					
					if (sXml.indexOf("|$$|") < 0 && !ComIsNull(sXml)) {
						errCode=ComGetEtcData(sXml,"errCode"); 
					}
					SarOpenWait(false,true);
				} , 100);	
					
				setTimeout( function () {	
					if (!ComIsNull(errCode)) { 
						ComShowCodeMessage(errCode);
						var cond_bl_no=frm.cond_bl_no.value;
						var cond_inv_no=frm.cond_inv_no.value;				
						var cond_bkg_no=frm.cond_bkg_no.value;
						var temp = combo1.GetSelectCode();
						frm.reset();
						frm.cond_bl_no.value=cond_bl_no;
						frm.cond_inv_no.value=cond_inv_no;
						frm.cond_bkg_no.value=cond_bkg_no;
						combo1.SetSelectCode(temp);
						sheet1.RemoveAll();
						document.getElementById("udt_inv").innerText="";
						document.getElementById("udt_rct").innerText="";
						document.getElementById("udt_adj").innerText="";
						document.getElementById("udt_bal").innerText="";
						document.getElementById("lcl_inv").innerText="";
						document.getElementById("lcl_rct").innerText="";
						document.getElementById("lcl_adj").innerText="";
						document.getElementById("lcl_bal").innerText="";
						document.getElementById("usd_inv").innerText="";
						document.getElementById("usd_rct").innerText="";
						document.getElementById("usd_adj").innerText="";
						document.getElementById("usd_bal").innerText="";			
						return;
					}
					var arrXml=sXml.split("|$$|");		
					// form mapping
					if (arrXml.length > 0) {
						var list=SarXml2ListMap(arrXml[0]);
						// form 설정
						SarMapToForm(frm, list[0]);
						// B/L set
						frm.cond_bl_no.value=frm.bl_no.value;
						frm.cond_inv_no.value=frm.inv_no.value;
						frm.cond_bkg_no.value = frm.bkg_no.value;
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
						document.getElementById("lcl_inv").innerText=ComGetMaskedValue(map["inv_locl_amt"], "float");    
						document.getElementById("lcl_rct").innerText=ComGetMaskedValue(map["rct_locl_amt"], "float");
						document.getElementById("lcl_adj").innerText=ComGetMaskedValue(map["adj_locl_amt"], "float");
						document.getElementById("lcl_bal").innerText=ComGetMaskedValue(map["bal_locl_amt"], "float");
						document.getElementById("usd_inv").innerText=ComGetMaskedValue(map["inv_usd_amt"] , "float");
						document.getElementById("usd_rct").innerText=ComGetMaskedValue(map["rct_usd_amt"] , "float");
						document.getElementById("usd_adj").innerText=ComGetMaskedValue(map["adj_usd_amt"] , "float");
						document.getElementById("usd_bal").innerText=ComGetMaskedValue(map["bal_usd_amt"] , "float");	
					}
				} , 110);	
			}
		//[open]	 	
		} else if (sAction == INIT) {
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
					combo1.SetSelectText(strUsr_ofc_cd, true);
					for (var i=1; i < ofcList.length; i++ ) {
						var ofcInfo=ofcList[i].split("^"); 
						if(ofcInfo[4] == strUsr_ofc_cd){ 
							combo1defindex = (i - 1);  
						}
					}
					frm.combo1.disabled = true;
				}
				if(combo1.GetSelectText() == ""){
					combo1.SetSelectIndex(combo1defindex,false);   	
				}
				param="f_cmd=" + SEARCH17 + "&ofc_cd=" + strUsr_ofc_cd;   
				sXml=sheet1.GetSearchData("SARCommonGS.do", param); 
				var hiddenYn = ComGetEtcData(sXml,"hidden_yn");
				
				if(hiddenYn == 'Y'){
					$("th#th_inv_curr_cd").html("&nbsp;"); 
					$("input#inv_curr_cd.input2").hide();
				} else {
					$("th#th_inv_curr_cd").html("Invoice Currency"); 
					$("input#inv_curr_cd.input2").show();  
				}
				
				// call popup
				if (!ComIsNull(frm.bl_no.value)) {
					doActionIBSheet(SEARCHLIST);
				}
			}		
		}
	}
