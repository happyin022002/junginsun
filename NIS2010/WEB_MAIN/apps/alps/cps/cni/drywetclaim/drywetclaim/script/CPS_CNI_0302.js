/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CPS_CNI_0302.js
*@FileTitle : Status
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
     * @class CPS_CNI_0302 : CPS_CNI_0302 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function CPS_CNI_0302() {
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
	var partyType;

	//IBMultiCombo
	var comboObjects = new Array();
	var comboCnt = 0;
	
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	
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
                case "btn_Retrieve":
	             	doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                    break; 

                case "btn_New":
					ComResetAll();
					eval("document.all.combo_date_type").Code = "DOU";
                    break; 

				case "btn_DownExcel":
					sheetObject1.SpeedDown2Excel(1)
                    break; 
                break;

                case "cal_from_dt":
					var cal = new ComCalendar();
					cal.setDisplayType('date');
					cal.select(form.from_dt, 'yyyy-MM-dd');
                    break; 

                case "cal_to_dt":
					var cal = new ComCalendar();
					cal.setDisplayType('date');
					cal.select(form.to_dt, 'yyyy-MM-dd');
                    break;
                   
               	case "pop_hdlr_usr_id":
					ComOpenPopupWithTarget("COM_ENS_091.do", 780, 565, "usr_id:hdlr_usr_id", "1,0,1,1,1", true);
                    break; 
                   
               	case "pop_cre_ofc_cd":
					ComOpenPopupWithTarget("COM_ENS_071.do", 780, 480, "ofc_cd:cre_ofc_cd", "1,0,1,1,1", true);
                    break; 
                   
               	case "pop_cre_usr_id":
					ComOpenPopupWithTarget("COM_ENS_091.do", 780, 565, "usr_id:cre_usr_id", "1,0,1,1,1", true);
                    break; 
                    
               	case "pop_dw_clm_ref_vvd_no":
					popupVvdCd();	
                    break; 
                    
               	case "pop_clmt_clm_pty_nm":
               		partyType = srcName;
					popupMainCodeInquiry();
                    break; 
                    
               	case "pop_deft_clm_pty_nm":
               		partyType = srcName;
					popupMainCodeInquiry();
                    break; 
                    
               	case "pop_labl_pty_clm_pty_nm":
               		partyType = srcName;
					popupMainCodeInquiry();
                    break; 
                    
               	case "pop_insur_clm_pty_nm":
               		partyType = srcName;
					popupMainCodeInquiry();
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
	* 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
	* @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
	**/
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
        
    }

    /**
     * Sheet의 Load가 끝났을때 발생되는 이벤트
     */
    function sheet1_OnLoadFinish(sheetObj) {
		sheetObj.WaitImageVisible = false;
		initMiscCode(sheetObj);   
		sheetObj.WaitImageVisible = true; 
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
		eval("document.all.combo_date_type").Code = "DOU";
		eval("document.all.combo_date_type").DeleteItem(""); 
		eval("document.all.combo_date_type").focus();

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
		comboObj.DropHeight = 230;
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
        axon_event.addListener  ('keydown', 'ComKeyEnter', 'form');

        axon_event.addListener  ('change'  , 'vvd_change', 'dw_clm_ref_vvd_no');				//- VVD 입력 후 입력된 정보 체크하기
        axon_event.addListener  ('change'  , 'handler_change', 'hdlr_usr_id');					//- Handler 입력 후 입력된 정보 체크하기
        axon_event.addListener  ('change'  , 'handler_change', 'cre_usr_id');					//- R.Handler 입력 후 입력된 정보 체크하기
        axon_event.addListener  ('change'  , 'office_change', 'cre_ofc_cd');					//- R.Office 입력 후 입력된 정보 체크하기
        axon_event.addListener  ('change'  , 'party_change', 'insur_clm_pty_nm');				//- Party name 삭제시 party no 삭제
        axon_event.addListener  ('change'  , 'party_change', 'labl_pty_clm_pty_nm');			//- Party name 삭제시 party no 삭제
        axon_event.addListener  ('change'  , 'party_change', 'clmt_clm_pty_nm');				//- Party name 삭제시 party no 삭제
        axon_event.addListener  ('change'  , 'party_change', 'deft_clm_pty_nm');				//- Party name 삭제시 party no 삭제
        
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
     * Handler 입력시 입력된 정보 체크한다. <br>
     **/
    function handler_change() {
    	var obj = event.srcElement;
    	if (obj.value != "") {
			doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, obj.name);
    	}
    }
    
    /**
     * R.Office 입력시 입력된 정보 체크한다. <br>
     **/
    function office_change() {
    	var obj = event.srcElement;
    	if (obj.value != "") {
			doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, obj.name);
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
	        case "cre_usr_id":
	            ComKeyOnlyAlphabet('num');
	            break;
	        case "cre_ofc_cd":
	            ComKeyOnlyAlphabet('uppernum');
	            break;
	        case "insur_clm_pty_nm":
	        	if (event.keyCode > 0) event.returnValue = false;;
	            break;
	        case "labl_pty_clm_pty_nm":
	        	if (event.keyCode > 0) event.returnValue = false;;
	            break;
	        case "clmt_clm_pty_nm":
	        	if (event.keyCode > 0) event.returnValue = false;;
	            break;
	        case "deft_clm_pty_nm":
	        	if (event.keyCode > 0) event.returnValue = false;;
	            break;
			default:
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
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

		           // 높이 설정
					style.height = 380;
										
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 15, 100);

					var HeadTitle1 = "Seq|Case No.|TOC|STS|TOH|Company|R. Office|R. Handler|HOFC|Handler|POI|DOI|DON|DOU|DOC|VVD|Vessel|DOTB|LP DOTB|Claimant|Defendant|DOF|Arbitrated|Litigated|Claim Amount|DOS|Settled Amount|Liable Party|LP DOF|LP Claim AMT|LP DOR|LP Recovered AMT|Insurer|Deductible|INS DOF|INS Claim AMT|INS DOR|INS Recovered AMT|Handing Costs";
					var headCount = ComCountHeadTitle(HeadTitle1);
										
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 2, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
                   
                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtSeq,			45,		daCenter,	true,		"Seq",					false,      "",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"dw_clm_no",			false,		"",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,		"dw_clm_tp_cd",			false,      "",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,		"dw_clm_sts_cd",		false,		"",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,		"dw_clm_att_def_tp_cd",	false,      "",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"dw_co_cd",				false,		"",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"cre_ofc_cd",			false,      "",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			80,		daLeft,		true,		"cre_usr_nm",			false,		"",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"hdlr_ofc_cd",			false,      "",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			80,		daLeft,		true,		"hdlr_usr_nm",			false,      "",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,		"inci_plc_tp_cd",		false,		"",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"inci_occr_dt",			false,      "",				dfDateYmd,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"prlm_clm_ntfy_dt",		false,		"",				dfDateYmd,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"upd_dt",				false,      "",				dfDateYmd,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"cs_clz_dt",			false,		"",				dfDateYmd,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"dw_clm_ref_vvd_no",	false,      "",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			130,	daLeft,		true,		"vsl_eng_nm",			false,		"",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"tm_bar_dt",			false,		"",				dfDateYmd,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			75,		daCenter,	true,		"labl_pty_tm_bar_dt",	false,      "",				dfDateYmd,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			150,	daLeft,		true,		"clmt_clm_pty_nm",		false,		"",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			150,	daLeft,		true,		"deft_clm_pty_nm",		false,      "",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"fmal_clm_rcv_dt",		false,		"",				dfDateYmd,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"arbt_dt",				false,      "",				dfDateYmd,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"lit_dt",				false,		"",				dfDateYmd,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,		90,		daRight,	true,		"clm_usd_amt",			false,      "",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"clm_stl_dt",			false,		"",				dfDateYmd,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	true,		"clm_stl_usd_amt",		false,      "",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			150,	daLeft,		true,		"labl_pty_clm_pty_nm",	false,		"",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"labl_pty_file_dt",		false,		"",				dfDateYmd,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,		90,		daRight,	true,		"labl_pty_file_usd_amt",false,      "",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"labl_pty_rcvr_dt",		false,		"",				dfDateYmd,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,		115,	daRight,	true,		"labl_pty_rcvr_usd_amt",false,      "",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			150,	daLeft,		true,		"insur_clm_pty_nm",		false,		"",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,		90,		daRight,	true,		"ddct_usd_amt",			false,		"",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"insur_file_dt",		false,      "",				dfDateYmd,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,		90,		daRight,	true,		"insur_file_usd_amt",	false,		"",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"insur_rcvr_dt",		false,      "",				dfDateYmd,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,		115,	daRight,	true,		"insur_rcvr_usd_amt",	false,		"",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	true,		"inv_amt",				false,		"",				dfNone,		0,			true,		true);

		          }
		          break;

        }
    }

	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction, Col) {

        switch(sAction) {
			case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) return;
				
				formObj.f_cmd.value = SEARCH;
	        	
        	   	sheetObj.DoSearch("CPS_CNI_0302GS.do", FormQueryString(formObj));

			break;

			case IBROWSEARCH: 

				if (Col == "ComCd") {//코드 조회
					
					CoCniGetCombo(formObj, sheetObj, "MULTI:MULTI:MULTI:MULTI:MULTI:MULTI", "18:24:21:19:25:17","dw_clm_tp_cd:dw_co_cd:inci_plc_tp_cd:dw_clm_att_def_tp_cd:date_type:dw_clm_sts_cd", "dw_clm_tp_cdText:dw_co_cdText:inci_plc_tp_cdText:dw_clm_att_def_tp_cdText:date_typeText:dw_clm_sts_cdText");

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
				} else if (Col == "hdlr_usr_id" || Col == "cre_usr_id") {//Handler 조회
					
					var obj = eval("document."+formObj.name+"."+Col);

		   			var sXml = sheetObj.GetSearchXml("CPS_CNI_0301GS.do" , "&f_cmd="+SEARCH03+"&hdlr_usr_id="+obj.value);

		   			var result = ComGetEtcData(sXml, "usr_id");

		   			if(typeof result == "undefined" || result == "" ) {
						var obj = eval("document."+formObj.name+"."+Col);
						obj.value = "";
						ComAlertFocus(obj, ComGetEtcData(sXml, "errMsg"));
						return;
					}
				} else if (Col == "cre_ofc_cd") {//Office 조회
					
					var obj = eval("document."+formObj.name+"."+Col);

		   			var sXml = sheetObj.GetSearchXml("CPS_CNI_0301GS.do" , "&f_cmd="+SEARCH06+"&ofc_cd="+obj.value);

		   			var result = ComGetEtcData(sXml, "ofc_cd");

		   			if(typeof result == "undefined" || result == "" ) {
						var obj = eval("document."+formObj.name+"."+Col);
						obj.value = "";
						ComAlertFocus(obj, ComGetEtcData(sXml, "errMsg"));
						return;
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
     * Party popup에서 선택시 Party Name을 세팅한다.
     */
    function setMainCodeInquiry(partyVo) {

        switch(partyType) {
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
        }         
    	
    }
	
	/**
     * Double Click Evenet 더블 클릭시 Dry Wet Claim 메인 화면을 오픈한다.<br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     **/
	function sheet1_OnDblClick(sheetObj,Row,Col){

		if (Row < 1) return;
		
		ComOpenPopup("CPS_CNI_0301.do?popup=yes&dw_clm_no="+sheetObj.CellValue(Row, "dw_clm_no"), 1024, 620,"", "1,0,1,1,1", false, false, null, null, 0, "CPS_CNI_0301");
	}

	/**
	* 선택된 Item이 변경되었을 때 이벤트가 발생한다.
	* @param comboObj
	* @param index_cd
	* @param text
	* @return
	*/
	function combo_date_type_OnChange(comboObj, index_cd, text) {
		// 각 콤보 필드에 해당하는 hidden 필드에 값을 세팅해줌
		form.date_type.value = index_cd;
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
	function combo_dw_clm_sts_cd_OnChange(comboObj, index_cd, text) {
		// 각 콤보 필드에 해당하는 hidden 필드에 값을 세팅해줌
		form.dw_clm_sts_cd.value = index_cd;
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
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction, Col){

        with(formObj){

			if (!ComChkValid(formObj)) return false;
			
            if (sAction == IBSEARCH) {
            	var fromDt = ComReplaceStr(form.from_dt.value.trim(),"-","");
            	var toDt = ComReplaceStr(form.to_dt.value.trim(),"-","");

   				if (fromDt != "" && toDt != "" && fromDt > toDt) {
					ComAlertFocus(form.to_dt, ComGetMsg("CNI09058"));
					return;
   				}
			}
   				
        }

        return true;
    }
    
	/* 개발자 작업  끝 */