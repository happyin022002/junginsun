/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0499.js
 *@FileTitle : Transit Time Report at T/S Port
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.01.17
 *@LastModifier : 김경섭
 *@LastVersion : 1.0
 * 2012.01.17 김경섭
 * 1.0 Creation 
 * ======================================================
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
 * @class esm_bkg_0499 : esm_bkg_0499 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0499() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetObjectsMap = new Array();

var sheetCnt = 0;
var oldCntrTypeSize = "";
var sCntrTypeSize = "";
var oldCntrTypeSize2 = "";
var tabIndex = 0;
var isOpen = false;
var enterSwitch = false;
var comboObjects = new Array();
var comboObjectsMap = new Array();
var comboCnt = 0;

var isSummarySearch = false;//조회 후 탭만 클릭시 재조회 하지 않을 용도.
var isDetailSearch = false;//조회 후 탭만 클릭시 재조회 하지 않을 용도.

/**
 * IBMultiCombo Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setComboObject(combo_obj) {

	comboObjects[comboCnt++] = combo_obj;
	comboObjectsMap[combo_obj.id] = combo_obj;
}

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var t1sheet1 = sheetObjectsMap["t1sheet1"];
	var t2sheet1 = sheetObjectsMap["t2sheet1"];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_Retrieve":
			
			if (tabIndex == 0) {
				t1sheet1.RemoveAll();
				doActionIBSheet(t1sheet1, formObject, IBSEARCH);
				t1sheet1.SelectRow = 0;
				isDetailSearch = false;
			} else {
				t2sheet1.RemoveAll();
				doActionIBSheet(t2sheet1, formObject, SEARCH01);
				t2sheet1.SelectRow = 0;
				isSummarySearch = false;
			}
			break;

		case "btn_downExcel":
			if (tabIndex == 0) {
				t1sheet1.Down2Excel(-1);
			} else {
				t2sheet1.Down2Excel(-1);
			}
			break;

		case "btn_new":
			t1sheet1.RemoveAll();
			t2sheet1.RemoveAll();
			formObject.reset();
			document.getElementById("location").value = "";
			formObject.from_dt.value="";
			formObject.to_dt.value="";
			comboObjectsMap['rlane1'].RemoveAll(); 
			comboObjectsMap['vvd'].RemoveAll(); 
			break;
		case "btn_loc_cd": //Location 조회 팝업
			var cnt_cd = "";
			var loc_cd = "";
			cnt_cd = formObject.inquiry_level.value;
			loc_cd = formObject.location.value;
			if (formObject.inquiry_level.value != 'A') {
				if (formObject.inquiry_level.value == 'C') { //Country
					var param = "?cnt_cd=" + cnt_cd + "&loc_cd=" + loc_cd;
					ComOpenPopup("/hanjin/COM_ENS_0M1.do", 565, 650, "popupFinish", "1,0,1,1,1,1,1,1", true);
				} else {
					var loc_code = "";

					if (formObject.inquiry_level.value == "R") {
						loc_code = "rcc_cd";
					} else if (formObject.inquiry_level.value == "P") {
						loc_code = "loc_cd";
					}
					var param = "?cnt_cd=" + cnt_cd + "&loc_cd=" + loc_cd;
					ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 460, loc_code + ":location", "1,0,1,1,1,1,1,1", true);
				}
			}
			break;
		case "btn_print":
			alert("btn_print");
			break;

		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			alert("지금은 사용하실 수가 없습니다 ");
		} else {
			alert(e);
		}
	}
}

/**
 * Location by loc_cd 팝업에서 선택한 값 Setting.
 */
