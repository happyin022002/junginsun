/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_3007.js
*@FileTitle : Demand Note Issue Preview
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.10.07 최성환
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
	/**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author 한진해운
     */

	/**
     * @extends 
     * @class EES_DMT_3007 : EES_DMT_3007 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
	function EES_DMT_3007() {
		this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/
	// 공통전역변수

	var sheetObjects = new Array();
	var sheetCnt = 0;
	
    var rdObjects = new Array();
    var rdCnt = 0;


	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         
         var sheetObject1 = sheetObjects[0];
         
         var rdObject = rdObjects[0];
         
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

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
				        //Payer Code, INV Cur. 정보가 없을 경우 “Pls update Payer code first!” Alert창 띄우며 막음
						var payerCd = ComGetObjValue(formObject.payer_cd);
						if(payerCd == ''){
							ComShowCodeMessage('DMT00182');
							ComSetFocus(formObject.payer_cd);
							return;
						} else {
							rdObjects[0].PrintDialog();
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
						//Payer Code, INV Cur. 정보가 없을 경우 “Pls update Payer code first!” Alert창 띄우며 막음
						var payerCd = ComGetObjValue(formObject.payer_cd);
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
					window.close();
					break;
            } // end switch
    	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowMessage(OBJECT_ERROR);
     		} else {
     			ComShowMessage(e);
     		}
    	}
    }

    
    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
	function setSheetObject(sheet_obj){

       sheetObjects[sheetCnt++] = sheet_obj;

    }
	
     /**
      * Sheet 기본 설정 및 초기화
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      */
	function loadPage() {
    	  for(i=0;i<sheetObjects.length;i++){
    		  ComConfigSheet (sheetObjects[i] );
			  initSheet(sheetObjects[i],i+1);
			  ComEndConfigSheet(sheetObjects[i]);
    	  }
    	  //init RD config
    	  
    	  initRdConfig(rdObjects[0]);
    	  rdOpen();
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
		var Rdviewer = rdObject ;
 		Rdviewer.AutoAdjust = true;
 		Rdviewer.HideStatusbar();
 		Rdviewer.ViewShowMode(0);
 		Rdviewer.SetPageLineColor(255,255,255);
 		
 		Rdviewer.DisableToolbar (0);
        Rdviewer.DisableToolbar (13);
        Rdviewer.DisableToolbar (14);
        Rdviewer.DisableToolbar (15);
        Rdviewer.DisableToolbar (16);
        Rdviewer.DisableToolbar (17);
  
	}

    /**
     * call rd report
     * @param rdObject
     * @return
     */
	function rdOpen(){
    	 var formObj = document.form;
    	 var opener = window.dialogArguments;
    	 var opnSheetObj = opener.document.sheet1;
    	 var sheetObj = sheetObjects[0];  // Group 호출 시 사용.
    	 var sheetObj2 = sheetObjects[1]; // Booking 호출시 사용.
    	 // call 한 대상이 어디에서 왔는지 확인 후 처리
    	 // ex)call_to_rd_tp = "booking" or call_to_rd_tp = "group"
    	 // 1. group - 3108, booking - 3109 
    	 ComSetObjValue(formObj.call_to_rd_tp, opener.document.form.call_to_rd_tp.value);
    	 
    	 if (ComGetObjValue(formObj.call_to_rd_tp) == 'group') {
    		 previewByGroup(formObj, opener, opnSheetObj, sheetObj);
    	 } 
    	 else {
    		 //1.RD 기본 데이터를 정보
    		 makeDataByBooking(formObj, opener, opnSheetObj, sheetObj2);

    		 //3.rv param
    		 var rdParm = " /ruseurlmoniker [0] /rv " + rvParmByBooking(formObj) + " /rfn [" + RDServerIP + "/EES_DMT_3007_RD.do] /rpost [" + opener.sheetObjects[0].GetSaveString(false, true, "checkBox") + "]";

    		 var usrCntCd = ComGetObjValue(formObj.rd_usr_cnt_cd);  
    		 var locDivCd = ComGetObjValue(formObj.bil_to_loc_div_cd);
    		 var path = DmtComGetRdFileNm("D", "N", usrCntCd, locDivCd);
    		 
    		 rdObjects[0].FileOpen(RD_path+path, rdParm);
    	 }
	}   
    /**
     * rv By Demand Booking 
     */ 
    function rvParmByBooking(formObj){
   		var formObj = document.form;
  		var opener = window.dialogArguments; // MODAL창에서 부모창 javascript호출
 	 	
    	var	rvRaram =" OFC_ADD01[" + ComGetObjValue(formObj.ofc_add01)					+"]" +	
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
					" HJS_REF[" + ComGetObjValue(formObj.hjs_ref) 						+"]" +
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
					" EX_RATE[" + ComGetObjValue(formObj.ex_rate) 						+"]" +
					" CAL_SUB_TOTAL[" + ComGetObjValue(formObj.tot_amt) 				+"]" +
					" DC_AMOUNT[" + ComGetObjValue(formObj.dc_amt) 						+"]" +
					" NET_AMOUNT[" + ComGetObjValue(formObj.inv_chg_amt) 				+"]" +
					" TAX[" + ComGetObjValue(formObj.tax_rto_dis) 						+"]" +
					" VAT[" + ComGetObjValue(formObj.tax_amt) 							+"]" +
					" TAX_NM[" + ComGetObjValue(formObj.tax_nm)							+"]" +
					" TOTAL_AMOUNT_DUE[" + ComGetObjValue(formObj.inv_amt) 				+"]" +
					" INV_CURR_CD[" + ComGetObjValue(formObj.inv_curr_cd) 				+"]" +
					" CUSTREF[" + ComGetObjValue(formObj.cust_ref_prn_flg)  				+"]" +
					" TELFAX[" + ComGetObjValue(formObj.phn_fax_prn_flg)  				+"]" +
					" CUSTVATNO[" + ComGetObjValue(formObj.cust_vat_prn_flg)  			+"]" +
					" TAXAMT[" + ComGetObjValue(formObj.tax_amt_prn_flg)				+"]" +
					" DCAMT[" + ComGetObjValue(formObj.dc_amt_prn_flg) 					+"]" +
					" RD_USR_CNT_CD[" + ComGetObjValue(formObj.rd_usr_cnt_cd) +"]" +
					// 인도 TAX 관련 정보	
					" RD_TAX_RGST_NO["         + ComGetObjValue(formObj.rd_tax_rgst_no)          + "]" +
					" RD_SVC_CATE_RMK["        + ComGetObjValue(formObj.rd_svc_cate_rmk)         + "]" +
					" RD_PMNT_ACCT_NO["        + ComGetObjValue(formObj.rd_pmnt_acct_no)         + "]" +
					" RD_IDA_EXPN_TAX_RT["     + ComGetObjValue(formObj.rd_ida_expn_tax_rt)      + "]" +
					" RD_IDA_EXPN_TAX["        + ComGetObjValue(formObj.rd_ida_expn_tax)         + "]" +
					" RD_IDA_EDU_TAX_RT["      + ComGetObjValue(formObj.rd_ida_edu_tax_rt)       + "]" +
					" RD_IDA_EDU_TAX["         + ComGetObjValue(formObj.rd_ida_edu_tax)          + "]" +
					" RD_IDA_HIGH_EDU_TAX_RT[" + ComGetObjValue(formObj.rd_ida_high_edu_tax_rt)  + "]" +
					" RD_IDA_HIGH_EDU_TAX["    + ComGetObjValue(formObj.rd_ida_high_edu_tax)     + "]" +
					// SBC ( Swacha Bharat Cess )
					" RD_IDA_LOCL_TAX_RT["     + ComGetObjValue(formObj.rd_ida_locl_tax_rt)      + "]" +
					" RD_IDA_LOCL_TAX["        + ComGetObjValue(formObj.rd_ida_locl_tax)         + "]" +
					// KCC ( Krishi Kalyan Cess )
					" RD_IDA_N2ND_LOCL_TAX_RT["+ ComGetObjValue(formObj.rd_ida_n2nd_locl_tax_rt) + "]" +
					" RD_IDA_N2ND_LOCL_TAX["   + ComGetObjValue(formObj.rd_ida_n2nd_locl_tax)    + "]" +
					" RD_IDA_TAX_APPL_TM["     + ComGetObjValue(formObj.rd_ida_tax_appl_tm)      + "]" + 
					" RD_IDA_CGST_RTO["        + ComGetObjValue(formObj.rd_ida_cgst_rto)         + "]" + 
					" RD_IDA_CGST_AMT["        + ComGetObjValue(formObj.rd_ida_cgst_amt)         + "]" + 
					" RD_IDA_SGST_RTO["        + ComGetObjValue(formObj.rd_ida_sgst_rto)         + "]" + 
					" RD_IDA_SGST_AMT["        + ComGetObjValue(formObj.rd_ida_sgst_amt)         + "]" + 
					" RD_IDA_IGST_RTO["        + ComGetObjValue(formObj.rd_ida_igst_rto)         + "]" + 
					" RD_IDA_IGST_AMT["        + ComGetObjValue(formObj.rd_ida_igst_amt)         + "]" + 
					" RD_IDA_UGST_RTO["        + ComGetObjValue(formObj.rd_ida_ugst_rto)         + "]" + 
					" RD_IDA_UGST_AMT["        + ComGetObjValue(formObj.rd_ida_ugst_amt)         + "]" +
					" RD_BANK_ACCT_NO["        + ComGetObjValue(formObj.rd_ida_bank_acct_no)     + "]" +
					" RD_BANK_IFSC_CD["        + ComGetObjValue(formObj.rd_ida_bank_ifsc_cd)     + "]" +
					" RD_IDA_GST_RGST_NO["     + ComGetObjValue(formObj.rd_ida_gst_rgst_no)      + "]" +
					" RD_IDA_STE_CD["          + ComGetObjValue(formObj.rd_ida_ste_cd)           + "]" +
					" RD_IDA_SAC_CD["          + ComGetObjValue(formObj.rd_ida_sac_cd)           + "]" +
					" RD_IDA_TAX_CIN["         + ComGetObjValue(formObj.rd_ida_tax_cin)          + "]" + 
					" RD_IDA_OFC_STE_CD["      + ComGetObjValue(formObj.rd_ida_ofc_ste_cd)       + "]";    	
    	
    	return rvRaram;
    }
      
      /**
       * RD(Booking)를 위한 데이터 호출 및 리셋 
       */    
 	function makeDataByBooking(formObj, opener, opnSheetObj, sheetObj2){
  		ComSetObjValue(formObj.ofc_cd, 			opener.document.form.ofc_cd.value);
  		ComSetObjValue(formObj.dmdt_trf_cd, 	opener.document.form.dmdt_trf_cd.value);
  		ComSetObjValue(formObj.payer_cd, 		opener.document.form.payer_cd.value);
  		ComSetObjValue(formObj.payer_nm, 		opener.document.form.payer_nm.value);
  		ComSetObjValue(formObj.trucker, 		opener.document.form.trucker_nm.value);
  		//부모화면에서 null 값이 넘어 오느라 아래 처럼 정의함.
  		if(ComGetObjValue(opener.document.form.dmdt_payr_cntc_pnt_nm) == 'null'){
  			ComSetObjValue(formObj.dmdt_payr_cntc_pnt_nm, '');
  		} else {
  			ComSetObjValue(formObj.dmdt_payr_cntc_pnt_nm, opener.document.form.dmdt_payr_cntc_pnt_nm.value);
  		}
  		  
  		ComSetObjValue(formObj.payr_cntc_pnt_phn_no, 	opener.document.form.payr_cntc_pnt_phn_no.value);
  		ComSetObjValue(formObj.payr_cntc_pnt_fax_no, 	opener.document.form.payr_cntc_pnt_fax_no.value);
  		ComSetObjValue(formObj.payr_cntc_pnt_eml, 		opener.document.form.payr_cntc_pnt_eml.value);
  		ComSetObjValue(formObj.inv_curr_cd, 			opener.document.form.inv_curr_cd.value);
  		
  		ComSetObjValue(formObj.bkg_no, 					opener.document.form.bkg_no.value);
  		//RD: TOTAL PART 
  		//추가 나중에 확인 사항.
  		ComSetObjValue(formObj.org_curr_cd, 			opener.document.form.chg_curr_cd.value); 
  		//추가 나중에 확인 사항.
  		ComSetObjValue(formObj.tot_org_amt, 			opener.document.form.mn_bil_amt.value); 
  		//total
  		ComSetObjValue(formObj.ex_rate, 				opener.document.form.inv_xch_rt.value); 
  		ComSetObjValue(formObj.tot_amt, 				opener.document.form.tot_amt.value);
  		ComSetObjValue(formObj.dc_amt, 					opener.document.form.dc_amt.value);
  		ComSetObjValue(formObj.inv_chg_amt, 			opener.document.form.inv_chg_amt.value);
  		ComSetObjValue(formObj.tax_amt, 				opener.document.form.tax_amt.value);
  		ComSetObjValue(formObj.inv_amt, 				opener.document.form.inv_amt.value);
  		ComSetObjValue(formObj.tax_rto_dis, 			opener.document.form.tax_rto_dis.value);
  		ComSetObjValue(formObj.rd_tax_rgst_no, 	        opener.document.form.tax_rgst_no.value);
  		ComSetObjValue(formObj.rd_svc_cate_rmk, 	    opener.document.form.svc_cate_rmk.value);
  		ComSetObjValue(formObj.rd_pmnt_acct_no, 	    opener.document.form.pmnt_acct_no.value);
  		ComSetObjValue(formObj.rd_usr_cnt_cd, 	        opener.document.form.usr_cnt_cd.value);
  		ComSetObjValue(formObj.rd_ida_expn_tax_rt, 	    opener.document.form.ida_expn_tax_rt.value);
  		ComSetObjValue(formObj.rd_ida_expn_tax, 	    opener.document.form.ida_expn_tax.value);
  		ComSetObjValue(formObj.rd_ida_edu_tax_rt, 	    opener.document.form.ida_edu_tax_rt.value);
  		ComSetObjValue(formObj.rd_ida_edu_tax, 	        opener.document.form.ida_edu_tax.value);
  		ComSetObjValue(formObj.rd_ida_high_edu_tax_rt, 	opener.document.form.ida_high_edu_tax_rt.value);
  		ComSetObjValue(formObj.rd_ida_high_edu_tax, 	opener.document.form.ida_high_edu_tax.value);
  		ComSetObjValue(formObj.rd_ida_locl_tax_rt, 		opener.document.form.ida_locl_tax_rt.value);
  		ComSetObjValue(formObj.rd_ida_locl_tax, 		opener.document.form.ida_locl_tax.value);
  		ComSetObjValue(formObj.rd_ida_n2nd_locl_tax, 	opener.document.form.ida_n2nd_locl_tax.value);
  		ComSetObjValue(formObj.rd_ida_n2nd_locl_tax_rt,	opener.document.form.ida_n2nd_locl_tax_rt.value);
  		ComSetObjValue(formObj.rd_ida_tax_appl_tm,      opener.document.form.ida_tax_appl_tm.value);
  		ComSetObjValue(formObj.rd_ida_cgst_rto,         opener.document.form.ida_cgst_rto.value);
  		ComSetObjValue(formObj.rd_ida_cgst_amt,         opener.document.form.ida_cgst_amt.value);
  		ComSetObjValue(formObj.rd_ida_sgst_rto,         opener.document.form.ida_sgst_rto.value);
  		ComSetObjValue(formObj.rd_ida_sgst_amt,         opener.document.form.ida_sgst_amt.value);
  		ComSetObjValue(formObj.rd_ida_igst_rto,         opener.document.form.ida_igst_rto.value);
  		ComSetObjValue(formObj.rd_ida_igst_amt,         opener.document.form.ida_igst_amt.value);
  		ComSetObjValue(formObj.rd_ida_ugst_rto,         opener.document.form.ida_ugst_rto.value);
  		ComSetObjValue(formObj.rd_ida_ugst_amt,         opener.document.form.ida_ugst_amt.value);
  		ComSetObjValue(formObj.rd_ida_bank_acct_no,     opener.document.form.ida_bank_acct_no.value);
  		ComSetObjValue(formObj.rd_ida_bank_ifsc_cd,     opener.document.form.ida_bank_ifsc_cd.value);
  		ComSetObjValue(formObj.cond_ida_sac_cd,         opener.document.form.cond_ida_sac_cd.value); 
  		ComSetObjValue(formObj.usr_cnt_cd, 	        	opener.document.form.usr_cnt_cd.value);
  		ComSetObjValue(formObj.ida_tax_appl_tm,      	opener.document.form.ida_tax_appl_tm.value);
  		
  		// payer_cd 가 6자리 vendor일 경우 00을 추가. 아래 조회 시때만 사용.
		ComSetObjValue(formObj.tmp_payer_cd, ComGetObjValue(formObj.payer_cd));
  		if(ComGetObjValue(formObj.payer_cd).length == 6) {
  			ComSetObjValue(formObj.payer_cd, "00" + ComGetObjValue(formObj.payer_cd));
  		}
  		
  		formObj.f_cmd.value = SEARCH01;	
  		var sXml =  sheetObj2.GetSearchXml("EES_DMT_3007GS.do",	FormQueryString(formObj));
  		sheetObj2.LoadSearchXml(sXml);
  		
  		//서버에서 받아온 etc 데이터를 한번에 form 에 전달.
  		ComEtcDataToForm(formObj, sheetObj2);
          
  		// 조회 후에 payer_cd를 이전 값으로 다시  리셋.
  		ComSetObjValue(formObj.payer_cd, ComGetObjValue(formObj.tmp_payer_cd));
  		
        //서버에서 받아온 값 : address01 : DONGSHIN MARITIME AGENCY CO.,LTD.|SEJONG B/D 100 DANGJOO-DONG, JONGRO-GU, SEOUL, KOREA
        //"|" 을 기준으로 cust_nm 및 address01로 다시 변수에 리셋함
   	  	if(!ComIsEmpty ( ComGetObjValue(formObj.address01) )){	
			  var temp = ComGetObjValue(formObj.address01).split("|");
			  ComSetObjValue(formObj.cust_nm,		temp[0]);			
		      ComSetObjValue(formObj.address01, 	temp[1]);	
   	  	} else {
   	  		  ComSetObjValue(formObj.cust_nm,		"");			
   	  		  ComSetObjValue(formObj.address01, 	"");	   	  			
   	  	}
   	  	
   	  	//주소데이터를  엔터값을 구분자로 분리처리함.  
   	  	if ( !ComIsEmpty ( ComGetObjValue(formObj.address01) ) ) {
   	  		var paryInfoAddr = ComGetObjValue(formObj.address01).split("\n");
   	  		var paryInfoAddrCnt = paryInfoAddr.length;
   	  		if ( paryInfoAddrCnt >= 1 ) {
   	  			document.form.address01.value = ComReplaceStr(paryInfoAddr[0],"'"," ");
   	  		} else {
   	  			document.form.address01.value = "";
   	  		}
   	  		if ( paryInfoAddrCnt >= 2 ) {
   	  			document.form.address02.value = ComReplaceStr(paryInfoAddr[1],"'"," ");
   	  		} else {
   	  			document.form.address02.value = "";
   	  		}
   	  		if ( paryInfoAddrCnt >= 3 ) {
   	  			document.form.address03.value = ComReplaceStr(paryInfoAddr[2],"'"," ");
   	  		} else {
   	  			document.form.address03.value = "";
	        }
   	  		if ( paryInfoAddrCnt >= 4 ) {
   	  			document.form.address04.value = ComReplaceStr(paryInfoAddr[3],"'"," ");
	        } else {
	        	document.form.address04.value = "";
	        }
   	  	} else {
//	    	document.form.address01.value = ComReplaceStr(paryInfoArr[2],"'"," ");
//	        document.form.address02.value = ComReplaceStr(paryInfoArr[2],"'"," ");
//	        document.form.address03.value = ComReplaceStr(paryInfoArr[2],"'"," ");
//	        document.form.address04.value = ComReplaceStr(paryInfoArr[2],"'"," ");
   	  	}
        //주소처리 끝.
   	  	
   	  	//flag 여부에 따라  RD화면에 include / exclude 함.		
  		if(!ComIsEmpty ( ComGetObjValue(formObj.sh_num) )){
  			temp = ComGetObjValue(formObj.sh_num).split("|");
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
	function previewByGroup(formObj, opener, opnSheetObj, sheetObj) {
		
 		//데이터 정의 
     	makeDataByGroup(formObj, opener, opnSheetObj, sheetObj);
     	
 		//rd에게 넘기는 파람값 셋팅.(preview/fax/email 같이 사용.)
     	//faxEmailByGroup(formObj, opener, opnSheetObj, sheetObj);
     	//부모화면에서 다수의 bkg_no를 get방식으로 받지 않고 자식 창에서 직접 부모를 호출하여 가져온다.
    	var bkgNos 		= "";
    	var cntrNos 	= "";
  		var chkRows 	= opnSheetObj.FindCheckedRow(1).split("|");
  		for (var i=0; i<chkRows.length-1; i++) {
  			bkgNos  += ','+opnSheetObj.CellValue(chkRows[i], "bkg_no");
  			cntrNos += ','+opnSheetObj.CellValue(chkRows[i], "cntr_no");
  		}
  		ComSetObjValue(formObj.bkg_no, 	bkgNos.substring(1));
  		ComSetObjValue(formObj.cntr_no, cntrNos.substring(1));
  		
  		//rd_fxeml_rd_param 셋팅 rd report 표현 할 때 사용.
  		var rdRaram = " /rp [" + ComGetObjValue(formObj.ofc_cd) 								  +"]" +
  		 				  " [" + ComGetObjValue(formObj.dmdt_trf_cd) 							  +"]" +
  		 				  " [" + ComReplaceStr(ComGetObjValue(formObj.dmdt_chg_sts_cd), "R", "L") +"]" +
  		 				  " [" + ComGetObjValue(formObj.bkg_no) 								  +"]" +
  		 				  " [" + ComGetObjValue(formObj.cntr_no) 								  +"]" +
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
  		 				" [" + ComGetObjValue(formObj.hjs_ref) 						+"]" +
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
		 				" /rv TAX_NM[" + ComGetObjValue(formObj.tax_nm)				+"]" +
						// 인도 TAX 관련 정보	
						" RD_TAX_RGST_NO["         + ComGetObjValue(formObj.rd_tax_rgst_no)          + "]" +
						" RD_SVC_CATE_RMK["        + ComGetObjValue(formObj.rd_svc_cate_rmk)         + "]" +
						" RD_PMNT_ACCT_NO["        + ComGetObjValue(formObj.rd_pmnt_acct_no)         + "]" +
						" RD_IDA_EXPN_TAX_RT["     + ComGetObjValue(formObj.rd_ida_expn_tax_rt)      + "]" +
						" RD_IDA_EXPN_TAX["        + ComGetObjValue(formObj.rd_ida_expn_tax)         + "]" +
						" RD_IDA_EDU_TAX_RT["      + ComGetObjValue(formObj.rd_ida_edu_tax_rt)       + "]" +
						" RD_IDA_EDU_TAX["         + ComGetObjValue(formObj.rd_ida_edu_tax)          + "]" +
						" RD_IDA_HIGH_EDU_TAX_RT[" + ComGetObjValue(formObj.rd_ida_high_edu_tax_rt)  + "]" +
						" RD_IDA_HIGH_EDU_TAX["    + ComGetObjValue(formObj.rd_ida_high_edu_tax)     + "]" +
						// SBC ( Swacha Bharat Cess )
						" RD_IDA_LOCL_TAX_RT["     + ComGetObjValue(formObj.rd_ida_locl_tax_rt)      + "]" +
						" RD_IDA_LOCL_TAX["        + ComGetObjValue(formObj.rd_ida_locl_tax)         + "]" +
						// KCC ( Krishi Kalyan Cess )
						" RD_IDA_N2ND_LOCL_TAX_RT["+ ComGetObjValue(formObj.rd_ida_n2nd_locl_tax_rt) + "]" +
						" RD_IDA_N2ND_LOCL_TAX["   + ComGetObjValue(formObj.rd_ida_n2nd_locl_tax)    + "]" +
						" RD_IDA_TAX_APPL_TM["     + ComGetObjValue(formObj.rd_ida_tax_appl_tm)      + "]" + 
						" RD_IDA_CGST_RTO["        + ComGetObjValue(formObj.rd_ida_cgst_rto)         + "]" + 
						" RD_IDA_CGST_AMT["        + ComGetObjValue(formObj.rd_ida_cgst_amt)         + "]" + 
						" RD_IDA_SGST_RTO["        + ComGetObjValue(formObj.rd_ida_sgst_rto)         + "]" + 
						" RD_IDA_SGST_AMT["        + ComGetObjValue(formObj.rd_ida_sgst_amt)         + "]" + 
						" RD_IDA_IGST_RTO["        + ComGetObjValue(formObj.rd_ida_igst_rto)         + "]" + 
						" RD_IDA_IGST_AMT["        + ComGetObjValue(formObj.rd_ida_igst_amt)         + "]" + 
						" RD_IDA_UGST_RTO["        + ComGetObjValue(formObj.rd_ida_ugst_rto)         + "]" + 
						" RD_IDA_UGST_AMT["        + ComGetObjValue(formObj.rd_ida_ugst_amt)         + "]" +
						" RD_BANK_ACCT_NO["        + ComGetObjValue(formObj.rd_ida_bank_acct_no)     + "]" +
						" RD_BANK_IFSC_CD["        + ComGetObjValue(formObj.rd_ida_bank_ifsc_cd)     + "]" +
						" RD_IDA_GST_RGST_NO["     + ComGetObjValue(formObj.rd_ida_gst_rgst_no)      + "]" +
  						" RD_IDA_STE_CD["          + ComGetObjValue(formObj.rd_ida_ste_cd)           + "]" +
  						" RD_IDA_SAC_CD["          + ComGetObjValue(formObj.rd_ida_sac_cd)           + "]" +
  						" RD_IDA_TAX_CIN["         + ComGetObjValue(formObj.rd_ida_tax_cin)          + "]" + 
  						" RD_IDA_OFC_STE_CD["      + ComGetObjValue(formObj.rd_ida_ofc_ste_cd)       + "]";  		
  		
  		
  		ComSetObjValue(formObj.rd_fxeml_rd_param, rdRaram);
     	 
  		var rdParm = ComGetObjValue(formObj.rd_fxeml_rd_param);

		 var usrCntCd = ComGetObjValue(formObj.rd_usr_cnt_cd);  
		 var locDivCd = ComGetObjValue(formObj.bil_to_loc_div_cd);
		 var path = DmtComGetRdFileNm("D", "Y", usrCntCd, locDivCd);
		 
		 rdObjects[0].FileOpen(RD_path+path, RDServerIP + " " + rdParm);
	}
	

	function sendFaxEmail(sendType){
		
  		var formObj = document.form;
  		var opener = window.dialogArguments; // MODAL창에서 부모창 javascript호출
  		var opnfrmObj = opener.document.form;
 	 	var opnSheetObj = opener.document.sheet1;
 	 	var sheetObj = sheetObjects[0];  // Group 호출 시 사용.
 	 	var sheetObj2 = sheetObjects[1]; // Booking 호출시 사용.
 	 	var usrCntCd = ComGetObjValue(formObj.rd_usr_cnt_cd);  
 	 	var locDivCd = ComGetObjValue(formObj.bil_to_loc_div_cd);
 	 	
 	 	// call 한 대상이 어디에서 왔는지 확인 후 처리
 	 	// ex)call_to_rd_tp = "booking" or call_to_rd_tp = "group"
 	 	// 1. group - 3108, booking - 3109 
 	 	ComSetObjValue(formObj.call_to_rd_tp, opener.document.form.call_to_rd_tp.value);
 	 	if(ComGetObjValue(formObj.call_to_rd_tp) == 'group'){
 	 		//1.
 		 	makeDataByGroup(formObj, opener, opnSheetObj, sheetObj);
 		    //2.GROUP 용 RD DATA
 		 	faxEmailByGroup(formObj, opener, opnSheetObj, sheetObj);
 		 	//3.팩스 / 이메일 기본정보 셋팅.
 		 	faxEmaiInfoByGroup(formObj, opener, opnSheetObj, sheetObj);
 		 	
 		 	var rdfile = DmtComGetRdFileNm("D", "Y", usrCntCd, locDivCd, true);
 		 	ComSetObjValue(formObj.rd_fxeml_file_name, rdfile);
 	 	}	
 	 	// demand by booking
 	 	else {
 	 		
    		//1. 기본 정보 조회
 		 	makeDataByBooking(formObj, opener, opnSheetObj, sheetObj2);
 		 	//2.opener그리드에서 데이터 가져오기 - RD리스트 조회용도.
 		 	//var opnSheetParm = opener.sheetObjects[0].GetSaveString(false, true, "checkBox");
 		 	//3.rv param
 		 	// var rvParam = rvParmByBooking(formObj);
 		 	var rdParm = " /ruseurlmoniker [0] /rv " + rvParmByBooking(formObj) + " /rfn [" + RDServerIP + "/EES_DMT_3007_RD.do] /rpost [" + opener.sheetObjects[0].GetSaveString(false, true, "checkBox") + "]";
 		 	ComSetObjValue(formObj.rd_fxeml_rd_param, 	rdParm);
 		 	//3.팩스 / 이메일 기본정보 셋팅.
 		 	faxEmaiInfoByBooking(formObj, opener, opnSheetObj, sheetObj2);
 		 	
 		 	var rdfile = DmtComGetRdFileNm("D", "N", usrCntCd, locDivCd, true);
 		 	ComSetObjValue(formObj.rd_fxeml_file_name, rdfile);
 	 	}
	}
      
	function faxEmailByGroup(formObj, opener, opnSheetObj, sheetObj){
     	//부모화면에서 다수의 bkg_no를 get방식으로 받지 않고 자식 창에서 직접 부모를 호출하여 가져온다.
   	  	var bkgNos 		= "";
   	  	var cntrNos 	= "";
 		var chkRows 	= opnSheetObj.FindCheckedRow(1).split("|");
 		for(var i=0; i < chkRows.length-1; i++) {
 			bkgNos  += ','+opnSheetObj.CellValue(chkRows[i], "bkg_no");
 			cntrNos += ','+opnSheetObj.CellValue(chkRows[i], "cntr_no");
 		}
 		ComSetObjValue(formObj.bkg_no, 	bkgNos.substring(1));
 		ComSetObjValue(formObj.cntr_no, cntrNos.substring(1));
 		 
 		//rd_fxeml_rd_param 셋팅 rd report 표현 할 때 사용.
 		var rdRaram = " /rp  [" + ComGetObjValue(formObj.ofc_cd) 								  +"]" +
 		 				  " [" + ComGetObjValue(formObj.dmdt_trf_cd) 							  +"]" +
 		 				  " [" + ComReplaceStr(ComGetObjValue(formObj.dmdt_chg_sts_cd), "R", "L") +"]" +
 		 				  " [" + ComGetObjValue(formObj.bkg_no) 								  +"]" +
 		 				  " [" + ComGetObjValue(formObj.cntr_no) 								  +"]" +
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
 		 				" [" + ComGetObjValue(formObj.hjs_ref) 						+"]" +
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
 		 				" /rv TAX_NM[" + ComGetObjValue(formObj.tax_nm)				+"]" +
						// 인도 TAX 관련 정보	
						" RD_TAX_RGST_NO["         + ComGetObjValue(formObj.rd_tax_rgst_no)          + "]" +
						" RD_SVC_CATE_RMK["        + ComGetObjValue(formObj.rd_svc_cate_rmk)         + "]" +
						" RD_PMNT_ACCT_NO["        + ComGetObjValue(formObj.rd_pmnt_acct_no)         + "]" +
						" RD_IDA_EXPN_TAX_RT["     + ComGetObjValue(formObj.rd_ida_expn_tax_rt)      + "]" +
						" RD_IDA_EXPN_TAX["        + ComGetObjValue(formObj.rd_ida_expn_tax)         + "]" +
						" RD_IDA_EDU_TAX_RT["      + ComGetObjValue(formObj.rd_ida_edu_tax_rt)       + "]" +
						" RD_IDA_EDU_TAX["         + ComGetObjValue(formObj.rd_ida_edu_tax)          + "]" +
						" RD_IDA_HIGH_EDU_TAX_RT[" + ComGetObjValue(formObj.rd_ida_high_edu_tax_rt)  + "]" +
						" RD_IDA_HIGH_EDU_TAX["    + ComGetObjValue(formObj.rd_ida_high_edu_tax)     + "]" +
						// SBC ( Swacha Bharat Cess )
						" RD_IDA_LOCL_TAX_RT["     + ComGetObjValue(formObj.rd_ida_locl_tax_rt)      + "]" +
						" RD_IDA_LOCL_TAX["        + ComGetObjValue(formObj.rd_ida_locl_tax)         + "]" +
						// KCC ( Krishi Kalyan Cess )
						" RD_IDA_N2ND_LOCL_TAX_RT["+ ComGetObjValue(formObj.rd_ida_n2nd_locl_tax_rt) + "]" +
						" RD_IDA_N2ND_LOCL_TAX["   + ComGetObjValue(formObj.rd_ida_n2nd_locl_tax)    + "]" +
						" RD_IDA_TAX_APPL_TM["     + ComGetObjValue(formObj.rd_ida_tax_appl_tm)      + "]" + 
						" RD_IDA_CGST_RTO["        + ComGetObjValue(formObj.rd_ida_cgst_rto)         + "]" + 
						" RD_IDA_CGST_AMT["        + ComGetObjValue(formObj.rd_ida_cgst_amt)         + "]" + 
						" RD_IDA_SGST_RTO["        + ComGetObjValue(formObj.rd_ida_sgst_rto)         + "]" + 
						" RD_IDA_SGST_AMT["        + ComGetObjValue(formObj.rd_ida_sgst_amt)         + "]" + 
						" RD_IDA_IGST_RTO["        + ComGetObjValue(formObj.rd_ida_igst_rto)         + "]" + 
						" RD_IDA_IGST_AMT["        + ComGetObjValue(formObj.rd_ida_igst_amt)         + "]" + 
						" RD_IDA_UGST_RTO["        + ComGetObjValue(formObj.rd_ida_ugst_rto)         + "]" + 
						" RD_IDA_UGST_AMT["        + ComGetObjValue(formObj.rd_ida_ugst_amt)         + "]" +
						" RD_BANK_ACCT_NO["        + ComGetObjValue(formObj.rd_ida_bank_acct_no)     + "]" +
						" RD_BANK_IFSC_CD["        + ComGetObjValue(formObj.rd_ida_bank_ifsc_cd)     + "]";
 		
 		ComSetObjValue(formObj.rd_fxeml_rd_param, 	RDServerBAT + rdRaram);
	}     

	function faxEmaiInfoByBooking(formObj, opener, opnSheetObj, sheetObj){
 		//EMAIL 정보
        ComSetObjValue(formObj.rd_fxeml_sys_cd         , 	 "DMT");
		ComSetObjValue(formObj.rd_fxeml_bat_flg        , 	 "N");
		//Demand Note  subject
		ComSetObjValue(formObj.rd_fxeml_title		   ,  	 "Demand Note (B/L No.: SMLM" + ComGetObjValue(formObj.bl_no) + ")");               
		ComSetObjValue(formObj.rd_fxeml_doc_tp		   , 	 "D");
		ComSetObjValue(formObj.rd_fxeml_fax_no         , 	 "");
		ComSetObjValue(formObj.rd_fxeml_fax_sndr_id    , 	 "SM Line");
 		ComSetObjValue(formObj.rd_fxeml_eml_sndr_nm    , 	 "Demand Note");
		ComSetObjValue(formObj.rd_fxeml_eml_rcvr_add   , 	 "");//;mjchang@hanjin.com
		ComSetObjValue(formObj.rd_fxeml_eml_atch_file  , 	 ComGetNowInfo("ymd") + "_SMLM" + ComGetObjValue(formObj.bl_no)); //YYYY-MM-DD_SMLM+B/L No. (예시: 2010-02-24_SMLMSHAE61559002)
		ComSetObjValue(formObj.rd_fxeml_eml_templt     , 	 "EES_DMT_DEMAND_001.htmlmail"); // 템플릿 위치 C:/sitectx/ALPS\APP-INF/config/template/mailtemplate/template.htmlmail
		ComSetObjValue(formObj.rd_fxeml_eml_tmplt_param, 	 "bl_no;" + ComGetObjValue(formObj.bl_no) + "|bl_no;" + ComGetObjValue(formObj.bl_no) + "");
 		ComSetObjValue(formObj.invno					, 	 "DemandNot");
 		ComSetObjValue(formObj.payc						, 	 ComGetObjValue(formObj.payer_cd) );
	}	  
	
	function faxEmaiInfoByGroup(formObj, opener, opnSheetObj, sheetObj){
 		//EMAIL 정보
        ComSetObjValue(formObj.rd_fxeml_sys_cd         , 	 "DMT");
 		ComSetObjValue(formObj.rd_fxeml_bat_flg        , 	 "N");
 		ComSetObjValue(formObj.rd_fxeml_title          , 	 "Demand Note (SM Line Corporation)");
 		ComSetObjValue(formObj.rd_fxeml_doc_tp		   , 	 "G");
 		ComSetObjValue(formObj.rd_fxeml_fax_no         , 	 "");
 		ComSetObjValue(formObj.rd_fxeml_fax_sndr_id    , 	 "SM Line");
 		ComSetObjValue(formObj.rd_fxeml_eml_sndr_nm    , 	 "Demand Note");
 		ComSetObjValue(formObj.rd_fxeml_eml_rcvr_add   , 	 "");//;mjchang@hanjin.com
 		ComSetObjValue(formObj.rd_fxeml_eml_atch_file  , 	 ComGetNowInfo("ymd") + "_" + ComGetObjValue(formObj.payer_cd)); //YYYY-MM-DD_payer code (예시: 2010-02-24_KR123456)
 		ComSetObjValue(formObj.rd_fxeml_eml_templt     , 	 "EES_DMT_DEMAND_002.htmlmail"); // 템플릿 위치 C:/sitectx/ALPS\APP-INF/config/template/mailtemplate/template.htmlmail
 		ComSetObjValue(formObj.rd_fxeml_eml_tmplt_param, 	 "");
 		ComSetObjValue(formObj.invno					, 	 "DemandNot");
 		ComSetObjValue(formObj.payc						, 	 ComGetObjValue(formObj.payer_cd) );
	}
	

	
	/**
     * RD를 위한 데이터 호출 및 리셋 
     */    
	function makeDataByGroup(formObj, opener, opnSheetObj, sheetObj) {

    	ComSetObjValue(formObj.ofc_cd, 					opener.document.form.ofc_cd.value);
		ComSetObjValue(formObj.dmdt_trf_cd, 			opener.document.form.dmdt_trf_cd.value);
		ComSetObjValue(formObj.dmdt_chg_sts_cd, 		opener.document.form.dmdt_chg_sts_cds.value);  //code 리스트.
		ComSetObjValue(formObj.payer_cd, 				opener.document.form.payer_cd.value);
		ComSetObjValue(formObj.payer_nm, 				opener.document.form.payer_nm.value);
	  
		ComSetObjValue(formObj.dmdt_payr_cntc_pnt_nm, 	opener.document.form.dmdt_payr_cntc_pnt_nm.value);
		ComSetObjValue(formObj.payr_cntc_pnt_phn_no, 	opener.document.form.payr_cntc_pnt_phn_no.value);
		ComSetObjValue(formObj.payr_cntc_pnt_fax_no, 	opener.document.form.payr_cntc_pnt_fax_no.value);
		ComSetObjValue(formObj.payr_cntc_pnt_eml, 		opener.document.form.payr_cntc_pnt_eml.value);
		ComSetObjValue(formObj.inv_curr_cd, 			opener.document.form.inv_curr_cd.value);

        //RD 호출전에 화면에서 선택한 내용중에서 필요한 정보를 가져오기       	  
        ComSetObjValue(formObj.tot_bil_amt, 			opener.document.form.inv_chg_amt.value);
        ComSetObjValue(formObj.tot_tax_amt, 			opener.document.form.tax_amt.value);
        ComSetObjValue(formObj.tot_payable_amt, 		opener.document.form.inv_amt.value);
        ComSetObjValue(formObj.tax_rto_dis, 			opener.document.form.tax_rto_dis.value);
        ComSetObjValue(formObj.rd_usr_cnt_cd, 			opener.document.form.usr_cnt_cd.value);

        //인도 관련 항목.
  		ComSetObjValue(formObj.rd_usr_cnt_cd, 	        opener.document.form.usr_cnt_cd.value);
  		ComSetObjValue(formObj.usr_cnt_cd, 	        	opener.document.form.usr_cnt_cd.value);
  		ComSetObjValue(formObj.rd_ida_expn_tax_rt, 	    opener.document.form.ida_expn_tax_rt.value);
  		ComSetObjValue(formObj.rd_ida_expn_tax, 	    opener.document.form.ida_expn_tax.value);
  		ComSetObjValue(formObj.rd_ida_edu_tax_rt, 	    opener.document.form.ida_edu_tax_rt.value);
  		ComSetObjValue(formObj.rd_ida_edu_tax, 	        opener.document.form.ida_edu_tax.value);
  		ComSetObjValue(formObj.rd_ida_high_edu_tax_rt, 	opener.document.form.ida_high_edu_tax_rt.value);
  		ComSetObjValue(formObj.rd_ida_high_edu_tax, 	opener.document.form.ida_high_edu_tax.value);
  		ComSetObjValue(formObj.rd_ida_locl_tax_rt, 		opener.document.form.ida_locl_tax_rt.value);
  		ComSetObjValue(formObj.rd_ida_locl_tax, 		opener.document.form.ida_locl_tax.value);
  		ComSetObjValue(formObj.rd_ida_n2nd_locl_tax, 	opener.document.form.ida_n2nd_locl_tax.value);
  		ComSetObjValue(formObj.rd_ida_n2nd_locl_tax_rt,	opener.document.form.ida_n2nd_locl_tax_rt.value);
  		ComSetObjValue(formObj.rd_ida_tax_appl_tm,      opener.document.form.ida_tax_appl_tm.value);
  		ComSetObjValue(formObj.rd_ida_cgst_rto,         opener.document.form.ida_cgst_rto.value);
  		ComSetObjValue(formObj.rd_ida_cgst_amt,         opener.document.form.ida_cgst_amt.value);
  		ComSetObjValue(formObj.rd_ida_sgst_rto,         opener.document.form.ida_sgst_rto.value);
  		ComSetObjValue(formObj.rd_ida_sgst_amt,         opener.document.form.ida_sgst_amt.value);
  		ComSetObjValue(formObj.rd_ida_igst_rto,         opener.document.form.ida_igst_rto.value);
  		ComSetObjValue(formObj.rd_ida_igst_amt,         opener.document.form.ida_igst_amt.value);
  		ComSetObjValue(formObj.rd_ida_ugst_rto,         opener.document.form.ida_ugst_rto.value);
  		ComSetObjValue(formObj.rd_ida_ugst_amt,         opener.document.form.ida_ugst_amt.value);
  		ComSetObjValue(formObj.rd_ida_bank_acct_no,     opener.document.form.ida_bank_acct_no.value);
  		ComSetObjValue(formObj.rd_ida_bank_ifsc_cd,     opener.document.form.ida_bank_ifsc_cd.value);
  		ComSetObjValue(formObj.cond_ida_sac_cd,         opener.document.form.cond_ida_sac_cd.value); 

        // payer_cd 가 6자리 vendor일 경우 00을 추가. 아래 조회 시때만 사용.
        ComSetObjValue(formObj.tmp_payer_cd, ComGetObjValue(formObj.payer_cd));
        if(ComGetObjValue(formObj.payer_cd).length == 6) {
        	ComSetObjValue(formObj.payer_cd, "00" + ComGetObjValue(formObj.payer_cd));
        }

        formObj.f_cmd.value = SEARCH01;
        var sXml =  sheetObj.GetSearchXml("EES_DMT_3007GS.do",	FormQueryString(formObj));

        sheetObj.LoadSearchXml(sXml);
        //서버에서 받아온 etc 데이터를 한번에 form 에 전달.
        ComEtcDataToForm(formObj, sheetObj);
        
        //조회 후에 payer_cd를 이전 값으로 다시  리셋.
        ComSetObjValue(formObj.payer_cd, ComGetObjValue(formObj.tmp_payer_cd));
        
        //서버에서 받아온 값 : address01 : DONGSHIN MARITIME AGENCY CO.,LTD.|SEJONG B/D 100 DANGJOO-DONG, JONGRO-GU, SEOUL, KOREA
        //"|" 을 기준으로 cust_nm 및 address01로 다시 변수에 리셋함
        if (!ComIsEmpty(ComGetObjValue(formObj.address01))) {	
        	var temp = ComGetObjValue(formObj.address01).split("|");
  		  	ComSetObjValue(formObj.cust_nm,		temp[0]);			
  		  	ComSetObjValue(formObj.address01, 	temp[1]);	
  	  	} 
        else {
  	  		  ComSetObjValue(formObj.cust_nm,		"");			
  	  		  ComSetObjValue(formObj.address01, 	"");	   	  			
  	  	}
   	  	
   	  	//주소데이터를  엔터값을 구분자로 분리처리함.  
   	  	if (!ComIsEmpty(ComGetObjValue(formObj.address01))) {
   	  		var paryInfoAddr = ComGetObjValue(formObj.address01).split("\n");
   	  		var paryInfoAddrCnt = paryInfoAddr.length;
   	  		if ( paryInfoAddrCnt >= 1 ) {
   	  			document.form.address01.value = ComReplaceStr(paryInfoAddr[0],"'"," ");
   	  		} else {
   	  			document.form.address01.value = "";
   	  		}
   	  		if ( paryInfoAddrCnt >= 2 ) {
   	  			document.form.address02.value = ComReplaceStr(paryInfoAddr[1],"'"," ");
   	  		} else {
   	  			document.form.address02.value = "";
   	  		}
   	  		if ( paryInfoAddrCnt >= 3 ) {
   	  			document.form.address03.value = ComReplaceStr(paryInfoAddr[2],"'"," ");
   	  		} else {
   	  			document.form.address03.value = "";
	        }
   	  		if ( paryInfoAddrCnt >= 4 ) {
   	  			document.form.address04.value = ComReplaceStr(paryInfoAddr[3],"'"," ");
	        } else {
	        	document.form.address04.value = "";
	        }
   	  	} else {
//	    	document.form.address01.value = ComReplaceStr(paryInfoArr[2],"'"," ");
//	        document.form.address02.value = ComReplaceStr(paryInfoArr[2],"'"," ");
//	        document.form.address03.value = ComReplaceStr(paryInfoArr[2],"'"," ");
//	        document.form.address04.value = ComReplaceStr(paryInfoArr[2],"'"," ");
   	  	}
        //주소처리 끝.
   	  	
        //flag 여부에 따라  RD화면에 include / exclude 함.	
        if (!ComIsEmpty(ComGetObjValue(formObj.sh_num))) {
  			temp = ComGetObjValue(formObj.sh_num).split("|");
  			ComSetObjValue(formObj.bil_to_loc_div_cd,	temp[0]);			
  			ComSetObjValue(formObj.cust_ref_prn_flg, 	temp[1]);	
  			ComSetObjValue(formObj.phn_fax_prn_flg, 	temp[2]);		
  			ComSetObjValue(formObj.cust_vat_prn_flg, 	temp[3]);		
  			ComSetObjValue(formObj.tax_amt_prn_flg,   	temp[4]);
  			ComSetObjValue(formObj.dc_amt_prn_flg,   	temp[5]);
  		} 
        else {
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
 	* 시트 초기설정값, 헤더 정의
 	* param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 	* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 	*/
	function initSheet(sheetObj,sheetNo) {
	var cnt = 0;
	var sheetID = sheetObj.id;
     					
      	switch(sheetID) {

          	case "sheet1":      // t1sheet1 init
          		with (sheetObj) {
  					// 높이 설정
  					style.height = 100;
  					// 전체 너비 설정
  					SheetWidth = mainTable.clientWidth;

  					// Host정보 설정[필수][HostIp, Port, PagePath]
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

  					// 전체Merge 종류 [선택, Default msNone]
  					MergeSheet = msNone;

  					// 전체Edit 허용 여부 [선택, Default false]
  					Editable = true;

  					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  					InitRowInfo( 1, 1, 2, 100);

  					// 해더에서 처리할 수 있는 각종 기능을 설정한다
  					InitHeadMode(true, true, false, true, false,false);

  					var HeadTitle  = "|Seq.|VVD_CD|BL_NO|LOC|CNTR_NO|CNTR_TPSZ_CD|FM_MVMT_DT|TO_MVMT_DT|ft_cmnc_dt|FT_END_DT|FT_DYS|FX_FT_OVR_DYS|BZC_TRF_CURR_CD|org_chg_amt|EXPT_AMT|AFT_EXPT_DC_AMT|BIL_AMT";

  					var headCount = ComCountHeadTitle(HeadTitle);
                      
  					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  					InitColumnInfo(headCount, 0, 0, true);
                      
  					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  					InitHeadRow(0, HeadTitle, true);

  					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,		daCenter,   true,     	"ibflag");	
					InitDataProperty(0, cnt++ , dtSeq,			 30,		daCenter,	true,		"seq");
  					InitDataProperty(0, cnt++ , dtData,			 80,		daCenter,	true,		"vvd_cd",				false,		"",			dfNone,			0,		true,		true);
  					InitDataProperty(0, cnt++ , dtData,			 80,		daCenter,	true,		"bl_no",				false,		"",			dfNone,			0,		true,		true);
  					InitDataProperty(0, cnt++ , dtData,			 80,		daCenter,	true,		"loc",					false,		"",			dfNone,			0,		true,		true);
  					InitDataProperty(0, cnt++ , dtData,			 80,		daCenter,	true,		"cntr_no",				false,		"",			dfNone,			0,		true,		true);
  					InitDataProperty(0, cnt++ , dtData,			 80,		daCenter,	true,		"cntr_tpsz_cd",			false,		"",			dfNone,			0,		true,		true);
  					InitDataProperty(0, cnt++ , dtData,			 80,		daCenter,	true,		"fm_mvmt_dt",			false,		"",			dfNone,			0,		true,		true);
  					InitDataProperty(0, cnt++ , dtData,			 80,		daCenter,	true,		"to_mvmt_dt",			false,		"",			dfNone,			0,		true,		true);
  					InitDataProperty(0, cnt++ , dtData,			 80,		daCenter,	true,		"ft_cmnc_dt",			false,		"",			dfNone,			0,		true,		true);
  					InitDataProperty(0, cnt++ , dtData,			 80,		daCenter,	true,		"ft_end_dt",			false,		"",			dfNone,			0,		true,		true);
  					InitDataProperty(0, cnt++ , dtData,			 80,		daCenter,	true,		"ft_dys",				false,		"",			dfNone,			0,		true,		true);
  					InitDataProperty(0, cnt++ , dtData,			 80,		daCenter,	true,		"fx_ft_ovr_dys",		false,		"",			dfNone,			0,		true,		true);
  					
  					InitDataProperty(0, cnt++ , dtData,			 80,		daCenter,	true,		"bzc_trf_curr_cd",		false,		"",			dfNone,			0,		true,		true);
  					InitDataProperty(0, cnt++ , dtData,			 80,		daCenter,	true,		"org_chg_amt",			false,		"",			dfNullFloat,	2,		true,		true);
  					InitDataProperty(0, cnt++ , dtData,			 80,		daCenter,	true,		"expt_amt",				false,		"",			dfNullFloat,	2,		true,		true);
  					InitDataProperty(0, cnt++ , dtData,			 80,		daCenter,	true,		"aft_expt_dc_amt",		false,		"",			dfNullFloat,	2,		true,		true);
  					
  					InitDataProperty(0, cnt++ , dtData,			 80,		daCenter,	true,		"bil_amt",				false,		"",			dfNullFloat,	2,		true,		true);
  					

  					CountPosition = 2;
          		}
                break;  
                
          	case "sheet2":      // t1sheet1 init
      			with (sheetObj) {
					// 높이 설정
					style.height = 100;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;

					// 전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 2, 100);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);

					var HeadTitle  = "|Seq.|cntr_no|cntr_tpsz_cd|fm_mvmt_dt|to_mvmt_dt|ft_cmnc_dt|ft_end_dt|ft_dys|ft_ovr_und_dys|rt_amt|fx_ft_ovr_dys|rt_amount|bzc_trf_curr_cd";

					var headCount = ComCountHeadTitle(HeadTitle);
                  
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
                  
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,		daCenter,   true,     	"ibflag");	
					InitDataProperty(0, cnt++ , dtSeq,			 30,		daCenter,	true,		"seq");
					InitDataProperty(0, cnt++ , dtData,			 80,		daCenter,	true,		"cntr_no",				false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			 80,		daCenter,	true,		"cntr_tpsz_cd",			false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			 80,		daCenter,	true,		"fm_mvmt_dt",			false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			 80,		daCenter,	true,		"to_mvmt_dt",			false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			 80,		daCenter,	true,		"ft_cmnc_dt",			false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			 80,		daCenter,	true,		"ft_end_dt",			false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			 80,		daCenter,	true,		"ft_dys",				false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			 80,		daCenter,	true,		"ft_ovr_und_dys",		false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			 80,		daCenter,	true,		"rt_amt",				false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			 80,		daCenter,	true,		"fx_ft_ovr_dys",		false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			 80,		daCenter,	true,		"rt_amount",			false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			 80,		daCenter,	true,		"bzc_trf_curr_cd",		false,		"",			dfNone,			0,		true,		true);

					CountPosition = 2;
      		}
            break;                  
      	}                
	}      
  
 	/**
 	 * EES_DMT_3109, EES_DMT_3108 팝업 호출
 	 * @param sheetObj
 	 * @param formObj
 	 * @param srcName
 	 * @return
 	 */
 	function openPopupWindow(sheetObj, formObj, srcName) {
 		var sheetType = "";
 		 if(ComGetObjValue(formObj.call_to_rd_tp) == 'group'){
 			sheetType = "G";
 		} else {
 			sheetType = "D";
 		}
 		if(srcName == "btn_set") {
 			var url = "EES_DMT_4101.do"
 				+"?issoff="+ComGetObjValue(formObj.ofc_cd)
 				+"&tftp2="+ComGetObjValue(formObj.dmdt_trf_cd)
 				+"&sheetp="+sheetType
 				+"&invoice_issue=1"
 				+"&jspno=EES_DMT_3007";
 			var returnValue = ComOpenWindowCenter(url, "EES_DMT_4101", "725","780", true);
 		} else if(srcName == "btn_option") {
 			var url = "EES_DMT_4103.do"
 				+"?issoff="+ComGetObjValue(formObj.ofc_cd)
 				+"&invoice_issue=1"
 				+"&jspno=EES_DMT_3007";
 			var returnValue = ComOpenWindowCenter(url, "EES_DMT_4103", "625","650", true);

 		} else if(srcName == "btn_payerfaxemail") {
			var url = "EES_DMT_4104.do"
				+"?s_ofc_cd="+ComGetObjValue(formObj.ofc_cd)
				+"&s_cust_cd="+ComGetObjValue(formObj.payer_cd)
				+"&s_bkg_no="
				+"&s_pod_cd="
			var returnValue = ComOpenWindowCenter(url, "EES_DMT_4104", "825","620", true);
		} else if(srcName == "btn_fax") {
			if(ComGetObjValue(formObj.payer_cd) == null || ComGetObjValue(formObj.payer_cd) == "") {
				ComShowCodeMessage("DMT00182");
				return;
			}
			var ofc_cd = ComGetObjValue(formObj.session_ofc_cd);

			var url = "EES_DMT_4107.do"
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
			ComOpenWindowCenter(url, "EES_DMT_4107", "500","300", true);
		} else if(srcName == "btn_email") {
			if(ComGetObjValue(formObj.payer_cd) == null || ComGetObjValue(formObj.payer_cd) == "") {
				ComShowCodeMessage("DMT00182");
				return;
			}
			var ofc_cd = ComGetObjValue(formObj.session_ofc_cd);

			var url = "EES_DMT_4108.do"
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
			ComOpenWindowCenter(url, "EES_DMT_4108", "500","300", true);
		}
 	}     	
     	
 	 
 	// Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

             case IBSEARCH_ASYNC05:      //조회
                 //ComOpenWait Start
				 sheetObj.WaitImageVisible=false;
	        	 ComOpenWait(true);
	        	
                 formObj.f_cmd.value = SEARCH05;
                 sheetObj.DoSearch4Post( "DMTCommonFaxEmailGS.do" , FormQueryString(formObj) );
                 
                 //ComOpenWait End
				 ComOpenWait(false);
             break;

             case IBSEARCH_ASYNC06:      //조회
	             //ComOpenWait Start
				 sheetObj.WaitImageVisible=false;
	        	 ComOpenWait(true);             
                 
	        	 formObj.f_cmd.value = SEARCH06;
                 var sXml06 = sheetObj.GetSaveXml("DMTCommonFaxEmailGS.do", FormQueryString(formObj));
                 sheetObjects[0].LoadSaveXml(sXml06);    
                 
                 //ComOpenWait End
				 ComOpenWait(false);
             break;
             
             
         }
     }
 	 
    /* 개발자 작업  끝 */