/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0159.js
 *@FileTitle : ESM_BKG_0159
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.10
 *@LastModifier : 김승민
 *@LastVersion : 1.0
 * 2009.07.10 김승민
 * 1.0 Creation
 * ------------------------------------------------------
 * history 
 * 2011.02.21 김영철 [CHM-201108683-01] Container Loading/Discharging List(ESM_BKG_0159) 화면 그리드 wgt 값 소숫점 3자리 다 보이게 수정
 * 2011.02.21 김영철 [CHM-201108462-01] GOH 체크 후 조회 시 해당 항목만 조회(조회 그리드 Special Cargo 항목에 "Hanger" Text 보여줌)
 * 2012.08.09 김보배 [CHM-201219500] [BKG] CLL/CDL EDI 전송시 Receiver S/P추가
 * 2012.10.25 채창호 [CHM-201220810] [BKG][CLL/CDL] W/O Flag추가, Transmission MSG변경
 * 2014.06.03 김보배 [CHM-201430464] CDL R8 SUMMARY 집계누락건
 * 2014.08.11 이한나 [CHM-201431533] NE6 SHA Block Stowage 관련 CLL/CDL 화면 보완 요청
 * 2015.02.09 이한나 [CHM-201533845] CLL/CDL 메뉴에 Calling sequence 추가
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
 * @class ESM_BKG_0159 : ESM_BKG_0159 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0159() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업 */

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var bkgNo = "";
var state = "";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;
//	var thaiOfcVal = formObject.thai_ofc.checked;
//	alert(thaiOfcVal);

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
		case "btn_retrieve":
		
				if (formObject.thai_ofc.checked){
					document.getElementById("mainTable6").style.display="Inline"; 
					document.getElementById("mainTable").style.display="none"; 
					sheetObject = sheetObjects[5];
	
				}else{
					document.getElementById("mainTable").style.display="Inline"; 
					document.getElementById("mainTable6").style.display="none";
					sheetObject = sheetObjects[0];
				}
			
			doActionIBSheet(sheetObject, document.form, IBSEARCH);
			break;

		case "btn_ediDownload":
			doActionIBSheet(sheetObject, formObject, IBSAVE);
			break;

		case "btn_cllForEdi":
			doActionIBSheet(sheetObject, formObject, COMMAND03);
			break;

		case "btn_edi":
			doActionIBSheet(sheetObject, formObject, COMMAND04);
			break;

		case "btn_faxemail":
			doActionIBSheet(sheetObject, formObject, COMMAND08);
			break;

		case "btn_sort":
			doActionIBSheet(sheetObject, formObject, COMMAND05);
			break;

		case "btn_new":
			document.form.reset();
			sheetObject.RemoveAll();
			formObject.in_vvd_cd.focus();
			if (formObject.in_list_type_temp(0).checked) {
				document.all["pod_cd"].className = "input1";
				document.all["pod_yd_cd"].className = "input1";
				document.all["pol_cd"].className = "input";
				document.all["pol_yd_cd"].className = "input";
			} else {
				document.all["pod_cd"].className = "input";
				document.all["pod_yd_cd"].className = "input";
				document.all["pol_cd"].className = "input1";
				document.all["pol_yd_cd"].className = "input1";
			}
			
			splitChange();  // Add. 2015.02.09
			
			break;
			
		case "btn_downExcel":
			
			if (formObject.thai_ofc.checked){
				sheetObject = sheetObjects[5];

			}else{
				sheetObject = sheetObjects[0];
			}
			
			
			doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
			
			break;
		case "TAO/ODCY":
			doActionIBSheet(sheetObjects[3], formObject, COMMAND09);
			break;

		case "btn_print":
			doActionIBSheet(sheetObject, formObject, COMMAND06);
			break;

//		case "btn_multiretrieve":
//			doActionIBSheet(sheetObject, formObject, IBSEARCH);
//			break;
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
 * @param sheet_obj IBSheet Object
 */
function setSheetObject(sheet_obj) {

	sheetObjects[sheetCnt++] = sheet_obj;

}

function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}


function splitChange(){
	
	var formObj = document.form;
	
	if(formObj.ofcCd.value =="RTMSC" || formObj.ofcCd.value =="HAMRUS" || formObj.ofcCd.value =="HAMRUG" || formObj.ofcCd.value =="SELCMQ") {
		if(formObj.in_list_type_temp(0).checked){
			formObj.pol_split_no.value = "1";
			formObj.pod_split_no.value = "";
			document.getElementById("span_polSplit").style.display = "inline";
			document.getElementById("span_podSplit").style.display = "none";
		}else{
			formObj.pol_split_no.value = "";
			formObj.pod_split_no.value = "1";
			document.getElementById("span_polSplit").style.display = "none";
			document.getElementById("span_podSplit").style.display = "inline";
		}
		
	}else{
		formObj.pol_split_no.value = "";
		formObj.pod_split_no.value = "";
		document.getElementById("span_polSplit").style.display = "none";
		document.getElementById("span_podSplit").style.display = "none";
	
	}
	
}


/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

	for (i = 0; i < sheetObjects.length; i++) {

		// khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	// IBMultiCombo초기화
	for ( var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k]);
	}
	initControl();

	splitChange();  // Add. 2015.02.09.
	
	axon_event.addListenerForm("click", "obj_click", document.form); 

}

