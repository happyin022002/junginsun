/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0985.js
 *@FileTitle : Queue Detail Return
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.21
 *@LastModifier : 김경섭
 *@LastVersion : 1.0
 * 2009.05.21 김경섭
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
 * @extends 
 * @class esm_bkg_0985  생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0985() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
	this.sheet1_OnClick = sheet1_OnClick;
	this.sheet1_OnKeyUp = sheet1_OnKeyUp;
}

/* 개발자 작업	*/
/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var rowsPerPage = 50;

var prefix = "";//IBSheet 구분자

var grp_cd = "";//Current Queue 조회를 위한 전역변수  
var queueMap = new Array();

/*********************** EDTITABLE MULIT COMBO START ********************/
var comboCnt = 0;
var comboObjects = new Array();

var return_yn = "N";
//페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
//ComComboObject생성자 메소드에서 호출됨
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}
/*********************** EDTITABLE MULIT COMBO END********************/

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	checkInitData(form);
	
}
/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}
/*
 * 페이지 로딩시 필요한 파라메터들을 확인한다.<br>
 * 파라메터가 정확하지 않을 경우 확인 메시지를 보내고 'Return' 버튼을 감춘다.
 * */
function checkInitData(formObj) {
	if (ComIsNull(formObj.src_cd) || ComIsNull(formObj.sr_no) || ComIsNull(formObj.bkg_no) || ComIsNull(formObj.sr_knd_cd)) {
		//div_return.style.display = "none";
		btn_return_l.className = "btn2_left";
		btn_return_c.className = "btn2";
		btn_return_r.className = "btn2_right";

		ComShowCodeMessage('BKG00626', 'SI CD, SI No., BKG No., Amend Type CD');
	}
}

function initControl() {
	var formObject = document.form;

	axon_event.addListenerFormat('keypress', 'bkg_keypress', formObject); //- 키보드 입력할때
	axon_event.addListenerFormat('beforedeactivate', 'bkg_deactivate', formObject); //- 포커스 나갈때     
	axon_event.addListenerFormat('beforeactivate', 'bkg_activate', formObject); //- 포커스 들어갈때
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
}

/*********************** KEY EVENT START ********************/
function bkg_keypress() {
	switch (event.srcElement.dataformat) {
		case "engup":
			//영문대문자
			ComKeyOnlyAlphabet('upper');
			break;
		case "engupnum":
			//숫자+"영문대분자"입력하기
			ComKeyOnlyAlphabet('uppernum');
			break;
		case "num":
			//숫자 입력하기
			ComKeyOnlyNumber(event.srcElement);
			break;
		case "custname":
			//숫자 입력하기
			ComKeyOnlyAlphabet('uppernum', '40|41|46|44|32|42|38|35|45');
			break;
		default:
	}
}

/**
 * HTML Control의 onBlur을 제어한다.
 **/
function bkg_deactivate() {

	var formObj = document.form;
	switch (event.srcElement.getAttribute("name")) {
		case "dura_from_dt":
			ComAddSeparator(event.srcElement);
			break;
		case "dura_to_dt":
			ComAddSeparator(event.srcElement);
			break;

		default:
			break;
	}
}

/**
 * HTML Control의 onFocus 이벤트에서 Validation을 체크한다. <br>
 **/
function bkg_activate() {
	//입력Validation 확인하기
	switch (event.srcElement.name) {
		case "dura_from_dt":
			ComClearSeparator(event.srcElement);
			break;
		case "dura_to_dt":
			ComClearSeparator(event.srcElement);
			break;
		default:
			break;
	}
}

