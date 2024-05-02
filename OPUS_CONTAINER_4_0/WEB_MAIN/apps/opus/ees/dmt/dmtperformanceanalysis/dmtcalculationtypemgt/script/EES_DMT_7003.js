/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : Calculation Type Inquiry
*@FileTitle  : Some Title 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
	// Common Global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var prefix="sheet1_";
	var COUNTRY="CNT";
	var REGION="RGN";
	var STATE="STE";
	var LOCATION="LOC";
	var ROWMARK="|";
	var FIELDMARK="=";
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
	var duplicateCaller=0;
	var isNoChangeActive=false;
	var isNoInitActive=false;	
	//When Retrieving Location, Location intended to prevent information from being erased
	var isClearLocation=true;
	// Event handler processing by button click event
	document.onclick=processButtonClick;
	
	// Event handler processing by button name
    function processButtonClick(){
    	/***** case in Sheet count are more two by Tab, defining adding sheet *****/
        var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
            switch(srcName) {
 				case "btn_Retrieve":
 					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
 					break;
 				case "btn_New":
 					initSearchControls();
 					break;
 				case "btn_Minimize":
 					var schCondDiv=document.getElementById("sch_cond_div");
 					if(schCondDiv.style.display == 'block') {
 						schCondDiv.style.display='none';
 						sheetObject1.SetSheetHeight(400);
 					} else {
 						schCondDiv.style.display='block';
 						sheetObject1.SetSheetHeight(308);
 					}
 					break;
 				case "btn_DownExcel":
 					if(sheetObject1.RowCount() < 1){//no data
 						ComShowCodeMessage("COM132501");
 					}else{
//parameter changed[check again]CLT
 	 					sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
 					}
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
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        //IBMultiCombo initializing
        for(var k=0;k<comboObjects.length;k++){
        	initCombo(comboObjects[k],k+1);
        }
        initControl();
        OnLoadFinish();
    }
     
    function OnLoadFinish() {
    	var formObj=document.form;
		var sheetObj=sheetObjects[0];
		// Country
		doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH02);
		// Region
		doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH01);
		// New button event
        doActionIBSheet(sheetObj, formObj, IBSEARCH);
        //Country Search Field get ficus
        comboObjects[0].focus(); 
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
            		var HeadTitle="Seq.|Country|Region|State|Location|Bound|Calculation Type|Effective Date|Expiration Date|Creation Date|User Office|User Name";
            		var headCount=ComCountHeadTitle(HeadTitle);

            		SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

            		var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            		var headers = [ { Text:HeadTitle, Align:"Center"} ];
            		InitHeaders(headers, info);

            		var cols = [ {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"seq" },
            		             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cnt_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:prefix+"rgn_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ste_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:prefix+"loc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:prefix+"io_bnd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"dmdt_calc_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"eff_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"exp_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cre_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cre_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cre_usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 } ];
               
            		InitColumns(cols);

            		SetEditable(1);
            		SetCountPosition(0);
		            SetSheetHeight(378);
		            SetHighlightAfterSort(0);
            	}
                break;
        }
    }
     
    // Process of Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:      // Retrieve
			    if(!validateForm(sheetObj,formObj,sAction)) return;
			    
				// 조회결과 초기화 및 Sort 기능이 적용된 경우, 적용해제해 준다.
				sheetObj.RemoveAll();
				
				formObj.f_cmd.value=SEARCH;
				formObj.cnt_cd.value=comboObjects[0].GetSelectText();
				if (Region.innerHTML == "Region") {
					formObj.rgn_cd.value=comboObjects[1].GetSelectText();
					formObj.ste_cd.value="";
				}
				else {
					formObj.rgn_cd.value="";
					formObj.ste_cd.value=comboObjects[1].GetSelectText();
				}
				formObj.loc_cd.value=ComTrimAll(formObj.location.value);
