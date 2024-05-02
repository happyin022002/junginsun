/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_LEA_0012.js
*@FileTitle : CSR I/F Inquiry
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
     * @fileoverview 
     * @author 
     */

    /**
     * @extends 
     * @class ESD_LEA_0012 : business script for ESD_LEA_0012
     */
    function ESD_LEA_0012() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
    /* The global variables */
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
        * Convert the date to the defined format(YYYY-MM-DD).
    	* @param : obj
    	* example : <input type ="text" name ="date" onblur="lea_com_convertYymmdd(this)">
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
    					
    					//Setting height
    					style.height = 400;
    		
    					//Setting the Host information[Required][HostIp, Port, PagePath]
    					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    		
    					//Kind of merge[Optional, Default msNone]
    					MergeSheet = msHeaderOnly;
    		
    					//Edit kind[Optional, Default false]
    					Editable = true;
    		
    					//Setting row information[Required][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    					InitRowInfo( 2, 1, 9, 100);
    		
    					 //Setting column information[Required][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    					InitColumnInfo(13, 0, 0, true); //11+2
    		
    					//Setting function handling header
    					InitHeadMode(true, true, false, true, false,false)
    		
    					var HeadTitle  = "Seq||CSR No.|Source|ERP I/F|ERP I/F|ERP I/F|LEA I/F|Currency|Total Amt|Old CSR|A|B" ;
    					var HeadTitle1 = "Seq||CSR No.|Source|Status|I/F Date|Error Reason|Status|Currency|Total Amt|Old CSR|A|B" ;
    		
    					//The information of the header row[Required][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    					InitHeadRow(0, HeadTitle, true);
    					InitHeadRow(1, HeadTitle1, true);
    			
    					 //Data attribute	[ROW,	  COL,	DATATYPE, WIDTH,   DATAALIGN, COLMERGE,	 SAVENAME,   KEYFIELD, CALCULOGIC,   DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    					InitDataProperty(0,	cnt++,	dtDataSeq		,	35,		daRight, 	true);
    					InitDataProperty(0,	cnt++,	dtHiddenStatus	,	0,		daCenter,	false,	"ibflg"			,	false,	"",	dfNone		,	0,	true,	true);
    					InitDataProperty(0,	cnt++,	dtData			,	150,	daCenter,	true,	"csr_no"		,	false,	"",	dfNone		,	0,	false,	true,	400,	false,	 true,	"",	false);
    					InitDataProperty(0,	cnt++,	dtData			,	50,		daCenter,	true,	"src_ctnt"		,	false,	"",	dfNone		,	0,	false,	true,	400,	false,	 true,	"",	false);
    					InitDataProperty(0,	cnt++,	dtData			,	50,		daCenter,	true,	"if_flg"		,	false,	"",	dfNone		,	0,	false,	true,	400,	false,	 true,	"",	false);
    					InitDataProperty(0,	cnt++,	dtData			,	70,		daCenter,	true,	"if_dt"			,	false,	"",	dfDateYmd	,	0,	false,	true,	400,	false,	 true,	"",	false);
    					InitDataProperty(0,	cnt++,	dtData			,	150,	daLeft,		true,	"if_err_rsn"	,	false,	"",	dfNone		,	0,	false,	true,	400,	false,	 true,	"",	false);
    					InitDataProperty(0,	cnt++,	dtData			,	50,		daCenter,	true,	"lea_flg"		,	false,	"",	dfNone		,	0,	false,	true,	400,	false,	 true,	"",	false);
    					InitDataProperty(0,	cnt++,	dtData			,	60,		daCenter,	true,	"csr_curr_cd"	,	false,	"",	dfNone		,	0,	false,	true,	400,	false,	 true,	"",	false);
    					InitDataProperty(0,	cnt++,	dtData			,	100,	daRight,	true,	"csr_amt"		,	false,	"",	dfNone		,	0,	false,	true,	400,	false,	 true,	"",	false);
    					InitDataProperty(0,	cnt++,	dtData			,	50,		daCenter,	true,	"err_csr_no"	,	false,	"",	dfNone		,	0,	false,	true,	400,	false,	 true,	"",	false);
    					InitDataProperty(0,	cnt++,	dtHidden		,	50,		daCenter,	true,	"gl_dt"			,	false,	"",	dfNone		,	0,	false,	true,	400,	false,	 true,	"",	false);
    					InitDataProperty(0,	cnt++,	dtHidden		,	50,		daCenter,	true,	"inv_ofc_cd"	,	false,	"",	dfNone		,	0,	false,	true,	400,	false,	 true,	"",	false);
    					
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

    			var HeadTitle  = "Inv.Office|ERP I/F Date|ERP I/F Date|Source|ERP I/F|LEA I/F";

    			//Setting the header row[Required][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    			InitHeadRow(0, HeadTitle, true);

    			//Data attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    			InitDataProperty(0, cnt++ , dtData   ,	100,	daCenter,  true,	"inv_ofc_cd",	false,	"",	dfNone	,	0,	false,	false);
    			InitDataProperty(0, cnt++ , dtData   ,	100,    daCenter,  true,    "st_if_dt"	,	false,	"",	dfDateYm,	0,	false,	false);
    			InitDataProperty(0, cnt++ , dtData   ,	100,    daCenter,  true,    "end_if_dt"	,	false,	"",	dfDateYm,	0,	false,	false);
    			InitDataProperty(0, cnt++ , dtData   ,	100,    daCenter,  true,    "src_ctnt"	,	false,	"",	dfNone	,	0,	false,	false);
    			InitDataProperty(0, cnt++ , dtData   ,	100,    daCenter,  true,    "if_flg"	,	false,	"",	dfNone	,	0,	false,	false);
    			InitDataProperty(0, cnt++ , dtData   ,	100,	daCenter,  true,	"lea_flg"	,	false,	"",	dfNone	,	0,	false,	false);
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
    					cal.select(formObject.frm_st_if_dt, 'yyyy-MM-dd');
    					break;
    					
    				case "btns_calendar2":
    					var cal = new ComCalendar();
    					cal.select(formObject.frm_end_if_dt, 'yyyy-MM-dd');
    					break;
    					
    				case "btng_downexcel":
    					sheetObject. ExcelOption= "NOCOLOR";
            	    	sheetObject.SpeedDown2Excel(true);
            	    	sheetObject. ExcelOption= "";   
    					break;
    					
            	    case "btng_csrmonitoring":	//Link CSR Monitoring
    		            if ( sheetObject.RowCount < 1 ) 
    		            {
    		              	ComShowMessage(ComGetMsg("LEA90008"));
    		                return false;
    		            }
    		            if ( sheetObject.SelectRow < 0 ) 
    		            {
    		              	ComShowMessage(ComGetMsg("LEA90003"));
    		                return false;
    		            }
    						var url_str = "ESD_LEA_0013.do";
    								url_str += "?f_cmd="			+ "2";
    								url_str += "&frm_opt_st_dt="	+ sheetObject.CellValue(sheetObject.SelectRow, "gl_dt");
    								url_str += "&frm_opt_end_dt="	+ sheetObject.CellValue(sheetObject.SelectRow, "gl_dt");
    								url_str += "&frm_src_ctnt="		+ "ALL";
    								url_str += "&frm_inv_ofc_cd="	+ sheetObject.CellValue(sheetObject.SelectRow, "inv_ofc_cd");
    								url_str += "&frm_csr_no="		+ sheetObject.CellValue(sheetObject.SelectRow, "csr_no");
    								url_str += "&frm_rslt_cd="		+ "ALL";
    								url_str += "&winopen_div="		+ "POP";
    								url_str += "&dt_div="           + "GL";
    						window.showModalDialog(url_str, window, "dialogWidth:1050px; dialogHeight:600px; help:no; status:no; resizable:yes;");
            	        break;					
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
         * Handling the retrieving process when pressed EnterKey Event
         */
    	function lea_enterRetrieve(){
    		var sheetObject = sheetObjects[curTab-1];
    		var formObject = document.form;
    		doActionIBSheet(sheetObject,formObject,IBSEARCH);
    	}
    	
    	
    	/**
    	 * Handling the process about the sheet
    	 */ 
    	function doActionIBSheet(sheetObj,formObj,sAction) {
    		sheetObj.ShowDebugMsg = false;
    		switch(sAction) {
    		   case IBSEARCH:	  //Retrieving
    				formObj.f_cmd.value = SEARCH;
    				
    				sheetObj.DoSearch4Post("ESD_LEA_0012GS.do", leaFormQueryString(formObj));
    				break;
    		}
    	}
    	
    	/**
         * Handling the process for the input validation
         */
    	function validateForm(sheetObj,formObj,sAction){
    		with(formObj){
    			
    			 //Inv.Office Code check
    			 if (formObj.frm_inv_ofc_cd.value.trim() == '' ) {
    			 	ComShowMessage(ComGetMsg("TRS90091")); //'Please input the Office code.'
    			 	return false;
    			 }			 
    			 //Date check
    			 if (parseInt(get_IntervalDay(formObj.frm_st_if_dt.value, formObj.frm_end_if_dt.value)) > 7)  {
    			 	ComShowMessage(ComGetMsg("LEA90022", "1")); //'Period is limited to 1 week.'
    			 	return false;
    			 }
    			 
    		}
    		
    		return true;
    	}
    	
    	/**
    	 * Handling the common when the retrieving result occurs error.
    	 */
    	function sheet_OnSearchEnd(sheetObj,errMsg){
    		if(errMsg!=null){
    			ComShowMessage(errMsg);
    		}
    	}
    	
    	/**
     	 * Copying the form data to the sheet 
    	 */
    	function lea_form2sheet(formObj,sheetObj){
    		sheetObj.RemoveAll();
    		var Row = sheetObj.DataInsert();
    		
    		sheetObj.CellValue2(Row, "inv_ofc_cd"	) = formObj.frm_inv_ofc_cd.value;
    		sheetObj.CellValue2(Row, "st_if_dt"		) = formObj.frm_st_if_dt.value;
    		sheetObj.CellValue2(Row, "end_if_dt"	) = formObj.frm_end_if_dt.value;
    		sheetObj.CellValue2(Row, "src_ctnt"		) = formObj.frm_src_ctnt.value;
    		sheetObj.CellValue2(Row, "if_flg"		) = formObj.frm_if_flg.value;
    		sheetObj.CellValue2(Row, "lea_flg"		) = formObj.frm_lea_flg.value;
    	}

    	/**
         * Opening the retrieving CSR page by the modal window when double-clicked CSR No.
         */		
    	function sheet1_OnDblClick(sheet1, row, col){
    		if(col==2 || col==10){ //CSR No, Old CSR Column
    			var csr_no = sheet1.cellValue(row, col);
    			var inv_sys_id = sheet1.cellValue(row, 3); //TRS, TES
    		
    			if (inv_sys_id == "TRS") {
    				window.showModalDialog("ESD_TRS_0960.do?csr_no=" + csr_no, window, "dialogWidth:800px; dialogHeight:800px; help:no; status:no; resizable:yes;");
    			} else if (inv_sys_id == "TES"){
       				window.showModalDialog("ESD_TES_0101.screen?csr_no=" + csr_no, window, "dialogWidth:800px; dialogHeight:800px; help:no; status:no; resizable:yes;");
    			}
    		}
    	}	
