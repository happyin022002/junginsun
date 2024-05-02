/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_EAS_0009.jsp
*@FileTitle : Drop-off Charge Collection Performance
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/

function ESD_EAS_0009() {
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
				InsertTab(0, "Dry Index" , 23 );
				InsertTab(1, "Tanker Index" , 23); 
				InsertTab(2, "Time Charter" , 23 );
				InsertTab(3, "Bunker Price" , 23 );
				InsertTab(4, "Ship Price" , 23); 
				InsertTab(5, "FFA Index" , 23 );
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
		    
//			comConfigSheet(sheetObjects[i],SYSTEM_ENIS);
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

	//Axon - start
	/**
	 *only upper case, numbers <br>
	 **/
	function engnum_keypress() {
//	    ComKeyOnlyAlphabet('uppernum');
	}

	/**
	 * BKG Creation manual <br>
	 **/
	function manual_click() {
	    // edit  bkg no case in manual
//	    form.boo_bkg_no.readOnly =!form.manual.checked;
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
//	    return ComChkObjValid(event.srcElement);
	}

	/**
	 * clear separator <br>
	 **/
	function obj_focus(){
//	    ComClearSeparator(event.srcElement);
	}

	/**
	 * only numbers <br>
	 **/
	function obj_keypress(){
//	    ComKeyOnlyNumber(event.srcElement);
	}

	//Axon  --- end
	
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
					InitRowInfo( 2, 1, 10, 10);

					//setting Column information [COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(12, 0, 0, true);

					// setting function handling header
					InitHeadMode(true, true, true, true, false, false)

					var HeadTitle = "SEQ|MT Return CY|Container Q'ty|Container Q'ty|Container Q'ty|Container Q'ty|Tariff Amount|Tariff Amount|Tariff Amount|Tariff Amount|TRO Amount|DOD Amount";
					var HeadTitle1 = "SEQ|MT Return CY|D2|D4|D5|Sum|D2|D4|D5|Sum|TRO Amount|DOD Amount";
					//Header Row info [ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);		
					InitHeadRow(1, HeadTitle1, true);		
				   
					//Data Attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtSeq,   	 40,    daCenter, true,     "seq",                  false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,      100,    daCenter, true,     "cntr_rtn_yd_cd",      	false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,      100,    daCenter, false,    "d2_qty",				false,          "",       dfNullInteger,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,      100,    daCenter, false,    "d4_qty",               false,          "",       dfNullInteger,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,      100,    daCenter, false,    "d5_qty",     			false,          "",       dfNullInteger,    	0,     false,       true);

					InitDataProperty(0, cnt++, dtData,      100,    daCenter, false,    "cntr_qty",   			false,          "",       dfNullInteger,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,      100,    daCenter, false,    "trf_d2_qty",      		false,          "",       dfNullInteger,    	0,     false,       true); 
					InitDataProperty(0, cnt++, dtData,      100,    daCenter, false,    "trf_d4_qty",         	false,          "",       dfNullInteger,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,      100,    daCenter, false,    "trf_d5_qty",         	false,          "",       dfNullInteger,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "trf_amt",              false,          "",       dfNullFloat,  0,     false,       true);
					
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, true,    "tro_amt",              false,          "",       dfNullFloat,  0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, true,     "dod_amt",              false,          "",       dfNullFloat,  0,     false,       true);
					
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
					ComOpenPopup('/opuscntr/COM_ENS_0041.do', 770, 470, 'getCustomer', '1,0,1,1,1,1,1,1');
				break;
				
                case "cnt_btn":         
                	with(formObject)
                	{    	    
                	    var v_cnt_cd = cnt_cd.value;
                	    var classId = "COM_ENS_00M1";
            		    var param = '?cnt_cd='+v_cnt_cd+'&classId='+classId;
            		    var v_display = "1,0,1,1,1,0,0";
            		    var chkStr = v_display.substring(0,3)
            		  
            		    if(chkStr == "1,0") {
            		        ComOpenPopup('/opuscntr/COM_ENS_00M1.do' + param, 565, 480, 'getCOM_ENS_00M1_1', v_display, true);
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
	

    function getCOM_ENS_0M1_1(rowArray) {
    	
    	var colArray = rowArray[0];	
    	document.all.cnt_cd.value = colArray[3];
    	document.all.cnt_nm.value = colArray[4];
 
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
//				prompt('',"ESD_EAS_009GS.do?"+EasFrmQryString(formObj));
//				return;
				sheetObj.DoSearch4Post("ESD_EAS_0009GS.do", EasFrmQryString(formObj));
				break;	 
			case IBCLEAR:	   
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


//Change Office
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
	if( obj.name == "fromtrodate" || obj.name == "totrodate" ) {
		selectWhere();
	}	
}

function selectWhere() {

		if ( document.form.fromtrodate.value == "yyyymmdd" ){
			document.form.fromtrodate.value = "";
			document.form.fromtrodate.focus();
		}	
		
		if ( document.form.totrodate.value == "yyyymmdd" ){
			document.form.totrodate.value = "";
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
		
	if( ComIsEmpty(formObj.fromtrodate) || ComIsEmpty(formObj.totrodate) || formObj.totrodate =='yyyymmdd'){
		ComShowMessage("Please enter TRO Period.");
		result = false;
		
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
	