/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_MST_0021.js
 *@FileTitle :  Container Specification Creation &amp; Update
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.11
 *@LastModifier : 김석준
 *@LastVersion : 1.0
 * 2009.05.11 김석준
 * 1.0 Creation
 *  ======================================================
 * 2011.06.13 나상보 [CHM-201111466-01] [MST] MDM에 R9 등록에 따른 추가 업무 진행 요청
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
 * @class ees_mst_0021 : ees_mst_0021 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ees_mst_0021() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initCombo = initCombo;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업	*/

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

// Combo Object Array
var comboObjects = new Array();
var comboCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	/** **************************************************** */
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
		case "btn_close":
			window.close();
			break;

		case "btn_Popup":
			openPopup();
			break;

		case "btn_new":
			doActionIBSheet(sheetObject1, formObj, IBINSERT);
			break;

		case "btn_save":
			doActionIBSheet(sheetObject1, formObj, IBSAVE);
			if (sheetObject1.RowStatus(1) == "U") // 저장후 조회
			{
				doActionIBSheet(sheetObject1, formObj, IBSEARCH);
			}			
			break;

		case "btn_delete":
			doActionIBSheet(sheetObject1, formObj, IBDELETE);
			break;
			
		case "btns_vndr":	// Lessor Code 가져오기 팝업
			ComOpenPopupWithTarget('/hanjin/COM_ENS_0C1.do', 700, 480, "vndr_seq:vndr_seq|vndr_lgl_eng_nm:vndr_lgl_eng_nm", "0,0,1,1,1,1", true);
			break;	
			
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage("MST00011", srcName + " Button Fail.");
		} else {
			ComShowCodeMessage("MST00011", e);
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
 * IBMultiCombo Object를 배열로 등록
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
	var formObj = document.form;

	for (i = 0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

    //Axon 이벤트 처리1. 이벤트catch
    axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
    axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form);    
    axon_event.addListenerFormat('keypress', 'obj_keypress',		form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
    axon_event.addListener('focusout',    	'obj_focusout',		"lod_capa","cntr_grs_wgt","tare_wgt","rc_ldb_capa","tnk_capa","inter_len","inter_wdt","inter_hgt","xter_len","xter_wdt");
    axon_event.addListener('focusout',    	'obj_focusout',		"xter_hgt","opn_dor_wdt","opn_dor_hgt","rc_ldb_hgt","own_cntr_flg","spec_yr","cntr_mtrl_cd");
    axon_event.addListenerForm('click',   	'obj_click',  		formObj); //- 변경될때.
    axon_event.addListener('change', 'obj_change', 'vndr_seq'); 

	for (k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], k + 1);
	}

	if (formObj.popflag.value != "") {
		// 팝업으로 호출되었을 때 - 조회.
		if (formObj.cntr_spec_no.value != "") {
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
			initTankRefferValue(ComGetObjValue(comboObjects[0]).substring(0, 1));			
		} else {
			clearForm();
		}

	} else {
		// 폼 초기화.
		doActionIBSheet(sheetObjects[0], formObj, IBINSERT);
	}

	if (formObj.popflag.value == "") {			
		/* 초기 Focus Setting */
		formObj.own_cntr_flg[0].checked = true;
		ComSetFocus(formObj.spec_yr);
	}
	doActionIBSheet(sheetObjects[0], document.form, IBCREATE);	
}

//Axon 이벤트 처리2. 이벤트처리함수
function obj_deactivate() {
 	var formObj = document.form;
 	obj = event.srcElement;      	
 	 
 	with(formObj){
 		if(obj.name!='vndr_seq'){ 			
 			ComChkObjValid(event.srcElement); 			
 		}
 	}
}

function obj_activate() {
	ComClearSeparator(event.srcElement);
}

function obj_keypress() {
	obj = event.srcElement;
	if (obj.dataformat == null)
		return;
	window.defaultStatus = obj.dataformat;

	switch (obj.dataformat) {
	case "ymd":
	case "ym":
	case "hms":
	case "hm":
	case "jumin":
	case "saupja":
		ComKeyOnlyNumber(obj);
		break;
	case "int":		
		if (obj.name == "txtInt"){
			ComKeyOnlyNumber(obj, "-");
		}else{
			ComKeyOnlyNumber(obj);
		}
		break;		
	case "float":
		ComKeyOnlyNumber(obj, "-.");
		break;
	case "eng":
		ComKeyOnlyAlphabet();
		break;
	case "engup":
		if (obj.name == "spec_yr"){
			ComKeyOnlyNumber(obj);
		}else{
			ComKeyOnlyAlphabet('upper');
		}
		break;
	case "engdn":
		if (obj.name == "txtEngDn2"){
			ComKeyOnlyAlphabet('lowernum');
		}else{
			ComKeyOnlyAlphabet('lower');
		}
		break;
	}
}

/**
 * Click Event 처리 
 */
function obj_click() {
	var obj = event.srcElement;
	var formObj = document.form;

	switch (obj.name) {
	case "own_cntr_flg":
		if (obj.value == "Y") {
			div_dcond1.style.display = "inline";
			div_dcond2.style.display = "none";
		} else {
			div_dcond1.style.display = "none";
			div_dcond2.style.display = "inline";
		}
		ComSetFocus(formObj.spec_yr);		
		break;
	}
}

