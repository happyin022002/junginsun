/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_1101.js
*@FileTitle  : Copy Basic Tariff
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30
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
	var ROWMARK="|";
	var FIELDMARK="=";
	var ORIGIN="Origin";
	var DESTINATION="Destination";
	var isNoChangeActive=false;
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
				case "btn_new":
					initControl();
					break;
				case "btn_save":
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
					break;
				case "btn_close":
					ComClosePopup(); 
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
	//comboObjects array generated in the registration page to IB Combo Object
	function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
	}
	/**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
    	var formObj=document.form;
		for(var i=0;i<sheetObjects.length;i++){
			initSheet(sheetObjects[i],i+1);
		}
		//IBMultiCombo initializing
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],k+1);
	    }
    	//cvrg region, state 
    	if(ComGetObjValue(formObj.cvrg_cnt_cd) == "US" || ComGetObjValue(formObj.cvrg_cnt_cd) == "CA") {
    		ComSetObjValue(formObj.cvrg_rgn_ste_cd,  ComGetObjValue(formObj.cvrg_ste_cd));
    	} else {
    		ComSetObjValue(formObj.cvrg_rgn_ste_cd,  ComGetObjValue(formObj.cvrg_rgn_cd));
    	}
    	//org_dest region, state 
    	if(ComGetObjValue(formObj.org_dest_cnt_cd) == "US" || ComGetObjValue(formObj.org_dest_cnt_cd) == "CA") {
    		ComSetObjValue(formObj.org_dest_rgn_ste_cd,  ComGetObjValue(formObj.org_dest_ste_cd));
    	} else {
    		ComSetObjValue(formObj.org_dest_rgn_ste_cd,  ComGetObjValue(formObj.org_dest_rgn_cd));
    	}
    	//org_dest region, state 
//    	if(ComGetObjValue(formObj.to_cvrg_cnt_cd) == "US" || ComGetObjValue(formObj.to_cvrg_cnt_cd) == "CA") {
//    		ComSetObjValue(formObj.to_cvrg_rgn_ste_cd,  ComGetObjValue(formObj.cvrg_ste_cd));
//    	} else {
//    		ComSetObjValue(formObj.to_cvrg_rgn_ste_cd,  ComGetObjValue(formObj.cvrg_rgn_cd));
//    	}
	    initAxonControl();
	    
	    comboObjects[0].SetSelectText(ComGetObjValue(formObj.cvrg_conti_cd));
	    comboObjects[1].SetSelectText(ComGetObjValue(formObj.cvrg_cnt_cd));
    	if(comboObjects[1].GetSelectText() == "US" || comboObjects[1].GetSelectText() == "CA") {
    		comboObjects[2].SetSelectText(ComGetObjValue(formObj.cvrg_ste_cd));
		} else {
			comboObjects[2].SetSelectText(ComGetObjValue(formObj.cvrg_rgn_cd));
		}
    	ComSetObjValue(formObj.to_cvrg_loc_cd,  ComGetObjValue(formObj.cvrg_loc_cd));
    	ComSetObjValue(formObj.to_cvrg_yd_cd,  ComGetObjValue(formObj.cvrg_yd_cd));
    }
	function initAxonControl() { 
		axon_event.addListenerFormat('blur',	'obj_blur',		form); // out of focus
		axon_event.addListenerFormat('focus',	'obj_focus',	form); // Get focus
//		axon_event.addListenerFormat('keypress',		'obj_keypress',    form); // Keyboard input
//		axon_event.addListener('keydown', 'ComKeyEnter',  'form');	
//		axon_event.addListener('keydown', 'obj_keydown',  'to_org_dest_location');	
	}
    /**
     * HTML Control Foucs in
     */
    function obj_focus(){
        ComClearSeparator(event.srcElement);
    }
   // out of focus
    function obj_blur(){
    	//check inputing Validation + Inserting separator 
		var obj=event.srcElement;
		if(obj.value.length > 0 && obj.value.length < 5) {
			ComShowCodeMessage('DMT00110');
			ComClearObject(obj);
		}
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        switch(sheetNo) {
            case 1:
                with (sheetObj) {
                    //setting Host information[mandatory][HostIp, Port, PagePath]
                    //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
            		SetVisible(false);
                }
                break;
        }
    }
    /**
   	 * Initializing Combo 
   	 * param : comboObj , comboNo
   	 * adding case as numbers of counting Combos 
   	 */ 
   	function initCombo(comboObj, comboNo) {
   		var formObj=document.form
	    switch(comboNo) {  
    	//Coverage Continent
    	case 1:
    		with (comboObj) { 
    			SetMultiSelect(0);
				SetUseAutoComplete(0);
				SetColAlign(0, "left");
				SetColAlign(1, "left");
				SetColWidth(0, "30");
				SetColWidth(1, "100");
				SetDropHeight(160);
				SetUseEdit(1);
				ValidChar(2);
				//BackColor = "#CCFFFD";
//no support[check again]CLT 					ValidChar(2,0);		
//no support[check again]CLT 					IMEMode=0;
				SetMaxLength(1);
    		}
			//doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH08,CONTINENT);
    		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH08,CONTINENT,comboObj);
			break;
		//Coverage Country
    	case 2:
    		with (comboObj) {
    			SetMultiSelect(0);
    			UseAutoComplet=false;
				SetColAlign(0, "left");
				SetColAlign(1, "left");
				SetColWidth(0, "30");
				SetColWidth(1, "200");
    			SetDropHeight(160);
    			SetUseEdit(1);
    			ValidChar(2);
//no support[check again]CLT 					ValidChar(2,0);		
//no support[check again]CLT 					IMEMode=0;
				SetMaxLength(2);
    		}
    		//doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH02,COUNTRY);
    		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH02,COUNTRY,comboObj);
    		break;
    	//Coverage Region
    	case 3:
    		with (comboObj) {
					SetMultiSelect(0);
					SetUseAutoComplete(0);
				SetColAlign(0, "left");
				SetColAlign(1, "left");
				SetColWidth(0, "40");
				SetColWidth(1, "200");
					SetDropHeight(160);
					SetUseEdit(1);
					ValidChar(2);
//no support[check again]CLT 					ValidChar(2,0);		
//no support[check again]CLT 					IMEMode=0;
				SetMaxLength(3);
    		}
    		//doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION);
    		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObj);
    		break;
	    	//Continent
	    	case 4:
	    		with (comboObj) { 
	    			SetMultiSelect(0);
					SetUseAutoComplete(0);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "30");
					SetColWidth(1, "100");
					SetDropHeight(160);
					SetUseEdit(1);
					ValidChar(2);
					//BackColor = "#CCFFFD";
