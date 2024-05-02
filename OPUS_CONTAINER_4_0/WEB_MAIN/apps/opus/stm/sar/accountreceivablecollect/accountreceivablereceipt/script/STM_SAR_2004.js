/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAR_2004.js
*@FileTitle  : Office Code
*@author     : CLT
*@version    : 1.0
*@LastModify : 2014/12/15
*@since      : 2014/08/05
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
              MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
              OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class STM_SAR_2004 : business script for STM_SAR_2004
 */
// common global variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();        
var comboCnt=0;
var gCurRow=0;
var prefix="sheet1_";
var selOfcCds="";

// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	/***** setting sheet object *****/
	var sheetObject1=sheetObjects[0];
	/*******************************************************/
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		//alert("############ window.event.srcElement.getAttribute " + srcName );
		switch (srcName) {
			case "btn_retrieve":
				if(ComIsEmpty(formObj.rct_dt_fm)){
					ComShowCodeMessage("COM130403", "Receipt Date");
					ComSetFocus(formObj.rct_dt_fm);
					break;
				}
				if(ComIsEmpty(formObj.rct_dt_to)){
					ComShowCodeMessage("COM130403", "Receipt Date");
					ComSetFocus(formObj.rct_dt_to);
					break;
				}
				if(formObj.rct_ofc_cd1.value == ""){
					ComShowCodeMessage("COM12113", "Office");
					break;
				}
				doActionIBSheet(sheetObject1, formObj, IBSEARCH);
				break;
			case "btn_new":
				removeAll(formObj);
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC04);
				break;
			case "btn_print":
				break;
			case "btns_calRecFr":
				var cal=new ComCalendar();
				cal.select(form.rct_dt_fm, 'yyyy-MM-dd');
				//cal.select(form.rct_dt_fm, 'yyyyMMdd');
				break;					
			case "btns_calRecTo":
				var cal=new ComCalendar();
				cal.select(form.rct_dt_to, 'yyyy-MM-dd');
				//cal.select(form.rct_dt_to, 'yyyyMMdd');
				break;	
			case "btns_calDepFr":
				var cal=new ComCalendar();
				cal.select(form.rct_dps_dt_fm, 'yyyy-MM-dd');
				break;					
			case "btns_calDepTo":
				var cal=new ComCalendar();
				cal.select(form.rct_dps_dt_to, 'yyyy-MM-dd');
				break;	
			case "btns_search_usrid":
				var rct_dt_fm=formObj.rct_dt_fm.value;
				var rct_dt_to=formObj.rct_dt_to.value;
				var rct_dps_dt_fm=formObj.rct_dps_dt_fm.value;
				var rct_dps_dt_to=formObj.rct_dps_dt_to.value;
				var classId="STM_SAR_0014";
				var param='?fm_rct_dt='+rct_dt_fm+'&to_rct_dt='+rct_dt_to+'&dep_fr_dt='+ rct_dps_dt_fm + '&dep_to_dt='+ rct_dps_dt_to +'&pop_yn=Y&classId='+classId;
				ComOpenPopup('/opuscntr/STM_SAR_0014.do' + param, 600, 530, 'getSTM_SAR_0014', '0,0', true, false);
				break;	
			case "btns_bank":
				if(formObj.rct_ofc_cd1.value == ""){
					ComShowCodeMessage("COM12113", "Office");
					break;
				}
				if(formObj.rct_dt_tp_cd.value == "RECEIPT"){
					var rct_dt_fm=formObj.rct_dt_fm.value;
					var rct_dt_to=formObj.rct_dt_to.value;
					var rct_dps_dt_fm="";
					var rct_dps_dt_to="";
				} else {
					var rct_dt_fm="";
					var rct_dt_to="";
					var rct_dps_dt_fm=formObj.rct_dt_fm.value;
					var rct_dps_dt_to=formObj.rct_dt_to.value;
				}
				var rct_ofc_cd=formObj.rct_ofc_cd.value;
				var rct_sts_cd=formObj.rct_sts_cd.value;
				var rct_unpay_sts_flg="";
				var classId="STM_SAR_0005";
				var param='?ui_type=I&fm_rct_dt='+rct_dt_fm+'&to_rct_dt='+rct_dt_to+'&dep_fr_dt='+ rct_dps_dt_fm + '&dep_to_dt='+ rct_dps_dt_to + '&rct_ofc_cd='+ rct_ofc_cd + '&rct_sts_cd='+ rct_sts_cd + '&rct_unpay_sts_flg='+ rct_unpay_sts_flg + '&pop_yn=Y&classId='+classId;
				ComOpenPopup('/opuscntr/STM_SAR_0005.do' + param, 500, 470, 'getSTM_SAR_0005', '0,0', true, false);
				break;						
			case "btn_downexcel":
				if(sheetObjects[0].RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
				}else{
					sheetObjects[0].Down2Excel({FileName : 'Summary By Date.xlsx'}); 
				}
    	    	break;
			case "btn_multi_office_popup":  
				//--  if  not required :  var param = "";  
				var param=selOfcCds;
				var popupMultiWin=ComOpenPopup('/opuscntr/STM_SAR_0003.do' + param, 400, 650, 'getSTM_SAR_0003', '0,1', true, false);
				//popupMultiWin.focus();
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

