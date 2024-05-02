/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0079.js
*@FileTitle : Unmatched Revenue VVD Inquiry
*			  (기 생성된 Revenue VVD정보가 갱신되어야 하는 대상을 조회
*			   Booking정보 기준으로 Revenue Lane, VVD가 변경된 내용
*			       대상데이타 메뉴얼 BKG I/F)
*Open Issues :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.10.06 최우석
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
	 * @class FNS_INV_0079 : FNS_INV_0079 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function FNS_INV_0079() {
		this.processButtonClick		= processButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl            = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.validateForm 			= validateForm;
		this.obj_activate			= obj_activate;
		this.obj_deactivate			= obj_deactivate;
		this.obj_keypress			= obj_keypress;
		this.getBatchJobStatus		= getBatchJobStatus;
		this.inputReadOnly			= inputReadOnly;
		this.getBackEndJobStatus	= getBackEndJobStatus;
		this.closeOpenWait			= closeOpenWait;
	}

	/* 개발자 작업	*/

	// 공통전역변수

	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var timerBatch = null;
	var timerBackEndJob = null;

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

                case "btn_run":
                	sheetObject.RemoveAll();
                	doActionIBSheet(sheetObject,formObject,IBSEARCH, "2");
                    break;

                case "btn_interface":
                	doActionIBSheet(sheetObject,formObject,IBSAVE);
                    break;

                case "btn_retrive":
                    doActionIBSheet(sheetObject,formObject,IBSEARCH, "1");
                    break;

                case "btn_new":
                	ComResetAll();
                    break;

		        case "btn_downExcel":
		        	sheetObject.SpeedDown2Excel(-1,false,false,"","",false,false,"",false,"0|1");
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
        form.from_dt.focus();
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
            case 1:      //t1sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 460;
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
                    
                    var HeadTitle = "|All|Seq|OFC|I/F No.|B/L No.|Rev. VVD|New  VVD|AMT_TTL";
                    HeadTitle     +=   "|I/F Date|Good Date|Del.|Rev.Source|BKG No.|Zone IOC|New Lane|Old VVD";
                    HeadTitle     +=   "|Trunk VVD|Creation Date";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	0,    	daCenter,  	true,    "ibflag");
                    InitDataProperty(0, cnt++ , dtCheckBox,    	40,    	daCenter,  	true,    "rev_vvd_mtch_flg",    false,		"",      dfNone,		0,	true,	true,	0);
                    InitDataProperty(0, cnt++ , dtDataSeq,    	40,    	daCenter,  	true,    "seq",     			false,      "",      dfInteger,		0,	false,	false,	0);
                    InitDataProperty(0, cnt++ , dtData,    		70,    	daCenter,  	true,    "ar_ofc_cd",     		false,      "",      dfNone,		0,	false,	false,	0);
                    InitDataProperty(0, cnt++ , dtData,    		90,    	daCenter,  	true,    "ar_if_no",     		false,      "",      dfNone,		0,	false,	false,	0);
                    InitDataProperty(0, cnt++ , dtData,    		100,   	daCenter,  	true,    "bl_src_no",     		false,      "",      dfNone,		0,	false,	false,	0);
                    InitDataProperty(0, cnt++ , dtData,    		100,    daCenter,  	true,    "rev_vvd",     		false,      "",      dfNone,		0,	false,	false,	0);
                    InitDataProperty(0, cnt++ , dtData,    		100,    daCenter,  	true,    "new_vvd",     		false,      "",      dfNone,		0,	false,	false,	0);
                    InitDataProperty(0, cnt++ , dtData,    		90,     daRight,  	true,    "inv_ttl_locl_amt",    false,      "",      dfFloat,		2,	false,	false,	0);
                    InitDataProperty(0, cnt++ , dtData,    		80,     daCenter,  	true,    "bl_inv_if_dt",     	false,      "",      dfDateYmd,		0,	false,	false,	0);
                    InitDataProperty(0, cnt++ , dtData,    		80,     daCenter,  	true,    "bl_inv_cfm_dt",     	false,      "",      dfDateYmd,		0,	false,	false,	0);
                    InitDataProperty(0, cnt++ , dtData,    		30,    	daCenter,  	true,    "inv_delt_div_cd",     false,      "",      dfNone,		0,	false,	false,	0);
                    InitDataProperty(0, cnt++ , dtData,    		80,    	daCenter,  	true,    "rev_src_cd",     		false,      "",      dfNone,		0,	false,	false,	0);
                    InitDataProperty(0, cnt++ , dtData,    		100,   	daCenter,  	true,    "bkg_no",     			false,      "",      dfNone,		0,	false,	false,	0);
                    InitDataProperty(0, cnt++ , dtData,    		70,    	daCenter,  	true,    "zn_ioc_cd",     		false,      "",      dfNone,		0,	false,	false,	0);
                    InitDataProperty(0, cnt++ , dtData,    		70,    	daCenter,  	true,    "new_rlane_cd",     	false,      "",      dfNone,		0,	false,	false,	0);
                    InitDataProperty(0, cnt++ , dtData,    		100,    daCenter,  	true,    "old_vvd",     		false,      "",      dfNone,		0,	false,	false,	0);
                    InitDataProperty(0, cnt++ , dtData,    		100,    daCenter,  	true,    "trunk_vvd",     		false,      "",      dfNone,		0,	false,	false,	0);
                    InitDataProperty(0, cnt++ , dtData,    		120,    daCenter,  	true,    "log_rgst_dt",     	false,      "",      dfUserFormat2,	0,	false,	false,	0);
                    
                    SetSortDialog(false);
                    InitUserFormat2(0, "log_rgst_dt", "####-##-## ##:##:##", "-|:" );
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
   		axon_event.addListenerFormat('keypress', 'obj_keypress', form); 			//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
   		axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
   		axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
   		axon_event.addListenerForm ('keyup', 'obj_keyup', form);
   		
   	}

    /** Sheet관련 프로세스 처리<br>
     * 
     * @param {object} sheetObj
     * @param {object} formObj
     * @param {int} sAction
     * @param {string} flag
     * @return 없음
     * @see #processButtonClick
     */
    function doActionIBSheet(sheetObj,formObj,sAction, flag) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
        	case IBSEARCH:      //조회
       			if(flag == "1") {
           			formObj.f_cmd.value = SEARCH;
           			sheetObj.DoSearch("FNS_INV_0079GS.do", FormQueryString(formObj));
       			} else if(flag == "2") {
       				if(validateForm(sheetObj,formObj,sAction)) {
           				formObj.f_cmd.value = SEARCH01;
           				var sXml = sheetObj.GetSearchXml("FNS_INV_0079GS.do", FormQueryString(formObj));
						var arrXml = sXml.split("|$$|");
						var jobID = ComGetEtcData(arrXml[0], "jobID")
						doActionIBSheet(sheetObj,formObj,IBSEARCH, "1");
						/*
						if(typeof jobID != "undefined" && jobID != "" ) {
							inputReadOnly(2);
							formObj.batchJobID.value = jobID;
							sheetObj.WaitImageVisible = false;
							ComOpenWait(true);
							sheetObj.RequestTimeOut = 10000;
							timerBatch = setInterval(getBatchJobStatus, 3000);
						} else {
							// Failed to Run. Please try again.
							ComShowCodeMessage("INV00112", "Run");
						}
						*/
       				}
       			}
                break;
        	case IBSAVE:      // 저장
        		formObj.f_cmd.value = MULTI;
        		checkFlag(sheetObj);
			  	var param = FormQueryString(formObj) + "&" + sheetObjects[0].GetSaveString();
				var sXml = sheetObj.GetSaveXml("FNS_INV_0079GS.do", param);
				//var arrXml = sXml.split("|$$|");
				//var backEndJobKey = ComGetEtcData(arrXml[0], "backEndJobKey")
				/*
				if(typeof backEndJobKey != "undefined" && backEndJobKey != "" ) {
					inputReadOnly(2);
					formObj.backendjob_key.value = backEndJobKey;
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					sheetObj.RequestTimeOut = 10000;
					timerBackEndJob = setInterval(getBackEndJobStatus, 3000);
				} else {
					// Failed to Interface. Please try again.
					ComShowCodeMessage("INV00112", "Interface");
				}
				*/
				sheetObjects[0].LoadSaveXml(sXml);
				ComOpenWait(false);
				break;
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리<br>
     *
     * @param {object} sheetObj
     * @param {object} formObj
     * @param {int} sAction
     * @return bool
     * @see #doActionIBSheet
     */
    function validateForm(sheetObj,formObj,sAction){
    	if (!ComChkValid(formObj)) {
     		return false;
      	}
        return true;
    }
    
     
     /** 
 	 * HTML Control KeyUp 이벤트 호출<br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 * 
 	 * </pre>
 	 * @param 없음
 	 * @return 없음
 	 * @see #
 	 * @author 박정진
 	 * @version 2009.05.04
 	 */
 	function obj_keyup() {
 		var formObject = document.form;
 		switch (event.srcElement.name) {
 			case "from_dt":
 				var fromDt = ComReplaceStr(event.srcElement.value,"-","");
 				
 				if (fromDt.length == 8) {
 					formObject.to_dt.focus();
 				}
 	 		break;
 	 	}
 	}
 	
  	/**
     * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다.<br>
     *
     * @return 없음
     * @see #initControl
     */
    function obj_activate() {
    	var formObject = document.form;
 		
 		switch(event.srcElement.name){
 			case "from_dt":
 				//마스크 구분자 없애기
 				ComClearSeparator (event.srcElement);
 			break;
 			case "to_dt":
 				//마스크 구분자 없애기
 				ComClearSeparator (event.srcElement);
 			break;
 		}
    }
      
    /**
     * HTML Control의 onblur이벤트에서 Effective Date의 Validation을 체크한다.<br>
     *
     * @return 없음
     * @see #initControl
     */
    function obj_deactivate(){ 		
 		
        if((event.srcElement.name == "from_dt") ||
      	   (event.srcElement.name == "to_dt")) {
     		if(ComChkObjValid(event.srcElement) == true) {
 				startDt = form.from_dt.value.replace(/-/g,"");
 				endDt = form.to_dt.value.replace(/-/g,"");
 				if(startDt != "" && endDt != "") {
     				startDt = new Date(startDt.substring(0,4),startDt.substring(4,6)-1,startDt.substring(6,8));
     				endDt = new Date(endDt.substring(0,4),endDt.substring(4,6)-1,endDt.substring(6,8));
     				days = (endDt.getTime()-startDt.getTime())/(1000*60*60*24);
     				if(days > 31) {
     					ComShowCodeMessage("INV00024");
     					form.to_dt.value = "";
     					form.to_dt.focus();
     				}
 				} 				
     		}
      	}
      	
    }
     
    /**
     * HTML Control의 onkeypress 이벤트에서 숫자만 입력가능하게 처리한다.<br>
     * 
     * @return 없음
     * @see #initControl
     */
    function obj_keypress(){
    	if(event.srcElement.dataformat == "ymd") {
    		ComKeyOnlyNumber(event.srcElement);
    	}
    
    }
     
    /**
     * BatchJob 관련 Status='4' 이 될때까지 확인한다.<br>
     *
     * @return 없음
     * @see #doActionIBSheet
     */
    function getBatchJobStatus() {
 		form.f_cmd.value = SEARCH02;
 		var sXml = sheetObjects[0].GetSearchXml("FNS_INV_0079GS.do", FormQueryString(form));
 		var arrXml = sXml.split("|$$|");
 		var jobState = ComGetEtcData(arrXml[0], "jb_sts_flg")
 		if(jobState == "4") {
 			clearInterval(timerBatch);
 			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH, "1");
 			ComOpenWait(false);
 			inputReadOnly(1);
 	    } else if(jobState == "5") {
 	    	clearInterval(timerBatch);
 	    	// Failed to Run. Please try again.
			ComShowCodeMessage("INV00112", "Run");
 	    	ComOpenWait(false);
 	    	inputReadOnly(1);
 	    }
    }
     
    /**
     * 조건에 따라 해당 오브젝트의 사용여부를 설정한다.<br>
     * 
     * @param {int} flag
     * @return 없음
     * @see #getBatchJobStatus, #doActionIBSheet
     */
    function inputReadOnly(flag) {
    	if(flag == 1) {
    		ComBtnEnable("btn_run");
    		ComBtnEnable("btn_interface");
    		ComBtnEnable("btn_retrive");
    		ComBtnEnable("btn_new");
    		ComBtnEnable("btn_downExcel");
    		
    		form.from_dt.readOnly = false;
    		form.to_dt.readOnly = false;
    		form.bkg_if_flg.disabled = false;

    		document.images["btn_fromDt"].name = "btn_fromDt";
    		form.btn_fromDt.style.cursor = "hand";
    		document.images["btn_toDt"].name = "btn_toDt";
    		form.btn_toDt.style.cursor = "hand";
    		
    	} else if(flag == 2) {
    		ComBtnDisable("btn_run");
    		ComBtnDisable("btn_interface");
    		ComBtnDisable("btn_retrive");
    		ComBtnDisable("btn_new");
    		ComBtnDisable("btn_downExcel");
    		
    		form.from_dt.readOnly = true;
    		form.to_dt.readOnly = true;
    		form.bkg_if_flg.disabled = true;
    		
    		document.images["btn_fromDt"].name = "no_btn_fromDt";
    		form.btn_fromDt.style.cursor = "default";
    		document.images["btn_toDt"].name = "no_btn_toDt";
    		form.btn_toDt.style.cursor = "default";

    	}
    }
     
    /**
     * 저장할 대상을 체크한다.<br>
     * 
     * @param {object} sheetObj
     * @return 없음
     */
    function checkFlag(sheetObj) {
    	for(var row=1; row<=sheetObj.LastRow; row++) {
     		if(sheetObj.CellValue(row, "rev_vvd_mtch_flg") == "1") {
     			//sheetObj.CellValue2(row, "ibflag") = "U";
     			sheetObj.RowStatus(row) = "U";
     		}
     	}
    }

    /**
     * 업무 자바스크립트 OnLoadFinish 이벤트 처리한다.<br>
     * 
     * @param {object} sheetObj
     * @return 없음
     */
    function sheet_OnLoadFinish(sheetObj) {
    	var ofcCd = form.ofc_cd.value;
    	// SELXWP, SELADG 추가요청 HJS 김기용BJ.- 2010.06.15 CLT KHH
    	if(ofcCd != "SELPIO" && ofcCd != "SELXWP" && ofcCd != "SELADG") {
    		ComBtnDisable("btn_run");
    		ComBtnDisable("btn_interface");
    	}
    }
     
    /**
     * BackEndJob 관련 Status='3' 이 될때까지 확인한다.<br>
     *
     * @return 없음
     * @see #doActionIBSheet
     */
    function getBackEndJobStatus() {
    	form.f_cmd.value = SEARCH02;
  		var sXml = sheetObjects[0].GetSearchXml("FNS_INV_0028GS.do", FormQueryString(form));
  		var arrXml = sXml.split("|$$|");
  		var jobState = ComGetEtcData(arrXml[0], "jb_sts_flg")
  		if(jobState == "3") {
  			clearInterval(timerBackEndJob);
  			// Process Success.
  			ComShowCodeMessage("INV00111");
  			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH, "1");
  			ComOpenWait(false);
  			inputReadOnly(1);
  			
  	    } else if(jobState == "4") {
  	    	clearInterval(timerBackEndJob);
  	    	// Failed to Interface. Please try again.
			ComShowCodeMessage("INV00112", "Interface");
  	    	ComOpenWait(false);
  	    	inputReadOnly(1);

  	    } else if(jobState == "5") {
  	    	clearInterval(timerBackEndJob);
  	    	// Already Read Result File Of BackEndJob.
  	    	ComShowCodeMessage("INV00090");
  	    	ComOpenWait(false);
  	    	inputReadOnly(1);
  	    }
    }

    /**
     * 대기상태 ProgressBar를 닫는다.<br>
     * 
     * @return 없음
     **/
    function closeOpenWait() {
    	ComOpenWait(false);
    }
  
     
      /**
      * 시트를 클릭했을 때 처리
      *  2010.10.12  by Kim Hyunhwa
      */
     function sheet_OnClick(sheetObj, row, col) {
     	
     	 var rowCnt = sheetObj.RowCount;
         var rev_vvd_mtch_flg = sheetObj.CellValue(row,"rev_vvd_mtch_flg");
         var keyBlNo = sheetObj.CellValue(row,"bl_src_no");
         var colSaveName = sheetObj.ColSaveName(col);
          
         switch(colSaveName) {
 	       	case "rev_vvd_mtch_flg" :
 	
 	    		for(i=1; i<=rowCnt; i++) {
  	    		    			
 		    		if(rev_vvd_mtch_flg == 1) {
 		    			if(i == row) continue;
 		    			if(keyBlNo == sheetObj.CellValue(i, "bl_src_no")) {
 		    				sheetObj.CellValue2(i, "rev_vvd_mtch_flg") = 0;
 		    			}
 		    		} else if(rev_vvd_mtch_flg == 0) {
 		    			if(i == row) continue;
 		    			if(keyBlNo == sheetObj.CellValue(i, "bl_src_no")) {
 		    				sheetObj.CellValue2(i, "rev_vvd_mtch_flg") = 1;
 		    			}
 		    		}
 	    		}
 	    		break;
 	    	
         } // end switch
         
     }
    
    /* 개발자 작업  끝 */