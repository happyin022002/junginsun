/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0233.js
 *@FileTitle : Inbond EDA Adjustment by VVD
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.24  
 *@LastModifier : 김도완
 *@LastVersion : 1.0
 * 2009.07.24 김도완
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
 * @class ESM_BKG-0233 : ESM_BKG-0233 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0233() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

//공통전역변수

var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_retrieve":
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;

		case "btn_New":
			formObject.reset();
			
			//US AMS Main Menu : VVD 입력시
			ComClearManyObjects(document.form.pod_cd,"");
			
			sheetObject.RemoveAll();
			break;

		case "btn_DownExcel":
			sheetObject.SpeedDown2Excel(-1);
			break;

		case "btn_Transmit":
			doActionIBSheet(sheetObjects[0], document.form, MULTI01);
			break;

		case "btn_calendar":
			var cal = new ComCalendarFromTo();
			cal.select(formObject.from_dt, formObject.to_dt, 'yyyy-MM-dd');
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
 * IBSheet Object를 배열로 등록
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

	for (i = 0; i < sheetObjects.length; i++) {

		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
	
	//US AMS Main Menu : VVD 입력시
	/*if (!ComIsNull(document.form.pod_cd))
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);*/
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
	axon_event.addListenerFormat('keypress', 'obj_KeyPress2', formObject); // - 키보드 입력할때
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	switch (sheetNo) {
	case 1: //sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 440;
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
			InitColumnInfo(8, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			var HeadTitle1 = "|Seq.||VVD|POD|MI EDA|SKD ETA|B/L count";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "ibflag");
			InitDataProperty(0, cnt++, dtSeq, 70, daCenter, true, "Seq");
			InitDataProperty(0, cnt++, dtCheckBox, 75, daCenter, true, "chk");
			InitDataProperty(0, cnt++, dtData, 165, daCenter, true, "vvd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "pod", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 165, daCenter, true, "eda_on_mi", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 250, daCenter, true, "eta", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daRight, true, "bl_count", false, "", dfNullInteger, 0, false, false);

			// InitUserFormat2(0, "ETA", "####-##-## ##:##", "-|:" );

		}
		break;

	}
}

//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case IBSEARCH: //조회
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = SEARCH01;

			var sXml = sheetObj.GetSearchXml("ESM_BKG_0233GS.do", FormQueryString(formObj));

			sheetObj.LoadSearchXml(sXml);
		}

		break;
	case MULTI01: // Transmit
		if (validateForm(sheetObj, formObj, sAction)) {

			formObj.f_cmd.value = MULTI01;
			var sParam = ComGetSaveString(sheetObj) + "&" + FormQueryString(formObj);
			var sXml = sheetObj.GetSaveXml("ESM_BKG_0233GS.do", sParam);

			if (sXml.indexOf("<TR-ALL>OK</TR-ALL>") > 0) {
				ComShowCodeMessage('BKG00101'); // EDI 전송이 성공했습니다.
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			} else {
				sheetObj.LoadSaveXml(sXml);
			}
		}
		break;

	case IBINSERT: // 입력
		break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: // 조회
		if (!ComChkRequired(formObj))
			return false;

		if (chkDateTimeValid(formObj.from_dt, "ymd") == "false") {
			return false;
		}
		if (chkDateTimeValid(formObj.to_dt, "ymd") == "false") {
			return false;
		}
		break;
	}
	return true;
}

/**
 * 키보드가 눌릴 때 dataformat으로 세팅하고 엔터키를 누를때 조회한다.
 * @author 김도완.
 * CoBkg.js를 같이 사용하지 못하는 예외상황이 발생하여 따로 구현함.
 * ymd에 대한 포맷에 대한 처리가 예외적.
 */
