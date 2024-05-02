/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_lse_0095.js
*@FileTitle : Lease Agreement Inquery
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.05.26 노정용
* 1.0 Creation 
* ======================================================
* 2010.12.08 신자영 [CHM-201007442-01] LT일때 Per-Diem LCC로 변경
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
	/**
	 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
	 * @author 노정용
	 */

	/**
	 * @extends 
	 * @class ees_lse_0095 : ees_lse_0095 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ees_lse_0095() {
		this.processButtonClick		= processButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.setTabObject 			= setTabObject;
		this.setComboObject         = setComboObject;
		this.loadPage 				= loadPage;
		this.initControl            = initControl;
		this.obj_blur               = obj_blur;
		this.obj_focus              = obj_focus;
		this.obj_change             = obj_change;
		this.obj_keypress           = obj_keypress;
		this.obj_keyup              = obj_keyup;
		this.obj_keydown            = obj_keydown;
		this.initSheet 				= initSheet;
		this.initTab                = intiTab;
		this.initCombo              = initCombo;
		this.doActionIBSheet 		= doActionIBSheet;
		this.t1sheet1_OnLoadFinish  = t1sheet1_OnLoadFinish;
		this.t1sheet1_OnSearchEnd   = t1sheet1_OnSearchEnd;
		this.tab1_OnChange			= tab1_OnChange;
		this.validateForm 			= validateForm;
	}

	/* 개발자 작업 */

	/* 공통전역변수 Start *****************************************************/
	// Tab Object Array
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;

	// Sheet Object Array
	var sheetObjects = new Array();
	var sheetCnt = 0;

	// Combo Object Array
	var comboObjects = new Array();
	var comboCnt = 0;
	
	//파일업로드를 사용하기 위한
	var uploadObjects = new Array();
	var uploadCnt = 0;

	//파일Seq저장변수 (추가될때 )
	var uploadFileSeq  = "";
	var fileUploadFlag = false;
	var fileSaveFlag = false;
	
	/* 화면 설정 구분 : 조회/신규입력/수정용 */
	var formActionType;
	/* 현재 Active 상태의 컨테이너 타입/사이즈 코드 문자열 : "|"로 연결 */
	var orgCntrTpSzCd;
	/* 현재 Active 상태의 컨테이너 타입/사이즈 코드 배열 */
	var arrOrgCntrTpSzCd;

	/* 화면 설정 구분 코드 */
	var MODE_CREATE = 1001;
	var MODE_MODIFY = 1002;
	var MODE_SEARCH = 1003;
	var MODE_VRSNUP = 1004;

	/* 각 탭의 컬럼 갯수 */
	var t2TabColCnt = 0;
	var t3TabColCnt = 0;
	var t4TabColCnt = 0;
	var t5TabColCnt = 0;
	
	var SEARCH_ENABLE = true;
	
	/* 공통전역변수 End *****************************************************/

	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/**
	 *  버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
	 */
	function processButtonClick() {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1  = sheetObjects[0];   //t1sheet1. General
		var sheetObject2  = sheetObjects[1];   //t2sheet1. Per-diem
		var sheetObject3  = sheetObjects[2];   //t3sheet1. Lifting Charges
		var sheetObject4  = sheetObjects[3];   //t4sheet1. DOL/DOC
		var sheetObject5  = sheetObjects[4];   //t4sheet2. Desc.
		var sheetObject6  = sheetObjects[5];   //t5sheet1. Penalty
		var sheetObject7  = sheetObjects[6];   //t6sheet1. DPP
		var sheetObject8  = sheetObjects[7];   //t7sheet1. AGMT Attach
		/*******************************************************/
		var formObj = document.form;

		try {
			var srcObj  = window.event.srcElement;
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

				case "btn_Retrieve":
					doActionIBSheet(sheetObject1, formObj, IBSEARCH);
					break;

				case "btn_New":
					ComResetAll();

					/* 조회가능하도록 Form 설정 */
					//setFormEnable(MODE_SEARCH, formObj);

					tabObjects[0].SelectedIndex = 0;
					break;

				case "btns_search1":		// Agreement Pop-up
					if ( srcObj.style.filter == "" ) {
						openPopupPage("1");
					}
					break;

				case "btn_t1DownExcel":
					if ( ComIsBtnEnable(srcName) ) {
						doActionIBSheet(sheetObject1, formObj, IBDOWNEXCEL);
					}
					break;

				case "btn_t2DownExcel":
					if ( ComIsBtnEnable(srcName) ) {
						doActionIBSheet(sheetObject2, formObj, IBDOWNEXCEL);
					}
					break;

				case "btn_t3DownExcel":
					if ( ComIsBtnEnable(srcName) ) {
						doActionIBSheet(sheetObject3, formObj, IBDOWNEXCEL);
					}
					break;

				case "btn_t4DownExcel":
					if ( ComIsBtnEnable(srcName) ) {
						doActionIBSheet(sheetObject4, formObj, IBDOWNEXCEL);
					}
					break;

				case "btn_t6DownExcel":
					if ( ComIsBtnEnable(srcName) ) {
						doActionIBSheet(sheetObject7, formObj, IBDOWNEXCEL);
					}
					break;
			} // end switch
		} catch(e) {
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
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++] = sheet_obj;
	}

	/**
	 * IBTab Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setTabObject(tab_obj){
		tabObjects[tabCnt++] = tab_obj;
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
	 * IBUpload Object를 uploadObjects 배열에 등록
	 * 배열은 소스 상단에 정의
	 */
	function setUploadObject(uploadObj){
		uploadObjects[uploadCnt++] = uploadObj;
	}

	function initUpload(uploadObj, uploadNo) {
		uploadObj.Files = "";
	}
	
	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		var formObj = document.form;

		orgCntrTpSzCd    = ComGetObjValue(formObj.org_cntr_tpsz_cd);
		arrOrgCntrTpSzCd = orgCntrTpSzCd.split("|");

		/* IBTab 초기화 */
		for ( var i = 0 ; i < tabObjects.length ; i++ ) {
			initTab(tabObjects[i], i+1);
		}

		/* IBSheet 초기화 */
		for ( var j = 0 ; j < sheetObjects.length ; j++ ) {
			ComConfigSheet(sheetObjects[j]);
			initSheet(sheetObjects[j], j+1);
			ComEndConfigSheet(sheetObjects[j]);
		}

		/* IBMultiCombo 초기화 */
		for ( var k = 0 ; k < comboObjects.length ; k++ ) {
	        initCombo(comboObjects[k], k+1);
	    }
		
		ComConfigUpload(uploadObjects[0], "/hanjin/LSE_INTGS.do");

		/* Axon Control Setting*/
		initControl();

		/* Form Field Enable/Disable Setting*/
		//setFormEnable(MODE_SEARCH, formObj);

		var vReqAgmtSeq = ComGetObjValue(formObj.req_agmt_seq);
		if ( vReqAgmtSeq != "" ) {
			ComSetObjValue(formObj.agmt_seq, vReqAgmtSeq);
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);			
		}
	}

  	/* Axon 이벤트 처리 Start ****************************************************************************/
  	// 1. 이벤트catch
  	function initControl() {
  		var formObj = document.form;
		//axon_event.addListenerFormat('beforedeactivate', 'obj_blur',		formObj); //- 포커스 나갈때
  		axon_event.addListenerFormat('blur', 		'obj_blur',		formObj); //- 포커스 나갈때
		axon_event.addListenerFormat('focus',		'obj_focus',	formObj); //- 포커스 들어갈때
  		axon_event.addListenerFormat('keypress',	'obj_keypress',	formObj); //- 키 눌렸을때
		axon_event.addListenerFormat('keyup',		'obj_keyup',	formObj); //- 키 올라올때
		axon_event.addListenerFormat('keydown',		'obj_keydown',	formObj); //- 키 눌렸을때
		axon_event.addListenerForm('change',		'obj_change',	formObj); //- 변경될때.
		axon_event.addListenerForm('click',			'obj_click',	formObj); //- 변경될때.
  	}

  	// 2. 이벤트처리함수 -- Start
  	/**
	 * HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
	 */
	function obj_blur() {
		var obj = event.srcElement;

	    switch(obj.name){
	        case "agmt_seq":
	        	/* 숫자이면서 천단위 구분을 하지 않는다. */
	            //if ( !ComChkObjValid(obj, true, false, false) ) {
	            //	ComSetObjValue(obj, "");
	    		//}
	            break;

	        case "vndr_seq":
	            /* 숫자이면서 천단위 구분을 하지 않는다. */
	            ComChkObjValid(obj, true, false, false);
	            break;

	        default:
	            /* Validation 전체 체크(길이,format,최대,최소 등등) */
	            ComChkObjValid(obj);
	        	break;
	    }
  	}

	/**
	 * HTML Control의 포커스 들어가는 이벤트에서 마스크 구분자를 제거한다.
	 */
	function obj_focus(){
		var obj  = event.srcElement;
		if( obj.readOnly ) {
			ComSetNextFocus(obj);
		} else {
		    /* 마스크구분자 없애기 */
		    ComClearSeparator(event.srcElement);
		}
	}

	/**
	 * HTML Control의 Value가 변경되었을 경우 처리한다.
	 */
	function obj_change(){
		var obj      = event.srcElement;
		var formObj  = document.form;

		if ( ComTrim(ComGetObjValue(obj)) != "" ) {
			switch(obj.name) {
	    		case "agmt_seq":
	    			ComSetObjValue(formObj.agmt_ver_seq, "");
	    			if ( SEARCH_ENABLE ) {
	    				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	    			}
					break;

	    		case "exp_dt":
	    			setDuration();
	    			break;

	    		case "agmt_chg_val":
	    			sheetObjects[5].CellValue(1, "agmt_chg_val") = ComGetObjValue(formObj.agmt_chg_val); 
	    			break;
			}
	    }
	}

	/**
	 * HTML Control의 Key-Press Event 처리한다.
	 */
  	function obj_keypress() {
		var obj = event.srcElement;
		//alert(event.keyCode);
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
	        	if ( obj.name == "lse_ctrt_no" || obj.name == "ref_no" ) {
	        		ComKeyOnlyAlphabet("num","45|95");
	        	} else {
	        		ComKeyOnlyAlphabet();
	        	}
	            break;
	        case "engup":
	            ComKeyOnlyAlphabet('upper');
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
  	 * HTML Control의 Key-Up Event 처리한다.
  	 */
  	function obj_keyup() {
  		var obj     = event.srcElement;
  		var formObj = document.form;

  		switch(obj.name) {
			case "agmt_seq":
  				if ( ComTrim(ComGetObjValue(obj)) != "" ) {
  					ComKeyEnter('LengthNextFocus');
  				}
  				break;

 			case "vndr_seq":
  				if ( ComTrim(ComGetObjValue(obj)) == "" ) {
  					ComSetObjValue(formObj.vndr_nm,"");
  				} else {
  					ComKeyEnter('LengthNextFocus');
  				}
  				break;

 			default:
  				ComKeyEnter('LengthNextFocus');
  				break;
  		}
  	}

  	/**
   	 * HTML Control의 Key-Down Event 처리한다.
   	 */
  	function obj_keydown() {
  		var obj      = event.srcElement;
  		var vKeyCode = event.keyCode;
  		var formObj  = document.form;

  		switch (obj.name) {
  			case "agmt_seq": 
		  		if ( vKeyCode == 13 ) {
		  			ComSetObjValue(formObj.agmt_ver_seq, "");
		  			SEARCH_ENABLE = false;
		  			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
		  			SEARCH_ENABLE = true;
		  		}
		  		break;

  			case "agmt_rmk":
	  			if ( ComGetLenByByte(obj) > 999) {
	  				ComShowCodeMessage("LSE01021");
	  				return false;
	  			}
	  			break;
  		}
  	}

   	function obj_click() {
   		var obj     = event.srcElement;
   		var formObj = document.form;

   		switch (obj.name) {
   			case "lse_vndr_url" :
   				if ( ComGetObjValue(formObj.lse_vndr_url) != "" ) {
   					var url = ComGetObjValue(formObj.lse_vndr_url);
   					if ( (url.substr(0,4)).toLowerCase() != "http" ) {
   						url = "http://" + url;
   					}
   					window.open(url,"_blank");
   					return;
   				}
   				break;
   		}
   	}

  	// 2. 이벤트처리함수 -- End
  	/* Axon 이벤트 처리 End ****************************************************************************/

	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		var sheetID = sheetObj.id;

		switch(sheetID) {
			case "t1sheet1":      // t1sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 160;

					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth-20;
					//SheetWidth = 979;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 10, 100);

					var HeadTitle1 = "||TP/SZ|Spec No.|Qty|REPL Value|PUR OPT Price|PUR OPT Period|Gate In|Gate Out|Remark(s)|";

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++, dtDummyCheck,	40,		daCenter,	false,	"del_chk");
					InitDataProperty(0, cnt++, dtCombo,			60,		daCenter,	false,	"cntr_tpsz_cd",		true,	"",	dfNone,		0,	false,	true);
					InitDataProperty(0, cnt++, dtPopup,			100,	daCenter,	false,	"cntr_spec_no",		false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++, dtData,			70,		daRight,	false,	"qty",				false,	"",	dfInteger,	0,	true,	true,	6);
					InitDataProperty(0, cnt++, dtData,			100,	daRight,	false,	"repl_value",		false,	"",	dfFloat,	2,	true,	true,	10);
					InitDataProperty(0, cnt++, dtData,			120,	daRight,	false,	"pur_price",		false,	"",	dfFloat,	2,	true,	true,	10);
					InitDataProperty(0, cnt++, dtData,			120,	daRight,	false,	"pur_period",		false,	"",	dfInteger,	0,	true,	true,	5);
					InitDataProperty(0, cnt++, dtData,			95,		daRight,	false,	"gate_in",			false,	"",	dfFloat,	2,	true,	true,	10);
					InitDataProperty(0, cnt++, dtData,			95,		daRight,	false,	"gate_out",			false,	"",	dfFloat,	2,	true,	true,	10);
					InitDataProperty(0, cnt++, dtData,			130,	daLeft,		false,	"gen_rmk",			false,	"",	dfNone,		0,	true,	true,	500);
					InitDataProperty(0, cnt++, dtHidden,		80,		daCenter,	false,	"loc_cd",			false,	"",	dfNone);

					ColHidden("cntr_spec_no") = true;
					ColHidden("del_chk")      = true;

					SelectBackColor = LSE_SELECT_BACK_COLOR;
				}
				break;

			case "t2sheet1":      // t2sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 180;

					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth-20;
					//SheetWidth = 979;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 8, 100);

					var HeadTitle1 = "||LOC(LCC)|No. of TEU|"+orgCntrTpSzCd;

					t2TabColCnt = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(t2TabColCnt, 4, 0, false);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus,	30,	daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++, dtDummyCheck,	40,	daCenter,	false,	"del_chk");
					InitDataProperty(0, cnt++, dtPopupEdit,		70,	daCenter,	false,	"loc_cd",		true,	"",	dfNone,			0,	false,	true, 5);
					InitDataProperty(0, cnt++, dtData,			90,	daRight,	false,	"agmt_chg_val",	false,	"",	dfNullInteger,	0,	false,	true, 6);
					for ( var i = 0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
						eval('InitDataProperty(0, cnt++, dtData, 55, daRight, false, "cntr'+(i+1)+'_n1_amt", false, "",  dfNullFloat, 2, true, true, 6);');
					}

					InitDataValid(0, "loc_cd",	vtEngUpOther , "0123456789");

					ColHidden("del_chk") = true;
					for ( var i = 0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
						eval('ColHidden("cntr'+(i+1)+'_n1_amt") = true;');
					}

					SelectBackColor = LSE_SELECT_BACK_COLOR;
				}
				break;

			case "t3sheet1":      // t3sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 180;

					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth-20;
					//SheetWidth = 979;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 2, 1, 8, 100);

					var HeadTitle1 = "|||LOC(SCC)";
					var HeadTitle2 = "|||LOC(SCC)";

					for ( var i = 0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
						HeadTitle1 = HeadTitle1 + "|" + arrOrgCntrTpSzCd[i] + "|" + arrOrgCntrTpSzCd[i];
						HeadTitle2 = HeadTitle2 + "|L/On|L/Off";
					}

					t3TabColCnt = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(t3TabColCnt, 4, 0, false);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus,	30,	daCenter,	true,	"ibflag");
					InitDataProperty(0, cnt++, dtDummyCheck,	40,	daCenter,	true,	"del_chk");
					InitDataProperty(0, cnt++, dtHidden,		90,	daRight,	true,	"agmt_chg_val");
					InitDataProperty(0, cnt++, dtPopupEdit,		70,	daCenter,	true,	"loc_cd",		true, "", dfNone, 0, false, true, 5);
					for ( var i = 0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
						eval('InitDataProperty(0, cnt++, dtData, 55, daRight, false, "cntr'+(i+1)+'_n1_amt", false, "", dfNullFloat, 2, true, true, 6);');
						eval('InitDataProperty(0, cnt++, dtData, 55, daRight, false, "cntr'+(i+1)+'_n2_amt", false, "", dfNullFloat, 2, true, true, 6);');
					}

					InitDataValid(0, "loc_cd",	vtEngUpOther , "0123456789");

					ColHidden("del_chk") = true;
					for ( var i = 0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
						eval('ColHidden("cntr'+(i+1)+'_n1_amt") = true;');
						eval('ColHidden("cntr'+(i+1)+'_n2_amt") = true;');
					}

					SelectBackColor = LSE_SELECT_BACK_COLOR;
				}
				break;

			case "t4sheet1":      // t4sheet1 init
				with (sheetObj) {
					//높이 설정
					style.height = 140;

					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth-20;
					//SheetWidth = 979;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 2, 1, 6, 100);

					var HeadTitle1 = "||LOC(SCC)";
					var HeadTitle2 = "||LOC(SCC)";

					for ( var i = 0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
						HeadTitle1 = HeadTitle1 + "|" + arrOrgCntrTpSzCd[i] + "|" + arrOrgCntrTpSzCd[i];
						HeadTitle2 = HeadTitle2 + "|DOL|DOC";
 					}

					t4TabColCnt = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(t4TabColCnt, 3, 0, false);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus,	30,	daCenter,	true,	"ibflag");
					InitDataProperty(0, cnt++, dtDummyCheck,	40,	daCenter,	true,	"del_chk");
					InitDataProperty(0, cnt++, dtPopupEdit,		70,	daCenter,	true,	"loc_cd",	true, "", dfNone, 0, false, true, 5);
					for ( var i = 0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
						eval('InitDataProperty(0, cnt++, dtData, 55, daRight, false, "cntr'+(i+1)+'_chg_val", false, "", dfNullInteger,	0, true, true, 6);');
						eval('InitDataProperty(0, cnt++, dtData, 65, daRight, false, "cntr'+(i+1)+'_n1_amt",  false, "", dfNullFloat,	2, true, true, 8);');
					}

					InitDataValid(0, "loc_cd",	vtEngUpOther , "0123456789");

					ColHidden("del_chk") = true;
					for ( var i = 0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
						eval('ColHidden("cntr'+(i+1)+'_chg_val") = true;');
						eval('ColHidden("cntr'+(i+1)+'_n1_amt") = true;');
					}

					SelectBackColor = LSE_SELECT_BACK_COLOR;
				}
				break;

			case "t4sheet2":      // t4sheet2 init
				with (sheetObj) {
					// 높이 설정
					style.height = 80;

					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth-20;
					//SheetWidth = 979;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 6, 100);

					var HeadTitle1 = "||LOC(SCC)|Depot|Address|CTC|Contract No.|Turn in Ref. No.";

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++, dtDummyCheck,	40,		daCenter,	false,	"del_chk");
					InitDataProperty(0, cnt++, dtPopupEdit,		70,		daCenter,	false,	"loc_cd",			true,	"",	dfNone,		true,	false, 5);
					InitDataProperty(0, cnt++, dtData,			180,	daLeft,		false,	"dpt_desc",			false,	"",	dfNone,		true,	true);
					InitDataProperty(0, cnt++, dtData,			400,	daLeft,		false,	"addr_desc",		false,	"",	dfNone,		true,	true);

					InitDataProperty(0, cnt++, dtData,			100,	daLeft,		false,	"ctrt_pson_desc",	false,	"",	dfNone,		true,	true);
					InitDataProperty(0, cnt++, dtData,			100,	daLeft,		false,	"ctrt_no_desc",		false,	"",	dfNone,		true,	true);
					InitDataProperty(0, cnt++, dtData,			100,	daLeft,		false,	"turn_ref_no_desc",	false,	"",	dfNone,		true,	true);

					InitDataValid(0, "loc_cd",	vtEngUpOther , "0123456789");

					ColHidden("del_chk") = true;

					SelectBackColor = LSE_SELECT_BACK_COLOR;
				}
				break;

			case "t5sheet1":      // t5sheet1 init  
				with (sheetObj) {
					// 높이 설정
					style.height = 80;

					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth-20;
					//SheetWidth = 979;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 2);

					var HeadTitle1 = "TP/SZ|"+orgCntrTpSzCd+"|||";

					t5TabColCnt = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(t5TabColCnt, 0, 1, false);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					//InitHeadMode(true, true, false, true, false, false);
					InitHeadMode(false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtData,			70,	daCenter,	false,	"TP/SZ");
					for ( var i = 0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
						eval('InitDataProperty(0, cnt++, dtData, 65, daRight, false, "cntr'+(i+1)+'_n1_amt", false, "",  dfNullFloat, 2, true, true, 8);');
 					}
					InitDataProperty(0, cnt++, dtHiddenStatus,	0,	daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++, dtHidden,		90,	daRight,	true,	"loc_cd");
					InitDataProperty(0, cnt++, dtHidden,		90,	daRight,	true,	"agmt_chg_val");

					InitHeadColumn("TP/SZ", "Rate/Day", daCenter);

					for ( var i = 0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
						eval('ColHidden("cntr'+(i+1)+'_n1_amt") = true;');
					}

					CountPosition = 0;

					SelectBackColor = LSE_SELECT_BACK_COLOR;

					MessageText("UserMsg14") = "";
				}
				break;

             case "t6sheet1":      // t6sheet1 init  
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 140;

                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth-20;
 					//SheetWidth = 979;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 2, 1, 10, 100);

                     var HeadTitle1 = "|||TP/SZ|DPP|DPP|DPP|DPP";
                     var HeadTitle2 = "|||TP/SZ|Free Day|Coverage Amt|Lump sum Rate|Daily Rate";

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false, false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     InitHeadRow(1, HeadTitle2, true); 

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++, dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
                     InitDataProperty(0, cnt++, dtHidden,		50,		daCenter,	true,	"loc_cd",				false);
                     InitDataProperty(0, cnt++, dtHidden,		50,		daCenter,	true,	"cntr_rntl_chg_tp_cd",	false);
                     InitDataProperty(0, cnt++, dtData,			150,	daCenter,	true,	"cntr_tpsz_cd",			false,  "",  dfNone,	0,	false,	false);
                     InitDataProperty(0, cnt++, dtData,			195,	daRight,	true,	"agmt_chg_dys",			false,  "",  dfInteger,	0,	true,	true, 5);

                     InitDataProperty(0, cnt++, dtData,			195,	daRight,	true,	"n1st_chg_amt",			false,  "",  dfFloat,   2,	true,	true, 8);
                     InitDataProperty(0, cnt++, dtData,			195,	daRight,	true,	"agmt_chg_val",			false,  "",  dfFloat,   2,	true,	true, 8);
                     InitDataProperty(0, cnt++, dtData,			195,	daRight,	true,	"n2nd_chg_amt",			false,  "",  dfFloat,	2,	true,	true, 8);

                     SelectBackColor = LSE_SELECT_BACK_COLOR;
                 }
                 break;
 		
             case "t7sheet1":      // t7sheet1 init
				with (sheetObj) {
					//높이 설정
					style.height = 140;

					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth-20;
					//SheetWidth = 979;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 6, 100);

					var HeadTitle1 = "||Seq|File|";

					t8TabColCnt = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(t8TabColCnt, 3, 0, false);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus,	30,	daCenter,	true,	"ibflag");
					InitDataProperty(0, cnt++, dtDummyCheck,	40,	daCenter,	true,	"del_chk");
					InitDataProperty(0, cnt++ , dtSeq,			30,	daCenter,	true,	"file_dtl_seq");
					InitDataProperty(0, cnt++, dtPopupEdit,		75,	daCenter,	true,	"file_path_nm",	true, "", dfNone, 0, false, true, 5);
					InitDataProperty(0, cnt++ , dtHidden,		90,	daLeft,		false,	"org_file_nm",	false,		"",		dfNone,			0,	false,	false);

					//InitDataValid(0, "loc_cd",	vtEngUpOther , "0123456789");

					SelectBackColor = LSE_SELECT_BACK_COLOR;
				}
				break;
		}
     }

     /**
      * Tab 기본 설정
      * 탭의 항목을 설정한다.
      */
     function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                 with (tabObj) {
                     var cnt  = 0 ;
                     InsertTab( cnt++ , "General",			-1 );
                     InsertTab( cnt++ , "Per Diem",			-1 );
                     InsertTab( cnt++ , "Lifting Charge",	-1 );
                     InsertTab( cnt++ , "DOL/DOC",			-1 );
                     InsertTab( cnt++ , "Penalty",			-1 );
                     InsertTab( cnt++ , "DPP",				-1 );
                     InsertTab( cnt++ , "AGMT Attach",		-1 );
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
			//lstm_cd
			case "combo1":
				with(comboObj) {
					DropHeight = 250;
					MultiSelect = false;
					Enable = false;
					//UseAutoComplete = true;
					//ValidChar(2,0);
				}
  	        	break;

  	        //cntr_dpc_lvl_cd
			case "combo2":
				with(comboObj) {
					DropHeight = 250;
					MultiSelect = false;
					Enable = false;
					//UseAutoComplete = true;
					//ValidChar(2,0);
				}
  	        	break;

  	        //dpc_val_flg
			case "combo3":
				with(comboObj) {
					DropHeight = 250;
					MultiSelect = false;
					Enable = false;
					//UseAutoComplete = true;
					//ValidChar(2,0);
				}
  	        	break;
		}
	}

	/**
	 * Sheet관련 프로세스 처리
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */ 
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;

		switch(sAction) {
			case IBCREATE:
				sheetObj.WaitImageVisible = false;
				
				/* Lease Term Form Combo Item Setting */
				ComSetObjValue(formObj.f_cmd, SEARCH01);
		     	var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", FormQueryString(formObj));

		        if ( sXml != "" ) {
		        	LseComXml2ComboItem(sXml, comboObjects[0], "lease_term_nm", "lease_term_cd", "|");
		        }

		        /* DEPR Level Form Combo Item Setting */
				var strText = "Daily|Monthly|Yearly";
        		var strCode = "D|M|Y";

        		LseComText2ComboItem(comboObjects[1], strText, strCode, "|");

		        /* DPC_VAL_FLG Level Form Combo Item Setting */
				var strText2 = "Manufacture Date|On-Hire Date";
        		var strCode2 = "N|Y";

        		LseComText2ComboItem(comboObjects[2], strText2, strCode2, "|");

        		/* Container Type/Size Grid Combo Item Setting */
        		if ( orgCntrTpSzCd != "" ) {
        			sheetObj.InitDataCombo(0, "cntr_tpsz_cd", " |"+orgCntrTpSzCd, " |"+orgCntrTpSzCd);
        		}

        		ComSetFocus(formObj.agmt_seq);
		        sheetObj.WaitImageVisible = true;

		        break;

			case IBSEARCH:      //조회
				/* Org 컨테이너 타입/사이즈 코드 재설정 : Form Data 설정시 Org 컨테이너 타입/사이즈 코드 데이터가 삭제됨으로 재설정. */
				ComSetObjValue(formObj.org_cntr_tpsz_cd, orgCntrTpSzCd);

				if(validateForm(sheetObj,formObj,sAction)) {
					if ( sheetObj.id == "t6sheet1" ) {
						/* DPP Tab */
						ComSetObjValue(formObj.f_cmd, SEARCH01);
	            	} else {
						sheetObj.Redraw = false;
	            		ComSetObjValue(formObj.f_cmd, SEARCH);
	            	}

					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					var sXml = sheetObj.GetSearchXml("EES_LSE_0095GS.do" , FormQueryString(formObj));

					if ( sheetObj.id == "t6sheet1" ) {
						sheetObj.LoadSearchXml(sXml);
					} else {
						var arrXml = sXml.split("|$$|");
						if (arrXml.length > 0) sheetObjects[0].LoadSearchXml(arrXml[0]);
						if (arrXml.length > 1) sheetObjects[1].LoadSearchXml(arrXml[1]);
						if (arrXml.length > 2) sheetObjects[2].LoadSearchXml(arrXml[2]);
						if (arrXml.length > 3) sheetObjects[3].LoadSearchXml(arrXml[3]);
						if (arrXml.length > 4) sheetObjects[4].LoadSearchXml(arrXml[4]);
						if (arrXml.length > 5) sheetObjects[5].LoadSearchXml(arrXml[5]);
						if (arrXml.length > 6) sheetObjects[6].LoadSearchXml(arrXml[6]);
						if (arrXml.length > 7) sheetObjects[7].LoadSearchXml(arrXml[7]);
					}
					ComOpenWait(false);
				}
	            break;

			case IBDOWNEXCEL:
 				with(sheetObj) {
 					var vSheetName = ComReplaceStr(tabObjects[0].TabText(tabObjects[0].SelectedIndex),"/","_");
					if ( ToTalRows < 1 ) {
						var row = DataInsert(0);
						RowHidden(row) = true;
						Down2Excel(-1, false, false, true, "", "", false, false, vSheetName);
						RowDelete(row, false);
					} else {
						Down2Excel(-1, false, false, true, "", "", false, false, vSheetName);
					}
 				}
 				break;
		}
	}

	function t1sheet1_OnLoadFinish(sheetObj) {
		var formObj = document.form;

		/* IBMulti Combo Item Setting */
		doActionIBSheet(sheetObj, formObj, IBCREATE);
	}

	/**
	 * Lease Agreement Master/General Tab IBSheet Object Search-End Event
	 */
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		var formObj = document.form;

		if ( ErrMsg == "" ) {

			ComEtcDataToForm(formObj, sheetObj);

			/* InActive CheckBox Setting */
			if ( ComGetObjValue(formObj.agmt_act_flg) == "Y" ) {
				formObj.chk_agmt_act_flg.checked = true;
			} else {
				formObj.chk_agmt_act_flg.checked = false;
			}

			/* ICF Flag CheckBox Setting */
			if ( ComGetObjValue(formObj.itchg_fee_flg) == "Y" ) {
				formObj.chk_itchg_fee_flg.checked = true;
			} else {
				formObj.chk_itchg_fee_flg.checked = false;
			}

			comboObjects[0].Code = ComGetObjValue(formObj.lstm_cd);
			comboObjects[1].Code = ComGetObjValue(formObj.cntr_dpc_lvl_cd);
			comboObjects[2].Code = ComGetObjValue(formObj.dpc_val_flg);

			/* DPP Coverage 의 값이 'N' 일 경우 DPP Tab 비활성화 */
			if ( ComGetObjValue(formObj.dpp_tp_cd) == "Y" ) {
				if ( tabObjects[0].TabEnable(5) == false ) {
					tabObjects[0].TabEnable(5)= true;
				}
			} else {
				if ( tabObjects[0].TabEnable(5) == true ) {
					tabObjects[0].TabEnable(5)= false;
				}
			}

			/* Mask 추가 */
			ComAddSeparator(form.eff_dt, "ymd");
			ComAddSeparator(form.exp_dt, "ymd");
			ComAddSeparator(form.agmt_dt, "ymd");
			ComAddSeparator(form.bld_up_dt, "ymd");

			/* Duration 계산 */
			setDuration();

			/* Lease Term 에 따른 General Sheet Control */
			control_Spec_No(ComGetObjValue(formObj.combo1));

			sheetObj.Redraw = true;

			/* 화면모드를 조회모드로 설정 */
			//setFormEnable(MODE_SEARCH, formObj);

			tabObjects[0].SelectedIndex = 0;

		} else {
			ComResetAll();

			/* 조회가능하도록 Form 설정 */
			//setFormEnable(MODE_SEARCH, formObj);
		}

		sheetObj.Redraw = true;

		/* Org 컨테이너 타입/사이즈 코드 재설정 : Form Data 설정시 Org 컨테이너 타입/사이즈 코드 데이터가 삭제됨으로 재설정. */
		ComSetObjValue(formObj.org_cntr_tpsz_cd, orgCntrTpSzCd);
	}

	/**
	 * Penalty Tab IBSheet Object Search-End Event
	 */
	function t5sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		var formObj = document.form;

		if ( sheetObj.SearchRows > 0 ) {
			ComSetObjValue(formObj.agmt_chg_val, sheetObj.CellValue(1,"agmt_chg_val"));
		} else {
			ComSetObjValue(formObj.agmt_chg_val, "");
			sheetObj.CellValue(1, "loc_cd") = "KRSEL";
			sheetObj.RowStatus(1) = "R";
		}
	}
	
    
    /**
	 * sheet7_OnMouseMove :: 마우스가 Sheet 위에서 움직일 때 발생하는 Event
	 */
	function t7sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
		with(sheetObj) {
			var linkFlag = CellValue(MouseRow, MouseCol) != "";
			DataLinkMouse("file_path_nm") = linkFlag;
		}
	}		
	
	/**
	 * sheet7_OnClick
	 */
	function t7sheet1_OnClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
		var formObj = document.form;
		var sName = sheetObj.ColSaveName(Col);

		if(sheetObj.MousePointer != "Hand") return;

		with(sheetObj) {
			switch(sName) {
				case "file_path_nm":
					location.href = "/hanjin/FileDownload?key="+CellText(Row, "org_file_nm");
					break;
			}
		}
	}
	
	/**
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	 */
	function tab1_OnChange(tabObj , nItem)
	{
		var formObj = document.form;
		var objs    = document.all.item("tabLayer");

		objs[nItem].style.display     = "Inline";
		objs[beforetab].style.display = "none";

		//--------------- 요기가 중요 ------------------------------//
		objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
		//--------------------------------------------------------//
		beforetab = nItem;

		//if ( formActionType == MODE_MODIFY ) {
			switch(nItem) {
				case 1 :	// Per-diem
					if ( ComGetObjValue(formObj.combo1) == "LT" ) {
						sheetObjects[1].ColHidden("agmt_chg_val") = true;
						sheetObjects[1].ColHidden("loc_cd")       = false;
					} else {
						sheetObjects[1].ColHidden("agmt_chg_val") = false;
						sheetObjects[1].ColHidden("loc_cd")       = true;
					}
					break;
			}
		//}

		/* General Tab에 있는 Container Type/Size Column만 Show */
		switch(nItem) {
			case 1 :	// Per-diem
				setCntrTypeSizeColumns(sheetObjects[0], sheetObjects[1]);
				break;
	
			case 2 :	// Lifting Charges
				setCntrTypeSizeColumns(sheetObjects[0], sheetObjects[2]);
				break;
	
			case 3 :	// DOL/DOC
				setCntrTypeSizeColumns(sheetObjects[0], sheetObjects[3]);
				break;
	
			case 4 :	// Penalty
				setCntrTypeSizeColumns(sheetObjects[0], sheetObjects[5]);
				break;

			case 5 :	// DPP
				setCntrTypeSizeRows(sheetObjects[0], sheetObjects[6]);
				break;
		}
	}

	/**
	 * Sheet Object 내 Container Type/Size 코드들을 문자열로 반환
	 * @param sourceSheetObj : Source Sheet of Container Type/Size
	 * @param targetSheetObj : Target Sheet of Container Type/Size
	 */
	function getGeneralCntrTypeSizes(sheetObj) {
		var vSelectedCntrTpSz = "";
		if ( sheetObj.RowCount > 0 ) {
			for ( var i = sheetObj.HeaderRows ; i <= sheetObj.LastRow ; i++ ) {
				if ( sheetObj.RowHidden(i) == false ) {
					if ( vSelectedCntrTpSz != "" ) {
						vSelectedCntrTpSz = vSelectedCntrTpSz + "|" + sheetObj.CellValue(i, "cntr_tpsz_cd");
					} else {
						vSelectedCntrTpSz = sheetObj.CellValue(i, "cntr_tpsz_cd");
					}
				}
			}
		}
		return vSelectedCntrTpSz;
	}

    /**
	 * Per-diem/Lifting Charges/DOLDOC/Penalty Tab Container Type/Size Setting
	 * Target Sheet 의 Container Type/Size Column 형태로 있는 경우
	 * @param sourceSheetObj : Source Sheet of Container Type/Size
	 * @param targetSheetObj : Target Sheet of Container Type/Size
	 */
	function setCntrTypeSizeColumns(sourceSheetObj, targetSheetObj) {
		var vSelectedCntrTpSz = getGeneralCntrTypeSizes(sourceSheetObj);
		var vShowSheetWidth   = 0;
		var vStartCntrColIdx  = 0;

		if ( vSelectedCntrTpSz != "" ) {
			with(targetSheetObj) {
				if ( FrozenCols == 0 ) {
					vStartCntrColIdx = 1;
				} else {
					vStartCntrColIdx = FrozenCols;
				}

				/* Frozen된 Column의 Width 계산(Hidden Column 제외) */
				for ( var colIdx = 0 ; colIdx < vStartCntrColIdx ; colIdx++ ) {
					if ( ColHidden(colIdx) == false ) { 
						vShowSheetWidth = vShowSheetWidth + ColWidth(colIdx);
					}
				}

				Redraw = false;
				/* General Tab에 입력된 Container Type/Size Column의 Width 계산  */
				for ( var colIdx = vStartCntrColIdx ; colIdx <= LastCol ; colIdx++ ) {
					/* Header Title이 있으면서 General Grid에 있는 Container Type/Size Code와 같을 경우 Hidden false, 다를 경우 Hidden true */
					if ( CellValue(0, colIdx) != "" ) {
						if ( vSelectedCntrTpSz.match(CellValue(0, colIdx)) ) {
							if ( ColHidden(colIdx) == true ) {
								ColHidden(colIdx) = false;
							}
							vShowSheetWidth = vShowSheetWidth + ColWidth(colIdx);
						} else {
							if ( ColHidden(colIdx) == false ) {
								//for ( var i = HeaderRows ; i <= RowCount+(HeaderRows-1) ; i++ ) {
								for ( var i = HeaderRows ; i <= LastRow ; i++ ) {
									CellValue2(i, colIdx) = "";
								}
								ColHidden(colIdx) = true;
							}
						}
					}
				}

				if ( RowCount >= ViewRows ) {
					vShowSheetWidth = vShowSheetWidth + 20;
				} else {
					vShowSheetWidth = vShowSheetWidth + 10;
				}

				if ( vShowSheetWidth > mainTable.clientWidth-20 ) {
					SheetWidth = mainTable.clientWidth-20;
				} else {
					SheetWidth = vShowSheetWidth;
				}

				Redraw = true;
			}
		}

		targetSheetObj.Visible = true;
	}

    /**
	 * DPP Tab Container Type/Size Setting
	 * Target Sheet 의 Container Type/Size Row 형태로 있는 경우
	 * @param sourceSheetObj : Source Sheet of Container Type/Size
	 * @param targetSheetObj : Target Sheet of Container Type/Size
	 */
	function setCntrTypeSizeRows(sourceSheetObj, targetSheetObj) {
		var formObj = document.form;

		/* Source Sheet Container Type/Size */
		var vGeneralCntrTpSz = getGeneralCntrTypeSizes(sourceSheetObj);

		/* Target Sheet Container Type/Size */
		var vDppCntrTpSz     = getGeneralCntrTypeSizes(targetSheetObj);

		with(targetSheetObj) {
			if ( RowCount > 0 ) {
				/* Target Sheet Container Type/Size 가 있을 경우 비교하여 입력 */
				if ( (vGeneralCntrTpSz != "") && (vGeneralCntrTpSz != vDppCntrTpSz) ) {
					var arrGeneralCntrTpSz = vGeneralCntrTpSz.split("|");
					/* DPP Sheet에 없을 경우 신규입력 */
					for ( var i = 0 ; i < arrGeneralCntrTpSz.length ; i++ ) {
						if ( !vDppCntrTpSz.match(arrGeneralCntrTpSz[i]) ) {
							var Row = DataInsert(-1);
							CellValue2(Row, "cntr_tpsz_cd")        = arrGeneralCntrTpSz[i];
							CellValue2(Row, "loc_cd")              = "KRSEL";
							CellValue2(Row, "cntr_rntl_chg_tp_cd") = "DPPV";
						}
					}
					var arrDppCntrTpSz = vDppCntrTpSz.split("|");
					for ( var i = 0 ; i < arrDppCntrTpSz.length ; i++ ) {
						if ( !vGeneralCntrTpSz.match(arrDppCntrTpSz[i]) ) {
							var Row = FindText("cntr_tpsz_cd", arrDppCntrTpSz[i]);
							RowHidden(Row)= true;		//1.행 숨기기
							RowStatus(Row)= "D";		//2.트랜잭션 상태 "삭제"로 만들기
						}
					}
				}
			} else {
				/* DPP Sheet에 Container Type/Size 가 없을 경우 모두 입력 */
				if ( vGeneralCntrTpSz != "" ) {
					var arrGeneralCntrTpSz = vGeneralCntrTpSz.split("|");
					for ( var i = 0 ; i < arrGeneralCntrTpSz.length ; i++ ) {
						var Row = DataInsert(-1);
						CellValue2(Row, "cntr_tpsz_cd")        = arrGeneralCntrTpSz[i];
						CellValue2(Row, "loc_cd")              = "KRSEL";
						CellValue2(Row, "cntr_rntl_chg_tp_cd") = "DPPV";
					}
				}
			}
		}
	}

	/**
	 * Pop-up Open 부분<br>
	 * @param type 1:Agreement(include Ver.) for FORM, 2:Lessor for FORM, 3:Currency for FORM
	 * @param object 대상 Object
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 */
	function openPopupPage(type, Row, Col, SheetIdx) {
		var formObj = document.form;

		if ( type == "1" ) {
			if ( ComGetObjValue(formObj.agmt_ver_seq) != "" ) {
				ComOpenPopup('/hanjin/EES_LSE_0002.do?agmt_seq='+ComGetObjValue(formObj.agmt_seq), 850, 450, 'setPopData_AgreementVer', '1,0', true);
			} else {
				ComOpenPopup('/hanjin/EES_LSE_0091.do', 805, 430, 'setPopData_Agreement', '1,0', true);
			}
		}
	}

	/**
	 * Agreement Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param 대상IBSheet의 Sheet Array index
	 */
	function setPopData_Agreement(aryPopupData, Row, Col, SheetIdx) {
		var formObj  = document.form;
		var sheetObj = sheetObjects[0];

		if ( aryPopupData.length > 0 ) {
			ComSetObjValue(formObj.agmt_seq, aryPopupData[0][4]);
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
		}
	}

	/**
	 * Agreement Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param 대상IBSheet의 Sheet Array index
	 */
	function setPopData_AgreementVer(aryPopupData, Row, Col, SheetIdx) {
		var formObj  = document.form;
		var sheetObj = sheetObjects[0];

		if ( aryPopupData.length > 0 ) {
			ComSetObjValue(formObj.agmt_seq,     aryPopupData[0][4]);
			ComSetObjValue(formObj.agmt_ver_seq, aryPopupData[0][8]);
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
      	}
	}

	/**
	 * 화면 처리 구분에 따른 Form 내 Objects 사용여부 처리 부분<br>
	 * @param type
	 * @param formObj
	 */
	function setFormEnable(type, formObj) {
		switch(type) {
			case MODE_SEARCH :
				if ( formActionType != MODE_SEARCH ) {
					formActionType = MODE_SEARCH;
					LseComEnableForm(false, formObj, "agmt_cty_cd|agmt_ver_seq|dt_drtn|vndr_nm|ofc_cd");
					LseComMndtForm(formObj,"agmt_seq");
					if ( formObj.vndr_seq.className != "input2" ) {
						//ComEnableManyObjects(false, formObj.vndr_seq);
						ComEnableObject(formObj.vndr_seq, false);
					}
					if ( formObj.eff_dt.className != "input2" ) {
						//ComEnableManyObjects(false, formObj.eff_dt);
						ComEnableObject(formObj.eff_dt, false);
					}
					if ( formObj.exp_dt.className != "input2" ) {
						//ComEnableManyObjects(false, formObj.eff_dt);
						ComEnableObject(formObj.exp_dt, false);
					}
					ComEnableManyObjects(true, formObj.btns_search1);
				}
				ComSetFocus(formObj.agmt_seq);
				break
		}
	}

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch(sAction) {
			case IBSEARCH:
				if ( ComGetObjText(formObj.agmt_seq) == "" ) {
					ComShowCodeMessage("LSE01006");
					ComSetFocus(formObj.agmt_seq);
					return false;
				} else {
					if ( !ComChkObjValid(formObj.agmt_seq, true, false, false) ) {
						ComSetFocus(formObj.agmt_seq);
						return false;
					}
				}
				break;

			case IBSEARCH_ASYNC01:
				if( ComGetObjText(formObj.vndr_seq) == "" ) {
					ComShowCodeMessage("LSE01044");
					ComSetFocus(formObj.vndr_seq);
					return false;
				}
				break;
		}

		return true;
    }

	/**
	 * Effective Date 입력 시 Duration 계산 처리 부분<br>
	 */
    function setDuration() {
    	var formObj = document.form;

    	if ( !checkEffDate() ) {
       		ComSetFocus(formObj.exp_dt);
       		return;
       	}

   		var input1 = ComReplaceStr(ComGetObjValue(formObj.eff_dt), "-", "");
   		var input2 = ComReplaceStr(ComGetObjValue(formObj.exp_dt), "-", "");
   		var duration = LseComGetMonthsDateDiff(input1, input2);
		ComSetObjValue(formObj.dt_drtn, duration);
    }

	/**
	 * Effective Date Validation 처리 부분<br>
	 */
    function checkEffDate() {
    	var formObj = document.form;

		/* Effective Date Validation(eff_dt) */
		if( ComGetObjValue(formObj.eff_dt) == "" ) {
			ComShowCodeMessage("LSE01010");
			ComSetFocus(formObj.eff_dt);
			return false;
		} else if ( !ComIsDate(formObj.eff_dt) ) {
			ComShowCodeMessage("LSE01020");
			ComSetObjValue(formObj.eff_dt,"");
			ComSetFocus(formObj.eff_dt);
			return false;
		}

		/* Effective Date Validation(exp_dt) */
		if( ComGetObjValue(formObj.exp_dt) == "" ) {
			ComShowCodeMessage("LSE01011");
			ComSetFocus(formObj.exp_dt);
			return false;
		} else if ( !ComIsDate(formObj.exp_dt) ) {
			ComShowCodeMessage("LSE01026");
			ComSetObjValue(formObj.exp_dt,"");
			ComSetFocus(formObj.exp_dt);
			return false;
		}

		/* Effective Date Validation(eff_dt < exp_dt) */
		var vEffDt = ComReplaceStr(ComGetObjValue(formObj.eff_dt),"-","");
		var vExpDt = ComReplaceStr(ComGetObjValue(formObj.exp_dt),"-","");
		if ( ComChkPeriod(vEffDt, vExpDt) != 1 ) {
			ComShowCodeMessage("LSE01051");
			ComSetObjValue(formObj.exp_dt,"");
			ComSetFocus(formObj.exp_dt);
			return false;
		}

		return true;
    }

	/*
	 * Container Spec No. Cell Control
	 * - Lease Term 이 'LT' 일 경우에만 Genearl Data 의 Spec No. 입력 가능.
	 * - 2009.09.16 by 이유목 수석 요청
	 */
	function control_Spec_No (text) {
		var sheetObj = sheetObjects[0];

		if ( text == "LT" ) {
			sheetObj.ColHidden("cntr_spec_no") = false;
		} else {
			sheetObj.ColHidden("cntr_spec_no") = true;
		}
	}

	/* 개발자 작업  끝 */
