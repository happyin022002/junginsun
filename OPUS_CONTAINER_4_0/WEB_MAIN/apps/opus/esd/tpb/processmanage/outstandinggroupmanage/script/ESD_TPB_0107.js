/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0107.js
*@FileTitle  : TPB Group Remaking 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/24
=========================================================
*/
    /* Global Variables */
	  //var calPop = new calendarPopupGrid();
	  var curTab=1;
	  var beforetab=0;
	  var sheetObjects=new Array();
	  var sheetCnt=0;
	  var n3pty_no_Array=new Array(); // it will be used on group change
	  var n3pty_expn_tp_cd_Array=new Array(); // for group check condition 
	  var trd_party_code_Array=new Array(); // for group check condition 
	  var rev_vvd_Array=new Array(); // for group check condition 
	  var cfm_curr_cd_Array=new Array(); // for group check condition 
	  var act_vvd_Array=new Array(); // for group check condition // for JO
	  var csr_no_Array=new Array(); // for group check condition // for JO
	  var gl_month_Array=new Array(); // for group check condition // for JO
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
  	 * tab1의 onChange이벤트핸들러
  	 * IBSheetConfig.js에서 정의한 핸들러 함수를 구현한 것임
  	 */
  	function tab1_OnChange(nItem){
  		ChangeTab(document.all.tab1,nItem);
  	}
  	/**
  	 * onChange event of tab1
  	 * Implementing defined function from IBSheetConfig.js
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
  			//Setting final environment.
  			ComEndConfigSheet(sheetObjects[i]);
  		}
  		if(document.form.s_office_level.value == "H"){
  			getTPBGenCombo('s_if_rhq_cd','searchHandleRHQList','F','','2', new Array("s_ofc_cd_for_rhq","s_office_level"));
  		} else if(document.form.s_office_level.value == "R"){
  			ComClearCombo(document.form.s_if_rhq_cd);
			ComAddComboItem(document.form.s_if_rhq_cd, document.form.s_rhq_cd_for_rhq.value, document.form.s_rhq_cd_for_rhq.value);
			setTimeout("if_rhq_cd_OnChange();",300);
  		} else if(document.form.s_office_level.value == "G" ||  document.form.s_office_level.value == "T" ||  document.form.s_office_level.value == "C" || document.form.s_office_level.value == ""){
  			getTPBGenCombo('s_if_rhq_cd','searchHandleRHQList','F','','5', new Array("s_ofc_cd_for_rhq","s_office_level"));
  			if_rhq_cd_OnChange();
  		}
  		//document.form.s_if_rhq_cd.onchange = if_rhq_cd_OnChange;
  		//document.form.s_n3pty_bil_tp_cd.onchange = s_n3pty_bil_tp_cd_OnChange;
  		//document.form.s_vndr_cust_div_cd.onchange = s_vndr_cust_div_cd_OnChange_ToSearch; // for searching 
  		//document.form.s_trd_party_val.onfocus = s_trd_party_val_OnFocus;
  		//document.form.s_trd_party_val.onblur = s_trd_party_val_OnBlur_ToSearch;
  		//document.form.s_if_rhq_cd.onchange=if_rhq_cd_OnChange;
  		//document.form.s_vndr_cust_div_cd.onchange=s_trd_party_val_OnFocus; // for searching 
  		//document.form.s_trd_party_val.onfocus=s_trd_party_val_OnFocus;
  		//document.form.s_trd_party_val.onblur=s_trd_party_val_OnBlur_ToSearch;
  		//document.all.btns_calendar2.disabled = true;
  		//document.form.s_n3pty_src_sub_sys_cd.onchange=tpb_searchBillingCaseByExpenseType;
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
		 		      var HeadTitle1="STS||G/S Org|G/S|dtl_seq|AS-IS(Current)|AS-IS(Current)|TO-BE(To be Changed)|TO-BE(To be Changed)|Expense Type|Expense Type|Expense Type|S/P Invoice No.|BKG No.|B/L No.|Revenue VVD|Actual VVD|CSR No.|GL Month|EQ No.|3rd Party|3rd Party|TPB Status|Candidate YN|ROC Candidate YN|Confirm Currency|Confirmed Amount";
		 		      var HeadTitle2="STS||G/S Org|G/S|dtl_seq|TPB No.|Seq.|TPB No.|Seq.|Main|Sub Code|Sub|S/P Invoice No.|BKG No.|B/L No.|Revenue VVD|Actual VVD|CSR No.|GL Month|EQ No.|Code|Name|TPB Status|Candidate YN|ROC Candidate YN|Confirm Currency|Confirmed Amount";
		 		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		 		      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		 		      var headers = [ { Text:HeadTitle1, Align:"Center"},
		 		                      { Text:HeadTitle2, Align:"Center"} ];
		 		      InitHeaders(headers, info);
		 		      var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		 		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		 		             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"grp_srt_no_org",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		 		             {Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"grp_srt_no",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		 		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ots_dtl_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		 		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_no_org",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		 		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n3pty_no_dp_seq_org",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		 		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		 		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n3pty_no_dp_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		 		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n3pty_expn_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		 		             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n3pty_bil_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		 		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"n3pty_bil_tp_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		 		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_src_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		 		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no_all",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		 		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_no_all",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		 		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rev_vvd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		 		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"act_vvd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		 		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"csr_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		 		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"gl_month",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		 		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		 		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"trd_party_code",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		 		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"trd_party_name",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		 		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"ots_sts_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		 		             {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"candidate_yn",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		 		             {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"roc_candidate_yn",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		 		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"cfm_curr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		 		             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:"cfm_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 } ];
		 		      InitColumns(cols);
		 		      SetEditable(1);
		 		      SetSheetHeight(360);
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
				case "bttn_add":
					doActionIBSheet(sheetObject,formObject,IBINSERT);
					break;
				case "bttn_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
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
				case "btn_downexcel":
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
  					doActionIBSheet(sheetObject,formObject,IBSEARCH);
  					break;
  				case "btns_calendar1":
  					var cal=new ComCalendar();
  					cal.displayType="date";
  					cal.select(formObject.s_sdate, 'yyyy-MM-dd');
  					break;
  				case "btns_calendar2":
  					if (!document.all.btns_calendar2.disabled){
	  					var cal=new ComCalendarFromTo();
	  					cal.displayType="date";
	  					cal.select(formObject.s_sdate, formObject.s_edate,'yyyy-MM-dd');
  					}
  					break;
  				case "btn_vvd":
  					var param='?sdate='+formObject.s_sdate.value+'&edate='+formObject.s_edate.value;
  					ComOpenPopup('/opuscntr/COM_ENS_0B2.do'+ param, 770, 470, 'getVVD', '1,0,1,1,1,1,1,1');
  					break;
  				case "btn_new":
  					sheetObject.RemoveAll();
  					formObject.reset();
  					break;
  				case "btn_save":
  					doActionIBSheet(sheetObject,formObject,IBSAVE);
  					break;
  				case "btn_3rdParty":
  					get3rdPartyToSearch( formObject.s_vndr_cust_div_cd.value );
  					break;
  				case "btn_settlement":
  					var str=getCheckN3ptyNo(formObject,sheetObject);
  					if(str != ''){
  						formObject.f_cmd.value=SEARCH;
  						formObject.method="post";
  						formObject.action="ESD_TPB_0015.do";
  						formObject.submit();
  					}
  					break;
  				case "btn_invoicecreation":
  					var vndr_cust_div_cd="";
  				    var ots_sts_cd="";
  					var n3ptyArr=new Array();
  					for(var i=1;i<=sheetObject.RowCount();i++){
  						if(sheetObject.GetCellValue(i,"chk") == '1'){
  							if( sheetObject.GetCellValue(i,"vndr_cust_div_cd") == "S" || (sheetObject.GetCellValue(i,"ots_sts_cd") != "O" && sheetObject.GetCellValue(i,"ots_sts_cd") != "M") ){
  								ComShowMessage(ComGetMsg('TPB90011','','',''));
  								return;
  							}
  							n3ptyArr[n3ptyArr.length]=new Array(sheetObject.GetCellValue(i,"n3pty_no") ,sheetObject.GetCellValue(i,"cfm_dt"));
  						}
  					}
  					if(n3ptyArr.length == 0){
  						ComShowMessage(ComGetMsg('COM12176','','',''));
  						return;
  					} else if(n3ptyArr.length > 0){
  						if( n3ptyArr.length == 1 ){
  							formObject.s_n3pty_no.value=n3ptyArr[0][0];
  							formObject.s_cfm_dt.value=n3ptyArr[0][1];
  							formObject.f_cmd.value="";
  							formObject.action="ESD_TPB_0028.do";
  							formObject.submit();
  						}else{
  							formObject.s_dao_n3pty_no.value=tpb_getN3ptyArr(n3ptyArr, "NO", "");
  							formObject.s_cfm_dt_prev.value=tpb_getN3ptyArr(n3ptyArr, "DATE", "PREV");
  							formObject.s_cfm_dt_last.value=tpb_getN3ptyArr(n3ptyArr, "DATE", "LAST");
  							formObject.f_cmd.value="";
  							formObject.action="ESD_TPB_0028.do";
  							formObject.submit();
  						}
  					}
  					break;
  			} // end switch
  		} catch(e) {			
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
  			    final_retrieve_querystrings=tpbFrmQryStr(formObj); /// on save end
  			    sheetObj.DoSearch("ESD_TPB_0107GS.do", tpbFrmQryStr(formObj) );
  				break;
  			case IBSAVE:		//Save
  				if(!validateForm(sheetObj,formObj,sAction)) {
  					return false;
  				}
  				formObj.f_cmd.value=MULTI;
  				sheetObj.DoSave("ESD_TPB_0107GS.do", tpbFrmQryStr(formObj));
  				break;
  			case IBINSERT:	   //Insert
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
  		with(formObj){
  			if(!ComChkValid(formObj)) return false;
  			if(document.all.period_class.className == "star"){
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
		if(errMsg==null && erMsg == ''){
			ComShowMessage(errMsg);
		} else {
    		//var temp = "";
    		for(var i=2; i<sheetObj.RowCount()+2; i++){
				n3pty_no_Array      [sheetObj.GetCellValue(i,"grp_srt_no").toString()]=sheetObj.GetCellValue(i,"n3pty_no");
				n3pty_expn_tp_cd_Array[sheetObj.GetCellValue(i,"grp_srt_no").toString()]=sheetObj.GetCellValue(i,"n3pty_expn_tp_cd");
				trd_party_code_Array[sheetObj.GetCellValue(i,"grp_srt_no").toString()]=sheetObj.GetCellValue(i,"trd_party_code");
				rev_vvd_Array       [sheetObj.GetCellValue(i,"grp_srt_no").toString()]=sheetObj.GetCellValue(i,"rev_vvd");
				cfm_curr_cd_Array   [sheetObj.GetCellValue(i,"grp_srt_no").toString()]=sheetObj.GetCellValue(i,"cfm_curr_cd");
    		}
		}
	}
	/**
  	 * Defined by DataSheetObject.prototype.event_OnSaveEnd
  	 */
  	function sheet1_OnSaveEnd(sheetObj,errMsg){
  		if(errMsg==null || errMsg == ''){
  			ComShowMessage(ComGetMsg('COM12149','Data'));
  			sheetObj.DoSearch("ESD_TPB_0107GS.do", final_retrieve_querystrings  );
  		}
  	}
  	function sheet1_OnChange(sheetObj,Row,Col,Value){
  		if ( sheetObj.ColSaveName(Col) == "grp_srt_no" ) {
  		    var n3pty_no_ToBe=n3pty_no_Array        [Value.toString()]; 
  		    var n3pty_expn_tp_cd_MustBe=n3pty_expn_tp_cd_Array[Value.toString()]; 
  		    var trd_party_code_MustBe=trd_party_code_Array  [Value.toString()]; 
  		    var rev_vvd_MustBe=rev_vvd_Array         [Value.toString()]; 
  		    var cfm_curr_cd_MustBe=cfm_curr_cd_Array     [Value.toString()]; 
  		    if ( n3pty_no_ToBe != undefined && n3pty_no_ToBe !=null && n3pty_no_ToBe.length==14 ){
  		    	if ( sheetObj.GetCellValue(Row,"n3pty_expn_tp_cd") != n3pty_expn_tp_cd_MustBe ) {
  		            ComShowMessage(ComGetMsg('TPB90065', 'Expense Type - Main'));
  		            sheetObj.SetCellValue(Row,"grp_srt_no",sheetObj.GetCellValue(Row,"grp_srt_no_org"),0);
  		            return;
  		        }		        
  		    	if ( sheetObj.GetCellValue(Row,"trd_party_code") != trd_party_code_MustBe ) {
  		            ComShowMessage(ComGetMsg('TPB90065', '3rd Party'));
  		            sheetObj.SetCellValue(Row,"grp_srt_no",sheetObj.GetCellValue(Row,"grp_srt_no_org"),0);
  		            return;
  		        }
  		    	if ( sheetObj.GetCellValue(Row,"rev_vvd") != rev_vvd_MustBe ) {
  		            ComShowMessage(ComGetMsg('TPB90065', 'Revenue VVD'));
  		            sheetObj.SetCellValue(Row,"grp_srt_no",sheetObj.GetCellValue(Row,"grp_srt_no_org"),0);
  		            return;
  		        }
  		    	if ( sheetObj.GetCellValue(Row,"cfm_curr_cd") != cfm_curr_cd_MustBe ) {
  		            ComShowMessage(ComGetMsg('TPB90065', 'Currency'));
  		            sheetObj.SetCellValue(Row,"grp_srt_no",sheetObj.GetCellValue(Row,"grp_srt_no_org"),0);
  		            return;
  		        }
         		    sheetObj.SetCellValue(Row,"n3pty_no",n3pty_no_ToBe,0);
         		    if ( sheetObj.GetCellValue(Row,"n3pty_no") == sheetObj.GetCellValue(Row,"n3pty_no_org") ){
         		    	sheetObj.SetCellValue(Row,"n3pty_no_dp_seq",sheetObj.GetCellValue(Row,"n3pty_no_dp_seq_org"),0);
         		    } else {
         		    	sheetObj.SetCellValue(Row,"n3pty_no_dp_seq","",0);
         		    }
              } else {
            	  if (sheetObj.GetCellValue(Row,"candidate_yn") == "N" || sheetObj.GetCellValue(Row,"roc_candidate_yn") == "N") {
						ComShowMessage(ComGetMsg('TPB90068', 'ROC-in'));
						sheetObj.SetCellValue(Row,"grp_srt_no",sheetObj.GetCellValue(Row,"grp_srt_no_org"),0);
					}else {
						sheetObj.SetCellValue(Row,"n3pty_no","",0);
						sheetObj.SetCellValue(Row,"n3pty_no_dp_seq","",0);
					}
              }
  		}
  	}
  	function sheet1_OnClick(sheetObj,Row,Col,Value){
  	}
  	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
  	}
  	function setSource(sObj){
  		var val=sObj.value;
  		if(sObj.type == 'radio'){
  			var obj=form.s_n3pty_src_sub_sys_cd;
  			for(i=0; i<obj.length; i++)	{
  				var compValue=obj[i].value;
  				  if(compValue == val)
  				   { 	
  						obj.selectedIndex=i 
  						break;
  				   }else{
  						obj.selectedIndex=0;
  				   }
  			}
  		}else if(sObj.type == 'select-one'){
  			var obj=form.s_n3pty_src_sub_sys_cd_check;
  			if(val == ''){
  				for(i=0; i<obj.length; i++)	{
  					obj[i].checked=false;
  				}
  			}else{
  				for(i=0; i<obj.length; i++)	{
  					var compValue=obj[i].value;
  					if(compValue  == val){
  						//obj[i].disabled = false;
  						obj[i].checked=true
  					}else{
  						//obj[i].disabled = true
  					}
  				}
  			}
  		}
  	}
  	function if_rhq_cd_OnChange(){
  		var f=document.form;
  		if(f.s_office_level.value == "H" || f.s_office_level.value == "R"){ //Head Office, RHQ
  			getTPBGenCombo('s_if_ofc_cd','searchHandleOfficeList','F','','11', new Array("s_if_rhq_cd","s_office_level"));
  		}else if(f.s_office_level.value == "G" || f.s_office_level.value == "T" || f.s_office_level.value == "C" || f.s_office_level.value == ""){ //General Office
  			//clear_Combo(f.s_if_ofc_cd);
  			ComClearCombo(f.s_if_ofc_cd);
  			//add_Combo(f.s_if_ofc_cd, f.s_ofc_cd_for_rhq.value, f.s_ofc_cd_for_rhq.value);
  			ComAddComboItem(f.s_if_ofc_cd, f.s_ofc_cd_for_rhq.value, f.s_ofc_cd_for_rhq.value);
  		}
  	}
  	function getCheckN3ptyNo(formObj, sheetObj){
  		var str='';
  		var otsCd=true;
  		var otsCdCnt=0;
  		if(sheetObj.RowCount()> 0){
  			var o=document.createElement("<input type='hidden' name='n3pty_no'>");
  			document.form.appendChild(o);
  			for ( var i=0; i <= sheetObj.RowCount(); i++ ){
  				if(sheetObj.GetRowStatus(i) == 'U'){
  					str += sheetObj.GetCellValue(i,'n3pty_no')+"|";
  					//Possible to passing data by settlement in case of ots_sts_cd - O,J,L,M
  					var ots=sheetObj.GetCellValue(i, "ots_sts_cd");
  					if(ots != 'O' && ots != 'J' && ots != 'L' && ots != 'M'){
  						otsCd=false;
  					}else{
  						otsCdCnt++;
  					}
  				}
  			}
  			document.form.n3pty_no.value=str;
  		}
  		if(str == ''){
  			ComShowMessage(getMsg('COM12176','','',''));
  		}
  		if(!otsCd){
  			ComShowMessage(getMsg('TPB90003','','',''));
  			if(otsCdCnt == 0) str='';
  		}
  		return str;
  	}
  	function s_n3pty_bil_tp_cd_OnChange(formObj){
  		var obj=document.form.s_n3pty_bil_tp_cd;
  		var str=obj.value;
  		if(str != '' || get_Combo(obj) == 'ALL'){
  			document.form.s_edn_tp_cd.value="";
  			document.form.s_edn_tp_cd.disabled=true;
  		}else{
  			document.form.s_edn_tp_cd.disabled=false;
  		}
  	}
  	function tpb_searchBillingCaseByExpenseType(){
  		getTPBGenCombo('s_n3pty_bil_tp_cd','searchBillingCaseByExpenseType','F','','2',new Array("s_n3pty_src_sub_sys_cd"));
  		var obj=document.form.s_n3pty_src_sub_sys_cd;
  		var str=obj.value;
  		if(str != '' || get_Combo(obj) == 'ALL'){
  			document.form.s_edn_tp_cd.disabled=false;
  		}else{
  			document.form.s_edn_tp_cd.disabled=true;
  		}
  	}
  	function tpb_getN3ptyArr(arr, gubun, type){
  		var str="";
  		var dateArr=new Array();
  		var otsCdCnt=0;
  		for ( var i=0; i < arr.length; i++ ){
  			if(gubun.toUpperCase() == 'NO'){
  				str += arr[i][0]+",";
  			}else if(gubun.toUpperCase() == 'DATE'){
  				dateArr[dateArr.length]=arr[i][1];
  			}
  		}
  		if(gubun.toUpperCase() == "DATE"){
  			dateArr=dateArr.sort();
  			if(type.toUpperCase() == "PREV") str=dateArr[0];
  			else if (type.toUpperCase() == "LAST") str=dateArr[dateArr.length-1];
  		}
  		return str;
  	}
  	function tpb_equal_n3ptyNo(n3ptyArr, sheetObj){
  		var rtn=true;
  		for(var i=0;i<n3ptyArr.length;i++){
  			var dbl=0;
  			for(var j=0;j<n3ptyArr.length;j++){
  				if(n3ptyArr[i][0] != n3ptyArr[j][0]){
  					continue;
  				}else{
  					dbl++;
  					if(dbl>1){
  						n3ptyArr.splice(j,1);
  						j--;
  					}
  				}
  			}
  		}
  		if(n3ptyArr.length > 1){
  			ComShowMessage(getMsg('COM12113','3rd Party No','',''));
  			rtn=false;
  		}
  		return rtn;
  	}
  	function checkPeriod(val){
  		if(val == "T"){ //TPB
  			document.all.s_sdate.disabled=true;
  			document.all.s_edate.disabled=true;
  			document.all.btns_calendar2.disabled=true;
  			document.all.period_class.className="nostar";
  			document.all.s_ots_sts_cd_detail_open.style.display='';
  			document.all.s_ots_sts_cd_detail_close.style.display='none';
  		}else{
  			document.all.s_sdate.disabled=false;
  			document.all.s_edate.disabled=false;
  			document.all.btns_calendar2.disabled=false;
  			document.all.period_class.className="star";
  			document.all.s_ots_sts_cd_detail_open.style.display='none';
  			document.all.s_ots_sts_cd_detail_close.style.display='';
  		}
  	}
  	function tpb_searchBillingCaseByExpenseType(){
  		getTPBGenCombo('s_n3pty_bil_tp_cd','searchBillingCaseByExpenseType','F','','2',new Array("s_n3pty_src_sub_sys_cd"));
  	}
	/* Finishing work */