function obj_click() {
	var formObject = document.form;
	var srcObj = window.event.srcElement;
	var srcName = srcObj.getAttribute("name");

	
	
	if (srcName == "thai_ofc") {
		if (formObject.thai_ofc.checked){
			document.getElementById("mainTable6").style.display="Inline"; 
			document.getElementById("mainTable").style.display="none"; 	

		}else{
			document.getElementById("mainTable").style.display="Inline"; 
			document.getElementById("mainTable6").style.display="none"; 
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
	// ** Date 구분자 **/
	DATE_SEPARATOR = "-";

	var formObject = document.form;
	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
	axon_event.addListenerForm('blur', 'obj_deactivate', formObject); // - 포커스
	// 나갈때
	axon_event.addListenerFormat('focus', 'obj_activate', formObject); // - 포커스
	// 들어갈때
	axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); // -
	// 키보드
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	ComBtnDisable("btn_ediDownload");
	ComBtnDisable("btn_cllForEdi");
	ComBtnDisable("btn_edi");
	ComBtnDisable("btn_sort");
	ComBtnDisable("btn_downExcel");
	ComBtnDisable("TAO/ODCY");
	ComBtnDisable("btn_print");
	ComBtnDisable("btn_faxemail");

//	ComBtnDisable("btn_multiretrieve");

	doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
	document.form.in_vvd_cd.focus()
}

/**
 * 조회조건 입력할 때 처리
 */
function obj_KeyUp() {
	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	if (ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}
 
//function obj_deactivate() {
//	var formObj = document.form;
//	switch(event.srcElement.name){
//		case "in_vvd_cd":		
//				var arrVvd  = formObj.in_vvd_cd.value.split(",")
//				if(arrVvd.length > 1){
//					ComBtnDisable("btn_retrieve");
//					ComBtnEnable("btn_multiretrieve");
//				} else {
//					ComBtnEnable("btn_retrieve");
//					ComBtnDisable("btn_multiretrieve");
//				}
//
//				ComBtnDisable("btn_ediDownload");
//				ComBtnDisable("btn_cllForEdi");
//				ComBtnDisable("btn_edi");
//				ComBtnDisable("btn_sort");
//				ComBtnDisable("btn_downExcel");
//				ComBtnDisable("TAO/ODCY");
//				ComBtnDisable("btn_print");
//				ComBtnDisable("btn_faxemail");
//			break;
//		default:
//			break; 
//	}
//}
 
 
/**
 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
 */
function obj_keypress() {
	switch (event.srcElement.dataformat) {
	case "uppernum":
		// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
		ComKeyOnlyAlphabet('uppernum');
		break;
	case "upper":
		// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
		ComKeyOnlyAlphabet('upper');
		break;
	case "uppernum2":
		// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
		ComKeyAlphabetNChar('uppernum');
		break;
    case "engupspecial": // 영문대문자 + Space + &-,.
    	ComKeyOnlyAlphabet('uppernum', "32|38|45|44|46");
	    break;
	default:
		// 숫자만입력하기(정수,날짜,시간)
		ComKeyOnlyNumber(event.srcElement);
	}
}

/**
 * 콤보 초기설정값
 * 
 * @param {IBMultiCombo}
 *            comboObj comboObj
 */
function initCombo(comboObj) {
	comboObj.MultiSelect = true;
	comboObj.UseCode = true;
	comboObj.LineColor = "#ffffff";
	comboObj.SetColAlign("left|left");
	comboObj.MultiSeparator = ",";
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 * @param sheetObj 시트오브젝트
 * @param sheetNo 시트오브젝트 태그의 아이디에 붙인 일련번호
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;

	switch (sheetID) {
	case "sheet1": // sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 175;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 5, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)
			
			// 틀고정 설정
			//FrozenCols = 14;

			var HeadTitle1 = "ibflag|cntr_no2|Seq.|Sel.|VVD CD|Container No.|" +
					"TP|Seal No.|Kind/Code|Kind/Code|W/O|WGT|WGT (T)|E.WGT (T)|VGM|VGM|VGM Signature|VGM Method|" +
//					"TP|Seal No.|Kind/Code|Kind/Code|W/O|WGT|WGT (T)|E.WGT (T)|" +
					"PKG|PKG|Booking No.|B/L No.|O B/L Serial No.|POR|POR|POR|" +
					"A/POL|A/POL|A/POL|A/POD|A/POD|A/POD|B/POL|B/POL|B/POL|B/POD|B/POD|B/POD|DEL|DEL|DEL|" +
					"BS|R|D|TS|CTP|Hot|Special Cargo|Special Cargo|" +
					"Former Lane|Former VVD|Customer|Customs Description|Yard|Gate In Date|S.O.C|" +
					"STOW|Rail Hub|HTS Code|HS Code|Meas|" +
					"Pre1.VVD|Pre2.VVD|Pre3.VVD|Pre4.VVD|Trunk VVD|Post1.VVD|Post2.VVD|Post3.VVD|Post4.VVD|" +
					"Pre1.POL|Pre2.POL|Pre3.POL|Pre4.POL|Post1.POL|Post2.POL|Post3.POL|Post4.POL";

			var headCount = ComCountHeadTitle(HeadTitle1);	
			
		  // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		
		   InitColumnInfo(headCount, 14, 0, true);
//			InitColumnInfo(headCount, 16, 0, true);
			
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "ibflag");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cntr_no2", false, "", dfNone, 0, false, true, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenterTop, true, "seq", false, "", dfNone, 0, false, true, false);
			InitDataProperty(0, cnt++, dtCheckBox, 40, daCenter, false, "del_chk");
			InitDataProperty(0, cnt++, dtHidden, 170, daCenter, false, "out_vvd_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 170, daCenter, false, "cntr_no", false, "", dfNone, 0, false, true);
			
			InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "cntr_tpsz_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "cntr_seal_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "seal_knd_cd", false, "", dfNone, 0, false, true, 1);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "seal_pty_tp_cd", false, "", dfNone, 0, false, true, 2);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "wo_flg", false, "", dfNone, 0, false, true, 2);
			InitDataProperty(0, cnt++, dtData, 90, daRight, false, "a_cntr_wgt", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 60, daRight, false, "cntr_wgt", false, "", dfNullInteger, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 65, daRight, false, "e_cntr_wgt", false, "", dfNullInteger, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 65, daRight, false, "vgm_wgt", false, "", dfNullInteger, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daRight, false, "vgm_wgt_ut_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "vgm_vrfy_sig_ctnt", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "vgm_mzd_tp_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 40, daRight, false, "pck_qty", false, "", dfNullInteger, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 25, daRight, false, "pck_tp_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 95, daLeft, false, "bkg_no", false, "", dfNone, 0, false, true);
			InitDAtaProperty(0, cnt++, dtData, 95, daLeft, false, "bl_no", false, "", dfNone, 0, false, true);
			InitDAtaProperty(0, cnt++, dtData, 95, daLeft, false, "obl_ser_no", false, "", dfNone, 0, false, true);
			
			
			InitDataProperty(0, cnt++, dtData, 45, daCenter, false, "por_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, false, "por_nod_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "por_nm");
			
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "pol_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 25, daCenter, false, "pol_yd_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "bpol_nm");

			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "pod_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 25, daCenter, false, "pod_yd_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "bpod_nm");
			
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "a_pol_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, false, "pol_nod_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "apol_nm");
			
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "a_pod_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, false, "pod_nod_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "apod_nm");
			
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "del_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, false, "del_nod_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "del_nm");

			InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "blck_stwg_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenter, false, "rcv_term_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenter, false, "de_term_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "ts_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "bkg_cgo_tp_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "hot_de_flg", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "spcl_cgo_desc_type", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 200, daCenter, false, "spcl_cgo_desc", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "slan_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, false, "vvd_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 370, daLeft, false, "cust_nm", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daLeft, false, "cstms_desc");
			
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "org_yd_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 120, daCenter, false, "cnmv_evnt_dt", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "soc_flg", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 65, daCenter, false, "stwg_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 55, daCenter, false, "blck_stwg_hub_loc_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 65, daCenter, false, "hamo_trf_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "cmdt_hs_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "meas_qty", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "prevvd1", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "prevvd2", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "prevvd3", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "prevvd4", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "trunkvvd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "postvvd1", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "postvvd2", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "postvvd3", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "postvvd4", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "pre1pol", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "pre2pol", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "pre3pol", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "pre4pol", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "post1pol", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "post2pol", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "post3pol", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "post4pol", false, "", dfNone, 0, false, true);
			ShowButtonImage = 1;
			CountPosition = 0;
		}
		break;

	case "sheet2": // backendjob 용
		with (sheetObj) {

			// 높이 설정
			style.height = 20;
			// 전체 너비 설정
			SheetWidth = 300;
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);
			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;
			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 2, 100);
			var HeadTitle1 = "f_text1"
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 ROW ,COL ,DATATYPE ,WIDTH,DATAALIGN,COLMERGE,SAVENAME
			// ,KEYFIELD,CALCULOGIC,DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX
			InitDataProperty(0, cnt++, dtData, 200, daLeft, false, "f_text1", false, "", dfNone, 0);

			// var idx = sheet2.DataInsert();

			RequestTimeOut = 6000;
			Visible = false; // backendjob 용으로 같이씀 참고 : 0015

		}
		break;
	case "sheet3": // sheet_search
		cnt = 0;
		with (sheetObj) {

			// 높이 설정
			style.height = 100;
			// 전체 너비 설정
			SheetWidth = 0;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 2, 100);

			var HeadTitle1 = "ibflag|SysCd|TmplMrd|Title|TmplParam|RcvInfo|SndNm|SndEml|Filekey|RcvEml|Contents|Bkg_no|Bl_no|TmplMrdPdf|itr|";
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
			InitDataProperty(0, cnt++, dtStatus, 30, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "syscd", false, "", dfNone, 0, false, false, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "tmplmrd", false, "", dfNone, 0, false, false, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "title", false, "", dfNone, 0, false, false, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "tmplparam", false, "", dfNone, 0, false, false, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "rcvinfo", false, "", dfNone, 0, false, false, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "sndnm", false, "", dfNone, 0, false, false, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "sndeml", false, "", dfNone, 0, false, false, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "filekey", false, "", dfNone, 0, false, false, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "rcveml", false, "", dfNone, 0, false, false, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "contents", false, "", dfNone, 0, false, false, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "bkg_no", false, "", dfNone, 0, false, false, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "bl_no", false, "", dfNone, 0, false, false, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "history_gubun", false, "", dfNone, 0, false, false, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "tmplmrdpdf", false, "", dfNone, 0, false, false, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "itr", false, "", dfNone, 0, false, false, 0, false, false);

			CountPosition = 0;
		}
		break;

	case "sheet4": // sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 175;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 5, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			var HeadTitle1 = "BOUND|BKG_NO|BL_NO|SPLIT|ATD_DT|ATA_DT|AWK_FRONT|AWK_HEIGHT|AWK_LEFT|AWK_REAR|AWK_RIGHT|BKG_ACT_WGT|BKG_ACT_WGT_TP_CD" +
					"|BKG_CGO_TP_CD|BKG_HOT_DEL_FLG|BKG_MEAS_QTY|BKG_MEAS_TP_CD|BKG_STS_CD|CARRIER_VSL_CD|CARRIERS_VOY_NO|CMDY_NM|CNEE_NM|CNTR_MEAS_QTY|CNTR_MEAS_TP_CD" +
					"|CNTR_NO|CNTR_TPSZ_CD|CNTR_WGT_QTY|CNTR_WGT_TP_CD|CSTMS_RMK|DEL_LOC|DEPOT_CD|DG_CLS|DMG_STS|EMS|ETA_DT|ETD_DT|FSH_POINT|HUMIDITY|LANE_CODE|MAR_POL|PKG_GRP" +
					"|BKG_PKG_QTY|BKG_PKG_TP_CD|POD_LOC|POL_LOC|RE_CMMD_NM|RF_TEMP|VENT|SEAL_NO|SHPR_NM|SOC_IND|SUBSI_RSK_FLG|UN_CD" +
					"|CNTR_PKG_QTY|CNTR_PKG_TP_CD|DG_CGO_FLAG|RF_FLAG|AK_FLAG|HG_FLAG|EQ_SUB_FLAG|RD_FLAG|DST_SVC_ROUT|EXT_REMARK|BKG_TP|MST_BKG_NO";

			var headCount = ComCountHeadTitle(HeadTitle1);
			
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 5, 0, true);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData, 30, daCenter, true, "bound");
			InitDataProperty(0, cnt++, dtData, 0, daCenter, true, "bkg_no", false, "", dfNone, 0, false, true, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenterTop, true, "bl_no", false, "", dfNone, 0, false, true, false);
			InitDataProperty(0, cnt++, dtData, 150, daCenter, false, "split", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "atd_dt", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "ata_dt", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 60, daRight, false, "awk_front", false, "", dfNullInteger, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 60, daRight, false, "awk_height", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 65, daRight, false, "awk_left", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 40, daRight, false, "awk_rear", false, "", dfNullInteger, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 25, daRight, false, "awk_right", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 95, daLeft, false, "bkg_act_wgt", false, "", dfNone, 0, false, true);
			InitDAtaProperty(0, cnt++, dtData, 95, daLeft, false, "bkg_act_wgt_tp_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 45, daCenter, false, "bkg_cgo_tp_cd", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 25, daCenter, false, "bkg_hot_del_flg", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "bkg_meas_qty", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 25, daCenter, false, "bkg_meas_tp_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "bkg_sts_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 25, daCenter, false, "carrier_vsl_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "carriers_voy_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, false, "cmdy_nm", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "cnee_nm", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, false, "cntr_meas_qty", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "cntr_meas_tp_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, false, "cntr_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "cntr_tpsz_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenter, false, "cntr_wgt_qty", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenter, false, "cntr_wgt_tp_cd", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "cstms_rmk", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "del_loc", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "depot_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenter, false, "dg_cls", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 200, daCenter, false, "dmg_sts", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 90, daCenter, false, "ems", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 370, daLeft, false, "eta_dt", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "etd_dt", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 120, daCenter, false, "fsh_point", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "humidity", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 65, daCenter, false, "lane_code", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 55, daCenter, false, "mar_pol", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 55, daCenter, false, "pkg_grp", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "bkg_pkg_qty", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "bkg_pkg_tp_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "pod_loc", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "pol_loc", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "re_cmmd_nm", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "rf_temp", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "vent", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "seal_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "shpr_nm", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "soc_ind", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "subsi_rsk_flg", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "un_cd", false, "", dfNone, 0, false, true);

			/*
			 * 2009년 8월 2일 경종윤
			 * 12필드 추가
			 */
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "cntr_pkg_qty", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "cntr_pkg_tp_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "dg_cgo_flag", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "rf_flag", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "ak_flag", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "hg_flag", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "eq_sub_flag", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "rd_flag", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "dst_svc_rout", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "ext_remark", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "bkg_tp", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "mst_bkg_no", false, "", dfNone, 0, false, true);
	
	}
		break;

	case "sheet5": // LCL Cntr
		with (sheetObj) {

			// 높이 설정
			style.height = 80;
			// 전체 너비 설정
			SheetWidth = 300;
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);
			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;
			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 2, 100);
			var HeadTitle1 = "cntr_no|cnt_flag"
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 ROW ,COL ,DATATYPE ,WIDTH,DATAALIGN,COLMERGE,SAVENAME
			// ,KEYFIELD,CALCULOGIC,DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX
			InitDataProperty(0, cnt++, dtData, 200, daLeft, false, "cntr_no", false, "", dfNone, 0);
			InitDataProperty(0, cnt++, dtData, 200, daLeft, false, "ibflag", false, "", dfNone, 0);
		}
		break;
	
		
		//타이 office 용 sheet 만들기 
	case "sheet6": // sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 175;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 5, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)
			
			// 틀고정 설정   
			//FrozenCols = 14;

			var HeadTitle1 = "ibflag|Seq.|Sel.|Trunk VVD|TP|Container No.|Seal No.|Booking No.|R|Special Cargo|Vent|POR|A/POD|B/POD|DEL|VGM|VGM|Post1.POL|Customs Desc|BS" 
					

			var headCount = ComCountHeadTitle(HeadTitle1);	
			
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
			
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "ibflag");
			InitDataProperty(0, cnt++, dtData, 40, daCenterTop, true, "seq", false, "", dfNone, 0, false, true, false);
			InitDataProperty(0, cnt++, dtCheckBox, 40, daCenter, false, "del_chk");
			InitDataProperty(0, cnt++, dtData, 70, daRight, false, "trunkvvd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "cntr_tpsz_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 170, daCenter, false, "cntr_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "cntr_seal_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 95, daCenter, false, "bkg_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenter, false, "rcv_term_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "spcl_cgo_desc", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 45, daCenter, false, "vent", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 45, daCenter, false, "por_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "pod_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "a_pod_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "del_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 65, daRight, false, "vgm_wgt", false, "", dfNullInteger, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daRight, false, "vgm_wgt_ut_cd", false, "", dfNone, 0, false, true);
//			InitDataProperty(0, cnt++, dtData, 65, daRight, false, "e_cntr_wgt", false, "", dfNullInteger, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "post1pol", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 0, daLeft, false, "cstms_desc");
			InitDataProperty(0, cnt++, dtData, 20, daCenter, false, "blck_stwg_cd", false, "", dfNone, 0, false, true);
	
			ShowButtonImage = 1;
			CountPosition = 0;
		}
		break;

		
		
	}
}

