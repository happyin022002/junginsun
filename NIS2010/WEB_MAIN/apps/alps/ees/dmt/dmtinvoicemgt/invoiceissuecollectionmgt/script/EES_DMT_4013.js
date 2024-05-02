/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_4013.jsp
*@FileTitle : Invoice Creation - Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.08.05 김태균
* 1.0 Creation
* 2011.03.31 김태균 [CHM-201109784-01] [DMT] Invoice Creation & Issue의 Payer 정보 확인 절차 추가
* 2012.05.23 김현화 [CHM-201217803] 인도용 DMT Invoice format 구성 - GST 적용.
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
     * @class EES_DMT_4013 : EES_DMT_4013 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_4013() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
	// 공통전역변수
	
	var sheetObjects = new Array();
	var sheetCnt = 0;

	var comboObjects = new Array();
	var comboCnt = 0;

	var ROWMARK = "|";
	var FIELDMARK = "=";
	
	//Action 정의
	var IBSEARCH_INIT = 100;	
	var IBSEARCH02	  = 51;
	var IBARIF		  = 52;	

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         
    	var sheetObject1 = sheetObjects[0];
     	//var sheetObject2 = sheetObjects[1];
         
    	var srcObj = window.event.srcElement;
        /*******************************************************/
     	var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
	            case "btn_payer_cd":
	         		openPopup('payer_cd');
					break;
				
				case "btn_update":
					setDataUpdate();
					break;

				case "btn_save":
					doActionSave();
					break;
				
				case "btn_ar":
					if (ComIsBtnEnable(srcName)) {
						doActionIBSheet(sheetObject1,formObject,IBARIF);
					}
					break;

				case "btn_excel":
					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
 					break;

				case "btn_close":
					window.close();
					break;

            } // end switch
    	} 
    	catch(e) {
    		if (e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} 
    		else {
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
	 * IBCombo Object를 배열로 등록
	 * param : combo_obj ==> 콤보오브젝트
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */ 
	function setComboObject(combo_obj) {  
	    comboObjects[comboCnt++] = combo_obj;  
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
					
	  			case 'payer_code_check':
	  				var returnValue = ComOpenPopup('EES_DMT_4109.do', 500, 150, "", "1,0,1,1,1,1,0", true);
	  				if(returnValue == "R") {
	  					ComSetObjValue(formObj.payer_cd,     ComGetObjValue(formObj.h_payer_cd));
	  					ComSetObjValue(formObj.payer_nm,     ComGetObjValue(formObj.h_payer_nm));
	  					ComSetObjValue(formObj.s_cust_gubun, ComGetObjValue(formObj.h_cust_gubun));
	  					ComSetObjValue(formObj.s_cust_cd,    ComGetObjValue(formObj.h_payer_cd));
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
    	document.form.payer_cd.value = aryPopupData[0][3];
    	document.form.payer_nm.value = aryPopupData[0][4];
    }    
    				

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	 var formObj = document.form;
    	 
        for (i=0; i<sheetObjects.length; i++) {

        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);

        }
        initAxonControl();
        
		// Invoice Creation - Group 초기 정보 조회
		DMTComDoActionIBSheet(sheetObjects[1], formObj, IBSEARCH_INIT);
		
        doInit();
    }
    
    /*
     * EES_DMT_4001에서 팝업 호출
     */
	function doInit() {
 		var formObj = document.form;
 		var opener  = window.dialogArguments;
 		var opnSheetObj = "";
 		var exchange_rate = "";
 		
 		var jspno = ComGetObjValue(formObj.jspno);
 		if (jspno == "4001") {
 			opnSheetObj = opener.document.form.sheet1;

 	 		ComSetObjValue(formObj.s_fm_dt, opener.document.form.fm_cfm_dt.value);
 	 		ComSetObjValue(formObj.s_to_dt, opener.document.form.to_cfm_dt.value);
 		} 
 		else if (jspno == "3001") {
 			opnSheetObj = opener.document.form.sheet2;
 		} 
 		else if (jspno == "4005") {
 			opnSheetObj = opener.document.form.sheet1;
 		}
 		
 		var sheetObj = sheetObjects[0];
 		
 		if (ComGetObjValue(formObj.s_group_by) == "1") {
 			sheetObj.ColHidden("cntr_cnt") = false;
 			sheetObj.ColHidden("cntr_no")  = true;
 			sheetObj.ColHidden("gb")       = true;
		} 
 		else {
			sheetObj.ColHidden("cntr_cnt") = true;
			sheetObj.ColHidden("cntr_no")  = false;
			sheetObj.ColHidden("gb")       = false;
		}

 		//sheet1의 "CheckBox" 컬럼이 체크된 데이터를 조회XML로 만들기
 		var sXml = ComMakeSearchXml(opnSheetObj, false, "CheckBox", "bkg_no|bl_no|cntr_cnt|cntr_no|gb|ofc_cd|dmdt_trf_cd|cust_cd|sc_no|rfa_no|ar_curr_cd|inv_amt|bzc_trf_curr_cd|org_chg_amt|sc_rfa_expt_amt|aft_expt_dc_amt|bil_amt|inv_xch_rt|vsl_cd|skd_voy_no|skd_dir_cd|pol_cd|pod_cd|por_cd|del_cd");
 		//hidden sheet
 		sheetObjects[2].LoadSearchXml(sXml, true);
 		
 		var sXml2 = "";
 		
 		var s_dmdt_trf_cd 	= "";
 		var s_bkg_no		= "";
 		var s_ofc_cd		= "";
 		var s_chg_type		= "";
 		var s_cntr_no		= "";
 		
 		//해당 되는 조건으로 data 조회
 		for (var i = 2; i < sheetObjects[2].TotalRows + 2; i++) {
 			var temp  = sheetObjects[2].CellValue(i, "dmdt_trf_cd");
 			var temp2 = sheetObjects[2].CellValue(i, "bkg_no");
 			var temp3 = sheetObjects[2].CellValue(i, "cntr_no");
 			
 			s_dmdt_trf_cd += temp + ","; 
 			s_bkg_no 	  += temp2 + ",";
 			if (temp3 != "") {
 				s_cntr_no += temp3 + ",";
 			}
 			s_ofc_cd = sheetObjects[2].CellValue(i, "ofc_cd");
 		}
 		
 		//search Bkg
 		ComSetObjValue(formObj.s_ofc_cd, 	  s_ofc_cd);
 		ComSetObjValue(formObj.s_bkg_no, 	  s_bkg_no);
 		ComSetObjValue(formObj.s_cntr_no, 	  s_cntr_no);
 		ComSetObjValue(formObj.s_dmdt_trf_cd, s_dmdt_trf_cd); 		

 		// Invoice Creation - Group 목록을 조회합니다.
 		doActionIBSheet(sheetObj, formObj, IBSEARCH);

 		ComSetObjValue(formObj.issue_date, 	ComGetObjValue(formObj.ofc_curr_date));
 		ComSetObjValue(formObj.usr_ofc, 	ComGetObjValue(formObj.session_ofc_cd));
 		ComSetObjValue(formObj.usr_name, 	ComGetObjValue(formObj.session_usr_nm));
 		ComSetObjValue(formObj.inv_qty,     "0");
 		ComSetObjValue(formObj.inv_curr_cd, getInvCurrCd());
 		
 		//전체 선택
 		sheetObj.CheckAll(1) = 1;
 		
 		//각 row의 container count를 구한다.
 		setCntrCntByRow();
 		
 		//추가 디폴트 PAYER CODE 값 셋팅
 		for (var i=2; i<sheetObj.TotalRows+2; i++) {
 			if (sheetObj.CellValue(i, "cust_cd") == "") continue;

			ComSetObjValue(formObj.payer_cd, sheetObj.CellValue(i, "cust_cd"));
			doActionText(sheetObjects[1], formObj, "", SEARCH20);
			break;
 		}
 		
 		//2011.03.31. invoice issue 전 PayerCd 팝업 체크 화면을 띄운다.
		ComSetObjValue(formObj.h_payer_cd,	ComGetObjValue(formObj.payer_cd));	
		ComSetObjValue(formObj.h_payer_nm,	ComGetObjValue(formObj.payer_nm));
		ComSetObjValue(formObj.h_cust_gubun,ComGetObjValue(formObj.s_cust_gubun));
		
		//초기화
		DmtComClearPayerCond();		
		
		if (ComGetObjValue(formObj.h_payer_cd) != "")
			openPopup('payer_code_check');
		
  		if (ComGetObjValue(formObj.s_ofc_cd) == 'PKGSC' || ComGetObjValue(formObj.s_ofc_cd) == 'PENSO' || ComGetObjValue(formObj.s_ofc_cd) == 'PGUSO') {
  			formObj.inv_new_rpt_flg.value = "Y";
  			formObj.inv_new_rpt.checked = true;
  		} 
  		else {
  			formObj.inv_new_rpt_flg.value = "N";
  			formObj.inv_new_rpt.checked = false;
  		}
  		
 		// Tax Ratio 항목의 값과 상태를 초기화 시켜줍니다.
 		DmtComInitTaxRto();
 		
 		//Invoice 발행 전 일 경우에는 Tax Amount 및 Invoice Amount 을 계산해 줍니다.
 		DmtComCalcInvAmtByTaxAmt();
 		
 		// 금액항목에 데이터를 금액표시로 변환 해줍니다.
 		DmtComDisplayCurrency();
  	}
	
	/*
	 * 조회된 모든 Charge 목록에서 최종 Charge 의 Currency 를 사용합니다. ( 기존 로직 그대로 유지 )
	 */
	function getInvCurrCd() {
		var sheetObj = sheetObjects[0];
		
		lastRow = sheetObj.TotalRows+1;
		var invCurrCd = sheetObj.CellValue(lastRow, "ar_curr_cd");
		
		return invCurrCd;
	}

	/*
	 * 각 Row 별 Container Count 를 조회합니다.
	 */
	function setCntrCntByRow() {
		var formObj  = document.form;
		var sheetObj = sheetObjects[0]
		
 		if (ComGetObjValue(formObj.s_group_by) == "1") {
 			for (var i=2; i<sheetObj.TotalRows+2 ; i++) {
 				ComSetObjValue(formObj.s_ofc_cd,      sheetObj.CellValue(i, "ofc_cd"));
 				ComSetObjValue(formObj.s_bkg_no,      sheetObj.CellValue(i, "bkg_no"));
 				ComSetObjValue(formObj.s_dmdt_trf_cd, sheetObj.CellValue(i, "dmdt_trf_cd"));
 				
 				doActionIBCombo(sheetObjects[1], formObj, IBSEARCH, SEARCH01);
 				sheetObj.CellValue2(i, "cntr_cnt") = ComGetObjValue(formObj.re_cntr_cnt);
 			}
		} 
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
                    style.height = 380;
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

                    //var HeadTitle  = "||Seq.|Invoice No.|STS|A/R|BKG No.|B/L No.|CNTR|CNTR No.|G/B|Office|Tariff|Payer|S/C No.|RFA No.|Invoice|Invoice|Invoice|Invoice|Invoice|Charge|Charge|Charge|Charge|Charge|Ex. Rate|vsl_cd|skd_voy_no|skd_dir_cd|pol_cd|pod_cd|por_cd|del_cd|chg_cust_cnt_cd|chg_cust_seq";
                    //var HeadTitle1  = "||Seq.|Invoice No.|STS|A/R|BKG No.|B/L No.|CNTR|CNTR No.|G/B|Office|Tariff|Payer|S/C No.|RFA No.|Cur.|Billing AMT|Tax(%)|Tax AMT|Payable AMT|Cur.|Incurred AMT|Exception AMT|D/C AMT|Billable AMT|Ex. Rate|vsl_cd|skd_voy_no|skd_dir_cd|pol_cd|pod_cd|por_cd|del_cd|chg_cust_cnt_cd|chg_cust_seq";
                    
                    var HeadTitle  = "||Seq.|Invoice No.|STS|A/R|BKG No.|B/L No.|CNTR|CNTR No.|G/B|Office|Tariff|Payer|S/C No.|RFA No.|TAA No.|Invoice|Invoice|Invoice|Invoice|Invoice|Charge|Charge|Charge|Charge|Charge|Ex. Rate|vsl_cd|skd_voy_no|skd_dir_cd|pol_cd|pod_cd|por_cd|del_cd|dmdt_chg_loc_div_cd|ida_expn_tax_rt|ida_expn_tax|ida_edu_tax_rt|ida_edu_tax|ida_high_edu_tax_rt|ida_high_edu_tax|ida_locl_tax|ida_locl_tax_rt|ida_n2ndlocl_tax|ida_n2nd_locl_tax_rt|ida_cgst_amt|ida_sgst_amt|ida_igst_amt|ida_ugst_amt";
                    var HeadTitle1  = "||Seq.|Invoice No.|STS|A/R|BKG No.|B/L No.|CNTR|CNTR No.|G/B|Office|Tariff|Payer|S/C No.|RFA No.|TAA No.|Cur.|Billing AMT|Tax(%)|Tax AMT|Payable AMT|Cur.|Incurred AMT|Exception AMT|D/C AMT|Billable AMT|Ex. Rate|vsl_cd|skd_voy_no|skd_dir_cd|pol_cd|pod_cd|por_cd|del_cd|dmdt_chg_loc_div_cd|ida_expn_tax_rt|ida_expn_tax|ida_edu_tax_rt|ida_edu_tax|ida_high_edu_tax_rt|ida_high_edu_tax|ida_locl_tax|ida_locl_tax_rt|ida_n2ndlocl_tax|ida_n2nd_locl_tax_rt|ida_cgst_amt|ida_sgst_amt|ida_igst_amt|ida_ugst_amt";
                    
                    var headCount = ComCountHeadTitle(HeadTitle);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
					InitHeadRow(1, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,		DATAALIGN, COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,			daCenter,   true,       "ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,		30,			daCenter,	true,		"check_box");
					InitDataProperty(0, cnt++ , dtSeq,			30,			daCenter,	true,		"SEQ");
					InitDataProperty(0, cnt++ , dtData,			90,			daCenter,	true,		"dmdt_inv_no",		false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			30,			daCenter,	true,		"dmdt_inv_sts_cd",	false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			30,			daCenter,	true,		"dmdt_ar_if_cd",	false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			90,			daCenter,	true,		"bkg_no",			false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			90,			daCenter,	true,		"bl_no",			false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			40,			daCenter,	true,		"cntr_cnt",			false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			90,			daCenter,	true,		"cntr_no",			false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			30,			daCenter,	true,		"gb",				false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			50,			daCenter,	true,		"ofc_cd",			false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			40,			daCenter,	true,		"dmdt_trf_cd",		false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,		"cust_cd",			false,		"",			dfNone,			0,		false,		false);			
					InitDataProperty(0, cnt++ , dtData,			90,			daCenter,	true,		"sc_no",			false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			90,			daCenter,	true,		"rfa_no",			false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			90,			daCenter,	true,		"taa_no",			false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			40,			daCenter,	true,		"ar_curr_cd",		false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,			daRight,	true,		"inv_amt",			false,		"",			dfNullFloat,	2,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		60,			daRight,	true,		"inv_tax_rto",		false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		60,			daRight,	true,		"inv_tax_amt",		false,		"",			dfNullFloat,	2,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		80,			daRight,	true,		"inv_payable_amt",	false,		"",			dfNullFloat,	2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			40,			daCenter,	true,		"bzc_trf_curr_cd",	false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			90,			daRight,	true,		"org_chg_amt",		false,		"",			dfNullFloat,	2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			90,			daRight,	true,		"sc_rfa_expt_amt",	false,		"",			dfNullFloat,	2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			60,			daRight,	true,		"aft_expt_dc_amt",	false,		"",			dfNullFloat,	2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,			daRight,	true,		"bil_amt",			false,		"",			dfNullFloat,	2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			0,			daRight,	true,		"inv_xch_rt",		false,		"",			dfNullFloat,	6,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		80,			daRight,	true,		"vsl_cd");
					InitDataProperty(0, cnt++ , dtHidden,		80,			daRight,	true,		"skd_voy_no");
					InitDataProperty(0, cnt++ , dtHidden,		80,			daRight,	true,		"skd_dir_cd");
					InitDataProperty(0, cnt++ , dtHidden,		80,			daRight,	true,		"pol_cd");
					InitDataProperty(0, cnt++ , dtHidden,		80,			daRight,	true,		"pod_cd");
					InitDataProperty(0, cnt++ , dtHidden,		80,			daRight,	true,		"por_cd");
					InitDataProperty(0, cnt++ , dtHidden,		80,			daRight,	true,		"del_cd");
					InitDataProperty(0, cnt++ , dtHidden,		80,			daRight,	true,		"dmdt_chg_loc_div_cd");
					//InitDataProperty(0, cnt++ , dtHidden,		80,			daRight,	true,		"chg_cust_cnt_cd");
					//InitDataProperty(0, cnt++ , dtHidden,		80,			daRight,	true,		"chg_cust_seq");
					InitDataProperty(0, cnt++ , dtHidden,		80,			daRight,	true,		"ida_expn_tax_rt");
					InitDataProperty(0, cnt++ , dtHidden,		80,			daRight,	true,		"ida_expn_tax");
					InitDataProperty(0, cnt++ , dtHidden,		80,			daRight,	true,		"ida_edu_tax_rt");
					InitDataProperty(0, cnt++ , dtHidden,		80,			daRight,	true,		"ida_edu_tax");
					InitDataProperty(0, cnt++ , dtHidden,		80,			daRight,	true,		"ida_high_edu_tax_rt");
					InitDataProperty(0, cnt++ , dtHidden,		80,			daRight,	true,		"ida_high_edu_tax");
					InitDataProperty(0, cnt++ , dtHidden,		80,			daRight,	true,		"ida_locl_tax_rt");
					InitDataProperty(0, cnt++ , dtHidden,		80,			daRight,	true,		"ida_locl_tax");
					InitDataProperty(0, cnt++ , dtHidden,		80,			daRight,	true,		"ida_n2nd_locl_tax_rt");
					InitDataProperty(0, cnt++ , dtHidden,		80,			daRight,	true,		"ida_n2nd_locl_tax");
					InitDataProperty(0, cnt++ , dtHidden,		 0,			daRight,	true,		"ida_cgst_amt");
					InitDataProperty(0, cnt++ , dtHidden,		 0,			daRight,	true,		"ida_sgst_amt");
					InitDataProperty(0, cnt++ , dtHidden,		 0,			daRight,	true,		"ida_igst_amt");
					InitDataProperty(0, cnt++ , dtHidden,		 0,			daRight,	true,		"ida_ugst_amt");
					
					
                    FrozenCols = SaveNameCol("cntr_cnt");
                    ToolTipOption="balloon:true;width:300;";

					//CountPosition = 0;
                }
                break;
                
            case 2:
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

                    var HeadTitle = "";
					var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

					CountPosition = 0;
                }
                break;
            case 3:      // sheet3 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 380;
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

                    //var HeadTitle  = "||Seq.|Invoice No.|STS|A/R|BKG No.|B/L No.|CNTR|CNTR No.|G/B|Office|Tariff|Payer|S/C No.|RFA No.|Invoice|Invoice|Invoice|Invoice|Invoice|Charge|Charge|Charge|Charge|Charge|Ex. Rate|vsl_cd|skd_voy_no|skd_dir_cd|pol_cd|pod_cd|por_cd|del_cd|chg_cust_cnt_cd|chg_cust_seq";
                    //var HeadTitle1  = "||Seq.|Invoice No.|STS|A/R|BKG No.|B/L No.|CNTR|CNTR No.|G/B|Office|Tariff|Payer|S/C No.|RFA No.|Cur.|Billing AMT|Tax(%)|Tax AMT|Payable AMT|Cur.|Incurred AMT|Exception AMT|D/C AMT|Billable AMT|Ex. Rate|vsl_cd|skd_voy_no|skd_dir_cd|pol_cd|pod_cd|por_cd|del_cd|chg_cust_cnt_cd|chg_cust_seq";
                    
                    var HeadTitle  = "BKG No.|B/L No.|CNTR|CNTR No.|G/B|Office|Tariff|Payer|S/C No.|RFA No.|Invoice|Invoice|Charge|Charge|Charge|Charge|Charge|Ex. Rate|vsl_cd|skd_voy_no|skd_dir_cd|pol_cd|pod_cd|por_cd|del_cd";
                    var HeadTitle1  = "BKG No.|B/L No.|CNTR|CNTR No.|G/B|Office|Tariff|Payer|S/C No.|RFA No.|Cur.|Billing AMT|Cur.|Incurred AMT|Exception AMT|D/C AMT|Billable AMT|Ex. Rate|vsl_cd|skd_voy_no|skd_dir_cd|pol_cd|pod_cd|por_cd|del_cd";
                    
                    var headCount = ComCountHeadTitle(HeadTitle);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
					InitHeadRow(1, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,		DATAALIGN, COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,			90,			daCenter,	true,		"bkg_no",			false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			90,			daCenter,	true,		"bl_no",			false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			40,			daCenter,	true,		"cntr_cnt",			false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			90,			daCenter,	true,		"cntr_no",			false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			30,			daCenter,	true,		"gb",				false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			40,			daCenter,	true,		"ofc_cd",			false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			40,			daCenter,	true,		"dmdt_trf_cd",		false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,		"cust_cd",			false,		"",			dfNone,			0,		false,		false);			
					InitDataProperty(0, cnt++ , dtData,			90,			daCenter,	true,		"sc_no",			false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			90,			daCenter,	true,		"rfa_no",			false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			40,			daCenter,	true,		"ar_curr_cd",		false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,			daRight,	true,		"inv_amt",			false,		"",			dfNullFloat,	2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			40,			daCenter,	true,		"bzc_trf_curr_cd",	false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			90,			daRight,	true,		"org_chg_amt",		false,		"",			dfNullFloat,	2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			90,			daRight,	true,		"sc_rfa_expt_amt",	false,		"",			dfNullFloat,	2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			60,			daRight,	true,		"aft_expt_dc_amt",	false,		"",			dfNullFloat,	2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,			daRight,	true,		"bil_amt",			false,		"",			dfNullFloat,	2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			0,			daRight,	true,		"inv_xch_rt",		false,		"",			dfNullFloat,	6,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		80,			daRight,	true,		"vsl_cd");
					InitDataProperty(0, cnt++ , dtHidden,		80,			daRight,	true,		"skd_voy_no");
					InitDataProperty(0, cnt++ , dtHidden,		80,			daRight,	true,		"skd_dir_cd");
					InitDataProperty(0, cnt++ , dtHidden,		80,			daRight,	true,		"pol_cd");
					InitDataProperty(0, cnt++ , dtHidden,		80,			daRight,	true,		"pod_cd");
					InitDataProperty(0, cnt++ , dtHidden,		80,			daRight,	true,		"por_cd");
					InitDataProperty(0, cnt++ , dtHidden,		80,			daRight,	true,		"del_cd");
					//InitDataProperty(0, cnt++ , dtHidden,		80,			daRight,	true,		"chg_cust_cnt_cd");
					//InitDataProperty(0, cnt++ , dtHidden,		80,			daRight,	true,		"chg_cust_seq");
					
                    FrozenCols = SaveNameCol("cntr_cnt");
                    ToolTipOption="balloon:true;width:300;";

					
					//CountPosition = 0;
                }
                break;

        }
    }
    
    function initAxonControl() {
		axon_event.addListenerFormat('focus',	'obj_focus',	form); //- 포커스 들어갈때
		axon_event.addListenerFormat('blur',	'obj_blur',		form); //- 포커스 나갈때

    }
    /**
     * HTML Control Foucs in
     */
    function obj_focus(){
    	var obj = event.srcElement;
		ComClearSeparator(obj);
        
		//글자가 있는 경우 블럭으로 선택할수 있도록 한다.
		if (obj.getAttribute("isContentEditable") && obj.getAttribute("value") != null && obj.value.length >=1 ) obj.select();

    }	
    
    //포커스가 나갈 때
    function obj_blur(){
    	//입력Validation 확인하기 + 마스크구분자 넣기
		var obj = event.srcElement;
		
		if (obj.name == 'payer_cd') {
			doActionText(sheetObjects[0], document.form, obj, SEARCH20);
		} 
		else {
			ComChkObjValid(obj);
		}
    }       

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

        	case IBSEARCH:      //조회
        		if (sheetObj.id == "sheet1") {
        			ComSetObjValue(formObj.f_cmd, SEARCH02);
        			
					var sXml = sheetObj.GetSearchXml("EES_DMT_4013GS.do", FormQueryString(formObj));
					sheetObj.LoadSearchXml(sXml);

					ComSetObjValue(formObj.grp_bkg_no,           ComGetEtcData(sXml, "GRP_BKG_NO"));
					ComSetObjValue(formObj.grp_dmdt_trf_cd,      ComGetEtcData(sXml, "GRP_DMDT_TRF_CD"));
					ComSetObjValue(formObj.dmdt_trf_cd,          ComGetEtcData(sXml, "GRP_DMDT_TRF_CD"));
					ComSetObjValue(formObj.por_cd,               ComGetEtcData(sXml, "GRP_POR_CD"));
					ComSetObjValue(formObj.del_cd,               ComGetEtcData(sXml, "GRP_DEL_CD"));
					ComSetObjValue(formObj.tax_rto,              ComGetEtcData(sXml, "TAX_RTO"));

					ComSetObjValue(formObj.ida_tax_appl_tm,      ComGetEtcData(sXml, "IDA_TAX_APPL_TM"));
					ComSetObjValue(formObj.ida_expn_tax_rt,      ComGetEtcData(sXml, "IDA_EXPN_TAX_RT"));
					ComSetObjValue(formObj.ida_edu_tax_rt,       ComGetEtcData(sXml, "IDA_EDU_TAX_RT"));
					ComSetObjValue(formObj.ida_high_edu_tax_rt,  ComGetEtcData(sXml, "IDA_HIGH_EDU_TAX_RT"));
					ComSetObjValue(formObj.ida_locl_tax_rt,      ComGetEtcData(sXml, "IDA_LOCL_TAX_RT"));
					ComSetObjValue(formObj.ida_n2nd_locl_tax_rt, ComGetEtcData(sXml, "IDA_N2ND_LOCL_TAX_RT"));
        		}
				break;     
			
        	case IBSAVE:
        		if (sheetObj.id == "sheet1") {	//Save
        			ComSetObjValue(formObj.f_cmd, COMMAND02);//MULTI
        			
        			if (!validateForm(sheetObj, formObj, sAction)) return;

        			if (formObj.s_group_inv[0].checked == true) {
        				var msg = "Combined Invoice nbr for selected BKGs";
        			} 
        			else {
        				var msg = "Individual invoice nbr for selected BKGs";
        			}
        			if (!ComShowCodeConfirm("DMT01180", msg)) return;
        			
        			sheetObj.WaitImageVisible = false;
        			ComOpenWait(true);
        			
        			DmtComRemoveCurrency();
        			
        			// Grid 데이터에 prefix 를 추가해준다.
        			var sParam = "";
        			sParam += sheetObj.GetSaveString(true);
        			sParam = ComSetPrifix(sParam, "grid");
        			sParam = sParam + "&" + FormQueryString(formObj);

        			var sXml = sheetObj.GetSaveXml("EES_DMT_4013GS.do", sParam);
        			
        			var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
    				if (backendJobKey != undefined && backendJobKey != '') {
						ComSetObjValue(formObj.backendjob_key, backendJobKey);
						sheetObj.WaitImageVisible = false;
						sheetObj.RequestTimeOut = 10000;
						timer = setInterval(getBackEndJobStatus, 3000); // 3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
					}
    				
    				DmtComDisplayCurrency();
        		}
	         	break;


        	case IBARIF:
        		if (!DmtComValidPayer()){
        			return;
        		}
        		
        		ComSetObjValue(formObj.f_cmd, COMMAND01);
        		setParameters(COMMAND01);
        		
				// AUTO-INF. 처리일 경우에는 Validation Check 와 Confirm 메시지를 실행하지 않는다. 2015.03.25
				if (ComGetObjValue(formObj.auto_ar_inf_yn) != "Y") {
	        		if (!validateForm(sheetObj, formObj, sAction)) return;
	        		if (!ComShowCodeConfirm("DMT03026")) return;
				}
				
    			// Grid 데이터에 prefix 를 추가해준다.
    			var sParam = "";
    			sParam += sheetObjects[0].GetSaveString(true);
    			sParam = ComSetPrifix(sParam, "grid");
    			sParam = sParam + "&" + FormQueryString(formObj);
    			
				var sXml = sheetObj.GetSaveXml("EES_DMT_4013GS.do", sParam);
				
				//3.저장 후 결과처리
				sheetObj.LoadSaveXml(sXml);

        		break;
        		
			case IBDOWNEXCEL:	// EXCEL DOWNLOAD
				if (sheetObj.id == "sheet1") {
					sheetObj.SpeedDown2Excel(-1);
				}; 
				break;        		
        }
    }
    
    /**
	 * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
	 */
    function getBackEndJobStatus() {
	 	var formObj = document.form;
	 	var sheetObj = sheetObjects[0];
	
	 	//It gets a status of backendjob. 2
	 	ComSetObjValue(formObj.f_cmd, COMMAND03);
	
	 	var params		= "f_cmd=" + COMMAND03 + "&backendjob_key=" + ComGetObjValue(formObj.backendjob_key);
	 	var sXml		= sheetObj.GetSearchXml("EES_DMT_4013GS.do", params);
	 	var jobState 	= ComGetEtcData(sXml, "jb_sts_flg");
	 	
	 	// jobState == "2" BackEndJob 진행중......
	 	if (jobState == "3") {
	 		clearInterval(timer);
	 		// BackEndJob이 성공 하였습니다.
	 		getBackEndJobLoadFile();
	 	}
	 	else if (jobState == "4") {
	 		clearInterval(timer);
	 		// BackEndJob을 실패 하였습니다.
	 		var jbUsrErrMsg	= ComGetEtcData(sXml, "jb_usr_err_msg");
	 		if (jbUsrErrMsg != undefined && jbUsrErrMsg != '')
	 			ComShowMessage(jbUsrErrMsg);
	 		else
	 			ComShowCodeMessage("DMT01125");
	 		
	 		ComOpenWait(false);
	 	}
	 	else if (jobState == "5") {
	 		clearInterval(timer);
	 		// 이미 BackEndJob 결과 파일을 읽었습니다.
	 		ComShowCodeMessage("DMT01125");
	 		ComOpenWait(false);
	 	}
	 }

	// BackEndJob 성공종료시 결과데이터를 반영한다.
	function getBackEndJobLoadFile() {
	 	var formObj = document.form;
	 	var sheetObj = sheetObjects[0];
	 	
	 	var backendjobId = ComGetObjValue(formObj.backendjob_id);
	 	
	 	ComSetObjValue(formObj.f_cmd, MULTI);	//SAVE
	 	
	 	var params = "f_cmd=" + ComGetObjValue(formObj.f_cmd) + "&backendjob_key=" + ComGetObjValue(formObj.backendjob_key);
	 	var sXml = sheetObj.GetSaveXml("EES_DMT_4013GS.do", params);
	 	sheetObj.LoadSaveXml(sXml);
	 	
	 	var invQty = typeof(sheetObj.EtcData("inv_qty")) == "undefined" ? "0" : sheetObj.EtcData("inv_qty"); 
	 	ComSetObjValue(formObj.inv_qty, invQty);
 	
	 	ComOpenWait(false);
	 	
	}    
	
  	/**
 	 * IBSheet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
 	 */
 	function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
 		if(ErrMsg != '') return;
 		
		var formObj = document.form;
		var fCmd = formObj.f_cmd.value;
		
		if (fCmd == COMMAND03) {
			alert(ErrMsg);
		}
	}	
    
    /**
     *  Payer, CUR, Tax정보 Update
     */
    function setDataUpdate() {
    	var formObj = document.form;
    	var sheetObj = sheetObjects[0];
    	
    	//Payer
    	if (ComGetObjValue(formObj.payer_cd) == "") {
    		ComAlertFocus(formObj.payer_cd, ComGetMsg("DMT02002","[Payer Code]"));
			return;
    	}
		
    	//Payer Code Setting
    	var payerCd = ComGetObjValue(formObj.payer_cd);
    	for (var i=2; i<sheetObj.TotalRows+2; i++) {
    		if (sheetObj.CellValue(i, "check_box") == 1) {
    			sheetObj.CellValue2(i, "cust_cd") = payerCd;
    		}
    	}
    	
    	ComShowCodeMessage("DMT01109");
    }
    
    //상단 그리드 선택 금액 처리함
    /**
     * Detail Sheet 클릭시 금액 계산
     * 
     * 2015-05-21 김기태 : 계산 로직 아래 setTax() 함수로 이동 후 setTax() 호출되도록 수정
     * 
     * @param sheetObj
     * @param Row
     * @param Col
     * @param Value
     * @return
     */
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		
		if (sheetObj.ColSaveName(Col) == "check_box") {
	    	// Invoice Amount 계산 로직 호출!!
	    	DmtComCalcInvAmtByTaxAmt();
		}
	}    

    // 전체 선택
    function sheet1_OnClick(sheetObj, row, col, Value){
        if(sheetObj.ColSaveName(col) == "check_box") {
        	ComSyncAllCheck(sheetObj, col, Value);
        }
    }	
    
	/*
	 * 조회필드정보를 입력화면의 조회필드값으로 저장한다.
	 */		
	function setParameters(sAction) {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		
		if (sAction == COMMAND01) {
			//container로 조회시
			if (ComGetObjValue(formObj.s_group_by) == "2") {
				//invoice_no하고 동일한 A/R
				for (var i=2; i<sheetObj.TotalRows+2; i++) {
					
					if (sheetObj.CellValue(i, "check_box") == "1") {
						var invoice_no = sheetObj.CellValue(i, "dmdt_inv_no");
						if (invoice_no == "") continue;
						
						//전체 중 같은 invoice_no가 존재하면 체크를 한다.
						for (var j = 2; j < sheetObj.TotalRows + 2 ; j++) {
							if (i == j) continue;
							if (invoice_no == sheetObj.CellValue(j, "dmdt_inv_no")) {
								sheetObj.CellValue(j, "check_box") = "1";
							}
						}//end of for
					}
				}//end of for
			}
		}
	}
	
	
    //말풍선
    function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){ 
    	 
    	with(sheetObj) {
    	   //마우스 위치를 행과 컬럼과 값 가져오기
    	      var Row = MouseRow;
    	      var Col = MouseCol;

    	      if (Row == 0 || Row == 1) {
    	    	  MouseToolTipText = (Col == 10) ? "General/Balance Charge Type" : "";
    	      } 
    	      else {
    	    	  if (Col == 4) {
    	    		  if (CellValue(Row, Col) == "I") {
    	    			  MouseToolTipText = "Issued";
    	    		  } 
    	    		  else {
    	    			  MouseToolTipText = "";
    	    		  }
    	    	  } 
    	    	  else {
    	    		  MouseToolTipText = "";
    	    	  }
    	      }
    	}
    }
    

	// 조회조건필드인 Combo 데이터 조회
    function doActionIBCombo(sheetObj, formObj, sAction, sComboAction) {
        sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;

		switch(sAction) {
        	case IBSEARCH:      // 조회
				if (sheetObj.id == "sheet2") {
					
					switch(sComboAction) {
						//CONTAINTER COUNT 조회
						case SEARCH01:
							ComSetObjValue(formObj.f_cmd, SEARCH01);
							
							//2.조회조건으로 조회실행					
							var sXml = sheetObj.GetSearchXml("EES_DMT_4013GS.do", FormQueryString(formObj));

							ComSetObjValue(formObj.re_cntr_cnt, ComGetEtcData(sXml, "CNTR_CNT"));
							break;			
					}
					
				};
                break;
        }
		sheetObj.WaitImageVisible = true;
    }
    
    function setComboParameters(sComboAction, sObj) {
    	var formObj = document.form;
    	//ComSetObjValue(formObj.curr_cd, ComGetObjValue(formObj.inv_curr_cd));//inv_curr_cd
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
	
    //Payer 체크
    function doActionText(sheetObj, formObj, object, formCmd) {
    	sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;
		
		var detention_check = "";
		//Detention 체크 확인
		for (var i=2; i<sheetObj.TotalRows+2; i++) {
			var dmdtTrfCd = sheetObj.CellValue(i, "dmdt_trf_cd");
			
			if (dmdtTrfCd.indexOf("DM") != -1) {
				detention_check = "Y";//Service Provider 입력 불가
				break;
			}
		}
		
		if (detention_check == 'Y') {
			ComShowCodeMessage("DMT00165", "Payer");
			DmtComClearPayerCond();
			return false;
		}

		// Payer Code 의 유효성을 체크하고, 유효할 경우 Payer Name 을 설정해준다.
    	DmtComValidPayer();

    	// Payer 정보가 변경되면 Payer 에 해당되는 India Tax Ratio 를 조회해서 Invoice Amount 를 재계산합니다.
    	DmtComSearchIdaTaxRtoByPayer();
    	
        sheetObj.WaitImageVisible = true;
    }

    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, formObj, sAction) {
        with(formObj) {
    		switch(sAction) {
				case IBSAVE:
					if (sheetObj.CheckedRows("check_box") == 0) {
		     			ComShowCodeMessage('COM12114', 'BKG No');
		     			return;
		     		}
					
					//issued 상태인 경우 막음
					var seq = 1;
					for (var i = 2 ; i < sheetObj.TotalRows + 2; i++) {
						if (sheetObj.CellValue(i, "check_box") == 1) {
							if (sheetObj.CellValue(i, "dmdt_inv_sts_cd") == "I" ) {
								ComShowCodeMessage("DMT01094", seq);
								return false;
							}
						}
						seq++;
					}
					
					// Payer 정보가 입력되지 않았다면 오류를 발생합니다.
					var payerCd = ComGetObjValue(formObj.payer_cd);
    				if (payerCd == "") {
    					ComAlertFocus(formObj.payer_cd, ComGetMsg("DMT02002","[Payer Code]"));
						return false;
    				}
					
					//data dup check
					//1. payer code
					var cmptPayerCd	= "";
					for (var i = 2; i < sheetObj.TotalRows + 2; i++) {
						if (sheetObj.CellValue(i, "check_box") == "1") {
							cmptPayerCd = sheetObj.CellValue(i, "cust_cd");
							
							if (cmptPayerCd == "") {
								ComAlertFocus(formObj.payer_cd, ComGetMsg("DMT01052"));
								return false;
							}
							else if (cmptPayerCd != payerCd) {
								ComAlertFocus(formObj.payer_cd, ComGetMsg("DMT01051"));
								return false;
							}
						}
					}
					
					//2. tax rto
					var cmptTaxRto	= "";					
					for (var i = 2; i < sheetObj.TotalRows + 2; i++) {
						if (sheetObj.CellValue(i, "check_box") == "1") {
							cmptTaxRto = sheetObj.CellValue(i, "inv_tax_rto");
							
							//하위 부터 중복 데이터가 존재하는지 체크한다.
							for (var j = i+1 ; j < sheetObj.TotalRows + 2; j++) {
								if (sheetObj.CellValue(j, "check_box") == "1") {
									if (cmptTaxRto != sheetObj.CellValue(j, "inv_tax_rto")) {
										ComAlertFocus(formObj.payer_cd, ComGetMsg("DMT01051"));
										return false;
									}
								}
							}
						}
					}
					
					//ar_curr_cd 상태인 경우 막음
					var arCurrCd = "";
					var curr_cnt = 0;
					for (var i = 2 ; i < sheetObj.TotalRows + 2; i++) {
						if (sheetObj.CellValue(i, "check_box") == 1) {
							if (curr_cnt == 0) {
								arCurrCd = sheetObj.CellValue(i, "ar_curr_cd");
								curr_cnt = 1;
							}
							if (arCurrCd != sheetObj.CellValue(i, "ar_curr_cd")) {
								ComShowCodeMessage("DMT00110", "Cur.");
								return false;
							}
						}
					}

    				return true;
					break;
					
				case IBARIF:
					if(sheetObj.CheckedRows("check_box") == 0) {
		     			ComShowCodeMessage('COM12114', 'BKG No');
		     			return;
		     		}
					var seq = 1;
					//Grid Check
					for (var i = 2 ; i < sheetObj.TotalRows + 2; i++) {
						
						if(sheetObj.CellValue(i, "check_box") == 1) {
							
							//Invoice no 필수 입력 체크
							if(sheetObj.CellValue(i, "dmdt_inv_sts_cd") == "I" || sheetObj.CellValue(i, "dmdt_inv_sts_cd") == "C") {
							
								if(sheetObj.CellValue(i, "dmdt_ar_if_cd") == "Y") {
									ComShowCodeMessage("DMT01098", seq);
									return false;
								}
							}else{
								ComShowCodeMessage("DMT01097", seq);
								return false;
							}
						}
						seq++;
					}
					
    				//로그인 사용자가 미주지역이 아니면 payer가 vendor가 입력되어있으면 메시지 처리한다.
    				//if((ComGetObjValue(formObj.session_cnt_cd) != "US") && (ComGetObjValue(formObj.session_cnt_cd) != "CA")) {
    				if ((ComGetObjValue(formObj.usr_cnt_cd) != "US") && (ComGetObjValue(formObj.usr_cnt_cd) != "CA")) {
    					//payer code
    					for (var i = 2; i < sheetObj.TotalRows+2 ; i++) {
    						var cust_len = parseInt(ComGetLenByByte(sheetObj.CellValue(i, "cust_cd")));
    						if (cust_len <= 6) {
    							ComShowCodeMessage("DMT00185");
    							return false;
    						}
    					}
    				}
					break;
    		}
        }

        return true;
    }
     
	function unLoadPage() {
		window.returnValue="Y";
	}
	
	function setRpt() {
  		var formObj = document.form;
  		if (formObj.inv_new_rpt.checked == true) {
  			formObj.inv_new_rpt_flg.value = "Y";
  		} 
  		else {
  			formObj.inv_new_rpt_flg.value = "N";
  		}  		
	}
	
	function setGroupInv(GrpFlg) {
		var sheetObj = sheetObjects[0];
		var formObj = document.form;
		
		if (( GrpFlg == "GRP" && sheetObj.ColHidden("inv_tax_rto") == false ) || ( GrpFlg == "BKG" && sheetObj.ColHidden("inv_tax_rto") == true )) {
			sheetObj.CheckAll(1) = 0;
		}
		
		if (GrpFlg == "GRP") {
			sheetObj.ColHidden("inv_tax_rto")     = true;
			sheetObj.ColHidden("inv_tax_amt")     = true;
			sheetObj.ColHidden("inv_payable_amt") = true;
		} 
		else {
			sheetObj.ColHidden("inv_tax_rto")     = false;
			sheetObj.ColHidden("inv_tax_amt")     = false;
			sheetObj.ColHidden("inv_payable_amt") = false;
		}

		//전체 선택
 		sheetObj.CheckAll(1) = 1;
	}
	
	function doActionSave() {
		var sheetObj = sheetObjects[0];
		var formObj  = document.form;
		
		// Tax Ratio 설정
		ComSetObjValue(formObj.tax_rto, ComGetObjValue(formObj.tax_rto_dis));
		
		// Invoice 생성
		doActionIBSheet(sheetObj, formObj, IBSAVE);
		
	}