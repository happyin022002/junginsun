/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0129.jsp
*@FileTitle  : JO TPB Invoice Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/20
=========================================================*/
/****************************************************************************************
  Event code : 	INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    			MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
  OTHER CASE : 	COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESD_TPB_0129 : business script for ESD_TPB_0129
     */
  
    /* Global Variables */
  //var calPop = new calendarPopupGrid();
  var curTab=1;
  var beforetab=0;
  var sheetObjects=new Array();
  var sheetCnt=0;
  var rowForCorrection=0;
  //var invNoForCorrection = 0;
  //var invRmdForCorrection = 0;
  //var invHisSeqForCorrection = 0;
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
  		document.form.s_vndr_cust_div_cd.onchange=s_vndr_cust_div_cd_OnChange_ToSearch; // for searching 
  		document.form.s_trd_party_val.onfocus=s_trd_party_val_OnFocus;
  		document.form.s_trd_party_val.onblur=s_trd_party_val_OnBlur_ToSearch;
  		tpb_3rdPartyStaffClear(document.form.s_vndr_cust_div_cd);
  		document.form.s_ofc_cd_for_rhq.value=OfficeCodeMgr.getOfficeCodeList('000004', 'TPB')[0];
  		document.form.s_office_level.value="H";
  		getTPBGenCombo('s_if_rhq_cd','searchHandleRHQList','F','','2', new Array("s_ofc_cd_for_rhq","s_office_level"));
  		if(document.form.s_office_level.value == "H"){
  			getTPBGenCombo('s_if_rhq_cd','searchHandleRHQList','F','','2', new Array("s_ofc_cd_for_rhq","s_office_level"));
  		}else if(document.form.s_office_level.value == "R"){
  			ComClearCombo(s_if_rhq_cd);
  			ComAddComboItem(s_if_rhq_cd,s_rhq_cd_for_rhq.value,s_rhq_cd_for_rhq.value);
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
  					var HeadTitle="|SEQ|Office|TPB No.|Invoice No.|Version()|AR B/L No.|Expense type|Currency|Net Amount|VAT Amount|Invoice Amount|AR I/F Amount|Issued Date|Issued By|C/L|3rd Party|AR I/F Date|length_n3pty_bil_tp_cd|3rd Party Division Code|3rd Party Code|n3pty_inv_his_seq|length_n3pty_bil_tp_cd"; // Recovery Activity|

  					SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:5, DataRowMerge:1 } );

  					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
  					var headers = [ { Text:HeadTitle, Align:"Center"} ];
  					InitHeaders(headers, info);

  					var cols = [ {Type:"Status",    Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"sts",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
  		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_inv_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"n3pty_inv_rvis_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"if_bl_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"n3pty_expn_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"ots_amt",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"vat_amt",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"inv_amt",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"clt_amt",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"inv_iss_locl_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"upd_usr_id",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"clt_agn_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"trd_party_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:"ar_if_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"length_n3pty_bil_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"vndr_cust_div_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"trd_party_code",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3pty_inv_his_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
  		       
  					InitColumns(cols);

  					SetEditable(1);
  					SetDataLinkMouse("n3pty_no",1);
  					SetDataLinkMouse("n3pty_inv_rvis_cd",1);
  					SetColHidden("if_bl_no",1);//2009-03-09
  					//SetSheetHeight(410);
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
  			 if(ComGetBtnDisable(srcName)) return false;
  			switch(srcName) {
  				case "btn_downexcel":
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					break;
  				case "btn_retrieve":
  					doActionIBSheet(sheetObject,formObject,IBSEARCH);
  					break;
  				case "btn_3rdParty":
  						get3rdPartyToSearch( formObject.s_vndr_cust_div_cd.value );  					
  					break;
  				case "btn_new":
  					sheetObject.RemoveAll();
  					formObject.reset();
  					break;
  				case "btns_calendar1":
  					 
  						 var cal=new calendarPopup();
  						 cal.select(formObject.s_sdate, 's_sdate', 'yyyy-MM-dd');
  					
  					break;
  				case "btns_calendar2":
  					
	  					var cal=new ComCalendarFromTo();
	  					cal.displayType="date";
	  					cal.select(formObject.s_sdate, formObject.s_edate,'yyyy-MM-dd');
  					
  					break;
  			} // end switch
  		}catch(e) {			
  			if( e == "[object Error]") {
  				ComShowMessage(getMsg('COM12111'));
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
  				if( document.form.s_cond[0].checked ){ 
  					if(!validateForm(sheetObj,formObj,sAction)) {
  						return false;
  					}
  				}
  				formObj.f_cmd.value=SEARCH;
   				sheetObj.DoSearch("ESD_TPB_0129GS.do", tpbFrmQryStr(formObj) );
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
  			if(s_cond[0].checked){
  				if(s_sdate.value == "" || s_edate.value == ""){
  					ComShowMessage(getMsg("COM12179","","",""));
  					return false;
  				}
  			}else if(s_cond[1].checked){
  				if(trim(s_n3pty_inv_no_for_search.value) == ""){
  					ComShowMessage(getMsg("COM12114","Invoice No.","",""));
  					s_n3pty_inv_no_for_search.focus();
  					s_n3pty_inv_no_for_search.select();
  					return false;
  				}
  			}else if(s_cond[2].checked){
  				if(trim(s_eq_no.value) == ""){
  					ComShowMessage(getMsg("COM12114","EQ No.","",""));
  					s_eq_no.focus();
  					s_eq_no.select();
  					return false;
  				}
  			}
  			if(!ComChkValid(formObj)) return false;
  		}
  		return true;
  	}
  	/**
     * handling process after ending sheet1 retrieve
     */
  	function sheet1_OnSearchEnd(sheetObj,errMsg){
  		for ( var i=0; i <= sheetObj.RowCount(); i++ ){
   			sheetObj.SetCellFontUnderline(i+1, "n3pty_no",1);
   			sheetObj.SetCellFontUnderline(i+1, "n3pty_inv_rvis_cd",1);
  		}
  	}
  	function sheet1_OnClick(sheetObj,Row,Col,Value){
  		/// Calling pop-up in case of Collection Activity button clicking
  		if ( sheetObj.ColSaveName(Col) == "n3pty_no" ) {
  			var tpb_no=sheetObj.GetCellValue(Row, "n3pty_no");
  			if ( tpb_no != null && tpb_no != undefined && tpb_no != "" ) {
  				var r_n3pty_no=sheetObj.GetCellValue(Row, "n3pty_no");
  				var r_n3pty_inv_no=sheetObj.GetCellValue(Row, "n3pty_inv_no");
      			openRecoveryActPopup(r_n3pty_no,r_n3pty_inv_no,'','Y');
  			}
  		/// to Detail 
  		} else if(sheetObj.ColSaveName(Col) == 'n3pty_inv_rvis_cd'){
			document.form.s_detail_n3pty_no.value=sheetObj.GetCellValue(Row, "n3pty_no");
			document.form.s_n3pty_inv_no.value=sheetObj.GetCellValue(Row, "n3pty_inv_no");
			document.form.s_n3pty_inv_his_seq.value=sheetObj.GetCellValue(Row, "n3pty_inv_his_seq");
			document.form.s_n3pty_inv_rmd_cd.value=sheetObj.GetCellValue(Row, "n3pty_inv_rvis_cd");
			document.form.s_trd_party_code.value=sheetObj.GetCellValue(Row, "trd_party_code");
			document.form.s_h_vndr_cust_div_cd.value=sheetObj.GetCellValue(Row, "vndr_cust_div_cd");
  		    document.form.s_correction_yn.value="N"; 
  			document.form.f_cmd.value=SEARCH01;
  			document.form.method="post";
  			document.form.action="ESD_TPB_0127.do?pgmNo=ESD_TPB_0127&parentPgmNo=ESD_TPB_M001"; 
  			document.form.submit();
  		}
  	}
  	/**
  	 * Defined by DataSheetObject.prototype.event_OnSaveEnd
  	 */
  	function sheet1_OnSaveEnd(sheetObj,errMsg){
  		if(errMsg==null || errMsg == ''){
  			if(document.form.f_cmd.value == REMOVE){
  				ComShowMessage(getMsg('TPB90059'));
            		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
  			} else if(document.form.f_cmd.value == MODIFY){
  			    document.form.s_correction_yn.value="Y"; 
      			document.form.f_cmd.value=SEARCH01;
      			document.form.method="post";
      			document.form.action="ESD_TPB_127.do?pgmNo=ESD_TPB_0127&parentPgmNo=ESD_TPB_M001&s_n3pty_inv_no="+document.form.s_n3pty_inv_no.value+"&s_n3pty_inv_rmd="+document.form.s_n3pty_inv_rmd_cd.value+"&s_n3pty_inv_his_seq="+document.form.s_n3pty_inv_his_seq.value;
      			document.form.submit();
  			} else if(document.form.f_cmd.value == ADD){
  				ComShowMessage(getMsg('COM12149','AR Interface','',''));
      			document.all.btn_erpInterface.style.display='none'; 
  			} else {
  			    // ComShowMessage('sss');
  			}
  			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
  		} else {
  		    ComShowMessage(errMsg);
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
  			ComClearCombo(s_if_ofc_cd);
  			getTPBGenCombo('s_if_ofc_cd','searchTPBOfficeList','F','','2', new Array("s_if_ctrl_cd","s_office_level"));
  		} else if(f.s_office_level.value == "C"){ //CTRL
  			getTPBGenCombo('s_if_ofc_cd','searchTPBOfficeList','F','','2', new Array("s_if_ctrl_cd","s_office_level"));
  		}else if(f.s_office_level.value == "T" || f.s_office_level.value == ""){ //General Office
  			ComClearCombo(s_if_ofc_cd);
  			ComAddComboItem(s_if_ofc_cd, f.s_ofc_cd_for_rhq.value, f.s_ofc_cd_for_rhq.value);
  		}
  	}
	/* Finishing work */
