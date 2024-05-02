/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CPS_CNI_0401.js
*@FileTitle : Insurance Main
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.13
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.11.13 윤세영
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
     * @class CPS_CNI_0401 : CPS_CNI_0401 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function CPS_CNI_0401() {
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
	var popupType;

	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	var beforetab1 = 1;
	var beforetab2 = 1;
    
    var uploadObjects = new Array();
	var uploadCnt = 0;
	
	var initload = true;
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];

		/*******************************************************/
		var formObject = document.form;
		try {
    		var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
                case "cal_insur_ctrt_eff_dt":
                
                case "cal_insur_ctrt_exp_dt":
                
                case "cal_ttl_due_dt":
                
                case "cal_ttl_pay_dt":
                
                case "cal_adj_due_dt":
                
                case "cal_adj_pay_dt":
                
                case "cal_rfnd_due_dt":
                
                case "cal_rfnd_pay_dt":
                
                case "cal_ots_due_dt":
                
                case "cal_ots_pay_dt":
                
                case "cal_inst_due_dt_1":
                
                case "cal_inst_pay_dt_1":
                
                case "cal_inst_due_dt_2":
                
                case "cal_inst_pay_dt_2":
                
                case "cal_inst_due_dt_3":
                
                case "cal_inst_pay_dt_3":
                
                case "cal_inst_due_dt_4":
                
                case "cal_inst_pay_dt_4":
                
                case "cal_inst_due_dt_5":
                
                case "cal_inst_pay_dt_5":
                
                case "cal_inst_due_dt_6":
                
                case "cal_inst_pay_dt_6":
                
                case "cal_inst_due_dt_7":
                
                case "cal_inst_pay_dt_7":
                
                case "cal_inst_due_dt_8":
                
                case "cal_inst_pay_dt_8":
                
                case "cal_inst_due_dt_9":
                
                case "cal_inst_pay_dt_9":
                
                case "cal_inst_due_dt_10":
                
                case "cal_inst_pay_dt_10":
					var cal = new ComCalendar();
					cal.setDisplayType('date');
					cal.select(eval("form."+srcName.substring(4)), 'yyyy-MM-dd');
                    break; 
                    
               	case "pop_insur_clm_pty":
                    
               	case "pop_ins_clm_pty":
                    
               	case "pop_rins_clm_pty":
                    
               	case "pop_cins_clm_pty":
                    
               	case "pop_bro_clm_pty":
                    
               	case "pop_insur_clm_pty_prm":
               		popupType = srcName;
					popupMainCodeInquiry();
                    break; 
                    
               	case "btn_insur_ctnt":
					if(!validateForm(sheetObject1,formObject,IBSEARCH)) return;
					var pop_param = "&insur_plcy_yr="+formObject.insur_plcy_yr.value+"&pop_cont_col="+srcName.substring(4) + "&pop_title=Insurer";
               		var insurTpNm = formObject.insur_tp_cd.options[formObject.insur_tp_cd.selectedIndex].text;
					formObject.insur_tp_nm.value = insurTpNm;
					formObject.pop_desc.value = formObject.insur_clm_pty_nm.value;
					ComPostOpenWindow("/hanjin/CPS_CNI_0402.do?"+pop_param, 'CPS_CNI_0402', 'width=1000,height=637');
                    break; 
                    
               	case "btn_ins_ctnt":
					if(!validateForm(sheetObject1,formObject,IBSEARCH)) return;
					var pop_param = "&insur_plcy_yr="+formObject.insur_plcy_yr.value+"&pop_cont_col="+srcName.substring(4) + "&pop_title=Insured";
               		var insurTpNm = formObject.insur_tp_cd.options[formObject.insur_tp_cd.selectedIndex].text;
					formObject.insur_tp_nm.value = insurTpNm;
					formObject.pop_desc.value = formObject.ins_clm_pty_nm.value;
					ComPostOpenWindow("/hanjin/CPS_CNI_0402.do?"+pop_param, 'CPS_CNI_0402', 'width=1000,height=637');
                    break; 
                    
               	case "btn_rins_ctnt":
					if(!validateForm(sheetObject1,formObject,IBSEARCH)) return;
					var pop_param = "&insur_plcy_yr="+formObject.insur_plcy_yr.value+"&pop_cont_col="+srcName.substring(4) + "&pop_title=Reinsurer";
               		var insurTpNm = formObject.insur_tp_cd.options[formObject.insur_tp_cd.selectedIndex].text;
					formObject.insur_tp_nm.value = insurTpNm;
					formObject.pop_desc.value = formObject.rins_clm_pty_nm.value;
					ComPostOpenWindow("/hanjin/CPS_CNI_0402.do?"+pop_param, 'CPS_CNI_0402', 'width=1000,height=637');
                    break; 
                    
               	case "btn_cins_ctnt":
					if(!validateForm(sheetObject1,formObject,IBSEARCH)) return;
					var pop_param = "&insur_plcy_yr="+formObject.insur_plcy_yr.value+"&pop_cont_col="+srcName.substring(4) + "&pop_title=Co-Insured";
               		var insurTpNm = formObject.insur_tp_cd.options[formObject.insur_tp_cd.selectedIndex].text;
					formObject.insur_tp_nm.value = insurTpNm;
					formObject.pop_desc.value = formObject.cins_clm_pty_nm.value;
					ComPostOpenWindow("/hanjin/CPS_CNI_0402.do?"+pop_param, 'CPS_CNI_0402', 'width=1000,height=637');
                    break; 
                    
               	case "btn_int_desc":
					if(!validateForm(sheetObject1,formObject,IBSEARCH)) return;
					var pop_param = "&insur_plcy_yr="+formObject.insur_plcy_yr.value+"&pop_cont_col="+srcName.substring(4) + "&pop_title=Interest";
               		var insurTpNm = formObject.insur_tp_cd.options[formObject.insur_tp_cd.selectedIndex].text;
					formObject.insur_tp_nm.value = insurTpNm;
					eval("form."+srcName.substring(4)).value = eval("form."+srcName.substring(4)+"_nm").value;
					formObject.pop_desc.value = '';
					ComPostOpenWindow("/hanjin/CPS_CNI_0406.do?"+pop_param, 'CPS_CNI_0406', 'width=1000,height=617');
                    break; 
                    
               	case "btn_subj_mat_ins_desc":
					if(!validateForm(sheetObject1,formObject,IBSEARCH)) return;
					var pop_param = "&insur_plcy_yr="+formObject.insur_plcy_yr.value+"&pop_cont_col="+srcName.substring(4) + "&pop_title=Subject Matter Insured";
               		var insurTpNm = formObject.insur_tp_cd.options[formObject.insur_tp_cd.selectedIndex].text;
					formObject.insur_tp_nm.value = insurTpNm;
					eval("form."+srcName.substring(4)).value = eval("form."+srcName.substring(4)+"_nm").value;
					formObject.pop_desc.value = '';
					ComPostOpenWindow("/hanjin/CPS_CNI_0406.do?"+pop_param, 'CPS_CNI_0406', 'width=1000,height=617');
                    break; 
                    
               	case "pop_ins_curr_cd":
					ComOpenPopupWithTarget("COM_ENS_N13.do?classId=COM_ENS_N13&curr_cd=&cnt_cd=&curr_desc=", 500, 450, "curr_cd:"+srcName.substring(4), "1,0,1,1,1", true);
                    break; 
                    
               	case "pop_lmt_ins_curr_cd":
					ComOpenPopupWithTarget("COM_ENS_N13.do?classId=COM_ENS_N13&curr_cd=&cnt_cd=&curr_desc=", 500, 450, "curr_cd:"+srcName.substring(4), "1,0,1,1,1", true);
                    break; 
                    
               	case "pop_ttl_curr_cd":
					ComOpenPopupWithTarget("COM_ENS_N13.do?classId=COM_ENS_N13&curr_cd=&cnt_cd=&curr_desc=", 500, 450, "curr_cd:"+srcName.substring(4), "1,0,1,1,1", true);
                    break; 
                    
               	case "pop_ins_xch_rt":
					//환율 팝업 클릭시 금액, 통화 등 연관 필드도 모두 입력되었는지 체크
					if (!chkFieldAmount(eval("form."+srcName.substring(4,8)+"locl_amt"), eval("form."+srcName.substring(4,8)+"curr_cd"), "Amount Insured")) return;

               		popupType = srcName;
               		var currCd = eval("form."+srcName.substring(4,8)+"curr_cd").value;
					popupRateOfExchange(currCd, "");
                    break; 
                    
               	case "pop_lmt_ins_xch_rt":
					//환율 팝업 클릭시 금액, 통화 등 연관 필드도 모두 입력되었는지 체크
					if (!chkFieldAmount(eval("form."+srcName.substring(4,12)+"locl_amt"), eval("form."+srcName.substring(4,12)+"curr_cd"), "Limit")) return;

               		popupType = srcName;
               		var currCd = eval("form."+srcName.substring(4,12)+"curr_cd").value;
					popupRateOfExchange(currCd, "");
                    break; 
                    
               	case "pop_ttl_xch_rt":
                    
               	case "pop_adj_xch_rt":
                    
               	case "pop_rfnd_xch_rt":
                    
               	case "pop_ots_xch_rt":
               		popupType = srcName;
					//환율 팝업 클릭시 금액, 통화 등 연관 필드도 모두 입력되었는지 체크
					if (!chkFieldAmount(eval("form."+ComReplaceStr(ComReplaceStr(srcName, "pop_"), "xch_rt")+"locl_amt"), eval("form.ttl_curr_cd"))) return;

               		var currCd = eval("form.ttl_curr_cd").value;
					popupRateOfExchange(currCd, "");
                    break; 
                    
               	case "pop_inst_xch_rt_1":
                    
               	case "pop_inst_xch_rt_2":
                    
               	case "pop_inst_xch_rt_3":
                    
               	case "pop_inst_xch_rt_4":
                    
               	case "pop_inst_xch_rt_5":
                    
               	case "pop_inst_xch_rt_6":
                    
               	case "pop_inst_xch_rt_7":
                    
               	case "pop_inst_xch_rt_8":
                    
               	case "pop_inst_xch_rt_9":
                    
               	case "pop_inst_xch_rt_10":
               		popupType = srcName;
					//환율 팝업 클릭시 금액, 통화 등 연관 필드도 모두 입력되었는지 체크
					if (!chkFieldAmount(eval("form.inst_locl_amt"+ComReplaceStr(srcName, "pop_inst_xch_rt")), eval("form.ttl_curr_cd"))) return;

               		var currCd = eval("form.ttl_curr_cd").value;
					popupRateOfExchange(currCd, "");
                    break; 

                case "btn1_Retrieve":
                	if (beforetab == 0) {//Insurance
		             	if(!CoCniInitConfirm(sheetObjects[0])) return;
		             	if(!CoCniInitConfirm(sheetObjects[1])) return;
		             	if(!CoCniInitConfirm(sheetObjects[2])) return;
		             	if(!CoCniInitConfirm(sheetObjects[3])) return;
		             	if(!CoCniInitConfirm(sheetObjects[4])) return;
		             	if(!CoCniInitConfirm(sheetObjects[5])) return;
		             	if(!CoCniInitConfirm(sheetObjects[6])) return;
		             	if(!CoCniInitConfirm(sheetObjects[7])) return;
                	} else {//Premium
		             	if(!CoCniInitConfirm(sheetObjects[10])) return;
		             	if(!CoCniInitConfirm(sheetObjects[8])) return;
		             	if(!CoCniInitConfirm(sheetObjects[9])) return;
                	}

	             	doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;

                case "btn1_New":
                	if (beforetab == 0) {//Insurance
		             	if(!CoCniInitConfirm(sheetObjects[0])) return;
		             	if(!CoCniInitConfirm(sheetObjects[1])) return;
		             	if(!CoCniInitConfirm(sheetObjects[2])) return;
		             	if(!CoCniInitConfirm(sheetObjects[3])) return;
		             	if(!CoCniInitConfirm(sheetObjects[4])) return;
		             	if(!CoCniInitConfirm(sheetObjects[5])) return;
		             	if(!CoCniInitConfirm(sheetObjects[6])) return;
		             	if(!CoCniInitConfirm(sheetObjects[7])) return;

						ComResetAll();
                	} else {//Premium
		             	if(!CoCniInitConfirm(sheetObjects[10])) return;
		             	if(!CoCniInitConfirm(sheetObjects[8])) return;
		             	if(!CoCniInitConfirm(sheetObjects[9])) return;
					
			            //Premium Tab만 초기화
			            clearPremium();
                	}

	   				//검색 조건 필드 제어
	   				inputReadOnly("New");
                    break; 

                case "btn1_Save":
					doActionIBSheet(sheetObject1,formObject,IBSAVE, "Save");
                    break;

                case "btn1_Delete":
                	var vMsg = "";
                	if (beforetab == 0) {//Insurance
                		vMsg = "Insurance Main";
                	} else {//Premium
                		vMsg = "Premium";
                	}
                	if (confirm(ComGetMsg("COM12165", vMsg))) {
						doActionIBSheet(sheetObject1,formObject,IBSAVE, "Delete");
                	}
                    break;
                    
                case "btn2_Row_Add":
                	var tabIndex = 1;
                	if (beforetab == 0) {//Insurance
	                	sheetObject1 = sheetObjects[beforetab1-1]
	                	tabIndex = beforetab1;
                	} else {//Premium
	                	sheetObject1 = sheetObjects[8+beforetab2-1]
	                	tabIndex = 8+beforetab2;
                	}
                	
	          		if(!validateForm(sheetObject1,formObject,IBSAVE)) return;
					var row = sheetObject1.DataInsert(-1);
					var prefix = "file_";
					sheetObject1.CellValue(row, prefix+"clm_file_tp_cd") = "0401"+ComLpad(tabIndex,2,"0");
					sheetObject1.CellValue(row, prefix+"clm_bztp_cd") = "I";
                	if (beforetab == 0) {//Insurance 
						sheetObject1.CellValue(row, prefix+"insur_tp_cd") = formObject.insur_tp_cd.value;
						sheetObject1.CellValue(row, prefix+"insur_plcy_yr") = formObject.insur_plcy_yr.value;
                	} else {
						sheetObject1.CellValue(row, prefix+"inst_insur_tp_cd") = formObject.insur_tp_cd.value;
						sheetObject1.CellValue(row, prefix+"inst_insur_plcy_yr") = formObject.insur_plcy_yr.value;
						sheetObject1.CellValue(row, prefix+"inst_prm_insur_tp_cd") = formObject.insur_prm_tp_cd.value;
                	}
					sheetObject1.CellValue(row, prefix+"insur_clm_pty_no") = formObject.insur_clm_pty_no.value;
					break;

                case "btn2_Row_Insert":
                	var tabIndex = 1;
                	if (beforetab == 0) {
	                	sheetObject1 = sheetObjects[beforetab1-1]
	                	tabIndex = beforetab1;
                	} else {//Premium
	                	sheetObject1 = sheetObjects[8+beforetab2-1]
	                	tabIndex = 8+beforetab2;
                	}
                	
	          		if(!validateForm(sheetObject1,formObject,IBSAVE)) return;
					var row = sheetObject1.DataInsert();
					var prefix = "file_";
					sheetObject1.CellValue(row, prefix+"clm_file_tp_cd") = "0401"+ComLpad(tabIndex,2,"0");
					sheetObject1.CellValue(row, prefix+"clm_bztp_cd") = "I";
                	if (beforetab == 0) {//Insurance
						sheetObject1.CellValue(row, prefix+"insur_tp_cd") = formObject.insur_tp_cd.value;
						sheetObject1.CellValue(row, prefix+"insur_plcy_yr") = formObject.insur_plcy_yr.value;
                	} else {//Premium
						sheetObject1.CellValue(row, prefix+"inst_insur_tp_cd") = formObject.insur_tp_cd.value;
						sheetObject1.CellValue(row, prefix+"inst_insur_plcy_yr") = formObject.insur_plcy_yr.value;
						sheetObject1.CellValue(row, prefix+"inst_prm_insur_tp_cd") = formObject.insur_prm_tp_cd.value;
                	}
					sheetObject1.CellValue(row, prefix+"insur_clm_pty_no") = formObject.insur_clm_pty_no.value;
                    break; 
                    
                case "btn2_Row_Delete":
                	if (beforetab == 0) {
	                	sheetObject1 = sheetObjects[beforetab1-1]
                	} else {
	                	sheetObject1 = sheetObjects[8+beforetab2-1]
                	}
					if(ComCniCheckBoxCheckYn(sheetObject1, "file_DelChk")) { 
						ComRowHideDelete(sheetObject1, "file_DelChk"); 
					}
                    break;

                case "btn2_Save":
                	if (beforetab == 0) {
	                	sheetObject1 = sheetObjects[beforetab1-1]
                	} else {
	                	sheetObject1 = sheetObjects[8+beforetab2-1]
                	}

					doActionIBSheet(sheetObject1,formObject,IBSAVE,'FILE');
                    break; 

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			alert("An unknown error occurred(in JavaScript source). Please verify your entry and try again. If the problem persists, please contact your system administrator.");
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
	* IBTab Object를 배열로 등록
 	* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 	* 배열은 소스 상단에 정의
	*/
	function setTabObject(tab_obj){
		tabObjects[tabCnt++] = tab_obj;
	}
    
    /**
     * 페이지에 생성된 IBUpload Object를 uploadObjects 배열에 등록한다. <br>
     * @param {ibupload} uploadObj    IBUpload Object
     **/
	function setUploadObject(uploadObj) {
		uploadObjects[uploadCnt++] = uploadObj;
	}

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1);
		}

        for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        //UPLOAD 환경 설정
        for(var i=0;i<uploadObjects.length;i++){
		    //1. 기본 환경 설정
		    ComConfigUpload(uploadObjects[i], "/hanjin/CNI_FILE_0000GS.do");
		
		}

        //html컨트롤 이벤트초기화
        initControl();
        
        //권한
		setRollBtnCtlIns("btn1_Save,btn1_Delete,btn2_Row_Add,btn2_Row_Insert,btn2_Row_Delete,btn2_Save");
        
        //Miscellaneous code
		doActionIBSheet(sheetObjects[0],document.form,IBROWSEARCH, "ComCd");
		
		//Delete 버튼 비활성화
		ComBtnDisable("btn1_Delete");
				
    }

	
	/**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl() {
        //Axon 이벤트 처리1. 이벤트catch
    	axon_event.addListenerForm  ('blur'	, 'obj_deactivate', form); 							//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
        axon_event.addListenerFormat('keypress'        	, 'obj_keypress'  , form); 				//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    	axon_event.addListenerFormat('beforeactivate'	, 'obj_activate'  , form);
        
        axon_event.addListener  ('keypress', 'obj_keypress' , form);							//- form 전체 컨트롤 중 keypress 이벤트 발생시
        axon_event.addListener  ('keyup'  , 'obj_keyup', 'insur_plcy_yr');				//- Policy Year 입력시 데이터 존재 여부 체크
//        axon_event.addListener  ('keydown', 'ComKeyEnter', 'form');

        axon_event.addListener  ('change'  , 'premium_change', 'insur_prm_tp_cd');				//- Premium 변경후 자동 조회하기

        axon_event.addListener  ('change'  , 'currency_change', 'ins_curr_cd');					//- Currency 입력 후 입력된 정보 체크하기
        axon_event.addListener  ('change'  , 'currency_change', 'lmt_ins_curr_cd');				//- Currency 입력 후 입력된 정보 체크하기
        axon_event.addListener  ('change'  , 'amount_change', 'ins_locl_amt');					//- 금액 입력 후 USD 금액 세팅하기
        axon_event.addListener  ('change'  , 'amount_change', 'lmt_ins_locl_amt');				//- 금액 입력 후 USD 금액 세팅하기
        axon_event.addListener  ('change'  , 'amount_change', 'ins_xch_rt');					//- 환율 입력 후 USD 금액 세팅하기
        axon_event.addListener  ('change'  , 'amount_change', 'lmt_ins_xch_rt');				//- 환율 입력 후 USD 금액 세팅하기
        axon_event.addListener  ('change'  , 'party_change', 'insur_clm_pty_nm');				//- Party name 삭제시 party no 삭제
        axon_event.addListener  ('change'  , 'party_change', 'ins_clm_pty_nm');					//- Party name 삭제시 party no 삭제
        axon_event.addListener  ('change'  , 'party_change', 'rins_clm_pty_nm');				//- Party name 삭제시 party no 삭제
        axon_event.addListener  ('change'  , 'party_change', 'cins_clm_pty_nm');				//- Party name 삭제시 party no 삭제
        axon_event.addListener  ('change'  , 'party_change', 'bro_clm_pty_nm');					//- Party name 삭제시 party no 삭제

        axon_event.addListener  ('click'  , 'party_open', 'insur_clm_pty_nm');					//- Party name 클릭시 party no 팝업 오픈
        axon_event.addListener  ('click'  , 'party_open', 'ins_clm_pty_nm');					//- Party name 클릭시 party no 팝업 오픈
        axon_event.addListener  ('click'  , 'party_open', 'rins_clm_pty_nm');					//- Party name 클릭시 party no 팝업 오픈
        axon_event.addListener  ('click'  , 'party_open', 'cins_clm_pty_nm');					//- Party name 클릭시 party no 팝업 오픈
        axon_event.addListener  ('click'  , 'party_open', 'bro_clm_pty_nm');					//- Party name 클릭시 party no 팝업 오픈

        axon_event.addListener  ('change'  , 'currency_change', 'ttl_curr_cd');					//- Currency 입력 후 입력된 정보 체크하기
        axon_event.addListener  ('change'  , 'amount_change', 'ttl_locl_amt');					//- 금액 입력 후 USD 금액 세팅하기
        axon_event.addListener  ('change'  , 'amount_change', 'ttl_xch_rt');					//- 환율 입력 후 USD 금액 세팅하기
        axon_event.addListener  ('change'  , 'amount_change', 'adj_locl_amt');					//- 금액 입력 후 USD 금액 세팅하기
        axon_event.addListener  ('change'  , 'amount_change', 'adj_xch_rt');					//- 환율 입력 후 USD 금액 세팅하기
        axon_event.addListener  ('change'  , 'amount_change', 'rfnd_locl_amt');					//- 금액 입력 후 USD 금액 세팅하기
        axon_event.addListener  ('change'  , 'amount_change', 'rfnd_xch_rt');					//- 환율 입력 후 USD 금액 세팅하기
        axon_event.addListener  ('change'  , 'amount_change', 'ots_locl_amt');					//- 금액 입력 후 USD 금액 세팅하기
        axon_event.addListener  ('change'  , 'amount_change', 'ots_xch_rt');					//- 환율 입력 후 USD 금액 세팅하기
        axon_event.addListener  ('change'  , 'amount_change', 'inst_locl_amt_1');				//- 금액 입력 후 USD 금액 세팅하기
        axon_event.addListener  ('change'  , 'amount_change', 'inst_xch_rt_1');					//- 환율 입력 후 USD 금액 세팅하기
        axon_event.addListener  ('change'  , 'amount_change', 'inst_locl_amt_2');				//- 금액 입력 후 USD 금액 세팅하기
        axon_event.addListener  ('change'  , 'amount_change', 'inst_xch_rt_2');					//- 환율 입력 후 USD 금액 세팅하기
        axon_event.addListener  ('change'  , 'amount_change', 'inst_locl_amt_3');				//- 금액 입력 후 USD 금액 세팅하기
        axon_event.addListener  ('change'  , 'amount_change', 'inst_xch_rt_3');					//- 환율 입력 후 USD 금액 세팅하기
        axon_event.addListener  ('change'  , 'amount_change', 'inst_locl_amt_4');				//- 금액 입력 후 USD 금액 세팅하기
        axon_event.addListener  ('change'  , 'amount_change', 'inst_xch_rt_4');					//- 환율 입력 후 USD 금액 세팅하기
        axon_event.addListener  ('change'  , 'amount_change', 'inst_locl_amt_5');				//- 금액 입력 후 USD 금액 세팅하기
        axon_event.addListener  ('change'  , 'amount_change', 'inst_xch_rt_5');					//- 환율 입력 후 USD 금액 세팅하기
        axon_event.addListener  ('change'  , 'amount_change', 'inst_locl_amt_6');				//- 금액 입력 후 USD 금액 세팅하기
        axon_event.addListener  ('change'  , 'amount_change', 'inst_xch_rt_6');					//- 환율 입력 후 USD 금액 세팅하기
        axon_event.addListener  ('change'  , 'amount_change', 'inst_locl_amt_7');				//- 금액 입력 후 USD 금액 세팅하기
        axon_event.addListener  ('change'  , 'amount_change', 'inst_xch_rt_7');					//- 환율 입력 후 USD 금액 세팅하기
        axon_event.addListener  ('change'  , 'amount_change', 'inst_locl_amt_8');				//- 금액 입력 후 USD 금액 세팅하기
        axon_event.addListener  ('change'  , 'amount_change', 'inst_xch_rt_8');					//- 환율 입력 후 USD 금액 세팅하기
        axon_event.addListener  ('change'  , 'amount_change', 'inst_locl_amt_9');				//- 금액 입력 후 USD 금액 세팅하기
        axon_event.addListener  ('change'  , 'amount_change', 'inst_xch_rt_9');					//- 환율 입력 후 USD 금액 세팅하기
        axon_event.addListener  ('change'  , 'amount_change', 'inst_locl_amt_10');				//- 금액 입력 후 USD 금액 세팅하기
        axon_event.addListener  ('change'  , 'amount_change', 'inst_xch_rt_10');				//- 환율 입력 후 USD 금액 세팅하기
    }

 	//focus in
 	function obj_activate(){
 		obj = event.srcElement;
 		//readonly 일때 데이터 포맷 변경되는 것  방지
 		if (obj.getAttribute("readOnly")) return;
 		ComClearSeparator(obj);
 	} 

    /**
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_deactivate(){

        //입력Validation 확인하기
    	switch(event.srcElement.name){
    			
			case "insur_plcy_yr":
				//숫자이면서 천단위 구분을 하지 않는다.
				ComChkObjValid(event.srcElement, true, false, false);
				break;
			
			default:
				ComChkObjValid(event.srcElement);
    	}
    	
    }
    
    /**
     * HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
     **/
    function obj_keypress(){

    	switch(event.srcElement.dataformat){
	        case "engup":
	            ComKeyOnlyAlphabet('uppernum');
	            break;
			case "float":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
			case "ymd":
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
				break;
	        case "eng":
	        	if (event.keyCode > 0) event.returnValue = false;;
	            break;
			default:
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
    	}
    }
    
    /**
     * Party name 삭제시 party no 삭제. <br>
     **/
    function party_change() {
    	var obj = event.srcElement;
    	if (obj.value == "") {
			eval("form."+obj.name.substring(0,obj.name.length-1)+"o").value = '';
    	}
    }
    
    /**
     * Party name 클릭시 party no 팝업 오픈. <br>
     **/
    function party_open() {
    	var obj = event.srcElement;
    	if (obj.value == "") {
       		popupType = "pop_"+obj.name.substring(0,obj.name.length-3);
			popupMainCodeInquiry();
    	}
    }
    
    /**
     * Policy Year 입력시 자동조회. <br>
     **/
    function obj_keyup() {
    	var keyValue = event.keyCode;
    	//대문자와 숫자인 경우만 실행
    	if ((keyValue >= 48 && keyValue <= 57) || (keyValue >= 96 && keyValue <= 105)) {
        	if (event.srcElement.value.trim().length == 4) {
            	eval("document.tab1").selectedIndex = 0;
            	//입력시 자동 조회
               	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        	} 
    	}
    }
    
    /**
     * Premium 변경후 자동 조회하기. <br>
     **/
    function premium_change() {
		var obj = document.getElementById("btn_Retrieve");
		if (obj) obj.fireEvent("onclick");
    }
    
    /**
     * Currency 입력시 입력된 정보 체크한다. <br>
     **/
    function currency_change() {
    	var obj = event.srcElement;
    	if (obj.value != "" && obj.value.trim().length == 3) {
    		
    		if (obj.value == "USD") {//USD인 경우 환율에 1로 세팅하고 금액은 local amt랑 똑같게 세팅
    			var objname = ComReplaceStr(obj.name, "curr_cd", "");
    			eval("document.form."+objname+"xch_rt").value = "1.00000";
    			
    			//Premium tab의 Total currency인 경우
    			if (obj.name == "ttl_curr_cd") {
    				if (form.adj_locl_amt.value.trim() != "" && parseFloat(form.adj_locl_amt.value.trim()) != 0) {
    					form.adj_xch_rt.value = "1.00000";
		    			amount_change(form.adj_locl_amt);
    				}
    				if (form.rfnd_locl_amt.value.trim() != "" && parseFloat(form.rfnd_locl_amt.value.trim()) != 0) {
    					form.rfnd_xch_rt.value = "1.00000";
		    			amount_change(form.rfnd_locl_amt);
    				}
    				if (form.ots_locl_amt.value.trim() != "" && parseFloat(form.ots_locl_amt.value.trim()) != 0) {
    					form.ots_xch_rt.value = "1.00000";
		    			amount_change(form.ots_locl_amt);
    				}
    				
    				for (var ii=1; ii<11; ii++) {
    					var objInst = eval("form.inst_locl_amt_"+ii);
	    				if (objInst.value.trim() != "" && parseFloat(objInst.value.trim()) != 0) {
	    					eval("form.inst_xch_rt_"+ii).value = "1.00000";
			    			amount_change(objInst);
	    				}
    				}
    			} 
    			amount_change(obj);
    		} else {
				doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, obj.name);
			}	
    	} else if (obj.value.trim() == "") {
    		//환율, USD Amount를 초기화함
    		changeCurrency(obj);
    	}	
    }
    
    /**
     * 통화, 환율, 금액 입력 후 USD 금액 세팅하기. <br>
     **/
    function changeCurrency(obj) {
		var objname = ComReplaceStr(obj.name, "curr_cd", "");
		eval("document.form."+objname+"xch_rt").value = "";
		eval("document.form."+objname+"usd_amt").value = "";

		//Premium tab의 Total currency인 경우
		if (obj.name == "ttl_curr_cd") {
			form.adj_xch_rt.value = "";
			form.adj_usd_amt.value = "";
			form.rfnd_xch_rt.value = "";
			form.rfnd_usd_amt.value = "";
			form.ots_xch_rt.value = "";
			form.ots_usd_amt.value = "";
			
			for (var ii=1; ii<11; ii++) {
				eval("form.inst_xch_rt_"+ii).value = "";
				eval("form.inst_usd_amt_"+ii).value = "";
			}
		} 

   	}
    
    /**
     * 통화, 환율, 금액 입력 후 USD 금액 세팅하기. <br>
     **/
    function amount_change(obj) {
    	if (obj.name == undefined || obj == null) {
    		obj = event.srcElement;
    	}
    	
    	var objloclamt = eval("form."+replaceStrWith(replaceStrWith(replaceStrWith(obj.name, "xch_rt", "locl_amt"), "curr_cd", "locl_amt"), "usd_amt", "locl_amt"));
    	var objrt = eval("form."+replaceStrWith(replaceStrWith(replaceStrWith(obj.name, "locl_amt", "xch_rt"), "curr_cd", "xch_rt"), "usd_amt", "xch_rt"));
    	var objusdamt = eval("form."+replaceStrWith(replaceStrWith(replaceStrWith(obj.name, "xch_rt", "usd_amt"), "curr_cd", "usd_amt"), "locl_amt", "usd_amt"));

    	//local 금액에 대해 USD 금액 계산하기
		var valLoclAmt = objloclamt.value.trim();
		var valXchRt = objrt.value.trim();
		
		if (valLoclAmt != "" && valXchRt != "") {
			objloclamt.value = ComAddComma2(ComReplaceStr(valLoclAmt,",",""),"#,###.00");
			var usdAmt = parseFloat(ComReplaceStr(objloclamt.value,",",""))/parseFloat(ComReplaceStr(objrt.value,",",""));
			usdAmt = usdAmt.toFixed(2) + "";
			objusdamt.value = ComAddComma2(usdAmt,"#,###.00");
			
		} else if (valLoclAmt != "" && valXchRt == "") {
            //Premium에서 total amount필드가 아닌 경우 금액 입력시 Currency가 USD인 경우 환율을 1로 자동입력한다.
			if (beforetab == 1 && obj.name != "ttl_locl_amt") {
				var currCd = form.ttl_curr_cd.value;
				if (currCd == 'USD') {
					objloclamt.value = ComAddComma2(ComReplaceStr(valLoclAmt,",",""),"#,###.00");
					objrt.value = "1.00000";
					objusdamt.value = ComAddComma2(ComReplaceStr(valLoclAmt,",",""),"#,###.00");
				}
				
			}
		} else {
			objusdamt.value = "";
		}
		
		//Total Amount 필드의 경우 해당 Premium Type으로 데이터가 있는지 체크
		//Premium Type 선택시 자동 조회되므로 이 기능은 필요 없음
		if (obj.name == 'ttl_locl_amt') {
			//doActionIBSheet(sheetObjects[10],document.form,IBROWSEARCH, "Premium");
		}    	

    }

    /**
     * 문자열(sVal)에 포함된 특정문자열(sFind)을 다른문자열(sReplace)로 변경하여 문자열로 리턴한다. <br>
     * @param {string,object} obj       필수,문자열 또는 HTML태그(Object)
     * @param {string}        sFind     필수,찾을 기준 문자열
     * @param {string}        sReplace  선택,변경할 문자열, default=""
     * @return String, 특정문자열(sFind)을 다른문자열(sReplace)로 변경한 결과 문자열
     */
    function replaceStrWith(sVal, sFind, sReplace)
    {
        try {

            var varLen = sVal.length;
            var sFindLen = sFind.length;
            var sReturn = sVal;

            for (var ii=0; ii<varLen; ii++) {
            
            	if (sVal.substring(ii, ii+sFindLen) == sFind) {
					sReturn = sVal.substring(0, ii)+sReplace+sVal.substring(ii+sFindLen);            		
            	}
            
            }
            
            return sReturn;
        } catch(err) { ComFuncErrMsg(err.message); }
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
			    InsertTab( cnt++ , "Main Terms" , -1 );
			    InsertTab( cnt++ , "Premium" , -1 );
			}
			break;
			
			case 2:
			with (tabObj) {
			    var cnt  = 0 ;
			    InsertTab( cnt++ , "Main Terms Remark" , -1 );
			    InsertTab( cnt++ , "Terms’ Detail" , -1 );
			    InsertTab( cnt++ , "Loss Record" , -1 );
			    InsertTab( cnt++ , "Renewal Strategy" , -1 );
			    InsertTab( cnt++ , "Renewal Target" , -1 );
			    InsertTab( cnt++ , "Initial Offer" , -1 );
			    InsertTab( cnt++ , "Renewal Negotiation" , -1 );
			    InsertTab( cnt++ , "Policy" , -1 );
			    InsertTab( cnt++ , "Renewal Approval" , -1 );
			    BaseColor = "243,242,248";
			    //tabObj.Visible = true;
			}
			break;
			
			case 3:
			with (tabObj) {
			    var cnt  = 0 ;
			    InsertTab( cnt++ , "Premium Remark", -1 );
			    InsertTab( cnt++ , "Premium Detail" , -1 );
			    InsertTab( cnt++ , "Debit Note" , -1 );
			    BaseColor = "243,242,248";
			    //tabObj.Visible = true;
			}
			break;
		}
	}

	/**
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	*/
	function tab1_OnChange(tabObj , nItem){
		
		var objs = document.all.item("tabLayer");
        objs[nItem].style.display = "Inline";
        objs[beforetab].style.display = "none";
				
        //--------------- 요기가 중요 --------------------------//
        objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
        //------------------------------------------------------//
        beforetab= nItem;
        if(nItem == 1 && initload){
    		tabObjects[2].Visible= true;
    		tabObjects[2].SelectedIndex = 1;
    		tabObjects[2].SelectedIndex = 2;
    		tabObjects[2].SelectedIndex = 0;
    		
    		initload = false;
        }
        
		//Tab Click시 Insurer 정보가 없는 경우 다른 Tab에 있는 Insurer 정보를 넣어줌
        var formObj = document.form;
        if (beforetab == 0) {//Main Terms
			if (formObj.insur_clm_pty_no.value == "") {
				formObj.insur_clm_pty_no.value = formObj.insur_clm_pty_prm_no.value;
				formObj.insur_clm_pty_nm.value = formObj.insur_clm_pty_prm_nm.value;
			}
		} else {//Premium
			if (formObj.insur_clm_pty_prm_no.value == "") {
				formObj.insur_clm_pty_prm_no.value = formObj.insur_clm_pty_no.value;
				formObj.insur_clm_pty_prm_nm.value = formObj.insur_clm_pty_nm.value;
			}
		}
        
	}
	
	/**
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	*/
	function tab2_OnChange(tabObj , nItem){

		var objs = document.all.item("tabLayer1");
	
        objs[nItem].style.display = "Inline";
        objs[beforetab1].style.display = "none";

        //--------------- 요기가 중요 --------------------------//
        objs[beforetab1].style.zIndex = objs[nItem].style.zIndex -1 ;
        //------------------------------------------------------//
        beforetab1= nItem;
	        
	}


	/**
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	*/
	function tab3_OnChange(tabObj , nItem){
		var objs = document.all.item("tabLayer3");
	
        objs[nItem].style.display = "Inline";
        objs[beforetab2].style.display = "none";

        //--------------- 요기가 중요 --------------------------//
        objs[beforetab2].style.zIndex = objs[nItem].style.zIndex -1 ;
        //------------------------------------------------------//
        beforetab2= nItem;
		
	}
		
		

  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
        switch(sheetObj.id) {
	
            case "sheet1":      //sheet1 init
                with (sheetObj) {

		           	// 높이 설정
					style.height = 200;
										
                	var prefix = "file_";

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

					var HeadTitle1 = "|Sel.|Seq.|File Name|Contents|ID|Date|File Download|||||||||";
					var headCount = ComCountHeadTitle(HeadTitle1);
										
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(20, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
                   
                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  	true,   prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,  	40,    	daCenter,  	false,  prefix + "DelChk");
					InitDataProperty(0, cnt++ , dtSeq,        	40,    	daCenter,  	false,  prefix + "Seq");
					InitDataProperty(0, cnt++ , dtPopup,     	300,	daLeft,		false,	prefix + "file_nm",			true,	"",	dfNone,				0,	false,	true,	200);
					InitDataProperty(0, cnt++ , dtData,     	340,	daLeft,		false,	prefix + "file_desc",		false,	"",	dfNone,				0,	true,	true,	500);
					InitDataProperty(0, cnt++ , dtData,     	80,		daCenter,	false,	prefix + "upd_usr_id",		false,	"",	dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,     	80,		daCenter,	false,	prefix + "upd_dt",			false,	"",	dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtImage,     	100,	daCenter,	false,	prefix + "file_download",	false,	"",	dfNone,				0,	false,	true);
					InitDataProperty(0, cnt++ , dtHidden,		0,    	daCenter,  	false,  prefix + "clm_file_seq");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "clm_file_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "clm_bztp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "dw_clm_no");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "insur_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "insur_plcy_yr");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "insur_clm_pty_no");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "inst_insur_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "inst_insur_plcy_yr");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "inst_prm_insur_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "file_path");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "file_sav_id");
                    
                    ImageList(0)= "/hanjin/img/ico_attach.gif";
                    
                    DataLinkMouse(prefix + "file_download") = true;
                    
					ShowButtonImage = 1;
				}
				break;
	
            case "sheet2":      //sheet1 init
                with (sheetObj) {

		           	// 높이 설정
					style.height = 200;
										
                	var prefix = "file_";

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

					var HeadTitle1 = "|Sel.|Seq.|File Name|Contents|ID|Date|File Download|||||||||";
					var headCount = ComCountHeadTitle(HeadTitle1);
										
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(20, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
                   
                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  	true,   prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,  	40,    	daCenter,  	false,  prefix + "DelChk");
					InitDataProperty(0, cnt++ , dtSeq,        	40,    	daCenter,  	false,  prefix + "Seq");
					InitDataProperty(0, cnt++ , dtPopup,     	300,	daLeft,		false,	prefix + "file_nm",			true,	"",	dfNone,				0,	false,	true,	200);
					InitDataProperty(0, cnt++ , dtData,     	340,	daLeft,		false,	prefix + "file_desc",		false,	"",	dfNone,				0,	true,	true,	500);
					InitDataProperty(0, cnt++ , dtData,     	80,		daCenter,	false,	prefix + "upd_usr_id",		false,	"",	dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,     	80,		daCenter,	false,	prefix + "upd_dt",			false,	"",	dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtImage,     	100,	daCenter,	false,	prefix + "file_download",	false,	"",	dfNone,				0,	false,	true);
					InitDataProperty(0, cnt++ , dtHidden,		0,    	daCenter,  	false,  prefix + "clm_file_seq");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "clm_file_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "clm_bztp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "dw_clm_no");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "insur_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "insur_plcy_yr");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "insur_clm_pty_no");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "inst_insur_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "inst_insur_plcy_yr");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "inst_prm_insur_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "file_path");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "file_sav_id");
                    
                    ImageList(0)= "/hanjin/img/ico_attach.gif";
                    
                    DataLinkMouse(prefix + "file_download") = true;
                    
					ShowButtonImage = 1;
				}
				break;
						
	
            case "sheet3":      //sheet1 init
                with (sheetObj) {

		           	// 높이 설정
					style.height = 200;
										
                	var prefix = "file_";

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

					var HeadTitle1 = "|Sel.|Seq.|File Name|Contents|ID|Date|File Download|||||||||";
					var headCount = ComCountHeadTitle(HeadTitle1);
										
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(20, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
                   
                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  	true,   prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,  	40,    	daCenter,  	false,  prefix + "DelChk");
					InitDataProperty(0, cnt++ , dtSeq,        	40,    	daCenter,  	false,  prefix + "Seq");
					InitDataProperty(0, cnt++ , dtPopup,     	300,	daLeft,		false,	prefix + "file_nm",			true,	"",	dfNone,				0,	false,	true,	200);
					InitDataProperty(0, cnt++ , dtData,     	340,	daLeft,		false,	prefix + "file_desc",		false,	"",	dfNone,				0,	true,	true,	500);
					InitDataProperty(0, cnt++ , dtData,     	80,		daCenter,	false,	prefix + "upd_usr_id",		false,	"",	dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,     	80,		daCenter,	false,	prefix + "upd_dt",			false,	"",	dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtImage,     	100,	daCenter,	false,	prefix + "file_download",	false,	"",	dfNone,				0,	false,	true);
					InitDataProperty(0, cnt++ , dtHidden,		0,    	daCenter,  	false,  prefix + "clm_file_seq");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "clm_file_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "clm_bztp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "dw_clm_no");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "insur_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "insur_plcy_yr");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "insur_clm_pty_no");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "inst_insur_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "inst_insur_plcy_yr");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "inst_prm_insur_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "file_path");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "file_sav_id");
                    
                    ImageList(0)= "/hanjin/img/ico_attach.gif";
                    
                    DataLinkMouse(prefix + "file_download") = true;
                    
					ShowButtonImage = 1;
				}
		        break;
						
	
            case "sheet4":      //sheet1 init
                with (sheetObj) {

		           	// 높이 설정
					style.height = 200;
										
                	var prefix = "file_";

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

					var HeadTitle1 = "|Sel.|Seq.|File Name|Contents|ID|Date|File Download|||||||||";
					var headCount = ComCountHeadTitle(HeadTitle1);
										
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(20, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
                   
                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  	true,   prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,  	40,    	daCenter,  	false,  prefix + "DelChk");
					InitDataProperty(0, cnt++ , dtSeq,        	40,    	daCenter,  	false,  prefix + "Seq");
					InitDataProperty(0, cnt++ , dtPopup,     	300,	daLeft,		false,	prefix + "file_nm",			true,	"",	dfNone,				0,	false,	true,	200);
					InitDataProperty(0, cnt++ , dtData,     	340,	daLeft,		false,	prefix + "file_desc",		false,	"",	dfNone,				0,	true,	true,	500);
					InitDataProperty(0, cnt++ , dtData,     	80,		daCenter,	false,	prefix + "upd_usr_id",		false,	"",	dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,     	80,		daCenter,	false,	prefix + "upd_dt",			false,	"",	dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtImage,     	100,	daCenter,	false,	prefix + "file_download",	false,	"",	dfNone,				0,	false,	true);
					InitDataProperty(0, cnt++ , dtHidden,		0,    	daCenter,  	false,  prefix + "clm_file_seq");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "clm_file_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "clm_bztp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "dw_clm_no");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "insur_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "insur_plcy_yr");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "insur_clm_pty_no");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "inst_insur_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "inst_insur_plcy_yr");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "inst_prm_insur_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "file_path");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "file_sav_id");
                    
                    ImageList(0)= "/hanjin/img/ico_attach.gif";
                    
                    DataLinkMouse(prefix + "file_download") = true;
                    
					ShowButtonImage = 1;
		          }
		          break;
						
	
            case "sheet5":      //sheet1 init
                with (sheetObj) {

		           	// 높이 설정
					style.height = 200;
										
                	var prefix = "file_";

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

					var HeadTitle1 = "|Sel.|Seq.|File Name|Contents|ID|Date|File Download|||||||||";
					var headCount = ComCountHeadTitle(HeadTitle1);
										
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(20, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
                   
                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  	true,   prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,  	40,    	daCenter,  	false,  prefix + "DelChk");
					InitDataProperty(0, cnt++ , dtSeq,        	40,    	daCenter,  	false,  prefix + "Seq");
					InitDataProperty(0, cnt++ , dtPopup,     	300,	daLeft,		false,	prefix + "file_nm",			true,	"",	dfNone,				0,	false,	true,	200);
					InitDataProperty(0, cnt++ , dtData,     	340,	daLeft,		false,	prefix + "file_desc",		false,	"",	dfNone,				0,	true,	true,	500);
					InitDataProperty(0, cnt++ , dtData,     	80,		daCenter,	false,	prefix + "upd_usr_id",		false,	"",	dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,     	80,		daCenter,	false,	prefix + "upd_dt",			false,	"",	dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtImage,     	100,	daCenter,	false,	prefix + "file_download",	false,	"",	dfNone,				0,	false,	true);
					InitDataProperty(0, cnt++ , dtHidden,		0,    	daCenter,  	false,  prefix + "clm_file_seq");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "clm_file_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "clm_bztp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "dw_clm_no");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "insur_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "insur_plcy_yr");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "insur_clm_pty_no");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "inst_insur_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "inst_insur_plcy_yr");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "inst_prm_insur_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "file_path");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "file_sav_id");
                    
                    ImageList(0)= "/hanjin/img/ico_attach.gif";
                    
                    DataLinkMouse(prefix + "file_download") = true;
                    
					ShowButtonImage = 1;
		          }
		          break;
						
	
            case "sheet6":      //sheet1 init
                with (sheetObj) {

		           	// 높이 설정
					style.height = 200;
										
                	var prefix = "file_";

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

					var HeadTitle1 = "|Sel.|Seq.|File Name|Contents|ID|Date|File Download||||||||";
					var headCount = ComCountHeadTitle(HeadTitle1);
										
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(20, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
                   
                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  	true,   prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,  	40,    	daCenter,  	false,  prefix + "DelChk");
					InitDataProperty(0, cnt++ , dtSeq,        	40,    	daCenter,  	false,  prefix + "Seq");
					InitDataProperty(0, cnt++ , dtPopup,     	300,	daLeft,		false,	prefix + "file_nm",			true,	"",	dfNone,				0,	false,	true,	200);
					InitDataProperty(0, cnt++ , dtData,     	340,	daLeft,		false,	prefix + "file_desc",		false,	"",	dfNone,				0,	true,	true,	500);
					InitDataProperty(0, cnt++ , dtData,     	80,		daCenter,	false,	prefix + "upd_usr_id",		false,	"",	dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,     	80,		daCenter,	false,	prefix + "upd_dt",			false,	"",	dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtImage,     	100,	daCenter,	false,	prefix + "file_download",	false,	"",	dfNone,				0,	false,	true);
					InitDataProperty(0, cnt++ , dtHidden,		0,    	daCenter,  	false,  prefix + "clm_file_seq");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "clm_file_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "clm_bztp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "dw_clm_no");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "insur_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "insur_plcy_yr");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "insur_clm_pty_no");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "inst_insur_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "inst_insur_plcy_yr");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "inst_prm_insur_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "file_path");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "file_sav_id");
                    
                    ImageList(0)= "/hanjin/img/ico_attach.gif";
                    
                    DataLinkMouse(prefix + "file_download") = true;
                    
					ShowButtonImage = 1;
		          }
		          break;
						
	
            case "sheet7":      //sheet1 init
                with (sheetObj) {

		           	// 높이 설정
					style.height = 200;
										
                	var prefix = "file_";

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

					var HeadTitle1 = "|Sel.|Seq.|File Name|Contents|ID|Date|File Download||||||||";
					var headCount = ComCountHeadTitle(HeadTitle1);
										
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(20, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
                   
                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  	true,   prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,  	40,    	daCenter,  	false,  prefix + "DelChk");
					InitDataProperty(0, cnt++ , dtSeq,        	40,    	daCenter,  	false,  prefix + "Seq");
					InitDataProperty(0, cnt++ , dtPopup,     	300,	daLeft,		false,	prefix + "file_nm",			true,	"",	dfNone,				0,	false,	true,	200);
					InitDataProperty(0, cnt++ , dtData,     	340,	daLeft,		false,	prefix + "file_desc",		false,	"",	dfNone,				0,	true,	true,	500);
					InitDataProperty(0, cnt++ , dtData,     	80,		daCenter,	false,	prefix + "upd_usr_id",		false,	"",	dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,     	80,		daCenter,	false,	prefix + "upd_dt",			false,	"",	dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtImage,     	100,	daCenter,	false,	prefix + "file_download",	false,	"",	dfNone,				0,	false,	true);
					InitDataProperty(0, cnt++ , dtHidden,		0,    	daCenter,  	false,  prefix + "clm_file_seq");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "clm_file_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "clm_bztp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "dw_clm_no");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "insur_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "insur_plcy_yr");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "insur_clm_pty_no");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "inst_insur_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "inst_insur_plcy_yr");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "inst_prm_insur_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "file_path");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "file_sav_id");
                    
                    ImageList(0)= "/hanjin/img/ico_attach.gif";
                    
                    DataLinkMouse(prefix + "file_download") = true;
                    
					ShowButtonImage = 1;
		          }
		          break;
						
	
            case "sheet8":      //sheet1 init
                with (sheetObj) {

		           	// 높이 설정
					style.height = 200;
										
                	var prefix = "file_";

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

					var HeadTitle1 = "|Sel.|Seq.|File Name|Contents|ID|Date|File Download||||||||";
					var headCount = ComCountHeadTitle(HeadTitle1);
										
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(20, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
                   
                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  	true,   prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,  	40,    	daCenter,  	false,  prefix + "DelChk");
					InitDataProperty(0, cnt++ , dtSeq,        	40,    	daCenter,  	false,  prefix + "Seq");
					InitDataProperty(0, cnt++ , dtPopup,     	300,	daLeft,		false,	prefix + "file_nm",			true,	"",	dfNone,				0,	false,	true,	200);
					InitDataProperty(0, cnt++ , dtData,     	340,	daLeft,		false,	prefix + "file_desc",		false,	"",	dfNone,				0,	true,	true,	500);
					InitDataProperty(0, cnt++ , dtData,     	80,		daCenter,	false,	prefix + "upd_usr_id",		false,	"",	dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,     	80,		daCenter,	false,	prefix + "upd_dt",			false,	"",	dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtImage,     	100,	daCenter,	false,	prefix + "file_download",	false,	"",	dfNone,				0,	false,	true);
					InitDataProperty(0, cnt++ , dtHidden,		0,    	daCenter,  	false,  prefix + "clm_file_seq");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "clm_file_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "clm_bztp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "dw_clm_no");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "insur_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "insur_plcy_yr");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "insur_clm_pty_no");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "inst_insur_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "inst_insur_plcy_yr");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "inst_prm_insur_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "file_path");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "file_sav_id");
                    
                    ImageList(0)= "/hanjin/img/ico_attach.gif";
                    
                    DataLinkMouse(prefix + "file_download") = true;
                    
					ShowButtonImage = 1;
		          }
		          break;
						
	
            case "sheet9":      //sheet1 init
                with (sheetObj) {

		           	// 높이 설정
					style.height = 160;
										
                	var prefix = "file_";

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

					var HeadTitle1 = "|Sel.|Seq.|File Name|Contents|ID|Date|File Download||||||||";
					var headCount = ComCountHeadTitle(HeadTitle1);
										
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(20, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
                   
                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  	true,   prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,  	40,    	daCenter,  	false,  prefix + "DelChk");
					InitDataProperty(0, cnt++ , dtSeq,        	40,    	daCenter,  	false,  prefix + "Seq");
					InitDataProperty(0, cnt++ , dtPopup,     	300,	daLeft,		false,	prefix + "file_nm",			true,	"",	dfNone,				0,	false,	true,	200);
					InitDataProperty(0, cnt++ , dtData,     	340,	daLeft,		false,	prefix + "file_desc",		false,	"",	dfNone,				0,	true,	true,	500);
					InitDataProperty(0, cnt++ , dtData,     	80,		daCenter,	false,	prefix + "upd_usr_id",		false,	"",	dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,     	80,		daCenter,	false,	prefix + "upd_dt",			false,	"",	dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtImage,     	100,	daCenter,	false,	prefix + "file_download",	false,	"",	dfNone,				0,	false,	true);
					InitDataProperty(0, cnt++ , dtHidden,		0,    	daCenter,  	false,  prefix + "clm_file_seq");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "clm_file_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "clm_bztp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "dw_clm_no");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "insur_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "insur_plcy_yr");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "insur_clm_pty_no");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "inst_insur_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "inst_insur_plcy_yr");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "inst_prm_insur_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "file_path");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "file_sav_id");
                    
                    ImageList(0)= "/hanjin/img/ico_attach.gif";
                    
                    DataLinkMouse(prefix + "file_download") = true;
                    
					ShowButtonImage = 1;
		          }
		          break;
						
	
            case "sheet10":      //sheet1 init
                with (sheetObj) {

		           	// 높이 설정
					style.height = 153;
										
                	var prefix = "file_";

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

					var HeadTitle1 = "|Sel.|Seq.|File Name|Contents|ID|Date|File Download||||||||";
					var headCount = ComCountHeadTitle(HeadTitle1);
										
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(20, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
                   
                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  	true,   prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,  	40,    	daCenter,  	false,  prefix + "DelChk");
					InitDataProperty(0, cnt++ , dtSeq,        	40,    	daCenter,  	false,  prefix + "Seq");
					InitDataProperty(0, cnt++ , dtPopup,     	300,	daLeft,		false,	prefix + "file_nm",			true,	"",	dfNone,				0,	false,	true,	200);
					InitDataProperty(0, cnt++ , dtData,     	340,	daLeft,		false,	prefix + "file_desc",		false,	"",	dfNone,				0,	true,	true,	500);
					InitDataProperty(0, cnt++ , dtData,     	80,		daCenter,	false,	prefix + "upd_usr_id",		false,	"",	dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,     	80,		daCenter,	false,	prefix + "upd_dt",			false,	"",	dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtImage,     	100,	daCenter,	false,	prefix + "file_download",	false,	"",	dfNone,				0,	false,	true);
					InitDataProperty(0, cnt++ , dtHidden,		0,    	daCenter,  	false,  prefix + "clm_file_seq");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "clm_file_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "clm_bztp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "dw_clm_no");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "insur_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "insur_plcy_yr");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "insur_clm_pty_no");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "inst_insur_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "inst_insur_plcy_yr");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "inst_prm_insur_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "file_path");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "file_sav_id");
                    
                    ImageList(0)= "/hanjin/img/ico_attach.gif";
                    
                    DataLinkMouse(prefix + "file_download") = true;
                    
					ShowButtonImage = 1;
		          }
		          break;

            case "sheet11":      //sheet1 init
                with (sheetObj) {

		           	// 높이 설정
					style.height = 181;
										
                	var prefix = "sheet_";

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

					var HeadTitle1 = "|Sel.|Seq.|File Name|Contents|ID|Date|File Download|";
					var headCount = ComCountHeadTitle(HeadTitle1);
										
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(14, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
                   
                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  	true,   prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,  	40,    	daCenter,  	false,  prefix + "DelChk");
					InitDataProperty(0, cnt++ , dtSeq,        	40,    	daCenter,  	false,  prefix + "Seq");
					InitDataProperty(0, cnt++ , dtHidden,		0,   	daCenter,  	false,  prefix + "inst_seq");
                    InitDataProperty(0, cnt++ , dtHidden,		0,    	daCenter,   false,  prefix + "inst_locl_amt");
                    InitDataProperty(0, cnt++ , dtHidden,		0,    	daCenter,   false,  prefix + "inst_curr_cd");
                    InitDataProperty(0, cnt++ , dtHidden,		0,    	daCenter,   false,  prefix + "inst_xch_rt");
                    InitDataProperty(0, cnt++ , dtHidden,		0,    	daCenter,   false,  prefix + "inst_usd_amt");
                    InitDataProperty(0, cnt++ , dtHidden,		0,    	daCenter,   false,  prefix + "inst_due_dt");
                    InitDataProperty(0, cnt++ , dtHidden,		0,    	daCenter,   false,  prefix + "inst_pay_dt");
                    InitDataProperty(0, cnt++ , dtHidden,		0,    	daCenter,   false,  prefix + "insur_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,		0,    	daCenter,   false,  prefix + "insur_plcy_yr");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "insur_clm_pty_no");
                    InitDataProperty(0, cnt++ , dtHidden,		0,    	daCenter,   false,  prefix + "insur_prm_tp_cd");
                    
		          }
		          break;
		  }        

    }

	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction,Col, msgYN) {

        switch(sAction) {
			case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) return;
				
				var insurClmPtyNo;
				var insurClmPtyNm;
				if (beforetab == 0) {//Main Terms
					formObj.f_cmd.value = SEARCH;
			
					//Insurer 정보 저장
					insurClmPtyNo = formObj.insur_clm_pty_no.value;
					insurClmPtyNm = formObj.insur_clm_pty_nm.value;

					var aryPrefix = new Array("file_", "file_", "file_", "file_", "file_", "file_", "file_", "file_", "sheet_", "file_", "file_");
		        	
		   			var sXml = sheetObj.GetSearchXml("CPS_CNI_0401GS.do" , FormQueryString(formObj) +"&" + ComGetPrefixParam(aryPrefix));
					var arrXml = sXml.split("|$$|");
					if (arrXml.length > 0) sheetObjects[0].LoadSearchXml(arrXml[0]);
					if (arrXml.length > 1) sheetObjects[1].LoadSearchXml(arrXml[1]);	
					if (arrXml.length > 2) sheetObjects[2].LoadSearchXml(arrXml[2]);	
					if (arrXml.length > 3) sheetObjects[3].LoadSearchXml(arrXml[3]);
					if (arrXml.length > 4) sheetObjects[4].LoadSearchXml(arrXml[4]);
					if (arrXml.length > 5) sheetObjects[5].LoadSearchXml(arrXml[5]);
					if (arrXml.length > 6) sheetObjects[6].LoadSearchXml(arrXml[6]);
					if (arrXml.length > 7) sheetObjects[7].LoadSearchXml(arrXml[7]);

		   			if (ComGetEtcData(arrXml[0], "RetrievePrm") == "Y") {//Data found
						//Premium
						if (arrXml.length > 8) sheetObjects[10].LoadSearchXml(arrXml[8]);
						if (arrXml.length > 9) sheetObjects[8].LoadSearchXml(arrXml[9]);	
						if (arrXml.length > 10) sheetObjects[9].LoadSearchXml(arrXml[10]);
	
						//Installment
						var prefix = "sheet_"
						for (var ii=1; ii<11; ii++) {
							var findRow = sheetObjects[10].FindText(prefix+"inst_seq", ii);
							if (findRow > 0) {
								eval("form.inst_locl_amt_"+ii).value = sheetObjects[10].CellValue(findRow, prefix+"inst_locl_amt");
								eval("form.inst_xch_rt_"+ii).value   = sheetObjects[10].CellValue(findRow, prefix+"inst_xch_rt");
								eval("form.inst_usd_amt_"+ii).value  = sheetObjects[10].CellValue(findRow, prefix+"inst_usd_amt");
								eval("form.inst_due_dt_"+ii).value   = sheetObjects[10].CellValue(findRow, prefix+"inst_due_dt");
								eval("form.inst_pay_dt_"+ii).value   = sheetObjects[10].CellValue(findRow, prefix+"inst_pay_dt");
							} else {
								eval("form.inst_locl_amt_"+ii).value = '';
								eval("form.inst_xch_rt_"+ii).value   = '';
								eval("form.inst_usd_amt_"+ii).value  = '';
								eval("form.inst_due_dt_"+ii).value   = '';
								eval("form.inst_pay_dt_"+ii).value   = '';
							}
						}
					} else {
						clearPremium();
					}	

	   			} else {//Premium
					formObj.f_cmd.value = SEARCH01;

					//Insurer 정보 저장
					insurClmPtyNo = formObj.insur_clm_pty_prm_no.value;
					insurClmPtyNm = formObj.insur_clm_pty_prm_nm.value;

					sheetObj = sheetObjects[10];
		        	
		        	var aryPrefix = new Array("sheet_", "file_", "file_");
		        	
		   			var sXml = sheetObj.GetSearchXml("CPS_CNI_0401GS.do" , FormQueryString(formObj) +"&" + ComGetPrefixParam(aryPrefix));
					var arrXml = sXml.split("|$$|");
					if (arrXml.length > 0) sheetObjects[10].LoadSearchXml(arrXml[0]);
					if (arrXml.length > 1) sheetObjects[8].LoadSearchXml(arrXml[1]);	
					if (arrXml.length > 2) sheetObjects[9].LoadSearchXml(arrXml[2]);
					
					//Installment
					var prefix = "sheet_"
					for (var ii=1; ii<11; ii++) {
						var findRow = sheetObjects[10].FindText(prefix+"inst_seq", ii);
						if (findRow > 0) {
							eval("form.inst_locl_amt_"+ii).value = sheetObjects[10].CellValue(findRow, prefix+"inst_locl_amt");
							eval("form.inst_xch_rt_"+ii).value   = sheetObjects[10].CellValue(findRow, prefix+"inst_xch_rt");
							eval("form.inst_usd_amt_"+ii).value  = sheetObjects[10].CellValue(findRow, prefix+"inst_usd_amt");
							eval("form.inst_due_dt_"+ii).value   = sheetObjects[10].CellValue(findRow, prefix+"inst_due_dt");
							eval("form.inst_pay_dt_"+ii).value   = sheetObjects[10].CellValue(findRow, prefix+"inst_pay_dt");
						} else {
							eval("form.inst_locl_amt_"+ii).value = '';
							eval("form.inst_xch_rt_"+ii).value   = '';
							eval("form.inst_usd_amt_"+ii).value  = '';
							eval("form.inst_due_dt_"+ii).value   = '';
							eval("form.inst_pay_dt_"+ii).value   = '';
						}
					}	
	   			}
	   			
   				ComEtcDataToForm(formObj, sheetObj);

	   			if (ComGetEtcData(arrXml[0], "Retrieve") == "Y") {//Data found
	   				//검색 조건 필드 제어
	   				inputReadOnly("Search");
	   			} else {
	   				if (beforetab == 0) {//Main Terms
		   				formObj.insur_clm_pty_no.value = insurClmPtyNo;
	   					formObj.insur_clm_pty_nm.value = insurClmPtyNm;

	   			        sheetObjects[0].RemoveAll();
	   			        sheetObjects[1].RemoveAll();
	   			        sheetObjects[2].RemoveAll();
	   			        sheetObjects[3].RemoveAll();
	   			        sheetObjects[4].RemoveAll();
	   			        sheetObjects[5].RemoveAll();
	   			        sheetObjects[6].RemoveAll();
	   			        sheetObjects[7].RemoveAll();

	   				} else {//Premium
		   				formObj.insur_clm_pty_prm_no.value = insurClmPtyNo;
	   					formObj.insur_clm_pty_prm_nm.value = insurClmPtyNm;

	   			        sheetObjects[10].RemoveAll();
	   			        sheetObjects[8].RemoveAll();
	   			        sheetObjects[9].RemoveAll();

	   				}

	   			}

			break;

			case IBROWSEARCH: 

				if (Col == "ComCd") {//코드 조회
					
					CoCniGetCombo(formObj, sheetObj, "FORM:FORM", "27:28","insur_tp_cd:insur_prm_tp_cd", "insur_tp_cdText:insur_prm_tp_cdText");

				} else if (Col == "Insurer") {//해당 Insurance Type으로 데이터가 존재하는지 체크

					formObj.f_cmd.value = SEARCH02;
		   			var sXml = sheetObj.GetSearchXml("CPS_CNI_0401GS.do" , FormQueryString(formObj));
		   			sheetObj.LoadSearchXml(sXml);

		   			if (ComGetEtcData(sXml, "Retrieve") == "Y") {//Data found
						doActionIBSheet(sheetObj,formObj,IBSEARCH);
		   			}	

				} else if (Col == "Premium") {//해당 Premium Type으로 데이터가 존재하는지 체크

					formObj.f_cmd.value = SEARCH03;
		   			var sXml = sheetObj.GetSearchXml("CPS_CNI_0401GS.do" , FormQueryString(formObj));
		   			sheetObj.LoadSearchXml(sXml);

		   			if (ComGetEtcData(sXml, "Retrieve") == "Y") {//Data found
						doActionIBSheet(sheetObj,formObj,IBSEARCH);
		   			}	

				} else {//Currency 조회
					
					var obj = eval("document."+formObj.name+"."+Col);
		
		   			var sXml = sheetObj.GetSearchXml("CPS_CNI_0301GS.do" , "&f_cmd="+SEARCH04+"&curr_cd="+obj.value);

		   			var result = ComGetEtcData(sXml, "curr_cd");

		   			if(typeof result == "undefined" || result == "" ) {
						obj.value = "";
						ComAlertFocus(obj, ComGetEtcData(sXml, "errMsg"));
						return;
					} else {
			    		//환율, USD Amount를 초기화함
			    		changeCurrency(obj);
					}
				}
			break;

			case IBSAVE:        //저장
          		if(!validateForm(sheetObj,formObj,sAction, Col)) return;

			   	var result = "";
			   	if (Col == 'Save') {//Save
			   		
					if (beforetab == 0) {//Main Terms

						formObj.f_cmd.value = MODIFY;
						
						//Interest와 Subject Matter Insured인 경우 name필드 값을 desc에 세팅함.
						formObj.int_desc.value = formObj.int_desc_nm.value;
						formObj.subj_mat_ins_desc.value = formObj.subj_mat_ins_desc_nm.value;
						
						var sXml = sheetObj.GetSaveXml("CPS_CNI_0401GS.do", FormQueryString(formObj));
						
			   			result   = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
						
					} else {//Premium
						
						formObj.f_cmd.value = MODIFY01;
						
						sheetObj = sheetObjects[10];
						
						//Installment 필드를 Sheet에 세팅하기
						var prefix = "sheet_"
						var aryPrefix = new Array("sheet_");
						for (var ii=1; ii<11; ii++) {
							var varLoclAmt = eval("form.inst_locl_amt_"+ii).value.trim();
							var varXchRt = eval("form.inst_xch_rt_"+ii).value.trim();
							var varUsdAmt = eval("form.inst_usd_amt_"+ii).value.trim();
							var varDueDt = eval("form.inst_due_dt_"+ii).value.trim();
							var varPayDt = eval("form.inst_pay_dt_"+ii).value.trim();
							
							var findRow = sheetObj.FindText(prefix+"inst_seq", ii);
							if (varLoclAmt != "" || varXchRt != "" || varDueDt != "" || varPayDt != "") {
 								if (findRow < 1) {//Insert
 									findRow = sheetObj.DataInsert();
 								}

								sheetObj.CellValue(findRow, prefix+"inst_seq") = ii;
								sheetObj.CellValue(findRow, prefix+"inst_locl_amt") = ComReplaceStr(varLoclAmt,",");
								sheetObj.CellValue(findRow, prefix+"inst_curr_cd") = form.ttl_curr_cd.value;
								sheetObj.CellValue(findRow, prefix+"inst_xch_rt") = ComReplaceStr(varXchRt,",");
								sheetObj.CellValue(findRow, prefix+"inst_usd_amt") = ComReplaceStr(varUsdAmt,",");
								sheetObj.CellValue(findRow, prefix+"inst_due_dt") = ComReplaceStr(varDueDt,"-");
								sheetObj.CellValue(findRow, prefix+"inst_pay_dt") = ComReplaceStr(varPayDt,"-");
								sheetObj.CellValue(findRow, prefix+"insur_tp_cd") = form.insur_tp_cd.value;
								sheetObj.CellValue(findRow, prefix+"insur_plcy_yr") = form.insur_plcy_yr.value;
								sheetObj.CellValue(findRow, prefix+"insur_clm_pty_no") = form.insur_clm_pty_prm_no.value;
								sheetObj.CellValue(findRow, prefix+"insur_prm_tp_cd") = form.insur_prm_tp_cd.value;
							} else {
 								if (findRow > 0) {//Delete
 									sheetObj.RowStatus(findRow) = "D";
 								}
							}
						}

						var arrSheets = new Array(sheetObj);
						var sParam = ComGetSaveString(arrSheets);
						var sXml = sheetObj.GetSaveXml("CPS_CNI_0401GS.do", FormQueryString(formObj) +"&" + sParam +"&" + ComGetPrefixParam(aryPrefix));
						
			   			result   = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
	
					}	
					
					if (result == 'S') {
			   			
			   			var iStart = 0;
			   			var iEnd = 0;
			   			//File 저장
						if (beforetab == 0) {//Main Terms
							iEnd = 8;
						} else {//Premium
							iStart = 8;
							iEnd = 10;
						}
						
			   			for (var i=iStart; i<iEnd; i++) {
							if (sheetObjects[i].isDataModified) {
								doActionIBSheet(sheetObjects[i],formObj,IBSAVE,'FILE','N');
							}
			   			}

						//검색 조건 필드 제어
	   					inputReadOnly("Search");

					}

					sheetObj.LoadSaveXml(sXml);

			   	} else if (Col == 'Delete') {//Delete
			   		
			   		var insurPlcyYr = formObj.insur_plcy_yr.value;
			   	
					if (beforetab == 0) {//Main Terms

						formObj.f_cmd.value = MODIFY02;
						
						var sXml = sheetObj.GetSaveXml("CPS_CNI_0401GS.do", FormQueryString(formObj));
						
						sheetObj.LoadSaveXml(sXml);

		   				result = ComGetEtcData(sXml, "TRANS_RESULT_KEY");

					} else {//Premium
						
						formObj.f_cmd.value = MODIFY03;
						
						sheetObj = sheetObjects[10];

						var sXml = sheetObj.GetSaveXml("CPS_CNI_0401GS.do", FormQueryString(formObj));

						sheetObj.LoadSaveXml(sXml);

		   				result = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
					}
					
					if (result == 'S') {
	            		var obj = document.getElementById("btn1_New");
	            		if (obj) obj.fireEvent("onclick");
	            		formObj.insur_plcy_yr.value = insurPlcyYr;
	            	}	
						
			   	} else {
					formObj.f_cmd.value = MULTI;
					
					//1.IBUpload에 파일 추가하기
					var upObj = uploadObjects[0];
					
					upObj.Files="";	//-먼저기존파일을 모두 지운후 추가함

					var paramFile1 = setFileUpload(sheetObj, "file_", upObj);

					//2.IBSheet 데이터 QueryString으로 묶기
					var arrSheets = new Array(sheetObj);
					var sParam = ComGetSaveString(arrSheets);
					
					if (sParam == "") return;
					
					//3.Form 데이터 QueryString으로 묶기
					var aryPrefix = new Array("file_");
					
					sParam = "&f_cmd=" + MULTI + "&" + sParam +"&" + ComGetPrefixParam(aryPrefix) + "&" + paramFile1;
					
					if (upObj.LocalFiles == "") {//
					/*******파일이 없는 경우 IBSheet 이용하기********/

						var sXml = sheetObj.GetSaveXml("CNI_FILE_0000GS.do", sParam);

					} else {
					/*******파일이 있는 경우 IBUpload 이용하기********/

						//4. 서버에 request전달하고, reponse 받기
						upObj.ExtendParam = sParam;
						
						//upObj.ParamDecoding = true;

						ComOpenWait(true);
						
						var sXml = upObj.DoUpload(true);
					}
		   			sheetObj.LoadSaveXml(sXml);

					ComOpenWait(false);

		   			var result   = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
		   			if (result == 'S' && msgYN == null) {
		   				ComShowCodeMessage('CNI00008');
		   			}

			   	}

			break;
        }
    }


    /**
     * Party popup에서 선택시 Party Name을 세팅한다.
     */
    function setMainCodeInquiry(partyVo) {

		eval("form."+popupType.substring(4)+"_no").value = partyVo.clm_pty_no;
		eval("form."+popupType.substring(4)+"_nm").value = partyVo.pty_nm;

    	//Insurer인 경우 자동 조회
		if (popupType == "pop_insur_clm_pty" || popupType == "pop_insur_clm_pty_prm") {
	       	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}
		
    }

    /**
     * R.O.E popup에서 선택시 Currency, Exchange Rate를 세팅한다.
     */
    function setCurrencyROE(xchRtVo) {

		if (popupType == "pop_ins_xch_rt" || popupType == "pop_lmt_ins_xch_rt" || popupType == "pop_ttl_xch_rt") {
			eval("form."+ComReplaceStr(popupType.substring(4), "xch_rt", "")+"curr_cd").value = xchRtVo.curr_cd;
		} else {//Premium의 경우 Total의 필드가 아닌 경우 Total의 Currency와 다르면 안됨
			if (form.ttl_curr_cd.value != xchRtVo.curr_cd) {
		    	ComAlertFocus(eval("form."+popupType.substring(4)), ComGetMsg('CNI09059'));
				return;
			}	
		}
		eval("form."+popupType.substring(4)).value = xchRtVo.usd_locl_xch_rt;
		amount_change(eval("form."+popupType.substring(4)));
    	
    }

    /**
     * 환율 팝업 클릭시 금액, 통화 등 다른 연관 필드도 모두 입력되었는지 체크
     */
    function chkFieldAmount(objLoclAmt, objCurrCd, msg1) {
		
		var loclAmt = objLoclAmt.value.trim();
		var currCd = objCurrCd.value.trim();

		var msg2 = msg1;
		
       	if (msg1==undefined || msg1==null) {

           switch (popupType) {
                case "pop_ttl_xch_rt":
                	msg1 = "Total";
                	msg2 = "Total";
	                break;
                case "pop_adj_xch_rt":
                	msg1 = "Total";
                	msg2 = "Paid";
	                break;
                case "pop_rfnd_xch_rt":
                	msg1 = "Total";
                	msg2 = "Refunded";
	                break;
                case "pop_ots_xch_rt":
                	msg1 = "Total";
                	msg2 = "O/S";
	                break;
                case "pop_inst_xch_rt_1":
                	msg1 = "Total";
                	msg2 = "1st Installment";
	                break;
                case "pop_inst_xch_rt_2":
                	msg1 = "Total";
                	msg2 = "2nd Installment";
	                break;
                case "pop_inst_xch_rt_3":
                	msg1 = "Total";
                	msg2 = "3rd Installment";
	                break;
                default:
                	msg1 = "Total";
                	msg2 = popupType.substring(popupType.length-1)+"th Installment";
	                break;
            }
       		
       	}
       	
       	if (ComIsNull(currCd)) {
	    	ComAlertFocus(objCurrCd, ComGetMsg('CNI09028',msg1+"(Currency)"));
			return false;
       	} 
    	if (ComIsNull(loclAmt)) {
	    	ComAlertFocus(objLoclAmt, ComGetMsg('CNI09028',msg2+"(Amount)"));
			return false;
       	} 
		
		return true;
		
    }


    /**
     * 금액, 통화, 환율이 하나라도 입력시 다른 연관 필드도 모두 입력되었는지 체크
     */
    function chkAmount(objLoclAmt, objCurrCd, objXchRt, objUsdAmt, msg1) {
		
		var loclAmt = objLoclAmt.value.trim();
		var currCd = objCurrCd.value.trim();
		var xchRt = objXchRt.value.trim();
		if (xchRt == "") xchRt = "0"; 
		var usdAmt = objUsdAmt.value.trim();
		if (usdAmt == "") usdAmt = "0"; 
		
		var msg2 = msg1;

       	if (msg1==undefined || msg1==null) {
			switch (objXchRt.name) {
			    case "adj_xch_rt":
			    	msg1 = "Total";
			    	msg2 = "Paid";
			        break;
			    case "rfnd_xch_rt":
			    	msg1 = "Total";
			    	msg2 = "Refunded";
			        break;
			    case "ots_xch_rt":
			    	msg1 = "Total";
			    	msg2 = "O/S";
			        break;
			    case "inst_xch_rt_1":
			    	msg1 = "Total";
			    	msg2 = "1st Installment";
			        break;
			    case "inst_xch_rt_2":
			    	msg1 = "Total";
			    	msg2 = "2nd Installment";
			        break;
			    case "inst_xch_rt_3":
			    	msg1 = "Total";
			    	msg2 = "3rd Installment";
			        break;
			    default:
			    	msg1 = "Total";
			    	msg2 = objXchRt.name.substring(objXchRt.name.length-1)+"th Installment";
			        break;
			}
		}

		if (msg1 == msg2 && ComIsNull(loclAmt) && ComIsNull(currCd) && parseFloat(xchRt) == 0 && parseFloat(usdAmt) == 0) {
			objXchRt.value = "";
			objUsdAmt.value = "";
			return true;
		//Installment인 경우
		} else if (msg1 != msg2 && ComIsNull(loclAmt) && parseFloat(xchRt) == 0 && parseFloat(usdAmt) == 0) {
			objXchRt.value = "";
			objUsdAmt.value = "";
			return true;
		} else if (!ComIsNull(loclAmt) && !ComIsNull(currCd) && parseFloat(xchRt) != 0 && parseFloat(usdAmt) != 0) {
			return true;
		} else {
        	
        	if (ComIsNull(loclAmt)) {
		    	ComAlertFocus(objLoclAmt, ComGetMsg('CNI09028',msg2+"(Amount)"));
				return false;
	       	} else if (ComIsNull(currCd)) {
		    	ComAlertFocus(objCurrCd, ComGetMsg('CNI09028',msg1+"(Currency)"));
				return false;
	       	} else if (parseFloat(xchRt) == 0) {
		    	ComAlertFocus(objXchRt, ComGetMsg('CNI09028',msg2+"(R.O.E)"));
				return false;
	       	} else if (parseFloat(usdAmt) == 0) {
		    	ComAlertFocus(objUsdAmt, ComGetMsg('CNI09028',msg2+"(Amount USD)"));
				return false;
        	} 
		
		}
		
		return true;
		
    }
	
	/**
     * 파일 선택하기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     **/
	function sheet1_OnPopupClick(sheetObj,Row,Col){
		var prefix = "file_";
		var fileName = sheetObj.OpenFileDialog("Open File");
		
		if(fileName.indexOf("\\") !=-1) {
			sheetObj.CellValue2(Row, prefix+"file_path")= fileName;

			fileName = fileName.substr(fileName.lastIndexOf("\\")+1);
			sheetObj.CellValue2(Row, Col)= fileName;
		}
	}
	
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @param {String} 	Value     	파일명
     **/
	function sheet1_OnClick(sheetObj,Row,Col,Value){
		var prefix = "file_";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_download" || sheetObj.RowStatus(Row)=="I") return;
		
		if(sheetObj.CellText(Row, prefix+"file_sav_id") == "") return;
		
		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, prefix+"file_sav_id");
		return;
	}
	
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     **/
	function sheet1_OnDblClick(sheetObj,Row,Col){
		var prefix = "file_";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_nm" || sheetObj.RowStatus(Row)=="I") return;
		
		if(sheetObj.CellText(Row, prefix+"file_sav_id") == "") return;
		
		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, prefix+"file_sav_id");
		return;
	}
	
	/**
     * 파일 선택하기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     **/
	function sheet2_OnPopupClick(sheetObj,Row,Col){
		var prefix = "file_";
		var fileName = sheetObj.OpenFileDialog("Open File");
		
		if(fileName.indexOf("\\") !=-1) {
			sheetObj.CellValue2(Row, prefix+"file_path")= fileName;

			fileName = fileName.substr(fileName.lastIndexOf("\\")+1);
			sheetObj.CellValue2(Row, Col)= fileName;
		}
	}
	
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @param {String} 	Value     	파일명
     **/
	function sheet2_OnClick(sheetObj,Row,Col,Value){
		var prefix = "file_";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_download" || sheetObj.RowStatus(Row)=="I") return;
		
		if(sheetObj.CellText(Row, prefix+"file_sav_id") == "") return;
		
		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, prefix+"file_sav_id");
		return;
	}
	
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     **/
	function sheet2_OnDblClick(sheetObj,Row,Col){
		var prefix = "file_";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_nm" || sheetObj.RowStatus(Row)=="I") return;
		
		if(sheetObj.CellText(Row, prefix+"file_sav_id") == "") return;
		
		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, prefix+"file_sav_id");
		return;
	}
	
	/**
     * 파일 선택하기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     **/
	function sheet3_OnPopupClick(sheetObj,Row,Col){
		var prefix = "file_";
		var fileName = sheetObj.OpenFileDialog("Open File");
		
		if(fileName.indexOf("\\") !=-1) {
			sheetObj.CellValue2(Row, prefix+"file_path")= fileName;

			fileName = fileName.substr(fileName.lastIndexOf("\\")+1);
			sheetObj.CellValue2(Row, Col)= fileName;
		}
	}
	
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @param {String} 	Value     	파일명
     **/
	function sheet3_OnClick(sheetObj,Row,Col,Value){
		var prefix = "file_";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_download" || sheetObj.RowStatus(Row)=="I") return;
		
		if(sheetObj.CellText(Row, prefix+"file_sav_id") == "") return;
		
		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, prefix+"file_sav_id");
		return;
	}
	
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     **/
	function sheet3_OnDblClick(sheetObj,Row,Col){
		var prefix = "file_";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_nm" || sheetObj.RowStatus(Row)=="I") return;
		
		if(sheetObj.CellText(Row, prefix+"file_sav_id") == "") return;
		
		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, prefix+"file_sav_id");
		return;
	}
	
	/**
     * 파일 선택하기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     **/
	function sheet4_OnPopupClick(sheetObj,Row,Col){
		var prefix = "file_";
		var fileName = sheetObj.OpenFileDialog("Open File");
		
		if(fileName.indexOf("\\") !=-1) {
			sheetObj.CellValue2(Row, prefix+"file_path")= fileName;

			fileName = fileName.substr(fileName.lastIndexOf("\\")+1);
			sheetObj.CellValue2(Row, Col)= fileName;
		}
	}
	
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @param {String} 	Value     	파일명
     **/
	function sheet4_OnClick(sheetObj,Row,Col,Value){
		var prefix = "file_";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_download" || sheetObj.RowStatus(Row)=="I") return;
		
		if(sheetObj.CellText(Row, prefix+"file_sav_id") == "") return;
		
		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, prefix+"file_sav_id");
		return;
	}
	
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     **/
	function sheet4_OnDblClick(sheetObj,Row,Col){
		var prefix = "file_";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_nm" || sheetObj.RowStatus(Row)=="I") return;
		
		if(sheetObj.CellText(Row, prefix+"file_sav_id") == "") return;
		
		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, prefix+"file_sav_id");
		return;
	}
	
	/**
     * 파일 선택하기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     **/
	function sheet5_OnPopupClick(sheetObj,Row,Col){
		var prefix = "file_";
		var fileName = sheetObj.OpenFileDialog("Open File");
		
		if(fileName.indexOf("\\") !=-1) {
			sheetObj.CellValue2(Row, prefix+"file_path")= fileName;

			fileName = fileName.substr(fileName.lastIndexOf("\\")+1);
			sheetObj.CellValue2(Row, Col)= fileName;
		}
	}
	
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @param {String} 	Value     	파일명
     **/
	function sheet5_OnClick(sheetObj,Row,Col,Value){
		var prefix = "file_";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_download" || sheetObj.RowStatus(Row)=="I") return;
		
		if(sheetObj.CellText(Row, prefix+"file_sav_id") == "") return;
		
		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, prefix+"file_sav_id");
		return;
	}
	
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     **/
	function sheet5_OnDblClick(sheetObj,Row,Col){
		var prefix = "file_";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_nm" || sheetObj.RowStatus(Row)=="I") return;
		
		if(sheetObj.CellText(Row, prefix+"file_sav_id") == "") return;
		
		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, prefix+"file_sav_id");
		return;
	}
	
	/**
     * 파일 선택하기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     **/
	function sheet6_OnPopupClick(sheetObj,Row,Col){
		var prefix = "file_";
		var fileName = sheetObj.OpenFileDialog("Open File");
		
		if(fileName.indexOf("\\") !=-1) {
			sheetObj.CellValue2(Row, prefix+"file_path")= fileName;

			fileName = fileName.substr(fileName.lastIndexOf("\\")+1);
			sheetObj.CellValue2(Row, Col)= fileName;
		}
	}
	
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @param {String} 	Value     	파일명
     **/
	function sheet6_OnClick(sheetObj,Row,Col,Value){
		var prefix = "file_";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_download" || sheetObj.RowStatus(Row)=="I") return;
		
		if(sheetObj.CellText(Row, prefix+"file_sav_id") == "") return;
		
		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, prefix+"file_sav_id");
		return;
	}
	
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     **/
	function sheet6_OnDblClick(sheetObj,Row,Col){
		var prefix = "file_";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_nm" || sheetObj.RowStatus(Row)=="I") return;
		
		if(sheetObj.CellText(Row, prefix+"file_sav_id") == "") return;
		
		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, prefix+"file_sav_id");
		return;
	}
	
	/**
     * 파일 선택하기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     **/
	function sheet7_OnPopupClick(sheetObj,Row,Col){
		var prefix = "file_";
		var fileName = sheetObj.OpenFileDialog("Open File");
		
		if(fileName.indexOf("\\") !=-1) {
			sheetObj.CellValue2(Row, prefix+"file_path")= fileName;

			fileName = fileName.substr(fileName.lastIndexOf("\\")+1);
			sheetObj.CellValue2(Row, Col)= fileName;
		}
	}
	
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @param {String} 	Value     	파일명
     **/
	function sheet7_OnClick(sheetObj,Row,Col,Value){
		var prefix = "file_";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_download" || sheetObj.RowStatus(Row)=="I") return;
		
		if(sheetObj.CellText(Row, prefix+"file_sav_id") == "") return;
		
		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, prefix+"file_sav_id");
		return;
	}
	
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     **/
	function sheet7_OnDblClick(sheetObj,Row,Col){
		var prefix = "file_";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_nm" || sheetObj.RowStatus(Row)=="I") return;
		
		if(sheetObj.CellText(Row, prefix+"file_sav_id") == "") return;
		
		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, prefix+"file_sav_id");
		return;
	}
	
	/**
     * 파일 선택하기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     **/
	function sheet8_OnPopupClick(sheetObj,Row,Col){
		var prefix = "file_";
		var fileName = sheetObj.OpenFileDialog("Open File");
		
		if(fileName.indexOf("\\") !=-1) {
			sheetObj.CellValue2(Row, prefix+"file_path")= fileName;

			fileName = fileName.substr(fileName.lastIndexOf("\\")+1);
			sheetObj.CellValue2(Row, Col)= fileName;
		}
	}
	
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @param {String} 	Value     	파일명
     **/
	function sheet8_OnClick(sheetObj,Row,Col,Value){
		var prefix = "file_";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_download" || sheetObj.RowStatus(Row)=="I") return;
		
		if(sheetObj.CellText(Row, prefix+"file_sav_id") == "") return;
		
		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, prefix+"file_sav_id");
		return;
	}
	
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     **/
	function sheet8_OnDblClick(sheetObj,Row,Col){
		var prefix = "file_";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_nm" || sheetObj.RowStatus(Row)=="I") return;
		
		if(sheetObj.CellText(Row, prefix+"file_sav_id") == "") return;
		
		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, prefix+"file_sav_id");
		return;
	}
	
	/**
     * 파일 선택하기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     **/
	function sheet9_OnPopupClick(sheetObj,Row,Col){
		var prefix = "file_";
		var fileName = sheetObj.OpenFileDialog("Open File");
		
		if(fileName.indexOf("\\") !=-1) {
			sheetObj.CellValue2(Row, prefix+"file_path")= fileName;

			fileName = fileName.substr(fileName.lastIndexOf("\\")+1);
			sheetObj.CellValue2(Row, Col)= fileName;
		}
	}
	
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @param {String} 	Value     	파일명
     **/
	function sheet9_OnClick(sheetObj,Row,Col,Value){
		var prefix = "file_";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_download" || sheetObj.RowStatus(Row)=="I") return;
		
		if(sheetObj.CellText(Row, prefix+"file_sav_id") == "") return;
		
		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, prefix+"file_sav_id");
		return;
	}
	
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     **/
	function sheet9_OnDblClick(sheetObj,Row,Col){
		var prefix = "file_";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_nm" || sheetObj.RowStatus(Row)=="I") return;
		
		if(sheetObj.CellText(Row, prefix+"file_sav_id") == "") return;
		
		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, prefix+"file_sav_id");
		return;
	}
	
	/**
     * 파일 선택하기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     **/
	function sheet10_OnPopupClick(sheetObj,Row,Col){
		var prefix = "file_";
		var fileName = sheetObj.OpenFileDialog("Open File");
		
		if(fileName.indexOf("\\") !=-1) {
			sheetObj.CellValue2(Row, prefix+"file_path")= fileName;

			fileName = fileName.substr(fileName.lastIndexOf("\\")+1);
			sheetObj.CellValue2(Row, Col)= fileName;
		}
	}
	
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @param {String} 	Value     	파일명
     **/
	function sheet10_OnClick(sheetObj,Row,Col,Value){
		var prefix = "file_";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_download" || sheetObj.RowStatus(Row)=="I") return;
		
		if(sheetObj.CellText(Row, prefix+"file_sav_id") == "") return;
		
		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, prefix+"file_sav_id");
		return;
	}
	
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     **/
	function sheet10_OnDblClick(sheetObj,Row,Col){
		var prefix = "file_";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_nm" || sheetObj.RowStatus(Row)=="I") return;
		
		if(sheetObj.CellText(Row, prefix+"file_sav_id") == "") return;
		
		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, prefix+"file_sav_id");
		return;
	}

	/**
     * IBSheet에 업로드하고자 선택한 파일들을 IBUpload로 추가한다 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	prefix    	변수 구분값
     **/
	function setFileUpload(sheetObj, prefix, upObj) {
		//트랜잭션 상태가 "입력"인 행을 찾아 온다.
		var sRow = sheetObj.FindStatusRow("I");
		var arrRow = sRow.split(";");
		
		for (var idx=0; idx<arrRow.length-1; idx++){ 
			var row = arrRow[idx];
			
			//파일 경로 가져오기
			var sFile = sheetObj.CellValue(row,prefix + "file_path");		

			//IBUpload에 파일 추가하기
			var ret = upObj.AddFile(sFile);
		}
		
		var param = prefix + "file_cnt=" + (arrRow.length-1); 

		return param; 
	}

    /**
     * IBSheet XML에서 XML 문자열을 파싱하여 그 안의 파라미터 항목 값을 리턴한다 <br>
     * @param {string} xmlStr    IBSheet를 통해 받아온 xml 문자열
     * @param {string} dataNode  파싱할 항목
     * @return {string} xmlValue
     **/
  	function GetXMLData(xmlStr, dataNode) {
  		
  		var xmlData = '';

        try {
            /* XML Parsing */
            var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
            xmlDoc.async = "false";
            xmlDoc.loadXML(xmlStr);
			/* get message */
            xmlData = xmlDoc.documentElement.getElementsByTagName(dataNode).item(0).text
        } catch(err) {
            xmlData = '';
        }
        
		return xmlData;
  	}

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction,Col){
        with(formObj){

            if (sAction == IBSAVE && Col == "Save") {
				if (beforetab == 0) {//Main Terms
					formObj.insur_clm_pty_nm.setAttribute("required", true);
					
				} else {//Premium
					formObj.insur_clm_pty_prm_nm.setAttribute("required", true);

					formObj.ttl_curr_cd.setAttribute("required", true);
					formObj.ttl_locl_amt.setAttribute("required", true);
					formObj.ttl_xch_rt.setAttribute("required", true);
					formObj.ttl_usd_amt.setAttribute("required", true);
				}
			} else {
				formObj.insur_clm_pty_nm.removeAttribute("required");
				formObj.insur_clm_pty_prm_nm.removeAttribute("required");

				formObj.ttl_curr_cd.removeAttribute("required");
				formObj.ttl_locl_amt.removeAttribute("required");
				formObj.ttl_xch_rt.removeAttribute("required");
				formObj.ttl_usd_amt.removeAttribute("required");
			}

			if (!ComChkValid(formObj)) return false;

            //Main 화면 저장
            if (sAction == IBSAVE && Col == "Save") {
            	
				if (beforetab == 0) {//Main Terms

		           	var fromDt = ComReplaceStr(form.insur_ctrt_eff_dt.value.trim(),"-","");
	            	var toDt = ComReplaceStr(form.insur_ctrt_exp_dt.value.trim(),"-","");
	
	   				if (fromDt != "" && toDt != "" && fromDt > toDt) {
						ComAlertFocus(form.insur_ctrt_exp_dt, ComGetMsg("CNI09058"));
						return;
	   				}
	   				
					if (!chkAmount(form.ins_locl_amt, form.ins_curr_cd, form.ins_xch_rt, form.ins_usd_amt, "Amount Insured")) return;
					if (!chkAmount(form.lmt_ins_locl_amt, form.lmt_ins_curr_cd, form.lmt_ins_xch_rt, form.lmt_ins_usd_amt, "Limit")) return;
					
				} else {//Premium

					if (!chkAmount(form.ttl_locl_amt, form.ttl_curr_cd, form.ttl_xch_rt, form.ttl_usd_amt, "Total")) return;
					if (!chkAmount(form.adj_locl_amt, form.ttl_curr_cd, form.adj_xch_rt, form.adj_usd_amt)) return;
					if (!chkAmount(form.rfnd_locl_amt, form.ttl_curr_cd, form.rfnd_xch_rt, form.rfnd_usd_amt)) return;
					if (!chkAmount(form.ots_locl_amt, form.ttl_curr_cd, form.ots_xch_rt, form.ots_usd_amt)) return;
					
					for (var ii=1; ii<11; ii++) {
						if (!chkAmount(eval("form.inst_locl_amt_"+ii), form.ttl_curr_cd, eval("form.inst_xch_rt_"+ii), eval("form.inst_usd_amt_"+ii))) return;
					}
				}	

            }
        }

        return true;
    }
    
    /**
     * Event에 따른 화면 처리 <br>
     * @param {String} flag     	Event 구분값
     **/
    function inputReadOnly(flag) {
    	var readOnly = true;
    	
    	if(flag == "New") {
    		readOnly = false;
			if (beforetab == 0) {//Main Terms
		    	form.insur_tp_cd.disabled = readOnly;
		    	form.insur_plcy_yr.readOnly = readOnly;
		    	form.insur_prm_tp_cd.disabled = readOnly;
			} else {//Premium
		    	//form.insur_prm_tp_cd.disabled = readOnly;
			}	
	    	ComBtnDisable("btn1_Delete");
    	} else {//Search
			if (beforetab == 0) {//Main Terms
		    	form.insur_tp_cd.disabled = readOnly;
		    	form.insur_plcy_yr.readOnly = readOnly;
			} else {//Premium
		    	//form.insur_prm_tp_cd.disabled = readOnly;
			}	
	    	ComBtnEnable("btn1_Delete");
    	}

    }
    
    /**
     * Premium tab에서 New 버튼 클릭시 <br>
     **/
    function clearPremium() {
        var elems   = form.elements;

        //사용가능한 HTML컨트롤을 배열로 생성한다.
        var premiumYn = "N";
        for (var i = 0; i < elems.length; i++) {

           	//Premium Tab의 오브젝트만 초기화함.
           	if (elems[i].name == "insur_prm_tp_cd") {
           		premiumYn = "Y";
           	}	
           	
           	if (premiumYn == "Y") elems[i].value = "";
            
        }//for

        //Type of Premium 초기값 세팅
        form.insur_prm_tp_cd.value = form.insur_prm_tp_cd.options[0].value;

        sheetObjects[10].RemoveAll();
        sheetObjects[8].RemoveAll();
        sheetObjects[9].RemoveAll();
			            
    }

	/* 개발자 작업  끝 */