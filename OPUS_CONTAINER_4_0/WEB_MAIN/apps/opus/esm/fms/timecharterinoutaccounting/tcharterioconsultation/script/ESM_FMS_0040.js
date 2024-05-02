/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_fms_0040.jsp
*@FileTitle  : Manual Slip
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19
=========================================================*/
/****************************************************************************************
  event classification code : [initializing]INIT=0; [inputting]ADD=1; [retrieving]SEARCH=2; [list retrieving]SEARCHLIST=3;
					[modifying]MODIFY=4; [deleting]REMOVE=5; [list deleting]REMOVELIST=6 [multiple handling]MULTI=7
					etc extra codes  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class esm_fms_0040 : esm_fms_0040 definition of biz script for creation screen
     */

    // common global variables 
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event*/
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
        var sheetObject=sheetObjects[0];
        var sheetObject1=sheetObjects[1];
        var sheetObject2=sheetObjects[2];
        var formObject=document.form;
        try {
        	var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
    		switch(srcName) {
    			case "btn_Brokerage":
    				if(validateForm(sheetObject,formObject)) {
	    			  	for (var row=sheetObject.LastRow(); row >= sheetObject.HeaderRows(); row--) {
	    			  		if(sheetObject.GetCellValue(row, "flet_ctrt_no") != "") {
	    						sheetObject.SetRowHidden(row,1);
	    						sheetObject.SetRowStatus(row,"D");
	    					}
	    				}
	    			  	curr_cd=form.csr_curr_cd.value;
    					ComOpenPopup("ESM_FMS_00401.do?curr_cd="+curr_cd, 1100, 395, "setCsulSlp", "0,1,1,1,1", true, false, null, null, null, "esm_fms_00401");
    				}
					break;
    			case "btn_RowAdd":
    				if(validateForm(sheetObject,formObject)) {
						var row=sheetObject.DataInsert(-1);
						setSheetInfo(row);
					}
					break;
    			case "btn_RowDel":
    				ComRowHideDelete(sheetObject, "DelChk");
    				setDrDiff();
					break;
    			case "btn_New":
    				if(!initConfirm()) return;
        			ComResetAll();
        			setSlpIssDt();
        			initDefaultDate();
        			inputReadOnly("0");
					break;
    			case "btn_Save":
    				doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;
    			case "btn_TaxEvidence":
    				if(validateForm(sheetObject,formObject,IBSEARCH) == false) return;
	        		// TAX Classification(only TAX/CI)
	        		var evid_tp_cd=evid_tp_cd.value;
	        		// Effective DT Value
	        		var tax_inv_yrmon=formObject.eff_dt.value;
	        		ComOpenPopup("ESM_FMS_0029.do?tax_inv_yrmon="+tax_inv_yrmon+"&evid_tp_cd="+evid_tp_cd, 917, 562,"setTaxEvidence", "1,0,1,1,1", false);
	        		break;
    			case "btn_SlipInquiry":
    				ComOpenWindowCenter("ESM_FMS_0041_1.do?popup=yes", "esm_fms_0041_1", 1024, 660, false);
    				//ComOpenWindowCenter("ESM_FMS_0041.do?popup=yes", "esm_fms_0041", 1024, 590, false);
					break;
    			case "btn_Print":
    				rdOpen(document.form);
					break;
    			case "btn_vndrSeq":
    				ComOpenPopup("ESM_FMS_0070.do?condFlag=VP", 620, 430, "setVndrSeq", "1,0,1,1,1", true);
    				break;
    			case "btn_effDt":
    				var cal=new ComCalendar();
    				cal.setDisplayType('date');
    				cal.setEndFunction('eff_dt_change');
					cal.select(form.eff_dt, 'yyyy-MM-dd');
    				break;
    			case "btn_rqstDt":
    				var cal=new ComCalendar();
    				cal.setDisplayType('date');
    				cal.setEndFunction('setRqstDt');
					cal.select(form.rqst_dt, 'yyyy-MM-dd');
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
        setSlpIssDt();
        sheet1_OnLoadFinish(sheetObjects[0]);
        
        initControl();

		//doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "slp_func_cd");
		//doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "evid_tp_cd");
        
        resizeSheet();        
    }
    /**
     * Prevent blinking of Sheet when calling DB after implementing onLoad Event Handler of body tag
     * * adding first-served functions after loading screen. 
     */
    function sheet1_OnLoadFinish(sheetObj) {  
    	sheetObj.SetWaitImageVisible(0);
    	doActionIBSheet(sheetObj, document.form, IBSEARCH, "slp_func_cd");
		doActionIBSheet(sheetObj, document.form, IBSEARCH, "combo_evid_tp_cd");
		initDefaultDate();
  		
  		//NYK Modify 2014.11.05 : Center Code, City 조회.
  		doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH);
		sheetObj.SetWaitImageVisible(1);
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
    	var cnt=0;
    	switch(sheetNo) {
    	 	case 1:
    	 	    with(sheetObj){
		    	      var HeadTitle1="|Sel.|Seq.|Acct Code|Vendor Code|Center Code|City|Effective Date|Slip Amount|Description|VVD Code|Key Number|csr_no|flet_ctrt_no|flet_iss_tp_cd|inv_seq|inv_dtl_seq";
		    	      var headCount=ComCountHeadTitle(HeadTitle1);
		
		    	      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		    	      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		    	      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		    	      InitHeaders(headers, info);
		
		    	      var cols = [ 
		    	             {Type:"Status",    Hidden:1, Width:30,  Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		    	             {Type:"DummyCheck",Hidden:0, Width:30,  Align:"Center",  ColMerge:1,   SaveName:"DelChk",   UpdateEdit:0 },
		    	             {Type:"Seq",       Hidden:0, Width:40,  Align:"Center",  ColMerge:1,   SaveName:"Seq" },
		    	             {Type:"Text",      Hidden:0, Width:80,  Align:"Center",  ColMerge:0,   SaveName:"acct_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6 },
		    	             {Type:"Text",      Hidden:0, Width:90,  Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
		    	             {Type:"Text",      Hidden:0, Width:90,  Align:"Center",  ColMerge:0,   SaveName:"ctr_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
		    	             {Type:"Text",      Hidden:0, Width:60,  Align:"Center",  ColMerge:0,   SaveName:"slp_loc_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
		    	             {Type:"Date",      Hidden:0, Width:90,  Align:"Center",  ColMerge:0,   SaveName:"eff_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Float",     Hidden:0, Width:150, Align:"Right",   ColMerge:0,   SaveName:"csr_amt",         KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1,   EditLen:18 },
		    	             {Type:"Text",      Hidden:0, Width:450, Align:"Left",    ColMerge:0,   SaveName:"csr_desc",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:500 },
		    	             {Type:"Text",      Hidden:0, Width:100, Align:"Center",  ColMerge:0,   SaveName:"vvd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:10 },
		    	             {Type:"Text",      Hidden:1, Width:80,  Align:"Center",  ColMerge:0,   SaveName:"to_inv_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:12 },
		    	             {Type:"Text",      Hidden:1, Width:1,   Align:"Center",  ColMerge:0,   SaveName:"csr_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:1, Width:1,   Align:"Center",  ColMerge:0,   SaveName:"flet_ctrt_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:1, Width:1,   Align:"Center",  ColMerge:0,   SaveName:"flet_iss_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:1, Width:1,   Align:"Center",  ColMerge:0,   SaveName:"inv_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:1, Width:1,   Align:"Center",  ColMerge:0,   SaveName:"inv_dtl_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		    	       
		    	      InitColumns(cols);
		    	      SetEditable(1);
		    	      SetSheetHeight(260);
		    	      SetColProperty(0 ,"acct_cd" , {AcceptKeys:"N"});
		    	      SetColProperty(0 ,"vndr_seq" , {AcceptKeys:"N"});
		    	      SetColProperty(0 ,"ctr_cd" , {AcceptKeys:"N"});
		    	      SetColProperty(0 ,"slp_loc_cd" , {AcceptKeys:"E"});		    	      		    	     		    	      
		    	      SetColProperty(0 ,"vvd_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
		    	      
    	            }
    	 		break;
    	 	case 2:      //sheet2
    	 	    with(sheetObj){
    	        var prefix="tax_";
		    	      var HeadTitle="|Seq|Sel|tax_inv_yrmon|ofc_cd|tax_iss_cd|tax_vat_tp_cd|tax_naid_flg|tax_div_cd|fa_flg|tax_pl_cd|tax_nsl_flg|spl_rgst_no|ownr_nm|co_nm|bzct_nm|bztp_nm|spl_addr|iss_dt|spl_amt|tax_amt|total_amt|SLP_TP_CD|SLP_FUNC_CD|SLP_OFC_CD|SLP_ISS_DT|SLP_SER_NO|CRE_USR_ID|UPD_USR_ID";
		    	      var headCount=ComCountHeadTitle(HeadTitle);
		    	      (headCount, 0, 0, true);
		
		    	      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		    	      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		    	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		    	      InitHeaders(headers, info);
		
		    	      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		    	             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq" },
		    	             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"DelChk" },
		    	             {Type:"Date",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:0,   SaveName:prefix+"tax_inv_yrmon", KeyField:0,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"tax_iss_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:0,  Width:134,  Align:"Center",  ColMerge:0,   SaveName:prefix+"tax_vat_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:0,  Width:161,  Align:"Center",  ColMerge:0,   SaveName:prefix+"tax_naid_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:0,  Width:161,  Align:"Center",  ColMerge:0,   SaveName:prefix+"tax_div_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:0,  Width:134,  Align:"Center",  ColMerge:0,   SaveName:prefix+"fa_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:0,  Width:99,   Align:"Right",   ColMerge:0,   SaveName:prefix+"tax_pl_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:0,  Width:134,  Align:"Center",  ColMerge:0,   SaveName:prefix+"tax_nsl_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:0,  Width:134,  Align:"Center",  ColMerge:0,   SaveName:prefix+"spl_rgst_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:0,  Width:161,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ownr_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:0,  Width:161,  Align:"Center",  ColMerge:0,   SaveName:prefix+"co_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:0,  Width:134,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bzct_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:0,  Width:134,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bztp_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:0,  Width:134,  Align:"Center",  ColMerge:0,   SaveName:prefix+"spl_addr",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
		    	             {Type:"Date",      Hidden:0,  Width:134,  Align:"Center",  ColMerge:0,   SaveName:prefix+"iss_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
		    	             {Type:"Float",     Hidden:0,  Width:134,  Align:"Center",  ColMerge:0,   SaveName:prefix+"spl_amt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:0 },
		    	             {Type:"Float",     Hidden:0,  Width:134,  Align:"Center",  ColMerge:0,   SaveName:prefix+"tax_amt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:0 },
		    	             {Type:"Float",     Hidden:0,  Width:134,  Align:"Center",  ColMerge:0,   SaveName:prefix+"total_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:prefix+"slp_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:prefix+"slp_func_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:prefix+"slp_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:1, Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix+"slp_iss_dt",    KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:prefix+"slp_ser_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"cre_usr_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"upd_usr_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		    	       
		    	      InitColumns(cols);
		    	      SetEditable(1);
		    	      SetSheetHeight(120);
    	            }


    	 		break;
	        case 3:      //sheet3
	            with(sheetObj){
			            var prefix="txd_";
			          var HeadTitle1=" |순번|Sel|품명|공급가액|세액|합계";
			          var headCount=ComCountHeadTitle(HeadTitle1);
			          (headCount, 0, 0, true);
		
			          SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
			          var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			          var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			          InitHeaders(headers, info);
		
			          var cols = [ {Type:"Status",    Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
			                 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tax_dtl_ser_no", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"DelChk" },
			                 {Type:"Text",      Hidden:0,  Width:440,  Align:"Center",  ColMerge:1,   SaveName:prefix+"itm_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"spl_amt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"tax_amt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"total_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 } ];
			           
			          InitColumns(cols);
		
			          SetEditable(1);
			          SetSheetHeight(120);
	                }
	            break;
    	}
    }
    /**
     * Handling IBSheet's process<br>
     */
    function doActionIBSheet(sheetObj, formObj, sAction, objNm, row) {
    	sheetObj.ShowDebugMsg(false);
    	switch(sAction) {
    		case IBSEARCH:      
	    		if(objNm == "csr_curr_cd") {
					form.f_cmd.value=SEARCH01;
					var param="f_cmd=" +  form.f_cmd.value + "&curr_cd=" + form.csr_curr_cd.value;
 					var sXml=sheetObj.GetSearchData("ESM_FMS_0076GS.do", param);
		   			var currNm=ComGetEtcData(sXml, "currCd");
		   			if(typeof currNm == "undefined" || currNm == "" ) {
		   				form.csr_curr_cd.value="";
		   				ComAlertFocus(formObj.csr_curr_cd, ComGetMsg("FMS00006", "Currency"));
		   			} else {
		   				// Handling as possible to change Proof Type not depend on Currency Validation
		   				/** 
		   				    if(currNm == "KRW") {
		   					evid_tp_cd.value="5";
		   					evid_tp_cd.disabled=true;
		   				} else {
		   					evid_tp_cd.disabled=false;
		   				} 
		   				*/ 
		   			}
	    		} else if(objNm == "slp_func_cd") {
    				CoFmsGetCombo("FORM", formObj, sheetObj, "CD02267", "slp_func_cd", "slp_func_cdText");
    				
    				for (var i=0;i<document.form.slp_func_cd.length;i++) {
    					if (document.form.slp_func_cd.options[i].value == "P") {
    						document.form.slp_func_cd.remove(i);
    						break;
    					}
    				}
	    		} else if(objNm == "combo_evid_tp_cd") {
    				//CoFmsGetTaxCombo("FORM", formObj, sheetObj, "CD01745", "combo_evid_tp_cd", "evid_tp_cdText");
	    			//formObj.combo_evid_tp_cd.value="5";
    				//ComBtnDisable("btn_TaxEvidence");
	    			//NYK Modify 2014.11.11
	    			CoFmsGetTaxCombo("FORM", formObj, sheetObj, gEvidenceClassTaxCode, "combo_evid_tp_cd", "evid_tp_cdText");
    				formObj.combo_evid_tp_cd.value=gEvidenceClassTaxF0;
    				
    				formObj.evid_tp_cd.value = $("#combo_evid_tp_cd option:selected").val();
    				formObj.evid_tp_nm.value = $("#combo_evid_tp_cd option:selected").text();
					
    				formObj.combo_evid_tp_cd.disabled = true;
	    		} else if(objNm == "eff_dt") {
	    			formObj.f_cmd.value=SEARCH09;
 		   			var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do" , ComReplaceStr(FormQueryString(form),"-",""));
 		   			
 		   			var closFlg=ComGetEtcData(sXml, "clos_yn");
		   			var effDt=ComGetEtcData(sXml, "eff_dt");
		   			var oldEffDt=ComGetUnMaskedValue(formObj.eff_dt, "ymd");
				
		   			if (closFlg=="C"){
						//closed, and open item not exists
						if (ComTrim(effDt) == ""){
							ComShowCodeMessage("FMS20009", oldEffDt.substring(0,6));
							formObj.eff_dt.value="";
							return;					
						}
						//closed, and user confirmed, setting next month 1 day
						if (ComShowCodeConfirm('FMS20010',oldEffDt, effDt)){
							formObj.eff_dt.value=effDt;
							
							//Sheet Set.
							setSheetSlpEffDtChange(sheetObj);
							
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
						//Sheet Set.
						setSheetSlpEffDtChange(sheetObj);
					//in case of not existing data
					}else if (closFlg=="E"){
						ComShowCodeMessage("FMS20012", oldEffDt.substring(0,6));
						formObj.eff_dt.value="";
					}else{
						//Sheet Set.
						setSheetSlpEffDtChange(sheetObj);
					}  
	    		} else if(objNm == "vndr_seq") {
	    			formObj.f_cmd.value=SEARCH01;
	    			var param=FormQueryString(formObj) + "&cond_flag=VM" + "&cd_cnt=&cd_seq=" + form.vndr_seq.value;
 					var sXml=sheetObj.GetSearchData("ESM_FMS_0070GS.do", param);
					var cdName=ComGetEtcData(sXml, "cdName");
					if(typeof cdName == "undefined" || cdName == "" ) {
						form.vndr_seq.value="";
						form.vndr_nm.value="";
//						form.vndr_seq.focus();
						ComShowCodeMessage('FMS01334');
			    	} else {
			    		form.vndr_nm.value=cdName;
			    	}
	    		}
    			break;
    		case IBROWSEARCH:
	    		if (objNm == "ctr_cd") {
	   			 	formObj.f_cmd.value=SEARCH01;
					var acctCd=sheetObj.GetCellValue(row, "acct_cd");
					var ctrCd=sheetObj.GetCellValue(row, "ctr_cd");
 	   			 	var sXml=sheetObj.GetSearchData("ESM_FMS_0021GS.do", FormQueryString(formObj)+"&acct_cd="+acctCd+"&chk_ctr_cd="+ctrCd);
	   			 	var slpLocCd=ComGetEtcData(sXml, "slpLocCd");
	   			 	if(typeof slpLocCd == "undefined" || slpLocCd == "" ) {
	   			 		ComShowCodeMessage('FMS01441');
		   			 	sheetObj.SetCellValue(row, "ctr_cd","",0);
	        			sheetObj.SelectCell(row, "ctr_cd");
	   			 	} else {
	   			 		sheetObj.SetCellValue(row, "slp_loc_cd",slpLocCd,0);
	   			 	}
	    		} else if (objNm == "acct_cd") {
	    			formObj.f_cmd.value=SEARCH01;
	    			var acctCd=sheetObj.GetCellValue(row, "acct_cd");
 	    			var sXml=sheetObj.GetSearchData("ESM_FMS_0069GS.do", FormQueryString(formObj)+"&acct_cd="+acctCd+"&pnd_tgt_flg=N");
	    			var cdName=ComGetEtcData(sXml, "acctNm");
	    			if(typeof cdName == "undefined" || cdName == "" ) {
	    				ComShowCodeMessage('FMS01336');
	    				sheetObj.SetCellValue(row, "ctr_cd","",0);
	    				sheetObj.SetCellValue(row, "slp_loc_cd","",0);
	    				sheetObj.SetCellValue(row, "acct_cd","",0);
	        			sheetObj.SelectCell(row, "acct_cd");
	    			}
	    		} else if(objNm == "vndr_seq") {
	    			formObj.f_cmd.value=SEARCH01;
	    			var cd_seq=sheetObj.GetCellValue(row, "vndr_seq");
	    			var param=FormQueryString(formObj) + "&cond_flag=VM"+"&cd_cnt=&cd_seq="+cd_seq;
 					var sXml=sheetObj.GetSearchData("ESM_FMS_0070GS.do", param);
					var cdName=ComGetEtcData(sXml, "cdName");
					if(typeof cdName == "undefined" || cdName == "" ) {
						ComShowCodeMessage('FMS01334');
						sheetObj.SetCellValue(row, "vndr_seq","",0);
	        			sheetObj.SelectCell(row, "vndr_seq");
			    	}
	    		} else if(objNm == "vvd_cd") {
	    			formObj.f_cmd.value=SEARCH06;
	    			var vvdCd=sheetObj.GetCellValue(row, "vvd_cd");
 	    			var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do", FormQueryString(formObj)+"&vvd_cd="+vvdCd);
	    			if(CoFmsShowXmlMessage(sXml) != "") {
	    				ComAlertFocus(formObj.vvd_cd, CoFmsShowXmlMessage(sXml));
	    				sheetObj.SetCellValue(row, "vvd_cd","",0);
	    				sheetObj.SelectCell(row, "vvd_cd");
					} 
	    		}else { //NYK Modify 2014.11.05 : Center Code, City Search.
	        		sheetObj.SetWaitImageVisible(0);
	        		formObj.f_cmd.value=SEARCH10;
 		   			var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do" , FormQueryString(formObj));
		   			var apCtrCd=ComGetEtcData(sXml, "apCtrCd");
		   			var locCd=ComGetEtcData(sXml, "locCd");
		   			// Center Code Setting
		   			if(typeof apCtrCd != "undefined" && apCtrCd != "" ) {
		   				formObj.ap_ctr_cd.value=apCtrCd;
					} 
		   			// City Code Setting
		   			if(typeof locCd != "undefined" && locCd != "" ) {
						formObj.loc_cd.value=locCd;
					}
		   			sheetObj.SetWaitImageVisible(1);
	        	}
    			break;
    		case IBSAVE:        
    			if(validateForm(sheetObj,formObj,sAction)) {
    				if(!saveConfirm()) return;
    				formObj.f_cmd.value=MULTI;
    				if (sheetObj.IsDataModified()&& sheetObj.GetSaveString() == "") return;
    				
    				//NYK Modify 2014.11.11
    				/*if(combo_evid_tp_cd.value != "5") {
	    				if(sheetObjects[2].RowCount()== 0) {
							ComShowCodeMessage("FMS01458");
							return;
	    				}
    				}*/
					var param=FormQueryString(formObj) + "&" + 
								ComFmsSetPrifix(sheetObjects[0].GetSaveString(),"sheet1_") + "&" +
								sheetObjects[1].GetSaveString() + "&" +
								sheetObjects[2].GetSaveString();
 					var sXml=sheetObj.GetSaveData("ESM_FMS_0040GS.do", param);
 					sheetObj.LoadSaveData(sXml);
    			}
    			break;
    		case IBINSERT:      
            	break;
            	
			case IBSEARCH_ASYNC01: //NYK Modify 2014.10.14
        		sheetObj.SetWaitImageVisible(0);
        		var f_query = "";					
				f_query += "f_cmd=" + SEARCH; 
				f_query += "&csr_type="+formObj.csr_type.value;	 			
				f_query += "&slp_ofc_cd="+formObj.slp_ofc_cd.value; 
				
				//var sXml = sheetObj.GetSearchXml("FMS_COMGS.do","" , f_query, true);
				var sXml = sheetObj.GetSearchData("FMS_COMGS.do",f_query);
				
	   			var varRqstDt = ComGetEtcData(sXml, "rqst_dt");
	   			var varEffDt = ComGetEtcData(sXml, "eff_dt");

	   			if(typeof varRqstDt != "undefined" && varRqstDt != "" ) {
	   				formObj.rqst_dt.value = ComGetMaskedValue(varRqstDt,"ymd");
				} 
	   			
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
    function validateForm(sheetObj, formObj, sAction) {
    	if (!ComFmsChkValid(formObj,"csr_desc")) {
      		return false;
       	}
     	if(sAction == IBSAVE) {
     		var iRowCnt = sheetObjects[0].RowCount();
     		
     		if(iRowCnt==0){
     			iRowCnt = sheetObj.RowCount("D");
			}
     		
 	    	if(iRowCnt== 0) {
 	  			ComShowCodeMessage("FMS00007");
 	  			return false;
 	  		}
 	    	if (!ComChkValid(formObj)) {
 	      		return false;
 	       	}
 	    	for(var i=1; i<=sheetObjects[0].LastRow(); i++) {
 	    		if(sheetObjects[0].GetCellValue(i, "csr_amt") == "0") {
 	    			ComShowCodeMessage("FMS00020", "Slip Amount");
 	    			sheetObj.SelectCell(i, "csr_amt");
 	 	  			return false;
 	    		}
 	    		// --------------------------------------------------
				// Checking to prevent inserting decimal point in case Currency is KRW or JPY
				// --------------------------------------------------
				var currCd=form.csr_curr_cd.value;
				if(currCd == "KRW" || currCd == "JPY" || currCd == "PAB") {
					var carAmt=sheetObj.GetCellValue(i, "csr_amt").replace(/,/g,'');
					if(carAmt%parseInt(carAmt)) {
						ComShowCodeMessage("FMS01476");
						sheetObj.SelectCell(i, "csr_amt");
						return false;
					}
				}
				/* 2015.10.14 NYK 사용하지 않음.
				// --------------------------------------------------
	 	   		// Checking VVD Code
				// --------------------------------------------------
				if(checkVvdCd(sheetObjects[0], i)) {
	 	   			var vvdCd=sheetObjects[0].GetCellValue(i, "vvd_cd");
	 	   			if(vvdCd == "") {
						//Require to insert VVD in case of using ACC# 421211
						var acctCdCol=sheetObj.SaveNameCol("acct_cd");
						var acctCdValue=sheetObj.GetCellValue(i,acctCdCol);
						if (acctCdValue != "421211") {
		 	   				ComShowCodeMessage("FMS01155");
		 	   				sheetObjects[0].SelectCell(i, "vvd_cd");
		 	   				return false;
						}
	 	   			}
	 	   		}*/
	 	   		// Checking Key Number
	 			if(checkKeyNumber(sheetObjects[0], i)) {
	 				var toInvNo=sheetObjects[0].GetCellValue(i, "to_inv_no");
	 				if(toInvNo == "") {
	 					ComShowCodeMessage("FMS01456");
	 					sheetObjects[0].SelectCell(i, "to_inv_no");
	 					return false;
	 				}
	 			}
	 			var csrCurrCd=form.csr_curr_cd.value;
	 			var acctCd=sheetObj.GetCellValue(i, "acct_cd");
				if(csrCurrCd != "KRW" && acctCd == "111811") {
					ComShowCodeMessage('FMS01475');
					sheetObj.SetCellValue(i, "acct_cd","",0);
        			sheetObj.SelectCell(i, "acct_cd");
        			return false;
				}
 	    	}
 	    	var slpFuncCd=form.slp_func_cd.value;
 	    	var balance=form.balance.value.replace(/,/g,'');
 	    	if(slpFuncCd == "S") {
 	    		if(balance < 0) {
 	    			ComShowCodeMessage("FMS01466");
 	    			return false;
 	    		}
 	    	} else if(slpFuncCd == "P") {
 	    		if(balance < 0) {
 	    			ComShowCodeMessage("FMS01470");
 	    			return false;
 	    		}
 	    	} else if(slpFuncCd == "C") {
 	    		if(balance >= 0) {
 	    			ComShowCodeMessage("FMS01467");
 	    			return false;
 	    		}
 	    	}
     	}
      	return true;
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
  	 * Loading Event of HTML_Control existing on page dynamically <br>
  	 * Calling the function from {@link #loadPage} to initialize IBSheet Object <br>
  	 * @param {ibsheet} sheetObj    IBSheet Object
  	 * @param {int}     sheetNo     sequence of sheetObjects array
  	 **/
  	function initControl() {
  		axon_event.addListenerForm  ('blur',      'obj_deactivate',  form); 		//- form Code Handling to OnBeforeDeactivate(blur) Event of All Controls
  		axon_event.addListenerForm  ('change'	, 'obj_change', form); 				//- form Code Handling to OnChange Event of All Controls
  		axon_event.addListenerForm  ('beforeactivate', 'obj_activate', form); 		//- form Code Handling to OnFocus Event of All Controls

  	}
  	/**
     * Checking Validation of Effective DT, Requset DT, Vendor Code in ondeactivate Event of HTML Control<br>
     **/
    function obj_deactivate(){
    	if((ComGetEvent("name") == "eff_dt") ||
    	   (ComGetEvent("name") == "rqst_dt")) {
    		ComChkObjValid(ComGetEvent());
    	} else if((ComGetEvent("name") == "vndr_seq")) {
    		ComChkObjValid(ComGetEvent(), true, false, false);
    	}
    }

    /**
     * Checking Validation of Effective DT, Currency, Vendor Code, Evidence Type, Requset DT in onchange Event of HTML Control<br>
     */
 	function obj_change() {
 		if((ComGetEvent("name") == "csr_curr_cd") && (form.csr_curr_cd.value.length == 3)) {
 			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH, "csr_curr_cd");
 		} else if((ComGetEvent("name") == "eff_dt")) {
			if (form.eff_dt.value != "" && ComIsDate(form.eff_dt.value)) {
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "eff_dt");
        	}
 		} else if((ComGetEvent("name") == "vndr_seq")) {
 			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH, "vndr_seq");
 		} else if(ComGetEvent("name") == "combo_evid_tp_cd") {
 			/*if(combo_evid_tp_cd.value == "1" || combo_evid_tp_cd.value == "4") {
 				ComBtnEnable("btn_TaxEvidence");
 			} else {
 				ComBtnDisable("btn_TaxEvidence");
 			}*/
 		} else if((ComGetEvent("name") == "vndr_seq") && (form.vndr_seq.value.length == 0)) {
 			form.vndr_nm.value="";
 		} else if((ComGetEvent("name") == "rqst_dt")) {
 			setRqstDt();
 		} else if((ComGetEvent("name") == "slp_func_cd")) {
 			sheetObjects[0].RemoveAll();
 			sheetObjects[1].RemoveAll();
 			sheetObjects[2].RemoveAll();
 			form.dr.value="0";
 			form.diff.value="0";
 			form.balance.value="0";
 			//NYK Modify 2014.11.11
 			form.combo_evid_tp_cd.disabled=true;
 			//combo_evid_tp_cd.disabled=false;
 		}
 	}
 	/**
 	 * Setting Vender Code and Name selected on Vendor/Customer Inquiry PopUp into Form item<br>
 	 */
 	function setVndrSeq(aryPopupData) {
 		form.vndr_seq.value=aryPopupData[0][5];
 		form.vndr_nm.value=aryPopupData[0][3];
 	}
    
    //NYK Modify 2014.10.14
    function initDefaultDate(){
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);    	
    }
 	/**
	 * Checking Validation of Eff Data<br>
	 */
	function eff_dt_change() {
		if (form.eff_dt.value != "" && ComIsDate(form.eff_dt.value)) {
    		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, 'eff_dt');
      	}else{
      		ComAlertFocus(form.eff_dt, ComGetMsg("FMS01565"));
      	}
		//doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "eff_dt");
	}
	/**
	 * Removing Mask Separator in onfocus Event of HTML Control<br>
	 */
    function obj_activate() {
        if((ComGetEvent("name") == "eff_dt") ||
    	   (ComGetEvent("name") == "rqst_dt")) {
        	ComClearSeparator(ComGetEvent());
        }
    }
    /**
  	 * Setting Csul_Slp information<br>
  	 */
  	function setCsulSlp(aryPopupData) {
  		if(aryPopupData.length > 0){
  			for(var i=0; i < aryPopupData.length ; i++){
				var tmpFletCtrtNo 		= aryPopupData[i][4] ; //flet_ctrt_no
				var tmpCsrDesc 			= aryPopupData[i][5] ; //inv_desc
  				var tmpAcctCd 			= aryPopupData[i][9] ; //acct_cd
  				var tmpCsrAmt 			= aryPopupData[i][11]; //inv_amt
  				var tmpVvdCd 			= aryPopupData[i][12]; //vvd_cd
  				var tmpFletIssTpCd 		= aryPopupData[i][13]; //flet_iss_tp_cd
  				var tmpInvSeq 			= aryPopupData[i][14]; //inv_seq
  				var tmpInvDtlSeq 		= aryPopupData[i][15]; //inv_dtl_seq
  				var tmpFletCtrtTpCd 	= aryPopupData[i][17]; //flet_ctrt_tp_cd
  				
  				
		  		var row=sheetObjects[0].DataInsert(-1);
		  		sheetObjects[0].SetCellValue(row, "acct_cd"			, tmpAcctCd,0);
		  		
		  	    //NYK Modify 2014.10.06
				// 40 : TC- OUT , 41 : TC - IN
		  		//gFletCtrtTpCdTI, gFletCtrtTpCdTO
				if(tmpFletCtrtTpCd == gFletCtrtTpCdTI) { //TI : 용선
		  			sheetObjects[0].SetCellValue(row, "csr_amt"		, tmpCsrAmt		,0);
		  		} else { //TO : 대선 2015.08.25 대선도 그대로 금액을 내린다.
		  			//sheetObjects[0].SetCellValue(row, "csr_amt"		, -1*tmpCsrAmt	,0);
		  			sheetObjects[0].SetCellValue(row, "csr_amt"		, tmpCsrAmt	,0);
		  		}
				
		  		sheetObjects[0].SetCellValue(row, "csr_desc"		, tmpCsrDesc	,0);
		  		sheetObjects[0].SetCellValue(row, "vvd_cd"			, tmpVvdCd		,0);
		  		sheetObjects[0].SetCellValue(row, "flet_ctrt_no"	, tmpFletCtrtNo	,0);
		  		sheetObjects[0].SetCellValue(row, "flet_iss_tp_cd"	, tmpFletIssTpCd,0);
		  		sheetObjects[0].SetCellValue(row, "inv_seq"			, tmpInvSeq		,0);
		  		sheetObjects[0].SetCellValue(row, "inv_dtl_seq"		, tmpInvDtlSeq	,0);
		  		
		  		setSheetInfo(row);
		  		
		  		//Checking Key Number Enable
		  		if(checkKeyNumber(sheetObjects[0], row)) {
		  			sheetObjects[0].SetCellEditable(row, "to_inv_no",1);
				} else {
					sheetObjects[0].SetCellEditable(row, "to_inv_no",0);
				}
		  		sheetObjects[0].InitCellProperty(row, "acct_cd", { Type:"Text",Align:"Center"} );
		  		sheetObjects[0].SetCellEditable(row, "acct_cd"	,0);
		  		sheetObjects[0].SetCellEditable(row, "vndr_seq"	,0);
		  		sheetObjects[0].SetCellEditable(row, "csr_desc"	,0);
  			}
	  		
	  		inputReadOnly(2);
	  		setDrDiff();
  		}
  	}
  	/**
  	 * Setting inserted Effective DT, Request DT into Sheet<br>
  	 */
    function setSheetInfo(row) {
    	sheetObjects[0].SetCellValue(row, "eff_dt"		,form.eff_dt.value		,0);
    	sheetObjects[0].SetCellValue(row, "vndr_seq"	,form.vndr_seq.value	,0);
    	
    	//NYK Modify 2014.11.05 Center Code, City Set.		
    	sheetObjects[0].SetCellValue(row, "ctr_cd"		,form.ap_ctr_cd.value	,0);
    	sheetObjects[0].SetCellValue(row, "slp_loc_cd"	,form.loc_cd.value		,0);
    	
    	sheetObjects[0].InitCellProperty(row, "acct_cd"	,{ Type:"PopupEdit",Align:"Center"} );
    	sheetObjects[0].SetDataLinkMouse("acct_cd",1);
    	sheetObjects[0].SetShowButtonImage(2);
    }

	function sheet1_OnPopupClick(sheetObj,Row,Col){
		ComOpenPopup("ESM_FMS_0076.do?flet_acct_cate_cd=CH", 550, 450, "setGridItemNm", "1,0,1,1,1,1", true, false, Row, Col, 0, "ESM_FMS_0076");
	}

	/**
	 * Inserting setGridItemNm <br>
	 * @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
	 */
	function setGridItemNm(aryPopupData, row, col, sheetIdx){
		//sheetObjects[0].SetCellValue(row,"acct_nm",aryPopupData[0][2],0);
		sheetObjects[0].SetCellValue(row,"acct_cd",aryPopupData[0][3],0);
		//sheetObjects[0].SetCellValue(row,"acct_itm_seq",aryPopupData[0][4],0);
		
		// Checking Acct Code by Slip Type
		if(checkSlpFuncCd(sheetObjects[0], row)) {
			doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, "acct_cd", row);
		}
	}
	
    /**
     * Checking Validation of Acct Code, Vendor Code, Center Code, VVD Code in case OnChange Event of Sheet1 is occurred<br>
     */
    function sheet1_OnChange(sheetObj, row, col, value, oldValue, RaiseFlag) {
    	if(value == oldValue) return;
    	var colName = sheetObj.ColSaveName(col);
    	switch(colName){
	    	case "acct_cd": //3
				if(sheetObj.GetCellValue(row, "acct_cd").length > 0) {
					var acctCd=sheetObj.GetCellValue(row, "acct_cd");
					/* 2015.10.14 NYK는 Account Level 별 VVD 를 체크하지 않음.
					// 계정 항차 레벨 검사(Account 별 VVD Level Check)
					// 해당 계정에 대한 항차 입력 여부 판단
					if(checkAcctCdVvdLevelMdt(sheetObj, row)) {
						sheetObj.SetCellEditable(row, "vvd_cd",0);
						sheetObj.SetCellValue(row, "vvd_cd","",0);
					} else {
						if(checkAcctCdVvdLevel(sheetObj, row)) {
							sheetObj.SetCellEditable(row, "vvd_cd",1);
							sheetObj.SetCellValue(row, "vvd_cd","",0);
						} else {
							sheetObj.SetCellEditable(row, "vvd_cd",0);
							sheetObj.SetCellValue(row, "vvd_cd","",0);
						}
					}*/
					// Checking Key Number Enable 
					if(checkKeyNumber(sheetObj, row)) {
						sheetObj.SetCellEditable(row, "to_inv_no",1);
					} else {
						sheetObj.SetCellEditable(row, "to_inv_no",0);
					}
					var csrCurrCd=form.csr_curr_cd.value;
					if(csrCurrCd != "KRW" && acctCd == "111811") {
						ComShowCodeMessage('FMS01475');
						sheetObj.SetCellValue(row, "acct_cd","",0);
	        			sheetObj.SelectCell(row, "acct_cd");
	        			return;
					}
					// Checking Acct Code by Slip Type
					if(checkSlpFuncCd(sheetObj, row)) {
						doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "acct_cd", row);
					} else {
						return;
					}
				}
	    		break;
	    	case "vndr_seq"://4
	    		if(sheetObj.GetCellValue(row, "vndr_seq").length > 0) {
					doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "vndr_seq", row);
				}
	    		break;
	    	case "ctr_cd"://5
	    		if(sheetObj.GetCellValue(row, "ctr_cd").length > 0) {
					doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "ctr_cd", row);
				}
	    		break;
	    	case "vvd_cd"://10
	    		if(sheetObj.GetCellValue(row, "vvd_cd").length > 0) {
					doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "vvd_cd", row);
				}
	    		break;
	    	case "csr_amt"://8
	    		if(value != "") {
	    			setDrDiff();
	    		}
	    		break;
    	}
    }
    /**
     * Setting Creditor/Debtor Value<br>
     * @param value
     * @return
     */
    function setDrDiff() {
    	var csrAmt=0;
    	var dr=0;
    	var diff=0;
    	for(var i=1; i<=sheetObjects[0].LastRow(); i++) {
    		csrAmt=sheetObjects[0].GetCellValue(i, "csr_amt");
			if(csrAmt > 0) {
				dr=dr*1 + csrAmt*1;
			} else {
				diff=diff*1 + csrAmt*1;
			}
    	}
    	balance=(dr*1 + diff*1).toFixed(2);
		form.dr.value=ComAddComma(dr.toFixed(2));
		form.diff.value=ComAddComma(diff.toFixed(2));
		form.balance.value=ComAddComma(balance);
		form.csr_amt.value=balance;
		form.rqst_amt.value=balance;
    }
    /**
     * Setting Bond No<br>
     * @param ErrMsg
     * @return
     */
    function sheet1_OnSaveEnd(ErrMsg) {
    	var sheetObj=sheetObjects[0];
    	if(sheetObj.RowCount()> 0) {
    		if(sheetObj.GetCellValue(1, "csr_no") != "" ) {
	    		inputReadOnly("1");
	    		form.csr_no.value=sheetObj.GetCellValue(1, "csr_no");
	  	    	for(var i=sheetObj.HeaderRows(); i<sheetObj.LastRow(); i++) {
	  	    		sheetObj.SetCellEditable(i, "DelChk",0);
	  	    		sheetObj.SetCellEditable(i, "acct_cd",0);
	  	    		sheetObj.SetCellEditable(i, "vndr_seq",0);
	  	    		sheetObj.SetCellEditable(i, "ctr_cd",0);
	  	    		sheetObj.SetCellEditable(i, "slp_loc_cd",0);
	  	    		sheetObj.SetCellEditable(i, "eff_dt",0);
	  	    		sheetObj.SetCellEditable(i, "csr_amt",0);
	  	    		sheetObj.SetCellEditable(i, "csr_desc",0);
	  	    		sheetObj.SetCellEditable(i, "vvd_cd",0);
	  	    		sheetObj.SetCellEditable(i, "to_inv_no",0);
	  	    	}
    		}
  	    }
    }
    /**
     * Setting whether to use the Object by Condition<br>
     **/
    function inputReadOnly(flag) {
    	if(flag == "0") {
    		form.csr_desc.readOnly=false;
    		form.slp_func_cd.disabled=false;
    		//NYK Modify 2014.11.11
    		form.combo_evid_tp_cd.disabled=true;
    		//combo_evid_tp_cd.disabled=false;
    		form.rqst_dt.readOnly=false;
    		form.eff_dt.readOnly=false;
    		form.vndr_seq.readOnly=false;
    		form.csr_curr_cd.readOnly=false;
    		form.btn_rqstDt.style.cursor="hand";
//    		document.images["btn_rqstDt"].name="btn_rqstDt";
    		form.btn_rqstDt.name="btn_rqstDt";
    		form.btn_effDt.style.cursor="hand";
//    		document.images["btn_effDt"].name="btn_effDt";
    		form.btn_effDt.name="btn_effDt";
    		form.btn_vndrSeq.style.cursor="hand";
//    		document.images["btn_vndrSeq"].name="btn_vndrSeq";
    		form.btn_vndrSeq.name="btn_vndrSeq";
    		ComBtnEnable("btn_Brokerage");
    		ComBtnEnable("btn_RowAdd");
    		ComBtnEnable("btn_RowDel");
    		ComBtnEnable("btn_Save");
    		
    		//NYK Modify 2014.11.11
    		/*ComBtnEnable("btn_TaxEvidence");
    		combo_evid_tp_cd.value="5";
    		if(combo_evid_tp_cd.value == "5") {
    			ComBtnDisable("btn_TaxEvidence");
    		}*/
    	} else if(flag == "1") {
    		form.csr_desc.readOnly=true;
    		form.slp_func_cd.disabled=true;
    		form.combo_evid_tp_cd.disabled=true;
    		form.rqst_dt.readOnly=true;
    		form.eff_dt.readOnly=true;
    		form.vndr_seq.readOnly=true;
    		form.csr_curr_cd.readOnly=true;
    		form.btn_rqstDt.style.cursor="default";
//    		document.images["btn_rqstDt"].name="no_btn_rqstDt";
    		form.btn_rqstDt.name="no_btn_rqstDt";
    		form.btn_effDt.style.cursor="default";
//    		document.images["btn_effDt"].name="no_btn_effDt";
    		form.btn_effDt.name="no_btn_effDt";
    		form.btn_vndrSeq.style.cursor="default";
//    		document.images["btn_vndrSeq"].name="no_btn_vndrSeq";
    		form.btn_vndrSeq.name="no_btn_vndrSeq";
    		ComBtnDisable("btn_Brokerage");
    		ComBtnDisable("btn_RowAdd");
    		ComBtnDisable("btn_RowDel");
    		ComBtnDisable("btn_Save");
    		//NYK Modify 2014.11.11
    		//ComBtnDisable("btn_TaxEvidence");
    		
    	} else if(flag == "2") {
    		form.csr_curr_cd.readOnly=true;
    		form.vndr_seq.readOnly=true;
    		form.btn_vndrSeq.style.cursor="default";
//    		document.images["btn_vndrSeq"].name="no_btn_vndrSeq";
    		form.btn_vndrSeq.name="no_btn_vndrSeq";
    	} else if(flag == "3") {
    		form.combo_evid_tp_cd.disabled=true;
    	}
    }

   	/**
   	 * Printing Slip<br>
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
   	 * Checking whether Request DT is smaller than CSR Data<br>
   	 */
   	function setRqstDt() {
   		var csrDt=form.slp_iss_dt.value.replace(/-/g,'');
   		var rqstDt=form.rqst_dt.value.replace(/-/g,'');
   		if(parseInt(csrDt) > parseInt(rqstDt)) {
   			form.rqst_dt.value="";
   			ComAlertFocus(form.rqst_dt, ComGetMsg('FMS01438'));
   		}
   	}
    /**
     * Checking whether Key Number is required to insert by Account Code<br>
     **/
    function checkKeyNumber(sheetObj, row) {
    	//NYK Modify 2014.10.29
    	/*
    	var acctCd=sheetObj.GetCellValue(row, "acct_cd");
    	if(   acctCd == "167111"
    	   || acctCd == "16712"
    	   || acctCd == "167191"
    	   || (parseInt(acctCd) > 511300 && parseInt(acctCd) < 511499 && acctCd != "511351")
    	   || (parseInt(acctCd) > 133810 && parseInt(acctCd) < 133891)) {
    		return true;
    	}*/
    	return false;
 	}
    /**
     * 2015.10.14 NYK 사용하지 않음.
     * Checking whether VVD_CD is required to insert by Account Code <br>
     **/
    function checkVvdCd(sheetObj, row) {
    	var acctCd=sheetObj.GetCellValue(row, "acct_cd");
    	if(acctCd == "580111") {
    		sheetObj.SetCellValue(row, "vvd_cd","",0);
    		return false;
    	} else if(acctCd.substring(0,1) == "4"
	   	   || acctCd.substring(0,1) == "6"
	   	   || acctCd.substring(0,1) == "7"
	   	   || acctCd.substring(0,2) == "51"
	   	   || acctCd == "956115"
	   	   || acctCd == "962111"
	   	   || acctCd == "111071") {
    		return true;
    	}
    	return false;
    }
    /**
     * Checking Acct Code by Slip Type<br>
     **/
    function checkSlpFuncCd(sheetObj, row) {
    	var acctCd=sheetObj.GetCellValue(row, "acct_cd");
    	var slpFuncCd=form.slp_func_cd.value;
    	if(slpFuncCd == "S") {
    		if(acctCd.substring(0,6) == "111431") {
   				ComShowCodeMessage("FMS01454");
   				sheetObj.SetCellValue(row, "acct_cd","",0);
   				sheetObj.SelectCell(row, "acct_cd");
   				return false;
    		}
    	} else if(slpFuncCd == "P") {
    		if(acctCd.substring(0,6) == "111431") {
    			var tmpCnt=0;
    			for(i=sheetObj.HeaderRows();i<sheetObj.LastRow();i++) {
    				if(sheetObj.GetCellValue(i,"acct_cd")=="111431") {
    					tmpCnt++;
    				}
    			}
    			if(tmpCnt > 0) {
    				ComShowCodeMessage("FMS01464");
    				sheetObj.SetCellValue(row, "acct_cd","",0);
    				sheetObj.SelectCell(row, "acct_cd");
    				return false;
    			}
    		}	
    		if(acctCd == "111071") {
    			ComShowCodeMessage("FMS01462");
    			sheetObj.SetCellValue(row, "acct_cd","",0);
    			sheetObj.SelectCell(row, "acct_cd");
    			return false;
    		}
    	} else if(slpFuncCd == "C") {
    		if(acctCd.substring(0,6) == "111431") {
   				ComShowCodeMessage("FMS01454");
   				sheetObj.SetCellValue(row, "acct_cd","",0);
   				sheetObj.SelectCell(row, "acct_cd");
   				return false;
    		}
    	}
    	return true;
    }
    /**
     * Showing Save Message<br>
     **/
  	function saveConfirm() {
  		var okYn=ComShowConfirm(ComGetMsg("FMS00017"));
  		return okYn;
  	}
    /**
     * 2015.10.14 NYK 사용하지 않음.
     * VVD Level Check by Account(Checking whether Voyage about relevant Account is required to insert )
     * Decide whether Voyage about relevant Account is required to insert by checking Account Voyage Level <br>
     * @param {ibsheet}	 sheetObj    IBSheet Object
     * @param {ibsheet}  row     	 selected Row of sheetObj
     * @return {boolean} true : Madatory, false : pass
     **/
    function checkAcctCdVvdLevelMdt(sheetObj, row) {
     	var acctCdCol=sheetObj.SaveNameCol("acct_cd");
     	var acctCdValue=sheetObj.GetCellValue(row,acctCdCol);
 		if(	  acctCdValue.substring(0,4) == "4212"
 		   || acctCdValue.substring(0,4) == "5801"
 		   || acctCdValue == "612900"
 	       || acctCdValue == "712900") {
 			return true;
 		} else {
 			return false;
 		}
    }
    /**
     * 2015.10.14 NYK 사용하지 않음.
     * VVD Level Check by Account
     * Decide whether Voyage about relevant Account is required to insert by checking Account Voyage Level <br>
     * @param {ibsheet}	 sheetObj    IBSheet Object
     * @param {ibsheet}  row     	 selected Row of sheetObj
     * @return {boolean} true : Checking Voyage Level, false : pass
     **/
    function checkAcctCdVvdLevel(sheetObj, row) {
    	//VVD Level Check by Account
     	var acctCdCol=sheetObj.SaveNameCol("acct_cd");
     	var acctCdValue=sheetObj.GetCellValue(row,acctCdCol);
 		if((   acctCdValue.substring(0,1) == "4"
 		    || acctCdValue.substring(0,1) == "6"
 		    || acctCdValue.substring(0,1) == "7"
 		    || acctCdValue.substring(0,2) == "51"
 		    || acctCdValue == "956115"
 		    || acctCdValue == "962111"
 		    || acctCdValue == "111071") && !(   acctCdValue.substring(0,4) == "4212"
 				    						 || acctCdValue.substring(0,4) == "5801"
 				    						 || acctCdValue == "612900"
 				    					     || acctCdValue == "712900")) {
 			return true;
 		} else {
 			return false;
 		}
    }
    
    function setSheetSlpEffDtChange(sheetObj){
    	var formObj = document.form;
		//Sheet Set.
		if(sheetObj.RowCount()> 0) {
			for(var ir=sheetObj.HeaderRows(); ir<=sheetObj.LastRow(); ir++) {
				sheetObj.SetCellValue(ir,"eff_dt",formObj.eff_dt.value, 0);
			}
		}
    	
    }    

    function resizeSheet(){
        for (i=0; i<sheetObjects.length; i++){
            ComResizeSheet(sheetObjects[i], 130);
        }
    }
    
