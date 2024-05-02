/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0154.jsp
*@FileTitle  :  Disposal Tariff Input by Region
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   	/* developer job	*/
   	/* Sheet Select Back Color */
	var MNR_SELECT_BACK_COLOR=10092543;
	var cntrTpSz=new Array();
	var chssTpSz=new Array();
	var gsetTpSz=new Array();
	// common global variables
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick() {
        var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObj=document.form;
     	try {
     		var obj = event.target || event.srcElement;
     			if ($(obj).prop('disabled')) {
     		   return;
     	   }
 			var srcName=ComGetEvent("name");
 			switch(srcName) {
 				case "btn_Retrieve":
 					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
 					break;
 				case "btn_New":
					ComResetAll();
					setDynamicEqTpszCombo(sheetObjects[0], "U");
					ComBtnDisable("btn_RowAdd");
					ComBtnDisable("btn_Delete");
					ComSetFocus(formObj.p_trf_eff_yr);
 					break;
 				case "btn_Save":
 					//doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
 					doActionIBSheet(sheetObjects[0], formObj, IBBATCH);
 					break;
 				case "btn_RowAdd":
 					if ( ComIsBtnEnable(srcName) ) {
 						doActionIBSheet(sheetObjects[0], formObj, IBINSERT);
 					} else {
 						ComSetFocus(formObj.p_trf_eff_yr);
 					}
 					break;
 				case "btn_Delete":
 					if ( ComIsBtnEnable(srcName) ) {
 						ComRowHideDelete(sheetObject1, "del_chk");
 					} else {
 						ComSetFocus(formObj.p_trf_eff_yr);
 					}
 					break;
 				case "btns_calendar1":
 					var cal=new ComCalendar();
					cal.setDisplayType('year');
					cal.select(formObj.p_trf_eff_yr, 'yyyy');
             	 	break;
				case "btn_LoadExcel":
					doActionIBSheet(sheetObject1,formObj,IBLOADEXCEL);
				break;
             	case "btn_DownExcel":
             		if(sheetObject1.RowCount() < 1){//no data
             			ComShowCodeMessage("COM132501");
             			}else{
             				sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
             			}
					break;
 			} // end switch
     	} catch(e) {
     		if(e == "[object Error]") {
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
    function setSheetObject(sheet_obj) {
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
    	var formObj=document.form;
		for(i=0; i < sheetObjects.length; i++) {
	        //
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i], i+1);
	        //
			ComEndConfigSheet(sheetObjects[i]);
		}
		var formObj=document.form;
     	/* IBMulti Combo Item Setting */
    	doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
    	/* Axon Control Setting*/
    	initControl();
    	ComBtnDisable("btn_RowAdd");
		ComBtnDisable("btn_Delete");
    	/* initial Focus Setting */
    	ComSetFocus(formObj.p_trf_eff_yr);
    }
    // Axon handling event
  	// 1. event catch
  	function initControl() {
  		var formObj=document.form;
  		axon_event.addListenerFormat('blur',		'obj_blur',		formObj); 
		axon_event.addListenerFormat('focus',		'obj_focus',	formObj); 
		axon_event.addListenerForm('change',   		'obj_change',  	formObj); 
		axon_event.addListenerForm('click',			'obj_click',	formObj); 
  	}
	//setting event duplicate
	var preEventType=null;
  	// 2. handling event -- Start
  	/**
	 * checking on HTML Control's onblur event.
	 **/
	function obj_blur() {
		var obj=ComGetEvent();
		if(preEventType == event.type) {
			preEventType=null;
			return;
		}
	    switch(ComGetEvent("name")) {
	    	case "p_trf_eff_yr":
  				//checking validation Object(length,format,max,min 등등)
	            ComChkObjValid(obj, true, false, false);
	    		break;
	        default: //do nothing
	        	ComChkObjValid(obj);
	        	break;
	    }
	}
	/**
	 * checking on HTML Control's focus event.
	 */
	function obj_focus() {
		var obj=ComGetEvent();
	    if(obj.readOnly) {
	    	ComSetNextFocus(obj);
	    } else {
	    	//clearing mask separator
		    ComClearSeparator(obj);
	    }
	}
	/**
	 * handling Change Event
	 */
	function obj_change() {
		var obj=ComGetEvent();
		if(obj.name == "p_eq_knd_cd") {
			setDynamicEqTpszCombo(sheetObjects[0], obj.value);
		}
	}
	/**
	 * handling Key-Press Event
	 */
	
   	/**
     * handling Click Event
     */
   	function obj_click() {
   		var obj=ComGetEvent();
  		var vKeyCode=event.keyCode;
  		var formObj=document.form;
  		switch(ComGetEvent("name")) {
  			case "p_cre_usr_id":
  				if(obj.value != "") {
  					// call user's popup
					ComUserPopup(obj.value);
  				}
  				break;
  		}
   	}
	function resizeSheet( sheetObj ){
	    ComResizeSheet( sheetObj );
	}
  	//2. handling event -- End
  	/**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetid=sheetObj.id;
		switch(sheetid) {
			case "sheet1":
				  with(sheetObj){
				   var HeadTitle1="|Sel.|Seq.|Year|Quarter||EQ Type|Location|TP/SZ|Currency|Tariff Amount|Remark||";
				   var headCount=ComCountHeadTitle(HeadTitle1);
				   (headCount, 0, 0, true);
	
				   SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
				   var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
				   var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				   InitHeaders(headers, info);
	
				   var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"DummyCheck", Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"del_chk" },
				             {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq_no" },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"trf_eff_yr",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"trf_eff_qtr_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, ComboText:"1/4QTA|2/4QTA|3/4QTA|4/4QTA", ComboCode:"1|2|3|4"},
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"mnr_disp_trf_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Combo",     Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"eq_knd_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, ComboText:"Container|Chassis|M.G.Set", ComboCode:"U|Z|G"},
				             {Type:"PopupEdit", Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"loc_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
				             {Type:"Combo",     Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"PopupEdit", Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"curr_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3, AcceptKeys:"E", InputCaseSensitive:1 },
				             {Type:"Float",     Hidden:0,  Width:150,  Align:"Right",   ColMerge:0,   SaveName:"mnr_disp_trf_amt",  KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
				             {Type:"Text",      Hidden:1, Width:350,  Align:"Left",    ColMerge:0,   SaveName:"mnr_trf_rmk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000 },
				             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"complex_pk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"last_chk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				    
				   InitColumns(cols);
//				   SetSheetHeight(420);
				   SetColProperty(0 ,"loc_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
				   resizeSheet( sheetObj );
			   }
				break;
		}
	}
	/**
	 * handling process for sheet
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @param CondParam
	 * @param PageNo
	 */
    function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
		switch(sAction) {
			case IBCREATE:
				//Equipment Type/Size Grid Combo Item Setting
				initDynamicEqTpszCd(sheetObj);
				setDynamicEqTpszCombo(sheetObj, formObj.p_eq_knd_cd.value);
				break;
			case IBSEARCH:			//retrieving
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet1") {
						formObj.f_cmd.value=SEARCH;
						//sheetObj.SetWaitImageVisible(0);
						sheetObj.WaitImageVisible=false;
						ComOpenWait(true);
						sheetObj.DoSearch("EES_MNR_0154GS.do",FormQueryString(formObj) );
						ComOpenWait(false);
						sheetObj.SetWaitImageVisible(1);
					}
				}
				break;
			case IBINSERT:			// adding
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet1") {
						var Row=sheetObj.DataInsert(-1);
						sheetObj.SetCellValue(Row,"trf_eff_yr",ComGetObjValue(formObj.p_trf_eff_yr),0);
						sheetObj.SetCellValue(Row,"trf_eff_qtr_no",ComGetObjValue(formObj.p_trf_eff_qtr_no),0);
						sheetObj.SetCellValue(Row,"eq_knd_cd",ComGetObjValue(formObj.p_eq_knd_cd),0);
						sheetObj.SelectCell(Row,"eq_tpsz_cd");
					}
				}
				break;
			case IBLOADEXCEL://EXCEL UPLOAD
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true, "mainTable");
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet1") {
						sheetObj.LoadExcel({ Mode:"HeaderMatch", Append:true});
					}
				}
				ComOpenWait(false, "mainTable");
				sheetObj.SetWaitImageVisible(1);
				break;
			case IBSAVE:			// saving
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true, "mainTable");
				if(sheetObj.IsDataModified()== false) {
					ComShowCodeMessage("COM130104");
				} else {
					var saveXml=sheetObj.GetSaveString(false, true);
					if(saveXml != "") {
						if(checkSaveValidation(sheetObj)) {
							if(validateForm(sheetObj, formObj, sAction)) {
								formObj.f_cmd.value=MULTI;
								sheetObj.DoSave("EES_MNR_0154GS.do", FormQueryString(formObj));
							}
						}
					}
				}
				ComOpenWait(false, "mainTable");
				sheetObj.SetWaitImageVisible(1);
				break;
			case IBBATCH:      // saving-BackEndJob
				if(sheetObj.IsDataModified()== false) {
					ComShowCodeMessage("COM130104");
				} else {
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					var saveXml=sheetObj.GetSaveString(false, true);
					if(saveXml != "") {
						if(checkSaveValidation(sheetObj)) {
							if(validateForm(sheetObj, formObj, sAction)) {
								var sParam="f_cmd=" + COMMAND01 +"&"+ saveXml;
								var sXml=sheetObj.GetSaveData("EES_MNR_0154GS.do", sParam);
								var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey");
								if (backendJobKey.length > 0) {
									ComSetObjValue(formObj.backendjob_key, backendJobKey);
									sheetObj.SetWaitTimeOut(10000);
									timer1=setInterval(getBackEndJobStatus, 3000);
								}
							} else {
								ComOpenWait(false);
								sheetObj.SetWaitImageVisible(1);
							}
						} else {
							ComOpenWait(false);
							sheetObj.SetWaitImageVisible(1);
						}
					} else {
						ComOpenWait(false);
						sheetObj.SetWaitImageVisible(1);
					}
				}
				break;
		}
    }
	/**
	 * Sheet Onhandling Change Event.<br>
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
	 */
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var formObj=document.form;
		with(sheetObj) {
			var sName=ColSaveName(Col);
			switch(sName) {
				case "eq_knd_cd":
					setDynamicEqTpszCombo(sheetObj, Value, Row);
					break;
				case "loc_cd":		// Grid LOC Code Check
					if(GetCellValue(Row,Col) != "") {
						var param="f_cmd="+SEARCH+"&loc_cd="+GetCellValue(Row,Col)
 								  + "&loc_nm=&un_loc_ind_cd=&cnt_cd=&loc_eq_ofc=&select=&rcc_cd=&lcc_cd=&loc_state=";
 						//sheetObj.SetWaitImageVisible(0);
						sheetObj.WaitImageVisible=false;
 						var sXml=sheetObj.GetSearchData("COM_ENS_051GS.do", param);
						sheetObj.SetWaitImageVisible(1);
						if ( ComGetTotalRows(sXml) != 1 ) {
							ComShowCodeMessage("MNR00117");
 							SetCellValue(Row,Col,"",0);
 							SelectCell(Row,Col,1);
 							return false;
						}
					}
					break;
				case "curr_cd":		// Grid Currency Code Check
					if(GetCellValue(Row,Col) != "") {
						var param="f_cmd="+SEARCH+"&curr_cd="+GetCellValue(Row,Col);
 						//sheetObj.SetWaitImageVisible(0);
						sheetObj.WaitImageVisible=false;
 						var sXml=sheetObj.GetSearchData("COM_ENS_N13GS.do", param);
						sheetObj.SetWaitImageVisible(1);
						if ( ComGetTotalRows(sXml) != 1 ) {
							SelectCell(Row,Col);
							ComShowCodeMessage("MNR00118");
 							SetCellValue(Row,Col,"",0);
 							return false;
						}
					}
					break;
			}
 		}
 		return true;
 	}
 	/**
 	 * Sheet OnPopuphandling Click Event.<br>
 	 * @param sheetObj
 	 * @param Row
 	 * @param Col
 	 */
    function sheet1_OnPopupClick(sheetObj,Row,Col) {
 		with(sheetObj) {
			var sName=ColSaveName(Col);
			switch(sName) {
				case "loc_cd":	// Location Pop-up
					openPopup("1", Row, Col);
					break;
				case "curr_cd":	//Currency Pop-up
					openPopup("2", Row, Col);
					break;
			}
 		}
    }
	/**
	 * checking validation before saving.
	 */
    function checkSaveValidation(sheetObj) {
		with(sheetObj) {
			for(var i=HeaderRows(); i <= LastRow(); i++) {
				if(GetRowStatus(i) == "I" && GetCellValue(i, "last_chk") != "OK") {
					for(var j=0; j <= LastCol(); j++) {
						var saveName=ColSaveName(j);
						if(/loc_cd|curr_cd/.test(saveName)) {
							var index=FindText(j, GetCellText(i, j));
							if(index == -1 || index == i) {
								if(!sheet1_OnChange(sheetObj, i, j, GetCellValue(i, j))) {
									SetCellValue(i, "last_chk","Fail",0);
									return false;
								} else if(saveName == "curr_cd") {
									SetCellValue(i, "last_chk","OK",0);
								} else {
									SetCellValue(i, "last_chk","Hold",0);
								}
							} else {
								if(saveName == "curr_cd") {
									SetCellValue(i, "last_chk","OK",0);
								} else {
									SetCellValue(i, "last_chk","Hold",0);
								}
							}
						}
					}
				}
				if(GetRowStatus(i) != "R") {
					SetCellValue(i, "complex_pk",GetCellValue(i, "trf_eff_yr") + GetCellValue(i, "trf_eff_qtr_no")+ GetCellValue(i, "eq_knd_cd")  + GetCellValue(i, "loc_cd")+ GetCellValue(i, "eq_tpsz_cd"));
				}
			}
			if(sheetObj.IsDataModified()== false) {
				ComShowCodeMessage("COM130104");
				return false;
			}
		}
		return true;
    }
    /**
     * event after saving
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	if(!/Error/.test(ErrMsg)) {
    		ComShowCodeMessage("MNR00023");
    		doActionIBSheet(sheetObj,document.form,IBSEARCH);
    	}
    }
    /**
     * event after retrieving
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	ComBtnEnable("btn_RowAdd");
		ComBtnEnable("btn_Delete");
    }
    /**
	 * event after loading excel
	 * @param sheetObj
	 */
	function sheet1_OnLoadExcel(sheetObj, result, code, msg){
		if(isExceedMaxRow(msg))return;
		
		var formObj=document.form;
    	with(sheetObj) {
    		var vTrfEffYr=ComGetObjValue(formObj.p_trf_eff_yr);
    		var vTrfEffQtr=ComGetObjValue(formObj.p_trf_eff_qtr_no);
    		var vEqKndCd=ComGetObjValue(formObj.p_eq_knd_cd);
    		for(var i=HeaderRows(); i <= RowCount(); i++) {
    			if(GetRowStatus(i) == "I") {
					SetCellValue(i,"trf_eff_yr",vTrfEffYr,0);
					SetCellValue(i,"trf_eff_qtr_no",vTrfEffQtr,0);
					SetCellValue(i,"eq_knd_cd",vEqKndCd,0);
    			}
    		}
    	}
	}
    /**
     * Pop-up Open <br>
     * @param type 1:Location Code, 2:Currency Code
     * @param Row Row index of IBSheet
     * @param Col Col index of IBSheet
     */
    function openPopup(type, Row, Col) {
    	if ( type == "1" ) {
    		ComOpenPopup('/opuscntr/COM_ENS_051.do', 700, 460, 'setPopData_Location', '1,0,1,1,0,0,0,0', true, false, Row, Col, 0);
    	} else if ( type == "2" ) {
			ComOpenPopup('/opuscntr/COM_ENS_N13.do', 700, 450, 'setPopData_Currency', '1,0,1', true, false, Row, Col, 0);
    	}
    	return;
    }
  	/**
	 * Location Pop-up Return Value <br>
	 * @param {arry} Return value array of returnedValues Pop-up
	 * @param Row Row index of IBSheet
	 * @param Col Col index of IBSheet
	 * @param Array index of IBSheet
	 */
	function setPopData_Location(aryPopupData, Row, Col, sheetIdx) {
		if(aryPopupData.length > 0) {
			with(sheetObjects[sheetIdx]) {
				var sName=ColSaveName(Col);
				switch(sName) {
					case "loc_cd":
						SetCellValue(Row, sName,aryPopupData[0][3],0);//LOC
						break;
					default :	//do nothing
				}
			}
		}
	}
	/**
	 * Currency Pop-up Return Value <br>
	 * @param {arry} Return value array of returnedValues Pop-up
	 * @param Row Row index of IBSheet
	 * @param Col Col index of IBSheet
	 * @param Array index of IBSheet
	 */
	function setPopData_Currency(aryPopupData, Row, Col, sheetIdx) {
		if(aryPopupData.length > 0) {
			with(sheetObjects[sheetIdx]) {
				var sName=ColSaveName(Col);
				switch(sName) {
					case "curr_cd":
						SetCellValue(Row, sName,aryPopupData[0][2],0);//Currency
						break;
					default :	//do nothing
				}
			}
		}
	}
	/**
	 * registering EQ_TYPE as list.
	 */
	function initDynamicEqTpszCd(sheetObj) {
		var arrXml=MnrComSearchGrid(sheetObj,"type_size_search_ind","");
		if(arrXml != null) {
			for(var i=0; i < arrXml.length; i++) {
				if(i == 0){//U
					cntrTpSz=MnrXmlToOneDimArray(arrXml[i], "cd_id");
				} else if(i == 1){//Z
					chssTpSz=MnrXmlToOneDimArray(arrXml[i], "cd_id");
				} else if(i == 2){//G
					gsetTpSz=MnrXmlToOneDimArray(arrXml[i], "cd_id");
				}
			}
		}
	}
	/**
	 * Equipment Type/Size Grid Combo Item Setting
	 */
	function setDynamicEqTpszCombo(sheetObj, eqKndCd, rowIdx) {
		var eqTpSzAry=new Array();
		if(eqKndCd == "U") {
			eqTpSzAry=cntrTpSz;
		} else if(eqKndCd == "Z") {
			eqTpSzAry=chssTpSz;
		} else {//eqKndCd is 'G'
			eqTpSzAry=gsetTpSz;
		}
		if(eqTpSzAry.length > 0) {
			var eqTpSzStr=eqTpSzAry.toString().replace(/,/g, "|");
			if(rowIdx) {
				sheetObj.CellComboItem(rowIdx,"eq_tpsz_cd", {ComboText:eqTpSzStr, ComboCode:eqTpSzStr} );
			} else {
				sheetObj.SetColProperty(0,"eq_tpsz_cd", {ComboText:eqTpSzStr, ComboCode:eqTpSzStr} );
			}
		}
	}
    /**
	 * handling process for input validation
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 */
	function validateForm(sheetObj, formObj, sAction) {
    	with(formObj) {
    		switch(sAction) {
    			case IBSEARCH:      //retrieving
    			case IBINSERT:		//adding
    			case IBLOADEXCEL:	//uploading
					if(formObj.p_trf_eff_yr.value == "") {
						ComShowCodeMessage("MNR00172", "Effective Year");
						ComSetFocus(formObj.p_trf_eff_yr);
						return false;
						break;
					}
    				return ComChkValid(formObj, false);
    				break;
				default :	//do nothing
    		}
    	}
	    with(sheetObj) {
    		switch(sAction) {
	    		case IBSAVE:		// saving
	    		case IBBATCH:		// saving-BackEndJob
	    			//SpaceDupCheck = false;
					//var dupRow = ColValueDup("trf_eff_yr|trf_eff_qtr_no|eq_knd_cd|loc_cd|eq_tpsz_cd", false);
					var dupRow=ColValueDup("complex_pk", false);
					if(dupRow != -1) {
						ComShowCodeMessage("MNR00006", "Effective Quarter, EQ Type, TP/SZ, Location");
						SelectCell(dupRow, 0);
						ValidateFail(true);
						return false;
					}
	    			return true;
	    			break;
	    		default : 	//do nothing
    		}
    	}
        return true;
	}
	/**
	 * checking BackEndJob until Status='3'.
	 */
	function getBackEndJobStatus() {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		formObj.f_cmd.value=COMMAND02;
		var sXml=sheetObj.GetSearchData("EES_MNR_0154GS.do", FormQueryString(formObj));
		var jobState=ComGetEtcData(sXml, "jb_sts_flg");
		if (jobState == "3") {
			getBackEndJobLoadFile();
			clearInterval(timer1);
		} else if (jobState == "4") {
			ComShowCodeMessage("MNR00344");
			ComOpenWait(false);
			sheetObj.SetWaitImageVisible(1);
			clearInterval(timer1);
		} else if (jobState == "5") {
			ComShowCodeMessage("MNR00345");
			clearInterval(timer1);
		}
	}
	/**
	 * downloading excel when BackEndJob is completed
	 */
	function getBackEndJobLoadFile() {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		ComShowCodeMessage("MNR00023");
    	formObj.f_cmd.value=SEARCH;
    	sheetObj.DoSearch("EES_MNR_0154GS.do",FormQueryString(formObj) );
		ComOpenWait(false);
		sheetObj.SetWaitImageVisible(1);
	}
  	/**
	 * Form Element Clear .<br>
	 * @param fieldName
	 * @deprecated
	 */
	function clearForm(fieldName) {
		var formObj=document.form;
		switch(fieldName) {
			default :	//do nothing
		}
	}
	/* developer job  end*/
