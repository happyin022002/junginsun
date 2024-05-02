/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_FMS_0021.js
*@FileTitle : Payments Slip
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.08.20 정윤태
* 1.0 Creation
* 
* 2010.11.24 이상민 [CHM-201007233-01] 수정 및 추가 
* vessel code 입력시 keypress : eng_keypress -> engnum_keypress
*   
* -----------------------------------------------------------
* 2012.02.14 조병연 [CHM-201216090-01] 수정 
* 세금 계산서 기능보안
* 세금계산서 처리에서 영세 부분도 과세와 동일하게 처리.
* 
* -----------------------------------------------------------
* 2012.05.29 전상화 [CHM-CHM-201218108-01] 수정 
* Slip Type에서 'Prepayment Bunker' 추가
* -----------------------------------------------------------
*   
* 2012.06.19 전상화 [CHM-201218327] 수정 
* 세금 계산서 기능보안
* Payment Slip 에서 '영세 Tax Evidence' 를 선택했을 때,  발생하는 오류 수정
*
* 2012.08.24 김상근 [CHM-201219775-01] 수정 
* O/A 추가 및 영세 세금계산서 기능 보완
* Payments Slip 화면 Owner's account 추가 및 영세 세금계산서 데이터 생성시 오류 발생에 대한 처리 

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
     * @class ESM_FMS_0021 : ESM_FMS_0021 Payments Slip 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_FMS_0021() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.sheet1_OnLoadFinish	= sheet1_OnLoadFinish;
    	this.initSheet 				= initSheet;
    	this.initControl        	= initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
        this.eng_keypress			= eng_keypress;
        this.vsl_cd_change			= vsl_cd_change;
        this.obj_deactivate			= obj_deactivate;
        this.obj_activate			= obj_activate;
        this.obj_keypress			= obj_keypress;
        this.setVslCd				= setVslCd;
        this.eff_dt_change			= eff_dt_change;
        this.slp_tp_click			= slp_tp_click;
        this.setPrepayments			= setPrepayments;
        this.setCharterersExp		= setCharterersExp;
        this.setOffhireExp			= setOffhireExp;
        this.setOwnersAccountStd		= setOwnersAccountStd;
        this.setBodBor				= setBodBor;
        this.setButton				= setButton;
        this.preWorkCheck			= preWorkCheck;
        this.initConfirm			= initConfirm;
        this.saveReadOnly			= saveReadOnly;
        this.setEffectiveDate		= setEffectiveDate;
        this.setCsrDate				= setCsrDate;
        this.formReset				= formReset;
        this.initCheckBox			= initCheckBox;
        this.rowRemove				= rowRemove;
        this.setCsrHeadInfomation 	= setCsrHeadInfomation;
        this.sheet1_OnChange		= sheet1_OnChange;
        this.checkAccountCode       = checkAccountCode;
        this.sheet1_OnClick			= sheet1_OnClick;
        this.sheet1_OnSaveEnd 		= sheet1_OnSaveEnd;
        this.sheet1_OnValidation	= sheet1_OnValidation;
        this.saveConfirm			= saveConfirm;
        this.setTotalAmount			= setTotalAmount;
        this.checkKeyNumber			= checkKeyNumber;
        this.setMakeTaxEvidence		= setMakeTaxEvidence;
        this.setMakeSlipMstData		= setMakeSlipMstData;
        this.checkAcctCdVvdLevel	= checkAcctCdVvdLevel;
        this.checkAcctCdVvdLevelMdt = checkAcctCdVvdLevelMdt;
        this.setEvidenceType		= setEvidenceType;
        this.setInitVatApply		= setInitVatApply;
        this.checkBalance			= checkBalance;
        this.setCellFont			= setCellFont;
        this.sheet1_OnSearchEnd 	= sheet1_OnSearchEnd;
        this.initRdConfig			= initRdConfig;
        this.rdOpen					= rdOpen;
        this.setHireStatementStd		= setHireStatementStd;
    }
    
	// 공통전역변수
	
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	//2017.05.15 contract type 콤보로 변경
	var comboObjects = new Array();
    var comboCnt = 0;
    
	var rdObjects = new Array();
    var rdCnt = 0;
    var ar_olay_amt = 0;
    var ar_olay_rt_amt = 0;
    var ar_csr_no = "";  // 20T 전표
    
    // 이전에 입력한 Effective Date(같은 값 입력시 서버호출 방지하기 위하여 사용함)
    var pre_eff_dt = "";
    
    // OA, COMM  AR 전표
    var cust_cnt_cd  = "";
    var cust_seq     = "";
	
    
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	    	
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         var sheetObject1 = sheetObjects[1];
         var sheetObject2 = sheetObjects[2];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

	        	case "btn_prepayments":
	        		if(validateForm(sheetObject,formObject,IBSEARCH,'N') == false) return;
	        		
	        		if(sheetObject.rowCount != 0) {
	        			formObject.ppay_hir_no.value = "";
	        			sheetObject.RemoveAll();
	        		}
	        		
	        		setTotalAmount('S');
	        		
	        		var flet_ctrt_no = formObject.flet_ctrt_no.value;
	        		var csr_curr_cd = formObject.csr_curr_cd.value;
	        		
	        		ComOpenPopup("ESM_FMS_0024.do?flet_ctrt_no="+flet_ctrt_no+"&csr_curr_cd="+csr_curr_cd, 900, 378, "setPrepayments", "1,0,1,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0024");
					break;

	        	case "btn_charterersExp":
	        		if(validateForm(sheetObject,formObject,IBSEARCH,'N') == false) return;
	        		
	        		if(!preWorkCheck()) return; 
	        		
	        		initCheckBox(sheetObject);
	        		
	        		for (var ir=sheetObject.LastRow; ir>=sheetObject.HeaderRows; ir--) {
	        			if(sheetObject.CellValue(ir,"pop_gb") == "CHT") {
	        				sheetObject.CellValue2(ir,"DelChk") = 1;
	        				rowRemove(sheetObject, "");
	        			}
	        		}
	        		
	        		setTotalAmount('S');
	        		
	        		var flet_ctrt_no = formObject.flet_ctrt_no.value;
	        		var csr_curr_cd = formObject.csr_curr_cd.value;
	        		
	        		ComOpenPopup("ESM_FMS_0025.do?flet_ctrt_no="+flet_ctrt_no+"&csr_curr_cd="+csr_curr_cd, 900, 378, "setCharterersExp", "1,0,1,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0025");
	        		
					break;
						
	        	case "btn_offhireExp":
	        		if(validateForm(sheetObject,formObject,IBSEARCH,'N') == false) return;
	        		
	        		if(!preWorkCheck()) return; 
	        		
	        		initCheckBox(sheetObject);
	        		
	        		for (var ir=sheetObject.LastRow; ir>=sheetObject.HeaderRows; ir--) {
	        			if(sheetObject.CellValue(ir,"pop_gb") == "OFF") {
	        				sheetObject.CellValue2(ir,"DelChk") = 1;
	        				rowRemove(sheetObject, "");
	        			}
	        		}
	        		
	        		setTotalAmount('S');
	        		
	        		var flet_ctrt_no = formObject.flet_ctrt_no.value;
	        		var csr_curr_cd = formObject.csr_curr_cd.value;
	        		
	        		ComOpenPopup("ESM_FMS_0026.do?flet_ctrt_no="+flet_ctrt_no+"&csr_curr_cd="+csr_curr_cd, 900, 378, "setOffhireExp", "1,0,1,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0026");
	        		
	        		break;
				
	        	case "btn_ownersAccount":
	        		if(validateForm(sheetObject,formObject,IBSEARCH,'N') == false) return;
	        		
	        		if(!preWorkCheck()) return; 
	        		
	        		initCheckBox(sheetObject);
	        		
	        		for (var ir=sheetObject.LastRow; ir>=sheetObject.HeaderRows; ir--) {
	        			if(sheetObject.CellValue(ir,"pop_gb") == "OWN") {
	        				sheetObject.CellValue2(ir,"DelChk") = 1;
	        				rowRemove(sheetObject, "");
	        			}
	        		}
	        		
	        		sheetObjects[4].RemoveAll();//본 버튼을 누를 때 마다 이전 선택한 데이터와 해당 그리드 데이터도 함께 날려줘야함.
	        		
	        		setTotalAmount('S');
	        		
	        		var flet_ctrt_no = formObject.flet_ctrt_no.value;
	        		var csr_curr_cd = formObject.csr_curr_cd.value;
	        		var slp_tp = "";
	        		
	        		if(form.slp_tp[0].checked){
	        			slp_tp = "P";		// Prepayment
	        		}else if(form.slp_tp[1].checked){
	        			slp_tp = "S"		// Standard
	        		}
	        		
//	        		if(form.slp_tp[1].checked) {
//		        		ComOpenPopup("ESM_FMS_0028.do?flet_ctrt_no="+flet_ctrt_no+"&csr_curr_cd="+csr_curr_cd, 900, 378, "setOwnersAccount", "1,0,1,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0028");	        			
		        		ComOpenPopup("ESM_FMS_0099.do?flet_ctrt_no="+flet_ctrt_no+"&csr_curr_cd="+csr_curr_cd+"&slp_tp="+slp_tp, 900, 378, "setOwnersAccountStd", "1,0,1,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0099");	        			
