/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_7007.js
*@FileTitle  : Daily Batch Job Status Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

   	/* Developer's task	*/
    // Common global variable
	var sheetObjects=new Array();
	var sheetCnt=0;
    var set_day=30;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	
	// Event handler processing by button name
	function processButtonClick() {
		/***** Tab sheets per case more than two additional sheets are used to specify a variable *****/
		var sheetObject1=sheetObjects[0];
		/** **************************************************** */
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			var srcObj=window.event.srcElement;
			switch (srcName) {
         	case "btns_calendar": //calendar button
	         	//if(srcObj.style.cursor == "hand") {
		            var cal=new ComCalendarFromTo();
		            cal.select(formObject.fm_dt,  formObject.to_dt,  'yyyy-MM-dd');
	         	//}
				break;
 			case "btn_retrieve":
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
				break;
			case "btn_new":				
				var formObject=document.form;
				//Office Of Users should look up the current date.
				var ofcCurrDate=DmtComOfficeCurrDate(sheetObjects[0], formObject); 
				//Viewed in the field of the screen allows you to map date.
				ComSetObjValue(formObject.fm_dt, 	ComGetDateAdd(ofcCurrDate, "M", -1)); //  the date before 1 month.
				ComSetObjValue(formObject.to_dt,   	ofcCurrDate);  //today.
				sheetObject1.RemoveAll();
				break;
			} // end switch
		} catch (e) {
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
     * adding first-served functions after loading screen
    */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		//html control event initializing
		initControl();
		// The initial set of date values
		var formObject=document.form;
		var ofcCurrDate=DmtComOfficeCurrDate(sheetObjects[0], formObject); 
		//Viewed in the field of the screen allows you to map date.
		ComSetObjValue(formObject.fm_dt, 	ComGetDateAdd(ofcCurrDate, "M", -1)); //the date before 1 month.
		ComSetObjValue(formObject.to_dt,   	ofcCurrDate);  //오늘 날짜.
		doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
	}
	
    function initControl() {
		axon_event.addListenerForm  ('beforedeactivate','obj_deactivate',  form, 'cond_type'); //- focus out
		axon_event.addListenerFormat('beforeactivate',	'obj_activate',    form); //- focus in
		axon_event.addListenerFormat('keypress',		'obj_keypress',    form); //- input with keyboard
		//axon_event.addListener('click', 'obj_click', 'cond_type'); 
	}
    
    function obj_click() {
    	 doEnableCondObj(event.srcElement.value);
    } 
    
    //focus out
    function obj_deactivate(){
        //input Validation check + mast delimiter input
        ComChkObjValid(event.srcElement);
    }
    
    /**
     * HTML Control Foucs in
     */
    function obj_activate(){
        ComClearSeparator(event.srcElement);
    }
    
	//business javascript OnKeyPress event processing
	function obj_keypress() {
	   	 switch(event.srcElement.dataformat){
        	case "engup":
		    	// upper case + numbers 
        		ComKeyOnlyAlphabet('uppernum');
		        break;
        	default:
	         	// only numbers(integer, date, time)
	            ComKeyOnlyNumber(event.srcElement);
	   	 }
    }
	
    /**
     * Sheet the initial setting, the header definition
     * param : sheetObj ==> sheet object, sheetNo ==> Sheet object ID of the tag attached to the serial number
     * Many case as the number of sheets to add the sheet, a sheet should initialize the module configuration
      */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch (sheetID) {
		case "sheet1":
			with(sheetObj){
				var HeadTitle1="|Seq.|Date|KOR|KOR|CHN|CHN|SWA1|SWA1|SWA2|SWA2|SWA3|SWA3|USA|USA|EUR|EUR";
				var HeadTitle2="|Seq.|Date|Batch Time|Auto|Batch Time|Auto|Batch Time|Auto|Batch Time|Auto|Batch Time|Auto|Batch Time|Auto|Batch Time|Auto";
				var headCount=ComCountHeadTitle(HeadTitle1);

				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Status" },
				             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"SEQ",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Date",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"bat_his_dt",   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:1,   SaveName:"kor_bat_tm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"kor_bat_typ",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 },
				             {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:1,   SaveName:"chn_bat_tm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"chn_bat_typ",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 },
				             {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:1,   SaveName:"sw1_bat_tm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"sw1_bat_typ",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 },
				             {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:1,   SaveName:"sw2_bat_tm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"sw2_bat_typ",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 },
				             {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:1,   SaveName:"sw3_bat_tm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"sw3_bat_typ",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 },
				             {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:1,   SaveName:"usa_bat_tm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"usa_bat_typ",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 },
				             {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:1,   SaveName:"eur_bat_tm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"eur_bat_typ",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 } ];
	       
				InitColumns(cols);

				SetEditable(1);
				SetSheetHeight(515);
			}
			break;
		}
	}
	
	// Sheet processing-related processes
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
			case IBSEARCH: //조회
				if (!validateForm(sheetObj, formObj, sAction)) {
					return false;
				}
				if (!validateDate(formObj)) {
					return false
				}
				formObj.f_cmd.value=SEARCH;
//method change[check again]CLT
				sheetObj.DoSearch("EES_DMT_7007GS.do",	FormQueryString(formObj) );
				break;
		}
	}
	
	/**
     * Screen input form validation process for handling
     */
	function validateForm(sheetObj, formObj, sAction) {
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
		
	/**
     * Handling of date value validation process
     */
 	function validateDate(formObj){
 		if (ComChkPeriod(formObj.fm_dt.value, formObj.to_dt.value) <= 0){
 			ComShowCodeMessage('DMT01020');
 			return false;
 		} 
 		return true;
 	}
 	
	function keyPress() {
		var eventKey=window.event.keyCode ;
		if( eventKey == 13 ) {
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}
	document.onkeypress=keyPress ;
	/* Developer's task end */
