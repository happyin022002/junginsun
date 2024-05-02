/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1008.js
*@FileTitle  : Chassis On-Hire Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================
*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class ees_cgm_1008 : ees_cgm_1008 business script for
 */
//	function ees_cgm_1008() {
//		this.processButtonClick=tprocessButtonClick;
//		this.setSheetObject=setSheetObject;
//		this.loadPage=loadPage;
//		this.initSheet=initSheet;
//		this.initControl=initControl;
//		this.doActionIBSheet=doActionIBSheet;
//		this.setTabObject=setTabObject;
//		this.validateForm=validateForm;
//	}
	/* developer jop */
	// common global variables
	var tabObjects=new Array();
	var tabCnt=0;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick() {
		/***** use additional sheet var in case of more than 2 tap each sheet *****/
		var sheetObj=sheetObjects[0];
		var sheetObj1=sheetObjects[1];
		/*******************************************************/
		var formObj=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
			case "btn_rowadd":
				sheetObj.DataInsert();
				// setting hidden culumn value(CUD Query mandatory culumn value)
				for(i=1; i<sheetObj.RowCount()+1; i++){
					sheetObj.SetCellValue(i, "eq_knd_cd",document.forms[0].eq_knd_cd.value);
					if(sheetObj.GetCellValue(i, "cre_usr_id") == ""){
						sheetObj.SetCellValue(i, "cre_usr_id",document.forms[0].cre_id.value);
					}
				}
				break;
			case "btn_delete":
				rowDelete(sheetObj);
				break;
			case "btn_excel":
				doActionIBSheet(sheetObj,formObj,IBLOADEXCEL);
				break;
			case "btn_new":
				// SHEET RESET
				sheetObj.RemoveAll();
				// HTML OBJECT RESET
				formObj.reset();
				chk('O');
				break;
			case "btn_verify":
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
				break;
			case "btn_confirm":
				doActionIBSheet(sheetObj,formObj,IBSAVE);
				break;
			case "btn_Calendar_a":
				if(window.event.srcElement.disabled) {
					return;
				}
				var cal=new ComCalendar();
				cal.select(formObj.onh_dt, "yyyy-MM-dd");
				break;
			case "ComOpenPopupWithTargetOffice":
				ComOpenPopupWithTarget('/opuscntr/COM_ENS_071.do?pgmNo=COM_ENS_071', 800, 480, "ofc_cd:onh_ofc_cd", "1,0,1,1,1,1,1", true);
//				Matched_Chk('Office');
//			    Verify_Status_chk();
				break;
			case "ComOpenPopupWithTargetYard":
				ComOpenPopupWithTarget('/opuscntr/COM_ENS_061.do?pgmNo=COM_ENS_061', 800, 550, "3:onh_yd_cd", "1,0,1,1,1,1,1", true);
//				Matched_Chk('Yard');
//				Verify_Status_chk();
				break;
			case "ComOpenPopupWithTargetAgree":
				if(formObj.ownleas[1].checked == true){
					ComOpenPopup('/opuscntr/EES_CGM_1117.do?pgmNo=EES_CGM_1117', 820, 420, "setProgramNo", "1,0,1,1,1,1", true, false);
				}
				break;
	        case "btn_downexcel":
	        	if(sheetObj.RowCount() < 1){//no data
	        		ComShowCodeMessage("COM132501");
        	    } else{
        	    	sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(        	 sheetObj), SheetDesign:1,Merge:1 });
        	    }
		       	break;
			} // end switch
		} catch (e) {
			if( e == "[object Error]") {
	 			ComShowMessage(OBJECT_ERROR);
	 		} else {
	 			ComShowMessage(e.message);
	 		}
		}
	}
	/**
	 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items 
	 * defining list on the top of source
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * implementing onLoad event handler in body tag / adding first-served functions after loading screen.
	 *
	 */
	function loadPage() {
		var sheetObj=sheetObjects[0];
		var formObj=document.form;
		for (i=0; i < sheetObjects.length; i++) {
			// 
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			// 
			ComEndConfigSheet(sheetObjects[i]);
			yard_Chk();
			
			sheet1_OnLoadFinish(sheetObjects[0]);
		}
	}
	 /**
	  * 
	  * @param sheetObj
	  * @return
	  */
	 function sheet1_OnLoadFinish(sheetObj) {
	     sheetObj.SetWaitImageVisible(0);
	     var formObj=document.form;
	//   axon_event.addListenerFormat("keypress",			"obj_keypress",		form);
	//   axon_event.addListenerFormat("keypress",			"obj_keydown",		form);
	     axon_event.addListenerForm  ("beforedeactivate",	"obj_deactivate",	form);
	 //	 axon_event.addListenerFormat("beforeactivate",		"obj_activate",		form);
	 	 axon_event.addListener      ("click",				"obj_onclick",		"ownleas");
//	 	axon_event.addListener('focusout', 'obj_focusout' , 'onh_ofc_cd' , 'agreement_no' ,'onh_dt','onh_dt_hm','onh_yd_cd' ); 
	 	axon_event.addListener('change', 'obj_change' , 'onh_ofc_cd' , 'agreement_no' ,'onh_dt','onh_dt_hm','onh_yd_cd' ); 
	// 	axon_event.addListenerForm('keyup', 'obj_keyup', formObj);
	 	doActionIBSheet(sheetObj, formObj, SEARCH08); // COMBO retrieve(STATE CODE)
	 	doActionIBSheet(sheetObj, formObj, SEARCH04); // COMBO retrieve(TYPE SIZE)
	    sheetObj.SetWaitImageVisible(1);
	}
		function resizeSheet( ){
			ComResizeSheet( sheetObjects[0] );
		}
	/**
	 * setting sheet initial values and header param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		switch (sheetNo) {
		case 1: // sheet1 init
		    with(sheetObj){
			      var HeadTitle="Status||Seq.|Chassis No.|Type/Size|Manufacture Date|Weight(lbs)|Reg.State|Reg.Year|Expiry Date|Expiry Date|License No.|Vehicle ID No.|Title No.|Alias No.1|Alias No.2|Verify Status|Created By|eq_knd_cd|own_lse|onh_dt|vndr_seq|agmt_lstm_cd";
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1, FrozenCol: 5} );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
			             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
			             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"eq_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10, InputCaseSensitive:1 },
			             {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"eq_tpsz_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"PopupEdit", Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"mft_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Int",       Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"chss_tare_wgt",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Combo",     Hidden:0, Width:190,  Align:"Center",  ColMerge:0,   SaveName:"chss_rgst_ste_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"chss_rgst_yr",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 },
			             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"chss_rgst_exp_div",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"chss_rgst_exp_dt",   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"chss_rgst_lic_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:12 },
			             {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"chss_veh_id_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
			             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"chss_tit_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:15 },
			             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"chss_als_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:11 },
			             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"n2nd_chss_als_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:11 },
			             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"verify",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cre_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"eq_knd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"own_lse",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"onh_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"agreement_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"agmt_ver_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"onh_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"onh_yd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"vndr_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"agmt_lstm_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			      InitColumns(cols);
			      SetEditable(1);
		          SetColProperty(0,"chss_rgst_exp_div", {ComboText:"PMNT|Fixed", ComboCode:"P|F"} );
		          SetColProperty(0,"eq_no", {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1} );
			      SetShowButtonImage(2);
			      SetSelectionMode(smSelectionFree);
//			      SetSheetHeight(380);
			      resizeSheet();
			      }
			break;
		}
	}
	/**
	 * handling process for Sheet 
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
		case IBSEARCH: // retrieve
			var chkFlag=false;
			var typFlag=false;
			formObj.f_cmd.value=SEARCHLIST;
			queryString="f_cmd=" + SEARCHLIST;
			if(formObj.onh_ofc_cd.value == ""){
				ComShowCodeMessage("CGM10004", "Office");
	//			formObj.onh_ofc_cd.focus();
				return;
			}
			if(formObj.onh_dt.value == ""){
				ComShowCodeMessage("CGM10004", "On-Hire Date");
	//			formObj.onh_dt.focus();
				return;
			}
			if(formObj.onh_yd_cd.value == ""){
				ComShowCodeMessage("CGM10004", "On-Hire Yard");
	//			formObj.onh_yd_cd.focus();
				return;
			}
			if(formObj.onh_yd_cd.value!='' && formObj.onh_yd_cd.value.length !=7){
				 ComShowCodeMessage('CGM10044','On-Hire Yard (7)');
	//		 	 formObj.onh_yd_cd.focus();
			     return false;
			}
			if(formObj.agreement_no.value == "" && formObj.ownleas[0].checked != true){
				ComShowCodeMessage("CGM10004", "Agreement No");
	//			formObj.agreement_no.focus();
				return;
			}
			for(i=1; i<sheetObj.RowCount()+1; i++){
				var del_chk=sheetObj.GetCellValue(i, "del_chk");
				// 
				if(del_chk == "1" && sheetObj.GetCellValue(i, "eq_no")==""){
					sheetObj.SetRowStatus(i,"R");
					sheetObj.SetCellValue(i, "del_chk","0");
				} else if(del_chk == "1" && sheetObj.GetCellValue(i, "eq_no")!=""){
					sheetObj.SetRowStatus(i,"U");
					sheetObj.SetCellValue(i, "own_lse",formObj.own_lse.value);
	//				if(formObj.ownleas[1].checked == true && sheetObj.CellValue(i, "eq_tpsz_cd") == ""){
	//					typFlag = true;
	//				}
					if(formObj.ownleas[1].checked == true  ){
						sheetObj.SetCellValue(i, "agreement_no",formObj.agreement_no.value);
					}
					chkFlag=true;
				}
				sheetObj.SetCellValue(i, "onh_dt",formObj.onh_dt.value + " " + formObj.onh_dt_hm.value);
			}
			var params=sheetObj.GetSaveString(true);
			if(sheetObj.RowCount()>0 && chkFlag){
				sheetObj.SetWaitImageVisible(0);
	 	        ComOpenWait(true);
	 	        sheetObj.DoSearch("EES_CGM_1008GS.do", queryString+"&"+params );
				
			} else {
				ComShowCodeMessage("CGM10008");	
				return;
			}
			
			break;
		case IBSAVE: // saving
			var actionFlag=true; 
		    var VerifyFlag=false; 
			if(formObj.onh_ofc_cd.value == ""){
				ComShowCodeMessage("CGM10004", "Office");
	//			formObj.onh_ofc_cd.focus();
				return;
			}
			if(formObj.onh_dt.value == ""){
				ComShowCodeMessage("CGM10004", "On-Hire Date");
	//			formObj.onh_dt.focus();
				return;
			}
			if(formObj.onh_yd_cd.value == ""){
				ComShowCodeMessage("CGM10004", "On-Hire Yard");
	//			formObj.onh_yd_cd.focus();
				return;
			}
			if(formObj.onh_yd_cd.value!='' && formObj.onh_yd_cd.value.length !=7){
				 ComShowCodeMessage('CGM10044','On-Hire Yard (7)');
	//		 	 formObj.onh_yd_cd.focus();
			     return false;
			}
			if(formObj.agreement_no.value == "" && formObj.ownleas[0].checked != true){
				ComShowCodeMessage("CGM10004", "Agreement No");
	//			formObj.agreement_no.focus();
				return;
			}
			formObj.f_cmd.value=MULTI;
			for(i=1; i<sheetObj.RowCount()+1; i++){
				var verify=sheetObj.GetCellValue(i, "verify");
				if(verify == "OK" &&sheetObj.GetCellValue(i, "del_chk") == "1"){
					// 
					sheetObj.SetCellValue(i, "onh_dt",formObj.onh_dt.value + " " + formObj.onh_dt_hm.value);
					if(formObj.ownleas[1].checked){
						sheetObj.SetCellValue(i, "agreement_no",formObj.agreement_no.value );
						sheetObj.SetCellValue(i, "agmt_ver_no",formObj.agmt_ver_no.value );
						sheetObj.SetCellValue(i, "agmt_lstm_cd",formObj.agmt_lstm_cd.value );
						sheetObj.SetCellValue(i, "vndr_seq",formObj.vndr_seq.value );
					}
					sheetObj.SetCellValue(i, "onh_yd_cd",formObj.onh_yd_cd.value );
					sheetObj.SetCellValue(i, "onh_ofc_cd",formObj.onh_ofc_cd.value );
					sheetObj.SetCellValue(i, "eq_knd_cd","Z" );
					sheetObj.SetRowStatus(i,"I");
				} else if(verify == "" && sheetObj.GetCellValue(i, "del_chk")== "1" ) {
					ComShowCodeMessage("CGM10004", "verify");
					sheetObj.SetRowStatus(i,"R");
					actionFlag=false; 
					break;
				} else if(verify != "OK" && sheetObj.GetCellValue(i, "del_chk")== "1" ) {
					VerifyFlag=true; 
					sheetObj.SetRowStatus(i,"R");
					break;
				} else {
					sheetObj.SetRowStatus(i,"R");
				}
			}
			// CONFIRM
			if (VerifyFlag){
	        	ComShowCodeMessage("CGM10005");
		    } else if(actionFlag){
	 			formObj.f_cmd.value=MULTI;
				queryString="f_cmd=" + MULTI ;
				sheetObj.SetWaitImageVisible(0);
	 	        ComOpenWait(true);
				var params=sheetObj.GetSaveString(true);
				if(sheetObj.DoSave("EES_CGM_1008GS.do",queryString + "&" + ComGetPrefixParam("")),'del_chk')
				{
					for(i=1; i<sheetObj.RowCount()+1; i++){
						if(sheetObj.GetCellValue(i, "del_chk") == "1"){
							sheetObj.SetRowStatus(i,"R");
						}
					}
				}
				ComOpenWait(false);
			}
			else
			{
				ComShowCodeMessage("CGM10008");
			}
			break;
		case IBSEARCH_ASYNC01:
			formObj.f_cmd.value=SEARCH12;
			formObj.agmt_no.value=formObj.agreement_no.value;
			var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do" , FormQueryString(formObj));
			var dataCount=ComGetTotalRows(sXml);
			if(dataCount > 0){
				var lstmCd=DomXml2String(sXml,"agmt_lstm_cd");
				if(formObj.ownleas[0].checked == true  ){
					if(lstmCd !="OW" && lstmCd !="OL" && lstmCd !="LP"){
		       		 ComShowCodeMessage('CGM10066',formObj.agreement_no.value);
		           	 return false;
		       	 } else {
		       		formObj.agreement_no.value=DomXml2String(sXml,"agmt_no");
		        	formObj.agmt_ref_no.value=DomXml2String(sXml,"agmt_ref_no");
		        	formObj.agmt_lstm_cd.value=DomXml2String(sXml,"agmt_lstm_cd");
		        	// AGREEMENT NO POST PROCESS CALL
		        	formObj.vndr_lgl_eng_nm.value=DomXml2String(sXml,"vndr_lgl_eng_nm");
		        	formObj.vndr_seq.value=DomXml2String(sXml,"vndr_seq");
		        	formObj.agmt_ver_no.value=DomXml2String(sXml,"agmt_ver_no");
		        	agreementNoChk(lstmCd);
		       	 }
	        } else if(formObj.ownleas[1].checked == true ){
		       	 if(lstmCd =="OW" || lstmCd =="OL" || lstmCd =="LP"){
		       		 ComShowCodeMessage('CGM10065',formObj.agreement_no.value);
		           	 return false;
		       	 }  else if(lstmCd =="CP"  ){
		       		 ComShowCodeMessage('CGM10029');
		           	 return false;
		       	 } else {
		       		formObj.agreement_no.value=DomXml2String(sXml,"agmt_no");
		        	formObj.agmt_ref_no.value=DomXml2String(sXml,"agmt_ref_no");
		        	formObj.agmt_lstm_cd.value=DomXml2String(sXml,"agmt_lstm_cd");
		        	// AGREEMENT NO POST PROCESS CALL
		        	formObj.vndr_lgl_eng_nm.value=DomXml2String(sXml,"vndr_lgl_eng_nm");
		        	formObj.vndr_seq.value=DomXml2String(sXml,"vndr_seq");
		        	formObj.agmt_ver_no.value=DomXml2String(sXml,"agmt_ver_no");
		        	agreementNoChk(lstmCd);
		       	 }
	        }
	    	return true;
	    } else {
	    	// Form Object reset
	    	ComShowCodeMessage("CGM10009","Agreement No");
	    	formObj.agreement_no.value="";
	    	formObj.agmt_ref_no.value="";
	    	formObj.agmt_lstm_cd.value="";
	    	formObj.vndr_lgl_eng_nm.value="";
	    	formObj.vndr_seq.value="";
	    	return false;
	    }
	    break;
	    
		case IBLOADEXCEL:
			if (sheetObj.id == "sheet1") {
				if(sheetObj.RowCount() >= 1)
				{
					sheetObj.RemoveAll();
				}
				sheetObj.LoadExcel();
			}


/*			for(i=1; i<sheetObj.RowCount()+1; i++){
				if(sheetObj.GetCellValue(i, "chss_rgst_exp_div") == 'P'){
					sheetObj.SetCellEditable(i, "chss_rgst_exp_dt",0);
				} else {
					sheetObj.SetCellEditable(i, "chss_rgst_exp_dt",1);
				}
				if(formObj.ownleas[1].checked == true){ //Leased 
					sheetObj.SetCellValue(i,"cre_usr_id",document.forms[0].cre_id.value,0);
					sheetObj.SetCellEditable(i, "eq_tpsz_cd",1);
					sheetObj.SetCellEditable(i, "mft_dt",1);
					sheetObj.SetCellEditable(i, "chss_tare_wgt",1);
					sheetObj.SetCellEditable(i, "chss_rgst_ste_cd",1);
					sheetObj.SetCellEditable(i, "chss_rgst_yr",1);
					sheetObj.SetCellEditable(i,"chss_rgst_exp_dt",1);
					sheetObj.SetCellEditable(i,"chss_rgst_lic_no",1);
					sheetObj.SetCellEditable(i,"chss_veh_id_no",1);
					sheetObj.SetCellEditable(i,"chss_tit_no",1);
					sheetObj.SetCellEditable(i,"chss_als_no",1);
					sheetObj.SetCellEditable(i,"n2nd_chss_als_no",1);
				} else{	//OWN
					alert(sheetObj.GetCellValue(i, "eq_no"));
			     	formObj.f_cmd.value=SEARCH;
			     	formObj.eq_no.value=sheetObj.GetCellValue(i, "eq_no");
					if(formObj.eq_no.value !=""){
						var sXml=sheetObj.GetSearchData("EES_CGM_1008GS.do", FormQueryString(formObj));
				 		var dataCount=ComGetTotalRows(sXml);
				 		if(dataCount > 0){
							sheetObj.SetCellValue(i,"agreement_no",DomXml2String(sXml,"agreement_no"),0);
							sheetObj.SetCellValue(i,"agmt_ver_no",DomXml2String(sXml,"agmt_ver_no"),0);
							sheetObj.SetCellValue(i,"vndr_seq",DomXml2String(sXml,"vndr_seq"),0);
							sheetObj.SetCellValue(i,"agmt_lstm_cd",DomXml2String(sXml,"agmt_lstm_cd"),0);
							sheetObj.SetCellValue(i,"eq_tpsz_cd",DomXml2String(sXml,"eq_tpsz_cd"),0);
						} else {
							sheetObj.SetCellValue(i,"eq_no","",0);
							ComShowCodeMessage("CGM20003");
						}
					}			
				}
			}*/
		break;
		
		case SEARCH08: 
			formObj.f_cmd.value=SEARCH08;
			var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
	 	  	var cols=ComCgmXml2ComboString(sXml, "code1", "code1|desc1", "\t");
	 	  	sheetObj.SetColProperty(0, "chss_rgst_ste_cd", {ComboText:"|"+cols[1], ComboCode: "|"+cols[0]} );
	 	break;
	 	
		case SEARCH04: 
	        formObj.f_cmd.value=SEARCH04;
	        var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
	        var sStr=ComGetEtcData(sXml,"comboList");
	        var arrStr=sStr.split("@");
	        var arrCode1="";
	        var arrCode2="";
	        for (var i=0; i < arrStr.length;i++ ) {
	        	var arrCode=arrStr[i].split("|");
	        	if(i==0){
	        		arrCode1=arrCode1+" " +"|"+ arrCode[1];
	        		arrCode2=arrCode2+" " +"|"+ arrCode[0];
	        	} else {
	        		arrCode1=arrCode1 +"|"+ arrCode[1];
	        		arrCode2=arrCode2 +"|"+ arrCode[0];
	        	}
	        }
	        sheetObj.SetColProperty(0, "eq_tpsz_cd", {ComboText:arrCode1, ComboCode: arrCode2} );
		 	break;
		 	
		case IBSEARCH_ASYNC02:	// Office Code Validation check 
		   	formObj.f_cmd.value=COMMAND01;
		   	formObj.ofc_cd.value=formObj.onh_ofc_cd.value;
		   	var sXml=sheetObj.GetSearchData("CgmValidationGS.do", FormQueryString(formObj));
		   	var sCheckResult=ComGetEtcData(sXml,"checkResult");    	
		   	if(sCheckResult == COM_VALIDATION_FALSE){
		   		ComShowCodeMessage('CGM10009','Office');
		   		formObj.onh_ofc_cd.value="";
		   	} else {
		   		Matched_Chk('Office');
		   	}
		   	break;
		   	
		case IBSEARCH_ASYNC03:	// Office Code  Validation check 
		   	formObj.f_cmd.value=COMMAND01;
		   	formObj.yd_cd.value=formObj.onh_yd_cd.value;
		   	var sXml=sheetObj.GetSearchData("Check_YardGS.do", FormQueryString(formObj));
		   	var sCheckResult=ComGetEtcData(sXml,"checkResult");    	
		   	if(sCheckResult == COM_VALIDATION_FALSE){
		   		ComShowCodeMessage('CGM10009','Yard');
		   		formObj.onh_yd_cd.value="";
		   	} else {
		   		Matched_Chk('Yard');
		   	}
		   	break;
		}
	}
	
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		var verify = "";
		var verifyFlag=false;
		for(i=1; i<sheetObj.RowCount()+1; i++){
			verify=sheetObj.GetCellValue(i, "verify")
			// 
			if(verify != "OK"){
				if(sheetObj.GetCellValue(i, "eq_no") == ""){
					//sheetObj.CellValue(i, "del_chk") = "1";
				} else {
					verifyFlag=true;
				}
			}
		}
		ComOpenWait(false);
		if(verifyFlag){
			ComShowCodeMessage("CGM10005");
		}
		
		for(i=1; i<sheetObj.RowCount()+1; i++){
			if(sheetObj.GetCellValue(i, "chss_rgst_exp_div") == 'P'){
				sheetObj.SetCellEditable(i, "chss_rgst_exp_dt",0);
			} else {
				sheetObj.SetCellEditable(i, "chss_rgst_exp_dt",1);
			}
		}
		for (i=1; i<sheetObj.RowCount()+1; i++){
			if (sheetObj.GetCellValue(i, "verify") == "OK" && sheetObj.GetCellValue(i, "del_chk") == "1"){
				sheetObj.SetCellEditable(i, "del_chk",1);
				sheetObj.SetCellEditable(i, "eq_no",0);
				sheetObj.SetRowFontColor(i,"#000000");
			} else if(sheetObj.GetCellValue(i, "verify") != "OK" && sheetObj.GetCellValue(i, "del_chk") == "1"){
				sheetObj.SetCellValue(i, "del_chk","0");
				sheetObj.SetCellEditable(i, "del_chk",1);
				sheetObj.SetCellEditable(i, "mft_dt",1);
				sheetObj.SetCellEditable(i, "chss_tare_wgt",1);
				sheetObj.SetCellEditable(i, "chss_rgst_ste_cd",1);
				sheetObj.SetCellEditable(i, "chss_rgst_yr",1);
				sheetObj.SetCellEditable(i,"chss_rgst_exp_dt",1);
				sheetObj.SetCellEditable(i,"chss_rgst_lic_no",1);
				sheetObj.SetCellEditable(i,"chss_veh_id_no",1);
				sheetObj.SetCellEditable(i,"chss_tit_no",1);
				sheetObj.SetCellEditable(i,"chss_als_no",1);
				sheetObj.SetCellEditable(i,"n2nd_chss_als_no",1);
				sheetObj.SetRowFontColor(i,"#FF0000");
//				sheetObj.CellValue(i, "ibflag") = "";
			}
		}
	}
	
	
	function sheet1_OnLoadExcel(sheetObj, result, code, msg){
		if(isExceedMaxRow(msg))return;
		
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		
//		if(result){
			
/*			for(i=1; i<=sheetObj.RowCount(); i++){
				if(sheetObj.GetCellValue(i, "chss_rgst_exp_div") == 'P'){
					sheetObj.SetCellEditable(i, "chss_rgst_exp_dt",0);
				} else {
					sheetObj.SetCellEditable(i, "chss_rgst_exp_dt",1);
				}
				if(formObj.ownleas[1].checked == true){ //Leased 
					sheetObj.SetCellValue(i,"cre_usr_id",document.forms[0].cre_id.value,0);
					sheetObj.SetCellEditable(i, "eq_tpsz_cd",1);
					sheetObj.SetCellEditable(i, "mft_dt",1);
					sheetObj.SetCellEditable(i, "chss_tare_wgt",1);
					sheetObj.SetCellEditable(i, "chss_rgst_ste_cd",1);
					sheetObj.SetCellEditable(i, "chss_rgst_yr",1);
					sheetObj.SetCellEditable(i,"chss_rgst_exp_dt",1);
					sheetObj.SetCellEditable(i,"chss_rgst_lic_no",1);
					sheetObj.SetCellEditable(i,"chss_veh_id_no",1);
					sheetObj.SetCellEditable(i,"chss_tit_no",1);
					sheetObj.SetCellEditable(i,"chss_als_no",1);
					sheetObj.SetCellEditable(i,"n2nd_chss_als_no",1);
				} else{	//OWN
				//	alert(sheetObj.GetCellValue(i, "eq_no"));
			     	formObj.f_cmd.value=SEARCH;
			     	var cellValue = sheetObj.GetCellValue(i, "eq_no");
			     	formObj.eq_no.value=cellValue;
			     	
			     	if(formObj.eq_no.value !=""){
						var sXml=sheetObj.GetSearchData("EES_CGM_1008GS.do", FormQueryString(formObj));
				 		//var dataCount=ComGetTotalRows(sXml);
				 		if(DomXml2String(sXml, "eq_no") != null && DomXml2String(sXml, "eq_no") != "") {
				 			alert(DomXml2String(sXml,"agreement_no"));
							sheetObj.SetCellValue(i,"agreement_no",DomXml2String(sXml,"agreement_no"),0);
							alert(DomXml2String(sXml,"agmt_ver_no"));
							sheetObj.SetCellValue(i,"agmt_ver_no",DomXml2String(sXml,"agmt_ver_no"),0);
							alert(DomXml2String(sXml,"vndr_seq"));
							sheetObj.SetCellValue(i,"vndr_seq",DomXml2String(sXml,"vndr_seq"),0);
							alert(DomXml2String(sXml,"agmt_lstm_cd"));
							sheetObj.SetCellValue(i,"agmt_lstm_cd",DomXml2String(sXml,"agmt_lstm_cd"),0);
							alert(DomXml2String(sXml,"eq_tpsz_cd"));
							sheetObj.SetCellEditable(i, "eq_tpsz_cd",1);
							sheetObj.SetCellValue(i,"eq_tpsz_cd",DomXml2String(sXml,"eq_tpsz_cd"),0);
							alert("End");
						
						} else {
							sheetObj.SetCellValue(i,"eq_no","",0);
							ComShowCodeMessage("CGM20003");
						}
					}		
					
				}
	//			cellEnable(sheetObj, i);
				sheetObj.SetRowStatus(i, "I");
				sheetObj.SetCellValue(i, "del_chk", 1, 0);
			}	*/		
	     	
			// chassis no check
			for(var i = 1 ; i < sheetObj.LastRow()+1 ; i++){
				Row = i;
				
				var cellValue=sheetObj.GetCellValue(i, "eq_no"); 
				if(sheetObj.GetCellValue(i, "eq_no")== '')
				{
					ComShowCodeMessage("CGM20004",sheetObj.GetCellValue(i, "eq_no"));
		        	// Setting Cell value to Null
					sheetObj.SetCellValue(Row, "eq_no","");
		        	continue;
				}

				formObj.f_cmd.value=SEARCH;
				formObj.eq_no.value=cellValue;
				
				if(formObj.eq_no.value !=""){
					var sXml=sheetObj.GetSearchData("EES_CGM_1008GS.do", FormQueryString(formObj),{Sync:1});
					
			 		var dataCount=ComGetTotalRows(sXml);
			 		if(dataCount > 0){
						sheetObj.SetCellValue(Row,"eq_tpsz_cd",DomXml2String(sXml,"eq_tpsz_cd"),0);
						var onhDt = DomXml2String(sXml, "onh_dt");
						var expDt = DomXml2String(sXml,"chss_rgst_exp_dt");
//						sheetObj.SetCellValue(Row,"mft_dt",onhDt,0);
						sheetObj.SetCellValue(Row,"mft_dt",DomXml2String(sXml,"mft_dt"),0);
						sheetObj.SetCellValue(Row,"chss_tare_wgt",DomXml2String(sXml,"chss_tare_wgt"),0);
						sheetObj.SetCellValue(Row,"chss_rgst_ste_cd",DomXml2String(sXml,"chss_rgst_ste_cd"),0);
						sheetObj.SetCellValue(Row,"chss_rgst_yr",DomXml2String(sXml,"chss_rgst_yr"),0);
						sheetObj.SetCellValue(Row,"chss_rgst_exp_dt",expDt,0);
						sheetObj.SetCellValue(Row,"chss_rgst_lic_no",DomXml2String(sXml,"chss_rgst_lic_no"),0);
						sheetObj.SetCellValue(Row,"chss_veh_id_no",DomXml2String(sXml,"chss_veh_id_no"),0);
						sheetObj.SetCellValue(Row,"chss_tit_no",DomXml2String(sXml,"chss_tit_no"),0);
						sheetObj.SetCellValue(Row,"chss_als_no",String(DomXml2String(sXml,"chss_als_no")),0); 
						
						sheetObj.SetCellValue(Row,"n2nd_chss_als_no",DomXml2String(sXml,"n2nd_chss_als_no"),0);
						sheetObj.SetCellValue(Row,"agreement_no",DomXml2String(sXml,"agreement_no"),0);
						sheetObj.SetCellValue(Row,"agmt_ver_no",DomXml2String(sXml,"agmt_ver_no"),0);
						sheetObj.SetCellValue(Row,"vndr_seq",DomXml2String(sXml,"vndr_seq"),0);
						sheetObj.SetCellValue(Row,"agmt_lstm_cd",DomXml2String(sXml,"agmt_lstm_cd"),0);
						if(formObj.ownleas[0].checked != true){
							sheetObj.SetCellEditable(Row, "eq_tpsz_cd",1);
						}
						sheetObj.SetCellEditable(Row, "mft_dt",1);
						sheetObj.SetCellEditable(Row, "chss_tare_wgt",1);
						sheetObj.SetCellEditable(Row, "chss_rgst_ste_cd",1);
						sheetObj.SetCellEditable(Row, "chss_rgst_yr",1);
						sheetObj.SetCellEditable(Row,"chss_rgst_exp_dt",1);
						sheetObj.SetCellEditable(Row,"chss_rgst_lic_no",1);
						sheetObj.SetCellEditable(Row,"chss_veh_id_no",1);
						sheetObj.SetCellEditable(Row,"chss_tit_no",1);
						sheetObj.SetCellEditable(Row,"chss_als_no",1);
						sheetObj.SetCellEditable(Row,"n2nd_chss_als_no",1);
					} 
			 		else {
			 			if(formObj.ownleas[0].checked){
							sheetObj.SetCellValue(Row,"eq_tpsz_cd","",0);
							sheetObj.SetCellValue(Row,"mft_dt","",0);
							sheetObj.SetCellValue(Row,"chss_tare_wgt","",0);
							sheetObj.SetCellValue(Row,"chss_rgst_ste_cd","",0);
							sheetObj.SetCellValue(Row,"chss_rgst_yr","",0);
							sheetObj.SetCellValue(Row,"chss_rgst_exp_dt","",0);
							sheetObj.SetCellValue(Row,"chss_rgst_lic_no","",0);
							sheetObj.SetCellValue(Row,"chss_veh_id_no","",0);
							sheetObj.SetCellValue(Row,"chss_tit_no","",0);
							sheetObj.SetCellValue(Row,"chss_als_no","",0);
							sheetObj.SetCellValue(Row,"n2nd_chss_als_no","",0);
							sheetObj.SetCellValue(Row,"agreement_no","",0);
							sheetObj.SetCellValue(Row,"agmt_ver_no","",0);
							sheetObj.SetCellValue(Row,"cre_usr_id",document.forms[0].cre_id.value,0);
							sheetObj.SetCellValue(Row,"vndr_seq","",0);
							sheetObj.SetCellValue(Row,"agmt_lstm_cd","",0);
							if(formObj.ownleas[0].checked == true){
								ComShowCodeMessage("CGM20003");
					        	// Setting Cell value to Null
								sheetObj.SetCellValue(Row, "eq_no","");
								sheetObj.SelectCell(Row, "eq_no", true);
								continue;
							}
							if(formObj.ownleas[0].checked != true){
								sheetObj.SetCellEditable(Row, "eq_tpsz_cd",1);
							}
							sheetObj.SetCellEditable(Row, "mft_dt",1);
							sheetObj.SetCellEditable(Row, "chss_tare_wgt",1);
							sheetObj.SetCellEditable(Row, "chss_rgst_ste_cd",1);
							sheetObj.SetCellEditable(Row, "chss_rgst_yr",1);
							sheetObj.SetCellEditable(Row,"chss_rgst_exp_dt",1);
							sheetObj.SetCellEditable(Row,"chss_rgst_lic_no",1);
							sheetObj.SetCellEditable(Row,"chss_veh_id_no",1);
							sheetObj.SetCellEditable(Row,"chss_tit_no",1);
							sheetObj.SetCellEditable(Row,"chss_als_no",1);
							sheetObj.SetCellEditable(Row,"n2nd_chss_als_no",1);
			 			}
					}
				} else {
					sheetObj.SetCellValue(Row,"eq_tpsz_cd","",0);
					sheetObj.SetCellValue(Row,"mft_dt","",0);
					sheetObj.SetCellValue(Row,"chss_tare_wgt","",0);
					sheetObj.SetCellValue(Row,"chss_rgst_ste_cd","",0);
					sheetObj.SetCellValue(Row,"chss_rgst_yr","",0);
					sheetObj.SetCellValue(Row,"chss_rgst_exp_dt","",0);
					sheetObj.SetCellValue(Row,"chss_rgst_lic_no","",0);
					sheetObj.SetCellValue(Row,"chss_veh_id_no","",0);
					sheetObj.SetCellValue(Row,"chss_tit_no","",0);
					sheetObj.SetCellValue(Row,"chss_als_no","",0);
					sheetObj.SetCellValue(Row,"n2nd_chss_als_no","",0);
					sheetObj.SetCellValue(Row,"agreement_no","",0);
					sheetObj.SetCellValue(Row,"agmt_ver_no","",0);
					sheetObj.SetCellValue(Row,"cre_usr_id",document.forms[0].cre_id.value,0);
					sheetObj.SetCellValue(Row,"vndr_seq","",0);
					sheetObj.SetCellValue(Row,"agmt_lstm_cd","",0);
					sheetObj.SetCellEditable(Row, "eq_tpsz_cd",0);
					sheetObj.SetCellEditable(Row, "mft_dt",0);
					sheetObj.SetCellEditable(Row, "chss_tare_wgt",0);
					sheetObj.SetCellEditable(Row, "chss_rgst_ste_cd",0);
					sheetObj.SetCellEditable(Row, "chss_rgst_yr",0);
					sheetObj.SetCellEditable(Row, "chss_rgst_exp_div",0);
					sheetObj.SetCellEditable(Row,"chss_rgst_exp_dt",0);
					sheetObj.SetCellEditable(Row,"chss_rgst_lic_no",0);
					sheetObj.SetCellEditable(Row,"chss_veh_id_no",0);
					sheetObj.SetCellEditable(Row,"chss_tit_no",0);
					sheetObj.SetCellEditable(Row,"chss_als_no",0);
					sheetObj.SetCellEditable(Row,"n2nd_chss_als_no",0);
				}
				if(sheetObj.GetCellValue(Row, "chss_rgst_exp_div") == 'P'){
					sheetObj.SetCellEditable(Row, "chss_rgst_exp_dt",0);
				} else {
					sheetObj.SetCellEditable(Row, "chss_rgst_exp_dt",1);
				}
				sheetObj.SetCellEditable(Row, "chss_rgst_exp_div",1);	
				
				sheetObj.SetRowStatus(i, "I");
				sheetObj.SetCellValue(i, "del_chk", 1, 0);

			}
//		}
	}
	
	
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		with (formObj) {
			// if (!isNumber(formObj.iPage)) {
			// return false;
			// }
		}
		return true;
	}
