/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_LEA_0013.js
*@FileTitle : CSR Monitoring Inquiry
*Open Issues :
*Change history : 
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

    /**
     * @extends 
     * @class ESD_LEA_0013 :  business script for ESD_LEA_0013 
     */
    function ESD_LEA_0013() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
    /* The common global variables*/

  var curTab = 1;
  var beforetab = 0;
  var sheetObjects = new Array();
  var sheetCnt = 0;

  /**
   * registering IBSheet Object as list
   * adding process for list in case of needing batch processing with other items 
   * defining list on the top of source
   */
  	function setSheetObject(sheet_obj){
  		sheetObjects[sheetCnt++] = sheet_obj;
  	}
  	
  	/**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
  	function loadPage() {
  		for(i=0;i<sheetObjects.length;i++){
  			ComConfigSheet(sheetObjects[i]);
  			initSheet(sheetObjects[i],i+1);
  			ComEndConfigSheet(sheetObjects[i]);
  		}
  	}

  	/**
  	* Converting from the object's value to defined format(YYYY-MM-DD)
  	* example usage : <input type ="text" name ="date" onblur="lea_com_convertYymmdd(this)"> 
  	**/
  	function lea_convertYymmdd(obj){
  		obj.value = ComReplaceStr(obj.value, '-', '');
  		switch(obj.value.length){
  			case 0 :
  					return;
  					break;
  			case 6 :
  					if (parseInt(obj.value.substring(0,2),10)  > 80 )
  					{
  						obj.value = "19"+obj.value;
  					}
  					else
  					{
  						obj.value = "20"+obj.value;
  					}
  					break;
  			case 8 :
  					break;
  			default :
  					obj.focus();
  					return;
  					break;
  		}
  		
  		var realDate = ComIsDate(obj.value);
  		if (!realDate)
  		{
  			ComShowMessage(ComGetMsg("LEA90001"));
  			obj.value="";
  			obj.focus();
  			return;
  		}
  		
  		str = obj.value;
  		str = str.substring(0,4) + "-" + str.substring(4,6) + "-" + str.substring(6,8);
  		obj.value = str;
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
  					
  					//Setting width
  					SheetWidth = mainTable.clientWidth;
  					
  				// Setting height
					style.height = 400;
  		
  					//Setting the Host information[Required][HostIp, Port, PagePath]
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
  		
  					//Kind of merge [Optional, Default msNone]
  					MergeSheet = msHeaderOnly;
  		
  					//Edit kind [Optional, Default false]
  					Editable = true;
  		
  					//Setting row information[Required][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  					InitRowInfo( 2, 1, 9, 1000); //setting 1000 to ONEPAGEROW(the row count that retrieves at once by retrieving XML)'s value(For retrieving large data)
  		
  					//Setting column information[Required][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  					InitColumnInfo(34, 5, 0, true); 
  		
  					// Setting function handling header
  					InitHeadMode(true, true, false, true, false, false)

  					var HeadTitle  = "Seq||Source|Inv.Office|CSR No.|Inv.No.|LEA I/F Date|G/L Date|R.Month|R.VVD|R.VVD|BKG No.|CNTR No.|CNTR TP/SZ|CNTR TP/SZ|A/G|A/G|A/G Seq|A/G Seq|Cost Code|Cost Code|1st Node|1st Node|2nd Node|2nd Node|3rd Node|3rd Node|4th Node|4th Node|Amount(USD)|Amount(USD)|Amount per CNTR|Amount per CNTR|Result" ;
  					var HeadTitle1 = "Seq||Source|Inv.Office|CSR No.|Inv.No.|LEA I/F Date|G/L Date|R.Month|Inv.|Est.|BKG No.|CNTR No.|Inv.|Est.|Inv.|Est.|Inv.|Est.|Inv.|Est.|Inv.|Est.|Inv.|Est.|Inv.|Est.|Inv.|Est.|Inv.|Est.|Count|Amt|Result" ;


  					//The information of the header row[Required][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  					InitHeadRow(0, HeadTitle, true);
  					InitHeadRow(1, HeadTitle1, true);

  					//Data attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX] 
  					InitDataProperty(0,	cnt++,		dtDataSeq,		35,		daRight, 	true);
  					InitDataProperty(0,	cnt++,	dtHiddenStatus,		0,		daCenter,	false,		"ibflg",					false,	"",	dfNone		,	0,	true,	true);
  					InitDataProperty(0,	cnt++,			dtData,		50,		daCenter,	true,		"inv_sys_id",				false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		60,		daCenter,	true,		"inv_ofc_cd",				false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,	   130,		daCenter,	true,		"csr_no",					false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		90,		daCenter,	true,		"inv_no",					false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		70,		daCenter,	true,		"if_dt",					false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		70,		daCenter,	true,		"gl_dt",					false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		60,		daCenter,	true,		"rev_yrmon",				false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		80,		daCenter,	true,		"inv_rvvd",					false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		80,		daCenter,	true,		"estm_rvvd",				false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		90,		daCenter,	true,		"bkg_no",					false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		80,		daCenter,	true,		"cntr_no",					false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		35,		daCenter,	true,		"inv_cntr_tpsz_cd",			false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		35,		daCenter,	true,		"estm_cntr_tpsz_cd",		false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		50,		daCenter,	true,		"inv_cost_act_grp_cd",		false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		50,		daCenter,	true,		"estm_cost_act_grp_cd",		false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		30,		daCenter,	true,		"inv_cost_act_grp_seq",		false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		30,		daCenter,	true,		"estm_cost_act_grp_seq",	false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		60,		daCenter,	true,		"inv_coa_cost_src_cd",		false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		60,		daCenter,	true,		"estm_coa_cost_src_cd",		false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		60,		daCenter,	true,		"inv_n1st_nod_cd",			false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		60,		daCenter,	true,		"estm_n1st_nod_cd",			false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		60,		daCenter,	true,		"inv_n2nd_nod_cd",			false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		60,		daCenter,	true,		"estm_n2nd_nod_cd",			false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		60,		daCenter,	true,		"inv_n3rd_nod_cd",			false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		60,		daCenter,	true,		"estm_n3rd_nod_cd",			false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		60,		daCenter,	true,		"inv_n4th_nod_cd",			false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		60,		daCenter,	true,		"estm_n4th_nod_cd",			false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		100,	daRight,	true,		"inv_cost_amt",				false,	"",	dfFloat	,	2,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		100,	daRight,	true,		"estm_cost_amt",			false,	"",	dfFloat	,	2,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		50,		daRight,	true,		"aloc_cntr_qty",			false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		100,	daRight,	true,		"aloc_cntr_amt",			false,	"",	dfFloat	,	2,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		50,		daCenter,	true,		"act_mapg_rslt_cd",			false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);

  					//style.height = 260 ;
  					
  					//ActionMenu = "Header Setting Save|Header Setting Reset|Header Setting Delete";
  					//IBS_RestoreGridSetting(document.form.FORM_CRE_USR_ID.value, getPageURL(), sheetObjects[0], false);
  					
  					
  				}
  				break;
  			case 2:      //IBSheet1 init
  			with (sheetObj) {
  				//Setting width
  				SheetWidth = mainTable.clientWidth;

  				//Setting the Host information[Required][HostIp, Port, PagePath]
  				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

  				//Kind of merge [Optional, Default msNone]
  				MergeSheet = msHeaderOnly;

  				//Edit kind [Optional, Default false]
  				Editable = true;

  				//Setting row information[Required][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  				InitRowInfo( 1, 1, 9, 100);

  				//Setting column information[Required][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  				InitColumnInfo(6, 0, 0, true);

  				// Setting function handling header
  				InitHeadMode(true, true, true, true, false,false)

  				if (document.form.dt_div.value == "GL") {
  					var HeadTitle  = "Invoice Office|G/L Date|G/L Date|Source|CSR No.|Result";
  				} else {
  					var HeadTitle  = "Invoice Office|LEA I/F Date|LEA I/F Date|Source|CSR No.|Result";
  				}

  				//The information of the header row[Required][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  				InitHeadRow(0, HeadTitle, true);

  				//Data attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  				InitDataProperty(0,	cnt++,	dtData,	100,	daCenter,	true,	"inv_ofc_cd"		,	false,	"",	dfNone,	0,	false,	false);
  				InitDataProperty(0,	cnt++,	dtData,	100,	daCenter,	true,	"opt_st_dt"			,	false,	"",	dfNone,	0,	false,	false);
  				InitDataProperty(0,	cnt++,	dtData,	100,	daCenter,	true,	"opt_end_dt"		,	false,	"",	dfNone,	0,	false,	false);
  				InitDataProperty(0,	cnt++,	dtData,	100,	daCenter,	true,	"src_ctnt"			,	false,	"",	dfNone,	0,	false,	false);
  				InitDataProperty(0,	cnt++,	dtData,	100,	daCenter,	true,	"csr_no"			,	false,	"",	dfNone,	0,	false,	false);
  				InitDataProperty(0,	cnt++,	dtData,	100,	daCenter,	true,	"act_mapg_rslt_cd"	,	false,	"",	dfNone,	0,	false,	false);

  				style.height = GetSheetHeight(13) ;
  				}
  				break;
  		}
  	}

  	/* Event handler processing by button click event */
  	document.onclick = processButtonClick;
  	
  	/* Event handler processing by button name */	
  	function processButtonClick(){
  		 var sheetObject = sheetObjects[0];
  		 var sheetObject1 = sheetObjects[1];
  		 var formObject = document.form;
  		 if(curTab == 2)
  			formObject = document.form2;
  			
  		try {
  			var srcName = window.event.srcElement.getAttribute("name");
  			switch(srcName) {
  				case "btn_retrieve":
  					doActionIBSheet(sheetObject,formObject,IBSEARCH);
  						break;
  				case "btns_calendar1":
  					var cal = new ComCalendar();
  					cal.select(formObject.frm_opt_st_dt, 'yyyy-MM-dd');
  					break;
  				case "btns_calendar2":
  					var cal = new ComCalendar();
  					cal.select(formObject.frm_opt_end_dt,'yyyy-MM-dd');
  					break;
  				case "btng_downexcel":
  					sheetObject. ExcelOption= "NOCOLOR";
        	    	sheetObject.SpeedDown2Excel(true);
        	    	sheetObject. ExcelOption= "";   
  			} // end switch
  		}catch(e) {			
  			if( e == "[object Error]") {
  				ComShowMessage(OBJECT_ERROR);
  			} else {
  				ComShowMessage(e);
  			}
  		}
  	}
  	
  	/**
  	 * Handling the retrieving process when pressed Enter key Event
  	 */
  	function lea_enterRetrieve(){
  		var sheetObject = sheetObjects[curTab-1];
  		var formObject = document.form;
  		doActionIBSheet(sheetObject,formObject,IBSEARCH);
  	}
  	
  	/**
  	 * Handling the process of the retrieving Page Loading Event
  	 */
  	function lea_load_page(){
  		var sheetObject = sheetObjects[curTab-1];
  		var formObject = document.form;
  		
  		//Retrieving automatically when being called by popUpWindow
  		if (formObject.dt_div.value == "GL") {
  			doActionIBSheet(sheetObject,formObject,IBSEARCH);
  		}
  	}
  	
  	/* Handling the process about the sheet */
  	function doActionIBSheet(sheetObj,formObj,sAction) {
  		sheetObj.ShowDebugMsg = false;
  		switch(sAction) {
  			case IBSEARCH:	  //Retrieving
  				/*if(!validateForm(sheetObj,formObj,sAction)) {
  					return false;
  				}
  				*/
  				formObj.f_cmd.value = SEARCH;
  				//alert(FormQueryString(formObj)) //Parameter Value
  				//sheetObj.DoSearch4Post("ESD_LEA_0013GS.do", FormQueryString(formObj));
  				
  				sheetObj.DoSearch4Post("ESD_LEA_0013GS.do", leaFormQueryString(formObj));
  				
  				break;
  		}
  	}
  	
  	/**
  	 * Handling the process for the input validation
  	 */
  	function validateForm(sheetObj,formObj,sAction){
  		with(formObj){
  			 //Inv.Office Code Check
  			 if (formObj.frm_inv_ofc_cd.value.trim() == '' ) {
  			 	ComShowMessage(ComGetMsg("TRS90091")); //'Please input the Office code.'
  			 	return false;
  			 }
  			 //Date Check
  			 if (parseInt(get_IntervalDay(formObj.frm_opt_st_dt.value, formObj.frm_opt_end_dt.value)) > 7)  {
  			 	ComShowMessage(ComGetMsg("LEA90022", "1")); //'Period is limited to 1 week.'
  			 	return false;
  			 }
  			 
  			 
  		}
  		
  		return true;
  	}
  	
  	/**
  	 * Handling the common when the retrieving result occurs error
  	 * Defined it at DataSheetObject.prototype.event_OnSearchEnd in IBSheetConfig.js
  	 */
  	function sheet_OnSearchEnd(sheetObj,errMsg){
  		if(errMsg!=null){
  			ComShowMessage(errMsg);
  		}
  	}
  	
  	/**
  	 * Copying the form data to sheet one
  	 */
  	function lea_form2sheet(formObj,sheetObj){
  		sheetObj.RemoveAll();
  		var Row = sheetObj.DataInsert();
  		
  		sheetObj.CellValue2(Row , "inv_ofc_cd"      ) = formObj.frm_inv_ofc_cd.value;
  		sheetObj.CellValue2(Row , "opt_st_dt"        ) = formObj.frm_opt_st_dt.value;
  		sheetObj.CellValue2(Row , "opt_end_dt"       ) = formObj.frm_opt_end_dt.value;
  		sheetObj.CellValue2(Row , "src_ctnt"        ) = formObj.frm_src_ctnt.value;
  		sheetObj.CellValue2(Row , "csr_no"          ) = formObj.frm_csr_no.value;
  		sheetObj.CellValue2(Row , "act_mapg_rslt_cd") = formObj.frm_rslt_cd.value;
  	}

  	/**
  	 * Opening the retrieving CSR page of the selected system when double-clicking the cell of CSR(TRS, TES only)
  	 */
  	function sheet1_OnDblClick(sheet1, row, col){
  		if(col==4 ){ //CSR No
  			var csr_no = sheet1.cellValue(row, col);
  			var inv_sys_id = sheet1.cellValue(row, 2); //TRS, TES
  		
  			if (inv_sys_id == "TRS") {
  				window.showModalDialog("ESD_TRS_0960.do?csr_no=" + csr_no, window, "dialogWidth:800px; dialogHeight:800px; help:no; status:no; resizable:yes;");
  			} else if (inv_sys_id == "TES"){
  				window.showModalDialog("ESD_TES_0101.screen?csr_no=" + csr_no, window, "dialogWidth:800px; dialogHeight:800px; help:no; status:no; resizable:yes;");
  			}
  		}
  	}
  	
