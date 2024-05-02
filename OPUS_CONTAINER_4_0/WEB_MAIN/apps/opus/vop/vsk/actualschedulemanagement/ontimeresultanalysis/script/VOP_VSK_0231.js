/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0231.jsp
*@FileTitle  : SKD for Conversion
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/12
=========================================================*/

// public variable
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick(){
	var sheetObject1=sheetObjects[0];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
        if (!ComIsBtnEnable(srcName)) return;  
		switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
				break;
			case "btn_ok":
				if(sheetObject1.FindCheckedRow("checkbox") == ""){
					return;
				}else{
					comPopupOK();
				}
				
				break;
			case "btn_close":
				ComClosePopup(); 
				break;
			case "btns_search":
				doActionIBSheet(sheetObject1, formObject, SEARCH01);
				break; 					
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage('VSK09005');	//Original
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
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
	document.form.vsl_cd.focus();
}
/**
 * registering initial event
 */
function initControl() {
	var formObj=document.form;
//	axon_event.addListenerForm('focus', 'obj_focus', formObj);
//	axon_event.addListenerFormat("keypress", "obj_keypress", form);
//	axon_event.addListenerFormat("keyup",    "obj_keyup" ,   form);
	axon_event.addListenerForm ('keydown', 'ComKeyEnter', formObj);
}
function obj_focus() {
	if(event.srcElement.options){
		event.srcElement.focus();
	}else{
		event.srcElement.select();
	}
}
/**
 * Handling KEY PRESS event
 */
function obj_keypress() {
	switch(event.srcElement.dataformat){
		case "float":
			ComKeyOnlyNumber(event.srcElement, ".");
			break;
		case "eng":
			ComKeyOnlyAlphabet();
			break;
		case "engdn":
			ComKeyOnlyAlphabet('lower');
			break;
		case "engup":
			ComKeyOnlyAlphabet('upper');
			break;
		case "uppernum":
            ComKeyOnlyAlphabet('uppernum');
            break;    	
		default:
			ComKeyOnlyNumber(event.srcElement);
	}
	switch(event.srcElement.name){
		case "vsl_cd": case "voy_no": case "dir_cd": case "vsl_slan_cd":
			if(event.keyCode==13){
//parameter changed[check again]CLT DoSearch("" );
			}
			break;
	}
}
/**
 * Handling KEY UP event
 */
