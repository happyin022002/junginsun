/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   :  EES_DMT_1006.js
*@FileTitle  : Commodity Exception Tariff Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

    // Common Global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	//  Business Global Variables
    var CONTINENT="CONTI";
    var COUNTRY="CNT";
    var REGION="RGN";
    var STATE="STE";
    var LOCATION="LOC";
    var ALL_TARIFF_CD="all_tariff_cd"; 
	var ROWMARK="|";
	var FIELDMARK="=";
	var isNoChangeActive=false;
	var DEF_SHEET_HEIGHT = 409;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
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
					initControl();
					break;
				case "btn_DownExcel":
					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
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
    	//alert("2_10");
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
     //IBMultiCombo initializing
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],k+1);
	    }
        initAxonControl();
        
        sheet1_OnLoadFinish(sheet1);
    }
    
    
    function sheet1_OnLoadFinish(sheetObj) {
    	var formObj=document.form;
    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCHLIST10,"","");
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH08,CONTINENT,comboObjects[0]);		//1
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH02,COUNTRY,comboObjects[1]);		//2
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObjects[2]);			//3
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH08,CONTINENT,comboObjects[3]);		//4
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH02,COUNTRY,comboObjects[4]);		//5
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObjects[5]);			//6
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH09,ALL_TARIFF_CD,comboObjects[6]);	//7
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
                
              var HeadTitle1="|Seq.|Confirmed|Tariff|Coverage|ORG/Dest|Commodity|Commodity|Commodity|EFF DT|EXP DT|Free Time|Free Time|F/T Exclusion|F/T Exclusion|F/T Exclusion|Update|Update|Update|expire_chk|wknd1|wknd2";
              var HeadTitle2="|Seq.|Confirmed|Tariff|Coverage|ORG/Dest|Code|Description|Rep.|EFF DT|EXP DT|Add|Total|SAT|SUN|HOLI|Date|Office|Name|expire_chk|wknd1|wknd2";
              var headCount=ComCountHeadTitle(HeadTitle1);
              //(headCount, 0, 0, true);

              SetConfig( { SearchMode:2, FrozenCol:9, MergeSheet:5, Page:20, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"},
                          { Text:HeadTitle2, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"hdnStatus" },
                     {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"SEQ",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cfm_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1,  ToolTipText:"Basic Tariff Confirmed and applicable"},
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_trf_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"covrg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"org_dest",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:260,  Align:"Left",    ColMerge:1,   SaveName:"cmdt_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rep_cmdt_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_add_dys",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_ttl_dys",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"xcld_sat_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"xcld_sun_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"xcld_hol_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"upd_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"upd_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"upd_usr_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:20 },
                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"expire_chk",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"wknd1",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"wknd2",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
               
              InitColumns(cols);

              SetEditable(1);
              SetCountPosition(0);
              FrozenCols=SaveNameCol("eff_dt");
              SetSheetHeight(DEF_SHEET_HEIGHT);
              }
              break;
        }
    }
    // Process of Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	//alert("2_9");
    	sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBSEARCH:      // Retrieve
				//1.Inquiry ago, the parameter is set to a value type or allows selected.
        		ComSetObjValue(formObj.f_cmd, SEARCH);	
				setParameters(SEARCH);
				if (validateForm(sheetObj,formObj,sAction)) {
					if (sheetObj.id == "sheet1") {
						//2.Inquiry ago, the result makes Empty fields.
						initResultControls();
	                    //ComOpenWait Start
	                    sheetObj.SetWaitImageVisible(0);
	                    ComOpenWait(true);
						//2.Inquiry as a query is run conditions
	                    sheetObj.DoSearch("EES_DMT_1006GS.do", FormQueryString(formObj) );
	                    
					}
				}
				break;	
		case IBDOWNEXCEL:	// EXCEL DOWNLOAD
			if (sheetObj.id == "sheet1") {
				if (sheetObj.RowCount()== 0 ) {
			   		ComShowCodeMessage("COM132501"); // No data to dowload as Excel
			   	    return;
			   	} else {
			   		sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
			   	}
				
			}; 
			break;
		}			
    }    
    
    function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    	//ComOpenWait End
        ComOpenWait(false);
		//3.Expired Validity
		for(var i=0; i<= sheetObj.RowCount()+1; i++) {
			if(sheetObj.GetCellValue(i, "expire_chk") == "Y") {
				sheetObj.SetCellFontColor(i, 6,"#FF0000");
				sheetObj.SetCellFontColor(i, 7,"#FF0000");
				sheetObj.SetCellFontColor(i, 8,"#FF0000");
			}
		}
		sheetObj.SetCellValue(1,"xcld_sat_flg",sheetObj.GetCellValue(2,"wknd1"));
		sheetObj.SetCellValue(1,"xcld_sun_flg",sheetObj.GetCellValue(2,"wknd2"));
    }
    
    
	function initAxonControl() {  
		//alert("2_8");
		axon_event.addListenerFormat('blur',	'obj_blur',		form); // out of focus
		axon_event.addListenerFormat('keypress',		'obj_keypress',    form); // Keyboard input
		axon_event.addListener('keydown', 'obj_keydown',  'cvrg_location', 'org_dest_location');	
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
	function obj_blur() {
		//alert("3_1");
		obj=event.srcElement;
		if(obj.value.length > 0 && obj.value.length < 5) {
			ComShowCodeMessage('DMT00110');
			ComClearObject(obj);
		}
	}
	function obj_keydown() {
		//alert("3_1");
		if(event.keyCode == 13) {
			//obj = event.srcElement;
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}
	}
	/**
     *  handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
    	//Validity check
    	if(!formObj.validity1.checked && !formObj.validity2.checked && !formObj.validity3.checked) {
    		ComShowCodeMessage('COM12114', "Validity");
    		return false;
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
	    var formObj=document.form
	    //alert(comboNo);
	    switch(comboNo) {  
	    	//Continent
	    	case 1: 
	    	case 4:
	    		with (comboObj) { 
	    			SetMultiSelect(0);
					SetUseAutoComplete(0);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "30");
					SetColWidth(1, "100");
					SetDropHeight(160);
					ValidChar(2);
//no support[check again]CLT 					ValidChar(2,0);		
//no support[check again]CLT 					IMEMode=0;
					SetMaxLength(1);
	    		}
	    		//doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH08,CONTINENT,comboObj);
				break;
			//Country
	    	case 2:
	    	case 5:
	    		with (comboObj) {
	    			SetMultiSelect(0);
  					SetUseAutoComplete(0);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "30");
					SetColWidth(1, "200");
	    			SetDropHeight(160);
	    			ValidChar(2);
//no support[check again]CLT 					ValidChar(2,0);		
//no support[check again]CLT 					IMEMode=0;
					SetMaxLength(2);
	    		}
	    		//doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH02,COUNTRY,comboObj);
	    		break;
	    	//Region
	    	case 3:
	    	case 6:
	    		with (comboObj) {
  					SetMultiSelect(0);
  					SetUseAutoComplete(0);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "40");
					SetColWidth(1, "200");
  					SetDropHeight(160);
  					ValidChar(2);
//no support[check again]CLT 					ValidChar(2,0);		
//no support[check again]CLT 					IMEMode=0;
					SetMaxLength(3);
	    		}
	    		//doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObj);
	    		break;
	    	//Tariff Type
	    	case 7:
	    		with (comboObj) {
  					SetMultiSelect(1);
  					SetUseAutoComplete(1);
  					SetMultiSeparator(",");
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "55");
					SetColWidth(1, "330");
  					//SetDropHeight(160);
	    		}
	    		//doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH09,ALL_TARIFF_CD,comboObj);
	    		break;
	     } 
	} 	
	/*
	 * Changes Continent Search Field, if it's part of Country, Region or State functions that query information
	 */		
	
	function combo1_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, Text, Index_Code) {
		//alert("1_3");
		search_combo1(comboObj, Index_Code, Text);
	}
	
	
	function search_combo1(comboObj, searchIndex, searchText) {
		//alert("1_1");
		if (comboObj.GetSelectText().length == 0 ) return;
		if (isNoChangeActive) return;
		var formObj=document.form;
		
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,comboObj);
		//Region initialization
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObj);
		//Location initialization
		clearLocation1();
	}
	function combo1_OnKeyDown(comboObj, KeyCode, Shift) {
		//alert("1_2");
		if(KeyCode == 13) {
			var sIndexCode=comboObj.GetSelectIndex();
			var sText=comboObj.GetSelectText();
			search_combo1(comboObj, sIndexCode, sText);
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}	
	/*
	 * Country Search Field when there is a change, the part of the Region or State functions that query information
	 */		
	function combo2_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, Text, Index_Code) {
		search_combo2(comboObj, Index_Code, Text);
	}
	function search_combo2(comboObj, searchIndex, searchText) {
		if (comboObj.GetSelectText().length == 0 ) return;
		if (isNoChangeActive)	return;
		if (comboObj.GetSelectText()== "CA" || comboObj.GetSelectText()== 'US') {
			Region.innerHTML="State";
		} else {
			Region.innerHTML="Region";
		}
		var formObj=document.form;
		isNoChangeActive=true;
		//Continent 
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH12,CONTINENT,comboObj);
		//Region 
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,REGION,comboObj);
		isNoChangeActive=false;
		//Location initialization
		clearLocation1();
	}	
	function combo2_OnKeyDown(comboObj, KeyCode, Shift) {
		if(KeyCode == 13) {
			var sIndexCode=comboObj.GetSelectIndex();
			var sText=comboObj.GetSelectText();
			search_combo2(comboObj, sIndexCode, sText);
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}	
	/*
	 *Region or State Search Field case is changed, Location Search Field and initializing functions that
	 */	
	function combo3_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, Text, Index_Code) {
		search_combo3(comboObj, Index_Code, Text);
	}
	function search_combo3(comboObj, searchIndex, searchText) {
		var region_len=comboObj.GetSelectText().length ;
		if (region_len == 0)	return;
		if (isNoChangeActive)	return;
		var formObj=document.form;
		isNoChangeActive=true;
		if(region_len == 2) {
			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH17,STATE,comboObj);	//searchHierarchyByState
		}else{
			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH13,REGION,comboObj);	//searchHierarchyByRegion
		}
		isNoChangeActive=false;
	}	
	function combo3_OnKeyDown(comboObj, KeyCode, Shift) {
		if(KeyCode == 13) {
			var sIndexCode=comboObj.GetSelectIndex();
			var sText=comboObj.GetSelectText();
			search_combo3(comboObj, sIndexCode, sText);
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}	
	/*
	 * Location Search Field, if entered in the Enter Key, Location that contains the Continent, Country and Region or State functions to query information
	 */		
	function checkLocation1(obj) {
		//alert("1_4");
		if(isAlpha()) {
			if (isNoChangeActive) return;
			var formObj=document.form;
	    	if (ComTrim(ComGetObjValue(obj)).length == 5) {
				var locCd=ComTrim(ComGetObjValue(obj));
	    		if (locCd.length > 0) {
	    			if(locCd.substring(0,2) == "CA" || locCd.substring(0,2) == "US") {
	    				Region.innerHTML="State";
	    			}else{
	    				Region.innerHTML="Region";
	    			}
	    			isNoChangeActive=true;
	    			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH10,LOCATION,obj);
	    			isNoChangeActive=false;
				}
	    	}		
		}
	}
	/*
	 * Changes Continent Search Field, if it's part of Country, Region or State functions that query information
	 */		
	function combo4_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, Text, Index_Code) {
		search_combo4(comboObj, Index_Code, Text);
	}
	function search_combo4(comboObj, searchIndex, searchText) {
		if (comboObj.GetSelectText().length == 0 ) return;
		if (isNoChangeActive) return;
		var formObj=document.form;
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,comboObj);
	}
	function combo4_OnKeyDown(comboObj, KeyCode, Shift) {
		if(KeyCode == 13) {
			var sIndexCode=comboObj.GetSelectIndex();
			var sText=comboObj.GetSelectText();
			search_combo4(comboObj, sIndexCode, sText);
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}	
	/*
	 * Country Search Field when there is a change, the part of the Region or State functions that query information
	 */		
	function combo5_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, Text, Index_Code) {
		search_combo5(comboObj, Index_Code, Text);
	}
	function search_combo5(comboObj, searchIndex, searchText) {
		if (isNoChangeActive) 			return;
		if (comboObj.GetSelectText().length == 0 ) return;
		if (comboObj.GetSelectText()== "CA" || comboObj.GetSelectText()== 'US') {
			Region2.innerHTML="State";
		} else {
			Region2.innerHTML="Region";
		}
		var formObj=document.form;
		isNoChangeActive=true;
		//Continent - set
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH12,CONTINENT,comboObj);
		//Region 
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,REGION,comboObj);
		isNoChangeActive=false;
	}
	function combo5_OnKeyDown(comboObj, KeyCode, Shift) {
		if(KeyCode == 13) {
			var sIndexCode=comboObj.GetSelectIndex();
			var sText=comboObj.GetSelectText();
			search_combo5(comboObj, sIndexCode, sText);
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}	
	/*
	 *Region or State Search Field case is changed, Location Search Field and initializing functions that
	 */	
	function combo6_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, Text, Index_Code) {
		search_combo6(comboObj, Index_Code, Text);
	}
	function search_combo6(comboObj, searchIndex, searchText) {
		if (isNoChangeActive) 			return;
		if (comboObj.GetSelectText().length == 0)	return;
		var formObj=document.form;
		isNoChangeActive=true;
		if(comboObj.GetSelectText().length == 2) {
			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH17,STATE,comboObj);	//searchHierarchyByState
		}else{
			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH13,REGION,comboObj);	//searchHierarchyByRegion
		}
		isNoChangeActive=false;
	}	
	function combo6_OnKeyDown(comboObj, KeyCode, Shift) {
		if(KeyCode == 13) {
			var sIndexCode=comboObj.GetSelectIndex();
			var sText=comboObj.GetSelectText();
			search_combo6(comboObj, sIndexCode, sText);
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}	
	/*
	 * Location Search Field, if entered in the Enter Key, Location that contains the Continent, Country and Region or State functions to query information
	 */		
	function checkLocation2(obj) {
		//alert("1_7");
		if(isAlpha()) {
			if (isNoChangeActive) return;
			var formObj=document.form;
	    	if (ComTrim(ComGetObjValue(obj)).length == 5) {
				var locCd=ComTrim(ComGetObjValue(obj));
	    		if (locCd.length > 0) {
	    			if(locCd.substring(0,2) == "CA" || locCd.substring(0,2) == "US") {
	    				Region2.innerHTML="State";
	    			}else{
	    				Region2.innerHTML="Region";
	    			}
	    			isNoChangeActive=true;
	    			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH10,LOCATION,obj);
	    			isNoChangeActive=false;
				}
	    	}		
		}
	}
	function clearObjectValue(obj) {
		//alert("1_8");
		switch(ComGetEvent("name")) {
			case "cvrg_location":
			case "org_dest_location":
				obj.value="";
				break;
			default:
				obj.SetSelectText("");
				break;
		}
	}
	//Multi Combo click event
