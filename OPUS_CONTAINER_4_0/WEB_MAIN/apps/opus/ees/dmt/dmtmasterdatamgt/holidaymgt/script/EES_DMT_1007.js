/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ees_dmt_1007.js
*@FileTitle  : Holiday by Country Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/28
=========================================================*/
/****************************************************************************************
   Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                  MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                  OTHER CASE : COMMAND01=11; ~ COMMAND20=30;	
 ***************************************************************************************/
    /**
     * @extends 
     * @class Holiday by Country Creation : Holiday by Country Creation ,  business script for EES_DMT_1007.
     */

	// Common Global variables 
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var COUNTRY="CNT";
	var REGION="RGN";
	var STATE="STE";
	var LOCATION="LOC";
	IBSEARCH_WKND=101;
	var HOL_DT_IN=3;
	var HOL_DESC=4;
	var HOL_YR=5;
	var CNT_CD=6;
	var RGN_CD=7;
	var STE_CD=8;
	var LOC_CD=9;
	var HOL_DT=10;
	var UPD_DT=11;
	var UPD_OFC_CD=12;
	var UPD_USR_NM=13;
	var ROWMARK="|";
	var FIELDMARK="=";
	var MonthOfYear=new Array();
	MonthOfYear[1]='JAN';
	MonthOfYear[2]='FEB';
	MonthOfYear[3]='MAR';
	MonthOfYear[4]='APR';
	MonthOfYear[5]='MAY';
	MonthOfYear[6]='JUN';
	MonthOfYear[7]='JUL';
	MonthOfYear[8]='AUG';
	MonthOfYear[9]='SEP';
	MonthOfYear[10]='OCT';
	MonthOfYear[11]='NOV';
	MonthOfYear[12]='DEC';
	var DEF_SHEET_HEIGHT = 386;
	
	//When Retrieving Location, Location intended to prevent information from being erased
	var isClearLocation=true;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
        /***** case in Sheet count are more two by Tab, defining adding sheet *****/
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
		var sheetObject3=sheetObjects[2];
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
				case "btn_Retrieve":
					ComSetObjValue(formObject.retry, "");
					doActionIBSheet(sheetObject3, formObject, IBSEARCH);
					break;
				case "btn_New":
					initControl();
					break;
				case "btn_Save":
					doActionIBSheet(sheetObject3, formObject, IBSAVE);
					break;
				case "btn_DownExcel":
					doActionIBSheet(sheetObject3, formObject, IBDOWNEXCEL);
					break;
				case "btn_RowAdd":
					if (ComIsBtnEnable("btn_RowAdd")) 
						doActionIBSheet(sheetObject3, formObject, IBINSERT);
					break;
				case "btn_RowCopy":
					if (ComIsBtnEnable("btn_RowCopy")) 
						doActionIBSheet(sheetObject3, formObject, IBCOPYROW);
					break;
				case "btn_Delete":
					if (ComIsBtnEnable("btn_Delete")) 
						doActionIBSheet(sheetObject3, formObject, IBDELETE);
					break;
				case "btn_LoadExcel":
					if (ComIsBtnEnable("btn_LoadExcel")) 
						doActionIBSheet(sheetObject3, formObject, IBLOADEXCEL);
					break;																																								
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
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
    function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
		var formObj=document.form;
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        sheet1_OnLoadFinish();
	 	//IBMultiCombo initializing
	    for(var k=0 ; k < comboObjects.length ; k++){
	        initCombo(comboObjects[k],k+1);
	    }
		initAxonControl();
		//Update Date/OFC/Name initializing
		with(formObj) {
			ComEnableManyObjects(false, upd_dt, upd_ofc_cd, upd_usr_nm);
			upd_dt.className='input2';
			upd_ofc_cd.className='input2';
			upd_usr_nm.className='input2';
		}
		//Year Search Field initializing
		initYearControl();
		changeBtnInGrid(false);
		//Save, Down Excelbutton deactivating =============
		ComBtnDisable("btn_Save");
		ComBtnDisable("btn_DownExcel");
		//Country Search Field get focus
		//comboObjects[0].focus();
    }
  function sheet1_OnLoadFinish() {
  		var formObj=document.form
  		var sheetObj=sheetObjects[0];
  		doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH02);
  		doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH01);
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
            case "sheet1":      // sheet1 init
                with(sheetObj){
		              var HeadTitle="|SAT";
		
		              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Status" },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"firstholiday",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		               
		              InitColumns(cols);
		              SetEditable(1);
		              SetSheetHeight(DEF_SHEET_HEIGHT);
                    }
                break;
            case "sheet2":      // sheet2 init
                with(sheetObj){
		             var HeadTitle="|SUN";
		
		             SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		             var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		             var headers = [ { Text:HeadTitle, Align:"Center"} ];
		             InitHeaders(headers, info);
		
		             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Status" },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"secondholiday",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		              
		             InitColumns(cols);
		             SetEditable(1);
		             SetSheetHeight(DEF_SHEET_HEIGHT);
                  }
                break;
            case "sheet3":      // sheet4 init
                with(sheetObj){
		             var HeadTitle="||Seq.|DATE|HOLIDAY";
		
		             SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		             var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		             var headers = [ { Text:HeadTitle, Align:"Center"} ];
		             InitHeaders(headers, info);
		
		             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
		                 {Type:"Seq",       Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
		                 {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"hol_dt_in",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"hol_desc",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:30 },
		                 {Type:"Text",      Hidden:1, Width:120,  Align:"Left",    ColMerge:0,   SaveName:"hol_yr",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:120,  Align:"Left",    ColMerge:0,   SaveName:"cnt_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:120,  Align:"Left",    ColMerge:0,   SaveName:"rgn_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:120,  Align:"Left",    ColMerge:0,   SaveName:"ste_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:120,  Align:"Left",    ColMerge:0,   SaveName:"loc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:120,  Align:"Left",    ColMerge:0,   SaveName:"hol_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:120,  Align:"Left",    ColMerge:0,   SaveName:"upd_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:120,  Align:"Left",    ColMerge:0,   SaveName:"upd_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:120,  Align:"Left",    ColMerge:0,   SaveName:"upd_usr_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		              
		             InitColumns(cols);
		             SetEditable(1);
		             SetSheetHeight(DEF_SHEET_HEIGHT);
		             SetColProperty(0 ,"hol_desc" , {AcceptKeys:"E|[ ]" , InputCaseSensitive:1});
		                      //conversion of function[check again]CLT 					InitDataValid(0,  "hol_desc", vtEngUpOther, " ");
             }
            break;;
        }
    }
	// Process of Sheet
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
           case IBSEARCH:      // Search
				if(validateForm(sheetObj, formObj, sAction)) {
					if (sheetObj.id == "sheet3") {
						//1.Inquiry ago, the parameter is set to a value type or allows selected.
						setParameters(SEARCH);
						//2.Inquiry ago, the result makes Empty fields.
						clearResultControls();
						//3.Inquiry before, Update User information fields makes Empty.
						clearUpdateUserControls();
						//4.Inquiry as a query is run conditions
						var sXml=sheetObj.GetSearchData("EES_DMT_1007GS.do" , FormQueryString(formObj));
						
						//5.After handling Retrieving results (retrieved results allows you to map each result to the grid.)
			            var arrXml=sXml.split("|$$|");
			            if (arrXml.length > 0) sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
						if (arrXml.length > 1) sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
						if (arrXml.length > 2) sheetObjects[2].LoadSearchData(arrXml[2],{Sync:1} );
						// If it fails to terminate the search results.
						
						//if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "F") return;
						
						changeBtnInGrid(true);
						
						ComBtnEnable("btn_Save");
						
						ComBtnEnable("btn_DownExcel");
						
						//==================================================
						disableSearchControls();
						if (sheetObj.RowCount()> 0) {
							if (ComGetObjValue(formObj.retry) == "Y") {
								for (var row=sheetObj.HeaderRows(); row <= sheetObj.LastRow(); row++) {
									sheetObj.SetRowStatus(row,"I");
								}
								ComClearObject(formObj.upd_dt);
								ComClearObject(formObj.upd_ofc_cd);
								ComClearObject(formObj.upd_usr_nm);
								ComShowCodeMessage('DMT00111');
							} 
							else {
								ComSetObjValue(formObj.upd_dt, 		sheetObj.GetCellValue(1, UPD_DT));
								ComSetObjValue(formObj.upd_ofc_cd, 	sheetObj.GetCellValue(1, UPD_OFC_CD));
								ComSetObjValue(formObj.upd_usr_nm, 	sheetObj.GetCellValue(1, UPD_USR_NM));
							}
						} 
						else {
							if (ComGetObjValue(formObj.retry) == "") {
								if (ComShowCodeConfirm("DMT06015")) {
									ComSetObjValue(formObj.retry, "Y");	
									doActionIBSheet(sheetObj, formObj, sAction);
								}
							}
						}
					}
				};						
                break;
           case IBSEARCH_WKND:      
				if (sheetObj.id == "sheet3") {
					var wkndTpCd="";
					if (ComTrim(comboObjects[0].GetSelectText()) != "") {
						//Inquiry ago, the parameter is set to a value type or allows selected.
						setParameters(SEARCH02);
						//Inquiry as a query is run conditions
						var sXml=sheetObj.GetSearchData("EES_DMT_1007GS.do", FormQueryString(formObj));
						//After handling Retrieving results
						//change the type of holiday
						wkndTpCd=ComGetEtcData(sXml, "wknd_tp_cd");
					}
					ComSetObjValue(formObj.wknd_tp_cd, wkndTpCd);
					//4-2.change gird  title of holiday
					setHolidayTitle();									
				}
				break;
			case IBSAVE:        
				if (validateForm(sheetObj, formObj, sAction)) {
					if (sheetObj.id == "sheet3") {
						fillMandatory();
						//Inquiry ago, the parameter is set to a value type or allows selected.
						setParameters(MULTI);
						sheetObj.DoSave("EES_DMT_1007GS.do", FormQueryString(formObj));
					}
				};				
				break;
			case IBINSERT:      // insert
				if (sheetObj.id == "sheet3") { 
					sheetObj.DataInsert(-1);
				};
				break;
			case IBDELETE:		// Delete
				if (sheetObj.id == "sheet3") { 
			        var delrows=sheetObj.FindCheckedRow("del_chk");
			        sheetObj.CheckAll("del_chk",0);
			        //==============================================================
			        if (ComTrim(delrows).length == 0) return;
					delrows=delrows.substring(0, delrows.length);
			        var arrRow=delrows.split(ROWMARK);
			        for (var i=arrRow.length-1 ; i >= 0 ; i--) {
			        	if (sheetObj.GetRowStatus(arrRow[i]) == 'I') {
							sheetObj.RowDelete(arrRow[i], false);
						}
						else {
							sheetObj.SetRowStatus(arrRow[i],'D');
							sheetObj.SetRowHidden(arrRow[i],1);
						}
			        }
				};
				break;
			case IBDOWNEXCEL:	// EXCEL DOWNLOAD
				if (sheetObj.id == "sheet3") {
					if (sheetObj.RowCount()== 0 ) {
				   		ComShowCodeMessage("COM132501"); // No data to dowload as Excel
				   	    return;
				   	} else {
				   		sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(					sheetObj), SheetDesign:1,Merge:1 });
				   	}
					
				}; 
				break;
			case IBLOADEXCEL:	// EXCEL UPLOAD
				if (sheetObj.id == "sheet3") {
					sheetObj.LoadExcel();
					setAllFormatDate();
				}; 
				break;
			case IBCOPYROW:	// EXCEL UPLOAD
				if (sheetObj.id == "sheet3") {
					var row=sheetObj.DataCopy();
					sheetObj.SetRowStatus(row,"I");
				}; 
				break;			
        }
    }
    function doActionIBCombo(sheetObj,formObj,sAction,sComboAction) {
        sheetObj.ShowDebugMsg(false);
		sheetObj.SetWaitImageVisible(0);
        switch(sAction) {
			case IBSEARCH:      // Search
				if (sheetObj.id == "sheet1") {
					//1.Inquiry ago, the parameter is set to a value type or allows selected.
					setParameters(sComboAction);
					//2.Inquiry as a query is run conditions
					var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
					//3.After handling Retrieving results
					var comboDatas;
					var comboItems;
					var comboItem;
					switch(sComboAction) {
						//3-1.Search Region (All Region List)
						case SEARCH01:
    						comboItems=ComGetEtcData(sXml, REGION).split(ROWMARK);
							comboObjects[1].RemoveAll();
							addComboItem(comboObjects[1],comboItems);						
							break;
						//3-2.Search Country (All Country List)
						case SEARCH02:
    						comboItems=ComGetEtcData(sXml, COUNTRY).split(ROWMARK);
							comboObjects[0].RemoveAll();
							addComboItem(comboObjects[0],comboItems);						
							break;
						//3-3. Search  Region of Country
						case SEARCH03:
							//In response XML,  Region or State information, choose from the list allows querying.다.
							if (comboObjects[0].GetSelectText()== "CA" || comboObjects[0].GetSelectText()== "US") {
								comboDatas=ComGetEtcData(sXml, STATE);
							} else {
								comboDatas=ComGetEtcData(sXml, REGION);
							}
							if (comboDatas != undefined) {
								comboObjects[1].RemoveAll();
								comboItems=comboDatas.split(ROWMARK);
								addComboItem(comboObjects[1],comboItems);	
							}			
							break;
						case SEARCH04:
							//In response XML, Country information, choose from the list allows querying.
							comboDatas=ComGetEtcData(sXml, COUNTRY);
							if (comboDatas != undefined) {
								comboItems=comboDatas.split(ROWMARK);
								setComboItem(comboObjects[0],comboItems);
							}
							//In response XML,  Region or State information, choose from the list allows querying.다.
							var locCd=ComTrim(ComGetObjValue(formObj.location)).substring(0, 2);
							if (locCd == "CA" || locCd == "US") {
								comboDatas=ComGetEtcData(sXml, STATE);
							} else {
								comboDatas=ComGetEtcData(sXml, REGION);
							}
							if (comboDatas != undefined) {
								comboItems=comboDatas.split(ROWMARK);
								setComboItem(comboObjects[1],comboItems);
							} else {
								ComShowCodeMessage("DMT00110", "Location");
								ComClearObject(formObj.location);
								ComSetFocus(formObj.location);
							}
							break;
						//3-5.Region as a higher item code (Country) should query information.
						case SEARCH13:						
						//3-6.State as a higher item code (Country) should query information.
						case SEARCH17:
							//In response XML, Country information, choose from the list allows querying.
							comboDatas=ComGetEtcData(sXml, COUNTRY);
							if (comboDatas != undefined) {
								comboItems=comboDatas.split(ROWMARK);
								setComboItem(comboObjects[0],comboItems);
								//In response XML,  Region or State information, choose from the list allows querying.다.
								if (comboObjects[0].GetSelectText()== "US" || comboObjects[0].GetSelectText()== "CA") {
									comboDatas=ComGetEtcData(sXml, STATE);
								}
								else {
									comboDatas=ComGetEtcData(sXml, REGION);
								}
								if (comboDatas != undefined) {
									comboItems=comboDatas.split(ROWMARK);
									setComboItem(comboObjects[1],comboItems);
								}							
							}
							else {
								ComShowCodeMessage("DMT00110", "Region");
								comboObjects[1].SetSelectText("");
							}
							break;
					}						
				};
                break;
        }
		sheetObj.SetWaitImageVisible(1);
    }
    /**
     * add data  combo field 
     */	
	function addComboItem(comboObj,comboItems,checked) {
		var checkedItem="";
    	for (var i=0 ; i < comboItems.length ; i++) {
			if (ComTrim(comboItems[i]) != "") {
    			var comboItem=comboItems[i].split(FIELDMARK);
				if (i == 0) checkedItem=comboItem[0];
				comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[1]);
			}		
    	}
		if (checked) comboObj.SetSelectText(checkedItem);
	}
    /**
     * Select the first item
     */	
	function setComboItem(comboObj,comboItems) {
		var checkedItem=comboItems[0].split(FIELDMARK);
		comboObj.SetSelectText(checkedItem[0]);
	}	
    /**
     *  handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction) {
		if (sheetObj.id == 'sheet3') {
			switch(sAction) {
				case IBSAVE:
	        		var dupRows = sheetObj.ColValueDupRows(HOL_DT_IN);
	        		if(dupRows != "") {
		        		var arrRow=dupRows.split(",");
		        		var dupDt=sheetObj.GetCellValue(arrRow[0],HOL_DT_IN);
			        	ComShowCodeMessage('DMT00109',dupDt);
						sheetObj.SetSelectRow(arrRow[0]);
			        	return false;
	        		}
					break;
				case IBSEARCH:
					if (comboObjects[0].GetSelectText()== "") {
						ComShowCodeMessage("COM12113", "Country");
						return false;
					};
					break;
			}
		}
        return true;
    }
	/** 
	 * IBCombo Object set to an array
	 * param : combo_obj 
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */ 
	function setComboObject(combo_obj) {  
	    comboObjects[comboCnt++]=combo_obj;  
	} 
	/**
	 * Initializing Combo 
	 * param : comboObj , comboNo
	 * adding case as numbers of counting Combos 
	 */ 
	function initCombo(comboObj, comboNo) {
	    var formObject=document.form
		switch(comboNo) {
			//Country Initializing Combo
			case 1:
				with (comboObj) { 
					SetMultiSelect(0);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "30");
					SetColWidth(1, "200");
					//SetFontName("Tahoma");
					SetDropHeight(160);
					SetColBackColor(0, "#CCFFFD");
					SetColBackColor(1, "#CCFFFD"); 
					ValidChar(2, 2);	// use upper case
		    	}
			break;
			
			//Region Initializing Combo
			case 2: 
				with (comboObj) { 		
					SetMultiSelect(0);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "50");
					SetColWidth(1, "190");
					//SetFontName("Tahoma");
					SetDropHeight(160);
					ValidChar(2, 2);	// use upper case
				}
			break;			
	     } 
	}
	//business javascript OnKeyPress event handling
