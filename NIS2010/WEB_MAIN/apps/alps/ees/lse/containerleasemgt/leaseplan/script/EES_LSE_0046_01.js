/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_lse_0046_01.js
*@FileTitle : Off Hire Plan DOL Inquery
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.10.08 노정용
* 1.0 Creation
* 2011.01.27 남궁진호 [CHM-201108164-01] 공통 팝업 (COM_ENS_051, COM_ENS_0C1) Open Size 조정
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
	 * @class ees_lse_0046_01 : ees_lse_0046_01 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ees_lse_0046_01() {
		this.processButtonClick	= processButtonClick;
		this.setSheetObject		= setSheetObject;
		this.setComboObject		= setComboObject;
		this.loadPage			= loadPage;
		this.initControl		= initControl;
		this.obj_blur			= obj_blur;
		this.obj_focus			= obj_focus;
		this.obj_keypress		= obj_keypress;
		this.obj_keyup			= obj_keyup;
		this.obj_keydown		= obj_keydown;
		this.obj_click			= obj_click;
		this.initSheet			= initSheet;
		this.initCombo			= initCombo;
		this.doActionIBSheet	= doActionIBSheet;
		this.sheet1_OnSearchEnd = sheet1_OnSearchEnd;
		this.sheet1_OnChange	= sheet1_OnChange;
		this.validateForm		= validateForm;
	}

	/* 개발자 작업  */

	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;

	// Combo Object Array
	var comboObjects = new Array();
	var comboCnt = 0;
	
	var orgCntrTpSzCd;
	var arrOrgCntrTpSzCd;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
		/*******************************************************/
		var formObj = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "btns_search":
					openPopup("1");
					break;

				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
					break;

				case "btn_New":
					ComResetAll();
					LseComBtnControl(false, "btn_Save|btns_DownExcel");
					break;

				case "btn_Close":
					window.close();
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

		/* IBMultiCombo 초기화 */
		for ( var k = 0 ; k < comboObjects.length ; k++ ) {
	        initCombo(comboObjects[k], k+1);
	    }

		for(var i = 0 ; i < sheetObjects.length ; i++ ) {
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}

		initControl();
	}

	// Axon 이벤트 처리
  	// 1. 이벤트catch
  	function initControl() {
  		var formObj = document.form;
  		axon_event.addListenerForm('blur',		'obj_blur',		formObj); //- 포커스 나갈때
		axon_event.addListenerForm('focus',		'obj_focus',	formObj); //- 포커스 들어갈때
  		axon_event.addListenerForm('keypress',	'obj_keypress',	formObj); //- 키 눌렸을때
		axon_event.addListenerForm('keyup',		'obj_keyup',	formObj); //- 키 올라올때
		axon_event.addListenerForm('keydown',	'obj_keydown',	formObj); //- 키 눌렸을때
		axon_event.addListenerForm('click',		'obj_click',	formObj); //- 키 눌렸을때
		axon_event.addListenerForm('change',	'obj_change',	formObj); //- 키 눌렸을때
  	}

  	// 2. 이벤트처리함수 -- Start
  	/**
	 * HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
	 */
	function obj_blur(){
		var obj = event.srcElement;

	    switch(obj.name){
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
			case "loc_cd":
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
   		}
   	}

	/**
	 * HTML Control의 Value가 변경되었을 경우 처리한다.
	 */
	function obj_click() {
		var obj = event.srcElement;
/*
		switch(obj.name) {
			case "chk_offh_rgn_loc_cd":
				if ( obj.checked ) {
					comboObjects[2].Code = vOrcOffhLocCd.replaceStr("|", ",");
				} else {
					comboObjects[2].Code = "";
				}
				break;
		}
*/
	}

	/**
	 * Change Event 처리
	 */	 
	function obj_change() {
		var obj      = event.srcElement;
		var formObj  = document.form;

		if ( ComTrim(ComGetObjValue(obj)) != "" ) {
			switch(obj.name) {
		   		case "loc_cd":
		   			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);
					break;
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
		var formObj = document.form;

		orgCntrTpSzCd = ComGetObjValue(formObj.cntr_tpsz_cd);
		arrOrgCntrTpSzCd = orgCntrTpSzCd.split("|");

		switch(sheetid) {
			case "sheet1":
				with (sheetObj) {
					// 높이 설정
					style.height = 200;

					//전체 너비 설정
					SheetWidth = mainTable.clientWidth-20;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msPrevColumnMerge;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 20, 100);

					var HeadTitle = "|RCC|LCC|AGMT NO.|TTL|" + orgCntrTpSzCd;
					var headCount = ComCountHeadTitle(HeadTitle);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 5, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false)

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					var vCalcStr = "";

					for ( var i = 0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
						if ( vCalcStr != "" ) {
							vCalcStr = vCalcStr + '+|cntr'+(i+1)+'_qty|';
						} else {
							vCalcStr = '|cntr'+(i+1)+'_qty|';
						}
					}

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHidden,	30,  	daCenter,	true,	"level_no",			false,	"",		dfNone);
					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"offh_rgn_loc_cd",	false,  "",			dfNone,		0);
					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"offh_loc_cd",		false,  "",			dfNone,		0);
					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	"agmt_no",			false,  "",			dfNone,		0);
					InitDataProperty(0, cnt++ , dtData,		55,		daRight,	false,	"TTL",				false,  vCalcStr,   dfInteger,	0);
					for ( var i = 0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
						eval('InitDataProperty(0, cnt++, dtData, 55, daRight, false, "cntr'+(i+1)+'_qty", false, "", dfInteger,	0);');
					}
					
					//InitTreeInfo("offh_rgn_loc_cd", "level_no", RgbColor(0,0,255), false);
					InitTreeInfo("offh_loc_cd",     "level_no", RgbColor(0,0,255), false);
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
	        case "loc_tp":
	        	with(comboObj) {
	            	DropHeight = 100;
	            	MultiSelect = false;
	            	UseAutoComplete = true;
	            }
	        	break;

	        case "lstm_cd":
	        	with(comboObj) {
	            	DropHeight = 200;
	            	MultiSelect = false;
	            	UseAutoComplete = true;
	            	ValidChar(2,0);
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

		        /* Plan Month Combo Item Setting Start */
	        	var strText = "RCC by LCC|LCC by SCC";
	        	var strCode = "1|2";

	        	LseComText2ComboItem(comboObjects[0], strText, strCode, "|");
	        	
	        	comboObjects[0].Index = 0;

				/* Lease Term Form Combo Item Setting */
				ComSetObjValue(formObj.f_cmd, SEARCH01);
		     	var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", FormQueryString(formObj));

		        if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ) {
		        	var strText1 = "ALL|"+ComGetEtcData(sXml,"lease_term_nm");
		        	var strCode1 = " |"+ComGetEtcData(sXml,"lease_term_cd");
		        	LseComText2ComboItem(comboObjects[1], strText1, strCode1, "|");
		        }
		        comboObjects[1].Index = 0;

		        /* 초기 Focus Setting */
				ComSetFocus(formObj.loc_cd);
		        sheetObj.WaitImageVisible = true;
				break;

			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
					ComSetObjValue(formObj.f_cmd, SEARCH);
					sheetObj.DoSearch4Post("EES_LSE_0046_01GS.do", FormQueryString(formObj));
				}
				break;

			case IBSEARCH_ASYNC01:	// Location 조회
				if(validateForm(sheetObj,formObj,sAction)) {
					if ( sheetObj.id == "sheet1") {
						//ComSetObjValue(formObj.f_cmd, SEARCH05);
						sheetObj.WaitImageVisible = false;
						var sParam = "f_cmd="+SEARCH05;
						sParam = sParam + "&lstm_cd=" + ComGetObjValue(formObj.lstm_cd);
						var vLocTp = ComGetObjValue(formObj.loc_tp);
						switch (vLocTp) {
							case "1":
								sParam = sParam + "&loc_tp=RCC";
								break;

							case "2":
								sParam = sParam + "&loc_tp=LCC";
								break;
						}
						sParam = sParam + "&loc_cd=" + ComGetObjValue(formObj.loc_cd);
						var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", sParam); //FormQueryString(formObj));
						sheetObj.WaitImageVisible = true;
	
						if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ) {
							if ( ComGetEtcData(sXml, "rcc_cd") != undefined ) {
								if ( ComGetEtcData(sXml, "rcc_cd") != "" ) {
									var vLocCd = "";
									switch (vLocTp) {
										case "1":
											vLocCd = ComGetEtcData(sXml, "rcc_cd");
											break;
	
										case "2":
											vLocCd = ComGetEtcData(sXml, "lcc_cd");
											break;
									}
									ComSetObjValue(formObj.loc_cd, vLocCd);
								} else {
									ComShowCodeMessage("LSE01037");
									ComSetObjValue(formObj.loc_cd, "");
									ComSetFocus(formObj.loc_cd);
								}
							} else {
								var errMsg = LseComGetErrMsg(sXml);
								if ( errMsg != "" ) {
									ComShowMessage(errMsg);
								}
								ComSetObjValue(formObj.loc_cd, "");
								ComSetFocus(formObj.loc_cd);
							}
						} else {
							var errMsg = LseComGetErrMsg(sXml);
							if ( errMsg != "" ) {
								ComShowMessage(errMsg);
							}
							ComSetObjValue(formObj.loc_cd, "");
							ComSetFocus(formObj.loc_cd);
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
		var formObj = document.form;

		if ( ErrMsg == "" ) {
			/*
			var sumCols = "";
			for ( var i = 0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
				if ( i == 0 ) {
					sumCols = (2+i)+"";
				} else {
					sumCols = sumCols+"|"+(2+i);
				}
			}
			var captionCol = "offh_rgn_loc_cd="+ComGetObjValue(formObj.loc_cd)+";offh_loc_cd=TTL";
			sheetObj.ShowSubSum("offh_rgn_loc_cd", sumCols, -1, false, false, 0, captionCol);
			*/
			sheetObj.ShowTreeLevel(0, 1);			
		}
	}

	function loc_tp_OnChange(comboObj, Index_Code, Text) {
		if ( Index_Code == "1" ) {
			sheetObjects[0].CellValue(0, "offh_rgn_loc_cd") = "RCC";
			sheetObjects[0].CellValue(0, "offh_loc_cd")     = "LCC";
		} else if ( Index_Code == "2" ) {
			sheetObjects[0].CellValue(0, "offh_rgn_loc_cd") = "LCC";
			sheetObjects[0].CellValue(0, "offh_loc_cd")     = "SCC";
		}
	}
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
    	with(formObj){
    		switch(sAction) {
    			case IBSEARCH: //조회
	    			if ( ComGetObjValue(formObj.loc_cd) == "" ) {
						ComShowCodeMessage("LSE01046");
						ComSetFocus(formObj.loc_cd);
						return false;
						break;
					}
    				return ComChkValid(formObj);
    				break;
    		}
    	}

		return true;
	}

	/**
     * Pop-up Open 부분<br>
     * @param type 1:Location for FORM
     * @param object 대상 Object
     * @param Row 대상Object가 IBSheet일 경우 해당 Row index
     */
    function openPopup(type, Row, Col) {
    	if ( type == "1" ) {
    		ComOpenPopup('/hanjin/COM_ENS_051.do', 800, 430, 'setPopData_DeliveryLoc', '1,0,1,1,0,0,0,0', false, false, Row, Col, 0);
    	}
	}

    /**
     * Location Pop-up Return Value 처리 부분<br>
     * @param {arry} returnedValues Pop-up 화면의 Return value array
     * @param Row 대상Object가 IBSheet일 경우 해당 Row index
     * @param Col 대상Object가 IBSheet일 경우 해당 Col index
     * @param 대상IBSheet의 Sheet Array index
     */
    function setPopData_DeliveryLoc(aryPopupData, Row, Col, SheetIdx) {
    	var sheetObj = sheetObjects[SheetIdx];
    	var formObj  = document.form;

    	if ( aryPopupData.length > 0 ) {
    		if ( formObj.loc_tp[0].checked ) {
    			//ComSetObjValue(formObj.loc_cd, aryPopupData[0][13]);
    			ComSetObjValue(formObj.loc_cd, aryPopupData[0][11]);
    		} else if ( formObj.loc_tp[1].checked ) {
    			//ComSetObjValue(formObj.loc_cd, aryPopupData[0][12]);
    			ComSetObjValue(formObj.loc_cd, aryPopupData[0][10]);
    		} else if ( formObj.loc_tp[2].checked ) {
    			//ComSetObjValue(formObj.loc_cd, aryPopupData[0][10]);
    			ComSetObjValue(formObj.loc_cd, aryPopupData[0][8]);
    		}
    	}
    }
    /* 개발자 작업  끝 */