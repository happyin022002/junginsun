/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_EAS_0006.js
*@FileTitle : MSC Checking
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion :
=========================================================*/


function ESD_EAS_0006() {
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

/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * initializing Sheetobjects
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++) {
		 
//		comConfigSheet(sheetObjects[i],SYSTEM_ENIS);
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		 
		ComEndConfigSheet(sheetObjects[i]);
	}
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

//Axon  --- start
/**
 *only upper case, numbers <br>
 **/
function engnum_keypress() {
//    ComKeyOnlyAlphabet('uppernum');
}

/**
 * BKG Creation manual <br>
 **/
function manual_click() {
    // edit  bkg no case in manual
//    form.boo_bkg_no.readOnly =!form.manual.checked;
}

/**
 * case in change  Booking No <br>
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
 * check Validation <br>
 **/
function obj_blur(){
    // inputValidation 확인하기
//    return ComChkObjValid(event.srcElement);
}

/**
 * clser Separator(  <br>
 **/
function obj_focus(){
//    ComClearSeparator(event.srcElement);
}

/**
 * only numbers <br>
 **/
function obj_keypress(){
//    ComKeyOnlyNumber(event.srcElement);
}

//Axon  --- end

/* Event handler processing by button click event */
document.onclick = processButtonClick;

/* Event handler processing by button name */
function processButtonClick(){

	 var sheetObject1 = sheetObjects[0];
	 var formObject  = document.form;

	try{
		var srcName = window.event.srcElement.getAttribute("name");
		
		switch(srcName) {

			case "btn_retrieve":
				if( validateForm(formObject) ) {
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
				}
				break;

			case "btn_new":
				sheetObject1.RemoveAll();
				formObject.reset();
				break;

			case "btn_downexcel":
				doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
				break;

			case "btn_calendar1":
				 var cal = new calendarPopup();
				 cal.select(formObject.occr_dt1, 'occr_dt1', 'yyyy-MM-dd');
				break;

			case "btn_calendar2":
        	        var cal = new calendarPopupFromTo();
	  				cal.displayType = "date";
					cal.select(formObject.occr_dt1, 'occr_dt1',formObject.occr_dt2, 'occr_dt2', 'yyyy-MM-dd');
				break;
			case "btns_office":
				if( isInputField(formObject) ) {
					var ofc_cd = formObject.ctrl_ofc_cd.value;
					var selofc_cd = formObject.sel_ofc_cd.value;
					ComOpenWindow('ESD_EAS_COM_0001.screen?ctrl_ofc_cd='+ofc_cd+'&sel_ofc_cd='+selofc_cd, 'ESD_EAS_COM_0001', 'top=200, left=200, width=410, height=400, toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=0');
				}
				break;				
		}
	}catch(e){
		if( e == "[object Error]") {
			ComShowCodeMessage('COM12111');
		} else {
			ComShowMessage(e);
		}
	}
}

function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSEARCH:      
			formObj.f_cmd.value = SEARCHLIST;
			sheetObj.DoSearch4Post("ESD_EAS_0006GS.do", EasFrmQryString(formObj));
			break;
	   case IBDOWNEXCEL:       
		   sheetObj.Down2Excel(-1, false, false, true);
		  break;

	}
}

function rtn_office_code(obj) {
	document.form.ctrl_ofc_cd.value = obj;
}

function resetSearchCondition(formObj){
	
	formObj.reset();
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
				
				style.height = GetSheetHeight(13);
				
				SheetWidth = mainTable.clientWidth;

				
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				
				MergeSheet = msHeaderOnly;

				
				Editable = false;

				//setting Row information [HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				//InitRowInfo( 1, 1, 9, document.form.row_size.value);
				InitRowInfo( 1, 1, 10);

				//setting Column information [COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(8, 0, 0, true);

				// setting function handling header
				InitHeadMode(true, true, true, true, false,false)

				var HeadTitle = " Seq.|TRO Office.|Booking No.|B/L No.|Bound.|Term.|Currancy.|AR Rev." ;

				//Header Row info [ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				HeadRowHeight = 12;
				
				//Data Attribute	[ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  			  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtData,  	 40,	daCenter,  true,	"seq",		   false,		  "",	   dfNone,   	0,	 		true ,	   true );
				InitDataProperty(0, cnt++ , dtData,		 100,	daCenter,  false,	"cre_ofc_cd",      false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 135,	daCenter,  false,	"bkg_no",      false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	     135,	daCenter,  false,	"bl_no",       false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 80,	daCenter,  true,	"bnd",         false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 80,	daCenter,  true,	"term",    	   false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 80,	daCenter,  true,	"chg_curr_cd", false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 105,	daRight,   true,	"ar_rev",      false,		  "",	   dfNone,   	0,	 		false,	   false);

				HeadRowHeight = 20 ;
		   }
			break;

	}
}

