/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0607_C.js
 *@FileTitle : HTS (Harmonized Tariff Schedule) Code Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
   Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
           MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
           Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------These code are for making JSDoc well ------------------*/
/**
 * @fileoverview 
 * @author 
 */
	/**
	 * @extends 
	 * @class esm_bkg_0607 : esm_bkg_0607 - task script definition for screen
	 */
	function esm_bkg_0607() {
		this.processButtonClick=tprocessButtonClick;
		this.setSheetObject=setSheetObject;
		this.loadPage=loadPage;
		this.initSheet=initSheet;
		this.initControl=initControl;
		this.doActionIBSheet=doActionIBSheet;
		this.setTabObject=setTabObject;
		this.validateForm=validateForm;
	}
	// public variable
	var sheetObjects=new Array();
	var comboObjects=new Array();
	var sheetCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick() {
		/***** If sheets are more than 2 in one tab, use additional sheet variables *****/
		var sheetObject=sheetObjects[0];
		var sheetObject1=sheetObjects[1];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch (srcName) {
			case "btn_Retrieve":
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
				break;
			case "btn_DownExcel":
				doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
				break;
			case "btn_save":                                              
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE); //add save
				break;	
			case "btn_add":
				 var newRow=setDataInsert(sheetObject, 1);
				 break;
			case "btn_del":                                                                                                   
					doActionIBSheet(sheetObjects[0],document.form,IBDELETE); //add del
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
			case "btn_Close":
				ComClosePopup(); 
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
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
	function loadPage() {
		for (i=0; i < sheetObjects.length; i++) {
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
	 * load HTML Control event on the page <br>
	 * {@link #loadPage}call the function and init IBSheet Object <br>
	 * 
	 * @param {ibsheet}
	 *            sheetObj IBSheet Object
	 * @param {int}
	 *            sheetNo sheetObjects 
	 */
	function initControl() {
		var formObject=document.form;
		//Axon Event process1 Event catch(Develoer can change)
	    axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); //- focus in
	    axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject);
//	    axon_event.addListenerFormat('keypress',       'obj_KeyPress',    formObject); //- in case of keyboard input
	    axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
	/*
	    axon_event.addListener('keypress', 'eng_keypress', 'hamo_cd_desc');
	    axon_event.addListener('keypress', 'obj_keypress', 'hamo_trf_cd');
		*/
	}
	/**
	 * setting sheet initial values and header
	 * 
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetId=sheetObj.id;
		switch (sheetId) {
		case "sheet1":
			with(sheetObj){			
				var HeadTitle1="||Del|Seq.|HTS Code|Description|Category|FDA P/N|Effective Date|Expire Date|User ID|Office||Update Date";
				var headCount=ComCountHeadTitle(HeadTitle1);				
				var prefix="sheet1_";
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
				 {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"Sel",            KeyField:0,   CalcLogic:"",   Format:undefined },
				 {Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"delt_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"Seq" },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"hamo_trf_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:10 },
				 {Type:"Text",      Hidden:0, Width:350,  Align:"Left",    ColMerge:0,   SaveName:prefix+"hamo_cd_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   EditLen:1000 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"hamo_cate_ctnt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   EditLen:50 },
				 {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"fda_decl_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Date",      Hidden:0, Width:100,   Align:"Center",  ColMerge:0,   SaveName:prefix+"eff_dt",         KeyField:0,   CalcLogic:"",  Format:"Ymd",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Date",      Hidden:0, Width:100,   Align:"Center",  ColMerge:0,   SaveName:prefix+"exp_dt",         KeyField:0,   CalcLogic:"",  Format:"Ymd",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"upd_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:100,   Align:"Center",  ColMerge:0,   SaveName:prefix+"hamo_trf_cd_seq",         KeyField:0,   CalcLogic:"",  Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"upd_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				   
				InitColumns(cols);
				SetSheetHeight(400);
				SetEditable(1);
				//SetGetCountPosition()(0);
				SetColProperty(prefix+"fda_decl_flg", {ComboText:"Y|N", ComboCode:"Y|N"} );
				SetColProperty(prefix+"delt_flg", {ComboText:"Y|N", ComboCode:"Y|N"} );
				SetColProperty(prefix+"hamo_trf_cd", {AcceptKeys:"[0123456789]"} );
				SetColHidden("check",1);
			}
			break;
		}
	}
	 /**
	  * setDataInsert 호calling .<br>
	  * DELT FLG를 'N'로setting 
	  * @param sheetObj, sNo
	  */
		function setDataInsert(sheetObj, sNo) {
			var formObj=document.form;
			switch (sNo) {
			case 1:
				var prefix="sheet1_";
				var nRow=sheetObj.DataInsert(-1);
				var todate = new Date();
				sheetObj.SetCellValue(nRow, prefix + "delt_flg",'N');
				sheetObj.SetCellValue(nRow, prefix + "eff_dt",""+todate.getFullYear()+"-"+ComLpad(todate.getMonth()+1,2,"0")+"-"+ComLpad(todate.getDate(),2,"0"));
				break;
			}
			return nRow;
		}
	// handling sheet process
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
		case IBCLEAR: // code retrieve
			formObj.f_cmd.value=INIT;
			var sXml=sheetObj.GetSearchData("ESM_BKG_0607GS.do", FormQueryString(formObj));
			var arrXml=sXml.split("|$$|");
			if (arrXml.length > 0) 
				ComXml2ComboItem(arrXml[0], hamo_tp_cd, "val", "val|name");
				ComSetObjValue(hamo_tp_cd,ComGetObjValue(formObj.sel_hamo_tp_cd));
			break;
		case IBSEARCH: //retrieve
			if (validateForm(sheetObj, formObj, sAction)){
				formObj.f_cmd.value=SEARCH;
				sheetObj.DoSearch("ESM_BKG_0607GS.do", FormQueryString(formObj )+ "&" + ComGetPrefixParam("sheet1_"));

			}		
			break;
		case IBSAVE:        //Save
			if(!validateForm(sheetObj,formObj,sAction)) {
				return;
			}//end if
	        formObj.f_cmd.value=MULTI;		        
	        sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
	        var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
	        sheetObj.DoSave("ESM_BKG_0607GS.do", sParam);
		break;
		case IBDELETE:      // remove	 		
			ComRowHideDelete(sheetObj, "sheet1_Sel");
		    ComBtnEnable("btn_save");
//			ComRowHideDelete(sheetObj,"Sel");
		break;
		case IBDOWNEXCEL:      // input
			sheetObj.SetHeaderBackColor("#CCCCCC");
			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
			sheetObj.SetHeaderBackColor("#333333");			
			break;	
		}	
 		ComOpenWait(false);
	}
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		with (sheetObj) {
			var color1="#CCFFFD";
		}
	}
	/**
	 * In case of selecting check in popup screen, send value to the mother screen. <br>
	 * 
	 * @param {ibsheet}
	 *            sheetObj IBSheet Object
	 * @param {String}
	 *            value 
	 */
	function chkCallPopupOK(sheetObj) {
		var formObj=document.form;
		var calllFunc;
		var rArray=null; 
		// Radio or CheckBox
		rArray=chkGetLocalCheckedRows(sheetObj);
		if(rArray == null) {
			ComShowCodeMessage("COM12114", "row");
			return;
		}
		calllFunc=formObj.calllFunc.value;
		opener.eval(calllFunc)(rArray);
		ComClosePopup(); 
	}
	function chkGetLocalCheckedRows(sheetObj,colName) {
		var checkRows;
		var colsCnt=sheetObj.LastCol()+ 1;
		var rArray=null; // array for row data
		var cArray=null; // array for column data
		checkRows=sheetObj.CheckedRows('radio');
		if(checkRows == 0) {  			
				return null;
			}
			else {
				var idx=0;
	  		rArray=new Array(checkRows);
			for(var i=0; i < sheetObj.RowCount(); i++) {
				if(sheetObj.GetCellValue(i, "radio") == 1) {
		  			cArray=null;
		  			if(colName != null && colName != "") {
		  				cArray=sheetObj.GetCellValue(i, colName);
		  			} else {
		  				cArray=new Array(colsCnt);
			  			for(var j=0; j<cArray.length; j++) {
			  				var iCol=sheetObj.SaveNameCol("hamo_trf_cd");
				        	if (j == iCol) {
				        		cArray[j]=(sheetObj.GetCellValue(i, j)).substr(0,6);
				        	}else{
				        		cArray[j]=sheetObj.GetCellValue(i, j);
				        	}
	                    }
	                } 
	                rArray[idx++]=cArray;
	     		}
	  		}
	  	}
	  	return rArray;
	}
	/**
	  * hamo_tp_cd Combo Change Event
     */
	 function hamo_tp_cd_OnChange(comboObj, OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod){
		 hamo_tp_cd.SetColWidth(0 , 20);
		 hamo_tp_cd.SetColWidth(1 , 80);
		 var title = "";
		 var hTitle1="||Del|Seq.|";
		 var hTitle2="|Description|Category|FDA P/N|Effective Date|Expire Date|User ID|Office||Update Date";
		 
		 if(hamo_tp_cd.GetSelectCode() == "T"){
			 title = "HTS";
		 }else if (hamo_tp_cd.GetSelectCode() == "H"){
			 title = "HS";
		 }
		 cd_title.innerHTML = title;
		 changeHeaderRow(sheetObjects[0] , 0 , hTitle1+title+hTitle2);
		
	 }
	 /**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch(sAction) {
		case IBSAVE:
			var rowCnt=sheetObjects[0].RowCount();
			for( var i=1 ; i <= rowCnt ; i++){
				if(('I' == sheetObj.GetCellValue(i, "sheet1_" + "ibflag")|| 'U' == sheetObj.GetCellValue(i, "sheet1_" + "ibflag"))
					&& '' == sheetObj.GetCellValue(i, "sheet1_" + "eff_dt")
				){
					ComShowCodeMessage("BKG00104","Effective Date");
					return false;
				}
			}
			break;
		}
		return true;
	}