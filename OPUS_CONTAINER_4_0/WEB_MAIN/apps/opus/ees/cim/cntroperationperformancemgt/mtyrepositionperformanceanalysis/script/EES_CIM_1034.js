/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_1034.js
*@FileTitle  : Repo Result by Location
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/17
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class ees_cim_1034 : business script for ees_cim_1034 
 */
/* developer job	*/
//common global variables
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
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
		case "btn_Retrieve":
			doActionIBSheet(sheet1, formObject, IBSEARCH);
			sheetObjects[0].SetSelectRow(0);
			break;
		case "btn_DownExcel":
			if(sheet1.RowCount() < 1){//no data
				ComShowCodeMessage("COM132501");
			}else{
//				sheet1.Down2Excel({ HiddenColumn:-1});
				sheet1.Down2Excel({ SheetDesign:1, HiddenColumn:1, Merge:1 });
			}
			break;
		case "btn_location1": // location retrieving popup
			var check="";
			for ( var i=0; i < formObject.inquirywise.length; i++) {
				if (formObject.inquirywise[i].checked) { 
					check=formObject.inquirywise[i].value;
				} 
			}
			if (check == "L") {
				ComOpenPopup('/opuscntr/COM_ENS_051.do', 850, 460, "getLocationInfo1", '1,0,1,1,1,1,1,1', true);
			}
			break;
		case "btn_location2": //location2 retrieving popup
			var check="";
			for ( var i=0; i < formObject.inquirywise.length; i++) {
				if (formObject.inquirywise[i].checked) {
					check=formObject.inquirywise[i].value;
				}
			}
			if (check == "L") {
				ComOpenPopup('/opuscntr/COM_ENS_051.do', 850, 460, "getLocationInfo2", '1,0,1,1,1,1,1,1', true);
			}
			break;
		case "btn_new":
			//alert(sheet1.Version());
			sheet1.RemoveAll();
			//alert(1);
			formObject.reset();
			initForm();
			ComSetFocus(formObject.froms);
			break;
		} // end switch
	} catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * Location Port Code Inquiry부분.<br>
 * @param {arry} aryPopupData
 */
function getLocationInfo1(aryPopupData) {
	var formObject=document.form;
	var location=aryPopupData[0][3];
	formObject.loccode1.value=location;
}
/**
 * Location Port Code Inquiry부분.<br>
 * @param {arry} aryPopupData
 */
function getLocationInfo2(aryPopupData) {
	var formObject=document.form;
	var location=aryPopupData[0][3];
	formObject.loccode2.value=location;
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
	sheet1_OnLoadFinish(sheet1);
	inputEngSet();
}
function sheet1_OnLoadFinish(sheetObj) {
	//	sheetObj.WaitImageVisible = false;
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
	//	sheetObj.WaitImageVisible = true;
}
function initControl() {
//	axon_event.addListener('click', 'reverse_cntr_tpsz_cd_check', 'chk_cntr_tpsz_cd', '');
	axon_event.addListenerForm('change', 'obj_change', form);
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form); 
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form);
	axon_event.addListenerForm('blur', 'obj_deactivate', form);
	axon_event.addListenerForm('click', 'obj_tpsz_click', form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListenerForm('blur', 'obj_locLevelBlur', form);
	document.form.loccode1.disabled=true;
	document.form.loccode2.disabled=true;
	document.getElementById("loccode1").className="input2";
	document.getElementById("loccode2").className="input2";
}

/**
 * initializing form when clicking NEW button
 * @return
 */
function initForm() {
	comboObjects[0].SetSelectCode("");
	comboObjects[0].SetEnable(1);
	document.form.loccode1.value="";
	document.form.loccode2.value="";
	document.form.loccode1.disabled=true;
	document.form.loccode2.disabled=true;
	document.getElementById("loccode1").className="input2";
	document.getElementById("loccode2").className="input2";
	sheetObjects[0].SetCellValue(0, 0,"To LCC",0);
	sheetObjects[0].SetCellValue(0, 1,"Fm LCC",0);
	document.form.rdtype.disabled=true;
	document.form.rdtype.value="I";
}
function obj_locLevelBlur() {
	switch (ComGetEvent("name")) {
	case "loccode1":
		if (ComGetEvent().value != "") {
			document.getElementById("location").value=document.getElementById("loccode1").value;
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02, "loccode1");
		}
		break;
	case "loccode2":
		if (ComGetEvent().value != "") {
			document.getElementById("location").value=document.getElementById("loccode2").value;
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02, "loccode2");
		}
		break;
	}
}
/**
 * RCC code 입력값 체크
 * @param KeyCode
 * @param Shift
 * @return
 */
