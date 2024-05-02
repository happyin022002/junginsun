/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : fn_joo_0018.js
 *@FileTitle : AP CSR Creation Evidence PopUp
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.15
 *@LastModifier : 박희동
 *@LastVersion : 1.0
 * 2009.06.15 박희동
 * 1.0 Creation
 * -----------------------------------------------------------
 * History
 * 2010.10.04 이준범[CHM-201006190-01] Evidence를 클릭하면 나오는 pop-up 화면에서 발행일자 칼럼의 defalut 값을
 * -. 현행 : 해당 CSR 발행일
 * -. 세금계산서 번호 컬럼에 찍히는 月의 말일을 (휴일여부 관계 없음)
 * -. default 값으로 지정
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
 * @class fn_joo_0018 : fn_joo_0018 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function fn_joo_0018() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.setComboObject = setComboObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	//this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업	*/

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var aryPrefix = new Array("sheet1_", "sheet2_");

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;


// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObj1 = sheetObjects[0];
	var sheetObj2 = sheetObjects[1];

	/*******************************************************/
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_confirm":
			
			if (formObj.tax_inv_yrmon.value.length ==0){
				ComShowCodeMessage('JOO00062');
				formObj.tax_inv_yrmon.focus();
				return;
			}

			if (formObj.ofc_cd.Code.length == 0){
				ComShowCodeMessage('JOO00063');
				formObj.ofc_cd.focus();
				return;
			}

			if (JooGetRadioValue(formObj.doc_evid_tp_cd) == ""){
				ComShowCodeMessage("JOO00178");
				formObj.doc_evid_tp_cd[0].focus();
				return;
			}
			
			if (formObj.iss_dt.value.length ==0){
				ComShowCodeMessage('JOO00064');
				formObj.iss_dt.focus();
				return;
			}
			
			if (formObj.jo_xch_rt.value == ""){
				ComShowCodeMessage('JOO00065');
				formObj.jo_xch_rt.focus();
				return;
			}
			
			var taxPlCd = JooGetRadioValue(formObj.tax_pl_cd);
				
			var taxInvYrmon = ComReplaceStr(formObj.tax_inv_yrmon.value,"-","");
			var issDt       = ComReplaceStr(formObj.iss_dt.value,"-","");
			
			if (taxInvYrmon != issDt.substring(0,6)){
				ComShowCodeMessage('JOO00066');
				formObj.iss_dt.focus();
				return;
			}
			var row = sheetObj1.LastRow;
			var prefix="sheet1_";
			var itmNm = sheetObj1.CellValue(row, prefix+"itm_nm"); 
			if (itmNm.length == 0){
				ComShowCodeMessage('JOO00067');
				sheetObj1.SelectCell(row,prefix+"itm_nm",true);
				return;
			}
			var splAmt = sheetObj1.CellValue(row, prefix+"spl_amt");
			if (splAmt <= 0){
				ComShowCodeMessage('JOO00068');
				sheetObj1.CellValue(row, prefix+"spl_amt") = 0;
				formObj.spl_amt.value = '0';
				sheetObj1.SelectCell(row,prefix+"spl_amt",true);
				return;
			}
			
			var amt = Number(splAmt);
			
			if (taxPlCd == "B" && amt < 0){
				ComShowCodeMessage('JOO00069');
				sheetObj1.SelectCell(row,prefix+"spl_amt",true);
				return;
			}

			if (taxPlCd == "R" && amt > 0){
				ComShowCodeMessage('JOO00070');
				sheetObj1.SelectCell(row,prefix+"spl_amt",true);
				return;
			}
			
			var sndAmt = Number(gSplyAmt);
			var xchRt  = Number(ComReplaceStr(formObj.jo_xch_rt.value,",",""));			
			var splAmt = Number(sheetObj1.CellValue(row,prefix+"spl_amt"));
			
			if (Math.round(sndAmt * xchRt) != splAmt){
				if (!ComShowCodeConfirm('JOO00071'))
					return;
			}
			setInput2Sheet(formObj, sheetObjects[1]);
			comPopupOK();
			break;

		case "btn_cancel":
