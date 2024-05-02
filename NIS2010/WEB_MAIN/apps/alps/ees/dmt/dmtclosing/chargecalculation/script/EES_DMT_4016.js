/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_4016.js
*@FileTitle : SZPSC DEM Calculation &amp; Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.10.13 황효근
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
     * @class EES_DMT_4016 : EES_DMT_4016 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_4016() {
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
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1; 
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var comboObjects = new Array();
	var comboCnt = 0;
	
	// RD
	var rdObjects = new Array();
	var rdCnt = 0;
	var queryStr = "";
	
	//Action 정의
	var IBSAVE_CORRRMK	= 89;
	var IBCHK_SHEETSET	= 90;
	var IBCHK_SHEETOPT	= 91;
	var IBFAXSEND		= 92;
	var IBEMAILSEND		= 93;
	var IBARIF			= 94;
	var IBCANCEL		= 95;
	var IBCALCULATE		= 96;
	var IBCONFIRM		= 97;
	var IBSEARCH_MBILL	= 98;
	var IBGETTOMVMT		= 99;
	
	//업무전역변수
	var ROWMARK 	= "|";
	var FIELDMARK 	= "=";
	
	var PAYER_CD = "act_payr_cust_cd";
	var PAYER_NM = "act_payr_cust_nm";
	var TRUCKER_CD = "vndr_seq";
	var TRUCKER_NM = "vndr_nm";
	
	// Tab2내  IBSeet Height 초기값
	var TAB2_SHEET_HEIGHT = 82;
	// ****************************************
	
	 

	 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	 document.onclick = processButtonClick;

	 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	 var sheetObj1 = sheetObjects[0];
    	 var sheetObj2 = sheetObjects[1];
    	 var sheetObj3 = sheetObjects[2];
    	 var sheetObj4 = sheetObjects[3];
    	 var sheetObj5 = sheetObjects[4];
    	 var sheetObj6 = sheetObjects[5];
    	 
         var formObj = document.form;
         var formObj2 = document.form2;

         try {
        	 var srcObj = window.event.srcElement;
        	 var srcName = srcObj.getAttribute("name");
        	 
        	 // 그리드 하단 버튼 클릭시  비활성화 상태이면 그냥 return
        	 if(!ComIsBtnEnable(srcName)) return;
                                           
        	 switch(srcName) {
        	 	case "btns_calendar": //달력 버튼
		      		if(srcObj.style.cursor == "hand") {
		      			var cal = new ComCalendarFromTo();
		                cal.select(formObj.fm_mvmt_dt1, formObj.to_mvmt_dt1, 'yyyy-MM-dd');
		      		}
					break;
					
        	 	case "btns_cust_cd":
 					doProcessPopup('cust_cd');
					break;
						
	            case "btns_svc_provdr":
	            	doProcessPopup('svc_provdr');
	            	break;

        	 	case "btn_Retrieve":
					doActionIBSheet(sheetObj1,formObj,IBSEARCH);
					break;

				case "btn_New":
					doInit();
					break;
					
				case "btn_Minimize":
					var schCondDiv = document.getElementById("sch_cond_div");
					if(schCondDiv.style.display == 'inline') {
						schCondDiv.style.display = 'none';
						sheetObj1.style.height = 330+145;
					} else {
						schCondDiv.style.display = 'inline';
						sheetObj1.style.height = 330;
					}
					break;
 					
 				case "btn_GetToMVMT":
 					doActionIBSheet(sheetObj1, formObj, IBGETTOMVMT);
                    break;

                case "btn_Calculate":
                	doActionIBSheet(sheetObj1, formObj, IBCALCULATE);
                    break;
                     
                case "btn_DownExcel":
  					sheetObj1.SpeedDown2Excel(-1, false, false, '', '', false, false, '', false, 'chk');
                    break; 
                      
                case "btn_Confirm":    
                	doActionIBSheet(sheetObj1, formObj, IBCONFIRM);
                	break;
                	
				case "btn_MBilling":
					doManualBilling();
					break;
					
				case "btn_ROInfo":
				case "btn_MVMTInq":
				case "btn_ExptInq":
				case "m_bkg_no":
 				case "m_bl_no":
 				case "m_cntr_no":
                	 doProcessPopup(srcName);
                     break;
                     
                // =================== Tab-2 ===================
 				case "btns_payer_cd":
 					doProcessPopup('payer_cd');
					break;
						
	            case "btns_trucker_cd":
	            	doProcessPopup('trucker_cd');
	            	break;
 				
 				case "btn_New2":
 					doInit2();
					break;
				
 				case "btn_Minimize2":
 					doActionMinimize();
					break;
					
 				case "btn_Save":
 					doActionIBSheet(sheetObj4, formObj2, IBSAVE);
					break;
					
 				case "btn_ARIF":
 					doActionText(sheetObj6, formObj2, formObj2.payer_cd, SEARCH20);
 					doActionIBSheet(sheetObj6, formObj2, IBARIF);
					break;	
					
 				case "btn_CRemark":
 					AlertCRemark();
					break;
					
 				case "btn_InvPrint":
 					if (ComGetObjValue(formObj2.has_sheetset) != "Y") {
						ComShowCodeMessage("DMT01096");
						return;
					}
 					
 					//Preview, Print 할때 PayerCode가 없으면 alert 메시지 처리
					if (ComGetObjValue(formObj2.payer_cd) == "") {
						ComShowCodeMessage("DMT02002");
						return;
					}

					initRdConfig(rdObjects[0]);
					rdOpen(rdObjects[0], formObj2, sheetObj6);
					break;
					
 				
 					
 				case "btn_EmailSend":
 					if (ComGetObjValue(formObj2.has_sheetset) != "Y") {
						ComShowCodeMessage("DMT01096");
						return;
					}
 					doActionIBSheet(sheetObj6, formObj2, IBEMAILSEND);
 					doProcessPopup(srcName);
 					break;
 					
 				case "btn_FaxSend":
 					if (ComGetObjValue(formObj2.has_sheetset) != "Y") {
						ComShowCodeMessage("DMT01096");
						return;
					}
 					doActionIBSheet(sheetObj6, formObj2, IBFAXSEND);
 					doProcessPopup(srcName);
 					break;
				
 				case "btn_Preview":
 					//Sheet Set 이 없으면 alert 메시지 처리
 					if (ComGetObjValue(formObj2.has_sheetset) != "Y") {
						ComShowCodeMessage("DMT01096");
						return;
					}
 					
					//Preview, Print 할때 PayerCode가 없으면 alert 메시지 처리
					if (ComGetObjValue(formObj2.payer_cd) == "") {
						ComShowCodeMessage("DMT02002");
						return;
					}
					
 				case "btn_SheetSet":
 				case "btn_SheetOpt":
 				case "btn_SendingHistory":
 				case "btn_Cancel":
 				case "btn_PayerInfo":
 					doProcessPopup(srcName);
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
      
    //페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
  	function setComboObject(combo_obj){
  		comboObjects[comboCnt++] = combo_obj;
  	} 

 	/**
      * IBTab Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setTabObject(tab_obj){
         tabObjects[tabCnt++] = tab_obj;
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
         
    	// IBMultiCombo초기화 
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}

    	for(k=0;k<tabObjects.length;k++){
             initTab(tabObjects[k],k+1);
        }
 		
 		//html컨트롤 이벤트초기화
		initControl();
	}
      
      
	// 페이지에 Object 태그를 사용하여 IBSheet의 인스턴스를 생성완료 하면 Event가 발생한다.
   	function t1sheet1_OnLoadFinish() {
  		var formObj = document.form2;
  		var sheetObj = sheetObjects[0];
  		//sheetObj.WaitImageVisible = false;
 		
 		doInit();
  	    //sheetObj.WaitImageVisible = true; 
   	}  
      
      
	// Tab-1 화면 초기화
  	function doInit() {
		var formObj = document.form;
		
		ComResetAll();
		sheetObjects[0].CheckAll("chk") = 0;
		
		//Period Date 초기화
//		var ofcCurrDate = DmtComOfficeCurrDate(sheetObj, formObj);
//		var fmMvmtDt = ComGetDateAdd(ofcCurrDate, "D", -15);
//		var toMvmtDt = ofcCurrDate;
//		ComSetObjValue(formObj.fm_mvmt_dt1, fmMvmtDt);
//		ComSetObjValue(formObj.to_mvmt_dt1, toMvmtDt);
		
		//조회조건 부분적으로 활성화/비활성화  처리
		doEnableCondObj("vvd_cd");
		initBtns();
		
		tabObjects[0].TabEnable(1) = false;
	}
	
	
	// Tab-2 화면 초기화
  	function doInit2() {
		var formObj = document.form2;
		doActionIBSheet(sheetObjects[3], formObj, IBSEARCH_MBILL);
  	}
	
	
  	/**
     * Minimize 버튼이 클릭되었을 경우 실행해야할 동작을 정의하는 함수
     */	    
	function doActionMinimize() {
     	var chgSheetObj = sheetObjects[3];
     	var rtSheetObj 	= sheetObjects[4];
     	var addHeight   = 129;
     	
 		if (conditionLayer.style.display == 'inline') {
 			conditionLayer.style.display = 'none';
 		}
 		else {
 			conditionLayer.style.display = 'inline';
 			addHeight = 0;
 		}
 		
 		chgSheetObj.style.height = TAB2_SHEET_HEIGHT + addHeight;
 		rtSheetObj.style.height  = TAB2_SHEET_HEIGHT + addHeight;
	}
	
	
	// Tab-1 버튼 상태 초기화
 	function initBtns() {
 		DmtComEnableManyBtns(false,	"btn_GetToMVMT", "btn_Calculate", "btn_Confirm", "btn_ROInfo", "btn_MVMTInq",
 									"btn_MBilling", "btn_ExptInq", "btn_DownExcel");
 		
	  	document.getElementById("btn_ROInfo").style.color = '';
 	}
 	
	// Tab-2 버튼 초기화
  	function initBtns2() {
		/*
  		DmtComEnableManyBtns(true, "btn_SheetSet", "btn_SheetOpt", "btn_Save");
		DmtComEnableManyBtns(false, "btn_SendingHistory", "btn_CRemark", "btn_Cancel", "btn_Preview", "btn_InvPrint"
									, "btn_FaxSend", "btn_EmailSend", "btn_PayerInfo", "btn_ARIF");
		*/
		var formObj = document.form2;
		var invStsCd = ComGetObjValue(formObj.dmdt_inv_sts_cd);
  		
		//C. REMARK
		if(invStsCd == "X") {
			ComBtnEnable("btn_CRemark");
			document.getElementById("btn_CRemark").style.color = "red";
		} else {
			ComBtnDisable("btn_CRemark");
			document.getElementById("btn_CRemark").style.color = "";
		}
		
		//ARIF button Enable
		var arIfCd = ComGetObjValue(formObj.dmdt_ar_if_cd);
		
		if(invStsCd == "I" || invStsCd == "C") {
			if(arIfCd == "N" || arIfCd == "H")
				ComBtnEnable("btn_ARIF");
			else
				ComBtnDisable("btn_ARIF");
		} else {
			ComBtnDisable("btn_ARIF");
		}
		
		//SAVE button Enable
		if(invStsCd == "C" || invStsCd == "X") {
			ComBtnDisable("btn_Save");
		}else{
			ComBtnEnable("btn_Save");
		}
		
		//CANCEL 
		if(invStsCd == "I") {
			ComBtnEnable("btn_Cancel");
		}else{
			ComBtnDisable("btn_Cancel");
		}
		
		//공통 버튼
		DmtComEnableManyBtns(true, "btn_SheetSet", "btn_SheetOpt", "btn_PayerInfo");
		
		if(ComGetObjValue(formObj.invoice_issue) == "1") {
			DmtComEnableManyBtns(false, "btn_SendingHistory", "btn_Preview", "btn_InvPrint", "btn_FaxSend"
										, "btn_EmailSend");
			
		} else { //if(ComGetObjValue(formObj.invoice_issue) == "2") {
			DmtComEnableManyBtns(true, "btn_SendingHistory", "btn_Preview", "btn_InvPrint", "btn_FaxSend"
										, "btn_EmailSend");
		}
  	}
	
	
  	/**
     * Attention Combo를 조회하기 위한 Payer Code 정보 설정
     */
    function setPayerCd() {
    	var formObj = document.form2;
    	var payer_cd	= ComGetObjValue(formObj.payer_cd);
    	var cust_cnt_cd	= "";
    	var cust_seq 	= "";
    	
    	//Service Provider
    	if(payer_cd.length == 6) {
    		cust_cnt_cd = "00";
    		cust_seq	= payer_cd;
    	}else if(payer_cd.length == 8){
    		cust_cnt_cd = payer_cd.substring(0,2);
    		cust_seq	= payer_cd.substring(2);
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
     * Attention 데이터 조회
     */	
	function searchAttentionList() {
 		
    	setPayerCd();
 		
    	var comboObj = comboObjects[2]; // Attention IB콤보
    	var formObj = document.form2;
 		
 		if(ComGetObjValue(formObj.invoice_issue) == "1") {
 			//Invoice Issue 전
 			ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.session_ofc_cd));
 		} else {
 			//Invoice Issue 후
 			ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.cre_ofc_cd));
 		}
 		
 		// 데이터 요청해서 받아옴
 		doActionIBCombo(sheetObjects[3], formObj, comboObj, SEARCHLIST03);
 		
 		
 		var comboObj = comboObjects[2];
 		var comboObjCd = ComGetObjValue(formObj.cust_cnt_cd)+"^"+ComGetObjValue(formObj.cust_cntc_pnt_seq)+"^"+ComParseInt(ComGetObjValue(formObj.cust_seq));
		
		if(ComGetObjValue(formObj.payer_cd) == "") {
			comboObj.Code = "";
//			comboObj.Index = -1;
		} else {
			//Attention Setting
			comboObj.Code = comboObjCd;
			if(comboObj.Code == ""){
				comboObj.Index = 0;
			}
		}
 	}
	
	
  	function doManualBilling() {
  		var formObj = document.form2;
  		var sheetObj = sheetObjects[0];
  		
  		var bkgNo;
  		var trfCd;
  		var chgStsCd;
  		var invIssue;
  		
  		with(sheetObj) {
	  		var chkRow = SelectRow;
			/*if(CheckedRows("chk") > 0) {
				var chkRows = FindCheckedRow("chk").split("|");
				chkRow = chkRows[0];
			} else if(SelectRow > 0) {
				chkRow = SelectRow;
			}*/
			
			if(CellValue(chkRow , "cal_flg") == '') {
				ComShowCodeMessage('DMT03054');
				SelectRow = chkRow;
				return;
			}
			
			var chgStsCd = CellValue(chkRow , "dmdt_chg_sts_cd");
			if(chgStsCd == 'U' || chgStsCd == 'L' || chgStsCd == 'N' || chgStsCd == 'E' || chgStsCd == 'F') {
				ComShowCodeMessage('DMT01076', 'billing');
				SelectRow = chkRow;
				return;
			}
			
			if(chgStsCd == 'C') {
				bkgNo		= CellValue(chkRow , "bkg_no");
				trfCd 		= CellValue(chkRow , "dmdt_trf_cd");
				chgStsCd	= CellValue(chkRow , "dmdt_chg_sts_cd");
				invIssue	= "1";
				
		  		ComSetObjValue(formObj.dmdt_chg_sts_cds, chgStsCd);
				
			} else if(chgStsCd == 'I') {
				bkgNo		= CellValue(chkRow , "bkg_no");
				trfCd 		= CellValue(chkRow , "dmdt_trf_cd");
				invIssue	= "2";
				var invNo	= CellValue(chkRow , "dmdt_inv_no");
				
		  		ComSetObjValue(formObj.s_invoice_no,	invNo);
		  		ComSetObjValue(formObj.cre_ofc_cd,		"SZPSC");
			}
			
			with(formObj) {
	  			ComSetObjValue(s_bkg_no, 		bkgNo);
	  			ComSetObjValue(s_dmdt_trf_cd,	trfCd);
	  			ComSetObjValue(invoice_issue,	invIssue);
	  			ComSetObjValue(dmdt_chg_sts_cds,chgStsCd);
	  		}
  		}
  		 
  		tabObjects[0].TabEnable(1) = true;
  		tabObjects[0].selectedIndex = 1;
  		
  		// Retrieve
  		doActionIBSheet(sheetObjects[3], formObj, IBSEARCH_MBILL);
  		
  		//오피스별 현재일자를 조회한다.
		ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.session_ofc_cd));
		doActionIBCombo(sheetObjects[3], formObj, comboObjects[2], SEARCHLIST06);
  	}
      
    
	function initControl() {
  		axon_event.addListenerForm  ('blur',	'obj_blur',		document.form, 'cond_type'); //- 포커스 나갈때
  		axon_event.addListenerForm  ('blur',	'obj_blur',		document.form2);
  		axon_event.addListenerFormat('focus',	'obj_focus',	document.form); //- 포커스 들어갈때
  		axon_event.addListenerFormat('focus',	'obj_focus',	document.form2); //- 포커스 들어갈때
  		axon_event.addListenerFormat('keypress','obj_keypress', document.form); //- 키보드 입력할때
  		axon_event.addListenerFormat('keypress','obj_keypress', document.form2); //- 키보드 입력할때
  		axon_event.addListener('click', 'condType_click', 'cond_type');
  		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
  		axon_event.addListener('mouseover', 'obj_mouseover', 'txt_remark','btn_CRemark');	// onMouseover 이벤트
		axon_event.addListener('mouseout', 'obj_mouseout',	 'txt_remark','btn_CRemark');	// onMouseout 이벤트
		//axon_event.addListener('blur', 'sheetobj_blur', 't1sheet1');
  	}
	
    
	// 조회조건(Date/VVD CD/CNTGR) 라디오버튼 클릭 이벤트 전달 함수
	function condType_click() {
		doEnableCondObj(event.srcElement.value);
	}
     
	// 조회조건(Date/VVD CD/CNTGR) 라디오버튼 클릭 이벤트 처리 함수
	function doEnableCondObj(condType) {
    	 var formObj = document.form;
    	 
    	 with (formObj) {
	    	 switch(condType){
	    	 	case "date":
	    	 		ComEnableManyObjects(true, yard_fmto[0], yard_fmto[1], yd_cd);
	    	 		ComEnableManyObjects(false, vvd_cd, tmnl_cd);			//VVD CD: Disable
	    	 		ComEnableManyObjects(false, bkg_no, bl_no, cntr_no);	//CNTR: Disable
	    	 		DmtComSetClassManyObjects('input2', vvd_cd, tmnl_cd, bkg_no, bl_no, cntr_no); //비활성화 class (input2)
	    	 		comboObjects[1].Enable = true;		//Date YD
	    	 		//===> 검색조건 항목(VVD CD, CNTR) Clear
	    	 		ComSetObjValue(yard_fmto, "yard_fm");
	    	 		ComClearManyObjects(vvd_cd, tmnl_cd);			//VVD CD
	    	 		ComClearManyObjects(bkg_no, bl_no, cntr_no);	//CNTR
	    	 		ComEnableManyObjects(true, cust_type, cust_cd, svc_provdr, sc_no, rfa_no);
	    	 		break;
	    	 		
	    	 	case "vvd_cd":
	    	 		ComEnableManyObjects(false, yard_fmto[0], yard_fmto[1], yd_cd);
	    	 		ComEnableManyObjects(true, vvd_cd, tmnl_cd);
	    	 		ComEnableManyObjects(false, bkg_no, bl_no, cntr_no);
	    	 		DmtComSetClassManyObjects('input1', vvd_cd); 			//필수항목 표시
	    	 		DmtComSetClassManyObjects('input2', yd_cd, bkg_no, bl_no, cntr_no);
	    	 		comboObjects[1].Enable = false;		//Date YD
	    	 		// 검색조건 항목(Date, CNTR) Clear
	    	 		comboObjects[1].RemoveAll();		//Date
	    	 		ComClearManyObjects(yd_cd, bkg_no, bl_no, cntr_no);	//CNTR
	    	 		break;
	    	 		
	    	 	case "cntr":
	    	 		ComEnableManyObjects(false, yard_fmto[0], yard_fmto[1], yd_cd);
	    	 		ComEnableManyObjects(false, vvd_cd, tmnl_cd);
	    	 		ComEnableManyObjects(true, bkg_no, bl_no, cntr_no);
	    	 		DmtComSetClassManyObjects('input1', bkg_no, bl_no, cntr_no); //필수항목 표시
	    	 		DmtComSetClassManyObjects('input2', yd_cd, vvd_cd, tmnl_cd);
	    	 		comboObjects[1].Enable = false;		//Date YD
	    	 		//===> 검색조건 항목(Date, VVD CD) Clear
	    	 		comboObjects[1].RemoveAll();		//Date
	    	 		ComClearManyObjects(yd_cd, vvd_cd, tmnl_cd);	//VVD CD
	    	 		break;
	    	 }
	    	 
	    	 // Period 활성화 처리
	    	 if(condType == 'date') {
	    		ComEnableManyObjects(true, fm_mvmt_dt1, to_mvmt_dt1, btns_calendar);
	    		DmtComSetClassManyObjects('input1', fm_mvmt_dt1, to_mvmt_dt1);
	    		
	    		//Period Date 초기화
	    		var ofcCurrDate = DmtComOfficeCurrDate(sheetObjects[0], formObj);
				var fmMvmtDt = ComGetDateAdd(ofcCurrDate, "D", -15);
				var toMvmtDt = ofcCurrDate;
				ComSetObjValue(fm_mvmt_dt1, fmMvmtDt);
				ComSetObjValue(to_mvmt_dt1, toMvmtDt);
				
	    	 } else {
	    		 ComEnableManyObjects(false, fm_mvmt_dt1, to_mvmt_dt1, btns_calendar);
	    		 DmtComSetClassManyObjects('input2', fm_mvmt_dt1, to_mvmt_dt1);
	    		 ComClearManyObjects(fm_mvmt_dt1, to_mvmt_dt1);
	    	 }
	    	 
	    	 // 멀티입력 팝업창 오픈 아이콘 활성화/비활성화 처리
	    	 if(condType == 'cntr') {
	    		 ComEnableManyObjects(true, btns_multisearch1, btns_multisearch2, btns_multisearch3);
	    	 } else {
	    		 ComEnableManyObjects(false, btns_multisearch1, btns_multisearch2, btns_multisearch3);
	    	 }
    	 }
     }
    
      
	//포커스가 나갈 때
    function obj_blur(){
        //입력Validation 확인하기 + 마스크구분자 넣기
        var obj = event.srcElement;
        
        if(obj.name == 'svc_provdr' || obj.name == 'bkg_no' || obj.name == 'bl_no' || obj.name == 'cntr_no') {
			 
        } else if(obj.name == 'yd_cd' || obj.name == 'tmnl_cd') {
			 if(obj.value.length > 0 && obj.value.length < 5) {
				var cdDiv = (obj.name == 'yd_cd') ? 'Yard' : 'Location';
				ComShowCodeMessage('DMT00110', cdDiv);
				ComClearObject(obj);
			 }
        } else if(obj.name == 'payer_cd') {
			doActionText(sheetObjects[3], document.form2, obj, SEARCH20);
		
        } else if(obj.name == 'trucker_cd') {
			doActionText(sheetObjects[3], document.form2, obj, SEARCHLIST04);	 
		 
        } else {
        	ComChkObjValid(obj);
        }
    }
	
	
	// Payer, Trucker
	function doActionText(sheetObj, formObj, object, formCmd) {
		//sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;
		
		//Payer 체크
		if(object.name == "payer_cd"){
			//cust_cd
			ComSetObjValue(formObj.s_cust_cd, ComGetObjValue(formObj.payer_cd));
			var cust_len = parseInt(ComGetLenByByte(ComGetObjValue(formObj.s_cust_cd)));
			
			if(cust_len == 0){
				clearPayerAttention();
				return;
			}
			
			var cre_cnt_cd = "";
			//Invoice 생성전
			if(ComGetObjValue(formObj.invoice_issue) == "1" ) {
				cre_cnt_cd = ComGetObjValue(formObj.session_cnt_cd);
			//Invoice 생성후
			}else if(ComGetObjValue(formObj.invoice_issue) == "2" ) {
				cre_cnt_cd = ComGetObjValue(formObj.cre_cnt_cd);
			}
			
			//미주 : customer + vendor 
			if(cre_cnt_cd == "US"){
				if(cust_len > 2) {
					var char_chk = ComGetObjValue(formObj.s_cust_cd).substring(0,2);
					//2자리가 영문자이면 CUSTOMER 조회
					if(ComIsAlphabet(char_chk)) {
						ComSetObjValue(formObj.s_cust_gubun, "2");
					//아니면 VENDOR 조회
					}else{
						ComSetObjValue(formObj.s_cust_gubun, "1");
					}
				} else {
					ComSetObjValue(formObj.s_cust_gubun, "1");
				}
			} else {
				//미주 외 : customer만 적용 ( vendor 는 제외 에러 처리) 
				if(cust_len > 2) {
					var char_chk = ComGetObjValue(formObj.s_cust_cd).substring(0,2);
					//2자리가 영문자이면 CUSTOMER 조회
					if(ComIsAlphabet(char_chk)) {
						ComSetObjValue(formObj.s_cust_gubun, "2");
					//아니면 VENDOR 조회
					}else{
						ComShowCodeMessage("DMT00165", "Payer");
						clearPayerAttention();
						ComSetFocus(formObj.payer_cd);
						return;
					}
				} else {
					ComShowCodeMessage("DMT00165", "Payer");
					clearPayerAttention();
					ComSetFocus(formObj.payer_cd);
					return;
				}
			}
			
			ComSetObjValue(formObj.f_cmd, formCmd);
			
			var sXml 	= sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
			var cust_cd = ComGetEtcData(sXml, "PAYER_CODE");
			var cust_nm = ComGetEtcData(sXml, "PAYER_NM");
			var delt_flg = ComGetEtcData(sXml, "DELT_FLG");
			var nmd_cust_flg = ComGetEtcData(sXml, "NMD_CUST_FLG");
			
			if(cust_nm == null || cust_nm == "") {
				ComShowCodeMessage("DMT00165", "Payer");
				clearPayerAttention();
				ComSetFocus(formObj.payer_cd);
			}else if ( nmd_cust_flg == "Y" ){
				ComShowCodeMessage("DMT02002", "Payer Code - Named Customer");
				clearPayerAttention();
				ComSetFocus(formObj.payer_cd);
			}
			else{
				ComSetObjValue(formObj.payer_cd, cust_cd);
				ComSetObjValue(formObj.payer_nm, cust_nm);
				
				searchAttentionList();
			}
		} else if(object.name == "trucker_cd") {
			// Trucker Code, Name(vndr_seq) 조회용 
			ComSetObjValue(formObj.vndr_cd, ComGetObjValue(formObj.trucker_cd));
	
			var vndr_len = parseInt(ComGetLenByByte(ComGetObjValue(formObj.vndr_cd)));
			
			//변경
			if(vndr_len == 0) {
				ComSetObjValue(formObj.vndr_cd, "");
				ComSetObjValue(formObj.trucker_cd, "");
				ComSetObjValue(formObj.trucker_nm, "");
				ComSetObjValue(formObj.vndr_seq, "");
				return;
			}

			ComSetObjValue(formObj.f_cmd, formCmd);
			
			var sXml 	= sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
			var vndr_cd = ComGetEtcData(sXml, "VNDR_CD");	//추가
			var vndr_nm = ComGetEtcData(sXml, "VNDR_NM");
			var lgs_flg = ComGetEtcData(sXml, "LGS_FLG");
			
			if(vndr_nm == null || vndr_nm == "") {
				ComSetObjValue(formObj.vndr_cd, "");
				ComSetObjValue(formObj.trucker_cd, "");
				ComSetObjValue(formObj.trucker_nm, "");
				ComSetObjValue(formObj.vndr_seq, "");
				ComShowCodeMessage("DMT00165", "Trucker");
				ComSetFocus(formObj.trucker_cd);
			}else{
				ComSetObjValue(formObj.trucker_cd, vndr_cd);	//변경
				ComSetObjValue(formObj.trucker_nm, vndr_nm);
				ComSetObjValue(formObj.vndr_seq, vndr_cd);
			}
			
			if ( lgs_flg == "N" ){
				ComSetObjValue(formObj.vndr_cd, "");
				ComSetObjValue(formObj.trucker_cd, "");
				ComSetObjValue(formObj.trucker_nm, "");
				ComSetObjValue(formObj.vndr_seq, "");
				ComShowCodeMessage("DMT01183");
				ComSetFocus(formObj.trucker_cd);		
				return false;
			}
		}
		
        sheetObj.WaitImageVisible = true;
    }
	
	
	function clearPayerAttention() {
		var formObj = document.form2;
		with(formObj) {
			ComSetObjValue(s_cust_gubun, "");
			ComSetObjValue(s_cust_cd, "");
			
			ComClearManyObjects(payer_cd, payer_nm, payr_cntc_pnt_phn_no, payr_cntc_pnt_fax_no, payr_cntc_pnt_eml);
		}
		
		// Attention IBCombo
		comboObjects[2].RemoveAll();
	}
	
	
	// Attention 정보  Clear
    function clearAttention() {
    	var formObj = document.form2;
    	comboObjects[2].RemoveAll();
    	ComClearManyObjects(formObj.payr_cntc_pnt_phn_no, formObj.payr_cntc_pnt_fax_no, formObj.payr_cntc_pnt_eml);
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
    
	//업무 자바스크립트 OnKeyPress 이벤트 처리
	function obj_keypress() {
   	 switch(event.srcElement.dataformat){
        	case "engup":
		    	// 영문대+숫자 
        		ComKeyOnlyAlphabet('uppernum');
		        break;
        	case "engup2":
		    	// 영문대+숫자+예외문자
        		DmtComKeyOnlyAlphabet('uppernum', ',');
		        break;
        	case "int":
	   	        //숫자 만입력하기
	   	        ComKeyOnlyNumber(event.srcElement);
	   	        break;
        	default:
	         	// 숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber(event.srcElement);
   	 }
    }
    
	
	/*
	 * Yard, Port(Location) 필드에   입력한 코드값의  Validation을 위한 KeyUp 이벤트 처리 함수
	 */
	function obj_keyup() {
		var srcObj = event.srcElement;
		checkLocYdCd(srcObj);
	}
	
	/*
	 * Yard, Port(Location) 필드에   입력한 코드값의  Validation 처리 함수
	 */
	function checkLocYdCd(srcObj) {
		var formObj = document.form;
		var cd = ComTrim(ComGetObjValue(srcObj));
		
		if (cd.length == 5) {
			//var comboObj = (srcObj.name == 'yd_cd') ? comboObjects[1]:comboObjects[4];
			var comboObj = comboObjects[1];
			
			if(srcObj.name == 'yd_cd') {
				formObj.yd_cd1.value = cd;
				doActionIBCombo(sheetObjects[0], formObj, comboObj, SEARCH14, srcObj);
				
				if(comboObj.GetCount() == 0) {
					formObj.loc_cd.value = cd;
					doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND07, formObj.tmnl_cd);
				}
			} else {
				formObj.loc_cd.value = cd;
				doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND07, srcObj);
			}
		}
	}
	 
  	 
	// (버튼 말풍선  보여줌)
 	function obj_mouseover() {
  		var msg = '';
 		var x = event.x+document.body.scrollLeft;
 		var y = event.y+document.body.scrollTop;

      	switch(event.srcElement.id){
 	  		case 'txt_remark':
 	  			msg = 'Invoice Remark will be included in the Invoice Sheet';
 	  			x = x;
 	  			y = y-10;
 	  			break;
 	  		
 	  		case 'btn_CRemark':
 	  			msg = 'Invoice Cancel Remark';
 	  			x = x-120;
 	  			y = y+20;
 	  			break;
 	  			
 	  		case 'btn_HRemark':
 	  			msg = 'Invoice Hold Remark';
 	  			x = x-120;
 	  			y = y;
 	  			break;
      	}
 		
      	var bak = 'lightyellow';
  		var content =	"<TABLE BORDER=0 CELLPADDING=1 CELLSPACING=0 BGCOLOR=#000000><TR><TD><TABLE WIDTH=100% BORDER=0 CELLPADDING=2 CELLSPACING=0 BGCOLOR="+bak
  						+"><TR><TD style=font-family:tahoma;font-size:9pt;>"+msg+"</TD></TR></TABLE></TD></TR></TABLE>"; 
  		
  		document.all("topdeck").innerHTML = content;
  		
  		var skn = document.all("topdeck").style;
  		skn.left = x;
  		skn.top  = y;
  		skn.visibility = 'visible';
     }
     
     // (버튼 말풍선 숨김)
 	function obj_mouseout() {
 		var skn = document.all("topdeck").style;
 		skn.visibility = 'hidden';
 	}


   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;

         switch(sheetObj.id) {
              case "t1sheet1":      //sheet1 init
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 330;
                     
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(1, 1, 15, 100);
                     
                     // Ctrl키를 눌러 다중행 선택가능
                     MultiSelection = true;
                     SelectionMode = smSelectionList;

                     var HeadTitle = "||Seq.|Get|Cal.|STS|CNTR No.|T/S|From YD|To YD|Fm|To|Tariff|F/T|Over|From DT|To DT|F/T CMNC|F/T End|Cur.|Billable AMT|BKG No|B/L No"
                     	 			+"|VVD CD|Lane|POR|POL|POD|DEL|R|D|S/C No.|RFA No.|A/Cust|SOC|D/O|R/OFC|R/O|Invoice No.|ISS DT|INV Cur.|Billing AMT"
                     	 			+"|Payer|Payer|Shipper|Shipper|Cnsignee|Cnsignee|Notify|Notify|A/R Actual Payer|A/R Actual Payer"
                     	 			+"|Service Provider|Service Provider|Commodity|Commodity|Remark(s)";
                     //var headCount = ComCountHeadTitle(HeadTitle);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(65, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false, false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);
                     

                     //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,		DATAALIGN,		COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,daCenter,	true,	"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,	30,	daCenter,	true,	"chk");
 					InitDataProperty(0, cnt++ , dtSeq,		40,	daCenter,	true,	"seq");
 					InitDataProperty(0, cnt++ , dtData,   	40,	daCenter,	true,	"get_flg",			false,	"",		dfNone,			0,	false,	true, -1, false, true, "Get To MVMT Processed");
 					InitDataProperty(0, cnt++ , dtData,   	40,	daCenter,	true,	"cal_flg",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	30,	daCenter,	true,	"dmdt_chg_sts_cd",	false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	90,	daCenter,	true,	"cntr_no",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	40,	daCenter,	true,	"cntr_tpsz_cd",		false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	80,	daCenter,	true,	"fm_mvmt_yd_cd",	false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	70,	daCenter,	true,	"to_mvmt_yd_cd",	false,	"",		dfNone,			0,	false,	true);
					
					InitDataProperty(0, cnt++ , dtData,   	40,	daCenter,	true,	"fm_mvmt_sts_cd",	false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	40,	daCenter,	true,	"to_mvmt_sts_cd",	false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	50,	daCenter,	true,	"dmdt_trf_cd",		false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	40,	daCenter,	true,	"ft_dys",			false,	"",		dfInteger,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	50,	daCenter,	true,	"fx_ft_ovr_dys",	false,	"",		dfInteger,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	80,	daCenter,	true,	"fm_mvmt_dt",		false,	"",		dfDateYmd,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	80,	daCenter,	true,	"to_mvmt_dt",		false,	"",		dfDateYmd,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	80,	daCenter,	true,	"ft_cmnc_dt",		false,	"",		dfDateYmd,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	80,	daCenter,	true,	"ft_end_dt",		false,	"",		dfDateYmd,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	40,	daCenter,	true,	"bzc_trf_curr_cd",	false,	"",		dfNone,			0,	false,	true);
					
					InitDataProperty(0, cnt++ , dtData,   	80,	daRight,	true,	"bil_amt",			false,	"",		dfNullFloat,	2,	false,	true);
					InitDataProperty(0, cnt++ , dtData,		100,daCenter,	true,	"bkg_no",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	90,	daCenter,	true,	"bl_no",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	80,	daCenter,	true,	"vvd_cd",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	60,	daCenter,	true,	"lane",				false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	70,	daCenter,	true,	"por_cd",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	70,	daCenter,	true,	"pol_cd",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	70,	daCenter,	true,	"pod_cd",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	70,	daCenter,	true,	"del_cd",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	50,	daCenter,	true,	"bkg_rcv_term_cd",	false,	"",		dfNone,			0,	false,	true);
					
					InitDataProperty(0, cnt++ , dtData,   	50,	daCenter,	true,	"bkg_de_term_cd",	false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	60,	daCenter,	true,	"sc_no",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	90,	daCenter,	true,	"rfa_no",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	70,	daCenter,	true,	"acust",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	40,	daCenter,	true,	"soc_flg",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	40,	daCenter,	true,	"d_o",				false,	"",		dfNone,			0,	false,	true, -1, false, true, "Cargo Release");
					InitDataProperty(0, cnt++ , dtData,   	70,	daCenter,	true,	"rlse_ofc",			false,	"",		dfNone,			0,	false,	true, -1, false, true, "Cargo Release Office");
					InitDataProperty(0, cnt++ , dtData,   	40,	daCenter,	true,	"roll_ovr",			false,	"",		dfNone,			0,	false,	true, -1, false, true, "Roll Over due to Customs or Customer Request"); 
					InitDataProperty(0, cnt++ , dtData,   	80,	daCenter,	true,	"dmdt_inv_no",		false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	80,	daCenter,	true,	"iss_dt",			false,	"",		dfDateYmd,		0,	false,	false);
					
					InitDataProperty(0, cnt++ , dtData,   	80,	daCenter,	true,	"inv_curr_cd",		false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,   	80,	daRight,	true,	"inv_chg_amt",		false,	"",		dfNullFloat,	2,	false,	false);
					InitDataProperty(0, cnt++ , dtData,   	70,	daCenter,	true,	"payer_cd",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	150,daLeft,		true,	"payer_nm",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	70,	daCenter,	true,	"shipper_cd",		false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	150,daLeft,		true,	"shipper_nm",		false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	70,	daCenter,	true,	"cnee_cd",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	150,daLeft,		true,	"cnee_nm",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	70,	daCenter,	true,	"ntfy_cd",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	150,daLeft,		true,	"ntfy_nm",			false,	"",		dfNone,			0,	false,	true);
					
					InitDataProperty(0, cnt++ , dtData,   	70,	daCenter,	true,	"ar_act_cd",		false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	150,daLeft,		true,	"ar_act_nm",		false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	70,	daCenter,	true,	"svc_provdr_cd",	false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	150,daLeft,		true,	"svc_provdr_nm",	false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	70,	daCenter,	true,	"cmdt_cd",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	150,daLeft,		true,	"cmdt_nm",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtPopup,	150,daLeft,		true,	"corr_rmk",			false,	"",		dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtHidden,    0, daCenter,	true,	"svr_id",			false,  "",		dfNone,			0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    0, daCenter,	true,	"cntr_cyc_no",		false,  "",		dfNone,			0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    0, daCenter,	true,	"chg_seq",			false,  "",		dfNone,			0,	false,  false);
					
					InitDataProperty(0, cnt++ , dtHidden,    0, daCenter,	true,	"ofc_cd",			false,	"",		dfNone,			0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    0, daCenter,	true,	"to_mvmt_yr",		false,	"",		dfNone,			0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    0, daCenter,	true,	"to_mvmt_seq",		false,	"",		dfNone,			0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    0, daCenter,	true,	"to_mvmt_split_no",	false,	"",		dfNone,			0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    50, daCenter,	true,	"dmdt_chg_loc_div_cd",false,"",		dfNone,			0,	false,  false);
					
					// 좌측 틀고정 컬럼 설정
					FrozenCols		= SaveNameCol("cntr_tpsz_cd");
					ToolTipOption	= "balloon:true;width:50;";
					Ellipsis = true;
					
					PopupImage		= "img/btns_note.gif";
 					ShowButtonImage = 2;
 				}
                 break;
	         	 
              case "t1sheet2":	// 데이터 통신용 Hidden sheet init (Get To MVMT)
	         	 with (sheetObj) {
	                  // 높이 설정
	                  style.height = GetSheetHeight(5);
	                  // 전체 너비 설정
	                  SheetWidth = mainTable.clientWidth;
	
	                  //Host정보 설정[필수][HostIp, Port, PagePath]
	                  if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                  //전체Merge 종류 [선택, Default msNone]
	                  MergeSheet = msNone;
	
	                 //전체Edit 허용 여부 [선택, Default false]
	                  Editable = true;
	
	                  //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                  InitRowInfo( 1, 1, 2, 100);
	
	                  //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                  InitColumnInfo(9, 0, 0, true);
	
	                  // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                  InitHeadMode(true, true, true, true, false,false);
	
	                  var HeadTitle  = "|Seq.|CNTR No.|BKG No.|To YD|To DT|To YR|To Seq|To SpNo";
	
	                  //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                  InitHeadRow(0, HeadTitle, true);
	
	                  //데이터속성    [ROW, COL,  	DATATYPE,		WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,   true,	"ibflag");
						InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	false,	"seq");
						InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,	"cntr_no",			false,	"",	dfNone,		0,	false,	true);
						InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,	"bkg_no",			false,	"",	dfNone,		0,	false,	true);
						InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,	"to_mvmt_yd_cd",	false,	"",	dfNone,		0,	false,	true);
						InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,	"to_mvmt_dt",		false,	"",	dfDateYmd,	0,	false,	true);
						InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	"to_mvmt_yr",		false,	"",	dfNone,		0,	false,	true);
						InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	"to_mvmt_seq",		false,	"",	dfNone,		0,	false,	true);
						InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	false,	"to_mvmt_split_no",	false,	"",	dfNone,		0,	false,	true);
	         	 } // with - end
	         	 break;
	         	 
              case "t1sheet3":	// 데이터 통신용 Hidden sheet init (Calculate)
            	with (sheetObj) {
	                  // 높이 설정
	                  style.height = GetSheetHeight(5);
	                  // 전체 너비 설정
	                  SheetWidth = mainTable.clientWidth;
	
	                  //Host정보 설정[필수][HostIp, Port, PagePath]
	                  if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                  //전체Merge 종류 [선택, Default msNone]
	                  MergeSheet = msNone;
	
	                 //전체Edit 허용 여부 [선택, Default false]
	                  Editable = true;
	
	                  //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                  InitRowInfo( 1, 1, 2, 100);
	
	                  //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                  InitColumnInfo(25, 0, 0, true);
	
	                  // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                  InitHeadMode(true, true, true, true, false, false);
	
	                  var HeadTitle  = "|Seq.|svr_id|cntr_no|cntr_cyc|trf_cd|loc_div|chg_seq|cntr_tpsz|bkg_no|vvd_cd|To DT|To|To YD|To YR|To Seq|To SpNo|F/T|Over|F/T CMNC|F/T End|Cur.|Billable AMT|STS|From DT";
	
	                  //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                  InitHeadRow(0, HeadTitle, true);
	
	                  //데이터속성    [ROW, COL,  	DATATYPE,		WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                  InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,   true,	"ibflag");
	                  InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	false,	"seq");
	                  InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	"svr_id",			false,	"",	dfNone,		0,	false,	false);
	                  InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,	"cntr_no",			false,	"",	dfNone,		0,	false,	false);
	                  InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	"cntr_cyc_no",		false,	"",	dfNone,		0,	false,	false);
	                  InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	"dmdt_trf_cd",		false,	"",	dfNone,		0,	false,	false);
	                  InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,	"dmdt_chg_loc_div_cd",	false,	"",	dfNone,	0,	false,	false);
	                  InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	"chg_seq",			false,	"",	dfNone,		0,	false,	false);
	                  InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	"cntr_tpsz_cd",		false,	"",	dfNone,		0,	false,	false);
	                  InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,	"bkg_no",			false,	"",	dfNone,		0,	false,	false);
					
	                  InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,	"vvd_cd",			false,	"",	dfNone,		0,	false,	false);
	                  InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,	"to_mvmt_dt",		false,	"",	dfDateYmd,	0,	false,	false);
	                  InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	false,	"to_mvmt_sts_cd",	false,	"",	dfNone,		0,	false,	false);
	                  InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	"to_mvmt_yd_cd",	false,	"",	dfNone,		0,	false,	false);
	                  InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	"to_mvmt_yr",		false,	"",	dfNone,		0,	false,	false);
	                  InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	"to_mvmt_seq",		false,	"",	dfNone,		0,	false,	false);
	                  InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	false,	"to_mvmt_split_no",	false,	"",	dfNone,		0,	false,	false);
	                  InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	false,	"ft_dys",			false,	"",	dfNone,		0,	false,	false);
	                  InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	false,	"fx_ft_ovr_dys",	false,	"",	dfNone,		0,	false,	false);
	                  InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,	"ft_cmnc_dt",		false,	"",	dfDateYmd,	0,	false,	false);
	                  
	                  InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,	"ft_end_dt",		false,	"",	dfDateYmd,	0,	false,	false);
	                  InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	"bzc_trf_curr_cd",	false,	"",	dfNone,		0,	false,	false);
	                  InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	"bil_amt",			false,	"",	dfNullFloat,2,	false,	false);
	                  InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	false,	"dmdt_chg_sts_cd",	false,	"",	dfNone,		0,	false,	false);
	                  InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,	"fm_mvmt_dt",		false,	"",	dfDateYmd,	0,	false,	false);
					
            	} // with - end
            	break; 	 

 			case "t2sheet1":      // Tab2 - Charge
                 with (sheetObj) {

                     // 높이 설정
                     style.height = TAB2_SHEET_HEIGHT;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(1, 1, 10, 100);

 					var HeadTitle1  = "|Seq.|CNTR No.|T/S|From DT|To DT|F/T CMNC|F/T End|F/D";
 					//var headCount = ComCountHeadTitle(HeadTitle1);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(26, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false, false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                     //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,		DATAALIGN, COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					 InitDataProperty(0, cnt++ , dtHiddenStatus,	0,	daCenter,	true,	"ibflag");
					 InitDataProperty(0, cnt++ , dtSeq,				30,	daCenter,	true,	"seq");
					 InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	"cntr_no",				false,	"",		dfNone,			0,	false,	false);
					 InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	true,	"cntr_tpsz_cd",			false,	"",		dfNone,			0,	false,	false);
					 InitDataProperty(0, cnt++ , dtData, 			80,	daCenter,	true,	"fm_mvmt_dt",			false,	"",		dfDateYmd,		0,	false,	false);
					 InitDataProperty(0, cnt++ , dtData, 			80,	daCenter,	true,	"to_mvmt_dt",			false,	"",		dfDateYmd,		0,	false,	false);
					 InitDataProperty(0, cnt++ , dtData, 			80,	daCenter,	true,	"ft_cmnc_dt",			false,	"",		dfDateYmd,		0,	false,	false);
					 InitDataProperty(0, cnt++ , dtData, 			80,	daCenter,	true,	"ft_end_dt",			false,	"",		dfDateYmd,		0,	false,	false);
					 InitDataProperty(0, cnt++ , dtData,  			30,	daCenter,	true,	"ft_dys",				false,	"",		dfNullInteger,	0,	false,	false);
					 InitDataProperty(0, cnt++ , dtHidden,  		0,	daCenter,	true,	"dmdt_inv_no",			false,	"",		dfNone,			0,	false,	false);
					 
					 InitDataProperty(0, cnt++ , dtHidden,  		20,	daCenter,	true,	"svr_id",				false,	"",		dfNone,			0,	false,	false);
					 InitDataProperty(0, cnt++ , dtHidden,  		20,	daCenter,	true,	"cntr_cyc_no",			false,	"",		dfNone,			0,	false,	false);
					 InitDataProperty(0, cnt++ , dtHidden,  		20,	daCenter,	true,	"dmdt_chg_loc_div_cd",	false,	"",		dfNone,			0,	false,	false);
					 InitDataProperty(0, cnt++ , dtHidden,  		20,	daCenter,	true,	"chg_seq",				false,	"",		dfNone,			0,	false,	false);
					 InitDataProperty(0, cnt++ , dtHidden,  		20,	daCenter,	true,	"bil_amt",				false,	"",		dfNone,			0,	false,	false);
					 InitDataProperty(0, cnt++ , dtHidden,  		20,	daCenter,	true,	"aft_expt_dc_amt",		false,	"",		dfNone,			0,	false,	false);
					 InitDataProperty(0, cnt++ , dtHidden,  		20,	daCenter,	true,	"bzc_trf_curr_cd",		false,	"",		dfNone,			0,	false,	false);
					 InitDataProperty(0, cnt++ , dtHidden,  		20,	daCenter,	true,	"bzc_trf_seq",			false,	"",		dfNone,			0,	false,	false);
					 InitDataProperty(0, cnt++ , dtHidden,  		20,	daCenter,	true,	"bzc_dmdt_de_term_cd",	false,	"",		dfNone,			0,	false,	false);
					 InitDataProperty(0, cnt++ , dtHidden,  		20,	daCenter,	true,	"bzc_trf_grp_seq",		false,	"",		dfNone,			0,	false,	false);
					 
					 InitDataProperty(0, cnt++ , dtHidden,  		20,	daCenter,	true,	"expt_amt",				false,	"",		dfNone,			0,	false,	false);
					 InitDataProperty(0, cnt++ , dtHidden,  		20,	daCenter,	true,	"fx_ft_ovr_dys",		false,	"",		dfNone,			0,	false,	false);
					 InitDataProperty(0, cnt++ , dtHidden,  		20,	daCenter,	true,	"org_chg_amt",			false,	"",		dfNone,			0,	false,	false);
					 InitDataProperty(0, cnt++ , dtHidden,  		20,	daCenter,	true,	"dmdt_trf_cd",			false,	"",		dfNone,			0,	false,	false);
					 InitDataProperty(0, cnt++ , dtHidden,  		20,	daCenter,	true,	"rt_dtl_grp",			false,	"",		dfNone,			0,	false,	false);
					 InitDataProperty(0, cnt++ , dtHidden,  		20,	daCenter,	true,	"dmdt_trf_aply_tp_cd",	false,	"",		dfNone,			0,	false,	false);
					 
					 PopupImage  =  "img/btns_calendar.gif";
					 ShowButtonImage = 2;
					 CountPosition = 0;						   
				}
 				break;
                 
 			case "t2sheet2":      // Tab2 - Rate Detail
                 with (sheetObj) {

                      // 높이 설정
                     style.height = TAB2_SHEET_HEIGHT;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(1, 1, 10, 100);

 					var HeadTitle1  = "|From|Up To|Rate|Over|Billable AMT";
 					//var headCount = ComCountHeadTitle(HeadTitle1);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(7, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                     //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,		DATAALIGN, COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,	"ibflag");
 					 InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"rt_over",		false,	"",		dfNone,			0,	false,	false);
 					 InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"rt_under",		false,	"",		dfNone,			0,	false,	false);
 					 InitDataProperty(0, cnt++ , dtData,			150,	daRight,	true,	"rt_rate",		false,	"",		dfNullFloat,	2,	false,	false);
 					 InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"rt_day",		false,	"",		dfNone,			0,	false,	false);
 					 InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	"rt_chrg",		false,	"",		dfNullFloat,	2,	false,	false);
			 		 InitDataProperty(0, cnt++ , dtHidden,  		20,		daCenter,	true,	"rt_cur_cd",	false,	"",		dfNone,			0,	false,	false);
 					
			 		 CountPosition = 0;
 				}
 				break;
 				
 			case "t2sheet3":      //sheet1 init
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
	                
	                InitDataProperty(0, cnt++ , dtHiddenStatus,	0,daCenter,	true,	"ibflag");
	
					CountPosition = 0;
				}
				break;
         }
     }
    
    
  	/**
     * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
     */
    function t1sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
        with(sheetObj) {
            if (ColSaveName(Col) != "chk") {
                // row클릭시 해당 Check Box도 체크
                // "/" 구분자로 연결하여 선택된 행번 가져오기, 결과:"3/4/5"
                var sRowStr = GetSelectionRows("/");
                var arr = sRowStr.split("/");
                if (arr.length > 1) {
                	for (i=0; i<arr.length; i++) {
                        if (CellEditable(arr[i], "chk")) {
                        	// 토글 기능
                            CellValue2(arr[i], "chk") = (CellValue(arr[i], "chk") == '0') ? "1" : "0";
                        }
                    }
                    
                    // AllCheck box 상태 동기화
                    HeadCheck(0, "chk") = (CheckedRows("chk") == RowCount);
                }
            } else {
            	//Check box 클릭시  AllCheck box 상태 동기화 처리
	            ComSyncAllCheck(sheetObj, Col, Value);
            }
        }
    }
    
	
    /*
    function t1sheet1_OnPopupClick(sheetObj, row, col) {
  		if(sheetObj.ColSaveName(col) == 'corr_rmk')
  			ComShowMemoPad(sheetObj);
  	}
  	*/
    
    function t1sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
    	var colSaveNm = sheetObj.ColSaveName(Col);
    	
  		if(colSaveNm == "corr_rmk") {
	 		if(sheetObj.CellValue(Row, "cal_flg") == '') {
				ComShowCodeMessage('DMT03054');
				return;
			}
  			
  			//corr_rmk 셀을 더블클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
  		    ComShowMemoPad(sheetObj);
  		    
  			var _frameDoc  = document.getElementById(MEMO_FRAME_NAME).contentWindow.document;
  			var btnSaveObj = _frameDoc.getElementById("btn_apply");
  			btnSaveObj.innerHTML = 'Save';
  			
  			btnSaveObj.detachEvent('onclick', eval('save_click'));
  			btnSaveObj.attachEvent("onclick", eval('save_click'));
  		}
    }
  	
    function save_click() {
    	var _frameDoc  = document.getElementById(MEMO_FRAME_NAME).contentWindow.document;
		var btnSaveObj = _frameDoc.getElementById("btn_apply");
		btnSaveObj.detachEvent('onclick', eval('save_click'));
		
		doActionIBSheet(sheetObjects[0], document.form, IBSAVE_CORRRMK);
    }

    
	// sheetObj 포커스가 나갈 때
    function sheetobj_blur() {
   		var sheetObj = sheetObjects[0];
   		
   		with(sheetObj) {
   			var col = SelectCol;
   			var row = SelectRow;
   			
   			if(ColSaveName(col) != 'corr_rmk') return;
   			
   			if(befCorrRmk != CellValue(row, col)) {
	  			alert(befCorrRmk + ' --> ' + CellValue(row, col));
	  		}
   		}
    }
	
	
	/*
	 * Grid에서 말풍선 처리
	 */
	function t1sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
		with(sheetObj){
			Row = MouseRow;
			Col = MouseCol;
			if (Row > 0) {
				var ttText='';
				var colSaveNm = ColSaveName(Col);
				
				if(colSaveNm == 'corr_rmk') {	// Remark 전체내용을 보여줌
					var corrRmk = CellValue(Row, "corr_rmk");
					if(corrRmk == '') return;
					ttText = corrRmk;
				}
				MouseToolTipText = ttText;
			} else {
				MouseToolTipText = "";
			}
		}
	}
      

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         
         switch(sAction) {
 			case IBSEARCH:      // 조회
 				if(!validateForm(sheetObj,formObj,sAction)) return;
        	
	 			sheetObj.WaitImageVisible=false;
	        	ComOpenWait(true);
	        	
 				formObj.f_cmd.value = SEARCH01;
 				sheetObj.DoSearch("EES_DMT_4016GS.do", FormQueryString(formObj));
 				ComOpenWait(false);
 				break;
                
 			case IBGETTOMVMT:	// Get To MVMT 처리
 				if(!validateForm(sheetObj,formObj,sAction)) return;
 				
	 			sheetObj.WaitImageVisible=false;
	        	ComOpenWait(true);
	        	
 				formObj.f_cmd.value = SEARCH02;
				var sheetObj2 = sheetObjects[1];	// Hidden Sheet
				sheetObj2.DoAllSave("EES_DMT_4016GS.do", FormQueryString(formObj));
				ComOpenWait(false);
 				break;

 			case IBCALCULATE:
 				if(!validateForm(sheetObj,formObj,sAction)) return;
 				
 				//formObj.f_cmd.value = MULTI;
				//var sheetObj2 = sheetObjects[2];	// Hidden Sheet
				//sheetObj2.DoAllSave("EES_DMT_4016GS.do", FormQueryString(formObj));
 				sheetObj.WaitImageVisible = false;
 				ComOpenWait(true);
 				
 				sheetObj = sheetObjects[2];	// Hidden Sheet
	         	formObj.f_cmd.value = COMMAND01;	//원래 MULTI
	         	ComSetObjValue(formObj.backendjob_id, "CALCULATE");
	         	var params = sheetObj.GetSaveString(true, true) + "&" + FormQueryString(formObj);
	         	
	         	var sXml = sheetObj.GetSaveXml("EES_DMT_4016GS.do", params);
				var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
				
				if (backendJobKey != undefined && backendJobKey != '') {
					ComSetObjValue(formObj.backendjob_key, backendJobKey);
					sheetObj.WaitImageVisible = false;
					sheetObj.RequestTimeOut = 10000;
					timer = setInterval(getBackEndJobStatus, 3000); // 3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
				}
                break;
                
 			case IBCONFIRM:
 				if(!validateForm(sheetObj,formObj,sAction)) return;
 				
 				sheetObj.WaitImageVisible = false;
 				ComOpenWait(true);
 				
 				var chkRows = sheetObj.FindCheckedRow("chk").split("|");
         		for(var i=0; i < chkRows.length-1; i++) {
         			sheetObj.RowStatus(chkRows[i]) = "U";
         		}
         		
 				formObj.f_cmd.value = MULTI01;
 				sheetObj.DoSave("EES_DMT_4016GS.do", FormQueryString(formObj), "chk");
 				ComOpenWait(false);
                break;
                
 			case IBSAVE_CORRRMK:
 				//if(!validateForm(sheetObj,formObj,sAction)) return;
 				var row = sheetObj.SelectRow;
				var sparam =  "f_cmd=" 			+ MODIFY
							+ "&svr_id="		+ sheetObj.CellValue(row, "svr_id")
							+ "&cntr_no="		+ sheetObj.CellValue(row, "cntr_no")
							+ "&cntr_cyc_no="	+ sheetObj.CellValue(row, "cntr_cyc_no")
							+ "&dmdt_trf_cd="	+ sheetObj.CellValue(row, "dmdt_trf_cd")
							+ "&dmdt_chg_loc_div_cd=" + sheetObj.CellValue(row, "dmdt_chg_loc_div_cd")
							+ "&chg_seq="		+ sheetObj.CellValue(row, "chg_seq")
							+ "&corr_rmk="		+ sheetObj.CellValue(row, "corr_rmk")
							;
				
				var sheetObj2 = sheetObjects[5];
				var sXml = sheetObj2.GetSaveXml("EES_DMT_4016GS.do", sparam);
				//sheetObj.LoadSaveXml(sXml);
                break;
                
 			case IBSEARCH_MBILL:	// Manual Billing Retrieve
				if(sheetObj.id == 't2sheet1') {
					if(!validateForm(sheetObj,formObj,sAction)) return;
					
					ComSetObjValue(formObj.caller, "4016");
					
					if(ComGetObjValue(formObj.invoice_issue) == "1") {
						formObj.f_cmd.value = SEARCH;
						//ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.session_ofc_cd));
						ComSetObjValue(formObj.s_ofc_cd,	"SZPSC");
						ComSetObjValue(formObj.ofc_cd,		"SZPSC");
					} else {
						formObj.f_cmd.value = SEARCH01;
						//ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.cre_ofc_cd));
						ComSetObjValue(formObj.ofc_cd, "SZPSC");
					}
					
					sheetObj.WaitImageVisible=false;
		        	ComOpenWait(true);
					
					var sXml = sheetObj.GetSearchXml("EES_DMT_4016-2GS.do", FormQueryString(formObj));
	                var arrXml = sXml.split("|$$|");
	                
	                sheetObj.LoadSearchXml(arrXml[0]);			// Charge Grid
	                sheetObjects[4].LoadSearchXml(arrXml[1]);	// Rate Detail Grid
	                ComOpenWait(false);
	                //Billable AMT를 Rate Detail 전체 합으로 변경한다.(2010.070.02)
	                calcBillableAmount();
				
				} else if(sheetObj.id == 't2sheet3') {
					formObj.f_cmd.value = SEARCH02;
					var sXml = sheetObj.GetSearchXml("EES_DMT_4016-2GS.do", FormQueryString(formObj));
					var exRate = ComGetEtcData(sXml, "EX_RATE");
					ComSetObjValue(formObj.inv_xch_rt, exRate);
				}
 				break;    
                
 			case IBSAVE:
 				var sheetObj2 = sheetObjects[3];
 				var sheetObj3 = sheetObjects[4];
 				
 				if(!validateForm(sheetObj,formObj,sAction)) return;
 				
 				sheetObj.WaitImageVisible=false;
	        	ComOpenWait(true);
	        	
 				ComSetObjValue(formObj.caller, "4016");
 				ComSetObjValue(formObj.bkg_no, ComGetObjValue(formObj.s_bkg_no));
 				
 				// 3자리 콤마 제거
				unSetComma();
				
				var sparam = '';
				
				//Invoice 생성전
 				if(ComGetObjValue(formObj.invoice_issue) == "1") {
 					if(!formObj.chk_tax.checked) {
 						ComSetObjValue(formObj.tax_rto, "0");
 					}
 					
 					for(var i=sheetObj2.TopRow; i <= sheetObj2.LastRow; i++) {
 						sheetObj2.CellValue2(i, "ibflag") = "U";
 					}
 					
 					for(var i=sheetObj3.TopRow; i <= sheetObj3.LastRow; i++) {
 						sheetObj3.CellValue2(i, "ibflag") = "U";
 					}
 					var sparam1 = sheetObj2.GetSaveString();
 					var sparam2 = sheetObj3.GetSaveString();
 					
 					sparam1 = ComSetPrifix(sparam1, "subCharge");
 					sparam  = sparam1 + "&";
 					sparam2 = ComSetPrifix(sparam2, "subRate");
 					sparam  = sparam + sparam2;

 					formObj.f_cmd.value = MULTI;
 					
 					sparam += "&" + FormQueryString(formObj);
 				} else {
 					//Invoice 생성후
 					if(!formObj.chk_tax.checked) {
 						if(parseFloat(ComGetObjValue(formObj.tax_rto_dis)) == 0) {
 							ComSetObjValue(formObj.tax_rto, "0");
 						}else{
 							ComSetObjValue(formObj.tax_rto, ComGetObjValue(formObj.tax_rto_dis));
 						}
 					}
 					
 					formObj.f_cmd.value = MULTI01; //Invoice 생성후
 					sparam = FormQueryString(formObj);
 				}
				var sXml = sheetObj.GetSaveXml("EES_DMT_4016-2GS.do", sparam);
				sheetObj.LoadSaveXml(sXml);
				ComOpenWait(false);
				
				// ************* 저장 후 처리 **************
				var successYN = sheetObj.EtcData("SUCCESS_YN");
				
				if(successYN == 'Y') {
					var invIssue = ComGetObjValue(formObj.invoice_issue);
					var invNo;
					
					if(invIssue == '1') {
						invNo = sheetObj.EtcData("INVOICE_NO");
					} else { // '2'
						invNo = ComGetObjValue(formObj.dmdt_inv_no);
					}
					
					ComSetObjValue(formObj.invoice_issue, "2");
					ComSetObjValue(formObj.s_invoice_no, invNo);
					
					// Re-SEARCH
					doActionIBSheet(sheetObj, formObj, IBSEARCH_MBILL);
				} else
					initBtns2();
				
                break;
                
 			case IBARIF:
 				if(!validateForm(sheetObj,formObj,sAction)) return;   
                
 				sheetObj.WaitImageVisible=false;
	        	ComOpenWait(true);
	        	
 				formObj.f_cmd.value = COMMAND01;
 				
 				//sheetObj.DoSave("EES_DMT_4002GS.do", FormQueryString(formObj), -1, false);
				//var sParam = sheetObj.GetSaveString(true) +"&" + FormQueryString(formObj);
				var sParam = FormQueryString(formObj);
				
				//성공시 INVOICE 조회 버튼 처리
				var sXml = sheetObj.GetSaveXml("EES_DMT_4016-2GS.do", sParam);
				
				//3.저장 후 결과처리
				sheetObj.LoadSaveXml(sXml);
				ComOpenWait(false);
				
				//저장후 버튼 처리
				var successYN = ComGetEtcData(sXml, "SUCCESS_YN");
				ComSetObjValue(formObj.success_yn, successYN);
				
				//4.저장후 저장버튼 처리
				if(successYN == "Y") {
					// Retrieve
					doActionIBSheet(sheetObjects[3], formObj, IBSEARCH_MBILL);

					var invStsCd = ComGetObjValue(formObj.dmdt_inv_sts_cd);
					var arIfCd = ComGetObjValue(formObj.dmdt_ar_if_cd);
					
					//ARIF button Enable
					if( (invStsCd == "I" || invStsCd == "C") && arIfCd == "N")
						ComBtnEnable("btn_ARIF");
					else
						ComBtnDisable("btn_ARIF");
				}
				break;
				
 			case IBFAXSEND:
        		var mrd_file	= "";
        		
        		//MRD 파일
        		var temp_LR 	= ComGetObjValue(formObj.bil_to_loc_div_cd);

        		if(temp_LR == "") {
        			mrd_file = "EES_DMT_4901.mrd";		//L
        		}else if(temp_LR == "L") {
        			mrd_file = "EES_DMT_4901.mrd";		//L
        		}else if(temp_LR == "R") {
        			mrd_file = "EES_DMT_4902.mrd";		//R
        		}
        		
        		var dmdtInvNo	= ComGetObjValue(formObj.dmdt_inv_no);
        		var blNo		= ComGetObjValue(formObj.bl_no);
        		
	    		var ma_param = "jspno=4016"
					 + "&invoice_no=" + dmdtInvNo
					 + "&f_cmd=" + SEARCH01
					 + "&cre_ofc_cd=" + ComGetObjValue(formObj.cre_ofc_cd)
					 ;
	        	
	       		//MASTER DATA 조회
	       		var sXml =  sheetObj.GetSearchXml("EES_DMT_4003GS.do",	ma_param);
	       		sheetObj.LoadSearchXml(sXml);
	       		ComEtcDataToForm(formObj, sheetObj);
	    		
	       		//rd_fxeml_rd_param
	       		var rdParm =  " /ruseurlmoniker[0] /rfn [" + RDServerIP + "/EES_DMT_4003_RD.do] "		//DETAIL DATA 조회
	   						+ " /rv " + rvParmByInvoice(formObj)
							+ " /rpost [jspno=4016&invoice_no=" + dmdtInvNo + "&cre_ofc_cd=" + ComGetObjValue(formObj.cre_ofc_cd) + "]"		//jspno, invoice_no
   						;
	        	
        		ComSetObjValue(formObj.rd_fxeml_sys_cd,			"DMT");
    			ComSetObjValue(formObj.rd_fxeml_file_name,		mrd_file);
    			ComSetObjValue(formObj.rd_fxeml_bat_flg,		"N");
//    			ComSetObjValue(formObj.rd_fxeml_title,			"Invoice Number: " + dmdtInvNo + " (B/L No.: SMLM" + blNo + ") " + ComGetObjValue(formObj.act_payr_cust_nm));
    			ComSetObjValue(formObj.rd_fxeml_title,			"Invoice Number: " + dmdtInvNo + " (B/L No.: SMLM" + blNo + ")");
    			ComSetObjValue(formObj.rd_fxeml_rd_param,		rdParm);
    			ComSetObjValue(formObj.rd_fxeml_fax_sndr_id,	"SM Line");					//sndr_id
    			ComSetObjValue(formObj.rd_fxeml_eml_sndr_nm,	"SM Line");				//sndr_name
    			ComSetObjValue(formObj.rd_fxeml_eml_rcvr_add,	"");		//rcvr_email
    			ComSetObjValue(formObj.rd_fxeml_eml_atch_file,	"");
    			ComSetObjValue(formObj.rd_fxeml_eml_templt,		"EES_DMT_INVOICE_001.html");
    			ComSetObjValue(formObj.rd_fxeml_eml_tmplt_param,"inv_no;" + dmdtInvNo + "|bl_no;" + blNo + "|payer_nm;" + ComGetObjValue(formObj.act_payr_cust_nm));
    			ComSetObjValue(formObj.rd_fxeml_doc_tp,			"I");					//  I : Invoice D : Demend G : GroupDemand O : OTS
    			ComSetObjValue(formObj.payc,					ComGetObjValue(formObj.payer_cd));
    			ComSetObjValue(formObj.invno,					dmdtInvNo);
    			
        		break;
        		
        	case IBEMAILSEND:
        		var mrd_file	= "";
        		//MRD 파일
        		var temp_LR 	= ComGetObjValue(formObj.bil_to_loc_div_cd);

        		if(temp_LR == "") {
        			mrd_file = "EES_DMT_4901.mrd";		//L
        		}else if(temp_LR == "L") {
        			mrd_file = "EES_DMT_4901.mrd";		//L
        		}else if(temp_LR == "R") {
        			mrd_file = "EES_DMT_4902.mrd";		//R
        		}

        		var dmdtInvNo = ComGetObjValue(formObj.dmdt_inv_no);
        		var blNo = ComGetObjValue(formObj.bl_no);

	    		var ma_param = "jspno=4016"
					 + "&invoice_no=" + dmdtInvNo
					 + "&f_cmd=" + SEARCH01
					 + "&cre_ofc_cd=" + ComGetObjValue(formObj.cre_ofc_cd)
					 ;

        		//MASTER DATA 조회
        		var sXml =  sheetObj.GetSearchXml("EES_DMT_4003GS.do",	ma_param);
        		sheetObj.LoadSearchXml(sXml);
        		ComEtcDataToForm(formObj, sheetObj);
     		
        		//rd_fxeml_rd_param
        		var rdParm =  " /ruseurlmoniker[0] /rfn [" + RDServerIP + "/EES_DMT_4003_RD.do] "		//DETAIL DATA 조회
    						+ " /rv " + rvParmByInvoice(formObj)
							+ " /rpost [jspno=4016&invoice_no=" + dmdtInvNo + "&cre_ofc_cd=" + ComGetObjValue(formObj.cre_ofc_cd) + "]"		//jspno, invoice_no
    						;
        		
        		ComSetObjValue(formObj.rd_fxeml_sys_cd,			"DMT");
    			ComSetObjValue(formObj.rd_fxeml_file_name,		mrd_file);
    			ComSetObjValue(formObj.rd_fxeml_bat_flg,		"N");
//    			ComSetObjValue(formObj.rd_fxeml_title,			"Invoice Number: " + dmdtInvNo + " (B/L No.: SMLM" + blNo + ") " + ComGetObjValue(formObj.act_payr_cust_nm));
    			ComSetObjValue(formObj.rd_fxeml_title,			"Invoice Number: " + dmdtInvNo + " (B/L No.: SMLM" + blNo + ")");
    			ComSetObjValue(formObj.rd_fxeml_rd_param,		rdParm);
    			ComSetObjValue(formObj.rd_fxeml_fax_no,			"");			//rcvr_fax_no
    			ComSetObjValue(formObj.rd_fxeml_fax_sndr_id,	"SM Line");					//sndr_id
    			ComSetObjValue(formObj.rd_fxeml_eml_sndr_nm,	"SM Line");				//sndr_name
    			ComSetObjValue(formObj.rd_fxeml_eml_atch_file,	dmdtInvNo);
    			ComSetObjValue(formObj.rd_fxeml_eml_templt,		"EES_DMT_INVOICE_001.html");
    			ComSetObjValue(formObj.rd_fxeml_eml_tmplt_param,"inv_no;" + dmdtInvNo + "|bl_no;" + blNo + "|payer_nm;" + ComGetObjValue(formObj.act_payr_cust_nm));
    			ComSetObjValue(formObj.rd_fxeml_doc_tp,			"I");					//  I : Invoice D : Demend G : GroupDemand O : OTS
    			ComSetObjValue(formObj.payc,					ComGetObjValue(formObj.payer_cd));
    			ComSetObjValue(formObj.invno,					dmdtInvNo); 
    			
        		break;	
         }
	}
	
	
	/**
	* BackEndJob 관련 Status='3' 이 될때까지 확인한다.
	*/
	function getBackEndJobStatus() {
	 	var formObj = document.form;
	 	var sheetObj = sheetObjects[2];
	
	 	//It gets a status of backendjob. 2
	 	ComSetObjValue(formObj.f_cmd, COMMAND02);
	
	 	var params		= "f_cmd=" + COMMAND02 + "&backendjob_key=" + ComGetObjValue(formObj.backendjob_key);
	 	var sXml		= sheetObj.GetSearchXml("EES_DMT_4016GS.do", params);
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
	 	var sheetObj = sheetObjects[2];
	 	var fCmd = MULTI;
 	 	ComSetObjValue(formObj.f_cmd, fCmd);
	 	
	 	var params = "f_cmd=" + fCmd + "&backendjob_key=" + ComGetObjValue(formObj.backendjob_key);
	 	var sXml = sheetObj.GetSaveXml("EES_DMT_4016GS.do", params);
	 	sheetObj.LoadSaveXml(sXml);
	 	
	 	ComOpenWait(false);
	}
	
	
	/**
     * Confirm 이후 처리
     */
  	function t1sheet1_OnSaveEnd(sheetObj, ErrMsg) {
  		if(ErrMsg != '') return;
  		
		var formObj = document.form1;
		var chkRows = sheetObj.FindCheckedRow("chk").split("|");
		
  		for(var i=0; i < chkRows.length-1; i++) {
  			sheetObj.CellValue(chkRows[i], "dmdt_chg_sts_cd") = 'C';
  		}
  		
  		//전체 UnCheck --> sheetObj.RowStatus(i)가  모두  'R' 로  바뀜
		sheetObj.CheckAll("chk") = 0;
  	}
  	
  	
	/**
     * t1sheet2(Hidden Sheet - Get To MVMT) 호출 후 처리
     */
  	function t1sheet2_OnSaveEnd(sheetObj,ErrMsg) {
  		if(ErrMsg != '') return;
  		
		var formObj = document.form;
		var mainSheetObj = sheetObjects[0];	// 원래 조회 리스트
		
		for(var i=sheetObj.TopRow; i <= sheetObj.LastRow; i++) {
			
			var seq = sheetObj.CellValue(i, "seq");
			var rowIdx = mainSheetObj.FindText("seq", seq);
			
			if(rowIdx != -1) {
				var toMvmtYdCd	= sheetObj.CellValue(i, "to_mvmt_yd_cd");
				var toMvmtDt	= sheetObj.CellValue(i, "to_mvmt_dt");
				var toMvmtYr	= sheetObj.CellValue(i, "to_mvmt_yr");
				var toMvmtSeq	= sheetObj.CellValue(i, "to_mvmt_seq");
				var toMvmtSplitNo = sheetObj.CellValue(i, "to_mvmt_split_no");
				
				with(mainSheetObj) {
					//CellValue(rowIdx, "get_flg")			= 'Y';
					CellValue2(rowIdx, "to_mvmt_yd_cd")		= toMvmtYdCd;
					CellValue2(rowIdx, "to_mvmt_sts_cd") 	= 'ID';
					CellValue2(rowIdx, "dmdt_trf_cd")		= 'DMIF';
					CellValue2(rowIdx, "to_mvmt_dt")		= toMvmtDt;
					CellValue2(rowIdx, "to_mvmt_yr")		= toMvmtYr;
					CellValue2(rowIdx, "to_mvmt_seq")		= toMvmtSeq;
					CellValue2(rowIdx, "to_mvmt_split_no")	= toMvmtSplitNo;
				}
			}
		}
		
		var chkRows = mainSheetObj.FindCheckedRow("chk").split("|");
 		for(var i=0; i < chkRows.length-1; i++) {
 			mainSheetObj.CellValue2(chkRows[i], "get_flg") = 'Y';
 		}
  	}
     
     
     /**
      * t1sheet3(Hidden Sheet - Calculate) 호출 후 처리
      */
   	function t1sheet3_OnSaveEnd(sheetObj,ErrMsg) {
   		if(ErrMsg != '') return;
   		
 		var formObj = document.form;
 		var mainSheetObj = sheetObjects[0];	// 원래 조회 리스트
 		
 		for(var i=sheetObj.TopRow; i <= sheetObj.LastRow; i++) {
 			
 			var seq = sheetObj.CellValue(i, "seq");
 			var rowIdx = mainSheetObj.FindText("seq", seq);
 			
 			if(rowIdx != -1) {
				mainSheetObj.CellValue(rowIdx, "cal_flg")			= 'Y';
				mainSheetObj.CellValue(rowIdx, "ft_dys")			= sheetObj.CellValue(i, "ft_dys");
				mainSheetObj.CellValue(rowIdx, "fx_ft_ovr_dys")		= sheetObj.CellValue(i, "fx_ft_ovr_dys");
				mainSheetObj.CellValue(rowIdx, "ft_cmnc_dt")		= sheetObj.CellValue(i, "ft_cmnc_dt");
				mainSheetObj.CellValue(rowIdx, "ft_end_dt")			= sheetObj.CellValue(i, "ft_end_dt");
				mainSheetObj.CellValue(rowIdx, "bzc_trf_curr_cd")	= sheetObj.CellValue(i, "bzc_trf_curr_cd");
				mainSheetObj.CellValue(rowIdx, "bil_amt")			= sheetObj.CellValue(i, "bil_amt");
				mainSheetObj.CellValue(rowIdx, "dmdt_chg_sts_cd")	= sheetObj.CellValue(i, "dmdt_chg_sts_cd");
				mainSheetObj.CellValue(rowIdx, "dmdt_chg_loc_div_cd") = "SZP";
 			}
 		}
 		
 		tabObjects[0].TabEnable(1) = false;
   	}
      
      
	// REMARK MESSAGE
	function AlertCRemark() {
		var formObj = document.form2;
		var cancel_rmk	= ComGetObjValue(formObj.cxl_rmk);		//	cancel_remark
		var cancel_date	= ComGetObjValue(formObj.upd_dt);		//	update_dt
		var ofc_cd 		= ComGetObjValue(formObj.upd_ofc_cd);	//	update_ofc_cd
		var usr_id 		= ComGetObjValue(formObj.upd_usr_id);	//update_usr_id
		var usr_name 	= ComGetObjValue(formObj.upd_usr_nm);	//update_usr_nm
		var msg 		= cancel_rmk
						+ "\n\nCancel Date: "+ cancel_date
						+ "\nOffice: "		+ ofc_cd
						+ "\nUser ID: "		+ usr_id
						+ "\nUser Name: "	+ usr_name;
		ComShowMessage(msg);
  	}
	
      
	/**
	 * Tax Rate 체크
	 */
	 function setTax(){
		var formObj = document.form2;
		
		if(formObj.chk_tax.checked) {
			ComSetObjValue(formObj.tax_rto_dis, ComGetObjValue(formObj.tax_rto));
		}else{
			ComSetObjValue(formObj.tax_rto_dis, "0");
		}
		
		getExRate();
		setComma();
	}
      
	 
	/**
	 * INV Cur 변경시 ExRate를 조회하고 Invoice Amt를 계산한다.
	 */
	function getExRate() {
		var formObj = document.form2;
		var chg_curr_cd = ComGetObjValue(formObj.chg_curr_cd);
		var inv_curr_cd = ComGetObjValue(formObj.inv_curr_cd);
		
		if(chg_curr_cd == "" || inv_curr_cd == "")	return;
		
		var chg_dc_amt;
		var inv_xch_rt;	
		var tot_amt;	
		var dc_amt;		
		var bil_amt;
		var inv_chg_amt;
		var tax_rto;
		var tax_amt;
		var inv_amt;
		
		bil_amt 	= parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.mn_bil_amt),	"float"));	//Billable AMT
		tax_rto		= parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.tax_rto_dis),	"float"));	//Tax Rate
		chg_dc_amt	= parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.chg_dc_amt),	"float"));	//Discount AMT
		tot_amt 	= parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.tot_amt),		"float"));	//Total AMT
		
		
		inv_xch_rt 	= ComGetObjValue(formObj.inv_xch_rt);
		inv_xch_rt	= ComRound(inv_xch_rt, 6);	//소숫점 6자리 반올림
		
		//tot_amt = tot_amt * inv_xch_rt;
		//tot_amt = DMTtrimCurrencyAmount(inv_curr_cd, tot_amt);
		
		//alert('tot_amt: ' + tot_amt);
		
		//dc_amt 계산 로직 변경
		//dc_amt	= inv_xch_rt * chg_dc_amt;
		//dc_amt	= DMTtrimCurrencyAmount(inv_curr_cd, dc_amt);
		dc_amt		= chg_dc_amt;
		
		//Billing AMT 계산 로직 변경
		inv_chg_amt = tot_amt - dc_amt;
		inv_chg_amt	= DMTtrimCurrencyAmount(inv_curr_cd, inv_chg_amt);

		
		var cre_cnt_cd = "";
		
		//Invoice 생성전
		if(ComGetObjValue(formObj.invoice_issue) == "1" ) {
			cre_cnt_cd = ComGetObjValue(formObj.session_cnt_cd);
		//Invoice 생성후
		} else { //if(ComGetObjValue(formObj.invoice_issue) == "2" ) {
			cre_cnt_cd = ComGetObjValue(formObj.cre_cnt_cd);
		}
		
		if(cre_cnt_cd == "VN") {	//베트남일 경우
			tax_amt = (inv_chg_amt / (1 - tax_rto * 0.01)) * (tax_rto * 0.01);
		}else{
			tax_amt = (tax_rto * 0.01) * inv_chg_amt;
		}
		
		tax_amt	= DMTtrimCurrencyAmount(inv_curr_cd, tax_amt);
		
		inv_amt	= inv_chg_amt + tax_amt;
		inv_amt	= DMTtrimCurrencyAmount(inv_curr_cd, inv_amt);
		
		
		//반올림, 절사 처리
		//ComSetObjValue(formObj.inv_xch_rt, inv_xch_rt);
		//ComSetObjValue(formObj.tot_amt, tot_amt);
		//ComSetObjValue(formObj.dc_amt, dc_amt);
		//ComSetObjValue(formObj.inv_chg_amt, inv_chg_amt);
		ComSetObjValue(formObj.tax_amt, tax_amt);
		ComSetObjValue(formObj.inv_amt, inv_amt);
		
		setComma();
	}
	
	
	/**
	 * 수치 문자열을 숫자포맷에 맞게 변경한다.
	 */
	function setComma(){
    	var formObj = document.form2;
    	
		//Charge 3자리 콤마
//		var org_chg_amt		= ComAddComma2(ComGetObjValue(formObj.mn_org_chg_amt),"#,###.00");
//		var dmdt_expt_amt	= ComAddComma2(ComGetObjValue(formObj.dmdt_expt_amt),"#,###.00");
//		var chg_dc_amt		= ComAddComma2(ComGetObjValue(formObj.chg_dc_amt),"#,###.00");
		var bil_amt			= ComAddComma2(ComGetObjValue(formObj.mn_bil_amt),"#,###.00");
//		var aft_inv_adj_amt	= ComAddComma2(ComGetObjValue(formObj.aft_inv_adj_amt),"#,###.00");
		
		//Invoice
		var tot_amt			= ComAddComma2(ComGetObjValue(formObj.tot_amt),"#,###.00");
		var dc_amt			= ComAddComma2(ComGetObjValue(formObj.dc_amt),"#,###.00");
		var inv_chg_amt		= ComAddComma2(ComGetObjValue(formObj.inv_chg_amt),"#,###.00");
		var tax_amt			= ComAddComma2(ComGetObjValue(formObj.tax_amt),"#,###.00");
		var inv_amt			= ComAddComma2(ComGetObjValue(formObj.inv_amt),"#,###.00");
		var inv_xch_rt		= parseFloat(ComGetObjValue(formObj.inv_xch_rt)).toFixed(6);

//		ComSetObjValue(formObj.mn_org_chg_amt, org_chg_amt);
//		ComSetObjValue(formObj.dmdt_expt_amt, dmdt_expt_amt);
//		ComSetObjValue(formObj.chg_dc_amt, chg_dc_amt);
		ComSetObjValue(formObj.mn_bil_amt, bil_amt);
//		ComSetObjValue(formObj.aft_inv_adj_amt, aft_inv_adj_amt);
		
		ComSetObjValue(formObj.tot_amt, tot_amt);
		ComSetObjValue(formObj.dc_amt, dc_amt);
		ComSetObjValue(formObj.inv_chg_amt, inv_chg_amt);
		ComSetObjValue(formObj.tax_amt, tax_amt);
		ComSetObjValue(formObj.inv_amt, inv_amt);
		ComSetObjValue(formObj.inv_xch_rt, inv_xch_rt);
    }
      
	
	function unSetComma(){
        var formObj = document.form2;
  		//Charge 3자리 콤마 제거
//  	var org_chg_amt		= ComGetUnMaskedValue(ComGetObjValue(formObj.mn_org_chg_amt),"float");
//  	var dmdt_expt_amt	= ComGetUnMaskedValue(ComGetObjValue(formObj.dmdt_expt_amt),"float");
//  	var chg_dc_amt		= ComGetUnMaskedValue(ComGetObjValue(formObj.chg_dc_amt),"float");
  		var bil_amt			= ComGetUnMaskedValue(ComGetObjValue(formObj.mn_bil_amt),"float");
//  	var aft_inv_adj_amt	= ComGetUnMaskedValue(ComGetObjValue(formObj.aft_inv_adj_amt),"float");
  		
  		//Invoice
  		var tot_amt			= ComGetUnMaskedValue(ComGetObjValue(formObj.tot_amt),"float");
  		var dc_amt			= ComGetUnMaskedValue(ComGetObjValue(formObj.dc_amt),"float");
  		var inv_chg_amt		= ComGetUnMaskedValue(ComGetObjValue(formObj.inv_chg_amt),"float");
  		var tax_amt			= ComGetUnMaskedValue(ComGetObjValue(formObj.tax_amt),"float");
  		var inv_amt			= ComGetUnMaskedValue(ComGetObjValue(formObj.inv_amt),"float");
  		
//  	ComSetObjValue(formObj.mn_org_chg_amt, org_chg_amt);
// 		ComSetObjValue(formObj.dmdt_expt_amt, dmdt_expt_amt);
//  	ComSetObjValue(formObj.chg_dc_amt, chg_dc_amt);
  		ComSetObjValue(formObj.mn_bil_amt, bil_amt);
//  	ComSetObjValue(formObj.aft_inv_adj_amt, aft_inv_adj_amt);
  		
  		ComSetObjValue(formObj.tot_amt, tot_amt);
  		ComSetObjValue(formObj.dc_amt, dc_amt);
  		ComSetObjValue(formObj.inv_chg_amt, inv_chg_amt);
  		ComSetObjValue(formObj.tax_amt, tax_amt);
  		ComSetObjValue(formObj.inv_amt, inv_amt);    	
	}
      
      
    /**
	 * Combo 기본 설정 
	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */ 
	function initCombo(comboObj, comboNo) {
	    var formObj = document.form;
	    
	    switch(comboObj.id) {  
	    	case "tariff_type":
	    		with (comboObj) { 
					MultiSelect = false;
					SetColAlign("left|left");
					SetColWidth("45|270");
					DropHeight = 160;
					ColBackColor(0) = "#CCFFFD";
					ColBackColor(1) = "#CCFFFD";
					
					InsertItem(0, "DMIF|DEMURRAGE INBOUND LADEN CONTAINER", "DMIF");
	  				InsertItem(1, "DMOF|DEMURRAGE OUTBOUND LADEN CONTAINER", "DMOF");
			    }
	    		break;
	    		
	    	case "yd_cd2":
   	    		with (comboObj) { 
   	    			MultiSelect = false; 
  					UseAutoComplete = true;
	    			SetColAlign("left");
	    			SetColWidth("50");
  					DropHeight = 160;
  					
  					ValidChar(2, 1);	// 영어대문자, 숫자 사용
					MaxLength = 2; 
   		    	}
   	    		break;
   	    		
	    	case "attention":
	    		with (comboObj) {
					MultiSelect = false;
					SetColAlign("left|left|left|left");
					DropHeight = 160;
			    }
	    		break;
	    }
	}
	 

	function doActionIBCombo(sheetObj, formObj, comboObj, formCmd, srcObj) {
		sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;
    	 
		formObj.f_cmd.value = formCmd;
		var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
    	 
    	 switch(comboObj.id) {
 	        case "yd_cd2":
 	        	var comboDatas;
 	        	var chkObj;
 	        	var condType = ComGetObjValue(formObj.cond_type);
 	        	
 	        	if(srcObj.name == 'yd_cd') {
	 	        	comboObj.RemoveAll();			
	 	        	chkObj = formObj.chk_yd_cd;
	 	        	comboDatas = ComGetEtcData(sXml, "YD");
 	        	} else {
 	        		if(condType == 'date')
 	        			chkObj = formObj.chk_yd_cd;
 	        		else
 	        			chkObj = formObj.chk_loc_cd;
 	        		
 	        		comboDatas = ComGetEtcData(sXml, "LOC_CD");
 	        	}
				
				if (comboDatas != undefined && comboDatas != '') {
					ComSetObjValue(chkObj, "Y");
					if(srcObj.name == 'yd_cd') {
						comboItems = comboDatas.split(ROWMARK);
						addComboItem2(comboObj, comboItems);
					}
				} else {
					ComClearObject(srcObj);
					
					if(srcObj.name == 'yd_cd') {
						sheetObj.WaitImageVisible = true;
						return;
					}
					
					ComSetObjValue(chkObj, "N");
					ComShowCodeMessage('DMT00110', "Location");
					srcObj.focus();
				}
 	        	break;
 	        	
 	        case "attention":
 	        	// ATTENTION LIST
 	        	if(formCmd == SEARCHLIST03) {
					var comboDatas;
					var comboItems;
					comboDatas = ComGetEtcData(sXml, "ATTENTION");
					comboObj.RemoveAll();
					
					if(comboDatas != undefined && comboDatas != '') {
						comboItems = comboDatas.split(ROWMARK);
						addComboItem2(comboObj, comboItems);
					}
 	        	} else if(formCmd == SEARCHLIST06) {
 	        		ComSetObjValue(formObj.ofc_curr_date, ComGetEtcData(sXml, "OFC_CURR_DAY"));
				}
 	        	break;
         }
    	 
         sheetObj.WaitImageVisible = true;
     }
	
 	
    /**
     * 콤보필드에 데이터를 추가해준다.
     */	
 	function addComboItem(comboObj, comboDatas, isOnlyCode, isReverse) {
 		var comboItem;
 		var comboItems;
 		var val;
 		var txt;
 		if (comboDatas != undefined) {
 			comboItems = comboDatas.split(ROWMARK);	
 	    	for (var i = 0 ; i < comboItems.length ; i++) {
 	    		comboItem = comboItems[i].split(FIELDMARK);
 	    		//ComboItem[0]: Code, [1]: Description
    			val = comboItem[0];
 				txt = isOnlyCode ? comboItem[0] : comboItem[1];
 				// Combo 박스에 Description 이 나타나도록 설정해주는 변수
 				if (isReverse) {
 					ComAddComboItem(comboObj,txt,val);
 				}
 				else {
 					ComAddComboItem(comboObj,val,txt);
 				}
 	    	}
 		}   		
 	}
 	
 	
 	/**
     * 콤보필드에 데이터를 추가해준다.
     */	
	function addComboItem2(comboObj, comboItems) {
 		
 		switch(comboObj.id) {
 			case "yd_cd2":
 				for (var i = 0 ; i < comboItems.length ; i++) {
 		    		var comboItem = comboItems[i].split(FIELDMARK);
 					comboObj.InsertItem(i, comboItem[1], comboItem[0]);		
 		    	}
 				break;
 				
 			case "attention":
 				for (var i = 0 ; i < comboItems.length ; i++) {
 		    		var comboItem = comboItems[i].split(FIELDMARK);
 					comboObj.InsertItem(i, comboItem[0]+"|"+comboItem[1]+"|"+comboItem[2]+"|"+comboItem[3], comboItem[4]);		
 		    	}
 				break;
 		}
	}
      
      
	/**
	* 콤보필드에 데이터를 추가해준다. (미사용)
	*/	
   	function addMultiComboItem(comboObj, comboItems) {
       	for (var i = 0 ; i < comboItems.length ; i++) {
       		var comboItem = comboItems[i].split(FIELDMARK);
   			comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[1]);		
       	}
   	}
 	

 	//Attention IB콤보 선택 이벤트
	function attention_OnChange(comboObj, Index_Code, Text) {
		var formObj = document.form2;
		var code = comboObj.Code;
		
		//alert('attention_OnChange --> ' + code);
		ComSetObjValue(formObj.dmdt_payr_cntc_pnt_nm,	comboObj.GetText(code,0));
		ComSetObjValue(formObj.payr_cntc_pnt_phn_no,	comboObj.GetText(code,1));	//텍스트 컬럼 보여주기
		ComSetObjValue(formObj.payr_cntc_pnt_fax_no,	comboObj.GetText(code,2));	//텍스트 컬럼 보여주기
		ComSetObjValue(formObj.payr_cntc_pnt_eml,		comboObj.GetText(code,3));	//텍스트 컬럼 보여주기
		
		var codes = code.split("^");			//code
		if(codes != undefined || codes != "") {
			ComSetObjValue(formObj.cust_cntc_pnt_seq , codes[1]);
		}
	}
 	
 	

    //콤보관련 데이터를 조회하는 함수
  	function doActionIBCommon(sheetObj, formObj, sAction, formCmd) {
  	    sheetObj.ShowDebugMsg = false;
  		sheetObj.WaitImageVisible = false;
  		
  		//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
  		ComSetObjValue(formObj.f_cmd, formCmd);
  		//ComSetObjValue(formObj.ofc_cd, "SZPSC");
  		ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.session_ofc_cd));
  		
  	    switch(formCmd) {
  	    	// SHEET SET 이 존재하는지 조회
			case COMMAND13:
				ComSetObjValue(formObj.dmdt_sh_tp_cd, "I");
				var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
				
				//3.조회후 결과처리
				ComSetObjValue(formObj.has_sheetset, ComGetEtcData(sXml, "RESULT"));
				break;
				
			// Sheet Option 조회
			case COMMAND14:
				var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
				
				//3.조회후 결과처리
				ComSetObjValue(formObj.bil_to_loc_div_cd, 	ComGetEtcData(sXml, "BIL_TO_LOC_DIV_CD"));
				break;

			//Payer별 Email, FAX 번호를 조회한다.
			case COMMAND02:
				var sParam = "f_cmd=" + COMMAND02
						  + "&payer_cd="	+ formObj.payer_cd.value
						  + "&dmdt_trf_cd=" + formObj.dmdt_trf_cd.value
						  + "&ofc_cd="		+ formObj.cre_ofc_cd.value;
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_4002GS.do", sParam);
				
				//3.조회후 결과처리
				ComSetObjValue(formObj.payr_faxnos, 	ComGetEtcData(sXml, "FAX_NO"));
				ComSetObjValue(formObj.payr_emailnos, 	ComGetEtcData(sXml, "EMAIL_NO"));
				break;
  	    }
  	    
  		sheetObj.WaitImageVisible = true;
  	}
	 
	 
	// IBMultiCombo Tariff Type 초기화
   	function initComboValue_tariff_type() {
   		comboObjects[0].Code = "DMIF";
   	}
	
	// IBMultiCombo YardCode2 초기화
   	function initComboValue_yd_cd2() {
   		comboObjects[1].RemoveAll();
   	}
	
	
	// 선택된 콤보Item이 변경되었을 때 이벤트 발생
