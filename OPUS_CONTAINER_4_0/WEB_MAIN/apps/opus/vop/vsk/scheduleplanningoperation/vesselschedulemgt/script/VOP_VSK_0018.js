/*=========================================================
 *Copyright(c) 2006 CyberLogitec
*@FileName : VOP_VSK_0018.js
*@FileTitle : VSL SKD Delete & Holding
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/15
=========================================================*/
/****************************************************************************************
 Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
 Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class VOP_VSK_0018 : business script for VOP_VSK_0018
 */


function VOP_VSK_0018() {
	this.processButtonClick=tprocessButtonClick;
	this.setSheetObject=setSheetObject;
	this.loadPage=loadPage;
	this.initSheet=initSheet;
	this.initControl=initControl;
	this.doActionIBSheet=doActionIBSheet;
	this.setTabObject=setTabObject;
	this.validateForm=validateForm;
}
// public variable
var sheetObjects=new Array();
var sheetCnt=0;
var existEmptyPf=false;
var saveRows=new Array();
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */ 
function processButtonClick() {
	var sheetObject1=sheetObjects[0];
	/** **************************************************** */
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		if (!ComIsBtnEnable(srcName)) return;  
		switch (srcName) {
		case "btn_Retrieve":
			existEmptyPf=false;
			saveRows=new Array();
			//			sheetObject1.ShowButtonImage = 0;
			doActionIBSheet(sheetObject1, formObj, IBSEARCH);
			break;
		case "btn_Delete":
			if(checkSelection(sheetObject1)){
				if(ComShowConfirm(ComGetMsg("VSK00088"))){
					doActionIBSheet(sheetObject1, formObj, IBDELETE);
				}
			}else{
				ComShowCodeMessage('VSK00010');
			}
			break;
		case "btn_Save":
			if(saveRows.length>0){
				if(ComShowConfirm(ComGetMsg("COM130504"))){
					doActionIBSheet(sheetObject1, formObj, IBSAVE);
				//	doActionIBSheet(sheetObject1, formObj, IBSEARCH);
				}
			}else{
				ComShowCodeMessage('VSK00012');
			}
			
			doActionIBSheet(sheetObject1, formObj, IBSEARCH);
			
//			if(true){
//				if(ComShowConfirm(ComGetMsg("COM130504"))){
//					doActionIBSheet(sheetObject1, formObj, IBSAVE);
//					doActionIBSheet(sheetObject1, formObj, IBSEARCH);
//				}
//			}else{
//				ComShowCodeMessage('VSK00012');
//			}			
			break;
			
		case "btn_SkdHolding":
			if(checkSelection(sheetObject1)){
				var status=checkStatus(sheetObject1);
				if(status=="ACT"){
					if(ComShowConfirm(ComGetMsg("VSK00087"))){
						var result=doActionIBSheet(sheetObject1, formObj, MULTI01);
						if(result){
							changeStatus(sheetObject1);
							doActionIBSheet(sheetObject1, formObj, IBSEARCH);
						}
					}
				}else if(status=="BKG"){
					ComShowCodeMessage("VSK00042", "Booking states");
				}else{
					ComShowCodeMessage("VSK00015");
				}
			}else{
				ComShowCodeMessage('VSK00010');
			}
			break;
			
		case "btn_SkdOpen":
			if(checkSelection(sheetObject1)){
				if(checkStatus(sheetObject1)=="CLO"){
					if(ComShowConfirm(ComGetMsg("VSK00014"))){
						var result=doActionIBSheet(sheetObject1, formObj, MULTI01);
						if(result){
							changeStatus(sheetObject1);
						}
					}
				}else{
					ComShowCodeMessage("VSK00016");
				}
				doActionIBSheet(sheetObject1, formObj, IBSEARCH);	//::FOR.NYK.by TOP:2014-11-1-:://
			}else{
				ComShowCodeMessage('VSK00010');
			}
			break;
			
		case "btn_SkdActivate":
			if(ComShowConfirm(ComGetMsg("VSK00014"))){
				var result=doActionIBSheet(sheetObject1, formObj, MULTI03);
				if(result){
					doActionIBSheet(sheetObj, formObj, IBSEARCH);	
				}
			}
			break;
			
		case "btn_BookingList":
			openBookingList(sheetObject1);
			break;
		case "btns_search1":
			openLandCd();
			break;
		case "btns_search2":
			openVslCd();
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
	var formObj=document.form;
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
	formObj.vsl_slan_cd.focus();
}
//function initPage() {
//	var formObj = document.form;
//
//	for (i = 0; i < sheetObjects.length; i++) {
//		ComConfigSheet(sheetObjects[i]);
//		initSheet(sheetObjects[i], i + 1);
//		ComEndConfigSheet(sheetObjects[i]);
//	}
//}
function clearPage() {
	var formObj=document.form;
	for (i=0; i < sheetObjects.length; i++) {
		sheetObjects[i].RemoveAll();
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
	case 1: // sheet1 init
	    with(sheetObj){
		
		      if (location.hostname != "")		     
		      SetSelectionMode(smSelectionList);
		      var HeadTitle1="|Sel.|VVD|VVD|VVD|VVD|VVD|VSL Name|Mask|Lane|P/F SKD Type|Status|VirStatus|Created Date|Start Date|Carrier|Carrier|turn_skd_voy_no|turn_skd_dir_cd|skd_sts_mnl_flg";
		      var HeadTitle2="||VSL|VOY NO.|OP Kind|OP Kind(MDA)|DIR|VSL Name||Lane|P/F SKD Type|Status|VirStatus|Created Date|Start Date|CURT|ACT||turn_skd_voy_no|turn_skd_dir_cd|skd_sts_mnl_flg";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      var prefix="sheet1_";

		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

		      var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:0 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"},
		                  { Text:HeadTitle2, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Sel" },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_cd",            		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_voy_no",        		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Combo",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"modi_vop_tp_cd",    		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"modi_vsl_opr_tp_cd",  	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_dir_cd",        		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:220,  Align:"Left",    ColMerge:1,   SaveName:prefix+"vsl_eng_nm",        		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },

		             //::FOR.NYK.START::by TOP:2014-11-07:://
		             {Type:"CheckBox",	Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_nm_xter_hide_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             //::FOR.NYK.FINISH::by TOP:2014-11-07:://
		             
		             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_slan_cd",       	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             
		             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pf_skd_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Combo",     Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_sts_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Combo",     Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vir_skd_sts_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Date",      Hidden:0,  Width:120,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Date",      Hidden:0,  Width:120,   Align:"Center",  ColMerge:1,   SaveName:prefix+"n1st_port_brth_dt", KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cur_crr_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"PopupEdit", Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"act_crr_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3, InputCaseSensitive:1 },
		             {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:prefix+"turn_skd_voy_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:prefix+"turn_skd_dir_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_sts_mnl_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		       
					InitColumns(cols);
					SetEditable(1);
					SetImageList(0,"img/btns_search.gif");
					SetEditableColorDiff(0);
					//conversion of function[check again]CLT 			InitDataValid(0, prefix+"act_crr_cd", InputCaseSensitive:1);
					SetRowHeight(0,20);
					SetRowHeight(1,20);
					SetColHidden("sheet1_vir_skd_sts_cd",1);					
					SetFocusAfterProcess(0);
					//SetColProperty(prefix+"act_crr_cd", {InputCaseSensitive:1}); 
					SetColProperty("sheet1_modi_vop_tp_cd", {ComboText:"07\tSC(NYK)|08\tSC(OTH)|01\tNYK|06\tAGENCY(OTH)|10\tPOOL(OTH)|05\tAGENCY(NYK)|09\tPOOL(NYK)|02\tTC OUT", ComboCode:"07|08|01|06|10|05|09|02"} );
					SetColProperty("sheet1_skd_sts_cd", {ComboText:"Holding|Ready|Booking|Booking|", ComboCode:"CLO|RDY|BKG|BKGNOD|ACT"} );
					SetColProperty("sheet1_vir_skd_sts_cd", {ComboText:"Holding|Booking|Booking|", ComboCode:"CLO|BKG|BKGNOD|ACT"} );
					
					SetRangeBackColor(1,1,1,5,"#555555");
					SetRangeBackColor(1,11,1,13,"#555555");
					
					resizeSheet();
		      }

		break;
	}
}
// in case Booking VVD, if ETA is within 3 days from today then user cannot delete
// in case Booking VVD of virtual port, user can delete. But Applying reason through VOP_VSK_0249 
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	sheetObj.SetWaitImageVisible(0);
	switch (sAction) {
	case IBSEARCH: // Retrieve
		if (validateForm(sheetObj, formObj, sAction)){
			formObj.f_cmd.value=SEARCH;
			sheetObj.RenderSheet(0);
			ComOpenWait(true);
			
			//alert(FormQueryString(formObj));
			//alert(ComGetPrefixParam("sheet1_"));
			setTimeout(function(){
				var sXml=sheetObj.GetSearchData("VOP_VSK_0018GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
				ComOpenWait(false);
				sheetObj.LoadSearchData(sXml,{Sync:0} );
	        },300);	
			
			sheetObj.RenderSheet(1);
		}
		break;
	case IBDELETE:
		var SaveStr=ComGetSaveString(sheetObjects);
		ComOpenWait(true);
		formObj.f_cmd.value=MULTI;
		setTimeout(function(){
			var sXml=sheetObj.GetSaveData("VOP_VSK_0018GS.do", FormQueryString(formObj) + "&" + SaveStr);
			ComOpenWait(false);
			var laneData=ComGetEtcData(sXml, "lane").split("|");
			var vvdData=ComGetEtcData(sXml, "vvd").split("|");
			var hisData=ComGetEtcData(sXml, "his").split("|");
			var turnVoyData=ComGetEtcData(sXml, "turn_voy").split("|");
			var turnDirData=ComGetEtcData(sXml, "turn_dir").split("|");
			if(vvdData!=""){
				var sUrl="/opuscntr/VOP_VSK_0249.do?";
				for(var i=0; i<vvdData.length-1; i++){
					sUrl=sUrl + "&lane_vvd=" + laneData[i] + "&bkg_vvd=" + vvdData[i] + "&his_vvd=" + hisData[i] + "&turn_voy=" + turnVoyData[i] + "&turn_dir=" + turnDirData[i] + "&aft_vsl_slan_cd=" + formObj.vsl_slan_cd.value;
				}
				ComOpenPopup(sUrl, 524, 322, "returnDeletePop", "0,0", true);
			}else{
				sheetObj.LoadSaveData(sXml);
				if(!VskGetErrorXml(sXml)){
					doActionIBSheet(sheetObj, formObj, IBSEARCH);	
				}
			}
        },300);	
		break;
		
	case MULTI01: // Manual Close
		ComOpenWait(true);
		formObj.f_cmd.value	= MULTI01;
		var sParam			= FormQueryString(formObj);
		
		setTimeout(function(){
			var sXml			= sheetObj.GetSaveData("VOP_VSK_0018GS.do", sParam + "&" + ComGetSaveString(sheetObj));
			sheetObj.LoadSearchData(sXml,{Sync:0});
			ComOpenWait(false);
			
			//alert(sXml);
			//alert(VskGetErrorXml(sXml));
			
			if(VskGetErrorXml(sXml)){
				return false;
			}else{
				return true;
			}
        },300);	
		
		break;
		
	case IBSAVE: // Save
		var dataRows=sheetObj.RowCount();
		
		//alert('dataRows ['+dataRows+']');
		//if(dataRows == 0){
		//	ComShowCodeMessage("VSK00021", formObj.vsl_slan_cd.value);
		//	return;
		//}
		
		formObj.f_cmd.value=MULTI02;
		var sParam=FormQueryString(formObj);
		ComOpenWait(true);
		setTimeout(function(){
			var sXml=sheetObj.GetSaveData("VOP_VSK_0018GS.do", sParam + "&" + ComGetSaveString(sheetObj));
			ComOpenWait(false);
			sheetObj.LoadSaveData(sXml);
			if(!VskGetErrorXml(sXml)){
				for(var i=0; i<saveRows.length; i++){
					sheetObj.SetRowStatus(saveRows[i],"R");
					setRowDisplay(sheetObj, saveRows[i], "R");
				}
				saveRows=new Array();
			}
        },300);	

		break;
	case SEARCH01: // Lane Code Retrieve
		formObj.f_cmd.value=SEARCH01;
		if ( sheetObj.id == "sheet1"){
			ComOpenWait(true);
			var sParam=FormQueryString(formObj);
			var sXml=sheetObj.GetSearchData("VOP_VSK_0018GS.do" , sParam);
			ComOpenWait(false);
			var vsl_slan_nm=ComGetEtcData(sXml, "vsl_slan_nm");
			if(!vsl_slan_nm){
				var message=VskGetXmlNodeValue(sXml, "MESSAGE");
				if(message!=""){
					sheetObj.LoadSearchData(sXml,{Sync:0} );
				}else{
					ComShowCodeMessage("VSK00021", formObj.vsl_slan_cd.value);
				}
				formObj.tmp_vsl_slan_cd.value="";
				formObj.vsl_slan_cd.value="";
				formObj.vsl_slan_cd.focus();
				return false;
			}else{
				formObj.tmp_vsl_slan_cd.value=formObj.vsl_slan_cd.value;
				formObj.vsl_cd.focus();
			}
		}
		break;
	case SEARCH02: // Vessel Code Retrieve
		//formObj.f_cmd.value = SEARCH;
		formObj.f_cmd.value=COMMAND16;
		if ( sheetObj.id == "sheet1"){
			ComOpenWait(true);
			var sParam=FormQueryString(formObj);
			var sXml=sheetObj.GetSearchData("VSK_GLOGS.do", sParam);
			ComOpenWait(false);
			var vsl_eng_nm=ComGetEtcData(sXml, "vsl_eng_nm");
	    	if(!vsl_eng_nm){ // undefined
	    		ComShowCodeMessage('VSK00021', formObj.vsl_cd.value);
				formObj.tmp_vsl_cd.value="";
				formObj.vsl_cd.value="";
				formObj.vsl_cd.focus();
				return false;
	    	}else{
	    		formObj.tmp_vsl_cd.value=formObj.vsl_cd.value;
	    		formObj.vsl_cd.focus();
	    	}
		}
		break;
		
	case MULTI03: // btn_SkdActivate click
		var prefix="sheet1_";
		var sParam="f_cmd=" + MULTI03 + "&" +
		prefix + "vsl_cd=" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), prefix + "vsl_cd") + "&" +
		prefix + "skd_voy_no=" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), prefix + "skd_voy_no") + "&" +
		prefix + "skd_dir_cd=" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), prefix + "skd_dir_cd");
		ComOpenWait(true);
		formObj.f_cmd.value=MULTI03;
		
		setTimeout(function(){
			var sXml=sheetObj.GetSaveData("VOP_VSK_0018GS.do", sParam);
			ComOpenWait(false);
			
			sheetObj.LoadSearchData(sXml,{Sync:0} );
			
			//alert(sXml);
			//alert(VskGetErrorXml(sXml));
			
			if(VskGetErrorXml(sXml)){
				return false;
			}else{
				return true;
			}
        },300);	
		
		break;
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	 with (formObj) {
		if(formObj.vsl_slan_cd.value == "" && formObj.vsl_cd.value == ""){
			ComShowCodeMessage("VSK00027", "Lane CD or Vessel CD");
			formObj.vsl_slan_cd.value="";
			formObj.vsl_slan_cd.focus();
			return false;
		}
	}
	return true;
}
/**
 * Open Lane Code Help
 */
