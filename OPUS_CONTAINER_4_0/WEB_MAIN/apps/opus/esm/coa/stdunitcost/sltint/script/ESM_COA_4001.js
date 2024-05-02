/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   :  ESM_COA_4001.js
*@FileTitle  : Unit Price management for MRI Freight revenue
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
     * @class ESM_COA_4001 : ESM_COA_4001 Business script for the UI
     */
  var sheetObjects=new Array();
  var sheetCnt=0;
  var comboObjects=new Array();
  var comboCnt=0;
  var loadingMode=false;
  var sheet_height=200; // sheet height
  var EXCEL_LOAD_FLG = false;	//check excell loading
  var EXCEL_LOADING_FLG = false;	//check excell loading ing~
  var EXCEL_VAL_FLG = false;	//check excell validation check
  var IBVALIDATION = "IBVALIDATION";
  
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
            	doActionIBSheet(sheetObjects[0],formObject,IBVALIDATION);
                if(EXCEL_VAL_FLG) doActionIBSheet(sheetObjects[0],formObject,IBSAVE);                
                break;					
				
            case "btn_Rowadd":
                doActionIBSheet(sheetObjects[0],formObject,IBINSERT);
                break;
                
            case "btn_Rowcopy":
		    	doActionIBSheet(sheetObjects[0],formObject,IBCOPYROW);
                break;                  
                
			case "btn_Downexcel":	
				doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
				break;
				
			case "btn_loadexcel":
				EXCEL_LOADING_FLG = true;				
				doActionIBSheet(sheetObjects[0],formObject,IBLOADEXCEL);				
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
				
//			case "btn_Validation":	
//				doActionIBSheet(sheetObjects[0],formObject,IBVALIDATION1);
//				break;				
				
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
    for(k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],comboObjects[k].id);
    }    
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
		case 1:		//sheet2 init
		    with(sheetObj){
			  //SJH.20141121.MOD, SJH.20141216.ADD, SJH.20150224.MOD : cnt_cd 콜보로..
	      //  (11, 5, 0, true);//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			  var HeadTitle0 = "Del.|STS|CHGSTS|SEQ|Supplier\nLane|Borrower|Borrower|From|From|To|To|Cargo\nNature|Rate20|Rate40|Rate40H|Rate45|Effective Month|Effective Month|Batch|Remarks";
              var HeadTitle1 = "Del.|STS|CHGSTS|SEQ|Supplier\nLane|Trade|Sub Trade|Country|Port|Country|Port|Cargo\nNature|Rate20|Rate40|Rate40H|Rate45|From|To|Batch|Remarks";

              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0, ComboMaxHeight:200 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle0, Align:"Center"},
                              { Text:HeadTitle1, Align:"Center"} ];
              InitHeaders(headers, info);

  		      var cols = [ 
  		             {Type:"DelCheck",  Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"ibDel" },
  		             {Type:"Status",    Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
  		             {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"chg_status",      	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rt_seq",          	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Combo",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"slan_cd",       	KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3  },
  		             {Type:"Combo",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"trd_cd",          	KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Combo",     Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"sub_trd_cd",      	KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Combo",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"fm_cnt_cd",       	KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2  },
  		             {Type:"PopupEdit", Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"fm_port_cd",      	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5  },
  		             {Type:"Combo",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"to_cnt_cd",       	KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2  },
  		             {Type:"PopupEdit", Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"to_port_cd",      	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5  },
  		             {Type:"Combo",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cgo_tp_cd",       	KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2  },
  		             {Type:"Float",     Hidden:0,  Width:85,   Align:"Right",   ColMerge:0,   SaveName:"cntr_20ft_rt_amt",	KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:25 },
  		             {Type:"Float",     iHidden:0,  Width:85,   Align:"Right",   ColMerge:0,   SaveName:"cntr_40ft_rt_amt",	KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:25 },
  		             {Type:"Float",     Hidden:0,  Width:85,   Align:"Right",   ColMerge:0,   SaveName:"cntr_hc_rt_amt",  	KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:25 },
  		             {Type:"Float",     Hidden:0,  Width:85,   Align:"Right",   ColMerge:0,   SaveName:"cntr_45ft_rt_amt",	KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:25 },
  		             {Type:"Date",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"eff_fm_yrmon",    	KeyField:1,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6  },
  		             //SJH.20141224.MOD : TO를 필수가 아님..
  		             {Type:"Date",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"eff_to_yrmon",    	KeyField:0,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6  },
  		             //SJH.20141216.ADD
  		             {Type:"CheckBox",  Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bat_flg",      	  	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   TrueValue:"Y",   FalseValue:"N" },
  		      		 {Type:"Text",      Hidden:0,  Width:160,  Align:"Left",    ColMerge:1,   SaveName:"remark",   		  	KeyField:0,   CalcLogic:"",   Format:"",       	  PointCount:0,   UpdateEdit:0,   InsertEdit:0,   MultiLineText:1, Wrap:1 } ];
  		       
  		      InitColumns(cols);
  		      
  		      SetColProperty(0 ,"chg_status"    , {AcceptKeys:"E"   , InputCaseSensitive:1});
  		      SetColProperty(0 ,"fm_port_cd"    , {AcceptKeys:"E|N" , InputCaseSensitive:1});
  		      SetColProperty(0 ,"to_port_cd"    , {AcceptKeys:"E|N" , InputCaseSensitive:1});  		
//  		  InitComboNoMatchText(1,"",1);

  		      SetEditable(1);	//Editkind[optional,Defaultfalse]
  		      SetWaitImageVisible(0);
  		      SetSheetHeight(420);
	        }
		    
			break;
	}
}
/**
 * Function to initialize the IBCOMBO <br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
* @param {ibsheet} comboObj mandatory IBMultiCombo Object
* @param {int} comboNo mandatory  The order of the IBMultiCombo
 * @return nothing
 */ 
