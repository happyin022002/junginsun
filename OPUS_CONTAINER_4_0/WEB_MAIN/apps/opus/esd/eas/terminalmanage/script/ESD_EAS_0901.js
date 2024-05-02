/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : ESD_EAS_0901.jsp
*@FileTitle : Manage Remark Detail
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/

	/**
	 * @extends Bkg
	 * @class ESD_EAS_0901 : ex) business script for COD vs. TPB .
	 */
	function ESD_EAS_0901() {
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
    	doActionIBSheet(sheetObjects[0],document.form,SEARCH01);

	}
	
	/* Event handler processing by button name */
	function processButtonClick(){

		var sheetObject1 = sheetObjects[0];
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch(srcName) {
				case "btn_add":
					doActionIBSheet(sheetObject1,formObject,IBINSERT);
					break;
				case "btn_save":
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
					break;
				case "btn_close":
				    window.returnValue = null;
				    window.close();
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
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
		sheetObj.UseUtf8 = true;
		var cnt = 0;
		switch(sheetNo) {
			case 1:	  //IBSheet1 init
				with (sheetObj) {
					
					style.height = 240;
					
					// setting height of Head
					sheetObj.HeadRowHeight = 27;
					
					
					SheetWidth = mainTable.clientWidth;

					
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					
					MergeSheet = msHeaderOnly;

				   
					Editable = true;

					//setting Row information setting Row information [HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 6, 100);

					//setting Column information [COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(11, 1, 0, true);

					// setting function handling header
					InitHeadMode(true, true, true, true, false, false)

					var HeadTitle1 = "Booking Nbr|Seq|Remark|Update Date|Update Office|Update User";
	
					//Header Row info [ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					
					//Data Attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					initDataProperty(0, cnt++, dtData,      100,    daCenter, true,    	"bkg_no",			false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtData,       40,    daCenter, false,    "rmk_ctnt_seq",     false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtData,      250,    daLeft,   false,    "rmk_ctnt",     	false,          "",       dfNone,    0,     true,        true,	1000);
					InitDataProperty(0, cnt++, dtData,    	 80,    daCenter, false,    "upd_dt",      		false, 			"",    	  dfNone,    0,     false,       false); 
					InitDataProperty(0, cnt++, dtData,       90,    daCenter, false,    "cre_ofc_cd",      	false,          "",       dfNone,    0,     false,       false,	6);
					InitDataProperty(0, cnt++, dtData,       85,    daCenter, false,    "upd_usr_id",      	false,          "",       dfNone,    0,     false,       false,	20);
					InitDataProperty(0, cnt++, dtData,     85,    daCenter, false,    "bl_no",      		false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtData,     85,    daCenter, false,    "eas_expn_tp_cd",  	false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtData,     85,    daCenter, false,    "bkg_no_split",  	false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtData, 	 30,    daCenter, false,   	"op_code",		  	false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtStatus, 30,  daCenter, false,   	"ibflag",		  	false,          "",       dfNone,    0,     false,       false);
					WordWrap = true;
					sheetObj.DateFormatChar = "-";
					
				}
				break;
		}
	}


	
	/* handling sheet process */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		
		sheetObj.ShowDebugMsg = false;

		switch(sAction) {
		   case SEARCH01:	//retrieve  
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				formObj.f_cmd.value = SEARCH01;
				sheetObj.DoSearch4Post("ESD_EAS_0901GS.do", EasFrmQryString(formObj));
				break;
		   
		   case IBSAVE:	// save	
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}

				//rmk_ctnt setting
				sheetObj.CellValue(i,"rmk_ctnt") = formObj.s_rmk_ctnt.value;
			
				formObj.f_cmd.value   = MULTI01;
				sheetObj.DoSave("ESD_EAS_0901GS.do", EasFrmQryString(formObj));
				break;
			
			case IBINSERT:	  // input
				var Row = sheetObj.DataInsert(-1);
				var insertFlg = 1;
				sheetObj.CellValue(Row,"bkg_no")     = formObj.s_bkg_no.value;
				sheetObj.CellValue(Row,"cre_ofc_cd") = formObj.cre_ofc_cd.value;
				sheetObj.CellValue(Row,"upd_dt")     = formObj.login_date.value;
				sheetObj.CellValue(Row,"upd_usr_id") = formObj.cre_user_id.value;
				sheetObj.CellValue(Row,"rmk_ctnt_seq") = sheetObj.RowCount;
				sheetObj.CellValue(Row,"eas_expn_tp_cd") = formObj.s_eas_expn_tp_cd.value;
				sheetObj.CellValue(Row,"op_code")	 = "I"; 
//				sheetObj.RowStatus(Row)    = "I";
				break;
			
			case IBCLEAR:	   // Clear
				sheetObj.RemoveAll();
				break;

		}
	}	

	/**
	 * Handling Error Result
	 * IBSheetConfig.js - definie DataSheetObject.prototype.event_OnSearchEnd
	 */
	function sheet1_OnSearchEnd(sheetObj,errMsg){
	}
	
	/**
	 * Handling Error about result of saving 
	 * IBSheetConfig.js - define DataSheetObject.prototype.event_OnSaveEnd
	 */
	function sheet1_OnSaveEnd(sheetObj,errMsg){
		doActionIBSheet(docObjects[0],document.form,SEARCH01);
	}

	function sheet1_OnDblClick(sheetObj, Row,Col,Value){
		var formObj = document.form;
		var currentOfcCd = formObj.s_cre_ofc_cd.value;
		
		if(Col == 2){
			if(sheetObj.CellValue(Row, 'cre_ofc_cd') != currentOfcCd ){
				sheetObj.CellEditable(Row, 2) = false; 
				showErrMessage("Update by Only Created Office");
				return false;
				}
		}
	}


	function sheet1_OnChange(sheetObj, Row,Col,Value){
		if(Col != 2 && Col != 9 ){
//			sheetObj.RowStatus(Row) = "R";
		}else if(Col == 2){
			if(sheetObj.CellValue(Row, 'op_code')=="I" 
				&& (sheetObj.RowCount == sheetObj.CellValue(Row, 'rmk_ctnt_seq'))){
//				sheetObj.RowStatus(Row) = "I";
				sheetObj.CellValue(Row, 'op_code') = "I"
			}else{
//				sheetObj.RowStatus(Row) = "U";
				sheetObj.CellValue(Row, 'op_code') = "U"
			}
		}
	}	
 
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){

			//if (!isNumber(formObj.iPage)) {
			//	return false;
		   // }
		}
		
		return true;
	}

	function isInputField(formObj) {
		var result    = true ;
	
		if( document.form.s_cre_ofc_cd.value=="" ) {
			showErrMessage(getMsg('EAS90001'));
			result = false;
		}
		return result;
	}
	