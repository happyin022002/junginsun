/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_2001
*@FileTitle  : M.G.Set Model Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class ees_cgm_2001 : ees_cgm_2001 business script for
 */

// common global variables
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
//var confirm_eq_spec_no="";
var sSaveFlag = null; // insert, update : S, delete : D

// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	/***** use additional sheet var in case of more than 2 tap each sheet *****/
	var sheetObject=sheetObjects[0];
	var sheetObject1=sheetObjects[1];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
				if(ComGetBtnDisable(srcName)) return false;
		var formObj=document.form;
			switch (srcName) {
			case "Retrieve":
	  	        with(cmb_eq_spec_no) { // setting edit enable in case of click new
	  	        	SetEditable(false); //setting edit unable
	 	  	    }			
				if((cmb_eq_spec_no.GetSelectText() == null) || (cmb_eq_spec_no.GetSelectText() == "")) {
					ComShowCodeMessage("CGM10004", "Model No")
					return;
				}
				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
				formObj.page_status.value="R";
				break;
			case "New":
				//document.eq_spec_no.Index = -1;
				formObj.page_status.value="I";
				initControl();
	  	        with(cmb_eq_spec_no) { // setting edit enable in case of click new
	  	        	
	  	        	SetEditable(true); //setting edit enable
	 	  	    }			
				break;
			case "Save":
				if(cmb_eq_spec_no.GetSelectText() == null || cmb_eq_spec_no.GetSelectText() == ""){
					ComShowCodeMessage("CGM10004", "Model No");
					return;
				}else 
				{
					if(sheetObject1.GetRowStatus(1)=="I")
					{
						formObj.f_cmd.value				= SEARCH01;
						formObj.eq_spec_no_dup.value	= cmb_eq_spec_no.GetSelectText();
						
	 					var sXml		= sheetObject1.GetSearchData("EES_CGM_2001GS.do", FormQueryString(formObj));
						// data count
						var dataCount	= ComGetTotalRows(sXml);
						
						if(dataCount > 0){
							ComShowCodeMessage('CGM20011',cmb_eq_spec_no.GetSelectText());
							cmb_eq_spec_no.SetSelectText('', false);
							return;
						}
					}
				}
				if(formObj.vndr_seq_text.value == null || formObj.vndr_seq_text.value == ""){
					ComShowCodeMessage("CGM10004", "Maker");
					return;
				}
				if(formObj.eq_tpsz_cd_text.value == null || formObj.eq_tpsz_cd_text.value == ""){
					ComShowCodeMessage("CGM10004", "Type");
					return;
				}
				
				
				doActionIBSheet(sheetObject1,formObject,IBSAVE);
	  	        
				break;
			case "Delete":
				if(sheetObject.RowCount() != 0){
					ComShowCodeMessage("CGM10033");
					return;
				}
				formObj.f_cmd.value			= SEARCH01;
				formObj.eq_spec_no.value	= cmb_eq_spec_no.GetSelectText();
				
	      		var sXml=sheetObject1.GetSearchData("EES_CGM_1002GS.do", FormQueryString(formObj));
	     		// data count
	  	        var dataCount=ComGetTotalRows(sXml);
	  	        // a.You cannot delete specification number with chassis. Please contact system manager.
	  	        if(dataCount > 0){
	  	        	ComShowCodeMessage('CGM10033');
	  	        	return;
	  	        }
				// b.Are you sure that you want to delete this specification number? 
				if ( ComShowCodeConfirm("CGM10051", "specification number")) {
					sheetObject1.SetRowStatus(1,"D");
					doActionIBSheet(sheetObject1,formObject, IBDELETE);
				}else
				{
					return;
				}
	  	        	
				break;
			} // end switch
			tRoleApply();
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * registering IBCombo Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
function setComboObjects(combo_obj) {
	comboObjects[comboCnt++]=combo_obj;
}
/**
 * implementing onLoad event handler in body tag / adding first-served functions after loading screen.
 */
function loadPage() {
    for(var i=0;i<sheetObjects.length;i++){
    	ComConfigSheet (sheetObjects[i] );
    	initSheet(sheetObjects[i],i+1);
    	ComEndConfigSheet(sheetObjects[i]);
    }
    sheet1_OnLoadFinish(sheet1);
}

 /**
 * sheet setting and init in case of load finish <br>
 * @param  
 * @return 
 * @author 
 * @version 
 */     
