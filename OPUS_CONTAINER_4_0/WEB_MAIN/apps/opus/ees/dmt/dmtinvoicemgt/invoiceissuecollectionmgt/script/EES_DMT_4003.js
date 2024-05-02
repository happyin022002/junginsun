/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_4003.jsp
*@FileTitle  : Invoice Issue Preview
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/18
=========================================================*/
/****************************************************************************************
   Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                  OTHER CASE : COMMAND01=11; ~ COMMAND20=30;	
 ***************************************************************************************/
	// Common Global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
//	var rdObjects=new Array(); 
//	rdObjects[0] = document.getElementById("rd_invoice"); 
//	var rdCnt=0;
	var queryStr="";
	var ROWMARK="|";
	var FIELDMARK="=";
	var IBFAXSEND=53;
	var IBEMAILSEND=54;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
    	/***** case in Sheet count are more two by Tab, defining adding sheet *****/
    	var sheetObject1=sheetObjects[0];
    	var srcObj=window.event.srcElement;
    	/*******************************************************/
        var formObject=document.form;
//        var rdObject=rdObjects[0];
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
				case "btn_print":
					if (ComGetObjValue(formObject.has_sheetset) != "Y") {
						ComShowCodeMessage("DMT01096");
						return;
					}
					viewer.print({isServerSide:true});
					break;								
				case "btn_fax":
					if(ComIsBtnEnable(srcName)) {
						if (ComGetObjValue(formObject.has_sheetset) != "Y") {
							ComShowCodeMessage("DMT01096");
							return;
						}
	                    doActionIBSheet(sheetObject1,formObject,IBFAXSEND);
	                    openPopupWindow(formObject, srcName);
					}
					break;
				case "btn_email":
					if(ComIsBtnEnable(srcName)) {
						if (ComGetObjValue(formObject.has_sheetset) != "Y") {
							ComShowCodeMessage("DMT01096");
							return;
						}
						doActionIBSheet(sheetObject1,formObject,IBEMAILSEND);
	                    openPopupWindow(formObject, srcName);
					}
					break;	
