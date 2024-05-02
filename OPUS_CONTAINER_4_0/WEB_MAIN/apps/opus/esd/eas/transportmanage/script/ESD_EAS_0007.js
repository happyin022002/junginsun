/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_EAS_0007.js
*@FileTitle : Drop Off Charge Tariff List
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
=========================================================*/

function ESD_EAS_0007() {
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
	
	var shtObj = null ;
	var sheetrow = 0;

/* Event handler processing by button click event */
document.onclick = processButtonClick;

/* Event handler processing by button name */	
function processButtonClick(){

	 var sheetObject = sheetObjects[0];
	
	 var formObject = document.form;
		
	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
			case "bttn_addloc":
				   doActionIBSheet(sheetObject,formObject,IBINSERT);
				break;
			case "bttn_addts":
				   doActionIBSheet(sheetObject,formObject,IBCOPYROW);
				break;					
			case "bttn_save":
				//zu_openRunning(false); 
				sheetObject.WaitImageVisible = false;
				doActionIBSheet(sheetObject,formObject,IBSAVE);
				break;
			//case "bttn_remove":
			//	doActionIBSheet(sheetObject,formObject,IBDELETE);
			//	break;
			case "btn_downexcel":
				sheetObject.ExcelPrint = "";
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
				break;
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
			case "btn_new":
				sheetObject.RemoveAll();
				formObject.reset();
				break;
			case 'btn_customer':
				popCustomer();
				break;
            case "cnt_btn":         
            	with(formObject)
            	{    	    
            	    var v_cnt_cd = sel_cnt_cd.value;
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
	//initializing html controller 
	initControl();
	
	//fun_getEUROffcd();		
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
	 *  Check Validation <br>
	 **/
	function obj_blur(){

	//    return ComChkObjValid(event.srcElement);
		
		
	}

	/**
	 * clear Separator <br>
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

	//Axon --- end
	

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
					
					style.height = GetSheetHeight(15) ;
										
					
					SheetWidth = mainTable.clientWidth;

					
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					
					MergeSheet = msHeaderOnly;

				   
					Editable = true;

					//setting Row information [HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 10, 10);

					//setting Column information [COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(12, 0, 0, true);

					// setting function handling header
					InitHeadMode(true, true, true, true, false, false)

					var HeadTitle = "Del.|Del.|Eff_dt|Loc|Customer|Origin|T/S|Currency|Amount|User ID|Remark|Cre_Offce";
	
					//Header Row info [ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);		
				   
					//Data Attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtDelCheck,     40,    daCenter, false,    "r_chk",		      false,          "",       dfNone,    0,     true,     true);
                    InitDataProperty(0, cnt++, dtHiddenStatus, 30,    daCenter, false,    "ibflag",		  false,          "",       dfNone,    0,     false,   false);					
					InitDataProperty(0, cnt++, dtHidden,      100,    daCenter, false,    "effdt",            false,          "",       dfNone,    0,     false,   false);
					InitDataProperty(0, cnt++, dtData,        100,    daCenter, false,    "fm_loc_cd",         true,          "",       dfEngUpKey,0,     false,    true,   5);
					InitDataProperty(0, cnt++, dtPopupEdit,   100,    daCenter, false,    "cust_info",        false,          "",       dfEngUpKey,0,     false,    true,   8);					
					InitDataProperty(0, cnt++, dtCombo,       100,    daCenter, false,    "conti_cd",         false,          "",       dfNone,    0,     true,     true);
					InitDataProperty(0, cnt++, dtData,         50,    daCenter, false,    "cntr_tp_cd",		   true,          "",       dfEngUpKey,0,     false,    true,   2);
					InitDataProperty(0, cnt++, dtData,         90,    daCenter, false,    "curr_cd",           true,          "",       dfEngUpKey,0,     false,    true,   3);
					InitDataProperty(0, cnt++, dtData,         90,    daRight,  false,    "chrr_frt_tax_val", false,          "",       dfNumber,  4,     false,    true,  15); 
					InitDataProperty(0, cnt++, dtData,        100,    daCenter, false,    "cre_usr_id",       false,          "",       dfNone,    0,     false,    false,  20); 
					InitDataProperty(0, cnt++, dtData,        100,    daLeft,   false,    "cust_rmk",         false,          "",       dfNone,    0,     true,     true, 250);
					InitDataProperty(0, cnt++, dtHidden,      100,    daCenter, false,    "cre_ofc_cd",       false,          "",       dfNone,    0,     false,   false);
					
					InitDataCombo(0, "conti_cd", " |Asia|America|Europe|Africa", " |A|M|E|F");
				}
				break;
				
		}
	}



function getCOM_ENS_0M1_1(rowArray) {
	
	var colArray = rowArray[0];	
	document.all.sel_cnt_cd.value = colArray[3];
	document.all.sel_cnt_nm.value = colArray[4];
	
	fun_CntEffData();

}	
/* handling sheet process */
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
	   case IBSEARCH:	  
		
			if(!validateForm(formObj)) {
				return false;
			}
						
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch4Post("ESD_EAS_0007GS.do", EasFrmQryString(formObj));
			break;

		case IBCLEAR:	   
			sheetObj.RemoveAll();
			break;
		case IBDOWNEXCEL:  
			sheetObj.SpeedDown2Excel(true);
			break;
		case IBINSERT:
			var isEUR = null;
			isEUR = formObj.ctrl_ofc_cd.value;
			
			if( isEUR == null && formObj.ctrl_user_id.value != 'system1'  ) {
				ComShowCodeMessage("EAS90011");
				return false;
			}
		      var Row = sheetObj.DataInsert();
		      
		      sheetObj.CellValue(Row, "cre_usr_id") = formObj.ctrl_user_id.value;
		      break;		
		case IBCOPYROW:
		      var row = sheetObj.DataCopy();
		      sheetObj.CellValue(row, "cntr_tp_cd") = "";
		      sheetObj.CellValue(row, "chrr_frt_tax_val") = "";
		      sheetObj.CellValue(row, "cre_usr_id") = formObj.ctrl_user_id.value;
		      sheetObj.CellValue(row, "cre_ofc_cd") = formObj.ctrl_ofc_cd.value;
		      
		      break;	
		case IBDELETE:
		      sheetObj.RowDelete(sheetObj.CheckedRows, false);		      
		      break;			
        case IBSAVE:       
			
			if(!validateForm(formObj)) {
                return false;
            } 
            
            if(!verifyLocCd(sheetObj)||!verifyCustCd(sheetObj)||!verifyTpszCd(sheetObj)||!verifyCurrCd(sheetObj)){
				return false;            	
	        }

	        if(sheetObj.CheckedRows("r_chk")==0){
	            if(!checkDupData(sheetObj)){
					return;            	
	            }
	        }
	        
            formObj.f_cmd.value = MULTI;
           	sheetObj.DoSave("ESD_EAS_0007GS.do" ,EasFrmQryString(formObj));                
            break;  			            		      		
	}
}


function sheet1_OnPopupClick(sheetObj, row, col){
	var colName = sheetObj.ColSaveName(col) ;
	
	if(colName=="cust_info" ){

		openCustPopSheet(sheetObj, row ) ;
	}
}

// date format yyyy-mm-dd
function addBar() {
	var dat="";
	var dt = document.form.newEffDate.value;
	if( dt.length == 8 ) {
		dat = dt.substr(0,4) + '/' + dt.substr(4,2) + '/' + dt.substr(6,2);
		document.form.newEffDate.value = dat;
	}
}


/**
 *  Customer Code Open Common Pop-up Screen(sheet)
 */
function openCustPopSheet(sheetObj, row ){
	sheetrow = row;
	shtObj = sheetObj;
	
	ComOpenPopup('/opuscntr/COM_ENS_041.do', 770, 470, 'setCustPopSheet', '1,0,1,1,1,1,1,1');
}


function setCustPopSheet( rowArray ) {

	var colArray = '';
	
	if(rowArray.length>0)
	{
		shtObj.CellValue(sheetrow, "cust_info") = rowArray[0][3];
	}
	
}

function sheet1_OnClick(sheetObj, Row,Col,Value){
	var isEUR = null;
	isEUR = document.form.ctrl_user_id.value;
	
	if( Col == 5) {
		if( isEUR !=  sheetObj.CellValue(Row, "cre_usr_id") ){
			ComShowCodeMessage("EAS90012");			
			return false;
		}
	}
	if( Col == 10) {
		if( isEUR !=  sheetObj.CellValue(Row, "cre_usr_id") ){
			ComShowCodeMessage("EAS90012");	
			return false;
		}
	}
}

function sheet1_OnChange(sheetObj, Row,Col,Value){
	var isEUR = null;
	isEUR = document.form.ctrl_ofc_cd.value;
	var formObj = document.form;
	
	formObj.s_loc_cd.value 		= sheetObj.CellValue(Row, "fm_loc_cd");
	formObj.s_cust_info.value 	= sheetObj.CellValue(Row, "cust_info");
	formObj.s_cntr_tp_cd.value 	= sheetObj.CellValue(Row, "cntr_tp_cd");
	formObj.s_curr_cd.value 	= sheetObj.CellValue(Row, "curr_cd");
	formObj.s_conti_cd.value 	= sheetObj.CellValue(Row, "conti_cd");

	if( Col == 0 ) {		
		if( isEUR !=  sheetObj.CellValue(Row, "cre_ofc_cd") ){
			ComShowCodeMessage("EAS90013");
			sheetObj.CellValue2(Row, "r_chk") = 0;
			return false;
		}
	}
}

function checkDupData(sheetObj){
	var dupCnt = '';
	var formObj = document.form;
	
	formObj.f_cmd.value = SEARCH02;
	sheetObj.DoSearch4Post("ESD_EAS_0007GS.do", EasFrmQryString(formObj));
	
	dupCnt = sheetObj.EtcData("dupCnt") ;
	
	if(dupCnt > 0){
		ComShowCodeMessage("EAS90014");
		return false;
	}
	return true;
}

function verifyLocCd(sheetObj){
	var locCnt = '';
	var formObj = document.form;
	
	formObj.f_cmd.value = SEARCH03;
	sheetObj.DoSearch4Post("ESD_EAS_0007GS.do", EasFrmQryString(formObj));
	
	locCnt = sheetObj.EtcData("locCnt") ;
	
	if(locCnt > 0){
		return true;
	}else{
		ComShowCodeMessage("EAS90015");
		return false;	
	}
}

function verifyCustCd(sheetObj){
	var custCnt = '';
	var custInfo = '';
	var formObj = document.form;
	
	formObj.f_cmd.value = SEARCH04;
	sheetObj.DoSearch4Post("ESD_EAS_0007GS.do", EasFrmQryString(formObj));
	
	custCnt 	= sheetObj.EtcData("custCnt");
	custInfo	= sheetObj.EtcData("custInfo");
	
	if(custCnt > 0 || custInfo == 'CO0'){
		return true;
	}else{
		ComShowCodeMessage("EAS90016");
		return false;	
	}
}

function verifyTpszCd(sheetObj){
	var tpszCnt = '';
	var formObj = document.form;
	
	formObj.f_cmd.value = SEARCH05;
	sheetObj.DoSearch4Post("ESD_EAS_0007GS.do", EasFrmQryString(formObj));
	
	tpszCnt = sheetObj.EtcData("tpszCnt") ;
	
	if(tpszCnt > 0){
		return true;
	}else{
		ComShowCodeMessage("EAS90017");
		return false;	
	}
}

function verifyCurrCd(sheetObj){
	var currCnt = '';
	var formObj = document.form;
	
	formObj.f_cmd.value = SEARCH06;
	sheetObj.DoSearch4Post("ESD_EAS_0007GS.do", EasFrmQryString(formObj));
	
	currCnt = sheetObj.EtcData("currCnt") ;
	
	if(currCnt > 0){
		return true;
	}else{
		ComShowCodeMessage("EAS90018");
		return false;	
	}
}

/*
function sheet1_OnSaveEnd(sheetObj, errMsg){
	var formObj = document.form;
	
	if(errMsg==""){
		doActionIBSheet(sheetObj,formObj,IBSEARCH);	
		showErrMessage('') ;
	}
}
*/

function upperCase(obj) {
	obj.value = obj.value.toUpperCase();
	
}

function selectText(obj) {

	if( obj.name == "sel_cnt_cd" || obj.name == "sel_cnt_nm" ) {
		document.form.search_choice[0].checked = true;
	}else if( obj.name == "cust_cnt_seq" || obj.name == "cust_nm" ) {
		document.form.search_choice[1].checked = true;
	}
	
	selectWhere();
}


function selectWhere() {

	if( document.form.search_choice[0].checked == true ) {

		document.form.sel_cnt_cd.value = "";
		document.form.sel_cnt_cd.focus();
		document.form.sel_cnt_nm.value = "";
			
		document.form.search_choice[1].checked = false;
		document.form.cust_cnt_seq.value = "";
		document.form.cust_nm.value = "";
				
	} else if( document.form.search_choice[1].checked == true ) {

		document.form.cust_cnt_seq.value = "";
		document.form.cust_cnt_seq.focus();
		document.form.cust_nm.value = "";
		
		document.form.search_choice[0].checked = false;
		document.form.sel_cnt_cd.value = "";
		document.form.sel_cnt_nm.value = "";
	
	}

}


/**
 * handling process for input validation
 */
function validateForm(formObj){

	var result = true ;
	// check condition
	if( !isInputField(formObj) ) {
		result = false ;
	}else if( formObj.s_type.value == 'null' ){
		ComShowCodeMessage("EAS90019");
		result = false;
	}                                                                                                                                                                                                                                                                                                                 

	return result;
}

function isInputField(formObj) {
	var result    = true ;

	if( ComIsEmpty(formObj.sel_cnt_cd) && ComIsEmpty(formObj.cust_cnt_seq) ) {
		ComShowCodeMessage("EAS90020");
		
		result = false;
	}
	return result;
}


function fun_CntEffData(){

	var strlen = document.form.sel_cnt_cd.value.length;

	if( strlen > 1 ){

		fun_getEffDate();
	}
}

function fun_CustEffData(){

	var strlen = document.form.cust_cnt_seq.value.length;

	if( strlen > 2 ){
		//alert(document.form.sel_cnt_cd.value.toUpperCase() );
		fun_getEffDate();
	}	
}

// Effect Date Combo  Logic
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
		showErrMessage("Erroe Request XMLHttp");
	}
}

