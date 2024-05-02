/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_3109.jsp
*@FileTitle  : Demand Note Issue by Booking
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30
=========================================================*/

   	/* Developer's task	*/
	//common global variables
//    var rdObjects=new Array();
//	rdObjects[0] = document.getElementById("Demand"); 
//    var rdCnt=0;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var ROWMARK="|";
	var FIELDMARK="=";
	
	var DEF_SHEET_HEIGHT = 180;
	
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
		/***** Tab sheets per case more than two additional sheets are used to specify a variable *****/
		var sheetObject1=sheetObjects[0];
		/*******************************************************/
		/*******************************************************/
    	var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
	            case "btn_payer_cd":
	         		openPopup('payer_cd');
					break;
	            case "btn_trucker_cd":
	            	openPopup('trucker_cd');
	            	break;
            	case "btn_set":
            		if(ComIsBtnEnable(srcName)) {
            			openPopupWindow(sheetObject1, formObject, srcName);
            		}
					break; 
            	case "btn_option":
            		if(ComIsBtnEnable(srcName)) {
            			openPopupWindow(sheetObject1, formObject, srcName);
            		}
            		break;
            	case "btn_sendinghistory":
            		if(ComIsBtnEnable(srcName)) {
            			openPopupWindow(sheetObject1, formObject, srcName);
            		}
            		break;                    		
				case "btn_preview":
					if(ComIsBtnEnable(srcName)) {
						var payerCd=ComGetObjValue(formObject.payer_cd);
						if(payerCd == ''){
							ComShowCodeMessage('DMT00182');
							ComSetFocus(formObject.payer_cd);
							return;
						} else {
							if (!validateSheetSetForBooking()) {
								ComShowCodeMessage('DMT01096');
								return false;
							}
//							ComOpenPopupWithTarget('EES_DMT_3007.do', 920, 740, "", "0,1,1,1,1,1,1", true);
							//ComOpenPopup('/opuscntr/EES_DMT_3007.do?', 920, 740, 'getYard', "0,1", false); 
							ComOpenPopup("EES_DMT_3007.do", 910, 670, "getYard", "0,1", true);
						}
					}
					break;
				case "btn_print":
					if(ComIsBtnEnable(srcName)) {
						var payerCd=ComGetObjValue(formObject.payer_cd);
						if(payerCd == ''){
							ComShowCodeMessage('DMT00182');
							ComSetFocus(formObject.payer_cd);
							return;
						} else {
							if (!validateSheetSetForBooking()) {
								ComShowCodeMessage('DMT01096');
								return false;
							}
							//ComOpenWait Start
		 					sheetObject1.SetWaitImageVisible(0);
		 		        	ComOpenWait(true);
							//init RD config
							initRdConfig();
							rdOpen();
							//ComOpenWait End
							ComOpenWait(false);
						}
					}
					break;
				case "btn_fax":
					if(ComIsBtnEnable(srcName)) {
						if (!validateSheetSetForBooking()) {
							ComShowCodeMessage('DMT01096');
							return false;
						}
						sendFaxEmail("fax");
						openPopupWindow(sheetObject1, formObject, srcName);
					}
					break;
				case "btn_email":
					if(ComIsBtnEnable(srcName)) {
						if (!validateSheetSetForBooking()) {
							ComShowCodeMessage('DMT01096');
							return false;
						}
						sendFaxEmail("email");
						openPopupWindow(sheetObject1, formObject, srcName);
					}
					break;	
				case "btn_payerfaxemail":
					if(ComIsBtnEnable(srcName)) {
						var payerCd=ComGetObjValue(formObject.payer_cd);
						if(payerCd == ''){
							ComShowCodeMessage('DMT00182');
							ComSetFocus(formObject.payer_cd);
							return;
						} else {
							openPopupWindow(sheetObject1, formObject, srcName);
						}
					}
					break; 
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
	 * Sheet Set data should determine whether. If you do not have the data processing does not RD. 
	 */
	function validateSheetSetForBooking(){
   	 	var formObj=document.form;
   	 	var opnSheetObj=document.sheet1;
   	 	var sheetObj2=sheetObjects[1]; 
   	 	makeDataByBooking(formObj, opnSheetObj, sheetObj2);
		if(  ComGetObjValue(formObj.ofc_add01) == ''
			  && ComGetObjValue(formObj.ofc_add02) == '' 
			  && ComGetObjValue(formObj.ofc_add03) == '' 
			  && ComGetObjValue(formObj.header01) == '' 
			  && ComGetObjValue(formObj.header02) == '' 
			  && ComGetObjValue(formObj.header03) == '' 
			  && ComGetObjValue(formObj.header04) == '' 
			  && ComGetObjValue(formObj.header05) == '' 
			  && ComGetObjValue(formObj.sheet_remark01) == '' 
			  && ComGetObjValue(formObj.sheet_remark02) == '' 
			  && ComGetObjValue(formObj.sheet_remark03) == '' 
			  && ComGetObjValue(formObj.sheet_remark04) == '' 
			  && ComGetObjValue(formObj.sheet_remark05) == ''
			  && ComGetObjValue(formObj.sheet_remark06) == ''
			  && ComGetObjValue(formObj.sheet_remark07) == ''
			  && ComGetObjValue(formObj.sheet_remark08) == ''
			  && ComGetObjValue(formObj.sheet_remark09) == ''
			  && ComGetObjValue(formObj.sheet_remark10) == ''
			  && ComGetObjValue(formObj.sheet_remark11) == ''
			  && ComGetObjValue(formObj.sheet_remark12) == ''
			  && ComGetObjValue(formObj.sheet_remark13) == ''
			  && ComGetObjValue(formObj.sheet_remark14) == '' ){
    		 //ComShowCodeMessage('DMT01096');  
    		 return false;
   	  	} 
   	  	return true;
	}
    /**
    * init RD
    * index : Index of toolbar items to be disabled. 0-Save a  file, 1-Print, 2-Find, 3-Creating a table of contents, 
    * 4-Zoom-in the screen, 5-Zoom-out the screen, 12-Stop printing, 13-View in Microsoft Excel, 14-View in Hangul, 
    * 15-View in pdf, 16-View in Microsoft PowerPoint, 17-View in Microsoft Word.
    * @return
    */
	function initRdConfig() {
//	   var Rdviewer = rdObject;
//	   Rdviewer.AutoAdjust=false;
//	   Rdviewer.ApplyLicense("0.0.0.0");
//	   Rdviewer.HideStatusBar();
//	   Rdviewer.ViewShowMode(0);
//	   Rdviewer.SetPageLineColor(255,255,255);
//		var hiddenParam = ["save"];
//        Rdviewer.hideToolbarItem(hiddenParam);
	}
	/**
    * call rd report
    * @return
    */
	function rdOpen(){
//		var Rdviewer = rdObject;
   	 	var formObj=document.form;
   	 	var opnSheetObj=document.sheet1;
   	 	var sheetObj2=sheetObjects[1]; 
   	 	var usr_cnt_cd = ComGetObjValue(formObj.usr_cnt_cd);
   	 	
		 makeDataByBooking(formObj, opnSheetObj, sheetObj2);
		 

 		var appendReport = [];
		 //RD - Right
 		if(ComGetObjValue(formObj.bil_to_loc_div_cd) == 'R'){
 			var mrdPath = RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/demandnotesend/report/EES_DMT_3902.mrd';
	  	 } 
	  	 //RD - Left
	  	 else {
	  		var mrdPath = RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/demandnotesend/report/EES_DMT_3901.mrd';
	  	 }
 		var mrdParam = " /ruseurlmoniker [0] /rv " + rvParmByBooking(formObj) + " /rfn [" + RDServerIP + "/EES_DMT_3007_RD.do] /rpost [" + sheetObjects[0].GetSaveString(false, true, "checkBox") + "]";
 		appendReport.push({mrdPath:mrdPath,mrdParam:mrdParam});
 		directReportDownload(appendReport);
		 
		 
		 //var opnSheetParm = sheetObjects[0].GetSaveString(false, true, "checkBox");
		 //3.rv param
		 // var rvParam = rvParmByBooking(formObj);
//		 var rdParm=" /ruseurlmoniker [0] /rv " + rvParmByBooking(formObj) + " /rfn [" + RDServerIP + "/EES_DMT_3007_RD.do] /rpost [" + sheetObjects[0].GetSaveString(false, true, "checkBox") + "]";
//		 //ComDebug(rdParm);
//		 //RD - Right
//    	 if(ComGetObjValue(formObj.bil_to_loc_div_cd) == 'R'){
////    		  if(usr_cnt_cd == 'IN'){
////    			  Rdviewer.openFile(RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/demandnotesend/report/EES_DMT_3906.mrd', rdParm);
////    		  }else {
//    			  Rdviewer.openFile(RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/demandnotesend/report/EES_DMT_3902.mrd', rdParm, {timeout:1800});
////    		  }
//    	 } 
//    	 //RD - Left
//    	 else {
////    		 if(usr_cnt_cd == 'IN'){
////    			 Rdviewer.openFile(RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/demandnotesend/report/EES_DMT_3905.mrd', rdParm);
////    		 }else{
//    			 Rdviewer.openFile(RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/demandnotesend/report/EES_DMT_3901.mrd', rdParm, {timeout:1800});
////    		 }
//    	 }    	
//  	 	 //rd print
//    	 Rdviewer.print({isServerSide:true});
  	 	 //as-is
   	 	//previewByBooking(formObj, opnSheetObj, sheetObj2);
	}  
   /**
    * preview By Demand Booking 
    */  