//				case "btn_payerfaxemail":
//					if(ComIsBtnEnable(srcName)) {
//						openPopupWindow(formObject, srcName);
//					}
//					break;		
//					
//				case "btn_remark":
//					openPopupWindow(formObject, srcName);
//					break;
//					
//				case "btn_set":
//					if(ComIsBtnEnable(srcName)) {
//            			openPopupWindow(formObject, srcName);
//            		}
//					break;				
//				
//				case "btn_option":
//					if(ComIsBtnEnable(srcName)) {
//            			openPopupWindow(formObject, srcName);
//            		}
//					break;
				case "btn_close":
					ComClosePopup(); 
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
     * adding first-served functions after loading screen.
     */
    function loadPage(){
		var opener=window.dialogArguments;
		if (!opener) opener=window.opener;  //이 코드 추가할것
		if (!opener) opener=parent;
    	var cntc_pnt_nm="";
    	for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
    	if(ComGetObjValue(document.form.jspno) == "4002") {
    		cntc_pnt_nm=opener.form.org_dmdt_payr_cntc_pnt_nm.value;
    	}
    	else if(ComGetObjValue(document.form.jspno) == "4004") {
    		cntc_pnt_nm=opener.form.org_dmdt_payr_cntc_pnt_nm.value;
    	}
    	else if(ComGetObjValue(document.form.jspno) == "4016") {
    		cntc_pnt_nm=opener.form.org_dmdt_payr_cntc_pnt_nm.value;
    	}
    	ComSetObjValue(document.form.dmdt_payr_cntc_pnt_nm, cntc_pnt_nm);
    	//RD
    	rdOpen(viewer, document.form, sheetObjects[0]);
    	//Retrieving whether there should Sheet Set.
		//if there is no Sheet Set , when Preview / Print / Fax send / Email send button clicked,  on the Alert message show and blocking..
		doActionIBCombo(sheetObjects[0],document.form,IBSEARCH,COMMAND13,"RESULT","");		
    	//search Payer's email and fax no
		//payer_cd, ofc_cd, dmdt_trf_cd
		doActionIBCombo(sheetObjects[0], document.form, IBSEARCH, COMMAND02, "", "");
    }
    
    function rdOpen(rdObject,formObj,sheetObj){
    	var Rdviewer=rdObject ;
    	
//        Rdviewer.AutoAdjust=false;
        Rdviewer.zoom = 100;
      //  Rdviewer.HideStatusbar();
//        Rdviewer.ViewShowMode(0);
//        Rdviewer.ApplyLicense("0.0.0.0");
//        Rdviewer.SetPageLineColor(255,255,255);         
    	var path=formObj.mrd.value;		//mrd_path
    	//Search MASTER DATA
    	ComSetObjValue(formObj.f_cmd, SEARCH01);	
 		var sXml=sheetObj.GetSearchData("EES_DMT_4003GS.do",	FormQueryString(formObj));
		sheetObj.LoadSearchData(sXml,{Sync:1} );
		ComEtcDataToForm(formObj, sheetObj);
		//RD calls 
		var rdParm="/ruseurlmoniker [0]" + " /rfn [" + RDServerIP + "/EES_DMT_4003_RD.do] "		//Search DETAIL DATA
					+ " /rv " + rvParmByInvoice(formObj)
					+ " /rpost [jspno=" + ComGetObjValue(formObj.jspno) + "&invoice_no="+ComGetObjValue(formObj.invoice_no)+"&cre_ofc_cd="+ComGetObjValue(formObj.cre_ofc_cd)+"]"		//jspno, invoice_no
					;
//		ComDebug(rdParm);
		var pdf_name="INVOICE_" + ComGetObjValue(formObj.invoice_no);
		//BSTR szPath, BSTR szName, BSTR szExtList, BSTR szDefaultExt
//		Rdviewer.SetSaveDialogEx("c:\\", pdf_name, "pdf", "pdf");
		Rdviewer.openFile(RD_path+path, rdParm, {timeout:1800});
		//Rdviewer.DisableToolbar (0);
		var hiddenParam = ["xls","hwp","ppt","doc"];
        Rdviewer.hideToolbarItem(hiddenParam);
    }    
    /**
     * rv By Invoice 
     */ 
    function rvParmByInvoice(formObj){
    	/////////////////////////////////////////////////////////////////////////////////////
		//separate Address1,Address2,Address3,Address4
		var payrAddrs=ComGetObjValue(formObj.rd_payr_addr);
		var rd_payr_addr01="";
		var rd_payr_addr02="";
		var rd_payr_addr03="";
		var rd_payr_addr04="";
        var paryInfoAddr=payrAddrs.split("\n");
        var paryInfoAddrCnt=paryInfoAddr.length;
        if ( paryInfoAddrCnt >= 1 ) {
        	rd_payr_addr01=paryInfoAddr[0];
        } else {
        	rd_payr_addr01="";
        }
        if ( paryInfoAddrCnt >= 2 ) {
        	rd_payr_addr02=paryInfoAddr[1];
        } else {
        	rd_payr_addr02="";
        }
        if ( paryInfoAddrCnt >= 3 ) {
        	rd_payr_addr03=paryInfoAddr[2];
        } else {
        	rd_payr_addr03="";
        }
        if ( paryInfoAddrCnt >= 4 ) {
        	rd_payr_addr04=paryInfoAddr[3];
        } else {
        	rd_payr_addr04="";
        }
        /////////////////////////////////////////////////////////////////////////////////////    	
    	var	rvRaram=" RD_SH_ADDR1[" + ComGetObjValue(formObj.rd_sh_addr1) +"]" +
					" RD_SH_ADDR2[" + ComGetObjValue(formObj.rd_sh_addr2) +"]" +
					" RD_SH_ADDR3[" + ComGetObjValue(formObj.rd_sh_addr3) +"]" +
					" RD_INVOICE_TITLE[" + ComGetObjValue(formObj.rd_invoice_title) +"]" +
					" RD_CANCEL_NOTE[" + ComGetObjValue(formObj.rd_cancel_note) +"]" +
					" RD_CUST_NM[" + ComGetObjValue(formObj.rd_cust_nm) +"]" +
					" RD_PAYR_ADDR01[" + rd_payr_addr01 +"]" +
					" RD_PAYR_ADDR02[" + rd_payr_addr02 +"]" +
					" RD_PAYR_ADDR03[" + rd_payr_addr03 +"]" +
					" RD_PAYR_ADDR04[" + rd_payr_addr04 +"]" +
					" RD_ATTN_NM[" + ComGetObjValue(formObj.rd_attn_nm) +"]" +
					" RD_PHN_NO[" + ComGetObjValue(formObj.rd_phn_no) +"]" +
					" RD_FAX_NO[" + ComGetObjValue(formObj.rd_fax_no) +"]" +
					" RD_DMDT_INV_NO[" + ComGetObjValue(formObj.rd_dmdt_inv_no) +"]" +
					" RD_ISSUE_DAY[" + ComGetObjValue(formObj.rd_issue_day) +"]" +
					" RD_DUE_DATE[" + ComGetObjValue(formObj.rd_due_date) +"]" +
					" RD_DUE_DAY[" + ComGetObjValue(formObj.rd_due_day) +"]" +
					" RD_NTC_KNT_CD[" + ComGetObjValue(formObj.rd_ntc_knt_cd) +"]" +
					" RD_CRE_USR_NM[" + ComGetObjValue(formObj.rd_cre_usr_nm) +"]" +
					" RD_CUST_CD[" + ComGetObjValue(formObj.rd_cust_cd) +"]" +
					" RD_INV_REF_NO[" + ComGetObjValue(formObj.rd_inv_ref_no) +"]" +
					" RD_CUST_VAT_NO[" + ComGetObjValue(formObj.rd_cust_vat_no) +"]" +
					" RD_SH_HD_N1ST_MSG[" + ComGetObjValue(formObj.rd_sh_hd_n1st_msg) +"]" +
					" RD_SH_HD_N2ND_MSG[" + ComGetObjValue(formObj.rd_sh_hd_n2nd_msg) +"]" +
					" RD_SH_HD_N3RD_MSG[" + ComGetObjValue(formObj.rd_sh_hd_n3rd_msg) +"]" +
					" RD_SH_HD_N4TH_MSG[" + ComGetObjValue(formObj.rd_sh_hd_n4th_msg) +"]" +
					" RD_SH_HD_N5TH_MSG[" + ComGetObjValue(formObj.rd_sh_hd_n5th_msg) +"]" +
					" RD_VVD_CD[" + ComGetObjValue(formObj.rd_vvd_cd) +"]" +
					" RD_VSL_ENG_NM[" + ComGetObjValue(formObj.rd_vsl_eng_nm) +"]" +
					" RD_ARR[" + ComGetObjValue(formObj.rd_arr) +"]" +
					" RD_DEP[" + ComGetObjValue(formObj.rd_dep) +"]" +
					" RD_BL_NO[" + ComGetObjValue(formObj.rd_bl_no) +"]" +
					" RD_BKG_NO[" + ComGetObjValue(formObj.rd_bkg_no) +"]" +
					" RD_CMDT_NM[" + ComGetObjValue(formObj.rd_cmdt_nm) +"]" +
					" RD_DMDT_TRF_CD[" + ComGetObjValue(formObj.rd_dmdt_trf_cd) +"]" +
					" RD_DMDT_TRF_NM[" + ComGetObjValue(formObj.rd_dmdt_trf_nm) +"]" +
					" RD_BKG_RCV_TERM_NM[" + ComGetObjValue(formObj.rd_bkg_rcv_term_nm) +"]" +
					" RD_BKG_DEL_TERM_NM[" + ComGetObjValue(formObj.rd_bkg_del_term_nm) +"]" +
					" RD_POD[" + ComGetObjValue(formObj.rd_pod) +"]" +
					" RD_POD_NM[" + ComGetObjValue(formObj.rd_pod_nm) +"]" +
					" RD_DEL[" + ComGetObjValue(formObj.rd_del) +"]" +
					" RD_DEL_NM[" + ComGetObjValue(formObj.rd_del_nm) +"]" +
					" RD_TRUCKER_NM[" + ComGetObjValue(formObj.rd_trucker_nm) +"]" +
					" RD_ORG_CHG_AMT[" + ComGetObjValue(formObj.rd_org_chg_amt) +"]" +
					" RD_ORG_CURR_CD[" + ComGetObjValue(formObj.rd_org_curr_cd) +"]" +
					" RD_INV_XCH_RT[" + ComGetObjValue(formObj.rd_inv_xch_rt) +"]" +
					" RD_TOT_AMT[" + ComGetObjValue(formObj.rd_tot_amt) +"]" +
					" RD_INV_CURR_CD[" + ComGetObjValue(formObj.rd_inv_curr_cd) +"]" +
					" RD_DC_AMT[" + ComGetObjValue(formObj.rd_dc_amt) +"]" +
					" RD_INV_CHG_AMT[" + ComGetObjValue(formObj.rd_inv_chg_amt) +"]" +
					" RD_TAX_RTO[" + ComGetObjValue(formObj.rd_tax_rto) +"]" +
					" RD_TAX_AMT[" + ComGetObjValue(formObj.rd_tax_amt) +"]" +
					" RD_INV_AMT[" + ComGetObjValue(formObj.rd_inv_amt) +"]" +
					" RD_INV_RMK1[" + ComGetObjValue(formObj.rd_inv_rmk1) +"]" +
					" RD_INV_RMK2[" + ComGetObjValue(formObj.rd_inv_rmk2) +"]" +
					" RD_SH_RMK1[" + ComGetObjValue(formObj.rd_sh_rmk1) +"]" +
					" RD_SH_RMK2[" + ComGetObjValue(formObj.rd_sh_rmk2) +"]" +
					" RD_SH_RMK3[" + ComGetObjValue(formObj.rd_sh_rmk3) +"]" +
					" RD_SH_RMK4[" + ComGetObjValue(formObj.rd_sh_rmk4) +"]" +
					" RD_SH_RMK5[" + ComGetObjValue(formObj.rd_sh_rmk5) +"]" +
					" RD_SH_RMK6[" + ComGetObjValue(formObj.rd_sh_rmk6) +"]" +
					" RD_SH_RMK7[" + ComGetObjValue(formObj.rd_sh_rmk7) +"]" +
					" RD_SH_RMK8[" + ComGetObjValue(formObj.rd_sh_rmk8) +"]" +
					" RD_SH_RMK9[" + ComGetObjValue(formObj.rd_sh_rmk9) +"]" +
					" RD_SH_RMK10[" + ComGetObjValue(formObj.rd_sh_rmk10) +"]" +
					" RD_SH_RMK11[" + ComGetObjValue(formObj.rd_sh_rmk11) +"]" +
					" RD_SH_RMK12[" + ComGetObjValue(formObj.rd_sh_rmk12) +"]" +
					" RD_SH_RMK13[" + ComGetObjValue(formObj.rd_sh_rmk13) +"]" +
					" RD_SH_RMK14[" + ComGetObjValue(formObj.rd_sh_rmk14) +"]" +
					" RD_TAX_AMT_PRN_FLG[" + ComGetObjValue(formObj.rd_tax_amt_prn_flg) +"]" +
					" RD_PHN_FAX_PRN_FLG[" + ComGetObjValue(formObj.rd_phn_fax_prn_flg) +"]" +
					" RD_CUST_VAT_PRN_FLG[" + ComGetObjValue(formObj.rd_cust_vat_prn_flg) +"]" +
					" RD_DC_AMT_FLG[" + ComGetObjValue(formObj.rd_dc_amt_flg) +"]" +
					" RD_CUST_REF_PRN_FLG[" + ComGetObjValue(formObj.rd_cust_ref_prn_flg) +"]" +
					" RD_DAYS_DISP[" + ComGetObjValue(formObj.rd_days_disp) +"]" +
					" RD_DMDT_INV_STS_CD[" + ComGetObjValue(formObj.rd_dmdt_inv_sts_cd) +"]" +
					" RD_CRE_CNT_CD[" + ComGetObjValue(formObj.rd_cre_cnt_cd) +"]" +
					" RD_IDA_EXPN_TAX_RT[" + ComGetObjValue(formObj.rd_ida_expn_tax_rt) +"]" +
					" RD_IDA_EXPN_TAX[" + ComGetObjValue(formObj.rd_ida_expn_tax) +"]" +
					" RD_IDA_EDU_TAX_RT[" + ComGetObjValue(formObj.rd_ida_edu_tax_rt) +"]" +
					" RD_IDA_EDU_TAX[" + ComGetObjValue(formObj.rd_ida_edu_tax) +"]" +
					" RD_IDA_HIGH_EDU_TAX_RT[" + ComGetObjValue(formObj.rd_ida_high_edu_tax_rt) +"]" +
					" RD_IDA_HIGH_EDU_TAX[" + ComGetObjValue(formObj.rd_ida_high_edu_tax) +"]" +
					" RD_TAX_RGST_NO[" + ComGetObjValue(formObj.rd_tax_rgst_no) +"]" +
					" RD_SVC_CATE_RMK[" + ComGetObjValue(formObj.rd_svc_cate_rmk) +"]"+
					" RD_PMNT_ACCT_NO[" + ComGetObjValue(formObj.rd_pmnt_acct_no) +"]"
					;
    	return rvRaram;
    }    
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
	        case 1:
	            with(sheetObj){
	            
			          var HeadTitle="|";
			          var headCount=ComCountHeadTitle(HeadTitle);
			        //  (headCount, 0, 0, true);
		
			          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
			          var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			          var headers = [ { Text:HeadTitle, Align:"Center"}];
			          InitHeaders(headers, info);
		
			          var cols = [ {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
			           
			          InitColumns(cols);
		
			          SetEditable(1);
			          SetSheetHeight(130);
	       //   SetGetCountPosition()(0);
	                }


		        break;
        }
    }    
    // Process of Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
    	case IBFAXSEND:
