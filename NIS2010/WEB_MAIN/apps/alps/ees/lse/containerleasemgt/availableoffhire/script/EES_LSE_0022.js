/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_LSE_0022.js
 *@FileTitle :Off-Hire Confirm from Lessor
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.09
 *@LastModifier : 장준우
 *@LastVersion : 1.0
 * 2009.10.09 장준우
 * 1.0 Creation
 * =====================================================
 *  2010.12.02 박명신 [CHM-201007443-01] Ref No. 자리 변경
 *  2011.01.27 남궁진호 [CHM-201108164-01] 공통 팝업 (COM_ENS_051, COM_ENS_0C1) Open Size 조정
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
	 * @class EES_LSE_0022 : EES_LSE_0022 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_LSE_0022() {
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
		this.sheet1_OnValidation = sheet1_OnValidation;
		this.sheet1_OnSaveEnd 	= sheet1_OnSaveEnd;
		this.sheet1_OnSearchEnd = sheet1_OnSearchEnd;
		this.sheet1_OnChange 	= sheet1_OnChange;
		this.sheet1_OnMouseMove = sheet1_OnMouseMove;
		this.sheet1_OnDblClick  = sheet1_OnDblClick;
		this.sheet1_OnPopupClick = sheet1_OnPopupClick;
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
		this.setPopData_Lessor 	 = setPopData_Lessor;
		this.setPopData_YardCode = setPopData_YardCode;
		this.getBackEndJobStatus = getBackEndJobStatus;
		this.getBackEndJobLoadFile = getBackEndJobLoadFile;
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
				case "btn_retrieve":
					if(ComChkValid(formObj) == true) {
						//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
						doActionIBSheet(sheetObjects[0],document.form,IBBATCH);
					}
					break;

				case "btn_new":
					ComResetAll();
					setEnableSwitch("1");
					sheetObject.MoveColumnPos("vvd_cd", 38);
					for ( var k = 0 ; k < comboObjects.length ; k++ ) {
				        setDefaultComboCheck(comboObjects[k]);
				    }
					ComSetFocus(formObj.loc_cd);
					break;

				case "btn_save":
					doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
					break;

				case "btn_DownExcel":
					sheetObject.Down2Excel(-1, false, false, true);
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
				case "cntr_no_multi":
					if ( srcObj.style.filter == "" ) {
						rep_Multiful_inq_cntr("cntr_list");
					}
					break;
				case "btn_Creation":
					openPopupMST();
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
					sheetObj.MoveColumnPos("vvd_cd", "crnt_yd_cd");
				}else if (obj.value == "3"){
					ComSetFocus(formObj.cntr_list);
				}else {
					ComSetFocus(formObj.loc_cd);
					sheetObj.MoveColumnPos("vvd_cd", 38);
				}

				break;
			case "loc_tp":		//Location Type
				formObj.loc_cd.value = "";
				formObj.loc_cd.maxLength = obj.value == "3" ? 7 : 5;
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
                    InitRowInfo(1, 1, 3, 100);

					var HeadTitle1 = "|Sel.|Seq.||Lessor|Lessor||AGMT No.|||Ref No.|Lease\nTerm|TP/SZ|CNTR No.|Current\nYard|Return\nYard|* Off-Hire  \nStatus|Off-Hire\nCFRM Date|* Off-Hire  \nYard|* Off-Hire  \nDue Date|Off-Hire\nReference No.|MT/Full|MVMT\nStatus|MVMT\nDate|On-hire\nYard"
								   + "|On-hire\nDate|Min On-hire\nDays|Used\nDays|Free\nDays|M&R Cost|BKG No.|B/L No.|POL|POD|DEL|R.Office|ETD-DT|ETA-DT|T.VVD|TRS S/O No.|TRS W/O No.|TRS Invoice No.|TRS S/P\nCode|TRS S/P\nName|||||||||||||Request\nOffice CD|Request\nUser ID|Confirm\nUser ID";
					var headCount = ComCountHeadTitle(HeadTitle1);

		            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		            InitColumnInfo(headCount, 14, 0, true);

		            // 해더에서 처리할 수 있는 각종 기능을 설정한다
		            InitHeadMode(true, true, false, true, false,false)

		            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		            InitHeadRow(0, HeadTitle1, true);

		            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		            InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,	"del_chk");
					InitDataProperty(0, cnt++ , dtDataSeq,		40,		daCenter,	true,	"seq_no");
		            InitDataProperty(0, cnt++ , dtHidden,      	50,		daCenter,	true,	"scc_cd",			false,	"",		dfNone, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtData,      	50,		daCenter,	true,	"vndr_seq",			false,	"",		dfNone, 	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	65,		daCenter,	true,	"vndr_abbr_nm",		false,	"",		dfNone, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtHidden,      	80,		daCenter,	true,	"vndr_lgl_eng_nm",	false,	"",		dfNone, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtData,      	75,		daCenter,	true,	"agmt_no",			false,	"",		dfNone, 	0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      	50,		daCenter,	true,	"agmt_cty_cd",		false,	"",		dfNone, 	0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      	60,		daCenter,	true,	"agmt_seq",			false,	"",		dfNone, 	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,     	120,   	daLeft,		true,	"ref_no",			false,	"",		dfNone, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtData,     	55,   	daCenter,	true,	"lstm_cd",			false,	"",		dfNone, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtData,      	50,		daCenter,	true,	"cntr_tpsz_cd",		false,	"",		dfNone, 	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,     	90,   	daCenter,	true,	"cntr_no",			false,	"",		dfNone, 	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,     	70,   	daCenter,	true,	"crnt_yd_cd",		false,	"",		dfNone, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtPopupEdit,   	75,		daCenter,	true,	"mty_rtn_yd_cd",	false,	"",		dfEngUpKey,	0,	true,	false, 7);
		            InitDataProperty(0, cnt++ , dtCombo,   	  	65,  	daCenter,	true,	"offh_sts_cd",		false,	"",		dfNone, 	0,	true,	false);
		            InitDataProperty(0, cnt++ , dtData,   	  	85,  	daCenter,	true,	"offh_cnfm_dt",		false,	"",		dfDateYmd, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtPopupEdit,   	75,		daCenter,	true,	"offh_yd_cd",		false,	"",		dfEngUpKey,	0,	false,	false, 7);
		            InitDataProperty(0, cnt++ , dtData,   		80,		daCenter,	true,	"offh_due_dt",		false,	"",		dfDateYmd, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtData,   		120,	daCenter,	true,	"offh_ref_no",		false,	"",		dfEngUpKey,	0,	false,	false, 20);
		            InitDataProperty(0, cnt++ , dtData,      	55,		daCenter,	true,	"full_flg",			false,	"",		dfNone, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtData,      	60,		daCenter,	true,	"mvmt_sts_cd",		false,	"",		dfNone, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtData,      	85,		daCenter,	true,	"cnmv_dt",			false,	"",		dfDateYmd, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtData,      	65,		daCenter,	true,	"onh_yd_cd",		false,	"",		dfNone, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtData,      	85,		daCenter,	true,	"onh_dt",			false,	"",		dfDateYmd, 	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	75,		daRight,	true,	"min_onh_dys",		false,	"",		dfInteger, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtData,      	70,		daRight,	true,	"used_days",		false,	"",		dfInteger, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtData,      	70,		daRight,	true,	"onh_free_dys",		false,	"",		dfInteger, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtData,      	80,		daRight,	true,	"mnr_cost",			false,	"",		dfFloat, 	2,	false,	false);
		            InitDataProperty(0, cnt++ , dtData,      	100,	daCenter,	true,	"bkg_no",			false,	"",		dfNone, 	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	100,	daCenter,	true,	"bl_no",			false,	"",		dfNone, 	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	60,		daCenter,	true,	"pol_cd",			false,	"",		dfNone, 	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	60,		daCenter,	true,	"pod_cd",			false,	"",		dfNone, 	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	60,		daCenter,	true,	"del_cd",			false,	"",		dfNone, 	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	70,		daCenter,	true,	"evnt_ofc_cd",		false,	"",		dfNone, 	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	85,		daCenter,	true,	"pol_etd_dt",		false,	"",		dfDateYmd, 	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	85,		daCenter,	true,	"pod_eta_dt",		false,	"",		dfDateYmd, 	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	80,		daCenter,	true,	"vvd_cd",			false,	"",		dfNone, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtData,    		90,		daCenter,	true,	"trs_so_no",		false,	"",		dfNone, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtData,   	  	90,		daCenter,	true,	"trs_wo_no",		false,	"",		dfNone, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtData,    		100,	daCenter,	true,	"trs_inv_no",		false,	"",		dfNone, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtData,    		70,		daCenter,	true,	"trs_sp_cd",		false,	"",		dfNone, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtData,    		70,		daCenter,	true,	"trs_sp_nm",		false,	"",		dfNone, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtHidden,  	  	50,  	daCenter,	true,	"offh_seq",			false,	"",		dfNone, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtHidden,      	70,		daRight,	true,	"rem_qty",			false,	"",		dfInteger, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtHidden,      	70,		daRight,	true,	"cfm_qty",			false,	"",		dfInteger, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtHidden,      	70,		daRight,	true,	"tot_qty",			false,	"",		dfInteger, 	0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      	70,		daRight,	true,	"cntr_qty",			false,	"",		dfInteger, 	0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      	120,	daCenter,	true,	"complex_pk",		false,	"",		dfNone, 	0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,  	  	85,  	daCenter,	true,	"org_offh_cnfm_dt",	false,	"",		dfDateYmd, 	0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,   	75,		daCenter,	true,	"org_offh_yd_cd",	false,	"",		dfEngUpKey,	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtHidden,  		80,		daCenter,	true,	"org_offh_due_dt",	false,	"",		dfDateYmd, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtHidden,   	75,		daCenter,	true,	"org_rtn_yd_cd",	false,	"",		dfEngUpKey,	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtHidden,   	75,		daCenter,	true,	"lse_vndr_url",		false,	"",		dfNone,		0,	false,	false);
		            InitDataProperty(0, cnt++ , dtHidden,   	75,		daCenter,	true,	"org_offh_ref_no",	false,	"",		dfEngUpKey,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,   	  	75,  	daCenter,	true,	"rqst_ofc_cd",		false,	"",		dfNone,		0,	false,	false);
		            InitDataProperty(0, cnt++ , dtData,   	  	85,  	daCenter,	true,	"snd_usr_id",		false,	"",		dfNone,		0,	false,	false);
		            InitDataProperty(0, cnt++ , dtData,   	  	85,  	daCenter,	true,	"cfm_usr_id",		false,	"",		dfNone,		0,	false,	false);

					InitDataCombo(0, "offh_sts_cd", 	"Request|Confirm|Cancel", 	"R|C|D");
					InitDataValid(0, "mty_rtn_yd_cd",	vtEngUpOther, "0123456789");
					InitDataValid(0, "offh_yd_cd",		vtEngUpOther, "0123456789");
					InitDataValid(0, "offh_ref_no",		vtEngUpOther, "0123456789-");

					//CellFontColor(0,"mty_rtn_yd_cd") = LSE_MANDATORY_FONT_COLOR;
					CellFontColor(0,"offh_sts_cd") = LSE_MANDATORY_FONT_COLOR;
					CellFontColor(0,"offh_yd_cd") = LSE_MANDATORY_FONT_COLOR;
					CellFontColor(0,"offh_due_dt") = LSE_MANDATORY_FONT_COLOR;

					SelectBackColor = LSE_SELECT_BACK_COLOR;
					SelectionMode = 0;
					MultiSelection = true;
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
						sheetObj.DoSearch4Post("EES_LSE_0022GS.do",FormQueryString(formObj));
					}
				}
				break;

			case IBBATCH:      //조회-BackEndJob
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet1") {
						formObj.f_cmd.value = COMMAND01;
						sheetObj.WaitImageVisible = false;
						ComOpenWait(true);

						var sXml = sheetObj.GetSearchXml("EES_LSE_0022GS.do", FormQueryString(formObj));
						var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");

						if (backendJobKey.length > 0) {
							ComSetObjValue(formObj.backendjob_key, backendJobKey);
							sheetObj.RequestTimeOut = 10000;
							timer = setInterval(getBackEndJobStatus, 3000);
						}
					}
				}
				break;

			case IBSAVE:			//저장
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet1") {
						formObj.f_cmd.value = MULTI;
						sheetObj.DoSave("EES_LSE_0022GS.do", FormQueryString(formObj), -1, false);
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
     * 저장처리 전에 유효성 검사를 할수 있도록 발생하는 Event
     * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
     */
    function sheet1_OnValidation(sheetObj, Row, Col, Value) {
    	with(sheetObj) {
	    	//저장처리 전에 유효성 검사를 할수 있도록 발생하는 이벤트
			//if(RowStatus(Row) == "D") return;

			//필수입력 항목 체크처리
			if(CellValue(Row, "offh_sts_cd") == "C") {
				if(CellValue(Row, "mty_rtn_yd_cd") == "") {
					ComShowCodeMessage("LSE01070");
					ValidateFail = true;
			        SelectCell(Row, "mty_rtn_yd_cd");
					return;
				}
				if(CellValue(Row, "offh_yd_cd") == "") {
					ComShowCodeMessage("LSE01106");
					ValidateFail = true;
			        SelectCell(Row, "offh_yd_cd");
					return;
				}
				if(CellValue(Row, "offh_due_dt") == "") {
					ComShowCodeMessage("LSE01107");
					ValidateFail = true;
			        SelectCell(Row, "offh_due_dt");
					return;
				}
			}
    	}
    }

	/**
     * 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	if(!/Error/.test(ErrMsg)) {
    		ComShowCodeMessage("LSE10001");
			//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			doActionIBSheet(sheetObjects[0],document.form,IBBATCH);
    	}
    }

	/**
     * 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		var vCanselFlg = false;
    	with(sheetObj) {
    		ColFontColor("snd_usr_id") = RgbColor(0, 0, 255);
    		ColFontColor("cfm_usr_id") = RgbColor(0, 0, 255);

			for(var i = HeaderRows; i <= LastRow; i++) {
				if(CellValue(i, "lse_vndr_url") != "") {
    				CellFontColor(i, "vndr_seq") = RgbColor(0, 0, 255);
				}

				if(CellValue(i, "trs_so_no") != "") {//TRS 연동자료에 대한 자료처리를 불가한다.
					//RowEditable(i) = false;
					CellEditable(i, "mty_rtn_yd_cd")  = false;
					CellEditable(i, "offh_sts_cd")    = false;
					CellEditable(i, "offh_yd_cd")     = false;
					CellEditable(i, "offh_due_dt")    = true;
					CellEditable(i, "offh_ref_no")    = false;
				} else if(CellValue(i, "offh_sts_cd") == "C") {//기 Confirm 된 자료의 복원을 위한 값을 임시 보관한다.
					CellEditable(i, "offh_yd_cd")     = true;
					CellEditable(i, "offh_due_dt")    = true;
					CellEditable(i, "offh_ref_no")    = true;
					CellValue2(i, "org_offh_cnfm_dt") = CellValue(i, "offh_cnfm_dt");
					CellValue2(i, "org_offh_yd_cd")   = CellValue(i, "offh_yd_cd");
					CellValue2(i, "org_offh_due_dt")  = CellValue(i, "offh_due_dt");
					CellValue2(i, "org_offh_ref_no")  = CellValue(i, "offh_ref_no");
					RowStatus(i) = "R";
				}
				
				if(CellValue(i, "offh_sts_cd") == "D"){
					//조회 결과에 Off-Hire Status가 Cansel이 있는지 체크
					vCanselFlg = true;
					RowStatus(i) = "U";
					
					CellFontColor(i, "seq_no") = RgbColor(255, 0, 0);
					CellFontColor(i, "vndr_seq") = RgbColor(255, 0, 0);
					CellFontColor(i, "vndr_abbr_nm") = RgbColor(255, 0, 0);
					CellFontColor(i, "agmt_no") = RgbColor(255, 0, 0);
					CellFontColor(i, "ref_no") = RgbColor(255, 0, 0);
					CellFontColor(i, "lstm_cd") = RgbColor(255, 0, 0);
					CellFontColor(i, "cntr_tpsz_cd") = RgbColor(255, 0, 0);
					CellFontColor(i, "cntr_no") = RgbColor(255, 0, 0);
					CellFontColor(i, "crnt_yd_cd") = RgbColor(255, 0, 0);
					CellFontColor(i, "mty_rtn_yd_cd") = RgbColor(255, 0, 0);
				}
    		}
			
			if(vCanselFlg){
				ComShowCodeMessage("LSE01149");
			}
    	}
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
				case "offh_sts_cd":
					var vEditFlag = Value == "C";
					CellEditable(Row, "offh_yd_cd")    = vEditFlag;
					CellEditable(Row, "offh_due_dt")   = vEditFlag;
					CellEditable(Row, "offh_ref_no")   = vEditFlag;

					if(vEditFlag == true) {
						var vChkCount = 0;
						var vMaxCount = CellValue(Row, "cntr_qty");
						var vComplexPk = CellValue(Row, "complex_pk");

						if(CellValue(Row, "tot_qty") - CellValue(Row, "rem_qty") > 0) {
							for(var i = HeaderRows; i <= LastRow; i++) {
								if(vComplexPk == CellValue(i, "complex_pk") && RowStatus(i) == "U") {
									if(CellValue(i, "offh_sts_cd") == "C" && CellValue(i, "offh_cnfm_dt") == "") {
										if(CellValue(i, "org_offh_cnfm_dt") == "") {
											vChkCount++;
										}
									} else if(/R|D/.test(CellValue(i, "offh_sts_cd"))) {
										vChkCount--;
								 	} else {
										vChkCount;
								 	}
								}
							}

							if(vChkCount > vMaxCount) {
								//ComShowCodeMessage("LSE01148", vMaxCount);
								if(ComShowConfirm(ComGetMsg("LSE01152")) == false) {
									CellValue(Row, "offh_sts_cd") = "R";
								}
								return;
							}
						}
					}

					//기 Confirm 된 자료의 복원을 위한 값을 재할당한다.
					CellValue2(Row, "offh_cnfm_dt")  = vEditFlag ? CellValue(Row, "org_offh_cnfm_dt") : "";
					CellValue2(Row, "offh_yd_cd")    = vEditFlag ? CellValue(Row, "org_offh_yd_cd") : "";
					CellValue2(Row, "offh_due_dt")   = vEditFlag ? CellValue(Row, "org_offh_due_dt") : "";
					CellValue2(Row, "offh_ref_no")   = vEditFlag ? CellValue(Row, "org_offh_ref_no") : "";
					CellValue2(Row, "mty_rtn_yd_cd") = vEditFlag ? CellValue(Row, "crnt_yd_cd") : CellValue(Row, "org_rtn_yd_cd");

					//========================================================
					//if(vEditFlag && CellValue(Row, "mty_rtn_yd_cd") == CellValue(Row, "org_rtn_yd_cd")) {
					//	  RowStatus(Row) = "R";
					//}
					break;

				case "mty_rtn_yd_cd":		// Grid Yard Code Check
					if(CellValue(Row,Col) != "") {
						var param = "f_cmd="+SEARCH+"&node_cd="+CellValue(Row,Col)
 								  + "&mode=yard";
 						sheetObj.WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("COM_ENS_061GS.do",param);
						sheetObj.WaitImageVisible = true;

						if ( ComGetTotalRows(sXml) != 1 ) {
							CellValue2(Row,"mty_rtn_yd_cd") = "";
							ComShowCodeMessage("LSE01048");
						}
					}
					break;

				case "offh_yd_cd":		// Off-Hire Yard Code Check
					if(CellValue(Row,Col) != "") {
						var param = "f_cmd="+SEARCH18+"&yd_cd="+CellValue(Row,Col);
						sheetObj.WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",param);
						sheetObj.WaitImageVisible = true;
						if ( sXml != "" ) {
							if ( ComGetEtcData(sXml, "offh_yd_cd") != undefined ) {
								if ( ComGetEtcData(sXml, "offh_yd_cd") != "" ) {
									CellValue2(Row,"offh_yd_cd") = ComGetEtcData(sXml, "offh_yd_cd");
								}else{
									CellValue2(Row,"offh_yd_cd") = "";
									ComShowCodeMessage("LSE01048");
								}
							} else {
								var errMsg = LseComGetErrMsg(sXml);
								if ( errMsg != "" ) {
									ComShowMessage(errMsg);
								}
								CellValue2(Row,"offh_yd_cd") = "";
								ComSetFocus(formObj.loc_cd);
							}
						}
					}
					break;

				case "offh_due_dt":		// Off-Hire Due Date Check
					if(CellValue(Row,Col) != "") {
						if(ComGetDaysBetween(formObj.h_curr_dt.value, CellText(Row,Col)) < 0) {
							ComShowCodeMessage("LSE01118");
							CellValue2(Row,Col) = CellSearchValue(Row, Col);
 							SelectCell(Row,Col);
						}
					}
					break;

				default :
					//do nothing
			}
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
			if(Row >= HeaderRows && ColSaveName(Col) == "vndr_seq") {
				sText = CellText(Row,Col);
				//풍선도움말 만들기
				MouseToolTipText = CellText(Row,"vndr_lgl_eng_nm");
			} else {
				MouseToolTipText = "";
			}

			var linkFlag = CellValue(MouseRow, MouseCol) != "";
			DataLinkMouse("vndr_seq") = CellValue(Row, "lse_vndr_url") != "";
			DataLinkMouse("snd_usr_id") = linkFlag;
			DataLinkMouse("cfm_usr_id") = linkFlag;
		}
	}

	/**
	 * sheet1_OnDblClick
	 */
	function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
		var formObj = document.form;
		var sName = sheetObj.ColSaveName(Col);

		if(sheetObj.MousePointer != "Hand") return;

		with(sheetObj) {
			switch(sName) {
				case "vndr_seq":
					var sUrl = CellValue(Row, "lse_vndr_url");
					ComOpenWindow2(sUrl, "Agreement Lessor URL", "");
				break;
				case "snd_usr_id":
					//사용자정보 화면을 팝업한다.
					ComUserPopup(CellValue(Row, Col));
				break;
				case "cfm_usr_id":
					ComUserPopup(CellValue(Row, Col));
				break;
			}
		}
	}

	/**
 	 * Sheet의 OnPopupClick Event 처리부분.<br>
 	 * @param sheetObj
 	 * @param Row
 	 * @param Col
 	 */
    function sheet1_OnPopupClick(sheetObj,Row,Col) {
 		with(sheetObj) {
			var sName = ColSaveName(Col);

			switch(sName) {
				case "offh_yd_cd":		//Yard Code No Pop-up
					openPopup("9", Row, Col);
					break;
				case "mty_rtn_yd_cd":	//Yard Code No Pop-up
					openPopup("8", Row, Col);
					break;
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
    	} else if ( type == "8" ) {//Return Yard
    		ComOpenPopup("/hanjin/COM_ENS_061.do", 755, 610, "setPopData_YardCode", "1,0,1,1,1,1,1,1", true, false, Row, Col, 0);
    	} else if ( type == "9" ) {//Off-Hire Yard
    		ComOpenPopup("/hanjin/EES_LSE_0101.do", 800, 450, "setPopData_AvailYard", '1,0', true, false, Row, Col, 0);
    	}

    	return;
    }
    
    /**
     * Master Pop-up  처리 부분<br>
     * @param {arry} returnedValues Pop-up 화면의 Return value array
     * @param Row 대상Object가 IBSheet일 경우 해당 Row index
     * @param Col 대상Object가 IBSheet일 경우 해당 Col index
     * @param 대상IBSheet의 Sheet Array index
     */
    function openPopupMST(){
    	   var formObj = document.form;
    	 //  var cnmv_date = ComGetNowInfo("ymd"); //formObj.cnmv_dt.value;
    	   ComOpenPopupWithTarget("/hanjin/EES_MST_0024.do?"+"pop_mode=Y", 1020, 682, "", "0,1", true);
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
      * Yard Code Pop-up Return Value 처리 부분<br>
      * @param {arry} returnedValues Pop-up 화면의 Return value array
      * @param Row 대상Object가 IBSheet일 경우 해당 Row index
      * @param Col 대상Object가 IBSheet일 경우 해당 Col index
      * @param 대상IBSheet의 Sheet Array index
      */
     function setPopData_YardCode(aryPopupData, Row, Col, sheetIdx) {
     	if(aryPopupData.length > 0) {
			with(sheetObjects[sheetIdx]) {
				CellValue2(Row, Col) = aryPopupData[0][3]; //Yard
			}
		}
     }

     /**
      * Yard Code Pop-up Return Value 처리 부분<br>
      * @param {arry} returnedValues Pop-up 화면의 Return value array
      * @param Row 대상Object가 IBSheet일 경우 해당 Row index
      * @param Col 대상Object가 IBSheet일 경우 해당 Col index
      * @param 대상IBSheet의 Sheet Array index
      */
     function setPopData_AvailYard(aryPopupData, Row, Col, sheetIdx) {
     	if(aryPopupData.length > 0) {
			with(sheetObjects[sheetIdx]) {
				CellValue2(Row, Col) = aryPopupData[0][4]; //Yard
			}
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
	 * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
	 */
	function getBackEndJobStatus() {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];

		formObj.f_cmd.value = COMMAND02;
		var sXml = sheetObj.GetSearchXml("EES_LSE_0022GS.do", FormQueryString(formObj));
		var jobState = ComGetEtcData(sXml, "jb_sts_flg");
		if (jobState == "3") {
			getBackEndJobLoadFile();
			clearInterval(timer);
		} else if (jobState == "4") {
			ComShowCodeMessage("LSE01124");
			ComOpenWait(false);
			sheetObj.WaitImageVisible = true;
			clearInterval(timer);
		} else if (jobState == "5") {
			ComShowCodeMessage("LSE01125");
			clearInterval(timer);
		}
	}

	/**
	 * BackEndJob의 결과가 완료되면 Excel파일로 내려받음
	 */
	function getBackEndJobLoadFile() {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];

		formObj.f_cmd.value = COMMAND03;
		ComOpenWait(false);
		var sXml = sheetObj.GetSearchXml("EES_LSE_0022GS.do", FormQueryString(form));
		sheetObj.LoadSearchXml(sXml);
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
    				} else if(formObj.port_cd.className == "input1" && formObj.port_cd.value == "") {
    					ComShowCodeMessage("LSE01046");
    					ComSetFocus(formObj.port_cd);
    					return false;
    				} else if(formObj.cntr_list.className == "input1" && formObj.cntr_list.value == "") {
    					ComShowCodeMessage("LSE01064");
    					ComSetFocus(formObj.cntr_list);
    					return false;
    				} else if (!checkDurationDate()) {
    					return false;
    				}

    				return ComChkValid(formObj, true);
    				break;
				default :	//do nothing
    		}
    	}

    	with(sheetObj) {
    		switch(sAction) {
	    		case IBSAVE:		//저장
	    			return true;
	    			break;
	    		default : 	//do nothing
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

		//Division is Location와  CNTR No인 경우만 제외한다.
		if(formObj.loc_case.value == "1" || formObj.loc_case.value == "3") return true;

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
			ComEnableObject(formObj.loc_cd, 	   true);
			ComEnableObject(formObj.port_cd, 	   true);
			ComEnableObject(formObj.slan_cd, 	   true);
			ComEnableObject(formObj.del_cd, 	   true);
			ComEnableObject(formObj.vvd_cd, 	   true);
			ComEnableObject(formObj.str_estm_dt,   true);
			ComEnableObject(formObj.end_estm_dt,   true);
			ComEnableObject(formObj.cntr_list,     true);
			formObj.cntr_list.value  = "";
			formObj.loc_cd.className  = "input1";
			formObj.port_cd.className = "input1";
			formObj.cntr_list.className = "input";
		} else if (value == "3"){
			ComEnableObject(formObj.btns_search1,  value == "3");
			ComEnableObject(formObj.btns_search2,  value != "3");
			ComEnableObject(formObj.btns_search3,  value != "3");
			ComEnableObject(formObj.btns_search6,  value != "3");
			ComEnableObject(formObj.btns_search7,  value != "3");
			ComEnableObject(formObj.btns_calendar, value != "3");
			ComEnableObject(formObj.loc_cd, 	   value != "3");
			ComEnableObject(formObj.port_cd, 	   value != "3");
			ComEnableObject(formObj.slan_cd, 	   value != "3");
			ComEnableObject(formObj.del_cd, 	   value != "3");
			ComEnableObject(formObj.vvd_cd, 	   value != "3");
			ComEnableObject(formObj.str_estm_dt,   value != "3");
			ComEnableObject(formObj.end_estm_dt,   value != "3");
			ComEnableObject(formObj.cntr_list,     value == "3");
			formObj.cntr_list.className = "input1";
		} else {
			ComEnableObject(formObj.btns_search1,  value == "1");
			ComEnableObject(formObj.btns_search2,  value != "1");
			ComEnableObject(formObj.btns_search3,  value != "1");
			ComEnableObject(formObj.btns_search6,  value != "1");
			ComEnableObject(formObj.btns_search7,  value != "1");
			ComEnableObject(formObj.btns_calendar, value != "1");
			ComEnableObject(formObj.loc_cd, 	   value == "1");
			ComEnableObject(formObj.port_cd, 	   value != "1");
			ComEnableObject(formObj.slan_cd, 	   value != "1");
			ComEnableObject(formObj.del_cd, 	   value != "1");
			ComEnableObject(formObj.vvd_cd, 	   value != "1");
			ComEnableObject(formObj.str_estm_dt,   value != "1");
			ComEnableObject(formObj.end_estm_dt,   value != "1");
			ComEnableObject(formObj.cntr_list,     value != "1");
			formObj.cntr_list.value  = "";
			if(value == "1") {
				formObj.loc_cd.className   = "input1";
			} else {
				formObj.port_cd.className  = "input1";
			}
		}

		if(value != "1" && value != "3") {//loc_case is Port
			var vCurrDate = formObj.h_curr_dt.value;
			formObj.str_estm_dt.value = vCurrDate;
			formObj.end_estm_dt.value = ComGetDateAdd(vCurrDate, "D", 7);
		}
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
			case "cntr_list":
				ComSetObjValue(formObj.cntr_list,    "");
				break;
		}
	}
	
	function getLse_Multi(rowArray,ret_val) {
		var formObj = document.form;
		var tempText = "";
		//initializing
		formObj.cntr_list.value = '';
		for(var i=0; i<rowArray.length; i++) {
			var colArray = rowArray[i];
			tempText +=  rowArray[i] + ',';
		}
		//clearing comma(,)
		tempText = LseDelLastDelim(tempText);
		tempText = tempText.toUpperCase();
		eval("document.form." + ret_val + ".value = '" + tempText + "';");
	}	
	/* 개발자 작업  끝 */