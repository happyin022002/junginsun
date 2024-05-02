/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_EAS_0002.js
*@FileTitle : Route UnMatch List
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1
=========================================================*/

	function ESD_EAS_0002() {
	    this.processButtonClick     = processButtonClick;
	    this.setSheetObject         = setSheetObject;
	    this.setComboObject         = setComboObject;
	    this.setTabObject           = setTabObject;
	    this.loadPage               = loadPage;
	    this.initSheet              = initSheet;        
	    this.initControl            = initControl;
	    this.initTab                = initTab;
	    this.doActionIBSheet        = doActionIBSheet;
	    this.validateForm           = validateForm;
	}	
	
	/* Global variables */
	var sheetObjects = new Array();
	var sheetCnt = 0;

	/* Event handler processing by button click event */
	document.onclick = processButtonClick;
	
	/* Event handler processing by button name */
	function processButtonClick(){

		var sheetObject = sheetObjects[0];
		
		 /******************************************************/
		 var formObject = document.form;
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
			case "btn_downexcel":
				sheetObject.ExcelPrint = "";
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
				break;
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
			case "bttn_save":
				doActionIBSheet(sheetObject,formObject,IBSAVE);
				break;
			case "btn_new":
				sheetObject.RemoveAll();
				formObject.reset();
				break;				
			case "btns_office": 
			//if( validation_check() ) {
				var ofc_cd = formObject.ctrl_ofc_cd.value;
				ComOpenWindow('ESD_EAS_COM_0001.screen?ctrl_ofc_cd='+ofc_cd, 'ESD_EAS_COM_001', 'top=200, left=200, width=410, height=400, toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=0');
			//}
			break;
			case "btn_detail":
				//openWindow('ESD_EAS_0903.do?inv_no=PUS-07-05-TS-20', 'ESD_EAS_0903', 'top=200, left=200, width=800, height=600, toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=1');
				sheet1_OnDblClick(sheetObject, sheetObject.SelectRow, sheetObject.SelectCol);
				break;

			} // end switch
		} catch(e) {
			if( e == "[object Error]") {
				errMsg = ComGetMsg("COM12111" );
				ComShowMessage(errMsg);
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
		sheetObjects[sheetCnt++] = sheet_obj;
	}
			
	 
	 /**
	  * initializing Sheetobjects
	  * implementing onLoad event handler in body tag
	  * adding first-served functions after loading screen.
	  */
	 function loadPage() {
	 	for(i=0;i<sheetObjects.length;i++){
	 		 
	 		ComConfigSheet(sheetObjects[i]);
	        initSheet(sheetObjects[i],i+1);
	         
	        ComEndConfigSheet(sheetObjects[i]);
	    }
	         
	 	document.form.somonth.focus();
 		//initializing html controller 
 		initControl();
	 }
	 
	 

  	function initControl() {
  	    //Axon event
  	//		axon_event.addListener  ('keypress', 'engnum_keypress', 'boo_bkg_no', 'vvd_vvd');
  	//		axon_event.addListener  ('click', 'manual_click', 'manual');    
  	//		axon_event.addListener  ('keyup', 'bkgno_keyup', 'boo_bkg_no'); 
  	//		axon_event.addListenerFormat('blur',    'obj_blur',     form);  
  	//		axon_event.addListenerFormat('focus',   'obj_focus',    form);  
  	//		axon_event.addListenerFormat('keypress','obj_keypress', form);  
  	//		axon_event.addListener  ('change', 'customer_change', 'cus_cust_nm');    
  	}

  	/**
  	 * only upper case, numbers <br>
  	 **/
  	function engnum_keypress() {
  	//    ComKeyOnlyAlphabet('uppernum');
  	}

  	/**
  	 * BKG Creation manual <br>
  	 **/
  	function manual_click() {
  	//    form.boo_bkg_no.readOnly =!form.manual.checked;
  	}

  	/**
  	 * Case in change Booking No at BKG Creation tab <br>
  	 **/
  	function bkgno_keyup() {
  	    /*
  	    if (form.boo_bkg_no.value != form.hdn_boo_bkg_no.value) 
  		form.boo_bl_no.value = "";
  	    else
  		form.boo_bl_no.value = form.hdn_boo_bl_no.value;
  		*/
  	}

   /**
  	* check inputValidation  <br>
  	**/
  	function obj_blur(){
  	    // check inputValidation 기
  	//    return ComChkObjValid(event.srcElement);
  	}

  	/**
  	 * Clear Separator  <br>
  	 **/
  	function obj_focus(){
  	//    ComClearSeparator(event.srcElement);
  	}

  	/**
  	 *  only numbers <br>
  	 **/
  	function obj_keypress(){
  	//    ComKeyOnlyNumber(event.srcElement);
  	}


	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		switch(sheetNo) {
			case 1:	  //IBSheet1 init
				with (sheetObj) {
	                
	                style.height = GetSheetHeight(15) ;
	                
	                SheetWidth = mainTable.clientWidth;

					
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					
					MergeSheet = msHeaderOnly;

				   
					Editable = true;

					//setting Row information [HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 2, 1, 10, 10);

					//setting Column information [COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(17, 0, 0, true);

					InitHeadMode(true, true, true, true, false, false)

					var HeadTitle = "SEQ|B/L Data|B/L Data|B/L Data|B/L Data|B/L Data|B/L Data|B/L Data|B/L Data|B/L Data|B/L Data|S/O Data|S/O Data|S/O Data|S/O Data|S/O Data|Investigation";
					var HeadTitle1 = "SEQ|VVD|BKG NO|S|B/L NO|BD|TM|POR|POL|POD|DEL|FROM|VIA|TO|T/Mode|Office|Investigation";
	
					//setting Header  [ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					InitHeadRow(1, HeadTitle1, true);
					
					HeadRowHeight = 12;					
				   
					//Data Attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtSeq,   	 40,    daCenter, true,     "seq",              false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,      100,    daCenter, false,    "vvd",            	false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,      100,    daCenter, false,    "bkg_no",			false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       50,    daCenter, false,    "bkg_status",       false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,      100,    daCenter, false,    "bl_no",            false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       50,    daCenter, false,    "bound",     		false,          "",       dfNone,    0,     false,       true);

					InitDataProperty(0, cnt++, dtData,       50,    daCenter, false,    "term",      		false,          "",       dfNone,    0,     false,       true); 
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "bkg_por",          false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "bkg_pol",          false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "bkg_pod",          false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "bkg_del",          false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "so_from",          false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "so_via",          false,          "",       dfNone,    0,     false,       true);
					
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "so_to",            false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       60,    daCenter, false,    "trans_mode",       false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "so_ofc_cd",        false,          "",       dfNone,    0,     false,       true);					
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, true,     "rmk_ctnt",     	false,          "",       dfNone,    0,     false,       true);

				}
				break;
		}
	}

		

	
	/* handling sheet process */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		   case IBSEARCH:	  //Retrieve
			
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch4Post("ESD_EAS_0002GS.do", EasFrmQryString(formObj));
				break;

			case IBCLEAR:	   //Clear
				sheetObj.RemoveAll();
				break;
			case IBDOWNEXCEL:  
				sheetObj.SpeedDown2Excel(true);
				break;
		}
	}
	

	/**
	 * Handling Error Result
	 * IBSheetConfig.js - definie DataSheetObject.prototype.event_OnSearchEnd
	 */
	function sheet1_OnSearchEnd(sheetObj,errMsg){

	}

	function sheet1_OnClick(sheetObj, Row,Col,Value){
	
	}

	
	function sheet1_OnDblClick(sheetObj,Row,Col){
		var param;
		var theURL;
		var winName;
		var features;
		
	   	var bkg_no = ComTrim(sheetObj.CellValue(Row, 'bkg_no'));

	   	var so_ofc_cd = ComTrim(sheetObj.CellValue(Row, 'so_ofc_cd'));

	   	if(Col != 16){
			param = "?bkg_no="+bkg_no+"&so_ofc_cd="+so_ofc_cd;
			theURL = "ESD_EAS_0903.do"+param;
			winName = "ESD_EAS_0903";
			features = "toolbar=no,location=no,status=no,menubar=no,scrollbars=auto,resizable=yes,alwaysRaised,dependent,titlebar=no,width=800,height=550";
			ComOpenWindow(theURL,winName,features);
			
		}else if(Col == 16){
	    	var theURL = "ESD_EAS_0901.do?bkg_no=" + sheetObj.CellValue( Row, 'bkg_no') + "&eas_expn_tp_cd=RU";
	    	var winName = "ESD_EAS_0901";
	    	var features = "width=700,height=365,toolbar=no,location=no,status=yes,menubar=no,scrollbars=auto,resizable=no,alwaysRaised,dependent,titlebar=no";
	    	
	    	ComOpenWindow(theURL,winName,features);
			
//			openRemarkPopup(sheetObj.CellValue(Row,"bkg_no"), sheetObj.CellValue(Row,"bl_no"), 'RU');
    	}
	}

