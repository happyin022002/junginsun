/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0812.js
*@FileTitle  : Taxation Control
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/22
=========================================================*/
/****************************************************************************************
  Event Code: [Initializing]INIT=0; [Insert]ADD=1; [Retrieve]SEARCH=2; [List retrieve]SEARCHLIST=3;
			  [Modify]MODIFY=4; [Remove]REMOVE=5; [List remove]REMOVELIST=6 [Multi process]MULTI=7
			  [Constant]  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

    /* Global Variables */
    var curTab=1;
    var beforetab=0;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var rowForCorrection=0;
    /**
	 * Setting IBTab Object Initial.
	 * Tab ID is tab1,tab2,...
	 * InitTab() function is called before the loadPage() function call from setupPage() function.
	 */
  	function InitTab() {
  		try{
  			with(tab1){
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
  //no support[check again]CLT 		tabObj.TabBackColor(nItem)="146,174,230";
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
  		if( document.form.s_cnt_cd.value != 'IN' ){
  			$('#btn_save, #btn_add').hide();
  		}
  		document.form.s_calendar_date1.value=ComGetDateAdd(null, "D", 0, "-");
  		for(i=0;i<sheetObjects.length;i++){
  		   //Setting startup environment. Change the name of the function
  			ComConfigSheet(sheetObjects[i]);
  			initSheet(sheetObjects[i],i+1);
  			//Setting final environment.
  			ComEndConfigSheet(sheetObjects[i]);
  		}
  		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
  		getTPBGenCombo("s_ofc_cd","searchHierarchyOfficeByCountry","F","","1", new Array("s_ofc_grd","s_cnt_cd"));
        window.onunload=InitWinTopPendingTPBWin; 
  	}
  	 function InitWinTopPendingTPBWin(){
          try {
              Set_Cookie( "PendingTPBWin", "N", 1, "", "", "" )
          } catch(e){}
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
  				with (sheetObj) {
	                var HeadTitle="Status|Del.|Seq.|ida_tax_seq|Office|Effective Date|Service\nTax(%)|Swachh Bharat\n Tax(%)|Krishi Kalyan\n Tax(%)|Registration No.|Service Category|PAN No.|cre_usr_id|cre_dt|Create ID|Create Date";
	
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
						{Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"upd_chk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
						{Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"" },
						{Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"ida_tax_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eff_dt",        KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"expn_tax",      KeyField:1,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Int",       Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"edu_tax",       KeyField:1,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:"high_edu_tax",  KeyField:1,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:"tax_rgst_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:25 },
						{Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:"svc_cate_rmk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
						{Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:"pmnt_acct_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
						{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"editable",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	                 
	                InitColumns(cols);
	
	                SetEditable(1);
	                SetColHidden("cre_usr_id",1);
	                SetColHidden("cre_dt",1);
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
  				case "btn_add":
  					doActionIBSheet(sheetObject,formObject,IBINSERT);
  					break;
  				case "btn_save":
  					doActionIBSheet(sheetObject,formObject,IBSAVE);
  					break;
  				case "btn_retrieve":
  					doActionIBSheet(sheetObject,formObject,COMMAND01);
  					break;
  				case "btn_reset":
  					//formObject.Reset();
  					document.form.s_ofc_cd.value='';
  					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
  					break;
  				case "btns_calendar1": 
  					var cal=new ComCalendar();
  					cal.select(formObject.s_calendar_date1, 'yyyy-MM-dd');
  					break;
  				case "btn_close":
      				InitWinTopPendingTPBWin();
      				ComClosePopup(); 
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
  				sheetObj.DoSearch("ESD_TPB_0812GS.do", tpbFrmQryStr(formObj) );
  				break;
  			case COMMAND01:	  //Retrieving by Effective Date.
  				if(!validateForm(sheetObj,formObj,sAction)) {
  					return false;
  				}
  				formObj.f_cmd.value=SEARCH01;
  				sheetObj.DoSearch("ESD_TPB_0812GS.do", tpbFrmQryStr(formObj) );
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
  			case IBINSERT:	  //Insert
  				var Row=sheetObj.DataInsert(-1);
  				break;
  			case IBSAVE:	  //Insert
  				if( document.form.s_cnt_cd.value != 'IN') return;
  				formObj.f_cmd.value=MULTI;
  				sheetObj.DoSave("ESD_TPB_0812GS.do", tpbFrmQryStr(formObj));
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
     * handling process after ending sheet1 retrieve
     */
  	function sheet1_OnSearchEnd(sheetObj,errMsg){
  		for ( var i=1; i <= sheetObj.RowCount(); i++ ){
  			if(sheetObj.GetCellValue(i,"editable")>0){
  				sheetObj.SetRowEditable(i,0);
  			}
  		}
  	}
  	function sheet1_OnChange(sheetObj,Row,Col,Value){
		if( sheetObj.ColSaveName(Col) != "svc_cate_rmk" && sheetObj.ColSaveName(Col) != "upd_chk" ){
			if ( sheetObj.GetCellValue(Row,Col).value != null && sheetObj.GetCellValue(Row,Col) != 'undefind' ) {
				sheetObj.SetCellValue(Row,Col,ComTrim(sheetObj.GetCellValue(Row,Col).value.toUpperCase()));
			}
		}
		if( sheetObj.ColSaveName(Col) == "expn_tax" || sheetObj.ColSaveName(Col) == "edu_tax" || sheetObj.ColSaveName(Col) == "high_edu_tax" ){
			if(sheetObj.GetCellValue(Row,Col) > 100){
				var headText=sheetObj.GetCellText(0, Col)
				headText=ComReplaceStr(headText, "\n", " ");        
				ComShowCodeMessage('TPB90032',headText,"100");
				sheetObj.ReturnCellData(Row,Col);
			}
		}
		for ( var i=1; i <= sheetObj.RowCount(); i++ ){
			if( Row != i ){
				if(sheetObj.GetCellValue(Row,"eff_dt") == sheetObj.GetCellValue(i,"eff_dt") && sheetObj.GetCellValue(Row,"eff_dt") != ''){
					ComShowCodeMessage('TPB90099')
					sheetObj.SetCellValue(Row,"eff_dt",'',0);
				}
			}
		}
	}
  	/**
  	 * Defined by DataSheetObject.prototype.event_OnSaveEnd
  	 */
  	function sheet1_OnSaveEnd(sheetObj,errMsg){
  	}
	/* Finishing work */
