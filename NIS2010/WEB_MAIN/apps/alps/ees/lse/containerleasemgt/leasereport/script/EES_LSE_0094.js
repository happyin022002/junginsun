/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_LSE_0094.js
 *@FileTitle : Sub Lease Out Container Summary
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.28
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.07.28 장준우
 * 1.0 Creation
 * ======================================================
 * 2010.12.01 박명신 [CHM-201007443-01] REF_NO 항목 추가
 * 2011.01.27 남궁진호 [CHM-201108164-01] 공통 팝업 (COM_ENS_051, COM_ENS_0C1) Open Size 조정
 * 2011.03.16 남궁진호 [CHM-201109488-01] S.TTL와 G.TTL의 Detail 조회시 Vender 코드가 조건으로 넘어가지않는 오류 수정
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
	 * @class EES_LSE_0094 : EES_LSE_0094 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_LSE_0094() {
		this.processButtonClick	= processButtonClick;
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
		this.sheet1_OnMouseMove = sheet1_OnMouseMove;
		this.sheet1_OnDblClick 	= sheet1_OnDblClick;
		this.sheet1_OnSearchEnd = sheet1_OnSearchEnd;
		this.combo1_OnCheckClick = combo1_OnCheckClick;
		this.combo2_OnCheckClick = combo2_OnCheckClick;
		this.combo1_OnBlur 		= combo1_OnBlur;
		this.combo2_OnBlur 		= combo2_OnBlur;
		this.combo1_OnKeyDown 	= combo1_OnKeyDown;
		this.combo2_OnKeyDown 	= combo2_OnKeyDown;
		this.openPopup 			= openPopup;
		this.setPopData_Agreement = setPopData_Agreement;
		this.setPopData_Country = setPopData_Country;
		this.setPopData_Lessor 	= setPopData_Lessor;
		this.validateForm 		= validateForm;
		this.checkDurationDate 	= checkDurationDate;
		this.clearForm 			= clearForm;
	}


	/* 개발자 작업	*/

	// 공통전역변수

	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;

	var sheetObjects = new Array();
	var sheetCnt = 0;

	// Combo Object Array
	var comboObjects = new Array();
	var comboCnt = 0;

	var vCntrTpszHdr = "| | | | | | | | | | | | | | | | | | | | | | | | | | | | | |";
	var vArrCntrTpsz = vCntrTpszHdr.split("|");
	var vCntrTpszCnt = vArrCntrTpsz.length;

	var vOrcLstmCd = "";
   	var vOrcCntrTpszCd = "";

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject1 = sheetObjects[0];
		 var sheetObject2 = sheetObjects[1];

         /*******************************************************/
         var formObj = document.form;

    	try {
    		var srcObj  = window.event.srcElement;
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
            	case "total_flg" :
            		sheetObject1.ColHidden("loc_cd") = srcObj.checked;
            		break;
            	case "lst_sts_flg" :
	  				if ( ComGetObjValue(srcObj) == "02" ) {
	  					formObj.str_evnt_dt.className = "input1";
	  					formObj.end_evnt_dt.className = "input1";
	  				} else {
	  					formObj.str_evnt_dt.className = "input";
	  					formObj.end_evnt_dt.className = "input";
	  				}
  					break;

				case "btn_Retrieve":
					dcondTD.innerHTML = "&nbsp;"
					sheetObject2.RemoveAll();
					doActionIBSheet(sheetObject1, formObj, IBSEARCH);
 					break;

				case "btn_New":
					dcondTD.innerHTML = "&nbsp;"
					ComResetAll();
					sheetObject1.SheetWidth = 984;
					for( var i = 1; i < vCntrTpszCnt; i++ ) {
						if(vArrCntrTpsz[i] != "") {
							eval('sheetObject1.ColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '") = false;');
						} else {
							eval('sheetObject1.ColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '") = true;');
						}
					}

					formObj.loc_cd.readOnly = true;
					formObj.loc_cd.className = "input2";
					formObj.str_evnt_dt.className = "input";
	  				formObj.end_evnt_dt.className = "input";
					ComEnableObject(formObj.btns_search, false);
					sheetObjects[0].CellText(0, "loc_cd") = "RCC";
					sheetObjects[0].ColHidden("loc_cd") = false;
					ComSetFocus(formObj.lst_sts_flg[0]);
					break;

				case "btn_DownExcel":
					//sheetObject1.SpeedDown2Excel(-1);
					sheetObject1.Down2Excel(-1, false, false, true);
					break;

				case "btn_DownExcel2":
					sheetObject2.SpeedDown2Excel(-1);
					break;

				case "btns_search":	//Form Location. 조회 팝업
 					openPopup("1");
 					break;

				case "btns_search2": // Form Agreement Search
					openPopup("2");
					break;

				case "btns_search3": // Form Lessor Search
					openPopup("3");
					break;

				case "btns_calendar":	// Event Duration (FromTo)
					if ( srcObj.style.filter == "" ) {
						var cal = new ComCalendarFromTo();
						cal.select(formObj.str_evnt_dt, formObj.end_evnt_dt, 'yyyy-MM-dd');
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
		ComEnableObject(formObj.btns_search, false);
		ComSetFocus(formObj.lst_sts_flg[0]);
		sheetObjects[0].CellText(0, "loc_cd") = "RCC";
    }

    /**
	 * loadPage 메서드에서 초기 조회하는 메서드를 분리한다.
	 */
	function sheet2_OnLoadFinish(sheetObj) {
		var formObj = document.form;

		/* Container Type Size Dynamic Header Setting */
		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC05);

		/* IBSheet 재설정 */
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet (sheetObjects[0] );
		initSheet(sheetObjects[0],1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[0]);
		sheetObjects[0].ScrollBar = 3;
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
			case "loc_tp":		//Location Type
				formObj.loc_cd.value = "";
				if(obj.value == "0" || obj.value == "1") {
					formObj.loc_cd.readOnly = true;
					formObj.loc_cd.className = "input2";
					ComEnableObject(formObj.btns_search, false);
					sheetObj.CellText(0, "loc_cd") = obj.value == "0" ? "RCC" : "Country";
				} else {
					formObj.loc_cd.readOnly = false;
					formObj.loc_cd.className = "input";
					ComEnableObject(formObj.btns_search, true);
					formObj.loc_cd.maxLength = obj.value == "5" ? 2 : 5;
					ComSetNextFocus(obj);
					if(obj.value == "2") {
						sheetObj.CellText(0, "loc_cd") = "LCC";
					} else if(obj.value == "3") {
						sheetObj.CellText(0, "loc_cd") = "SCC";
					} else if(obj.value == "4") {
						sheetObj.CellText(0, "loc_cd") = "Yard";
					} else {//obj.value is '5'
						sheetObj.CellText(0, "loc_cd") = "Country";
					}
				}

				break;
			case "loc_cd":		//Location Code
  				if ( ComTrim(obj.value) != "" ) {
  					if(obj.maxLength == 5) {
	        			doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC01);
  					} else {
  						doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC02);
  					}
  				}
				break;

  			case "str_evnt_dt":
    		case "end_evnt_dt":
    			checkDurationDate(obj);
	    		break;

  			case "agmt_seq":	//Agreement No.
  				if ( ComTrim(obj.value) != "" ) {
					doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC03);
				}
				break;

			case "vndr_seq":	//Lessor Code
  				if ( ComTrim(obj.value) != "" ) {
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC04);
  				}
  				break;
			case "use_day":
				if (ComTrim(obj.value) == "1") {
					formObj.onh_free_dys.value = "" ;
					formObj.onh_free_dys.readOnly = true;
					formObj.onh_free_dys.className = "input2";
				}
				if (ComTrim(obj.value) == "2") { 
					formObj.onh_free_dys.readOnly = false;
					formObj.onh_free_dys.className = "input";
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
	        	if(obj.name == "loc_cd") {
		            ComKeyOnlyAlphabet('uppernum');
	        	}else{
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
				case "vndr_seq":
	  			case "agmt_seq":
	  				if ( ComTrim(obj.value) == "" ) {
						doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
					}
					break;

				default :
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
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
                    //style.height = 280;
                    //전체 너비 설정
                    //SheetWidth = mainTable.clientWidth;
                    SheetWidth = 984;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 10, 100);

					var HeadTitle = "RCC|Lease Term|Lessee||Total"+ vCntrTpszHdr;
					var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 5, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,   		80,  	daCenter,	true,	"loc_cd",			false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtHidden,  		80,  	daCenter,	true,	"lstm_cd",			false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,  		80,  	daCenter,	true,	"vndr_abbr_nm",		false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtHidden,		60,  	daCenter,	false,	"vndr_seq",			false,	"",		dfNone);
					InitDataProperty(0, cnt++ , dtAutoSum,	 	60,  	daRight,	false,	"tpsz_total",		false,	"",		dfInteger);

					for(var i = 1; i < vCntrTpszCnt; i++) {
						var tpsz_dp_no = "tpsz_dp"+ ComLpad(i, 2, "0");
                    	InitDataProperty(0, cnt++ , dtAutoSum,	50,  	daRight,	false,	tpsz_dp_no,			false,	"",		dfInteger);

                    	if(vArrCntrTpsz[i] != "") {
							eval('sheetObj.ColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '") = false;');
						} else {
							eval('sheetObj.ColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '") = true;');
						}
					}

					CountFormat = "[SELECTDATAROW / TOTALROWS]";
					//AutoSumBottom = true;
					//FitColWidth();
					ScrollBar = 0;

				}
				break;

            case "sheet2":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 220;
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

					var HeadTitle = "Seq.|CNTR No.|TP/SZ|Term|AGMT No.|Ref No.|Out Yard|Out Date|In Yard|In Date|AGMT No.|Ref No.|Lessee|Lessee Name|F/Days|T/Using Days|PDM|LON|LOF|DOC|G.TTL";
					var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 3, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtDataSeq,		40,		daCenter,	true,	"seq_no");
                    InitDataProperty(0, cnt++ , dtData,   		80,  	daCenter,	true,	"cntr_no",			false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,   		40,  	daCenter,	true,	"cntr_tpsz_cd",		false,	"",		dfNone);

                    InitDataProperty(0, cnt++ , dtData,   		40,  	daCenter,	true,	"lstm_cd",			false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,   		70,  	daCenter,	true,	"lsi_agmt_no",		false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,   		100,  	daLeft,		true,	"lsi_ref_no",		false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,   		60,  	daCenter,	true,	"yd_cd",			false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,   		70,  	daCenter,	true,	"cntr_sts_evnt_dt",	false,	"",		dfDateYmd);
                    InitDataProperty(0, cnt++ , dtData,   		60,  	daCenter,	true,	"rtn_yd_cd",		false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,   		70,  	daCenter,	true,	"cntr_rtn_evnt_dt",	false,	"",		dfDateYmd);
                    InitDataProperty(0, cnt++ , dtData,   		70,  	daCenter,	true,	"agmt_no",			false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,   		100,  	daLeft,		true,	"ref_no",			false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,   		80,  	daCenter,	true,	"vndr_seq",			false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,   		100,  	daLeft,		true,	"vndr_abbr_nm",		false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,   		60,  	daRight,	true,	"rntl_chg_free_dys",false,	"",		dfInteger);
                    InitDataProperty(0, cnt++ , dtData,   		80,  	daRight,	true,	"ttl_use_dys",		false,	"",		dfInteger);

                    InitDataProperty(0, cnt++ , dtData,   		65,  	daRight,	true,	"pdm_amt",			false,	"",		dfFloat,	"2");
					InitDataProperty(0, cnt++ , dtData,   		65,  	daRight,	true,	"lon_amt",			false,	"",		dfFloat,	"2");
					InitDataProperty(0, cnt++ , dtData,   		65,  	daRight,	true,	"lof_amt",			false,	"",		dfFloat,	"2");
					InitDataProperty(0, cnt++ , dtData,   		65,  	daRight,	true,	"doc_amt",			false,	"",		dfFloat,	"2");
					InitDataProperty(0, cnt++ , dtData,   		70,  	daRight,	true,	"ttl_amt",			false,	"",		dfFloat,	"2");

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
	    }
	}

  	/**
	 * Sheet관련 프로세스 처리
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @param CondParam
	 * @param PageNo
	 */
    function doActionIBSheet(sheetObj,formObj,sAction, CondParam, PageNo) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			case IBCREATE:
	        	sheetObj.WaitImageVisible = false;

	        	//Lease Term Combo Item Setting
				formObj.f_cmd.value = SEARCH01;
				var sXml_1 = sheetObj.GetSearchXml("EES_LSE_COMGS.do",FormQueryString(formObj));

				//Container Type/Size Combo Item Setting Start
				formObj.f_cmd.value = SEARCH02;
				var sXml_2 = sheetObj.GetSearchXml("EES_LSE_COMGS.do", FormQueryString(formObj));

		        sheetObj.WaitImageVisible = true;

				if(sXml_1 != "") {
					comboObjects[0].InsertItem(0 , 'ALL','');
					LseComXml2ComboItem(sXml_1, comboObjects[0], "lease_term_nm", "lease_term_cd", "|");
					vOrcLstmCd = ComGetEtcData(sXml_1, "lease_term_cd");
				}
	            if ( sXml_2 != "" ) {
	            	comboObjects[1].InsertItem(0 , 'ALL','');
	            	LseComXml2ComboItem(sXml_2, comboObjects[1], "cntr_tpsz_nm", "cntr_tpsz_cd", "|");
	            	vOrcCntrTpszCd = ComGetEtcData(sXml_2, "cntr_tpsz_cd");
	            }

	            break;

           case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
					if ( sheetObj.id == "sheet1") {
						formObj.f_cmd.value = SEARCH;
						formObj.lstm_cd.value = ComGetObjValue(comboObjects[0]);
						formObj.cntr_tpsz_cd.value = ComGetObjValue(comboObjects[1]);

						sheetObj.WaitImageVisible = false;
	         			ComOpenWait(true);
	         			formObj.onh_free_dys.value = formObj.onh_free_dys.value.replace(",","");
						var sXml = sheetObj.GetSearchXml("EES_LSE_0094GS.do", FormQueryString(formObj));
						if ( sXml != "" ) {
							var comboVal = ComGetObjValue(comboObjects[1]);

							if ( comboVal != "" ) {
								for ( var i = 1 ; i < vCntrTpszCnt ; i++ ) {
									eval('sheetObj.ColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '") = true;');
								}

								var arrComboVal = comboVal.split(",");

								for ( var i = 0 ; i < arrComboVal.length ; i++ ) {
									for( var j = 1; j < vCntrTpszCnt; j++ ) {
										if(arrComboVal[i] == vArrCntrTpsz[j]) {
											eval('sheetObj.ColHidden("tpsz_dp'+ ComLpad(j, 2, "0") + '") = false;');
											break;
										}
									}
								}
							} else {
								for( var i = 1; i < vCntrTpszCnt; i++ ) {
									if(vArrCntrTpsz[i] != "") {
										eval('sheetObj.ColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '") = false;');
									} else {
										eval('sheetObj.ColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '") = true;');
									}
								}
							}

							sheetObj.Redraw = false;
							sheetObj.LoadSearchXml(sXml);
							sheetObj.Redraw = true;

							ComOpenWait(false);
						}
					}
				}
				break;

			case IBSEARCH_ASYNC01:	// Location 조회
 				if(validateForm(sheetObj,formObj,sAction)) {
 					if ( sheetObj.id == "sheet1") {
 						var vLocTp = formObj.loc_tp.value == "2" ? "RCC" :
 									 formObj.loc_tp.value == "3" ? "LCC" : "SCC";
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
									ComSetFocus(formObj.loc_cd);
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

 			case IBSEARCH_ASYNC02:	// Country 조회
				if(validateForm(sheetObj,formObj,sAction)) {
					if ( sheetObj.id == "sheet1") {
						var param = "f_cmd="+SEARCH10+"&loc_cd="+ComGetObjValue(formObj.loc_cd);
						sheetObj.WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",param);
						sheetObj.WaitImageVisible = true;
						if ( sXml != "" ) {
							if ( ComGetEtcData(sXml, "loc_cd") != undefined ) {
								if ( ComGetEtcData(sXml, "loc_cd") != "" ) {
									formObj.loc_cd.value = ComGetEtcData(sXml, "loc_cd") ;
								}else{
									ComShowCodeMessage("LSE01048");
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

 			case IBSEARCH_ASYNC03:	//조회(Form Agreement No. 입력시)
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
								ComSetObjValue(formObj.ref_no,   ComGetEtcData(sXml, "ref_no"));
								ComSetObjValue(formObj.vndr_seq, ComGetEtcData(sXml, "vndr_seq"));
								ComSetFocus(formObj.ref_no);
								doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC04);
							} else {
	 							ComShowCodeMessage("LSE01007");
	 							clearForm("agmt_seq");
	 						}
						} else {
							var errMsg = LseComGetErrMsg(sXml);
							if ( errMsg != "" ) {
								ComShowMessage(errMsg);
							}
							clearForm("agmt_seq");;
						}
 					}
				}
				break;

			case IBSEARCH_ASYNC04:	//조회(Form Lessor No. 입력시)
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
						clearForm("vndr_seq");;
					}
				}
				break;

			case IBSEARCH_ASYNC05:	//Container Type Size Dynamic Header Setting
				sheetObj.WaitImageVisible = false;
				formObj.f_cmd.value = SEARCH12;
				var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", FormQueryString(formObj));
				sheetObj.WaitImageVisible = true;

				if(sXml != "") {
					if ( ComGetEtcData(sXml, "cntr_tpsz_hd") != undefined ) {
						if ( ComGetEtcData(sXml, "cntr_tpsz_hd") != "" ) {
							vCntrTpszHdr = ComGetEtcData(sXml, "cntr_tpsz_hd");
							vArrCntrTpsz = vCntrTpszHdr.split("|");
							vCntrTpszCnt = vArrCntrTpsz.length;
						}
					}
				}
				break;

			case IBSEARCHAPPEND:	//조회(페이징처리)
				if(sheetObj.id == "sheet2") {
					formObj.f_cmd.value = SEARCH01;
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					sheetObj.DoSearch4Post("EES_LSE_0094GS.do", CondParam, "iPage="+ PageNo, true);
					ComOpenWait(false);
				}
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
	function sheet2_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
		doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, CondParam, PageNo);
	}

	/**
	 * sheet1_OnMouseMove :: 마우스가 Sheet 위에서 움직일 때 발생하는 Event
	 */
	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
		with(sheetObj) {
			var isFlag = CellValue(MouseRow, "lstm_cd")  != "Total"
					  && CellValue(MouseRow, "vndr_abbr_nm") != "S.TTL";
			isFlag = true;
			DataLinkMouse("loc_cd") = isFlag;
			DataLinkMouse("lstm_cd") = isFlag;
			DataLinkMouse("vndr_abbr_nm") = isFlag;
			DataLinkMouse("tpsz_total") = isFlag;

			for(var i = 1; i < vCntrTpszCnt; i++) {
				var tpsz_dp_no = "tpsz_dp"+ ComLpad(i, 2, "0");
            	DataLinkMouse(tpsz_dp_no) = isFlag;
			}
		}
	}

	/**
	 * sheet1_OnDblClick
	 */
	function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
		var formObj = document.form;
		var sName  = sheetObj.ColSaveName(Col);
		var sLocCd = sheetObj.CellValue(Row,"loc_cd");
		var sLstmCd = sheetObj.CellValue(Row,"lstm_cd");
		var param  = "";
		var tmpVndrSeq = ComGetObjValue(formObj.vndr_seq);
		if (tmpVndrSeq == null || tmpVndrSeq==""){
			tmpVndrSeq= sheetObj.CellValue(Row,"vndr_seq");
		}
		switch (sName) {
			case "tpsz_dp01": case "tpsz_dp02": case "tpsz_dp03":
			case "tpsz_dp04": case "tpsz_dp05": case "tpsz_dp06":
			case "tpsz_dp07": case "tpsz_dp08": case "tpsz_dp09":
			case "tpsz_dp10": case "tpsz_dp11": case "tpsz_dp12":
			case "tpsz_dp13": case "tpsz_dp14": case "tpsz_dp15":
			case "tpsz_dp16": case "tpsz_dp17": case "tpsz_dp18":
			case "tpsz_dp19": case "tpsz_dp20": case "tpsz_dp21":
			case "tpsz_dp22": case "tpsz_dp23": case "tpsz_dp24":
			case "tpsz_dp25": case "tpsz_dp26": case "tpsz_dp27":
			case "tpsz_dp28": case "tpsz_dp29": case "tpsz_dp30":
				param = "&cntr_tpsz_cd=" + sheetObj.CellText(0, Col)
					  + "&vndr_seq=" + tmpVndrSeq
			        //  + "&lstm_cd=" + (sLstmCd == "Total" ? "" : sheetObj.CellValue(Row,"lstm_cd"))
			          + "&lstm_cd=" + ComGetObjValue(formObj.hcond_lstm_cd)
			          + "&loc_cd=" + (sLocCd == "G.Total" ? ComGetObjValue(formObj.hcond_loc_cd) : sheetObj.CellValue(Row,"loc_cd"));

				if(sheetObj.MousePointer == "Hand") {
					dcondTD.innerHTML = sheetObj.CellText(0, "loc_cd") +" : "+ sheetObj.CellValue(Row,"loc_cd")
						   + ",&nbsp;&nbsp;Lease Term : "+ ComGetObjValue(formObj.hcond_lstm_cd)
						//   + ",&nbsp;&nbsp;Lease Term : "+ sheetObj.CellValue(Row,"lstm_cd")
						   + ",&nbsp;&nbsp;Lessee : "+ sheetObj.CellValue(Row,"vndr_abbr_nm")
						   + ",&nbsp;&nbsp;TP/SZ : "+ sheetObj.CellText(0, Col);
				}
				break;

			case "tpsz_total":
			case "vndr_abbr_nm":
				param = "&cntr_tpsz_cd=" + ComGetObjValue(formObj.hcond_tpsz_cd)
					  + "&vndr_seq=" + tmpVndrSeq
			          //+ "&lstm_cd=" + (sLstmCd == "Total" ? "" : sheetObj.CellValue(Row,"lstm_cd"))
			          + "&lstm_cd=" + ComGetObjValue(formObj.hcond_lstm_cd)
			          + "&loc_cd=" + (sLocCd == "G.Total" ? ComGetObjValue(formObj.hcond_loc_cd) : sheetObj.CellValue(Row,"loc_cd"));

			    if(sheetObj.MousePointer == "Hand") {
					dcondTD.innerHTML = sheetObj.CellText(0, "loc_cd") +" : "+ sheetObj.CellValue(Row,"loc_cd")
						//   + ",&nbsp;&nbsp;Lease Term : "+ sheetObj.CellValue(Row,"lstm_cd")
						   + ",&nbsp;&nbsp;Lease Term : "+ ComGetObjValue(formObj.hcond_lstm_cd)
						   + ",&nbsp;&nbsp;Lessee : "+ sheetObj.CellValue(Row,"vndr_abbr_nm");
				}
				break;

			/*case "lstm_cd":
				param = "&cntr_tpsz_cd=" + ComGetObjValue(formObj.hcond_tpsz_cd)
					  + "&vndr_seq=" + ComGetObjValue(formObj.hcond_vndr_seq)
			          + "&lstm_cd=" + (sLstmCd == "Total" ? "" : sheetObj.CellValue(Row,"lstm_cd"))
			          + "&loc_cd=" + (sLocCd == "G.Total" ? ComGetObjValue(formObj.hcond_loc_cd) : sheetObj.CellValue(Row,"loc_cd"));

				if(sheetObj.MousePointer == "Hand") {
					dcondTD.innerHTML = sheetObj.CellText(0, "loc_cd") +" : "+ sheetObj.CellValue(Row,"loc_cd")
						   + ",&nbsp;&nbsp;Lease Term : "+ sheetObj.CellValue(Row,"lstm_cd");
				}
				break;*/

			case "loc_cd":
				param = "&cntr_tpsz_cd=" + ComGetObjValue(formObj.hcond_tpsz_cd)
					  + "&vndr_seq=" + ComGetObjValue(formObj.hcond_vndr_seq)
			          + "&lstm_cd=" + ComGetObjValue(formObj.hcond_lstm_cd)
			          + "&loc_cd=" + (sLocCd == "G.Total" ? ComGetObjValue(formObj.hcond_loc_cd) : sheetObj.CellValue(Row,"loc_cd"));

				if(sheetObj.MousePointer == "Hand") {
					dcondTD.innerHTML = sheetObj.CellText(0, "loc_cd") +" : "+ sheetObj.CellValue(Row,"loc_cd");
				}
				break;
		}

		var isFlag = sheetObj.CellValue(Row, "lstm_cd")	!= "Total"
				  && sheetObj.CellValue(Row, "vndr_abbr_nm") != "S.TTL";

		if ( param != "") {
			param = "f_cmd=" + SEARCH01 + param + ComGetObjValue(formObj.hcond_params);

			sheetObjects[1].WaitImageVisible = false;
			ComOpenWait(true);
			sheetObjects[1].doSearch4Post("EES_LSE_0094GS.do",param);
			ComOpenWait(false);
		}
	}

	/**
	 * sheet1_OnMouseDown
	 * 마우스가 눌러졌을때 발생하는 Event 처리
	 * SUMMARY 에 해당하는 DETAIL 조회
	 */
	function sheet1_OnMouseDown(sheetObj , Button, Shift, X, Y) {

		var formObj = document.form;
		var sRow = sheetObj.MouseRow  ;
		var sCol = sheetObj.MouseCol  ;
		var sName  = sheetObj.ColSaveName(sCol);
		var sLocCd = sheetObj.CellValue(sRow,"loc_cd");
		var sLstmCd = sheetObj.CellValue(sRow,"lstm_cd");
		var fLstmCd = formObj.lstm_cd.value;  // 20140925 Add
		var param  = "";
		// G.Total Click 
		if(sRow > sheetObj.HeaderRows && sRow == sheetObj.LastRow){
			switch (sName) {
				case "tpsz_dp01": case "tpsz_dp02": case "tpsz_dp03":
				case "tpsz_dp04": case "tpsz_dp05": case "tpsz_dp06":
				case "tpsz_dp07": case "tpsz_dp08": case "tpsz_dp09":
				case "tpsz_dp10": case "tpsz_dp11": case "tpsz_dp12":
				case "tpsz_dp13": case "tpsz_dp14": case "tpsz_dp15":
				case "tpsz_dp16": case "tpsz_dp17": case "tpsz_dp18":
				case "tpsz_dp19": case "tpsz_dp20": case "tpsz_dp21":
				case "tpsz_dp22": case "tpsz_dp23": case "tpsz_dp24":
				case "tpsz_dp25": case "tpsz_dp26": case "tpsz_dp27":
				case "tpsz_dp28": case "tpsz_dp29": case "tpsz_dp30":
					param = "&cntr_tpsz_cd=" + sheetObj.CellText(0, sCol)
						  + "&vndr_seq=" + ComGetObjValue(formObj.vndr_seq)
				      //    + "&lstm_cd=" + (sLstmCd == "Total" ? "" : sheetObj.CellValue(sRow,"lstm_cd"))
				          + "&lstm_cd=" + (sLstmCd == "Total" ? "" : fLstmCd)
				          + "&loc_cd=" + (sLocCd == "G.Total" ? ComGetObjValue(formObj.hcond_loc_cd) : sheetObj.CellValue(sRow,"loc_cd"));

					if(sheetObj.MousePointer == "Hand") {
						dcondTD.innerHTML = sheetObj.CellText(0, "loc_cd") +" : "+ sheetObj.CellValue(sRow,"loc_cd")
							 //  + ",&nbsp;&nbsp;Lease Term : "+ sheetObj.CellValue(sRow,"lstm_cd")
							   + ",&nbsp;&nbsp;Lease Term : "+ fLstmCd
							   + ",&nbsp;&nbsp;Lessee : "+ sheetObj.CellValue(sRow,"vndr_abbr_nm")
							   + ",&nbsp;&nbsp;TP/SZ : "+ sheetObj.CellText(0, sCol);
					}
					break;

				case "tpsz_total":
				case "vndr_abbr_nm":
/*					param = "&cntr_tpsz_cd=" + ComGetObjValue(formObj.hcond_tpsz_cd)
						  + "&vndr_seq=" + ComGetObjValue(formObj.vndr_seq)
				          + "&lstm_cd=" + (sLstmCd == "Total" ? "" : sheetObj.CellValue(sRow,"lstm_cd"))
				          + "&loc_cd=" + (sLocCd == "G.Total" ? ComGetObjValue(formObj.hcond_loc_cd) : sheetObj.CellValue(sRow,"loc_cd"));

					if(sheetObj.MousePointer == "Hand") {
						dcondTD.innerHTML = sheetObj.CellText(0, "loc_cd") +" : "+ sheetObj.CellValue(sRow,"loc_cd")
							   + ",&nbsp;&nbsp;Lease Term : "+ sheetObj.CellValue(sRow,"lstm_cd")
							   + ",&nbsp;&nbsp;Lessee : "+ sheetObj.CellValue(sRow,"vndr_abbr_nm");
					}
					break;
*/
				case "lstm_cd":
/*					param = "&cntr_tpsz_cd=" + ComGetObjValue(formObj.hcond_tpsz_cd)
						  + "&vndr_seq=" + ComGetObjValue(formObj.hcond_vndr_seq)
				          + "&lstm_cd=" + (sLstmCd == "Total" ? "" : sheetObj.CellValue(sRow,"lstm_cd"))
				          + "&loc_cd=" + (sLocCd == "G.Total" ? ComGetObjValue(formObj.hcond_loc_cd) : sheetObj.CellValue(sRow,"loc_cd"));

					if(sheetObj.MousePointer == "Hand") {
						dcondTD.innerHTML = sheetObj.CellText(0, "loc_cd") +" : "+ sheetObj.CellValue(sRow,"loc_cd")
							   + ",&nbsp;&nbsp;Lease Term : "+ sheetObj.CellValue(sRow,"lstm_cd");
					}
					break;*/

				case "loc_cd":
					param = "&cntr_tpsz_cd=" + ComGetObjValue(formObj.hcond_tpsz_cd)
						  + "&vndr_seq=" + ComGetObjValue(formObj.hcond_vndr_seq)
				          + "&lstm_cd=" + ComGetObjValue(formObj.hcond_lstm_cd)
				          + "&loc_cd=" + (sLocCd == "G.Total" ? ComGetObjValue(formObj.hcond_loc_cd) : sheetObj.CellValue(sRow,"loc_cd"));

					if(sheetObj.MousePointer == "Hand") {
						dcondTD.innerHTML = sheetObj.CellText(0, "loc_cd") +" : "+ sheetObj.CellValue(sRow,"loc_cd");
					}
					break;
			}

			var isFlag = sheetObj.CellValue(sRow, "lstm_cd")	!= "Total"
					  && sheetObj.CellValue(sRow, "vndr_abbr_nm") != "S.TTL";

			if ( param != "") {
				param = "f_cmd=" + SEARCH01 + param + ComGetObjValue(formObj.hcond_params) + "&ttl_flag="+sheetObj.CellValue(sRow,"loc_cd");

				sheetObjects[1].WaitImageVisible = false;
				ComOpenWait(true);
				sheetObjects[1].doSearch4Post("EES_LSE_0094GS.do",param);
				ComOpenWait(false);
			}
		}
	}

	/**
     * 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		with(sheetObj) {
			var viewCnt = 0;
			var formObj = document.form;

			for ( var i = 1 ; i < vCntrTpszCnt ; i++ ) {
				var cellData = eval('sheetObj.SumValue(0, "tpsz_dp'+ ComLpad(i, 2, "0") + '")');
				if(cellData <= 0) {
					eval('sheetObj.ColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '") = true;');
				}

				var viewFlag = eval('sheetObj.ColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '")');
				if(viewFlag == false) {
					viewCnt++;
				}
			}

			if(SearchRows > 0) {
				if(310 + (viewCnt * 50) > 984) {
					SheetWidth = 984;
				} else {
					SheetWidth = 320 + (viewCnt * 50);
				}

				if(formObj.total_flg.checked) {
					SheetWidth = SheetWidth -80;
				}
		    	//RowBackColor(LastRow) = LSE_TOTCOL_BACK_COLOR;
			} else {
				SheetWidth = 984;
				for( var i = 1; i < vCntrTpszCnt; i++ ) {
					if(vArrCntrTpsz[i] != "") {
						eval('sheetObj.ColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '") = false;');
					} else {
						eval('sheetObj.ColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '") = true;');
					}
				}
			}

			for(var i = 0; i <= SearchRows; i++) {
				if(CellValue(i, "lstm_cd") == "Total" || CellValue(i, "vndr_abbr_nm") == "S.TTL" ) {
					//RowBackColor(i) = LSE_TOTCOL_BACK_COLOR;
				}
			}
			ColBackColor("tpsz_total") = LSE_TOTCOL_BACK_COLOR;

			if(SearchRows > 0) {
				for(var j = 0; j <= LastCol; j++) {
					CellText(LastRow, j) = CellText(LastRow -1, j);
				}
				RowHidden(LastRow -1) = true;

				if(formObj.total_flg.checked) {
					//합계 Title Merge 처리
					//SetMergeCell(LastRow, 1, 1, 2);
				} else {
					try {
						//소계 Title Merge 처리
						var strRows = ComFindAll(sheetObj, "lstm_cd", "Total");
						var arrStrRows = strRows.split("|");

						for ( var i = 0 ; i < arrStrRows.length; i++ ) {
						//	SetMergeCell(arrStrRows[i], 1, 1, 2);
						}
					} catch(e) {
						//SetMergeCell(strRows, 1, 1, 2);
					}
					//SetMergeCell(LastRow, 0, 1, 3);
				}
			}

			formObj.hcond_tpsz_cd.value  = ComGetObjValue(formObj.cntr_tpsz_cd);
			formObj.hcond_lstm_cd.value  = ComGetObjValue(formObj.lstm_cd);
			formObj.hcond_vndr_seq.value = ComGetObjValue(formObj.vndr_seq);
			formObj.hcond_loc_cd.value = ComGetObjValue(formObj.loc_cd);
			formObj.hcond_params.value = "&lst_sts_flg=" + ComGetObjValue(formObj.lst_sts_flg)
				   + "&cntr_sts_cd=" + ComGetObjValue(formObj.cntr_sts_cd)
				   + "&lstm_soc_tp=" + ComGetObjValue(formObj.lstm_soc_tp)
				   + "&str_evnt_dt=" + ComGetObjValue(formObj.str_evnt_dt)
				   + "&end_evnt_dt=" + ComGetObjValue(formObj.end_evnt_dt)
				   + "&agmt_cty_cd=" + ComGetObjValue(formObj.agmt_cty_cd)
			       + "&agmt_seq=" + ComGetObjValue(formObj.agmt_seq)
				   + "&onh_free_dys=" + ComGetObjValue(formObj.onh_free_dys)
				   + "&use_day=" + ComGetObjValue(formObj.use_day)
			//	   + "&cntr_full_flg=" + ComGetObjValue(formObj.cntr_full_flg)
				   + "&total_flg=" + ComGetObjValue(formObj.total_flg)
				   + "&loc_tp=" + ComGetObjValue(formObj.loc_tp);
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
				formObj.lstm_cd.value = ComGetObjValue(comboObj);
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
				formObj.cntr_tpsz_cd.value = ComGetObjValue(comboObj);
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}
		}
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
    			case "2" :	//RCC
    				ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430,"rcc_cd:loc_cd", "1,0,1,1,1,1,1", true);
    				break;
    			case "3" :	//LCC
    				ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430,"lcc_cd:loc_cd", "1,0,1,1,1,1,1", true);
    				break;
    			case "4" :	//SCC
    				ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430,"scc_cd:loc_cd", "1,0,1,1,1,1,1", true);
    				break;
    			case "5" :	//Country
					ComOpenPopup("/hanjin/COM_ENS_0M1.do",565, 480, 'setPopData_Country', "1,0,1,1,1,1,1", true);
    				break;
    			default : 	//do nothing
    		}
    	} else if ( type == "2" ) {
    		ComOpenPopup('/hanjin/EES_LSE_0091.do', 805, 450, 'setPopData_Agreement', '1,0', true);
    	} else if ( type == "3" ) {
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
    		ComSetObjValue(formObj.ref_no,   aryPopupData[0][5]);
    		ComSetObjValue(formObj.vndr_seq, aryPopupData[0][7]);
    		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC04);
    	}
    }

    /**
	 * Country Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param 대상IBSheet의 Sheet Array index
	 */
	function setPopData_Country(aryPopupData, Row, Col, SheetIdx) {
		var sheetObj = sheetObjects[SheetIdx];
		var formObj  = document.form;

		if ( aryPopupData.length > 0 ) {
			ComSetObjValue(formObj.loc_cd, aryPopupData[0][3]);
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
    			case IBSEARCH:      //조회
    				if (!checkDurationDate()) {
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
    	var vEffDt = ComReplaceStr(ComGetObjValue(formObj.str_evnt_dt),"-","");
		var vExpDt = ComReplaceStr(ComGetObjValue(formObj.end_evnt_dt),"-","");

    	//Duration이 필수입력이 아닌경우
    	if(formObj.str_evnt_dt.className == "input") {
	    	if( vEffDt == "" && vExpDt == "" ) {
	    		return true;
	    	}
    	}

		/* Duration Date Validation(str_evnt_dt) */
		if(vEffDt == "" && eventObj == null) {
			ComShowCodeMessage("LSE01078");
			ComSetFocus(formObj.str_evnt_dt);
			return false;
		} else if(vEffDt == "" && eventObj.name == "str_evnt_dt") {
			ComShowCodeMessage("LSE01078");
			ComSetFocus(formObj.str_evnt_dt);
			return false;
		} else if (vEffDt != "" && !ComIsDate(formObj.str_evnt_dt) ) {
			ComShowCodeMessage("LSE01080");
			ComSetObjValue(formObj.str_evnt_dt,"");
			ComSetFocus(formObj.str_evnt_dt);
			return false;
		}

		/* Duration Date Validation(end_evnt_dt) */
		if(vExpDt == "" && eventObj == null) {
			ComShowCodeMessage("LSE01079");
			ComSetFocus(formObj.end_evnt_dt);
			return false;
		} else if(vExpDt == "" && eventObj.name == "end_evnt_dt") {
			ComShowCodeMessage("LSE01079");
			ComSetFocus(formObj.end_evnt_dt);
			return false;
		} else if (vExpDt != "" && !ComIsDate(formObj.end_evnt_dt) ) {
			ComShowCodeMessage("LSE01081");
			ComSetObjValue(formObj.end_evnt_dt,"");
			ComSetFocus(formObj.end_evnt_dt);
			return false;
		}

		/* Duration Date Validation(str_evnt_dt < end_evnt_dt) */
		if(vEffDt != "" && vExpDt != "") {
			if ( ComChkPeriod(vEffDt, vExpDt) != 1 ) {
				ComShowCodeMessage("LSE01082");

				if(eventObj == null) {
					ComSetObjValue(formObj.end_evnt_dt,"");
					ComSetFocus(formObj.end_evnt_dt);
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
			case "agmt_seq":
				ComSetObjValue(formObj.agmt_seq,    "");
				ComSetObjValue(formObj.ref_no,   	"");
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

	/* 개발자 작업  끝 */