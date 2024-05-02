﻿/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0229_07.js
*@FileTitle  : e-Booking & SI Process Detail(REEFER)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/08
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// Common global variable
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var comboNmArr;
var comboVlArr;
var iterator="|$$|";
var isCopy="false";
var prefix="t7sheet1_";
var cmdtPosition=0;
var cntrTpsz_cd="";
var cntrTpsz_id="";
var max_rc_seq=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	/*****  Tab ->two or more sheet : sheet  a variable assignment *****/
	var sheetObject=sheetObjects[0];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case IBCLEAR:
			doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
			break;
		case "btn_cancelcopydata":
			parent.document.form.reeferTabCancel.value="Y";
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			isCopy="false";
			top.isCopyAllRequested=false;
			break;
		case "btn_datacopytoopus":
			doSaveCopy();
			if (isCopy == "false") {
				dataCopy();
			}
			break;
		case "btn_upload":
			doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
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
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	for (i=0; i < sheetObjects.length; i++) {
		//khlee- Preferences change the name of the function to start
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		// khlee- The final configuration functions added
		ComEndConfigSheet(sheetObjects[i]);
		// IBMultiCombo
	}
    for(var k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],k+1);           
    }    
	doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
	initControl();
}
function initControl() {
 	var formObject=document.form;
 	// Axon Event Processing 1. Events catch (developers change)
 	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject);
	axon_event.addListenerForm("change", "form_onChange", formObject);
	
	ComFormControlAxon();
	applyShortcut();
}
/**
* The initial setting combo
* 
* @param {IBMultiCombo}
*            comboObj comboObj
*/
function initCombo(comboObj) {
	comboObj.SetMultiSelect(0);
//no support[check again]CLT 	comboObj.UseCode=true;
//no support[check again]CLT 	comboObj.LineColor="#ffffff";
	comboObj.SetColAlign(0, "left");
	comboObj.SetColAlign(1, "left");
	comboObj.SetMultiSeparator("|");
}
/**
* registering IBCombo Object as list
* 
* @param {IBMultiCombo}
*            combo_obj IBMultiCombo Object
*/
function setComboObject(combo_obj) {
	comboObjects[comboCnt++]=combo_obj;
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
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch (sheetID) {
	case "sheet1":
		with (sheetObj) {
	        if (location.hostname != "")
	        var HeadTitle1="ibflag|bkg_no|rc_seq|cntr_tpsz_cd|cntr_no|cmdt_cd|cmdt_desc|fdo_temp|cdo_temp|pwr_spl_cbl_flg|vent_rto|clng_tp_cd|humid_no|MAX"
	        var headCount=ComCountHeadTitle(HeadTitle1);
	//        (headCount, 0, 0, true);
	
	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);
	
	        var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	               {Type:"Text",     Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"bkg_no" },
	               {Type:"Text",     Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"rc_seq" },
	               {Type:"Text",     Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"cntr_tpsz_cd" },
	               {Type:"Text",     Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"cntr_no" },
	               {Type:"Text",     Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"cmdt_cd" },
	               {Type:"Text",     Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"cmdt_desc" },
	               {Type:"Float",     Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"fdo_temp",         KeyField:0,   CalcLogic:"",   Format:"NullFloat" },
	               {Type:"Float",     Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"cdo_temp",         KeyField:0,   CalcLogic:"",   Format:"NullFloat" },
	               {Type:"Text",     Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"pwr_spl_cbl_flg" },
	               {Type:"Text",     Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"vent_rto" },
	               {Type:"Text",     Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"clng_tp_cd" },
	               {Type:"Text",     Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"humid_no" },
	               {Type:"Text",     Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"max_rc_seq" },
	               {Type:"Text",     Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"cntr_vent_tp_cd" },
	               {Type:"Text",     Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"diff_rmk" }];
	         
	        InitColumns(cols);
	        SetEditable(1);
	        SetVisible(false);
		}
		break;
	}
}
// Sheet handling process
function doActionIBSheet(sheetObj, formObj, sAction) {
//	sheetObj.ShowDebugMsg = 1;
	switch (sAction) {
	case IBCLEAR: //Retrieve
		if (formObj.bkg_no2.value != null && formObj.bkg_no2.value != '') {
			var formObj2=document.form2;
			var obj=null;
			var objNm=null;
			var objVal=null;
			var obj2=null;
			var objNm2=null;
			var objVal2=null;
			var sameCntr="false";
			for ( var i=0; i < formObj2.elements.length; i++) {
				if (formObj2.elements[i].type == "text"
						&& (formObj2.elements[i].name).indexOf("__") > 0) {
					obj=(formObj2.elements[i].name).split("__");
					objNm=obj[0];
					objVal=formObj2.elements[i].value;
					if (objNm == "cntr_no") {
						for ( var j=0; j < formObj.elements.length; j++) {
							if ((formObj.elements[j].name).indexOf("__") > 0) {
								obj2=(formObj.elements[j].name).split("__");
								objNm2=obj2[0];
								objVal2=formObj.elements[j].value;
								if (objNm2 == "cntr_no") {
									if (objVal == objVal2) {
										sameCntr="true";
										break;
									} else {
										sameCntr="false";
									}
								}
							}
						}
						if (sameCntr == "true") {
							compareCntr(obj2[1], obj[1]);
						}
					}
				}
			}
			var sXml=formObj.sXml.value;
			var arrXml=sXml.split("|$$|");
			sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
			//combo
			/*if (arrXml.length > 2) {
				if (formObj.initComboName) {
					var combo;
					comboNmArr=new Array();
					comboVlArr=new Array();
					if (formObj.initComboName.length) {
						for (var i=0; i<formObj.initComboName.length; i++) {
							combo=document.getElementById(formObj.initComboName[i].value);
							ComBkgXml2ComboItem(arrXml[2], combo, "val", "name");
							if (0==i) {
								for (var j=0; j<combo.GetItemCount(); j++) {
									comboNmArr[j]=combo.GetText(j,0);
									combo.SetSelectIndex(j);
									comboVlArr[j]=combo.GetSelectCode();
								}
							}
							combo.SetSelectCode(formObj.initComboCode[i].value);
							combo.SetEnable(formObj.initComboEnable[i].value);
						}
					} else {
						combo=document.getElementById(formObj.initComboName.value);
						ComBkgXml2ComboItem(arrXml[2], combo, "val", "name");
						for (var j=0; j<combo.GetItemCount(); j++) {
							comboNmArr[j]=combo.GetText(j,0);
							combo.SetSelectIndex(j);
							comboVlArr[j]=combo.GetSelectCode();
						}
						combo.SetSelectCode(formObj.initComboCode.value);
						combo.SetEnable(formObj.initComboEnable.value);
					}
				}
			}*/
		}
		for(var i=1;i<sheetObjects[0].LastRow();i++){
			if(max_rc_seq<parseInt(sheetObjects[0].GetCellValue(i, "rc_seq"))){
				max_rc_seq=parseInt(sheetObjects[0].GetCellValue(i, "rc_seq"));
			}
		}
		if(parent.document.form.reeferTabCancel.value=="Y"){
			//ComBtnColor("btn_cancelcopydata", "blue");
			//ComBtnColor("btn_datacopytoopus", "#737373");
			
			
			document.getElementById("btn_cancelcopydata").style.cssText = "color:blue !important;font-weight:bold;";
			document.getElementById("btn_datacopytoopus").style.cssText = "color:#737373 !important;font-weight:normal;";
			
			parent.document.form.reeferTabCancel.value="N";
		}
		if(top.document.form.tabload7.value == "COPY"){
			dataCopy();
		} else {
			compareItem();
		}
		if(parent.frames["t1frame"].document.form.doc_tp_cd.value == "S"){
			ComBtnDisable("btn_datacopytoopus");
		}
		top.document.form.tabload7.value="LOAD";
		
		if(parent.subPageSearchEnd != undefined) parent.subPageSearchEnd('ESM_BKG_0229_07');
		
		break;
	case IBSEARCH: //Retrieve
		formObj.f_cmd.value=SEARCH;
		formObj.method="post";
		formObj.target="_self";
		formObj.action="/opuscntr/ESM_BKG_0229_07.do";
		formObj.submit();
//no support[check again]CLT 		parent.tabObjects[0].TabBackColor(6)="#96c792";
		break;
	case IBSEARCH_ASYNC02: //Data Copy
		// DHTML Create table
		var ins_tables=document.getElementById("INS_TABLES");
		ins_tables.innerHTML="";
		var insTableDiv="";
		var maxSeq=0;
		for ( var k=0; k < formObj.elements.length; k++) {
			if ((formObj.elements[k].name).indexOf("cntr_seq__") == 0) {
				if (formObj.elements[k].value > maxSeq)
					maxSeq=formObj.elements[k].value;
			}
		}
		// Comparison of container
		var formObj2=document.form2;
		var obj=null;
		var objNm=null;
		var objVal=null;
		var obj2=null;
		var objNm2=null;
		var objVal2=null;
		var isInsert="false";
		if (maxSeq > 0) {
			for ( var i=0; i < formObj2.elements.length; i++) {
				if (formObj2.elements[i].type == "text"
						&& (formObj2.elements[i].name).indexOf("__") > 0) {
					obj=(formObj2.elements[i].name).split("__");
					objNm=obj[0];
					objVal=formObj2.elements[i].value;
					if (objNm == "rc_seq") {
						for ( var j=0; j < formObj.elements.length; j++) {
							if ((formObj.elements[j].name).indexOf("__") > 0) {
								obj2=(formObj.elements[j].name).split("__");
								objNm2=obj2[0];
								objVal2=formObj.elements[j].value;
								if (objNm2 == "rc_seq") {
									if (objVal == objVal2) {
										isInsert="false";
										break;
									} else {
										isInsert="true";
									}
								}
							}
						}
						if (isInsert == "true") {
							maxSeq++;
							var insTableDiv=createTable(maxSeq);
							ins_tables.innerHTML=ins_tables.innerHTML + insTableDiv;
							createCntr(maxSeq, obj[1]);
						} else if (isInsert == "false") {
							updateCntr(obj2[1], obj[1]);
						}
					}
				}
			}
		} else {
			for ( var i=0; i < formObj2.elements.length; i++) {
				if (formObj2.elements[i].type == "text"
						&& (formObj2.elements[i].name).indexOf("__") > 0) {
					obj=(formObj2.elements[i].name).split("__");
					objNm=obj[0];
					objVal=formObj2.elements[i].value;
					if (objNm == "cntr_no") {
						maxSeq++;
						var insTableDiv=createTable(maxSeq);
						ins_tables.innerHTML=ins_tables.innerHTML + insTableDiv;
						createCntr(maxSeq, obj[1]);
					}
				}
			}
		}
//no support[check again]CLT 		parent.tabObjects[0].TabBackColor(6)="#fff270";
		compareItem();
		initControl();
		break;
	//UPLOAD
	case IBSAVE:
		if (validateForUpload() == false) return;
		var params=getSaveStringForUpload();
 		var sXml=sheetObj.GetSaveData("ESM_BKG_0229_07GS.do", params);
		if(ComBkgErrMessage(sheetObjects[0], sXml)) {
 			sheetObj.LoadSaveData(sXml);
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
		break;
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	for ( var i=0; i < formObj.elements.length; i++) {
		if (formObj.elements[i].name.indexOf("cmdt_cd") == 0){
			if(haveOnlyNumber(formObj.elements[i].value)==false){
				ComShowCodeMessage("BKG00010");		
				ComSetFocus(formObj.elements[i]);
				return false;
			}
		}
	}
	if (!ComChkValid(formObj))
		return false;
	return true;
}
/**
 * being called in case of clicking 'Upload' button.
 * having the function of the same name regardless of tab 
 * being implemented the content that fits to the tab
 * moving to the field if needed after failed to validate before returning false
 * 
 */
function validateForUpload() {
	return validateForm(sheetObjects[0], document.form, IBSAVE);
}
 /**
  * being called in case of clicking 'Upload' button.
  * having the function of the same name regardless of tab 
  * being implemented the content that fits to the tab
  * QueryString return
  */
function getSaveStringForUpload() { 	
 	doSaveCopy();
 	var params="";
	if (sheetObjects[0].RowCount()>0) {
		params="f_cmd=" + MULTI + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true), prefix);
 	}
// 	a"lert("getSaveStringForUpload in ESM_BKG_0229_04.js params=[" + params + "]");
 	return (params);
}
/**
 * e-Booking Upload Copy popup ->[OK] button Click
 */
