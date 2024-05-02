/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_BKG_1119_01.js
*@FileTitle : Korea B/L Application Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.01
*@LastModifier : 김종호
*@LastVersion : 1.0
* 2011.12.01 김종호
* 1.0 Creation
=========================================================*/
 /**
 * [ESM_BKG_1119_01] B/L Inquiry Detail
 * @extends
 * @class ESM_BKG_1119_01 화면에서 사용하는 업무 스크립트를 정의한다.
 */
    function ESM_BKG_1119_01() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;

    }
    
    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;

//    var comboObjects = new Array();
//    var comboCnt = 0;     
    
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
		var sheetObject = sheetObjects[0];
		/*******************************************************/
		var formObject = document.form;
		try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
				
				case "btn_close":
					closePage();
					break;
				case "btn_approval":
					doActionIBSheet(sheetObject,formObject,COMMAND01,"","");
					break;
				case "btn_reject":
					doActionIBSheet(sheetObject,formObject,COMMAND02,"","");
					break;
				case "btn_Print": // Print
					window.print();
                	break;
				case "img_mnl_bl_obrd_dt":
					var _cal = new ComCalendar();
					_cal.select(formObject.mnl_bl_obrd_dt, 'yyyy-MM-dd');
					chkValidDt();
					break;
				case "img_mnl_bl_iss_dt":
					if(document.form.rqst_bl_tp_cd.value != "W"){
						var _cal = new ComCalendar();
						_cal.select(formObject.mnl_bl_iss_dt, 'yyyy-MM-dd');
						chkValidDt();
					}
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
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage(blIssDt, blIssRjctDt) {
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		// B/L Type 에 따른 출력값 세팅
		
		if (document.form.rqst_bl_tp_cd.value == "O"){ document.form.bl_type.value = "Original B/L"; 
		} else if(document.form.rqst_bl_tp_cd.value == "W"){ document.form.bl_type.value = "Sea Waybill";
		} else if(document.form.rqst_bl_tp_cd.value == "S"){ document.form.bl_type.value = "Surrender";
		} else { document.form.bl_type.value = "Unknown"; }
		
		//라디오 버튼 값 세팅
		if(document.form.bl_rcv_tp_cd.value == "D"){
			document.form.radio_bl_rcv_tp_cd[0].checked = true;
			document.form.radio_bl_rcv_tp_cd[1].checked = false;
		}else if(document.form.bl_rcv_tp_cd.value == "Q"){
			document.form.radio_bl_rcv_tp_cd[0].checked = false;
			document.form.radio_bl_rcv_tp_cd[1].checked = true;
		}
		
		if(document.form.certi_exist_flg.value == "N"){
			document.form.radio_certi_exist_flg[0].checked = true;
			document.form.radio_certi_exist_flg[1].checked = false;
		}else if(document.form.certi_exist_flg.value == "Y"){
			document.form.radio_certi_exist_flg[0].checked = false;
			document.form.radio_certi_exist_flg[1].checked = true;
		}
		
		if(document.form.frt_dp_flg.value == "N"){
			document.form.radio_frt_dp_flg[0].checked = true;
			document.form.radio_frt_dp_flg[1].checked = false;
		}else if(document.form.frt_dp_flg.value == "Y"){
			document.form.radio_frt_dp_flg[0].checked = false;
			document.form.radio_frt_dp_flg[1].checked = true;
		}
		
		//버튼 활성&비활성화
		if(document.form.rqst_bl_tp_cd.value == "W"){
			document.form.radio_bl_rcv_tp_cd[0].disabled = true;
			document.form.radio_bl_rcv_tp_cd[1].disabled = true;
			document.form.mnl_bl_iss_dt.disabled = true;
			document.form.radio_certi_exist_flg[0].disabled = true;
			document.form.radio_certi_exist_flg[1].disabled = true;
			document.form.radio_frt_dp_flg[0].disabled = true;
			document.form.radio_frt_dp_flg[1].disabled = true;
			document.form.form1_bl_rqst_rmk.disabled = true;
		}
		
		//initRdConfig(rdObjects[0]);
		//doActionIBSheet(sheetObjects[0], document.form, IBCLEAR,"","");
		document.form.sXml.value = null;
		//initControl();
	}
	
	/** 
	 * page 종료시
	 * @return
	 */
	function closePage() {
		//parent 창에 변경 여부값을 넘기고 창 종료 
		window.returnValue = document.form.page_save_yn.value;
		self.close();
	}
	
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	 function initSheet(sheetObj,sheetNo) {
		 var cnt = 0;
	    switch(sheetNo) {
	        case 1:   //sheet1 init
	            with (sheetObj) {
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	                  //나머지는 속성이나 함수는 필요하지 않으므로 모두 생략한다.
	                // 높이 설정
					style.height = 302;
	                //전체Merge 종류 [선택, Default msNone]
	    			MergeSheet = msNone;
	
	    			//전체Edit 허용 여부 [선택, Default false]
	    			Editable = true;
	    			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	    			InitRowInfo(1, 1, 21, 100);
	
	    			// 해더에서 처리할 수 있는 각종 기능을 설정한다
	    			InitHeadMode(true, true, false, true, false, false);
	    			//var HeadTitle1 = " |bl_iss_sts_cd";
	    			var HeadTitle1 = " |bl_iss_sts_cd|xter_rqst_no|xter_rqst_seq|bl_no|bl_iss_rqst_dt|rqst_rct_loc_cd|loc_nm|rqst_co_nm|rqst_usr_eml|rqst_atnd_nm|rqst_phn_no|bl_rqst_rmk|tax_inv_rcvr_co_nm|tax_inv_rcvr_rgst_no|remit_co_nm|remit_knd_cd|crr_remit_amt|crr_acct_curr_cd|crr_bank_nm|crr_bank_acct_no|bl_iss_rmk|crr_remit_dt|rqst_bl_tp_cd|bl_type|bl_rcv_tp_cd|mnl_bl_obrd_dt|mnl_bl_iss_dt|certi_exist_flg|frt_dp_flg|bl_obrd_dt|";
	    			var headCount = ComCountHeadTitle(HeadTitle1);
	    			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	    			InitColumnInfo(headCount, 0, 0, true);
	    			
	    			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	    			InitHeadRow(0, HeadTitle1, true);
	
	    			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	    			InitDataProperty(0, cnt++ , dtHiddenStatus,30,    daCenter,  true,    "ibflag");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "bl_iss_sts_cd");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "xter_rqst_no");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "xter_rqst_seq");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "bl_no");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "bl_iss_rqst_dt");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "rqst_rct_loc_cd");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "loc_nm");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "rqst_co_nm");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "rqst_usr_eml");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "rqst_atnd_nm");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "rqst_phn_no");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "bl_rqst_rmk");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "tax_inv_rcvr_co_nm");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "tax_inv_rcvr_rgst_no");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "remit_co_nm");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "remit_knd_cd");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "crr_remit_amt");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "crr_acct_curr_cd");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "crr_bank_nm");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "crr_bank_acct_no");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "crr_remit_dt");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "bl_iss_rmk");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "rqst_bl_tp_cd");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "bl_type");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "bl_rcv_tp_cd");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "mnl_bl_obrd_dt");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "mnl_bl_iss_dt");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "certi_exist_flg");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "frt_dp_flg");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "bl_obrd_dt");
	            }
	            break;
	    }
	}
    
    //Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction,sCondParam,PageNo) {
        switch(sAction) {
        
			case COMMAND01: //btn_approval
				//document.form.sXml.value = null;
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
        		sheetObj.WaitImageVisible=false;
				ComOpenWait(true);
	        	formObj.f_cmd.value = COMMAND01;
	        	var SaveXml = sheetObj.GetSaveXml("ESM_BKG_1119_01GS.do", FormQueryString(formObj));
 				//sheetObj.LoadSaveXml(SaveXml);
	        	ComOpenWait(false);
    	        doActionIBSheet(sheetObj,formObj,SEARCH01,"","");
    	        ComShowMessage("Appoved successfully.");
    			formObj.page_save_yn.value = "A"; //데이터 변경 여부를 확인하고, 부모창 시트에 해당 코드로 변경하기 위해 세팅
    	        this.close();
    	        break;
				
			case COMMAND02: //btn_reject
				//document.form.sXml.value = null;
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
        		sheetObj.WaitImageVisible=false;
				ComOpenWait(true);
	        	formObj.f_cmd.value = COMMAND02;
	        	var SaveXml = sheetObj.GetSaveXml("ESM_BKG_1119_01GS.do", FormQueryString(formObj));
 				sheetObj.LoadSaveXml(SaveXml);
    	        ComOpenWait(false);
    	        doActionIBSheet(sheetObj,formObj,SEARCH01,"","");
    	        ComShowMessage("Rejected successfully.");
    	        formObj.page_save_yn.value = "X"; //데이터 변경 여부를 확인하고, 부모창 시트에 해당 코드로 변경하기 위해 세팅
    	        this.close();
				break;
				
			case SEARCH01: //조회
				//document.form.sXml.value = null;
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);
	        	formObj.f_cmd.value = SEARCH01;
	        	var sXml = sheetObj.GetSearchXml("ESM_BKG_1119_01GS.do", FormQueryString(formObj));
	        	sheetObj.LoadSearchXml(sXml);
	        	
	            if(sheetObj.RowCount == 1){
		            IBS_CopyRowToForm(sheetObj, formObj, 1, "form1_");
	            } 
	        	
				ComOpenWait(false);
				break;
				
	    }
    }

	/**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
    function setSheetObject(sheet_obj) {
    	sheetObjects[sheetCnt++] = sheet_obj;
    }
    
    /**
     * Remark TextArea의 Max값 설정
     */
    function maxLimit(obj) {
    	var maxLength = parseInt(obj.getAttribute("maxlength"));
    	var errTxt = "You are not allowed to input more than "+maxLength+" bytes.";
    	if(obj.value.length > maxLength ){
    		ComShowMessage(errTxt);
    		obj.value = obj.value.substring(0,maxLength);
    		return;
    	}
    }
    
    /**
     * bl onboard date보다 이른 date 고를 시 선택불가 logic 
     */