//	function previewByBooking(formObj, opnSheetObj, sheetObj2){
//		 makeDataByBooking(formObj, opnSheetObj, sheetObj2);
//		 //var opnSheetParm = sheetObjects[0].GetSaveString(false, true, "checkBox");
//		 //3.rv param
//		 // var rvParam = rvParmByBooking(formObj);
//		 var rdParm = "/rv " + rvParmByBooking(formObj) + " /rfn [" + RDServerIP + "/EES_DMT_3007_RD.do] /rpost [" + sheetObjects[0].GetSaveString(false, true, "checkBox") + "]";
////		 ComDebug(rdParm);
//		 //RD - Right
//     	 if(ComGetObjValue(formObj.bil_to_loc_div_cd) == 'R'){
//     		 rdObjects[0].FileOpen(RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/demandnotesend/report/EES_DMT_3902.mrd', rdParm);
//     	 } 
//     	 //RD - Left
//     	 else {
//     		 rdObjects[0].FileOpen(RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/demandnotesend/report/EES_DMT_3901.mrd', rdParm);
//     	 }    	
//     	 
//   	 	 //rd print
//		 rdObjects[0].PrintDialog();
//	}
    /**
     * rv By Demand Booking 
     */ 
    function rvParmByBooking(formObj){
    	var	rvRaram=" OFC_ADD01[" + ComGetObjValue(formObj.ofc_add01)					+"]" +	
					" OFC_ADD02[" + ComGetObjValue(formObj.ofc_add02) 					+"]" +
					" OFC_ADD03[" + ComGetObjValue(formObj.ofc_add03) 					+"]" +
					" TITLE[*** " + ComGetObjValue(formObj.title) 						+" ***]" +
					" PRINT_DATE[" + ComGetObjValue(formObj.print_date) 				+"]" +
					" CUST_NAME[" + ComGetObjValue(formObj.cust_nm)			 			+"]" +
					" ADDRESS01[" + ComGetObjValue(formObj.address01) 					+"]" +
					" ADDRESS02[" + ComGetObjValue(formObj.address02) 					+"]" +
					" ADDRESS03[" + ComGetObjValue(formObj.address03) 					+"]" +
					" ADDRESS04[" + ComGetObjValue(formObj.address04) 					+"]" +
					" ATTN_NAME[" + ComGetObjValue(formObj.dmdt_payr_cntc_pnt_nm) 		+"]" +
					" TEL_NO[" + ComGetObjValue(formObj.payr_cntc_pnt_phn_no) 			+"]" +
					" FAX_NO[" + ComGetObjValue(formObj.payr_cntc_pnt_fax_no) 			+"]" +
					" COM_REF[" + ComGetObjValue(formObj.com_ref) 						+"]" +
					" CUST_CODE[" + ComGetObjValue(formObj.payer_cd) 					+"]" +
					" CUST_VAT[" + ComGetObjValue(formObj.cust_vat) 					+"]" +
					" HEADER01[" + ComGetObjValue(formObj.header01) 					+"]" +
					" HEADER02[" + ComGetObjValue(formObj.header02) 					+"]" +
					" HEADER03[" + ComGetObjValue(formObj.header03) 					+"]" +
					" HEADER04[" + ComGetObjValue(formObj.header04) 					+"]" +
					" HEADER05[" + ComGetObjValue(formObj.header05) 					+"]" +
					" SHEET_REMARK01[" + ComGetObjValue(formObj.sheet_remark01) 		+"]" +
					" SHEET_REMARK02[" + ComGetObjValue(formObj.sheet_remark02) 		+"]" +
					" SHEET_REMARK03[" + ComGetObjValue(formObj.sheet_remark03) 		+"]" +
					" SHEET_REMARK04[" + ComGetObjValue(formObj.sheet_remark04) 		+"]" +
					" SHEET_REMARK05[" + ComGetObjValue(formObj.sheet_remark05) 		+"]" +
					" SHEET_REMARK06[" + ComGetObjValue(formObj.sheet_remark06) 		+"]" +
					" SHEET_REMARK07[" + ComGetObjValue(formObj.sheet_remark07) 		+"]" +
					" SHEET_REMARK08[" + ComGetObjValue(formObj.sheet_remark08) 		+"]" +
					" SHEET_REMARK09[" + ComGetObjValue(formObj.sheet_remark09) 		+"]" +
					" SHEET_REMARK10[" + ComGetObjValue(formObj.sheet_remark10) 		+"]" +
					" SHEET_REMARK11[" + ComGetObjValue(formObj.sheet_remark11) 		+"]" +
					" SHEET_REMARK12[" + ComGetObjValue(formObj.sheet_remark12) 		+"]" +
					" SHEET_REMARK13[" + ComGetObjValue(formObj.sheet_remark13) 		+"]" +
					" SHEET_REMARK14[" + ComGetObjValue(formObj.sheet_remark14) 		+"]" +
					" VVD_CD[" + ComGetObjValue(formObj.vvd_cd) 						+"]" +
					" VVD_NM[" + ComGetObjValue(formObj.vvd_nm) 						+"]" +
					" ARR[" + ComGetObjValue(formObj.arr) 								+"]" +
					" DEP[" + ComGetObjValue(formObj.dep) 								+"]" +
					" BL_NO[" + ComGetObjValue(formObj.bl_no) 							+"]" +
					" BKG_NO[" + ComGetObjValue(formObj.bkg_no) 						+"]" +
					" COMMODITY[" + ComGetObjValue(formObj.cmdt_nm) 					+"]" +
					" CHARGE[" + ComGetObjValue(formObj.dmdt_trf_cd) 					+"]" +
					" CHARGE_NM[" + ComGetObjValue(formObj.dmdt_trf_nm) 				+"]" +
					" RCV_TERM[" + ComGetObjValue(formObj.bkg_rcv_term_nm) 				+"]" +
					" DEL_TERM[" + ComGetObjValue(formObj.bkg_del_term_nm) 				+"]" +
					" POD[" + ComGetObjValue(formObj.pod) 								+"]" +
					" POD_NM[" + ComGetObjValue(formObj.pod_nm) 						+"]" +
					" DEL[" + ComGetObjValue(formObj.del) 								+"]" +
					" DEL_NM[" + ComGetObjValue(formObj.del_nm) 						+"]" +
					" TRUCKER[" + ComGetObjValue(formObj.trucker_nm) 					+"]" +
					//" tot_org_amt[" + ComGetObjValue(formObj.tot_org_amt)	 			+"]" +
					//" org_curr_cd[" + ComGetObjValue(formObj.org_curr_cd) 				+"]" +
					" EX_RATE[" + ComGetObjValue(formObj.ex_rate) 						+"]" +
					" CAL_SUB_TOTAL[" + ComGetObjValue(formObj.tot_amt) 				+"]" +
					" DC_AMOUNT[" + ComGetObjValue(formObj.dc_amt) 						+"]" +
					" NET_AMOUNT[" + ComGetObjValue(formObj.inv_chg_amt) 				+"]" +
					" TAX[" + ComGetObjValue(formObj.tax_rto_dis) 						+"]" +
					" VAT[" + ComGetObjValue(formObj.tax_amt) 							+"]" +
					" TAX_NM[" + ComGetObjValue(formObj.tax_nm)							+"]" +
					" TOTAL_AMOUNT_DUE[" + ComGetObjValue(formObj.inv_amt) 				+"]" +
					" INV_CURR_CD[" + ComGetObjValue(formObj.inv_curr_cd) 				+"]" +
					//" bil_to_loc_div_cd[" + ComGetObjValue(formObj.bil_to_loc_div_cd) 			+"]" +
					" CUSTREF[" + ComGetObjValue(formObj.cust_ref_prn_flg) 				+"]" +
					" TELFAX[" + ComGetObjValue(formObj.phn_fax_prn_flg) 				+"]" +
					" CUSTVATNO[" + ComGetObjValue(formObj.cust_vat_prn_flg) 			+"]" +
					" TAXAMT[" + ComGetObjValue(formObj.tax_amt_prn_flg) 				+"]" +
					" DCAMT[" + ComGetObjValue(formObj.dc_amt_prn_flg) 					+"]" +
					" RD_IDA_EXPN_TAX_RT[" + ComGetObjValue(formObj.ida_expn_tax_rt) +"]" +
					" RD_IDA_EXPN_TAX[" + ComGetObjValue(formObj.ida_expn_tax) +"]" +
					" RD_IDA_EDU_TAX_RT[" + ComGetObjValue(formObj.ida_edu_tax_rt) +"]" +
					" RD_IDA_EDU_TAX[" + ComGetObjValue(formObj.ida_edu_tax) +"]" +
					" RD_IDA_HIGH_EDU_TAX_RT[" + ComGetObjValue(formObj.ida_high_edu_tax_rt) +"]" +
					" RD_IDA_HIGH_EDU_TAX[" + ComGetObjValue(formObj.ida_high_edu_tax) +"]" +
					" RD_TAX_RGST_NO[" + ComGetObjValue(formObj.tax_rgst_no) +"]" +
					" RD_SVC_CATE_RMK[" + ComGetObjValue(formObj.svc_cate_rmk) +"]" +
					" RD_PMNT_ACCT_NO[" + ComGetObjValue(formObj.pmnt_acct_no) +"]"
					;
    	return rvRaram;
    }
	/**
    *  the data for RD call and reset
    */    
	function makeDataByBooking(formObj, opnSheetObj, sheetObj2){
//  		ComSetObjValue(formObj.ofc_cd, 			opener.document.form.ofc_cd.value);
//  		ComSetObjValue(formObj.dmdt_trf_cd, 	opener.document.form.dmdt_trf_cd.value);
//  		ComSetObjValue(formObj.payer_cd, 		opener.document.form.payer_cd.value);
//  		ComSetObjValue(formObj.payer_nm, 		opener.document.form.payer_nm.value);
  		ComSetObjValue(formObj.trucker, 			document.form.trucker_nm.value);
  		if(ComGetObjValue(document.form.dmdt_payr_cntc_pnt_nm) == 'null'){
  			ComSetObjValue(formObj.dmdt_payr_cntc_pnt_nm, '');
  		} else {
  			ComSetObjValue(formObj.dmdt_payr_cntc_pnt_nm, document.form.dmdt_payr_cntc_pnt_nm.value);
  		}
//  		ComSetObjValue(formObj.payr_cntc_pnt_phn_no, 	opener.document.form.payr_cntc_pnt_phn_no.value);
//  		ComSetObjValue(formObj.payr_cntc_pnt_fax_no, 	opener.document.form.payr_cntc_pnt_fax_no.value);
//  		ComSetObjValue(formObj.payr_cntc_pnt_eml, 		opener.document.form.payr_cntc_pnt_eml.value);
//  		ComSetObjValue(formObj.inv_curr_cd, 			opener.document.form.inv_curr_cd.value);
//  		ComSetObjValue(formObj.bkg_no, 					opener.document.form.bkg_no.value);
  		//RD: TOTAL PART 
  		ComSetObjValue(formObj.org_curr_cd, 			document.form.chg_curr_cd.value); 
  		ComSetObjValue(formObj.tot_org_amt, 			document.form.mn_bil_amt.value); 
  		//total
  		ComSetObjValue(formObj.ex_rate, 				document.form.inv_xch_rt.value); 
//  		ComSetObjValue(formObj.tot_amt, 				opener.document.form.tot_amt.value);
//  		ComSetObjValue(formObj.dc_amt, 					opener.document.form.dc_amt.value);
//  		ComSetObjValue(formObj.inv_chg_amt, 			opener.document.form.inv_chg_amt.value);
//  		ComSetObjValue(formObj.tax_amt, 				opener.document.form.tax_amt.value);
//  		ComSetObjValue(formObj.inv_amt, 				opener.document.form.inv_amt.value);
//  		ComSetObjValue(formObj.tax_rto_dis, 			opener.document.form.tax_rto_dis.value);
  		ComSetObjValue(formObj.tmp_payer_cd, 	ComGetObjValue(formObj.payer_cd));
  		if(ComGetObjValue(formObj.payer_cd).length == 6) {
  			ComSetObjValue(formObj.payer_cd, 		"00" + ComGetObjValue(formObj.payer_cd));
  		}
  		formObj.f_cmd.value=SEARCH01;	
   		var sXml=sheetObj2.GetSearchData("EES_DMT_3007GS.do",	FormQueryString(formObj));
  		sheetObj2.LoadSearchData(sXml,{Sync:1} );
  		ComEtcDataToForm(formObj, sheetObj2);
  		ComSetObjValue(formObj.payer_cd, 	ComGetObjValue(formObj.tmp_payer_cd));
  		if(!ComIsEmpty ( ComGetObjValue(formObj.address01) )){	
			  var temp=ComGetObjValue(formObj.address01).split("|");
			  ComSetObjValue(formObj.cust_nm,		temp[0]);			
		      ComSetObjValue(formObj.address01, 	temp[1]);	
   	  	} else {
   	  		  ComSetObjValue(formObj.cust_nm,		"");			
   	  		  ComSetObjValue(formObj.address01, 	"");	   	  			
   	  	}
   	  	if ( !ComIsEmpty ( ComGetObjValue(formObj.address01) ) ) {
   	  		var paryInfoAddr=ComGetObjValue(formObj.address01).split("\n");
   	  		var paryInfoAddrCnt=paryInfoAddr.length;
   	  		if ( paryInfoAddrCnt >= 1 ) {
   	  			document.form.address01.value=ComReplaceStr(paryInfoAddr[0],"'"," ");
   	  		} else {
   	  			document.form.address01.value="";
   	  		}
   	  		if ( paryInfoAddrCnt >= 2 ) {
   	  			document.form.address02.value=ComReplaceStr(paryInfoAddr[1],"'"," ");
   	  		} else {
   	  			document.form.address02.value="";
   	  		}
   	  		if ( paryInfoAddrCnt >= 3 ) {
   	  			document.form.address03.value=ComReplaceStr(paryInfoAddr[2],"'"," ");
   	  		} else {
   	  			document.form.address03.value="";
	        }
   	  		if ( paryInfoAddrCnt >= 4 ) {
   	  			document.form.address04.value=ComReplaceStr(paryInfoAddr[3],"'"," ");
	        } else {
	        	document.form.address04.value="";
	        }
   	  	} else {
//	    	document.form.address01.value = ComReplaceStr(paryInfoArr[2],"'"," ");
//document.form.address02.value = ComReplaceStr(paryInfoArr[2],"'"," ");
//document.form.address03.value = ComReplaceStr(paryInfoArr[2],"'"," ");
//document.form.address04.value = ComReplaceStr(paryInfoArr[2],"'"," ");
document.form.address01.value="";
document.form.address02.value="";
document.form.address03.value="";
document.form.address04.value="";
   	  	}
  		if(!ComIsEmpty ( ComGetObjValue(formObj.sh_num) )){
  			temp=ComGetObjValue(formObj.sh_num).split("|");
  			ComSetObjValue(formObj.bil_to_loc_div_cd,	temp[0]);			
  			ComSetObjValue(formObj.cust_ref_prn_flg, 	temp[1]);	
  			ComSetObjValue(formObj.phn_fax_prn_flg, 	temp[2]);		
  			ComSetObjValue(formObj.cust_vat_prn_flg, 	temp[3]);		
  			ComSetObjValue(formObj.tax_amt_prn_flg,   	temp[4]);
  			ComSetObjValue(formObj.dc_amt_prn_flg,   	temp[5]);
  		} else {
  			ComSetObjValue(formObj.bil_to_loc_div_cd,	"");			
  			ComSetObjValue(formObj.cust_ref_prn_flg, 	"");	
  			ComSetObjValue(formObj.phn_fax_prn_flg, 	"");		
  			ComSetObjValue(formObj.cust_vat_prn_flg, 	"");		
  			ComSetObjValue(formObj.tax_amt_prn_flg,   	"");
  			ComSetObjValue(formObj.dc_amt_prn_flg,   	"");
  		}
	}		
	function sendFaxEmail(sendType){
     	var formObj=document.form;
     	//var opener = window.dialogArguments;
	 	var opnSheetObj=document.sheet1;
	 	var sheetObj=sheetObjects[1];
	 	var usr_cnt_cd = ComGetObjValue(formObj.usr_cnt_cd);
	 	makeDataByBooking(formObj, opnSheetObj, sheetObj);
	 	//var opnSheetParm = opener.sheetObjects[0].GetSaveString(false, true, "checkBox");
	 	//3.rv param
	 	// var rvParam = rvParmByBooking(formObj);
	 	var rdParm=" /ruseurlmoniker [0] /rv " + rvParmByBooking(formObj) + " /rfn [" + RDServerIP + "/EES_DMT_3007_RD.do] /rpost [" + sheetObjects[0].GetSaveString(false, true, "checkBox") + "]";
	 	ComSetObjValue(formObj.rd_fxeml_rd_param, 	rdParm);
	 	faxEmaiInfo(formObj, opnSheetObj, sheetObj);
	 	if(ComGetObjValue(formObj.bil_to_loc_div_cd) == 'R'){
//			if(usr_cnt_cd == 'IN'){
//	 		    ComSetObjValue(formObj.rd_fxeml_file_name, 	 "EES_DMT_3906.mrd");
//			}else{
				ComSetObjValue(formObj.rd_fxeml_file_name, 	 "EES_DMT_3902.mrd");
//			}
		} 
		//RD - Left
		else {
//			if(usr_cnt_cd == 'IN'){
//				ComSetObjValue(formObj.rd_fxeml_file_name, 	"EES_DMT_3905.mrd");
//			}else{
				ComSetObjValue(formObj.rd_fxeml_file_name, 	"EES_DMT_3901.mrd");
//			}
		}	
// 	 	var sndr_id		= "";	//id
//		var sndr_name	= "";	//
//		var sndr_email	= "";	//
//		var rcvr_fax_no	= "";	//id;fax_no||id;fax_no
//		var rcvr_email	= "";	//
//		var msg1		= "";
//		
//		//SEND
//		sndr_id 	= ComGetObjValue(formObj.session_usr_id);
//		sndr_name	= ComGetObjValue(formObj.session_usr_nm);
//		sndr_email	= ComGetObjValue(formObj.session_email);
//		
//		
//		//RCV
//		if(sendType == "fax"){
//			if(formObj.payr_faxnos.value == "" || formObj.payr_faxnos.value == ";" || formObj.payr_faxnos.value == "null") {
//    			ComShowCodeMessage("DMT01090");
//    			return;
//    		}
//			
//			var arr_faxnos 	= formObj.payr_faxnos.value.split(";");
//    		var re_faxnos	= "";
//    		
//    		for(var i=0; i< arr_faxnos.length; i++) {
//    			re_faxnos	+= formObj.payer_cd.value +";"+arr_faxnos[i];
//    			msg1		+= arr_faxnos[i] +"\n\t";
//    		}
//    		if (!ComShowCodeConfirm("DMT01092", msg1))	return;
//    		
//		} else if(sendType == "email"){
//    		if(formObj.payr_emailnos.value == "" || formObj.payr_emailnos.value == ";") {
//    			ComShowCodeMessage("DMT01091");
//    			return;
//    		}
//			rcvr_email		= formObj.payr_emailnos.value;  //payr_emailnos
//    		var arr_emails	= formObj.payr_emailnos.value.split(";"); //payr_emailnos
//    		
//    		for(var i=0 ; i < arr_emails.length; i++) {
//    			msg1		+= arr_emails[i] +"\n\t";
//    		}
//    		if (!ComShowCodeConfirm("DMT01093", msg1))	return;
//		}
//	 	
//	    if(sendType == "fax"){
//	  	    //send Fax 
//	    	doActionIBSheet(sheetObjects[0],document.form, IBSEARCH_ASYNC05);
//	    } else if(sendType == "email"){
//	  	    //send Email
//	  		doActionIBSheet(sheetObjects[0],document.form, IBSEARCH_ASYNC06);
//	    }
 	}	
	//SEND
	function faxEmaiInfo(formObj, opnSheetObj, sheetObj){
		//EMAIL info
        ComSetObjValue(formObj.rd_fxeml_sys_cd         , 	 "DMT");
		ComSetObjValue(formObj.rd_fxeml_bat_flg        , 	 "N");
		//Demand Note  subject
		ComSetObjValue(formObj.rd_fxeml_title		   ,  	 "DemDet Statement(BL#: "+ComGetObjValue(formObj.bl_no)+")");               
		ComSetObjValue(formObj.rd_fxeml_doc_tp		   , 	 "D");
		ComSetObjValue(formObj.rd_fxeml_fax_no         , 	 "");
		ComSetObjValue(formObj.rd_fxeml_fax_sndr_id    , 	 "COMPANY");
 		ComSetObjValue(formObj.rd_fxeml_eml_sndr_nm    , 	 "Demurrage / Detention Statement");
		ComSetObjValue(formObj.rd_fxeml_eml_rcvr_add   , 	 ""); //;mjchang@COMPANY.com
		ComSetObjValue(formObj.rd_fxeml_eml_atch_file  , 	 ComGetNowInfo("ymd") + "" + ComGetObjValue(formObj.bl_no)); //YYYY-MM-DD_COM+B/L No. (예시: 2010-02-24_SHAE61559002)
		ComSetObjValue(formObj.rd_fxeml_eml_templt     , 	 "EES_DMT_DEMAND_001.htmlmail"); // 템플릿 위치 C:/sitectx/OPUSCNTR\APP-INF/config/template/mailtemplate/template.htmlmail
		ComSetObjValue(formObj.rd_fxeml_eml_tmplt_param, 	 "bl_no;" + ComGetObjValue(formObj.bl_no) + "|bl_no;" + ComGetObjValue(formObj.bl_no) + "");
 		ComSetObjValue(formObj.invno					, 	 "DemandNot");
 		ComSetObjValue(formObj.payc						, 	 ComGetObjValue(formObj.payer_cd) );
	}
	///////////////////////////////////////////////////////////////////////////////	
    /**
    * Register as an array IBSheet Object
     * The next batch of other items when you need treatment of fiberglass can add to an array that holds the process
     * Array defined at the top of the source
    */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/** 
	 * Register as an array IBCombo Object
  	 * param : combo_obj ==> combo object
  	 * The next batch of other items when you need treatment of fiberglass can add to an array that holds the process
  	 * Array defined at the top of the source
	 */ 
	function setComboObject(combo_obj) {  
		 comboObjects[comboCnt++]=combo_obj;  
	} 
	/**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
//        var spanObj = document.getElementById("title");
//    	spanObj.innerText = "  Demand Note Issue - Booking";
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
	 	// IBMultiCombo initializing 
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],k+1);
	    }
		initAxonControl();
		var formObj=document.form;
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
		//setTaxRto();
		searchAttentionList();
		if (comboObjects[0].GetItemCount() > 0) {
			comboObjects[0].SetSelectIndex(0);
		}
//		var setCode = ComGetObjValue(formObj.cust_cnt_cd)+"^"+ComGetObjValue(formObj.cust_cntc_pnt_seq)+"^"+ComParseInt(ComGetObjValue(formObj.cust_seq));
//		
//		if(ComGetObjValue(formObj.payer_cd) == "") {
//			comboObjects[0].Code = -1;
//			ComSetObjValue(formObj.payr_cntc_pnt_phn_no, "");
//			ComSetObjValue(formObj.payr_cntc_pnt_fax_no, "");
//			ComSetObjValue(formObj.payr_cntc_pnt_eml, "");
//		}else{
//			//Attention Setting
//			comboObjects[0].Code = setCode;
//			if(comboObjects[0].Code == ""){
//				ComSetObjValue(formObj.payr_cntc_pnt_phn_no, "");
//				ComSetObjValue(formObj.payr_cntc_pnt_fax_no, "");
//				ComSetObjValue(formObj.payr_cntc_pnt_eml, "");
//			}
//		}
		searchARCurrencyList();
		formObj.chk_tax.checked=true;
		
		//=========================================
		//2015.10.27 #7995 comment start
        /*if(ComGetObjValue(formObj.usr_cnt_cd) == "IN") {
        	ComEnableObject(formObj.chk_tax, false);
        	ComSetObjValue(formObj.tax_rto_dis, "");
        }else{
		    ComSetObjValue(formObj.tax_rto_dis, ComGetObjValue(formObj.tax_rto));
        }*/
        ComSetObjValue(formObj.tax_rto_dis, ComGetObjValue(formObj.tax_rto));
        //2015.10.27 #7995 comment e n d
        //=========================================	
        
		if(ComGetObjValue(formObj.payer_cd) != "") {
			doActionIBCombo(sheetObjects[1], formObj, IBSEARCH, COMMAND02, "", "");
		}
		doActionIBCombo(sheetObjects[1],document.form,IBSEARCH,COMMAND17,"USR_CNT_CD","");	//2010.04.04.
		
		//=========================================
		//2015.10.27 #7995 comment start
		//if(ComGetObjValue(formObj.invoice_issue) == "1" && ComGetObjValue(formObj.usr_cnt_cd) != "IN"){
		if(ComGetObjValue(formObj.invoice_issue) == "1"){
		//2015.10.27 #7995 comment e n d
		//=========================================		
			ComSetObjValue(formObj.ida_expn_tax_rt, "");
			ComSetObjValue(formObj.ida_expn_tax, "");
			ComSetObjValue(formObj.ida_edu_tax_rt, "");
			ComSetObjValue(formObj.ida_edu_tax, "");
			ComSetObjValue(formObj.ida_high_edu_tax_rt, "");
			ComSetObjValue(formObj.ida_high_edu_tax, "");
		}
     }
	function setPayerCd() {
    	var formObj=document.form;
    	var payer_cd=ComGetObjValue(formObj.payer_cd);
    	var cust_cnt_cd="";
    	var cust_seq="";
    	//Service Provider
    	if(payer_cd.length == 6) {
    		cust_cnt_cd="00";
    		cust_seq=payer_cd;
    	}else if(payer_cd.length == 8){
    		cust_cnt_cd=payer_cd.substring(0,2);
    		cust_seq=payer_cd.substring(2);
    	}else{
    		ComSetObjValue(formObj.payer_cd, "");
    		ComSetObjValue(formObj.cust_cnt_cd, "");
    		ComSetObjValue(formObj.cust_seq, "");
    		return;
    	}
    	ComSetObjValue(formObj.cust_cnt_cd, cust_cnt_cd);
    	ComSetObjValue(formObj.cust_seq, cust_seq);
	}
     /**
  	 * attention list reset
      */	
	function attentionReset(){
		var formObj=document.form;
     	comboObjects[0].RemoveAll();
     	ComSetObjValue(formObj.dmdt_payr_cntc_pnt_nm, "");
     	ComSetObjValue(formObj.payr_cntc_pnt_phn_no	, "");
     	ComSetObjValue(formObj.payr_cntc_pnt_fax_no , "");
     	ComSetObjValue(formObj.payr_cntc_pnt_eml	, "");
	}
	function initControl() {
  		axon_event.addListenerForm  ('blur',	'obj_blur',		document.form, 'cond_type'); 
  		axon_event.addListenerFormat('focus',	'obj_focus',	document.form); 
  		axon_event.addListenerFormat('keypress','obj_keypress', document.form);	
	} 
	/**
     * Sheet the initial setting, the header definition
     * param : sheetObj ==> sheet object, sheetNo ==> Sheet object ID of the tag attached to the serial number
     * Many case as the number of sheets to add the sheet, a sheet should initialize the module configuration
     */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetNo) {
            case 1:      // sheet1 init
                with(sheetObj){
                
	              var HeadTitle="||Seq.|STS|CNTR No.|T/S|Staying Period|Staying Period|Free Time|Free Time|F/T|Over|Cur.|Incurred AMT|Exception AMT|Discount AMT|Billable AMT|G/B|svr_id|cntr_cyc_no|dmdt_trf_cd|dmdt_chg_loc_div_cd|chg_seq|bzc_trf_seq|bzc_trf_grp_seq|cmdt_expt_amt|inv_bill_amt|inv_chg_tot";
	              var HeadTitle1="||Seq.|STS|CNTR No.|T/S|From Date|To Date|F/T CMNC|F/T End|F/T|Over|Cur.|Incurred AMT|Exception AMT|Discount AMT|Billable AMT|G/B|svr_id|cntr_cyc_no|dmdt_trf_cd|dmdt_chg_loc_div_cd|chg_seq|bzc_trf_seq|bzc_trf_grp_seq|cmdt_expt_amt|inv_bill_amt|inv_chg_tot";
	              var headCount=ComCountHeadTitle(HeadTitle);
	              var headCount1=ComCountHeadTitle(HeadTitle1);
	              (headCount, 0, 0, true);
	
	              SetConfig( { SearchMode:2, FrozenCol:5, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	              var headers = [ { Text:HeadTitle, Align:"Center"},
	                          { Text:HeadTitle1, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	                     {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"checkBox" },
	                     {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
	                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_chg_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"fm_mvmt_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"to_mvmt_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ft_cmnc_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ft_end_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ft_dys",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"fx_ft_ovr_dys",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bzc_trf_curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"org_chg_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"expt_amt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"aft_expt_dc_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"bil_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"gb",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"svr_id" },
	                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_cyc_no" },
	                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dmdt_trf_cd" },
	                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dmdt_chg_loc_div_cd" },
	                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"chg_seq" },
	                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bzc_trf_seq" },
	                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bzc_trf_grp_seq" },
	                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cmdt_expt_amt" },
	                     {Type:"Text",      Hidden:1, Width:85,   Align:"Right",   ColMerge:1,   SaveName:"inv_bill_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:85,   Align:"Right",   ColMerge:1,   SaveName:"inv_chg_tot",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 } ];
	               
	              InitColumns(cols);
	              SetEditable(1);
	              FrozenCols=SaveNameCol("cntr_tpsz_cd");
	              SetToolTipText(0,"gb","General/Balance Charge Type");
	              SetToolTipText(1,"gb","General/Balance Charge Type");
	              SetSheetHeight(DEF_SHEET_HEIGHT);
              }
           	break;
           	
            case 2:
                with(sheetObj){
              
              var HeadTitle="||Seq.|STS|CNTR No.|T/S|Staying Period|Staying Period|Free Time|Free Time|F/T|Over|Cur.|Incurred AMT|Exception AMT|Discount AMT|Billable AMT|G/B|svr_id|cntr_cyc_no|dmdt_trf_cd|dmdt_chg_loc_div_cd|chg_seq|bzc_trf_seq|bzc_trf_grp_seq|cmdt_expt_amt";
              var HeadTitle1="||Seq.|STS|CNTR No.|T/S|From Date|To Date|F/T CMNC|F/T End|F/T|Over|Cur.|Incurred AMT|Exception AMT|Discount AMT|Billable AMT|G/B|svr_id|cntr_cyc_no|dmdt_trf_cd|dmdt_chg_loc_div_cd|chg_seq|bzc_trf_seq|bzc_trf_grp_seq|cmdt_expt_amt";
              var headCount=ComCountHeadTitle(HeadTitle);
              var headCount1=ComCountHeadTitle(HeadTitle1);
              (headCount, 0, 0, true);

              SetConfig( { SearchMode:2, FrozenCol:5, MergeSheet:5, Page:20, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"},
                          { Text:HeadTitle1, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                     {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"checkBox" },
                     {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_chg_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"fm_mvmt_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"to_mvmt_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ft_cmnc_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ft_end_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ft_dys",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"fx_ft_ovr_dys",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bzc_trf_curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"org_chg_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"expt_amt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"aft_expt_dc_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"bil_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"gb",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"svr_id" },
                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_cyc_no" },
                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dmdt_trf_cd" },
                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dmdt_chg_loc_div_cd" },
                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"chg_seq" },
                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bzc_trf_seq" },
                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bzc_trf_grp_seq" },
                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cmdt_expt_amt" } ];
               
              InitColumns(cols);
              SetEditable(1);
              FrozenCols=SaveNameCol("cntr_tpsz_cd");
              SetToolTipText(0,"gb","General/Balance Charge Type");
              SetToolTipText(1,"gb","General/Balance Charge Type");
              SetSheetHeight(220);
              }
            break;            	
        }
    }
     // Sheet processing-related processes
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
         	case IBSEARCH:      
 				if (sheetObj.id == "sheet1") {
 					//ComOpenWait Start
 					sheetObj.SetWaitImageVisible(0);
 		        	ComOpenWait(true);
 					if(ComGetObjValue(formObj.invoice_issue) == "1") {
 						setParameters(SEARCH);
 					}
 					
 					//조회를 동기방식으로 전환함. 2014.08.25
 					//sheetObj.DoSearch("EES_DMT_3109GS.do", FormQueryString(formObj));
 					var sXml = sheetObj.GetSearchData("EES_DMT_3109GS.do ", FormQueryString(formObj));
 					if (sXml != "") sheetObj.LoadSearchData(sXml,{Sync:1});
 					
					ComEtcDataToForm(formObj, sheetObj);
					setComma();
					if(ComGetObjValue(formObj.invoice_issue) == "2") {
						sheetObj.CheckAll(1,1,1);
						sheetObj.SetEditable(0);
					}else{
						sheetObj.CheckAll(1,1,1);
					}
					//ComOpenWait End
					ComOpenWait(false);
 				}else if (sheetObj.id == "sheet2") {
 					//ComOpenWait Start
 					sheetObj.SetWaitImageVisible(0);
 		        	ComOpenWait(true);
 					setParameters(SEARCH02);
//  					sheetObj.DoSearch("EES_DMT_4002GS.do", FormQueryString(formObj) );
  					var sXml = sheetObj.GetSearchData("EES_DMT_4002GS.do ", FormQueryString(formObj));
 					if (sXml != "") sheetObj.LoadSearchData(sXml,{Sync:1});
					ComSetObjValue(formObj.inv_xch_rt, sheetObj.GetEtcData("EX_RATE"));
					//ComOpenWait End
					ComOpenWait(false);
 				}
 				break;
         	case IBSEARCH_ASYNC05:      
         		//ComOpenWait Start
				sheetObj.SetWaitImageVisible(0);
	        	ComOpenWait(true);
         		formObj.f_cmd.value=SEARCH05;
         		sheetObjects[1].DoSearch("DMTCommonFaxEmailGS.do", FormQueryString(formObj)  );
         		//ComOpenWait End
				ComOpenWait(false);
         		break;
         	case IBSEARCH_ASYNC06:      
	         	//ComOpenWait Start
				sheetObj.SetWaitImageVisible(0);
	        	ComOpenWait(true);
         		formObj.f_cmd.value=SEARCH06;
         		sheetObjects[1].DoSearch("DMTCommonFaxEmailGS.do", FormQueryString(formObj)  );
         		//ComOpenWait End
				ComOpenWait(false);
         		break;	 				
         }
     }
     //ComAddComma2(ComRound(ComGetObjValue(formObj.inv_chg_amt), 2)+'' ,"#,###.00");
     function setComma(){
     	var formObj=document.form;
     	//Charge 3-digit comma
		var org_chg_amt=ComAddComma2(ComGetObjValue(formObj.mn_org_chg_amt),"#,###.00");
		var dmdt_expt_amt=ComAddComma2(ComGetObjValue(formObj.dmdt_expt_amt),"#,###.00");
		var chg_dc_amt=ComAddComma2(ComGetObjValue(formObj.chg_dc_amt),"#,###.00");
		var bil_amt=ComAddComma2(ComGetObjValue(formObj.mn_bil_amt),"#,###.00");
		var aft_inv_adj_amt=ComAddComma2(ComGetObjValue(formObj.aft_inv_adj_amt),"#,###.00");
		//Invoice
		var tot_amt=ComAddComma2(ComGetObjValue(formObj.tot_amt),"#,###.00");
		var dc_amt=ComAddComma2(ComGetObjValue(formObj.dc_amt),"#,###.00");
		var inv_chg_amt=ComAddComma2(ComGetObjValue(formObj.inv_chg_amt),"#,###.00");
		var tax_amt=ComAddComma2(ComGetObjValue(formObj.tax_amt),"#,###.00");
		var inv_amt=ComAddComma2(ComGetObjValue(formObj.inv_amt),"#,###.00");
		var inv_xch_rt=parseFloat(ComGetObjValue(formObj.inv_xch_rt)).toFixed(6);
		ComSetObjValue(formObj.mn_org_chg_amt, org_chg_amt);
		ComSetObjValue(formObj.dmdt_expt_amt, dmdt_expt_amt);
		ComSetObjValue(formObj.chg_dc_amt, chg_dc_amt);
		ComSetObjValue(formObj.mn_bil_amt, bil_amt);
		ComSetObjValue(formObj.aft_inv_adj_amt, aft_inv_adj_amt);
		ComSetObjValue(formObj.tot_amt, tot_amt);
		ComSetObjValue(formObj.dc_amt, dc_amt);
		ComSetObjValue(formObj.inv_chg_amt, inv_chg_amt);
		ComSetObjValue(formObj.tax_amt, tax_amt);
		ComSetObjValue(formObj.inv_amt, inv_amt);
		ComSetObjValue(formObj.inv_xch_rt, inv_xch_rt);
     }
     function unSetComma(){
        	var formObj=document.form;
 		//Charge 3-digit comma delete
 		var org_chg_amt=ComGetUnMaskedValue(ComGetObjValue(formObj.mn_org_chg_amt),"float");
 		var dmdt_expt_amt=ComGetUnMaskedValue(ComGetObjValue(formObj.dmdt_expt_amt),"float");
 		var chg_dc_amt=ComGetUnMaskedValue(ComGetObjValue(formObj.chg_dc_amt),"float");
 		var bil_amt=ComGetUnMaskedValue(ComGetObjValue(formObj.mn_bil_amt),"float");
 		var aft_inv_adj_amt=ComGetUnMaskedValue(ComGetObjValue(formObj.aft_inv_adj_amt),"float");
 		//Invoice
 		var tot_amt=ComGetUnMaskedValue(ComGetObjValue(formObj.tot_amt),"float");
 		var dc_amt=ComGetUnMaskedValue(ComGetObjValue(formObj.dc_amt),"float");
 		var inv_chg_amt=ComGetUnMaskedValue(ComGetObjValue(formObj.inv_chg_amt),"float");
 		var tax_amt=ComGetUnMaskedValue(ComGetObjValue(formObj.tax_amt),"float");
 		var inv_amt=ComGetUnMaskedValue(ComGetObjValue(formObj.inv_amt),"float");
 		ComSetObjValue(formObj.mn_org_chg_amt, org_chg_amt);
 		ComSetObjValue(formObj.dmdt_expt_amt, dmdt_expt_amt);
 		ComSetObjValue(formObj.chg_dc_amt, chg_dc_amt);
 		ComSetObjValue(formObj.mn_bil_amt, bil_amt);
 		ComSetObjValue(formObj.aft_inv_adj_amt, aft_inv_adj_amt);
 		ComSetObjValue(formObj.tot_amt, tot_amt);
 		ComSetObjValue(formObj.dc_amt, dc_amt);
 		ComSetObjValue(formObj.inv_chg_amt, inv_chg_amt);
 		ComSetObjValue(formObj.tax_amt, tax_amt);
 		ComSetObjValue(formObj.inv_amt, inv_amt);    	
     }
     /**
 	 * Combo basic setting 
 	 * param : comboObj ==> combo object, comboNo ==> Combo object ID of the tag attached to the serial number
 	 * If the number of combo a combo by adding the number of case sheets to initialize the module configuration
 	 */ 
 	function initCombo(comboObj, comboNo) {
 	    var formObj=document.form
 	    switch(comboNo) { 
 	    	//Attention
 	    	case 1:
 	    		with (comboObj) {
// 					MultiSelect = false; 
// 					UseAutoComplete = false;	
// 					SetColAlign("left");        
// 					SetColWidth("150");
// 					DropHeight = 250;
// 					ValidChar(2,2);		
 					SetMultiSelect(0);
SetColAlign(0, "left");
SetColAlign(1, "left");
SetColAlign(2, "left");
SetColAlign(3, "left");
					//SetColWidth("|1|1|1|");
					SetDropHeight(160);
 	    		}
 	    		break;
 	     } 		
 	} 	
	function setParameters(sAction) {
		var formObj=document.form;
		//Retrieve Setting
		ComSetObjValue(formObj.f_cmd, sAction);							//Command
	}
	function initAxonControl() {
		axon_event.addListener('mouseover', 'obj_mouseover', 'txt_aft_inv_adj_amt');	
		axon_event.addListener('mouseout', 'obj_mouseout', 'txt_aft_inv_adj_amt');	
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		axon_event.addListenerFormat('focus',	'obj_focus',	form); 
		axon_event.addListenerFormat('blur',	'obj_blur',		form);
	}
	/**
     * HTML Control Foucs in
     */
    function obj_focus(){
        ComClearSeparator(event.srcElement);
        ComSetFocus(event.srcElement);
    }	
    function obj_blur(){
		var obj=event.srcElement;
		if(obj.name == 'payer_cd') {
			doActionText(sheetObjects[0], document.form, obj, SEARCH20);
		}else if(obj.name == 'trucker_cd') {
			doActionText(sheetObjects[0], document.form, obj, SEARCHLIST04);
		}else{
			ComChkObjValid(obj);
		}
    }   
	function obj_mouseover() {
 		var msg='';
		var x=event.x+document.body.scrollLeft;
		var y=event.y+document.body.scrollTop;
		var skn=document.all("topdeck").style;
     	switch(event.srcElement.id){
	  		case 'txt_aft_inv_adj_amt':
	  			msg='Adjusted Billable AMT after the Invoice was issued';
	  			x=x;
	  			y=y-20;
	  			skn.left=x;
	  			skn.top=y-20;
	  			break;
     	}
		var bak='lightyellow';
		var content="<TABLE BORDER=0 CELLPADDING=1 CELLSPACING=0 BGCOLOR=#000000><TR><TD><TABLE WIDTH=100% BORDER=0 CELLPADDING=2 CELLSPACING=0 BGCOLOR="+bak
   	 				+"><TR><TD style=font-family:tahoma;font-size:9pt;>"+msg+"</TD></TR></TABLE></TD></TR></TABLE>"; 
		document.all("topdeck").innerHTML=content;
		skn.visibility='visible';
    }
	function obj_mouseout() {
		var skn=document.all("topdeck").style;
		skn.visibility='hidden';
	}
	function searchARCurrencyList() {
		var sheetObj=sheetObjects[1];
		var formObj=document.form;
		doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCHLIST05,"AR_CURRENCY");
	}
	function searchAttentionList() {
		//Attention Combo
		setPayerCd();
		var sheetObj=sheetObjects[0];
		var comboObj=comboObjects[0];
		var formObj=document.form;
		if(ComGetObjValue(formObj.payer_cd) == null || ComGetObjValue(formObj.payer_cd) == "") {
			comboObj.RemoveAll();
			return;
		}
		doActionIBCombo(sheetObjects[1],formObj,IBSEARCH,SEARCHLIST03,"ATTENTION",comboObj);
		// Attention Combo Setting
		//comboObj.Text = ComGetObjValue(formObj.dmdt_payr_cntc_pnt_nm);
	}
    function doActionIBCombo(sheetObj,formObj,sAction,sComboAction,sComboKey,sObj) {
        sheetObj.ShowDebugMsg(false);
		sheetObj.SetWaitImageVisible(0);
		switch(sAction) {
        	case IBSEARCH:      
				if (sheetObj.id == "sheet2") {
					var comboDatas;
					var comboItems;
					switch(sComboAction) {
						//1. ATTENTION LIST
						case SEARCHLIST03:
							var preOfcCd=ComGetObjValue(formObj.ofc_cd);
							ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.session_ofc_cd));
							setComboParameters(sComboAction, sObj);
 							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							comboItems=ComGetEtcData(sXml, sComboKey).split(ROWMARK);
							//comboObjects[0].Code = "-1";
							comboObjects[0].RemoveAll();
							addComboItem1(sObj,comboItems);			
							ComSetObjValue(formObj.ofc_cd, preOfcCd);
							break;							
						case SEARCHLIST05:
//							setComboParameters(sComboAction, sObj);
							var param="f_cmd=" + SEARCHLIST05
							  + "&jspno=3109" 
							  + "&ofc_cd=" + formObj.session_ofc_cd.value
							  ; 
//							var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
 							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", param);
							ComClearCombo(formObj.inv_curr_cd);
							comboDatas=ComGetEtcData(sXml, sComboKey);
							if (comboDatas != undefined) {
								addComboItem(formObj.inv_curr_cd,comboDatas,true);
							}
							break;	
						case COMMAND02:
							setComboParameters(sComboAction, sObj);
							var preOfcCd=ComGetObjValue(formObj.ofc_cd);
							ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.session_ofc_cd));
 							var sXml=sheetObj.GetSearchData("EES_DMT_4002GS.do", FormQueryString(formObj));
							ComSetObjValue(formObj.payr_faxnos, 	ComGetEtcData(sXml, "FAX_NO"));
							ComSetObjValue(formObj.payr_emailnos, 	ComGetEtcData(sXml, "EMAIL_NO"));
							ComSetObjValue(formObj.ofc_cd, preOfcCd);
							break;		
						case COMMAND17:
							ComSetObjValue(formObj.f_cmd, COMMAND17);
 							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							ComSetObjValue(formObj.usr_cnt_cd, 	ComGetEtcData(sXml, "USR_CNT_CD"));
							break;							
					}
				};
                break;
        }
		sheetObj.SetWaitImageVisible(1);
    }
    /**
     * Data in the field adds a combo
     */	
	function addComboItem(comboObj,comboDatas,isOnlyCode) {
		var comboItem;
		var comboItems;
		var val;
		var txt;
		if (comboDatas != undefined) {
			comboItems=comboDatas.split(ROWMARK);	
	    	for (var i=0 ; i < comboItems.length ; i++) {
    			comboItem=comboItems[i].split(FIELDMARK);
				val=comboItem[0];
				txt=isOnlyCode ? comboItem[0] : comboItem[1];
				ComAddComboItem(comboObj,val,txt);
    		}
		}   		
	}
	/**
     * Data in the field adds a combo
     */	
	function addComboItem1(comboObj, comboItems) {
    	for (var i=0 ; i < comboItems.length ; i++) {
    		var comboItem=comboItems[i].split(FIELDMARK);
			comboObj.InsertItem(i, comboItem[0]+"|"+comboItem[1]+"|"+comboItem[2]+"|"+comboItem[3], comboItem[4]);		
//			comboObj.SetColWidth("150|1|1|1");
    	}   		
	}
	
	function combo1_OnSelect(comboObj, Index, Text, Code) {

		search_combo1(comboObj, Code)
	}
	
    //Attention selection event
  	function combo1_OnSelect(comboObj, Index, Text, Code) {
  		search_combo1(comboObj, Index, Code);
  	}
  	
  	function search_combo1(comboObj, Index, Code) {
		var formObj      = document.form;
		var cboAttention = comboObjects[0];
		
		var pntNm = "";
		var phnNo = "";
		var faxNo = "";
		var eml   = "";
		
		if (Index != -1) {
			var pntNm = comboObj.GetText(Index, 0);
			var phnNo = comboObj.GetText(Index, 1);
			var faxNo = comboObj.GetText(Index, 2);
			var eml   = comboObj.GetText(Index, 3);
			
			ComSetObjValue(formObj.dmdt_payr_cntc_pnt_nm, pntNm);
			ComSetObjValue(formObj.payr_cntc_pnt_phn_no,  phnNo);	//To show the text column
			ComSetObjValue(formObj.payr_cntc_pnt_fax_no,  faxNo);	//To show the text column
			ComSetObjValue(formObj.payr_cntc_pnt_eml,     eml);		//To show the text column
		
			var arrCode = Code.split("^");		//code
			if (arrCode != undefined || arrCode != "") {
				ComSetObjValue(formObj.cust_cntc_pnt_seq, arrCode[1]);
			}
		}
  	} 
  	
 	function openPopup(flag, arg) {
 		var sheetObj=sheetObjects[0];
 		var formObj=document.form;
 		var sUrl='';
 		var sWidth='';
 		var sHeight='';
 		with(sheetObj) {
	  		switch(flag) {
	  			case 'payer_cd':		// Customer Inquiry Popup
					ComOpenPopup('COM_ENS_041.do', 770, 445, "getCustCd", "1,0,1,1,1,1,1", true);
					break;
	  			case 'trucker_cd':
					ComOpenPopup('COM_ENS_0C1.do', 700, 488, "getSvcProvdr", "1,0,1,1,1,1,0", true);
	  				break;
	  		} // switch-end
 		} // with-end
 	}
	function getCustCd(aryPopupData) {
		document.form.payer_cd.value=aryPopupData[0][3];
		document.form.payer_nm.value=aryPopupData[0][4];
   		//Attention 
    	searchAttentionList();
		if (comboObjects[0].GetItemCount() > 0) {
			comboObjects[0].SetSelectIndex(0);
		}
		//parameter : payer_cd, ofc_cd  -- 세션 ofc_cd , dmdt_trf_cd 
		var formObj=document.form;
		doActionIBCombo(sheetObjects[1], formObj, IBSEARCH, COMMAND02, "", "");
	}    
	function getSvcProvdr(aryPopupData) {
		document.form.trucker_cd.value=aryPopupData[0][2];
		document.form.trucker_nm.value=aryPopupData[0][4]; //name값으로 수정
	}
	// Payer, Trucker
    function doActionText(sheetObj, formObj, object, formCmd) {
		sheetObj.ShowDebugMsg(false);
		sheetObj.SetWaitImageVisible(0);
	    //Payer check
		if(object.name == "payer_cd"){
			//cust_cd
			ComSetObjValue(formObj.s_cust_cd, ComGetObjValue(formObj.payer_cd));
			var cust_len=parseInt(ComGetLenByByte(ComGetObjValue(formObj.s_cust_cd)));
			if(cust_len == 0){
				ComSetObjValue(formObj.s_cust_gubun, "");
				ComSetObjValue(formObj.s_cust_cd, "");
				ComSetObjValue(formObj.payer_cd, "");
				ComSetObjValue(formObj.payer_nm, "");
				attentionReset();
				return;
			}
			//var spType = ComGetObjValue(formObj.dmdt_trf_cd);
			//var cre_cnt_cd = ComGetObjValue(formObj.session_cnt_cd);
			var cre_cnt_cd=ComGetObjValue(formObj.usr_cnt_cd);	//2010.04.04.
			if(cre_cnt_cd == "CA" || cre_cnt_cd == "US"){
				if(cust_len > 2) {
					var char_chk=ComGetObjValue(formObj.s_cust_cd).substring(0,2);
					if(ComIsAlphabet(char_chk)) {
						ComSetObjValue(formObj.s_cust_gubun, "2");
					}else{
						if(ComGetObjValue(formObj.dmdt_trf_cd).substring(1,2) == 'T'){
							ComSetObjValue(formObj.s_cust_gubun, "1");
						} else {
							ComShowCodeMessage("DMT00165", "Payer");
							ComSetObjValue(formObj.s_cust_gubun, "");
							ComSetObjValue(formObj.s_cust_cd, "");
							ComSetObjValue(formObj.payer_cd, "");
							ComSetObjValue(formObj.payer_nm, "");
							attentionReset();
							return;
						}
					}
				} else {
					if(ComGetObjValue(formObj.dmdt_trf_cd).substring(1,2) == 'T'){
						ComSetObjValue(formObj.s_cust_gubun, "1");
					} else {
						ComShowCodeMessage("DMT00165", "Payer");
						ComSetObjValue(formObj.s_cust_gubun, "");
						ComSetObjValue(formObj.s_cust_cd, "");
						ComSetObjValue(formObj.payer_cd, "");
						ComSetObjValue(formObj.payer_nm, "");
						attentionReset();
						return;
					}
				}
			} else {
				if(cust_len > 2) {
					var char_chk=ComGetObjValue(formObj.s_cust_cd).substring(0,2);
					if(ComIsAlphabet(char_chk)) {
						ComSetObjValue(formObj.s_cust_gubun, "2");
					}else{
						ComShowCodeMessage("DMT00165", "Payer");
						ComSetObjValue(formObj.s_cust_gubun, "");
						ComSetObjValue(formObj.s_cust_cd, "");
						ComSetObjValue(formObj.payer_cd, "");
						ComSetObjValue(formObj.payer_nm, "");
						attentionReset();
						return;
					}
				} else {
					ComShowCodeMessage("DMT00165", "Payer");
					ComSetObjValue(formObj.s_cust_gubun, "");
					ComSetObjValue(formObj.s_cust_cd, "");
					ComSetObjValue(formObj.payer_cd, "");
					ComSetObjValue(formObj.payer_nm, "");
					attentionReset();
					return;
				}
			}
			ComSetObjValue(formObj.f_cmd, formCmd);
 			var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
			var cust_cd=ComGetEtcData(sXml, "PAYER_CODE");
			var cust_nm=ComGetEtcData(sXml, "PAYER_NM");
			var delt_flg=ComGetEtcData(sXml, "DELT_FLG");
			if(cust_nm == null || cust_nm == "") {
				ComSetObjValue(formObj.s_cust_gubun, "");
				ComSetObjValue(formObj.s_cust_cd, "");
				ComSetObjValue(formObj.payer_cd, "");
				ComSetObjValue(formObj.payer_nm, "");
				attentionReset();
				ComShowCodeMessage("DMT00165", "Payer");
				ComSetFocus(formObj.payer_cd);
			}else{
				ComSetObjValue(formObj.payer_cd, cust_cd);
				ComSetObjValue(formObj.payer_nm, cust_nm);
	 			searchAttentionList();
	 			if (comboObjects[0].GetItemCount() > 0) {
	 				comboObjects[0].SetSelectIndex(0);
	 			}
				//parameter : payer_cd, ofc_cd  -- 세션 ofc_cd , dmdt_trf_cd 
				doActionIBCombo(sheetObjects[1], formObj, IBSEARCH, COMMAND02, "", "");
			}
		}else if(object.name == "trucker_cd"){
			//vndr_cd
			ComSetObjValue(formObj.vndr_cd, ComGetObjValue(formObj.trucker_cd));
			var vndr_len=parseInt(ComGetLenByByte(ComGetObjValue(formObj.vndr_cd)));
			if(vndr_len == 0) {
				ComSetObjValue(formObj.vndr_cd, "");
				ComSetObjValue(formObj.trucker_cd, "");
				ComSetObjValue(formObj.trucker_nm, "");
				return;
			}
			ComSetObjValue(formObj.f_cmd, formCmd);
 			var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
			var vndr_cd=ComGetEtcData(sXml, "VNDR_CD");	
			var vndr_nm=ComGetEtcData(sXml, "VNDR_NM");
			if(vndr_nm == null || vndr_nm == "") {
				ComSetObjValue(formObj.vndr_cd, "");
				ComSetObjValue(formObj.trucker_cd, "");
				ComSetObjValue(formObj.trucker_nm, "");
				ComSetFocus(formObj.trucker_cd);
			}else{
				ComSetObjValue(formObj.trucker_cd, vndr_cd);	
				ComSetObjValue(formObj.trucker_nm, vndr_nm);
			}			
		}
        sheetObj.SetWaitImageVisible(1);
    }
    function setComboParameters(sComboAction, sObj) {
    	var formObj=document.form;
    	ComSetObjValue(formObj.curr_cd, ComGetObjValue(formObj.inv_curr_cd));
    	ComSetObjValue(formObj.f_cmd, sComboAction);
    }
	function sheet1_OnSearchEnd(sheetObj, code, ErrMsg) {
		if(ErrMsg == '') {
			var formObj=document.form;
			var fCmd=formObj.f_cmd.value;
			if(fCmd == SEARCH) {
//				//check box All
//				sheetObj.CheckAll(1) = 1;
				sheetObj.CheckAll("checkBox",1);
				//btn
				DmtComEnableManyBtns(true,  "btn_set", "btn_option", "btn_close");
				DmtComEnableManyBtns(true, "btn_preview", "btn_print", "btn_fax", "btn_email", "btn_payerfaxemail");
			}
			
			ComEtcDataToForm(formObj, sheetObj);
			setComma();
			if(ComGetObjValue(formObj.invoice_issue) == "2") {
				sheetObj.CheckAll(1,1,1);
				sheetObj.SetEditable(0);
			}else{
				sheetObj.CheckAll(1,1,1);
			}
			//ComOpenWait End
			ComOpenWait(false);
		}
	}
	function sheet1_OnChange (sheetObj, Row, Col, Value) {
 		var formObj=document.form;
 		var sName=sheetObj.ColSaveName(Col);
 		var inv_curr_cd=ComGetObjValue(formObj.inv_curr_cd);
 		if(sName == "checkBox") {	//checkbox
 			if(Value == 1) {
				//Incurrend AMT
 				var c_org_chg_amt=parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.mn_org_chg_amt),"float")) + parseFloat(sheetObj.GetCellValue(Row, "org_chg_amt"));
				c_org_chg_amt=DMTtrimCurrencyAmount(inv_curr_cd, c_org_chg_amt);
				ComSetObjValue(formObj.mn_org_chg_amt, c_org_chg_amt);
				//Exception AMT
				var c_expt_amt=parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.dmdt_expt_amt),"float")) + parseFloat(sheetObj.GetCellValue(Row, "expt_amt"));
				c_expt_amt=DMTtrimCurrencyAmount(inv_curr_cd, c_expt_amt);
				ComSetObjValue(formObj.dmdt_expt_amt, c_expt_amt);
				//Discount AMT
				var c_chg_dc_amt=parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.chg_dc_amt),"float")) + parseFloat(sheetObj.GetCellValue(Row, "aft_expt_dc_amt"));
				c_chg_dc_amt=DMTtrimCurrencyAmount(inv_curr_cd, c_chg_dc_amt);
				ComSetObjValue(formObj.chg_dc_amt, c_chg_dc_amt);
				//Billable AMT
				var c_bil_amt=parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.mn_bil_amt),"float")) + parseFloat(sheetObj.GetCellValue(Row, "bil_amt"));
				c_bil_amt=DMTtrimCurrencyAmount(inv_curr_cd, c_bil_amt);
				ComSetObjValue(formObj.mn_bil_amt, c_bil_amt);
			}else if(Value == 0) {
				//Incurrend AMT
				var c_org_chg_amt=parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.mn_org_chg_amt),"float")) - parseFloat(sheetObj.GetCellValue(Row, "org_chg_amt"));
				c_org_chg_amt=DMTtrimCurrencyAmount(inv_curr_cd, c_org_chg_amt);
				ComSetObjValue(formObj.mn_org_chg_amt, c_org_chg_amt);
				//Exception AMT
				var c_expt_amt=parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.dmdt_expt_amt),"float")) - parseFloat(sheetObj.GetCellValue(Row, "expt_amt"));
				c_expt_amt=DMTtrimCurrencyAmount(inv_curr_cd, c_expt_amt);
				ComSetObjValue(formObj.dmdt_expt_amt, c_expt_amt);
				//Discount AMT
				var c_chg_dc_amt=parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.chg_dc_amt),"float")) - parseFloat(sheetObj.GetCellValue(Row, "aft_expt_dc_amt"));
				c_chg_dc_amt=DMTtrimCurrencyAmount(inv_curr_cd, c_chg_dc_amt);
				ComSetObjValue(formObj.chg_dc_amt, c_chg_dc_amt);
				//Billable AMT
				var c_bil_amt=parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.mn_bil_amt),"float")) - parseFloat(sheetObj.GetCellValue(Row, "bil_amt"));
				c_bil_amt=DMTtrimCurrencyAmount(inv_curr_cd, c_bil_amt);
				ComSetObjValue(formObj.mn_bil_amt, c_bil_amt);
			}
 			var iCnt=0;
 			for(var i=2; i < sheetObj.GetTotalRows()+2; i++) {
 				if(sheetObj.GetCellValue(i,"checkBox") == 1) {
 					iCnt++;
 				}
 			}
 			ComSetObjValue(formObj.cntr_cnt, iCnt);
 			getExRate();
 			setComma();
 			if(iCnt == 0){
 				ComShowCodeMessage('DMT00164');
 				DmtComEnableManyBtns(true,  "btn_set", "btn_option", "btn_close");
				DmtComEnableManyBtns(false, "btn_preview", "btn_print", "btn_fax", "btn_email", "btn_payerfaxemail");
 			} else {
 				DmtComEnableManyBtns(true,  "btn_set", "btn_option", "btn_close");
				DmtComEnableManyBtns(true, "btn_preview", "btn_print", "btn_fax", "btn_email", "btn_payerfaxemail");
 			}
 		}
 	}
    function sheet1_OnClick(sheetObj, row, col, Value){
        if(sheetObj.ColSaveName(col) == "checkBox"){
        	ComSyncAllCheck(sheetObj, col, Value);           
        }
    }	
    function changeExRate() {
    	doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
    }
	function getExRate() {
		var formObj=document.form;
		var chg_curr_cd=ComGetObjValue(formObj.chg_curr_cd);
		var inv_curr_cd=ComGetObjValue(formObj.inv_curr_cd);
		if(chg_curr_cd == "" || inv_curr_cd == "")	return;
		var chg_dc_amt;
		var inv_xch_rt;	
		var tot_amt=0;	
		var dc_amt;		
		var bil_amt;
		var inv_chg_amt;
		var tax_rto;
		var tax_amt;
		var inv_amt;
		var tot_bill_amt=0;
		var tot_bill_gst_amt;
		bil_amt=parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.mn_bil_amt),"float"));		//Billable AMT
		tax_rto=parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.tax_rto_dis),"float")); //Tax Rate
		chg_dc_amt=parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.chg_dc_amt),"float"));	//Discount AMT
		
		var ida_expn_tax_rt     = parseFloat(ComGetObjValue(formObj.ida_expn_tax_rt));
		var ida_edu_tax_rt      = parseFloat(ComGetObjValue(formObj.ida_edu_tax_rt));
		var ida_high_edu_tax_rt = parseFloat(ComGetObjValue(formObj.ida_high_edu_tax_rt));
		var sts_cd;
		
		if(chg_curr_cd == inv_curr_cd){
			ComSetObjValue(formObj.inv_xch_rt, 1);	//inv_xch_rt=1 setting
		}else{
			doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
		}
		inv_xch_rt=ComGetObjValue(formObj.inv_xch_rt);
		inv_xch_rt=ComRound(inv_xch_rt, 6);	
		for(var i=2 ; i < sheetObjects[0].GetTotalRows()+2 ; i++) {
			if(sheetObjects[0].GetCellValue(i, "checkBox") == 1) {
				tot_amt += parseFloat(sheetObjects[0].GetCellValue(i, "inv_chg_tot"));
				tot_bill_amt += parseFloat(sheetObjects[0].GetCellValue(i, "inv_bill_amt"));
				
				//=========================================
				//2015.10.27 #7995 comment start
				//if(ComGetObjValue(formObj.usr_cnt_cd) == "IN" && sts_cd != "I" ){
				if(sts_cd != "I" ){
				//2015.10.27 #7995 comment e n d
				//=========================================
					tot_bill_gst_amt += parseFloat(sheetObjects[0].GetCellValue(i, "inv_bill_amt"));
				}
			}
		}
		tot_amt=DMTtrimCurrencyAmount(inv_curr_cd, tot_amt);
		//billing amt 
		inv_chg_amt=DMTtrimCurrencyAmount(inv_curr_cd, tot_bill_amt);
		//dc_amt
		dc_amt=tot_amt - tot_bill_amt;
		dc_amt=DMTtrimCurrencyAmount(inv_curr_cd, dc_amt);
		//2010.04.04.
