/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0771.js
 *@FileTitle : Covered B/L
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.08
 *@LastModifier : 이진서
 *@LastVersion : 1.0
 * 2009.07.08 이진서
 * 1.0 Creation
 * -----------------------------------------------------------
 * History
 * 2011.04.18 이일민 [CHM-201110112] BKG HISTORY 추가 요청 - bill type change 
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
 * @class ESM_BKG_0771 : ESM_BKG_0771 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0771() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업	*/

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var URL_ESM_BKG = 'ESM_BKG_0771GS.do';
var prefix = "sheet1_";
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {	
	if (document.form.bkg_no.value == ''||document.form.bl_no.value == '') {
		ComShowCodeMessage("BKG00463");// 조회를 위한 BKG no가 없습니다.
		self.close();
	}
	for (i = 0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;
	switch (sheetID) {
	case "sheet1": //sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 225;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(4, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			var HeadTitle = "|Covered B/L No";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 40, daCenter, true, prefix + "ibflag");
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "bl_no", false, "", dfNone, 0, true, true, 12, false);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "bkg_no");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "old_bl_no");
			CountPosition = 0;

			InitDataValid(0, prefix + "bl_no", vtEngUpOther, "1234567890");
		}
		break;

	}
}

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	/** **************************************************** */
	var formObj = document.form;
	// BL검증이 끝나면 모두 12자리로 변환시킨다.
	if (ComGetObjValue(formObj.bl_no).length > 12) {
		ComSetObjValue(formObj.bl_no, ComGetObjValue(formObj.bl_no).substr(0, 12));
	}
	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_add":
			/*//caf인경우 삭제할수 없다. 
			if('Y' == ComGetObjValue(formObj.caflag) ){
				ComShowCodeMessage("BKG08157");
				return;
			}
			*/
			var tcnt = sheetObject1.TotalRows;
			if (tcnt > 0) {
				var Row = sheetObject1.LastRow;
				var bl_no = sheetObject1.CellValue(Row, prefix + "bl_no");
				if (typeof bl_no != "undefined" && bl_no != "") {
					sheetObject1.DataInsert(-1);
				}
			} else {
				sheetObject1.DataInsert(-1);
			}
			break;

		case "btn_delete":
			/*//caf인경우 삭제할수 없다. 
			if('Y' == ComGetObjValue(formObj.caflag) ){
				ComShowCodeMessage("BKG08157");
				return;
			}*/
			var sRow = sheetObject1.SelectRow;
			sheetObject1.RowHidden(sRow) = true; // 2.행 숨기기
			sheetObject1.RowStatus(sRow) = "D"; // 3.트랜잭션 상태 "삭제"로 만들기
			break;

		case "btn_save":

			var cnt = sheetObject1.LastRow;
			var tmp_bl_no, comp_bl_no;
			var comp1_bl_no = ComGetObjValue(formObj.bl_no);

			for ( var i = 1; i <= cnt; i++) {
				var ibflag = sheetObject1.CellValue(i, prefix + "ibflag");
				if (ibflag == 'D')
					continue;
				tmp_bl_no = sheetObject1.CellValue(i, prefix + "bl_no");

				for ( var j = 1; j <= cnt; j++) {
					comp_bl_no = sheetObject1.CellValue(j, prefix + "bl_no");
					if (i != j && tmp_bl_no == comp_bl_no) {
						ComShowCodeMessage("BKG95007");
						sheetObject1.SelectCell(j, prefix + "bl_no");
						return false;
					}
				}
				if (comp1_bl_no == tmp_bl_no) {
					ComShowCodeMessage("BKG08060");
					sheetObject1.SelectCell(i, prefix + "bl_no");
					return false;
				}
			}

			doActionIBSheet(sheetObject1, formObj, IBSAVE);
			break;

		case "btn_close":
			rValueClose();
			break;

		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * rValueSave 
 * 결과값을 리턴 
 */