//no support[check again]CLT 					ValidChar(2,0);		
//no support[check again]CLT 					IMEMode=0;
					SetMaxLength(1);
	    		}
				//doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH08,CONTINENT);
	    		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH08,CONTINENT,comboObj);
				break;
			//Country
	    	case 5:
	    		with (comboObj) {
	    			SetMultiSelect(0);
	    			UseAutoComplet=false;
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "30");
					SetColWidth(1, "200");
	    			SetDropHeight(160);
	    			SetUseEdit(1);
	    			ValidChar(2);
//no support[check again]CLT 					ValidChar(2,0);		
//no support[check again]CLT 					IMEMode=0;
					SetMaxLength(2);
	    		}
	    		//doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH02,COUNTRY);
	    		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH02,COUNTRY,comboObj);
	    		break;
	    	//Region
	    	case 6:
	    		with (comboObj) {
  					SetMultiSelect(0);
  					SetUseAutoComplete(0);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "40");
					SetColWidth(1, "200");
  					SetDropHeight(160);
  					SetUseEdit(1);
  					ValidChar(2);
//no support[check again]CLT 					ValidChar(2,0);		
//no support[check again]CLT 					IMEMode=0;
					SetMaxLength(3);
	    		}
	    		//doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION);
	    		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObj);
	    		break;
	     }    		
   	}
	// Process of Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
	        case IBSAVE:	// save
	        	ComSetObjValue(formObj.f_cmd, MULTI);
	        	setParameters(MULTI);
		 		if(!validateForm(sheetObj,formObj,sAction)) return;
                //ComOpenWait Start
                sheetObj.SetWaitImageVisible(0);
                ComOpenWait(true);
                var sXml=sheetObj.GetSaveData("EES_DMT_1101GS.do", FormQueryString(formObj));
	            var startMsg=sXml.indexOf("<MESSAGE>") + 9;
	            var endMsg=sXml.indexOf("</MESSAGE>");
	            var msg=sXml.substring(startMsg,endMsg);
	            msg=ComReplaceStr(msg, "<![CDATA[", "");
	            msg=ComReplaceStr(msg, "]]>", "");
	            ComShowMessage(msg);
                //ComOpenWait End
                ComOpenWait(false);
	            break;
        }
    }
	// Search criteria field data retrieval Combo
    function doActionIBCombo(sheetObj,formObj,sAction,sComboAction,sComboKey,sObj) {
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
						//1. CONTINENT LIST
						case SEARCH08:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							ComSetObjValue(formObj.f_cmd, SEARCH08);
							if(sObj.options.id == "combo1" || sObj.options.id == "combo2" || sObj.options.id == "combo3") {
								setCvrgComboParameters(sComboAction, sObj);
							} else if(sObj.options.id == "combo4" || sObj.options.id == "combo5" || sObj.options.id == "combo6") {
								setComboParameters(sComboAction, sObj);
							}
							//2.Inquiry as a query is run conditions					
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							index_1=0;
							index_2=3;
							comboDatas=ComGetEtcData(sXml, sComboKey);
							if (comboDatas != undefined) {
								comboItems=comboDatas.split(ROWMARK);
								//Change the selection to a usable state
								comboObjects[index_1].SetSelectCode("-1");
								comboObjects[index_1].RemoveAll();
								addComboItem(comboObjects[index_1],comboItems);	//Coverage CONTINENT
								comboObjects[index_2].SetSelectCode("-1");
								comboObjects[index_2].RemoveAll();
								addComboItem(comboObjects[index_2],comboItems);	//CONTINENT
							}else{
								ComShowCodeMessage("DMT06001");
							}
							break;
						//2. COUNTRY LIST
						case SEARCH02:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							ComSetObjValue(formObj.f_cmd, SEARCH02);
							if(sObj.options.id == "combo1" || sObj.options.id == "combo2" || sObj.options.id == "combo3") {
								setCvrgComboParameters(sComboAction, sObj);
							} else if(sObj.options.id == "combo4" || sObj.options.id == "combo5" || sObj.options.id == "combo6") {
								setComboParameters(sComboAction, sObj);
							}
							//2.Inquiry as a query is run conditions					
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							index_1=1;
							index_2=4;
							comboDatas=ComGetEtcData(sXml, sComboKey);
							if (comboDatas != undefined) {
								comboItems=comboDatas.split(ROWMARK);
								comboObjects[index_1].SetSelectCode("-1");
								comboObjects[index_1].RemoveAll();
								addComboItem(comboObjects[index_1],comboItems);	//Coverage COUNTRY
								comboObjects[index_2].SetSelectCode("-1");
								comboObjects[index_2].RemoveAll();
								addComboItem(comboObjects[index_2],comboItems);	//COUNTRY
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
							break;
						//3. REGION LIST
						case SEARCH01:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							ComSetObjValue(formObj.f_cmd, SEARCH01);
							if(sObj.options.id == "combo1" || sObj.options.id == "combo2" || sObj.options.id == "combo3") {
								setCvrgComboParameters(sComboAction, sObj);
							} else if(sObj.options.id == "combo4" || sObj.options.id == "combo5" || sObj.options.id == "combo6") {
								setComboParameters(sComboAction, sObj);
							}
							//2.Inquiry as a query is run conditions					
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							if(sObj.options.id == "combo3" || sObj.options.id == "combo1") {
								index_1=2;
							} else if(sObj.options.id == "combo6" || sObj.options.id == "combo4") {
								index_1=5;
							}
							comboDatas=ComGetEtcData(sXml, sComboKey);
							if (comboDatas != undefined) {
								comboItems=comboDatas.split(ROWMARK);
								comboObjects[index_1].SetSelectCode("-1");
								comboObjects[index_1].RemoveAll();
								addComboItem(comboObjects[index_1],comboItems);	//REGION
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
							break;
						//4.  Search CONTRY of Continent 
						case SEARCH06:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							ComSetObjValue(formObj.f_cmd, SEARCH06);
                            var sObj_name = "";
                            if ( sObj.name == "to_org_dest_location" || sObj.name == "to_cvrg_loc_cd" || sObj.name == "to_cvrg_yd_cd"){
                            	sObj_name = sObj.name;
                            } else {
                            	sObj_name = sObj.options.id;
                            }
							if(sObj_name == "combo1" || sObj_name == "combo2" || sObj_name == "combo3" || sObj_name == "to_cvrg_loc_cd" || sObj_name == "to_cvrg_yd_cd") {
								setCvrgComboParameters(sComboAction, sObj);
							} else if(sObj_name == "combo4" || sObj_name == "combo5" || sObj_name == "combo6" || sObj_name == "to_org_dest_location") {
								setComboParameters(sComboAction, sObj);
							}
							//2.Inquiry as a query is run conditions					
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
                            
							if(sObj_name == "combo1" || sObj_name == "combo3" || sObj_name == "to_cvrg_loc_cd" || sObj_name == "to_cvrg_yd_cd") {
								index_1=1;
							} else if(sObj_name == "combo4" || sObj_name == "combo6" || sObj_name == "to_org_dest_location" ) {
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
									ComShowCodeMessage("DMT06001");
									clearObjectValue(sObj);
								}
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
							break;
						//5.  search  Continent  of Country
						case SEARCH12:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							ComSetObjValue(formObj.f_cmd, SEARCH12);
							if(sObj.options.id == "combo1" || sObj.options.id == "combo2" || sObj.options.id == "combo3") {
								setCvrgComboParameters(sComboAction, sObj);
							} else if(sObj.options.id == "combo4" || sObj.options.id == "combo5" || sObj.options.id == "combo6") {
								setComboParameters(sComboAction, sObj);
							}
							//2.Inquiry as a query is run conditions					
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							if(sObj.options.id == "combo2") {
								index_1=0;
							} else if(sObj.options.id == "combo5") {
								index_1=3;
							} 
							comboDatas=ComGetEtcData(sXml, CONTINENT);
							if( comboDatas != undefined) {
								comboItems=comboDatas.split(ROWMARK);
								setComboItem(comboObjects[index_1],comboItems);	//Continent
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
							break;
						//5. Corresponding changes at Country Region Information Inquiry
						case SEARCH03:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							ComSetObjValue(formObj.f_cmd, SEARCH03);
                            var sObj_name = "";
                            if ( sObj.name == "to_org_dest_location" || sObj.name == "to_cvrg_loc_cd" || sObj.name == "to_cvrg_yd_cd"){
                            	sObj_name = sObj.name;
                            } else {
                            	sObj_name = sObj.options.id;
                            }
							if(sObj_name == "combo1" || sObj_name == "combo2" || sObj_name == "combo3" || sObj_name == "to_cvrg_loc_cd" || sObj_name == "to_cvrg_yd_cd") {
								setCvrgComboParameters(sComboAction, sObj);
							} else if(sObj_name == "combo4" || sObj_name == "combo5" || sObj_name == "combo6" || sObj_name == "to_org_dest_location") {
								setComboParameters(sComboAction, sObj);
							}
							//2.Inquiry as a query is run conditions					
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
                            
							if(sObj_name == "combo2" || sObj_name == "combo3" || sObj_name == "to_cvrg_loc_cd" || sObj_name == "to_cvrg_yd_cd") {
								index_1=1;
								index_2=2;
								clearCvrgLocation();
							} else if(sObj_name == "combo5" || sObj_name == "combo6" || sObj_name == "to_org_dest_location") {
								index_1=4;
								index_2=5;
								clearLocation();
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
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
							break;
						//6. State, Region at the time of change, the corresponding Continet, Country, State Lookup
						case SEARCH17:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							ComSetObjValue(formObj.f_cmd, SEARCH17);
							if(sObj.options.id == "combo1" || sObj.options.id == "combo2" || sObj.options.id == "combo3") {
								setCvrgComboParameters(sComboAction, sObj);
							} else if(sObj.options.id == "combo4" || sObj.options.id == "combo5" || sObj.options.id == "combo6") {
								setComboParameters(sComboAction, sObj);
							}
							//2.Inquiry as a query is run conditions					
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							if(sObj.options.id == "combo3") {
								index_1=0;
								index_2=1;	//Location initialization
								index_3=2;
								clearCvrgLocation();
							} else if(sObj.options.id == "combo6") {
								index_1=3;
								index_2=4;	//Location initialization
								index_3=5;
								clearLocation();
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
										ComShowCodeMessage("DMT06001");
										clearObjectValue(sObj);
									}
								}else{
									ComShowCodeMessage("DMT06001");
									clearObjectValue(sObj);
								}							
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
							break;
						case SEARCH13:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							ComSetObjValue(formObj.f_cmd, SEARCH13);
							if(sObj.options.id == "combo1" || sObj.options.id == "combo2" || sObj.options.id == "combo3") {
								setCvrgComboParameters(sComboAction, sObj);
							} else if(sObj.options.id == "combo4" || sObj.options.id == "combo5" || sObj.options.id == "combo6") {
								setComboParameters(sComboAction, sObj);
							}
							//2.Inquiry as a query is run conditions					
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							if(sObj.options.id == "combo3") {
								index_1=0;
								index_2=1;	//Location initialization
								index_3=2;
								clearCvrgLocation();
							} else if(sObj.options.id == "combo6") {
								index_1=3;
								index_2=4;	//Location initialization
								index_3=5;
								clearLocation();
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
										ComShowCodeMessage("DMT06001");
										clearObjectValue(sObj);
									}
								}else{
									ComShowCodeMessage("DMT06001");
									clearObjectValue(sObj);
								}							
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
							break;
						//4. Location, input Inquiry
						case SEARCH10:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							ComSetObjValue(formObj.f_cmd, SEARCH10);
							if(sObj.name == "to_cvrg_loc_cd" || sObj.name == "to_cvrg_yd_cd") {
								setCvrgComboParameters(sComboAction, sObj);
							} else if(sObj.name == "to_org_dest_location") {
								setComboParameters(sComboAction, sObj);
							}
							//2.Inquiry as a query is run conditions					
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							var location=ComGetObjValue(sObj);
							if(sObj.name == "to_cvrg_loc_cd" || sObj.name == "to_cvrg_yd_cd") {
								index_1=0;
								index_2=1;	//Location initialization
								index_3=2;
								clearCvrgLocation();
							} else if(sObj.name == "to_org_dest_location") {
								index_1=3;
								index_2=4;	//Location initialization
								index_3=5;
								clearLocation();
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
										ComShowCodeMessage("DMT06001");
										clearObjectValue(sObj);
									}
								}else{
									ComShowCodeMessage("DMT06001");
									clearObjectValue(sObj);
								}
							}else{
					    		ComAlertFocus(sObj, ComGetMsg('DMT00110'));
								clearObjectValue(sObj);
							}
							break;
						//5. Yard, input Inquiry
						case COMMAND03:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							ComSetObjValue(formObj.f_cmd, COMMAND03);
							setCvrgComboParameters(sComboAction, sObj);
							//2.Inquiry as a query is run conditions					
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							var yard=ComGetObjValue(sObj);
							if(sObj.name == "to_cvrg_yd_cd") {
								index_1=0;
								index_2=1;	//Location initialization
								index_3=2;
								clearCvrgLocation();
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
									if(yard.substring(0,2) == "CA" || yard.substring(0,2) == "US") {
										comboDatas=ComGetEtcData(sXml, STATE);
					    			}else{
										comboDatas=ComGetEtcData(sXml, REGION);
					    			}
									if (comboDatas != undefined) {
										comboItems=comboDatas.split(ROWMARK);
										setComboItem(comboObjects[index_3],comboItems);	//Region
										//location setting
										ComSetObjValue(sObj, yard);
										ComSetObjValue(formObj.to_cvrg_loc_cd, yard.substr(0,5));
									}else{
										ComShowCodeMessage("DMT06001");
										clearObjectValue(sObj);
									}
								}else{
									ComShowCodeMessage("DMT06001");
									clearObjectValue(sObj);
								}
							}else{
					    		ComAlertFocus(sObj, ComGetMsg('DMT00110'));
								clearObjectValue(sObj);
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
    	for (var i=0 ; i < comboItems.length ; i++) {
    		var comboItem=comboItems[i].split(FIELDMARK);
			comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[0]);		
    	}   		
	}
	/*
	 * Common code is Inquiry for Combo
	 */
	function setCvrgComboParameters(sComboAction) {
		var formObj=document.form;
		//Coverage ComboSettion
		ComSetObjValue(formObj.conti_cd, comboObjects[0].GetSelectText());
		ComSetObjValue(formObj.cnt_cd, comboObjects[1].GetSelectText());
		ComSetObjValue(formObj.rgn_cd, comboObjects[2].GetSelectText());
		ComSetObjValue(formObj.ste_cd, comboObjects[2].GetSelectText());
		ComSetObjValue(formObj.loc_cd, ComGetObjValue(formObj.to_cvrg_loc_cd));
		ComSetObjValue(formObj.yd_cd, ComGetObjValue(formObj.to_cvrg_yd_cd));
		ComSetObjValue(formObj.to_cvrg_conti_cd, comboObjects[0].GetSelectText());
		ComSetObjValue(formObj.to_cvrg_cnt_cd, comboObjects[1].GetSelectText());
		ComSetObjValue(formObj.to_cvrg_rgn_ste_cd, comboObjects[2].GetSelectText());
	}
	function setComboParameters(sComboAction) {
		var formObj=document.form;
		//Origin/Dest ComboSettion
		ComSetObjValue(formObj.conti_cd, comboObjects[3].GetSelectText());
		ComSetObjValue(formObj.cnt_cd, comboObjects[4].GetSelectText());
		ComSetObjValue(formObj.rgn_cd, comboObjects[5].GetSelectText());
		ComSetObjValue(formObj.ste_cd, comboObjects[5].GetSelectText());
		ComSetObjValue(formObj.loc_cd, ComGetObjValue(formObj.to_org_dest_location));
		ComSetObjValue(formObj.yd_cd, "");
	}
	/**
     * Select the first item
     */	
	function setComboItem(comboObj,comboItems) {
		var checkedItem=comboItems[0].split(FIELDMARK);
		comboObj.SetSelectText(checkedItem[0]);
	}	
	/*
	 * Location Search Field initialization
	 */		
	function clearCvrgLocation() {
		var formObj=document.form;
		ComSetObjValue(formObj.loc_cd, "");
		ComSetObjValue(formObj.yd_cd, "");
		ComSetObjValue(formObj.to_cvrg_loc_cd, "");
		ComSetObjValue(formObj.to_cvrg_yd_cd, "");
	}
	function clearLocation() {
		var formObj=document.form;
		ComSetObjValue(formObj.loc_cd, "");
		ComSetObjValue(formObj.yd_cd, "");
		ComSetObjValue(formObj.to_org_dest_location, "");
	}
	function clearObjectValue(obj) {
		switch(ComGetEvent("name")) {
			case "to_cvrg_loc_cd":
				obj.value="";
				break;
			case "to_cvrg_yd_cd":
				obj.value="";
				break;
			case "to_org_dest_location":
				obj.value="";
				break;
			default:
				obj.SetSelectText("");
				break;
		}
	}	
	/*
	 * Changes Continent Search Field, if it's part of Country, Region or State functions that query information
	 */		
	function combo1_OnChange(comboObj, Index_Code, Text) {
		if (comboObj.GetSelectText().length == 0 ) return;
		if (isNoChangeActive) return;
		//2. Check uppercase
		var ret=ComIsAlphabet(comboObj.GetSelectText(), "u");
		if(!ret) {
			comboObj.SetSelectText("");
			ComSetFocus(combo2);
			return;
		}
		//3. Check digits
		if(comboObj.GetSelectText().length != 1) {
			comboObj.SetSelectText("");
			ComSetFocus(comboObj);
			return;
		}
		var formObj=document.form;
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,comboObj);
		//Region initialization
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObj);
		//Location initialization
		clearCvrgLocation();
	}
	function combo4_OnChange(comboObj, Index_Code, Text) {
		if (comboObj.GetSelectText().length == 0 ) return;
		if (isNoChangeActive) return;
		//2. Check uppercase
		var ret=ComIsAlphabet(comboObj.GetSelectText(), "u");
		if(!ret) {
			comboObj.SetSelectText("");
			ComSetFocus(combo5);
			return;
		}
		//3. Check digits
		if(comboObj.GetSelectText().length != 1) {
			comboObj.SetSelectText("");
			ComSetFocus(comboObj);
			return;
		}
		var formObj=document.form;
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,comboObj);
		//Region initialization
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObj);
		//Location initialization
		clearLocation();
	}
	function search_combo1(comboObj, searchIndex, searchText) {
		if (comboObj.GetSelectText().length == 0 ) return;
		if (isNoChangeActive) return;
		var formObj=document.form;
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,comboObj);
		//Region initialization
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObj);
		//Location initialization
		clearCvrgLocation();
	}
	function search_combo4(comboObj, searchIndex, searchText) {
		if (comboObj.GetSelectText().length == 0 ) return;
		if (isNoChangeActive) return;
		var formObj=document.form;
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,comboObj);
		//Region initialization
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObj);
		//Location initialization
		clearLocation();
	}
	
	/*
	 * Country Search Field when there is a change, the part of the Region or State functions that query information
	 */		
	function combo2_OnChange(comboObj, Index_Code, Text) {
		search_combo2(comboObj, Index_Code, Text);
	}
	function combo5_OnChange(comboObj, Index_Code, Text) {
		search_combo5(comboObj, Index_Code, Text);
	}
	function search_combo2(comboObj, searchIndex, searchText) {
		if (comboObj.GetSelectText().length == 0 ) return;
		if (isNoChangeActive)	return;
		if (comboObj.GetSelectText()== "CA" || comboObj.GetSelectText()== 'US') {
			CvrgRegion.innerHTML="State";
		} else {
			CvrgRegion.innerHTML="Region";
		}
		var formObj=document.form;
		isNoChangeActive=true;
		//Continent 
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH12,CONTINENT,comboObj);
		//Region 
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,REGION,comboObj);
		isNoChangeActive=false;
		//Location initialization
		clearCvrgLocation();
	}
	function search_combo5(comboObj, searchIndex, searchText) {
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
		clearLocation();
	}	
	/*
	 *Region or State Search Field case is changed, Location Search Field and initializing functions that
	 */	
	function combo3_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		search_combo3(comboObj, newCode, newText);
	}
	function combo6_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		search_combo6(comboObj, newCode, newText);
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
	function search_combo6(comboObj, searchIndex, searchText) {
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
	/*
	 * Location Search Field, if entered in the Enter Key, Location that contains the Continent, Country and Region or State functions to query information
	 */		
	function checkCvrgLocation(obj) {
		if(isAlpha()) {
			if (isNoChangeActive) return;
			var formObj=document.form;
	    	if (ComTrim(ComGetObjValue(obj)).length == 5) {
				var locCd=ComTrim(ComGetObjValue(obj));
	    		if (locCd.length > 0) {
	    			if(locCd.substring(0,2) == "CA" || locCd.substring(0,2) == "US") {
	    				CvrgRegion.innerHTML="State";
	    			}else{
	    				CvrgRegion.innerHTML="Region";
	    			}
	    			isNoChangeActive=true;
	    			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH10,LOCATION,obj);
	    			isNoChangeActive=false;
				}
	    	}		
		}
	}
	function checkCvrgYard(obj) {
		if (isNoChangeActive) return;
		var formObj=document.form;
    	if (ComTrim(ComGetObjValue(obj)).length == 7) {
			var ydCd=ComTrim(ComGetObjValue(obj));
    		if (ydCd.length > 0) {
    			if(ydCd.substring(0,2) == "CA" || ydCd.substring(0,2) == "US") {
    				CvrgRegion.innerHTML="State";
    			}else{
    				CvrgRegion.innerHTML="Region";
    			}
    			isNoChangeActive=true;
    			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,COMMAND03,LOCATION,obj);
    			isNoChangeActive=false;
			}	
    	}
	}
	function checkLocation(obj) {
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
   	/**
     *  handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
    		switch(sAction) {
    			case IBSAVE:
    				if(ComGetObjValue(formObj.to_cvrg_conti_cd) == "") {
    					ComAlertFocus(combo1, ComGetMsg('COM12113', "Coverage Continent"));
						return false;
    				} else if(ComGetObjValue(formObj.to_org_dest_conti_cd) == "") {
    					ComAlertFocus(combo4, ComGetMsg('COM12113', "Continent"));
						return false;
    				}
    				if(ComGetObjValue(formObj.cvrg_conti_cd) 	== ComGetObjValue(formObj.to_cvrg_conti_cd) &&
    					ComGetObjValue(formObj.cvrg_cnt_cd) 	== ComGetObjValue(formObj.to_cvrg_cnt_cd) &&
    					ComGetObjValue(formObj.cvrg_rgn_cd) 	== ComGetObjValue(formObj.to_cvrg_rgn_cd) &&
    					ComGetObjValue(formObj.cvrg_ste_cd) 	== ComGetObjValue(formObj.to_cvrg_ste_cd) &&
    					ComGetObjValue(formObj.cvrg_loc_cd) 	== ComGetObjValue(formObj.to_cvrg_loc_cd) &&
    					ComGetObjValue(formObj.cvrg_yd_cd) 		== ComGetObjValue(formObj.to_cvrg_yd_cd) &&
    					ComGetObjValue(formObj.org_dest_conti_cd) 	== ComGetObjValue(formObj.to_org_dest_conti_cd) &&
    					ComGetObjValue(formObj.org_dest_cnt_cd) 	== ComGetObjValue(formObj.to_org_dest_cnt_cd) &&
    					ComGetObjValue(formObj.org_dest_rgn_cd) 	== ComGetObjValue(formObj.to_org_dest_rgn_cd) &&
    					ComGetObjValue(formObj.org_dest_ste_cd) 	== ComGetObjValue(formObj.to_org_dest_ste_cd) &&
    					ComGetObjValue(formObj.org_dest_loc_cd) 	== ComGetObjValue(formObj.to_org_dest_loc_cd)
    				) {
    					ComAlertFocus(combo1, ComGetMsg('DMT00153', "Coverage Continent"));
    					return false;
    				}
    				break;
    		}
        }
        return true;
    }
	/*
	 * Searching fields to enter information of the screen is stored in a lookup field values??.
	 */		
	function setParameters(sAction) {
		var formObj=document.form;
		//Coverage ComboSettion
		ComSetObjValue(formObj.to_cvrg_conti_cd, comboObjects[0].GetSelectText());
		ComSetObjValue(formObj.to_cvrg_cnt_cd, 	 comboObjects[1].GetSelectText());
		//Origin/Dest ComboSettion
		ComSetObjValue(formObj.to_org_dest_conti_cd, comboObjects[3].GetSelectText());
		ComSetObjValue(formObj.to_org_dest_cnt_cd, 	 comboObjects[4].GetSelectText());
		//TO CVRG
		if(ComGetObjValue(formObj.to_cvrg_cnt_cd) == "US" || ComGetObjValue(formObj.to_cvrg_cnt_cd) == "CA") {
			ComSetObjValue(formObj.to_cvrg_rgn_cd, "");
			ComSetObjValue(formObj.to_cvrg_ste_cd, comboObjects[2].GetSelectText());
		}else{
			ComSetObjValue(formObj.to_cvrg_rgn_cd, comboObjects[2].GetSelectText());
			ComSetObjValue(formObj.to_cvrg_ste_cd, "");
		}
		//TO ORG_DEST
		if(ComGetObjValue(formObj.to_org_dest_cnt_cd) == "US" || ComGetObjValue(formObj.to_org_dest_cnt_cd) == "CA") {
			ComSetObjValue(formObj.to_org_dest_rgn_cd, "");
			ComSetObjValue(formObj.to_org_dest_ste_cd, comboObjects[5].GetSelectText());
		}else{
			ComSetObjValue(formObj.to_org_dest_rgn_cd, comboObjects[5].GetSelectText());
			ComSetObjValue(formObj.to_org_dest_ste_cd, "");
		}
		ComSetObjValue(formObj.to_cvrg_loc_cd, ComGetObjValue(formObj.to_cvrg_loc_cd));
		ComSetObjValue(formObj.to_cvrg_yd_cd, ComGetObjValue(formObj.to_cvrg_yd_cd));
		ComSetObjValue(formObj.to_org_dest_loc_cd, ComGetObjValue(formObj.to_org_dest_location));
	}	
	/*
	 *  initializing
	 */		
	function initSearchControls() {
		var formObj=document.form;
		comboObjects[0].SetSelectCode(-1);
		comboObjects[0].RemoveAll();
		comboObjects[1].SetSelectCode(-1);
		comboObjects[1].RemoveAll();
		comboObjects[2].SetSelectCode(-1);
		comboObjects[2].RemoveAll();
		comboObjects[3].SetSelectCode(-1);
		comboObjects[3].RemoveAll();
		comboObjects[4].SetSelectCode(-1);
		comboObjects[4].RemoveAll();
		comboObjects[5].SetSelectCode(-1);
		comboObjects[5].RemoveAll();
		ComSetObjValue(formObj.conti_cd, "");	
		ComSetObjValue(formObj.cnt_cd, "");		
		ComSetObjValue(formObj.rgn_cd, "");		
		ComSetObjValue(formObj.ste_cd, "");
		ComSetObjValue(formObj.loc_cd, "");
		ComSetObjValue(formObj.yd_cd, "");
		ComSetObjValue(formObj.to_cvrg_conti_cd, "");	
		ComSetObjValue(formObj.to_cvrg_cnt_cd, "");		
		ComSetObjValue(formObj.to_cvrg_rgn_cd, "");		
		ComSetObjValue(formObj.to_cvrg_ste_cd, "");
		ComSetObjValue(formObj.to_cvrg_loc_cd, "");
		ComSetObjValue(formObj.to_cvrg_yd_cd, "");
		ComSetObjValue(formObj.to_org_dest_conti_cd, "");
		ComSetObjValue(formObj.to_org_dest_cnt_cd, "");
		ComSetObjValue(formObj.to_org_dest_rgn_cd, "");
		ComSetObjValue(formObj.to_org_dest_ste_cd, "");
		ComSetObjValue(formObj.to_org_dest_location, "");
		CvrgRegion.innerHTML="Region";
		Region.innerHTML="Region";
	}	    
	/*
	 * htmlControl event initializing
	 */	
	function initControl() {
		
		initSearchControls();
	 	//IBMultiCombo initializing
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],k+1);
	    }
	    
	    var formObj=document.form;
	    comboObjects[0].SetSelectText(ComGetObjValue(formObj.cvrg_conti_cd));
	    comboObjects[1].SetSelectText(ComGetObjValue(formObj.cvrg_cnt_cd));
    	if(comboObjects[1].GetSelectText() == "US" || comboObjects[1].GetSelectText() == "CA") {
    		comboObjects[2].SetSelectText(ComGetObjValue(formObj.cvrg_ste_cd));
		} else {
			comboObjects[2].SetSelectText(ComGetObjValue(formObj.cvrg_rgn_cd));
		}
	    comboObjects[3].SetSelectText(ComGetObjValue(formObj.cvrg_loc_cd));
	    comboObjects[4].SetSelectText(ComGetObjValue(formObj.cvrg_yd_cd));
	}	
	 function unLoadPage() {
		 window.returnValue="Y";
	 }
