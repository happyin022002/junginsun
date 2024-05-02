/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EAD_EAS_COM_0001.js
*@FileTitle : Common Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2007-11-27
*@LastModifier : choice
*@LastVersion : 1.0
* 2007-11-27 choice
* 1.0 최초 생성
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends Bkg
 * @class ESD_EAS_0008 : 예)Drop Off Charge Collection Inqury 조회 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESD_EAS_COM_0001() {
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
var selRow = 0;
var selCol = 0;
var selOfc = "";

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
	for(i=0;i<sheetObjects.length;i++) {

		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	//html컨트롤 이벤트초기화
	initControl();
	
	goSoOfficeCode(sheetObjects[0]);
}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 **/
function initControl() {
    //Axon 이벤트 처리1. 이벤트catch
//		axon_event.addListener  ('keypress', 'engnum_keypress', 'boo_bkg_no', 'vvd_vvd');
//		axon_event.addListener  ('click', 'manual_click', 'manual');    //BKG Creation탭의 manual이 바뀐경우
//		axon_event.addListener  ('keyup', 'bkgno_keyup', 'boo_bkg_no'); //BKG Creation탭의 Booking No가 바뀐경우
//		axon_event.addListenerFormat('blur',    'obj_blur',     form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onblur이벤트에 코드 처리
//		axon_event.addListenerFormat('focus',   'obj_focus',    form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onfocus이벤트에 코드 처리
//		axon_event.addListenerFormat('keypress','obj_keypress', form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리   
//		axon_event.addListener  ('change', 'customer_change', 'cus_cust_nm');     //Cust탭의 Cusromer_nm이 바뀐경우
}

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) {
			case "btn_apply":
				goApply();
			break;
			case "btn_close":
				window.close();
			break;
		} // end switch
	} catch(e) {
		if( e == "[object Error]") {
//			errMsg = getMsg("COM12111");
			ComShowCodeMessage('COM12111');
		} else {
			ComShowMessage(e);
		}
	}
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
                style.height = 280; // 높이 설정
				SheetWidth = mainTable.clientWidth; //전체 너비 설정
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
				MergeSheet = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
				Editable = true; //전체Edit 허용 여부 [선택, Default false]
				
				InitRowInfo( 1, 1, 9, 100); //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitColumnInfo(3, 0, 0, true); //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitHeadMode(true, true, true, true, false,false) // 해더에서 처리할 수 있는 각종 기능을 설정한다
				
				//var HeadTitle = "Seq|Sel.|STS|Office code";
				var HeadTitle = "Seq|Office code";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtSeq, 50, daCenter, false, "seq", false, "", dfNone,0, false, false);
				//InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, true, "chk1");
				//InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "ibflag", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "ofc_cd_name", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daLeft, true, "ofc_cd", false, "", dfNone, 0, false, false);
			}
		break;
	}
}

//라디오 버튼을 클릭시 데이터를 검색한다.
function sheet_OnChange(sheetObj, Row, Col, Value) {
	if( sheetObj.ColSaveName(Col) == "chk1" ) {
		if( Value == "1" ) {
			sheetObj.RowStatus(Row) = "I";
		} else {
			sheetObj.RowStatus(Row) = "R";
		}
	}
	
}

function sheet_OnClick(sheetObj, row, col, newPos){

    selRow = row;
    selCol = col;
    selOfc = sheetObj.CellValue(row, "ofc_cd");
        
}


function sheet_OnDblClick(sheetObj, row, col ){

    selRow = row;
    selCol = col;
    selOfc = sheetObj.CellValue(row, "ofc_cd");
	goApply();

}


function goApply() {

	if( selOfc != "" ) {
		opener.rtn_office_code(selOfc);
		window.close();
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	switch(sAction) {
		case IBSEARCH: //조회 101
			formObj.f_cmd.value = SEARCH03;
			sheetObj.DoSearch4Post("ESD_EAS_COM_0001GS.do", EasFrmQryString(formObj));
		break;
	}
}

function goSoOfficeCode(sheetObj) {
	doActionIBSheet(sheetObj, document.form, IBSEARCH);
}

/**
 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
*/
function sheet_OnSearchEnd(sheetObj,errMsg){
	if(errMsg!=null){
		ComShowCodeMessage(errMsg);
	}
	var lv_ofc = document.form.ctrl_ofc_cd.value;
	var lv_row = sheetObj.FindText("ofc_cd", lv_ofc, 0, -1, false);
	sheetObj.SelectCell(lv_row, "ofc_cd_name", false);
}


/**
 *  Customer Code 공통 팝업 오픈(sheet)
 * 
 * @param sheetObj IBSheet Object
 * @param row Row
 * @param multi multi check 여부
 * @param ofcCd Office Code
 * @param ofcNm Office Name
 * @param callType Call TYpe
 * @param ofcLev Office Level
 * @param ofcPtsCd Parent Office
 */
function openOfcPopSheet(sheetObj, row, multi, ofcCd, ofcNm, callType, ofcLev, ofcPtsCd){
	var formObj = document.form ;
	var param   = "" ;
	var display = getCommPopDisplay(multi) ;
	
	ofcLevFld   = ofcLev ;
	ofcPtsCdFld = ofcPtsCd ;
	ofcCdFld    = ofcCd ;
	ofcNmFld    = ofcNm ;
	callTypeFld = callType ;
	multiChkYN  = multi ;
	sheetRow    = row ;	
	sheetObject = sheetObj ;	
	
	param  = "?classId=" + getCommPopClassId() ;
	param += getURLParam(multi, "ofc_lev",    ofcLev) ;
	param += getURLParam(multi, "ofc_pts_cd", ofcPtsCd) ;
	param += getURLParam(multi, "ofc_cd",     ofcCd) ;
	param += getURLParam(multi, "ofc_nm",     ofcNm) ;
	param += getURLParam(multi, "CallType",   callType, "2") ;
	
	comPopup('/hanjin/COM_ENS_0071.do' + param, 770, 450, 'setValFromOfcPop', display) ;
}

/**
 * display 얻기
 * 
 * @param multi 다중선택 가능 여부
 *              true : 다중선택 가능, false : 불가능
 */
function getCommPopDisplay(multi){
 	var display = multi?'0,1,1,1,1,1,1,1,1,1,1,1':'1,0,1,1,1,1,1,1,1,1,1,1' ;
 	return display ;
}

/**
 * classId 얻기
 */
function getCommPopClassId(){
	var url = document.location.href ;
	var classId = url.substring(url.lastIndexOf("/")+1, url.lastIndexOf(".do")) ;
	return classId ;
}