//	        		}else{	        				        			        			
//		        		ComOpenPopup("ESM_FMS_0028.do?flet_ctrt_no="+flet_ctrt_no+"&csr_curr_cd="+csr_curr_cd, 900, 378, "setOwnersAccount", "1,0,1,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0028");	        			
//	        		}	        		
	        		break;
				
	        	case "btn_bodBor":
	        		if(validateForm(sheetObject,formObject,IBSEARCH,'N') == false) return;
	        		
	        		if(!preWorkCheck()) return; 
	        		
	        		initCheckBox(sheetObject);
	        		
	        		for (var ir=sheetObject.LastRow; ir>=sheetObject.HeaderRows; ir--) {
	        			if(sheetObject.CellValue(ir,"pop_gb") == "OIL") {
	        				sheetObject.CellValue2(ir,"DelChk") = 1;
	        				rowRemove(sheetObject, "");
	        			}
	        		}
	        		
	        		setTotalAmount('S');
	        		
	        		var flet_ctrt_no = formObject.flet_ctrt_no.value;
	        		var csr_curr_cd = formObject.csr_curr_cd.value;
	        		
	        		ComOpenPopup("ESM_FMS_0027.do?flet_ctrt_no="+flet_ctrt_no+"&csr_curr_cd="+csr_curr_cd+"&apro_flg=", 900, 378, "setBodBor", "1,0,1,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0027");
	        		
	        		break;
				
	        	case "btn_rowAdd":

	        		if(validateForm(sheetObject,formObject,IBSEARCH,'N') == false) return;
	        		
	        		if(!preWorkCheck()) return; 
	        		
	        		var row = sheetObject.DataInsert(-1);
	        		
	        		
	        		sheetObject.CellValue2(row,"vndr_seq") = formObject.ownr_cd.value;
	        		sheetObject.CellValue2(row,"ctr_cd") = formObject.ap_ctr_cd.value;
	        		sheetObject.CellValue2(row,"slp_loc_cd") = formObject.loc_cd.value;
	        		sheetObject.CellValue2(row,"slp_eff_dt") = formObject.eff_dt.value;
	        		sheetObject.CellValue2(row,"flet_src_tp_cd") = "99";
	        		
	        		sheetObject.CellEditable(row, "acct_cd") = true;
	        		sheetObject.CellEditable(row, "ctr_cd") = true;
	        		sheetObject.CellEditable(row, "csr_amt") = true;
	        		sheetObject.CellEditable(row, "bunker_vvd") = true;
	        		sheetObject.CellEditable(row, "csr_desc") = true;
	        		
	        		var currCd = formObject.csr_curr_cd.value;
	        		
	        		// -------------------------------------------------------
					// Currency가 KRW / JPY / PAB 는 소수점을 입력못하게 체크한다.
					// -------------------------------------------------------
	        		if(ComFmsCheckCurrencyYn(currCd)) {
	        			sheetObject.InitCellProperty(row, "csr_amt", dtNull, daRight, "csr_amt", "", dfNullInteger);
	        		}

	        		//sheetObject.CellValue2(row+1,"csr_desc")  = " ";
	        		//sheetObject.CellValue2(row+1,"csr_desc1") = " ";
	        		//sheetObject.CellValue2(row+1,"csr_desc2") = " ";
	        		//sheetObject.CellValue2(row+1,"csr_desc3") = " "; 
	        		
	        		// --------------------------
					// Grid Font 설정하기
					// --------------------------
	        		setCellFont(sheetObject, row);
	        		
	        		break;
			
	        	case "btn_rowDel":
	        		if(validateForm(sheetObject,formObject,IBSEARCH,'N') == false) return;
	        		
	        		if(checkBoxCheckYn(sheetObject, "DelChk")) {
	            		rowRemove(sheetObject, "");
	            	}
	        		
	        		setTotalAmount('S');
	        		
	        		break;
				
	        	case "btn_retrieve":
	        		doActionIBSheet(sheetObject,formObject,IBSEARCH);
	        		break;
				
	        	case "btn_new":
	        		if(!initConfirm()) return;
	        		
	        		formReset();
	        		break;
				
	        	case "btn_save":
	        		if(validateForm(sheetObject,formObject,IBSEARCH,'N') == false) return;
	        		
	        		doActionIBSheet(sheetObject,formObject,IBSAVE);	        		
	        		break;

	        	case "btn_hireStatement":
	        		if(sheetObject.RowCount > 0){
						var csr_no = formObject.csr_no.value;
						var vsl_eng_nm = formObject.vsl_eng_nm.value;
						
				 		//SLP_FUNC_CD가 'P' or 'S' or 'T'인 경우만 인쇄 대상임
				 		if (   csr_no.substring(2,3) == 'P'
				 			|| csr_no.substring(2,3) == 'S'
				 			|| csr_no.substring(2,3) == 'T') {
				 			
				 			ComOpenPopup("ESM_FMS_0075.do?csr_no="+ csr_no+"&pgm_id=esm_fms_0021&vsl_eng_nm="+vsl_eng_nm+"", 500, 153, "sendMail", "1,0,1,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0075");
				 		} else {
							ComShowCodeMessage("FMS01511");
							return;
				 		}

					} else {
						ComShowCodeMessage('FMS00015');
					}
	        		break;
				
	        	case "btn_taxEvidence":
	        		if(validateForm(sheetObject,formObject,IBSEARCH,'N') == false) return;
	        		
	        		if(sheetObject.RowCount == 0) return;
	        		
	        		//setInitVatApply(sheetObject);
	        		
	        		initCheckBox(sheetObject);
	        		
	        		for (var ir=sheetObject.LastRow; ir>=sheetObject.HeaderRows; ir--) {
	        			if(sheetObject.CellValue(ir,"pop_gb") == "TAX") {
	        				sheetObject.CellValue2(ir,"DelChk") = 1;
	        				rowRemove(sheetObject, "");
	        			}
	        		}
	        		
	        		setTotalAmount('S');
	        		
	        		var evid_tp_cd = form.evid_tp_cd_val.value;
	        		var tax_inv_yrmon = formObject.eff_dt.value;
	        		
	        		ComOpenPopup("ESM_FMS_0029.do?tax_inv_yrmon="+tax_inv_yrmon+"&evid_tp_cd="+evid_tp_cd, 917, 562,"setTaxEvidence", "1,0,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0029");
	        		
	        		break;
				
	        	case "btn_slipInquiry":
	        		ComOpenPopup("ESM_FMS_0041_1.do?popup=yes", 1024, 590, "setSlipInquiry", "1,0,1,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0041_1");
	        		//ComOpenPopup("ESM_FMS_0041.do?popup=yes", 1024, 590, "setSlipInquiry", "1,0,1,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0041");
	        		break;
				
	        	//2017.04.18 preview 기능 추가
	        	case "btn_preview":
	        		rdOpenPreview(rdObjects[0], document.form);
	        		break;
	        		
	        	case "btn_print":
	        		rdOpen(rdObjects[0], document.form);
	        		break;
				
	        	case "btn_vslpop":
	        		ComOpenPopup("ESM_FMS_0022.do?pgmNo=ESM_FMS_0022", 520, 440,"setVslCd", "1,0,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0022");
	        		break;
				
	        	case "btn_ctrtpop":
	        		if(formObject.vsl_cd.value == "") {
	        			ComAlertFocus(formObject.vsl_cd, ComGetMsg('FMS01231'));
	        			return;
	        		}
	        		
	        		if(formObject.slp_tp[0].checked) {
	        			ComOpenPopup("ESM_FMS_0023.do?vsl_cd=" + formObject.vsl_cd.value+"&typeFlag=" + "TI|OW", 520, 405,"setContractNo", "1,0,1,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0023");
	        		} else if (formObject.slp_tp[1].checked){
	        			ComOpenPopup("ESM_FMS_0023.do?vsl_cd=" + formObject.vsl_cd.value+"&typeFlag=" + "TI|TO|OW", 520, 405,"setContractNo", "1,0,1,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0023");
		        	//2010.08.13 nonbubble 추가 => Contract pop-up창에 slip type이 "Prepaid W/O hire"인 경우에는 Standard처럼 TI|TO|OW가 다 나오도록 한다(이영두 수석님) 
	        		} else if (formObject.slp_tp[2].checked){	        			
	        			
	        			ComOpenPopup("ESM_FMS_0023.do?vsl_cd=" + formObject.vsl_cd.value+"&typeFlag=" + "TI|TO|OW", 520, 405,"setContractNo", "1,0,1,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0023");
	        		
	        		//2012.05.30   Slip Type에서 'Prepayment Bunker' 추가
	        		} else if (formObject.slp_tp[3].checked){        			
	        			
	        		   ComOpenPopup("ESM_FMS_0023.do?vsl_cd=" + formObject.vsl_cd.value+"&typeFlag=" + "TI|TO|OW", 520, 405,"setContractNo", "1,0,1,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0023");
	        	
	        		}
	        		break;
				
	        	case "rqst_dt_cal": 
	        		var cal = new ComCalendar();
	        		cal.select(form.rqst_dt, 'yyyy-MM-dd');
	        		break;
			 
	        	case "eff_dt_cal": 
	        		var cal = new ComCalendar();
	        		cal.select(form.eff_dt, 'yyyy-MM-dd');
	        		break;
	        		
	        	case "btn_totalCal": 
	        		if(validateForm(sheetObject,formObject,IBSEARCH,'N') == false) return;
	        		
	        		if(!preWorkCheck()) return; 
	        		
	        		if(sheetObject.rowCount != 0) {
	        			setTotalAmount('S');
	        		}
	        		break;
	        		
	        	case "apro_step_btn" :
    				if(form.csr_no.value != "") return; 
    				var v_ofc_cd = formObject.slp_ofc_cd.value;
    	    	    
    	    	    
    	    	    var v_sub_sys_cd = "FMS";
    	            var param = "?mode=save&ofc_cd="+v_ofc_cd+"&sub_sys_cd="+v_sub_sys_cd+"&classId=COM_ENS_0T1"+"&target_obj_nm=apro_step";
    					ComOpenPopup('/hanjin/COM_ENS_0T1.do'+param, 835, 540, '', 'none', true);
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

    //2017.05.15 contract type 콤보로 변경
    function setComboObject(combo_obj){          
        comboObjects[comboCnt++] = combo_obj;
    }


    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
        	
        //khlee-시작 환경 설정 함수 이름변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+2);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        
        //RD
		initRdConfig(rdObjects[0]);
        
        //html컨트롤 이벤트초기화
        initControl();
        
        // 현재 오픈되어있는 G/L Date가져온다
    	doActionIBSheet(sheetObjects[0], document.form, "IBSEARCHGL");
    	doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'eff_dt');		//2017.05.10 과세처리 로직 보완
        
        sheetObjects[0].ExtendLastCol = false;
        sheetObjects[1].ExtendLastCol = false;
        sheetObjects[2].ExtendLastCol = false;

    }
    
    /**
     * body 태그의 onLoad 이벤트핸들러 구현 후 DB 호출시 Sheet 화면 깜빡임 방지
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function sheet1_OnLoadFinish(sheetObj) {  
    	sheetObj.WaitImageVisible = false;
    	
    	doActionIBSheet(sheetObj, document.form, IBROWSEARCH);
    	
    	doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "ComCd");		//2017.05.15 contract type 콤보로 변경
        
        CoFmsGetCombo('FORM', document.form, sheetObj, 'CD01745', 'evid_tp_cd', 'evid_tp_nm');
        
        setEvidenceType();
		
		sheetObj.WaitImageVisible = true;   
    }


    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetObj.id) {
            case "sheet1":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 208;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    //MergeSheet = msAll;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					//InitRowInfo(2, 2, 3, 100);
                    InitRowInfo( 1, 1, 3, 100);
 
 					//var HeadTitle1 = " |Seq|Sel|Account Code|Owner Code|Center Code|City|Eff. Date|Slip Amount|VAT\nApply";
					//var HeadTitle2 = " |Seq|Sel|Description|Description|Description|Description|VVD Code|Key Number|VAT\nApply";
					//var headCount = ComCountHeadTitle(HeadTitle1);
					
					//var HeadTitle = " |Seq|Sel|Acct Cd|Ownr Cd|Ctr Cd|City|Eff. Date|Slip Amount|VVD Code|Key Number|Description|Inv Seq|Flet Src Type Code|Inv Dtl Seq|Ownr Acct Slip Csr No|Bnk Seq|Flet Iss Type Code|Eff Dt|Exp Dt|VAT\nApply|PopGb|Vat Flag|SLP_TP_CD|SLP_FUNC_CD|SLP_OFC_CD|SLP_ISS_DT|SLP_SER_NO|SLP_SEQ_NO|Ctrt No|Bnk Seq|Key Flg|Slip Type";
                    
                    var HeadTitle = " |Sel|Seq|Seq|Acct Cd|Ownr Cd|Ctr Cd|City|Eff. Date|Curr Cd|Slip Amount|VVD Code|Key Number|Description|Inv Seq|Flet Src Type Code|Inv Dtl Seq|Ownr Acct Slip Csr No|Flet Iss Type Code|Eff Dt|Exp Dt|VAT\nApply|PopGb|Vat Flag|SLP_TP_CD|SLP_FUNC_CD|SLP_OFC_CD|SLP_ISS_DT|SLP_SER_NO|SLP_SEQ_NO|Ctrt No|Bnk Seq|Key Flg|Tax Seq|Auto Flg|Org Flet Ctrt No";
					
					//var HeadTitle = " |Seq|Sel|Account Code|Owner Code|Center Code|City|Eff. Date|Slip Amount|VVD Code|Key Number|Description|VAT\nApply";
 
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    //InitColumnInfo(headCount, 0, 0, true);
					
					//InitColumnInfo(33, 0, 0, true);
					InitColumnInfo(36, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, false, true, false, false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    //InitHeadRow(0, HeadTitle1, true);
                    //InitHeadRow(1, HeadTitle2, true);
                    
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    /*
					InitDataProperty(0, cnt++ , dtHiddenStatus,		80,		daCenter,	true,		"ibflag");
                    InitDataProperty(0, cnt++ , dtSeq,      	 	40,		daCenter,	true,		"Seq");
                    InitDataProperty(0, cnt++ , dtDummyCheck,   	30,    	daCenter,  	true,   	"DelChk");
					InitDataProperty(0, cnt++ , dtData,      		125,	daCenter,	true,		"AccountCode",		false,	"",		dfNone,			0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,      	  	125,	daCenter,	false,		"VendorCode",		false,	"",		dfNone,			0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,      	  	125,	daCenter,	true,		"CenterCode",		false,	"",		dfNone,			0,	true,	true);

					InitDataProperty(0, cnt++ , dtData,   	   		125,	daCenter,	true,		"City",				false,	"",		dfNone,			0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,      	  	125,	daCenter,	true,		"EffDate",			false,	"",		dfDateYmd,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,   	   		190,	daRight,	false,		"SlipAmount",		false,	"",		dfNullFloat,	2,	true,	true);
					InitDataProperty(0, cnt++ , dtCheckBox,  	  	40,		daCenter,	false,		"VATApply",			false,	"",		dfNone,			0,	true,	true);
					                                                                                                                  
					cnt = 1;
					InitDataProperty(1, cnt++ , dtSeq,      	 	40,		daCenter,	true,		"Seq");
					InitDataProperty(1, cnt++ , dtDummyCheck,   	30,    	daCenter,  	true,   	"DelChk");
					InitDataProperty(1, cnt++ , dtData,      		125,	daCenter,	true,		"csr_desc",			false,	"",		dfNone,			0,	true,	true);
					InitDataProperty(1, cnt++ , dtData,      	  	125,	daCenter,	true,		"csr_desc1",		false,	"",		dfNone,			0,	true,	true);
					InitDataProperty(1, cnt++ , dtData,      	  	125,	daCenter,	true,		"csr_desc2",		false,	"",		dfNone,			0,	true,	true);

					InitDataProperty(1, cnt++ , dtData,   	   		125,	daCenter,	true,		"csr_desc3",		false,	"",		dfNone,			0,	true,	true);
					InitDataProperty(1, cnt++ , dtData,      	  	125,	daCenter,	false,		"VVDCode",			false,	"",		dfNone,			0,	true,	true);
					InitDataProperty(1, cnt++ , dtData,   	   		190,	daCenter,	false,		"KeyNumber",		false,	"",		dfNone,			0,	true,	true);
					InitDataProperty(1, cnt++ , dtCheckBox,  	  	40,		daCenter,	true,		"VATApply",			false,	"",		dfNone,			0,	true,	true);

					SetSortDialog(false);
					
					DataRowMerge(0) = true;
					DataRowMerge(1) = true;
					*/
                    
                    InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,	true,		"ibflag");
                    InitDataProperty(0, cnt++ , dtDummyCheck,   	25,    	daCenter,  	true,   	"DelChk");
                    InitDataProperty(0, cnt++ , dtDataSeq,      	30,		daCenter,	true,		"seq_no");
                    InitDataProperty(0, cnt++ , dtHidden,   	   	30,		daCenter,	true,		"slp_seq_num",			false,	"",		dfNone,			0,	false,	false, 5);
					//InitDataProperty(0, cnt++ , dtData,      		50,		daCenter,	true,		"acct_cd",				false,	"",		dfUserFormat,	0,	false,	false, 6);
                    InitDataProperty(0, cnt++ , dtData,      		50,		daCenter,	true,		"acct_cd",				false,	"",		dfNone,			0,	false,	false, 6);
                    InitDataProperty(0, cnt++ , dtData,      	  	55,		daCenter,	false,		"vndr_seq",				false,	"",		dfNone,			0,	false,	false, 6);
					//InitDataProperty(0, cnt++ , dtData,      	  	45,		daCenter,	true,		"ctr_cd",				false,	"",		dfUserFormat,	0,	false,	false, 6);
                    InitDataProperty(0, cnt++ , dtData,      	  	45,		daCenter,	true,		"ctr_cd",				false,	"",		dfNone,			0,	false,	false, 6);
                    
					InitDataProperty(0, cnt++ , dtData,   	   		42,		daCenter,	true,		"slp_loc_cd",			false,	"",		dfNone,			0,	false,	false, 5);
					InitDataProperty(0, cnt++ , dtData,      	  	65,		daCenter,	true,		"slp_eff_dt",			false,	"",		dfDateYmd,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      		55,		daCenter,	false,		"curr_cd",				false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,   	   		75,		daRight,	false,		"csr_amt",				false,	"",		dfNullFloat,	2,	false,	false, 15);
					
					//InitDataProperty(0, cnt++ , dtData,      	  	80,		daCenter,	false,		"bunker_vvd",			false,	"",		dfEngUpKey,		0,	false,	false, 10);
					InitDataProperty(0, cnt++ , dtData,      	  	80,		daCenter,	false,		"bunker_vvd",			false,	"",		dfNone,			0,	false,	false, 10);
					InitDataProperty(0, cnt++ , dtData,   	   		175,	daLeft,		false,		"key_number",			false,	"",		dfEngUpKey,		0,	false,	false, 30);
					InitDataProperty(0, cnt++ , dtData,      		284,	daLeft,		true,		"csr_desc",				false,	"",		dfNone,			0,	false,	false, 100);
					InitDataProperty(0, cnt++ , dtHidden,      	  	65,		daCenter,	true,		"inv_seq",				false,	"",		dfNone,			0,	false,	false);					
					InitDataProperty(0, cnt++ , dtHidden,      	  	65,		daCenter,	true,		"flet_src_tp_cd",		false,	"",		dfNone,			0,	false,	false);					
					InitDataProperty(0, cnt++ , dtHidden,      	  	65,		daCenter,	true,		"inv_dtl_seq",			false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      	  	65,		daCenter,	true,		"ownr_acct_slp_csr_no",	false,	"",		dfNone,			0,	false,	false);
					//InitDataProperty(0, cnt++ , dtHidden,      	  	65,		daCenter,	true,		"bnk_seq",				false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      	  	65,		daCenter,	true,		"flet_iss_tp_cd",		false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      	  	65,		daCenter,	true,		"eff_dt",				false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      	  	65,		daCenter,	true,		"exp_dt",				false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,  	  		38,		daCenter,	false,		"vat_apply",			false,	"",		dfNone,			0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,  	  		38,		daCenter,	false,		"pop_gb",				false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,  	  		38,		daCenter,	false,		"vat_flg",				false,	"",		dfNone,			0,	false,	false);
					
					//InitDataProperty(0, cnt++ , dtData,      		60,		daLeft,		false,		"slp_tp_cd",			false,	"",		dfNone,			0,	false,	false);
					//InitDataProperty(0, cnt++ , dtData,      		60,		daLeft,		false,		"slp_func_cd",			false,	"",		dfNone,			0,	false,	false);
					//InitDataProperty(0, cnt++ , dtData,      		60,		daLeft,		false,		"slp_ofc_cd",	    	false,	"",		dfNone,			0,	false,	false);
					//InitDataProperty(0, cnt++ , dtData,      		65,		daCenter,	true,		"slp_iss_dt",			false,	"",		dfDateYmd,		0,	false,	false);
					//InitDataProperty(0, cnt++ , dtData,      		60,		daLeft,		false,		"slp_ser_no",			false,	"",		dfNone,			0,	false,	false);
					//InitDataProperty(0, cnt++ , dtData,      		60,		daLeft,		false,		"slp_seq_no",			false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      		60,		daLeft,		false,		"ap_slp_tp_cd",			false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      		60,		daLeft,		false,		"ap_slp_func_cd",		false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      		60,		daLeft,		false,		"ap_slp_ofc_cd",	    false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      		65,		daCenter,	true,		"ap_slp_iss_dt",		false,	"",		dfDateYmd,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      		60,		daLeft,		false,		"ap_slp_ser_no",		false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      		60,		daLeft,		false,		"ap_slp_seq_no",		false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      		60,		daLeft,		false,		"flet_ctrt_no",			false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      		60,		daLeft,		false,		"bnk_seq",				false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      		60,		daLeft,		false,		"key_flg",				false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      		60,		daLeft,		false,		"tax_seq",				false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      		60,		daCenter,	false,		"auto_flg",				false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      		60,		daCenter,	false,		"org_flet_ctrt_no",		false,	"",		dfNone,			0,	false,	false);
					//InitDataProperty(0, cnt++ , dtHidden,      		60,		daLeft,		false,		"slp_tp_cd",			false,	"",		dfNone,			0,	false,	false);
					
					InitDataValid(0, "acct_cd"   , vtNumericOnly);
					InitDataValid(0, "ctr_cd"    , vtNumericOnly);
					InitDataValid(0, "bunker_vvd", vtEngUpOther, "0123456789");
					//InitUserFormat(0, "acct_cd", "######", "" );
					//InitUserFormat(0, "ctr_cd",  "######", "" );

               }
                break;
            case "sheet2":      //sheet2
	            with (sheetObj) {
	            	var prefix = "tax_";
	                // 높이 설정
	                style.height = 120;
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msNone;
	
	               //전체Edit 허용 여부 [선택, Default false]
	                Editable = true;
	
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo( 1, 1, 3, 100);
	
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(29, 0, 0, true);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(false, true, true, true, false, false)
	
	                var HeadTitle = "|Seq|Sel|tax_inv_yrmon|ofc_cd|tax_iss_cd|tax_vat_tp_cd|tax_naid_flg|tax_div_cd|fa_flg|tax_pl_cd|tax_nsl_flg|spl_rgst_no|ownr_nm|co_nm|bzct_nm|bztp_nm|spl_addr|iss_dt|spl_amt|tax_amt|total_amt|SLP_TP_CD|SLP_FUNC_CD|SLP_OFC_CD|SLP_ISS_DT|SLP_SER_NO|CRE_USR_ID|UPD_USR_ID";
	
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle, true);
	                										  //134
	                //데이터속성    	[ROW, COL,  DATATYPE,     WIDTH,   DATAALIGN, COLMERGE, SAVENAME,  	   			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  	true,    	prefix + "ibflag");
	                InitDataProperty(0, cnt++ , dtSeq,    		40,    	daCenter,  	true,    	prefix + "Seq");
					InitDataProperty(0, cnt++ , dtDummyCheck,   40,    	daCenter,  	false,		prefix + "DelChk");
	                InitDataProperty(0, cnt++ , dtData,      	180,   	daCenter,  	false,    	prefix + "tax_inv_yrmon",		false,          "",      	dfDateYm,   	0,     	true,       true);
	                InitDataProperty(0, cnt++ , dtData,      	180,   	daCenter,  	false,      prefix + "ofc_cd",				false,          "",      	dfNone,   		0,     	true,       true);
	                InitDataProperty(0, cnt++ , dtData,      	134,   	daCenter,  	false,    	prefix + "tax_iss_cd",			false,          "",      	dfNone,      	0,     	false,      false);
	                InitDataProperty(0, cnt++ , dtData,      	134,   	daCenter,  	false,    	prefix + "tax_vat_tp_cd",		false,          "",      	dfNone,      	0,     	false,      false);
					InitDataProperty(0, cnt++ , dtData,      	161,   	daCenter,  	false,    	prefix + "tax_naid_flg",    	false,          "",      	dfNone,   		0,     	false,      true);
					InitDataProperty(0, cnt++ , dtData,      	161,   	daCenter,  	false,    	prefix + "tax_div_cd",     		false,          "",      	dfNone,   		0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      	134,   	daCenter,  	false,    	prefix + "fa_flg",     			false,          "",      	dfNone,  		0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      	99,    	daRight,   	false,    	prefix + "tax_pl_cd",			false,          "",      	dfNone, 		2,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      	134,   	daCenter,  	false,    	prefix + "tax_nsl_flg",			false,          "",      	dfNone,      	0,     	true,       false);
					
					InitDataProperty(0, cnt++ , dtData,      	134,   	daCenter,  	false,    	prefix + "spl_rgst_no",			false,          "",      	dfNone,      	0,     	true,       false);
					InitDataProperty(0, cnt++ , dtData,      	161,   	daCenter,  	false,    	prefix + "ownr_nm",  			false,          "",      	dfNone,   		0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      	161,   	daCenter,  	false,    	prefix + "co_nm",  				false,          "",      	dfNone,   		0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      	134,   	daCenter,  	false,    	prefix + "bzct_nm",				false,          "",      	dfNone,      	0,     	true,       false);
					
					InitDataProperty(0, cnt++ , dtData,      	134,   	daCenter,  	false,    	prefix + "bztp_nm",				false,          "",      	dfNone,      	0,     	true,       false);
					InitDataProperty(0, cnt++ , dtData,      	134,   	daCenter,  	false,    	prefix + "spl_addr",			false,          "",      	dfNone,      	0,     	true,       false);
					
					InitDataProperty(0, cnt++ , dtData,      	134,   	daCenter,  	false,    	prefix + "iss_dt",				false,          "",      	dfDateYmd,      0,     	true,       false);
					InitDataProperty(0, cnt++ , dtData,      	134,   	daCenter,  	false,    	prefix + "spl_amt",				false,          "",      	dfNullFloat,    2,     	true,       false);
					InitDataProperty(0, cnt++ , dtData,      	134,   	daCenter,  	false,    	prefix + "tax_amt",				false,          "",      	dfNullFloat,    2,     	true,       false);
					InitDataProperty(0, cnt++ , dtData,      	134,   	daCenter,  	false,    	prefix + "total_amt",			false,          "",      	dfNullFloat,    2,     	true,       false);
					InitDataProperty(0, cnt++ , dtHidden,      	60,		daLeft,		false,		prefix + "slp_tp_cd",			false,			"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,      	60,		daLeft,		false,		prefix + "slp_func_cd",			false,			"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,      	60,		daLeft,		false,		prefix + "slp_ofc_cd",	    	false,			"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,      	65,		daCenter,	true,		prefix + "slp_iss_dt",			false,			"",			dfDateYmd,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,      	60,		daLeft,		false,		prefix + "slp_ser_no",			false,			"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,      	110,	daRight,	true,		prefix + "cre_usr_id",			false,			"",			dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,      	110,	daRight,	true,		prefix + "upd_usr_id",			false,			"",			dfNone,			0,		false,		true);
	            }
	            break;
	            
            case "sheet3":      //sheet3
	            with (sheetObj) {
	            	var prefix = "txd_";
	            	
	                // 높이 설정
	                style.height = 120;
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msNone;
	
	               //전체Edit 허용 여부 [선택, Default false]
	                Editable = true;
	
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);
	
					var HeadTitle1 = " |순번|Sel|품명|공급가액|세액|합계";
					var headCount = ComCountHeadTitle(HeadTitle1);
	
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 0, 0, true);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false,false)
	
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle1, true);
	
	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,		80,		daCenter,	true,		prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtDataSeq,      	40,		daCenter,	false,		prefix + "tax_dtl_ser_no",	false,		"",		dfNone,				0,		false,		true);
					InitDataProperty(0, cnt++ , dtDummyCheck,   	40,    	daCenter,  	true,   	prefix + "DelChk");
					InitDataProperty(0, cnt++ , dtData,      	  	440,	daCenter,	true,		prefix + "itm_nm",			false,		"",		dfNone,				0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,      	  	110,	daRight,	true,		prefix + "spl_amt",			false,		"",		dfNullFloat,		2,		true,		true);
					InitDataProperty(0, cnt++ , dtData,   	   		100,	daRight,	true,		prefix + "tax_amt",			false,		"",		dfNullFloat,		2,		false,		true);
					InitDataProperty(0, cnt++ , dtData,      	  	110,	daRight,	true,		prefix + "total_amt",		false,		"",		dfNullFloat,		2,		false,		true);
	            }
	            break;
	            
            case "sheet4":      //sheet4
	            with (sheetObj) {
	            	var prefix = "mst_";
	            	
	                // 높이 설정
	                style.height = 120;
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msNone;
	
	               //전체Edit 허용 여부 [선택, Default false]
	                Editable = true;
	
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);
	
					var HeadTitle1 = " |Seq|Sel|slp_ofc_cd|ap_ctr_cd|loc_cd|chk_acct_cd|chk_ctr_cd|chk_bunker_vvd|pre_work_flag|evid_tp_cd_val|usd_locl_xch_rt|flet_ctrt_no|vsl_cd|vsl_eng_nm|flet_ctrt_tp_cd|csr_curr_cd|slp_iss_dt|usr_nm|csr_no|slp_desc|slp_tp|evid_tp_cd|rqst_dt|eff_dt|ownr_cd|ppay_hir_no|vat_flg|cre_usr_id|upd_usr_id|dr_amt|diff_amt|balance_amt|apro_step";
					var headCount = ComCountHeadTitle(HeadTitle1);
	
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 0, 0, true);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false,false)
	
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle1, true);
	
	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	80,		daCenter,	true,		prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtDataSeq,      40,		daCenter,	false,		prefix + "seq",				false,		"",		dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtDummyCheck,   40,    	daCenter,  	true,   	prefix + "DelChk");
					InitDataProperty(0, cnt++ , dtData,      	110,	daCenter,	true,		prefix + "slp_ofc_cd",		false,		"",		dfNone,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,      	110,	daRight,	true,		prefix + "ap_ctr_cd",		false,		"",		dfNone,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,   	   	100,	daRight,	true,		prefix + "loc_cd",			false,		"",		dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,      	110,	daRight,	true,		prefix + "chk_acct_cd",		false,		"",		dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,      	110,	daRight,	true,		prefix + "chk_ctr_cd",		false,		"",		dfNone,		0,		false,		true);
					
					InitDataProperty(0, cnt++ , dtData,      	110,	daRight,	true,		prefix + "chk_bunker_vvd",	false,		"",		dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,      	110,	daRight,	true,		prefix + "pre_work_flag",	false,		"",		dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,      	110,	daRight,	true,		prefix + "evid_tp_cd_val",	false,		"",		dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,      	110,	daRight,	true,		prefix + "usd_locl_xch_rt",	false,		"",		dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,      	110,	daRight,	true,		prefix + "flet_ctrt_no",	false,		"",		dfNone,		0,		false,		true);
					
					InitDataProperty(0, cnt++ , dtData,      	110,	daRight,	true,		prefix + "vsl_cd",			false,		"",		dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,      	110,	daRight,	true,		prefix + "vsl_eng_nm",		false,		"",		dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,      	110,	daRight,	true,		prefix + "flet_ctrt_tp_cd",	false,		"",		dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,      	110,	daRight,	true,		prefix + "csr_curr_cd",		false,		"",		dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,      	110,	daRight,	true,		prefix + "slp_iss_dt",		false,		"",		dfDateYmd,	0,		false,		true);
					
					InitDataProperty(0, cnt++ , dtData,      	110,	daRight,	true,		prefix + "usr_nm",			false,		"",		dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,      	110,	daRight,	true,		prefix + "csr_no",			false,		"",		dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,      	110,	daRight,	true,		prefix + "slp_desc",		false,		"",		dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,      	110,	daRight,	true,		prefix + "slp_tp",			false,		"",		dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,      	110,	daRight,	true,		prefix + "evid_tp_cd",		false,		"",		dfNone,		0,		false,		true);
					
					InitDataProperty(0, cnt++ , dtData,      	110,	daRight,	true,		prefix + "rqst_dt",			false,		"",		dfDateYmd,	0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,      	110,	daRight,	true,		prefix + "eff_dt",			false,		"",		dfDateYmd,	0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,      	110,	daRight,	true,		prefix + "ownr_cd",			false,		"",		dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,      	110,	daRight,	true,		prefix + "ppay_hir_no",		false,		"",		dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,      	110,	daRight,	true,		prefix + "vat_flg",			false,		"",		dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,      	110,	daRight,	true,		prefix + "cre_usr_id",		false,		"",		dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,      	110,	daRight,	true,		prefix + "upd_usr_id",		false,		"",		dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,      	110,	daRight,	true,		prefix + "dr_amt",			false,		"",		dfNullFloat,2,		true,		true);
					InitDataProperty(0, cnt++ , dtData,      	110,	daRight,	true,		prefix + "diff_amt",		false,		"",		dfNullFloat,2,		true,		true);
					InitDataProperty(0, cnt++ , dtData,      	110,	daRight,	true,		prefix + "balance_amt",		false,		"",		dfNullFloat,2,		true,		true);
					InitDataProperty(0, cnt++ , dtData,      	110,	daRight,	true,		prefix + "apro_step",		false,		"",		dfNone,		0,		false,		true);					
	            }
	            break;
	            
            case "sheet5":      //sheet5
    			with (sheetObj) {
    			
            	var prefix = "sheet1_";
            	
				// 높이 설정  293
				style.height = 300;
				
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msAll;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 2, 2, 3, 100);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, true, false, true, false,false)

                var HeadTitle = "|Seq|Account Code|Customer Code|Customer Code|Center Code|City|Eff. Date|Slip Amount|slp_tp_cd|slp_func_cd|slp_ofc_cd|slp_seq_no|csr_curr_cd|trns_curr_cd|trns_amt|inv_seq|slp_iss_dt|vvd_eff_dt|vvd_exp_dt|csr_no|flet_ctrt_no|flet_iss_tp_cd|inv_dtl_seq|bnk_seq|";
                var HeadTitle2 = "|Seq|Description|Description|Description|Description|VVD Code|Key Number|Key Number|slp_tp_cd|slp_func_cd|slp_ofc_cd|slp_seq_no|csr_curr_cd|trns_curr_cd|trns_amt|inv_seq|slp_iss_dt|vvd_eff_dt|vvd_exp_dt|csr_no|flet_ctrt_no|flet_iss_tp_cd|inv_dtl_seq|bnk_seq";
                var headCount = ComCountHeadTitle(HeadTitle);
                
                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
                InitHeadRow(1, HeadTitle2, true);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                cnt = 0;
                InitDataProperty(0, cnt++, dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
                InitDataProperty(0, cnt++, dtSeq,      		40,    	daCenter,  	true);
                InitDataProperty(0, cnt++, dtData,      	100,    daCenter,  	false,  "acct_cd",     		false,	"",	dfNone,      	0,	false,	false);
                InitDataProperty(0, cnt++, dtData,      	100,    daCenter,  	false,  "cust_cnt_cd",  	false,	"",	dfNone,      	0,	false,	false);
                InitDataProperty(0, cnt++, dtData,      	100,    daCenter,  	false,	"cust_seq",     	false,  "",	dfNone,      	0,  false,	false);
                InitDataProperty(0, cnt++, dtData,      	100,    daCenter,  	false,  "ctr_cd",     		false,  "", dfNone,      	0,  false,  false);
                InitDataProperty(0, cnt++, dtData,      	100,    daCenter,  	false,  "slp_loc_cd",   	false,  "", dtData,      	0,  false,  false);
                InitDataProperty(0, cnt++, dtData,      	100,    daCenter,  	false,  "eff_dt",     		false,  "", dfDateYmd,   	0,  false,  false);
                InitDataProperty(0, cnt++, dtData,      	180,    daRight,  	false,  "csr_amt",     		false,  "", dfNullFloat,	2,  false,  false);

                /* ------------------------------------------------------ */
                InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  	false,  "slp_tp_cd",    	false,  "", dtData,      	0,  false,  false);
                InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  	false,  "slp_func_cd",  	false,  "", dtData,      	0,  false,  false);
                InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  	false,  "slp_ofc_cd",   	false,  "", dtData,      	0,  false,  false);
                InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  	false,  "slp_seq_no",   	false,  "", dtData,      	0,  false,  false);
                InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  	false,  "csr_curr_cd",  	false,  "", dtData,      	0,  false,  false);
                InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  	false,  "trns_curr_cd", 	false,  "", dtData,      	0,  false,  false);
                InitDataProperty(0, cnt++, dtHidden,      	100,    daRight,  	false,  "trns_amt",     	false,  "", dfNullFloat,	2,  false,  false);
                InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  	false,  "inv_seq", 	 		false,  "", dtData,      	0,  false,  false);
                InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  	false,  "slp_iss_dt", 		false,  "", dfDateYmd,      0,  false,  false);
                InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  	false,  "vvd_eff_dt", 		false,  "", dfDateYmd,     	0,  false,  false);
                InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  	false,  "vvd_exp_dt", 		false,  "", dfDateYmd,     	0,  false,  false);
                InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  	false,  "csr_no", 			false,  "", dtData,     	0,  false,  false);
                InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  	false,  "flet_ctrt_no", 	false,  "", dtData,     	0,  false,  false);
                InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  	false,  "flet_iss_tp_cd", 	false,  "", dtData,     	0,  false,  false);
                InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  	false,  "inv_dtl_seq", 		false,  "", dtData,     	0,  false,  false);
                InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  	false,  "bnk_seq", 			false,  "", dtData,     	0,  false,  false);
                /* ------------------------------------------------------ */
                
				cnt = 0;
				InitDataProperty(1, cnt++, dtHiddenStatus,	30,    	daCenter,  	true,   "ibflag1");
                InitDataProperty(1, cnt++, dtSeq,      		40,    	daCenter,  	true);
                InitDataProperty(1, cnt++, dtData,      	100,   	daLeft,  	false,  "csr_desc",      	false,  "", dtData,      	0,	false,	false);
                InitDataProperty(1, cnt++, dtData,      	100,    daLeft,  	false,  "csr_desc1",     	false,  "", dtData,      	0,  false,	false);
                InitDataProperty(1, cnt++, dtData,      	100,    daLeft,  	false,  "csr_desc2",     	false,  "", dtData,      	0,  false,  false);
                InitDataProperty(1, cnt++, dtData,      	100,    daLeft,  	false,  "csr_desc3",     	false,  "", dtData,      	0,  false,  false);
                InitDataProperty(1, cnt++, dtData,      	100,    daCenter,  	false,  "vvd_cd",     	 	false,  "", dtData,      	0,  false,  false);
                InitDataProperty(1, cnt++, dtData,      	100,    daCenter,  	false,  "to_inv_no",   	 	false,  "", dtData,      	2,  false,  false);
                InitDataProperty(1, cnt++, dtData,      	180,    daCenter,  	false,  "to_inv_no1",    	false,  "", dtData,      	0,  false,  false);

                /* ------------------------------------------------------ */
                InitDataProperty(1, cnt++, dtHidden,      	100,    daCenter,  	false,  "slp_tp_cd1",    	false,  "", dtData,      	0,  false,  false);
                InitDataProperty(1, cnt++, dtHidden,      	100,    daCenter,  	false,  "slp_func_cd1",  	false,  "", dtData,      	0,  false,  false);
                InitDataProperty(1, cnt++, dtHidden,      	100,    daCenter,  	false,  "slp_ofc_cd1",   	false,  "", dtData,      	0,  false,  false);
                InitDataProperty(1, cnt++, dtHidden,      	100,    daCenter,  	false,  "slp_seq_no1",   	false,  "", dtData,      	0,  false,  false);
                InitDataProperty(1, cnt++, dtHidden,      	100,    daCenter,  	false,  "csr_curr_cd1",  	false,  "", dtData,      	0,  false,  false);
                InitDataProperty(1, cnt++, dtHidden,      	100,    daCenter,  	false,  "trns_curr_cd1", 	false,  "", dtData,      	0,  false,  false);
                InitDataProperty(1, cnt++, dtHidden,      	100,    daRight,  	false,  "trns_amt1",     	false,  "", dfNullFloat,	2,  false,  false);
                InitDataProperty(1, cnt++, dtHidden,      	100,    daCenter,  	false,  "inv_seq1", 	 	false,  "", dtData,      	0,  false,  false);
                InitDataProperty(1, cnt++, dtHidden,      	100,    daCenter,  	false,  "slp_iss_dt1", 	 	false,  "", dfDateYmd,    	0,  false,  false);
                InitDataProperty(1, cnt++, dtHidden,      	100,    daCenter,  	false,  "vvd_eff_dt1",	 	false,  "", dfDateYmd,     	0,  false,  false);
                InitDataProperty(1, cnt++, dtHidden,      	100,    daCenter,  	false,  "vvd_exp_dt1", 	 	false,  "", dfDateYmd,     	0,  false,  false);
                InitDataProperty(1, cnt++, dtHidden,      	100,    daCenter,  	false,  "csr_no1", 		 	false,  "", dtData,     	0,  false,  false);
                InitDataProperty(1, cnt++, dtHidden,      	100,    daCenter,  	false,  "flet_ctrt_no1", 	false,  "", dtData,     	0,  false,  false);
                InitDataProperty(1, cnt++, dtHidden,      	100,    daCenter,  	false,  "flet_iss_tp_cd1", 	false,  "", dtData,     	0,  false,  false);
                InitDataProperty(1, cnt++, dtHidden,      	100,    daCenter,  	false,  "inv_dtl_seq1", 	false,  "", dtData,     	0,  false,  false);
                InitDataProperty(1, cnt++, dtHidden,      	100,    daCenter,  	false,  "bnk_seq1", 		false,  "", dtData,     	0,  false,  false);

			}
			break;
			
            case "sheet6":      //sheet6 Offhiire Data
                with (sheetObj) {

                    // 높이 설정
                    style.height = 220;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);

 					//var HeadTitle1 = " |Apply|Hire No.|Item Name|Account Code|From|To|Cur.|Amount|Approval|Description";
 					//var HeadTitle = " ||Apply|Hire No|Item Name|Account Code|From|To|Cur|Amount|Description|Center Code|City Code";
					var HeadTitle = " ||Apply|Offhire Duration|Item Name|Account Code|Vessel VVD|Cur|Amount|Description|Center Code|City Code|FletIssTpCd|Inv Seq|Inv Dtl Seq|Flet Src TpCd|Eff Dt|Exp Dt|Vvd Yn|Flet Ctrt No";
 					var headCount = ComCountHeadTitle(HeadTitle);
 
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    //InitColumnInfo(headCount, 0, 0, true);
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    //InitHeadMode(false, true, false, true, false, false)
                    InitHeadMode(true, true, false, true, false, false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    //InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,  	40,		daCenter,	false,		"check",			false,	"",		dfNone,				0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,      	200,	daCenter,	false,		"duration",			false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	190,	daLeft,		false,		"acct_nm",			false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	90,		daCenter,	false,		"acct_cd",			false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	80,		daCenter,	false,		"vvd_bunker",		false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	40,		daCenter,	false,		"curr_cd",			false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,   	   	80,		daRight,	false,		"inv_amt",			false,	"",		dfNullFloat,		2,	false,	false);
					//InitDataProperty(0, cnt++ , dtData,      	60,		daCenter,	true,		"Approval",			false,	"",		dfNone,				0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,      	300,	daLeft,		false,		"inv_desc",			false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	60,		daLeft,		false,		"ctr_cd",			false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	60,		daLeft,		false,		"slp_loc_cd",		false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	60,		daLeft,		false,		"flet_iss_tp_cd",	false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	60,		daLeft,		false,		"inv_seq",			false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	60,		daLeft,		false,		"inv_dtl_seq",		false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	60,		daLeft,		false,		"flet_src_tp_cd",	false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	65,		daCenter,	true,		"eff_dt",			false,	"",		dfDateYmd,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	65,		daCenter,	true,		"exp_dt",			false,	"",		dfDateYmd,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	80,		daCenter,	false,		"vvd_yn",		    false,	"",		dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	80,		daCenter,	false,		"flet_ctrt_no",		false,	"",		dfNone,				0,	false,	false);
					
					//SetSortDialog(false);
               }
               break;
                
        }
    }

    /**
     * IBSheet 관련 각종 기능(조회,저장 등)을 처리한다. <br>
     * {@link #processButtonClick}함수에서 이 함수를 호출하여 버튼에서 IBSheet의 기능을 호추할 때 사용한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form}    formObj     Form Object
     * @param {int}     sAction     처리할 Action 코드(예:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL 등이며 CoObject.js에 정의됨)
     **/
    function doActionIBSheet(sheetObj,formObj,sAction,col,row) {

		sheetObj.ShowDebugMsg = false;
        switch(sAction) {

				case IBSEARCH:      //조회
					if(!validateForm(sheetObj,formObj,sAction))  return true;
				
	  				formObj.f_cmd.value = SEARCH;
	  			
	  				sheetObj.DoSearch("ESM_FMS_0021GS.do" , FormQueryString(formObj));
	  				
                	break;

				case IBSAVE:        //저장	
					
					if(!validateForm(sheetObj,formObj,sAction))  return true;
				
					if(sheetObj.RowCount == 0) {
			 			ComShowCodeMessage("FMS00007");
			 			return;
			 		}					
					
					// Tax Evidence 체크
					if(   formObj.evid_tp_cd_val.value == "1"
					   || formObj.evid_tp_cd_val.value == "4") {

						if(sheetObjects[2].RowCount == 0) {
							ComShowCodeMessage("FMS01458");
							return;
						}
					}
					
					//2017.07.12 Tax 항목 누락 방지
					var vatFlgCnt = 0;
					
					if(formObj.evid_tp_cd_val.value == "1") {
						for(var aa=1; aa<=sheetObj.LastRow; aa++) {
							if(sheetObj.CellValue(aa,"vat_flg") != "") vatFlgCnt++;
						}
						
						if(vatFlgCnt == 0) {
							ComShowCodeMessage("FMS01458");
							return;
						}
					}
					
					formObj.f_cmd.value = MULTI;
					
					//var arrSheets = new Array(sheetObjects[0], sheetObjects[1], sheetObjects[2], sheetObjects[3]);
					//var sParam = ComGetSaveString(arrSheets);
					 
					//var sParam = sheetObj.GetSaveString(); 
					
					//if (sheetObj.IsDataModified && sParam == "") {
						//return; 
					//}
					
					if(!saveConfirm()) return;
					
					
					var arrSheet = new Array(sheetObjects[0], sheetObjects[1]);
					var param = ComGetSaveString(arrSheet);
										
					
					if (sheetObj.IsDataModified && param == "") {
						return; 
					}
					
					/*
					// 세금 계산서 생성
					var evid_tp_cd = form.evid_tp_cd_val.value;
					//var tax_pl_cd = sheetObjects[1].RowCount;
					var vatCnt = sheetObj.CheckedRows("vat_apply");
					var taxCnt = sheetObjects[2].RowCount;
									
										
					if(taxCnt > 0 && evid_tp_cd == "1") {
						
						if(formObj.csr_curr_cd.value == "KRW") {
							// 영세(tax_tax_pl_cd == 1)도 과세와 동일하게 처리
							//if(sheetObjects[1].CellValue(1,"tax_tax_pl_cd") != "1") {
								setMakeTaxEvidence(sheetObj);
							//}
						} else {
							if(sheetObjects[1].CellValue(1,"tax_tax_pl_cd") != "2"){
									setMakeTaxEvidence(sheetObj);
							}else{
								if(vatCnt == taxCnt) {
									if(sheetObjects[1].CellValue(1,"tax_tax_pl_cd") != "1") {
										setMakeTaxEvidence(sheetObj);
									}									
								} else {
									if(sheetObjects[1].CellValue(1,"tax_tax_pl_cd") != "1") {
										ComShowCodeMessage('FMS01457',taxCnt);
										return;
									}
								}
							}
						}
					}
					*/
					
					// Total Amount
					setTotalAmount('S');

					
					// Balance 체크(금액이 0 이상일때 저장됨)
					if(!checkBalance(sheetObj)) return;
					
					// Slip Master Data 생성
					setMakeSlipMstData();
					
					var arrSheets = new Array(sheetObjects[0], sheetObjects[1], sheetObjects[2], sheetObjects[3]);
					var sParam = ComGetSaveString(arrSheets);
					
					if (sheetObj.IsDataModified && sParam == "") {
						return; 
					}
					
					var aryPrefix = new Array("", "tax_", "txd_", "mst_");
					
					sParam += "&" + FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix);
					
					var sXml = sheetObj.GetSaveXml("ESM_FMS_0021GS.do", sParam);
		       		var arrXml = sXml.split("|$$|");
		       		
		       		if (arrXml.length > 0) {
		       			//sheetObj.InitCellProperty(0, "seq_no", dtData); 	       			
		       			sheetObj.LoadSearchXml(arrXml[0]);
		       			//sheetObj.LoadSaveXml(arrXml[0]);
		       		}
		       		
		       		var csrNo = sheetObj.EtcData("csrNo");
		       		
		       		if(typeof csrNo == "undefined" || csrNo == "" ) {
		       			return;
		       		}

		       		
					// 20T : Start
					if (ar_olay_rt_amt > 0) {
						ComOpenWait(true);
						//AR O/A, OUTLAY COMM 자동 생성
						//CustomConsultationVO 넣어야 하느데
						//클라이언트에서 실행이 안되는 현상이 간헐적으로 발생된다고 하여 해당 액션 수행전에 딜레이를 추가함.
												
						setTimeout(createOlayComm, 2000);
					    	
/*
				   		var formObj = document.form;
				   		formObj.f_cmd.value = MULTI;
				   		var tParam = "f_cmd="+ formObj.f_cmd.value;
				   		tParam += "&" + "ar_olay_rt_amt="+ ar_olay_rt_amt;
				   		tParam += "&" + "slp_tp_cd=20" + "&" + "slp_func_cd=T" + "&" + "slp_ofc_cd=" + formObj.slp_ofc_cd.value;
				   		tParam += "&" + "slp_iss_dt=" + formObj.slp_iss_dt.value;
				   		tParam += "&" + "flet_ctrt_no=" + formObj.flet_ctrt_no.value;
				   		tParam += "&" + "csr_curr_cd=" + formObj.csr_curr_cd.value;
				   		tParam += "&" + "rqst_amt=0";
				   		tParam += "&" + "csr_desc=" + formObj.vsl_cd.value + " O/A, OUTLAY COMM";
				   		tParam += "&" + "eff_dt=" + formObj.eff_dt.value.trimAll('-');
				   		tParam += "&" + "apro_step=" + formObj.apro_step.value;
				   		//tParam += "&" + "vvd_cd=" + "CNTC" + form.eff_dt.value.trimAll('-').substring(2,6) + "MM";
				   		
				   		tParam += "&" + "cre_usr_id=" + formObj.usr_id.value;
				   		
				   		tParam += "&" + ComFmsSetPrifix(sheetObjects[4].GetSaveString(),"sheet1_");

//							var sXml = sheetObjects[0].GetSaveXml("ESM_FMS_0032GS.do", param);
						//sheetObj.LoadSaveXml(sXml);
				   		ar_olay_rt_amt = 0;  //초기화
				   		
				   		//alert("ar_olay_rt_amt > 0 ? [ " + ar_olay_rt_amt + " ]");
//					   	ComOpenWait(false);

				   		var sXml = sheetObj.GetSaveXml("ESM_FMS_0021GS.do", sParam + "&" + tParam);
				   		
                    }else{// 20T : End
                    	
*/
                    }

					
                	break;
                
				case IBROWSEARCH:   //공통 코드 조회	
                	if(col == "csr_curr_cd") {
                		
                		sheetObj.WaitImageVisible = false;
                		
    	        		formObj.f_cmd.value = SEARCH01;
    	        		
    	        		var sXml = sheetObj.GetSearchXml("ESM_FMS_0076GS.do" , FormQueryString(formObj)+"&curr_cd="+formObj.csr_curr_cd.value);
    	        		
    		   			var currCd = ComGetEtcData(sXml, "currCd");
    		   			
    		   			if(typeof currCd == "undefined" || currCd == "") {
    		   				formObj.csr_curr_cd.value = "";
    						ComAlertFocus(formObj.csr_curr_cd, ComGetMsg("FMS01142"));
    						
    		   			} else {
    		   				var currCd = formObj.csr_curr_cd.value;
    		   				
    		   				for(var ir=1; ir<=sheetObj.LastRow; ir++) {
    		   					
    		   					if(sheetObj.CellValue(ir, "flet_src_tp_cd") == "99") {
    		   						
    		   						// -------------------------------------------------------
    		   						// Currency가 KRW / JPY / PAB 는 소수점을 입력못하게 체크한다.
    		   						// -------------------------------------------------------
		    		   				if(ComFmsCheckCurrencyYn(currCd)) {
		    		        			sheetObj.InitCellProperty(ir, "csr_amt", dtNull, daRight, "csr_amt", "", dfNullInteger);
		    		        			
		    		        		} else {
		    		        			sheetObj.InitCellProperty(ir, "csr_amt", dtNull, daRight, "csr_amt", "", dfNullFloat, 2);
		    		        		}
    		   					}
    		   				}
    		   			}
    		   			
    		   			sheetObj.WaitImageVisible = true;
    		   			
    				} else if(col == "vsl_cd") {
    					
    					sheetObj.WaitImageVisible = false;
    					
    					formObj.f_cmd.value = SEARCH01;
    		
    		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do" , FormQueryString(formObj));

    		   			var vslEngNm = ComGetEtcData(sXml, "vslEngNm");
    		   			
    		   			if(typeof vslEngNm != "undefined" && vslEngNm != "" ) {
    		   				formObj.vsl_eng_nm.value = vslEngNm;
    		   				initDefaultContractNo(); //선박 대 계약 자동 매치
    		   				
    					} else {
    						formObj.vsl_cd.value = "";
    						formObj.vsl_eng_nm.value = "";
    						ComAlertFocus(formObj.vsl_cd, ComGetMsg("FMS01056"));
    						return;
    					}
    		   			
    		   			sheetObj.WaitImageVisible = true;
    		   			
    	    		} else if (col == "flet_ctrt_no") {
    					
    	    			sheetObj.WaitImageVisible = false;
    	    			
    					formObj.f_cmd.value = SEARCH;
    		
    		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0035GS.do" , FormQueryString(formObj));
    		
    		   			var fletCtrtTpCd = ComGetEtcData(sXml, "fletCtrtTpCd");
    		   			
    		   			if(typeof fletCtrtTpCd != "undefined" && fletCtrtTpCd != "" ) {
    		   				//formObj.flet_ctrt_tp_cd.value = fletCtrtTpCd;		//2017.05.15 contract type 콤보로 변경
    		   						
    		   				if(ComGetEtcData(sXml, "vndrNm") == "") {
    		   					formObj.ownr_cd.value = "";
    		   					formObj.ownr_nm.value = "";
    		   					cust_cnt_cd = "";
    		   					cust_seq = "";
    		   					
    		   				} else {
    		   					formObj.ownr_cd.value = ComGetEtcData(sXml, "vndrSeq");
    		   					formObj.ownr_nm.value = ComGetEtcData(sXml, "vndrNm");
    		   					
    		   					cust_cnt_cd = ComGetEtcData(sXml, "custCntCd");
    		   					cust_seq = ComGetEtcData(sXml, "custSeq"); 
    		   				}
    					}
    		   			
    		   			sheetObj.WaitImageVisible = true;
    		   			;
    	    		} else if (col == "eff_dt") {
    	    			
    	    			sheetObj.WaitImageVisible = false;
    	    			
    					formObj.f_cmd.value = SEARCH09;
    					
    		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do" , ComReplaceStr(FormQueryString(formObj),"-",""));
    		
    		   			var effDt = ComGetEtcData(sXml, "effDt");
    		   			var usdLoclXchRt = ComGetEtcData(sXml, "usdLoclXchRt");
    		   			
    		   			if(typeof effDt == "undefined" || effDt == "" ) {
    						formObj.eff_dt.value = "";
    						ComAlertFocus(formObj.eff_dt, ComGetMsg("FMS01565"));
    						return;
    						
    					} else {
    						if(sheetObj.rowCount > 0) {
    							for(var ir=1; ir<=sheetObj.LastRow; ir++) {
    								sheetObj.CellValue(ir,"slp_eff_dt") = formObj.eff_dt.value;
    							}
    						}
    						
    						pre_eff_dt = form.eff_dt.value;
    		   				//formObj.slp_desc.value = "Hire Settlement "+formObj.vsl_cd.value + " " + formObj.eff_dt.value.substring(0,7);
    		   				//ComBtnEnable("btn_retrieve");
    					}
    		   			
    		   			if(typeof usdLoclXchRt != "undefined" && usdLoclXchRt != "" ) {
    		   				formObj.usd_locl_xch_rt.value = usdLoclXchRt;
    		   				
    					}
    		   			
    		   			sheetObj.WaitImageVisible = true;
    		   			
    	    		} else if (col == "acct_cd") {
    	    			
    	    			sheetObj.WaitImageVisible = false;
    	    			
    	    			var acctCdCol = sheetObj.SaveNameCol("acct_cd");
    	    			
    	    			var curr_cd = formObj.csr_curr_cd.value;
    	    			
    	    			if(curr_cd != "KRW") {
    	    				if(formObj.chk_acct_cd.value == "111811") {
    	    					ComShowCodeMessage('FMS01475');
    	    					
    	    					sheetObj.CellValue2(row,acctCdCol) = "";
    		   					sheetObj.SelectCell(row,acctCdCol);
    		   					
    		   					return false;
    	    				}
    	    			}
    	    			
    					formObj.f_cmd.value = SEARCH01;
    					
    		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0069GS.do" , FormQueryString(formObj)+"&acct_cd="+formObj.chk_acct_cd.value);
    		
    		   			var cdName = ComGetEtcData(sXml, "cdName");
    		   			
    		   			//var prefix = "inv_";
	   					//var acctCdCol = sheetObj.SaveNameCol("acct_cd");
	   					
    		   			if(typeof cdName == "undefined" || cdName == "" ) {
    		   				ComShowCodeMessage('FMS01336');
		   					
		   					sheetObj.CellValue2(row,acctCdCol) = "";
		   					sheetObj.SelectCell(row,acctCdCol);
		   					
    					} else {
    						var acct_cd = sheetObj.CellValue(row,acctCdCol);
    						
    						//if(acct_cd == "956115") {
    							//sheetObj.CellEditable(row, "bunker_vvd") = false;
    						//} else {
    							// 계정 항차 레벨 검사(Account 별 VVD Level Check)
    	    					// 해당 계정에 대한 항차 입력 여부 판단
    							if(checkAcctCdVvdLevelMdt(sheetObj, row)) {
    	    						sheetObj.CellEditable(row, "bunker_vvd") = false;
    	    						sheetObj.CellValue2(row,"bunker_vvd") = "";
    	    					} else {
    	    						if(checkAcctCdVvdLevel(sheetObj, row)) {
	    	    						sheetObj.CellEditable(row, "bunker_vvd") = true;
	    	    						sheetObj.CellValue2(row,"bunker_vvd") = "";
    	    						} else {
    	    							sheetObj.CellEditable(row, "bunker_vvd") = false;
	    	    						sheetObj.CellValue2(row,"bunker_vvd") = "";
    	    						}
    	    					}
    						//}
    						
    						// Key Number 체크
    						if(checkKeyNumber(sheetObj, acct_cd)) {
    							sheetObj.CellEditable(row, "key_number") = true;
    							sheetObj.CellValue2(row,"key_flg") = "Y";
    						} else {
    							sheetObj.CellEditable(row, "key_number") = false;
    							sheetObj.CellValue2(row,"key_flg") = "";
    						}
    					}
				
						sheetObj.WaitImageVisible = true;
    		   			
    	    		} else if (col == "ctr_cd") {
    	    			
    	    			sheetObj.WaitImageVisible = false;
    	    			
    					formObj.f_cmd.value = SEARCH01;
    					
    		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0021GS.do" , FormQueryString(formObj)+"&acct_cd="+formObj.chk_acct_cd.value);
    		
    		   			var slpLocCd = ComGetEtcData(sXml, "slpLocCd");
    		   			
    		   			//var prefix = "inv_";
	   					var ctrCdCol = sheetObj.SaveNameCol("ctr_cd");
	   					var slpLocCdCol = sheetObj.SaveNameCol("slp_loc_cd");
	   					
    		   			if(typeof slpLocCd == "undefined" || slpLocCd == "" ) {
    		   				ComShowCodeMessage('FMS01441');
		   					
		   					sheetObj.CellValue2(row,slpLocCdCol) = "";
		   					sheetObj.CellValue2(row,ctrCdCol) = "";
		   					sheetObj.SelectCell(row,ctrCdCol);
    					} else {
    						sheetObj.CellValue2(row,slpLocCdCol) = slpLocCd;
    					}
    		   			
    		   			sheetObj.WaitImageVisible = true;
    		   			
    	    		} else if (col == "bunker_vvd") {
    	    			
    	    			sheetObj.WaitImageVisible = false;
    	    			
    					formObj.f_cmd.value = SEARCH13;
    					
    					var acct_cd = "";
    					
    					// 계정 항차 레벨 검사(Account 별 VVD Level Check)
    					if(checkAcctCdVvdLevel(sheetObj, row)) {
    						//acct_cd = formObj.chk_acct_cd.value;
    						acct_cd = sheetObj.CellValue(row, "acct_cd");   //2017.07.17 해당 row 의 acct_cd 로 변경
    					}
    					
    					var vvd_cd = sheetObj.CellValue(row, "bunker_vvd");
    					
    		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do" , FormQueryString(formObj)+"&acct_cd="+acct_cd+"&vvd_cd="+vvd_cd);
    		
    		   			//var bunkerVvd = ComGetEtcData(sXml, "bunkerVvd");
    		   			
    		   			var bunkerVvd = ComGetEtcData(sXml, "vslCd");
    		   			
    		   			//var prefix = "inv_";
	   					var bunkerVvdCol = sheetObj.SaveNameCol("bunker_vvd");
	   					
	   					if(acct_cd != "") {
	   						if(typeof bunkerVvd == "undefined" || bunkerVvd == "" ) {
	    		   				ComShowCodeMessage('FMS01443');
			   					
			   					sheetObj.CellValue2(row,bunkerVvdCol) = "";
			   					sheetObj.SelectCell(row,bunkerVvdCol);
	    					} else {
		   						if(parseInt(bunkerVvd) < 2) {
		   							ComShowCodeMessage('FMS01473');
				   					
		   							//sheetObj.CellEditable(row, "bunker_vvd") = false;
				   					sheetObj.CellValue2(row,bunkerVvdCol) = "";
				   					sheetObj.SelectCell(row,bunkerVvdCol);
		   						}
	    					}
	   						
	   					} else {
	    		   			if(typeof bunkerVvd == "undefined" || bunkerVvd == "" ) {
	    		   				ComShowCodeMessage('FMS01443');
			   					
			   					sheetObj.CellValue2(row,bunkerVvdCol) = "";
			   					sheetObj.SelectCell(row,bunkerVvdCol);
	    					}
	   					}
	   					
	   					sheetObj.WaitImageVisible = true;
    		   		
    	    		} else if(col == "ComCd") {		//2017.05.15 contract type 콤보로 변경
    					
    					sheetObj.WaitImageVisible = false;
    					
    					formObj.f_cmd.value = SEARCH04;
    					
    		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0001GS.do" , FormQueryString(formObj));
    		   			
    		   			var fletCtrtTpCd   = ComGetEtcData(sXml, "fletCtrtTpCd");
    		   			var fletCtrtTpNm   = ComGetEtcData(sXml, "fletCtrtTpNm");
    		   			
    		   			if(typeof fletCtrtTpCd != "undefined" && fletCtrtTpCd != "") {
    	    				var comboCode = fletCtrtTpCd;
    	    				var comboText = fletCtrtTpNm;

    	    				setDataCombo(comboObjects[0], comboText, comboCode);
    	    			}
    		   			
    		   			sheetObj.WaitImageVisible = true;
    		   			
                	} else {
    	        		
    	        		sheetObj.WaitImageVisible = false;
    	        		
    	        		formObj.f_cmd.value = SEARCH10;
    	        		
    		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do" , FormQueryString(formObj));

    		   			var apCtrCd = ComGetEtcData(sXml, "apCtrCd");
    		   			var locCd = ComGetEtcData(sXml, "locCd");
    		   			
    		   			// Center Code Setting
    		   			if(typeof apCtrCd != "undefined" && apCtrCd != "" ) {
    		   				formObj.ap_ctr_cd.value = apCtrCd;
    		   				
    					} 
    		   			
    		   			// City Code Setting
    		   			if(typeof locCd != "undefined" && locCd != "" ) {
    						formObj.loc_cd.value = locCd;
    					}
    		   			
    		   			sheetObj.WaitImageVisible = true;
    	        	}

				case IBINSERT:      // 입력
                	break;
                	
				case IBSEARCH_ASYNC02: //선박 대 계약 자동 매치				
					if(formObj.vsl_cd.value == "") return;				
					var f_query = "";					
					f_query += "f_cmd=" + SEARCH01; 
					f_query += "&vsl_cd="+formObj.vsl_cd.value;	 			
					f_query += "&type_flag="+gFletCtrtTpCdAll; 
					
					var sXml = sheetObj.GetSearchXml("FMS_COMGS.do",f_query);

		   			var varFletCtrtNo = ComGetEtcData(sXml, "flet_ctrt_no");
		   			var varFletCtrtTpCd = ComGetEtcData(sXml, "flet_ctrt_tp_cd");		//2017.05.15 contract type 콤보로 변경
		   			
		   			if(typeof varFletCtrtNo != "undefined" && varFletCtrtNo != "" ) {
						formObj.flet_ctrt_no.value = varFletCtrtNo;
						formObj.flet_ctrt_tp_cd.Code2 = varFletCtrtTpCd;		//2017.05.15 contract type 콤보로 변경
					}else{
						ComShowCodeMessage("FMS20001","Agreement");
						clearAll();
						return;
					}
					if(formObj.flet_ctrt_no.value != ""){
						contract_no_change();
					}
					break;	
					
				case "IBSEARCHGL":
					formObj.f_cmd.value = SEARCH14;
					var sXml = sheetObj.GetSearchXml("ESM_FMS_0095GS.do", ComReplaceStr(FormQueryString(formObj), "-", ""));
					
					var effDt = ComGetEtcData(sXml, "effDt");
					
					formObj.eff_dt.value = effDt;
					break;		
        }
    }
    
	function createOlayComm(){
    	
   		var formObj = document.form;
   		
   		formObj.f_cmd.value = MULTI;
   		
   		var param = "f_cmd="+ formObj.f_cmd.value;
   		
   		param += "&" + "slp_tp_cd=20" + "&" + "slp_func_cd=T" + "&" + "slp_ofc_cd=" + formObj.slp_ofc_cd.value;
   		
   		param += "&" + "slp_iss_dt=" + formObj.slp_iss_dt.value;
   		param += "&" + "flet_ctrt_no=" + formObj.flet_ctrt_no.value;
   		param += "&" + "csr_curr_cd=" + formObj.csr_curr_cd.value;
   		param += "&" + "rqst_amt=0";
   		param += "&" + "csr_desc=" + formObj.vsl_cd.value + " O/A, OUTLAY COMM";
   		param += "&" + "eff_dt=" + formObj.eff_dt.value.trimAll('-');
   		param += "&" + "apro_step=" + formObj.apro_step.value;
   		//param += "&" + "vvd_cd=" + "CNTC" + form.eff_dt.value.trimAll('-').substring(2,6) + "MM";
   		
   		param += "&" + "cre_usr_id=" + formObj.usr_id.value;
   		
   		param += "&" + ComFmsSetPrifix(sheetObjects[4].GetSaveString(),"sheet1_");
		var sXml = sheetObjects[0].GetSaveXml("ESM_FMS_0032GS.do", param);
		//sheetObj.LoadSaveXml(sXml);
   		ar_olay_rt_amt = 0;  //초기화
   		
   		ar_csr_no = ComGetEtcData(sXml, "ar_csr_no");
   		
		//alert("ar_olay_rt_amt > 0 ? [ " + ar_olay_rt_amt + " ]");
   		ComOpenWait(false);
    }
	
    /**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl() {
    	//** Date 구분자 **/
    	DATE_SEPARATOR = "-";
     	
    	//Axon 이벤트 처리1. 이벤트catch
    	//2010.11.24 이상민 [CHM-201007233-01] vsl_cd 는 engnum_keypress로 변경
        axon_event.addListener  ('keypress', 'eng_num_keypress'   , 'vsl_cd');
        axon_event.addListener  ('change'  , 'vsl_cd_change'     , 'vsl_cd');		//Vessel Code 입력 후 Name정보 가져오기
        axon_event.addListener  ('keypress', 'eng_num_keypress'  , 'csr_no');
        axon_event.addListener  ('change'  , 'csr_curr_cd_change', 'csr_curr_cd');	//- Currency Code 입력 후 Name 정보 가져오기
        axon_event.addListener  ('click'   , 'slp_tp_click'   	 , 'slp_tp');		//Vessel Code 입력 후 Name정보 가져오기
        
        axon_event.addListenerForm  ('blur'			   , 'obj_deactivate', form); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
        axon_event.addListenerFormat('beforeactivate'  , 'obj_activate'  , form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate(focus)이벤트에 코드 처리
        axon_event.addListenerFormat('keypress'        , 'obj_keypress'  , form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
        
        //doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH);
        
        //CoFmsGetCombo('FORM', document.form, sheetObjects[0], 'CD01745', 'evid_tp_cd', 'evid_tp_nm');
        
        setCsrDate();
        setCurDate();
        
        //Payments Slip Preview Button Disable 하기
		ComBtnDisable("btn_preview");
		
		//Payments Slip Print Button Disable 하기
		ComBtnDisable("btn_print");
		
		//Payments Slip HireStatement Button Disable 하기
		ComBtnDisable("btn_hireStatement");
		
		//Payments Slip TaxEvidence Button Disable 하기
		ComBtnDisable("btn_taxEvidence");
		
		//form.evid_tp_cd.selectedIndex = 2;
		
		//setEvidenceType();
		
		
    }
    
    /**
     * Request Date & G/L Date에 오늘 일자 세팅
     */
    function setCurDate() {
    	var now = new Date();

    	var y = now.getYear() + "";
    	var M = now.getMonth() + 1;
    	if (M < 10)
    		M = '0' + M;
    	var d = now.getDate();
    	if (d < 10)
    		d = '0' + d;

    	document.form.rqst_dt.value = ComGetMaskedValue(y + M + d, "ymd");
    	document.form.eff_dt.value = ComGetMaskedValue(y + M + d, "ymd");
    }
    
    //Axon 이벤트 처리2. 이벤트처리함수 --- start
    
    /**
     * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
     **/
    function obj_keypress(){
    	switch(event.srcElement.dataformat){
			case "int":
		        //숫자 만입력하기
		        ComKeyOnlyNumber(event.srcElement);
				break;
			case "float":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
			case "engup":
	            ComKeyOnlyAlphabet('upper');
	            break;
			default:
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
    	}
    }
    
    /**
     * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
     **/
    function eng_keypress() {
        //영대문자 자동변환
        ComKeyOnlyAlphabet('upper');
    }
    
    /**
     * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
     **/
    function eng_num_keypress() {
        //영대문자 자동변환
        ComKeyOnlyAlphabet('uppernum');
    }
    
    /**
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_deactivate(){
    	
        //입력Validation 확인하기
    	switch(event.srcElement.name){
	    	case "rqst_dt": 
	    	case "eff_dt": 
	    		
	    		ComChkObjValid(event.srcElement);
	    		
	    		if (event.srcElement.name == 'eff_dt') {
	    			if(pre_eff_dt == form.eff_dt.value) return;
	    			
	     	    	eff_dt_change();
	     	    } else if(event.srcElement.name == 'rqst_dt') {
	     	    	if(parseInt(form.rqst_dt.value.trimAll('-')) < parseInt(form.slp_iss_dt.value.trimAll('-'))) {
	     	    		form.rqst_dt.value = "";
	     	    		ComAlertFocus(form.rqst_dt, ComGetMsg("FMS01438"));
	     	    		return;
	     	    	}
	     	    }
	    		
    			break;
    	}
    }

    /**
     * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
     **/
    function obj_activate(){
    	//마스크구분자 없애기
    	ComClearSeparator(event.srcElement);
    }
     
    /**
     * VslCd변경 시 해당 Name 을 가져온다. <br>
     **/
    function vsl_cd_change() {
    	form.vsl_eng_nm.value = "";
    	form.flet_ctrt_no.value = "";
    	
     	if (form.vsl_cd.value != "" && form.vsl_cd.value.trim().length == 4) {
     		doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'vsl_cd');
     	} else {
     		form.vsl_cd.value = "";
     		ComAlertFocus(form.vsl_cd, ComGetMsg("FMS01231"));
     	}
    }
    
    /**
      * IBSheet 입력값 중 Currency Code값의 존재 여부를 판단하다. <br>
      * @return {없음}
      **/
     function csr_curr_cd_change() {
    	  
     	if(form.csr_curr_cd.value.trim().length == 3) {
    		doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'csr_curr_cd');
    		
     	} else {
     		if(form.csr_curr_cd.value != "") {
     			form.csr_curr_cd.value = "";
     			ComAlertFocus(form.csr_curr_cd, ComGetMsg("FMS01077"));
     		}
     	}
 	}
      
    /**
     * Effective Date 변경 시 체크한다. <br>
     **/
    function eff_dt_change() {
    	if (form.eff_dt.value != "" && ComIsDate(form.eff_dt.value)) {
    		doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'eff_dt');
      	}
    }
    
    /**
     * Slip Type 선택시 Prepayments Button 을 제어한다 <br>
     * @return {없음}
     **/
    function slp_tp_click() {
    	//Payments Slip TaxEvidence Button Disable 하기
 		ComBtnDisable("btn_taxEvidence");
 		ComBtnEnable("btn_charterersExp");
		ComBtnEnable("btn_offhireExp");
		ComBtnEnable("btn_ownersAccount");
				
    	if(form.slp_tp[0].checked) {
    		//sheetObjects[0].RemoveAll();
    		
    		//form.evid_tp_cd.selectedIndex = 2;

    		if(   form.flet_ctrt_no.value != ""
    		   && form.flet_ctrt_no.value.substring(4,6) == 'TO') {
	    		setEvidenceType();
	    		
	    		formReset();
    		} else {
    			setEvidenceType();
	    		
	    		//Payments Slip Prepayments Button Enable 하기
	    		ComBtnEnable("btn_prepayments");
	    		
	    		
	    		// Total Amount Setting 하기
	    		setTotalAmount();
    		}
    	} else if (form.slp_tp[1].checked){
    		form.pre_work_flag.value == "";
    		
    		//form.evid_tp_cd.selectedIndex = 2;
    		
    		setEvidenceType();
    		
    		//sheetObjects[0].RemoveAll();
    		
    		//Payments Slip Prepayments Button  하기
    		ComBtnDisable("btn_prepayments");
    		
    		
    		// Total Amount Setting 하기
    		setTotalAmount();
    	//2010.08.13 nonbubble 추가 => 
    	} else if (form.slp_tp[2].checked){
    		form.pre_work_flag.value == "";
    		
    		//form.evid_tp_cd.selectedIndex = 2;
    		
    		setEvidenceType();
    		
    		//sheetObjects[0].RemoveAll();
    		
    		//Payments Slip Prepayments Button  하기
    		ComBtnDisable("btn_prepayments");
    		
			
    		// Total Amount Setting 하기
    		setTotalAmount();
    	
    	// 2012.05.30. 추가
	    } else if (form.slp_tp[3].checked){
			form.pre_work_flag.value == "";
						
			setEvidenceType();	
			
			ComBtnDisable("btn_prepayments");
			ComBtnDisable("btn_charterersExp");
			ComBtnDisable("btn_offhireExp");
			ComBtnDisable("btn_ownersAccount");
			
			ComBtnEnable("btn_bodBor");
			ComBtnEnable("btn_rowAdd");
			ComBtnEnable("btn_rowDel");	
		
			// Total Amount Setting 하기
			setTotalAmount();
		}
    	
    	sheetObjects[0].RemoveAll();
    	sheetObjects[1].RemoveAll();
    	sheetObjects[2].RemoveAll();
    	
    	form.csr_curr_cd.readOnly = false;
    	form.evid_tp_cd.disabled = false;
    	
    }
     
    /**
 	 * CSR Date에 오늘 일자 세팅
 	 */
 	function setCsrDate() {
         var now=new Date();

         var y=now.getYear()+"";
         var M=now.getMonth()+1;
         if (M < 10) M = '0'+M;
         var d=now.getDate();
         if (d < 10) d = '0'+d;

         document.form.slp_iss_dt.value = ComGetMaskedValue(y+M+d, "ymd");
 	}
     
    //Axon 이벤트 처리2. 이벤트처리함수 --- end
    
    /**
	  * Vessel Code 입력부분.<br>
	  * @param {arry} aryPopupData
	  */
	function setVslCd(aryPopupData){
		axon_event.removeListener('vsl_cd', 'change', 'vsl_cd_change');
		form.vsl_cd.value = aryPopupData[0][2];
		form.vsl_eng_nm.value = aryPopupData[0][3];
		axon_event.addListener  ('change', 'vsl_cd_change', 'vsl_cd');			//Vessel Code 입력 후 Name정보 가져오기
		
		form.flet_ctrt_no.value = "";
		
		//선박 대 계약 자동 매치
		if(form.vsl_cd.value != ""){
			vsl_cd_change();
		}
		//form.vsl_cd.readOnly = true;
		//form.btn_vslpop.style.cursor = "default";
		//document.images["btn_vslpop"].name = "no_btn_vslpop";
	}

	/**
	 * Contract No 입력부분.<br>
	 * @param {arry} aryPopupData
	 */
	function setContractNo(aryPopupData){
		form.flet_ctrt_no.value = aryPopupData[0][3];
		form.flet_ctrt_tp_cd.Code2 = aryPopupData[0][5];	//2017.05.15 contract type 콤보로 변경
		contract_no_change();
	}
	 
	/**
	 * Prepayments 입력부분.<br>
	 * @param {arry} aryPopupData
	 */
	function setPrepayments(aryPopupData) {
		// P 전표인 경우 Prepayments 데이타가 선택되었는지 체크하기 위한 FLAG값 
		form.pre_work_flag.value = "1";
		
		var row = sheetObjects[0].DataInsert(-1);
		
		form.ppay_hir_no.value = aryPopupData[0].ppay_hir_no;
		form.slp_desc.value = aryPopupData[0].acct_desc;
		
		sheetObjects[0].CellEditable(row, "DelChk") = false;
		sheetObjects[0].CellValue2(row,"acct_cd") = "111431";
		sheetObjects[0].CellValue2(row,"ctr_cd") = aryPopupData[0].ctr_cd;
		sheetObjects[0].CellValue2(row,"slp_loc_cd") = aryPopupData[0].slp_loc_cd;
		sheetObjects[0].CellValue2(row,"vndr_seq") = form.ownr_cd.value;
		sheetObjects[0].CellValue2(row,"slp_eff_dt") = form.eff_dt.value;
		sheetObjects[0].CellValue2(row,"csr_amt") = aryPopupData[0].inv_amt_sum;
		sheetObjects[0].CellValue2(row,"csr_desc") = aryPopupData[0].acct_desc;
		
		//sheetObjects[0].CellValue2(row,"flet_ctrt_no") = form.flet_ctrt_no.value;
		sheetObjects[0].CellValue2(row,"flet_ctrt_no") = aryPopupData[0].flet_ctrt_no;
		sheetObjects[0].CellValue2(row,"inv_seq") = aryPopupData[0].inv_seq;
		sheetObjects[0].CellValue2(row,"inv_dtl_seq") = aryPopupData[0].inv_dtl_seq;
		sheetObjects[0].CellValue2(row,"flet_src_tp_cd") = aryPopupData[0].flet_src_tp_cd;
		sheetObjects[0].CellValue2(row,"flet_iss_tp_cd") = aryPopupData[0].flet_iss_tp_cd;
		sheetObjects[0].CellValue2(row,"eff_dt") = aryPopupData[0].eff_dt;
		sheetObjects[0].CellValue2(row,"exp_dt") = aryPopupData[0].exp_dt;
		sheetObjects[0].CellValue2(row,"curr_cd") = form.csr_curr_cd.value;
				
		setTotalAmount('S');

		// --------------------------
		// Grid Font 설정하기
		// --------------------------
		setCellFont(sheetObjects[0], row);
		
		//Payments Slip Prepayments Button  하기
		ComBtnDisable("btn_prepayments");
		
		setOffhireExp2();
	}
	 
	/**
 	 * Charterers Account PopUp창에서 조회한 데이터를 설정한다.
 	 * @param {arry} aryPopupData
 	 */
 	function setCharterersExp(aryPopupData) {

 		//sheetObjects[0].RemoveAll();

		for(var i=0; i<aryPopupData.length; i++) {
			var charterExpData = aryPopupData[i];
			var row = sheetObjects[0].DataInsert(-1);

			sheetObjects[0].CellValue2(row,"acct_nm") = charterExpData.acct_nm;
			sheetObjects[0].CellValue2(row,"acct_cd") = charterExpData.acct_cd;
			sheetObjects[0].CellValue2(row,"vndr_seq") = form.ownr_cd.value;
			sheetObjects[0].CellValue2(row,"ctr_cd") = charterExpData.ctr_cd;
			sheetObjects[0].CellValue2(row,"slp_loc_cd") = charterExpData.slp_loc_cd;
			sheetObjects[0].CellValue2(row,"slp_eff_dt") = form.eff_dt.value;
			sheetObjects[0].CellValue2(row,"curr_cd") = charterExpData.curr_cd;
			if(charterExpData.chtr_pay_rcv_cd == "Charterer") {
				sheetObjects[0].CellValue2(row,"csr_amt") = charterExpData.inv_amt;	
			} else {
				sheetObjects[0].CellValue2(row,"csr_amt") = charterExpData.inv_amt * -1;	
			}
			sheetObjects[0].CellValue2(row,"bunker_vvd") = charterExpData.vvd_bunker;
			sheetObjects[0].CellValue2(row,"csr_desc") = charterExpData.inv_desc;
			sheetObjects[0].CellValue2(row,"flet_iss_tp_cd") = charterExpData.flet_iss_tp_cd;
			sheetObjects[0].CellValue2(row,"flet_ctrt_no") = charterExpData.flet_ctrt_no;
			//sheetObjects[0].CellValue2(row,"flet_ctrt_no") = form.flet_ctrt_no.value;
			sheetObjects[0].CellValue2(row,"inv_seq") = charterExpData.inv_seq;
			sheetObjects[0].CellValue2(row,"inv_dtl_seq") = charterExpData.inv_dtl_seq;
			sheetObjects[0].CellValue2(row,"flet_src_tp_cd") = charterExpData.flet_src_tp_cd;
			sheetObjects[0].CellValue2(row,"org_flet_ctrt_no") = charterExpData.flet_ctrt_no;
			sheetObjects[0].CellValue2(row,"pop_gb") = "CHT";
			
			// Key Number 체크
			if(checkKeyNumber(sheetObjects[0], charterExpData.acct_cd)) {
				sheetObjects[0].CellEditable(row, "key_number") = true;
				sheetObjects[0].CellValue2(row,"key_flg") = "Y";
			}
			
			// --------------------------
			// Grid Font 설정하기
			// --------------------------
			setCellFont(sheetObjects[0], row);
		}
		
		setTotalAmount('S');
 	}
 	 
    /**
  	 * Offhire Expenses PopUp창에서 조회한 데이터를 설정한다.
  	 * @param {arry} aryPopupData
  	 */
  	function setOffhireExp(aryPopupData) {

 		for(var i=0; i<aryPopupData.length; i++) {
 			var offhireExpData = aryPopupData[i];
 			var row = sheetObjects[0].DataInsert(-1);

 			sheetObjects[0].CellValue2(row,"acct_nm") = offhireExpData.acct_nm;
 			sheetObjects[0].CellValue2(row,"acct_cd") = offhireExpData.acct_cd;
 			sheetObjects[0].CellValue2(row,"vndr_seq") = form.ownr_cd.value;
 			sheetObjects[0].CellValue2(row,"ctr_cd") = offhireExpData.ctr_cd;
 			sheetObjects[0].CellValue2(row,"slp_loc_cd") = offhireExpData.slp_loc_cd;
 			sheetObjects[0].CellValue2(row,"slp_eff_dt") = form.eff_dt.value;
 			sheetObjects[0].CellValue2(row,"curr_cd") = offhireExpData.curr_cd;
 			sheetObjects[0].CellValue2(row,"csr_amt") = -offhireExpData.inv_amt;	
 			sheetObjects[0].CellValue2(row,"bunker_vvd") = offhireExpData.vvd_bunker;
 			sheetObjects[0].CellValue2(row,"csr_desc") = offhireExpData.inv_desc;
 			sheetObjects[0].CellValue2(row,"flet_iss_tp_cd") = offhireExpData.flet_iss_tp_cd;
 			sheetObjects[0].CellValue2(row,"flet_ctrt_no") = offhireExpData.flet_ctrt_no;
 			//sheetObjects[0].CellValue2(row,"flet_ctrt_no") = form.flet_ctrt_no.value;
 			sheetObjects[0].CellValue2(row,"inv_seq") = offhireExpData.inv_seq;

 			sheetObjects[0].CellValue2(row,"inv_dtl_seq") = offhireExpData.inv_dtl_seq;
 			sheetObjects[0].CellValue2(row,"flet_src_tp_cd") = offhireExpData.flet_src_tp_cd;
 			
 			sheetObjects[0].CellValue2(row,"eff_dt") = offhireExpData.eff_dt;
 			sheetObjects[0].CellValue2(row,"exp_dt") = offhireExpData.exp_dt;
 			sheetObjects[0].CellValue2(row,"org_flet_ctrt_no") = offhireExpData.flet_ctrt_no;
 			sheetObjects[0].CellValue2(row,"pop_gb") = "OFF";
 			
 			// Key Number 체크
 			if(checkKeyNumber(sheetObjects[0], offhireExpData.acct_cd)) {
				sheetObjects[0].CellEditable(row, "key_number") = true;
				sheetObjects[0].CellValue2(row,"key_flg") = "Y";
			}
 			
 			// --------------------------
 			// Grid Font 설정하기
 			// --------------------------
 			setCellFont(sheetObjects[0], row);
 		}
 		
 		setTotalAmount('S');
  	}
 
    /**
  	 * Offhire Expenses  조회한 데이터를 설정한다.
  	 * @param {arry} aryPopupData
  	 */
  	function setOffhireExp2() {

		form.f_cmd.value = SEARCH;
		sheetObjects[5].DoSearch("ESM_FMS_0026GS.do" , FormQueryString(form));
		
		ComBtnDisable("btn_offhireExp");
		
		if (sheetObjects[5].rowCount == 0) {
			return;
		}
			
 		for(var i = 1; i<sheetObjects[5].rowCount+1; i++) {
 			var row = sheetObjects[0].DataInsert(-1);
 			
 			sheetObjects[0].CellValue2(row,"acct_nm") = sheetObjects[5].CellValue(i,"acct_nm");
 			sheetObjects[0].CellValue2(row,"acct_cd") = sheetObjects[5].CellValue(i,"acct_cd");
 			sheetObjects[0].CellValue2(row,"vndr_seq") = form.ownr_cd.value;
 			sheetObjects[0].CellValue2(row,"ctr_cd") = sheetObjects[5].CellValue(i,"ctr_cd");
 			sheetObjects[0].CellValue2(row,"slp_loc_cd") = sheetObjects[5].CellValue(i,"slp_loc_cd");
 			sheetObjects[0].CellValue2(row,"slp_eff_dt") = sheetObjects[5].CellValue(i,"eff_dt");
 			sheetObjects[0].CellValue2(row,"curr_cd") = sheetObjects[5].CellValue(i,"curr_cd");
 			sheetObjects[0].CellValue2(row,"csr_amt") = -sheetObjects[5].CellValue(i,"inv_amt");
 			sheetObjects[0].CellValue2(row,"bunker_vvd") = sheetObjects[5].CellValue(i,"vvd_bunker");
 			sheetObjects[0].CellValue2(row,"csr_desc") = sheetObjects[5].CellValue(i,"inv_desc");
 			
 			sheetObjects[0].CellValue2(row,"flet_iss_tp_cd") = sheetObjects[5].CellValue(i,"flet_iss_tp_cd");
 			sheetObjects[0].CellValue2(row,"flet_ctrt_no") = sheetObjects[5].CellValue(i,"flet_ctrt_no");
 			sheetObjects[0].CellValue2(row,"inv_seq") = sheetObjects[5].CellValue(i,"inv_seq");
 			sheetObjects[0].CellValue2(row,"inv_dtl_seq") = sheetObjects[5].CellValue(i,"inv_dtl_seq");
 			sheetObjects[0].CellValue2(row,"flet_src_tp_cd") = sheetObjects[5].CellValue(i,"flet_src_tp_cd");
 			sheetObjects[0].CellValue2(row,"eff_dt") = sheetObjects[5].CellValue(i,"eff_dt");
 			sheetObjects[0].CellValue2(row,"exp_dt") = sheetObjects[5].CellValue(i,"exp_dt");
 			sheetObjects[0].CellValue2(row,"org_flet_ctrt_no") = sheetObjects[5].CellValue(i,"flet_ctrt_no");
 			sheetObjects[0].CellValue2(row,"pop_gb") = "OFF";
 			
 			// Key Number 체크
 			if(checkKeyNumber(sheetObjects[0], sheetObjects[5].CellValue(i,"acct_cd"))) {
				sheetObjects[0].CellEditable(row, "key_number") = true;
				sheetObjects[0].CellValue2(row,"key_flg") = "Y";
			}
 			
 			// --------------------------
 			// Grid Font 설정하기
 			// --------------------------
 			setCellFont(sheetObjects[0], row);
 		}
		
 		setTotalAmount('S');
  	}
  	
  	/**
 	 * Owner’s Account PopUp창에서 조회한 데이터를 설정한다.
 	 * @param {arry} aryPopupData
 	 */  	
