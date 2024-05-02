/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   :  ESM_COA_4010.js
*@FileTitle  : Crosscheck between COA vs BKG
*@author     : CLT
*@version    : 1.0
*@since      : 2015/06/20
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------Code for JSDoc creation below ------------------*/
   /**
     * @fileoverview 
     */
    /**
     * @extends 
     * @class ESM_COA_4010 : ESM_COA_4010 Business script for the UI
     */
  var sheetObjects=new Array();
  var sheetCnt=0;
  var comboObjects=new Array();
  var comboCnt=0;
  var loadingMode=false;
  var sheet_height=200; // sheet height
  
document.onclick=processButtonClick;

function processButtonClick(){

    var costLocGrpCdCombo=comboObjects[0];
    var formObject=document.form;
    
    try {
        var srcName=ComGetEvent("name");
        if(ComGetBtnDisable(srcName)) return false;
        switch(srcName) {
	    	case "btn_calendar":
	            if (!window.event.srcElement.disabled) {
	                var cal=new ComCalendarFromTo();
	                cal.select(formObject.f_from, formObject.f_to, "yyyy-MM-dd");
	            }
	            break;        
            case "btn_Retrieve":
            	doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
                break;
                
            case "btn_New":
            	sheetObjects[0].RemoveAll();
                formObject.reset();
                changeConditionType("0");
            	break;				
                
			case "btn_Downexcel":	
				doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
				break;
				
			case "bu_zoom_in":
                if ( sheetObjects[0].RowCount() < 1 ) return;
                sheetObjects[0].SetSheetHeight( sheetObjects[0].GetSheetHeight(sheet_height) * 2 );
                div_zoom_in.style.display="none";
                div_zoom_out.style.display="inline";
                if (parent && parent.syncHeight) {
                    parent.syncHeight();
                }
				break;
			case "bu_zoom_out":
                if ( sheetObjects[0].RowCount() < 1 ) return;
                sheetObjects[0].SetSheetHeight( 420 );
                div_zoom_in.style.display="inline";
                div_zoom_out.style.display="none";
                if (parent && parent.syncHeight) {
                    parent.syncHeight();
                }
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
    loadingMode=true;
    changeConditionType("0");
    doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    loadingMode=false;
}   

/**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:	
		    with(sheetObj){
	      //  (11, 5, 0, true);//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			  var HeadTitle0 = "BKG NO|BKG|COA|Reason|Reason|Reason|Reason|Reason|Reason|R.Month|S.Month|Week|Trunk\nVVD|Revenue\nVVD|Service\nScope|Trade|Sub\nTrade|R.Lane|IOC|BKG TEU|COA TEU|Remark";
              var HeadTitle1 = "BKG NO|BKG|COA|MT|T/T|CMDT|VVD|OTH|ST|R.Month|S.Month|Week|Trunk\nVVD|Revenue\nVVD|Service\nScope|Trade|Sub\nTrade|R.Lane|IOC|BKG TEU|COA TEU|Remark";

              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0, ComboMaxHeight:200 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle0, Align:"Center"},
                              { Text:HeadTitle1, Align:"Center"} ];
              InitHeaders(headers, info);

  		      var cols = [ 
  		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",    	KeyField:0,   CalcLogic:"",   Format:"",    	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"bkg_flg",       KeyField:0,   CalcLogic:"",   Format:"",    	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"coa_flg",       KeyField:0,   CalcLogic:"",   Format:"",    	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"CheckBox",  Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"reason_mt",     KeyField:0,   CalcLogic:"",   Format:"",    	PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N" },
  		             {Type:"CheckBox",  Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"reason_tt",     KeyField:0,   CalcLogic:"",   Format:"",    	PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N" },
  		             {Type:"CheckBox",  Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"reason_cmdt",   KeyField:0,   CalcLogic:"",   Format:"",    	PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N" },
  		             {Type:"CheckBox",  Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"reason_vvd",    KeyField:0,   CalcLogic:"",   Format:"",    	PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N" },
  		             {Type:"CheckBox",  Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"reason_oth",    KeyField:0,   CalcLogic:"",   Format:"",   	 	PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N" },
  		             {Type:"CheckBox",  Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"reason_st",     KeyField:0,   CalcLogic:"",   Format:"",    	PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N" },
  		             {Type:"Date",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"cost_yrmon",    KeyField:0,   CalcLogic:"",   Format:"Ym",      PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Date",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"sls_yrmon",     KeyField:0,   CalcLogic:"",   Format:"Ym",      PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"cost_wk",       KeyField:0,   CalcLogic:"",   Format:"",    	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"trunk_vvd",     KeyField:0,   CalcLogic:"",   Format:"",    	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"rev_vvd",       KeyField:0,   CalcLogic:"",   Format:"",    	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",    KeyField:0,   CalcLogic:"",   Format:"",    	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  		 			 {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"trd_cd",        KeyField:0,   CalcLogic:"",   Format:"",    	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  		 			 {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"sub_trd_cd",    KeyField:0,   CalcLogic:"",   Format:"",    	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  		 			 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"rlane_cd",      KeyField:0,   CalcLogic:"",   Format:"",    	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  		 			 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ioc_cd",        KeyField:0,   CalcLogic:"",   Format:"",    	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  		 			 {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"bkg_teu",       KeyField:0,   CalcLogic:"",   Format:"Float", 	PointCount:2, 	UpdateEdit:0,   InsertEdit:0 },
  		 			 {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"coa_teu",       KeyField:0,   CalcLogic:"",   Format:"Float", 	PointCount:2, 	UpdateEdit:0,   InsertEdit:0 },
  		 			 {Type:"Text",      Hidden:0,  Width:160,  Align:"Left",    ColMerge:0,   SaveName:"remark",   		KeyField:0,   CalcLogic:"",   Format:"",    	PointCount:0,   UpdateEdit:0,   InsertEdit:0, MultiLineText:1, Wrap:1 } ];
  		       
  		      InitColumns(cols);
  		      
  		      SetEditable(1);	//Editkind[optional,Defaultfalse]
  		      SetWaitImageVisible(0);
  		      SetSheetHeight(420);
	        }
		    
			break;
	}
}

/**
 * Registering IBSheet Object as list
 * Calling from comSheetObject(id)
* adding process for list in case of needing batch processing with other items 
* defining list on the top of source
 */
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}
// window double click  //////////////////////////////////

/**
* Handling process about the sheet object MT ECC
*/
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
	    case IBCLEAR:    
			ComOpenWait(true);
	
//			var sXml=document.form.sXml.value; 
//			var arrXml=sXml.split("|$$|");
//			var State=ComGetEtcData(arrXml[0],ComWebKey.Trans_Result_Key); 
//			if(State != "S") {
//				ComOpenWait(false);
//				return;
//			}	
//			if (arrXml.length > 0) 
//				ComCoaSetIBCombo(sheetObj, arrXml[0], "rlane_cd",false,0);
//			if (arrXml.length > 1)
//				ComCoaSetIBCombo(sheetObj, arrXml[1], "dir_cd",false,0);
//			
//			document.form.sXml.value="";
			setYrMon();
			
			ComOpenWait(false);				
			break;
		
        case IBSEARCH:  //Inquiry
            if(!validateForm(sheetObj,formObj,sAction)) return false;
            
            ComOpenWait(true);
        	sheetObjects[0].RemoveAll();
        	if(formObj.conditionType[0].checked)	formObj.f_cmd.value=SEARCH01;
        	else	formObj.f_cmd.value=SEARCH02;
            sheetObj.DoSearch("ESM_COA_4010GS.do", coaFormQueryString(formObj) );
            ComOpenWait(false);
            break;

        case IBDOWNEXCEL:   // Excell download
        	var excelType=selectDownExcelMethod(sheetObj);
            break;
    }
}