//			if (!ComShowConfirm("Are you sure to reset all?"))
//				return;
			setInit();
			break;

		case "btn_close":
			window.close();
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage('JOO00001');
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
 * IBCombo Object를 배열로 등록
 * param : combo_obj ==> 콤보오브젝트
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */ 
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
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	
    for(var k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],k+1);
    }
    
    initControl();

    setEditable();

    //CSR NO가 parameter로 넘어온 경우는 조회
    if (gCsrNo != ""){
    	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    }else{
    	//CSR NO는 없고 datarow가 있는 경우는 넘어온 그대로 보여준다.
    	if (gRowdata != ""){
    		setParentToChild(document.form, sheetObjects[1]);
    	}else{
    		//vendor 코드만 있는 경우 TAX정보를 입력할 수 있도록 VENDOR정보를 조회한다.
	    	if (gVndrSeq != ""){
	        	doActionIBSheet(sheetObjects[1], document.form, IBROWSEARCH);
	    	}
    	}
    }
}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 **/
function initControl() {
	//** Date 구분자 **/
	DATE_SEPARATOR = "-";
	var formObject = document.form;
	
    //Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerFormat('beforedeactivate', 'obj_blur'      , formObject); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
	axon_event.addListenerFormat('beforeactivate'  , 'obj_focus'     , formObject);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
    axon_event.addListenerFormat('keypress'        , 'obj_keypress'  , formObject); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    axon_event.addListenerFormat('keyup'           , 'form_keyup'    , formObject);    
    
    axon_event.addListener('keypress', 'taxBillNo_keypress', 'tax_inv_yrmon');	
    axon_event.addListener('keypress', 'iss_dt_keypress', 'iss_dt');	
    axon_event.addListener('keypress', 'jo_xch_rt_keypress', 'jo_xch_rt');	
}

//Axon 이벤트 처리2. 이벤트처리함수
function obj_blur(){
    ComChkObjValid(event.srcElement);
}

function obj_focus(){
    ComClearSeparator(event.srcElement);
}

function obj_keypress(){
	var src = window.event.srcElement.getAttribute("name")
}

function form_keyup(){
	ComKeyEnter('lengthnextfocus');
}
function taxBillNo_keypress(){
	ComKeyOnlyNumber(this, '');
}
function iss_dt_keypress(){
	ComKeyOnlyNumber(this, '');
}

function jo_xch_rt_keypress(){
	ComKeyOnlyNumber(this, '.');
}