function sheet1_OnDownFinish(downloadType, result){
	sheetObjects[1].SetDown2ExcelUrl("/opuscntr/js/ibsheet/jsp/Down2Excel2.jsp");  
	sheetObjects[1].Down2Excel({FileName : 'Summary By Bank.xlsx'});    
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
 * registering IBCombo Object as list
 * param : combo_obj
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
	for(var k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],k+1);
	}	
	initControl();
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC04);
	
	selOfcCds = "?selOfcCds=" + ComReplaceStr(document.form.rct_ofc_cd.value, "'", "");
}
/**
 * loading HTML Control event <br>
 * {@link #loadPage} function call this. so IBSheet Object is initialized. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sequence number in sheetObjects array
 **/
function initControl() {
	//** Date Separator **/
	DATE_SEPARATOR="-";
	var formObj=document.form;
    //handling Axon event. event catch
	//axon_event.addListenerFormat ('keypress', 'obj_keypress', formObj);
	axon_event.addListenerFormat ('focus', 'obj_activate', formObj);
	//axon_event.addListenerForm ('keyup', 'obj_keyup', formObj);
	axon_event.addListenerForm ('blur', 'obj_deactivate', formObj);
	//axon_event.addListenerForm ('change', 'obj_onchange', formObj);
    // object change event
    //axon_event.addListener('change', 'rct_dt_tp_cd_onchange', 'rct_dt_tp_cd', '');
}
//handling Axon event 2
function obj_blur(){
    ComChkObjValid(ComGetEvent());
	var src=ComGetEvent("name")
}
function obj_keypress() {
	switch(ComGetEvent("dataformat")){
		case "engup":
			ComKeyOnlyAlphabet('upper'); 
			break;
		case "engnum":
			ComKeyOnlyAlphabet('uppernum'); 
			break;
		case "num":
        	//only number
			ComKeyOnlyNumber('num');
            break;
		case "int":
			//숫자 만입력하기
			ComKeyOnlyNumber(ComGetEvent(), "-");
			break;
		case "ymd":
			ComKeyOnlyNumber(ComGetEvent());
			break;
		case "float":
			ComKeyOnlyNumber(ComGetEvent(), "-.");
			break;
		default:
			//common standard: recognization only number, english
			ComKeyOnlyAlphabet('upper');
			break;     
	}
	if(event.KeyCode == 13){
		ComSetNextFocus(ComGetEvent());
	}
}    
/** 
 * handling Keypress event of Object  <br>
 * checking validation of input value by dataformat of object  <br>
 */ 
function obj_keyup(){
	var formObj=document.form;
	switch (ComGetEvent("name")) {
		case "rct_dt_fm":
			var condDtFm=ComReplaceStr(ComGetEvent("value"),"-","");
			if (condDtFm.length == 8) {
				formObj.rct_dt_to.focus();
			}
 		break;
		case "rct_dt_to":
			var condDtTo=ComReplaceStr(ComGetEvent("value"),"-","");
			if (condDtTo.length == 8) {
				formObj.rct_curr_cd.focus();
			}
 		break;
	}
}  
/** 
 * handling work javascript OnFocus event  <br>
 */    
function obj_activate() {
   	//delete mask separator
   	switch(ComGetEvent("name")){ 	    	
   		case "rct_dt_fm":
   			ComClearSeparator(ComGetEvent());
//   			ComAddSeparator(obj, "ymd");
   			break;
   		case "rct_dt_to":
   			ComClearSeparator(ComGetEvent());
//   			ComAddSeparator(obj, "ymd");
   			break;
   	}
   	event.srcElement.select();
}
/** 
 * handling work javascript OnBlur event  <br>
 */    
function obj_blur(){
	 ComChkObjValid(ComGetEvent());
}    
/**
 * HTML Control의 onfocus이벤트에서 마스크 구분자를 살려주며. Validate를 체크하여준다.
 **/
