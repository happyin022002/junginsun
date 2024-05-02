/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0113.js
*@FileTitle  : Response Office Change 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/25
=========================================================
*/

/****************************************************************************************
  Event code : 	INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    			MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
  OTHER CASE : 	COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class ESD_TPB_0113 : business script for ESD_TPB_0113
 */
   
    /* Global Variables */
	var sheetObjects=new Array();
	var sheetCnt=0;
	var final_retrieve_querystrings="";
	/* Event handler defined process to button click event */
	document.onclick=processButtonClick;
	/* Event handler is branch processing by name of button */
	function processButtonClick(){
		if(ComGetEvent("name") == "c_date_kind_flag"){
			if(window.event.srcElement.getAttribute("value") == "R"){
				document.all.date_type.value="Confirmed Date";
				document.all.s_date_kind_flag.value="R";
			}else if(window.event.srcElement.getAttribute("value") == "I"){
				document.all.date_type.value="ROC Request Date";
				document.all.s_date_kind_flag.value="I";
			}
		}	
		/***** Assignment sheet in case of over 2 by tab *****/
		var sheetObject=sheetObjects[0];
		/*******************************************************/
		var formObj=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObj,IBSEARCH);
					break;
				case "btn_new":
					formObj.reset();
					document.form.s_calendar_date1.value=ComGetDateAdd(null, "D", -6, "-");
					document.form.s_calendar_date2.value=ComGetDateAdd(null, "D", 0, "-");
					//sheetObject.RemoveAll();
					break;
				case "btn_save":
					doActionIBSheet(sheetObject,formObj,IBSAVE);
					//doActionIBSheet(sheetObject,formObj,IBSEARCH);
					break;
				case "btn_cancel":
					doActionIBSheet(sheetObject,formObj,REMOVELIST);
					break;
				case "btn_downexcel":
					if(sheetObject.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
	        	    } else{
	        	    	doActionIBSheet(sheetObject,formObj,IBDOWNEXCEL);
	        	    } 
					break;		
				case "btng_detail":
					break;
				case "btn_3rdParty":
				    get3rdPartyToSearch( formObj.s_vndr_cust_div_cd.value ); 
					break;
  				case "btns_calendar1":
  					var cal=new ComCalendar();
  					cal.displayType="date";
  					cal.select(formObj.s_calendar_date1, 'yyyy-MM-dd');
  					break;
  				case "btns_calendar2":
  					var cal=new ComCalendarFromTo();
  					cal.displayType="date";
  					cal.select(formObj.s_calendar_date1, formObj.s_calendar_date2,'yyyy-MM-dd');
  					break;
				case "btn_rocto":
				    openRocToOfficePopup(); 
					break;
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(ComGetMsg("TPB90014"));
			} else {
				ComShowMessage(e.message);
			}
		}
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
	function loadPage(n3pty_no_strs) {
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
//		document.form.s_date_flag_r.onchange=date_flag_OnChange
//		document.form.s_date_flag_i.onchange=date_flag_OnChange
		document.form.s_calendar_date1.value=ComGetDateAdd(null, "D", -6, "-");
		document.form.s_calendar_date2.value=ComGetDateAdd(null, "D", 0, "-");
//		document.form.s_trd_party_val.onfocus=s_trd_party_val_OnFocus;
		document.form.s_n3pty_no_strs.value=n3pty_no_strs;
		if ( n3pty_no_strs.length > 0 ){
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}
//		document.form.s_vndr_cust_div_cd.onchange=s_trd_party_val_OnFocus;
//		document.form.s_trd_party_val.onfocus=s_trd_party_val_OnFocus;
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
			if_rhq_cd_OnChange(); //  Setting Control Office ComboBox and  TPB Office ComboBox
			if_ctrl_cd_OnChange(); // Setting TPB Office ComboBox
		}
