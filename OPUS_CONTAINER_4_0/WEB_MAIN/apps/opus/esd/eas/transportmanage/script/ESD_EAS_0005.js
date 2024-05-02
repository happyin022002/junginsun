/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_EAS_0005.js
*@FileTitle : Cancelled BKG’s Cntr Tracing
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
 
function ESD_EAS_0005() {
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

//Axon -- start
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
//    return ComChkObjValid(event.srcElement);
}

function obj_focus(){
//    ComClearSeparator(event.srcElement);
}

/**
 * only number <br>
 **/
function obj_keypress(){
//    ComKeyOnlyNumber(event.srcElement);
}

//Axon -- end

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
		}
	}catch(e){
		if( e == "[object Error]") {
			ComShowCodeMessage('COM12111') ;
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
			sheetObj.DoSearch4Post("ESD_EAS_0005GS.do", EasFrmQryString(formObj));
			break;
	   case IBDOWNEXCEL:       
		  sheetObj.Down2Excel(-1, false, false, true);
		  break;

	}
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
				
				style.height = GetSheetHeight(16);
				
				SheetWidth = mainTable.clientWidth;

				
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				
				MergeSheet = msHeaderOnly;

				
				Editable = false;

				//setting Row information [HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				//InitRowInfo( 1, 1, 9, document.form.row_size.value);
				InitRowInfo( 2, 1, 10);

				//setting Column information [COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(28, 0, 0, true);

				// setting function handling header
				InitHeadMode(true, true, true, true, false,false)

				var HeadTitle = " Seq.|BKG Data|BKG Data|BKG Data|BKG Data|BKG Data|BKG Data|BKG Data|BKG Data|BKG Data|BKG Data|BKG Data|TRO Loc.|TRO Q'ty"
				+"|CCT Ofc.|Exp Inv.|TRO Amt.|AR Rev.|Rev_Exp|Ex.Rate|TRO Ofc.|TRO ID|S/O Ofc.|S/O ID|Rating Ofc.|Rating ID|Sts|Trm_Type" ;

				var HeadTitle1 = " Seq.|Booking No.|B/L No.|POR|POL|POD|DEL|S/C No.|RFA No.|Cntr No.|Bnd|Term|TRO Loc.|TRO Q'ty"
				+"|CCT Ofc.|Exp Inv.|TRO Amt.|AR Rev.|Rev_Exp|Ex.Rate|TRO Ofc.|TRO ID|S/O Ofc.|S/O ID|Rating Ofc.|Rating ID|Sts|Trm_Type" ;
				
				//Header Row info [ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				InitHeadRow(1, HeadTitle1, true);

				//HeadRowHeight = 12;
				
				//Data Attribute	[ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  			  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtData,  	 40,	daCenter,  true,	"seq",				false,		  "",	   dfNone,   	0,	 		true ,	   true );
				InitDataProperty(0, cnt++ , dtData,		 90,	daCenter,  false,	"bkg_no",      false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	     95,	daCenter,  false,	"bl_no",       false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	     50,	daCenter,  false,	"por_cd",      false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	     50,	daCenter,  false,	"pol_cd",      false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 50,	daCenter,  false,	"pod_cd",      false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	     50,	daCenter,  false,	"del_cd",      false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 85,	daCenter,  false,	"sc_no",      	false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	     85,	daCenter,  false,	"rfa_no",     	false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 85,	daCenter,  false,	"cntr_no",   	false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 30,	daCenter,  true,	"bnd",         false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daCenter,  true,	"term",        false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daCenter,  true,	"tro_loc",    	false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daCenter,  true,	"tro_qty",     false,		  "",	   dfNone,   	0,	 		false,	   false);				
				InitDataProperty(0, cnt++ , dtData,		 70,	daCenter,  true,	"cct_ofc",    	false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daRight,   true,	"exp_inv",     false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daRight,   true,	"tro_amt",    	false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daRight,   true,	"ar_rev",      false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daRight,   true,	"rev_exp",     false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daRight,   true,	"ex_rate",     false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 80,	daCenter,  true,	"tro_ofc",     false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daCenter,  true,	"tro_id",      false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 80,	daCenter,  true,	"so_ofc",     	false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daCenter,  true,	"so_id",       false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 80,	daCenter,  true,	"rating_ofc",  false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daCenter,  true,	"rating_id",   false,		  "",	   dfNone,    0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 30,	daCenter,  true,	"sts",         false,		  "",	   dfNone,   	0,	 		false,	   false); 
				InitDataProperty(0, cnt++ , dtData,		 70,	daCenter,  true,	"trm_type",    false,		  "",	   dfNone,   	0,	 		false,	   false);

				HeadRowHeight = 20 ;
		   }
			break;

	}
}

// Change Office
function fun_officeText() {
	document.form.bkgno.value = document.form.bkgno.value.toUpperCase();
	document.form.blno.value = document.form.blno.value.toUpperCase();
	//document.form.cntrno.value = document.form.cntrno.value.toUpperCase();
}


function selectText(obj) {

	if( obj.name == "bkgno" ) {
		document.form.search_choice[0].checked = true;
	}else if( obj.name == "blno" ) {
		document.form.search_choice[1].checked = true;
	}
//	else if( obj.name == "cntrno"  ) {
//		document.form.search_choice[2].checked = true;
//	}
	
	selectWhere();
}


function selectWhere() {

	if( document.form.search_choice[0].checked == true ) {

		document.form.bkgno.disabled = false;
		document.form.bkgno.value = "";
		document.form.bkgno.focus();
		
		document.form.search_choice[1].checked = false;
		document.form.blno.value = "";
	
//		document.form.search_choice[2].checked = false;
//		document.form.cntrno.value = "";
		
	} else if( document.form.search_choice[1].checked == true ) {

		document.form.blno.disabled = false;
		document.form.blno.value = "";
		document.form.blno.focus();
		
		document.form.search_choice[0].checked = false;
		document.form.bkgno.value = "";
	
//		document.form.search_choice[2].checked = false;
//		document.form.cntrno.value = "";

	}
//	else if( document.form.search_choice[2].checked == true ) {
//
//		document.form.cntrno.disabled = false;
//		document.form.cntrno.value = "";
//		document.form.cntrno.focus();
//		
//	} 

}


/**
 * handling process for input validation
 */
function validateForm(formObj){

	var result = true ;
	
	if( formObj.search_choice[0].checked == false &&
		formObj.search_choice[1].checked == false ){
		ComShowMessage('Please enter the inquiry option');
		result = false;
	}else if( formObj.search_choice[0].checked == true ){
		if( ComIsEmpty(formObj.bkgno) ){
			ComShowCodeMessage('EAS90004', 'Cancelled BKG No');
			result = false;
		}
	}else if( formObj.search_choice[1].checked == true ){
		if( ComIsEmpty(formObj.blno) ){
			ComShowCodeMessage('EAS90004', 'Cancelled B/L No');
			result = false;
		}
	}
//	else if( formObj.search_choice[2].checked == true ){
//	
//		if( ComIsEmpty(formObj.cntrno) ){
//			ComShowCodeMessage('EAS90004', 'Cancelled Container');
//			result = false;
//			
//		}
//		
//		if( ComIsEmpty(formObj.bkgno) || ComIsEmpty(formObj.blno) ){
//			ComShowCodeMessage('EAS90004', 'Cancelled BKG No or Cancelled B/L No');
//			result = false;
//			
//		}
//	}

	return result;
}
