	/*
	=========================================================
	*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
	*@FileName   : EES_MST_0025.js
	*@FileTitle  : Container Status Creation-LST and FND 
	*@author     : CLT
	*@version    : 1.0
	*@since      : 2014/06/04
	=========================================================
	*/
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
	 * @class EES_MST_0025 : business script for EES_MST_0025
	 */

	// common static variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	var IBSEARCH02=30;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick() {
		var sheetObject1=sheetObjects[0];
		/** **************************************************** */
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
			case "btn_master":
				if (sheetObjects[0].RowCount() != 0 ) {
					var cntr_no=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"cntr_no");
					if (sheetObjects[0].GetRowStatus(sheetObjects[0].GetSelectRow()) != "D"){
						var cntr_no_len=cntr_no.length;
						if ( cntr_no_len > 10 ) {
							cntr_no=cntr_no.substring(0,10);
						} 
						ComOpenPopup("/opuscntr/EES_MST_0019_POP.do?popup_mode=Y&cntr_no="+cntr_no,1100, 630, "", "1,0,1,1,1,1,1,1", true);
					}
				}
				break;  		
				
	    	case "btns_calendar1":     		
	    		if(!formObject.input_cntr_sts_evnt_dt2.disabled){
					var cal=new ComCalendar();
					cal.select(formObject.input_cntr_sts_evnt_dt2, 'yyyy-MM-dd');
	    		}
				break;
				
			case "ComOpenPopupWithTarget1":
	    		if(!formObject.input_onh_yd_cd.disabled){			
	 		        ComOpenPopupWithTarget('/opuscntr/COM_ENS_061.do', 1000, 530, "3:input_onh_yd_cd", "0,0,1,1,1,1,1", true);
	   		        if (formObject.input_onh_yd_cd.value == ""){
	   		        	formObject.yd_cd_nm.value="";
	   		        }
	            	if (formObject.input_onh_yd_cd.value.length > 0 && formObject.input_onh_yd_cd.value.length != 7){
	            		ComShowCodeMessage("MST01019", formObject.input_onh_yd_cd.value);
	            		formObject.input_onh_yd_cd.value="";
	            		formObject.yd_cd_nm.value="";
	            		ComSetFocus(formObject.input_onh_yd_cd);
	            		return;
	            	} else {
	            		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH02);
	            	} 	    			
	    		}
				break;   	
				
			case "btn_add":
					sheetObject1.DataInsert(-1);
					sheetObject1.SelectCell(sheetObject1.GetSelectRow(),"cntr_no", true);
				break;
				
			case "btn_delete":
				if(sheetObject1.FindCheckedRow("Sel")=="")
				{
					ComShowCodeMessage("MST00010");
				}
				else if(ComShowCodeConfirm("MST00005")) 
				{ 
					doActionIBSheet(sheetObject1,formObject,IBDELETE);
				}
				break;
				
			case "btn_retrieve":
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
				ComBtnEnable("btn_add");
				break;
				
			case "btn_new":
				formObject.input_cntr_sts_cd.disabled=false;
				formObject.input_cntr_sts_evnt_dt2.disabled=false;
				formObject.input_onh_yd_cd.disabled=false;
				ComBtnEnable("btn_add");
				ComBtnEnable("btn_loadexcel");			
				formObject.input_cntr_sts_cd.value="LST";
				formObject.input_cntr_sts_evnt_dt.value="";
				formObject.input_cntr_sts_evnt_dt2.value="";
				formObject.input_onh_yd_cd.value="";
				formObject.yd_cd_nm.value="";
				//formObject.input_cntr_sts_cd.value="";
				formObject.input_cntr_sts_cd.options[0].selected = true;
				sheetObject1.RemoveAll();
				sheetObject1.SetHeaderCheck(0,"Sel",0);
				ComSetFocus(formObject.input_cntr_sts_cd);			
				break;
				
			case "btn_save":
				doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
				break;
				
			case "btn_loadexcel":			
				sheetObject1.RemoveAll();
				if (validateForm(sheetObject1, formObject, "")){
					var aa = sheetObject1.LoadExcel({ Mode:"HeaderMatch",StartRow:"1",WorkSheetNo:"1",Append:false});
				}
				break; 
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	
	
	function sheet1_OnLoadExcel(sheetObj, result, code, msg) {
		if(isExceedMaxRow(msg))return;
		var formObj = document.form;
		  if(result) {
			  var sAction = IBSEARCH;
			  if (validateForm(sheetObj, formObj, sAction)){
		        	for ( var i=sheetObj.HeaderRows();  i <=sheetObj.RowCount() ; i++) {
						sheetObjects[0].SetCellValue(i,"h_save","0",0);
						sheetObjects[0].SetCellValue(i,"cntr_rmk","",0);
							
						formObj.f_cmd.value=SEARCH;
						var sParam1=sheetObj.GetSaveString();
						if (sheetObj.IsDataModified()&& sParam1 == "") return;
						formObj.input_cntr_sts_evnt_dt.value=ComReplaceStr(ComGetObjValue(form.input_cntr_sts_evnt_dt2), "-", "");
						sheetObj.DoSearch("EES_MST_0025GS.do", FormQueryString(formObj)+"&"+sheetObj.GetSaveString(true) );
						
						var cntrnochk=false;
						if(sheetObj.GetCellValue(i, "cntr_tpsz_cd") == ""){
							cntrnochk=true;
							sheetObj.SetCellFontColor(i,"cntr_no","#FF0000");
							sheetObj.SetCellEditable(i, "cntr_no",1);
						} else {
							sheetObj.SetCellEditable(i, "cntr_no",0);
						}
						if (cntrnochk == true)
							ComShowCodeMessage("MST02014");		
		        	}
			  	}
		  }else{
			  initVariable();
		  }
	}

	
	/**
	 * registering IBsheet Object as list
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
		var formObj=document.form;
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		form.input_cntr_sts_cd.options[0].selected = true;
		ComSetFocus(formObj.input_cntr_sts_cd);
		initControl(); 
	}
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		switch (sheetNo) {
		case 1: //sheet1 init
		    with(sheetObj){
			      var HeadTitle="|CNTR No.|TP/SZ|Term|Lessor|Lessor Name|EQ\nStatus|EQ Status\nDate|EQ Status\nYard|F/M|MVMT\nStatus|MVMT Yard|MVMT Date|Remark(s)";
			      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"DummyCheck", Hidden:0, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"Sel" },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:11},
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"lstm_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"vndr_lgl_eng_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_sts_evnt_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"lst_sts_yd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"full_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"crnt_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"cntr_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
			             {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"h_onh_yd_cd" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"h_cntr_sts_cd" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"h_cnmv_evnt_dt" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"h_lst_sts_yd_cd" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"h_lst_sts_seq" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"h_chk1" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"h_chk2" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"h_chk3" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"h_save" } ];
			      InitColumns(cols);
			      SetEditable(1);
			      SetColProperty(0 ,"cntr_no" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
			      SetColProperty(0, "cntr_rmk", {AcceptKeys:"E|[0123456789-~[](){}_|*&^%$#@!,'<>.?/-=\+ ]"});
			     // SetSheetHeight(390);
			      resizeSheet();
	            }
			break;
		}
	}
	
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
		case IBSEARCH: //retrieve
			if (validateForm(sheetObj, formObj, sAction)){
				for(var i=1; i<sheetObjects[0].RowCount()+1; i++){
					sheetObjects[0].SetCellValue(i,"h_save","0",0);
					sheetObjects[0].SetCellValue(i,"cntr_rmk","",0);
				}
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);			
				formObj.f_cmd.value=SEARCH;
				var sParam1=sheetObj.GetSaveString();
				if (sheetObj.IsDataModified()&& sParam1 == "") return;
				formObj.input_cntr_sts_evnt_dt.value=ComReplaceStr(ComGetObjValue(form.input_cntr_sts_evnt_dt2), "-", "");
				sheetObj.DoSearch("EES_MST_0025GS.do", FormQueryString(formObj)+"&"+sheetObj.GetSaveString(true) );
				ComOpenWait(false);
			}
			break;
			
		case IBSAVE: //save
			if (validateForm(sheetObj, formObj, sAction)){
				for(var i=0; i <= sheetObj.RowCount(); i++){
					if (sheetObj.GetCellEditable(i, "cntr_no") == true){
						ComShowCodeMessage("MST02015");
						sheetObj.SelectCell(i, "cntr_no", true);
						return;
					}			
				}
				for(var i=1; i<sheetObjects[0].RowCount()+1; i++){
					sheetObjects[0].SetCellValue(i,"h_save","1",0);
				}
				formObj.f_cmd.value=MULTI;
				if(ComShowCodeConfirm("COM130101")){
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
					sheetObj.DoSave("EES_MST_0025GS.do", FormQueryString(formObj), -1, false);
					ComOpenWait(false);
				}
			}
			break;
			
		case IBDELETE:      // removing
		    var iCheckRow=sheetObj.FindCheckedRow("Sel");
			if(iCheckRow != ""){
				  var arrRow=iCheckRow.split("|");
				  var totalRow = arrRow.length;
				  for (idx = 0; idx <= totalRow -1; idx++){ 
					   sheetObj.RowDelete(totalRow[idx], false);
				  }
			}	
		   	break;	
		   	
		case IBSEARCH02 :
			if (formObj.input_onh_yd_cd.value != ""){
				formObj.f_cmd.value=SEARCH06;
				var sXml=sheetObj.GetSearchData("EES_MST_COMGS.do", FormQueryString(formObj)+"&code="+formObj.input_onh_yd_cd.value+"&yd_chk_flg=N");
				var chk=sXml.indexOf("ERROR");
				if (sXml.indexOf("ERROR")!= -1 || sXml.indexOf("Error")!= -1){
				   sheetObj.LoadSearchData(sXml,{Sync:1} );
				   return;
				}
		    	var codestr=ComXmlString(sXml, "code_nm");
		    	if (codestr == "" && formObj.input_onh_yd_cd.value != ""){
		    		ComShowCodeMessage("MST01019", formObj.input_onh_yd_cd.value);
		    		formObj.input_onh_yd_cd.value="";
		    		formObj.yd_cd_nm.value="";
		    		ComSetFocus(formObj.input_onh_yd_cd);
		    		return;
		    	} else {
		    		formObj.yd_cd_nm.value=codestr;
		    	}
			}
			break;	
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		with (formObj) {
			if(ComIsEmpty(formObj.input_cntr_sts_cd)){
				ComShowCodeMessage("MST00001", "Status Code");			
				return false;
			}
			if(ComIsEmpty(formObj.input_cntr_sts_evnt_dt2)){
				ComShowCodeMessage("MST00001", "Date");			
				return false;			
			}
			if(ComGetDaysBetween(ComGetNowInfo(), formObj.input_cntr_sts_evnt_dt2) > 0){			
				ComShowCodeMessage("MST01006", "Date");			
				formObj.input_cntr_sts_evnt_dt2.value="";
				formObj.input_cntr_sts_evnt_dt.value="";
				return false;
			}
			if(ComIsEmpty(formObj.input_onh_yd_cd)){
				ComShowCodeMessage("MST00001", "Yard");			
				return false;
			}	
			for (var i=1 ; i <= sheetObj.RowCount(); i++){
				if ((sheetObj.GetCellValue(i,"cntr_no") == "")||(sheetObj.GetCellValue(i,"cntr_no") == null)){
					ComShowCodeMessage("MST00001", "CNTR No.");
					return;
				}
			}
			// in case of existing same cntr_no, show message about first duplicated row
			var dupRows = sheetObj.ColValueDupRows("cntr_no");
			var arrRow=dupRows.split(",");
	        if (dupRows != ""){
	   			 //error message : Data is duplicated, Please check data again.
	        	ComShowCodeMessage("MST00002", sheetObj.GetCellValue(arrRow[0],1));
	             for (var i=1; i <= sheetObj.RowCount()+1; i++){
	            	 if (sheetObj.GetCellValue(i,"cntr_no")   == sheetObj.GetCellValue(arrRow[0],"cntr_no")){
	       			     sheetObj.SelectCell(i, "cntr_no", true);
	            	 }
	             }
	   			 return false;			        	
	        }  		
		}
		return true;
	}
	
	 function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		var formObj=document.form; 
		var sheetObj=sheetObjects[0];		
		var rowCount=sheetObj.RowCount();
		if(rowCount > 0){
			formObj.input_cntr_sts_cd.disabled=true;
			formObj.input_cntr_sts_evnt_dt2.disabled=true;
			formObj.btns_calendar1.readonly=true;
			formObj.input_onh_yd_cd.disabled=true;
			formObj.ComOpenPopupWithTarget1.readonly=true;
		}
		
		var cntrnochk=false;
		for (var i=0; i <= sheetObj.RowCount(); i++){
			if(sheetObj.GetCellValue(i, "cntr_tpsz_cd") == ""){
				cntrnochk=true;
				sheetObj.SetCellFontColor(i,"cntr_no","#FF0000");
				sheetObj.SetCellEditable(i, "cntr_no",1);
			} else {
				sheetObj.SetCellEditable(i, "cntr_no",0);
			}
		}
	    if (cntrnochk == true)
	    	ComShowCodeMessage("MST02014");			
	 }
	/** 
	* handling eventsheet1 OnSearchEnd  <br>
	* @param  sheetObj
	* @param  ErrMsg
	* @return 
	*/ 
	function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
		var sheetObj=sheetObjects[0];		
		var rowCount=sheetObj.RowCount();
		var failcnt=0;		
		var failcnt2=0;	
		if(ErrMsg != '' && ErrMsg.length > 0) return;
		for(var i=1; i<rowCount+1; i++){
			if(sheetObj.GetCellValue(i,"h_chk1") == "E"){
		sheetObj.SetCellFontColor(i, "cntr_sts_cd","#FF0000");
				failcnt++;
			}
			if(sheetObj.GetCellValue(i,"h_chk2") == "E"){
				sheetObj.SetCellFontColor(i, "crnt_yd_cd","#FF0000");
				failcnt++;			
			}
			if(sheetObj.GetCellValue(i,"h_chk3") == "E"){
				sheetObj.SetCellFontColor(i, "cnmv_dt","#FF0000");
				failcnt++;			
			}		
			if(sheetObj.GetCellValue(i,"h_chk1") == "" &&	sheetObj.GetCellValue(i,"h_chk2") == "" &&
				sheetObj.GetCellValue(i,"h_chk3") == ""){
				sheetObj.SetCellFontColor(i, "cntr_no","#FF0000");
				failcnt++;	
			}
			if(failcnt > 0){
				failcnt2++;
			}
			failcnt=0;
		}	
		var succCount=rowCount - failcnt2;
		var sMsg="";
		if(rowCount >0){		
			if (succCount > 0 && failcnt2 == 0 ){
				sMsg=ComGetMsg("MST01025", "", "", "");
			}
			if (succCount > 0 && failcnt2 > 0 ){
				sMsg=sMsg + ComGetMsg("MST01027", "", "", "");
			}
			if (succCount == 0 && failcnt2 > 0){
				sMsg=sMsg + ComGetMsg("MST01026", "", "", "");
			}
			ComShowMessage (sMsg);
			if (succCount > 0 && failcnt2 == 0 ) sheetObj.RemoveAll();
		}			
	}
	
	function initControl() {
		var formObj=document.form;
		axon_event.addListenerFormat('beforedeactivate',    'obj_blur',     form);   //- handling OnBeforeDeactivate event of all control except rdoCity
		axon_event.addListenerFormat('focus',   'obj_focus',    form);   //- handling OnBeforeDeactivate event of all control that has dataformat attribute
		// axon_event.addListenerFormat('keydown',	'obj_keydown',	form);   //- when key down
		// axon_event.addListener('keydown',	'ComKeyEnter',	    'form'); //- when key down
		axon_event.addListenerFormat('keyup',	'obj_keyup',	form);   //- when key down
		// axon_event.addListenerFormat('keypress','obj_keypress',	form);   //- when key down  
		axon_event.addListenerForm('change', 'obj_change', formObj);
		ComBtnEnable("btn_add");
	}  	
	
	//handling event blur
	function obj_blur(){
		var formObj=document.form;
		var obj=event.srcElement;
	    if (event.srcElement.name == "input_cntr_sts_evnt_dt2"){
	    	ComAddSeparator(formObj.input_cntr_sts_evnt_dt2);
	    	if (ComGetNowInfo("ymd") < formObj.input_cntr_sts_evnt_dt2.value){
	    		formObj.input_cntr_sts_evnt_dt2.value=ComGetNowInfo("ymd");
	    		ComAlertFocus(formObj.input_cntr_sts_evnt_dt2,ComGetMsg("MST01006", "", "", ""));
	    	} else {
	    		ComAddSeparator(formObj.input_cntr_sts_evnt_dt2, "ymd");
	    	}
	    }
	    else if(event.srcElement.name == "input_onh_yd_cd"){	
	    	if (formObj.input_onh_yd_cd.value.length > 0 && formObj.input_onh_yd_cd.value.length != 7){
	    		ComShowCodeMessage("MST01019", formObj.input_onh_yd_cd.value);
	    		formObj.input_onh_yd_cd.value="";
	    		formObj.yd_cd_nm.value="";
	    		ComSetFocus(formObj.input_onh_yd_cd);
	    		formObj.input_onh_yd_cd.focus();
	    	} 	
	    }    
	}
	
	//handling event focus
	function obj_focus(){
		var formObj=document.form;
		var obj=ComGetEvent();
	    if (ComGetEvent("name") == "input_cntr_sts_evnt_dt2"){		
//	    	ComClearSeparator(formObj.input_cntr_sts_evnt_dt2, "ymd");
	    	ComSetFocus(formObj.input_cntr_sts_evnt_dt2);
	    }	
	}
	