function obj_deactivate(){
	ComAddSeparator(form.rct_dt_fm, "ymd");
	ComAddSeparator(form.rct_dt_to, "ymd");
	switch(ComGetEvent("name")){
		case "rct_dt_fm":
			ComChkObjValid(ComGetEvent());
//			ComAddSeparator(obj, "ymd");
			break;
		case "rct_dt_to":
//			ComAddSeparator(obj, "ymd");
			ComChkObjValid(ComGetEvent());
			break;
		case "rct_amt1":
			ComChkObjValid(ComGetEvent());
			break;
		case "rct_amt2":
			ComChkObjValid(ComGetEvent());
			break;
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
	case 1: //t1sheet1 init
	    with(sheetObj){
			var HeadTitle1="|Office|Bank|Date|Currency|Receipt\nAmout|Unapplied\nAmount|Unidentified\nAmount|Cancel\nAmount|Refund\nAmount";
			var headCount=ComCountHeadTitle(HeadTitle1);
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

			var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rct_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"bank_acct_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rct_or_dps_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rct_curr_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:150,  Align:"Right",   ColMerge:1,   SaveName:"rct_amt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:150,  Align:"Right",   ColMerge:1,   SaveName:"una_amt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:150,  Align:"Right",   ColMerge:1,   SaveName:"uni_amt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:150,  Align:"Right",   ColMerge:1,   SaveName:"bou_amt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:150,  Align:"Right",   ColMerge:1,   SaveName:"ref_amt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
       
			InitColumns(cols);
			SetSheetHeight(200);//360;
			SetEditable(1);
            SetColProperty("rct_or_dps_dt", {Format:"####-##-##"} );
      	}
	    break;
	case 2: //t1sheet1 init
	    with(sheetObj){
			var HeadTitle1="|Office|Bank|Currency|Receipt\nAmout|Unapplied\nAmount|Unidentified\nAmount|Cancel\nAmount|Refund\nAmount";
			var headCount=ComCountHeadTitle(HeadTitle1);
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

			var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rct_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:1,   SaveName:"bank_acct_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rct_curr_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:150,  Align:"Right",   ColMerge:1,   SaveName:"rct_amt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:150,  Align:"Right",   ColMerge:1,   SaveName:"una_amt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:150,  Align:"Right",   ColMerge:1,   SaveName:"uni_amt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:150,  Align:"Right",   ColMerge:1,   SaveName:"bou_amt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:150,  Align:"Right",   ColMerge:1,   SaveName:"ref_amt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
       
			InitColumns(cols);
			//SetSheetHeight(180);//360;
			resizeSheet();
			SetEditable(1);
        }
	    break;   
	}
}
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	var sheetID=sheetObj.id;
	var prefix=sheetID + "_";
	switch (sAction) {	
		case IBSEARCH_ASYNC01: 
			//retrieve login AR Office	
			formObj.f_cmd.value=SEARCH03;
			var sXml=sheetObj.GetSearchData("SARCommonGS.do", FormQueryString(formObj));
			var sStr=ComGetEtcData(sXml,"ots_ofc_cd");
			var arrStr=sStr.split("|");
			var arrStr2=arrStr[1].split("^");
			formObj.rct_ofc_cd.value="'" + arrStr2[1] + "'";
			formObj.rct_ofc_cd1.value="'" + arrStr2[1] + "'";
			//retrieve Receipt Type List
			var arrStr=SarGetComboItems(sheetObj, "RECEIPT TYPE");
			MakeRctTypeComboObject(rct_tp_cd, arrStr);
			//retrieve Local Time
			formObj.f_cmd.value=SEARCH07;
			var sXml=sheetObj.GetSearchData("SARCommonGS.do", FormQueryString(formObj));
			var sStr=ComGetEtcData(sXml,"lcl_time");
			formObj.rct_dt_fm.value=ComGetMaskedValue(sStr, "ymd");
			formObj.rct_dt_to.value=ComGetMaskedValue(sStr, "ymd");
			break;
			
		case IBSEARCH_ASYNC04: 
			formObj.f_cmd.value = SEARCH08;
			var sXml = sheetObj.GetSearchData("SARCommonGS.do", FormQueryString(formObj));
			var sStr = ComGetEtcData(sXml,"curr_cd_list");
			var arrStr = sStr.split("|");
			
			MakeCurrComboObject(rct_curr_cd, arrStr);
			break;		
		case IBSEARCH: //retrieve
			sheetObj.WaitImageVisible=false;
			ComOpenWait(true); 
			setTimeout( function () { 
				formObj.f_cmd.value=SEARCH;
				var sheetObject1=sheetObjects[0];
				var sheetObject2=sheetObjects[1];
				var sXml=sheetObj.GetSearchData("STM_SAR_2004GS.do", FormQueryString(formObj));
				var arrXml=sXml.split("|$$|");
				sheetObject1.LoadSearchData(arrXml[0],{Sync:1} );
				sheetObject2.LoadSearchData(arrXml[1],{Sync:1} );
				ComOpenWait(false); 
		    } , 100); 			
            break;
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
		case IBSEARCH: //retrieve
			formObj.rct_dt_fm.value=ComReplaceStr(formObj.rct_dt_fm,"-","");
			formObj.rct_dt_to.value=ComReplaceStr(formObj.rct_dt_to,"-","");
            /*
			if(formObj.ofc_cd.value == ""){
				ComShowCodeMessage("COM12113", "Office");
				ComSetFocus(document.all.item("ofc_cd"));
				return false;
			}
			*/
/*
			if(formObj.rct_dt_fm.value == ""){
				ComShowCodeMessage("COM12113", "From Receipt Date");
				ComSetFocus(document.all.item("rct_dt_fm"));
				return false;
			}
			if(formObj.rct_dt_to.value == ""){
				ComShowCodeMessage("COM12113", "To Receipt Date");
				ComSetFocus(document.all.item("rct_dt_to"));
				return false;
			}
			var frDt1=ComReplaceStr(formObj.rct_dt_fm,"-","");
			var toDt1=ComReplaceStr(formObj.rct_dt_to,"-","");
			if (ComGetDaysBetween(frDt1, toDt1) < 0){
				ComShowCodeMessage("COM132002");
				formObj.rct_dt_to.focus();
				return false;
			}
			*/
			break;
	}
	return true;
}
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	//if combined data
	for (var i=sheetObj.HeaderRows(); i<= sheetObj.LastRow(); i++){
		}
}
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var sName=sheetObj.ColSaveName(Col);
	var formObj=document.form;
}
function rct_dt_tp_cd_onchange(){
	var frm=document.form;
    var rctDtTpCd=ComGetObjValue(frm.rct_dt_tp_cd);
    if (rctDtTpCd == "RECEIPT"){
    	frm.rct_dps_dt_fm.value="";
    	frm.rct_dps_dt_to.value="";
    	ComEnableObject(frm.rct_dt_fm, true);	
    	ComEnableObject(frm.rct_dt_to, true);	
    	ComEnableObject(frm.rct_dps_dt_fm, false);	
    	ComEnableObject(frm.rct_dps_dt_to, false);
    } else {
    	frm.rct_dt_fm.value="";
    	frm.rct_dt_to.value="";
    	ComEnableObject(frm.rct_dt_fm, false);
    	ComEnableObject(frm.rct_dt_to, false);	
    	ComEnableObject(frm.rct_dps_dt_fm, true);	
    	ComEnableObject(frm.rct_dps_dt_to, true);
    }
}
/** 
 * init combo<br>
 * <br><b>Example :</b>
 * <pre>
 * 
 * </pre>
 * @param {IBMultiCombo} comboObj  comboObj
 * @return none
 * @see #
 * @author SHIN
 * @version 2014 04 02 
 */
	function initCombo(comboObj, comboNo) {
		switch (comboObj.id) {
		/*
			case "rct_tp_cd":
				with (comboObj) {
					InsertItem(0, "Unapplied", "Unapplied");
		            InsertItem(1, "Cancel",    "C");
		            InsertItem(2, "BTR",       "BTR");
		            Code="BTR";
		    		SetMultiSelect(0);
		    		//LineColor = "#ffffff";
		    		SetColAlign(0, "left");
		    		SetMultiSeparator(",");
		    		SetDropHeight(190);
				}
			break;
		*/
			case "rct_curr_cd":
				with (comboObj) {
		        	SetDropHeight(200);
		 			SetMultiSelect(0);
		 			//UseAutoComplete = true;
		 			//MaxSelect = 1;
		 			SetColAlign(0, "left");
				    SetColWidth("70");
				}
	        break;	
		}
	}
	/** 
	 * call method when select event on popup(FNS_INV_0086)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {array} rowArray   
	 * @return none
	 * @see #
	 * @author SHIN
	 * @version 2014.04.03
	 */
	function getSTM_SAR_0014(rowArray) {
		var formObj=document.form;
		var colArray=rowArray[0];
		formObj.rct_usr_id.value=colArray[1];
		
	}	
	/** 
	 * call method when select event on popup(STM_SAR_0005)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {array} rowArray   
	 * @return none
	 * @see #
	 * @author SHIN
	 * @version 2014.04.03
	 */
	function getSTM_SAR_0005(rowArray) {
		var colArray= rowArray[0];
		var formObj=document.form;
		
		if (colArray != "")
				{
					//colArray = rowArray[0];
					formObj.bank_acct_name.value=colArray[1];
				}
		formObj.bank_acct_seq.value=colArray[5];	
			
	}
	/** 
	 * call method when select event on popup(STM_SAR_0003)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {array} rowArray   
	 * @return none
	 * @see #
	 * @author SHIN
	 * @version 2014.04.03
	 */
	function getSTM_SAR_0003(data) {
	    // 반환 index 
		 //      data[0 ] =  ibflag
		 //  data[1 ] =  checkbox
		 //  data[2 ] =  OTS_OFC_CD   
		 //  data[3 ] =  ofc_brnc_agn_tp_cd
		 //  data[4 ] =  rhq_cd           
		 //  data[5 ] =  ar_curr_cd
		 //  data[6 ] =  ots_smry_cd
		 //  data[7 ] =  dp_prcs_knt
		 //  data[8 ] =  bank_ctrl_cd
		 //  data[9 ] =  ofc_entr_lvl_cd
		 //  data[10] =  ar_ofc_cd
		 //  data[11] =  ots_cd
		 //  data[12] =  rct_tp_cd
		 //  data[13] =  rep_ots_ofc_cd
		 //  data[14] =  rct_unapy_flg
		//alert("000000000000000");  
	    var multiOfcCd="";
	    selOfcCds = "";
	    
	    for(var i=0; i < data.length; i++) {
	        var row=data[i];
	        if (i > 0 ) {        	
	        	multiOfcCd +=  " , '" + row[2] +"'";
	        	selOfcCds +=  "&selOfcCds=" + row[2];
	        } else {
	        	multiOfcCd +=  "'" + row[2] +"'";
	        	selOfcCds +=  "?selOfcCds=" + row[2];
	        }    
	    }
	    var frm=document.form;
	    frm.rct_ofc_cd.value=multiOfcCd;
	    frm.rct_ofc_cd1.value=multiOfcCd;
	    //alert("frm.rct_ofc_cd.value= " + frm.rct_ofc_cd.value + "  , selOfcCds = "+ selOfcCds);
	}	