/*	function combo7_OnCheckClick(comboObj, index, code) {
		setMultiCombo(comboObj, index, code) ;
	}*/
	// Search criteria field data retrieval Combo
    function doActionIBCombo(sheetObj,formObj,sAction,sComboAction,sComboKey,sObj) {
    	//alert("1_9");
        sheetObj.ShowDebugMsg(false);
		sheetObj.SetWaitImageVisible(0);
		var index_1=0;
		var index_2=0;
		var index_3=0;
		switch(sAction) {
			case IBSEARCH:      // Search
				if (sheetObj.id == "sheet1") {
					//3.After handling Retrieving results
					var comboDatas;
					var comboItems;
					switch(sComboAction) {
						case SEARCHLIST10:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							ComSetObjValue(formObj.f_cmd, SEARCHLIST10); 
							//2.Inquiry as a query is run conditions                 
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							//Coverage Continent
							comboDatas=ComGetEtcData(sXml, CONTINENT);
							if (comboDatas != undefined) {
								comboItems=comboDatas.split(ROWMARK);
								//Change the selection to a usable state
								comboObjects[0].SetSelectCode("-1");
								comboObjects[0].RemoveAll();
								addComboItem(comboObjects[0],comboItems);
							}
							//Coverage Country 
							comboDatas=ComGetEtcData(sXml, COUNTRY);
							if (comboDatas != undefined) {
								comboItems=comboDatas.split(ROWMARK);
								comboObjects[1].SetSelectCode("-1");
								comboObjects[1].RemoveAll();
								addComboItem(comboObjects[1],comboItems); //COUNTRY
							}
							//Coverage Region
							comboDatas=ComGetEtcData(sXml, REGION);
							if (comboDatas != undefined) {
								comboItems=comboDatas.split(ROWMARK);
								comboObjects[2].SetSelectCode("-1");
								comboObjects[2].RemoveAll();
								addComboItem(comboObjects[2],comboItems); //Region
							}
							//Coverage Continent
							comboDatas=ComGetEtcData(sXml, CONTINENT);
							if (comboDatas != undefined) {
								comboItems=comboDatas.split(ROWMARK);
								//Change the selection to a usable state
								comboObjects[3].SetSelectCode("-1");
								comboObjects[3].RemoveAll();
								addComboItem(comboObjects[3],comboItems);
							}
							//Coverage Country 
							comboDatas=ComGetEtcData(sXml, COUNTRY);
							if (comboDatas != undefined) {
								comboItems=comboDatas.split(ROWMARK);
								comboObjects[4].SetSelectCode("-1");
								comboObjects[4].RemoveAll();
								addComboItem(comboObjects[4],comboItems); //COUNTRY
							}
							//Coverage Region
							comboDatas=ComGetEtcData(sXml, REGION);
							if (comboDatas != undefined) {
								comboItems=comboDatas.split(ROWMARK);
								comboObjects[5].SetSelectCode("-1");
								comboObjects[5].RemoveAll();
								addComboItem(comboObjects[5],comboItems); //Region
							}
							//TARIFF LIST
							comboItems=ComGetEtcData(sXml, ALL_TARIFF_CD).split(ROWMARK);	
							addComboItem(comboObjects[6], comboItems);
							break;        		   
						//1. CONTINENT LIST
						case SEARCH08:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							ComSetObjValue(formObj.f_cmd, SEARCH08); 
							setComboParameters(sComboAction, sObj);
							//2.Inquiry as a query is run conditions
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							if(sObj.options.id == "combo1") {
								index_1=0;
							} else {
								index_1=3;
							}
							comboDatas=ComGetEtcData(sXml, sComboKey);
							if (comboDatas != undefined) {
								comboItems=comboDatas.split(ROWMARK);
								comboObjects[index_1].SetSelectCode("-1");
								comboObjects[index_1].RemoveAll();
								addComboItem(comboObjects[index_1],comboItems);	//CONTINENT
							}else{
								//ComShowCodeMessage("DMT06001");
								//clearObjectValue(sObj);
							}
							break;
						//2. COUNTRY LIST
						case SEARCH02:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							ComSetObjValue(formObj.f_cmd, SEARCH02); 
							setComboParameters(sComboAction, sObj);
							//2.Inquiry as a query is run conditions
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							if(sObj.options.id == "combo2") {
								index_1=1;
							} else {
								index_1=4;
							}
							comboDatas=ComGetEtcData(sXml, sComboKey);
							if (comboDatas != undefined) {
								comboItems=comboDatas.split(ROWMARK);
								comboObjects[index_1].SetSelectCode("-1");
								comboObjects[index_1].RemoveAll();
								addComboItem(comboObjects[index_1],comboItems);	//COUNTRY
							}else{
								//ComShowCodeMessage("DMT06001");
								//clearObjectValue(sObj);
							}
							break;
						//3. REGION LIST
						case SEARCH01:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							ComSetObjValue(formObj.f_cmd, SEARCH01); 
							setComboParameters(sComboAction, sObj);
							//2.Inquiry as a query is run conditions
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							if(sObj.options.id == "combo3" || sObj.options.id == "combo1") {
								index_1=2;
							} else {
								index_1=5;
							} 
							comboDatas=ComGetEtcData(sXml, sComboKey);
							if (comboDatas != undefined) {
								comboItems=comboDatas.split(ROWMARK);
								comboObjects[index_1].SetSelectCode("-1");
								comboObjects[index_1].RemoveAll();
								addComboItem(comboObjects[index_1],comboItems);	//REGION
							}else{
								//ComShowCodeMessage("DMT06001");
								//clearObjectValue(sObj);
							}
							break;
						//4.  Search CONTRY of Continent 
						case SEARCH06:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							ComSetObjValue(formObj.f_cmd, SEARCH06);
							setComboParameters(sComboAction, sObj);
							//2.Inquiry as a query is run conditions   
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));

                            var sObj_name = "";
                            if ( sObj.name == "cvrg_location" || sObj.name == "org_dest_location"){
                            	sObj_name = sObj.name;
                            } else {
                            	sObj_name = sObj.options.id;
                            }
                            							
							if(sObj_name == "combo1" || sObj_name == "combo3" || sObj_name == "cvrg_location") {
								index_1=1;
							}else{
								index_1=4;
							}
							
							
							comboDatas=ComGetEtcData(sXml, COUNTRY);
							if (comboDatas != undefined) {
								
								if(comboDatas != "") {
									comboItems=comboDatas.split(ROWMARK);
									comboObjects[index_1].SetSelectCode("-1");
									comboObjects[index_1].RemoveAll();
									addComboItem(comboObjects[index_1],comboItems);	//Country
								}else{
									//ComShowCodeMessage("DMT06001");
									//clearObjectValue(sObj);
								}	
							}else{
								//ComShowCodeMessage("DMT06001");
								//clearObjectValue(sObj);
							}
							break;
						//5.  search  Continent  of Country
						case SEARCH12:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							ComSetObjValue(formObj.f_cmd, SEARCH12); 
							setComboParameters(sComboAction, sObj);
							//2.Inquiry as a query is run conditions                 
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							if(sObj.options.id == "combo2") {
								index_1=0;
							} else {
								index_1=3;
							}
							comboDatas=ComGetEtcData(sXml, CONTINENT);
							if( comboDatas != undefined) {
								comboItems=comboDatas.split(ROWMARK);
								setComboItem(comboObjects[index_1],comboItems);	//Continent
							}else{
								//ComShowCodeMessage("DMT06001");
								//clearObjectValue(sObj);
							}
							break;
						//5. Corresponding changes at Country Region Information Inquiry
						case SEARCH03:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							ComSetObjValue(formObj.f_cmd, SEARCH03); 
							setComboParameters(sComboAction, sObj);
							//2.Inquiry as a query is run conditions                 
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));

                            var sObj_name = "";
                            if ( sObj.name == "cvrg_location" || sObj.name == "org_dest_location"){
                            	sObj_name = sObj.name;
                            } else {
                            	sObj_name = sObj.options.id;
                            }
                            							
							if(sObj_name == "combo2" || sObj_name == "combo3" || sObj_name == "cvrg_location") {
								index_1=1;
								index_2=2;
								clearLocation1();
							} else {
								index_1=4;
								index_2=5;
								clearLocation2();
							}
							if(comboObjects[index_1].GetSelectText()== "CA" || comboObjects[index_1].GetSelectText()== "US" ) {
								//State
								comboDatas=ComGetEtcData(sXml, STATE);
							}else{
	                                                                                                                                                                                        									//Region
								comboDatas=ComGetEtcData(sXml, REGION);
							}
							if(comboDatas != undefined) {
								comboItems=comboDatas.split(ROWMARK);
								comboObjects[index_2].SetSelectCode("-1");
								comboObjects[index_2].RemoveAll();				//Region
								addComboItem(comboObjects[index_2],comboItems);
							}else {
								//ComShowCodeMessage("DMT06001");
								//clearObjectValue(sObj);
							}
							break;
						//6. State, Region at the time of change, the corresponding Continet, Country, State Lookup
						case SEARCH17:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							ComSetObjValue(formObj.f_cmd, SEARCH17); 
							setComboParameters(sComboAction, sObj);
							//2.Inquiry as a query is run conditions                 
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							if(sObj.options.id == "combo3") {
								index_1=0;
								index_2=1;
								index_3=2;
								clearLocation1();
							} else {
								index_1=3;
								index_2=4;
								index_3=5;
								clearLocation2();
							}
							//Select Country combo with the queried data
							comboDatas=ComGetEtcData(sXml, CONTINENT);
							if (comboDatas != undefined) {
								//Continent Setting
								comboItems=comboDatas.split(ROWMARK);
								setComboItem(comboObjects[index_1],comboItems);		//Continent
								//Country List 
								comboObjects[index_2].SetSelectCode("-1");
								comboObjects[index_2].RemoveAll();
								doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,sObj);//searchCountryListByContinent
								//Country Setting
								comboDatas=ComGetEtcData(sXml, COUNTRY);
								if (comboDatas != undefined) {
									comboItems=comboDatas.split(ROWMARK);
									setComboItem(comboObjects[index_2],comboItems);	//Country
									//Region/State List 
									comboObjects[index_3].SetSelectCode("-1");
									comboObjects[index_3].RemoveAll();				//Region
									doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,COUNTRY,sObj);//searchRegionListByCountry
									comboDatas=ComGetEtcData(sXml, sComboKey);
									if (comboDatas != undefined) {
										comboItems=comboDatas.split(ROWMARK);
										setComboItem(comboObjects[index_3],comboItems);	//Region
									}else{
										//ComShowCodeMessage("DMT06001");
										//clearObjectValue(sObj);
									}
								}else{
									//ComShowCodeMessage("DMT06001");
									//clearObjectValue(sObj);
								}							
							}else{
								//ComShowCodeMessage("DMT06001");
								//clearObjectValue(sObj);
							}
							break;
						case SEARCH13:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							ComSetObjValue(formObj.f_cmd, SEARCH13); 
							setComboParameters(sComboAction, sObj);
							//2.Inquiry as a query is run conditions                 
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							if(sObj.options.id == "combo3") {
								index_1=0;
								index_2=1;
								index_3=2;
								clearLocation1();
							} else {
								index_1=3;
								index_2=4;
								index_3=5;
								clearLocation2();
							}
							//Select Country combo with the queried data
							comboDatas=ComGetEtcData(sXml, CONTINENT);
							if (comboDatas != undefined) {
								//Continent Setting
								comboItems=comboDatas.split(ROWMARK);
								setComboItem(comboObjects[index_1],comboItems);		//Continent
								//Country List 
								comboObjects[index_2].SetSelectCode("-1");
								comboObjects[index_2].RemoveAll();
								doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,sObj);//searchCountryListByContinent
								//Country Setting
								comboDatas=ComGetEtcData(sXml, COUNTRY);
								if (comboDatas != undefined) {
									comboItems=comboDatas.split(ROWMARK);
									setComboItem(comboObjects[index_2],comboItems);	//Country
									//Region/State List 
									comboObjects[index_3].SetSelectCode("-1");
									comboObjects[index_3].RemoveAll();				//Region
									doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,COUNTRY,sObj);//searchRegionListByCountry
									comboDatas=ComGetEtcData(sXml, sComboKey);
									if (comboDatas != undefined) {
										comboItems=comboDatas.split(ROWMARK);
										setComboItem(comboObjects[index_3],comboItems);	//Region
									}else{
										//ComShowCodeMessage("DMT06001");
										//clearObjectValue(sObj);
									}
								}else{
									//ComShowCodeMessage("DMT06001");
									//clearObjectValue(sObj);
								}							
							}else{
								//ComShowCodeMessage("DMT06001");
								//clearObjectValue(sObj);
							}
							break;
						//4. Location, input Inquiry
						case SEARCH10:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							ComSetObjValue(formObj.f_cmd, SEARCH10); 
							setComboParameters(sComboAction, sObj);
							//2.Inquiry as a query is run conditions                 
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							var location=ComGetObjValue(sObj);
							if(sObj.name == "cvrg_location") {
								index_1=0;
								index_2=1;	//Location initialization
								index_3=2;
								clearLocation1();
							} else {
								index_1=3;
								index_2=4;
								index_3=5;
								clearLocation2();
							}
							//Continent 
							comboDatas=ComGetEtcData(sXml, CONTINENT);
							if (comboDatas != undefined) {
								comboItems=comboDatas.split(ROWMARK);
								//Continent Setting
								setComboItem(comboObjects[index_1],comboItems);		//Continent
								//Country List 
								comboObjects[index_2].SetSelectCode("-1");
								comboObjects[index_2].RemoveAll();					//Country
								doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,sObj);//searchCountryListByContinent
								//Country Setting
								comboDatas=ComGetEtcData(sXml, COUNTRY);
								if (comboDatas != undefined) {
									comboItems=comboDatas.split(ROWMARK);
									setComboItem(comboObjects[index_2],comboItems);
									//Region/State List 
									comboObjects[index_3].SetSelectCode("-1");
									comboObjects[index_3].RemoveAll();				//Region
									doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,COUNTRY,sObj);//searchRegionListByCountry
									if(location.substring(0,2) == "CA" || location.substring(0,2) == "US") {
										comboDatas=ComGetEtcData(sXml, STATE);
					    			}else{
										comboDatas=ComGetEtcData(sXml, REGION);
					    			}
									if (comboDatas != undefined) {
										comboItems=comboDatas.split(ROWMARK);
										setComboItem(comboObjects[index_3],comboItems);	//Region
										//location setting
										ComSetObjValue(sObj, location);
									}else{
										//ComShowCodeMessage("DMT06001");
										//clearObjectValue(sObj);
									}
								}else{
									//ComShowCodeMessage("DMT06001");
									//clearObjectValue(sObj);
								}
							}else{
					    		//ComAlertFocus(sObj, ComGetMsg('DMT00110'));
								//clearObjectValue(sObj);
							}
							break;
						//ALL_TARIFF_TYPE
						case SEARCH09:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							ComSetObjValue(formObj.f_cmd, SEARCH09); 
							//2.Inquiry as a query is run conditions                 
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							comboItems=ComGetEtcData(sXml, sComboKey).split(ROWMARK);
							addComboItem(sObj,comboItems);						
							for (var i=0 ; i < comboItems.length ; i++) {
					    		var comboItem=comboItems[i].split(FIELDMARK);
					    		sObj.SetItemCheck(i,1);
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
	function addComboItem(comboObj, comboItems) {
		//alert("1_10");
    	for (var i=0 ; i < comboItems.length ; i++) {
    		var comboItem=comboItems[i].split(FIELDMARK);
			comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[1]);		
    	}   		
	}
	/**
     * add data  combo field 
     */	
	function addComboItem2(comboObj, comboItems) {
		//alert("2_7");
    	for (var i=0 ; i < comboItems.length ; i++) {
    		var comboItem=comboItems[i].split(FIELDMARK);
    		comboObj.InsertItem(i, ComReplaceStr(comboItem[1],"^"," - ") , comboItem[0]);
    	}   		
	}
	/**
     * add data  combo field 
     */	
	function addComboItem1(comboObj, comboItems) {
		//alert("1_11");
    	for (var i=0 ; i < comboItems.length ; i++) {
    		
    		var comboItem=comboItems[i].split(FIELDMARK);
			comboObj.InsertItem(i, comboItem[1], comboItem[0]);		
    	}   		
	}
	/*
	 * Searching fields to enter information of the screen is stored in a lookup field values??.
	 */		
	function setParameters(sAction) {
		//alert("1_12");
		var formObj=document.form;
		//Coverage ComboSetting
		ComSetObjValue(formObj.cvrg_conti_cd, comboObjects[0].GetSelectText());
		ComSetObjValue(formObj.cvrg_cnt_cd, comboObjects[1].GetSelectText());
		
		if(Region.innerHTML == "State") {
			ComSetObjValue(formObj.cvrg_ste_cd, comboObjects[2].GetSelectText());
		}else{
			ComSetObjValue(formObj.cvrg_rgn_cd, comboObjects[2].GetSelectText());
		}
		
		ComSetObjValue(formObj.cvrg_loc_cd, ComGetObjValue(formObj.cvrg_location));
		//Origin/Dest ComboSettion
		ComSetObjValue(formObj.org_dest_conti_cd, comboObjects[3].GetSelectText());
		ComSetObjValue(formObj.org_dest_cnt_cd, comboObjects[4].GetSelectText());
		
		if(Region2.innerHTML == "State") {
			ComSetObjValue(formObj.org_dest_ste_cd, comboObjects[5].GetSelectText());
		}else{
			ComSetObjValue(formObj.org_dest_rgn_cd, comboObjects[5].GetSelectText());
		}
		
		ComSetObjValue(formObj.org_dest_loc_cd, ComGetObjValue(formObj.org_dest_location));
		//others
		ComSetObjValue(formObj.dmdt_trf_cd_list, comboObjects[6].GetSelectText());
	}
	/*
	 * Common code is Inquiry for Combo
	 */
	function setComboParameters(sComboAction, sObj) {
		//alert("1_13");
		var formObj=document.form;

        var sObj_name = "";
        if ( sObj.name == "cvrg_location" || sObj.name == "org_dest_location"){
        	sObj_name = sObj.name;
        } else {
        	sObj_name = sObj.options.id;
        }
        							
		switch(sObj_name) {
			case "combo1":
			case "combo2":
			case "combo3":
			case "cvrg_location":
				//Coverage ComboSetting
				ComSetObjValue(formObj.conti_cd, comboObjects[0].GetSelectText());
				ComSetObjValue(formObj.cnt_cd, comboObjects[1].GetSelectText());
				ComSetObjValue(formObj.rgn_cd, comboObjects[2].GetSelectText());
				ComSetObjValue(formObj.ste_cd, comboObjects[2].GetSelectText());
				ComSetObjValue(formObj.loc_cd, ComGetObjValue(formObj.cvrg_location));
				break;
			case "combo4":
			case "combo5":
			case "combo6":
			case "org_dest_location":
				//Origin/Dest ComboSettion
				ComSetObjValue(formObj.conti_cd, comboObjects[3].GetSelectText());
				ComSetObjValue(formObj.cnt_cd, comboObjects[4].GetSelectText());
				ComSetObjValue(formObj.rgn_cd, comboObjects[5].GetSelectText());
				ComSetObjValue(formObj.ste_cd, comboObjects[5].GetSelectText());
				ComSetObjValue(formObj.loc_cd, ComGetObjValue(formObj.org_dest_location));
				break;	
		}
	}
	
	var selComboIndex, selComboCode;
	function combo7_OnSelect(comboObj ,index, code) {
		selComboIndex = index;
		selComboCode = code;
	}
	function combo7_OnChange() {
	    setMultiCombo(combo7, selComboIndex, selComboCode);
	}
	
	//Multi Combo click event
	function combo8_OnCheckClick(comboObj, index, code) {
		setMultiCombo(comboObj, index, code) ;
	}
	
	//Multi Combo click event
	function combo9_OnCheckClick(comboObj, index, code) {
		//alert("2_6");
		setMultiCombo(comboObj, index, code) ;
	}
    /**
     * Select the first item
     */	
	function setComboItem(comboObj,comboItems) {
		//alert("2_5");
		var checkedItem=comboItems[0].split(FIELDMARK);
		comboObj.SetSelectText(checkedItem[0]);
	}	
	/*
	 * Initialize the query result information
	 */
	function initResultControls() {
		//alert("2_4");
		sheetObjects[0].RemoveAll();
	}
	/*
	 * Location Search Field initialization
	 */		
	function clearLocation1() {
		//alert("2_3");
		var formObj=document.form;
		ComSetObjValue(formObj.loc_cd, "");
		ComSetObjValue(formObj.cvrg_location, "");
	}
	/*
	 * Location Search Field initialization
	 */		
	function clearLocation2() {
		//alert("2_2");
		var formObj=document.form;
		ComSetObjValue(formObj.loc_cd, "");
		ComSetObjValue(formObj.org_dest_location, "");
	}
	/*
	 *  initializing
	 */		
	function initSearchControls() {
		//alert("1_14");
		var formObj=document.form;
		comboObjects[0].SetSelectCode("-1");
		comboObjects[0].RemoveAll();
		comboObjects[1].SetSelectCode("-1");
		comboObjects[1].RemoveAll();
		comboObjects[2].SetSelectCode("-1");
		comboObjects[2].RemoveAll();
		comboObjects[3].SetSelectCode("-1");
		comboObjects[3].RemoveAll();
		comboObjects[4].SetSelectCode("-1");
		comboObjects[4].RemoveAll();
		comboObjects[5].SetSelectCode("-1");
		comboObjects[5].RemoveAll();
		comboObjects[6].SetSelectCode("-1");
		comboObjects[6].RemoveAll();
		ComSetObjValue(formObj.conti_cd, "");	
		ComSetObjValue(formObj.cnt_cd, "");		
		ComSetObjValue(formObj.rgn_cd, "");		
		ComSetObjValue(formObj.ste_cd, "");		
		ComSetObjValue(formObj.loc_cd, "");
		ComSetObjValue(formObj.cvrg_location, "");
		ComSetObjValue(formObj.org_dest_location, "");
		ComSetObjValue(formObj.cvrg_conti_cd, "");
		ComSetObjValue(formObj.cvrg_cnt_cd, "");
		ComSetObjValue(formObj.cvrg_rgn_cd, "");
		ComSetObjValue(formObj.cvrg_ste_cd, "");
		ComSetObjValue(formObj.cvrg_loc_cd, "");
		ComSetObjValue(formObj.org_dest_conti_cd, "");
		ComSetObjValue(formObj.org_dest_cnt_cd, "");
		ComSetObjValue(formObj.org_dest_rgn_cd, "");
		ComSetObjValue(formObj.org_dest_ste_cd, "");
		ComSetObjValue(formObj.org_dest_loc_cd, "");
		ComSetObjValue(formObj.dmdt_trf_cd_list, "");
		ComSetObjValue(formObj.validity1, "Y");		//Validity
		ComSetObjValue(formObj.validity2, "Y");		//Validity
		ComSetObjValue(formObj.validity3, "");		//Validity
		formObj.cfm_flg.selectedIndex=1;
		Region.innerHTML="Region";
		Region2.innerHTML="Region";
	}		
	/*
	 * htmlControl event initializing
	 */	
	function initControl() {
		//alert("2_1");
		initSearchControls();
		//initResultControls();
	 	//IBMultiCombo initializing
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],k+1);
	    }
	    var formObj=document.form;
	    doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCHLIST10,"","");
//	    doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCHLIST,COMMON_TARIFF_CD,comboObjects[0]);		//1
//	    doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH08,CONTINENT,comboObjects[1]);		//2
//	    doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH02,COUNTRY,comboObjects[2]);			//3
//	    doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObjects[3]);		//4
//	    doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH08,CONTINENT,comboObjects[4]);		//5
//	    doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH02,COUNTRY,comboObjects[5]);			//6
//	    doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObjects[6]);	//7	    
	}	        
