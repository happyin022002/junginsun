/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0124.js
*@FileTitle  : JO TPB Handling
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
     * @class ESD_TPB_0124 : Defining logic script for ESD_TPB_0124 screen
     */
    /* Global Variables */
  //var calPop = new calendarPopupGrid();
  var curTab=1;
  var beforetab=0;
  var sheetObjects=new Array();
  var sheetCnt=0;
  var isJORetrive=false;
  var MaxDetailCount=100;
  var final_retrieve_querystrings=""; 
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
  		document.form.s_vndr_cust_div_cd.onchange=s_vndr_cust_div_cd_OnChange_ToSearch; // for searching 
  		document.form.s_trd_party_val.onfocus=s_trd_party_val_OnFocus;
  		document.form.s_trd_party_val.onblur=s_trd_party_val_OnBlur_ToSearch;
  		// tpb_3rdPartyStaffClear(document.form.s_vndr_cust_div_cd);
  		if(document.form.s_n3pty_no.value != "" || document.form.s_dao_n3pty_no.value != ""){
  			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
  		} else if ( document.form.s_n3pty_no_strs_link.value.length >= 14) {
  			//document.form.s_n3pty_no.value = document.form.s_n3pty_no_strs_link.value
  		    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
	                var HeadTitle1=" | |TPB No.|Invoice No.|Invoice No.|Invoice No.|Exp. Type|Exp. Type|Exp. Type|S/P Inv. No.|EQ No.|3rd Party|3rd Party|3rd Party|Revenue VVD|I/F(TES/TRS/M&R)|I/F(TES/TRS/M&R)|I/F(TES/TRS/M&R)|Currency|Outstanding AMT|Revised AMT|Confirmation|Confirmation|Confirmation|Overdue|AR I/F|AR I/F|AR I/F|Recovery Activity|invoice_able|revise_able|apif_able|length_n3pty_bil_tp_cd|trd_party_code_o";
	                var HeadTitle2=" | |TPB No.|Invoice No.|||Main|Sub code|Sub|S/P Inv. No.|EQ No.|Division|Code|Name|Revenue VVD|Cur.|Amount|USD|Currency|Outstanding AMT|Revised AMT|ID|Name|Date|Overdue|ID|Name|Date|Recovery Activity|invoice_able|revise_able|apif_able|length_n3pty_bil_tp_cd|trd_party_code_o";
	
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"},
	                                { Text:HeadTitle2, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"sts",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				     {Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_inv_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_inv_rvis_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_inv_rvis_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"n3pty_src_sub_sys_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3pty_bil_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				     {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"n3pty_bil_tp_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				     {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_src_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vndr_cust_div_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"trd_party_code",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				     {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"trd_party_name",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"revenue_vvd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"if_curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				     {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"if_amt",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
				     {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"if_amt_usd",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
				     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				     {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:"ots_amt",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
				     {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:"rvs_amt",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
				     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cfm_usr_id",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cfm_usr_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cfm_dt",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"overdue",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"erpif_usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"erpif_usr_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"erpif_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				     {Type:"Image",     Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"rcvr_act_yn",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"invoice_able",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"revise_able",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"erpif_able",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"length_n3pty_bil_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"trd_party_code_o",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	           
	                InitColumns(cols);
	
	                SetEditable(1);
	                SetImageList(0,"/opuscntr/img/button/btng_collectionactivity.gif");
	                SetImageList(1,"/opuscntr/img/button/btng_collectionactivity_yellow.gif");
	                SetDataLinkMouse("rcvr_act_yn",1);
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
  				case "btn_vvd":
  					var param='?sdate='+formObject.s_sdate.value+'&edate='+formObject.s_edate.value;
  					ComOpenPopup('/opuscntr/COM_ENS_0B2.do'+ param, 770, 470, 'getVVD', '1,0,1,1,1,1,1,1', true);
  					break;
  				case "btn_new":
  					sheetObject.RemoveAll();
  					formObject.reset();
  					document.getElementById("btn_invoice").style.display="none";
  					document.getElementById("btn_revise").style.display="none";
  					document.getElementById("btn_erpif").style.display="none";
  					document.getElementById("btn_modification").style.display="none";
  					break;
  				case "btn_3rdParty":
  					get3rdPartyToSearch( formObject.s_vndr_cust_div_cd.value );
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
  				case "btn_invoice":
  					formObject.f_cmd.value=SEARCH;
  					var str="";
  					for(var i=2;i<=sheetObject.RowCount()+1;i++){
  						if(sheetObject.GetCellValue(i,"chk") == "1"){
  							str += sheetObject.GetCellValue(i,"n3pty_no")+"|";
  							formObject.s_trd_party_code.value=sheetObject.GetCellValue(i,"trd_party_code_o");
  						}
  			  		}
  					formObject.s_dao_n3pty_no.value=str;
  					formObject.method="post";
  					formObject.action="ESD_TPB_0126.do?pgmNo=ESD_TPB_0126&parentPgmNo=ESD_TPB_M001";
  					formObject.submit();
  					break;
  				case "btn_revise":
  					doActionIBSheet(sheetObject,formObject,IBSAVE);
  					break;
  				case "btn_erpif":
  					doActionIBSheet(sheetObject,formObject,IBINSERT);
  					break;  			
  				case "btn_modification":
  					var str=getCheckN3ptyNo(formObject,sheetObject); 
  					if(str != ''){
  						formObject.f_cmd.value=SEARCH;
  						formObject.method="post";
  						formObject.action="ESD_TPB_0125.do?pgmNo=ESD_TPB_0125&parentPgmNo=ESD_TPB_M001";
  						formObject.submit();
  					}
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
  				final_retrieve_querystrings=tpbFrmQryStr(formObj); /// on save end
   				sheetObj.DoSearch("ESD_TPB_0124GS.do", tpbFrmQryStr(formObj) );
  				break;
  			case IBSAVE:		// Revise
  				//var sRow = sheetObj.FindStatusRow("U");
  				//sRow = ComClearSeparator(sRow, "", ";");
  				for(var i=2;i<=sheetObj.RowCount()+1;i++){
  					if(sheetObj.GetCellValue(i,"chk") == "1"){
							var sRow=i;
						}
  				}
  				if(sRow == ""){
  					ComShowCodeMessage('COM12113','Invoice No.','','');
  					return;
  				}else{
  					document.form.s_n3pty_inv_no.value=sheetObj.GetCellValue(sRow, "n3pty_inv_no");
					document.form.s_n3pty_inv_his_seq.value=sheetObj.GetCellValue(sRow, "n3pty_inv_rvis_seq");
					document.form.s_n3pty_inv_rmd_cd.value=sheetObj.GetCellValue(sRow, "n3pty_inv_rvis_cd");
					document.form.s_trd_party_code.value=sheetObj.GetCellValue(sRow, "trd_party_code");
					document.form.s_h_vndr_cust_div_cd.value=sheetObj.GetCellValue(sRow, "vndr_cust_div_cd");
					document.form.s_length_n3pty_bil_tp_cd.value=sheetObj.GetCellValue(sRow, "length_n3pty_bil_tp_cd");
      			    document.form.s_correction_yn.value="Y"; 
      			    document.form.f_cmd.value=SEARCH01;
          			document.form.method="post";
          			document.form.action="ESD_TPB_0127.do?pgmNo=ESD_TPB_0127&parentPgmNo=ESD_TPB_M001"; //?s_n3pty_inv_no="+document.form.s_n3pty_inv_no.value+"&s_n3pty_inv_rmd="+document.form.s_n3pty_inv_rmd_cd.value+"&s_n3pty_inv_his_seq="+document.form.s_n3pty_inv_his_seq.value;
          			document.form.submit();
  				}
  				break;	
  			case IBINSERT: //ERP I/F
  				//var sRow = sheetObj.FindStatusRow("U");
  				//sRow = ComClearSeparator(sRow, ";");
  				for(var i=2;i<=sheetObj.RowCount()+1;i++){
  					if(sheetObj.GetCellValue(i,"chk") == "1"){
						var sRow=i;
					}
				}
  				if(sRow == ""){
  					ComShowCodeMessage('COM12113','Invoice No.','','');
  					return;
  				}else{
  					var s_n3pty_inv=sheetObj.GetCellValue(sRow,"n3pty_inv_no");
  					var s_n3pty_no=sheetObj.GetCellValue(sRow,"n3pty_no");
  					document.form.s_n3pty_inv_no.value=sheetObj.GetCellValue(sRow, "n3pty_inv_no");
  					document.form.s_n3pty_inv_his_seq.value=sheetObj.GetCellValue(sRow, "n3pty_inv_rvis_seq");
  					document.form.s_n3pty_inv_rmd_cd.value=sheetObj.GetCellValue(sRow, "n3pty_inv_rvis_cd");
					formObj.f_cmd.value=ADD;
					sheetObj.DoSave("ESD_TPB_0124GS.do", tpbFrmQryStr(formObj),-1,false);
					//Re-retrieved target closed of complete ERP I/F
  					document.form.s_status.value="E";
  					document.form.s_n3pty_inv_no_search.value=s_n3pty_inv;
  					document.form.s_n3pty_no.value=s_n3pty_no;
  					formObj.f_cmd.value=SEARCH;
   					sheetObj.DoSearch("ESD_TPB_0124GS.do", tpbFrmQryStr(formObj) );
  				}
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
  		}
  		return true;
  	}
  	/**
  	 * Processing function in case of error to result of retrieve
  	 * Defined by DataSheetObject.prototype.event_OnSearchEnd
  	 */
  	function sheet1_OnSearchEnd(sheetObj,errMsg){
  	    document.form.s_n3pty_no_strs_link.value="";
  	}
  	/**
  	 * Defined by DataSheetObject.prototype.event_OnSaveEnd
  	 */
  	function sheet1_OnSaveEnd(sheetObj,errMsg){
  		if(errMsg==null || errMsg == ''){
  			document.getElementById("btn_erpif").style.display="none";
  		    ComShowCodeMessage('COM12149','Data');
   			sheetObj.DoSearch("ESD_TPB_0124GS.do", final_retrieve_querystrings );
  		}
  	}
  	function sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y){
  	}
  	function tpb_checkInvoiceDetailCount(sheetObj){
  		var cnt=0;
  		for(var i=1;i<=sheetObj.RowCount();i++){
  			cnt += sheetObj.GetCellValue(i,"chk_box");
  		}
  		if ( cnt > MaxDetailCount ){
  			ComShowCodeMessage('TPB90052', MaxDetailCount.toString());
  		    return false;
  		} else {
  		    return true;
  		}
  	}
  	function sheet1_OnClick(sheetObj, Row,Col,Value){
  		if ( sheetObj.ColSaveName(Col) == "rcvr_act_yn" ) {
  			var r_n3pty_no=sheetObj.GetCellValue(Row, "n3pty_no");
  			var r_n3pty_inv_no=sheetObj.GetCellValue(Row, "n3pty_inv_no");
  			openRecoveryActPopup(r_n3pty_no,r_n3pty_inv_no,'','N');
  		}
  	}
  	function sheet1_OnChange(sheetObj,Row,Col,Value){
  		if ( sheetObj.ColSaveName(Col) == "chk" ) {
  			var invoice_able=sheetObj.GetCellValue(Row, "invoice_able");
              /// invoice button 
              if ( invoice_able == 'Y' ) {
            		document.getElementById("btn_invoice").style.display="";
              } else {
            		document.getElementById("btn_invoice").style.display="none";
              }
              var revise_able=sheetObj.GetCellValue(Row, "revise_able");
              /// revise button 
              if ( revise_able == 'Y' ) {
            		document.getElementById("btn_revise").style.display="";
              } else {
            		document.getElementById("btn_revise").style.display="none";
              }
              var erpif_able=sheetObj.GetCellValue(Row, "erpif_able");
              /// erpif button 
              if ( erpif_able == 'Y' ) {
            		document.getElementById("btn_erpif").style.display="";
              } else {
            	  document.getElementById("btn_erpif").style.display="none";
              }
            	// roc, write-off button 
              if ( revise_able != 'Y' && erpif_able != 'Y' ){
            	  document.getElementById("btn_modification").style.display="";
              } else {
            	  document.getElementById("btn_modification").style.display="none";
              }
              // tpb no            
              document.all.s_detail_n3pty_no.value=sheetObj.GetCellValue(Row,"n3pty_no");
      		//3rd Party code
              document.all.s_trd_party_code.value=sheetObj.GetCellValue(Row,"trd_party_code");
      		//vndr_cust_div_cd
              document.all.s_h_vndr_cust_div_cd.value=sheetObj.GetCellValue(Row,"vndr_cust_div_cd");
              document.all.s_length_n3pty_bil_tp_cd.value=sheetObj.GetCellValue(Row,"length_n3pty_bil_tp_cd");
  		}
  	}
  	// Checking invoice detail data
  	function tpb_checkInvoiceList(sheetObject, formObject){
  		var rtn=true;
  		var invArr=new Array(); //Selected row array
  		var bilArr=new Array(); //Selected Billing case array
  		var n3pty_src_sub_sys_cd='';
  		var trd_party_code='';
  		var revenue_vvd='';
  		var actual_vvd='';
  		var curr_cd='';
  		var vndr_cust_div_cd='';
  		var csr_no='';
  		var gl_month='';
  		for(var i=1;i<=sheetObject.RowCount();i++){
  			if(sheetObject.GetCellValue(i,0) == '1'){
  				invArr[invArr.length]=new Array( sheetObject.GetCellValue(i,"n3pty_src_sub_sys_cd")
  						,sheetObject.GetCellValue(i,"trd_party_code")
  						,sheetObject.GetCellValue(i,"revenue_vvd")
  						,sheetObject.GetCellValue(i,"curr_cd")
  						,sheetObject.GetCellValue(i,"vvd_cd")
  						,sheetObject.GetCellValue(i,"csr_no")
  						,sheetObject.GetCellValue(i,"gl_month")
  												  ,i);
  				bilArr[bilArr.length]=sheetObject.GetCellValue(i,"n3pty_bil_tp_cd");
  				if(n3pty_src_sub_sys_cd == ''){
  					n3pty_src_sub_sys_cd=sheetObject.GetCellValue(i,"n3pty_src_sub_sys_cd");
  				}
  				if(trd_party_code == ''){
  					trd_party_code=sheetObject.GetCellValue(i,"trd_party_code");
  				}
  				if(revenue_vvd == ''){
  					revenue_vvd=sheetObject.GetCellValue(i,"revenue_vvd");
  				}
  				if(curr_cd == ''){
  					curr_cd=sheetObject.GetCellValue(i,"curr_cd");
  				}
  				if(vndr_cust_div_cd == ''){
  					vndr_cust_div_cd=sheetObject.GetCellValue(i,"vndr_cust_div_cd");
  				}
  				if(actual_vvd == ''){
  					actual_vvd=sheetObject.GetCellValue(i,"vvd_cd");
  				}
  				if(csr_no == ''){
  					csr_no=sheetObject.GetCellValue(i,"csr_no");
  				}
  				if(gl_month == ''){
  					gl_month=sheetObject.GetCellValue(i,"gl_month");
  				}
  			}
  		}
  		var invArrLen=invArr.length;
  		var invArrStr=invArr.toString();
  		// outstanding grouping check 
  		if ( isJORetrive==false ){
         		//Checking other value of NON J/O  : Source, 3rd Party, Revenue VVD, Currency
      		for(var i=0;i<invArr.length;i++){
      			if(invArr[i][0] != n3pty_src_sub_sys_cd){
      				ComShowCodeMessage('TPB90001',i+1,'Source','');
      				sheetObject.SetRowBackColor(invArr[i][7],"#C0C0C0");
      				rtn=false;
      				break;
      			}
      			if(invArr[i][1] != trd_party_code){
      				ComShowCodeMessage('TPB90001',i+1,'3rd Party','');
      				sheetObject.SetRowBackColor(invArr[i][7],"#C0C0C0");
      				rtn=false;
      				break;
      			}
      			if(invArr[i][2] != revenue_vvd){
      				ComShowCodeMessage('TPB90001',i+1,'Revenue VVD','');
      				sheetObject.SetRowBackColor(invArr[i][7],"#C0C0C0");
      				rtn=false;
      				break;
      			}
      			if(invArr[i][3] != curr_cd){
      				ComShowCodeMessage('TPB90001',i+1,'Currency','');
      				sheetObject.SetRowBackColor(invArr[i][7],"#C0C0C0");
      				rtn=false;
      				break;
      			}
      		}
  		} else {
  		    //Checking other value of J/O Case - Source, 3rd Party, Actual VVD, Currency, Csr No., Month of GL Date
      		for(var i=0;i<invArr.length;i++){
      			if(invArr[i][0] != n3pty_src_sub_sys_cd){
      				ComShowCodeMessage('TPB90001',i+1,'Source','');
      				sheetObject.SetRowBackColor(invArr[i][7],"#C0C0C0");
      				rtn=false;
      				break;
      			}
      			if(invArr[i][1] != trd_party_code){
      				ComShowCodeMessage('TPB90001',i+1,'3rd Party','');
      				sheetObject.SetRowBackColor(invArr[i][7],"#C0C0C0");
      				rtn=false;
      				break;
      			}
      			if(invArr[i][2] != revenue_vvd){
      				ComShowCodeMessage('TPB90001',i+1,'Revenue VVD','');
      				sheetObject.SetRowBackColor(invArr[i][7],"#C0C0C0");
      				rtn=false;
      				break;
      			}
      			if(invArr[i][3] != curr_cd){
      				ComShowCodeMessage('TPB90001',i+1,'Currency','');
      				sheetObject.SetRowBackColor(invArr[i][7],"#C0C0C0");
      				rtn=false;
      				break;
      			}
      			if(invArr[i][4] != actual_vvd){
      				ComShowCodeMessage('TPB90001',i+1,'Actual VVD','');
//      				sheetObject.RowBackColor(invArr[i][7]) = "#C0C0C0";
      				rtn=false;
      				break;
      			}
      			if(invArr[i][5] != csr_no){
      				ComShowCodeMessage('TPB90001',i+1,'CSR No.','');
//      				sheetObject.RowBackColor(invArr[i][7]) = "#C0C0C0";
      				rtn=false;
      				break;
      			}
      			if(invArr[i][6] != gl_month){
      				ComShowCodeMessage('TPB90001',i+1,'Month of GL Date','');
//      				sheetObject.RowBackColor(invArr[i][7]) = "#C0C0C0";
      				rtn=false;
      				break;
      			}
      		}
  		}
  		if(invArr.length == 0){
  			ComShowCodeMessage('COM12176','','','');
  			return false;
  		}else if(!rtn){
  			return rtn;
  		}
  		//Checking Billing Case Maximum 8(Deduplication after)
  		for(var i=0;i<bilArr.length;i++){
  			var dbl=0;
  			for(var j=0;j<bilArr.length;j++){
  				if(bilArr[i] != bilArr[j]){
  					continue;
  				}else{
  					dbl++;
  					if(dbl>1){
  						bilArr.splice(j,1);
  						j--;
  					}
  				}
  			}
  		}
  		if(bilArr.length > 8){
  			ComShowCodeMessage('TPB90002','8','','');
  			rtn=false;
  		}else{
  			//Billing case code count
  			formObject.s_length_n3pty_bil_tp_cd.value=bilArr.length;
  		}
  		//3rd Party code
  		formObject.s_trd_party_code.value=trd_party_code;
  		//vndr_cust_div_cd
  		formObject.s_h_vndr_cust_div_cd.value=vndr_cust_div_cd;
  		return rtn;
  	}
  	function getCheckN3ptyNo(formObj, sheetObj){
        document.form.s_n3pty_no_strs_link.value="";
  		var str='';
  		var sRow=sheetObj.FindCheckedRow("chk");
  		sRow=sRow.split("|")[0];
  		if(sRow == ""){
  			ComShowCodeMessage('COM12113','TPB No.','','');
  			return;
  		} else {
  			str=sheetObj.GetCellValue(sRow,'n3pty_no');
      		document.form.s_n3pty_no_strs_link.value=str;
  		}
  		if(str == ''){
  			ComShowCodeMessage('COM12176','','','');
  		}
  		// showErrMessage(str);
  		return str;
  	}
	/* Finishing work */