// case in sel_cnt_cd 
function fun_getEffDate() {
	var doc_cncd = document.form.sel_cnt_cd.value.toUpperCase();
	var doc_cust_cnt_seq = document.form.cust_cnt_seq.value.toUpperCase();

	if( doc_cncd != null || doc_cust_cnt_seq != null ) {
	
		var url = "ESD_EAS_0007GS.do?f_cmd="+SEARCH11+"&sel_cnt_cd="+doc_cncd+"&cust_cnt_seq="+doc_cust_cnt_seq;
		createHttpRequest();
		request.open("GET", url, true);

		request.onreadystatechange = subCntorlOffice;
		
		request.send(null);
	} else {
		//document.form.ctrl_ofc_cd.value = document.form.old_ofc_cd.value;
		alert("doc_cncd is null");
	}
}

// get Effect Date
function subCntorlOffice() {

	if( request.readyState == 4 ) {
		if( request.status == 200 ) {
			var docXml = request.responseXML;
			var rowXml = docXml.getElementsByTagName("EffDate");
			var skxml = docXml.getElementsByTagName("sub-sortKey");
			var cdxml = docXml.getElementsByTagName("sub-code");
			var nmxml = docXml.getElementsByTagName("sub-name");
			
			var sortKeyXml = null;
			var codeXml = null;
			var nameXml = null;
			
			var text_effS = "";
			var text_effM = "";
			var text_effE = "";
				
			//text_effS = "<select style=\"width:100;\" name=\"s_type\" onChance=\"fncselEff();\" >&nbsp;";
			text_effS = "<select style=\"width:100;\" name=\"s_type\" >&nbsp;";

			if( rowXml.length > 0 ){
			
				for( var i = 0; i < rowXml.length; i++ ) {
							
					sortKeyXml = skxml[i].childNodes[0].nodeValue;
					codeXml = cdxml[i].childNodes[0].nodeValue;
					nameXml = nmxml[i].childNodes[0].nodeValue;					

					if( i == 0){
						text_effM = text_effM + "<OPTION value=\"" + codeXml + "\" selected >"+nameXml+"</OPTION>";
					}else{
						text_effM = text_effM + "<OPTION value=\"" + codeXml + "\" >"+nameXml+"</OPTION>";
					}
				}
			}
		
			text_effE = "</SELECT>";
			
			if( text_effM.length < 1 ) {
				text_effM = "<OPTION value=\"null\" selected >No Data</OPTION>";
			}
			
			document.form.all.ScriptDiv.innerHTML = text_effS+text_effM+text_effE;
		}

	}

}