//    		var opener_obj=window.dialogArguments;
    		var opener_obj=window.dialogArguments;
    		if (!opener_obj) opener_obj=window.opener;  //이 코드 추가할것
    		if (!opener_obj) opener_obj=parent;  
//    		var fax_nos = "";
//    		var email_nos = "";
//    		if(ComGetObjValue(form.jspno) == "4016") {
//    			fax_nos 	= opener_obj.document.form2.payr_faxnos.value;
//    			email_nos 	= opener_obj.document.form2.payr_emailnos.value;
//    		}else{
//    			fax_nos 	= opener_obj.document.form.payr_faxnos.value;
//    			email_nos 	= opener_obj.document.form.payr_emailnos.value;
//    		}
//    		
//    		if(fax_nos == "") {
//    			ComShowCodeMessage("DMT01090");
//    			return;
//    		}
    		var mrd_file="";
//    		var sndr_id		= "";	//id
//    		var sndr_name	= "";	//
//    		var sndr_email	= "";	//
//    		var rcvr_fax_no	= "";	//id;fax_no||id;fax_no
//    		var rcvr_email	= "";	//
//    		var msg1		= "";
    		//MRD file
    		var temp_LR=ComGetObjValue(formObj.invoice_LR);
    		var temp_incCntrDtail	= ComGetObjValue(formObj.inc_cntr_dtail);
    		var rhq    = ComGetObjValue(formObj.rhq_ofc_cd);
    		var ofc_cd = ComGetObjValue(formObj.cre_ofc_cd);
    		var cre_cnt_cd = ComGetObjValue(formObj.cre_cnt_cd);
    		
    		/*
    		if(temp_LR == "") {
    			mrd_file="EES_DMT_4901.mrd";		//L
    		}else if(temp_LR == "L") {
    			mrd_file="EES_DMT_4901.mrd";		//L
    		}else if(temp_LR == "R") {
    			mrd_file="EES_DMT_4902.mrd";		//R
    		}
			*/
    		//=========================================
    		//2015.10.27 #7995 comment start
    		//2017.01.12 #23259 India Invocie
    		if(temp_LR == "") {
    			if(temp_incCntrDtail == "N"){
    				if(cre_cnt_cd == "IN"){
    				   mrd_file = "EES_DMT_4914.mrd";
    			    }else{
    				     mrd_file = "EES_DMT_4908.mrd";
    			    }     
    			}else{
    				if(cre_cnt_cd == "IN"){
     				   mrd_file = "EES_DMT_4912.mrd";
     			    }else{
				       mrd_file = "EES_DMT_4901.mrd";		//L
     			    }
    			}
     		}else if(temp_LR == "L") {
     			if(temp_incCntrDtail == "N"){
       				if(cre_cnt_cd == "IN"){
      				   mrd_file = "EES_DMT_4914.mrd";
      			    }else{
    				   mrd_file = "EES_DMT_4908.mrd";
      			    }
    			}else{
 	   				if(cre_cnt_cd == "IN"){
      				   mrd_file = "EES_DMT_4912.mrd";
      			    }else{
 				       mrd_file = "EES_DMT_4901.mrd";		//L
      			    }
    			}
     		}else if(temp_LR == "R") {
     			if(temp_incCntrDtail == "N"){
 	   				if(cre_cnt_cd == "IN"){
       				   mrd_file = "EES_DMT_4915.mrd";
       			    }else{
    				   mrd_file = "EES_DMT_4909.mrd";
       			    }
    			}else{
     	   			if(cre_cnt_cd == "IN"){
           			   mrd_file = "EES_DMT_4913.mrd";
           			}else{
     				   mrd_file = "EES_DMT_4902.mrd";		//R
           			}
    			}
     		}
    		/*
    		if(temp_LR == "") {
    			if(temp_incCntrDtail == "N"){
    				mrd_file = "EES_DMT_4908.mrd";
    			}else{
    				mrd_file = "EES_DMT_4901.mrd";		//L
    			}
     		}else if(temp_LR == "L") {
     			if(temp_incCntrDtail == "N"){
   				   	mrd_file = "EES_DMT_4908.mrd";
    			}else{
    				mrd_file = "EES_DMT_4901.mrd";		//L
    			}
     		}else if(temp_LR == "R") {
     			if(temp_incCntrDtail == "N"){
   				   	mrd_file = "EES_DMT_4909.mrd";
    			}else{
     	   			mrd_file = "EES_DMT_4902.mrd";		//R
    			}
     		}
     		*/
    		//2015.10.27 #7995 comment e n d
    		//=========================================
			
