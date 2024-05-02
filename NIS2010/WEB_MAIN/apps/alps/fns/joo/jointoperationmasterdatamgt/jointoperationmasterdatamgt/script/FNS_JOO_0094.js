/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : FNS_JOO_0094.js
*@FileTitle : Add Row Copy POP UP화면
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.13
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.12.13 김영오
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
 * @class FNS_JOO_0094 : FNS_JOO_0094 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function FNS_JOO_0094() {
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

//공통전역변수
var tabObjects = new Array();
var tabCnt = 0;

var sheetObjects = new Array();
var sheetCnt = 0;

var prefix = "sheet1_";
var gRow = "";

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObj = sheetObjects[0];

	/*******************************************************/
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
		case "btn_downexcel":
			sheetObj.SpeedDown2Excel(1);
			break;

		case "btn_close":
			self.close();
			break;
			
		case "btn_copy":
			
			var opener = window.dialogArguments;
			var opnr_sheet1 = opener.document.form.sheet1;
			
			//부모창의 체크된 Row를 복사....팝업창의 Copy Row 수 만큼
			var sRow = opnr_sheet1.FindCheckedRow(prefix+"del_chk").replace("|","");
			for(var i=0 ;i < document.form.copy_row_cnt.value; i++) {
				var row = opnr_sheet1.DataInsert();
				///////////////////////////1
				if (sheetObj.CellValue(1, "sub_all_01") == "1") {
					opnr_sheet1.CellValue2(row, prefix+"jo_ton_teu_qty")   = opnr_sheet1.CellValue(sRow, prefix+"jo_ton_teu_qty");
				}
				if (sheetObj.CellValue(2, "sub_all_01") == "1") {
					opnr_sheet1.CellValue2(row, prefix+"ofc_cd")   = opnr_sheet1.CellValue(sRow, prefix+"ofc_cd");
				}
				if (sheetObj.CellValue(3, "sub_all_01") == "1") {
					opnr_sheet1.CellValue2(row, prefix+"re_divr_cd")   = opnr_sheet1.CellValue(sRow, prefix+"re_divr_cd");
				}
				if (sheetObj.CellValue(4, "sub_all_01") == "1") {
					opnr_sheet1.CellValue2(row, prefix+"trd_cd")   = opnr_sheet1.CellValue(sRow, prefix+"trd_cd");
				}
				if (sheetObj.CellValue(5, "sub_all_01") == "1") {
					opnr_sheet1.CellValue2(row, prefix+"rlane_cd")   = opnr_sheet1.CellValue(sRow, prefix+"rlane_cd");
				}
				if (sheetObj.CellValue(6, "sub_all_01") == "1") {
					opnr_sheet1.CellValue2(row, prefix+"vsl_cd")   = opnr_sheet1.CellValue(sRow, prefix+"vsl_cd");
				}
				if (sheetObj.CellValue(7, "sub_all_01") == "1") {
					opnr_sheet1.CellValue2(row, prefix+"skd_dir_cd")   = opnr_sheet1.CellValue(sRow, prefix+"skd_dir_cd");
				}
				if (sheetObj.CellValue(8, "sub_all_01") == "1") {
					opnr_sheet1.CellValue2(row, prefix+"port_cd")   = opnr_sheet1.CellValue(sRow, prefix+"port_cd");
				}
				if (sheetObj.CellValue(9, "sub_all_01") == "1") {
					opnr_sheet1.CellValue2(row, prefix+"jo_crr_cd")   = opnr_sheet1.CellValue(sRow, prefix+"jo_crr_cd");
				}
				
				///////////////////////////2
				if (sheetObj.CellValue(1, "sub_all_02") == "1") {
					opnr_sheet1.CellValue2(row, prefix+"jo_20ft_sub_teu_qty")   = opnr_sheet1.CellValue(sRow, prefix+"jo_20ft_sub_teu_qty");
				}
				if (sheetObj.CellValue(2, "sub_all_02") == "1") {
					opnr_sheet1.CellValue2(row, prefix+"jo_20ft_ovr_rto")   = opnr_sheet1.CellValue(sRow, prefix+"jo_20ft_ovr_rto");
				}
				if (sheetObj.CellValue(3, "sub_all_02") == "1") {
					opnr_sheet1.CellValue2(row, prefix+"jo_40ft_sub_teu_qty")   = opnr_sheet1.CellValue(sRow, prefix+"jo_40ft_sub_teu_qty");
				}
				if (sheetObj.CellValue(4, "sub_all_02") == "1") {
					opnr_sheet1.CellValue2(row, prefix+"jo_40ft_ovr_rto")   = opnr_sheet1.CellValue(sRow, prefix+"jo_40ft_ovr_rto");
				}
				if (sheetObj.CellValue(5, "sub_all_02") == "1") {
					opnr_sheet1.CellValue2(row, prefix+"jo_45ft_sub_teu_qty")   = opnr_sheet1.CellValue(sRow, prefix+"jo_45ft_sub_teu_qty");
				}
				if (sheetObj.CellValue(6, "sub_all_02") == "1") {
					opnr_sheet1.CellValue2(row, prefix+"jo_45ft_und_rto")   = opnr_sheet1.CellValue(sRow, prefix+"jo_45ft_und_rto");
				}
				if (sheetObj.CellValue(7, "sub_all_02") == "1") {
					opnr_sheet1.CellValue2(row, prefix+"jo_45ft_ovr_rto")   = opnr_sheet1.CellValue(sRow, prefix+"jo_45ft_ovr_rto");
				}
				if (sheetObj.CellValue(8, "sub_all_02") == "1") {
					opnr_sheet1.CellValue2(row, prefix+"jo_rf_ocn_teu_qty")   = opnr_sheet1.CellValue(sRow, prefix+"jo_rf_ocn_teu_qty");
				}
				if (sheetObj.CellValue(9, "sub_all_02") == "1") {
					opnr_sheet1.CellValue2(row, prefix+"jo_rf_inter_teu_qty")   = opnr_sheet1.CellValue(sRow, prefix+"jo_rf_inter_teu_qty");
				}
				
				///////////////////////////3
				if (sheetObj.CellValue(1, "sub_all_03") == "1") {
					opnr_sheet1.CellValue2(row, prefix+"jo_bsa_prc")   = opnr_sheet1.CellValue(sRow, prefix+"jo_bsa_prc");
				}
				if (sheetObj.CellValue(2, "sub_all_03") == "1") {
					opnr_sheet1.CellValue2(row, prefix+"jo_ovr_ocn_prc")   = opnr_sheet1.CellValue(sRow, prefix+"jo_ovr_ocn_prc");
				}
				if (sheetObj.CellValue(3, "sub_all_03") == "1") {
					opnr_sheet1.CellValue2(row, prefix+"jo_ovr_inter_prc")   = opnr_sheet1.CellValue(sRow, prefix+"jo_ovr_inter_prc");
				}
				if (sheetObj.CellValue(4, "sub_all_03") == "1") {
					opnr_sheet1.CellValue2(row, prefix+"jo_ovr_mt_ocn_prc")   = opnr_sheet1.CellValue(sRow, prefix+"jo_ovr_mt_ocn_prc");
				}
				if (sheetObj.CellValue(5, "sub_all_03") == "1") {
					opnr_sheet1.CellValue2(row, prefix+"jo_ovr_mt_inter_prc")   = opnr_sheet1.CellValue(sRow, prefix+"jo_ovr_mt_inter_prc");
				}
				if (sheetObj.CellValue(6, "sub_all_03") == "1") {
					opnr_sheet1.CellValue2(row, prefix+"jo_rf_ocn_prc")   = opnr_sheet1.CellValue(sRow, prefix+"jo_rf_ocn_prc");
				}
				if (sheetObj.CellValue(7, "sub_all_03") == "1") {
					opnr_sheet1.CellValue2(row, prefix+"jo_rf_inter_prc")   = opnr_sheet1.CellValue(sRow, prefix+"jo_rf_inter_prc");
				}
				
				///////////////////////////4
				if (sheetObj.CellValue(1, "sub_all_04") == "1") {
					opnr_sheet1.CellValue2(row, prefix+"jo_inter_ovr_flg")   = opnr_sheet1.CellValue(sRow, prefix+"jo_inter_ovr_flg");
				}
				if (sheetObj.CellValue(2, "sub_all_04") == "1") {
					opnr_sheet1.CellValue2(row, prefix+"jo_rnd_knd_flg")   = opnr_sheet1.CellValue(sRow, prefix+"jo_rnd_knd_flg");
				}
				if (sheetObj.CellValue(3, "sub_all_04") == "1") {
					opnr_sheet1.CellValue2(row, prefix+"jo_rnd_rule_lvl")   = opnr_sheet1.CellValue(sRow, prefix+"jo_rnd_rule_lvl");
				}
				
				opnr_sheet1.CellValue2(row, prefix+"jo_add_bsa_crr_flg") = "N"
				opnr_sheet1.CellValue2(row, prefix+"jo_fsh_flg") = "N"
				opnr_sheet1.CellValue2(row, prefix+"delt_flg") = "N"
				opnr_sheet1.CellValue2(row, prefix+"del_chk") = "1"
				opnr_sheet1.CellValue2(row, prefix+"cre_dt") = ComGetNowInfo("ymd");
				opnr_sheet1.CellValue2(row, prefix+"upd_usr_id") = gUsrId;
				opnr_sheet1.CellValue2(row, prefix+"usr_nm") = gUsrNm;
				opnr_sheet1.CellEditable(row,prefix+"jo_ver_no") = false;
				opnr_sheet1.CellEditable(row,prefix+"jo_bsa_add_teu_qty") = false;
				opnr_sheet1.CellEditable(row,prefix+"jo_ovr_bsa_teu_qty") = false;
				opnr_sheet1.CellEditable(row,prefix+"cre_dt") = false;
				opnr_sheet1.CellEditable(row,prefix+"upd_usr_id") = false;
				opnr_sheet1.CellEditable(row,prefix+"usr_nm") = false;
			}
			self.close();
			break;
			
		case "all_div":
			//그리드 상단 전체 선택/해제
			if (formObj.all_div.checked == true) {
				sheetObj.CellValue2(1, "sub_all_01") = 1;
				sheetObj.CellValue2(1, "sub_all_02") = 1;
				sheetObj.CellValue2(1, "sub_all_03") = 1;
				sheetObj.CellValue2(1, "sub_all_04") = 1;
				sheetObj.CellValue2(2, "sub_all_01") = 1;
				sheetObj.CellValue2(2, "sub_all_02") = 1;
				sheetObj.CellValue2(2, "sub_all_03") = 1;
				sheetObj.CellValue2(2, "sub_all_04") = 1;
				sheetObj.CellValue2(3, "sub_all_01") = 1;
				sheetObj.CellValue2(3, "sub_all_02") = 1;
				sheetObj.CellValue2(3, "sub_all_03") = 1;
				sheetObj.CellValue2(3, "sub_all_04") = 1;			
				sheetObj.CellValue2(4, "sub_all_01") = 1;
				sheetObj.CellValue2(4, "sub_all_02") = 1;
				sheetObj.CellValue2(4, "sub_all_03") = 1;
				sheetObj.CellValue2(5, "sub_all_01") = 1;
				sheetObj.CellValue2(5, "sub_all_02") = 1;
				sheetObj.CellValue2(5, "sub_all_03") = 1;
				sheetObj.CellValue2(6, "sub_all_01") = 1;
				sheetObj.CellValue2(6, "sub_all_02") = 1;
				sheetObj.CellValue2(6, "sub_all_03") = 1;
				sheetObj.CellValue2(7, "sub_all_01") = 1;
				sheetObj.CellValue2(7, "sub_all_02") = 1;
				sheetObj.CellValue2(7, "sub_all_03") = 1;
				sheetObj.CellValue2(8, "sub_all_01") = 1;
				sheetObj.CellValue2(8, "sub_all_02") = 1;
				sheetObj.CellValue2(9, "sub_all_01") = 1;
				sheetObj.CellValue2(9, "sub_all_02") = 1;
			} else {
				sheetObj.CellValue2(1, "sub_all_01") = 0;
				sheetObj.CellValue2(1, "sub_all_02") = 0;
				sheetObj.CellValue2(1, "sub_all_03") = 0;
				sheetObj.CellValue2(1, "sub_all_04") = 0;
				sheetObj.CellValue2(2, "sub_all_01") = 0;
				sheetObj.CellValue2(2, "sub_all_02") = 0;
				sheetObj.CellValue2(2, "sub_all_03") = 0;
				sheetObj.CellValue2(2, "sub_all_04") = 0;
				sheetObj.CellValue2(3, "sub_all_01") = 0;
				sheetObj.CellValue2(3, "sub_all_02") = 0;
				sheetObj.CellValue2(3, "sub_all_03") = 0;
				sheetObj.CellValue2(3, "sub_all_04") = 0;
				sheetObj.CellValue2(4, "sub_all_01") = 0;
				sheetObj.CellValue2(4, "sub_all_02") = 0;
				sheetObj.CellValue2(4, "sub_all_03") = 0;
				sheetObj.CellValue2(5, "sub_all_01") = 0;
				sheetObj.CellValue2(5, "sub_all_02") = 0;
				sheetObj.CellValue2(5, "sub_all_03") = 0;
				sheetObj.CellValue2(6, "sub_all_01") = 0;
				sheetObj.CellValue2(6, "sub_all_02") = 0;
				sheetObj.CellValue2(6, "sub_all_03") = 0;
				sheetObj.CellValue2(7, "sub_all_01") = 0;
				sheetObj.CellValue2(7, "sub_all_02") = 0;
				sheetObj.CellValue2(7, "sub_all_03") = 0;
				sheetObj.CellValue2(8, "sub_all_01") = 0;
				sheetObj.CellValue2(8, "sub_all_02") = 0;
				sheetObj.CellValue2(9, "sub_all_01") = 0;
				sheetObj.CellValue2(9, "sub_all_02") = 0;
			}
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
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
    initControl();
	var sheetObj = sheetObjects[0];
	var row = sheetObj.DataInsert();
	var row2 = sheetObj.DataInsert();
	var row3 = sheetObj.DataInsert();
	var row4 = sheetObj.DataInsert();
	var row5 = sheetObj.DataInsert();
	var row6 = sheetObj.DataInsert();
	var row7 = sheetObj.DataInsert();
	var row8 = sheetObj.DataInsert();
	var row9 = sheetObj.DataInsert();
	
	sheetObj.CellValue2(row, "item_01")     = "Ton/TEU";
	sheetObj.CellValue2(row, "item_02")     = "20'HC(Sub-Allocation)";	
	sheetObj.CellValue2(row, "item_03")     = "BSA Price";	
	sheetObj.CellValue2(row, "item_04")     = "IPC OUS";
	
	sheetObj.CellValue2(row2, "item_01")     = "Office";	
	sheetObj.CellValue2(row2, "item_02")     = "20'HC(Over Ratio)";	
	sheetObj.CellValue2(row2, "item_03")     = "OUS Price(Ocean)";	
	sheetObj.CellValue2(row2, "item_04")     = "Round Kind";
	
	sheetObj.CellValue2(row3, "item_01")     = "Rev/Exp";
	sheetObj.CellValue2(row3, "item_02")     = "40'HC(Sub-Allocation)";
	sheetObj.CellValue2(row3, "item_03")     = "OUS Price(Inter)";
	sheetObj.CellValue2(row3, "item_04")     = "Round Type";
	
	sheetObj.CellValue2(row4, "item_01")     = "Trade";
	sheetObj.CellValue2(row4, "item_02")     = "40'HC(Over Ratio)";
	sheetObj.CellValue2(row4, "item_03")     = "OUS Price(MT-Ocean)";
	//sheetObj.InitCellProperty(row4, "sub_all_04", dtData);
	sheetObj.CellEditable (row4, "sub_all_04") = false;
	
	
	sheetObj.CellValue2(row5, "item_01")     = "Lane";
	sheetObj.CellValue2(row5, "item_02")     = "45'(Sub-Allocation)";
	sheetObj.CellValue2(row5, "item_03")     = "OUS Price(MT-Inter)";
	sheetObj.CellEditable (row5, "sub_all_04") = false;
		
	sheetObj.CellValue2(row6, "item_01")     = "Vessel";
	sheetObj.CellValue2(row6, "item_02")     = "45'(Under Ratio)";
	sheetObj.CellValue2(row6, "item_03")     = "R/F Price(Ocean)"
	sheetObj.CellEditable (row6, "sub_all_04") = false;
		
	sheetObj.CellValue2(row7, "item_01")     = "Direction";
	sheetObj.CellValue2(row7, "item_02")     = "45'(Over Ratio)";	
	sheetObj.CellValue2(row7, "item_03")     = "R/F Price(Inter)";
	sheetObj.CellEditable (row7, "sub_all_04") = false;
		
	sheetObj.CellValue2(row8, "item_01")     = "Port";
	sheetObj.CellValue2(row8, "item_02")     = "RF Alloc(Ocean)";
	sheetObj.CellEditable (row8, "sub_all_03") = false;
	sheetObj.CellEditable (row8, "sub_all_04") = false;
	
	sheetObj.CellValue2(row9, "item_01")     = "Carrier";
	sheetObj.CellValue2(row9, "item_02")     = "RF Alloc(Inter)";
	sheetObj.CellEditable (row9, "sub_all_03") = false;
	sheetObj.CellEditable (row9, "sub_all_04") = false;
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
	var formObj = document.form;
	
    //Axon 이벤트 처리1. 이벤트catch
	axon_event.addListener   ('click',    'obj_click',      formObj);
	
	axon_event.addListenerFormat('beforedeactivate', 'obj_deactivate',  formObj); //- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
	axon_event.addListenerFormat('beforeactivate'  , 'obj_activate'  ,  formObj); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
    axon_event.addListenerFormat('keypress'        , 'obj_keypress'  , 	formObj); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    axon_event.addListenerFormat('keyup'           , 'obj_keyup'     ,  formObj);
    axon_event.addListenerFormat('click'           , 'obj_onclick'   , 	formObj);

	axon_event.addListenerFormat('beforedeactivate', 'obj_blur' , formObj); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
	axon_event.addListenerFormat('beforeactivate',   'obj_focus', formObj);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
    //axon_event.addListenerFormat('keypress'        , 'obj_keypress', formObj);
				
    axon_event.addListener('beforedeactivate', 'ofc_cd_onblur'    , 'ofc_cd');
    axon_event.addListener('keypress', 'ofc_cd_keypress' , 'ofc_cd');
    axon_event.addListener('keyup'   , 'ofc_cd_keyup'    , 'ofc_cd');
	
    axon_event.addListenerForm  ('keydown' , 'ComKeyEnter',  formObj);
    axon_event.addListenerForm  ('keyup'   , 'fnObjKeyUp', formObj );
    axon_event.addListenerForm  ('keypress', 'fnObjKeyPress', formObj );
}