// 	function setOwnersAccount(aryPopupData) {
// 		
// 		var olay_amt = 0;
// 		var olay_rt_amt = 0;
// 		var n1st_amt_sum = 0;
// 		var manhour_ch_amt = 0;
//
// 		if((cust_cnt_cd == "" || cust_seq == "") && aryPopupData[0].flet_olay_comm_rt_amt > 0) {
//
//  			ComShowCodeMessage("FMS20002");
//  			return;
//  		}
//  		
//		for(var i=0; i<aryPopupData.length; i++) {
//			var ownersAccountData = aryPopupData[i];
//			var row = sheetObjects[0].DataInsert(-1);
//
//			sheetObjects[0].CellValue2(row,"acct_nm") = ownersAccountData.acct_nm;
//			sheetObjects[0].CellValue2(row,"acct_cd") = ownersAccountData.acct_cd;
//			sheetObjects[0].CellValue2(row,"vndr_seq") = form.ownr_cd.value;
//			sheetObjects[0].CellValue2(row,"ctr_cd") = ownersAccountData.ctr_cd;
//			sheetObjects[0].CellValue2(row,"slp_loc_cd") = ownersAccountData.slp_loc_cd;
//			
//			if(i == 0) {
//				olay_rt_amt = ownersAccountData.flet_olay_comm_rt_amt;
//			}
//			
//			sheetObjects[0].CellValue2(row,"slp_eff_dt") = form.eff_dt.value;
//			sheetObjects[0].CellValue2(row,"curr_cd") = ownersAccountData.curr_cd;
//			sheetObjects[0].CellValue2(row,"csr_amt") = -ownersAccountData.n1st_amt;	
//			sheetObjects[0].CellValue2(row,"bunker_vvd") = ownersAccountData.vvd_bunker;
//			sheetObjects[0].CellValue2(row,"csr_desc") = ownersAccountData.ap_desc;
//			sheetObjects[0].CellValue2(row,"flet_src_tp_cd") = ownersAccountData.flet_src_tp_cd;
//			sheetObjects[0].CellValue2(row,"ap_slp_tp_cd") = ownersAccountData.slp_tp_cd;
//			sheetObjects[0].CellValue2(row,"ap_slp_func_cd") = ownersAccountData.slp_func_cd;
//			sheetObjects[0].CellValue2(row,"ap_slp_ofc_cd") = ownersAccountData.slp_ofc_cd;
//			sheetObjects[0].CellValue2(row,"ap_slp_iss_dt") = ownersAccountData.slp_iss_dt;
//			sheetObjects[0].CellValue2(row,"ap_slp_ser_no") = ownersAccountData.slp_ser_no;
//			sheetObjects[0].CellValue2(row,"ap_slp_seq_no") = ownersAccountData.slp_seq_no;
//			
//			/*
//			sheetObjects[0].CellValue2(row,"slp_tp_cd") = ownersAccountData.slp_tp_cd;
//			sheetObjects[0].CellValue2(row,"slp_func_cd") = ownersAccountData.slp_func_cd;
//			sheetObjects[0].CellValue2(row,"slp_ofc_cd") = ownersAccountData.slp_;
//			sheetObjects[0].CellValue2(row,"slp_iss_dt") = ownersAccountData.slp_iss_dt;
//			sheetObjects[0].CellValue2(row,"slp_ser_no") = ownersAccountData.slp_ser_no;
//			sheetObjects[0].CellValue2(row,"slp_seq_no") = ownersAccountData.slp_seq_no;
//			*/
//			sheetObjects[0].CellValue2(row,"pop_gb") = "OWN";
//			
//			//sheetObjects[0].CellEditable(row, "key_number") = true;
//			
//			// --------------------------
//			// Grid Font 설정하기
//			// --------------------------
//			setCellFont(sheetObjects[0], row);
//			
//			n1st_amt_sum += -parseFloat(ownersAccountData.n1st_amt);
//			
//			manhour_ch_amt += parseFloat(ownersAccountData.manhour_ch);
//		}
//		
//		if(olay_rt_amt > 0) {
//			olay_amt = (n1st_amt_sum * olay_rt_amt / 100).toFixed(2);
//			
//			ar_olay_amt = olay_amt;
//			
//			ar_olay_rt_amt = olay_rt_amt;
//			
//			var ownersAccountData = aryPopupData[0];
//			var row = sheetObjects[0].DataInsert(-1);
//				
//			sheetObjects[0].CellValue2(row,"acct_nm") = ownersAccountData.acct_nm;
//			sheetObjects[0].CellValue2(row,"acct_cd") = "954113";  //"422011"
//			sheetObjects[0].CellValue2(row,"vndr_seq") = form.ownr_cd.value;
//			sheetObjects[0].CellValue2(row,"ctr_cd") = ownersAccountData.ctr_cd;
//			sheetObjects[0].CellValue2(row,"slp_loc_cd") = ownersAccountData.slp_loc_cd;
//			
//			sheetObjects[0].CellValue2(row,"slp_eff_dt") = form.eff_dt.value;
//			sheetObjects[0].CellValue2(row,"curr_cd") = ownersAccountData.curr_cd;
//			sheetObjects[0].CellValue2(row,"csr_amt") = olay_amt;	
//			//sheetObjects[0].CellValue2(row,"bunker_vvd") = "CNTC" + form.eff_dt.value.trimAll('-').substring(2,6) + "MM";
//			sheetObjects[0].CellValue2(row,"bunker_vvd") = "";
//			sheetObjects[0].CellValue2(row,"csr_desc") = "O/A, OUTLAY COMM";
//			sheetObjects[0].CellValue2(row,"flet_src_tp_cd") = "10";
//			
//			sheetObjects[0].CellValue2(row,"ap_slp_tp_cd") = ownersAccountData.slp_tp_cd;			
//			sheetObjects[0].CellValue2(row,"ap_slp_func_cd") = ownersAccountData.slp_func_cd;
//			sheetObjects[0].CellValue2(row,"ap_slp_ofc_cd") = ownersAccountData.slp_ofc_cd;
//			sheetObjects[0].CellValue2(row,"ap_slp_iss_dt") = ownersAccountData.slp_iss_dt;
//			sheetObjects[0].CellValue2(row,"ap_slp_ser_no") = ownersAccountData.slp_ser_no;
//			sheetObjects[0].CellValue2(row,"ap_slp_seq_no") = ownersAccountData.slp_seq_no;
//			
//			sheetObjects[0].CellValue2(row,"pop_gb") = "OWN";
//			
//			// --------------------------
//			// Grid Font 설정하기
//			// --------------------------
//			setCellFont(sheetObjects[0], row);
//			
//			//alert("aa")
//			setHireStatement(aryPopupData);
//		}
//		
//		if(manhour_ch_amt > 0) {
//			for(var i=0; i<aryPopupData.length; i++) {
//				var ownersAccountData = aryPopupData[i];
//				
//				if(parseFloat(ownersAccountData.manhour_ch) > 0) {
//					var row = sheetObjects[0].DataInsert(-1);
//					
//					sheetObjects[0].CellValue2(row,"acct_nm") = "Miscellaneous Income";
//					sheetObjects[0].CellValue2(row,"acct_cd") = "422011";
//					sheetObjects[0].CellValue2(row,"vndr_seq") = form.ownr_cd.value;
//					sheetObjects[0].CellValue2(row,"ctr_cd") = form.ap_ctr_cd.value;
//					sheetObjects[0].CellValue2(row,"slp_loc_cd") = form.loc_cd.value;
//					
//					sheetObjects[0].CellValue2(row,"slp_eff_dt") = form.eff_dt.value;
//					sheetObjects[0].CellValue2(row,"curr_cd") = ownersAccountData.curr_cd;
//					sheetObjects[0].CellValue2(row,"csr_amt") = -ownersAccountData.manhour_ch;	
//					sheetObjects[0].CellValue2(row,"bunker_vvd") = "CNTC" + form.eff_dt.value.trimAll('-').substring(2,6) + "MM";
//					sheetObjects[0].CellValue2(row,"csr_desc") = "(Manhour CHG) " + ownersAccountData.ap_desc;
//					sheetObjects[0].CellValue2(row,"flet_src_tp_cd") = "11";
//					
//					sheetObjects[0].CellValue2(row,"ap_slp_tp_cd") = ownersAccountData.slp_tp_cd;
//					sheetObjects[0].CellValue2(row,"ap_slp_func_cd") = ownersAccountData.slp_func_cd;
//					sheetObjects[0].CellValue2(row,"ap_slp_ofc_cd") = ownersAccountData.slp_ofc_cd;
//					sheetObjects[0].CellValue2(row,"ap_slp_iss_dt") = ownersAccountData.slp_iss_dt;
//					sheetObjects[0].CellValue2(row,"ap_slp_ser_no") = ownersAccountData.slp_ser_no;
//					sheetObjects[0].CellValue2(row,"ap_slp_seq_no") = ownersAccountData.slp_seq_no;
//					
//					sheetObjects[0].CellValue2(row,"pop_gb") = "OWN";
//					
//					// --------------------------
//					// Grid Font 설정하기
//					// --------------------------
//					setCellFont(sheetObjects[0], row);
//				}
//			}
//		}
//		
//		setTotalAmount('S');
// 	}
 	
 	/**
 	 * BOD, BOR Settlement PopUp창에서 조회한 데이터를 설정한다.
 	 * @param {arry} aryPopupData
 	 */
 	function setBodBor(aryPopupData) {
 		
        //자동생성 대체전표 생성 여부
 		var autoFlg = "N";
 		
 		if(   form.flet_ctrt_no.value.substring(4,6) == 'TO' 
 		   && confirm(ComGetMsg('FMS01477'))) {
 			autoFlg = "Y";
 		}
 		
		for(var i=0; i<aryPopupData.length; i++) {
			var bodBorData = aryPopupData[i];
			var row = sheetObjects[0].DataInsert(-1);

			sheetObjects[0].CellValue2(row,"acct_nm") = bodBorData.acct_nm;
			sheetObjects[0].CellValue2(row,"acct_cd") = bodBorData.acct_cd;
			sheetObjects[0].CellValue2(row,"vndr_seq") = form.ownr_cd.value;
			sheetObjects[0].CellValue2(row,"ctr_cd") = bodBorData.ctr_cd;
			sheetObjects[0].CellValue2(row,"slp_loc_cd") = bodBorData.slp_loc_cd;
			//sheetObjects[0].CellValue2(row,"flet_olay_comm_rt_amt") = ownersAccountData.flet_olay_comm_rt_amt;
			
			sheetObjects[0].CellValue2(row,"slp_eff_dt") = form.eff_dt.value;
			sheetObjects[0].CellValue2(row,"curr_cd") = bodBorData.curr_cd;
			
			//2017.07.13 Contract type 조건 추가
			if(form.flet_ctrt_no.value.substring(4,6) == 'TO') {
				if(bodBorData.bnk_tp_cd == "BOD") {
					sheetObjects[0].CellValue2(row,"csr_amt") = -bodBorData.bnk_amt;	
				} else {
					sheetObjects[0].CellValue2(row,"csr_amt") = bodBorData.bnk_amt;
				}
			} else {
				if(bodBorData.bnk_tp_cd == "BOD") {
					sheetObjects[0].CellValue2(row,"csr_amt") = bodBorData.bnk_amt;	
				} else {
					sheetObjects[0].CellValue2(row,"csr_amt") = -bodBorData.bnk_amt;
				}
			}
			
			//if(bodBorData.acct_cd == "951111") {
			/*
			if(bodBorData.acct_cd == "956115") {
				sheetObjects[0].CellValue2(row,"bunker_vvd") = "";
			} else {
				sheetObjects[0].CellValue2(row,"bunker_vvd") = bodBorData.vvd_bunker;
			}
			*/
			
			sheetObjects[0].CellValue2(row,"bunker_vvd") = bodBorData.vvd_bunker;
			
			sheetObjects[0].CellValue2(row,"csr_desc") = bodBorData.bnk_desc;
			sheetObjects[0].CellValue2(row,"flet_src_tp_cd") = bodBorData.flet_src_tp_cd;
			sheetObjects[0].CellValue2(row,"flet_ctrt_no") = bodBorData.flet_ctrt_no;
			sheetObjects[0].CellValue2(row,"bnk_seq") = bodBorData.bnk_seq;
			sheetObjects[0].CellValue2(row,"pop_gb") = "OIL";
			
			sheetObjects[0].CellEditable(row, "ctr_cd") = true;
			
			// Key Number 체크
			if(checkKeyNumber(sheetObjects[0], bodBorData.acct_cd)) {
				sheetObjects[0].CellEditable(row, "key_number") = true;
				sheetObjects[0].CellValue2(row,"key_flg") = "Y";
			}
			
			if(autoFlg == "Y") {
				sheetObjects[0].CellValue2(row,"auto_flg") = "Y";
			}
			
			// --------------------------
			// Grid Font 설정하기
			// --------------------------
			setCellFont(sheetObjects[0], row);
			
			if(autoFlg == "Y") {
				//for(var i=0; i<aryPopupData.length; i++) {
					//var bodBorData = aryPopupData[i];
					var row = sheetObjects[0].DataInsert(-1);
	
					sheetObjects[0].CellValue2(row,"acct_nm") = sheetObjects[0].CellValue(row-1,"acct_nm");
					sheetObjects[0].CellValue2(row,"acct_cd") = "954111";
					sheetObjects[0].CellValue2(row,"vndr_seq") = form.ownr_cd.value;
					sheetObjects[0].CellValue2(row,"ctr_cd") = sheetObjects[0].CellValue(row-1,"ctr_cd");
					sheetObjects[0].CellValue2(row,"slp_loc_cd") = sheetObjects[0].CellValue(row-1,"slp_loc_cd");
					//sheetObjects[0].CellValue2(row,"flet_olay_comm_rt_amt") = ownersAccountData.flet_olay_comm_rt_amt;
					
					sheetObjects[0].CellValue2(row,"slp_eff_dt") = form.eff_dt.value;
					sheetObjects[0].CellValue2(row,"curr_cd") = sheetObjects[0].CellValue(row-1,"curr_cd");
					
					sheetObjects[0].CellValue2(row,"csr_amt") = -1 * sheetObjects[0].CellValue(row-1,"csr_amt");	
				
					//if(bodBorData.acct_cd == "951111") {
					/*
					if(bodBorData.acct_cd == "956115") {
						sheetObjects[0].CellValue2(row,"bunker_vvd") = "";
					} else {
						sheetObjects[0].CellValue2(row,"bunker_vvd") = bodBorData.vvd_bunker;
					}
					*/
					
					//Account Code가 '954111' 이면 null로 처리함
					//sheetObjects[0].CellValue2(row,"bunker_vvd") = sheetObjects[0].CellValue(row-1,"bunker_vvd");
					
					sheetObjects[0].CellValue2(row,"csr_desc") = sheetObjects[0].CellValue(row-1,"csr_desc");
					sheetObjects[0].CellValue2(row,"flet_src_tp_cd") = sheetObjects[0].CellValue(row-1,"flet_src_tp_cd");
					//sheetObjects[0].CellValue2(row,"flet_ctrt_no") = sheetObjects[0].CellValue(row-1,"flet_ctrt_no");
					//sheetObjects[0].CellValue2(row,"bnk_seq") = sheetObjects[0].CellValue(row-1,"bnk_seq");
					sheetObjects[0].CellValue2(row,"pop_gb") = "OIL";
					
					sheetObjects[0].CellEditable(row, "ctr_cd") = true;
					
					// Key Number 체크
					if(checkKeyNumber(sheetObjects[0], "954111")) {
						sheetObjects[0].CellEditable(row, "key_number") = true;
						sheetObjects[0].CellValue2(row,"key_flg") = "Y";
					}
					
					sheetObjects[0].CellValue2(row,"auto_flg") = "Y";
					
					// --------------------------
					// Grid Font 설정하기
					// --------------------------
					setCellFont(sheetObjects[0], row);
				//}
			}
		}
			
		setTotalAmount('S');
 	}
	
	/**
     * Contract No 선택 시 해당 Name 을 가져온다. <br>
     **/
    function contract_no_change() {
    	doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'flet_ctrt_no');
    	
    	if(form.flet_ctrt_no.value.substring(4,6) == 'TO') {
    		ComBtnDisable("btn_charterersExp");
    		
    		ComBtnDisable("btn_offhireExp");
    		
    		ComBtnDisable("btn_ownersAccount");
    	}
    }
    
    /**
     * Evidence Type 변경시 Tax Evidence버튼을 컨트롤한다 <br>
     **/
    function setButton(val) {
    	form.evid_tp_cd_val.value = val;
    	
    	if(val == 5) {
   
	    	//Payments Slip TaxEvidence Button Disable 하기
			ComBtnDisable("btn_taxEvidence");
			
    	} else {
    	
    		//Payments Slip TaxEvidence Button Enable 하기
			ComBtnEnable("btn_taxEvidence");
    	}
    }
    
    /**
     * Slip Type 이 Prepayments일때 선급금 데이타가 선택되어 있는지 체크한다 <br>
     **/
    function preWorkCheck() {
    	if(form.slp_tp[0].checked) {
    		if(form.pre_work_flag.value == "") {
    			ComShowCodeMessage('FMS01445');
    			return false;
    		}
    		
    		return true;
    	} else {
    		return true;
    	}
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form}    formObj     Form Object
     * @param {int}     sAction     처리할 Action 코드(예:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL 등이며 CoObject.js에 정의됨)
     **/
    function validateForm(sheetObj,formObj,sAction,flag){
    	//필수 입력 등 Validation 체크
    	if(formObj.vsl_cd.value == "") {
    		ComAlertFocus(formObj.vsl_cd, ComGetMsg("FMS01138"));
    		return false;
    	}
    	
    	if(!ComChkValid(formObj)) return false;
    	
    	if(parseInt(formObj.rqst_dt.value.trimAll('-')) < parseInt(formObj.slp_iss_dt.value.trimAll('-'))) {
    		ComAlertFocus(formObj.rqst_dt, ComGetMsg("FMS01438"));
    		return false;
    	}
    	
    	if(flag != 'N') {
    		
    		if(formObj.slp_desc.value == "") {
    			ComAlertFocus(formObj.slp_desc, ComGetMsg("FMS01444"));
        		return false;
    		} else if (formObj.ownr_cd.value == "") {
    			ComShowCodeMessage("FMS01447");
        		return false;
    		}
    		return true;
    	}
    	
    	form.csr_curr_cd.readOnly = true;
    	
    	form.vsl_cd.readOnly = true;
    	
    	document.images["btn_vslpop"].name = "no_btn_vslpop";
    	form.btn_vslpop.style.cursor = "default";
    	document.images["btn_ctrtpop"].name = "no_btn_ctrtpop";
    	form.btn_ctrtpop.style.cursor = "default";
    }
    
    /**
     * 화면을 초기화한다. <br>
     * @return 없음
     * @see #ComResetAll
     **/
  	function formReset() {
    	
    	var ap_ctr_cd = form.ap_ctr_cd.value;
    	var loc_cd = form.loc_cd.value;
    	 
  	    ComResetAll();
  	    
  	    setCsrDate();
  	    setCurDate();
  	    
  	   // 현재 오픈되어있는 G/L Date가져온다
    	doActionIBSheet(sheetObjects[0], document.form, "IBSEARCHGL");
    	doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'eff_dt');	
  	  
  		form.vsl_cd.readOnly = false;
  		form.csr_curr_cd.readOnly = false;
  		form.slp_desc.readOnly = false;
  		form.rqst_dt.readOnly = false;
  		form.eff_dt.readOnly = false;
    	
    	form.slp_tp[0].disabled = false;
    	form.slp_tp[1].disabled = false;
    	//2010.08.13 nonbubble 추가
    	form.slp_tp[2].disabled = false;
    	form.slp_tp[3].disabled = false;
    	
    	form.slp_tp[0].checked = true;
    	
    	form.evid_tp_cd.disabled = false;
  		
  		form.btn_ctrtpop.style.cursor = "hand";
		document.images["btn_ctrtpop"].name = "btn_ctrtpop";
  		form.btn_vslpop.style.cursor = "hand";
  		document.images["btn_vslpop"].name = "btn_vslpop";
  		form.rqst_dt_cal.style.cursor = "hand";
  		document.images["rqst_dt_cal"].name = "rqst_dt_cal";
  		form.eff_dt_cal.style.cursor = "hand";
  		document.images["eff_dt_cal"].name = "eff_dt_cal";
  		
  		form.ap_ctr_cd.value = ap_ctr_cd;
    	form.loc_cd.value = loc_cd;
    	
    	pre_eff_dt = "";
  		
  		sheetObjects[0].ColHidden("seq_no") = false;
  		sheetObjects[0].ColHidden("slp_seq_num") = true;
  		
  		//form.evid_tp_cd.selectedIndex = 2;
  		
  		setEvidenceType();
  		
  		form.evid_tp_cd.disabled = false;
  		
  		//Payments Slip Preview Button Disable 하기
		ComBtnDisable("btn_preview");
		
  		//Payments Slip Print Button Disable 하기
		ComBtnDisable("btn_print");
		
		//Payments Slip HireStatement Button Disable 하기
		ComBtnDisable("btn_hireStatement");
		
		//Payments Slip Save Button Disable 하기
		ComBtnEnable("btn_save");
		
		//Payments Slip Prepayments Button Enable 하기
		ComBtnEnable("btn_prepayments");
		
		//Payments Slip CharterersExp Button Enable 하기
		ComBtnEnable("btn_charterersExp");
		
		//Payments Slip OffhireExp Button Enable 하기
		ComBtnEnable("btn_offhireExp");
		
		//Payments Slip OwnersAccount Button Enable 하기
		ComBtnEnable("btn_ownersAccount");
		
		//Payments Slip BodBor Button Enable 하기
		ComBtnEnable("btn_bodBor");
		
		//Payments Slip RowAdd Button Enable 하기
		ComBtnEnable("btn_rowAdd");
		
		//Payments Slip RowDel Button Enable 하기
		ComBtnEnable("btn_rowDel");
		
		//Payments Slip TaxEvidence Button Disable 하기
		ComBtnDisable("btn_taxEvidence");
		
		//Total Cal Button Enable 하기
		//ComBtnEnable("btn_totalCal");

		// Total Amount Setting 하기
		setTotalAmount();

  	}
  	
  	/**
     * row 삭제하기. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	prefix   	변수 구분값
     * @return {없음}
     **/
	function rowRemove(sheetObj, prefix) {
		var sRow = sheetObj.FindCheckedRow(prefix + "DelChk");
		if (sRow == "") return;
		
		//가져온 행을 배열로 반든다.
		var arrRow = sRow.split("|"); //결과 : "1|3|5|"
		for (var idx=arrRow.length-2; idx>=0; idx--){
			var row = arrRow[idx];
			
			sheetObj.RowHidden(row)= true;
			sheetObj.RowStatus(row)= "D";
		}
	}
     
    /**
     * Check Box 초기화하기. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	prefix   	변수 구분값
     * @return {없음}
     **/
	function initCheckBox(sheetObj) {
		for (var ir=1; ir<=sheetObj.LastRow; ir++) {
			sheetObj.CellValue2(ir,"DelChk") = 0;
		}
	}
    
    /**
     * 이벤트 발생시 실행여부 확인 <br>
     * @return {boolean} okYn   메세지 확인창에서 확인버튼 클릭하면 okYn:true 아니면 okYn:false
     **/
    function initConfirm() {
        var okYn = true;

     	//if(sheetObjects[0].RowCount > 0 && rowChangeYn()) {
     	if(sheetObjects[0].isDataModified) {
     		
     		var okYn = confirm(ComGetMsg('FMS00002'));
     	}
     	
     	return okYn;
    }
    
    /**
     * Event에 따른 화면 처리(저장 후) <br>
     * @return {없음}
     **/
    function saveReadOnly() {
    	form.vsl_cd.readOnly = true;
    	form.csr_curr_cd.readOnly = true;
    	form.slp_desc.readOnly = true;
    	form.rqst_dt.readOnly = true;
    	form.eff_dt.readOnly = true;
    	
    	form.slp_tp.disabled = true;
    	form.evid_tp_cd.disabled = true;
    	
    	document.images["btn_vslpop"].name = "no_btn_vslpop";
    	form.btn_vslpop.style.cursor = "default";
    	document.images["btn_ctrtpop"].name = "no_btn_ctrtpop";
    	form.btn_ctrtpop.style.cursor = "default";
    	document.images["eff_dt_cal"].name = "no_eff_dt_cal";
    	form.eff_dt_cal.style.cursor = "default";
    	document.images["rqst_dt_cal"].name = "no_rqst_dt_cal";
    	form.rqst_dt_cal.style.cursor = "default";
    	
    	form.slp_tp[0].disabled = true;
    	form.slp_tp[1].disabled = true;
    	//2010.08.13 nonbubble 추가
    	form.slp_tp[2].disabled = true;
    	form.slp_tp[3].disabled = true;
    	
    	//Payments Slip Preview Button Enable 하기
		ComBtnEnable("btn_preview");
		
    	//Payments Slip Print Button Enable 하기
		ComBtnEnable("btn_print");
			
		//Payments Slip HireStatement Button Enable 하기
		ComBtnEnable("btn_hireStatement");
		
		//Payments Slip Save Button Disable 하기
		ComBtnDisable("btn_save");
		
		//Payments Slip Prepayments Button Disable 하기
		ComBtnDisable("btn_prepayments");
		
		//Payments Slip CharterersExp Button Disable 하기
		ComBtnDisable("btn_charterersExp");
		
		//Payments Slip OffhireExp Button Disable 하기
		ComBtnDisable("btn_offhireExp");
		
		//Payments Slip OwnersAccount Button Disable 하기
		ComBtnDisable("btn_ownersAccount");
		
		//Payments Slip BodBor Button Disable 하기
		ComBtnDisable("btn_bodBor");
		
		//Payments Slip RowAdd Button Disable 하기
		ComBtnDisable("btn_rowAdd");
		
		//Payments Slip RowDel Button Disable 하기
		ComBtnDisable("btn_rowDel");
		
		//Total Cal Button Disable 하기
		//ComBtnDisable("btn_totalCal");
    }
    
    /**
     * 셀의 값이 변경되었을때 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     * @param {ibsheet} col     	sheetObj의 선택된 Col
     * @param {String} value    	sheetObj의 입력값
     **/
 	function sheet1_OnChange(sheetObj,row,col,value) {
 		//invAmtOnChange(sheetObj,row,col,value);
 		checkAccountCode(sheetObj,row,col,value,"");
 	}
 	
 	/**
     * IBSheet 입력값 중 Currency Code값의 존재 여부를 판단하다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     * @param {ibsheet} col     	sheetObj의 선택된 Col
     * @param {String} 	value    	sheetObj의 입력값
     * @param {String} 	prefix   	변수 구분값
     * @return {없음}
     * @see #setCurrCd
     **/
    function checkAccountCode(sheetObj,row,col,value,prefix) {
			
    	if (sheetObj.ColSaveName(col)==("acct_cd")) {
            var acctCdCol = sheetObj.SaveNameCol("acct_cd");
            var acctCdValue = sheetObj.CellValue(row,acctCdCol);
            
            if(acctCdValue == "") return;

            if(acctCdValue.length < 6) {
            	ComShowCodeMessage('FMS01439');
	    		sheetObj.CellValue2(row,acctCdCol) = "";
				sheetObj.SelectCell(row,acctCdCol);
				return;
    		}
            
           // 510991 : USE Only JOO Module.  FMS 510993
            if(acctCdValue == "510991") {
            	ComShowConfirm("Account Code 510991 is not available");
	    		sheetObj.CellValue2(row,acctCdCol) = "";
				sheetObj.SelectCell(row,acctCdCol);
				return;
            }
    		
            // P일때
            if(form.slp_tp[0].checked) {
            	if(   acctCdValue == "510911" 
            	   || acctCdValue == "111431" 
            	   || acctCdValue == "111071") {
            		ComShowCodeMessage('FMS01446');
            		
            		sheetObj.CellValue2(row,acctCdCol) = "";
   					sheetObj.SelectCell(row,acctCdCol);
   					
            		return;
            	}
            	
            // S일때
            } else {
            	if(   acctCdValue == "111431"
            	   || acctCdValue == "111071") {
            		ComShowCodeMessage('FMS01454');
            		
            		sheetObj.CellValue2(row,acctCdCol) = "";
    				sheetObj.SelectCell(row,acctCdCol);
    					
            		return;
            	}
            }
            
            form.chk_acct_cd.value = acctCdValue;
            
    		doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, "acct_cd", row);
    		
    	} else if (sheetObj.ColSaveName(col)==("ctr_cd")) {
            var ctrCdCol = sheetObj.SaveNameCol("ctr_cd");
            var ctrCdValue = sheetObj.CellValue(row,ctrCdCol);
            
            var slpLocCdCol = sheetObj.SaveNameCol("slp_loc_cd");
            
            if(ctrCdValue == "") {
            	sheetObj.CellValue(row,slpLocCdCol) = "";
            	return;
            }

            if(ctrCdValue.length < 6) {
            	ComShowCodeMessage('FMS01440');
	    		sheetObj.CellValue2(row,ctrCdCol) = "";
				sheetObj.SelectCell(row,ctrCdCol);
				return;
    		}
    		
            form.chk_ctr_cd.value = ctrCdValue;
            
    		doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, "ctr_cd", row);
    		
    	} else if (sheetObj.ColSaveName(col)==("bunker_vvd")) {
            var bunkerVvdCol = sheetObj.SaveNameCol("bunker_vvd");
            var bunkerVvdValue = sheetObj.CellValue(row,bunkerVvdCol);
            
            if(bunkerVvdValue == "") return;

            if(bunkerVvdValue.length < 10) {
            	ComShowCodeMessage('FMS01442');
	    		sheetObj.CellValue2(row,bunkerVvdCol) = "";
				sheetObj.SelectCell(row,bunkerVvdCol);
				return;
    		}
            
            /*
            if(bunkerVvdValue.substring(0,4) != form.vsl_cd.value) {
            	ComShowCodeMessage('FMS01144');
	    		sheetObj.CellValue2(row,bunkerVvdCol) = "";
				sheetObj.SelectCell(row,bunkerVvdCol);
				return;
    		}
    		*/
    		
            form.chk_bunker_vvd.value = bunkerVvdValue;
            
    		doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, "bunker_vvd", row);
    		
    	} else if (sheetObj.ColSaveName(col)==("csr_amt")) {
    		
    		var krw_csr_amt = 0;
        	var etc_csr_amt = 0; 
        	
    		for (var ir=1; ir<=sheetObj.LastRow; ir++) {
    			if(sheetObj.CellValue(ir,"pop_gb") == "TAX") {
    				if(sheetObj.CellValue(ir,"acct_cd") == "951111" && sheetObj.CellValue(ir,"curr_cd") == "KRW") {
    					
    					sheetObj.CellValue2(ir,"csr_amt") = (-parseFloat(value) * parseInt(form.usd_locl_xch_rt.value)).toFixed(0);
    					etc_csr_amt = parseFloat(sheetObj.CellValue(ir,"csr_amt"));
    					
    				} else if(sheetObj.CellValue(ir,"acct_cd") == "111811" && sheetObj.CellValue(ir,"curr_cd") == "KRW") {
    					
    					krw_csr_amt = parseFloat(sheetObj.CellValue(ir,"csr_amt"));
    					
    				} else if((sheetObj.CellValue(ir,"acct_cd") == "421211" || sheetObj.CellValue(ir,"acct_cd") == "580111") && sheetObj.CellValue(ir,"curr_cd") == "KRW") {
    					if(parseFloat(krw_csr_amt + etc_csr_amt) != 0 ) {
							//흑자인 경우
							if(parseFloat(krw_csr_amt) > 0) {
								if(krw_csr_amt - Math.abs(etc_csr_amt) < 0 ) {
									sheetObj.CellValue2(ir,"acct_cd") = "580111";
									sheetObj.CellValue2(ir,"csr_amt") = (krw_csr_amt - Math.abs(etc_csr_amt)).toFixed(0) * -1;
									sheetObj.CellValue2(ir,"csr_desc") = "외환차손  " + form.vsl_cd.value;
								} else {
									sheetObj.CellValue2(ir,"acct_cd") = "421211";
									sheetObj.CellValue2(ir,"csr_amt") = (Math.abs(krw_csr_amt) - Math.abs(etc_csr_amt)).toFixed(0) * -1;
									sheetObj.CellValue2(ir,"csr_desc") = "외환차익  " + form.vsl_cd.value;
								}
							//적자인 경우	
							} else {
								if(Math.abs(krw_csr_amt) - Math.abs(etc_csr_amt) > 0 ) {
									sheetObj.CellValue2(ir,"acct_cd") = "580111";
									sheetObj.CellValue2(ir,"csr_amt") = (Math.abs(krw_csr_amt) - Math.abs(etc_csr_amt)).toFixed(0);
									sheetObj.CellValue2(ir,"csr_desc") = "외환차손  " + form.vsl_cd.value;			         					
								} else {
									sheetObj.CellValue2(ir,"acct_cd") = "421211";
									sheetObj.CellValue2(ir,"csr_amt") = (Math.abs(krw_csr_amt) - Math.abs(etc_csr_amt)).toFixed(0);
									sheetObj.CellValue2(ir,"csr_desc") = "외환차익  " + form.vsl_cd.value;
								}
							}
						} 
    				}
    			}
    		}
    		
    		setTotalAmount('S');
    	}
	}
     
    /**
     * 셀을 클릭했을때 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @param {String} 	Value     	파일명
     **/
  	function sheet1_OnClick(sheetObj,Row,Col,Value){
    	
    	if(form.csr_no.value == "") {
	    	var evid_tp_cd = form.evid_tp_cd_val.value;
	    	var csr_curr_cd = form.csr_curr_cd.value;
	    	
	    	var tax_pl_cd = sheetObjects[1].CellValue(1,"tax_tax_pl_cd");
	    	 
	  		// VAT Apply 체크된 경우
	  		if (sheetObj.ColSaveName(Col)==("vat_apply")) {
	  			
		  		if(sheetObj.CellValue(Row,"vat_apply") == 0) {
		  			
		  			//if(evid_tp_cd == "1" || evid_tp_cd == "4") {
		  			if(evid_tp_cd == "1" && tax_pl_cd == "2") {
		  				
		  				if(csr_curr_cd == "KRW") {
		  					sheetObj.CellValue(Row,"vat_apply") = 1;
		  					
		  				} else {
		  					
		  					if(sheetObjects[2].RowCount == 0) {
								ComShowCodeMessage("FMS01458");
								sheetObj.CellValue(Row,"vat_apply") = 1;
							} else {
								if(sheetObjects[1].CellValue(1,"tax_tax_div_cd") == "1") {
									if(parseFloat(sheetObj.CellValue(Row,"csr_amt")) < 0) {
										ComShowCodeMessage("FMS01459"); // 흑자 메세지
										sheetObj.CellValue(Row,"vat_apply") = 1;
									}
								} else {
									if(parseFloat(sheetObj.CellValue(Row,"csr_amt")) > 0) {
										ComShowCodeMessage("FMS01460"); // 적자 메세지
										sheetObj.CellValue(Row,"vat_apply") = 1;
									}
								}
							}
		  				}
		  				
		  			} else {
		  				sheetObj.CellValue(Row,"vat_apply") = 1;
		  			}
		  			
		  		}
	  		}
  		}
  	}
    
    /**
     * 저장함수에서 저장직전에 Vlidation을 체크하기 위해 호출되는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     * @param {ibsheet} col     	sheetObj의 선택된 Col
     * @param {String}  value    	sheetObj의 입력값
     **/
 	function sheet1_OnValidation(sheetObj,row,col,value) {
    	 
 		var acctCdCol = sheetObj.SaveNameCol("acct_cd");
		var acctCdValue = sheetObj.CellValue(row,acctCdCol);
		
		var ctrCdCol = sheetObj.SaveNameCol("ctr_cd");
		var ctrtCdValue = sheetObj.CellValue(row,ctrCdCol);
		
		var csrAmtCol = sheetObj.SaveNameCol("csr_amt");
		var csrAmtValue = sheetObj.CellValue(row,csrAmtCol);
		
		var csrDescCol = sheetObj.SaveNameCol("csr_desc");
		var csrDescValue = sheetObj.CellValue(row,csrDescCol);
		
		var curr_cd = form.csr_curr_cd.value;
		
		// Currency 가 KRW 인 경우에만 111811 계정을 사용할 수 있으며 선급부가세(3전표)는 체크하지 않는다
		if(acctCdValue != "") {
			if(   curr_cd != "KRW" 
			   && acctCdValue == "111811" 
			   && sheetObj.CellValue(row,"vat_flg") != "2") {	//2017.05.10 과세처리 로직 보완
				
				ComShowCodeMessage('FMS01475');
				sheetObj.CellValue2(row,"acct_cd") = "";
				sheetObj.SelectCell(row,"acct_cd");
				sheetObj.ValidateFail = true;
				return;
			}
		}
		
		if(acctCdValue == "") {
			ComShowCodeMessage("FMS01073");
			sheetObj.SelectCell(row,"acct_cd");
			sheetObj.ValidateFail = true;
			return;
			
		} else if(ctrtCdValue == "") {
			ComShowCodeMessage("FMS01440");
			sheetObj.SelectCell(row,"ctr_cd");
			sheetObj.ValidateFail = true;
			return;
			
		} else if(csrAmtValue == "" || csrAmtValue == "0") {
			// 영세(tax_tax_pl_cd == 1)도 과세와 동일하게 처리
			if(sheetObjects[1].CellValue(1,"tax_tax_pl_cd") != "1") {
			ComShowCodeMessage("FMS01448");
			sheetObj.SelectCell(row,"csr_amt");
			sheetObj.ValidateFail = true;
			}
			return;
			
		} else if(csrDescValue == "") {
			ComShowCodeMessage("FMS01444");
			sheetObj.SelectCell(row,"csr_desc");
			sheetObj.ValidateFail = true;
			return;
		} 
		
		//항차 체크
		var bunkerVvdCol = sheetObj.SaveNameCol("bunker_vvd");
		var bunkerVvdValue = sheetObj.CellValue(row,bunkerVvdCol);
		
		if((   acctCdValue.substring(0,1) == "4"
		    || acctCdValue.substring(0,1) == "6"
		    || acctCdValue.substring(0,1) == "7"
		    || acctCdValue.substring(0,2) == "51"
		    || acctCdValue == "956115"
		    || acctCdValue == "962111"
		    || acctCdValue == "111071") && !(   acctCdValue.substring(0,4) == "4212"
			   							     || acctCdValue.substring(0,4) == "5801"
			   							     || acctCdValue == "612900"
			   							     || acctCdValue == "712900") ) {

			//&& !(acctCdValue == "580111" || acctCdValue == "421211") vat_flg
			// 3전표가 아닌 경우 체크
			if(sheetObj.CellValue(row,"vat_flg") != "2") {
				if(bunkerVvdValue == "") {
					//2011-11-04추가
					//ACC# 421211 사용시 VVD 입력을 요구.
					if (acctCdValue != "421211") {
						ComShowCodeMessage("FMS01155");
						sheetObj.SelectCell(row,"bunker_vvd");
						sheetObj.ValidateFail = true;
						return;						
					}
				}
			}
		} else {
			sheetObj.CellValue2(row,bunkerVvdCol) = "";
		}
		
		// Key Number 체크
		if(checkKeyNumber(sheetObj, acctCdValue)) {
			var keyNumberCol = sheetObj.SaveNameCol("key_number");
			var keyNumberValue = sheetObj.CellValue(row,keyNumberCol);
			
			if(sheetObj.CellValue(row,"vat_flg") == "") {
				if(keyNumberValue == "") {
					ComShowCodeMessage("FMS01456");
					sheetObj.SelectCell(row,"key_number");
					sheetObj.ValidateFail = true;
					return;
				}
			}
		}
 	}
     
    /**
     * Save 여부 결정 <br>
     * @return {boolean} okYn 저장 여부
     **/
 	function saveConfirm() {
 		//setTotalAmount('S');
 		
 		var okYn = ComShowConfirm(ComGetMsg("FMS00017"));
 		
 		return okYn;
 	}
 	
 	/**
     * Total Amount 를 계산해준다 <br>
     * @return {없음}
     **/
 	function setTotalAmount(flag) {
 		
 		if(flag == "S") {
 			var dr_amt = 0;
    		var diff_amt = 0;

    		for(var ir=1; ir<=sheetObjects[0].LastRow; ir++) {
    			if(   sheetObjects[0].CellValue(ir,"vat_flg") == ""
    			   || sheetObjects[0].CellValue(ir,"vat_flg") == "1") {
    				
	    			if(parseFloat(sheetObjects[0].CellValue(ir,"csr_amt")) > 0) {
	    				dr_amt += parseFloat(sheetObjects[0].CellValue(ir,"csr_amt"));
	    			} else {
	    				diff_amt += parseFloat(sheetObjects[0].CellValue(ir,"csr_amt"));
	    			}
    			}
    		}
    		
    		form.dr_amt.value = ComAddComma(dr_amt.toFixed(2));
    		form.diff_amt.value = ComAddComma(diff_amt.toFixed(2));
    		form.balance_amt.value = ComAddComma((dr_amt + diff_amt).toFixed(2));
    		
 		} else {
 			form.dr_amt.value = "0.00";
	 		form.diff_amt.value = "0.00";
	 		form.balance_amt.value = "0.00";
 		}
 	}
    
    /**
     * Account Code 에 따라 Key Number 를 입력해야하는지 판단여부 <br>
     * @param {ibsheet}	sheetObj    IBSheet Object
     * @param {String}  acctCd    	Account Code
     * @return {boolean} true : 존재, false : 미존재
     **/
    function checkKeyNumber(sheetObj, acctCd) {
     	
    	if(   acctCd == "167111" 
    	   || acctCd == "16712" 
    	   || acctCd == "167191"
    	   || (parseInt(acctCd) > 511300 && parseInt(acctCd) < 511499 && acctCd != "511351")
    	   || (parseInt(acctCd) > 133810 && parseInt(acctCd) < 133891)) {
    		
    		return true;
    	}
    	
    	return false;
 	}
  
     
    /**
     * 세금 계산서 / 계산서 데이타를 만들어준다 <br>
     * @param {ibsheet}	sheetObj    IBSheet Object
     * @param {String}  acctCd    	Account Code
     **/