function sheet1_OnLoadFinish(sheetObj) {
    sheetObj.SetWaitImageVisible(0);
 	var sheetObject=sheetObjects[0];
	var sheetObject1=sheetObjects[1];
	var formObj=document.form;

	axon_event.addListener("blur",		"obj_deactivate",	"mgst_fuel_capa");
	axon_event.addListener("focusin",	"obj_activate",		"mgst_fuel_capa");
//	axon_event.addListener("keypress",			"obj_onkeypress",	"mgst_fuel_capa");
//	axon_event.addListener("click",				"obj_onclick",		"mgst_vltg_capa");
//	axon_event.addListener("focusout",			"obj_focusout",		"mgst_fuel_capa");
//	axon_event.addListener("blur",				"obj_blur",			"eq_spec_no", "eq_tpsz_cd");
	
	comboCnt=0;
	
	//IBMULTICOMBO RESET
	comboObjects[comboCnt++]=cmb_eq_spec_no;
	comboObjects[comboCnt++]=vndr_seq;
	comboObjects[comboCnt++]=eq_tpsz_cd;
	for(var i=0; i< comboCnt; i++)
 	{
 		initCombo(comboObjects[i]);
 	}
   	doActionIBSheet(sheetObjects[0], document.form, IBRESET);
   	doActionIBSheet(sheetObject1, formObj, IBSEARCH_ASYNC01);
	initControl();
	tRoleApply();
    sheetObj.SetWaitImageVisible(1);
    
    with(cmb_eq_spec_no) { // setting edit enable in case of click new
    	SetEditable(true); //setting edit enable
    }	
 }
 /**
  * init control of form
  */
 function initControl(){
	// Form object
	var formObj=document.form;
	var sheetObject=sheetObjects[0];
	var sheetObject1=sheetObjects[1];
	sheetObject.RemoveAll();
	sheetObject1.RemoveAll();
	cmb_eq_spec_no.SetSelectIndex(-1,false);
	var row=sheetObject1.DataInsert(0);
	sheetObject1.SetCellValue(1, "eq_knd_cd","G");
	sheetObject1.SetCellValue(1, "mgst_vltg_capa","220");
	sheetObject1.SetCellValue(1, "eq_tpsz_cd","UMG");
	vndr_seq.SetSelectIndex(-1,false);
	eq_tpsz_cd.SetSelectCode("UMG");
	formObj.mgst_fuel_capa.value="";
	formObj.mgst_vltg_capa[0].checked=true;
	sheetObject1.SetRowStatus(1,"I");
 }
 
