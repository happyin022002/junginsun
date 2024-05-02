/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0136.js
*@FileTitle  : Activity - TPB Closing
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/24
=========================================================*/
/****************************************************************************************
  Event code : 	INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    			MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
  OTHER CASE : 	COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESD_TPB_0136 : business script for ESD_TPB_0136
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
  		var sheetObj=sheetObjects[0];
  		var formObj=document.form;
  		sheetObj.RemoveEtcData();
  		formObj.f_cmd.value=SEARCH01;
   		sheetObj.DoSearch("ESD_TPB_0135GS.do", tpbFrmQryStr(formObj) );
  		var user_ctrl_ofc_cd=sheetObj.GetEtcData('USER_CTRL_OFC_CD');
		formObj.s_ctrl_ofc_cd.value=user_ctrl_ofc_cd;
  		var real_office_level=formObj.s_office_level.value;
  		formObj.s_office_level.value='H';
  		getRHQOfcList();
  		document.form.s_office_level.value=real_office_level;
  		setSelectBox(document.form.s_if_rhq_cd,document.form.s_rhq_cd_for_rhq.value);
  		if_rhq_cd_OnChange();
  		getCtrlOfcList();
  		if( real_office_level == 'C') setSelectBox(document.form.s_if_ctrl_cd,document.form.s_user_ofc_cd.value);
  		else setSelectBox(document.form.s_if_ctrl_cd,document.form.s_ctrl_ofc_cd.value);
  		if_ctrl_cd_OnChange();
  		setSelectBox(document.form.s_if_ofc_cd,document.form.s_user_ofc_cd.value);
  	 }
  	function setSelectBox(obj, value){
  		if(obj.length > 0){
  			for(var i=0; i<obj.options.length; i++){
  				if(obj.options[i].value == value){
  					obj.options.selectedIndex=i;
  				}
  			}
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
  		        	var HeadTitle="STS|S/N|TPB No.|RHQ|Closing Office|Source|Invoice No.|Invoice Date|Source No.|BKG No.|B/L No.|VVD|EQ No|Type|3rd Party Code|3rd Party Name|TPB Status|Overdue|Currency|Original|Invoice|Collect|Adjust|Balance|I/F User|I/F Office|Adjust Type|R.O.C From|R.O.C To|Recovery Activity|EAC Type|CSR No.";

  		        	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:3, DataRowMerge:1 } );

  		        	var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
  		        	var headers = [ { Text:HeadTitle, Align:"Center"} ];
  		        	InitHeaders(headers, info);

  		        	var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"" },
  		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"n3pty_no_dp_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"n3pty_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rhq",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n3pty_src_sub_sys_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"n3pty_inv_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"inv_iss_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_src_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no_all",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"bl_no_all",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vvd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Text",      Hidden:0,  Width:160,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_bil_tp_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"trd_party_code",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"trd_party_name",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"ots_sts_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"overdue",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"ots_amt",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"inv_amt",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"clt_amt",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"stl_amt",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"bal_amt",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"if_usr_id",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"if_ofc_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_stl_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"stl_rqst_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"stl_to_clt_cng_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Image",     Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:"clt_act_yn",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"edn_tp_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:1,   SaveName:"csr_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ots_sts_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vndr_cust_div_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"n3pty_bil_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cfm_dt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  		             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"so_if_seq",              KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
  		       
  		        	InitColumns(cols);

  		        	SetEditable(1);
  		        	SetImageList(0,"/opuscntr/img/button/btng_collectionactivity.gif");
  		        	SetImageList(1,"/opuscntr/img/button/btng_collectionactivity_yellow.gif");
  		            SetDataLinkMouse("n3pty_no",1);
  		            SetDataLinkMouse("clt_act_yn",1);
  		            //SetSheetHeight(380);
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
  				case "btn_downexcel":
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					break;
  				case "btn_retrieve":
  					doActionIBSheet(sheetObject,formObject,IBSEARCH);
  					break;
  				case "btns_calendar1":
  					var cal=new ComCalendar();
  					cal.displayType="date";
  					cal.select(formObject.s_sdate, 'yyyy-MM-dd');
  					break;
  				case "btns_calendar2":
  					var cal=new ComCalendarFromTo();
  					cal.displayType="date";
  					cal.select(formObject.s_sdate, formObject.s_edate,'yyyy-MM-dd');
  					break;
  				case "btn_new":
  					sheetObject.RemoveAll();
  					formObject.reset();
  					document.all.s_sdate.className="";
  		  			document.all.s_edate.className="";  					
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
  				if(!validateForm(sheetObj,formObj,sAction)) {
  					return false;
  				}
  				formObj.f_cmd.value=SEARCH;
   				sheetObj.DoSearch("ESD_TPB_0136GS.do", tpbFrmQryStr(formObj) );
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
  			if(s_sdate.value == ""){
				ComShowCodeMessage("TPB90098",Msg_Required);
				s_sdate.focus();
				return false;
			}
			if(s_edate.value == ""){
				ComShowCodeMessage("TPB90098",Msg_Required);
				s_edate.focus();
				return false;
			}
			var days_between=ComGetDaysBetween(formObj.s_sdate , formObj.s_edate) ;
			if ( days_between > 365 ) {
				ComShowMessage(" Possible inquiry period is limited to 1 year.");
				return false;
			}
  		}
  		return true;
  	}
  	/**
     * handling process after ending sheet1 retrieve
     */
  	function sheet1_OnSearchEnd(sheetObj,errMsg){
  		for ( var i=0; i <= sheetObj.RowCount(); i++ ){
   			sheetObj.SetCellFontUnderline(i+1, "n3pty_no",1);
  		}
  		//Outstanding Amount 의 Auto Upate check
  		tpb_chgColor_ots_amt(sheetObj, 27, 12);
  	}
  	/**
  	 * Defined by DataSheetObject.prototype.event_OnSaveEnd
  	 */
  	function sheet1_OnSaveEnd(sheetObj,errMsg){
  		if(errMsg==null || errMsg == ''){
  			ComShowMessage(ComGetMsg('COM12149','Data','',''));
  		}
  	}
  	function sheet1_OnClick(sheetObj,Row,Col,Value){
  		if(sheetObj.ColSaveName(Col) == 'n3pty_no'){
  			location.href="ESD_TPB_0115.do?pgmNo=ESD_TPB_0115&parentPgmNo=ESD_TPB_M001&s_direct_tpb_no="+sheetObj.GetCellValue(Row, Col);
  		}else if(sheetObj.ColSaveName(Col) == 'clt_act_yn'){
  			var clt_act_yn=sheetObj.GetCellValue(Row,Col)
  			openRecoveryActPopup(sheetObj.GetCellValue(Row,"n3pty_no"), '', sheetObj.GetCellValue(Row,"fm_clt_cng_ofc_n3pty_no"),'N'); // ROC From 포함시
  		}
  	}
  	function if_rhq_cd_OnChange(){
  		getCtrlOfcList();
  		getTpbOfcList();
  	}
  	function if_ctrl_cd_OnChange(){
  		getTpbOfcList();
  	}
  	/**
	 * Inputting RHQ office in combobox
	 */
	function getRHQOfcList() {
		var sheetObj=sheetObjects[0];
  		var formObj=document.form;
  		sheetObj.RemoveEtcData();
  		formObj.f_cmd.value=SEARCH02;
  		var xmls = sheetObj.GetSearchData("ESD_TPB_0135GS.do", tpbFrmQryStr(formObj) );
		var rhq_ofc_cd=ComGetEtcData(xmls,'RHQ_OFC_CD');
		var rhqOfcCdArray=rhq_ofc_cd.split('|');
		var comboObj=eval("document.all.s_if_rhq_cd");
		if(comboObj != undefined) {
			ComClearCombo(comboObj);
		}
		ComAddComboItem(comboObj, "ALL", "" );
		var k=0;
		while(k < rhqOfcCdArray.length-1 ){
			k++;
			ComAddComboItem(comboObj, rhqOfcCdArray[k], rhqOfcCdArray[k]);
		}
		

	}
	/**
	 * Inputting Control office in combobox
	 */
	function getCtrlOfcList() {
		var sheetObj=sheetObjects[0];
  		var formObj=document.form;
  		sheetObj.RemoveEtcData();
  		formObj.f_cmd.value=SEARCH03;
  		var xmls = sheetObj.GetSearchData("ESD_TPB_0135GS.do", tpbFrmQryStr(formObj) );
		var ctrl_ofc_cd=ComGetEtcData(xmls,'CTRL_OFC_CD');
		var ctrlOfcCdArray=ctrl_ofc_cd.split('|');
		var comboObj=eval("document.all.s_if_ctrl_cd");
		if(comboObj != undefined) {
			ComClearCombo(comboObj);
		}
		ComAddComboItem(comboObj, "ALL", "" );
		var k=0;
		while(k < ctrlOfcCdArray.length-1 ){
			k++;
			ComAddComboItem(comboObj, ctrlOfcCdArray[k], ctrlOfcCdArray[k]);
		}
	}
	/**
	 * Inputting TPB office in combobox
	 */
	function getTpbOfcList() {
		var sheetObj=sheetObjects[0];
  		var formObj=document.form;
  		sheetObj.RemoveEtcData();
  		formObj.f_cmd.value=SEARCH04;
  		var xmls = sheetObj.GetSearchData("ESD_TPB_0135GS.do", tpbFrmQryStr(formObj) );
		var tpb_ofc_cd=ComGetEtcData(xmls,'TPB_OFC_CD');
		var tpbOfcCdArray=tpb_ofc_cd.split('|');
		var comboObj=eval("document.all.s_if_ofc_cd");
		if(comboObj != undefined) {
			ComClearCombo(comboObj);
		}
		ComAddComboItem(comboObj, "ALL", "" );
		var k=0;
		while(k < tpbOfcCdArray.length-1 ){
			k++;
			ComAddComboItem(comboObj, tpbOfcCdArray[k], tpbOfcCdArray[k]);
		}
	}
	/* Finishing work */
