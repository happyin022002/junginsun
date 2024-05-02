/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_fms_0032.js
*@FileTitle : Sublet Revenue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.06.24 최우석
* 1.0 Creation
* 
* 2010.11.24 이상민 [CHM-201007233-01] 수정 및 추가 
* vessel code 입력시 keypress : eng_keypress -> engnum_keypress
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
     * @class esm_fms_0032 : esm_fms_0032 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_fms_0032() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    	this.setHireStatement		= setHireStatement;
    	this.setBodBor				= setBodBor;
    	this.setVslCd				= setVslCd;
    	this.setContractNo			= setContractNo;
    	this.initControl            = initControl;
    	this.obj_keypress			= obj_keypress;
    	this.eng_keypress			= eng_keypress;
    	this.obj_change				= obj_change;
    	this.obj_deactivate			= obj_deactivate;
    	this.setSlpIssDt			= setSlpIssDt;
    	this.initConfirm			= initConfirm;
    	this.inputReadOnly			= inputReadOnly;
    	this.sheet1_OnSaveEnd		= sheet1_OnSaveEnd;
    	this.initRdConfig			= initRdConfig;
    	this.rdOpen					= rdOpen;
    	this.obj_activate			= obj_activate;
    }
    
   	/* 개발자 작업	*/

    // 공통전역변수 

    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    //2017.05.15 contract type 콤보로 변경
    var comboObjects = new Array();
    var comboCnt = 0;
    
    var rdObjects = new Array();
    var rdCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject = sheetObjects[0];
        var sheetObject1 = sheetObjects[1];

        /*******************************************************/
        var formObject = document.form;

        try {
        	var srcName = window.event.srcElement.getAttribute("name");
        	switch(srcName) {
        		case "btn_new":
        			if(!initConfirm()) return;
        			
        			ComBtnEnable("btn_hire");
        			ComBtnEnable("btn_bodBor");
        			
        			ComResetAll();
        			setSlpIssDt();
        			inputReadOnly("0");
        			break;

        		case "btn_save":
        			doActionIBSheet(sheetObject,formObject,IBSAVE);
        			inputReadOnly("1");
        			break;

    			case "btn_hire":
    				if(!initConfirm()) return;
    				
    				ComBtnDisable("btn_bodBor");
    				
    				if(validateForm(sheetObject,formObject)) {
	    				var param = FormQueryString(form);
	    				ComOpenWindowCenter("ESM_FMS_0034.do?" + param, "ESM_FMS_0034", 900, 435, false);
    				}
    				break;
    				
    			case "btn_bodBor":
    				if(!initConfirm()) return;
    				
    				ComBtnDisable("btn_hire");
	        		
    				if(validateForm(sheetObject,formObject)) {
	    				var param = FormQueryString(form);
	    				
	    				var flet_ctrt_no = formObject.flet_ctrt_no.value;
		        		var csr_curr_cd = formObject.csr_curr_cd.value;
		        		
		        		ComOpenPopup("ESM_FMS_0027.do?flet_ctrt_no="+flet_ctrt_no+"&csr_curr_cd="+csr_curr_cd+"&apro_flg=Y", 900, 378, "setBodBor", "1,0,1,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0027");
		        		
	    				//ComOpenWindowCenter("ESM_FMS_0034.do?" + param, "ESM_FMS_0034", 900, 415, false);
    				}
	        		
	        		//var flet_ctrt_no = formObject.flet_ctrt_no.value;
	        		//var csr_curr_cd = formObject.csr_curr_cd.value;
	        		
	        		//ComOpenPopup("ESM_FMS_0027.do?flet_ctrt_no="+flet_ctrt_no+"&csr_curr_cd="+csr_curr_cd, 900, 358, "setBodBor", "1,0,1,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0027");
	        		
	        		break;

    			case "btn_slip":
    				ComOpenWindowCenter("ESM_FMS_0041_1.do?popup=yes", "ESM_FMS_0041_1", 1024, 590, false);
    				//ComOpenWindowCenter("ESM_FMS_0041.do?popup=yes", "esm_fms_0041", 1024, 590, false);
    				break;

    			//2017.04.18 preview 기능 추가
	        	case "btn_preview":
	        		rdOpenPreview(rdObjects[0], document.form);
	        		break;
	        		
    			case "btn_print":
    				rdOpen(rdObjects[0], document.form);
    				break;

    			case "btn_vslCd":
     				ComOpenPopup("ESM_FMS_0022.do", 520, 440, "setVslCd", "1,0,1,1,1", false, false, null, null, null, "ESM_FMS_0022");
     				break;

    			case "btn_fletCtrtNo":
     				if(formObject.vsl_cd.value == "") {
     					ComAlertFocus(formObject.vsl_cd, ComGetMsg('FMS01231'));
     					return;
     				}
     				var param = "typeFlag=" + "TO" + "&vsl_cd=" + formObject.vsl_cd.value;
     				ComOpenPopup("ESM_FMS_0023.do?" + param, 520, 405, "setContractNo", "1,0,1,1,1", false, false, null, null, null, "ESM_FMS_0023");
     				break;
     				
    			case "btn_effDt":
    				var cal = new ComCalendar();
    				cal.setDisplayType('date');
    				cal.setEndFunction('setEffDt');
					cal.select(form.eff_dt, 'yyyy-MM-dd');
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

     		initSheet(sheetObjects[i],i+1);
     		//khlee-마지막 환경 설정 함수 추가
     		ComEndConfigSheet(sheetObjects[i]);
     	}

     	sheetObjects[0].ExtendLastCol = false;
    	initControl();
    	
    	setSlpIssDt();
    	
    	//RD
		initRdConfig(rdObjects[0]);
		
		//2017.05.15 contract type 콤보로 변경
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "ComCd");
    }

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt = 0;

    	switch(sheetNo) {
    		case 1:      //t1sheet1 init
    			with (sheetObj) {
    			
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

                    var HeadTitle = "|Seq|Account Code|Customer Code|Customer Code|Center Code|City|Eff. Date|Slip Amount|slp_tp_cd|slp_func_cd|slp_ofc_cd|slp_seq_no|csr_curr_cd|trns_curr_cd|trns_amt|inv_seq|slp_iss_dt|vvd_eff_dt|vvd_exp_dt|csr_no|flet_ctrt_no|flet_iss_tp_cd|inv_dtl_seq|bnk_seq";
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
                    /* ------------------------------------------------------ */
                    
                    DataRowMerge(1) = true;
                    SetSortDialog(false);
    			}
    			break;
    	}
    }

    /**
     * IBSheet 관련 각종 기능(조회,저장 등)을 처리한다.<br>
     **/
    function doActionIBSheet(sheetObj, formObj, sAction, objNm) {
    	sheetObj.ShowDebugMsg = false;
    	switch(sAction) {
    		case IBSEARCH:      //조회
	    		if(objNm == "flet_ctrt_tp_nm") {
		 			formObj.f_cmd.value = SEARCH04;
		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0050GS.do", FormQueryString(formObj));
		   			var ctrtType = ComGetEtcData(sXml, "ctrtType");
		   			if(typeof ctrtType != "undefined" && ctrtType != "") {
		   				//formObj.flet_ctrt_tp_nm.value = ctrtType;		//2017.05.15 contract type 콤보로 변경

		   				var param = "f_cmd=" + SEARCH01 + "&flet_ctrt_no=" + form.flet_ctrt_no.value;
		   				var sXml = sheetObj.GetSearchXml("ESM_FMS_0032GS.do", param);
		   				if(typeof ctrtType != "undefined" && ctrtType != "") {
		   					formObj.ownr_cd.value = ComGetEtcData(sXml, "CustCntCd");
		   					formObj.ownr_seq.value = ComGetEtcData(sXml, "CustSeq");
		   					formObj.ownr_nm.value = ComGetEtcData(sXml, "CustLglEngNm");
		   				}
					}
				} else if(objNm == "vsl_cd") {
	    			formObj.f_cmd.value = SEARCH01;
		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do", FormQueryString(formObj));
		   			var vslEngNm = ComGetEtcData(sXml, "vslEngNm");
	
		   			if(typeof vslEngNm != "undefined" && vslEngNm != "" ) {
		   				formObj.vsl_eng_nm.value = vslEngNm;
		   				form.flet_ctrt_no.value = "";
	     				//form.flet_ctrt_tp_nm.value = "";		//2017.05.15 contract type 콤보로 변경
	     				initDefaultContractNo(); //선박 대 계약 자동 매치
					} else {
						formObj.vsl_cd.value = "";
						form.flet_ctrt_no.value = "";
	     				//form.flet_ctrt_tp_nm.value = "";		//2017.05.15 contract type 콤보로 변경
						// 존재하지 않는 Vessel Code입니다
						ComAlertFocus(formObj.vsl_cd, ComGetMsg("FMS00006", "Vessel Code"));
					}
				} else if(objNm == "csr_curr_cd") {
					form.f_cmd.value = SEARCH01;
					var param = "f_cmd=" +  form.f_cmd.value + "&curr_cd=" + form.csr_curr_cd.value;
					var sXml = sheetObj.GetSearchXml("ESM_FMS_0076GS.do", param);
		   			var currNm = ComGetEtcData(sXml, "currCd");
	
		   			if(typeof currNm == "undefined" || currNm == "" ) {
		   				form.csr_curr_cd.value = "";
		   				ComAlertFocus(formObj.csr_curr_cd, ComGetMsg("FMS00006", "Currency"));
		   			}
				} else if(objNm == "eff_dt") {
		   			formObj.f_cmd.value = SEARCH09;
		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do" , ComReplaceStr(FormQueryString(form),"-",""));
		   			var effDt = ComGetEtcData(sXml, "effDt");
		   			if(typeof effDt == "undefined" || effDt == "" ) {
						formObj.eff_dt.value = "";
						ComAlertFocus(formObj.eff_dt, ComGetMsg("FMS01565"));
					}
				} else if(objNm == "vvd_cd") {
					formObj.f_cmd.value = SEARCH06;
					var param = "f_cmd=" + formObj.f_cmd.value + "&vvd_cd=" + formObj.vvd_cd.value;
					var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do", param);
					if(CoFmsShowXmlMessage(sXml) != "") {
						formObj.vvd_cd.value = "";
						ComAlertFocus(formObj.vvd_cd, CoFmsShowXmlMessage(sXml));
					} else {
						var vvdCd = formObj.vvd_cd.value;
						formObj.csr_desc.value = vvdCd.substring(0,4) + " " +
												 vvdCd.substring(4,6) + "년 " +
												 vvdCd.substring(6,8) + "월 " + "대선료 채권 계상";
					}
				} else if(objNm == "ComCd") {		//2017.05.15 contract type 콤보로 변경
					
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
		   			
				}
	 			break;

    		case IBSAVE:        //저장
    			if(validateForm(sheetObj,formObj,sAction)) {
    				formObj.f_cmd.value = MULTI;
    				var param = FormQueryString(formObj) + "&" + ComFmsSetPrifix(sheetObjects[0].GetSaveString(),"sheet1_");
					var sXml = sheetObj.GetSaveXml("ESM_FMS_0032GS.do", param);
					sheetObj.LoadSaveXml(sXml);
    			}
    			break;
    			
    		case IBSEARCH_ASYNC02: //선박 대 계약 자동 매치				
    			if(formObj.vsl_cd.value == "") return;				
    			var f_query = "";					
    			f_query += "f_cmd=" + SEARCH01; 
    			f_query += "&vsl_cd="+formObj.vsl_cd.value;	 			
    			f_query += "&type_flag="+gFletCtrtTpCdAll;  			
    			f_query += "&order_priority="+gOrderPriorityTO; 
    			
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
    	}
    }

    /**
     * 화면 폼입력값에 대한 Validation을 체크한다.<br>
     */
    function validateForm(sheetObj,formObj,sAction){
    	if (!ComChkValid(formObj)) {
     		return false;
      	}
    	
    	if(sAction == IBSAVE) {
	    	if(sheetObjects[0].RowCount == 0) {
	  			ComShowCodeMessage("FMS00007");
	  			return false;
	  		}

	    	// --------------------------------------------------
			// Currency가 KRW와 JPY는 소수점을 입력못하게 체크한다.
			// --------------------------------------------------
	    	for(var row=2; row<=sheetObj.LastRow; row++) {
	    		if(row%2 == 0) {
 					var currCd = form.csr_curr_cd.value;
 					if(currCd == "KRW" || currCd == "JPY" || currCd == "PAB") {
 						var carAmt = sheetObj.CellValue(row, "csr_amt").replace(/,/g,'');
 						if(carAmt%parseInt(carAmt)) {
 							ComShowCodeMessage("FMS01476");
     						sheetObj.SelectCell(row, "csr_amt");
 							return false;
 						}
 					}
	    		}
	    	}
	    	// --------------------------------------------------
    	}

     	return true;
    }

	/**
 	 * Hire Statement PopUp창에서 조회한 데이터를 설정한다.<br>
 	 * @param {arry} aryPopupData
 	 */
 	function setHireStatement(aryPopupData) {

 		//sheetObjects[0].RemoveAll();
 		
 		for (var ir=sheetObjects[0].LastRow; ir>=2; ir--) {
 			if(   sheetObjects[0].CellValue(ir,"bnk_seq") == ""
 			   || sheetObjects[0].CellValue(ir,"bnk_seq1") == "") {
 				sheetObjects[0].RowDelete(ir,false);
	 			//sheetObjects[0].RowHidden(ir)= true;
	 			//sheetObjects[0].RowStatus(ir)= "D";
 			}
		}

 		var seqNo = 0;
 		var csrAmt = 0;
		for(var i=0; i<aryPopupData.length; i++) {
			var hirRevenueData = aryPopupData[i];
			var row = sheetObjects[0].DataInsert(-1);
			
			sheetObjects[0].CellValue2(row,"slp_tp_cd") = form.slp_tp_cd.value;
			sheetObjects[0].CellValue2(row,"slp_func_cd") = form.slp_func_cd.value;
			sheetObjects[0].CellValue2(row,"slp_ofc_cd") = form.slp_ofc_cd.value;
			
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

			sheetObjects[0].CellValue2(row,"slp_seq_no") = slpSeqNo;
			sheetObjects[0].CellValue2(row,"acct_cd") = "110811";
			sheetObjects[0].CellValue2(row,"ctr_cd") = hirRevenueData.ar_ctr_cd;
			sheetObjects[0].CellValue2(row,"slp_loc_cd") = hirRevenueData.loc_cd;
			sheetObjects[0].CellValue2(row,"csr_curr_cd") = form.csr_curr_cd.value;
			sheetObjects[0].CellValue2(row,"csr_amt") = hirRevenueData.inv_amt;
//			sheetObjects[0].CellValue2(row,"cust_cnt_cd") = hirRevenueData.cust_cnt_cd;			
//			sheetObjects[0].CellValue2(row,"cust_seq") = hirRevenueData.cust_seq;
			sheetObjects[0].CellValue2(row,"cust_cnt_cd") = form.ownr_cd.value;
			sheetObjects[0].CellValue2(row,"cust_seq") = form.ownr_seq.value;
			sheetObjects[0].CellValue2(row,"trns_curr_cd") = form.csr_curr_cd.value;
			sheetObjects[0].CellValue2(row,"slp_iss_dt") = form.slp_iss_dt.value;
			sheetObjects[0].CellValue2(row,"vvd_eff_dt") = hirRevenueData.eff_dt;
			sheetObjects[0].CellValue2(row,"vvd_exp_dt") = hirRevenueData.exp_dt;
			sheetObjects[0].CellValue2(row,"trns_amt") = hirRevenueData.inv_amt;
			sheetObjects[0].CellValue2(row,"inv_seq") = hirRevenueData.inv_seq;
			sheetObjects[0].CellValue2(row,"eff_dt") = form.eff_dt.value;
			sheetObjects[0].CellValue2(row,"flet_ctrt_no") = hirRevenueData.flet_ctrt_no;
			sheetObjects[0].CellValue2(row,"flet_iss_tp_cd") = hirRevenueData.flet_iss_tp_cd;
			sheetObjects[0].CellValue2(row,"inv_dtl_seq") = hirRevenueData.inv_dtl_seq;
			
			sheetObjects[0].CellValue2(row+1,"csr_desc") = hirRevenueData.inv_desc;
			sheetObjects[0].CellValue2(row+1,"csr_desc1") = hirRevenueData.inv_desc;
			sheetObjects[0].CellValue2(row+1,"csr_desc2") = hirRevenueData.inv_desc;
			sheetObjects[0].CellValue2(row+1,"csr_desc3") = hirRevenueData.inv_desc;
			sheetObjects[0].CellValue2(row+1,"to_inv_no") = hirRevenueData.to_inv_no;
			sheetObjects[0].CellValue2(row+1,"to_inv_no1") = hirRevenueData.to_inv_no;
			sheetObjects[0].CellValue2(row+1,"vvd_cd") = form.vvd_cd.value;

			csrAmt = csrAmt + parseFloat(hirRevenueData.inv_amt);
			
			sheetObjects[0].CellFont("FontName", row, "slp_loc_cd") = "Courier New";
			sheetObjects[0].CellFont("FontName", row+1, "vvd_cd") = "Courier New";
		}
		
		form.tot_hire_amt.value = CoFmsRound(csrAmt, 2);

		if(form.tot_bnk_amt.value == "") {
			form.rqst_amt.value = CoFmsRound(csrAmt, 2);
			form.dr_amt.value = ComAddComma(CoFmsRound(csrAmt, 2));	// 대변
			form.cr_amt.value = ComAddComma(CoFmsRound(csrAmt, 2));	// 차변
		} else {
			form.rqst_amt.value = CoFmsRound(form.tot_bnk_amt.value, 2) + CoFmsRound(csrAmt, 2);
			form.dr_amt.value = ComAddComma(CoFmsRound(form.tot_bnk_amt.value, 2) + CoFmsRound(csrAmt, 2));	// 대변
			form.cr_amt.value = ComAddComma(CoFmsRound(form.tot_bnk_amt.value, 2) + CoFmsRound(csrAmt, 2));	// 차변
		}

		for(var i=0; i<aryPopupData.length; i++) {
			var hirRevenueData = aryPopupData[i];
			var row = sheetObjects[0].DataInsert(-1);
			
			sheetObjects[0].CellValue2(row,"slp_tp_cd") = form.slp_tp_cd.value;
			sheetObjects[0].CellValue2(row,"slp_func_cd") = form.slp_func_cd.value;
			sheetObjects[0].CellValue2(row,"slp_ofc_cd") = form.slp_ofc_cd.value;
			
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

			sheetObjects[0].CellValue2(row,"slp_seq_no") = slpSeqNo;
			sheetObjects[0].CellValue2(row,"acct_cd") = "954112";
			sheetObjects[0].CellValue2(row,"ctr_cd") = hirRevenueData.ar_ctr_cd;
			sheetObjects[0].CellValue2(row,"slp_loc_cd") = hirRevenueData.loc_cd;
			sheetObjects[0].CellValue2(row,"csr_curr_cd") = form.csr_curr_cd.value;
			sheetObjects[0].CellValue2(row,"csr_amt") = hirRevenueData.inv_amt;
//			sheetObjects[0].CellValue2(row,"cust_cnt_cd") = hirRevenueData.cust_cnt_cd;			
//			sheetObjects[0].CellValue2(row,"cust_seq") = hirRevenueData.cust_seq;
			sheetObjects[0].CellValue2(row,"cust_cnt_cd") = form.ownr_cd.value;
			sheetObjects[0].CellValue2(row,"cust_seq") = form.ownr_seq.value;
			sheetObjects[0].CellValue2(row,"trns_curr_cd") = form.csr_curr_cd.value;
			sheetObjects[0].CellValue2(row,"slp_iss_dt") = form.slp_iss_dt.value;
			sheetObjects[0].CellValue2(row,"vvd_eff_dt") = hirRevenueData.eff_dt;
			sheetObjects[0].CellValue2(row,"vvd_exp_dt") = hirRevenueData.exp_dt;
			sheetObjects[0].CellValue2(row,"trns_amt") = hirRevenueData.inv_amt;
			sheetObjects[0].CellValue2(row,"inv_seq") = hirRevenueData.inv_seq;
			sheetObjects[0].CellValue2(row,"eff_dt") = form.eff_dt.value;
			sheetObjects[0].CellValue2(row,"flet_ctrt_no") = hirRevenueData.flet_ctrt_no;
			sheetObjects[0].CellValue2(row,"flet_iss_tp_cd") = hirRevenueData.flet_iss_tp_cd;
			sheetObjects[0].CellValue2(row,"inv_dtl_seq") = hirRevenueData.inv_dtl_seq;

			sheetObjects[0].CellValue2(row+1,"csr_desc") = hirRevenueData.inv_desc;
			sheetObjects[0].CellValue2(row+1,"csr_desc1") = hirRevenueData.inv_desc;
			sheetObjects[0].CellValue2(row+1,"csr_desc2") = hirRevenueData.inv_desc;
			sheetObjects[0].CellValue2(row+1,"csr_desc3") = hirRevenueData.inv_desc;
			sheetObjects[0].CellValue2(row+1,"to_inv_no") = hirRevenueData.to_inv_no;
			sheetObjects[0].CellValue2(row+1,"to_inv_no1") = hirRevenueData.to_inv_no;
			sheetObjects[0].CellValue2(row+1,"vvd_cd") = form.vvd_cd.value;
			
			sheetObjects[0].CellFont("FontName", row, "slp_loc_cd") = "Courier New";
			sheetObjects[0].CellFont("FontName", row+1, "vvd_cd") = "Courier New";
		}
		
		inputReadOnly("1");
 	}
 	
 	/**
 	 * BOD, BOR Settlement PopUp창에서 조회한 데이터를 설정한다.
 	 * @param {arry} aryPopupData
 	 */
 	function setBodBor(aryPopupData) {
 		
 	    for (var ir=sheetObjects[0].LastRow; ir>=2; ir--) {
			if(   sheetObjects[0].CellValue(ir,"bnk_seq") != ""
			   || sheetObjects[0].CellValue(ir,"bnk_seq1") != "") {
				sheetObjects[0].RowDelete(ir,false);
	 			//sheetObjects[0].RowHidden(ir)= true;
	 			//sheetObjects[0].RowStatus(ir)= "D";
			}
		}
 		
 	    var seqNo = 0;
		var csrAmt = 0;
		
		for(var i=0; i<aryPopupData.length; i++) {
			var bodBorData = aryPopupData[i];
			var row = sheetObjects[0].DataInsert(-1);
			
			sheetObjects[0].CellValue2(row,"slp_tp_cd") = form.slp_tp_cd.value;
			sheetObjects[0].CellValue2(row,"slp_func_cd") = form.slp_func_cd.value;
			sheetObjects[0].CellValue2(row,"slp_ofc_cd") = form.slp_ofc_cd.value;
			
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

			sheetObjects[0].CellValue2(row,"slp_seq_no") = slpSeqNo;
			sheetObjects[0].CellValue2(row,"acct_cd") = "110811";
			sheetObjects[0].CellValue2(row,"cust_cnt_cd") = form.ownr_cd.value;
			sheetObjects[0].CellValue2(row,"cust_seq") = form.ownr_seq.value;
			sheetObjects[0].CellValue2(row,"ctr_cd") = bodBorData.ctr_cd;
			sheetObjects[0].CellValue2(row,"slp_loc_cd") = bodBorData.slp_loc_cd;
			sheetObjects[0].CellValue2(row,"csr_curr_cd") = form.csr_curr_cd.value;
			
			sheetObjects[0].CellValue2(row,"trns_curr_cd") = form.csr_curr_cd.value;
			sheetObjects[0].CellValue2(row,"slp_iss_dt") = form.slp_iss_dt.value;
			
			sheetObjects[0].CellValue2(row,"trns_amt") = bodBorData.bnk_amt;
			sheetObjects[0].CellValue2(row,"eff_dt") = form.eff_dt.value;
			
			if(bodBorData.bnk_tp_cd == "BOD") {
				sheetObjects[0].CellValue2(row,"csr_amt") = -bodBorData.bnk_amt;	
			} else {
				sheetObjects[0].CellValue2(row,"csr_amt") = bodBorData.bnk_amt;
			}
			
			sheetObjects[0].CellValue2(row,"bnk_seq") = bodBorData.bnk_seq;
			
			sheetObjects[0].CellValue2(row,"flet_ctrt_no") = bodBorData.flet_ctrt_no;
			//sheetObjects[0].CellValue2(row,"flet_iss_tp_cd") = bodBorData.flet_src_tp_cd;
			
			sheetObjects[0].CellValue2(row+1,"csr_desc") = bodBorData.bnk_desc;
			sheetObjects[0].CellValue2(row+1,"csr_desc1") = bodBorData.bnk_desc;
			sheetObjects[0].CellValue2(row+1,"csr_desc2") = bodBorData.bnk_desc;
			sheetObjects[0].CellValue2(row+1,"csr_desc3") = bodBorData.bnk_desc;
			sheetObjects[0].CellValue2(row+1,"to_inv_no") = bodBorData.to_inv_no;
			sheetObjects[0].CellValue2(row+1,"to_inv_no1") = bodBorData.to_inv_no;
			sheetObjects[0].CellValue2(row+1,"vvd_cd") = bodBorData.vvd_bunker;
			sheetObjects[0].CellValue2(row+1,"bnk_seq1") = bodBorData.bnk_seq;
			
			csrAmt = csrAmt + parseFloat(sheetObjects[0].CellValue(row,"csr_amt"));
			
			sheetObjects[0].CellFont("FontName", row, "slp_loc_cd") = "Courier New";
			sheetObjects[0].CellFont("FontName", row+1, "vvd_cd") = "Courier New";

		}
		
		form.tot_bnk_amt.value = CoFmsRound(csrAmt, 2);
		
		if(form.tot_hire_amt.value == "") {
			form.rqst_amt.value = CoFmsRound(csrAmt, 2);
			form.dr_amt.value = ComAddComma(CoFmsRound(csrAmt, 2));	// 대변
			form.cr_amt.value = ComAddComma(CoFmsRound(csrAmt, 2));	// 차변
		} else {
			form.rqst_amt.value = CoFmsRound(form.tot_hire_amt.value, 2) + CoFmsRound(csrAmt, 2);
			form.dr_amt.value = ComAddComma(CoFmsRound(form.tot_hire_amt.value, 2) + CoFmsRound(csrAmt, 2));	// 대변
			form.cr_amt.value = ComAddComma(CoFmsRound(form.tot_hire_amt.value, 2) + CoFmsRound(csrAmt, 2));	// 차변
		}
		
		for(var i=0; i<aryPopupData.length; i++) {
			var bodBorData = aryPopupData[i];
			var row = sheetObjects[0].DataInsert(-1);
			
			sheetObjects[0].CellValue2(row,"slp_tp_cd") = form.slp_tp_cd.value;
			sheetObjects[0].CellValue2(row,"slp_func_cd") = form.slp_func_cd.value;
			sheetObjects[0].CellValue2(row,"slp_ofc_cd") = form.slp_ofc_cd.value;
			
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

			sheetObjects[0].CellValue2(row,"slp_seq_no") = slpSeqNo;
			sheetObjects[0].CellValue2(row,"acct_cd") = "954111";
			sheetObjects[0].CellValue2(row,"cust_cnt_cd") = form.ownr_cd.value;
			sheetObjects[0].CellValue2(row,"cust_seq") = form.ownr_seq.value;
			sheetObjects[0].CellValue2(row,"ctr_cd") = bodBorData.ctr_cd;
			sheetObjects[0].CellValue2(row,"slp_loc_cd") = bodBorData.slp_loc_cd;
			sheetObjects[0].CellValue2(row,"csr_curr_cd") = form.csr_curr_cd.value;
			
			sheetObjects[0].CellValue2(row,"trns_curr_cd") = form.csr_curr_cd.value;
			sheetObjects[0].CellValue2(row,"slp_iss_dt") = form.slp_iss_dt.value;
			
			sheetObjects[0].CellValue2(row,"trns_amt") = bodBorData.bnk_amt;
			sheetObjects[0].CellValue2(row,"eff_dt") = form.eff_dt.value;
			
			if(bodBorData.bnk_tp_cd == "BOD") {
				sheetObjects[0].CellValue2(row,"csr_amt") = -bodBorData.bnk_amt;	
			} else {
				sheetObjects[0].CellValue2(row,"csr_amt") = bodBorData.bnk_amt;
			}
			
			sheetObjects[0].CellValue2(row,"bnk_seq") = bodBorData.bnk_seq;
			
			sheetObjects[0].CellValue2(row,"flet_ctrt_no") = bodBorData.flet_ctrt_no;
			//sheetObjects[0].CellValue2(row,"flet_iss_tp_cd") = bodBorData.flet_src_tp_cd;
			
			sheetObjects[0].CellValue2(row+1,"csr_desc") = bodBorData.bnk_desc;
			sheetObjects[0].CellValue2(row+1,"csr_desc1") = bodBorData.bnk_desc;
			sheetObjects[0].CellValue2(row+1,"csr_desc2") = bodBorData.bnk_desc;
			sheetObjects[0].CellValue2(row+1,"csr_desc3") = bodBorData.bnk_desc;
			sheetObjects[0].CellValue2(row+1,"to_inv_no") = bodBorData.to_inv_no;
			sheetObjects[0].CellValue2(row+1,"to_inv_no1") = bodBorData.to_inv_no;
			//Account Code가 '954111' 이면 null로 처리함
			//sheetObjects[0].CellValue2(row+1,"vvd_cd") = bodBorData.vvd_bunker;
			sheetObjects[0].CellValue2(row+1,"bnk_seq1") = bodBorData.bnk_seq;
			
			sheetObjects[0].CellFont("FontName", row, "slp_loc_cd") = "Courier New";
			//sheetObjects[0].CellFont("FontName", row+1, "vvd_cd") = "Courier New";

		}
		
		inputReadOnly("1");
 	}
 	
	/**
 	 * Vessel Code 팝업창에서 선택한 Vessel Code와 Name을 Form항목에 설정한다.<br>
 	 * @param {arry} aryPopupData
 	 */
 	function setVslCd(aryPopupData) {
 		form.vsl_cd.value = aryPopupData[0][2];
 		form.vsl_eng_nm.value = aryPopupData[0][3];
 		
 		//선박 대 계약 자동 매치
 		if(form.vsl_cd.value != ""){
 			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"vsl_cd");
 		}
 	}
 	
 	/**
	 * Contract Code 팝업창에서 선택한 Contract No.을 Form항목에 설정한다.<br>
	 * @param {arry} aryPopupData
	 */
	function setContractNo(aryPopupData){
		form.flet_ctrt_no.value = aryPopupData[0][3];
		form.flet_ctrt_tp_cd.Code2 = aryPopupData[0][5];		//2017.05.15 contract type 콤보로 변경
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"flet_ctrt_tp_nm");
		contract_no_change();
	}
	
 	//선박 대 계약 자동 매치
 	function contract_no_change() {
 		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"flet_ctrt_tp_nm");
 	}
	
	/**
 	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 	 * @param {ibsheet} sheetObj    IBSheet Object
 	 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 	 **/
 	function initControl() {
 		//Axon 이벤트 처리1. 이벤트catch
 		axon_event.addListenerForm  ('blur', 'obj_deactivate',  form); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
 		axon_event.addListenerFormat('keypress'	, 'obj_keypress', form); 			//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
 		axon_event.addListenerForm  ('keypress'	, 'eng_keypress', form); 			//- form 전체 컨트롤 모든 컨트롤의 OnKeypress이벤트에 코드 처리
 		axon_event.addListenerForm  ('change'	, 'obj_change', form); 				//- form 전체 컨트롤 모든 컨트롤의 OnChange이벤트에 코드 처리
 		axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
 		//2010.11.24 이상민 [CHM-201007233-01] vsl_cd 는 engnum_keypress로 변경
        axon_event.addListener  ('keypress', 'engnum_keypress'   , 'vsl_cd');
 	}

    /**
     * HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다.<br>
     **/
    function obj_keypress() {
    	switch(event.srcElement.dataformat){
			case "int":
		        //숫자 만입력하기
		        ComKeyOnlyNumber(event.srcElement);
				break;
			case "float":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
			default:
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
    	}
    }
    
    /**
     * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다.<br>
     **/
   //* 2010.11.24 이상민 [CHM-201007233-01] vessel code는 engnum_keypress를 사용한다
    function eng_keypress() {
    	if(event.srcElement.name == "csr_curr_cd") {
    		//영대문자 자동변환
    		ComKeyOnlyAlphabet('upper');
    	} else if(event.srcElement.name == "vvd_cd") {
    		//영대문자 자동변환
    		ComKeyOnlyAlphabet('upper', '48|49|50|51|52|53|54|55|56|57');
    	}
    }
     
     /**
      * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
      **/
     //* 2010.11.24 이상민 [CHM-201007233-01] vessel code는 engnum_keypress를 사용한다
     function engnum_keypress() {
         //영대문자 자동변환
         ComKeyOnlyAlphabet('uppernum');
     }

    /**
     * HTML Control의 onchange이벤트에서 Vessel Code, Currency, Eff Date, VVD Validation을 체크한다.<br>
     */
	function obj_change() {
		if((event.srcElement.name == "vsl_cd") && (form.vsl_cd.value.length == 4)) {
	    	form.vsl_eng_nm.value = "";
	    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"vsl_cd");
		} else if((event.srcElement.name == "csr_curr_cd") && (form.csr_curr_cd.value.length == 3)) {
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"csr_curr_cd");
		} else if((event.srcElement.name == "eff_dt")) {
			if (form.eff_dt.value != "" && ComIsDate(form.eff_dt.value)) {
       			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "eff_dt");
        	}
		} else if((event.srcElement.name == "vvd_cd") && (form.vvd_cd.value.length == 10)) {
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"vvd_cd");
		}
	}

    /**
     * HTML Control의 ondeactivate이벤트에서 Validation을 체크한다.<br>
     **/
    function obj_deactivate(){
    	ComChkObjValid(event.srcElement);
    }

    /**
 	 * slp_iss_dt에 오늘 일자 세팅한다.<br>
 	 */
 	function setSlpIssDt() {
         var now=new Date();

         var y=now.getYear()+"";
         var M=now.getMonth()+1;
         if (M < 10) M = '0'+M;
         var d=now.getDate();
         if (d < 10) d = '0'+d;

         document.form.slp_iss_dt.value = ComGetMaskedValue(y+M+d, "ymd");
 	}
 	 
 	/**
     * 변경된 데이터가 있을 경우 다른 작업시 진행여부를 체크한다.<br>
     **/
    function initConfirm() {
    	var okYn = true;
     	if(sheetObjects[0].isDataModified) {
     		var okYn = ComShowCodeConfirm("FMS00002");
     	}
     	
     	return okYn;
    }
    
    /**
     * 조건에 따라 해당 오브젝트의 사용여부를 설정한다.<br>
     **/
    function inputReadOnly(flag) {
    	if(flag == "1") {
    		form.vsl_cd.readOnly = true;
    		form.csr_curr_cd.readOnly = true;
    		form.vvd_cd.readOnly = true;
    		form.eff_dt.readOnly = true;
    		form.btn_fletCtrtNo.style.cursor = "default";
    		document.images["btn_fletCtrtNo"].name = "no_btn_fletCtrtNo";
    		form.btn_vslCd.style.cursor = "default";
    		document.images["btn_vslCd"].name = "no_btn_effDt";
    		form.btn_effDt.style.cursor = "default";
    		document.images["btn_effDt"].name = "no_btn_effDt";
    	} else {
    		form.vsl_cd.readOnly = false;
    		form.csr_curr_cd.readOnly = false;
    		form.vvd_cd.readOnly = false;
    		form.eff_dt.readOnly = false;
    		form.btn_fletCtrtNo.style.cursor = "hand";
    		document.images["btn_fletCtrtNo"].name = "btn_fletCtrtNo";
    		form.btn_vslCd.style.cursor = "hand";
    		document.images["btn_vslCd"].name = "btn_effDt";
    		form.btn_effDt.style.cursor = "hand";
    		document.images["btn_effDt"].name = "btn_effDt";
	    	ComBtnEnable("btn_save");
	    	ComBtnEnable("btn_hire");
    	}
    }

    /**
     * 채권번호를 설정한다.<br>
     */
    function sheet1_OnSaveEnd(ErrMsg) {
    	if(sheetObjects[0].RowCount > 0) {
    		if(sheetObjects[0].CellValue(2, "csr_no") != "") {
	  	    	form.csr_no.value = sheetObjects[0].CellValue(2, "csr_no");
	  	    	ComBtnDisable("btn_save");
	  	    	ComBtnDisable("btn_hire");
    		}
  	    } else {
  	    	form.csr_amt.value = "0";
  	    	form.rqst_amt.value = "0";
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
   	 * 전표를 출력한다.<br>
   	 */
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
	}

    /**
     * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다.<br>
     */
    function obj_activate() {
        ComClearSeparator(event.srcElement);
    }

    /**
   	 * 달력 Ojbect를 이용하여 일자를 설정하는 경우 Change이벤트를 발생시킨다.<br>
   	 */
   	function setEffDt() {
   		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "eff_dt");
   	}
   	
   //선박 대 계약 자동 매치
   	function initDefaultContractNo(){
   	  doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);   
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
	            	
	            	comboObj.Code = comboCodeList[1];
	            	
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
	/* 개발자 작업  끝 */