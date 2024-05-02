/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EES_MNR_0238.js
*@FileTitle : MNR PFMC by Work Order
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/20
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
						MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
						OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class EES_MNR_0238 : business script for EES_MNR_0238.
 */
function EES_MNR_0238() {
	this.processButtonClick=tprocessButtonClick;
	this.setSheetObject=setSheetObject;
	this.loadPage=loadPage;
	this.initSheet=initSheet;
	this.initControl=initControl;
	this.doActionIBSheet=doActionIBSheet;
	this.setTabObject=setTabObject;
	this.validateForm=validateForm;
}
// common global variables
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;       
var uTpSz=new Array();    
var gTpSz=new Array();  
var zTpSz=new Array(); 
var selComboIndex=0;
var selComboCode="";
//Event handler processing by button click event */
document.onclick=processButtonClick;
//Event handler processing by button name */
function processButtonClick() {
	var sheetObject=sheetObjects[0];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch(srcName) {
		case "btn_Retrieve":
			doActionIBSheet(sheetObject,formObject,IBSEARCH);
			break;
		case "btn_New":
			doActionIBSheet(sheetObject,formObject,IBCLEAR);
			break; 		            
		case "btn_DownExcel":
			doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
			break;
		case "btn_calendar": 
			var cal=new ComCalendarFromTo();		
			cal.select(formObject.fm_dt, formObject.to_dt, 'yyyy-MM-dd');       						
			break;	  	 
		case "btn_provider_popup":
			ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 700, 550, 'setPopData_Sp', '1,0,1,1,1,1,1,1', true);
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
 * registering IBCombo Object as list
 * @param	{IBMultiCombo}	combo_obj	adding ComboObject. 
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */ 
function setComboObject(combo_obj){    
	comboObjects[comboCnt++]=combo_obj;  
} 
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	initControl(); 
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}		
	//initializing IBMultiCombo 	
	for(var k=0;k<comboObjects.length;k++){ 
		initCombo(comboObjects[k],k + 1);  
	}			
	// initializing type size		
	setTpSzArray(sheetObjects[0]);  
	doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
}
/**   
 * setting combo basic info    
 * @param	{IBMultiCombo}	combo_obj	ComboObject. 
 * @param	{Number}	comboNo		ComboObject tag serial number 
 * adding case as numbers of counting combos 
 */	     
