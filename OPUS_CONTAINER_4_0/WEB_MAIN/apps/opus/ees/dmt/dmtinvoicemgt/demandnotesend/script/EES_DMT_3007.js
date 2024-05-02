/*========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_DMT_3007.js
*@FileTitle  : Demand Note Issue Preview
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30
=========================================================*/
	// Common Global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
//    var rdObjects=new Array();
//	rdObjects[0] = document.getElementById("Demand"); 
//    var rdCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
         /***** case in Sheet count are more two by Tab, defining adding sheet *****/
         var sheetObject1=sheetObjects[0];
//         var rdObject=viewer;
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
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
				case "btn_print":
					if(ComIsBtnEnable(srcName)) {
						var payerCd=ComGetObjValue(formObject.payer_cd);
						if(payerCd == ''){
							ComShowCodeMessage('DMT00182');
							ComSetFocus(formObject.payer_cd);
							return;
						} else {
							viewer.print({isServerSide:true});
						}
					}
					break;					
				case "btn_fax":
					if(ComIsBtnEnable(srcName)) {
						 sendFaxEmail("fax");
						 openPopupWindow(sheetObject1, formObject, srcName);
					}
					break;		
				case "btn_email":
					if(ComIsBtnEnable(srcName)) {
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
    		  ComConfigSheet (sheetObjects[i] );
			  initSheet(sheetObjects[i],i+1);
			  ComEndConfigSheet(sheetObjects[i]);
    	  }
    	  //init RD config
    	  initRdConfig(viewer);
    	  rdOpen(viewer);
    }
    /**
     * init RD
     * index : Index of toolbar items to be disabled. 0-Save a  file, 1-Print, 2-Find, 3-Creating a table of contents, 
     * 4-Zoom-in the screen, 5-Zoom-out the screen, 12-Stop printing, 13-View in Microsoft Excel, 14-View in Hangul, 
     * 15-View in pdf, 16-View in Microsoft PowerPoint, 17-View in Microsoft Word.
     * @param rdObject
     * @return
     */
	function initRdConfig(rdObject){
		var Rdviewer=rdObject ;
 		//Rdviewer.AutoAdjust=true;
//		Rdviewer.AutoAdjust=false;
//		Rdviewer.zoom = 100;		
// 		Rdviewer.ViewShowMode(0);
// 		Rdviewer.HideStatusBar();
// 		Rdviewer.SetPageLineColor(255,255,255);
		var hiddenParam = ["save"];
        Rdviewer.hideToolbarItem(hiddenParam);
//        Rdviewer.ApplyLicense("0.0.0.0"); 
	}
    /**
     * call rd report
     * @param rdObject
     * @return
     */
	function rdOpen(rdObject){
		 var Rdviewer=rdObject ;
    	 var formObj=document.form;
    	 var opener=window.dialogArguments;
    	 if (!opener) opener=window.opener;  //이 코드 추가할것
    	 if(!opener) opener=parent;
    	 var opnSheetObj=opener.sheet1;
    	 var sheetObj=sheetObjects[0];
    	 var sheetObj2=sheetObjects[1];
    	 ComSetObjValue(formObj.call_to_rd_tp, opener.document.form.call_to_rd_tp.value);
    	 if(ComGetObjValue(formObj.call_to_rd_tp) == 'group'){
    		 previewByGroup(Rdviewer, formObj, opener, opnSheetObj, sheetObj);
    	 } else {
    		 makeDataByBooking(formObj, opener, opnSheetObj, sheetObj2);
    		 
    		 var usr_cnt_cd = ComGetObjValue(formObj.rd_usr_cnt_cd);
    		 var rdParm=" /ruseurlmoniker [0] /rv " + rvParmByBooking(formObj) + " /rfn [" + RDServerIP + "/EES_DMT_3007_RD.do] /rpost [" + opener.sheetObjects[0].GetSaveString(false, true, "checkBox") + "]";
         	 if(ComGetObjValue(formObj.bil_to_loc_div_cd) == 'R'){         	 //RD - Right
//         		  if (usr_cnt_cd =='IN'){
//         			 Rdviewer.openFile(RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/demandnotesend/report/EES_DMT_3906.mrd', rdParm); 
//         		  }else {
         			 Rdviewer.openFile(RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/demandnotesend/report/EES_DMT_3902.mrd', rdParm, {timeout:1800});
//         		  }
         	 } else {         	 //RD - Left
//         		if (usr_cnt_cd =='IN'){
//         			Rdviewer.openFile(RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/demandnotesend/report/EES_DMT_3905.mrd', rdParm);
//         		
//         		}else {
         			Rdviewer.openFile(RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/demandnotesend/report/EES_DMT_3901.mrd', rdParm, {timeout:1800});
//         		}
         	 }
    	 }
	}
    /**
     * rv By Demand Booking 
     */ 
    function rvParmByBooking(formObj){
   		var formObj=document.form;
  		var opener=window.dialogArguments; // from MODAL parents window javascript called
  		if (!opener) opener=window.opener;  //이 코드 추가할것
	   	if(!opener) opener=parent;  		
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
					" TRUCKER[" + opener.document.form.trucker_nm.value 						+"]" +
					//" TRUCKER[" + ComGetObjValue(formObj.trucker) 						+"]" +
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
					" CUSTREF[" + ComGetObjValue(formObj.cust_ref_prn_flg)  				+"]" +
					" TELFAX[" + ComGetObjValue(formObj.phn_fax_prn_flg)  				+"]" +
					" CUSTVATNO[" + ComGetObjValue(formObj.cust_vat_prn_flg)  			+"]" +
					" TAXAMT[" + ComGetObjValue(formObj.tax_amt_prn_flg)				+"]" +
					" DCAMT[" + ComGetObjValue(formObj.dc_amt_prn_flg) 					+"]" +
					" RD_USR_CNT_CD[" + ComGetObjValue(formObj.rd_usr_cnt_cd) +"]" +
					" RD_IDA_EXPN_TAX_RT[" + ComGetObjValue(formObj.rd_ida_expn_tax_rt) +"]" +
					" RD_IDA_EXPN_TAX[" + ComGetObjValue(formObj.rd_ida_expn_tax) +"]" +
					" RD_IDA_EDU_TAX_RT[" + ComGetObjValue(formObj.rd_ida_edu_tax_rt) +"]" +
					" RD_IDA_EDU_TAX[" + ComGetObjValue(formObj.rd_ida_edu_tax) +"]" +
					" RD_IDA_HIGH_EDU_TAX_RT[" + ComGetObjValue(formObj.rd_ida_high_edu_tax_rt) +"]" +
					" RD_IDA_HIGH_EDU_TAX[" + ComGetObjValue(formObj.rd_ida_high_edu_tax) +"]" +
					" RD_TAX_RGST_NO[" + ComGetObjValue(formObj.rd_tax_rgst_no) +"]" +
					" RD_SVC_CATE_RMK[" + ComGetObjValue(formObj.rd_svc_cate_rmk) +"]" +
					" RD_PMNT_ACCT_NO[" + ComGetObjValue(formObj.rd_pmnt_acct_no) +"]"
					;
    	return rvRaram;
    }
      /**
       * RD (Booking) for the data call and reset
       */    
 	function makeDataByBooking(formObj, opener, opnSheetObj, sheetObj2){
  		ComSetObjValue(formObj.ofc_cd, 			opener.document.form.ofc_cd.value);
  		ComSetObjValue(formObj.dmdt_trf_cd, 	opener.document.form.dmdt_trf_cd.value);
  		ComSetObjValue(formObj.payer_cd, 		opener.document.form.payer_cd.value);
  		ComSetObjValue(formObj.payer_nm, 		opener.document.form.payer_nm.value);
  		//ComSetObjValue(formObj.trucker, 		opener.document.form.trucker_nm.value);
  		if(ComGetObjValue(opener.document.form.dmdt_payr_cntc_pnt_nm) == 'null'){
  			ComSetObjValue(formObj.dmdt_payr_cntc_pnt_nm, '');
  		} else {
  			ComSetObjValue(formObj.dmdt_payr_cntc_pnt_nm, opener.document.form.dmdt_payr_cntc_pnt_nm.value);
  		}
  		
  		ComSetObjValue(formObj.payr_cntc_pnt_phn_no, 	opener.document.form.payr_cntc_pnt_phn_no.value);
  		ComSetObjValue(formObj.payr_cntc_pnt_fax_no, 	opener.document.form.payr_cntc_pnt_fax_no.value);
  		ComSetObjValue(formObj.payr_cntc_pnt_eml, 		opener.document.form.payr_cntc_pnt_eml.value);
//  		ComSetObjValue(formObj.inv_curr_cd, 			opener.inv_curr_cd.value);
  		ComSetObjValue(formObj.bkg_no, 					opener.document.form.bkg_no.value);
  		//RD: TOTAL PART 
  		//ComSetObjValue(formObj.org_curr_cd, 			opener.document.form.chg_curr_cd.value); 
  		//ComSetObjValue(formObj.tot_org_amt, 			opener.document.form.mn_bil_amt.value); 
  		//total
  		//ComSetObjValue(formObj.ex_rate, 				opener.document.form.inv_xch_rt.value); 
  		ComSetObjValue(formObj.tot_amt, 				opener.document.form.tot_amt.value);
  		ComSetObjValue(formObj.dc_amt, 					opener.document.form.dc_amt.value);
  		ComSetObjValue(formObj.inv_chg_amt, 			opener.document.form.inv_chg_amt.value);
  		ComSetObjValue(formObj.tax_amt, 				opener.document.form.tax_amt.value);
  		ComSetObjValue(formObj.inv_amt, 				opener.document.form.inv_amt.value);
  		ComSetObjValue(formObj.tax_rto_dis, 			opener.document.form.tax_rto_dis.value);
  		ComSetObjValue(formObj.rd_ida_expn_tax_rt, 	    opener.document.form.ida_expn_tax_rt.value);
  		ComSetObjValue(formObj.rd_ida_expn_tax, 	    opener.document.form.ida_expn_tax.value);
  		ComSetObjValue(formObj.rd_ida_edu_tax_rt, 	    opener.document.form.ida_edu_tax_rt.value);
  		ComSetObjValue(formObj.rd_ida_edu_tax, 	        opener.document.form.ida_edu_tax.value);
  		ComSetObjValue(formObj.rd_ida_high_edu_tax_rt, 	opener.document.form.ida_high_edu_tax_rt.value);
  		ComSetObjValue(formObj.rd_ida_high_edu_tax, 	opener.document.form.ida_high_edu_tax.value);
  		ComSetObjValue(formObj.rd_tax_rgst_no, 	        opener.document.form.tax_rgst_no.value);
  		ComSetObjValue(formObj.rd_svc_cate_rmk, 	    opener.document.form.svc_cate_rmk.value);
  		ComSetObjValue(formObj.rd_pmnt_acct_no, 	    opener.document.form.pmnt_acct_no.value);
  		ComSetObjValue(formObj.rd_usr_cnt_cd, 	        opener.document.form.usr_cnt_cd.value);
  		
  		// If the six-digit vendor payer_cd an additional 00. Fill out the following Inquiry.
		ComSetObjValue(formObj.tmp_payer_cd, 	ComGetObjValue(formObj.payer_cd));
  		if(ComGetObjValue(formObj.payer_cd).length == 6) {
  			ComSetObjValue(formObj.payer_cd, 		"00" + ComGetObjValue(formObj.payer_cd));
  		}

  		formObj.f_cmd.value = SEARCH01;	
  		var sXml=sheetObj2.GetSearchData("EES_DMT_3007GS.do",	FormQueryString(formObj));
  		sheetObj2.LoadSearchData(sXml,{Sync:1} );
  		//Data received from the server at once, etc passed to form.
  		ComEtcDataToForm(formObj, sheetObj2);
  		// After Search, payer_cd to reset back to its previous value.
  		ComSetObjValue(formObj.payer_cd, 	ComGetObjValue(formObj.tmp_payer_cd));
        //onserver : address01 : DONGSHIN MARITIME AGENCY CO.,LTD.|SEJONG B/D 100 DANGJOO-DONG, JONGRO-GU, SEOUL, KOREA
        //"|" Is based on, cust_nm and address01 Resets back to the variable
   	  	if(!ComIsEmpty ( ComGetObjValue(formObj.address01) )){	
			  var temp=ComGetObjValue(formObj.address01).split("|");
			  ComSetObjValue(formObj.cust_nm,		temp[0]);			
		      ComSetObjValue(formObj.address01, 	temp[1]);	
   	  	} else {
   	  		  ComSetObjValue(formObj.cust_nm,		"");			
   	  		  ComSetObjValue(formObj.address01, 	"");	   	  			
   	  	}
   	  	//Address data "Enter" as a separator must separate processing.. 
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
	    	document.form.address01.value=ComReplaceStr(paryInfoAddr[2],"'"," ");
	        document.form.address02.value=ComReplaceStr(paryInfoAddr[2],"'"," ");
	        document.form.address03.value=ComReplaceStr(paryInfoAddr[2],"'"," ");
	        document.form.address04.value=ComReplaceStr(paryInfoAddr[2],"'"," ");
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
      /**
      * preview By Demand Group 
      */  
	function previewByGroup(rdObject, formObj, opener, opnSheetObj, sheetObj){
		var Rdviewer=rdObject ;
     	makeDataByGroup(formObj, opener, opnSheetObj, sheetObj);
     	//faxEmailByGroup(formObj, opener, opnSheetObj, sheetObj);
    	var bkgNos="";
    	var cntrNos="";
  		var chkRows=opnSheetObj.FindCheckedRow(1).split("|");
  		for(var i=0; i < chkRows.length; i++) {
  			bkgNos  += ','+opnSheetObj.GetCellValue(chkRows[i], "bkg_no");
  			cntrNos += ','+opnSheetObj.GetCellValue(chkRows[i], "cntr_no");
  		}
  		ComSetObjValue(formObj.bkg_no, 	bkgNos.substring(1));
  		ComSetObjValue(formObj.cntr_no, cntrNos.substring(1));
  		var rdRaram=" /rp [" + ComGetObjValue(formObj.ofc_cd) 								+"]" +
  		 				  " [" + ComGetObjValue(formObj.dmdt_trf_cd) 							+"]" +
  		 				  " [" + ComReplaceStr(ComGetObjValue(formObj.dmdt_chg_sts_cd), "R", "L") 	+"]" +
  		 				  " [" + ComGetObjValue(formObj.bkg_no) 								+"]" +
  		 				  " [" + ComGetObjValue(formObj.cntr_no) 								+"]" +
  		 				" [" + ComGetObjValue(formObj.ofc_add01)					+"]" +	
  		 				" [" + ComGetObjValue(formObj.ofc_add02) 					+"]" +
  		 				" [" + ComGetObjValue(formObj.ofc_add03) 					+"]" +
  		 				" [" + ComGetObjValue(formObj.print_date) 					+"]" +
  		 				" [" + ComGetObjValue(formObj.cust_nm)			 			+"]" +
  		 				" [" + ComGetObjValue(formObj.address01) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.address02) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.address03) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.address04) 					+"]" +
  		 				" [" + ComGetObjValue(formObj.dmdt_payr_cntc_pnt_nm) 		+"]" +
  		 				" [" + ComGetObjValue(formObj.payr_cntc_pnt_phn_no) 		+"]" +
  		 				" [" + ComGetObjValue(formObj.payr_cntc_pnt_fax_no) 		+"]" +
  		 				" [" + ComGetObjValue(formObj.com_ref) 						+"]" +
  		 				" [" + ComGetObjValue(formObj.payer_cd) 					+"]" +
  		 				" [" + ComGetObjValue(formObj.cust_vat) 					+"]" +
  		 				" [" + ComGetObjValue(formObj.header01) 					+"]" +
  		 				" [" + ComGetObjValue(formObj.header02) 					+"]" +
  		 				" [" + ComGetObjValue(formObj.header03) 					+"]" +
  		 				" [" + ComGetObjValue(formObj.header04) 					+"]" +
  		 				" [" + ComGetObjValue(formObj.header05) 					+"]" +
  		 				" [" + ComGetObjValue(formObj.header06) 					+"]" +
  		 				" [" + ComGetObjValue(formObj.header07) 					+"]" +
  		 				" [" + ComGetObjValue(formObj.header08) 					+"]" +
  		 				" [" + ComGetObjValue(formObj.header09) 					+"]" +
  		 				" [" + ComGetObjValue(formObj.header10) 					+"]" +
  		 				" [" + ComGetObjValue(formObj.dmdt_trf_cd) 					+"]" +
  		 				" [(" + ComGetObjValue(formObj.dmdt_trf_nm) 				+")]" +
  		 				" [" + ComGetObjValue(formObj.tot_bil_amt) 					+"]" +
  		 				" [" + ComGetObjValue(formObj.tax_rto_dis) 					+"]" +
  		 				" [" + ComGetObjValue(formObj.tot_tax_amt) 					+"]" +
  		 				" [" + ComGetObjValue(formObj.tot_payable_amt) 				+"]" +
  		 				" [" + ComGetObjValue(formObj.inv_curr_cd) 					+"]" +
  		 				" [" + ComGetObjValue(formObj.bil_to_loc_div_cd) 			+"]" +
  		 				" [" + ComGetObjValue(formObj.cust_ref_prn_flg) 			+"]" +
  		 				" [" + ComGetObjValue(formObj.phn_fax_prn_flg) 				+"]" +
  		 				" [" + ComGetObjValue(formObj.cust_vat_prn_flg) 			+"]" +
  		 				" [" + ComGetObjValue(formObj.tax_amt_prn_flg) 				+"]" +
  		 				" [" + ComGetObjValue(formObj.dc_amt_prn_flg) 				+"]" +
  		 				" [*** " + ComGetObjValue(formObj.title) 					+" ***]"
//  		 				" /rv TAX_NM[" + ComGetObjValue(formObj.tax_nm)				+"]" +
//		 				" RD_IDA_EXPN_TAX_RT[" + ComGetObjValue(formObj.rd_ida_expn_tax_rt)	+"]" +
//		 				" RD_IDA_EXPN_TAX[" + ComGetObjValue(formObj.rd_ida_expn_tax)		+"]" +
//		 				" RD_IDA_EDU_TAX_RT[" + ComGetObjValue(formObj.rd_ida_edu_tax_rt)	+"]" +
//		 				" RD_IDA_EDU_TAX[" + ComGetObjValue(formObj.rd_ida_edu_tax)			+"]" +
//		 				" RD_IDA_HIGH_EDU_TAX_RT[" + ComGetObjValue(formObj.rd_ida_high_edu_tax_rt)	+"]" +
//		 				" RD_IDA_HIGH_EDU_TAX[" + ComGetObjValue(formObj.rd_ida_high_edu_tax)		+"]" +
//		 				" RD_TAX_RGST_NO[" + ComGetObjValue(formObj.rd_tax_rgst_no)			+"]" +
//		 				" RD_SVC_CATE_RMK[" + ComGetObjValue(formObj.rd_svc_cate_rmk)		+"]" +
//		 				" RD_PMNT_ACCT_NO[" + ComGetObjValue(formObj.rd_pmnt_acct_no)		+"]"
  		 			   ;
//  		ComSetObjValue(formObj.rd_fxeml_rd_param, 	rdRaram);
  		ComSetObjValue(formObj.rd_fxeml_rd_param, 	RDServerBAT + rdRaram);
  		var rdParm=ComGetObjValue(formObj.rd_fxeml_rd_param);
  	    var usr_cnt_cd = ComGetObjValue(formObj.rd_usr_cnt_cd);
//  		ComDebug(rdParm);
     	//RD - Right
     	if(ComGetObjValue(formObj.bil_to_loc_div_cd) == 'R'){
//     		if (usr_cnt_cd =='IN'){
//     			Rdviewer.openFile(RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/demandnotesend/report/EES_DMT_3908.mrd', RDServerIP+" "+ rdParm);
//     		}else{
     			Rdviewer.openFile(RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/demandnotesend/report/EES_DMT_3904.mrd', RDServerIP+" "+ rdParm, {timeout:1800});
//     		}
     	} 
     	//RD - Left
     	else {
//     		if (usr_cnt_cd =='IN'){
//     			Rdviewer.openFile(RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/demandnotesend/report/EES_DMT_3907.mrd', RDServerIP+" "+ rdParm);
//     		}else{
     			Rdviewer.openFile(RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/demandnotesend/report/EES_DMT_3903.mrd', RDServerIP+" "+ rdParm, {timeout:1800});
//     		}
     	}
	}
	function sendFaxEmail(sendType){
  		var formObj=document.form;  		

		var opener=window.dialogArguments;
		if (!opener) opener=window.opener;  //이 코드 추가할것
		if (!opener) opener=parent; 
  		
  		var opnfrmObj=opener.form;
 	 	var opnSheetObj=opener.sheet1;
 	 	var sheetObj=sheetObjects[0];  // Group  called.
 	 	var sheetObj2=sheetObjects[1]; // Booking   called.
 	 	var usr_cnt_cd = ComGetObjValue(formObj.rd_usr_cnt_cd);  
 	 	
 	 	// check from system
 	 	// ex)call_to_rd_tp = "booking" or call_to_rd_tp = "group"
 	 	// 1. group - 3108, booking - 3109 
 	 	ComSetObjValue(formObj.call_to_rd_tp, opener.document.form.call_to_rd_tp.value);
 	 	if(ComGetObjValue(formObj.call_to_rd_tp) == 'group'){
 	 		//1.
 		 	makeDataByGroup(formObj, opener, opnSheetObj, sheetObj);
 		    //2.GROUP  RD DATA
 		 	faxEmailByGroup(formObj, opener, opnSheetObj, sheetObj);
 		 	//3.fax/email
 		 	faxEmaiInfoByGroup(formObj, opener, opnSheetObj, sheetObj);
 		 	if(ComGetObjValue(formObj.bil_to_loc_div_cd) == 'R'){
// 		 		if (usr_cnt_cd == 'IN') {
//				   ComSetObjValue(formObj.rd_fxeml_file_name  , 	 "EES_DMT_3908.mrd");
// 		 		}else{
 		 			ComSetObjValue(formObj.rd_fxeml_file_name  , 	 "EES_DMT_3904.mrd");
// 		 		}
  	 		} 
  	 		//RD - Left
  	 		else {
//  	 			if (usr_cnt_cd == 'IN') {
// 				   ComSetObjValue(formObj.rd_fxeml_file_name  , 	 "EES_DMT_3907.mrd");
//  		 		}else{
  	    		   ComSetObjValue(formObj.rd_fxeml_file_name  , 	 "EES_DMT_3903.mrd");
//   	 		    }	
  	 		}	
 	 	}
 	 	// demand by booking
 	 	else {
 		 	makeDataByBooking(formObj, opener, opnSheetObj, sheetObj2);
 		 	var rdParm=" /ruseurlmoniker [0] /rv " + rvParmByBooking(formObj) + " /rfn [" + RDServerIP + "/EES_DMT_3007_RD.do] /rpost [" + opener.sheetObjects[0].GetSaveString(false, true, "checkBox") + "]";
 		 	ComSetObjValue(formObj.rd_fxeml_rd_param, 	rdParm);
 		 	faxEmaiInfoByBooking(formObj, opener, opnSheetObj, sheetObj2);
 		 	if(ComGetObjValue(formObj.bil_to_loc_div_cd) == 'R'){
// 		 		if (usr_cnt_cd == 'IN') {
// 				   ComSetObjValue(formObj.rd_fxeml_file_name  , 	 "EES_DMT_3906.mrd");
//  		 		}else{
  				   ComSetObjValue(formObj.rd_fxeml_file_name  , 	 "EES_DMT_3902.mrd");
//  		 		}   
  	 		} 
  	 		//RD - Left
  	 		else {
//  	 			if (usr_cnt_cd == 'IN') {
//  				   ComSetObjValue(formObj.rd_fxeml_file_name  , 	 "EES_DMT_3905.mrd");
//   		 		}else{
  	    		   ComSetObjValue(formObj.rd_fxeml_file_name  , 	 "EES_DMT_3901.mrd");
//   		 		}
  	 		}	
 	 	}
	}
	function faxEmailByGroup(formObj, opener, opnSheetObj, sheetObj){
   	  	var bkgNos="";
   	  	var cntrNos="";
 		var chkRows=opnSheetObj.FindCheckedRow(1).split("|");
 		for(var i=0; i < chkRows.length; i++) {
 			bkgNos  += ','+opnSheetObj.GetCellValue(chkRows[i], "bkg_no");
 			cntrNos += ','+opnSheetObj.GetCellValue(chkRows[i], "cntr_no");
 		}
 		ComSetObjValue(formObj.bkg_no, 	bkgNos.substring(1));
 		ComSetObjValue(formObj.cntr_no, cntrNos.substring(1));
 		//var rdRaram = "/rsn [jdbc/OPUSCNTR] /rp  [" + ComGetObjValue(formObj.ofc_cd) 				+"]" +
 		var rdRaram=" /rp  [" + ComGetObjValue(formObj.ofc_cd) 								+"]" +
 		 				  " [" + ComGetObjValue(formObj.dmdt_trf_cd) 							+"]" +
 		 				  " [" + ComReplaceStr(ComGetObjValue(formObj.dmdt_chg_sts_cd), "R", "L") 	+"]" +
 		 				  " [" + ComGetObjValue(formObj.bkg_no) 								+"]" +
 		 				  " [" + ComGetObjValue(formObj.cntr_no) 								+"]" +
 		 				" [" + ComGetObjValue(formObj.ofc_add01)					+"]" +	
 		 				" [" + ComGetObjValue(formObj.ofc_add02) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.ofc_add03) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.print_date) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.cust_nm)			 			+"]" +
 		 				" [" + ComGetObjValue(formObj.address01) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.address02) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.address03) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.address04) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.dmdt_payr_cntc_pnt_nm) 		+"]" +
 		 				" [" + ComGetObjValue(formObj.payr_cntc_pnt_phn_no) 		+"]" +
 		 				" [" + ComGetObjValue(formObj.payr_cntc_pnt_fax_no) 		+"]" +
 		 				" [" + ComGetObjValue(formObj.com_ref) 						+"]" +
 		 				" [" + ComGetObjValue(formObj.payer_cd) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.cust_vat) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.header01) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.header02) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.header03) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.header04) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.header05) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.header06) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.header07) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.header08) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.header09) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.header10) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.dmdt_trf_cd) 					+"]" +
 		 				" [(" + ComGetObjValue(formObj.dmdt_trf_nm) 				+")]" +
 		 				" [" + ComGetObjValue(formObj.tot_bil_amt) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.tax_rto_dis) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.tot_tax_amt) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.tot_payable_amt) 				+"]" +
 		 				" [" + ComGetObjValue(formObj.inv_curr_cd) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.bil_to_loc_div_cd) 			+"]" +
 		 				" [" + ComGetObjValue(formObj.cust_ref_prn_flg) 			+"]" +
 		 				" [" + ComGetObjValue(formObj.phn_fax_prn_flg) 				+"]" +
 		 				" [" + ComGetObjValue(formObj.cust_vat_prn_flg) 			+"]" +
 		 				" [" + ComGetObjValue(formObj.tax_amt_prn_flg) 				+"]" +
 		 				" [" + ComGetObjValue(formObj.dc_amt_prn_flg) 				+"]" +
 		 				" [*** " + ComGetObjValue(formObj.title) 					+" ***]"