function openLandCd() {
	var formObj=document.form;
	/*var sUrl="/opuscntr/VOP_VSK_0202.do";
	var rVal=ComOpenPopupWithTarget(sUrl, 500, 490, "sheet1_vsl_slan_cd:vsl_slan_cd", "0,0", true);
	if(rVal){
		formObj.tmp_vsl_slan_cd.value=rVal;
		formObj.vsl_cd.focus();
	}*/
	var sUrl="/opuscntr/VOP_VSK_0202.do?vsl_slan_cd=" + formObj.vsl_slan_cd.value;
	ComOpenPopup(sUrl, 500, 470, "returnLaneCdHelp", "0,0", true);
	
}
function openVslCd() {
	var formObj=document.form;
	/*
	var sUrl="/opuscntr/VOP_VSK_0219.do?vsl_cd=" + formObj.vsl_cd.value;
	var rVal=ComOpenPopupWithTarget(sUrl, 464, 500, "", "0,0", true);
	if (rVal) {
		formObj.vsl_cd.value=rVal;
	}*/
	var sUrl="/opuscntr/VOP_VSK_0219.do";
	ComOpenPopup(sUrl, 460, 500, "returnVslCdHelp", "0,0", true);
}

function returnDeletePop(rtnObjs) {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}
/**
 * After [Lane Code] Button Click, call from Pop-up
 * @param rtnObjs
 * @return
 */