function initCombo(comboObj, comboNo) {
    var formObject = document.form
    
    switch(comboNo) {  
    	case 1: 
           with (comboObj) { 
				MultiSelect = false; 
				UseAutoComplete = false;	
				SetColAlign("left|left");        
				SetColWidth("0|30");
 				DropHeight = 160;
 		    }
            var comboItems = gOfcList.split("|");
            addComboItem(comboObj, comboItems);           	
 			break; 
 	} 
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	switch (sheetNo) {
		case 1: //t1sheet1 init
			with (sheetObj) {
	
				// 높이 설정
				style.height = 80;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);
	
				var HeadTitle = "순번|품명|공급가액|세액|합계";
				var headCount = ComCountHeadTitle(HeadTitle);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false, false)
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
	
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtDataSeq     , 30, daCenter, true, aryPrefix[0]+""       , false, "", dfNone);
				InitDataProperty(0, cnt++, dtData        ,350, daLeft  , true, aryPrefix[0]+"itm_nm" , false, "", dfNone     , 0,  true, true);
				InitDataProperty(0, cnt++, dtData        ,150, daRight , true, aryPrefix[0]+"spl_amt", false, "", dfInteger, 0,  true, true);
				InitDataProperty(0, cnt++, dtData        ,100, daRight , true, aryPrefix[0]+"tax_amt", false, "|2|*0", dfInteger, 0, false,false);
				InitDataProperty(0, cnt++, dtData        , 80, daRight , true, aryPrefix[0]+"ttl_amt", false, "|2|", dfInteger, 0, false,false);
			}
			break;

		case 2: //t1sheet1 init
			with (sheetObj) {
	
				// 높이 설정
				style.height = 0;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);
	
				var HeadTitle = "radio|check|vendor|tax_inv_yrmon|ofc_cd|tax_ser_no|Tax구분|매입세액불공제|흑적자구분|고정자산여부|Tax Type|의제매출분|사업자번호|상호|대표자명|업태|종목|주소|발행일자|환율|공급가액|세액|총합계|품명|계산서발행구분";
				var headCount = ComCountHeadTitle(HeadTitle);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false, false)
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
	
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtRadioCheck  , 50, daCenter,false, "radio"                      , false, "", dfNone, 0,     true,       true);
				InitDataProperty(0, cnt++, dtCheckBox    , 50, daCenter,false, "check"                      , false, "", dfNone, 0,     true,       true);
				InitDataProperty(0, cnt++, dtData        , 50, daCenter, true, aryPrefix[1]+"vndr_seq"      , false, "", dfNone);
				InitDataProperty(0, cnt++, dtData        , 50, daCenter, true, aryPrefix[1]+"tax_inv_yrmon" , false, "", dfUserFormat2);
				InitDataProperty(0, cnt++, dtData        , 50, daCenter, true, aryPrefix[1]+"ofc_cd"        , false, "", dfNone);
				InitDataProperty(0, cnt++, dtData        , 50, daCenter, true, aryPrefix[1]+"tax_ser_no"    , false, "", dfNone);
				InitDataProperty(0, cnt++, dtData        , 50, daCenter, true, aryPrefix[1]+"tax_div_cd"    , false, "", dfNone);
				InitDataProperty(0, cnt++, dtData        , 50, daCenter, true, aryPrefix[1]+"tax_naid_flg"  , false, "", dfNone);
				InitDataProperty(0, cnt++, dtData        , 50, daCenter, true, aryPrefix[1]+"tax_pl_cd"     , false, "", dfNone);
				InitDataProperty(0, cnt++, dtData        , 50, daCenter, true, aryPrefix[1]+"fa_flg"        , false, "", dfNone);
				InitDataProperty(0, cnt++, dtData        , 50, daCenter, true, aryPrefix[1]+"tax_vat_tp_cd" , false, "", dfNone);
				InitDataProperty(0, cnt++, dtData        , 50, daCenter, true, aryPrefix[1]+"tax_nsl_flg"   , false, "", dfNone);
				InitDataProperty(0, cnt++, dtData        , 50, daCenter, true, aryPrefix[1]+"spl_rgst_no"   , false, "", dfSaupNo);
				InitDataProperty(0, cnt++, dtData        , 50, daCenter, true, aryPrefix[1]+"co_nm"         , false, "", dfNone);
				InitDataProperty(0, cnt++, dtData        , 50, daCenter, true, aryPrefix[1]+"ownr_nm"       , false, "", dfNone);
				InitDataProperty(0, cnt++, dtData        , 50, daCenter, true, aryPrefix[1]+"bzct_nm"       , false, "", dfNone);
				InitDataProperty(0, cnt++, dtData        , 50, daCenter, true, aryPrefix[1]+"bztp_nm"       , false, "", dfNone);
				InitDataProperty(0, cnt++, dtData        , 50, daCenter, true, aryPrefix[1]+"spl_addr"      , false, "", dfNone);
				InitDataProperty(0, cnt++, dtData        , 50, daCenter, true, aryPrefix[1]+"iss_dt"        , false, "", dfUserFormat2);
				InitDataProperty(0, cnt++, dtData        , 50, daCenter, true, aryPrefix[1]+"jo_xch_rt"     , false, "", dfNullFloat, 2);
				InitDataProperty(0, cnt++, dtData        , 50, daCenter, true, aryPrefix[1]+"spl_amt"       , false, "", dfInteger, 0);
				InitDataProperty(0, cnt++, dtData        , 50, daCenter, true, aryPrefix[1]+"tax_amt"       , false, "", dfInteger, 0);
				InitDataProperty(0, cnt++, dtData        , 50, daCenter, true, aryPrefix[1]+"ttl_amt"       , false, "", dfInteger, 0);
				InitDataProperty(0, cnt++, dtData        , 50, daCenter, true, aryPrefix[1]+"doc_evid_tp_cd", false, "", dfNone);

				//두개의 sheet를 opener에 넘길 방법이 없으므로...
				InitDataProperty(0, cnt++, dtData        , 30, daLeft  , true, aryPrefix[1]+"itm_nm" , false, "", dfNone     , 0,  true, true);

				InitUserFormat2(0, aryPrefix[1]+"tax_inv_yrmon", "####-##", "-");				
				InitUserFormat2(0, aryPrefix[1]+"iss_dt", "####-##-##", "-");				
				
			}
		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case IBSEARCH: //조회
		formObj.f_cmd.value = SEARCH;
		var sXml = sheetObj.GetSearchXml("FNS_JOO_0018GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
		
		var arrXml = sXml.split("|$$|");

		for(var inx=0; inx<arrXml.length; inx++){
			sheetObjects[inx].LoadSearchXml(arrXml[inx]);
		}
		
		setSheet2Input(formObj, sheetObjects[1]);		
		break;
	
	case IBROWSEARCH:
		formObj.f_cmd.value = SEARCHLIST01;
        var sXml = sheetObj.GetSearchXml("FNS_JOO_0018GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix[1]));
        
        sheetObj.LoadSearchXml(sXml);
        
		setSheet2Input(formObj, sheetObj);		
        
		sheetObjects[0].DataInsert(-1);
		sheetObjects[0].CellValue(sheetObjects[0].LastRow,"radio") = "1";
		sheetObjects[0].CellValue(sheetObjects[0].LastRow,"check") = "1";
		sheetObjects[1].CellValue(sheetObjects[1].LastRow,"radio") = "1";
		sheetObjects[1].CellValue(sheetObjects[1].LastRow,"check") = "1";
		formObj.tax_inv_yrmon.focus();
        break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
		case IBSEARCH: //조회
			break;
			
		case IBSAVE: //저장
			setInputToSheet(formObj, sheetObj);
			break;
	}
	return true;
}

