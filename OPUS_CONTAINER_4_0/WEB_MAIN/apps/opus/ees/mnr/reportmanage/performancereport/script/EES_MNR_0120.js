/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName : EES_MNR_0120.js
 *@FileTitle : MNR PFMC by VNDR/Manufacturer
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/14
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
						MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
						OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class EES_MNR_0120 : business script for EES_MNR_0120.
 */
/* developer job	*/

var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
// setting eq_type in case of TS type
var uTpSz=new Array();
var gTpSz=new Array();
var zTpSz=new Array();

var selComboIndex=0;
var selComboCode="";
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	var sheetObject=sheetObjects[0];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
		case "btn_Retrieve":
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
			break;
		case "btn_New":
			doActionIBSheet(sheetObject, formObject, IBCLEAR);
			break;
		case "btn_DownExcel":
			doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
			break;
		case "btn_calendar":  
			var cal=new ComCalendarFromTo();
			cal.select(formObject.fm_dt, formObject.to_dt, 'yyyy-MM-dd');
			break;
		case "btn_calendar1":  
			var cal=new ComCalendarFromTo();
			cal.select(formObject.fqa_fm_dt, formObject.fqa_to_dt, 'yyyy-MM-dd');
			break;	
		case "btn_provider_popup":
			ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 700, 550, 'setPopData_Sp','1,0,1,1,1,1,1,1', true);
			break;
		case "btn_yd":
			ComOpenPopup('/opuscntr/COM_ENS_061.do', 766, 550, 'getCOM_ENS_061', "1,0,1,1,1,1,1,1,1,1,1,1", true);
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
	            ValidChar(2);
	            SetTitleVisible(1);
	    	}      
        	break;    
        case 5: 
           	with (comboObj) { 
				SetMultiSeparator("|");
				SetTitle("Office Code|Office Name");
				SetColAlign(0, "left");
				SetColAlign(1, "left");
				//SetColWidth("100|150");
			   	SetDropHeight(160);
				SetUseAutoComplete(1);
	            ValidChar(2);
	            SetTitleVisible(1);
	    	}      
        	break;
        case 6: 
           	with (comboObj) {  
				SetMultiSeparator("|");
				SetTitle("Code|Code Desc");  
				SetColAlign(0, "left");
				SetColAlign(1, "left");
				//SetColWidth("100|150");
			   	SetDropHeight(160);
				SetUseAutoComplete(1);
				SetTitleVisible(1);
	    	}      
        	break;
      } 
}     
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
	var sheetID=sheetObj.id;
    switch(sheetID) {    	
        case "sheet1":
                with(sheetObj){
					
				  var HeadTitle="|Seq.|EQ Type|TP/SZ|RHQ|Office|Yard|S/P Code|S/P Name|FQA QTY|FQA Date\n(Last)|Curr|Repair\nQTY|Total\nAMT|Average\nAMT|Average\nRepair Days";

				  SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

				  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				  var headers = [ { Text:HeadTitle, Align:"Center"} ];
				  InitHeaders(headers, info);

				  var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"hdnStatus" },
						 {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq",        KeyField:0,   CalcLogic:"",   Format:"" },
						 {Type:"Combo",     Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"eq_type",    KeyField:0,   CalcLogic:"",   Format:"" },
						 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"tpsz",       KeyField:0,   CalcLogic:"",   Format:"" },
						 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rhq",        KeyField:0,   CalcLogic:"",   Format:"" },
						 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"" },
						 {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"yard_cd",    KeyField:0,   CalcLogic:"",   Format:"" },
						 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"vndr_seq",   KeyField:0,   CalcLogic:"",   Format:"" },
						 {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:0,   SaveName:"sp_nm",      KeyField:0,   CalcLogic:"",   Format:"" },
						 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"fqa_qty",    KeyField:0,   CalcLogic:"",   Format:"" },
						 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"fqa_dt",     KeyField:0,   CalcLogic:"",   Format:"" },
						 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"curr",       KeyField:0,   CalcLogic:"",   Format:"" },
						 {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"unit",       KeyField:0,   CalcLogic:"",   Format:"Integer" },
						 {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"amt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
						 {Type:"Float",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"avg_amt",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
						 {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"avg_days",   KeyField:0,   CalcLogic:"",   Format:"Integer" } ];
				   
				  InitColumns(cols);

				  SetEditable(0);
				  SetCountPosition(0);
//				  SetSheetHeight(390);
				  resizeSheet( sheetObj );
            }


            break;
    }
}
function resizeSheet( sheetObj ){
    ComResizeSheet( sheetObj );
}
//handling process for sheet
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
					sheetObj.DoSearch("EES_MNR_0120GS.do",FormQueryString(formObj) );
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
				new Array("MnrGenCd","","CUSTOM9"), 
				new Array("MnrGenCd","CD00057", "COMMON"),
				new Array("MnrGenCd","CD00055", "COMMON"),
				new Array("MdmOrganization","RHQ","FALSE")
			)
			var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
			var sheetComboText="";  
			var sheetComboCode="";
			var sheetComboDefault="";
			//EQ Type   
			eq_type.InsertItem(0,"ALL","A");
			if(comboList[0] != null){	       
				sheetComboText="";
				sheetComboCode="";
				sheetComboDefault=""; 
				for(var j=0; j < comboList[0].length;j++){ 
					var tempText=comboList[0][j].split("|");   
					sheetComboText +=  tempText[1] + "|";
					sheetComboCode +=  tempText[0] + "|";
					eq_type.InsertItem(j + 1, tempText[1] ,tempText[0]);
				} 
				sheetObjects[0].InitDataCombo (0, "eq_type", sheetComboText, sheetComboCode ,sheetComboDefault);
			}     	
			eq_type.SetSelectCode("A");
			//Report Type Period
			if(comboList[2] != null){	       
				for(var j=0; j < comboList[2].length;j++){ 
					var tempText=comboList[2][j].split("|");  
					tempText[1]=tempText[1] + '|' + 'Estimate Amt';  
					report_period_type.InsertItem(j, tempText[1] ,tempText[0]);
				}     	    
			}     
			report_period_type.SetSelectCode("WI");
			//Regional HQ  
			rhq.InsertItem(0,"ALL","A");	
			if(comboList[3] != null){		       
				for(var j=0; j < comboList[3].length;j++){	 
					var tempText=comboList[3][j].split("|"); 	 
					rhq.InsertItem(j + 1, comboList[3][j] ,tempText[0]);
				}     	    
			}	
			rhq.SetSelectCode("A");
			// setting initial value 
 	 		tp_sz_cd.SetEnable(0);
			formObj.fm_dt.value=ComGetDateAdd(ComGetNowInfo("ymd"), "M", -1);
