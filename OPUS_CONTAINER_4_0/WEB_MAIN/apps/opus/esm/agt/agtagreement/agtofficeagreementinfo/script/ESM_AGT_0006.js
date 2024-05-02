// Common Global Variables


var sheetObjects = new Array();
var sheetCnt = 0;
var IBSEARCH01  = 29;
var IBSEARCH02  = 30;
var IBSEARCH03  = 31;
var IBSEARCH04  = 32;
var IBSEARCH05  = 33;
var IBSEARCH06  = 34;
var IBSEARCH07  = 35;
var IBSEARCH08  = 36;
var IBSEARCH09  = 37;

/* Event handler processing by button click event */
document.onclick = processButtonClick;

/* Event handler processing by button name */
	function processButtonClick(){
		 /***** Setting the additional Sheet variable when each tab has more than 2 sheets *****/
		 var sheetObject = sheetObjects[0];
		 var sheetObject1 = sheetObjects[1];
		 var sheetObject2 = sheetObjects[2];
		 var sheetObject3 = sheetObjects[3];
		 var sheetObject4 = sheetObjects[4];

		 /*******************************************************/
		 var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

				case "btn_ok":
					  comPopupOK();
				  break;

				case "btn_close":
					  window.close();
				  break;

			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(ComGetMsg("COM12111", "", "", ""));
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
	function setSheetObject(sheet_obj)
	{
		sheetObjects[sheetCnt++] = sheet_obj;
	}

	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen
	 */
	function loadPage() {

		for(i=0;i<sheetObjects.length;i++){

		//khlee-Changing Start Environment Setting Method's Name
			ComConfigSheet(sheetObjects[i]);

			initSheet(sheetObjects[i],i+1);
		//khlee-Adding Last Environment Setting method
			ComEndConfigSheet(sheetObjects[i]);
		}
		var sheetObject = sheetObjects[0];
		var sheetObject1 = sheetObjects[1];
		var sheetObject2 = sheetObjects[2];
		var sheetObject3 = sheetObjects[3];
		var sheetObject4 = sheetObjects[4];
		var formObject = document.form;
		if(formObject.agn_seq.value != ""){
			doActionIBSheet(sheetObject,formObject,IBSEARCH01);
			doActionIBSheet(sheetObject1, formObject, IBSEARCH02);
			doActionIBSheet(sheetObject2,formObject,IBSEARCH03);
			doActionIBSheet(sheetObject3,formObject,IBSEARCH04);
			doActionIBSheet(sheetObject4,formObject,IBSEARCH05);
		}else{
			doActionIBSheet(sheetObject,formObject,IBSEARCH01);
		}
	   	
	}

   /**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {

		var cnt = 0;

		switch(sheetNo) {
			case 1:	  //sheet1 init
				with (sheetObj) {
					// setting height
					style.height = GetSheetHeight(5) ;
					//Whole setting width
					SheetWidth = mainTable.clientWidth;

					//setting Host information[mandatory][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//Whole Merge kind [Optional, Default msNone]
					MergeSheet = msHeaderOnly;

				   //Edit kind [Optional, Default false]
					if(document.form.pageType.value != "Inquiry"){
						Editable = true;
					}else{
						Editable = false;
					}

					//setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 0, 1, 9, 100);

					//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(5, 0 , 0, true);

					// setting function handling header
					InitHeadMode(true, true, false, true, false,false) ;

					var HeadTitle = "STS|No|CHK|Code|Name";

					//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//Data  properties	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	 0,	daCenter,	false,	"",			false,		"",	   dfNone,		0,	 false,	  true);
					InitDataProperty(0, cnt++ , dtSeq,			30,	daCenter,	false,	"",			false,		"",	   dfNone,		0,	 true,	   true);
					InitDataProperty(0, cnt++ , dtCheckBox,		30,	daCenter,	false,	"checkbox",	false,		"",	   dfNone,		0,	 true,	   true);
					InitDataProperty(0, cnt++ , dtData,			40,	daCenter,	false,	"conti_cd",		false,		"",	   dfNone,		0,	 false,	   false);
					InitDataProperty(0, cnt++ , dtData,			70,	daCenter,	false,	"conti_nm",		false,		"",	   dfNone,		0,	 false,	   false);

					CountPosition = 0 ;
//					AllowEvent4CheckAll = true;
				}
				break;
			case 2:	  //sheet1 init
				with (sheetObj) {
					// setting height
					style.height = GetSheetHeight(5) ;
					//Whole setting width
					SheetWidth = mainTable.clientWidth;

					//setting Host information[mandatory][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//Whole Merge kind [Optional, Default msNone]
					MergeSheet = msHeaderOnly;

				   //Edit kind [Optional, Default false]
					if(document.form.pageType.value != "Inquiry"){
						Editable = true;
					}else{
						Editable = false;
					}

					//setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 0, 1, 9, 100);

					//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(5, 0 , 0, true);

					// setting function handling header
					InitHeadMode(true, true, false, true, false,false) ;

					var HeadTitle = "STS|No|CHK|Code|Name";

					//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//Data  properties	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	 0,	daCenter,	false,	"",			false,		"",	   dfNone,		0,	 false,	  true);
					InitDataProperty(0, cnt++ , dtSeq,			30,	daCenter,	false,	"",			false,		"",	   dfNone,		0,	 true,	   true);
					InitDataProperty(0, cnt++ , dtCheckBox,		30,	daCenter,	false,	"checkbox",	false,		"",	   dfNone,		0,	 true,	   true);
					InitDataProperty(0, cnt++ , dtData,			40,	daCenter,	false,	"sconti_cd",		false,		"",	   dfNone,		0,	 false,	   false);
					InitDataProperty(0, cnt++ , dtData,			70,	daCenter,	false,	"sconti_nm",		false,		"",	   dfNone,		0,	 false,	   false);
					CountPosition = 0 ;
				}
				break;
			case 3:	  //sheet3 init
				with (sheetObj) {
					// setting height
					style.height = GetSheetHeight(11) ;
					//Whole setting width
					SheetWidth = mainTable.clientWidth;

					//setting Host information[mandatory][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//Whole Merge kind [Optional, Default msNone]
					MergeSheet = msHeaderOnly;

				   //Edit kind [Optional, Default false]
					if(document.form.pageType.value != "Inquiry"){
						Editable = true;
					}else{
						Editable = false;
					}

					//setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 0, 1, 9, 100);

					//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(5, 0 , 0, true);

					// setting function handling header
					InitHeadMode(true, true, false, true, false,false) ;

					var HeadTitle = "STS|No|CHK|Code|Name";

					//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//Data  properties	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	 0,	daCenter,	false,	"",			false,		"",		dfNone,   		0,	 false,	  true);
					InitDataProperty(0, cnt++ , dtSeq,			30,	daCenter,	false,	"",			false,		"",		dfNone,		  0,	 true,		true);
					InitDataProperty(0, cnt++ , dtCheckBox,		30,	daCenter,	false,	"checkbox",	false,		"",		dfNone,		  0,	 true,		true);
					InitDataProperty(0, cnt++ , dtData,			40,	daCenter,	false,	"cnt_cd",		false,		"",		dfNone,		  0,	 false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,	daCenter,	false,	"cnt_nm",		false,		"",		dfNone,		  0,	 false,		false);
					CountPosition = 0 ;
				}
				break;

			case 4:	  //sheet6 init
				with (sheetObj) {
					// setting height
					style.height = GetSheetHeight(11) ;
					//Whole setting width
					SheetWidth = mainTable.clientWidth;

					//setting Host information[mandatory][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//Whole Merge kind [Optional, Default msNone]
					MergeSheet = msHeaderOnly;

					//Edit kind [Optional, Default false]
					if(document.form.pageType.value != "Inquiry"){
						Editable = true;
					}else{
						Editable = false;
					}

					//setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 0, 1, 9, 100);

					//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(4, 0 , 0, true);

					// setting function handling header
					if(document.form.pageType.value != "Inquiry"){
						InitHeadMode(true, true, true, true, false,false) ;
					}else{
						InitHeadMode(true, true, false, true, false,false) ;
					}
					

					var HeadTitle = "STS|No|CHK|Code";

					//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//Data  properties	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus,	0,	daCenter,	false,	"",			false,		  "",	   dfNone,		0,	false,	  true);
					InitDataProperty(0, cnt++, dtSeq,			30,	daCenter,	false,	"",			false,		  "",	   dfNone,		0,	true,	   true);
					InitDataProperty(0, cnt++, dtCheckBox,		30,	daCenter,	false,	"checkbox",	false,		  "",	   dfNone,		0,	true,	   true);
					InitDataProperty(0, cnt++, dtData,			80,	daCenter,	false,	"loc_cd",		false,		  "",	   dfNone,		0,	false,	   false);

					CountPosition = 0 ;
				}
				break;
			case 5:	  //sheet7 init
				with (sheetObj) {
					// setting height
					style.height = GetSheetHeight(11) ;
					//Whole setting width
					SheetWidth = mainTable.clientWidth;

					//setting Host information[mandatory][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//Whole Merge kind [Optional, Default msNone]
					MergeSheet = msHeaderOnly;

				   //Edit kind [Optional, Default false]
					if(document.form.pageType.value != "Inquiry"){
						Editable = true;
					}else{
						Editable = false;
					}

					//setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 0, 1, 9, 100);

					//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(4, 0 , 0, true);

					// setting function handling header
					InitHeadMode(true, true, false, true, false,false) ;

					var HeadTitle = "STS|No|CHK|Code";

					//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//Data  properties	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	 0,	daCenter,	false,	"",			false,		  "",	   dfNone,		0,	 false,	  true);
					InitDataProperty(0, cnt++ , dtSeq,			30,	daCenter,	false,	"",			false,		  "",	   dfNone,		0,	 true,	   true);
					InitDataProperty(0, cnt++ , dtCheckBox,		30,	daCenter,	false,	"checkbox",	false,		  "",	   dfNone,		0,	 true,	   true);
					InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	false,	"ofc_cd",		false,		  "",	   dfNone,		0,	 false,	   false);

					CountPosition = 0 ;
				}
				break;
		}
	}

  // handling process for Sheet
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		var sheetObject = sheetObjects[0];
		var sheetObject1 = sheetObjects[1];
		var sheetObject2 = sheetObjects[2];
		var sheetObject3 = sheetObjects[3];
		var sheetObject4 = sheetObjects[4];
		
		switch(sAction) {
			case IBSEARCH01:		 //Retrieve
				if(!validateForm(sheetObject,formObj,sAction)) return false;
				formObj.f_cmd.value = SEARCH01;
				sheetObj.DoSearch4Post("ESM_AGT_0006GS.do", agtQryStr(formObj));
				break;
			case IBSEARCH02:	  //Retrieve
				if(!validateForm(sheetObject1,formObj,sAction)) return false;
				formObj.f_cmd.value = SEARCH02;
				sheetObj.DoSearch4Post("ESM_AGT_0006GS.do", agtQryStr(formObj));
				break;
			case IBSEARCH03:	  //Retrieve
				if(!validateForm(sheetObject2,formObj,sAction)) return false;
				formObj.f_cmd.value = SEARCH03;
				sheetObj.DoSearch4Post("ESM_AGT_0006GS.do", agtQryStr(formObj));
				break;
			case IBSEARCH04:	  //Retrieve
				if(!validateForm(sheetObject3,formObj,sAction)) return false;
				formObj.f_cmd.value = SEARCH04;
				sheetObj.DoSearch4Post("ESM_AGT_0006GS.do", agtQryStr(formObj));
				break;
			case IBSEARCH05:	  //Retrieve
				if(!validateForm(sheetObject4,formObj,sAction)) return false;
				formObj.f_cmd.value = SEARCH05;
				sheetObj.DoSearch4Post("ESM_AGT_0006GS.do", agtQryStr(formObj));
				break;
			case IBSEARCH06:	  //Retrieve
				if(!validateForm(sheetObject,formObj,sAction)) return false;
				formObj.f_cmd.value = SEARCH02;
				var agn_seq = formObj.agn_seq.value;
				formObj.agn_seq.value = '';
				var parameter = agtQryStr(formObj);
				parameter = parameter + '&conti_cd='+chkdArgs(sheetObject, 'checkbox', 'conti_cd');
				sheetObject1.DoSearch4Post("ESM_AGT_0006GS.do", parameter);
				sheetObject2.RemoveAll();
				sheetObject3.RemoveAll();
				sheetObject4.RemoveAll();
				formObj.agn_seq.value = agn_seq;
				break;
			case IBSEARCH07:	  //Retrieve
				if(!validateForm(sheetObject1,formObj,sAction)) return false;
				var agn_seq = formObj.agn_seq.value;
				formObj.agn_seq.value = '';
				formObj.f_cmd.value = SEARCH03;
				var parameter = agtQryStr(formObj);
				parameter = parameter + '&sconti_cd='+chkdArgs(sheetObject1, 'checkbox', 'sconti_cd');
				sheetObject2.DoSearch4Post("ESM_AGT_0006GS.do", parameter);
				sheetObject3.RemoveAll();
				sheetObject4.RemoveAll();
				formObj.agn_seq.value = agn_seq;
				break;
			case IBSEARCH08:	  //Retrieve
				if(!validateForm(sheetObject2,formObj,sAction)) return false;
				var agn_seq = formObj.agn_seq.value;
				formObj.agn_seq.value = '';
				formObj.f_cmd.value = SEARCH04;
				parameter = "";
				parameter = agtQryStr(formObj);
				parameter = parameter + '&cnt_cd='+chkdArgs(sheetObject2, 'checkbox', 'cnt_cd');
				sheetObject3.DoSearch4Post("ESM_AGT_0006GS.do", parameter);	
				formObj.f_cmd.value = SEARCH05;
				parameter = "";
				parameter = agtQryStr(formObj);
				parameter = parameter + '&cnt_cd='+chkdArgs(sheetObject2, 'checkbox', 'cnt_cd');
				sheetObject4.DoSearch4Post("ESM_AGT_0006GS.do", parameter);			
				formObj.agn_seq.value = agn_seq;
				break;
			case IBSEARCH09:	  //Retrieve
				if(!validateForm(sheetObject3,formObj,sAction)) return false;
				var agn_seq = formObj.agn_seq.value;
				formObj.agn_seq.value = '';
				formObj.f_cmd.value = SEARCH05;
				var parameter = agtQryStr(formObj);
				parameter = parameter + '&loc_cd='+chkdArgs(sheetObject3, 'checkbox', 'loc_cd');
				sheetObject4.DoSearch4Post("ESM_AGT_0006GS.do", parameter);
				formObj.agn_seq.value = agn_seq;
				break;
		}
	}

	/**
	 * Conti sheet check box is clicked, then Sub Conti Retrieve
	 */

	function sheet1_OnClick(sheetObject, Row, Col, Value)
	{
		var formObject = document.form;
		if(document.form.pageType.value != "Inquiry"){
			if ( sheetObject.colSaveName(Col)== "checkbox"){
				if(Value == 0){
					sheetObject.CellValue(Row,Col) = 1;
				}else{
					sheetObject.CellValue(Row,Col) = 0;
				}
				doActionIBSheet(sheetObject,formObject,IBSEARCH06);
			
				if(sheetObject.CellValue(Row,Col) == 1){
					sheetObject.CellValue(Row,Col) = 0;
				}else{
					sheetObject.CellValue(Row,Col) = 1;
				}					   
			}	
		}
	}
	

	
	/**
	 * Sub Conti sheet check box is clicked, then Country Code Retrieve
	 */

	function sheet2_OnClick(sheetObject, Row, Col, Value)
	{
		var formObject = document.form;
		if(document.form.pageType.value != "Inquiry"){
			if ( sheetObject.colSaveName(Col)== "checkbox"){
				if(Value == 0){
					sheetObject.CellValue(Row,Col) = 1;
				}else{
					sheetObject.CellValue(Row,Col) = 0;
				}	
				doActionIBSheet(sheetObject,formObject,IBSEARCH07);
				if(sheetObject.CellValue(Row,Col) == 1){
					sheetObject.CellValue(Row,Col) = 0;
				}else{
					sheetObject.CellValue(Row,Col) = 1;
				}				   
			}
		}
		
	}
	
	
	/**
	 * Country Code sheet check box is clicked, then Region Code Retrieve
	 */

	function sheet3_OnClick(sheetObject, Row, Col, Value)
	{
		var formObject = document.form;
		if(document.form.pageType.value != "Inquiry"){
			if ( sheetObject.colSaveName(Col)== "checkbox"){
				if(Value == 0){
					sheetObject.CellValue(Row,Col) = 1;
				}else{
					sheetObject.CellValue(Row,Col) = 0;
				} 
				doActionIBSheet(sheetObject,formObject,IBSEARCH08);
				if(sheetObject.CellValue(Row,Col) == 1){
					sheetObject.CellValue(Row,Col) = 0;
				}else{
					sheetObject.CellValue(Row,Col) = 1;
				}					  
			}
		}
	}
	

	/**
	 * Location Code sheet check box is clicked, then OFC Code Retrieve
	 */

	function sheet4_OnClick(sheetObject, Row, Col, Value)
	{
		var formObject = document.form;
		if(document.form.pageType.value != "Inquiry"){
			if ( sheetObject.colSaveName(Col)== "checkbox"){
				if(Value == 0){
					sheetObject.CellValue(Row,Col) = 1;
				}else{
					sheetObject.CellValue(Row,Col) = 0;
				}	 
				doActionIBSheet(sheetObject,formObject,IBSEARCH09);
				if(sheetObject.CellValue(Row,Col) == 1){
					sheetObject.CellValue(Row,Col) = 0;
				}else{
					sheetObject.CellValue(Row,Col) = 1;
				}				  
			}
		}
		
	}
	
	// Retrieving OFC Code on Clicking checkAll box

	function sheet4_OnMouseDown(sheetObject, Btn, Shift, X, Y)
	{
		var formObject = document.form;
		if(document.form.pageType.value != "Inquiry"){
			if ( sheetObject.MouseRow < 1  && sheetObject.MouseCol == 2){
				
				if(sheetObject.CheckAll(2) == 0){
					sheetObject.CheckAll(2) = 0;
				}else{
					sheetObject.CheckAll(2) = 1;
				}
				
				sheetObject.CheckReverse(2);
				doActionIBSheet(sheetObject,formObject,IBSEARCH09);
	
			}
		}
		
	}

   /**
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction){
		var sheetObject = sheetObjects[0];
		var sheetObject1 = sheetObjects[1];
		var sheetObject2 = sheetObjects[2];
		var sheetObject3 = sheetObjects[3];
		var sheetObject4 = sheetObjects[4];
		
		switch(sAction) {

			case IBSEARCH06:
				if(sheetObject.CheckedRows("checkbox") < 1){
					ComShowMessage(ComGetMsg('COM12113','Conti 체크박스'));
					sheetObject1.RemoveAll();
					sheetObject2.RemoveAll();
					sheetObject3.RemoveAll();
					sheetObject4.RemoveAll();
					return false;
				}
				break;
			case IBSEARCH07:
				if(sheetObject1.CheckedRows("checkbox") < 1){
					ComShowMessage(ComGetMsg('COM12113','S. Conti 체크박스'));
					sheetObject2.RemoveAll();
					sheetObject3.RemoveAll();
					sheetObject4.RemoveAll();
					return false;
				}
				break;
			case IBSEARCH08:
				if(sheetObject2.CheckedRows("checkbox") < 1){
					ComShowMessage(ComGetMsg('COM12113','Country Code 체크박스'));
					sheetObject3.RemoveAll();
					sheetObject4.RemoveAll();
					return false;
				}
				break;
			case IBSEARCH09:
				if(sheetObject3.CheckedRows("checkbox") < 1){
					ComShowMessage(ComGetMsg('COM12113','Location Code 체크박스'));
					sheetObject4.RemoveAll();
					return false;
				}
				break;
		}
		return true;
	}

	function chkdArgs(sheetObj,chkCol,valCol,isNum)
	{
		var rtn = '';
		with(sheetObj)
		{
			for (var i = 1; i <= LastRow; i ++)
			{
				if ("1" == CellValue(i, chkCol))
					rtn += (''!=rtn?',':'')+(isNum?'':'\'')+CellValue(i, valCol)+(isNum?'':'\'');
			}
		}
		return rtn;
	}