/**
 * Sheet관련 프로세스 처리
 * @param sheetObj Sheet
 * @param formObj form객체
 * @param sAction 작업처리코드
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case COMMAND09: // 조회
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);

		// top.document.body.scrollTop = 0;
		formObj.f_cmd.value = SEARCH02;
		if (formObj.in_list_type_temp(0).checked)
			formObj.in_list_type.value = "L";
		else
			formObj.in_list_type.value = "D";

		sheetObj.DoSearch("ESM_BKG_0159GS.do", FormQueryString(formObj));
		ComEtcDataToForm(formObj, sheetObj);

		state = sheetObj.EtcData("TRANS_RESULT_KEY");
		
		if (state == "S") {
			
			var columnSkipList = "";
			
			if(formObj.in_list_type.value == "D") {
				columnSkipList = "dst_svc_rout";
			} else {
				columnSkipList = "";
			}
			
			if(sheetObj.RowCount >0){
				sheetObj.SpeedDown2Excel(0, false, false, "", "", false, false, "", false, columnSkipList, "");
			}else{
				ComShowCodeMessage('BKG00095');	// No data found.
	 			ComOpenWait(false);
				return;
			}
		}
		ComOpenWait(false);
		break;
	case IBSEARCH: // 조회
//	case COMMAND10: // Multi Down Excel
		if (validateForm(sheetObj, formObj, sAction)) {
			//top.document.body.scrollTop = 0;
			formObj.f_cmd.value = SEARCH;
			if (formObj.in_list_type_temp(0).checked)
				formObj.in_list_type.value = "L";
			else
				formObj.in_list_type.value = "D";

			if (formObj.in_ofc_cd_type_temp(0).checked)
				formObj.in_ofc_cd_type.value = "B";
			else
				formObj.in_ofc_cd_type.value = "S";

			if (formObj.in_pol_ts1.checked && formObj.in_pol_ts2.checked || !formObj.in_pol_ts1.checked && !formObj.in_pol_ts2.checked)
				formObj.in_pol_ts.value = "";
			else if (formObj.in_pol_ts1.checked)
				formObj.in_pol_ts.value = "L";
			else if (formObj.in_pol_ts2.checked)
				formObj.in_pol_ts.value = "T";

			if (formObj.in_pod_ts1.checked && formObj.in_pod_ts2.checked || !formObj.in_pod_ts1.checked && !formObj.in_pod_ts2.checked)
				formObj.in_pod_ts.value = "";
			else if (formObj.in_pod_ts1.checked)
				formObj.in_pod_ts.value = "L";
			else if (formObj.in_pod_ts2.checked)
				formObj.in_pod_ts.value = "T";

			if (formObj.in_cntr_cfm_flg1.checked && formObj.in_cntr_cfm_flg2.checked || !formObj.in_cntr_cfm_flg1.checked
					&& !formObj.in_cntr_cfm_flg2.checked)
				formObj.in_cntr_cfm_flg.value = "";
			else if (formObj.in_cntr_cfm_flg1.checked)
				formObj.in_cntr_cfm_flg.value = "Y";
			else if (formObj.in_cntr_cfm_flg2.checked)
				formObj.in_cntr_cfm_flg.value = "N";

			if (formObj.in_cntr_match_temp.checked)
				formObj.in_cntr_match.value = "N";
			else
				formObj.in_cntr_match.value = "Y";

			if (formObj.in_dcgo_flg.checked)
				formObj.in_dcgo_flg.value = "Y";
			else
				formObj.in_dcgo_flg.value = "";

			if (formObj.in_rc_flg.checked)
				formObj.in_rc_flg.value = "Y";
			else
				formObj.in_rc_flg.value = "";

			if (formObj.in_awk_cgo_flg.checked)
				formObj.in_awk_cgo_flg.value = "Y";
			else
				formObj.in_awk_cgo_flg.value = "";

			if (formObj.in_bb_cgo_flg.checked)
				formObj.in_bb_cgo_flg.value = "Y";
			else
				formObj.in_bb_cgo_flg.value = "";

			if (formObj.in_stwg_cd.checked)
				formObj.in_stwg_cd.value = "Y";
			else
				formObj.in_stwg_cd.value = "";

			if (formObj.in_hot_de_flg.checked)
				formObj.in_hot_de_flg.value = "Y";
			else
				formObj.in_hot_de_flg.value = "";

			if (formObj.in_rd_cgo_flg.checked)
				formObj.in_rd_cgo_flg.value = "Y";
			else
				formObj.in_rd_cgo_flg.value = "";

			if (formObj.in_soc_flg.checked)
				formObj.in_soc_flg.value = "Y";
			else
				formObj.in_soc_flg.value = "";

			if (formObj.in_prct_flg.checked)
				formObj.in_prct_flg.value = "Y";
			else
				formObj.in_prct_flg.value = "";
			
			if (formObj.in_hngr_flg.checked)
				formObj.in_hngr_flg.value = "Y";
			else
				formObj.in_hngr_flg.value = "";

			if (formObj.in_including_type_temp.checked)
				formObj.in_including_type.value = "Y";
			else
				formObj.in_including_type.value = "N";

			if (formObj.in_bkg_cgo_tp_cd.Code == "A")
				formObj.in_bkg_cgo_tp_cd_temp.value = "A";
			if (formObj.in_bkg_cgo_tp_cd.Code == "F")
				formObj.in_bkg_cgo_tp_cd_temp.value = "F";
			if (formObj.in_bkg_cgo_tp_cd.Code == "P")
				formObj.in_bkg_cgo_tp_cd_temp.value = "P";
			if (formObj.in_bkg_cgo_tp_cd.Code == "R")
				formObj.in_bkg_cgo_tp_cd_temp.value = "R";
			if (formObj.in_bkg_cgo_tp_cd.Code == "B")
				formObj.in_bkg_cgo_tp_cd_temp.value = "B";
			if (formObj.in_bkg_cgo_tp_cd.Code == "")
				formObj.in_bkg_cgo_tp_cd_temp.value = "";

			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			var sParam = "";
			var sParamSheet2 = sheetObj.GetSaveString();
//			var sParamSheet3 = sheetObjects[5].GetSaveString();
			
			if (sParamSheet2 != "") {
				sParam += "&" + ComSetPrifix(sParamSheet2, "");
			}

			sParam += "&" + FormQueryString(formObj);

			
			top.document.body.scrollTop = 0;
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0159GS.do", sParam);
			//alert(sParam);
//			sheetObjects[5].LoadSearchXml(sXml); 
			var key = ComGetEtcData(sXml, "KEY");
			// top.document.body.`scrollTop = 0;
			if (formObj.thai_ofc.checked){
				intervalId = setInterval("doActionValidationResult(sheetObjects[5], '" + key + "');", 3000);
			} else {
				intervalId = setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');", 3000);
			}
		
		}
		break;

	case IBSAVE: // 저장
		if (validateForm(sheetObj, formObj, sAction)) {
			//top.document.body.scrollTop = 0;
			formObj.f_cmd.value = MULTI;
			if (formObj.in_pol_ts1.checked && formObj.in_pol_ts2.checked || !formObj.in_pol_ts1.checked && !formObj.in_pol_ts2.checked)
				formObj.in_pol_ts.value = "";
			else if (formObj.in_pol_ts1.checked)
				formObj.in_pol_ts.value = "L";
			else if (formObj.in_pol_ts2.checked)
				formObj.in_pol_ts.value = "T";
			// sheetObj.CheckAll("del_chk") = 1;
			// ComOpenWait(true);
			sheetObjects[0].WaitImageVisible = false;
			ComOpenWait(true);
			for ( var i = 1; i < sheetObjects[0].RowCount + 1; i++) {
				//sheetObjects[0].CellValue(i, "ibflag") = "I";
				sheetObjects[0].RowStatus(i) = "I";
			}

			var sParam = "";
			var sParamSheet2 = sheetObjects[0].GetSaveString();
			if (sParamSheet2 != "") {
				sParam += "&" + ComSetPrifix(sParamSheet2, "");
			}
			sParam += "&" + FormQueryString(formObj);
			// ComOpenWait(true);
			top.document.body.scrollTop = 0;
			var sXml = sheetObjects[0].GetSaveXml("ESM_BKG_0159GS.do", sParam);
			var key = ComGetEtcData(sXml, "KEY");
			// ComOpenWait(true);

			// top.document.body.scrollTop = 0;
			intervalId = setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');", 3000);
			// top.document.body.scrollTop = 0;

		}
		break;
	case COMMAND01: // 입력

		formObj.f_cmd.value = INIT;
		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);
		var sXml = sheetObj.GetSearchXml("ESM_BKG_0159GS.do", FormQueryString(formObj));
		var arrXml = sXml.split("|$$|");

		ComXml2ComboItem(arrXml[0], formObj.in_bkg_cgo_tp_cd, "val", "desc");
		// ComXml2ComboItem(arrXml[0], formObj.in_bkg_cgo_tp_cd, "val", "name");
		formObj.in_bkg_cgo_tp_cd.DropHeight = 300;
		// ComXml2ComboItem(arrXml[1], formObj.in_cntr_tpsz_cd, "cntr_tpsz_cd",
		// "cntr_tpsz_cd|cntr_tpsz_cd");
		ComXml2ComboItem(arrXml[1], formObj.in_cntr_tpsz_cd, "cntr_tpsz_cd", "cntr_tpsz_cd");
		formObj.in_cntr_tpsz_cd.DropHeight = 300;
		// comboObjects[1].Code = "D2,D4";
		// ComXml2ComboItem(arrXml[2], formObj.in_rcv_term_cd, "val",
		// "val|name");
		ComXml2ComboItem(arrXml[2], formObj.in_rcv_term_cd, "val", "name");
		formObj.in_rcv_term_cd.DropHeight = 300;
		// ComXml2ComboItem(arrXml[2], formObj.in_de_term_cd, "val",
		// "val|name");
		ComXml2ComboItem(arrXml[3], formObj.in_de_term_cd, "val", "name");
		formObj.in_de_term_cd.DropHeight = 300;
		// ComXml2ComboItem(arrXml[3], formObj.in_org_trns_svd_mod_cd, "val",
		// "val|name");
		ComXml2ComboItem(arrXml[4], formObj.in_org_trns_svd_mod_cd, "val", "name");
		formObj.in_org_trns_svd_mod_cd.DropHeight = 300;
		// ComXml2ComboItem(arrXml[3], formObj.in_dest_trns_svc_mod_cd, "val",
		// "val|name");
		ComXml2ComboItem(arrXml[4], formObj.in_dest_trns_svc_mod_cd, "val", "name");
		formObj.in_dest_trns_svc_mod_cd.DropHeight = 300;
		ComOpenWait(false);
		break;
	case IBDOWNEXCEL:
		var noRows = "";
		if (validateForm(sheetObj, formObj, sAction)) {
			for ( var i = 1; i <= sheetObj.RowCount + 1; i++) {
				// if( sheetObj.CellValue(i, "cntr_tpsz_cd") == "" ||
				// sheetObj.CellValue(i, "del_chk") == 0 )
				if (sheetObj.CellValue(i, "cntr_tpsz_cd") == "") {
					noRows = noRows + i + "|";
				}
			}

			// var noRows2 = "";
			if (noRows.length > 0)
				noRows = noRows.substring(0, noRows.length - 1);

			sheetObj.SpeedDown2Excel(0, false, false, "", "", false, false, "", false, "ibflag|cntr_no2|del_chk|meas_qty", noRows);
		}
		break;

	case COMMAND03: // 입력
		var inListType = "";
		if (formObj.in_list_type_temp(0).checked)
			inListType = "L";
		else
			inListType = "D";
		var inVvdCd = formObj.in_vvd_cd.value;
		var inPolCd = formObj.in_pol_cd.value;
		var inPodCd = formObj.in_pod_cd.value;
		var inPolSplitNo = formObj.pol_split_no.value; // Add. 2015.02.09. CHM-201533845
		var inPodSplitNo = formObj.pod_split_no.value; // Add. 2015.02.09. CHM-201533845
		
		var inPolTs = "";
		if (formObj.in_pol_ts1.checked && formObj.in_pol_ts2.checked || !formObj.in_pol_ts1.checked && !formObj.in_pol_ts2.checked)
			inPolTs = "";
		else if (formObj.in_pol_ts1.checked)
			inPolTs = "L";
		else if (formObj.in_pol_ts2.checked)
			inPolTs = "T";

		var sUrl = "/hanjin/ESM_BKG_0155.do?pgmNo=ESM_BKG_0155&inListType=" + inListType + "&inVvdCd=" + inVvdCd + "&inPolCd=" + inPolCd
				+ "&inPodCd=" + inPodCd + "&inPolTs=" + inPolTs + "&inPolSplitNo=" + inPolSplitNo;
		// var sUrl = "/hanjin/ESM_BKG_0456.do?bl_no="+selectedBlNumber;
		// location.href = sUrl;
		ComOpenWindowCenter(sUrl, "ESM_BKG_0155", 1024, 580, true);
		// ComOpenWindowCenter(sUrl, "ESM_BKG_0161", 400, 240, false);

		break;

	case COMMAND04: // 입력
		if (validateForm(sheetObj, formObj, sAction)) {
			var inListType = "";
			if (formObj.in_list_type_temp(0).checked)
				inListType = "L";
			else
				inListType = "D";
			var inVvdCd = formObj.in_vvd_cd.value;
			var inPolCd = formObj.in_pol_cd.value;
			var inPodCd = formObj.in_pod_cd.value;
			var inPodSplitNo = formObj.pod_split_no.value;

			var sUrl = "/hanjin/ESM_BKG_0723.do?pgmNo=ESM_BKG_0723&inListType=" + inListType + "&inVvdCd=" + inVvdCd + "&inPolCd=" + inPolCd
					+ "&inPodCd=" + inPodCd + "&inPodSplitNo=" + inPodSplitNo;  // Add. 2015.02.09
			// var sUrl = "/hanjin/ESM_BKG_0456.do?bl_no="+selectedBlNumber;
			// location.href=sUrl;
			ComOpenWindowCenter(sUrl, "ESM_BKG_0723", 450, 430, true);
			// ComOpenWindowCenter(sUrl, "ESM_BKG_0161", 400, 240, false);
		}
		break;

	case COMMAND05: // 입력
		var sUrl = "/hanjin/ESM_BKG_0161.do?pgmNo=ESM_BKG_0161&codeGubun=CD02298";
		// var sUrl = "/hanjin/ESM_BKG_0456.do?bl_no="+selectedBlNumber;
		// ComOpenWindowCenter(sUrl, "ESM_BKG_0458", 1024, 768, false);
		ComOpenWindowCenter(sUrl, "ESM_BKG_0161", 400, 260, false);

		break;

	case COMMAND08: // 입력
		var sUrl = "/hanjin/ESM_BKG_0221.do?pgmNo=ESM_BKG_0221&ui_id=ESM_BKG_0159&ok_hidden=Y";
		// var sUrl = "/hanjin/ESM_BKG_0456.do?bl_no="+selectedBlNumber;
		// ComOpenWindowCenter(sUrl, "ESM_BKG_0458", 1024, 768, false);
		ComOpenWindowCenter(sUrl, "ESM_BKG_0221", 360, 180, false);

		break;

	case COMMAND06: // 입력
		var inListType = "";
		if (formObj.in_list_type_temp(0).checked)
			inListType = "L";
		else
			inListType = "D";

		var inOfcCdType = "";
		if (formObj.in_ofc_cd_type_temp(0).checked)
			inOfcCdType = "B";
		else
			inOfcCdType = "S";

		var inPolTs = "";
		if (formObj.in_pol_ts1.checked && formObj.in_pol_ts2.checked || !formObj.in_pol_ts1.checked && !formObj.in_pol_ts2.checked)
			inPolTs = "";
		else if (formObj.in_pol_ts1.checked)
			inPolTs = "L";
		else if (formObj.in_pol_ts2.checked)
			inPolTs = "T";

		var inPodTs = "";
		if (formObj.in_pod_ts1.checked && formObj.in_pod_ts2.checked || !formObj.in_pod_ts1.checked && !formObj.in_pod_ts2.checked)
			inPodTs = "";
		else if (formObj.in_pod_ts1.checked)
			inPodTs = "L";
		else if (formObj.in_pod_ts2.checked)
			inPodTs = "T";

		var inCntrCfmFlg = "";
		if (formObj.in_cntr_cfm_flg1.checked && formObj.in_cntr_cfm_flg2.checked || !formObj.in_cntr_cfm_flg1.checked
				&& !formObj.in_cntr_cfm_flg2.checked)
			inCntrCfmFlg = "";
		else if (formObj.in_cntr_cfm_flg1.checked)
			inCntrCfmFlg = "Y";
		else if (formObj.in_cntr_cfm_flg2.checked)
			inCntrCfmFlg = "N";

		var inCntrMatch = "";
		if (formObj.in_cntr_match_temp.checked)
			inCntrMatch = "N";
		else
			inCntrMatch = "Y";

		var inDcgoFlg = "";
		if (formObj.in_dcgo_flg.checked)
			inDcgoFlg = "Y";
		else
			inDcgoFlg = "";

		var inRcFlg = "";
		if (formObj.in_rc_flg.checked)
			inRcFlg = "Y";
		else
			inRcFlg = "";

		var inAwkCgoFlg = "";
		if (formObj.in_awk_cgo_flg.checked)
			inAwkCgoFlg = "Y";
		else
			inAwkCgoFlg = "";

		var inBbCgoFlg = "";
		if (formObj.in_bb_cgo_flg.checked)
			inBbCgoFlg = "Y";
		else
			inBbCgoFlg = "";

		var inStwgCd = "";
		if (formObj.in_stwg_cd.checked)
			inStwgCd = "Y";
		else
			inStwgCd = "";

		var inHotDeFlg = "";
		if (formObj.in_hot_de_flg.checked)
			inHotDeFlg = "Y";
		else
			inHotDeFlg = "";

		var inRdCgoFlg = "";
		if (formObj.in_rd_cgo_flg.checked)
			inRdCgoFlg = "Y";
		else
			inRdCgoFlg = "";

		var inSocFlg = "";
		if (formObj.in_soc_flg.checked)
			inSocFlg = "Y";
		else
			inSocFlg = "";

		var inPrctFlg = "";
		if (formObj.in_prct_flg.checked)
			inPrctFlg = "Y";
		else
			inPrctFlg = "";

		var inHngrFlg = "";
		if (formObj.in_hngr_flg.checked)
			inHngrFlg = "Y";
		else
			inHngrFlg = "";
		
		var inIncludingType = "";
		if (formObj.in_including_type_temp.checked)
			inIncludingType = "Y";
		else
			inIncludingType = "N";

		var inBkgCgoTpCd = "";

		var tempArray = formObj.in_bkg_cgo_tp_cd.Code.split(",");

		for ( var i = 0; i < tempArray.length; i++) {
			inBkgCgoTpCd = inBkgCgoTpCd + "'" + tempArray[i] + "',";
		}
		if (inBkgCgoTpCd == "'',")
			inBkgCgoTpCd = "";

		if (inBkgCgoTpCd.length > 0)
			inBkgCgoTpCd = inBkgCgoTpCd.substr(0, inBkgCgoTpCd.length - 1);

		var inCntrTpszCd = "";
		var tempArray = formObj.in_cntr_tpsz_cd.Code.split(",");
		for ( var i = 0; i < tempArray.length; i++) {
			inCntrTpszCd = inCntrTpszCd + "'" + tempArray[i] + "',"
		}
		if (inCntrTpszCd == "'',")
			inCntrTpszCd = "";
		if (inCntrTpszCd.length > 0)
			inCntrTpszCd = inCntrTpszCd.substr(0, inCntrTpszCd.length - 1);

		var inRcvTermCd = "";
		var tempArray = formObj.in_rcv_term_cd.Code.split(",");
		for ( var i = 0; i < tempArray.length; i++) {
			inRcvTermCd = inRcvTermCd + "'" + tempArray[i] + "',"
		}
		if (inRcvTermCd == "'',")
			inRcvTermCd = "";
		if (inRcvTermCd.length > 0)
			inRcvTermCd = inRcvTermCd.substr(0, inRcvTermCd.length - 1);

		var inDeTermCd = "";
		var tempArray = formObj.in_de_term_cd.Code.split(",");
		for ( var i = 0; i < tempArray.length; i++) {
			inDeTermCd = inDeTermCd + "'" + tempArray[i] + "',"
		}
		if (inDeTermCd == "'',")
			inDeTermCd = "";
		if (inDeTermCd.length > 0)
			inDeTermCd = inDeTermCd.substr(0, inDeTermCd.length - 1);

		var inOrgTrnsSvdModCd = "";
		var tempArray = formObj.in_org_trns_svd_mod_cd.Code.split(",");
		for ( var i = 0; i < tempArray.length; i++) {
			inOrgTrnsSvdModCd = inOrgTrnsSvdModCd + "'" + tempArray[i] + "',"
		}
		if (inOrgTrnsSvdModCd == "'',")
			inOrgTrnsSvdModCd = "";
		if (inOrgTrnsSvdModCd.length > 0)
			inOrgTrnsSvdModCd = inOrgTrnsSvdModCd.substr(0, inOrgTrnsSvdModCd.length - 1);

		var inDestTrnsSvcModCd = "";
		var tempArray = formObj.in_dest_trns_svc_mod_cd.Code.split(",");
		for ( var i = 0; i < tempArray.length; i++) {
			inDestTrnsSvcModCd = inDestTrnsSvcModCd + "'" + tempArray[i] + "',"
		}
		if (inDestTrnsSvcModCd == "'',")
			inDestTrnsSvcModCd = "";
		if (inDestTrnsSvcModCd.length > 0)
			inDestTrnsSvcModCd = inDestTrnsSvcModCd.substr(0, inDestTrnsSvcModCd.length - 1);
		
		var param = "/rp [" + inListType + "][" + inOfcCdType + "][" + formObj.in_ofc_cd.value + "][" + formObj.in_bkg_sts_cd.value + "]["
				+ inBkgCgoTpCd + "][" + formObj.in_vvd_cd.value + "][" + formObj.in_pol_cd.value + "][" + inPolTs + "][" + formObj.in_pod_cd.value
				+ "][" + inPodTs + "][" + inCntrTpszCd + "][" + formObj.in_por_cd.value + "][" + formObj.in_del_cd.value + "][" + inRcvTermCd + "]["
				+ inDeTermCd + "][" + inOrgTrnsSvdModCd + "][" + inDestTrnsSvcModCd + "][" + inDcgoFlg + "][" + inRcFlg + "][" + inAwkCgoFlg + "]["
				+ inBbCgoFlg + "][" + inStwgCd + "][" + inHotDeFlg + "][" + inRdCgoFlg + "][" + inSocFlg + "][" + inPrctFlg + "][" + inCntrCfmFlg
				+ "][" + inCntrMatch + "][" + formObj.in_order_by_type.value + "][" + formObj.in_pol_yd_cd.value + "][" + formObj.in_pod_yd_cd.value
				+ "][" + formObj.in_scc_cd.value + "][" + formObj.vvd_nkm.value + "][" + formObj.un_loc_cd.value + "][" + formObj.vps_eta_dt.value
				+ "][" + formObj.vps_etd_dt.value + "][" + formObj.vps_etb_dt.value + "][" + formObj.d2.value + "][" + formObj.d4.value + "]["
				+ formObj.d5.value + "][" + formObj.d7.value + "][" + formObj.d8.value + "][" + formObj.d9.value + "][" + formObj.dw.value + "]["
				+ formObj.dx.value + "][" + formObj.r2.value + "][" + formObj.r4.value + "][" + formObj.r5.value + "][" + formObj.f2.value + "]["
				+ formObj.f4.value + "][" + formObj.f5.value + "][" + formObj.o2.value + "][" + formObj.o4.value + "][" + formObj.s2.value + "]["
				+ formObj.s4.value + "][" + formObj.t2.value + "][" + formObj.t4.value + "][" + formObj.a2.value + "][" + formObj.a4.value + "]["
				+ formObj.p2.value + "][" + formObj.p4.value + "][" + formObj.total20.value + "][" + formObj.total40.value + "][" + formObj.totalTpSize.value
				+ "][" + formObj.full.value + "][" + formObj.empty.value + "][" + formObj.local.value + "][" + formObj.ts.value + "]["
				+ formObj.ewgt.value + "][" + formObj.wgt.value + "][" + formObj.measure.value + "][" + formObj.hji.value + "][" + formObj.kk4.value
				+ "][" + formObj.kk6.value + "][" + formObj.kx1.value + "][" + formObj.kx5.value + "][" + formObj.lax.value + "]["
				+ formObj.lb1.value + "][" + formObj.lb2.value + "][" + formObj.lb3.value + "][" + formObj.lb4.value + "][" + formObj.lbt.value
				+ "][" + formObj.lgb.value + "][" + formObj.se1.value + "][" + formObj.sea.value + "][" + formObj.va1.value + "]["
				+ formObj.van.value + "][" + formObj.hot.value + "][" + inIncludingType + "][" + inHngrFlg + "][" + formObj.o5.value + "][" 
				+ formObj.pol_split_no.value + "][" + formObj.pod_split_no.value + "][" + formObj.a5.value + "][" + formObj.o7.value + "]";

		//alert(param);
		formObj.com_mrdArguments.value = param;
		ComOpenRDPopup("width=1024, height=600");
		// ComOpenWindowCenter(sUrl, "0783", 1024, 720, false);

		break;

	case COMMAND07: // 입력
		comBkgCallPopBkgDetail(bkgNo);

		// var sUrl = "/hanjin/ESM_BKG_0079.do?pgmNo=ESM_BKG_0079&bkg_no=" + bkgNo;
		// ComOpenWindowCenter(sUrl, "ESM_BKG_0079", 1024, 630, false);

		break;
	}
}

/**
 * BackEndJob 처리
 * @param sheetObj Sheet
 * @param sKey sKey
 */