//		if(ComGetObjValue(formObj.usr_cnt_cd) == "VN") {	
//			tax_amt=(inv_chg_amt / (1 - tax_rto * 0.01)) * (tax_rto * 0.01);
//		}
		//=========================================
		//2015.10.27 #7995 comment start
		/*else if(ComGetObjValue(formObj.usr_cnt_cd) == "IN"){
			var ida_expn_tax = 0;
		    var ida_edu_tax = 0;
		    var ida_high_edu_tax = 0;

			// Service Tax
			 ida_expn_tax = ComRound( (tot_bill_gst_amt * ida_expn_tax_rt * 0.01), 2 );
			 ComSetObjValue(formObj.ida_expn_tax, ida_expn_tax);
			
			// Education Cess
			 ida_edu_tax = ComRound( (ida_expn_tax * ida_edu_tax_rt * 0.01), 2 );
			 ComSetObjValue(formObj.ida_edu_tax, ida_edu_tax);
			
			// Higher Edu Cess
			 ida_high_edu_tax = ComRound( (ida_expn_tax * ida_high_edu_tax_rt * 0.01), 2 );
			 ComSetObjValue(formObj.ida_high_edu_tax, ida_high_edu_tax);
			
			// Total Service Tax
			tax_amt = parseFloat(ida_expn_tax) + parseFloat(ida_edu_tax) + parseFloat(ida_high_edu_tax) ;
			
		}*/
		//2015.10.27 #7995 comment e n d
		//=========================================
