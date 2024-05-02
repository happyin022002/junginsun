/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : VOP_FCM_0054.js
 *@FileTitle : FOC Simulation by Speed
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.04.04
 *@LastModifier : 진마리아
 *@LastVersion : 1.0
 * 2011.12.23 진마리아
 * 1.0 Creation
 * 
 * History
 * 2012.04.04 진마리아 CHM-201216636-01 [FCM] ALPS 모델 및 DB 구조 불일치 복구
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
 * @class VOP_FCM_0054 : VOP_FCM_0054 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_FCM_0054() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm;
}

/* 개발자 작업 */

// 공통전역변수
var sheetObjects = new Array();
var chartObjects = new Array();
var sheetCnt = 0;
var chartCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */

	var sheetObject = sheetObjects[0];

	/** **************************************************** */
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_New":
			clearAll();
			break;
			
		case "btn_Simulation":
			if(sheetObjects[0].RowCount>0){
				calcRslt();
			}
			break;

		case "btn_vsl_cd":
			var sUrl = "/hanjin/VOP_VSK_0219.do?vsl_cd=" + formObj.vsl_cd.value + "&inc_del_vsl_pop=Y";
    		ComOpenPopup(sUrl, 460, 500, "getVslCdData", "0,0", true);
			break;
			
		case "rdo_tran":
			setItem(formObj);
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
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	
	var formObj = document.form;

	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}

	initControl();
	controlPeriod(formObj, false);
}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * 
 * @param {ibsheet} sheetObj IBSheet Object
 * @param {int} sheetNo sheetObjects 배열에서 순번
 */
function initControl() {
	var formObj = document.form;

	// Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerForm("focus", "obj_activate", formObj);
	axon_event.addListenerForm("keypress", "obj_keypress", formObj);
	axon_event.addListenerForm('change', 'obj_change', form);

}

 /**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */ 
 function initCombo(comboObj, comboNo) {
 	var formObject = document.form;
 	switch(comboObj.id) {  
 		case "vsl_clss_cd":
 			with (comboObj) {
 				MultiSelect = false; 
 				UseAutoComplete = true;
 				UseCode = true;
 				DropHeight = 190;
 				ColWidth = 50;
 			}
 		break;
 			
 		case "vsl_clss_sub_cd":
 			with (comboObj) {
 				MultiSelect = false; 
 				UseAutoComplete = true;
 				UseCode = true;
 				DropHeight = 190;
 				ColWidth = 50;
 			}
 		break;

 		case "vsl_slan_cd": 
 			with (comboObj) { 
 				MultiSelect = false; 
 				UseAutoComplete = true;
 				UseCode = true;
 				DropHeight = 190;
 				MaxLength = 3;
 			}
 		break; 	
 	
 		case "skd_dir_cd":
 			with (comboObj) {
 				MultiSelect = false; 
 				UseAutoComplete = true;	
 				UseCode = true;
 				DropHeight = 190;
 				MaxLength = 1;
 			}
 	 	break;
 	}
 }
 
function obj_activate() {
	if (event.srcElement.options) {
		event.srcElement.focus();
	} else {
		event.srcElement.select();
	}
}