function initCombo(comboObj) {
	 switch(comboObj.options.id) {
    case "f_selslane":  
    case "f_trd_cd":	
    case "f_sub_trd_cd":	  
    case "f_type_cd":	    	 
        with(comboObj) { 
	    	 DropHeight = 300;
	    	 comboObj.InsertItem(0, "All", "All");
//	         SetUseAutoComplete(1);
	         ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고	
	    	 SetSelectIndex(0);
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
/**
* registering IBCombo Object as list
* adding process for list in case of needing batch processing with other items 
* defining list on the top of source by.yjjeon
   */
  function setComboObject(combo_obj){
      comboObjects[comboCnt++]=combo_obj;
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
				ComXml2ComboItem(arrXml[0], f_selslane, "code", "code");
			if (arrXml.length > 1)
				ComXml2ComboItem(arrXml[1], f_trd_cd, "code", "code");
			if (arrXml.length > 2)
				ComXml2ComboItem(arrXml[2], f_sub_trd_cd, "code", "code");
			if (arrXml.length > 3)
				ComXml2ComboItem(arrXml[3], f_type_cd, "code", "code");
			
			if (arrXml.length > 0) 
				ComCoaSetIBCombo(sheetObj, arrXml[0], "slan_cd",true,0);
			if (arrXml.length > 1)
				ComCoaSetIBCombo(sheetObj, arrXml[1], "trd_cd",true,0);
			if (arrXml.length > 2)
				ComCoaSetIBCombo(sheetObj, arrXml[2], "sub_trd_cd",true,0);
			if (arrXml.length > 3)
				ComCoaSetIBCombo(sheetObj, arrXml[3], "cgo_tp_cd",false,0);
			if (arrXml.length > 4) {
				ComCoaSetIBCombo(sheetObj, arrXml[4], "fm_cnt_cd", true, 0, 0,"","", true);
				ComCoaSetIBCombo(sheetObj, arrXml[4], "to_cnt_cd", true, 0, 0,"","", true);
			}			
			document.form.sXml.value="";
			setYrMon();
			
			ComOpenWait(false);				
			break;
			
	    //SJH.20150105.ADD
		case SEARCHLIST01:
			formObj.f_cmd.value=sAction;
			var sXml=sheetObj.GetSearchData("ESM_COA_4001GS.do", FormQueryString(formObj));
			var arrXml=sXml.split("|$$|");
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], f_sub_trd_cd, "code", "code");
			initCombo(f_sub_trd_cd,f_sub_trd_cd.id);
			f_sub_trd_cd.SetSelectIndex(0);
			break;	
			
		//SJH.20150105.ADD	
		case SEARCHLIST02:
			formObj.f_cmd.value=sAction;
			formObj.f_cbotrade.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(),"trd_cd");
			var sXml=sheetObj.GetSearchData("ESM_COA_4001GS.do", FormQueryString(formObj));
			var arrXml=sXml.split("|$$|");  				
			if (arrXml.length > 0) {
				ComCoaSetIBCombo(sheetObj, arrXml[0], "sub_trd_cd", true, 0, sheetObj.GetSelectRow());
				formObj.f_cbotrade.value="";
			}
			break;			
            
        case IBSEARCH:  //Inquiry
            if(!validateForm(sheetObj,formObj,sAction)) return false;
            
            ComOpenWait(true);
        	sheetObjects[0].RemoveAll();
            formObj.f_cmd.value=SEARCH01;
            sheetObj.DoSearch("ESM_COA_4001GS.do", coaFormQueryString(formObj) );
            EXCEL_VAL_FLG = false;
			EXCEL_LOAD_FLG = false;            
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
            var sXml = sheetObj.GetSaveData("ESM_COA_4001GS.do", sParam);
            sheetObj.LoadSaveData(sXml, {Sync:1});
            
            var dupChk = ComGetEtcData(sXml, "dup_chk");
 			var transResultKey = ComGetEtcData(sXml, "TRANS_RESULT_KEY"); 
 			
 			if((dupChk == "S"||dupChk=="") && transResultKey == "S"){
 				ComShowCodeMessage("COM130102","Data");//Success
 				doActionIBSheet(sheetObj,document.form,IBSEARCH);
			}else if(dupChk == "Dup"){
				//SJH.20141105.MOD
				ComShowCodeMessage('COM12115', '[ Supplier Lane, Trade, Sub Trade, From Country, From Port, To Country, To Port, Cargo Nature, Effective From Month ]');
				ComOpenWait(false);
				break;
				return false;
 			}else{
 				ComShowCodeMessage("COM12151",'Data'); //Failed 
 				ComOpenWait(false);
 				return false;
 			}
    
            EXCEL_VAL_FLG = false;
			EXCEL_LOAD_FLG = false;             
            ComOpenWait(false);
            break;

		case IBINSERT:	//Add row
			var Row = sheetObj.DataInsert();
			sheetObj.SetCellValue(Row, "cgo_tp_cd", "GC");		//SJH.20141105.ADD  
			EXCEL_VAL_FLG = false;
			break;
			
		case IBCOPYROW:   
			//SJH.20141105.ADD
			if (sheetObj.RowCount() > 0) {
  				var Row = sheetObj.DataCopy();
  				sheetObj.SetCellValue(Row,"rt_seq",""); 
  				sheetObj.SetCellValue(Row,"eff_to_yrmon","");
  				sheetObj.SetCellValue(Row,"bat_flg","");  	
  				sheetObj.SetCellValue(Row,"remark","");  	
			}
			EXCEL_VAL_FLG = false;
			break;  			
  				
        case IBDOWNEXCEL:   // Excell download
        	var excelType=selectDownExcelMethod(sheetObj);
            break;
            
    	case IBLOADEXCEL:   
    		//20150716.MOD/ADD/DEL
    		sheetObj.SetWaitImageVisible(0);
        	sheetObj.RemoveAll();
        	sheetObj.LoadExcel({ Mode:"HeaderMatch", StartRow: "1"});
        	EXCEL_VAL_FLG = false;
			break;      
			
		case IBVALIDATION:		
			if(!validateForm(sheetObj,formObj,sAction)) return false;			
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
			if(formObj.f_fm_mon.value.length == 0) {
				ComShowMessage(ComGetMsg('COA10002','YYYY-MM'));
	  			ComSetFocus(formObj.f_fm_mon);		//20150806.MOD
	  			return false;	
	  		}
	  		if(formObj.f_fm_mon.value.length > 0) {
	  	  		if(!ComIsDate(formObj.f_fm_mon , "ym")){
	  	  			ComShowMessage(ComGetMsg('COM12180'));
	  	  			ComSetFocus(formObj.f_fm_mon);	//20150806.MOD
	  	  			return false;	
	  	  		}
	  		}
  			//SJH.20141105.ADD
  			if (formObj.f_from.value.length > 0) {
  				if(formObj.f_from.value.length != 2 && formObj.f_from.value.length != 5) {
  					ComShowCodeMessage('COA10002', '2(Country size) or 5(Port size) characters');
  					return false;
  				}
  			}
  			if (formObj.f_to.value.length > 0) {
  				if(formObj.f_to.value.length != 2 && formObj.f_to.value.length != 5) {
  					ComShowCodeMessage('COA10002', '2(Country size) or 5(Port size) characters');
  					return false;
  				}
  			}
	  		if (sAction == IBSAVE) {
	  			for ( var i = sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {	  				
	  				if(sheetObj.GetCellValue(i, "ibflag") == "U" || sheetObj.GetCellValue(i, "ibflag") == "I") {
			  	  		if(EXCEL_LOAD_FLG && sheetObj.GetCellValue(i, "ibflag") == "U") {
			  	  			ComShowMessage(ComGetMsg('COM12114','Status.\nWhen loading Excel [UPDATE] is not allowed.\n'));
			  	  			return false; 	
			  	  			break;				  	  			
			  	  		}				  	  	
		  	  		if(!EXCEL_VAL_FLG) {
	  					ComShowMessage(ComGetMsg('COA10071'));
		  	  			return false; 	
		  	  			break;
		  	  		}
	  	  			if (ComTrimAll(sheetObj.GetCellText(i, "remark")).length > 0) {
	  	  				ComShowMessage(ComGetMsg('COM12114','Remarks'));
		  	  			return false;	
		  	  			break;
	  	  			}	  	  		
		  	  	}
	  	  	}
	  		}
	  		return true;
	  		break;
	  		
		case IBVALIDATION:			
			var sTitle = new Array();
			var keyCol = 0;
			var sMsg = new Array();
			
			//sheet1 keyCol set
			keyCol = sheetObj.SaveNameCol("fm_cnt_cd");			
					
  			for ( var i = sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {  				
  				var remark = "";
  				var rcheck = 0;  
  				
  				for ( var Col = 0 ; Col <= sheetObj.LastCol() ; Col++) {	  					
					//0--- title 설정
					if (i == sheetObj.HeaderRows()) {
						if (sheetObj.HeaderRows() < 2) {
							sTitle[Col] = sheetObj.GetCellValue(0, sheetObj.ColSaveName(Col)).replace("\n"," ");
						} else {
  						sTitle[Col] = sheetObj.GetCellValue(1, sheetObj.ColSaveName(Col)).replace("\n"," ");
  						if (sheetObj.GetCellValue(0, sheetObj.ColSaveName(Col)).replace("\n"," ") != sTitle[Col]) 
  							sTitle[Col] = sheetObj.GetCellValue(0, sheetObj.ColSaveName(Col)).replace("\n"," ") + " " + sTitle[Col];	  								
						}
					}
					if(sheetObj.GetCellValue(i, "ibflag") != "" && sheetObj.GetCellValue(i, "ibflag") != "R" && sheetObj.GetCellValue(i, "ibflag") != "D") {
						if (Col > 3) {
							//1--- Keyfield Validation
							if (Col <= keyCol || sheetObj.ColSaveName(Col)=="to_cnt_cd" || sheetObj.ColSaveName(Col)=="cgo_tp_cd" || sheetObj.ColSaveName(Col)=="eff_fm_yrmon") {
		  						if (ComTrimAll(sheetObj.GetCellText(i, Col)).length == 0) {
		  							remark = remark + ((rcheck == 0) ? "" : ",\n") + "[ "+sTitle[Col]+" ] : "+sheetObj.GetCellText(i, Col);
		  							rcheck++;
		  						} 	  								
							}
							if (sheetObj.GetCellValue(i, Col).length > 0 || sheetObj.GetCellText(i, Col).length > 0) {
		  						//2--- Combo Validation
		  						if (sheetObj.GetCellProperty(0, Col, "Type") == "Combo") {
		  							if (ComTrimAll(sheetObj.GetCellText(i, Col)).length > 0 && sheetObj.GetComboInfo(i, Col, "SelectedIndex") < 0) {
		  								remark = remark + ((rcheck == 0) ? "" : ",\n") + "[ "+sTitle[Col]+" ] : "+sheetObj.GetCellText(i, Col);
			  							rcheck++;		  								
		  							}
		  						}		  						
		  						//3--- Date Validation
		  						if (sheetObj.GetCellProperty(0, Col, "Format") == "Ym") {
		  							if (!ComIsDate(sheetObj.GetCellValue(i, Col), "ym")) {		
		  								remark = remark + ((rcheck == 0) ? "" : ",\n") + "[ "+sTitle[Col]+" ] : "+sheetObj.GetCellValue(i, Col);
			  							rcheck++;
		  							}
		  						}
								//4--- port_cd Validation, max 5
								if(sheetObj.ColSaveName(Col).substring(3)=="port_cd") {
									if(sheetObj.GetCellValue(i, Col).length != 0 && sheetObj.GetCellValue(i, Col).length != 5) {
										remark = remark + ((rcheck == 0) ? "" : ",\n") + "[ "+sTitle[Col]+" ] : "+sheetObj.GetCellValue(i, Col)+" (Only 5 characters or NULL)";
										rcheck++;										
									}
								}								
							}	//END LENGTH > 0
						}
					}				//END IBFLAG=U/I/D
				}	//END FOR (COL)
					
  				if(sheetObj.GetCellValue(i, "ibflag") != "" && sheetObj.GetCellValue(i, "ibflag") != "R" && sheetObj.GetCellValue(i, "ibflag") != "D") {  
  					var sMsgArr = "";
	  				//5--- sheet1 : Date Validation : fm_date > to_date
					if(parseInt(sheetObj.GetCellValue(i, "eff_to_yrmon")) < parseInt(sheetObj.GetCellValue(i, "eff_fm_yrmon"))) {
						remark = remark + ((rcheck == 0) ? "" : ",\n") + "[ Effective Month ] : "+
						         sheetObj.GetCellValue(i, "eff_fm_yrmon")+" > "+sheetObj.GetCellValue(i, "eff_to_yrmon")+" (End must be greater than start)";
						rcheck++;
					}
					//6--- cnt_cd, port_cd Validation, cnt_cd <> port_cd.substr(0,2)
					if(sheetObj.GetCellValue(i, "fm_port_cd").length > 0) {
						if(sheetObj.GetCellValue(i, "fm_cnt_cd").substr(0,2)!=sheetObj.GetCellValue(i, "fm_port_cd").substr(0,2)){
							remark = remark + ((rcheck == 0) ? "" : ",\n") + "[ From Country/Port ] : "+sheetObj.GetCellValue(i, "fm_cnt_cd")+"/"+sheetObj.GetCellValue(i, "fm_port_cd");
							rcheck++;
						}
					}
					if(sheetObj.GetCellValue(i, "to_port_cd").length > 0) {
						if(sheetObj.GetCellValue(i, "to_cnt_cd").substr(0,2)!=sheetObj.GetCellValue(i, "to_port_cd").substr(0,2)){
							remark = remark + ((rcheck == 0) ? "" : ",\n") + "[ To Country/Port ] : "+sheetObj.GetCellValue(i, "to_cnt_cd")+"/"+sheetObj.GetCellValue(i, "to_port_cd");
							rcheck++;
						}
					} 					
					//7--- sheet1 : Date Validation : fm_date or to_date가 구간사이에 속한 경우
					for ( var j = sheetObj.HeaderRows(); j <= sheetObj.LastRow(); j++) {
						if (i != j &&
							sheetObj.GetCellValue(i, "slan_cd") == sheetObj.GetCellValue(j, "slan_cd") &&
							sheetObj.GetCellValue(i, "trd_cd") == sheetObj.GetCellValue(j, "trd_cd") &&
							sheetObj.GetCellValue(i, "sub_trd_cd") == sheetObj.GetCellValue(j, "sub_trd_cd") &&  							
							sheetObj.GetCellValue(i, "fm_cnt_cd") == sheetObj.GetCellValue(j, "fm_cnt_cd") &&
							sheetObj.GetCellValue(i, "fm_port_cd") == sheetObj.GetCellValue(j, "fm_port_cd") &&
							sheetObj.GetCellValue(i, "to_cnt_cd") == sheetObj.GetCellValue(j, "to_cnt_cd") &&
							sheetObj.GetCellValue(i, "to_port_cd") == sheetObj.GetCellValue(j, "to_port_cd") &&
							sheetObj.GetCellValue(i, "cgo_tp_cd") == sheetObj.GetCellValue(j, "cgo_tp_cd")) {
							if (sheetObj.GetCellValue(i, "eff_to_yrmon").length > 0 && sheetObj.GetCellValue(j, "eff_to_yrmon").length > 0) {		  								
	  							if (parseInt(sheetObj.GetCellValue(i, "eff_fm_yrmon")) >= parseInt(sheetObj.GetCellValue(j, "eff_fm_yrmon")) &&
	  								parseInt(sheetObj.GetCellValue(i, "eff_fm_yrmon")) <= parseInt(sheetObj.GetCellValue(j, "eff_to_yrmon"))) {
	  								remark = remark + ((rcheck == 0) ? "" : ",\n") + "[ "+sTitle[sheetObj.SaveNameCol("eff_fm_yrmon")]+" ] : "+sheetObj.GetCellValue(i, "eff_fm_yrmon")+" (Check the overlapping period)";
	  								sheetObj.SetCellFontColor(i, "eff_fm_yrmon","#FF0000");
	  								rcheck++;
	  							}
	  							if (parseInt(sheetObj.GetCellValue(i, "eff_to_yrmon")) >= parseInt(sheetObj.GetCellValue(j, "eff_fm_yrmon")) &&
	  								parseInt(sheetObj.GetCellValue(i, "eff_to_yrmon")) <= parseInt(sheetObj.GetCellValue(j, "eff_to_yrmon"))) {
	  								remark = remark + ((rcheck == 0) ? "" : ",\n") + "[ "+sTitle[sheetObj.SaveNameCol("eff_to_yrmon")]+" ] : "+sheetObj.GetCellValue(i, "eff_to_yrmon")+" (Check the overlapping period)";
	  								sheetObj.SetCellFontColor(i, "eff_to_yrmon","#FF0000");
	  								rcheck++;
	  							}
							}
							//8--- dup check							
							if (sheetObj.GetCellValue(i, "eff_fm_yrmon") == sheetObj.GetCellValue(j, "eff_fm_yrmon")) {			
								sMsgArr = "";
								var sArr = ("slan_cd|trd_cd|sub_trd_cd|fm_cnt_cd|fm_port_cd|to_cnt_cd|to_port_cd|cgo_tp_cd|eff_fm_yrmon").split("|");								
								for ( var k = 0; k < sArr.length; k++) {
									sMsgArr = sMsgArr + sheetObj.GetCellValue(j, sArr[k])+((k >= sArr.length-2) ? "" : "|");
								}								
  								sheetObj.SetCellFontColor(j, "eff_fm_yrmon","#FF0000");  								
							}
						}
					}
					if(sMsgArr.length > 0) {
						remark = remark + ((rcheck == 0) ? "" : ",\n") + "[ Dup Error ] : "+sMsgArr;
						rcheck++;
					}
					sheetObj.SetCellValue(i, "remark", remark);
  				}				//END IBFLAG=U/I/D
  			}			//END FOR ROW  		
  			
			//ComShowMessage(ComGetMsg('COM12116','Validation'));
			EXCEL_VAL_FLG = true;
			if (rcheck > 0) return false;	  			
			break;
	}  		
	return true;
}

/**
* Function that check a validation on the window <br>
*/		
function validateEffMonth(sheetObj, i) {
	var vCheck = 0;
	//겹치는 구간만 체크!!
	if(sheetObj.GetCellValue(i, "ibflag") != "") {
		//Key or not null 체크
		for ( var j = sheetObj.HeaderRows(); j <= sheetObj.LastRow(); j++) {
			if (i != j &&
				sheetObj.GetCellValue(i, "slan_cd") == sheetObj.GetCellValue(j, "slan_cd") &&
				sheetObj.GetCellValue(i, "trd_cd") == sheetObj.GetCellValue(j, "trd_cd") &&
				sheetObj.GetCellValue(i, "sub_trd_cd") == sheetObj.GetCellValue(j, "sub_trd_cd") &&
				sheetObj.GetCellValue(i, "fm_cnt_cd") == sheetObj.GetCellValue(j, "fm_cnt_cd") &&
				sheetObj.GetCellValue(i, "fm_port_cd") == sheetObj.GetCellValue(j, "fm_port_cd") &&
				sheetObj.GetCellValue(i, "to_cnt_cd") == sheetObj.GetCellValue(j, "to_cnt_cd") &&
				sheetObj.GetCellValue(i, "to_port_cd") == sheetObj.GetCellValue(j, "to_port_cd") &&
				sheetObj.GetCellValue(i, "cgo_tp_cd") == sheetObj.GetCellValue(j, "cgo_tp_cd")) {
				//SJH.20141105.ADD, SJH.20141224.MOD : TO_YRMON이 NULL인경우 추가
				if(sheetObj.GetCellValue(j, "eff_to_yrmon").length > 0) {
  					if (parseInt(sheetObj.GetCellValue(i, "eff_fm_yrmon")) >= parseInt(sheetObj.GetCellValue(j, "eff_fm_yrmon")) &&
					parseInt(sheetObj.GetCellValue(i, "eff_fm_yrmon")) <= parseInt(sheetObj.GetCellValue(j, "eff_to_yrmon"))) {							
					sheetObj.SetCellFontColor(i, "eff_fm_yrmon","#FF0000");
					vCheck++;
				}  
  					if(sheetObj.GetCellValue(i, "eff_to_yrmon").length > 0 ) {
  	  					if (parseInt(sheetObj.GetCellValue(i, "eff_to_yrmon")) >= parseInt(sheetObj.GetCellValue(j, "eff_fm_yrmon")) &&
    						parseInt(sheetObj.GetCellValue(i, "eff_to_yrmon")) <= parseInt(sheetObj.GetCellValue(j, "eff_to_yrmon"))) {
    						sheetObj.SetCellFontColor(i, "eff_to_yrmon","#FF0000");
    						vCheck++;
    					}  						
  					}  	  					
				}
			}
		}	 
	}
	
	if (vCheck > 0) 
		return false;
	else
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
        var nowYear=ComGetNowInfo("yy");
        var nowMon=ComGetNowInfo("mm");
        if ( nowMon.length == 1 ) nowMon="0" + nowMon; // conversion : 1month -> 01month 
        var nowYrMon=nowYear + nowMon;
        f_fm_mon.value=nowYrMon;
        isValidYYYYMM(f_fm_mon,true,'-',true);
        if(!ComAddSeparator(f_fm_mon)) return false;
    }
}

