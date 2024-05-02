/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_fms_0033.js
*@FileTitle : Reverse CSR for Sublet
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.08.03 최우석
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
     * @class esm_fms_0033 : esm_fms_0033 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_fms_0033() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    	this.setInvNo				= setInvNo;
    	this.setSlpIssDt			= setSlpIssDt;
    	this.initConfirm			= initConfirm;
    	this.inputReadOnly			= inputReadOnly;
    	this.initControl			= initControl;
    	this.obj_keypress			= obj_keypress;
    	this.eng_keypress			= eng_keypress;
    	this.obj_change				= obj_change;
    	this.obj_deactivate			= obj_deactivate;
    	this.sheet1_OnSearchEnd		= sheet1_OnSearchEnd;
    	this.sheet1_OnChange		= sheet1_OnChange;
    	this.setCsrSum				= setCsrSum;
    	this.sheet1_OnSaveEnd		= sheet1_OnSaveEnd;
    	this.sheet1_OnAfterEdit		= sheet1_OnAfterEdit;
    	this.sheet1_OnBeforeEdit	= sheet1_OnBeforeEdit;
    	this.setCellEditable		= setCellEditable;
    	this.obj_activate			= obj_activate;
    	this.initRdConfig			= initRdConfig;
    	this.rdOpen					= rdOpen;
    	this.setEffDt				= setEffDt;
    	this.sheet1_OnSearchEnd		= sheet1_OnSearchEnd;
    }
    
   	/* 개발자 작업	*/

    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var rdObjects = new Array();
    var rdCnt = 0;
    
    var orgEffDate = "";

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
					case "btn_Retrieve":
						if(!initConfirm()) return;
						if(form.btn_condition[0].checked) {
							form.search_type.value = "inquiry";
						} else if(form.btn_condition[1].checked) {
							form.search_type.value = "creation";
						}
						doActionIBSheet(sheetObject,formObject,IBSEARCH);
						break;

					case "btn_New":
						if(!initConfirm()) return;
	        			ComResetAll();
	        			setSlpIssDt();
	        			inputReadOnly(0);
	        			break;

					case "btn_Save":
						doActionIBSheet(sheetObject,formObject,IBSAVE);
						break;

					case "btn_slip":
						ComOpenWindowCenter("ESM_FMS_0041_1.do?popup=yes", "esm_fms_0041_1", 1024, 590, false);
						//ComOpenWindowCenter("ESM_FMS_0041.do?popup=yes", "esm_fms_0041", 1024, 590, false);
	    				break;

					case "btn_invNo":
						ComOpenPopup("ESM_FMS_00331.do", 650, 435, "setInvNo", "1,0,1,1,1", false, false, null, null, null, "esm_fms_00331");
						break;
						
					case "btn_effDt":
						orgEffDate = form.eff_dt.value;
	    				var cal = new ComCalendar();
	    				cal.setDisplayType('date');
	    				cal.setEndFunction('setEffDt');
						cal.select(form.eff_dt, 'yyyy-MM-dd');
						break;
	    				
					case "btn_condition":
						inputReadOnly(0);
						break;

					case "btn_Print":
	    				rdOpen(rdObjects[0], document.form);
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
	
	        sheetObjects[i].ExtendLastCol = false;
		}
		
		initControl();
	    setSlpIssDt();
	    inputReadOnly(0);
	    
	 	//RD
		initRdConfig(rdObjects[0]);
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

	 			// 높이 설정
	 			style.height = 263;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msAll;
				
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 2, 2, 3, 100);
				
				var HeadTitle1 = "|Sel|Seq|Acct Code|Customer Code|Customer Code|Center Code|City|Effective Date|Reserved AMT|Modified Slip AMT|slp_tp_cd|slp_func_cd|slp_ofc_cd|csr_curr_cd|inv_seq|vvd_eff_dt|vvd_exp_dt|flet_src_tp_cd|org_slp_tp_cd|org_slp_func_cd|org_slp_ofc_cd|org_iss_dt|org_slp_ser_no|flet_ctrt_no|csr_no";
                var HeadTitle2 = "|Sel|Seq|Description|Description|Description|Description|Description|VVD Code|Key Number|Key Number|slp_tp_cd1|slp_func_cd1|slp_ofc_cd1|csr_curr_cd1|inv_seq1|vvd_eff_dt1|vvd_exp_dt1|flet_src_tp_cd1|org_slp_tp_cd1|org_slp_func_cd1|org_slp_ofc_cd1|org_iss_dt1|org_slp_ser_no1|flet_ctrt_no1|csr_no1";
				var headCount = ComCountHeadTitle(HeadTitle1);
				
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, true, false, true, false,false)
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
				
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
				InitDataProperty(0, cnt++, dtCheckBox,     	30,    	daCenter,  	true,   "stl_flg");
				InitDataProperty(0, cnt++, dtSeq,			30,		daCenter,	true,	"Seq");
				InitDataProperty(0, cnt++, dtData,     		125,	daCenter,	true,	"acct_cd",			false,	"",	dfNone,		0,	false,	false);
                InitDataProperty(0, cnt++, dtData,     		40,		daCenter,	false,	"cust_cnt_cd",		false,	"",	dfNone,		0,	false,	false);
                InitDataProperty(0, cnt++, dtData,     		90,		daCenter,	false,	"cust_seq",			false,	"",	dfNone,		0,	false,	false);
                InitDataProperty(0, cnt++, dtData,     		125,	daCenter,	false,	"ctr_cd",			false,	"",	dfNone,		0,	false,	false);
                InitDataProperty(0, cnt++, dtData,     		125,	daCenter,	false,	"slp_loc_cd",		false,	"",	dfNone,		0,	false,	false);
                InitDataProperty(0, cnt++, dtData,     		125,	daCenter,	false,	"eff_dt",			false,	"",	dfDateYmd,	0,	false,	false);
                InitDataProperty(0, cnt++, dtData,   		130,	daRight,	false,	"csr_amt",			true,	"",	dfNullFloat,2,	true,	false, 18);
                InitDataProperty(0, cnt++, dtData,   		130,	daRight,	false,	"rev_amt",			false,	"",	dfFloat,	2,	false,	false);

                // ------------------------------------------------------------------------------------------------
                InitDataProperty(0, cnt++, dtHidden,     	30,		daCenter,	true,	"slp_tp_cd",		false,	"",	dfNone,		0,	true,	false);
                InitDataProperty(0, cnt++, dtHidden,     	30,		daCenter,	true,	"slp_func_cd",		false,	"",	dfNone,		0,	true,	false);
                InitDataProperty(0, cnt++, dtHidden,     	30,		daCenter,	true,	"slp_ofc_cd",		false,	"",	dfNone,		0,	true,	false);
                InitDataProperty(0, cnt++, dtHidden,     	30,		daCenter,	true,	"csr_curr_cd",		false,	"",	dfNone,		0,	true,	false);
                InitDataProperty(0, cnt++, dtHidden,     	30,		daCenter,	true,	"inv_seq",			false,	"",	dfNone,		0,	true,	false);
                InitDataProperty(0, cnt++, dtHidden,     	30,		daCenter,	true,	"vvd_eff_dt",		false,	"",	dfNone,		0,	true,	false);
                InitDataProperty(0, cnt++, dtHidden,     	30,		daCenter,	true,	"vvd_exp_dt",		false,	"",	dfNone,		0,	true,	false);
                InitDataProperty(0, cnt++, dtHidden,     	30,		daCenter,	true,	"flet_src_tp_cd",	false,	"",	dfNone,		0,	true,	false);
                InitDataProperty(0, cnt++, dtHidden,     	30,		daCenter,	true,	"org_slp_tp_cd",	false,	"",	dfNone,		0,	true,	false);
                InitDataProperty(0, cnt++, dtHidden,     	30,		daCenter,	true,	"org_slp_func_cd",	false,	"",	dfNone,		0,	true,	false);
                InitDataProperty(0, cnt++, dtHidden,     	30,		daCenter,	true,	"org_slp_ofc_cd",	false,	"",	dfNone,		0,	true,	false);
                InitDataProperty(0, cnt++, dtHidden,     	30,		daCenter,	true,	"org_iss_dt",		false,	"",	dfNone,		0,	true,	false);
                InitDataProperty(0, cnt++, dtHidden,     	30,		daCenter,	true,	"org_slp_ser_no",	false,	"",	dfNone,		0,	true,	false);
                InitDataProperty(0, cnt++, dtHidden,     	30,		daCenter,	true,	"flet_ctrt_no",		false,	"",	dfNone,		0,	true,	false);
                InitDataProperty(0, cnt++, dtHidden,     	30,		daCenter,	true,	"csr_no",			false,	"",	dfNone,		0,	true,	false);
                // ------------------------------------------------------------------------------------------------

				cnt = 0;
				InitDataProperty(1, cnt++, dtHiddenStatus,	30,		daCenter,	true,	"ibflag1");
				InitDataProperty(1, cnt++, dtData,     		30,    	daCenter,  	true,  	"stl_flg1",			false);
				InitDataProperty(1, cnt++, dtSeq,			30,		daCenter,	true,	"Seq1");
                InitDataProperty(1, cnt++, dtData,     		125,	daLeft,		true,	"csr_desc",			true,	"",	dfNone,		0,	true,	false, 100);
                InitDataProperty(1, cnt++, dtData,     		40,		daCenter,	false,	"csr_desc1",		false,	"",	dfNone,		0,	true,	false, 50);
                InitDataProperty(1, cnt++, dtData,     		90,		daCenter,	false,	"csr_desc2",		false,	"",	dfNone,		0,	true,	false, 50);
                InitDataProperty(1, cnt++, dtData,     		125,	daCenter,	false,	"csr_desc3",		false,	"",	dfNone,		0,	true,	false, 50);
                InitDataProperty(1, cnt++, dtData,     		125,	daCenter,	false,	"csr_desc4",		false,	"",	dfNone,		0,	true,	false, 50);
                InitDataProperty(1, cnt++, dtData,     		125,	daCenter,	false,	"vvd_cd",			false,	"",	dfNone,		0,	false,	false);
                InitDataProperty(1, cnt++, dtData,   		130,	daCenter,	false,	"to_inv_no",		false,	"",	dfNone,		0,	false,	false);
                InitDataProperty(1, cnt++, dtData,   		130,	daCenter,	false,	"to_inv_no1",		false,	"",	dfNone,		0,	false,	false);
                
                // ------------------------------------------------------------------------------------------------
                InitDataProperty(1, cnt++, dtHidden,     	30,		daCenter,	true,	"slp_tp_cd1",		false,	"",	dfNone,		0,	true,	false);
                InitDataProperty(1, cnt++, dtHidden,     	30,		daCenter,	true,	"slp_func_cd1",		false,	"",	dfNone,		0,	true,	false);
                InitDataProperty(1, cnt++, dtHidden,     	30,		daCenter,	true,	"slp_ofc_cd1",		false,	"",	dfNone,		0,	true,	false);
                InitDataProperty(1, cnt++, dtHidden,     	30,		daCenter,	true,	"csr_curr_cd1",		false,	"",	dfNone,		0,	true,	false);
                InitDataProperty(1, cnt++, dtHidden,     	30,		daCenter,	true,	"inv_seq1",			false,	"",	dfNone,		0,	true,	false);
                InitDataProperty(1, cnt++, dtHidden,     	30,		daCenter,	true,	"vvd_eff_dt1",		false,	"",	dfNone,		0,	true,	false);
                InitDataProperty(1, cnt++, dtHidden,     	30,		daCenter,	true,	"vvd_exp_dt1",		false,	"",	dfNone,		0,	true,	false);
                InitDataProperty(1, cnt++, dtHidden,     	30,		daCenter,	true,	"flet_src_tp_cd1",	false,	"",	dfNone,		0,	true,	false);
                InitDataProperty(1, cnt++, dtHidden,     	30,		daCenter,	true,	"org_slp_tp_cd1",	false,	"",	dfNone,		0,	true,	false);
                InitDataProperty(1, cnt++, dtHidden,     	30,		daCenter,	true,	"org_slp_func_cd1",	false,	"",	dfNone,		0,	true,	false);
                InitDataProperty(1, cnt++, dtHidden,     	30,		daCenter,	true,	"org_slp_ofc_cd1",	false,	"",	dfNone,		0,	true,	false);
                InitDataProperty(1, cnt++, dtHidden,     	30,		daCenter,	true,	"org_iss_dt1",		false,	"",	dfNone,		0,	true,	false);
                InitDataProperty(1, cnt++, dtHidden,     	30,		daCenter,	true,	"org_slp_ser_no1",	false,	"",	dfNone,		0,	true,	false);
                InitDataProperty(1, cnt++, dtHidden,     	30,		daCenter,	true,	"flet_ctrt_no1",	false,	"",	dfNone,		0,	true,	false);
                InitDataProperty(1, cnt++, dtHidden,     	30,		daCenter,	true,	"csr_no1",			false,	"",	dfNone,		0,	true,	false);
                // ------------------------------------------------------------------------------------------------
                
				SetSortDialog(false);
				DataRowMerge(1) = true;
	 		}
	 		break;
	 	}
  	}

    /**
     * Sheet관련 프로세스를 처리한다.<br>
     */
    function doActionIBSheet(sheetObj,formObj,sAction,objNm) {
    	sheetObj.ShowDebugMsg = false;
    	switch(sAction) {
    		case IBSEARCH:      //조회
  				if(objNm == "eff_dt") {
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
				} else {
					if(validateForm(sheetObj,formObj,sAction)) {
	        			formObj.f_cmd.value = SEARCH;
	        			var vsl_cd = "";
	        			if(formObj.btn_condition[0].checked) {
	        				vsl_cd = formObj.to_inv_no.value.substring(4,8);
	        	    	} else if(formObj.btn_condition[1].checked) {
	        	    		vsl_cd = formObj.vvd_cd.value.substring(0,4);
	        	    	}
	        			formObj.csr_desc.value = "Reverse CSR from Approved Sublet Invoice (" + vsl_cd + ")";
		   				sheetObj.DoSearch("ESM_FMS_0033GS.do", FormQueryString(formObj));
		   				inputReadOnly(1);
    				}
				} 
	 			break;

    		case IBSAVE:        //저장
	    		if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = MULTI;
					var param = FormQueryString(formObj) + "&" + ComFmsSetPrifix(sheetObjects[0].GetSaveString(),"sheet1_");
					var sXml = sheetObj.GetSaveXml("ESM_FMS_0033GS.do", param);
					sheetObj.LoadSaveXml(sXml);
					//inputReadOnly(1);
					//setCellEditable(sheetObj);
				}
    	      	  
    		case IBINSERT:      // 입력
    			break;
    	}
    }

    /**
     * 화면 폼입력값에 대한 Validation을 체크한다.<br>
     */
    function validateForm(sheetObj,formObj,sAction){
		var exptElems = "";
    	if(form.btn_condition[0].checked) {
    		exptElems = "vvd_cd";
    	} else if(form.btn_condition[1].checked) {
    		exptElems = "to_inv_no";
    	}
    	
    	if (!ComFmsChkValid(formObj, exptElems)) {
    		return false;
    	}

     	if(sAction == IBSAVE) {
     		var cnt = 0;
     		for(var row=2; row<=sheetObj.LastRow; row++) {
     			if(row%2 == 0) {
     				if(sheetObj.CellValue(row, "stl_flg") == 1) {
     					cnt = cnt + 1;

     					if(sheetObj.CellValue(row, "csr_amt") == 0 ||
     						sheetObj.CellValue(row, "csr_amt") == "") {
     						ComShowCodeMessage("FMS00020", "Reserved AMT");
     						sheetObj.SelectCell(row, "csr_amt");
     						return false;
     					}
     					
     					// --------------------------------------------------
     					// Currency가 KRW와 JPY는 소수점을 입력못하게 체크한다.
     					// --------------------------------------------------
     					var currCd = form.csr_curr_cd.value;
     					if(currCd == "KRW" || currCd == "JPY" || currCd == "PAB") {
     						var carAmt = sheetObj.CellValue(row, "csr_amt").replace(/,/g,'');
     						if(carAmt%parseInt(carAmt)) {
     							ComShowCodeMessage("FMS01476");
         						sheetObj.SelectCell(row, "csr_amt");
     							return false;
     						}
     					}
     					// --------------------------------------------------
     					
     				}
     			} else {
     				if(sheetObj.CellValue(row-1, "stl_flg") == 1) {
     					if(sheetObj.CellValue(row, "csr_desc") == " ") {
     						ComShowCodeMessage("FMS00004", "Description");
     						sheetObj.SelectCell(row, "csr_desc");
     						return false;
     					}
     				}
     			}
        	}

     		if(cnt == 0) {
     			ComShowCodeMessage("FMS00007");
 	  			return false;
     		}

 	    	if(sheetObj.RowCount == 0) {
 	  			ComShowCodeMessage("FMS00007");
 	  			return false;
 	  		}

 	    	// 동일한 Customer Code의 존재여부를 체크한다.
 	    	for(var i=2; i<sheetObj.LastRow; i++) {
 	    		if(i%2 == 0) {
	 	    		if(sheetObj.CellValue(i, "stl_flg") == 1) {
		 	    		var sourceCustCode = sheetObj.CellValue(i, "cust_cnt_cd") + sheetObj.CellValue(i, "cust_seq");
		 	    		for(var j=i+1; j<=sheetObj.LastRow; j++) {
		 	    			if(j%2 == 0) {
		 	    				if(sheetObj.CellValue(j, "stl_flg") == 1) {
				 	    			var targetCustCode = sheetObj.CellValue(j, "cust_cnt_cd") + sheetObj.CellValue(j, "cust_seq");
				 	    			if(sourceCustCode != targetCustCode) {
				 	    				ComShowCodeMessage("FMS01472");
				 	    				return false;
				 	    			}
		 	    				}
		 	    			}
		 	    		}
	 	    		}
 	    		}
 	    	}
     	}

     	return true;
    }
     
    /**
   	 * RCS/Invoice No Inquiry 팝업창에서 선택한 Invoice No.를 Form항목에 설정한다.<br>
   	 * @param {arry} aryPopupData
   	 */
   	function setInvNo(aryPopupData) {
   		form.to_inv_no.value = aryPopupData[0][3];
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
    	 if(flag == 0) {
	    	if(form.btn_condition[0].checked) {
				form.to_inv_no.readOnly = false;
				form.to_inv_no.className = "input1";
	   			form.vvd_cd.readOnly = true;
	   			form.vvd_cd.value = "";
	   			form.vvd_cd.className = "input2";
	   			
		    	document.images["btn_invNo"].name = "btn_invNo";
		    	form.btn_invNo.style.cursor = "hand";
		    	
		    	if(form.search_type.value == "creation") {
		    		form.eff_dt.value = "";
		    		form.csr_desc.value = "";
		    		form.csr_amt.value = "";
		    		sheetObjects[0].RemoveAll();
		    	}
			} else if(form.btn_condition[1].checked) {
				form.to_inv_no.readOnly = true;
	   			form.to_inv_no.value = "";
	   			form.to_inv_no.className = "input2";
				form.vvd_cd.readOnly = false;
				form.vvd_cd.className = "input1";

	   			document.images["btn_invNo"].name = "no_btn_invNo";
		    	form.btn_invNo.style.cursor = "default";
	
		    	if(form.search_type.value == "inquiry") {
		    		form.eff_dt.value = "";
		    		form.csr_desc.value = "";
		    		form.csr_amt.value = "";
		    		sheetObjects[0].RemoveAll();
		    	}
			}
	    	form.btn_condition[0].disabled = false;
	    	form.btn_condition[1].disabled = false;
	    	form.eff_dt.readOnly = false;
	    	
	    	form.csr_curr_cd.readOnly = false;
	    	
	    	document.images["btn_effDt"].name = "btn_effDt";
   		 	form.btn_effDt.style.cursor = "hand";

   		 	ComBtnEnable("btn_Retrieve");

    	} else if(flag == 1) {
            form.btn_condition[0].disabled = true;
    		form.btn_condition[1].disabled = true;
    		
    		form.to_inv_no.readOnly = true;
    		form.vvd_cd.readOnly = true;
    		form.eff_dt.readOnly = true;
    		
    		form.csr_curr_cd.readOnly = true;

    		document.images["btn_effDt"].name = "no_btn_effDt";
    		form.btn_effDt.style.cursor = "default";
    		 
    		document.images["btn_invNo"].name = "no_btn_invNo";
    		form.btn_invNo.style.cursor = "default";

    		ComBtnDisable("btn_Retrieve");
    	}
    }
    
    /**
  	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
  	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
  	 * @param {ibsheet} sheetObj    IBSheet Object
  	 * @param {int}     sheetNo     sheetObjects 배열에서 순번
  	 **/
  	function initControl() {
  		//Axon 이벤트 처리1. 이벤트catch
  		axon_event.addListenerForm  ('blur', 'obj_deactivate', form); 					//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
  		axon_event.addListenerFormat('keypress'	, 'obj_keypress', form); 			//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
  		axon_event.addListenerForm  ('keypress'	, 'eng_keypress', form); 			//- form 전체 컨트롤 모든 컨트롤의 OnKeypress이벤트에 코드 처리
  		axon_event.addListenerForm  ('change'	, 'obj_change', form); 				//- form 전체 컨트롤 모든 컨트롤의 OnChange이벤트에 코드 처리
  		axon_event.addListenerForm  ('beforeactivate', 'obj_activate', form); 					//- form 전체 컨트롤 모든 컨트롤의 OnFocus이벤트에 코드 처리
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
    function eng_keypress() {
    	if((event.srcElement.name == "vvd_cd") ||
    	   (event.srcElement.name == "to_inv_no")) {
    		//영대문자 자동변환
    		ComKeyOnlyAlphabet('upper', '48|49|50|51|52|53|54|55|56|57');
    	} else if(event.srcElement.name == "csr_curr_cd") {
    		//영대문자 자동변환
    		ComKeyOnlyAlphabet('upper');
    	}
    }

    /**
     * HTML Control의 onchange이벤트에서 eff_dt, vvd_cd, csr_curr_cd를 체크한다.<br>
     */
	function obj_change() {
		if((event.srcElement.name == "eff_dt")) {
			if (form.eff_dt.value != "" && ComIsDate(form.eff_dt.value)) {
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "eff_dt");
        	}
		} else if((event.srcElement.name == "vvd_cd") && (form.vvd_cd.value.length == 10)) {
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"vvd_cd");
		} else if((event.srcElement.name == "csr_curr_cd") && (form.csr_curr_cd.value.length == 3)) {
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"csr_curr_cd");
		}
	}

    /**
     * HTML Control의 onblur이벤트에서 Eff Date, Invoice No., VVD의 Validation을 체크한다.<br>
     **/
    function obj_deactivate() {
    	if((event.srcElement.name == "eff_dt")) {
    		ComChkObjValid(event.srcElement);
      	} else if((event.srcElement.name == "to_inv_no")) {
      		ComChkObjValid(event.srcElement);
      	} else if((event.srcElement.name == "vvd_cd")) {
      		ComChkObjValid(event.srcElement);
      	}
    }

    /**
     * Sheet에 OnSearchEnd 이벤트 발생시 flet_ctrt_no, csr_curr_cd를 Form항목에 설정한다.<br>
     */
    function sheet1_OnSearchEnd(sheetObj, errMsg) {
    	if(sheetObjects[0].RowCount > 0) {
  	    	form.flet_ctrt_no.value = sheetObjects[0].CellValue(2, "flet_ctrt_no");
  	    	form.csr_curr_cd.value = sheetObjects[0].CellValue(2, "csr_curr_cd");
  	    } else {
  	    	form.csr_amt.value = "0";
  	    }
  	}
    
    /**
     * Sheet1의 OnChange 이벤트 발생시 Reserved AMT의 Total값을 계산한다.<br>
     */
    function sheet1_OnChange(sheetObj, row, col, value) {
        if(col == 1 || col == 9) {
        	setCsrSum(sheetObj);
        }
    }

    /**
     * Total Amount를 구한다.<br>
     */
    function setCsrSum(sheetObj) {
    	var csrAmt = 0;
    	for(var row=2; row<=sheetObj.LastRow; row++) {
 			if(row%2 == 0) {
 				if(sheetObj.CellValue(row, "stl_flg") == 1) {
 	    			csrAmt = csrAmt + sheetObj.CellValue(row, "csr_amt")*1;
 				}
 			}
    	}

    	form.csr_amt.value = ComAddComma(CoFmsRound(csrAmt, 2));
		form.rqst_amt.value = ComAddComma(CoFmsRound(csrAmt, 2));
    }    
     
    /**
     * 채권번호를 설정한다.<br>
     */
    function sheet1_OnSaveEnd(errMsg) {
    	if(sheetObjects[0].RowCount > 0) {
    		if(sheetObjects[0].CellValue(2, "csr_no") != "") {
	   	    	form.csr_no.value = sheetObjects[0].CellValue(2, "csr_no");
	   	    	
	   	    	//추가
	   	    	inputReadOnly(1);
				setCellEditable(sheetObj);
    		}
   	    } else {
   	    	form.csr_amt.value = "0";
   	    	form.rqst_amt.value = "0";
   	    }
    }
     
    /**
     * Sheet1의 OnAfterEdit 이벤트 발생시 Description에 값이 없는 경우 column merge가 깨지므로 스페이스로 처리한다.<br>
     */
    function sheet1_OnAfterEdit(sheetObj, row, col) {
    	if((row%2 > 0) && (col == 3)) {
     	    if (sheetObj.CellValue(row,"csr_desc") == "") {
     	    	sheetObj.CellValue2(row,"csr_desc") = " ";
     		    sheetObj.CellValue2(row,"csr_desc1") = " ";
     		    sheetObj.CellValue2(row,"csr_desc2") = " ";
     		    sheetObj.CellValue2(row,"csr_desc3") = " ";
     		    sheetObj.CellValue2(row,"csr_desc4") = " ";
     		}
     	}
    }

    /**
     * Sheet1의 OnBeforeEdit 이벤트 발생시 Description이 스페이스인 경우 값을 넣기 위해 스페이스를 제거한다.<br>
     */
    function sheet1_OnBeforeEdit(sheetObj, row, col) {
        if((row%2 > 0) && (col == 3)) {
    	    if (sheetObj.CellValue(row,"csr_desc") == " ") {
    		    sheetObj.CellValue(row,"csr_desc") = "";
    		}
    	}
    }

    /**
     * 저장 후 항목수정을 못하게 처리한다.<br>
     */
    function setCellEditable(sheetObj) {
 		for(var row=2; row<=sheetObj.LastRow; row++) {
 			if(row%2 == 0) {
 				sheetObj.CellEditable(row, "stl_flg") = false;
 				sheetObj.CellEditable(row, "csr_amt") = false;
 			} else {
 				sheetObj.CellEditable(row, "stl_flg1") = false;
	 			sheetObj.CellEditable(row, "csr_desc") = false;
	 			sheetObj.CellEditable(row, "csr_desc1") = false;
	 			sheetObj.CellEditable(row, "csr_desc2") = false;
	 			sheetObj.CellEditable(row, "csr_desc3") = false;
 			}
 		}
    }

    /**
     * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다.<br>
     */
    function obj_activate() {
    	ComClearSeparator(event.srcElement);
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
   	 * 조회한 데이타를 인쇄한다.<br>
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

   	/**
   	 * Eff Data의 Validation을 체크한다.<br>
   	 */
   	function setEffDt() {
   		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "eff_dt");
   	}
   	 
   	/**
     * Sheet1에 OnSearchEnd 이벤트 발생시 VVD Code, City의 Font를 변경한다.<br>
     */
    function sheet1_OnSearchEnd(sheetObj, errMsg) {
    	for(var i=2; i<=sheetObj.LastRow; i++) {
    		if(i%2 > 0) {
    			sheetObj.CellFont("FontName", i, "vvd_cd") = "Courier New";
    		} else {
    			sheetObj.CellFont("FontName", i, "slp_loc_cd") = "Courier New";
    		}
    	}
    }
    /* 개발자 작업  끝 */