//		else{
			tax_amt=(tax_rto * 0.01) * inv_chg_amt;
//		}
		tax_amt=DMTtrimCurrencyAmount(inv_curr_cd, tax_amt);
		inv_amt=inv_chg_amt + tax_amt;
		inv_amt=DMTtrimCurrencyAmount(inv_curr_cd, inv_amt);
		ComSetObjValue(formObj.inv_xch_rt, inv_xch_rt);
		ComSetObjValue(formObj.tot_amt, tot_amt);
		ComSetObjValue(formObj.dc_amt, dc_amt);
		ComSetObjValue(formObj.inv_chg_amt, inv_chg_amt);
		ComSetObjValue(formObj.tax_amt, tax_amt);
		ComSetObjValue(formObj.inv_amt, inv_amt);
		//SETCOMMA
		setComma();
	}
	/**
	 * Tax Rate check
	 */
	function setTax(){
		var formObj=document.form;
		if(formObj.chk_tax.checked) {
			ComSetObjValue(formObj.tax_rto_dis, ComGetObjValue(formObj.tax_rto));
		}else{
			ComSetObjValue(formObj.tax_rto_dis, "0");
		}
		getExRate();
		setComma();
	}
 	function openPopupWindow(sheetObj, formObj, srcName) {
 		if (srcName == "btn_set") {
 			var url="EES_DMT_4101.do"
 				+"?issoff="+ComGetObjValue(formObj.ofc_cd)
 				+"&tftp2="+ComGetObjValue(formObj.s_dmdt_trf_cd)
 				+"&sheetp=D"
 				+"&invoice_issue=1"
 				+"&jspno=EES_DMT_3109";
			var sWidht  = "725";
			var sHeight = "550";
   			ComOpenWindowCenter(url, "EES_DMT_4101", sWidht, sHeight, true, "yes");
 			//ComOpenWindowCenter(url, "EES_DMT_4101", "725","780", true, "yes");
 		} 
 		else if (srcName == "btn_option") {
 			var url="EES_DMT_4103.do"
 				+"?issoff="+ComGetObjValue(formObj.ofc_cd)
 				+"&tftp="+ComGetObjValue(formObj.s_dmdt_trf_cd)
 				+"&invoice_issue=1"
 				+"&jspno=EES_DMT_3109";
			var sWidht  = "625";
			var sHeight = "680";   			
   			ComOpenWindowCenter(url, "EES_DMT_4103", sWidht, sHeight, true); 			
 			//ComOpenWindowCenter(url, "EES_DMT_4103", "625","680", true);
 		} 
 		else if (srcName == "btn_payerfaxemail") {
			var url="EES_DMT_4104.do"
				+"?s_ofc_cd="+ComGetObjValue(formObj.session_ofc_cd) 
				+"&s_cust_cd="+ComGetObjValue(formObj.payer_cd)
				+"&s_bkg_no="+ComGetObjValue(formObj.bkg_no)
				+"&s_pod_cd="+ComGetObjValue(formObj.pod_cd)
				+"&jspno=EES_DMT_3109"
				+"&attn="+ComGetObjValue(formObj.dmdt_payr_cntc_pnt_nm)
				+"&telno="+ComGetObjValue(formObj.payr_cntc_pnt_phn_no)
				+"&faxno="+ComGetObjValue(formObj.payr_cntc_pnt_fax_no)
				+"&email="+ComGetObjValue(formObj.payr_cntc_pnt_eml)
			var sWidht  = "825";
			var sHeight = "580"; 	
			ComOpenWindowCenter(url, "EES_DMT_4104", sWidht, sHeight, true);				
			//var returnValue=ComOpenWindowCenter(url, "EES_DMT_4104", "825","585", true);
		} 
 		else if (srcName == "btn_sendinghistory") {
			var url="EES_DMT_7006_P.do"
				+"?jspno=EES_DMT_3109"
				+"&payerCd="+ComGetObjValue(formObj.payer_cd)
				+"&selectType=D"
				+"&selectOpt=2"
				;
			var sWidht  = "1036";
			var sHeight = "650";
			ComOpenPopup(url, sWidht, sHeight, "callbackProc", "0,1", false);
			//ComOpenPopup(url, "1036", "655", "callbackProc", "0,1", false);
		} 
 		else if(srcName == "btn_fax") {
			if(ComGetObjValue(formObj.payer_cd) == null || ComGetObjValue(formObj.payer_cd) == "") {
				ComShowCodeMessage("DMT00182");
				return;
			}
			var ofc_cd=ComGetObjValue(formObj.session_ofc_cd);
			var url="EES_DMT_4107.do"
				+"?s_ofc_cd="+ofc_cd
				+"&s_cust_cd="+ComGetObjValue(formObj.payer_cd)
				+"&s_bkg_no="+ComGetObjValue(formObj.bkg_no)
				+"&s_pod_cd="+ComGetObjValue(formObj.pod_cd)
				+"&jspno=3109"
				+"&telno="+ComGetObjValue(formObj.payr_cntc_pnt_phn_no)
				+"&faxno="+ComGetObjValue(formObj.payr_cntc_pnt_fax_no)
				+"&email="+ComGetObjValue(formObj.payr_cntc_pnt_eml)
				+"&cntc_seq="//
				;
			var sWidht  = "520";
			var sHeight = "250";
			ComOpenWindowCenter(url, "EES_DMT_4107", sWidht, sHeight, true);			
			//ComOpenWindowCenter(url, "EES_DMT_4107", "500","260", true);
		} 
 		else if (srcName == "btn_email") {
			if(ComGetObjValue(formObj.payer_cd) == null || ComGetObjValue(formObj.payer_cd) == "") {
				ComShowCodeMessage("DMT00182");
				return;
			}
			var ofc_cd=ComGetObjValue(formObj.session_ofc_cd);
			var url="EES_DMT_4108.do"
				+"?s_ofc_cd="+ofc_cd
				+"&s_cust_cd="+ComGetObjValue(formObj.payer_cd)
				+"&s_bkg_no="+ComGetObjValue(formObj.bkg_no)
				+"&s_pod_cd="+ComGetObjValue(formObj.pod_cd)
				+"&jspno=3109"
				+"&telno="+ComGetObjValue(formObj.payr_cntc_pnt_phn_no)
				+"&faxno="+ComGetObjValue(formObj.payr_cntc_pnt_fax_no)
				+"&email="+ComGetObjValue(formObj.payr_cntc_pnt_eml)
				+"&cntc_seq="//
				;
			var sWidht  = "520";
			var sHeight = "250";	
			ComOpenWindowCenter(url, "EES_DMT_4108", sWidht, sHeight, true);			
			//ComOpenWindowCenter(url, "EES_DMT_4108", "520","263", true);
		}
 	} 	
