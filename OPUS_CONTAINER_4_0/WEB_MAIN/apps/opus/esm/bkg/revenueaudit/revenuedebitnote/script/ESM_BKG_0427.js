/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0427.js
*@FileTitle  : RDN Status Inquery 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/09
=========================================================*/
// Common global variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1; 
var sheetObjects=new Array();
var sheetCnt=0;
var sheet1;
var comboObjects=new Array();
var comboCnt=0;
var iterator="|$$|";
var arrMultiCombo;
// Event handler processing by button click event */
document.onclick=processButtonClick;
    
/**
 * Event handler processing by button name <br>
 */
function processButtonClick(){
	/* */
	var sheetObject1=sheetObjects[0];
    var sheetObject2=sheetObjects[1];
    /*******************************************************/
    var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
        switch(srcName) {
	        case "btns_calendar1": //
	        	var cal=new ComCalendar();
	        	cal.select(form.rdn_iss_dt_from, 'yyyy-MM-dd');
	        	break;
	        case "btns_calendar2":
		        var cal=new ComCalendar();
		        cal.select(form.rdn_iss_dt_to, 'yyyy-MM-dd');
		        break;
			case "btn_SettledAll":
				settledAll(formObject);
				break;
			case "btn_UnsettledAll":
				unSettledAll(formObject);
				break;
			case "btn_Retrieve":
				doActionIBSheet(sheetObjects[1], formObject, IBSEARCH);
				break;
			case "btn_New":
				removeAll(formObject);
				break;
			case "btn_DownExcel":
				doActionIBSheet(sheetObjects[1],formObject,IBDOWNEXCEL);
				break;
			case "btn_Print":
				//alert(srcName);
				break;
        } // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * registering IBSheet Object as list <br>
 * adding process for list in case of needing batch processing with other items <br>
 * defining list on the top of source <br>
 */ 
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++]=sheet_obj;
}

/**
 * registering IBMulti Combo Object as list <br>
 * adding process for list in case of needing batch processing with other items <br>
 * defining list on the top of source <br>
 */ 
function setComboObject(combo_obj){
	comboObjects[comboCnt++]=combo_obj;
}

/**
 * initializing sheet <br>
 * implementing onLoad event handler in body tag <br>
 * adding first-served functions after loading screen.. <br>
 */
function loadPage() {
	sheet1=sheetObjects[1];
	//initializing IBMultiCombo
    for(var k=0; k < comboObjects.length; k++){
        initCombo(comboObjects[k], k + 1);
    }
	for(i=0;i<sheetObjects.length;i++){
		initSheet(sheetObjects[i],i+1);
		ComConfigSheet (sheetObjects[i] );
		ComEndConfigSheet(sheetObjects[i]);
	}
	axon_event.addListenerForm('keypress', 'obj_keypress', document.form);    		
    axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
    axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
    axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
    initIBComboItem();
}
        
/**
 * OnBeforeActivate   event<br>
 */  
function obj_activate() {
	ComClearSeparator (event.srcElement);	   
}
 
/** 
* Keypress event <br>
* input validation according to dataformat <br>
*/ 
function obj_keypress(){
	var obj=event.srcElement;
 	if(obj.dataformat == null) return;
 	window.defaultStatus=obj.dataformat;
	switch(obj.dataformat){
	 	case "ymd": //date
			ComKeyOnlyNumber(obj,"-"); 
			break;
	 	case "int": //
	 	case "number": // 	
	 		ComKeyOnlyNumber(obj);
	 		break;
	 	case "engup":
	 		ComKeyOnlyAlphabet('upper');
	 		break;
	 	case "uppernum":
	 		ComKeyOnlyAlphabet('uppernum');
	 		break;
	 	default:
	 		//ComKeyOnlyNumber(obj);
	 		break;
	}
}

/** 
 * Onbeforedeactivate event <br>
 * input validation according to dataformat <br>
 */ 
 function obj_deactivate() {
	 var form=document.form;
 	 var formObj=event.srcElement;
     var srcName=formObj.getAttribute("name");
     switch(srcName) {
 		case "rdn_no":
 		case "bl_no":
 			setSearchCond();
 			break;
 		default :
 			ComChkObjValid(formObj);
 			break;
 	}
 }
 