function initCombo (comboObj, comboNo) {        
	var formObject=document.form
	switch(comboNo) {	          	    
		case 1: 
			with (comboObj) {						
				SetMultiSeparator("|");
				SetTitle("Period|Amount");
				SetColAlign(0, "left");
				SetColAlign(1, "left");
				SetColWidth(0, "100");
				SetColWidth(1, "0");
				SetDropHeight(160);
				SetUseAutoComplete(1);
			}        
			break; 
		case 2: 
			with (comboObj) { 
				SetColAlign(0, "left");
				SetColWidth(0, "80");
				SetDropHeight(160);
				SetUseAutoComplete(1);
			}          
			break; 
		case 3: 
			with (comboObj) { 
				SetMultiSelect(1);
				SetUseAutoComplete(1);
				SetColAlign(0, "left");
				SetColWidth(0, "230");
				SetDropHeight(200);
			}      
			break;
		case 4: 
			with (comboObj) { 
				SetMultiSeparator("|");
				SetTitle("Office Code|Office Name");
				SetColAlign(0, "left");
				SetColAlign(1, "left");
				//SetColWidth("100|150");     
				SetDropHeight(160);
				SetUseAutoComplete(1);
				SetTitleVisible(1);
				SetMaxLength(6);
				ValidChar(2);
			}      
			break;
		case 5:	 		 
			with (comboObj) { 
				SetMultiSeparator("|");
				SetTitle("Code|Country Name");
				SetColAlign(0, "left");
				SetColAlign(1, "left");
				//SetColWidth("100|150");	     
				SetDropHeight(160);
				SetUseAutoComplete(1);
				SetTitleVisible(1);
				ValidChar(2);
			}      
			break;		
		case 6: 
			with (comboObj) { 
				SetMultiSelect(1);
				SetMultiSeparator(",");
				SetTitle("Office Code|Office Name");
				SetColAlign(0, "left");
				SetColAlign(1, "left");
				//SetColWidth("100|150");
				SetDropHeight(160);
				SetUseAutoComplete(1);
				SetMaxLength(600);
				SetTitleVisible(1);
				ValidChar(2,3);
			} 	 	    
			break;		
		 case 7:	
		 	with (comboObj) {			 	
				SetMultiSelect(1);
				SetUseAutoComplete(1);
				SetColAlign(0, "left");
				SetColWidth(0, "180");
				SetDropHeight(200);
			}	
			break;	
	} 
}     
function resizeSheet( sheetObj ){
    ComResizeSheet( sheetObj );
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch(sheetID) {
	case "sheet1":
	    with(sheetObj){				 
			  var HeadTitle="|Seq.|RHQ|Country|Office|S/P Code|S/P Name|Account\nCode|W/O Type|Cost Type|Cost Detail|TP/SZ|Hanger Bar\nType|Reefer Parts\nType|Part No.|VVD|Yard|QTY|Hanger Bar\nQTY|CURR|Total AMT|Average\nAMT";
			  var headCount=ComCountHeadTitle(HeadTitle)
			
			  SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
			
			  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			  var headers = [ { Text:HeadTitle, Align:"Center"} ];
			  InitHeaders(headers, info);
			
			  var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"hdnStatus" },
			 {Type:"Seq",       Hidden:0, Width:105,   Align:"Rigth",    ColMerge:1,   SaveName:"Seq",                 KeyField:0,   CalcLogic:"",   Format:"" },
			 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rhq",                 KeyField:0,   CalcLogic:"",   Format:"" },
			 {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"cnt_nm",              KeyField:0,   CalcLogic:"",   Format:"" },
			 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cost_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"" },
			 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"vndr_seq",            KeyField:0,   CalcLogic:"",   Format:"" },
			 {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:0,   SaveName:"vndr_seq_nm",         KeyField:0,   CalcLogic:"",   Format:"" },
			 {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"acct_cd",             KeyField:0,   CalcLogic:"",   Format:"" },
			 {Type:"Text",      Hidden:0,  Width:85,   Align:"Left",    ColMerge:0,   SaveName:"mnr_wo_tp_nm",        KeyField:0,   CalcLogic:"",   Format:"" },
			 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"cost_nm",             KeyField:0,   CalcLogic:"",   Format:"" },
			 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"cost_dtl_nm",         KeyField:0,   CalcLogic:"",   Format:"" },
			 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"eq_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"" },
			 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"mnr_hngr_bar_tp_nm",  KeyField:0,   CalcLogic:"",   Format:"" },
			 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"spr_prt_ut_tp_nm",    KeyField:0,   CalcLogic:"",   Format:"" },
			 {Type:"Text",      Hidden:0,  Width:100,   Align:"Left",    ColMerge:0,   SaveName:"spr_prt_no",          KeyField:0,   CalcLogic:"",   Format:"" },
			 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"vsl_vvd",             KeyField:0,   CalcLogic:"",   Format:"" },
			 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"spr_prt_spl_yd_cd",   KeyField:0,   CalcLogic:"",   Format:"" },
			 {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"qty",                 KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
			 {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"hqty",                KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
			 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",             KeyField:0,   CalcLogic:"",   Format:"" },
			 {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"amt",                 KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
			 {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"avg_amt",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 } ];
			   
			  InitColumns(cols);
			  SetEditable(0);
			  sheetObj.ShowSubSum([{StdCol:"mnr_wo_tp_nm", SumCols:"17|18|20", Sort:false, ShowCumulate:false, CaptionCol: 1, CaptionText:"%s : %col" }]);              
//			  SetSheetHeight(390);
			  resizeSheet( sheetObj );
			  }
	    break;
	}
}
// handling process for sheet
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH:      //retrieving
			if(validateForm(sheetObj,formObj,sAction)){
				if (sheetObj.id == "sheet1"){
					formObj.f_cmd.value=SEARCH;     	
					if(formObj.check_usd_only.checked){
						formObj.curr_cd.value="Y";
					} else {
						formObj.curr_cd.value="N";
					}
					sheetObj.DoSearch("EES_MNR_0238GS.do",FormQueryString(formObj) );
				}
			}
			break;	
		case IBCLEAR:        //initializing
			MnrWaitControl(true);
			sheetObj.SetWaitImageVisible(0);
			//initializing sheet   
			for(i=0;i<sheetObjects.length;i++){   
				sheetObjects[i].RemoveAll();
			}  
			//initializing combo
			for(var i=0; i < comboObjects.length;i++){ 
				comboObjects[i].RemoveAll();
			}  			
			//retrieving common combo.    
			var sCondition=new Array (	 
					new Array("MnrGenCd","CD00091", "COMMON"), 	//Period
					new Array("MnrGenCd","","CUSTOM9"), 		//EQ Type  
					new Array("MdmOrganization","RHQ","FALSE"), //Regional HQ  
					new Array("MnrGenCd","CD00020", "COMMON") 	//MNR_WO_TP_CD
			)		
			var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
			//EQ Type   
			eq_type.InsertItem(0,"ALL","A"); 
			//Regional HQ  
			rhq.InsertItem(0,"ALL","A");
			//MNR_WO_TP_CD
			mnr_wo_tp_cd.InsertItem(0,"ALL","A");
			for(var i=0;i<comboList.length;i++)
			{	
				if(comboList[i] != null){        
					for(var j=0; j < comboList[i].length;j++){  
						var tempText=comboList[i][j].split("|");  
						if(i==0){
							var codeAmt=tempText[1].replace("=","|");
							report_period_type.InsertItem(j,codeAmt ,tempText[0]);
						}else if(i==1){
							eq_type.InsertItem(j + 1,tempText[1] ,tempText[0]);
						}else if(i==2){
							rhq.InsertItem(j + 1,comboList[i][j] ,tempText[0]);
						}else if(i==3){
							mnr_wo_tp_cd.InsertItem(j + 1,tempText[1] ,tempText[0]);
						}	
					}  	   
				}	  
			}	
			//setting default value 	
			report_period_type.SetSelectCode("WI");
			eq_type.SetSelectCode("A");
			rhq.SetSelectCode("A");
			tp_sz_cd.SetEnable(0);
			formObj.fm_dt.value=ComGetDateAdd(ComGetNowInfo("ymd"), "M", -1);
			MnrSetFromDate(formObj.fm_dt);		
			formObj.to_dt.value=ComGetNowInfo();
			formObj.vndr_seq.value=""; 	
			formObj.vndr_lgl_eng_nm.value=""; 	
			sheetObj.SetWaitImageVisible(1);
			MnrWaitControl(false);  				
			break;
		case IBDOWNEXCEL:
			if(sheetObj.RowCount() < 1){//no data
 				ComShowCodeMessage("COM132501");
 			}else{
 				sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1, AutoSizeColumn:1 });
 				} 					
			break;	 
		case IBSEARCH_ASYNC01:	//retrieving(in case of existing sevice provider No.)
			if ( validateForm(sheetObj, formObj, sAction) ) { 
				//retrieving service provider     	
				var sCondition=new Array ( 	 
						new Array("MdmVendor",formObj.vndr_seq.value,"COMMON")
				)                             
				//setting in case of existing retrieving result
				var comboList=MnrComSearchCombo(sheetObjects[0],sCondition); 
				if(comboList[0] != null){  
					var tempText=comboList[0][0].split("|");  
					formObj.vndr_lgl_eng_nm.value=tempText[1];   
				} else {        
					ComShowCodeMessage("MNR00005", "Service Provider");              
					ComSetObjValue(formObj.vndr_lgl_eng_nm, "");  
					ComSetObjValue(formObj.vndr_seq, "");   
					ComSetFocus(formObj.vndr_seq);  
				}  
			}	
			break;	
	}
}
/**
* handling after retrieving
*/			
function sheet1_OnSearchEnd(sheetObj, ErrMsg){ 
//	sheetObj.ShowSubSum([{StdCol:"mnr_wo_tp_nm", SumCols:"17|18|20", Sort:true, ShowCumulate:false, CaptionCol:-1, CaptionText:"avg_amt=(|amt|/(|qty|+|hqty|))"}]);
//	sheetObj.ShowSubSum([{StdCol:"mnr_wo_tp_nm", SumCols:"17|18|20|21", Sort:false, ShowCumulate:false, CaptionCol:1, CaptionText:"SubTotal"}]);  
	
	var aFloat=parseFloat(sheetObj.GetSumValue(0,"amt") + "");
	var bFloat=parseFloat(sheetObj.GetSumValue(0,"qty") + sheetObj.GetSumValue(0,"hqty"));
	var avgFloat=0;		
	if(bFloat != 0){			
			avgFloat = MnrMakeRound((aFloat / bFloat),2);
	}				  	
	sheetObj.SetSumValue(0,"avg_amt",avgFloat);
	
	var subSumRow = sheetObj.FindSubSumRow();
	var arrRow = subSumRow.split("|");
	
	for(var i = 0; i < arrRow.length; i++){
		var row = parseInt(arrRow[i]);
		var avgValue = sheetObj.GetCellValue(row, "amt")/(sheetObj.GetCellValue(row, "qty")+sheetObj.GetCellValue(row, "hqty"));
		avgValue = MnrMakeRound(avgValue, 2);
//		sheetObj.SetRangeFontColor(row, 0, row, sheetObj.LastCol(), "#000000");
		sheetObj.SetCellValue(row, "avg_amt", avgValue);
	}
	
	sheetObj.SetSumBackColor("#FFA7A7");
    sheetObj.SetSumFontColor("#000000");
    sheetObj.SetSumText( 0,1,"TOTAL");	
}
/**  
 * rhq Change event		      
 * @param {IBMultiCombo}  comboObj ComboObject  
 * @param  {String}    Index_Code   Index or Code
 * @param  {String}    Text
 */  	
