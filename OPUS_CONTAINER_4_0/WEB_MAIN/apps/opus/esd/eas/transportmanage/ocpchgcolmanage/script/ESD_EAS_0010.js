/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_EAS_0010.js
*@FileTitle : OCP Charge Collection Management
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
=========================================================*/

function ESD_EAS_0010() {
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

var curTab = 1;
var beforetab = 0;
var sheetObjects = new Array();
var sheetCnt = 0;
var isJORetrive = false; 


	/**
	 * IBTab Object initializing
	 * Tab ID tab1,tab2,...
	 * Call setupPage()  before loadPage()
	 */
	function InitTab() {
		try{
			with(document.all.tab1){
				InsertTab(0, "Dry Index"    , 23 );
				InsertTab(1, "Tanker Index" , 23 ); 
				InsertTab(2, "Time Charter" , 23 );
				InsertTab(3, "Bunker Price" , 23 );
				InsertTab(4, "Ship Price"   , 23 ); 
				InsertTab(5, "FFA Index"    , 23 );
				TabBackColor(0)="146,174,230";
			}
		}catch(e){
			ComShowMessage(e);
		}
	}
	
	/**
	 * handling onChange event of tab1
	 */
	function tab1_OnChange(nItem){
		ChangeTab(document.all.tab1,nItem);
	}
	
	function ChangeTab(tabObj,nItem){
		tabObj.BackColor="#FFFFFF";
		tabObj.TabBackColor(nItem)="146,174,230";
	
		var objs = document.all.item("tabLayer");
		objs[beforetab].style.display = "none";
		objs[nItem].style.display = "Inline";
	
		//--------------- Notice --------------------------//
		//objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
		//ksw : Can not click buttun zIndex  below -2.
		objs[beforetab].style.zIndex = 0;
		objs[nItem].style.zIndex = 9;
		//------------------------------------------------------//
		beforetab= nItem;
	}

	/**
	 * registering IBSheet Object as list
	 * Calling at comSheetObject(id)
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
		
//		document.form.somonth.focus();
		//initializing html controller 
		initControl();
	}


	function initControl() {
	    //Axon event  catch
//			axon_event.addListener  ('keypress', 'engnum_keypress', 'boo_bkg_no', 'vvd_vvd');
//			axon_event.addListener  ('click', 'manual_click', 'manual');    
//			axon_event.addListener  ('keyup', 'bkgno_keyup', 'boo_bkg_no'); 
//			axon_event.addListenerFormat('blur',    'obj_blur',     form);  
//			axon_event.addListenerFormat('focus',   'obj_focus',    form);  
//			axon_event.addListenerFormat('keypress','obj_keypress', form);  
//			axon_event.addListener  ('change', 'customer_change', 'cus_cust_nm');   
	}
	
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
		sheetObj.UseUtf8 = true;
		switch(sheetNo) {
			case 1:	  //IBSheet1 init
				with (sheetObj) {
					var cnt = 0;
					
					style.height = 365;
										
					
					SheetWidth = mainTable.clientWidth;

					
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					
					MergeSheet = msHeaderOnly;

				   
					Editable = true;

					//setting Row information [HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 2, 1, 10, 10);

					//setting Column information [COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(22, 0, 0, true);

					// setting function handling header
					InitHeadMode(true, true, true, true, false, false)

					var HeadTitle1 = "SEQ|Control\nOffice|Booking Information|Booking Information|Booking Information|Booking Information|Booking Information|Booking Information|Booking Information|Booking Information|Booking Information|Booking Information|Booking Information|Booking Information|OCP Information|OCP Information|OCP Information|OCP Information|Collection Information|Collection Information|Collection Information|Investigation\n& Note";
					var HeadTitle2 = "SEQ|Control\nOffice|Booking|Container|T/S|RCV tm|DEL tm|Shipper|Consignee|POR|POL|POD|DEL|SC or RFA|Inbound Release|Inbound Release|MT Return|MT Return|BKG-OCP|BKG-OCP|TPB|Investigation\n& Note";
	
					//Header Row info [ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
					
				   
					//Data Attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtSeq,   	 40,    daCenter, true,     "seq",              false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       60,    daCenter, true,    "ctrl_ofc_cd",       false,          "",       dfNone,    	0,     false,       true);

					InitDataProperty(0, cnt++, dtData,       90,    daCenter, false,    "bkg_no",			false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       90,    daCenter, false,    "cntr_no",            false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       50,    daCenter, false,    "ts_cd",     		false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       50,    daCenter, false,    "rcv_tm",     		false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       50,    daCenter, false,    "del_tm",     		false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       90,    daCenter, false,    "shpr_no",      	false,          "",       dfNone,    	0,     false,       true); 
					InitDataProperty(0, cnt++, dtData,       90,    daCenter, false,    "cnee_no",      	false,          "",       dfNone,    	0,     false,       true); 
					InitDataProperty(0, cnt++, dtData,       50,    daCenter, false,    "por_cd",           false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       50,    daCenter, false,    "pol_cd",           false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       50,    daCenter, false,    "pod_cd",           false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       50,    daCenter, false,    "del_cd",           false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "sc_rfa_cd",           false,          "",       dfNone,    	0,     false,       true);

					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "ib_rlse_cd",           false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "ib_rlse_dt",           false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "mt_rtn_cd",           false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "mt_rtn_dt",           false,          "",       dfNone,    	0,     false,       true);

					InitDataProperty(0, cnt++, dtData,       30,    daCenter, false,    "bkg_ocp_tp",          false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daRight, false,    "bkg_ocp_amt",          false,          "",       dfNullFloat,  2,     false,       true);
					InitDataProperty(0, cnt++, dtData,       90,    daCenter, false,    "tpb_cd",          false,          "",       dfNone,  0,     false,       true);
					
					InitDataProperty(0, cnt++, dtHidden,       60,    daCenter, true,    "rmk_ctnt",          false,          "",       dfNone,  0,     false,       false);
					
					//sheetObj.ColHidden("bkg_no_split") = true;
				}
				break;
		}
	}

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
				case "bttn_add":
					   doActionIBSheet(sheetObject,formObject,IBINSERT);
					break;
				case "bttn_cancel":
//					   doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
				case "bttn_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;
				case "bttn_remove":
					break;
				case "bttn_preview":
					sheetObject.ExcelPrint = "PreView";
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;
				case "btn_downexcel":
					sheetObject.ExcelPrint = "";
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;
				case "bttn_print":
					sheetObject.ExcelPrint = "PrintOnly";
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;
				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
				case "btn_new":
					sheetObject.RemoveAll();
					formObject.reset();
					break;
				case "btns_calendar1":
					 var cal = new calendarPopup();
					 cal.select(formObject.fm_dt, 's_sdate', 'yyyy-MM-dd');
					break;
				case "btns_calendar2":
					var cal = new calendarPopupFromTo();
					cal.displayType = "date";
					cal.select(formObject.to_dt, 's_sdate',formObject.s_edate, 's_edate', 'yyyy-MM-dd');
					break;
				case "btns_office": 
					var ofc_cd = formObject.s_ctrl_ofc_cd.value;
					ComOpenWindow('ESD_EAS_COM_0001.screen?s_ctrl_ofc_cd='+ofc_cd, 'ESD_EAS_COM_0001', 'top=200, left=200, width=410, height=400, toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=0');
			
				break;
				case "btns_cust": 
					ComOpenPopup('/opuscntr/COM_ENS_041.do', 770, 470, 'getCustomer', '1,0,1,1,1,1,1,1');
				break;
				case "btns_loc": 
					ComOpenPopup('/opuscntr/COM_ENS_051.do', 770, 470, 'getLocation', '1,0,1,1,1,1,1,1');
				break;
				
                case "cnt_btn":         
                	with(formObject)
                	{    	    
                	    var v_cnt_cd = cnt_cd.value;
                	    var classId = "COM_ENS_0M1";
            		    var param = '?cnt_cd='+v_cnt_cd+'&classId='+classId;
            		    var v_display = "1,0,1,1,1,0,0";
            		    var chkStr = v_display.substring(0,3)
            		  
            		    if(chkStr == "1,0") {
            		        ComOpenPopup('/opuscntr/COM_ENS_0M1.do' + param, 565, 480, 'getCOM_ENS_0M1_1', v_display, true);
            		    } else {
            			    return;
            		    }
                	}
				break;
				case "btn_detail":
					//ComOpenWindow('ESD_EAS_0903.do?inv_no=PUS-07-05-TS-20', 'ESD_EAS_0903', 'top=200, left=200, width=800, height=600, toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=1');
					sheet1_OnDblClick(sheetObject, sheetObject.SelectRow, sheetObject.SelectCol);
					break;
			} // end switch
		}catch(e) {			
			if( e == "[object Error]") {
				ComShowCodeMessage('COM12111');
			} else {
				ComShowMessage(e);
			}
		}
	}
	
	/**
	 * Location popup close
	 *
	 */
	function getLocation(rArray) {
		var cArray = rArray[0];
		document.all.s_mt_rtn_cd.value = cArray[3];
	}

	
	function getCustomer(rArray){
		var cArray = rArray[0];
		
		document.form.s_cnee_no.value = cArray[3];		
		document.form.s_cust_nm.value = cArray[4]; 
    }	
	/* handling sheet process */
	function doActionIBSheet(sheetObj,formObj,sAction) {
//		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		   case IBSEARCH:	 //retrieve
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				formObj.f_cmd.value = SEARCH;
//				prompt('',"ESD_EAS_0010GS.do?"+EasFrmQryString(formObj));
//				return;
				sheetObj.DoSearch4Post("ESD_EAS_0010GS.do", EasFrmQryString(formObj));
				break;	 
			case IBCLEAR:	   //Clear
				sheetObj.RemoveAll();
				break;
			case IBDOWNEXCEL:  // down excel file
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


// Change Office
function fun_officeText() {
	document.form.s_ctrl_ofc_cd.value = document.form.s_ctrl_ofc_cd.value.toUpperCase();
}

function rtn_office_code(obj) {
	document.form.s_ctrl_ofc_cd.value = obj;
}


function upperCase(obj) {
	obj.value = obj.value.toUpperCase();
	
}
function pointAutoMove(val) {
	if ( val.length == 8  ) {
		document.form.to_dt.focus();
	}
}

function selectText(obj) {
	//alert("obj.name : "+obj.name);
	if( obj.name == "fm_dt" || obj.name == "to_dt" ) {
		selectWhere();
	}	
}


function selectWhere() {

	if ( document.form.fm_dt.value == "yyyymmdd" ){
		document.form.fm_dt.value = "";
		document.form.fm_dt.focus();
	}	
	
	if ( document.form.to_dt.value == "yyyymmdd" ){
		document.form.to_dt.value = "";
	}
}

function setNull() {
	if ( document.form.fm_dt.value == "yyyymmdd" ){
		document.form.fm_dt.value = "";
	}	
	if ( document.form.to_dt.value == "yyyymmdd" ){
		document.form.to_dt.value = "";
	}
	if ( document.form.s_ctrl_ofc_cd.value != "" ){
		document.form.s_ctrl_ofc_cd.value = "";
	}
	if ( document.form.s_mt_rtn_cd.value != "" ){
		document.form.s_mt_rtn_cd.value = "";
	}
	if ( document.form.s_cnee_no.value != "" ){
		document.form.s_cnee_no.value = "";
	}
	if ( document.form.s_cust_nm.value != "" ){
		document.form.s_cust_nm.value = "";
	}
	
}


/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
//	formObj = document.form;
		var result = true ;
		// Check inputing conditions
/*		if( !isInputField(formObj) ) {
			result = false ;
		}*/
		if( ComIsEmpty(formObj.s_bkg_no) ){
	
			if( ComIsEmpty(formObj.fm_dt) || ComIsEmpty(formObj.to_dt) || formObj.to_dt.value == "yyyymmdd"){
				ComShowMessage("Please enter MT Return Period.");
				result = false;
			}
			else {
				var days = ComGetDaysBetween(formObj.fm_dt.value , formObj.to_dt.value);
				
				if (days > 30){
					ComShowMessage("MT Return Period Should not exceed 1 month duration.");
					result = false;
				}				
			}	
		}
		
		else {

			if( formObj.s_ctrl_ofc_cd.value != "" || formObj.s_mt_rtn_cd.value != "" || formObj.s_cnee_no.value != "" || formObj.s_cust_nm.value !="" ){
				setNull();
				ComShowMessage(ComGetMsg("EAS90021", "", "", ""));
				result = false;
			}
			else if ( formObj.fm_dt.value != "" && formObj.to_dt.value == "" ){
				ComShowMessage("Please enter MT Return Period.");
				result = false;
			}
		}	
	return result;
		
}

function isInputField(formObj) {
	var result    = true ;

	if( document.form.s_ctrl_ofc_cd.value=="" ) {
		ComShowMessage("Please enter TRO Office Code.");
		result = false;
	}
	return result;
}

/**
 * Investigation Remark pup up. 
 * 
 */
function sheet1_OnDblClick(sheetObj, row, col ){
	
    if(col == 21){
    	var theURL = "ESD_EAS_0901.do?bkg_no=" + sheetObj.CellValue( row, 'bkg_no') + "&bl_no=" + sheetObj.CellValue( row, 'bl_no') + "&eas_expn_tp_cd=CO&rmk_ctnt_seq=1" + "&rmk_ctnt=" + sheetObj.CellValue( row, 'ctrt_no');
    	var winName = "ESD_EAS_0901";
    	var features = "width=700,height=365,toolbar=no,location=no,status=yes,menubar=no,scrollbars=auto,resizable=no,alwaysRaised,dependent,titlebar=no";
    	
    	ComOpenWindow(theURL,winName,features);
    }
}

	