/**
 * 2-3. Focus-out Event 처리
 */
function obj_focusout() {
	var obj = event.srcElement;
	var formObj = document.form;

	switch (obj.name) {
	case "lod_capa":
		if (ComTrim(obj.value) != "") {
			formObj.lod_capa_cbf.value = ComAddComma(computeCbmCbf(obj.value
					.replaceStr(",")));
		}

		sheetObjects[0].CellValue(1, "lod_capa") = obj.value.replaceStr(",");
		break;

	case "cntr_grs_wgt":
		var cntr_grs_wgt = obj.value.replaceStr(",");
		var tare_wgt = formObj.tare_wgt.value.replaceStr(",");

		if (ComTrim(obj.value) != "") {
			formObj.cntr_grs_wgt_ibs.value = ComAddComma(computeKgIbs(cntr_grs_wgt));
			formObj.pay_load.value = ComAddComma(computeKgIbs(obj.value
					.replaceStr(",")));
			var pay_load = cntr_grs_wgt - tare_wgt;
			formObj.pay_load.value = ComAddComma(pay_load);
			formObj.pay_load_ibs.value = ComAddComma(computeKgIbs(pay_load));
		}

		sheetObjects[0].CellValue(1, "cntr_grs_wgt") = obj.value
				.replaceStr(",");
		break;

	case "tare_wgt":
		var cntr_grs_wgt = formObj.cntr_grs_wgt.value.replaceStr(",");
		var tare_wgt = obj.value.replaceStr(",");

		if (ComTrim(obj.value) != "") {
			formObj.tare_wgt_ibs.value = ComAddComma(computeKgIbs(obj.value
					.replaceStr(",")));
			var pay_load = cntr_grs_wgt - tare_wgt;
			formObj.pay_load.value = ComAddComma(pay_load);
			formObj.pay_load_ibs.value = ComAddComma(computeKgIbs(pay_load));
		}

		sheetObjects[0].CellValue(1, "tare_wgt") = obj.value.replaceStr(",");
		break;

	case "rc_ldb_capa":
		if (ComTrim(obj.value) != "") {
			formObj.rc_ldb_capa_cbf.value = ComAddComma(computeCbmCbf(obj.value
					.replaceStr(",")));
		}

		sheetObjects[0].CellValue(1, "rc_ldb_capa") = obj.value.replaceStr(",");
		break;

	case "tnk_capa":
		if (ComTrim(obj.value) != "") {
			formObj.tnk_capa_cbf.value = ComAddComma(computeCbmCbf(obj.value
					.replaceStr(",")));
		}

		sheetObjects[0].CellValue(1, "tnk_capa") = obj.value.replaceStr(",");
		break;

	case "inter_len":
		sheetObjects[0].CellValue(1, "inter_len") = obj.value.replaceStr(",");
		break;

	case "inter_wdt":
		sheetObjects[0].CellValue(1, "inter_wdt") = obj.value.replaceStr(",");
		break;

	case "inter_hgt":
		sheetObjects[0].CellValue(1, "inter_hgt") = obj.value.replaceStr(",");
		break;

	case "xter_len":
		sheetObjects[0].CellValue(1, "xter_len") = obj.value.replaceStr(",");
		break;

	case "xter_wdt":
		sheetObjects[0].CellValue(1, "xter_wdt") = obj.value.replaceStr(",");
		break;

	case "xter_hgt":
		sheetObjects[0].CellValue(1, "xter_hgt") = obj.value.replaceStr(",");
		break;

	case "opn_dor_wdt":
		sheetObjects[0].CellValue(1, "opn_dor_wdt") = obj.value.replaceStr(",");
		break;

	case "opn_dor_hgt":
		sheetObjects[0].CellValue(1, "opn_dor_hgt") = obj.value.replaceStr(",");
		break;

	case "rc_ldb_hgt":
		sheetObjects[0].CellValue(1, "rc_ldb_hgt") = obj.value.replaceStr(",");
		break;

	case "own_cntr_flg":
		sheetObjects[0].CellValue(1, "own_cntr_flg") = obj.value.replaceStr(",");
		break;

	case "spec_yr":
		sheetObjects[0].CellValue(1, "spec_yr") = obj.value.replaceStr(",");
		break;

	case "cntr_mtrl_cd":
		sheetObjects[0].CellValue(1, "cntr_mtrl_cd") = obj.value.replaceStr(",");
		break;
	}
}

/**
 * CBM 단위를 CBF로 바꾼다. 공식은 cbm * 35.3028
 * @param cbm
 * @return
 */
function computeCbmCbf(cbm) {
	return ComRound(cbm * 35.3028, 0);
}

/**
 * Kg 단위를 Ibs로 바꾼다. 공식은 kg * 2.20459
 * @param kg
 * @return
 */
