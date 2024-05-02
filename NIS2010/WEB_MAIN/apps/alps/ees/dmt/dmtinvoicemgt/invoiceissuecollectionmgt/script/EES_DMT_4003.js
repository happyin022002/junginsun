/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_4003.js
*@FileTitle : Invoice Issue Preview
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : 김태균
*@LastVersion : 1.0 
* 2009.09.11 김태균
* 1.0 최초 생성 
* 2011.10.19 황효근 [CHM-201114001-01] [DMT] DMT Invoice의 e-mail 전송 본문을 Portugal언어로 전환 요청
* 2011.11.09 권   민 [CHM-201114143] [DMT] Manual Invoice with no detail 조건의 Print Preview 개발
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
     * @class EES_DMT_4003 : EES_DMT_4003 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_4003() {
    	this.processButtonClick		= tprocessButtonClick;
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

	var comboObjects = new Array();
	var comboCnt = 0;
	
	var rdObjects = new Array();
	var rdCnt = 0;
	var queryStr = "";

	var ROWMARK = "|";
	var FIELDMARK = "=";
	var IBFAXSEND	= 53;
	var IBEMAILSEND	= 54;
	
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	 
    	var sheetObject1 = sheetObjects[0];
 
    	var srcObj = window.event.srcElement;
    	/*******************************************************/
        var formObject = document.form;
        var rdObject = rdObjects[0];

    	
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

				case "btn_print":
					if (ComGetObjValue(formObject.has_sheetset) != "Y") {
						ComShowCodeMessage("DMT01096");
						return;
					}
					rdObject.PrintDialog();
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
    function loadPage(){
    	var opener = window.dialogArguments;
    	var cntc_pnt_nm = "";
    	
    	for (i=0;i<sheetObjects.length;i++) {
        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);

        }
    	
    	if (ComGetObjValue(document.form.jspno) == "4002") {
    		cntc_pnt_nm = opener.document.form.org_dmdt_payr_cntc_pnt_nm.value;
    		ComSetObjValue(document.form.act_payr_cust_nm, opener.document.form.act_payr_cust_nm.value);
    	}
    	else if (ComGetObjValue(document.form.jspno) == "4004") {
    		cntc_pnt_nm = opener.document.form.org_dmdt_payr_cntc_pnt_nm.value;
    		ComSetObjValue(document.form.act_payr_cust_nm, opener.document.form.act_payr_cust_nm2.value);
    	}
    	else if (ComGetObjValue(document.form.jspno) == "4016") {
    		cntc_pnt_nm = opener.document.form2.org_dmdt_payr_cntc_pnt_nm.value;
    		ComSetObjValue(document.form.act_payr_cust_nm, opener.document.form2.act_payr_cust_nm.value);
    	}
    	
    	ComSetObjValue(document.form.dmdt_payr_cntc_pnt_nm, cntc_pnt_nm);
    	
    	
    	//RD
    	rdOpen(rdObjects[0], document.form, sheetObjects[0]);
    	
    	//Sheet Set 있는지 없는지 조회한다.
		//Sheet Set가 없을 경우에는 Preview, Print, Fax send, Email send를 버튼 클릭시 Alert MSG을 띄워 막고자 합니다
		doActionIBCombo(sheetObjects[0],document.form,IBSEARCH,COMMAND13,"RESULT","");		
    }    

    function rdOpen(rdObject,formObj,sheetObj){
    	var Rdviewer = rdObject ;

        Rdviewer.AutoAdjust = true;
        Rdviewer.HideStatusbar();
        Rdviewer.ViewShowMode(0);
                
        Rdviewer.SetPageLineColor(255,255,255);         
    	
    	var path = formObj.mrd.value;		//mrd_path
		
    	//MASTER DATA 조회
    	ComSetObjValue(formObj.f_cmd, SEARCH01);	
		var sXml =  sheetObj.GetSearchXml("EES_DMT_4003GS.do",	FormQueryString(formObj));
		sheetObj.LoadSearchXml(sXml);
		
		ComEtcDataToForm(formObj, sheetObj);
		
		//RD 호출
		var rdParm =  "/ruseurlmoniker [0]" + " /rfn [" + RDServerIP + "/EES_DMT_4003_RD.do] "		//DETAIL DATA 조회
					+ " /rv " + rvParmByInvoice(formObj)
					+ " /rpost [jspno=" + ComGetObjValue(formObj.jspno) + "&invoice_no="+ComGetObjValue(formObj.invoice_no)+"&cre_ofc_cd="+ComGetObjValue(formObj.cre_ofc_cd)+"]"		//jspno, invoice_no
					;
//		ComDebug(rdParm);
		
		var pdf_name = "INVOICE_" + ComGetObjValue(formObj.invoice_no);
		//BSTR szPath, BSTR szName, BSTR szExtList, BSTR szDefaultExt
		Rdviewer.SetSaveDialogEx("c:\\", pdf_name, "pdf", "pdf");
		
		
		Rdviewer.FileOpen(RD_path+path, rdParm);
		
		//Rdviewer.DisableToolbar (0);
		Rdviewer.DisableToolbar (13);
		Rdviewer.DisableToolbar (14);
		Rdviewer.DisableToolbar (15);
		Rdviewer.DisableToolbar (16);
		Rdviewer.DisableToolbar (17);
    }    
    
    /**
     * rv By Invoice 
     */ 
    function rvParmByInvoice(formObj) {
    	/////////////////////////////////////////////////////////////////////////////////////
		//Address1,Address2,Address3,Address4 쪼개기
		var payrAddrs = ComGetObjValue(formObj.rd_payr_addr);
		var rd_payr_addr01 = "";
		var rd_payr_addr02 = "";
		var rd_payr_addr03 = "";
		var rd_payr_addr04 = "";
		
        var paryInfoAddr = payrAddrs.split("\n");
        var paryInfoAddrCnt = paryInfoAddr.length;
        
        if ( paryInfoAddrCnt >= 1 ) {
        	rd_payr_addr01 = paryInfoAddr[0];
        } 
        else {
        	rd_payr_addr01 = "";
        }
        
        if ( paryInfoAddrCnt >= 2 ) {
        	rd_payr_addr02 = paryInfoAddr[1];
        } 
        else {
        	rd_payr_addr02 = "";
        }
        
        if ( paryInfoAddrCnt >= 3 ) {
        	rd_payr_addr03 = paryInfoAddr[2];
        } 
        else {
        	rd_payr_addr03 = "";
        }
        
        if ( paryInfoAddrCnt >= 4 ) {
        	rd_payr_addr04 = paryInfoAddr[3];
        } 
        else {
        	rd_payr_addr04 = "";
        }
        
        /////////////////////////////////////////////////////////////////////////////////////    	
    	
    	var	rvRaram =" RD_SH_ADDR1[" + ComGetObjValue(formObj.rd_sh_addr1) +"]" +
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
					" RD_TAX_RGST_NO["          + ComGetObjValue(formObj.rd_tax_rgst_no)          + "]" +
					" RD_SVC_CATE_RMK["         + ComGetObjValue(formObj.rd_svc_cate_rmk)         + "]" +
					" RD_PMNT_ACCT_NO["         + ComGetObjValue(formObj.rd_pmnt_acct_no)         + "]" +
					" RD_IDA_EXPN_TAX_RT["      + ComGetObjValue(formObj.rd_ida_expn_tax_rt)      + "]" +
					" RD_IDA_EXPN_TAX["         + ComGetObjValue(formObj.rd_ida_expn_tax)         + "]" +
					" RD_IDA_EDU_TAX_RT["       + ComGetObjValue(formObj.rd_ida_edu_tax_rt)       + "]" +
					" RD_IDA_EDU_TAX["          + ComGetObjValue(formObj.rd_ida_edu_tax)          + "]" +
					" RD_IDA_HIGH_EDU_TAX_RT["  + ComGetObjValue(formObj.rd_ida_high_edu_tax_rt)  + "]" +
					" RD_IDA_HIGH_EDU_TAX["     + ComGetObjValue(formObj.rd_ida_high_edu_tax)     + "]" +
					// SBC ( Swacha Bharat Cess )
					" RD_IDA_LOCL_TAX_RT["      + ComGetObjValue(formObj.rd_ida_locl_tax_rt)      + "]" +
					" RD_IDA_LOCL_TAX["         + ComGetObjValue(formObj.rd_ida_locl_tax)         + "]" +
					// KCC ( Krishi Kalyan Cess )
					" RD_IDA_N2ND_LOCL_TAX_RT[" + ComGetObjValue(formObj.rd_ida_n2nd_locl_tax_rt) + "]" +
					" RD_IDA_N2ND_LOCL_TAX["    + ComGetObjValue(formObj.rd_ida_n2nd_locl_tax)    + "]" +
					" RD_IDA_TAX_APPL_TM["      + ComGetObjValue(formObj.rd_ida_tax_appl_tm)      + "]" + 
					" RD_IDA_CGST_RTO["         + ComGetObjValue(formObj.rd_ida_cgst_rto)         + "]" + 
					" RD_IDA_CGST_AMT["         + ComGetObjValue(formObj.rd_ida_cgst_amt)         + "]" + 
					" RD_IDA_SGST_RTO["         + ComGetObjValue(formObj.rd_ida_sgst_rto)         + "]" + 
					" RD_IDA_SGST_AMT["         + ComGetObjValue(formObj.rd_ida_sgst_amt)         + "]" + 
					" RD_IDA_IGST_RTO["         + ComGetObjValue(formObj.rd_ida_igst_rto)         + "]" + 
					" RD_IDA_IGST_AMT["         + ComGetObjValue(formObj.rd_ida_igst_amt)         + "]" + 
					" RD_IDA_UGST_RTO["         + ComGetObjValue(formObj.rd_ida_ugst_rto)         + "]" + 
					" RD_IDA_UGST_AMT["         + ComGetObjValue(formObj.rd_ida_ugst_amt)         + "]" +
					" RD_BANK_ACCT_NO["         + ComGetObjValue(formObj.rd_ida_bank_acct_no)     + "]" +
					" RD_BANK_IFSC_CD["         + ComGetObjValue(formObj.rd_ida_bank_ifsc_cd)     + "]" + 
					" RD_IDA_GST_RGST_NO["      + ComGetObjValue(formObj.rd_ida_gst_rgst_no)      + "]" +
					" RD_IDA_STE_CD["           + ComGetObjValue(formObj.rd_ida_ste_cd)           + "]" +
					" RD_IDA_STE_NM["           + ComGetObjValue(formObj.rd_ida_ste_nm)           + "]" +
					" RD_IDA_SAC_CD["           + ComGetObjValue(formObj.rd_ida_sac_cd)           + "]" +
					" RD_IDA_TAX_CIN["          + ComGetObjValue(formObj.rd_ida_tax_cin)          + "]" + 
					" RD_IDA_OFC_STE_CD["       + ComGetObjValue(formObj.rd_ida_ofc_ste_cd)       + "]" +
					" RD_IDA_OFC_STE_NM["       + ComGetObjValue(formObj.rd_ida_ofc_ste_nm)       + "]";
    	
    	return rvRaram;
    }    
   
    
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
	        case 1:
		        with (sheetObj) {
		            // 높이 설정
		            style.height = 102;
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
		
		            var HeadTitle  = "|";
                    var headCount = ComCountHeadTitle(HeadTitle);
		
		            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		            InitColumnInfo(headCount, 0, 0, true);
		
		            // 해더에서 처리할 수 있는 각종 기능을 설정한다
		            InitHeadMode(true, true, true, true, false,false)
		
		            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		            InitHeadRow(0, HeadTitle, true);
		            InitDataProperty(0, cnt++ , dtData,			30,			daCenter,	true,		"cntr_tpsz_cd",		false,		"",			dfNone,			0,		false,		true);
		
					CountPosition = 0;
		        }
		        break;

        }
    }    
    
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

    	case IBFAXSEND:
    		var opener_obj = window.dialogArguments;
    		
    		var mrd_file	= "";

    		//MRD 파일
    		var temp_LR 			= ComGetObjValue(formObj.invoice_LR);
    		var temp_incCntrDtail	= ComGetObjValue(formObj.inc_cntr_dtail);
    		var rhq    = ComGetObjValue(formObj.rhq_ofc_cd);
    		var ofc_cd = ComGetObjValue(formObj.cre_ofc_cd);
    		var cre_cnt_cd = ComGetObjValue(formObj.cre_cnt_cd);
    		var inv_new_rpt_flg = ComGetObjValue(formObj.inv_new_rpt_flg);
    		
    		if (temp_LR == "") {
    			if (temp_incCntrDtail == "N") {
    				if (cre_cnt_cd == "IN") {
    				   mrd_file = "EES_DMT_4914.mrd";
    				}
    				/* 2017.04.11 수정요청:PREVIEW 와 INV PRINT 동일한 RD 문서를 사용하도록 요청함.(박경문대리)
    				else if (cre_cnt_cd == "MY" && inv_new_rpt_flg == "Y") {
     				   mrd_file = "EES_DMT_4918.mrd";
    			    }
    			    */
    				else {
    				     mrd_file = "EES_DMT_4908.mrd";
    			    }     
    			}
    			else {
    				//if(rhq == "HAMRU"){
    				// RHQ 기중에서  특정 Office로 변경됨. 2012.01.11	
    				if (ofc_cd == "ANRSO" ||ofc_cd == "HAMSC"||ofc_cd == "LEHSC"||ofc_cd == "PRGSC"||ofc_cd == "RTMSC") {
    				   mrd_file = "EES_DMT_4910.mrd";	
    				}
    				else {
        				if (cre_cnt_cd == "IN") {
         				    mrd_file = "EES_DMT_4912.mrd";
        				}
        				/* 2017.04.11 수정요청:PREVIEW 와 INV PRINT 동일한 RD 문서를 사용하도록 요청함.(박경문대리)
        				else if (cre_cnt_cd == "MY" && inv_new_rpt_flg == "Y") {
          				    mrd_file = "EES_DMT_4916.mrd";
         			    }
         			    */
        				else {
    				        mrd_file = "EES_DMT_4901.mrd";		//L
         			    }
    				}
    			}
     		}
    		else if (temp_LR == "L") {
     			if (temp_incCntrDtail == "N") {
       				if (cre_cnt_cd == "IN") {
      				   mrd_file = "EES_DMT_4914.mrd";
    				}
       				/* 2017.04.11 수정요청:PREVIEW 와 INV PRINT 동일한 RD 문서를 사용하도록 요청함.(박경문대리)
       				else if (cre_cnt_cd == "MY" && inv_new_rpt_flg == "Y") {
       				   mrd_file = "EES_DMT_4918.mrd";
      			    }
      			    */
       				else {
    				   mrd_file = "EES_DMT_4908.mrd";
      			    }
    			}
     			else {
    			   //if(rhq == "HAMRU"){
        		   // RHQ 기중에서  특정 Office로 변경됨. 2012.01.11	
    				if (ofc_cd == "ANRSO" ||ofc_cd == "HAMSC"||ofc_cd == "LEHSC"||ofc_cd == "PRGSC"||ofc_cd == "RTMSC") {
    					mrd_file = "EES_DMT_4910.mrd";	
     				}
    				else {
     	   				if (cre_cnt_cd == "IN") {
          				   mrd_file = "EES_DMT_4912.mrd";
        				}
     	   				/* 2017.04.11 수정요청:PREVIEW 와 INV PRINT 동일한 RD 문서를 사용하도록 요청함.(박경문대리)
     	   				else if (cre_cnt_cd == "MY" && inv_new_rpt_flg == "Y") {
           				    mrd_file = "EES_DMT_4916.mrd";
          			    }
          			    */
     	   				else {
     				       mrd_file = "EES_DMT_4901.mrd";		//L
          			    }
     				}
    			}
     		}
    		else if (temp_LR == "R") {
     			if (temp_incCntrDtail == "N") {
 	   				if (cre_cnt_cd == "IN") {
       				   mrd_file = "EES_DMT_4915.mrd";
    				}
 	   				/* 2017.04.11 수정요청:PREVIEW 와 INV PRINT 동일한 RD 문서를 사용하도록 요청함.(박경문대리)
 	   				else if (cre_cnt_cd == "MY" && inv_new_rpt_flg == "Y") {
       				   mrd_file = "EES_DMT_4919.mrd";
       			    }
       			    */
 	   				else {
    				   mrd_file = "EES_DMT_4909.mrd";
       			    }
    			}
     			else {
    				//if(rhq == "HAMRU"){
    	        	// RHQ 기중에서  특정 Office로 변경됨. 2012.01.11
    				if (ofc_cd == "ANRSO" ||ofc_cd == "HAMSC"||ofc_cd == "LEHSC"||ofc_cd == "PRGSC"||ofc_cd == "RTMSC") {
					   mrd_file = "EES_DMT_4911.mrd";	
     				}
    				else {
     	   			  if (cre_cnt_cd == "IN") {
           				  mrd_file = "EES_DMT_4913.mrd";
     	   			  }
     	   			  /* 2017.04.11 수정요청:PREVIEW 와 INV PRINT 동일한 RD 문서를 사용하도록 요청함.(박경문대리)
     	   			  else if (cre_cnt_cd == "MY" && inv_new_rpt_flg == "Y") {
        			      mrd_file = "EES_DMT_4917.mrd";
           			  }
           			  */
     	   			  else {
     	   				  mrd_file = "EES_DMT_4902.mrd";		//R
           			  }
     				}   
    			}
     		}

    		//rd_fxeml_rd_param
    		var rdParm =  "/ruseurlmoniker [0]" + " /rfn [" + RDServerIP + "/EES_DMT_4003_RD.do] "		//DETAIL DATA 조회
						+ " /rv " + rvParmByInvoice(formObj)
						+ " /rpost [jspno=" + ComGetObjValue(formObj.jspno) + "&invoice_no="+ComGetObjValue(formObj.invoice_no)+"&cre_ofc_cd="+ComGetObjValue(formObj.cre_ofc_cd)+"]"		//jspno, invoice_no
						;

       		// 2011.10.19 수정
    		var emlTitle;
       		var emlTemplt;
       		
       		if (ComGetObjValue(formObj.session_ofc_cd) != 'SAOSC') {
       			emlTitle = "Invoice Number: " + ComGetObjValue(formObj.invoice_no) + " (B/L No.: SMLM" + ComGetObjValue(formObj.bl_no) + ")";
       			emlTemplt = "EES_DMT_INVOICE_001.html";
       		} 
       		else {
       			emlTitle = "Fatura de Demurrage No: " + ComGetObjValue(formObj.invoice_no) + " (Conhecimento de Embarque: SMLM" + ComGetObjValue(formObj.bl_no) + ")";
       			emlTemplt = "EES_DMT_INVOICE_002.html";
       		}
			
    		ComSetObjValue(formObj.invno,					ComGetObjValue(formObj.invoice_no));
    		ComSetObjValue(formObj.payc,					ComGetObjValue(formObj.payer_cd));
    		ComSetObjValue(formObj.rd_fxeml_sys_cd,			"DMT");
			ComSetObjValue(formObj.rd_fxeml_file_name,		mrd_file);
			ComSetObjValue(formObj.rd_fxeml_bat_flg,		"N");
			ComSetObjValue(formObj.rd_fxeml_title,			emlTitle);
			ComSetObjValue(formObj.rd_fxeml_rd_param,		rdParm);
			ComSetObjValue(formObj.rd_fxeml_fax_sndr_id,	"SM Line");					//sndr_id
			ComSetObjValue(formObj.rd_fxeml_eml_sndr_nm,	"SM Line");				//sndr_name
			//ComSetObjValue(formObj.rd_fxeml_eml_sndr_add,	sndr_email);		//sndr_email
			ComSetObjValue(formObj.rd_fxeml_eml_rcvr_add,	"");	//rcvr_email	//mjchang@hanjin.com
			ComSetObjValue(formObj.rd_fxeml_eml_atch_file,	ComGetObjValue(formObj.invoice_no));
			ComSetObjValue(formObj.rd_fxeml_eml_templt,		emlTemplt);// 템플릿 위치 C:/sitectx/ALPS\APP-INF/config/template/mailtemplate/template.htmlmail
			ComSetObjValue(formObj.rd_fxeml_eml_tmplt_param,"inv_no;" + ComGetObjValue(formObj.invoice_no) + "|bl_no;" + ComGetObjValue(formObj.bl_no) + "|payer_nm;" + ComGetObjValue(formObj.act_payr_cust_nm));
			ComSetObjValue(formObj.rd_fxeml_doc_tp,			"I");	//  I : Invoice D : Demend G : GroupDemand O : OTS

    		break;
    		
    	case IBEMAILSEND:
    		var mrd_file	= "";
    		
    		//MRD 파일
    		var temp_LR 	= ComGetObjValue(formObj.invoice_LR);
    		var temp_incCntrDtail	= ComGetObjValue(formObj.inc_cntr_dtail);
    		var rhq	= ComGetObjValue(formObj.rhq_ofc_cd);
    		var ofc_cd = ComGetObjValue(formObj.cre_ofc_cd);
    		var cre_cnt_cd = ComGetObjValue(formObj.cre_cnt_cd);
    		var inv_new_rpt_flg = ComGetObjValue(formObj.inv_new_rpt_flg);
    		
    		if (temp_LR == "") {
    			if (temp_incCntrDtail == "N") {
    				if (cre_cnt_cd == "IN") {
     				   mrd_file = "EES_DMT_4914.mrd";
    				}
    				/* 2017.04.11 수정요청:PREVIEW 와 INV PRINT 동일한 RD 문서를 사용하도록 요청함.(박경문대리)
    				else if (cre_cnt_cd == "MY" && inv_new_rpt_flg == "Y") {
      				   mrd_file = "EES_DMT_4918.mrd";
     			    }
     			    */
    				else {
     			    	mrd_file = "EES_DMT_4908.mrd";
     			    }
    			}
    			else {
    				// if(rhq == "HAMRU"){
        			// RHQ 기중에서  특정 Office로 변경됨. 2012.01.11
    				if (ofc_cd == "ANRSO" ||ofc_cd == "HAMSC"||ofc_cd == "LEHSC"||ofc_cd == "PRGSC"||ofc_cd == "RTMSC") {
      				   mrd_file = "EES_DMT_4910.mrd";	
      				}
    				else {
      					if (cre_cnt_cd == "IN") {
          				   mrd_file = "EES_DMT_4912.mrd";
        				}
      					/* 2017.04.11 수정요청:PREVIEW 와 INV PRINT 동일한 RD 문서를 사용하도록 요청함.(박경문대리)
      					else if (cre_cnt_cd == "MY" && inv_new_rpt_flg == "Y") {
           				    mrd_file = "EES_DMT_4916.mrd";
          			    }
          			    */
      					else {
          			    	mrd_file = "EES_DMT_4901.mrd";		//L
          			    }
      				}
    			}
     		}
    		else if (temp_LR == "L") {
     			if (temp_incCntrDtail == "N") {
     				if (cre_cnt_cd == "IN") {
     				   mrd_file = "EES_DMT_4914.mrd";
    				}
     				/* 2017.04.11 수정요청:PREVIEW 와 INV PRINT 동일한 RD 문서를 사용하도록 요청함.(박경문대리)
     				else if (cre_cnt_cd == "MY" && inv_new_rpt_flg == "Y") {
      				   mrd_file = "EES_DMT_4918.mrd";
     			    }
     			    */
     				else {
     			    	mrd_file = "EES_DMT_4908.mrd";
     			    }
    			}
     			else {
    				//if(rhq == "HAMRU"){
            		// RHQ 기중에서  특정 Office로 변경됨. 2012.01.11	
    				if (ofc_cd == "ANRSO" ||ofc_cd == "HAMSC"||ofc_cd == "LEHSC"||ofc_cd == "PRGSC"||ofc_cd == "RTMSC") {
      				   mrd_file = "EES_DMT_4910.mrd";	
      				}
    				else {
      					if (cre_cnt_cd == "IN") {
          				   mrd_file = "EES_DMT_4912.mrd";
        				}
      					/* 2017.04.11 수정요청:PREVIEW 와 INV PRINT 동일한 RD 문서를 사용하도록 요청함.(박경문대리)
      					else if (cre_cnt_cd == "MY" && inv_new_rpt_flg == "Y") {
           				    mrd_file = "EES_DMT_4916.mrd";
          			    }
          			    */
      					else {
          			    	mrd_file = "EES_DMT_4901.mrd";		//L
          			    }
      				}
    			}
     		}
    		else if (temp_LR == "R") {
     			if (temp_incCntrDtail == "N") {
     				if (cre_cnt_cd == "IN"){
     				   mrd_file = "EES_DMT_4915.mrd";
    				}
     				/* 2017.04.11 수정요청:PREVIEW 와 INV PRINT 동일한 RD 문서를 사용하도록 요청함.(박경문대리)
     				else if (cre_cnt_cd == "MY" && inv_new_rpt_flg == "Y") {
        				   mrd_file = "EES_DMT_4919.mrd";
     			    }
     			    */
     				else {
     			    	mrd_file = "EES_DMT_4909.mrd";
     			    }
    			}
     			else {
    				//if(rhq == "HAMRU"){
            		// RHQ 기중에서  특정 Office로 변경됨. 2012.01.11	
    				if (ofc_cd == "ANRSO" ||ofc_cd == "HAMSC"||ofc_cd == "LEHSC"||ofc_cd == "PRGSC"||ofc_cd == "RTMSC") {
      				   mrd_file = "EES_DMT_4911.mrd";	
      				}
    				else {
      					if (cre_cnt_cd == "IN") {
         				   mrd_file = "EES_DMT_4913.mrd";
          				}
      					/* 2017.04.11 수정요청:PREVIEW 와 INV PRINT 동일한 RD 문서를 사용하도록 요청함.(박경문대리)
      					else if (cre_cnt_cd == "MY" && inv_new_rpt_flg == "Y") {
         				    mrd_file = "EES_DMT_4917.mrd";
         			    }
         			    */
      					else {
         			    	mrd_file = "EES_DMT_4902.mrd";		//R
         			    }
      				}
    			}
     		}
    		
    		//rd_fxeml_rd_param
    		var rdParm =  "/ruseurlmoniker [0]" + " /rfn [" + RDServerIP + "/EES_DMT_4003_RD.do] "		//DETAIL DATA 조회
						+ " /rv " + rvParmByInvoice(formObj)
						+ " /rpost [jspno=" + ComGetObjValue(formObj.jspno) + "&invoice_no="+ComGetObjValue(formObj.invoice_no)+"&cre_ofc_cd="+ComGetObjValue(formObj.cre_ofc_cd)+"]"		//jspno, invoice_no
						;

    		// 2011.10.19 수정
    		var emlTitle;
       		var emlTemplt;
       		
       		if (ComGetObjValue(formObj.session_ofc_cd) != 'SAOSC') {
       			emlTitle = "Invoice Number: " + ComGetObjValue(formObj.invoice_no) + " (B/L No.: SMLM" + ComGetObjValue(formObj.bl_no) + ")";
       			emlTemplt = "EES_DMT_INVOICE_001.html";
       		} 
       		else {
       			emlTitle = "Fatura de Demurrage No: " + ComGetObjValue(formObj.invoice_no) + " (Conhecimento de Embarque: SMLM" + ComGetObjValue(formObj.bl_no) + ")";
       			emlTemplt = "EES_DMT_INVOICE_002.html";
       		} 

    		ComSetObjValue(formObj.invno,					ComGetObjValue(formObj.invoice_no));
    		ComSetObjValue(formObj.payc,					ComGetObjValue(formObj.payer_cd));
    		ComSetObjValue(formObj.rd_fxeml_sys_cd,			"DMT");
			ComSetObjValue(formObj.rd_fxeml_file_name,		mrd_file);
			ComSetObjValue(formObj.rd_fxeml_bat_flg,		"N");
			ComSetObjValue(formObj.rd_fxeml_title,			emlTitle);
			ComSetObjValue(formObj.rd_fxeml_rd_param,		rdParm);
			ComSetObjValue(formObj.rd_fxeml_fax_no,			"");			//rcvr_fax_no
			ComSetObjValue(formObj.rd_fxeml_fax_sndr_id,	"SM Line");					//sndr_id
			ComSetObjValue(formObj.rd_fxeml_eml_sndr_nm,	"SM Line");				//sndr_name
			ComSetObjValue(formObj.rd_fxeml_eml_atch_file,	ComGetObjValue(formObj.invoice_no));
			ComSetObjValue(formObj.rd_fxeml_eml_templt,		emlTemplt);// 템플릿 위치 C:/sitectx/ALPS\APP-INF/config/template/mailtemplate/template.htmlmail
			ComSetObjValue(formObj.rd_fxeml_eml_tmplt_param,"inv_no;" + ComGetObjValue(formObj.invoice_no) + "|bl_no;" + ComGetObjValue(formObj.bl_no) + "|payer_nm;" + ComGetObjValue(formObj.act_payr_cust_nm));
			ComSetObjValue(formObj.rd_fxeml_doc_tp,	"I");	//  I : Invoice D : Demend G : GroupDemand O : OTS
    		
    		break;        
        }
    }
        
    
    /**
	 * EES_DMT_4101, EES_DMT_4103 팝업 호출
	 * @param formObj
	 * @param srcName
	 * @return
	 */
	function openPopupWindow(formObj, srcName) {
		var opener = window.dialogArguments;

		if (srcName == "btn_fax") {
			if(ComGetObjValue(formObj.payer_cd) == null || ComGetObjValue(formObj.payer_cd) == "") {
				ComShowCodeMessage("DMT00182");
				return;
			}
			var ofc_cd = ComGetObjValue(formObj.cre_ofc_cd);
			var cust_cntc_pnt_seq = "";
			if(ComGetObjValue(document.form.jspno) == "4002") {
				cust_cntc_pnt_seq = opener.document.form.cust_cntc_pnt_seq.value;
	    	}
	    	else if(ComGetObjValue(document.form.jspno) == "4004") {
	    		cust_cntc_pnt_seq = opener.document.form.cust_cntc_pnt_seq.value;
	    	}
	    	else if(ComGetObjValue(document.form.jspno) == "4016") {
	    		cust_cntc_pnt_seq = opener.document.form2.cust_cntc_pnt_seq.value;
	    	}

			var url = "EES_DMT_4107.do"
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
			ComOpenWindowCenter(url, "EES_DMT_4107", "500","300", true);
		}
		else if(srcName == "btn_email") {
			if (ComGetObjValue(formObj.payer_cd) == null || ComGetObjValue(formObj.payer_cd) == "") {
				ComShowCodeMessage("DMT00182");
				return;
			}
			var ofc_cd = ComGetObjValue(formObj.cre_ofc_cd);
			var cust_cntc_pnt_seq = "";
			if(ComGetObjValue(document.form.jspno) == "4002") {
				cust_cntc_pnt_seq = opener.document.form.cust_cntc_pnt_seq.value;
	    	}
	    	else if(ComGetObjValue(document.form.jspno) == "4004") {
	    		cust_cntc_pnt_seq = opener.document.form.cust_cntc_pnt_seq.value;
	    	}
	    	else if(ComGetObjValue(document.form.jspno) == "4016") {
	    		cust_cntc_pnt_seq = opener.document.form2.cust_cntc_pnt_seq.value;
	    	}

			var url = "EES_DMT_4108.do"
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
			ComOpenWindowCenter(url, "EES_DMT_4108", "500","300", true);
		}
	}   

	// 조회조건필드인 Combo 데이터 조회
    function doActionIBCombo(sheetObj,formObj,sAction,sComboAction,sComboKey,sObj) {
        sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;

		switch(sAction) {
        	case IBSEARCH:      // 조회
				if (sheetObj.id == "sheet1") {
					switch(sComboAction) {
						//SHEET SET 이 존재하는지 조회
						case COMMAND13:
							//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							ComSetObjValue(formObj.f_cmd, COMMAND13);
							setComboParameters(sComboAction, sObj);
							
							//2.조회조건으로 조회실행					
							var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
							
							//3.조회후 결과처리
							ComSetObjValue(formObj.has_sheetset, 	ComGetEtcData(sXml, "RESULT"));
							break;
							
					}
					
				};
                break;
        }
		sheetObj.WaitImageVisible = true;
    }
    
    function setComboParameters(sComboAction, sObj) {
    	var formObj = document.form;
    	
    	if (sComboAction == COMMAND13) {
    		ComSetObjValue(formObj.dmdt_sh_tp_cd, 	"I");
			ComSetObjValue(formObj.ofc_cd, 			ComGetObjValue(formObj.cre_ofc_cd));
    	}
    }
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	
    	return true;
    }
    
    function dmtGetMsgText(xmlStr){

        try {
            var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
            xmlDoc.loadXML(xmlStr);

            var xmlRoot = xmlDoc.documentElement;
            if(xmlRoot == null) return;

            var msgNode = xmlRoot.getElementsByTagName("MESSAGE").item(0);
            if(msgNode == null) 
             return;
            else
             return msgNode.firstChild.nodeValue;
       } catch(err) { ComFuncErrMsg(err.message); }
       
    }    
    
 