function rcc_OnBlur(KeyCode, Shift) {
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
			ComShowCodeMessage("CIM29008");
			comboObjects[0].SetSelectText("");
//			comboObjects[0].focus();
			return true;
		}
		flag=false;
//		//document.form.cargotype.focus();
	}
}
/**
 * obj_tpsz_click 클릭 이벤트
 * @return
 */
function obj_tpsz_click() {
	obj=ComGetEvent();
	if (obj.name == "tpsz") { // TP/SZ 종류에 따라
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
			comboObjects[0].SetSelectCode("");
			comboObjects[0].SetEnable(0);
			$('#loccode1, #btn_location1, #btn_location2').prop('disabled', false).prop('required', true);
			$('#loccode2').prop('disabled', false);
		} else {
			comboObjects[0].SetEnable(1);
			document.form.loccode1.value="";
			document.form.loccode2.value="";
			$('#loccode1, #loccode2, #btn_location1, #btn_location2').prop('disabled', true).prop('required', false);
		}
	} else if (obj.name == "inquirylevel") {
		if (document.form.directionwise.value != "F") {
			if (obj.value == "L") {
				sheetObjects[0].SetCellValue(0, 0,"To LCC",0);
				sheetObjects[0].SetCellValue(0, 1,"Fm LCC",0);
			} else if (obj.value == "E") {
				sheetObjects[0].SetCellValue(0, 0,"To ECC",0);
				sheetObjects[0].SetCellValue(0, 1,"Fm ECC",0);
			} else if (obj.value == "S") {
				sheetObjects[0].SetCellValue(0, 0,"To SCC",0);
				sheetObjects[0].SetCellValue(0, 1,"Fm SCC",0);
			}
		} else {
			if (obj.value == "L") {
				sheetObjects[0].SetCellValue(0, 0,"Fm LCC",0);
				sheetObjects[0].SetCellValue(0, 1,"To LCC",0);
			} else if (obj.value == "E") {
				sheetObjects[0].SetCellValue(0, 0,"Fm ECC",0);
				sheetObjects[0].SetCellValue(0, 1,"To ECC",0);
			} else if (obj.value == "S") {
				sheetObjects[0].SetCellValue(0, 0,"Fm SCC",0);
				sheetObjects[0].SetCellValue(0, 1,"To SCC",0);
			}
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
						ComSetFocus(document.form.tos);
						t.select();
						return false;
					} else {
						if (chkToDateWeekBlur() == false) {
							enterSwitch=false;
							t.value="";
//							t.focus();
							ComSetFocus(document.form.tos);
							t.select();
							return false;
						}
					}
					document.getElementById("from").value=sVal1 + "01";
					document.getElementById("to").value=sVal2 + day;
					ComSetFocus(document.form.tos);
				}
			} else { // retrieving by week
				if (sVal1 != "" && sVal2 != "") {
					if (ComParseInt(sVal1) > ComParseInt(sVal2)) {
						ComShowCodeMessage("CIM29003");
						enterSwitch=false;
						t.value="";
//						t.focus();
						ComSetFocus(document.form.tos);
						t.select();
						return false;
					} else {
						if (chkToDateWeekBlur() == false) {
							enterSwitch=false;
							t.value="";
//							t.focus();
							ComSetFocus(document.form.tos);
							t.select();
							return false;
						}
					}
					document.getElementById("from").value=sVal1;
					document.getElementById("to").value=sVal2;
					ComSetFocus(document.form.tos);
				}
			}
		} else {
			if (f.getAttribute("dataformat") == "ym") {
				if (sVal1.length > 0 && !ComIsMonth(sVal1.substring(4, 6)) && ComGetEvent("name") == 'froms') {
					ComGetEvent().value="";
					ComShowCodeMessage("CIM21004", "YYYYMM");
					enterSwitch=false;
//					ComGetEvent().focus();
//					ComGetEvent().select();
					return false;
				}
			} else { // retrieving by week
				if (sVal1.length > 0 && !ComIsWeek(sVal1.substring(4, 6)) && ComGetEvent("name") == 'froms') {
					ComGetEvent().value="";
					ComShowCodeMessage("CIM21004", "YYYYWW");
//					ComGetEvent().focus();
//					ComGetEvent().select();
					enterSwitch=false;
					return false;
				}
			}
		}
		ComSetFocus(document.form.tos);
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
//						t.select();
						return false;
					} else {
						if (chkToDateWeekBlur() == false) {
							enterSwitch=false;
							ComGetEvent().value="";
//							t.focus();
//							t.select();
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
//							t.select();
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
	}
	return true;
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
	} else if (obj.name == "directionwise") {
		var checkValue="";
		for ( var i=0; i < document.form.inquirylevel.length; i++) {
			if (document.form.inquirylevel[i].checked) {
				checkValue=document.form.inquirylevel[i].value;
			}
		}
		var ft=document.getElementById("ff");
		var ld=document.getElementById("tt");
		if (obj.value != "F") {
			ft.innerText="From";
			ld.innerText="To";
			ft.textContent="From";
			ld.textContent="To";
			if (checkValue == "L") {
				sheetObjects[0].SetCellValue(0, 0,"To LCC",0);
				sheetObjects[0].SetCellValue(0, 1,"Fm LCC",0);
			} else if (checkValue == "E") {
				sheetObjects[0].SetCellValue(0, 0,"To ECC",0);
				sheetObjects[0].SetCellValue(0, 1,"Fm ECC",0);
			} else if (checkValue == "S") {
				sheetObjects[0].SetCellValue(0, 0,"To SCC",0);
				sheetObjects[0].SetCellValue(0, 1,"Fm SCC",0);
			}
		} else {
			ft.innerText="To";
			ld.innerText="From";
			ft.textContent="To";
			ld.textContent="From";
			if (checkValue == "L") {
				sheetObjects[0].SetCellValue(0, 0,"Fm LCC",0);
				sheetObjects[0].SetCellValue(0, 1,"To LCC",0);
			} else if (checkValue == "E") {
				sheetObjects[0].SetCellValue(0, 0,"Fm ECC",0);
				sheetObjects[0].SetCellValue(0, 1,"To ECC",0);
			} else if (checkValue == "S") {
				sheetObjects[0].SetCellValue(0, 0,"Fm SCC",0);
				sheetObjects[0].SetCellValue(0, 1,"To SCC",0);
			}
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
	case "rcc":
		var i=0;
		with (comboObj) {
//			SetBackColor("#CCFFFF");
			SetBackColor("#E9F4FF");
			SetDropHeight(200);
			SetMultiSelect(0);
			SetUseAutoComplete(1);
			SetMaxLength(5);
		}
		break;
	}
}
function MakeComboObject(cmbObj, arrStr) {
	for ( var i=0; i < arrStr.length; i++) {
		cmbObj.InsertItem(i, arrStr[i], arrStr[i]);
	}
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
	case "sheet1": //sheet1 init
	    with(sheetObj){
	      var HeadTitle="To LCC|Fm LCC|Total";
	      oldCntrTypeSize=sCntrTypeSize;
	      var arrCntrTypeSize=oldCntrTypeSize.split(",");
	      var arrHead=new Array();
	      for ( var i=0; i < arrCntrTypeSize.length; i++) {
		      if (sCntrTypeSize != "") {
		    	  HeadTitle += "|" + arrCntrTypeSize[i];
		      }
	      }
	      var TO=80;
	      var FM=60;
	      var Total=60;
	
	      SetConfig( { SearchMode:2, FrozenCol:3, MergeSheet:7, Page:20} );
	
	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
	      InitHeaders(headers, info);
	
	      var cols = [ {Type:"Text",      Hidden:0,  Width:FM,   Align:"Center",  ColMerge:1,   SaveName:"loccode01",   KeyField:0,   CalcLogic:"",   Format:"",UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:TO,   Align:"Center",  ColMerge:1,   SaveName:"loccode02",   KeyField:0,   CalcLogic:"",   Format:"",UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Int",   Hidden:0, Width:Total,Align:"Right",   ColMerge:1,   SaveName:"counttotal",  KeyField:0,   CalcLogic:"",   Format:"NullInteger",UpdateEdit:0,   InsertEdit:0} ];
	      
	      var sCount="";
	      var x=1;
	      for ( var i = 0; i < arrCntrTypeSize.length; i++) {
		      if (arrCntrTypeSize.length > 1) {
			      if (x < 10) {
			    	  sCount = "count0" + x;
			      } else {
			    	  sCount = "count" + x;
			      }
			      cols.push({Type:"Int",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:sCount,    KeyField:0,   CalcLogic:"",   Format:"NullInteger",UpdateEdit:0,   InsertEdit:0});  
			        
			      //var x=1;
			      x++;
		      }
	      }
	      cols.push({Type:"AutoSum",   Hidden:1, Width:50,   Align:"Right"});
	      SetEditable(1);
	      InitColumns(cols);
	      //SetSheetHeight(360);
	      resizeSheet();
	      SetCountPosition(0);
	      SetSumRowHidden(0);
//	      SetSumText(0, 0,"G.Total");
      	}
		break;
	}
}
//Sheet의 높이 자동으로 변경
function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}
//handling process for Sheet
function doActionIBSheet(sheetObj, formObj, sAction, gubun) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: 
		isOpen=true;
		if (validateForm(sheetObj, formObj, sAction)) {
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
			sheetObj.DoSearch("EES_CIM_1034GS.do", FormQueryString(formObj) );
			sheetObj.SetWaitImageVisible(1);
			ComOpenWait(false);
		} else {
			return;
		}
		break;
	case IBSEARCH_ASYNC01:
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value=SEARCH02;
			//var sXml = sheetObj.GetSearchXml("EES_CIM_1033GS.do",	FormQueryString(formObj));
			var sXml=formObj.sXml.value;
			var sRcc=ComGetEtcData(sXml, "sRcc");
			if (sRcc != undefined) {
				var arrRcc=sRcc.split("|");
				MakeComboObject(rcc, arrRcc);
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
	case IBSEARCH_ASYNC02:
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value=SEARCH02;
			sheetObj.SetWaitImageVisible(0);
			var sXml=sheetObj.GetSearchData("EES_CIM_1001GS.do", FormQueryString(formObj));
			var sCheck=ComGetEtcData(sXml, "check");
			if (sCheck != "OK") {
				ComShowCodeMessage("CIM29024");
				if (gubun == "loccode1") {
					formObj.loccode1.value="";
					ComSetFocus(formObj.loccode1);
				} else if (gubun == "loccode2") {
					formObj.loccode2.value="";
					ComSetFocus(formObj.loccode2);
				}
				sheetObj.SetWaitImageVisible(1);
				return false;
			}
			if (gubun == "loccode1") {
				formObj.loccode2.value="";
				ComSetFocus(formObj.loccode2);
			} else if (gubun == "loccode2") {
				ComSetFocus(formObj.cargotype);
			}
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
			var check2="";
			for ( var i=0; i < inquirywise.length; i++) {
				if (inquirywise[i].checked) {
					check2=inquirywise[i].value;
				}
			}
			if (check2 == "R") {
				if (comboObjects[0].GetSelectCode()== "") {
					ComShowCodeMessage("CIM29001");
					ComSetFocus(rcc);
					return false;
				}
			} else {
				if (loccode1.value == "") {
					ComShowCodeMessage("CIM29002");
					ComSetFocus(loccode1);
					return false;
				}
				if (loccode1.value.length < 5) {
					ComShowCodeMessage("CIM29024");
					ComSetFocus(loccode1);
					return false;
				}
			}
		}
	}
	return true;
}
function sheet1_OnChangeSum(sheetObj, Row) {
	with (sheetObj) {
		SetSumText(0, "TO","G.Total");
		SetSumText(0, "Bound","I/B");
		SetSumText(1, "Bound","O/B");
		SetSumText(2, "Bound","Bal.");
		SetSumText(3, "Bound","M/B");
	}
}
function sheet1_OnSearchEnd(sheetObj, Code, ErrMsg) {
	with (sheetObj) {
		var arrTime=sCntrTypeSize.split(",");
		if (RowCount()> 0) {
			SetRowHidden(RowCount(),1);
			
			for ( var i=2; i < arrTime.length + 3; i++) {
//				if ( ComIsNull( GetCellValue(RowCount(), i) ) ) {
//					SetSumText(0, i ,"");
//				}
			SetSumText(0, i,GetCellText(RowCount(), i));
				//SetSumText(RowCount(), i,10);
			}
			SetSumText(0, 0,"G.Total");
			SetCellAlign(LastRow(), 0,"Center");
			if (RowCount()> 0) {
				SetMergeCell(LastRow(), 0, 1, 2);
			}
		}
		
	}
}

var inputEngSet = function(){
    $("[name^='rcc']").css("text-transform","uppercase");
   $("[name^='rcc']").keyup(function(event){
	                                 if (!((event.keyCode >=37 && event.keyCode<=40)||   // 영어
	                                		 (event.keyCode >=48 && event.keyCode<=57) )){ // 숫자
		                                 var inputVal = $(this).val();
	 	                                $(this).val(inputVal.replace(/[^a-z][^0-9]/gi,'')); // 영어 숫만 외문자는 삭제
	                                 }
                        });
  }

	/* end of developer job */