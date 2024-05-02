/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_1074.js
 *@FileTitle : Exchange Rate
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.18
 *@LastModifier : 이진서
 *@LastVersion : 1.0
 * 2009.06.18 이진서
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
 * @class esm_bkg_1074 : esm_bkg_1074 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_1074() {
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
var URL_ESM_BKG = 'ESM_BKG_1074GS.do';
var prefix = "sheet1_";
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {

	if (document.form.bkg_no.value == '') {
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
			InitColumnInfo(6, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			var HeadTitle = "||||";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, "ibflag");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "bkg_no");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cust_tp");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cust_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cust_nm");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "wbl_eml");
			CountPosition = 0;
		}
		break;

	}
}
// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObj = sheetObjects[0];
	/** **************************************************** */
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "pop_shpr":
			var s_cust_cnt_cd = ComGetObjValue(formObj.shpr_cd).substring(0,2) ; 
			var s_cust_seq = ComGetObjValue(formObj.shpr_cd).substring(2,formObj.shpr_cd.length) ; 
			var s_cust_nm = ComGetObjValue(formObj.shpr_nm);
			comBkgCallPop0652('callBack0652', 'S', s_cust_cnt_cd, s_cust_seq);
			break;

		case "pop_fwdr":
			var f_cust_cnt_cd = ComGetObjValue(formObj.fwdr_cd).substring(0,2) ; 
			var f_cust_seq = ComGetObjValue(formObj.fwdr_cd).substring(2,formObj.fwdr_cd.length) ; 
			var f_cust_nm = ComGetObjValue(formObj.fwdr_nm);
			comBkgCallPop0652('callBack0652', 'F', f_cust_cnt_cd, f_cust_seq);
			break;

		case "btn_Authorize":
			doActionIBSheet(sheetObj, formObj, MULTI01);
			break;

		case "btn_Email":
			if (ComIsEmpty(formObj.email_to.value)) {
				ComShowMessage(ComGetMsg("BKG00857"));
				ComSetFocus(formObj.email_to);
				return;
			}
			doActionIBSheet(sheetObj, formObj, MULTI02);
			break;

		case "btn_close":
			window.close();
			break;

		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			bkg_error_alert('processButtonClick', e);
			
		} else {
			alert(e);
		}
	}
}



/**
 * Customer Inquiry 팝업 호출. <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * comBkgCallPop0652(callback_func, bkgCustTpCd, custCntCd, custSeq);
 * </pre>
 * 
 * @param {string}
 *            팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력
 * @return 없음
 * @author 이진서
 * @version 2009.12.24
 */
function comBkgCallPop0652(callback_func, bkgCustTpCd, custCntCd, custSeq) {
	ComOpenPopup("ESM_BKG_0652.do?bkg_cust_tp_cd=" + bkgCustTpCd
			+ "&cust_cnt_cd=" + custCntCd + "&cust_seq=" + custSeq, 900, 690,
			callback_func, "1,0,1,1,1", true);
}


/**
 * Customer Popup에서 전달받은 값 저장 <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * callBack0652(bkgCustTpCd, rArray1, rArray2);
 * </pre>
 * 
 * @param Popup에서
 *            전달받은 값
 * @return 없음
 * @author 이진서
 * @version 2009.12.24
 */
