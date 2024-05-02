/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1150.js
*@FileTitle : Shipper's Chassis Movement Management
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.30
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.08.30 장준우
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
     * @class EES_CGM_1150 : EES_CGM_1150 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_CGM_1150() {
    	this.processButtonClick		= tprocessButtonClick;
    }

   	/* 개발자 작업	*/

 	// 공통전역변수
 	var tabObjects = new Array();
 	var tabCnt = 0 ;
 	var beforetab = 1;

 	var sheetObjects = new Array();
 	var sheetCnt = 0;

 	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 	document.onclick = processButtonClick;

 	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
 		var sheetObj = sheetObjects[0];
        /*******************************************************/
        var formObj = document.form;

     	try {
     		var srcObj  = window.event.srcElement;
     		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
            	case "btn_retrieve":
					if(ComChkValid(formObj) == true) {
						doActionIBSheet(sheetObj,formObj,IBSEARCH);
					}
					break;
				case "btn_new":
					ComResetAll();
					ComSetFocus(formObj.p_chss_no);
					break;
            	case "btns_calendar":		// Activity Date
					if ( srcObj.style.filter == "" ) {
						var cal = new ComCalendar();
		                cal.select(formObj.p_mvmt_dt, "yyyy-MM-dd");
					}
					break;
				case "btn_delete":
					alert("개발중");
 					break;
 				case "btn_downexcel":
					sheetObj.SpeedDown2Excel(-1);
 					break;
				case "btns_search1":	//Form LOC 조회 팝업
					openPopup("1");
 					break;
				case "btns_search2": 	// Form Yard 조회 팝업
 					openPopup("2");
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
	}

	/**
	 * loadPage 메서드에서 초기 조회하는 메서드를 분리한다.
	 */
	function sheet1_OnLoadFinish(sheetObj) {
		var formObj = document.form;

		/* Axon Control Setting*/
    	initControl();

    	/* 초기 Focus Setting */
    	ComSetFocus(formObj.p_chss_no);
    }

	// Axon 이벤트 처리
  	// 1. 이벤트catch
  	function initControl() {
  		var formObj = document.form;
  		axon_event.addListenerFormat('blur',		'obj_blur',		formObj); //- 포커스 나갈때
		axon_event.addListenerForm	('focus',		'obj_focus',	formObj); //- 포커스 들어갈때
  		axon_event.addListenerFormat('keypress',	'obj_keypress',	formObj); //- 키 눌렸을때
		axon_event.addListenerFormat('keyup',		'obj_keyup',	formObj); //- 키 올라올때
		axon_event.addListenerForm	('keydown',		'obj_keydown',	formObj); //- 키 눌렸을때
		axon_event.addListenerForm	('change',   	'obj_change',  	formObj); //- 변경될때.
  	}

	// 2. 이벤트처리함수 -- Start
  	/**
  	 * HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
	 **/
	function obj_blur() {
		var obj = event.srcElement;
		var formObj = document.form;

	    switch(obj.name) {
	    	default:
	            /* Validation 전체 체크(길이,format,최대,최소 등등) */
	            ComChkObjValid(obj);
	        	break;
	    }
	}

	/**
	 * HTML Control의 포커스 들어가는 이벤트에서 마스크 구분자를 제거한다.
	 */
	function obj_focus() {
		var obj = event.srcElement;

	    if(obj.readOnly) {
			ComSetNextFocus(obj);
	    } else if (obj.value == "" ) {
			//ComSetFocus(obj);
	    } else {
	    	//마스크구분자 없애기
		    ComClearSeparator(obj);
	    }
	}

	/**
	 * Change Event 처리
	 */
	function obj_change() {
		var obj = event.srcElement;
		var formObj = document.form;

  		switch(obj.name) {
  			case "p_chss_no":	//Chss No
				if ( ComTrim(obj.value) != "" ) {
					//do nothing - 2010.09.17 현재 입력 Chassis에 대한 유효성 검증은 제외한다.(by 시스템설계자)
	        		//doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC03);
  				}
				break;
  			case "p_loc_cd":	//LOC Code
				if ( ComTrim(obj.value) != "" ) {
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC01);
  				}
				break;
			case "p_yd_cd":		//Yard Code
  				if ( ComTrim(obj.value) != "" ) {
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC02);
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
	        	if(obj.name == "p_yd_cd") {
					ComKeyOnlyAlphabet('uppernum');
	        	} else if(obj.name == "p_chss_no") {
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
  		var obj     = event.srcElement;
  		var formObj = document.form;

  		switch(obj.name) {
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

   		if(vKeyCode == 13) {
   			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
   		}
   	}
  	//2. 이벤트처리함수 -- End

   	/**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;

        switch(sheetNo) {
			case 1:      //sheet1 init
			with (sheetObj) {
				// 높이 설정
                style.height = 420;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 3, 1000);

                var HeadTitle = "||Seq|CHSS No|MVMT Date|Yard||I/O||Container 1||Container 2||";
                var headCount = ComCountHeadTitle(HeadTitle);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false, false);

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

             	//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
             	InitDataProperty(0, cnt++ , dtHiddenStatus, 40,	 daCenter,  false,   "ibflag");
             	InitDataProperty(0, cnt++ , dtCheckBox,     70,  daCenter,  false,   "del_chk",		false, "", dfNone,   	 0, true,  	false);
             	InitDataProperty(0, cnt++ , dtDataSeq,		70,	 daCenter,	true,	 "seq_no");

             	InitDataProperty(0, cnt++ , dtData,        	150, daCenter,  false,   "chss_no",   	false, "", dfNone,   	 0, false,  false, 	10);
             	InitDataProperty(0, cnt++ , dtData,    		200, daCenter,  false,   "mvmt_dt",    	false, "", dfUserFormat2,0, false,  false,	12);
             	InitDataProperty(0, cnt++ , dtData, 	  	100, daCenter,  false,   "yd_cd",     	false, "", dfNone,   	 0, false,  false, 	7);

             	InitDataProperty(0, cnt++ , dtHidden,    	100, daCenter,  false,   "loc_cd",    	false, "", dfNone,   	 0, false,  false);
             	InitDataProperty(0, cnt++ , dtData,   		100, daCenter,  false,   "gate_io_cd",  false, "", dfNone,   	 0, false,  false);
             	InitDataProperty(0, cnt++ , dtHidden,   	50,  daCenter,  false,   "sys_seq_01",  false, "", dfNone,		 0, false,  false);
             	InitDataProperty(0, cnt++ , dtData,   	    180, daCenter,  false,   "cntr_no_01",  false, "", dfNone, 	 	 0, false,	false, 	11);
             	InitDataProperty(0, cnt++ , dtHidden,       50,  daCenter,  false,   "sys_seq_02",	false, "", dfNone,   	 0, false,  false);
                InitDataProperty(0, cnt++ , dtData,  	    180, daCenter,  false,   "cntr_no_02",  false, "", dfNone,   	 0, false,	false, 	11);
                InitDataProperty(0, cnt++ , dtHidden,       50,  daCenter,  false,   "cnt_seq",		false, "", dfNone,   	 0, false,  false);
                InitDataProperty(0, cnt++ , dtHidden,       50,  daCenter,  false,   "lst_seq",		false, "", dfNone,   	 0, false,  false);

				ColHidden("del_chk") = true;
				InitUserFormat2(0, "mvmt_dt", "####-##-## ##:##", "-|:" );
				CountFormat = "[SELECTDATAROW / TOTALROWS]";
				ScrollBar = 2;
			}
			break;
		}
	}

   	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction, CondParam, PageNo) {
     	switch(sAction) {

			case IBSEARCH:      //조회
	 			if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet1") {
						formObj.f_cmd.value = SEARCH;
						sheetObj.WaitImageVisible = false;
						ComOpenWait(true);
						sheetObj.DoSearch("EES_CGM_1150GS.do",FormQueryString(formObj));
						ComOpenWait(false);
						sheetObj.WaitImageVisible = true;
					}
				}
 				break;
 			case IBSEARCH_ASYNC01:	// LOC 조회
 				if(validateForm(sheetObj,formObj,sAction)) {
 					if ( sheetObj.id == "sheet1") {
 						var param = "f_cmd="+SEARCH+"&loc_cd="+ComGetObjValue(formObj.p_loc_cd)
 								  + "&loc_nm=&un_loc_ind_cd=&cnt_cd=&loc_eq_ofc=&select=&rcc_cd=&lcc_cd=&loc_state=";
 						sheetObj.WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("COM_ENS_051GS.do", param);
						sheetObj.WaitImageVisible = true;

						if ( ComGetTotalRows(sXml) == 1 ) {
							ComSetNextFocus(formObj.p_loc_cd);
						} else {
							ComShowCodeMessage("CGM10012");
							formObj.p_loc_cd.value = "";
							ComSetFocus(formObj.p_loc_cd);
						}
					}
				}
 				break;
 			case IBSEARCH_ASYNC02:	// Yard 조회
 				if(validateForm(sheetObj,formObj,sAction)) {
 					if ( sheetObj.id == "sheet1") {
 						var param = "f_cmd="+SEARCH+"&node_cd="+ComGetObjValue(formObj.p_yd_cd)
 								  + "&mode=yard";
 						sheetObj.WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("COM_ENS_061GS.do",param);
						sheetObj.WaitImageVisible = true;

						if ( ComGetTotalRows(sXml) == 1 ) {
							ComSetNextFocus(formObj.p_yd_cd);
						} else {
							ComShowCodeMessage("CGM10012");
							formObj.p_yd_cd.value = "";
							ComSetFocus(formObj.p_yd_cd);
						}
					}
				}
 				break;
 			case IBSEARCH_ASYNC03:	// Chss No 조회
 				if(validateForm(sheetObj,formObj,sAction)) {
 					if ( sheetObj.id == "sheet1") {
 						var param = "f_cmd="+SEARCH+"&eq_no="+ComGetObjValue(formObj.p_chss_no)
 								  + "&eq_knd_cd=Z";
 						sheetObj.WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("CGM_CHS_MASTERGS.do",param);
						sheetObj.WaitImageVisible = true;

						if ( ComGetTotalRows(sXml) == 1 ) {
							ComSetNextFocus(formObj.p_chss_no);
						} else {
							ComShowCodeMessage('CGM10009','Chassis No');
							formObj.p_chss_no.value = "";
							ComSetFocus(formObj.p_chss_no);
						}
					}
				}
				break;
 			case IBSEARCHAPPEND:	//조회(페이징처리)
				formObj.f_cmd.value = SEARCH;
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				sheetObj.DoSearch4Post("EES_CGM_1150GS.do", CondParam, "iPage="+ PageNo, true);
				ComOpenWait(false);
				sheetObj.WaitImageVisible = true;
				break;
     	}
    }

	/**
	 * Sheet의 OnScrollNext Event 처리부분.<br>
	 * @param sheetObj
	 * @param CondParam
	 * @param PageNo
	 * @param OnePageRows
	 */
	function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
		doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, CondParam, PageNo);
	}

    /**
     * Pop-up Open 부분<br>
     * @param type 1:Lessor Code Popup for FORM, 2:Agreement No. Popup for FORM
     * @param Row 대상Object가 IBSheet일 경우 해당 Row index
     * @param Col 대상Object가 IBSheet일 경우 해당 Col index
     */
    function openPopup(type, Row, Col) {
    	var formObj = document.form;

    	if ( type == "1" ) {//LOC
			ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 755, 510,"loc_cd:p_loc_cd", "1,0,1,1,1,1,1", true);
    	} else if ( type == "2" ) {//Yard
    		ComOpenPopupWithTarget("/hanjin/COM_ENS_061.do", 805, 510,"yd_cd:p_yd_cd", "1,0,1,1,1,1,1,1", true);
    	}

    	return;
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj) {
    		switch(sAction) {
    			case IBSEARCH:      //조회
    				if(formObj.p_chss_no.value == "" && formObj.p_mvmt_dt.value == "" &&
    				   formObj.p_loc_cd.value == "" && formObj.p_yd_cd.value == "") {
    					ComShowCodeMessage("CGM10004", "Chss No.");
    					ComSetFocus(formObj.p_chss_no);
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

	/* 개발자 작업  끝 */