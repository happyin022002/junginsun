/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ESM_PRI_0150.js
*@FileTitle : Korea MOF Filing (by Upload)
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.27
*@LastModifier : 전지예
*@LastVersion : 1.0
* 2016.05.25 전지예
* 1.0 Creation
*=========================================================*/
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
     * @class ESM_PRI_0150 : ESM_PRI_0150 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0150() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 			= setSheetObject;
    	this.loadPage 					= loadPage;
    	this.initSheet 					= initSheet;
    	this.initCombo 				= initCombo;
    	this.obj_keypress				= obj_keypress;
    	this.initControl					= initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }

   	/* 개발자 작업	*/
    //  ===================================================================================
    //  전역변수
    //  ===================================================================================
    //  공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var comboObjects = new Array();
    var comboCnt = 0;
    //  업무전역변수
    //  ===================================================================================
    //  페이지 초기화
    //  ===================================================================================
    /** 
     * IBSheet Object를 sheetObjects 배열로 등록 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj IBSheet Object
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.09.04
     */ 
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * IBCombo Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj){
    	comboObjects[comboCnt++] = combo_obj;
    }

    /** 
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br> 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  없음
     * @return 없음
     * @see #
     * @author 
     * @version 2016.05.25
     */ 
    function loadPage() {
        var form = document.form;	
        sheetObject = sheetObjects[0];
        sheetCnt = sheetObjects.length;
        
        //IBSheet 초기화
        for(i=0;i<sheetCnt;i++){
            ComConfigSheet(sheetObjects[i]); //시작 환경 설정 함수 이름 변경
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]); //마지막 환경 설정 함수 추가
        }
        
        //IBMultiCombo 초기화
        comboCnt = comboObjects.length;
        for(var k=0;k<comboCnt;k++) {
            initCombo(comboObjects[k],k+1);
        }

	   	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
	   	axon_event.addListenerForm('keypress', 'obj_keypress', document.form);
	   	axon_event.addListenerFormat('keydown', 'obj_keydown', document.form);
		 
		// 당일 날짜로 default setting
		gCurrDate = ComGetDateAdd(null, "D", 0);
		form.f_eff_dt.value = gCurrDate;
	    form.f_exp_dt.value = gCurrDate;
	    
	    form.f_ctrt_tp.Text = 'S/C,RFA(B/A/C)';
	    sheetObject.WaitImageVisible = false;

    }
   
    /**
     * IBMultiCombo 기본 설정 및 초기화 <br>
     */
    function initCombo(comboObj, comboNo) {
        switch (comboObj.id) {
            case "f_ctrt_tp":
                with(comboObj) {
					MultiSelect = true; 
					UseAutoComplete = true;	
					SetColAlign("left");
					SetColWidth("230");  
					DropHeight = 200;
					
//                	InsertItem(0, "" , "");
                	InsertItem(0, "S/C" , "S");
                	InsertItem(1, "RFA(B/A/C)" , "R");
                }     
                break;                
        }
    }
    
    /** 
     * Sheet 기본 설정 및 초기화 <br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다. <br> 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {IBSheet} sheetObj : 시트오브젝트
     * @param {int} sheetNo : 시트오브젝트 태그의 아이디에 붙인 일련번호  
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.08.12
     */ 
    function initSheet(sheetObj, sheetNo) {

        var cnt = 0;
        var sheetID = sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with (sheetObj) {
                    //높이 설정
                    style.height = 395;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
                    
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;
                    
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;
                    
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);
                    
                    // Header Title
                    var HeadTitle1 = "|Sel.|Seq.||SC/RFA\nNo.||AMD\nNo.|Customer Name|Contract\nOFC|APVL\nOFC|Contract Duration|Contract Duration|AMD\nEffective|Status|Filed or\nApproved Date";
                    var HeadTitle2 = "|Sel.|Seq.||SC/RFA\nNo.||AMD\nNo.|Customer Name|Contract\nOFC|APVL\nOFC|EFF Date|EXP Date|AMD\nEffective|Status|Filed or\nApproved Date";
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle2), 0, 0, false);
                    
                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false, false);
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
                    
