/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0767.js
 *@FileTitle : booking report
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.04
 *@LastModifier : 강동윤
 *@LastVersion : 1.0
 * 2009.06.04 강동윤
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
 * @class esm_bkg_0767 : esm_bkg_0767 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0767() {
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

var searchXml = "";

var beforeIdx = 0;

var newItemIdx = 0;

var comboCnt = 0;
var comboObjects = new Array();

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

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

		sheetObjects[i].isible = false;

		initSheet(sheetObjects[i], i + 1);

		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	for ( var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], comboObjects[k].id);
	}

	addSetting(true);

	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);

	initControl();
}

/**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */
function initCombo(comboObj, comboId) {
	var formObject = document.form
	initComboEditable(comboObj, comboId)
}

//콤보 멀티 셀렉트 및 수정 여부 초기 설정
function initComboEditable(combo, comboId) {
	with (combo) {
		if (comboId == "dlv_ctnt_cd") {
			//alert(comboId);
			MultiSelect = false;
			UseAutoComplete = true;
			UseEdit = false;

		} else {
			MultiSelect = true;
			UseEdit = false;

		}
	}
}

/**
 * 조회조건 입력할 때 처리
 */
function obj_KeyUp() {
	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	if (srcName == "ca_issue_off" || srcName == "bkg_off" || srcName == "del_off") {
		return;
	} else {
		if (ComChkLen(srcValue, srcMaxLength) == "2") {
			ComSetNextFocus();
		}
	}
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
	var formObject = document.form;
	// Axon 이벤트 처리1. 이벤트catch(개발자변경)

	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', formObject); // - 포커스 나갈때
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', formObject); // - 포커스 들어갈때
	// axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); //- 키보드 입력할때
	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject);

	// axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
}

/**
 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
 **/