//	function obj_keypress() {
//		var formObj=document.form;
//		switch(event.srcElement.dataformat){
//			case "engup":
//				// upper case + numbers 
//				ComKeyOnlyAlphabet('uppernum', ',');
//				break;
//		}
//	} 	 
	/*
	 * Country Search Field when there is a change, the part of the Region or State functions that query information
	 */		
	function cboCountry_OnChange(comboObj, Index_Code, Text) {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		var cntCd=comboObj.GetSelectText();
		//If Country is changed, Location information erase
		if (isClearLocation) clearLocation();
		//If Country is Empty, All Region information is Inquiry.
		if (cntCd.length == 0) {
			doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH01);
			return;	
		}	
		//Region Caption change depending on the Country Code gives.
		switch(cntCd) {
			case "CA":
			case "US":
				Region.innerHTML="State";
				break;
			default:
				Region.innerHTML="Region";
		}
		//Search information of Country belonging to the sub-Regsion or State 
		doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH03);
		//Country information change, Country WEEKEND TYPE to be reset after a Inquiry.
		doActionIBSheet(sheetObjects[2], formObj, IBSEARCH_WKND);
	}
	/*
	 *Region or State Search Field case is changed, Location Search Field and initializing functions that
	 */	
	function cboRegion_OnChange(comboObj, Index_Code, Text) {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		var rgnCd=comboObj.GetSelectText();
		switch(rgnCd.length) {
			case 2: //State Code to find a parent code.
				ComSetObjValue(formObj.ste_cd, rgnCd);
				doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCH17);
				break;
			case 3:	//Region Code to find a parent code.
				ComSetObjValue(formObj.rgn_cd, rgnCd);
				doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCH13);
				break;
		}
		//If Region is changed, Location information erase.
		if (isClearLocation) clearLocation();
	}
	/*
	 * Location Search Field, if entered in the Enter Key Location Country and Region or State that includes a function to query information
	 */		
	function checkLocation() {
		var formObj=document.form;
    	if (ComTrim(ComGetObjValue(formObj.location)).length == 5) {
			var locCd=ComTrim(ComGetObjValue(formObj.location));
    		if (locCd.length == 5) {
				isClearLocation=false;
				//Search higher Country, Region or State of  Location includes
    			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH04);
				//Location : Country information change, Country WEEKEND TYPE to be reset after a Inquiry.
				doActionIBSheet(sheetObjects[2],formObj,IBSEARCH_WKND);
				isClearLocation=true;
			}
    	}		
	}
	/**
	 * Holidays in the query result grid of the information entered in the DATE field Mon (MM: number) that function by converting part of English
	 */		 
	function sheet3_OnChange(sheetObj, Row, Col, Value) {
		var formObj=document.form;
		if (sheetObj.ColSaveName(Col) == "hol_dt_in") {
			setFormatDate(Row);
		}
	}
	/**
	 * Holidays in the grid, enter a title screen will change to match the Inquiry conditions.
	 */		
	function setHolidayTitle() {
		var formObj=document.form;
		var sheet1Title="";
		var sheet2Title="";
		var wkndTpCd=ComGetObjValue(formObj.wknd_tp_cd);
		switch(wkndTpCd) {
			case "TF": 
				sheet1Title="|THU";
				sheet2Title="|FRI";
				break;
			case "FS": 
				sheet1Title="|FRI";
				sheet2Title="|SAT";
				break;
			default:
				sheet1Title="|SAT";
				sheet2Title="|SUN";							
		}
		changeHeaderRow(sheetObjects[0] , 0 , sheet1Title);
		changeHeaderRow(sheetObjects[1] , 0 , sheet2Title);
		//sheetObjects[0].InitHeadRow(0, sheet1Title, false);
		//sheetObjects[1].InitHeadRow(0, sheet2Title, false);
	}
	/*
	 * Searching fields to enter information of the screen is stored in a lookup field values??.
	 */		
	function setParameters(sAction) {
		var formObj=document.form;
		ComSetObjValue(formObj.hol_yr, ComGetObjValue(formObj.year));		//Year
		ComSetObjValue(formObj.cnt_cd, comboObjects[0].GetSelectText());				//Country
		ComSetObjValue(formObj.loc_cd, ComGetObjValue(formObj.location));	//Location	
		ComSetObjValue(formObj.loc_cd, ComGetObjValue(formObj.location));	//Weekend Type
		ComSetObjValue(formObj.f_cmd, sAction);								//Command
	}
	/*
	 * 휴Holidays do not enter information mandatory from the user input the value of the item, enter the value received from the user fills the lookup.
	 */	
	function fillMandatory() {
		var formObj=document.form;
		var sheetObj=sheetObjects[2];
		for (var row=1 ; row <= sheetObj.RowCount(); row++) {
			if (sheetObj.GetRowStatus(row) == 'I') {
				sheetObj.SetCellValue(row, HOL_YR,ComGetObjValue(formObj.hol_yr));
				sheetObj.SetCellValue(row, CNT_CD,ComGetObjValue(formObj.cnt_cd));
				sheetObj.SetCellValue(row, RGN_CD,ComGetObjValue(formObj.rgn_cd));
				sheetObj.SetCellValue(row, STE_CD,ComGetObjValue(formObj.ste_cd));
				sheetObj.SetCellValue(row, LOC_CD,ComGetObjValue(formObj.loc_cd));
				var hol_dt=sheetObj.GetCellValue(row, HOL_DT_IN);
				var day=hol_dt.substring(0, 2);
				var month=ComTrim(hol_dt.substring(2));
				for (var i=1 ; i < MonthOfYear.length ; i++) {
					if (MonthOfYear[i] == month) {
						if (i < 10) month="0" + month;
						break;
					}
				}
				sheetObj.SetCellValue(row, HOL_DT,sheetObj.GetCellValue(row, HOL_YR) + "-" + month + "-" + day);
			}
		}
	}
	function initAxonControl() {  
		axon_event.addListener('beforedeactivate', 	'obj_deactivate', 	'location');
//		axon_event.addListener('keydown', 			'obj_keydown', 		'location');
//		axon_event.addListenerFormat('keypress',	'obj_keypress', 	document.form); // Keyboard input
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	}           
	/*
	 * Location FocusOut, input digits for the Validation Check
	 */
	function obj_deactivate() {
		obj=event.srcElement;
		if(obj.value.length > 0 && obj.value.length < 5) {
			ComShowCodeMessage("DMT00110", "Location");
			ComClearObject(obj);
		}
	}	

	function obj_keydown() {
		var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
		if (keyValue != 13) return;
		doActionIBSheet(sheetObjects[2],document.form,IBSEARCH);
	}
	/*
	 * Search Field deactivating  
	 */		
	function disableSearchControls() {
		var formObj=document.form;
		comboObjects[0].SetEnable(0);
		comboObjects[1].SetEnable(0);
		with (formObj) {
			ComEnableManyObjects(false, location, year);
			location.className='input2';
			year.className='input2';
		}	
	}
	/*
	 * activating searching fields 
	 */		
	function enableSearchControls() {
		var formObj=document.form;
		var cboCountryObj=comboObjects[0];
		var cboRegionObj=comboObjects[1];
		cboCountryObj.SetEnable(1);
		cboRegionObj.SetEnable(1);
		with (formObj) {
			ComEnableManyObjects(true, location, year);
			location.className='input';
			year.className='input';
		}	
	}
	/*
	 * Year Search Field initializing
	 */		
	function initYearControl() {
		var formObj=document.form;
		var date=new Date();
		var optVal="";
		for (var i=-1 ; i < 6 ; i++) {
			optVal=date.getFullYear() - i;
			formObj.year.add(new Option(optVal, optVal));
		}
		ComSetObjValue(formObj.year, date.getFullYear());
	}
	/*
	 * Search Field initializing
	 */		
	function initSearchControls() {
		var formObj=document.form;
		var cboCountryObj=comboObjects[0];
		var cboRegionObj=comboObjects[1];
		cboCountryObj.SetSelectText("");//Country ComboBox
		cboRegionObj.RemoveAll();		//Region or State ComboBox
		Region.innerHTML="Region";	//Region Caption
		ComSetObjValue(formObj.hol_yr, 		new Date().getFullYear());	//Year ComboBox
		ComSetObjValue(formObj.year, 		new Date().getFullYear());	//Year ComboBox
		ComSetObjValue(formObj.cnt_cd, 		"");
		ComSetObjValue(formObj.rgn_cd, 		"");
		ComSetObjValue(formObj.ste_cd, 		"");
		ComSetObjValue(formObj.loc_cd, 		"");
		ComSetObjValue(formObj.location, 	"");
		ComSetObjValue(formObj.wknd_tp_cd, 	"");
	}
	/*
	 * Holidays query result field initialization
	 */		
	function clearResultControls() {
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
	}
	/*
	 * Location Search Field initialization
	 */		
	function clearLocation() {
		var formObj=document.form;
		ComSetObjValue(formObj.loc_cd, "");
		ComSetObjValue(formObj.location, "");
	}
	/*
	 * Update Date/OFC/Name Field initialization
	 */		
	function clearUpdateUserControls() {
		var formObj=document.form;
		ComSetObjValue(formObj.upd_dt, "");
		ComSetObjValue(formObj.upd_ofc_cd, "");
		ComSetObjValue(formObj.upd_usr_nm, "");
	}
	/*
	 * Weekend grid title initialization
	 */		
	function initWeekendType() {
		var formObj=document.form;
		ComSetObjValue(formObj.wknd_tp_cd, "");
		setHolidayTitle();
	}	
	/*
	 * htmlControl event initializing
	 */	
	function initControl() {
		var formObj=document.form;
		initSearchControls();
		// search  Field activating
		enableSearchControls();
		clearResultControls();
		//grid title initialization
		initWeekendType();
		//Update User initializing
		clearUpdateUserControls();
		//Region combo initializing
		doActionIBCombo(sheetObjects[0], formObj, IBSEARCH, SEARCH01);
		//Grid button deactivating
		changeBtnInGrid(false);
		//Save, Down Excelbutton deactivating =============
		ComBtnDisable("btn_Save");
		ComBtnDisable("btn_DownExcel");
		//=========================================================
	}	
    /**
     * Grid button Change is the status of the function
     */	
	function changeBtnInGrid(flag) {
		if (flag) {
			ComBtnEnable("btn_RowAdd");
			ComBtnEnable("btn_RowCopy");
			ComBtnEnable("btn_Delete");
			ComBtnEnable("btn_LoadExcel");			
		} else {
			ComBtnDisable("btn_RowAdd");
			ComBtnDisable("btn_RowCopy");
			ComBtnDisable("btn_Delete");
			ComBtnDisable("btn_LoadExcel");			
		}
	}
   /**
 	* Holiday Date column of the user input a function that converts into DDMON
 	*/
 	function setAllFormatDate() {
		var sheetObj=sheetObjects[2];
		with(sheetObj) {
			for (var row=HeaderRows(); row <= LastRow(); row++) {
				setFormatDate(row);
			}
		}
 	}
   /**
	* Holiday Date column of the user input a function that converts into DDMON
	*/
	function setFormatDate(selectedRow) {
		var formObj=document.form;
		var sheetObj=sheetObjects[2];
		var inDate=sheetObj.GetCellValue(selectedRow, "hol_dt_in");
		if (inDate.length < 4 || inDate.length > 5) {
			ComShowCodeMessage("DMT00165", "DATE");
			sheetObj.SetCellValue(selectedRow, "hol_dt_in","",0);
			sheetObj.SelectCell(selectedRow, "hol_dt_in");
			return false;
		}
		var orgYear=ComGetObjValue(formObj.hol_yr);
		var orgDay=inDate.substring(0, 2);
		var orgMonth=inDate.substring(2);
		var tmpMonth="";
		var displayDate="";
		if (ComIsNumber(orgMonth) && ComIsMonth(orgMonth)) {
			tmpMonth=orgMonth;
			displayDate=orgDay + MonthOfYear[ComParseInt(orgMonth)];
		}
		else if (ComIsAlphabet(orgMonth)) {
			for (var i=1 ; i <= MonthOfYear.length ; i++) {
				if (MonthOfYear[i] == orgMonth) {
					tmpMonth=i + "";
					tmpMonth=tmpMonth.length == 1 ? "0" + tmpMonth : tmpMonth;
					break;
				}
			}
		}
		if (!ComIsDate(orgYear + tmpMonth + orgDay)) {
			ComShowCodeMessage("DMT00165", "DATE");
			sheetObj.SetCellValue(selectedRow, "hol_dt_in","",0);
			sheetObj.SelectCell(selectedRow, "hol_dt_in");
			return false;			
		}
		if (displayDate != "")
			sheetObj.SetCellValue(selectedRow, "hol_dt_in",displayDate,0);
		return true;
	}