/**
 * setting sheet initial values and header param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch (sheetNo) {
	case 1: // t1sheet1 init
	    with(sheetObj){
		      var HeadTitle="Seq.|Range|Q'ty";
		
		      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);
		
		      var cols = [ {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"desc1",  KeyField:0,   CalcLogic:"",   Format:"" },
		             {Type:"Text",      Hidden:0,  Width:250,  Align:"Center",  ColMerge:1,   SaveName:"desc2",  KeyField:0,   CalcLogic:"",   Format:"" },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"desc3",  KeyField:0,   CalcLogic:"",   Format:"" } ];
		       
		      InitColumns(cols);
		      SetEditable(0);
		      SetSheetHeight(400);
            }
		break;
	case 2: // t1sheet1 init
	    with(sheetObj){
		      var HeadTitle="ibflag|eq_spec_no|vndr_seq|eq_knd_cd|eq_tpsz_cd|mgst_vltg_capa|mgst_fuel_capa";
		
		      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);
		
		      var cols = [ {Type:"Status",    Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"eq_spec_no",      KeyField:0,   CalcLogic:"",   Format:"" },
		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",        KeyField:0,   CalcLogic:"",   Format:"" },
		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"eq_knd_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"" },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"mgst_vltg_capa",  KeyField:0,   CalcLogic:"",   Format:"" },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"mgst_fuel_capa",  KeyField:0,   CalcLogic:"",   Format:"" } ];
		       
		      InitColumns(cols);
		      SetEditable(1);
		      SetSheetHeight(100);
            }
		break;
	}
}
/**
 * SHEET process handling
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	var sheetObject=sheetObjects[0];
	var sheetObject1=sheetObjects[1];
	var formObj=document.form;
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: // retrieve
//		sheetObject1.RemoveAll(); //01072014
		formObj.f_cmd.value			= SEARCH;
		formObj.eq_spec_no.value	= cmb_eq_spec_no.GetSelectText();
 		sheetObject1.DoSearch("EES_CGM_2001GS.do",FormQueryString(formObj) );
		// retrieve value combo matching
		vndr_seq.SetSelectText('',false);//chungpa 20100222 lessor display null bug
		vndr_seq.SetSelectCode(sheetObj.GetCellValue(1, "vndr_seq"));
		eq_tpsz_cd.SetSelectCode(sheetObj.GetCellValue(1, "eq_tpsz_cd"));
		// radio button value setting
		if(sheetObject1.GetCellValue(1, "mgst_vltg_capa") == "220") {
			formObj.mgst_vltg_capa[0].checked=true;
		} else {
			formObj.mgst_vltg_capa[1].checked=true;
		}
		break;
	case IBSAVE: // saving
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);		
		formObj.f_cmd.value			= MULTI;
		formObj.eq_spec_no.value	= cmb_eq_spec_no.GetSelectText();
		
//		prompt("1",FormQueryString(formObj));
		sSaveFlag = "S";
		sheetObj.DoSave("EES_CGM_2001GS.do", FormQueryString(formObj));
		
		break;
	case IBDELETE: // deleting
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);		
		formObj.f_cmd.value			= REMOVE;
		formObj.eq_spec_no.value	= cmb_eq_spec_no.GetSelectText();
		sSaveFlag = "D";
//		sheetObj.DoSave("EES_CGM_2001GS.do", FormQueryString(formObj), -1, false);
		var ParamData = FormQueryString(formObj);
		sheetObj.DoSave("EES_CGM_2001GS.do", {Param:ParamData,Quest:0,Sync:1} );
		loadPage();
		
		
		break;
    // COMBO - MODEL NO
	case IBSEARCH_ASYNC01:
		formObj.f_cmd.value			= SEARCH03;
		formObj.eq_spec_no.value	= cmb_eq_spec_no.GetSelectText();
 		var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
		//ComDebug(sXml);
		var sStr=ComGetEtcData(sXml,"comboList");
		var arrStr=sStr.split("@");
		MakeComboObject1(cmb_eq_spec_no, arrStr, 0);
		break;
    // COMBO - MAKER
	case IBSEARCH_ASYNC03:
		formObj.f_cmd.value			= SEARCH05;
		formObj.eq_spec_no.value	= cmb_eq_spec_no.GetSelectText();
 		var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
		var sStr=ComGetEtcData(sXml,"comboList");
		var arrStr=sStr.split("@");
		MakeComboObjectManufacture(vndr_seq, arrStr, 1);
		break;
    // COMBO - TYPE/SIZE
	case IBSEARCH_ASYNC02:
		formObj.f_cmd.value			= SEARCH04;
		formObj.eq_spec_no.value	= cmb_eq_spec_no.GetSelectText();
 		var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
		var sStr=ComGetEtcData(sXml,"comboList");
		var arrStr=sStr.split("@");
		MakeComboObject1(eq_tpsz_cd, arrStr, 0);
		break;
	// M.G.SET NO data retrieve
	case SEARCH06:
		sheetObj.RemoveAll();
		formObj.f_cmd.value			= SEARCH06;
		formObj.eq_spec_no.value	= cmb_eq_spec_no.GetSelectText();
		sheetObject.DoSearch("CgmCodeMgtGS.do",FormQueryString(formObj) );
        
//		gridList=ComGetEtcData(sXml, "gridList");
//		if(gridList < 1) {
//			ComShowCodeMessage("CGM10003","Location ");
//		}
		
		sheetObject1.RemoveAll();
		formObj.f_cmd.value=SEARCH;
		sheetObject1.DoSearch("EES_CGM_2001GS.do",FormQueryString(formObj) );
        break;
	case IBRESET:
		var idx=0
		var sXml2=document.form2.sXml.value;
		var arrXml=sXml2.split("|$$|");
   		// Spec No of CGM_EQ_SPEC table
		if ( arrXml[idx] == null ) {return;}
		var vArrayListData=ComCgmXml2ListMap(arrXml[idx]);
	    var arrStr1=new Array();
		for ( var i=0; i < vArrayListData.length; i++) {
		    vListData=vArrayListData[i];
		    arrStr1[i]=vListData["code1"] + "|" + vListData["desc1"];
		}
		
		MakeComboObject1(cmb_eq_spec_no, arrStr1, 0);
		idx++;        		
		//Type/Size
		if ( arrXml[idx] == null ) {return;}
		var vArrayListData2=ComCgmXml2ListMap(arrXml[idx]);
	    var arrStr2=new Array();
		for ( var i=0; i < vArrayListData2.length; i++) {
		    vListData=vArrayListData2[i];
		    arrStr2[i]=vListData["code1"] + "|" + vListData["desc1"];
		}
		MakeComboObject1(eq_tpsz_cd, arrStr2, 0);
  		idx++;
		// Manufacturer
		if ( arrXml[idx] == null ) {return;}
		var vArrayListData3=ComCgmXml2ListMap(arrXml[idx]);
	    var arrStr3=new Array();
		for ( var i=0; i < vArrayListData3.length; i++) {
		    vListData=vArrayListData3[i];
		    arrStr3[i]=vListData["code1"] + "|" + vListData["desc1"];
		}
		MakeComboObjectManufacture(vndr_seq, arrStr3, 1);
  		idx++;
		break;        
	}
}
/**
 * IBMULTI COMBO
 */
