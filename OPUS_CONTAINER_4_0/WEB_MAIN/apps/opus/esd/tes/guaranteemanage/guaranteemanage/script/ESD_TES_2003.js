/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_2003.js
*@FileTitle  : Guarantee Report Designer
*@author     : CLT
*@LastVersion : 1.0
*@since      : 2014/10/20
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

    /**
     * @extends 
     * @class ESD_TES_2003 : business script for ESD_TES_2003
     */
    function ESD_TES_2003() {
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
   	// global variable
	var sheetObjects = new Array();
	var sheetCnt = 0;
	// RD
	//var rdObjects = new Array(); //2016.07.05 HTML5 RD 주석처리
	//var rdCnt = 0;               //2016.07.05 HTML5 RD 주석처리
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
		//RD
	    rdOpen();//2016.07.05 HTML5 RD Add
		//initRdConfig(rdObjects[0]); //2016.07.05 HTML5 RD 주석처리
		//rdOpen(rdObjects[0], document.form); //2016.07.05 HTML5 RD 주석처리
		//Sheet
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
	}
	/**
	 * setting sheet initial values and header
	 * adding case as numbers of counting sheets
	 * 
	 * @param {ibsheet}  	sheetObj	Sheet Object
	 * @param {int,String} 	sheetNo		Sheet Object 
	 */
	function initSheet(sheetObj,sheetNo) {
		sheetObj.UseUtf8 = true;
		switch(sheetNo) {
			case 1:	  //IBSheet1 init
				with (sheetObj) {
					var cnt = 0;
					
					var HeadTitle = "|||||||||";
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
				   
					var cols = [ {Type:"Text",	Hidden:0, Width:30,   Align:"Center",	ColMerge:0,   SaveName:"email_addr",			KeyField:0,   CalcLogic:"",	Format:"",		PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					         {Type:"Text",		Hidden:0,	Width:30,		Align:"Center",		ColMerge:0,   SaveName:"fax_num",			KeyField:0,   CalcLogic:"",   Format:"",		PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					         
					         {Type:"Text",		Hidden:0,	Width:30,		Align:"Center",		ColMerge:0,   SaveName:"sys_cd",				KeyField:0,   CalcLogic:"",   Format:"",		PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					         {Type:"Text",		Hidden:0,	Width:30,		Align:"Center",		ColMerge:0,   SaveName:"app_cd",				KeyField:0,   CalcLogic:"",   Format:"",		PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",		Hidden:0,	Width:30,		Align:"Center",		ColMerge:0,   SaveName:"batch_ind",			KeyField:0,   CalcLogic:"",   Format:"",		PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",		Hidden:0,	Width:30,		Align:"Center",		ColMerge:0,   SaveName:"param",				KeyField:0,   CalcLogic:"",   Format:"",		PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					         {Type:"Text",		Hidden:0,	Width:30,		Align:"Center",		ColMerge:0,   SaveName:"rcv_info",				KeyField:0,   CalcLogic:"",   Format:"",		PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",		Hidden:0,	Width:30,		Align:"Center",		ColMerge:0,   SaveName:"office",					KeyField:0,   CalcLogic:"",   Format:"",		PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					         {Type:"Text",		Hidden:0,	Width:30,		Align:"Center",		ColMerge:0,   SaveName:"fax_title",				KeyField:0,   CalcLogic:"",   Format:"",		PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",		Hidden:0,	Width:30,		Align:"Center",		ColMerge:0,   SaveName:"email_title",			KeyField:0,   CalcLogic:"",   Format:"",		PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",		Hidden:0,	Width:30,		Align:"Center",		ColMerge:0,   SaveName:"email_contents",	KeyField:0,   CalcLogic:"",   Format:"",		PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
					
					InitColumns(cols);
					DataInsert();
					SetEditable(1);
					resizeSheet();
				}
				break;
		}
	}

	/* Event handler processing by button click event */
	document.onclick = processButtonClick;
	/**
	 * Event handler processing by button name
	 **/	
	function processButtonClick(){
		 /***** using extra sheet valuable if there are more 2 sheets *****/
		 var sheetObject = sheetObjects[0];
		 //var rdObject = rdObjects[0]; //2016.07.05 HTML5 RD 주석처리
		 /*******************************************************/
		 var formObject = document.form;
		try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_reset":
					resetForm(formObject, sheetObject);
					break;
				 case "btn_print":
				     viewer.print({isServerSide:true});
					//rdObjects[0].PrintDialog(); //2016.07.05 HTML5 RD 주석처리
					break;
				case "btn_send":
					sheetObject.WaitImageVisible = false;
					doActionIBSheet(sheetObject, formObject, MULTI01);
					break;
                case "btn_close":
                	ComClosePopup(); 
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
    * handling sheet process
    * @param {sheet}	sheetObj	ibsheet
    * @param {form}	formObj		form object
    * @param {int}		sAction		
    * @return
    */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		try {
			switch(sAction) {
			   case MULTI01:
				    if (!validateForm(sheetObj,formObj,sAction)){
				        return false;
				    }
				    
					formObj.f_cmd.value = MULTI01;
					sheetObj.RemoveAll();
					
					var row = sheetObj.DataInsert(-1);
			   		sheetObj.SetCellValue(row, "sys_cd", "TES");
			   		sheetObj.SetCellValue(row, "app_cd", "ESD_TES_2003.mrd");
			   		sheetObj.SetCellValue(row, "batch_ind", "N");
			   		sheetObj.SetCellValue(row, "fax_title", "Guarantee(GNTE#: "+formObj.gnte_no.value+")");
			   		sheetObj.SetCellValue(row, "param", '['+formObj.gnte_no.value+']');
			   		sheetObj.SetCellValue(row, "rcv_info", form.fax_num.value);
			   		sheetObj.SetCellValue(row, "email_title", "COMPANY, SHALL GUARANTEE ALL CHARGES FOR THE PAYMENT");
			   		sheetObj.SetCellValue(row, "email_contents", "COMPANY, SHALL GUARANTEE ALL CHARGES FOR THE PAYMENT");

			   		syncData(form.email_addr);
			   		syncData(form.fax_num);
					sheetObj.DoAllSave("ESD_TES_2003GS.do", sheetObj.GetSaveString(true)+"&"+FormQueryString(formObj));		   		
					break;
			}
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('COM12111');
			} else {
				ComShowMessage(e);
			}
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			if(formObj.email_addr.value=="" && formObj.fax_num.value=="") {
				ComShowCodeMessage('TES70203', "E-mail Address", "Fax Number");
				return false;
			}
		}
		return true;
	}
	 /**
	  * setting RD initial values
	  * @param {rd object}		rdObject	rd
	  * @return
	  */
	/* //2016.07.05 HTML5 RD 주석처리
	function initRdConfig(rdObject){

	    var Rdviewer = rdObject ;
	    
		Rdviewer.AutoAdjust = false;
	    Rdviewer.ZoomRatio = 140;
		// Rdviewer.HideToolBar(); // show tool bar ... In 2008-09-12

	    // Added Option  ... In 2008-09-12
    	Rdviewer.SetSaveDialogEx("", "", "pdf", "pdf");
    	Rdviewer.DisableToolbar(13);
    	Rdviewer.DisableToolbar(14);
    	Rdviewer.DisableToolbar(16);
    	Rdviewer.DisableToolbar(17);

		Rdviewer.HideStatusBar();
		Rdviewer.ViewShowMode(2);

		Rdviewer.SetBackgroundColor(255,255,255);
		Rdviewer.SetPageLineColor(255,255,255);
		Rdviewer.ApplyLicense("0.0.0.0");
	}*/
	 
	  /**
	   * Open RD
	   * @param {rd}	rdObject	RD Object
	   * @param {form}	formObj		form object
	   * @return
	   */
	/* //2016.07.05 HTML5 RD 주석처리
	function rdOpen(rdObject,formObject) {
	    //var Rdviewer = rdObject ;
	    var rdParam = "/rp [" + formObject.gnte_no.value + "] /rfonttype60";		//$1   			    
	    Rdviewer.FileOpen( RD_path + "apps/opus/esd/tes/guaranteemanage/guaranteemanage/report/ESD_TES_2003.mrd", RDServer + rdParam); 
//	    Rdviewer.FileOpen( "http://localhost:8001/opuscntr/apps/opus/esd/tes/guaranteemanage/guaranteemanage/report/ESD_TES_2003.mrd", RDServer + rdParam);
		
	}*/
	function rdOpen() {
	    var formObject = document.form;
        var rdParam = "/rp [" + formObject.gnte_no.value + "] /rfonttype60";        //$1                
        viewer.openFile( RD_path + "apps/opus/esd/tes/guaranteemanage/guaranteemanage/report/ESD_TES_2003.mrd", RDServer + rdParam, {timeout:1800});
    }
	/**
	 * reset form
	 * @param {form object}		formObj
	 * @param {sheet object}	sheetObj
	 * @return
	 */
	function resetForm(formObj, sheetObj){
		formObj.email_addr.value = '';
		formObj.fax_num.value = '';
		formObj.email_addr.focus();
	}	
	/**
	 * Sync sheet data 
	 * @param {object} obj	text box
	 * @return
	 */
	function syncData(obj){
		eval( "sheetObjects[0].SetCellValue(1,'"+obj.name+"', '"+obj.value+"');" );
	 }
	/**
	 * Processing After the sheet retrieved.. <br>
	 * 
	 * @param{ibsheet}		sheetObj	Sheet Object
	 * @param{string}		errMsg		Error Message
	 */
	 function sheet_OnSaveEnd(sheet, errMsg) {
		 ComShowCodeMessage('TES70202');
		 loadPage();
	 }
    /**
     * UI 표준화관련 하단 여백 설정
     */
    function resizeSheet() {
    	ComResizeSheet(sheetObjects[0]);
    }