function setMakeTaxEvidence(taxAmt) {
		var sheetObj = sheetObjects[0];
    	var taxCnt = sheetObjects[2].RowCount;
    	var vatCnt = 0;
    	var idx = 0;
    	var krw_csr_amt = 0;
    	var etc_csr_amt = 0;    	 
    	var currCd = form.csr_curr_cd.value;
    	var row =0;
    	var i=0;
    	var paymentCnt=0;
    	var vatAmt = 0;
    	
   /********** IF 'currCd' - [Start] ***********/ 	
    	
    	
    	if(currCd == "KRW") {
    		//for (var ir=1; ir<=taxCnt; ir++){
    			
    			var row = sheetObj.DataInsert(-1);
    			
    			sheetObj.CellValue2(row,"acct_cd") = "111811";
 				sheetObj.CellValue2(row,"ctr_cd") = form.ap_ctr_cd.value;
     			sheetObj.CellValue2(row,"slp_loc_cd") = form.loc_cd.value;
 				sheetObj.CellValue2(row,"bunker_vvd") = "";
 				sheetObj.CellValue2(row,"csr_amt") = parseInt(taxAmt).toFixed(0);
 				sheetObj.CellValue2(row,"csr_desc") = "선급부가세 " + form.vsl_cd.value + " (VAT)";
 				sheetObj.CellValue2(row,"curr_cd") = "KRW";
 				sheetObj.CellValue2(row,"slp_tp_cd") = "S"; 				
 				sheetObj.CellValue2(row,"vndr_seq") = form.ownr_cd.value;
     			sheetObj.CellValue2(row,"slp_eff_dt") = form.eff_dt.value;     			
     			sheetObj.CellValue2(row,"flet_src_tp_cd") = "20";     			
     			sheetObj.CellValue2(row,"key_flg") = sheetObj.CellValue(row-1,"key_flg");
     			sheetObj.CellValue2(row,"vat_flg") = "1";
     			sheetObj.CellValue2(row,"pop_gb") = "TAX";
     			
    		//}
    	} else {
    		
			/********** For  'ir' - [Start] ***********/ 
			if( (sheetObjects[1].CellValue(1,"tax_tax_pl_cd") == "2") ) { //과세
				paymentCnt=sheetObj.LastRow;
				form.make_tax_yn.value = "Y";
				for (var ir=1; ir<=paymentCnt; ir++) {
					vatAmt += parseFloat(sheetObj.CellValue(ir,"csr_amt"));
				}
				vatAmt = vatAmt.toFixed(2);
				/********** IF  'vat_apply', 'tax_tax_pl_cd' - [Start] ***********/ 
				//if( (sheetObj.CellValue(ir, "vat_apply") == 1) || (sheetObjects[1].CellValue(1,"tax_tax_pl_cd") == "1") ) {
					//idx = idx + 1;	

					// 전표1, 전표2, 전표3  데이타 생성
					//if( (sheetObj.CellValue(ir, "vat_apply") == 1) )  {
						//vatCnt = vatCnt + 1;
						/* *************** 1St Row [Start] **************		//2017.05.10 과세처리 로직 보완
						row = sheetObj.DataInsert(-1);
						sheetObj.CellValue2(row,"acct_cd") = sheetObj.CellValue(ir,"acct_cd");
						sheetObj.CellValue2(row,"csr_desc") = sheetObj.CellValue(ir,"csr_desc") + " (VAT)";
						sheetObj.CellValue2(row,"vndr_seq") = sheetObj.CellValue(ir,"vndr_seq");
						sheetObj.CellValue2(row,"ctr_cd") 	= sheetObj.CellValue(ir,"ctr_cd");
						sheetObj.CellValue2(row,"slp_loc_cd") = sheetObj.CellValue(ir,"slp_loc_cd");
						sheetObj.CellValue2(row,"slp_eff_dt") = sheetObj.CellValue(ir,"slp_eff_dt");
						sheetObj.CellValue2(row,"curr_cd") = sheetObj.CellValue(ir,"curr_cd");
						sheetObj.CellValue2(row,"csr_amt") = (parseFloat(sheetObj.CellValue(ir,"csr_amt")) * 0.1).toFixed(2);
						sheetObj.CellValue2(row,"bunker_vvd") = sheetObj.CellValue(ir,"bunker_vvd");
						sheetObj.CellValue2(row,"flet_src_tp_cd") = "20";
					    
						sheetObj.CellValue2(row,"flet_ctrt_no") = sheetObj.CellValue(ir,"flet_ctrt_no");
					    sheetObj.CellValue2(row,"bnk_seq") = sheetObj.CellValue(ir,"bnk_seq");
					    sheetObj.CellValue2(row,"pop_gb") = sheetObj.CellValue(ir,"pop_gb");					         		
					    sheetObj.CellValue2(row,"key_flg") = sheetObj.CellValue(ir,"key_flg");
					    sheetObj.CellValue2(row,"vat_flg") = "1";
						**************** 1St Row [End] ************* */

						/**************** 2nd Row [Start] **************/
						row = sheetObj.DataInsert(-1);
						//i++;
						sheetObj.CellValue2(row,"acct_cd") = "951111";
						sheetObj.CellValue2(row,"ctr_cd") = sheetObj.CellValue(1,"ctr_cd");
						sheetObj.CellValue2(row,"slp_loc_cd") = sheetObj.CellValue(1,"slp_loc_cd");
						sheetObj.CellValue2(row,"bunker_vvd") = sheetObj.CellValue(1,"bunker_vvd");	
						sheetObj.CellValue2(row,"csr_amt") = (vatAmt * 0.1).toFixed(2);	//2017.05.10 과세처리 로직 보완

						sheetObj.CellValue2(row,"csr_desc") = "환대체 " + form.vsl_cd.value + " (VAT)";
						sheetObj.CellValue2(row,"curr_cd") = sheetObj.CellValue(1,"curr_cd");
						sheetObj.CellValue2(row,"slp_tp_cd") = "S";
						sheetObj.CellValue2(row,"vat_flg") = "1";	//2017.05.10 과세처리 로직 보완
						sheetObj.CellValue2(row,"tax_seq") = 2; // setMakeSlipMstData 함수에 계산 로직으로 사용.
						sheetObj.CellValue2(row,"vndr_seq") = sheetObj.CellValue(1,"vndr_seq");
						sheetObj.CellValue2(row,"slp_eff_dt") = sheetObj.CellValue(1,"slp_eff_dt");
						sheetObj.CellValue2(row,"flet_src_tp_cd") = "20";
						sheetObj.CellValue2(row,"key_flg") = sheetObj.CellValue(1,"key_flg");	
						sheetObj.CellValue2(row,"pop_gb") = "TAX";
						
						sheetObj.CellEditable(row, "csr_amt") = true;
						/**************** 2nd Row [End] **************/

						/* *************** 3rd Row [Start] **************		//2017.05.10 과세처리 로직 보완
						row = sheetObj.DataInsert(-1);
						sheetObj.CellValue2(row,"acct_cd") = sheetObj.CellValue(ir,"acct_cd");
						sheetObj.CellValue2(row,"ctr_cd") = sheetObj.CellValue(ir,"ctr_cd");
						sheetObj.CellValue2(row,"slp_loc_cd") = sheetObj.CellValue(ir,"slp_loc_cd");
						sheetObj.CellValue2(row,"bunker_vvd") = sheetObj.CellValue(ir,"bunker_vvd");
						sheetObj.CellValue2(row,"csr_amt") = -sheetObj.CellValue(row-2,"csr_amt");
						sheetObj.CellValue2(row,"csr_desc") = sheetObj.CellValue(row-2,"csr_desc");
						sheetObj.CellValue2(row,"curr_cd") = sheetObj.CellValue(ir,"curr_cd");
						sheetObj.CellValue2(row,"slp_tp_cd") = "S";		         				
						sheetObj.CellValue2(row,"vat_flg") = "2";

						sheetObj.CellValue2(row,"vndr_seq") = sheetObj.CellValue(ir,"vndr_seq");
						sheetObj.CellValue2(row,"slp_eff_dt") = sheetObj.CellValue(ir,"slp_eff_dt");
						sheetObj.CellValue2(row,"flet_src_tp_cd") = "20";
						sheetObj.CellValue2(row,"key_flg") = sheetObj.CellValue(ir,"key_flg");
						**************** 3rd Row [End] ************* */

						/**************** 4th Row [Start] **************/
						row = sheetObj.DataInsert(-1);

						sheetObj.CellValue2(row,"acct_cd") = "951111";		         				
						sheetObj.CellValue2(row,"ctr_cd") = sheetObj.CellValue(1,"ctr_cd");
						sheetObj.CellValue2(row,"slp_loc_cd") = sheetObj.CellValue(1,"slp_loc_cd");								
						sheetObj.CellValue2(row,"bunker_vvd") = sheetObj.CellValue(1,"bunker_vvd");		         				
						sheetObj.CellValue2(row,"csr_amt") = (-parseFloat((vatAmt * 0.1).toFixed(2)) * parseInt(form.usd_locl_xch_rt.value)).toFixed(0);
						sheetObj.CellValue2(row,"csr_desc") = "환대체 " + form.vsl_cd.value + " (VAT)";
						sheetObj.CellValue2(row,"curr_cd") = "KRW";
						sheetObj.CellValue2(row,"slp_tp_cd") = "S";		         				
						sheetObj.CellValue2(row,"vat_flg") = "2";		//2017.05.10 과세처리 로직 보완	         				
						sheetObj.CellValue2(row,"tax_seq") = 5; // setMakeSlipMstData 함수에 계산 로직으로 사용.

						//etc_csr_amt = etc_csr_amt + parseFloat(sheetObj.CellValue(row,"csr_amt"));	
						etc_csr_amt =   parseFloat(sheetObj.CellValue(row,"csr_amt"));

						// ROW 공통처리		         				
						sheetObj.CellValue2(row,"vndr_seq") = sheetObj.CellValue(1,"vndr_seq");
						sheetObj.CellValue2(row,"slp_eff_dt") = sheetObj.CellValue(1,"slp_eff_dt");
						sheetObj.CellValue2(row,"flet_src_tp_cd") = "20";
						sheetObj.CellValue2(row,"key_flg") = sheetObj.CellValue(1,"key_flg");
						sheetObj.CellValue2(row,"pop_gb") = "TAX";
						/**************** 4th Row [End] **************/
						
						/**************** 5th Row [Start] **************/
						row = sheetObj.DataInsert(-1);
						sheetObj.CellValue2(row,"acct_cd") = "111811";
						sheetObj.CellValue2(row,"ctr_cd") = sheetObj.CellValue(1,"ctr_cd");
						sheetObj.CellValue2(row,"slp_loc_cd") = sheetObj.CellValue(1,"slp_loc_cd");
						sheetObj.CellValue2(row,"bunker_vvd") = ""; //sheetObj.CellValue(1,"bunker_vvd");		         				
						sheetObj.CellValue2(row,"csr_amt") = parseInt(taxAmt).toFixed(0);

						sheetObj.CellValue2(row,"csr_desc") = "선급부가세 " + form.vsl_cd.value + " (VAT)";
						sheetObj.CellValue2(row,"curr_cd") = "KRW";
						sheetObj.CellValue2(row,"slp_tp_cd") = "S";
						sheetObj.CellValue2(row,"vat_flg") = "2";	//2017.05.10 과세처리 로직 보완	         
						sheetObj.CellValue2(row,"tax_seq") = 4; // setMakeSlipMstData 함수에 계산 로직으로 사용.
									
						//krw_csr_amt = krw_csr_amt + parseFloat(sheetObjects[2].CellValue(vatCnt,"txd_tax_amt"));	
						krw_csr_amt =  parseFloat(taxAmt);

						sheetObj.CellValue2(row,"vndr_seq") = sheetObj.CellValue(1,"vndr_seq");
						sheetObj.CellValue2(row,"slp_eff_dt") = sheetObj.CellValue(1,"slp_eff_dt");
						sheetObj.CellValue2(row,"flet_src_tp_cd") = "20";
						sheetObj.CellValue2(row,"key_flg") = sheetObj.CellValue(1,"key_flg");
						sheetObj.CellValue2(row,"pop_gb") = "TAX";
						/**************** 5th Row [End] **************/

						/****************최종 데이타 생성 [Start] **************/	
						//과세일 경우만 처리한다.
						//if(vatCnt == taxCnt) {
							if(parseFloat(krw_csr_amt + etc_csr_amt) != 0 ) {
								row = sheetObj.DataInsert(-1);
								//흑자인 경우
								if(parseFloat(taxAmt) > 0) {
									if(krw_csr_amt - Math.abs(etc_csr_amt) < 0 ) {
										sheetObj.CellValue2(row,"acct_cd") = "580111";
										sheetObj.CellValue2(row,"csr_amt") = (krw_csr_amt - Math.abs(etc_csr_amt)).toFixed(0) * -1;
										sheetObj.CellValue2(row,"csr_desc") = "외환차손  " + form.vsl_cd.value;
									} else {
										sheetObj.CellValue2(row,"acct_cd") = "421211";
										sheetObj.CellValue2(row,"csr_amt") = (Math.abs(krw_csr_amt) - Math.abs(etc_csr_amt)).toFixed(0) * -1;
										sheetObj.CellValue2(row,"csr_desc") = "외환차익  " + form.vsl_cd.value;
									}
								//적자인 경우	
								} else {
									if(Math.abs(krw_csr_amt) - Math.abs(etc_csr_amt) > 0 ) {
										sheetObj.CellValue2(row,"acct_cd") = "580111";
										sheetObj.CellValue2(row,"csr_amt") = (Math.abs(krw_csr_amt) - Math.abs(etc_csr_amt)).toFixed(0);
										sheetObj.CellValue2(row,"csr_desc") = "외환차손  " + form.vsl_cd.value;			         					
									} else {
										sheetObj.CellValue2(row,"acct_cd") = "421211";
										sheetObj.CellValue2(row,"csr_amt") = (Math.abs(krw_csr_amt) - Math.abs(etc_csr_amt)).toFixed(0);
										sheetObj.CellValue2(row,"csr_desc") = "외환차익  " + form.vsl_cd.value;
									}
								}
								sheetObj.CellValue2(row,"ctr_cd") = sheetObj.CellValue(1,"ctr_cd");
								sheetObj.CellValue2(row,"slp_loc_cd") = sheetObj.CellValue(1,"slp_loc_cd");

								sheetObj.CellValue2(row,"bunker_vvd") =sheetObj.CellValue(1,"bunker_vvd");			         				
								sheetObj.CellValue2(row,"curr_cd") = "KRW";
								sheetObj.CellValue2(row,"slp_tp_cd") = "S";	         				
								sheetObj.CellValue2(row,"vndr_seq") = sheetObj.CellValue(1,"vndr_seq");
								sheetObj.CellValue2(row,"slp_eff_dt") = sheetObj.CellValue(1,"slp_eff_dt");
								sheetObj.CellValue2(row,"flet_src_tp_cd") = "20";
								sheetObj.CellValue2(row,"key_flg") = sheetObj.CellValue(1,"key_flg");
								sheetObj.CellValue2(row,"vat_flg") = "2";	//2017.05.10 과세처리 로직 보완	 
								sheetObj.CellValue2(row,"pop_gb") = "TAX";
							} // End  if  'krw_csr_amt + etc_csr_amt != 0'
						//}
						/****************최종 데이타 생성 [End] **************/	
					//}
					/**************** 5th Row [End] **************/
					

				//}/********** For  'ir' - [End] ***********/

			// 과세 끝
			} else if( (sheetObjects[1].CellValue(1,"tax_tax_pl_cd") == "1") ) { //영세
				//paymentCnt=sheetObjects[2].LastRow;
				form.make_tax_yn.value = "Y";

				//for (var ir=1; ir<=paymentCnt; ir++) {

					row = sheetObj.DataInsert(-1);
//					i++;
					sheetObj.CellValue2(row,"acct_cd") = "111811";
					sheetObj.CellValue2(row,"ctr_cd") = sheetObj.CellValue(1,"ctr_cd");
					sheetObj.CellValue2(row,"slp_loc_cd") = sheetObj.CellValue(1,"slp_loc_cd");
					sheetObj.CellValue2(row,"bunker_vvd") = ""; //sheetObj.CellValue(1,"bunker_vvd");		         				
					sheetObj.CellValue2(row,"csr_amt") = parseInt(taxAmt).toFixed(0);

					sheetObj.CellValue2(row,"csr_desc") = "선급부가세 " + form.vsl_cd.value + " (VAT)";
					sheetObj.CellValue2(row,"curr_cd") = "KRW";
					sheetObj.CellValue2(row,"slp_tp_cd") = "S";
					sheetObj.CellValue2(row,"vat_flg") = "2";	//2017.05.10 과세처리 로직 보완	 
					sheetObj.CellValue2(row,"tax_seq") = 4;

					sheetObj.CellValue2(row,"vndr_seq") = sheetObj.CellValue(1,"vndr_seq");
					sheetObj.CellValue2(row,"slp_eff_dt") = sheetObj.CellValue(1,"slp_eff_dt");
					sheetObj.CellValue2(row,"flet_src_tp_cd") = "20";
					sheetObj.CellValue2(row,"key_flg") = sheetObj.CellValue(1,"key_flg");
					sheetObj.CellValue2(row,"pop_gb") = "TAX";
				//}
			}
			/********** IF  'vat_apply', 'tax_tax_pl_cd' - [End] ***********/ 

		}  /********** IF 'currCd' - [End] ***********/
    	
    	setTotalAmount('S');
    	
	}// End Function
     