// Change Office
function fun_officeText() {
	document.form.ctrl_ofc_cd.value = document.form.ctrl_ofc_cd.value.toUpperCase();
}

function selectText(obj) {

	if( obj.name == "tromonth" ) {
		document.form.search_choice[0].checked = true;
		document.form.search_choice[1].checked = false;
		selectWhere();
		
	}else if( obj.name == "fromtrodate" ) {
		document.form.search_choice[0].checked = false;
		document.form.search_choice[1].checked = true;

		selectWhere();
		
	}else if( obj.name == "totrodate" ) {
		document.form.search_choice[0].checked = false;
		document.form.search_choice[1].checked = true;

		if( document.form.fromtrodate.value == "YYYYMMDD" ){
			document.form.fromtrodate.value = "";
		}
		document.form.totrodate.value = "";
		
	}	
	
}

function selectWhere() {

	if( document.form.search_choice[0].checked == true ) {

		document.form.tromonth.disabled = false;
		document.form.tromonth.value = "";
		document.form.tromonth.focus();
		
		document.form.search_choice[1].checked = false;
		document.form.fromtrodate.value = "YYYYMMDD";
		document.form.totrodate.value = "YYYYMMDD";
	
		
	} else if( document.form.search_choice[1].checked == true ) {

		document.form.fromtrodate.disabled = false;
		document.form.totrodate.disabled = false;
		document.form.fromtrodate.value = "";
		document.form.totrodate.value = "";
		document.form.fromtrodate.focus();
		
		document.form.search_choice[0].checked = false;
		document.form.tromonth.value = "YYYYMM";
	

	} 
}


/**
 * handling process for input validation
 */
function validateForm(formObj){

	var result = true ;
	
	if( ComIsEmpty(formObj.ctrl_ofc_cd) ) {
		ComShowCodeMessage('EAS90004', 'TRO Office');
		result = false ;
	}else if( formObj.search_choice[0].checked == false &&
		formObj.search_choice[1].checked == false ){
		ComShowMessage('Please enter the inquiry option');
		result = false;
	}else if( formObj.search_choice[0].checked == true ){
		if( ComIsEmpty(formObj.tromonth) ){
			ComShowCodeMessage('EAS90004', 'TRO Month.');
			result = false;
		}
	}else if( formObj.search_choice[1].checked == true ){
		if( ComIsEmpty(formObj.fromtrodate) ){
			ComShowCodeMessage('EAS90004', 'TRO Date.');
			result = false;
		}else if( ComIsEmpty(formObj.totrodate) ){
			ComShowCodeMessage('EAS90004', 'TRO Date.');
			result = false;
		}
	}
	return result;
}

function isInputField(formObj) {
	var result    = true ;
	if( ComIsEmpty(formObj.ctrl_ofc_cd) ) {
		formObj.ctrl_ofc_cd.value = 'HAMBB';
	}
	return result;
}

// handling Include Office Logic
var request = null;
function createHttpRequest() {
	try{
		request = new XMLHttpRequest();
	} catch(trymicrosoft) {
		try{
			request = new ActiveXObject("Msxml2.XMLHTTP");
		} catch(othermicosoft) {
			try{
				request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch(failed) {
				request = null;
			}
		}
	}
	if( request == null ) {
		ComShowMessage("Erroe Request XMLHttp");
	}
}

// Include Check Bok
function fun_chkOffice() {
	var doc_office = document.form.chk_office;
	var prm_office = doSepRemove(document.form.ctrl_ofc_cd.value.toUpperCase(), " "); //input text
	if( prm_office == "" ) {
		doc_office.checked = false;
		document.form.ctrl_ofc_cd.value = "";
		ComShowMessage("Please input the 'TRO Office'!!");
		return false;
	}
	if( doc_office.checked == true ) {
	
		var url = "ESD_EAS_0006GS.do?f_cmd="+SEARCH11+"&ctrl_ofc_cd="+prm_office;
		document.form.old_ofc_cd.value = prm_office;
		createHttpRequest();
		
		request.open("GET", url, false);

		request.onreadystatechange = subCntorlOffice;
		
		request.send(null);
	} else {
		document.form.ctrl_ofc_cd.value = document.form.old_ofc_cd.value;
	}
}

// get Office code
function subCntorlOffice() {
	if( request.readyState == 4 ) {
		if( request.status == 200 ) {
			var docXml = request.responseXML;
			var rowXml = docXml.getElementsByTagName("row-count")[0];
			var subXml = null;
			var text_ofc = "";
			for( var n = 0; n < rowXml.firstChild.nodeValue; n++ ) {
				subXml = docXml.getElementsByTagName("sub-office")[n];
				text_ofc = text_ofc+subXml.firstChild.nodeValue+",";
			}
			if( text_ofc.length < 1 ) {
				ComShowMessage("No Data!");
			}
			
			document.form.ctrl_ofc_cd.value = text_ofc.substring(0, text_ofc.length-1);
			
			
		}

	}

}