//cnt_cd / port_cd 팝업 조회
function openLocationCode(funtionNm){
    if(funtionNm == "getF_from" || funtionNm == "getF_to")
        ComOpenPopup('/opuscntr/COM_ENS_051.do', 800, 490,  funtionNm, '1,0,1,1,1,1,1,1,1,1,1,1', true);
}
function getF_from(rowArray) {
    var colArray=rowArray[0];
    document.form.f_from.value=colArray[3];
    document.form.f_to.focus();
}
function getF_to(rowArray) {
    var colArray=rowArray[0];
    document.form.f_to.value=colArray[3];
    document.form.f_type_cd.focus();			//SJH.20141107.MOD
} 
function sheet1_OnPopupClick(sheetObj, row, col){ 
	if ( sheetObj.ColSaveName(col).substring(3) == "cnt_cd" ){
		var cnt_cd = sheetObj.GetCellValue(row, col);
		ComOpenPopup('/opuscntr/COM_ENS_0M1.do?'+"cnt_cd="+cnt_cd+"", 800, 490,  "setSheet1PopUpValue", '1,0,1,1,1,1,1,1', true, sheetObj, row, col);
	}	
	if ( sheetObj.ColSaveName(col).substring(3) == "port_cd" ){	
		var pol_cd = sheetObj.GetCellValue(row, col);
		var cnt_cd = sheetObj.GetCellValue(row, col-1);
		ComOpenPopup('/opuscntr/COM_ENS_051.do?'+"loc_cd="+pol_cd+"&cnt_cd="+cnt_cd+"", 800, 490,  "setSheet1PopUpValue", '1,0,1,1,1,1,1,1', true, sheetObj, row, col);
	}
}
function setSheet1PopUpValue(rowArray, row, col) {
	var sheetObj = sheetObjects[0];
	var colArray = rowArray[0];
	sheetObj.SetCellValue(row, col, colArray[3], 0);
	onChangeCheck(sheetObj, row, col, colArray[3]);			//SJH.20141110.ADD
} 

