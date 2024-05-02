/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0401.js
*@FileTitle  : Insurance Main 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23

=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   	/* 개발자 작업	*/
	// common global variables 
	var sheetObjects=new Array(); 
	var sheetCnt=0;
	var popupType;
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=0;
	var beforetab1=1;
	var beforetab2=1;
	var initload=true;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
		var sheetObject1=sheetObjects[0];
		/*******************************************************/
		var formObject=document.form;
		try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
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
					var cal=new ComCalendar();
					cal.setDisplayType('date');
					cal.select(eval("form."+srcName.substring(4)), 'yyyy-MM-dd');
                    break; 
               	case "pop_insur_clm_pty":
               	case "pop_ins_clm_pty":
               	case "pop_rins_clm_pty":
               	case "pop_cins_clm_pty":
               	case "pop_bro_clm_pty":
               	case "pop_insur_clm_pty_prm":
               		popupType=srcName;
					popupMainCodeInquiry();
                    break; 
               	case "btn_insur_ctnt":
					if(!validateForm(sheetObject1,formObject,IBSEARCH)) return;
					var pop_param="&insur_plcy_yr="+formObject.insur_plcy_yr.value+"&pop_cont_col="+srcName.substring(4) + "&pop_title=Insurer";
               		var insurTpNm=formObject.insur_tp_cd.options[formObject.insur_tp_cd.selectedIndex].text;
					formObject.insur_tp_nm.value=insurTpNm;
					formObject.pop_desc.value=formObject.insur_clm_pty_nm.value;
					ComPostOpenWindow("/opuscntr/CPS_CNI_0402.do?"+pop_param, 'CPS_CNI_0402', 'width=1000,height=637');
                    break; 
               	case "btn_ins_ctnt":
					if(!validateForm(sheetObject1,formObject,IBSEARCH)) return;
					var pop_param="&insur_plcy_yr="+formObject.insur_plcy_yr.value+"&pop_cont_col="+srcName.substring(4) + "&pop_title=Insured";
               		var insurTpNm=formObject.insur_tp_cd.options[formObject.insur_tp_cd.selectedIndex].text;
					formObject.insur_tp_nm.value=insurTpNm;
					formObject.pop_desc.value=formObject.ins_clm_pty_nm.value;
					ComPostOpenWindow("/opuscntr/CPS_CNI_0402.do?"+pop_param, 'CPS_CNI_0402', 'width=1000,height=637');
                    break; 
               	case "btn_rins_ctnt":
					if(!validateForm(sheetObject1,formObject,IBSEARCH)) return;
					var pop_param="&insur_plcy_yr="+formObject.insur_plcy_yr.value+"&pop_cont_col="+srcName.substring(4) + "&pop_title=Reinsurer";
               		var insurTpNm=formObject.insur_tp_cd.options[formObject.insur_tp_cd.selectedIndex].text;
					formObject.insur_tp_nm.value=insurTpNm;
					formObject.pop_desc.value=formObject.rins_clm_pty_nm.value;
					ComPostOpenWindow("/opuscntr/CPS_CNI_0402.do?"+pop_param, 'CPS_CNI_0402', 'width=1000,height=637');
                    break; 
               	case "btn_cins_ctnt":
					if(!validateForm(sheetObject1,formObject,IBSEARCH)) return;
					var pop_param="&insur_plcy_yr="+formObject.insur_plcy_yr.value+"&pop_cont_col="+srcName.substring(4) + "&pop_title=Co-Insured";
               		var insurTpNm=formObject.insur_tp_cd.options[formObject.insur_tp_cd.selectedIndex].text;
					formObject.insur_tp_nm.value=insurTpNm;
					formObject.pop_desc.value=formObject.cins_clm_pty_nm.value;
					ComPostOpenWindow("/opuscntr/CPS_CNI_0402.do?"+pop_param, 'CPS_CNI_0402', 'width=1000,height=637');
                    break; 
               	case "btn_int_desc":
					if(!validateForm(sheetObject1,formObject,IBSEARCH)) return;
					var pop_param="&insur_plcy_yr="+formObject.insur_plcy_yr.value+"&pop_cont_col="+srcName.substring(4) + "&pop_title=Interest";
               		var insurTpNm=formObject.insur_tp_cd.options[formObject.insur_tp_cd.selectedIndex].text;
					formObject.insur_tp_nm.value=insurTpNm;
					eval("form."+srcName.substring(4)).value=eval("form."+srcName.substring(4)+"_nm").value;
					formObject.pop_desc.value='';
					ComPostOpenWindow("/opuscntr/CPS_CNI_0406.do?"+pop_param, 'CPS_CNI_0406', 'width=1000,height=617');
                    break; 
               	case "btn_subj_mat_ins_desc":
					if(!validateForm(sheetObject1,formObject,IBSEARCH)) return;
					var pop_param="&insur_plcy_yr="+formObject.insur_plcy_yr.value+"&pop_cont_col="+srcName.substring(4) + "&pop_title=Subject Matter Insured";
               		var insurTpNm=formObject.insur_tp_cd.options[formObject.insur_tp_cd.selectedIndex].text;
					formObject.insur_tp_nm.value=insurTpNm;
					eval("form."+srcName.substring(4)).value=eval("form."+srcName.substring(4)+"_nm").value;
					formObject.pop_desc.value='';
					ComPostOpenWindow("/opuscntr/CPS_CNI_0406.do?"+pop_param, 'CPS_CNI_0406', 'width=1000,height=617');
                    break; 
               	case "pop_ins_curr_cd":
					ComOpenPopupWithTarget("COM_ENS_N13.do?classId=COM_ENS_N13&curr_cd=&cnt_cd=&curr_desc=", 700, 450, "curr_cd:"+srcName.substring(4), "1,0,1,1,1", true);
                    break; 
               	case "pop_lmt_ins_curr_cd":
					ComOpenPopupWithTarget("COM_ENS_N13.do?classId=COM_ENS_N13&curr_cd=&cnt_cd=&curr_desc=", 700, 450, "curr_cd:"+srcName.substring(4), "1,0,1,1,1", true);
                    break; 
               	case "pop_ttl_curr_cd":
					ComOpenPopupWithTarget("COM_ENS_N13.do?classId=COM_ENS_N13&curr_cd=&cnt_cd=&curr_desc=", 700, 450, "curr_cd:"+srcName.substring(4), "1,0,1,1,1", true);
                    break; 
               	case "pop_ins_xch_rt":
					//환율 팝업 클릭시 금액, 통화 등 연관 필드도 모두 입력되었는지 체크
					if (!chkFieldAmount(eval("form."+srcName.substring(4,8)+"locl_amt"), eval("form."+srcName.substring(4,8)+"curr_cd"), "Amount Insured")) return;
               		popupType=srcName;
               		var currCd=eval("form."+srcName.substring(4,8)+"curr_cd").value;
					popupRateOfExchange(currCd, "");
                    break; 
               	case "pop_lmt_ins_xch_rt":
					//환율 팝업 클릭시 금액, 통화 등 연관 필드도 모두 입력되었는지 체크
					if (!chkFieldAmount(eval("form."+srcName.substring(4,12)+"locl_amt"), eval("form."+srcName.substring(4,12)+"curr_cd"), "Limit")) return;
               		popupType=srcName;
               		var currCd=eval("form."+srcName.substring(4,12)+"curr_cd").value;
					popupRateOfExchange(currCd, "");
                    break; 
               	case "pop_ttl_xch_rt":
               	case "pop_adj_xch_rt":
               	case "pop_rfnd_xch_rt":
               	case "pop_ots_xch_rt":
               		popupType=srcName;
					//환율 팝업 클릭시 금액, 통화 등 연관 필드도 모두 입력되었는지 체크
					if (!chkFieldAmount(eval("form."+ComReplaceStr(ComReplaceStr(srcName, "pop_"), "xch_rt")+"locl_amt"), eval("form.ttl_curr_cd"))) return;
               		var currCd=eval("form.ttl_curr_cd").value;
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
               		popupType=srcName;
					//환율 팝업 클릭시 금액, 통화 등 연관 필드도 모두 입력되었는지 체크
					if (!chkFieldAmount(eval("form.inst_locl_amt"+ComReplaceStr(srcName, "pop_inst_xch_rt")), eval("form.ttl_curr_cd"))) return;
               		var currCd=eval("form.ttl_curr_cd").value;
					popupRateOfExchange(currCd, "");
                    break; 
                case "btn1_Retrieve":
//                	if (beforetab == 0) {//Insurance
		             	if(!CoCniInitConfirm(sheetObjects[0])) return;
		             	if(!CoCniInitConfirm(sheetObjects[1])) return;
		             	if(!CoCniInitConfirm(sheetObjects[2])) return;
		             	if(!CoCniInitConfirm(sheetObjects[3])) return;
		             	if(!CoCniInitConfirm(sheetObjects[4])) return;
		             	if(!CoCniInitConfirm(sheetObjects[5])) return;
		             	if(!CoCniInitConfirm(sheetObjects[6])) return;
		             	if(!CoCniInitConfirm(sheetObjects[7])) return;
//                	} else {//Premium
		             	if(!CoCniInitConfirm(sheetObjects[10])) return;
		             	if(!CoCniInitConfirm(sheetObjects[8])) return;
		             	if(!CoCniInitConfirm(sheetObjects[9])) return;
//                	}
	             	doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
                case "btn1_New":
//                	if (beforetab == 0) {//Insurance
		             	if(!CoCniInitConfirm(sheetObjects[0])) return;
		             	if(!CoCniInitConfirm(sheetObjects[1])) return;
		             	if(!CoCniInitConfirm(sheetObjects[2])) return;
		             	if(!CoCniInitConfirm(sheetObjects[3])) return;
		             	if(!CoCniInitConfirm(sheetObjects[4])) return;
		             	if(!CoCniInitConfirm(sheetObjects[5])) return;
		             	if(!CoCniInitConfirm(sheetObjects[6])) return;
		             	if(!CoCniInitConfirm(sheetObjects[7])) return;
						ComResetAll();
						resetHiddenField(formObject);
