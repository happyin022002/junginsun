/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_1009.js
*@FileTitle  : SB45 Ruling Exceptions
*@author     : CLT
*@version    : 1.0
*@since      : 2016/01/25
=========================================================*/
var ADDROW=false;
var IBSEARCH_CVRG=102;
    var IBSEARCH_CHECK_DUP=110;
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
    var YARD="YD";
	//DATA 구분자 정의
	var ROWMARK="|";
	var FIELDMARK="=";
	//Field 컬럼순서 정의
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
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	
	// Event handler processing by button name
	function processButtonClick(){
          var sheetObject1=sheetObjects[0];
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
 				case "t1btng_rowadd":
 					  sheetObject1.DataInsert(-1);
					break;
				case "t1btng_delete":
					sheetObject1.SetRowStatus(sheetObject1.GetSelectRow(),'D');
					break;
				case "t1btng_rowcopy":
					var row = sheetObject1.DataCopy();
					sheetObject1.SetCellValue(row, "sheet1_exclu_seq", "", 0);
					break;
				case "t1btng_save":
					doActionIBSheet(sheetObject1,formObject,MULTI);
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
	
    function doActionSave() {
    	var formObj=document.form;
    	var sheetObj=sheetObjects[0];
    	
		if (validateForm(sheetObj,formObj,IBSAVE)) {
			doActionIBSheet(sheetObj,formObj,MULTI);
			
			resetAll();
			doActionIBSheet(sheetObj,formObj,IBSEARCH);			
		}    	
    }
    
    function resetAll() {
    	var formObj = document.form;
    	
    	ComResetAll();
		ComSetObjValue(formObj.cnt_cd, 			"");
		ComSetObjValue(formObj.loc_cd, 			"");
		ComSetObjValue(formObj.location, 		"");    	
    	ComSetObjValue(formObj.retry, 	 		"");
    	ComSetObjValue(formObj.io_bnd_cd, 		"");
    	ComSetObjValue(formObj.dmdt_calc_tp_cd, "");
    	ComSetObjValue(formObj.result, 			"");
    }
    
    function deleteRow() {
	    with (sheetObjects[0]) {
	        var sRowStr=FindCheckedRow("sheet1_del_chk");
	        var arr=sRowStr.split("|");
	        for (var i=0; i<arr.length - 1; i++) {
	        	if (GetCellValue(arr[i], prefix+"flg") == "Y") {
	                RowDelete(arr[i]);
	            }else{
	            	SetRowStatus(arr[i],"D");
	            	SetRowHidden(arr[i],1);
	            }
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
        
    	// Initializing IBMultiCombo  
        for(var k=0;k<comboObjects.length;k++){
        	initCombo(comboObjects[k],k+1);
        }
        initControl();
        sheet1_OnLoadFinish();
    }
    
    function sheet1_OnLoadFinish() {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		// Country
		doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH02);
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
        		    var HeadTitle=" Seq.|Del|STS|Country|Location|Yard|Bound|DEM/DET Type|SEQ|Sat|Sun|Holidays|Effective From|Effective To";
        		    var headCount=ComCountHeadTitle(HeadTitle);

        		    SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

        		    var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
        		    var headers = [ { Text:HeadTitle, Align:"Center"} ];
        		    InitHeaders(headers, info);

        		    var cols = [ {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"seq" },
	            	             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk1",       KeyField:0,  CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
       		                     {Type:"Status",    Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
        		                 {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cnt_cd",        KeyField:1,  CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, AcceptKeys:"E|N|[ ]", InputCaseSensitive:1 },
        		                 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"loc_cd",        KeyField:0,  CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N|[ ]", InputCaseSensitive:1 },
        		                 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"yd_cd",         KeyField:0,  CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:7, AcceptKeys:"E|N|[ ]", InputCaseSensitive:1 },
        		                 {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"io_bnd_cd",     KeyField:1,  CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        		                 {Type:"Combo",     Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"dem_det_tp_cd", KeyField:1,  CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"exclu_seq",     KeyField:0,  CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        		                 {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"xcld_sat_flg",  KeyField:1,  CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        		                 {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"xcld_sun_flg",  KeyField:1,  CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        		                 {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"xcld_hol_flg",  KeyField:1,  CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        		                 {Type:"Date",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"eff_dt",        KeyField:1,  CalcLogic:"",   Format:"Ymd",    PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        		                 {Type:"Date",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"exp_dt",        KeyField:0,  CalcLogic:"",   Format:"Ymd",    PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
        		       
        		    InitColumns(cols);

        		    SetEditable(1);
        		    SetCountPosition(0);

        	        SetSheetHeight(365);
        			SetColProperty(prefix+"io_bnd_cd",     {ComboText:"ALL|OB|IB",       ComboCode:"A|O|I"} );
                    SetColProperty(prefix+"dem_det_tp_cd", {ComboText:dem_det_tp_cdText, ComboCode:dem_det_tp_cdCode} );
        			SetColProperty(prefix+"xcld_sat_flg",  {ComboText:"|Y|N",            ComboCode:"|Y|N"} );
        			SetColProperty(prefix+"xcld_sun_flg",  {ComboText:"|Y|N",            ComboCode:"|Y|N"} );
        			SetColProperty(prefix+"xcld_hol_flg",  {ComboText:"|Y|N",            ComboCode:"|Y|N"} );
        			
        			InitComboNoMatchText(1, "", 1);
        		}
        		break;
        }
 	}
   
 	// Process of Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBSEARCH:
				if(!validateForm(sheetObj,formObj,sAction)) return;
				
				formObj.f_cmd.value=SEARCH;
				formObj.cnt_cd.value=comboObjects[0].GetSelectText();
				formObj.loc_cd.value=ComTrimAll(formObj.location.value);
		        formObj.io_bnd_cd.value = formObj.bound.options[formObj.bound.selectedIndex].value;
		        if(combo5.GetSelectCode() == '') {
	                ComSetObjValue(formObj.yd_cd,  formObj.yd_cd1.value);
		        } else {
	                ComSetObjValue(formObj.yd_cd,  combo5.GetSelectCode());
		        }
                ComSetObjValue(formObj.eff_dt,  '');
                

				var sXml = sheetObj.GetSearchData("EES_DMT_1009GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix) );
				sheetObj.LoadSearchData(sXml, {Sync:1});
			break;
			
			case IBSEARCH_CHECK_DUP:
				ComSetObjValue(formObj.f_cmd, SEARCH01);
				ComOpenWait(true);
				sheetObjects[0].SetWaitImageVisible(0);

				var sXml=sheetObjects[0].GetSearchData("EES_DMT_1009GS.do", FormQueryString(formObj));
				ComOpenWait(false);
				var result=ComGetEtcData(sXml, "RESULT");
				ComSetObjValue(formObj.result, result);
			break;
			
            case MULTI:
            	// 1. validate data
				if(!validateForm(sheetObj,formObj,sAction)) return;
				// 2. set command parameter & get form querystring
				ComSetObjValue(formObj.f_cmd, MULTI);
				var sParam="";
				var sParam1=sheetObjects[0].GetSaveString();
				if (sheetObj.IsDataModified()== true) {
					sParam=sParam1 + "&";
				}
				sParam += "&" + FormQueryString(formObj);				
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				// 3. register to server & get result
				var sXml=sheetObj.GetSaveData("EES_DMT_1009GS.do", sParam);
				ComOpenWait(false);
				var result = ComGetEtcData(sXml, "DUPLICATED");
				var seq = ComGetEtcData(sXml, "SEQ");
				ComSetObjValue(formObj.result, result);
				// 3.1. duplicated data exists
				if (ComGetObjValue(formObj.result) == "Y") {
					with(sheetObj) {
						var row = FindText(prefix + "seq", seq);
						ComSetObjValue(formObj.cnt_cd, GetCellValue(row, prefix + "cnt_cd"));
						ComSetObjValue(formObj.loc_cd, GetCellValue(row, prefix + "loc_cd"));
						ComSetObjValue(formObj.yd_cd, GetCellValue(row, prefix + "yd_cd"));
						ComSetObjValue(formObj.io_bnd_cd, GetCellValue(row, prefix + "io_bnd_cd"));
						ComSetObjValue(formObj.dem_det_tp_cd, GetCellValue(row, prefix + "dem_det_tp_cd"));
						ComSetObjValue(formObj.eff_dt, GetCellValue(row, prefix + "eff_dt"));
						ComSetObjValue(formObj.exp_dt, GetCellValue(row, prefix + "exp_dt"));
						
//						var dupAlertMsg="\n\n";
//						dupAlertMsg += "Country : [ " + GetCellValue(row, prefix + "cnt_cd")+ " ]";
//						dupAlertMsg += "\n";
//						dupAlertMsg += "Location : [ " + GetCellText(row, prefix + "loc_cd") + " ]";
//						dupAlertMsg += "\n";
//						dupAlertMsg += "Yard : [ " + GetCellText(row, prefix + "yd_cd") + " ]";
//						dupAlertMsg += "\n";
//						dupAlertMsg += "Bound : [ " + GetCellText(row, prefix + "io_bnd_cd") + " ]";
//						dupAlertMsg += "\n";
//						dupAlertMsg += "DEM/DET Type : [ " + GetCellText(row, prefix + "dem_det_tp_cd") + " ]";
//						dupAlertMsg += "\n";
//						dupAlertMsg += "Effective From : [ " + GetCellText(row, prefix + "eff_dt") + " ]";
//						ComShowCodeMessage("DMT00138", seq, dupAlertMsg);
				 	}
					alertDupMsg(sheetObj, null, seq);
				} else { // 3.2. load to sheet
					sheetObj.LoadSaveData(sXml, {Sync:1});
				}
			break;
         }
     }
    
     function doActionIBCombo(sheetObj,formObj,sAction,sComboAction) {
         sheetObj.ShowDebugMsg(false);
         sheetObj.SetWaitImageVisible(0);
         switch(sAction) {
 			case IBSEARCH:
 				if (sheetObj.id == "sheet1") {
 					setParameters(sComboAction);

 					var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
 					var comboDatas;
 					var comboItems;
 					var comboItem;
 					var sheetComboItems
 					switch(sComboAction) {
 						case SEARCH01:
     						comboItems=ComGetEtcData(sXml, REGION).split(ROWMARK);
 							addComboItem(comboObjects[1],comboItems);
 							sheetComboItems=ComGetEtcData(sXml, REGION);
 							addCellComboItem(sheetObj,sheetComboItems,prefix+"rgn_cd",false);
 							break;
 						case SEARCH02:
     						comboItems=ComGetEtcData(sXml, COUNTRY).split(ROWMARK);
 							addComboItem(comboObjects[0],comboItems);
 							sheetComboItems=ComGetEtcData(sXml, COUNTRY);
 							addCellComboItem(sheetObj,sheetComboItems,prefix+"cnt_cd",false);
 						   if (ADDROW) {
 							     sheetComboItems=ComGetEtcData(sXml, REGION);
 							     addCellComboItem(sheetObj,sheetComboItems,prefix+"rgn_cd",false);
 							   }
 							break;
 						case SEARCH03:
 							comboObjects[1].RemoveAll();
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
 						case SEARCH04:
 							comboDatas=ComGetEtcData(sXml, COUNTRY);
 							if (comboDatas != undefined) {
 								comboItems=comboDatas.split(ROWMARK);
 								setComboItem(comboObjects[0],comboItems);
 							} 
 							if (comboObjects[0].GetSelectText()== "CA" || comboObjects[0].GetSelectText()== "US") {
// 								Region.innerHTML="State";
 								comboDatas=ComGetEtcData(sXml, STATE);
 							} else {
// 								Region.innerHTML="Region";
 								comboDatas=ComGetEtcData(sXml, REGION);
 							}
 							if (comboDatas != undefined) {
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
 						case SEARCH07:
 							comboDatas=ComGetEtcData(sXml, COUNTRY);
 							if (comboDatas != undefined) {
 								comboItems=comboDatas.split(ROWMARK);
 								setComboItem(comboObjects[0],comboItems);
 							}
 							clearLocation();
 							comboObjects[1].RemoveAll();
 							comboDatas=ComGetEtcData(sXml, REGION);
 							if (comboDatas != undefined) {
 								comboItems=comboDatas.split(ROWMARK);
 								addComboItem(comboObjects[1],comboItems,true);
 							}
 							break;
						case SEARCH13:
						case SEARCH17:
							comboDatas=ComGetEtcData(sXml, COUNTRY);
							if (comboDatas != undefined) {
								comboItems=comboDatas.split(ROWMARK);
								setComboItem(comboObjects[0],comboItems);
								//응답 XML 에서 Region or State 정보를 추출해서 목록에서 선택해준다.
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
 		
     function sheet1_OnChange(sheetObj,Row,Col,Value) {
 		var formObj=document.form;
 		var sheetComboItems;
 		with(sheetObj) {
 			switch(ColSaveName(Col)) {
 				case prefix+"cnt_cd":
 					var cntCd=ComTrim(sheetObj.GetCellValue(Row,Col));
 					if (cntCd.length == 0) {
 						doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH02);
 						sheetObj.SetCellValue(Row, prefix+"rgn_cd","");
 					}
 					else if (cntCd.length == 2) {
 						if (cntCd.substring(0,2) == "US" || cntCd.substring(0,2) == "CA") {
 							doActionIBCommon(sheetObj,formObj,IBSEARCH_CVRG,SEARCH03,prefix+"cnt_cd" + "|" + prefix+"ste_cd");
 						}
 						else
 							doActionIBCommon(sheetObj,formObj,IBSEARCH_CVRG,SEARCH03,prefix+"cnt_cd" + "|" + prefix+"rgn_cd");
 					}
 					if (isClearLocation) clearLocation(sheetObj,prefix + "loc_cd");
 					break;				
 				case prefix+"rgn_cd":
 					var rgnCd=ComTrim(sheetObj.GetCellValue(Row,Col));
 					switch(rgnCd.length) {
 						case 2: 
 							doActionIBCommon(sheetObj,formObj,IBSEARCH_CVRG,SEARCH17,"|" + prefix+"cnt_cd" + "|" + prefix+"ste_cd");
 							break;
 						case 3:
 							doActionIBCommon(sheetObj,formObj,IBSEARCH_CVRG,SEARCH13,"|" + prefix+"cnt_cd" + "|" + prefix+"rgn_cd");
 							break;
 					}
 					if (isClearLocation) clearLocation(sheetObj,prefix+"loc_cd");
 					break;
 				case prefix + "loc_cd":
 					var locCd=ComTrim(sheetObj.GetCellValue(Row,Col));
 		    		if (locCd.length == 5) {
 						isClearLocation=false;
 						isValueSettingEvent=true;
 						if (locCd.substring(0,2) == "US" || locCd.substring(0,2) == "CA") {
 							sheetObj.SetCellValue(Row,prefix + "rgn_cd","",0);
 							doActionIBCommon(sheetObj,formObj,IBSEARCH_CVRG,SEARCH04,prefix+"cnt_cd" + "|" + prefix+"ste_cd" + "|" + prefix+"loc_cd");
 						}
 						else {
 							sheetObj.SetCellValue(Row,prefix + "ste_cd","",0);
 							doActionIBCommon(sheetObj,formObj,IBSEARCH_CVRG,SEARCH04,prefix+"cnt_cd" + "|" + prefix+"rgn_cd" + "|" + prefix+"loc_cd");
 						}
 						isValueSettingEvent=false;
 						isClearLocation=true;
 					}
 					else if (locCd.length > 0) {
 						ComShowCodeMessage("DMT00110", "Location");
 						sheetObj.SetCellValue(Row, Col,"",0);
 					}
 					break;
 				case prefix + "yd_cd":
 					var ydCd=ComTrim(sheetObj.GetCellValue(Row,Col));
 		    		if (ydCd.length == 7) {
 						isClearLocation=false;
 						isValueSettingEvent=true;
 						if (ydCd.substring(0,2) == "US" || ydCd.substring(0,2) == "CA") {
 							sheetObj.SetCellValue(Row,prefix + "rgn_cd","",0);
 							doActionIBCommon(sheetObj,formObj,IBSEARCH_CVRG,SEARCH21,prefix+"cnt_cd" + "|" + prefix+"ste_cd" + "|" + prefix+"loc_cd" + "|" + prefix+"yd_cd");
 						}
 						else {
 							sheetObj.SetCellValue(Row,prefix + "ste_cd","",0);
 							doActionIBCommon(sheetObj,formObj,IBSEARCH_CVRG,SEARCH21,prefix+"cnt_cd" + "|" + prefix+"rgn_cd" + "|" + prefix+"loc_cd" + "|" + prefix+"yd_cd");
 						}
 						isValueSettingEvent=false;
 						isClearLocation=true;
 					}
 					else if (ydCd.length > 0) {
 						ComShowCodeMessage("DMT00110", "Yard");
 						sheetObj.SetCellValue(Row, Col,"",0);
 					}
 					break;
 				case prefix + "del_chk1":
 		    		if (Value == "1") {
						sheetObj.SetCellValue(Row, prefix + "ibflag", "D", 0);
 					} else {
						sheetObj.SetCellValue(Row, prefix + "ibflag", "", 0);
 					}
 					break;
 			}
 		}
 	}
    
     function sheet1_OnSort(sheetObj, Col, SortArrow){
    	 sheetObj.ReNumberSeq();   
     }     
     
    function doActionIBCommon(sheetObj,formObj,sAction,sComboAction,sComboField,sInitCellCombo) {
        sheetObj.ShowDebugMsg(false);
		sheetObj.SetWaitImageVisible(0);
	    switch(sAction) {
	    	case IBSEARCH_CVRG:
	    		setCommonParameters(sheetObj,sComboAction);
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);

				var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
				ComOpenWait(false);
				var comboDatas;
				var comboItems;
				var comboItem;
				sInitCellCombo=sInitCellCombo == false ? false : true;
				switch(sComboAction) {
					case SEARCH03:
						sComboField=sComboField.split(ROWMARK);
						var cntCd=sheetObj.GetCellValue(sheetObj.GetSelectRow(), sComboField[0]);
						if (cntCd.substring(0,2) == "US" || cntCd.substring(0,2) == "CA") {
							comboDatas=ComGetEtcData(sXml, "STE");
						} else {
							comboDatas=ComGetEtcData(sXml, "RGN");
						}
						addCellComboItem(sheetObj,comboDatas,sComboField[1],true);
						break;
					case SEARCH04:
						sComboField=sComboField.split(ROWMARK);
						comboDatas=ComGetEtcData(sXml, "CNT");
						if (comboDatas != undefined) {
							setCellComboItem(sheetObj,comboDatas,sComboField[0]);
							var cntCd=ComTrim(sheetObj.GetCellValue(sheetObj.GetSelectRow(), sComboField[0]));
							if (cntCd != "") {
								if (cntCd.substring(0,2) == "US" || cntCd.substring(0,2) == "CA") {
									comboDatas=ComGetEtcData(sXml, "STE");
								} else {
									comboDatas=ComGetEtcData(sXml, "RGN");
								}
								setCellComboItem(sheetObj,comboDatas,sComboField[1]);
							}
						}
						else {
							ComShowCodeMessage("DMT00110", "Location");
							sheetObj.SetCellValue(sheetObj.GetSelectRow(),sComboField[2],"",0);
						}
						break;
					case SEARCH13:	
					case SEARCH17:
						sComboField=sComboField.split(ROWMARK);
						comboDatas=ComGetEtcData(sXml, "CNT");
						if (comboDatas != undefined) {
							setCellComboItem(sheetObj,comboDatas,sComboField[1]);
							var cntCd=ComTrim(sheetObj.GetCellValue(sheetObj.GetSelectRow(), sComboField[1]));
							if (cntCd != "") {
								if (cntCd.substring(0,2) == "US" || cntCd.substring(0,2) == "CA") {
									comboDatas=ComGetEtcData(sXml, "STE");
								} 
								else {
									comboDatas=ComGetEtcData(sXml, "RGN");
								}
								setCellComboItem(sheetObj,comboDatas,sComboField[2]);
							}
						}
						else {
							ComShowCodeMessage("DMT00110", "Region");
							sheetObj.SetCellValue(sheetObj.GetSelectRow(), sComboField[2],"",0);
						}
						break;
					case SEARCH21:
						sComboField=sComboField.split(ROWMARK);
						comboDatas=ComGetEtcData(sXml, "CNT");
						if (comboDatas != undefined) {
							setCellComboItem(sheetObj,comboDatas,sComboField[0]);
							var cntCd=ComTrim(sheetObj.GetCellValue(sheetObj.GetSelectRow(), sComboField[0]));
							if (cntCd != "") {
								if (cntCd.substring(0,2) == "US" || cntCd.substring(0,2) == "CA") {
									comboDatas=ComGetEtcData(sXml, "STE");
								} else {
									comboDatas=ComGetEtcData(sXml, "RGN");
								}
								setCellComboItem(sheetObj,comboDatas,sComboField[1]);

								comboDatas=ComGetEtcData(sXml, "LOC");
								setCellComboItem(sheetObj,comboDatas,sComboField[2]);
							}
						}
						else {
							ComShowCodeMessage("DMT00110", "Yard");
							sheetObj.SetCellValue(sheetObj.GetSelectRow(),sComboField[3],"",0);
						}
						break;
				}
	    		break;
        }
		sheetObj.SetWaitImageVisible(1);
    }
    
	function setCellComboItem(sheetObj,comboDatas,sComboKey) {
		var sRow=sheetObj.GetSelectRow();
		var sVal="";
		if (comboDatas != undefined) {
			var comboItem=comboDatas.split(FIELDMARK);
			sVal=comboItem[0];
		}
		sheetObj.SetCellValue(sRow, sComboKey,sVal);
	}
	
 	function addCellComboItem(sheetObj,comboDatas,sComboKey,isCellCombo,isOnlyTextView) {
 		var sRow=sheetObj.GetSelectRow();
 		var comboTxt="";
 		var comboVal="";
 		var comboItems;
 		var comboItem;
 		var comboInitTxt="";
 		var comboInitVal="";
 		if (comboDatas != undefined && ComTrim(comboDatas).length > 0) {
 			comboItems=comboDatas.split(ROWMARK);
 			for (var i=0 ; i < comboItems.length ; i++) {
 				comboItem=comboItems[i].split(FIELDMARK);
 				if (!isCellCombo && i == 0) {
 					comboInitTxt=comboItem[0];
 					comboInitVal=comboItem[0];
 				}
 				if (ComTrim(comboItem[0]) != "") {
					if (isOnlyTextView) {
						comboTxt += comboItem[1];
					}
					else if (comboItem[1].indexOf("\^") != -1) {
						comboTxt += comboItem[1].replace("^", " - ");
					}
					//Text 와 Code 를 둘 다 보여줘야 할 때
					else {
						comboTxt += comboItem[0] + "\t" + comboItem[1];
					}
					comboVal += comboItem[0];
				}
				else {
					comboTxt += " \t ";
					comboVal += " ";
				}
 				if (i < comboItems.length-1) {
 					comboTxt += ROWMARK;
 					comboVal += ROWMARK;
 				}				
 			}
 		}
 		else {
 			comboTxt += " \t ";
 			comboVal += " ";			
 		}
 		var colName=sComboKey;
 		if (isCellCombo) {
 			sheetObj.CellComboItem(sRow,colName, {ComboText:comboTxt, ComboCode:comboVal} );
 			sheetObj.SetCellValue(sRow,colName,"",0);
 		}
 		else {
 			sheetObj.SetColProperty(colName, {ComboText:comboTxt, ComboCode:comboVal} );
 		}
 	}
 	
    /**
     * Select the first item
     */	
 	function setComboItem(comboObj,comboItems) {
 		var checkedItem=comboItems[0].split(FIELDMARK);
 		comboObj.SetSelectText(checkedItem[0]);
 	}
 	
 	/**
     * add data combo field 
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
			case 1: // Country combo Initialization
			   with (comboObj) { 
				   	SetMultiSelect(0);
					SetUseAutoComplete(0);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "30");
					SetColWidth(1, "200");
					SetFontColor("#606060");
					SetDropHeight(160);
					ValidChar(2);
					SetMaxLength(2);
			   }
			   break;
			case 2: // Yard combo Initialization 
				with (comboObj) { 		
					SetMultiSelect(0);
					SetUseAutoComplete(0);
					SetColAlign(0, "left");
					SetColWidth(0, "50");
					SetFontColor("#606060");
					SetDropHeight(160);
					ValidChar(2, 1);
					SetMaxLength(2);
				}
				break;
	     }
	}
	
	/*
	 *Region or State Search Field case is changed, Location Search Field and initializing functions that
	 */	
	function combo5_OnChange(comboObj, Index_Code, Text) {
		setComboParameters("", "combo5");
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
	
	function setCommonParameters(sheetObj,sComboAction) {
    	var formObj=document.form;
		ComSetObjValue(formObj.f_cmd, sComboAction);
		switch(sComboAction) {
			case SEARCH01 :
				break;
			case SEARCH02 :
				break;
			case SEARCH03:
				ComSetObjValue(formObj.cnt_cd, sheetObj.GetCellValue(sheetObj.GetSelectRow(), prefix+"cnt_cd"));
				break;
			case SEARCH04:
				ComSetObjValue(formObj.loc_cd, sheetObj.GetCellValue(sheetObj.GetSelectRow(), prefix+"loc_cd"));
				break;
			case SEARCH13:
				ComSetObjValue(formObj.rgn_cd, sheetObj.GetCellValue(sheetObj.GetSelectRow(), prefix+"rgn_cd"));
				break;
			case SEARCH17:
				ComSetObjValue(formObj.ste_cd, sheetObj.GetCellValue(sheetObj.GetSelectRow(), prefix+"rgn_cd"));
				break;
			case SEARCH21:
				ComSetObjValue(formObj.yd_cd, sheetObj.GetCellValue(sheetObj.GetSelectRow(), prefix+"yd_cd"));
				break;
		}
	}
	
	/*
	 * Searching fields to enter information of the screen is stored in a lookup field values??.
	 */			
	function setParameters(sAction) {
		var formObj=document.form;
		ComSetObjValue(formObj.cnt_cd, comboObjects[0].GetSelectText());		//Country
		ComSetObjValue(formObj.loc_cd, ComGetObjValue(formObj.location));		//Location		
		ComSetObjValue(formObj.f_cmd, sAction);									//Command
	}
	
	function initControl() {
	    axon_event.addListenerFormat('keypress', 'obj_keypress', form);    
	    axon_event.addListener('beforedeactivate', 'obj_deactivate', 'location');
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
	 * Location Search Field initialization
	 */		
	function clearLocation() {
		var formObj=document.form;
		ComSetObjValue(formObj.loc_cd, "");
		ComSetObjValue(formObj.location, "");
	}
	
	/*
	 * htmlControl event initializing
	 */	
	function initSearchControls() {
		// 조회결과 초기화 및 Sort 기능이 적용된 경우, 적용해제해 준다.
		sheetObjects[0].RemoveAll();	
		
		var formObj=document.form;
		isNoInitActive=false;	
		resetAll();
		// reset hidden form items
		formObj.f_cmd.value="";
		formObj.pagerows.value="";
		formObj.cnt_cd.value="";
		formObj.loc_cd.value="";
		formObj.yd_cd.value="";
		formObj.retry.value="";
		formObj.io_bnd_cd.value="";
		formObj.dem_det_tp_cd.value="";
	}
	
	/**
     *  handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
	       	 if(sAction == IBSEARCH) {
	       		 if(location.value != '' && location.value.length < 5) {
					ComShowCodeMessage('DMT00110');
					ComClearObject(location);
					return false;
	       		 }
	       	 }
	     	else if (sAction == MULTI) {
	     		with(sheetObj) {
	     			if (RowCount()== 0 || sheetObj.IsDataModified()== false) {
	     				ComShowCodeMessage("DMT00128");
	     				return false;
	     			}
	 				
	 				//with(formObj) 안에서 prefix 변수를 사용할 경우, formObj 안에 있는 객체로 인식해서 오류가 발생됨.
	 				//직접 변수명을 사용함
	     			for (var row=HeaderRows(); row <= LastRow(); row++) {
	     				if (GetRowStatus(row) == "I" || GetRowStatus(row) == "U") {
	     					if (GetCellValue(row, "sheet1_cnt_cd") == "") {
	     						ComShowCodeMessage("DMT00108", GetCellValue(row, "sheet1_seq"), "Country");
	 	    					return false;
	 	    				}
	     					if (GetCellValue(row, "sheet1_io_bnd_cd") == "") {
	     						ComShowCodeMessage("DMT00108", GetCellValue(row, "sheet1_seq"), "Bound");
	 	    					return false;
	 	    				}
	     					if (GetCellValue(row, "sheet1_xcld_sat_flg") == "") {
	     						ComShowCodeMessage("DMT00108", GetCellValue(row, "sheet1_seq"), "Saturday");
	 	    					return false;
	 	    				}
	     					if (GetCellValue(row, "sheet1_xcld_sun_flg") == "") {
	     						ComShowCodeMessage("DMT00108", GetCellValue(row, "sheet1_seq"), "Sunday");
	 	    					return false;
	 	    				}
	     					if (GetCellValue(row, "sheet1_xcld_hol_flg") == "") {
	     						ComShowCodeMessage("DMT00108", GetCellValue(row, "sheet1_seq"), "Holidays");
	 	    					return false;
	 	    				}
	     					if (GetCellValue(row, "sheet1_eff_dt") == "") {
	     						ComShowCodeMessage("DMT00108", GetCellValue(row, "sheet1_seq"), "Effective Date");
	 	    					return false;
	 	    				}
	     					if (GetCellValue(row, "sheet1_exp_dt") != "") {
	     						if (ComGetDaysBetween(ComTrim(GetCellValue(row, "sheet1_exp_dt")), ComTrim(GetCellValue(row, "sheet1_eff_dt"))) > 0) {
	 	    		    			ComShowCodeMessage("COM12133", "'Effective Date'", "'Expiration Date'", "earlier");
	 	    		    			return false;	    			
	 	    		    		}
	 	    				}
	     				}
	     			}

	     			var dupRow = checkColValueDup(sheetObj);
	     			
	     			if( dupRow > -1) {
// 						ComShowCodeMessage("DMT00138", dupRow, "");
 						alertDupMsg(sheetObj, dupRow, null);
	     				SetSelectRow(dupRow, 0);
	     				return false;
	     			}
	     	        /////////////////////////////////////////
	     	        var dupKey = "sheet1_cnt_cd|"+"sheet1_loc_cd|"+"sheet1_yd_cd|"+"sheet1_io_bnd_cd|"+"sheet1_dem_det_tp_cd";
	     	        
	     	        dupRow =  checkEffectiveDate(sheetObj, dupKey);
	     			
	     			if( dupRow > -1) {
// 						ComShowCodeMessage("DMT00138", dupRow, "");
 						alertDupMsg(sheetObj, dupRow, null);
	     				SetSelectRow(dupRow, 0);
	     				return false;
	     			}
	     			//////////////////////////////////////////
	     			dupRow = checkDelAvailable(sheetObj);
	     			
	     			if( dupRow > -1) {
 						ComShowCodeMessage("COM130302", "Seq. " + dupRow + " data for Effective Date");
	     				SetSelectRow(dupRow, 0);
	     				return false;
	     			}
	     			
	 				//if (!dupValidate(sheetObj)) return false;
	     		}
	     	}
        }
        return true;
    }
   	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////                              2016.01.25 S.W. Kim                             /////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    function checkLocation1(obj) {
        if(isAlpha()) {
            var formObj=document.form;
            if (ComTrim(ComGetObjValue(obj)).length == 5) {
                var locCd=ComTrim(ComGetObjValue(obj));
                if (locCd.length > 0) {
                    doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH10,LOCATION,obj);
                }
            }       
        }
    }

    function checkYard1(obj) {
        if(isAlpha()) {
            checkYard1_sub2(obj);
        }
    }
    function checkYard1_sub1(obj) {
        var formObj=document.form;
        if (ComTrim(ComGetObjValue(obj)).length == 5) {
            var yardCd1=ComTrim(ComGetObjValue(obj));
            if (yardCd1.length > 0) {
                doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH10,LOCATION,obj);
            }
        }
    }
    function checkYard1_sub2(obj) {
        var formObj=document.form;
        if (ComTrim(ComGetObjValue(obj)).length == 5) {
            var yardCd1=ComTrim(ComGetObjValue(obj));
            if (yardCd1.length > 0) {
                doActionIBCombo_new(sheetObjects[0],formObj,IBSEARCH,SEARCH14,YARD,obj);
            }
        }
    }

    function doActionIBCombo_new(sheetObj,formObj,sAction,sComboAction,sComboKey,sObj) {
        sheetObj.ShowDebugMsg(false);
        sheetObj.WaitImageVisible = false;
        var index_1=0;
        var index_2=0;
        var index_3=0;
        switch(sAction) {
           case IBSEARCH:     
                if (sheetObj.id == "sheet1") {
                	var comboDatas;
                    var comboItems;
                    switch(sComboAction) {
                    	case SEARCHLIST07:
                    		ComSetObjValue(formObj.f_cmd, SEARCHLIST07); 
                    		var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
                    		//TARIFF LIST
                    		comboItems=ComGetEtcData(sXml, COMMON_TARIFF_CD).split(ROWMARK);	
                    		addComboItem(comboObjects[0], comboItems);
                    		//Coverage Continent
                    		comboDatas=ComGetEtcData(sXml, CONTINENT);
                    		if (comboDatas != undefined) {
                                comboItems=comboDatas.split(ROWMARK);
                                comboObjects[1].SetSelectCode("-1");
                                comboObjects[1].RemoveAll();
                                addComboItem(comboObjects[1],comboItems);
                            }
                    		//Coverage Country 
                    		comboDatas=ComGetEtcData(sXml, COUNTRY);
                            if (comboDatas != undefined) {
                                comboItems=comboDatas.split(ROWMARK);
                                comboObjects[2].SetSelectCode("-1");
                                comboObjects[2].RemoveAll();
                                addComboItem(comboObjects[2],comboItems); //COUNTRY
                            }
                            //Coverage Region
                            comboDatas=ComGetEtcData(sXml, REGION);
                            if (comboDatas != undefined) {
                                comboItems=comboDatas.split(ROWMARK);
                                comboObjects[3].SetSelectCode("-1");
                                comboObjects[3].RemoveAll();
                                addComboItem(comboObjects[3],comboItems); //Region
                            }
                            //Coverage Continent
                    		comboDatas=ComGetEtcData(sXml, CONTINENT);
                    		if (comboDatas != undefined) {
                                comboItems=comboDatas.split(ROWMARK);
                                comboObjects[5].SetSelectCode("-1");
                                comboObjects[5].RemoveAll();
                                addComboItem(comboObjects[5],comboItems);
                            }
                    		//Coverage Country 
                    		comboDatas=ComGetEtcData(sXml, COUNTRY);
                            if (comboDatas != undefined) {
                                comboItems=comboDatas.split(ROWMARK);
                                comboObjects[6].SetSelectCode("-1");
                                comboObjects[6].RemoveAll();
                                addComboItem(comboObjects[6],comboItems); //COUNTRY
                            }
                            //Coverage Region
                            comboDatas=ComGetEtcData(sXml, REGION);
                            if (comboDatas != undefined) {
                                comboItems=comboDatas.split(ROWMARK);
                                comboObjects[7].SetSelectCode("-1");
                                comboObjects[7].RemoveAll();
                                addComboItem(comboObjects[7],comboItems); //Region
                            }
                    		break;
                        //1. TARIFF LIST
                        case SEARCHLIST:
                        	ComSetObjValue(formObj.f_cmd, SEARCHLIST); 
                        	setComboParameters(sComboAction, sObj);
                        	var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
                            comboItems=ComGetEtcData(sXml, sComboKey).split(ROWMARK);
                            addComboItem(sObj,comboItems);                      
                            break;                          
                        //2. CONTINENT LIST
                        case SEARCH08:
                        	ComSetObjValue(formObj.f_cmd, SEARCH08); 
                            setComboParameters(sComboAction, sObj);
                            var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
                            if(sObj.options.id == "combo2") {
                                index_1=1;
                            } else {
                                index_1=5;
                            }
                            comboDatas=ComGetEtcData(sXml, sComboKey);
                            if (comboDatas != undefined) {
                                comboItems=comboDatas.split(ROWMARK);
                                comboObjects[index_1].SetSelectCode("-1");
                                comboObjects[index_1].RemoveAll();
                                addComboItem(comboObjects[index_1],comboItems); //CONTINENT
                            }else{
                                ComShowCodeMessage("DMT06001");
                                clearObjectValue(sObj);
                            }
                            break;
                        //2. COUNTRY LIST
                        case SEARCH02:
                        	ComSetObjValue(formObj.f_cmd, SEARCH02);
                        	setComboParameters(sComboAction, sObj);
                        	var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
                            if(sObj.options.id == "combo3") {
                                index_1=2;
                            } else {
                                index_1=6;
                            }
                            comboDatas=ComGetEtcData(sXml, sComboKey);
                            if (comboDatas != undefined) {
                                comboItems=comboDatas.split(ROWMARK);
                                comboObjects[index_1].SetSelectCode("-1");
                                comboObjects[index_1].RemoveAll();
                                addComboItem(comboObjects[index_1],comboItems); //COUNTRY
                            }else{
                                ComShowCodeMessage("DMT06001");
                                clearObjectValue(sObj);
                            }
                            break;
                        //3. REGION LIST
                        case SEARCH01:
                        	ComSetObjValue(formObj.f_cmd, SEARCH01);
                        	setComboParameters(sComboAction, sObj);
                        	var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
                            if(sObj.options.id == "combo4" || sObj.options.id == "combo2") {
                                index_1=3;
                            } else {
                                index_1=7;
                            } 
                            comboDatas=ComGetEtcData(sXml, sComboKey);
                            if (comboDatas != undefined) {
                                comboItems=comboDatas.split(ROWMARK);
                                comboObjects[index_1].SetSelectCode("-1");
                                comboObjects[index_1].RemoveAll();
                                addComboItem(comboObjects[index_1],comboItems); //REGION
                            }else{
                                ComShowCodeMessage("DMT06001");
                                clearObjectValue(sObj);
                            }
                            break;
                        case SEARCH06:
                        	ComSetObjValue(formObj.f_cmd, SEARCH06);
                        	setComboParameters(sComboAction, sObj);
                        	var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));

                            var sObj_name = "";
                            if ( sObj.name == "cvrg_location" || sObj.name == "yd_cd1" || sObj.name == "org_dest_location"){
                            	sObj_name = sObj.name;
                            } else {
                            	sObj_name = sObj.options.id;
                            }
                            
                            if(sObj_name == "combo2" || sObj_name == "combo4" || sObj_name == "cvrg_location"
                                || sObj_name == "combo5" || sObj_name == "yd_cd1" ) {
                                index_1=2;
                            }else{
                                index_1=6;
                            }
                            comboDatas=ComGetEtcData(sXml, COUNTRY);
                            if (comboDatas != undefined) {
                                if(comboDatas != "") {
                                    comboItems=comboDatas.split(ROWMARK);
                                    comboObjects[index_1].SetSelectCode("-1");
                                    comboObjects[index_1].RemoveAll();
                                    addComboItem(comboObjects[index_1],comboItems); //Country
                                }else{
                                    ComShowCodeMessage("DMT06001");
                                    clearObjectValue(sObj);
                                }
                            }else{
                                ComShowCodeMessage("DMT06001");
                                clearObjectValue(sObj);
                            }
                            break;
                        case SEARCH12:
                        	ComSetObjValue(formObj.f_cmd, SEARCH12);
                        	setComboParameters(sComboAction, sObj);
                        	var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
                            if(sObj.options.id == "combo3") {
                                index_1=1;
                            } else {
                                index_1=5;
                            }
                            comboDatas=ComGetEtcData(sXml, CONTINENT);
                            if( comboDatas != undefined) {
                                comboItems=comboDatas.split(ROWMARK);
                                setComboItem(comboObjects[index_1],comboItems); //Continent
                            }else{
                                ComShowCodeMessage("DMT06001");
                                clearObjectValue(sObj);
                            }
                            break;
                        case SEARCH03:
                        	ComSetObjValue(formObj.f_cmd, SEARCH03);
                        	setComboParameters(sComboAction, sObj);
                        	var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
                        	
                            var sObj_name = "";
                            if ( sObj.name == "cvrg_location" || sObj.name == "yd_cd1" || sObj.name == "org_dest_location"){
                            	sObj_name = sObj.name;
                            } else {
                            	sObj_name = sObj.options.id;
                            }
                            
                            if(sObj_name == "combo3" || sObj_name == "combo4" || sObj_name == "combo5" 
                                || sObj_name == "cvrg_location" || sObj_name == "yd_cd1") {
                                index_1=2;
                                index_2=3;
                                clearLocation1();
                            } else {
                                index_1=6;
                                index_2=7;
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
                                comboObjects[index_2].RemoveAll();              //Region
                                addComboItem(comboObjects[index_2],comboItems);
                            }else {
                                ComShowCodeMessage("DMT06001");
                                clearObjectValue(sObj);
                            }
                            break;
                        case SEARCH17:
                        	ComSetObjValue(formObj.f_cmd, SEARCH17);
                        	setComboParameters(sComboAction, sObj);
                        	var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
                            if(sObj.options.id == "combo4") {
                                index_1=1;
                                index_2=2;    
                                index_3=3;
                                clearLocation1();
                            } else {
                                index_1=5;
                                index_2=6;
                                index_3=7;
                                clearLocation2();
                            }
                            comboDatas=ComGetEtcData(sXml, CONTINENT);
                            if (comboDatas != undefined) {
                                //Continent Setting
                                comboItems=comboDatas.split(ROWMARK);
                                setComboItem(comboObjects[index_1],comboItems);     //Continent
                                comboObjects[index_2].SetSelectCode("-1");
                                comboObjects[index_2].RemoveAll();
                                doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,sObj);//searchCountryListByContinent
                                //Country Setting
                                comboDatas=ComGetEtcData(sXml, COUNTRY);
                                if (comboDatas != undefined) {
                                    comboItems=comboDatas.split(ROWMARK);
                                    setComboItem(comboObjects[index_2],comboItems); //Country
                                    comboObjects[index_3].SetSelectCode("-1");
                                    comboObjects[index_3].RemoveAll();              //Region
                                    doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,COUNTRY,sObj);//searchRegionListByCountry
                                    comboDatas=ComGetEtcData(sXml, sComboKey);
                                    if (comboDatas != undefined) {
                                        comboItems=comboDatas.split(ROWMARK);
                                        setComboItem(comboObjects[index_3],comboItems); //Region
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
                        	ComSetObjValue(formObj.f_cmd, SEARCH13);
                        	setComboParameters(sComboAction, sObj);
                        	var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
                            if(sObj.options.id == "combo4") {
                                index_1=1;
                                index_2=2;   
                                index_3=3;
                                clearLocation1();
                            } else {
                                index_1=5;
                                index_2=6;
                                index_3=7;
                                clearLocation2();
                            }
                            comboDatas=ComGetEtcData(sXml, CONTINENT);
                            if (comboDatas != undefined) {
                                //Continent Setting
                                comboItems=comboDatas.split(ROWMARK);
                                setComboItem(comboObjects[index_1],comboItems);     //Continent
                                comboObjects[index_2].SetSelectCode("-1");
                                comboObjects[index_2].RemoveAll();
                                doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,sObj);//searchCountryListByContinent
                                //Country Setting
                                comboDatas=ComGetEtcData(sXml, COUNTRY);
                                if (comboDatas != undefined) {
                                    comboItems=comboDatas.split(ROWMARK);
                                    setComboItem(comboObjects[index_2],comboItems); //Country
                                    comboObjects[index_3].SetSelectCode("-1");
                                    comboObjects[index_3].RemoveAll();              //Region
                                    doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,COUNTRY,sObj);//searchRegionListByCountry
                                    comboDatas=ComGetEtcData(sXml, sComboKey);
                                    if (comboDatas != undefined) {
                                        comboItems=comboDatas.split(ROWMARK);
                                        setComboItem(comboObjects[index_3],comboItems); //Region
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
                        case SEARCH10:
                        	ComSetObjValue(formObj.f_cmd, SEARCH10);
                        	setComboParameters(sComboAction, sObj);
                        	var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
                            var location=ComGetObjValue(sObj);
                            if(sObj.name == "cvrg_location" || sObj.name == "yd_cd1") {
                                index_1=1;
                                index_2=2;    //Location 초기화
                                index_3=3;
                                clearLocation1();
                            } else {
                                index_1=5;
                                index_2=6;
                                index_3=7;
                                clearLocation2();
                            }
                            comboDatas=ComGetEtcData(sXml, CONTINENT);
                            if (comboDatas != undefined) {
                                comboItems=comboDatas.split(ROWMARK);
                                //Continent Setting
                                setComboItem(comboObjects[index_1],comboItems);     //Continent
                                comboObjects[index_2].SetSelectCode("-1");
                                comboObjects[index_2].RemoveAll();                  //Country
                                doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,sObj);//searchCountryListByContinent
                                //Country Setting
                                comboDatas=ComGetEtcData(sXml, COUNTRY);
                                if (comboDatas != undefined) {
                                    comboItems=comboDatas.split(ROWMARK);
                                    setComboItem(comboObjects[index_2],comboItems);
                                    comboObjects[index_3].SetSelectCode("-1");
                                    comboObjects[index_3].RemoveAll();              //Region
                                    doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,COUNTRY,sObj);//searchRegionListByCountry
                                    if(location.substring(0,2) == "CA" || location.substring(0,2) == "US") {
                                        comboDatas=ComGetEtcData(sXml, STATE);
                                    }else{
                                        comboDatas=ComGetEtcData(sXml, REGION);
                                    }
                                    if (comboDatas != undefined) {
                                        comboItems=comboDatas.split(ROWMARK);
                                        setComboItem(comboObjects[index_3],comboItems); //Region
                                        //location setting
                                        ComSetObjValue(sObj, location);
                                        if(sObj.name == "cvrg_location") {
                                            if (ComGetObjValue(formObj.combo1) == "DMIF" || ComGetObjValue(formObj.combo1) == "DMOF" 
                                                || ComGetObjValue(formObj.combo1) == "") {
                                                //yd_cd1 Setting
                                                ComSetObjValue(formObj.yd_cd1, ComGetObjValue(formObj.cvrg_location));
                                                isNoChangeActive=false;
                                                checkYard1_sub2(formObj.yd_cd1);
                                                ComSetFocus(formObj.yd_cd1);
                                            }
                                        }
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
                        case SEARCH14:
                        	ComSetObjValue(formObj.f_cmd, SEARCH14);
                        	setComboParameters(sComboAction, sObj);
                        	var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
                            var yd_cd1=ComGetObjValue(sObj);
                            index_1=1;
                            comboObjects[index_1].SetSelectCode("-1");
                            comboObjects[index_1].RemoveAll();
                            comboDatas=ComGetEtcData(sXml, YARD);
                            if (comboDatas == undefined ||comboDatas == "") {
                            	
                            }else{
                                comboItems=comboDatas.split(ROWMARK);
                                addComboItem1(comboObjects[index_1],comboItems);    
                                setComboItem(comboObjects[index_1],comboItems);
                            }
                            break;
                        case COMMAND03:
                        	ComSetObjValue(formObj.f_cmd, COMMAND03);
                        	setComboParameters(sComboAction, sObj);
                        	var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
                            index_1=1;
                            index_2=2;
                            index_3=3;
                            //Continent 조회
                            comboDatas=ComGetEtcData(sXml, CONTINENT);
                            if (comboDatas != undefined) {
                                //Continent Setting
                                comboItems=comboDatas.split(ROWMARK);
                                setComboItem(comboObjects[index_1],comboItems);
                                comboObjects[index_2].SetSelectCode("-1");
                                comboObjects[index_2].RemoveAll();
                                doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,sObj);//searchCountryListByContinent
                                //Country Setting
                                comboDatas=ComGetEtcData(sXml, COUNTRY);
                                if (comboDatas != undefined) {
                                    comboItems=comboDatas.split(ROWMARK);
                                    setComboItem(comboObjects[index_2],comboItems);
                                    comboObjects[index_3].SetSelectCode("-1");
                                    comboObjects[index_3].RemoveAll();
                                    doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,COUNTRY,sObj);//searchRegionListByCountry
                                    //Region/State Setting
                                    if(comboObjects[index_2].GetSelectText()== "CA" || comboObjects[index_2].GetSelectText()== "US" ) {
                                        comboDatas=ComGetEtcData(sXml, STATE);
                                    }else{
                                        comboDatas=ComGetEtcData(sXml, REGION);
                                    }
                                    if (comboDatas != undefined) {
                                        comboItems=comboDatas.split(ROWMARK);
                                        setComboItem(comboObjects[index_3],comboItems);
                                        //location setting
                                        ComSetObjValue(formObj.cvrg_location, ComGetObjValue(formObj.yd_cd1));
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
                    }
                };
                break;
        }
        sheetObj.SetWaitImageVisible(1);
    }

    function setComboParameters(sComboAction, sObj) {
        var formObj = document.form;
        var sObj_name = sObj.id;
        if(typeof sObj.id == "undefined") {
        	sObj_name = sObj;
        }
        switch(sObj_name) {
            case "combo5":
            case "yd_cd1":
                //Coverage ComboSetting
                ComSetObjValue(formObj.cnt_cd, combo1.GetSelectText());
                ComSetObjValue(formObj.loc_cd, ComGetObjValue(formObj.location));
                ComSetObjValue(formObj.yd_cd,  combo5.GetSelectCode());
                break; 
        }
    }
    
    function addComboItem1(comboObj, comboItems) {
        for (var i=0 ; i < comboItems.length ; i++) {
            var comboItem=comboItems[i].split(FIELDMARK);
            comboObj.InsertItem(i, comboItem[1], comboItem[0]);
        }           
    }
    
    function checkBound(obj) {
        var formObj = document.form;
        formObj.io_bnd_cd.value = obj.options[obj.selectedIndex].value;
    	
    }
     
    /**
     * CHECK RULE :
     * 1. CNT, LOC, YD, BND, DEM/DET_TP, EFF_DT 이 모두 동일하면 중복
     * 2. CNT, LOC, YD, EFF_DT 이 동일하고 어느 한 쪽 BND가 A이면 중복
     * 3. CNT, LOC, YD, EFF_DT 이 동일하고 BND가 동일할 때 어느 한 쪽 DEM/DET_TP가 A이면 중복
     * 4. 중복이면 해당 ROW INDEX를 RETURN
     * 5. 이 외에는 UNIQUE하기 때문에 -1을 RETURN
     * @param sheetObj
     * @returns dupRowIndex
     */
    function checkColValueDup(sheetObj) {
    	// 1. CNT, LOC, YD, BND, DEM/DET_TP, EFF_DT 이 모두 동일하면 중복
    	var row = sheetObj.ColValueDup("sheet1_cnt_cd|"+"sheet1_loc_cd|"+"sheet1_yd_cd|"+"sheet1_io_bnd_cd|"+"sheet1_dem_det_tp_cd|"+"sheet1_eff_dt", 0);
    	// 1.1. duplicated
    	if(row > -1) return row;
    	
    	// 2. find duplicated Row Indexes (Dup. Rule : CNT, LOC, YD, EFF_DT)
    	var rows = sheetObj.ColValueDupRows("sheet1_cnt_cd|"+"sheet1_loc_cd|"+"sheet1_yd_cd|"+"sheet1_eff_dt", false, true); // ColStr, IncludeDelRow, IncludeFirstRow, StartRow, EndRow, IncludeSumRow
    	// 2.1. be not duplicated
    	if(rows == "") return -1;

    	var splitRows = rows.split("|");
    	var firstRows = splitRows[0].split(",");
    	var secondRows = splitRows[1].split(",");
    	var currRow = secondRows[0]; // current checking secondary row index
    	
        for (idx=0; idx<firstRows.length; idx++) {
        	var firstIoBound = sheetObj.GetCellValue(firstRows[idx], "sheet1_io_bnd_cd");
        	var firstDemDetType = sheetObj.GetCellValue(firstRows[idx], "sheet1_dem_det_tp_cd");
        	// 2.2. check first row Bound ALL
//        	if (firstIoBound == "A") { // duplicated & Bound ALL exists
//        		return firstRows[idx];
//        	}
        	
        	var firstColValues = sheetObj.GetRangeText(firstRows[idx], 3, firstRows[idx], 5, "|", "^") + sheetObj.GetRangeText(firstRows[idx], 12, firstRows[idx], 12, "|", "^"); // 3 : sheet1_cnt_cd, 5 : sheet1_yd_cd, 12 : sheet1_eff_dt

        	for (idx2=0; idx2<secondRows.length; idx2++) {
        		currRow = secondRows[idx2];
        		var secondColValues = sheetObj.GetRangeText(secondRows[idx2], 3, secondRows[idx2], 5, "|", "^") + sheetObj.GetRangeText(secondRows[idx2], 12, secondRows[idx2], 12, "|", "^");
            	var secondIoBound = sheetObj.GetCellValue(secondRows[idx2], "sheet1_io_bnd_cd");
            	var secondDemDetType = sheetObj.GetCellValue(secondRows[idx2], "sheet1_dem_det_tp_cd");
            	// BOUND가 같고, DEM/DET이 같을 경우 DUP               - TYPE1
            	// BOUND가 한 쪽이 A이고, DEM/DET이 한 쪽이 A일 경우 DUP     - TYPE2
            	// BOUND가 한 쪽이 A이고, DEM/DET이 A가 아니면서 같을 경우 DUP - TYPE3
            	// BOUND가 A가 아니면서 같고, DEM/DET이 한 쪽이 A일 경우 DUP  - TYPE4
            	
            	// 2.3. check second row Bound ALL
            	// BOUND가 I/O이면서 다를 경우 NOT DUP
            	// DEM/DET가 M/T이면서 다를 경우 NOT DUP
            	if (firstColValues != secondColValues) { // NOT duplicated
            		continue;
            	} else if (firstColValues == secondColValues && firstIoBound != "A" && secondIoBound != "A" && firstIoBound != secondIoBound) { // NOT duplicated
            		continue;
            	} else if(firstColValues == secondColValues && firstDemDetType != "A" && secondDemDetType != "A" && firstDemDetType != secondDemDetType) { // NOT duplicated
            		continue;
            	} else {
            		return currRow;
            	}
            	// 2.4. check DEM/DET Type ALL
//            	if (firstColValues == secondColValues 
//            			&& firstIoBound == secondIoBound 
//            			&& (firstDemDetType == "A" || secondDemDetType == "A")) { // duplicated & Bound is equal & DEM/DET Type ALL exists
//            		return currRow;
//            	}
        	}
        }
        
    	// 3. all valid (not equal)
    	return -1;
    }
    
    function checkDelAvailable(sheetObj) {
    	var rowsTxt = sheetObj.FindCheckedRow("sheet1_del_chk1");
    	if(rowsTxt.length > 0) {
    		var curDate = (new Date()).toISOString().slice(0,10).replace(/-/g,""); // YYYYMMDD
        	var rowsArr = rowsTxt.split("|");
    		for (var i = 0; i < rowsArr.length; i++) {
    			if (sheetObj.GetCellValue(rowsArr[i], "sheet1_eff_dt") <= curDate) {
    				return rowsArr[i];
    			}
    		}
    	}
		return -1;
    }
    
    /**
     * EffectiveDate Duplicate Check
     * @param sheetObj
     * @param dupKey
     * @returns {Boolean}
     */
    function checkEffectiveDate(sheetObj, dupKey) {
  	    var dupRows = sheetObj.ColValueDupRows(dupKey, false, true); // ColStr, IncludeDelRow, IncludeFirstRow, StartRow, EndRow, IncludeSumRow
  	    var effectiveDateDupRow = -1;
  	    
  	    if(dupRows != "") {
  	        var dupKeyArray = dupKey.split("|"); //중복검사 컬럼
  	    	
  	        var dupRowsArray = dupRows.split("|");
  	        var dupRowsArray2 = dupRowsArray[0].split(","); //중복된 최초 기중행
  	        var dupRowsArray3 = dupRowsArray[1].split(","); //기준행으로 중복된 행

  	        var checkLen2 = dupRowsArray2.length;
  	        var checkLen3 = dupRowsArray3.length;

  	        var colValueJoin2;
  	        var colValueJoin3;

  	        // 중복된 최초 기준행별로 유효일자 검사
  	        if(dupRowsArray[0].length > 0) {
	  	        for(var idx = 0; idx < checkLen2; idx++) {
	  	        	// 중복된 최초 기준행의 중복검사 컬럼들 값을 합침
	  	            colValueJoin2 = "";
	  				for(var dup = 0; dup < dupKeyArray.length; dup++) {
	  					colValueJoin2 += sheetObj.GetCellValue(dupRowsArray2[idx], dupKeyArray[dup]);
	  				}
	  	        	// 기준행으로 중복된 행이 비교대상이됨
	  	  	        if(dupRowsArray[1].length > 0) {
		  				for(var idx2 = 0; idx2 < checkLen3; idx2++) {
		  					// 기준행으로 중복된 행의 중복검사 컬럼들 값을 합침
		  					colValueJoin3 = "";
		  					for(var dup = 0; dup < dupKeyArray.length; dup++) {
		  						colValueJoin3 += sheetObj.GetCellValue(dupRowsArray3[idx2], dupKeyArray[dup]);
		  					}
		  					// 중복행인 경우 유효일자 검사
		  					if(colValueJoin2 == colValueJoin3) {
		  	                    var checkedEffFmDt = sheetObj.GetCellValue(dupRowsArray2[idx], "sheet1_eff_dt");
		  	                    var checkedEffToDt = (sheetObj.GetCellValue(dupRowsArray2[idx], "sheet1_exp_dt") == "") ? "99991231" : sheetObj.GetCellValue(dupRowsArray2[idx], "sheet1_exp_dt");
		  	                    var sheetRowEffFmDt = sheetObj.GetCellValue(dupRowsArray3[idx2], "sheet1_eff_dt");
		  	                    var sheetRowEffToDt = (sheetObj.GetCellValue(dupRowsArray3[idx2], "sheet1_exp_dt") == "" ) ? "99991231" : sheetObj.GetCellValue(dupRowsArray3[idx2], "sheet1_exp_dt");

		  	                    if((sheetRowEffFmDt <= checkedEffFmDt && checkedEffFmDt <= sheetRowEffToDt) ||
		  	                 	   (sheetRowEffFmDt <= checkedEffToDt && checkedEffToDt <= sheetRowEffToDt) ||
		  	                 	   (checkedEffFmDt <= sheetRowEffFmDt && sheetRowEffFmDt <= checkedEffToDt) ||
		  	                 	   (checkedEffFmDt <= sheetRowEffToDt && sheetRowEffToDt <= checkedEffToDt)
		  	                    ) {
		  	                    	effectiveDateDupRow = dupRowsArray3[idx2];
		  	                    	break;
		  	                    }
		  					}
		  				}
	  	  	        }
	
	  		        if(effectiveDateDupRow > -1) {
	  		        	break;
	  		        }
	  	        }
	  	    }
  		}
  	    return effectiveDateDupRow;
    }
    
    function alertDupMsg(sheetObj, _row, _seq) {
		var row = _row;
		var seq = _seq;
		with(sheetObj) {
			if(row == null) {
				row = FindText(prefix + "seq", seq);
			} else {
				seq = GetCellValue(row, prefix + "seq");
			}
			
			var dupAlertMsg="\n\n";
			dupAlertMsg += "Country : [ " + GetCellValue(row, prefix + "cnt_cd")+ " ]";
			dupAlertMsg += "\n";
			dupAlertMsg += "Location : [ " + GetCellText(row, prefix + "loc_cd") + " ]";
			dupAlertMsg += "\n";
			dupAlertMsg += "Yard : [ " + GetCellText(row, prefix + "yd_cd") + " ]";
			dupAlertMsg += "\n";
			dupAlertMsg += "Bound : [ " + GetCellText(row, prefix + "io_bnd_cd") + " ]";
			dupAlertMsg += "\n";
			dupAlertMsg += "DEM/DET Type : [ " + GetCellText(row, prefix + "dem_det_tp_cd") + " ]";
			dupAlertMsg += "\n";
			dupAlertMsg += "Effective From : [ " + GetCellText(row, prefix + "eff_dt") + " ]";
			ComShowCodeMessage("DMT00138", seq, dupAlertMsg);
	 	}
    }