function obj_keypress(){
	obj = event.srcElement;
	if(obj.dataformat == null) return;

	window.defaultStatus = obj.dataformat;

	switch(obj.dataformat) {
		case "ym": case "ymd":
			ComKeyOnlyNumber(obj);
			break;
		case "num":
			ComKeyOnlyNumber(obj);
			break;
		case "eng":
			ComKeyOnlyAlphabet(); 
			break;
		case "engup":
			ComKeyOnlyAlphabet('upper');
			break;
		case "engdn":
//			ComKeyOnlyAlphabet('lowernum')
			ComKeyOnlyAlphabet('lower');
			break;
		case "uppernum":
			ComKeyOnlyAlphabet('uppernum');
			break;
		case "float":
			ComKeyOnlyNumber(obj,".");
			break;
	}
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;
	var prefix = sheetID + "_";
	
	switch (sheetNo) {
	case 1: // t1sheet1 init [Departure Report]
		with (sheetObj) {

			tabIndex = -1;

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
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			var HeadTitle = "|tp cd|CHT|tp sub cd|Class|Sub\nClass|Lane|Vessel|Bound|X2|X|C|MAX|MIN|Updated\nDate|Updated\nID|applied slip";
			
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
//			sheetObj.FrozenCols = 4;

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			//데이터속성                 [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME
			InitDataProperty(0, cnt++ , dtHiddenStatus,		0,		daCenter,  false,   	prefix+"ibflag");
			InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,		prefix+"trnd_line_tp_cd",	false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,		prefix+"trnd_line_cht_tp_cd",	false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,		prefix+"trnd_line_tp_sub_cd",	false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,		prefix+"vsl_clss_cd",		false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,		prefix+"vsl_clss_sub_cd",	false,		"",			dfNone,		0,			false,		false);	
			InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,		prefix+"vsl_slan_cd",		false,		"",			dfNone,		0,			false,		false);	
			InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,		prefix+"vsl_cd",			false,		"",			dfNone,		0,			false,		false);	
			InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,		prefix+"skd_dir_cd",		false,		"",			dfNone,		0,			false,		false);	
			InitDataProperty(0, cnt++ , dtData,		80,		daLeft,		true,		prefix+"n1st_coef_val",		false,		"",			dfNone,		0,			false,		false);	
			InitDataProperty(0, cnt++ , dtData,		80,		daLeft,		true,		prefix+"n2nd_coef_val",		false,		"",			dfNone,		0,			false,		false);	
			InitDataProperty(0, cnt++ , dtData,		90,		daLeft,		true,		prefix+"trnd_line_cons_val",			false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,		prefix+"op_max_spd",		false,		"",			dfNone,		0,			false,		false);	
			InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,		prefix+"op_min_spd",		false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,		prefix+"upd_dt",			false,		"",			dfNone,		0,			false,		false);	
			InitDataProperty(0, cnt++ , dtData,		50,		daLeft,		true,		prefix+"upd_usr_id",		false,		"",			dfNone,		0,			false,		false);	
			InitDataProperty(0, cnt++ , dtData,		50,		daLeft,		true,		prefix+"aply_slp_rt",		false,		"",			dfNone,		0,			false,		false);	
			
			CountPosition = 0;
		}
		break;
		
	case 2:
		with (sheetObj) {

			tabIndex = -1;

			// 높이 설정
			style.height = 350;
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
			InitRowInfo(1, 1, 3, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false, false)

			var HeadTitle = "|Speed|RPM|Load|FOC";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,		0,		daCenter,  false,   	prefix+"ibflag"				);
			InitDataProperty(0, cnt++ , dtData,				50,		daCenter,	true,		prefix+"calc_spd"			);
			InitDataProperty(0, cnt++ , dtData,				290,	daCenter,	true,		prefix+"sail_avg_rpm_pwr"	);
			InitDataProperty(0, cnt++ , dtData,				290,	daCenter,	true,		prefix+"load"				);
			InitDataProperty(0, cnt++ , dtData,				290,	daCenter,	true,		prefix+"day_mn_foil_csm_qty");
			
			CountPosition = 0;
		}
		break;
	}
}