/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;

	switch (sheetNo) {
	case 1: // sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 210;
			// 전체 너비 설정
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

			var HeadTitle  = "|Sub-All|Item|Sub-All|Item|Sub-All|Item|Sub-All|Item";
			var headCount = ComCountHeadTitle(HeadTitle);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, false);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, false, true, false, false, false)
			
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			//데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,		COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT,	POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, 	true, "ibflag" );
			InitDataProperty(0, cnt++, dtCheckBox    , 70, daCenter, 	true, "sub_all_01"       , false, "", dfNone, 0);
			InitDataProperty(0, cnt++, dtData   	 ,130, daLeft, 		true, "item_01"          , false, "", dfNone        	, 0, false, false );
			InitDataProperty(0, cnt++, dtCheckBox    , 70, daCenter, 	true, "sub_all_02"       , false, "", dfNone, 0);
			InitDataProperty(0, cnt++, dtData        ,130, daLeft, 		true, "item_02"          , false, "", dfNone        	, 0, false, false );
			InitDataProperty(0, cnt++, dtCheckBox    , 70, daCenter, 	true, "sub_all_03"       , false, "", dfNone, 0);
			InitDataProperty(0, cnt++, dtData        ,130, daLeft, 		true, "item_03"          , false, "", dfNone        	, 0, false, false );
			InitDataProperty(0, cnt++, dtCheckBox    , 70, daCenter, 	true, "sub_all_04"       , false, "", dfNone, 0);
			InitDataProperty(0, cnt++, dtData   	 ,130, daLeft, 		true, "item_04"          , false, "", dfNone        	, 0, false, false );
			
			// Edit 가능한 셀과 불가능한 셀을 배경색으로 구분여부
            EditableColorDiff = false;
            WaitImageVisible = false;
            CountPosition = 0;

            // 선택된 행의 하이라이트
            SelectHighLight = false;
		}
		break;

	}
}

	//Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
		if (!validateForm(sheetObj, formObj, sAction))
			return;
	
		switch (sAction) {
	
		}
	}
	// Copy Row 숫자만 입력가능
	function obj_keypress(){
		var formObj = document.form;
    	switch(event.srcElement.dataformat){
    		case "engup":
    			switch(event.srcElement.name){
    				case "copy_row_cnt":
	            		ComKeyOnlyNumber(formObj.copy_row_cnt);
    					break;
    			}
    			break;
    	}
    }

/* 개발자 작업  끝 */