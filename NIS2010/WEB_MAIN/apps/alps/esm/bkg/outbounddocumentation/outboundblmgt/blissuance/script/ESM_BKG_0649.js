/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0649.js
 *@FileTitle : Cancel Issue Release
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.20
 *@LastModifier : 이진서
 *@LastVersion : 1.0
 * 2009.07.20 이진서
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
 * @class ESM_BKG_0649 : ESM_BKG_0649 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0649() {
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
var URL_ESM_BKG = 'ESM_BKG_0649GS.do';
var prefix1 = "sheet1_";
var prefix2 = "sheet2_";
var prefix3 = "sheet3_";
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
	var formObj = document.form;	
	initControl();
	for (i = 0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	initComboSetVal(sheetObjects[0], formObj);
	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
}
/**
 * 초기 컨트롤 설정하기 
 **/
function initControl() {
	DATE_SEPARATOR = "-";	//** Date 구분자 **/
	var formObj = document.form;
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', formObj); // -
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', formObj); // -
	axon_event.addListenerFormat('keypress', 'obj_keypress', formObj); // -
	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObj); //- 키보드 입력할때
	axon_event.addListener('keydown', 'check_Enter', 'form');
	/*	
	 * 1. B/L Collection, Save, Confirm 비활성화
	 * 2. B/L No가 있는 Pop-up 상태로 열린 경우 조회를 실행한다.
	 */
	//ComBtnDisable("btn_Save");
	//ComBtnDisable("btn_Confirm");
}

/**
 * 콤보 데이타를 가져온다.
 **/