/*********************** KEY EVENT END ********************/

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];

	/*******************************************************/
	var formObject = document.form;

	try {

		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
			case "btn_return":
				if (return_yn == "Y")
					return;
				doActionIBSheet(sheetObject1, formObject, MODIFY01);
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

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction, Row, Col, PageNo) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
		case IBSEARCH:
			//if(!validateForm(sheetObj,formObj,sAction)) return;
			formObj.f_cmd.value = SEARCH;
			//sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0985GS.do", FormQueryString(formObj));
			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 1) 
				sheetObjects[1].LoadSearchXml(arrXml[1]); 
			if (arrXml.length > 0) 
				sheetObjects[0].LoadSearchXml(arrXml[0]); 
			
			sXml = arrXml[0];
			
			fnt_ofc_eml.innerHTML = ComGetEtcData(sXml, "fnt_ofc_eml");
			inputer_eml.innerHTML = ComGetEtcData(sXml, "inputer_eml");
			rater_eml.innerHTML = ComGetEtcData(sXml, "rater_eml");
			cust_eml.innerHTML = ComGetEtcData(sXml, "cust_eml");
			fnt_from_eml.innerHTML = "{"+ComGetEtcData(sXml, "fo_rcv_eml")+"}";
			srep_eml.innerHTML = ComGetEtcData(sXml, "srep_eml");
			
			//fnt_ofc_eml_s.innerHTML = ComGetEtcData(sXml, "fnt_ofc_eml");
			ComSetObjValue(form.eml_subj_ctnt,ComGetEtcData(sXml, "eml_subj_ctnt"));
			ComSetObjValue(form.eml_cpy_to_cust_flg,ComGetEtcData(sXml, "eml_cpy_to_cust_flg"));
			ComSetObjValue(form.st_dt,ComGetEtcData(sXml, "st_dt"));
			ComSetObjValue(form.fo_rcv_eml,ComGetEtcData(sXml, "fo_rcv_eml"));
			
			return_yn = ComGetEtcData(arrXml[0], "return_yn")
			
			if (return_yn == "Y") {
				for ( var i = 0; i < form.ui_grp_cd.length; i++) {
					if (form.ui_grp_cd[i].value == ComGetEtcData(sXml, "ui_grp_cd")) {
						form.ui_grp_cd[i].checked = true;
						break;
					}
				}
				
				form.rtn_to_usr_eml.value = ComGetEtcData(sXml, "rtn_to_usr_eml");
				form.message.value = ComGetEtcData(sXml, "message");
				if (ComGetEtcData(sXml, "rsn_bkg_mn_flg") == "Y")
					form.rsn_bkg_mn_flg.checked = true;
				if (ComGetEtcData(sXml, "rsn_cust_info_flg") == "Y")
					form.rsn_cust_info_flg.checked = true;
				if (ComGetEtcData(sXml, "rsn_frt_chg_flg") == "Y")
					form.rsn_frt_chg_flg.checked = true;
				if (ComGetEtcData(sXml, "rsn_cntr_flg") == "Y")
					form.rsn_cntr_flg.checked = true;
				if (ComGetEtcData(sXml, "rsn_cntr_mf_flg") == "Y")
					form.rsn_cntr_mf_flg.checked = true;

				if (ComGetEtcData(sXml, "rsn_dcgo_flg") == "Y")
					form.rsn_dcgo_flg.checked = true;
				if (ComGetEtcData(sXml, "rsn_awk_cgo_flg") == "Y")
					form.rsn_awk_cgo_flg.checked = true;
				if (ComGetEtcData(sXml, "rsn_rc_flg") == "Y")
					form.rsn_rc_flg.checked = true;
				if (ComGetEtcData(sXml, "rsn_bb_cgo_flg") == "Y")
					form.rsn_bb_cgo_flg.checked = true;
				if (ComGetEtcData(sXml, "rsn_rly_port_flg") == "Y")
					form.rsn_rly_port_flg.checked = true;

				if (ComGetEtcData(sXml, "rsn_new_bkg_flg") == "Y")
					form.rsn_new_bkg_flg.checked = true;
				if (ComGetEtcData(sXml, "rsn_split_flg") == "Y")
					form.rsn_split_flg.checked = true;
				if (ComGetEtcData(sXml, "rsn_bl_info_flg") == "Y")
					form.rsn_bl_info_flg.checked = true;
				if (ComGetEtcData(sXml, "rsn_hbl_flg") == "Y")
					form.rsn_hbl_flg.checked = true;
				if (ComGetEtcData(sXml, "cust_verif_flg") == "Y")
					form.cust_verif_flg.checked = true;

				ComBtnDisable("btn_return");
			}else{
				setMessage();
			}
			break;

		case MODIFY01: //저장
			formObj.f_cmd.value = MULTI;
			if (!validateForm(sheetObj, formObj, sAction))
				return;
			
			if ( ComGetObjValue(formObj.eml_cpy_to_cust_flg) == "Y" && ComShowCodeConfirm("BKG08111") == false) return;
			
			var sParam = FormQueryString(formObj);
			var SaveStr = sheetObjects[0].GetSaveString(false); 
			if (sheetObjects[1].RowCount("U") > 0 ){
				SaveStr += "&"+ sheetObjects[1].GetSaveString(false) ; 
			}
			var sXml = sheetObj.GetSaveXml("ESM_BKG_0985GS.do?"+sParam, SaveStr);
			if (ComGetEtcData(sXml, "success_yn") == "Y") {
				ComShowCodeMessage('COM130102', 'Data');
				window.opener.inintSearch();
				self.close();
			} else {
				ComShowCodeMessage('COM130103', 'Data');
			}
			break;

	}
}
function getChkBoxValCnt(form) {
	var j = 0;
	// 사용가능한 컨트롤을 배열로 생성한다.
	var len = form.elements.length;
	for (i = 0; i < len; i++) {
		//클래스 아이디로 제품을 구분함-아래는 HTMl제품
			switch (form.elements[i].type) {
				case "checkbox":
					if (form.elements[i].checked == true) {
						j++;
					}
					break;
			}
	}
	return j;
}    
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {

		case MODIFY01:
			if (ComIsNull(formObj.src_cd) || ComIsNull(formObj.sr_no) || ComIsNull(formObj.bkg_no) || ComIsNull(formObj.sr_knd_cd)) {
				return false;
			}
			
			if (ComGetObjValue(formObj.eml_cpy_to_cust_flg) == "Y"){
				var eml = ComGetObjValue(formObj.rtn_to_usr_eml);
				var arrEml=eml.split(";");
			    for(var idx=0;idx<arrEml.length;idx++){
			    	if (ComIsEmailAddr(arrEml[idx]) == false){
						ComShowCodeMessage('BKG00366');
						ComSetFocus(formObj.rtn_to_usr_eml);
						return false;
					}
			    }
			    if (!ComChkValid(formObj))
					return false;
			    
			}
			if (getRadioValue2(formObj.ui_grp_cd) == "") {
				ComShowCodeMessage('BKG00626', 'Return to');
				formObj.ui_grp_cd[0].focus();
				return false;
			}
			if ((sheetObjects[0].RowCount("U") < 1 
					&& sheetObjects[1].RowCount("U") < 1 )
					/*|| getChkBoxValCnt(formObj) < 1*/
					){
				ComShowCodeMessage("BKG01160");
				return false;
			}
			
			break;
	}

	return true;
}

