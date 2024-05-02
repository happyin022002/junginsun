/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : ESD_EAS_0903GS.jsp
*@FileTitle : Route UnMatch List Detail 
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion :
=========================================================*/

	function ESD_EAS_0903() {
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
			case "btn_close":
			    window.returnValue = null;
			    window.close();
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
	 * comSheetObject(id)
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */
//	function setDocumentObject(sheet_obj){
//		docObjects[sheetCnt++] = sheet_obj;
//	}
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
		doActionIBSheet(sheetObjects[0],document.form,COMMAND01);
		doActionIBSheet(sheetObjects[1],document.form,COMMAND02);

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
					
					style.height = 100;
										
					
					SheetWidth = mainTable.clientWidth;

					
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					
					MergeSheet = msHeaderOnly;

				   
					Editable = true;

					//setting Row information [HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 2, 1, 10, 10);

					//setting Column information [COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(8, 0, 0, true);

					// setting function handling header
					InitHeadMode(true, true, true, true, false, false)

					var HeadTitle1 = "B/L Information|B/L Information|B/L Information|B/L Information|B/L Information|B/L Information|B/L Information|B/L Information";
					var HeadTitle2 = "BKG NO|B/L NO|RCV Term|DEL Term|POR|POL|POD|DEL";
	
					//Header Row info [ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);					
				   
					//Data Attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtData,      100,    daCenter, false,    "bkg_no",			false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,      100,    daCenter, false,    "bl_no",            false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "rcv_term",     	false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "del_term",      	false,          "",       dfNone,    0,     false,       true); 
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "bkg_por",          false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "bkg_pol",          false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "bkg_pod",          false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "bkg_del",          false,          "",       dfNone,    0,     false,       true);
														
				}
				break;
				
			case 2:	  //IBSheet2 init
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
					InitColumnInfo(17, 0, 0, true);

					// setting function handling header
					InitHeadMode(true, true, true, true, false, false)

					var HeadTitle1 = "S/O Detail|S/O Detail|S/O Detail|S/O Detail|S/O Detail|S/O Detail|S/O Detail|S/O Detail|S/O Detail|S/O Detail|S/O Detail|S/O Detail|S/O Detail|S/O Detail|S/O Detail|S/O Detail|S/O Detail";
					var HeadTitle2 = "SEQ|Container|T/S|ORG - DEST|Move|Office|S/O Date|User ID|S/O STS|CUR|S/O AMT|W/O NO|W/O Date|INV AMT|INV STS|INV User|S/O Remark";
	
					//Header Row info [ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);					
  
					//Data Attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtSeq,   	 40,    daCenter, false,    "seq",          false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,      100,    daCenter, false,    "cntr_no",     	false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       50,    daCenter, false,    "tp_sz",		false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,      150,    daCenter, false,    "org_dest",     false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       50,    daCenter, false,    "move",         false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       50,    daCenter, false,    "ofc_cd",     	false,          "",       dfNone,    0,     false,       true);

					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "so_date",      false,          "",       dfNone,    0,     false,       true); 
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "so_user",      false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "so_sts",       false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "curr",         false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "amt",          false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "wo_no",        false,          "",       dfNone,    0,     false,       true);

					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "wo_date",      false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "inv_amt",      false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       50,    daCenter, false,    "inv_sts",      false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "inv_user",     false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "so_rmk",       false,          "",       dfNone,    0,     false,       true);
															
				}
				break;
		}
	}


	
	/* handling sheet process */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		   case COMMAND01:	  // retrieve Detail Top 
				
				formObj.f_cmd.value = SEARCH01;
//				prompt('',"ESD_EAS_0903GS.do?"+EasFrmQryString(formObj));
//				return;
				sheetObj.DoSearch4Post("ESD_EAS_0903GS.do", EasFrmQryString(formObj));
				break;
				
				
		   case COMMAND02:	  //Detail Down 
				
				formObj.f_cmd.value = SEARCH02;
//				prompt('',"ESD_EAS_0903GS.do?"+EasFrmQryString(formObj));
//				return;
				sheetObj.DoSearch4Post("ESD_EAS_0903GS.do", EasFrmQryString(formObj));
				break;

			case IBCLEAR:	   //Clear
				sheetObj.RemoveAll();
				break;
			case IBDOWNEXCEL:  // excel 
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
	

/**
 * handling process for input validation
 */
function validateForm(formObj){

formObj = document.form;
	var result = true ;
	//  check condition
	if( !isInputField(formObj) ) {
		result = false ;
	}

	if( formObj.search_choice[0].checked == true ){
	
		if( isEmpty(formObj.somonth) || !chkMonthValue(formObj.somonth.value) ){
			showErrMessage(getMsg('EAS90001', 'S/O Month'));
			result = false;
		}
	}else if( formObj.search_choice[1].checked == true ){
	
		if( ( isEmpty(formObj.fromsodate) || !chkDateValue(formObj.fromsodate.value) ) && ( isEmpty(formObj.tosodate) || !chkDateValue(formObj.tosodate.value) ) ){
			showErrMessage(getMsg('EAS90001', 'S/O Date'));
			result = false;
			
		}
	}

	return result;
}

function isInputField(formObj) {
	var result    = true ;

	if( document.form.ctrl_ofc_cd.value=="" ) {
		showErrMessage(getMsg('EAS90001'));
		result = false;
	}
	return result;
}
	