// Change Office
function fun_officeText() {
	document.form.ctrl_ofc_cd.value = document.form.ctrl_ofc_cd.value.toUpperCase();
}

function rtn_office_code(obj) {
	document.form.ctrl_ofc_cd.value = obj;
}


function upperCase(obj) {
	obj.value = obj.value.toUpperCase();
	
}
function pointAutoMove(val) {
	if ( val.length == 8  ) {
		document.form.tosodate.focus();
	}
}

function selectText(obj) {

	if( obj.name == "somonth" ) {
		document.form.search_choice[0].checked = true;
	}else if( obj.name == "fromsodate" || obj.name == "tosodate" ) {
		document.form.search_choice[1].checked = true;
	}
	
	selectWhere();
}


function selectWhere() {

	if( document.form.search_choice[0].checked == true ) {

		document.form.somonth.disabled = false;
		document.form.somonth.value = "";
		document.form.somonth.focus();
			
		document.form.search_choice[1].checked = false;
		document.form.fromsodate.value = "yyyymmdd";
		document.form.fromsodate.disabled = true;
		document.form.tosodate.value = "yyyymmdd";
		document.form.tosodate.disabled = true;
				
	} else if( document.form.search_choice[1].checked == true ) {

		document.form.fromsodate.disabled = false;
		document.form.tosodate.disabled = false;
		if ( document.form.fromsodate.value == "yyyymmdd" ){
			document.form.fromsodate.value = "";
			document.form.fromsodate.focus();
		}	
		
		if ( document.form.tosodate.value == "yyyymmdd" ){
			document.form.tosodate.value = "";
		}

		document.form.search_choice[0].checked = false;
		document.form.somonth.value = "yyyymm";
		document.form.somonth.disabled = true;
	
	}

}