function isNullEtcData(xmlStr) {
	var rtn = false;
	var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
	xmlDoc.loadXML(xmlStr);

	var xmlRoot = xmlDoc.documentElement;
	if (xmlRoot == null)
		return true;

	var etcDataNode = xmlRoot.getElementsByTagName("ETC-DATA").item(0);
	if (etcDataNode == null)
		return true;

	var etcNodes = etcDataNode.childNodes;
	if (etcNodes == null)
		return true;
	if (etcNodes.length == 0)
		rtn = true;

	return rtn;
}

function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	switch (sheetNo) {
		case 1:
			with (sheetObj) {

				// 높이 설정
				style.height = 180;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;

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
				InitColumnInfo(5, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false, false)

				var HeadTitle = "|Sel|Seq.|Data Missing ...(M)|";

				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				prefix = ""
				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
				// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
				// SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, prefix + "ibflag");
				InitDataProperty(0, cnt++, dtCheckBox, 25, daCenter, true, prefix + "sel", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtDataSeq, 40, daCenter, false, prefix + "Seq", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 120, daLeft, false, prefix + "name", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, prefix + "code");

			}
			break;
		case 2:
			with (sheetObj) {

				// 높이 설정
				style.height = 180;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;

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
				InitColumnInfo(5, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false, false)

				var HeadTitle = "|Sel|Seq.|Discrepancy ...(D)|";

				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				prefix = ""
				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
				// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
				// SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, prefix + "ibflag");
				InitDataProperty(0, cnt++, dtCheckBox, 25, daCenter, true, prefix + "sel", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtDataSeq, 40, daCenter, false, prefix + "Seq", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 120, daLeft, false, prefix + "name", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, prefix + "code");

			}
			break;
	}
}
function sheet1_OnChange(sheetObj, Row, Col, Value){
	var prefix = "sheet1_";
	var formObject = document.form;
	if (sheetObj.ColSaveName(Col) == "sel"){
		setMessage();
	}
}
function sheet2_OnChange(sheetObj, Row, Col, Value){
	var prefix = "sheet2_";
	if (sheetObj.ColSaveName(Col) == "sel"){
		setMessage();
	}
}
function setMessage(){
	if (return_yn == "Y") return;
	
	var formObject = document.form;
	var message = "";
	message += "*BKG No	: " + ComGetObjValue(formObject.bkg_no) + "\n\n";
	message +=  ComGetMsg("BKG01161") +"\n\n";
	
	if (sheetObjects[0].RowCount("U") > 0
			|| sheetObjects[1].RowCount("U") > 0 ){
		with (sheetObjects[0]) {   
			var prefix = "";
			for ( var i = 1; i <= RowCount; i++) {
				if (CellValue(i, prefix+"sel") == '1') {
					message +="- "+CellValue(i, prefix+"name") +"\n";
				}
			}
		}	
		with (sheetObjects[1]) {   
			var prefix = "";
			for ( var i = 1; i <= RowCount; i++) {
				if (CellValue(i, prefix+"sel") == '1') {
					message +="- "+CellValue(i, prefix+"name") +"\n";
				}
			}
		}
		message += "\n";
		message +=  ComGetMsg("BKG01162");
	}
	ComSetObjValue(form.message,message);
}

