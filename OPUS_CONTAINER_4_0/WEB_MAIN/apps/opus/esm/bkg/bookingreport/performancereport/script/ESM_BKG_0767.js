/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0767.js
*@FileTitle  : Booking Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/28
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class esm_bkg_0767 : business script for esm_bkg_0767
 */
var sheetObjects=new Array();
var sheetCnt=0;
var searchXml="";
var beforeIdx=0;
var newItemIdx=0;
var comboCnt=0;
var comboObjects=new Array();
// Event handler processing by button click event  */
document.onclick=processButtonClick;
/**
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
function setComboObject(combo_obj) {
	comboObjects[comboCnt++]=combo_obj;
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen
 */
function loadPage() {
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		sheetObjects[i].isible=false;
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	for ( var k=0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], comboObjects[k].id);
	}
	addSetting(true);
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	initControl();
}
/**
    * setting combo initial values and header
    * param : comboObj, comboId
    * adding case as numbers of counting combo
    */
function initCombo(comboObj, comboId) {
	var formObject=document.form
	initComboEditable(comboObj, comboId)
}
//inital setting of combo
function initComboEditable(combo, comboId) {
	with (combo) {
		if(combo.options.id == "dlv_ctnt_cd" ){
			//alert(comboId);
			SetMultiSelect(0);
			SetUseAutoComplete(1);
			SetUseEdit(0);
		} else {
			SetMultiSelect(1);
			SetUseEdit(0);
		}
	}
}
/**
 * handling search conditions input
 */
/*function obj_KeyUp() {
	var formObject=document.form;
	var srcName=ComGetEvent("name");
	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
	var srcValue=window.event.srcElement.getAttribute("value");
	if (srcName == "ca_issue_off" || srcName == "bkg_off" || srcName == "del_off") {
		return;
	} else {
		if (ComChkLen(srcValue, srcMaxLength) == "2") {
			ComSetNextFocus();
		}
	}
}*/
/**
 * registering initial event 
 */
function initControl() {
	var formObject=document.form;
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', formObject); // - focus out
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', formObject); // - focus in
	// axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); //- key input
	//axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject);
	// axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
}
/**
 * setting sheet initial values and header param : sheetObj, sheetNo adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch (sheetID) {
		case "sheet1": //sheet1 init
		    with(sheetObj){
	      if (location.hostname != "")
	      var HeadTitle="";

	      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

	      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
	      InitHeaders(headers, info);

	      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	             {Type:"Text",      Hidden:1, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"rpt_id",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rpt_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bkg_rpt_knd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bzc_cond_sql_ctnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bzc_ord_ctnt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"temp_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	       
	      InitColumns(cols);
	      SetVisible(false);
	      SetEditable(1);
	            }


			break;
	}
}
// Event handler processing by button name */
function processButtonClick() {
	var sheetObject1=sheetObjects[0];
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
			case "btn_add":
				formObject.dlv_ctnt_cd.Code = "";
				addTemplate(formObject);
				break;
			case "btn_delete":
				formObject.rpt_nm.disabled=false;
				formObject.dlv_ctnt_cd.Code = "";
				deleteTemplate(formObject);
				break;
			case "btn_save":
				doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
				break;
			case "btn_new":
				formObject.rpt_nm.disabled=false;
				formObject.dlv_ctnt_cd.Code = "";
				addSetting(true);
				formObject.reset();
				break;
			case "btn_close":
				ComClosePopup(); 
				break;
			case "btn_corr_sdate":
				var cal=new ComCalendar();
				cal.select(formObject.corr_from_dt, 'yyyy-MM-dd');
				break;
			case "btn_corr_edate":
				var cal=new ComCalendar();
				cal.select(formObject.corr_to_dt, 'yyyy-MM-dd');
				break;
			case "btn_cre_sdate":
				var cal=new ComCalendar();
				cal.select(formObject.cre_from_dt, 'yyyy-MM-dd');
				break;
			case "btn_cre_edate":
				var cal=new ComCalendar();
				cal.select(formObject.cre_to_dt, 'yyyy-MM-dd');
				break;
			 case "btn_cakind":
				 ComOpenPopup("ESM_BKG_0758_POP.do?pgmNo=ESM_BKG_0758", 600, 410, "", '1,0', true);
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
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
		case IBSEARCH: 						
			formObj.f_cmd.value=SEARCH;
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			var sXml=sheetObj.GetSearchData("ESM_BKG_0767GS.do", FormQueryString(formObj));
			var arrXml=sXml.split("|$$|");
			searchXml=arrXml[0];
			ComXml2ComboItem(arrXml[1], dlv_ctnt_cd, "val", "name");
			sheetObj.LoadSearchData(searchXml,{Sync:1} );
			var listSize=ComGetEtcData(searchXml, "listSize");
			if (listSize > 0) {
				for ( var i=0; i < listSize; i++) {
					formObj.rpt_nm.options[i]=new Option(ComGetEtcData(searchXml, "rptNm_" + i), ComGetEtcData(searchXml,
							"rptId_" + i));
				}
				//setCondition(sheetObj.CellValue(1, 4), "",formObj);
				if (sheetObj.GetCellValue(1, 6) != -1 && sheetObj.GetCellValue(1, 6) != '' && sheetObj.GetCellValue(1, 6) != undefined) {
					formObj.rpt_nm[sheetObj.GetCellValue(1, 6)].selected=true;
					setCondition(ComGetEtcData(searchXml, "seq_" + sheetObj.GetCellValue(1, 6)), ComGetEtcData(searchXml, "ord_"
							+ sheetObj.GetCellValue(1, 6)), formObj);
				} else {
					formObj.rpt_nm[0].selected=true;
					setCondition(ComGetEtcData(searchXml, "seq_0"), ComGetEtcData(searchXml, "ord_0"), formObj);
				}
			}
			break;
		case IBSAVE: 
			if (!validateForm(sheetObj, formObj, sAction))
				return;

			if (formObj.add_value.value == "") {
				if (formObj.rpt_nm.length > 0) {
					var idx=formObj.rpt_nm.selectedIndex;
					var rpt_id=formObj.rpt_nm.options[idx].value;
					for ( var i=1; i < sheetObj.LastRow()+ 1; i++) {
						if (sheetObj.GetCellValue(i, 1) == rpt_id) {
							sheetObj.SetCellValue(i, 4,makeOption(formObj),0);
							break;
						}
					}
				}
			} else {
				if (!validateForm(sheetObj, formObj, ADD))
					return;

				var addNm=formObj.add_value.value;
				formObj.add_value.value="";
				var itemIdx=0;
				sheetObj.DataInsert(-1);
				sheetObj.SetCellValue(sheetObj.LastRow(), 0,"I",0);
				sheetObj.SetCellValue(sheetObj.LastRow(), 1,"new|" + itemIdx,0);
				sheetObj.SetCellValue(sheetObj.LastRow(), 2,addNm,0);
				sheetObj.SetCellValue(sheetObj.LastRow(), 3,"C",0);
				sheetObj.SetCellValue(sheetObj.LastRow(), 4,makeOption(formObj),0);
				beforeIdx=0;
			}
			formObj.f_cmd.value=MULTI;
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam("");
			sheetObj.DoSave("ESM_BKG_0767GS.do", sParam);
			break;
	}
	ComOpenWait(false);
}
/**
 * template add
 */