// 		 				" /rv TAX_NM[" + ComGetObjValue(formObj.tax_nm)				+"]" +
//		 				" RD_IDA_EXPN_TAX_RT[" + ComGetObjValue(formObj.rd_ida_expn_tax_rt)	+"]" +
//		 				" RD_IDA_EXPN_TAX[" + ComGetObjValue(formObj.rd_ida_expn_tax)		+"]" +
//		 				" RD_IDA_EDU_TAX_RT[" + ComGetObjValue(formObj.rd_ida_edu_tax_rt)	+"]" +
//		 				" RD_IDA_EDU_TAX[" + ComGetObjValue(formObj.rd_ida_edu_tax)			+"]" +
//		 				" RD_IDA_HIGH_EDU_TAX_RT[" + ComGetObjValue(formObj.rd_ida_high_edu_tax_rt)	+"]" +
//		 				" RD_IDA_HIGH_EDU_TAX[" + ComGetObjValue(formObj.rd_ida_high_edu_tax)		+"]" +
//		 				" RD_TAX_RGST_NO[" + ComGetObjValue(formObj.rd_tax_rgst_no)			+"]" +
//		 				" RD_SVC_CATE_RMK[" + ComGetObjValue(formObj.rd_svc_cate_rmk)		+"]" +
//		 				" RD_PMNT_ACCT_NO[" + ComGetObjValue(formObj.rd_pmnt_acct_no)		+"]" 
 		 			   ;