function initCombo(comboObj) {
    switch(comboObj.options.id) {
    	// MODEL NO
    	case "cmb_eq_spec_no":
    		with(comboObj){
    			SetDropHeight(1000);
    			SetMultiSelect(0);
	            SetMaxLength(20);
	            ValidChar(2,3);
    		}
    		break;
    	// MAKER
	    case "vndr_seq":
	        with(comboObj) {
	        	SetDropHeight(120);
	        	SetMultiSelect(0);
	        }
	        break;
	    // M.G.SET TYPE/SIZE
	    case "eq_tpsz_cd":
	    	with(comboObj){
	        	SetDropHeight(100);
	        	SetMultiSelect(0);
	        	SetSelectIndex(0);
	    	}
	    	break;
	}
}
/**
 * combo object creation
 */
function MakeComboObject1(cmbObj, arrStr, col) {
	cmbObj.RemoveAll();
	for (var i=0; i<arrStr.length; i++) {
		var arrCode=arrStr[i].split("|");
		cmbObj.InsertItem(i, arrCode[1], arrCode[0]);
		
	}
}
 /**
  * combo object creation
  */
 function MakeComboObjectManufacture(cmbObj, arrStr, col) {
	cmbObj.RemoveAll();
	cmbObj.InsertItem(0, "", "");
//	cmbObj.InsertItem(1, "Thermo King Corporation","113272");
	for (var i=0; i<arrStr.length; i++) {
		var arrCode=arrStr[i].split("|");
		cmbObj.InsertItem(i+2, arrCode[1], arrCode[0]);
	}
	cmbObj.SetSelectIndex("" ,false);
 }
 /**
  * combo object creation + '' for 0 Index.
  */
 function MakeComboObject2(cmbObj, arrStr, col) {
 	cmbObj.RemoveAll();
 	cmbObj.InsertItem(0, '', '');
 	for (var i=1; i<=arrStr.length; i++) {
 		var arrCode=arrStr[i-1].split("|");
 		cmbObj.InsertItem(i, arrCode[1], arrCode[0]);
 	}
 }
function vndr_seq_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, Index_Code, Text){
	var sheetObject1=sheetObjects[1];
	sheetObject1.SetCellValue(1, "vndr_seq", newCode);
	if(vndr_seq.GetSelectIndex()<=-1){
		document.form.vndr_seq_text.value=""; 
	}else{
		document.form.vndr_seq_text.value = comboObj.GetText(parseInt(newIndex), 0); 
	}
	
}

function vndr_seq_OnBlur() {
	document.form.vndr_seq_text.value = vndr_seq.GetText(parseInt(vndr_seq.GetSelectIndex()), 0);
}

 function eq_tpsz_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, Index_Code, Text){
 	var sheetObject1=sheetObjects[1];
 	var comboValuec=comboObj.GetText(parseInt(newIndex),0);
 	sheetObject1.SetCellValue(1, "eq_tpsz_cd", comboValuec);
 }
