/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0133.js
*@FileTitle  : InterfacedCancel
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/24
=========================================================*/
/****************************************************************************************
  Event Code: [Initializing]INIT=0; [Insert]ADD=1; [Retrieve]SEARCH=2; [List retrieve]SEARCHLIST=3;
			  [Modify]MODIFY=4; [Remove]REMOVE=5; [List remove]REMOVELIST=6 [Multi process]MULTI=7
			  [Constant]  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESD_TPB_0133 : Defining logic script for ESD_TPB_0133 screen
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
  	 * Register as an IBSheet Object array
  	 * This is called from comSheetObject(id)
  	 * Process can add in case of future necessity to process other items
  	 * Array defined at the top of the source
  	 */
  	function setSheetObject(sheet_obj){
  		sheetObjects[sheetCnt++]=sheet_obj;
  	}
  	/**
  	 * Initializing sheet
  	 * To implement onLoad event of body tag
  	 * Add functionality to after loading screen.
  	 */
  	function loadPage() {
  		for(i=0;i<sheetObjects.length;i++){
  			//Setting startup environment. Change the name of the function
  			ComConfigSheet(sheetObjects[i]);
  			initSheet(sheetObjects[i],i+1);
  			//Setting final environment.
  			ComEndConfigSheet(sheetObjects[i]);
  		}
//  		document.form.s_if_rhq_cd.onchange=if_rhq_cd_OnChange;
//  		document.form.s_if_ctrl_cd.onchange=if_ctrl_cd_OnChange;
  		$('#s_if_rhq_cd').on('change', if_rhq_cd_OnChange);
  		$('#s_if_ctrl_cd').on('change', if_ctrl_cd_OnChange);
  		/**
  		 * Setting hierarchy<br>
  		 * Changing hierarchy<br> 
  		 */
  		document.form.s_office_level.value="H"; //Head Office - Hierarchy Authorization
  		if(document.form.s_office_level.value == "H"){
  			getTPBGenCombo('s_if_rhq_cd','searchHandleRHQList','F','','2', new Array("s_ofc_cd_for_rhq","s_office_level"));
  		} else if(document.form.s_office_level.value == "R"){
  			ComClearCombo(document.form.s_if_rhq_cd);
  			ComAddComboItem(document.form.s_if_rhq_cd, document.form.s_rhq_cd_for_rhq.value, document.form.s_rhq_cd_for_rhq.value);
  			setTimeout("if_rhq_cd_OnChange();",300);
  		} else if(document.form.s_office_level.value == "C"){
  			ComClearCombo(document.form.s_if_rhq_cd);
  			ComAddComboItem(document.form.s_if_rhq_cd, document.form.s_rhq_cd_for_rhq.value, document.form.s_rhq_cd_for_rhq.value);
  			if_ctrl_cd_OnChange();
  		}else if(document.form.s_office_level.value == "T" || document.form.s_office_level.value == ""){
  			getTPBGenCombo('s_if_rhq_cd','searchHandleRHQList','F','','5', new Array("s_ofc_cd_for_rhq","s_office_level"));
  			getTPBGenCombo('s_if_ctrl_cd','searchCtrlOffice','F','','5', new Array("s_ofc_cd_for_rhq","s_office_level"));
  			if_rhq_cd_OnChange(); //  Setting Control Office ComboBox, TPB Office ComboBox
  			if_ctrl_cd_OnChange(); // Setting TPB Office ComboBox
  		}
  	}
  	/**
  	 * Initializing sheet. Defining header
  	 * param : sheetObj ==> sheet object, sheetNo ==> sheet No.
  	 * Composition a initial module in case of multi sheet
  	 */
  	function initSheet(sheetObj,sheetNo) {
  		sheetObj.UseUtf8=true;
  		switch(sheetNo) {
  			case 1:	  //IBSheet1 init
  			    with(sheetObj){
	  		        var cnt=0;
	  		    
	  		        var HeadTitle1="DEL|STS|Canceled S/O Details|Canceled S/O Details|Canceled S/O Details|Canceled S/O Details|Canceled S/O Details|TPB Details|TPB Details|TPB Details|TPB Details|org_seq|cxl_seq|TPB No.|Removable";
	  		        var HeadTitle2="DEL|STS|Office|S/O Number|Amount(USD)|Initial I/F Date|Canceled Date|Status|Confirm(USD)|Invoice(USD)|Group|org_seq|cxl_seq|TPB No.|Removable";
	
	  		        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:2, DataRowMerge:1 } );
	
	  		        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	  		        var headers = [ { Text:HeadTitle1, Align:"Center"},
	  		                  { Text:HeadTitle2, Align:"Center"} ];
	  		        InitHeaders(headers, info);
	
	  		        var cols = [ {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk_del",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
  		             {Type:"Status",    Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
  		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"so_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"if_amt_usd",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"org_if_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"cxl_if_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"ots_sts",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"ots_amt_usd",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"inv_amt_usd",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"grp_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"org_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cxl_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"editable",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
  		       
	  		      InitColumns(cols);
	
	  		      SetEditable(1);
	  		      SetColHidden("ibflag",1);
	  		      SetColHidden("org_seq",1);
	  		      SetColHidden("cxl_seq",1);
	  		      SetColHidden("editable",1);
	  		      SetSheetHeight(445);
  		      }
			break;
  		}
  	}
  	/* Event handler defined process to button click event */
  	document.onclick=processButtonClick;
  	/* Event handler is branch processing by name of button */
  	function processButtonClick(){
  		 /***** Assignment sheet in case of over 2 by tab****/
  		 var sheetObject=sheetObjects[curTab-1];
  		 /******************************************************/
  		 var formObject=document.form;
  		 if(curTab == 2)
  			formObject=document.form2;
  		try {
  			var srcName=ComGetEvent("name");
  			switch(srcName) {
  				case "btn_retrieve":
  					doActionIBSheet(sheetObject,formObject,IBSEARCH);
  					break;
  				case "btn_downexcel": 
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					break;
  				case "btn_tonontpb":
  					document.form.s_isNoticeOnly.value=0;
  					accessAfterConfirmMsg(0,COMMAND01);
  					break;
  				case "btn_eliminate":
  					document.form.s_isNoticeOnly.value=1;
  					accessAfterConfirmMsg(1,COMMAND01);
  					break;	
  			} // end switch
  		}catch(e) {			
  			if( e == "[object Error]") {
  				ComShowMessage(getMsg('TPB90014'));
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
   				sheetObj.DoSearch("ESD_TPB_0133GS.do", tpbFrmQryStr(formObj) );
  				break;
  			case COMMAND01: //cancelation
  				if(!validateForm(sheetObj,formObj,sAction)) {
  					return false;
  				}
  				for( var i=2 ; i<sheetObj.RowCount()+2 ; i++ ){
  					if( sheetObj.GetCellValue(i,"chk_del") == "1" ){
  						if( document.form.s_isNoticeOnly.value == "0" ){ // Delete All
  							if( sheetObj.GetCellValue(i,"org_seq") == "" || sheetObj.GetCellValue(i,"cxl_seq") == "" ){
  								ComShowCodeMessage('TPB90083',i-1);
  								return;
  							}
  						}else if(document.form.s_isNoticeOnly.value == "1" ){ // Delete Cancel Flag Only
  							if( sheetObj.GetCellValue(i,"cxl_seq") == "" ){
  								ComShowCodeMessage('TPB90084');
  							}					
  						}
  					}
  				}
  				formObj.f_cmd.value=MULTI;
  				sheetObj.DoSave("ESD_TPB_0133GS.do", tpbFrmQryStr(formObj));
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
  			if(!ComChkValid(formObj)) return false;
  		}
  		return true;
  	}
  	/**
  	 * Processing function in case of error to result of retrieve
  	 * Defined by DataSheetObject.prototype.event_OnSearchEnd
  	 */
  	function sheet1_OnSearchEnd(sheetObj,errMsg){
  		for( var i=2 ; i<sheetObj.RowCount()+2 ; i++ ){
  			if( sheetObj.GetCellValue(i,"editable") == "Y"
  				&& sheetObj.GetCellValue(i,"grp_flg") == "N"
  					&& sheetObj.GetCellValue(i,"ofc_cd") == document.form.s_ofc_cd_for_rhq.value){
  				sheetObj.SetCellEditable(i,"chk_del",1);
  			}
  		}
  	}
  	/**
  	 * Setting heierarchy 구조를 위한 기본 설정.<br>
  	 * if_rhq_cd_OnChange
  	 */
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
  	/**
  	 * Setting hierarchy<br> 
  	 * if_ctrl_cd_OnChange
  	 */
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
  	/**
  	 * accessAfterConfrimMsg <br> 
  	 * 
  	 */
  	function accessAfterConfirmMsg(flg,cmd){
  		var k=0;
  		for( var i=2 ; i<sheetObjects[0].RowCount()+2 ; i++ ){
  			if( sheetObjects[0].GetCellValue(i,"chk_del") == "1" ) k++;
  		}
  		if( k == 0 ) return;
  		var result='';
  		if( flg == 0 ){
  			result=ComShowConfirm(msgs['TPB90066']);
  		}else if( flg == 1){
  			result=ComShowConfirm(msgs['TPB90067']);
  		}
  		if(result) {
  			doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
  		}
  		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
  	}
  	/* Finishing work */
