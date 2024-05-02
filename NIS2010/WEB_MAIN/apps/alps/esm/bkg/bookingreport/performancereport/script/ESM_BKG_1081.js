	/*=========================================================
	 *Copyright(c) 2010 CyberLogitec
	 *@FileName : ESM_BKG_1081.js
	 *@FileTitle : Autorating Accuracy Monitoring Report
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2010.02.04
	 *@LastModifier : 김기종
	 *@LastVersion : 1.0
	 * 2010.02.04 김기종
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
	 * @class ESM_BKG_1081 : ESM_BKG_1081 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESM_BKG_1081() {
		this.processButtonClick = processButtonClick;
		this.setSheetObject 	= setSheetObject;
		this.loadPage 			= loadPage;
		this.initSheet 			= initSheet;
		this.initControl 		= initControl;
		this.doActionIBSheet 	= doActionIBSheet;
		this.setTabObject 		= setTabObject;
		this.validateForm 		= validateForm;
	}
	
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var comboObjects = new Array();
	var combo1 = null;
	var comboCnt = 0;
	/* 개발자 작업	*/
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		/*******************************************************/
		var formObject = document.form;
		var bkg_no = "";
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch (srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
					break;
	
				case "btn_New":
					formObject.reset();
					sheetObject1.RemoveAll();
					sheetObject2.RemoveAll();
					break;
	
				case "btn_DownExcel_Summary":
					sheetObject1.SpeedDown2Excel(-1);
					break;
				case "btn_DownExcel_Detail":
					sheetObject2.SpeedDown2Excel(-1);
					break;
				case "auto_rat_cd":
					if (formObject.auto_rat_cd.checked)
					{
						document.all.span_autorated_bl.innerHTML="Autorated B/L List";
					}
					else
					{
						document.all.span_autorated_bl.innerHTML="Non Autorated B/L List";
					}
					break;
					
					
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowCodeMessage("COM12111");
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
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	
	function setComboObject(combo_obj) {
		comboObjects[comboCnt++] = combo_obj;
	}
	
	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		for (i = 0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		initControl();
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
	}
	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 * 
	 * @param {ibsheet}
	 *            sheetObj IBSheet Object
	 * @param {int}
	 *            sheetNo sheetObjects 배열에서 순번
	 */
	function initControl() {
		//** Date 구분자 **/
		DATE_SEPARATOR = "-";
	
		var formObject = document.form;
		// Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerForm('blur', 'obj_deactivate', formObject); //- 포커스 나갈때
		axon_event.addListenerFormat('focus', 'obj_activate', formObject); //- 포커스 들어갈때
		axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	
		combo1 = comboObjects[0];
		comboCnt = comboObjects.length;
	
		// IBMultiCombo초기화
		for ( var k = 0; k < comboObjects.length; k++) {
			initCombo(comboObjects[k]);
		}
	
		ComSetObjValue(formObject.fr_dt, ComGetNowInfo());
		ComSetObjValue(formObject.to_dt, ComGetNowInfo());
	
	}
	
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj, sheetNo) {
	
		var cnt = 0;
		switch (sheetNo) {
			case 1:
				with (sheetObj) {
					// 높이 설정
					style.height = 380;
	
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
	
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "")
						InitHostInfo(location.hostname, location.port, page_path);
	
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msAll;//msPrevColumnMerge; //msNone;
	
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
	
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 5, 100);
	
					var HeadTitle = "No.|Scope|B.OFC|P.OFC|TTL B/L|Rated B/L|Auto|Non|Ratio(%)|||";
					var headCount = ComCountHeadTitle(HeadTitle);
	
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
	
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);
	
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
	
					//데이터속성    [	ROW, COL,  DATATYPE,   		WIDTH, 	DATAALIGN, COLMERGE, SAVENAME,  	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtSeq, 			30, 	daCenter, 	false, 	"no");
					InitDataProperty(0, cnt++, dtData, 			40, 	daCenter, 	false, 	"svc_scp_cd", 	false, "", dfNone, 0, false);
					InitDataProperty(0, cnt++, dtData, 			50, 	daCenter, 	false, 	"bkg_ofc_cd", 	false, "", dfNone, 0, false);
					InitDataProperty(0, cnt++, dtData, 			50, 	daCenter, 	false, 	"region", 		false, "", dfNone, 0, false);
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daRight, 	false, 	"ttl",			false, "", dfNullInteger, 0, false);
					InitDataProperty(0, cnt++, dtAutoSum, 		70, 	daRight, 	false, 	"rate_cnt", 	false, "", dfNullInteger, 0, false);
					InitDataProperty(0, cnt++, dtAutoSum, 		50, 	daRight, 	false, 	"auto_cnt", 	false, "", dfNullInteger, 0, false);
					InitDataProperty(0, cnt++, dtAutoSum, 		50, 	daRight, 	false, 	"non_auto_cnt", 	false, "", dfNullInteger, 0, false);
					InitDataProperty(0, cnt++, dtAutoAvg, 		55, 	daRight, 	false, 	"ratio", 		false, "", dfNullFloat, 2, false);
					
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	"t_ttl", 		false, "", dfNone, 0, false);
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	"t_auto_cnt", 	false, "", dfNone, 0, false);
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	"t_ratio", 		false, "", dfNone, 0, false);
					
					FocusEditMode = -1;
					MultiSelection = false;
					break;
				}
	
			case 2:
				with (sheetObj) {
					// 높이 설정
	
					style.height = 380;
	
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
	
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "")
						InitHostInfo(location.hostname, location.port, page_path);
	
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msAll;//msPrevColumnMerge; //msNone;  msHeaderOnly;
	
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
	
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 5, 100);
	
					var HeadTitle = "No|BKG No|Scope|S/C No|Change History|Rater|Office";
					var headCount = ComCountHeadTitle(HeadTitle);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
	
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, false, true, false, false);
	
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
	
					//데이터속성    [	ROW, COL,  DATATYPE,   		WIDTH, 	DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtSeq, 			30, 	daCenter, 	false, 	"no");
					InitDataProperty(0, cnt++, dtData, 			85, 	daCenter, true, "bkg_no", 		false, "", dfNone, 0, false);
					InitDataProperty(0, cnt++, dtHidden, 		100, 	daCenter, false, "svc_scp_cd", 	false, "", dfNone, 0, false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daCenter, false, "sc_no", 		false, "", dfNone, 0, false);
					InitDataProperty(0, cnt++, dtData, 			250, 	daLeft, 	false, 	"change_history",false, "", dfNone, 0, false);
					InitDataProperty(0, cnt++, dtData, 			60, 	daLeft, false, "rater", 		false, "", dfNone, 0, false);
					InitDataProperty(0, cnt++, dtData, 			45, 	daCenter, false, "rater_ofc", 	false, "", dfNone, 0, false);
					
					break;
				}
		}
	}
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
		switch (sAction) {
			case IBCLEAR: // 화면 로딩시 코드 조회
				formObj.f_cmd.value = INIT;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_1081GS.do", FormQueryString(formObj));
	
				var arrXml = sXml.split("|$$|");
				ComXml2ComboItem(arrXml[0], formObj.region, "val", "val");
				
				if (arrXml.length > 0){
					ComXml2ComboItem(arrXml[0], formObj.region, "val", "val");
				}
				
				if (arrXml.length > 1)
					ComXml2ComboItem(arrXml[1], formObj.ctrt_cd, "val", "name");
				
				formObj.region.Index =0; 
				formObj.ctrt_cd.Index =1; 					
									
				break;
			case IBSEARCH: //조회	
				if (validateForm(sheetObj, formObj, sAction)) {
					
					formObj.f_cmd.value = SEARCH01;
					sheetObjects[1].WaitImageVisible = false;
					sheetObjects[0].WaitImageVisible = false;

					sheetObjects[0].RemoveAll();
					sheetObjects[1].RemoveAll();
					
					ComOpenWait(true); //대기이미지 표시
					var sXml = sheetObj.GetSearchXml("ESM_BKG_1081GS.do", FormQueryString(formObj));
					var arrXml = sXml.split("|$$|");
					
//					if (arrXml.length > 1)
//						sheetObjects[1].LoadSearchXml(arrXml[1]);
					if (arrXml.length > 0){
						sheetObjects[0].LoadSearchXml(arrXml[0])
						
						if(sheetObjects[0].Rows > 1){
							var Row = 1;
							if (sheetObjects[0].CellValue(Row, "bkg_ofc_cd") != '' ) {
								ComSetObjValue(formObj.sel_ofc_cd, sheetObjects[0].CellValue(Row, "bkg_ofc_cd"));
								ComSetObjValue(formObj.sel_scp_cd, sheetObjects[0].CellValue(Row, "svc_scp_cd"));
								doActionIBSheet(sheetObjects[1], formObj, IBROWSEARCH);
							}
						}
					}
					ComOpenWait(false); //대기이미지 숨김
				}
				break;
	
			case IBROWSEARCH: //조회
				if (validateForm(sheetObj, formObj, sAction)) {
					formObj.f_cmd.value = SEARCH02;
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true); //대기이미지 표시
					var sXml = sheetObj.GetSearchXml("ESM_BKG_1081GS.do", FormQueryString(formObj));
					//sheetObj.RemoveAll();
	
					var arrXml = sXml.split("|$$|");
					if (arrXml.length > 0)
						sheetObj.LoadSearchXml(arrXml[0]);
					
					ComOpenWait(false); //대기이미지 숨김
					
				}
				break;
	
			case "btn_New":
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
				ComResetAll();
				break;
			case IBDOWNEXCEL: // 다운로드
				sheetObj.SpeedDown2Excel(-1);
				break;
		}
	}
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction) {
		with (formObj) {
			switch (sAction) {
				case IBSEARCH: // 조회시 확인
					if (!ComChkValid(formObj))
						return false;
	
					if (!ComIsNull(formObj.fr_dt) && !ComIsNull(formObj.to_dt) && ComGetDaysBetween(formObj.fr_dt.value, formObj.to_dt.value) > 31) {
						ComShowCodeMessage("BKG50469");//Can't Input Date Over 31 days!
						formObj.fr_dt.focus();
						return false;
					}
					
					if ( ComGetObjValue(formObj.svc_scp_cd) == "" 
						&& ComGetObjValue(formObj.sc_no)=="" 
							&& ComGetObjValue(formObj.bkg_ofc_cd)=="" 
								&& formObj.region.index < 1) {
       	
 			  			ComShowCodeMessage('BKG00626', '\n\n[Region,SVC Scope,S/C No,Booking Office] , One must have value');
 			  			return false;
 			  		}
					break;
			}
		}
		return true;
	}
	
	/**
	 * 콤보 초기설정값
	 * @param {IBMultiCombo} comboObj  comboObj
	 */
	function initCombo(comboObj) {
		comboObj.DropHeight = 150;
	}
	
	
	/**
	 * from,to 기간 선택 달력 띄우기
	 */
	function callDatePop(val) {
		var cal = new ComCalendarFromTo();
		if (val == 'BKG_DATE') {
			cal.select(form.fr_dt, form.to_dt, 'yyyy-MM-dd');
		}
	
	}
	function sheet1_OnClick(sheetObj, Row, Col, Value) {
		var formObj = document.form;
	
		if (sheetObj.CellValue(Row, "bkg_ofc_cd") != '' ) {
			ComSetObjValue(formObj.sel_ofc_cd, sheetObj.CellValue(Row, "bkg_ofc_cd"));
			ComSetObjValue(formObj.sel_scp_cd, sheetObj.CellValue(Row, "svc_scp_cd"));
			doActionIBSheet(sheetObjects[1], formObj, IBROWSEARCH);
		}
	}
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var dataRowCnt = 0;
    	with(sheetObj){
    		SumText(0, "no") = "";
    		SumText(0, "region") = "Total";
    		SumText(0, "ratio") =  EtcData("t_ratio"); //ComRound(SumText(0, "auto_cnt") / SumText(0, "ttl") * 100,2);
    	}
	}	
	function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
		comBkgIndicateLink(sheetObj,"bkg_no");
 		ComOpenWait(false); //대기이미지 숨김
  	}
	
	function sheet2_OnDblClick(sheetObj,rowIdx,colIdx) {
		var colName = sheetObj.ColSaveName(colIdx);
		if (colName == "bkg_no"){
			comBkgCallBkgDetail(sheetObj.CellValue(rowIdx, colName));
 		}
  	}    
	
	
	/* 개발자 작업  끝 */