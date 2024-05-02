/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_fms_0033.js
*@FileTitle  : Reverse CSR for Sublet
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/17
=========================================================*/
/****************************************************************************************
  event classification code : [initializing]INIT=0; [inputting]ADD=1; [retrieving]SEARCH=2; [list retrieving]SEARCHLIST=3;
					[modifying]MODIFY=4; [deleting]REMOVE=5; [list deleting]REMOVELIST=6 [multiple handling]MULTI=7
					etc extra codes  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class esm_fms_0033 : esm_fms_0033 definition of biz script for creation screen
     */
//    function esm_fms_0033() {
//    	this.processButtonClick=tprocessButtonClick;
//    	this.setSheetObject=setSheetObject;
//    	this.loadPage=loadPage;
//    	this.initSheet=initSheet;
//    	this.doActionIBSheet=doActionIBSheet;
//    	this.validateForm=validateForm;
//    	this.setInvNo=setInvNo;
//    	this.setSlpIssDt=setSlpIssDt;
//    	this.initConfirm=initConfirm;
//    	this.inputReadOnly=inputReadOnly;
//    	this.initControl=initControl;
//    	this.obj_keypress=obj_keypress;
//    	this.eng_keypress=eng_keypress;
//    	this.obj_change=obj_change;
//    	this.obj_deactivate=obj_deactivate;
//    	this.sheet1_OnSearchEnd=sheet1_OnSearchEnd;
//    	this.sheet1_OnChange=sheet1_OnChange;
//    	this.setCsrSum=setCsrSum;
//    	this.sheet1_OnSaveEnd=sheet1_OnSaveEnd;
//    	this.sheet1_OnAfterEdit=sheet1_OnAfterEdit;
//    	this.sheet1_OnBeforeEdit=sheet1_OnBeforeEdit;
//    	this.setGetCellEditable=setGetCellEditable;
//    	this.obj_activate=obj_activate;
//    	this.initRdConfig=initRdConfig;
//    	this.eff_dt_change=eff_dt_change;
//    	this.sheet1_OnSearchEnd=sheet1_OnSearchEnd;
//    }
    // common global variables 
    var sheetObjects=new Array();
    var sheetCnt=0;
    var orgEffDate="";
    // Event handler processing by button click event*/
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
    	var sheetObject=sheetObjects[0];
    	var sheetObject1=sheetObjects[1];
    	var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		//if (!ComIsBtnEnable(srcName)) return;             //버튼 상태를 확인을 합니다.
				switch(srcName) {
					case "btn_Retrieve":
						if(!initConfirm()) return;
						if(form.btn_condition[0].checked) {
							form.search_type.value="inquiry";
						} else if(form.btn_condition[1].checked) {
							form.search_type.value="creation";
						}
						doActionIBSheet(sheetObject,formObject,IBSEARCH);
						break;
					case "btn_New":
						if(!initConfirm()) return;
	        			ComResetAll();
	        			setSlpIssDt();
	        			initDefaultDate();//NYK Modify 2014.10.15
	        			inputReadOnly(0);
	        			break;
					case "btn_Save":
						doActionIBSheet(sheetObject,formObject,IBSAVE);
						break;
					case "btn_slip":
						ComOpenWindowCenter("ESM_FMS_0041_1.do?popup=yes", "esm_fms_0041_1", 1024, 700, false);
						//ComOpenWindowCenter("ESM_FMS_0041.do?popup=yes", "esm_fms_0041", 1024, 590, false);
	    				break;
					case "btn_invNo":
						ComOpenPopup("ESM_FMS_00331.do", 650, 435, "setInvNo", "1,0,1,1,1", false, false, null, null, null, "esm_fms_00331");
						break;
					case "btn_effDt":
						orgEffDate=form.eff_dt.value;
	    				var cal=new ComCalendar();
	    				cal.setDisplayType('date');
	    				cal.setEndFunction('eff_dt_change');
						cal.select(form.eff_dt, 'yyyy-MM-dd');
						break;
					case "btn_condition":
						inputReadOnly(0);
						break;
					case "btn_Print":
	    				rdOpen(document.form);
	    				break;
				} // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
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
	 * * adding first-served functions after loading screen. 
	 */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
	        ComConfigSheet (sheetObjects[i] );
	        initSheet(sheetObjects[i],i+1);
	        ComEndConfigSheet(sheetObjects[i]);
		}
		initControl();
	    setSlpIssDt();
	    inputReadOnly(0);
	    initDefaultDate();//NYK Modify 2014.10.15
	    
	    resizeSheet();	    
	}
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} sheetNo Mandatory IBSheet Object Tag's ID Serial No
     * @return N/A
     * @author 
     */
    function initSheet(sheetObj,sheetNo) {
    	switch(sheetNo) {
	 		case 1:      //t1sheet1 init
	 		    with(sheetObj){
			 	      var HeadTitle1="|Sel|Seq|Acct Code|Customer Code|Customer Code|Center Code|City|Effective Date|Reversed AMT|Modified Slip AMT|slp_tp_cd|slp_func_cd|slp_ofc_cd|csr_curr_cd|inv_seq|vvd_eff_dt|vvd_exp_dt|flet_src_tp_cd|org_slp_tp_cd|org_slp_func_cd|org_slp_ofc_cd|org_iss_dt|org_slp_ser_no|flet_ctrt_no|csr_no";
			 	      var HeadTitle2="|Sel|Seq|Description|Description|Description|Description|Description|VVD Code|Key Number|Key Number|slp_tp_cd1|slp_func_cd1|slp_ofc_cd1|csr_curr_cd1|inv_seq1|vvd_eff_dt1|vvd_exp_dt1|flet_src_tp_cd1|org_slp_tp_cd1|org_slp_func_cd1|org_slp_ofc_cd1|org_iss_dt1|org_slp_ser_no1|flet_ctrt_no1|csr_no1";
			 	      var headCount=ComCountHeadTitle(HeadTitle1);
			 	      (headCount, 0, 0, true);
		
			 	      SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );
		
			 	      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
			 	      var headers = [ { Text:HeadTitle1, Align:"Center"},
			 	                  { Text:HeadTitle2, Align:"Center"} ];
			 	      InitHeaders(headers, info);
		
			 	      var cols = [[ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			 	             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"stl_flg" },
			 	             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
			 	             {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:1,   SaveName:"acct_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cust_cnt_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cust_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 	             {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:0,   SaveName:"ctr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 	             {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:0,   SaveName:"slp_loc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 	             {Type:"Date",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:0,   SaveName:"eff_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 	             {Type:"Float",     Hidden:0,  Width:130,  Align:"Right",   ColMerge:0,   SaveName:"csr_amt",           KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:0,   EditLen:18 },
			 	             {Type:"Float",     Hidden:0,  Width:130,  Align:"Right",   ColMerge:0,   SaveName:"rev_amt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			 	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"slp_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
			 	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"slp_func_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
			 	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"slp_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
			 	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"csr_curr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
			 	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"inv_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
			 	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"vvd_eff_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
			 	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"vvd_exp_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
			 	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"flet_src_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
			 	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"org_slp_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
			 	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"org_slp_func_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
			 	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"org_slp_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
			 	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"org_iss_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
			 	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"org_slp_ser_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
			 	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"flet_ctrt_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
			 	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"csr_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
			 	            ],[
			 	             {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag1" },
			 	             {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"stl_flg1",          KeyField:0 },
			 	             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq1" },
			 	             {Type:"Text",      Hidden:0,  Width:125,  Align:"Left",    ColMerge:1,   SaveName:"csr_desc",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:500 },
			 	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"csr_desc1",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:500 },
			 	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"csr_desc2",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:500 },
			 	             {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:0,   SaveName:"csr_desc3",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:500 },
			 	             {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:0,   SaveName:"csr_desc4",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:500 },
			 	             {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:0,   SaveName:"vvd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 	             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"to_inv_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 	             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"to_inv_no1",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"slp_tp_cd1",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
			 	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"slp_func_cd1",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
			 	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"slp_ofc_cd1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
			 	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"csr_curr_cd1",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
			 	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"inv_seq1",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
			 	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"vvd_eff_dt1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
			 	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"vvd_exp_dt1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
			 	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"flet_src_tp_cd1",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
			 	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"org_slp_tp_cd1",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
			 	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"org_slp_func_cd1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
			 	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"org_slp_ofc_cd1",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
			 	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"org_iss_dt1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
			 	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"org_slp_ser_no1",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
			 	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"flet_ctrt_no1",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
			 	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"csr_no1",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 } 
			 	             ]];

//			 	      InitColumns(cols);
			 	     InitColumns(cols , 2);
			 	      SetEditable(1);
			 	     SetDataAutoTrim(1);
			 	      SetSheetHeight(263);
	 	      }
	 		break;
	 	}
  	}
    /**
     * Handling IBSheet's process<br>
     */
    function doActionIBSheet(sheetObj,formObj,sAction,objNm) {
    	sheetObj.ShowDebugMsg(false);
    	switch(sAction) {
    		case IBSEARCH:      
  				if(objNm == "eff_dt") {
  					formObj.f_cmd.value=SEARCH09;
 		   			var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do" , ComReplaceStr(FormQueryString(form),"-",""));
		   			
 		   			var closFlg=ComGetEtcData(sXml, "clos_yn");
		   			var effDt=ComGetEtcData(sXml, "eff_dt");
		   			var oldEffDt=ComGetUnMaskedValue(formObj.eff_dt, "ymd");
				
		   			if (closFlg=="C"){
						//closed, and open item not exists
						if (ComTrim(effDt) == ""){
							//ComAlertFocus(formObj.eff_dt, ComGetMsg("FMS20009"), oldEffDt.substring(0,6));
							ComShowCodeMessage("FMS20009", oldEffDt.substring(0,6));
							formObj.eff_dt.value="";
							return;					
						}
						//closed, and user confirmed, setting next month 1 day
						if (ComShowCodeConfirm('FMS20010',oldEffDt, effDt)){
							formObj.eff_dt.value=effDt;
						}else{
							formObj.eff_dt.value="";
						}
					//before closing month, and before closing previous month
					}else if (closFlg=="X"){
						//Two or more un-closed month exist ! Do you want ignore it 
						//if (!ComShowCodeConfirm("FMS20011")){
						//	formObj.eff_dt.value="";
						//	formObj.eff_dt.focus();
						//}
					//in case of not existing data
					}else if (closFlg=="E"){
						ComShowCodeMessage("FMS20012", oldEffDt.substring(0,6));
						formObj.eff_dt.value="";
					}else{
						//dumy
					}
				} else if(objNm == "vvd_cd") {
					formObj.f_cmd.value=SEARCH06;
					var param="f_cmd=" + formObj.f_cmd.value + "&vvd_cd=" + formObj.vvd_cd.value;
 					var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do", param);
					if(CoFmsShowXmlMessage(sXml) != "") {
						formObj.vvd_cd.value="";
						ComAlertFocus(formObj.vvd_cd, CoFmsShowXmlMessage(sXml));
					}
				} else if(objNm == "csr_curr_cd") {
					form.f_cmd.value=SEARCH01;
					var param="f_cmd=" +  form.f_cmd.value + "&curr_cd=" + form.csr_curr_cd.value;
 					var sXml=sheetObj.GetSearchData("ESM_FMS_0076GS.do", param);
		   			var currNm=ComGetEtcData(sXml, "currCd");
		   			if(typeof currNm == "undefined" || currNm == "" ) {
		   				form.csr_curr_cd.value="";
		   				ComAlertFocus(formObj.csr_curr_cd, ComGetMsg("FMS00006", "Currency"));
		   			}
				} else {
					if(validateForm(sheetObj,formObj,sAction)) {
	        			formObj.f_cmd.value=SEARCH;
	        			var vsl_cd="";
	        			if(formObj.btn_condition[0].checked) {
	        				vsl_cd=formObj.to_inv_no.value.substring(4,8);
	        	    	} else if(formObj.btn_condition[1].checked) {
	        	    		vsl_cd=formObj.vvd_cd.value.substring(0,4);
	        	    	}
	        			if("" == vsl_cd) {
	        				formObj.csr_desc.value="Reverse CSR from Approved Sublet Invoice";
	        			}else{
	        				formObj.csr_desc.value="Reverse CSR from Approved Sublet Invoice (" + vsl_cd + ")";
	        			}
	        			sheetObj.DoSearch("ESM_FMS_0033GS.do", FormQueryString(formObj) );
		   				inputReadOnly(1);
    				}
				} 
	 			break;
    		case IBSAVE:        
	    		if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value=MULTI;
					var param=FormQueryString(formObj) + "&" + ComFmsSetPrifix(sheetObjects[0].GetSaveString(),"sheet1_");
 					var sXml=sheetObj.GetSaveData("ESM_FMS_0033GS.do", param);
 					sheetObj.LoadSaveData(sXml);
//					inputReadOnly(1);
					//setCellEditable(sheetObj);
				}
    		case IBINSERT:      
    			break;
            	
			case IBSEARCH_ASYNC01: //NYK Modify 2014.10.14
				sheetObj.SetWaitImageVisible(0);
				var f_query = "";					
				f_query += "f_cmd=" + SEARCH; 
				f_query += "&csr_type="+formObj.csr_type.value;	 			
				f_query += "&slp_ofc_cd="+formObj.slp_ofc_cd.value; 
				
				var sXml = sheetObj.GetSearchData("FMS_COMGS.do",f_query);

	   			var varRqstDt = ComGetEtcData(sXml, "rqst_dt");
	   			var varEffDt = ComGetEtcData(sXml, "eff_dt");

	   			if(typeof varEffDt != "undefined" && varEffDt != "" ) {
					formObj.eff_dt.value = ComGetMaskedValue(varEffDt,"ymd");
				}
				sheetObj.SetWaitImageVisible(1);
				
				eff_dt_change();
				break;
    	}
    }
    /**
     * Handling process for input validation<br>
     */
    function validateForm(sheetObj,formObj,sAction){
		var exptElems="";
    	if(form.btn_condition[0].checked) {
    		exptElems="vvd_cd";
    	} else if(form.btn_condition[1].checked) {
    		exptElems="to_inv_no";
    	}
    	if (!ComFmsChkValid(formObj, exptElems)) {
    		return false;
    	}
     	if(sAction == IBSAVE) {
     		var cnt=0;
     		for(var row=2; row<=sheetObj.LastRow(); row++) {
     			if(row%2 == 0) {
     				if(sheetObj.GetCellValue(row, "stl_flg") == 1) {
     					cnt=cnt + 1;
     					if(sheetObj.GetCellValue(row, "csr_amt") == 0 ||
     							sheetObj.GetCellValue(row, "csr_amt") == "") {
     						ComShowCodeMessage("FMS00020", "Reserved AMT");
     						sheetObj.SelectCell(row, "csr_amt");
     						return false;
     					}
     					// --------------------------------------------------
     					// Checking to prevent inserting decimal point in case Currency is KRW or JPY
     					// --------------------------------------------------
     					var currCd=form.csr_curr_cd.value;
     					if(currCd == "KRW" || currCd == "JPY" || currCd == "PAB") {
     						var carAmt=sheetObj.GetCellValue(row, "csr_amt").replace(/,/g,'');
     						if(carAmt%parseInt(carAmt)) {
     							ComShowCodeMessage("FMS01476");
         						sheetObj.SelectCell(row, "csr_amt");
     							return false;
     						}
     					}
     					// --------------------------------------------------
     				}
     			} else {
     				if(sheetObj.GetCellValue(row-1, "stl_flg") == 1) {
     					if(sheetObj.GetCellValue(row, "csr_desc") == " ") {
     						ComShowCodeMessage("FMS00004", "Description");
     						sheetObj.SelectCell(row, "csr_desc");
     						return false;
     					}
     				}
     			}
        	}
     		if(cnt == 0) {
     			ComShowCodeMessage("FMS00007");
 	  			return false;
     		}
 	    	if(sheetObj.RowCount()== 0) {
 	  			ComShowCodeMessage("FMS00007");
 	  			return false;
 	  		}
 	    	//  Checking duplication of Customer Code
 	    	for(var i=2; i<sheetObj.LastRow(); i++) {
 	    		if(i%2 == 0) {
 	    			if(sheetObj.GetCellValue(i, "stl_flg") == 1) {
 	    				var sourceCustCode=sheetObj.GetCellValue(i, "cust_cnt_cd") + sheetObj.GetCellValue(i, "cust_seq");
		 	    		for(var j=i+1; j<=sheetObj.LastRow(); j++) {
		 	    			if(j%2 == 0) {
		 	    				if(sheetObj.GetCellValue(j, "stl_flg") == 1) {
		 	    					var targetCustCode=sheetObj.GetCellValue(j, "cust_cnt_cd") + sheetObj.GetCellValue(j, "cust_seq");
				 	    			if(sourceCustCode != targetCustCode) {
				 	    				ComShowCodeMessage("FMS01472");
				 	    				return false;
				 	    			}
		 	    				}
		 	    			}
		 	    		}
	 	    		}
 	    		}
 	    	}
     	}else if( sAction == IBSEARCH){
     		if(form.btn_condition[0].checked) {
        		if("" == form.to_inv_no.value ){
        			ComShowCodeMessage("FMS00004", "Invoice No.");
	    			return false;
        		}
        	} else if(form.btn_condition[1].checked) {
        		if("" == form.vvd_cd.value ){
        			ComShowCodeMessage("FMS00004", "VVD");
	    			return false;
        		}
        	}
     		
     	}
     	return true;
    }
    /**
   	 *  Setting Invoice No. selected on RCS/Invoice No Inquiry PopUp into Form item<br>
   	 * @param {arry} aryPopupData
   	 */
   	function setInvNo(aryPopupData) {
   		form.to_inv_no.value=aryPopupData[0][3];
   	}
   	/**
  	 * Setting current date into slp_iss_dt<br>
  	 */
  	function setSlpIssDt() {
  		document.form.slp_iss_dt.value = ComFmsCurrentDate();
  	}
  	/**
     * Checking whether to go ahead when other work is occured in case changed data is existing<br>
     **/
    function initConfirm() {
 	    var okYn=true;
 	    if(sheetObjects[0].IsDataModified()) {
 	    	var okYn=ComShowCodeConfirm("FMS00002");
 	    }
 	    return okYn;
    }
    /**
     *  Setting whether to use the Object by Condition<br>
     **/
    function inputReadOnly(flag) {
    	 if(flag == 0) {
	    	if(form.btn_condition[0].checked) {
				form.to_inv_no.readOnly=false;
				var existClass = $("#to_inv_no").attr("class");
				$("#to_inv_no").removeClass(existClass).addClass("input1");

				var existClass1 = $("#vvd_cd").attr("class");
				$("#vvd_cd").removeClass(existClass1).addClass("input2");
				
	   			form.vvd_cd.readOnly=true;
	   			form.vvd_cd.value="";
	   			
	   			form.btn_invNo.name="btn_invNo";
		    	form.btn_invNo.style.cursor="hand";
		    	
		    	if(form.search_type.value == "creation") {
		    		//form.eff_dt.value="";
		    		form.csr_desc.value="";
		    		form.csr_amt.value="";
		    		sheetObjects[0].RemoveAll();
		    	}
			} else if(form.btn_condition[1].checked) {
				form.to_inv_no.readOnly=true;
	   			form.to_inv_no.value="";
	   			
	   			var existClass = $("#to_inv_no").attr("class");
				$("#to_inv_no").removeClass(existClass).addClass("input2");
								
				var existClass1 = $("#vvd_cd").attr("class");
				$("#vvd_cd").removeClass(existClass1).addClass("input1");
				
				form.vvd_cd.readOnly=false;
				
				form.btn_invNo.name="no_btn_invNo";
		    	form.btn_invNo.style.cursor="default";
		    	
		    	if(form.search_type.value == "inquiry") {
		    		//form.eff_dt.value="";
		    		form.csr_desc.value="";
		    		form.csr_amt.value="";
		    		sheetObjects[0].RemoveAll();
		    	}
			}
	    	form.btn_condition[0].disabled=false;
	    	form.btn_condition[1].disabled=false;
	    	form.eff_dt.readOnly=false;
	    	form.csr_curr_cd.readOnly=false;
	    	
	    	form.btn_effDt.name="btn_effDt";
   		 	form.btn_effDt.style.cursor="hand";
   		 	ComBtnEnable("btn_Retrieve");
    	} else if(flag == 1) {
            form.btn_condition[0].disabled=true;
    		form.btn_condition[1].disabled=true;
    		
    		form.to_inv_no.readOnly=true;
    		form.btn_invNo.readOnly=true;
    		
    		form.vvd_cd.readOnly=true;
    		
    		form.eff_dt.readOnly=true;
    		form.btn_effDt.readOnly=true;
    		
    		form.csr_curr_cd.readOnly=true;
    		
    		form.btn_invNo.style.cursor="default";
    		form.btn_invNo.name="no_btn_effDt";
    		
    		form.btn_effDt.style.cursor="default";
    		form.btn_effDt.name="no_btn_invNo";
    		
    		ComBtnDisable("btn_Retrieve");
    	}
    }
    /**
  	 * Loading Event of HTML_Control existing on page dynamically <br>
  	 * Calling the function from {@link #loadPage} to initialize IBSheet Object <br>
  	 * @param {ibsheet} sheetObj    IBSheet Object
  	 * @param {int}     sheetNo     sequence of sheetObjects array
  	 **/
  	function initControl() {
  		//Axon Event Handling1. Event catch
  		axon_event.addListenerForm  ('blur', 'obj_deactivate', form); 					//- form Code Handling to OnBeforeDeactivate(blur) Event of All Controls
  		//axon_event.addListenerFormat('keypress'	, 'obj_keypress', form); 			//- form Code Handling to onkeypress Event of All Controls having dataformat attribute
  		//axon_event.addListenerForm  ('keypress'	, 'eng_keypress', form); 			//- form Code Handling to onkeypress Event of All Controls
  		axon_event.addListenerForm  ('change'	, 'obj_change', form); 				//- form Code Handling to OnChange Event of All Controls
  		axon_event.addListenerForm  ('beforeactivate', 'obj_activate', form); 					//- form Code Handling to OnFocus Event of All Controls
  	}

    /**
     * Checking eff_dt, vvd_cd, csr_curr_cd in onchange Event of HTML Control<br>
     */
	function obj_change() {
		if((event.srcElement.name == "eff_dt")) {
			if (form.eff_dt.value != "" && ComIsDate(form.eff_dt.value)) {
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "eff_dt");
        	}
		} else if((event.srcElement.name == "vvd_cd") && (form.vvd_cd.value.length == 10)) {
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"vvd_cd");
		} else if((event.srcElement.name == "csr_curr_cd") && (form.csr_curr_cd.value.length == 3)) {
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"csr_curr_cd");
		}
	}

    /**
     * Setting flet_ctrt_no, csr_curr_cd into Form item in case OnSearchEnd Event of Sheet1  is occurred<br>
     */
    function sheet1_OnSearchEnd(sheetObj, errMsg) {
    	if(sheetObjects[0].RowCount()> 0) {
    		form.flet_ctrt_no.value=sheetObjects[0].GetCellValue(2, "flet_ctrt_no");
    		form.csr_curr_cd.value=sheetObjects[0].GetCellValue(2, "csr_curr_cd");
  	    } else {
  	    	form.csr_amt.value="0";
  	    }
  	}
    /**
     * Calculating Total Sum of Reserved AMT in case OnChange Event of Sheet1 is occurred<br>
     */
    function sheet1_OnChange(sheetObj, row, col, value) {
        if(col == 1 || col == 9) {
        	setCsrSum(sheetObj);
        }
    }
    /**
     * Calculating Total Amount<br>
     */
    function setCsrSum(sheetObj) {
    	var csrAmt=0;
    	for(var row=2; row<=sheetObj.LastRow(); row++) {
 			if(row%2 == 0) {
 				if(sheetObj.GetCellValue(row, "stl_flg") == 1) {
 					csrAmt=csrAmt + sheetObj.GetCellValue(row, "csr_amt")*1;
 				}
 			}
    	}
    	form.csr_amt.value=ComAddComma(CoFmsRound(csrAmt, 2));
		form.rqst_amt.value=ComAddComma(CoFmsRound(csrAmt, 2));
    }    
    /**
     * Setting Bond No<br>
     */
    function sheet1_OnSaveEnd(errMsg) {
    	if(sheetObjects[0].RowCount()> 0) {
    		if(sheetObjects[0].GetCellValue(2, "csr_no") != "") {
    			form.csr_no.value=sheetObjects[0].GetCellValue(2, "csr_no");
	   	    	inputReadOnly(1);
				//setCellEditable(sheetObj);
    		}
   	    } else {
   	    	form.csr_amt.value="0";
   	    	form.rqst_amt.value="0";
   	    }
    }
    /**
     *  In OnAfterEdit Event of Sheet1, in case Description value doesnt exists, Handling it as Space as column merge can be broken<br>
     */
    function sheet1_OnAfterEdit(sheetObj, row, col) {
    	if((row%2 > 0) && (col == 3)) {
    		if (sheetObj.GetCellValue(row,"csr_desc") == "") {
     	    	sheetObj.SetCellValue(row,"csr_desc"," ",0);
     		    sheetObj.SetCellValue(row,"csr_desc1"," ",0);
     		    sheetObj.SetCellValue(row,"csr_desc2"," ",0);
     		    sheetObj.SetCellValue(row,"csr_desc3"," ",0);
     		    sheetObj.SetCellValue(row,"csr_desc4"," ",0);
     		}
     	}
    }
    /**
     *  In OnBeforeEdit Event of Sheet1, in case Description is Space, Removing the Space to insert certain value<br>
     */
    function sheet1_OnBeforeEdit(sheetObj, row, col) {
        if((row%2 > 0) && (col == 3)) {
        	if (sheetObj.GetCellValue(row,"csr_desc") == " ") {
    		    sheetObj.SetCellValue(row,"csr_desc","");
    		}
    	}
    }
    /**
     *  Prevent Modifying items after Saving<br>
     */
    function setGetCellEditable(sheetObj) {
 		for(var row=2; row<=sheetObj.LastRow(); row++) {
 			if(row%2 == 0) {
 				sheetObj.SetCellEditable(row, "stl_flg",0);
 				sheetObj.SetCellEditable(row, "csr_amt",0);
 			} else {
 				sheetObj.SetCellEditable(row, "stl_flg1",0);
	 			sheetObj.SetCellEditable(row, "csr_desc",0);
	 			sheetObj.SetCellEditable(row, "csr_desc1",0);
	 			sheetObj.SetCellEditable(row, "csr_desc2",0);
	 			sheetObj.SetCellEditable(row, "csr_desc3",0);
 			}
 		}
    }
    /**
     * Removing Mask Separator in onfocus Event of HTML Control<br>
     */
    function obj_activate() {
    	ComClearSeparator(event.srcElement);
    }
    /**
   	 * loading RD Object existing in Page <br>
   	 * Initializing RD Object by calling this function from {@link #loadPage} <br>
   	 * @param {rdObject} rdObject    RD Object
   	 **/
   	function initRdConfig(rdObject){
   	    var Rdviewer=rdObject ;
   	    Rdviewer.style.height = 0;
   	    Rdviewer.style.width=0;
   	    Rdviewer.AutoAdjust=true;
   	    Rdviewer.ViewShowMode(0);
   		Rdviewer.SetBackgroundColor(128,128,128);
   		Rdviewer.SetPageLineColor(128,128,128);
   		Rdviewer.ApplyLicense("0.0.0.0"); 
   	}
   	/**
   	 * Printing Retrieved Data<br>
   	 */
   	function rdOpen(formObject){
  		if(sheetObjects[0].RowCount()== 0) {
  			ComShowCodeMessage("FMS00015");
  			return;
  		}
  		if(formObject.csr_no.value == "") {
  			ComShowCodeMessage("FMS00015");
  			return;
 		}
  		
  		var rdParam = '/rv '+ RD_FormQueryString(formObject,1);
		var rdFile = 'apps/opus/esm/fms/timecharterinoutaccounting/tcharterioconsultation/report/ESM_FMS_031.mrd';

 		formObject.com_mrdPath.value = rdFile;
 		formObject.com_mrdArguments.value = rdParam;
 	    ComOpenRDPopup();
 	}
    /**
   	 * Excuting Change Event in case of setting date by Calendar Object<br>
   	 */
   	function eff_dt_change() {
   		if (form.eff_dt.value != "" && ComIsDate(form.eff_dt.value)) {
   			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "eff_dt");
      	}else{
      		ComAlertFocus(form.eff_dt, ComGetMsg("FMS01565"));
      	}   		
   	}
   	/**
     * Changing VVD Code, Font of City in case OnSearchEnd Event in Sheet1 is occurred<br>
     */
    function sheet1_OnSearchEnd(sheetObj, errMsg) {
    	for(var i=2; i<=sheetObj.LastRow(); i++) {
    		sheetObj.GetEtcData("")
    		if(i%2 > 0) {
     			sheetObj.SetCellFont("FontName", i, "vvd_cd","Courier New");
    		} else {
     			sheetObj.SetCellFont("FontName", i, "slp_loc_cd","Courier New");
    		}
    	}
    }
    
    //NYK Modify 2014.10.14
    function initDefaultDate(){
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);    	
    }

    function resizeSheet(){
        for (i=0; i<sheetObjects.length; i++){
            ComResizeSheet(sheetObjects[i], 70);
        }
    }
    