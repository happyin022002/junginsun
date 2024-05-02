/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0115.js
*@FileTitle  : TPB Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/24
=========================================================
*/
/****************************************************************************************
  Event code : 	INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    			MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
  OTHER CASE : 	COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESD_TPB_0115 : business script for ESD_TPB_0115
     */
    /* Global Variables */
    var curTab=1;
    var beforetab=0;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var isReadOnly="";
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
		 formObject = document.form;
	   	 var objs=document.all.item("tabLayer");
	   	 objs[nItem].style.display="Inline";
	   	 for(var i = 0; i< objs.length; i++){
	       	  if(i != nItem){
	        	   objs[i].style.display="none";
	        	   objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
	       	  }
	   	}
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
		isReadOnly=document.form.s_readonly.value;
		for(i=0;i<sheetObjects.length;i++){
		   //Setting startup environment. Change the name of the function
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			//Setting final environment.
			ComEndConfigSheet(sheetObjects[i]);
		}
		sheetObjects[1].SetVisible(0);
		if ( document.form.s_n3pty_no.value.length > 0 ){
			doActionIBSheet(sheetObjects[1],document.form,SEARCH);
			doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
		}
		//document.form.s_vndr_cust_div_cd.onchange=s_vndr_cust_div_cd_OnChange;
		//document.form.s_trd_party_val.onfocus = s_trd_party_val_OnFocus; 
		//document.form.s_trd_party_val.onblur=s_trd_party_val_OnBlur;
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
				      var HeadTitle1=" |TPB No.|Invoice No.|TPB Seq No.|Seq.|Exp. Type|Exp. Type|Exp. Type|EQ Kind|EQ No.|BKG No.|B/L No.|VVD|S/P Inv. No.|I/F (TES/TRS/M&R)|I/F (TES/TRS/M&R)|I/F (TES/TRS/M&R)|Confirmed|Confirmed|Invoiced|Invoiced|AR I/F|AR I/F|I/F (TES/TRS/M&R)|I/F (TES/TRS/M&R)|I/F (TES/TRS/M&R)|Confirmed|Confirmed|Confirmed|Overdue days|Remark";
				      var HeadTitle2=" |TPB No.|Invoice No.|TPB Seq No.|Seq.|Main|Sub-Cd|Sub|EQ Kind|EQ No.|BKG No.|B/L No.|VVD|S/P Inv. No.|Cur.|Amount|USD|Cur.|Amount|Cur.|Amount|Cur.|Amount|Office|User|Date|Office|User|Date|Overdue days|Remark";
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"},
				                      { Text:HeadTitle2, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"Status",    Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"sts",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_inv_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ots_dtl_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"n3pty_no_dp_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"n3pty_expn_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3pty_bil_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:"n3pty_bil_tp_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"eq_knd_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rev_vvd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_src_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"if_curr_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:"if_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:"if_amt_usd",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cfm_curr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:"cfm_amt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"inv_curr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:"inv_amt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"clt_curr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:"clt_amt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"if_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"if_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"if_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cfm_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cfm_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cfm_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"overdue_days",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:0,    Align:"Left",    ColMerge:1,   SaveName:"cfm_rmk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				      if ( isReadOnly!='Y' ){
//				    	  allReadonly(document.form);
				      }
				      InitColumns(cols);
				      SetEditable(0);
				      //SetSheetHeight(370);
				      ComResizeSheet(sheetObjects[0]);
		            }
				break;
				
			case 2: //sheet2 init
			    with(sheetObj){
				      var cnt=0;
				      var HeadTitle="STS|n3pty_no|n3pty_inv_no|ofc_cd|ots_sts_nm|overdue|vndr_cust_div_cd|trd_party_val|trd_party_nm|csr_no|roc_in|roc_out|file_no";
				      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
				      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"Status",    Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ibflag",            KeyField:0,   CalcLogic:"" },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n3pty_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n3pty_inv_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ots_sts_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"overdue",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vndr_cust_div_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"trd_party_val",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"trd_party_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"csr_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"roc_in",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"roc_out",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"file_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				      InitColumns(cols);
				      SetEditable(1);
				      SetSheetHeight(110);
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
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "bttn_add":
					doActionIBSheet(sheetObject,formObject,IBINSERT);
					break;
				case "btn_cancel_process": /// Cancel By Super User
					var ots=formObject.s_ots_sts_cd.value;
					if(ots == 'L' || ots == 'A' || ots == 'K' || ots == 'E' || ots == 'D'){ //ERP I/F
						ComShowCodeMessage("TPB90010","use Cancel Close Function ");
						return;
					}
					doActionIBSheet(sheetObjects[1],formObject,COMMAND01);
					break;
				case "btn_close_process": /// Close Process By General User
     	            formObject.s_process_close_message.value="";
					var ots=formObject.s_ots_sts_cd.value;
					if(ots == 'L' || ots == 'A' || ots == 'K' || ots == 'E' || ots == 'D'){ //ERP I/F
						ComShowCodeMessage("TPB90010","use Process Close Function ");
						return;
					}
					if(formObject.s_n3pty_bil_tp_cd.value=='JO'){ // JO Case Blocking
						ComShowCodeMessage("TPB90047");  
						return;
					}
					if(ots == 'I' || ots == 'R'){ // Invoice / Adjustment Request Case
					    if ( ots == 'I' ){
       						ComShowCodeMessage("TPB90049");
					    } else if ( ots == 'R' ){
					        ComShowCodeMessage("TPB90050");
					    }
						return;
					}
					doActionIBSheet(sheetObjects[1],formObject,COMMAND02);
					break;
				case "btn_save":
					var ots=formObject.s_ots_sts_cd.value;
                    if(ots != 'O' && ots != 'J' && ots != 'M'){
						ComShowCodeMessage('TPB90010','save ','','');
						return;
					}
					doActionIBSheet(sheetObjects[1],formObject,IBSAVE);
					break;
				case "bttn_remove":
					break;
				case "bttn_preview":
					if(sheetObject.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
	        	    } else{
	        	    	doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
	        	    }
					break;
				case "bttn_excel":
					if(sheetObject.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
	        	    } else{
	        	    	doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
	        	    }
					break;
				case "bttn_print":
					if(sheetObject.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
	        	    } else{
	        	    	doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
	        	    }
					break;
				case "btn_retrieve":
					doActionIBSheet(sheetObjects[1],formObject,SEARCH);
					doActionIBSheet(sheetObject,formObject,SEARCH01);
					break;
				case "btn_new":
					sheetObjects[0].RemoveAll();
					sheetObjects[1].RemoveAll();
					formObject.reset();
					formObject.s_n3pty_no.value="";
					break;
				case "btn_3rdParty":
					get3rdParty( document.all.s_vndr_cust_div_cd.value );
					break;
				case "btn_recoveryactivity":
					var read=document.form.s_readonly.value;
					openRecoveryActPopup(formObject.s_n3pty_no.value,formObject.s_n3pty_inv_no.value,'',read);
					break;
				case "btn_settlement":
					var ots=formObject.s_ots_sts_cd.value;
					if(ots != 'O' && ots != 'J' && ots != 'L'&& ots != 'M'){
						ComShowCodeMessage('TPB90007','','','');
						return;
					}
					return;
					location.href="ESD_TPB_015.do?n3pty_no="+formObject.s_detail_n3pty_no.value+"&f_cmd="+SEARCH;
					break;
				case "btn_invoicecreation":
					if(formObject.s_h_vndr_cust_div_cd.value != "" &&
					   formObject.s_h_vndr_cust_div_cd.value != "S"){ //Impossible to Invoice creation in case of s_h_vndr_cust_div_cd=Staff
						var act=null;
						if(formObject.s_ots_sts_cd.value == "O" || formObject.s_ots_sts_cd.value == "M"){
							act="ESD_TPB_0110.do";
						}else{
							ComShowCodeMessage('TPB90011','','','');
							return;
						}
						formObject.f_cmd.value=SEARCH01;
						formObject.method="post";
						formObject.action=act;
						formObject.submit();
					}
					break;
			} // end switch
	}
	/* Processing Sheet */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case SEARCH:	  //Retrieve
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
  				formObj.f_cmd.value=SEARCH;
				sheetObj.DoSearch("ESD_TPB_0115GS.do", tpbFrmQryStr(formObj) );
				break;
				
			case SEARCH01:	  //Retrieve
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				formObj.f_cmd.value=SEARCH01;
				sheetObj.DoSearch("ESD_TPB_0115GS.do", tpbFrmQryStr(formObj) );
				break;
				
			case IBSAVE:		//Save
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				if(document.form.s_vndr_cust_div_cd.value == "" ||
				   document.form.s_trd_party_val.value == ""){
					if(document.form.s_vndr_cust_div_cd.value == ""){
						ComShowCodeMessage("COM12113","3rd Party type","","");
						document.form.s_vndr_cust_div_cd.focus();
						return;
					}
					if(document.form.s_trd_party_val.value == ""){
						ComShowCodeMessage("COM12114","3rd Party code","","");
						document.form.s_trd_party_val.focus();
						return;
					}
				}
				sheetObj.DataInsert();
				formObj.f_cmd.value=ADD;
				sheetObj.DoSave("ESD_TPB_0115GS.do", tpbFrmQryStr(formObj));
				sheetObj.RemoveAll();
				break;
				
			case COMMAND01:		// Cancel By Super User
				if ( sheetObj.RowCount()> 0 ) { sheetObj.RemoveAll();}
				var sRow=sheetObj.DataInsert();
				sheetObj.SetCellValue(sRow, "cancel_n3pty_no",formObj.s_detail_n3pty_no.value,0);
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				formObj.f_cmd.value=COMMAND01;
				sheetObj.DoSave("ESD_TPB_0115GS.do", tpbFrmQryStr(formObj));
				sheetObj.RemoveAll();
				break;
				
			case COMMAND02:		// Close Process By General User
				if ( sheetObj.RowCount()> 0 ) { sheetObj.RemoveAll();}
				var sRow=sheetObj.DataInsert();
				sheetObj.SetCellValue(sRow, "cancel_n3pty_no",formObj.s_detail_n3pty_no.value,0);
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				var n3pty_src_sub_sys_cd=formObj.s_n3pty_src_sub_sys_cd.value;
				var last_vndr_cust_div_cd=formObj.s_last_vndr_cust_div_cd.value;
				processCloseCase=0;
				if (n3pty_src_sub_sys_cd=="TES" || n3pty_src_sub_sys_cd=="TRS"){
				   if ( last_vndr_cust_div_cd == "C" ) {
				       processCloseCase=1;
				   } else if ( last_vndr_cust_div_cd == "V" ) {
				       processCloseCase=2;
				   }
				} else if (n3pty_src_sub_sys_cd=="MNR") {
				   if ( last_vndr_cust_div_cd == "C" || last_vndr_cust_div_cd == "V" ) {
				       processCloseCase=3;
				   } 
				} 
                if ( processCloseCase != 0 ){
				     var processCloseOk=openProcessClosePopup(formObj, processCloseCase);
                } else {
                    ComShowCodeMessage("TPB90048");
                    return;
                }
                if ( processCloseOk==true ){
    				formObj.f_cmd.value=COMMAND02;
    				sheetObj.DoSave("ESD_TPB_0115GS.do", tpbFrmQryStr(formObj));
 				    sheetObj.RemoveAll();
                }
				break;
			case IBINSERT:	  //Insert
				var Row=sheetObj.DataInsert();
				break;
			case IBCLEAR:	   //Clear
				sheetObj.RemoveAll();
				break;
			case IBDOWNEXCEL:  //Excel download
				sheetObj.Down2Excel(TPBDown2ExcelOptions);
				break;
		}
	}
	/**
	 * Checking validation of input value
	 */
	function validateForm(sheetObj,formObj,sAction){
		return true;
	}
	/**
     * handling process after ending sheet1 retrieve
     */
	function sheet1_OnSearchEnd(sheetObj,errMsg){
		sheetObj.SetColWidth("cfm_rmk",0);
		if(errMsg!=null&&errMsg!=0){
			ComShowMessage(errMsg);
		}
	}
	function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
		if(sheetObj.RowCount()>0){
			document.form.s_n3pty_no.value=GetNull(sheetObj.GetCellValue(1,"n3pty_no"));
			document.form.s_n3pty_inv_no.value=GetNull(sheetObj.GetCellValue(1,"n3pty_inv_no"));
			document.form.s_ofc_cd.value=GetNull(sheetObj.GetCellValue(1,"ofc_cd"));
			document.form.s_ots_sts_nm.value=GetNull(sheetObj.GetCellValue(1,"ots_sts_nm"));
			document.form.s_overdue.value=GetNull(sheetObj.GetCellValue(1,"overdue"));
			document.form.s_vndr_cust_div_cd.value=GetNull(sheetObj.GetCellValue(1,"vndr_cust_div_cd"));
			document.form.s_trd_party_val.value=GetNull(sheetObj.GetCellValue(1,"trd_party_val"));
			document.form.s_trd_party_nm.value=GetNull(sheetObj.GetCellValue(1,"trd_party_nm"));
			document.form.s_csr_no.value=GetNull(sheetObj.GetCellValue(1,"csr_no"));
			document.form.s_roc_in.value=GetNull(sheetObj.GetCellValue(1,"roc_in"));
			document.form.s_roc_out.value=GetNull(sheetObj.GetCellValue(1,"roc_out"));
		}
		else
		{
			document.form.s_n3pty_inv_no.value="";
		}
	}
	
	function sheet2_OnSaveEnd(sheetObj, ErrMsg){
		
	}
	function allReadonly(f){
		var el;
		for ( var n=0, sz=f.elements.length; n < sz; n++){
			el=f.elements(n);
			if ( ! el.name || el.name=="s_trd_party_val" || el.name=="s_trd_party_nm") continue;
			if(el != undefined && el.type != undefined && el.type == 'text'){
				el.readOnly=true;
                 el.style.backgroundColor="#EEEEEE";
                 el.style.color="#555555";
			}
		}
	}
	function getStaff_formail(rowArray){
		var gubun=':';
		var formObj=document.form;
		var user_id='';
		var user_email='';
		for(var i=0; i<rowArray.length; i++){
			if(i == rowArray.length-1) gubun='';
			colArray=rowArray[i];
			user_id += colArray[0] + gubun;
			user_email += colArray[1] + gubun;
		}
		formObj.toEmail.value=user_email+";"+user_id;
	}
	/**
	 * Calling pop-up for message info. registering in case of Process closing 
	 */
    function openProcessClosePopup(formObject, processCloseCase){
    	return;
    	var theURL="ESD_TPB_0917.do?processCloseCase="+processCloseCase;
    	var features="scroll:no;status:no;help:no;dialogWidth:700px;dialogHeight:385px";
    	var rtnValue =  ComOpenWindow(theURL,  window,  features , true);
        var process_colose_message="";
    	if(rtnValue != undefined && rtnValue != null && rtnValue.length > 0){
    	    for(var i=0; i<rtnValue.length; i++ ){
    	       if ( i > 0){
    	           process_colose_message += "|$@$|";
    	       }
    	       process_colose_message += rtnValue[i];
    	    }
     	    formObject.s_process_close_message.value=process_colose_message;
     	    return true;
    	} else {
    	    return false;
    	}
     }
     function GetNull(val){
         if ( val == undefined || val == null ){
            val="";             
         }
         return val;
     }
	/* Finishing work */