//			MnrSetFromDate(formObj.fm_dt);	
 			formObj.to_dt.value=ComGetNowInfo(); 
 			formObj.fqa_fm_dt.value=ComGetDateAdd(ComGetNowInfo("ymd"), "m", -3);
 			formObj.fqa_to_dt.value=ComGetNowInfo(); 
 			formObj.vndr_seq.value="";
 			formObj.vndr_lgl_eng_nm.value="";
 			sheetObj.SetWaitImageVisible(1);
 			MnrWaitControl(false);  	 				
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
		case IBSEARCH_ASYNC02:	//retrieving(in case of changing RHQ combo)	
			sheetObj.SetWaitImageVisible(0);
			if ( validateForm(sheetObj, formObj, sAction) ) { 
				ofc_cd.RemoveAll();
				var sCondition=new Array ( 				 
					new Array("MdmOrganization","SEARCH",rhq.GetSelectCode())
				)	  	   	                        
				var comboList=MnrComSearchCombo(sheetObjects[0],sCondition); 
				ofc_cd.InsertItem(0,"ALL","A");			  
				if(comboList[0] != null){		    
					for(var j=0; j < comboList[0].length;j++){  
						var tempText=comboList[0][j].split("|");  
						ofc_cd.InsertItem(j + 1,comboList[0][j] ,tempText[0]);
					}					 					      
				}					
			    ofc_cd.SetSelectCode("A");
			}							
			sheetObj.SetWaitImageVisible(1);
			break;			
 		case IBDOWNEXCEL:
			if(sheetObj.RowCount() < 1){//no data
				  ComShowCodeMessage("COM132501");
				}else{
					sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1, AutoSizeColumn:1 });
				}
 			break;
     }
 }