//	function tariff_type_OnChange(comboObj, value, text) {
//   		if(value == 'DMIF')
//   			ComBtnEnable('btn_GetToMVMT');
//   		else
//   			ComBtnDisable('btn_GetToMVMT');
//   	}
	
	
	/**
  	 * IBSheet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
  	 * (Tab-1 Retrieve 처리후)
  	 */
  	function t1sheet1_OnSearchEnd(sheetObj,ErrMsg) {
  		if(ErrMsg != '') return;
  		
		var formObj = document.form;
		sheetObj.CheckAll("chk") = 0;
		
		with(formObj) {
			tabObjects[0].TabEnable(1) = false;
			
  			// 결과데이터가 없을경우, 검색조건 입력데이터 유지
        	if(sheetObj.SearchRows == 0) {
        		initBtns();
        	} else {
        		var trfCd = comboObjects[0].Code;
        		
        		if(trfCd == 'DMIF') {
        			ComBtnEnable('btn_GetToMVMT');
        			
        			for(var i=sheetObj.TopRow; i <= sheetObj.LastRow; i++) {
        				if(sheetObj.CellValue(i, "dmdt_chg_sts_cd") != '') {
	        				sheetObj.CellValue2(i, "get_flg") = "Y";
	        				sheetObj.CellValue2(i, "cal_flg") = "Y";
        				}
        			}
        			
        		} else {	// 'DMOF'
        			ComBtnDisable('btn_GetToMVMT');
        			
        			for(var i=sheetObj.TopRow; i <= sheetObj.LastRow; i++) {
        				if(sheetObj.CellValue(i, "dmdt_chg_sts_cd") != '')
        					sheetObj.CellValue2(i, "cal_flg") = "Y";
        					
        				sheetObj.CellValue2(i, "get_flg") = "Y";
        				sheetObj.CellValue2(i, "dmdt_trf_cd") = "DMOF";
        			}
        		}
        		
    			// 버튼 활성화
    			DmtComEnableManyBtns(true, "btn_Calculate", "btn_Confirm", "btn_MBilling", "btn_ROInfo", "btn_MVMTInq", "btn_ExptInq", "btn_DownExcel");
    			
        		if(sheetObj.CellValue(sheetObj.TopRow, "roll_ovr") == 'S')
			  		document.getElementById("btn_ROInfo").style.color = "red";
        		else
        			document.getElementById("btn_ROInfo").style.color = "";
  			}
		} // with end
  	}
	
	// Tab-2 Retrieve 처리후
  	function t2sheet1_OnSearchEnd(sheetObj,ErrMsg) {
  		var formObj = document.form2;

  		// 조회된 EtcData를 Form 객체에 설정
  		ComEtcDataToForm(formObj, sheetObj);
  		
  		// 출력 데이터 포맷 처리
  		setComma();
  		
  		// Attention IB콤보 초기화
  		//comboObjects[2].Code = "";
  		
  		// 버튼 활성화/비활성화 처리
  		initBtns2();
		
  		with(formObj) {
			//날짜 하이픈 처리
			if(ComGetObjValue(formObj.due_date) != "********") {
				ComSetObjValue(formObj.due_date, ComGetMaskedValue(formObj.due_date.value, "ymd"));
			}
			//ComSetObjValue(due_date, ComGetMaskedValue(due_date.value, "ymd"));
			
			//Create Note 텍스트 동적처리
			if(ComGetObjValue(dmdt_inv_sts_cd) == "C" && ComGetObjValue(cr_inv_no) != "") {
				document.getElementById('cr_nm').innerHTML = "Reference No";
			}else{
				document.getElementById('cr_nm').innerHTML = "Credit Note";
			}
			
			// 1. invoice 전에는 항상 체크 박스를 체크 상태로 만든다.
		    // 2. Invoice 후에는 금액이 0이면 체크를 안 하고, 
		    //     (Invoice의 tax_rto, Office별 tax_rto)가 다르면 체크박스를 선택 안하고 조회한 Invoice Tax_Rto를 나타낸다.
		    //     (Invoice의 tax_rto, Office별 tax_rto)가 같으면 체크박스를 선택 한다.
		  	// TAX 포함 가격일 경우만 체크 한다.(INVOICE 생성후)
			if(ComGetObjValue(invoice_issue) == "2"){
				if(ComGetObjValue(tax_amt) == "0.00") {
					chk_tax.checked = false;
					ComSetObjValue(tax_rto_dis, "0");
				} else {
					//office별 tax_rto와 invoice에 저장된 tax_rto 값을 비교한다.
					if(ComGetObjValue(tax_rto) == ComGetObjValue(inv_tax_rto)) {
						chk_tax.checked = true;
						ComSetObjValue(tax_rto_dis, ComGetObjValue(tax_rto));
					}else{
						chk_tax.checked = false;
						ComSetObjValue(tax_rto_dis, ComGetObjValue(inv_tax_rto));
					}
				}
			} else {
				// Invoice Issue 이전 조회
				chk_tax.checked = true;
				ComSetObjValue(tax_rto_dis, ComGetObjValue(tax_rto));
			}
			
			ComSetObjValue(vndr_seq, ComGetObjValue(trucker_cd));
			
			// 첫번째 콤보 항목이 Default
		  	searchAttentionList();
		  	
		  	
		  	//Sheet Set 있는지 없는지 조회한다.
			//Sheet Set가 없을 경우에는 Preview, Print, Fax send, Email send를 버튼 클릭시 Alert MSG을 띄워 막고자 합니다
			doActionIBCommon(sheetObjects[5], formObj, IBSEARCH, COMMAND13);
			
			//Payer별 email, faxno를 조회한다.
			//payer_cd, ofc_cd, dmdt_trf_cd
			if(ComGetObjValue(formObj.invoice_issue) == "2" && ComGetObjValue(formObj.payer_cd) != "") {
				doActionIBCommon(sheetObjects[5], formObj, IBCHK_SHEETSET, COMMAND02);
			}
			
			
			//조회한 ATTENTION 정보
			ComSetObjValue(org_dmdt_payr_cntc_pnt_nm, 	ComGetObjValue(dmdt_payr_cntc_pnt_nm));
			ComSetObjValue(org_payr_cntc_pnt_phn_no, 	ComGetObjValue(payr_cntc_pnt_phn_no));
			ComSetObjValue(org_payr_cntc_pnt_fax_no, 	ComGetObjValue(payr_cntc_pnt_fax_no));
			ComSetObjValue(org_payr_cntc_pnt_eml, 		ComGetObjValue(payr_cntc_pnt_eml));
			
  		} // with(formObj) - end
  	}
	
  	
  	
  	// Rate Detail Grid 조회 후 처리
  	function t2sheet2_OnSearchEnd(sheetObj,ErrMsg) {
  		var formObj = document.form2;
  		var chgSheet = sheetObjects[3]; // Charge Grid
  		
  		if(chgSheet.SearchRows > 0) {
  			t2sheet1_OnSelectCell(chgSheet, 0, 0, 1, 0);
  		}
  		
  		initBtns2();
  	}
  	
  	
  	/**
	 * Charge Sheet 에 변경이 발생하였을 때 호출되는 함수
	 */		 
	function t2sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
  		
		 if(OldRow != NewRow) {
			var rtDtlGrp = sheetObj.CellValue(NewRow, "rt_dtl_grp");
	  		var rtDtlSheet = sheetObjects[4]; // Rate Detail Grid
	  		var selRow = 0;
	  		
	  		with(rtDtlSheet) {
		  		for(var i=1; i <= LastRow; i++) {
		  			if(CellValue(i, "rt_cur_cd") == rtDtlGrp) {
		  				RowHidden(i) = false;
		  				if(selRow == 0) selRow = i;
		  			} else
		  				RowHidden(i) = true;
		  		}
		  		
		  		SelectRow = selRow;
	  		}
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
		if(invoice_LR == "") {
			path="apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4901.mrd";
		}else if(invoice_LR == "L") {
			path="apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4901.mrd";
		}else if(invoice_LR == "R") {
			path="apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4902.mrd";
		}
		
		var ma_param = "jspno=4016"
			 + "&invoice_no=" + ComGetObjValue(formObj.dmdt_inv_no)
			 + "&f_cmd=" + SEARCH01
			 + "&cre_ofc_cd=" + ComGetObjValue(formObj2.cre_ofc_cd)
			 ;

    	//MASTER DATA 조회
		var sXml =  sheetObj.GetSearchXml("EES_DMT_4003GS.do",	ma_param);
		sheetObj.LoadSearchXml(sXml);
		ComEtcDataToForm(formObj, sheetObj);
		
		//RD 호출
		var rdParm =  " /ruseurlmoniker[0] /rfn [" + RDServerIP + "/EES_DMT_4003_RD.do] "		//DETAIL DATA 조회
					+ " /rv " + rvParmByInvoice(formObj)
					+ " /rpost [jspno=4002&invoice_no="+ComGetObjValue(formObj.dmdt_inv_no)+"&cre_ofc_cd="+ComGetObjValue(formObj2.cre_ofc_cd)+"]"		//jspno, invoice_no
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
					" RD_CUST_REF_PRN_FLG[" + ComGetObjValue(formObj.rd_cust_ref_prn_flg) +"]" +
					" RD_DAYS_DISP[" + ComGetObjValue(formObj.rd_days_disp) +"]" +
					" RD_DMDT_INV_STS_CD[" + ComGetObjValue(formObj.rd_dmdt_inv_sts_cd) +"]" +
					" RD_CRE_CNT_CD[" + ComGetObjValue(formObj.rd_cre_cnt_cd) +"]" 
					;
    	
    	return rvRaram;
    }
  	
  	
  	
     
  	/*
  	 * Customer 공통팝업에서 선택한 Customer Code값을 해당 필드에 설정 
  	 */
    function getCustCd(aryPopupData) {
  		document.form.cust_cd.value = aryPopupData[0][3];
    }    
    
    /*
  	 * Service Provider Inquiry 공통팝업 호출
  	 */
    function getSvcProvdr(aryPopupData) {
  		document.form.svc_provdr.value = aryPopupData[0][2];
    }
  	

    /*
  	 * Customer 공통팝업에서 선택한 Customer Code값을 해당 필드에 설정 
  	 */
    function getPayerCd(aryPopupData) {
    	document.form2.payer_cd.value = aryPopupData[0][3];
    	document.form2.payer_nm.value = aryPopupData[0][4];
    	
    	searchAttentionList();
    }    
    
    /*
  	 * Trucker Cd Inquiry 공통팝업 호출
  	 */
    function getTruckerCd(aryPopupData) {
  		var formObj = document.form2;
  		formObj.trucker_cd.value = aryPopupData[0][2];
  		formObj.trucker_nm.value = aryPopupData[0][4];
    	
    	ComSetObjValue(formObj.vndr_seq, aryPopupData[0][2]);
    }

  	 
    /*
     * 멀티입력 팝업 페이지가 닫힌 후, 호출되는 Opener 함수
     * - 해당 필드에 멀티 입력값을 설정해준다.
     */
    function getDmt_Multi(rArray, return_val) {
    	var targObj = eval("document.form." + return_val);
    	var retStr = rArray.toString().toUpperCase();
    	
    	ComSetObjValue(targObj, retStr);
    }
     

   	/*
  	 * 각 공통팝업창 호출 함수 
  	 */
  	function doProcessPopup(srcName, arg) {
  		
  		var sheetObj = sheetObjects[0];
  		var formObj	= document.form;
  		var formObj2 = document.form2;
  		var sUrl	= '';
  		var paramVal = '';
  		var sWidth	= '';
  		var sHeight	= '';
  		var sScroll = 'no';
  		
  		with(sheetObj) {
	  		switch(srcName) {
		        case 'cust_cd':		// Customer Inquiry Popup
					ComOpenPopup('COM_ENS_041.do', 770, 470, "getCustCd", "1,0,1,1,1,1,1", true);
					return;
					break;
			
				case 'svc_provdr':		// Service Provider Popup
					ComOpenPopup('COM_ENS_0C1.do', 700, 450, "getSvcProvdr", "1,0,1,1,1,1,0", true);
					return;
					break;
	  		
	  			case 'payer_cd':		// Customer Inquiry Popup
//		  			if(ComGetObjValue(formObj2.payer_cd) == "") {
//		  			    ComShowCodeMessage("DMT00182");
//		  			    return;
//		  			}
					ComOpenPopup('COM_ENS_041.do', 770, 470, "getPayerCd", "1,0,1,1,1,1,1", true);
					return;
	  				break;
				
	  			case 'trucker_cd':		// Service Provider Popup
	  				ComOpenPopup('COM_ENS_0C1.do', 700, 450, "getTruckerCd", "1,0,1,1,1,1,0", true);
	  				return;
					break;
					
	  			case 'm_bkg_no':	// BKG No. 멀티입력 팝업 호출
	  			case 'm_bl_no':		// B/L No. 멀티입력 팝업 호출
	  			case 'm_cntr_no':	// CNTR No. 멀티입력 팝업 호출
	  			
		  			var flag = ComReplaceStr(srcName,"m_","");
		  			
			  		// 멀티입력 팝업 타이틀 세부 내용 지정
	  				var returntitle = '';
	  				if(flag == 'bkg_no')
	  					returntitle = 'BKG No.';
	  				else if(flag == 'bl_no')
	  					returntitle = 'B/L No.';
	  				else if(flag == 'cntr_no')
	  					returntitle = 'CNTR No.';
	  				
	  				var param = "?returnval=" + flag + "&returntitle=" + returntitle;
	  				ComOpenPopup('EES_DMT_MULTI.do'+param, 400, 380, 'getDmt_Multi', '1,0,1,1,1,1,1,1,1,1,1,1', true);
	  				return;
	  				break;
             	
	  			case 'btn_ROInfo':
	  				var selRow	= SelectRow;
		  			var bkgNo	= CellValue(selRow , "bkg_no");
		  			paramVal	= "?bkg_no=" + bkgNo;
		  			
	  				sUrl	= 'ESM_BKG_0724.do' + paramVal;
	  				sWidth	= '1000';
              		sHeight	= '450';
	  				break;
	  				
	  			case 'btn_MVMTInq':
	  				var selRow = SelectRow;
	  				var cntrNo = CellValue(selRow , "cntr_no");
	  				var cntrTpszCd = CellValue(selRow , "cntr_tpsz_cd");
	  				paramVal =	"?pop_mode=Y&p_cntrno=" + cntrNo.substring(0,10)
	  							+ "&check_digit=" + cntrNo.substring(10,11)
	  							+ "&ctnr_tpsz_cd=" + cntrTpszCd;
	  				
					sUrl	= 'EES_CTM_0408.do' + paramVal;
					sWidth	= '1020';
					sHeight	= '690';
	  				break;
	  				
	  			case 'btn_ExptInq':
	  				var selRow	= SelectRow;
	  				var scNo	= CellValue(selRow , "sc_no");
	  				var rfaNo	= CellValue(selRow , "rfa_no");
	  				
	  				if(scNo != '' && rfaNo != '') scNo = '';
	  				
	  				paramVal = "?caller=4016&sc_no=" + scNo
	  							+ "&rfa_no=" + rfaNo
	  							+ "&trf_cd=" + comboObjects[0].Code
	  							;

	  				sUrl	= 'EES_DMT_2007_1.do' + paramVal;
	  				sWidth	= '1024';
              		sHeight	= '780';
              		sScroll = 'yes';
	  				break;
	  				
	  			case "btn_SheetSet":
	  				paramVal = "?issoff=" + ComGetObjValue(formObj2.session_ofc_cd)
  								+ "&tftp2=" + ComGetObjValue(formObj2.dmdt_trf_cd)
  								+ "&sheetp=I"
  								+ "&invoice_issue=" + ComGetObjValue(formObj2.invoice_issue)
  								+ "&jspno=EES_DMT_4016-1";
	  				
	  				sUrl	= 'EES_DMT_4101.do' + paramVal;
              		sWidth	= '725';
              		sHeight	= '780';
              		
              		ComOpenWindowCenter(sUrl, 'EES_DMT_4101', sWidth, sHeight, true, 'yes');
              		//Sheet Set 있는지 없는지 재조회한다.
    				doActionIBCommon(sheetObjects[5], formObj2, IBSEARCH, COMMAND13);
    				return;
	  				break;
	  				
 				case "btn_SheetOpt":
 					paramVal = "?issoff=" + ComGetObjValue(formObj2.session_ofc_cd)
								+ "&tftp=" + ComGetObjValue(formObj2.dmdt_trf_cd)
								+ "&invoice_issue=" + ComGetObjValue(formObj2.invoice_issue)
								+ "&jspno=EES_DMT_4016-1";
 					
 					sUrl	= 'EES_DMT_4103.do' + paramVal;
              		sWidth	= '625';
              		sHeight	= '650';
	  				break;
	  				
 				case "btn_SendingHistory":
 					paramVal = "?jspno=EES_DMT_4016-1"
								+ "&invoice=" + ComGetObjValue(formObj2.dmdt_inv_no)
								+ "&selectOpt=1";
 					
 					sUrl	= 'EES_DMT_7006_P.do' + paramVal;
              		sWidth	= '1020';
              		sHeight	= '690';
              		break;
	  				
 				case "btn_Cancel":
 					var creOfcCd = ComGetObjValue(formObj2.cre_ofc_cd);
 					
 					if(ComGetObjValue(formObj2.session_ofc_cd) == creOfcCd) {
 						if(ComShowCodeConfirm('DMT03025')) {
 							var sUrl = "EES_DMT_4106.do"
	 								+ "?dmdt_inv_no=" + ComGetObjValue(formObj2.dmdt_inv_no)
	 								+ "&cre_ofc_cd=" + creOfcCd
	 								+ "&dmdt_trf_cd=" + ComGetObjValue(formObj2.dmdt_trf_cd);
 								
 							var returnValue = ComOpenWindowCenter(sUrl, "EES_DMT_4106", "420", "450", true);
 							if(returnValue == "Y"){
 								doActionIBSheet(sheetObjects[3], formObj2, IBSEARCH_MBILL);
 							}
 						}
 					}else{
 						ComShowCodeMessage('DMT03024', creOfcCd, ComGetObjValue(formObj2.session_ofc_cd));
 					}
 					return;
 					break;
	  				
 				case "btn_Preview":
 					var temp_LR = ComGetObjValue(formObj2.bil_to_loc_div_cd);
 					var invoice_LR = "";
 					if(temp_LR == "") {
 						invoice_LR = "L";
 					}else if(temp_LR == "L") {
 						invoice_LR = "L";
 					}else if(temp_LR == "R") {
 						invoice_LR = "R";
 					}

					paramVal =	"?jspno=4016"
								+"&payr_cntc_pnt_phn_no="	+ ComGetObjValue(formObj2.org_payr_cntc_pnt_phn_no)
								+"&payr_cntc_pnt_fax_no="	+ ComGetObjValue(formObj2.org_payr_cntc_pnt_fax_no)
								+"&payr_cntc_pnt_eml="		+ ComGetObjValue(formObj2.org_payr_cntc_pnt_eml)
								//+"&dmdt_payr_cntc_pnt_nm="	+ ComGetObjValue(formObj2.org_dmdt_payr_cntc_pnt_nm)
								+"&invoice_no="	+ ComGetObjValue(formObj2.dmdt_inv_no)
								+"&invoice_LR="	+ invoice_LR
								+"&cre_ofc_cd="	+ ComGetObjValue(formObj2.cre_ofc_cd)
								+"&payer_cd="	+ ComGetObjValue(formObj2.payer_cd)
								+"&bkg_no="		+ ComGetObjValue(formObj2.s_bkg_no)
								+"&pod_cd="		+ ComGetObjValue(formObj2.pod_cd)
								+"&bl_no="		+ ComGetObjValue(formObj2.bl_no)
								+"&dmdt_trf_cd="+ ComGetObjValue(formObj2.dmdt_trf_cd)
								;
					
					sUrl	= 'EES_DMT_4003.do' + paramVal;
              		sWidth	= '950';
              		sHeight	= '735';
              		break;

 				case "btn_PayerInfo":
 					if(ComGetObjValue(formObj2.payer_cd) == null || ComGetObjValue(formObj2.payer_cd) == "") {
 						ComShowCodeMessage("DMT00182");
 						return;
 					}
 					
 					var ofcCd = '';
 					if(ComGetObjValue(formObj2.invoice_issue) == "1")
 						ofcCd = ComGetObjValue(formObj2.session_ofc_cd);
 					else	//ComGetObjValue(formObj.invoice_issue) == "2"
 						ofcCd = ComGetObjValue(formObj2.cre_ofc_cd);

 					paramVal =	"?s_ofc_cd="	+ ofcCd
		 						+ "&s_cust_cd="	+ ComGetObjValue(formObj2.payer_cd)
		 						+ "&s_bkg_no="	+ ComGetObjValue(formObj2.s_bkg_no)
		 						+ "&s_pod_cd="	+ ComGetObjValue(formObj2.pod_cd)
		 						+ "&jspno=EES_DMT_4016-1"
		 						+ "&attn="		+ ComGetObjValue(formObj2.dmdt_payr_cntc_pnt_nm)
		 						+ "&telno="		+ ComGetObjValue(formObj2.payr_cntc_pnt_phn_no)
		 						+ "&faxno="		+ ComGetObjValue(formObj2.payr_cntc_pnt_fax_no)
		 						+ "&email="		+ ComGetObjValue(formObj2.payr_cntc_pnt_eml)
		 						;
 					
 					sUrl	= 'EES_DMT_4104.do' + paramVal;
              		sWidth	= '825';
              		sHeight	= '620';
 					break;
 				case "btn_FaxSend":
					if(ComGetObjValue(formObj2.payer_cd) == null || ComGetObjValue(formObj2.payer_cd) == "") {
						ComShowCodeMessage("DMT00182");
						return;
					}
					var ofc_cd = "";
					if(ComGetObjValue(formObj2.invoice_issue) == "1") {
						return;
					}else{	//ComGetObjValue(formObj2.invoice_issue) == "2"
						ofc_cd = ComGetObjValue(formObj2.cre_ofc_cd);
					}

					sUrl = "EES_DMT_4107.do"
						+"?s_ofc_cd="+ofc_cd
						+"&s_cust_cd="+ComGetObjValue(formObj2.payer_cd)
						+"&s_bkg_no="+ComGetObjValue(formObj2.s_bkg_no)
						+"&s_pod_cd="+ComGetObjValue(formObj2.pod_cd)
						+"&jspno=4016"
						+"&telno="+ComGetObjValue(formObj2.payr_cntc_pnt_phn_no)
						+"&faxno="+ComGetObjValue(formObj2.payr_cntc_pnt_fax_no)
						+"&email="+ComGetObjValue(formObj2.payr_cntc_pnt_eml)
						+"&cntc_seq="+ComGetObjValue(formObj2.cust_cntc_pnt_seq)
						;
					sWidth	= "500";
		  			sHeight	= "300";					
					break;
 				case "btn_EmailSend":
					if(ComGetObjValue(formObj2.payer_cd) == null || ComGetObjValue(formObj2.payer_cd) == "") {
						ComShowCodeMessage("DMT00182");
						return;
					}
					var ofc_cd = "";
					if(ComGetObjValue(formObj2.invoice_issue) == "1") {
						return;
					}else{	//ComGetObjValue(formObj2.invoice_issue) == "2"
						ofc_cd = ComGetObjValue(formObj2.cre_ofc_cd);
					}

					sUrl = "EES_DMT_4108.do"
						+"?s_ofc_cd="+ofc_cd
						+"&s_cust_cd="+ComGetObjValue(formObj2.payer_cd)
						+"&s_bkg_no="+ComGetObjValue(formObj2.s_bkg_no)
						+"&s_pod_cd="+ComGetObjValue(formObj2.pod_cd)
						+"&jspno=4016"
						+"&telno="+ComGetObjValue(formObj2.payr_cntc_pnt_phn_no)
						+"&faxno="+ComGetObjValue(formObj2.payr_cntc_pnt_fax_no)
						+"&email="+ComGetObjValue(formObj2.payr_cntc_pnt_eml)
						+"&cntc_seq="+ComGetObjValue(formObj2.cust_cntc_pnt_seq)
						;
					sWidth	= "500";
		  			sHeight	= "300";					
					break;					
	  				
	  		} // switch-end
  		} // with-end
  		
  		if(sUrl != '') {
  			var sWinName = sUrl.substring(0, sUrl.indexOf('.do'));
			var returnValue = ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true, sScroll);
  		}
  	}
	
  	 
  	/**
 	 * SheetOption 팝업화면에서 변경시 자동변경 처리하는 로직임(Due Date, Credit Term, Tax Rate)
 	 */
 	function getSheetOptionData(cr_term_dys, is_dt_prn_flg, tax_rto) {
 		var formObj = document.form2;
 		
 		var d_is_dt_prn_flg = "";
		
		if(cr_term_dys == "0" && is_dt_prn_flg == "2") {
			d_is_dt_prn_flg = "N";
		} else{
			d_is_dt_prn_flg = "Y";
		}
 		
 		
 		if(cr_term_dys != null && cr_term_dys != ""){
 			//Invoice Issue 이전
 			if(ComGetObjValue(formObj.invoice_issue) == "1") {
 				if(cr_term_dys == "0") {
 					if(is_dt_prn_flg == "Y"){
 						//현재일자
 						ComSetObjValue(formObj.due_date, ComGetObjValue(formObj.ofc_curr_date));
 						//날짜 하이픈 처리
 						ComSetObjValue(formObj.due_date, ComGetMaskedValue(formObj.due_date.value, "ymd"));
 						//0
 						ComSetObjValue(formObj.cr_term_dys, "0");
 						
 					}else if(is_dt_prn_flg == "N") {
 						ComSetObjValue(formObj.due_date, "********");
 						ComSetObjValue(formObj.cr_term_dys, "");
 					}
 				}else if(parseInt(cr_term_dys) > 0){
 					//현재일자
 					ComSetObjValue(formObj.due_date, ComGetObjValue(formObj.ofc_curr_date));
 					//날짜 하이픈 처리
 					ComSetObjValue(formObj.due_date, ComGetMaskedValue(formObj.due_date.value, "ymd"));
 					ComSetObjValue(formObj.cr_term_dys, cr_term_dys);
 				}
 			//Invoice Issue 이후
 			}else if(ComGetObjValue(formObj.invoice_issue) == "2") {
 				if(cr_term_dys == "0") {
 					if(is_dt_prn_flg == "Y"){
 						//Invoice 일자
 						ComSetObjValue(formObj.due_date, ComGetObjValue(formObj.cre_dt));
 						//0
 						ComSetObjValue(formObj.cr_term_dys, "0");
 						
 					}else if(is_dt_prn_flg == "N") {
 						ComSetObjValue(formObj.due_date, "********");
 						ComSetObjValue(formObj.cr_term_dys, "");
 					}
 				}else{
 					//Invoice 일자 + cr_term_dys
 					var cal_due_date = ComGetDateAdd(ComGetObjValue(formObj.cre_dt), "D", parseInt(cr_term_dys)); 
 					ComSetObjValue(formObj.due_date, cal_due_date);
 					ComSetObjValue(formObj.cr_term_dys, cr_term_dys);
 				}
 			}
 		}
 		
 		if(tax_rto == null || tax_rto == "") {
 			tax_rto = "0";
 		}
 		
 		//tax_rto
 		ComSetObjValue(formObj.tax_rto, tax_rto);
 		
 		if(formObj.chk_tax.checked) {
 			ComSetObjValue(formObj.tax_rto_dis, ComGetObjValue(formObj.tax_rto));
 			//tax calculate
 			getExRate();
 			setComma();
 		}
 		
 		//searchSeetOption
 		doActionIBCommon(sheetObjects[5], formObj, IBSEARCH, COMMAND14);
 	}
 	 
 	 
	/**
 	 * PayerInfo 팝업화면에서 변경시 자동변경 처리됨
 	 */
	function getPayerInfoData(fax_nos, email_nos, cntc_pnt_nm, cntc_pnt_seq){
 		var formObj = document.form2;
 		ComSetObjValue(formObj.payr_faxnos, 			fax_nos);
 		ComSetObjValue(formObj.payr_emailnos, 			email_nos);
 		ComSetObjValue(formObj.dmdt_payr_cntc_pnt_nm, 	cntc_pnt_nm);
 		ComSetObjValue(formObj.cust_cntc_pnt_seq, 		cntc_pnt_seq);
 		
 		//alert('getPayerInfoData');
 		searchAttentionList();

 		var setCode = ComGetObjValue(formObj.cust_cnt_cd)+"^"+ComGetObjValue(formObj.cust_cntc_pnt_seq)+"^"+ComParseInt(ComGetObjValue(formObj.cust_seq));
 		
 		//setting
 		if(ComGetObjValue(formObj.payer_cd) == "") {
 			comboObjects[2].Code = -1;
 			ComSetObjValue(formObj.payr_cntc_pnt_phn_no, "");
 			ComSetObjValue(formObj.payr_cntc_pnt_fax_no, "");
 			ComSetObjValue(formObj.payr_cntc_pnt_eml, "");
 			ComSetObjValue(formObj.cust_cntc_pnt_seq, "");
 		}else{
 			//Attention Setting
 			comboObjects[2].Code = setCode;
 			if(comboObjects[2].Code == ""){
 				ComSetObjValue(formObj.payr_cntc_pnt_phn_no, "");
 				ComSetObjValue(formObj.payr_cntc_pnt_fax_no, "");
 				ComSetObjValue(formObj.payr_cntc_pnt_eml, "");
 				ComSetObjValue(formObj.cust_cntc_pnt_seq, "");
 			}
 		}
 		
 	}
  	 

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	  
    	  with(formObj){
    		  
        	 switch(sAction) {
        	 	case IBSEARCH:      //조회
	        	 	ComSetObjValue(fm_mvmt_yd_cd, '');
	         		ComSetObjValue(to_mvmt_yd_cd, '');
	         		
	         		var condType = ComGetObjValue(cond_type);
	         		
	         		//******************** Date 조건  ************************
	         		if(condType == 'date') {
	         			
	         			if(!ComIsDate(fm_mvmt_dt1)) {
	         				ComAlertFocus(fm_mvmt_dt1, ComGetMsg('COM12134', 'Period From Date'));
	         				return false;
	         			}
	         			if(!ComIsDate(to_mvmt_dt1)) {
	         				ComAlertFocus(to_mvmt_dt1, ComGetMsg('COM12134', 'Period To Date'));
	         				return false;
	         			}
	         			
	         			var startDt = ComGetUnMaskedValue(fm_mvmt_dt1, 'ymd');
	         			var endDt = ComGetUnMaskedValue(to_mvmt_dt1, 'ymd');
	         			
                        // 기간체크
                        if (ComChkPeriod(startDt, endDt) == 0) {
                        	ComShowCodeMessage("DMT01020");
                        	return false;
                        }
                        
                        // 기간이 1달 이내 여부인지 체크
                        var limitDt = ComGetDateAdd(startDt, "M", 1);
                        if (ComChkPeriod(endDt, limitDt) == 0) {
                        	ComShowCodeMessage("DMT00162", "1 month");
                        	return false;
                        }
	                    
	                    ComSetObjValue(fm_mvmt_dt, startDt);
	                    ComSetObjValue(to_mvmt_dt, endDt);
	                    
	                    var yardCd = ComGetObjValue(yd_cd);
	                    
	                    // YardCode를 입력했는지
	                    if((yardCd != '' && yardCd.length < 5) || (yardCd.length == 5 && ComGetObjValue(chk_yd_cd) == "N")) {
	                    	ComShowCodeMessage('DMT00110', 'Yard');
	                    	ComClearObject(yd_cd);
	    					return false;
	    					
	    	       		} else if(yardCd.length == 5) {
	    	       			var yardFmto = ComGetObjValue(yard_fmto);
	         				if(yardFmto == 'yard_fm') {
	         					ComSetObjValue(fm_mvmt_yd_cd, yardCd);
	         					ComSetObjValue(to_mvmt_yd_cd, '');
	         				} else {
	         					ComSetObjValue(fm_mvmt_yd_cd, '');
	         					ComSetObjValue(to_mvmt_yd_cd, yardCd);
	         				}
	    	       		}
	         			
	         			var yardCd2 = ComGetObjValue(comboObjects[1]);
	         			// YardCode를 선택했는지
	         			if(yardCd2 != '') {
	         				var yardFmto = ComGetObjValue(yard_fmto);
	         				if(yardFmto == 'yard_fm') {
	         					ComSetObjValue(fm_mvmt_yd_cd, yardCd2);
	         					ComSetObjValue(to_mvmt_yd_cd, '');
	         				} else {
	         					ComSetObjValue(fm_mvmt_yd_cd, '');
	         					ComSetObjValue(to_mvmt_yd_cd, yardCd2);
	         				}
	         			}
	         			
	         		//******************** VVD CD 조건  ************************
	         		} else if(condType == 'vvd_cd') {
	         			if( ComChkLen(vvd_cd, 9) != 2) {	// 9자리가 아니면
	         				//ComShowCodeMessage('DMT00102', "VVD CD");
	         				ComAlertFocus(vvd_cd, ComGetMsg('DMT00119', 'VVD CD', '9'));
	     					return false;
	         			}
	         			
	         			ComSetObjValue(pod_cd, "");
	         			ComSetObjValue(pol_cd, "");
	         			var tmnlCd = ComGetObjValue(tmnl_cd);
	         			
	         			if(tmnlCd != '') {
	         				if( tmnlCd.length < 5 || tmnlCd.length == 5 && ComGetObjValue(chk_loc_cd) == "N" ) {	
	         					//ComAlertFocus(tmnl_cd, ComGetMsg('DMT00110', 'Location'));
	         					ComShowCodeMessage('DMT00110', 'Location');
	         					ComClearObject(tmnl_cd);
	        	       			return false;
	         				}
	         				
	         				var trf_cd = comboObjects[1].Code;
	         				if(trf_cd.indexOf('I') != -1)	// Inbound
	         					ComSetObjValue(pod_cd, tmnlCd);
	         				
	         				if(trf_cd.indexOf('O') != -1)	// Outbound
	         					ComSetObjValue(pol_cd, tmnlCd);
	         			}
	         			
	         		//******************** CNTR 조건  ************************	
	         		} else {
	     				if(ComIsNull(bkg_no) && ComIsNull(bl_no) && ComIsNull(cntr_no)) {
	         				ComShowCodeMessage('DMT00102', 'BKG No. or B/L No. or CNTR No.');
	             			return false;
	     				}
	         			
	         			var bkgNo = ComGetObjValue(bkg_no);
	         			if(bkgNo != '') {
	         				var arrBkgNo = bkgNo.split(',');
	         				for(var i=0; i<arrBkgNo.length; i++) {
	         					if(ComChkLen(arrBkgNo[i], 11) != 2 && ComChkLen(arrBkgNo[i], 12) != 2 && ComChkLen(arrBkgNo[i], 13) != 2) {
	         						ComAlertFocus(bkg_no, ComGetMsg('DMT00119', 'BKG No.', '11~13'));
		                 			return false;
	         					}
	         				}
	         			}
	         			
	         			var blNo = ComGetObjValue(bl_no);
	         			if(blNo != '') {
	         				var arrBlNo = blNo.split(',');
	         				for(var i=0; i<arrBlNo.length; i++) {
	         					if(ComChkLen(arrBlNo[i], 10) != 2 && ComChkLen(arrBlNo[i], 12) != 2) {
	         						ComAlertFocus(bl_no, ComGetMsg('COM12175', 'B/L No.', '10', '12'));
		                 			return false;
	         					}
	         				}
	         			}
	         			
	         			var cntrNo = ComGetObjValue(cntr_no);
	         			if(cntrNo != '') {
	         				var arrCntrNo = cntrNo.split(',');
	         				for(var i=0; i<arrCntrNo.length; i++) {
	         					if(ComChkLen(arrCntrNo[i], 14) == 0) {	// 길이 초과
	         						ComAlertFocus(cntr_no, ComGetMsg('COM12173', 'CNTR No.', '14'));
		                 			return false;
	         					}
	         				}
	         			}
	         		}
	             	
	         		if(svc_provdr.value != '') {
	         			if(!ComIsNumber(svc_provdr)) {
	         				ComAlertFocus(svc_provdr, ComGetMsg('COM12122', 'Service Provider'));
	         				return false;
	         			}
	         			if(ComChkLen(svc_provdr, 6) != 2) {
	     					ComAlertFocus(svc_provdr, ComGetMsg('DMT00120', 'Service Provider', '6'));
	     					return false;
	     				}
	         		}
	         		
	         		// Tariff Type IBMultiCombo 선택 코드값을  Hidden 변수에 세팅
	         		ComSetObjValue(dmdt_trf_cd, comboObjects[0].Code);
	         		break;
	         		
        	 	case IBGETTOMVMT:
        	 		if(sheetObj.CheckedRows("chk") == 0) {
        	  			ComShowCodeMessage('COM12113', 'CNTR');
        	  			return false;
        			}
        	 		
        	 		var chkRows = sheetObj.FindCheckedRow("chk").split("|");
             		for(var i=0; i < chkRows.length-1; i++) {
             			var chkRow = chkRows[i];
             			
             			if(sheetObj.CellValue(chkRow, "get_flg") == 'Y') {
             				if(ComShowCodeConfirm('DMT03051')) 
             					break;
             				else
             					return false;
             			}
             		}
        	  		
        	 		// Hidden Sheet
        	 		var sheetObj2 = sheetObjects[1];
        	 		
        	 		//sheet1의 "chk" 컬럼이 체크된 데이터를 조회XML로 만들기
        	 		var sXml = ComMakeSearchXml(sheetObj, false, "chk", "seq|cntr_no|bkg_no");
        	 		
        	 		sheetObj2.RemoveAll();
        	 		//sheet2로 조회XML 로드하기
        	 		sheetObj2.LoadSearchXml(sXml, true);
	    	 		break;
	    	 		
        	 	case IBCALCULATE:
        	 		if(sheetObj.CheckedRows("chk") == 0) {
        	  			ComShowCodeMessage('COM12113', 'CNTR');
        	  			return false;
        			}
        	 		
        	 		var chkRows = sheetObj.FindCheckedRow("chk").split("|");
             		for(var i=0; i < chkRows.length-1; i++) {
             			var chkRow = chkRows[i];
             			
             			if(sheetObj.CellValue(chkRow, "get_flg") == '') {
             				ComShowCodeMessage('DMT03053');
         					sheetObj.SelectRow = chkRow;
         					return false;
             			}
             			
             			if(sheetObj.CellValue(chkRow, "dmdt_trf_cd") == '') {
             				ComShowCodeMessage('DMT03028', 'To MVMT');
         					sheetObj.SelectRow = chkRow;
         					return false;
             			}
             			
             			/*
             			var toMvmtYdCd = sheetObj.CellValue(chkRow, "to_mvmt_yd_cd");
             			var toMvmtStsCd = sheetObj.CellValue(chkRow, "to_mvmt_sts_cd");
             			var toMvmtDt = sheetObj.CellValue(chkRow, "to_mvmt_dt");
             			*/
             			if(sheetObj.CellValue(chkRow, "dmdt_chg_sts_cd") == 'I') {
             				ComShowCodeMessage('DMT01068', 'calculate');
         					sheetObj.SelectRow = chkRow;
         					return false;
             			}
             		}
             		
             		for(var i=0; i < chkRows.length-1; i++) {
             			var chkRow = chkRows[i];
             			if(sheetObj.CellValue(chkRow, "cal_flg") == 'Y') {
             				if(ComShowCodeConfirm('DMT03052')) 
             					break;
             				else
             					return false;
             			}
             		}
        	 		
        	 		// Hidden Sheet
        	 		var sheetObj2 = sheetObjects[2];
        	 		
        	 		//sheet1의 "chk" 컬럼이 체크된 데이터를 조회XML로 만들기
        	 		var sXml = ComMakeSearchXml(sheetObj, false, "chk", "seq|svr_id|cntr_no|cntr_cyc_no|dmdt_trf_cd|dmdt_chg_loc_div_cd|chg_seq|cntr_tpsz_cd|bkg_no|vvd_cd|to_mvmt_dt|to_mvmt_sts_cd|to_mvmt_yd_cd|to_mvmt_yr|to_mvmt_seq|to_mvmt_split_no|dmdt_chg_sts_cd|fm_mvmt_dt");
        	 		
        	 		sheetObj2.RemoveAll();
        	 		//sheet2로 조회XML 로드하기
        	 		sheetObj2.LoadSearchXml(sXml, true);
        	 		break;
        	 		
        	 	case IBCONFIRM:		// Confirm
	         		if(sheetObj.CheckedRows("chk") == 0) {
	         			ComShowCodeMessage('COM12114', 'CNTR for Confirm');
	         			return false;
	         		}
	         		
	         		var chkRows = sheetObj.FindCheckedRow("chk").split("|");
	         		for(var i=0; i < chkRows.length-1; i++) {
	         			var chgStsCd = sheetObj.CellValue(chkRows[i], "dmdt_chg_sts_cd");
	     				if(chgStsCd != 'F') {
	     					ComShowCodeMessage('DMT03018');
	     					sheetObj.SelectRow = chkRows[i];
	     					return false;
	     				}
	         		}
	         		break;	
        	 		
        	 	case IBSAVE:
        	 		if(ComGetObjValue(payer_cd) == "") {
    					ComAlertFocus(payer_cd, ComGetMsg("DMT01052"));
						return false;
    				}
    				
    				//AR-IF 된 상태의 INVOICE는 수정하지 못하고 메시지 처리를 함.
    				if(ComGetObjValue(formObj.dmdt_ar_if_cd) == "Y") {
    					ComShowCodeMessage("DMT03022");
    					return false;
    				}
        	 		
    				// 미주지역만 Service Provider 입력 가능('CA','US')
    				/*if(ComGetObjValue(session_cnt_cd) == "CA" || ComGetObjValue(session_cnt_cd) == "US") {
    					if(ComGetObjValue(payer_cd).length < 6) {
    						ComAlertFocus(payer_cd, ComGetMsg('COM12143', "Payer", "6"));
    						return false;
    					}
    				}else{
    					if(ComGetObjValue(payer_cd).length < 8) {
    						ComAlertFocus(payer_cd, ComGetMsg('COM12143', "Payer", "6"));
    						return false;
    					}
    				}*/
        	 		break;
        	 		
        	 	case IBARIF:
        	 		var sessionCntCd = ComGetObjValue(session_cnt_cd);
        	 		if( sessionCntCd != "US" && sessionCntCd != "CA" ) {
        	 			if(ComGetObjValue(payer_cd).length <= 6) {
        	 				ComShowCodeMessage("DMT00185");
        	 				return false;
        	 			}
	 		        }
        	 		
        	 		if(!ComShowCodeConfirm('DMT03026'))
        	 			return false;
        	 		
        	 		break;
        	 		
        	 } // swith - end
    	  } // with - end
    	  
    	  return true;
     }
         

 	 /**
      * Tab 기본 설정
      * 탭의 항목을 설정한다.
      */
     function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                 with (tabObj) {
                     var cnt  = 0 ;
                     InsertTab( cnt++ , "DEM Cal." , -1 );
                     InsertTab( cnt++ , "Manual Billing" , -1 );
                 }
                 break;

         }
     }

 	 /**
      * Tab 클릭시 이벤트 관련
      * 선택한 탭의 요소가 활성화 된다.
      */
     function tab1_OnChange(tabObj , nItem)
     {

         var objs = document.all.item("tabLayer");

         objs[nItem].style.display = "Inline";
         objs[beforetab].style.display = "none";

         //--------------- 요기가 중요 --------------------------//
         objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
         //------------------------------------------------------//
         beforetab= nItem;
     }
    
   /**
  	* Billable AMT 를 계산하는 함수
  	*/	 
  	function calcBillableAmount() {
  		var formObj = document.form2;
  		var sheetCHGObj = sheetObjects[3];
  		var sheetRTObj = sheetObjects[4];
  		var billableAmt = 0;

  		with(sheetCHGObj) {
  			for (var row = HeaderRows ; row <= LastRow ; row++) {
  				var dtlSeq 	= CellValue(row, "rt_dtl_grp");
  			
  				for (var subRow = sheetRTObj.HeaderRows ; subRow <= sheetRTObj.LastRow ; subRow++) {
  					if (	dtlSeq 	== sheetRTObj.CellValue(subRow, "rt_cur_cd")) {		

  						billableAmt += parseFloat(sheetRTObj.CellValue(subRow, "rt_chrg"));
  					}
  				}
  			}
  		}
  		
  		billableAmt = billableAmt + "";
  		ComSetObjValue(formObj.mn_bil_amt, setDataFormat(billableAmt, "AMT"));
  			
  	}      
  	
    /**
     * Charge Currency 가 변경될 경우 수행해야될 동작을 정의하는 함수 
     */
   function setDataFormat(sVal, sType) {

   	if (sVal == undefined || sVal == "null" || sVal.length == 0) return "";

   	if (sType != undefined) {
   		switch(sType) {
   			case "AMT":
   				sVal = ComAddComma2(sVal + "", "#,###.00");
   				break;
   				
   			case "EX_RATE":
   				sVal = parseFloat(sVal).toFixed(6);
   				break;
   		}
   	}
   	return sVal;
   }


	/* 개발자 작업  끝 */