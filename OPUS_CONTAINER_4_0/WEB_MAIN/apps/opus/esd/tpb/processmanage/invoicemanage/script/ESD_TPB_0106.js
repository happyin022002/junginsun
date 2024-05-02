/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0106.js
*@FileTitle  : TPB Handling 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/24
=========================================================
*/
/****************************************************************************************
  Event Code: [Initializing]INIT=0; [Insert]ADD=1; [Retrieve]SEARCH=2; [List retrieve]SEARCHLIST=3;
			  [Modify]MODIFY=4; [Remove]REMOVE=5; [List remove]REMOVELIST=6 [Multi process]MULTI=7
			  [Constant]  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class ESD_TPB_0106 : business script for ESD_TPB_0106
 */
    /* Global Variables */
	  //var calPop = new calendarPopupGrid();
	  var curTab=1;
	  var beforetab=0;
	  var sheetObjects=new Array();
	  var sheetCnt=0;
	  var isJORetrive=false;
	  var MaxDetailCount=100; // Maximum Detatil Count
	  var final_retrieve_querystrings=""; 
	  var cancel = false;
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
  		for(i=0;i<sheetObjects.length;i++){
   		   //Setting startup environment. Change the name of the function
   			ComConfigSheet(sheetObjects[i]);
   			initSheet(sheetObjects[i],i+1);
   			ComEndConfigSheet(sheetObjects[i]);
   		}
  		//document.form.s_vndr_cust_div_cd.onchange=s_vndr_cust_div_cd_OnChange;
  		//document.form.s_vndr_cust_div_cd.onchange = s_trd_party_val_OnFocus;
  		//document.form.s_trd_party_val.onfocus = s_trd_party_val_OnFocus;
  		//document.form.s_trd_party_val.onblur=s_trd_party_val_OnBlur;
  		//document.form.s_vndr_cust_div_cd.onchange=s_vndr_cust_div_cd_OnChange_ToSearch; // for searching
  		//document.form.s_trd_party_val.onfocus = s_trd_party_val_OnFocus;
  		document.form.s_trd_party_val.onblur=s_trd_party_val_OnBlur();
  		//tpb_3rdPartyStaffClear(document.form.s_vndr_cust_div_cd);
		if(document.form.s_n3pty_no.value != "" || document.form.s_dao_n3pty_no.value != ""){
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		} else if ( document.form.s_n3pty_no_strs_link.value.length >= 14) {
		    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
	 		      var HeadTitle1=" || |TPB No.|Invoice No.|Invoice No.|Invoice No.|Exp. Type|Exp. Type|Exp. Type|S/P Inv. No.|EQ No.|3rd Party|3rd Party|3rd Party|Revenue VVD|I/F(TES/TRS/M&R)|I/F(TES/TRS/M&R)|I/F(TES/TRS/M&R)|Currency|Outstanding AMT|Revised AMT|Confirm / ROC-Accept|Confirm / ROC-Accept|Confirm / ROC-Accept|Overdue|AR I/F|AR I/F|AR I/F|invoice_able|revise_able|apif_able|length_n3pty_bil_tp_cd|n3pty_cd_o";
	 		      var HeadTitle2=" || |TPB No.|Invoice No.|Invoice No.|Invoice No.|Main|Sub code|Sub|S/P Inv. No.|EQ No.|Division|Code|Name|Revenue VVD|Cur.|Amount|USD|Currency|Outstanding AMT|Revised AMT|ID|Name|Date|Overdue|ID|Name|Date|invoice_able|revise_able|apif_able|length_n3pty_bil_tp_cd|n3pty_cd_o";
	 		      SetConfig( { SearchMode:2, MergeSheet:7, Page:50, DataRowMerge:0 } );
	 		      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	 		      var headers = [ { Text:HeadTitle1, Align:"Center"},
	 		                      { Text:HeadTitle2, Align:"Center"} ];
	 		      InitHeaders(headers, info);
	 		      var cols = [
	 		             {Type:"Status",    Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ibflag",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	 		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"s_eq_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	 		             {Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	 		             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	 		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_inv_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	 		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"lst_n3pty_inv_rvis_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	 		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"n3pty_inv_rvis_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	 		             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"n3pty_expn_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	 		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"n3pty_bil_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	 		             {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:0,   SaveName:"n3pty_bil_tp_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	 		             {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"n3pty_src_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	 		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eq_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	 		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vndr_cust_div_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	 		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n3pty_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	 		             {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"n3pty_nm",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	 		             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"rev_vvd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	 		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"if_curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	 		             {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:"if_amt",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
	 		             {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:"if_amt_usd",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
	 		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	 		             {Type:"Float",     Hidden:0, Width:110,  Align:"Right",   ColMerge:0,   SaveName:"ots_amt",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
	 		             {Type:"Float",     Hidden:0, Width:110,  Align:"Right",   ColMerge:0,   SaveName:"rvs_amt",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
	 		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cfm_usr_id",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	 		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cfm_usr_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	 		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cfm_dt",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	 		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"overdue",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	 		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"erpif_usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	 		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"erpif_usr_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	 		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"erpif_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
//	 		             {Type:"Image",     Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"rcvr_act_yn",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"invoice_able",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"revise_able",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"erpif_able",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"length_n3pty_bil_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ida_tax_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"n3pty_cd_o",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	 		      InitColumns(cols);
	 		      SetEditable(1);
	 		      SetImageList(0,"/opuscntr/img/button/btng_collectionactivity.gif");
	 		      SetImageList(1,"/opuscntr/img/button/btng_collectionactivity_yellow.gif");
	 		      SetDataLinkMouse("rcvr_act_yn",1);
		          SetSheetHeight(450);
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
  				with(document.form) {
	  			switch(srcName) {
	  				case "btn_add":
	  					doActionIBSheet(sheetObject,formObject,IBINSERT);
	  					break;
//	  				case "btn_cancel":
//	  					doActionIBSheet(sheetObject,formObject,IBSEARCH);
//	  					break;
	  				case "btn_save":
	  					doActionIBSheet(sheetObject,formObject,IBSAVE);
	  					break;
	  				case "btn_cancel":
	  					doActionIBSheet(sheetObject,formObject,COMMAND01);
	  					break;
	  				case "btn_remove":
	  					break;
	  				case "btn_preview":
	  					if(sheetObject.RowCount() < 1){//no data
	  						ComShowCodeMessage("COM132501");
  		        	    } else{
  		        	    	doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  		        	    }
	  					break;
	  				case "btn_downexcel":
	  					if(sheetObject.RowCount() < 1){//no data
	  						ComShowCodeMessage("COM132501");
  		        	    } else{
  		        	    	doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  		        	    }
	  					break;
	  				case "btn_print":
	  					if(sheetObject.RowCount() < 1){//no data
	  						ComShowCodeMessage("COM132501");
  		        	    } else{
  		        	    	doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  		        	    }
	  					break;
	  				case "btn_retrieve":
	  					doActionIBSheet(sheetObject,formObject,IBSEARCH);
	  					break;
	  				case "btn_vvd":
	  					var param='?sdate='+formObject.s_sdate.value+'&edate='+formObject.s_edate.value;
	  					ComOpenPopup('/opuscntr/COM_ENS_0B2.do'+ param, 770, 470, 'getVVD', '1,0,1,1,1,1,1,1', true);
	  					break;
	  				case "btn_new":
	  					doActionIBSheet(sheetObject,formObject,IBCLEAR);
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
	  				case "btn_revise":
	  					doActionIBSheet(sheetObject,formObject,IBSAVE);
	  					break;
	  				case "btn_erpif":
	  					doActionIBSheet(sheetObject,formObject,IBINSERT);
	  					break;
	  				case "btn_invoice":
	  					formObject.f_cmd.value=SEARCH01;
	  					var str="";
	  					for(var i=2;i<=sheetObject.RowCount()+1;i++){
	  						if(sheetObject.GetCellValue(i,"chk") == "1"){
	  							str += sheetObject.GetCellValue(i,"n3pty_no")+"|";
	  							formObject.s_trd_party_code.value=sheetObject.GetCellValue(i,"n3pty_cd_o");
	  						}
	  			  		}
	  					formObject.s_dao_n3pty_no.value=str;
	  					formObject.method="post";
	  					formObject.action="ESD_TPB_0110.do?pgmNo=ESD_TPB_0110&parentPgmNo=ESD_TPB_M001";
	  					formObject.submit();
	  					break;
	  				case "btn_modification":
	  					var str=getCheckN3ptyNo(formObject,sheetObject); 
	  					if(str != ''){
	  						formObject.f_cmd.value=SEARCH;
	  						formObject.method="post";
	  						formObject.action="ESD_TPB_0108.do?pgmNo=ESD_TPB_0108&parentPgmNo=ESD_TPB_M001";
	  						formObject.submit();
	  					}
	  					break;
	  				case "btn_roc":
	  					var str=getCheckN3ptyNo(formObject,sheetObject); 
	  					if(str != ''){
	  						formObject.f_cmd.value=SEARCH;
	  						formObject.method="post";
	  						formObject.action="ESD_TPB_0113.do?pgmNo=ESD_TPB_0113&parentPgmNo=ESD_TPB_M001";
	  						formObject.submit();
	  					}
	  					break;
	  				case "btn_writeoff":
	  					var str=getCheckN3ptyNo(formObject,sheetObject);
	  					if(str != ''){
	  						formObject.f_cmd.value=SEARCH;
	  						formObject.method="post";
	  						formObject.action="ESD_TPB_0114.do?pgmNo=ESD_TPB_0114&parentPgmNo=ESD_TPB_M001";
	  						formObject.submit();
	  					}
	  					break;
				} // end switch
  			}// end with
  		} catch(e) {			
  			if( e == "[object Error]") {
  				ComShowMessage(ComGetMsg('TPB90014'));
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
  				cancel = false;
  				formObj.f_cmd.value=SEARCH;
  				sheetObj.DoSearch("ESD_TPB_0106GS.do", tpbFrmQryStr(formObj) );
  				break;
  				
  			case IBSAVE:		// Revise
  				for(var i=2; i <= sheetObj.RowCount()+1;i++){
  					if(sheetObj.GetCellValue(i,"chk") == "1"){
							var sRow=i;
						}
  				}
  				if(sRow == ""){
  					ComShowMessage(ComGetMsg('TPB90077', 'Invoice No.'));
  					return;
  				} else {
					document.form.s_n3pty_inv_no.value=sheetObj.GetCellValue(sRow, "n3pty_inv_no");
					document.form.s_n3pty_inv_his_seq.value=sheetObj.GetCellValue(sRow, "lst_n3pty_inv_rvis_seq");
					document.form.s_n3pty_inv_rmd_cd.value=sheetObj.GetCellValue(sRow, "n3pty_inv_rvis_cd");
					document.form.s_trd_party_code.value=sheetObj.GetCellValue(sRow, "trd_party_code");
					document.form.s_h_vndr_cust_div_cd.value=sheetObj.GetCellValue(sRow, "vndr_cust_div_cd");
					document.form.s_length_n3pty_bil_tp_cd.value=sheetObj.GetCellValue(sRow, "length_n3pty_bil_tp_cd");
      			    document.form.s_correction_yn.value="Y"; 
          			document.form.f_cmd.value=SEARCH01;
          			document.form.method="post";
          			document.form.action="ESD_TPB_0111.do?pgmNo=ESD_TPB_0111&parentPgmNo=ESD_TPB_M001";
          			document.form.submit();
  				}
  				break;
  				
  			case COMMAND01:		// Revise
  				for(var i=2; i <= sheetObj.RowCount()+1;i++){
  					if(sheetObj.GetCellValue(i,"chk") == "1"){
							var sRow=i;
						}
  				}
  				
  				if(sRow == ""){
  					ComShowMessage(ComGetMsg('TPB90077', 'TPB No.'));
  					return;
  				}else{
  					formObj.f_cmd.value=MULTI;
  					if(ComShowCodeConfirm("TPB90110")){
  						cancel = true;
  	            		var sParam = sheetObj.GetSaveString(0,1, "chk", "sheet_");
  	            		var sXml = sheetObj.GetSaveData("ESD_TPB_0106GS.do", tpbFrmQryStr(formObj)+"&"+sParam);
  	                	sheetObj.LoadSaveData(sXml);
  	            	}
  				}
  				
  				break;
  				
  			case IBINSERT: //ERP I/F
  				for(var i=2;i<=sheetObj.RowCount()+1;i++){
  					if(sheetObj.GetCellValue(i,"chk") == "1"){
							var sRow=i;
						}
  				}
  				if(sRow == ""){
  					ComShowMessage(ComGetMsg('TPB90077', 'Invoice No.'));
  					return;
  				}else{
					var s_n3pty_inv=sheetObj.GetCellValue(sRow,"n3pty_inv_no");
					var s_n3pty_no=sheetObj.GetCellValue(sRow,"n3pty_no");
					document.form.s_n3pty_inv_no.value=sheetObj.GetCellValue(sRow, "n3pty_inv_no");
					document.form.s_n3pty_inv_his_seq.value=sheetObj.GetCellValue(sRow, "lst_n3pty_inv_rvis_seq");
					document.form.s_n3pty_inv_rmd_cd.value=sheetObj.GetCellValue(sRow, "n3pty_inv_rvis_cd");
  					formObj.f_cmd.value=ADD;
  					sheetObj.DoSave("ESD_TPB_0106GS.do", tpbFrmQryStr(formObj),-1,false);
  					//Re-retrieving ERP I/F complete Closed
  					document.form.s_status.value="E";
  					document.form.s_n3pty_inv_no_search.value=s_n3pty_inv;
  					document.form.s_n3pty_no.value=s_n3pty_no;
  					formObj.f_cmd.value=SEARCH;
  					sheetObj.DoSearch("ESD_TPB_0106GS.do", tpbFrmQryStr(formObj) );
  				}
  				break;
  				
  			case IBCLEAR:	   //Clear
  				sheetObj.RemoveAll();
  				formObj.reset();
  				cancel = false;
  				
  				document.all.btn_roc_left.style.display="none";
  				document.all.btn_roc.style.display="none";
  				document.all.btn_roc_right.style.display="none";
  				document.all.btn_writeoff_left.style.display="none";
  				document.all.btn_writeoff.style.display="none";
  				document.all.btn_writeoff_right.style.display="none";
  				document.all.btn_modification_left.style.display="none";
  				document.all.btn_modification.style.display="none";
  				document.all.btn_modification_right.style.display="none";
  				document.all.btn_cancel.style.display="none";
  				document.all.btn_invoice_left.style.display="none";
  		  	    document.all.btn_invoice.style.display="none";
  		  	    document.all.btn_invoice_right.style.display="none";
  		  	    document.all.btn_revise_left.style.display="none";
  			    document.all.btn_revise.style.display="none";
  			    document.all.btn_revise_right.style.display="none";
  			    document.all.btn_erpif_left.style.display="none";
  		  	    document.all.btn_erpif.style.display="none";
  		  	    document.all.btn_erpif_right.style.display="none";
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
		with(formObj){
			if(!ComChkValid(formObj)) return false;
		}
		return true;
	}
	/**
     * handling process after ending sheet1 retrieve
     */
  	function sheet1_OnSearchEnd(sheetObj,errMsg){
  	    document.form.s_n3pty_no_strs_link.value="";
  	    
  	    document.all.btn_roc_left.style.display="none";
		document.all.btn_roc.style.display="none";
		document.all.btn_roc_right.style.display="none";
		document.all.btn_writeoff_left.style.display="none";
		document.all.btn_writeoff.style.display="none";
		document.all.btn_writeoff_right.style.display="none";
		document.all.btn_modification_left.style.display="none";
		document.all.btn_modification.style.display="none";
		document.all.btn_modification_right.style.display="none";
		document.all.btn_cancel.style.display="none";
		document.all.btn_invoice_left.style.display="none";
  	    document.all.btn_invoice.style.display="none";
  	    document.all.btn_invoice_right.style.display="none";
  	    document.all.btn_revise_left.style.display="none";
	    document.all.btn_revise.style.display="none";
	    document.all.btn_revise_right.style.display="none";
	    document.all.btn_erpif_left.style.display="none";
  	    document.all.btn_erpif.style.display="none";
  	    document.all.btn_erpif_right.style.display="none";
  	}
  	/**
  	 * Defined by DataSheetObject.prototype.event_OnSaveEnd
  	 */
  	function sheet1_OnSaveEnd(sheetObj,errMsg){
  		var formObj = document.form;
  		if(errMsg==null || errMsg == ''){
  			document.all.btn_erpif_left.style.display="none";
  		    document.all.btn_erpif.style.display="none";
  		    document.all.btn_erpif_right.style.display="none";
  			
  			if(!cancel){
  				ComShowMessage(ComGetMsg('TPB90075', 'Data'));
  				sheetObj.DoSearch("ESD_TPB_0106GS.do", final_retrieve_querystrings );
  			}else{
  				ComShowMessage(ComGetMsg('COM12116', 'Cancellation '));
  				doActionIBSheet(sheetObj,formObj,IBSEARCH);
  			}
  			
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
  		    ComShowMessage(ComGetMsg('TPB90052', MaxDetailCount.toString()));
  		    return false;
  		} else {
  		    return true;
  		}
  	}
  	function sheet1_OnClick(sheetObj, Row, Col, Value){
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
                  document.all.btn_invoice_left.style.display="";
                  document.all.btn_invoice.style.display="";
            	  document.all.btn_invoice_right.style.display="";
              } else {
            	  document.all.btn_invoice_left.style.display="none";
            	  document.all.btn_invoice.style.display="none";
            	  document.all.btn_invoice_right.style.display="none";
              }
              var revise_able=sheetObj.GetCellValue(Row, "revise_able");
              /// revise button 
              if ( revise_able == 'Y' ) {
            	  document.all.btn_revise_left.style.display="";
            	  document.all.btn_revise.style.display="";
            	  document.all.btn_revise_right.style.display="";
              } else {
            	  document.all.btn_revise_left.style.display="none";
            	  document.all.btn_revise.style.display="none";
            	  document.all.btn_revise_right.style.display="none";
              }
              var erpif_able=sheetObj.GetCellValue(Row, "erpif_able");
              /// erpif button 
              if ( erpif_able == 'Y' ) {
            	  document.all.btn_erpif_left.style.display="";
            	  document.all.btn_erpif.style.display="";
            	  document.all.btn_erpif_right.style.display="";
              } else {
            	  document.all.btn_erpif_left.style.display="none";
            	  document.all.btn_erpif.style.display="none";
            	  document.all.btn_erpif_right.style.display="none";
              }
              // roc, write-off button 
              if ( revise_able != 'Y' && erpif_able != 'Y' ){
				document.all.btn_roc_left.style.display="";
				document.all.btn_roc.style.display="";
				document.all.btn_roc_right.style.display="";
				document.all.btn_writeoff_left.style.display="";
				document.all.btn_writeoff.style.display="";
				document.all.btn_writeoff_right.style.display="";
				document.all.btn_modification_left.style.display="";
				document.all.btn_modification.style.display="";
				document.all.btn_modification_right.style.display="";
				document.all.btn_cancel.style.display="";
              } else {
				document.all.btn_roc_left.style.display="none";
				document.all.btn_roc.style.display="none";
				document.all.btn_roc_right.style.display="none";
				document.all.btn_writeoff_left.style.display="none";
				document.all.btn_writeoff.style.display="none";
				document.all.btn_writeoff_right.style.display="none";
				document.all.btn_modification_left.style.display="none";
				document.all.btn_modification.style.display="none";
				document.all.btn_modification_right.style.display="none";
				document.all.btn_cancel.style.display="none";
              }
              document.all.s_detail_n3pty_no.value=sheetObj.GetCellValue(Row,"n3pty_no");
              document.all.s_trd_party_code.value=sheetObj.GetCellValue(Row,"trd_party_code");
              document.all.s_h_vndr_cust_div_cd.value=sheetObj.GetCellValue(Row,"vndr_cust_div_cd");
              document.all.s_length_n3pty_bil_tp_cd.value=sheetObj.GetCellValue(Row,"length_n3pty_bil_tp_cd");
  		}
  	}
  	//Invoice Detail로 넘길 데이터에 대한 유효성 체크 Checking Invoice Detail passing data
  	function tpb_checkInvoiceList(sheetObject, formObject){
  		var rtn=true;
  		var invArr=new Array(); //row array
  		var bilArr=new Array(); //Billing case array
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
      		for(var i=0;i<invArr.length;i++){
      			if(invArr[i][0] != n3pty_src_sub_sys_cd){
      				ComShowMessage(ComGetMsg('TPB90001',i+1,'Source',''));
      				sheetObject.SetRowBackColor(invArr[i][7],"#C0C0C0");
      				rtn=false;
      				break;
      			}
      			if(invArr[i][1] != trd_party_code){
      				ComShowMessage(ComGetMsg('TPB90001',i+1,'3rd Party',''));
      				sheetObject.SetRowBackColor(invArr[i][7],"#C0C0C0");
      				rtn=false;
      				break;
      			}
      			if(invArr[i][2] != revenue_vvd){
      				ComShowMessage(ComGetMsg('TPB90001',i+1,'Revenue VVD',''));
      				sheetObject.SetRowBackColor(invArr[i][7],"#C0C0C0");
      				rtn=false;
      				break;
      			}
      			if(invArr[i][3] != curr_cd){
      				ComShowMessage(ComGetMsg('TPB90001',i+1,'Currency',''));
      				sheetObject.SetRowBackColor(invArr[i][7],"#C0C0C0");
      				rtn=false;
      				break;
      			}
      		}
  		} else {
      		for(var i=0;i<invArr.length;i++){
      			if(invArr[i][0] != n3pty_src_sub_sys_cd){
      				ComShowMessage(ComGetMsg('TPB90001',i+1,'Source',''));
      				sheetObject.SetRowBackColor(invArr[i][7],"#C0C0C0");
      				rtn=false;
      				break;
      			}
      			if(invArr[i][1] != trd_party_code){
      				ComShowMessage(ComGetMsg('TPB90001',i+1,'3rd Party',''));
      				sheetObject.SetRowBackColor(invArr[i][7],"#C0C0C0");
      				rtn=false;
      				break;
      			}
      			if(invArr[i][2] != revenue_vvd){
      				ComShowMessage(ComGetMsg('TPB90001',i+1,'Revenue VVD',''));
      				sheetObject.SetRowBackColor(invArr[i][7],"#C0C0C0");
      				rtn=false;
      				break;
      			}
      			if(invArr[i][3] != curr_cd){
      				ComShowMessage(ComGetMsg('TPB90001',i+1,'Currency',''));
      				sheetObject.SetRowBackColor(invArr[i][7],"#C0C0C0");
      				rtn=false;
      				break;
      			}
      			if(invArr[i][4] != actual_vvd){
      				ComShowMessage(ComGetMsg('TPB90001',i+1,'Actual VVD',''));
      				//sheetObject.RowBackColor(invArr[i][7]) = "#C0C0C0";
      				rtn=false;
      				break;
      			}
      			if(invArr[i][5] != csr_no){
      				ComShowMessage(ComGetMsg('TPB90001',i+1,'CSR No.',''));
      				//sheetObject.RowBackColor(invArr[i][7]) = "#C0C0C0";
      				rtn=false;
      				break;
      			}
      			if(invArr[i][6] != gl_month){
      				ComShowMessage(ComGetMsg('TPB90001',i+1,'Month of GL Date',''));
      				//sheetObject.RowBackColor(invArr[i][7]) = "#C0C0C0";
      				rtn=false;
      				break;
      			}
      		}
  		}
  		if(invArr.length == 0){
  			ComShowMessage(ComGetMsg('TPB90076', ''));
  			return false;
  		}else if(!rtn){
  			return rtn;
  		}
  		//Checking billing case maximum 8(after duplicate)
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
  			ComShowMessage(ComGetMsg('TPB90002', '8'));
  			rtn=false;
  		}else{
  			//Billing case code count
  			formObject.s_length_n3pty_bil_tp_cd.value=bilArr.length;
  		}
  		//3rd Party code
  		//alert(formObject.s_trd_party_code.value);
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
  			ComShowMessage(ComGetMsg('TPB90077', 'TPB No.'));
  			return;
  		} else {
  			str=sheetObj.GetCellValue(sRow,'n3pty_no');
      		document.form.s_n3pty_no_strs_link.value=str;
  		}
  		if(str == ''){
  			ComShowMessage(ComGetMsg('TPB90076', ''));
  		}
  		//ComShowMessage(str);
  		return str;
  	}