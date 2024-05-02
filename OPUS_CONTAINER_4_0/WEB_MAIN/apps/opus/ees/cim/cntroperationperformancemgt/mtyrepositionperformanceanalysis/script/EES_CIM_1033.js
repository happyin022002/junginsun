	/*=========================================================
	*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
	*@FileName   : EES_CIM_1033.js
	*@FileTitle  : Repo Result by Port
	*@author     : CLT
	*@version    : 1.0
	*@since      : 2014/06/13
	=========================================================*/
	/****************************************************************************************
	  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
	    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
	     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
	 ***************************************************************************************/
	/**
	 * @extends 
	 * @class ees_cim_1033 : business script for ees_cim_1033 
	 */
	/* developer job	*/
	// common global variables
	var tabObjects=new Array();
	var tabCnt=0;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var oldCntrTypeSize="";
	var sCntrTypeSize="";
	var oldCntrTypeSize2="";
	var tabIndex=0;
	var isOpen=false;
	var comboObjects=new Array();
	var comboCnt=0;
	var flag=false;
	var enterSwitch=false;
	//Event handler processing by button click event */
	document.onclick=processButtonClick;
	//Event handler processing by button name */
	function processButtonClick() {
		var shtCnt=0;
		var sheet1=sheetObjects[shtCnt++];
		//  var t2sheet1 = sheetObjects[shtCnt++];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
				if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
			case "btn_Retrieve":
				doActionIBSheet(sheet1, formObject, IBSEARCH);
				//sheetObjects[0].SetSelectRow(0);
				break;
			case "btn_DownExcel":
				if(sheet1.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
				}else{
//					sheet1.Down2Excel({ HiddenColumn:-1});
					sheet1.Down2Excel({ SheetDesign:1, HiddenColumn:1, Merge:1 });
				}
				break;
			case "btn_vvd": // vvd retrieving popup
				var check="";
				for ( var i=0; i < formObject.option.length; i++) {
					if (formObject.option[i].checked) {
						check=formObject.option[i].value;
					}
				}
				if (check == "V") {
					ComOpenPopup('/opuscntr/COM_ENS_0B2.do', 750, 480, "getVvdInfo", '1,0,1,1,1,1,1,1', true);
				}
				break;
			case "btn_new":
				sheet1.RemoveAll();
				formObject.reset();
				initForm();
				break;
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowCodeMessage("CIM30032");
			} else {
				alert(e);
			}
		}
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
	 * registering IBMultiCombo Object as list
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
		
		initControl();
		// initializing IBMultiCombo
		for ( var k=0; k < comboObjects.length; k++) {
			initCombo(comboObjects[k], k + 1);
		}
		
		for (k=0; k < tabObjects.length; k++) {
			initTab(tabObjects[k], k + 1);
		}
	//	doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC01);
		sheet1_OnLoadFinish(sheet1);
		inputEngSet();
	}
	function sheet1_OnLoadFinish(sheetObj) {
		//sheetObj.WaitImageVisible = false;
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
		//sheetObj.WaitImageVisible = true;
	}
	function initControl() {
//		axon_event.addListener('click', 'reverse_cntr_tpsz_cd_check', 'chk_cntr_tpsz_cd', ''); 
		axon_event.addListenerForm('change', 'obj_change', form);
		axon_event.addListenerForm('blur', 'obj_deactivate', form); 
		axon_event.addListenerForm('click', 'obj_tpsz_click', form);
		document.getElementById("vvd01").className="input2";
		document.getElementById("vvd02").className="input2";
		document.getElementById("vvd03").className="input2";
		document.getElementById("vvd04").className="input2";
		ComBtnDisable("btn_vvd"); 
	}
	/**
	 * initializing form when clicking NEW button
	 * @return
	 */
	function initForm() {
		document.form.vvd01.value="";
		document.form.vvd02.value="";
		document.form.vvd03.value="";
		document.form.vvd04.value="";
		document.form.vvd01.disabled=true;
		document.form.vvd02.disabled=true;
		document.form.vvd03.disabled=true;
		document.form.vvd04.disabled=true;
		document.getElementById("vvd01").className="input2";
		document.getElementById("vvd02").className="input2";
		document.getElementById("vvd03").className="input2";
		document.getElementById("vvd04").className="input2";
		document.getElementById("froms").className="input1";
		document.getElementById("tos").className="input1";
		document.getElementById("period").className="input1";
		document.form.period.disabled=false;
		document.form.froms.disabled=false;
		document.form.tos.disabled=false;
		comboObjects[0].SetEnable(1);
		comboObjects[1].SetEnable(1);
		comboObjects[2].SetEnable(1);
		comboObjects[3].SetEnable(0);
		comboObjects[4].SetEnable(0);
		comboObjects[3].SetSelectCode("");
		comboObjects[4].SetSelectCode("");
		document.form.rdtype.disabled=true;
		document.form.rdtype.value="I";
		document.form.through.disabled=true;
		document.form.through.value="I";
		var ft=document.getElementById("ft");
		var ld=document.getElementById("ld");
		var fmrcc=document.getElementById("fmrcc");
		var torcc=document.getElementById("torcc");
		var pol=document.getElementById("pol");
		var pod=document.getElementById("pod");
		ft.innerText="TO/From";
		ld.innerText="POD/POL";
		torcc.innerText="TO RCC";
		fmrcc.innerText="FM RCC";
		pod.innerText="POD";
		pol.innerText="POL";
		sheetObjects[0].SetCellValue(0, 0,"POD",0);
		sheetObjects[0].SetCellValue(0, 1,"POL",0);
		comboObjects[0].SetSelectCode("");
		comboObjects[1].SetSelectCode("");
		comboObjects[2].SetSelectCode("");
		comboObjects[3].SetSelectCode("");
		comboObjects[4].SetSelectCode("");
		ComBtnDisable("btn_vvd"); // button disabled
	//	document.getElementById("froms").focus();
	}
	/**
	 * Vessel SKD & Code Inquiry part
	 * @param {arry} aryPopupData
	 */
	function getVvdInfo(aryPopupData) {
		var formObject=document.form;
		var vvd=aryPopupData[0][7];
		if (formObject.vvd01.value == '') {
			formObject.vvd01.value=vvd;
		} else if (formObject.vvd02.value == '') {
			formObject.vvd02.value=vvd;
		} else if (formObject.vvd03.value == '') {
			formObject.vvd03.value=vvd;
		} else if (formObject.vvd04.value == '') {
			formObject.vvd04.value=vvd;
		}
	}
	
	function obj_tpsz_click() {
		obj=ComGetEvent();
		if (obj.name == "tpsz") { // by TP/SZ 
			if (obj.value != "R") {
				document.form.rdtype.disabled=true;
				document.form.rdtype.value="I";
			} else {
				document.form.rdtype.disabled=false;
			}
		} else if (obj.name == "tscntr") {
			if (obj.value != "T") {
				document.form.through.disabled=true;
				document.form.through.value="I";
			} else {
				document.form.through.disabled=false;
			}
		} else if (obj.name == "inquirywise") {
			if (obj.value != "R") {
				comboObjects[1].SetEnable(0);
				comboObjects[2].SetEnable(0);
				comboObjects[3].SetEnable(1);
				comboObjects[4].SetEnable(1);
				comboObjects[1].SetSelectCode("");
				comboObjects[2].SetSelectCode("");
			} else {
				comboObjects[1].SetEnable(1);
				comboObjects[2].SetEnable(1);
				comboObjects[3].SetEnable(0);
				comboObjects[4].SetEnable(0);
				comboObjects[3].SetSelectCode("");
				comboObjects[4].SetSelectCode("");
			}
		} else if (obj.name == "option") {
			if (obj.value != "P") {
				document.form.period.disabled=true;
				document.form.froms.value="";
				document.form.tos.value="";
				document.form.froms.disabled=true;
				document.form.tos.disabled=true;
				comboObjects[0].SetEnable(0);
				comboObjects[0].SetSelectCode("");
				document.form.vvd01.disabled=false;
				document.form.vvd02.disabled=false;
				document.form.vvd03.disabled=false;
				document.form.vvd04.disabled=false;
				document.getElementById("vvd01").className="input1";
				document.getElementById("vvd02").className="input";
				document.getElementById("vvd03").className="input";
				document.getElementById("vvd04").className="input";
				document.getElementById("froms").className="input2";
				document.getElementById("tos").className="input2";
				document.getElementById("period").className="input2";
				ComBtnEnable("btn_vvd");
	//			document.getElementById("vvd01").focus();
			} else {
				document.form.vvd01.value="";
				document.form.vvd02.value="";
				document.form.vvd03.value="";
				document.form.vvd04.value="";
				document.form.vvd01.disabled=true;
				document.form.vvd02.disabled=true;
				document.form.vvd03.disabled=true;
				document.form.vvd04.disabled=true;
				document.getElementById("vvd01").className="input2";
				document.getElementById("vvd02").className="input2";
				document.getElementById("vvd03").className="input2";
				document.getElementById("vvd04").className="input2";
				document.getElementById("froms").className="input1";
				document.getElementById("tos").className="input1";
				document.getElementById("period").className="input1";
				document.form.period.disabled=false;
				document.form.froms.disabled=false;
				document.form.tos.disabled=false;
				comboObjects[0].SetEnable(1);
				ComBtnDisable("btn_vvd");
	//			document.getElementById("froms").focus();
			}
		} else if (obj.name == "directionwise") {
			var ft=document.getElementById("ft");
			var ld=document.getElementById("ld");
			var fmrcc=document.getElementById("fmrcc");
			var torcc=document.getElementById("torcc");
			var pol=document.getElementById("pol");
			var pod=document.getElementById("pod");
			if (obj.value != "F") {
				ft.innerText="TO/From";
				ld.innerText="POD/POL";
				torcc.innerText="TO RCC";
				fmrcc.innerText="FM RCC";
				pod.innerText="POD";
				pol.innerText="POL";
				sheetObjects[0].SetCellValue(0, 0,"POD",0);
				sheetObjects[0].SetCellValue(0, 1,"POL",0);
			} else {
				ft.innerText="From/TO";
				ld.innerText="POL/POD";
				torcc.innerText="FM RCC";
				fmrcc.innerText="TO RCC";
				pod.innerText="POL";
				pol.innerText="POD";
				sheetObjects[0].SetCellValue(0, 0,"POL",0);
				sheetObjects[0].SetCellValue(0, 1,"POD",0);
			}
		}
	}
	function chkToDateWeekBlur() {
		var period=document.form.period.value;
		var toDate=document.form.tos.value;
		var frDate=document.form.froms.value;
		var toYearDate=toDate.substring(0, 4);
		var frYearDate=frDate.substring(0, 4);
		var toMonthDate=toDate.substring(5, 7);
		var frMonthDate=frDate.substring(5, 7);
		var frDayDate="";
		var toDayDate="";
		if (frDate.length > 7) {
			frDayDate=frDate.substring(8, 10);
			toDayDate=toDate.substring(8, 10);
		} else {
			frDayDate="01";
			toDayDate=lastDay(toYearDate, toMonthDate);
		}
		var frDateFull=new Date(frYearDate, frMonthDate - 1, frDayDate);
		var toDateFull=new Date(toYearDate, toMonthDate - 1, toDayDate);
		var getDiffTime=toDateFull.getTime() - frDateFull.getTime();
		var retDate=Math.floor(getDiffTime / (1000 * 60 * 60 * 24));
		var retMonth=((parseInt(toYearDate) - parseInt(frYearDate)) * 12 + parseInt(toMonthDate, 10) - parseInt(frMonthDate, 10));
		var retWeek=Math.floor((toDateFull - frDateFull) / (1000 * 60 * 60 * 24 * 7));
		var week="";
		var fromTo=52;
		if (period == "M") {
			if (retMonth >= 12) {
				if (ComGetEvent("name") == "tos") {
					ComShowCodeMessage("CIM21031");
					ComSetFocus(document.getElementById("tos"));
				}
				return false;
			}
		} else if (period == "W") {
			if (frYearDate == toYearDate) {
				week=eval(toMonthDate) - eval(frMonthDate) + 1;
			} else {
				betwMonth=fromTo - eval(frMonthDate) + eval(toMonthDate) + 1;
				if ((eval(toYearDate) - eval(frYearDate)) == 1) { //in case of 1 year gap
					week=betwMonth;
				} else {
					week=(eval(toYearDate) - eval(frYearDate) - 1) * fromTo + betwMonth;
				}
			}
			if (week > 26) {
				if (ComGetEvent("name") == "tos") {
					ComShowCodeMessage("CIM21031");
					ComSetFocus(document.getElementById("tos"));
				}
				return false;
			}
		} else if (period == "D") {
			if (retDate >= 31) {
				if (ComGetEvent("name") == "tos") {
					ComShowCodeMessage("CIM29029");
					ComSetFocus(document.getElementById("tos"));
				}
				return false;
			}
		}
	}
	//function for handling Axon event
	function obj_deactivate() {
		var f=document.getElementById("froms");
		var t=document.getElementById("tos");
		sVal1=f.value.replace(/\/|\-|\./g, "");
		sVal2=t.value.replace(/\/|\-|\./g, "");
		switch (ComGetEvent("name")) {
		case "froms":
			if (ComChkObjValid(ComGetEvent(), false)) {
				if (f.getAttribute("dataformat") == "ym") {
					if (sVal1 != "" && sVal2 != "") {
						var day=lastDay(sVal2.substring(0, 4), sVal2.substring(4, 6));
						var flag=ComChkPeriod(sVal1 + "01", sVal2 + day);
						if (flag < 1) {
							//ComShowCodeMessage("CIM29004");
							enterSwitch=false;
							t.value="";
	//						t.focus();
							t.select();
							return false;
						} else {
							if (chkToDateWeekBlur() == false) {
								enterSwitch=false;
								t.value="";
	//							t.focus();
								t.select();
								return false;
							}
						}
						document.getElementById("from").value=sVal1 + "01";
						document.getElementById("to").value=sVal2 + day;
					}
				} else { // retrieving by week
					if (sVal1 != "" && sVal2 != "") {
						if (ComParseInt(sVal1) > ComParseInt(sVal2)) {
							ComShowCodeMessage("CIM29003");
							enterSwitch=false;
							t.value="";
	//						t.focus();
							t.select();
							return false;
						} else {
							if (chkToDateWeekBlur() == false) {
								enterSwitch=false;
								t.value="";
	//							t.focus();
								t.select();
								return false;
							}
						}
						document.getElementById("from").value=sVal1;
						document.getElementById("to").value=sVal2;
					}
				}
			} else {
				if (f.getAttribute("dataformat") == "ym") {
					if (sVal1.length > 0 && !ComIsMonth(sVal1.substring(4, 6)) && ComGetEvent("name") == 'froms') {
						ComGetEvent().value="";
						ComShowCodeMessage("CIM21004", "YYYYMM");
						enterSwitch=false;
	//					ComGetEvent().focus();
						ComGetEvent().select();
						return false;
					}
				} else { // retrieving by week
					if (sVal1.length > 0 && !ComIsWeek(sVal1.substring(4, 6)) && ComGetEvent("name") == 'froms') {
						ComGetEvent().value="";
						ComShowCodeMessage("CIM21004", "YYYYWW");
	//					ComGetEvent().focus();
						ComGetEvent().select();
						enterSwitch=false;
						return false;
					}
				}
			}
			break;
		case "tos":
			if (ComChkObjValid(ComGetEvent(), false)) {
				if (t.getAttribute("dataformat") == "ym") {
					var day=lastDay(sVal2.substring(0, 4), sVal2.substring(4, 6));
					if (sVal1 != "" && sVal2 != "") {
						var flag=ComChkPeriod(sVal1 + "01", sVal2 + day);
						if (flag < 1) {
							if (ComGetEvent("name") == "tos") {
								ComShowCodeMessage("CIM29004");
							}
							enterSwitch=false;
							ComGetEvent().value="";
	//						t.focus();
							t.select();
							return false;
						} else {
							if (chkToDateWeekBlur() == false) {
								enterSwitch=false;
								ComGetEvent().value="";
	//							t.focus();
								t.select();
								return false;
							}
						}
					}
					document.getElementById("from").value=sVal1 + "01";
					document.getElementById("to").value=sVal2 + day;
				} else { // retrieving by week
					if (sVal1 != "" && sVal2 != "") {
						if (ComParseInt(sVal1) > ComParseInt(sVal2)) {
							if (ComGetEvent("name") == "tos") {
								ComShowCodeMessage("CIM29003");
							}
							enterSwitch=false;
							ComGetEvent().value="";
	//						t.focus();
							t.select();
							return false;
						} else {
							if (chkToDateWeekBlur() == false) {
								enterSwitch=false;
								ComGetEvent().value="";
	//							t.focus();
								t.select();
								return false;
							}
						}
					}
					document.getElementById("from").value=sVal1;
					document.getElementById("to").value=sVal2;
				}
				enterSwitch=true;
			} else {
				if (t.getAttribute("dataformat") == "ym") {
					if (sVal2.length > 0 && !ComIsMonth(sVal2.substring(4, 6))) {
						enterSwitch=false;
						ComGetEvent().value="";
						ComShowCodeMessage("CIM21004", "YYYYMM");
	//					t.focus();
						t.select();
						return false;
					}
				} else { // retrieving by week
					if (sVal2.length > 0 && !ComIsWeek(sVal2.substring(4, 6))) {
						enterSwitch=false;
						ComGetEvent().value="";
						ComShowCodeMessage("CIM21004", "YYYYWW");
	//					t.focus();
						t.select();
						return false;
					}
				}
			}
			break;
		case "vvd01":
			if (ComGetEvent().value != "") {
				document.getElementById("vvd").value=document.getElementById("vvd01").value;
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
			}
			break;
		case "vvd02":
			if (ComGetEvent().value != "") {
				document.getElementById("vvd").value=document.getElementById("vvd02").value;
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
			}
			break;
		case "vvd03":
			if (ComGetEvent().value != "") {
				document.getElementById("vvd").value=document.getElementById("vvd03").value;
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
			}
			break;
		case "vvd04":
			if (ComGetEvent().value != "") {
				document.getElementById("vvd").value=document.getElementById("vvd04").value;
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
			}
			break;
		}
		return true;
	}
	/*
	 function obj_vvdBlur(){
	 switch (ComGetEvent("name")) {
	 case "vvd01":
	 if(ComGetEvent().value != ""){
	 document.getElementById("vvd").value=document.getElementById("vvd01").value;
	 doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
	 }
	 break;
	 case "vvd02":
	 if(ComGetEvent().value != ""){
	 document.getElementById("vvd").value=document.getElementById("vvd02").value;
	 doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
	 }
	 break;
	 case "vvd03":
	 if(ComGetEvent().value != ""){
	 document.getElementById("vvd").value=document.getElementById("vvd03").value;
	 doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
	 }
	 break;
	 case "vvd04":
	 if(ComGetEvent().value != ""){
	 document.getElementById("vvd").value=document.getElementById("vvd04").value;
	 doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
	 }
	 break;
	 }	
	 }
	 */
	/**
	 * validating combo_lane code
	 * @param KeyCode
	 * @param Shift
	 * @return
	 */
	function combo_lane_OnBlur(KeyCode, Shift) {
		flag=false;
		if (comboObjects[0].GetSelectText().length > 0) {
			comboObjects[0].SetSelectText(comboObjects[0].GetSelectText().toUpperCase());
			for ( var i=0; i < comboObjects[0].GetItemCount(); i++) {
				if (comboObjects[0].GetSelectText()== comboObjects[0].GetText(i, 0)) {
					flag=true;
					break;
				}
			}
			if (flag == false) {
				ComShowCodeMessage("CIM29012");
				comboObjects[0].SetSelectText("");
				return false;
			}
			flag=false;
		}
	}
	function portnextfocus() {
	//	comboObjects[4].focus();
	}
	function rccnextfocus() {
	//	comboObjects[2].focus();
	}
	/**
	 * validating RCC1 code 
	 * @param KeyCode
	 * @param Shift
	 * @return
	 */
	function rcc01_OnBlur(KeyCode, Shift) {
		flag=false;
		if (comboObjects[1].GetSelectText().length > 0) {
			comboObjects[1].SetSelectText(comboObjects[1].GetSelectText().toUpperCase());
			for ( var i=0; i < comboObjects[1].GetItemCount(); i++) {
				if (comboObjects[1].GetSelectText()== comboObjects[1].GetText(i, 0)) {
					flag=true;
					break;
				}
			}
			if (flag == false) {
				ComShowCodeMessage("CIM29008");
				comboObjects[1].SetSelectText("");
	//			comboObjects[1].focus();
				return false;
			}
			flag=false;
	//		//comboObjects[2].focus();
		}
	}
	/**
	 * validating RCC2 code 
	 * @param KeyCode
	 * @param Shift
	 * @return
	 */
	function rcc02_OnBlur(KeyCode, Shift) {
		flag=false;
		if (comboObjects[2].GetSelectText().length > 0) {
			comboObjects[2].SetSelectText(comboObjects[2].GetSelectText().toUpperCase());
			for ( var i=0; i < comboObjects[2].GetItemCount(); i++) {
				if (comboObjects[2].GetSelectText()== comboObjects[2].GetText(i, 0)) {
					flag=true;
					break;
				}
			}
			if (flag == false) {
				ComShowCodeMessage("CIM29008");
				comboObjects[2].SetSelectText("");
	//			comboObjects[2].focus();
				return false;
			} else {
	//			document.form.cargotype.focus();
			}
			flag=false;
	//		//document.form.cargotype.focus();
		} else {
	//		document.form.cargotype.focus();
		}
	}
	/**
	 * validating POD code 
	 * @param KeyCode
	 * @param Shift
	 * @return
	 */
	function port01_OnBlur(KeyCode, Shift) {
		flag=false;
		if (comboObjects[3].GetSelectText().length > 0) {
	//no support[check again]CLT 		comboObjects[3].UseCode=false;
			comboObjects[3].SetSelectText(comboObjects[3].GetSelectText().toUpperCase());
			for ( var i=0; i < comboObjects[3].GetItemCount(); i++) {
				if (comboObjects[3].GetSelectText()== comboObjects[3].GetText(i, 0)) {
					flag=true;
					break;
				}
			}
			if (flag == false) {
				ComShowCodeMessage("CIM29024");
				comboObjects[3].SetSelectText("");
	//			comboObjects[3].focus();
				return false;
			}
			flag=false;
	//		//	comboObjects[4].focus();
		}
	}
	/**
	 * validating POL code 
	 * @param KeyCode
	 * @param Shift
	 * @return
	 */
	function port02_OnBlur(KeyCode, Shift) {
		flag=false;
		if (comboObjects[4].GetSelectText().length > 0) {
			comboObjects[4].SetSelectText(comboObjects[4].GetSelectText().toUpperCase());
			for ( var i=0; i < comboObjects[4].GetItemCount(); i++) {
				if (comboObjects[4].GetSelectText()== comboObjects[4].GetText(i, 0)) {
					flag=true;
					break;
				}
			}
			if (flag == false) {
				ComShowCodeMessage("CIM29024");
				comboObjects[4].SetSelectText("");
	//			comboObjects[4].focus();
				return false;
			} else {
	//			document.form.cargotype.focus();
			}
			flag=false;
	//		//document.form.cargotype.focus();
		}
	}
	function obj_change() {
		obj=ComGetEvent();
		if (obj.name == "period") {
			if (obj.value == "M") {
				document.getElementById("froms").setAttribute("dataformat", "ym");
				document.getElementById("tos").setAttribute("dataformat", "ym");
				document.form.froms.value="";
				document.form.tos.value="";
				document.form.from.value="";
				document.form.to.value="";
	//			document.getElementById("froms").focus();
			} else {
				document.getElementById("froms").setAttribute("dataformat", "yw");
				document.getElementById("tos").setAttribute("dataformat", "yw");
				document.form.froms.value="";
				document.form.tos.value="";
				document.form.from.value="";
				document.form.to.value="";
	//			document.getElementById("froms").focus();
			}
		}
	}
	function lastDay(y, m) {
		var d, d2, s="";
		d=new Date();
		d2=new Date(y, m, "");
		s=d2.getDate();
		return (s);
	}
	function obj_activate() {
		ComClearSeparator(ComGetEvent());
		ComSetFocus(ComGetEvent());
	}
	function setDate() {
		var today=new Date();
		var y=today.getFullYear().toString();
		var m=(today.getMonth() + 1).toString();
		if (m.length == 1) {
			m=0 + m;
		}
		var ym=y + '-' + m;
		document.form.froms.value=ym;
		document.form.tos.value=ym;
		var day=lastDay(y, m);
		document.form.from.value=y + m + "01";
		document.form.to.value=y + m + day;
	}
	function initCombo(comboObj, comboNo) {
		switch (comboObj.options.id) {
		case "combo_lane":
			with (comboObj) {
				SetColAlign(0, "center");
				SetColAlign(1, "left");
				SetColWidth(0, "50");
				SetColWidth(1, "200");
				SetTitle("combo_lane|Description");
				SetMultiSelect(0);
				SetUseAutoComplete(1);
				SetDropHeight(200);
				SetMaxLength(3);
			}
			break;
		case "rcc01":
			var i=0;
			with (comboObj) {
				SetBackColor("#CCFFFF");
				SetMultiSelect(0);
				SetUseAutoComplete(1);
				//MaxSelect = 1;
				SetDropHeight(200);
				SetMaxLength(5);
			}
			break;
		case "rcc02":
			var i=0;
			with (comboObj) {
				//BackColor = "#CCFFFF";
				SetDropHeight(200);
				SetMultiSelect(0);
				SetUseAutoComplete(1);
				SetMaxLength(5);
			}
			break;
		case "port01":
			var i=0;
			with (comboObj) {
				SetBackColor("#CCFFFF");
				SetDropHeight(200);
				SetMultiSelect(0);
				SetUseAutoComplete(1);
				SetEnable(0);
				SetMaxLength(5);
			}
			break;
		case "port02":
			var i=0;
			with (comboObj) {
				//BackColor = "#CCFFFF";
				SetDropHeight(200);
				SetMultiSelect(0);
				SetUseAutoComplete(1);
				SetEnable(0);
				SetMaxLength(5);
			}
			break;
		}
	}
	