function initComboSetVal(sheetObj, formObj) {
	ComSetObjValue(formObj.f_cmd, SEARCHLIST01);
	var param = FormQueryString(formObj);
	param = param + "&cm_code=CD01648";
	var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
	var arrXml = sXml.split("|$$|");
	if (arrXml[0].length > 0) {
		ComXml2ComboItem(arrXml[0], formObj.bl_riss_rsn_cd, "val", "name");
	}
}
/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	var sheetID = sheetObj.id;

	switch (sheetNo) {
	case 1: //t1sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 0;
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
			InitColumnInfo(10, 0, 0, true);
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)
			var HeadTitle1 = "|||||||";
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,
			// SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP,
			// ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, prefix1 + "ibflag");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "bkg_no");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "bl_no");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "bl_tp_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "shipper_code");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "shipper_name");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "obl_iss_knt");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "obl_srnd_flg");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "obl_iss_flg");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "do_yn");
			CountPosition = 0;
		}
		break;
	case 2: //t1sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 0;
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
			InitColumnInfo(7, 0, 0, true);
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)
			var HeadTitle1 = "|||||||";
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,
			// SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP,
			// ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, prefix2 + "ibflag");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix2 + "bkg_no");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix2 + "his_seq");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix2 + "bkg_evnt_knd_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix2 + "riss_flg");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix2 + "bl_riss_rsn_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix2 + "riss_rsn");
			CountPosition = 0;
		}
		break;
	case 3: //sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 82;
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
			InitRowInfo(1, 1, 15, 100);
			var HeadTitle1 = "||No|Office|By|Date|";
			var headCount = ComCountHeadTitle(HeadTitle1);
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(7, 0, 0, true);
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,
			// SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
			// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE,
			// TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, prefix3 + "ibflag");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix3 + "his_seq");
			InitDataProperty(0, cnt++, dtData, 60,  daCenter, true, prefix3 + "iss_rdem_knt", false, "", dfInteger, 0, true, true, 1, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, prefix3 + "evnt_ofc_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, prefix3 + "evnt_usr_id", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtPopup, 0,  daCenter, true, prefix3 + "evnt_dt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix3 + "obl_rdem_cfm_flg");
			PopupImage = "img/btns_calendar.gif";
			ShowButtonImage = 1;
			CountPosition = 0;
			DataLinkMouse(prefix3 + "evnt_dt") = true;
			InitDataValid(0, prefix3 + "evnt_ofc_cd"			, vtEngUpOther, "0123456789");
			InitDataValid(0, prefix3 + "evnt_usr_id"			, vtEngUpOther, "0123456789");
		}
		break;
	}

}

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];

	/** **************************************************** */
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		//유효성 체크 
		if(!processValidate(srcName)) return; 

		switch (srcName) {

			case "btn_Retrieve":
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
				break;
	
			case "btn_Save":
				doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
				break;
	
			case "btn_Confirm":
				
				if(ComGetObjValue(formObj.frm_sheet1_obl_released_flg)== 'Y' && ComGetObjValue(formObj.frm_sheet1_bl_tp_cd)== 'W' )
				{
					ComSetObjValue(formObj.setupfocoblflag, 'Y');
				}
				doActionIBSheet(sheetObjects[0],document.form,MULTI01);
				break;
	
			case "btn_Close":
				self.close();
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
* processValidate 이벤트 발생 
* param :comObj
*/
function processValidate(_action) {
	var formObj = document.form;

	switch (_action) {
	case "btn_Retrieve":

		break;
	}
	return true;
}			
			
// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	var aryPrefix = new Array(prefix1, prefix2, prefix3);

	// 유효성 검사를 수행한다. 
	if (!validateForm(sheetObj, formObj, sAction)) return;
	
	switch (sAction) {
	
		case IBSEARCH: //조회
	
			//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.				
			ComSetObjValue(formObj.f_cmd, SEARCH);
			ComSetObjValue(formObj.bl_no,ComGetObjValue(formObj.frm_sheet1_bl_no));
			ComSetObjValue(formObj.bkg_no,ComGetObjValue(formObj.frm_sheet1_bkg_no));
		
			// 2.조회조건으로 조회실행
			var sXml = sheetObj.GetSearchXml(URL_ESM_BKG, FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));

			//ComResetAll();
			// 3.조회후 결과처리
			var arrXml = sXml.split("|$$|");
			var State = ComGetEtcData(arrXml[0],"TRANS_RESULT_KEY");
			if ( State == "S" ) {
				for ( var inx = 0; inx < arrXml.length; inx++) {
					sheetObjects[inx].LoadSearchXml(arrXml[inx]);
				}	
				//1. 기본정보무조건보여주세요  by 신자영 10.19 
				if (IBS_CopyRowToForm(sheetObjects[0], formObj, 1, "frm_")) {
				}
				;
				fnOnSearchEnd();
				
			}else{
				fnExceptionMessage(sXml);
			}

			break;
	
		case IBSAVE: //저장

			if (!ComShowConfirm(ComGetMsg("BKG00824"))) {//"Do you want to Save your Changes?";
				return;
			}
				
			//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.				
			ComSetObjValue(formObj.f_cmd, MULTI);
			
			ComSetObjValue(formObj.bkg_no,ComGetObjValue(formObj.frm_sheet1_bkg_no));	
			// select box :  bl_riss_rsn_cd 		
			ComSetObjValue(formObj.frm_sheet2_bl_riss_rsn_cd,ComGetObjValue(formObj.bl_riss_rsn_cd));
			//sheet에 변경된값 셋팅하기
			if (IBS_CopyFormToRow(formObj, sheetObjects[1], 1, "frm_")) {}
			// 2.저장조건으로 실행
			var sParam = ComGetSaveString(sheetObjects); // 변경된 sheet문자열;
			sParam += "&" + FormQueryString(formObj); // hidden param value 문자열
			sParam += "&" + ComGetPrefixParam(aryPrefix);// prefix 문자열 배열

			var sXml = sheetObj.GetSaveXml(URL_ESM_BKG, sParam);
			var State = ComGetEtcData(sXml,"TRANS_RESULT_KEY");
			
			if ( State == "S" ) {
				// 3.저장후 결과처리
				sheetObj.LoadSaveXml(sXml);
				ComShowMessage(ComGetMsg("BKG06071"));
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			}else{
				fnExceptionMessage(sXml);
			}
			break;
			
		case MULTI01: // 확인 		
	
			if (!ComShowConfirm(ComGetMsg("BKG00618"))) {//"Would you really want to confirm?";
			return;
			}
			//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.				
			ComSetObjValue(formObj.f_cmd, MULTI01);
			ComSetObjValue(formObj.bkg_no,ComGetObjValue(formObj.frm_sheet1_bkg_no));	
			// select box :  bl_riss_rsn_cd 		
			ComSetObjValue(formObj.frm_sheet2_bl_riss_rsn_cd,ComGetObjValue(formObj.bl_riss_rsn_cd));
			//sheet에 변경된값 셋팅하기
			if (IBS_CopyFormToRow(formObj, sheetObjects[1], 1, "frm_")) {}
			// 2.저장조건으로 실행
			var sParam = ComGetSaveString(sheetObjects); // 변경된 sheet문자열;
			sParam += "&" + FormQueryString(formObj); // hidden param value 문자열
			sParam += "&" + ComGetPrefixParam(aryPrefix);// prefix 문자열 배열
		
			var sXml = sheetObj.GetSaveXml(URL_ESM_BKG, sParam);
			var State = ComGetEtcData(sXml,"TRANS_RESULT_KEY");
			if ( State == "S" ) {
				sheetObj.LoadSaveXml(sXml);
				rValueClose();
			}else{
				fnExceptionMessage(sXml);
			}
			break;
		}
}
/**
* rValueSave 
* 결과값을 리턴 
*/
function rValueClose() {
	var formObj = document.form;
	if('Y' == ComGetObjValue(formObj.isPopUp)){
		var obj = new Object();
		obj.msg="OK";
		window.returnValue = obj;//retVal 변수값 설정.
		self.close();
	}else{
		ComShowMessage("Data confirm Successfully !");
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
}
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	var sheetObject2 = sheetObjects[2];
	
	switch (sAction) {
		case IBSEARCH: // search 
			// bl번호 필요존재
			if (ComGetObjValue(formObj.frm_sheet1_bkg_no) == '' && ComGetObjValue(formObj.frm_sheet1_bl_no)  == '') {
				return false;
			}
			// bl번호가 다르면 조회가 가능하다.
			if(ComGetObjValue(formObj.bl_no).substring(0, 12) != ComGetObjValue(formObj.frm_sheet1_bl_no)){
				return true;
			}

			break;
			
		case IBSAVE: // save
		
			/*
			"1. BKG or B/L no 입력 여부 체크
			2. BKG no 또는 B/L no로  호출. 둘다 입력된 경우 B/L no 우선
			3. Surrender 여부 체크
			4. Issue 여부 체크
			5. D/O 발행 여부 체크
			<EXCEPTION>
			1. 둘다 입력이 안된 경우 메시지 [BKG00445] 표시 후 리턴
			3. Surrender 인 경우 메세지 [BKG00457] 표시 후 조회가 안되게 한다.
			4. Issue가 안되었으면  메세지 [BKG00478] 표시 후 조회가 안되게 한다.
			5. D/O가 발행 되었으면  메세지 [BKG00434] 표시 후 조회 안되게 한다."
			*/

			if (ComGetObjValue(formObj.frm_sheet1_bl_no) == '') {
				ComShowCodeMessage("BKG00445");
				ComSetFocus(formObj.frm_sheet1_bl_no);
				return false;
			}
			if (ComGetObjValue(formObj.frm_sheet1_bkg_no) == ''|| ComGetObjValue(formObj.frm_sheet1_bl_no) == '') {
				ComShowCodeMessage("BKG00445");
				return;
			}
			if( ComGetObjValue(formObj.bl_no).substring(0, 12) != ComGetObjValue(formObj.frm_sheet1_bl_no)){
				ComShowCodeMessage("BKG00012");
				return false;
			}
			if (ComGetObjValue(formObj.frm_sheet1_obl_srnd_flg) != '' && ComGetObjValue(formObj.frm_sheet1_obl_srnd_flg).toUpperCase() == 'Y') {
				ComShowCodeMessage("BKG00457");
				return false;
			}
			if (ComGetObjValue(formObj.frm_sheet1_obl_iss_flg) != '' && ComGetObjValue(formObj.frm_sheet1_obl_iss_flg).toUpperCase() != 'Y') {
				ComShowCodeMessage("BKG00478");
				return false;
			}
			if (ComGetObjValue(formObj.frm_sheet1_do_yn) != '' && ComGetObjValue(formObj.frm_sheet1_do_yn).toUpperCase() == 'Y') {
				ComShowCodeMessage("BKG00434");
				return false;
			}
	
			var rCnt = sheetObject2.RowCount;
			for (i = 1; i <= rCnt; i++) {
				sheetObject2.CellValue2(i, prefix3 + "obl_rdem_cfm_flg") = "N";
			}
			break;
		
		case MULTI01: // confirm
			/*
				1. Reason이 Change, Amend/Switch, Damaged이면 Issue Count와 Collect count 합계를 비교
				<EXCEPTION>
				1.a 다를 경우 메시지 [BKG00454] 표시후 리턴
			*/
			
			/*
			"1. BKG or B/L no 입력 여부 체크
			2. BKG no 또는 B/L no로  호출. 둘다 입력된 경우 B/L no 우선
			3. Surrender 여부 체크
			4. Issue 여부 체크
			5. D/O 발행 여부 체크
			<EXCEPTION>
			1. 둘다 입력이 안된 경우 메시지 [BKG00445] 표시 후 리턴
			3. Surrender 인 경우 메세지 [BKG00457] 표시 후 조회가 안되게 한다.
			4. Issue가 안되었으면  메세지 [BKG00478] 표시 후 조회가 안되게 한다.
			5. D/O가 발행 되었으면  메세지 [BKG00434] 표시 후 조회 안되게 한다."
			*/
			if( ComGetObjValue(formObj.bl_no).substring(0, 12) != ComGetObjValue(formObj.frm_sheet1_bl_no)){
				ComShowCodeMessage("BKG00012");
				return false;
			}
			if (ComGetObjValue(formObj.frm_sheet1_bkg_no) == ''|| ComGetObjValue(formObj.frm_sheet1_bl_no) == '') {
				ComShowCodeMessage("BKG00445");
				return;
			}
			if (ComGetObjValue(formObj.frm_sheet1_bl_no) == '') {
				ComShowCodeMessage("BKG00445");
				ComSetFocus(formObj.frm_sheet1_bl_no);
				return false;
			}
			if (ComGetObjValue(formObj.frm_sheet1_obl_srnd_flg) != '' && ComGetObjValue(formObj.frm_sheet1_obl_srnd_flg).toUpperCase() == 'Y') {
				ComShowCodeMessage("BKG00457");
				return false;
			}
			if (ComGetObjValue(formObj.frm_sheet1_obl_iss_flg) != '' && ComGetObjValue(formObj.frm_sheet1_obl_iss_flg).toUpperCase() != 'Y') {
				ComShowCodeMessage("BKG00478");
				return false;
			}
			if (ComGetObjValue(formObj.frm_sheet1_do_yn) != '' && ComGetObjValue(formObj.frm_sheet1_do_yn).toUpperCase() == 'Y') {
				ComShowCodeMessage("BKG00434");
				return false;
			}
			
			var Index_Code = ComGetObjValue(formObj.bl_riss_rsn_cd);
			// Print fail/ cancle/ lost 인경우 pass
			if (!(rIndex_Code == 'P' || rIndex_Code == 'C' || rIndex_Code == 'L')) {
				
				if(!fn_buttonChange()){
					return false;
				}
				
				// 저장하기 위해 , 모두 수정상태로 변경
				var collectCount = 0; // Collect count 
				var issueCount = ComGetObjValue(formObj.frm_sheet1_bl_issue_no); // Issue Count
				var cnt = sheetObject2.TotalRows;
				for (i = 1; i <= cnt; i++) {
					collectCount = collectCount + parseInt(sheetObject2.CellValue(i, prefix3 + "iss_rdem_knt"));
				}
				//[합계를 비교]Issue Count와 Collect count 
				if(collectCount != issueCount){
					ComShowCodeMessage("BKG00454");
					return false;
				}

				var rCnt = sheetObject2.RowCount;
				for (i = 1; i <= rCnt; i++) {
					sheetObject2.CellValue2(i, prefix3 + "obl_rdem_cfm_flg") = "Y";
				}
			}
			
		break;
	}
	return true;
}