/**
 * Html input에 있는 값을 sheet에 넘긴다.
 * @param formObj
 * @param sheetObj
 * @return
 */
function setInput2Sheet(formObj, sheetObj){
	var row = sheetObj.LastRow;
	var pre = "sheet2_";
	var prefix = "sheet1_";
	var row1   = sheetObjects[0].LastRow;
	var form = document.form;
	
	sheetObj.CellValue(row, pre+"vndr_seq"     )= form.vndr_seq.value;
	sheetObj.CellValue(row, pre+"tax_inv_yrmon")= ComReplaceStr(form.tax_inv_yrmon.value,"-","");
	sheetObj.CellValue(row, pre+"ofc_cd"       )= form.ofc_cd.Code;
	sheetObj.CellValue(row, pre+"tax_ser_no"   )= "";
	sheetObj.CellValue(row, pre+"tax_div_cd"   )= JooGetRadioValue(form.tax_div_cd);
	sheetObj.CellValue(row, pre+"tax_naid_flg" )= JooGetRadioValue(form.tax_naid_flg);
	sheetObj.CellValue(row, pre+"tax_pl_cd"    )= JooGetRadioValue(form.tax_pl_cd);
	sheetObj.CellValue(row, pre+"fa_flg"       )= JooGetRadioValue(form.fa_flg);
	sheetObj.CellValue(row, pre+"tax_vat_tp_cd")= JooGetRadioValue(form.tax_vat_tp_cd);
	sheetObj.CellValue(row, pre+"tax_nsl_flg"  )= JooGetRadioValue(form.tax_nsl_flg);
	sheetObj.CellValue(row, pre+"spl_rgst_no"  )= ComReplaceStr(form.spl_rgst_no.value,"-","");
	sheetObj.CellValue(row, pre+"co_nm"        )= form.co_nm.value;
	sheetObj.CellValue(row, pre+"ownr_nm"      )= form.ownr_nm.value;
	sheetObj.CellValue(row, pre+"bzct_nm"      )= form.bzct_nm.value;
	sheetObj.CellValue(row, pre+"bztp_nm"      )= form.bztp_nm.value;
	sheetObj.CellValue(row, pre+"spl_addr"     )= form.spl_addr.value;
	sheetObj.CellValue(row, pre+"iss_dt"       )= ComReplaceStr(form.iss_dt.value,"-","");
	sheetObj.CellValue(row, pre+"jo_xch_rt"    )= ComReplaceStr(form.jo_xch_rt.value,",","");
	sheetObj.CellValue(row, pre+"spl_amt"      )= ComReplaceStr(form.spl_amt.value,",","");
	sheetObj.CellValue(row, pre+"tax_amt"      )= ComReplaceStr(form.tax_amt.value,",","");
	sheetObj.CellValue(row, pre+"ttl_amt"      )= ComReplaceStr(form.ttl_amt.value,",","");
	sheetObj.CellValue(row, pre+"itm_nm"       )= sheetObjects[0].CellValue(row1,prefix+"itm_nm");
	sheetObj.CellValue(row, pre+"doc_evid_tp_cd")= JooGetRadioValue(form.doc_evid_tp_cd);
}

