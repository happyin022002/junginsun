/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : esm_fms_0094.js
*@FileTitle : Revenue VVD Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.05
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2015.10.05 손진환
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
     * @class esm_fms_0094 : esm_fms_0094 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_fms_0094() {
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

	var rdObjects = new Array();
    var rdCnt = 0;
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
       /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject = sheetObjects[0];

       /*******************************************************/
       var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

          	switch(srcName) {
          		
          		case "btn_new":
	          		if(!CoFmsInitConfirm(sheetObject)) return;
	          		
	          		ComResetAll();
	                //CSR Date생성
	                setCsrDate();
	                condition_click();
	          		break;
	          		
            	case "btn_retrieve":
	             	if(!CoFmsInitConfirm(sheetObject)) return;
	             	
	             	if (form.condition[0].checked) {
	             		doActionIBSheet(sheetObject, formObject, IBSEARCH);
	             	}else{
	             		doActionIBSheet(sheetObject, formObject, IBSEARCH);
	             	}
	             	break;

				case "btn_creation":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;

				//2017.04.18 preview 기능 추가
	        	case "btn_preview":
	        		rdOpenPreview(rdObjects[0], document.form);
	        		break;
	        		
				case "btn_print":
					rdOpen(rdObjects[0], document.form);
					break;
                
     			case "btn_pay_date":
     				var cal = new ComCalendar();

					cal.setDisplayType('date');
					cal.select(form.pay_date, 'yyyy-MM-dd');
					break;					

     			case "btn_eff_dt":
     				var cal = new ComCalendar();

     				cal.setDisplayType('date');
					cal.select(form.eff_dt, 'yyyy-MM-dd');
					break;					

     			case "btn_eff_date_from":
     				var cal = new ComCalendar();

					cal.setDisplayType('date');
					cal.select(form.eff_date_from, 'yyyy-MM-dd');
					break;					

     			case "btn_eff_date_to":
     				var cal = new ComCalendar();

     				cal.setDisplayType('date');
					cal.select(form.eff_date_to, 'yyyy-MM-dd');
					break;
					
    			case "apro_step_btn" :
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

        //html컨트롤 이벤트초기화
        initControl();
        
        //RD
		initRdConfig(rdObjects[0]);
		
        //CSR Date생성
        setCsrDate();
        
        //Creation Button Disable
        ComBtnDisable("btn_creation");
        
        //radio 선택에 따른 이벤트 제어 실행
        condition_click();
    }

	
	/**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl() {
    	
        //Axon 이벤트 처리1. 이벤트catch
    	axon_event.addListenerForm  ('blur'				, 'obj_deactivate', form); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
        axon_event.addListenerFormat('keypress'        	, 'obj_keypress'  , form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리

        axon_event.addListener  ('keypress', 'obj_keypress' , form);					//- form 전체 컨트롤 중 keypress 이벤트 발생시
        axon_event.addListener  ('click'   , 'condition_click', 'condition');			//- Condition 클릭시 Lane Code 종류 제어
		
    }
    
    /**
     * HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
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
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_deactivate(){
	    ComChkObjValid(event.srcElement);
	    obj = event.srcElement;
	    if (obj.name == 'eff_dt') {
	    	eff_dt_change();
	    }
    }
    
    /**
     * IBSheet Object에서 입력값이 변경된 경우
     */
	function sheet1_OnChange(sheetObj, Row, Col, Value){
		if (sheetObj.ColSaveName(Col) == "selChk") {//체크박스 선택 시 row status값 변경한다.
			if(sheetObj.CellValue(Row, "selChk") == 1){												
				sheetObj.RowStatus(Row) = "I";
				
			}else{
				sheetObj.RowStatus(Row) = "R";
				
			}
		}																														
																	
	}
    /**
     * Event에 따른 화면 처리 <br>
     * @param {String} flag     	Event 구분값
     **/
    function inputReadOnly(flag) {
    	var readOnly = true;
    	var cursor = "default";
    	var img = "no_";
    	
    	if(flag == "New") {
    		readOnly = false;
    		cursor = "hand";
    		img = "";
    	}

    	form.rev_yrmon.readOnly = readOnly;
    	form.slan_cd.readOnly = readOnly;
    	form.rlane_cd.readOnly = readOnly;
    	form.lane_search[0].disabled = readOnly;
    	form.lane_search[1].disabled = readOnly;
    	form.condition[0].disabled = readOnly;
    	form.condition[1].disabled = readOnly;
    	
    	document.images["btn_period_from"].name = img+"btn_period_from";
    	document.images["btn_period_to"].name = img+"btn_period_to";
    	document.images["btn_lanepop"].name = img+"btn_lanepop";
    	
    	form.btn_period_from.style.cursor = cursor;
    	form.btn_period_to.style.cursor = cursor;
    	form.btn_lanepop.style.cursor = cursor;

    }

     /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {

					// 높이 설정
					style.height = 400;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 3, 100);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(44, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false)
					
					var HeadTitle = "|All|Prepayment CSR No|New CSR No|Result Remark";
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,    daCenter,	false,  "ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,  	 50,    daCenter,   false,  "selChk");
					InitDataProperty(0, cnt++ , dtData,    		 240,   daCenter,  	true,   "org_slip_no",           false,          "",      dfNone,     0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,      	 240,   daCenter,  	true,   "new_csr_no",    	false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 340,   daCenter,  	true,   "rs_remark", 		false,          "",      dfNone,     0,     false,      false);
					
					InitDataProperty(0, cnt++ , dtHidden,      	 30,   daCenter,  	true,   "vsl_cd", 		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,   daCenter,  	true,   "ppay_hir_no", 		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,   daCenter,  	true,   "flet_ctrt_no", 		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,   daCenter,  	true,   "vndr_seq", 		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,   daCenter,  	true,   "eff_date", 		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,   daCenter,  	true,   "org_slp_tp_cd", 		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,   daCenter,  	true,   "org_slp_func_cd", 		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,   daCenter,  	true,   "org_slp_seq_no", 		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,   daCenter,  	true,   "slp_amt",	 		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,   daCenter,  	true,   "vvd_exp_dt", 		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,   daCenter,  	true,   "csr_curr_cd", 		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,   daCenter,  	true,   "inv_seq",	 		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 280,   daCenter,  	true,   "slp_desc", 		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,   daCenter,  	true,   "vvd_eff_dt", 		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,   daCenter,  	true,   "ctr_cd",	 		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,   daCenter,  	true,   "org_slp_ser_no", 		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,   daCenter,  	true,   "acct_cd",	 		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,   daCenter,  	true,   "org_slp_ofc_cd", 		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,   daCenter,  	true,   "org_slp_iss_dt", 		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,   daCenter,  	true,   "slp_loc_cd", 		false,          "",      dfNone,     0,     false,      false);
					
					InitDataProperty(0, cnt++ , dtHidden,      	 50,   daCenter,  	true,   "usr_id", 		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,   daCenter,  	true,   "csr_type", 		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 70,   daCenter,  	true,   "screen_gubun", 		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 50,   daCenter,  	true,   "from_eff_dt", 		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 50,   daCenter,  	true,   "to_eff_dt", 		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 100,   daCenter,  	true,   "vsl_eng_name", 		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,   daCenter,  	true,   "request_team", 		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 50,   daCenter,  	true,   "csr_dt", 		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 70,   daCenter,  	true,   "produced_by",	 		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,   daCenter,  	true,   "csr_desc", 		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,   daCenter,  	true,   "ownr_cd", 		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,   daCenter,  	true,   "ownr_nm",	 		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 50,   daCenter,  	true,   "csr_amt", 		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,   daCenter,  	true,   "evid_tp",	 		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,   daCenter,  	true,   "deduction", 		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 50,   daCenter,  	true,   "rqst_amt",	 		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,   daCenter,  	true,   "diff_desc", 		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,   daCenter,  	true,   "cxl_flg", 		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,   daCenter,  	true,   "cxl_desc", 		false,          "",      dfNone,     0,     false,      false);
                }
                break;
                
         }
     }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj, sAction, Col, Row) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

         	case IBSEARCH:      //조회

	 			if(!validateForm(sheetObj,formObj,sAction))return;

	 			if (form.condition[0].checked) {
	 				formObj.f_cmd.value = SEARCH;
	 				
	 			}else{
	 				formObj.f_cmd.value = SEARCH02;
	 				
	 			}

        	   	sheetObj.DoSearch("ESM_FMS_0094GS.do", ComReplaceStr(FormQueryString(formObj),"-",""));
        	   
                break;

         	case IBSAVE:      //Creation

	 			if(!validateForm(sheetObj,formObj,sAction))return;

         		formObj.f_cmd.value = SEARCH01;

        	   	sheetObj.DoSave("ESM_FMS_0094GS.do", FormQueryString(formObj));
        	   	
                break;

         	case IBROWSEARCH:
         		
         		if (Col == "eff_dt") {
					formObj.f_cmd.value = SEARCH09;
		
		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do" , ComReplaceStr(FormQueryString(formObj),"-",""));
		
		   			var effDt = ComGetEtcData(sXml, "effDt");
		   			if(typeof effDt == "undefined" || effDt == "" ) {
						formObj.eff_dt.value = "";
						ComAlertFocus(formObj.eff_dt, ComGetMsg("FMS01565"));
						ComBtnDisable("btn_creation");
						return;
					} else {
		   				ComBtnEnable("btn_creation");
					}
         		}
         		break;
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
     * slp_iss_dt를 생성한다.
     **/ 
	function setCsrDate() {
        var now=new Date();

        var y=now.getYear()+"";
        var M=now.getMonth()+1;
        if (M < 10) M = '0'+M;
        var d=now.getDate();
        if (d < 10) d = '0'+d;

        document.form.slp_iss_dt.value = ComGetMaskedValue(y+M+d, "ymd");
	}

    /**
     * Condition 클릭시 종류 제어 <br>
     **/
    function condition_click() {
    	
    	if (form.condition[0].checked) {//Creation
   			form.pay_date.disabled = false;
   			form.pay_date.className = "input1";
   			form.eff_dt.disabled = false;
   			form.eff_dt.className = "input1";
   			form.vsl_cd.disabled = true;
   			form.vsl_cd.value = "";
   			form.vsl_cd.className = "input2";
   			form.vsl_cd.value = "";
   			form.eff_date_from.disabled = true;
   			form.eff_date_from.className = "input2";
   			form.eff_date_from.value = "";
   			form.eff_date_to.disabled = true;
   			form.eff_date_to.className = "input2";
   			form.eff_date_to.value = "";
   			
    	} else {//Inquiry
   			form.pay_date.disabled = true;
   			form.pay_date.className = "input2";
   			form.pay_date.value = "";
   			form.eff_dt.disabled = true;
   			form.eff_dt.className = "input2";
   			form.eff_dt.value = "";
   			form.vsl_cd.disabled = false;
   			form.vsl_cd.className = "input";
   			form.eff_date_from.disabled = false;
   			form.eff_date_from.className = "input1";
   			form.eff_date_to.disabled = false;
   			form.eff_date_to.className = "input1";
   			
    	}
    }

	/**
	* 화면 폼입력값에 대한 유효성검증 프로세스 처리
	*/
	function validateForm(sheetObj,formObj,sAction){
		if (sAction == IBSAVE) {
			var cnt = sheetObj.CheckedRows("selChk");
			if(cnt < 1) {
				ComShowCodeMessage('FMS01153');
				return false;
			}
			if(formObj.eff_dt.value == ""){
				ComShowMessage(ComGetMsg("COM130201", "Effective Date"));
				return false;
			}
		}
		if (sAction == IBSEARCH) {

			if(formObj.condition[0].checked) {
				if (formObj.pay_date.value == ""){
					ComShowMessage(ComGetMsg("COM130201", "Payment Date"));
					return false;
				}
				
			}else{
				if (formObj.eff_date_from.value == ""){
					ComShowMessage(ComGetMsg("COM130201", "Effective Date(From)"));
					return false;
				}
				if (formObj.eff_date_to.value == ""){
					ComShowMessage(ComGetMsg("COM130201", "Effective Date(To)"));
					return false;
				}
				if(formObj.eff_date_from.value != "" && formObj.eff_date_to.value != ""){
					var diff_day = ComGetDaysBetween(formObj.eff_date_from.value, formObj.eff_date_to.value);
					if(diff_day > 365) {
						ComShowCodeMessage("COM132001", "", "1 year" );// '{?msg1} exceeds maximum duration {?msg2}.';
						return false;
					}
				}
				
			}
			
		}
		return true;
	}

    /**
     * IBSheet를 저장 후 실행되는 이벤트
     */
	function sheet1_OnSaveEnd(sheetObj,ErrMsg){
		sheetObj.ColumnSort("rs_remark", "DESC"); // DISVVD거나 NOVVD인것이 맨 위로 올라오도록 정렬
	}
	
    /**
     * IBSheet Object에서 팝업을 클릭시
     */
 	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
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

 	function rdOpen(rdObject, formObject){
 		var Rdviewer = rdObject ;
 		var sRdFile = "ESM_FMS_031.mrd";
 		var sRdUrl = "apps/alps/esm/fms/timecharterinoutaccounting/tcharterioconsultation/report/";
 		
 		var pRdFile = "ESM_FMS_094.mrd";
 		var pRdUrl = "apps/alps/esm/fms/timecharterinoutaccounting/tcharteriosettlement/report/";
 		
 		var rdParam = "";
 		var sheetObj = sheetObjects[0];
 		
 		if(sheetObj.RowCount == 0) {
 			ComShowCodeMessage("FMS00015");
 			return;
 			
 		}
 		
		var cnt = sheetObj.CheckedRows("selChk");
		if(cnt < 1) {
			ComShowCodeMessage('FMS01153');
			return false;
			
		}
 		
		// 선택 한 체크박스의 rownum을 가져온다.
 		var iCheckRow = sheetObj.FindCheckedRow("selChk");
		// 가져온 행을 배열로 만든다.
		var arrRow = iCheckRow.split("|");	
				
		for(var i = 0; i < arrRow.length-1; i++){
/*
			for(var j = 0 ; j <= sheetObj.LastCol; j++){ //모든 컬럼에 대해서 파라미터를 만든다.
					rdParam += "frm1_" + sheetObj.ColSaveName(j) + "[" + sheetObj.CellValue(arrRow[i], j) + "] "; // RD parameter 생성					
			}// col for end
*/
			// 선택 된 로우 1개당 프린트 두번함. S전표 > P전표 순서로
			if(sheetObj.CellValue(arrRow[i], "org_slip_no") != "" && sheetObj.CellValue(arrRow[i], "new_csr_no") != ""){
				rdParam = "frm1_csr_type[AP] frm1_slp_no[" + sheetObj.CellValue(arrRow[i], 2) + "] frm1_csr_no["  + sheetObj.CellValue(arrRow[i], 3) + "]"; // RD parameter 생성
				// 열고자 하는 RD 파일을 지정한다. 1. S전표 - New CSR
				Rdviewer.FileOpen(RD_path + sRdUrl + sRdFile, RDServer + '/rv ' + rdParam + "/rop /riprnmargin /rwait"); // RD 생성완료되면 프린트 /rprintnexit
				
				rdParam = rdParam.replace("frm1_csr_no", "frm1_printed_csr_no").replace("frm1_slp_no", "frm1_csr_no"); // S전표를 프린트 한뒤 파라미터 키값을 변경하여 P전표를 프린트한다. 
				// 열고자 하는 RD 파일을 지정한다. 2. P전표 - Prepayment CSR - watermark(EVIDENCE)
				Rdviewer.FileOpen(RD_path + pRdUrl + pRdFile, RDServer + '/rv ' + rdParam + "/rop /riprnmargin /rwait");
//				Rdviewer.CMPrint(); //인쇄 시작
				
			}
			
		}//row for end

 	}
 	
 	function rdOpenPreview(rdObject, formObject){
 		
 		var sRdPath = "apps/alps/esm/fms/timecharterinoutaccounting/tcharterioconsultation/report/ESM_FMS_031.mrd";
 		var pRdPath = "apps/alps/esm/fms/timecharterinoutaccounting/tcharteriosettlement/report/ESM_FMS_094.mrd";
 		var rdParam = "";
 		var sheetObj = sheetObjects[0];
 		
 		if(sheetObj.RowCount == 0) {
 			ComShowCodeMessage("FMS00015");
 			return;
 			
 		}
 		
		var cnt = sheetObj.CheckedRows("selChk");
		if(cnt < 1) {
			ComShowCodeMessage('FMS01153');
			return false;
			
		}
 		
		// 선택 한 체크박스의 rownum을 가져온다.
 		var iCheckRow = sheetObj.FindCheckedRow("selChk");
		// 가져온 행을 배열로 만든다.
		var arrRow = iCheckRow.split("|");	
				
		for(var i = 0; i < arrRow.length-1; i++){
			
			// 선택 된 로우 1개당 프린트 두번함. S전표 > P전표 순서로
			if(sheetObj.CellValue(arrRow[i], "org_slip_no") != "" && sheetObj.CellValue(arrRow[i], "new_csr_no") != ""){
				rdParam = "/rv frm1_csr_type[AP] frm1_slp_no[" + sheetObj.CellValue(arrRow[i], 2) + "] frm1_csr_no["  + sheetObj.CellValue(arrRow[i], 3) + "]"; // RD parameter 생성
			
				formObject.com_mrdPath.value = sRdPath;
				formObject.com_mrdArguments.value = rdParam;
		        ComOpenRDPopupModal('resizable=yes;dialogWidth:750px;dialogHeight:690px');   
		        
				rdParam = rdParam.replace("frm1_csr_no", "frm1_printed_csr_no").replace("frm1_slp_no", "frm1_csr_no"); // S전표를 프린트 한뒤 파라미터 키값을 변경하여 P전표를 프린트한다. 
				
				formObject.com_mrdPath.value = pRdPath;
				formObject.com_mrdArguments.value = rdParam;
		        ComOpenRDPopupModal('resizable=yes;dialogWidth:750px;dialogHeight:690px');   
				
			}
			
		}//row for end

 	}
 	
	/* 개발자 작업  끝 */