/**
 * fnOnSearchEnd  조회완료 후 이벤트 발생 
 * param :sheetObj, ErrMsg
 */
function fnOnSearchEnd() {

	var formObj = document.form;

	//FORM VALUE BINDING 
	if (IBS_CopyRowToForm(sheetObjects[1], formObj, 1, "frm_")) {
	}
	;
	var sheetObject2 = sheetObjects[2];
	var cnt = sheetObject2.TotalRows;
	
	// select box :  bl_riss_rsn_cd
	ComSetObjValue(formObj.bl_riss_rsn_cd, ComGetObjValue(formObj.frm_sheet2_bl_riss_rsn_cd));
	
	// 최대3개까지만 표시한다. 
	var limitcnt = 3;
	if (cnt < limitcnt) {
		for (i = cnt; i < limitcnt; i++) {
			var Row = sheetObject2.DataInsert(-1);
			sheetObject2.CellValue2(Row, prefix3 + "iss_rdem_knt") = 0;
		}
	}
	// 저장하기 위해 , 모두 수정상태로 변경 
	for (i = 0; i <= limitcnt; i++) {
		sheetObject2.RowStatus(i)= "U";		
	}

	ComSetObjValue(formObj.bl_no,ComGetObjValue(formObj.frm_sheet1_bl_no));
	
	// B/L Collection 값이 없으면 null로 셋팅한다.[BY 신자영]
	if(cnt == 0) {
		ComSetObjValue(formObj.bl_riss_rsn_cd, '');			// Reason
		ComSetObjValue(formObj.frm_sheet2_riss_rsn, '');	// Remark
	}
}
/** 
 * " Combo 값 변경시 이벤트 함수 
 * bl_riss_rsn_cd  변경시 그리드로 값 셋팅
 * 	1. B/L Type Change(B->W), Amend/Switch, Damaged 일때만 B/L Collection 활성화
 * 	 amend/switch=A  , type change=T , damaged =D
 * @param comboObj, Index_Code, Text
 */
 var rIndex_Code ='';