/**
 * Sheet에 있는 값을 Html input에 display한다.
 * @param formObj
 * @param sheetObj
 * @return
 */
function setSheet2Input(formObj, sheetObj){
	var prefix="sheet2_";                                                                    
	formObj.tax_inv_yrmon.value = sheetObj.CellText(sheetObj.LastRow,prefix+"tax_inv_yrmon");
	formObj.ofc_cd.Code         = sheetObj.CellText(sheetObj.LastRow,prefix+"ofc_cd"       );
	formObj.tax_ser_no.value    = sheetObj.CellText(sheetObj.LastRow,prefix+"tax_ser_no"   );
	formObj.tax_div_cd.value    = sheetObj.CellText(sheetObj.LastRow,prefix+"tax_div_cd"   );
	formObj.tax_naid_flg.value  = sheetObj.CellText(sheetObj.LastRow,prefix+"tax_naid_flg" );
	formObj.tax_pl_cd.value     = sheetObj.CellText(sheetObj.LastRow,prefix+"tax_pl_cd"    );
	formObj.fa_flg.value        = sheetObj.CellText(sheetObj.LastRow,prefix+"fa_flg"       );
	formObj.tax_vat_tp_cd.value = sheetObj.CellText(sheetObj.LastRow,prefix+"tax_vat_tp_cd");
	formObj.tax_nsl_flg.value   = sheetObj.CellText(sheetObj.LastRow,prefix+"tax_nsl_flg"  );
	formObj.spl_rgst_no.value   = sheetObj.CellText(sheetObj.LastRow,prefix+"spl_rgst_no"  );
	formObj.vndr_seq.value      = sheetObj.CellText(sheetObj.LastRow,prefix+"vndr_seq"     );
	formObj.co_nm.value         = sheetObj.CellText(sheetObj.LastRow,prefix+"co_nm"        );
	formObj.ownr_nm.value       = sheetObj.CellText(sheetObj.LastRow,prefix+"ownr_nm"      );
	formObj.bzct_nm.value       = sheetObj.CellText(sheetObj.LastRow,prefix+"bzct_nm"      );
	formObj.bztp_nm.value       = sheetObj.CellText(sheetObj.LastRow,prefix+"bztp_nm"      );
	formObj.spl_addr.value      = sheetObj.CellText(sheetObj.LastRow,prefix+"spl_addr"     );
	formObj.iss_dt.value        = sheetObj.CellText(sheetObj.LastRow,prefix+"iss_dt"       );
	formObj.jo_xch_rt.value     = sheetObj.CellText(sheetObj.LastRow,prefix+"jo_xch_rt"    );
	formObj.spl_amt.value       = sheetObj.CellText(sheetObj.LastRow,prefix+"spl_amt"      );
	formObj.tax_amt.value       = sheetObj.CellText(sheetObj.LastRow,prefix+"tax_amt"      );
	formObj.ttl_amt.value       = sheetObj.CellText(sheetObj.LastRow,prefix+"ttl_amt"      );
	formObj.doc_evid_tp_cd.value= sheetObj.CellText(sheetObj.LastRow,prefix+"doc_evid_tp_cd");
	
	var taxInvYrmon = sheetObj.CellText(sheetObj.LastRow,prefix+"tax_inv_yrmon");
	
	if (taxInvYrmon == null || taxInvYrmon == "" ){
		var lastMonth = ComGetDateAdd(gSysdate, "M", -1, "-"); 
		formObj.tax_inv_yrmon.value = lastMonth.substring(0,7);
		formObj.iss_dt.value        = lastMonth.substring(0,8) + ComGetLastDay(ComParseInt(lastMonth.substring(0,4)),ComParseInt(lastMonth.substring(5,7)));
	}

	var taxDivCd = sheetObj.CellText(sheetObj.LastRow, prefix+"tax_div_cd");
	
	if (taxDivCd == null || taxDivCd == "")
		taxDivCd = "2";
	
	if (taxDivCd == "1"){
		document.form.tax_div_cd[0].checked = true;
	}else if (taxDivCd == "2"){
		document.form.tax_div_cd[1].checked = true;
	}

	var taxPlCd = sheetObj.CellText(sheetObj.LastRow, prefix+"tax_pl_cd");
	
	if (taxPlCd == null || taxPlCd == "")
		taxPlCd = "B";
	
	if (taxPlCd == "B"){
		document.form.tax_pl_cd[0].checked = true;
	}else if (taxPlCd == "R"){
		document.form.tax_pl_cd[1].checked = true;
	}

	var taxVatTpCd = sheetObj.CellText(sheetObj.LastRow, prefix+"tax_vat_tp_cd");
	
	if (taxVatTpCd == null || taxVatTpCd == "")
		taxVatTpCd = "1";
	
	if (taxVatTpCd == "1"){
		document.form.tax_vat_tp_cd[0].checked = true;
	}else if (taxVatTpCd == "2"){
		document.form.tax_vat_tp_cd[1].checked = true;
	}
	
	var taxNaidFlg = sheetObj.CellText(sheetObj.LastRow, prefix+"tax_naid_flg");
	
	if (taxNaidFlg==null || taxNaidFlg=="")
		taxNaidFlg = "N";
	
	if (taxNaidFlg == "Y"){
		document.form.tax_naid_flg[0].checked = true;
	}else if (taxNaidFlg == "N"){
		document.form.tax_naid_flg[1].checked = true;
	}
	
	var faFlg = sheetObj.CellText(sheetObj.LastRow, prefix+"fa_flg");
	
	if (faFlg == null || faFlg=="")
		faFlg = "N";
	
	if (faFlg == "Y"){
		document.form.fa_flg[0].checked = true;
	}else if (faFlg == "N"){
		document.form.fa_flg[1].checked = true;
	}

	var taxNslFlg = sheetObj.CellText(sheetObj.LastRow, prefix+"tax_nsl_flg");
	if (taxNslFlg == null || taxNslFlg =="")
		taxNslFlg = "N";
	
	if (taxNslFlg == "Y"){
		document.form.tax_nsl_flg[0].checked = true;
	}else if (taxNslFlg == "N"){
		document.form.tax_nsl_flg[1].checked = true;
	}

	var docEvidTpCd = sheetObj.CellText(sheetObj.LastRow, prefix+"doc_evid_tp_cd");
	
//	if (docEvidTpCd == null || docEvidTpCd =="")
//		docEvidTpCd = "ELECTRONIC";
	
	if (docEvidTpCd == "ELECTRONIC"){
		document.form.doc_evid_tp_cd[0].checked = true;
	}else if (docEvidTpCd == "PAPER"){
		document.form.doc_evid_tp_cd[1].checked = true;
	}
}