/**
 * Handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
	switch (sAction) {
		case IBSEARCH: 
			if(formObj.conditionType[0].checked) {
				if(formObj.f_from.value.length == 0) {
					ComShowMessage(ComGetMsg('COA10002','Period'));
		  			ComSetFocus(formObj.f_from);		//20150806.MOD
		  			return false;	
		  		}
		  		if(formObj.f_from.value.length > 0) {
		  	  		if(!ComIsDate(formObj.f_from , "ymd")){
		  	  			ComShowMessage(ComGetMsg('COM12180'));
		  	  			ComSetFocus(formObj.f_from);	//20150806.MOD
		  	  			return false;	
		  	  		}
		  		}
				if(formObj.f_to.value.length == 0) {
					ComShowMessage(ComGetMsg('COA10002','Period'));
		  			ComSetFocus(formObj.f_to);			//20150806.MOD
		  			return false;	
		  		}
		  		if(formObj.f_to.value.length > 0) {
		  	  		if(!ComIsDate(formObj.f_to , "ymd")){
		  	  			ComShowMessage(ComGetMsg('COM12180'));
		  	  			ComSetFocus(formObj.f_to);		//20150806.MOD
		  	  			return false;	
		  	  		}
		  		}	  	
		  		//@@@ 나중풀기..
//				if (ComGetDaysBetween(f_from, f_to) > 14) {
//					ComShowMessage('Target Period term has more than 15 days.');
//					sheetObj.SelectCell(i,"f_from");
//					return false;
//				}					
			} else {
				if(formObj.f_vsl_cd.value.length == 0 || formObj.f_skd_voy_no.value.length == 0) {
					ComShowMessage(ComGetMsg('COA10002','T.VVD'));
		  			ComSetFocus(formObj.f_vsl_cd);		//20150806.MOD
		  			return false;	
		  		}				
			}
	}  		
	return true;
}

/**
 * Setting this month
 * setYrMon()
 *
 * @param NONE
 * @return NONE
 */