function bl_riss_rsn_cd_OnChange(comboObj, Index_Code, Text) {
	var formObj = document.form;
	var sheetObject2 = sheetObjects[2];
	
	if(sheetObject2.TotalRows == 0) return;
	if (Index_Code == 'A' || Index_Code == 'D' || Index_Code == 'T') {
		sheetObject2.Editable = true;
		//ComBtnEnable("btn_Save");
		//ComBtnEnable("btn_Confirm");
	} else {
		sheetObject2.Editable = false;
		//ComBtnDisable("btn_Save");
		//ComBtnDisable("btn_Confirm");
	}	

	rIndex_Code = Index_Code;
	
	/*	
	 1. Reason이 B/L Type Change(B->W), Amend/Switch, Damaged 가 아닌 경우 B/L Collection 정보 초기화
	*/
	if (rIndex_Code == 'P' || rIndex_Code == 'C' || rIndex_Code == 'L'){
		
		var limitcnt = 3;
		var cnt = fnNullToBlank(ComGetObjValue(formObj.frm_sheet1_bl_issue_no), 0)// Issue Count	
		if (cnt < limitcnt) {
			for (i = cnt+1; i < limitcnt+1; i++) {
				sheetObject2.CellValue2(i, prefix3 + "iss_rdem_knt") = 0;
				sheetObject2.CellValue2(i, prefix3 + "evnt_ofc_cd") = "";
				sheetObject2.CellValue2(i, prefix3 + "evnt_usr_id") = "";
				sheetObject2.CellValue2(i, prefix3 + "evnt_dt") = "";
			}
		}
	}
}
/**
 * Sheet관련 컬럼 OnKeyUp 엑션 이벤트 처리 
 * @param sheetObj, Row, Col, Value
 */