//	function obj_keypress(){
//	    obj=event.srcElement;
//	    if(obj.dataformat == null) return;
//	    window.defaultStatus=obj.dataformat;
//	    switch(obj.dataformat) {
//	        case "ymd":
//	            if(obj.name=="input_cntr_sts_evnt_dt2") ComKeyOnlyNumber(this, "-");
//	            break;
//	        case "engup":
//	        	if(obj.name=="input_onh_yd_cd") ComKeyOnlyAlphabet('uppernum');
//	            break;
//	    }        
//	}
	function obj_keyup() {
		var vKeyCode=event.keyCode;
		var formObj=document.form;
		switch (ComGetEvent("name")) {
			case "input_onh_yd_cd":
		    	if (formObj.input_onh_yd_cd.value.trim().length == 7){
		    		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH02);
		    	} 			
		    	else if (vKeyCode == 13 || vKeyCode == 9 && (formObj.input_onh_yd_cd.value.length > 0)){
		    		ComShowCodeMessage("MST01019", formObj.input_onh_yd_cd.value);
		    		formObj.input_onh_yd_cd.value="";
		    		formObj.yd_cd_nm.value="";
		    		ComSetFocus(formObj.input_onh_yd_cd);
		    		formObj.input_onh_yd_cd.focus();				
				}
		    break;	
		}
	}	
	function obj_change(){
		var formObj=document.form;
		if (formObj.input_onh_yd_cd.value.trim().length == 7){
    		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH02);
    	}
	}	
	// retrieving after inserting Container No