function popupFinish(aryPopupData, row, col, sheetIdx) {
	var sheetObject = sheetObjects[0];
	var formObject = document.form;
	formObject.location.value = aryPopupData[0][3]
}

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
	sheetObjectsMap[sheet_obj.id] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	sCntrTypeSize = ComGetEtcData(form.sXml.value, "cntrTypeSize");
	
	for (i = 0; i < sheetObjects.length; i++) {

		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	SpcSearchOptionTrade("trade");
	
	
	//RevenueLaneSetting();
	
	form.from_dt.value= Date.today().add(-1).months().toString('yyyy-MM');
	form.to_dt.value= form.from_dt.value;
	
	axon_event.addListener('blur', 'obj_blur', 'location');
	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
	axon_event.addListenerForm('change', 'obj_change', form);
	axon_event.addListenerForm('focus', 'obj_activate', document.form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	axon_event.addListenerForm('blur', 'obj_deactivate', document.form); //- form OnBeforeDeactivate이벤트에 코드 처리
	axon_event.addListenerFormat('keyup', 'form_keyup', form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	document.getElementById("location").className = "input1";

	for (k = 0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
	}
	isOpen = true;
	document.form.from_dt.focus();
}

function trade_OnChange(){
	var formObj = document.form;
	RevenueLaneSetting(formObj.trade.Code);
}
function rlane1_OnChange(){
	comboObjectsMap['vvd'].RemoveAll(); 

}
	/* Revenue Lane Setting */
function RevenueLaneSetting(trdCd) {
 	if(trdCd == undefined || trdCd == null){
 		trdCd = '';
 	}     		
	rlane_rtn_xml = SpcSearchRevLane("rlane1",true,"N",true,trdCd);    	
	var rlane1_combo = document.getElementById("rlane1");
	ComXml2ComboItem(rlane_rtn_xml, rlane1_combo, "sub_trd_cd", "trd_cd|sub_trd_cd|rlane_cd|rlane_nm");
	rlane1_combo.InsertItem(0, "||ALL|ALL");
	
	comboObjectsMap['vvd'].RemoveAll();
}	

function form_keyup() {
	var obj = null;
	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	if (keyValue != 13) {
		ComKeyEnter('lengthnextfocus');
	} else {
		obj_deactivate();
	}
}

function periodCheck(from,to){
		if(eval(from) > eval(to) )
			return false;
	
	return true;
} 
//Axon 이벤트 처리2. 이벤트처리함수
function obj_deactivate() {
	
	var from = document.getElementById("from_dt");
	var to = document.getElementById("to_dt");
	sVal1 = from.value.replace(/\/|\-|\./g, "");
	sVal2 = to.value.replace(/\/|\-|\./g, "");
	switch (event.srcElement.name) {
		case "from_dt":
			if(ComIsNull(from)) return;
			if (ComChkObjValid(from,"Period")) {//정상적인 수치가 입력 됨
				if(!ComIsNull(to) && !periodCheck(sVal1,sVal2)){//from과 to가 정상적이지 않을경우
					ComShowCodeMessage("CIM29004");
					event.srcElement.value = "";
					event.srcElement.focus();
					event.srcElement.select();
					return false;
				}
			}else{ //기간 입력 오류
				event.srcElement.value = "";
				event.srcElement.focus();
				event.srcElement.select();
				return false;
			}
			break;
		case "to_dt":
			if(ComIsNull(to)) return;
			if (ComChkObjValid(to,"Period")) {//정상적인 수치가 입력 됨
				if(!ComIsNull(from) && !periodCheck(sVal1,sVal2)){//from과 to가 정상적이지 않을경우
					ComShowCodeMessage("CIM29004");
					event.srcElement.value = "";
					event.srcElement.focus();
					event.srcElement.select();
				}
			}else{ //기간 입력 오류
				event.srcElement.value = "";
				event.srcElement.focus();
				event.srcElement.select();
				return false;
			}
			break;
	}
	
}

function lastDay(y, m) {
	var d, d2, s = "";
	d = new Date();
	d2 = new Date(y, m, "");
	s = d2.getDate();
	return (s);
}

function obj_activate() {
	ComClearSeparator(event.srcElement);
	ComSetFocus(event.srcElement);
}



function obj_keypress() {
	switch (event.srcElement.name) {
	case "location":
		ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자만 입력허용
		break;
	case "from_dt":
		// 숫자만 + "-"만 입력허용
		ComKeyOnlyNumber(event.srcElement);
		break;
	case "to_dt":
		// 숫자만 + "-"만 입력허용
		ComKeyOnlyNumber(event.srcElement);
		break;
	}

}

function obj_change() {

	obj = event.srcElement;
	if (obj.name == "inquiry_level") {
		if (obj.value == "A") {
			document.getElementById("location").value = "";
			document.getElementById("location").className = "input1";
		} else {
			document.getElementById("location").className = "input1";
			if (obj.value == "C") {
				document.getElementById("location").setAttribute("maxLength", 2);
			} else {
				document.getElementById("location").setAttribute("maxLength", 5);
			}
			document.getElementById("location").focus();
		}
	} else if (obj.name == "period") {
		if (obj.value == "M") {
			document.getElementById("from_dt").setAttribute("dataformat", "ym");
			document.getElementById("to_dt").setAttribute("dataformat", "ym");
			document.form.from_dt.value = "";
			document.form.to_dt.value = "";
			document.form.from.value = "";
			document.form.to.value = "";
		} else {
			document.getElementById("from_dt").setAttribute("dataformat", "yw");
			document.getElementById("to_dt").setAttribute("dataformat", "yw");

			document.form.from_dt.value = "";
			document.form.to_dt.value = "";
			document.form.from.value = "";
			document.form.to.value = "";
		}
	} else if (obj.name == "from_dt" || obj.name == "to_dt" || obj.name == "location") { // VVD를 초기화 한다.
		comboObjectsMap['vvd'].RemoveAll();
	}
}

function vvd_OnFocus(comboObj) {
	var f = document.form;
	flag = false;
	if (f.from_dt.value == "") {
		ComShowCodeMessage("BKG08231", "Period");
		ComSetFocus(f.from_dt);
		return false;
	} else if (f.to_dt.value == "") {
		ComShowCodeMessage("BKG08231", "Period");
		ComSetFocus(f.to_dt);
		return false;
	} else if (form.location.value == "") {
		ComShowCodeMessage("COM12193","Location");
		document.form.location.focus();
		return false;
	}
	
	if (comboObj.GetCount() <= 0) {
		//comboObj.Enable = false;
		doActionIBSheet(sheetObjects[0], document.form, SEARCH03);
		if (comboObjects[2].GetCount() > 0) {
			comboObj.Enable = true;
			comboObjects[2].focus();
		}

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

	switch (sheetID) {

	case "t1sheet1": //t1sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 390;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = "Trade|Sub Trade|Lane|VVD|Division|Total";

			//컬럼 가변 처리를 위한 기준 데이터를 배열로 만든다.
			oldCntrTypeSize = sCntrTypeSize;
			var arrCntrTypeSize = oldCntrTypeSize.split(",");
			var arrHead = new Array();

			//컬럼 가변에 따라 해더타이틀 가변 처리
			for ( var i = 0; i < arrCntrTypeSize.length; i++) {
					HeadTitle1 += "|" + arrCntrTypeSize[i];
			}
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			//InitHeadMode(true, true, false, true, false, false);
			InitHeadMode(false, false, true, true, false,false)

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			sheetObj.FrozenCols = 6;
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			//컬럼 가변에 따라 해더타이틀 가변 처리
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "trade", false, "", dfNone);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "sub_trade", false, "", dfNone);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "lane", false, "", dfNone);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "vvd", false, "", dfNone);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "division", false, "", dfNone);
			InitDataProperty(0, cnt++, dtData, 40, daRight, true, "total", false, "", dfNone);
			
			for ( var i = 0; i < arrCntrTypeSize.length; i++) {
				InitDataProperty(0,		cnt++ , dtData,					45,	daCenter,		true, i+1 < 10 ? 'count0'+(i+1):'count'+(i+1),         	false,		"",		dfNone);
			}
			CountPosition = 0;

		}
		break;

	case "t2sheet1": //t2sheet1 init
		with (sheetObj) {
            // 높이 설정
            style.height = 335;
            //전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

           //전체Edit 허용 여부 [선택, Default false]
            Editable = true;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(1, 1, 5, 100);

            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(21, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, false, true, false,false)

//            var HeadTitle1 = "|Sel.|Seq.|Yard CD|Container No.|T/S|F/M|MV|B/L No.|POL|POD|Next\nPort|Former VVD|Lane|ACT Date|Next VVD|Lane|ETD Date|Special|S/Days|Shipper|Consignee";
            var HeadTitle1 = "|Seq.|Yard CD|BKG No.|Container No.|S/Days|T/S|MV|Event Date|B/L No.|POL|Next\nPort|POD|Lane|Former VVD|Lane|Next VVD|ETD Date|Special|Shipper|Consignee";


            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);

            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0,	cnt++ , dtHiddenStatus,			60,		daCenter,	true,		"ibflag");