function setTabObject(tab_obj) {
	tabObjects[tabCnt++]=tab_obj;
}
function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {
		}
		break;
	}
}
function tab1_OnChange(tabObj, nItem) {
	var objs=document.all.item("tabLayer");
	objs[nItem].style.display="Inline";
	objs[beforetab].style.display="none";
	// *********************************************************
	objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1;
	// *******************************************************************
	beforetab=nItem;
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {}
	return true;
}
//function obj_blur(comboObj, Index_Code, Text){
//	var formObj=document.form;
//	var sheetObject1=sheetObjects[1];
//	sheetObject1.SetCellValue(1, "eq_spec_no",cmb_eq_spec_no.GetSelectText());
//	sheetObject1.SetCellValue(1, "eq_tpsz_cd",formObj.eq_tpsz_cd_text.value);
//}
function cmb_eq_spec_no_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, Index_Code, Text){
//	alert("comboObj[" + typeof comboObj + "] : " + comboObj +
//			"\noldIndex[" + typeof oldIndex + "] : " + oldIndex +
//			"\noldText[" + typeof oldText + "] : " + oldText +
//			"\noldCode[" + typeof oldCode + "] : " + oldCode +
//			"\nnewIndex[" + typeof newIndex + "] : " + newIndex +
//			"\nnewText[" + typeof newText + "] : " + newText +
//			"\nnewCode[" + typeof newCode + "] : " + newCode);
//	
//	alert(cmb_eq_spec_no.FindItem(newText, 0));
	// *********************************************************//
	var formObj		= document.form;
	var sheetObj	= sheetObjects[0];
	var sheetObj1	= sheetObjects[1];
	// *********************************************************//
	if(Text.length > 20) // chungpa 20090803 MAXLEN cannot be over more than 20 
	{
		ComShowCodeMessage('CGM10019','eq_spec_no(20)');
		cmb_eq_spec_no.SetSelectText('',false);//
		sheetObj1.SetCellValue(1, "eq_spec_no",'');
		return;
	}
//	var confirm_eq_spec_no=cmb_eq_spec_no.GetSelectText();// comboObj.GetText(Index_Code,0);
//	sheetObj1.SetCellValue(1, "eq_spec_no",confirm_eq_spec_no,0);
	if(cmb_eq_spec_no.FindItem(newText, 0) >= 0) {
		doActionIBSheet(sheetObj, formObj, SEARCH06);
	}else {
		formObj.cmb_eq_spec_no_text.value = cmb_eq_spec_no.GetSelectText();
		sheetObj1.SetCellValue(1, "eq_spec_no", cmb_eq_spec_no.GetSelectText(), false);
		//cmb_eq_spec_no.InsertItem(-1, cmb_eq_spec_no.GetSelectText(), cmb_eq_spec_no.GetSelectText());
		
	//	alert(sheetObj1.GetCellValue(1,"eq_spec_no"));
	}
}
//function cmb_eq_spec_no_OnBlur() {
//	if(cmb_eq_spec_no.GetSelectIndex()<=-1){
//		document.form.eq_spec_no_text.value=""; 
//	}else{
//		document.form.eq_spec_no_text.value = eq_spec_no.GetText(parseInt(cmb_eq_spec_no.GetSelectIndex()), 0);
//	}
//}
/**
 * HTML Object event handling
 */
//function obj_focusout() {
//	var sheetObject1=sheetObjects[1];
//	var formObj=document.form;
//	var obj=ComGetEvent();
//    ComChkObjValid(obj);
//	switch(ComGetEvent("name")){
//        case "mgst_fuel_capa":
//    		sheetObject1.SetCellValue(1, "mgst_fuel_capa",formObj.mgst_fuel_capa.value.replaceStr(","));
//        	break;
//    }
//}
function obj_onclick(radioObj){
	var formObj=document.form;
	var sheetObject1=sheetObjects[1];
	if(formObj.mgst_vltg_capa[0].checked == true) {
		sheetObject1.SetCellValue(1, "mgst_vltg_capa","220");
	} else {
		sheetObject1.SetCellValue(1, "mgst_vltg_capa","440");
	}
}
/**
 * Axon event handling 2. even handling function
 */
