/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_1003.js
*@FileTitle : Basic Tariff Summary Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion :
=========================================================*/
/****************************************************************************************
   Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                  MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                  OTHER CASE : COMMAND01=11; ~ COMMAND20=30;	
 ***************************************************************************************/
    /**
     * @extends 	
     * @class EES_DMT_1003 :  business script for EES_DMT_1003
     */
    function EES_DMT_1003() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
		this.setComboObject=setComboObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
	// Common Global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var plusComboCnt = 1;
	// Business Global Variables
	var RHQ="RHQ";
	var COUNTRY="CNT";
	var CONTINENT="CONTI";
    var ALL_TARIFF_CD="all_tariff_cd"; 
	var ROWMARK="|";
	var FIELDMARK="=";
	var Mincount=0 ;
	var DEF_SHEET_HEIGHT = 409;
	var MAX_SHEET_HEIGHT = DEF_SHEET_HEIGHT + 116;
	
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
         var sheetObject1=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
				case "btn_new":
					initControl();
					initComboSearch();
					break;
 				case "btn_minimize":
                    Mincount=(Mincount+1)%2 ;
                    Minimize(Mincount);
                    break;
 				case "btn_downexcel":
					//alert("excel down");
 					//sheetObject1.Down2Excel(-1);
 					
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
        for(i=0;i<sheetObjects.length;i++){
        	ComConfigSheet (sheetObjects[i] );
        	initSheet(sheetObjects[i],i+1);
        	ComEndConfigSheet(sheetObjects[i]);
        }
        
        initControl();
        
        sheet1_OnLoadFinish(sheetObjects[0]);
		
		doActionIBCombo2(sheetObjects[0], document.form, comboObjects[0], COMMAND06);
   		comboObjects[0].SetSelectIndex(0,true);
   		doActionIBCombo2(sheetObjects[0], document.form, comboObjects[4], COMMAND21);

    }
    function sheet1_OnLoadFinish(sheetObj) {
    	var formObj=document.form;
    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,"",SEARCHLIST09,"");	
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,comboObjects[0],SEARCH02,COUNTRY);
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,comboObjects[1],SEARCH08,CONTINET);
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,comboObjects[2],SEARCH09,ALL_TARIFF_CD);
    }
  /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
    	//alert("initSheet");
        var cnt=0;
		var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":      // sheet4 init
                with(sheetObj){
                
              
              var HeadTitle1="|Country|Coverage|Tariff\nType|Origin/\nDest.||Tariff Group Name|Effective Date|Expiration Date|No.of CNTR &\n Cargo Type|Confirmation|Confirmation|Confirmation|Expiration|Expiration|Expiration|expire_chk";
              var HeadTitle2="|Country|Coverage|Tariff\nType|Origin/\nDest.||Tariff Group Name|Effective Date|Expiration Date|No.of CNTR &\n Cargo Type|Date|Office|Name|Date|Office|Name|expire_chk";
              var headCount=ComCountHeadTitle(HeadTitle1);
              //(headCount, 0, 0, true);

              SetConfig( { SearchMode:2, FrozenCol:7, MergeSheet:7, Page:20, DataRowMerge:0, PrevColumnMergeMode:0 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"},
                          { Text:HeadTitle2, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"hdnStatus" },
                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cvrg_cnt_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"covrg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_trf_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"org_dest",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"dmdt_bzc_trf_grp_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eff_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0 },
                     {Type:"Date",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"exp_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cntr_cgo_cnt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cre_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cre_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cre_usr_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"upd_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"upd_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"upd_usr_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"expire_chk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
               
              InitColumns(cols);

              SetEditable(1);
              SetCountPosition(0);
                    SetColHidden("seq",1);
              //FrozenCols=SaveNameCol("eff_dt");
              SetSheetHeight(DEF_SHEET_HEIGHT);
              }


				break;         	
        }
    }
    // Process of Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
           case IBSEARCH:      // Retrieve
				if (validateForm(sheetObj,formObj,sAction)) {
					if (sheetObj.id == "sheet1") {
						//1.Inquiry ago, the parameter is set to a value type or allows selected.
						ComSetObjValue(formObj.f_cmd, SEARCH);
						setParameters(SEARCH);
						//2.Inquiry ago, the result makes Empty fields.
						initResultControls();
	                    //ComOpenWait Start
	                    sheetObj.SetWaitImageVisible(0);
	                    ComOpenWait(true);
	                    //2.Inquiry as a query is run conditions
	                    sheetObj.DoSearch("EES_DMT_1003GS.do", FormQueryString(formObj) );
	                    //ComOpenWait End
	                    //ComOpenWait(false);
						//3.Expired Validity
						
					}
				}
				break;	
		case IBDOWNEXCEL:	// EXCEL DOWNLOAD
			if (sheetObj.id == "sheet1") {
				if (sheetObj.RowCount()== 0 ) {
			   		ComShowCodeMessage("COM132501"); // No data to dowload as Excel
			   	    return;
			   	} else {
			   		sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(				sheetObj), SheetDesign:1,Merge:1 });
			   	}
				
			}; 
			break;
		}			
    }
    
    function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
        ComOpenWait(false);
        for(var i=0; i<= sheetObj.RowCount()+1; i++) {
			if(sheetObj.GetCellValue(i, "expire_chk") == "Y") {
				sheetObj.SetCellFontColor(i, 5,"#FF0000");
				sheetObj.SetCellFontColor(i, 6,"#FF0000");
				sheetObj.SetCellFontColor(i, 7,"#FF0000");
				sheetObj.SetCellFontColor(i, 8,"#FF0000");
			}
		}
    }
    
    function doActionIBCombo2(sheetObj, formObj, comboObj, formCmd) {
     	 sheetObj.ShowDebugMsg(false);
     	 sheetObj.SetWaitImageVisible(0);
     	 formObj.f_cmd.value=formCmd;
     	 var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
     	 switch(formCmd) {
     	 	case COMMAND06:	// RHQ
     	 		with (comboObj) { 
  	    	 		RemoveAll();
  					SetMultiSelect(0);
  					SetColWidth(0, "80");
  					ValidChar(2);	
  					//MaxLength = 6;
     	 		}
     	 		var data=ComGetEtcData(sXml, "common_cd");
  				if (data != undefined && data != '') {
  					comboObj.InsertItem(0, "All", "");
  					var comboItems=data.split("|");
  					for (var i=0 ; i < comboItems.length ; i++) {
  		    	    	comboObj.InsertItem(i+1, comboItems[i], comboItems[i]);		
  		         	}
  				}
  			break;
  			
      	 	case COMMAND21:	// sys_area_grp_id 
      	 		with (comboObj) { 
   	    	 		RemoveAll();
   					SetMultiSelect(0);
   					SetColWidth(0, "80");
   					ValidChar(2);	
   					//MaxLength = 6;
      	 		}
      	 		var data=ComGetEtcData(sXml, "common_cd");
   				if (data != undefined && data != '') {
   					comboObj.InsertItem(0, "All", "");
   					var comboItems=data.split("|");
   					for (var i=0 ; i < comboItems.length ; i++) {
   		    	    	comboObj.InsertItem(i+1, comboItems[i], comboItems[i]);		
   		         	}
   				}
   			break;   		  			
     	 	}
     	 
  	}	     
    
	// Search criteria field data retrieval Combo
    function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboAction,sComboKey) {
        sheetObj.ShowDebugMsg(false);
		sheetObj.SetWaitImageVisible(0);
        switch(sAction) {
           case IBSEARCH:      // Search
				if (sheetObj.id == "sheet1") {
					if(sComboAction == SEARCHLIST09 ) {
						//1.Inquiry ago, the parameter is set to a value type or allows selected.
						ComSetObjValue(formObj.f_cmd, SEARCHLIST09); 
						//2.Inquiry as a query is run conditions
						var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
						var comboItem;
						var comboItems;
						// Country
						comboDatas=ComGetEtcData(sXml, COUNTRY);
				        if (comboDatas != undefined) {
				            comboItems=comboDatas.split(ROWMARK);
				            comboObjects[0 + plusComboCnt].SetSelectCode("-1");
				            comboObjects[0 + plusComboCnt].RemoveAll();
				            addComboItem(comboObjects[0 + plusComboCnt],comboItems); //COUNTRY
				        }
				        // Continent
				        comboDatas=ComGetEtcData(sXml, CONTINENT);
						if (comboDatas != undefined) {
				            comboItems=comboDatas.split(ROWMARK);
				            //Change the selection to a usable state
				            comboObjects[1 + plusComboCnt].SetSelectCode("-1");
				            comboObjects[1 + plusComboCnt].RemoveAll();
				            addComboItem(comboObjects[1 + plusComboCnt],comboItems);
				        }
						//TARIFF LIST
						comboItems=ComGetEtcData(sXml, ALL_TARIFF_CD).split(ROWMARK);	
			            //Change the selection to a usable state
			            comboObjects[2 + plusComboCnt].SetSelectCode("-1");
			            comboObjects[2 + plusComboCnt].RemoveAll();
						addComboItem(comboObjects[2 + plusComboCnt], comboItems);
						//default multi check
						for (var i=0 ; i < comboItems.length ; i++) {
							comboObjects[2 + plusComboCnt].SetItemCheck(i,1);
				    	}  						
					} else if (sComboAction == SEARCH02 ) {
						//1.Inquiry ago, the parameter is set to a value type or allows selected.
						ComSetObjValue(formObj.f_cmd, SEARCH02); 
						setParameters(sComboAction);
						//2.Inquiry as a query is run conditions
						var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
						var comboItem;
						var comboItems;
						// Country
						comboDatas=ComGetEtcData(sXml, COUNTRY);
				        if (comboDatas != undefined) {
				            comboItems=comboDatas.split(ROWMARK);
				            comboObjects[0 + plusComboCnt].SetSelectCode("-1");
				            comboObjects[0 + plusComboCnt].RemoveAll();
				            addComboItem(comboObjects[0 + plusComboCnt],comboItems); //COUNTRY
				        }
					} else if (sComboAction == SEARCH05 ) {
						//1.Inquiry ago, the parameter is set to a value type or allows selected.
						ComSetObjValue(formObj.f_cmd, SEARCH05); 
						setParameters(sComboAction);
						//2.Inquiry as a query is run conditions
						var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
						var comboItem;
						var comboItems;
						// Country
						comboDatas=ComGetEtcData(sXml, COUNTRY);
				        if (comboDatas != undefined) {
				            comboItems=comboDatas.split(ROWMARK);
				            comboObjects[0 + plusComboCnt].SetSelectCode("-1");
				            comboObjects[0 + plusComboCnt].RemoveAll();
				            addComboItem(comboObjects[0 + plusComboCnt],comboItems); //COUNTRY
				        }
					} else if(sComboAction == SEARCH16){
						ComSetObjValue(formObj.f_cmd, 	sComboAction);
						var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
						rhqList=handleNullString(ComGetEtcData(sXml, "RHQ"));
						if (rhqList != "") {
							fieldRHQList=rhqList.split("=");
							
							for(var i=0; i<comboObjects[4].GetItemCount(); i++){
								if(fieldRHQList[0] == comboObjects[4].GetIndexText(i+1, 1)){
//									ComSetObjValue(formObj.rhq, comboObjects[0].GetIndexText(i+1, 1));
									comboObjects[4].SetSelectIndex(i,false);
									//comboObjects[0].SetSelectIndex(i,false);
						        }
							}
						}

						var rhq=handleNullString(ComGetEtcData(sXml, CONTINENT));//Country Code로 RHQ select
						if (rhq != "") {								
							for(var i=0; i<comboObjects[0].GetItemCount(); i++){
								if(rhq == comboObjects[0].GetIndexText(i+1, 1)){
									comboObjects[0].SetSelectIndex(i,false);
						        }
							}
						}
						countryList=handleNullString(ComGetEtcData(sXml, COUNTRY));
						if (countryList != "") {
							setComboItem(comboObjects[1], countryList.split("="));
						}
					}
				};
                break;
        }
		sheetObj.SetWaitImageVisible(1);
    }
    
	function setComboItem(comboObj,comboItems) {
		var checkedItem=comboItems[0].split("=");
		comboObj.SetSelectText(checkedItem[0], false);
	}
	
	/**
     * add data  combo field 
     */	
	function addComboItem(comboObj,comboItems) {
    	for (var i=0 ; i < comboItems.length ; i++) {
    		var comboItem=comboItems[i].split(FIELDMARK);
			comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[1]);		
    	}   		
	}
	//Multi Combo click event
	function combo3_OnCheckClick(comboObj, index, code) {
		setMultiCombo(comboObj, index, code) ;
	}
	/**
     *  handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
    	//Group Type check
    	if(!formObj.dmdt_trf_grp_tp_cd1.checked && !formObj.dmdt_trf_grp_tp_cd2.checked) {
    		//alert("Charge Group Type");
    		ComShowCodeMessage('COM12114', "Group Type");
    		return false;
    	}
    	
    	//Validity check
    	if(!formObj.validity1.checked && !formObj.validity2.checked && !formObj.validity3.checked) {
    		//alert("Check Validity");
    		ComShowCodeMessage('COM12114', "Validity");
    		return false;
    	}
    	var checkCnt=0;
    	for(var i=0 ; i < comboObjects[2 + plusComboCnt].GetItemCount() ; i++) {
    		
			if(comboObjects[2 + plusComboCnt].GetItemCheck(i)) {
				checkCnt++;
			}
		}
    	if(checkCnt==0) {
    		ComShowCodeMessage('COM12114', "Tariff Type");
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
	    switch(comboNo) {
	    	//Country
	    	case 2: 
	           with (comboObj) { 
					SetMultiSelect(0);
					SetUseAutoComplete(1);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "30");
					SetColWidth(1, "200");
					SetDropHeight(160);
					ValidChar(2);
					SetMaxLength(2);
		    	}
				//doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,comboObj,SEARCH02,COUNTRY);
			break;
			
			//Origin/Destination
	    	case 3:
	    		with (comboObj) {
	    			SetMultiSelect(0);
					SetUseAutoComplete(1);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "30");
					SetColWidth(1, "100");
	    			SetDropHeight(160);
	    			ValidChar(2);
					SetMaxLength(1);
	    		}
	    		//doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,comboObj,SEARCH08,CONTINET);
	    	break;
	    	
	    	//Tariff Type
	    	case 4:
	    		with (comboObj) {
  					SetMultiSelect(1);
  					SetUseAutoComplete(1);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "55");
					SetColWidth(1, "330");
  					SetDropHeight(200);
					SetColBackColor(0, "#CCFFFD");
					SetColBackColor(1, "#CCFFFD");  					
  					SetMultiSeparator(",");
	    		}
	    		//doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,comboObj,SEARCH09,ALL_TARIFF_CD);
	    	break;
	     } 
	} 	
	/*
	 * RHQ search field is changed, the Country of its member functions that query information
	 */		
	function rhqCd_OnChange() {
		//alert("searchCountryByRHQ()");
		var formObj=document.form;
		comboObjects[0 + plusComboCnt].RemoveAll();
		if(ComGetObjValue(formObj.rhqCd)=="") {
			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,comboObjects[0 + plusComboCnt],SEARCH02,COUNTRY);
		}else{
			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,comboObjects[0 + plusComboCnt],SEARCH05,COUNTRY);
		}
	}	
	
	/** combo1_OnChange
	 * 
	 */
	function combo1_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, Text, Index_Code) {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		var cntCd=comboObj.GetSelectText();
//		if (isClearLocation) clearLocation();
//		if (cntCd.length == 0) {
//			doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH01);
//			return;	
//		}			

		ComSetObjValue(formObj.cnt_cd, cntCd);
		doActionIBCombo(sheetObj, formObj, IBSEARCH, comboObjects[1], SEARCH16);		
	}	
	
    /**
     *Click the Tab at the event-related
     * Elements selected tab is active.
     */
    function Minimize(nItem)
    {
        var objs=document.all.item("showMin");
        if ( nItem == "1" )
        {
    	    objs.style.display="none";
    	    sheetObjects[0].SetSheetHeight(MAX_SHEET_HEIGHT);
    	}
    	else
    	{
    	    objs.style.display="inline";
    	    sheetObjects[0].SetSheetHeight(DEF_SHEET_HEIGHT);
    	}
    }
	/*
	 * Searching fields to enter information of the screen is stored in a lookup field values??.
	 */		
	function setParameters(sAction) {
		var formObj=document.form;
		ComSetObjValue(formObj.svr_id, ComGetObjValue(formObj.rhqCd));	//RHQ
		ComSetObjValue(formObj.cnt_cd, comboObjects[0 + plusComboCnt].GetSelectText());			//cnt_cd
		ComSetObjValue(formObj.conti_cd, comboObjects[1 + plusComboCnt].GetSelectText());			//conti_cd
		ComSetObjValue(formObj.dmdt_trf_cd_list, comboObjects[2 + plusComboCnt].GetSelectText());			//dmdt_trf_cd_list
	}
	/*
	 *  initializing
	 */		
	function initSearchControls() {
		var formObj=document.form;
		comboObjects[0 + plusComboCnt].RemoveAll();
		comboObjects[1 + plusComboCnt].RemoveAll();
		comboObjects[2 + plusComboCnt].RemoveAll();
		ComSetObjValue(formObj.rhqCd, "");			//RHQ
		ComSetObjValue(formObj.svr_id, "");			//RHQ
		ComSetObjValue(formObj.cnt_cd, "");			//Coverage Country
		ComSetObjValue(formObj.conti_cd, "");		//Origin/Destination
		ComSetObjValue(formObj.dmdt_trf_cd_list, "");		//Tariff Type
		ComSetObjValue(formObj.dmdt_trf_grp_tp_cd1, "Y");	//Group Type
		ComSetObjValue(formObj.dmdt_trf_grp_tp_cd2, "Y");		//Group Type
		ComSetObjValue(formObj.validity1, "Y");		//Validity
		ComSetObjValue(formObj.validity2, "Y");		//Validity
		ComSetObjValue(formObj.validity3, "");		//Validity
	}		
	/*
	 * Search Field deactivating  
	 */		
	function disableSearchControls() {
		var formObj=document.form;
		formObj.rhqCd.disabled=true;
		comboObjects[0 + plusComboCnt].SetEnable(0);
		comboObjects[1 + plusComboCnt].SetEnable(0);
		comboObjects[2 + plusComboCnt].SetEnable(0);
		formObj.dmdt_trf_grp_tp_cd1.disabled=true;
		formObj.dmdt_trf_grp_tp_cd2.disabled=true;		
		formObj.validity1.disabled=true;		
		formObj.validity2.disabled=true;		
		formObj.validity3.disabled=true;		
	}
	/*
	 * activating searching fields 
	 */		
	function enableSearchControls() {
		var formObj=document.form;
		formObj.rhqCd.disabled=false;
		comboObjects[0 + plusComboCnt].SetEnable(1);
		comboObjects[1 + plusComboCnt].SetEnable(1);
		comboObjects[2 + plusComboCnt].SetEnable(1);
		formObj.dmdt_trf_grp_tp_cd1.disabled=false;
		formObj.dmdt_trf_grp_tp_cd2.disabled=false;		
		formObj.validity1.disabled=false;		
		formObj.validity2.disabled=false;		
		formObj.validity3.disabled=false;		
	}
	/*
	 * Initialize the query result information
	 */
	function initResultControls() {
		sheetObjects[0].RemoveAll();
	}
	/*
	 * htmlControl event initializing
	 */	
	function initControl() {
		initSearchControls();
		initResultControls();
		enableSearchControls();
	 	//IBMultiCombo initializing
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],k+1);
	    }
	    axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	}	
	/*
	 * combobox initializing
	 */
	function initComboSearch() {
	    //data initializing
    	var formObj=document.form;
    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,"",SEARCHLIST09,"");	
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,comboObjects[0],SEARCH02,COUNTRY);
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,comboObjects[1],SEARCH08,CONTINET);
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,comboObjects[2],SEARCH09,ALL_TARIFF_CD);		
	}
	
    /**
     * Delivered normally not received from the server being able to handle the data function
     */
    function handleNullString(sVal) {
         if (sVal == undefined || sVal == "null" || sVal.length == 0) return "";
         return ComTrim(sVal);
    }	 