function addTemplate(formObj) {
	addSetting(false);
	formObj.reset();
	var itemIdx=newItemIdx++;
	var idx=formObj.rpt_nm.length;
	formObj.rpt_nm.options[idx]=new Option(" ", "new|" + itemIdx);
	formObj.rpt_nm[idx].selected=true;
	formObj.rpt_nm.disabled=true;
	formObj.add_value.focus();
}
/*
function addTemplate(formObject){
    var sheetObj=sheetObjects[0];
    if (formObject.rpt_nm.length > 0){
 	    var before_rpt_id=formObject.rpt_nm.options[beforeIdx].value;
 	    if(!validateForm(sheetObj,formObject,0)){
 	    	formObject.rpt_nm.selectedIndex=beforeIdx;    	    	    	    	
    			return;
    	    }
 	    for (var i=1 ; i < sheetObj.LastRow()+1 ; i++){
if (sheetObj.GetCellValue(i,1) == before_rpt_id){
        		sheetObj.SetCellValue(i, 4,makeOption(formObject),0);
if (sheetObj.GetCellValue(i, 0) != "I"){
     				sheetObj.SetCellValue(i, 0,"U",0);
     			}else{
     				sheetObj.SetCellValue(i, 0,"I",0);
     			}    
        		break;
     		}
     	}
    }
	if (formObject.add_value.value == '') {
		ComShowCodeMessage("BKG08028");// Please input Add
		formObject.add_value.focus();
		return;
	}
	var itemIdx=newItemIdx++;
	var sheetObj=sheetObjects[0];
    sheetObj.DataInsert(-1);
    sheetObj.SetCellValue(sheetObj.LastRow(), 0,"I",0);
	sheetObj.SetCellValue(sheetObj.LastRow(), 1,"new|" + itemIdx,0);
	sheetObj.SetCellValue(sheetObj.LastRow(), 2,formObject.add_value.value,0);
	sheetObj.SetCellValue(sheetObj.LastRow(), 3,"C",0);
	sheetObj.SetCellValue(sheetObj.LastRow(), 4,"",0);
	beforeIdx=sheetObj.LastRow()-1;
	var idx=formObject.rpt_nm.length;
		formObject.rpt_nm.options[idx]=new Option(formObject.add_value.value,"new|" + itemIdx);
    formObject.reset();
    formObject.rpt_nm[idx].selected=true;	            
	formObject.add_value.value="";
}
 */
