/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_LSE_0020.js
 *@FileTitle : Available Off Hire Q'ty List
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.22
 *@LastModifier : 장준우
 *@LastVersion : 1.0
 * 2009.09.22 장준우
 * 1.0 Creation
 * =======================================================
 * 2010.12.02 박명신 [CHM-201007443-01] Ref No. 추가
 * 2011.01.27 남궁진호 [CHM-201108164-01] 공통 팝업 (COM_ENS_051, COM_ENS_0C1) Open Size 조정
 * 2011.09.08 나상보 [선처리] 전체 sel select 가능하도록 변경
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
	 * @class EES_LSE_0020 : EES_LSE_0020 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_LSE_0020() {
		this.processButtonClick = processButtonClick;
		this.setSheetObject 	= setSheetObject;
		this.setComboObject 	= setComboObject;
		this.loadPage 			= loadPage;
		this.sheet1_OnLoadFinish = sheet1_OnLoadFinish;
		this.initControl 		= initControl;
		this.obj_blur 			= obj_blur;
		this.obj_focus 			= obj_focus;
		this.obj_change 		= obj_change;
		this.obj_keypress 		= obj_keypress;
		this.obj_keyup 			= obj_keyup;
		this.obj_keydown 		= obj_keydown;
		this.initSheet 			= initSheet;
		this.initCombo 			= initCombo;
		this.doActionIBSheet 	= doActionIBSheet;
		this.sheet1_OnSearchEnd = sheet1_OnSearchEnd;
		this.sheet1_OnChange 	= sheet1_OnChange;
		this.sheet1_OnMouseMove = sheet1_OnMouseMove;
		this.combo1_OnCheckClick = combo1_OnCheckClick;
		this.combo2_OnCheckClick = combo2_OnCheckClick;
		this.combo3_OnCheckClick = combo3_OnCheckClick;
		this.combo1_OnBlur 		= combo1_OnBlur;
		this.combo2_OnBlur 		= combo2_OnBlur;
		this.combo3_OnBlur 		= combo3_OnBlur;
		this.combo1_OnKeyDown 	= combo1_OnKeyDown;
		this.combo2_OnKeyDown 	= combo2_OnKeyDown;
		this.combo3_OnKeyDown 	= combo3_OnKeyDown;
		this.setDefaultComboCheck = setDefaultComboCheck;
		this.openPopup 			= openPopup;
		this.setPopData_Agreement = setPopData_Agreement;
		this.setPopData_Lessor 	= setPopData_Lessor;
		this.callbackPopupMail  = callbackPopupMail;
		this.getBackEndJobStatus = getBackEndJobStatus;
		this.getBackEndJobLoadFile = getBackEndJobLoadFile;
		this.delayActionIBSheet = delayActionIBSheet;
		this.validateForm 		= validateForm;
		this.checkDurationDate 	= checkDurationDate;
		this.setEnableSwitch 	= setEnableSwitch;
		this.clearForm 			= clearForm;
	}

	/* 개발자 작업	*/
	// 공통전역변수

	// Combo Object Array
	var comboObjects = new Array();
	var comboCnt = 0;

	var vOrcLstmCd = "LT|ST|OF|SI|MI";
   	var vOrcCntrTpszCd = "";
   	var vCnmvStsCd = "MT|VL|TS|VD|IC|ID|EN|TN";

	var sheetObjects = new Array();
	var sheetCnt = 0;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
        /*******************************************************/
        var formObj = document.form;

    	try {
    		var srcObj  = window.event.srcElement;
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
   				case "radio_dol_tp":
  					if(formObj.radio_dol_tp[0].checked){
						ComSetObjValue(formObj.dol_tp, "A");
   					}else if(formObj.radio_dol_tp[1].checked){
						ComSetObjValue(formObj.dol_tp, "E");
   					}else if(formObj.radio_dol_tp[2].checked){
						ComSetObjValue(formObj.dol_tp, "N");
   					}
  					break;				

   				case "radio_sent_tp":
  					if(formObj.radio_sent_tp[0].checked){
						ComSetObjValue(formObj.sent_tp, "A");
   					}else if(formObj.radio_sent_tp[1].checked){
						ComSetObjValue(formObj.sent_tp, "E");
   					}else if(formObj.radio_sent_tp[2].checked){
						ComSetObjValue(formObj.sent_tp, "N");
   					}
  					break;				
				
				case "btn_retrieve":
					if(ComChkValid(formObj) == true) {
						doActionIBSheet(sheetObjects[0],document.form,IBBATCH);
					}
					break;

				case "btn_new":
					ComResetAll();
					setEnableSwitch("1");
					for ( var k = 0 ; k < comboObjects.length ; k++ ) {
				        setDefaultComboCheck(comboObjects[k]);
				    }
	               formObj.combo1.BackColor = "#ffffff";
	               formObj.combo3.BackColor = "#ffffff";
					ComSetFocus(formObj.loc_cd);
					break;

				case "btn_DownExcel":
					sheetObject.Down2Excel(-1, false, false, true);
					break;

				case "btn_DetailInquiry":
					openPopup("8");
					break;

				case "btns_search1":	//Form Location. 조회 팝업
					if(formObj.loc_case.value != "2") {
						openPopup("1");
					}
 					break;
				case "btns_search2": 	// Form Delivery SCC Search
					if(formObj.loc_case.value != "1") {
 						openPopup("2");
					}
 					break;
				case "btns_search3": 	// VVD Code Search
					if(formObj.loc_case.value != "1") {
						openPopup("3");
					}
					break;
				case "btns_search4": 	// Form Agreement Search
					openPopup("4");
					break;
				case "btns_search5": 	// Form Lessor Search
					openPopup("5");
					break;
				case "btns_search6":	//Form Port. 조회 팝업
					if(formObj.loc_case.value != "1") {
						openPopup("6");
					}
 					break;
 				case "btns_search7":	//Form Lane 조회 팝업
 					if(formObj.loc_case.value != "1") {
						openPopup("7");
 					}
 					break;
				case "btns_calendar":	// Estimate Duration (FromTo)
					if ( srcObj.style.filter == "" ) {
						var cal = new ComCalendarFromTo();
						cal.select(formObj.str_estm_dt, formObj.end_estm_dt, 'yyyy-MM-dd');
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
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }

	/**
	 * IBMultiCombo Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
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

            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);

            ComEndConfigSheet(sheetObjects[i]);
        }

		/* IBMultiCombo 초기화 */
		for ( var k = 0 ; k < comboObjects.length ; k++ ) {
	        initCombo(comboObjects[k], k+1);
	    }
    }

	/**
	 * loadPage 메서드에서 초기 조회하는 메서드를 분리한다.
	 */
	function sheet1_OnLoadFinish(sheetObj) {
		var formObj = document.form;

     	/* IBMulti Combo Item Setting */
		doActionIBSheet(sheetObjects[0], document.form, IBCREATE);

		/* Axon Control Setting*/
		initControl();

		// 조회 전 데이터 가공 방지를 위한 버튼 콘트롤
		LseComBtnControl(false, "btn_DetailInquiry");

		/* 초기 Focus Setting */
		setEnableSwitch("1");
		ComSetFocus(formObj.loc_cd);
    }

	// Axon 이벤트 처리
  	// 1. 이벤트catch
  	function initControl() {
  		var formObj = document.form;
  		axon_event.addListenerFormat('blur',		'obj_blur',		formObj); //- 포커스 나갈때
		axon_event.addListenerForm('focus',			'obj_focus',	formObj); //- 포커스 들어갈때
  		axon_event.addListenerFormat('keypress',	'obj_keypress',	formObj); //- 키 눌렸을때
		axon_event.addListenerFormat('keyup',		'obj_keyup',	formObj); //- 키 올라올때
		axon_event.addListenerForm('keydown',		'obj_keydown',	formObj); //- 키 눌렸을때
		axon_event.addListenerForm('change',		'obj_change',	formObj); //- 변경될때.
  	}

	//이벤트 중복방지 변수
	var preEventType = null;
  	// 2. 이벤트처리함수 -- Start
  	/**
	 * HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
	 */
	function obj_blur(){
		var obj = event.srcElement;

		if(preEventType == event.type) {
			preEventType = null;
			return;
		}

	    switch(obj.name){
	    	case "agmt_seq" :
	    	case "vndr_seq" :
	    		/* 숫자이면서 천단위 구분을 하지 않는다. */
	            ComChkObjValid(obj, true, false, false);
	            break;
	    	case "loc_cd" :
                if(document.form.loc_tp.value == "0" && (document.form.loc_cd.value != "")){
                	document.form.combo1.BackColor = "#ffffff";
                	document.form.combo3.BackColor = "#ffffff";
				}
	            break;
	        default:
	            //Validation 전체 체크(길이,format,최대,최소 등등)
	            ComChkObjValid(obj);
	        	break;
	    }
	}

	/**
	 * HTML Control의 포커스 들어가는 이벤트에서 마스크 구분자를 제거한다.
	 */
	function obj_focus(){
		var obj  = event.srcElement;
		var formObj = document.form;

		if(obj.name == "del_cd" && obj.value == "") {
			obj.value = formObj.port_cd.value;
		}

		if( obj.readOnly ) {
			ComSetNextFocus(obj);
		} else {
		    //마스크구분자 없애기
		    ComClearSeparator(event.srcElement);
		}
	}

	/**
	 * OnChange Event 처리
	 */
	function obj_change(){
		var obj      = event.srcElement;
		var formObj  = document.form;
		var sheetObj = sheetObjects[0];

		switch(obj.name) {
			case "loc_case":	//Location Case
				sheetObj.RemoveAll();
				clearForm("port_loc");
				setEnableSwitch(obj.value);

				if(obj.value == "2") {
					ComSetFocus(formObj.port_cd);
				} else if(obj.value == "3") {
					ComSetFocus(formObj.slan_cd);
				} else {
					ComSetFocus(formObj.loc_cd);
				}
                formObj.combo1.BackColor = "#ffffff";
                formObj.combo3.BackColor = "#ffffff";

                if(formObj.loc_tp.value == "0" && (formObj.loc_case.value == "0" || formObj.loc_case.value == "1")){ // 20160609 not mandatory , RCC => aLL available.
		               formObj.combo1.BackColor = "#ccffff";
		               formObj.combo3.BackColor = "#ccffff";
				}

				break;
			case "loc_tp":		//Location Type
				formObj.loc_cd.value = "";
				formObj.loc_cd.maxLength = obj.value == "3" ? 7 : 5;
				if(formObj.loc_tp.value == "0"){ // 20160609 not mandatory , RCC => aLL available.
		               formObj.loc_cd.className = "input";
		               formObj.combo1.BackColor = "#ccffff";
		               formObj.combo3.BackColor = "#ccffff";
				} else {
					   formObj.loc_cd.className = "input1";
		               formObj.combo1.BackColor = "#ffffff";
		               formObj.combo3.BackColor = "#ffffff";
				}
				ComSetNextFocus(obj);
				break;
			case "loc_cd":		//Location Code
				if ( ComTrim(obj.value) != "" ) {
					if(obj.maxLength == 5) {
	        			doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC01);
  					} else {
  						doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC08);
  					}
  				}
				break;
			case "port_cd":
				if ( ComTrim(obj.value) != "" ) {
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC02);
  				}
				break;
			case "slan_cd":
				if ( ComTrim(obj.value) != "" ) {
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC07);
  				}
				break;
			case "del_cd":	//Delivery SCC
  				if ( ComTrim(obj.value) != "" ) {
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC06);
  				}
				break;

			case "estm_tp":
				ComSetNextFocus(obj);
				break;
  			case "str_estm_dt":
    		case "end_estm_dt":
    			checkDurationDate(obj);
	    		break;

			case "vvd_cd":		//VVD Code Search
				if ( ComTrim(obj.value) != "" ) {
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC03);
  				}
				break;

  			case "agmt_seq":	//Agreement No.
  				if ( ComTrim(obj.value) != "" ) {
					doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC04);
				}
				break;

			case "vndr_seq":	//Lessor Code
  				if ( ComTrim(obj.value) != "" ) {
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC05);
  				}
  				break;
		}
	}

	/**
	 * Key-Press Event 처리
	 */
  	function obj_keypress() {
		var obj = event.srcElement;
		var formObj = document.form;

		switch(obj.dataformat) {
	        case "ymd":
	        case "ym":
	        case "hms":
	        case "hm":
	        case "jumin":
	        case "saupja":
	        case "int":
	            ComKeyOnlyNumber(obj);
	            break;
	        case "float":
	            ComKeyOnlyNumber(obj, "-.");
	            break;
	        case "eng":
	            ComKeyOnlyAlphabet();
	            break;
	        case "engup":
	        	if(obj.name == "loc_cd") {
	        		ComKeyOnlyAlphabet('uppernum');
	        	} else if(obj.name == "vvd_cd") {
	        		if(obj.value.length > 3 && obj.value.length < 8) {
						ComKeyOnlyNumber(obj);
	        		} else {
						ComKeyOnlyAlphabet('upper');
		        	}
	        	} else {
					ComKeyOnlyAlphabet('upper');
	        	}
	            break;
	        case "engdn":
	            ComKeyOnlyAlphabet('lower');
	            break;
	        default:
	            ComKeyOnlyNumber(obj);
	        	break;
	    }
  	}

  	/**
  	 * Key-Up Event 처리
  	 */
  	function obj_keyup() {
  		var obj = event.srcElement;
  		var formObj = document.form;

  		switch(obj.name) {
  			case "vndr_seq":
  			case "agmt_seq":
				if ( ComTrim(obj.value) == "" ) {
  					clearForm(obj.name);
  				} else {
  					ComKeyEnter('LengthNextFocus');
  				}
  				break;

  			default :
			  	ComKeyEnter('LengthNextFocus');
  		}
  	}

   	/**
	 * Key-Down Event 처리
	 */
   	function obj_keydown() {
   		var obj      = event.srcElement;
   		var vKeyCode = event.keyCode;
   		var formObj  = document.form;
   		if ( vKeyCode == 13 ) {
   			switch(obj.name) {
   				case "loc_cd":
   				case "port_cd":
   				case "slan_cd":
   				case "del_cd":		//Delivery SCC
   				case "vvd_cd":		//VVD Code Search
				case "vndr_seq":
	  			case "agmt_seq":
	  				if ( ComTrim(obj.value) == "" ) {
						//doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
						doActionIBSheet(sheetObjects[0], formObj, IBBATCH);
					}
					break;

				default :
					//doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
					doActionIBSheet(sheetObjects[0], formObj, IBBATCH);
			}
   		}
   	}
  	// 2. 이벤트처리함수 -- End

  	/**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
		var sheetid = sheetObj.id;

        switch(sheetid) {
            case "sheet1":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 320;
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

					var HeadTitle1 = "|Sel.|SCC|AGMT No.|||Ref No.|Lessor|Lessor||Lease\nTerm|TP/SZ|DOL vs PFMC|DOL vs PFMC|DOL vs PFMC|Reserved\nQ'ty|Remained\nQ'ty|Available Off-Hire Q'ty|Available Off-Hire Q'ty|Available Off-Hire Q'ty|Available Off-Hire Q'ty|Available Off-Hire Q'ty|Available Off-Hire Q'ty|CNTR List|CNTR List";
					var HeadTitle2 = "|Sel.|SCC|AGMT No.|||Ref No.|Lessor|Lessor||Lease\nTerm|TP/SZ|DOL|PFMC|Balance|Reserved\nQ'ty|Remained\nQ'ty|MT|VL/TS|VD/IC|ID|EN/TN|Total|Sent|Rest";
					var headCount = ComCountHeadTitle(HeadTitle1);

		            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		            InitColumnInfo(headCount, 0, 0, true);

		            // 해더에서 처리할 수 있는 각종 기능을 설정한다
		            InitHeadMode(true, true, true, true, false,false)

		            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		            InitHeadRow(0, HeadTitle1, true);
		            InitHeadRow(1, HeadTitle2, true);

		            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		            InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	true,	"del_chk");
		            InitDataProperty(0, cnt++ , dtData,      	50,		daCenter,	true,	"scc_cd",		false,	"",		dfNone, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtData,      	75,		daCenter,	true,	"agmt_no",		false,	"",		dfNone, 	0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      	50,		daCenter,	true,	"agmt_cty_cd",	false,	"",		dfNone, 	0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      	60,		daCenter,	true,	"agmt_seq",		false,	"",		dfNone, 	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	100,	daLeft,		true,	"ref_no",		false,	"",		dfNone, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtHidden,      	50,		daCenter,	true,	"vndr_seq",		false,	"",		dfNone, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtData,      	65,		daCenter,	true,	"vndr_abbr_nm",	false,	"",		dfNone, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtHidden,      	80,		daCenter,	true,	"vndr_lgl_eng_nm",	false,	"",		dfNone, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtData,     	50,   	daCenter,	true,	"lstm_cd",		false,	"",		dfNone, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtData,      	50,		daCenter,	true,	"cntr_tpsz_cd",	false,	"",		dfNone, 	0,	false,	false);

		            InitDataProperty(0, cnt++ , dtAutoSum, 		45,		daRight,	true,	"dol_qty",		false,	"",		dfInteger, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtAutoSum,	  	45,		daRight,	true,	"pfmc_qty",		false,	"",		dfInteger, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtAutoSum, 		50,		daRight,	true,	"bal_qty",		false,	"",		dfInteger, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtAutoSum, 		65,		daRight,	true,	"res_qty",		false,	"",		dfInteger, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtAutoSum,		65,		daRight,	true,	"rem_qty",		false,	"",		dfInteger, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtAutoSum, 	  	45,  	daRight,	true,	"mt_qty",		false,	"",		dfInteger, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtAutoSum, 	  	45,  	daRight,	true,	"vl_qty",		false,	"",		dfInteger, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtAutoSum, 	  	45,  	daRight,	true,	"ic_qty",		false,	"",		dfInteger, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtAutoSum, 	  	45,  	daRight,	true,	"id_qty",		false,	"",		dfInteger, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtAutoSum, 	  	45,  	daRight,	true,	"etn_qty",		false,	"",		dfInteger, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtAutoSum, 	  	50,  	daRight,	true,	"tot_qty",		false,	"",		dfInteger, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtAutoSum, 	  	45,  	daRight,	true,	"hld_qty",		false,	"",		dfInteger, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtAutoSum, 	  	50,   	daRight,	true,	"cntr_qty",		false,	"",		dfInteger, 	0,	false,	false);

					SelectBackColor = LSE_SELECT_BACK_COLOR;
					AutoSumBottom = -1;
					ScrollBar = 3;
 					CountFormat = "[SELECTDATAROW / TOTALROWS]";
				}
				break;

        }
    }

	/**
	 * 콤보 초기설정값, 헤더 정의
	 * param : comboObj ==> 콤보오브젝트, sheetNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initCombo(comboObj, comboNo) {
	    switch(comboObj.id) {
	        case "combo1":
	        	with(comboObj) {
	            	DropHeight = 250;
	            	MultiSelect = true;
	            	//MaxSelect = 1;
	            	MultiSeparator = ",";
	            	Style = 0;
             		UseAutoComplete = true;
             		//영문(대)+특수문자 - Lease Term
             		ValidChar(2,2);
	        	}

	        	break;
	        case "combo2":
	        	with(comboObj) {
	            	DropHeight = 200;
	            	MultiSelect = true;
	            	//MaxSelect = 1;
	            	MultiSeparator = ",";
	            	Style = 0;
             		UseAutoComplete = true;
             		//영문(대)+특수문자,숫자 - TP/SZ
             		ValidChar(2,3);
	            }

	        	break;

	        case "combo3":
	        	with(comboObj) {
	            	DropHeight = 200;
	            	MultiSelect = true;
	            	//MaxSelect = 1;
	            	MultiSeparator = ",";
	            	Style = 0;
             		UseAutoComplete = true;
             		//영문(대)+특수문자 - MVMT Status
             		ValidChar(2,2);
	            }

	        	break;
	    }
	}

  	/**
	 * Sheet관련 프로세스 처리
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
        	case IBCREATE:
				//Lease Term Combo Item Setting
				comboObjects[0].InsertItem(0 , 'ALL','');
				LseComText2ComboItem(comboObjects[0], vOrcLstmCd, vOrcLstmCd, "|");
				setDefaultComboCheck(comboObjects[0]);

				//Container Movement Status Combo Item Setting Start
            	comboObjects[2].InsertItem(0 , 'ALL','');
            	LseComText2ComboItem(comboObjects[2], vCnmvStsCd, vCnmvStsCd, "|");
            	setDefaultComboCheck(comboObjects[2]);

				sheetObj.WaitImageVisible = false;
				//Container Type/Size Combo Item Setting Start
				formObj.f_cmd.value = SEARCH02;
				var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", FormQueryString(formObj));
		        sheetObj.WaitImageVisible = true;

	            if ( sXml != "" ) {
	            	comboObjects[1].InsertItem(0 , 'ALL','');
	            	LseComXml2ComboItem(sXml, comboObjects[1], "cntr_tpsz_nm", "cntr_tpsz_cd", "|");
	            	vOrcCntrTpszCd = ComGetEtcData(sXml, "cntr_tpsz_cd");
	            	setDefaultComboCheck(comboObjects[1]);
	            }

	            break;

			case IBSEARCH:      //조회
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet1") {
						formObj.f_cmd.value = SEARCH;
						sheetObj.Redraw = false;
						sheetObj.DoSearch4Post("EES_LSE_0020GS.do",FormQueryString(formObj));
					}
				}
				break;

			case IBBATCH:      //조회-BackEndJob
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet1") {
						formObj.f_cmd.value = COMMAND01;
						sheetObj.WaitImageVisible = false;
						sheetObj.Redraw = false;
						ComOpenWait(true);

						var sXml = sheetObj.GetSearchXml("EES_LSE_0020GS.do", FormQueryString(formObj));
						var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");

						if (backendJobKey.length > 0) {
							ComSetObjValue(formObj.backendjob_key, backendJobKey);
							sheetObj.RequestTimeOut = 10000;
							timer1 = setInterval(getBackEndJobStatus, 3000);
						}
					}
				}
				break;

			case IBSEARCH_ASYNC01:	// Location 조회
 				if(validateForm(sheetObj,formObj,sAction)) {
 					if ( sheetObj.id == "sheet1") {
 						var vLocTp = formObj.loc_tp.value == "0" ? "RCC" :
 									 formObj.loc_tp.value == "1" ? "LCC" : "SCC";
 						var param = "f_cmd="+SEARCH05+"&loc_tp="+ vLocTp
 								  +"&loc_cd="+ComGetObjValue(formObj.loc_cd);
 						sheetObj.WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",param);
						sheetObj.WaitImageVisible = true;

						if ( sXml != "" ) {
							if ( ComGetEtcData(sXml, "rcc_cd") != undefined ) {
								if ( ComGetEtcData(sXml, "rcc_cd") != "" ) {
									var vLocCd = "";
									switch (vLocTp) {
										case "RCC":
											vLocCd = ComGetEtcData(sXml, "rcc_cd");
											break;

										case "LCC":
											vLocCd = ComGetEtcData(sXml, "lcc_cd");
											break;

										case "SCC":
											vLocCd = ComGetEtcData(sXml, "scc_cd");
											break;
									}

									formObj.loc_cd.value = vLocCd;
									if(formObj.port_cd.className == "input1") {
										ComSetNextFocus(formObj.loc_cd);
									} else {
										ComSetFocus(comboObjects[0]);
									}
								} else {
									ComShowCodeMessage("LSE01037");
									formObj.loc_cd.value = "";
									ComSetFocus(formObj.loc_cd);
								}
							} else {
								var errMsg = LseComGetErrMsg(sXml);
								if ( errMsg != "" ) {
									ComShowMessage(errMsg);
								}
								formObj.loc_cd.value = "";
								ComSetFocus(formObj.loc_cd);
							}
						}
					}
				}
 				break;

 			case IBSEARCH_ASYNC02:	// 조회(Form Port 입력시)
				if(validateForm(sheetObj,formObj,sAction)) {
					if ( sheetObj.id == "sheet1") {
						var param = "f_cmd="+SEARCH13+"&loc_cd="+ComGetObjValue(formObj.port_cd);
						sheetObj.WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",param);
						sheetObj.WaitImageVisible = true;

						if ( sXml != "" ) {
							if ( ComGetEtcData(sXml, "loc_cd") != undefined ) {
								if ( ComGetEtcData(sXml, "loc_cd") != "" ) {
									formObj.port_cd.value = ComGetEtcData(sXml, "loc_cd") ;
									ComSetNextFocus(formObj.port_cd);
								}else{
									ComShowCodeMessage("LSE01048");
									formObj.port_cd.value = "";
									ComSetFocus(formObj.port_cd);
								}
							} else {
								var errMsg = LseComGetErrMsg(sXml);
								if ( errMsg != "" ) {
									ComShowMessage(errMsg);
								}
								formObj.port_cd.value = "";
								ComSetFocus(formObj.port_cd);
							}
						}
					}
				}
				break;

			case IBSEARCH_ASYNC03:	//조회(Form VVD Code. 입력시)
				if(validateForm(sheetObj,formObj,sAction)) {
 					if ( sheetObj.id == "sheet1") {
 						ComSetObjValue(formObj.f_cmd, SEARCH03);
 						var param = "f_cmd="+SEARCH14+"&vvd_cd="+ComGetObjValue(formObj.vvd_cd);
 						sheetObj.WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",param);
						sheetObj.WaitImageVisible = true;

						if ( sXml != "" ) {
							if ( ComGetEtcData(sXml, "vvd_cd") != undefined ) {
								if ( ComGetEtcData(sXml, "vvd_cd") != "" ) {
									formObj.vvd_cd.value = ComGetEtcData(sXml, "vvd_cd");
									ComSetNextFocus(formObj.vvd_cd);
								}else{
									ComShowCodeMessage("LSE01109");
									formObj.vvd_cd.value = "";
									ComSetFocus(formObj.vvd_cd);
								}
							} else {
								var errMsg = LseComGetErrMsg(sXml);
								if ( errMsg != "" ) {
									ComShowMessage(errMsg);
								}
								formObj.vvd_cd.value = "";
								ComSetFocus(formObj.vvd_cd);
							}
						}
 					}
				}
				break;

 			case IBSEARCH_ASYNC04:	//조회(Form Agreement No. 입력시)
 				if(validateForm(sheetObj,formObj,sAction)) {
 					if ( sheetObj.id == "sheet1") {
 						ComSetObjValue(formObj.f_cmd, SEARCH03);
 						var param = "f_cmd="+SEARCH03+"&agmt_cty_cd="+ComGetObjValue(formObj.agmt_cty_cd)
 								  + "&agmt_seq="+ComGetObjValue(formObj.agmt_seq);
 						sheetObj.WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",param);
						sheetObj.WaitImageVisible = true;

						if ( sXml != "" ) {
							if ( ComGetEtcData(sXml, "lstm_cd") != undefined ) {
								ComSetObjValue(formObj.vndr_seq, ComGetEtcData(sXml, "vndr_seq"));
								doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC05);
							} else {
	 							ComShowCodeMessage("LSE01007");
	 							clearForm("agmt_seq");
	 						}
						} else {
							var errMsg = LseComGetErrMsg(sXml);
							if ( errMsg != "" ) {
								ComShowMessage(errMsg);
							}
							clearForm("agmt_seq");
						}
 					}
				}
				break;

			case IBSEARCH_ASYNC05:	//조회(Form Lessor No. 입력시)
				if ( validateForm(sheetObj, formObj, sAction) ) {
					var param = "f_cmd="+SEARCH06+"&vndr_seq="+ComGetObjValue(formObj.vndr_seq);
					sheetObj.WaitImageVisible = false;
					var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", param);
					sheetObj.WaitImageVisible = true;

					if ( sXml != "" ) {
						if ( ComGetEtcData(sXml, "vndr_lgl_eng_nm") != undefined ) {
							ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
							ComSetObjValue(formObj.vndr_abbr_nm, ComGetEtcData(sXml, "vndr_abbr_nm"));
							ComSetFocus(formObj.vndr_nm);
 						} else {
 							ComShowCodeMessage("LSE01019");
 							clearForm("vndr_seq");
 						}
					} else {
						var errMsg = LseComGetErrMsg(sXml);
						if ( errMsg != "" ) {
							ComShowMessage(errMsg);
						}
						clearForm("vndr_seq");
					}
				}
				break;

			case IBSEARCH_ASYNC06:	// 조회(Form Delivery SCC 입력시)
				if(validateForm(sheetObj,formObj,sAction)) {
					if ( sheetObj.id == "sheet1") {
						var param = "f_cmd="+SEARCH05+"&loc_tp=SCC&loc_cd="+ComGetObjValue(formObj.del_cd);
						sheetObj.WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",param);
						sheetObj.WaitImageVisible = true;
						if ( sXml != "" ) {
							if ( ComGetEtcData(sXml, "scc_cd") != undefined ) {
								if ( ComGetEtcData(sXml, "scc_cd") != "" ) {
									formObj.del_cd.value = ComGetEtcData(sXml, "scc_cd");
								}else{
									ComShowCodeMessage("LSE01048");
									formObj.del_cd.value = "";
									ComSetFocus(formObj.del_cd);
								}
							} else {
								var errMsg = LseComGetErrMsg(sXml);
								if ( errMsg != "" ) {
									ComShowMessage(errMsg);
								}
								formObj.del_cd.value = "";
								ComSetFocus(formObj.del_cd);
							}
						}
					}
				}
				break;

			case IBSEARCH_ASYNC07:	// 조회(Form Lane 입력시)
				if(validateForm(sheetObj,formObj,sAction)) {
					if ( sheetObj.id == "sheet1") {
						var param = "f_cmd="+SEARCH19+"&slan_cd="+ComGetObjValue(formObj.slan_cd);
						sheetObj.WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",param);
						sheetObj.WaitImageVisible = true;

						if ( sXml != "" ) {
							if ( ComGetEtcData(sXml, "slan_cd") != undefined ) {
								if ( ComGetEtcData(sXml, "slan_cd") != "" ) {
									formObj.slan_cd.value = ComGetEtcData(sXml, "slan_cd") ;
									ComSetNextFocus(formObj.slan_cd);
								}else{
									ComShowCodeMessage("LSE01048");
									formObj.slan_cd.value = "";
									ComSetFocus(formObj.slan_cd);
								}
							} else {
								var errMsg = LseComGetErrMsg(sXml);
								if ( errMsg != "" ) {
									ComShowMessage(errMsg);
								}
								formObj.slan_cd.value = "";
								ComSetFocus(formObj.slan_cd);
							}
						}
					}
				}
				break;

			case IBSEARCH_ASYNC08:	// Yard 조회
 				if(validateForm(sheetObj,formObj,sAction)) {
 					if ( sheetObj.id == "sheet1") {
 						var param = "f_cmd="+SEARCH+"&node_cd="+ComGetObjValue(formObj.loc_cd)
 								  + "&mode=yard";
 						sheetObj.WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("COM_ENS_061GS.do",param);
						sheetObj.WaitImageVisible = true;

						if ( ComGetTotalRows(sXml) == 1 ) {
							ComSetFocus(formObj.loc_cd);
						} else {
							ComShowCodeMessage("LSE01048");
							formObj.loc_cd.value = "";
							ComSetFocus(formObj.loc_cd);
						}
					}
				}

 				break;
        }
    }

	/**
     * 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	with(sheetObj) {
			for(var i = HeaderRows; i <= LastRow; i++) {
				var vRemQty  = Number(CellValue(i, "rem_qty"));
				var vTotQty  = Number(CellValue(i, "tot_qty"));
				var vHldQty  = Number(CellValue(i, "hld_qty"));
				var vCntrQty = Number(CellValue(i, "cntr_qty"));
				var vDolQty  = Number(CellValue(i, "dol_qty"));
				var vRstQty = vTotQty - vHldQty;

    			//var vEditFlag = (vRemQty != 0 && vRstQty > 0);
    			//==========================================================================
    			//[2010.04.22] Off-Hire Checking에 대한 DOL 제약사항을 삭제한다. - by 현업설계자
    			//--------------------------------------------------------------------------
    			//var vEditFlag = (vDolQty == 0 || vRemQty != 0) && vRstQty > 0;
    			//CellEditable(i, "del_chk") = vEditFlag;
    			CellText(i, "hld_qty") = vHldQty == 0 ? "" : vHldQty;
    			CellFontColor(i, "cntr_qty") = vCntrQty < 0 ? RgbColor(255, 0, 0) : RgbColor(0, 0, 255);
    			//CellText(i, "cntr_qty") = Math.abs(CellValue(i, "cntr_qty"));
    		}

			//특정 셀을 기준으로 인접한 셀과 강제로 머지한다.
			sheetObj.SetMergeCell(LastRow, 1, 1, 10);
			CellAlign(LastRow, "del_chk") = daCenter;
			sheetObj.CellText(LastRow, "del_chk") = "G.TTL";

			LseComBtnControl(false, "btn_DetailInquiry");
    		sheetObj.Redraw = true;
    	}

    	var formObj = document.form;
    	formObj.h_loc_case.value = ComGetObjValue(formObj.loc_case);
    	formObj.h_loc_tp.value = ComGetObjValue(formObj.loc_tp);
    	formObj.h_loc_cd.value = ComGetObjValue(formObj.loc_cd);
    	formObj.h_port_cd.value = ComGetObjValue(formObj.port_cd);
    	formObj.h_slan_cd.value = ComGetObjValue(formObj.slan_cd);
    	formObj.h_del_cd.value = ComGetObjValue(formObj.del_cd);
    	formObj.h_vvd_cd.value = ComGetObjValue(formObj.vvd_cd);
    	formObj.h_estm_tp.value = ComGetObjValue(formObj.estm_tp);
    	formObj.h_str_estm_dt.value = ComGetObjValue(formObj.str_estm_dt);
    	formObj.h_end_estm_dt.value = ComGetObjValue(formObj.end_estm_dt);
    	formObj.h_lstm_cd.value = ComGetObjValue(formObj.lstm_cd);
    	formObj.h_cntr_tpsz_cd.value = ComGetObjValue(formObj.cntr_tpsz_cd);
    	formObj.h_cnmv_sts_cd.value = ComGetObjValue(formObj.cnmv_sts_cd);
    	formObj.h_agmt_cty_cd.value = ComGetObjValue(formObj.agmt_cty_cd);
    	formObj.h_agmt_seq.value = ComGetObjValue(formObj.agmt_seq);
    	formObj.h_vndr_seq.value = ComGetObjValue(formObj.vndr_seq);
    	formObj.h_used_dys.value = ComGetObjValue(formObj.used_dys);
    	formObj.h_free_dys.value = ComGetObjValue(formObj.free_dys);
    	//formObj.h_min_onh_dys_tp.value = ComGetObjValue(formObj.min_onh_dys_tp);
    }

	/**
	 * Sheet의 OnChange Event 처리부분.<br>
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
	 */
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var formObj = document.form;

		with(sheetObj) {
			var sName = ColSaveName(Col);

			switch(sName) {
				case "del_chk":
					var vDelCheck = FindCheckedRow("del_chk").split("|");
					LseComBtnControl(vDelCheck.length > 1, "btn_DetailInquiry");
					break;
				default :
					//do nothing
			}
		}
 	}
	
	 /**
	 * make_detail_info :: detail에 전달할 정보를 생성하는 Event
	 */
	function make_detail_info(sheetObj) {
		with(sheetObj) {
			var formObj = document.form;
			var vDelCheck = FindCheckedRow("del_chk").split("|");
			var vComplexPk = "";
			var vComplexPk2 = "";
			var vComplexPk3 = "";
			var vComplexPk4 = "";
			var vComplexPk5 = "";
			var vComplexPk6 = "";
			var vComplexPk7 = "";
			var vComplexPk8 = "";
			var vComplexPk9 = "";
			var vComplexPk10 = "";
			var vComplexPk11 = "";
			var vComplexPk12 = "";
			var vComplexPk13 = "";
			var vComplexPk14 = "";
			var vComplexPk15 = "";
			var vComplexPk16 = "";
			var vComplexPk17 = "";
			var vComplexPk18 = "";
			var vComplexPk19 = "";
						
            for(var i=0; i<vDelCheck.length; i++) {
			  if(i < 200){
                if(vDelCheck[i] != "") {
                  if(i==0){ vComplexPk = "|"; };
                  vComplexPk += CellValue(vDelCheck[i], "scc_cd");
                  vComplexPk += CellValue(vDelCheck[i], "agmt_no");
                  vComplexPk += CellValue(vDelCheck[i], "cntr_tpsz_cd") +"|";
                }
			  }else if(i < 400){
                if(vDelCheck[i] != "") {
                  if(i==200){ vComplexPk2 = "|"; };
                  vComplexPk2 += CellValue(vDelCheck[i], "scc_cd");
                  vComplexPk2 += CellValue(vDelCheck[i], "agmt_no");
                  vComplexPk2 += CellValue(vDelCheck[i], "cntr_tpsz_cd") +"|";
                }
			  }
			  else if(i < 600){
                if(vDelCheck[i] != "") {
                  if(i==400){ vComplexPk3 = "|"; };
                  vComplexPk3 += CellValue(vDelCheck[i], "scc_cd");
                  vComplexPk3 += CellValue(vDelCheck[i], "agmt_no");
                  vComplexPk3 += CellValue(vDelCheck[i], "cntr_tpsz_cd") +"|";
                }
			  }else if(i < 800){
                if(vDelCheck[i] != "") {
                  if(i==600){ vComplexPk4 = "|"; };
                  vComplexPk4 += CellValue(vDelCheck[i], "scc_cd");
                  vComplexPk4 += CellValue(vDelCheck[i], "agmt_no");
                  vComplexPk4 += CellValue(vDelCheck[i], "cntr_tpsz_cd") +"|";
                }
			  }else if(i < 1000){
                if(vDelCheck[i] != "") {
                  if(i==800){ vComplexPk5 = "|"; };
                  vComplexPk5 += CellValue(vDelCheck[i], "scc_cd");
                  vComplexPk5 += CellValue(vDelCheck[i], "agmt_no");
                  vComplexPk5 += CellValue(vDelCheck[i], "cntr_tpsz_cd") +"|";
                }
			  }else if(i < 1200){
                if(vDelCheck[i] != "") {
                  if(i==1000){ vComplexPk6 = "|"; };
                  vComplexPk6 += CellValue(vDelCheck[i], "scc_cd");
                  vComplexPk6 += CellValue(vDelCheck[i], "agmt_no");
                  vComplexPk6 += CellValue(vDelCheck[i], "cntr_tpsz_cd") +"|";
                }
			  }else if(i < 1400){
                if(vDelCheck[i] != "") {
                  if(i==1200){ vComplexPk7 = "|"; };
                  vComplexPk7 += CellValue(vDelCheck[i], "scc_cd");
                  vComplexPk7 += CellValue(vDelCheck[i], "agmt_no");
                  vComplexPk7 += CellValue(vDelCheck[i], "cntr_tpsz_cd") +"|";
                }
			  }else if(i < 1600){
                if(vDelCheck[i] != "") {
                  if(i==1400){ vComplexPk8 = "|"; };
                  vComplexPk8 += CellValue(vDelCheck[i], "scc_cd");
                  vComplexPk8 += CellValue(vDelCheck[i], "agmt_no");
                  vComplexPk8 += CellValue(vDelCheck[i], "cntr_tpsz_cd") +"|";
                }
			  }else if(i < 1800){
                if(vDelCheck[i] != "") {
                  if(i==1600){ vComplexPk9 = "|"; };
                  vComplexPk9 += CellValue(vDelCheck[i], "scc_cd");
                  vComplexPk9 += CellValue(vDelCheck[i], "agmt_no");
                  vComplexPk9 += CellValue(vDelCheck[i], "cntr_tpsz_cd") +"|";
                }
			  }else if(i < 2000){
                if(vDelCheck[i] != "") {
                  if(i==1800){ vComplexPk10 = "|"; };
                  vComplexPk10 += CellValue(vDelCheck[i], "scc_cd");
                  vComplexPk10 += CellValue(vDelCheck[i], "agmt_no");
                  vComplexPk10 += CellValue(vDelCheck[i], "cntr_tpsz_cd") +"|";
                }
			  }else if(i < 2200){
                if(vDelCheck[i] != "") {
                  if(i==2000){ vComplexPk11 = "|"; };
                  vComplexPk11 += CellValue(vDelCheck[i], "scc_cd");
                  vComplexPk11 += CellValue(vDelCheck[i], "agmt_no");
                  vComplexPk11 += CellValue(vDelCheck[i], "cntr_tpsz_cd") +"|";
                }
			  }else if(i < 2400){
                if(vDelCheck[i] != "") {
                  if(i==2200){ vComplexPk12 = "|"; };
                  vComplexPk12 += CellValue(vDelCheck[i], "scc_cd");
                  vComplexPk12 += CellValue(vDelCheck[i], "agmt_no");
                  vComplexPk12 += CellValue(vDelCheck[i], "cntr_tpsz_cd") +"|";
                }
			  }else if(i < 2600){
                if(vDelCheck[i] != "") {
                  if(i==2400){ vComplexPk13 = "|"; };
                  vComplexPk13 += CellValue(vDelCheck[i], "scc_cd");
                  vComplexPk13 += CellValue(vDelCheck[i], "agmt_no");
                  vComplexPk13 += CellValue(vDelCheck[i], "cntr_tpsz_cd") +"|";
                }
			  }else if(i < 2800){
                if(vDelCheck[i] != "") {
                  if(i==2600){ vComplexPk14 = "|"; };
                  vComplexPk14 += CellValue(vDelCheck[i], "scc_cd");
                  vComplexPk14 += CellValue(vDelCheck[i], "agmt_no");
                  vComplexPk14 += CellValue(vDelCheck[i], "cntr_tpsz_cd") +"|";
                }
			  }else if(i < 3000){
                if(vDelCheck[i] != "") {
                  if(i==2800){ vComplexPk15 = "|"; };
                  vComplexPk15 += CellValue(vDelCheck[i], "scc_cd");
                  vComplexPk15 += CellValue(vDelCheck[i], "agmt_no");
                  vComplexPk15 += CellValue(vDelCheck[i], "cntr_tpsz_cd") +"|";
                }
			  }else if(i < 3200){
                if(vDelCheck[i] != "") {
                  if(i==3000){ vComplexPk16 = "|"; };
                  vComplexPk16 += CellValue(vDelCheck[i], "scc_cd");
                  vComplexPk16 += CellValue(vDelCheck[i], "agmt_no");
                  vComplexPk16 += CellValue(vDelCheck[i], "cntr_tpsz_cd") +"|";
                }
			  }else if(i < 3400){
                if(vDelCheck[i] != "") {
                  if(i==3200){ vComplexPk17 = "|"; };
                  vComplexPk17 += CellValue(vDelCheck[i], "scc_cd");
                  vComplexPk17 += CellValue(vDelCheck[i], "agmt_no");
                  vComplexPk17 += CellValue(vDelCheck[i], "cntr_tpsz_cd") +"|";
                }
			  }else if(i < 3600){
                if(vDelCheck[i] != "") {
                  if(i==3400){ vComplexPk18 = "|"; };
                  vComplexPk18 += CellValue(vDelCheck[i], "scc_cd");
                  vComplexPk18 += CellValue(vDelCheck[i], "agmt_no");
                  vComplexPk18 += CellValue(vDelCheck[i], "cntr_tpsz_cd") +"|";
                }
			  }else if(i < 3800){
                if(vDelCheck[i] != "") {
                  if(i==3600){ vComplexPk19 = "|"; };
                  vComplexPk19 += CellValue(vDelCheck[i], "scc_cd");
                  vComplexPk19 += CellValue(vDelCheck[i], "agmt_no");
                  vComplexPk19 += CellValue(vDelCheck[i], "cntr_tpsz_cd") +"|";
                }
			  }
            }
			
            ComSetObjValue(formObj.complex_pk,  vComplexPk);
			ComSetObjValue(formObj.complex_pk2, vComplexPk2);
			ComSetObjValue(formObj.complex_pk3, vComplexPk3);
			ComSetObjValue(formObj.complex_pk4, vComplexPk4);
			ComSetObjValue(formObj.complex_pk5, vComplexPk5);
			ComSetObjValue(formObj.complex_pk6, vComplexPk6);
			ComSetObjValue(formObj.complex_pk7, vComplexPk7);
			ComSetObjValue(formObj.complex_pk8, vComplexPk8);
			ComSetObjValue(formObj.complex_pk9, vComplexPk9);
			ComSetObjValue(formObj.complex_pk10, vComplexPk10);
			ComSetObjValue(formObj.complex_pk11, vComplexPk11);
			ComSetObjValue(formObj.complex_pk12, vComplexPk12);
			ComSetObjValue(formObj.complex_pk13, vComplexPk13);
			ComSetObjValue(formObj.complex_pk14, vComplexPk14);
			ComSetObjValue(formObj.complex_pk15, vComplexPk15);
			ComSetObjValue(formObj.complex_pk16, vComplexPk16);
			ComSetObjValue(formObj.complex_pk17, vComplexPk17);
			ComSetObjValue(formObj.complex_pk18, vComplexPk18);
			ComSetObjValue(formObj.complex_pk19, vComplexPk19);
		}
	 }

	/**
	 * sheet1_OnMouseMove :: 마우스가 Sheet 위에서 움직일 때 발생하는 Event
	 */
	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
		with(sheetObj) {
			//마우스 위치를 행과 컬럼과 값 가져오기
			Row = MouseRow;
			Col = MouseCol;
			if(Row >= HeaderRows && ColSaveName(Col) == "vndr_abbr_nm") {
				sText = CellText(Row,Col);
				//풍선도움말 만들기
				MouseToolTipText = CellText(Row,"vndr_seq") +"|"+ CellText(Row,"vndr_lgl_eng_nm");
			} else {
				MouseToolTipText = "";
			}
		}
	}

	/**
	 * MultiSelect속성을 이용하는 경우, 체크박스를 클릭하는 순간 발생한다.
	 * @return
	 */
	function combo1_OnCheckClick(comboObj, index, code) {
		if(index==0) {
			var bChk = comboObj.CheckIndex(index);
			if(bChk){
				for(var i = 1 ; i < comboObj.GetCount() ; i++) {
					comboObj.CheckIndex(i) = false;
				}
			}
		} else {
			comboObj.CheckIndex(0) = false;
		}
	}

	/**
	 * MultiSelect속성을 이용하는 경우, 체크박스를 클릭하는 순간 발생한다.
	 * @return
	 */
	function combo2_OnCheckClick(comboObj, index, code) {
		if(index==0) {
			var bChk = comboObj.CheckIndex(index);
			if(bChk){
				for(var i = 1 ; i < comboObj.GetCount() ; i++) {
					comboObj.CheckIndex(i) = false;
				}
			}
		} else {
			comboObj.CheckIndex(0) = false;
		}
	}

	/**
	 * MultiSelect속성을 이용하는 경우, 체크박스를 클릭하는 순간 발생한다.
	 * @return
	 */
	function combo3_OnCheckClick(comboObj, index, code) {
		if(index==0) {
			var bChk = comboObj.CheckIndex(index);
			if(bChk){
				for(var i = 1 ; i < comboObj.GetCount() ; i++) {
					comboObj.CheckIndex(i) = false;
				}
			}
		} else {
			comboObj.CheckIndex(0) = false;
		}
	}

    /**
	 * combo2_OnBlur
	 */
	function combo1_OnBlur(comboObj, Index_Code, Text) {
		var formObj = document.form;
		formObj.lstm_cd.value = ComGetObjValue(comboObj);
	}

    /**
	 * combo2_OnBlur
	 */
	function combo2_OnBlur(comboObj, Index_Code, Text) {
		var formObj = document.form;
		formObj.cntr_tpsz_cd.value = ComGetObjValue(comboObj);
	}

	/**
	 * combo3_OnBlur
	 */
	function combo3_OnBlur(comboObj, Index_Code, Text) {
		var formObj = document.form;
		formObj.cnmv_sts_cd.value = ComGetObjValue(comboObj);
	}

	/**
	 * combo1_OnKeyDown
	 * @deprecated 2009.07.21 IBCombo Single로 현재 사용되지 않는다.
	 */
	function combo1_OnKeyDown(comboObj, KeyCode, Shift) {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];

		with(comboObj) {
			if ( KeyCode == 8 || KeyCode == 46 ) {
				for ( var i = 0 ; i < GetCount() ; i++ ) {
					if ( CheckIndex(i) ) {
						//CheckIndex(i) = false;
					}
				}
			} else if(KeyCode == 13) {
				formObj.lstm_cd.value = ComGetObjValue(comboObj);
				doActionIBSheet(sheetObj, formObj, IBBATCH);
			}
		}
	}

	/**
	 * combo2_OnKeyDown
	 */
	function combo2_OnKeyDown(comboObj, KeyCode, Shift) {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];

		with(comboObj) {
			if ( KeyCode == 8 || KeyCode == 46 ) {
				for ( var i = 0 ; i < GetCount() ; i++ ) {
					if ( CheckIndex(i) ) {
						//CheckIndex(i) = false;
					}
				}
			} else if(KeyCode == 13) {
				formObj.cntr_tpsz_cd.value = ComGetObjValue(comboObj);
				doActionIBSheet(sheetObj, formObj, IBBATCH);
			}
		}
	}

	/**
	 * combo3_OnKeyDown
	 */
	function combo3_OnKeyDown(comboObj, KeyCode, Shift) {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];

		with(comboObj) {
			if ( KeyCode == 8 || KeyCode == 46 ) {
				for ( var i = 0 ; i < GetCount() ; i++ ) {
					if ( CheckIndex(i) ) {
						//CheckIndex(i) = false;
					}
				}
			} else if(KeyCode == 13) {
				formObj.cnmv_sts_cd.value = ComGetObjValue(comboObj);
				doActionIBSheet(sheetObj, formObj, IBBATCH);
			}
		}
	}

	/**
	 * IBMultiCombo에 대한 Default 체크처리를 수행한다.
	 * @deprecated 2009.09.25 IBCombo Default 설정은 현재 사용되지 않는다.
	 */
	function setDefaultComboCheck(comboObj, code) {
		var formObj = document.form;
		//do nothing

		//if(code) {
		//	comboObj.CheckCode(code) = true;
		//} else {
		//	comboObj.CheckIndex(0) = true;
		//}
	}

	/**
     * Pop-up Open 부분<br>
     * @param type 1:Lessor Code Popup for FORM, 2:Agreement No. Popup for FORM
     * @param Row 대상Object가 IBSheet일 경우 해당 Row index
     * @param Col 대상Object가 IBSheet일 경우 해당 Col index
     */
    function openPopup(type, Row, Col) {
    	var formObj = document.form;

    	if ( type == "1" ) {
    		switch(formObj.loc_tp.value) {
    			case "0" :	//RCC
    				ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430,"rcc_cd:loc_cd", "1,0,1,1,1,1,1", true);
    				break;
    			case "1" :	//LCC
    				ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430,"lcc_cd:loc_cd", "1,0,1,1,1,1,1", true);
    				break;
    			case "2" :	//SCC
    				ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430,"scc_cd:loc_cd", "1,0,1,1,1,1,1", true);
    				break;
    			case "3" :	//Yard
					ComOpenPopup("/hanjin/COM_ENS_061.do",755, 610, "setPopData_DeliveryLoc", "1,0,1,1,1,1,1,1", true);
    			default:	//do nothing
    		}
    	} else if ( type == "2" ) {
			ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430,"scc_cd:del_cd", "1,0,1,1,1,1,1", true);
    	} else if ( type == "3" ) {
    		ComOpenPopupWithTarget('/hanjin/COM_ENS_0B2.do', 770, 470,"vvd:vvd_cd", "1,0,1,1,1,1,1,1", true);
    	} else if ( type == "4" ) {
    		ComOpenPopup('/hanjin/EES_LSE_0091.do', 805, 450, 'setPopData_Agreement', '1,0', true);
    	} else if ( type == "5" ) {
    		ComOpenPopup('/hanjin/COM_ENS_0C1.do', 705, 450, 'setPopData_Lessor', '1,0,1,1,1,1,1,1', true);
    	} else if ( type == "6" ) {//Port
    		ComOpenPopupWithTarget('/hanjin/VOP_VSK_0043.do', 430, 500,"loc_cd:port_cd", "0,0", true);
    	} else if ( type == "7") {//Lane 조회 팝업
			ComOpenPopupWithTarget('/hanjin/COM_ENS_081.do', 800, 450, "col1:slan_cd", '1,0,1,1,1,1,1,1', true);
    	} else if ( type == "8") {
    		var formObj = document.form;
			//var vDelCheck = sheetObjects[0].FindCheckedRow("del_chk").split("|");
			//200 행까지 체크	
			//if( vDelCheck.length > 201 ){
			//	ComShowCodeMessage("LSE01157");
			//}else{
	    		make_detail_info(sheetObjects[0]);
	    		formObj.f_cmd.value = "";
	    		ComPostOpenWindow("/hanjin/EES_LSE_0021.do", "EES_LSE_0021", "status=no, resizable=no, width=855, height=455");				
			//}
			
    	}

    	return;
    }

	/**
     * Agreement Pop-up Return Value 처리 부분<br>
     * @param {arry} returnedValues Pop-up 화면의 Return value array
     * @param Row 대상Object가 IBSheet일 경우 해당 Row index
     * @param Col 대상Object가 IBSheet일 경우 해당 Col index
     * @param 대상IBSheet의 Sheet Array index
     */
    function setPopData_Agreement(aryPopupData, Row, Col, SheetIdx) {
    	var sheetObj = sheetObjects[SheetIdx];
    	var formObj  = document.form;

    	if ( aryPopupData.length > 0 ) {
			ComSetObjValue(formObj.agmt_seq, aryPopupData[0][4]);
    		ComSetObjValue(formObj.vndr_seq, aryPopupData[0][7]);
    		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC05);
    	}
    }

    /**
	 * Lessor(Service Provider) Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param 대상IBSheet의 Sheet Array index
	 */
	function setPopData_Lessor(aryPopupData, Row, Col, SheetIdx) {
		var sheetObj = sheetObjects[SheetIdx];
		var formObj  = document.form;

		if ( aryPopupData.length > 0 ) {
			ComSetObjValue(formObj.vndr_seq, ComLtrim(aryPopupData[0][2],"0"));
			ComSetObjValue(formObj.vndr_abbr_nm,  aryPopupData[0][5]);
			ComSetObjValue(formObj.vndr_nm,  aryPopupData[0][4]);
		}
	}

	/**
      * DeliveryLoc(Yard) Pop-up Return Value 처리 부분<br>
      * @param {arry} returnedValues Pop-up 화면의 Return value array
      * @param Row 대상Object가 IBSheet일 경우 해당 Row index
      * @param Col 대상Object가 IBSheet일 경우 해당 Col index
      * @param 대상IBSheet의 Sheet Array index
      */
     function setPopData_DeliveryLoc(aryPopupData, Row, Col, SheetIdx) {
     	var sheetObj = sheetObjects[SheetIdx];
     	var formObj  = document.form;

     	if ( aryPopupData.length > 0 ) {
     		if ( formObj.loc_tp.value == "3" ) {
				ComSetObjValue(formObj.loc_cd, aryPopupData[0][3]);
			}
     	}
     }

	/**
	 * 메일팝업 화면이 종료시 호출되는 콜백메서드
	 */
	function callbackPopupMail(interval) {
		timer2 = setInterval(delayActionIBSheet, interval);
	}

	/**
	 * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
	 */
	function getBackEndJobStatus() {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];

		formObj.f_cmd.value = COMMAND02;
		var sXml = sheetObj.GetSearchXml("EES_LSE_0020GS.do", FormQueryString(formObj));
		var jobState = ComGetEtcData(sXml, "jb_sts_flg");
		if (jobState == "3") {
			getBackEndJobLoadFile();
			clearInterval(timer1);
		} else if (jobState == "4") {
			ComShowCodeMessage("LSE01124");
			ComOpenWait(false);
			sheetObj.WaitImageVisible = true;
			clearInterval(timer1);
		} else if (jobState == "5") {
			ComShowCodeMessage("LSE01125");
			clearInterval(timer1);
		}
	}

	/**
	 * BackEndJob의 결과가 완료되면 Excel파일로 내려받음
	 */
	function getBackEndJobLoadFile() {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];

		formObj.f_cmd.value = COMMAND03;
		var sXml = sheetObj.GetSearchXml("EES_LSE_0020GS.do", FormQueryString(form));
		sheetObj.LoadSearchXml(sXml);
		ComOpenWait(false);
		sheetObj.WaitImageVisible = true;
	}

	/**
	 * 지연된 Sheet관련 프로세스 처리
	 */
	function delayActionIBSheet() {
		var formObj = document.form;
		//doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
		doActionIBSheet(sheetObjects[0], formObj, IBBATCH);
		clearInterval(timer2);
	}

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj) {
    		switch(sAction) {
    			case IBSEARCH:      //조회
    			case IBBATCH:      	//조회-BackEndJob
    				if(formObj.loc_cd.className == "input1" && formObj.loc_cd.value == "") {
    					ComShowCodeMessage("LSE01046");
    					ComSetFocus(formObj.loc_cd);
						return false;
					} else if(formObj.slan_cd.className == "input1" && formObj.slan_cd.value == "") {
    					ComShowCodeMessage("LSE01156", "Vessel Lane ");
    					ComSetFocus(formObj.slan_cd);
    					return false;
    				} else if(formObj.port_cd.className == "input1" && formObj.port_cd.value == "") {
    					ComShowCodeMessage("LSE01156", "Vessel Port ");
    					ComSetFocus(formObj.port_cd);
    					return false;
    				} else if (!checkDurationDate()) {
    					return false;
    				} else if (formObj.loc_cd.className == "input" && formObj.loc_cd.value == "") {
    					if (formObj.lstm_cd.value == "" || formObj.lstm_cd.value == "ALL"){
        					ComShowCodeMessage("LSE01156", "Lease Term code except ALL ");
        					return false;
    					}
    					if (formObj.cnmv_sts_cd.value == "" || formObj.cnmv_sts_cd.value == "ALL"){
        					ComShowCodeMessage("LSE01156", "MVMT Status code except ALL ");
        					return false;
    					}
    				}

    				return ComChkValid(formObj, true);
    				break;
				default :	//do nothing
    		}
    	}

        return true;
    }

	/**
	 * Duration Date Validation 처리 부분<br>
	 */
    function checkDurationDate(eventObj) {
    	var formObj = document.form;
    	var vEffDt = ComReplaceStr(ComGetObjValue(formObj.str_estm_dt),"-","");
		var vExpDt = ComReplaceStr(ComGetObjValue(formObj.end_estm_dt),"-","");

		//Division is Location인 경우만 제외한다.
		if(formObj.loc_case.value == "1") return true;

    	//Duration이 필수입력이 아닌경우
    	if(formObj.str_estm_dt.className == "input") {
	    	if( vEffDt == "" && vExpDt == "" ) {
	    		return true;
	    	}
    	}

		/* Duration Date Validation(str_estm_dt) */
		if(vEffDt == "" && eventObj == null) {
			ComShowCodeMessage("LSE01078");
			ComSetFocus(formObj.str_estm_dt);
			return false;
		} else if(vEffDt == "" && eventObj.name == "str_estm_dt") {
			//ComShowCodeMessage("LSE01078");
			//ComSetFocus(formObj.str_estm_dt);
			//return false;
		} else if (vEffDt != "" && !ComIsDate(formObj.str_estm_dt) ) {
			ComShowCodeMessage("LSE01080");
			ComSetObjValue(formObj.str_estm_dt,"");
			ComSetFocus(formObj.str_estm_dt);
			return false;
		}

		/* Duration Date Validation(end_estm_dt) */
		if(vExpDt == "" && eventObj == null) {
			ComShowCodeMessage("LSE01079");
			ComSetFocus(formObj.end_estm_dt);
			return false;
		} else if(vExpDt == "" && eventObj.name == "end_estm_dt") {
			//ComShowCodeMessage("LSE01079");
			//ComSetFocus(formObj.end_estm_dt);
			//return false;
		} else if (vExpDt != "" && !ComIsDate(formObj.end_estm_dt) ) {
			ComShowCodeMessage("LSE01081");
			ComSetObjValue(formObj.end_estm_dt,"");
			ComSetFocus(formObj.end_estm_dt);
			return false;
		}

		/* Duration Date Validation(str_estm_dt < end_estm_dt) */
		if(vEffDt != "" && vExpDt != "") {
			if ( ComChkPeriod(vEffDt, vExpDt) != 1 ) {
				ComShowCodeMessage("LSE01082");

				if(eventObj == null) {
					ComSetObjValue(formObj.end_estm_dt,"");
					ComSetFocus(formObj.end_estm_dt);
				} else {
					ComSetObjValue(eventObj,"");
					ComSetFocus(eventObj);
				}
				return false;
			}
		}

		return true;
    }

	/**
	 * Division의 값에 따라 종속된 Object에 대한 가시성을 설정한다.
	 */
	function setEnableSwitch(value) {
		var formObj = document.form;

		if(value == "0") {
			ComEnableObject(formObj.btns_search1,  true);
			ComEnableObject(formObj.btns_search2,  true);
			ComEnableObject(formObj.btns_search3,  true);
			ComEnableObject(formObj.btns_search6,  true);
			ComEnableObject(formObj.btns_search7,  true);
			ComEnableObject(formObj.btns_calendar, true);
			ComEnableObject(formObj.loc_tp, 	   true);
			ComEnableObject(formObj.loc_cd, 	   true);
			ComEnableObject(formObj.port_cd, 	   true);
			ComEnableObject(formObj.slan_cd, 	   true);
			ComEnableObject(formObj.del_cd, 	   true);
			ComEnableObject(formObj.vvd_cd, 	   true);
			ComEnableObject(formObj.str_estm_dt,   true);
			ComEnableObject(formObj.end_estm_dt,   true);
			if(formObj.loc_tp.value == "0") // 20160609 not mandatory , RCC => aLL available.
	               formObj.loc_cd.className = "input";
			else   formObj.loc_cd.className = "input1";
			//formObj.loc_cd.className  = "input1";
		//	formObj.slan_cd.className = "input1";
		} else {
			ComEnableObject(formObj.btns_search1,  value == "1");
			ComEnableObject(formObj.btns_search2,  value != "1");
			ComEnableObject(formObj.btns_search3,  value != "1");
			ComEnableObject(formObj.btns_search6,  value != "1");
			ComEnableObject(formObj.btns_search7,  value != "1");
			ComEnableObject(formObj.btns_calendar, value != "1");
			ComEnableObject(formObj.loc_tp, 	   value == "1");
			ComEnableObject(formObj.loc_cd, 	   value == "1");
			ComEnableObject(formObj.port_cd, 	   value != "1");
			ComEnableObject(formObj.slan_cd, 	   value != "1");
			ComEnableObject(formObj.del_cd, 	   value != "1");
			ComEnableObject(formObj.vvd_cd, 	   value != "1");
			ComEnableObject(formObj.str_estm_dt,   value != "1");
			ComEnableObject(formObj.end_estm_dt,   value != "1");
			if(value == "1") {
				if(formObj.loc_tp.value == "0"){ // 20160609 not mandatory , RCC => aLL available.
		               formObj.loc_cd.className = "input";
		               formObj.combo1.BackColor = "#ccffff";
		               formObj.combo3.BackColor = "#ccffff";
				} else {
					   formObj.loc_cd.className = "input1";
		               formObj.combo1.BackColor = "#ffffff";
		               formObj.combo3.BackColor = "#ffffff";
				}

				//formObj.loc_cd.className   = "input1";
			} else if(value == "3") {
				formObj.slan_cd.className  = "input1";
			} else {
				formObj.port_cd.className  = "input1";
			}
		}

		if(value != "1") {//loc_case is Port
			var vCurrDate = formObj.h_curr_dt.value;
			formObj.str_estm_dt.value = vCurrDate;
			formObj.end_estm_dt.value = ComGetDateAdd(vCurrDate, "D", 7);
		}

		LseComBtnControl(false, "btn_DetailInquiry");
	}

    /**
	 * Form Element Clear 처리부분.<br>
	 * @param fieldName
	 */
	function clearForm(fieldName) {
		var formObj = document.form;
		switch(fieldName) {
			case "agmt_seq":
				ComSetObjValue(formObj.agmt_seq,    "");
				ComSetFocus(formObj.agmt_seq);
				break;
			case "vndr_seq":
				ComSetObjValue(formObj.vndr_seq, 	"");
				ComSetObjValue(formObj.vndr_nm,  	"");
				ComSetObjValue(formObj.vndr_abbr_nm,"");
				ComSetFocus(formObj.vndr_seq);
				break;
			case "port_loc":
				ComSetObjValue(formObj.loc_cd, 		"");
				ComSetObjValue(formObj.port_cd, 	"");
				ComSetObjValue(formObj.slan_cd, 	"");
				ComSetObjValue(formObj.del_cd, 		"");
				ComSetObjValue(formObj.str_estm_dt,	"");
				ComSetObjValue(formObj.end_estm_dt,	"");
				ComSetObjValue(formObj.vvd_cd,  	"");
				break;
		}
	}
	/* 개발자 작업  끝 */