//    		//SEND
//    		sndr_id 	= ComGetObjValue(formObj.session_usr_id);
//    		sndr_name	= ComGetObjValue(formObj.session_usr_nm);
//    		sndr_email	= ComGetObjValue(formObj.session_email);
//    		
//    		//RCV
//    		var arr_faxnos 	= fax_nos.split(";");
//    		var re_faxnos	= "";
//    		
//    		for(var i=0; i< arr_faxnos.length; i++) {
//    			re_faxnos	+= ComGetObjValue(formObj.payer_cd)+";"+arr_faxnos[i];
//    			msg1		+= arr_faxnos[i] +"\n\t";
//    		}
    		//rd_fxeml_rd_param
    		var rdParm="/ruseurlmoniker [0]" + " /rfn [" + RDServerIP + "/EES_DMT_4003_RD.do] "		//Search DETAIL DATA
						+ " /rv " + rvParmByInvoice(formObj)
						+ " /rpost [jspno=" + ComGetObjValue(formObj.jspno) + "&invoice_no="+ComGetObjValue(formObj.invoice_no)+"&cre_ofc_cd="+ComGetObjValue(formObj.cre_ofc_cd)+"]"		//jspno, invoice_no
						;
//    		if (!ComShowCodeConfirm("DMT01092", msg1))	return;
    		ComSetObjValue(formObj.invno,					ComGetObjValue(formObj.invoice_no));
    		ComSetObjValue(formObj.payc,					ComGetObjValue(formObj.payer_cd));
    		ComSetObjValue(formObj.rd_fxeml_sys_cd,			"DMT");
			ComSetObjValue(formObj.rd_fxeml_file_name,		mrd_file);
			ComSetObjValue(formObj.rd_fxeml_bat_flg,		"N");
			ComSetObjValue(formObj.rd_fxeml_title,			"Invoice Ref # "+ComGetObjValue(formObj.invoice_no));
			ComSetObjValue(formObj.rd_fxeml_rd_param,		rdParm);
			ComSetObjValue(formObj.rd_fxeml_fax_sndr_id,	"COMPANY");					//sndr_id
			ComSetObjValue(formObj.rd_fxeml_eml_sndr_nm,	"COMPANY");				//sndr_name
			//ComSetObjValue(formObj.rd_fxeml_eml_sndr_add,	sndr_email);		//sndr_email
			ComSetObjValue(formObj.rd_fxeml_eml_rcvr_add,	"");	//rcvr_email	//mjchang@COMPANY.com
			ComSetObjValue(formObj.rd_fxeml_eml_atch_file,	ComGetObjValue(formObj.invoice_no));
			ComSetObjValue(formObj.rd_fxeml_eml_templt,		"EES_DMT_INVOICE_001.html");// Template Location C:/sitectx/OPUSCNTR\APP-INF/config/template/mailtemplate/template.htmlmail
			ComSetObjValue(formObj.rd_fxeml_eml_tmplt_param,"inv_no;" + ComGetObjValue(formObj.invoice_no) + "|bl_no;" + ComGetObjValue(formObj.bl_no));	//"name;mjchang|message;" + mailCtnt);
			ComSetObjValue(formObj.rd_fxeml_doc_tp,			"I");	//  I : Invoice D : Demend G : GroupDemand O : OTS