/**
 * template delete
 */
function deleteTemplate(formObj) {
	var sheetObj=sheetObjects[0];
	if (formObj.rpt_nm.length == 0) {
		ComShowCodeMessage("BKG00751");
		return;
	}
	var maxIdx=formObj.rpt_nm.length;
	var idx=formObj.rpt_nm.selectedIndex;
	var rpt_id=formObj.rpt_nm.options[idx].value;
	/*
	 * if (maxIdx == 0){
	 * 
	 * ComShowCodeMessage("BKG08029");//Please Input Period formObject.add_value.focus();
	 * 
	 * return; }
	 */
	if (!ComShowCodeConfirm("BKG00535")) {//Are you sure to delete?
		return;
	}
	var temp=rpt_id.split("|");
	for ( var i=1; i < sheetObj.LastRow()+ 1; i++) {
		if (temp.length > 1) {
			if (sheetObj.GetCellValue(i, 1) == rpt_id) {
				sheetObj.RowDelete(i, false);
				break;
			}
		} else {
			if (sheetObj.GetCellValue(i, 1) == rpt_id) {
				sheetObj.SetCellValue(i, 0,"D",0);
				break;
			}
		}
	}
	formObj.rpt_nm.remove(idx);
	if (formObj.rpt_nm.length > 0) {
		beforeIdx=formObj.rpt_nm.selectedIndex;
		var new_rpt_id=formObj.rpt_nm.options[beforeIdx].value;
		for ( var i=1; i < sheetObj.LastRow()+ 1; i++) {
			if (sheetObj.GetCellValue(i, 1) == new_rpt_id) {
				setCondition(sheetObj.GetCellValue(i, 4), "", formObj);
			}
		}
	} else {
		beforeIdx=0;
		formObj.reset();
	}
}
function setTemplate(reValue) {
	var formObject=document.form
	var idx=formObject.rpt_nm.length;
	var tempValue=reValue.split("|");
	for ( var i=0; i < tempValue.length; i++) {
		var tempValue2=tempValue[i].split(">");
		if (tempValue[i] != '') {
			formObject.rpt_nm.options[idx]=new Option(tempValue2[1], "new");
			idx++;
		}
	}
}
/**
 * change template name
 */
function changeNm() {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	var before_rpt_id=formObj.rpt_nm.options[beforeIdx].value;
	var idx=formObj.rpt_nm.selectedIndex;
	var now_rpt_id=formObj.rpt_nm.options[idx].value;
	if (!validateForm(sheetObj, formObj, 0)) {
		formObj.rpt_nm.selectedIndex=beforeIdx;
		return;
	}
	if (now_rpt_id.indexOf("new|") == -1) {
		addSetting(true);
	} else {
		addSetting(false);
	}
	for ( var i=1; i < sheetObj.LastRow()+ 1; i++) {
		if (sheetObj.GetCellValue(i, 1) == before_rpt_id) {
			sheetObj.SetCellValue(i, 4,makeOption(formObj),0);
			if (sheetObj.GetCellValue(i, 0) != "I") {
				sheetObj.SetCellValue(i, 0,"U",0);
			} else {
				sheetObj.SetCellValue(i, 0,"I",0);
			}
			break;
		}
	}
	for ( var i=1; i < sheetObj.LastRow()+ 1; i++) {
		if (sheetObj.GetCellValue(i, 1) == now_rpt_id) {
			setCondition(sheetObj.GetCellValue(i, 4), "", formObj);
			break;
		}
	}
	beforeIdx=idx;
}
/**
 * Make Option
 */
