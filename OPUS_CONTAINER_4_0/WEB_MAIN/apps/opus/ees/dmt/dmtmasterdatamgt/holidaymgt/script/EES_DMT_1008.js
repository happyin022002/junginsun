/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   :  EES_DMT_1008.js
*@FileTitle  : Holiday by Country Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/*------------------The following code added code to make a good  JSDoc ------------------*/

  	/* Developer's task	*/
	// common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var plusComboCnt = 1;
	var RHQ="RHQ";
	var COUNTRY="CNT";
	var REGION="RGN";
	var STATE="STE";
	var LOCATION="LOC";
	var CONTINENT="CONTI";
	var ROWMARK="|";
	var FIELDMARK="=";
	var isClearLocation=true;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	var currHolYr="";
	var currCntCd="";
	var currRgnCd="";
	var currLocCd="";
	var DEF_SHEET_HEIGHT = 257;
	var SUB_SHEET_HEIGHT = 215;
	// Event handler processing by button name */
    function processButtonClick(){
         /***** Tab sheets per case more than two additional sheets are used to specify a variable *****/
         var sheetObject1=sheetObjects[0];
         var sheetObject2=sheetObjects[1];
		 var sheetObject3=sheetObjects[2];
		 var sheetObject4=sheetObjects[3]; 
         /*******************************************************/
         var formObj=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1, formObj, IBSEARCH);
					break;
				case "btn_New":
					initControl();
					break;
				case "btn_DownExcel":
					doActionIBSheet(sheetObject4, formObj, IBDOWNEXCEL);
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
     * Register as an array IBSheet Object
     * The next batch of other items when you need treatment of fiberglass can add to an array that holds the process
     * Array defined at the top of the source
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
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
	    for(var k=0 ; k < comboObjects.length ; k++){
	        initCombo(comboObjects[k],k+1);
	    }
	    
	    sheet1_OnLoadFinish();
		initAxonControl();
		initYearControl();
		formObj.rhq.focus();
		
		doActionIBCombo2(sheetObjects[0], formObj, comboObjects[0], COMMAND06);
   		comboObjects[0].SetSelectIndex(0,false);
   		doActionIBCombo2(sheetObjects[0], formObj, comboObjects[3], COMMAND21);
    }
    
    
	function sheet1_OnLoadFinish() {
   		var formObj=document.form
   		var sheetObj=sheetObjects[0];
   		doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH02);
   		doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH01);
   	}
  /**
     * Sheet the initial setting, the header definition
     * param : sheetObj ==> sheet object, sheetNo ==> Sheet object ID of the tag attached to the serial number
     * Many case as the number of sheets to add the sheet, a sheet should initialize the module configuration
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":      // sheet4 init
                with(sheetObj){
                
              var HeadTitle="|Seq.|Country|Coverage|Coverage|Coverage|Year|Weekend|Days of Holiday|Update|Update|Update";
              var HeadTitle2="|Seq.|Country|CN|RGN|LOC|Year|Weekend|Days of Holiday|Date|Office|Name";
              var headCount=ComCountHeadTitle(HeadTitle) + 4;

              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"},
                          { Text:HeadTitle2, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cnt_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cvrg_cnt_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cvrg_rgn_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cvrg_loc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"hol_yr",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"hol_wknd_tp",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"hol_days",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"upd_usr_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"rgn_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ste_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"loc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"wknd_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
               
              InitColumns(cols);

              SetEditable(1);
              SetCountPosition(0);
              SetSheetHeight(DEF_SHEET_HEIGHT);
                    }


				break;         	
            case "sheet2":      // sheet2 init
                with(sheetObj){
                
              var HeadTitle="|SAT";

              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Status" },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"firstholiday",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 } ];
               
              InitColumns(cols);

              SetEditable(1);
              SetCountPosition(0);
              SetSheetHeight(SUB_SHEET_HEIGHT);
                    }


                break;
            case "sheet3":      // sheet3 init
                with(sheetObj){
                
              var HeadTitle="|SUN";

              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Status" },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"secondholiday",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 } ];
               
              InitColumns(cols);

              SetEditable(1);
              SetCountPosition(0);
              SetSheetHeight(SUB_SHEET_HEIGHT);
                    }


                break;
            case "sheet4":      // sheet4 init
                with(sheetObj){
              var HeadTitle="|Seq.|DATE|HOLIDAY";

              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                     {Type:"Seq",       Hidden:0, Width:65,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
                     {Type:"Text",      Hidden:0,  Width:135,  Align:"Center",  ColMerge:0,   SaveName:"hol_dt_in",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"hol_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
               
              InitColumns(cols);

              SetEditable(1);
              SetCountPosition(0);
              SetSheetHeight(SUB_SHEET_HEIGHT);
                    }


                break;
        }
    }
    
    
    function sheet1_OnSearchEnd(sheetObj,Code, Msg, StCode, StMsg){
    	var formObj=document.form;
    	if (sheetObj.RowCount()> 0) {
			doActionIBSheet(sheetObj, formObj, IBROWSEARCH);
			with(sheetObj) {
				currCntCd=GetCellValue(GetSelectRow(), "cvrg_cnt_cd");
				currRgnCd=GetCellValue(GetSelectRow(), "cvrg_rgn_cd");
				currLocCd=GetCellValue(GetSelectRow(), "cvrg_loc_cd");
				currHolYr=GetCellValue(GetSelectRow(), "hol_yr");
			}
		}
    	ComOpenWait(false);
    }
  	// Sheet processing-related processes
    function doActionIBSheet(sheetObj, formObj, sAction) {
        var cboCountryObj=comboObjects[0+plusComboCnt];
        var cboRegionObj=comboObjects[1+plusComboCnt];
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
           case IBSEARCH:     
				if (validateForm(sheetObj, formObj, sAction)) {
					if (sheetObj.id == "sheet1") {
						
						ComSetObjValue(formObj.svr_id, 	ComGetObjValue(formObj.rhq));		//RHQ
						ComSetObjValue(formObj.hol_yr, 	ComGetObjValue(formObj.year));		//Year
						ComSetObjValue(formObj.cnt_cd, 	cboCountryObj.GetSelectText());				//Country
						if (cboCountryObj.GetSelectText()== "CA" || cboCountryObj.GetSelectText()== "US") {
							ComSetObjValue(formObj.rgn_cd, 	"");							//Region
							ComSetObjValue(formObj.ste_cd, 	cboRegionObj.GetSelectText())				//State
						}
						else {
							ComSetObjValue(formObj.rgn_cd, 	cboRegionObj.GetSelectText())				//Region
							ComSetObjValue(formObj.ste_cd, 	"");							//State
						}
						ComSetObjValue(formObj.loc_cd, 	ComGetObjValue(formObj.location));	//Location		
						ComSetObjValue(formObj.f_cmd, 	SEARCH);							//Command
						ComOpenWait(true);
						
						initResultControls();
						sheetObj.DoSearch("EES_DMT_1008GS.do", FormQueryString(formObj) );
					}
				}
				break;	
			case IBROWSEARCH:
				if (validateForm(sheetObj,formObj,sAction)) {
					if (sheetObj.id == "sheet1") {
						var row=sheetObj.GetSelectRow();
						ComSetObjValue(formObj.hol_yr, 		sheetObj.GetCellValue(row, "hol_yr"));		//Hol_yr
						ComSetObjValue(formObj.cnt_cd, 		sheetObj.GetCellValue(row, "cnt_cd"));		//Country
						ComSetObjValue(formObj.rgn_cd, 		sheetObj.GetCellValue(row, "rgn_cd"));		//Region
						ComSetObjValue(formObj.ste_cd, 		sheetObj.GetCellValue(row, "ste_cd"));		//State
						ComSetObjValue(formObj.loc_cd, 		sheetObj.GetCellValue(row, "loc_cd"));		//Location
						ComSetObjValue(formObj.wknd_tp_cd, 	sheetObj.GetCellValue(row, "wknd_tp_cd"));
						ComSetObjValue(formObj.f_cmd, 		SEARCH01);								//Command
						var sXml=sheetObj.GetSearchData("EES_DMT_1008GS.do" , FormQueryString(formObj));
			            var arrXml=sXml.split("|$$|");
		            	if (arrXml.length > 0) sheetObjects[1].LoadSearchData(arrXml[0],{Sync:1} );
						if (arrXml.length > 1) sheetObjects[2].LoadSearchData(arrXml[1],{Sync:1} );
			            if (arrXml.length > 2) sheetObjects[3].LoadSearchData(arrXml[2],{Sync:1} );
						setHolidayTitle();				
					}
				}
				break;
			case IBDOWNEXCEL:	// EXCEL DOWNLOAD
				if(sheetObj.RowCount() < 1){//no data
					  ComShowCodeMessage("COM132501");
					}else{
						sheetObj.Down2Excel({ HiddenColumn:-1});
					}
				
				break;				
        }
    }
    
    
    /**
     *  doActionIBCombo
     */
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
    

    function doActionIBCombo(sheetObj, formObj, sAction, sComboAction) {
		var cboCountryObj=comboObjects[0+plusComboCnt];
		var cboRegionObj=comboObjects[1+plusComboCnt];
		var regionList;
		var countryList;
        sheetObj.ShowDebugMsg(false);
		sheetObj.SetWaitImageVisible(0);
        switch(sAction) {
			case IBSEARCH:      
				if (sheetObj.id == "sheet1") {
					ComSetObjValue(formObj.f_cmd, 	sComboAction);
					var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
					switch(sComboAction) {
						case SEARCH01:
    						regionList=handleNullString(ComGetEtcData(sXml, REGION));
    						cboRegionObj.RemoveAll();
    						if (regionList != "") {
    							addComboItem(cboRegionObj, regionList.split(ROWMARK));
    						}
							break;
						case SEARCH02:
    						countryList=handleNullString(ComGetEtcData(sXml, COUNTRY));
    						cboCountryObj.RemoveAll();
    						if (regionList != "") {
    							addComboItem(cboCountryObj, countryList.split(ROWMARK));
    						}
							break;
						case SEARCH05:
							countryList=handleNullString(ComGetEtcData(sXml, COUNTRY));
							cboCountryObj.RemoveAll();
							if (countryList != "") {
								addComboItem(cboCountryObj, countryList.split(ROWMARK));
							}							
							break;
						case SEARCH03:
							if (cboCountryObj.GetSelectText()== "CA" || cboCountryObj.GetSelectText()== "US") {
								regionList=handleNullString(ComGetEtcData(sXml, STATE));
							} 
							else {
								regionList=handleNullString(ComGetEtcData(sXml, REGION));
							}
							cboRegionObj.RemoveAll();
							if (regionList != "") {
								addComboItem(cboRegionObj, regionList.split(ROWMARK));
							}							
							break;
						case SEARCH04:
							rhqList=handleNullString(ComGetEtcData(sXml, RHQ));
							if (rhqList != "") {
								arrRHQList=rhqList.split(ROWMARK);
								fieldRHQList=arrRHQList[0].split(FIELDMARK);
								ComSetObjValue(formObj.rhq, fieldRHQList[0]);
								
								for(var i=0; i<comboObjects[3].GetItemCount(); i++){
									if(fieldRHQList[0] == comboObjects[3].GetIndexText(i+1, 1)){
										comboObjects[3].SetSelectIndex(i,false);
										comboObjects[0].SetSelectIndex(i,false);
							        }
								}
							}
							countryList=handleNullString(ComGetEtcData(sXml, COUNTRY));
							if (countryList != "") {
								setComboItem(cboCountryObj, countryList.split(ROWMARK));
							}
							locCd=ComTrim(ComGetObjValue(formObj.location)).substring(0, 2);
							if (locCd == "CA" || locCd == "US") {
								regionList=handleNullString(ComGetEtcData(sXml, STATE));
							} 
							else {
								regionList=handleNullString(ComGetEtcData(sXml, REGION));
							}
							if (regionList != "") {
								var cntCd=cboCountryObj.GetSelectText();
								switch(cntCd) {
									case "CA":
									case "US":
										Region.innerHTML="State";
										break;
									default:
										Region.innerHTML="Region";
								}
								ComSetObjValue(formObj.cnt_cd, 	cntCd);

								doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH03);
								setComboItem(cboRegionObj, regionList.split(ROWMARK));
							} 
							else {
								ComShowCodeMessage("DMT00110", "Location");
								ComClearObject(formObj.location);
								ComSetFocus(formObj.location);
							}
							
							var rhq=handleNullString(ComGetEtcData(sXml, CONTINENT));//Country Code로 RHQ select
							if (rhq != "") {								
								for(var i=0; i<comboObjects[0].GetItemCount(); i++){
									if(rhq == comboObjects[0].GetIndexText(i+1, 1)){
										comboObjects[0].SetSelectIndex(i,false);
							        }
								}
							}
							break;
						case SEARCH07:
							rhqList=handleNullString(ComGetEtcData(sXml, RHQ));
							if (rhqList != "") {
								fieldRHQList=rhqList.split(FIELDMARK);
								ComSetObjValue(formObj.rhq, fieldRHQList[0]);
								
								for(var i=0; i<comboObjects[3].GetItemCount(); i++){
									if(fieldRHQList[0] == comboObjects[3].GetIndexText(i+1, 1)){
										comboObjects[3].SetSelectIndex(i,false);
//										comboObjects[0].SetSelectIndex(i,false);
							        }
								}

							}
							countryList=handleNullString(ComGetEtcData(sXml, COUNTRY));
							if (countryList != "") {
								setComboItem(cboCountryObj, countryList.split(ROWMARK));
							}
//							regionList=handleNullString(ComGetEtcData(sXml, REGION));
//							if (regionList != "") {
//								setComboItem(cboRegionObj, regionList.split(ROWMARK));
//							}

							var rhq=handleNullString(ComGetEtcData(sXml, CONTINENT));//Country Code로 RHQ select
							if (rhq != "") {								
								for(var i=0; i<comboObjects[0].GetItemCount(); i++){
									if(rhq == comboObjects[0].GetIndexText(i+1, 1)){
										comboObjects[0].SetSelectIndex(i,false);
							        }
								}
							}
							break;
						case SEARCH16:
							rhqList=handleNullString(ComGetEtcData(sXml, RHQ));
							if (rhqList != "") {
								fieldRHQList=rhqList.split(FIELDMARK);
								
								for(var i=0; i<comboObjects[3].GetItemCount(); i++){
									if(fieldRHQList[0] == comboObjects[3].GetIndexText(i+1, 1)){
//										ComSetObjValue(formObj.rhq, comboObjects[0].GetIndexText(i+1, 1));
										comboObjects[3].SetSelectIndex(i,false);
//										comboObjects[0].SetSelectIndex(i,false);	
							        }
								}
								
//								if(fieldRHQList[0] == 'USA')
//						        {
//						         ComSetObjValue(formObj.rhq, 'NYCHQ');
//						        }
//						        else if(fieldRHQList[0] == 'EUR')
//						        {
//						         ComSetObjValue(formObj.rhq, 'LOCHQ');
//						        }
//						        else if(fieldRHQList[0] == 'KOR' || fieldRHQList[0] == 'SWA' || fieldRHQList[0] == 'CHN')
//						        {
//						         ComSetObjValue(formObj.rhq, 'SINHQ');
//						        }

								//ComSetObjValue(formObj.rhq, fieldRHQList[0]);
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
								setComboItem(cboCountryObj, countryList.split(ROWMARK));
							}							
							break;												
					}						
				};
				break;
        }
		sheetObj.SetWaitImageVisible(1);
    }
    /**
     * Data in the field adds a combo
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
		if (checked) comboObj.SetSelectText(checkedItem, false);
	}
	function setComboItem(comboObj,comboItems) {
		var checkedItem=comboItems[0].split(FIELDMARK);
		comboObj.SetSelectText(checkedItem[0], false);
	}
    /**
     * Screen input form validation process for handling
     */
    function validateForm(sheetObj,formObj,sAction){
		//필수항목에 데이터가 입력되었는지 확인한다.
        return true;
    }
	/** 
	 * Register as an array IBCombo Object
  	 * param : combo_obj ==> combo object
  	 * The next batch of other items when you need treatment of fiberglass can add to an array that holds the process
  	 * Array defined at the top of the source
	 */ 
	function setComboObject(combo_obj) {  
	    comboObjects[comboCnt++]=combo_obj;  
	} 
	/**
	 * Combo basic setting 
	 * param : comboObj ==> combo object, comboNo ==> Combo object ID of the tag attached to the serial number
	 * If the number of combo a combo by adding the number of case sheets to initialize the module configuration
	 */ 
	function initCombo(comboObj, comboNo) {
	    var formObject=document.form;
		switch(comboNo) {
			case 1:
				with (comboObj) { 
  					SetMultiSelect(0);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "50");
					SetColWidth(1, "190");
  					SetDropHeight(160);
  					ValidChar(2, 2);
					SetMaxLength(2);
		    	}
				break;
			case 2: 
				with (comboObj) { 		
  					SetMultiSelect(0);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "50");
					SetColWidth(1, "190");
  					SetDropHeight(160);
  					ValidChar(2, 2);
					SetMaxLength(3);
				}
				break;			
	     }  
	} 	
	function rhq_OnChange() {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if (isClearLocation) clearLocation();
		if (ComTrim(ComGetObjValue(formObj.rhq)).length > 0) {
			ComSetObjValue(formObj.svr_id, 	ComGetObjValue(formObj.rhq));	//RHQ
			doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH05);
		}
		else {
			doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH02);
		}
		doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH01);		
		formObj.year.focus();
	}
	function cboCountry_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, Text, Index_Code) {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		var cntCd=comboObj.GetSelectText();
		if (isClearLocation) clearLocation();
		if (cntCd.length == 0) {
			doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH01);
			return;	
		}			
		switch(cntCd) {
			case "CA":
			case "US":
				Region.innerHTML="State";
				break;
			default:
				Region.innerHTML="Region";
		}
		ComSetObjValue(formObj.cnt_cd, 	cntCd);
		doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH16);		
		doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH03);
	}	
	function cboRegion_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, Text, Index_Code) {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		var rgnCd=comboObj.GetSelectText();
		if (isClearLocation) clearLocation();
		if (rgnCd.length == 0) return;
		ComSetObjValue(formObj.rgn_cd, rgnCd);
		doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH07);
	}
	function checkLocation() {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
    	if (ComTrim(ComGetObjValue(formObj.location)).length == 5) {
			var locCd=ComTrim(ComGetObjValue(formObj.location));
    		if (locCd.length == 5) {
				isClearLocation=false;
				ComSetObjValue(formObj.loc_cd, locCd);
    			doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH04);
				isClearLocation=true;
			}
    	}
	}
	function sheet1_OnSort(sheetObj, Col, SortArrow) {
		with(sheetObj) {
			for (var row=HeaderRows(); row <= LastRow(); row++) {
if (	currCntCd == GetCellValue(row, "cvrg_cnt_cd")
&&	currRgnCd == GetCellValue(row, "cvrg_rgn_cd")
&&	currLocCd == GetCellValue(row, "cvrg_loc_cd")
&&	currHolYr == GetCellValue(row, "hol_yr")) {
					SetSelectRow(row);
					break;
				}
			}
		}
	}
	function sheet1_OnClick(sheetObj, Row, Col, value) {
		with(sheetObj) {
currCntCd=GetCellValue(GetSelectRow(), "cvrg_cnt_cd");
currRgnCd=GetCellValue(GetSelectRow(), "cvrg_rgn_cd");
currLocCd=GetCellValue(GetSelectRow(), "cvrg_loc_cd");
currHolYr=GetCellValue(GetSelectRow(), "hol_yr");
		}
		doActionIBSheet(sheetObj, document.form, IBROWSEARCH);
	}
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
		//sheetObjects[1].InitHeadRow(0, sheet1Title, false);
		//sheetObjects[2].InitHeadRow(0, sheet2Title, false);
	}
	function initAxonControl() {  
	    axon_event.addListenerFormat('keypress',    'obj_keypress', 	document.form);  
		axon_event.addListener('beforedeactivate', 	'obj_deactivate', 	'location');
		axon_event.addListener('keydown', 			'ComKeyEnter', 		'form'); 		
	}           
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
	function obj_deactivate() {
		obj=event.srcElement;
		if(obj.value.length > 0 && obj.value.length < 5) {
			ComShowCodeMessage("DMT00110", "Location");
			ComClearObject(obj);
		}
	}	
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
	function initSearchControls() {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		ComSetObjValue(formObj.hol_yr, 		"");	//Year ComboBox
		ComSetObjValue(formObj.year, 		"");	//Year ComboBox
		ComSetObjValue(formObj.svr_id, 		"");
		ComSetObjValue(formObj.cnt_cd, 		"");
		ComSetObjValue(formObj.rgn_cd, 		"");
		ComSetObjValue(formObj.ste_cd, 		"");
		ComSetObjValue(formObj.loc_cd, 		"");
		ComSetObjValue(formObj.location, 	"");
		ComSetObjValue(formObj.wknd_tp_cd, 	"");
		initYearControl();
		comboObjects[0].SetSelectIndex(0,false);
		//Region Caption
		Region.innerHTML="Region";				
   		doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH02);
   		doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH01);
	}		
	function initResultControls() {
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
		sheetObjects[3].RemoveAll();
		//sheetObjects[1].InitHeadRow(0, "|SAT", false);
		//sheetObjects[2].InitHeadRow(0, "|SUN", false);
	}
	function clearLocation() {
		var formObj=document.form;
		ComSetObjValue(formObj.loc_cd, "");
		ComSetObjValue(formObj.location, "");
	}
	/*
	 * html control event initializing 
	 */	
	function initControl() {
		initSearchControls();
		initResultControls();
	}
    /**
     * Delivered normally not received from the server being able to handle the data function
     */
    function handleNullString(sVal) {
         if (sVal == undefined || sVal == "null" || sVal.length == 0) return "";
         return ComTrim(sVal);
    }	 