function returnLaneCdHelp(rtnObjs){
	
	var formObj=document.form;
	var sheetObj=null;
	if(rtnObjs){
		var rtnDatas=rtnObjs[0];
		if(rtnDatas){
			if(rtnDatas.length > 0){
				formObj.vsl_slan_cd.value=rtnDatas[1];
			}
		}
	}
}

/**
 * Handling data from VSL Code Help (Pop-Up)
 * @param rtnObjs
 * @return
 */
function returnVslCdHelp(rtnObjs){
	var formObj=document.form;
	if(rtnObjs){
		var rtnDatas=rtnObjs[0];
		if(rtnDatas){
			if(rtnDatas.length > 0){
				formObj.vsl_cd.value=rtnDatas[1];
				
			}
		}
	}
}
function openBookingList(sheetObj){
	var selectRow=sheetObj.GetSelectRow();
	if(selectRow==-1){
		return;
	}
	var sUrl="/opuscntr/VOP_VSK_0229.do?vsl_cd=" + sheetObj.GetCellValue(selectRow, "sheet1_vsl_cd") + "&skd_voy_no=" + sheetObj.GetCellValue(selectRow, "sheet1_skd_voy_no")	+ "&skd_dir_cd=" + sheetObj.GetCellValue(selectRow, "sheet1_skd_dir_cd");
	var rVal=ComOpenPopupWithTarget(sUrl, 406, 485, "", "0,0", true);
}
function initControl() {
	var formObj=document.form;
	axon_event.addListenerForm('deactivate', 'obj_deactivate', formObj);
//	axon_event.addListenerForm('focus', 'obj_activate', formObj);
//	axon_event.addListenerForm('keypress', 'eng_keypress', formObj);
//	axon_event.addListenerForm('keypress', 'num_keypress', formObj);
//	axon_event.addListenerForm('keypress', 'enter_keypress', formObj);
//	axon_event.addListenerForm('keyup', "VskKeyFocus", formObj);
}
//function obj_activate(){
//	if(event.srcElement.options){
//		event.srcElement.focus();
//	}else{
//		event.srcElement.select();
//	}
//}
/**
 * Handling english of onkeypress
 **/