// 		ComSetObjValue(formObj.rd_fxeml_rd_param, 	rdRaram);
 		ComSetObjValue(formObj.rd_fxeml_rd_param, 	RDServerBAT + rdRaram);
	}     
	function faxEmaiInfoByBooking(formObj, opener, opnSheetObj, sheetObj){
 		//EMAIL 
        ComSetObjValue(formObj.rd_fxeml_sys_cd         , 	 "DMT");
		ComSetObjValue(formObj.rd_fxeml_bat_flg        , 	 "N");
		//Demand Note  subject
		ComSetObjValue(formObj.rd_fxeml_title		   ,  	 "DemDet Statement(BL#: " +ComGetObjValue(formObj.bl_no) + ")");               
		ComSetObjValue(formObj.rd_fxeml_doc_tp		   , 	 "D");
		ComSetObjValue(formObj.rd_fxeml_fax_no         , 	 "");
		ComSetObjValue(formObj.rd_fxeml_fax_sndr_id    , 	 "COMPANY");
 		ComSetObjValue(formObj.rd_fxeml_eml_sndr_nm    , 	 "Demurrage / Detention Statement");
		ComSetObjValue(formObj.rd_fxeml_eml_rcvr_add   , 	 "");//;mjchang@COMPANY.com
		ComSetObjValue(formObj.rd_fxeml_eml_atch_file  , 	 ComGetNowInfo("ymd") + "_" + ComGetObjValue(formObj.bl_no)); //YYYY-MM-DD_COM+B/L No. (ex: 2010-02-24_COMSHAE61559002)
		ComSetObjValue(formObj.rd_fxeml_eml_templt     , 	 "EES_DMT_DEMAND_001.htmlmail"); // Template Location C:/sitectx/OPUSCNTR\APP-INF/config/template/mailtemplate/template.htmlmail
		ComSetObjValue(formObj.rd_fxeml_eml_tmplt_param, 	 "bl_no;" + ComGetObjValue(formObj.bl_no) + "|bl_no;" + ComGetObjValue(formObj.bl_no) + "");
 		ComSetObjValue(formObj.invno					, 	 "DemandNot");
 		ComSetObjValue(formObj.payc						, 	 ComGetObjValue(formObj.payer_cd) );
	}	
	function faxEmaiInfoByGroup(formObj, opener, opnSheetObj, sheetObj){
 		//EMAIL 
        ComSetObjValue(formObj.rd_fxeml_sys_cd         , 	 "DMT");
 		ComSetObjValue(formObj.rd_fxeml_bat_flg        , 	 "N");
 		ComSetObjValue(formObj.rd_fxeml_title          , 	 "DemDet Statement(Custmer Code: "+document.form.payer_cd.value+")");
 		ComSetObjValue(formObj.rd_fxeml_doc_tp		   , 	 "G");
 		ComSetObjValue(formObj.rd_fxeml_fax_no         , 	 "");
 		ComSetObjValue(formObj.rd_fxeml_fax_sndr_id    , 	 "COMPANY");
 		ComSetObjValue(formObj.rd_fxeml_eml_sndr_nm    , 	 "Demurrage / Detention Statement");
 		ComSetObjValue(formObj.rd_fxeml_eml_rcvr_add   , 	 "");//;mjchang@COMPANY.com
 		ComSetObjValue(formObj.rd_fxeml_eml_atch_file  , 	 ComGetNowInfo("ymd") + "_" + ComGetObjValue(formObj.payer_cd)); //YYYY-MM-DD_payer code (ex: 2010-02-24_KR123456)
 		ComSetObjValue(formObj.rd_fxeml_eml_templt     , 	 "EES_DMT_DEMAND_002.htmlmail"); // Template Location C:/sitectx/OPUSCNTR\APP-INF/config/template/mailtemplate/template.htmlmail
 		ComSetObjValue(formObj.rd_fxeml_eml_tmplt_param, 	 "");
 		ComSetObjValue(formObj.invno					, 	 "DemandNot");
 		ComSetObjValue(formObj.payc						, 	 ComGetObjValue(formObj.payer_cd) );
	}
	/**
     * RD for the data call and reset
     */    
	function makeDataByGroup(formObj, opener, opnSheetObj, sheetObj){
    	ComSetObjValue(formObj.ofc_cd, 					opener.document.form.ofc_cd.value);
		ComSetObjValue(formObj.dmdt_trf_cd, 			opener.document.form.dmdt_trf_cd.value);
		ComSetObjValue(formObj.dmdt_chg_sts_cd, 		opener.document.form.dmdt_chg_sts_cds.value);  //code list
		ComSetObjValue(formObj.payer_cd, 				opener.document.form.payer_cd.value);
		ComSetObjValue(formObj.payer_nm, 				opener.document.form.payer_nm.value);
		ComSetObjValue(formObj.dmdt_payr_cntc_pnt_nm, 	opener.document.form.dmdt_payr_cntc_pnt_nm.value);
		ComSetObjValue(formObj.payr_cntc_pnt_phn_no, 	opener.document.form.payr_cntc_pnt_phn_no.value);
		ComSetObjValue(formObj.payr_cntc_pnt_fax_no, 	opener.document.form.payr_cntc_pnt_fax_no.value);
		ComSetObjValue(formObj.payr_cntc_pnt_eml, 		opener.document.form.payr_cntc_pnt_eml.value);
		ComSetObjValue(formObj.inv_curr_cd, 			opener.document.form.inv_curr_cd.value);
        //Before the RD calls, Screen obtain information needed from the selection of    	  
        ComSetObjValue(formObj.tot_bil_amt, 			opener.document.form.tot_bil_amt.value);
        ComSetObjValue(formObj.tot_tax_amt, 			opener.document.form.tot_tax_amt.value);
        ComSetObjValue(formObj.tot_payable_amt, 		opener.document.form.tot_payable_amt.value);
        ComSetObjValue(formObj.tax_rto_dis, 			opener.document.form.tax_rto_dis.value);
        ComSetObjValue(formObj.rd_usr_cnt_cd, 			opener.document.form.usr_cnt_cd.value);
        
        //인도 관련 항목.
 		ComSetObjValue(formObj.rd_ida_expn_tax_rt, 	    opener.document.form.ida_expn_tax_rt.value);
  		ComSetObjValue(formObj.rd_ida_expn_tax, 	    opener.document.form.ida_expn_tax.value);
  		ComSetObjValue(formObj.rd_ida_edu_tax_rt, 	    opener.document.form.ida_edu_tax_rt.value);
  		ComSetObjValue(formObj.rd_ida_edu_tax, 	        opener.document.form.ida_edu_tax.value);
  		ComSetObjValue(formObj.rd_ida_high_edu_tax_rt, 	opener.document.form.ida_high_edu_tax_rt.value);
  		ComSetObjValue(formObj.rd_ida_high_edu_tax, 	opener.document.form.ida_high_edu_tax.value);
  		ComSetObjValue(formObj.rd_tax_rgst_no, 	        opener.document.form.tax_rgst_no.value);
  		ComSetObjValue(formObj.rd_svc_cate_rmk, 	    opener.document.form.svc_cate_rmk.value);
  		ComSetObjValue(formObj.rd_pmnt_acct_no, 	    opener.document.form.pmnt_acct_no.value);
  		
        // If the six-digit vendor payer_cd an additional 00. Fill out the following Inquiry.
        ComSetObjValue(formObj.tmp_payer_cd, 	ComGetObjValue(formObj.payer_cd));
        if(ComGetObjValue(formObj.payer_cd).length == 6) {
        	ComSetObjValue(formObj.payer_cd, 		"00" + ComGetObjValue(formObj.payer_cd));
        }
        formObj.f_cmd.value=SEARCH01;
        var sXml=sheetObj.GetSearchData("EES_DMT_3007GS.do",	FormQueryString(formObj));
        sheetObj.LoadSearchData(sXml,{Sync:1} );
        //Data received from the server at once, etc passed to form.
        ComEtcDataToForm(formObj, sheetObj);
       // After Search, payer_cd to reset back to its previous value.
        ComSetObjValue(formObj.payer_cd, 	ComGetObjValue(formObj.tmp_payer_cd));
        //on server : address01 : DONGSHIN MARITIME AGENCY CO.,LTD.|SEJONG B/D 100 DANGJOO-DONG, JONGRO-GU, SEOUL, KOREA
        //"|" Is based on, cust_nm and address01 Resets back to the variable
        if(!ComIsEmpty ( ComGetObjValue(formObj.address01) )){	
  		  var temp=ComGetObjValue(formObj.address01).split("|");
  		  ComSetObjValue(formObj.cust_nm,		temp[0]);			
  	      ComSetObjValue(formObj.address01, 	temp[1]);	
  	  	} else {
  	  		  ComSetObjValue(formObj.cust_nm,		"");			
  	  		  ComSetObjValue(formObj.address01, 	"");	   	  			
  	  	}
   	  	//Address data "Enter" as a separator must separate processing.. 
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
	    	document.form.address01.value=ComReplaceStr(paryInfoArr[2],"'"," ");
	        document.form.address02.value=ComReplaceStr(paryInfoArr[2],"'"," ");
	        document.form.address03.value=ComReplaceStr(paryInfoArr[2],"'"," ");
	        document.form.address04.value=ComReplaceStr(paryInfoArr[2],"'"," ");
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
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////     
  /**
 	* setting sheet initial values and header
 	* param : sheetObj, sheetNo
 	* adding case as numbers of counting sheets
 	*/
	function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
      	switch(sheetID) {
          	case "sheet1":      // t1sheet1 init
          	    with(sheetObj){
		              var HeadTitle="|Seq.|VVD_CD|BL_NO|LOC|CNTR_NO|CNTR_TPSZ_CD|FM_MVMT_DT|TO_MVMT_DT|ft_cmnc_dt|FT_END_DT|FT_DYS|FX_FT_OVR_DYS|BZC_TRF_CURR_CD|org_chg_amt|EXPT_AMT|AFT_EXPT_DC_AMT|BIL_AMT";
		              var headCount=ComCountHeadTitle(HeadTitle);
		              (headCount, 0, 0, true);
		              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
			                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"loc",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"fm_mvmt_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"to_mvmt_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ft_cmnc_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ft_end_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ft_dys",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"fx_ft_ovr_dys",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bzc_trf_curr_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"org_chg_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"expt_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"aft_expt_dc_amt",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bil_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
		               
		              InitColumns(cols);
		              SetEditable(1);
		              SetSheetHeight(100);
                    }


                break;  
          	case "sheet2":      // t1sheet1 init
          	    with(sheetObj){                
		              var HeadTitle="|Seq.|cntr_no|cntr_tpsz_cd|fm_mvmt_dt|to_mvmt_dt|ft_cmnc_dt|ft_end_dt|ft_dys|ft_ovr_und_dys|rt_amt|fx_ft_ovr_dys|rt_amount|bzc_trf_curr_cd";
		              var headCount=ComCountHeadTitle(HeadTitle);
		              (headCount, 0, 0, true);
		              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"fm_mvmt_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"to_mvmt_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ft_cmnc_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ft_end_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ft_dys",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ft_ovr_und_dys",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rt_amt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"fx_ft_ovr_dys",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rt_amount",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bzc_trf_curr_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		               
		              InitColumns(cols);
		              SetEditable(1);
		              SetSheetHeight(100);
                    }
            break;                  
      	}                
	}      
 	/**
 	 * EES_DMT_3109, EES_DMT_3108 call
 	 * @param sheetObj
 	 * @param formObj
 	 * @param srcName
 	 * @return
 	 */
 	function openPopupWindow(sheetObj, formObj, srcName) {
 		var sheetType="";
 		 if(ComGetObjValue(formObj.call_to_rd_tp) == 'group'){
 			sheetType="G";
 		} else {
 			sheetType="D";
 		}
 		if(srcName == "btn_set") {
 			var url="EES_DMT_4101.do"
 				+"?issoff="+ComGetObjValue(formObj.ofc_cd)
 				+"&tftp2="+ComGetObjValue(formObj.dmdt_trf_cd)
 				+"&sheetp="+sheetType
 				+"&invoice_issue=1"
 				+"&jspno=EES_DMT_3007";
			var sWidht  = "780";
			var sHeight = "700";
   			ComOpenWindowCenter(url, "EES_DMT_4101", sWidht, sHeight, true, "yes"); 			
 		} 
 		else if(srcName == "btn_option") {
 			var url="EES_DMT_4103.do"
 				+"?issoff="+ComGetObjValue(formObj.ofc_cd)
 				+"&invoice_issue=1"
 				+"&jspno=EES_DMT_3007";
 			var sWidht  = "625";
			var sHeight = "680";   			
   			ComOpenWindowCenter(url, "EES_DMT_4103", sWidht, sHeight, true);  			
 		} 
 		else if(srcName == "btn_payerfaxemail") {
			var url="EES_DMT_4104.do"
				+"?s_ofc_cd="+ComGetObjValue(formObj.ofc_cd)
				+"&s_cust_cd="+ComGetObjValue(formObj.payer_cd)
				+"&s_bkg_no="
				+"&s_pod_cd="
				var sWidht  = "825";
				var sHeight = "585"; 	
				ComOpenWindowCenter(url, "EES_DMT_4104", sWidht, sHeight, true);				
		} 
 		else if (srcName == "btn_fax") {
			if (ComGetObjValue(formObj.payer_cd) == null || ComGetObjValue(formObj.payer_cd) == "") {
				ComShowCodeMessage("DMT00182");
				return;
			}
			var ofc_cd=ComGetObjValue(formObj.session_ofc_cd);
			var url="EES_DMT_4107.do"
				+"?s_ofc_cd="+ofc_cd
				+"&s_cust_cd="+ComGetObjValue(formObj.payer_cd)
				+"&s_bkg_no="//+ComGetObjValue(formObj.bkg_no)
				+"&s_pod_cd="//+ComGetObjValue(formObj.pod_cd)
				+"&jspno=3109"
				+"&telno="+ComGetObjValue(formObj.payr_cntc_pnt_phn_no)
				+"&faxno="+ComGetObjValue(formObj.payr_cntc_pnt_fax_no)
				+"&email="+ComGetObjValue(formObj.payr_cntc_pnt_eml)
				+"&cntc_seq="//
				;
			var sWidht  = "520";
			var sHeight = "250";
			ComOpenWindowCenter(url, "EES_DMT_4107", sWidht, sHeight, true);				
		} 
 		else if (srcName == "btn_email") {
			if (ComGetObjValue(formObj.payer_cd) == null || ComGetObjValue(formObj.payer_cd) == "") {
				ComShowCodeMessage("DMT00182");
				return;
			}
			var ofc_cd=ComGetObjValue(formObj.session_ofc_cd);
			var url="EES_DMT_4108.do"
				+"?s_ofc_cd="+ofc_cd
				+"&s_cust_cd="+ComGetObjValue(formObj.payer_cd)
				+"&s_bkg_no="//+ComGetObjValue(formObj.bkg_no)
				+"&s_pod_cd="//+ComGetObjValue(formObj.pod_cd)
				+"&jspno=3109"
				+"&telno="+ComGetObjValue(formObj.payr_cntc_pnt_phn_no)
				+"&faxno="+ComGetObjValue(formObj.payr_cntc_pnt_fax_no)
				+"&email="+ComGetObjValue(formObj.payr_cntc_pnt_eml)
				+"&cntc_seq="//
				;
			var sWidht  = "520";
			var sHeight = "250";	
			ComOpenWindowCenter(url, "EES_DMT_4108", sWidht, sHeight, true);			
		}
 	}     	
 	// Process of Sheet
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
             case IBSEARCH_ASYNC05:     // Search
                 //ComOpenWait Start
				 sheetObj.SetWaitImageVisible(0);
	        	 ComOpenWait(true);
                 formObj.f_cmd.value=SEARCH05;
                  sheetObj.DoSearch("DMTCommonFaxEmailGS.do", FormQueryString(formObj)  );
                 //ComOpenWait End
				 ComOpenWait(false);
             break;
             case IBSEARCH_ASYNC06:     // Search
	             //ComOpenWait Start
				 sheetObj.SetWaitImageVisible(0);
	        	 ComOpenWait(true);             
	        	 formObj.f_cmd.value=SEARCH06;
                 var sXml06=sheetObj.GetSaveData("DMTCommonFaxEmailGS.do", FormQueryString(formObj));
                 sheetObjects[0].LoadSaveData(sXml06);
                 //ComOpenWait End
				 ComOpenWait(false);
             break;
         }
     }
