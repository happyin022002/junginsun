/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_cni_0004.js
 *@FileTitle : [CPS_CNI_0004] Handler History
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.06
 *@LastModifier : 정행룡
 *@LastVersion : 1.0
 * 2009.10.06 정행룡
 * 1.0 Creation
=========================================================*/

/**
 * [CPS_CNI_0004] Handler History
 * 
 * @extends
 * @class Handler History 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function cps_cni_0004() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject     = setSheetObject;
	this.loadPage           = loadPage;
	this.initSheet          = initSheet;
	this.initControl        = initControl;
	this.doActionIBSheet    = doActionIBSheet;
	this.setTabObject       = setTabObject;
	this.validateForm       = validateForm;
}


//===================================================================================
//전역변수 & 추상함수
//===================================================================================

//IBSheet 
var sheetObjects = new Array();
var sheetCnt = 0;
var sheet1 = null;


//html form
var frm = null;

//===================================================================================
//초기화 
//===================================================================================

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
	//전역 변수 설정 
	frm = document.form;
	sheet1 = sheetObjects[0];
	sheetCnt = sheetObjects.length;

	// 시트 초기화
	for ( var i = 0; i < sheetCnt; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}

	//Form 이벤트 등록
	initControl();
	
	sheet1.WaitImageVisible = false;	   
	
 	var claim_no = frm.cgo_clm_no.value;
 	if (claim_no != "") {
 		doActionIBSheet(SEARCHLIST01);
 	}
 	
 	sheet1.WaitImageVisible = true;
}

/**
 * Form 이벤트 등록
 **/
function initControl() {
	//keypress
	axon_event.addListenerForm('keypress', 'obj_keypress', frm);
	// focus in
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', frm);
	// focus out
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', frm);
	//key up
	axon_event.addListenerForm('keyup',				'obj_keyup',frm); 
}

 /**
  * HTML Control KeyPress 이벤트 호출
  */
function obj_keypress() {
	switch (event.srcElement.name) {    
    case "cgo_clm_no":
    	ComKeyOnlyAlphabet('uppernum');
    	if (event.keyCode == 13) {
    		doActionIBSheet(SEARCHLIST01);
 		}
 		break;
 	}
}

 /**
  * HTML Control KeyUp 이벤트 호출
  **/
 function obj_keyup() {
 	switch (event.srcElement.name) {    
     case "cgo_clm_no":
     	ComKeyOnlyAlphabet('uppernum');
     	if (frm.cgo_clm_no.value.length == 10) {
     		doActionIBSheet(SEARCHLIST01);
  		}
  		break;
  	}
 }
/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 * @param {ibsheet} sheetObj IBSheet Object  
 **/
function setSheetObject(sheetObj) {
	sheetObjects[sheetCnt++] = sheetObj;
}
 
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * 버튼이름으로 구분하여 처리할 작업을 수행하는 이벤트 핸들러
 * @param none 
 **/
function processButtonClick() {
	
	// 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용 
	// var sheetObject1 = sheetObjects[0];
   	// var formObject = document.form;
	
	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
		
		case "btn2_Manager":
			
			var claim_no = frm.cgo_clm_no.value
			var param = "cgo_clm_no=" + claim_no ;
			var url = "CPS_CNI_0005.do?" + param;
			var display = "0,0,1,1,0,1,1,1,1,0,1,1";
			var win = ComOpenPopup(url, 600, 500, "", display);
			win.focus();
			break;

		case "btn1_Retrieve":
			doActionIBSheet(SEARCHLIST01);
			break;

		case "btn1_New":
			doActionIBSheet(IBCLEAR);
			break;

		case "btn1_Close":
			window.close();
			break;

		} // end switch
	} catch (e) {
		if( e == "[object Error]") {
		    ComShowMessage(OBJECT_ERROR);
		} else {
	       ComShowMessage(e);
		}
	}
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 **/
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetObj.id) {
	case "sheet1": //sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 162;

			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 15, 100);

			var HeadTitle1 = "||Seq.|Handler|Office|STS|Description|Working Period|Working Period|Working Period|Date|User";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 	0, 		daCenter, true,	"ibflag");
			InitDataProperty(0, cnt++, dtRadioCheck,    20, 	daCenter, true, "crnt_hdlr_flg", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtDataSeq,       30, 	daCenter, true, "seq");
			InitDataProperty(0, cnt++, dtData, 			80, 	daCenter, true, "hdlr_usr_id", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 			50, 	daCenter, true, "hdlr_ofc_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 			30, 	daCenter, true, "cgo_clm_sts_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 			80, 	daCenter, true, "cgo_clm_sts_nm", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 			65,	    daCenter, true, "eff_dt", false, "", dfDateYmd, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 			15,	    daCenter, true, "tmp_bar", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 			65, 	daCenter, true, "exp_dt", false, "", dfDateYmd, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 			65, 	daCenter, true, "upd_dt", false, "", dfDateYmd, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 			0, 		daCenter, true, "cre_usr_id", false, "", dfNone, 0, true, true);

		}
		break;

	}
}
/**
 * Sheet관련 프로세스 처리
 **/
function doActionIBSheet(sAction) {
	
	frm.f_cmd.value = sAction;
	
	switch (sAction) {

	case SEARCHLIST01: // Retrieve
		if (validateForm(sAction)) {
			frm.mgr_hdlr_div_cd.value = "H";
			var sXml = sheet1.GetSearchXml("CPS_CNI_0004GS.do",	FormQueryString(frm));
			var list = SheetXml2ListMap(sXml);
			if (list.length == 0) {
				ComShowCodeMessage("CNI00013");
			}
			sheet1.LoadSearchXml(sXml);
			
		}
		break;

	case IBCLEAR: // New 
		//CNI00015 Do you want to initialize?
		if (ComShowCodeConfirm("CNI00015") ) {
			ComResetAll();
			frm.cgo_clm_no.focus();
		}
		break;
	}

}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 **/
function validateForm(sAction) {
	 
	if (!ComChkValid(frm)) return false;
		
	if (sAction == SEARCHLIST01) {
		var cgo_clm_no = frm.cgo_clm_no.value;
		
		if(ComIsNull(cgo_clm_no)) {
			//CNI00003:Please Fill all required entry fields {?msg1}.
			ComShowCodeMessage("CNI00003","Claim No");
			frm.cgo_clm_no.focus();
			return false;
		}
	}
		
	return true;
}
	