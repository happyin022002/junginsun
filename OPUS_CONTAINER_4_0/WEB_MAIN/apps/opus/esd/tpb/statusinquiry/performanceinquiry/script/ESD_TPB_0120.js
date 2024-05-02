/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0120.jsp
*@FileTitle  : Performance - Non-TPB
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/18
=========================================================*/
/****************************************************************************************
  Event code : 	INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    			MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
  OTHER CASE : 	COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESD_TPB_0120 : business script for ESD_TPB_0120
     */

    /* Global Variables */
  //var calPop = new calendarPopupGrid();
  var curTab=1;
  var beforetab=0;
  var sheetObjects=new Array();
  var sheetCnt=0;
  	/**
	 * Setting IBTab Object Initial.
	 * Tab ID is tab1,tab2,...
	 * InitTab() function is called before the loadPage() function call from setupPage() function.
	 */
  	function InitTab() {
  		try{
  			with(document.all.tab1){
				InsertItem( "Dry Index" , "");
				InsertItem( "Tanker Index" , "");
				InsertItem( "Time Charter" , "");
				InsertItem( "Bunker Price" , "");
				InsertItem( "Ship Price" , "");
				InsertItem( "FFA Index" , "");
  			}
  		}catch(e){
  			ComShowMessage(e.message);
  		}
  	}
  	/**
  	 * onChange event of tab1
  	 * Implementing defined function from IBSheetConfig.js
  	 */
  	function tab1_OnChange(nItem){
  		ChangeTab(document.all.tab1,nItem);
  	}
  	/**
  	 * Showing tab contents in case of clicking IBTab Object
  	 * ID of Grouped each tab DIV TAG defined "tabLayer"
  	 */
  	function ChangeTab(tabObj,nItem){
  		tabObj.SetBackColor("#FFFFFF");
  		var objs=document.all.item("tabLayer");
  		objs[beforetab].style.display="none";
  		objs[nItem].style.display="Inline";
  		//--------------- Notice --------------------------//
  		//objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
  		//Not a click button in case of zIndex under 2
  		objs[beforetab].style.zIndex=0;
  		objs[nItem].style.zIndex=9;
  		//------------------------------------------------------//
  		beforetab=nItem;
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
  		   //Setting startup environment. Change the name of the function
  			ComConfigSheet(sheetObjects[i]);
  			initSheet(sheetObjects[i],i+1);
  			//Setting final environment.
  			ComEndConfigSheet(sheetObjects[i]);
  		}
  		//document.form.s_ofc_cd_for_rhq.value = "SELCOL";
  		document.form.s_ofc_cd_for_rhq.value=OfficeCodeMgr.getOfficeCodeList('000004', 'TPB')[0];
  		document.form.s_office_level.value="H";
  		getTPBGenCombo('s_if_rhq_cd','searchHandleRHQList','F','','2', new Array("s_ofc_cd_for_rhq","s_office_level"));
  		document.form.s_if_rhq_cd.onchange=if_rhq_cd_OnChange;
  		document.form.s_if_ctrl_cd.onchange=if_ctrl_cd_OnChange;
  	}
  	/**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
  	function initSheet(sheetObj,sheetNo) {
  		sheetObj.UseUtf8=true;
  		switch(sheetNo) {
  			case 1:	  //IBSheet1 init
  	            with(sheetObj){
                var cnt=0;
          
                var HeadTitle1="Office|Type|Total|Total|TES|TES|TRS|TRS|MNR|MNR";
                var HeadTitle2="Office|Type|No.|Ratio(%)|No.|Ratio(%)|No.|Ratio(%)|No.|Ratio(%)";
                SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:2, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"},
                                { Text:HeadTitle2, Align:"Center"} ];
                InitHeaders(headers, info);
                var cols = [ {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"if_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:400 },
			     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cd_type",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:400 },
			     {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"total_cnt",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:400 },
			     {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"total_ratio",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:true },
			     {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"tes_cnt",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:400 },
			     {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"tes_ratio",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:1,   EditLen:400 },
			     {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"trs_cnt",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:400 },
			     {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"trs_ratio",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:400 },
			     {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"mnr_cnt",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:400 },
			     {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"mnr_ratio",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:400 } ];
                InitColumns(cols);
                SetEditable(0);
                //SetSheetHeight(430);
                ComResizeSheet(sheetObjects[0]);
            }
			break;
  		}
  	}
  	/* Event handler defined process to button click event */
  	document.onclick=processButtonClick;
  	/* Event handler is branch processing by name of button */
  	function processButtonClick(){
  		 /***** Assignment sheet in case of over 2 by tab ****/
  		 var sheetObject=sheetObjects[curTab-1];
  		 /******************************************************/
  		 var formObject=document.form;
  		 if(curTab == 2)
  			formObject=document.form2;
  		try {
  			var srcName=ComGetEvent("name");
  			switch(srcName) {
  				case "bttn_add":
  					   doActionIBSheet(sheetObject,formObject,IBINSERT);
  					break;
  				case "bttn_cancel":
  					   doActionIBSheet(sheetObject,formObject,IBSEARCH);
  					break;
  				case "bttn_save":
  					doActionIBSheet(sheetObject,formObject,IBSAVE);
  					break;
  				case "bttn_remove":
  					break;
  				case "bttn_preview":
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEsL);
  					break;
  				case "btn_downexcel":
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					break;
  				case "bttn_print":
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					break;
  				case "btn_retrieve":
  					doActionIBSheet(sheetObject,formObject,IBSEARCH);
  					break;
  				case "btn_new":
  					sheetObject.RemoveAll();
  					formObject.reset();
  					break;
  				case "btns_calendar2":
  					var cal=new ComCalendarFromTo();
  					cal.displayType="date";
  					cal.select(formObject.s_sdate, formObject.s_edate, 'yyyy-MM-dd');
  					break;
  			} // end switch
  		}catch(e) {			
  			if( e == "[object Error]") {
  				ComShowCodeMessage('COM12111');
  			} else {
  				ComShowMessage(e.message);
  			}
  		}
  	}
  	/* Processing Sheet */
  	function doActionIBSheet(sheetObj,formObj,sAction) {
  		sheetObj.ShowDebugMsg(false);
  		switch(sAction) {
  		   case IBSEARCH:	  //Retrieve
  				if(!validateForm(sheetObj,formObj,sAction)) {
  					return false;
  				}
  				formObj.f_cmd.value=SEARCH;
   				sheetObj.DoSearch("ESD_TPB_0120GS.do", tpbFrmQryStr(formObj) );
  				break;
  			case IBSAVE:		//Save
  				if(!validateForm(sheetObj,formObj,sAction)) {
  					return false;
  				}
  				formObj.f_cmd.value=MULTI;
  				sheetObj.DoSave("ESD_TPB_0120GS.do", tpbFrmQryStr(formObj));
  				break;
  			case IBINSERT:	  //Insert
  				var Row=sheetObj.DataInsert();
  				break;
  			case IBCLEAR:	   //Clear
  				sheetObj.RemoveAll();
  				break;
  			case IBDOWNEXCEL:  //Excel download
  				if(sheetObj.RowCount() < 1){//no data
  					ComShowCodeMessage("COM132501");
  				}else{
  					sheetObj.Down2Excel(TPBDown2ExcelOptions);
  				}
  				break;
  		}
  	}
  	/**
  	 * Checking validation of input value
  	 */
  	function validateForm(sheetObj,formObj,sAction){
  		with(formObj){
  			if(s_if_rhq_cd.options[s_if_rhq_cd.selectedIndex].text == "ALL"){
  				s_if_rhq_cd.options[s_if_rhq_cd.selectedIndex].value="all";
  			}
  			if(!ComChkValid(formObj)) return false;
  		}
  		return true;
  	}
  	/**
     * handling process after ending sheet1 retrieve
     */
  	function sheet1_OnSearchEnd(sheetObj,errMsg){
  		if(sheetObj.searchRows <= 0) return;
  		var row_cnt=sheetObj.RowCount();
  		for(var i=0;i<4;i++){
  			sheetObj.SetRowBackColor(row_cnt-i+1,"#ECE7F7");
  		}
  		var subSumArr=new Array();
 		for(var i=2; i < sheetObj.RowCount() ; i++){
  			if(i%4 == 1) {
				subSumArr[subSumArr.length]=new Array(tpb_change_zero(sheetObj.GetCellValue(i, "total_cnt"))
				,tpb_change_zero(sheetObj.GetCellValue(i, "tes_cnt"))
				,tpb_change_zero(sheetObj.GetCellValue(i, "trs_cnt"))
				,tpb_change_zero(sheetObj.GetCellValue(i, "mnr_cnt")));
  			}
  		}
 		for(var i=2,j=0; i < sheetObj.RowCount() ; i++){
 			if (subSumArr[j] != undefined) {
 				sheetObj.SetCellValue(i, "total_ratio",(sheetObj.GetCellValue(i, "total_cnt")/subSumArr[j][0])*100);
 				sheetObj.SetCellValue(i, "tes_ratio",(sheetObj.GetCellValue(i, "tes_cnt")/subSumArr[j][1])*100);
 				sheetObj.SetCellValue(i, "trs_ratio",(sheetObj.GetCellValue(i, "trs_cnt")/subSumArr[j][2])*100);
 				sheetObj.SetCellValue(i, "mnr_ratio",(sheetObj.GetCellValue(i, "mnr_cnt")/subSumArr[j][3])*100);
 			}
  			if(i%4 == 1) j++;
  		}
  	}
  	function tpb_change_zero(val){
  		var rtn;
  		if(val == 0 || val == "") rtn=1;
  		else rtn=val;
  		return rtn;
  	}
  	function s_office_level_OnChange(){
  		var f=document.form;
  		ComClearCombo(f.s_if_rhq_cd);
  		ComAddComboItem(f.s_if_rhq_cd, "", "<Select>");
  		f.s_if_ofc_cd.disabled=false;
  		ComClearCombo(f.s_if_ofc_cd);
  		ComAddComboItem(f.s_if_ofc_cd, "", "<Select>");
  		if ( f.s_office_level.value=="H" ) {
  			getTPBGenCombo('s_if_rhq_cd','searchHandleRHQList','F','','4');
  		} else if ( f.s_office_level.value=="R" ){
  			getTPBGenCombo('s_if_rhq_cd','searchHandleRHQList','F','','2');
  		} 
  	}
  	function if_rhq_cd_OnChange(){
  		var f=document.form;
  		if(f.s_office_level.value == "H"){ // HO
  			getTPBGenCombo('s_if_ofc_cd','searchHandleOfficeList','F','','2', new Array("s_if_rhq_cd","s_office_level"));
  		} else if(f.s_office_level.value == "R"){ //RHQ
  			getTPBGenCombo('s_if_ofc_cd','searchHandleOfficeList','F','','2', new Array("s_if_rhq_cd","s_office_level"));
  		}else if(f.s_office_level.value == "T" || f.s_office_level.value == ""){ //General Office
  			ComClearCombo(f.s_if_ofc_cd);
  			ComAddComboItem(f.s_if_ofc_cd, f.s_ofc_cd_for_rhq.value, f.s_ofc_cd_for_rhq.value);
  		}
  	}
   	function if_rhq_cd_OnChange(){
  		var f=document.form;
  		if(f.s_office_level.value == "H"){ // HO
  			ComClearCombo(f.s_if_ctrl_cd);
  			getTPBGenCombo('s_if_ctrl_cd','searchControlOfficeList','F','','2', new Array("s_if_rhq_cd","s_office_level"));
  			ComClearCombo(f.s_if_ofc_cd);
  			getTPBGenCombo('s_if_ofc_cd','searchTPBOfficeList','F','','2', new Array("",""));
  		} else if(f.s_office_level.value == "R"){ //RHQ
  			getTPBGenCombo('s_if_ctrl_cd','searchControlOfficeList','F','','2', new Array("s_if_rhq_cd","s_office_level"));
  		}else if(f.s_office_level.value == "T" || f.s_office_level.value == ""){ //General Office
  			ComClearCombo(f.s_if_ofc_cd);
  			ComAddComboItem(f.s_if_ofc_cd, f.s_ofc_cd_for_rhq.value, f.s_ofc_cd_for_rhq.value);
  		}
  	}
  	function if_ctrl_cd_OnChange(){
  		var f=document.form;
  		if(f.s_office_level.value == "H"){ // HO
  			ComClearCombo(f.s_if_ofc_cd);
  			getTPBGenCombo('s_if_ofc_cd','searchTPBOfficeList','F','','2', new Array("s_if_ctrl_cd","s_office_level"));
  		} else if(f.s_office_level.value == "R"){ //RHQ
  			ComClearCombo(f.s_if_ofc_cd);
  			getTPBGenCombo('s_if_ofc_cd','searchTPBOfficeList','F','','2', new Array("s_if_ctrl_cd","s_office_level"));
  		} else if(f.s_office_level.value == "C"){ //CTRL
  			getTPBGenCombo('s_if_ofc_cd','searchTPBOfficeList','F','','2', new Array("s_if_ctrl_cd","s_office_level"));
  		}else if(f.s_office_level.value == "T" || f.s_office_level.value == ""){ //General Office
  			ComClearCombo(f.s_if_ofc_cd);
  			ComAddComboItem(f.s_if_ofc_cd, f.s_ofc_cd_for_rhq.value, f.s_ofc_cd_for_rhq.value);
  		}
  	}
	/* Finishing work */