//                	} else {//Premium
		             	if(!CoCniInitConfirm(sheetObjects[10])) return;
		             	if(!CoCniInitConfirm(sheetObjects[8])) return;
		             	if(!CoCniInitConfirm(sheetObjects[9])) return;
		             	
		             	for(var i=0; i < sheetObjects.length; i++){
		             		sheetObjects[i].RemoveAll();
		             	}
			            //Premium Tab만 initializing
			            clearPremium();
//                	}
	   				//검색 조건 필드 제어
	   				inputReadOnly("New");
                    break; 
                case "btn1_Save":
					doActionIBSheet(sheetObject1,formObject,IBSAVE, "Save");
                    break;
                case "btn1_Delete":
                	var vMsg="";
                	if (beforetab == 0) {//Insurance
                		vMsg="Insurance Main";
                	} else {//Premium
                		vMsg="Premium";
                	}
                	if (confirm(ComGetMsg("COM12165", vMsg))) {
						doActionIBSheet(sheetObject1,formObject,IBSAVE, "Delete");
                	}
                    break;
                case "btn2_Row_Add":
                	var tabIndex=1;
                	if (beforetab == 0) {//Insurance
	                	sheetObject1=sheetObjects[beforetab1-1]
	                	tabIndex=beforetab1;
                	} else {//Premium
	                	sheetObject1=sheetObjects[8+beforetab2-1]
	                	tabIndex=8+beforetab2;
                	}
	          		if(!validateForm(sheetObject1,formObject,IBSAVE)) return;
					var row=sheetObject1.DataInsert(-1);
					var prefix="file_";
					sheetObject1.SetCellValue(row, prefix+"clm_file_tp_cd","0401"+ComLpad(tabIndex,2,"0"));
					sheetObject1.SetCellValue(row, prefix+"clm_bztp_cd","I");
                	if (beforetab == 0) {//Insurance 
						sheetObject1.SetCellValue(row, prefix+"insur_tp_cd",insur_tp_cd.value);
						sheetObject1.SetCellValue(row, prefix+"insur_plcy_yr",formObject.insur_plcy_yr.value);
                	} else {
						sheetObject1.SetCellValue(row, prefix+"inst_insur_tp_cd",insur_tp_cd.value);
						sheetObject1.SetCellValue(row, prefix+"inst_insur_plcy_yr",formObject.insur_plcy_yr.value);
						sheetObject1.SetCellValue(row, prefix+"inst_prm_insur_tp_cd",formObject.insur_prm_tp_cd.value);
                	}
					sheetObject1.SetCellValue(row, prefix+"insur_clm_pty_no",formObject.insur_clm_pty_no.value);
					break;
                case "btn2_Row_Insert":
                	var tabIndex=1;
                	if (beforetab == 0) {
	                	sheetObject1=sheetObjects[beforetab1-1]
	                	tabIndex=beforetab1;
                	} else {//Premium
	                	sheetObject1=sheetObjects[8+beforetab2-1]
	                	tabIndex=8+beforetab2;
                	}
	          		if(!validateForm(sheetObject1,formObject,IBSAVE)) return;
					var row=sheetObject1.DataInsert();
					var prefix="file_";
					sheetObject1.SetCellValue(row, prefix+"clm_file_tp_cd","0401"+ComLpad(tabIndex,2,"0"));
					sheetObject1.SetCellValue(row, prefix+"clm_bztp_cd","I");
                	if (beforetab == 0) {//Insurance
						sheetObject1.SetCellValue(row, prefix+"insur_tp_cd",insur_tp_cd.value);
						sheetObject1.SetCellValue(row, prefix+"insur_plcy_yr",formObject.insur_plcy_yr.value);
                	} else {//Premium
						sheetObject1.SetCellValue(row, prefix+"inst_insur_tp_cd",insur_tp_cd.value);
						sheetObject1.SetCellValue(row, prefix+"inst_insur_plcy_yr",formObject.insur_plcy_yr.value);
						sheetObject1.SetCellValue(row, prefix+"inst_prm_insur_tp_cd",formObject.insur_prm_tp_cd.value);
                	}
					sheetObject1.SetCellValue(row, prefix+"insur_clm_pty_no",formObject.insur_clm_pty_no.value);
                    break; 
                case "btn2_Row_Delete":
                	if (beforetab == 0) {
	                	sheetObject1=sheetObjects[beforetab1-1]
                	} else {
	                	sheetObject1=sheetObjects[8+beforetab2-1]
                	}
					if(ComCniCheckBoxCheckYn(sheetObject1, "file_DelChk")) { 
						ComRowHideDelete(sheetObject1, "file_DelChk"); 
					}
                    break;
                case "btn2_Save":
                	if (beforetab == 0) {
	                	sheetObject1=sheetObjects[beforetab1-1]
                	} else {
	                	sheetObject1=sheetObjects[8+beforetab2-1]
                	}
					doActionIBSheet(sheetObject1,formObject,IBSAVE,'FILE');
                    break; 
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			alert("An unknown error occurred(in JavaScript source). Please verify your entry and try again. If the problem persists, please contact your system administrator.");
    		} else {
    			ComShowMessage(e.message);
    		}
    	}
    }
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;	
    }
	/**
	* registering IBTab Object as list 
 	* adding process for list in case of needing batch processing with other items
 	* defining list on the top of source
	*/
	function setTabObject(tab_obj){
		tabObjects[tabCnt++]=tab_obj;
	}
//    /**
//     * 페이지에 생성된 IBUpload Object를 uploadObjects 배열에 등록한다. <br>
//     * @param {ibupload} uploadObj    IBUpload Object
//     **/
//	function setUploadObject(uploadObj) {
//		uploadObjects[uploadCnt++]=uploadObj;
//	}
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
        for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1);
		}
        for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        initUpload();
        //html컨트롤 이벤트initializing
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
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 initializing 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl() {
        //Axon 이벤트 처리1. 이벤트catch
    	axon_event.addListenerForm  ('blur'	, 'obj_deactivate', form); 							//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
//        axon_event.addListenerFormat('keypress'        	, 'obj_keypress'  , form); 				//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
//    	axon_event.addListenerFormat('beforeactivate'	, 'obj_activate'  , form);
//        axon_event.addListener  ('keypress', 'obj_keypress' , form);							//- form 전체 컨트롤 중 keypress 이벤트 발생시
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
 		obj=ComGetEvent();
 		if (obj.getAttribute("readOnly")) return;
 		ComClearSeparator(obj);
 	} 
    /**
     * checking validation
     **/
    function obj_deactivate(){
        //입력Validation 확인하기
    	switch(ComGetEvent("name")){
			case "insur_plcy_yr":
				//숫자이면서 천단위 구분을 하지 않는다.
				ComChkObjValid(ComGetEvent(), true, false, false);
				break;
			default:
				ComChkObjValid(ComGetEvent());
    	}
    }
    /**
     * only numbers
     **/
