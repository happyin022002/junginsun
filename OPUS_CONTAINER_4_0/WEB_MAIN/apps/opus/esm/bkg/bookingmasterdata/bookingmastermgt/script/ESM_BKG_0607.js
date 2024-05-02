/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   ESM_BKG_0607.js
 *@FileTitle  : Harmonized Tariff Code(HT Code 조회 화면)
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
 Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
 [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
 character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	var sheetObjects=new Array();
	var sheetCnt=0;
	
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick() {
		/***** using extra sheet valuable if there are more 2 sheets *****/
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
				if(sheetObjects[0].RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
				}else{
					doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
				}
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
		var obj = document.getElementById('span_hs_aply_dt_msg');
		if("" == document.form.hs_aply_dt.value && "H"== hamo_tp_cd.GetSelectCode()){
			obj.innerHTML = "No Application Date";
		}
		if (document.form.hamo_trf_cd.value !="" || document.form.hamo_cd_desc.value !="" ){
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}
	/**
	 * loading HTML Control event <br>
	 * @param sheetObj
	 * @param sheetNo
	 */
	function initControl() {
		var formObject=document.form;
	    axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); //- focus out
	    axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject); //- focus in
	    axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
	}
	 /**
	  * setting sheet initial values and header
	  * @param sheetObj
	  * @param sheetNo
	  * @return
	  */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetId=sheetObj.id;
		switch (sheetId) {
		case "sheet1":
			with(sheetObj){
				var HeadTitle1="||Seq.|HTS Code|Description|Category|FDA P/N|Effective Date|Expire Date";
				var headCount=ComCountHeadTitle(HeadTitle1);				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Radio",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"radio",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"check",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
							 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"hamo_trf_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
							 {Type:"Text",      Hidden:0, Width:450,  Align:"Left",    ColMerge:0,   SaveName:"hamo_cd_desc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
							 {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"hamo_cate_ctnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
							 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"fda_decl_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
							 {Type:"Date",      Hidden:0, Width:100,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",         KeyField:0,   CalcLogic:"",  Format:"Ymd",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 							 {Type:"Date",      Hidden:0, Width:100,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",         KeyField:0,   CalcLogic:"",  Format:"Ymd",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } 							 
							 ];
				   
				InitColumns(cols);
				SetSheetHeight(322);
				SetEditable(1);
				SetColHidden("check",1);
				SetColProperty("hamo_trf_cd", {AcceptKeys : "[0123456789]", InputCaseSensitive :1} );
			}
			break;
		}
	}
	/**
	 * handling sheet process
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return void
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
		case IBCLEAR: // retrieve code in case of loading page
			formObj.f_cmd.value=INIT;
			var sXml=sheetObj.GetSearchData("ESM_BKG_0607GS.do", FormQueryString(formObj));
			var arrXml=sXml.split("|$$|");
			if (arrXml.length > 0) 
				ComXml2ComboItem(arrXml[0], hamo_tp_cd, "val", "val|name");
				ComSetObjValue(hamo_tp_cd,ComGetObjValue(document.form.sel_hamo_tp_cd));
			break;
		case IBSEARCH: //retrieve
			
			if (validateForm(sheetObj, formObj, sAction)){
					formObj.f_cmd.value=SEARCH;
					sheetObj.DoSearch("ESM_BKG_0607GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(""));
			}
			var obj1 = document.getElementById('span_hs_aply_dt_msg');
			if("" != document.form.hs_aply_dt.value){
				obj1.innerHTML = "";
			}else if("" != document.form.exp_dt.value){
				obj1.innerHTML = "";
			}
			break;
		case IBDOWNEXCEL:    
			sheetObj.SetHeaderBackColor("#CCCCCC");
			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
			sheetObj.SetHeaderBackColor("#333333");			
			break;	
		}	
	}
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		with (sheetObj) {
			var color1="#CCFFFD";
		}
	}
	/**
	 * sending data to parents windows in casse of selecting check at popup<br>
	 * @param sheetObj
	 * @param value
	 */
	function chkCallPopupOK(sheetObj) {
		var formObj=document.form;
		var calllFunc;
		if (!opener) opener=parent; 
		var rArray=null; // Row data array
		rArray=chkGetLocalCheckedRows(sheetObj);
		if(rArray == null) {
			ComShowCodeMessage("COM12114", "row");
			return;
		}
		calllFunc=formObj.calllFunc.value;
		if(calllFunc != ''){
			eval('opener.'+calllFunc)(rArray);
		}
		ComClosePopup(); 
	}
	function chkGetLocalCheckedRows(sheetObj,colName) {
		var checkRows;
		var colsCnt=sheetObj.LastCol()+ 1;
		var rows = sheetObj.RowCount()+1;
		var rArray=null; // Row data array
		var cArray=null; // Column data array
		checkRows=sheetObj.CheckedRows('radio');
		if(checkRows == 0) {  			
				return null;
		}
		else {
			var idx=0;
	  		rArray=new Array(checkRows);
			for(var i=0; i < rows; i++) {
				if(sheetObj.GetCellValue(i, "radio") == 1) {
		  			cArray=null;
		  			if(colName != null && colName != "") {
		  				cArray=sheetObj.GetCellValue(i, colName);
		  			} 
		  			else {
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
	function hamo_tp_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		 hamo_tp_cd.SetColWidth(0 , 20);
		 hamo_tp_cd.SetColWidth(1 , 80);
		 var title = "";
		 var hTitle1="||Seq.|";
		 var hTitle2="|Description|Category|FDA P/N|Effective Date|Expire Date|User ID|Office|Update Date";
		 
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
		with (formObj) {
		}
		return true;
	}