//parameter changed[check again]CLT
				var sXml = sheetObj.GetSearchData("EES_DMT_7003GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix) );
				sheetObj.LoadSearchData(sXml, {Sync:1});				
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
//parameter changed[check again]CLT
 					var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
 					//3.After handling Retrieving results
 					var comboDatas;
 					var comboItems;
 					var comboItem;
 					switch(sComboAction) {
 						//3-1.Search Region (All Region List)
 					    case SEARCH01:
     						comboItems=ComGetEtcData(sXml, REGION).split(ROWMARK);
 							addComboItem(comboObjects[1],comboItems);						
 							break;
 						//3-2.Search Country (All Country List)
 						case SEARCH02:
     						comboItems=ComGetEtcData(sXml, COUNTRY).split(ROWMARK);
 							addComboItem(comboObjects[0],comboItems);						
 							break;
 						//3-3. Search  Region of Country
 						case SEARCH03:
 							//Region combo Empty initialization
 							comboObjects[1].RemoveAll();
 							//Location initialization
 							clearLocation();
 							if (comboObjects[0].GetSelectText()== "CA" || comboObjects[0].GetSelectText()== "US") {
 								comboDatas=ComGetEtcData(sXml, STATE);
 							} else {
 								comboDatas=ComGetEtcData(sXml, REGION);
 							}
 							if (comboDatas != undefined) {
 								comboItems=comboDatas.split(ROWMARK);
 								addComboItem(comboObjects[1],comboItems);	
 							}
 							break;
 						//3-4.Location according to an item, enter higher Country, Region Inquiry
 						case SEARCH04:
 							//Select Country combo with the queried data
 							comboDatas=ComGetEtcData(sXml, COUNTRY);
 							if (comboDatas != undefined) {
 								comboItems=comboDatas.split(ROWMARK);
 								setComboItem(comboObjects[0],comboItems);
 							} 
 							if (comboObjects[0].GetSelectText()== "CA" || comboObjects[0].GetSelectText()== "US") {
 								Region.innerHTML="State";
 								comboDatas=ComGetEtcData(sXml, STATE);
 							} else {
 								Region.innerHTML="Region";
 								comboDatas=ComGetEtcData(sXml, REGION);
 							}
 							if (comboDatas != undefined) {
 								//Region combo reset to Empty
 								comboObjects[1].RemoveAll();
 								comboItems=comboDatas.split(ROWMARK);
 								addComboItem(comboObjects[1],comboItems,true);
 								isClearLocation=true;
 							} else {
 								ComShowCodeMessage('DMT00110');
 								ComClearObject(formObj.location);
 								formObj.location.focus();
 							}
 							break;
 						//3-5.Select an item by Region higher Country Inquiry
 						case SEARCH07:
 							//Select Country combo with the queried data
 							comboDatas=ComGetEtcData(sXml, COUNTRY);
 							if (comboDatas != undefined) {
 								comboItems=comboDatas.split(ROWMARK);
 								setComboItem(comboObjects[0],comboItems);
 							}
 							//Location initialization
 							clearLocation();
 							//Region combo Initialization
 							comboObjects[1].RemoveAll();
 							comboDatas=ComGetEtcData(sXml, REGION);
 							if (comboDatas != undefined) {
 								comboItems=comboDatas.split(ROWMARK);
 								addComboItem(comboObjects[1],comboItems,true);
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
 			    }
 			    break;
        }
        sheetObj.SetWaitImageVisible(1);
    }
     
    /**
     * Select the first item
     */	
    function setComboItem(comboObj,comboItems) {
        var checkedItem=comboItems[0].split(FIELDMARK);
    	comboObj.SetSelectText(checkedItem[0]);
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
    	var comboKey=COUNTRY;
    	switch(comboNo) {
    	    //Country  combo Initialization
			case 1: 
			    with (comboObj) { 
					SetMultiSelect(0);
					SetUseAutoComplete(0);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "30");
					SetColWidth(1, "200");
					SetFontColor("#606060");
					ValidChar(2);	// use upper case
					SetDropHeight(160);
					SetMaxLength(2);
				}
				break;
			//Region  combo Initialization
			case 2: 
				with (comboObj) { 		
					SetMultiSelect(0);
					SetUseAutoComplete(0);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "40");
					SetColWidth(1, "190");
					SetFontColor("#606060");
					ValidChar(2);	// use upper case
					SetDropHeight(160);
					SetMaxLength(3);
				}
				break;	
    	}
    } 	
     
    /*
	 * Country Search Field when there is a change, the part of the Region or State functions that query information
	 */		
    function combo1_OnChange(comboObj, Index_Code, Text) {
        if (isNoChangeActive) return;
    	var formObj=document.form;
    	//var cntCd = ComTrim(comboObj.GetText(Index_Code, 0));
    	var cntCd=comboObj.GetSelectText();
    	if (cntCd.length == 0) return;
    	if (cntCd == "CA" || cntCd == "US") {
    		Region.innerHTML="State";
    	}
    	else {
    		Region.innerHTML="Region";
    	}
    	isNoChangeActive=true;
    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03);
    	isNoInitActive=true;
        isNoChangeActive=false;
    }
     
	/*
	 * Country combo will be a value from the failed attempts FocusOut focus is used to specify the following.
	 */		
    function combo1_OnKeyDown(comboObj, KeyCode, Shift) {
    	if (KeyCode == 9)	//Tab key
    		comboObjects[0].focus();
    	else if (KeyCode == 13)	//Enter key
    		comboObjects[1].focus();
    }	
	
     /*
	 *Region or State Search Field case is changed, Location Search Field and initializing functions that
	 */	
    function combo2_OnChange(comboObj, Index_Code, Text) {
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
    		if (locCd.length > 0) {
    			isClearLocation=false;
				isNoChangeActive=true;
    			doActionIBCombo(sheetObjects[0], formObj, IBSEARCH, SEARCH04);
				isNoInitActive=true;
				isNoChangeActive=false;
			}
    	}		
	}
	
	/*
	 * Searching fields to enter information of the screen is stored in a lookup field values??.
	 */		
	function setParameters(sAction) {
		var formObj=document.form;
		ComSetObjValue(formObj.cnt_cd, comboObjects[0].GetSelectText());			//Country
		ComSetObjValue(formObj.loc_cd, ComGetObjValue(formObj.location));//Location		
		ComSetObjValue(formObj.f_cmd, sAction);							//Command
	}
	
	function initControl() {
	   // axon_event.addListenerFormat('keypress', 'obj_keypress', 'form', );    
	    axon_event.addListener('beforedeactivate', 'obj_deactivate', 'location');
	    axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	}
	
	/*
	 * Location field, enter the letters converted to upper case
	 */		
	
	
	
	
	function obj_keypress(){ 
	    obj=event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus=obj.dataformat;
	    switch(obj.dataformat) {
	        case "engup":
	          	ComKeyOnlyAlphabet('uppernum');          
	            break;   
	    }   
	}
	
	/*
	 * Location FocusOut, input digits for the Validation Check
	 */
	function obj_deactivate() {
		obj=event.srcElement;
		if(obj.value.length > 0 && obj.value.length < 5) {
			ComShowCodeMessage('DMT00110');
			ComClearObject(obj);
		}
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
	 * Search Field initializing
	 */		
	function initSearchControls() {
		var formObj=document.form;
		comboObjects[0].SetSelectText("");//Country ComboBox
		comboObjects[1].RemoveAll();	//Region or State ComboBox
		Region.innerHTML="Region";	//Region Caption
		ComSetObjValue(formObj.cnt_cd, "");
		ComSetObjValue(formObj.rgn_cd, "");
		ComSetObjValue(formObj.ste_cd, "");
		ComSetObjValue(formObj.loc_cd, "");
		ComSetObjValue(formObj.location, "");
		isNoInitActive=false;	
	}
	
    function resetAll() {
    	var formObj = document.form;
    	
    	ComResetAll();
		Region.innerHTML = "Region";	//Region Caption
		ComSetObjValue(formObj.cnt_cd, 			"");
		ComSetObjValue(formObj.rgn_cd, 			"");
		ComSetObjValue(formObj.ste_cd, 			"");
		ComSetObjValue(formObj.loc_cd, 			"");
		ComSetObjValue(formObj.location, 		"");    	
    }
    
	/*
	 * htmlControl event initializing
	 */	
	function initSearchControls() {
		var formObj=document.form;
		isNoInitActive=false;	
		resetAll();
		doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01);
	}
	
	/**
     *  handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
	       	 if(sAction == IBSEARCH) {
	       		 if(!formObj.val_curr.checked && !formObj.val_tobe.checked && !formObj.val_exp.checked) {
	       			 ComShowCodeMessage('COM12114', "Validity");
	       			 return false;
	       		 }
	       		 if(location.value != '' && location.value.length < 5) {
					ComShowCodeMessage('DMT00110');
					ComClearObject(location);
					return false;
	       		 }
	       	 }
        }
        return true;
    }

    function sheet1_OnSort(sheetObj, Col, SortArrow){
        sheetObj.ReNumberSeq();   
    }