function dataCopy() {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
	//ComBtnColor("btn_cancelcopydata", "#737373");
	//ComBtnColor("btn_datacopytoopus", "blue");	
		
	document.getElementById("btn_datacopytoopus").style.cssText = "color:blue !important;font-weight:bold;";
	document.getElementById("btn_cancelcopydata").style.cssText = "color:#737373 !important;font-weight:normal;";
	
}
function doSaveCopy(){
 	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	var maxSeq=0;
	for ( var k=0; k < formObj.elements.length; k++) {
		if ((formObj.elements[k].name).indexOf("cntr_seq__") == 0) {
			if (formObj.elements[k].value > maxSeq)
				maxSeq=formObj.elements[k].value;
		}
	}
	for (var i=sheetObj.RowCount(); i<maxSeq; i++) {
		sheetObj.DataInsert(-1);
	}
	var obj=null;
	var objNm=null;
	var objSeq=null;
	var objVal=null;
	var cntrNo=null;
	var ibflag=null;
	var cdo_temp="";
	var fdo_temp="";	
	for(var i=0; i<formObj.elements.length; i++) {
		if ((formObj.elements[i].name).indexOf("__") > 0) {
			obj=(formObj.elements[i].name).split("__");
			objNm=obj[0];
			objSeq=obj[1];
			objVal= formObj.elements[i].value;
			if (sheetObjects[0].GetCellValue(objSeq,"bkg_no") == "") {
				sheetObjects[0].SetCellValue(objSeq,"bkg_no",formObj.bkg_no.value,0);
			}
			if ( objNm == "rc_seq")			sheetObjects[0].SetCellValue(objSeq,"rc_seq",objVal,0);
			if ( objNm == "cntr_no")		sheetObjects[0].SetCellValue(objSeq,"cntr_no",ComTrimAll(objVal),0);
			if ( objNm == "cntr_tpsz_cd" )	sheetObjects[0].SetCellValue(objSeq,"cntr_tpsz_cd",objVal,0);
			if ( objNm == "cmdt_cd")		sheetObjects[0].SetCellValue(objSeq,"cmdt_cd",objVal,0);
			if ( objNm == "cmdt_desc" )		sheetObjects[0].SetCellValue(objSeq,"cmdt_desc",objVal,0);
			if ( objNm == "temperature1" )	cdo_temp=objVal;
			if ( objNm == "cdo_temp" )     	sheetObjects[0].SetCellValue(objSeq,"cdo_temp",cdo_temp + objVal,0);
			if ( objNm == "temperature2" )	fdo_temp=objVal;
			if ( objNm == "fdo_temp" )      sheetObjects[0].SetCellValue(objSeq,"fdo_temp",fdo_temp + objVal,0);
			if ( objNm == "pwr_spl_cbl_flg")sheetObjects[0].SetCellValue(objSeq,"pwr_spl_cbl_flg",objVal,0);
			if ( objNm == "vent_rto" )		sheetObjects[0].SetCellValue(objSeq,"vent_rto",objVal,0);
			if ( objNm == "clng_tp_cd" )	sheetObjects[0].SetCellValue(objSeq,"clng_tp_cd",objVal,0);
			if ( objNm == "humid_no" )		sheetObjects[0].SetCellValue(objSeq,"humid_no",objVal,0);
			if ( objNm == "cntr_vent_tp_cd" ) sheetObjects[0].SetCellValue(objSeq,"cntr_vent_tp_cd",objVal,0);
			if ( objNm == "diff_rmk" ) 		sheetObjects[0].SetCellValue(objSeq,"diff_rmk",objVal,0);
		}
	}
}
function compareItem() {
	var obj=null;
	var objNm=null;
	var objVal=null;
	var obj2=null;
	var objNm2=null;
	var objVal2=null;
	var formObj=document.form;
	var formObj2=document.form2;
	var sameCntr="false";
	for ( var i=0; i < formObj2.elements.length; i++) {
		if ((formObj2.elements[i].name).indexOf("__") > 0) {
			obj=(formObj2.elements[i].name).split("__");
			objNm=obj[0];
			objVal=formObj2.elements[i].value;
			if (objNm == "cntr_no_cmpr") {
				for ( var j=0; j < formObj.elements.length; j++) {
					if ((formObj.elements[j].name).indexOf("__") > 0) {
						obj2=(formObj.elements[j].name).split("__");
						objNm2=obj2[0];
						objVal2=formObj.elements[j].value;
						if (objNm2 == "cntr_no_cmpr") {
							if (objVal == objVal2) {
								sameCntr="true";
								break;
							} else {
								sameCntr="false";
							}
						}
					}
				}
				if (sameCntr == "true") {
					compareCntr(obj2[1], obj[1]);
				}
			}
		}
	}	
}
function form_onChange(){
//	var formObj = document.form;
//	var srcName = window.event.srcElement.getAttribute("name");
//	var srcValue = window.event.srcElement.getAttribute("value");
//	var obj = document.getElementById(srcName);
//	if (srcName.indexOf("net_wgt") == 0) 		obj.value = makeComma(srcValue.replace(/,/g, ""));
//	if (srcName.indexOf("pck_qty") == 0) 		obj.value = ComAddComma(srcValue, "#,##0");		
	compareItem();
}
function loadCntrTpsz(cd, id) {
	cntrTpsz_cd=cd;
	cntrTpsz_id=id;
}
function createTable(seq) {
	var insTableDiv="";
	insTableDiv=insTableDiv + "<div id='table_" + seq + "'>\n";
	insTableDiv=insTableDiv + "</div>\n";
	return insTableDiv;
}