/**
 * initializing IBSHEET COMBO<br>
 */ 
function initCombo(comboObj, comboNo) {
    switch(comboObj.options.id) {
	    case "rct_rhq_cd":
	        var i=0;
	        with(comboObj) {
	        	SetDropHeight(200);
				SetUseAutoComplete(1);
				//no support[check again]CLT 				ValidChar(2, 0);    // English uppercase
				SetMaxLength(6);// 6digits
	        }
	        break;    
	    case "rct_ofc_cd":
	    	var i=0;
	    	with(comboObj) {
	    		SetDropHeight(200);
	    		SetUseAutoComplete(1);
	    		//no support[check again]CLT 				ValidChar(2, 0);    // English uppercase
	    		SetMaxLength(6);// 6digits
	    	}
	    	break;  
	    case "respb_rhq_cd":
	    	var i=0;
	    	with(comboObj) {
	    		SetDropHeight(200);
	    		SetUseAutoComplete(1);
	    		//no support[check again]CLT 				ValidChar(2, 0);    // English uppercase
	    		SetMaxLength(6);// 6digits
	    	}
	        break;      
	    case "respb_ofc_cd":
	    	var i=0;
	        with(comboObj) {
	        	SetDropHeight(200);
	    		SetUseAutoComplete(1);
	    		//no support[check again]CLT 				ValidChar(2, 0);    // English uppercase
	            SetMaxLength(6);// 6digits
	        }
	        break;  
	    case "rev_aud_tool_cd":
	    	var i=0;
	        with(comboObj) {
	        	SetDropHeight(200);
	    		SetUseAutoComplete(1);
	    		//no support[check again]CLT 				ValidChar(1, 2);    // English + special character
	        }
	        break;  
	    case "bkg_ctrt_tp_cd":
	    	var i=0;
	        with(comboObj) {
	        	SetDropHeight(200);
	    		SetUseAutoComplete(1);
	    		//no support[check again]CLT 	ValidChar(2, 2);    // English uppercase + special character
	        }
	        break;  
	    case "umch_tp_cd":
	    	var i=0;
	        with(comboObj) {
	        	SetDropHeight(200);
	    		SetUseAutoComplete(1);
	            //no support[check again]CLT 	ValidChar(2, 2);    // English uppercase + special character
	            SetMultiSelect(1);
	            //no support[check again]CLT 		    comboObj.UseCode=true;
	            //no support[check again]CLT 		 	comboObj.LineColor="#ffffff";
	        	SetColAlign(0, "left");
	        	SetColAlign(1, "left");
	        	SetMultiSeparator(",");
	        }
	        break; 
	    }
}
        
/**
 * returning code value of comboObjects[0]<br>
 */ 
function getRctRhqCd() {
	return comboObjects[0].GetSelectCode();
}

/**
 * returning code value of comboObjects[1]<br>
 */ 
function getRctOfcCd() {
	return comboObjects[1].GetSelectCode();
}

/**
 * returning code value of comboObjects[2]<br>
 */ 
function getRespbRhqCd() {
	return comboObjects[2].GetSelectCode();
}

/**
 * returning code value of comboObjects[3]<br>
 */ 
function getRespbOfcCd() {
	return comboObjects[3].GetSelectCode();
}

/**
 * activating in case of changing rct_rhq_cd combo <br>
 */ 
function rct_rhq_cd_OnChange(comboObj, oldindex, oldtext, oldcode, newindex , text , code) {
	if(rct_rhq_cd.GetSelectIndex()== "0") {
		comboObjects[1].RemoveAll();
		return;
	}
	if(comboObjects[0].GetItemCount () > 0 && comboObjects[0].GetSelectIndex()!= "-1") {
		var formObj=document.form;
		formObj.etc2.value=code;
		setOfcCd1();
	} 
}

/**
 * activating in case of changing respb_rhq_cd combo<br>
 */