//function rhq_OnChange(comboObj,Index_Code, Text){
function rhq_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	form.rhq_text.value = comboObj.GetText(parseInt(newIndex), 0);
	var formObj=document.form;  
	country.RemoveAll(); 	 		    
	var sCondition=new Array (
			new Array("MdmOrganization", "COUNTRY", newCode)   //Office	
		); 		  
	var comboList=MnrComSearchCombo(sheetObjects[0], sCondition);
	country.InsertItem(0, "ALL" , "A");		
	if(comboList[0] != null){
		for(var i=0; i < comboList[0].length;i++){ 
			var code=comboList[0][i].substring(0, comboList[0][i].indexOf('|') );
			country.InsertItem(i + 1, comboList[0][i] , code);			   
		}
	}
	country.SetSelectCode("A");
}  	
/**  
 * country Change event		      
 * @param {IBMultiCombo}  comboObj ComboObject  
 * @param  {String}    Index_Code   Index or Code
 * @param  {String}    Text
 */  	
//function country_OnChange(comboObj,Index_Code, Text){	
function country_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	var formObj=document.form;			 
	ofc_cd.RemoveAll();          
	var sCondition=new Array (				
			new Array("MdmOrganization","OFCBYCOUNTRY",newCode + ',' + rhq.GetSelectCode())   //Office
		);			 			   
	var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
	ofc_cd.InsertItem(0, "ALL" , "A");
	if(comboList[0] != null){	
		for(var i=0; i < comboList[0].length;i++){ 
			var code=comboList[0][i].substring(0, comboList[0][i].indexOf('|') );
			ofc_cd.InsertItem(i + 1, comboList[0][i] , code);			   
		}				
	}	
	if(country.GetSelectCode()== 'A' && rhq.GetSelectCode()== 'A'){
		//formObj.ofc_cd.enable=false; 
		ofc_cd.SetEnable(0)
	} else {
		//formObj.ofc_cd.enable=true;  
		ofc_cd.SetEnable(1)
	}					 					 
}  	

