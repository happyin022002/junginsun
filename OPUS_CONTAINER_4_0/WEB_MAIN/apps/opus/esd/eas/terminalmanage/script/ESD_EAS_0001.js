/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_EAS_0001.js
*@FileTitle : Rehandling Expense & TPB Check
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
	/**
	 * @extends Bkg
	 * @class ESD_EAS_0001 : ex)business script for COD vs. TPB.
	 */
	function ESD_EAS_0001() {
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

	// Global variables
	var sheetObjects = new Array();
	var sheetCnt = 0;

	/* Event handler processing by button click event */
	document.onclick = processButtonClick;
	
	
	/**
	 * registering IBSheet Object as list
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	
	/* Event handler processing by button name */
	function processButtonClick(){

		var sheetObject1 = sheetObjects[0];
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject1, formObject, IBSEARCH, "btn_retrieve"  );
					break;

				case "btn_new":
					fn_reset();
					break;
						
				case "btn_downexcel":
					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
					break;
					
				case "port":
					if ( formObject.btns_radio_ofc[0].checked == true ) {
						formObject.port.value="";
					}else {
						formObject.port.disabled = true;
					}
					break;
				
				case "fmMonth":
					if ( formObject.btns_radio_date[0].checked == true ) {
						formObject.fmMonth.value="";
					}else {
						formObject.fmMonth.disabled = true;
					}
					break;
					
				case "toMonth":
					if ( formObject.btns_radio_date[0].checked == true ) {
						formObject.toMonth.value="";
					}else {
						formObject.toMonth.disabled = true;
					}
					break;
				
				case "office":
					if ( formObject.btns_radio_ofc[1].checked == true ) {
						formObject.office.value="";
					}else {
						formObject.office.disabled = true;
					}
					break;
					
				case "vvd":
					if ( formObject.btns_radio_date[1].checked == true ) {
						formObject.vvd.value="";
					}else {
						formObject.vvd.disabled = true;
					}
					break;
			
			} // end switch

		} catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage("COM12111");
			} else {
				ComShowMessage(e);
			}
		}
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
	// initializing html controller 
	initControl();
}

 // handling sheet process
