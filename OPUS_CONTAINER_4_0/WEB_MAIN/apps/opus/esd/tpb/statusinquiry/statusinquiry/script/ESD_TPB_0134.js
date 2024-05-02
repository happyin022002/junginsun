/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0134.js
*@FileTitle  : TPB Status by Booking(B/L)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/29
=========================================================*/
/****************************************************************************************
  Event code : 	INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    			MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
  OTHER CASE : 	COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
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
  //no support[check again]CLT 				TabBackColor(0)="146,174,230";
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
  		for(i=0;i<sheetObjects.length;i++){
  		   //Setting startup environment. Change the name of the function
  			ComConfigSheet(sheetObjects[i]);
  			initSheet(sheetObjects[i],i+1);
  			//Setting final environment.
  			ComEndConfigSheet(sheetObjects[i]);
  		}
  		//document.all.btns_calendar2.disabled = true;
  		if (document.form.s_state.value == "BKG"){
	  		var formObject=document.form;
	  		doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);  // Calling in BKG
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
  				with (sheetObj) {
  	            	var cnt=0;
	  	          var HeadTitle="STS||TPB No.|Seq.|Source|Invoice No.|Invoice Date|Source No.|BKG No.|B/L No.|VVD|EQ No|Type|3rd Party Code|3rd Party Name|TPB Status|Overdue|Currency|Original|Invoice|Collect|Adjust|Balance|I/F User|I/F Office|Adjust Type|R.O.C From|R.O.C To|From TPB No.|Recovery Activity|EAC Type|CSR No.";
	
	  	          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:3, DataRowMerge:1 } );
	
	  	          var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	  	          var headers = [ { Text:HeadTitle, Align:"Center"} ];
	  	          InitHeaders(headers, info);
	
	  	          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"" },
	  	              {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
	  	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	  	              {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_no_dp_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	  	              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n3pty_src_sub_sys_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	  	              {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"n3pty_inv_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	  	              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"inv_iss_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	  	              {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_src_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	  	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no_all",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	  	              {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"bl_no_all",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	  	              {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"vvd",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	  	              {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"eq_no",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	  	              {Type:"Text",      Hidden:0,  Width:160,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_bil_tp_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	  	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"trd_party_code",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	  	              {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"trd_party_name",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	  	              {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"ots_sts_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	  	              {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"overdue",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	  	              {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	  	              {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"ots_amt",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
	  	              {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"inv_amt",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
	  	              {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"clt_amt",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
	  	              {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"stl_amt",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
	  	              {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"bal_amt",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
	  	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"if_usr_id",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	  	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"if_ofc_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	  	              {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_stl_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	  	              {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"stl_rqst_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	  	              {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"stl_to_clt_cng_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	  	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"fm_clt_cng_ofc_n3pty_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	  	              {Type:"Image",     Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:"clt_act_yn",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	  	              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"edn_tp_nm",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	  	              {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:1,   SaveName:"csr_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	  	              {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ots_sts_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	  	              {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vndr_cust_div_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	  	              {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"n3pty_bil_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	  	              {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cfm_dt",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	  	              {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"so_if_seq",                KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	  	           
	  	          InitColumns(cols);
	
	  	          SetEditable(1);
	  	          SetImageList(0,"/opuscntr/img/button/btng_collectionactivity.gif");
	  	          SetImageList(1,"/opuscntr/img/button/btng_collectionactivity_yellow.gif");
                  SetDataLinkMouse("clt_act_yn",1);
                  SetSheetHeight(400);
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
  				case "bttn_save":
  					doActionIBSheet(sheetObject,formObject,IBSAVE);
  					break;
  				case "bttn_remove":
  					break;
  				case "bttn_preview":
  //no support[check again]CLT 					sheetObject.ExcelPrint="PreView";
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					break;
  				case "btn_downexcel":
  //no support[check again]CLT 					sheetObject.ExcelPrint="";
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					break;
  				case "bttn_print":
  //no support[check again]CLT 					sheetObject.ExcelPrint="PrintOnly";
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
  				case "btn_vvd":
  					var param='?sdate='+formObject.s_sdate.value+'&edate='+formObject.s_edate.value;
  					ComOpenPopup('/opuscntr/COM_ENS_0B2.do'+ param, 770, 470, 'getVVD', '1,0,1,1,1,1,1,1');
  					break;
  				case "btn_new":
  					sheetObject.RemoveAll();
  					formObject.reset();
  					//formObject.s_edn_tp_cd.disabled = false;
  					//ComClearCombo(formObject.s_n3pty_bil_tp_cd);
  					//ComAddComboItem(formObject.s_n3pty_bil_tp_cd, "<<Select>>", "");
  					//document.all.period_class.className	= "nostar";
  		  			//document.all.s_sdate.className	= "";
  		  			//document.all.s_edate.className	= "";
  					//document.all.s_sdate.disabled = true;
  					//document.all.s_edate.disabled = true;
  					//document.all.btns_calendar2.disabled = true;
  					break;
  				case "btn_3rdParty":
  					get3rdPartyToSearch( formObject.s_vndr_cust_div_cd.value );
  					break;
  				case "btn_settlement":
  					var str=getCheckN3ptyNo(formObject,sheetObject);
  					if(str != ''){
  						formObject.f_cmd.value=SEARCH;
  						formObject.method="post";
  						return;
  						formObject.action="ESD_TPB_0015.do?pgmNo=ESD_TPB_0015&parentPgmNo=ESD_TPB_M001";
  						formObject.submit();
  					}
  					break;
  				case "btn_invoicecreation":
  					var vndr_cust_div_cd="";
  				    var ots_sts_cd="";
  					var n3ptyArr=new Array(); //select n3pty No array
  					for(var i=1;i<=sheetObject.RowCount();i++){
  						if(sheetObject.GetCellValue(i,"chk") == '1'){
  							//Impossible to Invoice Creation in case of staff, Possible to in case of Outstanding Initial status
  							if( sheetObject.GetCellValue(i,"vndr_cust_div_cd") == "S" ||
  									(sheetObject.GetCellValue(i,"ots_sts_cd") != "O" && sheetObject.GetCellValue(i,"ots_sts_cd") != "M") ){
  								ComShowMessage(ComGetMsg('TPB90011','','',''));
  								return;
  							}
  							n3ptyArr[n3ptyArr.length]=new Array(sheetObject.GetCellValue(i,"n3pty_no")
  									,sheetObject.GetCellValue(i,"cfm_dt"));
  						}
  					}
  					if(n3ptyArr.length == 0){
  						ComShowMessage(ComGetMsg('COM12176','','',''));
  						return;
  					} else if(n3ptyArr.length > 0){
  						//Checking each other n3pty_no exist
  						if( n3ptyArr.length == 1 ){
  							formObject.s_n3pty_no.value=n3ptyArr[0][0];
  							formObject.s_cfm_dt.value=n3ptyArr[0][1];
  							formObject.f_cmd.value="";
  							return;
  							formObject.action="ESD_TPB_0106.do";
  							formObject.submit();
  						}else{
  							formObject.s_dao_n3pty_no.value=tpb_getN3ptyArr(n3ptyArr, "NO", "");
  							formObject.s_cfm_dt_prev.value=tpb_getN3ptyArr(n3ptyArr, "DATE", "PREV");
  							formObject.s_cfm_dt_last.value=tpb_getN3ptyArr(n3ptyArr, "DATE", "LAST");
  							formObject.f_cmd.value="";
  							return;
  							formObject.action="ESD_TPB_0106.do";
  							formObject.submit();
  						}
  					}
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
  				sheetObj.DoSearch("ESD_TPB_0134GS.do", tpbFrmQryStr(formObj) );
  				break;
  			case IBSAVE:		//Save
  				if(!validateForm(sheetObj,formObj,sAction)) {
  					return false;
  				}
  				formObj.f_cmd.value=MULTI;
  				sheetObj.DoSave("ESD_TPB_0134GS.do", tpbFrmQryStr(formObj));
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
  			if(!ComChkValid(formObj)) return false;
  			//if(document.all.period_class.className == "star"){
  			if(document.all.s_sdate.className == "input1" && document.all.s_edate.className == "input1"){
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
  		//Checking Auto Update of Outstanding Amount
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
  		}else if(sheetObj.ColSaveName(Col) == 'clt_act_yn'){
  			var clt_act_yn=sheetObj.GetCellValue(Row,Col)
  			openRecoveryActPopup(sheetObj.GetCellValue(Row,"n3pty_no"), '', sheetObj.GetCellValue(Row,"fm_clt_cng_ofc_n3pty_no"),'N'); // ROC From 포함시
  		}
  	}
  	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
  		/*
  		var mRow=sheetObj.MouseRow();
  		var mCol=sheetObj.MouseCol();
  		if(sheetObj.ColSaveName(mCol) == 'clt_act_yn'){
		if(sheetObj.GetCellValue(mRow,mCol) == '0' || sheetObj.GetCellValue(mRow,mCol) == ''){
  				sheetObj.SetMousePointer("Default");
  			}
  		}*/
  	}
	/* Finishing work */