function createCntr(leftSeq, rightSeq) {
	var formObj2=document.form2;
	var tabSeq="table_" + leftSeq;
	var dyntbl1=document.getElementById(tabSeq);
	dyntbl1.innerHTML="";
	var oCell1="";
	max_rc_seq++;
	
	var colGrStr = 
		'<colgroup>\n' + 
		'	<col width="30" />' + 
		'	<col width="90" />' + 
		'	<col width="180" />' + 
		'	<col width="50" />' + 
		'	<col width="*" />' + 
		'</colgroup>\n';
	oCell1=oCell1 + "	<input type=\"hidden\" name=\"cntr_no_cmpr__" + leftSeq + "\" value=\""
	+ eval("formObj2.cntr_no__" + rightSeq).value
	+ eval("formObj2.rc_seq__" + rightSeq).value + "\">\n";
	oCell1=oCell1 + "<input type=\"hidden\" name=\"rc_seq__" + leftSeq
	+ "\" value='" + max_rc_seq + "'>\n";
	
	oCell1=oCell1 + "<table id=\"table" + leftSeq + "\">\n";
	oCell1 = oCell1 + colGrStr + "<tbody>\n";
	
	//ROW1 (S)
	oCell1=oCell1 + "	<tr>\n";
	oCell1=oCell1 + "		<td><input type=\"text\" name=\"cntr_seq__" + leftSeq
			+ "\" style=\"width:25px;\" class=\"input\" value=\"" + leftSeq + "\" readOnly></td>\n";
	oCell1=oCell1 + "		<th>CNTR No.</th>\n";
	oCell1=oCell1 + "		<td>\n";
	var cntrNoId = 'cntr_no__' + leftSeq;
	oCell1=oCell1 + "		  <select name=\"cntr_no__" + leftSeq
			+ "\"" + "id=\"cntr_no__" + leftSeq + "\" style=\"width:105px;\" class=\"input\" onChange=\"changeCntrNo(this,'" + leftSeq + "')\">\n";
	var cntrTpsz_cdArr=cntrTpsz_cd.split("|");
	var cntrTpsz_idArr=cntrTpsz_id.split("|");
	for ( var j=0; j < cntrTpsz_cdArr.length; j++) {
		if (cntrTpsz_cdArr[j] == '' && cntrTpsz_idArr[j] == '')
			continue;
		if (cntrTpsz_cdArr[j] == eval("formObj2.cntr_no__" + rightSeq).value) {
			oCell1=oCell1 + "<option value=\"" + cntrTpsz_cdArr[j] + "\" id=\""
					+ cntrTpsz_idArr[j] + "\" selected>" + cntrTpsz_cdArr[j]
					+ "</option>\n";
		} else {
			oCell1=oCell1 + "<option value=\"" + cntrTpsz_cdArr[j] + "\" id=\""
					+ cntrTpsz_idArr[j] + "\">" + cntrTpsz_cdArr[j]
					+ "</option>\n";
		}
	}
	oCell1=oCell1 + "		  </select><input type=\"text\" name=\"cntr_tpsz_cd__" + leftSeq
			+ "\" required caption=\"cntr Type Size\"" + "id=\"cntr_tpsz_cd__" + leftSeq + "\" style=\"width:40px;\" maxlength=\"2\" dataformat=\"engup\" class=\"input\" value=\""
			+ eval("formObj2.cntr_tpsz_cd__" + rightSeq).value + "\"></td>\n";
	oCell1=oCell1 + "		<th>Status</th>\n";
	oCell1=oCell1 + "		<td><input type=\"text\" name=\"status__" + leftSeq
			+ "\" style=\"width:95px;\" class=\"input2\" value=\"New\" readOnly></td>\n";
	oCell1=oCell1 + "	</tr>\n";
	//ROW1 (E)
	
	oCell1=oCell1 + "	<tr>\n";
	oCell1=oCell1 + "		<td></td>\n";
	oCell1=oCell1 + "		<th>Commodity</th>\n";
	oCell1=oCell1 + "		<td colspan=\"3\">\n<input type=\"text\" required caption=\"Commodity\" name=\"cmdt_cd__" 
			+ leftSeq + "\" style=\"width:90px;\" class=\"input\" maxlength=\"10\" dataformat=\"num\" onChange=\"javascript:changeCmdtDesc(this);\" value=\""
			+ eval("formObj2.cmdt_cd__" + rightSeq).value + "\">";
			
	oCell1 = oCell1 + "<button type=\"button\" class=\"input_seach_btn\" onclick=\"" 
					+ "javascript:comBkgCallPop0653_position('setCallBack0653', document.form.cmdt_cd__"  
					+ leftSeq + ".value, '" + leftSeq + "');" + "\"></button>";
	oCell1=oCell1 + "<input type=\"text\" name=\"cmdt_desc__" + leftSeq
			+ "\" style=\"width:190px;\" maxlength=\"4000\" dataformat=\"engup\" class=\"input\" value=\"" + eval("formObj2.cmdt_desc__" + rightSeq).value + "\">\n";
	oCell1=oCell1 + "		</td>\n";
	oCell1=oCell1 + "	</tr>\n";
	
	//ROW3 (S)
	oCell1=oCell1 + "	<tr>\n";
	oCell1=oCell1 + "		<td></td>\n";
	oCell1=oCell1 + "		<th>Temperature</th>\n";
	oCell1=oCell1 + "		<td>\n";
	var plusminus=eval("formObj2.temperature1__" + rightSeq).value;
	var cdoTemp=eval("formObj2.min_temp__" + rightSeq).value;
	var fdoTemp=eval("formObj2.min_temp__" + rightSeq).value;
	var temp11=null;
	var temp12=null;
	var temp21=null;
	var temp22=null;
	if (eval("formObj2.min_temp_ut_cd__" + rightSeq).value == "C") {
		fdoTemp=calcTemperature(plusminus + fdoTemp, "F");
		cdoTemp=cdoTemp;
		if (eval("formObj2.temperature1__" + rightSeq).value == "-") {
			temp11="selected";
			temp12="";
		} else {
			temp11="";
			temp12="selected";
		}
		if (fdoTemp.toString().substring(0, 1) == "-") {
			temp21="selected";
			temp22="";
			fdoTemp=fdoTemp.toString().substring(1, fdoTemp.length);
		} else {
			temp21="";
			temp22="selected";
		}
	} else {
		fdoTemp=fdoTemp;
		cdoTemp=calcTemperature(plusminus + cdoTemp, "C");
		if (eval("formObj2.temperature1__" + rightSeq).value == "-") {
			temp21="selected";
			temp22="";
		} else {
			temp21="";
			temp22="selected";
		}
		if (cdoTemp.toString().substring(0, 1) == "-") {
			temp11="selected";
			temp12="";
			cdoTemp=cdoTemp.toString().substring(1, cdoTemp.length);
		} else {
			temp11="";
			temp12="selected";
		}
	}
	oCell1=oCell1 + "		  <select name=\"temperature1__" + leftSeq
			+ "\"" + "id=\"temperature1__" + leftSeq
			+ "\" style=\"width:40px;\" onChange=\"javascript:changeTemperature(this,'" + leftSeq + "')\">\n";
	oCell1=oCell1 + "		    <option value=\"-\" " + temp11 + ">-</option>\n";
	oCell1=oCell1 + "		    <option value=\"+\" " + temp12 + ">+</option>\n";
	oCell1=oCell1 + "		  </select>";
	oCell1=oCell1 + "<input type=\"text\" name=\"cdo_temp__" + leftSeq
			+ "\" required caption=\"Temperature\"  dataformat=\"num\" pointcount=\"1\" maxlength=\"6\" style=\"width:40px;\" class=\"input\" value=\""
			+ cdoTemp + "\" onChange=\"javascript:changeTemperature(this,'" + leftSeq + "')\">C<label class=\"mar_rgt_4\"> </label>";
	oCell1=oCell1 + "<select name=\"temperature2__" + leftSeq
			+ "\"" + "id=\"temperature2__" + leftSeq
			+ "\" style=\"width:40px;\" onChange=\"javascript:changeTemperature(this,'"
			+ leftSeq + "')\">\n";
	oCell1=oCell1 + "		    <option value=\"-\" " + temp21 + ">-</option>\n";
	oCell1=oCell1 + "		    <option value=\"+\" " + temp22 + ">+</option>\n";
	oCell1=oCell1 + "		  </select>";
	oCell1=oCell1 + "<input type=\"text\" name=\"fdo_temp__" + leftSeq
			+ "\" required caption=\"Temperature\"  dataformat=\"num\" pointcount=\"1\" maxlength=\"6\" style=\"width:40px;\" class=\"input\" value=\""
			+ fdoTemp + "\" onChange=\"javascript:changeTemperature(this,'"
			+ leftSeq + "')\">F\n";
	oCell1=oCell1 + "		</td>\n";
	oCell1=oCell1 + "		<th>Genset</th>\n";
	oCell1=oCell1 + "		<td colspan=\"2\">\n";
	oCell1=oCell1 + "		  <select name=\"pwr_spl_cbl_flg__" + leftSeq
			+ "\"" + "id=\"pwr_spl_cbl_flg__" + leftSeq
			+ "\" style=\"width:72px;\">\n";
	var genset1=null;
	var genset2=null;
	if (eval("formObj2.pwr_spl_cbl_flg__" + rightSeq).value == "Y")
		genset1="selected";
	else
		genset1="";
	if (eval("formObj2.pwr_spl_cbl_flg__" + rightSeq).value == "N")
		genset2="selected";
	else
		genset2="";
	oCell1=oCell1 + "		    <option value=\"Y\" " + genset1 + ">Yes</option>\n";
	oCell1=oCell1 + "		    <option value=\"N\" " + genset2 + ">No</option>\n";
	oCell1=oCell1 + "		  </select>\n";
	oCell1=oCell1 + "		</td>\n";
	oCell1=oCell1 + "	</tr>\n";
	
	//ROW4 (S)
	oCell1=oCell1 + "	<tr>\n";
	oCell1=oCell1 + "		<td></td>\n";
	oCell1=oCell1 + "		<th>Ventilation</th>\n";
	oCell1=oCell1 + "		<td colspan=\"3\" class=\"stm\">\n<input type=\"text\" name=\"vent_rto__" + leftSeq
			+ "\" style=\"width:40px;\" maxlength=\"5\" dataformat=\"num\" class=\"input\" value=\""
			+ eval("formObj2.vent_rto__" + rightSeq).value
			+ "\">";
	oCell1=oCell1 + "<select name=\"cntr_vent_tp_cd__" + leftSeq
			+ "\"" + "id=\"cntr_vent_tp_cd__" + leftSeq
			+ "\" style=\"width:80px;\">\n";
	var ventCd1=null;
	var ventCd2=null;
	if (eval("formObj2.cntr_vent_tp_cd__" + rightSeq).value == "P")
		ventCd1="selected";
	else
		ventCd1="";
	if (eval("formObj2.cntr_vent_tp_cd__" + rightSeq).value == "C")
		ventCd2="selected";
	else
		ventCd2="";
	oCell1=oCell1 + "		    <option value=\"P\" " + ventCd1 + ">% Open</option>\n";
	oCell1=oCell1 + "		    <option value=\"C\" " + ventCd2 + ">CMH</option>\n";
	oCell1=oCell1 + "		  </select>\n";
	oCell1=oCell1 + "		</td>\n";	
	oCell1=oCell1 + "	</tr>\n";
	
	//ROW5 (S)
	oCell1=oCell1 + "	<tr>\n";
	oCell1=oCell1 + "		<td></td>\n";
	oCell1=oCell1 + "		<th>Nature</th>\n";
	oCell1=oCell1 + "		<td>\n";
	oCell1=oCell1 + "		  <select name=\"clng_tp_cd__" + leftSeq
			+ "\"" + "id=\"clng_tp_cd__" + leftSeq
			+ "\" style=\"width:105px;\">\n";
	var nature1=null;
	var nature2=null;
	var nature3=null;
	if (eval("formObj2.clng_tp_cd__" + rightSeq).value == "C")
		nature1="selected";
	else
		nature1="";
	if (eval("formObj2.clng_tp_cd__" + rightSeq).value == "F")
		nature2="selected";
	else
		nature2="";
	if (eval("formObj2.clng_tp_cd__" + rightSeq).value == "S")
		nature3="selected";
	else
		nature3="";
	/*if (comboNmArr && comboNmArr.length) {
		for (var ii=0; ii<comboNmArr.length; ii++) {
	       	oCell1=oCell1 + "		    <option value=\""+comboVlArr[ii]+"\" "+eval("nature"+(1+ii))+">"+comboNmArr[ii]+"</option>\n";
		}
	}
	
	oCell1=oCell1 + "		  </select>\n";
*/	
	oCell1 = oCell1 + "		    <option value=\"C\" " + nature1 + ">Chilled</option>\n";
	oCell1 = oCell1 + "		    <option value=\"F\" " + nature2 + ">Frozen</option>\n";
	oCell1 = oCell1 + "		    <option value=\"S\" " + nature3 + ">Fresh</option>\n";
	oCell1 = oCell1 + "		  </select>\n";
	
	
	oCell1=oCell1 + "		</td>\n";
	oCell1=oCell1 + "		<th>Humidity</th>\n";
	oCell1=oCell1 + "		<td width=\"50px\" class=\"stm\"><input type=\"text\" name=\"humid_no__" + leftSeq
			+ "\" style=\"width:35px;\" maxlength=\"4\" dataformat=\"num\" class=\"input\" value=\""
			+ eval("formObj2.humid_no__" + rightSeq).value + "\"><label>%</label>";
	oCell1 = oCell1 + '</td>\n';
	
	oCell1=oCell1 + "	</tr>\n";
    //ROW9 (S)
	oCell1=oCell1 + "		<tr>\n";
	oCell1=oCell1 + "			<td></td>\n";
	oCell1=oCell1 + "			<th>Remark(s)</th>\n";
	oCell1=oCell1 + "			<td colspan=\"2\">"
    	+ "							<textarea onKeyUp='allowAllCharsButEngup()' name=\"diff_rmk__"+ leftSeq + "\" id=\"diff_rmk__"+ leftSeq + "\" style=\"width:320px;height:40px;resize:none;\">" + eval("formObj2.diff_rmk__" + rightSeq).value + "</textarea></td>\n";
	oCell1=oCell1 + "			<td>\n";
	oCell1=oCell1 + 				'<button class="btn_etc" name="btn_delete" id="btn_delete" type="button" class=\"btn_etc mar_top_2\" onclick="btn_deleteTable(\'table' + leftSeq + '\', \'' + leftSeq + '\');">Delete</button></td>\n';
	oCell1=oCell1 + "			</td>\n";
	oCell1=oCell1 + "		</tr>\n";
    //ROW9 (E)
	
	oCell1=oCell1 + "</tbody>\n</table>\n";
	
	dyntbl1.innerHTML=oCell1;
}