//	function sheet1_OnPopupClick(sheetObj, Row, Col, Value) {
//		ComShowMessage("popup_click");
//	}
	/**
	 * SHEET1 ONCHANGE EVENT
	 */
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
	//	 alert(Row+"::"+Col+"::"+Value);
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		var targetCol=sheetObj.SaveNameCol("eq_no");
		var eqNo=sheetObj.GetCellValue(Row, "eq_no");
		with(sheetObj){
			var colName=ColSaveName(Col);
			switch(colName){
			case "eq_no":
		     	formObj.f_cmd.value=SEARCH;
				formObj.eq_no.value=eqNo;
				if(Row >1){
					// chassis no check
					for(i=1; i<sheetObj.RowCount(); i++){
						if(sheetObj.GetCellValue(i, "eq_no")== Value && Row != i  && sheetObj.GetCellValue(i, "eq_no")!='')
	 					{
							ComShowCodeMessage("CGM20004",sheetObj.GetCellValue(i, "eq_no"));
				        	// Setting Cell value to Null
							sheetObj.SetCellValue(Row, "eq_no","");
				        	return false;
	 					}
					}
				} 
				if(formObj.eq_no.value !=""){
					var sXml=sheetObj.GetSearchData("EES_CGM_1008GS.do", FormQueryString(formObj));
			 		var dataCount=ComGetTotalRows(sXml);
			 		if(dataCount > 0){
						var lstmCd=DomXml2String(sXml,"agmt_lstm_cd");
						if(formObj.ownleas[1].checked == true){
							if(lstmCd =="OW" || lstmCd =="OL" || lstmCd =="LP"){
					       		 ComShowCodeMessage('CGM10065',formObj.eq_no.value);
					           	 return false;
					       	 }
							sheetObj.SetCellValue(Row,"cre_usr_id",DomXml2String(sXml,"cre_usr_id"),0);
						} else {
							//sheetObj.CellValue2(Row,"cre_usr_id")   = "";
							sheetObj.SetCellValue(Row,"cre_usr_id",DomXml2String(sXml,"cre_usr_id"),0);
							if(lstmCd !="OW" && lstmCd !="OL" && lstmCd !="LP"){
					       		 ComShowCodeMessage('CGM10066',formObj.eq_no.value);
					           	 return false;
					       	} 
						}
						sheetObj.SetCellValue(Row,"eq_tpsz_cd",DomXml2String(sXml,"eq_tpsz_cd"),0);
						var onhDt = DomXml2String(sXml, "onh_dt");
						var expDt = DomXml2String(sXml,"chss_rgst_exp_dt");
//						sheetObj.SetCellValue(Row,"mft_dt",onhDt,0);
						sheetObj.SetCellValue(Row,"mft_dt",DomXml2String(sXml,"mft_dt"),0);
						sheetObj.SetCellValue(Row,"chss_tare_wgt",DomXml2String(sXml,"chss_tare_wgt"),0);
						sheetObj.SetCellValue(Row,"chss_rgst_ste_cd",DomXml2String(sXml,"chss_rgst_ste_cd"),0);
						sheetObj.SetCellValue(Row,"chss_rgst_yr",DomXml2String(sXml,"chss_rgst_yr"),0);
						sheetObj.SetCellValue(Row,"chss_rgst_exp_dt",expDt,0);
						sheetObj.SetCellValue(Row,"chss_rgst_lic_no",DomXml2String(sXml,"chss_rgst_lic_no"),0);
						sheetObj.SetCellValue(Row,"chss_veh_id_no",DomXml2String(sXml,"chss_veh_id_no"),0);
						sheetObj.SetCellValue(Row,"chss_tit_no",DomXml2String(sXml,"chss_tit_no"),0);
						sheetObj.SetCellValue(Row,"chss_als_no",String(DomXml2String(sXml,"chss_als_no")),0); 
						
						sheetObj.SetCellValue(Row,"n2nd_chss_als_no",DomXml2String(sXml,"n2nd_chss_als_no"),0);
						sheetObj.SetCellValue(Row,"agreement_no",DomXml2String(sXml,"agreement_no"),0);
						sheetObj.SetCellValue(Row,"agmt_ver_no",DomXml2String(sXml,"agmt_ver_no"),0);
						sheetObj.SetCellValue(Row,"vndr_seq",DomXml2String(sXml,"vndr_seq"),0);
						sheetObj.SetCellValue(Row,"agmt_lstm_cd",DomXml2String(sXml,"agmt_lstm_cd"),0);
						if(formObj.ownleas[0].checked != true){
							sheetObj.SetCellEditable(Row, "eq_tpsz_cd",1);
						}
						sheetObj.SetCellEditable(Row, "mft_dt",1);
						sheetObj.SetCellEditable(Row, "chss_tare_wgt",1);
						sheetObj.SetCellEditable(Row, "chss_rgst_ste_cd",1);
						sheetObj.SetCellEditable(Row, "chss_rgst_yr",1);
						sheetObj.SetCellEditable(Row,"chss_rgst_exp_dt",1);
						sheetObj.SetCellEditable(Row,"chss_rgst_lic_no",1);
						sheetObj.SetCellEditable(Row,"chss_veh_id_no",1);
						sheetObj.SetCellEditable(Row,"chss_tit_no",1);
						sheetObj.SetCellEditable(Row,"chss_als_no",1);
						sheetObj.SetCellEditable(Row,"n2nd_chss_als_no",1);
					} else {
						sheetObj.SetCellValue(Row,"eq_tpsz_cd","",0);
						sheetObj.SetCellValue(Row,"mft_dt","",0);
						sheetObj.SetCellValue(Row,"chss_tare_wgt","",0);
						sheetObj.SetCellValue(Row,"chss_rgst_ste_cd","",0);
						sheetObj.SetCellValue(Row,"chss_rgst_yr","",0);
						sheetObj.SetCellValue(Row,"chss_rgst_exp_dt","",0);
						sheetObj.SetCellValue(Row,"chss_rgst_lic_no","",0);
						sheetObj.SetCellValue(Row,"chss_veh_id_no","",0);
						sheetObj.SetCellValue(Row,"chss_tit_no","",0);
						sheetObj.SetCellValue(Row,"chss_als_no","",0);
						sheetObj.SetCellValue(Row,"n2nd_chss_als_no","",0);
						sheetObj.SetCellValue(Row,"agreement_no","",0);
						sheetObj.SetCellValue(Row,"agmt_ver_no","",0);
						sheetObj.SetCellValue(Row,"cre_usr_id",document.forms[0].cre_id.value,0);
						sheetObj.SetCellValue(Row,"vndr_seq","",0);
						sheetObj.SetCellValue(Row,"agmt_lstm_cd","",0);
						if(formObj.ownleas[0].checked == true){
							ComShowCodeMessage("CGM20003");
				        	// Setting Cell value to Null
							sheetObj.SetCellValue(Row, "eq_no","");
							sheetObj.SelectCell(Row, "eq_no", true);
							 return false;
						}
						if(formObj.ownleas[0].checked != true){
							sheetObj.SetCellEditable(Row, "eq_tpsz_cd",1);
						}
						sheetObj.SetCellEditable(Row, "mft_dt",1);
						sheetObj.SetCellEditable(Row, "chss_tare_wgt",1);
						sheetObj.SetCellEditable(Row, "chss_rgst_ste_cd",1);
						sheetObj.SetCellEditable(Row, "chss_rgst_yr",1);
						sheetObj.SetCellEditable(Row,"chss_rgst_exp_dt",1);
						sheetObj.SetCellEditable(Row,"chss_rgst_lic_no",1);
						sheetObj.SetCellEditable(Row,"chss_veh_id_no",1);
						sheetObj.SetCellEditable(Row,"chss_tit_no",1);
						sheetObj.SetCellEditable(Row,"chss_als_no",1);
						sheetObj.SetCellEditable(Row,"n2nd_chss_als_no",1);
					}
				} else {
					sheetObj.SetCellValue(Row,"eq_tpsz_cd","",0);
					sheetObj.SetCellValue(Row,"mft_dt","",0);
					sheetObj.SetCellValue(Row,"chss_tare_wgt","",0);
					sheetObj.SetCellValue(Row,"chss_rgst_ste_cd","",0);
					sheetObj.SetCellValue(Row,"chss_rgst_yr","",0);
					sheetObj.SetCellValue(Row,"chss_rgst_exp_dt","",0);
					sheetObj.SetCellValue(Row,"chss_rgst_lic_no","",0);
					sheetObj.SetCellValue(Row,"chss_veh_id_no","",0);
					sheetObj.SetCellValue(Row,"chss_tit_no","",0);
					sheetObj.SetCellValue(Row,"chss_als_no","",0);
					sheetObj.SetCellValue(Row,"n2nd_chss_als_no","",0);
					sheetObj.SetCellValue(Row,"agreement_no","",0);
					sheetObj.SetCellValue(Row,"agmt_ver_no","",0);
					sheetObj.SetCellValue(Row,"cre_usr_id",document.forms[0].cre_id.value,0);
					sheetObj.SetCellValue(Row,"vndr_seq","",0);
					sheetObj.SetCellValue(Row,"agmt_lstm_cd","",0);
					sheetObj.SetCellEditable(Row, "eq_tpsz_cd",0);
					sheetObj.SetCellEditable(Row, "mft_dt",0);
					sheetObj.SetCellEditable(Row, "chss_tare_wgt",0);
					sheetObj.SetCellEditable(Row, "chss_rgst_ste_cd",0);
					sheetObj.SetCellEditable(Row, "chss_rgst_yr",0);
					sheetObj.SetCellEditable(Row, "chss_rgst_exp_div",0);
					sheetObj.SetCellEditable(Row,"chss_rgst_exp_dt",0);
					sheetObj.SetCellEditable(Row,"chss_rgst_lic_no",0);
					sheetObj.SetCellEditable(Row,"chss_veh_id_no",0);
					sheetObj.SetCellEditable(Row,"chss_tit_no",0);
					sheetObj.SetCellEditable(Row,"chss_als_no",0);
					sheetObj.SetCellEditable(Row,"n2nd_chss_als_no",0);
				}
				if(sheetObj.GetCellValue(Row, "chss_rgst_exp_div") == 'P'){
					sheetObj.SetCellEditable(Row, "chss_rgst_exp_dt",0);
				} else {
					sheetObj.SetCellEditable(Row, "chss_rgst_exp_dt",1);
				}
				sheetObj.SetCellEditable(Row, "chss_rgst_exp_div",1);
				break;
			case "chss_veh_id_no":
				if(sheetObj.GetCellValue(Row, "chss_veh_id_no") == "" || sheetObj.GetCellValue(Row, "chss_veh_id_no") == null){
			    	return;
			    } else {
					formObj.chss_veh_id_no_tmp.value=sheetObj.GetCellValue(Row, "chss_veh_id_no");
					formObj.eq_no.value=sheetObj.GetCellValue(Row, "eq_no");
					formObj.chss_als_no_tmp.value=sheetObj.GetCellValue(Row, "chss_als_no");
					formObj.chss_tit_no_tmp.value=sheetObj.GetCellValue(Row, "chss_tit_no");
					formObj.n2nd_chss_als_no_tmp.value=sheetObj.GetCellValue(Row, "n2nd_chss_als_no");
					formObj.f_cmd.value=SEARCH03;
					var sXml=sheetObj.GetSearchData("EES_CGM_1008GS.do", FormQueryString(formObj));
				    var dataCount=ComGetTotalRows(sXml);
				    if(dataCount > 0){
				    	ComShowCodeMessage("CGM10017", DomXml2String(sXml, "eq_no"));
				    	sheetObj.SetCellValue(Row, Col,"",0);
				    	sheetObj.SelectCell(Row, Col, true);
				    } else {
				    	return;
				    }
			    }
				break;
			case "chss_tit_no":
				if(sheetObj.GetCellValue(Row, "chss_tit_no") == "" || sheetObj.GetCellValue(Row, "chss_tit_no") == null){
			    	return;
			    } else {
					formObj.chss_veh_id_no_tmp.value=sheetObj.GetCellValue(Row, "chss_veh_id_no");
					formObj.eq_no.value=sheetObj.GetCellValue(Row, "eq_no");
					formObj.chss_als_no_tmp.value=sheetObj.GetCellValue(Row, "chss_als_no");
					formObj.chss_tit_no_tmp.value=sheetObj.GetCellValue(Row, "chss_tit_no");
					formObj.n2nd_chss_als_no_tmp.value=sheetObj.GetCellValue(Row, "n2nd_chss_als_no");
					formObj.f_cmd.value=SEARCH03;
					var sXml=sheetObj.GetSearchData("EES_CGM_1008GS.do", FormQueryString(formObj));
					var dataCount=ComGetTotalRows(sXml);
					if(dataCount > 0){
				    	ComShowCodeMessage("CGM10017", DomXml2String(sXml, "eq_no"));
				    	sheetObj.SetCellValue(Row, Col,"",0);
				    	sheetObj.SelectCell(Row, Col, true);
				    } else {
				    	return;
				    }
				}
				break;
			case "chss_als_no":
				if(sheetObj.GetCellValue(Row, "chss_als_no") == "" || sheetObj.GetCellValue(Row, "chss_als_no") == null){
			    	return;
			    } else {
					formObj.chss_veh_id_no_tmp.value=sheetObj.GetCellValue(Row, "chss_veh_id_no");
					formObj.eq_no.value=sheetObj.GetCellValue(Row, "eq_no");
					formObj.chss_als_no_tmp.value=sheetObj.GetCellValue(Row, "chss_als_no");
					formObj.chss_tit_no_tmp.value=sheetObj.GetCellValue(Row, "chss_tit_no");
					formObj.n2nd_chss_als_no_tmp.value=sheetObj.GetCellValue(Row, "n2nd_chss_als_no");
					formObj.f_cmd.value=SEARCH03;
					var sXml=sheetObj.GetSearchData("EES_CGM_1008GS.do" , FormQueryString(formObj));
					var dataCount=ComGetTotalRows(sXml);
				    if(dataCount > 0){
				    	ComShowCodeMessage("CGM10017", DomXml2String(sXml, "eq_no"));
				    	sheetObj.SetCellValue(Row, Col,"",0);
				    	sheetObj.SelectCell(Row, Col, true);
				    } else {
				    	if(sheetObj.GetCellValue(Row, "chss_als_no") == sheetObj.GetCellValue(Row, "n2nd_chss_als_no"))
				    	{
							ComShowCodeMessage("CGM10017","Alias No1");
				    		sheetObj.SetCellValue(Row, Col,"",0);
				    		sheetObj.SelectCell(Row, Col, true);
				    	}
				    	return;
				    }
			    }
				break;
			case "n2nd_chss_als_no":
				if(sheetObj.GetCellValue(Row, "n2nd_chss_als_no") == "" || sheetObj.GetCellValue(Row, "n2nd_chss_als_no") == null){
			    	return;
			    } else {
					formObj.chss_veh_id_no_tmp.value=sheetObj.GetCellValue(Row, "chss_veh_id_no");
					formObj.eq_no.value=sheetObj.GetCellValue(Row, "eq_no");
					formObj.chss_als_no_tmp.value=sheetObj.GetCellValue(Row, "chss_als_no");
					formObj.chss_tit_no_tmp.value=sheetObj.GetCellValue(Row, "chss_tit_no");
					formObj.n2nd_chss_als_no_tmp.value=sheetObj.GetCellValue(Row, "n2nd_chss_als_no");
					formObj.f_cmd.value=SEARCH03;
					var sXml=sheetObj.GetSearchData("EES_CGM_1008GS.do" , FormQueryString(formObj));
					// data count
					var dataCount=ComGetTotalRows(sXml);
				    if(dataCount > 0){
				    	ComShowCodeMessage("CGM10017", DomXml2String(sXml, "eq_no"));
				    	sheetObj.SetCellValue(Row, Col,"",0);
				    	sheetObj.SelectCell(Row, Col, true);
				    } else {
				    	if(sheetObj.GetCellValue(Row, "chss_als_no") == sheetObj.GetCellValue(Row, "n2nd_chss_als_no"))
				    	{
							ComShowCodeMessage("CGM10017","Alias No2");
				    		sheetObj.SetCellValue(Row, Col,"",0);
				    		sheetObj.SelectCell(Row, Col, true);
				    	}
				    	return;
				    }
			    }
				break;
				
			case "chss_rgst_exp_div":
				if(GetCellValue(Row, "chss_rgst_exp_div") == 'F'){
					SetCellEditable(Row, "chss_rgst_exp_dt",1);
				} else {
					SetCellValue(Row, "chss_rgst_exp_dt","",0);
					SetCellEditable(Row, "chss_rgst_exp_dt",0);
				}
				break;
			}
		}
	}
	/**
	 * key input limit
	 */
