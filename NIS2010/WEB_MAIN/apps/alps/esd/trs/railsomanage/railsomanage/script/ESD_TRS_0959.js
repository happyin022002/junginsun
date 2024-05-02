/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0959.js
*@FileTitle : Cancel REQ Reject Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2006-02-06
*@LastModifier : kim_sang_geun
*@LastVersion : 1.0
* 2006-11-23 kim_sang_geun
* 1.0 최초 생성
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/**
 * @class ESD_TRS_0959 : Rail Billing Cancel Request Reject
 */
function ESD_TRS_0959() {
    this.processButtonClick     = processButtonClick;
    this.setSheetObject         = setSheetObject;
    this.setComboObject         = setComboObject;
    this.setTabObject           = setTabObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;        
    this.initControl            = initControl;
    this.initTab                = initTab;
    this.doActionIBSheet        = doActionIBSheet;
    this.validateForm           = validateForm;
}
/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/

/* 공통전역변수 */
var sheetObjects = new Array();
var sheetCnt = 0;
var openobjsheet = window.dialogArguments.sheetObjects[0];

/**
 * IBSheet Object를 배열로 등록
 * comSheetObject(id)에서 호출한다
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	IBS_Sheet1SheetStatus(openobjsheet, sheetObjects[0]);
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
	var cnt = 0;
	switch(sheetNo) {
		case 1:      //t1sheet1 init
			with (sheetObj) {
				style.height=GetSheetHeight(6);
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1,10, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(16, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false)

				var HeadTitle = "Seq.|Cargo|Booking\nNumber|Booking\nNumber|Container\nNumber|Type/\nSize|Status|Rail Origin|Rail Destination|Cancel Request\nReason|Cancel Request\nReject Reason" ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtSeq, 30, daCenter, true, "seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "cgo_tp_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "bkg_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 30, daCenter, true, "bkg_no_split", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "eq_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "eq_tpsz_cd", false, "", dfNone, 0, false, false);																				 
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "status", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "fm_nod_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "to_nod_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 120, daCenter, true, "cxl_rqst_rsn", false, "", dfNone, 0, false, false);
				
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "cxl_rqst_rjct_rsn", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, true, "trsp_so_ofc_cty_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, true, "trsp_so_seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "cop_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "cost_act_grp_seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "ibflag");
			}
		break;
	}
}

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	
	/*******************************************************/
	var formObject = document.form;
	
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		
		switch(srcName) {
		
			case "btn_ok":
				doActionIBSheet(sheetObject,formObject,IBSAVE);
			break;
			
			case "btn_close":
				window.close();
			break;
		} // end switch
	} catch(e) {
		if( e == "[object Error]") {
			errMsg = ComGetMsg("TRS90106");
			ComShowMessage(errMsg);
		} else {
			ComShowMessage(e);
		}
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {

		case IBSAVE:        //저장
			if(validateForm(sheetObj,formObj,sAction)) {
				formObj.f_cmd.value = MULTI01;
				sheetObj.DoSave("ESD_TRS_0959GS.do", TrsFrmQryString(formObj), "chk1", false, true);
			}
		break;
	}
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	for( var i = 0; i < sheetObj.RowCount; i++ ) {
		var doRsn = doSepRemove(sheetObj.CellValue(i+1, "cxl_rqst_rjct_rsn"), " ");
		if( doRsn == "" ) {
			errMsg = ComGetMsg("TRS90092");
			ComShowMessage(errMsg);
			return false;
		}
	}
	return true;
}

// body의 데이터를 가지고 온다.
function IBS_Sheet1SheetStatus(fromSheet, toSheet)  {
	//함수 인자 유효성 확인
	if( fromSheet.RowCount < 1 ) {
		errMsg = ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	}

	//데이터 행의 개수 확인
	var sRow = fromSheet.FindCheckedRow("chk1");
	var arrRow = sRow.split("|");

	for( var i=0; i<arrRow.length-1; i++ ) {
		toRow = toSheet.DataInsert(-1); //마지막 row밑에 붙이는 경우는 -1, 상단은 0, 아니면 toRow
		toSheet.CellValue2(toRow, "cgo_tp_cd") = fromSheet.CellValue(arrRow[i], "cgo_tp_cd");
		toSheet.CellValue2(toRow, "bkg_no") = fromSheet.CellValue(arrRow[i], "bkg_no");
		toSheet.CellValue2(toRow, "bkg_no_split") = fromSheet.CellValue(arrRow[i], "bkg_no_split");
		toSheet.CellValue2(toRow, "eq_no") = fromSheet.CellValue(arrRow[i], "eq_no");
		toSheet.CellValue2(toRow, "eq_tpsz_cd") = fromSheet.CellValue(arrRow[i], "eq_tpsz_cd");
		toSheet.CellValue2(toRow, "status") = fromSheet.CellValue(arrRow[i], "status");
		toSheet.CellValue2(toRow, "fm_nod_cd") = fromSheet.CellValue(arrRow[i], "fm_nod_cd")+fromSheet.CellValue(arrRow[i], "fm_nod_yard");
		toSheet.CellValue2(toRow, "to_nod_cd") = fromSheet.CellValue(arrRow[i], "to_nod_cd")+fromSheet.CellValue(arrRow[i], "to_nod_yard");
		toSheet.CellValue2(toRow, "cxl_rqst_rsn") = fromSheet.CellValue(arrRow[i], "cxl_rqst_rsn");
		toSheet.CellValue2(toRow, "cxl_rqst_rjct_rsn") = fromSheet.CellValue(arrRow[i], "cxl_rqst_rjct_rsn");
		toSheet.CellValue2(toRow, "trsp_so_ofc_cty_cd") = fromSheet.CellValue(arrRow[i], "trsp_so_ofc_cty_cd");
		toSheet.CellValue2(toRow, "trsp_so_seq") = fromSheet.CellValue(arrRow[i], "trsp_so_seq");
		toSheet.CellValue2(toRow, "cop_no") = fromSheet.CellValue(arrRow[i], "cop_no");
		toSheet.CellValue2(toRow, "cost_act_grp_seq") = fromSheet.CellValue(arrRow[i], "cost_act_grp_seq");
	}
}

/**
 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSaveEnd에서 정의
 */
function sheet1_OnSaveEnd(sheetObj,errMsg) {
	if( errMsg.length > 0 ) {
		ComShowMessage(errMsg);
	} else {
		errMsg = ComGetMsg("TRS90040");
		ComShowMessage(errMsg);
		//원본에서 역순으로 특정 상태의 행을 이동한다.
		window.dialogArguments.doSearchPopup();
		window.close();
	}
}