function setParentToChild(form, sheetObj){
	sheetObjects[0].RemoveAll();
	sheetObj.RemoveAll();
	sheetObjects[0].DataInsert(-1);
	sheetObj.DataInsert(-1);
	
	var arr = gRowdata.split("|");
	for (var i=0; i<=sheetObj.LastCol; i++){
		sheetObj.CellValue(1, i) = arr[i];
	}
	
	var pre  = "sheet2_";
	var pre1 = "sheet1_";
	form.vndr_seq.value      = sheetObj.CellValue(1, pre+"vndr_seq"     );
	form.tax_inv_yrmon.value = sheetObj.CellValue(1, pre+"tax_inv_yrmon");
	form.ofc_cd.Code         = sheetObj.CellValue(1, pre+"ofc_cd"       );
	form.tax_div_cd.value    = sheetObj.CellValue(1, pre+"tax_div_cd"   );
	form.tax_naid_flg.value  = sheetObj.CellValue(1, pre+"tax_naid_flg" );
	form.tax_pl_cd.value     = sheetObj.CellValue(1, pre+"tax_pl_cd"    );
	form.fa_flg.value        = sheetObj.CellValue(1, pre+"fa_flg"       );
	form.tax_vat_tp_cd.value = sheetObj.CellValue(1, pre+"tax_vat_tp_cd");
	form.tax_nsl_flg.value   = sheetObj.CellValue(1, pre+"tax_nsl_flg"  );
	form.spl_rgst_no.value   = sheetObj.CellValue(1, pre+"spl_rgst_no"  );
	form.co_nm.value         = sheetObj.CellValue(1, pre+"co_nm"        );
	form.ownr_nm.value       = sheetObj.CellValue(1, pre+"ownr_nm"      );
	form.bzct_nm.value       = sheetObj.CellValue(1, pre+"bzct_nm"      );
	form.bztp_nm.value       = sheetObj.CellValue(1, pre+"bztp_nm"      );
	form.spl_addr.value      = sheetObj.CellValue(1, pre+"spl_addr"     );
	form.iss_dt.value        = sheetObj.CellText (1, pre+"iss_dt"       );
	form.jo_xch_rt.value     = sheetObj.CellText (1, pre+"jo_xch_rt"    );
	form.spl_amt.value       = sheetObj.CellText (1, pre+"spl_amt"      );
	form.tax_amt.value       = sheetObj.CellText (1, pre+"tax_amt"      );
	form.ttl_amt.value       = sheetObj.CellText (1, pre+"ttl_amt"      );
	form.doc_evid_tp_cd.value= sheetObj.CellValue(1, pre+"doc_evid_tp_cd");
	
	sheetObjects[0].CellValue(1,pre1+"itm_nm")  = sheetObj.CellValue(1, pre+"itm_nm" );
	sheetObjects[0].CellValue(1,pre1+"spl_amt") = sheetObj.CellValue(1, pre+"spl_amt");
	sheetObjects[0].CellValue(1,pre1+"tax_amt") = sheetObj.CellValue(1, pre+"tax_amt");
	sheetObjects[0].CellValue(1,pre1+"ttl_amt") = sheetObj.CellValue(1, pre+"ttl_amt");
	
	var taxDivCd = sheetObj.CellValue(sheetObj.LastRow, pre+"tax_div_cd");
	
	if (taxDivCd == null || taxDivCd == "")
		taxDivCd = "2";
	
	if (taxDivCd == "1"){
		form.tax_div_cd[0].checked = true;
	}else if (taxDivCd == "2"){
		form.tax_div_cd[1].checked = true;
	}

	var taxPlCd = sheetObj.CellText(sheetObj.LastRow, pre+"tax_pl_cd");
	
	if (taxPlCd == null || taxPlCd == "")
		taxPlCd = "B";
	
	if (taxPlCd == "B"){
		form.tax_pl_cd[0].checked = true;
	}else if (taxPlCd == "R"){
		form.tax_pl_cd[1].checked = true;
	}

	var taxVatTpCd = sheetObj.CellText(sheetObj.LastRow, pre+"tax_vat_tp_cd");
	
	if (taxVatTpCd == null || taxVatTpCd == "")
		taxVatTpCd = "1";
	
	if (taxVatTpCd == "1"){
		form.tax_vat_tp_cd[0].checked = true;
	}else if (taxVatTpCd == "2"){
		form.tax_vat_tp_cd[1].checked = true;
	}
	
	var taxNaidFlg = sheetObj.CellText(sheetObj.LastRow, pre+"tax_naid_flg");
	
	if (taxNaidFlg==null || taxNaidFlg=="")
		taxNaidFlg = "N";
	
	if (taxNaidFlg == "Y"){
		form.tax_naid_flg[0].checked = true;
	}else if (taxNaidFlg == "N"){
		form.tax_naid_flg[1].checked = true;
	}
	
	var faFlg = sheetObj.CellText(sheetObj.LastRow, pre+"fa_flg");
	
	if (faFlg == null || faFlg=="")
		faFlg = "N";
	
	if (faFlg == "Y"){
		form.fa_flg[0].checked = true;
	}else if (faFlg == "N"){
		form.fa_flg[1].checked = true;
	}

	var taxNslFlg = sheetObj.CellText(sheetObj.LastRow, pre+"tax_nsl_flg");
	if (taxNslFlg == null || taxNslFlg =="")
		taxNslFlg = "N";
	
	if (taxNslFlg == "Y"){
		form.tax_nsl_flg[0].checked = true;
	}else if (taxNslFlg == "N"){
		form.tax_nsl_flg[1].checked = true;
	}	
	
	var docEvidTpCd = sheetObj.CellText(sheetObj.LastRow, pre+"doc_evid_tp_cd");

	if (docEvidTpCd == null || docEvidTpCd =="")
		docEvidTpCd = "ELECTRONIC";
	
	if (docEvidTpCd == "ELECTRONIC"){
		form.doc_evid_tp_cd[0].checked = true;
	}else if (docEvidTpCd == "PAPER"){
		form.doc_evid_tp_cd[1].checked = true;
	}
}