// function obj_keypress(){
// switch(event.srcElement.dataformat){
// case "ymd":
// //number
// ComKeyOnlyNumber(event.srcElement, "-");
// break;
// case "int":
// //숫자만입력하기
// ComKeyOnlyNumber(event.srcElement);
// break;
// case "float":
// //숫자+"."입력하기
// ComKeyOnlyNumber(event.srcElement, ".");
// break;
// case "eng":
// //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
// ComKeyOnlyAlphabet();
// break;
// case "engdn":
// //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
// ComKeyOnlyAlphabet('lower');
// break;
// case "engup":
// //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
// ComKeyOnlyAlphabet('upper');
// break;
// case "engupnum":
// //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
// ComKeyOnlyAlphabet('uppernum');
// break;
//
// default:
// //숫자만입력하기(정수,날짜,시간)
// ComKeyOnlyNumber(event.srcElement);
// }
// }
/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;
	switch (sheetID) {
		case "sheet1": //sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = 0;
				// 전체 너비 설정
				SheetWidth = 0;

				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);

				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msNone;

				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);

				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(7, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false, false)

				var HeadTitle = "";

				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
				// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus, 40, daCenter, true, "ibflag");
				InitDataProperty(0, cnt++, dtHidden, 25, daCenter, false, "rpt_id", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, false, "rpt_nm", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, false, "bkg_rpt_knd_cd", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, false, "bzc_cond_sql_ctnt", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, false, "bzc_ord_ctnt", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, false, "temp_seq", false, "", dfNone, 0, true, true);

			}
			break;

	}
}

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

			case "btn_add":
				formObject.dlv_ctnt_cd.Code = "";
				addTemplate(formObject);
				break;

			case "btn_delete":
				formObject.rpt_nm.disabled = false;
				formObject.dlv_ctnt_cd.Code = "";
				deleteTemplate(formObject);
				break;

			case "btn_save":
				doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
				break;

			case "btn_new":
				formObject.rpt_nm.disabled = false;
				formObject.dlv_ctnt_cd.Code = "";
				addSetting(true);
				formObject.reset();
				break;

			case "btn_close":
				window.close();
				break;

			case "btn_corr_sdate":
				var cal = new ComCalendar();
				cal.select(formObject.corr_from_dt, 'yyyy-MM-dd');
				break;

			case "btn_corr_edate":
				var cal = new ComCalendar();
				cal.select(formObject.corr_to_dt, 'yyyy-MM-dd');
				break;

			case "btn_cre_sdate":
				var cal = new ComCalendar();
				cal.select(formObject.cre_from_dt, 'yyyy-MM-dd');
				break;

			case "btn_cre_edate":
				var cal = new ComCalendar();
				cal.select(formObject.cre_to_dt, 'yyyy-MM-dd');
				break;
				
			 case "btn_cakind":
 				 ComOpenPopup("ESM_BKG_0758.do?pgmNo=ESM_BKG_0758", 300, 410, "", '1,0,1,1,1', true);
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

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

		case IBSEARCH: //조회						
			formObj.f_cmd.value = SEARCH;
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0767GS.do", FormQueryString(formObj));

			var arrXml = sXml.split("|$$|");
			searchXml = arrXml[0];

			ComXml2ComboItem(arrXml[1], formObj.elements["dlv_ctnt_cd"], "val", "name");

			sheetObj.LoadSearchXml(searchXml, false);

			var listSize = ComGetEtcData(searchXml, "listSize");

			if (listSize > 0) {

				for ( var i = 0; i < listSize; i++) {

					formObj.rpt_nm.options[i] = new Option(ComGetEtcData(searchXml, "rptNm_" + i), ComGetEtcData(searchXml,
							"rptId_" + i));
				}

				//setCondition(sheetObj.CellValue(1, 4), "",formObj);

				if (sheetObj.CellValue(1, 6) != '' && sheetObj.CellValue(1, 6) != undefined) {

					formObj.rpt_nm[sheetObj.CellValue(1, 6)].selected = true;
					setCondition(ComGetEtcData(searchXml, "seq_" + sheetObj.CellValue(1, 6)), ComGetEtcData(searchXml, "ord_"
							+ sheetObj.CellValue(1, 6)), formObj);
				} else {
					formObj.rpt_nm[0].selected = true;
					setCondition(ComGetEtcData(searchXml, "seq_0"), ComGetEtcData(searchXml, "ord_0"), formObj);
				}
			}

			break;

		case IBSAVE: //저장

			if (!validateForm(sheetObj, formObj, sAction))
				return;

			if (formObj.add_value.value == "") {

				if (formObj.rpt_nm.length > 0) {
					var idx = formObj.rpt_nm.selectedIndex;
					var rpt_id = formObj.rpt_nm.options[idx].value;

					for ( var i = 1; i < sheetObj.LastRow + 1; i++) {

						if (sheetObj.CellValue(i, 1) == rpt_id) {

							sheetObj.CellValue2(i, 4) = makeOption(formObj);

							break;
						}
					}
				}
			} else {

				if (!validateForm(sheetObj, formObj, ADD))
					return;

				var addNm = formObj.add_value.value;

				formObj.add_value.value = "";

				var itemIdx = 0;

				sheetObj.DataInsert(-1);

				sheetObj.CellValue2(sheetObj.LastRow, 0) = "I";
				sheetObj.CellValue2(sheetObj.LastRow, 1) = "new|" + itemIdx;
				sheetObj.CellValue2(sheetObj.LastRow, 2) = addNm;
				sheetObj.CellValue2(sheetObj.LastRow, 3) = "C";
				sheetObj.CellValue2(sheetObj.LastRow, 4) = makeOption(formObj);

				beforeIdx = 0;
			}

			formObj.f_cmd.value = MULTI;
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("");

			sheetObj.DoSave("ESM_BKG_0767GS.do", sParam);

			break;

	}
	ComOpenWait(false);
}

/**
 * template add
 */

