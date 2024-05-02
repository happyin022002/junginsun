/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_3109.js
*@FileTitle : Demand Note Issue by Booking
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.09.25 최성환
* 1.0 Creation
* 2011.02.08 김태균 [CHM-201108612-01] [EES-DMT] [DMT] Demand Note 환율 표기 관련
* 2012.07.09 김현화 [CHM-201218976] 인도 Demand Note Issue - GST 적용.
* 2012.08.21 김현화 [CHM-201219328-01] Mexico DMT Invoice 금액 차이 발생건 보완-billable amount로 계산 하도록 수정함.
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
     * @class EES_DMT_3109 : EES_DMT_3109 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
	function EES_DMT_3109() {
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
	//공통전역변수
    var rdObjects = new Array();
    var rdCnt = 0;
    
	var sheetObjects = new Array();
	var sheetCnt = 0;

	var comboObjects = new Array();
	var comboCnt = 0;

	var ROWMARK = "|";
	var FIELDMARK = "=";
	
	//Action 정의
	var IBSEARCH_INIT = 100;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          
		var sheetObject1 = sheetObjects[0];
          
		/*******************************************************/
		/*******************************************************/
    	var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

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
						//Payer Code, INV Cur. 정보가 없을 경우 “Pls update Payer code first!” Alert창 띄우며 막음
						var payerCd = ComGetObjValue(formObject.payer_cd);
						if (payerCd == '') {
							ComShowCodeMessage('DMT00182');
							ComSetFocus(formObject.payer_cd);
							return;
						} 
						else {
							//Sheet Set 데이타가 없을 경우
							if (!validateSheetSetForBooking()) {
								ComShowCodeMessage('DMT01096');
								return false;
							}
							ComOpenPopupWithTarget('/hanjin/EES_DMT_3007.do', 920, 740, "", "0,1,1,1,1,1,1", true);
						}
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
							//Sheet Set 데이타가 없을 경우
							if (!validateSheetSetForBooking()) {
								ComShowCodeMessage('DMT01096');
								return false;
							}
							
							//ComOpenWait Start
		 					sheetObject1.WaitImageVisible=false;
		 		        	ComOpenWait(true);
		 		        	
							//init RD config
							initRdConfig(rdObjects[0]);
							rdOpen();
							
							//ComOpenWait End
							ComOpenWait(false);
						}
					}
					break;
					
				case "btn_fax":
					if(ComIsBtnEnable(srcName)) {
						//Sheet Set 데이타가 없을 경우
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
						//Sheet Set 데이타가 없을 경우
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
	 * Sheet Set 데이터여부를 판단한다. 데이터가 없을 경우 RD처리를 하지 않는다. 
	 */
	function validateSheetSetForBooking(){
   	 	var formObj = document.form;
   	 	var opnSheetObj = document.sheet1;
   	 	var sheetObj2 = sheetObjects[1]; // Booking 호출시 사용.
		
   	 	makeDataByBooking(formObj, opnSheetObj, sheetObj2);
   	 	
		// Group Sheet Set 확인 - 전체가 없으면  alert MSG
		if (     ComGetObjValue(formObj.ofc_add01) == ''
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
   	 	var opnSheetObj = document.sheet1;
   	 	var sheetObj2 = sheetObjects[1]; // Booking 호출시 사용.
   	 	var usr_cnt_cd = ComGetObjValue(formObj.usr_cnt_cd);
   	 	
   	 	//1.RD 기본 데이터를 정보
		 makeDataByBooking(formObj, opnSheetObj, sheetObj2);
		 //2.opener그리드에서 데이터 가져오기 - RD리스트 조회용도.
		 //var opnSheetParm = sheetObjects[0].GetSaveString(false, true, "checkBox");
		 //3.rv param
		 // var rvParam = rvParmByBooking(formObj);
		 var rdParm = " /ruseurlmoniker [0] /rv " + rvParmByBooking(formObj) + " /rfn [" + RDServerIP + "/EES_DMT_3007_RD.do] /rpost [" + sheetObjects[0].GetSaveString(false, true, "checkBox") + "]";
//		 ComDebug(rdParm);
		 
		 //2012.07.09 김현화 [CHM-201218976] 인도 Demand Note Issue	 추가 
		 //RD - Right
    	 if(ComGetObjValue(formObj.bil_to_loc_div_cd) == 'R'){
    		  if(usr_cnt_cd == 'IN'){
    		     rdObjects[0].FileOpen(RD_path+'apps/alps/ees/dmt/dmtinvoicemgt/demandnotesend/report/EES_DMT_3906.mrd', rdParm);
    		  }else {
    			 rdObjects[0].FileOpen(RD_path+'apps/alps/ees/dmt/dmtinvoicemgt/demandnotesend/report/EES_DMT_3902.mrd', rdParm);  
    		  }
    	 } 
    	 //RD - Left
    	 else {
    		 if(usr_cnt_cd == 'IN'){
    		      rdObjects[0].FileOpen(RD_path+'apps/alps/ees/dmt/dmtinvoicemgt/demandnotesend/report/EES_DMT_3905.mrd', rdParm);
    		 }else{
    			  rdObjects[0].FileOpen(RD_path+'apps/alps/ees/dmt/dmtinvoicemgt/demandnotesend/report/EES_DMT_3901.mrd', rdParm);
    		 }
    	 }    	
    	 
  	 	 //rd print
		 rdObjects[0].PrintDialog();
	}  
    
    /**
     * rv By Demand Booking 
     */ 
    function rvParmByBooking(formObj){
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
					// 인도 TAX 관련 정보	
					" RD_TAX_RGST_NO["          + ComGetObjValue(formObj.tax_rgst_no)          +"]" +
					" RD_SVC_CATE_RMK["         + ComGetObjValue(formObj.svc_cate_rmk)         +"]" +
					" RD_PMNT_ACCT_NO["         + ComGetObjValue(formObj.pmnt_acct_no)         +"]" +
					" RD_IDA_EXPN_TAX_RT["      + ComGetObjValue(formObj.ida_expn_tax_rt)      +"]" +
					" RD_IDA_EXPN_TAX["         + ComGetObjValue(formObj.ida_expn_tax)         +"]" +
					" RD_IDA_EDU_TAX_RT["       + ComGetObjValue(formObj.ida_edu_tax_rt)       +"]" +
					" RD_IDA_EDU_TAX["          + ComGetObjValue(formObj.ida_edu_tax)          +"]" +
					" RD_IDA_HIGH_EDU_TAX_RT["  + ComGetObjValue(formObj.ida_high_edu_tax_rt)  +"]" +
					" RD_IDA_HIGH_EDU_TAX["     + ComGetObjValue(formObj.ida_high_edu_tax)     +"]" +
					// SBC ( Swacha Bharat Cess )
					" RD_IDA_LOCL_TAX_RT["      + ComGetObjValue(formObj.ida_locl_tax_rt)      + "]" +
					" RD_IDA_LOCL_TAX["         + ComGetObjValue(formObj.ida_locl_tax)         + "]" +
					// KCC ( Krishi Kalyan Cess )
					" RD_IDA_N2ND_LOCL_TAX_RT[" + ComGetObjValue(formObj.ida_n2nd_locl_tax_rt) + "]" +
					" RD_IDA_N2ND_LOCL_TAX["    + ComGetObjValue(formObj.ida_n2nd_locl_tax)    + "]" +
					" RD_IDA_TAX_APPL_TM["      + ComGetObjValue(formObj.ida_tax_appl_tm)      + "]" + 
					" RD_IDA_CGST_RTO["         + ComGetObjValue(formObj.ida_cgst_rto)         + "]" + 
					" RD_IDA_CGST_AMT["         + ComGetObjValue(formObj.ida_cgst_amt)         + "]" + 
					" RD_IDA_SGST_RTO["         + ComGetObjValue(formObj.ida_sgst_rto)         + "]" + 
					" RD_IDA_SGST_AMT["         + ComGetObjValue(formObj.ida_sgst_amt)         + "]" + 
					" RD_IDA_IGST_RTO["         + ComGetObjValue(formObj.ida_igst_rto)         + "]" + 
					" RD_IDA_IGST_AMT["         + ComGetObjValue(formObj.ida_igst_amt)         + "]" + 
					" RD_IDA_UGST_RTO["         + ComGetObjValue(formObj.ida_ugst_rto)         + "]" + 
					" RD_IDA_UGST_AMT["         + ComGetObjValue(formObj.ida_ugst_amt)         + "]" +
					" RD_BANK_ACCT_NO["         + ComGetObjValue(formObj.ida_bank_acct_no)     + "]" +
					" RD_BANK_IFSC_CD["         + ComGetObjValue(formObj.ida_bank_ifsc_cd)     + "]" + 					
					" RD_IDA_GST_RGST_NO["      + ComGetObjValue(formObj.ida_gst_rgst_no)      + "]" +
					" RD_IDA_STE_CD["           + ComGetObjValue(formObj.ida_ste_cd)           + "]" +
					" RD_IDA_SAC_CD["           + ComGetObjValue(formObj.ida_sac_cd)           + "]" +
					" RD_IDA_TAX_CIN["          + ComGetObjValue(formObj.ida_tax_cin)          + "]" + 
					" RD_IDA_OFC_STE_CD["       + ComGetObjValue(formObj.ida_ofc_ste_cd)       + "]";    	
    	
    	return rvRaram;
    }
	/**
    * RD를 위한 데이터 호출 및 리셋 
    */    
	function makeDataByBooking(formObj, opnSheetObj, sheetObj2) {

 		//주석처리 한 내용은 변수명이 동일 해서 처리 처리 안함.
  		ComSetObjValue(formObj.trucker, document.form.trucker_nm.value);
  		// null 값이 넘어 오느라 아래 처럼 정의함.
  		if (ComGetObjValue(document.form.dmdt_payr_cntc_pnt_nm) == 'null') {
  			ComSetObjValue(formObj.dmdt_payr_cntc_pnt_nm, '');
  		}
  		else {
  			ComSetObjValue(formObj.dmdt_payr_cntc_pnt_nm, document.form.dmdt_payr_cntc_pnt_nm.value);
  		}
  		  
  		//RD: TOTAL PART 
  		//추가 나중에 확인 사항.
  		ComSetObjValue(formObj.org_curr_cd, document.form.chg_curr_cd.value); 
  		//추가 나중에 확인 사항.
  		ComSetObjValue(formObj.tot_org_amt, document.form.mn_bil_amt.value); 
  		//total
  		ComSetObjValue(formObj.ex_rate, document.form.inv_xch_rt.value); 

  		  
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
   	  	if (!ComIsEmpty ( ComGetObjValue(formObj.address01))) {
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
   	  	} 
   	  	else {
			document.form.address01.value = "";
			document.form.address02.value = "";
			document.form.address03.value = "";
			document.form.address04.value = "";
   	  	}
        //주소처리 끝.
   	  	
        //flag 여부에 따라  RD화면에 include / exclude 함.			     	
  		if (!ComIsEmpty ( ComGetObjValue(formObj.sh_num) )) {
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
	

	function sendFaxEmail(sendType){
     	var formObj = document.form;
     	//var opener = window.dialogArguments;
	 	var opnSheetObj = document.sheet1;
	 	var sheetObj = sheetObjects[1];  // Booking 호출 시 사용.
	 	var usr_cnt_cd = ComGetObjValue(formObj.usr_cnt_cd);
	 	
		//1. 기본 정보 조회
	 	makeDataByBooking(formObj, opnSheetObj, sheetObj);
	 	
	 	//2.opener그리드에서 데이터 가져오기 - RD리스트 조회용도.
	 	//var opnSheetParm = opener.sheetObjects[0].GetSaveString(false, true, "checkBox");
	 	//3.rv param
	 	// var rvParam = rvParmByBooking(formObj);
	 	var rdParm = " /ruseurlmoniker [0] /rv " + rvParmByBooking(formObj) + " /rfn [" + RDServerIP + "/EES_DMT_3007_RD.do] /rpost [" + sheetObjects[0].GetSaveString(false, true, "checkBox") + "]";
	 	
	 	ComSetObjValue(formObj.rd_fxeml_rd_param, 	rdParm);
      
	 	//3. 팩스 / 이메일 기본정보 셋팅.
	 	faxEmaiInfo(formObj, opnSheetObj, sheetObj); 
	 	
	 	if(ComGetObjValue(formObj.bil_to_loc_div_cd) == 'R'){
			if (usr_cnt_cd == 'IN') {
	 		    ComSetObjValue(formObj.rd_fxeml_file_name, "EES_DMT_3906.mrd");
			}
			else {
				ComSetObjValue(formObj.rd_fxeml_file_name, "EES_DMT_3902.mrd");
			}
		} 
		//RD - Left
		else {
			if (usr_cnt_cd == 'IN') {
				ComSetObjValue(formObj.rd_fxeml_file_name, "EES_DMT_3905.mrd");
			} 
			else {
				ComSetObjValue(formObj.rd_fxeml_file_name, "EES_DMT_3901.mrd");
			}
		}	
        
 	}	
	//SEND
	function faxEmaiInfo(formObj, opnSheetObj, sheetObj){
		//EMAIL 정보
        ComSetObjValue(formObj.rd_fxeml_sys_cd         , 	 "DMT");
		ComSetObjValue(formObj.rd_fxeml_bat_flg        , 	 "N");
		//Demand Note  subject
		ComSetObjValue(formObj.rd_fxeml_title		   ,  	 "Demand Note (B/L No.: SMLM" + ComGetObjValue(formObj.bl_no) + ")");               
		ComSetObjValue(formObj.rd_fxeml_doc_tp		   , 	 "D");
		ComSetObjValue(formObj.rd_fxeml_fax_no         , 	 "");
		ComSetObjValue(formObj.rd_fxeml_fax_sndr_id    , 	 "SM Line");
 		ComSetObjValue(formObj.rd_fxeml_eml_sndr_nm    , 	 "Demand Note");
		ComSetObjValue(formObj.rd_fxeml_eml_rcvr_add   , 	 ""); //;mjchang@hanjin.com
		ComSetObjValue(formObj.rd_fxeml_eml_atch_file  , 	 ComGetNowInfo("ymd") + "_SMLM" + ComGetObjValue(formObj.bl_no)); //YYYY-MM-DD_SMLM+B/L No. (예시: 2010-02-24_SMLMSHAE61559002)
		ComSetObjValue(formObj.rd_fxeml_eml_templt     , 	 "EES_DMT_DEMAND_001.htmlmail"); // 템플릿 위치 C:/sitectx/ALPS\APP-INF/config/template/mailtemplate/template.htmlmail
		ComSetObjValue(formObj.rd_fxeml_eml_tmplt_param, 	 "bl_no;" + ComGetObjValue(formObj.bl_no) + "|bl_no;" + ComGetObjValue(formObj.bl_no) + "");
 		ComSetObjValue(formObj.invno					, 	 "DemandNot");
 		ComSetObjValue(formObj.payc						, 	 ComGetObjValue(formObj.payer_cd) );
	}
	 
	///////////////////////////////////////////////////////////////////////////////	
	
    /**
    * IBSheet Object를 배열로 등록
    * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
    * 배열은 소스 상단에 정의
    */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	/** 
	 * IBCombo Object를 배열로 등록
	 * param : combo_obj ==> 콤보오브젝트
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */ 
	function setComboObject(combo_obj) {  
		 comboObjects[comboCnt++] = combo_obj;  
	} 
	
	/**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for (i=0; i<sheetObjects.length; i++) {
        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i], i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);

        }
	 	// IBMultiCombo초기화 
	    for (var k=0; k<comboObjects.length; k++) {
	        initCombo(comboObjects[k],k+1);
	    } 
	    
		initAxonControl();
		
		var formObj = document.form;
	
		//요구사항으로  [국가별 통화량]사용안함. 후에 다시 사용 가능성이 있어서 주석으로 처리. 
		//수정한 부분 : JS:searchARCurrencyList() ,function DmtComCalcInvAmtByTaxAmt() { 밑에 주석 부분 ,JSP:<select name="inv_curr_cd"~~
	    //국가별 통화량
		searchARCurrencyList();
		
		// Demand Note - Booking 초기 정보 조회
		DMTComDoActionIBSheet(sheetObjects[0], formObj, IBSEARCH_INIT);
		// Demand Note - Booking 정보 조회		
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
		
		// Payer 의 Attention 정보를 초기화해 줍니다.
		DmtComInitPayerAttention();	
		
		//팩스, 이메일 디폴트 값 셋팅 로직 추가 
		//Payer별 email, faxno를 조회한다.
		//parameter : payer_cd, ofc_cd  -- 세션 ofc_cd , dmdt_trf_cd 
		
		//메인 조회 후에 PAYER CD가 있을 경우만 EMAIL / FAX 조회함. 
		if (ComGetObjValue(formObj.payer_cd) != "") {
			doActionIBCombo(sheetObjects[1], formObj, IBSEARCH, COMMAND02, "", "");
		}
		
		//2011.03.31. invoice issue 전 PayerCd 팝업 체크 화면을 띄운다.
		if (ComGetObjValue(formObj.invoice_issue) == "1") {

            // Payer 정보를 설정합니다. ( US, CA 로직 적용 Payer Code 적용 )
            DmtComSetPayer();
            
			//초기화
			ComSetObjValue(formObj.payer_cd, "");
			ComSetObjValue(formObj.payer_nm, "");
			
    		comboObjects[0].Index = -1;
			ComSetObjValue(formObj.payr_cntc_pnt_phn_no, "");
			ComSetObjValue(formObj.payr_cntc_pnt_fax_no, "");
			ComSetObjValue(formObj.payr_cntc_pnt_eml,    "");

			// GST 정보 초기화
			ComSetObjValue(formObj.ida_gst_rgst_sts_nm, "");
			ComSetObjValue(formObj.ida_gst_rgst_no,     "");
			ComSetObjValue(formObj.ida_ste_cd,          "");
			ComSetObjValue(formObj.ida_ste_nm,          "");
			ComSetObjValue(formObj.ida_sac_cd,          "");
			ComSetObjValue(formObj.ida_sac_nm,          "");
			
			if (ComGetObjValue(formObj.h_payer_cd) != "")
				openPopup('payer_code_check');
		}
		
		/***********************************************************/
		DmtComValidPayer();
		/***********************************************************/
		
     }

	/**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
	function initSheet(sheetObj,sheetNo) {

		var cnt = 0;
		switch(sheetNo) {
            case 1:      // sheet1 init
            	with (sheetObj) {
                    // 높이 설정
                    style.height = 202;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1, 2, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle  = "||Seq.|STS|CNTR No.|T/S|Staying Period|Staying Period|Free Time|Free Time|F/T|Over|Cur.|Incurred AMT|Exception AMT|Discount AMT|Billable AMT|G/B|svr_id|cntr_cyc_no|dmdt_trf_cd|dmdt_chg_loc_div_cd|chg_seq|bzc_trf_seq|bzc_dmdt_de_term_cd|bzc_trf_grp_seq|cmdt_expt_amt|inv_bill_amt|inv_chg_tot";
                    var HeadTitle1 = "||Seq.|STS|CNTR No.|T/S|From Date|To Date|F/T CMNC|F/T End|F/T|Over|Cur.|Incurred AMT|Exception AMT|Discount AMT|Billable AMT|G/B|svr_id|cntr_cyc_no|dmdt_trf_cd|dmdt_chg_loc_div_cd|chg_seq|bzc_trf_seq|bzc_dmdt_de_term_cd|bzc_trf_grp_seq|cmdt_expt_amt|inv_bill_amt|inv_chg_tot";

                    var headCount = ComCountHeadTitle(HeadTitle);
                    var headCount1 = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
					InitHeadRow(1, HeadTitle1, true);
                    
					
                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,		DATAALIGN, COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,			daCenter,   true,       "ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,		40,			daCenter,	true,		"checkBox");
					InitDataProperty(0, cnt++ , dtSeq,			40,			daCenter,	true,		"seq");
					InitDataProperty(0, cnt++ , dtData,			30,			daCenter,	true,		"dmdt_chg_sts_cd",	false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			90,			daCenter,	true,		"cntr_no",			false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			30,			daCenter,	true,		"cntr_tpsz_cd",		false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			80,			daCenter,	true,		"fm_mvmt_dt",		false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			80,			daCenter,	true,		"to_mvmt_dt",		false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			80,			daCenter,	true,		"ft_cmnc_dt",		false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			80,			daCenter,	true,		"ft_end_dt",		false,		"",			dfNone,			0,		true,		true);
					
					InitDataProperty(0, cnt++ , dtData,			50,			daCenter,	true,		"ft_dys",			false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			50,			daCenter,	true,		"fx_ft_ovr_dys",	false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			40,			daCenter,	true,		"bzc_trf_curr_cd",	false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			90,			daRight,	true,		"org_chg_amt",		false,		"",			dfFloat,		2,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			90,			daRight,	true,		"expt_amt",			false,		"",			dfFloat,		2,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			90,			daRight,	true,		"aft_expt_dc_amt",	false,		"",			dfFloat,		2,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			80,			daRight,	true,		"bil_amt",			false,		"",			dfFloat,		2,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			50,			daCenter,	true,		"gb",				false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		100,		daCenter,	true,		"svr_id");
					InitDataProperty(0, cnt++ , dtHidden,		100,		daCenter,	true,		"cntr_cyc_no");
					
					InitDataProperty(0, cnt++ , dtHidden,		100,		daCenter,	true,		"dmdt_trf_cd");
					InitDataProperty(0, cnt++ , dtHidden,		100,		daCenter,	true,		"dmdt_chg_loc_div_cd");
					InitDataProperty(0, cnt++ , dtHidden,		100,		daCenter,	true,		"chg_seq");
					InitDataProperty(0, cnt++ , dtHidden,		100,		daCenter,	true,		"bzc_trf_seq");
					InitDataProperty(0, cnt++ , dtHidden,		100,		daCenter,	true,		"bzc_dmdt_de_term_cd");
					InitDataProperty(0, cnt++ , dtHidden,		100,		daCenter,	true,		"bzc_trf_grp_seq");
					InitDataProperty(0, cnt++ , dtHidden,		100,		daCenter,	true,		"cmdt_expt_amt");
					InitDataProperty(0, cnt++ , dtHidden,		85,			daRight,	true,		"inv_bill_amt",			false,		"",			dfFloat,		2,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		85,			daRight,	true,		"inv_chg_tot",			false,		"",			dfFloat,		2,		false,		true);
					
                    FrozenCols = SaveNameCol("cntr_tpsz_cd");

					ToolTipOption = "balloon:true;width:50;";
					ToolTipText(0,"gb") = "General/Balance Charge Type";
					ToolTipText(1,"gb") = "General/Balance Charge Type";
					CountPosition = 0;
            	}
            	break;
           
            case 2:
            	with (sheetObj) {
            		// 높이 설정
                    style.height = 220;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                  //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1, 2, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle  = "||Seq.|STS|CNTR No.|T/S|Staying Period|Staying Period|Free Time|Free Time|F/T|Over|Cur.|Incurred AMT|Exception AMT|Discount AMT|Billable AMT|G/B|svr_id|cntr_cyc_no|dmdt_trf_cd|dmdt_chg_loc_div_cd|chg_seq|bzc_trf_seq|bzc_dmdt_de_term_cd|bzc_trf_grp_seq|cmdt_expt_amt";
                    var HeadTitle1 = "||Seq.|STS|CNTR No.|T/S|From Date|To Date|F/T CMNC|F/T End|F/T|Over|Cur.|Incurred AMT|Exception AMT|Discount AMT|Billable AMT|G/B|svr_id|cntr_cyc_no|dmdt_trf_cd|dmdt_chg_loc_div_cd|chg_seq|bzc_trf_seq|bzc_dmdt_de_term_cd|bzc_trf_grp_seq|cmdt_expt_amt";

                    var headCount = ComCountHeadTitle(HeadTitle);
                    var headCount1 = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
					InitHeadRow(1, HeadTitle1, true);
                    
					
                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,		DATAALIGN, COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,			daCenter,   true,       "ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,		40,			daCenter,	true,		"checkBox");
					InitDataProperty(0, cnt++ , dtSeq,			40,			daCenter,	true,		"seq");
					InitDataProperty(0, cnt++ , dtData,			30,			daCenter,	true,		"dmdt_chg_sts_cd",	false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			90,			daCenter,	true,		"cntr_no",			false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			30,			daCenter,	true,		"cntr_tpsz_cd",		false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			80,			daCenter,	true,		"fm_mvmt_dt",		false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			80,			daCenter,	true,		"to_mvmt_dt",		false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			80,			daCenter,	true,		"ft_cmnc_dt",		false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			80,			daCenter,	true,		"ft_end_dt",		false,		"",			dfNone,			0,		true,		true);
					
					InitDataProperty(0, cnt++ , dtData,			50,			daCenter,	true,		"ft_dys",			false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			50,			daCenter,	true,		"fx_ft_ovr_dys",	false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			40,			daCenter,	true,		"bzc_trf_curr_cd",	false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			90,			daRight,	true,		"org_chg_amt",		false,		"",			dfFloat,		2,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			90,			daRight,	true,		"expt_amt",			false,		"",			dfFloat,		2,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			90,			daRight,	true,		"aft_expt_dc_amt",	false,		"",			dfFloat,		2,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			80,			daRight,	true,		"bil_amt",			false,		"",			dfFloat,		2,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			50,			daCenter,	true,		"gb",				false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		100,		daCenter,	true,		"svr_id");
					InitDataProperty(0, cnt++ , dtHidden,		100,		daCenter,	true,		"cntr_cyc_no");

					InitDataProperty(0, cnt++ , dtHidden,		100,		daCenter,	true,		"dmdt_trf_cd");
					InitDataProperty(0, cnt++ , dtHidden,		100,		daCenter,	true,		"dmdt_chg_loc_div_cd");
					InitDataProperty(0, cnt++ , dtHidden,		100,		daCenter,	true,		"chg_seq");
					InitDataProperty(0, cnt++ , dtHidden,		100,		daCenter,	true,		"bzc_trf_seq");
					InitDataProperty(0, cnt++ , dtHidden,		100,		daCenter,	true,		"bzc_dmdt_de_term_cd");
					InitDataProperty(0, cnt++ , dtHidden,		100,		daCenter,	true,		"bzc_trf_grp_seq");
					InitDataProperty(0, cnt++ , dtHidden,		100,		daCenter,	true,		"cmdt_expt_amt");
					
                    FrozenCols = SaveNameCol("cntr_tpsz_cd");

					ToolTipOption = "balloon:true;width:50;";
					ToolTipText(0,"gb") = "General/Balance Charge Type";
					ToolTipText(1,"gb") = "General/Balance Charge Type";
					CountPosition = 0;

                    
                }
                break;            	
        }
    }
	
     // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
         	case IBSEARCH:      //조회
 				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
 				if (sheetObj.id == "sheet1") {
 					//ComOpenWait Start
 					sheetObj.WaitImageVisible=false;
 		        	ComOpenWait(true);
 		        	
 					if (ComGetObjValue(formObj.invoice_issue) == "1") {
 						setParameters(SEARCH);
 					}
 					
					//sheetObj.DoSearch("EES_DMT_3109GS.do", FormQueryString(formObj));
					var sXml = sheetObj.GetSearchXml("EES_DMT_3109GS.do", FormQueryString(formObj));
					sheetObj.LoadSearchXml(sXml);

					//ComOpenWait End
					ComOpenWait(false);

					if (ComGetObjValue(formObj.invoice_issue) == "2") {
						sheetObj.CheckAll2(1) = 1;
						// Grid 수정 불가 처리
						sheetObj.Editable = false;
					}
					else {
						sheetObj.CheckAll2(1) = 1;
					}
					
                    // ETC 조회결과를 Form 항목으로 바인딩 시켜줍니다.
					DmtComEtcDataToForm(formObj, sheetObj);
 				} 
 				else if (sheetObj.id == "sheet2") {
 					//ComOpenWait Start
 					sheetObj.WaitImageVisible=false;
 		        	ComOpenWait(true);
 		        	
 					setParameters(SEARCH02);
 					sheetObj.DoSearch("EES_DMT_4002GS.do", FormQueryString(formObj));
					ComSetObjValue(formObj.inv_xch_rt, sheetObj.EtcData("EX_RATE"));
					
					//ComOpenWait End
					ComOpenWait(false);
 				}
 				break;
 				
         	case IBSEARCH_ASYNC05:      //조회
         		//ComOpenWait Start
				sheetObj.WaitImageVisible=false;
	        	ComOpenWait(true);
         		formObj.f_cmd.value = SEARCH05;
         		sheetObjects[1].DoSearch4Post( "DMTCommonFaxEmailGS.do" , FormQueryString(formObj) );
         		//ComOpenWait End
				ComOpenWait(false);
         		break;

         	case IBSEARCH_ASYNC06:      //조회
	         	//ComOpenWait Start
				sheetObj.WaitImageVisible=false;
	        	ComOpenWait(true);
         		formObj.f_cmd.value = SEARCH06;
         		sheetObjects[1].DoSearch4Post( "DMTCommonFaxEmailGS.do" , FormQueryString(formObj) );
         		//ComOpenWait End
				ComOpenWait(false);
         		break;	 				
         		
         }
     }
     
     /**
 	 * Combo 기본 설정 
 	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 	 */ 
 	function initCombo(comboObj, comboNo) {
 	    var formObj = document.form
 	    
 	    switch(comboNo) { 
 	    	//Attention
 	    	case 1:
 	    		with (comboObj) {
// 					MultiSelect = false; 
// 					UseAutoComplete = false;	
// 					SetColAlign("left");        
// 					SetColWidth("150");
// 					DropHeight = 250;
// 					ValidChar(2,2);		//영문 대문자
 					MultiSelect = false;
					SetColAlign("left|left|left|left");
					//SetColWidth("|1|1|1|");
					DropHeight = 160;
 	    		}
 	    		break;
 	    	
 	     } 		
 	} 	
 	
 	/*
	 * 조회필드정보를 입력화면의 조회필드값으로 저장한다.
	 */		
	function setParameters(sAction) {
		var formObj = document.form;
		
		//Retrieve Setting
		ComSetObjValue(formObj.f_cmd, sAction);							//Command
		
	}
 
	function initAxonControl() {
		axon_event.addListener('mouseover', 'obj_mouseover', 'txt_aft_inv_adj_amt');	// onMouseover 이벤트
		axon_event.addListener('mouseout', 'obj_mouseout', 'txt_aft_inv_adj_amt');	// onMouseout 이벤트
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		axon_event.addListener('change',	'obj_change', 'ida_cgst_amt','ida_sgst_amt','ida_igst_amt','ida_ugst_amt');
		axon_event.addListenerFormat('focus',	'obj_focus',	form); //- 포커스 들어갈때
		axon_event.addListenerFormat('blur',	'obj_blur',		form); //- 포커스 나갈때
	}
	
    function obj_change() {
 		var obj = event.srcElement;
		var formObj = document.form;
		
		switch(obj.name) {
	    	case "ida_cgst_amt":
	    	case "ida_sgst_amt":
	    	case "ida_igst_amt":
			case "ida_ugst_amt":
				DmtComCalcInvAmtByCngTaxAmt(obj);		
				break;	
		}
	}
    
    /**
     * HTML Control Foucs in
     */
    function obj_focus(){
    	var obj = event.srcElement;
		ComClearSeparator(obj);
        
		//글자가 있는 경우 블럭으로 선택할수 있도록 한다.
		if (obj.getAttribute("isContentEditable") && obj.getAttribute("value") != null && obj.value.length >=1 ) {
			obj.select();
		}
    }	
    
    //포커스가 나갈 때
    function obj_blur() {
    	var formObj = document.form;
    	
    	//입력Validation 확인하기 + 마스크구분자 넣기
		var obj = event.srcElement;
		switch(obj.name) {
			case "payer_cd":
				var isValidation = DmtComDoActionText(sheetObjects[0], formObj, obj, SEARCH20);
				if (isValidation) {
					//팩스, 이메일 디폴트 값 셋팅 로직 추가 
					//Payer별 email, faxno를 조회한다.
					//parameter : payer_cd, ofc_cd  -- 세션 ofc_cd , dmdt_trf_cd 
					doActionIBCombo(sheetObjects[1], formObj, IBSEARCH, COMMAND02, "", "");
				}
				break;
			
			case "trucker_cd":
				DmtComDoActionText(sheetObjects[0], formObj, obj, SEARCHLIST04);
				break;
		}
    } 

    // (버튼 말풍선  보여줌)
	function obj_mouseover() {
 		var msg = '';
		var x = event.x+document.body.scrollLeft;
		var y = event.y+document.body.scrollTop;
		var skn = document.all("topdeck").style;

     	switch(event.srcElement.id){
	  		case 'txt_aft_inv_adj_amt':
	  			msg = 'Adjusted Billable AMT after the Invoice was issued';
	  			x = x;
	  			y = y-20;
	  			skn.left = x;
	  			skn.top  = y-20;
	  			break;
	  		
     	}
		
		var bak = 'lightyellow';
		var content =	"<TABLE BORDER=0 CELLPADDING=1 CELLSPACING=0 BGCOLOR=#000000><TR><TD><TABLE WIDTH=100% BORDER=0 CELLPADDING=2 CELLSPACING=0 BGCOLOR="+bak
   	 				+"><TR><TD style=font-family:tahoma;font-size:9pt;>"+msg+"</TD></TR></TABLE></TD></TR></TABLE>"; 
		document.all("topdeck").innerHTML = content;
		skn.visibility = 'visible';
    }
    
    // (버튼 말풍선 숨김)
	function obj_mouseout() {
		var skn = document.all("topdeck").style;
		skn.visibility = 'hidden';
	}
    
    /**
    * AR Currency 를 조회하는 함수
    */	
	function searchARCurrencyList() {
		var sheetObj = sheetObjects[1];
		var formObj = document.form;
	
		doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCHLIST05,"AR_CURRENCY");
	}
    
	// 조회조건필드인 Combo 데이터 조회
    function doActionIBCombo(sheetObj,formObj,sAction,sComboAction,sComboKey,sObj) {
        sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;

		switch(sAction) {
        	case IBSEARCH:      // 조회
				if (sheetObj.id == "sheet2") {
					
					//3.조회후 결과처리
					var comboDatas;
					var comboItems;
					
					switch(sComboAction) {

						//3-1.Currency 항목 조회
						case SEARCHLIST05:
							//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							var param = "f_cmd=" + SEARCHLIST05
							  + "&jspno=3109" 
							  + "&ofc_cd=" + formObj.session_ofc_cd.value
							  ; 
							
							//2.조회조건으로 조회실행					
							var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", param);
							
							ComClearCombo(formObj.inv_curr_cd);
							comboDatas = ComGetEtcData(sXml, sComboKey);
							if (comboDatas != undefined) {
								addComboItem(formObj.inv_curr_cd,comboDatas,true);
							}
							break;	
						
						//Payer별 Email, FAX 번호를 조회한다.
						case COMMAND02:
							//session ofc 사용하고 있음.
							//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							setComboParameters(sComboAction, sObj);
							
							//ofc_cd를 세션 값으로 치환.
							var preOfcCd = ComGetObjValue(formObj.ofc_cd);
							ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.session_ofc_cd));
							
							//2.조회조건으로 조회실행					
							var sXml = sheetObj.GetSearchXml("EES_DMT_4002GS.do", FormQueryString(formObj));
							
							//3.조회후 결과처리
							ComSetObjValue(formObj.payr_faxnos, 	ComGetEtcData(sXml, "FAX_NO"));
							ComSetObjValue(formObj.payr_emailnos, 	ComGetEtcData(sXml, "EMAIL_NO"));
							
							//조회 후 처리전 ofc_cd로 재조정.
							ComSetObjValue(formObj.ofc_cd, preOfcCd);
							break;		
					}
				};
                break;
        }
		sheetObj.WaitImageVisible = true;
    }
    
    /**
     * 콤보필드에 데이터를 추가해준다.
     */	
	function addComboItem(comboObj,comboDatas,isOnlyCode) {
		var comboItem;
		var comboItems;
		var val;
		var txt;
		if (comboDatas != undefined) {
			comboItems = comboDatas.split(ROWMARK);	
	    	for (var i = 0 ; i < comboItems.length ; i++) {
    			comboItem = comboItems[i].split(FIELDMARK);
				val = comboItem[0];
				txt = isOnlyCode ? comboItem[0] : comboItem[1];
				
				ComAddComboItem(comboObj,val,txt);
    		}
		}   		
	}
	
 	//Attention 선택 이벤트
 	function combo1_OnChange(comboObj, Index_Code, Text) {
 		
 		DmtComSetAttention();
 	}
 	
  	/*
 	 * 각 공통팝업창 호출 함수 
 	 */
 	function openPopup(flag, arg) {
 		
 		var sheetObj = sheetObjects[0];
 		var formObj	= document.form;
 		var sUrl	= '';
 		var sWidth	= '';
 		var sHeight	= '';
 		
 		with(sheetObj) {
	  		switch(flag) {
	  			case 'payer_cd':		// Customer Inquiry Popup
					ComOpenPopup('COM_ENS_041.do', 770, 470, "getCustCd", "1,0,1,1,1,1,1", true);
					break;
					
	  			case 'trucker_cd':
					ComOpenPopup('COM_ENS_0C1.do', 700, 450, "getSvcProvdr", "1,0,1,1,1,1,0", true);
	  				break;
	  				
	  			case 'payer_code_check':
	  				var returnValue = ComOpenPopup('EES_DMT_4109.do', 500, 150, "", "1,0,1,1,1,1,0", true);
	  				if (returnValue == "R") {
	  					ComSetObjValue(formObj.payer_cd, ComGetObjValue(formObj.h_payer_cd));
	  					ComSetObjValue(formObj.payer_nm, ComGetObjValue(formObj.h_payer_nm));

	  					// Payer 의 Attention 정보를 초기화해 줍니다.
	  					DmtComInitPayerAttention();
	  				}
  			    	// Payer 정보가 변경되면 Payer 에 해당되는 GST 정보 및 India Tax Ratio 를 조회해서 Invoice Amount 를 재계산합니다.
  			    	DmtComSearchIdaTaxRtoByPayer();
  			    	
	  				break;	  				
	  		} // switch-end
 		} // with-end
 		
 	}
 	 
    /*
 	 * Customer 공통팝업에서 선택한 Customer Code값을 해당 필드에 설정 
 	 */
	function getCustCd(aryPopupData) {
		var formObj 	= document.form;
		
		document.form.payer_cd.value = aryPopupData[0][3];
		document.form.payer_nm.value = aryPopupData[0][4];
   	
		// Payer 의 Attention 정보를 초기화해 줍니다.
		DmtComInitPayerAttention();	
		
    	// Payer 정보가 변경되면 Payer 에 해당되는 India Tax Ratio 를 조회해서 Invoice Amount 를 재계산합니다.
    	DmtComSearchIdaTaxRtoByPayer();
    	
		//팩스, 이메일 디폴트 값 셋팅 로직 추가 
		//Payer별 email, faxno를 조회한다.
		//parameter : payer_cd, ofc_cd  -- 세션 ofc_cd , dmdt_trf_cd 

		doActionIBCombo(sheetObjects[1], formObj, IBSEARCH, COMMAND02, "", "");
	}    
   
	/*
 	 * Service Provider Inquiry 공통팝업 호출
 	 */
	function getSvcProvdr(aryPopupData) {
		document.form.trucker_cd.value = aryPopupData[0][2];
		document.form.trucker_nm.value = aryPopupData[0][4]; //name값으로 수정
	}
 	 

    
    function setComboParameters(sComboAction, sObj) {
    	var formObj = document.form;
    	ComSetObjValue(formObj.curr_cd, ComGetObjValue(formObj.inv_curr_cd));
    	ComSetObjValue(formObj.f_cmd, sComboAction);
    }
    
    /**
 	 * IBSheet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
 	 */
	function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
		if(ErrMsg == '') {
			var formObj = document.form;
			var fCmd = formObj.f_cmd.value;
			
			if(fCmd == SEARCH) {
//				//check box All
//				sheetObj.CheckAll(1) = 1;
				sheetObj.CheckAll("checkBox") = 1;
				
				//btn
				DmtComEnableManyBtns(true,  "btn_set", "btn_option", "btn_close");
				DmtComEnableManyBtns(true, "btn_preview", "btn_print", "btn_fax", "btn_email", "btn_payerfaxemail");
				
			}
		}
	}
	
 	/**
      * Detail Sheet 클릭시 금액 계산
      * @param sheetObj
      * @param Row
      * @param Col
      * @param Value
      * @return
      */
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
 		var formObj = document.form;
 		
 		if (sheetObj.ColSaveName(Col) == "checkBox") {	//checkbox

 			DmtComCalcAmt(sheetObj, Row, Value);
			var iCnt = parseInt(ComGetObjValue(formObj.cntr_cnt));
			
			//CHECK BOX를 모두 해제 했을 경우 alert & 버튼 비활성화
 			if (iCnt == 0) {
 				ComShowCodeMessage('DMT00164');

 				DmtComEnableManyBtns(true,  "btn_set", "btn_option", "btn_close");
				DmtComEnableManyBtns(false, "btn_preview", "btn_print", "btn_fax", "btn_email", "btn_payerfaxemail");
 			} 
 			else {
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
    
 	/**
 	 * EES_DMT_3109, EES_DMT_3108 팝업 호출
 	 * @param sheetObj
 	 * @param formObj
 	 * @param srcName
 	 * @return
 	 */
 	function openPopupWindow(sheetObj, formObj, srcName) {
 		if(srcName == "btn_set") {
 			var url = "EES_DMT_4101.do"
 				+"?issoff="+ComGetObjValue(formObj.ofc_cd)
 				+"&tftp2="+ComGetObjValue(formObj.s_dmdt_trf_cd)
 				+"&sheetp=D"
 				+"&invoice_issue=1"
 				+"&jspno=EES_DMT_3109";
 			var returnValue = ComOpenWindowCenter(url, "EES_DMT_4101", "725","780", true, "yes");
 		} else if(srcName == "btn_option") {
 			var url = "EES_DMT_4103.do"
 				+"?issoff="+ComGetObjValue(formObj.ofc_cd)
 				+"&tftp="+ComGetObjValue(formObj.s_dmdt_trf_cd)
 				+"&invoice_issue=1"
 				+"&jspno=EES_DMT_3109";
 			var returnValue = ComOpenWindowCenter(url, "EES_DMT_4103", "625","650", true);
 		} else if(srcName == "btn_payerfaxemail") {
			var url = "EES_DMT_4104.do"
				+"?s_ofc_cd="+ComGetObjValue(formObj.session_ofc_cd) 
				+"&s_cust_cd="+ComGetObjValue(formObj.payer_cd)
				+"&s_bkg_no="+ComGetObjValue(formObj.bkg_no)
				+"&s_pod_cd="+ComGetObjValue(formObj.pod_cd)
				+"&jspno=EES_DMT_3109"
				+"&attn="+ComGetObjValue(formObj.dmdt_payr_cntc_pnt_nm)
				+"&telno="+ComGetObjValue(formObj.payr_cntc_pnt_phn_no)
				+"&faxno="+ComGetObjValue(formObj.payr_cntc_pnt_fax_no)
				+"&email="+ComGetObjValue(formObj.payr_cntc_pnt_eml)
			var returnValue = ComOpenWindowCenter(url, "EES_DMT_4104", "825","620", true);
		} else if(srcName == "btn_sendinghistory") {
			var url = "EES_DMT_7006_P.do"
				+"?jspno=EES_DMT_3109"
				+"&payerCd="+ComGetObjValue(formObj.payer_cd)
				+"&selectType=D"
				+"&selectOpt=2"
				;

			var returnValue = ComOpenWindowCenter(url, "EES_DMT_7006_P", "1036","690", true);
		} else if(srcName == "btn_fax") {
			if(ComGetObjValue(formObj.payer_cd) == null || ComGetObjValue(formObj.payer_cd) == "") {
				ComShowCodeMessage("DMT00182");
				return;
			}
			var ofc_cd = ComGetObjValue(formObj.session_ofc_cd);

			var url = "EES_DMT_4107.do"
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
				+"&s_bkg_no="+ComGetObjValue(formObj.bkg_no)
				+"&s_pod_cd="+ComGetObjValue(formObj.pod_cd)
				+"&jspno=3109"
				+"&telno="+ComGetObjValue(formObj.payr_cntc_pnt_phn_no)
				+"&faxno="+ComGetObjValue(formObj.payr_cntc_pnt_fax_no)
				+"&email="+ComGetObjValue(formObj.payr_cntc_pnt_eml)
				+"&cntc_seq="//
				;
			ComOpenWindowCenter(url, "EES_DMT_4108", "500","300", true);
		}
 	} 	
/////////////////////////////////////////////////////////////////////////////////////
 	/**
 	 * SheetOption 팝업화면에서 변경시 자동변경 처리하는 로직임(Due Date, Credit Term, Tax Rate)
 	 */
 	function getSheetOptionData(cr_term_dys, is_dt_prn_flg, tax_rto) {
 		var formObj = document.form;
 		if (tax_rto == null || tax_rto == "") {
 			tax_rto = "0";
 		}
 		//tax_rto
 		ComSetObjValue(formObj.tax_rto, tax_rto);
 		//
 		if (formObj.chk_tax.checked) {
 			ComSetObjValue(formObj.tax_rto_dis, ComGetObjValue(formObj.tax_rto));
 			//tax calculate
 			DmtComCalcInvAmtByTaxAmt();
 		}
 	} 	 
 	
	/**
	 * PayerInfo 팝업화면에서 변경시 자동변경 처리됨
	 */
	function getPayerInfoData(fax_nos, email_nos, cntc_pnt_nm, cntc_pnt_seq){
		var formObj = document.form;
		
		ComSetObjValue(formObj.payr_faxnos, 			fax_nos);
		ComSetObjValue(formObj.payr_emailnos, 			email_nos);
		ComSetObjValue(formObj.dmdt_payr_cntc_pnt_nm, 	cntc_pnt_nm);
		ComSetObjValue(formObj.cust_cntc_pnt_seq, 		cntc_pnt_seq);
		
		// Payer 의 Attention 정보를 초기화해 줍니다.
		DmtComInitPayerAttention();	
	} 	
	
	/* 개발자 작업  끝 */