/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_4002.js
*@FileTitle : Invoice Creation & Issue - Booking
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.08.05 김태균
* 1.0 Creation
* 2010.11.11 김태균 [CHM-201007006-01] [EES-DMT] [DMDT] Invoice Currency 선택 기능 추가
* 2010.12.03 김태균 [] [EES-DMT] invoice 생성 후 tax 계산 로직 누락 분 수정
* 2010.12.28 김태균 [] [EES-DMT] THRBA OFFICE 사용자 invoice issue 시 invoice currency ERROR로 인하여 validation 추가
* 2011.03.31 김태균 [CHM-201109784-01] [DMT] Invoice Creation & Issue의 Payer 정보 확인 절차 추가
* 2011.10.19 황효근 [CHM-201114001-01] [DMT] DMT Invoice의 e-mail 전송 본문을 Portugal언어로 전환 요청
* 2012.05.18 김현화 [CHM-201217803] 인도용 DMT Invoice format 구성 - GST 적용.
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
     * @class EES_DMT_4002 : EES_DMT_4002 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_4002() {
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
	// RD
	var rdObjects = new Array();
	var rdCnt = 0;
	var queryStr = "";

	var ROWMARK 	= "|";
	var FIELDMARK 	= "=";
	
	//Action 정의
	var IBSEARCH_INIT    = 100;
	var IBARIF		     = 52;	
	var IBFAXSEND	     = 53;
	var IBEMAILSEND	     = 54;
	var IBVTCANCEL       = 55;
	var IBVTSEARCH       = 56;
	var IBPAYRSEARCH     = 57;

	// 화면 컴포넌트 제어를 위한 코드 ]========================================
	var BEF_INV = "I1";				// Invoice 생성 전
	var AFT_INV_BEF_ARIF ="I2";		// Invoice 생성 후 & A/R I/F 전
	var AFT_INV_AFT_ARIF = "I3";	// Invoice 생성 후 & A/R I/F 후
	var CNL_INV = "I4"				// Invoice 취소
	//=========================================================================
		
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
 
    	var sheetObject1 = sheetObjects[0];
    	var sheetObject2 = sheetObjects[1];
         
    	var srcObj = window.event.srcElement;
    	/*******************************************************/
    	var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

	            case "btn_payer_cd":
	            	
	            	if(srcObj.style.cursor == "hand") {
	            		openPopup('payer_cd');
 					}
 					break;

	            case "btn_trucker_cd":
	            	if(srcObj.style.cursor == "hand") {
	            		openPopup('trucker_cd');
	            	}
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
					
				case "btn_cremark":
					if(ComIsBtnEnable(srcName)) {
						remark_alert(srcName);
					}
					break;					

				case "btn_hremark":
					if(ComIsBtnEnable(srcName)) {
						remark_alert(srcName);
					}
					break; 
					
				case "btn_save":
					if(ComIsBtnEnable(srcName)) {
						//버튼권한 추가(2010.04.08)
		        		if(ComGetObjValue(formObject.sec_invoice) == "N") {
		        			ComShowCodeMessage("DMT01145", "Save");
		        			return;
		        		}
		        		
		        		var isSave = true;
		        		// 가상Invoice 가 아닐 경우
		        		if (ComGetObjValue(formObject.dmdt_vt_inv_yn) != "Y") {
		        			// BKG No., Tariff Type 에 대한 Virtual Invoice 가 존재하는지 여부를 체크한다.
		        			var isExistsVtInv = doActionIBSheet(sheetObject1,formObject,IBVTSEARCH);
		        			if (isExistsVtInv) {
		        				// DMT01173 : There is a virtual invoice for this container. if you create invoice, then virtual invoice will be cancelled. Do you want to create invoice?
		        				isSave = ComShowCodeConfirm("DMT01173");
		        			}
		        		}
		        		// 오피스가 미주인 경우 DMT/DET Payer Info 테이블에 해당 Payer 정보가 등록되지 않은 경우 경고
//		        		if(!doActionIBSheet(sheetObject1,formObject,IBPAYRSEARCH)) {
//		        			ComShowCodeMessage("DMT01187");
//		        			return;
//		        		}

		        		if (isSave) {
		        			doActionIBSheet(sheetObject1,formObject,IBSAVE);
		        		}
					}
					break;
					
				case "btn_cancel":
					if(ComIsBtnEnable(srcName)) {
						//버튼권한 추가(2010.04.08)
		        		if(ComGetObjValue(formObject.sec_invoice) == "N") {
		        			ComShowCodeMessage("DMT01145", "Cancel");
		        			return;
		        		}
		        		
		        		// Virtual Invoice 에 대한 취소일 경우, Cancel 된 Invoice 의 Virtual Status 를 취소로 갱신한다.
		        		if (ComGetObjValue(formObject.dmdt_vt_inv_yn) == "Y") {
		        			if (ComShowCodeConfirm("DMT01171", "virtual invoice")) {
		        				doActionIBSheet(sheetObject1,formObject,IBVTCANCEL);
		        			}
		        		}
		        		else {
		        			openPopupWindow(sheetObject1, formObject, srcName);
		        		}
					}
					break;
					
				case "btn_preview":
					if(ComIsBtnEnable(srcName)) {
						if (ComGetObjValue(formObject.has_sheetset) != "Y") {
							ComShowCodeMessage("DMT01096");
							return;
						}
						openPopupWindow(sheetObject1, formObject, srcName);
					}
					break;
					
				case "btn_print":
					
					if(ComIsBtnEnable(srcName)) {
						
						if (ComGetObjValue(formObject.has_sheetset) != "Y") {
							ComShowCodeMessage("DMT01096");
							return;
						}
						
						initRdConfig(rdObjects[0]);
						rdOpen(rdObjects[0], formObject, sheetObject2);

					}
					break;
					
				case "btn_fax":
					if(ComIsBtnEnable(srcName)) {
						if (ComGetObjValue(formObject.has_sheetset) != "Y") {
							ComShowCodeMessage("DMT01096");
							return;
						}
	                    doActionIBSheet(sheetObject2, formObject, IBFAXSEND);	//팩스 전송 변수 저장
						openPopupWindow(sheetObject1, formObject, srcName);
					}
					break;
					
				case "btn_email":
					if(ComIsBtnEnable(srcName)) {
						if (ComGetObjValue(formObject.has_sheetset) != "Y") {
							ComShowCodeMessage("DMT01096");
							return;
						}
						doActionIBSheet(sheetObject2,formObject,IBEMAILSEND);
						
						openPopupWindow(sheetObject1, formObject, srcName);
					}
					break;																														

				case "btn_payer":
					//if(ComIsBtnEnable(srcName)) {
						openPopupWindow(sheetObject1, formObject, srcName);
					//}
					break; 
					
				case "btn_arif":
					if(ComIsBtnEnable(srcName)) {
						//버튼권한 추가(2010.04.08)
		        		if(ComGetObjValue(formObject.sec_invoice) == "N") {
		        			ComShowCodeMessage("DMT01145", "A/R I/F");
		        			return;
		        		}
						doActionIBSheet(sheetObject1,formObject,IBARIF);
					}
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

	    //국가별 통화량
	    if (ComGetObjValue(formObj.invoice_issue) == "1") {
	    	document.getElementById('inv_cur').innerHTML 
	    		= "<select name='inv_curr_cd' style='width:80;' class='input1' onchange='DmtComCalcInvAmtByTaxAmt()'>&nbsp;</select>";
	    	searchARCurrencyList();
	    }
	    
		// Invoice Creation & Issue - Booking 초기 정보 조회
		DMTComDoActionIBSheet(sheetObjects[0], document.form, IBSEARCH_INIT);
		
		var invAmtCalcTp = ComGetObjValue(formObj.invoice_issue) == "2"	? "R" : "";
    	// 발행한 invoice 정보일 경우, 금액계산을 실행하지 않고, 조회된 결과를 그대로 보여주도록 옵션값을 설정한다.
		ComSetObjValue(formObj.inv_amt_calc_tp, invAmtCalcTp);  		
		// Invoice Creation & Issue - Booking 정보 조회
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		// 조회가 끝나면 정상적으로 Tax Amount, Invoice Amount 계산이 수행될 수 있도록 옵션값을 초기화 시켜준다.
		if (invAmtCalcTp == "R") ComSetObjValue(formObj.inv_amt_calc_tp, "");
				
		// invoice 전은  openPopup('payer_code_check'); 결과값에 따라 로직을 수행한다.
		if (ComGetObjValue(formObj.invoice_issue) == "2") {
		
			// Payer 의 Attention 정보를 초기화해 줍니다.
			DmtComInitPayerAttention();	
		}
		
		//Sheet Set 있는지 없는지 조회한다.
		//Sheet Set가 없을 경우에는 Preview, Print, Fax send, Email send를 버튼 클릭시 Alert MSG을 띄워 막고자 합니다
		doActionIBCombo(sheetObjects[1],document.form,IBSEARCH,COMMAND13,"RESULT","");		
		
		//Payer별 email, faxno를 조회한다.
		if (ComGetObjValue(formObj.invoice_issue) == "2") {
			if (ComGetObjValue(formObj.payer_cd) != "") {
				doActionIBCombo(sheetObjects[1], formObj, IBSEARCH, COMMAND02, "", "");
			}
		}
		//조회한 ATTENTION 정보
		ComSetObjValue(formObj.org_dmdt_payr_cntc_pnt_nm, 	ComGetObjValue(formObj.dmdt_payr_cntc_pnt_nm));
		ComSetObjValue(formObj.org_payr_cntc_pnt_phn_no, 	ComGetObjValue(formObj.payr_cntc_pnt_phn_no));
		ComSetObjValue(formObj.org_payr_cntc_pnt_fax_no, 	ComGetObjValue(formObj.payr_cntc_pnt_fax_no));
		ComSetObjValue(formObj.org_payr_cntc_pnt_eml, 		ComGetObjValue(formObj.payr_cntc_pnt_eml));
		
		
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
		else {
	    	// 발행한 invoice 정보일 경우, 금액계산을 실행하지 않고, 조회된 결과를 그대로 보여주도록 옵션값을 설정한다.
			ComSetObjValue(formObj.inv_amt_calc_tp, "R");  			
	    	// Payer 정보가 변경되면 Payer 에 해당되는 GST 정보 및 India Tax Ratio 를 조회해서 Invoice Amount 를 재계산합니다.
	    	DmtComSearchIdaTaxRtoByPayer();
	    	// 조회가 끝나면 정상적으로 Tax Amount, Invoice Amount 계산이 수행될 수 있도록 옵션값을 초기화 시켜준다.
	    	ComSetObjValue(formObj.inv_amt_calc_tp, "");
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
                    style.height = 132;
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

                    var HeadTitle  = "||Seq.|CNTR No.|T/S|Staying Period|Staying Period|Free Time|Free Time|F/D|Over|Cur.|Incurred AMT|Exception AMT|Discount AMT|Billable AMT|G/B|svr_id|cntr_cyc_no|dmdt_trf_cd|dmdt_chg_loc_div_cd|chg_seq|bzc_trf_seq|bzc_dmdt_de_term_cd|bzc_trf_grp_seq|CMDT_EXPT_AMT|rfa_expt_dar_no|rfa_expt_mapg_seq|rfa_expt_ver_seq|rfa_rqst_dtl_seq|sc_no|sc_expt_ver_seq|sc_expt_grp_seq|dmdt_trp_aply_tp_cd|inv_bill_amt|inv_chg_tot|org_ft_ovr_dys|fm_mvmt_yd_cd";
                    var HeadTitle1  = "||Seq.|CNTR No.|T/S|From Date|To Date|F/T CMNC|F/T End|F/D|Over|Cur.|Incurred AMT|Exception AMT|Discount AMT|Billable AMT|G/B|svr_id|cntr_cyc_no|dmdt_trf_cd|dmdt_chg_loc_div_cd|chg_seq|bzc_trf_seq|bzc_dmdt_de_term_cd|bzc_trf_grp_seq|CMDT_EXPT_AMT|rfa_expt_dar_no|rfa_expt_mapg_seq|rfa_expt_ver_seq|rfa_rqst_dtl_seq|sc_no|sc_expt_ver_seq|sc_expt_grp_seq|dmdt_trp_aply_tp_cd|inv_bill_amt|inv_chg_tot|org_ft_ovr_dys|fm_mvmt_yd_cd";
					var headCount = ComCountHeadTitle(HeadTitle) + 5;

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    InitHeadRow(1, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,		DATAALIGN, COLMERGE,	SAVENAME,			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,			daCenter, 	true,       "ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,		30,			daCenter,	true,		"checkBox",			false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtSeq,			30,			daCenter,	true,		"SEQ");
					InitDataProperty(0, cnt++ , dtData,			85,			daCenter,	true,		"cntr_no",			false,		"",			dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			30,			daCenter,	true,		"cntr_tpsz_cd",		false,		"",			dfNone,			0,		false,		true);
					
					InitDataProperty(0, cnt++ , dtData,			70,			daCenter,	true,		"fm_mvmt_dt",		false,		"",			dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			70,			daCenter,	true,		"to_mvmt_dt",		false,		"",			dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			70,			daCenter,	true,		"ft_cmnc_dt",		false,		"",			dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			70,			daCenter,	true,		"ft_end_dt",		false,		"",			dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			35,			daCenter,	true,		"ft_dys",			false,		"",			dfNone,			0,		false,		true);
					
					InitDataProperty(0, cnt++ , dtData,			35,			daCenter,	true,		"fx_ft_ovr_dys",	false,		"",			dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			35,			daCenter,	true,		"bzc_trf_curr_cd",	false,		"",			dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			85,			daRight,	true,		"org_chg_amt",		false,		"",			dfFloat,		2,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			85,			daRight,	true,		"expt_amt",			false,		"",			dfFloat,		2,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			85,			daRight,	true,		"aft_expt_dc_amt",	false,		"",			dfFloat,		2,		false,		true);
					
					InitDataProperty(0, cnt++ , dtData,			85,			daRight,	true,		"bil_amt",			false,		"",			dfFloat,		2,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,			daCenter,	true,		"gb",				false,		"",			dfNone,			0,		false,		true);
                    
					InitDataProperty(0, cnt++ , dtHidden,		100,		daCenter,	true,		"svr_id");
					InitDataProperty(0, cnt++ , dtHidden,		100,		daCenter,	true,		"cntr_cyc_no");
					InitDataProperty(0, cnt++ , dtHidden,		100,		daCenter,	true,		"dmdt_trf_cd");
					InitDataProperty(0, cnt++ , dtHidden,		100,		daCenter,	true,		"dmdt_chg_loc_div_cd");
					InitDataProperty(0, cnt++ , dtHidden,		100,		daCenter,	true,		"chg_seq");
					InitDataProperty(0, cnt++ , dtHidden,		100,		daCenter,	true,		"bzc_trf_seq");
					InitDataProperty(0, cnt++ , dtHidden,		100,		daCenter,	true,		"bzc_dmdt_de_term_cd");
					InitDataProperty(0, cnt++ , dtHidden,		100,		daCenter,	true,		"bzc_trf_grp_seq");
					InitDataProperty(0, cnt++ , dtHidden,		85,			daRight,	true,		"cmdt_expt_amt");
					
					//추가 컬럼
					InitDataProperty(0, cnt++ , dtHidden,		85,			daRight,	true,		"rfa_expt_dar_no");
					InitDataProperty(0, cnt++ , dtHidden,		85,			daRight,	true,		"rfa_expt_mapg_seq");
					InitDataProperty(0, cnt++ , dtHidden,		85,			daRight,	true,		"rfa_expt_ver_seq");
					InitDataProperty(0, cnt++ , dtHidden,		85,			daRight,	true,		"rfa_rqst_dtl_seq");
					InitDataProperty(0, cnt++ , dtHidden,		85,			daRight,	true,		"sc_no");
					InitDataProperty(0, cnt++ , dtHidden,		85,			daRight,	true,		"sc_expt_ver_seq");
					InitDataProperty(0, cnt++ , dtHidden,		85,			daRight,	true,		"sc_expt_grp_seq");
					InitDataProperty(0, cnt++ , dtHidden,		85,			daRight,	true,		"dmdt_trf_aply_tp_cd");
					
					InitDataProperty(0, cnt++ , dtHidden,		85,			daRight,	true,		"inv_bill_amt",			false,		"",			dfFloat,		2,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		85,			daRight,	true,		"inv_chg_tot",			false,		"",			dfFloat,		2,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		85,			daRight,	true,		"org_ft_ovr_dys",		false,		"",			dfFloat,		2,		false,		true);
					
					InitDataProperty(0, cnt++ , dtHidden,		85,			daRight,	true,		"fm_mvmt_yd_cd");
					
					InitDataProperty(0, cnt++ , dtHidden,		85,			daRight,	true,		"org_chg_amt_flg");
					InitDataProperty(0, cnt++ , dtHidden,		85,			daRight,	true,		"expt_amt_flg");
					InitDataProperty(0, cnt++ , dtHidden,		85,			daRight,	true,		"aft_expt_dc_amt_flg");
					InitDataProperty(0, cnt++ , dtHidden,		85,			daRight,	true,		"bil_amt_flg");
					InitDataProperty(0, cnt++ , dtHidden,		85,			daRight,	true,		"dul_tp_expt_flg");
					
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

        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
        	case IBSEARCH:      //조회
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				if (sheetObj.id == "sheet1") {
					var param = "";
					
					var dmdtVtInvYn    = ComGetObjValue(formObj.dmdt_vt_inv_yn);
					var dmdtVtInvNo    = ComGetObjValue(formObj.dmdt_vt_inv_no);
					var dmdtVtInvStsCd = ComGetObjValue(formObj.dmdt_vt_inv_sts_cd); 
					
					if (ComGetObjValue(formObj.invoice_issue) == "1") {
						//ComSetObjValue(formObj.f_cmd, SEARCH);
						//setParameters(SEARCH);
						
						param = "f_cmd=" + SEARCH
							  + "&s_dmdt_trf_cd=" + formObj.s_dmdt_trf_cd.value 
							  + "&s_bkg_no=" + formObj.s_bkg_no.value 
							  + "&ofc_cd=" + formObj.session_ofc_cd.value		//session office code
							  + "&s_ofc_cd=" + formObj.s_ofc_cd.value			//charge office code
							  + "&dmdt_chg_sts_cds=" + formObj.dmdt_chg_sts_cds.value
							  + "&s_chg_type=" + formObj.s_chg_type.value
							  + "&usr_cnt_cd=" + formObj.usr_cnt_cd.value
							  ;
					}
					else if (ComGetObjValue(formObj.invoice_issue) == "2") {
						//ComSetObjValue(formObj.f_cmd, SEARCH01);
						//setParameters(SEARCH01);
						var invoiceNo = dmdtVtInvYn == "Y" ? dmdtVtInvNo : ComGetObjValue(formObj.s_invoice_no);
						
						param = "f_cmd=" + SEARCH01
						  + "&s_bkg_no=" + formObj.s_bkg_no.value 
						  + "&s_dmdt_trf_cd=" + formObj.s_dmdt_trf_cd.value
						  + "&ofc_cd=" + formObj.s_ofc_cd.value			//credit office code
						  + "&s_ofc_cd=" + formObj.s_ofc_cd.value		//charge office code
						  + "&s_invoice_no=" + invoiceNo
						  + "&dmdt_vt_inv_yn=" + dmdtVtInvYn
						  + "&dmdt_vt_inv_sts_cd=" + dmdtVtInvStsCd
						  ;
					}
					
					if (!validateForm(sheetObj,formObj,sAction)) return;
					
                    //ComOpenWait Start
                    sheetObj.WaitImageVisible=false;
                    ComOpenWait(true);

					var sXml = sheetObj.GetSearchXml("EES_DMT_4002GS.do", param);
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
					
					// INV Cur. 항목 컴포넌트 변경 (Invoice 가 발행된 경우)
					if (ComGetObjValue(formObj.invoice_issue) == "2") {
						//invoice currency input box 로 변경
						document.getElementById('inv_cur').innerHTML 
							= "<input type='text' name='inv_curr_cd' style='width:40;text-align:center'  class='input2' value='' readonly>";	
					}
					
                    // ETC 조회결과를 Form 항목으로 바인딩 시켜줍니다.
                    DmtComEtcDataToForm(formObj, sheetObj);
                    
					// Virtual Invoice 정보는 조회 후에도 그 데이터가 변경되지 않기 때문에, DmtComEtcDataToForm 함수를 호출해서 
					// Form 데이터가 조회결과로 변경되더라도 이 정보는 변경되지 않도록 데이터를 원복해준다.
					ComSetObjValue(formObj.dmdt_vt_inv_yn, dmdtVtInvYn);
					ComSetObjValue(formObj.dmdt_vt_inv_no, dmdtVtInvNo);
					
					//org_payer_cd
					ComSetObjValue(formObj.org_payer_cd, ComGetObjValue(formObj.payer_cd));
					
					// Virtual Invoice 일 경우
					if (dmdtVtInvYn == "Y") {	
						
						// 가상Invoice 인 경우, 버튼 상태 설정.
						setScreenStatusOfVtInv();
					}
					// Virtual Invoice 가 아닐 경우
					else {
						// 화면 컴포넌트(입력, 버튼)의 상태를 제어합니다.
						controlScreen();
						
						//날짜 하이픈 처리
						if (ComGetObjValue(formObj.due_date) != "********") {
							ComSetObjValue(formObj.due_date, ComGetMaskedValue(formObj.due_date.value, "ymd"));
						}
						
						//Create Note 텍스트 동적처리
						if (ComGetObjValue(formObj.dmdt_inv_sts_cd) == "C" && ComGetObjValue(formObj.cr_inv_no) != "") {
							document.getElementById('cr_nm').innerHTML = "Reference";
						}
						else {
							document.getElementById('cr_nm').innerHTML = "Credit Note";
						}						
					}					

					if (formObj.inv_new_rpt_flg.value == "" || ComGetObjValue(formObj.inv_new_rpt_flg) == 'null') {	
			        	if (ComGetObjValue(formObj.cre_dt) == '' && ( ComGetObjValue(formObj.s_ofc_cd) == "PKGB" || ComGetObjValue(formObj.s_ofc_cd) == "PKGB" || ComGetObjValue(formObj.s_ofc_cd) == "PKGB" )) {
			        		formObj.inv_new_rpt.checked = true;
			        		formObj.inv_new_rpt_flg.value = "Y";
			        	} 
			        	else {
			        		formObj.inv_new_rpt.checked = false;
			        		formObj.inv_new_rpt_flg.value = "N";
			        	}
					}
					sheetObj.CellFontColor(1, "bil_amt")=10; 
				}
				else if (sheetObj.id == "sheet2") {
					ComSetObjValue(formObj.f_cmd, SEARCH02);
					setParameters(SEARCH02);
					if (validateForm(sheetObj,formObj,sAction)) {
						sheetObj.DoSearch("EES_DMT_4002GS.do", FormQueryString(formObj));	//ex_rate 조회
						ComSetObjValue(formObj.inv_xch_rt, sheetObj.EtcData("EX_RATE"));
					}
				}
				
				if(ComGetObjValue(formObj.inv_new_rpt_flg) == 'Y') 
					formObj.inv_new_rpt.checked = true;
	        	else 
	        		formObj.inv_new_rpt.checked = false;
	        	
	        	if(ComGetObjValue(formObj.ar_if_dt) != '') 
	        		formObj.inv_new_rpt.disabled = true;
	        	else
	        		formObj.inv_new_rpt.disabled = false;
	        	
				break;
        		
        	case IBSAVE:
        		//Invoice 생성전
        		if (ComGetObjValue(formObj.invoice_issue) == "1") {
        			ComSetObjValue(formObj.f_cmd, MULTI);
					setParameters(MULTI);
				}
				//Invoice 생성후
        		else if (ComGetObjValue(formObj.invoice_issue) == "2") {
        			
        			// Virtual Invoice 일 경우(Virtual Invoice 는 Cancel 된 Invoice 정보를 근간으로 생성하기 때문에 Invoice 발행 후 상태이다.)
        			if (ComGetObjValue(formObj.dmdt_vt_inv_yn) == "Y") {
            			ComSetObjValue(formObj.f_cmd, MULTI);
    					setParameters(MULTI); 
        			}
        			// Virtual Invoice 가 아닐 경우
        			else {
    					ComSetObjValue(formObj.f_cmd, MULTI01);
    					setParameters(MULTI01);
        			}

        			// 인도 OFC 인 경우, Tax Ratio 는 별도로 관리함. 2017.08.03
        			if (ComGetObjValue(formObj.cre_cnt_cd) != "IN") {
	        			// INVOICE TAX_RTO와 OFFICE별 TAX_RTO가 다를 경우 메시지 처리함
	        			var taxRtoDis  = ComGetObjValue(formObj.tax_rto_dis);
	        			var taxRto     = ComGetObjValue(formObj.tax_rto);
	        			var iTaxRtoDis = parseInt(taxRtoDis);
	        			
						if (iTaxRtoDis > 0  && taxRtoDis != taxRto) {
							if (!ComShowCodeConfirm("DMT00184")) return;
						}
        			}
				}
        		
				if (!validateForm(sheetObj,formObj,sAction)) return;
				
				//3자리 콤마 제거
				DmtComRemoveCurrency();	
				
				//실제 전달할 Payer Code를 Customer Code에 대입
				ComSetObjValue(formObj.s_cust_cd, ComGetObjValue(formObj.payer_cd));
				var sParam = "";
				
				// Invoice 생성전
        		if (ComGetObjValue(formObj.invoice_issue) == "1") {
        			sParam = sheetObjects[0].GetSaveString(true) +"&" + FormQueryString(formObj);
				}
        		// Invoice 생성후
        		else if (ComGetObjValue(formObj.invoice_issue) == "2") {
					sParam = sheetObjects[0].GetSaveString(true) +"&" + FormQueryString(formObj);
					sheetObj.RowStatus(2) = "U";	//임시로 처리함
				}
                //ComOpenWait Start
                sheetObj.WaitImageVisible=false;
                ComOpenWait(true);

        		var sXml = sheetObj.GetSaveXml("EES_DMT_4002GS.do", sParam);
				//3.저장 후 결과처리
				sheetObj.LoadSaveXml(sXml);
				
                //ComOpenWait End
                ComOpenWait(false);
                
				ComSetObjValue(formObj.success_yn,     ComGetEtcData(sXml, "SUCCESS_YN"));
				ComSetObjValue(formObj.auto_ar_inf_yn, ComGetEtcData(sXml, "AUTO_AR_INF_YN"));
				
				//4.저장후 저장버튼 처리
				if (ComGetObjValue(formObj.success_yn) == "Y") {
					
					if (ComGetObjValue(formObj.invoice_issue) == "1") {
						ComSetObjValue(formObj.s_invoice_no, sheetObj.EtcData("INVOICE_NO"));
						ComSetObjValue(formObj.s_ofc_cd,     sheetObj.EtcData("CRE_OFC_CD"));
					}
					else {
						// Virtual Invoice 인 경우, 신규 Invoice 가 생성되었기 때문에 Virtual Invoice 정보를 제거한다.
						if (ComGetObjValue(formObj.dmdt_vt_inv_yn) == "Y") {
							ComSetObjValue(formObj.s_invoice_no, sheetObj.EtcData("INVOICE_NO"));
							ComSetObjValue(formObj.s_ofc_cd,     sheetObj.EtcData("CRE_OFC_CD"));
							
							ComSetObjValue(formObj.dmdt_vt_inv_yn,     "");
							ComSetObjValue(formObj.dmdt_vt_inv_no,     "");
							ComSetObjValue(formObj.dmdt_vt_inv_sts_cd, "I");	
						}
						else {
							ComSetObjValue(formObj.s_invoice_no, ComGetObjValue(formObj.dmdt_inv_no));
							ComSetObjValue(formObj.s_ofc_cd,     ComGetObjValue(formObj.cre_ofc_cd));							
						}
					}
					
					// 4.1) [ 발행된 invoice 정보 조회 전 설정 ]
					ComSetObjValue(formObj.invoice_issue, "2");
			    	// 발행한 invoice 정보일 경우, 금액계산을 실행하지 않고, 조회된 결과를 그대로 보여주도록 옵션값을 설정한다.
					ComSetObjValue(formObj.inv_amt_calc_tp, "R");  

			    	// 4.2) [ 발행된 invoice 정보 조회 ]
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);

					// 4.3) [ 발행된 invoice 정보 조회 후 설정값 원복 ]
					// 조회가 끝나면 정상적으로 Tax Amount, Invoice Amount 계산이 수행될 수 있도록 옵션값을 초기화 시켜준다.
					ComSetObjValue(formObj.inv_amt_calc_tp, "");					
					
					
					// AUTO A/R I/F 가 아닐 경우, 화면 컨트롤 조정을 위해서 아래 로직을 실행합니다.
					// AUTO A/R I/F 일 경우, 조회로직에 화면 컨트롤 조정이 포함되어 있어서 그 부분만 실행하면 됩니다.
					if (ComGetObjValue(formObj.auto_ar_inf_yn) != "Y") {

						sheetObj.Editable = true;
						sheetObj.CheckAll2(1) = 1;
						sheetObj.Editable = false;
						
						//email, fax 정보 조회
						doActionIBCombo(sheetObjects[1], formObj, IBSEARCH, COMMAND02, "", "");
						
						// Payer 의 Attention 정보를 초기화해 줍니다.
						DmtComInitPayerAttention();	
						
						//조회한 ATTENTION 정보
						ComSetObjValue(formObj.org_dmdt_payr_cntc_pnt_nm, 	ComGetObjValue(formObj.dmdt_payr_cntc_pnt_nm));
						ComSetObjValue(formObj.org_payr_cntc_pnt_phn_no, 	ComGetObjValue(formObj.payr_cntc_pnt_phn_no));
						ComSetObjValue(formObj.org_payr_cntc_pnt_fax_no, 	ComGetObjValue(formObj.payr_cntc_pnt_fax_no));
						ComSetObjValue(formObj.org_payr_cntc_pnt_eml, 		ComGetObjValue(formObj.payr_cntc_pnt_eml));
					}
				}
				// 실패한 경우
				else {
					// 실패한 경우 현상태를 그대로 유지한다. ( 아래 로직은 주석처리함 )
					/*====================================================================================================
					// 가상 Invoice 로 Invoice 생성에 실패한 경우라면, 화면UI 컨트롤을 현상태 그대로 유지한다.
					//if (ComGetObjValue(formObj.dmdt_vt_inv_yn) == "Y") return;
					// 화면 컴포넌트(입력, 버튼)의 상태를 제어합니다.
					//controlScreen();
					====================================================================================================*/
				}
				break;		
				
        	case IBARIF:
        		if (!DmtComValidPayer()){
        			return;
        		}
        		
        		ComSetObjValue(formObj.f_cmd, COMMAND01);
        		setParameters(COMMAND01);
        		
				if (!validateForm(sheetObj, formObj, sAction)) return;
				if (!ComShowCodeConfirm("DMT03026")) return;	
        		
        		//sheetObj.DoSave("EES_DMT_4002GS.do", FormQueryString(formObj), -1, false);
				var sParam = sheetObjects[0].GetSaveString(true) +"&" + FormQueryString(formObj);
				
                //ComOpenWait Start
                sheetObj.WaitImageVisible=false;
                ComOpenWait(true);
				
				//성공시 INVOICE 조회 버튼 처리
				var sXml = sheetObj.GetSaveXml("EES_DMT_4002GS.do", sParam);
				//3.저장 후 결과처리
				sheetObj.LoadSaveXml(sXml);

                //ComOpenWait End
                ComOpenWait(false);
				
				ComSetObjValue(formObj.success_yn, ComGetEtcData(sXml, "SUCCESS_YN"));//SUCCESS_YN
				
				//4.저장후 재조회
				
				// 4.1) [ 발행된 invoice 정보 조회 전 설정 ]
		    	// 발행한 invoice 정보일 경우, 금액계산을 실행하지 않고, 조회된 결과를 그대로 보여주도록 옵션값을 설정한다.
				ComSetObjValue(formObj.inv_amt_calc_tp, "R");  			
				
				// 4.2) [ 발행된 invoice 정보 조회 ]
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
				
				// 4.3) [ 발행된 invoice 정보 조회 후 설정값 원복 ]
		    	// 조회가 끝나면 정상적으로 Tax Amount, Invoice Amount 계산이 수행될 수 있도록 옵션값을 초기화 시켜준다.
				ComSetObjValue(formObj.inv_amt_calc_tp, "");
				
				// Payer 의 Attention 정보를 초기화해 줍니다.
				DmtComInitPayerAttention();	
				
				sheetObj.Editable = true;
				sheetObj.CheckAll2(1) = 1;
				sheetObj.Editable = false;
        		break;
        		
        	case IBFAXSEND:
//        		//fax no가 존재하지 않으면
//        		if(ComGetObjValue(formObj.payr_faxnos) == "") {
//        			ComShowCodeMessage("DMT01090");
//        			return;
//        		}
//        		
        		var mrd_file	= "";
//        		var sndr_id		= "";	//id
//        		var sndr_name	= "";	//
//        		var sndr_email	= "";	//
//        		var rcvr_fax_no	= "";	//id;fax_no||id;fax_no
//        		var rcvr_email	= "";	//
//        		var msg1		= "";
        		
        		//MRD 파일
        		var temp_LR  = ComGetObjValue(formObj.bil_to_loc_div_cd);
        		var rhq 	 = ComGetObjValue(formObj.rhq_ofc_cd);
        		var ofc_cd   = ComGetObjValue(formObj.cre_ofc_cd);
        		var cre_cnt_cd = ComGetObjValue(formObj.cre_cnt_cd);
        		var inv_new_rpt_flg = ComGetObjValue(formObj.inv_new_rpt_flg);

        		if(temp_LR == "") {
        			// if(rhq =="HAMRU"){
        			// RHQ 기중에서  특정 Office로 변경됨. 2012.01.11	
       				if (ofc_cd == "ANRSO" ||ofc_cd == "HAMSC"||ofc_cd == "LEHSC"||ofc_cd == "PRGSC"||ofc_cd == "RTMSC") {
        				mrd_file = "EES_DMT_4910.mrd";	
        			}
       				else {
       		 		  if (cre_cnt_cd == "IN") {
        	        	// india office 전용 2012.05.18	
        	        	  mrd_file = "EES_DMT_4912.mrd";
      				  }
       		 		  /* 2017.04.11 수정요청:PREVIEW 와 INV PRINT 동일한 RD 문서를 사용하도록 요청함.(박경문대리)
       		 		  else if (cre_cnt_cd == "MY" && inv_new_rpt_flg == "Y") {
        				  mrd_file = "EES_DMT_4916.mrd";	
       		 		  }
       		 		  */
       		 		  else {
       		 			  mrd_file = "EES_DMT_4901.mrd";  //L
       		 		  }
        			}
        		}
        		else if (temp_LR == "L") {
        			// if(rhq =="HAMRU"){
            		// RHQ 기중에서  특정 Office로 변경됨. 2012.01.11	
           			if (ofc_cd == "ANRSO" ||ofc_cd == "HAMSC"||ofc_cd == "LEHSC"||ofc_cd == "PRGSC"||ofc_cd == "RTMSC") {
        				mrd_file = "EES_DMT_4910.mrd";	
        			}
           			else {
         		 		 if (cre_cnt_cd == "IN") {
              	        // india office 전용 2012.05.18	
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
        		else if (temp_LR == "R") {
        			
        		
        			// if(rhq =="HAMRU"){
            		// RHQ 기중에서  특정 Office로 변경됨. 2012.01.11	
        			if (ofc_cd == "ANRSO" ||ofc_cd == "HAMSC"||ofc_cd == "LEHSC"||ofc_cd == "PRGSC"||ofc_cd == "RTMSC") {
        				mrd_file = "EES_DMT_4911.mrd";	
        			}
        			else {
       		 		  if (cre_cnt_cd == "IN") {
               	        // india office 전용 2012.05.18	
               	          mrd_file = "EES_DMT_4913.mrd";
      				  }
       		 		  /* 2017.04.11 수정요청:PREVIEW 와 INV PRINT 동일한 RD 문서를 사용하도록 요청함.(박경문대리)
       		 		  else if (cre_cnt_cd == "MY" && inv_new_rpt_flg == "Y") {
         				  mrd_file = "EES_DMT_4917.mrd";
              		  }
              		  */
       		 		  else {	
        				  mrd_file = "EES_DMT_4902.mrd";	//R
        			  }
        			}
        		}
        		
//        		//RCV
//        		var arr_faxnos 	= ComGetObjValue(formObj.payr_faxnos).split(";");
//        		var re_faxnos	= "";
//        		
//        		for(var i=0; i< arr_faxnos.length; i++) {
//        			re_faxnos	+= ComGetObjValue(formObj.payer_cd)+";"+arr_faxnos[i];
//        			msg1		+= arr_faxnos[i] +"\n\t";
//        		}
//        		//확인 메시지
//        		if (!ComShowCodeConfirm("DMT01092", msg1))	return;
//        		
//        		rcvr_email		= ComGetObjValue(formObj.payr_emailnos);
//
////참조 멀티일때        		
////        		var tInvNo = "";
////        		for ( var z01 = 1 ; z01 < sheetObjects[0].RowCount+1 ; z01++  ) {
////        		    if ( sheetObjects[0].CellValue(z01,1) == 1 ) {
////        		        tInvNo = sheetObjects[0].CellValue(z01,3) + "," + tInvNo;
////        		    }
////        		}
        		
        		var ma_param = "jspno=4002"
					 + "&invoice_no=" + ComGetObjValue(formObj.dmdt_inv_no)
					 + "&f_cmd=" + SEARCH01
					 + "&cre_ofc_cd=" + ComGetObjValue(formObj.cre_ofc_cd)
					 + "&payer_cd=" + ComGetObjValue(formObj.payer_cd)
					 + "&cond_ida_sac_cd=" + ComGetObjValue(formObj.ida_sac_cd);
            	//MASTER DATA 조회
        		var sXml =  sheetObj.GetSearchXml("EES_DMT_4003GS.do",	ma_param);
        		sheetObj.LoadSearchXml(sXml);
        		ComEtcDataToForm(formObj, sheetObj);
     		
        		//rd_fxeml_rd_param
        		var rdParm =  "/ruseurlmoniker [0]" + " /rfn [" + RDServerIP + "/EES_DMT_4003_RD.do] "		//DETAIL DATA 조회
    						+ " /rv " + rvParmByInvoice(formObj)
    						+ " /rpost [jspno=4002&invoice_no="+ComGetObjValue(formObj.dmdt_inv_no)+"&cre_ofc_cd="+ComGetObjValue(formObj.cre_ofc_cd)+"]"		//jspno, invoice_no
    						;
        		
        		// 2011.10.19 수정
        		var emlTitle;
	       		var emlTemplt;
	       		
	       		if(ComGetObjValue(formObj.session_ofc_cd) != 'SAOSC') {
//	       			emlTitle = "Invoice Number: " + ComGetObjValue(formObj.dmdt_inv_no) + " (B/L No.: SMLM" + ComGetObjValue(formObj.bl_no) + ") " + ComGetObjValue(formObj.act_payr_cust_nm);
	       			emlTitle = "Invoice Number: " + ComGetObjValue(formObj.dmdt_inv_no) + " (B/L No.: SMLM" + ComGetObjValue(formObj.bl_no) + ")";
	       			emlTemplt = "EES_DMT_INVOICE_001.html";
	       		} else {
	       			emlTitle = "Fatura de Demurrage No: " + ComGetObjValue(formObj.dmdt_inv_no) + " (Conhecimento de Embarque: SMLM" + ComGetObjValue(formObj.bl_no) + ")";
	       			emlTemplt = "EES_DMT_INVOICE_002.html";
	       		}
        		
        		ComSetObjValue(formObj.invno,					ComGetObjValue(formObj.dmdt_inv_no));
    			ComSetObjValue(formObj.payc,					ComGetObjValue(formObj.payer_cd));
        		ComSetObjValue(formObj.rd_fxeml_sys_cd,			"DMT");
    			ComSetObjValue(formObj.rd_fxeml_file_name,		mrd_file);
    			ComSetObjValue(formObj.rd_fxeml_bat_flg,		"N");
    			ComSetObjValue(formObj.rd_fxeml_title,			emlTitle);
    			ComSetObjValue(formObj.rd_fxeml_rd_param,		rdParm);
//    			ComSetObjValue(formObj.rd_fxeml_fax_no,			ComGetObjValue(formObj.payr_faxnos));			//rcvr_fax_no
    			ComSetObjValue(formObj.rd_fxeml_fax_sndr_id,	"SM Line");					//sndr_id
    			ComSetObjValue(formObj.rd_fxeml_eml_sndr_nm,	"SM Line");				//sndr_name
    			ComSetObjValue(formObj.rd_fxeml_eml_rcvr_add,	"");	//rcvr_email	//mjchang@hanjin.com
    			ComSetObjValue(formObj.rd_fxeml_eml_atch_file,	ComGetObjValue(formObj.dmdt_inv_no));		//file_name
    			ComSetObjValue(formObj.rd_fxeml_eml_templt,		emlTemplt);// 템플릿 위치 C:/sitectx/ALPS\APP-INF/config/template/mailtemplate/template.htmlmail
    			ComSetObjValue(formObj.rd_fxeml_eml_tmplt_param,"inv_no;" + ComGetObjValue(formObj.dmdt_inv_no) + "|bl_no;" + ComGetObjValue(formObj.bl_no) + "|payer_nm;" + ComGetObjValue(formObj.act_payr_cust_nm));	//"name;mjchang|message;" + mailCtnt);
    			ComSetObjValue(formObj.rd_fxeml_doc_tp,			"I");	//  I : Invoice D : Demend G : GroupDemand O : OTS
        		
//    			ComSetObjValue(formObj.f_cmd, SEARCH05);
//        		setParameters(SEARCH05);
//        		
//                //ComOpenWait Start
//                sheetObj.WaitImageVisible=false;
//                ComOpenWait(true);
//
//        		var sXml = sheetObj.GetSaveXml("DMTCommonFaxEmailGS.do", FormQueryString(formObj));
//        		ComShowMessage(dmtGetMsgText(sXml));
//        		
//                //ComOpenWait End
//                ComOpenWait(false);
        		
        		break;
        		
        	case IBEMAILSEND:
//        		//Email no가 존재하지 않으면
//        		if(ComGetObjValue(formObj.payr_emailnos) == "") {
//        			ComShowCodeMessage("DMT01091");
//        			return;
//        		}
        		
        		var mrd_file	= "";
//        		var sndr_id		= "";	//id
//        		var sndr_name	= "";	//
//        		var sndr_email	= "";	//
//        		var rcvr_fax_no	= "";	//id;fax_no||id;fax_no
//        		var rcvr_email	= "";	//
//        		var msg1		= "";
//        		
        		//MRD 파일
        		var temp_LR  = ComGetObjValue(formObj.bil_to_loc_div_cd);
        		var rhq 	 = ComGetObjValue(formObj.rhq_ofc_cd);
        		var ofc_cd   = ComGetObjValue(formObj.cre_ofc_cd);
        		var cre_cnt_cd  = ComGetObjValue(formObj.cre_cnt_cd);
        		var inv_new_rpt_flg = ComGetObjValue(formObj.inv_new_rpt_flg);
        		
        		if (temp_LR == "") {
        			//if(rhq == "HAMRU"){
            		//RHQ 기중에서  특정 Office로 변경됨. 2012.01.11	
        			if (ofc_cd == "ANRSO" ||ofc_cd == "HAMSC"||ofc_cd == "LEHSC"||ofc_cd == "PRGSC"||ofc_cd == "RTMSC") {
        				mrd_file = "EES_DMT_4910.mrd";	
        			}
        			else {
         		 	   if (cre_cnt_cd == "IN") {
              	        //india office 전용 2012.05.18	
              	          mrd_file = "EES_DMT_4912.mrd";
       				   }
         		 	   /* 2017.04.11 수정요청:PREVIEW 와 INV PRINT 동일한 RD 문서를 사용하도록 요청함.(박경문대리)
         		 	   else if (cre_cnt_cd == "MY" && inv_new_rpt_flg == "Y") {
         				  mrd_file = "EES_DMT_4916.mrd";
             		   }
             		   */
         		 	   else {
                          mrd_file = "EES_DMT_4901.mrd";	//L
             		   }   
        	     	}
        		}
        		else if (temp_LR == "L") {
        			//if(rhq == "HAMRU"){
                	// RHQ 기중에서  특정 Office로 변경됨. 2012.01.11	
        			if (ofc_cd == "ANRSO" ||ofc_cd == "HAMSC"||ofc_cd == "LEHSC"||ofc_cd == "PRGSC"||ofc_cd == "RTMSC") {
              			mrd_file = "EES_DMT_4910.mrd";	
        			}
        			else {
          		 	   if (cre_cnt_cd == "IN") {
                 	       //india office 전용 2012.05.18	
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
        		else if (temp_LR == "R") {
           			//if(rhq == "HAMRU"){
            		//RHQ 기중에서  특정 Office로 변경됨. 2012.01.11	
        			if (ofc_cd == "ANRSO" ||ofc_cd == "HAMSC"||ofc_cd == "LEHSC"||ofc_cd == "PRGSC"||ofc_cd == "RTMSC") {
        				mrd_file = "EES_DMT_4911.mrd";	
        			}
        			else {
          		 	   if (cre_cnt_cd == "IN") {
                 	      //india office 전용 2012.05.18	
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
        		
//        		//SEND
//        		sndr_id 	= ComGetObjValue(formObj.session_usr_id);
//        		sndr_name	= ComGetObjValue(formObj.session_usr_nm);
//        		sndr_email	= ComGetObjValue(formObj.session_email);
//        		
//        		rcvr_email		= ComGetObjValue(formObj.payr_emailnos);
//        		var arr_emails	= ComGetObjValue(formObj.payr_emailnos).split(";");
//        		
//        		for(var i=0 ; i < arr_emails.length; i++) {
//        			msg1		+= arr_emails[i] +"\n\t";
//        		}
//        		//확인 메시지
//        		if (!ComShowCodeConfirm("DMT01093", msg1))	return;
//        		
        		var ma_param = "jspno=4002"
					 		+ "&invoice_no=" + ComGetObjValue(formObj.dmdt_inv_no)
					 		+ "&f_cmd=" + SEARCH01
					 		+ "&cre_ofc_cd=" + ComGetObjValue(formObj.cre_ofc_cd)
					 		+ "&payer_cd=" + ComGetObjValue(formObj.payer_cd)
        					+ "&cond_ida_sac_cd=" + ComGetObjValue(formObj.ida_sac_cd);
            	//MASTER DATA 조회
        		var sXml =  sheetObj.GetSearchXml("EES_DMT_4003GS.do",	ma_param);
        		sheetObj.LoadSearchXml(sXml);
        		ComEtcDataToForm(formObj, sheetObj);
     		
        		//rd_fxeml_rd_param
        		var rdParm =  "/ruseurlmoniker [0]" + " /rfn [" + RDServerIP + "/EES_DMT_4003_RD.do] "		//DETAIL DATA 조회
    						+ " /rv " + rvParmByInvoice(formObj)
    						+ " /rpost [jspno=4002&invoice_no="+ComGetObjValue(formObj.dmdt_inv_no)+"&cre_ofc_cd="+ComGetObjValue(formObj.cre_ofc_cd)+"]"		//jspno, invoice_no
    						;
        		
        		// 2011.10.19 수정
        		var emlTitle;
	       		var emlTemplt;
	       		
	       		if(ComGetObjValue(formObj.session_ofc_cd) != 'SAOSC') {
//	       			emlTitle = "Invoice Number: " + ComGetObjValue(formObj.dmdt_inv_no) + " (B/L No.: SMLM" + ComGetObjValue(formObj.bl_no) + ") " + ComGetObjValue(formObj.act_payr_cust_nm);
	       			emlTitle = "Invoice Number: " + ComGetObjValue(formObj.dmdt_inv_no) + " (B/L No.: SMLM" + ComGetObjValue(formObj.bl_no) + ")";
	       			emlTemplt = "EES_DMT_INVOICE_001.html";
	       		} else {
	       			emlTitle = "Fatura de Demurrage No: " + ComGetObjValue(formObj.dmdt_inv_no) + " (Conhecimento de Embarque: SMLM" + ComGetObjValue(formObj.bl_no) + ")";
	       			emlTemplt = "EES_DMT_INVOICE_002.html";
	       		}  
	       		
        		ComSetObjValue(formObj.invno,					ComGetObjValue(formObj.dmdt_inv_no));
    			ComSetObjValue(formObj.payc,					ComGetObjValue(formObj.payer_cd));
        		ComSetObjValue(formObj.rd_fxeml_sys_cd,			"DMT");
    			ComSetObjValue(formObj.rd_fxeml_file_name,		mrd_file);
    			ComSetObjValue(formObj.rd_fxeml_bat_flg,		"N");
    			ComSetObjValue(formObj.rd_fxeml_title,			emlTitle);
    			ComSetObjValue(formObj.rd_fxeml_rd_param,		rdParm);
    			ComSetObjValue(formObj.rd_fxeml_fax_no,			"");			//rcvr_fax_no
    			ComSetObjValue(formObj.rd_fxeml_fax_sndr_id,	"SM Line");					//sndr_id
    			ComSetObjValue(formObj.rd_fxeml_eml_sndr_nm,	"SM Line");				//sndr_name
//    			ComSetObjValue(formObj.rd_fxeml_eml_rcvr_add,	ComGetObjValue(formObj.payr_emailnos));	//rcvr_email	
    			ComSetObjValue(formObj.rd_fxeml_eml_atch_file,	ComGetObjValue(formObj.dmdt_inv_no));
    			ComSetObjValue(formObj.rd_fxeml_eml_templt,		emlTemplt);// 템플릿 위치 C:/sitectx/ALPS\APP-INF/config/template/mailtemplate/template.htmlmail
    			ComSetObjValue(formObj.rd_fxeml_eml_tmplt_param,"inv_no;" + ComGetObjValue(formObj.dmdt_inv_no) + "|bl_no;" + ComGetObjValue(formObj.bl_no) + "|payer_nm;" + ComGetObjValue(formObj.act_payr_cust_nm));	//"name;mjchang|message;" + mailCtnt);
    			ComSetObjValue(formObj.rd_fxeml_doc_tp,	"I");	//  I : Invoice D : Demend G : GroupDemand O : OTS
        		
//    			ComSetObjValue(formObj.f_cmd, SEARCH06);
//        		setParameters(SEARCH06);
//        		
//                //ComOpenWait Start
//                sheetObj.WaitImageVisible=false;
//                ComOpenWait(true);
//
//        		var sXml = sheetObj.GetSaveXml("DMTCommonFaxEmailGS.do", FormQueryString(formObj));
//        		ComShowMessage(dmtGetMsgText(sXml));
//        		
//                //ComOpenWait End
//                ComOpenWait(false);
        		break;
        		
        	case IBVTCANCEL:      //Virtual Invoice Cancel
        		ComSetObjValue(formObj.f_cmd, COMMAND03);
        		ComSetObjValue(formObj.dmdt_vt_inv_sts_cd, "X");					// X:CANCEL
        		
                //ComOpenWait Start
                sheetObj.WaitImageVisible=false;
                ComOpenWait(true);
                
        		var sXml = sheetObj.GetSaveXml("EES_DMT_4002GS.do", FormQueryString(formObj));

        		//ComOpenWait End
                ComOpenWait(false);  

				// Virtual Invoice Cancel 후 결과처리
				ComSetObjValue(formObj.success_yn, ComGetEtcData(sXml, "SUCCESS_YN"));
				
				// Virtual Invoice Cancel 후 처리로직
				if (ComGetObjValue(formObj.success_yn) == "Y") {
					// DMT01172 : Virtual invoice was cancelled successfully
					ComShowCodeMessage("DMT01172", "Virtual invoice");

					// Virtual Invoice 가 취소된 경우, 보여줄 데이터가 존재할 필요가 없으므로 현 화면을 종료한다.
					window.close();					
				}
	        break;
        		
        	case IBVTSEARCH:
        		ComSetObjValue(formObj.f_cmd, COMMAND04);

                //ComOpenWait Start
                sheetObj.WaitImageVisible=false;
                ComOpenWait(true);
                
        		var sXml = sheetObj.GetSaveXml("EES_DMT_4002GS.do", FormQueryString(formObj));

        		//ComOpenWait End
                ComOpenWait(false);  

				// Virtual Invoice Cancel 후 결과처리
                return ComGetEtcData(sXml, "EXISTS_YN") == "Y"; 
				
        	break;
        	
        	case IBPAYRSEARCH:
        		ComSetObjValue(formObj.f_cmd, SEARCH28);
        		        		
        		//ComOpenWait Start
        		sheetObj.WaitImageVisible=false;
        		ComOpenWait(true);				
				//2.조회조건으로 조회실행
				var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));        		
        		//ComOpenWait End
        		ComOpenWait(false);
        		
        		// DMT PAYR CHECK 후 결과처리
        		return ComGetEtcData(sXml, "PAYR_FLG") == 'Y'; 
        		
        		break;
        	
        }
    }
    
	/**
	 * EES_DMT_4013, EES_DMT_4002 팝업 호출
	 * @param sheetObj
	 * @param formObj
	 * @param srcName
	 * @return
	 */
	function openPopupWindow(sheetObj, formObj, srcName) {
		 
		if(srcName == "btn_preview") {
			//PayerCode가 없으면 메시지 처리
			if(ComGetObjValue(formObj.payer_cd) == "") {
				ComShowCodeMessage("DMT02002", "Payer Code");
			}
			
			
			var temp_LR = ComGetObjValue(formObj.bil_to_loc_div_cd);
			var invoice_LR = "";
			if(temp_LR == "") {
				invoice_LR = "L";
			}else if(temp_LR == "L") {
				invoice_LR = "L";
			}else if(temp_LR == "R") {
				invoice_LR = "R";
			}
				
			var url = "EES_DMT_4003.do"
				+"?payr_cntc_pnt_phn_no="+ComGetObjValue(formObj.org_payr_cntc_pnt_phn_no)
				+"&payr_cntc_pnt_fax_no="+ComGetObjValue(formObj.org_payr_cntc_pnt_fax_no)
				+"&payr_cntc_pnt_eml="+ComGetObjValue(formObj.org_payr_cntc_pnt_eml)
				//+"&dmdt_payr_cntc_pnt_nm="+ComGetObjValue(formObj.org_dmdt_payr_cntc_pnt_nm)
				+"&invoice_no="+ComGetObjValue(formObj.dmdt_inv_no)
				+"&invoice_LR="+invoice_LR
				+"&cre_ofc_cd="+ComGetObjValue(formObj.cre_ofc_cd)
				+"&payer_cd="+ComGetObjValue(formObj.payer_cd)
				+"&bkg_no="+ComGetObjValue(formObj.bkg_no)
				+"&pod_cd="+ComGetObjValue(formObj.pod_cd)
				+"&bl_no="+ComGetObjValue(formObj.bl_no)
				+"&dmdt_trf_cd="+ComGetObjValue(formObj.dmdt_trf_cd)
				+"&rhq_ofc_cd="+ComGetObjValue(formObj.rhq_ofc_cd)
				+"&cre_cnt_cd="+ComGetObjValue(formObj.cre_cnt_cd)
				+"&inv_new_rpt_flg="+ComGetObjValue(formObj.inv_new_rpt_flg)
				+"&cond_ida_sac_cd=" + ComGetObjValue(formObj.ida_sac_cd)
				+"&jspno=4002";

			//var returnValue = ComOpenWindowCenter(url, "EES_DMT_4003", "1036","735", true);
			var returnValue = ComOpenWindowCenter(url, "EES_DMT_4003", "950","735", true);
		} else if(srcName == "btn_cancel") {
			
			if (ComGetObjValue(formObj.cre_ofc_cd) == ComGetObjValue(formObj.session_ofc_cd)) {
				
				if (ComShowCodeConfirm('DMT03025')) {
					
					// virtual invoice 일 경우
					if (ComGetObjValue(formObj.dmdt_vt_inv_sts_cd) == "Y") {
						doActionIBSheet(sheetObjects[0],document.form,IBVTCANCEL);
					}
					else {
						var url = "EES_DMT_4106.do"
							+"?dmdt_inv_no="+ComGetObjValue(formObj.dmdt_inv_no)
							+"&cre_ofc_cd="+ComGetObjValue(formObj.cre_ofc_cd)
							+"&dmdt_trf_cd="+ComGetObjValue(formObj.dmdt_trf_cd)
							+"&ida_tax_appl_tm="+ComGetObjValue(formObj.ida_tax_appl_tm)
							+"&cre_cnt_cd="+ComGetObjValue(formObj.cre_cnt_cd);
						
						var returnValue = ComOpenWindowCenter(url, "EES_DMT_4106", "420","450", true);
						if (returnValue == "Y") {
					    	// 발행한 invoice 정보일 경우, 금액계산을 실행하지 않고, 조회된 결과를 그대로 보여주도록 옵션값을 설정한다.
							ComSetObjValue(formObj.inv_amt_calc_tp, "R"); 
					    	// 발행한 invoice 정보를 조회합니다.							
							doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
					    	// 조회가 끝나면 정상적으로 Tax Amount, Invoice Amount 계산이 수행될 수 있도록 옵션값을 초기화 시켜준다.
							ComSetObjValue(formObj.inv_amt_calc_tp, "");							
						}
					}
				}
			}
			else {
				ComShowCodeMessage('DMT03024', ComGetObjValue(formObj.cre_ofc_cd), ComGetObjValue(formObj.session_ofc_cd));
			}
		}else if(srcName == "btn_set") {
			var url = "EES_DMT_4101.do"
				+"?issoff="+ComGetObjValue(formObj.cre_ofc_cd)
				+"&tftp2="+ComGetObjValue(formObj.dmdt_trf_cd)
				+"&sheetp=I"
				+"&invoice_issue="+ComGetObjValue(formObj.invoice_issue)
				+"&jspno=EES_DMT_4002";
			var returnValue = ComOpenWindowCenter(url, "EES_DMT_4101", "725","780", true, "yes");
			
			//Sheet Set 있는지 없는지 조회한다.
			//Sheet Set가 없을 경우에는 Preview, Print, Fax send, Email send를 버튼 클릭시 Alert MSG을 띄워 막고자 합니다
			doActionIBCombo(sheetObjects[1],document.form,IBSEARCH,COMMAND13,"RESULT","");		
			
		}else if(srcName == "btn_option") {
			var url = "EES_DMT_4103.do"
				+"?issoff="+ComGetObjValue(formObj.cre_ofc_cd)
				+"&jspno=EES_DMT_4002"
				+"&invoice_issue="+ComGetObjValue(formObj.invoice_issue)
				+"&tftp="+ComGetObjValue(formObj.dmdt_trf_cd)
				;
			var returnValue = ComOpenWindowCenter(url, "EES_DMT_4103", "625","650", true);
			
			
		}else if(srcName == "btn_payer") {
			if(ComGetObjValue(formObj.payer_cd) == null || ComGetObjValue(formObj.payer_cd) == "") {
				ComShowCodeMessage("DMT00182");
				return;
			}
			var ofc_cd = "";
			if(ComGetObjValue(formObj.invoice_issue) == "1") {
				ofc_cd = ComGetObjValue(formObj.session_ofc_cd);
			}else{	//ComGetObjValue(formObj.invoice_issue) == "2"
				ofc_cd = ComGetObjValue(formObj.cre_ofc_cd);
			}

			var url = "EES_DMT_4104.do"
				+"?s_ofc_cd="+ofc_cd
				+"&s_cust_cd="+ComGetObjValue(formObj.payer_cd)
				+"&s_bkg_no="+ComGetObjValue(formObj.bkg_no)
				+"&s_pod_cd="+ComGetObjValue(formObj.pod_cd)
				+"&jspno=EES_DMT_4002"
				+"&attn="+ComGetObjValue(formObj.dmdt_payr_cntc_pnt_nm)
				+"&telno="+ComGetObjValue(formObj.payr_cntc_pnt_phn_no)
				+"&faxno="+ComGetObjValue(formObj.payr_cntc_pnt_fax_no)
				+"&email="+ComGetObjValue(formObj.payr_cntc_pnt_eml)
				;
			var returnValue = ComOpenWindowCenter(url, "EES_DMT_4104", "825","620", true);
		}else if(srcName == "btn_fax") {
			if(ComGetObjValue(formObj.org_payer_cd) == null || ComGetObjValue(formObj.org_payer_cd) == "") {
				ComShowCodeMessage("DMT00182");
				return;
			}
			var ofc_cd = "";
			if(ComGetObjValue(formObj.invoice_issue) == "1") {
				return;
			}else{	//ComGetObjValue(formObj.invoice_issue) == "2"
				ofc_cd = ComGetObjValue(formObj.cre_ofc_cd);
			}

			var url = "EES_DMT_4107.do"
				+"?s_ofc_cd="+ofc_cd
				+"&s_cust_cd="+ComGetObjValue(formObj.org_payer_cd)
				+"&s_bkg_no="+ComGetObjValue(formObj.bkg_no)
				+"&s_pod_cd="+ComGetObjValue(formObj.pod_cd)
				+"&jspno=4002"
				+"&telno="+ComGetObjValue(formObj.org_payr_cntc_pnt_phn_no)
				+"&faxno="+ComGetObjValue(formObj.org_payr_cntc_pnt_fax_no)
				+"&email="+ComGetObjValue(formObj.org_payr_cntc_pnt_eml)
				+"&cntc_seq="+ComGetObjValue(formObj.cust_cntc_pnt_seq)
				;
			ComOpenWindowCenter(url, "EES_DMT_4107", "500","300", true);
		}else if(srcName == "btn_email") {
			if(ComGetObjValue(formObj.org_payer_cd) == null || ComGetObjValue(formObj.org_payer_cd) == "") {
				ComShowCodeMessage("DMT00182");
				return;
			}
			var ofc_cd = "";
			if(ComGetObjValue(formObj.invoice_issue) == "1") {
				return;
			}else{	//ComGetObjValue(formObj.invoice_issue) == "2"
				ofc_cd = ComGetObjValue(formObj.cre_ofc_cd);
			}

			var url = "EES_DMT_4108.do"
				+"?s_ofc_cd="+ofc_cd
				+"&s_cust_cd="+ComGetObjValue(formObj.org_payer_cd)
				+"&s_bkg_no="+ComGetObjValue(formObj.bkg_no)
				+"&s_pod_cd="+ComGetObjValue(formObj.pod_cd)
				+"&jspno=4002"
				+"&telno="+ComGetObjValue(formObj.org_payr_cntc_pnt_phn_no)
				+"&faxno="+ComGetObjValue(formObj.org_payr_cntc_pnt_fax_no)
				+"&email="+ComGetObjValue(formObj.org_payr_cntc_pnt_eml)
				+"&cntc_seq="+ComGetObjValue(formObj.cust_cntc_pnt_seq)
				;
			ComOpenWindowCenter(url, "EES_DMT_4108", "500","300", true);		
		}else if(srcName == "btn_sendinghistory") {
			var url = "EES_DMT_7006_P.do"
				+"?jspno=EES_DMT_4002"
				+"&invoice="+ComGetObjValue(formObj.dmdt_inv_no)
				+"&selectOpt=1"
				;
			var returnValue = ComOpenWindowCenter(url, "EES_DMT_7006", "1036","690", true);
		}
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
	
    //RD 오픈
    function rdOpen(rdObject,formObj, sheetObj){
    	var Rdviewer = rdObject ;

    	//var path = formObj.mrd.value;		//mrd_path
    	var path 		= "";
    	var invoice_LR 	= ComGetObjValue(formObj.bil_to_loc_div_cd);
    	var rhq 	    = ComGetObjValue(formObj.rhq_ofc_cd);
    	var ofc_cd      = ComGetObjValue(formObj.cre_ofc_cd);
    	var cre_cnt_cd  = ComGetObjValue(formObj.cre_cnt_cd);

		if (invoice_LR == "") {
			// if(rhq =="HAMRU"){
			// RHQ 기중에서  특정 Office로 변경됨. 2012.01.11	
			if (ofc_cd == "ANRSO" ||ofc_cd == "HAMSC"||ofc_cd == "LEHSC"||ofc_cd == "PRGSC"||ofc_cd == "RTMSC"){
				path="apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4910.mrd";
			}
			else {
		 		if (cre_cnt_cd == "IN") {
	        		//india office 전용 2012.05.18	
	        		path="apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4912.mrd";
		 		}
		 		/* 2017.04.11 수정요청:PREVIEW 와 INV PRINT 동일한 RD 문서를 사용하도록 요청함.(박경문대리)
		 		else if (cre_cnt_cd == "MY") {
	        		path="apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4916.mrd";
	        	}
	        	*/
		 		else {
				    path="apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4901.mrd";
	        	}    
			}
		}
		else if (invoice_LR == "L") {
           //if(rhq =="HAMRU"){
           //RHQ 기중에서  특정 Office로 변경됨. 2012.01.11
			if (ofc_cd == "ANRSO" ||ofc_cd == "HAMSC"||ofc_cd == "LEHSC"||ofc_cd == "PRGSC"||ofc_cd == "RTMSC"){
				path="apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4910.mrd";
			}
			else {
		 		if (cre_cnt_cd == "IN") {
	        		//india office 전용 2012.05.18	
	        		path="apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4912.mrd";
		 		}
		 		/* 2017.04.11 수정요청:PREVIEW 와 INV PRINT 동일한 RD 문서를 사용하도록 요청함.(박경문대리)
		 		else if (cre_cnt_cd == "MY") {
	        		path="apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4916.mrd";
	        	}
	        	*/
		 		else {
			        path="apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4901.mrd";
	        	}   
			}    
		}
		else if (invoice_LR == "R") {
//			// if(rhq =="HAMRU"){
//			// RHQ 기중에서  특정 Office로 변경됨. 2012.01.11	
			if (ofc_cd == "ANRSO" ||ofc_cd == "HAMSC"||ofc_cd == "LEHSC"||ofc_cd == "PRGSC"||ofc_cd == "RTMSC") {
				path="apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4911.mrd";
			}
			else {
		 		if (cre_cnt_cd == "IN") {
	        		// india office 전용 2012.05.18	
	        		path="apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4913.mrd";
		 		}
		 		/* 2017.04.11 수정요청:PREVIEW 와 INV PRINT 동일한 RD 문서를 사용하도록 요청함.(박경문대리)
		 		else if (cre_cnt_cd == "MY") {
	        		path="apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4917.mrd";	
	        	}
	        	*/
		 		else {
                    path="apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4902.mrd";
	        	}    
			}    
		}
		
		var ma_param = "jspno=4002"
					 + "&invoice_no=" + ComGetObjValue(formObj.dmdt_inv_no)
					 + "&f_cmd=" + SEARCH01
					 + "&cre_ofc_cd=" + ComGetObjValue(formObj.cre_ofc_cd)
					 + "&payer_cd=" + ComGetObjValue(formObj.payer_cd)
		             + "&cond_ida_sac_cd=" + ComGetObjValue(formObj.ida_sac_cd);
    	//MASTER DATA 조회
		var sXml =  sheetObj.GetSearchXml("EES_DMT_4003GS.do",	ma_param);
		sheetObj.LoadSearchXml(sXml);
		ComEtcDataToForm(formObj, sheetObj);
		
		//RD 호출
		var rdParm =  "/ruseurlmoniker [0]" + " /rfn [" + RDServerIP + "/EES_DMT_4003_RD.do] "		//DETAIL DATA 조회
					+ " /rv " + rvParmByInvoice(formObj)
					+ " /rpost [jspno=4002&invoice_no="+ComGetObjValue(formObj.dmdt_inv_no)+"&cre_ofc_cd="+ComGetObjValue(formObj.cre_ofc_cd)+"]"		//jspno, invoice_no
					;
		
		Rdviewer.FileOpen(RD_path+path, rdParm);
		Rdviewer.PrintDialog();
    }   	
    
    /**
     * rv By Invoice 
     */ 
    function rvParmByInvoice(formObj){
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
        } else {
        	rd_payr_addr01 = "";
        }
        if ( paryInfoAddrCnt >= 2 ) {
        	rd_payr_addr02 = paryInfoAddr[1];
        } else {
        	rd_payr_addr02 = "";
        }
        if ( paryInfoAddrCnt >= 3 ) {
        	rd_payr_addr03 = paryInfoAddr[2];
        } else {
        	rd_payr_addr03 = "";
        }
        if ( paryInfoAddrCnt >= 4 ) {
        	rd_payr_addr04 = paryInfoAddr[3];
        } else {
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
					" RD_CUST_REF_PRN_FLG[" + ComGetObjValue(formObj.rd_cust_ref_prn_flg) +"]"+
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
    
	// REMARK MESSAGE
	function remark_alert(srcName) {
		if(srcName == "btn_cremark") {
			var formObj = document.form;
			var cancel_rmk	= ComGetObjValue(formObj.cxl_rmk);		//	cancel_remark
			var cancel_date	= ComGetObjValue(formObj.upd_dt);		//	update_dt
			var ofc_cd 		= ComGetObjValue(formObj.upd_ofc_cd);	//	update_ofc_cd
			var usr_id 		= ComGetObjValue(formObj.upd_usr_id);	//update_usr_id
			var usr_name 	= ComGetObjValue(formObj.upd_usr_nm);	//update_usr_nm
			var msg 		= cancel_rmk
							+ "\n\nCancel Date: "+cancel_date
							+ "\nOffice: "+ofc_cd
							+ "\nUser ID: "+usr_id
							+ "\nUser Name: "+usr_name;
			ComShowMessage(msg);
		}else if(srcName == "btn_hremark") {
			var formObj = document.form;
			var hold_rmk	= ComGetObjValue(formObj.inv_hld_rmk);			//hold_remark
			var hold_date	= ComGetObjValue(formObj.ar_if_dt);		//ar_if_dt
			var ofc_cd 		= ComGetObjValue(formObj.ar_if_ofc_cd);	//ar_if_ofc_cd
			var usr_id 		= ComGetObjValue(formObj.ar_if_usr_id);	//ar_if_usr_id
			var usr_name 	= ComGetObjValue(formObj.ar_if_usr_nm);	//ar_if_usr_nm
			var msg 		= hold_rmk
							+ "\n\nHold Date: "+hold_date
							+ "\nOffice: "+ofc_cd
							+ "\nUser ID: "+usr_id
							+ "\nUser Name: "+usr_name;
			ComShowMessage(msg);
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
		
		if (sAction == SEARCH) {
			ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.session_ofc_cd));
			
		}
		else if (sAction == MULTI) {
			if (!formObj.chk_tax.checked) {
				ComSetObjValue(formObj.tax_rto, "0");
			}
			if (ComGetObjValue(formObj.s_chg_type) == "A" || ComGetObjValue(formObj.s_chg_type) == "G") {
				ComSetObjValue(formObj.chg_type, "G");
			}
			else if (ComGetObjValue(formObj.s_chg_type) == "B") {
				ComSetObjValue(formObj.chg_type, "B");
			}
		}
		else if (sAction == MULTI01) {
			if (!formObj.chk_tax.checked) {
				if (parseFloat(ComGetObjValue(formObj.tax_rto_dis)) == 0) {
					ComSetObjValue(formObj.tax_rto, "0");
				}
				else {
					ComSetObjValue(formObj.tax_rto, ComGetObjValue(formObj.tax_rto_dis));
				}
			}
		}
		
	}
    function initAxonControl() {
		axon_event.addListener('mouseover', 'obj_mouseover', 'txt_remark','txt_aft_inv_adj_amt','btn_cremark','btn_hremark');	// onMouseover 이벤트
		axon_event.addListener('mouseout', 'obj_mouseout', 'txt_remark','txt_aft_inv_adj_amt','btn_cremark','btn_hremark');	// onMouseout 이벤트
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		axon_event.addListener('change',	'obj_change', 'inv_ref_no','ida_cgst_amt','ida_sgst_amt','ida_igst_amt','ida_ugst_amt');
		axon_event.addListenerFormat('focus',	'obj_focus',	form); //- 포커스 들어갈때
		axon_event.addListenerFormat('blur',	'obj_blur',		form); //- 포커스 나갈때

    }
    
    function obj_change() {
 		var obj = event.srcElement;
		var formObj = document.form;
		
		switch(obj.name) {
			case "inv_ref_no":
				//Cust. Ref 입력값 체크
				if (ComGetLenByByte(formObj.inv_ref_no) > 20) {
					ComShowCodeMessage('COM12142', "Cust. Ref", '20');
					ComSetFocus(formObj.inv_ref_no);
				}				
				break;
				
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
				DmtComDoActionText(sheetObjects[0], formObj, obj, SEARCH20);
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
	  		case 'txt_remark':
	  			msg = 'Invoice Remark will be included in the Invoice Sheet';
	  			x = x;
	  			y = y-20;
	  			skn.left = x;
	  			skn.top  = y+20;
	  			break;
	  			
	  		case 'txt_aft_inv_adj_amt':
	  			msg = 'Adjusted Billable AMT after the Invoice was issued';
	  			x = x;
	  			y = y-20;
	  			skn.left = x;
	  			skn.top  = y-20;
	  			break;
	  		
	  		case 'btn_cremark':
	  			msg = 'Invoice Cancel Remark';
	  			x = x-20;
	  			y = y-20;
	  			skn.left = x;
	  			skn.top  = y+20;
	  			break;
	  			
	  		case 'btn_hremark':
	  			msg = 'Invoice Hold Remark';
	  			x = x-20;
	  			y = y-20;
	  			skn.left = x;
	  			skn.top  = y+20;
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
		//Invoice Issue 전
//		if(ComGetObjValue(formObj.invoice_issue) == "1") {
			ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.session_ofc_cd));
//		//Invoice Issue 후
//		}else{
//			ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.s_ofc_cd));
//		}
		
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
							//ComSetObjValue(formObj.f_cmd, SEARCHLIST05);
							//setComboParameters(sComboAction, sObj);
							
							var param = "f_cmd=" + SEARCHLIST05
							  + "&jspno=4002" 
							  + "&ofc_cd=" + formObj.session_ofc_cd.value
							  ; 
							
							//2.조회조건으로 조회실행					
							//var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
							var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", param);
							
							ComClearCombo(formObj.inv_curr_cd);
							comboDatas = ComGetEtcData(sXml, sComboKey);
							if (comboDatas != undefined) {
								addComboItem(formObj.inv_curr_cd,comboDatas,true);
							}
							break;		
						
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
							
						//Payer별 Email, FAX 번호를 조회한다.
						case COMMAND02:
							//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							//ComSetObjValue(formObj.f_cmd, COMMAND02);
							//setComboParameters(sComboAction, sObj);
							var ofcCd = ComGetObjValue(formObj.dmdt_vt_inv_yn) == "Y" ?  ComGetObjValue(formObj.session_ofc_cd) : ComGetObjValue(formObj.cre_ofc_cd);
							
							var param = "f_cmd=" + COMMAND02
									  + "&payer_cd="    + ComGetObjValue(formObj.payer_cd) 
									  + "&dmdt_trf_cd=" + ComGetObjValue(formObj.dmdt_trf_cd) 
									  + "&ofc_cd="      + ofcCd
									  ;     
							var sXml = sheetObj.GetSearchXml("EES_DMT_4002GS.do", param);
							sheetObj.LoadSearchXml(sXml);
							
							//2.조회조건으로 조회실행					
							//var sXml = sheetObj.GetSearchXml("EES_DMT_4002GS.do", FormQueryString(formObj));
							
							//3.조회후 결과처리
							ComSetObjValue(formObj.payr_faxnos, 	ComGetEtcData(sXml, "FAX_NO"));
							ComSetObjValue(formObj.payr_emailnos, 	ComGetEtcData(sXml, "EMAIL_NO"));
							break;
							
						//Sheet Option 조회
						case COMMAND14:
							//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							ComSetObjValue(formObj.f_cmd, COMMAND14);
							setComboParameters(sComboAction, sObj);
							
							//2.조회조건으로 조회실행					
							var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
							
							//3.조회후 결과처리
							ComSetObjValue(formObj.bil_to_loc_div_cd, 	ComGetEtcData(sXml, "BIL_TO_LOC_DIV_CD"));
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
					//ComOpenPopupWithTarget('/hanjin/COM_ENS_0C1.do', 700, 480, "getSvcProvdr", "1,0,1,1,1,1", true);
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
    	var formObj = document.form;
    	
    	var payerCd = aryPopupData[0][3];
    	var payerNm = aryPopupData[0][4];
    	
    	ComSetObjValue(formObj.payer_cd, payerCd);
    	ComSetObjValue(formObj.payer_nm, payerNm);

		// Payer 의 Attention 정보를 초기화해 줍니다.
		DmtComInitPayerAttention();	

    	// Payer 정보가 변경되면 Payer 에 해당되는 India Tax Ratio 를 조회해서 Invoice Amount 를 재계산합니다.
    	DmtComSearchIdaTaxRtoByPayer();
    }    
    
    /*
  	 * Service Provider Inquiry 공통팝업 호출
  	 */
    function getSvcProvdr(aryPopupData) {
    	document.form.trucker_cd.value = aryPopupData[0][2];
    	document.form.trucker_nm.value = aryPopupData[0][4];
    }
  	 
    function setComboParameters(sComboAction, sObj) {
    	var formObj = document.form;
    	ComSetObjValue(formObj.curr_cd, ComGetObjValue(formObj.inv_curr_cd));
    	
    	if (sComboAction == COMMAND13) {
    		ComSetObjValue(formObj.dmdt_sh_tp_cd, 	"I");
    		if (ComGetObjValue(formObj.invoice_issue) == "1" || ComGetObjValue(formObj.dmdt_vt_inv_yn) == "Y") {
    			ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.session_ofc_cd));
    		}
    		else {
    			ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.cre_ofc_cd));
    		}
    	}
    	else if (sComboAction == COMMAND02) {
    		ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.cre_ofc_cd));
    	}
    	else if (sComboAction == COMMAND14) {
    		ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.cre_ofc_cd));
    	}
    	
    	ComSetObjValue(formObj.f_cmd, sComboAction);
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
		
		//조회 후 계산 이벤트 발생 하면 안된다.
		if (ComGetObjValue(formObj.invoice_issue) == 1) {
		
			if (sheetObj.ColSaveName(Col) == "checkBox") {	//checkbox
				
				DmtComCalcAmt(sheetObj, Row, Value);
				var iCnt = parseInt(ComGetObjValue(formObj.cntr_cnt));
				
				if (iCnt == 0) {
					ComShowCodeMessage("DMT00169");
					//save비활성화
					ComBtnDisable("btn_save");
				}
				else {
					//save활성화
					ComBtnEnable("btn_save");
				}
			}
		}
	}
	
	
	//전체선택 기능
    function sheet1_OnClick(sheetObj, row, col, Value){
    	var formObj = document.form;
    	
    	if(ComGetObjValue(formObj.invoice_issue) == "1") {
            if(sheetObj.ColSaveName(col) == "checkBox")
                ComSyncAllCheck(sheetObj, col, Value);
    	}
    	
    }	
    
	/*
	 * Tool Tip(Issued, Cancelled, Credit)
	 */
	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y ) {
		//마우스 위치를 행과 컬럼과 값 가져오기
		var Row = sheetObj.MouseRow;
		var Col = sheetObj.MouseCol;
		var sName = sheetObj.ColSaveName(sheetObj.MouseCol);
		
		if(sName == "gb"){
			var sText = sheetObj.CellText(Row,Col);

			//풍선도움말 만들기
			if(Row == 0 || Row == 1) {
				sheetObj.MouseToolTipText = "General/Balance Charge Type";
				sheetObj.MousePointer = "Hand";
			}else{
				sheetObj.MouseToolTipText = "";
			}
		}else{
			sheetObj.MouseToolTipText = "";
		}
	}
	
	function sheet1_OnSearchEnd(sheetObj,ErrMsg) {		
		// 차이 발생부분 색상 변경
		for (var i = 2; i < sheetObj.TotalRows+2; i++) {
			var flag1 = sheetObj.CellValue(i, "org_chg_amt_flg");
			var flag2 = sheetObj.CellValue(i, "expt_amt_flg");
			var flag3 = sheetObj.CellValue(i, "aft_expt_dc_amt_flg");
			var flag4 = sheetObj.CellValue(i, "bil_amt_flg");
			
			if (flag1 == 'Y') {
				sheetObj.CellFontColor(i, 'mn_org_chg_amt') = sheetObj.RgbColor(255, 0, 0);
				sheetObj.CellFont("FontBold", i, 'mn_org_chg_amt') = true;
			}
			if (flag2 == 'Y') {
				sheetObj.CellFontColor(i, 'dmdt_expt_amt') = sheetObj.RgbColor(255, 0, 0);
				sheetObj.CellFont("FontBold", i, 'dmdt_expt_amt') = true;
			}
			if (flag3 == 'Y') {
				sheetObj.CellFontColor(i, 'chg_dc_amt') = sheetObj.RgbColor(255, 0, 0);
				sheetObj.CellFont("FontBold", i, 'chg_dc_amt') = true;
			}
			if (flag4 == 'Y') {
				sheetObj.CellFontColor(i, 'mn_bil_amt') = sheetObj.RgbColor(255, 0, 0);
				sheetObj.CellFont("FontBold", i, 'mn_bil_amt') = true;
			}
		}
		
	}
    
	function setRpt() {
  		var formObj = document.form;
  		if (formObj.inv_new_rpt.checked == true)
  			formObj.inv_new_rpt_flg.value = "Y";
  		else
  			formObj.inv_new_rpt_flg.value = "N";
	}

	/////////////////////////////////////////////////////////////////////////////////////
	/**
	 * SheetOption 팝업화면에서 변경시 자동변경 처리하는 로직임(Due Date, Credit Term, Tax Rate)
	 */
	function getSheetOptionData(cr_term_dys, is_dt_prn_flg, tax_rto) {
		var formObj = document.form;
		
		var d_is_dt_prn_flg = "";
		
		if (cr_term_dys == "0" && is_dt_prn_flg == "2") {
			d_is_dt_prn_flg = "N";
		} 
		else {
			d_is_dt_prn_flg = "Y";
		}
		
		if (cr_term_dys != null && cr_term_dys != "") {
			//Invoice Issue 이전
			if (ComGetObjValue(formObj.invoice_issue) == "1") {
				if (cr_term_dys == "0") {
					if (d_is_dt_prn_flg == "Y"){
						//현재일자
						ComSetObjValue(formObj.due_date, ComGetObjValue(formObj.ofc_curr_date));
						//날짜 하이픈 처리
						ComSetObjValue(formObj.due_date, ComGetMaskedValue(formObj.due_date.value, "ymd"));
						//0
						ComSetObjValue(formObj.cr_term_dys, "0");
						
					} 
					else if (d_is_dt_prn_flg == "N") {
						ComSetObjValue(formObj.due_date, "********");
						ComSetObjValue(formObj.cr_term_dys, "");
					}
				} 
				else if (parseInt(cr_term_dys) > 0) {
					//현재일자
					ComSetObjValue(formObj.due_date, ComGetObjValue(formObj.ofc_curr_date));
					//날짜 하이픈 처리
					ComSetObjValue(formObj.due_date, ComGetMaskedValue(formObj.due_date.value, "ymd"));
					ComSetObjValue(formObj.cr_term_dys, cr_term_dys);
				}
			//Invoice Issue 이후
			} 
			else if(ComGetObjValue(formObj.invoice_issue) == "2") {
				if (cr_term_dys == "0") {
					if (d_is_dt_prn_flg == "Y") {
						//Invoice 일자
						ComSetObjValue(formObj.due_date, ComGetObjValue(formObj.cre_dt));
						//0
						ComSetObjValue(formObj.cr_term_dys, "0");
						
					}
					else if (d_is_dt_prn_flg == "N") {
						ComSetObjValue(formObj.due_date, "********");
						ComSetObjValue(formObj.cr_term_dys, "");
					}
				} 
				else {
					//Invoice 일자 + cr_term_dys
					var cal_due_date = ComGetDateAdd(ComGetObjValue(formObj.cre_dt), "D", parseInt(cr_term_dys)); 
					ComSetObjValue(formObj.due_date, cal_due_date);
					ComSetObjValue(formObj.cr_term_dys, cr_term_dys);
				}
			}
		}
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
		
		//searchSeetOption
		doActionIBCombo(sheetObjects[1],document.form,IBSEARCH,COMMAND14,"","");
	}
	////////////////////////////////////////////////////////////////////////
	
	
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

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
    		
    		switch(sAction) {
    			case IBSAVE:
    				if (ComGetObjValue(formObj.payer_cd) == "") {
    					ComAlertFocus(formObj.payer_cd, ComGetMsg("DMT01052"));
						return false;
    				}
    				
    				//AR-IF 된 상태의 INVOICE는 수정하지 못하고 메시지 처리를 함.
    				if (ComGetObjValue(formObj.dmdt_ar_if_cd) == "Y") {
    					ComShowCodeMessage("DMT03022");
    					return false;
    				}
    				
    				//2010.12.28. invoice cur 없을경우 에러 처리
    				if (ComGetObjValue(formObj.inv_curr_cd) == "") {
    					ComShowCodeMessage("DMT02002" , "INV Cur.");
    					return false;
    				}
    				
    				if (ComGetLenByByte(formObj.inv_ref_no) > 20) {
    					ComShowCodeMessage('COM12142', "Cust. Ref", '20'); 
    					ComSetFocus(formObj.inv_ref_no);
    					return false;
    				}
    				
    				break;
    			
    			case IBARIF:
    				//로그인 사용자가 미주지역이 아니면 payer가 vendor가 입력되어있으면 메시지 처리한다.
    				//if((ComGetObjValue(formObj.session_cnt_cd) != "US") && (ComGetObjValue(formObj.session_cnt_cd) != "CA")) {
    				if ((ComGetObjValue(formObj.usr_cnt_cd) != "US") && (ComGetObjValue(formObj.usr_cnt_cd) != "CA")) {	//2010.04.04.
    					if (ComGetObjValue(formObj.payer_cd).length <= 6) {
    						ComShowCodeMessage("DMT00185");
        					return false;
    					}
    				}
    				break;
    		}
        }

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
    
    function unLoadPage() {
		window.returnValue="Y";
    }
    
    // 가상Invoice 인 경우, 버튼 상태 설정.
    function setScreenStatusOfVtInv() {
    	var formObj = document.form;
    	
    	//1. 입력부분 비활성화
   		//contorlInput(true);
		//2. Sheet Set 상태 설정
		ComBtnDisable("btn_set");
		//3. Sheet Option 상태 설정
		ComBtnDisable("btn_option");		
		//4. Sending History 상태 설정
		ComBtnDisable("btn_sendinghistory");		
		//5. C.Remark(s) 상태 설정
		ComBtnDisable("btn_cremark");
		document.getElementById("btn_cremark").style.color = "";
		//6. H.Remark(s) 상태 설정
		ComBtnDisable("btn_hremark");
		document.getElementById("btn_hremark").style.color = "";
		//7. Save 상태 설정
		ComBtnEnable("btn_save");
		//8. Cancel 상태 설정
		ComBtnEnable("btn_cancel");		
		//9. Preview 상태 설정
		ComBtnDisable("btn_preview");
		//10. INV Print 상태 설정
		ComBtnDisable("btn_print");
		//11. Fax Send 상태 설정
		ComBtnDisable("btn_fax");
		//12. Email Send 상태 설정
		ComBtnDisable("btn_email");
		//13. Payer Info. 상태 설정
		ComBtnEnable("btn_payer");		
		//14. A/R I/F 상태 설정
		ComBtnDisable("btn_arif");
		
		//15. Credit Note 라벨 설정 
		document.getElementById('cr_nm').innerHTML = "Credit Note";
		
		//16. Due Date 날짜 하이픈 처리
		if (ComGetObjValue(formObj.due_date) != "********") {
			ComSetObjValue(formObj.due_date, ComGetMaskedValue(formObj.due_date.value, "ymd"));
		}
		
		//17. 수정가능 처리
		sheetObjects[0].CheckAll2(1) = 1;
    }
    
	/**
	 * 평균값 구하기 
	 */
	function getCalcAvg(nCalcVal, nSize, nDigit){
		var nAvgVal = nCalcVal / nSize;
		nAvgVal = Math.floor(nAvgVal / Math.pow(10, nDigit)) * Math.pow(10, nDigit);		
		return DMTtrimCurrencyAmount(ComGetObjValue(document.form.inv_curr_cd),nAvgVal);
	}
	
	/*
	 * 조회결과로 화면 버튼컴포넌트의 상태를 제어합니다.
	 */
	function controlScreen() {
		var formObj = document.form;
		
		// 입력항목 제어
		controlInput();
		// 버튼 제어
		controlButton();		
	}
	
	/*
	 * 조회결과로 화면 입력컴포넌트의 상태를 제어합니다.
	 */	
	function controlInput() {
		var formObj = document.form;
		
		var invIssCd = ComGetObjValue(formObj.invoice_issue);
		var arIfCd   = ComGetObjValue(formObj.dmdt_ar_if_cd);
		var invStsCd = ComGetObjValue(formObj.dmdt_inv_sts_cd);
		
		//======================================================
		// Invoice 상태에 따른 항목 상태값 변경
		//======================================================
		var bEnable = true;
		// Invoice 발행 후 취소된 경우
		if (invStsCd == "X") { 
			bEnable = false;
		}
		// Invoice 발행 후 A/R I/F 처리된 경우
		else if (invIssCd == "2" && arIfCd == "Y") {
			bEnable = false;
		}
		//======================================================
		
		// Payer
		DmtComEnableObject(formObj.payer_cd,     bEnable);
		DmtComEnableObject(formObj.btn_payer_cd, bEnable);
		
		// Attention
		comboObjects[0].Enable = bEnable;
		
		// Trucker
		DmtComEnableObject(formObj.trucker_cd,     bEnable);
		DmtComEnableObject(formObj.btn_trucker_cd, bEnable);
		
		// Invoice Remark(s)
		DmtComEnableObject(formObj.inv_rmk1, bEnable);
		DmtComEnableObject(formObj.inv_rmk2, bEnable);
		
		// Notice
		DmtComEnableObject(formObj.ntc_knt_cd, bEnable);
		// Cust. Ref
		DmtComEnableObject(formObj.inv_ref_no, bEnable);
		
		// tax ( 인도 OFC 에서 발행한 Tax 는 DMT Common 모듈에서 자체적으로 관리합니다. )
		var usrCntCd = ComGetObjValue(formObj.invoice_issue) == "2" ? ComGetObjValue(formObj.cre_cnt_cd) : ComGetObjValue(formObj.usr_cnt_cd);		
		if (usrCntCd != "IN") DmtComEnableObject(formObj.chk_tax, bEnable); 
		
		// [ CSS 설정 ] input : 선택입력, input1 : 필수입력, input2 : 비활성화, noinput : 테두리없는 선택입력, noinput2 : 테두리없는 비활성화
		formObj.payer_cd.className 	 = bEnable ? "input1"  : "input2";
		formObj.trucker_cd.className = bEnable ? "input"   : "input2";
		formObj.inv_rmk1.className 	 = bEnable ? "noinput" : "noinput2";
		formObj.inv_rmk2.className	 = bEnable ? "noinput" : "noinput2";	
		formObj.ntc_knt_cd.className = bEnable ? "input"   : "input2";
		formObj.inv_ref_no.className = bEnable ? "input"   : "input2";
	}	
	
	/*
	 * 조회결과로 화면 버튼컴포넌트의 상태를 제어합니다.
	 */
	function controlButton() {
		var formObj = document.form;
		
		var dmdtInvStsCd = ComGetObjValue(formObj.dmdt_inv_sts_cd);
		var dmdtArIfCd   = ComGetObjValue(formObj.dmdt_ar_if_cd);
		
		// Sheet Set
		ComBtnEnable("btn_set");
		
		// Sheet Option
		ComBtnEnable("btn_option");
		
		// C.Remark(s)
		if (dmdtInvStsCd == "X"|| dmdtInvStsCd == "C") {
			ComBtnEnable("btn_cremark");
			document.getElementById("btn_cremark").style.color = "red";
		}
		else {
			ComBtnDisable("btn_cremark");
			document.getElementById("btn_cremark").style.color = "";
		}	
		
		// H.Remark(s)
		if (dmdtArIfCd == "H") {
			ComBtnEnable("btn_hremark");
			document.getElementById("btn_hremark").style.color = "red";
		}
		else {
			ComBtnDisable("btn_hremark");
			document.getElementById("btn_hremark").style.color = "";
		}
		
		// Save
		if (dmdtInvStsCd == "C" || dmdtInvStsCd == "X" || dmdtArIfCd == "Y") {
			ComBtnDisable("btn_save");
		}
		else {
			ComBtnEnable("btn_save");
		}
		
		// Cancel
		if (dmdtInvStsCd == "I") {
			ComBtnEnable("btn_cancel");
		}
		else {
			ComBtnDisable("btn_cancel");
		}

		// Invoice 발행 전 
		if (ComGetObjValue(formObj.invoice_issue) == "1") {
			// Sending History
			ComBtnDisable("btn_sendinghistory");
			// Preview
			ComBtnDisable("btn_preview");
			// INV Print
			ComBtnDisable("btn_print");
			// Fax Send
			ComBtnDisable("btn_fax");
			// Email Send
			ComBtnDisable("btn_email");			
		}
		// Invoice 발행 후
		else {
			// Sending History
			ComBtnEnable("btn_sendinghistory");
			// Preview
			ComBtnEnable("btn_preview");
			// INV Print
			ComBtnEnable("btn_print");
			// Fax Send
			ComBtnEnable("btn_fax");
			// Email Send
			ComBtnEnable("btn_email");
		}
		
		// A/R I/F
		if (dmdtInvStsCd == "I" && dmdtArIfCd == "N") {
			ComBtnEnable("btn_arif");
		}
		else {
			ComBtnDisable("btn_arif");
		}
	}