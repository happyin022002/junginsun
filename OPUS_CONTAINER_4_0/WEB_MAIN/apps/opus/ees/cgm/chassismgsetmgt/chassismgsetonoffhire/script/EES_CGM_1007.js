/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1007.js
*@FileTitle  : Chassis Pool Inquiry/Update
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================
*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class ees_cgm_1007 : ees_cgm_1007 business script for
 */
//	function ees_cgm_1007() {
//		this.processButtonClick=tprocessButtonClick;
//		this.setSheetObject=setSheetObject;
//		this.loadPage=loadPage;
//		this.initSheet=initSheet;
//		this.initControl=initControl;
//		this.doActionIBSheet=doActionIBSheet;
//		this.setTabObject=setTabObject;
//		this.validateForm=validateForm;
//	}
	/* developer jop */
	// common global variables
	var tabObjects=new Array();
	var tabCnt=0;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var dataCount;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	var gBtnName=["btn_add", "btn_delete"];
	// Event handler processing by button name */
	function processButtonClick() {
		/***** use additional sheet var in case of more than 2 tap each sheet *****/
		var sheetObject=sheetObjects[0];
		var sheetObj=sheetObjects[0];
		/*******************************************************/
		var formObj=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
			case "btn_add":
				//
				if(formObj.btn_status.value == "R") {
				    return;
				}
				var Row=sheetObj.DataInsert();
				sheetObj.SetCellValue(Row, "chss_pool_cdw","");
				// 
				sheetObj.SetRowStatus(i,"U");
				sheetObj.SetCellValue(i, "eq_knd_cd",document.forms[0].eq_knd_cd.value);
				// CELL EDITABLE - FALSE
				sheetObj.SetCellEditable(Row, "eq_tpsz_cd",0);
				sheetObj.SetCellEditable(Row, "crnt_yd_cd",0);
				sheetObj.SetCellEditable(Row, "chss_pool_cd",0);
				// combo function call
				popupCall();
				break;
				
			case "btn_delete":
				if(formObj.btn_status.value == "R") {
				    return;
				}
				rowDelete(sheetObj);
				break;
				
			case "btn_loadexcel":
				doActionIBSheet(sheetObj,formObj,IBLOADEXCEL);
				
		    	break;
		    	
			case "btn_downexcel":
				if(sheetObj.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
        	    } else{
        	    	doActionIBSheet(sheetObj,formObj,IBDOWNEXCEL);
        	    }
		    	break;
			case "btn_retrieve":
				formObj.eq_no.value="";
		    	ComBtnDisable("btn_add");
		    	ComBtnDisable("btn_delete");
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
				formObj.btn_status.value="R"
				popupCall();
				break;
				
			case "btn_new":
				objectClear();
				formObj.btn_status.value="N"
				// 
		    	ComBtnEnable("btn_add");
		    	ComBtnEnable("btn_delete");
				break;
				
			case "btn_update":
				var chkRows=sheetObj.FindCheckedRow("del_chk");
//				if(chkRows != ""){
//					var arrChkRows=chkRows.split("|");
//					var cellText;
//					for(k=0; k < arrChkRows.length; k++){
//						cellText=sheetObj.GetCellValue(arrChkRows[k], "chss_pool_cdw");
//					}
//				}
				if(chkRows == "")
				{
					ComShowCodeMessage("CGM10009", " To-Be Pool");
					return;
				}
				doActionIBSheet(sheetObj, formObj, IBSAVE);
				formObj.eq_no.value="";
		    	ComBtnDisable("btn_add");
		    	ComBtnDisable("btn_delete");
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
				formObj.btn_status.value="R"
				popupCall();
				break;
				
			case "ComOpenPopupWithTargetLoc":
	        	var tmp=combo_location.GetSelectText();
	        	if (tmp == "RCC"){
	        		ComOpenPopup('/opuscntr/COM_ENS_051.do', 1000, 460,"setProgramNo2", "0,1,1,1,1,1", true, false);
	        	} else if(tmp == "LCC"){
	        		ComOpenPopup('/opuscntr/COM_ENS_051.do', 1000, 460,"setProgramNo2", "0,1,1,1,1,1", true, false);
	        	} else if(tmp == "SCC"){
	        		ComOpenPopup('/opuscntr/COM_ENS_051.do', 1000, 460,"setProgramNo2", "0,1,1,1,1,1", true, false);
	        	}
	  			break;
	  			
			case "ComOpenPopupWithTargetYard":
				ComOpenPopup("/opuscntr/COM_ENS_061.do", 800, 540, "setProgramNo", "0,1,1,1,1,1", true, false);
	  			break;
			}
			tRoleApply();
		} catch(e) {
	 		if( e == "[object Error]") {
	     		ComShowMessage(OBJECT_ERROR);
	 		} else {
	     		ComShowMessage(e.message);
	 		}
	 	}
	}
	/**
	 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items 
	 * defining list on the top of source
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * implementing onLoad event handler in body tag / adding first-served functions after loading screen.
	 *
	 */
	function loadPage() {
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		sheetObjects[0].SetWaitImageVisible(0);
	     var formObj=document.form;
		 var sheetObj=sheetObjects[0];
	     axon_event.addListener("change","sheet1_OnChange","eq_no");
		 // POOl
		 comboCnt=0;
	  	 comboObjects[comboCnt++]=combo_chss_pool_cd;
	  	 // LOCATION
	  	 comboObjects[comboCnt++]=combo_location;
	  	 // Active Status
	  	 comboObjects[comboCnt++]=combo_aciac_div_cd;
	  	 for(var k=0;k<comboObjects.length;k++){
	  		 initCombo(comboObjects[k]);
		 }
		 // Active St. MultiCombo value reset
	  	 var arrActive=new Array();
	   	 arrActive[0]="A|Active";
	  	 arrActive[1]="I|In-active";
	  	 makeComboObject(combo_aciac_div_cd, arrActive, 1, 0, 1);
	     doActionIBSheet(sheetObjects[0], document.form, IBRESET);
		 tRoleApply();
	     sheetObj.SetWaitImageVisible(1);
	}
	/**
	 * sheet setting and init in case of load finish <br>
	 * @param  
	 * @return 
	 * @author 
	 * @version 
	 */     
	 function sheet1_OnLoadFinish(sheetObj) {
	 } 
	 
	 function resizeSheet( ){
		 ComResizeSheet( sheetObjects[0] );
	 }
	/**
	 * setting sheet initial values and header param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		switch (sheetNo) {
		case 1: // sheet1 init
		    with(sheetObj){
			      var HeadTitle="ibflag||Seq.|Chassis No.|Type/Size|Yard|Active Status|Current Pool|To-be Pool|eq_knd_cd|chss_rgst_upd_ofc_cd|chss_rgst_upd_id|chss_rgst_upd_dt";
			      var headCount=ComCountHeadTitle(HeadTitle);
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
			             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
			             {Type:"Text",     Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"eq_no",                 KeyField:1 , InputCaseSensitive:1},
			             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"eq_tpsz_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"crnt_yd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"aciac_div_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:0,   SaveName:"chss_pool_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"chss_pool_cdw",         KeyField:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eq_knd_cd",             KeyField:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"chss_rgst_upd_ofc_cd",  KeyField:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"chss_rgst_upd_id",      KeyField:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"chss_rgst_upd_dt",      KeyField:0 } ];
			      InitColumns(cols);
			      SetEditable(1);
//			      SetSheetHeight(420);
			      resizeSheet( );
			      SetColProperty(0 ,"eq_no" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
	            }
			break;
		}
	}
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		switch (sAction) {
		// SEARCH LOGIC
		case IBSEARCH:
			if(validateForm(sheetObj,formObj,sAction)){
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);	
				formObj.f_cmd.value=SEARCH;
				var sXml=sheetObj.GetSearchData("EES_CGM_1007GS.do" , FormQueryString(formObj));
				dataCount=ComGetTotalRows(sXml);	 		// data count
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				
			}
			break;
		// SAVE LOGIC
		case IBSAVE:
			with(sheetObjects[0]) {
			    var chkRows=FindCheckedRow("del_chk")
			}
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);			
			formObj.f_cmd.value=MULTI;
			sheetObj.DoSave("EES_CGM_1007GS.do", FormQueryString(formObj));
			ComOpenWait(false);			
			break;
			
		case IBLOADEXCEL:		// EXCEL UPLOAD
			if (sheetObj.RowCount() >= 1)
			{
				sheetObj.RemoveAll();
			}
			sheetObj.LoadExcel();
			break;
			
		case IBDOWNEXCEL:     	// EXCEL DOWNLOAD
			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1, KeyFieldMark:0 });
			break;		
			
	 	case IBSEARCH_ASYNC02:	
			formObj.f_cmd.value=SEARCH02;
			var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
			var cols=ComCgmXml2ComboString(sXml, "code1", "desc1");
	 	  	ComCgmMakeMultiCombo1007(combo_chss_pool_cd, cols, 0, 0);
			break;
			
		case IBSEARCH_ASYNC04:
			formObj.f_cmd.value=SEARCH;
			formObj.intg_cd_id.value=COM_CD_TYPE_CD02117;
			var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
			var sStr=ComGetEtcData(sXml,"comboList");
			var arrStr=sStr.split("@");
			// COMBO CONTROL, result string TEXT INDEX, CODE INDEX
			MakeComboObject2(comboObjects[1], arrStr, 0, 0);
			break;
			
		case SEARCH02:
	 	  	break;
	 	  	
	    case IBSEARCH_ASYNC08:
	    	formObj.f_cmd.value=SEARCH17;
	    	var combo_location=combo_location.GetSelectText();
	    	if(combo_location == "RCC")
	    	{
	    		formObj.eq_orz_cht_chktype.value="RCC";
	    		formObj.eq_orz_cht_rcc_cd.value=formObj.scc_cd.value;
	    	}else if(combo_location == "LCC")
	    	{
	    		formObj.eq_orz_cht_chktype.value="LCC";
	    		formObj.eq_orz_cht_lcc_cd.value=formObj.scc_cd.value;
	    	}else if(combo_location == "SCC")
	    	{
	    		formObj.eq_orz_cht_chktype.value="SCC";
	    		formObj.eq_orz_cht_scc_cd.value=formObj.scc_cd.value;
	    	}else
	    	{
	    		formObj.eq_orz_cht_chktype.value="";
	    		formObj.eq_orz_cht_scc_cd.value="";
	    	}
	    	var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
	   		// data count
	        var dataCount=ComGetTotalRows(sXml);
	        if(dataCount==0){
	        	ComShowCodeMessage('CGM10009','combo_location cd');
		   		formObj.scc_cd.value="";
	        }
	  	    break;	
	  	    
		case IBRESET:
			var idx=0
			var sXml2=document.form2.sXml.value;
			var arrXml=sXml2.split("|$$|");
			//Location
			if ( arrXml[idx] == null ) {return;}
			var vArrayListData=ComCgmXml2ListMap(arrXml[idx]);
		    var arrStr1=new Array();
			for ( var i=0; i < vArrayListData.length; i++) {
			    vListData=vArrayListData[i];
			    arrStr1[i]=vListData["code1"] + "|" + vListData["desc1"];
			}
			//MakeComboObject2(combo_location, arrStr1, 0, 0);     
			MakeComboObject2(comboObjects[1], arrStr1, 0, 0);     
			idx++;        		
			if ( arrXml[idx] == null ) {return;}
			var cols=ComCgmXml2ComboString(arrXml[idx], "code1", "desc1");
	 	  	ComCgmMakeMultiCombo1007(combo_chss_pool_cd, cols, 0, 0);
	 	  	idx++;   
	 		objectClear();
	  		break;  	    
		}
		//sheetObj.ShowDebugMsg = false;
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
	  	switch(sAction) {
	  		 case IBSEARCH: 
	  		 	if(formObj.eq_no.value == ''){
	  				if(formObj.crnt_yd_cd.value == ""){
	  					if(formObj.scc_cd.value == ""){
	  						if(combo_chss_pool_cd.GetSelectText() == ""){
	  							ComShowCodeMessage("CGM10004", "Pool Name or Location or Yard");
	  							return false;
	  						}
	  					}
	  				}
	  				if(combo_location.GetSelectText() == undefined || combo_location.GetSelectText() == "") {
	  					ComShowCodeMessage("CGM10004", "location");
	  					return false;
	  				}
	     		}
	       		break;
	  	}      
		return true;
	}
	/**
	 * IBMULTI COMBO
	 */
	function initCombo(comboObj) {
	    switch(comboObj.options.id) {
	    // LOCATION
	    case "combo_chss_pool_cd":
	    	with(comboObj){
	        	Code="";
		        Text="";
	        	SetDropHeight(100);
	        	SetMultiSelect(0);
	        	SetMaxSelect(1);
	            SetEnable(1);
		        SetUseAutoComplete(1);
	    	}
	    	break;
	    case "combo_location":
	    	with(comboObj){
	        	Code="";
	            Text="";
	            SetDropHeight(100);
	            SetMultiSelect(0);
	            SetMaxSelect(1);
	            SetEnable(1);
	            SetUseAutoComplete(1);
	    	}
	    	break;
		case "combo_aciac_div_cd":
	 		var cnt=0;
	        with(comboObj) {
	        	Code="";
	            Text="";
	            SetDropHeight(100);
	            SetMultiSelect(0);
	            SetMaxSelect(1);
	            SetEnable(1);
	            SetUseAutoComplete(1);
	        }
	        break;    	
	    }
	}
	/** 
	 * add combo(POOL COMBO)
	 */ 
	function ComCgmMakeMultiCombo1007(cmbObj, arrStr, txtCol, codeCol) {
		cmbObj.RemoveAll();
		cmbObj.InsertItem(0, "", "");
		var arrCode=arrStr[0].split("|");
		for (var i=0; i < arrCode.length;i++ ) {
			var arrCode2=arrCode[i].split("|");
			cmbObj.InsertItem(i+1, arrCode2[txtCol], arrCode2[codeCol]);
		}
		cmbObj.SetSelectIndex("" ,false);
	}
	/** 
	 * IBSHEET GRID outer combo(LOCATION COMBO)
	 */ 
	function MakeComboObject2(cmbObj, arrStr, txtCol, codeCol) {
//		cmbObj.RemoveAll();
		cmbObj.SetSelectCode(-1);
		for (var i=0; i < arrStr.length;i++ ) {
				var arrCode=arrStr[i].split("|");
				cmbObj.InsertItem(i, arrCode[1], arrCode[codeCol]);
	     	}
		cmbObj.SetSelectIndex("" ,false);
	}
	/**
	 *  init object 
	 */
	function objectClear(){
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		// data reset
		sheetObj.RemoveAll();
		// page reset
		comboObjects[0].SetSelectIndex(0);
		comboObjects[1].SetSelectIndex(0);
		comboObjects[2].SetSelectIndex(1);
		formObj.scc_cd.value="";
		formObj.crnt_yd_cd.value="";
	}
	/**
	 * PROGRAM NO(YARD) inserting
	 */   
	function setProgramNo(aryPopupData, row, col, sheetIdx){
		var formObj=document.form;
		var crnt_yd_cd="";
		var i=0;
		for(i=0; i < aryPopupData.length; i++){
			crnt_yd_cd += aryPopupData[i][3];
			if(i < aryPopupData.length - 1){
				crnt_yd_cd += ",";
			}
		}
		formObj.crnt_yd_cd.value=crnt_yd_cd;
	}
	/**
	 * PROGRAM NO(LOCATION) inserting
	 */   
	function setProgramNo2(aryPopupData, row, col, sheetIdx){
		var formObj=document.form;
		var tmp=combo_location.GetSelectText();
		var scc_cd="";
		var i=0;
		if(tmp == "RCC") {
			for(i=0; i < aryPopupData.length; i++){
				scc_cd += aryPopupData[i][11];
				if(i < aryPopupData.length - 1){
					scc_cd += ",";
				}
			}
			formObj.scc_cd.value=scc_cd;
		}
		else if(tmp == "LCC") {
			for(i=0; i < aryPopupData.length; i++){
				scc_cd += aryPopupData[i][10];
				if(i < aryPopupData.length - 1){
					scc_cd += ",";
				}
			}
			formObj.scc_cd.value=scc_cd;
		}
		else if(tmp == "SCC") {
			for(i=0; i < aryPopupData.length; i++){
				scc_cd += aryPopupData[i][8];
				if(i < aryPopupData.length - 1){
					scc_cd += ",";
				}
			}
			formObj.scc_cd.value=scc_cd;
		}
	}
	 function combo_location_OnChange(comboObj, OlIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod){
	 	document.form.scc_cd.value="";
	 	document.form.combo_location_text.value = comboObj.GetText(parseInt(comboObj.GetSelectIndex()), 0);
	 	document.form.location.value = comboObj.GetSelectCode();
	 }
	 
	 function combo_chss_pool_cd_OnChange(comboObj, OlIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod){
		 document.form.combo_chss_pool_cd_text.value = comboObj.GetText(parseInt(comboObj.GetSelectIndex()), 0);
		 document.form.chss_pool_cd.value = comboObj.GetSelectCode();
	 }
	
	 function combo_aciac_div_cd_OnChange(comboObj, OlIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod){
		 document.form.scc_cd.value="";
		 document.form.combo_aciac_div_cd_text.value = comboObj.GetText(parseInt(comboObj.GetSelectIndex()), 0);
		 document.form.aciac_div_cd.value = comboObj.GetSelectCode();
	 }
	 
	/**
	 * POOL NAME combo 
	 */ 
	function popupCall(){
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		formObj.f_cmd.value=SEARCH02;
		var xml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
	  	var cols=ComCgmXml2ComboString(xml, "code1", "code1|desc1", "\t");
	  	var Cols1=" |"+cols[1];
	  	var Cols0=" |"+cols[0];
	  	sheetObj.SetColProperty(0,"chss_pool_cdw", {ComboText:Cols1, ComboCode:Cols0} );
	}
	/**
	 * key input limit
	 */