//function eng_keypress() {
//	 var name=event.srcElement.name;
//	switch(name){
//		case "vsl_slan_cd":
//		case "vsl_cd":
//			ComKeyOnlyAlphabet('uppernum');
//			break;
//		default:
//	}
//}
/**
 * Handling enter key
 */
//function enter_keypress(){
//	 VskKeyEnter();
//}
/**
 * Handling focus out event
 */
function obj_deactivate() {
	var formObj=document.form;
	var obj=event.srcElement;
	switch (event.srcElement.name) {
		case "vsl_slan_cd":
			if(obj.value==""){
				clearPage();
				formObj.tmp_vsl_slan_cd.value="";
				break;
			}
			if(formObj.tmp_vsl_slan_cd.value != obj.value){
				sheetObj=sheetObjects[0];
				doActionIBSheet(sheetObj, formObj, SEARCH01);
				if(sheetObj.RowCount()>0){
					sheetObj.RemoveAll();
				}
			}
			break;
		case "vsl_cd":
			if(obj.value==""){
				clearPage();
				formObj.tmp_vsl_cd.value="";
				break;
			}
			if(!obj || ComChkLen(obj.value, 4)!=2){
				break;
			}
			if(formObj.tmp_vsl_cd.value != obj.value){
				sheetObj=sheetObjects[0];
				doActionIBSheet(sheetObj, formObj, SEARCH02);
				if(sheetObj.RowCount()>0){
					sheetObj.RemoveAll();
				}
			}
			break;
	}
}
function sheet1_OnSearchEnd(sheetObj) {
	with(sheetObj){
		for(var Row=HeaderRows(); Row<RowCount()+HeaderRows(); Row++){
			if(GetCellValue(Row, "sheet1_skd_sts_cd")=="CLO" && GetCellValue(Row, "sheet1_skd_sts_mnl_flg")=="N"){
//				RowEditable(Row) = false;
				SetCellEditable(Row, "sheet1_Sel",0);
				SetRowBackColor(Row,"#F0F0F0");
			}else if(GetCellValue(Row, "sheet1_skd_sts_cd")=="BKG"){
				SetRowBackColor(Row,"#FFFF99");
			}else if(GetCellValue(Row, "sheet1_skd_sts_cd")=="BKGNOD"){
//				RowEditable(Row) = false;
				SetCellEditable(Row, "sheet1_Sel",0);
				SetRowBackColor(Row,"#FFA850");// nonremovable Booking VVD //orange color
			}else if(GetCellValue(Row, "sheet1_vir_skd_sts_cd")=="BKG"){
				SetRowBackColor(Row,"#FFFF99");
			}else if(GetCellValue(Row, "sheet1_vir_skd_sts_cd")=="BKGNOD"){
//				RowEditable(Row) = false;
				SetCellEditable(Row, "sheet1_Sel",0);
				SetRowBackColor(Row,"#FFA850");// nonremovable Booking VVD
			}
			if(GetCellValue(Row, "sheet1_pf_skd_tp_cd")==""){
				InitCellProperty(Row, "sheet1_pf_skd_tp_cd",{ Type:"Image",Align:"Center",Format:"dfNull"} );
//conversion of function[check again]CLT 				SetCellImage(Row, "sheet1_pf_skd_tp_cd",0);
//				existEmptyPf = true;
			}
		}
	}
}
function changeStatus(sheetObj){
	var dataRows=sheetObj.RowCount();
	for(var Row=sheetObj.HeaderRows(); Row<sheetObj.HeaderRows()+dataRows; Row++){
		if(sheetObj.GetCellValue(Row, 1)==1){
			if(sheetObj.GetCellValue(Row, "sheet1_skd_sts_cd")!="CLO"){
				sheetObj.SetCellValue(Row, "sheet1_skd_sts_cd","CLO",0);
				sheetObj.SetCellValue(Row, "sheet1_skd_sts_mnl_flg","Y",0);
				sheetObj.SetCellValue(Row, 1,0,0);
				sheetObj.SetRowStatus(Row,"R");
			}else if(sheetObj.GetCellValue(Row, "sheet1_skd_sts_cd")=="CLO"){
				sheetObj.SetCellValue(Row, "sheet1_skd_sts_cd","ACT",0);
				sheetObj.SetCellValue(Row, "sheet1_skd_sts_mnl_flg","N",0);
				sheetObj.SetCellValue(Row, 1,0,0);
				sheetObj.SetRowStatus(Row,"R");
			}
		}
	}
}
function checkSelection(sheetObj){
	var check=false;
	var dataRows=sheetObj.RowCount();
	for(var Row=sheetObj.HeaderRows(); Row<sheetObj.HeaderRows()+dataRows; Row++){
		if(sheetObj.GetCellValue(Row, 1)==1){
			check=true;
			break;
		}
	}
	return check;
}
function checkStatus(sheetObj){
	var dataRows=sheetObj.RowCount();
	var status=0;
	var count=0;
	for(var Row=sheetObj.HeaderRows(); Row<sheetObj.HeaderRows()+dataRows; Row++){
		if(sheetObj.GetCellValue(Row, 1)==1){
			count++;
			if(sheetObj.GetCellValue(Row, "sheet1_skd_sts_cd")=="CLO"){
				status=status + 1;
			}else if((sheetObj.GetCellValue(Row, "sheet1_skd_sts_cd")=="ACT" || sheetObj.GetCellValue(Row, "sheet1_skd_sts_cd")=="RDY") &&
					(sheetObj.GetCellValue(Row, "sheet1_vir_skd_sts_cd")=="ACT" || sheetObj.GetCellValue(Row, "sheet1_vir_skd_sts_cd")=="RDY")){
				status=status + 2;
			}else if(sheetObj.GetCellValue(Row, "sheet1_skd_sts_cd")=="BKG" || sheetObj.GetCellValue(Row, "sheet1_vir_skd_sts_cd")=="BKG"){
				return "BKG";
			}else{
				status=0;
				break;
			}
		}
	}
	if(status/count==1){
		return "CLO";
	}else if(status/count==2){
		return "ACT";
	}else{
		return "";
	}
}
function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
	var formObj=document.form;
	//	alert(CellValue(NewRow, "sheet1_vir_skd_sts_cd"));
	// button handling of selected a VVD
	var skd_sts_cd=sheetObj.GetCellValue(NewRow, "sheet1_skd_sts_cd");
	var skd_sts_mnl_flg=sheetObj.GetCellValue(NewRow, "sheet1_skd_sts_mnl_flg");
	var vir_skd_sts_cd=sheetObj.GetCellValue(NewRow, "sheet1_vir_skd_sts_cd");
	if( (skd_sts_cd=="BKG" || skd_sts_cd=="BKGNOD") ){
		ComBtnEnable("btn_BookingList");
		//|| (vir_skd_sts_cd=="BKG" || vir_skd_sts_cd=="BKGNOD") ){
	}else{
		ComBtnDisable("btn_BookingList");
	}
	// SKD Activate button
	if("Y"==formObj.availActivate.value) {
		if( skd_sts_cd=="CLO" && skd_sts_mnl_flg=="N" ){
			ComBtnEnable("btn_SkdActivate");
		}else{
			ComBtnDisable("btn_SkdActivate");
		}
	}
}