function addTemplate(formObj) {

	addSetting(false);

	formObj.reset();

	var itemIdx = newItemIdx++;

	var idx = formObj.rpt_nm.length;

	formObj.rpt_nm.options[idx] = new Option(" ", "new|" + itemIdx);

	formObj.rpt_nm[idx].selected = true;

	formObj.rpt_nm.disabled = true;

	formObj.add_value.focus();
}

/*
function addTemplate(formObject){
    
    var sheetObj = sheetObjects[0];
    
    if (formObject.rpt_nm.length > 0){
    
 	    var before_rpt_id 		= formObject.rpt_nm.options[beforeIdx].value;
 	    
 	    if(!validateForm(sheetObj,formObject,0)){

 	    	formObject.rpt_nm.selectedIndex = beforeIdx;    	    	    	    	
 	    	
    			return;
    	    }
 	    
 	    for (var i = 1 ; i < sheetObj.LastRow+1 ; i++){
     		
     		if (sheetObj.CellValue(i,1) == before_rpt_id){
     			
        		sheetObj.CellValue2(i, 4) = makeOption(formObject);
        		
        		if (sheetObj.CellValue(i, 0) != "I"){
     				
     				sheetObj.CellValue2(i, 0) = "U";
     			}else{
     				
     				sheetObj.CellValue2(i, 0) = "I";
     			}    
        		
        		break;
     		}
     	}
    }
   
	if (formObject.add_value.value == '') {
		
		ComShowCodeMessage("BKG08028");// Please input Add
		formObject.add_value.focus();
		return;
	}
	
	var itemIdx = newItemIdx++;
	
	var sheetObj = sheetObjects[0];
    
    sheetObj.DataInsert(-1);
    
    sheetObj.CellValue2(sheetObj.LastRow, 0) = "I";
	sheetObj.CellValue2(sheetObj.LastRow, 1) = "new|" + itemIdx;
	sheetObj.CellValue2(sheetObj.LastRow, 2) = formObject.add_value.value;
	sheetObj.CellValue2(sheetObj.LastRow, 3) = "C";
	sheetObj.CellValue2(sheetObj.LastRow, 4) = "";
	
	beforeIdx = sheetObj.LastRow-1;
	
	var idx = formObject.rpt_nm.length;

		formObject.rpt_nm.options[idx] = new Option(formObject.add_value.value,"new|" + itemIdx);
    
    formObject.reset();
    
    formObject.rpt_nm[idx].selected = true;	            
	
	formObject.add_value.value = "";
    
}
 */
/**
 * template delete
 */

function deleteTemplate(formObj) {

	var sheetObj = sheetObjects[0];

	if (formObj.rpt_nm.length == 0) {

		ComShowCodeMessage("BKG00751");// delete할 수 없는 상태입니다.

		return;
	}

	var maxIdx = formObj.rpt_nm.length;

	var idx = formObj.rpt_nm.selectedIndex;
	var rpt_id = formObj.rpt_nm.options[idx].value;
	/*
	 * if (maxIdx == 0){
	 * 
	 * ComShowCodeMessage("BKG08029");//Please Input Period formObject.add_value.focus();
	 * 
	 * return; }
	 */
	if (!ComShowCodeConfirm("BKG00535")) {//Are you sure to delete?

		return;
	}

	var temp = rpt_id.split("|");

	for ( var i = 1; i < sheetObj.LastRow + 1; i++) {

		if (temp.length > 1) {

			if (sheetObj.CellValue(i, 1) == rpt_id) {

				sheetObj.RowDelete(i, false);

				break;
			}
		} else {

			if (sheetObj.CellValue(i, 1) == rpt_id) {

				sheetObj.CellValue2(i, 0) = "D";

				break;
			}
		}
	}

	formObj.rpt_nm.remove(idx);

	if (formObj.rpt_nm.length > 0) {

		beforeIdx = formObj.rpt_nm.selectedIndex;

		var new_rpt_id = formObj.rpt_nm.options[beforeIdx].value;

		for ( var i = 1; i < sheetObj.LastRow + 1; i++) {

			if (sheetObj.CellValue(i, 1) == new_rpt_id) {

				setCondition(sheetObj.CellValue(i, 4), "", formObj);
			}
		}

	} else {

		beforeIdx = 0;

		formObj.reset();
	}

}