function callBack0652(bkgCustTpCd, rArray1, rArray2, lOfc, lRep){    	
	var formObj = document.form;
	var email = ComGetObjValue(formObj.email_to);
	var f_flg =false; 
	if(rArray2 != null){
		if(email.length>0)email=email+ ";";
		for(i = 0 ; i < rArray2.length ; i++){
			if(rArray2[i][7] == '') continue;
			if(f_flg){
				email= email + ";"+ rArray2[i][7];
			}else{
				email= email + rArray2[i][7]; 
				f_flg = true;
			}
		}
	}
	ComSetObjValue(formObj.email_to, email);
}

 // Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	
		switch (sAction) {

		case IBSEARCH: //조회
			if (validateForm(sheetObj, formObj, sAction))
				ComOpenWait(true);// 대기창 보임
			// 1.Param 변수
			ComSetObjValue(formObj.f_cmd, SEARCH);
			var sParam = FormQueryString(formObj); // hidden param value 문자열

			// 2.조회조건으로 조회실행
			var sXml = sheetObj.GetSearchXml(URL_ESM_BKG, sParam);

			// 3.조회후 결과처리
			var State = ComGetEtcData(sXml, "TRANS_RESULT_KEY");

			if (State == "S") {
				sheetObj.LoadSaveXml(sXml);
				OnSearchEnd(sheetObj);
			} else {
				var rMsg = ComGetEtcData(sXml, "Exception");
				var rmsg = rMsg.split("<||>");
				if (rmsg[3] != '') {
					ComShowMessage(rmsg[3]);
				}
			}
			break;

		case MULTI01: //authorize

			if (ComShowConfirm(ComGetMsg("BKG08110"))) {
				// Are you sure to authorize the printing of Internet O.B/L?) 
				/**
				 * Yes 클릭시 “WEB B/L Print Approved” 라는 Wording을 B/L ISSUE 화면
				 * (UI_BKG-0079-09 ) 에 표시하고, 자동으로 B/L Release 처리 & B/L type “B”
				 * 로 지정함
				 */
				try {
					ComOpenWait(true);// 대기창 보임
					if(!opener) opener = window.dialogArguments; 
					opener.btn_Authorize();
				
					// 버튼비활성화시킴
					
					 ComBtnDisable("btn_Authorize");
					
					ComShowMessage(ComGetMsg("BKG06071"));
					
				} catch (ex) {
					bkg_error_alert('sheet1_OnSearchEnd', ex);
					ComOpenWait(false); // 대기창 사라짐
				}
			
			}

			break;

		case MULTI02: //e-mail

			if (!ComShowConfirm(ComGetMsg("BKG08111")))
				return; // Do you want to send E-mail?
			ComOpenWait(true);// 대기창 보임
			// 1.Param 변수
			ComSetObjValue(formObj.f_cmd, MULTI02);
			var sParam = FormQueryString(formObj); // hidden param value 문자열
			// 2.저장처리
			var sXml = sheetObj.GetSaveXml(URL_ESM_BKG, sParam);
			// 3.저장후 결과처리
			var State = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
			if (State == "S") {
				sheetObj.LoadSaveXml(sXml);
				ComShowMessage(ComGetMsg("BKG00497"));
			} else {
				fnExceptionMessage(sXml);
			}
			break;
		}
	ComOpenWait(false); // 대기창 사라짐
}

/**
* fnExceptionMessage 
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

/**
 * sheet1_OnSearchEnd  조회완료 후 이벤트 발생 
 * param :sheetObj, ErrMsg
 */
function OnSearchEnd(sheetObj) {

	var formObj = document.form;
	var cnt = sheetObj.RowCount;

	try {

		if (cnt > 0) {
			for ( var i = 1; i <= cnt; i++) {

				if (sheetObj.CellValue(i, "cust_tp") == "SHPR") {
					ComSetObjValue(formObj.shpr_cd, sheetObj.CellValue(i, "cust_cd"));
					ComSetObjValue(formObj.shpr_nm, sheetObj.CellValue(i, "cust_nm"));
				}
				if (sheetObj.CellValue(i, "cust_tp") == "FWDR") {
					ComSetObjValue(formObj.fwdr_cd, sheetObj.CellValue(i, "cust_cd"));
					ComSetObjValue(formObj.fwdr_nm, sheetObj.CellValue(i, "cust_nm"));
				}
			}
			ComSetObjValue(formObj.email_to, sheetObj.CellValue(1, "wbl_eml"));
		}

	} catch (ex) {
		bkg_error_alert('sheet1_OnSearchEnd', ex);
	}
}
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		//             if (!isNumber(formObj.iPage)) {
		//                 return false;
		// }
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
  * bkg_error_alert 
  */
 function bkg_error_alert(msg, ex) {
 	ComShowMessage('[ ' + msg + ' ] \n [ ' + ex.name + ' ][ ' + ex.number + ' ][ ' + ex.description + ' ]');
 }
/* 개발자 작업  끝 */