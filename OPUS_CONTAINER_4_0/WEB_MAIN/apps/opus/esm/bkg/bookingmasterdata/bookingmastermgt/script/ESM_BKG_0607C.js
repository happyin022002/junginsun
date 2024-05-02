/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0607.js
 *@FileTitle : Harmonized Tariff Code(HT Code 조회 화면)
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
	 * @class esm_bkg_0607 : business script for esm_bkg_0607 
	 */
	function esm_bkg_0607() {
		this.processButtonClick = tprocessButtonClick;
		this.setSheetObject = setSheetObject;
		this.loadPage = loadPage;
		this.initSheet = initSheet;
		this.initControl = initControl;
		this.doActionIBSheet = doActionIBSheet;
		this.setTabObject = setTabObject;
		this.validateForm = validateForm;
	}
	
	
	
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	// Event handler processing by button click event  */
	document.onclick = processButtonClick;
	
	// Event handler processing by button name */
	function processButtonClick() {
		var sheetObject = sheetObjects[0];
		var sheetObject1 = sheetObjects[1];
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch (srcName) {
	
			case "btn_Retrieve":
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
				break;
	
			case "btn_DownExcel":
				doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
				break;
			
			case "btn_save":                                              
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);                                                      
				break;	
				
			case "btn_add":
					sheetObject.DataInsert(-1);
					//addRowEdit(sheetObjects[0],document.form);
				break;
				
			case "btn_del":                                                                                                   
					doActionIBSheet(sheetObjects[0],document.form,IBDELETE);												     
				break;	
			
			case "btn_Print":
				alert("btn_print");
				//doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
				break;
	
			case "btn_confirm":
				comPopupOK();
				break;
				
			case "btn_confirm_6digit":
				
				chkCallPopupOK(sheetObjects[0]);
				break;
				
			case "btn_close":
				window.close();
				break;	
				
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowCodeMessage("COM12111");
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
	function setSheetObject(sheet_obj) {
	
		sheetObjects[sheetCnt++] = sheet_obj;
	
	}
	
	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen
	 */
	function loadPage() {
	
		for (i = 0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		initControl();
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		
		if (document.form.hamo_trf_cd.value !="" || document.form.hamo_cd_desc.value !="" ){
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
		
	
	
		
	}
	
	/**
	 * regstering init event
	 */
	function initControl() {
		var formObject = document.form;
	    axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); //- focus in
	    axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject); //- focus out
	    axon_event.addListenerFormat('keypress',       'obj_KeyPress',    formObject); 
	    axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
	/*
	    axon_event.addListener('keypress', 'eng_keypress', 'hamo_cd_desc');
	    axon_event.addListener('keypress', 'obj_keypress', 'hamo_trf_cd');
		*/
	}
	
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj, sheetNo) {
	
		var cnt = 0;
		var sheetId = sheetObj.id;
	
		switch (sheetId) {
	
		case "sheet1":
			with (sheetObj) {
	
				// setting height
				style.height = 322;
				//setting width
				SheetWidth = mainTable.clientWidth;
	
				//setting Host information[mandatory][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);
	
				//Merge kind [selection, Default msNone]
				MergeSheet = msHeaderOnly;
	
				//Edit kind [selection, Default false]
				Editable = true;
	
				//setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 15, 100);
	
				var HeadTitle1 = "|Sel|Del|Seq.|HTS Code|Description|Category|FDA P/N|User ID|Office|Update Date";
				var headCount = ComCountHeadTitle(HeadTitle1);
	
				//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// setting function handling header
				InitHeadMode(true, true, false, true, false, false)
	
				//setting header row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				
				var prefix="sheet1";
	
				//data property    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				
				//InitDataProperty(0, cnt++, dtRadioCheck, 40, daCenter, false,
						//"radio", false, "", dfNone, 0, true, true);
				
				//InitDataProperty(0, cnt++, dtHidden, 40, daCenter, false,
						//"check", false, "", dfNone, 0, true, true);
				
				InitDataProperty(0, cnt++ , dtCheckBox,		30,		daCenter,		false,		prefix + "Sel", 			false, 	"", 	true );
				
				//InitDataProperty(0, cnt++, dtRadioCheck, 40, daCenter, false,       
					//	"Sel", false, "", dfNone, 0, true, true);                ///////////////
				
				InitDataProperty(0, cnt++ , dtHiddenStatus,	0,    	daCenter,  	 	false,  	prefix + "ibflag");
				
				InitDataProperty(0, cnt++, dtData, 30, daCenter, false,		prefix + "delt_flg");
				InitDataProperty(0, cnt++, dtSeq, 30, daCenter, false,		prefix + "Seq");
				InitDataProperty(0, cnt++, dtData, 80, daCenter, false,		prefix + "hamo_trf_cd", false, "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 720, daLeft, false,		prefix + "hamo_cd_desc", false, "", dfNone, 0, false);
				
				InitDataProperty(0, cnt++, dtData, 80, daLeft, false,		prefix + "hamo_cate_ctnt", false, "", dfNone, 0, false);
				
				InitDataProperty(0, cnt++, dtData, 80, daCenter, false,		prefix + "fda_decl_flg", false, "", dfNone, 0, false);
				
				InitDataProperty(0, cnt++, dtData, 80, daCenter, false,		prefix + "upd_usr_id", false, "", dfNone, 0, false); 
				InitDataProperty(0, cnt++, dtData, 75, daCenter, false,		prefix + "ofc_cd", false, "", dfNone, 0, false); 
				InitDataProperty(0, cnt++, dtData, 85, daCenter, false,		prefix + "upd_dt", false, "", dfNone, 0, false);
				
				
				CountPosition = 0;
				ColHidden("check") = true;
			}
			break;
	
		}
		
	}
	
	// handling sheet process
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
		switch (sAction) {
	
		case IBCLEAR: //retrieving when load page
			formObj.f_cmd.value = INIT;
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0607GS.do", FormQueryString(formObj));
			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 0) 
				ComXml2ComboItem(arrXml[0], formObj.hamo_tp_cd, "val", "val|name");
			
			ComSetObjValue(formObj.hamo_tp_cd,ComGetObjValue(formObj.sel_hamo_tp_cd));
	
			break;
			
		case IBSEARCH: 
		
			if (validateForm(sheetObj, formObj, sAction)){
					formObj.f_cmd.value = SEARCH;
					sheetObj.DoSearch("ESM_BKG_0607GS.do", FormQueryString(formObj)
						+ "&" + ComGetPrefixParam("sheet1"));
			}		
	
			break;
		case IBSAVE:       
			
			if(!validateForm(sheetObj,formObj,sAction)) {
				return;
			}//end if
        
	        formObj.f_cmd.value = MULTI;		        
	        sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
	        var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1");
		        sheetObj.DoSave("ESM_BKG_0607GS.do", sParam);

        
		break;
		
		case IBDELETE:     	 					
        					
			ComRowHideDelete(sheetObj, "Sel");	
		break;
		
			
		case IBDOWNEXCEL:    
			sheetObj.Down2Excel();
			break;	
		}	
		
	}
	
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		with (sheetObj) {
			var color1 = RgbColor(204, 255, 253);
		}
	}
	
	/**
	 * send value to opener in case of select checkbox in popup  <br>
	 * 
	 * @param {ibsheet} sheetObj
	 * @param {String} value 
	 */
	function chkCallPopupOK(sheetObj) {
		var formObj = document.form;
		var calllFunc;
		var rArray = null; 
		rArray = chkGetLocalCheckedRows(sheetObj);
		
		if(rArray == null) {
			ComShowCodeMessage("COM12114", "row");
			return;
		}
		
		calllFunc = formObj.calllFunc.value;
		opener.eval(calllFunc)(rArray);
		window.close();
	}
	 

	
	function chkGetLocalCheckedRows(sheetObj,colName) {
		var checkRows;
		var colsCnt = sheetObj.LastCol + 1;
		var rows = sheetObj.Rows;
		
		var rArray = null; // row data
		var cArray = null; // col data 
		
		checkRows = sheetObj.CheckedRows('radio');
		
		if(checkRows == 0) {  			
				return null;
			}
			else {
				var idx = 0;
	  		rArray = new Array(checkRows);
			for(var i = 0; i < rows; i++) {
				
				if(sheetObj.CellValue(i, "radio") == 1) {					
		  			cArray = null;
		  			if(colName != null && colName != "") {
		  				cArray = sheetObj.CellValue(i, colName);
		  			} else {
		  				cArray = new Array(colsCnt);
		  				
			  			for(var j=0; j<cArray.length; j++) {
			  				var iCol = sheetObj.SaveNameCol("hamo_trf_cd");
				        	if (j == iCol) {
				        		cArray[j] = (sheetObj.CellValue(i, j)).substr(0,6);
				        	}else{
				        		cArray[j] = sheetObj.CellValue(i, j);
				        	}
	                    }
	                } 
	                rArray[idx++] = cArray;
	     		}
	  		}
	  	}
	  	return rArray;
	}

	/**
	  * hamo_tp_cd Combo Change Event
     */
	 function hamo_tp_cd_OnChange(comboObj,value,text){
		 var formObj  = document.form;
		 var arrText = text.split("|");
		
		 if (arrText.length > 1){
			 cd_title.innerHTML = arrText[1];
		 }else{
			 if (ComGetObjValue(formObj.sel_hamo_tp_cd)=="H"){
				 cd_title.innerHTML = "HS";
			 }
			 
		 }
		 formObj.hamo_trf_cd.focus();
	 }
	 /**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		with (formObj) {
		
		}
		return true;
	}