/**
 * handling process for input validation
 */
function validateForm(formObj){

formObj = document.form;
	var result = true ;
	
	// Check condition 
	if( !isInputField(formObj) ) {
		result = false ;
	}

	if( formObj.search_choice[0].checked == true ){
		if( ComIsEmpty(formObj.somonth) || !chkMonthValue(formObj.somonth.value) ){
			var errMsg = ComGetMsg("EAS90004" , 'S/O Month');
			ComShowMessage(errMsg);
			result = false;
		}
	}else if( formObj.search_choice[1].checked == true ){
		if( ( ComIsEmpty(formObj.fromsodate) || !chkDateValue(formObj.fromsodate.value) ) && ( ComIsEmpty(formObj.tosodate) || !chkDateValue(formObj.tosodate.value) ) ){
			var errMsg = ComGetMsg("EAS90004" , 'S/O Date');
			ComShowMessage(errMsg);				
			result = false;
		}
	}
	if(formObj.ctrl_ofc_cd.value == '') {
		var errMsg = ComGetMsg("EAS90004" , 'S/O Office');
		ComShowMessage(errMsg);
		result = false;
	}
	return result;
}

function isInputField(formObj) {
	var result    = true ;

//	if( document.form.ctrl_ofc_cd.value=="" ) {
//		showErrMessage(getMsg('EAS90002', 'S/O Office'));
//		result = false;
//	}
	return result;
}
	