//    function obj_keypress(){
//    	switch(event.srcElement.dataformat){
//	        case "engup":
//	            ComKeyOnlyAlphabet('uppernum');
//	            break;
//			case "float":
//		        //숫자+"."입력하기
//		        ComKeyOnlyNumber(event.srcElement, ".");
//				break;
//			case "ymd":
//		        //only numbers
//		        ComKeyOnlyNumber(event.srcElement);
//				break;
//	        case "eng":
//	        	if (event.keyCode > 0) event.returnValue=false;;
//	            break;
//			default:
//		        //only numbers
//		        ComKeyOnlyNumber(event.srcElement);
//    	}
//    }
    /**
     * Party name 삭제시 party no 삭제. <br>
     **/
    function party_change() {
    	var obj=ComGetEvent();
    	if (obj.value == "") {
			eval("form."+obj.name.substring(0,obj.name.length-1)+"o").value='';
    	}
    }
    /**
     * Party name 클릭시 party no 팝업 오픈. <br>
     **/
    function party_open() {
    	var obj=ComGetEvent();
    	if (obj.value == "") {
       		popupType="pop_"+obj.name.substring(0,obj.name.length-3);
			popupMainCodeInquiry();
    	}
    }
    /**
     * Policy Year 입력시 자동조회. <br>
     **/
    function obj_keyup() {
    	var keyValue=event.keyCode;
    	//대문자와 숫자인 경우만 실행
    	if ((keyValue >= 48 && keyValue <= 57) || (keyValue >= 96 && keyValue <= 105)) {
        	if (event.srcElement.value.trim().length == 4) {
//            	eval("document.tab1").selectedIndex=0;
            	tab1.SetSelectedIndex(0);

               	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
               	formObj = document.form;
    			if (formObj.insur_clm_pty_prm_no.value == "") {
    				formObj.insur_clm_pty_prm_no.value=formObj.insur_clm_pty_no.value;
    				formObj.insur_clm_pty_prm_nm.value=formObj.insur_clm_pty_nm.value;
    			}
        	} 
    	}
    }
    /**
     * Premium 변경후 자동 조회하기. <br>
     **/
    function premium_change() {
		var obj=document.getElementById("btn_Retrieve");
		if (obj) ComFireEvent(obj , "click")
    }
    /**
     * Currency 입력시 입력된 정보 체크한다. <br>
     **/
    function currency_change() {
    	var obj=ComGetEvent();
    	if (obj.value != "" && obj.value.trim().length == 3) {
    		if (obj.value == "USD") {//USD인 경우 환율에 1로 세팅하고 금액은 local amt랑 똑같게 세팅
    			var objname=ComReplaceStr(obj.name, "curr_cd", "");
    			eval("document.form."+objname+"xch_rt").value="1.00000";
    			//Premium tab의 Total currency인 경우
    			if (obj.name == "ttl_curr_cd") {
    				if (form.adj_locl_amt.value.trim() != "" && parseFloat(form.adj_locl_amt.value.trim()) != 0) {
    					form.adj_xch_rt.value="1.00000";
		    			amount_change(form.adj_locl_amt);
    				}
    				if (form.rfnd_locl_amt.value.trim() != "" && parseFloat(form.rfnd_locl_amt.value.trim()) != 0) {
    					form.rfnd_xch_rt.value="1.00000";
		    			amount_change(form.rfnd_locl_amt);
    				}
    				if (form.ots_locl_amt.value.trim() != "" && parseFloat(form.ots_locl_amt.value.trim()) != 0) {
    					form.ots_xch_rt.value="1.00000";
		    			amount_change(form.ots_locl_amt);
    				}
    				for (var ii=1; ii<11; ii++) {
    					var objInst=eval("form.inst_locl_amt_"+ii);
	    				if (objInst.value.trim() != "" && parseFloat(objInst.value.trim()) != 0) {
	    					eval("form.inst_xch_rt_"+ii).value="1.00000";
			    			amount_change(objInst);
	    				}
    				}
    			} 
    			amount_change(obj);
    		} else {
				doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, obj.name);
			}	
    	} else if (obj.value.trim() == "") {
    		//환율, USD Amount를 initializing함
    		changeCurrency(obj);
    	}	
    }
    /**
     * 통화, 환율, 금액 입력 후 USD 금액 세팅하기. <br>
     **/
    function changeCurrency(obj) {
		var objname=ComReplaceStr(obj.name, "curr_cd", "");
		eval("document.form."+objname+"xch_rt").value="";
		eval("document.form."+objname+"usd_amt").value="";
		//Premium tab의 Total currency인 경우
		if (obj.name == "ttl_curr_cd") {
			form.adj_xch_rt.value="";
			form.adj_usd_amt.value="";
			form.rfnd_xch_rt.value="";
			form.rfnd_usd_amt.value="";
			form.ots_xch_rt.value="";
			form.ots_usd_amt.value="";
			for (var ii=1; ii<11; ii++) {
				eval("form.inst_xch_rt_"+ii).value="";
				eval("form.inst_usd_amt_"+ii).value="";
			}
		} 
   	}
    /**
     * 통화, 환율, 금액 입력 후 USD 금액 세팅하기. <br>
     **/
    function amount_change(obj) {
    	if (obj.name == undefined || obj == null) {
    		obj=ComGetEvent();
    	}
    	var objloclamt=eval("form."+replaceStrWith(replaceStrWith(replaceStrWith(obj.name, "xch_rt", "locl_amt"), "curr_cd", "locl_amt"), "usd_amt", "locl_amt"));
    	var objrt=eval("form."+replaceStrWith(replaceStrWith(replaceStrWith(obj.name, "locl_amt", "xch_rt"), "curr_cd", "xch_rt"), "usd_amt", "xch_rt"));
    	var objusdamt=eval("form."+replaceStrWith(replaceStrWith(replaceStrWith(obj.name, "xch_rt", "usd_amt"), "curr_cd", "usd_amt"), "locl_amt", "usd_amt"));
    	//local 금액에 대해 USD 금액 계산하기
		var valLoclAmt=objloclamt.value.trim();
		var valXchRt=objrt.value.trim();
		if (valLoclAmt != "" && valXchRt != "") {
			objloclamt.value=ComAddComma2(ComReplaceStr(valLoclAmt,",",""),"#,###.00");
			var usdAmt=parseFloat(ComReplaceStr(objloclamt.value,",",""))/parseFloat(ComReplaceStr(objrt.value,",",""));
			usdAmt=usdAmt.toFixed(2) + "";
			objusdamt.value=ComAddComma2(usdAmt,"#,###.00");
		} else if (valLoclAmt != "" && valXchRt == "") {
            //Premium에서 total amount필드가 아닌 경우 금액 입력시 Currency가 USD인 경우 환율을 1로 자동입력한다.
			if (beforetab == 1 && obj.name != "ttl_locl_amt") {
				var currCd=form.ttl_curr_cd.value;
				if (currCd == 'USD') {
					objloclamt.value=ComAddComma2(ComReplaceStr(valLoclAmt,",",""),"#,###.00");
					objrt.value="1.00000";
					objusdamt.value=ComAddComma2(ComReplaceStr(valLoclAmt,",",""),"#,###.00");
				}
			}
		} else {
			objusdamt.value="";
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
            var varLen=sVal.length;
            var sFindLen=sFind.length;
            var sReturn=sVal;
            for (var ii=0; ii<varLen; ii++) {
            	if (sVal.substring(ii, ii+sFindLen) == sFind) {
					sReturn=sVal.substring(0, ii)+sReplace+sVal.substring(ii+sFindLen);            		
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
			    var cnt=0 ;
				InsertItem( "Main Terms" , "");
				InsertItem( "Premium" , "");
			}
			tabObj.SetSelectedIndex(0);
			break;
			case 2:
			with (tabObj) {
			    var cnt=0 ;
				InsertItem( "Main Terms Remark" , "");
				InsertItem( "Terms’ Detail" , "");
				InsertItem( "Loss Record" , "");
				InsertItem( "Renewal Strategy" , "");
				InsertItem( "Renewal Target" , "");
				InsertItem( "Initial Offer" , "");
				InsertItem( "Renewal Negotiation" , "");
				InsertItem( "Policy" , "");
				InsertItem( "Renewal Approval" , "");
			}
			tabObj.SetSelectedIndex(0);
			break;
			case 3:
			with (tabObj) {
			    var cnt=0 ;
				InsertItem( "Premium Remark", "");
				InsertItem( "Premium Detail" , "");
				InsertItem( "Debit Note" , "");
			}
			tabObj.SetSelectedIndex(0);
			break;
		}
	}
	/**
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	*/
	function tab1_OnChange(tabObj , nItem){
		formObject = document.form;
        var objs=document.all.item("tabLayer");
        objs[nItem].style.display="Inline";
        for(var i = 0; i< objs.length; i++){
          if(i != nItem){
            objs[i].style.display="none";
            objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
          }
       }
        if(nItem == 1 && initload){
    		tabObjects[1].SetVisible(1);
//    		tabObjects[1].SetSelectedIndex(1);
//    		tabObjects[1].SetSelectedIndex(2);
    		tabObjects[1].SetSelectedIndex(0);
    		initload=false;
        }
		//Tab Click시 Insurer 정보가 없는 경우 다른 Tab에 있는 Insurer 정보를 넣어줌
        var formObj=document.form;
        if (beforetab == 0) {//Main Terms
			if (formObj.insur_clm_pty_no.value == "") {
				formObj.insur_clm_pty_no.value=formObj.insur_clm_pty_prm_no.value;
				formObj.insur_clm_pty_nm.value=formObj.insur_clm_pty_prm_nm.value;
			}
		} else {//Premium
			if (formObj.insur_clm_pty_prm_no.value == "") {
				formObj.insur_clm_pty_prm_no.value=formObj.insur_clm_pty_no.value;
				formObj.insur_clm_pty_prm_nm.value=formObj.insur_clm_pty_nm.value;
			}
		}
        beforetab=nItem;
	}
	/**
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	*/
	function tab2_OnChange(tabObj , nItem){
        formObject = document.form;
        var objs=document.all.item("tabLayer1");
        objs[nItem].style.display="Inline";
        for(var i = 0; i< objs.length; i++){
          if(i != nItem){
            objs[i].style.display="none";
            objs[beforetab1].style.zIndex=objs[nItem].style.zIndex - 1 ;
          }
       }
       beforetab1=nItem;
	}
	/**
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	*/
	function tab3_OnChange(tabObj , nItem){
		formObject = document.form;
        var objs=document.all.item("tabLayer3");
        objs[nItem].style.display="Inline";
        for(var i = 0; i< objs.length; i++){
          if(i != nItem){
            objs[i].style.display="none";
            objs[beforetab2].style.zIndex=objs[nItem].style.zIndex - 1 ;
          }
       }
       beforetab2=nItem;
	}
  /**
     * setting sheet initial values and header
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetObj.id) {
            case "sheet1":      //sheet1 init
                with (sheetObj) {
	                var prefix="file_";
	                var HeadTitle1="|Sel.|Seq.|File Name|Contents|ID|Date|File Download|||||||||";
	                var headCount=ComCountHeadTitle(HeadTitle1);
	
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	                       {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"DelChk" },
	                       {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"Seq" },
	                       {Type:"Popup",     Hidden:0, Width:300,  Align:"Left",    ColMerge:0,   SaveName:prefix+"file_nm",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:200 },
	                       {Type:"Text",      Hidden:0,  Width:340,  Align:"Left",    ColMerge:0,   SaveName:prefix+"file_desc",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
	                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"upd_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"upd_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Image",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"file_download",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"clm_file_seq" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"clm_file_tp_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"clm_bztp_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"dw_clm_no" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"insur_tp_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"insur_plcy_yr" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"insur_clm_pty_no" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"inst_insur_tp_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"inst_insur_plcy_yr" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"inst_prm_insur_tp_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"file_path" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"file_sav_id" } ];
	                 
	                InitColumns(cols);

                	SetEditable(1);
                	SetImageList(0,"/opuscntr/img/ico_attach.gif");
                    SetDataLinkMouse(prefix + "file_download",1);
                    SetShowButtonImage(1);
	                SetSheetHeight(200);
				}
				break;
            case "sheet2":      //sheet1 init
                with (sheetObj) {
	                var prefix="file_";
	                var HeadTitle1="|Sel.|Seq.|File Name|Contents|ID|Date|File Download|||||||||";
	                var headCount=ComCountHeadTitle(HeadTitle1);
	
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	                       {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"DelChk" },
	                       {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"Seq" },
	                       {Type:"Popup",     Hidden:0, Width:300,  Align:"Left",    ColMerge:0,   SaveName:prefix+"file_nm",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:200 },
	                       {Type:"Text",      Hidden:0,  Width:340,  Align:"Left",    ColMerge:0,   SaveName:prefix+"file_desc",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
	                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"upd_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"upd_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Image",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"file_download",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"clm_file_seq" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"clm_file_tp_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"clm_bztp_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"dw_clm_no" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"insur_tp_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"insur_plcy_yr" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"insur_clm_pty_no" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"inst_insur_tp_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"inst_insur_plcy_yr" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"inst_prm_insur_tp_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"file_path" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"file_sav_id" } ];
	                 
	                InitColumns(cols);
	
	                SetEditable(1);
	                SetImageList(0,"/opuscntr/img/ico_attach.gif");
	                SetDataLinkMouse(prefix + "file_download",1);
	                SetShowButtonImage(1);
	                SetSheetHeight(200);
				}
				break;
            case "sheet3":      //sheet1 init
                with (sheetObj) {
	                var prefix="file_";
	                var HeadTitle1="|Sel.|Seq.|File Name|Contents|ID|Date|File Download|||||||||";
	                var headCount=ComCountHeadTitle(HeadTitle1);
	
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	                       {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"DelChk" },
	                       {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"Seq" },
	                       {Type:"Popup",     Hidden:0, Width:300,  Align:"Left",    ColMerge:0,   SaveName:prefix+"file_nm",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:200 },
	                       {Type:"Text",      Hidden:0,  Width:340,  Align:"Left",    ColMerge:0,   SaveName:prefix+"file_desc",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
	                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"upd_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"upd_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Image",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"file_download",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"clm_file_seq" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"clm_file_tp_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"clm_bztp_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"dw_clm_no" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"insur_tp_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"insur_plcy_yr" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"insur_clm_pty_no" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"inst_insur_tp_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"inst_insur_plcy_yr" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"inst_prm_insur_tp_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"file_path" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"file_sav_id" } ];
	                 
	                InitColumns(cols);
	
	                					SetEditable(1);
	                SetImageList(0,"/opuscntr/img/ico_attach.gif");
	                SetDataLinkMouse(prefix + "file_download",1);
	                SetShowButtonImage(1);
	                SetSheetHeight(200);
				}
		        break;
            case "sheet4":      //sheet1 init
                with (sheetObj) {
	                var prefix="file_";
	                var HeadTitle1="|Sel.|Seq.|File Name|Contents|ID|Date|File Download|||||||||";
	                var headCount=ComCountHeadTitle(HeadTitle1);
	
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	                       {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"DelChk" },
	                       {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"Seq" },
	                       {Type:"Popup",     Hidden:0, Width:300,  Align:"Left",    ColMerge:0,   SaveName:prefix+"file_nm",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:200 },
	                       {Type:"Text",      Hidden:0,  Width:340,  Align:"Left",    ColMerge:0,   SaveName:prefix+"file_desc",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
	                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"upd_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"upd_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Image",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"file_download",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"clm_file_seq" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"clm_file_tp_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"clm_bztp_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"dw_clm_no" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"insur_tp_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"insur_plcy_yr" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"insur_clm_pty_no" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"inst_insur_tp_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"inst_insur_plcy_yr" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"inst_prm_insur_tp_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"file_path" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"file_sav_id" } ];
	                 
	                InitColumns(cols);
	
					SetEditable(1);
	                SetImageList(0,"/opuscntr/img/ico_attach.gif");
	                SetDataLinkMouse(prefix + "file_download",1);
	                SetShowButtonImage(1);
		            SetSheetHeight(200);
		          }
		          break;
            case "sheet5":      //sheet1 init
                with (sheetObj) {
		                var prefix="file_";
		                var HeadTitle1="|Sel.|Seq.|File Name|Contents|ID|Date|File Download|||||||||";
		                var headCount=ComCountHeadTitle(HeadTitle1);
		
		                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		                InitHeaders(headers, info);
		
		                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		                       {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"DelChk" },
		                       {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"Seq" },
		                       {Type:"Popup",     Hidden:0, Width:300,  Align:"Left",    ColMerge:0,   SaveName:prefix+"file_nm",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:200 },
		                       {Type:"Text",      Hidden:0,  Width:340,  Align:"Left",    ColMerge:0,   SaveName:prefix+"file_desc",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
		                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"upd_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"upd_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Image",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"file_download",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"clm_file_seq" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"clm_file_tp_cd" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"clm_bztp_cd" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"dw_clm_no" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"insur_tp_cd" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"insur_plcy_yr" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"insur_clm_pty_no" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"inst_insur_tp_cd" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"inst_insur_plcy_yr" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"inst_prm_insur_tp_cd" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"file_path" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"file_sav_id" } ];
		                 
		                InitColumns(cols);
		
						SetEditable(1);
		                SetImageList(0,"/opuscntr/img/ico_attach.gif");
		                SetDataLinkMouse(prefix + "file_download",1);
		                SetShowButtonImage(1);
		                SetSheetHeight(200);
		          }
		          break;
            case "sheet6":      //sheet1 init
                with (sheetObj) {
		                var prefix="file_";
		                var HeadTitle1="|Sel.|Seq.|File Name|Contents|ID|Date|File Download||||||||";
		                var headCount=ComCountHeadTitle(HeadTitle1);
		
		                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		                InitHeaders(headers, info);
		
		                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		                       {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"DelChk" },
		                       {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"Seq" },
		                       {Type:"Popup",     Hidden:0, Width:300,  Align:"Left",    ColMerge:0,   SaveName:prefix+"file_nm",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:200 },
		                       {Type:"Text",      Hidden:0,  Width:340,  Align:"Left",    ColMerge:0,   SaveName:prefix+"file_desc",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
		                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"upd_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"upd_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Image",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"file_download",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"clm_file_seq" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"clm_file_tp_cd" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"clm_bztp_cd" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"dw_clm_no" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"insur_tp_cd" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"insur_plcy_yr" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"insur_clm_pty_no" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"inst_insur_tp_cd" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"inst_insur_plcy_yr" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"inst_prm_insur_tp_cd" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"file_path" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"file_sav_id" } ];
		                 
		                InitColumns(cols);
		
		                					SetEditable(1);
		                SetImageList(0,"/opuscntr/img/ico_attach.gif");
		                SetDataLinkMouse(prefix + "file_download",1);
		                SetShowButtonImage(1);
		                SetSheetHeight(200);
		          }
		          break;
            case "sheet7":      //sheet1 init
                with (sheetObj) {
	                var prefix="file_";
	                var HeadTitle1="|Sel.|Seq.|File Name|Contents|ID|Date|File Download||||||||";
	                var headCount=ComCountHeadTitle(HeadTitle1);
	
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	                       {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"DelChk" },
	                       {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"Seq" },
	                       {Type:"Popup",     Hidden:0, Width:300,  Align:"Left",    ColMerge:0,   SaveName:prefix+"file_nm",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:200 },
	                       {Type:"Text",      Hidden:0,  Width:340,  Align:"Left",    ColMerge:0,   SaveName:prefix+"file_desc",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
	                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"upd_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"upd_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Image",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"file_download",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"clm_file_seq" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"clm_file_tp_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"clm_bztp_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"dw_clm_no" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"insur_tp_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"insur_plcy_yr" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"insur_clm_pty_no" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"inst_insur_tp_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"inst_insur_plcy_yr" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"inst_prm_insur_tp_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"file_path" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"file_sav_id" } ];
	                 
	                InitColumns(cols);
	
	                SetEditable(1);
	                SetImageList(0,"/opuscntr/img/ico_attach.gif");
	                SetDataLinkMouse(prefix + "file_download",1);
	                SetShowButtonImage(1);
	                SetSheetHeight(200);
		          }
		          break;
            case "sheet8":      //sheet1 init
                with (sheetObj) {
	                var prefix="file_";
	                var HeadTitle1="|Sel.|Seq.|File Name|Contents|ID|Date|File Download||||||||";
	                var headCount=ComCountHeadTitle(HeadTitle1);
	
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	                       {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"DelChk" },
	                       {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"Seq" },
	                       {Type:"Popup",     Hidden:0, Width:300,  Align:"Left",    ColMerge:0,   SaveName:prefix+"file_nm",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:200 },
	                       {Type:"Text",      Hidden:0,  Width:340,  Align:"Left",    ColMerge:0,   SaveName:prefix+"file_desc",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
	                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"upd_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"upd_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Image",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"file_download",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"clm_file_seq" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"clm_file_tp_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"clm_bztp_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"dw_clm_no" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"insur_tp_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"insur_plcy_yr" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"insur_clm_pty_no" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"inst_insur_tp_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"inst_insur_plcy_yr" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"inst_prm_insur_tp_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"file_path" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"file_sav_id" } ];
	                 
	                InitColumns(cols);
	
					SetEditable(1);
	                SetImageList(0,"/opuscntr/img/ico_attach.gif");
	                SetDataLinkMouse(prefix + "file_download",1);
	                SetShowButtonImage(1);
	                SetSheetHeight(200);
		          }
		          break;
            case "sheet9":      //sheet1 init
                with (sheetObj) {
	                var prefix="file_";
	                var HeadTitle1="|Sel.|Seq.|File Name|Contents|ID|Date|File Download||||||||";
	                var headCount=ComCountHeadTitle(HeadTitle1);
	
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	                       {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"DelChk" },
	                       {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"Seq" },
	                       {Type:"Popup",     Hidden:0, Width:300,  Align:"Left",    ColMerge:0,   SaveName:prefix+"file_nm",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:200 },
	                       {Type:"Text",      Hidden:0,  Width:340,  Align:"Left",    ColMerge:0,   SaveName:prefix+"file_desc",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
	                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"upd_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"upd_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Image",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"file_download",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"clm_file_seq" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"clm_file_tp_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"clm_bztp_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"dw_clm_no" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"insur_tp_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"insur_plcy_yr" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"insur_clm_pty_no" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"inst_insur_tp_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"inst_insur_plcy_yr" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"inst_prm_insur_tp_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"file_path" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"file_sav_id" } ];
	                 
	                InitColumns(cols);
	
	                SetEditable(1);
	                SetImageList(0,"/opuscntr/img/ico_attach.gif");
	                SetDataLinkMouse(prefix + "file_download",1);
	                SetShowButtonImage(1);
	                SetSheetHeight(160);
		          }
		          break;
            case "sheet10":      //sheet1 init
                with (sheetObj) {
	                var prefix="file_";
	                var HeadTitle1="|Sel.|Seq.|File Name|Contents|ID|Date|File Download||||||||";
	                var headCount=ComCountHeadTitle(HeadTitle1);
	
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	                       {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"DelChk" },
	                       {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"Seq" },
	                       {Type:"Popup",     Hidden:0, Width:300,  Align:"Left",    ColMerge:0,   SaveName:prefix+"file_nm",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:200 },
	                       {Type:"Text",      Hidden:0,  Width:340,  Align:"Left",    ColMerge:0,   SaveName:prefix+"file_desc",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
	                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"upd_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"upd_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Image",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"file_download",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"clm_file_seq" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"clm_file_tp_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"clm_bztp_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"dw_clm_no" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"insur_tp_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"insur_plcy_yr" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"insur_clm_pty_no" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"inst_insur_tp_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"inst_insur_plcy_yr" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"inst_prm_insur_tp_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"file_path" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"file_sav_id" } ];
	                 
	                InitColumns(cols);
	
	                SetEditable(1);
	                SetImageList(0,"/opuscntr/img/ico_attach.gif");
	                SetDataLinkMouse(prefix + "file_download",1);
	                SetShowButtonImage(1);
	                SetSheetHeight(153);
		          }
		          break;
            case "sheet11":      //sheet1 init
                with (sheetObj) {
	                var prefix="sheet_";
	                var HeadTitle1="|Sel.|Seq.|File Name|Contents|ID|Date|File Download|";
	                var headCount=ComCountHeadTitle(HeadTitle1);
	
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	                       {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"DelChk" },
	                       {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"Seq" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"inst_seq" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"inst_locl_amt" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"inst_curr_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"inst_xch_rt" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"inst_usd_amt" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"inst_due_dt" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"inst_pay_dt" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"insur_tp_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"insur_plcy_yr" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"insur_clm_pty_no" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"insur_prm_tp_cd" } ];
	                 
	                InitColumns(cols);
	
					SetEditable(1);
	                SetSheetHeight(181);
		          }
		          break;
		  }        
    }
	// Handling Sheet's process
    function doActionIBSheet(sheetObj,formObj,sAction,Col, msgYN) {
        switch(sAction) {
			case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) return;
				var insurClmPtyNo;
				var insurClmPtyNm;
				if (beforetab == 0) {//Main Terms
					formObj.f_cmd.value=SEARCH;
					//Insurer 정보 저장
					insurClmPtyNo=formObj.insur_clm_pty_no.value;
					insurClmPtyNm=formObj.insur_clm_pty_nm.value;
					var aryPrefix=new Array("file_", "file_", "file_", "file_", "file_", "file_", "file_", "file_", "sheet_", "file_", "file_");
					var sXml=sheetObj.GetSearchData("CPS_CNI_0401GS.do" , FormQueryString(formObj) +"&" + ComGetPrefixParam(aryPrefix));
					var arrXml=sXml.split("|$$|");
					if (arrXml.length > 0) sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
					if (arrXml.length > 1) sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
					if (arrXml.length > 2) sheetObjects[2].LoadSearchData(arrXml[2],{Sync:1} );
					if (arrXml.length > 3) sheetObjects[3].LoadSearchData(arrXml[3],{Sync:1} );
					if (arrXml.length > 4) sheetObjects[4].LoadSearchData(arrXml[4],{Sync:1} );
					if (arrXml.length > 5) sheetObjects[5].LoadSearchData(arrXml[5],{Sync:1} );
					if (arrXml.length > 6) sheetObjects[6].LoadSearchData(arrXml[6],{Sync:1} );
					if (arrXml.length > 7) sheetObjects[7].LoadSearchData(arrXml[7],{Sync:1} );
		   			if (ComGetEtcData(arrXml[0], "RetrievePrm") == "Y") {//Data found
						//Premium
						if (arrXml.length > 8) sheetObjects[10].LoadSearchData(arrXml[8],{Sync:1} );
						if (arrXml.length > 9) sheetObjects[8].LoadSearchData(arrXml[9],{Sync:1} );
						if (arrXml.length > 10) sheetObjects[9].LoadSearchData(arrXml[10],{Sync:1} );
						//Installment
						var prefix="sheet_"
						for (var ii=1; ii<11; ii++) {
							var findRow=sheetObjects[10].FindText(prefix+"inst_seq", ii);
							if (findRow > 0) {
								eval("form.inst_locl_amt_"+ii).value=sheetObjects[10].GetCellValue(findRow, prefix+"inst_locl_amt");
								eval("form.inst_xch_rt_"+ii).value=sheetObjects[10].GetCellValue(findRow, prefix+"inst_xch_rt");
								eval("form.inst_usd_amt_"+ii).value=sheetObjects[10].GetCellValue(findRow, prefix+"inst_usd_amt");
								eval("form.inst_due_dt_"+ii).value=sheetObjects[10].GetCellValue(findRow, prefix+"inst_due_dt");
								eval("form.inst_pay_dt_"+ii).value=sheetObjects[10].GetCellValue(findRow, prefix+"inst_pay_dt");
							} else {
								eval("form.inst_locl_amt_"+ii).value='';
								eval("form.inst_xch_rt_"+ii).value='';
								eval("form.inst_usd_amt_"+ii).value='';
								eval("form.inst_due_dt_"+ii).value='';
								eval("form.inst_pay_dt_"+ii).value='';
							}
						}
					} else {
						clearPremium();
					}	
	   			} else {//Premium
					formObj.f_cmd.value=SEARCH01;
					//Insurer 정보 저장
					insurClmPtyNo=formObj.insur_clm_pty_prm_no.value;
					insurClmPtyNm=formObj.insur_clm_pty_prm_nm.value;
					sheetObj=sheetObjects[10];
		        	var aryPrefix=new Array("sheet_", "file_", "file_");
		        	var sXml=sheetObj.GetSearchData("CPS_CNI_0401GS.do" , FormQueryString(formObj) +"&" + ComGetPrefixParam(aryPrefix));
					var arrXml=sXml.split("|$$|");
					if (arrXml.length > 0) sheetObjects[10].LoadSearchData(arrXml[0],{Sync:1} );
					if (arrXml.length > 1) sheetObjects[8].LoadSearchData(arrXml[1],{Sync:1} );
					if (arrXml.length > 2) sheetObjects[9].LoadSearchData(arrXml[2],{Sync:1} );
					//Installment
					var prefix="sheet_"
					for (var ii=1; ii<11; ii++) {
						var findRow=sheetObjects[10].FindText(prefix+"inst_seq", ii);
						if (findRow > 0) {
							eval("form.inst_locl_amt_"+ii).value=sheetObjects[10].GetCellValue(findRow, prefix+"inst_locl_amt");
							eval("form.inst_xch_rt_"+ii).value=sheetObjects[10].GetCellValue(findRow, prefix+"inst_xch_rt");
							eval("form.inst_usd_amt_"+ii).value=sheetObjects[10].GetCellValue(findRow, prefix+"inst_usd_amt");
							eval("form.inst_due_dt_"+ii).value=sheetObjects[10].GetCellValue(findRow, prefix+"inst_due_dt");
							eval("form.inst_pay_dt_"+ii).value=sheetObjects[10].GetCellValue(findRow, prefix+"inst_pay_dt");
						} else {
							eval("form.inst_locl_amt_"+ii).value='';
							eval("form.inst_xch_rt_"+ii).value='';
							eval("form.inst_usd_amt_"+ii).value='';
							eval("form.inst_due_dt_"+ii).value='';
							eval("form.inst_pay_dt_"+ii).value='';
						}
					}	
	   			}
   				ComEtcDataToForm(formObj, sheetObj);
   				if(formObj.insur_clm_pty_nm.value == "") {
   					formObj.insur_clm_pty_nm.value = ComGetEtcData(arrXml[0], "insur_clm_pty_nm");
   					formObj.insur_clm_pty_no.value= ComGetEtcData(arrXml[0], "insur_clm_pty_no");
   				}
	   			if (ComGetEtcData(arrXml[0], "Retrieve") == "Y") {//Data found
	   				//검색 조건 필드 제어
	   				inputReadOnly("Search");
	   			} else {
	   				if (beforetab == 0) {//Main Terms
		   				formObj.insur_clm_pty_no.value=insurClmPtyNo;
	   					formObj.insur_clm_pty_nm.value=insurClmPtyNm;
	   			        sheetObjects[0].RemoveAll();
	   			        sheetObjects[1].RemoveAll();
	   			        sheetObjects[2].RemoveAll();
	   			        sheetObjects[3].RemoveAll();
	   			        sheetObjects[4].RemoveAll();
	   			        sheetObjects[5].RemoveAll();
	   			        sheetObjects[6].RemoveAll();
	   			        sheetObjects[7].RemoveAll();
	   				} else {//Premium
		   				formObj.insur_clm_pty_prm_no.value=insurClmPtyNo;
	   					formObj.insur_clm_pty_prm_nm.value=insurClmPtyNm;
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
					formObj.f_cmd.value=SEARCH02;
					var sXml=sheetObj.GetSearchData("CPS_CNI_0401GS.do" , FormQueryString(formObj));
		   			sheetObj.LoadSearchData(sXml,{Sync:0} );
		   			if (ComGetEtcData(sXml, "Retrieve") == "Y") {//Data found
						doActionIBSheet(sheetObj,formObj,IBSEARCH);
		   			}	
				} else if (Col == "Premium") {//해당 Premium Type으로 데이터가 존재하는지 체크
					formObj.f_cmd.value=SEARCH03;
					var sXml=sheetObj.GetSearchData("CPS_CNI_0401GS.do" , FormQueryString(formObj));
		   			sheetObj.LoadSearchData(sXml,{Sync:0} );
		   			if (ComGetEtcData(sXml, "Retrieve") == "Y") {//Data found
						doActionIBSheet(sheetObj,formObj,IBSEARCH);
		   			}	
				}
			break;
			case IBSAVE:        //저장
          		if(!validateForm(sheetObj,formObj,sAction, Col)) return;
			   	var result="";
			   	if (Col == 'Save') {//Save
					if (beforetab == 0) {//Main Terms
						formObj.f_cmd.value=MODIFY;
						//Interest와 Subject Matter Insured인 경우 name필드 값을 desc에 세팅함.
						formObj.int_desc.value=formObj.int_desc_nm.value;
						formObj.subj_mat_ins_desc.value=formObj.subj_mat_ins_desc_nm.value;
						var sXml=sheetObj.GetSaveData("CPS_CNI_0401GS.do", FormQueryString(formObj));
			   			result=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
					} else {//Premium
						formObj.f_cmd.value=MODIFY01;
						sheetObj=sheetObjects[10];
						//Installment 필드를 Sheet에 세팅하기
						var prefix="sheet_"
						var aryPrefix=new Array("sheet_");
						for (var ii=1; ii<11; ii++) {
							var varLoclAmt=eval("form.inst_locl_amt_"+ii).value.trim();
							var varXchRt=eval("form.inst_xch_rt_"+ii).value.trim();
							var varUsdAmt=eval("form.inst_usd_amt_"+ii).value.trim();
							var varDueDt=eval("form.inst_due_dt_"+ii).value.trim();
							var varPayDt=eval("form.inst_pay_dt_"+ii).value.trim();
							var findRow=sheetObj.FindText(prefix+"inst_seq", ii);
							if (varLoclAmt != "" || varXchRt != "" || varDueDt != "" || varPayDt != "") {
 								if (findRow < 1) {//Insert
 									findRow=sheetObj.DataInsert();
 								}
								sheetObj.SetCellValue(findRow, prefix+"inst_seq",ii);
								sheetObj.SetCellValue(findRow, prefix+"inst_locl_amt",ComReplaceStr(varLoclAmt,","));
								sheetObj.SetCellValue(findRow, prefix+"inst_curr_cd",form.ttl_curr_cd.value);
								sheetObj.SetCellValue(findRow, prefix+"inst_xch_rt",ComReplaceStr(varXchRt,","));
								sheetObj.SetCellValue(findRow, prefix+"inst_usd_amt",ComReplaceStr(varUsdAmt,","));
								sheetObj.SetCellValue(findRow, prefix+"inst_due_dt",ComReplaceStr(varDueDt,"-"));
								sheetObj.SetCellValue(findRow, prefix+"inst_pay_dt",ComReplaceStr(varPayDt,"-"));
								sheetObj.SetCellValue(findRow, prefix+"insur_tp_cd",form.insur_tp_cd.value);
								sheetObj.SetCellValue(findRow, prefix+"insur_plcy_yr",form.insur_plcy_yr.value);
								sheetObj.SetCellValue(findRow, prefix+"insur_clm_pty_no",form.insur_clm_pty_prm_no.value);
								sheetObj.SetCellValue(findRow, prefix+"insur_prm_tp_cd",form.insur_prm_tp_cd.value);
							} else {
 								if (findRow > 0) {//Delete
 									sheetObj.SetRowStatus(findRow,"D");
 								}
							}
						}
						var arrSheets=new Array(sheetObj);
						var sParam=ComGetSaveString(arrSheets);
						var sXml=sheetObj.GetSaveData("CPS_CNI_0401GS.do", FormQueryString(formObj) +"&" + sParam +"&" + ComGetPrefixParam(aryPrefix));
			   			result=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
					}	
					if (result == 'S') {
			   			var iStart=0;
			   			var iEnd=0;
			   			//File 저장
						if (beforetab == 0) {//Main Terms
							iEnd=8;
						} else {//Premium
							iStart=8;
							iEnd=10;
						}
			   			for (var i=iStart; i<iEnd; i++) {
							if (sheetObjects[i].IsDataModified()) {
								doActionIBSheet(sheetObjects[i],formObj,IBSAVE,'FILE','N');
							}
			   			}
						//검색 조건 필드 제어
	   					inputReadOnly("Search");
					}
					sheetObj.LoadSaveData(sXml);
			   	} else if (Col == 'Delete') {//Delete
			   		var insurPlcyYr=formObj.insur_plcy_yr.value;
					if (beforetab == 0) {//Main Terms
						formObj.f_cmd.value=MODIFY02;
						var sXml=sheetObj.GetSaveData("CPS_CNI_0401GS.do", FormQueryString(formObj));
						sheetObj.LoadSaveData(sXml);
		   				result=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
					} else {//Premium
						formObj.f_cmd.value=MODIFY03;
						sheetObj=sheetObjects[10];
						var sXml=sheetObj.GetSaveData("CPS_CNI_0401GS.do", FormQueryString(formObj));
						sheetObj.LoadSaveData(sXml);
		   				result=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
					}
					if (result == 'S') {
	            		var obj=document.getElementById("btn1_New");
	            		if (obj) ComFireEvent(obj , "click")
	            		formObj.insur_plcy_yr.value=insurPlcyYr;
	            	}	
			   	} else {
					formObj.f_cmd.value=MULTI;
					var paramFile1=setFileUpload(sheetObj, "file_");
					var arrSheets=new Array(sheetObj);
					var sParam=ComGetSaveString(arrSheets);
					if (sParam == "") return;
					var aryPrefix=new Array("file_");
					sParam="&f_cmd=" + MULTI + "&" + sParam +"&" + ComGetPrefixParam(aryPrefix) + "&" + paramFile1;
					
					var fileList = upload1.GetList();
		            if(fileList.length == 0) {
						var sXml=sheetObj.GetSaveData("CNI_FILE_0000GS.do", sParam);
						sheetObj.LoadSaveData(sXml);
						ComOpenWait(false);
			   			var result=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
			   			if (result == 'S' && msgYN == null) {
			   				ComShowCodeMessage('CNI00008');
			   			}
					} else {
						ComOpenWait(true);
						upload1.SaveStatus();
					}

			   	}
			break;
        }
    }
    /**
     * Party popup에서 선택시 Party Name을 세팅한다.
     */
    function setMainCodeInquiry(partyVo) {
		eval("form."+popupType.substring(4)+"_no").value=partyVo.clm_pty_no;
		eval("form."+popupType.substring(4)+"_nm").value=partyVo.pty_nm;
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
			eval("form."+ComReplaceStr(popupType.substring(4), "xch_rt", "")+"curr_cd").value=xchRtVo.curr_cd;
		} else {//Premium의 경우 Total의 필드가 아닌 경우 Total의 Currency와 다르면 안됨
			if (form.ttl_curr_cd.value != xchRtVo.curr_cd) {
		    	ComAlertFocus(eval("form."+popupType.substring(4)), ComGetMsg('CNI09059'));
				return;
			}	
		}
		eval("form."+popupType.substring(4)).value=xchRtVo.usd_locl_xch_rt;
		amount_change(eval("form."+popupType.substring(4)));
    }
    /**
     * 환율 팝업 클릭시 금액, 통화 등 다른 연관 필드도 모두 입력되었는지 체크
     */
    function chkFieldAmount(objLoclAmt, objCurrCd, msg1) {
		var loclAmt=objLoclAmt.value.trim();
		var currCd=objCurrCd.value.trim();
		var msg2=msg1;
       	if (msg1==undefined || msg1==null) {
           switch (popupType) {
                case "pop_ttl_xch_rt":
                	msg1="Total";
                	msg2="Total";
	                break;
                case "pop_adj_xch_rt":
                	msg1="Total";
                	msg2="Paid";
	                break;
                case "pop_rfnd_xch_rt":
                	msg1="Total";
                	msg2="Refunded";
	                break;
                case "pop_ots_xch_rt":
                	msg1="Total";
                	msg2="O/S";
	                break;
                case "pop_inst_xch_rt_1":
                	msg1="Total";
                	msg2="1st Installment";
	                break;
                case "pop_inst_xch_rt_2":
                	msg1="Total";
                	msg2="2nd Installment";
	                break;
                case "pop_inst_xch_rt_3":
                	msg1="Total";
                	msg2="3rd Installment";
	                break;
                default:
                	msg1="Total";
                	msg2=popupType.substring(popupType.length-1)+"th Installment";
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
		var loclAmt=objLoclAmt.value.trim();
		var currCd=objCurrCd.value.trim();
		var xchRt=objXchRt.value.trim();
		if (xchRt == "") xchRt="0"; 
		var usdAmt=objUsdAmt.value.trim();
		if (usdAmt == "") usdAmt="0"; 
		var msg2=msg1;
       	if (msg1==undefined || msg1==null) {
			switch (objXchRt.name) {
			    case "adj_xch_rt":
			    	msg1="Total";
			    	msg2="Paid";
			        break;
			    case "rfnd_xch_rt":
			    	msg1="Total";
			    	msg2="Refunded";
			        break;
			    case "ots_xch_rt":
			    	msg1="Total";
			    	msg2="O/S";
			        break;
			    case "inst_xch_rt_1":
			    	msg1="Total";
			    	msg2="1st Installment";
			        break;
			    case "inst_xch_rt_2":
			    	msg1="Total";
			    	msg2="2nd Installment";
			        break;
			    case "inst_xch_rt_3":
			    	msg1="Total";
			    	msg2="3rd Installment";
			        break;
			    default:
			    	msg1="Total";
			    	msg2=objXchRt.name.substring(objXchRt.name.length-1)+"th Installment";
			        break;
			}
		}
		if (msg1 == msg2 && ComIsNull(loclAmt) && ComIsNull(currCd) && parseFloat(xchRt) == 0 && parseFloat(usdAmt) == 0) {
			objXchRt.value="";
			objUsdAmt.value="";
			return true;
		//Installment인 경우
		} else if (msg1 != msg2 && ComIsNull(loclAmt) && parseFloat(xchRt) == 0 && parseFloat(usdAmt) == 0) {
			objXchRt.value="";
			objUsdAmt.value="";
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
//	function sheet1_OnPopupClick(sheetObj,Row,Col){
//		var prefix="file_";
////		var fileName=sheetObj.OpenFileDialog("Open File");
//		if(fileName.indexOf("\\") !=-1) {
//			sheetObj.SetCellValue(Row, prefix+"file_path",fileName,0);
//			fileName=fileName.substr(fileName.lastIndexOf("\\")+1);
//			sheetObj.SetCellValue(Row, Col,fileName,0);
//		}
//	}
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @param {String} 	Value     	파일명
     **/
	function sheet1_OnClick(sheetObj,Row,Col,Value){
		var prefix="file_";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_download" || sheetObj.GetRowStatus(Row)=="I") return;
		if(sheetObj.GetCellText(Row, prefix+"file_sav_id") == "") return;
		location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, prefix+"file_sav_id");
		return;
	}
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     **/
	function sheet1_OnDblClick(sheetObj,Row,Col){
		var prefix="file_";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_nm" || sheetObj.GetRowStatus(Row)=="I") return;
		if(sheetObj.GetCellText(Row, prefix+"file_sav_id") == "") return;
		location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, prefix+"file_sav_id");
		return;
	}
	
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @param {String} 	Value     	파일명
     **/
	function sheet2_OnClick(sheetObj,Row,Col,Value){
		var prefix="file_";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_download" || sheetObj.GetRowStatus(Row)=="I") return;
		if(sheetObj.GetCellText(Row, prefix+"file_sav_id") == "") return;
		location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, prefix+"file_sav_id");
		return;
	}
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     **/
	function sheet2_OnDblClick(sheetObj,Row,Col){
		var prefix="file_";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_nm" || sheetObj.GetRowStatus(Row)=="I") return;
		if(sheetObj.GetCellText(Row, prefix+"file_sav_id") == "") return;
		location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, prefix+"file_sav_id");
		return;
	}
	
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @param {String} 	Value     	파일명
     **/
	function sheet3_OnClick(sheetObj,Row,Col,Value){
		var prefix="file_";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_download" || sheetObj.GetRowStatus(Row)=="I") return;
		if(sheetObj.GetCellText(Row, prefix+"file_sav_id") == "") return;
		location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, prefix+"file_sav_id");
		return;
	}
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     **/
	function sheet3_OnDblClick(sheetObj,Row,Col){
		var prefix="file_";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_nm" || sheetObj.GetRowStatus(Row)=="I") return;
		if(sheetObj.GetCellText(Row, prefix+"file_sav_id") == "") return;
		location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, prefix+"file_sav_id");
		return;
	}
	
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @param {String} 	Value     	파일명
     **/
	function sheet4_OnClick(sheetObj,Row,Col,Value){
		var prefix="file_";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_download" || sheetObj.GetRowStatus(Row)=="I") return;
		if(sheetObj.GetCellText(Row, prefix+"file_sav_id") == "") return;
		location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, prefix+"file_sav_id");
		return;
	}
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     **/
	function sheet4_OnDblClick(sheetObj,Row,Col){
		var prefix="file_";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_nm" || sheetObj.GetRowStatus(Row)=="I") return;
		if(sheetObj.GetCellText(Row, prefix+"file_sav_id") == "") return;
		location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, prefix+"file_sav_id");
		return;
	}
	
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @param {String} 	Value     	파일명
     **/
	function sheet5_OnClick(sheetObj,Row,Col,Value){
		var prefix="file_";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_download" || sheetObj.GetRowStatus(Row)=="I") return;
		if(sheetObj.GetCellText(Row, prefix+"file_sav_id") == "") return;
		location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, prefix+"file_sav_id");
		return;
	}
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     **/
	function sheet5_OnDblClick(sheetObj,Row,Col){
		var prefix="file_";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_nm" || sheetObj.GetRowStatus(Row)=="I") return;
		if(sheetObj.GetCellText(Row, prefix+"file_sav_id") == "") return;
		location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, prefix+"file_sav_id");
		return;
	}
	
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @param {String} 	Value     	파일명
     **/
	function sheet6_OnClick(sheetObj,Row,Col,Value){
		var prefix="file_";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_download" || sheetObj.GetRowStatus(Row)=="I") return;
		if(sheetObj.GetCellText(Row, prefix+"file_sav_id") == "") return;
		location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, prefix+"file_sav_id");
		return;
	}
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     **/
	function sheet6_OnDblClick(sheetObj,Row,Col){
		var prefix="file_";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_nm" || sheetObj.GetRowStatus(Row)=="I") return;
		if(sheetObj.GetCellText(Row, prefix+"file_sav_id") == "") return;
		location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, prefix+"file_sav_id");
		return;
	}
	
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @param {String} 	Value     	파일명
     **/
	function sheet7_OnClick(sheetObj,Row,Col,Value){
		var prefix="file_";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_download" || sheetObj.GetRowStatus(Row)=="I") return;
		if(sheetObj.GetCellText(Row, prefix+"file_sav_id") == "") return;
		location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, prefix+"file_sav_id");
		return;
	}
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     **/
	function sheet7_OnDblClick(sheetObj,Row,Col){
		var prefix="file_";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_nm" || sheetObj.GetRowStatus(Row)=="I") return;
		if(sheetObj.GetCellText(Row, prefix+"file_sav_id") == "") return;
		location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, prefix+"file_sav_id");
		return;
	}
	
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @param {String} 	Value     	파일명
     **/
	function sheet8_OnClick(sheetObj,Row,Col,Value){
		var prefix="file_";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_download" || sheetObj.GetRowStatus(Row)=="I") return;
		if(sheetObj.GetCellText(Row, prefix+"file_sav_id") == "") return;
		location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, prefix+"file_sav_id");
		return;
	}
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     **/
	function sheet8_OnDblClick(sheetObj,Row,Col){
		var prefix="file_";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_nm" || sheetObj.GetRowStatus(Row)=="I") return;
		if(sheetObj.GetCellText(Row, prefix+"file_sav_id") == "") return;
		location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, prefix+"file_sav_id");
		return;
	}
	
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @param {String} 	Value     	파일명
     **/
	function sheet9_OnClick(sheetObj,Row,Col,Value){
		var prefix="file_";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_download" || sheetObj.GetRowStatus(Row)=="I") return;
		if(sheetObj.GetCellText(Row, prefix+"file_sav_id") == "") return;
		location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, prefix+"file_sav_id");
		return;
	}
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     **/
	function sheet9_OnDblClick(sheetObj,Row,Col){
		var prefix="file_";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_nm" || sheetObj.GetRowStatus(Row)=="I") return;
		if(sheetObj.GetCellText(Row, prefix+"file_sav_id") == "") return;
		location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, prefix+"file_sav_id");
		return;
	}
	
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @param {String} 	Value     	파일명
     **/
	function sheet10_OnClick(sheetObj,Row,Col,Value){
		var prefix="file_";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_download" || sheetObj.GetRowStatus(Row)=="I") return;
		if(sheetObj.GetCellText(Row, prefix+"file_sav_id") == "") return;
		location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, prefix+"file_sav_id");
		return;
	}
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     **/
	function sheet10_OnDblClick(sheetObj,Row,Col){
		var prefix="file_";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_nm" || sheetObj.GetRowStatus(Row)=="I") return;
		if(sheetObj.GetCellText(Row, prefix+"file_sav_id") == "") return;
		location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, prefix+"file_sav_id");
		return;
	}
	/**
     * IBSheet에 업로드하고자 선택한 파일들을 IBUpload로 추가한다 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	prefix    	변수 구분값
     **/
	function setFileUpload(sheetObj, prefix) {
		//트랜잭션 상태가 "입력"인 행을 찾아 온다.
		var sRow=sheetObj.FindStatusRow("I");
		var arrRow=sRow.split(";");
		var param=prefix + "file_cnt=" + (arrRow.length-1); 
		return param; 
	}
    /**
     * IBSheet XML에서 XML 문자열을 파싱하여 그 안의 파라미터 항목 값을 리턴한다 <br>
     * @param {string} xmlStr    IBSheet를 통해 받아온 xml 문자열
     * @param {string} dataNode  파싱할 항목
     * @return {string} xmlValue
     **/
  	function GetXMLData(xmlStr, dataNode) {
  		var xmlData='';
        try {
            /* XML Parsing */
            var xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
            xmlDoc.async="false";
            xmlDoc.loadXML(xmlStr);
			/* get message */
            xmlData=xmlDoc.documentElement.getElementsByTagName(dataNode).item(0).text
        } catch(err) {
            xmlData='';
        }
		return xmlData;
  	}
    /**
     * handling process for input validation
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
		           	var fromDt=ComReplaceStr(form.insur_ctrt_eff_dt.value.trim(),"-","");
	            	var toDt=ComReplaceStr(form.insur_ctrt_exp_dt.value.trim(),"-","");
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
    	var readOnly=true;
    	if(flag == "New") {
    		readOnly=false;
			if (beforetab == 0) {//Main Terms
		    	form.insur_tp_cd.disabled=readOnly;
		    	form.insur_plcy_yr.readOnly=readOnly;
		    	form.insur_prm_tp_cd.disabled=readOnly;
			} else {//Premium
		    	//form.insur_prm_tp_cd.disabled = readOnly;
			}	
	    	ComBtnDisable("btn1_Delete");
    	} else {//Search
			if (beforetab == 0) {//Main Terms
		    	form.insur_tp_cd.disabled=readOnly;
		    	form.insur_plcy_yr.readOnly=readOnly;
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
        var elems=form.elements;
        //사용가능한 HTML컨트롤을 배열로 생성한다.
        var premiumYn="N";
        for (var i=0; i < elems.length; i++) {
           	//Premium Tab의 오브젝트만 initializing함.
           	if (elems[i].name == "insur_prm_tp_cd") {
           		premiumYn="Y";
           	}	
           	if (premiumYn == "Y") elems[i].value="";
        }//for
        //Type of Premium 초기값 세팅
        form.insur_prm_tp_cd.value=form.insur_prm_tp_cd.options[0].value;
//        sheetObjects[10].RemoveAll();
        sheetObjects[8].RemoveAll();
        sheetObjects[9].RemoveAll();
    }
    
    var pSheetObj, pRow, pCol ;
    function initUpload(){
    	upload1.Initialize({
    		SaveUrl:'/opuscntr/CNI_FILE_0000GS.do',
    		Files:[]
    	,BeforeSaveStatus : function(result){
    		var sRow=pSheetObj.FindStatusRow("I");
    		var arrRow=sRow.split(";");
    		var param="file_file_cnt=" + (arrRow.length-1); 
    		var paramFile1 = param
    		var arrSheets=new Array(pSheetObj);
    		var sParam=ComGetSaveString(arrSheets);
    		var aryPrefix=new Array("file_");
    		sParam="&f_cmd=" + MULTI + "&" + sParam +"&" + ComGetPrefixParam(aryPrefix) + "&" + paramFile1;
            paramToForm(sParam);
            return true;
         }
   		,BeforeAddFile : function(result){ 
   			
    			return true;
   		}
    		,AfterSaveStatus : function(result) {  
	      		var code = result.code;
	      		var files = result.files;
	      		
	      		if( code == 0) {
	      			var sXml = (new XMLSerializer()).serializeToString(result.xmlData);
	     			uploadFileName=ComGetEtcData(sXml,"filename");

	     			pSheetObj.LoadSaveData(sXml);
	     			
//	     			for( var i = 0; i < files.length; i++) {
//	     				files[i].DeleteFromList();
//	                }
	     			
					ComOpenWait(false);
		   			var result=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
//		   			if (result == 'S') {
//		   				ComShowCodeMessage('CNI00008');
//		   			}
	      		}else {
					ComShowMessage(result.msg);
				}
	      		
   			ComOpenWait(false);
    		}
    		,AfterAddFile:function(result){
   			
    			var files = result.files;
    			var fileType="";
    			var badFile=false;
    			var fileName= files[files.length-1].GetFileName();
    			
    			for( var i = 0; i < files.length; i++) {
                	if(pSheetObj.GetCellValue(pSheetObj.GetSelectRow(), "file_file_nm") == files[i].GetFileName()){
                		files[i].DeleteFromList();
                	}
                }
    			
    			pSheetObj.SetCellValue(pSheetObj.GetSelectRow(), "file_file_nm",fileName,0);
    			pSheetObj.SetCellValue(pSheetObj.GetSelectRow(), pCol,fileName,0);
    		}
    	});
    }
    /**
     * handling event when MouseMove Sheet1
     */
    function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
         var row = sheetObj.MouseRow(),
         col = sheetObj.MouseCol(),
         info = null;
         var saveName = sheetObj.ColSaveName(col);
         var editFlag = sheetObj.GetCellEditable( row , col);
      if (row > 0 && saveName=="file_file_nm" && editFlag == 1) {
	      info = sheetObj.GetCellElement(row, col, 1);
	      pSheetObj = sheetObj;
	      pRow = row;
	      pCol = col;
      	  upload1.SetFileUploadElement(info);
       }
    }
    
    function sheet2_OnMouseMove(sheetObj, Button, Shift, X, Y) {
        var row = sheetObj.MouseRow(),
        col = sheetObj.MouseCol(),
        info = null;
        var saveName = sheetObj.ColSaveName(col);
        var editFlag = sheetObj.GetCellEditable( row , col);
     if (row > 0 && saveName=="file_file_nm" && editFlag == 1) {
	      info = sheetObj.GetCellElement(row, col, 1);
	      pSheetObj = sheetObj;
	      pRow = row;
	      pCol = col;
     	  upload1.SetFileUploadElement(info);
      }
   }
    
    function sheet3_OnMouseMove(sheetObj, Button, Shift, X, Y) {
        var row = sheetObj.MouseRow(),
        col = sheetObj.MouseCol(),
        info = null;
        var saveName = sheetObj.ColSaveName(col);
        var editFlag = sheetObj.GetCellEditable( row , col);
     if (row > 0 && saveName=="file_file_nm" && editFlag == 1) {
	      info = sheetObj.GetCellElement(row, col, 1);
	      pSheetObj = sheetObj;
	      pRow = row;
	      pCol = col;
     	  upload1.SetFileUploadElement(info);
      }
   }
    

	function sheet4_OnMouseMove(sheetObj, Button, Shift, X, Y) {
		var row = sheetObj.MouseRow(), col = sheetObj.MouseCol(), info = null;
		var saveName = sheetObj.ColSaveName(col);
		var editFlag = sheetObj.GetCellEditable(row, col);
		if (row > 0 && saveName == "file_file_nm" && editFlag == 1) {
			info = sheetObj.GetCellElement(row, col, 1);
			pSheetObj = sheetObj;
			pRow = row;
			pCol = col;
			upload1.SetFileUploadElement(info);
		}
	}
	
	function sheet5_OnMouseMove(sheetObj, Button, Shift, X, Y) {
		var row = sheetObj.MouseRow(), col = sheetObj.MouseCol(), info = null;
		var saveName = sheetObj.ColSaveName(col);
		var editFlag = sheetObj.GetCellEditable(row, col);
		if (row > 0 && saveName == "file_file_nm" && editFlag == 1) {
			info = sheetObj.GetCellElement(row, col, 1);
			pSheetObj = sheetObj;
			pRow = row;
			pCol = col;
			upload1.SetFileUploadElement(info);
		}
	}
	
	function sheet6_OnMouseMove(sheetObj, Button, Shift, X, Y) {
		var row = sheetObj.MouseRow(), col = sheetObj.MouseCol(), info = null;
		var saveName = sheetObj.ColSaveName(col);
		var editFlag = sheetObj.GetCellEditable(row, col);
		if (row > 0 && saveName == "file_file_nm" && editFlag == 1) {
			info = sheetObj.GetCellElement(row, col, 1);
			pSheetObj = sheetObj;
			pRow = row;
			pCol = col;
			upload1.SetFileUploadElement(info);
		}
	}
	
	function sheet7_OnMouseMove(sheetObj, Button, Shift, X, Y) {
		var row = sheetObj.MouseRow(), col = sheetObj.MouseCol(), info = null;
		var saveName = sheetObj.ColSaveName(col);
		var editFlag = sheetObj.GetCellEditable(row, col);
		if (row > 0 && saveName == "file_file_nm" && editFlag == 1) {
			info = sheetObj.GetCellElement(row, col, 1);
			pSheetObj = sheetObj;
			pRow = row;
			pCol = col;
			upload1.SetFileUploadElement(info);
		}
	}
	
	function sheet8_OnMouseMove(sheetObj, Button, Shift, X, Y) {
		var row = sheetObj.MouseRow(), col = sheetObj.MouseCol(), info = null;
		var saveName = sheetObj.ColSaveName(col);
		var editFlag = sheetObj.GetCellEditable(row, col);
		if (row > 0 && saveName == "file_file_nm" && editFlag == 1) {
			info = sheetObj.GetCellElement(row, col, 1);
			pSheetObj = sheetObj;
			pRow = row;
			pCol = col;
			upload1.SetFileUploadElement(info);
		}
	}
	
	function sheet9_OnMouseMove(sheetObj, Button, Shift, X, Y) {
		var row = sheetObj.MouseRow(), col = sheetObj.MouseCol(), info = null;
		var saveName = sheetObj.ColSaveName(col);
		var editFlag = sheetObj.GetCellEditable(row, col);
		if (row > 0 && saveName == "file_file_nm" && editFlag == 1) {
			info = sheetObj.GetCellElement(row, col, 1);
			pSheetObj = sheetObj;
			pRow = row;
			pCol = col;
			upload1.SetFileUploadElement(info);
		}
	}
	
	function sheet10_OnMouseMove(sheetObj, Button, Shift, X, Y) {
		var row = sheetObj.MouseRow(), col = sheetObj.MouseCol(), info = null;
		var saveName = sheetObj.ColSaveName(col);
		var editFlag = sheetObj.GetCellEditable(row, col);
		if (row > 0 && saveName == "file_file_nm" && editFlag == 1) {
			info = sheetObj.GetCellElement(row, col, 1);
			pSheetObj = sheetObj;
			pRow = row;
			pCol = col;
			upload1.SetFileUploadElement(info);
		}
	}
	
	function sheet11_OnMouseMove(sheetObj, Button, Shift, X, Y) {
		var row = sheetObj.MouseRow(), col = sheetObj.MouseCol(), info = null;
		var saveName = sheetObj.ColSaveName(col);
		var editFlag = sheetObj.GetCellEditable(row, col);
		if (row > 0 && saveName == "file_file_nm" && editFlag == 1) {
			info = sheetObj.GetCellElement(row, col, 1);
			pSheetObj = sheetObj;
			pRow = row;
			pCol = col;
			upload1.SetFileUploadElement(info);
		}
	}