/////////////////////////////////////////////////////////////////////////////////////
 	function getSheetOptionData(cr_term_dys, is_dt_prn_flg, tax_rto) {
 		var formObj=document.form;
 		if(tax_rto == null || tax_rto == "") {
 			tax_rto="0";
 		}
 		//tax_rto
 		ComSetObjValue(formObj.tax_rto, tax_rto);
 		//
 		if(formObj.chk_tax.checked) {
 			ComSetObjValue(formObj.tax_rto_dis, ComGetObjValue(formObj.tax_rto));
 			//tax calculate
 			getExRate();
 			setComma();
 		}
 	} 	 
	function getPayerInfoData(fax_nos, email_nos, cntc_pnt_nm, cntc_pnt_seq){
		var formObj=document.form;
		ComSetObjValue(formObj.payr_faxnos, 			fax_nos);
		ComSetObjValue(formObj.payr_emailnos, 			email_nos);
		ComSetObjValue(formObj.dmdt_payr_cntc_pnt_nm, 	cntc_pnt_nm);
		ComSetObjValue(formObj.cust_cntc_pnt_seq, 		cntc_pnt_seq);
		searchAttentionList();
		var setCode=ComGetObjValue(formObj.cust_cnt_cd)+"^"+ComGetObjValue(formObj.cust_cntc_pnt_seq)+"^"+ComParseInt(ComGetObjValue(formObj.cust_seq));
		//setting
		if(ComGetObjValue(formObj.payer_cd) == "") {
			comboObjects[0].SetSelectCode(-1);
			ComSetObjValue(formObj.payr_cntc_pnt_phn_no, "");
			ComSetObjValue(formObj.payr_cntc_pnt_fax_no, "");
			ComSetObjValue(formObj.payr_cntc_pnt_eml, "");
			ComSetObjValue(formObj.cust_cntc_pnt_seq, "");
		}else{
			//Attention Setting
			comboObjects[0].SetSelectCode(setCode);
			if(comboObjects[0].GetSelectCode()== ""){
				ComSetObjValue(formObj.payr_cntc_pnt_phn_no, "");
				ComSetObjValue(formObj.payr_cntc_pnt_fax_no, "");
				ComSetObjValue(formObj.payr_cntc_pnt_eml, "");
				ComSetObjValue(formObj.cust_cntc_pnt_seq, "");
			}
		}
	} 	
	
	function callbackProc(rtnVal) {
		if (rtnVal == "Y") {
		}
	}
	/* Developer's task end */