function setYrMon(){
    var formObj=document.form;
    with(formObj){
    	ComSetObjValue(formObj.f_from, ComGetDateAdd(ComGetNowInfo(),"D", -15));
    	ComSetObjValue(formObj.f_to, ComGetDateAdd(ComGetNowInfo(),"D", -1));
        if(!ComAddSeparator(f_from)) return false;
        if(!ComAddSeparator(f_to)) return false;
    }
}

function callBackExcelMethod(excelType){
	var sheetObj = sheetObjects[0];
	switch (excelType) {
	case "AY":
		sheetObj.Down2Excel({DownCols:makeHiddenCoaSkipCol(sheetObj), SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
		break;
	case "AN":
		sheetObj.Down2Excel({DownCols:makeHiddenCoaSkipCol(sheetObj), SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
		break;      						
	case "DY":
		sheetObj.Down2Excel({DownCols:makeHiddenCoaSkipCol(sheetObj), SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
		break;
	case "DN":
		sheetObj.Down2Excel({DownCols:makeHiddenCoaSkipCol(sheetObj), SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
		break;
	}             
} 

//DOWNEXCEL OPTION
function makeHiddenCoaSkipCol(sobj){ 
    var lc = sobj.LastCol();
    var rtnStr = "";
    for(var i=0;i<=lc;i++){
       if( ! ( sobj.GetCellProperty(0,i,"Type") == "Status" ||  sobj.GetCellProperty(0,i,"Type") =="DelCheck" ) ){
          rtnStr += "|"+ i;
       }
    }
    return rtnStr.substring(1);
}

function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
	if(Code == 0) {
 		var bColor="#0000FF";
 		for(var i=1;i<=sheetObj.RowCount();i++) {
 			sheetObj.SetCellFontColor(i, "bkg_no",bColor);
 		}  	
 		sheetObj.SetColFontUnderline("bkg_no",1);
	} 	
} 

/**
 * sheet Dbl Click Event Handling
 */
function sheet1_OnDblClick(sheetObj, row, col) {
	if ( col == 0 ) {
		var chkBkgNo=sheetObjects[0].GetCellValue(row, "bkg_no");
		if ( chkBkgNo != "" ) {
	    	var sUrl="ESM_BKG_0079_Q_POP.do?pgmNo=ESM_BKG_0079_Q&bkg_no="+chkBkgNo;
	    	ComOpenWindowCenter(sUrl, "ESM_BKG_0079_Q", 1250, 850, false, "yes");		
		}
	}
}

/**
 * 조회옵션 선택
 */
function changeConditionType(v){	
    var formObject=document.form;
    if(v == '1'){			//Target Period  
    	document.getElementById("f_from").className="input";
    	document.getElementById("f_to").className="input";
    	document.getElementById("f_from").disabled = true; 
    	document.getElementById("f_to").disabled = true; 
    	document.getElementById("btn_calendar").disabled = true;
    	formObject.f_from.value = "";
    	formObject.f_to.value = "";
    	
    	document.getElementById("f_vsl_cd").className="input1";
    	document.getElementById("f_skd_voy_no").className="input1";
    	document.getElementById('f_vsl_cd').disabled = false; 
    	document.getElementById('f_skd_voy_no').disabled = false; 
    	document.getElementById('f_dir_cd').disabled = false; 
    	sheetObjects[0].RemoveAll();
    	
    } else if(v == '0'){	//T.VVD
    	document.getElementById("f_from").className="input1";
    	document.getElementById("f_to").className="input1";
    	
    	document.getElementById("f_from").disabled = false; 
    	document.getElementById("f_to").disabled = false; 
    	document.getElementById("btn_calendar").disabled = false;
    	
    	document.getElementById("f_vsl_cd").className="input";
    	document.getElementById("f_skd_voy_no").className="input";
    	document.getElementById('f_vsl_cd').disabled = true; 
    	document.getElementById('f_skd_voy_no').disabled = true; 
    	document.getElementById('f_dir_cd').disabled = true; 
    	formObject.f_vsl_cd.value = "";
    	formObject.f_skd_voy_no.value = "";
    	formObject.f_dir_cd.value = "";
    	setYrMon();
    	sheetObjects[0].RemoveAll();
    }
}