function doActionIBSheet(sheetObj,formObj,sAction, srcName) {

	sheetObj.ShowDebugMsg = false;

	switch(sAction) {

		case IBSEARCH:

			if(!validateForm(sheetObj, formObj, IBSEARCH	, "btn_retrieve" ))	return false;

			document.form.port.value = document.form.port.value.toUpperCase();

			sheetObjects[0].RemoveAll();
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch4Post("ESD_EAS_0001GS.do", EasFrmQryString(formObj));
			break;
					
		case IBDOWNEXCEL: //ExcelDownload
		    sheetObj.Down2Excel(-1, false, false, true);
			break;

	}
}


    /**
     * Laod Page HTML Control Event <br>
	 * {@link #loadPage} initializing IBSheet. <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {int}     sheetNo     sheetObjects
	 **/
	function initControl() {

	//		axon_event.addListener  ('keypress', 'engnum_keypress', 'boo_bkg_no', 'vvd_vvd');
	//		axon_event.addListener  ('click', 'manual_click', 'manual');    
	//		axon_event.addListener  ('keyup', 'bkgno_keyup', 'boo_bkg_no'); 
	//		axon_event.addListenerFormat('blur',    'obj_blur',     form); 
	//		axon_event.addListenerFormat('focus',   'obj_focus',    form); 
	//		axon_event.addListenerFormat('keypress','obj_keypress', form);
	//		axon_event.addListener  ('change', 'customer_change', 'cus_cust_nm');
	}

	/**
	 * HTML Control의 onkeypress Event  input only alphabet, numbers. <br>
	 **/
	function engnum_keypress() {
	//    ComKeyOnlyAlphabet('uppernum');
	}

	/**
	 * BKG Creation manual <br>
	 **/
	function manual_click() {
	   // edit Bkg_no in case checked manual.
	   //    form.boo_bkg_no.readOnly =!form.manual.checked;
	}

	/**
	 * When Change Booking No in  BKG Creation tab. <br>
	 **/
	function bkgno_keyup() {
	    // Clear BL No where changed bkg_no and DB data are different.
	    /*
	    if (form.boo_bkg_no.value != form.hdn_boo_bkg_no.value) 
		form.boo_bl_no.value = "";
	    else
		form.boo_bl_no.value = form.hdn_boo_bl_no.value;
		*/
	}

	/**
	 * Checking Validation HTML Control  onblur event <br>
	 **/
	function obj_blur(){
	    // input Validation 
	//    return ComChkObjValid(event.srcElement);
	}

	/**
	 * deleting unit separator Mask in  HTML Control onfocus Event <br>
	 **/
	function obj_focus(){
	//    ComClearSeparator(event.srcElement);
	}

	/**
	 * HTML Control의 onkeypress input only numbers. <br>
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
		case 1:      //sheet1 init
			with (sheetObj) {
			
				
				style.height = GetSheetHeight(15) ;
				
				SheetWidth = mainTable.clientWidth;
				
				
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				
				MergeSheet = msHeaderOnly;

			   
				Editable = true;

				//setting Row information setting Row information [HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 2, 1, 9, 100);

				//setting Column information [COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(18, 1, 0, true);

				// setting function handling header
				InitHeadMode(true, true, true, true, false,false)
                 
                // 4341.11.20 Investigation 추가
				var HeadTitle1 = "Seq.|COD Data|COD Data|COD Data|COD Data|COD Data|COD Data|COD Data|COD Data|COD Data|TPB Data|TPB Data|TPB Data|TPB Data|TPB Data|BL Data|Investigation";
				var HeadTitle2 = "Seq.|Req. Office|Port|VVD(O)|Lane|T-VVD|ETD Date|BKG No.|BKG\nCNTR|Amount\n(USD)|TPB No.|Amount\n(USD)|ROC to OFC|3rd Party|New TPB No.|Amount\n(USD)|Investigation";

				//Header Row info [ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);

				//Data Attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtSeq,        40,   daCenter,  true,    "seq",      	false,          "",      dfNone,      0,     false,       false,           8);
				InitDataProperty(0, cnt++ , dtData,       70,   daCenter,  true,    "cod_ofc_cd",   false,          "",      dfNone,      0,     false,       false,           5);
				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "cod_port_cd",       	false,          "",      dfNone,      0,     false,       false,           5);
				InitDataProperty(0, cnt++ , dtData,       80,   daCenter,  true,    "cod_vvd",      	false,          "",      dfNone,      0,     false,       false,           9);
				InitDataProperty(0, cnt++ , dtData,       40,   daCenter,  true,    "cod_slan_cd",      	false,          "",      dfNone,      0,     false,       false,           3);
				
				InitDataProperty(0, cnt++ , dtData,       80,   daCenter,  true,    "vvd",      	false,          "",      dfNone,      0,     false,       false,           9);
				InitDataProperty(0, cnt++ , dtData,      100,   daCenter,  true,    "cod_etd_dt",       	false,          "",      dfNone,      0,     false,       false,           10);
				InitDataProperty(0, cnt++ , dtData,      100,   daCenter,  true,    "bkg_no", 		false,          "",      dfNone,      0,     false,       false,           13);
				InitDataProperty(0, cnt++ , dtData,       40,   daCenter,  true,    "cod_cntr_qty",     false,          "",      dfInteger,   0,     false,       false,           5);
				InitDataProperty(0, cnt++ , dtData,       90,   daRight,   true,    "cod_amt",      false,          "",      dfFloat,     2,     false,       false,           14);
				
				InitDataProperty(0, cnt++ , dtData,      120,   daCenter,  true,    "tpb_no", 		false,          "",      dfNone,      0,     false,       false,           14);
				InitDataProperty(0, cnt++ , dtData,       90,   daRight,   true,    "amt_usd",      false,          "",      dfFloat,     2,     false,       false,           5);
				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "roc_ofc",      false,          "",      dfNone,      0,     false,       false,           2);
				InitDataProperty(0, cnt++ , dtData,       80,   daCenter,  true,    "pty_3rd",      false,          "",      dfNone,      0,     false,       false,           8);
				InitDataProperty(0, cnt++ , dtData,      120,   daCenter,  true,    "new_tpb_no",   false,          "",      dfNone,      0,     false,       false,           14);
				
				InitDataProperty(0, cnt++ , dtData,       90,   daRight,   true,    "usd_amt_bl",   false,          "",      dfFloat,     2,     false,       false,           14);
				InitDataProperty(0, cnt++ , dtData,		  70,	daCenter,  true,	"rmk_ctnt",    false,		  "",	   dfNone,   	0,	 		false,	   false);                
				InitDataProperty(0, cnt++ , dtHidden,     30,   daCenter,  true,    "ibflag");
				ColHidden('ibflag') = true;
			}
			break;

	}
}


function sheet1_OnDblClick(sheetObj, row, col ){

    if(col == 16){
    	var theURL = "ESD_EAS_0901.do?bkg_no=" + sheetObj.CellValue( row, 'bkg_no') + "&eas_expn_tp_cd=RH";
    	var winName = "ESD_EAS_0901";
    	var features = "width=700,height=365,toolbar=no,location=no,status=yes,menubar=no,scrollbars=auto,resizable=no,alwaysRaised,dependent,titlebar=no";
    	
    	ComOpenWindow(theURL,winName,features);
    }
}


/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction, srcName){
    var formObject = document.form;	
	var sheetObject1 = sheetObjects[0];

	switch(sAction) {
		case IBSEARCH:
			switch(srcName){
				case "btn_retrieve":
					if ( formObject.btns_radio_date[0].checked == true && formObject.btns_radio_ofc[0].checked == true) {
						var check_fmmonth 	= formObject.fmMonth.value ;
						var check_tomonth 	= formObject.toMonth.value ;
					
						if(check_fmmonth == '' || check_fmmonth == null || check_fmmonth == 'YYYYMM'
							|| check_tomonth == '' || check_tomonth == null || check_tomonth == 'YYYYMM') 
						{
							ComShowCodeMessage('EAS90007');
							fn_reset();
							return false;
						}
						formObject.office.value = "";
						formObject.vvd.value = "";
					} else if( formObject.btns_radio_date[1].checked == true && formObject.btns_radio_ofc[0].checked == true) {
						var check_vvd = formObject.vvd.value ;
						if(check_vvd == '' || check_vvd == null) 
						{
							ComShowCodeMessage("EAS90008");
							fn_reset();
							return false;
						}
						formObject.office.value = "";
						formObject.fmMonth.value = "YYYYMM";
						formObject.toMonth.value = "YYYYMM";					
					} else if( formObject.btns_radio_date[0].checked == true && formObject.btns_radio_ofc[1].checked == true) {
						var check_fmmonth 	= formObject.fmMonth.value ;
						var check_tomonth 	= formObject.toMonth.value ;
						if(check_fmmonth == '' || check_fmmonth == null || check_fmmonth == 'YYYYMM'
							|| check_tomonth == '' || check_tomonth == null || check_tomonth == 'YYYYMM') 
						{
							ComShowCodeMessage("EAS90007");
							fn_reset();
							return false;
						}
						formObject.port.value = "";	
						formObject.vvd.value = "";
					} else if( formObject.btns_radio_date[1].checked == true && formObject.btns_radio_ofc[1].checked == true) {
						var check_vvd = formObject.vvd.value ;
						if(check_vvd == '' || check_vvd == null) 
						{	
							ComShowCodeMessage("EAS90008");
							fn_reset();
							return false;
						}
						formObject.port.value = "";	
						formObject.fmMonth.value = "YYYYMM";
						formObject.toMonth.value = "YYYYMM";					
					}
					
				break;
			}
		break;
	}
	return true;
}

/**
 *  initializing conditionns in case of clicking  new button
 */