//    		ComSetObjValue(formObj.f_cmd, SEARCH05);	
//    		
//            //ComOpenWait Start
//            sheetObj.WaitImageVisible=false;
//            ComOpenWait(true);
//
//    		var sXml = sheetObj.GetSaveXml("DMTCommonFaxEmailGS.do", FormQueryString(formObj));
//    		
//            //ComOpenWait End
//            ComOpenWait(false);
//    		
//    		ComShowMessage(dmtGetMsgText(sXml));
    		break;
    	case IBEMAILSEND:
//    		var opener_obj = window.dialogArguments;
//    		var fax_nos = "";
//    		var email_nos = "";
//    		if(ComGetObjValue(form.jspno) == "4016") {
//    			fax_nos 	= opener_obj.document.form2.payr_faxnos.value;
//    			email_nos 	= opener_obj.document.form2.payr_emailnos.value;
//    		}else{
//    			fax_nos 	= opener_obj.document.form.payr_faxnos.value;
//    			email_nos 	= opener_obj.document.form.payr_emailnos.value;
//    		}
//    		if(email_nos == "") {
//    			ComShowCodeMessage("DMT01091");
//    			return;
//    		}
    		var mrd_file="";
//    		var sndr_id		= "";	//id
//    		var sndr_name	= "";	//
//    		var sndr_email	= "";	//
//    		var rcvr_fax_no	= "";	//id;fax_no||id;fax_no
//    		var rcvr_email	= "";	//
//    		var msg1		= "";
    		//MRD file
    		var temp_LR=ComGetObjValue(formObj.invoice_LR);
    		var temp_incCntrDtail	= ComGetObjValue(formObj.inc_cntr_dtail);
    		var rhq	= ComGetObjValue(formObj.rhq_ofc_cd);
    		var ofc_cd = ComGetObjValue(formObj.cre_ofc_cd);
    		var cre_cnt_cd = ComGetObjValue(formObj.cre_cnt_cd);
    		
    		//=========================================
    		//2015.10.27 #7995 comment start
    		//2017.01.12 #23259 India Invocie
    		if(temp_LR == "") {
    			if(temp_incCntrDtail == "N"){
    				if(cre_cnt_cd == "IN"){
     				   mrd_file = "EES_DMT_4914.mrd";
     			    }else{
     			    	mrd_file = "EES_DMT_4908.mrd";
     			    }
    			}else{
      					if(cre_cnt_cd == "IN"){
          				   mrd_file = "EES_DMT_4912.mrd";
          			    }else{
          			    	mrd_file = "EES_DMT_4901.mrd";		//L
          			    }
    			}
    		}else if(temp_LR == "L") {
     			if(temp_incCntrDtail == "N"){
     				if(cre_cnt_cd == "IN"){
     				   mrd_file = "EES_DMT_4914.mrd";
     			    }else{
     			    	mrd_file = "EES_DMT_4908.mrd";
     			    }
    			}else{
      					if(cre_cnt_cd == "IN"){
          				   mrd_file = "EES_DMT_4912.mrd";
          			    }else{
          			    	mrd_file = "EES_DMT_4901.mrd";		//L
          			    }
    			}
    		}else if(temp_LR == "R") {
     			if(temp_incCntrDtail == "N"){
     				if(cre_cnt_cd == "IN"){
     				   mrd_file = "EES_DMT_4915.mrd";
     			    }else{
     			    	mrd_file = "EES_DMT_4909.mrd";
     			    }
    			}else{
      					if(cre_cnt_cd == "IN"){
         				   mrd_file = "EES_DMT_4913.mrd";
         			    }else{
         			    	mrd_file = "EES_DMT_4902.mrd";		//R
         			    }
    			}
    		}
    		/*
    		if(temp_LR == "") {
    			if(temp_incCntrDtail == "N"){
   			    	mrd_file = "EES_DMT_4908.mrd";
    			}else{
   			    	mrd_file = "EES_DMT_4901.mrd";		//L
    			}
    		}else if(temp_LR == "L") {
     			if(temp_incCntrDtail == "N"){
   			    	mrd_file = "EES_DMT_4908.mrd";
    			}else{
   			    	mrd_file = "EES_DMT_4901.mrd";		//L
    			}
    		}else if(temp_LR == "R") {
     			if(temp_incCntrDtail == "N"){
   			    	mrd_file = "EES_DMT_4909.mrd";
    			}else{
   			    	mrd_file = "EES_DMT_4902.mrd";		//R
    			}
    		}
    		*/
    		//2015.10.27 #7995 comment e n d
    		//=========================================
    		