//			InitDataProperty(0, cnt++ , dtCheckBox,					30,		daCenter,	false,		"del_chk",		false,			"",      dfNone,			0,		true,		true);
			InitDataProperty(0, cnt++ , dtDataSeq,				30 ,	daCenter,	false,		"Seq",				false,			"",      dfNone,			0,		false,		true);
			
			InitDataProperty(0, cnt++ , dtData,					75,		daCenter,	false,		"pod_yd_cd",		false,			"",      dfNone,			0,		false,		true);
			InitDataProperty(0, cnt++ , dtData,					100,	daCenter,	false,		"bkg_no",			false,			"",      dfNone,			0,		false,		true);
			InitDataProperty(0, cnt++ , dtData,					100,	daCenter,	false,		"cntr_no",			false,			"",      dfNone,			0,		false,		true);
			InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	false,		"stay_day",		    false,			"",      dfNone,			0,		false,		true);
//			InitDataProperty(0, cnt++ , dtAutoSum,				50,		daCenter,	false,		"stay_day",		    false,			"",      dfNullFloat,	1);			
			InitDataProperty(0, cnt++ , dtData,					28,		daCenter,	false,		"cntr_tpsz_cd",		false,			"",      dfNone,			0,		false,		true);
			InitDataProperty(0, cnt++ , dtData,					28,		daCenter,	false,		"cnmv_sts_cd",		false,			"",      dfNone,			0,		false,		true);
			InitDataProperty(0, cnt++ , dtData,					120,	daCenter,	false,		"event_dt",			false,			"",      dfNone,			0,		false,		true);

			InitDataProperty(0, cnt++ , dtData,					100,	daCenter,	false,		"bl_no",			false,			"",      dfNone,			0,		false,		true);
			InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	false,		"pol_cd",			false,			"",      dfNone,			0,		false,		true);
			InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	false,		"next_port",		false,			"",      dfNone,			0,		false,		true);
			InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	false,		"pod_cd",			false,			"",      dfNone,			0,		false,		true);
			
			InitDAtaProperty(0, cnt++ , dtData,					50,		daCenter,	false,		"frmr_lane",		false,			"",      dfNone,			0,		false,		true);
			InitDataProperty(0, cnt++ , dtData,					95,		daCenter,	false,		"frmr_vvd",			false,			"",      dfNone,			0,		false,		true);
			InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	false,		"next_lane",		false,			"",      dfNone,			0,		false,		true);
			InitDataProperty(0, cnt++ , dtData,					90,		daCenter,	false,		"next_vvd",			false,			"",      dfNone,			0,		false,		true);
			
			InitDataProperty(0, cnt++ , dtData,					100,	daCenter,	false,		"etd",				false,			"",      dfNone,			0,		false,		true);

			InitDataProperty(0, cnt++ , dtData,					60,		daCenter,	false,		"special",			false,			"",      dfNone,			0,		false,		true);
			InitDataProperty(0, cnt++ , dtData,					240,	daLeft,		false,		"sh_nm",			false,			"",      dfNone,			0,		false,		true);
			InitDataProperty(0, cnt++ , dtData,					230,	daLeft,		false,		"cn_nm",			false,			"",      dfNone,			0,		false,		true);
			
			Ellipsis = true; //말줄임표시
		}
		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;

	switch (sAction) {

	case IBSEARCH: //조회
		isOpen = true;
		if (validateForm(sheetObj, formObj, sAction)) {
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("ESM_BKG_0499GS.do", FormQueryString(formObj)+"&sub_trade="+formObj.rlane1.Code.replace(",","','")+"&p_lane="+formObj.rlane1.Text.replace(",","','"));
			ComOpenWait(false);
			isSummarySearch = true;
			sheetObj.WaitImageVisible = true;
		}
		break;

	case SEARCH01:
		if (validateForm(sheetObj, formObj, sAction)) {
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH01;
			sheetObj.DoSearch("ESM_BKG_0499GS.do", FormQueryString(formObj)+"&p_lane="+formObj.rlane1.Code.replace(",","','"));
			ComOpenWait(false);
			isDetailSearch = true;//최초 로딩시 탭클릭시 조회함.
			sheetObj.WaitImageVisible = true;
		}			
		break;
		
	case SEARCH03: // VVD 조회
		formObj.f_cmd.value = SEARCH03;
		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);
		var tmpObj = formObj.rlane1.Text.split(',');
		var tmpObj2 = new Array();
		for(var i =0; i < tmpObj.length; i++){
			tmpObj2[i] = tmpObj[i].substring(0,3);
		}
		//alert(tmpObj2.join().replace(",","','"));
		
		var sXml = sheetObj.GetSearchXml("ESM_BKG_0499GS.do", FormQueryString(formObj)+"&p_lane="+tmpObj2.join().replace(",","','"));
		var combo_vvd= ComGetEtcData(sXml, "vvd");
		//alert(sXml);
		ComXml2ComboItem(sXml, comboObjectsMap['vvd'],'vvd', "vvd");
		comboObjectsMap['vvd'].InsertItem(0, "");
		ComOpenWait(false);
		sheetObj.WaitImageVisible = true;
		break;

	}
}