/**
 * Slip Master 데이타를 만들어준다 <br>
 * @return {없음}
 **/
function setMakeSlipMstData() {
	var prefix = "mst_";
	
	var makeTaxYn = form.make_tax_yn.value;
	if(makeTaxYn == "Y") {
		
		var dr_amt2 = 0;
		var dr_amt3 = 0;
		var dr_amt4 = 0;
		var dr_amt5 = 0;

		for(var ir=1; ir<=sheetObjects[0].LastRow; ir++) {
			if(sheetObjects[0].CellValue(ir,"tax_seq") == "2") {
    			dr_amt2 += Math.abs(parseFloat(sheetObjects[0].CellValue(ir,"csr_amt")));
			} else if(sheetObjects[0].CellValue(ir,"tax_seq") == "4") {
				dr_amt4 += Math.abs(parseFloat(sheetObjects[0].CellValue(ir,"csr_amt")));
			} else if(sheetObjects[0].CellValue(ir,"tax_seq") == "5") {
				dr_amt5 += Math.abs(parseFloat(sheetObjects[0].CellValue(ir,"csr_amt")));
			}
		}
		
		if(dr_amt4 > dr_amt5) {
			dr_amt3 = dr_amt4;
		} else if(dr_amt5 > dr_amt4) {
			dr_amt3 = dr_amt5;
		} else {
			dr_amt3 = dr_amt4;
		}

		for (var i=0; i<=1; i++) {		//2017.05.10 과세처리 로직 보완	 
			var row = sheetObjects[3].DataInsert(-1);
    		sheetObjects[3].CellValue2(row, prefix+"slp_ofc_cd") = form.slp_ofc_cd.value;
    		sheetObjects[3].CellValue2(row, prefix+"ap_ctr_cd") = form.ap_ctr_cd.value;
    		sheetObjects[3].CellValue2(row, prefix+"loc_cd") = form.loc_cd.value;
    		sheetObjects[3].CellValue2(row, prefix+"chk_acct_cd") = form.chk_acct_cd.value;
    		sheetObjects[3].CellValue2(row, prefix+"chk_ctr_cd") = form.chk_ctr_cd.value;
    		
    		sheetObjects[3].CellValue2(row, prefix+"chk_bunker_vvd") = form.chk_bunker_vvd.value;
    		sheetObjects[3].CellValue2(row, prefix+"pre_work_flag") = form.pre_work_flag.value;
    		sheetObjects[3].CellValue2(row, prefix+"evid_tp_cd_val") = form.evid_tp_cd_val.value;
    		sheetObjects[3].CellValue2(row, prefix+"usd_locl_xch_rt") = form.usd_locl_xch_rt.value;
    		sheetObjects[3].CellValue2(row, prefix+"flet_ctrt_no") = form.flet_ctrt_no.value;
    		
    		sheetObjects[3].CellValue2(row, prefix+"vsl_cd") = form.vsl_cd.value;
    		sheetObjects[3].CellValue2(row, prefix+"vsl_eng_nm") = form.vsl_eng_nm.value;
    		sheetObjects[3].CellValue2(row, prefix+"flet_ctrt_tp_cd") = form.flet_ctrt_tp_cd.Text;
    		
    		sheetObjects[3].CellValue2(row, prefix+"slp_iss_dt") = form.slp_iss_dt.value;
    		
    		sheetObjects[3].CellValue2(row, prefix+"usr_nm") = form.usr_nm.value;
    		sheetObjects[3].CellValue2(row, prefix+"csr_no") = form.csr_no.value;
    		
    		sheetObjects[3].CellValue2(row, prefix+"eff_dt") = form.eff_dt.value.trimAll('-');
    		sheetObjects[3].CellValue2(row, prefix+"ownr_cd") = form.ownr_cd.value;
    		sheetObjects[3].CellValue2(row, prefix+"ppay_hir_no") = form.ppay_hir_no.value;
    		sheetObjects[3].CellValue2(row, prefix+"apro_step") = form.apro_step.value;
    		
    		if(i == 0) {
    			sheetObjects[3].CellValue2(row, prefix+"csr_curr_cd") = form.csr_curr_cd.value;
    			sheetObjects[3].CellValue2(row, prefix+"slp_desc") = form.slp_desc.value;
    			
    			if(form.slp_tp[0].checked) {
    				sheetObjects[3].CellValue2(row, prefix+"slp_tp") = form.slp_tp[0].value;
    			} else if (form.slp_tp[1].checked){
    				sheetObjects[3].CellValue2(row, prefix+"slp_tp") = form.slp_tp[1].value;
    			//2010.08.13 nonbubble 추가
    			} else if (form.slp_tp[2].checked){
    				sheetObjects[3].CellValue2(row, prefix+"slp_tp") = form.slp_tp[2].value;
    			}
    			sheetObjects[3].CellValue2(row, prefix+"evid_tp_cd") = form.evid_tp_cd.value;
    			sheetObjects[3].CellValue2(row, prefix+"rqst_dt") = form.rqst_dt.value.trimAll('-');
    			sheetObjects[3].CellValue2(row, prefix+"vat_flg") = "1";
    			sheetObjects[3].CellValue2(row, prefix+"dr_amt") = form.dr_amt.value;
        		sheetObjects[3].CellValue2(row, prefix+"diff_amt") = form.diff_amt.value;
        		sheetObjects[3].CellValue2(row, prefix+"balance_amt") = form.balance_amt.value;
        		sheetObjects[3].CellValue2(row, prefix+"apro_step") = form.apro_step.value;
    			
        	/*2017.05.10 과세처리 로직 보완	 
    		} else if(i == 1) {
    			sheetObjects[3].CellValue2(row, prefix+"csr_curr_cd") = form.csr_curr_cd.value;
    			//sheetObjects[3].CellValue2(row, prefix+"slp_desc") = "환대체 " + form.vsl_cd.value + " (VAT) " + form.slp_desc.value;
    			sheetObjects[3].CellValue2(row, prefix+"slp_desc") = "환대체 " + form.vsl_cd.value + " (VAT)";
    			sheetObjects[3].CellValue2(row, prefix+"slp_tp") = "S";
    			sheetObjects[3].CellValue2(row, prefix+"evid_tp_cd") = form.evid_tp_cd.value;
    			//sheetObjects[3].CellValue2(row, prefix+"evid_tp_cd") = "5";
    			sheetObjects[3].CellValue2(row, prefix+"vat_flg") = "2";
    			sheetObjects[3].CellValue2(row, prefix+"dr_amt") = dr_amt2;
        		sheetObjects[3].CellValue2(row, prefix+"diff_amt") = dr_amt2;
        		sheetObjects[3].CellValue2(row, prefix+"balance_amt") = 0;
    		*/
        		
    		} else if(i == 1) {
    			sheetObjects[3].CellValue2(row, prefix+"csr_curr_cd") = "KRW";
    			//sheetObjects[3].CellValue2(row, prefix+"slp_desc") = "선급부가세 " + form.vsl_cd.value + " (VAT) " + form.slp_desc.value;
    			sheetObjects[3].CellValue2(row, prefix+"slp_desc") = "선급부가세 " + form.vsl_cd.value + " (VAT)";
    			sheetObjects[3].CellValue2(row, prefix+"slp_tp") = "S";
    			sheetObjects[3].CellValue2(row, prefix+"evid_tp_cd") = form.evid_tp_cd.value;
    			//sheetObjects[3].CellValue2(row, prefix+"evid_tp_cd") = "5";
    			sheetObjects[3].CellValue2(row, prefix+"vat_flg") = "2";	//2017.05.10 과세처리 로직 보완	 

    			// 영세일 경우 dr_amt, diff_amt 값을 0으로 넘긴다
				if(sheetObjects[1].CellValue(1,"tax_tax_pl_cd") == "1"){
        			sheetObjects[3].CellValue2(row, prefix+"dr_amt") = (parseFloat(0)).toFixed(2);
            		sheetObjects[3].CellValue2(row, prefix+"diff_amt") = (parseFloat(0)).toFixed(2);
				}else{
        			sheetObjects[3].CellValue2(row, prefix+"dr_amt") = dr_amt3.toFixed(0);
            		sheetObjects[3].CellValue2(row, prefix+"diff_amt") = dr_amt3.toFixed(0);
				}
    			
        		sheetObjects[3].CellValue2(row, prefix+"balance_amt") = 0;
    		}

    		sheetObjects[3].CellValue2(row, prefix+"cre_usr_id") = form.usr_id.value;
    		sheetObjects[3].CellValue2(row, prefix+"upd_usr_id") = form.usr_id.value;    		
		}
		
	} else {
		var row = sheetObjects[3].DataInsert(-1);
		
		sheetObjects[3].CellValue2(row, prefix+"slp_ofc_cd") = form.slp_ofc_cd.value;
		sheetObjects[3].CellValue2(row, prefix+"ap_ctr_cd") = form.ap_ctr_cd.value;
		sheetObjects[3].CellValue2(row, prefix+"loc_cd") = form.loc_cd.value;
		sheetObjects[3].CellValue2(row, prefix+"chk_acct_cd") = form.chk_acct_cd.value;
		sheetObjects[3].CellValue2(row, prefix+"chk_ctr_cd") = form.chk_ctr_cd.value;
		
		sheetObjects[3].CellValue2(row, prefix+"chk_bunker_vvd") = form.chk_bunker_vvd.value;
		sheetObjects[3].CellValue2(row, prefix+"pre_work_flag") = form.pre_work_flag.value;
		sheetObjects[3].CellValue2(row, prefix+"evid_tp_cd_val") = form.evid_tp_cd_val.value;
		sheetObjects[3].CellValue2(row, prefix+"usd_locl_xch_rt") = form.usd_locl_xch_rt.value;
		sheetObjects[3].CellValue2(row, prefix+"flet_ctrt_no") = form.flet_ctrt_no.value;
		
		sheetObjects[3].CellValue2(row, prefix+"vsl_cd") = form.vsl_cd.value;
		sheetObjects[3].CellValue2(row, prefix+"vsl_eng_nm") = form.vsl_eng_nm.value;
		sheetObjects[3].CellValue2(row, prefix+"flet_ctrt_tp_cd") = form.flet_ctrt_tp_cd.Text;
		sheetObjects[3].CellValue2(row, prefix+"csr_curr_cd") = form.csr_curr_cd.value;
		sheetObjects[3].CellValue2(row, prefix+"slp_iss_dt") = form.slp_iss_dt.value;
		
		sheetObjects[3].CellValue2(row, prefix+"usr_nm") = form.usr_nm.value;
		sheetObjects[3].CellValue2(row, prefix+"csr_no") = form.csr_no.value;
		sheetObjects[3].CellValue2(row, prefix+"slp_desc") = form.slp_desc.value;
		sheetObjects[3].CellValue2(row, prefix+"apro_step") = form.apro_step.value;
		
		if(form.slp_tp[0].checked) {
			sheetObjects[3].CellValue2(row, prefix+"slp_tp") = form.slp_tp[0].value;
		} else if(form.slp_tp[1].checked) {
			sheetObjects[3].CellValue2(row, prefix+"slp_tp") = form.slp_tp[1].value;
		} else if(form.slp_tp[2].checked) {
			sheetObjects[3].CellValue2(row, prefix+"slp_tp") = form.slp_tp[2].value;
		} else if(form.slp_tp[3].checked) {
			sheetObjects[3].CellValue2(row, prefix+"slp_tp") = form.slp_tp[3].value;
		}

		sheetObjects[3].CellValue2(row, prefix+"evid_tp_cd") = form.evid_tp_cd.value;
		
		sheetObjects[3].CellValue2(row, prefix+"rqst_dt") = form.rqst_dt.value.trimAll('-');
		sheetObjects[3].CellValue2(row, prefix+"eff_dt") = form.eff_dt.value.trimAll('-');
		sheetObjects[3].CellValue2(row, prefix+"ownr_cd") = form.ownr_cd.value;
		sheetObjects[3].CellValue2(row, prefix+"ppay_hir_no") = form.ppay_hir_no.value;
		sheetObjects[3].CellValue2(row, prefix+"vat_flg") = "1";

		sheetObjects[3].CellValue2(row, prefix+"cre_usr_id") = form.usr_id.value;
		sheetObjects[3].CellValue2(row, prefix+"upd_usr_id") = form.usr_id.value;
			
		
		// 영세일 경우 dr_amt, diff_amt 값을 0으로 넘긴다
		if(sheetObjects[1].CellValue(1,"tax_tax_pl_cd") == "1"){
			sheetObjects[3].CellValue2(row, prefix+"dr_amt") = (parseFloat(0)).toFixed(2);
    		sheetObjects[3].CellValue2(row, prefix+"diff_amt") = (parseFloat(0)).toFixed(2);
		}else{
    		sheetObjects[3].CellValue2(row, prefix+"dr_amt") = form.dr_amt.value;
    		sheetObjects[3].CellValue2(row, prefix+"diff_amt") = form.diff_amt.value;
		}
		
		sheetObjects[3].CellValue2(row, prefix+"balance_amt") = form.balance_amt.value;
	}
}

    /**
     * Balance Amt 체크하기 <br>
     * @param {ibsheet}	sheetObj    IBSheet Object
     * @param {없음}
     **/
    function checkBalance(sheetObj) {    	
    	var balanceAmt = form.balance_amt.value;
    	
	    if( form.slp_tp[0].checked 
	     || form.slp_tp[1].checked 
	     || form.slp_tp[2].checked ){	
	   
	    	if(parseFloat(balanceAmt) < 0) {
	    		
	    		for(var ir=1; ir<=sheetObj.LastRow; ir++) {
					if(sheetObj.CellValue(ir,"vat_flg") != "") {
						sheetObj.CellValue2(ir,"DelChk") = 1;
					}
				}	    		
	    		rowRemove(sheetObj, "");	    		
	    		ComShowCodeMessage("FMS01471");
	  			return false;
	    	}
	    }else if(form.slp_tp[3].checked){	       
	     	
	    	if(parseFloat(balanceAmt) != 0) {
	    		
	    		for(var ir=1; ir<=sheetObj.LastRow; ir++) {
					if(sheetObj.CellValue(ir,"vat_flg") != "") {
						sheetObj.CellValue2(ir,"DelChk") = 1;
					}
				}	    		
	    		rowRemove(sheetObj, "");	    		
	    		ComShowCodeMessage("FMS01480");
	  			return false;
	    	}
	    	
	    }	
    	return true;
    }
     
    /**
     * Account 별 VVD Level Check
     * 계정 항차 레벨을 체크하여 해당 계정에 대해 항차를 입력해야하는지를 판단 <br>
     * @param {ibsheet}	 sheetObj    IBSheet Object
     * @param {ibsheet}  row     	 sheetObj의 선택된 Row
     * @return {boolean} true : 항차 레벨 검사, false : pass
     **/
    function checkAcctCdVvdLevel(sheetObj, row) {
    	//Account 별 VVD Level Check
    	var acctCdCol = sheetObj.SaveNameCol("acct_cd");
		var acctCdValue = sheetObj.CellValue(row,acctCdCol);
		
		if((   acctCdValue.substring(0,1) == "4"
		    || acctCdValue.substring(0,1) == "6"
		    || acctCdValue.substring(0,1) == "7"
		    || acctCdValue.substring(0,2) == "51"
		    || acctCdValue == "956115"
		    || acctCdValue == "962111"
		    || acctCdValue == "111071") && !(   acctCdValue.substring(0,4) == "4212"
				    						 || acctCdValue.substring(0,4) == "5801"
				    						 || acctCdValue == "612900"
				    					     || acctCdValue == "712900")) {
			
			return true;
		} else {
			return false;
		}
    }

    /**
     * Account 별 VVD Level Check(해당 계정에 대한 항차 필수입력 여부 체크)
     * 계정 항차 레벨을 체크하여 해당 계정에 대해 항차를 입력해야하는지를 판단 <br>
     * @param {ibsheet}	 sheetObj    IBSheet Object
     * @param {ibsheet}  row     	 sheetObj의 선택된 Row
     * @return {boolean} true : 필수입력, false : pass
     **/
    function checkAcctCdVvdLevelMdt(sheetObj, row) {
    	//Account 별 VVD Level Check
    	var acctCdCol = sheetObj.SaveNameCol("acct_cd");
		var acctCdValue = sheetObj.CellValue(row,acctCdCol);
		
		if(	  acctCdValue.substring(0,4) == "4212"
		   || acctCdValue.substring(0,4) == "5801"
		   || acctCdValue == "612900"
	       || acctCdValue == "712900") {
			
			return true;
		} else {
			return false;
		}
    }
     
    /**
     * Evidence Type Default 값 세팅
     * ETC Data Default 세팅(코드값:5) <br>
     **/
    function setEvidenceType() {
    	var length = form.evid_tp_cd.length;
		
		if(length > 0) {
			for(var i=0; i<length; i++) {
				if(form.evid_tp_cd.options[i].value == "5") {
					form.evid_tp_cd.selectedIndex = i;
					break;
				}
			}
		}
    }
     
    /**
     * Tax Evidence 버튼 클릭 시 VAT Apply 체크박스 초기화
     * @param {ibsheet}	sheetObj    IBSheet Object
     **/
    function setInitVatApply(sheetObj) {
    	for(var ir=1; ir<=sheetObj.LastRow; ir++) {
    		sheetObj.CellValue2(ir,"vat_apply") = 0;
		}
    }
    
    /**
     * Grid 내 Cell Font를 'Courier New'체로 변경한다<br>
     * @param {ibsheet}	sheetObj    IBSheet Object
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     * @return {없음}
     **/
    function setCellFont(sheetObj, row) {
    	sheetObj.CellFont("FontName", row, "slp_loc_cd") = "Courier New";
    	sheetObj.CellFont("FontName", row, "bunker_vvd") = "Courier New";
    	sheetObj.CellFont("FontName", row, "key_number") = "Courier New";
    }

	
    /**
     * DoSearch로 조회 완료후 발생하는 이벤트 <br>
     * @param {ibsheet}	sheetObj    IBSheet Object
     * @param {String}  ErrMsg    	Error 메세지
     **/
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	 
    	var csrNo = sheetObj.EtcData("csrNo");
      	
 		if(typeof csrNo != "undefined" && csrNo != "" ) {
 			form.csr_no.value = csrNo;
     	
	    	// Mandantory 항목에 대한 버튼 및 Input 박스 Setting
	     	saveReadOnly();
	    	
	    	/*
	     	var csrNo = sheetObj.EtcData("csrNo");
	     	
			if(typeof csrNo != "undefined" && csrNo != "" ) {
				form.csr_no.value = csrNo;
			}
			*/
			
			sheetObj.ColHidden("seq_no") = true;
			sheetObj.ColHidden("slp_seq_num") = false;
	     	
	     	for (var ir=1; ir<=sheetObj.LastRow; ir++){
	     		sheetObj.CellEditable(ir, "DelChk") = false;
	     		sheetObj.CellEditable(ir, "acct_cd") = false;
	     		sheetObj.CellEditable(ir, "inv_amt") = false;
	     		sheetObj.CellEditable(ir, "bunker_vvd") = false;
	     		sheetObj.CellEditable(ir, "key_number") = false;
	     		sheetObj.CellEditable(ir, "csr_desc") = false;
	     		sheetObj.CellEditable(ir, "vat_apply") = false;
	     	}
	     	
	     	ComColFontName(sheetObj, "7"); 
	     	ComColFontName(sheetObj, "10"); 
	     	ComColFontName(sheetObj, "11");
	     	
 		} else {
 			//Master 생성 데이타 초기화
 			sheetObjects[3].RemoveAll();
 			
 			//세금계산서 / 계산서 생성 데이타 초기화
 			for (var ir=sheetObj.LastRow; ir>=sheetObj.HeaderRows; ir--) {
    			if(sheetObj.CellValue(ir,"flet_src_tp_cd") == "20") {
    				sheetObj.CellValue2(ir,"DelChk") = 1;
    				rowRemove(sheetObj, "");
    			} else {
    				sheetObj.CellValue2(ir, "vat_apply") = 0;
    			}
    		}
 		}
 	}
     
    /**
   	 * 페이지에 있는 RD Object를 로드한다. <br>
   	 * {@link #loadPage}함수에서 이 함수를 호출하여 RD Object를 초기화 한다. <br>
   	 * @param {rdObject} rdObject    RD Object
   	 **/
   	function initRdConfig(rdObject){
   	    var Rdviewer = rdObject ;
   	    Rdviewer.style.height = 0;
   	    Rdviewer.style.width = 0;
   	    
   	    Rdviewer.AutoAdjust = true;
   	    Rdviewer.ViewShowMode(0);

   		Rdviewer.setbackgroundcolor(128,128,128);
   		Rdviewer.SetPageLineColor(128,128,128);
   	}
     
    /**
     * RD 출력하기 <br>
     * @param {ibsheet}	rdObject    IBSheet Object
     * @param {form}    formObj     Form Object
     **/
    function rdOpen(rdObject, formObject){
    	
  		if(sheetObjects[0].RowCount == 0) {
  			ComShowCodeMessage("FMS00015");
  			return;
  		}
  		
  		if(form.csr_no.value == "") {
  			ComShowCodeMessage("FMS00015");
  			return;
  		}

 		var Rdviewer = rdObject ;
 	
 		rdParam = RD_FormQueryString(formObject,1);
 		var rdParam = '/rv '+ rdParam;
 		var rdFile = 'ESM_FMS_031.mrd';

 		// 열고자 하는 RD 파일을 지정한다.
 	    Rdviewer.FileOpen(RD_path+'apps/alps/esm/fms/timecharterinoutaccounting/tcharterioconsultation/report/'+rdFile, RDServer+rdParam);
 		Rdviewer.CMPrint (); //인쇄 시작
 		
 		
 		//ar csr no
 		
 		if(ar_csr_no == "") {
  			return;
  		}
 		
 		var tmp_csr_no = form.csr_no.value;
 		form.csr_no.value = ar_csr_no;
 		form.csr_type.value = "AR";
 		
 		var Rdviewer = rdObject ;
 	 	
 		rdParam = RD_FormQueryString(formObject,1);
 		var rdParam = '/rv '+ rdParam;
 		var rdFile = 'ESM_FMS_031.mrd';

 		form.csr_no.value = tmp_csr_no; // 원래대로 전표
 		form.csr_type.value = "AP";
 		
 		// 열고자 하는 RD 파일을 지정한다.
 	    Rdviewer.FileOpen(RD_path+'apps/alps/esm/fms/timecharterinoutaccounting/tcharterioconsultation/report/'+rdFile, RDServer+rdParam);
 		Rdviewer.CMPrint (); //인쇄 시작

 	}
    
    function rdOpenPreview(rdObject, formObject){
    	
  		if(sheetObjects[0].RowCount == 0) {
  			ComShowCodeMessage("FMS00015");
  			return;
  		}
  		
  		if(form.csr_no.value == "") {
  			ComShowCodeMessage("FMS00015");
  			return;
  		}
 	
 		rdParam = RD_FormQueryString(formObject,1);
 		var rdParam = '/rv '+ rdParam;
 		var strPath = 'apps/alps/esm/fms/timecharterinoutaccounting/tcharterioconsultation/report/ESM_FMS_031.mrd';
 		
 		formObject.com_mrdPath.value = strPath;
 		formObject.com_mrdArguments.value = rdParam;
        ComOpenRDPopupModal('resizable=yes;dialogWidth:750px;dialogHeight:690px');    	
 		
 		//ar csr no
 		
 		if(ar_csr_no == "") {
  			return;
  		}
 		
 		var tmp_csr_no = form.csr_no.value;
 		form.csr_no.value = ar_csr_no;
 		form.csr_type.value = "AR";
 	 	
 		rdParam = RD_FormQueryString(formObject,1);
 		var rdParam = '/rv '+ rdParam;
 		var strPath = 'apps/alps/esm/fms/timecharterinoutaccounting/tcharterioconsultation/report/ESM_FMS_031.mrd';

 		form.csr_no.value = tmp_csr_no; // 원래대로 전표
 		form.csr_type.value = "AP";
 		
 		formObject.com_mrdPath.value = strPath;
 		formObject.com_mrdArguments.value = rdParam;
        ComOpenRDPopupModal('resizable=yes;dialogWidth:750px;dialogHeight:690px');    	

 	}
    
	/**
 	 * Hire Statement PopUp창에서 조회한 데이터를 설정한다.<br>
 	 * @param {arry} aryPopupData
 	 */