//	function obj_keypress(){
//		 obj=event.srcElement;
//		 if(obj.dataformat == null){
//			 return;
//		 }
//		 window.defaultStatus=obj.dataformat;
//		 switch(obj.dataformat) {
//	  	    case "engup":
//	    		ComKeyOnlyAlphabet("uppernum");
//		        break;
//	  	    case "enghi":
//	  	    	ComKeyOnlyAlphabet("upper");
//	  	    	break;
//		    case "isnum":
//		    	ComKeyOnlyNumber(obj);
//		    	break;
//		    case "int":
//	 	    	ComKeyOnlyNumber(obj);
//	 	        break;
//	  	 	case "ymd":
//	  	 		ComKeyOnlyNumber(obj);
//	  	        break;
//	  	 	case "ym":
//	  	 		ComKeyOnlyNumber(obj);
//	  	        break;
//	  	 	case "hm":
//	  	 		ComKeyOnlyNumber(obj);
//	  	        break;
//		 }
//	}
	/**
	 * AXON event handling
	 */
	function obj_activate(){
	    ComClearSeparator(ComGetEvent());
	}
	/** 
	 * OBJECT DEACTIVATE event handler  <br>
	 */
	function obj_deactivate(){
		var formObj=document.form;
		obj=ComGetEvent();
		if(obj.name == "onh_dt"){
			with(formObj){
				var creDtFr=ComReplaceStr(onh_dt.value, "-", "");
			}
	        ComChkObjValid(event.srcElement);
		}
	   else if(obj.name == "onh_dt_hm"){
			with(formObj){
				var onhDtHm=ComReplaceStr(onh_dt_hm.value, ":", "");
			}
			ComChkObjValid(ComGetEvent());
		}
	}
	/**
	 * inserting value from PROGRAMNO POPUP
	 */   
	function setProgramNo(aryPopupData, row, col, sheetIdx){
		 var formObj=document.form;
		 var sheetObj=sheetObjects[0];
		 var agreeNo="";
		 var referNo="";
		 var lessNm="";
		 var lstmCd="";
		 var vndrSq="";
		 var agmtVerNo="";
		 var i=0;
		 for(i=0; i < aryPopupData.length; i++){
			 vndrSq=vndrSq  + aryPopupData[i][5];  // vndr_seq
			 agreeNo=agreeNo + aryPopupData[i][2];  // agreement_no
			 referNo=referNo + aryPopupData[i][3];  // reference_no
			 lstmCd=lstmCd  + aryPopupData[i][4];  // lease term
			 lessNm=lessNm  + aryPopupData[i][6];  // lessor
			 agmtVerNo=aryPopupData[i][11];  // lessor
		 }
	     if(formObj.ownleas[0].checked == true  ){
	    	 if(lstmCd !="OW" && lstmCd !="OL" && lstmCd !="LP"){
	    		 ComShowCodeMessage('CGM10066',agreeNo);
	        	 return false;
	    	 } else {
	    		 formObj.vndr_seq.value=vndrSq;
	    		 formObj.agreement_no.value=agreeNo;
	    		 formObj.agmt_ref_no.value=referNo;
	    		 formObj.agmt_lstm_cd.value=lstmCd;
	    		 // AGREEMENT NO POST PROCESS CALL
	    		 formObj.vndr_lgl_eng_nm.value=lessNm;
	    		 formObj.agmt_ver_no.value=agmtVerNo;
	    		 agreementNoChk(lstmCd);
	    	 }
	     } else if(formObj.ownleas[1].checked == true ){
	    	 if(lstmCd =="OW" || lstmCd =="OL" || lstmCd =="LP"){
	    		 ComShowCodeMessage('CGM10065',agreeNo);
	        	 return false;
	    	 }  else if(lstmCd =="CP"  ){
	       		 ComShowCodeMessage('CGM10029');
	           	 return false;
	    	 } else {
	    		 formObj.vndr_seq.value=vndrSq;
	    		 formObj.agreement_no.value=agreeNo;
	    		 formObj.agmt_ref_no.value=referNo;
	    		 formObj.agmt_lstm_cd.value=lstmCd;
	    		 // AGREEMENT NO POST PROCESS CALL
	    		 formObj.vndr_lgl_eng_nm.value=lessNm;
	    		 formObj.agmt_ver_no.value=agmtVerNo;
	    		 agreementNoChk(lstmCd);
	    	 }
	     }
	}
	/**
	 * AGREEMENT NO POST PROCESS CALL
	 */
	function agreementNoChk(lstmCd){
		var formObj=document.form;
		if(formObj.ownleas[0].checked == true){
			if(!(lstmCd == "OW" || lstmCd == "OL" || lstmCd =="LP")){
				// show message, object reset
				ComShowCodeMessage('CGM10029');
				formObj.agreement_no.value="";
				formObj.agmt_ref_no.value="";
				formObj.agmt_lstm_cd.value="";
				formObj.vndr_lgl_eng_nm.value="";
	//			formObj.agreement_no.focus();
			}
		}
	}
	/**
	 * Object Keydown event handling  <br>
	 * press enter retrieve action in case of agreement_no status.  <br>
	 */ 