function setTemplate(reValue) {

	var formObject = document.form

	var idx = formObject.rpt_nm.length;

	var tempValue = reValue.split("|");

	for ( var i = 0; i < tempValue.length; i++) {

		var tempValue2 = tempValue[i].split(">");

		if (tempValue[i] != '') {

			formObject.rpt_nm.options[idx] = new Option(tempValue2[1], "new");

			idx++;
		}
	}
}

/**
 * change template name
 */

function changeNm() {

	var formObj = document.form;

	var sheetObj = sheetObjects[0];

	var before_rpt_id = formObj.rpt_nm.options[beforeIdx].value;

	var idx = formObj.rpt_nm.selectedIndex;
	var now_rpt_id = formObj.rpt_nm.options[idx].value;

	if (!validateForm(sheetObj, formObj, 0)) {

		formObj.rpt_nm.selectedIndex = beforeIdx;

		return;
	}

	if (now_rpt_id.indexOf("new|") == -1) {

		addSetting(true);
	} else {

		addSetting(false);
	}

	for ( var i = 1; i < sheetObj.LastRow + 1; i++) {

		if (sheetObj.CellValue(i, 1) == before_rpt_id) {

			sheetObj.CellValue2(i, 4) = makeOption(formObj);

			if (sheetObj.CellValue(i, 0) != "I") {

				sheetObj.CellValue2(i, 0) = "U";
			} else {

				sheetObj.CellValue2(i, 0) = "I";
			}

			break;
		}
	}

	for ( var i = 1; i < sheetObj.LastRow + 1; i++) {

		if (sheetObj.CellValue(i, 1) == now_rpt_id) {

			setCondition(sheetObj.CellValue(i, 4), "", formObj);

			break;
		}
	}

	beforeIdx = idx;
}

/**
 * Make Option
 */
function makeOption(formObj) {

	var seq_ctnt = new Array();

	for ( var i = 0; i < formObj.length; i++) {

		if (formObj[i].name == "dlv_ctnt_cd") {
			seq_ctnt[i] = formObj[i].name + "=" + formObj[i].Code;
		} else {
			if (formObj[i].type == "checkbox") {

				if (formObj[i].checked == true) {

					seq_ctnt[i] = formObj[i].name + "=" + "Y";
				} else {

					seq_ctnt[i] = formObj[i].name + "=" + "N";
				}
			} else {
				/*
				if (formObj[i].name == "add_value"){
					
					seq_ctnt[i] = formObj[i].name + "=";
				}else{
				
					seq_ctnt[i] = formObj[i].name + "=" + formObj[i].value;
				}
				 */
				seq_ctnt[i] = formObj[i].name + "=" + formObj[i].value;
			}
		}
	}

	return seq_ctnt.join("|");
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObject, sAction) {

	if (formObject.rpt_nm.length > 0 && sheetObj.LastRow > 1) {

		if (!ComChkValid(formObject))
			return false;

		if (formObject.rpt_nm.length < 1) {

			ComShowCodeMessage("BKG08030");// Please Input Template Name
			formObject.add_value.focus();
			return false;
		}
		/*
		if (formObject.corr_from_dt.value == ''){
			
			ComShowCodeMessage("BKG08029");// Please Input Period
			formObject.corr_from_dt.focus();
			return false;
		}
		
		if (formObject.corr_to_dt.value == ''){
			
			ComShowCodeMessage("BKG08029");// Please Input Period
			formObject.corr_to_dt.focus();
			return false;
		}
		 */
		if (formObject.vvd.value != '') {

			if (formObject.vvd.value.length < 9) {

				ComShowCodeMessage("BKG00780");// T.VVD is 9 Digits
				formObject.vvd.focus();
				return false;
			}
		}

		if (formObject.ca_issue_off.value != '') {

			if (formObject.ca_issue_off.value.length < 5) {

				ComShowCodeMessage("BKG08031");// C/A Issue Office is 5 Digits
				formObject.ca_issue_off.focus();
				return false;
			}
		}

	}

	if (sAction == ADD) {

		if (!ComChkValid(formObject))
			return false;
		/*
		 * if (formObject.corr_from_dt.value == ''){
		 * 
		 * ComShowCodeMessage("BKG08029");//Please Input Period formObject.corr_from_dt.focus(); return false; }
		 * 
		 * if (formObject.corr_to_dt.value == ''){
		 * 
		 * ComShowCodeMessage("BKG08029");//Please Input Period formObject.corr_to_dt.focus(); return false; }
		 */
		if (formObject.vvd.value != '') {

			if (formObject.vvd.value.length < 9) {

				ComShowCodeMessage("BKG00780");// T.VVD is 9 Digits
				formObject.vvd.focus();
				return false;
			}
		}

		if (formObject.ca_issue_off.value != '') {

			if (formObject.ca_issue_off.value.length < 5) {

				ComShowCodeMessage("BKG08031");// C/A Issue Office is 5 Digits
				formObject.ca_issue_off.focus();
				return false;
			}
		}
	}

	return true;
}