function sheet1_OnClick(sheetObj, Row, Col){
	var formObj=document.form;
	var colSaveName=sheetObj.ColSaveName(Col);
	switch(colSaveName){
		case "sheet1_pf_skd_tp_cd":
			if(sheetObj.CheckedRows("sheet1_Sel")>0){
				ComShowMessage("SKD Deletion/Holding and ACT CRR update can not be used at the same time.");
				break;
			}
			if(sheetObj.GetCellValue(Row, Col) == "0"){
				
				var sUrl="/opuscntr/VOP_VSK_0212.do?vsl_slan_cd=" + formObj.vsl_slan_cd.value;
				ComOpenWait(true);
				var pfSkdTpCd=ComOpenPopupWithTarget(sUrl, 306, 407, "", "0,0", true);
				ComOpenWait(false);
				if(pfSkdTpCd){
					sheetObj.InitCellProperty(Row, Col,{ Type:"Null",Align:"Center",Format:"dfNull"} );
					sheetObj.SetCellValue(Row, Col,pfSkdTpCd);
					saveRows.push(Row);
				}
			}		
			break;
	}
}

function sheet1_OnChange(sheetObj, Row, Col, Value){
	var colSaveName	= sheetObj.ColSaveName(Col);
	var formObj		= document.form;
	
	switch(colSaveName){
		case "sheet1_modi_vop_tp_cd":
				var curVsl  = sheetObj.GetCellValue(Row, "sheet1_vsl_cd") + sheetObj.GetCellValue(Row, "sheet1_skd_voy_no");
				var nextVsl = "";
				for(var i=Row+1; i<sheetObj.RowCount()+sheetObj.HeaderRows(); i++){
					nextVsl  = sheetObj.GetCellValue(i, "sheet1_vsl_cd") + sheetObj.GetCellValue(i, "sheet1_skd_voy_no");
					if(curVsl == nextVsl){
						sheetObj.SetCellValue(i, "sheet1_modi_vop_tp_cd", Value, 0);
						saveRows.push(i);
					}else{
						break;
					}
				}
				
				for(var i=Row-1; i>=sheetObj.HeaderRows(); i--){
					nextVsl  = sheetObj.GetCellValue(i, "sheet1_vsl_cd") + sheetObj.GetCellValue(i, "sheet1_skd_voy_no");
					if(curVsl == nextVsl){
						sheetObj.SetCellValue(i, "sheet1_modi_vop_tp_cd", Value, 0);
						saveRows.push(i);
					}else{
						break;
					}
				}
				saveRows.push(Row);
			break;
		case "sheet1_vsl_nm_xter_hide_flg":
			
			//Value != sheetObj.CellSearchValue(Row, Col);
			
			//if(Value!=""){
				checkVslNmXterHideFlg(sheetObj, formObj, Row, Col, Value);
			//}
			//setRowDisplay(sheetObj, Row, sheetObj.GetRowStatus(Row));
			break;	
			
		case "sheet1_pf_skd_tp_cd":
			setRowDisplay(sheetObj, Row, sheetObj.GetRowStatus(Row));
			break;
			
		case "sheet1_act_crr_cd":
			if(sheetObj.CheckedRows("sheet1_Sel")>0){
				if(Value != sheetObj.CellSearchValue(Row, Col)){
					ComShowMessage("SKD Deletion/Holding and ACT CRR update can not be used at the same time.");
					sheetObj.SetCellValue(Row, Col,sheetObj.CellSearchValue(Row, Col));
					return false;
				}
			}
			if(Value!=""){
				searchCrrCd(sheetObj, formObj, Row, Col, Value);
			}
			saveRows.push(Row);
			setRowDisplay(sheetObj, Row, sheetObj.GetRowStatus(Row));
			break;
			
		case "sheet1_Sel":
			if(Value == 1){
				checkFontBold(sheetObj);
			}
		default:
	}
}
/**
 * Handling display status
 */