/**
 * 화면의 Editable을 setting한다.
 * @return
 */
function setEditable(){
	var formObj = document.form;
	var bEditable  = true;
	var vClassName = "input";

	if (gEditable == "N"){
		bEditable  = false;
		vClassName = "input2"; // readOnly
	}

	formObj.tax_inv_yrmon.readOnly = !bEditable;
	formObj.ofc_cd.Enable          =  bEditable;
	for (var inx=0; inx<formObj.tax_pl_cd.length; inx++){
		formObj.tax_pl_cd[inx].disabled  = !bEditable;
		formObj.tax_pl_cd[inx].classNmae = vClassName;
	}
	for (var inx=0; inx<formObj.doc_evid_tp_cd.length; inx++){
		formObj.doc_evid_tp_cd[inx].disabled  = !bEditable;
		formObj.doc_evid_tp_cd[inx].classNmae = vClassName;
	}
	formObj.iss_dt.readOnly        = !bEditable;
	formObj.jo_xch_rt.readOnly     = !bEditable;
	
	formObj.tax_inv_yrmon.className = vClassName;
	formObj.ofc_cd.ClassName        = vClassName;
	formObj.iss_dt.className        = vClassName;
	formObj.jo_xch_rt.className     = vClassName;
	
	sheetObjects[0].Editable = bEditable;
}