function respb_rhq_cd_OnChange(comboObj, oldindex, oldtext, oldcode, newindex , text , code) {
	if(comboObj.GetSelectIndex()== "0") {
		comboObjects[3].RemoveAll();
		return;
	}
	if(comboObjects[2].GetItemCount () > 0 && comboObjects[2].GetSelectIndex()!= "-1") {
		var formObj=document.form;
		formObj.etc2.value=code;
		setOfcCd2();
	} 
}
        
 /**
 * retrieving rct_ofc_cd combo data and setting hidden value<br>
 */
function setOfcCd1() {
	var formObj=document.form;
	// combo2
	formObj.f_cmd.value=COMMAND02;
 	var sXml=sheetObjects[0].GetSearchData("RASCommonGS.do", FormQueryString(formObj));
	ComXml2ComboItem(sXml, rct_ofc_cd, "cd", "cd");
	rct_ofc_cd.InsertItem(0,'','');
}

/**
 * retrieving respb_ofc_cd combo data and setting hidden value.<br>
 */
function setOfcCd2() {
	var formObj=document.form;
	// combo2
	formObj.f_cmd.value=COMMAND02;
	formObj.etc2.value=getRespbRhqCd();
 	var sXml=sheetObjects[0].GetSearchData("RASCommonGS.do", FormQueryString(formObj));
	// combo3
	ComXml2ComboItem(sXml, respb_ofc_cd, "cd", "cd");
	respb_ofc_cd.InsertItem(0,'','');
}
        
 /**
  * setting Item to IBMultiCombo<br>
  */
function initIBComboItem() {
	ComBkgTextCode2ComboItem(rhqComboValue,       rhqComboValue,      getComboObject(comboObjects, 'rct_rhq_cd'),      "|", "\t" );
	ComBkgTextCode2ComboItem(rhqComboValue,       rhqComboValue,      getComboObject(comboObjects, 'respb_rhq_cd'),    "|", "\t" );
	ComBkgTextCode2ComboItem(auditToolComboValue, auditToolComboText, getComboObject(comboObjects, 'rev_aud_tool_cd'), "|", "\t" );
	ComBkgTextCode2ComboItem(contractTypeComboValue, contractTypeComboText, getComboObject(comboObjects, 'bkg_ctrt_tp_cd'),     "|", "\t" );
	ComBkgTextCode2ComboItem(discrepancyKindComboValue, discrepancyKindComboText, getComboObject(comboObjects, 'umch_tp_cd'),      "|", "\t" );
}

 /*
  * initializing
 */
function initCom(formObject){    
	var sXml=ComGetObjValue(formObject.sXml);
	arrMultiCombo=sXml.split(iterator); 
	form.reset();
	comboObj.SetMultiSelect(1);
//no support[check again]CLT 		comboObj.UseCode=true;
//no support[check again]CLT 	 	comboObj.LineColor="#ffffff";
 	comboObj.SetColAlign(0, "left");
 	comboObj.SetColAlign(1, "left");
 	comboObj.SetMultiSeparator(",");
	ComXml2ComboItem(arrMultiCombo[0], formObject.umch_tp_cd, "val", "val|desc");
}
        
