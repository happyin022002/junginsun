/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_922.js
*@FileTitle : Get Container List Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-08
*@LastModifier : parkyeonjin
*@LastVersion : 1.0
* 2006-11-08 parkyeonjin
* 1.0 최초 생성
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

// 공통전역변수


var sheetObjects = new Array();
var sheetCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		 /*******************************************************/
		 var sheetObject = sheetObjects[0];
		 var formObject = document.form;

		 try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

				case "btn_ok":
					value2Form();
					break;

				case "btn_close":
					window.close();
					break;


			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(ComGetMsg('TES21506')); //ComShowMessage(OBJECT_ERROR);
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
		 var sheetObject = sheetObjects[0];
		 var formObject = document.form;

		for(i=0;i<sheetObjects.length;i++){

		//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);

			initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		initValue();
		doActionIBSheet(sheetObject,formObject,IBSEARCH);
	}



		function initValue(){
			document.form.vndr_seq.value = window.dialogArguments.form.vndr_seq.value;
			document.form.yd_cd		.value = window.dialogArguments.form.yd_cd		.value;

		}

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
					style.height = 240;

					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 2, 1, 9, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(8, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false)

					var HeadTitle = " |Seq.|UOM|Period|Period|Accoumulated Vol|VNDR_SEQ|ACCM_SEQ";
					var HeadTitle1 = " |Seq.|UOM|From|To|Accoumulated Vol|VNDR_SEQ|ACCM_SEQ";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					InitHeadRow(1, HeadTitle1, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtRadioCheck, 20,    daCenter,  true,    "chk");
					InitDataProperty(0, cnt++, dtSeq,        30,    daCenter,  true,    ""							,        false,          "",       dfNone		,    0,     true,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter,  true,    "tml_accm_ut_cd",        false,          "",       dfNone		,    0,     true,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter,  true,    "accm_fm_dt"		,        false,          "",       dfDateYmd,    0,     true,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter,  true,    "accm_to_dt"		,        false,          "",       dfDateYmd,    0,     true,       true);
					InitDataProperty(0, cnt++, dtData,      120,    daCenter,  true,    "pay_vol_qty"		,        false,          "",       dfInteger,    0,     true,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter,  true,    "vndr_seq"			,        false,          "",       dfNone		,    0,     true,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter,  true,    "accm_seq"			,        false,          "",       dfNone		,    0,     true,       true);

					//RangeBackColor(1,3,1,5) = RgbColor(222, 251, 248);   // ENIS

					//DoSearch("UI_ESD_TES_922_2DATA.html");
			   }
				break;
		}
	}



  // Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;

		switch(sAction) {

		   case IBSEARCH:      //저장
                formObj.f_cmd.value = SEARCH;
		          	var searchXml = sheetObj.GetSearchXml("ESD_TES_9220GS.do",  tesFrmQryStr(formObj));
								sheetObj.RemoveAll();
								//ComShowMessage(searchXml);
								if (searchXml != "") sheetObj.LoadSearchXml(searchXml,true);

				break;

		}
	}


   /**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
//            if (!isNumber(iPage)) {
//
//                return false;
//            }
		}

		return true;
	}

	/**
	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
	 */
	function sheet_OnSearchEnd(sheetObj,errMsg){
		if(errMsg!=null){
			ComShowMessage(errMsg);
		}
	}


	function value2Form(){
		if(sheetObjects[0].RowCount > 0){
			if(sheetObjects[0].CheckedRows("chk") < 1){
				ComShowMessage(ComGetMsg('TES22008')); //ComShowMessage("선택된 데이터가 없습니다.");
				return false;
			}
			for(var i=sheetObjects[0].HeaderRows ; i<sheetObjects[0].HeaderRows + sheetObjects[0].RowCount; i++){
				if(sheetObjects[0].CellValue(i, "chk")){
					window.dialogArguments.form.pay_vol_qty.value = sheetObjects[0].CellValue(i, "pay_vol_qty");
					window.dialogArguments.form.accm_seq		.value = sheetObjects[0].CellValue(i, "accm_seq"	 );
				}
			}
		}
		window.close();
	}