/** function MakeComboObject(cmbObj, arrStr) {
		for ( var i=0; i < arrStr.length; i++) {
			cmbObj.InsertItem(i, arrStr[i], arrStr[i]);
		}
	}
	function MakeComboObject2(cmbObj, arrStr) {
		for ( var i=0; i < arrStr.length; i++) {
			cmbObj.InsertItem(i, arrStr[i], arrStr[i].substring(0, 3));
		}
	}*/
	
	function MakeComboObject(cmbObj, arrStr) {
		var insertObj = new Array();
	      for ( var i=0; i < arrStr.length; i++) {
	         insertObj.push({text:arrStr[i], code:arrStr[i]});
	      }
	      cmbObj.InsertBatchItem(0, insertObj);
	} 

	function MakeComboObject2(cmbObj, arrStr) {
		var insertObj = new Array();
	      for ( var i=0; i < arrStr.length; i++) {
	         insertObj.push({text:arrStr[i], code:arrStr[i].substring(0, 3)});
	      }
	      cmbObj.InsertBatchItem(0, insertObj);

	} 
	
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch (sheetID) {
		case "sheet1": //t1sheet1 init
		    with(sheetObj){
	        	var HeadTitle="POD|POL|Total";
	        	oldCntrTypeSize=sCntrTypeSize;
	        	var arrCntrTypeSize=oldCntrTypeSize.split(",");
	        	for ( var i=0; i < arrCntrTypeSize.length; i++) {
	        		if (sCntrTypeSize != "") {
	        			HeadTitle += "|" + arrCntrTypeSize[i];
	        		}
	        	}
	        	var FM=80;
	        	var TO=60;
	        	var Total=60;
	        	SetConfig( { SearchMode:2, FrozenCol:3, MergeSheet:7, Page:20, DataRowMerge:0, PrevColumnMergeMode:0 } );
	        	var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	        	var headers = [ { Text:HeadTitle, Align:"Center"} ];
	        	InitHeaders(headers, info);
	
	        	var cols = [ {Type:"Text",      Hidden:0,  Width:FM,   Align:"Center",  ColMerge:1,   SaveName:"loccode01",   KeyField:0,   CalcLogic:"",   Format:"" },
	        	             {Type:"Text",      Hidden:0,  Width:TO,   Align:"Center",  ColMerge:1,   SaveName:"loccode02",   KeyField:0,   CalcLogic:"",   Format:"" },
	        	             {Type:"AutoSum",   Hidden:0, Width:Total,Align:"Right",   ColMerge:1,   SaveName:"counttotal",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:1 } ];
	        	var sCount="";
				var x=1;
	        	for ( var i = 0; i < arrCntrTypeSize.length; i++) {
	        		if (arrCntrTypeSize.length > 1) {
	        			if (x < 10) {
	        				sCount = "count0" + x;
	        			} else {
	        				sCount = "count" + x;
	        			}
		    			cols.push({Type:"AutoSum", Hidden:0, Width:50, Align:"Right",   ColMerge:1,   SaveName:sCount, KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:1 });
		    			x++;
	        		}
	        	}
	        	SetEditable(0);
	        	InitColumns(cols);
	        	SetSheetHeight(400);
	        	//resizeSheet();
	      	}
			break;
		}
	}
	// Sheet의 높이 자동으로 변경
    /*function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }*/
	//handling process for Sheet
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
		case IBSEARCH:
			isOpen=true;
			if (validateForm(sheetObj, formObj, sAction)) {
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				formObj.f_cmd.value=SEARCH01;
				sheetObj.DoSearch("EES_CIM_1033GS.do", FormQueryString(formObj) );
				sheetObj.SetWaitImageVisible(1);
				ComOpenWait(false);
			} else {
				return;
			}
			break;
		case IBSEARCH_ASYNC01: 
			if (validateForm(sheetObj, formObj, sAction)) {
				//formObj.f_cmd.value = SEARCH02;
				//var sXml = sheetObj.GetSearchXml("EES_CIM_1033GS.do",	FormQueryString(formObj));
				var sXml=formObj.sXml.value;
				var sRcc=ComGetEtcData(sXml, "sRcc");
				if (sRcc != undefined) {
					var arrRcc=sRcc.split("|");
					MakeComboObject(rcc01, arrRcc);
					MakeComboObject(rcc02, arrRcc);
				}
				var sPol=ComGetEtcData(sXml, "sPort");
				if (sPol != undefined) {
					var arrPol=sPol.split("|");
					MakeComboObject(port01, arrPol);
					MakeComboObject(port02, arrPol);
				}
				var sLane=ComGetEtcData(sXml, "sLane");
				if (sLane != undefined) {
					var arrLane=sLane.split(",");
					MakeComboObject2(combo_lane, arrLane);
				}
				sCntrTypeSize=ComGetEtcData(sXml, "cntrTypeSize");
				//getting changing column information from server
				if (oldCntrTypeSize != sCntrTypeSize) {
					oldCntrTypeSize=sCntrTypeSize;
					sheetObj = sheetObj.Reset();
					sheetObjects[0] = sheetObj;
					
					initSheet(sheetObjects[0]);
				}
				//	sheetObj.LoadSearchXml(sXml);
				ComSetFocus(document.form.froms);
			}
			break;
		case IBSEARCH_ASYNC02: //location focusOut
			if (validateForm(sheetObj, formObj, sAction)) {
				formObj.f_cmd.value=SEARCH03;
				sheetObj.SetWaitImageVisible(0);
				var sXml=sheetObj.GetSearchData("EES_CIM_1033GS.do", FormQueryString(formObj));
				var sCheck=ComGetEtcData(sXml, "check");
				if (sCheck != "OK") {
					ComShowCodeMessage("CIM29023");
					document.form.vvd01.value="";
					sheetObj.SetWaitImageVisible(1);
					ComSetFocus(document.form.vvd01);
					return false;
				}
	//			formObj.directionwise.focus();
				sheetObj.SetWaitImageVisible(1);
			} else {
				return;
			}
			break;
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		with (formObj) {
			if (sAction == IBSEARCH) {
				var check="";
				for ( var i=0; i < option.length; i++) {
					if (option[i].checked) {
						check=option[i].value;
					}
				}
				if (check == "P") {
					if (period.value == "M") {
						if (froms.value == "") {
							ComShowCodeMessage("CIM21001", "Period");
							ComSetFocus(froms);
							return false;
						} else if (tos.value == "") {
							ComShowCodeMessage("CIM21001", "Period");
							ComSetFocus(tos);
							return false;
						}
					} else if (period.value == "W") {
						if (froms.value == "") {
							ComShowCodeMessage("CIM21001", "Period");
							ComSetFocus(froms);
							return false;
						} else if (tos.value == "") {
							ComShowCodeMessage("CIM21001", "Period");
							ComSetFocus(tos);
							return false;
						}
					}
					if (froms.value.length < 6) {
						return false;
					} else if (tos.value.length < 6) {
						return false;
					}
					if (!enterSwitch) {
						return false;
					}
				} else {
					if (vvd01.value == "") {
						ComShowCodeMessage("CIM29006");
						ComSetFocus(vvd01);
						return false;
					}
				}
				var check2="";
				for ( var i=0; i < inquirywise.length; i++) {
					if (inquirywise[i].checked) {
						check2=inquirywise[i].value;
					}
				}
				if (check2 == "R") {
					if (comboObjects[1].GetSelectCode()== "") {
						ComShowCodeMessage("CIM29001");
						ComSetFocus(rcc01);
						return false;
					}
				} else {
					if (comboObjects[3].GetSelectCode()== "") {
						ComShowCodeMessage("CIM29007");
						ComSetFocus(port01);
						return false;
					}
				}
			}
		}
		return true;
	}
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		with (sheetObj) {
			var arrTime=sCntrTypeSize.split(",");
			if (RowCount()> 0) {
				SetRowHidden(RowCount(),1);	
				//2014.12.01 민정호
				var sumValue = 0;
				for ( var i=2; i < arrTime.length + 3; i++) {
					sumValue = GetCellValue(RowCount(),i)*-1;
					SetCellValue(RowCount(), i, sumValue);
				}			
				
				for ( var i=2; i < arrTime.length + 3; i++) {
					SetSumText(0, i,GetCellText(RowCount(), i));					
				}
				SetSumText(0, 0,"G.Total");
				SetCellAlign(LastRow(), 0,"Center");
				if (RowCount()> 0) {
					SetMergeCell(LastRow(), 0, 1, 2);
				}
			}
			
		}
	}
	
	function combo_lane_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		if(newText == "") {
			newText = "ALL";
		}
		
    	document.form.combo_lane_text.value = newText;
    }
   
    function combo_lane_OnBlur(comboObj) {
    	//document.form.combo_lane_text.value = comboObj.GetSelectText();
    }
    
    var inputEngSet = function(){
        $("[name^='rcc01']").css("text-transform","uppercase");
        $("[name^='rcc01']").keyup(function(event){
     	                                 if (!((event.keyCode >=37 && event.keyCode<=40)||   // 영어
     	                                		 (event.keyCode >=48 && event.keyCode<=57) )){ // 숫자
     		                                 var inputVal = $(this).val();
     	 	                                $(this).val(inputVal.replace(/[^a-z][^0-9]/gi,'')); // 영어 숫만 외문자는 삭제
     	                                 }
                             });
        $("[name^='rcc02']").css("text-transform","uppercase");
        $("[name^='rcc02']").keyup(function(event){
     	                                 if (!((event.keyCode >=37 && event.keyCode<=40)||   // 영어
     	                                		 (event.keyCode >=48 && event.keyCode<=57) )){ // 숫자
     		                                 var inputVal = $(this).val();
     	 	                                $(this).val(inputVal.replace(/[^a-z][^0-9]/gi,'')); // 영어 숫만 외문자는 삭제
     	                                 }
                             });
        $("[name^='port01']").css("text-transform","uppercase");
        $("[name^='port01']").keyup(function(event){
     	                                 if (!((event.keyCode >=37 && event.keyCode<=40)||   // 영어
     	                                		 (event.keyCode >=48 && event.keyCode<=57) )){ // 숫자
     		                                 var inputVal = $(this).val();
     	 	                                $(this).val(inputVal.replace(/[^a-z][^0-9]/gi,'')); // 영어 숫만 외문자는 삭제
     	                                 }
                             });
        $("[name^='port02']").css("text-transform","uppercase");
        $("[name^='port02']").keyup(function(event){
     	                                 if (!((event.keyCode >=37 && event.keyCode<=40)||   // 영어
     	                                		 (event.keyCode >=48 && event.keyCode<=57) )){ // 숫자
     		                                 var inputVal = $(this).val();
     	 	                                $(this).val(inputVal.replace(/[^a-z][^0-9]/gi,'')); // 영어 숫만 외문자는 삭제
     	                                 }
                             });
      }
    