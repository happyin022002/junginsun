/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_lse_0091.js
*@FileTitle : Agreement No. Selection
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.04.27 노정용
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
     * @author 노정용
     */

    /**
     * @extends
     * @class ees_lse_0091 : ees_lse_0091 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
	function ees_lse_0091() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.setComboObject			= setComboObject;
    	this.loadPage 				= loadPage;
    	this.initControl            = initControl;
    	this.obj_keypress           = obj_keypress;
    	this.obj_blur           	= obj_blur;
    	this.obj_focus				= obj_focus;
    	this.initSheet 				= initSheet;
    	this.initCombo 				= initCombo;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.sheet1_OnScrollNext	= sheet1_OnScrollNext;
    	this.combo1_OnChange		= combo1_OnChange;
    	this.openPopup				= openPopup;
    	this.validateForm 			= validateForm;
    }

   	/* 개발자 작업	*/
	// 공통전역변수
	// Sheet Object Array
	var sheetObjects = new Array();
	var sheetCnt = 0;

	// Combo Object Array
	var comboObjects = new Array();
	var comboCnt = 0;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){

		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1 = sheetObjects[0];
        /*******************************************************/
        var comboObject1 = comboObjects[0];
        var formObj = document.form;

        try {
        	var srcName = window.event.srcElement.getAttribute("name");

        	switch(srcName) {

        		case "btn_OK":
        			comPopupOK();
        			break;

        		case "btn_Close":
        			window.close();
        			break;

        		case "btn_New":
        			ComResetAll();
        			comboObjects[0].Text = "ALL";  // Initial Setting
        			break;

        		case "btn_Office":
        			openPopup("1");
        			break;

        		case "btn_Retrieve":
        			doActionIBSheet(sheetObject1,formObj,IBSEARCH);
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

		ComSetFocus(document.form.agmt_seq);
	 }

	//Axon 이벤트 처리1. 이벤트catch
	function initControl() {
		var formObj = document.form;
		axon_event.addListenerFormat('blur',		'obj_blur',		formObj); //- 포커스 나갈때
		axon_event.addListenerFormat('focus',		'obj_focus',	formObj); //- 포커스 들어갈때
		axon_event.addListenerFormat('keypress',	'obj_keypress',	formObj); //- 키보드 입력할때
		axon_event.addListenerForm('keydown',		'obj_keydown',	formObj); //- 키 눌렸을때
	}

	//Axon 이벤트 처리2. 이벤트처리함수 --- start
	/**
	 * 키보드가 눌릴 때
	 **/
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
	        	if ( obj.name == "ref_no" ) {
	        		ComKeyOnlyAlphabet('num');
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
	 * HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
	 **/
	function obj_blur(){
	    switch(event.srcElement.name){
	        case "agmt_seq":
	            //숫자이면서 천단위 구분을 하지 않는다.
	            ComChkObjValid(event.srcElement, true, false, false);
	            break;

	        default:
	            //Validation 전체 체크(길이,format,최대,최소 등등)
	            ComChkObjValid(event.srcElement);
	    }
	}

	/**
	 * HTML Control의 포커스 들어가는 이벤트에서 마스크 구분자를 제거한다.
	 **/
	function obj_focus(){
	    //마스크구분자 없애기
	    ComClearSeparator(event.srcElement);
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
  			formObj.agmt_seq.focus();
  		}
	}
	//Axon 이벤트 처리2. 이벤트처리함수 --- End

	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
 		var sheetID = sheetObj.id;

 		switch(sheetID) {

 			case "sheet1":
 				with (sheetObj) {
 					// 높이 설정
 					style.height = 202;

 					// 전체 너비 설정
 					SheetWidth = sheetTable.clientWidth;

 					//Host정보 설정[필수][HostIp, Port, PagePath]
 					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

 					//전체Merge 종류 [선택, Default msNone]
 					MergeSheet = msHeaderOnly;

 					//전체Edit 허용 여부 [선택, Default false]
 					Editable = true;

 					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 					InitRowInfo(2, 1, 10, 100);

 					var HeadTitle1 = " | |AGMT NO.|||Ref. No.|Term|Lessor|Lessor Name|Effective Date|Effective Date||||Contract No.|Created by|Date|Updated by|Date";
 					var HeadTitle2 = " | |AGMT NO.|||Ref. No.|Term|Lessor|Lessor Name|From|To||||Contract No.|Created by|Date|Updated by|Date";

 					var headCount = ComCountHeadTitle(HeadTitle1);

 					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 					InitColumnInfo(headCount, 0, 0, true);

 					// 해더에서 처리할 수 있는 각종 기능을 설정한다
 					InitHeadMode(true, true, false, true, false,false)

 					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 					InitHeadRow(0, HeadTitle1, true);
 					InitHeadRow(1, HeadTitle2, true);

 					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
                    InitDataProperty(0, cnt++ , dtRadioCheck,	20,		daCenter,	true,	"radio",			false,	"",	dfNone,	0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	"agmt_no",			false,	"",	dfNone,	0,	false,	false);
 					InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	true,	"agmt_cty_cd",		false,	"",	dfNone,	0,	false,	false);
 					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,	"agmt_seq",			false,	"",	dfNone,	0,	false,	false);

 					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,	"ref_no",			false,	"",	dfNone,	0,	false,	false);
 					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	"lstm_cd",			false,	"",	dfNone,	0,	false,	false);
 					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"vndr_seq",			false,	"",	dfNone,	0,	false,	false);
 					InitDataProperty(0, cnt++ , dtData,			180,	daLeft,		true,	"vndr_lgl_eng_nm",	false,	"",	dfNone,	0,	false,	false);
 					InitDataProperty(0, cnt++ , dtData,			75,		daCenter,	true,	"eff_dt",			false,	"",	dfNone,	0,	false,	false);

 					InitDataProperty(0, cnt++ , dtData,			75,		daCenter,	true,	"exp_dt",			false,	"",	dfNone,	0,	false,	false);
 					InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	"lse_free_dys",		false,	"",	dfNone,	0,	false,	false);
 					InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	"ofc_cd",			false,	"",	dfNone,	0,	false,	false);
 					InitDataProperty(0, cnt++ , dtHidden,		80,		daLeft,		true,	"vndr_abbr_nm",		false,	"",	dfNone,	0,	false,	false);
 					InitDataProperty(0, cnt++ , dtData,		    80,		daLeft,		true,	"lse_ctrt_no",		false,	"",	dfNone,	0,	false,	false);

 					InitDataProperty(0, cnt++ , dtData,		    80,		daCenter,	true,	"cre_usr_id",		false,	"",	dfNone,	0,	false,	false);
 					InitDataProperty(0, cnt++ , dtData,		    80,		daCenter,	true,	"cre_dt",			false,	"",	dfNone,	0,	false,	false);
 					InitDataProperty(0, cnt++ , dtData,		    80,		daCenter,	true,	"upd_usr_id",		false,	"",	dfNone,	0,	false,	false);
 					InitDataProperty(0, cnt++ , dtData,		    80,		daCenter,	true,	"upd_dt",			false,	"",	dfNone,	0,	false,	false);

 					CountFormat = "[SELECTDATAROW / TOTALROWS]";
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
	            	//BackColor = "cyan";
	            	DropHeight = 250;
	            	MultiSelect = false;
	            	//MaxSelect = 1;
	            	UseAutoComplete = true;
	            	ValidChar(2,0);
	            }

	        	break;
	    }
	}

	/**
	 * Sheet관련 프로세스 처리
	 */
	function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
		sheetObj.ShowDebugMsg = false;

         switch(sAction) {
	         case IBCREATE:		//Lease Term Form Combo Item Setting
	         	sheetObj.WaitImageVisible = false;

	         	formObj.f_cmd.value = SEARCH01;
	         	var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", FormQueryString(formObj));

	            if ( sXml != "" ) {
	            	// "ALL" Item Insert
		            comboObjects[0].InsertItem(0,"ALL"," ");
		            LseComXml2ComboItem(sXml, comboObjects[0], "lease_term_nm", "lease_term_cd", "|");
		            comboObjects[0].Text = "ALL";  // Initial Setting
	            }
		        sheetObj.WaitImageVisible = true;
	            break;

         	case IBSEARCH:      //조회
         		if ( sheetObj.id == "sheet1") {
         			formObj.f_cmd.value = SEARCH;
         			sheetObj.WaitImageVisible = false;
         			ComOpenWait(true);
         			sheetObj.DoSearch4Post("EES_LSE_0091GS.do",FormQueryString(formObj));
         			ComOpenWait(false);
         		}
         		break;

            case IBSEARCHAPPEND:
         		if ( sheetObj.id == "sheet1") {
	            	formObj.f_cmd.value = SEARCH;
	                sheetObj.DoSearch4Post("EES_LSE_0091GS.do", CondParam, "iPage=" + PageNo, true);
         		}
                break;
         }
	}

	function sheet1_OnLoadFinish(sheetObj) {
		var formObj = document.form;
		var vActFlg = formObj.h_agmt_act_flg.value;
		ComSetObjValue(formObj.agmt_act_flg, vActFlg);

		/* IBMulti Combo Item Setting */
		doActionIBSheet(sheetObj, formObj, IBCREATE);
	}

	/**
	 * sheet1_OnScrollNext
	 */
	function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
		doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, CondParam, PageNo);
	}

	/**
	 * combo1_OnChange
	 */
	function combo1_OnChange(comboObj, Index_Code, Text) {
		var formObj = document.form;
		formObj.lstm_cd.value = comboObj.Code;
	}

    /**
     * Pop-up Open 부분<br>
     * @param type 1:Agreement No. Selection for FORM, 2:Agreement No. Selection for GRID, 3:Location for GRID, 4:Service Provider for FORM
     * @param object 대상 Object
     * @param Row 대상Object가 IBSheet일 경우 해당 Row index
     */
    function openPopup(type, Row, Col) {
    	if ( type == "1" ) {
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
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction) {
/*
		switch (sAction) {
			case IBSEARCH:
				with(formObj) {
					if ( ComTrim(agmt_seq.value) == "" || ComTrim(lstm_cd.value) == "" ) {
						alert("Agreememt No를 입력해주세요");
						ComShowCodeMessage("LSE01006");
		                return false;
		            }
				}
	            break;

		}
*/
		return true;
	}
	/* 개발자 작업  끝 */