function setRtnTo(val){
	var formObj = document.form;
	if (val == "S"){
		ComSetObjValue(formObj.rtn_to_usr_eml,replaceStr(fnt_ofc_eml.innerHTML));
	}else if (val == "I"){
		ComSetObjValue(formObj.rtn_to_usr_eml,replaceStr(inputer_eml.innerHTML));
	}else if (val == "R"){
		ComSetObjValue(formObj.rtn_to_usr_eml,replaceStr(rater_eml.innerHTML));
	}else if (val == "C"){
		ComSetObjValue(formObj.rtn_to_usr_eml,replaceStr(cust_eml.innerHTML));
	}else if (val == "P"){
		ComSetObjValue(formObj.rtn_to_usr_eml,replaceStr(srep_eml.innerHTML));
	}
}
function replaceStr(val){
	var sVal = val.split("}");
	return ComReplaceStr(ComReplaceStr(ComRtrim(sVal[0],"}"),"{",""),"}","");
}

function setRtnFrom(obj){
	var formObj = document.form;
	if (obj.checked){
		if (ComGetObjValue(formObj.fo_rcv_eml) ==""){
			ComSetObjValue(formObj.rtn_from,ComGetObjValue(formObj.strUsr_eml));
		}else{
			ComSetObjValue(formObj.rtn_from,ComGetObjValue(formObj.fo_rcv_eml));
		}	
	}else{
		ComSetObjValue(formObj.rtn_from,ComGetObjValue(formObj.strUsr_eml));
	}
}

/* 개발자 작업  끝 */