/**
 * setting sheet initial values and header <br>
 * adding case as numbers of counting sheets <br>
 */ 
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
    var sheetID=sheetObj.id;
    switch(sheetID) {
 		case "sheet0":      //hidden 
 			with (sheetObj) {
            	// setting Host information[mandatory][HostIp, Port, PagePath]
 				SetVisible(false);
 			}
    	    break; 
 		case "sheet1":      //sheet1 init
 			with(sheetObj){
 				var HeadTitle="|Issue\nOffice|Receipt\nRHQ|Receipt\nOffice|Resp.\nRHQ|Resp.\nOffice|B/L No.|RDN No.|RDN Status|Contract\nType|Contract No.|Error Kind|Error Factor|Error Reason|Error Remarks|USD Amount|C/A No.|Remarks (Auditor)|Remarks (Office)|Audit Tool|Issue Date|Update Date|Issuer ID|Settler ID|Receiver ID|BKG No.";
 				var headCount=ComCountHeadTitle(HeadTitle);
 				(headCount, 0, 0, true);

 				SetConfig( { SearchMode:2, FrozenCol:8, MergeSheet:5, Page:20, DataRowMerge:1 } );

 				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
 				var headers = [ { Text:HeadTitle, Align:"Center"} ];
 				InitHeaders(headers, info);

 				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
 				             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"iss_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 				             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"rct_rhq_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 				             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"rct_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 				             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"respb_rhq_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 				             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"respb_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 				             {Type:"PopupEdit",     Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
 				             {Type:"PopupEdit",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rdn_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
 				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"rdn_sts_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ctrt_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 				             {Type:"PopupEdit",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"sc_rfa_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
 				             {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:1,   SaveName:"umch_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 				             {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:1,   SaveName:"umch_sub_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 				             {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:1,   SaveName:"rdn_iss_rsn_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 				             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"umch_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 				             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"usd_amt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
 				             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bkg_corr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 				             {Type:"Text",      Hidden:0,  Width:310,  Align:"Left",    ColMerge:1,   SaveName:"office_rdn_rmk",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 				             {Type:"Text",      Hidden:0,  Width:310,  Align:"Left",    ColMerge:1,   SaveName:"receiver_rdn_rmk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 				             {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:"rev_aud_tool_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rdn_iss_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"upd_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 				             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"iss_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 				             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"stl_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"receiver_usr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 				             {Type:"Text",      Hidden:0,  Width:95,   Align:"Left",    ColMerge:1,   SaveName:"bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
     	       
 				InitColumns(cols);

     	        SetShowButtonImage(2);
 				SetEditable(1);
 				//nosupport[checkagain]CLTUnEditableColor="#FFFFFF";
     	        FrozenCols=8;
     	      	SetColHidden("bkg_no",1);

       	    	SetSheetHeight(390);
     	    }
 			break;
    }
}

/**
 * handling process for Sheet <br>
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
        case IBCLEAR:
			break;	
    	case IBSEARCH:      //retrieve
    		if (validateForm(sheetObj,formObj,sAction)) {
    			formObj.f_cmd.value=SEARCH01;
	    		ComOpenWait(true);		
	    		sheetObj.SetWaitImageVisible(0);
            			    sheetObj.DoSearch("ESM_BKG_0427GS.do", FormQueryString(formObj) );
            			    sheetObj.SetShowButtonImage(2);
	    		ComOpenWait(false);		
        	}    
    	    break;
    	case IBDOWNEXCEL:
    		if(sheetObj.RowCount() < 1){//no data
				ComShowCodeMessage("COM132501");
	        }else{
	    		sheetObj.Down2Excel({ HiddenColumn:1});
	        }
    		break;    
    }
}

/**
 * handling process for input validation <br>
 */
function validateForm(sheetObj,formObj,sAction){
   	switch (sAction) {
 		case IBSEARCH: // 
	 		var fmDtObj=form.rdn_iss_dt_from;
	 		var toDtObj=form.rdn_iss_dt_to;
	 		var fmDtValue=fmDtObj.value.replace(/-/g, "");
	 		var toDtValue=toDtObj.value.replace(/-/g, "");
	 		var rdnNoObj=form.rdn_no;
	 		var blNoObj=form.bl_no;
	 		var isChkDt=true; 
	 		if(rdnNoObj.value.length > 0 || blNoObj.value.length > 0){
	 			isChkDt=false;
	 		}
    		if(!ComChkObjValid(fmDtObj)) { return false; }
    		if(!ComChkObjValid(toDtObj)) { return false; }
	 		if( "" == fmDtValue && "" == toDtValue && rdnNoObj.value.length == 0 && blNoObj.value.length == 0 ){
				 ComShowCodeMessage("BKG95025", "Date or RDN No or B/L No"); // "Please input {?msg2}."
				 return false;
	 		}
	 		if( isChkDt && ("" == fmDtValue || "" == toDtValue) ){
				 ComShowCodeMessage("BKG95025", "Date"); // "Please input {?msg2}."
				 if("" == fmDtValue){
 					 ComSetFocus(fmDtObj);
				 }else{
 					 ComSetFocus(toDtObj);
				 }
				 return false;
	 		}
 			if( ("" != fmDtValue && "" != toDtValue) && parseInt(fmDtValue,10) > parseInt(toDtValue, 10) ) {
				 ComShowCodeMessage("BKG95026", "From Date", "To Date");
				 ComSetFocus(fmDtObj);
				 return false;
	 		}
 			if(isChkDt) {
 	 			var fromAddDays=ComGetDateAdd(fmDtValue, "D", 364, "", true);
 	 			if( parseInt(toDtValue,10) > parseInt(fromAddDays, 10) ) {
 	 				ComShowCodeMessage("BKG95027", "365 days"); // "The period of Date can't be over {?msg1}."
 	 				ComSetFocus(fmDtObj);
 	 				return false;
 	 			}
	 		}
	   	 	makeInParam(formObj);
			return true;
 			break;
   	 }	
}

/**
 * reset
 */
function removeAll(formObj) {
	formObj.reset();
	comboObjects[0].SetSelectIndex("-1");
	comboObjects[1].RemoveAll();
	comboObjects[2].SetSelectIndex("-1");
	comboObjects[3].RemoveAll();
	sheetObjects[1].RemoveAll();
}

/**
 * checking/unchecking settled, canceled in case of clicking settle all<br>
 */
function settledAll(formObj) {
	formObj.all.checked=false;
	formObj.rdn_sts_check[0].checked=false;
	formObj.rdn_sts_check[1].checked=false;
	formObj.rdn_sts_check[2].checked=false;
	formObj.rdn_sts_check[3].checked=false;
	formObj.rdn_sts_check[4].checked=false;
	formObj.rdn_sts_check[5].checked=true;
	formObj.rdn_sts_check[6].checked=true;
}

/**
 * checking/unchecking ones excepting settled, canceled in case of clicking unsettle all<<br>
 */
function unSettledAll(formObj) {
	formObj.all.checked=false;
	formObj.rdn_sts_check[0].checked=true;
	formObj.rdn_sts_check[1].checked=true;
	formObj.rdn_sts_check[2].checked=true;
	formObj.rdn_sts_check[3].checked=true;
	formObj.rdn_sts_check[4].checked=true;
	formObj.rdn_sts_check[5].checked=false;
	formObj.rdn_sts_check[6].checked=false;
}

/**
 * checking/unchecking ones excepting settled, canceled in case of clicking unsettle all<br>
 */
function checkAll() {
	var formObj=document.form;
	if(formObj.all.checked) {
		formObj.rdn_sts_check[0].checked=true;
 		formObj.rdn_sts_check[1].checked=true;
 		formObj.rdn_sts_check[2].checked=true;
 		formObj.rdn_sts_check[3].checked=true;
 		formObj.rdn_sts_check[4].checked=true;
 		formObj.rdn_sts_check[5].checked=true;
 		formObj.rdn_sts_check[6].checked=true;
	} else {
		formObj.rdn_sts_check[0].checked=false;
 		formObj.rdn_sts_check[1].checked=false;
 		formObj.rdn_sts_check[2].checked=false;
 		formObj.rdn_sts_check[3].checked=false;
 		formObj.rdn_sts_check[4].checked=false;
 		formObj.rdn_sts_check[5].checked=false;
 		formObj.rdn_sts_check[6].checked=false;
	}
}

/**
 * check or uncheck in case of clicking all
 * @param 
 * @return 
 */
function checkItem() {
    var formObj=document.form;
    
    if(formObj.rdn_sts_check[0].checked && formObj.rdn_sts_check[1].checked &&
       formObj.rdn_sts_check[2].checked && formObj.rdn_sts_check[3].checked &&
       formObj.rdn_sts_check[4].checked && formObj.rdn_sts_check[5].checked &&
       formObj.rdn_sts_check[6].checked){
    	formObj.all.checked = true;
    } else {
    	formObj.all.checked = false;
    }
}
/**
 * getting checked status item(seperator - ',') : IS,ST ...<br>
 */
function makeInParam(formObj) {
	var rdn_sts_cd="";
	var cntCheck=0;
	for(var i=0;i<formObj.rdn_sts_check.length;i++){
		 if(formObj.rdn_sts_check[i].checked)
			cntCheck=i;
	}
	for(var i=0;i<formObj.rdn_sts_check.length;i++){
	    if(formObj.rdn_sts_check[i].checked) {
		    rdn_sts_cd=rdn_sts_cd + "'" + formObj.rdn_sts_check[i].value + "'";
		    if(i < (formObj.rdn_sts_check.length-1) && i < cntCheck) {
			    rdn_sts_cd=rdn_sts_cd + ",";
		    }	  
	    }
	}
	formObj.rdn_sts_cd.value=rdn_sts_cd;
}

/** 
 * event after retrieving
 */ 
function sheet1_OnSearchEnd(sheetObj, ErrMsg)
{
	var formObj=document.form;
	var rdn_count=0;
	var rdn_amount_count=0;
	var sum=0;
	var startRow1=sheet1.HeaderRows();
	var endRow1=sheet1.HeaderRows()+ sheet1.RowCount();
	for(var i=startRow1; i < endRow1; i++) {
		sum=parseFloat(sum) + parseFloat(sheetObj.GetCellValue(i,"usd_amt"));
	}
	//total
	rdn_count=sheetObj.GetTotalRows();
	rdn_amount_count=sum;
	formObj.rdn_count.value=ComAddComma(rdn_count);
	formObj.rdn_amount_count.value=ComAddComma(rdn_amount_count);
}

/** 
 * sheet1_OnPopupClick event <br>
 */
function sheet1_OnPopupClick(sheetObj, Row, Col) {
	var form=document.form;
	var colName=sheet1.ColSaveName(Col);
	var scRfaNo=sheet1.GetCellValue(Row, "sc_rfa_no");
	var ctrtTpCd=sheet1.GetCellValue(Row, "ctrt_tp_cd");
	var bkgNo=sheet1.GetCellValue(Row, "bkg_no");
	var rdnNo=sheet1.GetCellValue(Row, "rdn_no");
 	switch(colName) {
		case "sc_rfa_no":
        	if(null == scRfaNo || "" == scRfaNo) { return; }
    		var pgmNo="ESM_PRI_0004";
    		var scRfaNoP=scRfaNo.substr(0, 3);
    		var scRfaNoS=scRfaNo.substr(3);
        	var popParams="sc_no_p=" + scRfaNoP + "&sc_no_s=" + scRfaNoS;
	    	if(ctrtTpCd == "RFA") { // RFA
	    		pgmNo="ESM_PRI_2019";
	    		popParams="s_rfa_no=" + scRfaNo;
	    	}
	    	else if(ctrtTpCd == "TAA") { // TAA
	    		pgmNo="ESM_PRI_3007";
	    		popParams="cond_taa_no=" + scRfaNo;
	    	}
        	comRASCallPop(pgmNo, "ESM_BKG_0427", popParams, "");
		    break;
		case "bl_no":
        	if(null == bkgNo || "" == bkgNo) { return; }
         	var popParams="bkg_no=" + bkgNo + "&openTab=B9";
        	comRASCallPop("ESM_BKG_0079", "ESM_BKG_0427", popParams, "");
			break;
		case "rdn_no":
        	if(null == rdnNo || "" == rdnNo) { return; }
    		var popParams="rdn_no=" + rdnNo;
        	comRASCallPop("ESM_BKG_0712", "ESM_BKG_0427", popParams, "");
			break; 	 	    		
 	}    	 
}

/**                                                                                            
 * onClick event      
 */  
function sheet1_OnClick(sheetObj, Row, Col, Value) {
    //applying MemoPad function in case of clicking desc cell
	var form=document.form;
	var colName=sheet1.ColSaveName(Col);
 	switch(colName) {
    	case "office_rdn_rmk":
    		ComShowMemoPad(sheetObj,Row,Col,true,310,200); 
    		break;
    	case "receiver_rdn_rmk":
    		ComShowMemoPad(sheetObj,Row,Col,true,310,200);
    		break;	
 	}    	 
}

/** 
  * checking search condition
*/ 
function setSearchCond() {
	var form=document.form;
	var rdnNoObj=form.rdn_no;
	var blNoObj=form.bl_no;
	var fmDtObj=form.rdn_iss_dt_from;
	var toDtObj=form.rdn_iss_dt_to;
	var chkValLen=rdnNoObj.value.length + blNoObj.value.length; 
	if(chkValLen > 0){
	    fmDtObj.className="input"; 
	    toDtObj.className="input"; 
	}else{
	    fmDtObj.className="input1"; 
	    toDtObj.className="input1"; 
	}
} 