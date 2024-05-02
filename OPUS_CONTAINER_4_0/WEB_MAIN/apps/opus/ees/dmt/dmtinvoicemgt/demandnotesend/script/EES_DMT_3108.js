/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_DMT_3108.js
*@FileTitle  : Demand Note Issue by Group
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30
=========================================================*/
	//Common global variable
//    var rdObjects=new Array();
//	rdObjects[0] = document.getElementById("invPreview"); 
    
//    var rdCnt=0;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var ROWMARK="|";
	var FIELDMARK="=";
	var IBSEARCH02=51;;
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
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
	            case "btn_payer_cd":
	         		openPopup('s_cust_cd');
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
						//When there is no Data
						if(sheetObject1.RowCount()== 0){
							ComShowCodeMessage('DMT00164');
							return false;
						}
						//If there is no Payer Code, INV Cur. information, showing "Pls update Payer code first!" Alert window
						var payerCd=ComGetObjValue(formObject.payer_cd);
						if(payerCd == ''){
							ComShowCodeMessage('DMT00182');
							ComSetFocus(formObject.payer_cd);
							return;
						} else {
							//In case of that there is no data Sheet Set
							if (!validateSheetSetForGroup()) {
								ComShowCodeMessage('DMT01096');
								return false;
							}
							ComOpenPopupWithTarget('EES_DMT_3007.do', "920", "680", "", "0,1,1,1,1,1,1", true);
						}
					}
					break;
				case "btn_print":
					if(ComIsBtnEnable(srcName)) {
						//When there is no Data 
						if(sheetObject1.RowCount()== 0){
							ComShowCodeMessage('DMT00164');
							return false;
						}
						//If there is no Payer Code, INV Cur. information, showing "Pls update Payer code first!" Alert window
						var payerCd=ComGetObjValue(formObject.payer_cd);
						if(payerCd == ''){
							ComShowCodeMessage('DMT00182');
							ComSetFocus(formObject.payer_cd);
							return;
						} else {
							//In case of that there is no data Sheet Set
							if (!validateSheetSetForGroup()) {
								ComShowCodeMessage('DMT01096');
								return false;
							}
		 					//ComOpenWait Start
		 					sheetObject1.SetWaitImageVisible(0);
		 		        	ComOpenWait(true);
							//init RD config
//							initRdConfig(rdObjects[0]);
							rdOpen();
							//ComOpenWait End
							ComOpenWait(false);
						}
					}
					break;
				case "btn_fax":
					if(ComIsBtnEnable(srcName)) {
						//When there is no Data 
						if(sheetObject1.RowCount()== 0){
							ComShowCodeMessage('DMT00164');
							return false;
						}
						//In case of that there is no data Sheet Set
						if (!validateSheetSetForGroup()) {
							ComShowCodeMessage('DMT01096');
							return false;
						}
						sendFaxEmail("fax");
						openPopupWindow(sheetObject1, formObject, srcName);
					}
					break;
				case "btn_email":
					if(ComIsBtnEnable(srcName)) {
						//When there is no Data 
						if(sheetObject1.RowCount()== 0){
							ComShowCodeMessage('DMT00164');
							return false;
						}
						//In case of that there is no data Sheet Set
						if (!validateSheetSetForGroup()) {
							ComShowCodeMessage('DMT01096');
							return false;
						}
						sendFaxEmail("email");
						openPopupWindow(sheetObject1, formObject, srcName);
					}
					break;																														
				case "btn_payerfaxemail":
					if(ComIsBtnEnable(srcName)) {
						//If there is no Payer Code, INV Cur. information, showing "Pls update Payer code first!" Alert window
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
				case "btn_down_excel":
					//When there is no Data
					if(sheetObject1.RowCount()< 1){
						ComShowCodeMessage('DMT00164');
						return false;
					}
					sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
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
	 * Sheet Set data should determine whether: If you do not have the data processing does not RD.
	 */
	function validateSheetSetForGroup(){
		var formObj=document.form;
		var opnSheetObj=document.sheet1;
		var sheetObj=sheetObjects[1];  // Group 호출 시 사용.
		makeDataByGroup(formObj, opnSheetObj, sheetObj);
		// Check Group Sheet Set - If you do not have full alert MSG
   	  	if(  ComGetObjValue(formObj.ofc_add01) == ''
    		  && ComGetObjValue(formObj.ofc_add02) == '' 
    		  && ComGetObjValue(formObj.ofc_add03) == '' 
    		  && ComGetObjValue(formObj.header01) == '' 
    		  && ComGetObjValue(formObj.header02) == '' 
    		  && ComGetObjValue(formObj.header03) == '' 
    		  && ComGetObjValue(formObj.header04) == '' 
    		  && ComGetObjValue(formObj.header05) == '' 
    		  && ComGetObjValue(formObj.header06) == '' 
    		  && ComGetObjValue(formObj.header07) == '' 
    		  && ComGetObjValue(formObj.header08) == '' 
    		  && ComGetObjValue(formObj.header09) == '' 
    		  && ComGetObjValue(formObj.header10) == '' ){
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
	function initRdConfig(){
//	   var Rdviewer=rdObject ;
//	   Rdviewer.AutoAdjust=false;
//	   Rdviewer.HideStatusBar();
//	   Rdviewer.ViewShowMode(0);
//	   Rdviewer.SetPageLineColor(255,255,255);
//	   Rdviewer.style.height = 0;
//		var hiddenParam = ["save"];
//        Rdviewer.hideToolbarItem(hiddenParam);
//       Rdviewer.ApplyLicense("0.0.0.0"); 
	}
	/**
     * call rd report
     * @return
     */
	function rdOpen(){
//		 var Rdviewer=rdObject ;
    	 var formObj=document.form;
 		 var opener=window.dialogArguments;
		 if (!opener) opener=window.opener;  //이 코드 추가할것
		 if (!opener) opener=parent;               // 기존 가이드 부분
    	 var opnSheetObj = opener.sheet1;
    	 var sheetObj=sheetObjects[1];  // Use for calling Group.
    	 previewByGroup(formObj, opnSheetObj, sheetObj);
	}   		
    /**
     * preview By Demand Group 
     */  
	function previewByGroup(formObj, opnSheetObj, sheetObj){
//		var Rdviewer=rdObject ;
		 //Data Definition
    	makeDataByGroup(formObj, opnSheetObj, sheetObj);
		 // parameter value set passing to rd .(preview/fax/email Used as.)
    	 //faxEmailByGroup(formObj, opnSheetObj, sheetObj);
    	//To screen large numbers of parents get bkg_no manner without the child window by calling the direct parent brings.
		var bkgNos="";
    	var cntrNos="";
  		var chkRows=sheetObjects[0].FindCheckedRow(1).split("|");
  		var usr_cnt_cd  = ComGetObjValue(formObj.usr_cnt_cd);
  		for(var i=0; i < chkRows.length; i++) {
  			bkgNos  += ','+sheetObjects[0].GetCellValue(chkRows[i], "bkg_no");
  			cntrNos += ','+sheetObjects[0].GetCellValue(chkRows[i], "cntr_no");
  		}
  		ComSetObjValue(formObj.bkg_no, 	bkgNos.substring(1));
  		ComSetObjValue(formObj.cntr_no, cntrNos.substring(1));

		var appendReport = [];
  		
  		//rd_fxeml_rd_param setting, using when express rd report.
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
  		 				" [*** " + ComGetObjValue(formObj.title) 					+" ***]" +
  		 				" [" + ComGetObjValue(formObj.ida_expn_tax_rt)	+"]" +
  		 				" [" + ComGetObjValue(formObj.ida_expn_tax)		+"]" +
  		 				" [" + ComGetObjValue(formObj.ida_edu_tax_rt)	+"]" +
  		 				" [" + ComGetObjValue(formObj.ida_edu_tax)			+"]" +
  		 				" [" + ComGetObjValue(formObj.ida_high_edu_tax_rt)	+"]" +
  		 				" [" + ComGetObjValue(formObj.ida_high_edu_tax)		+"]" +
  		 				" [" + ComGetObjValue(formObj.tax_rgst_no)			+"]" +
  		 				" [" + ComGetObjValue(formObj.svc_cate_rmk)			+"]" +
  		 				" [" + ComGetObjValue(formObj.pmnt_acct_no)			+"]" +
  		 				" /rv TAX_NM[" + ComGetObjValue(formObj.tax_nm)				+"]" 
  		 			   ;

  		 //ComSetObjValue(formObj.rd_fxeml_rd_param, 	rdRaram);
  		 ComSetObjValue(formObj.rd_fxeml_rd_param, 	RDServer + rdRaram);
    	 var rdParm=ComGetObjValue(formObj.rd_fxeml_rd_param);
//    	 ComDebug(rdParm);
    	 

    	//RD - Right
 		if(ComGetObjValue(formObj.bil_to_loc_div_cd) == 'R'){
 			var mrdPath = RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/demandnotesend/report/EES_DMT_3904.mrd';
    	} 
 	   	//RD - Left
 	   	else {
 	   		var mrdPath = RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/demandnotesend/report/EES_DMT_3903.mrd';
 	   	}
 		var mrdParam = RDServerIP + " "+ rdParm;
 		appendReport.push({mrdPath:mrdPath,mrdParam:mrdParam});
 		directReportDownload(appendReport);
    	 
    	 //RD - Right
//    	 if(ComGetObjValue(formObj.bil_to_loc_div_cd) == 'R'){
////    		 if (usr_cnt_cd == 'IN') {
////    			 Rdviewer.openFile(RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/demandnotesend/report/EES_DMT_3908.mrd', RDServerIP+" "+ rdParm);
////    		 }else{
//    			 Rdviewer.openFile(RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/demandnotesend/report/EES_DMT_3904.mrd', RDServerIP+" "+ rdParm, {timeout:1800});
////    		 }
//    	 } 
//    	 //RD - Left
//    	 else {
////    		 if (usr_cnt_cd == 'IN') {
////    			 Rdviewer.openFile(RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/demandnotesend/report/EES_DMT_3907.mrd', RDServerIP+" "+ rdParm);
////    		 }else{
//    			 Rdviewer.openFile(RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/demandnotesend/report/EES_DMT_3903.mrd', RDServerIP+" "+ rdParm, {timeout:1800});
////    		 }
//    	 }
//    	 //rd print
//    	 Rdviewer.print({isServerSide:true});
	}
	/**
     * RD for the data call and reset
     */    
	function makeDataByGroup(formObj, opnSheetObj, sheetObj){
//    	ComSetObjValue(formObj.ofc_cd, 					opener.document.form.ofc_cd.value);
//		ComSetObjValue(formObj.dmdt_trf_cd, 			opener.document.form.dmdt_trf_cd.value);
//		ComSetObjValue(formObj.dmdt_chg_sts_cd, 		opener.document.form.dmdt_chg_sts_cds.value);  //code 리스트.
//		ComSetObjValue(formObj.payer_cd, 				opener.document.form.payer_cd.value);
//		ComSetObjValue(formObj.payer_nm, 				opener.document.form.payer_nm.value);
//		ComSetObjValue(formObj.dmdt_payr_cntc_pnt_nm, 	opener.document.form.dmdt_payr_cntc_pnt_nm.value);
//		ComSetObjValue(formObj.payr_cntc_pnt_phn_no, 	opener.document.form.payr_cntc_pnt_phn_no.value);
//		ComSetObjValue(formObj.payr_cntc_pnt_fax_no, 	opener.document.form.payr_cntc_pnt_fax_no.value);
//		ComSetObjValue(formObj.payr_cntc_pnt_eml, 		opener.document.form.payr_cntc_pnt_eml.value);
//		ComSetObjValue(formObj.inv_curr_cd, 			opener.document.form.inv_curr_cd.value);
        //RD on the screen before the call to get the information required of the selected content    	  
//        ComSetObjValue(formObj.tot_bil_amt, 			opener.document.form.tot_bil_amt.value);
//        ComSetObjValue(formObj.tot_tax_amt, 			opener.document.form.tot_tax_amt.value);
//        ComSetObjValue(formObj.tot_payable_amt, 		opener.document.form.tot_payable_amt.value);
//        ComSetObjValue(formObj.tax_rto_dis, 			opener.document.form.tax_rto_dis.value);
		// If the six-digit vendor payer_cd an additional 00. Used only when viewed under.
		ComSetObjValue(formObj.tmp_payer_cd, 	ComGetObjValue(formObj.payer_cd));
		if(ComGetObjValue(formObj.payer_cd).length == 6) {
			ComSetObjValue(formObj.payer_cd, 		"00" + ComGetObjValue(formObj.payer_cd));
		}
		formObj.f_cmd.value=SEARCH01;
         var sXml=sheetObj.GetSearchData("EES_DMT_3007GS.do",	FormQueryString(formObj));
        sheetObj.LoadSearchData(sXml,{Sync:1} );
        //Data received from the server at once, etc passed to form.
        ComEtcDataToForm(formObj, sheetObj);
        // Reset back to its previous value after the query payer_cd.
        ComSetObjValue(formObj.payer_cd, 	ComGetObjValue(formObj.tmp_payer_cd));
        //Value received from the server : address01 : DONGSHIN MARITIME AGENCY CO.,LTD.|SEJONG B/D 100 DANGJOO-DONG, JONGRO-GU, SEOUL, KOREA
        //"|" Is based on the variable back to address01 cust_nm and Resets
   	  	if(!ComIsEmpty ( ComGetObjValue(formObj.address01) )){	
		  var temp=ComGetObjValue(formObj.address01).split("|");
		  ComSetObjValue(formObj.cust_nm,		temp[0]);			
	      ComSetObjValue(formObj.address01, 	temp[1]);	
	  	} else {
	  		  ComSetObjValue(formObj.cust_nm,		"");			
	  		  ComSetObjValue(formObj.address01, 	"");	   	  			
	  	}
   	  	//Enter the address of data values ​​separated by a separator to handle.
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
//	        document.form.address02.value = ComReplaceStr(paryInfoArr[2],"'"," ");
//	        document.form.address03.value = ComReplaceStr(paryInfoArr[2],"'"," ");
//	        document.form.address04.value = ComReplaceStr(paryInfoArr[2],"'"," ");
			document.form.address01.value="";
			document.form.address02.value="";
			document.form.address03.value="";
			document.form.address04.value="";
   	  	}
        //Address end processing.
        //RD flag on the screen, depending on whether the include / exclude known.			     	
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
	function faxEmailByGroup(formObj, opnSheetObj, sheetObj){
     	//To screen large numbers of parents get bkg_no manner without the child window by calling the direct parent brings.
   	  	var bkgNos="";
   	  	var cntrNos="";
 		var chkRows=sheetObjects[0].FindCheckedRow(1).split("|");
 		for(var i=0; i < chkRows.length; i++) {
 			bkgNos  += ','+sheetObjects[0].GetCellValue(chkRows[i], "bkg_no");
 			cntrNos += ','+sheetObjects[0].GetCellValue(chkRows[i], "cntr_no");
 		}
 		ComSetObjValue(formObj.bkg_no, 	bkgNos.substring(1));
 		ComSetObjValue(formObj.cntr_no, cntrNos.substring(1));
 		//expression used when setting rd_fxeml_rd_param rd report.
// 		var rdRaram = "/rsn [jdbc/OPUSCNTR] /rp  [" + ComGetObjValue(formObj.ofc_cd) 				+"]" +
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
 		 			   ;
// 		ComSetObjValue(formObj.rd_fxeml_rd_param, 	rdRaram);
 		ComSetObjValue(formObj.rd_fxeml_rd_param, 	RDServerBAT + rdRaram);
	}     
	function sendFaxEmail(sendType){
      	var formObj=document.form;
		var opener=window.dialogArguments;
		if (!opener) opener=window.opener;  //이 코드 추가할것
		if (!opener) opener=parent;  
 	 	var opnSheetObj=opener.sheet1;
 	 	var sheetObj=sheetObjects[1];  // Using when call Group.
 		//1. Retrieving basic information.
	 	makeDataByGroup(formObj, opnSheetObj, sheetObj);
	    //2.RD DATA for Group
	 	faxEmailByGroup(formObj, opnSheetObj, sheetObj);
	 	//Fax / E-mail settings, basic information.
	 	faxEmaiInfo(formObj, opnSheetObj, sheetObj);
	 	if(ComGetObjValue(formObj.bil_to_loc_div_cd) == 'R'){
			ComSetObjValue(formObj.rd_fxeml_file_name  , 	 "EES_DMT_3904.mrd");
 		} 
 		//RD - Left
 		else {
    		ComSetObjValue(formObj.rd_fxeml_file_name  , 	 "EES_DMT_3903.mrd");
 		}	
  	}	
	function faxEmaiInfo(formObj, opnSheetObj, sheetObj){
 		//EMAIL information
        ComSetObjValue(formObj.rd_fxeml_sys_cd         , 	 "DMT");
 		ComSetObjValue(formObj.rd_fxeml_bat_flg        , 	 "N");
 		ComSetObjValue(formObj.rd_fxeml_title          , 	 "DemDet Statement(Custmer Code: "+ComGetObjValue(formObj.payer_cd)+")");
 		ComSetObjValue(formObj.rd_fxeml_doc_tp		   , 	 "G");
 		ComSetObjValue(formObj.rd_fxeml_fax_no         , 	 "");
 		ComSetObjValue(formObj.rd_fxeml_fax_sndr_id    , 	 "COMPANY");
 		ComSetObjValue(formObj.rd_fxeml_eml_sndr_nm    , 	 "Demurrage / Detention Statement");
 		ComSetObjValue(formObj.rd_fxeml_eml_rcvr_add   , 	 "");
 		ComSetObjValue(formObj.rd_fxeml_eml_atch_file  , 	 ComGetNowInfo("ymd") + "_" + ComGetObjValue(formObj.payer_cd)); //YYYY-MM-DD_payer code (ex: 2010-02-24_KR123456)
 		ComSetObjValue(formObj.rd_fxeml_eml_templt     , 	 "EES_DMT_DEMAND_002.htmlmail"); // Template Location C:/sitectx/OPUSCNTR\APP-INF/config/template/mailtemplate/template.htmlmail
 		ComSetObjValue(formObj.rd_fxeml_eml_tmplt_param, 	 "");
 		ComSetObjValue(formObj.invno					, 	 "DemandNot");
 		ComSetObjValue(formObj.payc						, 	 ComGetObjValue(formObj.payer_cd) );
	}
	///////////////////////////////////////////////////////////////////////////////
    /**
    * Register as an array IBSheet Object
    * The next batch of other items when you need to handle the process can be added to an array that holds
    * Array defined at the top of the source
    */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/** 
	 * Register as an array IBCombo Object
	 * param : combo_obj ==> Combo object
	 * The next batch of other items when you need to handle the process can be added to an array that holds
	 * Array defined at the top of the source
	 */ 
	function setComboObject(combo_obj) {  
		 comboObjects[comboCnt++]=combo_obj;  
	} 
	/**
     * Sheet default settings and initialization
     * Implementation of the body tag's onLoad event handler
     * After loading in your browser should display the ability to add pre-processing
     */
    function loadPage() {
 		/*********************************************
          * Defined as a pop-up calls handled by the Title
          **********************************************/
//        var spanObj = document.getElementById("title");
//    	spanObj.innerText = "  Demand Note Issue - Group";
        for(i=0;i<sheetObjects.length;i++){
        //khlee-Preferences change the name of the function to start
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
        //khlee-The final configuration functions added
            ComEndConfigSheet(sheetObjects[i]);
        }
        // IBMultiCombo initialization
  	    for(var k=0;k<comboObjects.length;k++){
  	        initCombo(comboObjects[k],k+1);
  	    }
        //To screen large numbers of parents get bkg_no manner without the child window by calling the direct parent brings.
		var formObj=document.form;
		var opener=window.dialogArguments;
		if (!opener) opener=window.opener;  //이 코드 추가할것
		if (!opener) opener=parent;  
  	  	var opnSheetObj=opener.sheet1;
  	  	var bkgNos="";
		var chkRows=opnSheetObj.FindCheckedRow(1).split("|");
		for(var i=0; i < chkRows.length; i++) {
			bkgNos += ','+opnSheetObj.GetCellValue(chkRows[i], "bkg_no");
		}
		
		ComSetObjValue(formObj.s_bkg_no, 	bkgNos.substring(1));
		// Far from the parent screen bkg_no get information.
		//Pop-up call from EES_DMT_3013
		//init RD config
		initRdConfig();
        doInit();
        initAxonControl();
		//Fax, e-mail settings, the default value added logic
		//Payer by email, faxno to look up.
		//parameter : payer_cd, ofc_cd  -- Session ofc_cd , dmdt_trf_cd 
		doActionIBCombo(sheetObjects[1], formObj, IBSEARCH, COMMAND02, "", "");
		//Get the code CNT
		doActionIBCombo(sheetObjects[1],document.form,IBSEARCH,COMMAND17,"USR_CNT_CD","");	//2010.04.04.
     }
     /**
 	 * Combo The default setting 
 	 * param : comboObj ==> Combo object, comboNo ==> Combo object ID of the tag attached to the serial number
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
// 					MultiSelect = false;
//					SetColAlign("left|left|left|left");
//					//SetColWidth("|1|1|1|");
//					DropHeight = 160;
					SetMultiSelect(0);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColAlign(2, "left");
					SetColAlign(3, "left");
					//SetColWidth("|1|1|1|");
					SetDropHeight(160);
 					//ValidChar(2,2);		//upper case
 	    		}
 	    		break;
 	     } 		
 	} 	
   /*
    * Pop-up call from EES_DMT_3013
    */
	function doInit() {
    	var sheetObj=sheetObjects[0]; 
  		var formObj=document.form;

  		// Retrieving MAIN List
  		doActionIBSheet(sheetObjects[0], formObj, IBROWSEARCH);
  		//check box - all check 
  		//sheetObj.CheckAll("chk_box") = 1; // 1: all check , 0: all unckeck
  		//OnChange Event does not occur.
  		sheetObj.CheckAll("chk_box",1,1);
  		//Tax Rto Retrieving
 		doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
 		//International monetary-> Depending on the requirements for a complete list of items without using the first.
		searchARCurrencyList();

 		//To calculate Total
 		var tot_bil_amt=0;
 		var tot_tax_amt=0;
 		var tot_payable_amt=0;
 		//Tax AMT, Payable AMT Calculation
 		var inv_tax_rto=parseFloat(ComGetObjValue(formObj.tax_rto));
 		var inv_tax_amt=0;
 		var inv_payable_amt=0;
 		var inv_chg_amt=0;
 		var inv_curr_cd=ComGetObjValue(formObj.inv_curr_cd);
 		var payerCd="";
 		var payerNm="";
 		
 		var tot_ida_expn_tax = 0;
 		var tot_ida_edu_tax = 0;
 		var tot_ida_high_edu_tax = 0;

 		for(var i=2; i < sheetObj.GetTotalRows()+2 ; i++) {
 			if(sheetObj.GetCellValue(i, "chk_box") == 1) {
 				inv_chg_amt=parseFloat(sheetObj.GetCellValue(i, "inv_chg_amt"));
//	 			inv_curr_cd = sheetObj.CellValue(i, "inv_curr_cd");
	 			//2010.04.04.
//	 			if(ComGetObjValue(formObj.usr_cnt_cd) == "VN") {	// in case of Vietnam
//	 				inv_tax_amt=(inv_chg_amt / (1 - inv_tax_rto * 0.01)) * (inv_tax_rto * 0.01);
//	 			}
	 			//=========================================
	 			//2015.10.27 #7995 comment start
	 			/*else if(ComGetObjValue(formObj.usr_cnt_cd) == "IN") {
	 				// 2012.07.12 인도 GST 관련 추가.	 			

	 				var ida_expn_tax_rt     = parseFloat(ComGetObjValue(formObj.ida_expn_tax_rt));
	 				var ida_edu_tax_rt      = parseFloat(ComGetObjValue(formObj.ida_edu_tax_rt));
	 				var ida_high_edu_tax_rt = parseFloat(ComGetObjValue(formObj.ida_high_edu_tax_rt));
	 			    var sts = sheetObj.CellValue(i, "dmdt_chg_sts_cd")
	 				var ida_expn_tax = 0;
	 				var ida_edu_tax = 0;
	 				var ida_high_edu_tax = 0;
	 			    if (sts != "I") {
	 			    	
	  				// Service Tax
	 				 ida_expn_tax = ComRound( (inv_chg_amt * ida_expn_tax_rt * 0.01), 2 )
	  				 sheetObj.CellValue2(i, "ida_expn_tax") = ida_expn_tax;
	 				 
	 				// Education Cess
	  				 ida_edu_tax = ComRound( (ida_expn_tax * ida_edu_tax_rt * 0.01), 2 )
	  				 sheetObj.CellValue2(i, "ida_edu_tax") = ida_edu_tax;
	 				
	 				// Higher Edu Cess
	 				 ida_high_edu_tax = ComRound( (ida_expn_tax * ida_high_edu_tax_rt * 0.01), 2 )
	 				 sheetObj.CellValue2(i, "ida_high_edu_tax") = ida_high_edu_tax;
	 			    }
	 				// Total Service Tax
	 				inv_tax_amt = parseFloat(ida_expn_tax) + parseFloat(ida_edu_tax) + parseFloat(ida_high_edu_tax) ;
	 				inv_tax_rto = "";
	 				
			 		tot_ida_expn_tax = tot_ida_expn_tax  + parseFloat(ida_expn_tax); 
			 		tot_ida_edu_tax = tot_ida_edu_tax  + parseFloat(ida_edu_tax); 
			 		tot_ida_high_edu_tax  = tot_ida_high_edu_tax  + parseFloat(ida_high_edu_tax); 	
	 				
	 			}*/
	 			//2015.10.27 #7995 comment e n d
	 			//=========================================
//	 			else{
	 				inv_tax_amt=(inv_tax_rto * 0.01) * inv_chg_amt;
//	 			}
				tot_bil_amt=tot_bil_amt + parseFloat(inv_chg_amt);
				tot_bil_amt=DMTtrimCurrencyAmount(inv_curr_cd, tot_bil_amt);
				tot_tax_amt=tot_tax_amt + parseFloat(inv_tax_amt);
				tot_tax_amt=DMTtrimCurrencyAmount(inv_curr_cd, tot_tax_amt);
				tot_payable_amt=tot_bil_amt + tot_tax_amt;
				tot_payable_amt=DMTtrimCurrencyAmount(inv_curr_cd, tot_payable_amt);
				//Viewed from the list payer cd data exists only when the first imported.
				if (payerCd == ''){
					payerCd=sheetObj.GetCellValue(i, "payer_cd");
					payerNm=sheetObj.GetCellValue(i, "payer_nm");
				} 
 			}
 		} //end of the for loop
 		ComSetObjValue(formObj.tot_bil_amt, 	ComAddComma2(tot_bil_amt+''		,"#,###.00"));
 		ComSetObjValue(formObj.tot_tax_amt, 	ComAddComma2(tot_tax_amt+''		,"#,###.00"));
 		ComSetObjValue(formObj.tot_payable_amt, ComAddComma2(tot_payable_amt+''	,"#,###.00"));
 		
 		ComSetObjValue(formObj.ida_expn_tax, ComRound(tot_ida_expn_tax,2));
 		ComSetObjValue(formObj.ida_edu_tax,  ComRound(tot_ida_edu_tax,2));
 		ComSetObjValue(formObj.ida_high_edu_tax, ComRound(tot_ida_high_edu_tax,2));
 		
 		//Tax Checked
 		formObj.chk_tax_rto.checked=true;
 		
 		//=========================================
 		//2015.10.27 #7995 comment start
 		/*if (ComGetObjValue(formObj.usr_cnt_cd) == "IN"){ 
 			ComEnableObject(formObj.chk_tax_rto, false);
 			ComSetObjValue(formObj.tax_rto_dis, "");
 		}*/
 		//2015.10.27 #7995 comment e n d
 		//=========================================	
 		
 		//total count = cntr no total number
 		ComSetObjValue(formObj.cntr_qty, sheetObjects[0].GetTotalRows());
 		//If you have a query from the list payer cd johoeham attention List. 
 		if (payerCd != ''){
 			ComSetObjValue(formObj.payer_cd, payerCd);
 			ComSetObjValue(formObj.payer_nm, payerNm);
 			//Attention List that corresponds to Payer
 			searchAttentionList();
 			if (comboObjects[0].GetItemCount() > 0) {
 				//Attention is changed Payer automatically retrieve information, and referrals to automatically select the first item gives.
 				comboObjects[0].SetSelectIndex(0);
 			}
 		}
   	}
    /**
     * Notification checkboxes and buttons to provide a full year whether to activate
     * @param sheetObj
     * @param Row
     * @param Col
     * @param Value
     * @return
     */
 	function sheet1_OnChange (sheetObj, Row, Col, Value) {
		var formObj=document.form;
		var sName=sheetObj.ColSaveName(Col);
		var inv_curr_cd=ComGetObjValue(formObj.inv_curr_cd);
		//Total Calculation
		var tot_bil_amt=0;
		var tot_tax_amt=0;
		var tot_payable_amt=0;
		//Tax AMT, Payable AMT Calculation
		var inv_tax_rto=parseFloat(ComGetObjValue(formObj.tax_rto));
		var inv_tax_amt=0;
		var inv_payable_amt=0;
		var inv_chg_amt=0;
		// 인도 관련 GST 합계.
 		var tot_ida_expn_tax = 0;
 		var tot_ida_edu_tax = 0;
 		var tot_ida_high_edu_tax = 0;
 		var usr_cnt_cd = ComGetObjValue(formObj.usr_cnt_cd);
		
		if(sName == "chk_box") {	//checkbox
			// Select the check box at the start recalculating
			if(Value == 1) {
				inv_chg_amt=parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.tot_bil_amt),"float")) + parseFloat(sheetObj.GetCellValue(Row, "inv_chg_amt"));
				//=========================================
				//2015.10.27 #7995 comment start
				/*if (usr_cnt_cd == "IN"){
					tot_ida_expn_tax = parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.ida_expn_tax),"float")) + parseFloat(sheetObj.CellValue(Row, "ida_expn_tax"));
					tot_ida_edu_tax = parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.ida_edu_tax),"float")) + parseFloat(sheetObj.CellValue(Row, "ida_edu_tax"));
					tot_ida_high_edu_tax = parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.ida_high_edu_tax),"float")) + parseFloat(sheetObj.CellValue(Row, "ida_high_edu_tax"));
				}*/
				//2015.10.27 #7995 comment e n d
				//=========================================
			} else if(Value == 0) {
				inv_chg_amt=parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.tot_bil_amt),"float")) - parseFloat(sheetObj.GetCellValue(Row, "inv_chg_amt"));
				//=========================================
				//2015.10.27 #7995 comment start
				/*if (usr_cnt_cd == "IN"){
					tot_ida_expn_tax = parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.ida_expn_tax),"float")) - parseFloat(sheetObj.CellValue(Row, "ida_expn_tax"));
					tot_ida_edu_tax = parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.ida_edu_tax),"float")) - parseFloat(sheetObj.CellValue(Row, "ida_edu_tax"));
					tot_ida_high_edu_tax = parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.ida_high_edu_tax),"float")) - parseFloat(sheetObj.CellValue(Row, "ida_high_edu_tax"));
				}*/
				//2015.10.27 #7995 comment e n d
				//=========================================
			}
			//Select chk_tax_rto applies only.
			if(formObj.chk_tax_rto.checked){
				//2010.04.04.
//	 			if(usr_cnt_cd == "VN") {	// in case of Vietnam
//	 				inv_tax_amt=(inv_chg_amt / (1 - inv_tax_rto * 0.01)) * (inv_tax_rto * 0.01);
//	 			}
	 			//=========================================
	 			//2015.10.27 #7995 comment start
	 			/*else if(usr_cnt_cd == "IN") {
	 				 inv_tax_amt = tot_ida_expn_tax + tot_ida_edu_tax + tot_ida_high_edu_tax
	 			}*/
	 			//2015.10.27 #7995 comment e n d
	 			//=========================================	
//	 			else{
	 				inv_tax_amt=(inv_tax_rto * 0.01) * inv_chg_amt;
//	 			}
			}
			tot_bil_amt=tot_bil_amt + parseFloat(inv_chg_amt);
			tot_bil_amt=DMTtrimCurrencyAmount(inv_curr_cd, tot_bil_amt);
			tot_tax_amt=tot_tax_amt + parseFloat(inv_tax_amt);
			tot_tax_amt=DMTtrimCurrencyAmount(inv_curr_cd, tot_tax_amt);
			tot_payable_amt=tot_bil_amt + tot_tax_amt;
			tot_payable_amt=DMTtrimCurrencyAmount(inv_curr_cd, tot_payable_amt);
			ComSetObjValue(formObj.tot_bil_amt, 	ComAddComma2(tot_bil_amt+''		,"#,###.00"));
	 		ComSetObjValue(formObj.tot_tax_amt, 	ComAddComma2(tot_tax_amt+''		,"#,###.00"));
	 		ComSetObjValue(formObj.tot_payable_amt, ComAddComma2(tot_payable_amt+''	,"#,###.00"));
	 		
	 		ComSetObjValue(formObj.ida_expn_tax, ComRound(tot_ida_expn_tax,2));
	 		ComSetObjValue(formObj.ida_edu_tax,  ComRound(tot_ida_edu_tax,2));
	 		ComSetObjValue(formObj.ida_high_edu_tax, ComRound(tot_ida_high_edu_tax,2));
	 		
			// Recalculation check box is selected exit
			var iCnt=0;
			for(var i=2; i < sheetObj.GetTotalRows()+2; i++) {
				if(sheetObj.GetCellValue(i,"chk_box") == 1) {
					iCnt++;
				}
			}
			ComSetObjValue(formObj.cntr_qty, iCnt);
			//CHECK BOX if you disable all alert & button disabled
			if(iCnt == 0){
				ComShowCodeMessage('DMT00164');
				DmtComEnableManyBtns(true,  "btn_set", "btn_option", "btn_close");
				DmtComEnableManyBtns(false, "btn_update", "btn_preview", "btn_print", "btn_fax", "btn_email", "btn_payerfaxemail", "btn_detail", "btn_down_excel");
			} else {
				DmtComEnableManyBtns(true,  "btn_set", "btn_option", "btn_close");
				DmtComEnableManyBtns(true,  "btn_update", "btn_preview", "btn_print", "btn_fax", "btn_email", "btn_payerfaxemail", "btn_detail", "btn_down_excel");
			}
		} //end of the check box
	}
   	/**
 	 * Tax Rate check
 	 */
 	function setTax(){
 		var formObj=document.form;
 		if(formObj.chk_tax_rto.checked) {
 			ComSetObjValue(formObj.tax_rto_dis, ComGetObjValue(formObj.tax_rto));
 		}else{
 			
 			//=========================================
 			//2015.10.27 #7995 comment start
 			/*if(ComGetObjValue(formObj.usr_cnt_cd)=="IN"){
				 ComSetObjValue(formObj.tax_rto_dis, "");	
			}else{
 			  ComSetObjValue(formObj.tax_rto_dis, "0");
			}*/
 			ComSetObjValue(formObj.tax_rto_dis, "0");
 			//2015.10.27 #7995 comment e n d
 			//=========================================	
 			
 		}
 		//Recalculation
		var inv_curr_cd=ComGetObjValue(formObj.inv_curr_cd);
		//Total calculation
		var tot_bil_amt=0;
		var tot_tax_amt=0;
		var tot_payable_amt=0;
		//Tax AMT, Payable AMT calculation
		var inv_tax_rto=parseFloat(ComGetObjValue(formObj.tax_rto));
		var inv_tax_amt=0;
		var inv_payable_amt=0;
		var inv_chg_amt=0;
 		inv_chg_amt=parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.tot_bil_amt),"float"));
 		//Select chk_tax_rto applies only.
 		if(formObj.chk_tax_rto.checked){
  			//2010.04.04.
//  			if(ComGetObjValue(formObj.usr_cnt_cd) == "VN") {	//in case of Vietnam	
//  				inv_tax_amt=(inv_chg_amt / (1 - inv_tax_rto * 0.01)) * (inv_tax_rto * 0.01);
//  			}
	  		//=========================================
	  		//2015.10.27 #7995 comment start
  			/*else if(ComGetObjValue(formObj.usr_cnt_cd) == "IN") {   // India
  				inv_tax_amt = parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.tot_tax_amt),"float"));
  			}*/
	  		//2015.10.27 #7995 comment e n d
	  		//=========================================
//  			else{
  				inv_tax_amt=(inv_tax_rto * 0.01) * inv_chg_amt;
//  			}
 		}
 		tot_bil_amt=tot_bil_amt + parseFloat(inv_chg_amt);
 		tot_bil_amt=DMTtrimCurrencyAmount(inv_curr_cd, tot_bil_amt);
 		tot_tax_amt=tot_tax_amt + parseFloat(inv_tax_amt);
 		tot_tax_amt=DMTtrimCurrencyAmount(inv_curr_cd, tot_tax_amt);
 		tot_payable_amt=tot_bil_amt + tot_tax_amt;
 		tot_payable_amt=DMTtrimCurrencyAmount(inv_curr_cd, tot_payable_amt);
 		ComSetObjValue(formObj.tot_bil_amt, 	ComAddComma2(tot_bil_amt+''		,"#,###.00"));
  		ComSetObjValue(formObj.tot_tax_amt, 	ComAddComma2(tot_tax_amt+''		,"#,###.00"));
  		ComSetObjValue(formObj.tot_payable_amt, ComAddComma2(tot_payable_amt+''	,"#,###.00"));
 	}  	    
    function setComma(){
     	var formObj=document.form;
 		//Charge 3-digit comma
 		var tot_bil_amt=ComAddComma2(ComRound(ComGetObjValue(formObj.tot_bil_amt), 2)+''		,"#,###.00");
 		var tot_tax_amt=ComAddComma2(ComRound(ComGetObjValue(formObj.tot_tax_amt), 2)+''		,"#,###.00");
 		var tot_payable_amt=ComAddComma2(ComRound(ComGetObjValue(formObj.tot_payable_amt), 2)+''	,"#,###.00");
 		ComSetObjValue(formObj.tot_bil_amt, 	tot_bil_amt);
 		ComSetObjValue(formObj.tot_tax_amt, 	tot_tax_amt);
 		ComSetObjValue(formObj.tot_payable_amt, tot_payable_amt);
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
		              var HeadTitle1=" ||Seq.|BKG No.|B/L No.|STS|CNTR No.|T/S|Staying Period|Staying Period|Free Time|Free Time|rd_date1|rd_date2|rd_date3|rd_date4|F/T|Over|Invoice|Invoice|Charge|Charge|Charge|Charge|Charge|Ex.Rate|VVD CD|Office|From YD|BKG DEL|Tariff|S/C No.|RFA No.";
		              HeadTitle1 += "|Payer|Payer|Shipper|Shipper|Consignee|Consignee|Notify|Notify|A/R Actual Payer|A/R Actual Payer|Service Provider|Service Provider";
		              HeadTitle1 += "|svrId|cntrCycNo|dmdtChgLocDivCd|dmdtInvNo|VslCd|SkdVoyNo|SkdDirCd|PolCd|PodCd|loc|ida_expn_tax|ida_edu_tax|ida_high_edu_tax";
		              var HeadTitle2=" ||Seq.|BKG No.|B/L No.|STS|CNTR No.|T/S|From Date|To Date|F/T CMNC|F/T End|rd_date1|rd_date2|rd_date3|rd_date4|F/T|Over|Cur.|Billing AMT|Cur.|Incurred AMT|Exception AMT|D/C AMT|Billable AMT|Ex.Rate|VVD CD|Office|From YD|BKG DEL|Tariff|S/C No.|RFA No.";
		              HeadTitle2 += "|Code|Name|Code|Name|Code|Name|Code|Name|Code|Name|Code|Name";
		              HeadTitle2 += "|svrId|cntrCycNo|dmdtChgLocDivCd|dmdtInvNo|VslCd|SkdVoyNo|SkdDirCd|PolCd|PodCd|loc|ida_expn_tax|ida_edu_tax|ida_high_edu_tax";
		              var headCount1=ComCountHeadTitle(HeadTitle1);
		              var headCount2=ComCountHeadTitle(HeadTitle2);
		              (headCount1, 0, 0, true);
		             // SetConfig( { SearchMode:2, FrozenCol:savenamecol("dmdt_chg_sts_cd"), MergeSheet:5, Page:20, DataRowMerge:1 } );
		              SetConfig( { SearchMode:2, FrozenCol:5, MergeSheet:5, Page:20, DataRowMerge:1 } );
		              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"Status",  Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			                     {Type:"CheckBox",  Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk_box" },
			                     {Type:"Seq",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_chg_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"fm_mvmt_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"to_mvmt_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ft_cmnc_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ft_end_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"fm_mvmt_dt_rd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"to_mvmt_dt_rd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ft_cmnc_dt_rd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ft_end_dt_rd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ft_dys",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"fx_ft_ovr_dys",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"inv_curr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"inv_chg_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"org_curr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"org_chg_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"expt_amt",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"dc_amt",               KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"bil_amt",              KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"inv_xch_rt",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:6,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"fm_mvmt_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"port",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_trf_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sc_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rfa_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"payer_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"payer_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"shipper_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"shipper_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cnee_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"cnee_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ntfy_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"ntfy_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ar_act_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"ar_act_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"svc_provdr_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"svc_provdr_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"svr_id",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_cyc_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_chg_loc_div_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_inv_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"loc",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     
			                     {Type:"Text",      Hidden:1,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"ida_expn_tax",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
   			                     {Type:"Text",      Hidden:1,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"ida_edu_tax",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:1,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"ida_high_edu_tax",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		               
		              InitColumns(cols);
		              SetEditable(1);
		              SetEllipsis(1);//Whenthecharactersoutsidetherangerepresentedbyanellipsis.
		              SetSheetHeight(360);
		              FrozenCols=SaveNameCol("dmdt_chg_sts_cd");
              }


            	break;         	
        }
    }
	function initAxonControl() {
		axon_event.addListenerFormat('focus',	'obj_focus',	form); //- focus in
		axon_event.addListenerFormat('blur',	'obj_blur',		form); //- focus out
	}     
    /**
    * HTML Control Foucs in
    */
	function obj_focus(){
       ComClearSeparator(event.srcElement);
	}		
    //focus out
	function obj_blur(){
   	//Input Validation to check +Inserting separator mask
		var obj=event.srcElement;
		if(obj.name == 'payer_cd') {
			doActionText(sheetObjects[0], document.form, obj, SEARCH20);
		}else{
			ComChkObjValid(obj);
		}
	}          
	// Sheet processing-related processes
	function doActionIBSheet(sheetObj, formObj, sAction) {
    	sheetObj.ShowDebugMsg(false);
        switch(sAction) {
         	case IBSEARCH:      //TAX retrieving
         		if (sheetObj.id == "sheet2") {	//Tax Rto retrieving
         			//ComOpenWait Start
 					sheetObj.SetWaitImageVisible(0);
 		        	ComOpenWait(true);
 		        	setParameters(SEARCH);
 					if (validateForm(sheetObj,formObj,sAction)) {
 						//used as a session ofc_cd.
 						//ofc_cd sheet option that corresponds to the tax in a temporary variable to query Overrides.
 						//variables used : ofc_cd 
 						//actual data: session office code is used as.
 						ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.session_ofc_cd));
  						var sXml=sheetObj.GetSearchData("EES_DMT_4013GS.do", FormQueryString(formObj));
 						var tax_rto=ComGetEtcData(sXml, "TAX_RTO");
 						ComSetObjValue(formObj.tax_rto, tax_rto);
 						ComSetObjValue(formObj.tax_rto_dis, tax_rto);
 						//Views of the financial variables and redefinition :which contains the charge office code chrg_ofc_cd temp variable star.
 						ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.chrg_ofc_cd))
 					}
 					//ComOpenWait End
					ComOpenWait(false);
 				}
			break;
			
         	case IBROWSEARCH:     // MAIN retrieving
         		//ComOpenWait Start
				sheetObj.SetWaitImageVisible(0);
	        	ComOpenWait(true);
         		setParameters(SEARCH01);
          		
				//조회를 동기방식으로 전환함. 2014.08.25
				//sheetObj.DoSearch("EES_DMT_3108GS.do", FormQueryString(formObj));
				var sXml = sheetObj.GetSearchData("EES_DMT_3108GS.do ", FormQueryString(formObj));
				if (sXml != "") sheetObj.LoadSearchData(sXml,{Sync:1});         		
         		
         		//ComOpenWait End
				ComOpenWait(false);
			break;
			
         	 case IBSEARCH_ASYNC05:      //retrieving
         	 	 //ComOpenWait Start
				 sheetObj.SetWaitImageVisible(0);
	        	 ComOpenWait(true);
	        	 formObj.f_cmd.value=SEARCH05;
 				 
	        	 //조회를 동기방식으로 전환함. 2014.08.25
	        	 //sheetObjects[1].DoSearch("DMTCommonFaxEmailGS.do", FormQueryString(formObj));
				 var sXml = sheetObjects[1].GetSearchData("DMTCommonFaxEmailGS.do ", FormQueryString(formObj));
				 if (sXml != "") sheetObj.LoadSearchData(sXml,{Sync:1});   				 
 				 
				 //ComOpenWait End
				 ComOpenWait(false);
	         break;
	         
	         case IBSEARCH_ASYNC06:      //retrieving
	         	 //ComOpenWait Start
			 	 sheetObj.SetWaitImageVisible(0);
        	     ComOpenWait(true);
        	     formObj.f_cmd.value=SEARCH06;
        	     
        	     //조회를 동기방식으로 전환함. 2014.08.25
        	     //sheetObjects[1].DoSearch("DMTCommonFaxEmailGS.do", FormQueryString(formObj));
 				 var sXml = sheetObjects[1].GetSearchData("DMTCommonFaxEmailGS.do ", FormQueryString(formObj));
				 if (sXml != "") sheetObj.LoadSearchData(sXml,{Sync:1});   	
				
				 //ComOpenWait End
				 ComOpenWait(false);
             break;				
        }
	}
	//save name lookup plus the port in accordance with the result that under the title changed to . 
    function sheet1_OnSearchEnd(sheetObj, code,  ErrMsg) {
		with(sheetObj) {
			var formObj=document.form;
    		var dmdtTrfCd=formObj.dmdt_trf_cd.value;
    		if(!ComIsEmpty(dmdtTrfCd)){
    		    //Outbound in the case of tariff type code
    			if(dmdtTrfCd.substr(2,1) == 'O'){
    				SetCellValue(0, "port","BKG POR");
        			SetCellValue(1, "port","BKG POR");
    			} else {
    			//Inbound in the case of tariff type code 
    				SetCellValue(0, "port","BKG DEL");
        			SetCellValue(1, "port","BKG DEL");
    			}
    		} else {
    			//default
    			SetCellValue(0, "port","BKG POR");
    			SetCellValue(1, "port","BKG POR");
    		}
		}
	}
    function sheet1_OnClick(sheetObj, row, col, Value){
        if(sheetObj.ColSaveName(col) == "chk_box")
        	ComSyncAllCheck(sheetObj, col, Value);
    }	
 	/*
	 * Lookup fields to enter information on the screen is stored in a lookup field values​​.
	 */		
	function setParameters(sAction) {
		var formObj=document.form;
		//Retrieve Setting
		ComSetObjValue(formObj.f_cmd, sAction);							//Command
	}
   	//Combo lookup data lookup field conditions
	function doActionIBCombo(sheetObj,formObj,sAction,sComboAction,sComboKey,sObj) {
 		sheetObj.ShowDebugMsg(false);
 		sheetObj.SetWaitImageVisible(0);
 		switch(sAction) {
 			case IBSEARCH:      // retrieving
 				if (sheetObj.id == "sheet2") {
  					//3.After processing query results
  					var comboDatas;
  					var comboItems;
  					switch(sComboAction) {
  						//1. ATTENTION LIST
  						case SEARCHLIST03:
  							//0. replacement value of the session ofc_cd.
							ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.session_ofc_cd));
  		  					//1. Enter all or selected query parameter set allows.
  		  					setComboParameters(sComboAction, sObj);
  		  					//2. Viewed as a query is run conditions				
   		  					var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
  							comboItems=ComGetEtcData(sXml, sComboKey).split(ROWMARK);
  							//comboObjects[0].Code = "-1";
  							comboObjects[0].RemoveAll();
  							addComboItem1(sObj,comboItems);
  						    //3. Again after redefining a variable lookup :which contains the charge office code chrg_ofc_cd temp variable star.
	 						ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.chrg_ofc_cd))
  							break;							
  						//3-1.Lookup Currency
  						//Imported items only currency in the first..DMD_ORGANIZATION see table.
  						case SEARCHLIST05:
  		  					//1.Enter all or selected query parameter set allows.
  		  					setComboParameters(sComboAction, sObj);
  		  					//2.Viewed as a query is run conditions				
   		  					var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
  							comboDatas=ComGetEtcData(sXml, sComboKey);
  							var invCurrCd="";
  							if (comboDatas != undefined) {
  								comboItems=comboDatas.split(ROWMARK);	
  						 	    for (var i=0 ; i < comboItems.length ; i++) {
  						     		comboItem=comboItems[i].split(FIELDMARK);
  						 			if(i == 0){
  						 				invCurrCd=comboItem[0];
  						     		}
  						 		}   
  							}
  							ComSetObjValue(formObj.inv_curr_cd, invCurrCd);
	  						break;	
					    // Email, FAX number by Payer is viewed.
						case COMMAND02:
							//1.Enter all or selected query parameter set allows.
							setComboParameters(sComboAction, sObj);
							//2. replacement value of the session ofc_cd.
							ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.session_ofc_cd));
							//2.Viewed as a query is run conditions				
 							var sXml=sheetObj.GetSearchData("EES_DMT_4002GS.do", FormQueryString(formObj));
							//3.After processing query results
							ComSetObjValue(formObj.payr_faxnos, 	ComGetEtcData(sXml, "FAX_NO"));
							ComSetObjValue(formObj.payr_emailnos, 	ComGetEtcData(sXml, "EMAIL_NO"));
							//4. Again after redefining a variable lookup :which contains the charge office code chrg_ofc_cd variable temp.
	 						ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.chrg_ofc_cd))
							break;
						//CNT retrieving		2010.04.04.
						case COMMAND17:
							ComSetObjValue(formObj.f_cmd, COMMAND17);
							//2.Viewed as a query is run conditions					
 							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							//3.After processing query results
							ComSetObjValue(formObj.usr_cnt_cd, 	ComGetEtcData(sXml, "USR_CNT_CD"));
							break;	 						
  					} //end of the switch(sComboAction) 
  				};
                break;
 		}
 		sheetObj.SetWaitImageVisible(1);
	}     
    function setComboParameters(sComboAction, sObj) {
    	var formObj=document.form;
    	ComSetObjValue(formObj.curr_cd, ComGetObjValue(formObj.inv_curr_cd));//inv_curr_cd
    	ComSetObjValue(formObj.f_cmd, sComboAction);
    }	
     /**
      * Data in the field adds a combo.
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
      * Data in the field adds a combo.
      */	
 	function addComboItem1(comboObj, comboItems) {
     	for (var i=0 ; i < comboItems.length ; i++) {
     		var comboItem=comboItems[i].split(FIELDMARK);
 			comboObj.InsertItem(i, comboItem[0]+"|"+comboItem[1]+"|"+comboItem[2]+"|"+comboItem[3], comboItem[4]);		
 			//comboObj.SetColWidth("150|1|1|1");
     	}   
 	}     
    //Payer check
	function doActionText(sheetObj, formObj, object, formCmd) {
		sheetObj.ShowDebugMsg(false);
		sheetObj.SetWaitImageVisible(0);
	    //Payer check
		//cust_cd
		ComSetObjValue(formObj.s_cust_cd, ComGetObjValue(formObj.payer_cd));
		var cust_len=parseInt(ComGetLenByByte(ComGetObjValue(formObj.s_cust_cd)));
		if(cust_len == 0){
			ComSetObjValue(formObj.s_cust_gubun, "");
			ComSetObjValue(formObj.s_cust_cd, "");
			ComSetObjValue(formObj.payer_cd, "");
			ComSetObjValue(formObj.payer_nm, "");
			//attention  reset
			attentionReset();
			return;
		}
		//var cre_cnt_cd = ComGetObjValue(formObj.session_cnt_cd);
		var cre_cnt_cd=ComGetObjValue(formObj.usr_cnt_cd);	//2010.04.04.
		//Americas : customer + vendor 
		if(cre_cnt_cd == "CA" || cre_cnt_cd == "US"){
			if(cust_len > 2) {
				var char_chk=ComGetObjValue(formObj.s_cust_cd).substring(0,2);
				//If the CUSTOMER is a two-digit alphanumeric views
				if(ComIsAlphabet(char_chk)) {
					ComSetObjValue(formObj.s_cust_gubun, "2");
				//VENDOR or query
				}else{
					//Detention should be the service provider can only
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
				//Detention should be the service provider can only
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
			// Other Americas : customer applies only ( vendor except for error handling) 
			if(cust_len > 2) {
				var char_chk=ComGetObjValue(formObj.s_cust_cd).substring(0,2);
				//If the CUSTOMER is a two-digit alphanumeric views
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
			//attention  reset
			attentionReset();
			ComShowCodeMessage("DMT00165", "Payer");
			ComSetFocus(formObj.payer_cd);
		}else{
			ComSetObjValue(formObj.payer_cd, cust_cd);
			ComSetObjValue(formObj.payer_nm, cust_nm);
			searchAttentionList();
			if (comboObjects[0].GetItemCount() > 0) {
				//Attention is changed Payer automatically retrieve information, and referrals to automatically select the first item gives.
				comboObjects[0].SetSelectIndex(0);
			}
			//Fax, e-mail settings, the default value added logic 
			//Payer by email, faxno to look up.
			//parameter : payer_cd, ofc_cd  -- session ofc_cd , dmdt_trf_cd 
			doActionIBCombo(sheetObjects[1], formObj, IBSEARCH, COMMAND02, "", "");
		}
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
 	/**
 	 * Functions to query AR Currency
     */	
	function searchARCurrencyList() {
		var sheetObj=sheetObjects[1];
		var formObj=document.form;
		doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCHLIST05,"AR_CURRENCY");
	}
 	/**
     * Attention to lookup function
     */	
	function searchAttentionList() {
 		//Attention Combo
 		setPayerCd();
 		var sheetObj=sheetObjects[1];
 		var comboObj=comboObjects[0];
 		var formObj=document.form;
 		//payer code when you do not exist
		if(ComGetObjValue(formObj.payer_cd) == null || ComGetObjValue(formObj.payer_cd) == "") {
			comboObj.RemoveAll();
			return;
		}
 		doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCHLIST03,"ATTENTION", comboObj);
 	}
    /**
     * Attention Combo Payer Code for query
     * @return
     */
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
  	/**
     * Screen input form validation process for handling
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
    		switch(sAction) {
    		}
        }
        return true;
    }  	
  	/*
	 * Each common pop-up function calls 
	 */
	function openPopup(flag, arg) {
		var sheetObj=sheetObjects[0];
		var formObj=document.form;
		var sUrl='';
		var sWidth='';
		var sHeight='';
		with(sheetObj) {
	  		switch(flag) {
	  			case 's_cust_cd':		// Customer Inquiry Popup
					ComOpenPopup('COM_ENS_041.do', 770, 445, "getCustCd", "1,0,1,1,1,1,1", true);
					break;
	  		} // switch-end
		} // with-end
	}
      /*
    	 * Customer Code Customer common values ​​selected in the pop-up settings in the appropriate fields 
    	 */
      function getCustCd(aryPopupData) {
      	document.form.payer_cd.value=aryPopupData[0][3];
      	document.form.payer_nm.value=aryPopupData[0][4];
      	//Attention 
    	searchAttentionList();
		if (comboObjects[0].GetItemCount() > 0) {
			//Attention is changed Payer automatically retrieve information, and referrals to automatically select the first item gives.
			comboObjects[0].SetSelectIndex(0);
		}
		//Fax, e-mail settings, the default value added logic 
		//Payer by email, faxno to look up.
		//parameter : payer_cd, ofc_cd  -- session ofc_cd , dmdt_trf_cd 
		var formObj=document.form;
		doActionIBCombo(sheetObjects[1], formObj, IBSEARCH, COMMAND02, "", "");
      }  
   	/**
   	 * EES_DMT_3109, EES_DMT_3108 Pop-up call
   	 * @param sheetObj
   	 * @param formObj
   	 * @param srcName
   	 * @return
   	 */
	function openPopupWindow(sheetObj, formObj, srcName) {
   		if (srcName == "btn_set") {
   			var url="EES_DMT_4101.do"
   				+"?issoff="+ComGetObjValue(formObj.ofc_cd)
   				+"&tftp2="+ComGetObjValue(formObj.s_dmdt_trf_cd)
 				+"&sheetp=G"
 				+"&invoice_issue=1"
   				+"&jspno=EES_DMT_3108";
			var sWidht  = "725";
			var sHeight = "550";
   			ComOpenWindowCenter(url, "EES_DMT_4101", sWidht, sHeight, true, "yes");
   		} 
   		else if (srcName == "btn_option") {
   			var url="EES_DMT_4103.do"
   				+"?issoff="+ComGetObjValue(formObj.ofc_cd)
   				+"&tftp="+ComGetObjValue(formObj.s_dmdt_trf_cd)
   				+"&invoice_issue=1"
   				+"&jspno=EES_DMT_3108";
			var sWidht  = "625";
			var sHeight = "680";   			
   			ComOpenWindowCenter(url, "EES_DMT_4103", sWidht, sHeight, true);
   		} 
   		else if (srcName == "btn_payerfaxemail") {
			var url="EES_DMT_4104.do"
				+"?s_ofc_cd="+ComGetObjValue(formObj.session_ofc_cd)
				+"&s_cust_cd="+ComGetObjValue(formObj.payer_cd)
				+"&s_bkg_no="//+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "bkg_no") //ComGetObjValue(formObj.bkg_no)
				+"&s_pod_cd="//+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "pod_cd")
				+"&jspno=EES_DMT_3108"
				+"&attn="+ComGetObjValue(formObj.dmdt_payr_cntc_pnt_nm)
				+"&telno="+ComGetObjValue(formObj.payr_cntc_pnt_phn_no)
				+"&faxno="+ComGetObjValue(formObj.payr_cntc_pnt_fax_no)
				+"&email="+ComGetObjValue(formObj.payr_cntc_pnt_eml)
			var sWidht  = "825";
			var sHeight = "580"; 	
			ComOpenWindowCenter(url, "EES_DMT_4104", sWidht, sHeight, true);
		} 
   		else if(srcName == "btn_sendinghistory") {
			var url="EES_DMT_7006_P.do"
				+"?jspno=EES_DMT_3108"
				+"&payerCd="+ComGetObjValue(formObj.payer_cd)
				+"&selectType=G"
				+"&selectOpt=2"
				;
			var sWidht  = "1036";
			var sHeight = "650";
			ComOpenWindowCenter(url, "EES_DMT_7006_P", sWidht, sHeight, false);
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
				+"&jspno=3108"
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
				+"&jspno=3108"
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
/////////////////////////////////////////////////////////////////////////////////////
  	/**
  	 * SheetOption pop-up screen automatically changes the processing logic in the change(Due Date, Credit Term, Tax Rate)
  	 */
  	function getSheetOptionData(cr_term_dys, is_dt_prn_flg, tax_rto) {
  		var formObj=document.form;
  		var usr_cnt_cd  = ComGetObjValue(formObj.usr_cnt_cd);
  		if(tax_rto == null || tax_rto == "") {
	  		//=========================================
	  		//2015.10.27 #7995 comment start
  			/*if(usr_cnt_cd =="IN"){
  				tax_rto = "";
  			}else{
  			    tax_rto = "0";
  			}*/
  			tax_rto = "0";
	  		//2015.10.27 #7995 comment e n d
	  		//=========================================
  		}
  		//tax_rto
  		ComSetObjValue(formObj.tax_rto, tax_rto);
  		//tax Calculation logic
  		setTax();
  	}  
	/**
	 * PayerInfo on the pop-up screen to change automatically when the change process
	 */
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
	/* developers work end */
