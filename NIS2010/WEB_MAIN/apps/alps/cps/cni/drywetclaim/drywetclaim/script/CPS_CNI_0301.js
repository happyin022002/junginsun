/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CPS_CNI_0301.js
*@FileTitle : DW Claim Main
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.10.12 윤세영
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
     * @class CPS_CNI_0301 : CPS_CNI_0301 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function CPS_CNI_0301() {
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

	//IBMultiCombo
	var comboObjects = new Array();
	var comboCnt = 0;
	
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
    
    var uploadObjects = new Array();
	var uploadCnt = 0;
	
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
					//alert(srcName);
            switch(srcName) {
                case "btn1_Retrieve":

	             	if(!CoCniInitConfirm(sheetObject1)) return;
	             	
	             	doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                    break; 

                case "btn1_New":
	             	if(!CoCniInitConfirm(sheetObject1)) return;
	             	
					initAll();
                    break; 

                case "btn1_Cancel":
					doActionIBSheet(sheetObject1,formObject,IBSAVE, "Cancel");
                    break;

                case "btn1_Save":
					doActionIBSheet(sheetObject1,formObject,IBSAVE, "Save");
                    break; 
                
                case "btn1_CaseClose":
					doActionIBSheet(sheetObject1,formObject,IBSAVE, "Close");
                    break; 
                    
               	case "btn1_Reopen":
					doActionIBSheet(sheetObject1,formObject,IBSAVE, "Reopen");
                    break; 
                
                case "btn1_Handling_Costs":
					ComOpenPopup("CPS_CNI_0303.do?popup=yes&dw_clm_no="+formObject.dw_clm_no.value, 1024, 620,"", "1,0,1,1,1", false, false, null, null, 0, "CPS_CNI_0303");
                    break; 
                    
               	case "btn1_Case_Report":
	          		if(!validateForm(sheetObject1,formObject,IBSAVE, "FILE")) return;
					
					ComSetObjValue(formObject.com_mrdPath,"apps/alps/cps/cni/drywetclaim/drywetclaim/report/CPS_CNI_0304.mrd");
					ComSetObjValue(formObject.com_mrdArguments,"/rv form_dw_clm_no[" + formObject.dw_clm_no.value + "]" ); 
					ComSetObjValue(formObject.com_mrdTitle,"Case Report");
					
					ComOpenRDPopup('resizable=yes');
                    break; 
                    
                case "btn2_Row_Add":
	          		if(!validateForm(sheetObject1,formObject,IBSAVE, "FILE")) return;
					var row = sheetObject1.DataInsert(-1);
					var prefix = "file_";
					sheetObject1.CellValue(row, prefix+"clm_file_tp_cd") = "030101";
					sheetObject1.CellValue(row, prefix+"clm_bztp_cd") = "D";
					sheetObject1.CellValue(row, prefix+"dw_clm_no") = formObject.dw_clm_no.value;
					break;

                case "btn2_Row_Insert":
	          		if(!validateForm(sheetObject1,formObject,IBSAVE, "FILE")) return;
					var row = sheetObject1.DataInsert();
					var prefix = "file_";
					sheetObject1.CellValue(row, prefix+"clm_file_tp_cd") = "030101";
					sheetObject1.CellValue(row, prefix+"clm_bztp_cd") = "D";
					sheetObject1.CellValue(row, prefix+"dw_clm_no") = formObject.dw_clm_no.value;
                    break; 

                case "btn2_Row_Delete":
					if(ComCniCheckBoxCheckYn(sheetObject1, "file_DelChk")) { 
						ComRowHideDelete(sheetObject1, "file_DelChk"); 
					}
                    break;

                case "btn2_Save":
					doActionIBSheet(sheetObject1,formObject,IBSAVE,'FILE');
                    break; 
                
                case "cal_inci_occr_dt":
					var cal = new ComCalendar();
					cal.setDisplayType('date');
					cal.select(form.inci_occr_dt, 'yyyy-MM-dd');
                    break; 
                    
                case "btns_hanlder_history":
                	popupDWCHandlerHistory(formObject.dw_clm_no.value);
        			break;
        		/*	
                case "pop_hdlr_usr_id":
					ComOpenPopupWithTarget("COM_ENS_091.do", 780, 560, "usr_id:hdlr_usr_id", "1,0,1,1,1", true);
                    break; 
                */    
               	case "pop_dw_clm_ref_vvd_no":
					popupVvdCd();	
                    break; 
                
                case "cal_inci_occr_dt":
					var cal = new ComCalendar();
					cal.setDisplayType('date');
					cal.select(form.inci_occr_dt, 'yyyy-MM-dd');
                    break; 
                
                case "cal_tm_bar_dt":
					var cal = new ComCalendar();
					cal.setDisplayType('date');
					cal.select(form.tm_bar_dt, 'yyyy-MM-dd');
                    break; 
                
                case "cal_lit_dt":
					var cal = new ComCalendar();
					cal.setDisplayType('date');
					cal.select(form.lit_dt, 'yyyy-MM-dd');
                    break; 
                
                case "cal_prlm_clm_ntfy_dt":
					var cal = new ComCalendar();
					cal.setDisplayType('date');
					cal.select(form.prlm_clm_ntfy_dt, 'yyyy-MM-dd');
                    break; 
                
                case "cal_arbt_dt":
					var cal = new ComCalendar();
					cal.setDisplayType('date');
					cal.select(form.arbt_dt, 'yyyy-MM-dd');
                    break; 
                    
               	case "pop_clmt_clm_pty_nm":
               		popupType = srcName;
					popupMainCodeInquiry();
                    break; 
                    
               	case "pop_deft_clm_pty_nm":
               		popupType = srcName;
					popupMainCodeInquiry();
                    break; 
                    
               	case "pop_labl_pty_clm_pty_nm":
               		popupType = srcName;
					popupMainCodeInquiry();
                    break; 
                    
               	case "pop_insur_clm_pty_nm":
               		popupType = srcName;
					popupMainCodeInquiry();
                    break; 
                    
               	case "btn_clmt_clm_pty_nm":
					var pop_param = "pop_title=Claimants"+"&pop_cont_col=clmt_ctnt";
					formObject.pop_desc.value = formObject.clmt_clm_pty_nm.value;
					ComPostOpenWindow("/hanjin/CPS_CNI_0305.do?"+pop_param, 'CPS_CNI_0305', 'width=1000,height=637');
                    break; 
                    
               	case "btn_deft_clm_pty_nm":
					var pop_param = "pop_title=Defendant"+"&pop_cont_col=deft_ctnt";
					formObject.pop_desc.value = formObject.deft_clm_pty_nm.value;
					ComPostOpenWindow("/hanjin/CPS_CNI_0305.do?"+pop_param, 'CPS_CNI_0305', 'width=1000,height=637');
                    break; 
                    
               	case "btn_labl_pty_clm_pty_nm":
					var pop_param = "pop_title=Liable Party"+"&pop_cont_col=labl_pty_ctnt";
					formObject.pop_desc.value = formObject.labl_pty_clm_pty_nm.value;
					ComPostOpenWindow("/hanjin/CPS_CNI_0305.do?"+pop_param, 'CPS_CNI_0305', 'width=1000,height=637');
                    break; 
                
                case "cal_labl_pty_tm_bar_dt":
					var cal = new ComCalendar();
					cal.setDisplayType('date');
					cal.select(form.labl_pty_tm_bar_dt, 'yyyy-MM-dd');
                    break; 
                
                case "cal_fmal_clm_rcv_dt":
					var cal = new ComCalendar();
					cal.setDisplayType('date');
					cal.select(form.fmal_clm_rcv_dt, 'yyyy-MM-dd');
                    break; 
                
                case "cal_clm_stl_dt":
					var cal = new ComCalendar();
					cal.setDisplayType('date');
					cal.select(form.clm_stl_dt, 'yyyy-MM-dd');
                    break; 
                
                case "cal_labl_pty_file_dt":
					var cal = new ComCalendar();
					cal.setDisplayType('date');
					cal.select(form.labl_pty_file_dt, 'yyyy-MM-dd');
                    break; 
                
                case "cal_labl_pty_rcvr_dt":
					var cal = new ComCalendar();
					cal.setDisplayType('date');
					cal.select(form.labl_pty_rcvr_dt, 'yyyy-MM-dd');
                    break; 
                
                case "cal_insur_file_dt":
					var cal = new ComCalendar();
					cal.setDisplayType('date');
					cal.select(form.insur_file_dt, 'yyyy-MM-dd');
                    break; 
                
                case "cal_insur_rcvr_dt":
					var cal = new ComCalendar();
					cal.setDisplayType('date');
					cal.select(form.insur_rcvr_dt, 'yyyy-MM-dd');
                    break; 
                    
               	case "pop_clm_locl_curr_cd":
					ComOpenPopupWithTarget("COM_ENS_N13.do?classId=COM_ENS_N13&curr_cd=&cnt_cd=&curr_desc=", 500, 450, "curr_cd:clm_locl_curr_cd", "1,0,1,1,1", true);

                    break; 
                    
               	case "pop_clm_stl_locl_curr_cd":
					ComOpenPopupWithTarget("COM_ENS_N13.do?classId=COM_ENS_N13&curr_cd=&cnt_cd=&curr_desc=", 500, 450, "curr_cd:clm_stl_locl_curr_cd", "1,0,1,1,1", true);

                    break; 
                    
               	case "pop_labl_pty_file_locl_curr_cd":
					ComOpenPopupWithTarget("COM_ENS_N13.do?classId=COM_ENS_N13&curr_cd=&cnt_cd=&curr_desc=", 500, 450, "curr_cd:labl_pty_file_locl_curr_cd", "1,0,1,1,1", true);

                    break; 
                    
               	case "pop_labl_pty_rcvr_locl_curr_cd":
					ComOpenPopupWithTarget("COM_ENS_N13.do?classId=COM_ENS_N13&curr_cd=&cnt_cd=&curr_desc=", 500, 450, "curr_cd:labl_pty_rcvr_locl_curr_cd", "1,0,1,1,1", true);

                    break; 
                    
               	case "pop_insur_file_locl_curr_cd":
					ComOpenPopupWithTarget("COM_ENS_N13.do?classId=COM_ENS_N13&curr_cd=&cnt_cd=&curr_desc=", 500, 450, "curr_cd:insur_file_locl_curr_cd", "1,0,1,1,1", true);

                    break; 
                    
               	case "pop_insur_rcvr_locl_curr_cd":
					ComOpenPopupWithTarget("COM_ENS_N13.do?classId=COM_ENS_N13&curr_cd=&cnt_cd=&curr_desc=", 500, 450, "curr_cd:insur_rcvr_locl_curr_cd", "1,0,1,1,1", true);

                    break; 
                    
               	case "pop_clm_xch_rt":
					//환율 팝업 클릭시 금액, 통화, 날짜 등 다른 세개의 필드도 모두 입력되었는지 체크
					if (!chkFieldAmount(form.clm_locl_amt, form.clm_locl_curr_cd, form.fmal_clm_rcv_dt, "Claim Amount", "Date of Formal Claim")) return;

               		popupType = srcName;
               		var currCd = form.clm_locl_curr_cd.value;
               		var yrMon = form.fmal_clm_rcv_dt.value;
					popupRateOfExchange(currCd, yrMon);
                    break; 
                    
               	case "pop_clm_stl_xch_rt":
					if (!chkFieldAmount(form.clm_stl_locl_amt, form.clm_stl_locl_curr_cd, form.clm_stl_dt, "Settled Amount", "Date of Settlement")) return;

               		popupType = srcName;
               		var currCd = form.clm_stl_locl_curr_cd.value;
               		var yrMon = form.clm_stl_dt.value;
					popupRateOfExchange(currCd, yrMon);
                    break; 
                    
               	case "pop_labl_pty_file_xch_rt":
					if (!chkFieldAmount(form.labl_pty_file_locl_amt, form.labl_pty_file_locl_curr_cd, form.labl_pty_file_dt, "LP Claim Amount", "Date of LP Claim")) return;

               		popupType = srcName;
               		var currCd = form.labl_pty_file_locl_curr_cd.value;
               		var yrMon = form.labl_pty_file_dt.value;
					popupRateOfExchange(currCd, yrMon);
                    break; 
                    
               	case "pop_labl_pty_rcvr_xch_rt":
					if (!chkFieldAmount(form.labl_pty_rcvr_locl_amt, form.labl_pty_rcvr_locl_curr_cd, form.labl_pty_rcvr_dt, "LP Recovered Amount", "Date of LP Recovery")) return;

               		popupType = srcName;
               		var currCd = form.labl_pty_rcvr_locl_curr_cd.value;
               		var yrMon = form.labl_pty_rcvr_dt.value;
					popupRateOfExchange(currCd, yrMon);
                    break; 
                    
               	case "pop_insur_file_xch_rt":
					if (!chkFieldAmount(form.insur_file_locl_amt, form.insur_file_locl_curr_cd, form.insur_file_dt, "INS Claim Amount", "Date of INS Claim")) return;

               		popupType = srcName;
               		var currCd = form.insur_file_locl_curr_cd.value;
               		var yrMon = form.insur_file_dt.value;
					popupRateOfExchange(currCd, yrMon);
                    break; 
                    
               	case "pop_insur_rcvr_xch_rt":
					if (!chkFieldAmount(form.insur_rcvr_locl_amt, form.insur_rcvr_locl_curr_cd, form.insur_rcvr_dt, "INS Recovered Amount", "Date of INS Recovery")) return;

               		popupType = srcName;
               		var currCd = form.insur_rcvr_locl_curr_cd.value;
               		var yrMon = form.insur_rcvr_dt.value;
					popupRateOfExchange(currCd, yrMon);
                    break; 
                
                case "cal_clmt_agn_apnt_dt":
					var cal = new ComCalendar();
					cal.setDisplayType('date');
					cal.select(form.clmt_agn_apnt_dt, 'yyyy-MM-dd');
                    break; 
                
                case "cal_deft_agn_apnt_dt":
					var cal = new ComCalendar();
					cal.setDisplayType('date');
					cal.select(form.deft_agn_apnt_dt, 'yyyy-MM-dd');
                    break; 
                    
               	case "pop_clmt_agn_clm_pty_no":
               		popupType = srcName;
					popupMainCodeInquiry();
                    break; 
                    
               	case "pop_deft_agn_clm_pty_no":
               		popupType = srcName;
					popupMainCodeInquiry();
                    break; 
                    
               	case "btn_ca_style":
					var clmPtyNo = form.clmt_agn_clm_pty_no.value;
					if (ComIsNull(clmPtyNo)) {
	                	ComAlertFocus(form.clmt_agn_clm_pty_no, ComGetMsg('CNI00009',"Claimant"));
						return;
					}
					popupMainCodeView(clmPtyNo);
                    break; 
                    
               	case "btn_da_style":
					var clmPtyNo = form.deft_agn_clm_pty_no.value;
					if (ComIsNull(clmPtyNo)) {
	                	ComAlertFocus(form.deft_agn_clm_pty_no, ComGetMsg('CNI00009',"Defendant"));
						return;
					}
					popupMainCodeView(clmPtyNo);
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
     * 초기화 상태로 만듦 
     */
    function initAll(){
		ComResetAll();
    	ComBtnEnable("btn1_Save");
    	disableButtons();
    	form.dw_clm_no.value = "";
    	eval("document.all.combo_dw_clm_tp_cd").Enable = true;//TOC Enable
		eval("document.all.combo_dw_clm_tp_cd").Code = "BCD";
		eval("document.all.combo_dw_co_cd").Code = "HJS";
		eval("document.all.combo_dw_clm_tp_cd").focus();
		
		document.form.trns_flg.disabled = true;
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
	* 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
	* @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
	**/
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
        for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        //Grid 마지막 컬럼의 크기가 그리드 사이즈에 맞게 늘어나지 않게 함.
        sheetObjects[0].ExtendLastCol = false;
        
        for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1);
		}

        //UPLOAD 환경 설정
        for(var i=0;i<uploadObjects.length;i++){
		    //1. 기본 환경 설정
		    ComConfigUpload(uploadObjects[i], "/hanjin/CNI_FILE_0000GS.do");
		
		}

        //html컨트롤 이벤트초기화
        initControl();
        
        initMiscCode(sheetObjects[0]);

		//Case Close, Reopen, Cancel 버튼 Disable
		disableButtons()

		if (form.dw_clm_no.value.trim().length == 11) {
        	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    	} 
		
		//focus를 TOC, Retrieve에 위치시킴
		eval("document.all.combo_dw_clm_tp_cd").focus();
		
    }

	/**
	* Case Close, Reopen, Cancel 버튼 Disable
	*/
    function disableButtons() {
    	ComBtnDisable("btn1_CaseClose");
    	ComBtnDisable("btn1_Reopen");
    	ComBtnDisable("btn1_Cancel");
    	
		document.getElementById("btn1_CaseClose").style.color="#c0c0c0";
		document.getElementById("btn1_Reopen").style.color="#c0c0c0";
		document.getElementById("btn1_Cancel").style.color="#c0c0c0";
    } 

	/**
	* 콤보 Miscellaneous 코드값 가져오기
    * @param {ibsheet} sheetObj    IBSheet Object
	*/
    function initMiscCode(sheetObj) {
		sheetObj.WaitImageVisible = false;
      
		// IBMultiCombo초기화
		for(var k=0; k<comboObjects.length; k++){
			initCombo(comboObjects[k]);
		}
		
		//MISCELLANEOUS 코드 정보를 가져온다
		doActionIBSheet(sheetObj,document.form,IBROWSEARCH, "ComCd");
		eval("document.all.combo_dw_clm_tp_cd").Code = "BCD";
		eval("document.all.combo_dw_co_cd").Code = "HJS";
		eval("document.all.combo_dw_clm_tp_cd").DeleteItem(""); 
		eval("document.all.combo_dw_co_cd").DeleteItem(""); 

		sheetObj.WaitImageVisible = true; 
    } 

	/**
	* 콤보 초기설정값
	* @param {IBMultiCombo} comboObj  comboObj
	*/
	function initCombo(comboObj) {
		comboObj.MultiSelect = false;
		comboObj.UseCode = true;
		comboObj.LineColor = "#ffffff";
		comboObj.SetColAlign("left|left");
		comboObj.MultiSeparator = ",";
		comboObj.DropHeight = 190;
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
        axon_event.addListener  ('keyup', 'obj_keyup' , "dw_clm_no");							//- Case No.가 모두 입력됐을때 keyup 이벤트 발생시

        axon_event.addListener  ('change'  , 'vvd_change', 'dw_clm_ref_vvd_no');				//- VVD 입력 후 입력된 정보 체크하기
        axon_event.addListener  ('change'  , 'handler_change', 'hdlr_usr_id');					//- Handler 입력 후 입력된 정보 체크하기
        axon_event.addListener  ('change'  , 'currency_change', 'clm_locl_curr_cd');			//- Currency 입력 후 입력된 정보 체크하기
        axon_event.addListener  ('change'  , 'currency_change', 'clm_stl_locl_curr_cd');		//- Currency 입력 후 입력된 정보 체크하기
        axon_event.addListener  ('change'  , 'currency_change', 'labl_pty_file_locl_curr_cd');	//- Currency 입력 후 입력된 정보 체크하기
        axon_event.addListener  ('change'  , 'currency_change', 'labl_pty_rcvr_locl_curr_cd');	//- Currency 입력 후 입력된 정보 체크하기
        axon_event.addListener  ('change'  , 'currency_change', 'insur_file_locl_curr_cd');		//- Currency 입력 후 입력된 정보 체크하기
        axon_event.addListener  ('change'  , 'currency_change', 'insur_rcvr_locl_curr_cd');		//- Currency 입력 후 입력된 정보 체크하기
        axon_event.addListener  ('change'  , 'amount_change', 'clm_locl_amt');					//- 금액 입력 후 USD 금액 세팅하기
        axon_event.addListener  ('change'  , 'amount_change', 'clm_stl_locl_amt');				//- 금액 입력 후 USD 금액 세팅하기
        axon_event.addListener  ('change'  , 'amount_change', 'labl_pty_file_locl_amt');		//- 금액 입력 후 USD 금액 세팅하기
        axon_event.addListener  ('change'  , 'amount_change', 'labl_pty_rcvr_locl_amt');		//- 금액 입력 후 USD 금액 세팅하기
        axon_event.addListener  ('change'  , 'amount_change', 'insur_file_locl_amt');			//- 금액 입력 후 USD 금액 세팅하기
        axon_event.addListener  ('change'  , 'amount_change', 'insur_rcvr_locl_amt');			//- 금액 입력 후 USD 금액 세팅하기
        axon_event.addListener  ('change'  , 'amount_change', 'clm_xch_rt');					//- 환율 입력 후 USD 금액 세팅하기
        axon_event.addListener  ('change'  , 'amount_change', 'clm_stl_xch_rt');				//- 환율 입력 후 USD 금액 세팅하기
        axon_event.addListener  ('change'  , 'amount_change', 'labl_pty_file_xch_rt');			//- 환율 입력 후 USD 금액 세팅하기
        axon_event.addListener  ('change'  , 'amount_change', 'labl_pty_rcvr_xch_rt');			//- 환율 입력 후 USD 금액 세팅하기
        axon_event.addListener  ('change'  , 'amount_change', 'insur_file_xch_rt');				//- 환율 입력 후 USD 금액 세팅하기
        axon_event.addListener  ('change'  , 'amount_change', 'insur_rcvr_xch_rt');				//- 환율 입력 후 USD 금액 세팅하기
        axon_event.addListener  ('change'  , 'agent_change', 'clmt_agn_clm_pty_no');			//- Claimant's Agent 입력 후 Tel, e-Mail 가져하기
        axon_event.addListener  ('change'  , 'agent_change', 'deft_agn_clm_pty_no');			//- Defendant's Agent 입력 후 Tel, e-Mail 가져하기
        
    }

 	//focus in
 	function obj_activate(){
 		obj = event.srcElement;
 		//readonly 일때 데이터 포맷 변경되는 것  방지
 		if (obj.getAttribute("readOnly")) return;
 		ComClearSeparator(obj);
 	} 
    
    /**
     * VVD 입력시 입력된 정보 체크한다. <br>
     **/
    function vvd_change() {
    	if (form.dw_clm_ref_vvd_no.value != "") {
			doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'dw_clm_ref_vvd_no');
    	}
    }
    
    /**
     * Status 변경후 Status Text에 조회하기. <br>
     **/
    function status_change() {
		form.dw_clm_sts_nm.value = form.dw_clm_sts_cd.options[form.dw_clm_sts_cd.selectedIndex].text;
		
    }
    
    /**
     * Handler 입력시 입력된 정보 체크한다. <br>
     **/
    function handler_change() {
    	if (form.hdlr_usr_id.value != "") {
			doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'hdlr_usr_id');
    	}
    }
    
    /**
     * Currency 입력시 입력된 정보 체크한다. <br>
     **/
    function currency_change() {
    	var obj = event.srcElement;
    	if (obj.value != "" && obj.value.trim().length == 3) {
    		
    		if (obj.value == "USD") {//USD인 경우 환율에 1로 세팅하고 금액은 local amt랑 똑같게 세팅
    			var objname = ComReplaceStr(obj.name, "locl_curr_cd", "");
    			eval("document.form."+objname+"xch_rt").value = "1.00000";
    			amount_change(obj);
    		} else {
				doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, obj.name);
			}	
    	} else if (obj.value.trim() == "") {
			var objname = ComReplaceStr(obj.name, "locl_curr_cd", "");
			eval("document.form."+objname+"xch_rt").value = "";
			eval("document.form."+objname+"usd_amt").value = "";
    	}
    }
    
    /**
     * 금액 입력 후 USD 금액 세팅하기. <br>
     **/
    function amount_change(obj) {
    	if (obj.name == undefined || obj == null) {
    		obj = event.srcElement;
    	}
    	
    	var objname = obj.name.substring(obj.name.length-3);
    	
    	if (objname == "amt") {//local amount
    		objname = ComReplaceStr(obj.name, "locl_amt", "");
    	} else if (objname == "_cd") {//local currency
    		objname = ComReplaceStr(obj.name, "locl_curr_cd", "");
    	} else if (objname == "_rt") {//exchange rate
    		objname = ComReplaceStr(obj.name, "xch_rt", "");
    	} 
    	
    	var objloclamt = eval("document.form."+objname+"locl_amt");
    	var objrt = eval("document.form."+objname+"xch_rt");
    	var objusdamt = eval("document.form."+objname+"usd_amt");
    	
    	//local 금액에 대해 USD 금액 계산하기
		var valLoclAmt = objloclamt.value.trim();
		var valXchRt = objrt.value.trim();
		
		if (valLoclAmt != "" && valXchRt != "") {
			objloclamt.value = ComAddComma2(ComReplaceStr(valLoclAmt,",",""),"#,###.00");
			var usdAmt = parseFloat(ComReplaceStr(objloclamt.value,",",""))/parseFloat(ComReplaceStr(objrt.value,",",""));
			usdAmt = usdAmt.toFixed(2) + "";
			objusdamt.value = ComAddComma2(usdAmt,"#,###.00");
		} else {
			objusdamt.value = "";
		}    	
    }
    
    /**
     * Agent 입력시 Tel, e-Mail 가져하기. <br>
     **/
    function agent_change(obj) {
    	if (obj.value != "") {
			doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, obj.name);
    	} else {
    		form.deft_agn_clm_pty_nm.value ="";
    		form.deft_agn_tel_no.value ="";
    		form.deft_agn_email.value ="";
    	}
    }

    /**
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_deactivate(){

        ComChkObjValid(event.srcElement);
    	
    }
    
    /**
     * HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
     **/
    function obj_keypress(){

    	switch(event.srcElement.name){
	        case "dw_clm_no":
	            ComKeyOnlyAlphabet('uppernum');
	            break;
	        case "dw_clm_ref_vvd_no":
	            ComKeyOnlyAlphabet('uppernum');
	            break;
	        case "hdlr_usr_id":
	            ComKeyOnlyAlphabet('num');
	            break;
			case "ddct_usd_amt":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
			case "clm_locl_amt":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
			case "clm_usd_amt":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
			case "clm_xch_rt":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
			case "clm_stl_locl_amt":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
			case "clm_stl_usd_amt":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
			case "clm_stl_xch_rt":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
			case "labl_pty_file_locl_amt":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
			case "labl_pty_file_usd_amt":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
			case "labl_pty_file_xch_rt":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
			case "labl_pty_rcvr_locl_amt":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
			case "labl_pty_rcvr_usd_amt":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
			case "labl_pty_rcvr_xch_rt":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
			case "insur_file_locl_amt":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
			case "insur_file_usd_amt":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
			case "insur_file_xch_rt":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
			case "insur_rcvr_locl_amt":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
			case "insur_rcvr_usd_amt":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
			case "insur_rcvr_xch_rt":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
	        case "clm_locl_curr_cd":
	            ComKeyOnlyAlphabet('upper');
	            break;
	        case "clm_stl_locl_curr_cd":
	            ComKeyOnlyAlphabet('upper');
	            break;
	        case "labl_pty_file_locl_curr_cd":
	            ComKeyOnlyAlphabet('upper');
	            break;
	        case "labl_pty_rcvr_locl_curr_cd":
	            ComKeyOnlyAlphabet('upper');
	            break;
	        case "insur_file_locl_curr_cd":
	            ComKeyOnlyAlphabet('upper');
	            break;
	        case "insur_rcvr_locl_curr_cd":
	            ComKeyOnlyAlphabet('upper');
	            break;
	        case "clmt_agn_ref_no":
	            ComKeyOnlyAlphabet('uppernum');
	            break;
	        case "deft_agn_ref_no":
	            ComKeyOnlyAlphabet('uppernum');
	            break;
			default:
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
    	}
    }
    
    /**
     * HTML Control의 Case No.가 모두 입력됐을때 조회한다. <br>
     **/
    function obj_keyup(){
    	switch(event.srcElement.name){
	        case "dw_clm_no":
	        
	        	var keyValue = event.keyCode;
	        	//대문자와 숫자인 경우만 실행
	        	if ((keyValue >= 65 && keyValue <= 90) || (keyValue >= 48 && keyValue <= 57) || (keyValue >= 96 && keyValue <= 105)) {
		        	if (event.srcElement.value.trim().length == 11) {
		            	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		        	} 
	        	}
	            break;
    	}
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
		            InsertTab( cnt++ , "Case Summary" , -1 );
		            InsertTab( cnt++ , "Development" , -1 );
		            InsertTab( cnt++ , "Handler’s Opinion On Settlement" , -1 );
		            InsertTab( cnt++ , "Claimant’s Agent" , -1 );
		            InsertTab( cnt++ , "Defendant’s Agent" , -1 );
		            InsertTab( cnt++ , "File Upload" , -1 );
		        }
		     break;
		  }
	}

	/**
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	*/
	var openTabIndex = 0;
	function tab1_OnChange(tabObj , nItem){
	
		var objs = document.all.item("tabLayer");
	
        objs[nItem].style.display = "Inline";
        objs[beforetab].style.display = "none";

        //--------------- 요기가 중요 --------------------------//
        objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
        //------------------------------------------------------//
        beforetab= nItem;
        
	}

	/**
	 * Tab에서 마우스 왼쪽버튼 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	*/
	function tab1_OnClick(tabObj , nItem){
	
		if (openTabIndex == nItem) {
			var pop_param = '';
			if (nItem == 0) {
				pop_param = "pop_title=Case Summary&pop_cont_col=dw_clm_cs_rmk";
			} else if (nItem == 1) {
				pop_param = "pop_title=Development&pop_cont_col=inci_dev_rmk";
			} else if (nItem == 2) {
				pop_param = "pop_title=Handler's Opinion On Settlement&pop_cont_col=hdlr_stl_opin_rmk";
			}
			
			if (nItem == 0 || nItem == 1 || nItem == 2) {
				form.pop_desc.value = '';
				ComPostOpenWindow("/hanjin/CPS_CNI_0305.do?pop_flag=TAB&"+pop_param, 'CPS_CNI_0305', 'width=1000,height=607');
			}	
		} else {
			openTabIndex = nItem;
		}
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

                	var prefix = "file_";

		           // 높이 설정
					style.height = 150;
										
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

					var HeadTitle1 = "|Sel|Seq|File Name|Contents|ID|Date|File Download||||||";
					var headCount = ComCountHeadTitle(HeadTitle1);
										
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(19, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
                   
                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  	true,   prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,  	40,    	daCenter,  	false,  prefix + "DelChk");
					InitDataProperty(0, cnt++ , dtSeq,        	40,    	daCenter,  	false,  prefix + "Seq");
					InitDataProperty(0, cnt++ , dtPopup,     	300,	daLeft,		false,	prefix + "file_nm",			true,	"",	dfNone,				0,	false,	true,	200);
					InitDataProperty(0, cnt++ , dtData,     	300,	daLeft,		false,	prefix + "file_desc",		false,	"",	dfNone,				0,	true,	true,	500);
					InitDataProperty(0, cnt++ , dtData,     	80,		daCenter,	false,	prefix + "upd_usr_id",		false,	"",	dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,     	80,		daCenter,	false,	prefix + "upd_dt",			false,	"",	dfNone,				0,	false,	false);
					InitDataProperty(0, cnt++ , dtImage,     	100,	daCenter,	false,	prefix + "file_download",	false,	"",	dfNone,				0,	false,	true);
					InitDataProperty(0, cnt++ , dtHidden,		0,    	daCenter,  	false,  prefix + "clm_file_seq");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "clm_file_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "clm_bztp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "dw_clm_no");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "insur_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,   false,  prefix + "insur_plcy_yr");
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

        }
    }

	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction, Col, msgYN) {

        switch(sAction) {
			case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) return;
				
				formObj.f_cmd.value = SEARCH;
	        	
	        	var aryPrefix = new Array("file_");
	
	   			var sXml = sheetObj.GetSearchXml("CPS_CNI_0301GS.do" , "&f_cmd=" + SEARCH + "&dw_clm_no="+formObj.dw_clm_no.value+"&" + ComGetPrefixParam(aryPrefix));
	   			sheetObj.LoadSearchXml(sXml);
	   			if (ComGetEtcData(sXml, "Retrieve") == "Y") {//Data found
	   				ComEtcDataToForm2(formObj, sheetObj, "", true);
	   			    if (ComGetEtcData(sXml, "trnsFlg") != "Y") {formObj.trns_flg.checked = false;}
		   			//Multi Combo Setting
		   			eval("document.all.combo_dw_clm_tp_cd").Code = formObj.dw_clm_tp_cd.value;
		   			eval("document.all.combo_dw_co_cd").Code = formObj.dw_co_cd.value;
		   			eval("document.all.combo_inci_plc_tp_cd").Code = formObj.inci_plc_tp_cd.value;
		   			eval("document.all.combo_dw_clm_att_def_tp_cd").Code = formObj.dw_clm_att_def_tp_cd.value;
		   			eval("document.all.combo_clmt_agn_tp_cd").Code = formObj.clmt_agn_tp_cd.value;
		   			eval("document.all.combo_deft_agn_tp_cd").Code = formObj.deft_agn_tp_cd.value;
		   		 
		   			//Status에 따라 Case Close, Reopen, Cancel 버튼 활성화/비활성화 처리
		   			controlButtons();
		   		
			    	eval("document.all.combo_dw_clm_tp_cd").Enable = false;//TOC Disable
			    	
			    	//Status 변경후 Status Text에 조회하기
			    	status_change();
			    	document.form.trns_flg.disabled = false;
	   			} else {//No data found
		   			//초기화
		   			initAll();
	   			}

			break;

			case IBSAVE:        //저장

          		if(!validateForm(sheetObj,formObj,sAction, Col)) return;

			   	if (Col == 'Save') {//Save
			   	   //저장여부 확인
				   if(!ComShowCodeConfirm('CNI00012')) return;
			   	
			   		formObj.f_cmd.value = MODIFY;
					
					//Status Cd를 세팅한다.
					setStatusCd();
					
					var sXml = sheetObj.GetSaveXml("CPS_CNI_0301GS.do", FormQueryString(formObj));
					
		   			var result   = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
					if (result == 'S') {
						formObj.dw_clm_no.value = ComGetEtcData(sXml, "dwClmNo");
						if (sheetObj.isDataModified) {
							doActionIBSheet(sheetObj,formObj,IBSAVE,'FILE','N');
						}
					} else {
						formObj.dw_clm_sts_cd.value = formObj.dw_clm_sts_cd_org.value;
					}
					ComShowMessage(GetXMLData(sXml, "MESSAGE"));
					doActionIBSheet(sheetObj,formObj,IBSEARCH);
			   	} else if (Col == 'Close') {//Close

			   		if (!confirm(ComGetMsg('CNI09023'))) return;
			   			
			   		if (!chkClose()) {
			   			ComShowCodeMessage('CNI09026');
			   			return;
					}

					formObj.f_cmd.value = MODIFY01;
					var sXml = sheetObj.GetSaveXml("CPS_CNI_0301GS.do", "&f_cmd="+formObj.f_cmd.value+"&dw_clm_no="+formObj.dw_clm_no.value);
					
		   			var result   = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
					if (result == 'S') {
						//formObj.r_office.value = formObj.usr_ofc_cd.value;
						//formObj.r_handler.value = formObj.usr_nm.value;
						formObj.upd_dt.value = formObj.todate.value;
						formObj.cs_clz_dt.value = formObj.todate.value;//DOC
						formObj.dw_clm_sts_cd.value = "CC";
						ComShowMessage(GetXMLData(sXml, "MESSAGE"));
					}
			   	} else if (Col == 'Reopen') {//Reopen
			   		
			   		if (!confirm(ComGetMsg('CNI09024'))) return;
			   			
					formObj.f_cmd.value = MODIFY02;
					var sXml = sheetObj.GetSaveXml("CPS_CNI_0301GS.do", "&f_cmd="+formObj.f_cmd.value+"&dw_clm_no="+formObj.dw_clm_no.value);
					
		   			var result   = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
					if (result == 'S') {
						//formObj.r_office.value = formObj.usr_ofc_cd.value;
						//formObj.r_handler.value = formObj.usr_nm.value;
						formObj.cs_clz_dt.value = '';//DOC
						formObj.upd_dt.value = formObj.todate.value;
						formObj.dw_clm_sts_cd.value = ComGetEtcData(sXml, "statusCd");
						ComShowMessage(GetXMLData(sXml, "MESSAGE"));
					}

			   	} else if (Col == 'Cancel') {//Cancel

			   		if (!confirm(ComGetMsg('CNI09025'))) return;

					formObj.f_cmd.value = MODIFY03;
					var sXml = sheetObj.GetSaveXml("CPS_CNI_0301GS.do", "&f_cmd="+formObj.f_cmd.value+"&dw_clm_no="+formObj.dw_clm_no.value);
					
		   			var result   = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
					if (result == 'S') {
						//formObj.r_office.value = formObj.usr_ofc_cd.value;
						//formObj.r_handler.value = formObj.usr_nm.value;
						formObj.upd_dt.value = formObj.todate.value;
						formObj.dw_clm_sts_cd.value = "XX";
						ComShowMessage(GetXMLData(sXml, "MESSAGE"));
					}
				} else {//File Upload

					formObj.f_cmd.value = MULTI;
					
					//1.IBUpload에 파일 추가하기
					var upObj = uploadObjects[0];
					
					upObj.Files="";	//-먼저기존파일을 모두 지운후 추가함
					
					var paramFile1 = setFileUpload(sheetObj, "file_");

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
			   	
			   	//Status에 따라 Case Close, Reopen, Cancel 버튼 활성화/비활성화 처리
			   	controlButtons();
		    	eval("document.all.combo_dw_clm_tp_cd").Enable = false;//TOC Disable
		    	
		    	//Status 변경후 Status Text에 조회하기
		    	status_change();
			   	
			break;

			case IBROWSEARCH: 

				if (Col == "ComCd") {//코드 조회
					
					CoCniGetCombo(formObj, sheetObj, "MULTI:MULTI:MULTI:MULTI:MULTI:MULTI:FORM", "18:24:21:19:20:20:17","dw_clm_tp_cd:dw_co_cd:inci_plc_tp_cd:dw_clm_att_def_tp_cd:clmt_agn_tp_cd:deft_agn_tp_cd:dw_clm_sts_cd", "dw_clm_tp_cdText:dw_co_cdText:inci_plc_tp_cdText:dw_clm_att_def_tp_cdText:clmt_agn_tp_cdText:deft_agn_tp_cdText:dw_clm_sts_cdText");

				} else if (Col == "dw_clm_ref_vvd_no") {//VVD 조회
					
					var obj = eval("document."+formObj.name+"."+Col);
		
		   			var sXml = sheetObj.GetSearchXml("CPS_CNI_0301GS.do" , "&f_cmd="+SEARCH02+"&dw_clm_ref_vvd_no="+obj.value);

		   			var result = ComGetEtcData(sXml, "vsl_nm");

		   			if(typeof result == "undefined" || result == "" ) {
						formObj.vsl_eng_nm.value = "";
						ComAlertFocus(formObj.dw_clm_ref_vvd_no, ComGetEtcData(sXml, "errMsg"));
						return;
					} else {
						formObj.vsl_eng_nm.value = result;
					}
				} else if (Col == "hdlr_usr_id") {//Handler 조회
					
					var obj = eval("document."+formObj.name+"."+Col);
		
		   			var sXml = sheetObj.GetSearchXml("CPS_CNI_0301GS.do" , "&f_cmd="+SEARCH03+"&hdlr_usr_id="+obj.value);

		   			var result = ComGetEtcData(sXml, "usr_id");

		   			if(typeof result == "undefined" || result == "" ) {
						formObj.hdlr_usr_id.value = "";
						ComAlertFocus(formObj.hdlr_usr_id, ComGetEtcData(sXml, "errMsg"));
						return;
					}
				} else if (Col == "clm_locl_curr_cd" || Col == "clm_stl_locl_curr_cd" || Col == "labl_pty_file_locl_curr_cd"
							|| Col == "labl_pty_rcvr_locl_curr_cd" || Col == "insur_file_locl_curr_cd" || Col == "insur_rcvr_locl_curr_cd") {//Currency 조회
					
					var obj = eval("document."+formObj.name+"."+Col);
		
		   			var sXml = sheetObj.GetSearchXml("CPS_CNI_0301GS.do" , "&f_cmd="+SEARCH04+"&curr_cd="+obj.value);

		   			var result = ComGetEtcData(sXml, "curr_cd");

		   			if(typeof result == "undefined" || result == "" ) {
						obj.value = "";
						ComAlertFocus(obj, ComGetEtcData(sXml, "errMsg"));
						return;
					} else {
				    	var objname = ComReplaceStr(Col, "locl_curr_cd", "");
				    	var objrt = eval("document.form."+objname+"xch_rt");
				    	var objusdamt = eval("document.form."+objname+"usd_amt");
						objrt.value = "";
						objusdamt.value = "";
					}
				} else if (Col == "clmt_agn_clm_pty_no" || Col == "deft_agn_clm_pty_no") {//Agent 조회
					
					var obj = eval("document."+formObj.name+"."+Col);
		
		   			var sXml = sheetObj.GetSearchXml("CPS_CNI_0301GS.do" , "&f_cmd="+SEARCH05+"&agent_cd="+obj.value);

		   			var result = ComGetEtcData(sXml, "phn_no");

		   			if(typeof result == "undefined" || result == "" ) {
						obj.value = "";
						ComAlertFocus(obj, ComGetEtcData(sXml, "errMsg"));
						return;
					} else {
						eval("document."+formObj.name+"."+Col.substring(0,4)+"_agn_tel_no").value = ComGetEtcData(sXml, "phn_no");
						eval("document."+formObj.name+"."+Col.substring(0,4)+"_agn_email").value = ComGetEtcData(sXml, "pty_eml");
					}
				}
					
					
			break;
        }
    }

	/**
	* Vvd Code/Name 입력부분.<br>
	* @param {arry} vvdVo
	*/
	function setVvdCd(vvdVo){
		document.form.dw_clm_ref_vvd_no.value = vvdVo.vvd_cd;
		document.form.vsl_eng_nm.value = vvdVo.vsl_eng_nm;
	}

    /**
     * Status Cd를 세팅한다
     */
    function setStatusCd() {

		form.dw_clm_sts_cd_org.value = form.dw_clm_sts_cd.value;
        
        var statusCd = form.dw_clm_sts_cd.value;

		if (form.insur_file_dt.value != "") {//Date of INS Claim 
    		form.dw_clm_sts_cd.value = "OI";
		} else if (form.labl_pty_file_dt.value != "") {//Date of LP Claim  
    		form.dw_clm_sts_cd.value = "OR";
		} else if (form.clm_stl_dt.value != "") {//Date of Settlement 
    		form.dw_clm_sts_cd.value = "OP";
		} else if (form.lit_dt.value != "") {//Litigated Date 
    		form.dw_clm_sts_cd.value = "OL";
		} else if (form.arbt_dt.value != "") {//Arbitrated Date 
    		form.dw_clm_sts_cd.value = "OB";
		} else if (form.fmal_clm_rcv_dt.value != "") {//Date of Formal Claim 
    		form.dw_clm_sts_cd.value = "OF";
		} else if (form.prlm_clm_ntfy_dt.value != "") {//Date of Notice 
    		form.dw_clm_sts_cd.value = "ON";
		} else {
    		form.dw_clm_sts_cd.value = "";
		}

    	var settleAmt = form.clm_stl_usd_amt.value.trim();

    	if (settleAmt == "") settleAmt = "0";
    	settleAmt = parseFloat(ComReplaceStr(settleAmt,",",""));
    	var LPAmt = form.labl_pty_rcvr_usd_amt.value.trim();
    	if (LPAmt == "") LPAmt = "0";
    	LPAmt = parseFloat(ComReplaceStr(LPAmt,",",""));
    	var INSAmt = form.insur_rcvr_usd_amt.value.trim();
    	if (INSAmt == "") INSAmt = "0";
    	INSAmt = parseFloat(ComReplaceStr(INSAmt,",",""));

        if (settleAmt != 0) {
        	
        	if (statusCd == "OP") {
	    	
	    		if (settleAmt <= LPAmt || settleAmt <= INSAmt || settleAmt <= (LPAmt + INSAmt)) {
	    			form.dw_clm_sts_cd.value = "CC";
	    		}
	    	
    		} else if (statusCd == "OR") {

		    	if (settleAmt <= LPAmt || settleAmt <= (LPAmt + INSAmt)) {
		    		form.dw_clm_sts_cd.value = "CC";
	    		}

	    	} else if (statusCd == "OI") {

		    	if (settleAmt <= INSAmt || settleAmt <= (LPAmt + INSAmt)) {
		    		form.dw_clm_sts_cd.value = "CC";
	    		}
			}

    	}

    }

    /**
     * Status에 따라 Case Close 가능한지 체크한다
     */
    function chkClose() {

		var chkYn = false;

        var statusCd = form.dw_clm_sts_cd.value;

        if (statusCd == "ON") {
	    	var claimAmt = form.clm_locl_amt.value.trim();
	    	if (claimAmt == "") claimAmt = "0";
	    	var settleAmt = form.clm_stl_locl_amt.value.trim();
	    	if (settleAmt == "") settleAmt = "0";
	    	
	    	if (parseFloat(ComReplaceStr(claimAmt,",","")) == 0 && parseFloat(ComReplaceStr(settleAmt,",","")) == 0) {
	    		chkYn = true;
	    	}
    	} else if (statusCd == "OF" || statusCd == "OB" || statusCd == "OL") {
	    	var settleAmt = form.clm_stl_locl_amt.value.trim();
	    	if (settleAmt == "") settleAmt = "0";

	    	if (parseFloat(ComReplaceStr(settleAmt,",","")) == 0) {
	    		chkYn = true;
	    	}
    	}
    	
    	return chkYn;
    }

    /**
     * Status에 따라 Case Close, Reopen, Cancel 버튼 활성화/비활성화 처리
     */
     function controlButtons() {

 		//Case Close, Reopen, Cancel 버튼 Disable
 		disableButtons()
         
        var statusCd = form.dw_clm_sts_cd.value;
 		
        if (statusCd == "CC") {
        	if (equalsRoleDwc("CNI32")||equalsRoleDwc("CNI33")||equalsRoleDwc("CNI93")){//all claim
	 	    	ComBtnEnable("btn1_Reopen");
	 			document.getElementById("btn1_Reopen").style.color="#cc3300";
        	}
        	else if (equalsRoleDwc("CNI31")){//his own claim
        		if (equalsHdlrIdDwc(form.hdlr_usr_id.value)){
        			ComBtnEnable("btn1_Reopen");
    	 			document.getElementById("btn1_Reopen").style.color="#cc3300";
        		}
        	}
        	else{//view
//        		for (i=0;i<arrBtn.length;i++) {
        			ComBtnDisable("btn1_Reopen");
//        		}
        	}
     	} 
     	if (statusCd != "CC" && statusCd != "XX") {
     		if (equalsRoleDwc("CNI32")||equalsRoleDwc("CNI33")||equalsRoleDwc("CNI93")){//all claim
	 	    	ComBtnEnable("btn1_Save");
	 		    ComBtnEnable("btn1_CaseClose");
	 			document.getElementById("btn1_CaseClose").style.color="#cc3300";
	 	    	ComBtnEnable("btn1_Cancel");
	 			document.getElementById("btn1_Cancel").style.color="#cc3300";
     		}else if (equalsRoleDwc("CNI31")){//his own claim
     			if (equalsHdlrIdDwc(form.hdlr_usr_id.value)){
     				ComBtnEnable("btn1_Save");
    	 		    ComBtnEnable("btn1_CaseClose");
    	 			document.getElementById("btn1_CaseClose").style.color="#cc3300";
    	 	    	ComBtnEnable("btn1_Cancel");
    	 			document.getElementById("btn1_Cancel").style.color="#cc3300";
     			}else{
     				ComBtnDisable("btn1_Save");//disableButtons 에서 Save 버튼은 처리하지 않아서 여기서 별도로 함.2010.03.12 양정란
     			}
     		}else{
     			ComBtnDisable("btn1_Save");
     		}
 			
     	} else {
 	    	ComBtnDisable("btn1_Save");
     	}
     }
     