function mnr_wo_tp_cd_OnSelect(comboObj ,index, code) {
    selComboIndex = index;
    selComboCode = code;
}
function mnr_wo_tp_cd_OnChange(comboObj) {
    ComSetMultiCombo(comboObj, selComboIndex, selComboCode);
}

function tp_sz_cd_OnSelect(comboObj ,index, code) {
    selComboIndex = index;
    selComboCode = code;
}
function tp_sz_cd_OnChange(comboObj) {
    ComSetMultiCombo(comboObj, selComboIndex, selComboCode);
}

function ofc_cd_OnSelect(comboObj ,index, code) {
    selComboIndex = index;
    selComboCode = code;
}
function ofc_cd_OnChange(comboObj) {
    ComSetMultiCombo(comboObj, selComboIndex, selComboCode);
}

/**  
 * combo_eq_type_cd Change event      
 * @param {IBMultiCombo}  comboObj ComboObject  
 * @param  {String}    Index_Code   Index or Code
 * @param  {String}    Text
 */  
//function eq_type_OnChange(comboObj,Index_Code, Text){ 
function eq_type_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	var formObj=document.form;        
	var comboValue=comboObj.GetSelectCode();
	form.eq_type_text.value = comboObj.GetText(parseInt(newIndex), 0);
	tp_sz_cd.RemoveAll();
	var selTpSz=new Array();
	if(comboValue == "U"){
		selTpSz=uTpSz;  	
	} else if(comboValue == "G"){
		selTpSz=gTpSz; 
	} else if(comboValue == "Z"){
		selTpSz=zTpSz;   
	}  	
	//setting default 'ALL'
	if(selTpSz.length == 0){
		tp_sz_cd.SetEnable(0);//tp_sz_cd
	}else{
		tp_sz_cd.SetEnable(1);//tp_sz_cd
		tp_sz_cd.InsertItem(0,"ALL","A");   		
		for(var i=1;i < (selTpSz.length + 1);i++){               
			tp_sz_cd.InsertItem(i, ComReplaceStr(selTpSz[i - 1],"^"," - ") , selTpSz[i - 1]); 			
		}
	}
} 
/**
 * getting rep_Multiful_inquiry  
 *           
 * Location : in case of Single choice     
 */      