function sheet3_OnChange(sheetObj, Row, Col, Value) {
	var formObj = document.form;
	if (sheetObj.ColSaveName(Col) == prefix3 + "iss_rdem_knt") {
		var no = sheetObj.CellValue(Row, Col);
		if (parseInt(no) > 0) {
			sheetObj.CellValue2(Row, prefix3 + "iss_rdem_knt") = no;
			sheetObj.CellValue2(Row, prefix3 + "evnt_ofc_cd") = ComGetObjValue(formObj.strOfc_cd);
			sheetObj.CellValue2(Row, prefix3 + "evnt_usr_id") = ComGetObjValue(formObj.strUsr_id);
			sheetObj.CellValue2(Row, prefix3 + "evnt_dt") = ComGetNowInfo();
		}else{
			sheetObj.CellValue2(Row, prefix3 + "evnt_ofc_cd") = "";
			sheetObj.CellValue2(Row, prefix3 + "evnt_usr_id") = "";
			sheetObj.CellValue2(Row, prefix3 + "evnt_dt") = "";
		}
	}
}
/**
* fn_buttonChange에서 버튼 활성여부 
*/
function fn_buttonChange(){
	var formObj = document.form;
	var sheetObj = sheetObjects[2];
	var collectCount = 0; // Collect count 
	var issueCount = fnNullToBlank(ComGetObjValue(formObj.frm_sheet1_bl_issue_no), 0)// Issue Count

	var cnt = sheetObj.TotalRows;
	for (i = 1; i <= cnt; i++) {
		collectCount = collectCount + parseInt(sheetObj.CellValue(i, prefix3 + "iss_rdem_knt"));
	}
	//[합계를 비교]Issue Count와 Collect count 
	if(collectCount != issueCount){
		ComShowCodeMessage("BKG08068");
		return false;
	}
	return true;
}

/**
* fnNullToBlank
* null값인 경우 default값을 return한다.
* param : xval,yval
*/
function fnNullToBlank(xval, yval) {
	return (xval != null && xval != "") ? xval : yval;
}

 /**
  * IBSheet Object에서 팝업을 클릭시
 */
function sheet3_OnPopupClick(sheetObj, Row,Col){
  if (sheetObj.ColSaveName(Col) == prefix3 + "evnt_dt") {
	  var cal = new ComCalendarGrid();
	    cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
	}
}
 
 /*조회조건 에터키 이력시 조회*/
 function check_Enter() {
 	var formObj = document.form;
 	if (event.keyCode == 13) {
 		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
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
 /**
 * fnExceptionMessage 
 */
 function fnExceptionMessage(rXml){
	var formObj = document.form;
 	var rMsg = ComGetEtcData(rXml,"Exception")
 	var rmsg = rMsg.split("<||>");
 	if(rmsg[3] != undefined && rmsg[3].length > 0) {
 		ComShowMessage(rmsg[3]);
 	}else{
 		sheetObjects[0].LoadSaveXml(rXml);
 	}
 	ComResetAll();
	ComSetFocus(formObj.frm_sheet1_bkg_no);
 }
/* 개발자 작업  끝 */