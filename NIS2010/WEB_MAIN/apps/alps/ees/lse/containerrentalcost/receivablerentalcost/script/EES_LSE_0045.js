/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_LSE_0045.js
 *@FileTitle : Receivable Invoice Inquiry and Cancel
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.17
 *@LastModifier : 장준우
 *@LastVersion : 1.0
 * 2009.09.17 장준우
 * 1.0 Creation
 * 2011.01.27 남궁진호 [CHM-201108164-01] 공통 팝업 (COM_ENS_051, COM_ENS_0C1) Open Size 조정
 * 2011.05.16 남궁진호 [CHM-201110759-01] Split 02-BKG 이외 모듈에서 INVOICE 로 I/F 하는 로직에 ERP 호출 분리
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
	 * @class EES_LSE_0045 : EES_LSE_0045 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_LSE_0045() {
		this.processButtonClick  = processButtonClick;
		this.setSheetObject 	 = setSheetObject;
		this.loadPage 			 = loadPage;
		this.sheet1_OnLoadFinish = sheet1_OnLoadFinish;
		this.initControl 		 = initControl;
		this.obj_blur 			 = obj_blur;
		this.obj_focus 			 = obj_focus;
		this.obj_change 		 = obj_change;
		this.obj_keypress 		 = obj_keypress;
		this.obj_keyup 			 = obj_keyup;
		this.obj_keydown 		 = obj_keydown;
		this.initSheet 			 = initSheet;
		this.doActionIBSheet 	 = doActionIBSheet;
		this.sheet1_OnMouseMove  = sheet1_OnMouseMove;
		this.sheet1_OnDblClick   = sheet1_OnDblClick;
		this.sheet1_OnSearchEnd  = sheet1_OnSearchEnd;
		this.sheet1_OnValidation = sheet1_OnValidation;
		this.sheet1_OnSaveEnd 	 = sheet1_OnSaveEnd;
		this.openPopup 			 = openPopup;
		this.setPopData_Lessor 	 = setPopData_Lessor;
		this.validateForm 		 = validateForm;
		this.clearForm 			 = clearForm;
	}

	// 공통전역변수
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
    		var srcObj  = window.event.srcElement;
    		var srcName = window.event.srcElement.getAttribute("name");

           	switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject1, formObj, IBSEARCH);
					break;

				case "btn_new":
					ComResetAll();
					// 조회 전 데이터 가공 방지를 위한 버튼 콘트롤
					sheet1_OnLoadFinish(sheetObject1);
					break;

				case "btn_cancel":
					doActionIBSheet(sheetObject1, formObj, IBSAVE);
					break;

				case "btn_downexcel":
					sheetObject1.SpeedDown2Excel(-1);
					break;

				case "btns_calendar1":
 					var cal = new ComCalendar();
					cal.setDisplayType('month');
					cal.select(formObj.qty_yrmon, 'yyyy-MM');
             	 	break;

				case "btns_search1": 	// Form Lessor Search
					openPopup("1");
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
		ComSetFocus(formObj.vndr_seq);
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
	    	case "qty_yrmon" :
	    		//Validation 전체 체크(길이,format,최대,최소 등등)
	            ComChkObjValid(obj);
	            break;
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

		switch(obj.name) {
			case "vndr_seq":	//Lessor Code
  				if ( ComTrim(obj.value) != "" ) {
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC01);
  				}
  				break;
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
	        	if(obj.value.length < 3) {
	            	ComKeyOnlyAlphabet('upper');
	        	} else {
	        		ComKeyOnlyNumber(obj);
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
				case "vndr_seq":
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
		var sheetId = sheetObj.id;

        switch(sheetId) {
             case "sheet1":      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 410;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    var HeadTitle = "|Sel.||Invoice No.|Lessee\nCode|Lessee Name|Issued Date|LSE\nCURR.|Invoice\nAmount|ERP\nCURR.|ERP\nLCL Amount|ERP\nUSD Amount|OTS Settle\nStatus|Invoice\nStatus|ERP\nStatus|I/F Date|Created|||||";

                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 6, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
			        InitDataProperty(0, cnt++ , dtRadioCheck,	40,		daCenter,	false,	"del_chk");
			        InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	false,	"cost_yrmon",   	false,	"",		dfNone);
					InitDataProperty(0, cnt++ , dtData,    		100,   	daCenter,  	false,	"inv_no",   		false,  "",     dfNone,     	0,	false,	false);

                    InitDataProperty(0, cnt++ , dtData,   		70,    	daCenter,  	false,   "vndr_seq",   		false,	"",     dfNone,     	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,   		120,   	daCenter,  	false,   "vndr_abbr_nm", 	false,  "",     dfNone,     	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,    		85,    	daCenter,  	false,   "inv_isu_dt", 		false,  "",     dfDateYmd,		0,  false,	false);
                    InitDataProperty(0, cnt++ , dtData,    		55,    	daCenter,  	false,   "curr_cd",   		false,  "",     dfNone,     	0,  false,	false);
                    InitDataProperty(0, cnt++ , dtData,   	  	95,   	daRight,  	false,   "inv_amt",   		false,  "",     dfFloat,		2,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,    		55,    	daCenter,  	false,   "ofc_curr_cd",		false,  "",     dfNone,     	0,  false,	false);
                    InitDataProperty(0, cnt++ , dtData,   	  	95,   	daRight,  	false,   "erp_lcl_amt", 	false,  "",     dfNullFloat,	2,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,   	  	95,   	daRight,  	false,   "erp_usd_amt",		false,  "",     dfNullFloat,	2,	false,	false);

                    InitDataProperty(0, cnt++ , dtCombo,   		80,   	daCenter,  	false,   "ots_stl_flg",   	false,  "",     dfNone,	    	0,  false,	false);
					InitDataProperty(0, cnt++ , dtCombo,   		110,   	daCenter,  	false,   "bl_inv_if_flg",   false,  "",     dfNone,	    	0,  false,	false);
					InitDataProperty(0, cnt++ , dtCombo,   		110,   	daCenter,  	false,   "erp_if_sts",   	false,  "",     dfNone,	    	0,  false,	false);
					InitDataProperty(0, cnt++ , dtData,    		85,    	daCenter,  	false,   "src_if_dt",  		false,  "",     dfDateYmd,		0,  false,	false);
					InitDataProperty(0, cnt++ , dtData,    		80,    	daCenter,  	false,   "inv_cre_usr_id", 	false,  "",     dfNone,			0,  false,	false);
					InitDataProperty(0, cnt++ , dtHidden,		120,	daCenter,	false,	 "if_err_rsn",   	false,	"",		dfNone);
					InitDataProperty(0, cnt++ , dtHidden,		120,	daCenter,	false,	 "erp_if_rsn",   	false,	"",		dfNone);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	false,	 "src_if_seq",   	false,	"",		dfNone);
					InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	false,	 "cfm_flg",   		false,	"",		dfNone);
					InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	false,	 "inv_cre_ofc_cd",	false,	"",		dfNone);

					InitDataCombo(0, "ots_stl_flg", 	" |Settled|Not Settled", 	" |Y|N");
					InitDataCombo(0, "bl_inv_if_flg", 	" |Invoice I/F Success|Invoice I/F Sending|Invoice I/F Error",		" |Y|N|E");
					InitDataCombo(0, "erp_if_sts", 		" |ERP I/F Success|Not ERP I/F|AR Invoicing Fail|ERP I/F Error", 	" |Y|N|F|E");

					SelectBackColor = LSE_SELECT_BACK_COLOR;
 					CountFormat = "[SELECTDATAROW / TOTALROWS]";
 					CountPosition = 0;
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

				case IBSEARCH:      //조회
					if(validateForm(sheetObj, formObj, sAction)) {
						if(sheetObj.id == "sheet1") {
							formObj.f_cmd.value = SEARCH;
							sheetObj.WaitImageVisible = false;
							ComOpenWait(true);
							sheetObj.DoSearch4Post("EES_LSE_0045GS.do",FormQueryString(formObj));
							ComOpenWait(false);
						}
					}
					break;

				case IBSEARCH_ASYNC01:	//조회(Form Lessor No. 입력시)
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

				case IBSAVE:        //저장
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					if(validateForm(sheetObj, formObj, sAction)) {
						if(sheetObj.id == "sheet1") {
							formObj.f_cmd.value = MULTI;
							var param = "f_cmd="+MULTI;
							
							var sXml = sheetObj.GetSaveXml("EES_LSE_0045GS.do", param+"&"+sheetObj.GetSaveString(false, false,"del_chk") , false);
							//INV I/F 로직 변경으로 인해 업데이트 되지 않았을 경우 해당 사유 알림 
							var arIfNo = ComGetEtcData(sXml, "arIfNo");
							var arIfNoArr = arIfNo.split("::");
							if(arIfNoArr[0] == "S"){
								ComShowCodeMessage("LSE10001");
								doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
							}else{
								ComShowMessage("ERROR : "+ arIfNoArr[1]);
							}
						}
					}
					ComOpenWait(false);
					sheetObj.WaitImageVisible = true;
					break;
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
			if(Row >= HeaderRows && ColSaveName(Col) == "bl_inv_if_flg") {
				MouseToolTipText = CellText(Row,"if_err_rsn");
			} else if(Row >= HeaderRows && ColSaveName(Col) == "erp_if_sts") {
				MouseToolTipText = CellText(Row,"erp_if_rsn");
			} else {
				MouseToolTipText = "";
			}

			DataLinkMouse("inv_cre_usr_id") = CellValue(MouseRow, MouseCol) != "";
		}
	}

	/**
	 * sheet1_OnDblClick
	 */
	function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
		var formObj = document.form;

		with(sheetObj) {
			if(MousePointer == "Hand") {
				//사용자정보 화면을 팝업한다.
				ComUserPopup(CellValue(Row, Col));
			}
		}
	}

	/**
     * 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var formObj = document.form;

    	with(sheetObj) {
    		ColFontColor("inv_cre_usr_id") = RgbColor(0, 0, 255);

    		for(var i = 0; i <= SearchRows; i++) {
    			var vCreOfcCd = CellValue(i, "inv_cre_ofc_cd");
    			//var vInvIfFlg = CellValue(i, "bl_inv_if_flg");
    			//CellEditable(i, "del_chk") = vInvIfFlg == "N";
    			if(CellValue(i, "cfm_flg") == "N") {
    				RowFontColor(i) = RgbColor(133, 133, 133);	//GRAY
    			}
				//발행점소의 Invoice에 대하여만 취소가 가능하다.
    			CellEditable(i, "del_chk") = (formObj.ofc_cd.value == vCreOfcCd);
    		}
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
	    	//do nothing
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
    		doActionIBSheet(sheetObj, document.form, IBSEARCH);
    	}
    }

    /**
     * Pop-up Open 부분<br>
     * @param type 1:Agreement No. Popup for FORM, 3:Location Popup for GRID
     * @param Row 대상Object가 IBSheet일 경우 해당 Row index
     * @param Col 대상Object가 IBSheet일 경우 해당 Col index
     */
    function openPopup(type, Row, Col) {
    	if ( type == "1" ) {
    		ComOpenPopup('/hanjin/COM_ENS_0C1.do', 705, 450, 'setPopData_Lessor', '1,0,1,1,1,1,1,1', true);
    	}

    	return;
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
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 */
	function validateForm(sheetObj, formObj, sAction) {
    	with(formObj) {
    		switch(sAction) {
    			case IBSEARCH:      	//조회
    				return ComChkValid(formObj, false);
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
	 * Form Element Clear 처리부분.<br>
	 * @param fieldName
	 */
	function clearForm(fieldName) {
		var formObj = document.form;
		switch(fieldName) {
			case "vndr_seq":
				ComSetObjValue(formObj.vndr_seq, 	"");
				ComSetObjValue(formObj.vndr_nm,  	"");
				ComSetObjValue(formObj.vndr_abbr_nm,"");
				ComSetFocus(formObj.vndr_seq);
				break;
		}
	}

	/* 개발자 작업  끝 */