function computeKgIbs(kg) {
	return ComRound(kg * 2.20459, 0);
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
			style.height = 100;
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

			var HeadTitle = "|cntr_spec_no|own_cntr_flg|spec_yr|cntr_tpsz_cd|cntr_mtrl_cd"
					+ "|lod_capa|cntr_grs_wgt|tare_wgt|inter_len|inter_wdt|inter_hgt|xter_len"
					+ "|xter_wdt|xter_hgt|opn_dor_wdt|opn_dor_hgt|rc_ldb_capa|rc_ldb_hgt|tnk_capa|vndr_seq2|vndr_abbr_nm";

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(24, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++ , dtHiddenStatus,	100,	daCenter,	false,	"ibflag");
            InitDataProperty(0, cnt++ , dtData,			 50,	daCenter,	false,	"cntr_spec_no",	false,	"",		dfNone,		0,	false,		false);
            InitDataProperty(0, cnt++ , dtData,			 50,	daCenter,	false,	"own_cntr_flg",	false,	"",		dfNone,		0,	false,		false);
            InitDataProperty(0, cnt++ , dtData,			 50,	daCenter,	false,	"spec_yr",		false,	"",		dfNone,		0,	false,		false);
            InitDataProperty(0, cnt++ , dtData,			 50,	daCenter,	false,	"cntr_tpsz_cd",	false,	"",		dfNone,		0,	false,		false);
            InitDataProperty(0, cnt++ , dtData,			 50,	daCenter,	false,	"cntr_mtrl_cd",	false,	"",		dfNone,		0,	false,		false);
            InitDataProperty(0, cnt++ , dtData,			 50,	daCenter,	false,	"lod_capa",		false,	"",		dfNone,		0,	false,		false);
            InitDataProperty(0, cnt++ , dtData,			 50,	daCenter,	false,	"cntr_grs_wgt",	false,	"",		dfNone,		0,	false,		false);
            InitDataProperty(0, cnt++ , dtData,			 50,	daCenter,	false,	"tare_wgt",		false,	"",		dfNone,		0,	false,		false);
            InitDataProperty(0, cnt++ , dtData,			 50,	daCenter,	false,	"inter_len",	false,	"",		dfNone,		0,	false,		false);
            InitDataProperty(0, cnt++ , dtData,			 50,	daCenter,	false,	"inter_wdt",	false,	"",		dfNone,		0,	false,		false);
            InitDataProperty(0, cnt++ , dtData,			 50,	daCenter,	false,	"inter_hgt",	false,	"",		dfNone,		0,	false,		false);
            InitDataProperty(0, cnt++ , dtData,			 50,	daCenter,	false,	"xter_len",		false,	"",		dfNone,		0,	false,		false);
            InitDataProperty(0, cnt++ , dtData,			 50,	daCenter,	false,	"xter_wdt",		false,	"",		dfNone,		0,	false,		false);
            InitDataProperty(0, cnt++ , dtData,			 50,	daCenter,	false,	"xter_hgt",		false,	"",		dfNone,		0,	false,		false);
            InitDataProperty(0, cnt++ , dtData,			 50,	daCenter,	false,	"opn_dor_wdt",	false,	"",		dfNone,		0,	false,		false);
            InitDataProperty(0, cnt++ , dtData,			 50,	daCenter,	false,	"opn_dor_hgt",	false,	"",		dfNone,		0,	false,		false);
            InitDataProperty(0, cnt++ , dtData,			 50,	daCenter,	false,	"rc_ldb_capa",	false,	"",		dfNone,		0,	false,		false);
            InitDataProperty(0, cnt++ , dtData,			 50,	daCenter,	false,	"rc_ldb_hgt",	false,	"",		dfNone,		0,	false,		false);
            InitDataProperty(0, cnt++ , dtData,			 50,	daCenter,	false,	"tnk_capa",		false,	"",		dfNone,		0,	false,		false);
            InitDataProperty(0, cnt++ , dtData,			 50,	daCenter,	false,	"vndr_seq2",	false,	"",		dfNone,		0,	false,		false);
            InitDataProperty(0, cnt++ , dtData,			 50,	daCenter,	false,	"vndr_abbr_nm",	false,	"",		dfNone,		0,	false,		false);            
            
		}
		break;		

    case "sheet2":	// Hidden Sheet
	    with (sheetObj) {
	        // 높이 설정
	        //Host정보 설정[필수][HostIp, Port, PagePath]
	        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	    }	
    	break;
	}
}