//	function obj_keypress(){
//		 obj=event.srcElement;
//		 if(obj.dataformat == null){
//			 return;
//		 }
//		 window.defaultStatus=obj.dataformat;
//		 switch(obj.dataformat) {
//	  	    case "engup":
//		        if(obj.name == "scc_cd"){
//		        	ComKeyOnlyAlphabet("uppernum");
//		        }
//		        break;
//	  	    case "isnum":
//		    	ComKeyOnlyNumber(obj);
//		    	break;
//	  	    case "engbc":
//	  	    	CgmKeyOnlyAlphabet("uppernum");
//		    	break;
//		 }
//	 }
	/**
	 * 1. XML data push to each column.
	 * 2. EXPIRY DATE CODE chage date select ENABLE DISABLE
	 */
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		var prefix="";
		var chk=true;
		with (sheetObj) {
			var colName=ColSaveName(Col);
			switch (colName) {
			case "del_chk":
				if(sheetObj.GetCellValue(Row,"del_chk")!="1")
				{
					sheetObj.SetCellValue(Row,"chss_pool_cdw","");
				}
				break;
			case "chss_pool_cdw":
				if (sheetObj.GetCellValue(Row,"chss_pool_cdw").length > 0)
				{
					sheetObj.SetCellValue(Row,"del_chk","1");
				}
				break;
			case "eq_no":
				if(Row >1){
					// chassis no check
					for(i=1; i<sheetObj.RowCount(); i++){
						if(sheetObj.GetCellValue(i, "eq_no")== Value && Row != i  && sheetObj.GetCellValue(i, "eq_no")!='')
	 					{
				        	ComShowCodeMessage("CGM10017", Value);
				        	// Setting Cell value to Null
							sheetObj.SetCellValue(Row, "eq_no","");
				        	return false;
	 					}
					}
				} 
			 	//server  duplication check
			 	var eqNo=Value;
				// XML data push to each column
				if(eqNo.length > 0) {
					formObj.f_cmd.value=SEARCH;
					document.form.eq_no.value=eqNo;
					var sXml=sheetObj.GetSearchData("EES_CGM_1007GS.do", FormQueryString(formObj));
					if(DomXml2String(sXml, "eq_no") == null || DomXml2String(sXml, "eq_no") == "") {
						// delete cell and focus move
						ComShowCodeMessage("CGM20023", eqNo);
						// Setting Cell value to Null
						sheetObj.SetCellValue(Row, Col,"",0);
						// focus to grid
						sheetObj.SelectCell(Row, Col, true);
						formObj.eq_no.value="";
						return;
					} else {
						// setting cell value
						sheetObj.SetCellValue(Row, "ibflag","U",0);
						sheetObj.SetCellValue(Row, "eq_tpsz_cd",DomXml2String(sXml, "eq_tpsz_cd"),0);
						sheetObj.SetCellValue(Row, "crnt_yd_cd",DomXml2String(sXml, "crnt_yd_cd"),0);
						sheetObj.SetCellValue(Row, "aciac_div_cd",DomXml2String(sXml, "aciac_div_cd"),0);
						sheetObj.SetCellValue(Row, "chss_pool_cd",DomXml2String(sXml, "chss_pool_cd"),0);
						sheetObj.SetCellValue(Row, "eq_knd_cd",DomXml2String(sXml, "eq_knd_cd"),0);
						sheetObj.SetCellValue(Row, "chss_rgst_upd_ofc_cd",DomXml2String(sXml, "chss_rgst_upd_ofc_cd"),0);
						sheetObj.SetCellValue(Row, "chss_rgst_upd_id",DomXml2String(sXml, "chss_rgst_upd_id"),0);
						sheetObj.SetCellValue(Row, "chss_rgst_upd_dt",DomXml2String(sXml, "chss_rgst_upd_dt"),0);
						formObj.eq_no.value="";
						if(DomXml2String(sXml, "aciac_div_cd") == "I")
						{
							SetRowFontColor(Row,"#FF0000");
						}
					}
				}
				break;
			}
		}
	}
	 /**
	  * 엑셀 업로드시 check
	  * @param sheetObj
	  * @author Chae-Shung Cho
	  * @version 2009.10.22
	  */
	function sheet1_OnLoadExcel(sheetObj, result, code, msg){
		if(isExceedMaxRow(msg))return;
		
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		var prefix="";
		var chk=true;
		// chassis no check
		for(iChk=1; iChk<sheetObj.RowCount()+1; iChk++){
			var cellValue=sheetObj.GetCellValue(iChk, "eq_no"); 
			//alert(cellValue);
			if (cellValue != ''){
				formObj.f_cmd.value=SEARCH;
				document.form.eq_no.value=cellValue;
				var sXml=sheetObj.GetSearchData("EES_CGM_1007GS.do", FormQueryString(formObj));
				if(DomXml2String(sXml, "eq_no") == null || DomXml2String(sXml, "eq_no") == "") {
					// setting cell value
					sheetObj.SetCellValue(iChk, "ibflag","U",0);
					sheetObj.SetCellValue(iChk, "eq_no","",0);
					sheetObj.SetCellValue(iChk, "eq_tpsz_cd","",0);
					sheetObj.SetCellValue(iChk, "crnt_yd_cd","",0);
					sheetObj.SetCellValue(iChk, "aciac_div_cd","",0);
					sheetObj.SetCellValue(iChk, "chss_pool_cd","",0);
					sheetObj.SetCellValue(iChk, "eq_knd_cd","",0);
					sheetObj.SetCellValue(iChk, "chss_rgst_upd_ofc_cd","",0);
					sheetObj.SetCellValue(iChk, "chss_rgst_upd_id","",0);
					sheetObj.SetCellValue(iChk, "chss_rgst_upd_dt","",0);
					formObj.eq_no.value="";
				} else {
					// setting cell value
					sheetObj.SetCellValue(iChk, "ibflag","U",0);
					sheetObj.SetCellValue(iChk, "eq_tpsz_cd",DomXml2String(sXml, "eq_tpsz_cd"),0);
					sheetObj.SetCellValue(iChk, "crnt_yd_cd",DomXml2String(sXml, "crnt_yd_cd"),0);
					sheetObj.SetCellValue(iChk, "aciac_div_cd",DomXml2String(sXml, "aciac_div_cd"),0);
					sheetObj.SetCellValue(iChk, "combo_chss_pool_cd",DomXml2String(sXml, "chss_pool_cd"),0);
					sheetObj.SetCellValue(iChk, "eq_knd_cd",DomXml2String(sXml, "eq_knd_cd"),0);
					sheetObj.SetCellValue(iChk, "chss_rgst_upd_ofc_cd",DomXml2String(sXml, "chss_rgst_upd_ofc_cd"),0);
					sheetObj.SetCellValue(iChk, "chss_rgst_upd_id",DomXml2String(sXml, "chss_rgst_upd_id"),0);
					sheetObj.SetCellValue(iChk, "chss_rgst_upd_dt",DomXml2String(sXml, "chss_rgst_upd_dt"),0);
					formObj.eq_no.value="";
					if(DomXml2String(sXml, "aciac_div_cd") == "I")
					{
						sheetObj.SetRowFontColor(iChk,"#FF0000");
					}
				}			
			}
			sheetObj.SetRowStatus(i,"U");
		}
		popupCall();
	}
	function rowDelete(sheetObj){
		for(i=sheetObj.RowCount(); i>0; i--){
	if(sheetObj.GetCellValue(i, "ibflag") != ""   &&  sheetObj.GetCellValue(i, "del_chk")=="1") {
				sheetObj.RowDelete(i, false);
			}
		}
	}
	function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	    if (ErrMsg == undefined || ErrMsg == "") {
			ComShowCodeMessage("CGM00002", "To-Be Pool");
			sheetObjects[0].removeAll();
	    }
	}
	
	function CgmKeyOnlyAlphabet(sFlag){   
	    try { 
	        var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	        var bCanNum=false;
	        //ComDebug('key  = '+keyValue);
	        if (sFlag==undefined || sFlag==null || sFlag.constructor!=String) sFlag="";
	        sFlag=sFlag.toLowerCase();
	        if (sFlag.length > 3){
	            if (sFlag.substr(sFlag.length-3)=="num") bCanNum=true;
	            if (sFlag.length > 5) sFlag=sFlag.substr(0,5);
	        }
	        if(keyValue >= 97 && keyValue <= 122){                  
	            if (sFlag=="upper") event.keyCode=keyValue + 65 - 97;
	             event.returnValue=true;
	        } else if(keyValue >= 65 && keyValue <= 90){            
	            if (sFlag=="lower") event.keyCode=keyValue + 97 - 65;
	             event.returnValue=true;
	        } else if(bCanNum && keyValue >= 48 && keyValue <= 57) {
	             event.returnValue=true;
	        } else if(keyValue == 44){         // ,
	    event.returnValue=true; 
	  } else {   
	             event.returnValue=false;
	        }
	        return true;
	    } catch(err) { ComFuncErrMsg(err.message); }
	}
	
	function makeComboObject(cmbObj, arrStr, txtCol, codeCol, opt) {
//		cmbObj.RemoveAll();
		cmbObj.SetSelectCode(-1);
		if(opt == 0) {
			for (var i=0; i < arrStr.length;i++ ) {
				var arrCode=arrStr[i].split("|");
	    		cmbObj.InsertItem(i, arrCode[txtCol], arrCode[codeCol]);
	        }
		} else if(opt == 1){
			cmbObj.InsertItem(0,"","");
			for (var i=0; i < arrStr.length;i++ ) {
				var arrCode=arrStr[i].split("|");
	    		cmbObj.InsertItem(i+1, arrCode[txtCol], arrCode[codeCol]);
	        }
		}
		cmbObj.SetSelectIndex("" ,false);
	}  
	/**
	 * value check logic
	 * @author  
	 */
