/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0123.jp
*@FileTitle  :  Invoice Sheet Set
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19
=========================================================*/
/****************************************************************************************
  Event Code: [Initializing]INIT=0; [Insert]ADD=1; [Retrieve]SEARCH=2; [List retrieve]SEARCHLIST=3;
			  [Modify]MODIFY=4; [Remove]REMOVE=5; [List remove]REMOVELIST=6 [Multi process]MULTI=7
			  [Constant]  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESD_TPB_105 : Defining logic script for ESD_TPB_105 screen
     */
    function ESD_TPB_105() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
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
  		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
  		        var HeadTitle="";

  		        SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:3, DataRowMerge:1 } );

  		        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
  		        var headers = [ { Text:HeadTitle, Align:"Center"} ];
  		        InitHeaders(headers, info);

  		        var cols = [ {Type:"Status",    Hidden:0, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"ibflag",             KeyField:0,   CalcLogic:"",   Format:"" },
  		             {Type:"Text",      Hidden:0,  Width:65,   Align:"Right",   ColMerge:1,   SaveName:"inv_iss_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"" },
  		             {Type:"Text",      Hidden:0,  Width:65,   Align:"Right",   ColMerge:1,   SaveName:"co_nm",              KeyField:0,   CalcLogic:"",   Format:"" },
  		             {Type:"Text",      Hidden:0,  Width:65,   Align:"Right",   ColMerge:1,   SaveName:"ofc_addr",           KeyField:0,   CalcLogic:"",   Format:"" },
  		             {Type:"Text",      Hidden:0,  Width:65,   Align:"Right",   ColMerge:1,   SaveName:"ofc_phn_no",         KeyField:0,   CalcLogic:"",   Format:"" },
  		             {Type:"Text",      Hidden:0,  Width:65,   Align:"Right",   ColMerge:1,   SaveName:"ofc_fax_no",         KeyField:0,   CalcLogic:"",   Format:"" },
  		             {Type:"Text",      Hidden:0,  Width:65,   Align:"Right",   ColMerge:1,   SaveName:"bil_to_loc_div_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
  		             {Type:"Text",      Hidden:0,  Width:65,   Align:"Right",   ColMerge:1,   SaveName:"vat_xch_rt",         KeyField:0,   CalcLogic:"",   Format:"" },
  		             {Type:"Text",      Hidden:0,  Width:65,   Align:"Right",   ColMerge:1,   SaveName:"inv_rmk1",           KeyField:0,   CalcLogic:"",   Format:"" },
  		             {Type:"Text",      Hidden:0,  Width:65,   Align:"Right",   ColMerge:1,   SaveName:"inv_rmk2",           KeyField:0,   CalcLogic:"",   Format:"" } ];
  		       
  		        InitColumns(cols);

  		        SetEditable(1);
  		        SetSheetHeight(160);
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
  				case "btn_save":
  					doActionIBSheet(sheetObject,formObject,IBSAVE);
  					break;
  				case "btn_retrieve":
  					doActionIBSheet(sheetObject,formObject,IBSEARCH);
  					break;
  				case "btn_new":
  					var ofc_cd=formObject.s_inv_iss_ofc_cd.value;
  					formObject.reset();
  					formObject.s_inv_iss_ofc_cd.value=ofc_cd;
  					break;
  				case "btn_close":
					ComClosePopup(); 
  					break;
  			} // end switch
  		}catch(e) {			
  			if( e == "[object Error]") {
  				ComShowMessage(ComGetMsg('COM12111'));
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
  				formObj.f_cmd.value=SEARCH;
  				sheetObj.DoSearch("ESD_TPB_0123GS.do", tpbFrmQryStr(formObj) );
  				break;
  			case IBSAVE:		//Save
  				gridSave(sheetObj);
  				if(!validateForm(formObj)) {
  					return false;
  				}
  				formObj.f_cmd.value=MULTI;
  				sheetObj.DoAllSave("ESD_TPB_0123GS.do", tpbFrmQryStr(formObj));
  				sheetObj.RemoveAll();
  				break;
  		}
  	}
  	function gridSave(sheetObj){
  		if(sheetObj.RowCount()<= 0){
	  		sheetObj.DataInsert(0);
  		}
  		sheetObj.SetCellValue(1, 'inv_iss_ofc_cd',document.form.s_inv_iss_ofc_cd.value,0);
  		sheetObj.SetCellValue(1, 'vat_xch_rt',document.form.s_vat_xch_rt.value,0);
  		sheetObj.SetCellValue(1, 'co_nm',document.form.s_co_nm.value,0);
  		sheetObj.SetCellValue(1, 'bil_to_loc_div_cd',document.form.s_bil_to_loc_div_cd.value,0);
  		sheetObj.SetCellValue(1, 'ofc_addr',document.form.s_ofc_addr.value,0);
  		sheetObj.SetCellValue(1, 'ofc_phn_no',document.form.s_ofc_phn_no.value,0);
  		sheetObj.SetCellValue(1, 'ofc_fax_no',document.form.s_ofc_fax_no.value,0);
  		sheetObj.SetCellValue(1, 'inv_rmk1',document.form.s_inv_rmk1.value,0);
  		sheetObj.SetCellValue(1, 'inv_rmk2',document.form.s_inv_rmk2.value,0);
  	}
  	/**
  	 * Checking validation of input value
  	 */
  	function validateForm(formObj){
  		with(formObj){
  			//VAT Rate 숫자 타입 체크
			if(!ComIsNumber(formObj.s_vat_xch_rt,".") && ComTrim(formObj.s_vat_xch_rt.value).length != 0){
				ComShowMessage(msgs['COM12178']);
				formObj.s_vat_xch_rt.focus();
				return false;
			}
  			if(!ComChkValid(formObj)) return false;
  		}
  		return true;
  	}
  	/**
  	 * Processing function in case of error to result of retrieve
  	 * Defined by DataSheetObject.prototype.event_OnSearchEnd
  	 */
  	function sheet1_OnSearchEnd(sheetObj,errMsg){
  		var ofc_cd=document.form.s_inv_iss_ofc_cd.value;
  		document.form.s_inv_iss_ofc_cd.value=sheetObj.GetCellValue(1, 'inv_iss_ofc_cd');
		document.form.s_vat_xch_rt.value=sheetObj.GetCellValue(1, 'vat_xch_rt');
		document.form.s_co_nm.value=sheetObj.GetCellValue(1, 'co_nm');
		ComSetObjValue(document.form.s_bil_to_loc_div_cd, sheetObj.GetCellValue(1, 'bil_to_loc_div_cd'));
		document.form.s_ofc_addr.value=sheetObj.GetCellValue(1, 'ofc_addr');
		document.form.s_ofc_phn_no.value=sheetObj.GetCellValue(1, 'ofc_phn_no');
		document.form.s_ofc_fax_no.value=sheetObj.GetCellValue(1, 'ofc_fax_no');
		document.form.s_inv_rmk1.value=sheetObj.GetCellValue(1, 'inv_rmk1');
		document.form.s_inv_rmk2.value=sheetObj.GetCellValue(1, 'inv_rmk2');
	  	if(sheetObj.RowCount()> 0){
	  		sheetObj.SetRowStatus(1,"U");
	  	} else{
	  		sheetObj.DataInsert(0);
	  		document.form.reset();
	  		document.form.s_inv_iss_ofc_cd.value=ofc_cd;
	  	}
  		if(errMsg != null && errMsg != 0 && errMsg != ""){
  			ComShowMessage(errMsg);
  		}
  	}
  	/**
  	 * Defined by DataSheetObject.prototype.event_OnSaveEnd
  	 */
  	function sheet1_OnSaveEnd(sheetObj,errMsg){
  		if(errMsg==null || errMsg == ''){
  			ComShowMessage(ComGetMsg('COM12149','Data','',''));
  		}
  		doActionIBSheet(sheetObj,document.form,IBSEARCH);	
  		var rtnValue=new Array();
  		rtnValue[0]=document.form.s_bil_to_loc_div_cd.options[document.form.s_bil_to_loc_div_cd.selectedIndex].value;
  		rtnValue[1]=document.form.s_vat_xch_rt.value;
  		window.returnValue=rtnValue;
  	}
	/* Finishing work */
