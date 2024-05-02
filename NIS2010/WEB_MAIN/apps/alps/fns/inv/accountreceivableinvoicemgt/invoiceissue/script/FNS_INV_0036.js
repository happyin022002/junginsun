/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0036.js
*@FileTitle : (Vietnam) Invoice Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.26
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.10.26 최우석
* 1.0 Creation
* --------------------------------------------------------
* History
* 2011.01.24 최도순 [CHM-201108418] 베트남지역 ALPS INVOICE 변경 요청
* 2011.11.08 박성진 [CHM-201113879-01] 베트남 인보이스 추가 및 보완
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
	 * @class FNS_INV_0036 : FNS_INV_0036 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function FNS_INV_0036() {
		this.processButtonClick		= processButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl            = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.validateForm 			= validateForm;
		this.sheet1_OnLoadFinish	= sheet1_OnLoadFinish;
		this.setBlNoRow				= setBlNoRow;
		this.MakeComboObject		= MakeComboObject;
		this.obj_activate			= obj_activate;
		this.obj_deactivate			= obj_deactivate;
		this.obj_keypress			= obj_keypress;
		this.obj_keyup				= obj_keyup;
		this.setCustCd				= setCustCd;
		this.inputReadOnly			= inputReadOnly;
		this.setInvTypeDisabled		= setInvTypeDisabled;
		this.setExRateDt			= setExRateDt;
		this.invChkValid			= invChkValid;
		this.initRdConfig			= initRdConfig;
		this.rdOpen					= rdOpen;
		this.setPaperIssueDisable	= setPaperIssueDisable;
		this.saveCombine			= saveCombine;
		this.blNoDupChk				= blNoDupChk;
		this.sheet1_OnChange		= sheet1_OnChange;
	}

	/* 개발자 작업	*/

	// 공통전역변수

	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var rdObjects = new Array();
	var rdCnt = 0;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러<br>
	 * 
	 * @return 없음
	 */
	function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject = sheetObjects[0];

    	/*******************************************************/
    	var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
                case "btn_new":
                	//var xchRtDt = formObject.xch_rt_dt.value;
                	ComResetAll();
                	formObject.combo_ar_ofc_cd.RemoveAll();
                	//formObject.xch_rt_dt.value = xchRtDt;
                	formObject.event_type.value = "open";
                	doActionIBSheet(sheetObject,formObject,IBSEARCH,"3");
                	formObject.event_type.value = "";
                	formObject.preview_yn.value = "";
                	inputReadOnly(0);
                	setInvTypeDisabled();
                	ComBtnEnable("btn_paperissue");
                	formObject.btn_issBy[1].disabled= false;
                	setExRateDt();
                    break;

		        case "btn_fromDt":
                    var cal = new ComCalendar();
                    cal.setDisplayType('date');
	                cal.select(formObject.from_dt, 'yyyy-MM-dd');
	                break;
	                
		        case "btn_toDt":
                    var cal = new ComCalendar();
                    cal.setDisplayType('date');
	                cal.select(formObject.to_dt, 'yyyy-MM-dd');
	                break;

		        case "btn_xchRtDt":
                    var cal = new ComCalendar();
                    cal.setDisplayType('date');
	                cal.select(formObject.xch_rt_dt, 'yyyy-MM-dd');
	                break;
	                
		        case "btn_custInfo":
		        	if(formObject.cust_cnt_cd.value.length == 2 && formObject.cust_seq.value.length == 6) {
		     	     	var param = '?cust_cnt_cd='+formObject.cust_cnt_cd.value+'&cust_seq='+formObject.cust_seq.value+'&pop_yn=Y';
		     	 		ComOpenPopup("FNS_INV_0013.do" + param, 900, 560, "", "1,0,1,1,1", false, false, null, null, null, "fns_inv_0013");
		          	}
	               
	                break;
	                
		        case "btn_custCd":
	                ComOpenPopup("FNS_INV_0086.do", 900, 450, "setCustCd", "1,0,1,1,1", false, false, null, null, null, "fns_inv_0086");
	                break;
	                
		        case "btn_paperissue":

		        	// 사전 체크 로직 - [CHM-201111084] 베트남 지역 인보이스 로직 변경 요청
		        	// Single 인 경우에만!! Combined 경우는 0088에서 체크
		        	if(formObject.btn_issOpt[0].checked && formObject.btn_issBy[1].checked){
		        		var blNos = "";
		    		    for (var i = 0; i < sheetObject.RowCount; i++) {
		    		    	for (var j = 0; j < 5; j++) {
		    		    		if (sheetObject.CellValue(i+1, j) != ""){
		    		    			blNos = blNos + "'" + sheetObject.CellValue(i+1, j) + "',";
		    		    		}
		    		    	}
		    		    }
		    		    if (blNos != ""){
		    		    	blNos = blNos + "''";
		    		    }
		    		    formObject.bl_nos.value = blNos;
		        		if(!doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC01))break;
		        	}
		        	
		        	if(formObject.btn_issOpt[0].checked && !doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC20)){
		        		break;
		        	} 
		        	
		        	if(formObject.btn_issOpt[1].checked) {
		        		if(validateForm(sheetObject,formObject,"")) {
		        			
							var vnInvPayMzdCd = formObject.method_pay.value;
							formObject.vn_inv_pay_mzd_cd.value = vnInvPayMzdCd;
							
							var arrArOfcCd = formObject.combo_ar_ofc_cd.Code.split("^");
		        			formObject.ar_ofc_cd.value = arrArOfcCd[1];
			        		var param = FormQueryString(formObject) + "&pgmNo=FNS_INV_0088";
			        		ComOpenPopup("FNS_INV_0088.do?"+param, 600, 400, "", "1,0,1,1,1", false, false, null, null, null, "fns_inv_0088");
		        		}
		        	} else {
		        		getSingleIssue();
		        	}
		        	break;
		        case "btn_issBy":
		        	inputReadOnly(0);
		        	break;
		        
		        case "btn_issOpt":
		        	if(formObject.btn_issOpt[1].checked) {
		        		formObject.btn_issBy[1].checked= false;
		        		formObject.btn_issBy[1].disabled= true;
		        		formObject.btn_issBy[0].checked= true;
		        		inputReadOnly(0);
		        		form.iss_type.value = "MULTI";
		        	} else {
		        		formObject.btn_issBy[1].disabled= false;
		        		formObject.btn_issBy[1].checked= true;
		        		formObject.btn_issBy[0].checked= false;
		        		inputReadOnly(0);
		        		form.iss_type.value = "SINGLE";
		        	}
		        	break;
		        	
		        case "btn_invType":
		        	setInvTypeDisabled();
		        	break;
	                
		        case "btn_dtOpt":
		        	if(form.btn_dtOpt[0].checked){
		        		form.dt_opt.value = "G";
		        	} else if(form.btn_dtOpt[1].checked) {
		        		form.dt_opt.value = "S";
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
     * single issue 일때 호출됨<br>
     *
     * @param {object} formObject
     * @param {object} sheetObject
     * @return 없음
     */
    function getSingleIssue(){
    	var formObject = document.form;
    	var sheetObject = sheetObjects[0];
    	if(formObject.btn_issBy[1].checked) {
    		var blNos = "";
		    for (var i = 0; i < sheetObject.RowCount; i++) {
		    	for (var j = 0; j < 5; j++) {
		    		if (sheetObject.CellValue(i+1, j) != ""){
		    			blNos = blNos + "'" + sheetObject.CellValue(i+1, j) + "',";
		    		}
		    	}
		    }
		    if (blNos != ""){
		    	blNos = blNos + "''";
		    }
		    formObject.bl_nos.value = blNos;
		    var preview_yn = formObject.preview_yn.value;
		    if(preview_yn == 'Y'){
		    	doActionIBSheet(sheetObject,formObject,IBSAVE);
		    }else{
		    	doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC10);
		    }
		} else {
			if(validateForm(sheetObject,formObject,"")) {
    			var arrArOfcCd = formObject.combo_ar_ofc_cd.Code.split("^");
    			formObject.ar_ofc_cd.value = arrArOfcCd[1];
        		var param = FormQueryString(formObject) + "&pgmNo=FNS_INV_0088";
        		ComOpenPopup("FNS_INV_0088.do?"+param, 600, 350, "", "1,0,1,1,1", false, false, null, null, null, "fns_inv_0088");
    		}
		}
    }        
	
    /**
     * preview 화면에서 issue 할때, 호출됨<br>
     *
     * @param {object} formObject
     * @param {object} sheetObject
     * @return 없음
     */
    function getPreviewIssue(){    	
    	document.form.preview_yn.value = "Y";
    	getSingleIssue();
    }
    
    /**
     * IBSheet Object를 배열로 등록<br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
     * 배열은 소스 상단에 정의<br>
     *
     * @param {object} sheet_obj
     * @return 없음
     */
    function setSheetObject(sheet_obj){
    	sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * Sheet 기본 설정 및 초기화<br>
     * body 태그의 onLoad 이벤트핸들러 구현<br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다<br>
     *
     * @return 없음
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
            
//            sheetObjects[i].ExtendLastCol = false;
        }
        
        initControl();
        initRdConfig(rdObjects[0]);
    }

    /**
      * 시트 초기설정값, 헤더 정의<br>
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호<br>
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다<br>
      * 
      * @param {object} sheetObj
      * @param {int} sheetNo
      * @return 없음
      * @see #loadPage
      */
     function initSheet(sheetObj,sheetNo) {
     	var cnt = 0;

     	switch(sheetNo) {
     		case 1:      //t2sheet1 init
     			with (sheetObj) {
     				 WaitImageVisible = false;
     			
                 	 // 높이 설정
                     style.height = 250;
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
                     InitColumnInfo(5, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     var HeadTitle = "1|2|3|4|5";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtData,	176,    daCenter,   false,   "bl_no1",	false,    "",      dfNone,	0,     true,	true, 12);
                     InitDataProperty(0, cnt++ , dtData,   	176,    daCenter,   false,   "bl_no2",  false,    "",      dfNone,	0,     true,    true, 12);
                     InitDataProperty(0, cnt++ , dtData,   	176,    daCenter,   false,   "bl_no3",  false,    "",      dfNone,	0,     true,    true, 12);
     				 InitDataProperty(0, cnt++ , dtData,   	176,    daCenter,   false,   "bl_no4",  false,    "",      dfNone,	0,     true,    true, 12);
     				 InitDataProperty(0, cnt++ , dtData,   	176,    daCenter,   false,   "bl_no5",  false,    "",      dfNone,	0,     true,    true, 12);
     				 CountPosition = 0;

     				 InitDataValid(0, "bl_no1", vtEngUpOther, "0123456789");
     				 InitDataValid(0, "bl_no2", vtEngUpOther, "0123456789");
     				 InitDataValid(0, "bl_no3", vtEngUpOther, "0123456789");
     				 InitDataValid(0, "bl_no4", vtEngUpOther, "0123456789");
     				 InitDataValid(0, "bl_no5", vtEngUpOther, "0123456789");
     			 }
                 break;
     	}
    }
     
    /**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다.<br>
     *
     * @param {object} sheetObj
     * @param {int} sheetNo
     * @return 없음
     * @see #loadPage
     */
	function initControl() {
		//Axon 이벤트 처리1. 이벤트catch
		axon_event.addListenerForm	('keyup', 'obj_keyup', form);
		axon_event.addListenerForm	('keypress', 'obj_keypress', form); 			//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
		axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
		axon_event.addListenerFormat('focus', 'obj_activate', form);
	}

    /** Sheet관련 프로세스 처리<br>
     * 
     * @param {object} sheetObj
     * @param {object} formObj
     * @param {int} sAction
     * @return 없음
     * @see #processButtonClick
     */
    function doActionIBSheet(sheetObj,formObj,sAction,flag, flag2) {
     	sheetObj.ShowDebugMsg = false;
     	switch(sAction) {
     		case IBSEARCH:      //조회
	     		//case IBSEARCH: // 화면 로딩시 AR Office & Number of copy invoice 조회
     			var arrArOfcCd = formObj.combo_ar_ofc_cd.Code.split("^");
     			if(arrArOfcCd[1] != "" && arrArOfcCd[1] != undefined){
     				formObj.ar_ofc_cd.value = arrArOfcCd[1];
     			}
	     			if(flag == "2") {
						if (formObj.cust_cnt_cd.value.length == 2 && formObj.cust_seq.value.length == 6) {
							formObj.f_cmd.value = SEARCH03;
							var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));	

							var custNm = ComGetEtcData(sXml, "cust_eng_nm");    
							if(typeof custNm != "undefined" && custNm != "" ) {
								formObj.cust_nm.value = custNm;
							} else {
								formObj.cust_nm.value = "";
							}		
									        	
							var custRgstNo = ComGetEtcData(sXml, "cust_rgst_no"); 
							if(typeof custRgstNo != "undefined" && custRgstNo != "" ) {
								formObj.cust_rgst_no.value = custRgstNo;
							} else {
								formObj.cust_rgst_no.value = "";
							}

							var crCurrCd = ComGetEtcData(sXml, "cr_curr_cd");    
							if(typeof crCurrCd != "undefined" && crCurrCd != "" ) {
								formObj.cr_curr_cd.value = crCurrCd;
							} else {
								formObj.cr_curr_cd.value = "";
							}
								
							var crAmt = ComGetEtcData(sXml, "cr_amt");
							if(typeof crAmt != "undefined" && crAmt != "" ) {
								formObj.cr_amt.value = ComAddComma(crAmt);
							} else {
								formObj.cr_amt.value = "";
							}
	
							var cntcPsonNm = ComGetEtcData(sXml, "cntc_pson_nm");    
							if(typeof cntcPsonNm != "undefined" && cntcPsonNm != "" ) {
								formObj.cntc_pson_nm.value = cntcPsonNm;
							} else {
								formObj.cntc_pson_nm.value = "";
							}
								
							var ioBndCd = formObj.io_bnd_cd.value;
							if (ioBndCd == "I") {
								var phnNo = ComGetEtcData(sXml, "ib_phn_no");
								if(typeof phnNo != "undefined" && phnNo != "" ) {
									formObj.phn_no.value = phn_no;
								} else {
									formObj.phn_no.value = "";
								}
	
								var faxNo = ComGetEtcData(sXml, "ib_fax_no");    
								if(typeof faxNo != "undefined" && faxNo != "" ) {
									formObj.fax_no.value = fax_no;
								} else {
									formObj.fax_no.value = "";
								}						
									
							} else {
								var phnNo = ComGetEtcData(sXml, "ob_phn_no");    
								if (phnNo != undefined) {
									formObj.phn_no.value = phnNo;
								} else {
									formObj.phn_no.value = "";
								}
	
								var faxNo = ComGetEtcData(sXml, "ob_fax_no");    
								if (faxNo != undefined) {
									formObj.fax_no.value = faxNo;
								} else {
									formObj.fax_no.value = "";
								}
							}					
					    }
	     			} else if(flag == "3") {
	     				// 환율을 가져온다.
	     				formObj.f_cmd.value = SEARCH;
						var sXml = sheetObj.GetSearchXml("FNS_INV_0036GS.do", FormQueryString(formObj));
						var xchRt = ComGetEtcData(sXml, "xchRt");
						if(typeof xchRt != "undefined" && xchRt != "" ) {
							formObj.xch_rt.value = ComAddComma(xchRt);
						}

						if(formObj.event_type.value == "open") {
							var arOfcCd = ComGetEtcData(sXml, "ar_ofc_cd");
							if(typeof arOfcCd != "undefined" && arOfcCd != "" ) {
								var arrXml = arOfcCd.split("|");
								MakeComboObject(formObj.combo_ar_ofc_cd, arrXml);
						        formObj.combo_ar_ofc_cd.text = arrXml[1].split("^")[3];
							}
							
							// 프린터정보를 가져온다.
							var invPrnDvcNm = ComGetEtcData(sXml, "inv_prn_dvc_nm");
							if(typeof invPrnDvcNm != "undefined" && invPrnDvcNm != "" ) {
								formObj.inv_prn_dvc_nm.value= invPrnDvcNm;
							} else {
								formObj.inv_prn_dvc_nm.value = rdObjects[0].GetLocalInfo("DefaultPrnName", "");
							}
					  		var invPrnDvcNm = form.inv_prn_dvc_nm.value;
					  		rdObjects[0].SetPrintInfo(invPrnDvcNm, 1, 1, 4);
		     			
					  		// Local Time을 가져온다.
							var lclTime = ComGetEtcData(sXml, "lcl_time");
							if(typeof lclTime != "undefined" && lclTime != "" ) {
								formObj.xch_rt_dt1.value = lclTime;
							}
							
							formObj.event_type.value = "";
						}else{
							// Local Time을 가져온다.
							if(flag2 == "Y"){
								var lclTime = ComGetEtcData(sXml, "lcl_time");
								if(typeof lclTime != "undefined" && lclTime != "" ) {
									var xchRtDt = lclTime.substring(0,4) + "-" + lclTime.substring(4,6) + "-" + lclTime.substring(6,8);
									formObj.xch_rt_dt1.value = lclTime;
									formObj.xch_rt_dt.value = xchRtDt;
								}
							}	
						}
	     			}
     			break;
     		
	     	case IBSEARCH_ASYNC10:        //preview
		    	if(validateForm(sheetObj,formObj,sAction)) {
		    		var arrArOfcCd = formObj.combo_ar_ofc_cd.Code.split("^");
				    formObj.ar_ofc_cd.value = arrArOfcCd[1];
					
				    formObj.f_cmd.value = SEARCH01;
					var sXml = sheetObj.GetSaveXml("FNS_INV_0036GS.do", FormQueryString(formObj));
					var blList = ComGetEtcData(sXml, "blList");
					var chgCd = ComGetEtcData(sXml, "chgCd");
					if(blList == "-1") {
    					ComShowCodeMessage("INV00097");
    				}else if(blList == "-2") {
    					ComShowCodeMessage("INV00136",chgCd);
    				} else {
    					rdOpenPreview("S",blList);
    				}
		    	}
		    	break;
     		case IBSAVE:        //저장
	     		if(validateForm(sheetObj,formObj,sAction)) {
				    var arrArOfcCd = formObj.combo_ar_ofc_cd.Code.split("^");
				    formObj.ar_ofc_cd.value = arrArOfcCd[1];
					formObj.f_cmd.value = MULTI;
					var vnInvPayMzdCd = formObj.method_pay.value;
					formObj.vn_inv_pay_mzd_cd.value = vnInvPayMzdCd;
					var sXml = sheetObj.GetSaveXml("FNS_INV_0036GS.do", FormQueryString(formObj));
					var invNoCnt = ComGetEtcData(sXml, "invNoCnt");
	    			var state = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
	    			if(state == "S") {
	    				if(invNoCnt == "-1") {
	    					ComShowCodeMessage("INV00097");
	    				} else if(invNoCnt == "-2") {
	    					ComShowCodeMessage("INV00098");
	    				} else {
	    					setPaperIssueDisable();
		    				formObj.inv_no_cnt.value= invNoCnt;
		    				var invNoList = ComGetEtcData(sXml, "invNoList");
		    				formObj.inv_no_list.value = invNoList;
//		    				ComShowCodeMessage("INV00051");
		    				if(invNoCnt > 0) {
		    					rdOpen("S");
		    				}
	    				}
	    			} else{
	    				ComShowCodeMessage("INV00053");
	    			}
	 			}
     			break;

     		case IBINSERT:      // 입력
	 			break;

     		
     		// 신규 추가 칼럼 대응 - [CHM-201111084] 베트남 지역 인보이스 로직 변경 요청
     		case IBSEARCH_ASYNC20: //체크
	     		if(validateForm(sheetObj,formObj,sAction)) {
	     			
	     			var arrArOfcCd = formObj.combo_ar_ofc_cd.Code.split("^");
				    formObj.ar_ofc_cd.value = arrArOfcCd[1];

				    var invType = "";
				    var invTypeMsg = "";
				    if(formObj.btn_invType[0].checked) {
				    	invType = "F";
				    	invTypeMsg = "VAT";
				    } else if(formObj.btn_invType[1].checked) {
				    	invType = "T";
				    	invTypeMsg = "VTT";
				    } else if(formObj.btn_invType[2].checked) {
				    	invType = "H";
				    	invTypeMsg = "VDT";
				    } else if(formObj.btn_invType[3].checked) {
				    	invType = "D";
				    	invTypeMsg = "VAT";
				    } else if(formObj.btn_invType[4].checked) {
				    	invType = "R";
				    	invTypeMsg = "VAT";
				    } else if(formObj.btn_invType[5].checked) {
				    	invType = "M";
				    	invTypeMsg = "VAT";
				    } else if(formObj.btn_invType[6].checked) {
				    	invType = "S";
				    	invTypeMsg = "VST";
				    } else if(formObj.btn_invType[7].checked) {
				    	invType = "C";
				    	invTypeMsg = "VCT";
				    } else if(formObj.btn_invType[8].checked) {
				    	invType = "E";
				    	invTypeMsg = "VRT";
				    } else if(formObj.btn_invType[9].checked) {
				    	invType = "X";
				    	invTypeMsg = "VAT";
				    }
				    switch(invType) {
					    case "T":
					    case "H":
					    case "S":
					    case "C":
					    case "E":
					    case "X":
						
					    	formObj.f_cmd.value = SEARCH02;		
					    	
					    	var blNos = "";
					    	// Single 
					    	if(!formObj.btn_issOpt[1].checked) {
					    	
							    for (var i = 0; i < sheetObj.RowCount; i++) {
							    	for (var j = 0; j < 5; j++) {
							    		if (sheetObj.CellValue(i+1, j) != ""){
							    			blNos = blNos + "[" + sheetObj.CellValue(i+1, j) + "]";
							    		}
							    	}
							    }
							// Combined
					    	} else {
					    		blNos  = "";
					    	}
					    	formObj.inv_no_list.value = blNos;
					    	
						    var sXml = sheetObj.GetSaveXml("FNS_INV_0036GS.do", FormQueryString(formObj));
							var invNoCnt = ComGetEtcData(sXml, "invNoCnt");
							var chgCd = ComGetEtcData(sXml, "chg_cd");

							if(invNoCnt == "-1") {
		    					ComShowCodeMessage("INV00097");
		    					return false;
		    				} else if(invNoCnt == "-2") {
		    					ComShowCodeMessage("INV00098");
		    					return false;
		    				} else {
		    					var vat_exist = ComGetEtcData(sXml, "vatExist");
							    // 해당vat가 존재하지 않을 경우
		    					if (vat_exist != "vat_exist") {
						    		
							    	// 입력된 BL의 갯수를 취득한다.
							    	var arrBlNos = blNos.split("]");
							    	// 이슈 타입이 Single 이고 입력된 BL의 갯수가 1개(arrBlNos.length == 2)인 경우
									if(formObj.btn_dtOpt[0].checked &&  arrBlNos.length == 2){
										if(invType == "X" && chgCd == "VET"){
											invTypeMsg = "VET";
										}
						    			if(!ComShowConfirm(ComGetMsg("INV00141",invTypeMsg))){
						    				return false;
						    			} else { return true;}
						    		} else {
						    			var vatNoExistBlNo = ComGetEtcData(sXml, "vatNoExistBlNo");
						    			if(invType == "X" && chgCd == "VET"){
											invTypeMsg = "VET";
										}else if(invType == "X" && chgCd == "VETTVA"){
											invTypeMsg = invTypeMsg + ",VET";
										}
						    			if(!ComShowConfirm(ComGetMsg("INV00142",invTypeMsg,vatNoExistBlNo))){
						    				return false;
						    			} else { return true;}
						    		}
						    	} else {
						    		return true;
			    				}
		    				}
					    	break; 
					    	
					    case "F":
					    case "R":
					    case "M":
					    case "D":
					    	return true;
					    	break;
				    }
	     		}
	     		break;
     		case IBSEARCH_ASYNC01: //체크
     		if(validateForm(sheetObj,formObj,sAction)) {
     			var arrArOfcCd = formObj.combo_ar_ofc_cd.Code.split("^");
			    formObj.ar_ofc_cd.value = arrArOfcCd[1];
			    var invType = "";
			    var invTypeMsg = "";
			    if(formObj.btn_invType[0].checked) {
			    	invType = "F";
			    	invTypeMsg = "VAT";
			    } else if(formObj.btn_invType[1].checked) {
			    	invType = "T";
			    	invTypeMsg = "VTT";
			    } else if(formObj.btn_invType[2].checked) {
			    	invType = "H";
			    	invTypeMsg = "VDT";
			    } else if(formObj.btn_invType[3].checked) {
			    	invType = "D";
			    	invTypeMsg = "VAT";
			    } else if(formObj.btn_invType[4].checked) {
			    	invType = "R";
			    	invTypeMsg = "VAT";
			    } else if(formObj.btn_invType[5].checked) {
			    	invType = "M";
			    	invTypeMsg = "VAT";
			    } else if(formObj.btn_invType[6].checked) {
			    	invType = "S";
			    	invTypeMsg = "VST";
			    } else if(formObj.btn_invType[7].checked) {
			    	invType = "C";
			    	invTypeMsg = "VCT";
			    } else if(formObj.btn_invType[8].checked) {
			    	invType = "E";
			    	invTypeMsg = "VRT";
			    } else if(formObj.btn_invType[9].checked) {
			    	invType = "X";
			    	invTypeMsg = "VAT";
			    }
			    switch(invType) {
				    case "T":
				    case "H":
				    case "S":
				    case "C":
				    case "E":
				    case "X":
					    formObj.f_cmd.value = SEARCH01;
						var sXml = sheetObj.GetSaveXml("FNS_INV_0036GS.do", FormQueryString(formObj));
						var blList = ComGetEtcData(sXml, "blList");
						var chgCd = ComGetEtcData(sXml, "chgCd");
						if(blList == "-1") {
	    					ComShowCodeMessage("INV00097");
	    					return false;
	    				}else if(blList == "-2") {
	    					ComShowCodeMessage("INV00136",chgCd);
	    					return false;
	    				} else {
	    					return true;
	    				}
				    	break; 
				    	
				    case "F":
				    case "R":
				    case "M":
				    case "D":
				    	return true;
				    	break;
			    }
     		}
     		break;
     	}
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리<br>
     *
     * @param {object} sheetObj
     * @param {object} formObj
     * @param {int} sAction
     * @return bool;
     */
    function validateForm(sheetObj,formObj,sAction){
    	var expt = "";

    	if (!(formObj.btn_issBy[0].checked || formObj.btn_issBy[1].checked)) {
			 ComShowCodeMessage("INV00004");
			 formObj.btn_issBy[1].checked = true;
			 setBlNoRow(sheetObj);
			 return false;
   	 	}

    	if(formObj.btn_issBy[1].checked) {
    		var cnt = 0;
		    for(var i=0; i<sheetObj.RowCount; i++) {
		    	for(var j=0; j<5; j++) {
		    		if(sheetObj.CellValue(i+1, j) != "") {
		    			cnt++;
		    		}
		    	}
		    }
		    if(cnt == 0) {
    			ComShowCodeMessage("INV00004");        			
    			sheetObj.SelectCell(1,0);
    			return false;
    		}

		    expt = expt + "|cust_cnt_cd|cust_seq";
    	}

    	if(formObj.btn_issBy[1].checked) {
    		expt = expt + "|cust_cnt_cd|cust_seq|from_dt|to_dt";
    	}
    	
    	if(formObj.btn_invType[2].checked) {
    		expt = expt + "|xch_rt_dt";
    	} else {
	    	if(formObj.xch_rt.value == "0"||formObj.xch_rt.value == "") {
	    		ComShowCodeMessage("INV00098");
	    		formObj.xch_rt_dt.select();
	    		return false;
	    	}
    	}
    	
    	expt = expt + "|cust_seq";
    	if(formObj.btn_issBy[0].checked) {
    		if (formObj.cust_cnt_cd.value == "") {
    			ComShowCodeMessage("INV00004");
   			 	formObj.cust_cnt_cd.focus();
   			 	return false;
   		 	}
    		
	    	if (formObj.cust_seq.value == "") {
	    		ComShowCodeMessage("INV00004");
	    		formObj.cust_seq.focus();
	    		return false;
	    	}
    	}

    	if (!invChkValid(formObj, expt)) {
      		return false;
       	}
        return true;
    }

    /**
     * 업무 자바스크립트 OnLoadFinish 이벤트 처리한다.<br>
     * 
     * @param {object} sheetObj
     * @return 없음
     */
    function sheet1_OnLoadFinish(sheetObj) {
    	form.event_type.value = "open";
     	doActionIBSheet(sheetObj,document.form,IBSEARCH,"3");
     	form.event_type.value = "";

    	setBlNoRow(sheetObj);
    	inputReadOnly(0);
    	setInvTypeDisabled();
    }

    /**
     * B/L No.를 입력하기 위한 Row를 생성한다.<br>
     * 
     * @param {object} sheetObj
     * @return 없음
     */
    function setBlNoRow(sheetObj) {
    	for(var i=0; i<20; i++){
    		sheetObj.DataInsert(-1);
   	 	}
    	sheetObj.SelectCell(1,0);
    }
     
    /**
     * 콤보박스를 설정한다.<br>
     * 
     * @param {object} cmbObj
     * @param {String} arrStr
     * @return 없음
     * @see #doActionIBSheet
     */
 	function MakeComboObject(cmbObj, arrStr) {
 		for (var i = 1; i < arrStr.length;i++ ) {
 			var arrStr2 = arrStr[i].split("^");
 			var ar_ofc_cd = arrStr2[1];
 			cmbObj.InsertItem(i-1, ar_ofc_cd, arrStr[i]);			 
 		}
 		cmbObj.DropHeight = 190;
 	}

    /**
     * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다.<br>
     *
     * @return 없음
     * @see #initControl
     */
    function obj_activate() {
    	ComClearSeparator(event.srcElement);
    	if(event.srcElement.dataformat == "ymd") {
    		if(event.srcElement.name == "from_dt") {
    			form.from_dt.select();
    		} else if(event.srcElement.name == "to_dt") {
    			form.to_dt.select();
    		} else if(event.srcElement.name == "xch_rt_dt") {
    			form.xch_rt_dt.select();
    		}
    	}
    }
     
    /**
     * HTML Control의 onblur이벤트에서 Effective Date의 Validation을 체크한다.<br>
     *
     * @return 없음
     * @see #initControl
     */
    function obj_deactivate(){
    	if((event.srcElement.dataformat == "ymd") ||
    	   (event.srcElement.name == "cust_cnt_cd")) {
    		if(event.srcElement.name == "xch_rt_dt") {
    			var xchRtDt = form.xch_rt_dt.value;
    			if(xchRtDt.length == 8) {
    				if(ComChkObjValid(event.srcElement)) {
    					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "3");
    					if(form.btn_issBy[0].checked) {
    						form.cust_cnt_cd.focus();
    					} else if(form.btn_issBy[1].checked) {
    						sheetObjects[0].SelectCell(1,0);
    					}
    				}
    			}
    		} else {
    			ComChkObjValid(event.srcElement);
    		}
       	} else if (event.srcElement.name == "cust_seq"){
       		// 자리수 채우기           
        	var formObject = document.form;
        	var tmp = "";
            if (form.cust_seq.value.length != 0 && form.cust_seq.value.length < 6) {
            	for(i = 0; i < 6 - form.cust_seq.value.length; i++){
            		tmp = tmp + "0";
            	}
        		document.form.cust_seq.value = tmp + document.form.cust_seq.value;
        	}
            
            var custCntCd = form.cust_cnt_cd.value;
            var custSeq = form.cust_seq.value;
            if((custCntCd.length == 2) &&
               (custSeq.length == 6)) {
            	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "2");
            }
       	}
    }
      
    /**
     * HTML Control의 onkeypress 이벤트에서 숫자와 영문만 입력가능하게 처리한다.<br>
     * 
     * @return 없음
     * @see #initControl
     */
    function obj_keypress(){
     	if((event.srcElement.dataformat == "ymd") ||
     	   (event.srcElement.dataformat == "int")) {
     		ComKeyOnlyNumber(event.srcElement);
    	} else if(event.srcElement.name == "cust_cnt_cd") {
    		ComKeyOnlyAlphabet('upper');
    	}
    }
    
    /**
     * HTML Control의 onkeyup 이벤트에서 country입력 후 custmer Seq항목으로 이동한다.<br>
     * 
     * @return 없음
     * @see #initControl
     */
    function obj_keyup() {
    	if(event.srcElement.name == "cust_cnt_cd") {
    		var custCntCd = form.cust_cnt_cd.value;
    		if(custCntCd.length == 2) {
    			form.cust_seq.focus();
    		}
		} else if(event.srcElement.name == "from_dt") {
			var fromDt = form.from_dt.value;
    		if(fromDt.length == 8) {
    			if(ComChkObjValid(event.srcElement)) {
	    			//form.to_dt.value = fromDt;
	    			form.to_dt.focus();
    			}
    		}
		}
    }
     
    /**
     * Quick Customer Search 팝업에서 호출하는 함수<br>
     * 
     * @param {array} aryPopupData
     * @return 없음
     */ 
   	function setCustCd(aryPopupData) {
   		var colArray = aryPopupData[0];
   		form.cust_cnt_cd.value = colArray[8];
   		form.cust_seq.value = ComLpad(colArray[9], 6, '0');
   		form.cust_nm.value = colArray[4];
   	}
     
    /**
     * 조건에 따라 해당 오브젝트의 사용여부를 설정한다.<br>
     * 
     * @param {int} flag
     * @return 없음
     */
    function inputReadOnly(flag) {
    	if(form.btn_issBy[0].checked) {
    		form.cust_cnt_cd.readOnly= false;
    		form.cust_seq.readOnly= false;
    		form.cust_cnt_cd.className = "input1";
    		form.cust_seq.className = "input1";
    		document.images["btn_custInfo"].name = "btn_custInfo";
    		form.btn_custInfo.style.cursor = "hand";
    		document.images["btn_custCd"].name = "btn_custCd";
    		form.btn_custCd.style.cursor = "hand";
    	} else {
    		form.cust_cnt_cd.readOnly= true;
    		form.cust_seq.readOnly= true;
    		form.cust_cnt_cd.className = "input2";
    		form.cust_seq.className = "input2";
    		document.images["btn_custInfo"].name = "no_btn_custInfo";
    		form.btn_custInfo.style.cursor = "default";
    		document.images["btn_custCd"].name = "no_btn_custCd";
    		form.btn_custCd.style.cursor = "default";
    		
    		form.cust_cnt_cd.value = "";
    		form.cust_seq.value = "";
    		form.cust_nm.value = "";
    		form.cust_rgst_no.value = "";
    		form.cr_curr_cd.value = "";
    		form.cr_amt.value = "";
    		form.phn_no.value = "";
    		form.fax_no.value = "";
    		form.cntc_pson_nm.value = "";
    	}

    	if(form.btn_issBy[1].checked) {
    		form.from_dt.value = "";
    		form.to_dt.value = "";
    		form.from_dt.readOnly = true;
    		form.to_dt.readOnly = true;
    		form.from_dt.className = "input2";
    		form.to_dt.className = "input2";
    		document.images["btn_fromDt"].name = "no_btn_fromDt";
    		form.btn_fromDt.style.cursor = "default";
    		document.images["btn_toDt"].name = "no_btn_toDt";
    		form.btn_toDt.style.cursor = "default";
    		
    		if(sheetObjects[0].RowCount == 0) {
    			setBlNoRow(sheetObjects[0]);
    		}
    	} else {
    		form.from_dt.readOnly = false;
    		form.to_dt.readOnly = false;
    		form.from_dt.className = "input1";
    		form.to_dt.className = "input1";
    		document.images["btn_fromDt"].name = "btn_fromDt";
    		form.btn_fromDt.style.cursor = "hand";
    		document.images["btn_toDt"].name = "btn_toDt";
    		form.btn_toDt.style.cursor = "hand";
    		
    		sheetObjects[0].RemoveAll();
    	}
    }

    /**
     * Invoice Type에 따라 Combined활성화 여부를 체크한다.<br>
     * 
     * @return 없음
     */
    function setInvTypeDisabled() {
    	var invType = "";
    	
    	if(form.btn_invType[0].checked) {
    		form.btn_issOpt[1].disabled = false;
    		form.xch_rt_dt.readOnly = false;
    		form.xch_rt_dt.className = "input1";
    		document.images["btn_xchRtDt"].name = "btn_xchRtDt";
    		form.btn_xchRtDt.style.cursor = "hand";
    		if(form.xch_rt_dt.value == "") {
    			setExRateDt();
    		}
    		invType = "FRT";
    	} else if(form.btn_invType[1].checked) {
    		form.btn_issOpt[1].disabled = false;
    		form.xch_rt_dt.readOnly = false;
    		form.xch_rt_dt.className = "input1";
    		document.images["btn_xchRtDt"].name = "btn_xchRtDt";
    		form.btn_xchRtDt.style.cursor = "hand";
    		if(form.xch_rt_dt.value == "") {
    			setExRateDt();
    		}
    		invType = "THC";
    	} else if(form.btn_invType[2].checked) {
    		form.btn_issOpt[1].disabled = false;
    		form.xch_rt_dt.value = "";
    		form.xch_rt_dt.readOnly = true;
    		form.xch_rt_dt.className = "input2";
    		form.xch_rt.value = "";
    		document.images["btn_xchRtDt"].name = "no_btn_xchRtDt";
    		form.btn_xchRtDt.style.cursor = "default";
    		invType = "DHF";
    	} else if(form.btn_invType[3].checked) {
    		form.btn_issOpt[0].checked = true;
    		form.btn_issOpt[1].disabled = false;
    		form.btn_issBy[1].disabled = false;
    		form.xch_rt_dt.readOnly = false;
    		form.xch_rt_dt.className = "input1";
    		document.images["btn_xchRtDt"].name = "btn_xchRtDt";
    		form.btn_xchRtDt.style.cursor = "hand";
    		if(form.xch_rt_dt.value == "") {
    			setExRateDt();
    		}
    		invType = "DMR";
    	} else if(form.btn_invType[4].checked) {
    		form.btn_issOpt[0].checked = true;
    		form.btn_issOpt[1].disabled = true;
    		form.btn_issBy[1].disabled = false;
    		form.xch_rt_dt.readOnly = false;
    		form.xch_rt_dt.className = "input1";
    		document.images["btn_xchRtDt"].name = "btn_xchRtDt";
    		form.btn_xchRtDt.style.cursor = "hand";
    		if(form.xch_rt_dt.value == "") {
    			setExRateDt();
    		}
    		invType = "MNR";
    	} else if(form.btn_invType[5].checked) {
    		form.btn_issOpt[0].checked = true;
    		form.btn_issOpt[1].disabled = true;
    		form.btn_issBy[1].disabled = false;
    		form.xch_rt_dt.readOnly = false;
    		form.xch_rt_dt.className = "input1";
    		document.images["btn_xchRtDt"].name = "btn_xchRtDt";
    		form.btn_xchRtDt.style.cursor = "hand";
    		if(form.xch_rt_dt.value == "") {
    			setExRateDt();
    		}
    		invType = "MRI";
    	} else if(form.btn_invType[6].checked) {
    		form.btn_issOpt[1].disabled = false;
    		form.xch_rt_dt.readOnly = false;
    		form.xch_rt_dt.className = "input1";
    		document.images["btn_xchRtDt"].name = "btn_xchRtDt";
    		form.btn_xchRtDt.style.cursor = "hand";
    		if(form.xch_rt_dt.value == "") {
    			setExRateDt();
    		}
    		invType = "SLF";
    	} else if(form.btn_invType[7].checked) {
    		form.btn_issOpt[1].disabled = false;
    		form.xch_rt_dt.readOnly = false;
    		form.xch_rt_dt.className = "input1";
    		document.images["btn_xchRtDt"].name = "btn_xchRtDt";
    		form.btn_xchRtDt.style.cursor = "hand";
    		if(form.xch_rt_dt.value == "") {
    			setExRateDt();
    		}
    		invType = "CLN";
    		
    	//2010-07-19 TYPE REF 추가
    	}  else if(form.btn_invType[8].checked) {
    		form.btn_issOpt[1].disabled = false;
    		form.xch_rt_dt.readOnly = false;
    		form.xch_rt_dt.className = "input1";
    		document.images["btn_xchRtDt"].name = "btn_xchRtDt";
    		form.btn_xchRtDt.style.cursor = "hand";
    		if(form.xch_rt_dt.value == "") {
    			setExRateDt();
    		}
    		invType = "REF";
    	//2010-11-08 TYPE ETC 추가
    	}  else if(form.btn_invType[9].checked) {
    		form.btn_issOpt[1].disabled = false;
    		form.xch_rt_dt.readOnly = false;
    		form.xch_rt_dt.className = "input1";
    		document.images["btn_xchRtDt"].name = "btn_xchRtDt";
    		form.btn_xchRtDt.style.cursor = "hand";
    		if(form.xch_rt_dt.value == "") {
    			setExRateDt();
    		}
    		invType = "ETC";
    	}
    	
    	form.inv_type.value = invType;
    }
    
    /**
  	 * Ex.Rate Date에 오늘 일자 세팅한다.<br>
  	 * 
  	 * @return 없음
  	 * @see #sheet1_OnLoadFinish
  	 */
  	function setExRateDt() {
//      var now=new Date();
//
//      var y=now.getYear()+"";
//      var M=now.getMonth()+1;
//      if (M < 10) M = '0'+M;
//      var d=now.getDate();
//      if (d < 10) d = '0'+d;

//      document.form.xch_rt_dt.value = ComGetMaskedValue(y+M+d, "ymd");
  		var xchRtDt = document.form.xch_rt_dt1.value;
		document.form.xch_rt_dt.value = xchRtDt.substring(0,4) + "-" + xchRtDt.substring(4,6) + "-" + xchRtDt.substring(6,8);
		
		if(xchRtDt.length == 8) {
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "3");
		}
		
		document.form.xch_rt_dt.value = xchRtDt.substring(0,4) + "-" + xchRtDt.substring(4,6) + "-" + xchRtDt.substring(6,8);
		
		
  	}

  	/**
 	 * 폼 개체 안에 모든 컨트롤의 Validation을 확인한다. <br>
 	 * 모든 컨트롤이 아닌 특정 하나의 컨트롤을 체크하고자 한다면 {@link #ComChkObjValid} 함수를 이용한다. <br>
 	 * bMsg 인자가 true이면 Validation이 정확하지 않은 경우 경고 메시지를 표시한다. <br>
 	 * bTrim 인자가 true이면 obj.value 확인 시 값을 trim하여 validation을 확인한다. <br>
 	 * bMasked 인자가 true이면 Validation이 정확한 경우 Format에 맞게 Masking 한값을 obj.value에 설정한다. <br>
 	 * Validation을 확인하기 위해서는 각 컨트롤 태그에 maxlength속성과 사용자 정의 속성인 required, minlength, caption, dataformat, fullfill, cofield, maxnum, minnum속성을 설정해주어야 한다. 다음과 같이 설정한다. <br>
 	 *     &lt;input type="text" name="txtDate" <font color="red">caption="입사일" maxlength="10" dataformat="ymd" required  fullfill maxnum="100" minnum="0" cofield="" </font>&gt; <br>
 	 * 위와 같은 속성을 설정함으로써 이 함수는 다음과 같은 처리를 한다. <br>
 	 * (1) maxlength  : 입력 최대 길이 확인, UTF-8기준으로 길이를 체크하므로, 한글은 3Byte로 된다.<br>
 	 * (2) minlength  : 입력 최소 길이 확인, 값이 있다면 최소 길이만큼 입력해야 한다. <br>
 	 * (3) dataformat : 데이타 포멧으로 Validation 확인<br>
 	 * <pre>
 	 *  - "ymd"      : yyyy-mm-dd
 	 *  - "ym"       : yyyy-mm
 	 *  - "hms"      : hh:mm:ss
 	 *  - "hm"       : hh:mm
 	 *  - "saupja"   : ###-##-#####
 	 *  - "jumin"    : ######-#######
 	 *  - "int"      : #,###
 	 *  - "float"    : #,###.###
 	 *  - "eng"      : 영문만
 	 *  - "engup"    : 영문 대문자만
 	 *  - "engdn"    : 영문 소문자만
 	 * </pre>
 	 * (4) required  : 필수입력 여부 확인, 값이 ""이면 에러 메시지 표시<br>
 	 * (5) caption   : EndUser를 위한 메시지 처리를 위한 컨트롤 표시 title<br>
 	 * (6) fullfill  : maxlength속성 만큼 글자를 모두 입력해야 하는 경우, 값이 ""이면 체크 안함<br>
 	 * (7) pointcount: dataformat="float" 인 경우 소숫점 아랫자리 수<br>
 	 * (8) maxnum    : 숫자인 경우 최대값<br>
 	 * (9) minnum    : 숫자인 경우 최소값<br>
 	 * (10) cofield  : 기간인 경우 시작일과 종료일 html태그에 이 속성을 설정해야 하며, 시작일은 종료일 name을 종료일은 시작일 name을 설정한다. <br>
 	 * <br>
 	 * &lt;input type="radio"&gt;의 경우 같은 name으로 여러개를 만든다면 첫번째 태그에만 위 속성을 설정해준다. 예를 들어 다음과 같다. <br>
 	 *     &lt;input type="radio" name="rdoCity" value="01" required caption="도시"&gt;서울<br>
 	 *     &lt;input type="radio" name="rdoCity" value="02"&gt;대전<br>
 	 *     &lt;input type="radio" name="rdoCity" value="03"&gt;대구<br>
 	 * 위 속성은 필요한것만 골라서 사용한다. 굳이 모든 속성을 다 설정할 필요는 없다. 그러나 속성을 하나라도 추가 한다면 caption속성은 설정해야 메시지 처리에 가독성을 높일수 있다.<br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 *     if(!ComChkValid(document.frmMaster)) return;   //frmMaster폼안에 모든 오브젝트의 Validation을 확인한다.
 	 * </pre>
 	 * @param {form}   frm          필수,대상 Form 오브젝트
 	 * @param {string} exptElems    선택,제외대상 오브젝트명
 	 * @param {bool}   bMsg         선택,각종메시지 표시 여부, default=true
 	 * @param {bool}   bTrim        선택,데이터 Trim후 확인할지 여부, default=true
 	 * @param {bool}   bMasked      선택,Validation이 정확하면 Format에 맞게 Masking한 값을 obj.value에 설정하지 여부, default=false
 	 * @returns bool <br>
 	 *          false - Validation이 정확하지 않은 경우<br>
 	 *          true  - Validation이 정확한 경우
 	 * @see #validateForm
 	 */
 	function invChkValid(frm, exptElems, bMsg, bTrim, bMasked){
 	    try {
 	        var elems   = frm.elements;
 	
 	        if (bMsg==undefined || bMsg==null)          bMsg = true;
 	        if (bTrim==undefined || bTrim==null)        bTrim = true;
 	        if (bMasked==undefined || bMasked==null)    bMasked = false;
 	
 	        for(var i = 0; i < elems.length; i++) {
 	            var elem = elems[i];
 	            
 	            // 제외대상 오브젝트명을 포함하고 있으면  validation체크를 하지 않는다.
 	            if(exptElems.indexOf(elem.name) >= 0) {
 	            	continue;
 	            }
 	
 	            //radio인 경우 같은 이름으로 여러개 있는 경우
 	            if (elem.type =="radio") {
 	                if (elem.name == null || elem.name=="") continue;
 	                var elem = document.all[elem.name];
 	                //첫번째 radio만 "required"속성이 있는지 체크한다. 나머지 건너뛰기
 	                if(elem.length>1) i += (elem.length-1);
 	            }
 	
 	            //Validation을 체크하여 false가 나오면 종료함
 	            if (!ComChkObjValid(elem, bMsg, bTrim, bMasked)) return false;
 	        }
 	    } catch(err) { ComFuncErrMsg(err.message); }
 	
 	    return true;
 	}
 	 
 	/**
 	 * RD Object 초기화<br>
 	 * 
 	 * @return 없음
   	 * @see #loadPage
      */
  	function initRdConfig(rdObject){
  		var Rdviewer = rdObject;
  		Rdviewer.style.height = 0;
  		Rdviewer.style.width = 0;
   	    
  		Rdviewer.AutoAdjust = true;
  		Rdviewer.ViewShowMode(0);
   	    
  		Rdviewer.setbackgroundcolor(128,128,128);
  		Rdviewer.SetPageLineColor(128,128,128);
   	}
  	
  	function rdOpenPreview(issType,blList){
  		var formObj = document.form;
  		var Rdviewer = rdObjects[0];
  		var arrBlNo = blList.split("|");
  		var ofcCd = formObj.ofc_cd.value;
  		var arOfcCd = formObj.ar_ofc_cd.value;
  		var vnInvPayMzdCd = formObj.method_pay.value;
  		
  		var invRt = ComReplaceStr(formObj.xch_rt.value,",","");
  		var invType = "";
  		var rdFiles = "";
  		var rdParam = "";
  		
  		if(form.btn_invType[0].checked) {
  			invType = "F";
  		} else if(form.btn_invType[1].checked) {
  			invType = "T";
  		} else if(form.btn_invType[2].checked) {
  			invType = "H";
  		} else if(form.btn_invType[3].checked) {
  			invType = "D";
  		} else if(form.btn_invType[4].checked) {
  			invType = "R";
  		} else if(form.btn_invType[5].checked) {
  			invType = "M";
  		} else if(form.btn_invType[6].checked) {
  			invType = "S";
  		} else if(form.btn_invType[7].checked) {
  			invType = "C";
  			
  		//2010-07-19 TYPE REF 추가
  		} else if(form.btn_invType[8].checked) {
  			invType = "E";
  		//2010-11-08 TYPE ETC 추가
  		} else if(form.btn_invType[9].checked) {
  			invType = "X";
  		}
  		for(var i=0; i<arrBlNo.length; i++){
  			if(arrBlNo[i] != ''){
  				if (issType == "S") {
  					rdFiles = rdFiles +"FNS_INV_0531_SINGLE_PREVIEW.mrd" +"|";					
				} else {
					rdFiles = rdFiles +"FNS_INV_0531_MULTI_PREVIEW.mrd" +"|";
				}
  				rdParam = rdParam + "/rv frm1_bl_src_no[" + arrBlNo[i] + "] frm1_ofc_cd [" + ofcCd + "] frm1_inv_gb[" + invType + "] frm1_ar_ofc_cd[" + arOfcCd + "] frm1_inv_rt[" + invRt + "] frm1_mth_py[" + vnInvPayMzdCd + "]" + "|";
  			}
  		}
  		
  		formObj.com_mrdPath.value = rdFiles ;
		formObj.com_mrdArguments.value = rdParam;
		ComOpenWindowCenter("FNS_INV_0034_02_prev.do?view_flag=S", "pop3", 800, 700);
  	}
  	
  	/**
   	 * 조회된 정보를 인쇄한다.<br>
   	 *
   	 * @return 없음
   	 */
    function rdOpen(issType){
    	/* 20170327 Print 기능 제거 --- 시작
  		if(form.inv_no_cnt.value == "") {
  			return;
  		}

  		var Rdviewer = rdObjects[0];
  		var arrInvNo = form.inv_no_list.value.split("|");
  		var ofcCd = form.ofc_cd.value;
  		var arOfcCd = form.ar_ofc_cd.value;
  		var invType = "";
  		var rdFile = "";
  		var vnInvPayMzdCd = form.method_pay.value;
  		
  		if(form.btn_invType[0].checked) {
  			invType = "F";
  		} else if(form.btn_invType[1].checked) {
  			invType = "T";
  		} else if(form.btn_invType[2].checked) {
  			invType = "H";
  		} else if(form.btn_invType[3].checked) {
  			invType = "D";
  		} else if(form.btn_invType[4].checked) {
  			invType = "R";
  		} else if(form.btn_invType[5].checked) {
  			invType = "M";
  		} else if(form.btn_invType[6].checked) {
  			invType = "S";
  		} else if(form.btn_invType[7].checked) {
  			invType = "C";
  		//2010-07-19 TYPE REF 추가
  		} else if(form.btn_invType[8].checked) {
  			invType = "E";
  		//2011-11-08 TYPE ETC 추가
  		} else if(form.btn_invType[9].checked) {
  			invType = "X";
  		}

 		for(var i=0; i<arrInvNo.length; i++){
 			
 			var rdParam = "/rv " + "frm1_inv_no[" + arrInvNo[i] + "] frm1_ofc_cd [" + ofcCd + "] frm1_inv_gb[" + invType + "] frm1_ar_ofc_cd[" + arOfcCd + "] frm1_mth_py[" + vnInvPayMzdCd + "]" + "|";
 			 			
 			var rdUrl = "apps/alps/fns/inv/accountreceivableinvoicemgt/invoiceissue/report/";
 			if(issType == "S") {
 				rdFile = "FNS_INV_0520_SINGLE.mrd";
 			} else {
 				rdFile = "FNS_INV_0520_MULTI.mrd";
 			}
 			Rdviewer.FileOpen(RD_path + rdUrl + rdFile, RDServer + rdParam+ "/rpagenuminit [1] /riprnmargin /rwait");
 			Rdviewer.SetAppendReport(1);

//			form.com_mrdPath.value = rdUrl + rdFile;
//			form.com_mrdArguments.value = form.com_mrdArguments.value + rdParam;
 		}
 		Rdviewer.CMPrint();
 		Rdviewer.SetAppendReport(0);
    	20170327 Print 기능 제거 --- 끝 */ 

 		setPaperIssueDisable();
 		
// 		sw=screen.availWidth;
//		sh=screen.availHeight;
//		px=(sw-622)/2;
//		py=(sh-760)/2;
//		var prevWin = window.open("apps/alps/fns/inv/accountreceivableinvoicemgt/invoiceissue/jsp/FNS_INV_0034_02_prev.jsp?view_flag=I", 
//  			   					  "FNS_INV_0034_02","scrollbars=no,fullscreen=no,width=640,height=780,left="+px+",top="+py);
//		prevWin.focus();
 	}

   	/**
     * Paper Issue버튼을 비활성화한다.<br>
     *
     * @return 없음
     */
   	function setPaperIssueDisable() {
   		ComBtnDisable("btn_paperissue");
   	}

    /**
     * 선택된 B/L을 Issue처리한다.(FNS_INV_0088 Popup 창에서 호출)<br>
     *
     * @return 없음
     */
    function saveCombine() {
    	doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
    }
     
    /**
     * B/L 번호 중복 체크 <br>
	 *
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {String} value ibsheet 해당 row, col의 값
     * @return 없음
     */     
    function blNoDupChk(sheetObj,Value){
    	var cnt = 0;
        for (var i=1; i<=sheetObj.RowCount; i++) {
        	for (var j=0; j<5; j++) {
        		if (Value != "" && Value == sheetObj.CellValue(i, j)) {        			
        			cnt++;
        			if (cnt > 1) {
        				ComShowCodeMessage("INV00017");
        				sheetObj.CellValue(i, j) = "";
        				return;
        			}
        		}
        	}
        }
    }

    /**
     * 시트값 변경시 이벤트 처리 <br>
	 *
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row ibsheet 해당 row
     * @param {int} Col ibsheet 해당 col
     * @param {String} value ibsheet 해당 row, col의 값
     * @return 없음
     */   
    function sheet1_OnChange(sheetObj,Row,Col,Value){
    	if(form.btn_issBy[1].checked) {
    		blNoDupChk(sheetObj, Value);
    	}
    }
    
    function dtOpt_chk(){
	    if(form.btn_dtOpt[0].checked){
			form.dt_opt.value = "G";
			form.iss_type.value = "SINGLE";
		} else if(form.btn_dtOpt[1].checked) {
			form.dt_opt.value = "S";
			form.iss_type.value = "MULTI";
		}
    }

    /**
     * Office 변경시 이벤트 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     ar_ofc_cd_OnChange(comboObj,value,text);
     * </pre>
     * @param {ibCombo} cmbObj 필수 IBCombo Object
     * @param {String} value cmbObj value
     * @param {String} text cmbObj text
     * @return 없음
     * @author 정휘택
     * @version 2009.10.20
     */
    function combo_ar_ofc_cd_OnChange(comboObj,value,text) {
    	if(document.form.event_type.value != "open"){
    		document.form.event_type.value = "";
    		document.form.event_ofc.value = "ofc";
    		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"3","Y");
    		document.form.event_ofc.value = "";
    	}
    }
 	/* 개발자 작업  끝 */