/**
 * IBTab Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++] = tab_obj;

}

/**
 * Tab 기본 설정
 * 탭의 항목을 설정한다.
 */
function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {
			var cnt = 0;
			InsertTab(cnt++, "Summary", -1);
			InsertTab(cnt++, "  Detail  ", -1);
		}
		break;

	}
}

/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnChange(tabObj, nItem) {
	var objs = document.all.item("tabLayer");

	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";

	//--------------- 요기가 중요 --------------------------//
	objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
	//------------------------------------------------------//
	beforetab = nItem;
	tabIndex = nItem;

}

/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnClick(tabObj, nItem) {
	beforetab = nItem;
	tabIndex = nItem;
	if (isOpen) {
		if (nItem == 0 && isSummarySearch == false) {//Summery
			doActionIBSheet(sheetObjectsMap['t1sheet1'], document.form, IBSEARCH);
			sheetObjectsMap['t1sheet1'].SelectRow = 0;
		} else if (nItem == 1 && isDetailSearch == false) {//Detail
			doActionIBSheet(sheetObjectsMap['t2sheet1'], document.form, SEARCH01);
			sheetObjectsMap['t2sheet1'].SelectRow = 0;
		}
	}

}

function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		var arrTime = sCntrTypeSize.split(",");
		for ( var i = 1; i <= RowCount; i++) {//데이타 로우 수 - 헤더 개수 제외
			if(i <= RowCount-3 && i % 3 == 0) {
				RowBackColor(i) = RgbColor(201, 213, 235);
			}else if(i > RowCount-3) {
				RowBackColor(i) = RgbColor(247, 225, 237);//Total색상
				CellBackColor(i,'trade') = RgbColor(255, 255, 255);//Total색상
				CellBackColor(i,'sub_trade') = RgbColor(255, 255, 255);//Total색상 
				CellBackColor(i,'lane') = RgbColor(255, 255, 255);//Total색상
			}
		}
	}//end with
}



