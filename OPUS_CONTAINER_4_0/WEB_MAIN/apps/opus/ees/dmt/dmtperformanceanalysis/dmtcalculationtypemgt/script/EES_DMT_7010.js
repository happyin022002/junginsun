/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_7010.js
*@FileTitle  : Calculation Type Entry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
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
 				case "btn_DownExcel":
//parameter changed[check again]CLT
 					if(sheetObject1.RowCount() < 1){//no data
 						ComShowCodeMessage("COM132501");
 					}else{
 						sheetObject1.Down2Excel({ HiddenColumn:-1});
 					}
 					break;
 				case "t1btng_rowadd":
 					  ADDROW = true;
 					  doActionIBCombo(sheetObject1, document.form, IBSEARCH, SEARCH01);
 					   sheetObject1.DataInsert(-1);
 					   ADDROW = false;
					break;
				case "t1btng_save":
					doActionSave();
					break;
				case "t1btng_delete":
					sheetObject1.SetRowStatus(sheetObject1.GetSelectRow(),'D');
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
		Region.innerHTML = "Region";	//Region Caption
		ComSetObjValue(formObj.cnt_cd, 			"");
		ComSetObjValue(formObj.rgn_cd, 			"");
		ComSetObjValue(formObj.ste_cd, 			"");
		ComSetObjValue(formObj.loc_cd, 			"");
		ComSetObjValue(formObj.location, 		"");    	
    	ComSetObjValue(formObj.retry, 	 		"");
    	ComSetObjValue(formObj.io_bnd_cd, 		"");
    	ComSetObjValue(formObj.dmdt_calc_tp_cd, "");
    	ComSetObjValue(formObj.result, 			"");
    }
    
    function deleteRow() {
	    with (sheetObjects[0]) {
	        var sRowStr=FindCheckedRow(prefix+"del_chk");
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
		//sheetObj.WaitImageVisible = false;
		// Country
		doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH02);
		// Region
		doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH01);
        doActionIBSheet(sheetObj, formObj, IBSEARCH);
        //comboObjects[0].focus();
	    //sheetObj.WaitImageVisible = true; 
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
        		    var HeadTitle=" |Seq.|Country|Region|State|Location|Bound|Calculation Type|Effective Date|Expiration Date";
        		    var headCount=ComCountHeadTitle(HeadTitle);

        		    SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

        		    var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
        		    var headers = [ { Text:HeadTitle, Align:"Center"} ];
        		    InitHeaders(headers, info);

        		    var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
        		                 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"seq" },
        		                 {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cnt_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        		                 {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"rgn_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        		                 {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ste_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
//        		                 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ste_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
        		                 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"loc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
        		                 {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"io_bnd_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        		                 {Type:"Combo",     Hidden:0, Width:130,  Align:"Center",  ColMerge:0,   SaveName:prefix+"dmdt_calc_tp_cd", KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        		                 {Type:"Date",      Hidden:0, Width:130,  Align:"Center",  ColMerge:0,   SaveName:prefix+"eff_dt",          KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        		                 {Type:"Date",      Hidden:0, Width:130,  Align:"Center",  ColMerge:0,   SaveName:prefix+"exp_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
        		       
        		    InitColumns(cols);

        		    SetEditable(1);
        		    SetCountPosition(0);

        	        SetSheetHeight(365);
        			SetColProperty(prefix+"io_bnd_cd", {ComboText:"|I|O", ComboCode:"|I|O"} );
        			SetColProperty(prefix+"dmdt_calc_tp_cd", {ComboText:"|Dual|Combined", ComboCode:"|D|C"} );
        			
        			//조회 후 매치된 데이터가 없으면 자동적으로 나오지 않지만 만약 매치된 데이터가 없어도 화면에 보이도록 처리함.
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
				
				// 조회결과 초기화 및 Sort 기능이 적용된 경우, 적용해제해 준다.
				sheetObj.RemoveAll();
				  sheetObj.SetColProperty(prefix+"rgn_cd", {ComboText:" ", ComboCode:" "} );
				
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

				var sXml = sheetObj.GetSearchData("EES_DMT_7010GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix) );
				sheetObj.LoadSearchData(sXml, {Sync:1});
			break;
			
			case IBSEARCH_CHECK_DUP:
				ComSetObjValue(formObj.f_cmd, SEARCH01);
				ComOpenWait(true);
				sheetObjects[0].SetWaitImageVisible(0);
//parameter changed[check again]CLT
				var sXml=sheetObjects[0].GetSearchData("EES_DMT_7010GS.do", FormQueryString(formObj));
				ComOpenWait(false);
				var result=ComGetEtcData(sXml, "RESULT");
				ComSetObjValue(formObj.result, result);
			break;
			
            case MULTI:
				ComSetObjValue(formObj.f_cmd, MULTI);
				var sParam="";
				var sParam1=sheetObjects[0].GetSaveString();
				if (sheetObj.IsDataModified()== true) {
					sParam=sParam1 + "&";
				}
				sParam += "&" + FormQueryString(formObj);				
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
//parameter changed[check again]CLT
				var sXml=sheetObj.GetSaveData("EES_DMT_7010GS.do", sParam);
				sheetObj.LoadSaveData(sXml, {Sync:1});
				ComOpenWait(false);
				
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
//parameter changed[check again]CLT
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
// 							if (sheetObj.locCd.GetCellValue() == "CA" || sheetObj.locCd.GetCellValue() == "US") {
 								Region.innerHTML="State";
// 								State.innerHTML="State";
 								comboDatas=ComGetEtcData(sXml, STATE);
 							} else {
 								Region.innerHTML="Region";
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
//parameter changed[check again]CLT
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
					SetDropHeight(160);
					ValidChar(2);
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
					SetDropHeight(160);
					ValidChar(2);
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
		//Country 가 Empty 라면 하위필드조회는 하지 않는다.				
		if (cntCd.length == 0) return;
		//Country 가 CA or US 이라면 Region 의 네임을 State 로 그 이외에는 Region 으로 변경한다.
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
		doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01);
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
	     	else if (sAction == IBSAVE) {
	     		with(sheetObj) {
	     			if (RowCount()== 0 || sheetObj.IsDataModified()== false) {
	     				ComShowCodeMessage("DMT00128");
	     				return false;
	     			}
	 				if (!dupValidate(sheetObj)) return false;
	 				
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
	     					if (GetCellValue(row, "sheet1_dmdt_calc_tp_cd") == "") {
	     						ComShowCodeMessage("DMT00108", GetCellValue(row, "sheet1_seq"), "Calculation Type");
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
	     		}
	     	}
        }
        return true;
    }
    
   	function dupValidate(sheetObj) {
	   	with(sheetObj) {
	   		for (var row=HeaderRows(); row <= LastRow(); row++) {
	   			if (GetRowStatus(row) == "I") {
	   				if (!dupValidateWithDB(row)) return false;
	   			}
	   		}
	   	} //end with
	   	return true;
   	}
	
   	function dupValidateWithDB(row) {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		with(sheetObj) {
		ComSetObjValue(formObj.cnt_cd, GetCellValue(row, prefix + "cnt_cd"));
		ComSetObjValue(formObj.rgn_cd, GetCellValue(row, prefix + "rgn_cd"));
		ComSetObjValue(formObj.ste_cd, GetCellValue(row, prefix + "ste_cd"));
		ComSetObjValue(formObj.loc_cd, GetCellValue(row, prefix + "loc_cd"));
		ComSetObjValue(formObj.io_bnd_cd, GetCellValue(row, prefix + "io_bnd_cd"));
		ComSetObjValue(formObj.dmdt_calc_tp_cd, GetCellValue(row, prefix + "dmdt_calc_tp_cd"));
			 doActionIBSheet(sheetObj,formObj,IBSEARCH_CHECK_DUP);
			 if (ComGetObjValue(formObj.result) == "Y") {
				var dupAlertMsg="\n\n";
				dupAlertMsg += "Country : [ " + GetCellValue(row, prefix + "cnt_cd")+ " ]";
				dupAlertMsg += "\n";
				dupAlertMsg += "Region : [ " + GetCellText(row, prefix + "rgn_cd") + " ]";
				dupAlertMsg += "\n";
				dupAlertMsg += "State : [ " + GetCellText(row, prefix + "ste_cd") + " ]";
				dupAlertMsg += "\n";				
				dupAlertMsg += "Location : [ " + GetCellText(row, prefix + "loc_cd") + " ]";
				dupAlertMsg += "\n";				
				dupAlertMsg += "Bound : [ " + GetCellText(row, prefix + "io_bnd_cd") + " ]";
				dupAlertMsg += "\n";				
				dupAlertMsg += "Calculation Type : [ " + GetCellText(row, prefix + "dmdt_calc_tp_cd") + " ]";
				ComShowCodeMessage("DMT00138", GetCellValue(row, "Seq"), dupAlertMsg);
				return false;
			 	}
		 } 
		 return true;
	 }