/**
 * 화면 폼명,입력값 설정
 */
function checkFormType(sheetObj, formObj, seq_ctnt, ord_ctnt) {

	ord_ctnt = "";

	for ( var i = 0; i < formObj.length; i++) {

		if (formObj[i].type == "checkbox") {

			if (formObj[i].checked == true) {

				seq_ctnt[i] = formObj[i].name + "=" + "Y";
			} else {

				seq_ctnt[i] = formObj[i].name + "=" + "N";
			}
		} else {

			seq_ctnt[i] = formObj[i].name + "=" + formObj[i].value;
		}
	}

	//alert(seq_ctnt.join("|"));
}

/**
 * condition setting
 */
function setCondition(seqValue, ordValue, formObj) {

	var seq_ctnt = new Array();
	var ord_ctnt = new Array();

	seq_ctnt = seqValue.split("|");
	// ord_ctnt = ordValue.split("|");

	for ( var i = 0; i < formObj.length; i++) {

		for ( var j = 0; j < seq_ctnt.length; j++) {

			var tempSeq = seq_ctnt[j].split("=");

			if (formObj[i].name == tempSeq[0]) {

				if (formObj[i].name == "dlv_ctnt_cd") {
					formObj[i].Code = tempSeq[1];
				} else {
					if (formObj[i].type == "checkbox") {

						if (tempSeq[1] == "Y") {

							formObj[i].checked = true;
						} else {

							formObj[i].checked = false;
						}
					} else {

						if (formObj[i].name != "rpt_nm") {

							if (tempSeq[1] != undefined) {

								formObj[i].value = tempSeq[1];
							} else {

								formObj[i].value = "";
							}
						}
					}
				}

				break;
			}
		}
	}

}

/**
 * background setting
 */
function addSetting(type) {

	var formObj = document.form;

	if (type) {

		formObj.add_value.readOnly = true;
		formObj.add_value.style.background = "#E8EFF9";
	} else {

		formObj.add_value.readOnly = false;
		formObj.add_value.style.background = "#FFFFFF";
	}
}

/**
 * Save End Event
 */
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {

	var formObj = document.form;

	if (ErrMsg.indexOf("Successfully") > -1) {

		sheetObj.RemoveAll();
		ComClearCombo(formObj.rpt_nm);
		ComResetAll();
		addSetting(true);
		formObj.rpt_nm.disabled = false;

		doActionIBSheet(sheetObj, formObj, IBSEARCH);

		window.opener.reSearch();
	}
}

/* 개발자 작업  끝 */