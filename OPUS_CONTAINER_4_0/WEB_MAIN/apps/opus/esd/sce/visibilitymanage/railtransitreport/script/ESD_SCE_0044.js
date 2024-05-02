	var sheetObjects=new Array();
	var sheetCnt=0;
	document.onclick=processButtonClick;
	
	function processButtonClick(){
		var sheetObject=sheetObjects[0];
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
	        	    case "btn_close":
	        	    	ComClosePopup(); 
	        	        break;
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	
	/**
	 * registering IBSheet Object as list
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */
	function setSheetObject(sheet_obj){
	   sheetObjects[sheetCnt++]=sheet_obj;
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
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetNo) {
			case 1:	  //IBSheet1 init
				with(sheetObj) {
					var HeadTitle="SEQ|F/M|Event|Current|Current|Current|Current|Current|Carrier|MD|Rail Origin|Rail Origin|Rail Destination|Rail Destination|Rail Destination|Train/Truck|Flat Car|BKG NO|WBL NO|Pick-up No|Received Date";
					var HeadTitle1="SEQ|F/M|Event|Location|Description|State|Event Date|Event Date|Carrier|MD|Location|State|Location|State|Description|Train/Truck|Flat Car|BKG NO|WBL NO|Pick-up No|Received Date";
	
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"},
					                { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
	
					var cols = [ {Type:"Seq",   Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",               KeyField:0,  CalcLogic:"",   Format:"engup",  PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",  Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"full_mty_cd",       KeyField:0,  CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",  Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"clm_sght_abbr_nm",  KeyField:0,  CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",  Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",            KeyField:0,  CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",  Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"arr_loc_nm",        KeyField:0,  CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",  Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"arr_ste_cd",        KeyField:0,  CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Date",  Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"arr_date",          KeyField:0,  CalcLogic:"",   Format:"Ymd",    PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",  Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"arr_time",          KeyField:0,  CalcLogic:"",   Format:"Hm",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",  Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"clm_crr_nm",        KeyField:0,  CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",  Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"trsp_mod_tp_cd",    KeyField:0,  CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",  Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"fm_nod_cd",         KeyField:0,  CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",  Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"fm_ste_cd",         KeyField:0,  CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",  Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"to_nod_cd",         KeyField:0,  CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",  Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"to_ste_cd",         KeyField:0,  CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",  Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"dep_loc_nm",        KeyField:0,  CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",  Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"trn_no",            KeyField:0,  CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",  Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"fcar_no",           KeyField:0,  CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",  Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",            KeyField:0,  CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",  Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"wbl_no",            KeyField:0,  CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",  Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pkup_no",           KeyField:0,  CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Date",  Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"rcv_dt",            KeyField:0,  CalcLogic:"",   Format:"YmdHms", PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		       
					InitColumns(cols);
					SetEditable(0);
					SetRangeBackColor(1, 3, 1, 14,"#555555");
					resizeSheet(); 
		      	}
			    break;
		}
	}
	
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
		   case IBSEARCH:
		   		formObj.f_cmd.value=SEARCHLIST ;
		   		sheetObj.DoSearch("ESD_SCE_0044GS.do", SceFrmQryString(formObj));
		   		// next action is onSearchEnd
				break;
		}
	}
	
	function sheet_OnScrollNext(sheetObj,CondParam, PageNo, OnePageRow){
	    var formObj=document.form ;
	    selectVal=SceFrmQryString(formObj);
	    sheetObj.DoSearch("ESD_SCE_0044GS.do", selectVal + "&" + "cur_page=" + PageNo, {Append:true} );
	}

	function sheet_OnSearchEnd(sheetObj, ErrMsg) {
      var formObj = document.form;
      if(formObj.f_cmd.value == SEARCHLIST) {
			formObj.f_cmd.value=SEARCH01;
			sheetObj.DoSearch("ESD_SCE_0044GS.do", SceFrmQryString(formObj) + "&cur_page=1");
      }	else if(formObj.f_cmd.value == SEARCH01) {
			ComEtcDataToForm(formObj, sheetObj);
      }
  }
	
	function resizeSheet(){
	    ComResizeSheet(sheetObjects[0]);
	} 