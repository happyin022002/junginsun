/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0121.jsp
*@FileTitle  : Performance - EAC Issue
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19
=========================================================*/
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
//  		document.form.s_office_level.onchange = s_office_level_OnChange;
  		document.form.s_if_rhq_cd.onchange=if_rhq_cd_OnChange;
  		if(document.form.s_office_level.value == "H"){
  			getTPBGenCombo('s_if_rhq_cd','searchHandleRHQList','F','','1', new Array("s_ofc_cd_for_rhq","s_office_level"));
  			if_rhq_cd_OnChange();
  		}else if(document.form.s_office_level.value == "R"){
  			ComClearCombo(document.form.s_if_rhq_cd);
  			ComAddComboItem(document.form.s_if_rhq_cd, document.form.s_rhq_cd_for_rhq.value, document.form.s_rhq_cd_for_rhq.value);
  			setTimeout("if_rhq_cd_OnChange();",300);
  		}else if(document.form.s_office_level.value == "G" ||  document.form.s_office_level.value == "T" ||  document.form.s_office_level.value == "C" || document.form.s_office_level.value == ""){
  			getTPBGenCombo('s_if_rhq_cd','searchHandleRHQList','F','','5', new Array("s_ofc_cd_for_rhq","s_office_level"));
  			if_rhq_cd_OnChange();
  		}
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
                var HeadTitle1="RHQ|Exp. Type|Misbilling|Misbilling|Missing 3rd Party Billing|Missing 3rd Party Billing|Internal Error|Internal Error|Total|Total";
                var HeadTitle2="RHQ|Exp. Type|Count|Amount|Count|Amount|Count|Amount|Count|Amount";
                
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:2, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"},
                                { Text:HeadTitle2, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"if_rhq_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"expn_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				     {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cnt_a",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				     {Type:"Float",     Hidden:0,  Width:115,  Align:"Right",   ColMerge:1,   SaveName:"amt_a",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				     {Type:"Float",     Hidden:0,  Width:115,  Align:"Right",   ColMerge:1,   SaveName:"cnt_b",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				     {Type:"Float",     Hidden:0,  Width:115,  Align:"Right",   ColMerge:1,   SaveName:"amt_b",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				     {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cnt_c",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"amt_c",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				     {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cnt_tot",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"amt_tot",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];
           
                InitColumns(cols);

                SetEditable(0);
                SetSheetHeight(460);
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
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
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
   				sheetObj.DoSearch("ESD_TPB_0121GS.do", tpbFrmQryStr(formObj) );
  				break;
  			case IBSAVE:		//Save
  				if(!validateForm(sheetObj,formObj,sAction)) {
  					return false;
  				}
  				formObj.f_cmd.value=MULTI;
  				sheetObj.DoSave("ESD_TPB_0121GS.do", tpbFrmQryStr(formObj));
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
  	}
  	function s_office_level_OnChange(){
  		var f=document.form;
  		ComClearCombo(f.s_if_rhq_cd);
  		ComAddComboItem(f.s_if_rhq_cd, "", "<Select>");
  		if ( f.s_office_level.value=="H" ) {
  			getTPBGenCombo('s_if_rhq_cd','searchHandleRHQList','F','','4');
  		} else if ( f.s_office_level.value=="R" ){
  			getTPBGenCombo('s_if_rhq_cd','searchHandleRHQList','F','','2');
  		} 
  	}
  	function if_rhq_cd_OnChange(){
  	}
  	function _if_rhq_cd_OnChange(){
  		var f=document.form;
  		if(f.s_if_rhq_cd.options[f.s_if_rhq_cd.selectedIndex].text == "ALL"){
  			f.s_if_rhq_cd.options[f.s_if_rhq_cd.selectedIndex].value="all";
  		}
  		if(f.s_if_ofc_cd.options[f.s_if_ofc_cd.selectedIndex].text == "ALL"){
  			f.s_if_ofc_cd.options[f.s_if_ofc_cd.selectedIndex].value="all";
  		}
  		if ( f.s_office_level.value=="H"){
  			if(f.s_if_rhq_cd.value=="all") {
  				f.s_if_ofc_cd.disabled=true;
  			}else{
  				getTPBGenCombo('s_if_ofc_cd','searchHandleOfficeList','F','','2', new Array("s_if_rhq_cd","s_office_level"));
  			}
  		}
  		if ( f.s_office_level.value=="R"){
  			getTPBGenCombo('s_if_ofc_cd','searchHandleOfficeList','F','','1', new Array("s_if_rhq_cd","s_office_level"));
  		}
  	}
	/* Finishing work */