/**
 * customer popup
 */
function popCustomer(){
	ComOpenPopup('/opuscntr/COM_ENS_041.do', 770, 470, 'setCustomerPop', '1,0,1,1,1,1,1,1');
}

/**
 * customer pop up
 */
function setCustomerPop(rowArray){
	var formObj = document.form;
	var colArray = '';
	
	if(rowArray.length>0)
	{
		formObj.cust_cnt_seq.value = rowArray[0][3];
		formObj.cust_nm.value = rowArray[0][4];
		
		fun_CustEffData();
	}

}

/**
 Euro Office code 
*/
function fun_getEUROffcd() {
		var url = "ESD_EAS_0007GS.do?f_cmd="+SEARCH01;
		createHttpRequest();
		request.open("GET", url, false);

		request.onreadystatechange = fncEUROffcd;
		
		request.send(null);

}

function fncEUROffcd() {
	if( request.readyState == 4 ) {
		
		if( request.status == 200 ) {
			
			var docXml = request.responseXML;
			//alert(docXml.xml);
			var rowXml = docXml.getElementsByTagName("EUROFFCD");
			var skxml = docXml.getElementsByTagName("sub-sortKey");
			
			var sortKeyXml = null;
			var codeXml = null;
			var nameXml = null;
			
			var text_effS = "";
			var text_effM = "";
			var text_effE = "";

			Dictionary ();
							

			if( rowXml.length > 0 ){
			
				for( var i = 0; i < rowXml.length; i++ ) {
					sortKeyXml = skxml[i].childNodes[0].nodeValue;
					put(sortKeyXml, sortKeyXml);
				}
				
			}
		}
	}
}

//******************************************************************

function Dictionary () {

    this.nodeObject = new Object();
    this.put = put;
    this.get = get;
    this.keys = keys;
    this.del = del;
}

function put(key, value)
{
    obj = this.nodeObject;

    searchFlag = 0;

    for(var n in obj) {
        if(n == key) {
            obj[key] = value;
            searchFlag = 1;
        }
    }

    if(searchFlag == 0) {
        obj[key] = value;
    }
}


function get(key) {
    obj = this.nodeObject;

    return obj[key];
}

function keys(){
    return this.nodeObject;
}

function del(key) {
    this.put(key, null);
}


	