//                  데이터속성       ROW , COL   ,DATATYPE   ,WIDTH  ,DATAALIGN  ,COLMERGE,SAVENAME	,KEYFIELD,CALCULOGIC,DATAFORMAT    ,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX
                    InitDataProperty(0,		 cnt++,		dtHidden,			30,			daCenter,			true,		"ibflag");
                    InitDataProperty(0,		 cnt++,		dtCheckBox,		40,			daCenter,			true,		"sel");
                    InitDataProperty(0,		 cnt++,		dtSeq,				40,			daCenter,			true,		"seq");
                    InitDataProperty(0,		 cnt++,		dtHidden,			80,			daCenter,			true,		"ctrt_type",				false,		"",		dfNone,		0,		false,		false,	30);
                    InitDataProperty(0,		 cnt++,		dtData,				80,			daCenter,			true,		"ctrt_no",					false,		"",		dfNone,		0,		false,		false	);
                    InitDataProperty(0,		 cnt++,		dtHidden,			100,			daCenter,			true,		"prop_no",				false,		"",		dfNone,		0,		false,		false,	30);
                    InitDataProperty(0,		 cnt++,		dtData,				40,			daCenter,			true,		"amdt_seq",				false,		"",		dfNone,		0,		false,		false	);
                    InitDataProperty(0,		 cnt++,		dtData,				260,			daLeft,				true,		"cust_nm",				false,		"",		dfNone,		0,		false,		false	);
                    InitDataProperty(0,		 cnt++,		dtData,				60,			daCenter,			true,		"prop_ofc_cd",			false,		"",		dfNone,		0,		false,		false	);
                    InitDataProperty(0,		 cnt++,		dtData,				60,			daCenter,			true,		"prop_apro_ofc_cd",	false,		"",		dfNone,		0,		false,		false	);
                    InitDataProperty(0,		 cnt++,		dtData,				80,			daCenter,			false,		"ctrt_eff_dt",			false,		"",		dfNone,		0,		false,		false,	30);
                    InitDataProperty(0,		 cnt++,		dtData,				80,			daCenter,			false,		"ctrt_exp_dt",			false,		"",		dfNone,		0,		false,		false,	30);
                    InitDataProperty(0,		 cnt++,		dtData,				80,			daCenter,			true,		"amdt_eff_dt",			false,		"",		dfNone,		0,		false,		false,	30);
                    InitDataProperty(0,		 cnt++,		dtData,				80,			daCenter,			true,		"prop_sts_cd",			false,		"",		dfNone,		0,		false,		false,	30);
                    InitDataProperty(0,		 cnt++,		dtData,				80,			daCenter,			true,		"file_apro_dt",			false,		"",		dfNone,		0,		false,		false,	30);
                    Ellipsis = true;