/**
* Search details with double clicking on sheet8
*/
function sheet1_OnDblClick(sheetObj , row, col){
	var formObject = document.form;
	formObject.f_view_tpsz.value = sheetObj.GetCellValue(row, "cntr_tpsz_cd");
	formObject.f_ecc_cd2.value = sheetObj.GetCellValue(row, "scc_cd");
	formObject.f_from.value = sheetObj.GetCellValue(row, "cost_src_fm_yrmon");
	formObject.f_to.value = sheetObj.GetCellValue(row, "cost_src_to_yrmon");	
	
	doActionIBSheet(sheetObjects[1],formObject,IBSEARCH); 		
}

//SJH.20141105.ADD, SJH.20141216.ADD : CHECKBOX
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

//LOADEXCEL OPTION
function sheet1_OnLoadExcel(sheetObj, result, code, msg) {
	ComOpenWait(false);									//20150716.MOD
	if(isExceedMaxRow(msg)) return;						//20150501.COMMON ADD
	
//	var sheetObj = sheetObjects[0];
	var check = 0;	
	if ((sheetObj.LastRow()+sheetObj.HeaderRows()) >= 2000) {
		if(!ComShowCodeConfirm("COA10072", "2000", "\nDo you want to continue?")) {
			sheetObj.RemoveAll();
			return false;
		}
	}	
	if (sheetObj.RowCount() > 0) {						//20150501.COMMON MOD
		for ( var i = sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
			//대문자로 모두 치환 : 속도는? 장담못함..
			for ( var Col = 2 ; Col <= sheetObj.LastCol() ; Col++) {
				if (sheetObj.GetCellProperty(i, Col,"Type")=="Text" || 
//					sheetObj.GetCellProperty(i, Col,"Type")=="Combo" || 			::: 목록에 추가되는 현상때문에 결국 뺌
					sheetObj.GetCellProperty(i, Col,"Type")=="PopupEdit") {
					sheetObj.SetCellValue(i,sheetObj.ColSaveName(Col), sheetObj.GetCellValue(i,sheetObj.ColSaveName(Col)).toUpperCase());
				}				
			}
			if (sheetObj.GetCellValue(i,"chg_status").substring(0,1) == "D") {
				sheetObj.SetCellValue(i,"ibflag","");
				sheetObj.SetCellValue(i,"ibDel",1);
			}else if (sheetObj.GetCellValue(i,"chg_status").substring(0,1) == "U" || 
					  sheetObj.GetCellValue(i,"chg_status").substring(0,1) == "I") {
				sheetObj.SetCellValue(i,"ibflag", sheetObj.GetCellValue(i,"chg_status").substring(0,1));
				sheetObj.SetCellValue(i,"bat_flg","");
				sheetObj.SetCellValue(i,"remark","");
    			if (sheetObj.GetCellValue(i, "ibflag").toUpperCase() == "I") {
    				sheetObj.SetCellValue(i,"rt_seq","");
      				sheetObj.SetCellValue(i,"eff_to_yrmon","");      				    				
    			}
//        		if(!validateEffMonth(sheetObj, i)){
//        			check++;
//        		}
			}else{
				sheetObj.SetCellValue(i,"ibflag","");
			}
		}
//		if(check > 0){
//			ComShowCodeMessage('COM12114', 'Effective Month (Red Data)');
//		}  
	}	
	EXCEL_LOAD_FLG = true;
	EXCEL_VAL_FLG = false;
	EXCEL_LOADING_FLG = false;
} 