/**
 * 콤보 초기설정값, 헤더 정의
 * param : comboObj ==> 콤보오브젝트, sheetNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initCombo(comboObj, comboNo) {
	switch (comboObj.id) {
		case "combo1":
			with (comboObj) {
				DropHeight = 200;
				MultiSelect = false;
				MaxSelect = 1;
				MultiSeparator = ",";
				BackColor = "#CCFFFD";
				Style = 0;
				UseAutoComplete = true;
	
				ValidChar(2, 1); // 영어대문자 사용, 숫자포함
				IMEMode = 0; // 영문
				MaxLength = 2; // 2자까지 입력
				SetColAlign("center");
			}
			break;
		  case "mft_vndr_seq": 
			   with (comboObj) { 
				   SetColAlign("left|left");        
				   SetColWidth("100|200");         
				   DropHeight = 160;                         
			   }   
			   break; 			
	}
}


/**
 * Sheet관련 프로세스 처리
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBCREATE:
		formObj.f_cmd.value = SEARCH02;
		var sXml = sheetObj.GetSearchXml("EES_MST_COMGS.do",FormQueryString(formObj) + "&eq_knd_cd=U");
		var chk = sXml.indexOf("ERROR");
		if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
		   sheetObj.LoadSearchXml(sXml);
		   return;
		}		

		if (sXml != "") {
			var sCntrTpSzCd = ComGetEtcData(sXml, "cntr_tpsz_cd");
			var arrCntrTpSzCd = sCntrTpSzCd.split("|");

			MstMakeComboObject(comboObjects[0], arrCntrTpSzCd, arrCntrTpSzCd);
		}
				
		formObj.f_cmd.value = SEARCH01;
		var xmlStr = sheetObj.GetSearchXml("EES_MST_COMGS.do", FormQueryString(formObj));
	    var chk = xmlStr.indexOf("ERROR");
		if (xmlStr.indexOf("ERROR") != -1 || xmlStr.indexOf("Error") != -1){
		   sheetObj.LoadSearchXml(xmlStr);
		   return;
	    }  		
		var sStr = ComGetEtcData(xmlStr, "comboList");
		var arrStr = sStr.split("@");
		MakeComboObject(formObj.mft_vndr_seq, arrStr, 1, 0);    
		
		break;
	case IBSEARCH: //조회
		if (sheetObj.id == "sheet1") {
			
			//sheetObj.WaitImageVisible=false;
			//ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			var xml = "";
			xml = sheetObj.GetSearchXml("EES_MST_0021GS.do", FormQueryString(formObj));
			sheetObj.LoadSearchXml(xml);			
	
			var own_cntr_flg = sheetObj.CellValue(1, "own_cntr_flg");
			var lod_capa = sheetObj.CellValue(1, "lod_capa");
			var lod_capa_cbf = computeCbmCbf(lod_capa);
			var cntr_grs_wgt = sheetObj.CellValue(1, "cntr_grs_wgt");
			var cntr_grs_wgt_ibs = computeKgIbs(cntr_grs_wgt);
			var tare_wgt = sheetObj.CellValue(1, "tare_wgt");
			var tare_wgt_ibs = computeKgIbs(tare_wgt);
			var pay_load = cntr_grs_wgt - tare_wgt;
			var pay_load_ibs = computeKgIbs(pay_load);
	
			// Reefer Cargo Loadable
			var rc_ldb_capa = sheetObj.CellValue(1, "rc_ldb_capa");
			var rc_ldb_capa_cbf = computeCbmCbf(rc_ldb_capa);
			var tnk_capa = sheetObj.CellValue(1, "tnk_capa");
			var tnk_capa_cbf = computeCbmCbf(tnk_capa);
	
			// 조회된 값 출력하기.
			if (own_cntr_flg == "Y") {
				formObj.own_cntr_flg[0].checked = true;
			} else {
				formObj.own_cntr_flg[1].checked = true;
			}
			
			comboObjects[0].Text = sheetObj.CellValue(1, "cntr_tpsz_cd");
			formObj.spec_yr.value = sheetObj.CellValue(1, "spec_yr");
			formObj.cntr_mtrl_cd.value = sheetObj.CellValue(1, "cntr_mtrl_cd");
			formObj.lod_capa.value = ComAddComma(lod_capa);
			formObj.lod_capa_cbf.value = ComAddComma(lod_capa_cbf);
			formObj.cntr_grs_wgt.value = ComAddComma(cntr_grs_wgt);
			formObj.cntr_grs_wgt_ibs.value = ComAddComma(cntr_grs_wgt_ibs);
			formObj.tare_wgt.value = ComAddComma(tare_wgt);
			formObj.tare_wgt_ibs.value = ComAddComma(tare_wgt_ibs);
			formObj.pay_load.value = ComAddComma(pay_load);
			formObj.pay_load_ibs.value = ComAddComma(pay_load_ibs);
			formObj.inter_len.value = ComAddComma(sheetObj.CellValue(1, "inter_len"));
			formObj.inter_wdt.value = ComAddComma(sheetObj.CellValue(1, "inter_wdt"));
			formObj.inter_hgt.value = ComAddComma(sheetObj.CellValue(1, "inter_hgt"));
			formObj.xter_len.value = ComAddComma(sheetObj.CellValue(1, "xter_len"));
			formObj.xter_wdt.value = ComAddComma(sheetObj.CellValue(1, "xter_wdt"));
			formObj.xter_hgt.value = ComAddComma(sheetObj.CellValue(1, "xter_hgt"));
			formObj.opn_dor_wdt.value = ComAddComma(sheetObj.CellValue(1,"opn_dor_wdt"));
			formObj.opn_dor_hgt.value = ComAddComma(sheetObj.CellValue(1,"opn_dor_hgt"));
			formObj.rc_ldb_capa.value = ComAddComma(rc_ldb_capa);
			formObj.rc_ldb_capa_cbf.value = ComAddComma(rc_ldb_capa_cbf);
			formObj.rc_ldb_hgt.value = ComAddComma(sheetObj.CellValue(1,"rc_ldb_hgt"));
			formObj.tnk_capa.value = ComAddComma(tnk_capa);
			formObj.tnk_capa_cbf.value = ComAddComma(tnk_capa_cbf);
			
			formObj.vndr_seq2.value = sheetObj.CellValue(1, "vndr_seq2");
			if (own_cntr_flg == "Y") {			
				div_dcond1.style.display = "inline";
				div_dcond2.style.display = "none";
				
				comboObjects[1].Code = sheetObj.CellValue(1, "vndr_seq2");
			}else{
				div_dcond1.style.display = "none";
				div_dcond2.style.display = "inline";
				
				formObj.vndr_seq.value = sheetObj.CellValue(1, "vndr_seq2");
		 		var vndrSeq = ComTrimAll(formObj.vndr_seq.value);	 		
		 		if(vndrSeq != ''){
		 			// Lessor 명칭 가져오기
	    	 		doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC04);
		 		}
		 	}
			
			// M/facturer 항목이 없을 경우 새로 추가
			if (own_cntr_flg == "Y") {		//Own 일 경우			
				if(formObj.mft_vndr_seq.Code == ''){
					formObj.mft_vndr_seq.InsertItem(-1, sheetObj.CellValue(-1,'vndr_seq2') +'|'+sheetObj.CellValue(1,'vndr_abbr_nm'), sheetObj.CellValue(1,'vndr_seq2'));
					ComSetObjValue(formObj.mft_vndr_seq,		sheetObj.CellValue(1,'vndr_seq2'));           			
				}			
			}
			//ComOpenWait(false);
			// 키필드 입력불가하게 한다.
			activeKeyFields(false);			
		}
		break;
	
	case IBINSERT: // 입력
		sheetObj.RemoveAll();
		var row = sheetObj.DataInsert(0);
		sheetObj.RowStatus(1) = "I";
		clearForm();
		activeTankCapa(false);
		activeReeferCapa(false);
	
		// 신규입력이므로 키필드 입력 가능하도록 한다.
		activeKeyFields(true);
		break;
	
	case IBSAVE: // MODIFY 나 ADD 를 처리한다.
		if (validateForm(sheetObj, formObj, sAction)) {
			
			if(formObj.own_cntr_flg[0].checked){
				formObj.vndr_seq2.value = formObj.mft_vndr_seq.Code;
				sheetObjects[0].CellValue(1, "own_cntr_flg") = 'Y';				
			}else{
				formObj.vndr_seq2.value = formObj.vndr_seq.value;
				sheetObjects[0].CellValue(1, "own_cntr_flg") = 'N';				
			}
			
			sheetObjects[0].CellValue(1, "vndr_seq2") = formObj.vndr_seq2.value; 
			
			//sheetObj.WaitImageVisible=false;
			//ComOpenWait(true);			
			if (sheetObj.RowStatus(1) == "I") // New 버튼을 입력시 값을 지정하였음.
			{
				formObj.f_cmd.value = ADD;
				sheetObj.DoSave("EES_MST_0021GS.do", FormQueryString(formObj), -1, false);
				var cntr_spec_no = sheetObj.EtcData("cntr_spec_no");
				formObj.cntr_spec_no.value = cntr_spec_no;
				sheetObj.CellValue(1, "cntr_spec_no") = cntr_spec_no;
			} else {
				formObj.f_cmd.value = MODIFY;
				sheetObj.RowStatus(1) = "U";
				sheetObj.DoSave("EES_MST_0021GS.do", FormQueryString(formObj), -1, false);
			}
			//ComOpenWait(false);			
		}
		break;
	
	case IBDELETE: // 삭제
		if (validateForm(sheetObj, formObj, sAction)) {
			// 삭제하시겠습니까? 메시지 박스 출력.
			if (ComShowCodeConfirm("MST00005")) {
				sheetObj.RowStatus(1) = "D";
				sheetObj.RowHidden(1) = true;
				
				//sheetObj.WaitImageVisible=false;
				//ComOpenWait(true);				
				formObj.f_cmd.value = REMOVE;
     	        var sParam = ComGetSaveString(sheetObj);
     	        sParam += "&" + FormQueryString(formObj);				
     	        var sXml = sheetObj.GetSaveXml("EES_MST_0021GS.do", sParam);
     	        //ComOpenWait(false);
     	        
				var chk = sXml.indexOf("ERROR");
				var chk1 = sXml.indexOf("◎ Info Message");
				var chk2 = sXml.indexOf("Error");
				if (chk == -1 && chk1 == -1 && chk2 == -1){
					doActionIBSheet(sheetObj, formObj, IBINSERT);
					return;
				} else {
					sheetObj.LoadSearchXml(sXml);
					return;
				}
			}
		}
		break;
		
		
 	case IBSEARCH_ASYNC04:	// Vendor Code,Name 조회
		formObj.f_cmd.value = SEARCH07;
 		formObj.code.value = formObj.vndr_seq.value;
		var sXml = sheetObj.GetSearchXml("EES_MST_COMGS.do", FormQueryString(formObj));
	    var chk = sXml.indexOf("ERROR");
		if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
		   sheetObj.LoadSearchXml(sXml);
		   return;
	    }		
		var text = ComNullToBlank(ComGetEtcData(sXml,"code_nm"));		
		formObj.vndr_lgl_eng_nm.value = text;
		break;			
	}
}

/**
 * initTankCapa 
 * TankCapa 입력항목 초기화 (신규생성시 사용)
 * @return
 */