//                    HeadRowHeight = DataRowHeight;

        }
                break;
    }
    }
    
    //  ===================================================================================
    //  버튼 이벤트 처리
    //  ===================================================================================
    document.onclick = processButtonClick;

    /** 
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  없음  
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.09.04
     */ 
    function processButtonClick(){
        var form = document.form;
        try {
            var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
                case "btn_Retrieve":
                	if (validateForm(sheetObjects[0], form, IBSEARCH)) {
                		doActionIBSheet(sheetObjects[0], form, IBSEARCH);
                	}
                    break;
                    
                case "btn_new":
                	form.date_by_rdo[0].checked = 'checked'; //Date By
                	
                	//날짜 초기화
            		gCurrDate = ComGetDateAdd(null, "D", 0);
            		form.f_eff_dt.value = gCurrDate;
            	    form.f_exp_dt.value = gCurrDate;
            	    
            	    //Ctrt Type 초기화
            	    form.f_ctrt_tp.Text = 'S/C,RFA(B/A/C)';
            	    
            	    //Apvl Ofc 초기화
            	    form.apvl_ofc.value='';
            	    
            	    //Sheet 초기화
                	doActionIBSheet(sheetObjects[0], form,IBCREATE);
                	break;

                case "btn_Downlist":
                    doActionIBSheet(sheetObjects[0], form, IBDOWNEXCEL);
                    break;
                    
                case "btn_multiDown":
                	if (validateForm(sheetObjects[0], form, MULTI)) {
                		doActionIBSheet(sheetObjects[0], form, MULTI);
                	}
                	break;

                case "btns_calendar": 
       		    	var cal = new ComCalendarFromTo();
                    cal.select(form.f_eff_dt, form.f_exp_dt, 'yyyy-MM-dd');
                    break;
                    
                case "ComOpenPopupWithTarget":	//Approval Office Code 가져오기 팝업
                    var rtnValues = new Object();
                    ComOpenPopupWithTarget('/hanjin/COM_ENS_071.do', 800, 470, "ofc_cd:apvl_ofc", "1,0,1,1,1,1,1,1", true);
                    break;   

            } //end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }
    }
    
    /** 
     * 조회 저장등 서버 기능을 호출하는 doActionIBSheet <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : 시트오브젝트  
     * @param  {object} formObj : 폼 오브젝트
     * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.09.04
     */ 
    function doActionIBSheet(sheetObj, formObj, sAction) {
    	sheetObj.ShowDebugMsg = false;
        switch(sAction) {
            case IBSEARCH: //조회
                ComOpenWait(true);

                formObj.f_cmd.value = SEARCH;
                formObj.date_by.value = ComGetObjValue ( formObj.date_by_rdo );
                sheetObj.DoSearch("ESM_PRI_0150GS.do", FormQueryString(formObj));

                ComOpenWait(false);

                break;
                
            case IBCREATE:
                sheetObj.RemoveAll();
                break;
                
            case IBDOWNEXCEL:
            	sheetObj.SpeedDown2Excel(-1);
                break;
                
            case MULTI:
                formObj.f_cmd.value = MULTI;
                formObj.date_by.value = ComGetObjValue ( formObj.date_by_rdo );
                
                var sParam = FormQueryString(formObj) + "&" + ComPriSetPrifix(sheetObjects[0].GetSaveString(false, true, "sel"), "sheet1_");
                var sXml = sheetObjects[0].GetSaveXml("ESM_PRI_0150GS.do", sParam);

        		ComOpenWait(true);
            	jobKey = ComGetEtcData(sXml, "JOB_KEY");
            	
        		if (sXml.indexOf("ERROR") >= 0) {
        			sheetObj.LoadSaveXml(sXml);
        			return false;
        		} else if (jobKey == null || jobKey == "" || jobKey == undefined || jobKey.length <= 0) {
        			ComShowCodeMessage("PRI00201");
        			return false;
        		} else {
        			setTimeout(getBackEndJobStatus, 2000);
        		}
//            	ComOpenWait(false);
            	
            	break;
        }
    }
    
    /** 
     * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
     * 
     * <br><b>Example :</b>
     * <pre>
     *      Webmail 전송 후 전송 완료되면 완료 메세지 출력
     * </pre>
     * 
     * @return 없음
     */
    function getBackEndJobStatus() {
    	var jobStatus = null;
    	
    	form.f_cmd.value = SEARCHLIST18;
    	var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(form) + "&key=" + jobKey);
    	jobStatus = ComGetEtcData(sXml, "JB_STS_FLG");
    	
    	if (jobStatus == "3") {
    		ComShowCodeMessage("PRI00361"); // Download file sent to Webmail : Korea.Filing@smlines.com
    		ComOpenWait(false);
    	} else if (jobStatus == "4") { // BackEndJob을 실패 하였습니다.
    		ComShowCodeMessage("PRI00201");
    		ComOpenWait(false);
    	} else {
    		// [CHM-201641607]구주 지역 RFA Creation 화면의 Rate 화면 로딩 관련
    		setTimeout(getBackEndJobStatus, 2000);
    	}
    }
    
    /** 
     * Object 의 Keypress 이벤트핸들러 <br>
     * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  없음  
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.08.12
     */ 
    function obj_keypress(){
        var obj = event.srcElement;
        if(obj.dataformat == null) return;
        window.defaultStatus = obj.dataformat;
        switch(obj.dataformat){
            case "ymd": //날짜 입력하기
                ComKeyOnlyNumber(obj,"-"); 
                break;
            case "engup":
            	ComKeyOnlyAlphabet('upper');
                break;
            default:
                //ComKeyOnlyNumber(obj);
                break;
        }
    }
    
    /**
     * OnKeyDown event를 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param 없음
     * @return 없음
     * @author 강효진
     * @version 2010.04.26
     */       
    function obj_keydown(){
       //enter key조회
       var eleName = event.srcElement.name;
       if (eleName == "f_eff_dt" || eleName == "f_exp_dt"){
           var keyValue = null;
           if(event == undefined || event == null) {
        	   keyValue = 13;
           }else{
        	   keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
           }
           if (keyValue == 13){
           	if (validateForm(sheetObjects[0], form, IBSEARCH)) {
           		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
           	}
           }
       }
    }
    
    /** 
     * Object 의 Onbeforedeactivate 이벤트핸들러 <br>
     * 객체의 dataformat 에 따라 입력값에 대한 Valadation을 체크한다.  <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  없음  
     * @return 없음
     * @see #
     * @author 강효진
     * @version 2010.04.23
     */ 
    function obj_deactivate() {
        var form = document.form;
        var formObj = event.srcElement;
        var eleName = event.srcElement.name;
        
        switch (eleName) {
	        case "f_eff_dt":
	        case "f_exp_dt":
            // 입력Validation 확인 및 마스킹 처리
            ComChkObjValid(event.srcElement);
            break;
        }
    }
    
	/**
	* 화면 폼입력값에 대한 유효성검증 프로세스 처리
	*/
	function validateForm(sheetObj,formObj,sAction) {
		var frFileDt = form.f_eff_dt;
		var toFileDt = form.f_exp_dt;
		var ctrtTp = form.f_ctrt_tp;
		
		switch (sAction) {
			case IBSEARCH: //조회
			
			//Filing Date 입력했는지 mandatory validation
			if(frFileDt.value == "") {
				ComShowCodeMessage("PRI00335", frFileDt.caption);
				ComSetFocus(frFileDt);
				return false;
			}
			if(toFileDt.value == "") {
				ComShowCodeMessage("PRI00335", toFileDt.caption);
				ComSetFocus(toFileDt);
				return false;
			}
			if(ctrtTp.Code == "") {
				ComShowCodeMessage("PRI00335", 'Contract Type');
				ComSetFocus(ctrtTp);
				return false;
			}
			
			// from date가 to date보다 큰지 validation
			if(!ComChkObjValid(frFileDt)) { return false; }
			if(!ComChkObjValid(toFileDt)) { return false; }
			
			// msgs['PRI07055'] = 'Please check effective date (91 day validation)';
			var ret = ComGetDaysBetween(frFileDt, toFileDt);
			
			if(ret > 90) {
				ComShowCodeMessage("PRI07057", "90");
				ComSetFocus(frFileDt);
				return false;
			}
			break;
		
		case MULTI :
			var checkedRows = sheetObj.FindCheckedRow('sel');
			var rowCnt = checkedRows.split('|');
			
			if (rowCnt <= 0) {
				ComShowCodeMessage('PRI07010'); 
				return false;
			}
			
			if(rowCnt.length > 31){
				ComShowCodeMessage("PRI00360",rowCnt.length-1); // 2016-07-07 변경 [CHM-201642410] : [Develop][해수부 운임 신고 시스템 (임시방식)] 다운로드 건수 제한 팝업 메세지 관련
				return false;
			}
			
		    break;
		}
	
		return true;
	}
	
	function chkEffDate(formObj) {
		var form = document.form;
		var effDt = form.f_eff_dt;
		var expDt = form.f_exp_dt;
		var fromVal = effDt.value.replace(/-/g,'');
		var toVal = expDt.value.replace(/-/g,'');
		var fromAddM = ComGetDateAdd(ComGetDateAdd(fromVal, "M", 3, "", true), "D", -1, "", true);
		
		if( parseInt(toVal,10) > parseInt(fromAddM,10) ) {
			ComShowCodeMessage("PRI00308", "check the date range!.", " Maximum date range is 3 months");
			ComSetFocus(formObj);
			return false;
		}
		return true;
	}

	//2016-07-04 이민경 [CHM-201642410] [해수부 운임 신고 시스템 (임시방식)] 다운로드 건수 제한 팝업 메세지 관련
	/*function sheet1_OnClick(sheetObj,Row,Col){
		if(Col==1) {
			var checkedRows = sheetObj.FindCheckedRow('sel');
			var rowCnt = checkedRows.split('|');
			if(rowCnt.length > 30) {
				ComShowCodeMessage("PRI00360"); // Max 30 contracts can be selected for Multi-Download.
				sheetObj.CellValue(Row,Col) = 1;
			}
		}
	}*/