//function getCoefficient(sheetObj, row, degree){
//	var coefficient = 0;
//	var saveName = "";
//	if(degree==2){
//		saveName = "n1st_coef_val";
//	}else if(degree==1){
//		saveName = "n2nd_coef_val";
//	}else if(degree==0){
//		saveName = "trnd_line_cons_val";
//	}
//	if(sheetObj.SearchRows>0){
//		coefficient = Number(sheetObj.CellValue(row, saveName));
//	}
//	return coefficient;
//}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;
	switch (sAction) {
	case IBSEARCH: // 조회
		if (validateForm(sheetObj, formObj, sAction)) {
			var aryPrefix = new Array( "sheet1_");
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			var rXml = sheetObj.GetSearchXml("VOP_FCM_0054GS.do", FormQueryString(formObj)+"&"+ComGetPrefixParam(aryPrefix));
			sheetObj.LoadSearchXml(rXml);
			ComOpenWait(false);
		}
		break;
		
	case SEARCH01: // Vessel Code가 Trnd Line이 생성되어 있는 vsl인지 check
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH01;
			var sXml = sheetObj.GetSearchXml("VOP_FCM_0054GS.do", FormQueryString(formObj));
			ComOpenWait(false);
			var isVslOk = ComGetEtcData(sXml, "is_vsl_ok");
			if(isVslOk=="N"){
				ComShowMessage(formObj.vsl_cd.value + " is not available in here.");
				formObj.vsl_cd.value="";
				formObj.vsl_cd.focus();
			}else{
				var dirCd = ComGetEtcData(sXml, "skd_dir_cd");
				if(dirCd != null && dirCd != undefined && dirCd != ""){
					formObj.skd_dir_cd.RemoveAll();
					var dirCdArr = dirCd.split("|");
					for (var i = 0 ; i < dirCdArr.length ; i++) {
						formObj.skd_dir_cd.InsertItem(-1, dirCdArr[i], dirCdArr[i]);
					}
				}
			}
		}
		break;
		
	case SEARCH02: // DZN Capa, Sub Class, lane 정보를 불러온다.
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH02;
			var sXml = sheetObj.GetSearchXml("VOP_FCM_0054GS.do", FormQueryString(formObj));
			ComOpenWait(false);
			var vslClssCd = ComGetEtcData(sXml, "vsl_clss_cd");
			var vslClssSubCd = ComGetEtcData(sXml, "vsl_clss_sub_cd");
			var vslSlanCd = ComGetEtcData(sXml, "vsl_slan_cd");
			
			if(formObj.vsl_clss_cd.Code==""){
				if(vslClssCd != null && vslClssCd != undefined && vslClssCd != ""){
					formObj.vsl_clss_cd.RemoveAll();
					var vslClssCdArr = vslClssCd.split("|");
					for (var i = 0 ; i < vslClssCdArr.length ; i++) {
						formObj.vsl_clss_cd.InsertItem(-1, vslClssCdArr[i], vslClssCdArr[i]);
					}
				}
			}
			if(formObj.vsl_clss_cd.Code!="" && formObj.vsl_clss_sub_cd.Code==""){
				if(vslClssSubCd != null && vslClssSubCd != undefined && vslClssSubCd != ""){
					formObj.vsl_slan_cd.RemoveAll();
					var vslClssSubCdArr = vslClssSubCd.split("|");
					for (var i = 0 ; i < vslClssSubCdArr.length ; i++) {
						formObj.vsl_clss_sub_cd.InsertItem(-1, vslClssSubCdArr[i], vslClssSubCdArr[i]);
					}
				}
			}
			if(formObj.vsl_clss_cd.Code!="" && formObj.vsl_slan_cd.Code==""){
				if(vslSlanCd != null && vslSlanCd != undefined && vslSlanCd != ""){
					formObj.vsl_slan_cd.RemoveAll();
					var vslSlanCdArr = vslSlanCd.split("|");
					for (var i = 0 ; i < vslSlanCdArr.length ; i++) {
						formObj.vsl_slan_cd.InsertItem(-1, vslSlanCdArr[i], vslSlanCdArr[i]);
					}
				}
			}
			
		}
		break;

	}
}

/*
* 조회 후처리
*/
function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	var formObj = document.form;
	if(sheetObj.RowCount>0){
		formObj.calc_spd_fm.value="";
		formObj.calc_spd_to.value="";
		formObj.aply_slp_rt.value=sheetObj.CellValue(sheetObj.HeaderRows, "sheet1_aply_slp_rt");
		controlPeriod(formObj, true);
//		ComEnableObject(formObj.calc_spd_fm, true);
//		ComEnableObject(formObj.calc_spd_to, true);
		sheetObjects[1].RemoveAll();
	}
}