function doActionValidationResult(sheetObj, sKey) {

	// top.document.body.scrollTop = 0;
	var formObj = document.form;
	// sheetObjects[0].WaitImageVisble = false;
	// ComOpenWait(true);
	// top.document.body.scrollTop = 0;
	var sXml = sheetObj.GetSearchXml("ESM_BKG_0159GS.do?f_cmd=" + SEARCH03 + "&key=" + sKey + "&formCommand=" + formObj.f_cmd.value);
	// ComOpenWait(true);
	var arrXml = sXml.split("|$$|");
	var sJbStsFlg = ComGetEtcData(arrXml[0], "jb_sts_flg");
	formObj.vessel_name.value = ComGetEtcData(arrXml[0], "vessel_name");

	// top.document.body.scrollTop = 0;
	// 에러가 발생했을 경우 대기사항을 종료한다.
	if (!ComBkgErrMessage(sheetObj, arrXml[0])) {
		clearInterval(intervalId);
		ComOpenWait(false);
		return;
	}
	if (sJbStsFlg == "SUCCESS") {

		clearInterval(intervalId);
		ComOpenWait(false);
		// 성공메시지 보여주고
		// ComShowCodeMessage('BKG00166');
		// ComShowMessage(ComResultMessage(sXml));
		// sheet1, sheet2 다시 조회
		// var selRow = sheetObjects[0].SelectRow;
		if (document.form.f_cmd.value == "2") {
			sheetObjects[0].LoadSearchXml(arrXml[0]);

			if (formObj.thai_ofc.checked){
				sheetObj.LoadSearchXml(arrXml[0]);
			}
			
			sheetObjects[4].LoadSearchXml(arrXml[1]);
			state = sheetObjects[0].EtcData("TRANS_RESULT_KEY");

			if (state == "S") {
				var d2 = 0;
				var d4 = 0;
				var d5 = 0;
				var d7 = 0;
				var d8 = 0;
				var d9 = 0;
				var dw = 0;
				var dx = 0;
				var r2 = 0;
				var r4 = 0;
				var r5 = 0;
				var f2 = 0;
				var f4 = 0;
				var f5 = 0;
				var o2 = 0;
				var o4 = 0;
				var o5 = 0;
				var o7 = 0;
				var s2 = 0;
				var s4 = 0;
				var t2 = 0;
				var t4 = 0;
				var a2 = 0;
				var a4 = 0;
				var a5 = 0; 
				var p2 = 0;
				var p4 = 0;
				var z2 = 0;
				var z4 = 0;
				var totalTpSize = 0;
				var local = 0;
				var full = 0;
				var empty = 0;
				var no_vgm_total = 0;
				var no_vgm_local =0;
				var no_vgm_ts =0;
				var ts = 0;
				var wgt = 0;
				var wgt2 = 0;
				var wgt3 = 0;
				var measure = 0;
				var hji = 0;
				var kk4 = 0;
				var kk6 = 0;
				var kx1 = 0;
				var kx5 = 0;
				var lax = 0;
				var lb1 = 0;
				var lb2 = 0;
				var lb3 = 0;
				var lb4 = 0
				var lbt = 0;
				var lgb = 0;
				var se1 = 0;
				var sea = 0;
				var va1 = 0;
				var van = 0;
				var hot = 0;
				var sh1 = 0;
				var sh2 = 0;
				var sha = 0; // 2014.08.11 CHM-201431533 , Hannah Lee
				
				var total20 = 0;
				var total40 = 0;
				
				var cntrTpszCd = "";
				var blckStwgCd = "";

				sheetObjects[0].ColFontColor("bkg_no") = sheetObjects[0].RgbColor(0, 0, 255);
				sheetObjects[0].ColFontUnderline("bkg_no") = true;
//				var cntrNo = "";
				var skip = false;
				
				for ( var i = 1; i <= sheetObjects[0].RowCount; i++) {
					for (var j = 1; j < sheetObjects[4].RowCount + 1; j++) {
						if (sheetObjects[0].CellValue(i, "cntr_no") == sheetObjects[4].CellValue(j, "cntr_no")) {
							if (sheetObjects[4].CellValue(j, "ibflag") == "Y") {
								skip = true;
							} else {
								sheetObjects[4].CellValue2(j, "ibflag") = "Y";
							}
							break;
						}
					}
					if (!skip) {
						if (sheetObjects[0].CellValue(i, "seq") == "") {
							sheetObjects[0].RowEditable(i) = false;
						}
						
						cntrTpszCd = sheetObjects[0].CellValue(i, "cntr_tpsz_cd");
						
						if (cntrTpszCd == "D2") {
							d2 = d2 + 1;
							totalTpSize = totalTpSize + 1;
//							wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
//							wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
//							measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "D4") {
							d4 = d4 + 1;
							totalTpSize = totalTpSize + 1;
//							wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
//							wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
//							measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "D5") {
							d5 = d5 + 1;
							totalTpSize = totalTpSize + 1;
//							wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
//							wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
//							measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "D7") {
							d7 = d7 + 1;
							totalTpSize = totalTpSize + 1;
//							wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
//							wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
//							measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "D8") {
							d8 = d8 + 1;
							totalTpSize = totalTpSize + 1;
//							wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
//							wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
//							measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "D9") {
							d9 = d9 + 1;
							totalTpSize = totalTpSize + 1;
//							wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
//							wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
//							measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "DW") {
							dw = dw + 1;
							totalTpSize = totalTpSize + 1;
//							wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
//							wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
//							measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "DX") {
							dx = dx + 1;
							totalTpSize = totalTpSize + 1;
//							wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
//							wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
//							measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "R2") {
							r2 = r2 + 1;
							totalTpSize = totalTpSize + 1;
//							wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
//							wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
//							measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "R4") {
							r4 = r4 + 1;
							totalTpSize = totalTpSize + 1;
//							wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
//							wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
//							measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "R5") {
							r5 = r5 + 1;
							totalTpSize = totalTpSize + 1;
//							wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
//							wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
//							measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "R7") {
							r5 = r5 + 1;
							totalTpSize = totalTpSize + 1;
//							wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
//							wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
//							measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "R8") {
							r5 = r5 + 1;
							totalTpSize = totalTpSize + 1;
//							wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
//							wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
//							measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "R9") {
							r5 = r5 + 1;
							totalTpSize = totalTpSize + 1;
//							wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
//							wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
//							measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "F2") {
							f2 = f2 + 1;
							totalTpSize = totalTpSize + 1;
//							wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
//							wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
//							measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "F4") {
							f4 = f4 + 1;
							totalTpSize = totalTpSize + 1;
//							wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
//							wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
//							measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "F5") {
							f5 = f5 + 1;
							totalTpSize = totalTpSize + 1;
//							wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
//							wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
//							measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "O2") {
							o2 = o2 + 1;
							totalTpSize = totalTpSize + 1;
//							wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
//							wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
//							measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "O4") {
							o4 = o4 + 1;
							totalTpSize = totalTpSize + 1;
//							wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
//							wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
//							measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "O5") {
							o5 = o5 + 1;
							totalTpSize = totalTpSize + 1;
//							wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
//							wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
//							measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "O7") {
							o7 = o7 + 1;
							totalTpSize = totalTpSize + 1;
//							wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
//							wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
//							measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "S2") {
							s2 = s2 + 1;
							totalTpSize = totalTpSize + 1;
//							wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
//							wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
//							measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "S4") {
							s4 = s4 + 1;
							totalTpSize = totalTpSize + 1;
//							wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
//							wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
//							measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "T2") {
							t2 = t2 + 1;
							totalTpSize = totalTpSize + 1;
//							wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
//							wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
//							measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "T4") {
							t4 = t4 + 1;
							totalTpSize = totalTpSize + 1;
//							wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
//							wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
//							measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "A2") {
							a2 = a2 + 1;
							totalTpSize = totalTpSize + 1;
//							wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
//							wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
//							measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "A4") {
							a4 = a4 + 1;
							totalTpSize = totalTpSize + 1;
//							wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
//							wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
//							measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "A5") {
							a5 = a5 + 1;
							totalTpSize = totalTpSize + 1;
//							wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
//							wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
//							measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "P2") {
							p2 = p2 + 1;
							totalTpSize = totalTpSize + 1;
//							wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
//							wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
//							measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "P4") {
							p4 = p4 + 1;
							totalTpSize = totalTpSize + 1;
//							wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
//							wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
//							measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
						}
						
						if (sheetObjects[0].CellValue(i, "seq") != "") {
							if (sheetObjects[0].CellValue(i, "ts_cd").substring(0, 1) == "T")
								ts = ts + 1;
							else
								local = local + 1;
							if (sheetObjects[0].CellValue(i, "bkg_cgo_tp_cd") != "P")
								full = full + 1;
							else
								empty = empty + 1;
						}
						
						//alert("1");
						if (sheetObjects[0].CellValue(i, "seq") != "") {
							if (sheetObjects[0].CellValue(i, "vgm_wgt") == "0" && sheetObjects[0].CellValue(i, "ts_cd").substring(0, 1) == "T" && sheetObjects[0].CellValue(i, "bkg_cgo_tp_cd") != "P" &&sheetObjects[0].CellValue(i, "bkg_cgo_tp_cd") != "B")
								no_vgm_ts = no_vgm_ts + 1;
							else if (sheetObjects[0].CellValue(i, "vgm_wgt") == "0" && sheetObjects[0].CellValue(i, "ts_cd").substring(0, 1) == "L" && sheetObjects[0].CellValue(i, "bkg_cgo_tp_cd") != "P" &&sheetObjects[0].CellValue(i, "bkg_cgo_tp_cd") != "B")
								no_vgm_local = no_vgm_local + 1;
							else (sheetObjects[0].CellValue(i, "vgm_wgt") == "0")
								no_vgm_total = no_vgm_ts + no_vgm_local;
							
						}
						
						//alert("2");

						blckStwgCd = sheetObjects[0].CellValue(i, "blck_stwg_cd");
						if (blckStwgCd == "HJI") {
							hji = hji + 1;
						}
						if (blckStwgCd == "KK4") {
							kk4 = kk4 + 1;
						}
						if (blckStwgCd == "KK6") {
							kk6 = kk6 + 1;
						}
						if (blckStwgCd == "KX1") {
							kx1 = kx1 + 1;
						}
						if (blckStwgCd == "KX5") {
							kx5 = kx5 + 1;
						}
						if (blckStwgCd == "LAX") {
							lax = lax + 1;
						}
						if (blckStwgCd == "LB1") {
							lb1 = lb1 + 1;
						}
						if (blckStwgCd == "LB2") {
							lb2 = lb2 + 1;
						}
						if (blckStwgCd == "LB3") {
							lb3 = lb3 + 1;
						}
						if (blckStwgCd == "LB4") {
							lb4 = lb4 + 1;
						}
						if (blckStwgCd == "LBT") {
							lbt = lbt + 1;
						}
						if (blckStwgCd == "LGB") {
							lgb = lgb + 1;
						}
						if (blckStwgCd == "SE1") {
							se1 = se1 + 1;
						}
						if (blckStwgCd == "SEA") {
							sea = sea + 1;
						}
						if (blckStwgCd == "VA1") {
							va1 = va1 + 1;
						}
						if (blckStwgCd == "VAN") {
							van = van + 1;
						}
						if (blckStwgCd == "HOT") {
							hot = hot + 1;
						}
						if (blckStwgCd == "SH1") {
							sh1 = sh1 + 1;
						}
						if (blckStwgCd == "SH2") {
							sh2 = sh2 + 1;
						}
						// 2014.08.11 CHM-201431533 , Hannah Lee
						if (blckStwgCd == "SHA") {
							sha = sha + 1;
						}

//						cntrNo = sheetObjects[0].CellValue(i, "cntr_no");
					}
					skip = false;
					
					if (cntrTpszCd == "D2") {
						wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "D4") {
						wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "D5") {
						wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "D7") {
						wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "D8") {
						wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "D9") {
						wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "DW") {
						wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "DX") {
						wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "R2") {
						wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "R4") {
						wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "R5") {
						wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "R7") {
						wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "R8") {
						wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "R9") {
						wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "F2") {
						wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "F4") {
						wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "F5") {
						wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "O2") {
						wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "O4") {
						wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "O5") {
						wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "O7") {
						wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "S2") {
						wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "S4") {
						wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "T2") {
						wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "T4") {
						wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "A2") {
						wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "A4") {
						wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "A5") {
						wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "P2") {
						wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "P4") {
						wgt = wgt + sheetObjects[0].CellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].CellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].CellValue(i, "meas_qty") * 1;
					}
				}

				/*
				 * 2010년 7월 6일 화요일 (하동일 수석, 이용태 수석, 경종윤)
				 * Type 중 20'에는  숫자 2의 type을  40'에는 숫자 4,5,7, 8, 9 영문 DW, DX type이 들어 갈 수 있도록 요청 드립니다. (김대준과장 요청)
				 */
				total20 = d2 + r2 + f2 + o2 + s2 + t2 + a2 + p2;
				total40 = d4 + d5 + d7 + d8 + d9 + dw + dx + r4 + r5 + f4 + f5 + o4 + o5 + o7 + s4 + t4 + a4 + a5 + p4;
				
				//alert("total20 : " + total20 + "\n" + "total40 : " + total40);
				
				formObj.d2.value = d2;
				formObj.d4.value = d4;
				formObj.d5.value = d5;
				formObj.d7.value = d7;
				formObj.d8.value = d8;
				formObj.d9.value = d9;
				formObj.dw.value = dw;
				formObj.dx.value = dx;
				formObj.r2.value = r2;
				formObj.r4.value = r4;
				formObj.r5.value = r5;
				formObj.f2.value = f2;
				formObj.f4.value = f4;
				formObj.f5.value = f5;
				formObj.o2.value = o2;
				formObj.o4.value = o4;
				formObj.o5.value = o5;
				formObj.o7.value = o7;
				formObj.s2.value = s2;
				formObj.s4.value = s4;
				formObj.t2.value = t2;
				formObj.t4.value = t4;
				formObj.a2.value = a2;
				formObj.a4.value = a4;
				formObj.a5.value = a5;
				formObj.p2.value = p2;
				formObj.p4.value = p4;
				formObj.total20.value = total20;
				formObj.total40.value = total40;
				formObj.totalTpSize.value = totalTpSize;
				formObj.local.value = local;
				formObj.ts.value = ts;
				formObj.empty.value = empty;
				formObj.full.value = full;
				formObj.no_vgm_total.value = no_vgm_total;
				formObj.no_vgm_local.value = no_vgm_local;
				formObj.no_vgm_ts.value = no_vgm_ts;
				formObj.wgt.value = wgt;
				
				
				// alert(wgt2);
				// alert(wgt2/1000);
				formObj.ewgt.value = wgt2;
				// alert(measure);
				formObj.measure.value = measure / 1000;
				// alert(formObj.measure.value);
				formObj.hji.value = hji;
				formObj.kk4.value = kk4;
				formObj.kk6.value = kk6;
				formObj.kx1.value = kx1;
				formObj.kx5.value = kx5;
				formObj.lax.value = lax;
				formObj.lb1.value = lb1;
				formObj.lb2.value = lb2;
				formObj.lb3.value = lb3;
				formObj.lb4.value = lb4;
				formObj.lbt.value = lbt;
				formObj.lgb.value = lgb;
				formObj.se1.value = se1;
				formObj.sea.value = sea;
				formObj.va1.value = va1;
				formObj.van.value = van;
				formObj.hot.value = hot;
				formObj.sh1.value = sh1;
				formObj.sh2.value = sh2;
				formObj.sha.value = sha; // 2014.08.11 CHM-201431533 , Hannah Lee
				
				// alert(formObj.measure.value);
				var rowCnt = sheetObjects[0].RowCount;
				// alert(rowCnt);
				var arrVvd  = formObj.in_vvd_cd.value.split(",")

				if (rowCnt == 0 || arrVvd.length > 1 ) {
					ComBtnDisable("btn_ediDownload");
					ComBtnDisable("btn_cllForEdi");
					ComBtnDisable("btn_edi");
					ComBtnDisable("btn_sort");
					ComBtnDisable("btn_downExcel");
					ComBtnDisable("TAO/ODCY");
					ComBtnDisable("btn_print");
					ComBtnDisable("btn_faxemail");
					if ( arrVvd.length > 1 ){
						ComBtnEnable("btn_downExcel");
					}
					if ( rowCnt == 0 ){
						ComBtnDisable("btn_downExcel");
					}
				} else {
					//alert(formObj.in_list_type_temp(0).checked );
					if (formObj.in_list_type_temp(0).checked) {
						ComBtnEnable("btn_ediDownload");
						ComBtnEnable("btn_cllForEdi");
						ComBtnDisable("btn_edi");
					} else {
						ComBtnDisable("btn_ediDownload");
						ComBtnDisable("btn_cllForEdi");
						ComBtnEnable("btn_edi");
					}
					ComBtnEnable("btn_sort");
					ComBtnEnable("btn_downExcel");
					ComBtnEnable("TAO/ODCY");
					ComBtnEnable("btn_print");
					ComBtnEnable("btn_faxemail");
				}
				sheetObj.CheckAll("del_chk") = 0;

				formObj.wgt.value = ComGetMaskedValue(formObj.wgt.value, 'int');
				formObj.ewgt.value = ComGetMaskedValue(formObj.ewgt.value, 'int');
				formObj.measure.value = ComGetMaskedValue(formObj.measure.value, 'float');
				// formObj.measure.value =
				// ComGetMaskedValue(formObj.measure.value,'float');
				// alert(formObj.measure.value);

				if (formObj.in_list_type_temp(0).checked) {
					sheetObjects[0].CellValue(0, "vvd_cd") = "Former VVD";
					sheetObjects[0].CellValue(0, "slan_cd") = "Former Lane";
				} else {
					sheetObjects[0].CellValue(0, "vvd_cd") = "Next VVD";
					sheetObjects[0].CellValue(0, "slan_cd") = "Next Lane";
				}
			}
		} else {
			//alert("test");
			ComShowMessage(ComResultMessage(arrXml[0]));
		}
		return;
	} else if (sJbStsFlg == "FAIL") {
		// 에러
		clearInterval(intervalId);
		ComOpenWait(false);
		// 에러메시지 보여주고
		ComShowMessage(ComResultMessage(arrXml[0]));
	}
}