function makeOption(formObj) {
	var seq_ctnt=new Array();
	for ( var i=0; i < formObj.length; i++) {
		if (formObj[i].name == "dlv_ctnt_cd") {
			seq_ctnt[i]=formObj[i].name + "=" + formObj[i].Code;
		} else {
			if (formObj[i].type == "checkbox") {
				if (formObj[i].checked == true) {
					seq_ctnt[i]=formObj[i].name + "=" + "Y";
				} else {
					seq_ctnt[i]=formObj[i].name + "=" + "N";
				}
			} else {
				/*
				if (formObj[i].name == "add_value"){
					seq_ctnt[i]=formObj[i].name + "=";
				}else{
					seq_ctnt[i]=formObj[i].name + "=" + formObj[i].value;
				}
				 */
				seq_ctnt[i]=formObj[i].name + "=" + formObj[i].value;
			}
		}
	}
	return seq_ctnt.join("|");
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObject, sAction) {
	if (formObject.rpt_nm.length > 0 && sheetObj.LastRow()> 1) {
		if (!ComChkValid(formObject))
			return false;
		if (formObject.rpt_nm.length < 1) {
			ComShowCodeMessage("BKG08030");// Please Input Template Name
			formObject.add_value.focus();
			return false;
		}
		/*
		if (formObject.corr_from_dt.value == ''){
			ComShowCodeMessage("BKG08029");// Please Input Period
			formObject.corr_from_dt.focus();
			return false;
		}
		if (formObject.corr_to_dt.value == ''){
			ComShowCodeMessage("BKG08029");// Please Input Period
			formObject.corr_to_dt.focus();
			return false;
		}
		 */
		if (formObject.vvd.value != '') {
			if (formObject.vvd.value.length < 9) {
				ComShowCodeMessage("BKG00780");// T.VVD is 9 Digits
				formObject.vvd.focus();
				return false;
			}
		}
		if (formObject.ca_issue_off.value != '') {
			if (formObject.ca_issue_off.value.length < 5) {
				ComShowCodeMessage("BKG08031");// C/A Issue Office is 5 Digits
				formObject.ca_issue_off.focus();
				return false;
			}
		}
	}
	if (sAction == ADD) {
		if (!ComChkValid(formObject))
			return false;
		/*
		 * if (formObject.corr_from_dt.value == ''){
		 * 
		 * ComShowCodeMessage("BKG08029");//Please Input Period formObject.corr_from_dt.focus(); return false; }
		 * 
		 * if (formObject.corr_to_dt.value == ''){
		 * 
		 * ComShowCodeMessage("BKG08029");//Please Input Period formObject.corr_to_dt.focus(); return false; }
		 */
		if (formObject.vvd.value != '') {
			if (formObject.vvd.value.length < 9) {
				ComShowCodeMessage("BKG00780");// T.VVD is 9 Digits
				formObject.vvd.focus();
				return false;
			}
		}
		if (formObject.ca_issue_off.value != '') {
			if (formObject.ca_issue_off.value.length < 5) {
				ComShowCodeMessage("BKG08031");// C/A Issue Office is 5 Digits
				formObject.ca_issue_off.focus();
				return false;
			}
		}
	}
	return true;
}
/**
 * setting form name and input value
 */
function checkFormType(sheetObj, formObj, seq_ctnt, ord_ctnt) {
	ord_ctnt="";
	for ( var i=0; i < formObj.length; i++) {
		if (formObj[i].type == "checkbox") {
			if (formObj[i].checked == true) {
				seq_ctnt[i]=formObj[i].name + "=" + "Y";
			} else {
				seq_ctnt[i]=formObj[i].name + "=" + "N";
			}
		} else {
			seq_ctnt[i]=formObj[i].name + "=" + formObj[i].value;
		}
	}
	//alert(seq_ctnt.join("|"));
}
/**
 * condition setting
 */
function setCondition(seqValue, ordValue, formObj) {
	var seq_ctnt=new Array();
	var ord_ctnt=new Array();
	seq_ctnt=seqValue.split("|");
	// ord_ctnt = ordValue.split("|");
	for ( var i=0; i < formObj.length; i++) {
		for ( var j=0; j < seq_ctnt.length; j++) {
			var tempSeq=seq_ctnt[j].split("=");
			if (formObj[i].name == tempSeq[0]) {
				if (formObj[i].name == "dlv_ctnt_cd") {
//					formObj[i].SetSelectCode(tempSeq[1]);
					formObj[i].Code = tempSeq[1];
				} else {
					if (formObj[i].type == "checkbox") {
						if (tempSeq[1] == "Y") {
							formObj[i].checked=true;
						} else {
							formObj[i].checked=false;
						}
					} else {
						if (formObj[i].name != "rpt_nm") {
							if (tempSeq[1] != undefined) {
								formObj[i].value=tempSeq[1];
							} else {
								formObj[i].value="";
							}
						}
					}
				}
				break;
			}
		}
	}
}
/**
 * background setting
 */
function addSetting(type) {
	var formObj=document.form;
	if (type) {
		formObj.add_value.readOnly=true;
		formObj.add_value.style.background="#E8EFF9";
	} else {
		formObj.add_value.readOnly=false;
		formObj.add_value.style.background="#FFFFFF";
	}
}
/**
 * Save End Event
 */
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	var formObj=document.form;
	if (ErrMsg>=0) {
		sheetObj = sheetObj.Reset();
		sheetObjects[0] = sheetObj;
		ComClearCombo(formObj.rpt_nm);
		ComResetAll();
		addSetting(true);
		formObj.rpt_nm.disabled=false;
		doActionIBSheet(sheetObj, formObj, IBSEARCH);
		parent.reSearch();
	}
}