var okSAVE = '';
function rValueClose() {
	var formObj = document.form;
	if ('Y' == okSAVE) {
		var obj = new Object();
		obj.msg = "OK";
		window.returnValue = obj;// retVal 변수값 설정.
	}
	self.close();
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	var aryPrefix = new Array("sheet1_");

	switch (sAction) {

	case IBSEARCH: //조회
		if (validateForm(sheetObj, formObj, sAction))
		// 1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
		ComSetObjValue(formObj.f_cmd, SEARCH);
		// 2.조회조건으로 조회실행
		sheetObj.DoSearch(URL_ESM_BKG, FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));

		break;

	case IBSAVE: //저장
	
	if (!validateForm(sheetObj, formObj, sAction))
			return;
		// 1.저장전 파라미터를 입력하거나 선택된 값으로 설정해준다.
		ComSetObjValue(formObj.f_cmd, MULTI);

		// 2.저장조건으로 실행
		var sParam = ComGetSaveString(sheetObjects); // 변경된 sheet문자열
		if (sParam == ""){
			ComShowMessage(ComGetMsg("BKG00743"));return;
		}
			

		if (!ComShowConfirm(ComGetMsg("BKG00824")))
			return; // Are you sure to save the changes?

		sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix); // hidden

		var sXml = sheetObj.GetSaveXml(URL_ESM_BKG, sParam);
		//sheetObj.LoadSaveXml(sXml);

		var State = ComGetEtcData(sXml,"TRANS_RESULT_KEY");
		if ( State == "S" ) {
			okSAVE='Y';
			ComShowMessage(ComGetMsg("BKG06071"));
		}else{
			fnExceptionMessage(sXml);
		}
		doActionIBSheet(sheetObj, document.form, IBSEARCH); // unique key 값을얻어오기위해서
		break;

	case IBINSERT: // 입력
		break;

	}
}

/**
 * t10sheet2_OnSearchEnd  조회완료 후 이벤트 발생 
 * param :sheetObj, ErrMsg
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	 var l_row = sheetObj.RowCount;
	 var formObj = document.form;
	//BDR FLAG 에 따른 활성,비활성 처리 
	 if (('Y' == ComGetObjValue(formObj.bdrflag) && 'N' == ComGetObjValue(formObj.caflag)) ||
		  'Y' == ComGetObjValue(formObj.caflag)) {
		 ComBtnDisable("btn_add");
	 	 ComBtnDisable("btn_save");
	 	 ComBtnDisable("btn_delete");
	 }else{
		 ComBtnEnable("btn_add");
		 ComBtnEnable("btn_save");
		 ComBtnEnable("btn_delete");
	 }
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {

		// 저장시 유효성검사 
		if (sAction == IBSAVE) {
			var sObject = sheetObj;
			var c_row = sheetObj.RowCount;
			//var c_row = sheetObj.LastRow;
			if (c_row == 0) {
				//"There is no updated data to save."
				ComShowMessage(ComGetMsg("BKG00743"));
				return false;
			}
			for ( var row = 1; row <= c_row; row++) {
				if ( sheetObj.RowHidden(row)) continue;
				var v_bl_no = sheetObj.CellValue(row, prefix + "bl_no");
				if (v_bl_no == '') {
					sheetObj.RowHidden(row) = true; // 2.행 숨기기
					sheetObj.RowStatus(row) = "D"; // 3.트랜잭션 상태 "삭제"로 만들기
				}
			}
			// 검색시 유효성검사
		} else if (sAction == IBSEARCH) {

		}
	}
	return true;
}

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}
 /**
 * fnExceptionMessage  
 * 에러처리 메세지 Alert
 * @param 
 * @return 
 */
 function fnExceptionMessage(rXml){
 	var rMsg = ComGetEtcData(rXml,"Exception")
 	var rmsg = rMsg.split("<||>");
 	if(rmsg[3] != undefined && rmsg[3].length > 0) {
 		ComShowMessage(rmsg[3]);
 	}else{
 		sheetObjects[0].LoadSaveXml(rXml);
 	}
 }
/* 개발자 작업  끝 */