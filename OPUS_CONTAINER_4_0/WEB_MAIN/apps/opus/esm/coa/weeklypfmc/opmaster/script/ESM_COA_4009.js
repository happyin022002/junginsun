/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   :  ESM_COA_4009.js
*@FileTitle  : Omission Port Management
*@author     : CLT
*@version    : 1.0
*@since      : 2015/02/24 : 싹다 변경
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
     * @class ESM_COA_4009 : ESM_COA_4009 Business script for the UI
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
            case "btn_Retrieve":
            	doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
                break;
                
            case "btn_Save":            	
                doActionIBSheet(sheetObjects[0],formObject,IBSAVE);                
                break;					
				
            case "btn_Rowadd":
                doActionIBSheet(sheetObjects[0],formObject,IBINSERT);
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
			  var HeadTitle0 = "Del.|STS|Effective Period|Effective Period|Port|Applicable|Applicable";
              var HeadTitle1 = "Del.|STS|From|To|Port|Revenue Lane|Bound";

              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0, ComboMaxHeight:200 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle0, Align:"Center"},
                              { Text:HeadTitle1, Align:"Center"} ];
              InitHeaders(headers, info);

  		      var cols = [ 
  		             {Type:"DelCheck",  Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"ibDel" },
  		             {Type:"Status",    Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
  		             {Type:"Date",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"eff_fm_dt",    	KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8  },
		             {Type:"Date",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"eff_to_dt",    	KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8  },
		             {Type:"PopupEdit", Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"loc_cd",    	KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5  },
  		             {Type:"Combo",     Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"rlane_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3  },
  		             {Type:"Combo",     Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"dir_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
  		       
  		      InitColumns(cols);
  		      
  		      SetColProperty(0 ,"loc_cd"    , {AcceptKeys:"E|N" , InputCaseSensitive:1});

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
	
			var sXml=document.form.sXml.value; 
			var arrXml=sXml.split("|$$|");
			var State=ComGetEtcData(arrXml[0],ComWebKey.Trans_Result_Key); 
			if(State != "S") {
				ComOpenWait(false);
				return;
			}	
			if (arrXml.length > 0) 
				ComCoaSetIBCombo(sheetObj, arrXml[0], "rlane_cd",false,0);
			if (arrXml.length > 1)
				ComCoaSetIBCombo(sheetObj, arrXml[1], "dir_cd",false,0);
			
			document.form.sXml.value="";
			setYrMon();
			
			ComOpenWait(false);				
			break;
		
        case IBSEARCH:  //Inquiry
            if(!validateForm(sheetObj,formObj,sAction)) return false;
            
            ComOpenWait(true);
        	sheetObjects[0].RemoveAll();
            formObj.f_cmd.value=SEARCH01;
            sheetObj.DoSearch("ESM_COA_4009GS.do", coaFormQueryString(formObj) );
            ComOpenWait(false);
            break;
             
        case IBSAVE:
        	if(!validateForm(sheetObj,formObj,sAction)) return false;
            
        	var sParam = sheetObj.GetSaveString(0);
        	if (!sheetObj.IsDataModified() && sParam == "") {
            	ComShowCodeMessage("COA00007");
            	return false;
            }
        	
            ComOpenWait(true);
            formObj.f_cmd.value=MULTI01;
            sParam = sParam + "&" + FormQueryString(formObj);
            var sXml = sheetObj.GetSaveData("ESM_COA_4009GS.do", sParam);
            sheetObj.LoadSaveData(sXml, {Sync:1});
            
            var dupChk = ComGetEtcData(sXml, "dup_chk");
 			var transResultKey = ComGetEtcData(sXml, "TRANS_RESULT_KEY"); 
 			
 			if((dupChk == "S"||dupChk=="") && transResultKey == "S"){
 				ComShowCodeMessage("COM130102","Data");//Success
 				doActionIBSheet(sheetObj,document.form,IBSEARCH);
			}else if(dupChk == "Dup"){
				ComShowMessage('Please Check Effective Period Date history.');
//				ComShowCodeMessage('COM12115', '[ Effective Period, Port ]');
				ComOpenWait(false);
				break;
				return false;
 			}else{
 				ComShowCodeMessage("COM12151",'Data'); //Failed 
 				ComOpenWait(false);
 				return false;
 			}
            ComOpenWait(false);
            break;

		case IBINSERT:	//Add row
			var Row = sheetObj.DataInsert();
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
		case IBSAVE: 	
			if(formObj.f_sdate.value.length == 0) {
				ComShowMessage(ComGetMsg('COA10002','Period'));
	  			ComSetFocus(formObj.f_sdate);			//20150806.MOD
	  			return false;	
	  		}
	  		if(formObj.f_sdate.value.length > 0) {
	  	  		if(!ComIsDate(formObj.f_sdate , "ymd")){
	  	  			ComShowMessage(ComGetMsg('COM12180'));
	  	  			ComSetFocus(formObj.f_sdate);		//20150806.MOD
	  	  			return false;	
	  	  		}
	  		}
  			if(sAction==IBSAVE) {
  	  			for ( var i = sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
  	  				if(sheetObj.GetCellValue(i, "ibflag") != "" && sheetObj.GetCellValue(i, "ibflag") != "R") {  
  						if (ComTrimAll(sheetObj.GetCellText(i, "eff_fm_dt")).length == 0) {
  							ComShowMessage(ComGetMsg('COA10002','Effective From Date'));
  							sheetObj.SelectCell(i, "eff_fm_dt");
  							return false;
  						}
  						if (ComTrimAll(sheetObj.GetCellText(i, "eff_to_dt")).length == 0) {
  							ComShowMessage(ComGetMsg('COA10002','Effective To Date'));
  							sheetObj.SelectCell(i, "eff_to_dt");
  							return false;
  						}
  						if (ComTrimAll(sheetObj.GetCellText(i, "loc_cd")).length == 0) {
  							ComShowMessage(ComGetMsg('COA10002','Port'));
  							sheetObj.SelectCell(i, "loc_cd");  							
  					  		return false;
  						}
  						if (sheetObj.GetCellValue(i, "ibflag") != "D" && ComTrimAll(sheetObj.GetCellText(i, "loc_cd")).length < 5) {
  							ComShowMessage(ComGetMsg('COA10002','the 5 letters to Port'));
  							sheetObj.SelectCell(i, "loc_cd");  							
  					  		return false;
  						}
  	  					if(sheetObj.GetCellValue(i, "ibflag") != "D") {
	  	  					var sMsgArr = "";
	  		  				//1--- sheet1 : Date Validation : fm_date > to_date
	  						if(parseInt(sheetObj.GetCellValue(i, "eff_to_dt")) < parseInt(sheetObj.GetCellValue(i, "eff_fm_dt"))) {
	  							ComShowMessage("End must be greater than start");
	  							sheetObj.SelectCell(i, "eff_fm_dt");
	  					  		return false;
	  						}				
	  						//2--- sheet1 : Date Validation : fm_date or to_date가 구간사이에 속한 경우
	  						for ( var j = sheetObj.HeaderRows(); j <= sheetObj.LastRow(); j++) {
	  							if (i != j &&
	  								sheetObj.GetCellValue(i, "loc_cd") == sheetObj.GetCellValue(j, "loc_cd") &&
	  								sheetObj.GetCellValue(i, "rlane_cd") == sheetObj.GetCellValue(j, "rlane_cd") &&
	  								sheetObj.GetCellValue(i, "dir_cd") == sheetObj.GetCellValue(j, "dir_cd")) {
	  								if (sheetObj.GetCellValue(i, "eff_to_dt").length > 0 && sheetObj.GetCellValue(j, "eff_to_dt").length > 0) {		  								
	  		  							if (parseInt(sheetObj.GetCellValue(i, "eff_fm_dt")) >= parseInt(sheetObj.GetCellValue(j, "eff_fm_dt")) &&
	  		  								parseInt(sheetObj.GetCellValue(i, "eff_fm_dt")) <= parseInt(sheetObj.GetCellValue(j, "eff_to_dt"))) {
	  		  								ComShowMessage("Check the Overlapping period.");
	  		  								sheetObj.SetCellFontColor(i, "eff_fm_dt","#FF0000");
	  		  								sheetObj.SelectCell(i, "eff_fm_dt");
	  		  					  			return false;	
	  		  							}
	  		  							if (parseInt(sheetObj.GetCellValue(i, "eff_to_dt")) >= parseInt(sheetObj.GetCellValue(j, "eff_fm_dt")) &&
	  		  								parseInt(sheetObj.GetCellValue(i, "eff_to_dt")) <= parseInt(sheetObj.GetCellValue(j, "eff_to_dt"))) {
	  		  								ComShowMessage("Check the Overlapping period.");
	  		  								sheetObj.SetCellFontColor(i, "eff_to_dt","#FF0000");
	  		  								sheetObj.SelectCell(i, "eff_to_dt");
	  		  					  			return false;	
	  		  							}
	  								}
	  							}
	  						}  	  						
  	  					}
  	  				}				//END IBFLAG=U/I/D
  	  			}			//END FOR ROW  	  				
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
    	ComSetObjValue(f_sdate, ComGetNowInfo("yy")+"-"+ComLpad(ComGetNowInfo("mm"),2,"0")+"-"+ComLpad(ComGetNowInfo("dd"),2,"0"));
        if(!ComAddSeparator(f_sdate)) return false;
    }
}

function sheet1_OnPopupClick(sheetObj, row, col){ 
	var pol_cd = sheetObj.GetCellValue(row, col);
	ComOpenPopup('/opuscntr/COM_ENS_051.do?'+"loc_cd="+pol_cd+"", 800, 490,  "setSheet1PopUpValue", '1,0,1,1,1,1,1,1', true, sheetObj, row, col);
}
function setSheet1PopUpValue(rowArray, row, col) {
	var sheetObj = sheetObjects[0];
	var colArray = rowArray[0];
	sheetObj.SetCellValue(row, col, colArray[3], 0);
} 

function callBackExcelMethod(excelType){
	var sheetObj = sheetObjects[0];
	switch (excelType) {
	case "AY":
		sheetObj.Down2Excel({DownCols:makeHiddenCoaSkipCol(sheetObj), SheetDesign:1, Merge:1});
		break;
	case "AN":
		sheetObj.Down2Excel({DownCols:makeHiddenCoaSkipCol(sheetObj), SheetDesign:0, Merge:0});
		break;      						
	case "DY":
		sheetObj.Down2Excel({DownCols:makeHiddenCoaSkipCol(sheetObj), SheetDesign:1, Merge:1});
		break;
	case "DN":
		sheetObj.Down2Excel({DownCols:makeHiddenCoaSkipCol(sheetObj), SheetDesign:0, Merge:0});
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
	var check = 0;
	if(Code == 0) {
    	for ( var i = sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
    		if(!validateEffMonth(sheetObj, i)){        			
    			check++;
    		} 		
    	}
    	if(check > 0){
    		ComShowCodeMessage('COM12114', 'Effective Month (Red Data)');
    	}    		
	} 	
} 
//20150609.ADD
function sheet1_OnChange(sheetObj,Row,Col,Value) {	
	if (sheetObj.ColSaveName(Col) == "loc_cd") {
		if(sheetObj.GetCellValue(Row,Col).length > 0) {
	  		var param="f_cmd="+SEARCH07;
	  		param=param + "&f_type_cd=LOC_CD&f_loc_cd="+sheetObj.GetCellValue(Row,Col);
	 		var result=ComSearchEtcData(sheetObj,"CommonUtilGS.do", param, "rtnValue");
			if (result!="true") {
	    		ComShowMessage(ComGetMsg('COA10004',Value));  	//msg1 + ' is invalid PORT.'
	    		sheetObj.SetCellValue(Row,Col,"")
	    		sheetObj.SelectCell(Row,Col,true);
	  		}				
		}
	}
}