//		document.form.s_if_rhq_cd.onchange=if_rhq_cd_OnChange;
//		document.form.s_if_ctrl_cd.onchange=if_ctrl_cd_OnChange;
		if ( document.form.s_n3pty_no_strs_link.value.length >= 14) {
		    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}
	}
	/**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetNo) {
			case 1 :      //sheet1 init
			    with(sheetObj){
				      var HeadTitle="Cancel|STS|approval|Request|Accept|Reject|Res.Office|TPB No.|Req.Date|Req.Office|Req.ID|App.Date|App.Office|App.ID|Rej.Date|Rej.Office|Rej.ID|Exp.Type|Invoice No.||ROC Status|BKG No.|B/L No.|EQ No.|RHQ|Office|3rd Party|Currency|Confirmed Amount|Confirmed Date|Invoice|AR I/F|Approval|Balance|Request|Activity|ROC Date|Review Step|Sts Seq";
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"DelCheck",  Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"",                       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"approval",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"CheckBox",  Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"chk_req",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:false },
				             {Type:"CheckBox",  Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"chk_app",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:false },
				             {Type:"CheckBox",  Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"chk_rej",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:false },
				             {Type:"PopupEdit", Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"stl_to_clt_cng_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 },
				             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"req_date",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"req_ofc",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"req_id",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"app_date",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"app_ofc",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"app_id",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rej_date",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rej_ofc",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rej_id",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"n3pty_src_sub_sys_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_inv_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ots_sts_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"ots_sts_cd_val",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"eq_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"if_rhq_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"if_ofc_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"n3pty",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:"ots_amt",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cfm_dt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"inv_amt",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"clt_amt",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"stl_amt",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"bal_amt",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"stl_clt_ofc_cng_amt",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Image",     Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:"clt_act_yn",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"stl_rqst_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"review_step",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"adj_sts_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				      InitColumns(cols);
				      SetEditable(1);
				      SetImageList(0,"/opuscntr/img/button/btng_collectionactivity.gif");
				      SetImageList(1,"/opuscntr/img/button/btng_collectionactivity_yellow.gif");
				      SetColHidden(0,1);
				      SetColHidden("ots_sts_cd",1);
				      SetColHidden("chk_req",1);
				      SetColHidden("chk_app",1);
				      SetColHidden("chk_rej",1);
				      SetColHidden("ibflag",1);
				      SetDataLinkMouse("clt_act_yn",1);
				      SetDataLinkMouse(true);
				      //SetSheetHeight(350);
				      ComResizeSheet(sheetObjects[0]);

				      SetColProperty(0 ,"stl_to_clt_cng_ofc_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});				      
			      }
				break;
		}
	}
	/* Processing Sheet */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBSEARCH:      //Retrieve
				var s_date_flag_r=document.form.s_date_flag_r.value;	
				if(document.form.s_date_kind_flag.value=="R"){
					formObj.f_cmd.value=SEARCH;
				}else if(document.form.s_date_kind_flag.value=="I"){
					formObj.f_cmd.value=SEARCHLIST;
				}
				final_retrieve_querystrings=tpbFrmQryStr(formObj); 
				sheetObj.DoSearch("ESD_TPB_0113GS.do", final_retrieve_querystrings  );
				break;
			case REMOVELIST:
				formObj.f_cmd.value=REMOVE;
				sheetObj.DoSave("ESD_TPB_0113GS.do", tpbFrmQryStr(formObj));
				formObj.f_cmd.value=SEARCHLIST;
				final_retrieve_querystrings=tpbFrmQryStr(formObj); 
				sheetObj.DoSearch("ESD_TPB_0113GS.do", final_retrieve_querystrings  );
				break;
			case IBSAVE:        //Save
				if( sheetObj.CheckedRows('chk_req') < 1 && sheetObj.CheckedRows('chk_app') < 1 && sheetObj.CheckedRows('chk_rej') < 1){
					ComShowCodeMessage("TPB90080");
					break;					
				}
				if( curr_action == "REQUEST" ){
					var bugs="";
					for( var i=1 ; i<sheetObj.RowCount()+1 ; i++ ){
						if(sheetObj.GetRowStatus(i) != 'R'){
							if(sheetObj.GetCellValue(i,"chk_req")==0||sheetObj.GetCellValue(i,"stl_to_clt_cng_ofc_cd")==""){
								if(bugs!=""){bugs += ",";}
								bugs += i;
							}
						}
					}
					if( bugs != "" ){
						ComShowCodeMessage("TPB90096", bugs);
						return;
					}
				}
        		document.form.s_file_no.value="";
        		document.form.s_ra_rmk1.value="";
        		document.form.s_ra_rmk2.value="";
				if( curr_action == "REQUEST" ){
					formObj.f_cmd.value=MULTI01;	// ROC Request -> Create ROC
					var reasonCheckResult=openReasonToSavePopup();
				}else if( curr_action == "APPROVAL" ){
					formObj.f_cmd.value=MULTI02;	// ROC Approve-Reject -> Modify ROC
					var reasonCheckResult=openReviewResultPopup();
				}
				
				break;
			case IBDOWNEXCEL:        //Excel download
				sheetObj.Down2Excel(TPBDown2ExcelOptions);
				break;
		}
	}
	/**
	 * Checking validation of input value
	 */
	function validateForm(sheetObj,formObj,sAction){
		if ( formObj.n3pty_stl_tp_cd.value.length == 0 ){
			ComShowMessage(ComGetMsg("TPB90077", 'Adjustment Type'));
			return false;
		}
		formObj.stl_to_clt_cng_ofc_cd.value=ComTrim(formObj.stl_to_clt_cng_ofc_cd.value);
		if ( formObj.n3pty_stl_tp_cd.value == "O" && formObj.stl_to_clt_cng_ofc_cd.value.length < 5 ){ /// R.O.C To 
			ComShowMessage(ComGetMsg("TPB90078", 'R.O.C To'));
			formObj.btn_rocto.style.display="";
			formObj.stl_to_clt_cng_ofc_cd.select();
			return false;
		}
		var chk_req=0; 
		var roc_amt=0;
		var ots_amt=0;
		var svr_id_valid_yn="";  // For MNR svr_id must be valid
		if ( formObj.n3pty_stl_tp_cd.value == "O" ){
			for(i=1;i<=sheetObjects[0].RowCount(); i++) {
				chk_req=sheetObjects[0].GetCellValue(i, "chk_req");
				roc_amt=sheetObjects[0].GetCellValue(i, "stl_clt_ofc_cng_amt");
				ots_amt=sheetObjects[0].GetCellValue(i, "ots_amt");
				svr_id_valid_yn=sheetObjects[0].GetCellValue(i, "svr_id_valid_yn");
				if ( chk_req==1 && (roc_amt <= 0.0 || roc_amt - ots_amt > 0) ) {
					ComShowMessage(ComGetMsg("TPB90078", 'R.O.C AMT'));
					sheetObjects[0].SelectCell(i, "stl_clt_ofc_cng_amt");
					return false; 
				}
			}
		}
		return true;
	}
	/**
	 * sheet1 on click event
	 */
	function sheet1_OnClick(sheetObj, Row,Col){ 
		//Calling pop-up in case of Collection Activity button clicking
		var colNm=sheetObj.ColSaveName(Col);
		if ( colNm == "clt_act_yn" ) { 
			var r_n3pty_no=sheetObj.GetCellValue(Row, "n3pty_no");
			var r_n3pty_inv_no=sheetObj.GetCellValue(Row, "n3pty_inv_no");
			openRecoveryActPopup(r_n3pty_no,r_n3pty_inv_no,'','N');
		}
		if( colNm == "chk_app" || colNm == "chk_rej" ){
			//sheetObj.CheckAll("chk_app",false,1);
			//sheetObj.CheckAll("chk_rej",false,1);
			//sheetObj.CheckAll("chk_req",false,1);
			if( colNm == "chk_app" ) {
				sheetObj.SetCellValue(Row, 'chk_rej','N');
			}
			else if( colNm == "chk_rej" ) {	
				sheetObj.SetCellValue(Row, 'chk_app','N');
			}
			
		}
	}
	
	/**
	 * sheet1 on BeforeCheckAll event
	 */
	function sheet1_OnBeforeCheckAll(sheetObj) {
		sheetObj.SetHeaderCheck(0,'chk_app',0);
		sheetObj.SetHeaderCheck(0,'chk_rej',0);
		sheetObj.CheckAll('chk_app', 0, 0);
		sheetObj.CheckAll('chk_rej', 0, 0);
	}
	
	/**
  	 * Defined by DataSheetObject.prototype.event_OnChange
  	 */
	function sheet1_OnChange(sheetObj, Row, Col, Value){
		_sheet_onchange( sheetObj,Row,Col,Value );
		var colNm=sheetObj.ColSaveName(Col);
		if( colNm=='chk_req' ){
			if( sheetObj.GetCellValue( Row, 'stl_to_clt_cng_ofc_cd')=='' ){
				sheetObj.SetRowStatus( Row ,'R');
			}
		}
		// 3rd Party Input directly ...
		if(colNm == 'stl_to_clt_cng_ofc_cd'){
			var stl_to_clt_cng_ofc_cd=sheetObj.GetCellValue(Row, "stl_to_clt_cng_ofc_cd");
			stl_to_clt_cng_ofc_cd=ComTrim(stl_to_clt_cng_ofc_cd).toUpperCase(); // TRIM & UPPER CASE 
			sheetObj.SetCellValue(Row, "stl_to_clt_cng_ofc_cd",stl_to_clt_cng_ofc_cd,0);
            if ( stl_to_clt_cng_ofc_cd.length == 0 ){
            	//in case of empty 3rd party value 
            } else { //Checking in case of not empty 3rd party value  
            	if(stl_to_clt_cng_ofc_cd == document.form.s_user_ofc_cd.value){
					sheetObj.SetCellValue(Row, "stl_to_clt_cng_ofc_cd","",0);
					sheetObj.SelectCell(Row, Col, false);
					ComShowMessage(ComGetMsg("TPB90103"));
					sheetObj.SetFocusEditMode(-1);
					return ;
            	} else{
					var f="";
					var ifr="frame_"+f.length;
					var o=document.createElement("DIV");
					o.style.display="none";
					o.innerHTML='<iframe name="'+ifr+'" scrolling="no" frameborder="0" width="0" height="0"></iframe>';
					document.body.appendChild(o);
					eval(ifr + ".document").location.href  ="TPBCommonCode.do?mode=T&id=stl_to_clt_cng_ofc_cd&method=checkTPBOffice&stl_to_clt_cng_ofc_cd="+stl_to_clt_cng_ofc_cd + "&otherObjs=" + Row ;
                }
            }
		}
		var val=document.form.n3pty_stl_tp_cd.value; // C / D / O / W  // O, L, J, K, M 
		var ots_sts_cd="";
		if ( sheetObj.ColSaveName(Col) == "chk_req" ) {  // chk_req on checking or unchecking
			if ( Value == 0 ) { // on unckecking 
				sheetObj.SetCellValue(Row, "stl_clt_ofc_cng_amt","",0);
			} else { // on checking
				ots_sts_cd=sheetObj.GetCellValue(Row, "ots_sts_cd");
				if ( val == "C" || val == "D" ) { //  L, K 
					if ( ots_sts_cd == "L" || ots_sts_cd == "K" ) {
						sheetObj.SetCellValue(Row, "stl_clt_ofc_cng_amt",sheetObj.GetCellValue(Row, "bal_amt"),0);
					} else {
						ComShowMessage(ComGetMsg("TPB90022", sheetObj.GetCellValue(Row, "n3pty_no")));
						sheetObj.SetCellValue(Row, "chk_req",0,0);
					} 
				} else if ( val == "O" || val == "W" ) { // O, J, M 
					if ( ots_sts_cd == "O" || ots_sts_cd == "J" || ots_sts_cd == "M" ) {
						sheetObj.SetCellValue(Row, "stl_clt_ofc_cng_amt",sheetObj.GetCellValue(Row, "bal_amt"),0);
					} else {
						ComShowMessage(ComGetMsg("TPB90022", sheetObj.GetCellValue(Row, "n3pty_no")));
						sheetObj.SetCellValue(Row, "stl_clt_ofc_cng_amt","",0);
						sheetObj.SetCellValue(Row, "chk_req",0,0);
					} 
				} else { // none selected
					sheetObj.SetCellValue(Row, "stl_clt_ofc_cng_amt",sheetObj.GetCellValue(Row, "bal_amt"),0);
				}
			}
		} else if ( sheetObj.ColSaveName(Col) == "stl_clt_ofc_cng_amt" ) { // request amount on changing
			if ( Value != "" ) {
				sheetObj.SetCellValue(Row, "chk_req",1,0);
			} else {
				sheetObj.SetCellValue(Row, "chk_req",0,0);
			}
		} 
	}//OnChange
	/**
     * handling process after ending sheet1 retrieve
     */
	var curr_action="";
	function sheet1_OnSearchEnd(sheetObj,errMsg){
		//Initializing condition
		document.form.s_ra_rmk1.value='';
		document.form.s_ra_rmk2.value='';
		var s_date_kind_flag=document.form.s_date_kind_flag.value;
		var s_date_flag_r=document.form.s_date_flag_r.value;
		var s_date_flag_i=document.form.s_date_flag_i.value;
		if( s_date_kind_flag == "R" ){
			if(s_date_flag_r == "IN"){
				curr_action="APPROVAL";
			}else if(s_date_flag_r == "OT"){
				curr_action="REQUEST";
			}
			for( var i=sheetObj.RowCount(); i > 0 ; i-- ){
				//Changing IBSheet column in s_date_kind_flag
				if( s_date_flag_r == "AL" ){
					sheetObj.SetCellEditable(i,"stl_to_clt_cng_ofc_cd",0);
					sheetObj.SetCellBackColor(i,"stl_to_clt_cng_ofc_cd",sheetObj.GetCellBackColor(i,"n3pty_no"));
				}else if( s_date_flag_r == "IN" ){
					if( sheetObj.GetCellValue(i,"approval") == 'Y' ){
						sheetObj.SetCellEditable(i,"chk_app",1);
						sheetObj.SetCellEditable(i,"chk_rej",1);
						sheetObj.SetCellEditable(i,"stl_to_clt_cng_ofc_cd",0);
						sheetObj.SetCellBackColor(i,"ibflag",sheetObj.GetCellBackColor(i,"n3pty_no"));
					}else{
						//Activating in case of review_step = login id
						if( sheetObj.GetCellValue(i,"review_step") == document.form.s_user_ofc_cd.value ){
							sheetObj.SetCellEditable(i,"chk_app",1);
							sheetObj.SetCellEditable(i,"chk_rej",1);
							sheetObj.SetCellEditable(i,"stl_to_clt_cng_ofc_cd",0);
							sheetObj.SetCellBackColor(i,"ibflag",sheetObj.GetCellBackColor(i,"n3pty_no"));
						}
					}
					//Processing authority approve/reject by 'S' authority
					if( document.form.s_office_level.value == "R" &&
							document.form.s_rhq_cd_for_rhq.value == sheetObj.GetCellValue(i,"review_step")){
						sheetObj.SetCellEditable(i,"chk_rej",1);
						sheetObj.SetCellEditable(i,"chk_app",1);
					}
				}else if( s_date_flag_r == "OT" ){
					sheetObj.SetCellEditable(i,"stl_to_clt_cng_ofc_cd",1);
					sheetObj.SetCellEditable(i,"chk_req",1);
					sheetObj.SetCellBackColor(i,"ibflag",sheetObj.GetCellBackColor(i,"n3pty_no"));
				}
				if( document.form.s_office_level.value == "T" || document.form.priv_cd.value == "T"){
					if( curr_action == "APPROVAL" ){
						if( document.form.s_user_ofc_cd.value != sheetObj.GetCellValue(i,"review_step") || sheetObj.GetCellValue(i,"review_step") == "" ){
							sheetObj.SetCellEditable(i,"chk_req",0);
							sheetObj.SetCellEditable(i,"chk_rej",0);
							sheetObj.SetCellEditable(i,"chk_app",0);
							sheetObj.SetCellBackColor(i,"chk_rej",sheetObj.GetCellBackColor(i,"n3pty_no"));
							sheetObj.SetCellBackColor(i,"chk_app",sheetObj.GetCellBackColor(i,"n3pty_no"));
						}
					}else if( curr_action == "REQUEST" ){
						if( document.form.s_user_ofc_cd.value != sheetObj.GetCellValue(i,"if_ofc_cd") ){
							sheetObj.SetCellEditable(i,"chk_req",0);
						}
					}
				}
				//Preventing Request of RHQ
				if( document.form.s_office_level.value == "R" ){
					sheetObj.SetCellEditable(i,"stl_to_clt_cng_ofc_cd",0);
					sheetObj.SetCellEditable(i,"chk_req",0);
					sheetObj.SetCellBackColor(i,"stl_to_clt_cng_ofc_cd",sheetObj.GetCellBackColor(i,"n3pty_no"));
					sheetObj.SetCellBackColor(i,"chk_req",sheetObj.GetCellBackColor(i,"n3pty_no"));
					//Showing only request of 'R' authority in case of ROC-IN retrieving
					if( sheetObj.GetCellValue(i,"review_step")!= document.form.s_rhq_cd_for_rhq.value ){
						if( document.form.s_rhq_cd_for_rhq.value == "N" ){
							//sheetObj.RowHidden(i) = true;
							sheetObj.RowDelete(i,false);
						}
					}
				}else if(document.form.s_office_level.value == "H" ){
					//Showing only request of 'H' authority in case of ROC-IN retrieving
					if( sheetObj.GetCellValue(i,"review_step")!= document.form.s_user_ofc_cd.value ){
						//sheetObj.RowHidden(i) = true;
						sheetObj.RowDelete(i,false);
					}
				} 
			}//for
			document.form.btn_cancel.style.display="none";
			document.form.btn_cancel.style.display="none";
			document.form.btn_cancel_right.style.display="none";
		} else if( s_date_kind_flag == "I" ){
			for( var i=1 ; i<sheetObj.RowCount()+1 ; i++ ){
				sheetObj.SetCellEditable(i,"stl_to_clt_cng_ofc_cd",0);
			}
			sheetObj.SetColHidden("chk_req",1);
			sheetObj.SetColHidden("chk_rej",1);
			sheetObj.SetColHidden("chk_app",1);
			sheetObj.SetColHidden("ibflag",1);
			if(s_date_flag_i=="OL"){
				//Possible to cancelling only TPB Office
				if( document.form.s_office_level.value == 'T' || document.form.priv_cd.value == 'T' ){
					document.all.btn_cancel_left.style.display="";
					document.form.btn_cancel.style.display="";
					document.form.btn_cancel_right.style.display="";
					sheetObj.SetColHidden(0,0);
				}else{
					document.all.btn_cancel_left.style.display="none";
					document.form.btn_cancel.style.display="none";
					document.form.btn_cancel_right.style.display="none";
					sheetObj.SetColHidden(0,1);
				}
				for( var i=1 ; i<sheetObj.RowCount()+1 ; i++ ){
					if( sheetObj.GetCellValue(i,"ots_sts_cd_val") == "Requested" && sheetObj.GetCellValue(i,"if_ofc_cd") == document.form.s_user_ofc_cd.value ){
						sheetObj.SetCellEditable(i,0,1);
						sheetObj.SetCellBackColor(i,0,"#000000");
					}else{
						sheetObj.SetCellBackColor(i,0,sheetObj.GetCellBackColor(i,"n3pty_no"));
					}
				}//for
			}else{
				document.all.btn_cancel_left.style.display="none";
				document.form.btn_cancel.style.display="none";
				document.form.btn_cancel_right.style.display="none";
				sheetObj.SetColHidden(0,1);
			}
		}
		//Hidden
		if( s_date_kind_flag == "R" ){
			if(s_date_flag_r == "AL"){
				sheetObj.SetColHidden("stl_to_clt_cng_ofc_cd",0);
				sheetObj.SetColHidden("chk_req",1);
				sheetObj.SetColHidden("chk_app",1);
				sheetObj.SetColHidden("chk_rej",1);
				sheetObj.SetColHidden("ibflag",1);
				sheetObj.SetColHidden(0,1);
			}else if(s_date_flag_r == "IN" ){
				sheetObj.SetColHidden("chk_rej",0);
				sheetObj.SetColHidden("chk_app",0);
				sheetObj.SetColHidden("chk_req",1);
				sheetObj.SetColHidden("ibflag",0);
				sheetObj.SetColHidden(0,1);
				if( document.form.s_office_level.value == "R" &&
						document.form.s_rhq_cd_for_rhq.value == sheetObj.GetCellValue(i,"review_step")){
					sheetObj.SetColHidden("chk_rej",0);
					sheetObj.SetColHidden("chk_app",0);
				}
			} else if(s_date_flag_r == "OT" ){
				if( document.form.s_office_level.value == 'T' || document.form.priv_cd.value == 'T' ){
					sheetObj.SetColHidden("chk_req",0);
				}else{
					sheetObj.SetColHidden("chk_req",1);
				}
				sheetObj.SetColHidden("chk_rej",1);
				sheetObj.SetColHidden("chk_app",1);
				sheetObj.SetColHidden("ibflag",0);
				sheetObj.SetColHidden(0,1);
				sheetObj.SetColHidden("stl_to_clt_cng_ofc_cd",0);
			}
		}else if( s_date_kind_flag == "I" ){
		}
	}
	/**
  	 * Defined by DataSheetObject.prototype.event_OnSaveEnd
  	 */
	function sheet1_OnSaveEnd(sheetObj,errMsg){
		//Initializing condigion
		document.form.s_ra_rmk1.value='';
		document.form.s_ra_rmk2.value='';
		var s_date_kind_flag=document.form.s_date_kind_flag.value;
		var s_date_flag_r=document.form.s_date_flag_r.value;
		var s_date_flag_i=document.form.s_date_flag_i.value;
		if( s_date_kind_flag == "R" ){
			//Saving in curr_action
			if(s_date_flag_r == "IN"){
				curr_action="APPROVAL";
			}else if(s_date_flag_r == "OT"){
				curr_action="REQUEST";
			}
			for( var i=1 ; i<sheetObj.RowCount()+1 ; i++ ){
				//Changing IBSheet column by s_date_kind_flag
				if( s_date_flag_r == "AL" ){
					sheetObj.SetCellEditable(i,"stl_to_clt_cng_ofc_cd",0);
					sheetObj.SetCellBackColor(i,"stl_to_clt_cng_ofc_cd",sheetObj.GetCellBackColor(i,"n3pty_no"));
				}else if( s_date_flag_r == "IN" ){
					if( sheetObj.GetCellValue(i,"approval") == 'Y' ){
						sheetObj.SetCellEditable(i,"chk_app",1);
						sheetObj.SetCellEditable(i,"chk_rej",1);
						sheetObj.SetCellEditable(i,"stl_to_clt_cng_ofc_cd",0);
						sheetObj.SetCellBackColor(i,"ibflag",sheetObj.GetCellBackColor(i,"n3pty_no"));
					}
					//Processing approve/reject authority of 'S' authority
					if( document.form.s_office_level.value == "R" &&
							document.form.s_rhq_cd_for_rhq.value == sheetObj.GetCellValue(i,"review_step")){
						sheetObj.SetCellEditable(i,"chk_rej",1);
						sheetObj.SetCellEditable(i,"chk_app",1);
					}
				} else if( s_date_flag_r == "OT" ){
					sheetObj.SetCellEditable(i,"stl_to_clt_cng_ofc_cd",1);
					sheetObj.SetCellEditable(i,"chk_req",1);
					sheetObj.SetCellBackColor(i,"ibflag",sheetObj.GetCellBackColor(i,"n3pty_no"));
				}
				//Possible to controlling only self office in case of s_date_flag_kind = 'R'
				if( document.form.s_office_level.value == "T" ){
					if( document.form.s_user_ofc_cd.value != sheetObj.GetCellValue(i,"review_step") || sheetObj.GetCellValue(i,"review_step") == "" ){
						if(curr_action == "REQUEST"){
							sheetObj.SetCellEditable(i,"chk_req",1);
						}else{
							sheetObj.SetCellEditable(i,"chk_req",0);
							sheetObj.SetCellBackColor(i,"chk_req",sheetObj.GetCellBackColor(i,"n3pty_no"));
						}
						sheetObj.SetCellEditable(i,"chk_rej",0);
						sheetObj.SetCellEditable(i,"chk_app",0);
						sheetObj.SetCellBackColor(i,"chk_rej",sheetObj.GetCellBackColor(i,"n3pty_no"));
						sheetObj.SetCellBackColor(i,"chk_app",sheetObj.GetCellBackColor(i,"n3pty_no"));
					}
				}
				//Preventing Request of RHQ
				if( document.form.s_office_level.value == "R" ){
					sheetObj.SetCellEditable(i,"stl_to_clt_cng_ofc_cd",0);
					sheetObj.SetCellEditable(i,"chk_req",0);
					sheetObj.SetCellBackColor(i,"stl_to_clt_cng_ofc_cd",sheetObj.GetCellBackColor(i,"n3pty_no"));
					sheetObj.SetCellBackColor(i,"chk_req",sheetObj.GetCellBackColor(i,"n3pty_no"));
				}
			}//for
			document.form.btn_cancel_left.style.display="none";
			document.form.btn_cancel.style.display="none";
			document.form.btn_cancel_right.style.display="none";
		} else if( s_date_kind_flag == "I" ){
			for( var i=1 ; i<sheetObj.RowCount()+1 ; i++ ){
				sheetObj.SetCellEditable(i,"stl_to_clt_cng_ofc_cd",0);
			}
			sheetObj.SetColHidden("chk_req",1);
			sheetObj.SetColHidden("chk_rej",1);
			sheetObj.SetColHidden("chk_app",1);
			sheetObj.SetColHidden("ibflag",1);
			if(s_date_flag_i=="OL"){
				document.form.btn_cancel_left.style.display="";
				document.form.btn_cancel.style.display="";
				document.form.btn_cancel_right.style.display="";
				sheetObj.SetColHidden(0,0);
				for( var i=1 ; i<sheetObj.RowCount()+1 ; i++ ){
					if( sheetObj.GetCellValue(i,"ots_sts_cd_val") != "Requested"){
						sheetObj.SetCellEditable(i,0,0);
						sheetObj.SetCellBackColor(i,0,sheetObj.GetCellBackColor(i,"n3pty_no"));
					}
				}//for
			} else{
				document.form.btn_cancel_left.style.display="none";
				document.form.btn_cancel.style.display="none";
				document.form.btn_cancel_right.style.display="none";
				sheetObj.SetColHidden(0,1);
			}
		}
		for( var i=1 ; i<sheetObj.RowCount()+1 ; i++ ){
			sheetObj.SetCellAlign(i,"chk_app","Center");
			sheetObj.SetCellAlign(i,"chk_rej","Center");
			sheetObj.SetCellAlign(i,"chk_req","Center");
			sheetObj.SetCellAlign(i,0,"Center");
		}
		if(errMsg==null || errMsg == ''){
			ComShowMessage(ComGetMsg("TPB90075", 'Data'));
			//sheetObj.DoSearch("ESD_TPB_0113GS.do", final_retrieve_querystrings ); /// sheet data reload
		}
		
		doActionIBSheet(sheetObj,document.form,IBSEARCH);
	}
	function date_flag_OnChange(){
		var sheetObj=sheetObjects[0];
		if( ComGetEvent("name")=="s_date_flag_r" &&
			document.form.s_date_kind_flag.value=="R"){
			document.form.btn_cancel_left.style.display="none";
			document.form.btn_cancel.style.display="none";
			document.form.btn_cancel_right.style.display="none";
			sheetObj.RemoveAll();
		}else if( ComGetEvent("name")=="s_date_flag_i" &&
			document.form.s_date_kind_flag.value=="I"){
			document.form.btn_cancel_left.style.display="none";
			document.form.btn_cancel.style.display="none";
			document.form.btn_cancel_right.style.display="none";
			sheetObj.RemoveAll();
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
			ComClearCombo(f.s_if_ofc_cd);
			getTPBGenCombo('s_if_ofc_cd','searchTPBOfficeList','F','','2', new Array("s_if_ctrl_cd","s_office_level"));
		} else if(f.s_office_level.value == "C"){ //CTRL
			getTPBGenCombo('s_if_ofc_cd','searchTPBOfficeList','F','','2', new Array("s_if_ctrl_cd","s_office_level"));
		}else if(f.s_office_level.value == "T" || f.s_office_level.value == ""){ //General Office
			ComClearCombo(f.s_if_ofc_cd);
			ComAddComboItem(f.s_if_ofc_cd, f.s_ofc_cd_for_rhq.value, f.s_ofc_cd_for_rhq.value);
		}
	}
	/// R.O.C-To-Office Validation Check
	function stl_to_clt_cng_ofc_cd_OnBlur(){
		var user_ofc_cd=document.form.s_user_ofc_cd.value;
	    var stl_to_clt_cng_ofc_cd=document.form.stl_to_clt_cng_ofc_cd.value;
		if ( stl_to_clt_cng_ofc_cd!="" && stl_to_clt_cng_ofc_cd == user_ofc_cd ){
		    document.form.stl_to_clt_cng_ofc_cd.value="";
		    ComShowMessage(ComGetMsg("TPB90051"));
		    return ; 
		}
		checkROCToOffice(document.form, document.form.stl_to_clt_cng_ofc_cd);
	}
    function openRocToOfficePopup(){
    	var theURL="ESD_TPB_0804.do&title=Res.Office";
        // ComShowMessage( theURL );
    	var features="scroll:no;status:no;help:no;dialogWidth:470px;dialogHeight:450px";
    	var rtnValue =  ComOpenWindow(theURL,  window,  features , true);
    	if(rtnValue != undefined && rtnValue != null ){
    		document.form.stl_to_clt_cng_ofc_cd.value=rtnValue;
    	}
	    var user_ofc_cd=document.form.s_user_ofc_cd.value;
	    var stl_to_clt_cng_ofc_cd=document.form.stl_to_clt_cng_ofc_cd.value;
		if ( stl_to_clt_cng_ofc_cd!="" && stl_to_clt_cng_ofc_cd == user_ofc_cd ){
		    document.form.stl_to_clt_cng_ofc_cd.value="";
		    ComShowMessage(ComGetMsg("TPB90051"));
		    return ; 
		}
    }	
    function callback0804(rtnValue){
    	if(rtnValue != undefined && rtnValue != null ){
    		document.form.stl_to_clt_cng_ofc_cd.value=rtnValue;
    	}
	    var user_ofc_cd=document.form.s_user_ofc_cd.value;
	    var stl_to_clt_cng_ofc_cd=document.form.stl_to_clt_cng_ofc_cd.value;
		if ( stl_to_clt_cng_ofc_cd!="" && stl_to_clt_cng_ofc_cd == user_ofc_cd ){
		    document.form.stl_to_clt_cng_ofc_cd.value="";
		    ComShowMessage(ComGetMsg("TPB90051"));
		    return ; 
		}
		
		sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "stl_to_clt_cng_ofc_cd", rtnValue);
  	}
    
	function callback0805(rtnValue){
		if(rtnValue != undefined && rtnValue != null ){
    		document.form.s_file_no.value=rtnValue[0];
    		document.form.s_ra_rmk1.value=rtnValue[1];
    		document.form.s_ra_rmk2.value=rtnValue[2];
    		if ( ComTrim(rtnValue[1]).length == 0 ){ 
    		    ComShowMessage(ComGetMsg("TPB90060"));
                return false;
    		}
            if ( document.form.n3pty_stl_tp_cd.value=="W" && ComTrim(rtnValue[2]).length == 0 ){ 
                // ComShowMessage("In Write-Off case Preventive Measures must be input.");
                ComShowMessage(ComGetMsg("TPB90060"));
                return false;
            }
            sheetObjects[0].DoSave("ESD_TPB_0113GS.do", tpbFrmQryStr(document.form));			
            
    	} else {
    	    return false;
    	}
	}
    
    function openReasonToSavePopup(){
    	var theURL="ESD_TPB_0805.do";
        // ComShowMessage( theURL );
    	var features="scroll:no;status:no;help:no;dialogWidth:470px;dialogHeight:250px";
    	var rtnValue =  ComOpenWindow(theURL,  window,  features , true);
    	
	}
    
    
    function openReviewResultPopup(){
    	var theURL="ESD_TPB_0806.do";
    	theURL += "?func=reviewResultCallBack";
        // ComShowMessage( theURL );
    	ComOpenPopup(theURL, 470, 340, "reviewResultCallBack", "1,0,1,1,1,1,1", true);
    }	
    
    function reviewResultCallBack(rtnValue){
    	if(rtnValue != undefined && rtnValue != null ){
    		document.form.s_file_no.value=rtnValue[0];
    		document.form.s_ra_rmk1.value=rtnValue[1];
    		if ( ComTrim(rtnValue[1]).length == 0 ){ 
    		    ComShowMessage(ComGetMsg("TPB90062"));
                return false;
    		}
    		sheetObjects[0].DoSave("ESD_TPB_0113GS.do", tpbFrmQryStr(document.form));
    	}
    	
    }
    
	function sheet1_OnPopupClick(sheetObj,Row,Col){
		get3rdPartyTarget_sheet( "S", Row,Col,sheetObj, "s_s_vndr_cust_div_cd", "s_s_trd_party_val", "Res. Office" );
		sheet1_OnChange(sheetObj, Row, Col);
	}