/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	if(sAction == IBSEARCH || sAction == SEARCH01){
		
			if (formObj.from_dt.value == "") {
				ComShowCodeMessage("BKG08231", "Period");
				ComSetFocus(formObj.from_dt);
				return false;
			} else if (formObj.to_dt.value == "") {
				ComShowCodeMessage("BKG08231", "Period");
				ComSetFocus(formObj.to_dt);
				return false;
			}
	
			if (formObj.from_dt.value.length < 6) {
				return false;
			} else if (formObj.to_dt.value.length < 6) {
				return false;
			}
			
			if (formObj.location.value == "") {
				ComShowCodeMessage("BKG08231", "Location");
				ComSetFocus(formObj.location);
				return false;
			}
			
			
			/*
			 * Detail 일경우 기간이 1달 이상이면 VVD가 필수 입력이다.
			 * */
			var p_from = formObj.from_dt.value.replace("-","");
			var p_to   = formObj.to_dt.value.replace("-","");

			/*
			 * Detail 일경우 기간이 1달 이상이면 VVD가 필수 입력이다.
			 * */
			var p_period = formObj.period.value;
			
			var frYearDate = p_from.substring(0, 4);
			var toYearDate = p_to.substring(0, 4);
			
			var frMonthDate = p_from.substring(4, 6);
			var toMonthDate = p_to.substring(4, 6);
			
			var betweencnt=0;
		
			var ffulldate ;
			var tfulldate ;
			var fYearFirstDate = Date.parse(frYearDate+'-01-01');//1월 1일
			var tYearFirstDate = Date.parse(toYearDate+'-01-01');//1월 1일
			
			if( p_period == "M" ){
				ffulldate = Date.parse(frYearDate+"-"+frMonthDate+"-01");//시작일
				tfulldate = Date.parse(toYearDate+"-"+toMonthDate+"-01").moveToLastDayOfMonth();//종료일					
			}else{
				if(eval(frMonthDate) ==1){
					ffulldate = fYearFirstDate.addWeeks(frMonthDate).addDays(-7);//시작일
				}else{
					ffulldate = fYearFirstDate.addWeeks(frMonthDate).addDays(-7).addDays(-fYearFirstDate.getDay());//시작일
				}

				if(eval(toMonthDate) ==1){
					tfulldate = tYearFirstDate.addWeeks(toMonthDate).addDays(-tYearFirstDate.getDay() -1);//시작일 '-1'은 기본적으로 1월 1일 부터 시작하므로 '7*몇주'에서 1일을 뺀다.
				}else{
					tfulldate = tYearFirstDate.addWeeks(toMonthDate).addDays(-tYearFirstDate.getDay()-1);//시작일
				}
			}
			
			
			if( p_period == "M" && p_from != p_to ){
				alert('조회 기간은 1개월을 초과 할수 없습니다.');
				return false;
			}else if( p_period == "W"){
				betweencnt = ComGetDaysBetween(ffulldate.toString('yyyy-MM-dd'),tfulldate.toString('yyyy-MM-dd')) +1;
				if(betweencnt > 30){
					alert('조회 기간은 30일을 초과 할수 없습니다('+betweencnt+'days).');
					return false;
				}
			}
			
			
			//상세화면에서는 VVD필수 입력항목
			
			if (sAction == SEARCH01 && ComGetObjValue(formObj.vvd) == "") {
				ComShowCodeMessage("BKG08231", "vvd");
				return false;
			}
			
 	}//end if

	return true;
}