// 권한적용전 백업    
//    function controlButtons() {
//
//		//Case Close, Reopen, Cancel 버튼 Disable
//		disableButtons()
//        
//        var statusCd = form.dw_clm_sts_cd.value;
//
//        if (statusCd == "CC") {
//	    	ComBtnEnable("btn1_Reopen");
//			document.getElementById("btn1_Reopen").style.color="#cc3300";
//    	} 
//    	if (statusCd != "CC" && statusCd != "XX") {
//	    	ComBtnEnable("btn1_Save");
//	    	
//	    	//Handler와 Login user가 같은 경우만 Case Close 가능
//	    	if (form.hdlr_usr_id.value == form.usr_id.value) {
//		    	ComBtnEnable("btn1_CaseClose");
//				document.getElementById("btn1_CaseClose").style.color="#cc3300";
//	    	}
//	    	ComBtnEnable("btn1_Cancel");
//			document.getElementById("btn1_Cancel").style.color="#cc3300";
//    	} else {
//	    	ComBtnDisable("btn1_Save");
//    	}
//    }

    /**
     * Party popup에서 선택시 Party Name을 세팅한다.
     */
    function setMainCodeInquiry(partyVo) {

        switch(popupType) {
            case "pop_clmt_clm_pty_nm":

				form.clmt_clm_pty_no.value = partyVo.clm_pty_no;
				form.clmt_clm_pty_nm.value = partyVo.pty_nm;
                break;
            case "pop_deft_clm_pty_nm":

				form.deft_clm_pty_no.value = partyVo.clm_pty_no;
				form.deft_clm_pty_nm.value = partyVo.pty_nm;    
                break;
            case "pop_labl_pty_clm_pty_nm":

				form.labl_pty_clm_pty_no.value = partyVo.clm_pty_no;
				form.labl_pty_clm_pty_nm.value = partyVo.pty_nm;    
                break;
            case "pop_insur_clm_pty_nm":

				form.insur_clm_pty_no.value = partyVo.clm_pty_no;
				form.insur_clm_pty_nm.value = partyVo.pty_nm;    
                break;
            case "pop_clmt_agn_clm_pty_no":

				form.clmt_agn_clm_pty_no.value = partyVo.clm_pty_no;
				form.clmt_agn_clm_pty_nm.value = partyVo.pty_nm;
				if (partyVo.intl_phn_no != "") {
					form.clmt_agn_tel_no.value = partyVo.intl_phn_no+"-"+partyVo.phn_no;
				} else {
					form.clmt_agn_tel_no.value = partyVo.phn_no;
				}    
				form.clmt_agn_email.value = partyVo.pty_eml;
                break;
            case "pop_deft_agn_clm_pty_no":

				form.deft_agn_clm_pty_no.value = partyVo.clm_pty_no;
				form.deft_agn_clm_pty_nm.value = partyVo.pty_nm;    
				if (partyVo.intl_phn_no != "") {
					form.deft_agn_tel_no.value = partyVo.intl_phn_no+"-"+partyVo.phn_no;
				} else {
					form.deft_agn_tel_no.value = partyVo.phn_no;
				}    
				form.deft_agn_email.value = partyVo.pty_eml;
                break;
        }         
    	
    }

    /**
     * R.O.E popup에서 선택시 Currency, Exchange Rate를 세팅한다.
     */
    function setCurrencyROE(xchRtVo) {

        switch(popupType) {
            case "pop_clm_xch_rt":
				form.clm_locl_curr_cd.value = xchRtVo.curr_cd;
				form.clm_xch_rt.value = xchRtVo.usd_locl_xch_rt;
				amount_change(form.clm_xch_rt);
                break;

            case "pop_clm_stl_xch_rt":
				form.clm_stl_locl_curr_cd.value = xchRtVo.curr_cd;
				form.clm_stl_xch_rt.value = xchRtVo.usd_locl_xch_rt;
				amount_change(form.clm_stl_xch_rt);
                break;

            case "pop_labl_pty_file_xch_rt":
				form.labl_pty_file_locl_curr_cd.value = xchRtVo.curr_cd;
				form.labl_pty_file_xch_rt.value = xchRtVo.usd_locl_xch_rt;
				amount_change(form.labl_pty_file_xch_rt);
                break;

            case "pop_labl_pty_rcvr_xch_rt":
				form.labl_pty_rcvr_locl_curr_cd.value = xchRtVo.curr_cd;
				form.labl_pty_rcvr_xch_rt.value = xchRtVo.usd_locl_xch_rt;
				amount_change(form.labl_pty_rcvr_xch_rt);
                break;

            case "pop_insur_file_xch_rt":
				form.insur_file_locl_curr_cd.value = xchRtVo.curr_cd;
				form.insur_file_xch_rt.value = xchRtVo.usd_locl_xch_rt;
				amount_change(form.insur_file_xch_rt);
                break;

            case "pop_insur_rcvr_xch_rt":
				form.insur_rcvr_locl_curr_cd.value = xchRtVo.curr_cd;
				form.insur_rcvr_xch_rt.value = xchRtVo.usd_locl_xch_rt;
				amount_change(form.insur_rcvr_xch_rt);
                break;

        }         
    	
    }

	/**
     * IBSheet에 업로드하고자 선택한 파일들을 IBUpload로 추가한다 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	prefix    	변수 구분값
     **/
	function setFileUpload(sheetObj, prefix) {
		//트랜잭션 상태가 "입력"인 행을 찾아 온다.
		var sRow = sheetObj.FindStatusRow("I");
		var upObj = uploadObjects[0];
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
	* 선택된 Item이 변경되었을 때 이벤트가 발생한다.
	* @param comboObj
	* @param index_cd
	* @param text
	* @return
	*/
	function combo_dw_clm_tp_cd_OnChange(comboObj, index_cd, text) {
		// 각 콤보 필드에 해당하는 hidden 필드에 값을 세팅해줌
		form.dw_clm_tp_cd.value = index_cd;
	}

	/**
	* 선택된 Item이 변경되었을 때 이벤트가 발생한다.
	* @param comboObj
	* @param index_cd
	* @param text
	* @return
	*/
	function combo_dw_co_cd_OnChange(comboObj, index_cd, text) {
		// 각 콤보 필드에 해당하는 hidden 필드에 값을 세팅해줌
		form.dw_co_cd.value = index_cd;
	}

	/**
	* 선택된 Item이 변경되었을 때 이벤트가 발생한다.
	* @param comboObj
	* @param index_cd
	* @param text
	* @return
	*/
	function combo_inci_plc_tp_cd_OnChange(comboObj, index_cd, text) {
		// 각 콤보 필드에 해당하는 hidden 필드에 값을 세팅해줌
		form.inci_plc_tp_cd.value = index_cd;
	}

	/**
	* 선택된 Item이 변경되었을 때 이벤트가 발생한다.
	* @param comboObj
	* @param index_cd
	* @param text
	* @return
	*/
	function combo_dw_clm_att_def_tp_cd_OnChange(comboObj, index_cd, text) {
		// 각 콤보 필드에 해당하는 hidden 필드에 값을 세팅해줌
		form.dw_clm_att_def_tp_cd.value = index_cd;
	}

	/**
	* 선택된 Item이 변경되었을 때 이벤트가 발생한다.
	* @param comboObj
	* @param index_cd
	* @param text
	* @return
	*/
	function combo_clmt_agn_tp_cd_OnChange(comboObj, index_cd, text) {
		// 각 콤보 필드에 해당하는 hidden 필드에 값을 세팅해줌
		form.clmt_agn_tp_cd.value = index_cd;
	}

	/**
	* 선택된 Item이 변경되었을 때 이벤트가 발생한다.
	* @param comboObj
	* @param index_cd
	* @param text
	* @return
	*/
	function combo_deft_agn_tp_cd_OnChange(comboObj, index_cd, text) {
		// 각 콤보 필드에 해당하는 hidden 필드에 값을 세팅해줌
		form.deft_agn_tp_cd.value = index_cd;
	}
	
	/**
     * 파일 선택하기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     **/
	function sheet1_OnPopupClick(sheetObj,Row,Col){
		var fileName = sheetObj.OpenFileDialog("Open File");
		
		if(fileName.indexOf("\\") !=-1) {
			sheetObj.CellValue2(Row, "file_file_path")= fileName;

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
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction, Col){

        with(formObj){

            if (sAction == IBSEARCH || (sAction == IBSAVE && Col != "Save")) {
                var objValue = formObj.dw_clm_no.value.trim();

                if (objValue == '') {
                	ComAlertFocus(formObj.dw_clm_no, ComGetMsg('CNI00003',"Case No."));
                	return false;
                }
            } else {//Main 화면 저장
   				if (!ComChkValid(formObj)) return false;
   				
				if (!chkAmount(form.clm_locl_amt, form.clm_locl_curr_cd, form.fmal_clm_rcv_dt, form.clm_xch_rt, "Claim Amount", "Date of Formal Claim")) return;
				if (!chkAmount(form.clm_stl_locl_amt, form.clm_stl_locl_curr_cd, form.clm_stl_dt, form.clm_stl_xch_rt, "Settled Amount", "Date of Settlement")) return;
				if (!chkAmount(form.labl_pty_file_locl_amt, form.labl_pty_file_locl_curr_cd, form.labl_pty_file_dt, form.labl_pty_file_xch_rt, "LP Claim Amount", "Date of LP Claim")) return;
				if (!chkAmount(form.labl_pty_rcvr_locl_amt, form.labl_pty_rcvr_locl_curr_cd, form.labl_pty_rcvr_dt, form.labl_pty_rcvr_xch_rt, "LP Recovered Amount", "Date of LP Recovery")) return;
				if (!chkAmount(form.insur_file_locl_amt, form.insur_file_locl_curr_cd, form.insur_file_dt, form.insur_file_xch_rt, "INS Claim Amount", "Date of INS Claim")) return;
				if (!chkAmount(form.insur_rcvr_locl_amt, form.insur_rcvr_locl_curr_cd, form.insur_rcvr_dt, form.insur_rcvr_xch_rt, "INS Recovered Amount", "Date of INS Recovery")) return;

            }
        }

        return true;
    }

    /**
     * 금액, 통화, 날짜, 환율이 하나라도 입력시 다른 세개의 필드도 모두 입력되었는지 체크
     */
    function chkAmount(objLoclAmt, objCurrCd, objInputDt, objXchRt, msg1, msg2) {
		
		var loclAmt = objLoclAmt.value.trim();
		var currCd = objCurrCd.value.trim();
		var inputDt = objInputDt.value.trim();
		var xchRt = objXchRt.value.trim();
		if (xchRt == "") xchRt = "0"; 
		
		if (ComIsNull(loclAmt) && ComIsNull(currCd) && ComIsNull(inputDt) && parseFloat(xchRt) == 0) {
			return true;
		} else if (!ComIsNull(loclAmt) && !ComIsNull(currCd) && !ComIsNull(inputDt) && parseFloat(xchRt) != 0) {
			return true;
		} else {
        	
        	if (ComIsNull(loclAmt)) {
		    	ComAlertFocus(objLoclAmt, ComGetMsg('CNI09028',msg1));
				return false;
	       	} else if (ComIsNull(currCd)) {
		    	ComAlertFocus(objCurrCd, ComGetMsg('CNI09028',msg1+"(Currency)"));
				return false;
	       	} else if (ComIsNull(inputDt)) {
		    	ComAlertFocus(objInputDt, ComGetMsg('CNI09028',msg2));
				return false;
	       	} else if (parseFloat(xchRt) == 0) {
		    	ComAlertFocus(objXchRt, ComGetMsg('CNI09028',msg1+"(R.O.E)"));
				return false;
        	} 
		
		}
		
		return true;
		
    }

    /**
     * 환율 팝업 클릭시 금액, 통화, 날짜 등 다른 세개의 필드도 모두 입력되었는지 체크
     */
    function chkFieldAmount(objLoclAmt, objCurrCd, objInputDt, msg1, msg2) {
		
		var loclAmt = objLoclAmt.value.trim();
		var currCd = objCurrCd.value.trim();
		var inputDt = objInputDt.value.trim();

    	if (ComIsNull(loclAmt)) {
	    	ComAlertFocus(objLoclAmt, ComGetMsg('CNI09028',msg1));
			return false;
       	} 
       	if (ComIsNull(currCd)) {
	    	ComAlertFocus(objCurrCd, ComGetMsg('CNI09028',msg1+"(Currency)"));
			return false;
       	} 
       	if (ComIsNull(inputDt)) {
	    	ComAlertFocus(objInputDt, ComGetMsg('CNI09028',msg2));
			return false;
    	} 
		
		return true;
		
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

	// 폼태그의 모든 컨트롤 데이타를 name[value] 포맷으로 가져오기
	function RD_FormQuery(form , no ) {
		if (typeof form != "object" || form.tagName != "FORM") {
			alert("FormQueryString함수의 인자는 FORM 태그가 아닙니다.");
			return "";
		}
	
		var name = new Array(form.elements.length);
		var value = new Array(form.elements.length);
		var j = 0;
		var plain_text="";
		
		//사용가능한 컨트롤을 배열로 생성한다.
		len = form.elements.length;
		for (var i = 0; i < len; i++) {
			//클래스 아이디로 제품을 구분함-아래는 HTMl제품
			if(form.elements[i].classid==undefined){
			
				switch (form.elements[i].type) {
					case "hidden":
						name[j] = form.elements[i].name;
						value[j] = form.elements[i].value;
						j++;
					break;	
					case "text":
						name[j] = form.elements[i].name;
						value[j] = form.elements[i].value;
						j++;
					break;
				}		
			}
		}
		
		//QueryString을 조합한다.
		for (var i = 0; i < j; i++) {
			if (name[i] != '') plain_text += "form" + no + "_" + name[i]+ "[" + value[i] + "] ";
		}
		
		//마지막에 &를 없애기 위함
		if (plain_text != "") plain_text = plain_text.substr(0, plain_text.length -1);
		
		return plain_text;
	}
    
	/* 개발자 작업  끝 */