// 	function setHireStatement(aryPopupData) {
//
// 		var seqNo = 0;
// 		var csrAmt = 0;
// 		
// 		//alert("bb");		
//
//		var ownersAccountData = aryPopupData[0];
//
// 		// 110811 첫번재
//		var row = sheetObjects[4].DataInsert(-1);
//		
//		sheetObjects[4].CellValue2(row,"slp_tp_cd") = "20";
//		sheetObjects[4].CellValue2(row,"slp_func_cd") = "T";
//		sheetObjects[4].CellValue2(row,"slp_ofc_cd") = form.slp_ofc_cd.value;
//		
//		//alert("cc");
//		
//		var slpSeqNo;
//		seqNo++;
//		
//		if(seqNo.toString().length == 1) {
//			slpSeqNo = "000" + seqNo;
//		} else if(seqNo.toString().length == 2) {
//			slpSeqNo = "00" + seqNo;
//		} else if(seqNo.toString().length == 3) {
//			slpSeqNo = "0" + seqNo;
//		} else {
//			slpSeqNo = seqNo;
//		}
//		
//  		/*if(cust_cnt_cd == "" || cust_seq == "") {
//  			ComShowCodeMessage("FMS20002");
//  			return;
//  		}*/
//
//		// 첫번째 110811
//		sheetObjects[4].CellValue2(row,"slp_seq_no") = slpSeqNo;
//		sheetObjects[4].CellValue2(row,"acct_cd") = "110811";
//		sheetObjects[4].CellValue2(row,"ctr_cd") = ownersAccountData.ctr_cd;
//		sheetObjects[4].CellValue2(row,"slp_loc_cd") = ownersAccountData.slp_loc_cd;
//		sheetObjects[4].CellValue2(row,"csr_curr_cd") = ownersAccountData.curr_cd;
//		sheetObjects[4].CellValue2(row,"csr_amt") = -ar_olay_amt;
//		sheetObjects[4].CellValue2(row,"cust_cnt_cd") = cust_cnt_cd;
//		sheetObjects[4].CellValue2(row,"cust_seq") = cust_seq;
//		sheetObjects[4].CellValue2(row,"trns_curr_cd") = ownersAccountData.curr_cd;
//		sheetObjects[4].CellValue2(row,"slp_iss_dt") = form.slp_iss_dt.value;
//		//sheetObjects[4].CellValue2(row,"vvd_eff_dt") = hirRevenueData.eff_dt;
//		//sheetObjects[4].CellValue2(row,"vvd_exp_dt") = hirRevenueData.exp_dt;
//		sheetObjects[4].CellValue2(row,"trns_amt") = -ar_olay_amt;
//		sheetObjects[4].CellValue2(row,"inv_seq") = "";
//		sheetObjects[4].CellValue2(row,"eff_dt") = form.eff_dt.value;
//		sheetObjects[4].CellValue2(row,"flet_ctrt_no") = form.flet_ctrt_no.value;
//		//sheetObjects[4].CellValue2(row,"flet_iss_tp_cd") = form.flet_iss_tp_cd.value;
//		sheetObjects[4].CellValue2(row,"inv_dtl_seq") = "";
//		
//		sheetObjects[4].CellValue2(row+1,"csr_desc") = form.vsl_cd.value + " O/A, OUTLAY COMM";
//		sheetObjects[4].CellValue2(row+1,"vvd_cd") = "CNTC" + form.eff_dt.value.trimAll('-').substring(2,6) + "MM";
//		sheetObjects[4].CellValue2(row+1,"to_inv_no") = form.vsl_cd.value + form.eff_dt.value.trimAll('-').substring(2,6)
//		sheetObjects[4].CellValue2(row+1,"to_inv_no1") = form.vsl_cd.value + form.eff_dt.value.trimAll('-').substring(2,6)
//
//		//form.rqst_amt.value = 0;
//		
//		//alert("dd");
//		
// 		// 110811 두번재
//		var row = sheetObjects[4].DataInsert(-1);
//		
//		sheetObjects[4].CellValue2(row,"slp_tp_cd") = "20";
//		sheetObjects[4].CellValue2(row,"slp_func_cd") = "T";
//		sheetObjects[4].CellValue2(row,"slp_ofc_cd") = form.slp_ofc_cd.value;
//		
//		//alert("cc");
//		
//		var slpSeqNo;
//		seqNo++;
//		
//		if(seqNo.toString().length == 1) {
//			slpSeqNo = "000" + seqNo;
//		} else if(seqNo.toString().length == 2) {
//			slpSeqNo = "00" + seqNo;
//		} else if(seqNo.toString().length == 3) {
//			slpSeqNo = "0" + seqNo;
//		} else {
//			slpSeqNo = seqNo;
//		}
//
//		sheetObjects[4].CellValue2(row,"slp_seq_no") = slpSeqNo;
//		sheetObjects[4].CellValue2(row,"acct_cd") = "110811";
//		sheetObjects[4].CellValue2(row,"ctr_cd") = ownersAccountData.ctr_cd;
//		sheetObjects[4].CellValue2(row,"slp_loc_cd") = ownersAccountData.slp_loc_cd;
//		sheetObjects[4].CellValue2(row,"csr_curr_cd") = ownersAccountData.curr_cd;
//		sheetObjects[4].CellValue2(row,"csr_amt") = ar_olay_amt;
//		sheetObjects[4].CellValue2(row,"cust_cnt_cd") = cust_cnt_cd;
//		sheetObjects[4].CellValue2(row,"cust_seq") = cust_seq;
//		sheetObjects[4].CellValue2(row,"trns_curr_cd") = ownersAccountData.curr_cd;
//		sheetObjects[4].CellValue2(row,"slp_iss_dt") = form.slp_iss_dt.value;
//		//sheetObjects[4].CellValue2(row,"vvd_eff_dt") = hirRevenueData.eff_dt;
//		//sheetObjects[4].CellValue2(row,"vvd_exp_dt") = hirRevenueData.exp_dt;
//		sheetObjects[4].CellValue2(row,"trns_amt") = ar_olay_amt;
//		sheetObjects[4].CellValue2(row,"inv_seq") = "";
//		sheetObjects[4].CellValue2(row,"eff_dt") = form.eff_dt.value;
//		sheetObjects[4].CellValue2(row,"flet_ctrt_no") = form.flet_ctrt_no.value;
//		//sheetObjects[4].CellValue2(row,"flet_iss_tp_cd") = form.flet_iss_tp_cd.value;
//		sheetObjects[4].CellValue2(row,"inv_dtl_seq") = "";
//		
//		sheetObjects[4].CellValue2(row+1,"csr_desc") = form.vsl_cd.value + " O/A, OUTLAY COMM";
//		sheetObjects[4].CellValue2(row+1,"vvd_cd") = "CNTC" + form.eff_dt.value.trimAll('-').substring(2,6) + "MM";
//		sheetObjects[4].CellValue2(row+1,"to_inv_no") = form.vsl_cd.value + form.eff_dt.value.trimAll('-').substring(2,6)
//		sheetObjects[4].CellValue2(row+1,"to_inv_no1") = form.vsl_cd.value + form.eff_dt.value.trimAll('-').substring(2,6)
//		
//       //4번째 Detail 954112
//		var row = sheetObjects[4].DataInsert(-1);
//		
//		sheetObjects[4].CellValue2(row,"slp_tp_cd") = "20";
//		sheetObjects[4].CellValue2(row,"slp_func_cd") = "T";
//		sheetObjects[4].CellValue2(row,"slp_ofc_cd") = form.slp_ofc_cd.value;		
//	
//		var slpSeqNo;
//		seqNo++;
//		
//		if(seqNo.toString().length == 1) {
//			slpSeqNo = "000" + seqNo;
//		} else if(seqNo.toString().length == 2) {
//			slpSeqNo = "00" + seqNo;
//		} else if(seqNo.toString().length == 3) {
//			slpSeqNo = "0" + seqNo;
//		} else {
//			slpSeqNo = seqNo;
//		}
//		
//		sheetObjects[4].CellValue2(row,"slp_seq_no") = slpSeqNo;
//		sheetObjects[4].CellValue2(row,"acct_cd") = "954112";
//		sheetObjects[4].CellValue2(row,"ctr_cd") = ownersAccountData.ctr_cd;
//		sheetObjects[4].CellValue2(row,"slp_loc_cd") = ownersAccountData.slp_loc_cd;
//		sheetObjects[4].CellValue2(row,"csr_curr_cd") = ownersAccountData.curr_cd;
//		sheetObjects[4].CellValue2(row,"csr_amt") = -ar_olay_amt;
//		sheetObjects[4].CellValue2(row,"cust_cnt_cd") = cust_cnt_cd;
//		sheetObjects[4].CellValue2(row,"cust_seq") = cust_seq;
//		sheetObjects[4].CellValue2(row,"trns_curr_cd") = ownersAccountData.curr_cd;
//		sheetObjects[4].CellValue2(row,"slp_iss_dt") = form.slp_iss_dt.value;
//		//sheetObjects[4].CellValue2(row,"vvd_eff_dt") = hirRevenueData.eff_dt;
//		//sheetObjects[4].CellValue2(row,"vvd_exp_dt") = hirRevenueData.exp_dt;
//		sheetObjects[4].CellValue2(row,"trns_amt") = -ar_olay_amt;
//		sheetObjects[4].CellValue2(row,"inv_seq") = "";
//		sheetObjects[4].CellValue2(row,"eff_dt") = form.eff_dt.value;
//		sheetObjects[4].CellValue2(row,"flet_ctrt_no") = form.flet_ctrt_no.value;
//		//sheetObjects[4].CellValue2(row,"flet_iss_tp_cd") = form.flet_iss_tp_cd.value;
//		sheetObjects[4].CellValue2(row,"inv_dtl_seq") = "";
//		
//		sheetObjects[4].CellValue2(row+1,"csr_desc") = form.vsl_cd.value + " O/A, OUTLAY COMM";
//		sheetObjects[4].CellValue2(row+1,"vvd_cd") = "CNTC" + form.eff_dt.value.trimAll('-').substring(2,6) + "MM";
//		sheetObjects[4].CellValue2(row+1,"to_inv_no") = form.vsl_cd.value + form.eff_dt.value.trimAll('-').substring(2,6)
//		sheetObjects[4].CellValue2(row+1,"to_inv_no1") = form.vsl_cd.value + form.eff_dt.value.trimAll('-').substring(2,6)
//		//alert("ee");
//		
//	    //3번째 Detail 954113
//		var row = sheetObjects[4].DataInsert(-1);
//		
//		sheetObjects[4].CellValue2(row,"slp_tp_cd") = "20";
//		sheetObjects[4].CellValue2(row,"slp_func_cd") = "T";
//		sheetObjects[4].CellValue2(row,"slp_ofc_cd") = form.slp_ofc_cd.value;
//		
//		var slpSeqNo;
//		seqNo++;
//		
//		if(seqNo.toString().length == 1) {
//			slpSeqNo = "000" + seqNo;
//		} else if(seqNo.toString().length == 2) {
//			slpSeqNo = "00" + seqNo;
//		} else if(seqNo.toString().length == 3) {
//			slpSeqNo = "0" + seqNo;
//		} else {
//			slpSeqNo = seqNo;
//		}
//
//		sheetObjects[4].CellValue2(row,"slp_seq_no") = slpSeqNo;
//		sheetObjects[4].CellValue2(row,"acct_cd") = "954113";
//		sheetObjects[4].CellValue2(row,"ctr_cd") = ownersAccountData.ctr_cd;
//		sheetObjects[4].CellValue2(row,"slp_loc_cd") = ownersAccountData.slp_loc_cd;
//		sheetObjects[4].CellValue2(row,"csr_curr_cd") = ownersAccountData.curr_cd;
//		sheetObjects[4].CellValue2(row,"csr_amt") = ar_olay_amt;
//		sheetObjects[4].CellValue2(row,"cust_cnt_cd") = cust_cnt_cd;
//		sheetObjects[4].CellValue2(row,"cust_seq") = cust_seq;
//		sheetObjects[4].CellValue2(row,"trns_curr_cd") = ownersAccountData.curr_cd;
//		sheetObjects[4].CellValue2(row,"slp_iss_dt") = form.slp_iss_dt.value;
//		//sheetObjects[4].CellValue2(row,"vvd_eff_dt") = hirRevenueData.eff_dt;
//		//sheetObjects[4].CellValue2(row,"vvd_exp_dt") = hirRevenueData.exp_dt;
//		sheetObjects[4].CellValue2(row,"trns_amt") = ar_olay_amt;
//		sheetObjects[4].CellValue2(row,"inv_seq") = "";
//		sheetObjects[4].CellValue2(row,"eff_dt") = form.eff_dt.value;
//		sheetObjects[4].CellValue2(row,"flet_ctrt_no") = form.flet_ctrt_no.value;
//		//sheetObjects[4].CellValue2(row,"flet_iss_tp_cd") = form.flet_iss_tp_cd.value;
//		sheetObjects[4].CellValue2(row,"inv_dtl_seq") = "";
//		
//		sheetObjects[4].CellValue2(row+1,"csr_desc") = form.vsl_cd.value + " O/A, OUTLAY COMM";
//		sheetObjects[4].CellValue2(row+1,"vvd_cd") = "CNTC" + form.eff_dt.value.trimAll('-').substring(2,6) + "MM";
//		sheetObjects[4].CellValue2(row+1,"to_inv_no") = form.vsl_cd.value + form.eff_dt.value.trimAll('-').substring(2,6)
//		sheetObjects[4].CellValue2(row+1,"to_inv_no1") = form.vsl_cd.value + form.eff_dt.value.trimAll('-').substring(2,6)
//		
//		//alert("ff");
//
// 	}
 	
 	//선박 대 계약 자동 매치
    function initDefaultContractNo(){
  	  doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);   
    }
	
  //===========================================================================================================================
  //===========================================================================================================================
  //===========================================================================================================================    
    /**
     * Owner’s Account PopUp창에서 조회한 데이터를 설정한다.(Standard)
     * @param {arry} aryPopupData
     */
    function setOwnersAccountStd(aryPopupData) {
    	
    	var olay_amt = 0;
    	var olay_rt_amt = 0;
    	var n1st_amt_sum = 0;
    	var manhour_ch_amt = 0;
    	var acct_cd = "";
    	var csr_amt = 0;
    	var csr_desc = "";
 		var n1st_amt_sum = 0;    	
 		var olay_amt = 0;
 		var olay_rt_amt = 0;
 		var oa_comm_flag_chk = 0;
    	
 		ar_olay_amt = 0;
 		
    	if((cust_cnt_cd == "" || cust_seq == "") && aryPopupData[0].flet_olay_comm_rt_amt > 0) {
    		ComShowCodeMessage("FMS20002");
    		return;
    	}
    	
    	for(var i=0; i<aryPopupData.length; i++) {    		
    		var ownersAccountDataStd = aryPopupData[i];
    		    		
    		if((form.slp_tp[0].checked || form.slp_tp[1].checked) && ownersAccountDataStd.oa_stl_sts_cd == "REFUND") {		// Standard	        		
    				// 첫번째 Row
		    		csr_amt = ownersAccountDataStd.n1st_amt;
		    		csr_desc = ownersAccountDataStd.ap_desc;		    		
		    		//2) Slip Amount 값이 반대부호가 되어야 합니다 (음수 -> 양수, 양수 -> 음수)
		    		csr_amt = csr_amt*-1;
		    		setStandardData(ownersAccountDataStd,"111071", csr_amt, csr_desc);		   		//111071 계정 생성
		    		
		    		
		    		
		    		
    				// 두번째 Row		    		
		    		//EX_DIFF_USD 양수 이면 580111
		    		//EX_DIFF_USD 음수 이면 421211    		    		
		    		if(ownersAccountDataStd.ex_diff_usd != 0){  // EX_DIFF_USD가 0이면 두번째 Row 생성 안 함.
				    		if(ownersAccountDataStd.ex_diff_usd > 0){
				    			acct_cd = "580111";	
				        		csr_desc = "Loss FRGN Exchange, "+ownersAccountDataStd.initial_desc;
				    		}else{
				    			acct_cd = "421211";    			
				        		csr_desc = "Gain FRGN Exchange, "+ownersAccountDataStd.initial_desc;    			
				    		}    				    				    		
				    		csr_amt = ownersAccountDataStd.ex_diff_usd;
				    		ownersAccountDataStd.flet_src_tp_cd = "10";
				    		setStandardData(ownersAccountDataStd,acct_cd, csr_amt, csr_desc);		   		//580111, 421211 계정생성
		    		}
		    		
    				// 세번째 Row	
		    		if(ownersAccountDataStd.oa_comm_flag == 1 && ownersAccountDataStd.flet_olay_comm_rt_amt != 0){		//Outlay comm 전표관련 보완 2017.05.18
		    			csr_amt = ownersAccountDataStd.refund_add_comm;
			    		csr_desc = "O/A, OUTLAY COMM";  
			    		ownersAccountDataStd.flet_src_tp_cd = "10";
			    		setStandardData(ownersAccountDataStd,"954113", csr_amt, csr_desc);			//954113 계정생성
			    		
						ar_olay_amt += parseFloat(ownersAccountDataStd.refund_add_comm);			//	 Slip Amount 
			    		//setHireStatementStd(ownersAccountDataStd);
			    		
			    		oa_comm_flag_chk++;		//Outlay comm 전표관련 보완 2017.05.18
		    		}
    	    }else{    			    				// Prepayment, Prepayment without Hire, Prepayment Bunker 	
    			if(ownersAccountDataStd.oa_comm_flag == 1 && ownersAccountDataStd.flet_olay_comm_rt_amt != 0){					// oa_comm_flag 체크:1, oa_comm_flag비체크:0		//Outlay comm 전표관련 보완 2017.05.18
    				oa_comm_flag_chk++;
    				olay_amt += parseFloat(((-parseFloat(ownersAccountDataStd.n1st_amt)) * parseFloat(ownersAccountDataStd.flet_olay_comm_rt_amt) / 100).toFixed(2)); 	//Outlay comm 전표관련 보완 2017.05.18   				
    			}
    			
    			csr_amt = -ownersAccountDataStd.n1st_amt;
	    		csr_desc = ownersAccountDataStd.ap_desc;    			
	    		setStandardData(ownersAccountDataStd,"111071", csr_amt, csr_desc);		   		//111071 계정 생성    			    			
    		}    		
    	}	
    	    	
    	/* Outlay comm 전표관련 보완 2017.05.18
		if((form.slp_tp[0].checked || form.slp_tp[1].checked) && ownersAccountDataStd.oa_stl_sts_cd == "REFUND") {		//	Standard
    		ownersAccountDataStd = aryPopupData[0];						    		
    		olay_rt_amt = ownersAccountDataStd.flet_olay_comm_rt_amt;    		
    		
			ar_olay_amt = olay_amt;					// Slip Amount
			ar_olay_rt_amt = olay_rt_amt;			// 	flet_olay_comm_rt_amt    		    					
		}else{										// Prepayment, Prepayment without Hire, Prepayment Bunker
    	*/
    	
    		ownersAccountDataStd = aryPopupData[0];						    		
    		olay_rt_amt = ownersAccountDataStd.flet_olay_comm_rt_amt;
    		
			if(olay_rt_amt > 0){
				//olay_amt = (n1st_amt_sum * olay_rt_amt / 100).toFixed(2);		//Outlay comm 전표관련 보완 2017.05.18	
			  	
				olay_amt = parseFloat(olay_amt.toFixed(2));
				ar_olay_amt += olay_amt;					// Slip Amount
				ar_olay_amt = parseFloat(ar_olay_amt.toFixed(2));
				
				csr_amt = olay_amt;
				csr_desc = "O/A, OUTLAY COMM";
				ownersAccountDataStd.flet_src_tp_cd = "10";
								
				// 7) 한건도 O/A Comm 선택이 안 될 경우 Main 그리드에 954113 계정 Row 안 나오게 해 주세요
			    //     아래 쉬트(대선 전표) 안 나오게 해 주세요 (Row 가 없으면 대선 전표 생성하지 않게 해 주세요)
				if(oa_comm_flag_chk > 0 && olay_amt != 0){
					setStandardData(ownersAccountDataStd,"954113", csr_amt, csr_desc);			//954113 계정생성\	
				}
				
				if(oa_comm_flag_chk > 0 && ar_olay_amt != 0){
					ar_olay_rt_amt = olay_rt_amt;			// 	flet_olay_comm_rt_amt
					setHireStatementStd(ownersAccountDataStd);			
				}else{
/*
					7) 한건도 O/A Comm 선택이 안 될 경우 Main 그리드에 954113 계정 Row 안 나오게 해 주세요   
					   아래 쉬트(대선 전표) 안 나오게 해 주세요 (Row 가 없으면 대선 전표 생성하지 않게 해 주세요) 
					  이 부분이 이해 안됨. Save를 안하게 하라는건지, 아님 save는 하는데 0032는 호출하지 말라는건지..이해 안 됩니다.


					 => AP 전표 Line 에 954113 계정 나오지 않게 해 주시고.
					      대선 전표 생성 하지 말아주세요 ( 0032는 호출하지 말라는 겁니다)					
*/					
					ar_olay_rt_amt = 0;
				}
				
			}
    	//}
		
		setTotalAmount('S');	
		
    }
            
	/**
 	 * Statement PopUp창에서 조회한 데이터를 설정한다.(Standard)<br>
 	 * @param {arry} aryPopupData
 	 */    
    function setStandardData(ownersAccountDataStd, acct_cd, csr_amt, csr_desc){
		var row = sheetObjects[0].DataInsert(-1);
		
		sheetObjects[0].CellValue2(row,"acct_nm") = ownersAccountDataStd.acct_itm_nm;
		sheetObjects[0].CellValue2(row,"acct_cd") = acct_cd;
		sheetObjects[0].CellValue2(row,"vndr_seq") = form.ownr_cd.value;
		sheetObjects[0].CellValue2(row,"ctr_cd") = ownersAccountDataStd.ctr_cd;
		sheetObjects[0].CellValue2(row,"slp_loc_cd") = ownersAccountDataStd.slp_loc_cd;    		    		
		sheetObjects[0].CellValue2(row,"slp_eff_dt") = form.eff_dt.value;
		sheetObjects[0].CellValue2(row,"curr_cd") = ownersAccountDataStd.loc_curr_cd;
		sheetObjects[0].CellValue2(row,"csr_amt") = csr_amt;		
		// 1) Acct Cd : 111071 일 경우만 VVD Code 값이 들어가고, 다른 계정일 경우는 안 들어가게 해 주세요
		if((form.slp_tp[0].checked || form.slp_tp[1].checked) && ownersAccountDataStd.oa_stl_sts_cd == "REFUND"){
			if(acct_cd == "111071"){
				sheetObjects[0].CellValue2(row,"bunker_vvd") = ownersAccountDataStd.vvd_bunker;				
			}else{
				sheetObjects[0].CellValue2(row,"bunker_vvd") = "";				
			}
			
			document.form.slp_desc.value = ownersAccountDataStd.vvd_bunker + " Wrongly Issued O/A Refund to Owner";
		}else{
			if(acct_cd == "954113"){		// 1) Slip Type : Prepayment  일 경우,  Acct Cd : 954113 VVD Code 값이 들 안 들어가게 해 주세요
				sheetObjects[0].CellValue2(row,"bunker_vvd") = "";				
			}else{
				sheetObjects[0].CellValue2(row,"bunker_vvd") = ownersAccountDataStd.vvd_bunker;
			}
		}
						
		sheetObjects[0].CellValue2(row,"csr_desc") = csr_desc;
		sheetObjects[0].CellValue2(row,"flet_src_tp_cd") = ownersAccountDataStd.flet_src_tp_cd;
		sheetObjects[0].CellValue2(row,"ap_slp_tp_cd") = ownersAccountDataStd.slp_tp_cd;
		sheetObjects[0].CellValue2(row,"ap_slp_func_cd") = ownersAccountDataStd.slp_func_cd;
		sheetObjects[0].CellValue2(row,"ap_slp_ofc_cd") = ownersAccountDataStd.slp_ofc_cd;
		sheetObjects[0].CellValue2(row,"ap_slp_iss_dt") = ownersAccountDataStd.slp_iss_dt;
		sheetObjects[0].CellValue2(row,"ap_slp_ser_no") = ownersAccountDataStd.slp_ser_no;
		sheetObjects[0].CellValue2(row,"ap_slp_seq_no") = ownersAccountDataStd.slp_seq_no;		
		sheetObjects[0].CellValue2(row,"pop_gb") = "OWN";
		
		// --------------------------
		// Grid Font 설정하기
		// --------------------------
		setCellFont(sheetObjects[0], row);    	
    } 
    
	/**
 	 * Hire Statement PopUp창에서 조회한 데이터를 설정한다.(Standard)<br>
 	 * @param {arry} aryPopupData
 	 */
 	function setHireStatementStd(ownersAccountData) {
 		var seqNo = 0;
 		var csrAmt = 0;
 		
//		var ownersAccountData = aryPopupData[0];

 		// 110811 첫번재
		var row = sheetObjects[4].DataInsert(-1);
		
		sheetObjects[4].CellValue2(row,"slp_tp_cd") = "20";
		sheetObjects[4].CellValue2(row,"slp_func_cd") = "T";
		sheetObjects[4].CellValue2(row,"slp_ofc_cd") = form.slp_ofc_cd.value;
		
		
		var slpSeqNo;
		seqNo++;
		
		if(seqNo.toString().length == 1) {
			slpSeqNo = "000" + seqNo;
		} else if(seqNo.toString().length == 2) {
			slpSeqNo = "00" + seqNo;
		} else if(seqNo.toString().length == 3) {
			slpSeqNo = "0" + seqNo;
		} else {
			slpSeqNo = seqNo;
		}
		
		// 첫번째 110811
		sheetObjects[4].CellValue2(row,"slp_seq_no") = slpSeqNo;
		sheetObjects[4].CellValue2(row,"acct_cd") = "110811";
		sheetObjects[4].CellValue2(row,"ctr_cd") = ownersAccountData.ctr_cd;
		sheetObjects[4].CellValue2(row,"slp_loc_cd") = ownersAccountData.slp_loc_cd;
		sheetObjects[4].CellValue2(row,"csr_curr_cd") = ownersAccountData.loc_curr_cd;
		sheetObjects[4].CellValue2(row,"csr_amt") = -ar_olay_amt;
		sheetObjects[4].CellValue2(row,"cust_cnt_cd") = cust_cnt_cd;
		sheetObjects[4].CellValue2(row,"cust_seq") = cust_seq;
		sheetObjects[4].CellValue2(row,"trns_curr_cd") = ownersAccountData.loc_curr_cd;
		sheetObjects[4].CellValue2(row,"slp_iss_dt") = form.slp_iss_dt.value;
		sheetObjects[4].CellValue2(row,"trns_amt") = -ar_olay_amt;
		sheetObjects[4].CellValue2(row,"inv_seq") = "";
		sheetObjects[4].CellValue2(row,"eff_dt") = form.eff_dt.value;
		sheetObjects[4].CellValue2(row,"flet_ctrt_no") = form.flet_ctrt_no.value;
		sheetObjects[4].CellValue2(row,"inv_dtl_seq") = "";
		
		sheetObjects[4].CellValue2(row+1,"csr_desc") = form.vsl_cd.value + " O/A, OUTLAY COMM";
		sheetObjects[4].CellValue2(row+1,"vvd_cd") = "CNTC" + form.eff_dt.value.trimAll('-').substring(2,6) + "MM";
		sheetObjects[4].CellValue2(row+1,"to_inv_no") = form.vsl_cd.value + form.eff_dt.value.trimAll('-').substring(2,6)
		sheetObjects[4].CellValue2(row+1,"to_inv_no1") = form.vsl_cd.value + form.eff_dt.value.trimAll('-').substring(2,6)
		
 		// 110811 두번재
		var row = sheetObjects[4].DataInsert(-1);
		
		sheetObjects[4].CellValue2(row,"slp_tp_cd") = "20";
		sheetObjects[4].CellValue2(row,"slp_func_cd") = "T";
		sheetObjects[4].CellValue2(row,"slp_ofc_cd") = form.slp_ofc_cd.value;
				
		var slpSeqNo;
		seqNo++;
		
		if(seqNo.toString().length == 1) {
			slpSeqNo = "000" + seqNo;
		} else if(seqNo.toString().length == 2) {
			slpSeqNo = "00" + seqNo;
		} else if(seqNo.toString().length == 3) {
			slpSeqNo = "0" + seqNo;
		} else {
			slpSeqNo = seqNo;
		}

		sheetObjects[4].CellValue2(row,"slp_seq_no") = slpSeqNo;
		sheetObjects[4].CellValue2(row,"acct_cd") = "110811";
		sheetObjects[4].CellValue2(row,"ctr_cd") = ownersAccountData.ctr_cd;
		sheetObjects[4].CellValue2(row,"slp_loc_cd") = ownersAccountData.slp_loc_cd;
		sheetObjects[4].CellValue2(row,"csr_curr_cd") = ownersAccountData.loc_curr_cd;
		sheetObjects[4].CellValue2(row,"csr_amt") = ar_olay_amt;
		sheetObjects[4].CellValue2(row,"cust_cnt_cd") = cust_cnt_cd;
		sheetObjects[4].CellValue2(row,"cust_seq") = cust_seq;
		sheetObjects[4].CellValue2(row,"trns_curr_cd") = ownersAccountData.loc_curr_cd;
		sheetObjects[4].CellValue2(row,"slp_iss_dt") = form.slp_iss_dt.value;
		sheetObjects[4].CellValue2(row,"trns_amt") = ar_olay_amt;
		sheetObjects[4].CellValue2(row,"inv_seq") = "";
		sheetObjects[4].CellValue2(row,"eff_dt") = form.eff_dt.value;
		sheetObjects[4].CellValue2(row,"flet_ctrt_no") = form.flet_ctrt_no.value;
		sheetObjects[4].CellValue2(row,"inv_dtl_seq") = "";
		
		sheetObjects[4].CellValue2(row+1,"csr_desc") = form.vsl_cd.value + " O/A, OUTLAY COMM";
		sheetObjects[4].CellValue2(row+1,"vvd_cd") = "CNTC" + form.eff_dt.value.trimAll('-').substring(2,6) + "MM";
		sheetObjects[4].CellValue2(row+1,"to_inv_no") = form.vsl_cd.value + form.eff_dt.value.trimAll('-').substring(2,6)
		sheetObjects[4].CellValue2(row+1,"to_inv_no1") = form.vsl_cd.value + form.eff_dt.value.trimAll('-').substring(2,6)
		
       //4번째 Detail 954112
		var row = sheetObjects[4].DataInsert(-1);
		
		sheetObjects[4].CellValue2(row,"slp_tp_cd") = "20";
		sheetObjects[4].CellValue2(row,"slp_func_cd") = "T";
		sheetObjects[4].CellValue2(row,"slp_ofc_cd") = form.slp_ofc_cd.value;		
	
		var slpSeqNo;
		seqNo++;
		
		if(seqNo.toString().length == 1) {
			slpSeqNo = "000" + seqNo;
		} else if(seqNo.toString().length == 2) {
			slpSeqNo = "00" + seqNo;
		} else if(seqNo.toString().length == 3) {
			slpSeqNo = "0" + seqNo;
		} else {
			slpSeqNo = seqNo;
		}
		
		sheetObjects[4].CellValue2(row,"slp_seq_no") = slpSeqNo;
		sheetObjects[4].CellValue2(row,"acct_cd") = "954112";
		sheetObjects[4].CellValue2(row,"ctr_cd") = ownersAccountData.ctr_cd;
		sheetObjects[4].CellValue2(row,"slp_loc_cd") = ownersAccountData.slp_loc_cd;
		sheetObjects[4].CellValue2(row,"csr_curr_cd") = ownersAccountData.loc_curr_cd;
		sheetObjects[4].CellValue2(row,"csr_amt") = -ar_olay_amt;
		sheetObjects[4].CellValue2(row,"cust_cnt_cd") = cust_cnt_cd;
		sheetObjects[4].CellValue2(row,"cust_seq") = cust_seq;
		sheetObjects[4].CellValue2(row,"trns_curr_cd") = ownersAccountData.loc_curr_cd;
		sheetObjects[4].CellValue2(row,"slp_iss_dt") = form.slp_iss_dt.value;
		sheetObjects[4].CellValue2(row,"trns_amt") = -ar_olay_amt;
		sheetObjects[4].CellValue2(row,"inv_seq") = "";
		sheetObjects[4].CellValue2(row,"eff_dt") = form.eff_dt.value;
		sheetObjects[4].CellValue2(row,"flet_ctrt_no") = form.flet_ctrt_no.value;
		sheetObjects[4].CellValue2(row,"inv_dtl_seq") = "";
		
		sheetObjects[4].CellValue2(row+1,"csr_desc") = form.vsl_cd.value + " O/A, OUTLAY COMM";
		sheetObjects[4].CellValue2(row+1,"vvd_cd") = "CNTC" + form.eff_dt.value.trimAll('-').substring(2,6) + "MM";
		sheetObjects[4].CellValue2(row+1,"to_inv_no") = form.vsl_cd.value + form.eff_dt.value.trimAll('-').substring(2,6)
		sheetObjects[4].CellValue2(row+1,"to_inv_no1") = form.vsl_cd.value + form.eff_dt.value.trimAll('-').substring(2,6)
		
	    //3번째 Detail 954113
		var row = sheetObjects[4].DataInsert(-1);
		
		sheetObjects[4].CellValue2(row,"slp_tp_cd") = "20";
		sheetObjects[4].CellValue2(row,"slp_func_cd") = "T";
		sheetObjects[4].CellValue2(row,"slp_ofc_cd") = form.slp_ofc_cd.value;
		
		var slpSeqNo;
		seqNo++;
		
		if(seqNo.toString().length == 1) {
			slpSeqNo = "000" + seqNo;
		} else if(seqNo.toString().length == 2) {
			slpSeqNo = "00" + seqNo;
		} else if(seqNo.toString().length == 3) {
			slpSeqNo = "0" + seqNo;
		} else {
			slpSeqNo = seqNo;
		}

		sheetObjects[4].CellValue2(row,"slp_seq_no") = slpSeqNo;
		sheetObjects[4].CellValue2(row,"acct_cd") = "954113";
		sheetObjects[4].CellValue2(row,"ctr_cd") = ownersAccountData.ctr_cd;
		sheetObjects[4].CellValue2(row,"slp_loc_cd") = ownersAccountData.slp_loc_cd;
		sheetObjects[4].CellValue2(row,"csr_curr_cd") = ownersAccountData.loc_curr_cd;
		sheetObjects[4].CellValue2(row,"csr_amt") = ar_olay_amt;
		sheetObjects[4].CellValue2(row,"cust_cnt_cd") = cust_cnt_cd;
		sheetObjects[4].CellValue2(row,"cust_seq") = cust_seq;
		sheetObjects[4].CellValue2(row,"trns_curr_cd") = ownersAccountData.loc_curr_cd;
		sheetObjects[4].CellValue2(row,"slp_iss_dt") = form.slp_iss_dt.value;
		sheetObjects[4].CellValue2(row,"trns_amt") = ar_olay_amt;
		sheetObjects[4].CellValue2(row,"inv_seq") = "";
		sheetObjects[4].CellValue2(row,"eff_dt") = form.eff_dt.value;
		sheetObjects[4].CellValue2(row,"flet_ctrt_no") = form.flet_ctrt_no.value;
		sheetObjects[4].CellValue2(row,"inv_dtl_seq") = "";
		
		sheetObjects[4].CellValue2(row+1,"csr_desc") = form.vsl_cd.value + " O/A, OUTLAY COMM";
		sheetObjects[4].CellValue2(row+1,"vvd_cd") = "CNTC" + form.eff_dt.value.trimAll('-').substring(2,6) + "MM";
		sheetObjects[4].CellValue2(row+1,"to_inv_no") = form.vsl_cd.value + form.eff_dt.value.trimAll('-').substring(2,6)
		sheetObjects[4].CellValue2(row+1,"to_inv_no1") = form.vsl_cd.value + form.eff_dt.value.trimAll('-').substring(2,6)
 	}
 	
 	//2017.05.15 contract type 콤보로 변경
 	function setDataCombo(comboObj, comboText, comboCode) {
		
        switch(comboObj.id) {
            case "flet_ctrt_tp_cd":
            	
            	if(comboText != "" ) {
	            	var comboTextList = comboText.split("|");
	            	var comboCodeList = comboCode.split("|");
	            	
	            	for(var i=0; i < comboTextList.length-1; i++) {
	            		comboObj.InsertItem(i, comboTextList[i], comboCodeList[i]);
	            	}
	            	
	            	comboObj.Code = comboCodeList[0];
	            	
	            	comboObj.BackColor = "#CCFFFD";
            	}
                break;
                
        } 
    }

 	//2017.05.15 contract type 콤보로 변경
	function flet_ctrt_tp_cd_OnChange(idx_cd, text) {
		
		if(form.vsl_cd.value == "") return;	
	
		var f_query = "";					
		f_query += "f_cmd=" + SEARCH01; 
		f_query += "&vsl_cd="+form.vsl_cd.value;	 			
		f_query += "&type_flag="+text;  
	
		var sXml = sheetObjects[0].GetSearchXml("FMS_COMGS.do",f_query);
		var varFletCtrtNo = ComGetEtcData(sXml, "flet_ctrt_no");
			
		if(typeof varFletCtrtNo != "undefined" && varFletCtrtNo != "" ) {
			form.flet_ctrt_no.value = varFletCtrtNo;
		}else{
			ComShowCodeMessage("FMS20001","Agreement");
			clearAll();
			return;
		}
		
		if(form.flet_ctrt_no.value != ""){
			contract_no_change();
		}
	}