/**
 * 초기화
 * @return
 */
function setInit(){
	var formObj = document.form;
	
	var lastMonth = ComGetDateAdd(gSysdate, "M", -1, "-"); 
	formObj.tax_inv_yrmon.value = lastMonth.substring(0,7);
	formObj.iss_dt.value        = lastMonth.substring(0,8) + ComGetLastDay(ComParseInt(lastMonth.substring(0,4)),ComParseInt(lastMonth.substring(5,7)));
	
	formObj.ofc_cd.Index = -1;
	formObj.tax_pl_cd[0].checked = true;
	
	formObj.jo_xch_rt.value = "";
	sheetObjects[0].RemoveAll();
	sheetObjects[0].DataInsert(-1);
	
	formObj.tax_inv_yrmon.focus();
}

function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift){
	var pre = "sheet1_";

	var sName = sheetObj.ColSaveName(Col);

	var Value = sheetObj.EditText;
	if (sName == (pre+"spl_amt")){
		document.form.spl_amt.value = Value;
		document.form.tax_amt.value = 0;
		document.form.ttl_amt.value = Value;
	}
}

/**
* HTML Control Focus in
*/
function taxBillNo_keyup(){	
	
	var formObj = document.form;
	
	if (formObj.tax_inv_yrmon.value.length == 6) {
		
		var lastYear  = formObj.tax_inv_yrmon.value.substring(0,4);
		var lastMonth = formObj.tax_inv_yrmon.value.substring(4,6);
		var lastDay   = ComGetLastDay(ComParseInt(lastYear),ComParseInt(lastMonth));

		formObj.iss_dt.value = lastYear + "-" + lastMonth + "-" + lastDay;
		
	} else {
		
		formObj.iss_dt.value = "";
	}
		
} 
/* 개발자 작업  끝 */