function setRowDisplay(sheetObj, Row, Status){
	 with(sheetObj){
		switch(Status){
			case "U":
				sheetObj.SetRowFontColor(Row,"#000000");
				sheetObj.SetCellFont("FontBold", Row, 0, Row, sheetObj.LastCol(),1);
				break;
			default: // "R"
				sheetObj.SetRowFontColor(Row,"#000000");
				sheetObj.SetCellFont("FontBold", Row, 0, Row, sheetObj.LastCol(),0);
		}
	}
}

/*
 * Checking vsl_nm_xter_hide_flg 
 */
function checkVslNmXterHideFlg(sheetObj, formObj, Row, Col, Value){
	saveRows.push(Row);
}

 /*
  * Checking act_crr_cd 
  */
function searchCrrCd(sheetObj, formObj, Row, Col, Value){
	ComOpenWait(true);
	formObj.f_cmd.value=SEARCH03;
	var prefix="sheet1_";
	var sParam="f_cmd=" + SEARCH03 + "&" + "crrCd=" + Value;
	var sXml=sheetObj.GetSearchData("VOP_VSK_0018GS.do", sParam);
	ComOpenWait(false);
	var crr_cd=ComGetEtcData(sXml, "crr_cd");
	if(crr_cd == "null"){
		ComShowCodeMessage("VSK50030");
		sheetObj.SetCellValue(Row, Col,sheetObj.CellSearchValue(Row, Col));
	}else{
		saveRows.push(Row);
	}
}