/**
	 * create combo box<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    MakeRctOfcComboObject(cmbObj, arrStr);
	 * </pre>
	 * @param object cmbObj
	 * @param String arrStr
	 * @author SHIN
	 * @version 2014.04.03
	 */
	function MakeRctOfcComboObject(cmbObj, arrStr) {
		for (var i=1; i < arrStr.length; i++ ) {
			var arrStr2=arrStr[i].split("^");
			var rct_ofc_cd=arrStr2[0];
			cmbObj.InsertItem(i-1, rct_ofc_cd, arrStr[i]);			 
		}
		cmbObj.SetDropHeight(190);
	} 
	/**
	 * create combo box<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    MakeRctTypeComboObject(cmbObj, arrStr);
	 * </pre>
	 * @param object cmbObj
	 * @param String arrStr
	 * @author Park sung yong
	 * @version 2014.03.24
	 */
	function MakeRctTypeComboObject(cmbObj, arrStr) {
		cmbObj.RemoveAll();
		for (var i=0; i < arrStr.length; i++ ) {
			var arrStr2=arrStr[i].split("=");
			cmbObj.InsertItem(i, arrStr2[0], arrStr2[0]);			 
		}
		cmbObj.SetDropHeight(190);
	}
	/**
	 * create combo box<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    MakeCurrComboObject(cmbObj, arrStr);
	 * </pre>
	 * @param object cmbObj
	 * @param String arrStr
	 * @author Lee Yong Jun
	 * @version 2014.03.24
	 */
	function MakeCurrComboObject(cmbObj, arrStr) {
		for (var i = 1; i < arrStr.length; i++ ) {
			var arrStr2 = arrStr[i].split("^");
			var curr_cd = arrStr2[0];
			cmbObj.InsertItem(i-1, curr_cd, arrStr[i]);			 
		}

		cmbObj.SetDropHeight(190);
	}
	
	/** 
	 * Initialize screen.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {object} formObj  
	 * @return none.
	 */
	function removeAll(formObj) {
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
		var formObj=document.form;
		formObj.reset();
		sheetObject1.RemoveAll();
		sheetObject2.RemoveAll();
		comboObjects[0].RemoveAll();
		doActionIBSheet(sheetObject1, document.form, IBSEARCH_ASYNC01);
	}
	
	function resizeSheet(){
		ComResizeSheet(sheetObjects[1]);
	}