/**
* handling process for input validation
*/
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		if(sAction==IBSEARCH) {	  	    
			if(!MnrChkFromDate(formObj.fm_dt)) return false;
		}  			
	}
	return true;
}
 /**  
 * rhq Change event		      
 * @param {IBMultiCombo}  comboObj ComboObject  
 * @param  {String}    Index_Code   Index or Code
 * @param  {String}    Text
 */  	
//function rhq_OnChange(comboObj,Index_Code, Text){
	 function rhq_OnChange(comboObj,OldIndex, OldText, OldCode, NewIndex, NewText, NewCode){	
	var formObj=document.form;			       
	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC02);			 
}	 		        
/**  
 * combo_eq_type_cd Change event      
 * @param {IBMultiCombo}  comboObj ComboObject  
 * @param  {String}    Index_Code   Index or Code
 * @param  {String}    Text
 */  
//function eq_type_OnChange(comboObj,Index_Code, Text){ 
	 function eq_type_OnChange(comboObj,OldIndex, OldText, OldCode, NewIndex, NewText, NewCode){		
	var formObj=document.form;        
	//--------------------------------------
	var comboValue=comboObj.GetSelectCode();
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
 		tp_sz_cd.SetEnable(0);
	}else{
 		tp_sz_cd.SetEnable(1);
		tp_sz_cd.InsertItem(0,"ALL","ALL");   		
		for(var i=1;i < (selTpSz.length + 1);i++){             
			tp_sz_cd.InsertItem(i, ComReplaceStr(selTpSz[i - 1],"^"," - ") , selTpSz[i - 1]); 			
		}
	}
} 

function tp_sz_cd_OnSelect(comboObj ,index, code) {
	selComboIndex = index;
	selComboCode = code;
}
	 
//multicombo click event
function tp_sz_cd_OnChange(comboObj) { 
	ComSetMultiCombo(comboObj, selComboIndex, selComboCode);
}
/**
* handling after retrieving
*/		
function sheet1_OnSearchEnd(sheetObj,ErrMsg){
	var aFloat=parseFloat(sheetObj.GetSumValue(0,"amt") + "");
	var bFloat=parseFloat(sheetObj.GetSumValue(0,"unit") + "");
	var avgFloat=0;	    
	if(bFloat != 0){ 			 
		avgFloat=MnrMakeRound((aFloat / bFloat),2);
	}	 							  	
	sheetObj.SetSumValue(0,"avg_amt",avgFloat);
	sheetObj.SetSumValue(0,1,"TOTAL");
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
 * COM_ENS_061 receiving function values ​​from Pop-up      
 */
function getCOM_ENS_061(aryPopupData, row, col, shhetIdx){
	var formObj=document.form; 
	if(aryPopupData[0][3] != null && aryPopupData[0][3] != ""){
		formObj.yd_cd.value=aryPopupData[0][3];
	}         
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
 //   axon_event.addListenerFormat('focus',   'obj_activate',    form);             
    axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);            
	axon_event.addListenerFormat('change',	 'obj_change',		form); 	  
}           
/**
 * HTML Control deactivate event <br>
 **/
function obj_deactivate(){  	  		
	obj=ComGetEvent();      		 
    ComChkObjValid(obj);	 
} 
/**
 * HTML Control activate event <br>
 **/
function obj_activate(){   				
    ComClearSeparator(ComGetEvent());
}  
function obj_change(){	    			 
	var obj=ComGetEvent(); 
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
function obj_keypress(){     
    obj=ComGetEvent();    
    if(obj.dataformat == null) return; 
    window.defaultStatus=obj.dataformat;
    switch(obj.dataformat) {  
        case "ymd":   
        case "int":    
			ComKeyOnlyNumber(obj); 
            break;     
        case "float":   
            ComKeyOnlyNumber(obj, ".");
            break; 
        case "eng":   
            ComKeyOnlyAlphabet();
			break;   
        case "engup": 
			ComKeyOnlyAlphabet('uppernum');  
	        break;	  
    }
} 
/* developer job */