function sheet1_OnPopupClick(sheetObj, Row, Col){
	var sUrl="/opuscntr/VOP_VSK_0252.do?code_type=CD0XXXX";
	ComOpenPopup(sUrl, 550, 410, "returnActCd", "0,0", true);
	/*
	ComOpenWait(true);
	var newActCrrCd=ComOpenPopupWithTarget(sUrl, 550, 406, "", "0,0", true);
	ComOpenWait(false);
	if(newActCrrCd){
		sheetObj.SetCellValue(Row, "sheet1_act_crr_cd",newActCrrCd);
		saveRows.push(Row);
	}
	*/
}
function checkFontBold(sheetObj){
	var dataRows=sheetObj.RowCount();
	var count=0;
	for(var Row=sheetObj.HeaderRows(); Row<sheetObj.HeaderRows()+dataRows; Row++){
		if(sheetObj.GetCellFont("FontBold", Row, 0, Row, sheetObj.LastCol())){
			count=1;
		}
	}
	if(count == 1){
		ComShowMessage("SKD Deletion/Holding and ACT CRR update can not be used at the same time.");
		for(var Row=sheetObj.HeaderRows(); Row<sheetObj.HeaderRows()+dataRows; Row++){
			sheetObj.SetCellValue(Row, "sheet1_Sel",0);
		}
	}
}

function returnActCd(rtnObjs){
	var sheetObj=sheetObjects[0];
	var formObj=document.form;
	if(rtnObjs){
		var rtnDatas=rtnObjs;
		if(rtnDatas){
			if(rtnDatas.length > 0){
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_act_crr_cd" ,rtnDatas);
				saveRows.push(sheetObj.GetSelectRow());
			}
		}
	}
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}