//    		//SEND
//    		sndr_id 	= ComGetObjValue(formObj.session_usr_id);
//    		sndr_name	= ComGetObjValue(formObj.session_usr_nm);
//    		sndr_email	= ComGetObjValue(formObj.session_email);
//    		
//    		//RCV
//    		rcvr_email		= email_nos;
//    		var arr_emails	= email_nos.split(";");
//    		
//    		for(var i=0 ; i < arr_emails.length; i++) {
//    			msg1		+= arr_emails[i] +"\n\t";
//    		}
    		//rd_fxeml_rd_param
    		var rdParm="/ruseurlmoniker [0]" + " /rfn [" + RDServerIP + "/EES_DMT_4003_RD.do] "		//Search DETAIL DATA
						+ " /rv " + rvParmByInvoice(formObj)
						+ " /rpost [jspno=" + ComGetObjValue(formObj.jspno) + "&invoice_no="+ComGetObjValue(formObj.invoice_no)+"&cre_ofc_cd="+ComGetObjValue(formObj.cre_ofc_cd)+"]"		//jspno, invoice_no
						;
//    		if (!ComShowCodeConfirm("DMT01093", msg1))	return;
    		ComSetObjValue(formObj.invno,					ComGetObjValue(formObj.invoice_no));
    		ComSetObjValue(formObj.payc,					ComGetObjValue(formObj.payer_cd));
    		ComSetObjValue(formObj.rd_fxeml_sys_cd,			"DMT");
			ComSetObjValue(formObj.rd_fxeml_file_name,		mrd_file);
			ComSetObjValue(formObj.rd_fxeml_bat_flg,		"N");
			ComSetObjValue(formObj.rd_fxeml_title,			"Invoice Ref # "+ComGetObjValue(formObj.invoice_no));
			ComSetObjValue(formObj.rd_fxeml_rd_param,		rdParm);
			ComSetObjValue(formObj.rd_fxeml_fax_no,			"");			//rcvr_fax_no
			ComSetObjValue(formObj.rd_fxeml_fax_sndr_id,	"COMPANY");					//sndr_id
			ComSetObjValue(formObj.rd_fxeml_eml_sndr_nm,	"COMPANY");				//sndr_name
			ComSetObjValue(formObj.rd_fxeml_eml_sndr_fixed,	"shipment.info@notifications.nykline.com");				// use when should fix sndr_email
			//ComSetObjValue(formObj.rd_fxeml_eml_sndr_add,	sndr_email);		//sndr_email