function initTankCapa() {
	var formObj = document.form;
	
	formObj.tnk_capa.value = "";
	formObj.tnk_capa_cbf.value = "";
	sheetObjects[0].CellValue(1, "tnk_capa") = "";
}

/**
 * activeTankCapa
 * TankCapa 관련 입력항목들을 활성화하거나 비활성화시킨다.
 * @param active
 * @return
 */
function activeTankCapa(active) {
	var formObj = document.form;
	if (active) {
		formObj.tnk_capa.readOnly = false;
		document.getElementById("tnk_capa").className = "input";
	} else {
		formObj.tnk_capa.readOnly = true;
		document.getElementById("tnk_capa").className = "input2";
	}
}

/**
 * initReeferCapa 
 * ReeferCapa 입력항목 초기화 (신규생성시 사용)
 * @return
 */
function initReeferCapa() {
	var formObj = document.form;
	
	formObj.rc_ldb_capa.value = "";
	formObj.rc_ldb_capa_cbf.value = "";
	formObj.rc_ldb_hgt.value = "";
	sheetObjects[0].CellValue(1, "rc_ldb_capa") = "";
	sheetObjects[0].CellValue(1, "rc_ldb_hgt") = "";
}

/**
 * activeReeferCapa
 * ReeferCapa 관련 입력항목들을 활성화하거나 비활성화시킨다.
 * @param active
 * @return
 */