function updateCntr(leftSeq, rightSeq) {
	var formObj=document.form;
	var formObj2=document.form2;
	if (eval("formObj.status__" + leftSeq).value == "Approved" 
		|| eval("formObj.status__" + leftSeq).value == "Rejected"
		|| eval("formObj.status__" + leftSeq).value == "Requested")
		return;
	if (eval("formObj2.cntr_no__" + rightSeq).value != null && eval("formObj2.cntr_no__" + rightSeq).value != '')
		eval("formObj.cntr_no__" + leftSeq).value=eval("formObj2.cntr_no__" + rightSeq).value;
	if (eval("formObj2.cntr_tpsz_cd__" + rightSeq).value != null && eval("formObj2.cntr_tpsz_cd__" + rightSeq).value != '')
		eval("formObj.cntr_tpsz_cd__" + leftSeq).value=eval("formObj2.cntr_tpsz_cd__" + rightSeq).value;
	if (eval("formObj2.cmdt_cd__" + rightSeq).value != null && eval("formObj2.cmdt_cd__" + rightSeq).value != '')
		eval("formObj.cmdt_cd__" + leftSeq).value=eval("formObj2.cmdt_cd__" + rightSeq).value;
	if (eval("formObj2.cmdt_desc__" + rightSeq).value != null && eval("formObj2.cmdt_desc__" + rightSeq).value != '')
		eval("formObj.cmdt_desc__" + leftSeq).value=eval("formObj2.cmdt_desc__" + rightSeq).value;
	var cdoTemp=null;
	var fdoTemp=null;
	if (eval("formObj2.min_temp__" + rightSeq).value != null && eval("formObj2.min_temp__" + rightSeq).value != '') {
		if (eval("formObj2.min_temp_ut_cd__" + rightSeq).value == "C") { 
			cdoTemp=eval("formObj2.temperature1__" + rightSeq).value + eval("formObj2.min_temp__" + rightSeq).value;
			fdoTemp=calcTemperature( eval("formObj2.temperature1__" + rightSeq).value + eval("formObj2.min_temp__" + rightSeq).value, "F");
			if (cdoTemp.substring(0, 1) == "-") {
				eval("formObj.temperature1__" + rightSeq).selectedIndex=0;
				eval("formObj.cdo_temp__" + leftSeq).value=eval("formObj2.min_temp__" + rightSeq).value;
			} else
				eval("formObj.temperature1__" + rightSeq).selectedIndex=1;
			if (fdoTemp.toString().substring(0, 1) == "-") {
				eval("formObj.temperature2__" + rightSeq).selectedIndex=0;
				eval("formObj.fdo_temp__" + leftSeq).value =calcTemperature( val("formObj2.temperature1__" + rightSeq).value + eval("formObj2.min_temp__" + rightSeq).value, "F");
			} else
				eval("formObj.temperature2__" + rightSeq).selectedIndex=1;
		} else {
			cdoTemp=calcTemperature( eval("formObj2.min_temp__" + rightSeq).value, "C");
			
			if (cdoTemp.toString().substring(0, 1) == "-") {
				cdoTemp = cdoTemp.toString().substring(1, cdoTemp.length)
			}
			
			eval("formObj.cdo_temp__" + leftSeq).value=cdoTemp;
				
			eval("formObj.fdo_temp__" + leftSeq).value=eval("formObj2.min_temp__" + rightSeq).value;
		}
	}
	if (eval("formObj2.min_temp_ut_cd__" + rightSeq).value != null && eval("formObj2.min_temp_ut_cd__" + rightSeq).value != '') {
		for ( var j=0; j < eval("formObj.temperature2__" + leftSeq).length; j++) {
			if (eval("formObj.temperature2__" + leftSeq)[j].value == eval("formObj2.min_temp_ut_cd__" + rightSeq).value) {
				eval("formObj.temperature2__" + leftSeq).selectedIndex=j;
				break;
			}
		}
	}
	if (eval("formObj2.pwr_spl_cbl_flg__" + rightSeq).value != null && eval("formObj2.pwr_spl_cbl_flg__" + rightSeq).value != '') {
		for ( var k=0; k < eval("formObj.pwr_spl_cbl_flg__" + leftSeq).length; k++) {
			if (eval("formObj.pwr_spl_cbl_flg__" + leftSeq)[k].value == eval("formObj2.pwr_spl_cbl_flg__" + rightSeq).value) {
				eval("formObj.pwr_spl_cbl_flg__" + leftSeq).selectedIndex=k;
				break;
			}
			if("Y"==eval("formObj2.pwr_spl_cbl_flg__" + rightSeq).value){
				eval("formObj.pwr_spl_cbl_flg__" + leftSeq).selectedIndex=0;
			} else {
				eval("formObj.pwr_spl_cbl_flg__" + leftSeq).selectedIndex=1;				
			}
		}
	}
	if (eval("formObj2.vent_rto__" + rightSeq).value != null && eval("formObj2.vent_rto__" + rightSeq).value != '')
		eval("formObj.vent_rto__" + leftSeq).value=eval("formObj2.vent_rto__" + rightSeq).value;
	if (eval("formObj2.cntr_vent_tp_cd__" + rightSeq).value != null && eval("formObj2.cntr_vent_tp_cd__" + rightSeq).value != '') {
		for ( var k=0; k < eval("formObj.cntr_vent_tp_cd__" + leftSeq).length; k++) {
			if (eval("formObj.cntr_vent_tp_cd__" + leftSeq)[k].value == eval("formObj2.cntr_vent_tp_cd__" + rightSeq).value) {
				eval("formObj.cntr_vent_tp_cd__" + leftSeq).selectedIndex=k;
				break;
			}
			if("Y"==eval("formObj2.cntr_vent_tp_cd__" + rightSeq).value){
				eval("formObj.cntr_vent_tp_cd__" + leftSeq).selectedIndex=0;
			} else {
				eval("formObj.cntr_vent_tp_cd__" + leftSeq).selectedIndex=1;				
			}
		}
	}

	if (eval("formObj2.clng_tp_cd__" + rightSeq).value != null && eval("formObj2.clng_tp_cd__" + rightSeq).value != '')
		eval("formObj.clng_tp_cd__" + leftSeq).value = eval("formObj2.clng_tp_cd__" + rightSeq).value;
	if (eval("formObj2.humid_no__" + rightSeq).value != null && eval("formObj2.humid_no__" + rightSeq).value != '')
		eval("formObj.humid_no__" + leftSeq).value=eval("formObj2.humid_no__" + rightSeq).value;
	if (eval("formObj2.diff_rmk__" + rightSeq).value != null && eval("formObj2.diff_rmk__" + rightSeq).value != '')
		eval("formObj.diff_rmk__" + leftSeq).value=eval("formObj2.diff_rmk__" + rightSeq).value;
}
function setCntrDiffCheckColor(bkgValue, eBkgValue, eBkgItemNm){
	var formObj=document.form;
	var formObj2=document.form2;
	var tmp=eval(eBkgItemNm);
	if (bkgValue != eBkgValue) {
		tmp.style.color="blue"
	} else {
		tmp.style.color="#606060";
	}	
}
function compareCntr(leftSeq, rightSeq) {
	var formObj=document.form;
	var formObj2=document.form2;
	var clngtpcdv = "";
	setCntrDiffCheckColor(eval("formObj.cntr_no__" 			+ leftSeq).value, eval("formObj2.cntr_no__" 		+ rightSeq).value, ("formObj2.cntr_no__" 			+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.cntr_tpsz_cd__" 	+ leftSeq).value, eval("formObj2.cntr_tpsz_cd__" 	+ rightSeq).value, ("formObj2.cntr_tpsz_cd__" 		+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.cmdt_cd__" 			+ leftSeq).value, eval("formObj2.cmdt_cd__" 		+ rightSeq).value, ("formObj2.cmdt_cd__" 			+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.cmdt_desc__" 		+ leftSeq).value, eval("formObj2.cmdt_desc__" 		+ rightSeq).value, ("formObj2.cmdt_desc__" 			+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.temperature1__" 	+ leftSeq).value, eval("formObj2.temperature1__" 	+ rightSeq).value, ("formObj2.temperature1__" 		+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.cdo_temp__" 		+ leftSeq).value, eval("formObj2.min_temp__" 		+ rightSeq).value, ("formObj2.min_temp__" 			+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.pwr_spl_cbl_flg__" 	+ leftSeq).value, eval("formObj2.pwr_spl_cbl_flg__" + rightSeq).value, ("formObj2.pwr_spl_cbl_flg__" 	+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.vent_rto__" 		+ leftSeq).value, eval("formObj2.vent_rto__" 		+ rightSeq).value, ("formObj2.vent_rto__" 			+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.cntr_vent_tp_cd__" 	+ leftSeq).value, eval("formObj2.cntr_vent_tp_cd__" + rightSeq).value, ("formObj2.cntr_vent_tp_cd__" 	+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.diff_rmk__" 		+ leftSeq).value, eval("formObj2.diff_rmk__" 		+ rightSeq).value, ("formObj2.diff_rmk__" 			+ rightSeq));
	//var clngTpCd = $(eval("formObj.clng_tp_cd__" + leftSeq)).is('select') ? eval("formObj.clng_tp_cd__" 		+ leftSeq).value : eval("clng_tp_cd__" 		+ leftSeq).GetSelectCode();
	
	if ("Chilled"==eval("formObj2.clng_tp_cd__"+ rightSeq).value){
		clngtpcdv = "C";
	} else if ("Frozen"==eval("formObj2.clng_tp_cd__"+ rightSeq).value){
		clngtpcdv = "F";
	} else if ("Fresh"==eval("formObj2.clng_tp_cd__"+ rightSeq).value){
		clngtpcdv = "S";
	}
	
	setCntrDiffCheckColor(clngtpcdv,  eval("formObj2.clng_tp_cd__" 		+ rightSeq).value, ("formObj2.clng_tp_cd__" 		+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.humid_no__" 		+ leftSeq).value, eval("formObj2.humid_no__" 		+ rightSeq).value, ("formObj2.humid_no__" 			+ rightSeq));
}
function deleteAllTable() {
	var formObj=document.form;
	for ( var i=0; i < formObj.elements.length; i++) {
		if ((formObj.elements[i].name).indexOf("table") == 0) {
			btn_deleteTable(formObj.elements[i].value);
		}
	}
}
function btn_deleteTable(tableId) {
	var formObj=document.form;
	var seq=1;
	var tbody=document.getElementById(tableId).getElementsByTagName("TBODY")[0];
	var rowCount = tbody.rows.length;
	while (rowCount > 0) {
		tbody.deleteRow(rowCount - 1);
		rowCount--;
	}
	for ( var i=0; i < formObj.elements.length; i++) {
		var objNm=(formObj.elements[i].name).split("__");
		if (objNm[0] == "cntr_seq") {
			formObj.elements[i].value=seq++;
		}
	}
}
function btn_delete(tableId, seq) {
	var formObj=document.form;
	doSaveCopy();
	for (var i=1; i<sheetObjects[0].RowCount()+1; i++) {
		if (sheetObjects[0].GetCellValue(i, "rc_seq") == eval("formObj.rc_seq__" + seq).value) {
			sheetObjects[0].SetRowStatus(i,"D");
			break;
		}
	}
	btn_deleteTable(tableId);
}
function calcTemperature(val, dir) {
	var ret=0;
	if (val.indexOf("+") != -1)
		val=val.substring(1, val.length);
	if (dir == "C") {
		ret=roundXL(((5 * parseFloat(val)) - 160) / 9, 1);
	} else {
		ret=roundXL((9 / 5) * parseFloat(val) + 32, 1);
	}
	return ret;
}
function changeTemperature(obj, seq) {
	var formObj=document.form;
	var temp1=eval("formObj.temperature1__" + seq);
	var temp2=eval("formObj.temperature2__" + seq);
	var cdoV=eval("formObj.cdo_temp__" + seq);
	var fdoV=eval("formObj.fdo_temp__" + seq);
	if (temp1.value.indexOf("-") == -1)
		temp1.value="";
	else
		temp1.value="-";
	if (temp2.value.indexOf("-") == -1)
		temp2.value="";
	else
		temp2.value="-";
	if (obj.name == "temperature1__" + seq || obj.name == "cdo_temp__" + seq) {
		if(cdoV.value != ''){
			var fdoTemp = calcTemperature(temp1.value + cdoV.value, "F");
			fdoV.value = fdoTemp;
			cdoV.value = temp1.value + cdoV.value;
		}else{
			cdoV.value = '';
		}
	} else {
		if(fdoV.value != ''){
			var cdoTemp = calcTemperature(temp2.value + fdoV.value, "C");
			cdoV.value = cdoTemp;
			fdoV.value = temp2.value + fdoV.value;
		}else{
			fdoV.value = '';
		}
	}
	if (cdoV.value.indexOf("-") != -1) {
		temp1.selectedIndex=0;
		cdoV.value=cdoV.value.substring(1, cdoV.value.length);
	} else {
		temp1.selectedIndex=1;
	}
	if (fdoV.value.indexOf("-") != -1) {
		temp2.selectedIndex=0;
		fdoV.value=fdoV.value.substring(1, fdoV.value.length);
	} else {
		temp2.selectedIndex=1;
	}
//	obj.value = makeComma(obj.value);
}
function makeComma(srcValue) {
	var arrVal=srcValue.split(".");
	if (arrVal.length > 1) {
		srcValue=arrVal[0] + "." + ComRpad(arrVal[1], 3, "0");
	} else {
		srcValue=arrVal[0] + ".0";
	}
	return srcValue;
}
function roundXL(n, digits) {
	if (digits >= 0)
		return parseFloat(n.toFixed(digits));
	digits=Math.pow(10, digits);
	var t=Math.round(n * digits) / digits;
	return parseFloat(t.toFixed(0));
}
function changeCmdtDesc(obj) {
	var formObj=document.form;
	formObj.cmdt_cd.value=obj.value;
	formObj.f_cmd.value=SEARCH01;
	var sXml=sheetObjects[0].GetSearchData("ESM_BKG_0229_07GS.do", FormQueryString(formObj));
	var cmdtDesc=ComGetEtcData(sXml, "cmdt_desc");
	var objSeq=(obj.name).split("__");
	if (cmdtDesc == "") {
		var cmdtCdObj=eval("formObj.cmdt_cd__" + objSeq[1]);
		var cmdtDescObj=eval("formObj.cmdt_desc__" + objSeq[1]);
		cmdtCdObj.value="";
		cmdtDescObj.value="";
	} else {
		var cmdtDescObj=eval("formObj.cmdt_desc__" + objSeq[1]);
		cmdtDescObj.value=cmdtDesc;
	}
}
function changeCntrNo(obj, seq) {
	if (seq != null) {
		var obj_id=obj.options[obj.selectedIndex].id;
		eval("document.form.cntr_tpsz_cd__" + seq).value=obj_id;
	}
}
function comBkgCallPop0653_position(funcNm, val, pos) {
	cmdtPosition=pos;
	comBkgCallPop0653(funcNm, val, '');
}
function setCallBack0653(aryPopupData) {
	var formObj=document.form;
	eval("formObj.cmdt_cd__" + cmdtPosition).value=aryPopupData[0][3];
	eval("formObj.cmdt_desc__" + cmdtPosition).value=aryPopupData[0][4];
}
