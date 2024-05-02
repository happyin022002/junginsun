/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0142.js
*@FileTitle  : VVD Check List
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------Code for JSDoc creation below ------------------*/
	/**
	 * @fileoverview 
	 */
	/**
	 * @extends 
	 * @class ESM_COA_0142 : ESM_COA_0142 Business script for the UI
	 */
	// Grobla Variable
	var sheetObjects=new Array();
	var sheetCnt=0;	
	var sheet_height=20; // sheet height
	/* Event handler processing by button click event */
	document.onclick=processButtonClick;
	/* Event handler processing by button name */
	function processButtonClick(){
		var sheetObject=sheetObjects[0];
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
				case "btn_Save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;
				case "btn_Close":
					ComClosePopup(); 
					break;			
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(ComGetMsg("COM12111"));
			} else {
				ComShowMessage(e.message);
			}
		}
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
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}
	/**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
	*/
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetNo) {
			case 1:      //sheet2 init
			    with(sheetObj){
		      var HeadTitle0="STS|Revenue\nYYYY-MM|Sales\nYYYY-MM|Week|Trade|Lane|IOC|Vessel|Voy.|BND|Revenue Port|Revenue Port|Weekly\n Auto/Mnl" ;
		      var HeadTitle1="STS|Revenue\nYYYY-MM|Sales\nYYYY-MM|Week|Trade|Lane|IOC|Vessel|Voy.|BND|Port|ETD|Weekly\n Auto/Mnl" ;

		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );

		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle0, Align:"Center"},
		                  { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cost_yrmon",            KeyField:1,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"sls_yrmon",             KeyField:0,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cost_wk",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ioc_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"lst_lodg_port_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"lst_lodg_port_etd_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"wky_mnl_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		       
		      InitColumns(cols);

		      SetEditable(1);//Editkind[optional,Defaultfalse]
		      SetWaitImageVisible(0);
		            SetHeaderRowHeight(10);
		      SetColProperty("lst_lodg_port_etd_dt", {Format:"####-##-####:##:##"} );
//		      SetSheetHeight(ComGetSheetHeight(sheetObj, sheet_height));
			  resizeSheet();
		      }


				break;
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
	* Alert message after saving
	*/
	function sheet1_OnSaveEnd(sheetObj, ErrMsg){
		if(ErrMsg == ""){
		// [COA10006] : The processes was completed
			ComShowCodeMessage("COA10006");
		}
	}
	/**
	/**
	* Handling process about the sheet object
	*/
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBCLEAR:
				ComOpenWait(true);
				var sXml=document.form.sXml.value; 
				var arrXml=sXml.split("|$$|");
				if (arrXml.length > 0) {
					ComCoaSetIBCombo(sheetObj, arrXml[0], "wky_mnl_flg", true, 0);
				}
				document.form.sXml.value="";
				ComOpenWait(false);
				break;
			case IBSEARCH:      //Inquiry
				ComOpenWait(true);
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				if(formObj.f_fm_mon.value != "" && formObj.f_fm_mon.value.length != 2) formObj.f_fm_mon.value=ComLpad(formObj.f_fm_mon.value, 2, '0');
				if(formObj.f_to_mon.value != "" && formObj.f_to_mon.value.length != 2) formObj.f_to_mon.value=ComLpad(formObj.f_to_mon.value, 2, '0');
				if(formObj.f_fm_wk.value != "" && formObj.f_fm_wk.value.length != 2) formObj.f_fm_wk.value=ComLpad(formObj.f_fm_wk.value, 2, '0');
				if(formObj.f_to_wk.value != "" && formObj.f_to_wk.value.length != 2) formObj.f_to_wk.value=ComLpad(formObj.f_to_wk.value, 2, '0');
				formObj.f_cmd.value=SEARCH;
 				sheetObj.DoSearch("ESM_COA_0142GS.do", coaFormQueryString(formObj) );
				ComOpenWait(false);
				break;
			case IBSAVE:        //Save
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				ComOpenWait(true);
				formObj.f_cmd.value=MULTI;
				sheetObj.DoSave("ESM_COA_0142GS.do", coaFormQueryString(formObj,'f_cmd',true), -1, false);
				ComOpenWait(false);
				break;				
		}
	}
	/**
	* Handling process for form object input validation
	*/
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			// Year Check..
			if (f_year.value == "") {
			    // [COM12114] : Check for year value
				ComShowCodeMessage("COM12114", "Year");
			    f_year.focus();
				return false;
			}
 		    if(!ComIsDate(f_year, "yyyy")){
 		    	// [COA10009] = 'Please enter Year correctly.\n\n Format : YYYY
 		    	ComShowCodeMessage('COA10009','Year','YYYY');
			    f_year.focus();
 		    	return false;
 		    }
 		    // 
			//f_chkprd
			if (f_fm_mon.value != "" && f_to_mon.value == ""){
				// [COM12114] : Check month
				ComShowCodeMessage("COM12114", "Month")
				f_to_mon.focus();
				return false;
			}
			if (f_fm_mon.value == "" && f_to_mon.value != "") {
				// [COM12114] : Check month
				ComShowCodeMessage("COM12114", "Month");
				f_fm_mon.focus();
				return false;
			}
			if (ComParseInt(f_fm_mon.value) > ComParseInt(f_to_mon.value)) {
				// [COA10011] = Check for month value : From <= to
				ComShowCodeMessage("COA10011","Month","From","To");
				f_to_mon.focus();
				return false;
			}
			if (f_fm_wk.value != "" && f_to_wk.value == ""){
				// [COM12114] : Check Week
				ComShowCodeMessage("COM12114", "Week");
				f_to_wk.focus();
				return false;
			}
			if (f_fm_wk.value == "" && f_to_wk.value != ""){
				// [COM12114] : Check Week
				ComShowCodeMessage("COM12114", "Week");
				f_fm_wk.focus();
				return false;
			}
			if (f_fm_wk.value > f_to_wk.value) {
				// [COA10011] = Check for month value : From <= to
				ComShowCodeMessage("COA10011","Week","From","To");
				f_to_wk.focus();
				return false;
			}
			if(f_fm_mon.value == "" && f_fm_wk.value == ""){
				//        			    ComShowCodeMessage("COM12138", "month", "week");
				return false;
			}
			if(!ComIsDate(f_year, "yyyy")){
				// [COA1009] = Check the year values
				ComShowCodeMessage('COA10009','Year','YYYY');
				return false;
			}
			if(!ComIsMonth(f_fm_mon)){
				// [COA1009] = Check for month value
				ComShowCodeMessage('COA10009','Month','MM');
				return false;
			}
			if(!ComIsMonth(f_to_mon)) {
				// [COA1009] = Check for month value
				ComShowCodeMessage('COA10009','Month','MM');
				return false;
			}
			if(!ComIsWeek(f_fm_wk)){
				// [COA1009] = Check for week value
				ComShowCodeMessage('COA10009','Week','WW');
				return false;
			}
			if(!ComIsWeek(f_to_wk)) {
				// [COA1009] = Check for week value
				ComShowCodeMessage('COA10009','Week','WW');
				return false;
			}
		}
		return true;
	}

    function resizeSheet(){
   	 ComResizeSheet(sheetObjects[0]);
    }