function activeReeferCapa(active) {
	var formObj = document.form;
	
	if (active) {
		formObj.rc_ldb_capa.readOnly = false;
		formObj.rc_ldb_hgt.readOnly = false;
		document.getElementById("rc_ldb_capa").className = "input";
		document.getElementById("rc_ldb_hgt").className = "input";
	} else {
		formObj.rc_ldb_capa.readOnly = true;
		formObj.rc_ldb_hgt.readOnly = true;
		document.getElementById("rc_ldb_capa").className = "input2";
		document.getElementById("rc_ldb_hgt").className = "input2";
	}
}

/**
 * activeKeyFields
 * 키필드의 액티브상태제어
 * @param active
 * @return
 */
function activeKeyFields(active) {
	var formObj = document.form;
	
	if (active) // 키필드 부분을 입력가능하게 한다. (신규생성시)
	{
		// Term
		formObj.own_cntr_flg[0].disabled = false;
		formObj.own_cntr_flg[1].disabled = false;
		// Year
		formObj.spec_yr.readOnly = false;
		document.getElementById("spec_yr").className = "input1";
		// TY/SZ
		comboObjects[0].Enable = true;
		// Material
		formObj.cntr_mtrl_cd.disabled = false;
		//M/facturer
		comboObjects[1].Enable = true;	
		//Lessor
//		formObj.vndr_seq.readOnly = false;
		document.getElementById("vndr_seq").className = "input1";
	} else // 키필드 부분을 입력불가하게 한다. (조회, 업데이트, 삭제시)
	{
		// Term
		formObj.own_cntr_flg[0].disabled = true;
		formObj.own_cntr_flg[1].disabled = true;
		// Year
		formObj.spec_yr.readOnly = true;
		document.getElementById("spec_yr").className = "input2";
		// TY/SZ
		comboObjects[0].Enable = false;
		// Material
		formObj.cntr_mtrl_cd.disabled = true;
		//M/facturer
		comboObjects[1].Enable = false;
		//Lessor
//		formObj.vndr_seq.readOnly = true;	
		document.getElementById("vndr_seq").className = "input2";		
	}
}

/**
 * combo1_OnChange
 * 컴보박스 입력값 변경시 처리. (신규생성시 사용.)
 * @param comboObj
 * @param Index_Code
 * @param Text
 * @return
 */
function combo1_OnChange(comboObj, Index_Code, Text) {
	if (document.form.popflag.value == "") // 메인으로 호출될경우 처리.
	{
		var strTpszCd = ComGetObjValue(comboObj);
	
		// 컴보박스의 변경사항 반영.
		sheetObjects[0].CellValue(1, "cntr_tpsz_cd") = strTpszCd;
	
		if (strTpszCd.substring(0, 1) == "R") // TY/SZ 코드가 R : Tank Capacity 비활성화.
		{
			activeTankCapa(false);
			activeReeferCapa(true);
			initTankCapa();
		} else if (strTpszCd.substring(0, 1) == "T") // TY/SZ 코드가 T : Reefer
														// Cargo Loadable 비활성화.
		{
			activeTankCapa(true);
			activeReeferCapa(false);
			initReeferCapa();
		} else // 두 코드 아니면 모두 입력을 비활성화한다.
		{
			activeTankCapa(false);
			activeReeferCapa(false);
			initTankCapa();
			initReeferCapa();
		}
	}
}

/**
 * changeTySzCd
 * 조회시 TY/SZ 코드에 따라 비활성화 작업.
 * @param strTpszCd
 * @return
 */
function initTankRefferValue(strTp) {
	var formObj = document.form;
	
	if (strTp == "R") // TY/SZ 코드가 R : Tank Capacity 비활성화.
	{
		formObj.tnk_capa.value = 0;
		formObj.tnk_capa_cbf.value = 0;
	} else if (strTp == "T") // TY/SZ 코드가 T : Reefer Cargo Loadable 비활성화.
	{
		formObj.rc_ldb_capa.value = 0;
		formObj.rc_ldb_capa_cbf.value = 0;
		formObj.rc_ldb_hgt.value = 0;
	} else // 두 코드 아니면 모두 입력을 비활성화한다.
	{
		formObj.tnk_capa.value = 0;
		formObj.tnk_capa_cbf.value = 0;
		formObj.rc_ldb_capa.value = 0;
		formObj.rc_ldb_capa_cbf.value = 0;
		formObj.rc_ldb_hgt.value = 0;
	}
}

