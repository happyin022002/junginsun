﻿﻿/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ESM_BKG_0229_09.jsp
 *@FileTitle : e-Booking & SI Process Detail(AWKWARD)
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/17
==================================================================*/
/****************************************************************************************
 Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
 [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
 character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/* developer's work*/
// global variable
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var iterator="|$$|";
var isCopy="false";
var akPosition=0;
var cntrTpsz_cd="";
var cntrTpsz_id="";
var wgt_cd="";
var wgt_nm="";
var prefix="t9sheet1_";
var max_awk_cgo_seq=0;
var table_prefix = "table_";
var div_prefix = "div_";
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	/***** using extra sheet valuable if there are more 2 sheets *****/
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
			parent.document.form.awkwardTabCancel.value="Y";
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
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
	initControl();
}
function initControl() {
	var formObject=document.form;
	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject);
	axon_event.addListenerForm("change", "form_onChange", formObject);
	ComFormControlAxon();
	applyShortcut();
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
			var HeadTitle1="ibflag|bkg_no|awk_cgo_seq|cntr_no|cntr_tpsz_cd|cmdt_cd|ttl_dim_len|ttl_dim_wdt|ttl_dim_hgt|grs_wgt|wgt_ut_cd|pck_qty|pck_tp_cd|net_wgt|stwg_rqst_desc|max_awk_cgo_seq";
			var headCount=ComCountHeadTitle(HeadTitle1);
	
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);
	
			var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			             {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no" },
			             {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"awk_cgo_seq" },
			             {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no" },
			             {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd" },
			             {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_cd" },
			             {Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ttl_dim_len",      KeyField:0,   CalcLogic:"",   Format:"NullFloat" },
			             {Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ttl_dim_wdt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat" },
			             {Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ttl_dim_hgt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat" },
			             {Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"grs_wgt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat" },
			             {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"wgt_ut_cd" },
			             {Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pck_qty",          KeyField:0,   CalcLogic:"",   Format:"NullFloat" },
			             {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pck_tp_cd" },
			             {Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"net_wgt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat" },
			             {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"stwg_rqst_desc" },
			             {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"max_awk_cgo_seq" } ];
			 
			InitColumns(cols);
			SetVisible(false);
			SetEditable(1);
		}
		break;
	}
}
// handling of Sheet 
function doActionIBSheet(sheetObj, formObj, sAction) {
//	sheetObj.ShowDebugMsg = 1;
	switch (sAction) {
	case IBCLEAR: 
		if (formObj.bkg_no2.value != null && formObj.bkg_no2.value != '') {
			var formObj2=document.form2;
			for ( var i=0; i < formObj.elements.length; i++) {
				if (formObj.elements[i].name.indexOf("ttl_dim_len") == 0)
					formObj.elements[i].value=ComAddComma(formObj.elements[i].value, "#,###");
				if (formObj.elements[i].name.indexOf("ttl_dim_wdt") == 0)
					formObj.elements[i].value=ComAddComma(formObj.elements[i].value, "#,###");
				if (formObj.elements[i].name.indexOf("ttl_dim_hgt") == 0)
					formObj.elements[i].value=ComAddComma(formObj.elements[i].value, "#,###");
				if (formObj.elements[i].name.indexOf("grs_wgt") == 0)
					formObj.elements[i].value=makeComma(formObj.elements[i].value.replace(/,/g, ""));
				if (formObj.elements[i].name.indexOf("net_wgt") == 0)
					formObj.elements[i].value=makeComma(formObj.elements[i].value.replace(/,/g, ""));
				if (formObj.elements[i].name.indexOf("pck_qty") == 0)
					formObj.elements[i].value=ComAddComma(formObj.elements[i].value, "#,###");
			}
			for ( var j=0; j < formObj2.elements.length; j++) {
				if (formObj2.elements[j].name.indexOf("ttl_dim_len") == 0)
					formObj2.elements[j].value=ComAddComma(formObj2.elements[j].value, "#,###");
				if (formObj2.elements[j].name.indexOf("ttl_dim_wdt") == 0)
					formObj2.elements[j].value=ComAddComma(formObj2.elements[j].value, "#,###");
				if (formObj2.elements[j].name.indexOf("ttl_dim_hgt") == 0)
					formObj2.elements[j].value=ComAddComma(formObj2.elements[j].value, "#,###");
				if (formObj2.elements[j].name.indexOf("grs_wgt") == 0)
					formObj2.elements[j].value=makeComma(formObj2.elements[j].value.replace(/,/g, ""));
				if (formObj2.elements[j].name.indexOf("net_wgt") == 0)
					formObj2.elements[j].value=makeComma(formObj2.elements[j].value.replace(/,/g, ""));
				if (formObj2.elements[j].name.indexOf("pck_qty") == 0)
					formObj2.elements[j].value=ComAddComma(formObj2.elements[j].value, "#,###");;
			}
			var sXml=formObj.sXml.value;
			var arrXml=sXml.split("|$$|");
			for ( var i=0; i < arrXml.length; i++) {
				//sheetObjects[i].RenderSheet(0);
				if (i > 0) {
					sheetObjects[i].SetWaitImageVisible(0);
				}
				sheetObjects[i].LoadSearchData(arrXml[i],{Sync:1} );
				//sheetObjects[i].RenderSheet(1);
			}
		}
		for(var i=1;i<sheetObjects[0].LastRow();i++){
			if(max_awk_cgo_seq<parseInt(sheetObjects[0].GetCellValue(i, "awk_cgo_seq"))){
				max_awk_cgo_seq=parseInt(sheetObjects[0].GetCellValue(i, "awk_cgo_seq"));
			}
		}
		if(parent.document.form.awkwardTabCancel.value=="Y"){
			//ComBtnColor("btn_cancelcopydata", "blue");
			//ComBtnColor("btn_datacopytoopus", "#737373");
			
			document.getElementById("btn_cancelcopydata").style.cssText = "color:blue !important;font-weight:bold;";
			document.getElementById("btn_datacopytoopus").style.cssText = "color:#737373 !important;font-weight:normal;";
			
			parent.document.form.awkwardTabCancel.value="N";
		}
		if(top.document.form.tabload9.value == "COPY"){
			dataCopy();
		} else {
			compareItem();			
		}
		if(parent.frames["t1frame"].document.form.doc_tp_cd.value == "S"){
			ComBtnDisable("btn_datacopytoopus");
		}
		top.document.form.tabload9.value="LOAD";
		
		if(parent.subPageSearchEnd != undefined) parent.subPageSearchEnd('ESM_BKG_0229_09');
		
		break;
	case IBSEARCH: 
		formObj.f_cmd.value=SEARCH;
//		formObj.method="post";
//		formObj.target="_self";
//		formObj.action="/opuscntr/ESM_BKG_0229_09.do";
//		formObj.submit();
//no support[check again]CLT 		parent.tabObjects[0].TabBackColor(8)="#96c792";
		parent.frames['t9frame'].location.reload();
		break;
	case IBSEARCH_ASYNC02: //Data Copy
		// creating DHTML table
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
		// comparing container
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
				if ((formObj2.elements[i].name).indexOf("__") > 0) {
					obj=(formObj2.elements[i].name).split("__");
					objNm=obj[0];
					objVal=formObj2.elements[i].value;
					if (objNm == "awk_cgo_seq") {
						for ( var j=0; j < formObj.elements.length; j++) {
							if ((formObj.elements[j].name).indexOf("__") > 0) {
								obj2=(formObj.elements[j].name).split("__");
								objNm2=obj2[0];
								objVal2=formObj.elements[j].value;
								if (objNm2 == "awk_cgo_seq") {
									if (ComTrim(objVal) == ComTrim(objVal2)) {
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
				if ((formObj2.elements[i].name).indexOf("__") > 0) {
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
//no support[check again]CLT 		parent.tabObjects[0].TabBackColor(8)="#fff270";
		isCopy="true";
		compareItem();
		initControl();
		break;
	//UPLOAD
	case IBSAVE:
		if (validateForUpload() == false) return;
		var params=getSaveStringForUpload();
 		var sXml=sheetObj.GetSaveData("ESM_BKG_0229_09GS.do", params);
		if(ComBkgErrMessage(sheetObjects[0], sXml)) {
 			sheetObj.LoadSaveData(sXml);
			// retrieving 
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
 * calling when button of all upload is clicked
 *  name of function is same, regardless tab
 * implementing 
 * after failing to Validate, if Focusing is needed, 
 * after moving Focus,  return false
 */
function validateForUpload() {
	return validateForm(sheetObjects[0], document.form, IBSAVE);
}
/**
 * calling when button of all upload is clicked
 *  name of function is same, regardless tab
 * implementing 
 *  when Upload button is clicked, return QueryString
 */
function getSaveStringForUpload() {
	//  copy form data to sheet
	doSaveCopy();
	var params="";	
	if (sheetObjects[0].RowCount()>=1) {
		params="f_cmd=" + MULTI + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true), prefix);
	}
//	al"ert("getSaveStringForUpload in ESM_BKG_0229_09.js params=[" + params + "]");
	return (params);
}
 /**
  *calling when [OK] button is clicked from pop up( e-Booking Upload Copy )
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
	// [Data Copy to OPUS]  New 
	for (var i=sheetObj.RowCount(); i<maxSeq; i++) {
		sheetObj.DataInsert(-1);
	}
	var obj=null;
	var objNm=null;
	var objSeq=null;
	var objVal=null;
	var cntrNo=null;
	var ibflag=null;
	//input Opus data to sheet
	for(var i=0; i<formObj.elements.length; i++) {
		if ((formObj.elements[i].name).indexOf("__") > 0) {
			obj=(formObj.elements[i].name).split("__");
			objNm=obj[0];
			objSeq=obj[1]; // row at sheet 
			objVal=formObj.elements[i].value;
			if (sheetObjects[0].GetCellValue(objSeq,"bkg_no") == "") {
				sheetObjects[0].SetCellValue(objSeq,"bkg_no",formObj.bkg_no.value,0);
			}
			if ( objNm == "awk_cgo_seq" )	sheetObjects[0].SetCellValue(objSeq, "awk_cgo_seq",objVal,0);
			if ( objNm == "cntr_no" )		sheetObjects[0].SetCellValue(objSeq, "cntr_no",ComTrimAll(objVal),0);
			if ( objNm == "cntr_tpsz_cd" )	sheetObjects[0].SetCellValue(objSeq, "cntr_tpsz_cd",objVal,0);
			if ( objNm == "cmdt_cd" )   	sheetObjects[0].SetCellValue(objSeq, "cmdt_cd",objVal,0);
			if ( objNm == "ttl_dim_len" )	sheetObjects[0].SetCellValue(objSeq, "ttl_dim_len",objVal,0);
			if ( objNm == "ttl_dim_wdt" )	sheetObjects[0].SetCellValue(objSeq, "ttl_dim_wdt",objVal,0);
			if ( objNm == "ttl_dim_hgt" )	sheetObjects[0].SetCellValue(objSeq, "ttl_dim_hgt",objVal,0);
			if ( objNm == "grs_wgt" ) 		sheetObjects[0].SetCellValue(objSeq, "grs_wgt",objVal,0);
			if ( objNm == "wgt_ut_cd" ) 	sheetObjects[0].SetCellValue(objSeq, "wgt_ut_cd",objVal,0);
			if ( objNm == "pck_qty" ) 		sheetObjects[0].SetCellValue(objSeq, "pck_qty",objVal,0);
			if ( objNm == "pck_tp_cd" ) 	sheetObjects[0].SetCellValue(objSeq, "pck_tp_cd",objVal,0);
			if ( objNm == "net_wgt" ) 		sheetObjects[0].SetCellValue(objSeq, "net_wgt",objVal,0);
			if ( objNm == "stwg_rqst_desc" )sheetObjects[0].SetCellValue(objSeq, "stwg_rqst_desc",objVal,0);
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
	if(leftSeq==0||rightSeq==0) return;
	var formObj=document.form;
	var formObj2=document.form2;
	setCntrDiffCheckColor(eval("formObj.cntr_tpsz_cd__" 	+ leftSeq).value, eval("formObj2.cntr_tpsz_cd__" 	+ rightSeq).value, ("formObj2.cntr_tpsz_cd__" 	+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.cmdt_cd__" 			+ leftSeq).value, eval("formObj2.cmdt_cd__" 		+ rightSeq).value, ("formObj2.cmdt_cd__" 		+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.ttl_dim_len__"		+ leftSeq).value, eval("formObj2.ttl_dim_len__" 	+ rightSeq).value, ("formObj2.ttl_dim_len__" 	+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.ttl_dim_wdt__" 		+ leftSeq).value, eval("formObj2.ttl_dim_wdt__" 	+ rightSeq).value, ("formObj2.ttl_dim_wdt__" 	+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.ttl_dim_hgt__" 		+ leftSeq).value, eval("formObj2.ttl_dim_hgt__" 	+ rightSeq).value, ("formObj2.ttl_dim_hgt__" 	+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.grs_wgt__" 			+ leftSeq).value, eval("formObj2.grs_wgt__" 		+ rightSeq).value, ("formObj2.grs_wgt__" 		+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.wgt_ut_cd__" 		+ leftSeq).value, eval("formObj2.wgt_ut_cd1__" 		+ rightSeq).value, ("formObj2.wgt_ut_cd1__" 	+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.pck_qty__"			+ leftSeq).value, eval("formObj2.pck_qty__" 		+ rightSeq).value, ("formObj2.pck_qty__" 		+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.pck_tp_cd__" 		+ leftSeq).value, eval("formObj2.pck_tp_cd__" 		+ rightSeq).value, ("formObj2.pck_tp_cd__" 		+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.net_wgt__" 			+ leftSeq).value, eval("formObj2.net_wgt__" 		+ rightSeq).value, ("formObj2.net_wgt__" 		+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.wgt_ut_cd2__" 		+ leftSeq).value, eval("formObj2.wgt_ut_cd2__" 		+ rightSeq).value, ("formObj2.wgt_ut_cd2__" 	+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.stwg_rqst_desc__" 	+ leftSeq).value, eval("formObj2.stwg_rqst_desc__" 	+ rightSeq).value, ("formObj2.stwg_rqst_desc__" + rightSeq));
//	var tmp = null;
//	tmp = eval("formObj2.cntr_tpsz_cd__" + rightSeq);
//	if (eval("formObj.cntr_tpsz_cd__" + leftSeq).value != eval("formObj2.cntr_tpsz_cd__"+ rightSeq).value) {
//		tmp.style.color = "blue";
//	} else {
//		tmp.style.color = "#606060";
//	}
//	tmp = eval("formObj2.cmdt_cd__" + rightSeq);
//	if (eval("formObj.cmdt_cd__" + leftSeq).value != eval("formObj2.cmdt_cd__"+ rightSeq).value) {
//		tmp.style.color = "blue";
//	} else {
//		tmp.style.color = "#606060";
//	}
//	tmp = eval("formObj2.ttl_dim_len__" + rightSeq);
//	if (eval("formObj.ttl_dim_len__" + leftSeq).value != eval("formObj2.ttl_dim_len__"+ rightSeq).value) {
//		tmp.style.color = "blue";
//	} else {
//		tmp.style.color = "#606060";
//	}
//	tmp = eval("formObj2.ttl_dim_wdt__" + rightSeq);
//	if (eval("formObj.ttl_dim_wdt__" + leftSeq).value != eval("formObj2.ttl_dim_wdt__"+ rightSeq).value) {
//		tmp.style.color = "blue";
//	} else {
//		tmp.style.color = "#606060";
//	}
//	tmp = eval("formObj2.ttl_dim_hgt__" + rightSeq);
//	if (eval("formObj.ttl_dim_hgt__" + leftSeq).value != eval("formObj2.ttl_dim_hgt__"+ rightSeq).value) {
//		tmp.style.color = "blue";
//	} else {
//		tmp.style.color = "#606060";
//	}
//	tmp = eval("formObj2.grs_wgt__" + rightSeq);
//	if (eval("formObj.grs_wgt__" + leftSeq).value != eval("formObj2.grs_wgt__"+ rightSeq).value) {
//		tmp.style.color = "blue";
//	} else {
//		tmp.style.color = "#606060";
//	}
//	tmp = eval("formObj2.wgt_ut_cd1__" + rightSeq);
//	if (eval("formObj.wgt_ut_cd__" + leftSeq).value != eval("formObj2.wgt_ut_cd1__"+ rightSeq).value) {
//		tmp.style.color = "blue";
//	} else {
//		tmp.style.color = "#606060";
//	}
//	tmp = eval("formObj2.pck_qty__" + rightSeq);
//	if (eval("formObj.pck_qty__" + leftSeq).value != eval("formObj2.pck_qty__"+ rightSeq).value) {
//		tmp.style.color = "blue";
//	} else {
//		tmp.style.color = "#606060";
//	}
//	tmp = eval("formObj2.pck_tp_cd__" + rightSeq);
//	if (eval("formObj.pck_tp_cd__" + leftSeq).value != eval("formObj2.pck_tp_cd__"+ rightSeq).value) {
//		tmp.style.color = "blue";
//	} else {
//		tmp.style.color = "#606060";
//	}
//	tmp = eval("formObj2.net_wgt__" + rightSeq);
//	if (eval("formObj.net_wgt__" + leftSeq).value != eval("formObj2.net_wgt__"+ rightSeq).value) {
//		tmp.style.color = "blue";
//	} else {
//		tmp.style.color = "#606060";
//	}
//	tmp = eval("formObj2.wgt_ut_cd2__" + rightSeq);
//	if (eval("formObj.wgt_ut_cd2__" + leftSeq).value != eval("formObj2.wgt_ut_cd2__"+ rightSeq).value) {
//		tmp.style.color = "blue";
//	} else {
//		tmp.style.color = "#606060";
//	}
//	tmp = eval("formObj2.stwg_rqst_desc__" + rightSeq);
//	if (eval("formObj.stwg_rqst_desc__" + leftSeq).value != eval("formObj2.stwg_rqst_desc__"+ rightSeq).value) {
//		tmp.style.color = "blue";
//	} else {
//		tmp.style.color = "#606060";
//	}
}
// checking digit
function form_onChange(){
	var formObj=document.form;
	var srcName=ComGetEvent("name");
	var srcValue=window.event.srcElement.getAttribute("value");
	var obj=document.getElementById(srcName);
	if (srcName.indexOf("ttl_dim_len") == 0) 	obj.value=ComAddComma(eval("formObj." + srcName + ".value"), "#,###");
	if (srcName.indexOf("ttl_dim_wdt") == 0) 	obj.value=ComAddComma(eval("formObj." + srcName + ".value"), "#,###");
	if (srcName.indexOf("ttl_dim_hgt") == 0) 	obj.value=ComAddComma(eval("formObj." + srcName + ".value"), "#,###");
	if (srcName.indexOf("grs_wgt") == 0) 		obj.value=makeComma(eval("formObj." + srcName + ".value").replace(/,/g, ""));
	if (srcName.indexOf("net_wgt") == 0) 		obj.value=makeComma(eval("formObj." + srcName + ".value").replace(/,/g, ""));
	if (srcName.indexOf("pck_qty") == 0) 		obj.value=ComAddComma(eval("formObj." + srcName + ".value"), "#,##0");
	if (srcName.indexOf("cmdt_cd") == 0){
		if(!ComIsNull(srcValue)){
			//obj.value=ComLpad(srcValue,6,"0");
			//validatePrecaution(formObj,srcName,ComLpad(srcValue,6,"0"));
		}else{
			ComSetObjValue(eval("formObj.cmdt_desc__"+srcName.substr(srcName.length-1,1)),"");
		}
 	}
	compareItem();
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
	var wgt_cdArr=wgt_cd.split("|");
	var wgt_nmArr=wgt_nm.split("|");
	max_awk_cgo_seq++;
	var colGrStr = 
		'<colgroup>\n' + 
		'	<col width="30" />' + 
		'	<col width="90" />' + 
		'	<col width="180" />' + 
		'	<col width="50" />' + 
		'	<col width="*" />' + 
		'</colgroup>\n';
	oCell1=oCell1 + "<input type=\"hidden\" name=\"awk_cgo_seq__" + leftSeq + "\" value='" + max_awk_cgo_seq + "'>\n";
	oCell1=oCell1 + "<table id=\"table" + leftSeq + "\" class=\"search\" border=\"0\">\n";
	oCell1 = oCell1 + colGrStr + "<tbody>\n";
	
	// row1 (S)
	oCell1=oCell1 + "	<tr>\n";
	oCell1=oCell1 + "		<td><input type=\"text\" name=\"cntr_seq__" + leftSeq + "\" style=\"width:25px;text-align:center;\" class=\"input\" value=\"" + leftSeq + "\" readOnly></td>\n";
	oCell1=oCell1 + "		<th>CNTR No.</th>\n";
	oCell1=oCell1 + "		<td>\n";
	oCell1=oCell1 + "		  <select name=\"cntr_no__" + leftSeq + "\" style=\"width:105px;\" class=\"input\" onChange=\"changeCntrNo(this,'" + leftSeq + "')\">\n";
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
	oCell1=oCell1 + "		  </select><input type=\"text\" required caption=\"Cntr Type Size\" name=\"cntr_tpsz_cd__" + leftSeq
			+ "\" style=\"width:35px;\" maxlength=\"4\" dataformat=\"engup\" class=\"input\" value=\""
			+ eval("formObj2.cntr_tpsz_cd__" + rightSeq).value + "\"></td>\n";
	oCell1=oCell1 + "		<th>Status</th>\n";
	oCell1=oCell1 + "		<td><input type=\"text\" name=\"status__" + leftSeq
			+ "\" style=\"width:80px;color:blue\" class=\"input2\" value=\"New\" readOnly></td>\n";
	oCell1=oCell1 + "	</tr>\n";
	
	// row2 (S)
	oCell1=oCell1 + "	<tr>\n";
	oCell1=oCell1 + "		<td></td>\n";
	oCell1=oCell1 + "		<th>Commodity</th>\n";
	oCell1=oCell1 + "		<td colspan=\"4\"><input type=\"text\" caption=\"Commodity\" name=\"cmdt_cd__" + leftSeq
			+ "\" style=\"width:90px;\" maxlength=\"8\" dataformat=\"num\" onChange=\"javascript:changeCmdtDesc(this);\"  class=\"input\" value=\"" + eval("formObj2.cmdt_cd__" + rightSeq).value + "\">"
			+"<button type=\"button\" class=\"input_seach_btn\" onclick=\"javascript:comBkgCallPop0653_position('setCallBack0653', document.form.cmdt_cd__" + leftSeq + ".value, '" + leftSeq + "');\"></button>";
	oCell1=oCell1 + "<input type=\"text\" name=\"cmdt_desc__" + leftSeq + "\" style=\"width:190px;\" maxlength=\"4000\" dataformat=\"engup\" class=\"input2\" value=\"" + eval("formObj2.cmdt_desc__" + rightSeq).value + "\" readonly=\"readonly\"></td>\n";
	oCell1=oCell1 + "	</tr>\n";
	
	// row3 (S)
	oCell1=oCell1 + "	<tr>\n";
	oCell1=oCell1 + "		<td></td>\n";
	oCell1=oCell1 + "		<th>Length</th>\n";
	oCell1=oCell1 + "		<td><input type=\"text\" name=\"ttl_dim_len__" + leftSeq + "\" style=\"width:80px;text-align:right\" maxlength=\"7\" dataformat=\"int\"  class=\"input\" value=\""
			+ eval("formObj2.ttl_dim_len__" + rightSeq).value+ "\"> CM</td>\n";
	oCell1=oCell1 + "		<th>Width</th>\n";
	oCell1=oCell1 + "		<td><input type=\"text\" name=\"ttl_dim_wdt__" + leftSeq + "\" style=\"width:110px;text-align:right\" maxlength=\"7\" dataformat=\"int\" class=\"input\" value=\""
			+ eval("formObj2.ttl_dim_wdt__" + rightSeq).value	+ "\">&nbsp;CM</td>\n";
	oCell1=oCell1 + "	</tr>\n";
	
	// row4 (S)
	oCell1=oCell1 + "	<tr>\n";
	oCell1=oCell1 + "		<td></td>\n";
	oCell1=oCell1 + "		<th>Height</th>\n";
	oCell1=oCell1 + "		<td><input type=\"text\" name=\"ttl_dim_hgt__" + leftSeq
			+ "\" style=\"width:80px;text-align:right\" maxlength=\"7\" dataformat=\"int\" class=\"input\" value=\""
			+ eval("formObj2.ttl_dim_hgt__" + rightSeq).value + "\">&nbsp;CM</td>\n";
	oCell1=oCell1 + "		<th>Package</th>\n";
	oCell1=oCell1 + "		<td><input type=\"text\" name=\"pck_qty__" + leftSeq
			+ "\" style=\"width:65px;text-align:right\" maxlength=\"12\" dataformat=\"int\" class=\"input\" value=\""+ eval("formObj2.pck_qty__" + rightSeq).value
			+ "\"><input type=\"text\" dataformat=\"enguponly\" maxlength=\"2\" required caption=\"Package Type Code\" name=\"pck_tp_cd__" + leftSeq
			+ "\" style=\"width:35px;\" class=\"input\" value=\""+ eval("formObj2.pck_tp_cd__" + rightSeq).value
			+ "\"><button type=\"button\" class=\"input_seach_btn\" onclick=\"javascript:comBkgCallPop0696_position('setCallBack0696', document.form.pck_tp_cd__" + leftSeq	+ ".value, '" + leftSeq	+ "');\"></button></td>\n";
	oCell1=oCell1 + "	</tr>\n";
	
	// row5 (S)
	oCell1=oCell1 + "	<tr>\n";
	oCell1=oCell1 + "		<td></td>\n";
	oCell1=oCell1 + "		<th>Gross WGT</th>\n";
	oCell1=oCell1 + "		<td><input type=\"text\" name=\"grs_wgt__" + leftSeq + "\" style=\"width:90px;text-align:right\" maxlength=\"12\" dataformat=\"float\" pointcount=\"3\" class=\"input\" value=\""
			+ eval("formObj2.grs_wgt__" + rightSeq).value + "\">";
	oCell1=oCell1 + "<select name=\"wgt_ut_cd__" + leftSeq	+ "\" style=\"width:55px;\" class=\"input\">\n";
	for ( var i=0; i < wgt_cdArr.length; i++) {
		if (wgt_cdArr[i] == '' && wgt_nmArr[i] == '')
			continue;
		if (wgt_cdArr[i] == eval("formObj2.wgt_ut_cd1__" + rightSeq).value) {
			oCell1=oCell1 + "<option value=\"" + wgt_cdArr[i] + "\" selected>"
					+ wgt_nmArr[i] + "</option>\n";
		} else {
			oCell1=oCell1 + "<option value=\"" + wgt_cdArr[i] + "\">" + wgt_nmArr[i]
					+ "</option>\n";
		}
	}
	oCell1=oCell1 + "		</td>\n";
	oCell1=oCell1 + "		<th>Net WGT</th>\n";
	oCell1=oCell1 + "		<td colspan=\"3\"><input type=\"text\" name=\"net_wgt__" + leftSeq + "\" style=\"width:90px;text-align:right\" maxlength=\"12\" dataformat=\"float\" pointcount=\"3\" class=\"input\" value=\""
			+ eval("formObj2.net_wgt__" + rightSeq).value + "\">";
	oCell1=oCell1 + "<select name=\"wgt_ut_cd2__" + leftSeq	+ "\" style=\"width:55px;\" class=\"input\">\n";
	for ( var j=0; j < wgt_cdArr.length; j++) {
		if (wgt_cdArr[j] == '' && wgt_nmArr[j] == '')
			continue;
		if (wgt_cdArr[j] == eval("formObj2.wgt_ut_cd2__" + rightSeq).value) {
			oCell1=oCell1 + "<option value=\"" + wgt_cdArr[j] + "\" selected>"
					+ wgt_nmArr[j] + "</option>\n";
		} else {
			oCell1=oCell1 + "<option value=\"" + wgt_cdArr[j] + "\">" + wgt_nmArr[j]
					+ "</option>\n";
		}
	}
	oCell1=oCell1 + "		</td>\n";
	oCell1=oCell1 + "	</tr>\n";
	
	// row6 (S)
	oCell1=oCell1 + "	<tr>\n";
	oCell1=oCell1 + "		<td></td>\n";
	oCell1=oCell1 + "		<th>Remark(s)</th>\n";
	oCell1=oCell1 + "		<td colspan=\"2\"><textarea onKeyUp='allowAllCharsButEngup()' name=\"stwg_rqst_desc__" + leftSeq
			+ "\" style=\"width:98%;height:40px;resize:none\">"
			+ eval("formObj2.stwg_rqst_desc__" + rightSeq).value
			+ "</textarea></td>\n";
	oCell1=oCell1 + "		<td>\n";
	oCell1=oCell1 + "			<button  onclick=\"javascript:btn_delete('table"+leftSeq+"','"+leftSeq+"');\" type=\"button\" class=\"btn_etc\" name=\"btn_delete" + leftSeq+"\" id=\"btn_delete" + leftSeq+"\">Delete</button>";
	oCell1=oCell1 + "		</td>\n";
	oCell1=oCell1 + "	</tr>\n";
	oCell1=oCell1 + "	</tbody>\n";
	oCell1=oCell1 + "</table>\n";
	dyntbl1.innerHTML=oCell1;
}

function updateCntr(leftSeq, rightSeq) {
	var formObj=document.form;
	var formObj2=document.form2;
	
	if (eval("formObj.status__" + leftSeq).value == "Approved" 
		|| eval("formObj.status__" + leftSeq).value == "Rejected"
		|| eval("formObj.status__" + leftSeq).value == "Requested")
		return;
	
	if (eval("formObj2.cntr_tpsz_cd__" + rightSeq).value != null && eval("formObj2.cntr_tpsz_cd__" + rightSeq).value != '')
		eval("formObj.cntr_tpsz_cd__" + leftSeq).value=eval("formObj2.cntr_tpsz_cd__" + rightSeq).value;
	if (eval("formObj2.cmdt_cd__" + rightSeq).value != null && eval("formObj2.cmdt_cd__" + rightSeq).value != '')
		eval("formObj.cmdt_cd__" + leftSeq).value=eval("formObj2.cmdt_cd__" + rightSeq).value;
	if (eval("formObj2.cmdt_desc__" + rightSeq).value != null && eval("formObj2.cmdt_desc__" + rightSeq).value != '')
		eval("formObj.cmdt_desc__" + leftSeq).value=eval("formObj2.cmdt_desc__" + rightSeq).value;
	if (eval("formObj2.ttl_dim_len__" + rightSeq).value != null && eval("formObj2.ttl_dim_len__" + rightSeq).value != '')
		eval("formObj.ttl_dim_len__" + leftSeq).value=eval("formObj2.ttl_dim_len__" + rightSeq).value;
	if (eval("formObj2.ttl_dim_wdt__" + rightSeq).value != null && eval("formObj2.ttl_dim_wdt__" + rightSeq).value != '')
		eval("formObj.ttl_dim_wdt__" + leftSeq).value=eval("formObj2.ttl_dim_wdt__" + rightSeq).value;
	if (eval("formObj2.ttl_dim_hgt__" + rightSeq).value != null && eval("formObj2.ttl_dim_hgt__" + rightSeq).value != '')
		eval("formObj.ttl_dim_hgt__" + leftSeq).value=eval("formObj2.ttl_dim_hgt__" + rightSeq).value;
	if (eval("formObj2.grs_wgt__" + rightSeq).value != null && eval("formObj2.grs_wgt__" + rightSeq).value != '')
		eval("formObj.grs_wgt__" + leftSeq).value=eval("formObj2.grs_wgt__" + rightSeq).value;
	
	if (eval("formObj2.pck_qty__" + rightSeq).value != null && eval("formObj2.pck_qty__" + rightSeq).value != '')
		eval("formObj.pck_qty__" + leftSeq).value=eval("formObj2.pck_qty__" + rightSeq).value;
	
	if (eval("formObj2.net_wgt__" + rightSeq).value != null && eval("formObj2.net_wgt__" + rightSeq).value != '')
		eval("formObj.net_wgt__" + leftSeq).value=eval("formObj2.net_wgt__" + rightSeq).value;
	
	if (eval("formObj2.stwg_rqst_desc__" + rightSeq).value != null && eval("formObj2.stwg_rqst_desc__" + rightSeq).value != '')
		eval("formObj.stwg_rqst_desc__" + leftSeq).value=eval("formObj2.stwg_rqst_desc__" + rightSeq).value;
	
	if (eval("formObj2.wgt_ut_cd1__" + rightSeq).value != null && eval("formObj2.wgt_ut_cd1__" + rightSeq).value != '') {
		for ( var i=0; i < eval("formObj.wgt_ut_cd__" + leftSeq).length; i++) {
			if (eval("formObj.wgt_ut_cd__" + leftSeq)[i].value == eval("formObj2.wgt_ut_cd1__" + rightSeq).value) {
				eval("formObj.wgt_ut_cd__" + leftSeq).selectedIndex=i;
				break;
			}
		}
	}
	if (eval("formObj2.wgt_ut_cd2__" + rightSeq).value != null
			&& eval("formObj2.wgt_ut_cd2__" + rightSeq).value != '') {
		for ( var j=0; j < eval("formObj.wgt_ut_cd2__" + leftSeq).length; j++) {
			if (eval("formObj.wgt_ut_cd2__" + leftSeq)[j].value == eval("formObj2.wgt_ut_cd2__" + rightSeq).value) {
				eval("formObj.wgt_ut_cd2__" + leftSeq).selectedIndex=j;
				break;
			}
		}
	}
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
if (sheetObjects[0].GetCellValue(i, "awk_cgo_seq") == eval("formObj.awk_cgo_seq__" + seq).value) {
			sheetObjects[0].SetRowStatus(i,"D");
			break;
		}
	}
	btn_deleteTable(tableId);
}
function changeCntrNo(obj, seq) {
	if (seq != null) {
		var obj_id=obj.options[obj.selectedIndex].id;
		eval("document.form.cntr_tpsz_cd__" + seq).value=obj_id;
	}
}
function loadComboData(cd, nm) {
 	wgt_cd=cd;
 	wgt_nm=nm;
}
function loadCntrTpsz(cd, id) {
	cntrTpsz_cd=cd;
	cntrTpsz_id=id;
}
function makeComma2(obj) {
	var val=makeComma(obj.value);
	obj.value=val;
}
function makeComma(srcValue) {
	var arrVal=srcValue.split(".");
	if (arrVal.length > 1) {
		srcValue=makeCommaRun(arrVal[0]) + "." + ComRpad(arrVal[1], 3, "0");
	} else {
		srcValue=makeCommaRun(arrVal[0]) + ".000";
	}
	return srcValue;
}
function makeCommaRun(srcValue) {
	srcValue=srcValue.replace(/\D/g, "");
	if (srcValue.length > 9) {
		srcValue=srcValue.substring(0, 9);
	}
	l=srcValue.length - 3;
	while (l > 0) {
		srcValue=srcValue.substr(0, l) + "," + srcValue.substr(l);
		l -= 3;
	}
	return srcValue;
}
function comBkgCallPop0696_position(funcNm, val, pos) {
	pkgPosition=pos;
	comBkgCallPop0696(funcNm, val);
}
function setCallBack0696(aryPopupData) {
	var formObj=document.form;
	eval("formObj.pck_tp_cd__" + pkgPosition).value=aryPopupData.cd;
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
/**
 *  searching precaution information when cmdt_cd is inputted
 */       
function validatePrecaution(formObj,srcName,srcValue){
	formObj.f_cmd.value=SEARCHLIST11;
 	var sXml=sheetObjects[0].GetSearchData("ESM_BKG_0079_01GS.do", "f_cmd="+SEARCHLIST11 + "&cmdt_cd="+srcValue);
	if (sXml != "") {
		ComSetObjValue(eval("formObj.cmdt_desc__"+srcName.substr(srcName.length-1,1)),ComGetEtcData(sXml,"cmdt_nm"));
	}
} 

/**
 * Allow All Char but Eng to Upper
 */
 function allowAllCharsButEngup() {
 	event.target.value = event.target.value.toUpperCase();
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
//function doCntrSaveCopy() {
//var formObj = document.form;
//var obj = null;
//var objNm = null;
//var objSeq = null;
//var objVal = null;
//var cntrNo = null;
//var ibflag = null;
//
//for ( var i = 0; i < formObj.elements.length; i++) {
//	if ((formObj.elements[i].name).indexOf("__") > 0) {
//		obj = (formObj.elements[i].name).split("__");
//		objNm = obj[0];
//		objSeq = obj[1];
//		objVal = formObj.elements[i].value;
//		if (objNm == "ibflag") {
//			ibflag = objVal;
//			if (sheetObjects[0].GetCellValue(objSeq, "ibflag") != "D") {
//				sheetObjects[0].GetCellValue(objSeq, "ibflag", objVal);
//			}
//		}
//		sheetObjects[0].SetCellValue(objSeq, "bkg_no", formObj.bkg_no.value);
//
//		if (objNm == "awk_cgo_seq")
//			sheetObjects[0].SetCellValue(objSeq, "awk_cgo_seq", objVal);
//		if (objNm == "cntr_no")
//			sheetObjects[0].SetCellValue(objSeq, "cntr_no", objVal);
//		if (objNm == "cntr_tpsz_cd")
//			sheetObjects[0].SetCellValue(objSeq, "cntr_tpsz_cd", objVal);
//		if (objNm == "cmdt_cd")
//			sheetObjects[0].SetCellValue(objSeq, "cmdt_cd", objVal);
//		if (objNm == "ttl_dim_len")
//			sheetObjects[0].SetCellValue(objSeq, "ttl_dim_len", (objVal).replaceStr(","));
//		if (objNm == "ttl_dim_wdt")
//			sheetObjects[0].SetCellValue(objSeq, "ttl_dim_wdt", (objVal).replaceStr(","));
//		if (objNm == "ttl_dim_hgt")
//			sheetObjects[0].SetCellValue(objSeq, "ttl_dim_hgt", (objVal).replaceStr(","));
//		if (objNm == "grs_wgt")
//			sheetObjects[0].SetCellValue(objSeq, "grs_wgt", (objVal).replaceStr(","));
//		if (objNm == "wgt_ut_cd")
//			sheetObjects[0].SetCellValue(objSeq, "wgt_ut_cd", objVal);
//		if (objNm == "pck_qty")
//			sheetObjects[0].SetCellValue(objSeq, "pck_qty", (objVal).replaceStr(","));
//		if (objNm == "pck_tp_cd")
//			sheetObjects[0].SetCellValue(objSeq, "pck_tp_cd", objVal));
//		if (objNm == "net_wgt")
//			sheetObjects[0].SetCellValue(objSeq, "net_wgt", (objVal).replaceStr(","));
//		if (objNm == "wgt_ut_cd2")
//			sheetObjects[0].SetCellValue(objSeq, "wgt_ut_cd2", objVal);
//		if (objNm == "stwg_rqst_desc")
//			sheetObjects[0].SetCellValue(objSeq, "stwg_rqst_desc", objVal);
//	}
//}
//}
