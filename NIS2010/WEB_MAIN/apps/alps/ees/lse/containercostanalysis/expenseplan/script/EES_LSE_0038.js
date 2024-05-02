/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0038.js
*@FileTitle : Lease Expense Plan & Performance
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.06.30 장준우
* 1.0 Creation
* ========================================================
* 2010.09.06 남궁진호 [CHM-201005772-01] G.TTL 부분을 SHEET하단에 표시하고 조회된 G.TTL ROW 삭제
*                   조회 SQL변경으로 인한 TOTAL 구하는 로직 및 비율 계산로직 제거
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
	/**
	 *@fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
	 * @author 한진해운
	 */

	/**
	 * @extends
	 * @class EES_LSE_0038 : EES_LSE_0038 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_LSE_0038() {
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
		this.initSheet 				= initSheet;
		this.initCombo 				= initCombo;
		this.doActionIBSheet 		= doActionIBSheet;
		this.combo1_OnBlur			= combo1_OnBlur;
		this.combo2_OnBlur			= combo2_OnBlur;
		this.combo1_OnKeyDown		= combo1_OnKeyDown;
		this.combo2_OnKeyDown		= combo2_OnKeyDown;
		this.combo1_OnCheckClick	= combo1_OnCheckClick;
		this.combo2_OnCheckClick	= combo2_OnCheckClick;
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

   	var vEqTermNm = "";

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		/*******************************************************/

		var formObj = document.form;

		try {
			var srcObj  = window.event.srcElement;
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
 					break;

				case "btn_New":
					ComResetAll();
					ComSetFocus(formObj.pln_yr);
					break;

				case "btn_DownExcel":
					//sheetObject1.SpeedDown2Excel(-1);
					sheetObject1.Down2Excel(-1, false, false, true);
					break;

				case "eq_knd_cd":
					comboObjects[1].RemoveAll();
					comboObjects[1].InsertItem(0 , 'ALL','');

					if(srcObj.value == "CNTR") {
						var strText = "LP|OL|LT|ST|SB|SO";
			        	var strCode = "LP|OL|LT|ST|SB|SO";
			        	LseComText2ComboItem(comboObjects[1], strText, strCode, "|");
			        	vEqTermNm = "LP|OL|LT|ST|SB|SO";
					} else if(srcObj.value == "CHSS") {
						var strText = "LP|OL|LS|NP|CP|MG.SET";
			        	var strCode = "LP|OL|LS|NP|CP|MG.SET";
			        	LseComText2ComboItem(comboObjects[1], strText, strCode, "|");
			        	vEqTermNm = "LP|OL|LT|ST|NP|CP|MG.SET";
					} else {
						var strText = "LP|OL|LT|ST|SB|SO|NP|CP|MG.SET";
			        	var strCode = "LP|OL|LT|ST|SB|SO|NP|CP|MG.SET";
			        	LseComText2ComboItem(comboObjects[1], strText, strCode, "|");
			        	vEqTermNm = "LP|OL|LT|ST|SB|SO|NP|CP|MG.SET";
					}

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

		 /* IBSheet 초기화 */
		 for( var i = 0 ; i < sheetObjects.length ; i++ ) {
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );

			initSheet(sheetObjects[i],i+1);

			//khlee-마지막 환경 설정 함수 추가
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
		ComSetFocus(formObj.pln_yr);
    }

  	// Axon 이벤트 처리
  	// 1. 이벤트catch
  	function initControl() {
  		var formObj = document.form;
  		axon_event.addListenerFormat('blur',		'obj_blur',		formObj); //- 포커스 나갈때
		axon_event.addListenerFormat('focus',		'obj_focus',	formObj); //- 포커스 들어갈때
  		axon_event.addListenerFormat('keypress',	'obj_keypress',	formObj); //- 키 눌렸을때
		axon_event.addListenerFormat('keyup',		'obj_keyup',	formObj); //- 키 올라올때
		axon_event.addListenerForm('keydown',		'obj_keydown',	formObj); //- 키 눌렸을때
		axon_event.addListenerFormat('change',		'obj_change',	formObj); //- 변경될때.
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
	    	case "pln_yr":
  				//Validation 전체 체크(길이,format,최대,최소 등등)
	            //if(ComChkObjValid(obj, true, false, false) == false) {
	            //	ComSetFocus(obj);
	            //}
	            ComChkObjValid(obj, true, false, false);
	    		break;
	        case "ver_seq":
	            //숫자이면서 천단위 구분을 하지 않는다.
	            ComChkObjValid(obj);
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
	    		default : //do nothing
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
			case "pln_yr":
				if ( ComTrim(obj.value) == "" ) {
  					clearForm(obj.name);
  				} else {
  					ComKeyEnter('LengthNextFocus');
  				}
  				break;
			case "ver_seq":
  				ComKeyEnter('LengthNextFocus');
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
   			//formObj.ver_seq.focus();
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
					InitRowInfo(1, 3, 10, 100);

					var HeadTitle1 = "Year|EQ Type|L/Term|Result|JAN|FEB|MAR|1/4 QTA|APR|MAY|JUN|2/4 QTA|JUL|AUG|SEP|3/4 QTA|OCT|NOV|DEC|4/4 QTA|G.TTL|||";
					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 4, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false)

					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					for(var i = 0; i < 3; i++) { //G.TOTAL 부분 표시를 위해 설정 2010.09.06
					cnt=0;
					// 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(i, cnt++ , dtData,		60,	daCenter,	true,	"pln_yr",		false,	"",	dfNone);
					InitDataProperty(i, cnt++ , dtData,		60,	daCenter,	true,	"eq_knd_nm",	false,	"",	dfNone);
					InitDataProperty(i, cnt++ , dtData,		60,	daCenter,	true,	"eq_term_nm",	false,	"",	dfNone);
 					InitDataProperty(i, cnt++ , dtData,		60,	daCenter,	false,	"rslt_tp",		false,	"",	dfNone);
 					InitDataProperty(i, cnt++ , dtData,		80,	daRight,	false,	"mnth_01",		false,	"",	dfNone);
					InitDataProperty(i, cnt++ , dtData,		80,	daRight,	false,	"mnth_02",		false,	"",	dfNone);
					InitDataProperty(i, cnt++ , dtData,		80,	daRight,	false,	"mnth_03",		false,	"",	dfNone);
					InitDataProperty(i, cnt++ , dtData,		90,	daRight,	false,	"frst_qurt_tot",false,	"",	dfNone);
					InitDataProperty(i, cnt++ , dtData,		80,	daRight,	false,	"mnth_04",		false,	"",	dfNone);
					InitDataProperty(i, cnt++ , dtData,		80,	daRight,	false,	"mnth_05",		false,	"",	dfNone);
					InitDataProperty(i, cnt++ , dtData,		80,	daRight,	false,	"mnth_06",		false,	"",	dfNone);
					InitDataProperty(i, cnt++ , dtData,		90,	daRight,	false,	"scnd_qurt_tot",false,	"",	dfNone);
					InitDataProperty(i, cnt++ , dtData,		80,	daRight,	false,	"mnth_07",		false,	"",	dfNone);
					InitDataProperty(i, cnt++ , dtData,		80,	daRight,	false,	"mnth_08",		false,	"",	dfNone);
					InitDataProperty(i, cnt++ , dtData,		80,	daRight,	false,	"mnth_09",		false,	"",	dfNone);
					InitDataProperty(i, cnt++ , dtData,		90,	daRight,	false,	"thrd_qurt_tot",false,	"",	dfNone);
					InitDataProperty(i, cnt++ , dtData,		80,	daRight,	false,	"mnth_10",		false,	"",	dfNone);
					InitDataProperty(i, cnt++ , dtData,		80,	daRight,	false,	"mnth_11",		false,	"",	dfNone);
					InitDataProperty(i, cnt++ , dtData,		80,	daRight,	false,	"mnth_12",		false,	"",	dfNone);
					InitDataProperty(i, cnt++ , dtData,		90,	daRight,	false,	"frth_qurt_tot",false,	"",	dfNone);
					InitDataProperty(i, cnt++ , dtData,		90,	daRight,	false,	"yr_tot",		false,	"", dfNone);
					InitDataProperty(i, cnt++ , dtHidden,	70,	daCenter,	true,	"rslt_tp_seq",	false,	"",	dfNone);
					InitDataProperty(i, cnt++ , dtHidden,	70,	daCenter,	true,	"ver_seq",		false,	"",	dfNone);
					InitDataProperty(i, cnt++ , dtAutoSum,  80, daRight,    true,   "auto_sum",     false,  "", dfNone);
					}
 					CountFormat = "[SELECTDATAROW / TOTALROWS]";
 					
 					ColHidden("auto_sum") = true;