//	function sheet1_OnChange(sheetObj, Row,Col, Value){
//		var sName=sheetObj.ColSaveName(Col);
//		if(sName == "cntr_no"){	
//			if(Value.length == 11){				
//				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
//			}
//		}
//	}
	function sheet1_OnKeyUp(SheetObj, Row, Col, KeyCode, Shift){
		var formObj=document.form;
		var sName=SheetObj.ColSaveName(Col);
	 	 var celltxt=SheetObj.GetEditText();
	 	 var celltxt1=SheetObj.GetCellValue(Row, "cntr_no");
	   	 if (celltxt == "" && celltxt1 != ""){
	   		 celltxt=celltxt1;
	   	 } 
	
	    if (sName == "cntr_no" && (celltxt.length == 11 || KeyCode == 13)){
	    	SheetObj.SetCellValue(Row,"cntr_no",celltxt.toUpperCase(),0);
			if (formObj.input_cntr_sts_cd.value == "") {
				ComShowCodeMessage("MST00001", "Status Code");
				ComSetFocus(formObj.input_cntr_sts_cd);
				return;
			}  
			if (formObj.input_cntr_sts_evnt_dt2.value == "") {
				ComShowCodeMessage("MST00001", "Date");
				ComSetFocus(formObj.input_cntr_sts_evnt_dt2);
				return;  
			}
			if (formObj.input_onh_yd_cd.value == "") {
				ComShowCodeMessage("MST00001", "Yard");
				ComSetFocus(formObj.input_onh_yd_cd);
				return;
			}
	    	doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
	    	
	    	//for (var i=1; i <= SheetObj.RowCount(); i++){
				if(SheetObj.GetCellValue(Row, "cntr_tpsz_cd") == ""){
					SheetObj.SetCellEditable(Row, "cntr_no",1);
				} else {
					SheetObj.SetCellEditable(Row, "cntr_no",0);
				}
			//}
  
	    } 

	}
	
	/**
	 * sheet1_OnChange
	 * @param SheetObj, Row, Col, Value
	 */
	function sheet1_OnChange(SheetObj, Row, Col, Value){	
		switch( SheetObj.ColSaveName(Col)  ){
		
		    case 'cntr_no' :
		    	if(SheetObj.GetCellValue(Row , "cntr_no") != "" && SheetObj.GetCellValue(Row , "cntr_no").length != 11){
			    	ComShowCodeMessage("MST02010");
			    	//sheetObjects[0].SetCellFontColor(Row, "cntr_no", "#FF0000");
			    	sheetObjects[0].SetCellValue(Row, "cntr_no", "", 0);
		    	} 
		    break;
		    
		}
	}
	
	function resizeSheet(){
 	    ComResizeSheet(sheetObjects[0]);
 	}
