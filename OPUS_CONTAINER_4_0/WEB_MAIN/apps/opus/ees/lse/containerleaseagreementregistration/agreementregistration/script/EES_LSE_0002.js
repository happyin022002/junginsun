/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0002.jsp
*@FileTitle  : Lease Agreement Version – Pop Up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/11
=========================================================*/
/****************************************************************************************
    Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * @extends
	 * @class ees_lse_0002 : business script for ees_lse_0002
	 */
	/* developer job */
	// common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Combo Object Array
	var comboObjects=new Array();
	var comboCnt=0;
	//Event handler processing by button click event */
	document.onclick=processButtonClick;
	//Event handler processing by button name */
	function processButtonClick(){
		/**********/
		var sheetObject=sheetObjects[0];
		/*******************************************************/
		var formObj=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject, formObj, IBSEARCH);
					break;
				case "btn_New":
					ComResetAll();
        			comboObjects[0].SetSelectText("ALL");// Initial Setting
					break;
				case "btn_Ok":
					comPopupOK();
					break;
				case "btn_Close":
					ComClosePopup(); 
					break;
 				case "btns_search1":
 					openPopupPage("1");
 					break;
 				case "btns_search2":
 					openPopupPage("2");
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
     * registering IBMultiCombo Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
	function setComboObject(combo_obj){
	   comboObjects[comboCnt++]=combo_obj;
	}
	/**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
	 */
	function loadPage() {
		/* initializing IBMultiCombo */
		for ( var k=0 ; k < comboObjects.length ; k++ ) {
			initCombo(comboObjects[k], k+1);
		}
		for ( var i=0 ; i < sheetObjects.length ; i++ ) {
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		/* Axon Control Setting*/
		initControl();
		ComSetFocus(document.form.agmt_seq);
		
		var formObj= document.form;
		if(formObj.agmt_seq.value != "") {
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
		}
	}
	
	
	//registering initial event
	function initControl() {
		var formObj=document.form;
		axon_event.addListenerFormat('blur',		'obj_blur',		formObj); 
		//axon_event.addListenerFormat('focus',		'obj_focus',	formObj); 
		//axon_event.addListenerFormat('keypress',	'obj_keypress',	formObj);
		//axon_event.addListenerFormat('keydown',		'obj_keydown',	formObj); 
		axon_event.addListenerFormat('change',		'obj_change',	formObj); 
	}
	/**
	 * handling event in case of Key-Press
	 **/
	function obj_keypress() {
		var obj=event.srcElement;
		switch(obj.dataformat) {
	        case "ymd":
	        case "ym":
	        case "hms":
	        case "hm":
	        case "jumin":
	        case "saupja":
	        case "int":
	            ComKeyOnlyNumber(obj);
	            break;
	        case "float":
	            ComKeyOnlyNumber(obj, "-.");
	            break;
	        case "eng":
	        	if ( obj.name == "ref_no" ) {
	        		ComKeyOnlyAlphabet('num');
	        	} else {
	        		ComKeyOnlyAlphabet();
	        	}
	            break;
	        case "engup":
	        	ComKeyOnlyAlphabet('upper');
	            break;
	        case "engdn":
	            ComKeyOnlyAlphabet('lower');
	            break;
	        default:
	            ComKeyOnlyNumber(obj);
	        	break;
	    }
	}
	/**
	 * handling Location blur event
	 **/
	function obj_blur(){
	    switch(event.srcElement.name){
	        case "agmt_seq":
	        case "vndr_seq":
	            //checking number
	            ComChkObjValid(event.srcElement, true, false, false);
	            break;
	        default:
	            //checking Validation
	            ComChkObjValid(event.srcElement);
	    }
	}
	/**
	 * handling event in case of focus
	 **/
	function obj_focus(){
	    //deleting data unit separator
	    ComClearSeparator(event.srcElement);
	}
  	/**
   	 * handling event in case of Key-Down
   	 */
  	function obj_keydown() {
  		var obj=event.srcElement;
  		var vKeyCode=event.keyCode;
  		var formObj=document.form;
  		if ( vKeyCode == 13 ) {
  			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
  			formObj.agmt_seq.focus();
  		}
	}
	/**
     * Onhandling event in case of Change
     */
 	function obj_change(){
		var obj=event.srcElement;
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if ( ComTrim(obj.value) != "" ) {
			switch(ComGetEvent("name")) {
	    		case "agmt_seq":
	    			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
					break;
	    		case "vndr_seq":
	        		doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC02);
				   	break;
			}
	    }
	}
	/**
	 * initializing IBMultiCombo
	 */
	function initCombo(comboObj, comboNo) {
	    switch(comboObj.id) {
	        case "combo1":
	        	with(comboObj) {
	            	//BackColor = "cyan";
	            	SetDropHeight(250);
	            	SetMultiSelect(0);
	            	SetMaxSelect(1);
	            }
	        	break;
	    }
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
		      var HeadTitle="|Sel.|AGMT No.|||Term|Contract No.|Ref. No.|VER|Lessor ABBR|Lessor Name|Office|Period|Period|Created by|Date|Updated by|Date";
		      var headCount=ComCountHeadTitle(HeadTitle);

		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		             {Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"radio",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"agmt_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"agmt_cty_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"agmt_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"lstm_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"lse_ctrt_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"ref_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"agmt_ver_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vndr_abbr_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"vndr_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cre_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"upd_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		       
		      InitColumns(cols);
		      //SetSheetHeight(500);
		      ComResizeSheet(sheetObj);
		      SetEditable(1);
		            }


				break;
		}
	}
	// handling process for Sheet
	function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
	        case IBCREATE:		//Lease Term Form Combo Item Setting
	     		sheetObj.SetWaitImageVisible(0);
	        	formObj.f_cmd.value=SEARCH01;
 		     	var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do", FormQueryString(formObj));
		        if ( sXml != "" ) {
		        	// "ALL" Item Insert
		            comboObjects[0].InsertItem(0,"ALL"," ");
		            LseComXml2ComboItem(sXml, comboObjects[0], "lease_term_nm", "lease_term_cd", "|");
		            comboObjects[0].SetSelectText("ALL");// Initial Setting
		        }
		        sheetObj.SetWaitImageVisible(1);
		        break;
			case IBSEARCH:
				if(validateForm(sheetObj,formObj,sAction)) {
					if(sheetObj.id == "sheet1") {
						formObj.f_cmd.value=SEARCH;
						//formObj.lstm_cd.value = ComGetObjValue(formObj.combo1);
						sheetObj.SetWaitImageVisible(0);
	         			ComOpenWait(true);
 	         			sheetObj.DoSearch("EES_LSE_0002GS.do",FormQueryString(formObj) );
	         			ComOpenWait(false);
					}
				}
				break;
			case IBSEARCHAPPEND:
         		if ( sheetObj.id == "sheet1") {
	            	formObj.f_cmd.value=SEARCH;
 	                sheetObj.DoSearch("EES_LSE_0002GS.do", CondParam+"&"+ "iPage=" + PageNo,{Append:true} );
         		}
                break;
 			case IBSEARCH_ASYNC01:	//retrieving when input Form Agreement No.
				if(validateForm(sheetObj,formObj,sAction)) {
					if ( sheetObj.id == "sheet1") {
						formObj.f_cmd.value=SEARCH03;
						sheetObj.SetWaitImageVisible(0);
	 						var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",FormQueryString(formObj));
						sheetObj.SetWaitImageVisible(1);
						if ( sXml != "" ) {
	 						if ( ComGetEtcData(sXml, "lstm_cd") != undefined ) {
	 							formObj.vndr_seq.value=ComGetEtcData(sXml, "vndr_seq");
	 							formObj.vndr_nm.value=ComGetEtcData(sXml, "vndr_nm");
	 							//formObj.lstm_cd.value      = ComGetEtcData(sXml, "lstm_cd");
							} else {
								var errMsg=LseComGetErrMsg(sXml);
								if ( errMsg != "" ) {
									ComShowMessage(errMsg);
								}
								clearForm("agmt_seq");
								ComSetFocus(formObj.agmt_seq);
							}
						}
					}
				}
				break;
			case IBSEARCH_ASYNC02:	//retrieving when input Form Lessor No.
				if(validateForm(sheetObj,formObj,sAction)) {
					if ( sheetObj.id == "sheet1") {
						var param="f_cmd="+SEARCH06+"&vndr_seq="+ComGetObjValue(formObj.vndr_seq);
						sheetObj.SetWaitImageVisible(0);
							var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do", param);
						sheetObj.SetWaitImageVisible(1);
						if ( sXml != "" ) {
							if ( ComGetEtcData(sXml, "vndr_lgl_eng_nm") != undefined ) {
								ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
								ComSetNextFocus(formObj.vndr_seq);
	 						} else {
	 							ComShowCodeMessage("LSE01019");
	 							ComSetObjValue(formObj.vndr_seq, "");
	 							ComSetObjValue(formObj.vndr_nm, "");
	 							ComSetFocus(formObj.vndr_seq);
	 						}
						} else {
							ComShowCodeMessage("LSE01019");
							ComSetObjValue(formObj.vndr_seq, "");
							ComSetFocus(formObj.vndr_seq);
						}
					}
				}
				break;
		}
	}
	 	function sheet1_OnLoadFinish(sheetObj) {
		var formObj=document.form;
		/* IBMulti Combo Item Setting */
		doActionIBSheet(sheetObj, formObj, IBCREATE);
	}
	/**
	 * sheet1_OnScrollNext
	 */
 	function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
		doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, CondParam, PageNo);
	}
	/**
	 * combo1_OnChange
	 */
	function combo1_OnChange(comboObj, Index_Code, Text) {
		var formObj=document.form;
		formObj.lstm_cd.value=comboObj.GetSelectCode();
	}
	/**
     * handing process Pop-up<br>
     * @param type 1:Agreement(include Ver.) for FORM, 2:Lessor for FORM, 3:Currency for FORM
     * @param object
     * @param Row index
	 */
   function openPopupPage(type, Row, Col) {
   	if ( type == "1" ) {
   		ComOpenPopup('/opuscntr/EES_LSE_0091.do', 805, 450, 'setPopData_Agreement', '1,0', true);
   	} else if ( type == "2" ) {
   		ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 615, 450, 'setPopData_Lessor', '1,0,1,1,1,1,1,1', true);
   	}
   }
    /**
     * handling process for Agreement Pop-up Return Value<br>
     * @param Return value array
     * @param Row index
     * @param Col index
     * @param Sheet Array index
     */
    function setPopData_Agreement(aryPopupData, Row, Col, SheetIdx) {
    	var sheetObj=sheetObjects[SheetIdx];
    	var formObj=document.form;
    	if ( aryPopupData.length > 0 ) {
    		document.form.agmt_seq.value=aryPopupData[0][5];
    		document.form.vndr_seq.value=aryPopupData[0][8];
    		document.form.vndr_nm.value=aryPopupData[0][9];
			//formObj.lstm_cd.value  = aryPopupData[0][6];
    	}
    }
	/**
	 * handling process for Lessor(Service Provider) Pop-up Return Value<br>
	 * @param Return value array
	 * @param Row index
	 * @param Col index
	 * @param Sheet Array index
	 */
	function setPopData_Lessor(aryPopupData, Row, Col, SheetIdx) {
		var sheetObj=sheetObjects[SheetIdx];
		var formObj=document.form;
		if ( aryPopupData.length > 0 ) {
			formObj.vndr_seq.value=ComLtrim(aryPopupData[0][2],"0");
			doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC02);
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction){
		switch(sAction) {
			case IBSEARCH:
				if ( ComTrim(ComGetObjValue(formObj.agmt_seq)) == ""
				  && ComTrim(ComGetObjValue(formObj.combo1))   == ""
				  && ComTrim(ComGetObjValue(formObj.vndr_seq)) == "" ) {
					ComShowCodeMessage("LSE01025");
					ComSetFocus(formObj.agmt_seq);
					return false;
				}
				break;
		}
		return true;
    }
	/**
	 * handling process for Form Element Clear<br>
	 * @param fieldName
	 */
	function clearForm(fieldName)
	{
		var formObj=document.form;
		switch(fieldName) {
			case "agmt_seq":
				formObj.agmt_seq.value="";
				formObj.vndr_seq.value="";
				formObj.vndr_nm.value="";
				//formObj.lstm_cd.value      = "";
				break;
			case "vndr_seq":
				formObj.agmt_seq.value="";
				formObj.vndr_seq.value="";
				formObj.vndr_nm.value="";
				//formObj.lstm_cd.value      = "";
				break;
		}
	}
	/* developer job */