//    function validationForMnlDT(sheetObj){
//    	var blObrdDt =document.form.bl_obrd_dt.value;
//    	var mnlBlObrdDt = document.form.mnl_bl_obrd_dt.value;
//    	if('' != blObrdDt && mnlBlObrdDt<blObrdDt){
//    		alert('안돼');
//    	}
//    }
    
    /**
     * 이벤트 처리에 대한 유효성검증 프로세스 처리
     */
	function validateForm(sheetObj, formObj, sAction){
		with(formObj){
			var blIssStsCd = formObj.form1_bl_iss_sts_cd.value;
			switch(sAction) {
			case COMMAND01:	//btn_approval
				if( blIssStsCd != "R" ){ //B/L발급상태가 'Request'가 아니면 메시지 표시
					if (blIssStsCd == "A"){
						ComShowMessage("This B/L has already been approved.");
					} else if (blIssStsCd == "X"){
						ComShowMessage("This B/L has already been rejected.");
					} else {
						ComShowMessage("This B/L is not available now.");
					} 
					return false;
					break;
				}
				
			case COMMAND02:	//btn_reject
				if( blIssStsCd != "R" ){ //B/L발급상태가 'Request'가 아니면 메시지 표시
					if (blIssStsCd == "A"){
						ComShowMessage("This B/L has already been approved.");
					} else if (blIssStsCd == "X"){
						ComShowMessage("This B/L has already been rejected.");
					} else {
						ComShowMessage("This B/L is not available now.");
					} 
					return false;
					break;
				}
			}
		}
	
	    return true;
	}
	
	function chkValidDt(){
    	var blObrdDt =document.form.bl_obrd_dt.value;
    	var mnlBlObrdDt = document.form.mnl_bl_obrd_dt.value;
    	var mnlBlIssDt = document.form.mnl_bl_iss_dt.value;
    	if('' != blObrdDt && mnlBlObrdDt<blObrdDt){
    		ComShowMessage('실제 B/L On Board Date보다 늦은 날짜만 입력 가능합니다.');
    		document.form.mnl_bl_obrd_dt.focus();
    		document.form.mnl_bl_obrd_dt.value = blObrdDt;
       	}else if('' != blObrdDt && mnlBlIssDt<blObrdDt){
       		ComShowMessage('실제 B/L On Board Date보다 늦은 날짜만 입력 가능합니다.');
    		document.form.mnl_bl_iss_dt.focus();
    		document.form.mnl_bl_iss_dt.value = blObrdDt;
       	}
	}

	
