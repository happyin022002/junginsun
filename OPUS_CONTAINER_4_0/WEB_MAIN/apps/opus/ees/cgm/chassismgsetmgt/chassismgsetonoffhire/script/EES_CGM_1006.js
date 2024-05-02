/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1006.js
*@FileTitle  : Chassis Registration Inquiry/Update 
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
 * @class ees_cgm_1006 : ees_cgm_1006 business script for
 */
	var tabObjects=new Array();
	var tabCnt=0;
	var curYear="";
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
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
			var Row=0;
			switch (srcName) {
			case "btn_add":
				var iRow=sheetObj.RowCount();
				//alert("iRow : " + iRow);
				Row=sheetObject.DataInsert();
				sheetObj.SetRowStatus(Row,"U");
				break;
			case "btn_del":
				sheet_delete(sheetObj);
				break;
			case "btn_downexcel":
				if(sheetObj.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
        	    } else{
        	    	doActionIBSheet(sheetObj,formObj,IBDOWNEXCEL);
        	    }
				
				break;
			case "btn_loadexcel":
				doActionIBSheet(sheetObj,formObj,IBLOADEXCEL);
				
				break;
			case "btn_retrieve":
				if( formObj.eq_no_to.value != ""){
					if( formObj.eq_no_fm.value == ""){
						ComShowCodeMessage("CGM10004", "Chassis No");
						return;
					}
				}
				if( formObj.chss_rgst_lic_noa.value != ""){
					if( formObj.chss_rgst_lic_no.value == ""){
						ComShowCodeMessage("CGM10004", "License No");
						return;
					}
				}
				if (formObj.chss_veh_id_no.value == ""){
					if(formObj.chss_rgst_lic_no.value == ""){
						if(formObj.chss_rgst_exp_dt.value == ""){ 
							if( formObj.eq_no_fm.value == ""){
								ComShowCodeMessage("CGM10004", "Chassis No");
								return;
							}
						}
					}
				}
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				// STATE CODE retrieve
				doActionIBSheet(sheetObject, formObj, SEARCH08);
				// IBSHEET retrieve
				doActionIBSheet(sheetObject, formObj, IBSEARCH);
				ComOpenWait(false);
				break;
			case "btn_new":
				sheetObject.RemoveAll();
				//reset function call
				objectClear();
				break;
			case "btn_save":
				doActionIBSheet(sheetObject,formObj,IBSAVE);
				break;
			} // end switch
			tRoleApply();
	  }catch(e) {
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
			// 
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			// 
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		sheet1_OnLoadFinish(sheetObjects[0]);
	}
	 /**
	 * sheet setting and init in case of load finish <br>
	 * @param  
	 * @return 
	 * @author 
	 * @version 
	 */     
	 function sheet1_OnLoadFinish(sheetObj) {
	     sheetObj.SetWaitImageVisible(0);
	 	 var formObj=document.form;
		 var sheetObj=sheetObjects[0];     
		 axon_event.addListener		("change",		"sheet1_OnChange",	"chss_rgst_prd_cd");
		 axon_event.addListener		("change",		"obj_change","eq_no_fm","eq_no_to");
	     doActionIBSheet(sheetObjects[0], document.form, IBRESET);
	     tRoleApply();
	     sheetObj.SetWaitImageVisible(1);
	 }
	 
	function resizeSheet(){
	    ComResizeSheet( sheetObjects[0] );
	}
	
	function obj_change(){
		var sheetObj=sheetObjects[0];
		var formObj=document.form;
		var obj=ComGetEvent(); 
		switch(ComGetEvent("name")){
			case "eq_no_fm":
				if(formObj.eq_no_fm.value != "" && formObj.eq_no_fm.value != null){
					formObj.eq_no_fm.value = formObj.eq_no_fm.value.substring(0,4)+ComLpad(formObj.eq_no_fm.value.substring(4),6,"0");
				}
				break;	
			case "eq_no_to":
				if(formObj.eq_no_to.value != "" && formObj.eq_no_to.value != null){
					formObj.eq_no_to.value = ComLpad(formObj.eq_no_to.value,6,"0");
				}
				break;	
		}
		
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
			      var HeadTitle="Status||Seq.|Chassis No.|Type/Size|Manufacture Date|Weight(lbs)|Reg. State|Reg. Year|Expiry Date|Expiry Date|License No.|Vehicle ID No.|Title No.|Alias No.1|Alias No.2|On-hire Yard|On-hire Office|On-hire Date|On-hire By|Update Date|Update By|eq_knd_cd";
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1, FrozenCol:9} );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
			      InitHeadColumn("col1", "Initial Plan|Monthly Request\n(ADD / TRS)|Monthly Request\n(ADD / TRS)|Monthly Request\n(ADD / TRS)|Monthly Request\n(ADD / TRS)|Monthly Request\n(ADD / TRS)|Monthly Request\n(ADD / TRS)|Monthly Request\n(ADD / TRS)|Monthly Request\n(ADD / TRS)|Monthly Request\n(ADD / TRS)|Monthly Request\n(ADD / TRS)|Monthly Request\n(ADD / TRS)|Monthly Request\n(ADD / TRS)|", daCenter);
			      InitHeadColumn("col2", ""+curYear+"|JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC", daCenter);
			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
			             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eq_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 },
			             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"eq_tpsz_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"PopupEdit", Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"mft_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Int",       Hidden:0,  Width:75,   Align:"Right",   ColMerge:0,   SaveName:"chss_tare_wgt",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Combo",     Hidden:0, Width:115,  Align:"Center",  ColMerge:0,   SaveName:"chss_rgst_ste_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"chss_rgst_yr",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
			             {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"chss_rgst_prd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, ComboText:"PMNT|Fixed", ComboCode:"P|F" },
			             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"chss_rgst_exp_dt",  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"chss_rgst_lic_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:12 },
			             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"chss_veh_id_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
			             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"chss_tit_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:15 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"chss_als_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n2nd_chss_als_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"onh_yd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"onh_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cre_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cre_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"chss_rgst_upd_dt",  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"chss_rgst_upd_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eq_knd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			      InitColumns(cols);
			      SetEditable(1);
			      SetShowButtonImage(2);
			      
			      SetColProperty(0 ,"eq_no" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
			      SetColProperty(0 ,"chss_als_no" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
			      SetColProperty(0 ,"n2nd_chss_als_no" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
//			      SetSheetHeight(440);
			      resizeSheet();
	      		}
			break;
		}
	}
	/**
	 * handling process for Sheet
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSEARCH: // retrieve
			if(validateForm(sheetObj,formObj,sAction)){
				var Row=0;
				formObj.f_cmd.value=SEARCH;
				formObj.eq_no_tmp.value=""; 
				sheetObj.DoSearch("EES_CGM_1006GS.do", FormQueryString(formObj) );
				if(sheetObj.RowCount() < 1) 
				{
					return; 
				}
				formObj.eq_no_tmp.value="";
			}
			break;
		case IBSAVE: // saving(check box에 선택된 행만 SAVE 로직을 태움.)
			if(validateForm(sheetObj,formObj,sAction)){ 
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);				
				formObj.f_cmd.value=MULTI;
				
				if(sheetObj.DoSave("EES_CGM_1006GS.do", FormQueryString(formObj))) {
					
				} else {
					ComOpenWait(false);
				}
						
			}
			break;
			
		case SEARCH08:
			//multi combo in grid
			formObj.f_cmd.value=SEARCH08;
			var xml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
	 	  	var cols=ComCgmXml2ComboString(xml, "code1", "code1|desc1", "\t");
	 	  	sheetObj.SetColProperty(0,"chss_rgst_ste_cd", {ComboText:"|"+cols[1], ComboCode: "|"+cols[0]});
	 	  	break;
	 	  	
		case IBLOADEXCEL:		// EXCEL UPLOAD
			if(sheetObj.RowCount() >= 1)
			{
				sheetObj.RemoveAll();
			}
			sheetObj.LoadExcel();
			break;
			
		case IBDOWNEXCEL:     	// EXCEL DOWNLOAD
			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(		sheetObj), SheetDesign:1,Merge:1 });
	    	break;	
	    	
		case IBRESET:
			var idx=0
			var sXml2=document.form2.sXml.value;
			var arrXml=sXml2.split("|$$|");
			//multi combo in grid
			if ( arrXml[idx] == null ) {return;}
	 	  	var cols=ComCgmXml2ComboString(arrXml[idx], "code1", "code1|desc1", "\t");
	 	  	sheetObj.SetColProperty(0,"chss_rgst_ste_cd", {ComboText:"|"+cols[1], ComboCode: "|"+cols[0]} );
	 	  	idx++; 
			break;    	
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		  with(formObj){
		  		 switch(sAction) {
		  		 	case IBSEARCH: 
		  		 		if(chss_rgst_exp_dt.value != '' && chss_rgst_exp_dt.value.length != 4)
		  		 		{
		  		 			
		  		 			ComShowCodeMessage('CGM10086');
		  		 			return false;
		  		 		}
		  		 		break;
		  		 		
		  		 	case IBSAVE: 
		  		 		// save logic only checked row
		  				var chkRows=sheetObj.FindCheckedRow("del_chk");
		  				var arrChkRows=chkRows.split("|");
		  				// check
		  				var cellText;
		  				for(k=0; k < arrChkRows.length; k++){
		  					cellText=sheetObj.GetCellValue(arrChkRows[k], "eq_no");
		  					if(cellText == ""){
		  						ComShowCodeMessage("CGM10009", " Chassis No.");
		  						return false;
		  					}
		  				}
		  				if(arrChkRows.length <= 0)
		  				{
		  					// msgs['CGM10008']='Please select a row.';
		  					ComShowCodeMessage("CGM10008");
		  					return false;
		  				}	  		 		
		       			break;
		  		 }      
		  	 }
		return true;
	}
	/**
	 * init object 
	 */
	function objectClear(){
		var formObj=document.form;
		var sheetObject=sheetObjects[0];
		formObj.reset();
	}
	/**
	* calendar
	*/
	function sheet1_OnPopupClick(sheetObj, row, col){
		switch (sheetObj.ColSaveName(col)) {
	       	case "mft_dt" :
			    if (sheetObj.ColSaveName(col) != "mft_dt") return;//chss_rgst_exp_dt
			    var cal=new ComCalendarGrid("myCal");
			    cal.select(sheetObj, row, col, 'yyyy-MM-dd');
			    break;
			    
	       	case "chss_rgst_exp_dt" :
			    if (sheetObj.ColSaveName(col) != "chss_rgst_exp_dt") return;
			    var cal=new ComCalendarGrid("myCal");
			    cal.select(sheetObj, row, col, 'yyyy-MM-dd');
			    break;
		}
	}
	function sheet_delete(sheetObj)
	{
		  for(i=sheetObj.RowCount(); i>0; i--){
			  if(sheetObj.GetCellValue(i, "ibflag") != ""   &&  sheetObj.GetCellValue(i, "del_chk")=="1") {
				sheetObj.RowDelete(i, false);
			}
		 }
	}
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		var prefix="";
		var chk=true;
		with (sheetObj) {
			var colName=ColSaveName(Col);
			switch (colName) {
			case "chss_rgst_prd_cd":
				if (GetCellValue(Row, "chss_rgst_prd_cd") == "F") {
				} else {
					SetCellValue(Row, "chss_rgst_exp_dt","",0);
				}
				break;
			case "chss_rgst_exp_dt":
				if (GetCellValue(Row, "chss_rgst_exp_dt") != "")
				{
					SetCellValue(Row, "chss_rgst_prd_cd","F",0);
				}else
				{
					SetCellValue(Row, "chss_rgst_prd_cd","P",0);
				}
				break;
			case "chss_als_no":
			case "n2nd_chss_als_no":
				// Alias No  duplication check(retrieve duplication check)
//				var GetCellValue=GetCellValue(Row, Col);
		 		var Col1	= GetCellValue(Row, "chss_als_no");
		 		var Col2	= GetCellValue(Row, "n2nd_chss_als_no");
		 		var tmpCnt	= 0;
		 		var preI	= 0;
		 		var preJ	= 0;
		 		var rowcnt	= RowCount();
		 		// chungpa 20100408 performance start
		 		var DUP=false;
		 		var check1	= FindText("chss_als_no", Value);
		 		var check2	= FindText("n2nd_chss_als_no", Value);
		 		if(Col == 14) //"chss_als_no"
		 		{
		 			if(check2==-1 && check1 == Row)
		 			{
	 					if(FindText("chss_als_no", Value, Row+1) == -1)
	 					{
	 						//Unique
	 					}else
	 					{
	 						DUP=true;
	 					}
		 			}else
		 			{
		 				DUP=true;
		 			}
		 		} else if(Col == 15) //"n2nd_chss_als_no"
		 		{
		 			if(check1==-1 && check2 == Row)
		 			{
	 					if(FindText("n2nd_chss_als_no", Value, Row+1) == -1)
	 					{
	 						//Unique
	 					}else
	 					{
	 						DUP=true;
	 					}
		 			}else
		 			{
		 				DUP=true;
		 			}
		 		}
		 		if(DUP == true)
		 		{
					ComShowCodeMessage("CGM10031",Value);
					// Setting Cell value to Null
		 			SetCellValue(Row, Col, "", 0);
		 			// focus to grid
		 			SelectCell(Row, Col, true);
		 		}
		 		// chungpa 20100408 performance end
		 		var chssAlsNo;
		 		// Alias No  duplication check(DB duplication check)
		 		if (colName == "chss_als_no") {
		 			chssAlsNo=GetCellValue(Row, "chss_als_no");
		 		} else {
		 			chssAlsNo=GetCellValue(Row, "n2nd_chss_als_no");
		 		}
				if(chssAlsNo.length > 0) {
					formObj.f_cmd.value=SEARCH01;
					document.form.chss_als_no.value=chssAlsNo;
					document.form.eq_no_tmp.value=GetCellValue(Row, "eq_no")
					var sXml = GetSearchData("EES_CGM_1006GS.do", FormQueryString(formObj));
					if (DomXml2String(sXml, "eq_no")) {
						if (DomXml2String(sXml, "eq_no").length > 0) {
							alert("CGM10031\n\n" + DomXml2String(sXml, "eq_no"));
							SetCellValue(Row, Col, "", 0);
							SelectCell(Row, colName, true);
							return;
						}
					}
				}
				break;
			case "eq_no":
			 	var eqNoTmp=Value;
				if (Row >1){
					for(i=1; i<RowCount(); i++){
						if(GetCellValue(i, "eq_no")== Value && Row != i  && GetCellValue(i, "eq_no")!='')
	 					{
				        	ComShowCodeMessage("CGM10017", "Chassis No");
							SetCellValue(Row, "eq_no","");
				        	return false;
	 					}
					}
				} 
				// XML data push to each column
				if(eqNoTmp.length > 0) {
					formObj.f_cmd.value=SEARCH;
					document.form.eq_no_tmp.value=eqNoTmp;
					var sXml=GetSearchData("EES_CGM_1006GS.do", FormQueryString(formObj));
					if(DomXml2String(sXml, "eq_no") == null || DomXml2String(sXml, "eq_no") == "") {
						// delete cell and focus move
						ComShowCodeMessage("CGM10012");
						// Setting Cell value to Null
						SetCellValue(Row, Col, "", 0);
						// focus to grid
						SelectCell(Row, Col, true);
						//row reset
						SetCellValue(Row, "eq_no","",0);
						SetCellValue(Row, "eq_tpsz_cd","",0);
						SetCellValue(Row, "mft_dt","",0);
						SetCellValue(Row, "chss_tare_wgt","",0);
						SetCellValue(Row, "chss_rgst_ste_cd","",0);
						SetCellValue(Row, "chss_rgst_yr","",0);
						SetCellValue(Row, "chss_rgst_exp_dt","",0);
						SetCellValue(Row, "chss_rgst_lic_no","",0);
						SetCellValue(Row, "chss_veh_id_no","",0);
						SetCellValue(Row, "chss_tit_no","",0);
						SetCellValue(Row, "chss_als_no","",0);
						SetCellValue(Row, "n2nd_chss_als_no","",0);
						SetCellValue(Row, "onh_yd_cd","",0);
						SetCellValue(Row, "onh_ofc_cd","",0);
						SetCellValue(Row, "cre_dt","",0);
						SetCellValue(Row, "cre_usr_id","",0);
						SetCellValue(Row, "chss_rgst_upd_dt","",0);
						SetCellValue(Row, "chss_rgst_upd_id","",0);
						SetCellValue(Row, "eq_knd_cd","",0);
						cellDisable(sheetObj, Row);
						return;
					} else {
						// setting cell value
						SetCellValue(Row, "eq_no",DomXml2String(sXml, "eq_no"),0);
						SetCellValue(Row, "eq_tpsz_cd",DomXml2String(sXml, "eq_tpsz_cd"),0);
						SetCellValue(Row, "mft_dt",DomXml2String(sXml, "mft_dt").toString(),0);
						SetCellValue(Row, "chss_tare_wgt",DomXml2String(sXml, "chss_tare_wgt"),0);
						SetCellValue(Row, "chss_rgst_ste_cd",DomXml2String(sXml, "chss_rgst_ste_cd"),0);
						SetCellValue(Row, "chss_rgst_yr",DomXml2String(sXml, "chss_rgst_yr"),0);
						SetCellValue(Row, "chss_rgst_exp_dt",DomXml2String(sXml, "chss_rgst_exp_dt").toString(),0);
						SetCellValue(Row, "chss_rgst_lic_no",DomXml2String(sXml, "chss_rgst_lic_no"),0);
						SetCellValue(Row, "chss_veh_id_no",DomXml2String(sXml, "chss_veh_id_no"),0);
						SetCellValue(Row, "chss_tit_no",DomXml2String(sXml, "chss_tit_no"),0);
						SetCellValue(Row, "chss_als_no",DomXml2String(sXml, "chss_als_no"),0);
						SetCellValue(Row, "n2nd_chss_als_no",DomXml2String(sXml, "n2nd_chss_als_no"),0);
						SetCellValue(Row, "onh_yd_cd",DomXml2String(sXml, "onh_yd_cd"),0);
						//chungpa 20090826 On_Hire_xxxx START
						SetCellValue(Row, "onh_ofc_cd",DomXml2String(sXml, "onh_ofc_cd"),0);
						SetCellValue(Row, "cre_dt",DomXml2String(sXml, "cre_dt").toString(),0);
						SetCellValue(Row, "cre_usr_id",DomXml2String(sXml, "cre_usr_id"),0);
						SetCellValue(Row, "chss_rgst_upd_dt",DomXml2String(sXml, "chss_rgst_upd_dt").toString(),0);
						SetCellValue(Row, "chss_rgst_upd_id",DomXml2String(sXml, "chss_rgst_upd_id"),0);
						//chungpa 20090826 On_Hire_xxxx END						
						// Hidden
						SetCellValue(Row, "eq_knd_cd",DomXml2String(sXml, "eq_knd_cd"),0);
						// calumn Enable function call //sheetObj, Row, Col
						var tmpRow=Row;
						cellEnable(sheetObj, Row);
					}
				}
				break;
			}
		}
	}
	 /**
	  * excel upload check
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
					document.form.eq_no_tmp.value=cellValue;
					var sXml=sheetObj.GetSearchData("EES_CGM_1006GS.do", FormQueryString(formObj));
					if(DomXml2String(sXml, "eq_no") == null || DomXml2String(sXml, "eq_no") == "") {
						//row reset
						sheetObj.SetCellValue(iChk, "eq_no","",0);
						sheetObj.SetCellValue(iChk, "eq_tpsz_cd","",0);
						sheetObj.SetCellValue(iChk, "mft_dt","",0);
						sheetObj.SetCellValue(iChk, "chss_tare_wgt","",0);
						sheetObj.SetCellValue(iChk, "chss_rgst_ste_cd","",0);
						sheetObj.SetCellValue(iChk, "chss_rgst_yr","",0);
						sheetObj.SetCellValue(iChk, "chss_rgst_exp_dt","",0);
						sheetObj.SetCellValue(iChk, "chss_rgst_lic_no","",0);
						sheetObj.SetCellValue(iChk, "chss_veh_id_no","",0);
						sheetObj.SetCellValue(iChk, "chss_tit_no","",0);
						sheetObj.SetCellValue(iChk, "chss_als_no","",0);
						sheetObj.SetCellValue(iChk, "n2nd_chss_als_no","",0);
						sheetObj.SetCellValue(iChk, "onh_yd_cd","",0);
						sheetObj.SetCellValue(iChk, "onh_ofc_cd","",0);
						sheetObj.SetCellValue(iChk, "cre_dt","",0);
						sheetObj.SetCellValue(iChk, "cre_usr_id","",0);
						sheetObj.SetCellValue(iChk, "chss_rgst_upd_dt","",0);
						sheetObj.SetCellValue(iChk, "chss_rgst_upd_id","",0);
						sheetObj.SetCellValue(iChk, "eq_knd_cd","",0);
						cellDisable(sheetObj, iChk);
					} else {
						// setting cell value
						sheetObj.SetCellValue(iChk, "eq_no",DomXml2String(sXml, "eq_no"),0);
						if(sheetObj.GetCellValue(iChk, "eq_tpsz_cd")=="")
							sheetObj.SetCellValue(iChk, "eq_tpsz_cd",DomXml2String(sXml, "eq_tpsz_cd"),0);
						if(sheetObj.GetCellValue(iChk, "mft_dt")=="")
							sheetObj.SetCellValue(iChk, "mft_dt",DomXml2String(sXml, "mft_dt").toString(),0);
						if(sheetObj.GetCellValue(iChk, "chss_tare_wgt")=="")
							sheetObj.SetCellValue(iChk, "chss_tare_wgt",DomXml2String(sXml, "chss_tare_wgt"),0);
						if(sheetObj.GetCellValue(iChk, "chss_rgst_ste_cd")=="")
							sheetObj.SetCellValue(iChk, "chss_rgst_ste_cd",DomXml2String(sXml, "chss_rgst_ste_cd"),0);
						if(sheetObj.GetCellValue(iChk, "chss_rgst_yr")=="")
							sheetObj.SetCellValue(iChk, "chss_rgst_yr",DomXml2String(sXml, "chss_rgst_yr"),0);
						if(sheetObj.GetCellValue(iChk, "chss_rgst_exp_dt")=="")
							sheetObj.SetCellValue(iChk, "chss_rgst_exp_dt",DomXml2String(sXml, "chss_rgst_exp_dt").toString(),0);
						if(sheetObj.GetCellValue(iChk, "chss_rgst_lic_no")=="")
							sheetObj.SetCellValue(iChk, "chss_rgst_lic_no",DomXml2String(sXml, "chss_rgst_lic_no"),0);
						if(sheetObj.GetCellValue(iChk, "chss_veh_id_no")=="")
							sheetObj.SetCellValue(iChk, "chss_veh_id_no",DomXml2String(sXml, "chss_veh_id_no"),0);
						if(sheetObj.GetCellValue(iChk, "chss_tit_no")=="")
							sheetObj.SetCellValue(iChk, "chss_tit_no",DomXml2String(sXml, "chss_tit_no"),0);
						if(sheetObj.GetCellValue(iChk, "chss_als_no")=="")
							sheetObj.SetCellValue(iChk, "chss_als_no",DomXml2String(sXml, "chss_als_no"),0);
						if(sheetObj.GetCellValue(iChk, "n2nd_chss_als_no")=="")
							sheetObj.SetCellValue(iChk, "n2nd_chss_als_no",DomXml2String(sXml, "n2nd_chss_als_no"),0);
						if(sheetObj.GetCellValue(iChk, "onh_yd_cd")=="")
							sheetObj.SetCellValue(iChk, "onh_yd_cd",DomXml2String(sXml, "onh_yd_cd"),0);
						//chungpa 20090826 On_Hire_xxxx START
						if(sheetObj.GetCellValue(iChk, "onh_ofc_cd")=="")
							sheetObj.SetCellValue(iChk, "onh_ofc_cd",DomXml2String(sXml, "onh_ofc_cd"),0);
						if(sheetObj.GetCellValue(iChk, "cre_dt")=="")
							sheetObj.SetCellValue(iChk, "cre_dt",DomXml2String(sXml, "cre_dt"),0);
						if(sheetObj.GetCellValue(iChk, "cre_usr_id")=="")
							sheetObj.SetCellValue(iChk, "cre_usr_id",DomXml2String(sXml, "cre_usr_id"),0);
						if(sheetObj.GetCellValue(iChk, "chss_rgst_upd_dt")=="")
							sheetObj.SetCellValue(iChk, "chss_rgst_upd_dt",DomXml2String(sXml, "chss_rgst_upd_dt").toString(),0);
						if(sheetObj.GetCellValue(iChk, "chss_rgst_upd_id")=="")
							sheetObj.SetCellValue(iChk, "chss_rgst_upd_id",DomXml2String(sXml, "chss_rgst_upd_id"),0);
						//chungpa 20090826 On_Hire_xxxx END						
						// Hidden
						sheetObj.SetCellValue(iChk, "eq_knd_cd",DomXml2String(sXml, "eq_knd_cd"),0);
						// column Enable function call //sheetObj, iChk, Col
						var tmpiChk=iChk;
						cellEnable(sheetObj, iChk);
						sheetObj.SetRowStatus(iChk, "U");
						sheetObj.SetCellValue(iChk, "del_chk", 1, 0);
					}	 		
			}
		}
	}
	/**
	 * column enable
	 */
	function cellEnable(sheetObj, Row){
	}
	/**
	 * column enable
	 */
	function cellDisable(sheetObj, Row, sXml){
	}
	
	/**
	 * Sheet Object On Save End
	 */
	function sheet1_OnSaveEnd(Code, Msg, StCode, StMsg) {
		if(Code == 0) ComShowCodeMessage("CGM00003");
		ComOpenWait(false);
	}
	
	/**
	 * key inserting limit
	 */
//	function obj_keypress(){
//		 obj=event.srcElement;
//		 if(obj.dataformat == null){
//			 return;
//		 }
//		 window.defaultStatus=obj.dataformat;
//		 switch(obj.dataformat) {
//	  	    case "engup":
//		        if(obj.name == "eq_no_fm"){
//		        	ComKeyOnlyAlphabet("uppernum");
//		        }
//		        break;
//		    case "isnum":
//		    	ComKeyOnlyNumber(obj);
//		    	break;
//	   	 	case "int":
//	   	 		ComKeyOnlyNumber(obj);
//	   	        break;	    	
//		 }
//	 }
//	 function search_keyup() {
//		   var formObj=document.form;
//		   if(formObj.eq_no_fm.value != '')
//		   {
//			   if(event.keyCode == 13)
//				   ComKeyEnter('search');
//		   }
//	 }  
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
//			  ComBtnDisable("btn_del");
//			  ComBtnDisable("btn_save");
//		  }
	 }