/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : EES_LSE_0104.js
 *@FileTitle : Off Hirable Container List Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.05.12
 *@LastModifier : 길정권
 *@LastVersion : 1.0
 * 2014.05.12 길정권
 * 1.0 Creation
 * =======================================================
 * 
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
	 * @class EES_LSE_0104 : EES_LSE_0104 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_LSE_0104() {
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
		this.combo1_OnBlur 		= combo1_OnBlur;
		this.combo2_OnBlur 		= combo2_OnBlur;
		this.combo1_OnKeyDown 	= combo1_OnKeyDown;
		this.combo2_OnKeyDown 	= combo2_OnKeyDown;
		this.setDefaultComboCheck = setDefaultComboCheck;
		this.openPopup 			= openPopup;
		this.setPopData_Agreement = setPopData_Agreement;
		this.setPopData_Lessor 	= setPopData_Lessor;
		this.callbackPopupMail  = callbackPopupMail;
		this.getBackEndJobStatus = getBackEndJobStatus;
		this.getBackEndJobLoadFile = getBackEndJobLoadFile;
		this.validateForm 		= validateForm;
		this.delayActionIBSheet = delayActionIBSheet;
		this.checkDurationDate 	= checkDurationDate;
		this.clearForm 			= clearForm;
	} 

	/* 개발자 작업	*/
	// 공통전역변수 

	// Combo Object Array
	var comboObjects = new Array();
	var comboCnt = 0;

	var vOrcLstmCd = "LT|ST|OF";
   	var vCnmvStsCd = "MT|IC|ID|EN|TN|VL|XX";

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
   				case "radio_loc_tp":
  					if(formObj.radio_loc_tp[0].checked){
						ComSetObjValue(formObj.rad_tp, "A");
						ComEnableObject(formObj.cntr_no_multi, true);
   					}else if(formObj.radio_loc_tp[1].checked){
						ComSetObjValue(formObj.rad_tp, "B");
						ComEnableObject(formObj.cntr_no_multi, false);
   					}
					sheetObject.RemoveAll();
					ComSetFocus(formObj.loc_cd);
  					break;					

   				case "radio_dol_tp":
  					if(formObj.radio_dol_tp[0].checked){
						ComSetObjValue(formObj.dol_tp, "A");
   					}else if(formObj.radio_dol_tp[1].checked){
						ComSetObjValue(formObj.dol_tp, "E");
   					}else if(formObj.radio_dol_tp[2].checked){
						ComSetObjValue(formObj.dol_tp, "N");
   					}
  					break;				
				
				case "btn_retrieve":
					sheetObject.RemoveAll();

					if(ComChkValid(formObj) == true) {
						doActionIBSheet(sheetObjects[0],document.form,IBBATCH);
					}
					break;

				case "btn_new":
					ComResetAll();
					for ( var k = 0 ; k < comboObjects.length ; k++ ) {
				        setDefaultComboCheck(comboObjects[k]);
				    }
					ComSetFocus(formObj.loc_cd);
					break;

				case "btn_DownExcel":
					sheetObject.Down2Excel(-1, false, false, true);
					break;

				case "btns_search1":	//Form Location. 조회 팝업
					openPopup("1");
 					break;
				case "btns_search3": 	// VVD Code Search
					openPopup("3");
					break;
				case "btns_search4": 	// Form Agreement Search
					openPopup("4");
					break;
				case "btns_search5": 	// Form Lessor Search
					openPopup("5");
					break;

				case "btns_calendar":	// Estimate Duration (FromTo)
					if ( srcObj.style.filter == "" ) {
						var cal = new ComCalendarFromTo();
						cal.select(formObj.str_estm_dt, formObj.end_estm_dt, 'yyyy-MM-dd');
					}
					break;
	 				// inputting multi
				case "cntr_no_multi":
					if ( srcObj.style.filter == "" ) {
				     rep_Multiful_inquiry("scc_list");
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
		//LseComBtnControl(false, "btn_DetailInquiry");
		
		var Dt = new Date();
		formObj.str_estm_dt.value = Dt.getFullYear() + "-" + addZero(eval(Dt.getMonth()+1)) + "-" + addZero(Dt.getDate());
		Dt.setDate( Dt.getDate() + 7 );
		formObj.end_estm_dt.value = Dt.getFullYear() + "-" + addZero(eval(Dt.getMonth()+1)) + "-" + addZero(Dt.getDate());

		/* 초기 Focus Setting */
		ComSetFocus(formObj.loc_cd);
    }
	
	function addZero(i){
		var rtn = i + 100;
		return rtn.toString().substring(1,3);
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
	    	//case "end_estm_dt":
    		//	checkDurationDate(obj);
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
			case "radio_loc_tp":		//Radio Button
				clearForm("radio_loc_tp");
				if(formObj.rad_tp.value == "A"){
					ComEnableObject(formObj.scc_list,  true);
					formObj.scc_list.className = "input1";
				}else{
					ComEnableObject(formObj.scc_list,  false);
				}
				break;
			case "loc_tp":		//Location Type
				clearForm("loc_cd");
				break;
			case "loc_cd":		//Location Code
				if ( ComTrim(obj.value) != "" ) {
					if(obj.maxLength == 5) {
	        			doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC01);
  					} else {
  						//doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC08);
  						doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC01);
  					}
  				}
				break;
  			case "str_estm_dt":
  				var Dt = new Date();
  				var compDt = Dt.getFullYear() + addZero(eval(Dt.getMonth()+1)) + addZero(Dt.getDate());

  				if (formObj.str_estm_dt.value < compDt && formObj.rad_tp.value == "A"){
  					ComShowCodeMessage("LSE01156", "start date since today");
  					return false;
  				}
  				break;
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
	        	} else if(obj.name == "scc_list") {
					ComKeyOnlyAlphabet('upper', "44");
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
   				case "vvd_cd":		//VVD Code Search
				case "vndr_seq":
	  			case "agmt_seq":
	  				if ( ComTrim(obj.value) == "" ) {
						doActionIBSheet(sheetObjects[0], formObj, IBBATCH);
					}
					break;

				default :
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
	            MergeSheet = msNone;
	
	           //전체Edit 허용 여부 [선택, Default false]
	            Editable = false;
	
	            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	            InitRowInfo( 1, 1, 3, 1000);
	
				var HeadTitle = "Seq.|CNTR No.|TP/SZ|Term|||AGMT No|Ref No|Lessor|MVMT Yard|MVMT|F/M|MVMT Date|BKG No|D.Term|LCC|POL|POR|POD|DEL|DEL SCC|MT Return|MT RTN SCC|DEL DOL|MT RTN DOL|CURR YD DOL|ETD DT|ETA DT|VVD|S/O No|W/O No|W/O S/P Type|W/O S/P CD|W/O S/P Name|DOL0|DOL1|DOL2|DOL3|DOL4|DOL5|DOL6|DOL7|DOL8|DOL9";
				var headCount = ComCountHeadTitle(HeadTitle);
	
	            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	            InitColumnInfo(headCount, 0, 0, true);
	
	            // 해더에서 처리할 수 있는 각종 기능을 설정한다
	            InitHeadMode(true, true, false, true, false,false)
	
	            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	            InitHeadRow(0, HeadTitle, true);
	
	            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	            InitDataProperty(0, cnt++ , dtDataSeq,		40,		daCenter,	true,	"seq_no");
	            InitDataProperty(0, cnt++ , dtData,   		90,  	daCenter,	true,	"cntr_no",			false,	"",		dfNone);
	            InitDataProperty(0, cnt++ , dtData,   		50,  	daCenter,	true,	"cntr_tpsz_cd",		false,	"",		dfNone);
	
	            InitDataProperty(0, cnt++ , dtData,   		50,  	daCenter,	true,	"lstm_cd",			false,	"",		dfNone);
	            InitDataProperty(0, cnt++ , dtHidden,  		60,  	daCenter,	true,	"agmt_cty_cd",		false,	"",		dfNone);
	            InitDataProperty(0, cnt++ , dtHidden,  		60,  	daCenter,	true,	"agmt_seq",			false,	"",		dfNone);
	            InitDataProperty(0, cnt++ , dtData,   		80,  	daCenter,	true,	"agmt_no",			false,	"",		dfNone);
	            InitDataProperty(0, cnt++ , dtData,   		100,  	daCenter,	true,	"ref_no",			false,	"",		dfNone);
	            InitDataProperty(0, cnt++ , dtData,   		100,  	daCenter,	true,	"vndr_abbr_nm",		false,	"",		dfNone);
	            InitDataProperty(0, cnt++ , dtData,   		70,  	daCenter,	true,	"crnt_yd_cd",		false,	"",		dfNone);
	            InitDataProperty(0, cnt++ , dtData,   		50,  	daCenter,	true,	"cnmv_sts_cd",		false,	"",		dfNone);
	            InitDataProperty(0, cnt++ , dtData,   		40,  	daCenter,	true,	"full_flg",			false,	"",		dfNone);
	            InitDataProperty(0, cnt++ , dtData,   		80,  	daCenter,	true,	"cnmv_dt",			false,	"",		dfDateYmd);
	            InitDataProperty(0, cnt++ , dtData,   		100,  	daCenter,	true,	"bkg_no",			false,	"",		dfNone);
	            InitDataProperty(0, cnt++ , dtData,   		50,  	daCenter,	true,	"de_term",			false,	"",		dfNone);
	            InitDataProperty(0, cnt++ , dtData,   		50,  	daCenter,	true,	"lcc_cd",			false,	"",		dfNone);
	            InitDataProperty(0, cnt++ , dtData,   		50,  	daCenter,	true,	"pol_cd",			false,	"",		dfNone);
	            InitDataProperty(0, cnt++ , dtData,   		50,  	daCenter,	true,	"por_cd",			false,	"",		dfNone);
	            InitDataProperty(0, cnt++ , dtData,   		50,  	daCenter,	true,	"pod_cd",			false,	"",		dfNone);
	            InitDataProperty(0, cnt++ , dtData,   		50,  	daCenter,	true,	"del_cd",			false,	"",		dfNone);
	            InitDataProperty(0, cnt++ , dtData,   		50,  	daCenter,	true,	"del_scc",			false,	"",		dfNone);
	            InitDataProperty(0, cnt++ , dtData,   		70,  	daCenter,	true,	"mt_rtn_yd",		false,	"",		dfNone);
	            InitDataProperty(0, cnt++ , dtData,   		70,  	daCenter,	true,	"mt_rtn_scc",		false,	"",		dfNone);
	            InitDataProperty(0, cnt++ , dtData,   		70,  	daCenter,	true,	"del_dol",			false,	"",		dfNone);
	            InitDataProperty(0, cnt++ , dtData,   		70,  	daCenter,	true,	"mt_rtn_dol",		false,	"",		dfNone);
	            InitDataProperty(0, cnt++ , dtData,   		70,  	daCenter,	true,	"curr_yd_dol",		false,	"",		dfNone);
	            InitDataProperty(0, cnt++ , dtData,   		100,  	daCenter,	true,	"pol_etd",			false,	"",		dfUserFormat2);
	            InitDataProperty(0, cnt++ , dtData,   		100,  	daCenter,	true,	"pod_eta",			false,	"",		dfUserFormat2);
	            InitDataProperty(0, cnt++ , dtData,   		90,  	daCenter,	true,	"vvd_cd",			false,	"",		dfNone);
	            InitDataProperty(0, cnt++ , dtData,   		90,  	daCenter,	true,	"so_no",			false,	"",		dfNone);
	            InitDataProperty(0, cnt++ , dtData,   		90,  	daCenter,	true,	"wo_no",			false,	"",		dfNone);
	            InitDataProperty(0, cnt++ , dtData,   		90,  	daCenter,	true,	"vndr_tp",			false,	"",		dfNone);
	            InitDataProperty(0, cnt++ , dtData,   		90,  	daCenter,	true,	"vndr_cd",			false,	"",		dfNone);
	            InitDataProperty(0, cnt++ , dtData,   		90,  	daCenter,	true,	"vndr_nm",			false,	"",		dfNone);
	            InitDataProperty(0, cnt++ , dtData,   		50,  	daCenter,	true,	"dol1",				false,	"",		dfNone);
	            InitDataProperty(0, cnt++ , dtData,   		50,  	daCenter,	true,	"dol2",				false,	"",		dfNone);
	            InitDataProperty(0, cnt++ , dtData,   		50,  	daCenter,	true,	"dol3",				false,	"",		dfNone);
	            InitDataProperty(0, cnt++ , dtData,   		50,  	daCenter,	true,	"dol4",				false,	"",		dfNone);
	            InitDataProperty(0, cnt++ , dtData,   		50,  	daCenter,	true,	"dol5",				false,	"",		dfNone);
	            InitDataProperty(0, cnt++ , dtData,   		50,  	daCenter,	true,	"dol6",				false,	"",		dfNone);
	            InitDataProperty(0, cnt++ , dtData,   		50,  	daCenter,	true,	"dol7",				false,	"",		dfNone);
	            InitDataProperty(0, cnt++ , dtData,   		50,  	daCenter,	true,	"dol8",				false,	"",		dfNone);
	            InitDataProperty(0, cnt++ , dtData,   		50,  	daCenter,	true,	"dol9",				false,	"",		dfNone);
	            InitDataProperty(0, cnt++ , dtData,   		50,  	daCenter,	true,	"dol10",			false,	"",		dfNone);
	
				CountFormat = "[SELECTDATAROW / TOTALROWS]";
				
				InitUserFormat2(0, "pol_etd", "####-##-## ##:##", "-|:" );
				InitUserFormat2(0, "pod_eta", "####-##-## ##:##", "-|:" );
				
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
            	comboObjects[1].InsertItem(0 , 'ALL','');
            	LseComText2ComboItem(comboObjects[1], vCnmvStsCd, vCnmvStsCd, "|");
            	setDefaultComboCheck(comboObjects[1]);

				sheetObj.WaitImageVisible = false;
				//Container Type/Size Combo Item Setting Start
				formObj.f_cmd.value = SEARCH02;
				var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", FormQueryString(formObj));
		        sheetObj.WaitImageVisible = true;

	            break;

			case IBSEARCH:      //조회
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet1") {
						formObj.f_cmd.value = SEARCH;
						sheetObj.DoSearch4Post("EES_LSE_0104GS.do",FormQueryString(formObj));
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
	                		var sXml = sheetObj.GetSearchXml("EES_LSE_0104GS.do", FormQueryString(formObj));
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

        }
    }

	/**
     * 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		var formObj  = document.form;

		with(sheetObj) {
			if(formObj.rad_tp.value == "A"){
				sheetObj.ColHidden("dol1") = false;
				sheetObj.ColHidden("dol2") = false;
				sheetObj.ColHidden("dol3") = false;
				sheetObj.ColHidden("dol4") = false;
				sheetObj.ColHidden("dol5") = false;
				sheetObj.ColHidden("dol6") = false;
				sheetObj.ColHidden("dol7") = false;
				sheetObj.ColHidden("dol8") = false;
				sheetObj.ColHidden("dol9") = false;
				sheetObj.ColHidden("dol10") = false;
			}else{
				sheetObj.ColHidden("dol1") = true;
				sheetObj.ColHidden("dol2") = true;
				sheetObj.ColHidden("dol3") = true;
				sheetObj.ColHidden("dol4") = true;
				sheetObj.ColHidden("dol5") = true;
				sheetObj.ColHidden("dol6") = true;
				sheetObj.ColHidden("dol7") = true;
				sheetObj.ColHidden("dol8") = true;
				sheetObj.ColHidden("dol9") = true;
				sheetObj.ColHidden("dol10") = true;
			}
			
			sheetObj.Redraw = true;
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
				case "del_chk":
					var vDelCheck = FindCheckedRow("del_chk").split("|");
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
	 * combo1_OnBlur
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
				formObj.cnmv_sts_cd.value = ComGetObjValue(comboObj);
			//	doActionIBSheet(sheetObj, formObj, IBBATCH);
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
    			default:	//do nothing
    		}
    	} else if ( type == "3" ) {
    		ComOpenPopupWithTarget('/hanjin/COM_ENS_0B2.do', 770, 470,"vvd:vvd_cd", "1,0,1,1,1,1,1,1", true);
    	} else if ( type == "4" ) {
    		ComOpenPopup('/hanjin/EES_LSE_0091.do', 805, 450, 'setPopData_Agreement', '1,0', true);
    	} else if ( type == "5" ) {
    		ComOpenPopup('/hanjin/COM_ENS_0C1.do', 705, 450, 'setPopData_Lessor', '1,0,1,1,1,1,1,1', true);			
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
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj) {
    		switch(sAction) {
    			//case IBBATCH:      //조회
    			case IBBATCH:      	//조회-BackEndJob
    				if(formObj.loc_cd.className == "input1" && formObj.loc_cd.value == "") {
    					ComShowCodeMessage("LSE01046");
    					ComSetFocus(formObj.loc_cd);
						return false;
    				} else if(formObj.scc_list.className == "input1" && formObj.scc_list.value == ""){
    					ComShowCodeMessage("LSE01156", "Target Off-hire Location Code");
    					ComSetFocus(formObj.scc_list);
						return false;
    					
    				} else if (!checkDurationDate()) {
    					return false;
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

    	//Duration이 필수입력이 아닌경우
    	if(formObj.str_estm_dt.className == "input") {
	    	if( vEffDt == "" && vExpDt == "" ) {
	    		return true;
	    	}
    	}
		if(vEffDt != "" && vExpDt != ""){
			if(LseComDateDiff(vEffDt, vExpDt, "D") > 30){
				ComShowCodeMessage("LSE01156", "period within one month");
				ComSetFocus(formObj.end_estm_dt);    				
				return false;
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
		if(vEffDt != "" && formObj.rad_tp.value == "A"){
			var Dt = new Date();
			var compDt = Dt.getFullYear() + addZero(eval(Dt.getMonth()+1)) + addZero(Dt.getDate());

			if (vEffDt < compDt){
				ComShowCodeMessage("LSE01156", "start date since today");
				ComSetFocus(formObj.str_estm_dt);
				return false;
			}
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
	 * Form Element Clear 처리부분.<br>
	 * @param fieldName
	 */
	function clearForm(fieldName) {
		var formObj = document.form;
		switch(fieldName) {
			case "radio_loc_tp":
				ComSetObjValue(formObj.loc_tp,    "2");
				ComSetObjValue(formObj.loc_cd,    "");
				ComSetObjValue(formObj.scc_list,    "");
				ComSetObjValue(formObj.agmt_seq,    "");
				ComSetObjValue(formObj.vndr_seq, 	"");
				ComSetObjValue(formObj.vndr_nm,  	"");
				ComSetObjValue(formObj.vndr_abbr_nm,"");
				ComSetObjValue(formObj.vvd_cd, "");
				comboObjects[0].Text ="";
				comboObjects[1].Text ="";

				var Dt = new Date();
				
				if(formObj.str_estm_dt.value < Dt.getFullYear() + "-" + addZero(eval(Dt.getMonth()+1)) + "-" + addZero(Dt.getDate())){
					formObj.str_estm_dt.value = Dt.getFullYear() + "-" + addZero(eval(Dt.getMonth()+1)) + "-" + addZero(Dt.getDate());
					Dt.setDate( Dt.getDate() + 7 );
					formObj.end_estm_dt.value = Dt.getFullYear() + "-" + addZero(eval(Dt.getMonth()+1)) + "-" + addZero(Dt.getDate());
				}
				break;
			case "loc_tp":
				ComSetObjValue(formObj.loc_tp,    "2");
				break;
			case "loc_cd":
				ComSetObjValue(formObj.loc_cd,    "");
				ComSetFocus(formObj.loc_cd);
				break;
			case "scc_list":
				ComSetObjValue(formObj.scc_list,    "");
				break;
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
		}
	}
	
	function getLse_Multi(rowArray,ret_val) {
		var formObj = document.form;
		var tempText = "";
		//initializing
		formObj.scc_list.value = '';
		for(var i=0; i<rowArray.length; i++) {
			var colArray = rowArray[i];
			tempText +=  rowArray[i] + ',';
		}
		//clearing comma(,)
		tempText = LseDelLastDelim(tempText);
		tempText = tempText.toUpperCase();
		eval("document.form." + ret_val + ".value = '" + tempText + "';");
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
		var sXml = sheetObj.GetSearchXml("EES_LSE_0104GS.do", FormQueryString(formObj));
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
		var sXml = sheetObj.GetSearchXml("EES_LSE_0104GS.do", FormQueryString(form));
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
	/* 개발자 작업  끝 */