/**
 * gubun값에 따른 cll과 cdl 필수입력항목 변경
 * @param gubun gubun
 */
function clickListType(gubun) {
	var formObj = document.form;
	// var rowCnt = sheetObjects[0].RowCount;
	if (gubun == "0") {
		// alert(document.all["pod_cd"].className);
		document.all["pod_cd"].className = "input1";
		document.all["pod_yd_cd"].className = "input1";
		document.all["pol_cd"].className = "input";
		document.all["pol_yd_cd"].className = "input";
		formObj.in_cntr_match_temp.disabled = false;
		// if ( rowCnt > 0 )
		// {
		// ComBtnEnable("btn_cllForEdi");
		// ComBtnDisable("btn_edi");
		// }
	} else {
		document.all["pod_cd"].className = "input";
		document.all["pod_yd_cd"].className = "input";
		document.all["pol_cd"].className = "input1";
		document.all["pol_yd_cd"].className = "input1";
		formObj.in_cntr_match_temp.disabled = true;
		formObj.in_cntr_match_temp.checked = false;
		// if ( rowCnt > 0 )
		// {
		// ComBtnDisable("btn_cllForEdi");
		// ComBtnEnable("btn_edi");
		// }
	}
	
	splitChange();
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 * @param sheetObj Sheet
 * @param formObj form객체
 * @param sAction 작업처리코드
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: // 조회
		// alert(formObj.vvd_cd.value);
		// alert(formObj.vps_eta_start_dt.value);
		var arrVvd  = formObj.in_vvd_cd.value.split(",")
	
		if (formObj.in_list_type_temp(0).checked) {
			if (ComTrim(formObj.in_vvd_cd.value) == "" || ComTrim(formObj.in_vvd_cd.value).length != 9) {
				if(arrVvd.length < 2 ){
					ComShowCodeMessage('BKG00213');
					formObj.in_vvd_cd.focus();
					return false;
				}
			}

			if (formObj.in_pol_cd.value == "" || formObj.in_pol_cd.value.length != 5) {
				ComShowCodeMessage('BKG00213');
				formObj.in_pol_cd.focus();
				return false;
			}
		} else {
			if (ComTrim(formObj.in_vvd_cd.value) == "" || ComTrim(formObj.in_vvd_cd.value).length != 9) {
				if(arrVvd.length < 2 ){
					ComShowCodeMessage('BKG00203');
					formObj.in_vvd_cd.focus();
					return false;
				}
			}

			if (formObj.in_pod_cd.value == "" || formObj.in_pod_cd.value.length != 5) {
				ComShowCodeMessage('BKG00203');
				formObj.in_pod_cd.focus();
				return false;
			}
		}
		return true;
		break;

	case IBSAVE: // 조회
		// alert(formObj.vvd_cd.value);
		// alert(formObj.vps_eta_start_dt.value);
		if (formObj.in_list_type_temp(0).checked) {
			if (formObj.in_vvd_cd.value == "" || formObj.in_vvd_cd.value.length != 9) {
				ComShowCodeMessage('BKG00213');
				formObj.in_vvd_cd.focus();
				return false;
			}

			if (formObj.in_pol_cd.value == "" || formObj.in_pol_cd.value.length != 5) {
				ComShowCodeMessage('BKG00213');
				formObj.in_pol_cd.focus();
				return false;
			}
		} else {
			if (formObj.in_vvd_cd.value == "" || formObj.in_vvd_cd.value.length != 9) {
				ComShowCodeMessage('BKG00203');
				formObj.in_vvd_cd.focus();
				return false;
			}

			if (formObj.in_pod_cd.value == "" || formObj.in_pod_cd.value.length != 5) {
				ComShowCodeMessage('BKG00203');
				formObj.in_pod_cd.focus();
				return false;
			}
		}
		return true;
		break;

	case COMMAND03: // 조회
		// alert(formObj.vvd_cd.value);
		// alert(formObj.vps_eta_start_dt.value);
		if (formObj.in_list_type_temp(0).checked) {
			if (formObj.in_vvd_cd.value == "" || formObj.in_vvd_cd.value.length != 9) {
				ComShowCodeMessage('BKG00213');
				formObj.in_vvd_cd.focus();
				return false;
			}

			if (formObj.in_pol_cd.value == "" || formObj.in_pol_cd.value.length != 5) {
				ComShowCodeMessage('BKG00213');
				formObj.in_pol_cd.focus();
				return false;
			}
		} else {
			if (formObj.in_vvd_cd.value == "" || formObj.in_vvd_cd.value.length != 9) {
				ComShowCodeMessage('BKG00203');
				formObj.in_vvd_cd.focus();
				return false;
			}

			if (formObj.in_pod_cd.value == "" || formObj.in_pod_cd.value.length != 5) {
				ComShowCodeMessage('BKG00203');
				formObj.in_pod_cd.focus();
				return false;
			}
		}
		return true;
		break;

	case COMMAND04: // 조회
		// alert(formObj.vvd_cd.value);
		// alert(formObj.vps_eta_start_dt.value);
		if (formObj.in_list_type_temp(0).checked) {
			if (formObj.in_vvd_cd.value == "" || formObj.in_vvd_cd.value.length != 9) {
				ComShowCodeMessage('BKG00213');
				formObj.in_vvd_cd.focus();
				return false;
			}

			if (formObj.in_pol_cd.value == "" || formObj.in_pol_cd.value.length != 5) {
				ComShowCodeMessage('BKG00213');
				formObj.in_pol_cd.focus();
				return false;
			}
		} else {
			if (formObj.in_vvd_cd.value == "" || formObj.in_vvd_cd.value.length != 9) {
				ComShowCodeMessage('BKG00203');
				formObj.in_vvd_cd.focus();
				return false;
			}

			if (formObj.in_pod_cd.value == "" || formObj.in_pod_cd.value.length != 5) {
				ComShowCodeMessage('BKG00203');
				formObj.in_pod_cd.focus();
				return false;
			}
		}

		var vIsCheck = false;
		for ( var i = 1; i <= sheetObj.RowCount + 1; i++) {
			if (sheetObj.CellValue(i, "del_chk") == 1) {
				vIsCheck = true;
				break;
			}
		}
		if (!vIsCheck) {
			// alert("test");
			ComShowCodeMessage('BKG00249', '');
			return false;
		}
		return true;
		break;

	case COMMAND05: // 조회
		// alert(formObj.vvd_cd.value);
		// alert(formObj.vps_eta_start_dt.value);
		if (formObj.in_list_type_temp(0).checked) {
			if (formObj.in_vvd_cd.value == "" || formObj.in_vvd_cd.value.length != 9) {
				ComShowCodeMessage('BKG00213');
				formObj.in_vvd_cd.focus();
				return false;
			}

			if (formObj.in_pol_cd.value == "" || formObj.in_pol_cd.value.length != 5) {
				ComShowCodeMessage('BKG00213');
				formObj.in_pol_cd.focus();
				return false;
			}
		} else {
			if (formObj.in_vvd_cd.value == "" || formObj.in_vvd_cd.value.length != 9) {
				ComShowCodeMessage('BKG00203');
				formObj.in_vvd_cd.focus();
				return false;
			}

			if (formObj.in_pod_cd.value == "" || formObj.in_pod_cd.value.length != 5) {
				ComShowCodeMessage('BKG00203');
				formObj.in_pod_cd.focus();
				return false;
			}
		}
		return true;
		break;

	case COMMAND06: // 조회
		// alert(formObj.vvd_cd.value);
		// alert(formObj.vps_eta_start_dt.value);
		if (formObj.in_list_type_temp(0).checked) {
			if (formObj.in_vvd_cd.value == "" || formObj.in_vvd_cd.value.length != 9) {
				ComShowCodeMessage('BKG00213');
				formObj.in_vvd_cd.focus();
				return false;
			}

			if (formObj.in_pol_cd.value == "" || formObj.in_pol_cd.value.length != 5) {
				ComShowCodeMessage('BKG00213');
				formObj.in_pol_cd.focus();
				return false;
			}
		} else {
			if (formObj.in_vvd_cd.value == "" || formObj.in_vvd_cd.value.length != 9) {
				ComShowCodeMessage('BKG00203');
				formObj.in_vvd_cd.focus();
				return false;
			}

			if (formObj.in_pod_cd.value == "" || formObj.in_pod_cd.value.length != 5) {
				ComShowCodeMessage('BKG00203');
				formObj.in_pod_cd.focus();
				return false;
			}
		}
		return true;
		break;
	}

	return true;
}