//	function obj_keydown(){
//		var obj=event.srcElement;
//	    var sheetObj=sheetObjects[0];
//	    var formObj=document.form;
//	    switch(ComGetEvent("name")){
//	    case 'agreement_no':
//	//    	var keyValue = null;
//	//        if(event == undefined || event == null) {
//	//        	keyValue = 13;
//	//        } else {
//	//        	keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
//	//        }
//	//
//	//        if(keyValue != 13) return;
//	//            	
//	//    	var agmtNo = formObj.agreement_no.value;
//	//    	var result = true;
//	//    	 		
//	//    	if(agmtNo != ""){
//	//    		if(agmtNo.length <= 3){
//	//    			result = false;
//	//    		} else {
//	//    			if(ComIsNumber(agmtNo.substring(3))==false){
//	//    				result = false;
//	//    			}
//	//    		}
//	//    	} else {
//	//    		result = true;
//	//    	}
//	//
//	//    	if(!result){
//	//    		ComShowCodeMessage('CGM10004','Agreement No.');
//	//    		formObj.agreement_no.value = "";
//	//    	 	ComSetFocus(formObj.agreement_no);
//	//    	} else {
//	//    		if(!doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01)){
//	////    			formObj.agreement_no.focus();
//	//    		} else {
//	//    			ComKeyEnter();
//	//    		}
//	//    	}
//	//    	break;
//	    }
//	}
	/**
	 *  ROW deleting 
	 */
	function rowDelete(sheetObj){
		for(i=sheetObj.RowCount(); i>0; i--){
	if(sheetObj.GetCellValue(i, "ibflag") != ""   &&  sheetObj.GetCellValue(i, "del_chk") == "1") {
				sheetObj.RowDelete(i, false);
			}
		}
	}
	function sheet1_OnPopupClick(sheetObj, row, col){
		switch (sheetObj.ColSaveName(col)) {
		case "mft_dt" :
			if (sheetObj.ColSaveName(col) != "mft_dt"){
				return;
			}
			var cal=new ComCalendarGrid("myCal");
			cal.select(sheetObj, row, col, 'yyyy-MM-dd');
			break;
		case "chss_rgst_exp_dt" :
			if (sheetObj.ColSaveName(col) != "chss_rgst_exp_dt"){
				return;
			}
			var cal=new ComCalendarGrid("myCal");
			cal.select(sheetObj, row, col, 'yyyy-MM-dd');
			break;
		}
	}
	/**
	 * OWN, Leased radio btn
	 */
	function obj_onclick(radioObj){
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if(formObj.ownleas[0].checked == true){
			formObj.own_lse.value="O";
		} else {
			formObj.own_lse.value="L";
		}
	}
	/** 
	 * Object  focusout event handling  <br>
	 * @param  
	 * @return 
	 * @author 
	 * @version 
	 */  
	    function obj_focusout(){
	    	 var formObj=document.form;
	    	 var sheetObj=sheetObjects[0]; 
	    	 obj=event.srcElement;
	    	 switch(ComGetEvent("name")){
	    	   case "onh_ofc_cd":
	    	 		if(formObj.onh_ofc_cd.value != ''){
	    	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
	    	 			Verify_Status_chk();
	    	 			break;
	    	 		} 
	    	 		break;
	    	   case "onh_yd_cd":
		    	    var onh_yd_cd;
			    	onh_yd_cd=formObj.onh_yd_cd.value;
			    	if (onh_yd_cd.length == 7) {
			    		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
			    	}
					break;
	    	   case "agreement_no":
	    		   if(formObj.agreement_no.value != ''){
	      	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
	      	 			Verify_Status_chk();
	      	 			break;
	    		   } else if(formObj.agreement_no.value == ''){
	    			   formObj.agmt_ref_no.value="";
	    			   formObj.agmt_lstm_cd.value="";
	    			   formObj.vndr_lgl_eng_nm.value="";
	    			   Verify_Status_chk();
	      	 			break;
	    		   }
	    		   break;
	    	   case "onh_dt":
	    		   if(formObj.onh_dt.value != ''){
	    			    if( ComGetUnMaskedValue(formObj.onh_dt.value, "ymd")  
	  	    			      > ComGetUnMaskedValue(formObj.form_day.value, "ymd") ){
//	      	 			if(formObj.onh_dt.value>formObj.form_day.value){
							ComShowCodeMessage("CGM10062");
	      	 				formObj.onh_dt.value="";
	      	 			}
	    		   } 
	    		   Verify_Status_chk();
	    		   break;
	    	   case "onh_dt_hm" :
		    	   Verify_Status_chk();
				   break;
	    	 }   
	    }
	    
	    function obj_change(){
	    	 var formObj=document.form;
	    	 var sheetObj=sheetObjects[0]; 
	    	 obj=event.srcElement;
	    	 switch(ComGetEvent("name")){
	    	   case "onh_ofc_cd":
	    	 		if(formObj.onh_ofc_cd.value != ''){
	    	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
	    	 			Verify_Status_chk();
	    	 			break;
	    	 		} 
	    	 		break;
	    	   case "onh_yd_cd":
		    	    var onh_yd_cd;
			    	onh_yd_cd=formObj.onh_yd_cd.value;
			    	if (onh_yd_cd.length == 7) {
			    		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
			    	}
					break;
	    	   case "agreement_no":
	    		   if(formObj.agreement_no.value != ''){
	      	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
	      	 			Verify_Status_chk();
	      	 			break;
	    		   } else if(formObj.agreement_no.value == ''){
	    			   formObj.agmt_ref_no.value="";
	    			   formObj.agmt_lstm_cd.value="";
	    			   formObj.vndr_lgl_eng_nm.value="";
	    			   Verify_Status_chk();
	      	 			break;
	    		   }
	    		   break;
	    	   case "onh_dt":
	    		   if(formObj.onh_dt.value != ''){
	    			    if( ComGetUnMaskedValue(formObj.onh_dt.value, "ymd")  
	  	    			      > ComGetUnMaskedValue(formObj.form_day.value, "ymd") ){
//	      	 			if(formObj.onh_dt.value>formObj.form_day.value){
							ComShowCodeMessage("CGM10062");
	      	 				formObj.onh_dt.value="";
	      	 			}
	    		   } 
	    		   Verify_Status_chk();
	    		   break;
	    	   case "onh_dt_hm" :
		    	   Verify_Status_chk();
				   break;
	    	 }   
	    }
	     /**
	      * YA_CD value check
	      * @return
	      */
