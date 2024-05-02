/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_2011.js
*@FileTitle : Time Clock Stop Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.05.11 최성환
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------The following code added code to make a good  JSDoc ------------------*/
   /**
     * @fileoverview JavaScript is commonly used in business calendar-related functions are defined as.
     * @author Hanjin Shipping
     */

   	/* Developer's task	*/
    // common global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    var COMMON_TARIFF_CD="common_tariff_cd"; 
    var ROWMARK="|";
    var FIELDMARK="=";
    var set_day=21;
    var DEF_SHEET_HEIGHT = 453;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
         /***** Tab sheets per case more than two additional sheets are used to specify a variable *****/
         var sheetObject1=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
         var srcObj=window.event.srcElement;
    	try {
    		var srcName=ComGetEvent("name");
				switch(srcName) {
					case "btns_calendar": 
			         	//if(srcObj.style.cursor == "hand") {
				            var cal=new ComCalendarFromTo();
				            cal.select(formObject.fm_dt,  formObject.to_dt,  'yyyy-MM-dd');
			         	//}
						break;	
					case "btn_Retrieve":	
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
						break;
					case "btn_New":
						doActionIBSheet(sheetObject1,formObject,IBCLEAR);
						var formObject=document.form; 
					    //var data = getDefaultDate(set_day).split("|");
						//formObject.fm_dt.value = data[1];
						//formObject.to_dt.value = data[0];
						var ofcCurrDate=DmtComOfficeCurrDate(sheetObjects[0], formObject); 
						ComSetObjValue(formObject.fm_dt, 	ComGetDateAdd(ofcCurrDate, "D", -21)); 
						ComSetObjValue(formObject.to_dt,   	ofcCurrDate);  //오늘 날짜.
						sheetObject1.RemoveAll();
						break;
					case "btn_Detail":
						alert(srcName);
						break;
					case "btn_DownExcel":
						if (sheetObject1.RowCount() == 0)  {
					   		ComShowCodeMessage("COM132501"); // No data to dowload as Excel
					   	    return;
					   	} 
						else {
					   		sheetObject1.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1, Merge:1});
					   	}
						
						break;
					case "btn_Print":
						alert(srcName);
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
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],k+1);
	    }
	    sheet1_OnLoadFinish();
		initControl();
		var formObject=document.form; 
	    //var data = getDefaultDate(set_day).split("|");
		//formObject.fm_dt.value = data[1];
		//formObject.to_dt.value = data[0];
		var ofcCurrDate=DmtComOfficeCurrDate(sheetObjects[0], formObject); 
		ComSetObjValue(formObject.fm_dt, 	ComGetDateAdd(ofcCurrDate, "D", -21)); 
		ComSetObjValue(formObject.to_dt,   	ofcCurrDate);  //오늘 날짜.
		ComSetFocus(formObject.r_date[0]);
    }
 	function initControl() {
		axon_event.addListenerForm  ('beforedeactivate','obj_deactivate',  form, 'cond_type'); 
		axon_event.addListenerFormat('beforeactivate',	'obj_activate',    form); 
		axon_event.addListenerFormat('keypress',		'obj_keypress',    form); 
		axon_event.addListener('click', 'obj_click', 'cond_type'); 
	}
    function obj_click() {
    	 doEnableCondObj(event.srcElement.value);
    } 
    function obj_deactivate(){
        ComChkObjValid(event.srcElement);
    }
    /**
     * HTML Control Foucs in
     */
    function obj_activate(){
        ComClearSeparator(event.srcElement);
    }
	function obj_keypress() {
	   	 switch(event.srcElement.dataformat){
	        	case "engup":
	        		ComKeyOnlyAlphabet('uppernum');
			        break;
	        	default:
		            ComKeyOnlyNumber(event.srcElement);
	   	 }
    }
    /** 
   	 *Register as an array IBCombo Object
  	 * param : combo_obj ==> combo object
  	 * The next batch of other items when you need treatment of fiberglass can add to an array that holds the process
  	 * Array defined at the top of the source
   	 */ 
   	function setComboObject(combo_obj) {  
   	    comboObjects[comboCnt++]=combo_obj;  
   	}
  	function initCombo(comboObj, comboNo) {
  	    var formObject=document.form
  	    
  	    switch(comboNo) {  
			case 1: 
			with (comboObj) { 
				SetMultiSelect(1);
				SetUseAutoComplete(1);
				SetColAlign(0, "left");
				SetColAlign(1, "left");
				SetColWidth(0, "65");
				SetColWidth(1, "300");
				SetDropHeight(160);
				SetMultiSeparator(",");
			}
			//doActionIBCombo(sheetObjects[0], formObject, IBSEARCH_ASYNC01);
			break;
			
			case 2: 
			with (comboObj) { 
				SetMultiSelect(1);
				SetUseAutoComplete(1);
				SetColAlign(0, "left");
				SetColAlign(1, "left");
				SetColWidth(0, "50");
				SetColWidth(1, "300");
				SetDropHeight(160);
				SetMultiSeparator(",");
			}
			//doActionIBCombo(sheetObjects[0], formObject, IBSEARCH_ASYNC02);
			break; 
  	     } 
  	}

  	
  	 var selComboIndex, selComboCode;
  	 function combo1_OnSelect(comboObj ,index, code) {
  	  selComboIndex = index;
  	  selComboCode = code;
  	 }
  	 
  	 function combo1_OnChange(comboObj) {
  	     ComSetMultiCombo(comboObj, selComboIndex, selComboCode);
  	 }
  	 
  	 
  	function sheet1_OnLoadFinish() {
  		var formObj=document.form
  		sheetObjects[0].SetWaitImageVisible(0);
  		doActionIBCombo(sheetObjects[0], formObj, IBSEARCH_ASYNC01);
  		doActionIBCombo(sheetObjects[0], formObj, IBSEARCH_ASYNC02);
        sheetObjects[0].SetWaitImageVisible(1);
  	}  
  	
  	
  	function doActionIBCombo(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
		sheetObj.SetWaitImageVisible(0);
        switch(sAction) {
		        case IBSEARCH_ASYNC01:  
			 		//1. Tariff type comboList
			 		var sComboObj=comboObjects[1];
			 		//1. Tariff type comboList
					formObj.f_cmd.value=SEARCH09;
					var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
					//3.조회후 결과처리
					var result;
					var comboItem;
					var comboItems;
					var comboItems=ComGetEtcData(sXml, "all_tariff_cd").split(ROWMARK);
					addComboItem(sComboObj,comboItems);
				break;
		        case IBSEARCH_ASYNC02:  
					//2. Office comboList
					formObj.f_cmd.value=SEARCHLIST01;
					var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
		    	    if (sXml != undefined && sXml != '') {
			    	    var ofc_cds=ComGetEtcData(sXml, "OFC_CD");
			    	    var ofc_nms=ComGetEtcData(sXml, "OFC_NM");
			    	    var comboCodeArr=ofc_cds.split("|");			    	    
			    	    var comboTextArr=ofc_nms.split("|");
			    	    var comboObj=comboObjects[0];
			    	    for (var i=0 ; i < comboTextArr.length ; i++) {
			    	    	comboObj.InsertItem(i, comboCodeArr[i] + "|" + comboTextArr[i], comboCodeArr[i]);		
			         	}
		    	    }
				break;
		        case IBSEARCH_ASYNC03:     	
					//3. Sub Office comboList
					formObj.f_cmd.value=COMMAND01;
					var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
		    	    if (sXml != undefined && sXml != '') {
			    	    var ofc_cds=ComGetEtcData(sXml, "OFC_CD");
			    	    var comboObj=comboObjects[0];
		    	    	if(ofc_cds != '') 
		    	    		comboObj.SetSelectCode(ofc_cds);
		    	    }
				break;
        }
		sheetObj.SetWaitImageVisible(1);
    }
	function addComboItem(comboObj, comboItems) {
		for ( var i=0; i < comboItems.length; i++) {
			var comboItem=comboItems[i].split(FIELDMARK);
			comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[1]);
		}
	}   	
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with(sheetObj){
            		var HeadTitle1="|Seq.|Status|Clock Stop No.|Office|Tariff|From|To|Stop Days|Yard|Remark(s)|Creation/Cancellation|Creation/Cancellation|Creation/Cancellation";
            		var HeadTitle2="|Seq.|Status|Clock Stop No.|Office|Tariff|From|To|Stop Days|Yard|Remark(s)|Office|Name|Date";
            		var headCount=ComCountHeadTitle(HeadTitle1);

              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"},
                          { Text:HeadTitle2, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"hdnStatus" },
                     {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"cxl_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"clk_stop_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"clk_stop_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_trf_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"clk_stop_fm_dt",   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0 },
                     {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"clk_stop_to_dt",   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"stop_days",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"clk_stop_yd_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },     
                     {Type:"Text",      Hidden:0,  Width:195,  Align:"Left",    ColMerge:1,   SaveName:"clk_stop_rmk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },                
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"upd_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"upd_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"upd_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0 } ];
               
              InitColumns(cols);

              SetEditable(1);
              SetCountPosition(0);
              SetEllipsis(1);
              SetSheetHeight(DEF_SHEET_HEIGHT);
                    //no support[check again]CLT ToolTipOption="balloon:true;width:50;";
              }
              break;
        }
    }
    // Sheet processing-related processes
    function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
		case IBSEARCH: 
				if (!validateForm(sheetObj, formObj, sAction)) {
					return false;
				}
				if (!validateDate(formObj)) {
					return false
				}
				if (formObj.r_date[0].checked) {
					formObj.date_period.value="creation";
				} else if (formObj.r_date[1].checked) {
					formObj.date_period.value="stop_date";
				}
				//office code :comboObjects[0]
				if (comboObjects[0].GetSelectText()== '') {
					formObj.office.value="";
				} else {
					formObj.office.value="stop_office";
//					if (formObj.r_office[0].checked) {
//						formObj.office.value = "creation";
//					} else if (formObj.r_office[1].checked) {
//						formObj.office.value = "stop_office";
//					}
				}
				//office code :comboObjects[0]
				formObj.clk_stop_ofc_cd.value=comboObjects[0].GetSelectText();
				//tariff code : comboObjects[1]
				formObj.dmdt_trf_cd.value=comboObjects[1].GetSelectText();
				//ComOpenWait Start
				sheetObj.SetWaitImageVisible(0);
		        ComOpenWait(true);
				formObj.f_cmd.value=SEARCH02;
				sheetObj.DoSearch("EES_DMT_2011GS.do",	FormQueryString(formObj) );
				//ComOpenWait End
				
			break;
		case IBCLEAR:      
			initSearchControls();
			//buttonMode("IBCLEAR");
			break;
		case IBINSERT: 
			break;
		}
	}
    
    
    function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    	ComOpenWait(false);
    }
    
    /**
     * Screen input form validation process for handling
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
        }
        return true;
    }
    /**
   	  * INIT SETTING
   	  */
   	function initSearchControls() {
   		var formObj=document.form;
   		comboObjects[0].SetSelectText("");
   		ComClearObject(formObj.clk_stop_ofc_cd);   		
   		comboObjects[1].SetSelectText("");
   		ComClearObject(formObj.dmdt_trf_cd);
   		ComClearObject(formObj.fm_dt);
   		ComClearObject(formObj.to_dt);
   		ComClearObject(formObj.cxl_flg);	
   		formObj.r_date[0].checked=true;
   		formObj.chk_sub_ofc.checked=false;
   	}
    /**
	  * Screen input form validation process for handling
	  */
	function validateForm(sheetObj,formObj,sAction){
		if(IBSEARCH == sAction ){
			if(formObj.fm_dt.value.trimAll().lengthByte() <= 0){
				ComShowCodeMessage('DMT02002', "Period");
				ComSetFocus(formObj.fm_dt);
				return false;
			} else if(formObj.to_dt.value.trimAll().lengthByte() <= 0){
				ComShowCodeMessage('DMT02002', "Period");
				ComSetFocus(formObj.to_dt);
				return false;
			} 
		}
		return true;
	}
	function validateDate(formObj){
//		if(ComChkPeriod(formObj.fm_dt.value, formObj.to_dt.value) > 0){
//			if(ComGetDaysBetween(formObj.fm_dt.value, formObj.to_dt.value) > 21){
//				ComShowCodeMessage('DMT00103');
//				return false;
//			}
//		} else 
		if (ComChkPeriod(formObj.fm_dt.value, formObj.to_dt.value) <= 0){
			ComShowCodeMessage('DMT01020');
			return false;
		} 
		return true;
	}
	function sheet1_OnPopupClick(sheetObj, Row, Col) {
		var parm=sheetObj.GetCellValue(Row, Col);
		ComOpenPopup('EES_DMT_2010.do?parm='+parm+'&parm2=Y', 800, 500, '', '0,1', false, false, Row, Col, 0);
	}
	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
		with(sheetObj){
			Row = MouseRow();
			Col = MouseCol();
			if (Row > 0 && Col == 9) {
				SetToolTipText(Row, Col, GetCellText(Row, Col));
			} 
			else {
				SetToolTipText(Row, Col, "");
			}
		}
	}
	function doInclSubOfc() {
		  var formObj=document.form;
		  if (formObj.chk_sub_ofc.checked) { // Sub Office including
			  if (ComIsEmpty(comboObjects[0].GetSelectCode())) {
				  ComShowCodeMessage('COM12113', "DEM/DET Office");
				  formObj.chk_sub_ofc.checked=false;
				  return;
			  }
			  formObj.ofc_cd.value=ComGetObjValue(comboObjects[0]);
			  formObj.tmp_ofc_cd.value=ComGetObjValue(comboObjects[0]);	
			  doActionIBCombo(sheetObjects[0], formObj, IBSEARCH_ASYNC03);
		  } else {
			  ComSetObjValue(comboObjects[0], formObj.tmp_ofc_cd.value);	
		  }
	}
	
	
	
 	function combo2_OnCheckClick(comboObj, index, code) {
 		var formObj=document.form;
 		if(formObj.chk_sub_ofc.checked) {
   			if(comboObj.GetItemCheck(index))
   				comboObj.SetItemCheck(index,0);
   			else
   				comboObj.SetItemCheck(index,1);
   			ComShowCodeMessage('DMT00107');
   		}
 	}
 	function combo2_OnKeyDown(comboObj, keycode, shift) {
		var formObj=document.form;
   		if(formObj.chk_sub_ofc.checked) {
   			ComShowCodeMessage('DMT00107');
   		}
 	}
	function keyPress() {
		var eventKey=window.event.keyCode ;
			if( eventKey == 13 ) {
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			}
		}
	document.onkeypress=keyPress ;
	/* Developer's task end */