/**
 * changeTySzCd
 * 조회시 TY/SZ 코드에 따라 비활성화 작업.
 * @param strTpszCd
 * @return
 */
function changeTySzCd(strTpszCd) {
	if (strTpszCd.substring(0, 1) == "R") // TY/SZ 코드가 R : Tank Capacity 비활성화.
	{
		activeTankCapa(false);
		activeReeferCapa(true);
		initTankRefferValue("R");
	} else if (strTpszCd.substring(0, 1) == "T") // TY/SZ 코드가 T : Reefer Cargo
													// Loadable 비활성화.
	{
		activeTankCapa(true);
		activeReeferCapa(false);
		initTankRefferValue("T");
	} else // 두 코드 아니면 모두 입력을 비활성화한다.
	{
		activeTankCapa(false);
		activeReeferCapa(false);
		initTankRefferValue("");
	}
}

/**
 * combo1_OnKeyDown
 * 컴보박스 키 입력시 처리.
 * @param comboObj
 * @param KeyCode
 * @param Shift
 * @return
 */
function combo1_OnKeyDown(comboObj, KeyCode, Shift) {
with (comboObj) {
	if (KeyCode == 8 || KeyCode == 46) {
		for (i = 0; i < GetCount(); i++) {
			if (CheckIndex(i)) {
				CheckIndex(i) = false;
			}
		}
	}
}
}

/**
 * Pop-up Open 부분<br>
 */
function openPopup() {
	var formObj = document.form;
	
	var sUrl = '/hanjin/EES_MST_0022.do';
	var iWidth = 1020;
	var iHeight = 680;
	var sTargetObjList = "cntr_spec_no:cntr_spec_no|cntr_tpsz_cd:cntr_tpsz_cd|cntr_mtrl_cd:cntr_mtrl_cd";
	var sDisplay = "0,0";
	
	var ownCntrFlg = "";
	if (formObj.own_cntr_flg[0].checked == true){
		ownCntrFlg = "Y";		
		div_dcond1.style.display = "inline";
		div_dcond2.style.display = "none";		
	}else if (formObj.own_cntr_flg[1].checked == true){
		ownCntrFlg = "N";
		div_dcond1.style.display = "none";
		div_dcond2.style.display = "inline";		
	}
	
	// Term, Tp/Sz, From, To, AGMT, Flag == 1 이면 EES_MST_0016.do 에서 사용.
	// Flag == 2이면 EES_MST_0021.do 에서 사용.
	var param = "?own_cntr_flg=" + ownCntrFlg
			+ "&cntr_tpsz_cd=&from_spec_yr=&to_spec_yr=&agmt_no=&active_flag=2";
	
	ComOpenPopupWithTarget(sUrl + param, iWidth, iHeight, sTargetObjList, sDisplay,true);
	
	if (formObj.cntr_spec_no.value != "") {
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	}
	
	// TY/SZ 코드에 따라서  활성화 여부 적용.
	changeTySzCd(ComGetObjValue(comboObjects[0]));
}

/**
 * Form Element Clear 처리부분.<br>
 */
function clearForm() {
	var formObj = document.form;
	
	formObj.own_cntr_flg[0].checked = true;
	formObj.own_cntr_flg[1].checked = false;
	
	formObj.cntr_spec_no.value = "";
	formObj.cntr_mtrl_cd.value = "";
	comboObjects[0].Text = "";
	formObj.spec_yr.value = "";
	formObj.lod_capa.value = "";
	formObj.lod_capa_cbf.value = "";
	formObj.cntr_grs_wgt.value = "";
	formObj.cntr_grs_wgt_ibs.value = "";
	formObj.tare_wgt.value = "";
	formObj.tare_wgt_ibs.value = "";
	formObj.pay_load.value = "";
	formObj.pay_load_ibs.value = "";
	formObj.inter_len.value = "";
	formObj.inter_wdt.value = "";
	formObj.inter_hgt.value = "";
	formObj.xter_len.value = "";
	formObj.xter_wdt.value = "";
	formObj.xter_hgt.value = "";
	formObj.opn_dor_wdt.value = "";
	formObj.opn_dor_hgt.value = "";
	formObj.rc_ldb_capa.value = "";
	formObj.rc_ldb_capa_cbf.value = "";
	formObj.rc_ldb_hgt.value = "";
	formObj.tnk_capa.value = "";
	formObj.tnk_capa_cbf.value = "";
	
	formObj.vndr_seq2.value = "";	
	comboObjects[1].Code = "";
	formObj.vndr_seq.value = "";	
	formObj.vndr_lgl_eng_nm.value = "";	
	
}

/**
 * DataToSheet 조회된 데이터를 Sheet로 옮긴다.
 * @return
 */