function obj_KeyPress2(){
	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	var srcName = event.srcElement.getAttribute("name");
	var srcValue = event.srcElement.getAttribute("value");
	switch(event.srcElement.dataformat) {
		case "ymd":
			ComKeyOnlyNumber(event.srcElement);
			if (srcValue.length == 4) {
				event.srcElement.value = srcValue.substring(0,4) + "-"
			}
			if (srcValue.length == 7) {
				event.srcElement.value = srcValue.substring(0,7) + "-"
			}
			break;
		case "ymdhm":
			ComKeyOnlyNumber(event.srcElement);
			if (srcValue.length == 4) {
				document.form.elements[srcName].value = srcValue.substring(0,4) + "-"
			}
			if (srcValue.length == 7) {
				document.form.elements[srcName].value = srcValue.substring(0,7) + "-"
			}
			if (srcValue.length == 10) {
				document.form.elements[srcName].value = srcValue.substring(0,10) + " "
			}
			if (srcValue.length == 13) {
				document.form.elements[srcName].value = srcValue.substring(0,13) + ":"
			}
			break;
		case "ym":
		case "yw":
		case "jumin":
		case "saupja":	//숫자 + "-"
			ComKeyOnlyNumber(event.srcElement, "-"); break;
		case "hms":
		case "hm":		//숫자 + ":"
			ComKeyOnlyNumber(event.srcElement, ":"); 
			if (srcValue.length == 2) {
				event.srcElement.value = srcValue.substring(0,2) + ":"
			}
			break;
		case "yy":		//숫자 + "0"
			ComKeyOnlyNumber(event.srcElement, "0"); break;
		case "int":		//숫자
			ComKeyOnlyNumber(event.srcElement);	break;
		case "float":	//숫자+"."
			ComKeyOnlyNumber(event.srcElement, "."); break;
		case "eng":		//영문 + 숫자
			// 영문은 기본 대문자로 한다.(포멧에 대소문자 구분 + 숫자가 없음)
			ComKeyOnlyAlphabet('uppernum'); break;  
		case "engup":	//영문대문자
			ComKeyOnlyAlphabet('upper'); break;
		case "engdn":	//영문소문자
			ComKeyOnlyAlphabet('upper'); break;
		case "engupspace": //영문대문자 + Space
			if(event.keyCode != 32) {
				ComKeyOnlyAlphabet('uppernum');
			}
			break;
		case "etc": //모든 문자 가능하지만 영문은 대문자로
			if(keyValue >= 97 && keyValue <= 122) {//소문자
				event.keyCode = keyValue + 65 - 97;
			}
			break;
		default: 		//영문 + 숫자
			ComKeyOnlyAlphabet('uppernum'); break;
	}
}

function chkDateTimeValid(obj, gubun) {
	var rtn = "";
	if(gubun == "ymd") {
		var tmp = obj.value.replace('-', '').replace('-', '').replace('/', '').replace('/', '');
		if(tmp.length < 8) {
			//BKG00920, Please enter a valid date format: YYYYMMDD
			ComShowCodeMessage('BKG00920');
			obj.focus();
			return "false";
		}
		var year = parseInt(tmp.substring(0, 4));
		var mon = parseInt(eval(tmp.substring(4, 6))) - 1;
		var days = parseInt(eval(tmp.substring(6, 8)));
		
		d = new Date(year, mon, days);
		
		var yearD = d.getFullYear();
		var monD = d.getMonth();
		var daysD = d.getDate();
		
		if(year != yearD || mon != monD || days != daysD){
			//BKG00714, Please Check Date
			ComShowCodeMessage('BKG00714');
			obj.focus();
			return "false";
		}
		
		var arrDtM = "";
		if(monD+1 < 10) arrDtM = "0"+(monD+1);
		else arrDtM = ""+(monD+1);
		var arrDtD = "";
		if(daysD < 10) arrDtD = "0"+daysD;
		else arrDtD = ""+daysD;
		
		rtn = yearD+"-"+arrDtM+"-"+arrDtD;
	}
	return rtn;
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with(sheetObj) {
		for (var i = 1; i <= RowCount+1; i ++) {
			var etaVal = CellValue(i, "eta");
			if(etaVal.length > 10) {
				etaVal = etaVal.substring(0, 10);
			}
			if (CellValue(i, "eda_on_mi") != etaVal) {
				CellBackColor(i, "Seq") = RgbColor(255, 0, 0);		// 글자는 붉은색
				sheetObj.CellFontColor(i, "eta") = RgbColor(255, 0, 0);
			}
		}
	}
}