function getMnr_Multi(rowArray,ret_val) {
	var formObj=document.form;  
	var tempText=""; 	
	//initializing	   
	formObj.eq_list.value=''; 	
	for(var i=0; i<rowArray.length; i++) {   
		var colArray=rowArray[i];     
		tempText +=  rowArray[i] + ','; 	  
	}      
	//clearing comma(,)     
	tempText=MnrDelLastDelim(tempText);	 
	tempText=tempText.toUpperCase(); 	    
	eval("document.form." + ret_val + ".value='" + tempText + "';"); 
}      	
function setTpSzArray(sheetObj){ 
	var arrXml=MnrComSearchGrid(sheetObj,"type_size_search_ind");
	if(arrXml != null){          
		for(var i=0; i < arrXml.length; i++){   
			if(i == 0){	       
				uTpSz=MnrXmlToOneDimArray(arrXml[i], "cd_id");    	
			} else if(i == 1){	  
				zTpSz=MnrXmlToOneDimArray(arrXml[i], "cd_id");  
			} else if(i == 2){	    
				gTpSz=MnrXmlToOneDimArray(arrXml[i], "cd_id");       	
			}	  	 
		}  	 
	}				
} 	   
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		if(sAction==IBSEARCH) {	  	    
			if (!ComChkValid(formObj)) return false; 
			if(!MnrChkFromDate(formObj.fm_dt)) return false;
		}  
	}
	return true;
}
/**
 * (Service Provider) handling Pop-up Return Value<br>
 * @param {arry} Return value array of returnedValues Pop-up
 * @param Row IBSheet Row index
 * @param Col IBSheet Col index
 * @param Sheet Array index 
 */
function setPopData_Sp(aryPopupData, Row, Col, SheetIdx) {
	var formObj=document.form;   
	if ( aryPopupData.length > 0 ) {
		formObj.vndr_seq.value=aryPopupData[0][2];
		formObj.vndr_lgl_eng_nm.value=aryPopupData[0][4];
	}	
}		 
function initControl() {       
	//Axon handling event1. event catch  
	axon_event.addListenerForm  ('blur', 'obj_deactivate',  form); 			      
//	axon_event.addListenerFormat('focus',   'obj_activate',    form);             
//	axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);            
	axon_event.addListenerFormat('change',	 'obj_change',		form); 	  
}           
/**
 * HTML Control deactivate event <br>
 **/
function obj_deactivate(){    
//	obj=event.srcElement;       
//	ComChkObjValid(event.srcElement);
	ComChkObjValid(ComGetEvent()); 
} 
/**
 * HTML Control activate event <br>
 **/
function obj_activate(){   
//	ComClearSeparator(event.srcElement);
	ComClearSeparator(ComGetEvent());
}  

function obj_change(){	     
//	var obj = ComGetEvent();
	var obj = ComGetEvent();
	var formObj=document.form; 
	var sheetObj=sheetObjects[0]; 
	if ( ComTrim(obj.value) != "" ) {
		switch(ComGetEvent("name")) {       
		case "vndr_seq":  
			formObj.vndr_seq.value=ComLpad(formObj.vndr_seq.value,6,"0");  
			doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC01);
			break;	   
		}       
	} else {
		switch(ComGetEvent("name")) {      
		case "vndr_seq":    
			ComSetObjValue(formObj.vndr_lgl_eng_nm,"") 
			break;   	
		}  		
	}
} 
/**
 * HTML Control keypress event <br>
 **/     

/* developer job */  
