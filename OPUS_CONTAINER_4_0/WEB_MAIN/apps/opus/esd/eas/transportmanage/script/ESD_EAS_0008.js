/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_EAS_0008.js
*@FileTitle : Drop Off Charge Collection Inqury List
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/


function ESD_EAS_0008() {
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
	 * define IBTab Object initializing
	 * tab ID tab1,tab2,...
	 * call setupPage() before loadPage() 
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
	 * tab1 onChange event
	 */
	 
	function tab1_OnChange(nItem){
		ChangeTab(document.all.tab1,nItem);
	}
	
	/**
	 * disply when click IBTab Object
	 * Grouping by  DIV TAG ID: "tabLayer"
	 */
	function ChangeTab(tabObj,nItem){
		tabObj.BackColor="#FFFFFF";
		tabObj.TabBackColor(nItem)="146,174,230";
	
		var objs = document.all.item("tabLayer");
		objs[beforetab].style.display = "none";
		objs[nItem].style.display = "Inline";
	
		//--------------- Notice--------------------------//
		//objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
		//ksw : Can not click zIndex below -2
		objs[beforetab].style.zIndex = 0;
		objs[nItem].style.zIndex = 9;
		//------------------------------------------------------//
		beforetab= nItem;
	}

	/**
	 * registering IBSheet Object as list
	 * comSheetObject(id)
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
	    //Axon event
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
					
					style.height = 280;
										
					
					SheetWidth = mainTable.clientWidth;

					
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					
					MergeSheet = msHeaderOnly;

				   
					Editable = true;

					//setting Row information [HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 10, 10);

					//setting Column information [COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(17, 0, 0, true);

					// setting function handling header
					InitHeadMode(true, true, true, true, false, false)

					var HeadTitle = "SEQ|TRO Office|Booking|B/L|Import Merchant|Container No.|T/S|POR|POL|POD|DEL|TRO Date|MT Return CY|Curr|Tar Amt|TRO Amt|DOD Amt";
	
					//Header Row info [ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);		
				   
					//Data Attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtSeq,   	 40,    daCenter, true,     "seq",              false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       60,    daCenter, false,    "cre_ofc_cd",       false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,      100,    daCenter, false,    "bkg_no",			false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       90,    daCenter, false,    "bl_no",            false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,      200,    daLeft, false,    "cust_cd",     		false,          "",       dfNone,    	0,     false,       true);

					InitDataProperty(0, cnt++, dtData,       90,    daCenter, false,    "cntr_no",      	false,          "",       dfNone,    	0,     false,       true); 
					InitDataProperty(0, cnt++, dtData,       30,    daCenter, false,    "cntr_tpsz_cd",     false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       50,    daCenter, false,    "por_cd",           false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       50,    daCenter, false,    "pol_cd",           false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       50,    daCenter, false,    "pod_cd",           false,          "",       dfNone,    	0,     false,       true);
					
					InitDataProperty(0, cnt++, dtData,       50,    daCenter, false,    "del_cd",           false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "cre_dt",           false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       100,    daCenter, false,    "cntr_rtn_yd_cd",   false,          "",       dfNone,   	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       30,    daCenter, false,    "curr_cd",          false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       60,    daCenter, false,    "tar_amt",          false,          "",       dfNullFloat,  0,     false,       true);
					
					InitDataProperty(0, cnt++, dtData,       60,    daCenter, false,    "tro_amt",          false,          "",       dfNullFloat,  0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       60,    daCenter, false,    "dod_amt",          false,          "",       dfNullFloat,  0,     false,       true);
					
					//sheetObj.ColHidden("bkg_no_split") = true;
				}
				break;
		}
	}

	/* Event handler processing by button click event */
	document.onclick = processButtonClick;
	
	/* Event handler processing by button name */	
	function processButtonClick(){

		 var sheetObject = sheetObjects[curTab-1];
		 /******************************************************/
		 var formObject = document.form;
		 if(curTab == 2)
			formObject = document.form2;
			
		try {
			
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "bttn_add":
					   doActionIBSheet(sheetObject,formObject,IBINSERT);
					break;
				case "bttn_cancel":
					   doActionIBSheet(sheetObject,formObject,IBSEARCH);
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
					 cal.select(formObject.s_sdate, 's_sdate', 'yyyy-MM-dd');
					break;
				case "btns_calendar2":
					var cal = new calendarPopupFromTo();
					cal.displayType = "date";
					cal.select(formObject.s_sdate, 's_sdate',formObject.s_edate, 's_edate', 'yyyy-MM-dd');
					break;
				case "btns_office": 
				//if( validation_check() ) {
					var ofc_cd = formObject.ctrl_ofc_cd.value;
					ComOpenWindow('ESD_EAS_COM_0001.screen?ctrl_ofc_cd='+ofc_cd, 'ESD_EAS_COM_0001', 'top=200, left=200, width=410, height=400, toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=0');
				//}
				break;
				case "btns_cust": 
					ComOpenPopup('/opuscntr/COM_ENS_041.do', 770, 470, 'getCustomer', '1,0,1,1,1,1,1,1');
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
	
	function getCustomer(rArray){
		var cArray = rArray[0];
		
		document.form.cust_cd.value = cArray[3];		
		document.form.cust_nm.value = cArray[4]; 
    }	
	/* handling sheet process */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		   case IBSEARCH:	  
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				formObj.f_cmd.value = SEARCH;
//				prompt('',"ESD_EAS_0008GS.do?"+EasFrmQryString(formObj));
//				return;
				sheetObj.DoSearch4Post("ESD_EAS_0008GS.do", EasFrmQryString(formObj));
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
		document.form.totrodate.focus();
	}
}

function selectText(obj) {
	//alert("obj.name : "+obj.name);
	if( obj.name == "tromonth" ) {
		document.form.search_choice[0].checked = true;
	}else if( obj.name == "fromtrodate" || obj.name == "totrodate" ) {
		document.form.search_choice[1].checked = true;
	}
	
	selectWhere();
}


function selectWhere() {

	if( document.form.search_choice[0].checked == true ) {

		document.form.tromonth.disabled = false;
		document.form.tromonth.value = "";
		document.form.tromonth.focus();
			
		document.form.search_choice[1].checked = false;
		document.form.fromtrodate.value = "yyyymmdd";
		document.form.fromtrodate.disabled = true;
		document.form.totrodate.value = "yyyymmdd";
		document.form.totrodate.disabled = true;
				
	} else if( document.form.search_choice[1].checked == true ) {

		document.form.fromtrodate.disabled = false;
		document.form.totrodate.disabled = false;
		if ( document.form.fromtrodate.value == "yyyymmdd" ){
			document.form.fromtrodate.value = "";
			document.form.fromtrodate.focus();
		}	
		
		if ( document.form.totrodate.value == "yyyymmdd" ){
			document.form.totrodate.value = "";
		}

		document.form.search_choice[0].checked = false;
		document.form.tromonth.value = "yyyymm";
		document.form.tromonth.disabled = true;
	
	}

}


/**
 * handling process for input validation
 */
function validateForm(formObj){

formObj = document.form;
	var result = true ;
	// check condition
	if( !isInputField(formObj) ) {
		result = false ;
	}

	if( formObj.search_choice[0].checked == true ){
	
		if( ComIsEmpty(formObj.tromonth) || !chkMonthValue(formObj.tromonth.value) ){
			ComShowMessage("Please enter TRO Month.");
			result = false;
		}
	}else if( formObj.search_choice[1].checked == true ){
	
		if( ComIsEmpty(formObj.fromtrodate) || ComIsEmpty(formObj.totrodate) ){
			ComShowMessage("Please enter TRO Period.");
			result = false;
			
		}
	}

	return result;
}

function isInputField(formObj) {
	var result    = true ;

	if( document.form.ctrl_ofc_cd.value=="" ) {
		ComShowMessage("Please enter TRO Office Code.");
		result = false;
	}
	return result;
}
	