/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_lse_0046.js
*@FileTitle : Off Hire Plan Input and Update by RCC
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.07.03 노정용
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
	 * @class ees_lse_0046 : ees_lse_0046 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ees_lse_0046() {
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
				case "btns_calendar":
					var cal = new ComCalendar();
					cal.setDisplayType('month');
					cal.select(formObj.offh_yrmon, 'yyyy-MM');
					break;

				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
					break;

				case "btn_New":
					ComResetAll();
					LseComBtnControl(false, "btn_Save|btns_DownExcel");
					break;

				case "btn_Save":
					if ( ComIsBtnEnable(srcName) ) {
						if ( ComShowCodeConfirm("COM12147", "Off-Hire Plan by RCC") ) {
							doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
						}
					}
					break;

				case "btns_DownExcel":
					if ( ComIsBtnEnable(srcName) ) {
						doActionIBSheet(sheetObjects[0], formObj, IBDOWNEXCEL);
					}
					break;

				case "btn_DOL":
					openPopup("1");
					break;

				case "btn_AvailOffHireUnits":
					openPopup("2");
					break;

				case "btn_OffHirePFMC":
					openPopup("3");
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

		LseComBtnControl(false, "btn_Save|btns_DownExcel");
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
			case "offh_yrmon":
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

		switch(obj.name) {
			case "chk_offh_rgn_loc_cd":
				/* RCC 체크박스 체크시 전체체크,전체해재 기능 */
				if ( obj.checked ) {
					comboObjects[2].Code = vOrcOffhLocCd.replaceStr("|", ",");
				} else {
					comboObjects[2].Code = "";
				}
				break;
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
					style.height = 660;

					//전체 너비 설정
					SheetWidth = mainTable.clientWidth-20;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msPrevColumnMerge;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 20, 100);

					var HeadTitle = "||RCC|LCC|G.TTL|" + orgCntrTpSzCd + "|";
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
					InitDataProperty(0, cnt++ , dtHidden,       100,  daCenter, true,   "pln_yr",          false,  "",   dfNone, 0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,       100,  daCenter, true,   "offh_yrmon",      false,  "",   dfNone, 0, false, false);
					InitDataProperty(0, cnt++ , dtData,         55,   daCenter, true,   "offh_rgn_loc_cd", false,  "",   dfNone, 0, false, false);
					InitDataProperty(0, cnt++ , dtData,         100,  daCenter, true,   "offh_loc_cd",     false,  "",   dfNone, 0, false, false);
					InitDataProperty(0, cnt++ , dtData,         65,   daRight,	false,  "TTL",             false,  vCalcStr,   dfInteger, 0, false, false);
					for ( var i = 0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
						eval('InitDataProperty(0, cnt++, dtData, 55, daRight, false, "cntr'+(i+1)+'_qty", false, "", dfInteger,	0, true, true, 6);');
					}
					InitDataProperty(0, cnt++ , dtHiddenStatus, 30,   daCenter,	true,   "ibflag");
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
	        case "offh_rgn_loc_cd":
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

				/* RCC Combo Item Setting */
	        	ComSetObjValue(formObj.f_cmd, SEARCH08);
		        var sXml3 = sheetObj.GetSearchXml("EES_LSE_COMGS.do", FormQueryString(formObj));
		        if ( sXml3 != "" ) {
			        LseComXml2ComboItem(sXml3, comboObjects[0], "rcc_cd", "rcc_cd", "|");
			        vOrcOffhLocCd = ComGetEtcData(sXml3, "rcc_cd");
		        }

		        /* 초기 Focus Setting */
		        ComSetFocus(formObj.offh_yrmon);
		        sheetObj.WaitImageVisible = true;
				break;

			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
					ComSetObjValue(formObj.f_cmd, SEARCH);
					
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					sheetObj.DoSearch4Post("EES_LSE_0046GS.do", FormQueryString(formObj));
					ComOpenWait(false);
				}
				break;

			case IBSAVE:        //저장
				if(validateForm(sheetObj,formObj,sAction)) {
					ComSetObjValue(formObj.f_cmd, MULTI);

					sheetObj.RowStatus(sheetObj.HeaderRows+1) = "R";

					if (sheetObj.IsDataModified == true) {
						var sParam = FormQueryString(formObj);
						sParam = sParam + "&" + ComSetPrifix(sheetObj.GetSaveString(), "sheet1_");
						
						sheetObj.WaitImageVisible = false;
						ComOpenWait(true);
						var sXml = sheetObj.GetSaveXml("EES_LSE_0046GS.do" , sParam);
						sheetObj.LoadSaveXml(sXml);
						ComOpenWait(false);
					} else {
						ComShowCodeMessage("LSE01033");
					}
				}
				break;

			case IBDOWNEXCEL:
				sheetObj.SpeedDown2Excel(-1);
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
			if ( sheetObj.SearchRows > 0 ) {
				if ( sheetObj.CellValue(sheetObj.HeaderRows, "offh_loc_cd") == "Target" ) {
					sheetObj.RowEditable(sheetObj.HeaderRows) = false;
				}
				if ( sheetObj.CellValue(sheetObj.HeaderRows+1, "offh_loc_cd") == "Difference" ) {
					sheetObj.RowEditable(sheetObj.HeaderRows+1) = false;
				}
			}

			for ( var i = sheetObj.FrozenCols ; i < (sheetObj.FrozenCols + arrOrgCntrTpSzCd.length) ; i++ ) {
				var totQty = eval('sheetObj.ComputeSum("|'+i+'|", sheetObj.HeaderRows+2, sheetObj.LastRow);');
				var bseQty = ComParseInt(sheetObj.CellValue(sheetObj.HeaderRows, i));
				var qtyGap = totQty-bseQty;
				
				if ( bseQty == 0 && qtyGap == 0 ) {
					sheetObj.ColHidden(i) = true;
				} else {
					sheetObj.ColHidden(i) = false;
					sheetObj.CellValue2(sheetObj.HeaderRows+1, i) = qtyGap;
					
					if ( qtyGap < 0 ) {
						sheetObj.CellFontColor(sheetObj.HeaderRows+1, i) = sheetObj.RgbColor(255, 0, 0);
						sheetObj.CellFont("FontBold", sheetObj.HeaderRows+1, i) = true;
					} else if ( qtyGap > 0) {
						sheetObj.CellFontColor(sheetObj.HeaderRows+1, i) = sheetObj.RgbColor(0, 0, 255);
						sheetObj.CellFont("FontBold", sheetObj.HeaderRows+1, i) = true;
					} else {
						sheetObj.CellFontColor(sheetObj.HeaderRows+1, i) = sheetObj.RgbColor(0, 0, 0);
						sheetObj.CellFont("FontBold", sheetObj.HeaderRows+1, i) = false;
					}
				}
			}
			
			/* Column 에 따른 Sheet Width 조정 */
			var vStartCntrColIdx = sheetObj.FrozenCols;
			var vShowSheetWidth  = 0;

			for ( var colIdx = 0 ; colIdx <= sheetObj.LastCol ; colIdx++ ) {
				if ( sheetObj.ColHidden(colIdx) == false ) {
					vShowSheetWidth = vShowSheetWidth + sheetObj.ColWidth(colIdx);
				}
			}

			if ( sheetObj.RowCount >= sheetObj.ViewRows ) {
				vShowSheetWidth = vShowSheetWidth + 20;
			} else {
				vShowSheetWidth = vShowSheetWidth + 10;
			}

			if ( vShowSheetWidth > mainTable.clientWidth-20 ) {
				sheetObj.SheetWidth = mainTable.clientWidth-20;
			} else {
				sheetObj.SheetWidth = vShowSheetWidth;
			}

			/* Button 조정 */
			LseComBtnControl(true, "btn_Save|btns_DownExcel");
		}
	}

	function sheet1_OnChange(sheetObj, Row, Col, Val) {
		var bseQty = ComParseInt(sheetObj.CellValue(sheetObj.HeaderRows, Col));
		var totQty = eval('sheetObj.ComputeSum("|'+Col+'|", sheetObj.HeaderRows+2, sheetObj.LastRow);');
		var qtyGap = totQty-bseQty;

		sheetObj.CellValue2(sheetObj.HeaderRows+1, Col) = qtyGap;

		if ( qtyGap < 0 ) {
			sheetObj.CellFontColor(sheetObj.HeaderRows+1, Col) = sheetObj.RgbColor(255, 0, 0);
			sheetObj.CellFont("FontBold", sheetObj.HeaderRows+1, Col) = true;
		} else if ( qtyGap > 0) {
			sheetObj.CellFontColor(sheetObj.HeaderRows+1, Col) = sheetObj.RgbColor(0, 0, 255);
			sheetObj.CellFont("FontBold", sheetObj.HeaderRows+1, Col) = true;
		} else {
			sheetObj.CellFontColor(sheetObj.HeaderRows+1, Col) = sheetObj.RgbColor(0, 0, 0);
			sheetObj.CellFont("FontBold", sheetObj.HeaderRows+1, Col) = false;
		}
	}

	function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	if ( ErrMsg == "" ) {
    		ComShowCodeMessage("LSE10001");

    		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    	}
    }

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
    	with(formObj){
    		switch(sAction) {
    			case IBSEARCH: //조회
	    			if ( ComGetObjValue(formObj.offh_yrmon) == "" ) {
						//ComShowCodeMessage("LSE01036");
						ComSetFocus(formObj.offh_yrmon);
						return false;
						break;
					}
	    			if ( ComGetObjValue(formObj.offh_rgn_loc_cd) == "" ) {
						//ComShowCodeMessage("LSE01036");
						ComSetFocus(formObj.offh_rgn_loc_cd);
						return false;
						break;
					}
    				return ComChkValid(formObj);
    				break;

    			case IBSAVE: //조회
	    			if ( ComGetObjValue(formObj.offh_yrmon) == "" ) {
						//ComShowCodeMessage("LSE01036");
						ComSetFocus(formObj.offh_yrmon);
						return false;
						break;
					}
	    			if ( ComGetObjValue(formObj.offh_rgn_loc_cd) == "" ) {
						//ComShowCodeMessage("LSE01036");
						ComSetFocus(formObj.offh_rgn_loc_cd);
						return false;
						break;
					}

	    			for ( var i = sheetObj.FrozenCols ; i < (sheetObj.FrozenCols + arrOrgCntrTpSzCd.length) ; i++ ) {
	    				var totQty = ComParseInt(sheetObj.CellValue(sheetObj.HeaderRows+1, i));
	    				if ( totQty != 0 ) {
	    					ComShowCodeMessage("LSE01073", sheetObj.CellValue(0, i), "" + totQty)
	    					return false;
	    					break;
	    				}
	    			}

					return ComChkValid(formObj);
					break;
    		}
    	}

		return true;
	}

	/**
     * Pop-up Open 부분<br>
     * @param type 1:Location for FORM, 2:Agreement No. Selection for FORM, 3:Lessor for FORM
     * @param object 대상 Object
     * @param Row 대상Object가 IBSheet일 경우 해당 Row index
     */
    function openPopup(type, Row, Col) {
    	if ( type == "1" ) {
    		ComOpenPopup('/hanjin/EES_LSE_0046_01.do', 1015, 400, '', '1,0', false, false, Row, Col, 0);
    	} else if ( type == "2" ) {
    		ComOpenPopup('/hanjin/EES_LSE_0020Pop.do?pop_yn=Y', 1015, 600, '', '1,0', false, false, Row, Col, 0);
    	} else if ( type == "3" ) {
    		ComOpenPopup('/hanjin/EES_LSE_0039Pop.do?pop_yn=Y', 1015, 710, '', '1,0', false, false, Row, Col, 0);
    	}
    }
	/* 개발자 작업  끝 */