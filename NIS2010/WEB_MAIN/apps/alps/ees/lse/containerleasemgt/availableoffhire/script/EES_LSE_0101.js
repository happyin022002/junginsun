/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0101.js
*@FileTitle : Available Yard Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.13
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.04.13 장준우
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
     * @author 장준우
     */

    /**
     * @extends
     * @class EES_LSE_0101 : EES_LSE_0101 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
	function EES_LSE_0101() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initControl            = initControl;
    	this.obj_change 			= obj_change;
    	this.obj_keypress           = obj_keypress;
    	this.obj_keydown			= obj_keydown;
    	this.obj_keyup				= obj_keyup;
    	this.obj_blur           	= obj_blur;
    	this.obj_focus				= obj_focus;
    	this.initSheet 				= initSheet;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    }

   	/* 개발자 작업	*/
	// 공통전역변수
	// Sheet Object Array
	var sheetObjects = new Array();
	var sheetCnt = 0;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){

		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1 = sheetObjects[0];
        /*******************************************************/
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
        			ComSetFocus(formObj.ofc_cd);
        			break;

        		case "btn_Retrieve":
        			doActionIBSheet(sheetObject1,formObj,IBSEARCH);
        			break;

        		case "btns_search":		//Office Code
	 				ComOpenPopupWithTarget('/hanjin/COM_ENS_071.do', 755, 635, "ofc_cd:ofc_cd", "1,0,1,1,1,1,1,1", true);
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
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {

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

		ComSetFocus(document.form.ofc_cd);
	 }

	//Axon 이벤트 처리1. 이벤트catch
	function initControl() {
		var formObj = document.form;
		axon_event.addListenerFormat('blur',		'obj_blur',		formObj); //- 포커스 나갈때
		axon_event.addListenerFormat('focus',		'obj_focus',	formObj); //- 포커스 들어갈때
		axon_event.addListenerFormat('keydown',		'obj_keydown',	formObj); //- 키 눌렸을때
		axon_event.addListenerFormat('keypress',	'obj_keypress',	formObj); //- 키보드 입력할때
		axon_event.addListenerFormat('keyup',		'obj_keyup',	formObj); //- 키 올라올때
		axon_event.addListenerFormat('change',   	'obj_change',  	formObj); //- 변경될때.
	}

	//Axon 이벤트 처리2. 이벤트처리함수 --- start
	/**
	 * Change Event 처리
	 */
	function obj_change() {
		var obj = event.srcElement;
		var formObj = document.form;

  		switch(obj.name) {
			case "ofc_cd":			//Office Code
  				if ( ComTrim(obj.value) != "" ) {
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC01);
  				}
				break;
		}
	}

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
	        	ComKeyOnlyAlphabet();
	            break;
	        case "engup":
	        	if(obj.name == "yd_cd") {
		        	ComKeyOnlyAlphabet('uppernum');
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

  		switch(obj.name) {
  			/*
  			case "yd_cd":
				if ( ComTrim(obj.value).length >= 2 ) {
  					ComKeyEnter('LengthNextFocus');
  				}
  				break;
  			*/
  			default :
			  	ComKeyEnter('LengthNextFocus');
			  	break;
  		}
  	}

	/**
	 * HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
	 **/
	function obj_blur(){
		var obj = event.srcElement;

	    switch(obj.name){
	    	case "ofc_cd" :
				ComChkObjValid(obj, true);
	    		break;
	        default:
	            //Validation 전체 체크(길이,format,최대,최소 등등)
	            ComChkObjValid(obj);
	            break;
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

  		if ( vKeyCode == 13 && obj.name != "ofc_cd" ) {
  			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
  			ComSetFocus(formObj.ofc_cd);
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
 					style.height = 242;

 					// 전체 너비 설정
 					SheetWidth = sheetTable.clientWidth;

 					//Host정보 설정[필수][HostIp, Port, PagePath]
 					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

 					//전체Merge 종류 [선택, Default msNone]
 					MergeSheet = msHeaderOnly;

 					//전체Edit 허용 여부 [선택, Default false]
 					Editable = true;

 					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 					InitRowInfo(1, 1, 15, 100);

 					var HeadTitle1 = " | |Seq|Yard\nType|Node Code|Node Name|CTRL\nOffice|Vendor\nCode|Vendor Name|Yard Address|Inter.\nPhone|Phone No.|Fax No.|PIC Name|Email ADDR|Created by|Date|Updated by|Date";

 					var headCount = ComCountHeadTitle(HeadTitle1);

 					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 					InitColumnInfo(headCount, 6, 0, true);

 					// 해더에서 처리할 수 있는 각종 기능을 설정한다
 					InitHeadMode(true, true, false, true, false,false)

 					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 					InitHeadRow(0, HeadTitle1, true);

 					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
                    InitDataProperty(0, cnt++ , dtRadioCheck,	30,		daCenter,	true,	"radio",			false,	"",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtSeq,			40,		daCenter,	true,	"seq_no",			false,	"",	dfNone,	0,	false,	false);

                    InitDataProperty(0, cnt++ , dtCombo,		45,		daCenter,	true,	"yard_type",		false,	"",	dfNone,	0,	false,	false);
 					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"yd_cd",			false,	"",	dfNone,	0,	false,	false);
 					InitDataProperty(0, cnt++ , dtData,			220,	daLeft,		true,	"yd_nm",			false,	"",	dfNone,	0,	false,	false);

					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"ofc_cd",			false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"vndr_seq",			false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			220,	daLeft,		true,	"vndr_lgl_eng_nm",	false,	"",	dfNone,	0,	false,	false);
 					InitDataProperty(0, cnt++ , dtData,			340,	daLeft,		true,	"yd_addr",			false,	"",	dfNone,	0,	false,	false);
 					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	"intl_phn_no",		false,	"",	dfNone,	0,	false,	false);
 					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,	"phn_no",			false,	"",	dfNone,	0,	false,	false);
 					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,	"fax_no",			false,	"",	dfNone,	0,	false,	false);
 					InitDataProperty(0, cnt++ , dtData,			130,	daLeft,		true,	"yd_pic_nm",		false,	"",	dfNone,	0,	false,	false);
 					InitDataProperty(0, cnt++ , dtData,			220,	daLeft,		true,	"yd_eml",			false,	"",	dfNone,	0,	false,	false);

 					InitDataProperty(0, cnt++ , dtData,		    80,		daCenter,	true,	"cre_usr_id",		false,	"",	dfNone,		0,	false,	false);
 					InitDataProperty(0, cnt++ , dtData,		    80,		daCenter,	true,	"cre_dt",			false,	"",	dfDateYmd,	0,	false,	false);
 					InitDataProperty(0, cnt++ , dtData,		    80,		daCenter,	true,	"upd_usr_id",		false,	"",	dfNone,		0,	false,	false);
 					InitDataProperty(0, cnt++ , dtData,		    80,		daCenter,	true,	"upd_dt",			false,	"",	dfDateYmd,	0,	false,	false);

 					CountFormat = "[SELECTDATAROW / TOTALROWS]";
 					InitDataCombo(0, "yard_type", "SML|LSE", "M|L");
 					//CountPosition = 0;
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
         	case IBSEARCH:      //조회
         		if(validateForm(sheetObj, formObj, sAction)) {
	         		if ( sheetObj.id == "sheet1") {
	         			formObj.f_cmd.value = SEARCH;
	         			sheetObj.DoSearch4Post("EES_LSE_0101GS.do",FormQueryString(formObj));
	         		}
         		}
         		break;

         	case IBSEARCH_ASYNC01:	// Office Code 에 대한 Validation 체크
				if(validateForm(sheetObj,formObj,sAction)) {
		        	var param = "f_cmd="+SEARCH16+"&ofc_cd="+ComGetObjValue(formObj.ofc_cd);
					sheetObj.WaitImageVisible = false;
					var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",param);
					sheetObj.WaitImageVisible = true;

					if ( sXml != "" ) {
						if ( ComGetEtcData(sXml, "ofc_cd") != undefined ) {
							if ( ComGetEtcData(sXml, "ofc_cd") != "" ) {
								formObj.ofc_cd.value = ComGetEtcData(sXml, "ofc_cd") ;
								ComSetNextFocus(formObj.ofc_cd);
							}else{
								ComShowCodeMessage("LSE01035");
								formObj.ofc_cd.value = "";
								ComSetFocus(formObj.ofc_cd);
							}
						} else {
							var errMsg = LseComGetErrMsg(sXml);
							if ( errMsg != "" ) {
								ComShowMessage(errMsg);
							}
							formObj.ofc_cd.value = "";
							ComSetFocus(formObj.ofc_cd);
						}
					}
				}

	        	break;
         }
	}

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction) {
		switch (sAction) {
			case IBSEARCH:
				with(formObj) {
					/*
					if ( ComTrim(yd_cd.value).length < 2) {
						ComShowCodeMessage("LSE01006");
		                return false;
		            }
		            */
		            return ComChkValid(formObj);
				}
	            break;

		}

		return true;
	}
	/* 개발자 작업  끝 */