//20150716.ADD
function sheet1_OnLoadFileSelect(sheetObj){
    ComOpenWait(true);
}

function sheet1_OnChange(sheetObj, Row, Col, value) {
	if(EXCEL_LOADING_FLG) return;
	var formObj=document.form;  							//SJH.20150105.ADD
	onChangeCheck(sheetObj, Row, Col, value);				//SJH.20141110.ADD  	
	//SJH.20150105.ADD
	if(sheetObj.ColSaveName(Col) == "trd_cd") {
  		if (sheetObj.GetCellValue(Row, "trd_cd")!= "") {    	  			
 			doActionIBSheet(sheetObj,formObj,SEARCHLIST02);
 		}  			
	}
    EXCEL_VAL_FLG = false;
}
//SJH.20141110.ADD
function onChangeCheck(sheetObj, Row, Col, value){
	if (value == "") return;
    with (sheetObj) {
    	var colname1 = sheetObj.ColSaveName(Col).substring(0,3);
    	var colname2 = sheetObj.ColSaveName(Col).substring(3);
    	if(colname2 == "port_cd" || colname2 == "cnt_cd") {
    		if(GetCellValue(Row, colname1+"port_cd").length > 0) {
    			if(colname2 == "port_cd") {
    				SetCellValue(Row, colname1+"cnt_cd", value.substring(0,2));
    			}
    			if(GetCellValue(Row, colname1+"cnt_cd").substring(0,2) !=
    			   GetCellValue(Row, colname1+"port_cd").substring(0,2)){
    				ComShowCodeMessage('COA10070', 'Data'); //Firts 2 charactor of Sub group cost code must be same with Main group cost code
    				SelectCell(Row, colname1+"port_cd", true);
    			}
    		}
    	}
    }
} 
//SJH.20150105.ADD
function f_trd_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	if(EXCEL_LOADING_FLG) return;
	if (loadingMode == true)
		return;	
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	if (comboObj.GetSelectText()!= "") {		
		 doActionIBSheet(sheetObj,formObj,SEARCHLIST01);
	}	
} 

function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
//	var check = 0;
//	if(Code == 0) {
//    	for ( var i = sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
//    		if(!validateEffMonth(sheetObj, i)){        			
//    			check++;
//    		} 		
//    	}
//    	if(check > 0){
//    		ComShowCodeMessage('COM12114', 'Effective Month (Red Data)');
//    	}    		
//	} 	
} 
