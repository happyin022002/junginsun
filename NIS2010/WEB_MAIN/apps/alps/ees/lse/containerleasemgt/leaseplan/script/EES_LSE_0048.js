/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_lse_0048.js
*@FileTitle : Long Term Lease CNTR Delivery Plan
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.04.27 노정용
* 1.0 Creation
* =======================================================
* 2010.09.17 남궁진호 [CHM-201006061-01] 
*            L/T Lease CNTR Delivery Plan Data 체크시 pln_yr 조건이 빠져 발생항 오류 수정
* 2010.12.03 [CHM-201007443-01] 남궁진호 Ref No 항목 추가*   
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
	 * @class ees_lse_0048 : ees_lse_0048 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ees_lse_0048() {
		this.processButtonClick		= processButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initControl			= initControl;
		this.obj_blur				= obj_blur;
		this.obj_focus				= obj_focus;
		this.obj_change				= obj_change;
		this.obj_keypress			= obj_keypress;
		this.obj_keyup				= obj_keyup;
		this.initSheet 				= initSheet;
		this.doActionIBSheet 		= doActionIBSheet;
		this.sheet1_OnScrollNext	= sheet1_OnScrollNext;
		this.sheet1_OnChange        = sheet1_OnChange;
		this.sheet1_OnPopupClick	= sheet1_OnPopupClick;
		this.sheet1_OnSaveEnd	    = sheet1_OnSaveEnd;
		this.sheet1_OnSearchEnd	    = sheet1_OnSearchEnd;
		this.checkDupData			= checkDupData;
		this.openPopup				= openPopup;
		this.setPopData_Agreement	= setPopData_Agreement;
		this.setPopData_DeliveryLoc	= setPopData_DeliveryLoc;
		this.validateForm 			= validateForm;
		this.clearForm 				= clearForm;
	}

	/* 개발자 작업	*/
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var LONG_TERM_CD = "LT";
	var AGMT_REG_CNT = 0;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		/*******************************************************/
		var formObj = document.form;

     	//try {
 			var srcName = window.event.srcElement.getAttribute("name");

 			switch(srcName) {
 				case "btn_Retrieve":
 					doActionIBSheet(sheetObject1, formObj, IBSEARCH);
 					break;

 				case "btn_New":
					ComResetAll();

					/* 조회 전 데이터 가공 방지를 위한 버튼 콘트롤 */
					LseComBtnControl(false, "btn_RowAdd|btn_Delete|btn_LoadExcel|btn_DownExcel");

					/* Excel Upload 사용여부 초기화 */
					ComSetObjValue(formObj.excel_flg, "N");

					ComSetFocus(formObj.pln_yr);
 					break;

 				case "btn_Save":
 					if ( ComShowCodeConfirm("COM12147", "Long Term Container Delivery Plan") ) {
 						doActionIBSheet(sheetObject1, formObj, IBSAVE);
 					}
 					break;

 				case "btn_RowAdd":
 					if ( ComIsBtnEnable(srcName) ) {
 						//if ( sheetObjects[0].SearchRows < 1 ) {
 						if ( sheetObjects[0].RowCount < 1 ) {
 							doActionIBSheet(sheetObject1, formObj, IBSEARCH_ASYNC02);
 							if ( AGMT_REG_CNT > 0 ) {
 								ComShowCodeMessage("LSE01055");
 								AGMT_REG_CNT = 0;
 								return;
 							}
 						}
 						doActionIBSheet(sheetObject1, formObj, IBINSERT);
 					} else {
 						ComSetFocus(formObj.pln_yr);
 					}
 					break;

 				case "btn_Delete":
 					if ( ComIsBtnEnable(srcName) ) {
 						ComRowHideDelete(sheetObject1, "del_chk");
 					} else {
 						ComSetFocus(formObj.pln_yr);
 					}
 					break;

 				case "btn_LoadExcel":
 					if ( ComIsBtnEnable(srcName) ) {
 						doActionIBSheet(sheetObject1, formObj, IBLOADEXCEL);
 					} else {
 						ComSetFocus(formObj.pln_yr);
 					}
 					break;

 				case "btn_DownExcel":
 					if ( ComIsBtnEnable(srcName) ) {
 						sheetObject1.SpeedDown2Excel(-1);
 					} else {
 						ComSetFocus(formObj.pln_yr);
 					}
					break;

 				case "btns_search1":
 					openPopup("1");
 					break;

 			} // end switch
     	//}catch(e) {
     	//	if( e == "[object Error]") {
     	//		ComShowMessage(OBJECT_ERROR);
     	//	} else {
     	//		ComShowMessage(e);
     	//	}
     	//}
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
    	 var formObj = document.form;
    	 
    	 for ( var i = 0 ; i < sheetObjects.length ; i++ ) {

 			//khlee-시작 환경 설정 함수 이름 변경
 			ComConfigSheet (sheetObjects[i] );

 			initSheet(sheetObjects[i],i+1);
 			
 			//khlee-마지막 환경 설정 함수 추가
 			ComEndConfigSheet(sheetObjects[i]);
 		 }
    	 
    	 /* Axon Control Setting*/
    	 initControl();

    	 /* 조회 전 데이터 가공 방지를 위한 버튼 콘트롤 */
    	 LseComBtnControl(false, "btn_RowAdd|btn_Delete|btn_LoadExcel|btn_DownExcel");
     }

  	// Axon 이벤트 처리
  	// 1. 이벤트catch
  	function initControl() {
  		var formObj = document.form;
  		axon_event.addListenerFormat('blur',		'obj_blur',		formObj); //- 포커스 나갈때
		axon_event.addListenerFormat('focus',		'obj_focus',	formObj); //- 포커스 들어갈때
  		axon_event.addListenerFormat('keypress',	'obj_keypress',	formObj); //- 키 눌렸을때
		axon_event.addListenerFormat('keyup',		'obj_keyup',	formObj); //- 키 올라올때
		axon_event.addListenerFormat('keydown',		'obj_keydown',	formObj); //- 키 눌렸을때
		axon_event.addListenerForm('change',   	'obj_change',  	formObj); //- 변경될때.
  	}

  	// 2. 이벤트처리함수 -- Start
  	/**
	 * HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
	 **/
	function obj_blur(){
		var obj = event.srcElement;

	    switch(obj.name){
	    	case "pln_yr":
	        case "agmt_seq":
	        case "mft_vndr_seq":
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
		var obj = event.srcElement;

	    if( obj.readOnly ) {
	    	ComSetNextFocus(obj);
	    } else {
	    	//마스크구분자 없애기
		    ComClearSeparator(obj);
	    }
	}

	function obj_change(){
		var obj = event.srcElement;
		var formObj = document.form;

  		switch(obj.name) {
  			case "pln_yr":
  				if ( sheetObjects[0].SearchRows > 0 ) {
  					sheetObjects[0].RemoveAll();

					/* 조회 전 데이터 가공 방지를 위한 버튼 콘트롤 */
					LseComBtnControl(false, "btn_RowAdd|btn_Delete|btn_LoadExcel|btn_DownExcel");

					ComSetFocus(formObj.pln_yr);
  				}
				break;
			case "agmt_seq":
				if ( ComTrim(obj.value) != "" ) {
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
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
  		var obj     = event.srcElement;
  		var formObj = document.form;

  		switch(obj.name) {
  			case "pln_yr":
  				ComKeyEnter('LengthNextFocus');
  				break;

  			case "agmt_seq":
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
   			ComSetNextFocus(obj);
   			if ( ComGetObjValue(formObj.lstm_cd) == LONG_TERM_CD ) {
   				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
			}
   		}
   	}
  	//2. 이벤트처리함수 -- End

	/**
	 * 시트 초기설정값, 헤더 정의. 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 * @param sheetObj
	 * @param sheetNo 시트오브젝트 태그의 아이디에 붙인 일련번호
	 */
	function initSheet(sheetObj,sheetNo) {

 		var cnt = 0;
 		var sheetid = sheetObj.id;

 		switch(sheetid){
 			case "sheet1":
 				with (sheetObj) {
 					// 높이 설정
 					style.height = 420;

 					//전체 너비 설정
 					SheetWidth = sheetTable.clientWidth;

 					//Host정보 설정[필수][HostIp, Port, PagePath]
 					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

 					//전체Merge 종류 [선택, Default msNone]
 					MergeSheet = msHeaderOnly;

 					//전체Edit 허용 여부 [선택, Default false]
 					Editable = true;

 					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 					InitRowInfo(1, 1, 3, 100);

 					var HeadTitle1 = "|Sel.|Seq.|Year|Plan Seq.|AGMT No.|AGMT No.|Ref No.|Delivery LOC\n(SCC)|TP/SZ|Delivery\nMonth|Q'ty|Vendor Seq.|Remark";
 					var headCount = ComCountHeadTitle(HeadTitle1);

 					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 					InitColumnInfo(headCount, 0, 0, true);

 					// 해더에서 처리할 수 있는 각종 기능을 설정한다
 					InitHeadMode(true, true, false, true, false,false)

 					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 					InitHeadRow(0, HeadTitle1, true);

					// 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,	40,		daCenter,	true,	"del_chk");
					InitDataProperty(0, cnt++ , dtDataSeq,		50,		daCenter,	true,	"Seq");
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	"pln_yr",		true,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,	"pln_seq",		false,	"",	dfNone,			0,	false,	false);

					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	"agmt_cty_cd",	true,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"agmt_seq",		true,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,	"ref_no",		false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtPopupEdit,	110,	daCenter,	true,	"del_cd",		true,	"",	dfNone,			0,	true,	true,	5);
					InitDataProperty(0, cnt++ , dtCombo,		60,		daCenter,	true,	"cntr_tpsz_cd",	true,	"",	dfNone,			0,	true,	true,   2);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	"de_yrmon",		true,	"",	dfDateYm,		0,	true,	true);

					InitDataProperty(0, cnt++ , dtData,			60,		daRight,	false,	"de_qty",		true,	"",	dfNullInteger,	0,	true,	true,	6);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	false,	"mft_vndr_seq",	true,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		    200,	daLeft,		false,	"pln_rmk",	    false,	"",	dfNone,			0,	true,	true,	1000);

					InitDataValid(0, "del_cd",  vtEngUpOnly);
					InitDataValid(0, "pln_rmk", vtEngOther,   "0123456789-,.() ");

					//ShowButtonImage = 1;

 					//CountFormat = "[SELECTDATAROW / TOTALROWS]";
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
	function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
		switch(sAction) {
			case IBCREATE:	//Container Type/Size Grid Combo Item Setting
				sheetObj.WaitImageVisible = false;

				ComSetObjValue(formObj.f_cmd, SEARCH02);
				var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",FormQueryString(formObj));
				if ( sXml != "" ) {
					sheetObj.InitDataCombo(0, "cntr_tpsz_cd", ComGetEtcData(sXml, "cntr_tpsz_nm"), ComGetEtcData(sXml, "cntr_tpsz_cd"));
				}

				/* Excel Upload 사용여부 초기화 */
				ComSetObjValue(formObj.excel_flg, "N");

				/* 초기 Focus Setting */
		    	ComSetFocus(formObj.pln_yr);

				break;
         
			case IBSEARCH:			//조회
				if(validateForm(sheetObj,formObj,sAction)) {
					if ( sheetObj.id == "sheet1") {
						ComSetObjValue(formObj.f_cmd, SEARCH);
						sheetObj.WaitImageVisible = false;
						ComOpenWait(true);
						sheetObj.DoSearch4Post("EES_LSE_0048GS.do",FormQueryString(formObj));
						ComOpenWait(false);
					}
				}
				break;

			case IBSEARCHAPPEND:	//조회(페이징처리)
				if ( sheetObj.id == "sheet1") {
					ComSetObjValue(formObj.f_cmd, SEARCH);
					sheetObj.DoSearch4Post("EES_LSE_0048GS.do", CondParam, "iPage=" + PageNo, true);
				}
				break;

			case IBINSERT:			// 입력
				if(validateForm(sheetObj,formObj,sAction)) {
					if ( sheetObj.id == "sheet1") {
						var Row = sheetObj.DataInsert(-1);
						sheetObj.CellValue2(Row,"pln_yr")       = ComGetObjValue(formObj.pln_yr);
						//sheetObj.CellValue2(Row,"agmt_no")      = ComGetObjValue(formObj.agmt_cty_cd)+ComLpad(ComGetObjValue(formObj.agmt_seq), 6, "0");
						sheetObj.CellValue2(Row,"agmt_cty_cd")  = ComGetObjValue(formObj.agmt_cty_cd);
						sheetObj.CellValue2(Row,"agmt_seq")     = ComGetObjValue(formObj.agmt_seq);
						sheetObj.CellValue2(Row,"mft_vndr_seq") = ComGetObjValue(formObj.mft_vndr_seq);
						sheetObj.CellValue2(Row,"ref_no") = ComGetObjValue(formObj.ref_no);
						sheetObj.SelectCell(Row,"del_cd");
					}
				}
				break;

			case IBSAVE:			//저장
				if ( validateForm(sheetObj,formObj,sAction) ) {
					if ( sheetObj.id == "sheet1") {
						if (sheetObj.IsDataModified == true) {
							ComSetObjValue(formObj.f_cmd, MULTI);
							var sParam = FormQueryString(formObj);
							var sSheetParam = ComSetPrifix(sheetObj.GetSaveString(), "sheet1_");
							sParam = sParam + "&" + sSheetParam;
							//sheetObj.DoSave("EES_LSE_0048GS.do",FormQueryString(formObj));
							var sXml = sheetObj.GetSaveXml("EES_LSE_0048GS.do" , sParam);
							sheetObj.LoadSaveXml(sXml);
						} else {
							//ComShowCodeMessage("COM130503");
							ComShowMessage(sheetObj.MessageText("UserMsg13"));
						}
					}
				}
				break;

			case IBSEARCH_ASYNC01:	//조회(Form Agreement No. 입력시)
 				if(validateForm(sheetObj,formObj,sAction)) {
 					if ( sheetObj.id == "sheet1") {
 						ComSetObjValue(formObj.f_cmd, SEARCH03);
 						sheetObj.WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",FormQueryString(formObj));
						sheetObj.WaitImageVisible = true;

						if ( sXml != "" ) {
							if ( ComGetEtcData(sXml, "lstm_cd") != undefined ) {
								if ( ComGetEtcData(sXml, "lstm_cd") == LONG_TERM_CD ) {
									ComSetObjValue(formObj.mft_vndr_seq, ComGetEtcData(sXml, "vndr_seq"));
									ComSetObjValue(formObj.mft_vndr_nm,  ComGetEtcData(sXml, "vndr_nm"));
									ComSetObjValue(formObj.lstm_cd,      ComGetEtcData(sXml, "lstm_cd"));
									ComSetObjValue(formObj.ref_no,      ComGetEtcData(sXml, "ref_no"));
								} else {
									ComShowCodeMessage("LSE01057");
									clearForm("agmt_seq");
									ComSetFocus(formObj.agmt_seq);
								}
							} else {
								var errMsg = LseComGetErrMsg(sXml);
								if ( errMsg != "" ) {
									ComShowMessage(errMsg);
								}
								clearForm("agmt_seq");
								ComSetFocus(formObj.agmt_seq);
							}
						}
 					}
				}
				break;
			
			case IBSEARCH_ASYNC02:	//조회(Agreement No. 등록여부)
				if(validateForm(sheetObj,formObj,sAction)) {
					if ( sheetObj.id == "sheet1") { //2010.09.16 pln_yr 조건 누락분 추가
						var param = "f_cmd="+SEARCH01+
									"&pln_yr="+ComGetObjValue(formObj.pln_yr)+
						            "&agmt_cty_cd="+ComGetObjValue(formObj.agmt_cty_cd)+
						            "&agmt_seq="+ComGetObjValue(formObj.agmt_seq);
 						sheetObj.WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("EES_LSE_0048GS.do",param);
						sheetObj.WaitImageVisible = true;

						if ( sXml != "" ) {
							if ( ComGetEtcData(sXml, "agmt_cnt") != undefined ) {
								AGMT_REG_CNT = ComGetEtcData(sXml, "agmt_cnt")
							} else {
								var errMsg = LseComGetErrMsg(sXml);
								if ( errMsg != "" ) {
									ComShowMessage(errMsg);
								}
								ComSetFocus(formObj.agmt_seq);
							}
						}
					}
				}
				break;

			case IBLOADEXCEL://EXCEL UPLOAD
				if ( ComShowCodeConfirm("LSE01138") ) {
					var uploadFlag = sheetObj.LoadExcel(-1, 1, "", "-1", "-1", "", false);
					if ( uploadFlag ) {
						/* Execl Upload 된 Data. All Data Delete 후 Insert 처리해야함. */
						ComSetObjValue(formObj.excel_flg, "Y");
	
						var plnYr   = ComGetObjValue(formObj.pln_yr);
						var agmtSeq = ComTrim(ComGetObjValue(formObj.agmt_seq));
						var rgbCd   = sheetObj.RgbColor(255, 0, 0);

						for ( var i = sheetObj.HeaderRows ; i <= sheetObj.LastRow ; i++ ) {
							// Plan Year 비교
							if ( sheetObj.CellValue(i, "pln_yr") != plnYr ) {
								sheetObj.CellFont("FontColor", i, "pln_yr") = rgbCd;
								sheetObj.CellFont("FontBold", i, "pln_yr")  = true;
							} else {
								sheetObj.CellFont("FontColor", i, "pln_yr") = sheetObj.DataFontColor;
								sheetObj.CellFont("FontBold", i, "pln_yr")  = false;
							}
								
							// Agreement Seq. 비교
							if ( sheetObj.CellValue(i, "agmt_seq") != agmtSeq ) {
								sheetObj.CellFont("FontColor", i, "agmt_seq") = rgbCd;
								sheetObj.CellFont("FontBold", i, "agmt_seq")  = true;
							} else {
								sheetObj.CellFont("FontColor", i, "agmt_seq") = sheetObj.DataFontColor;
								sheetObj.CellFont("FontBold", i, "agmt_seq")  = false;
							}
	
							sheetObj.CellValue2(i,"mft_vndr_seq") = ComGetObjValue(formObj.mft_vndr_seq);
						}

						// Duplicate Data
						checkDupData2(sheetObj);
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
	 * Sheet의 OnChange Event 처리부분.<br>
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
	 */
	function sheet1_OnChange(sheetObj, Row, Col, Value)  {
		var formObj = document.form;

		with(sheetObj) {
			var sName = ColSaveName(Col);

			switch(sName) {
				case "del_cd":		// Grid Location Code Check
					if ( CellValue(Row,Col) != "" ) {
						var param = "f_cmd="  + SEARCH05
 								 + "&loc_cd=" + CellValue(Row,Col)
 								 + "&loc_tp=SCC";
						WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",param);
 						WaitImageVisible = true;

 						if ( sXml != "" ) {
		 					if ( ComGetEtcData(sXml, "scc_cd") != undefined ) {
				 				if ( ComGetEtcData(sXml, "scc_cd") != "" ) {
				 					CellValue2(Row,Col)  = ComGetEtcData(sXml, "scc_cd");
		 						} else {
		 							ComShowCodeMessage("LSE01037");
		 							CellValue2(Row,Col) = "";
		 						}
 							} else {
 								var errMsg = LseComGetErrMsg(sXml);
 								if ( errMsg != "" ) {
 									ComShowMessage(errMsg);
 								}
 								CellValue2(Row,Col) = "";
 								SelectCell(Row,Col);
 							}
 						}
					}
					break;
			}
 		}
 	}

 	/**
 	 * Sheet의 OnPopupClick Event 처리부분.<br>
 	 * @param sheetObj
 	 * @param Row
 	 * @param Col
 	 */
    function sheet1_OnPopupClick(sheetObj,Row,Col)
    {
 		with(sheetObj) {
			var sName = ColSaveName(Col);

			switch (sName) {
				// Delivery Location Pop-up
				case "del_cd":
					openPopup("3", Row, Col);
					break;
			}
 		}
    }

    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	if ( ErrMsg == "" ) {
    		ComShowCodeMessage("LSE10001");

    		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    	}
    }
    
    function sheet1_OnSearchEnd(sheetOjb, ErrMsg) {
    	var formObj = document.form;

    	if ( ErrMsg == "" ) {
	    	/* 조회 후 데이터 가공을 위한 버튼 콘트롤 */
	    	LseComBtnControl(true, "btn_RowAdd|btn_Delete|btn_LoadExcel|btn_DownExcel");
	
	    	/* Excel Upload 사용여부 초기화 */
			ComSetObjValue(formObj.excel_flg, "N");
    	}
    }

    function checkDupData2(sheetObj) {
    	with(sheetObj) {
    		var resultRow = ColValueDupRows("pln_yr|agmt_cty_cd|agmt_seq|del_cd|cntr_tpsz_cd|de_yrmon",false,true); //중복결과
    		var baseRowColor   = RgbColor(255,255,0); // Yellow
    		var dupRowColor    = RgbColor(0,255,0);   // Green
    		var editRowColor   = EditableColor;
    		var unEditRowColor = UnEditableColor;

			for ( var i = sheetObj.HeaderRows ; i <= sheetObj.LastRow ; i++ ) {
				if ( CellBackColor(i, "del_cd") != editRowColor ) {
					for ( var j = 0 ; j <= sheetObj.LastCol ; j++ ) {
						if ( CellEditable(i, j) ) {
							CellBackColor(i, j) = editRowColor;
						} else {
							CellBackColor(i, j) = unEditRowColor;
						}
					}
				}
			}

    		if ( resultRow != "" ) {
    			var arrResultRow  = resultRow.split("|");       //중복결과 array
				var arrBaseRow    = arrResultRow[0].split(","); //중복 기준열 index array
				var arrDupRow     = arrResultRow[1].split(","); //중복열 index array

				for ( var i = 0 ; i < arrBaseRow.length ; i++ ) {
					RowBackColor(arrBaseRow[i]) = baseRowColor;
				}
				for ( var i = 0 ; i < arrDupRow.length ; i++ ) {
					RowBackColor(arrDupRow[i]) = dupRowColor;
				}

    			return false;
    		} else {
    			return true;
    		}
    	}
    }

    /**
 	 * Sheet의 duplicate Data check 부분.<br>
 	 * @param sheetObj
 	 */
    function checkDupData(sheetObj) {
    	with(sheetObj) {
    		var resultRow = ColValueDupRows("pln_yr|agmt_cty_cd|agmt_seq|del_cd|cntr_tpsz_cd|de_yrmon",false,true); //중복결과

			//중복결과가 있을 경우
			if ( resultRow != "" ) {
				var arrResultRow  = resultRow.split("|");       //중복결과 array
				var arrBaseRow    = arrResultRow[0].split(","); //중복 기준열 index array
				var arrDupRow     = arrResultRow[1].split(","); //중복열 index array
				var realDupRowIdx = "";                         //공백제거 후 중복열 결과 Row index

				//공백인 Row Filtering
				for ( var baseIdx = 0 ; baseIdx < arrBaseRow.length ; baseIdx++ ) {
					if ( CellValue(arrBaseRow[baseIdx],"pln_yr")       != "" 
					  && CellValue(arrBaseRow[baseIdx],"agmt_cty_cd")  != ""
					  && CellValue(arrBaseRow[baseIdx],"agmt_seq")     != ""
					  && CellValue(arrBaseRow[baseIdx],"del_cd")       != ""
					  && CellValue(arrBaseRow[baseIdx],"cntr_tpsz_cd") != ""
					  && CellValue(arrBaseRow[baseIdx],"de_yrmon")     != "" ) {
						//중복 기준열 = 중복 열 인 경우 Filtering
						for ( var dupIdx = 0 ; dupIdx < arrDupRow.length ; dupIdx++ ) {
							if ( CellValue(arrDupRow[dupIdx],"pln_yr")       == CellValue(arrBaseRow[baseIdx],"pln_yr")
							  && CellValue(arrDupRow[dupIdx],"agmt_cty_cd")  == CellValue(arrBaseRow[baseIdx],"agmt_cty_cd")
							  && CellValue(arrDupRow[dupIdx],"agmt_seq")     == CellValue(arrBaseRow[baseIdx],"agmt_seq")
							  && CellValue(arrDupRow[dupIdx],"del_cd")       == CellValue(arrBaseRow[baseIdx],"del_cd")
							  && CellValue(arrDupRow[dupIdx],"cntr_tpsz_cd") == CellValue(arrBaseRow[baseIdx],"cntr_tpsz_cd")
							  && CellValue(arrDupRow[dupIdx],"de_yrmon")     == CellValue(arrBaseRow[baseIdx],"de_yrmon") ) {
								if ( realDupRowIdx == "" ) {
									realDupRowIdx = arrDupRow[baseIdx];
								} else {
									realDupRowIdx =  realDupRowIdx + "," + arrDupRow[baseIdx];
								}
							}
						}
					} else if ( RowStatus(arrBaseRow[baseIdx]) == "I" ) {
						RowDelete(arrBaseRow[baseIdx]);
					}
				}
	
				//공백인 Row Filtering 후 실데이터가 있는 Row가 있다면 메세지 후 삭제
				if ( realDupRowIdx != "" ) {
					ComShowCodeMessage("LSE01031");
					ColumnSort("pln_yr|agmt_cty_cd|agmt_seq|del_cd|cntr_tpsz_cd|de_yrmon|de_qty","ASC|ASC|ASC|ASC|ASC|ASC|ASC");
					/*
					if ( ComShowCodeConfirm("LSE01031") ) {
						arrRealDupRowIdx = realDupRowIdx.split(",");
						for ( var i = 0 ; i < arrRealDupRowIdx.length ; i++ ) {
							RowBackColor(arrRealDupRowIdx[i]) = RgbColor(255,0,0);
						}
					}
					*/
					return false;
				}
			}
    	}

    	return true;
    }
    
    /**
     * Pop-up Open 부분<br>
     * @param type 1:Agreement No. Popup for FORM, 3:Location Popup for GRID
     * @param Row 대상Object가 IBSheet일 경우 해당 Row index
     * @param Col 대상Object가 IBSheet일 경우 해당 Col index
     */
    function openPopup(type, Row, Col) {
    	if ( type == "1" ) {
    		ComOpenPopup('/hanjin/EES_LSE_0091.do', 805, 450, 'setPopData_Agreement', '1,0', true);
    	} else if ( type == "3" ) {
    		ComOpenPopup('/hanjin/COM_ENS_051.do', 800, 430, 'setPopData_DeliveryLoc', '1,0,1,1,0,0,0,0', false, false, Row, Col, 0);
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
	    	if ( aryPopupData[0][6] == LONG_TERM_CD ) {
	    		ComSetObjValue(formObj.agmt_seq,     aryPopupData[0][4]);
	    		ComSetObjValue(formObj.mft_vndr_seq, aryPopupData[0][7]);
	    		ComSetObjValue(formObj.mft_vndr_nm,  aryPopupData[0][8]);
	    		ComSetObjValue(formObj.lstm_cd,      aryPopupData[0][6]);
	    	} else {
	    		ComShowCodeMessage("LSE01057");
	    		clearForm("agmt_seq");
	    	}
    	}
    }

	/**
	 * Location Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param 대상IBSheet의 Sheet Array index
	 */
	function setPopData_DeliveryLoc(aryPopupData, Row, Col, sheetIdx) {
		if ( aryPopupData.length > 0 ) {
			with(sheetObjects[sheetIdx]) {
				var sName = ColSaveName(Col);

				switch(sName) {
					case "del_cd":
						//CellValue2(Row, sName) = aryPopupData[0][10]; //SCC
						CellValue2(Row, sName) = aryPopupData[0][8]; // 2009.10.13 SCC
						break;
				}
			}
		}
	}

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 */
	function validateForm(sheetObj,formObj,sAction){
   		switch(sAction) {
   			case IBSEARCH:      //조회
   			case IBINSERT:		//Row Add
   			case IBSEARCH_ASYNC02:
				if ( ComGetObjValue(formObj.pln_yr) == "" ) {
					ComShowCodeMessage("LSE01036");
					ComSetFocus(formObj.pln_yr);
					return false;
					break;
				}
				if ( ComGetObjValue(formObj.agmt_seq) == "" ) {
					ComShowCodeMessage("LSE01006");
					ComSetFocus(formObj.agmt_seq);
					return false;
					break;
				}
				return ComChkValid(formObj);
   				break;

   			case IBSAVE:
   				for ( var i = sheetObj.HeaderRows ; i <= sheetObj.LastRow ; i++ ) {
   					var plnYr   = ComGetObjValue(formObj.pln_yr);
   					var agmtSeq = ComTrim(ComGetObjValue(formObj.agmt_seq));
   					var rgbCd   = sheetObj.RgbColor(255, 0, 0);

   					for ( var i = sheetObj.HeaderRows ; i <= sheetObj.LastRow ; i++ ) {
   						// Plan Year 비교
   						if ( sheetObj.CellValue(i, "pln_yr") != plnYr ) {
   							sheetObj.CellFont("FontColor", i, "pln_yr") = rgbCd;
   							sheetObj.CellFont("FontBold", i, "pln_yr")  = true;
   							ComShowCodeMessage("LSE01137");
   							return false;
   						} else {
							sheetObj.CellFont("FontColor", i, "pln_yr") = sheetObj.DataFontColor;
							sheetObj.CellFont("FontBold", i, "pln_yr")  = false;
   						}
   						// Agreement Seq. 비교
   						if ( sheetObj.CellValue(i, "agmt_seq") != agmtSeq ) {
   							sheetObj.CellFont("FontColor", i, "agmt_seq") = rgbCd;
   							sheetObj.CellFont("FontBold", i, "agmt_seq")  = true;
   							ComShowCodeMessage("LSE01039");
   							return false;
   						} else {
							sheetObj.CellFont("FontColor", i, "agmt_seq") = sheetObj.DataFontColor;
							sheetObj.CellFont("FontBold", i, "agmt_seq")  = false;
   						}
   					}
   				}

   				if ( !checkDupData2(sheetObj) ) {
   					ComShowCodeMessage("LSE01031");
   					return false;
   				}
   				break;
   		}
/*
	    with(sheetObj) {
    		switch(sAction) {
	    		case IBSAVE:
	    			return checkDupData(sheetObj);
	    			break;
    		}
    	}
*/
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
			case "agmt_seq":
				ComSetObjValue(formObj.agmt_seq,     "");
				ComSetObjValue(formObj.mft_vndr_seq, "");
				ComSetObjValue(formObj.mft_vndr_nm,  "");
				ComSetObjValue(formObj.lstm_cd,      "");
				break;
		}
	}
	/* 개발자 작업  끝 */