/**
 * 팝업에서 선택한 sroting 조겅으로 재검색
 * @param sortString sortString
 */
function setOrderBy(sortString) {
	// alert(sortString);
	document.form.in_order_by_type.value = sortString;
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/**
 * Sheet에서 클랙했을시 체크박스 처리
 * @param sheetObj Sheet
 * @param row row
 * @param col col
 */
function sheet1_OnClick(sheetObj, row, col) {

	var rowCnt = sheetObj.RowCount;
	var check = sheetObj.CellValue(row, "del_chk");
	var keyCntrNo = sheetObj.CellValue(row, "cntr_no");
	var colSaveName = sheetObj.ColSaveName(col);

	for (i = 1; i <= rowCnt + 2; i++) {

		if (colSaveName == "del_chk") {

			if (check == 0) {

				if (i == row)
					continue;

				if (keyCntrNo == sheetObj.CellValue(i, "cntr_no")) {
					sheetObj.CellValue(i, "del_chk") = 1;
				}

			} else if (check == 1) {

				if (i == row)
					continue;

				if (keyCntrNo == sheetObj.CellValue(i, "cntr_no")) {
					sheetObj.CellValue(i, "del_chk") = 0;
				}

			}
		}

	} // end for(i)

}

/**
 * Sheet에서 bkg_no 더블클릭시 팝업
 * @param sheetObj sheetObj
 * @param row row
 * @param col col
 */
function sheet1_OnDblClick(sheetObj, row, col) {
	var formObj = document.form;
	bkgNo = sheetObj.CellValue(row, "bkg_no");
	var colSaveName = sheetObj.ColSaveName(col);

	if (colSaveName == "bkg_no")
		doActionIBSheet(sheetObj, formObj, COMMAND07);

}

/**
 * 팝업화면에서 입력한 팩스번호와 메일주소 세팅후 전송함수 호출
 * @param faxNo faxNo
 * @param eMail eMail
 */
function sendFaxEmail(faxNo, eMail) {
	var formObj = document.form;
	formObj.fax.value = faxNo;
	formObj.email.value = eMail;
	paramSet(sheetObjects[2], document.form);
}

/**
 * 팩스와 이베일 전송을 위한 파라메터 세팅
 * @param sheetObject sheetObject
 * @param formObj formObj
 */
function paramSet(sheetObject, formObj) {

	var sheetObjectData = sheetObjects[0];
	var rdParam = "";
	var strPath = "";
	var strPdf = "";
	var bkg_no = "";

	var inListType = "";
	if (formObj.in_list_type_temp(0).checked)
		inListType = "L";
	else
		inListType = "D";

	var inOfcCdType = "";
	if (formObj.in_ofc_cd_type_temp(0).checked)
		inOfcCdType = "B";
	else
		inOfcCdType = "S";

	var inPolTs = "";
	if (formObj.in_pol_ts1.checked && formObj.in_pol_ts2.checked || !formObj.in_pol_ts1.checked && !formObj.in_pol_ts2.checked)
		inPolTs = "";
	else if (formObj.in_pol_ts1.checked)
		inPolTs = "L";
	else if (formObj.in_pol_ts2.checked)
		inPolTs = "T";

	var inPodTs = "";
	if (formObj.in_pod_ts1.checked && formObj.in_pod_ts2.checked || !formObj.in_pod_ts1.checked && !formObj.in_pod_ts2.checked)
		inPodTs = "";
	else if (formObj.in_pod_ts1.checked)
		inPodTs = "L";
	else if (formObj.in_pod_ts2.checked)
		inPodTs = "T";

	var inCntrCfmFlg = "";
	if (formObj.in_cntr_cfm_flg1.checked && formObj.in_cntr_cfm_flg2.checked || !formObj.in_cntr_cfm_flg1.checked
			&& !formObj.in_cntr_cfm_flg2.checked)
		inCntrCfmFlg = "";
	else if (formObj.in_cntr_cfm_flg1.checked)
		inCntrCfmFlg = "Y";
	else if (formObj.in_cntr_cfm_flg2.checked)
		inCntrCfmFlg = "N";

	var inCntrMatch = "";
	if (formObj.in_cntr_match_temp.checked)
		inCntrMatch = "N";
	else
		inCntrMatch = "Y";

	var inDcgoFlg = "";
	if (formObj.in_dcgo_flg.checked)
		inDcgoFlg = "Y";
	else
		inDcgoFlg = "";

	var inRcFlg = "";
	if (formObj.in_rc_flg.checked)
		inRcFlg = "Y";
	else
		inRcFlg = "";

	var inAwkCgoFlg = "";
	if (formObj.in_awk_cgo_flg.checked)
		inAwkCgoFlg = "Y";
	else
		inAwkCgoFlg = "";

	var inBbCgoFlg = "";
	if (formObj.in_bb_cgo_flg.checked)
		inBbCgoFlg = "Y";
	else
		inBbCgoFlg = "";

	var inStwgCd = "";
	if (formObj.in_stwg_cd.checked)
		inStwgCd = "Y";
	else
		inStwgCd = "";

	var inHotDeFlg = "";
	if (formObj.in_hot_de_flg.checked)
		inHotDeFlg = "Y";
	else
		inHotDeFlg = "";

	var inRdCgoFlg = "";
	if (formObj.in_rd_cgo_flg.checked)
		inRdCgoFlg = "Y";
	else
		inRdCgoFlg = "";

	var inSocFlg = "";
	if (formObj.in_soc_flg.checked)
		inSocFlg = "Y";
	else
		inSocFlg = "";

	var inPrctFlg = "";
	if (formObj.in_prct_flg.checked)
		inPrctFlg = "Y";
	else
		inPrctFlg = "";

	var inHngrFlg = "";
	if (formObj.in_hngr_flg.checked)
		inHngrFlg = "Y";
	else
		inHngrFlg = "";
	
	var inIncludingType = "";
	if (formObj.in_including_type_temp.checked)
		inIncludingType = "Y";
	else
		inIncludingType = "N";

	var inBkgCgoTpCd = "";

	var tempArray = formObj.in_bkg_cgo_tp_cd.Code.split(",");

	for ( var i = 0; i < tempArray.length; i++) {
		// alert(tempArray[i]);
		inBkgCgoTpCd = inBkgCgoTpCd + "'" + tempArray[i] + "',";
	}
	if (inBkgCgoTpCd == "'',")
		inBkgCgoTpCd = "";

	if (inBkgCgoTpCd.length > 0)
		inBkgCgoTpCd = inBkgCgoTpCd.substr(0, inBkgCgoTpCd.length - 1);

	var inCntrTpszCd = "";
	var tempArray = formObj.in_cntr_tpsz_cd.Code.split(",");
	for ( var i = 0; i < tempArray.length; i++) {
		// alert(tempArray[i]);
		inCntrTpszCd = inCntrTpszCd + "'" + tempArray[i] + "',"
	}
	if (inCntrTpszCd == "'',")
		inCntrTpszCd = "";
	if (inCntrTpszCd.length > 0)
		inCntrTpszCd = inCntrTpszCd.substr(0, inCntrTpszCd.length - 1);

	var inRcvTermCd = "";
	var tempArray = formObj.in_rcv_term_cd.Code.split(",");
	for ( var i = 0; i < tempArray.length; i++) {
		// alert(tempArray[i]);
		inRcvTermCd = inRcvTermCd + "'" + tempArray[i] + "',"
	}
	if (inRcvTermCd == "'',")
		inRcvTermCd = "";
	if (inRcvTermCd.length > 0)
		inRcvTermCd = inRcvTermCd.substr(0, inRcvTermCd.length - 1);

	var inDeTermCd = "";
	var tempArray = formObj.in_de_term_cd.Code.split(",");
	for ( var i = 0; i < tempArray.length; i++) {
		// alert(tempArray[i]);
		inDeTermCd = inDeTermCd + "'" + tempArray[i] + "',"
	}
	if (inDeTermCd == "'',")
		inDeTermCd = "";
	if (inDeTermCd.length > 0)
		inDeTermCd = inDeTermCd.substr(0, inDeTermCd.length - 1);

	var inOrgTrnsSvdModCd = "";
	var tempArray = formObj.in_org_trns_svd_mod_cd.Code.split(",");
	for ( var i = 0; i < tempArray.length; i++) {
		// alert(tempArray[i]);
		inOrgTrnsSvdModCd = inOrgTrnsSvdModCd + "'" + tempArray[i] + "',"
	}
	if (inOrgTrnsSvdModCd == "'',")
		inOrgTrnsSvdModCd = "";
	if (inOrgTrnsSvdModCd.length > 0)
		inOrgTrnsSvdModCd = inOrgTrnsSvdModCd.substr(0, inOrgTrnsSvdModCd.length - 1);

	var inDestTrnsSvcModCd = "";
	var tempArray = formObj.in_dest_trns_svc_mod_cd.Code.split(",");
	for ( var i = 0; i < tempArray.length; i++) {
		// alert(tempArray[i]);
		inDestTrnsSvcModCd = inDestTrnsSvcModCd + "'" + tempArray[i] + "',"
	}
	if (inDestTrnsSvcModCd == "'',")
		inDestTrnsSvcModCd = "";
	if (inDestTrnsSvcModCd.length > 0)
		inDestTrnsSvcModCd = inDestTrnsSvcModCd.substr(0, inDestTrnsSvcModCd.length - 1);

	var rdParam = "/rp [" + inListType + "][" + inOfcCdType + "][" + formObj.in_ofc_cd.value + "][" + formObj.in_bkg_sts_cd.value + "]["
			+ inBkgCgoTpCd + "][" + formObj.in_vvd_cd.value + "][" + formObj.in_pol_cd.value + "][" + inPolTs + "][" + formObj.in_pod_cd.value + "]["
			+ inPodTs + "][" + inCntrTpszCd + "][" + formObj.in_por_cd.value + "][" + formObj.in_del_cd.value + "][" + inRcvTermCd + "]["
			+ inDeTermCd + "][" + inOrgTrnsSvdModCd + "][" + inDestTrnsSvcModCd + "][" + inDcgoFlg + "][" + inRcFlg + "][" + inAwkCgoFlg + "]["
			+ inBbCgoFlg + "][" + inStwgCd + "][" + inHotDeFlg + "][" + inRdCgoFlg + "][" + inSocFlg + "][" + inPrctFlg + "][" + inCntrCfmFlg + "]["
			+ inCntrMatch + "][" + formObj.in_order_by_type.value + "][" + formObj.in_pol_yd_cd.value + "][" + formObj.in_pod_yd_cd.value + "]["
			+ formObj.in_scc_cd.value + "][" + formObj.vvd_nkm.value + "][" + formObj.un_loc_cd.value + "][" + formObj.vps_eta_dt.value + "]["
			+ formObj.vps_etd_dt.value + "][" + formObj.vps_etb_dt.value + "][" + formObj.d2.value + "][" + formObj.d4.value + "]["
			+ formObj.d5.value + "][" + formObj.d7.value + "][" + formObj.d8.value + "][" + formObj.d9.value + "][" + formObj.dw.value + "]["
			+ formObj.dx.value + "][" + formObj.r2.value + "][" + formObj.r4.value + "][" + formObj.r5.value + "][" + formObj.f2.value + "]["
			+ formObj.f4.value + "][" + formObj.f5.value + "][" + formObj.o2.value + "][" + formObj.o4.value + "][" + formObj.s2.value + "]["
			+ formObj.s4.value + "][" + formObj.t2.value + "][" + formObj.t4.value + "][" + formObj.a2.value + "][" + formObj.a4.value + "]["
			+ formObj.p2.value + "][" + formObj.p4.value + "][" + formObj.total20.value + "][" + formObj.total40.value + "][" + formObj.totalTpSize.value
			+ "][" + formObj.full.value + "][" + formObj.empty.value + "][" + formObj.local.value + "][" + formObj.ts.value + "]["
			+ formObj.ewgt.value + "][" + formObj.wgt.value + "][" + formObj.measure.value + "][" + formObj.hji.value + "][" + formObj.kk4.value
			+ "][" + formObj.kk6.value + "][" + formObj.kx1.value + "][" + formObj.kx5.value + "][" + formObj.lax.value + "][" + formObj.lb1.value
			+ "][" + formObj.lb2.value + "][" + formObj.lb3.value + "][" + formObj.lb4.value + "][" + formObj.lbt.value + "][" + formObj.lgb.value
			+ "][" + formObj.se1.value + "][" + formObj.sea.value + "][" + formObj.va1.value + "][" + formObj.van.value + "][" + formObj.hot.value
			+ "][" + inIncludingType + "][" + inHngrFlg + "][" + formObj.o5.value + "][" + formObj.pol_split_no.value + "][" + formObj.pod_split_no.value + "][" + formObj.a5.value + "][" + formObj.o7.value + "]";

//	 alert(rdParam);
	// rdParam = "/rv form_bkgNo[( '" + bkg_no + "') ] form_type[2]
	// form_dataOnly[N] form_manifest[N] form_hiddeData[N] form_mainOnly[N]
	// form_level[(1)] form_remark[] form_Cntr[1] ";
	// rdParam += "form_CorrNo[] form_his_cntr[BKG_CONTAINER]
	// form_his_bkg[BKG_BOOKING] form_his_mkd[BKG_BL_MK_DESC]
	// form_his_xpt[BKG_XPT_IMP_LIC] form_his_bl[BKG_BL_DOC] /rp []
	// /riprnmargin";
	strPath = "ESM_BKG_0783.mrd";
	if (formObj.in_list_type_temp(0).checked)
		strPdf = formObj.in_vvd_cd.value + "(CLL).pdf";
	else
		strPdf = formObj.in_vvd_cd.value + "(CDL).pdf";

	var bkgNo2 = "";
	if (sheetObjectData.RowCount > 0) {
		bkgNo2 = "|";
	}
	var Row1 = sheetObject.DataInsert();

	sheetObject.CellValue2(Row1, "bkg_no") = bkgNo2;
	sheetObject.CellValue2(Row1, "bl_no") = "";
	sheetObject.CellValue2(Row1, "syscd") = "BKG";
	sheetObject.CellValue2(Row1, "tmplmrd") = strPath;
	sheetObject.CellValue2(Row1, "batchflg") = "N";
	sheetObject.CellValue2(Row1, "tmplparam") = rdParam;
	sheetObject.CellValue2(Row1, "rcvinfo") = formObj.fax.value;
	sheetObject.CellValue2(Row1, "tmplmrdpdf") = strPdf; // 변환될 pdf명(RD파일명
	sheetObject.CellValue2(Row1, "history_gubun") = "N"; // 변환될 pdf명(RD파일명
	// ---> pdf파일명)
	sheetObject.CellValue2(Row1, "itr") = "|$$|";

	var Row2 = sheetObject.DataInsert();

	sheetObject.CellValue2(Row2, "bkg_no") = bkgNo2;
	sheetObject.CellValue2(Row2, "bl_no") = "";
	sheetObject.CellValue2(Row2, "syscd") = "BKG";
	sheetObject.CellValue2(Row2, "tmplmrd") = strPath;
	sheetObject.CellValue2(Row2, "batchflg") = "N";
	sheetObject.CellValue2(Row2, "tmplparam") = rdParam;
	sheetObject.CellValue2(Row2, "history_gubun") = "N"; // 변환될 pdf명(RD파일명
//	 alert("ggg -> " + inListType);
//	 alert("Row2 : " + Row2);
	if (formObj.in_list_type_temp(0).checked) {
		sheetObject.CellValue2(Row2, "title") = "SM Line Container Loading List (Vessel : " + formObj.vessel_name.value + ", Loading Port : "
				+ formObj.in_pol_cd.value + ")";
		sheetObject.CellValue2(Row2, "contents") = "Dear Partner,\n\nPlease refer to the attachment for SM Line Container Loading List\n\n- Vessel : "
				+ formObj.vessel_name.value + "\n- Loading Port : " + formObj.in_pol_cd.value + "\n\nSM Line Corporation";
	} else {

		sheetObject.CellValue2(Row2, "title") = "SM Line Container Discharging List (Vessel : " + formObj.vessel_name.value + ", Discharging Port : "
				+ formObj.in_pod_cd.value + ")";
		
		sheetObject.CellValue2(Row2, "contents") = "Dear Partner,\n\nPlease refer to the attachment for SM Line Container Discharging List\n\n- Vessel : "
			+ formObj.vessel_name.value + "\n- Discharging Port : " + formObj.in_pod_cd.value + "\n\nSM Line Corporation";
	}
	//alert("ddd-> " + sheetObject.CellValue(Row2, "contents"));
	
	sheetObject.CellValue2(Row2, "rcveml") = formObj.email.value; // 수신이메일주소
	sheetObject.CellValue2(Row2, "tmplmrdpdf") = strPdf; // 변환될 pdf명(RD파일명
	// ---> pdf파일명)
	sheetObject.CellValue2(Row2, "itr") = "|$$|";

	FaxEmailSend(sheetObject, formObj);
}

/**
 * 팩스와 이베일 전송
 * @param sheetObj sheetObj
 * @param formObject formObject
 */
function FaxEmailSend(sheetObj, formObject) {
	// if(formObject.fax.value == "" && formObject.email.value == ""){

	// alert("팩스번호 또는 이메일을 입력하세요.");
	// }else{

	ComOpenWait(true);

	formObject.f_cmd.value = SEARCH01;
	var sXml = sheetObj.GetSaveXml("ESM_BKG_0221GS.do", FormQueryString(formObject) + "&" + sheetObj.GetSaveString());
	ComOpenWait(false);

	if (sXml.substring(1, 6) == "ERROR") {
		//
		alert(ComResultMessage(sXml).split('<||>').join('\n'));
	} else {
		//
		var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);

		// alert("State : [" + State + "]");

		if (State == "S") {
			ComShowCodeMessage('BKG06082');
		}
	}

	sheetObj.RemoveAll();
	return;
	// }
}

    

	  /**
    * VVD Selection Inquiry Popup Open
    */ 
   function getVvds(){ 	  
    	var param = ""
	    var pWin = ComOpenWindow("/hanjin/ESM_BKG_0753.do" + param,"open0753", "statebar=no,width=920,height=390,left=200,top=0");
   }
   

	  /**
	   * VVD Selection Inquiry Popup Value Import
	   */
function setVvds(vvds){
	  var formObj = document.form;
	  document.form.in_vvd_cd.value = vvds;
}

 function clearVvds(){
	 document.form.in_vvd_cd.value = "";
 }
    
/* 개발자 작업 끝 */