function fn_reset(){

	var formObject = document.form;	
	sheetObjects[0].RemoveAll();

	formObject.port.value="";
	formObject.fmMonth.value="YYYYMM";
	formObject.toMonth.value="YYYYMM";
	formObject.office.value="";
	formObject.vvd.value="";
	formObject.btns_radio_date[0].checked = true;
	formObject.fmMonth.disabled = false;
	formObject.toMonth.disabled = false;
}	

function fun_Focus(obj)
{
	var val = obj.value;
	obj.value = val;
	obj.select();
}

/**
 * Chane period in case of clicking Radio button
 */
function change_period(){
	var formObject = document.form;
	var val="";	
	//formObject.hid_period.value="M";   //Month  
	//formObject.hid_period.value="V";   //VVD
	//formObject.hid_period.value="P";   //Port
	//formObject.hid_period.value="O";   //Office
								
	if ( formObject.btns_radio_date[0].checked == true && formObject.btns_radio_ofc[0].checked == true ) {
		formObject.fmMonth.disabled = false;
		formObject.toMonth.disabled = false;
		formObject.vvd.disabled = true;
		formObject.port.disabled = false;
		formObject.office.disabled = true;
	}else if ( formObject.btns_radio_date[1].checked == true && formObject.btns_radio_ofc[0].checked == true ) {
		formObject.vvd.disabled = false;
		formObject.fmMonth.disabled = true;
		formObject.toMonth.disabled = true;
		formObject.port.disabled = false;
		formObject.office.disabled = true;
	}else if ( formObject.btns_radio_date[0].checked == true && formObject.btns_radio_ofc[1].checked == true ) {
		formObject.fmMonth.disabled = false;
		formObject.toMonth.disabled = false;
		formObject.vvd.disabled = true;
		formObject.office.disabled = false;
		formObject.port.disabled = true;
	}else if ( formObject.btns_radio_date[1].checked == true && formObject.btns_radio_ofc[1].checked == true ) {
		formObject.vvd.disabled = false;
		formObject.fmMonth.disabled = true;
		formObject.toMonth.disabled = true;
		formObject.office.disabled = false;
		formObject.port.disabled = true;
	}
}