//	     function obj_keyup(){
//			 var formObj=document.form;
//			 var sheetObj=sheetObjects[0];
//			 obj=event.srcElement;
//			 switch(ComGetEvent("name")){
//			 	case "onh_yd_cd":
//			 		ComKeyEnter('lengthnextfocus');
//			    	break;
//			 }
//		}
	 /**
	  * OWN,Leased select -> init page 
	  * @param a
	  * @return
	  */
	    function chk(a){
	    	var formObj=document.form;
	    	 var sheetObj=sheetObjects[0]; 
	    	 sheetObj.RemoveAll();
				// HTML OBJECT RESET
	    	 formObj.reset();
	    	 if(a=="O"){
	    		 formObj.ownleas[0].checked=true;
	    	 } else {
	    		 formObj.ownleas[1].checked=true;
	    	 }
	    	 yard_Chk();
	    }
	    
	  function sheet1_OnSaveEnd(sheetObj, errMsg) {
		  if(errMsg =='') {   
			  ComShowCodeMessage('CGM00003');
	            for(i=sheetObj.LastRow(); i>0; i--){
	            	if(sheetObj.GetCellValue(i, "del_chk") == "1" ){
					  sheetObj.RowDelete(i, false);
				  } 
				}
			}
	  }    
	/**
	 * Form  Date yard control
	 * @return
	 * @author 
	 * @version 
	 */
	  function yard_Chk(){
		  formObj=document.form;
		  var l_chk ,f_chk;
		  var l_cName,f_cName;
		  if(formObj.ownleas[0].checked == true){
			  l_chk=true;
			  f_chk=false;
			  l_cName="input2";
			  formObj.agreement_no.value="";
		  } else {
	 		  l_chk=false;
	 		  f_chk=true;
			  l_cName="input1";
		  }
		  formObj.agreement_no.readOnly=l_chk;
	      ComEnableObject(formObj.ComOpenPopupWithTargetAgree, f_chk);
	      formObj.agreement_no.className=l_cName;
	}
	 /**
	  * yard and office check
	  * @param chk
	  * @return
	  */
	 function Matched_Chk(chk){
		 formObj=document.form;
		 var sheetObj=sheetObjects[0];
		 if(formObj.onh_yd_cd.value != "" && formObj.onh_ofc_cd.value != "" ){
			    formObj.f_cmd.value=SEARCH01;
			    formObj.ofc_cd.value=formObj.onh_ofc_cd.value;		//   ( location)
			    formObj.loc_cd.value=formObj.onh_yd_cd.value.substr(0,5);
			    var sXml=sheetObj.GetSearchData("cgm_Check_LocationGS.do", FormQueryString(formObj));
			    if(DomXml2String(sXml, "chk")!="OK"){
					ComShowCodeMessage("CGM10028");
					if(chk == 'Yard'){
						formObj.onh_yd_cd.value="";
					} else {
						formObj.onh_ofc_cd.value="";
					}
					return;
			    }
		 }
	 }
	 
	 function Verify_Status_chk(){
		 var sheetObj=sheetObjects[0];
		 for(i=1; i<sheetObj.RowCount()+1; i++){
			 sheetObj.SetCellValue(i, "verify","");
		 }
	 }