//	function obj_keyup(){
//		 var formObj=document.form;
//		 var sheetObj=sheetObjects[0];
//		 obj=event.srcElement;
//		 switch(ComGetEvent("name")){
//	 	 	case "scc_cd":
//		 		var crntLocCd=ComTrimAll(formObj.scc_cd.value);
//		   		var arrCrntLocCd=crntLocCd.split(",");
//		   		for(var i=0; i < arrCrntLocCd.length; i++){
//		 			if(arrCrntLocCd[i] == ''){
//		 				ComShowCodeMessage('CGM10009','Location');
//		 				formObj.scc_cd.value="";
//		 				ComSetFocus(formObj.scc_cd);
//		 				break;
//		 			}else{
//		    	 		//if(formObj.scc_cd.value != ''){
//		    	 		if(formObj.scc_cd.value.length == 5){
//		    	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC08);
//		    	 		}
//		    	 	}
//		 		}
//		 		break;
//		}
//	}
	 /**
	  * function(ex:btn_save) role(trole) apply  <br>
	  * @param  
	  * @return 
	  * @author 
	  * @version 2010.03.05
	  */     
	  function tRoleApply() {
//		  var formObj=document.form;
//		  if(formObj.trole.value == "Authenticated")
//		  {
//		  }else
//		  {
//			  ComBtnDisable("btn_add");
//			  ComBtnDisable("btn_delete");
//			  ComBtnDisable("btn_update");
//		  }
	  } 	
	  
	  function sheet1_OnSearchEnd(sheetObj,ErrMsg){
		  ComOpenWait(false);
		  if(dataCount > 0){ 	 							// data existing
			  for(var i=1; i <= sheetObj.RowCount(); i++){
				  if(sheetObj.GetCellValue(i,"aciac_div_cd") == "I")
				  {
					  sheetObj.SetRowFontColor(i,"#FF0000");
				  }
			  }
		  }
	  }