function obj_change(){
	var formObj = document.form;
	obj = event.srcElement;   
	
	with(formObj){
		switch(obj.name) {

			case "vsl_cd":
				if(vsl_cd.value!="" && vsl_cd.value.length=="4"){
					doActionIBSheet(sheetObjects[0], formObj, SEARCH01);
				}
			break;
			
			case "calc_spd_fm":
				if(calc_spd_fm.value!=""){
//					if(calc_spd_to.value!=""){
//						if(Number(clac_spd_fm.value)>Number(calc_spd_to.value)){
//							ComShowMessage("fm이 to보다 큽니다.");
//							calc_spd_fm.value="";
//							calc_spd_fm.focus();
//							break;
//						}
//					}
					var min = Number(sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_op_min_spd"));
					var max = Number(sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_op_max_spd"));
					if(Number(calc_spd_fm.value)<min || Number(calc_spd_fm.value)>max){
						ComShowMessage("Speed는 "+min+"과 "+max+" 사이의 범위여야 합니다.");
						calc_spd_fm.value="";
						calc_spd_fm.focus();
						break;
					}
					if(!ComChkObjValid(obj)){
						calc_spd_fm.value="";
						calc_spd_fm.focus();
					}
				}
				break;
				
			case "calc_spd_to":
				if(calc_spd_to.value!=""){
//					if(calc_spd_fm.value!=""){
//						if(Number(calc_spd_fm.value)>Number(calc_spd_to.value)){
//							ComShowMessage("fm이 to보다 큽니다.")
//							calc_spd_to.value="";
//							calc_spd_to.focus();
//							break;
//						}
//					}
					var min = Number(sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_op_min_spd"));
					var max = Number(sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_op_max_spd"));
					if(Number(calc_spd_to.value)>max || Number(calc_spd_to.value)<min){
						ComShowMessage("Speed는 "+min+"과 "+max+" 사이의 범위여야 합니다.");
						calc_spd_to.value="";
						calc_spd_to.focus();
						break;
					}
					if(!ComChkObjValid(obj)){
						calc_spd_to.value="";
						calc_spd_to.focus();
					}
				}
				break;
		}
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	return true;
}

/**
 * radio 버튼 선택에 의해 조건들을 setting
 */
function setItem(formObj) {
	if(formObj.rdo_tran[0].checked){
		document.getElementById("transVsl").style.display = "inline";
		document.getElementById("transCapa").style.display = "none";
		clearAll();
	}else{
		document.getElementById("transVsl").style.display = "none";
		document.getElementById("transCapa").style.display = "inline";
		clearAll();
		doActionIBSheet(sheetObjects[0], formObj, SEARCH02);
	}
}

 function skd_dir_cd_OnChange(){
	 var formObj = document.form;
	 doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
 }
 
 function vsl_clss_cd_OnChange(){
	 var formObj = document.form;
	 formObj.vsl_clss_sub_cd.RemoveAll();
	 formObj.vsl_slan_cd.RemoveAll();
	 doActionIBSheet(sheetObjects[0], formObj, SEARCH02);
 }
 
 function vsl_clss_sub_cd_OnChange(){
	 var formObj = document.form;
	 formObj.vsl_slan_cd.RemoveAll();
	 doActionIBSheet(sheetObjects[0], formObj, SEARCH02);
 }
 
 function vsl_slan_cd_OnChange(){
	 var formObj = document.form;
	 doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
 }
 
 function calcRslt(){
	 var formObj = document.form;
	 var sheetObj1 = sheetObjects[0];
	 var sheetObj2 = sheetObjects[1];
	 if(formObj.calc_spd_fm.value==""){
		 formObj.calc_spd_fm.value = sheetObj1.CellValue(sheetObj1.HeaderRows, "sheet1_op_min_spd");
	 }
	 if(formObj.calc_spd_to.value==""){
		 formObj.calc_spd_to.value = sheetObj1.CellValue(sheetObj1.HeaderRows, "sheet1_op_max_spd");
	 }
	 sheetObj2.RemoveAll();
	 var calcFm = Number(formObj.calc_spd_fm.value);
	 var calcTo = Number(formObj.calc_spd_to.value);
	 var term = Number(formObj.term.value);
	 var coef2="";
	 var coef1="";
	 var cons="";
	 if(calcFm<=calcTo){
		 for(var i=calcFm; i<=calcTo; i=i+term){
			 calcData(sheetObj1, sheetObj2, i);
		 }
	 }else{
		 for(var i=calcFm; i>=calcTo; i=i-term){
			 calcData(sheetObj1, sheetObj2, i);
		 }
	 }
 }
 
 function calcData(sheetObj1, sheetObj2, i){
	 var row=sheetObj2.DataInsert(-1);
	 sheetObj2.CellValue(row, "sheet2_calc_spd") = i;
	 
	 coef2=getCoefficient(sheetObj1, 1, 2);
	 coef1=getCoefficient(sheetObj1, 1, 1);
	 cons=getCoefficient(sheetObj1, 1, 0);
	 sheetObj2.CellValue(row, "sheet2_day_mn_foil_csm_qty") = round(calcFoc(coef2,coef1,cons,i),1);
	 
	 coef2=getCoefficient(sheetObj1, 2, 2);
	 coef1=getCoefficient(sheetObj1, 2, 1);
	 cons=getCoefficient(sheetObj1, 2, 0);
	 sheetObj2.CellValue(row, "sheet2_sail_avg_rpm_pwr") = round(calcFoc(coef2,coef1,cons,i),1);
	 
	 coef2=getCoefficient(sheetObj1, 3, 2);
	 coef1=getCoefficient(sheetObj1, 3, 1);
	 cons=getCoefficient(sheetObj1, 3, 0);
	 sheetObj2.CellValue(row, "sheet2_load") = round(calcFoc(coef2,coef1,cons,i),1);
 }
 function getCoefficient(sheetObj, row, degree){
 	var coefficient = 0;
 	var saveName = "";
 	if(degree==2){
 		saveName = "n1st_coef_val";
 	}else if(degree==1){
 		saveName = "n2nd_coef_val";
 	}else if(degree==0){
 		saveName = "trnd_line_cons_val";
 	}
 	if(sheetObj.SearchRows>0){
 		coefficient = Number(sheetObj.CellValue(row, "sheet1_"+saveName));
 	}
 	return coefficient;
 }
 

 function clearAll(str){
	 var formObj = document.form;
	 formObj.vsl_cd.value="";
	 formObj.calc_spd_fm.value="";
	 formObj.calc_spd_to.value="";
	 formObj.aply_slp_rt.value="";
	 formObj.vsl_slan_cd.RemoveAll();
	 formObj.vsl_clss_cd.Code="";
	 formObj.vsl_clss_sub_cd.RemoveAll();
	 formObj.skd_dir_cd.RemoveAll();
	 for(var i=0; i<sheetObjects.length; i++){
		 sheetObjects[i].RemoveAll();
	 }
	 controlPeriod(formObj, false);
//	ComEnableObject(formObj.calc_spd_fm, false);
//	ComEnableObject(formObj.calc_spd_to, false);
 }
 
 function getVslCdData(obj){
	 if(obj){
		 var rtnDatas = obj[0];
		 if(rtnDatas){
			 if(rtnDatas.length > 0){
				 document.form.vsl_cd.value = rtnDatas[1];
				 doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
			 }
		 }
	 }
 }

function controlPeriod(formObj, useflag){
	
	var fmObj = formObj.calc_spd_fm;
	var toObj = formObj.calc_spd_to;
	
	if(useflag){
		
		fmObj.readOnly = false;
		toObj.readOnly = false;
		fmObj.className = "input";
		toObj.className = "input";
	
	}else{
		
		fmObj.readOnly = true;
		toObj.readOnly = true;
		fmObj.className = "input2";
		toObj.className = "input2";
		
	}
	
}
/* 개발자 작업 끝 */