//			ComSetObjValue(formObj.rd_fxeml_eml_rcvr_add,	email_nos);	//rcvr_email	//mjchang@COMPANY.com
			ComSetObjValue(formObj.rd_fxeml_eml_atch_file,	ComGetObjValue(formObj.invoice_no));
			ComSetObjValue(formObj.rd_fxeml_eml_templt,		"EES_DMT_INVOICE_001.html");// Template Location C:/sitectx/OPUSCNTR\APP-INF/config/template/mailtemplate/template.htmlmail
			ComSetObjValue(formObj.rd_fxeml_eml_tmplt_param,"inv_no;" + ComGetObjValue(formObj.invoice_no) + "|bl_no;" + ComGetObjValue(formObj.bl_no));	//"name;mjchang|message;" + mailCtnt);
			ComSetObjValue(formObj.rd_fxeml_doc_tp,	"I");	//  I : Invoice D : Demend G : GroupDemand O : OTS
//			ComSetObjValue(formObj.f_cmd, SEARCH06);
//			
//            //ComOpenWait Start
//            sheetObj.WaitImageVisible=false;
//            ComOpenWait(true);
//			
//    		var sXml = sheetObj.GetSaveXml("DMTCommonFaxEmailGS.do", FormQueryString(formObj));
//    		
//            //ComOpenWait End
//            ComOpenWait(false);
//    		
//    		ComShowMessage(dmtGetMsgText(sXml));
    		break;        
        }
    }
    /**
	 * EES_DMT_4101, EES_DMT_4103 call
	 * @param formObj
	 * @param srcName
	 * @return
	 */
	function openPopupWindow(formObj, srcName) {
		var opener=window.dialogArguments;
		if (!opener) opener=window.opener;  //이 코드 추가할것
		if (!opener) opener=parent;    
		if(srcName == "btn_fax") {
			if(ComGetObjValue(formObj.payer_cd) == null || ComGetObjValue(formObj.payer_cd) == "") {
				ComShowCodeMessage("DMT00182");
				return;
			}
			var ofc_cd=ComGetObjValue(formObj.cre_ofc_cd);
			var cust_cntc_pnt_seq="";
			if(ComGetObjValue(document.form.jspno) == "4002") {
				cust_cntc_pnt_seq=opener.cust_cntc_pnt_seq.value;
	    	}
	    	else if(ComGetObjValue(document.form.jspno) == "4004") {
	    		cust_cntc_pnt_seq=opener.cust_cntc_pnt_seq.value;
	    	}
	    	else if(ComGetObjValue(document.form.jspno) == "4016") {
	    		cust_cntc_pnt_seq=opener.cust_cntc_pnt_seq.value;
	    	}
			var url="EES_DMT_4107.do"
				+"?s_ofc_cd="+ofc_cd
				+"&s_cust_cd="+ComGetObjValue(formObj.payer_cd)
				+"&s_bkg_no="+ComGetObjValue(formObj.bkg_no)
				+"&s_pod_cd="+ComGetObjValue(formObj.pod_cd)
				+"&jspno=4003"
				+"&telno="+ComGetObjValue(formObj.payr_cntc_pnt_phn_no)
				+"&faxno="+ComGetObjValue(formObj.payr_cntc_pnt_fax_no)
				+"&email="+ComGetObjValue(formObj.payr_cntc_pnt_eml)
				+"&cntc_seq="+cust_cntc_pnt_seq
				;
			ComOpenWindowCenter(url, "EES_DMT_4107", "520","250", true);
		}else if(srcName == "btn_email") {
			if(ComGetObjValue(formObj.payer_cd) == null || ComGetObjValue(formObj.payer_cd) == "") {
				ComShowCodeMessage("DMT00182");
				return;
			}

			var ofc_cd=ComGetObjValue(formObj.cre_ofc_cd);
			var cust_cntc_pnt_seq="";
			if(ComGetObjValue(document.form.jspno) == "4002") {
				cust_cntc_pnt_seq=opener.document.form.cust_cntc_pnt_seq.value;
	    	}
	    	else if(ComGetObjValue(document.form.jspno) == "4004") {
	    		cust_cntc_pnt_seq=opener.document.form.cust_cntc_pnt_seq.value;
	    	}
	    	else if(ComGetObjValue(document.form.jspno) == "4016") {
	    		cust_cntc_pnt_seq=opener.document.form2.cust_cntc_pnt_seq.value;
	    	}
			var url="EES_DMT_4108.do"
				+"?s_ofc_cd="+ofc_cd
				+"&s_cust_cd="+ComGetObjValue(formObj.payer_cd)
				+"&s_bkg_no="+ComGetObjValue(formObj.bkg_no)
				+"&s_pod_cd="+ComGetObjValue(formObj.pod_cd)
				+"&jspno=4003"
				+"&telno="+ComGetObjValue(formObj.payr_cntc_pnt_phn_no)
				+"&faxno="+ComGetObjValue(formObj.payr_cntc_pnt_fax_no)
				+"&email="+ComGetObjValue(formObj.payr_cntc_pnt_eml)
				+"&cntc_seq="+cust_cntc_pnt_seq
				;
			ComOpenWindowCenter(url, "EES_DMT_4108", "520","250", true);
		}
//		if(srcName == "btn_set") {
//			var url = "EES_DMT_4101.do"
//				+"?issoff="+ComGetObjValue(formObj.cre_ofc_cd)
//				+"&tftp2="+ComGetObjValue(formObj.dmdt_trf_cd)
//				+"&sheetp=I"
//				+"&invoice_issue=2"
//				+"&jspno=EES_DMT_4003";
//			var returnValue = ComOpenWindowCenter(url, "EES_DMT_4101", "725","780", true);
//		}else if(srcName == "btn_option") {
//			var url = "EES_DMT_4103.do"
//				+"?issoff="+ComGetObjValue(formObj.cre_ofc_cd)
//				+"&jspno=EES_DMT_4003"
//				+"&invoice_issue=2"
//				;
//			var returnValue = ComOpenWindowCenter(url, "EES_DMT_4103", "625","650", true);
//		}else if(srcName == "btn_payerfaxemail") {
//
//			var url = "EES_DMT_4104.do"
//				+"?s_ofc_cd="+ComGetObjValue(formObj.cre_ofc_cd)
//				+"&s_cust_cd="+ComGetObjValue(formObj.payer_cd)
//				+"&s_bkg_no="+ComGetObjValue(formObj.bkg_no)
//				+"&s_pod_cd="+ComGetObjValue(formObj.pod_cd)
//			var returnValue = ComOpenWindowCenter(url, "EES_DMT_4104", "825","600", true);
//		}else if(srcName == "btn_remark") {
//			var invoice_no = ComGetObjValue(formObj.invoice_no);
//			
//			var url = "EES_DMT_4105.do"
//				+"?jspno=4003"
//				+"&invno="+invoice_no	
//				;
//
//			var returnValue = ComOpenWindowCenter(url, "EES_DMT_4105", "920","250", true);
//		}
	}   
	// Retrieving conditions fields Combo 
    function doActionIBCombo(sheetObj,formObj,sAction,sComboAction,sComboKey,sObj) {
        sheetObj.ShowDebugMsg(false);
		sheetObj.SetWaitImageVisible(0);
		switch(sAction) {
        	case IBSEARCH:      // Search
				if (sheetObj.id == "sheet1") {
					switch(sComboAction) {
						//Payer's Email, FAX number is Retrieving.
						case COMMAND02:
							//1.Setting parametor condition, before retrieving
//							ComSetObjValue(formObj.f_cmd, COMMAND02);
//							setComboParameters(sComboAction, sObj);
							var param="f_cmd=" + COMMAND02
									  + "&payer_cd=" + formObj.payer_cd.value 
									  + "&dmdt_trf_cd=" + formObj.dmdt_trf_cd.value 
									  + "&ofc_cd=" + formObj.cre_ofc_cd.value
									  ;              
 							var sXml=sheetObj.GetSearchData("EES_DMT_4002GS.do", param);
							//2.retrievie according to conditions					
							//var sXml = sheetObj.GetSearchXml("EES_DMT_4002GS.do", FormQueryString(formObj));
							//3.After handling Retrieving results
							//ComSetObjValue(formObj.payr_faxnos, 	ComGetEtcData(sXml, "FAX_NO"));
							//ComSetObjValue(formObj.payr_emailnos, 	ComGetEtcData(sXml, "EMAIL_NO"));
							break;
						//Retrieving of SHEET SET exists
						case COMMAND13:
							//1.Setting parametor condition, before retrieving
							ComSetObjValue(formObj.f_cmd, COMMAND13);
							setComboParameters(sComboAction, sObj);
							//2.retrievie according to conditions					
 							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							//3.After handling Retrieving results
							ComSetObjValue(formObj.has_sheetset, 	ComGetEtcData(sXml, "RESULT"));
							break;
					}
				};
                break;
        }
		sheetObj.SetWaitImageVisible(1);
    }
    function setComboParameters(sComboAction, sObj) {
    	var formObj=document.form;
    	if(sComboAction == COMMAND13) {
    		ComSetObjValue(formObj.dmdt_sh_tp_cd, 	"I");
			ComSetObjValue(formObj.ofc_cd, 			ComGetObjValue(formObj.cre_ofc_cd));
    	}else if(sComboAction == COMMAND02) {
    		ComSetObjValue(formObj.ofc_cd, 			ComGetObjValue(formObj.cre_ofc_cd));
    	}
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
//        with(formObj){
//    		
////    		switch(sAction) {
////    			case IBSAVE:
////    				if(ComGetObjValue(formObj.payer_cd) == "") {
////    					ComAlertFocus(formObj.payer_cd, ComGetMsg("DMT01052"));
////						return false;
////    				}
////    				break;
////    		}
//        }
//
//        return true;
    }
    function dmtGetMsgText(xmlStr){
        try {
        	var xmlDoc = ComGetXmlDoc(xmlStr);
        	if (xmlDoc == null) return;
        	var xmlRoot = xmlDoc.documentElement;
            if(xmlRoot == null) return;
            var msgNode=xmlRoot.getElementsByTagName("MESSAGE").item(0);
            if(msgNode == null) 
             return;
            else
             return msgNode.firstChild.nodeValue;
       } catch(err) { ComFuncErrMsg(err.message); }
    }    