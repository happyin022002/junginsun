/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_lse_0004.js
*@FileTitle : Agreement List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.29
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.04.27 노정용
* 1.0 Creation
 * =======================================================
 * 2010.12.01 박명신 [CHM-201007443-01] Ref No. 추가
 * 2010.12.08 남궁진호 [CHM-201007442-01] Ref No. 컬럼크기조정
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
	/**
	 *@fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
	 * @author 노정용
	 */

	/**
	 * @extends
	 * @class ees_lse_0004 : ees_lse_0004 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ees_lse_0004() {
		this.processButtonClick		= processButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.setComboObject 		= setComboObject;
		this.loadPage 				= loadPage;
		this.initControl            = initControl;
		this.obj_blur				= obj_blur;
		this.obj_focus				= obj_focus;
		this.obj_change				= obj_change;
		this.obj_keypress			= obj_keypress;
		this.obj_keyup				= obj_keyup;
		this.obj_keydown			= obj_keydown;
		this.initSheet 				= initSheet;
		this.initCombo 				= initCombo;
		this.doActionIBSheet 		= doActionIBSheet;
		this.sheet1_OnSearchEnd		= sheet1_OnSearchEnd;
		this.openPopup				= openPopup;
		this.setPopData_Lessor		= setPopData_Lessor;
		this.validateForm 			= validateForm;
		this.clearForm 				= clearForm;
	}

	/* 개발자 작업	*/

	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;

	// Combo Object Array
	var comboObjects = new Array();
	var comboCnt = 0;

	/* 현재 Lease Term 코드 문자열 : "|"로 연결 */
	var vOrcLstmCd;
	/* 현재 Active 상태의 컨테이너 타입/사이즈 코드 문자열 : "|"로 연결 */
	var vOrgCntrTpSzCd;
	/* 현재 Active 상태의 컨테이너 타입/사이즈 코드 배열 */
	var arrOrgCntrTpSzCd;
	/* IBSheet 내 DbClick 된 Agreement 의 Lease Term Code */
	var vAgmtLstmCd;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		var comboObject1 = comboObjects[0];
		/*******************************************************/

		var formObj = document.form;

		try {
			var srcObj  = window.event.srcElement;
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "btn_Retrieve":
					sheetObject1.RemoveAll();
					doActionIBSheet(sheetObject1, formObj, IBSEARCH);
 					break;

				case "btn_New":
					ComResetAll();
					ComSetFocus(formObj.exp_from_dt);
					comboObjects[0].Index = 0;
					break;

				case "btn_DownExcel":
					sheetObject1.Down2Excel(-1, false, false, true, "", "./apps/alps/ees/lse/containerleaseagreementregistration/agreementregistration/jsp/EES_LSE_0004_FORM.jsp?row_count="+sheetObject1.RowCount);
					break;

				case "btns_search":
					// Lessor Search
					openPopup("3");
					break;

				case "btns_search1":
					openPopup("1");
					break;

				case "chk_lstm_cd":
					/* Lease Term 체크박스 체크시 전체체크,전체해재 기능 */
					if ( srcObj.checked ) {
						comboObject1.Code = vOrcLstmCd.replaceStr("|", ",");
					} else {
						comboObject1.Code = "";
					}
					break;

				case "btns_calendar1":
					var cal = new ComCalendarFromTo();
					cal.select(formObj.exp_from_dt, formObj.exp_to_dt, 'yyyy-MM-dd');
					break;
			} // end switch
		} catch (e) {
			if ( e == "[object Error]") {
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
		var formObj = document.form;

		vOrgCntrTpSzCd   = ComGetObjValue(formObj.org_cntr_tpsz_cd);
		arrOrgCntrTpSzCd = vOrgCntrTpSzCd.split("|");

		/* IBMultiCombo 초기화 */
		for ( var k = 0 ; k < comboObjects.length ; k++ ) {
	        initCombo(comboObjects[k], k+1);
	    }

		/* IBSheet 초기화 */
		for( var i = 0 ; i < sheetObjects.length ; i++ ) {
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );

			initSheet(sheetObjects[i],i+1);

			//khlee-마지막 환경 설정 함수 추가
 			ComEndConfigSheet(sheetObjects[i]);
 		}

		/* Axon Control Setting*/
		initControl();

		/* 초기 Focus Setting */
		var vExpFromDt = ComGetObjValue(formObj.cur_year)+ComLpad(ComGetObjValue(formObj.cur_month), 2, "0")+"01"
		var vExpToDt   = ComGetObjValue(formObj.cur_year)+ComLpad(ComGetObjValue(formObj.cur_month), 2, "0")+ComGetLastDay(ComParseInt(ComGetObjValue(formObj.cur_year)), ComParseInt(ComGetObjValue(formObj.cur_month)));

		ComSetObjValue(formObj.exp_from_dt, vExpFromDt);
		ComSetObjValue(formObj.exp_to_dt,   vExpToDt);
		ComAddSeparator(formObj.exp_from_dt, "ymd");
		ComAddSeparator(formObj.exp_to_dt, "ymd");
	}

  	// Axon 이벤트 처리
  	// 1. 이벤트catch
  	function initControl() {
  		var formObj = document.form;
  		axon_event.addListenerFormat('beforedeactivate',		'obj_blur',		formObj); //- 포커스 나갈때
		axon_event.addListenerFormat('focus',		'obj_focus',	formObj); //- 포커스 들어갈때
  		axon_event.addListenerFormat('keypress',	'obj_keypress',	formObj); //- 키 눌렸을때
		axon_event.addListenerFormat('keyup',		'obj_keyup',	formObj); //- 키 올라올때
		axon_event.addListenerFormat('keydown',		'obj_keydown',	formObj); //- 키 눌렸을때
		axon_event.addListenerFormat('change',		'obj_change',	formObj); //- 변경될때.
  	}

  	// 2. 이벤트처리함수 -- Start
  	/**
	 * HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
	 */
	function obj_blur(){
		var obj = event.srcElement;

	    switch(obj.name){
	        case "vndr_seq":
	            //숫자이면서 천단위 구분을 하지 않는다.
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

		if ( ComTrim(obj.value) != "" ) {
			switch(obj.name) {
	    		case "vndr_seq":
	        		doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC02);
				   	break;
			}
	    }
	}

	/**
	 * Key-Press Event 처리
	 */
  	function obj_keypress() {
		var obj = event.srcElement;

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
  	 * Key-Up Event 처리
  	 */
  	function obj_keyup() {
  		var obj = event.srcElement;

  		switch(obj.name) {
 			case "vndr_seq":
  				if ( ComTrim(obj.value) == "" ) {
  					clearForm(obj.name);
  				} else {
  					ComKeyEnter('LengthNextFocus');
  				}
  				break;
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
   			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
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

		switch(sheetid){
			case "sheet1":
				with (sheetObj) {
					// 높이 설정
					style.height = 400;

					//전체 너비 설정
					SheetWidth = sheetTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msPrevColumnMerge;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 4, 3, 100);

					var HeadTitle1 = "Term|Lessor|AGMT No.|Contract No|Ref No.|Contract Period|Contract Period|Division|TTL|"+vOrgCntrTpSzCd+"||";
					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 9, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, false, false, true, false, false)

					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					// 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					// Contract QTY
					InitDataProperty(0, cnt++ , dtData,		40,	daCenter,	true,	"lstm_cd",			false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,		50,	daCenter,	true,	"vndr_abbr_nm",		false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,		75,	daCenter,	true,	"agmt_no",			false,	"",	dfNone);					
					InitDataProperty(0, cnt++ , dtData,		75,	daCenter,	true,	"lse_ctrt_no",		false,	"",	dfNone);					
					InitDataProperty(0, cnt++ , dtData,		110,daLeft,		true,	"ref_no",			false,	"",	dfNone);
					
					InitDataProperty(0, cnt++ , dtData,		70,	daCenter,	true,	"eff_dt",			false,	"",	dfDateYmd);
					InitDataProperty(0, cnt++ , dtData,		70,	daCenter,	true,	"exp_dt",			false,	"",	dfDateYmd);

					InitDataProperty(0, cnt++ , dtData,		80,	daCenter,	true,	"type_nm",			false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,		60,	daRight,	true,	"ttl",				false,	"",	dfInteger);
					for ( var i = 0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
						eval('InitDataProperty(0, cnt++, dtData, 50, daRight, false, "cntr'+(i+1)+'_qty", false, "", dfInteger);');
					}
 					InitDataProperty(0, cnt++ , dtHidden,	80,	daRight,	true,	"fst_cls",			false,	"",	dfNone);
 					InitDataProperty(0, cnt++ , dtHidden,	80,	daRight,	true,	"type_cd",			false,	"",	dfNone);

 					// Lease QTY
 					cnt = 0;
 					InitDataProperty(1, cnt++ , dtData,		40,	daCenter,	true,	"lstm_cd",			false,	"",	dfNone);
 					InitDataProperty(1, cnt++ , dtData,		50,	daCenter,	true,	"vndr_abbr_nm",		false,	"",	dfNone);
					InitDataProperty(1, cnt++ , dtData,		75,	daCenter,	true,	"agmt_no",			false,	"",	dfNone);
					InitDataProperty(1, cnt++ , dtData,		75,	daCenter,	true,	"lse_ctrt_no",		false,	"",	dfNone);
					InitDataProperty(1, cnt++ , dtData,		75,	daCenter,	true,	"ref_no",			false,	"",	dfNone);
					InitDataProperty(1, cnt++ , dtData,		70,	daCenter,	true,	"eff_dt",			false,	"",	dfDateYmd);
					InitDataProperty(1, cnt++ , dtData,		70,	daCenter,	true,	"exp_dt",			false,	"",	dfDateYmd);

					InitDataProperty(1, cnt++ , dtData,		80,	daCenter,	true,	"type_nm",			false,	"",	dfNone);
					InitDataProperty(1, cnt++ , dtData,		60,	daRight,	true,	"ttl",				false,	"",	dfInteger);
 					for ( var i = 0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
						eval('InitDataProperty(1, cnt++, dtData, 50, daRight, false, "cntr'+(i+1)+'_qty", false, "", dfInteger);');
					}
 					InitDataProperty(1, cnt++ , dtHidden,	80,	daRight,	true,	"fst_cls",			false,	"",	dfNone);
 					InitDataProperty(1, cnt++ , dtHidden,	80,	daRight,	true,	"type_cd",			false,	"",	dfNone);

 					//Current QTY
 					cnt = 0;
 					InitDataProperty(2, cnt++ , dtData,		40,	daCenter,	true,	"lstm_cd",			false,	"",	dfNone);
					InitDataProperty(2, cnt++ , dtData,		50,	daCenter,	true,	"vndr_abbr_nm",		false,	"",	dfNone);
					InitDataProperty(2, cnt++ , dtData,		75,	daCenter,	true,	"agmt_no",			false,	"",	dfNone);
					InitDataProperty(2, cnt++ , dtData,		75,	daCenter,	true,	"lse_ctrt_no",		false,	"",	dfNone);
					InitDataProperty(2, cnt++ , dtData,		75,	daCenter,	true,	"ref_no",			false,	"",	dfNone);
					InitDataProperty(2, cnt++ , dtData,		70,	daCenter,	true,	"eff_dt",			false,	"",	dfDateYmd);
					InitDataProperty(2, cnt++ , dtData,		70,	daCenter,	true,	"exp_dt",			false,	"",	dfDateYmd);

					InitDataProperty(2, cnt++ , dtData,		80,	daCenter,	true,	"type_nm",			false,	"",	dfNone);
 					InitDataProperty(2, cnt++ , dtData,		60,	daRight,	true,	"ttl",				false,	"",	dfInteger);
 					for ( var i = 0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
						eval('InitDataProperty(2, cnt++, dtData, 50, daRight, false, "cntr'+(i+1)+'_qty", false, "", dfInteger);');
					}
 					InitDataProperty(2, cnt++ , dtHidden,	80,	daRight,	true,	"fst_cls",			false,	"",	dfNone);
 					InitDataProperty(2, cnt++ , dtHidden,	80,	daRight,	true,	"type_cd",			false,	"",	dfNone);

 					//Per-Diem
 					cnt = 0;
 					InitDataProperty(3, cnt++ , dtData,		40,	daCenter,	true,	"lstm_cd",			false,	"",	dfNone);
					InitDataProperty(3, cnt++ , dtData,		50,	daCenter,	true,	"vndr_abbr_nm",		false,	"",	dfNone);
					InitDataProperty(3, cnt++ , dtData,		75,	daCenter,	true,	"agmt_no",			false,	"",	dfNone);
					InitDataProperty(3, cnt++ , dtData,		75,	daCenter,	true,	"lse_ctrt_no",		false,	"",	dfNone);
					InitDataProperty(3, cnt++ , dtData,		75,	daCenter,	true,	"ref_no",			false,	"",	dfNone);
					InitDataProperty(3, cnt++ , dtData,		70,	daCenter,	true,	"eff_dt",			false,	"",	dfDateYmd);
					InitDataProperty(3, cnt++ , dtData,		70,	daCenter,	true,	"exp_dt",			false,	"",	dfDateYmd);

					InitDataProperty(3, cnt++ , dtData,		80,	daCenter,	true,	"type_nm",			false,	"",	dfNone);
					InitDataProperty(3, cnt++ , dtData,		60,	daRight,	true,	"ttl",				false,	"",	dfFloat, 2);
 					for ( var i = 0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
						eval('InitDataProperty(3, cnt++, dtData, 50, daRight, false, "cntr'+(i+1)+'_qty", false, "", dfFloat, 2);');
					}
 					InitDataProperty(3, cnt++ , dtHidden,	80,	daRight,	true,	"fst_cls",			false,	"",	dfNone);
 					InitDataProperty(3, cnt++ , dtHidden,	80,	daRight,	true,	"type_cd",			false,	"",	dfNone);

 					DataLinkMouse("agmt_no") = true;

 					SelectBackColor = LSE_SELECT_BACK_COLOR;
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
	        case "lstm_cd":
	        	with(comboObj) {
	            	DropHeight = 250;
	            	MultiSelect = true;
	            	UseAutoComplete = true;
	            	ValidChar(2,2);
	        	}
	        	break;
	    }
	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		switch(sAction) {
			case IBCREATE:
				sheetObj.WaitImageVisible = false;

				/* Lease Term Form Combo Item Setting */
				ComSetObjValue(formObj.f_cmd, SEARCH01);
		     	var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", FormQueryString(formObj));

		        if ( sXml != "" ) {
		        	//comboObjects[0].InsertItem(0, 'ALL','');
		        	LseComXml2ComboItem(sXml, comboObjects[0], "lease_term_nm", "lease_term_cd", "|");
		        }

		        vOrcLstmCd = ComGetEtcData(sXml, "lease_term_nm");

		        /* 초기 Focus Setting */
		        ComSetFocus(formObj.vndr_seq);
	            sheetObj.WaitImageVisible = true;
	            break;

			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
					if ( sheetObj.id == "sheet1") {
						ComSetObjValue(formObj.f_cmd, SEARCH);
						
						sheetObj.WaitImageVisible = false;
						ComOpenWait(true);
						sheetObj.Redraw = false;
						sheetObj.DoSearch4Post("EES_LSE_0004GS.do", FormQueryString(formObj));
						sheetObj.Redraw = true;
						ComOpenWait(false);
						sheetObj.WaitImageVisible = true;
					}
				}
				break;

 			case IBSEARCH_ASYNC02:	//조회(Form Lessor No. 입력시)
 				if(validateForm(sheetObj,formObj,sAction)) {
 					if ( sheetObj.id == "sheet1") {
 						var param = "f_cmd="+SEARCH06+"&vndr_seq="+ComGetObjValue(formObj.vndr_seq);
 						sheetObj.WaitImageVisible = false;
 						var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", param);
 						sheetObj.WaitImageVisible = true;

 						if ( sXml != "" ) {
 							if ( ComGetEtcData(sXml, "vndr_lgl_eng_nm") != undefined ) {
 								ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
 								ComSetNextFocus(formObj.vndr_seq);
 	 						} else {
 	 							ComShowCodeMessage("LSE01019");
 	 							ComSetObjValue(formObj.vndr_seq, "");
 	 							ComSetObjValue(formObj.vndr_nm, "");
 	 							ComSetFocus(formObj.vndr_seq);
 	 						}
 						} else {
 							ComShowCodeMessage("LSE01019");
 							ComSetObjValue(formObj.vndr_seq, "");
 							ComSetFocus(formObj.vndr_seq);
 						}
 					}
 				}
 				break;
		}
	}

	function sheet1_OnLoadFinish(sheetObj) {
		var formObj = document.form;

		/* IBMulti Combo Item Setting */
		doActionIBSheet(sheetObj, formObj, IBCREATE);
	}

	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		if ( ErrMsg == "" ) {
			for ( var i = sheetObj.FrozenCols ; i < sheetObj.LastCol-1 ; i++ ) {
				var sum = eval('sheetObj.ComputeSum("|'+i+'|");');
				if ( sum == 0 ) {
					sheetObj.ColHidden(i) = true;
				} else {
					sheetObj.ColHidden(i) = false;
				}
			}
		}
	}

	/**
	 * MultiSelect속성을 이용하는 경우, 체크박스를 클릭하는 순간 발생한다.
	 * @return
	 */
	function lstm_cd_OnCheckClick(comboObj, index, code) {
		/*
		// All Check 기능 사용시
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
		*/
	}

	/**
	 * combo1_OnKeyDown
	 * @deprecated 2009.07.21 IBCombo Single로 현재 사용되지 않는다.
	 */
	function lstm_cd_OnKeyDown(comboObj, KeyCode, Shift) {
		with(comboObj) {
			if ( KeyCode == 8 || KeyCode == 46 ) {
				for ( var i = 0 ; i < GetCount() ; i++ ) {
					if ( CheckIndex(i) ) {
						//CheckIndex(i) = false;
					}
				}
			}
		}
	}

    /**
	 * Per-diem/Lifting Charges/DOLDOC/Penalty Tab Container Type/Size Setting
	 * Target Sheet 의 Container Type/Size Column 형태로 있는 경우
	 * @param vSelectedCntrTpSz : General Data 에 등록된 Container Type/Size 문자열
	 * @param targetSheetObj : Target Sheet of Container Type/Size
	 */
	function setCntrTypeSizeColumns(vSelectedCntrTpSz, targetSheetObj) {
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
     * Pop-up Open 부분<br>
     * @param type 1:Location for FORM, 2:Agreement No. Selection for FORM, 3:Lessor for FORM
     * @param object 대상 Object
     * @param Row 대상Object가 IBSheet일 경우 해당 Row index
     */
    function openPopup(type, Row, Col) {
    	 if ( type == "3" ) {
    		ComOpenPopup('/hanjin/COM_ENS_0C1.do', 700, 450, 'setPopData_Lessor', '1,0,1,1,1,1,1,1', true);
    	} else if ( type == "1") {
    		var formObj = document.form;
    		var sUrl    = '/hanjin/COM_ENS_071.do';
			var iWidth  = 855;
			var iHeight = 435;
			var sTargetObjList = "ofc_cd:ofc_cd";
			var sDisplay = "1,0,1,1,1,1,1,1";

			ComOpenPopupWithTarget(sUrl, iWidth, iHeight, sTargetObjList, sDisplay, true);
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
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC02);
		}
	}

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction) {
    	switch(sAction) {
    		case IBSEARCH:      //조회
    			if ( ComGetObjValue(formObj.lstm_cd) == "" ) {
    				ComShowCodeMessage("LSE01009");
     				ComSetFocus(formObj.lstm_cd);
    				return false;
    			}

    			return ComChkValid(formObj);
    			break;
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
			case "vndr_seq":
				ComSetObjValue(formObj.vndr_seq, "");
				ComSetObjValue(formObj.vndr_nm,  "");
				break;
		}
	}
	/* 개발자 작업  끝 */