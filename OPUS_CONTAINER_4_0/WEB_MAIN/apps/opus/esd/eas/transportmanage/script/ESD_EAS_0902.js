/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : ESD_EAS_0902.jsp
*@FileTitle : manage Remark Detail 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion : 
=========================================================*/

/* Global variables */

var curTab = 1;
var beforetab = 0;
var docObjects = new Array();
var sheetCnt = 0;

var isJORetrive = false; 


/**
 * initializing Sheetobjects 
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
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
	function setDocumentObject(sheet_obj){
		docObjects[sheetCnt++] = sheet_obj;
	}
	
	/**
	 * initializing Sheetobjects 
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
	function loadPage() {
		isReadOnly = document.form.s_readonly.value;	    
	    
		for(i=0;i<docObjects.length;i++){
		    
//			comConfigSheet(sheetObjects[i],SYSTEM_ENIS);
			ComConfigSheet(sheetObjects[i]);
			initSheet(docObjects[i],i+1);
			 
			comEndConfigSheet(docObjects[i]);
		}
		doActionIBSheet(docObjects[0],document.form,SEARCH01);
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
					
					// 헤더 높이 설정
					sheetObj.HeadRowHeight = 27;
					
					
					SheetWidth = mainTable.clientWidth;

					
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					
					MergeSheet = msHeaderOnly;

				   
					Editable = true;

					//setting Row information [HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 6, 100);

					//setting Column information [COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(10, 1, 0, true);

					// setting function handling header
					InitHeadMode(true, true, true, true, false, false)

					var HeadTitle1 = "Booking Nbr|Seq|Remark|Update Date|Update Office|Update User";
	
					//Header Row info [ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					
					//Data Attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					initDataProperty(0, cnt++, dtData,      100,    daCenter, true,    	"bkg_no",			false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       40,    daCenter, false,    "rmk_ctnt_seq",     false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,      250,    daLeft,   false,    "rmk_ctnt",     	false,          "",       dfNone,    0,     true,        true,	1000);
					InitDataProperty(0, cnt++, dtData,    	 80,    daCenter, false,    "upd_dt",      		false, 			"",    	  dfNone,    0,     false,       true); 
					InitDataProperty(0, cnt++, dtData,       90,    daCenter, false,    "cre_ofc_cd",      	false,          "",       dfNone,    0,     false,       true,	6);
					InitDataProperty(0, cnt++, dtData,       85,    daCenter, false,    "upd_usr_id",      	false,          "",       dfNone,    0,     false,       true,	20);
					InitDataProperty(0, cnt++, dtHidden,     85,    daCenter, false,    "bl_no",      		false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtHidden,     85,    daCenter, false,    "eas_expn_tp_cd",  	false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtHidden,     85,    daCenter, false,    "bkg_no_split",  	false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtHiddenStatus, 30,  daCenter, false,   	"ib_flag",		  	false,          "",       dfNone,    0,     false,   false);					
					WordWrap = true;
					sheetObj.DateFormatChar = "-";
					
				}
				break;
		}
	}

	/* Event handler processing by button click event */
	document.onclick = processButtonClick;
	
	/* Event handler processing by button name */	
	function processButtonClick(){

		 var sheetObject = docObjects[curTab-1];
		 /******************************************************/
		 var formObject = document.form;
		 if(curTab == 2)
			formObject = document.form2;
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "btn_add":
					doActionIBSheet(sheetObject,formObject,IBINSERT);
					break;
				case "btn_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;
				case "btn_close":
				    window.returnValue = null;
				    window.close();
				    break;
			} // end switch
	}
	
	/* handling sheet process */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		   case SEARCH01:	  
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				formObj.f_cmd.value = SEARCH01;
				sheetObj.DoSearch4Post("ESD_EAS_0902GS.do", EasFrmQryString(formObj));
				break;
		   
		   case IBSAVE:		
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				
				//setting eas_expn_tp_cd
				sheetObj.CellValue(i,"eas_expn_tp_cd") 	= formObj.s_eas_expn_tp_cd.value;
				//setting rmk_ctnt
				sheetObj.CellValue(i,"rmk_ctnt") = formObj.s_rmk_ctnt.value;
				
				formObj.f_cmd.value = MULTI01;
				sheetObj.DoSave("ESD_EAS_0902GS.do", EasFrmQryString(formObj));
				break;
			
			case IBINSERT:	  // input
				var Row = sheetObj.DataInsert(-1);
				var insertFlg = 1;
				sheetObj.CellValue(Row,"bkg_no") = formObj.s_bkg_no.value;
				sheetObj.CellValue(Row,"cre_ofc_cd") = formObj.s_cre_ofc_cd.value;
				sheetObj.CellValue(Row,"upd_dt") = getDateStrAdd(null, "", 0, "-");
				sheetObj.CellValue(Row,"upd_usr_id") = formObj.s_user_id.value;
				sheetObj.CellValue(Row,"rmk_ctnt_seq") = sheetObj.RowCount;
				sheetObj.RowStatus(Row) = "I";
				break;
			
			case IBCLEAR:	   //Clear
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
	 * process error result
	 * define DataSheetObject.prototype.event_OnSaveEnd in IBSheetConfig.js 
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

	/**
	 * Sheet1 onChange event
	 */
	function sheet1_OnChange(sheetObj, Row,Col,Value){
		if(Col != 2){
			sheetObj.RowStatus(Row) = "R";	
		}else{
			if(sheetObj.CellValue(Row, 'ib_flag')=="I" 
				&& (sheetObj.RowCount == sheetObj.CellValue(Row, 'rmk_ctnt_seq'))){
				sheetObj.RowStatus(Row) = "I";
			}else{
				sheetObj.RowStatus(Row) = "U";
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
	