function obj_keyup(){
	var formObject=document.form;
	var sheetObject1=sheetObjects[0];
	/*******************************************************/
	try {
		var srcName=ComGetEvent("name");
		var formObj=document.form;
		var obj=event.srcElement;
		switch(srcName) {
			case "vsl_cd":
				if(!obj || obj.value=="" || ComChkLen(obj.value, 4)!=2){
					break;
				}
				if(formObj.tmp_vsl_cd.value != obj.value){
					sheetObj=sheetObjects[0];
					doActionIBSheet(sheetObj, formObj, SEARCH02);
				}
				//focus change
				obj_nextfocus(event.srcElement);
				break;
			case "voy_no":
				//focus change
				obj_nextfocus(event.srcElement);
				break;		    
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage('VSK00011');
		} else {
			ComShowMessage(e.message);
		}
	}
} 	
// focus change
function obj_nextfocus(obj) {
	var objMaxLength=obj.getAttribute("maxlength");
	var objValue=obj.getAttribute("value");
	if (ComChkLen(objValue, objMaxLength) == 2) {
		ComSetNextFocus(obj);
	}
} 
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
	case 1:      // sheet1 init
	    with(sheetObj){
        
	      var HeadTitle="||Seq.|Port|ETB|ETD|||||||||||||";
	      var headCount=ComCountHeadTitle(HeadTitle);
	      var prefix="sheet1_";
	
	      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
	      InitHeaders(headers, info);
	
	      var cols = [ {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"radio" },
	             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"checkbox" },
	             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vps_port_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:prefix+"vps_etb_dt",     KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:prefix+"vps_etd_dt",     KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"vsl_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"pf_etd_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"pf_eta_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"skd_voy_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"pf_etb_dt",      KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"slan_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"vps_eta_dt",     KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"skd_dir_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"skd_cng_sts_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"init_eta_dt",    KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"init_etb_dt",    KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"init_etd_dt",    KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"clpt_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	       
	      InitColumns(cols);
	
	      SetEditable(1);
	      SetWaitImageVisible(0);
	      SetColProperty(prefix+"vps_etb_dt", {Format:"####-##-## ##:##"} );
	      SetColProperty(prefix+"vps_etd_dt", {Format:"####-##-## ##:##"} );
	      SetColProperty(prefix+"pf_etd_dt", {Format:"####-##-## ##:##"} );
	      SetColProperty(prefix+"pf_eta_dt", {Format:"####-##-## ##:##"} );
	      SetColProperty(prefix+"pf_etb_dt", {Format:"####-##-## ##:##"} );
	      SetColProperty(prefix+"vps_eta_dt", {Format:"####-##-## ##:##"} );
	      SetColProperty(prefix+"init_eta_dt", {Format:"####-##-## ##:##"} );
	      SetColProperty(prefix+"init_etb_dt", {Format:"####-##-## ##:##"} );
	      SetColProperty(prefix+"init_etd_dt", {Format:"####-##-## ##:##"} );
	      
	      SetSheetHeight(342);
      }
      break;


	}
}
// handling sheet process
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH:      //Retrieve
			if(validateForm(sheetObj, formObj, sAction)){
				ComOpenWait(true);
				formObj.f_cmd.value=SEARCH;
				var prefix="sheet1_";	//prefix 
				//alert(FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
				var sXml=sheetObj.GetSearchData("VOP_VSK_0231GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				sheetObj.CheckAll("checkbox",0);
				ComOpenWait(false);
			}
		break;
		case SEARCH01:		//VVD
			//in case VSL_CD is not inputed
			if(formObj.vsl_cd.value.length != 4){
				ComOpenPopup('/opuscntr/VOP_VSK_0219.do', 480, 480, "callBackVslCd", "0,0", true);
			} else{
				targetObjList="sheet1_vsl_slan_cd:vsl_slan_cd|sheet1_vsl_slan_cd:vsl_slan_cd";
				ComOpenPopupWithTarget('/opuscntr/VOP_VSK_0230.do?ctrl_cd=NORL&vsl_cd='+formObj.vsl_cd.value, 340, 480 
									   , "vsl_cd:vsl_cd|skd_voy_no:voy_no|skd_dir_cd:dir_cd"
									   , "0,0", true);            		
			}
		break;
		case SEARCH02: // Vessel Code Retrieve
			//formObj.f_cmd.value = SEARCH;
			ComOpenWait(true);
			formObj.f_cmd.value=COMMAND16;
			var sParam=FormQueryString(formObj);
			sheetObj.SetWaitImageVisible(0);
			//var sXml = sheetObj.getSearchXml("VSK_GLOGS.do?op_=0219", sParam);
			var sXml=sheetObj.GetSearchData("VSK_GLOGS.do", sParam);
			var vsl_eng_nm=ComGetEtcData(sXml, "vsl_eng_nm");
			if(!vsl_eng_nm){ // undefined
	    		ComShowCodeMessage('VSK00021', formObj.vsl_cd.value);
				formObj.tmp_vsl_cd.value="";
				formObj.vsl_cd.value="";
				formObj.vsl_cd.focus();
				return false;
	    	}else{
	    		formObj.tmp_vsl_cd.value=formObj.vsl_cd.value;
	    		formObj.voy_no.focus();
	    	}
			ComOpenWait(false);
			break;
	}
}

function callBackVslCd(rtnObjs) {
	var formObj=document.form;
	var rtnDatas=rtnObjs;
	
	if(rtnObjs[0][1].length > 0){
		formObj.vsl_cd.value=rtnObjs[0][1]; //vessel code
	}
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
	switch(sAction) {
	case IBSEARCH:      //Retrieve
		if(ComIsNull(formObj.vsl_cd.value)){
			ComShowCodeMessage('VSK00027', "Vessel Code");
			formObj.vsl_cd.focus();
			return false;
		}
		if(formObj.voy_no.value.length == 0){
			ComShowCodeMessage('VSK00027', "Voyage No.");
			formObj.voy_no.focus();
			return false;
		}
		if(formObj.dir_cd.value.length == 0){
			ComShowCodeMessage('VSK00027', "Direction Code");
			formObj.dir_cd.focus();
			return false;
		}
		break;
	}
	return true;
}
function sheet1_OnLoadFinish(sheetObj) {
	var formObj=document.form;
	//Retrieve initially
	if(formObj.vsl_cd.value.length == 4
	   && formObj.voy_no.value.length == 4
	   && formObj.dir_cd.value.length == 1){
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	}	
} 
/**
 * Handling Sheet1 OnSearchEnd event
 * @return
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	var rows=sheetObj.SearchRows();
	var prefix="sheet1_";
	if(rows == 0){
		form.vsl_slan_cd.value="";
	} else{
		form.vsl_slan_cd.value=sheetObj.GetCellValue(1, prefix + "slan_cd");
	}
} 
/**
 * Handling Sheet1 OnSelectCell event
 * @return
 */
function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
   /*
	var formObject=document.form;
    if( OldRow != NewRow ){
     	var rows=sheetObj.SearchRows();
    	var prefix="sheet1_";
    	if(rows == 0){
    		form.vsl_slan_cd.value="";
    	} else{
form.vsl_slan_cd.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), prefix + "slan_cd");
    	}    
    }
   */ 
}
/**
 * Handling Enter key event
 * @param sheetObj
 * @param formObj
 * @return
 */
function doSearch(){
	var formObject=document.form;
	doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
}         