function obj_deactivate(){
    ComChkObjValid(ComGetEvent());
    
    var sheetObject1=sheetObjects[1];
	var formObj=document.form;
	var obj=ComGetEvent();
    ComChkObjValid(obj);
	switch(ComGetEvent("name")){
        case "mgst_fuel_capa":
    		sheetObject1.SetCellValue(1, "mgst_fuel_capa",formObj.mgst_fuel_capa.value.replaceStr(","));
    		formObj.mgst_fuel_capa.value=ComGetMaskedValue(sheetObject1.GetCellValue(1, "mgst_fuel_capa"), "int");
        	break;
    }
}
/**
 * Axon event handling 2. even handling function
 */
function obj_activate(){
    ComClearSeparator(ComGetEvent());
    ComIsNumber(ComGetEvent(), ",");
}
 /**
 * function(ex:btn_save) role(trole) apply  <br>
 * @param  
 * @return 
 * @author 
 * @version
 */     
 function tRoleApply() {
//	  var formObj=document.form;
//	  if(formObj.trole.value == "Authenticated")
//	  {
//	  }else
//	  {
//		  ComBtnDisable("Save");
//		  ComBtnDisable("Delete");
//	  }
 }
 
function sheet2_OnSearchEnd(sheetObject1, errMsg) {
	var formObj = document.form;
	if(sheetObject1.RowCount() > 0) {
		with(cmb_eq_spec_no) { // setting edit enable in case of click new
	   //    	SetEditable(false); //setting edit unable
	 	}	
	    formObj.page_status.value == "R"	 
	}else{
		if(formObj.page_status.value == "I") //Insert
		{
			sheetObject1.RemoveAll();
			var row=sheetObject1.DataInsert(0);
			sheetObject1.SetCellValue(1, "eq_knd_cd","G");
			if(formObj.mgst_vltg_capa[0].checked == true) {
				sheetObject1.SetCellValue(1, "mgst_vltg_capa","220");
			} else {
				sheetObject1.SetCellValue(1, "mgst_vltg_capa","440");
			}
			sheetObject1.SetRowStatus(1,"I");
		}
	}
	vndr_seq.SetSelectText('',false);//chungpa 20100222 lessor display null bug
	vndr_seq.SetSelectCode(sheetObject1.GetCellValue(1, "vndr_seq"));
	eq_tpsz_cd.SetSelectCode(sheetObject1.GetCellValue(1, "eq_tpsz_cd"));
	if(sheetObject1.GetCellValue(1, "mgst_vltg_capa") == "220") { // radio button value
		formObj.mgst_vltg_capa[0].checked=true;
	} else {
		formObj.mgst_vltg_capa[1].checked=true;
	}
	formObj.mgst_fuel_capa.value=ComGetMaskedValue(sheetObject1.GetCellValue(1, "mgst_fuel_capa"), "int");
}

function sheet2_OnSaveEnd(Code, Msg, StCode, StMsg) {
//	alert("Code[" + typeof Code + "] : " + Code + 
//			", Msg[" + typeof Msg + "] : " + Msg +
//			", StCode[" + typeof StCode + "] : " + StCode +
//			", StMsg[" + typeof StMsg + "] : " + StMsg);
	
	/***** use additional sheet var in case of more than 2 tap each sheet *****/
	var sheetObject=sheetObjects[0];
	var sheetObject1=sheetObjects[1];
	/**************************************************************************/
	var formObj = document.form;
	
	if(Msg == 0) { // Save Success
		doActionIBSheet(sheetObject1, formObj, IBSEARCH_ASYNC01);
		if(sSaveFlag == "S") { // On Insert & Update

			cmb_eq_spec_no.SetSelectText(sheetObject1.GetCellValue(1, "eq_spec_no"), false);
			ComShowCodeMessage("CGM00003");
		} else if(sSaveFlag == "D") { // On Delete
			
			ComShowCodeMessage("CGM00006", formObj.eq_spec_no.value);
			
			loadPage(); // Page Init
		} else {
			
		}
	} else if(Msg != 0 && sSaveFlag == "D") {
		
		sheetObject1.SetRowStatus(1,"U");
		loadPage(); // Page Init
	} else {
		// There is no possibility
	}
	
	with(cmb_eq_spec_no) { // setting edit enable in case of click new
		SetEditable(false); //setting edit unable
	}
	
	ComOpenWait(false);
}
/* developer jop end */