// 					SelectBackColor = LSE_SELECT_BACK_COLOR;
 					//CountPosition = 0;
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
             		//영문+특수문자 - 달력
             		ValidChar(1,2);
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
             		//영문(대)+특수문자 - Lease Term
             		ValidChar(2,2);
	            }

	        	break;
	    }
	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBCREATE:
	        	sheetObj.WaitImageVisible = false;

	        	//Plan Month Combo Item Setting Start */
	        	var strText = "Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec";
	        	var strCode = "JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC";
	        	comboObjects[0].InsertItem(0 , 'ALL','');
	        	LseComText2ComboItem(comboObjects[0], strText, strCode, "|");

	        	//Lease Term Combo Item Setting
	        	var strText = "LP|OL|LT|ST|SB|SO|N/P|C/P|MG.SET";
	        	var strCode = "LP|OL|LT|ST|SB|SO|N/P|C/P|MG.SET";
	        	comboObjects[1].InsertItem(0 , 'ALL','');
	        	LseComText2ComboItem(comboObjects[1], strText, strCode, "|");
	        	vEqTermNm = "LP|OL|LT|ST|SB|SO|N/P|C/P|MG.SET";

				sheetObj.WaitImageVisible = true;
	            break;

			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
					if ( sheetObj.id == "sheet1") {
						formObj.f_cmd.value = SEARCH;

						//Lease Expense Month
						formObj.expn_mon_cd.value = ComGetObjValue(comboObjects[0]);
						//Expense Lease Term
						formObj.eq_term_nm.value = ComGetObjValue(comboObjects[1]);

						sheetObj.WaitImageVisible = false;
		        		ComOpenWait(true);
						var sXml = sheetObj.GetSearchXml("EES_LSE_0038GS.do", FormQueryString(formObj));
						ComOpenWait(false);

						if(ComGetTotalRows(sXml) > 0){
							var comboVal = ComGetObjValue(comboObjects[0]);

							if ( comboVal != "" )
							{
								for ( var i = 1 ; i <= 12 ; i++ ) {
									eval('sheetObj.ColHidden("mnth_'+ ComLpad(i, 2, "0") + '") = true;');
								}
								sheetObj.ColHidden("frst_qurt_tot") = true;
								sheetObj.ColHidden("scnd_qurt_tot") = true;
								sheetObj.ColHidden("thrd_qurt_tot") = true;
								sheetObj.ColHidden("frth_qurt_tot") = true;

								var arrComboVal = comboVal.split(",");

								for ( var i = 0 ; i < arrComboVal.length ; i++ ) {
									switch(arrComboVal[i]) {
										case "JAN" :
											sheetObj.ColHidden("mnth_01")       = false;
											sheetObj.ColHidden("frst_qurt_tot") = false;
											break;
										case "FEB" :
											sheetObj.ColHidden("mnth_02")       = false;
											sheetObj.ColHidden("frst_qurt_tot") = false;
											break;
										case "MAR" :
											sheetObj.ColHidden("mnth_03")       = false;
											sheetObj.ColHidden("frst_qurt_tot") = false;
											break;
										case "APR" :
											sheetObj.ColHidden("mnth_04")       = false;
											sheetObj.ColHidden("scnd_qurt_tot") = false;
											break;
										case "MAY" :
											sheetObj.ColHidden("mnth_05")       = false;
											sheetObj.ColHidden("scnd_qurt_tot") = false;
											break;
										case "JUN" :
											sheetObj.ColHidden("mnth_06")       = false;
											sheetObj.ColHidden("scnd_qurt_tot") = false;
											break;
										case "JUL" :
											sheetObj.ColHidden("mnth_07")       = false;
											sheetObj.ColHidden("thrd_qurt_tot") = false;
											break;
										case "AUG" :
											sheetObj.ColHidden("mnth_08")       = false;
											sheetObj.ColHidden("thrd_qurt_tot") = false;
											break;
										case "SEP" :
											sheetObj.ColHidden("mnth_09")       = false;
											sheetObj.ColHidden("thrd_qurt_tot") = false;
											break;
										case "OCT" :
											sheetObj.ColHidden("mnth_10")       = false;
											sheetObj.ColHidden("frth_qurt_tot") = false;
											break;
										case "NOV" :
											sheetObj.ColHidden("mnth_11")       = false;
											sheetObj.ColHidden("frth_qurt_tot") = false;
											break;
										case "DEC" :
											sheetObj.ColHidden("mnth_12")       = false;
											sheetObj.ColHidden("frth_qurt_tot") = false;
											break;
											break;
									}
								}
							} else {
								for ( var i = 1 ; i <= 12 ; i++ ) {
									eval('sheetObj.ColHidden("mnth_'+ ComLpad(i, 2, "0") + '") = false;');
								}
								sheetObj.ColHidden("frst_qurt_tot") = false;
								sheetObj.ColHidden("scnd_qurt_tot") = false;
								sheetObj.ColHidden("thrd_qurt_tot") = false;
								sheetObj.ColHidden("frth_qurt_tot") = false;
							}

							sheetObj.Redraw = false;
							sheetObj.LoadSearchXml(sXml);
/*-------------------------------- 2010.09.06 SQL에서  분기TOTAL 및 S.TTL, G.TTL을 계산하도록 변경하여 주석처리함 ------------
//							for ( var idx = sheetObj.HeaderRows ; idx <= sheetObj.SearchRows ; idx++ ) {
//								if ( sheetObj.CellValue(idx, "rslt_tp_seq") == "3" ) {
//									if ( sheetObj.CellValue(idx-2,"frst_qurt_tot") != 0 ) {
//										sheetObj.CellValue(idx,"frst_qurt_tot") = (sheetObj.CellValue(idx-1,"frst_qurt_tot")/sheetObj.CellValue(idx-2,"frst_qurt_tot")*100).toFixed(2);
//									}
//									if ( sheetObj.CellValue(idx-2,"scnd_qurt_tot") != 0 ) {
//										sheetObj.CellValue(idx,"scnd_qurt_tot") = (sheetObj.CellValue(idx-1,"scnd_qurt_tot")/sheetObj.CellValue(idx-2,"scnd_qurt_tot")*100).toFixed(2);
//									}
//									if ( sheetObj.CellValue(idx-2,"thrd_qurt_tot") != 0 ) {
//										sheetObj.CellValue(idx,"thrd_qurt_tot") = (sheetObj.CellValue(idx-1,"thrd_qurt_tot")/sheetObj.CellValue(idx-2,"thrd_qurt_tot")*100).toFixed(2);
//									}
//									if ( sheetObj.CellValue(idx-2,"frth_qurt_tot") != 0 ) {
//										sheetObj.CellValue(idx,"frth_qurt_tot") = (sheetObj.CellValue(idx-1,"frth_qurt_tot")/sheetObj.CellValue(idx-2,"frth_qurt_tot")*100).toFixed(2);
//									}
//									if ( sheetObj.CellValue(idx-2,"yr_tot") != 0 ) {
//										sheetObj.CellValue(idx,"yr_tot") = (sheetObj.CellValue(idx-1,"yr_tot")/sheetObj.CellValue(idx-2,"yr_tot")*100).toFixed(2);
//									}
//
//									//S.TTL 및 G.TTL에 대한 비율계산 추가
//									if(sheetObj.CellValue(idx, "eq_knd_nm") == "G.TTL" || sheetObj.CellValue(idx, "eq_term_nm") == "S.TTL" ) {
//										for ( var i = 1 ; i <= 12 ; i++ ) {
//											var vPlan = eval('sheetObj.CellValue(idx-2,"mnth_'+ ComLpad(i, 2, "0") + '")');
//											var vPfmc = eval('sheetObj.CellValue(idx-1,"mnth_'+ ComLpad(i, 2, "0") + '")');
//
//											if ( vPlan != 0 ) {
//												var vRatio = (vPfmc / vPlan * 100).toFixed(2);
//												eval('sheetObj.CellValue(idx,"mnth_'+ ComLpad(i, 2, "0") + '") = '+ vRatio +';');
//											}
//										}
//									}
//								}
//							}

//							for ( var idx = sheetObj.HeaderRows ; idx <= sheetObj.SearchRows ; idx++ ) {
//								//비율계산에 대한 '%' 기호추가
//								for(var i = 0; i < sheetObj.LastCol; i++) {
//									switch(sheetObj.ColSaveName(i)) {
//										case "mnth_01": case "mnth_02": case "mnth_03": case "frst_qurt_tot":
//										case "mnth_04": case "mnth_05": case "mnth_06": case "scnd_qurt_tot":
//										case "mnth_07": case "mnth_08": case "mnth_09": case "thrd_qurt_tot":
//										case "mnth_10": case "mnth_11": case "mnth_12": case "frth_qurt_tot":
//										case "yr_tot":
//											var vCommaValue = Number(sheetObj.CellValue(idx, i));
//											sheetObj.CellValue(idx, i) = ComGetMaskedValue(vCommaValue, "float");
//											//비율계산에 대한 '%' 기호추가
//											if ( sheetObj.CellValue(idx, "rslt_tp_seq") == "3" ) {
//												sheetObj.CellValue(idx, i) += "%";
//											}
//											break;
//										default : //do nothing
//									}
//								}
//
//							}
------------------------------------------------------------------------------------------------*/							
							sheetObj.CellValue(sheetObj.LastRow -2, "pln_yr") = "G.TTL";
							sheetObj.Redraw = true;
						} else {
							sheetObj.LoadSearchXml("<SHEET><DATA TOTAL='0'></DATA></SHEET>");
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
	    	ColBackColor("frst_qurt_tot") = LSE_TOTCOL_BACK_COLOR;
			ColBackColor("scnd_qurt_tot") = LSE_TOTCOL_BACK_COLOR;
			ColBackColor("thrd_qurt_tot") = LSE_TOTCOL_BACK_COLOR;
			ColBackColor("frth_qurt_tot") = LSE_TOTCOL_BACK_COLOR;
			ColBackColor("yr_tot") = LSE_TOTCOL_BACK_COLOR;

			for(var i = 0; i <= RowCount-3 ; i++) {
//				if(CellValue(i, "eq_knd_nm") == "G.TTL" || CellValue(i, "eq_term_nm") == "S.TTL" ) { 
				if(CellValue(i, "eq_term_nm") == "S.TTL" ) {
					RowBackColor(i) = LSE_TOTCOL_BACK_COLOR;
				}
			}

			//조회된 버젼 관리번호를 설정한다.
    		document.form.ver_seq.value = CellValue(1, "ver_seq");
			
    		if(SearchRows > 0) {
    			for(var i = LastRow -3; i > LastRow -6; i--) {
    				for(var j = 3; j < LastCol; j++) {
    					CellText(i +3, j) = CellText(i, j);  
    					if (j==3){
    						CellAlign(i +3, j) = daCenter;
    					}else{
    						CellAlign(i +3, j) = daRight;
    					}
    				}
    			}

				sheetObj.RowDelete(LastRow -5, false);
				sheetObj.RowDelete(LastRow -4, false);
				sheetObj.RowDelete(LastRow -3, false);
				sheetObj.SetMergeCell(LastRow -2, 0, 3, 3);
    		}
		}
    }

	/**
	 * combo2_OnBlur
	 */
	function combo1_OnBlur(comboObj, Index_Code, Text) {
		var formObj = document.form;
		formObj.expn_mon_cd.value = ComGetObjValue(comboObj);
	}

    /**
	 * combo2_OnBlur
	 */
	function combo2_OnBlur(comboObj, Index_Code, Text) {
		var formObj = document.form;
		formObj.eq_term_nm.value = ComGetObjValue(comboObj);
	}

	/**
	 * combo1_OnKeyDown
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
				formObj.expn_mon_cd.value = ComGetObjValue(comboObj);
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
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
				formObj.eq_term_nm.value = ComGetObjValue(comboObj);
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}
		}
	}

	/**
	 * MultiSelect속성을 이용하는 경우, 체크박스를 클릭하는 순간 발생한다.
	 * @return
	 * @deprecated 2009.07.21 IBCombo Single로 현재 사용되지 않는다.
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
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
	    	with(formObj){
	    		switch(sAction) {
	    			case IBSEARCH:      //조회
		    			if ( formObj.pln_yr.value == "" ) {
							ComShowCodeMessage("LSE01036");
							ComSetFocus(formObj.pln_yr);
							return false;
							break;
						}
	    				return ComChkValid(formObj, true);
	    				break;
	    		}
	    	}
		}

		return true;
	}

    /**
	 * Form Element Clear 처리부분.<br>
	 * @param fieldName
	 */
	function clearForm(fieldName)
	{
		var formObj = document.form;
		switch(fieldName) {
			case "pln_yr":
				formObj.ver_seq.value  = "";
				break;
		}
	}
	/* 개발자 작업  끝 */