function DataToSheet() {
	var formObj = document.form;
	
	// 조회된 값 출력하기.
	if (formObj.own_cntr_flg[0].checked == true)
		sheetObj.CellValue(1, "own_cntr_flg") = "Y";
	else if (formObj.own_cntr_flg[1].checked == true)
		sheetObj.CellValue(1, "own_cntr_flg") = "N";
	else
		sheetObj.CellValue(1, "own_cntr_flg") = "";
	
	sheetObj.CellValue(1, "cntr_tpsz_cd") = comboObjects[0].Text;
	sheetObj.CellValue(1, "spec_yr") = formObj.spec_yr.value;
	sheetObj.CellValue(1, "cntr_mtrl_cd") = formObj.cntr_mtrl_cd.value;
	
	sheetObj.CellValue(1, "lod_capa") = formObj.lod_capa.value;
	sheetObj.CellValue(1, "cntr_grs_wgt") = formObj.cntr_grs_wgt.value;
	sheetObj.CellValue(1, "tare_wgt") = formObj.tare_wgt.value;
	sheetObj.CellValue(1, "inter_len") = formObj.inter_len.value;
	sheetObj.CellValue(1, "inter_wdt") = formObj.inter_wdt.value;
	sheetObj.CellValue(1, "inter_hgt") = formObj.inter_hgt.value;
	sheetObj.CellValue(1, "xter_len") = formObj.xter_len.value;
	sheetObj.CellValue(1, "xter_wdt") = formObj.xter_wdt.value;
	sheetObj.CellValue(1, "xter_hgt") = formObj.xter_hgt.value;
	sheetObj.CellValue(1, "opn_dor_wdt") = formObj.opn_dor_wdt.value;
	sheetObj.CellValue(1, "opn_dor_hgt") = formObj.opn_dor_hgt.value;
	sheetObj.CellValue(1, "rc_ldb_capa") = formObj.rc_ldb_capa.value;
	sheetObj.CellValue(1, "rc_ldb_hgt") = formObj.rc_ldb_hgt.value;
	sheetObj.CellValue(1, "tnk_capa") = formObj.tnk_capa.value;
	
	if (formObj.own_cntr_flg[0].checked == true)
		sheetObj.CellValue(1, "vndr_seq2") = formObj.mft_vndr_seq.Code;
	else if (formObj.own_cntr_flg[1].checked == true)
		sheetObj.CellValue(1, "vndr_seq2") = formObj.vndr_seq.value;
	
		
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
with (formObj) {
	if (sAction == IBSAVE) { // 저장시 필수 입력값 체크.
		if (own_cntr_flg[0].checked == false
				&& own_cntr_flg[1].checked == false) {
			ComShowCodeMessage("MST00001", "Spec");
			return false;
		}
		if (spec_yr.value == "" || spec_yr.value == null) {
			spec_yr.focus();
			ComShowCodeMessage("MST00001", "Year");
			return false;
		}
		if (comboObjects[0].Text == "") {
			ComShowCodeMessage("MST00001", "TY/SZ");
			return false;
		}
		if (cntr_mtrl_cd.value == "" || cntr_mtrl_cd.value == null) {
			if (cntr_mtrl_cd.disabled == false)
				cntr_mtrl_cd.focus();
			ComShowCodeMessage("MST00001", "Material");
			return false;
		}
		
		if (comboObjects[1].Text == "" && vndr_lgl_eng_nm.value == "") {
			if(formObj.own_cntr_flg[0].checked){
				ComShowCodeMessage("MST00001", "M/facturer");
			}else{
				ComShowCodeMessage("MST00001", "Lessor");				
			}
			return false;
		}		
		
	} else if (sAction == IBDELETE) {
		if (cntr_spec_no.value == "" || cntr_spec_no.value == null) {
			ComShowCodeMessage("MST00001", "SML Spec No");
			return false;
		}
	}
}

return true;
}
 
/**
 * 콤보 오브젝트 생성(Spec No * Type/Size)
 */
function MakeComboObject(cmbObj, arrStr, txtCol, codeCol) {
	cmbObj.RemoveAll();
	cmbObj.InsertItem(0, "", "");
	
	for (var i=0; i<arrStr.length; i++) {
		var arrCode = arrStr[i].split("|");
		cmbObj.InsertItem(i+1, arrCode[codeCol] + '|' + arrCode[txtCol], arrCode[codeCol]);
	}
	cmbObj.Index2 = "" ;
} 

/** 
 * Object 의 change 이벤트에 대한 처리  <br>
 * @param  없음
 * @return 없음
 * @author 김창식
 * @version 2009.06.03
 */  
function obj_change(){ 	 
	var formObj = document.form;
	var sheetObj = sheetObjects[1];
	 
	obj = event.srcElement;
	switch(obj.name){	 
	 	case "vndr_seq":
	 		var vndrSeq = ComTrimAll(formObj.vndr_seq.value);	 		
	 		if(vndrSeq != ''){
	 			// Lessor 명칭 가져오기
    	 		doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC04);
	 		} else {
	 			// vndr_seq 입력 텍스트에서 삭제할 경우 Lessor 명칭을 삭제
	 			formObj.vndr_lgl_eng_nm.value = "";
    	 	}    	 		
   	 	break;    	 
   	}
}
 
 function ComNullToBlank(sStr){
	if( sStr==null || sStr=='null' || sStr=='undefined' || sStr==undefined || typeof sStr=='undefined'){
		return '';
	} else {
		return sStr;
	}
} 

/* 개발자 작업  끝 */