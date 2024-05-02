/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_1511.js
 *@FileTitle : ESM_BKG_1511
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.16
 *@LastModifier : 경종윤
 *@LastVersion : 1.0
 * 2009.08.16 경종윤
 * 1.0 Creation
 * ------------------------------------------------------
 * History
 * 2012.11.14 김보배 [CHM-201221354] [BKG] [EU DG신고화면] Net Explosive Weight Data- Interface 보완
 * 2013.09.13 김보배 [CHM-201326759] DG Declare EDI Transmit 기능 수정 요청
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
 * @class ESM_BKG_1511 : ESM_BKG_1511 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_1511() {

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
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var nextSearchIdx = 0; // Filter 검색을 위한 전연변수(next index)

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {

	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];

	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
			case "btn1_Retrieve":
				doActionIBSheet(sheetObject2, formObject, SEARCH02);
				break;
				
			case "btn1_Save":
				doActionIBSheet(sheetObject1, formObject, IBSAVE);
				break;
				
			case "btn1_Append":
				doActionIBSheet(sheetObject1, formObject, MULTI03);
				break;
				
			case "btn1_EDITransmit":
				doActionIBSheet(sheetObject2, formObject, MULTI01);
				break;
				
			case "btn2_RowAdd":
				
				var row = sheetObject2.DataInsert(-1);
				//alert("row : " + row);
		
				sheetObject2.CellEditable(row, "bkg_no") = true;	
				sheetObject2.CellEditable(row, "bl_no") = true;			
				sheetObject2.CellEditable(row, "pol_cd") = true;			
				sheetObject2.CellEditable(row, "pod_cd") = true;			
				sheetObject2.CellEditable(row, "cntr_no") = true;				
				sheetObject2.CellValue2(row, "dg_list_local_yn") = "N" ;
				
				sheetObject2.CellValue2(row, "d_type") = sheetObject1.CellValue(1, "d_type");
				sheetObject2.CellValue2(row, "vvd_cd") = sheetObject1.CellValue(1, "vvd_cd");
				sheetObject2.CellValue2(row, "port_cd") = sheetObject1.CellValue(1, "port_cd"); ;
	
				// 조회 조건 값을 hidden으로 저장해 둔다.
				setSearchCond(sheetObject2, formObject);
				
				break;

			case "btn2_Delete":
				doActionIBSheet(sheetObject2, formObject, COMMAND02);				
				break;
				
				
			case "btn1_DownExcel":
				doActionIBSheet(sheetObject2, formObject, IBDOWNEXCEL);
				// sheetObject2.SpeedDown2Excel(-1);
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
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * 콤보 Object를 comboObjects 배열에 등록
 * 
 * @param combo_obj
 * @return
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}


/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage(dType, ofcCd) {
	var formObj = document.form;

	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}

	// Declaraion Init
	if (dType == "D" || dType == "") {
		formObj.d_type[0].checked = true;
	} else if (dType == "T") {
		formObj.d_type[1].checked = true;
	} else if (dType == "L") {
		formObj.d_type[2].checked = true;
	}
	
	var comboObjMaxLen = comboObjects.length;
	for (i = 0; i < comboObjMaxLen; i++) {
		// IBCombo 초기화
		initCombo(comboObjects[i], i + 1);
	}

	// 버튼 비활성화 셋팅
	ComBtnDisable("btn1_EDITransmit");
	

	// 화면에서 필요한 이벤트
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListenerForm('change', 'obj_change', document.form); // change
	
	
	
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	var sheetId = sheetObj.id;
	var formObj = document.form;

	switch (sheetId) {

	case "sheet1": // 상단 master 정보
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
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// var HeadTitle1 = "| |Harmonized Tariff
			// Code|Description|Category";
			// var HeadTitle1 =
			var HeadTitle1 = "|d_type|vvd_cd|port_cd|eta_d|eta_t|etd_d|etd_t|yd_cd|loc_nm|auto_snd_tp_cd|vsl_cd|vsl_nm|vsl_cnt_cd|lloyd_no|call_sgn_no|rtm_call_no|ssr_no|ack_rslt_id|local_db_yn";
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
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true,	"ibflag");
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "d_type",		false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "vvd_cd",		false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "port_cd",		false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "eta_d",			false, "", dfDateYmd, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "eta_t",			false, "", dfTimeHm, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "etd_d",			false, "", dfDateYmd, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "etd_t",			false, "", dfTimeHm, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, 	 true, "brth_yd_cd",	false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, 	 true, "yd_nm",			false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, 	 true, "auto_snd_tp_cd", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 50, daLeft, 	 true, "vsl_cd",		false, "", dfDateYmd, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, 	 true, "vsl_eng_nm",	false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, 	 true, "vsl_cnt_cd",	false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, 	 true, "lloyd_no",		false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, 	 true, "call_sgn_no",	false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 50, daLeft, 	 true,"rtm_call_no",    false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, 	 true, "svc_rqst_no",	false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, 	 true, "ack_rslt_id",	false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 50, daLeft, 	 true, "vsl_info_local_yn",	false, "", dfNone, 0, true, true);

			InitViewFormat(0, "eta_d", "yyyymmdd");
			InitViewFormat(0, "eta_t", "hhmm");
			InitViewFormat(0, "etd_d", "yyyymmdd");
			InitViewFormat(0, "etd_t", "hhmm");
			


			CountPosition = 0;
			
		}

		break;

	case "sheet2":
		with (sheetObj) {

			// 높이 설정
			style.height = 290;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			// MergeSheet = msAll;
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 15, 100);

			//var HeadTitle1 = "|merge_bl_no||Seq.|B/L No.|POL|POD|Container No.|Cell Position|Class|UN No.|Flash\nPoint|Package\nGroup|Marine\nPollutant|Limited\nquantity|DG\nInquiry|EMS|Net Weight|Gross Weight|Packages|Substance|Hazardous Contents|cntr_cgo_seq";
			var HeadTitle1 = "|Seq.|bkg_no|B/L No.|POL|POD|Container No.|DG\nInquiry" +
					"|Class|Compati\n-bility|UN No.|Flash\nPoint/℃|Package\nGroup|Marine\nPollutant|Limited\nquantity|EMS|Net Weight|Gross Weight" +
					"|Packages|Substance|Hazardous Contents|cntr_cgo_seq|out_imdg_pck_qty1|out_imdg_pck_cd1|in_imdg_pck_qty1|in_imdg_pck_cd1" +
					"|cntr_tpsz_cd|in_pck_desc|out_pck_desc|Send Type|Msg Snd No|First Msg Snd No|Sub Label 1|Sub Label 2|Sub Label 3|Sub Label 4" +
					"|CNTR_CNT|IMDG_UN_NO_SEQ|NET_EXPLO_WGT|dg_list_local_yn|d_type|vvd_cd|port_cd";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 	30, daCenter, 	 true, 	"ibflag");
//			InitDataProperty(0, cnt++, dtHidden, 		90, daCenter, 	 true, 	"merge_bl_no", 	false, "", dfNone, 0, false, false);
			//InitDataProperty(0, cnt++, dtCheckBox, 		40, daCenterTop, true, 	"check");
			InitDataProperty(0, cnt++, dtData, 			30, daCenterTop, true, 	"seq",				false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtHidden,		100, daCenterTop,true, 	"bkg_no",			true,  "", dfNone, 0, false, false, 12);
			InitDataProperty(0, cnt++, dtData, 			100, daCenterTop,true, 	"bl_no",			true, "", dfNone, 0, false, false, 12);
			InitDataProperty(0, cnt++, dtData, 			50, daCenterTop, true, 	"pol_cd",			false, "", dfNone, 0, false, false, 5);
			InitDataProperty(0, cnt++, dtData, 			50, daCenterTop, true, 	"pod_cd",			true, "", dfNone, 0, false, false, 5);
			InitDataProperty(0, cnt++, dtData, 			100,daCenterTop, true,	"cntr_no", 			true, "", dfNone, 0, false, false, 14);
			InitDataProperty(0, cnt++, dtPopup, 		50, daCenter, 	false, 	"dg",				false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 			50, daCenter, 	false,	"imdg_clss_cd", 	false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 			60, daCenter, 	false,	"imdg_comp_grp_cd", false,  "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtPopup, 		70, daCenter, 	false,	"imdg_un_no", 		true, "", dfNone, 0, true, true, 4);
			InitDataProperty(0, cnt++, dtData, 			60, daRight, 	false,	"flsh_pnt_cdo_temp",false, "", dfNullFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtCombo, 		60, daCenter, 	false,	"imdg_pck_grp_cd", 	false, "", dfNone, 0, true, true, 1);
			InitDataProperty(0, cnt++, dtCombo, 		80, daCenter, 	false,	"dcgo_mrn_polut_cd",false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCombo, 		80, daCenter, 	false,	"imdg_lmt_qty_flg", false, "", dfNone, 0, true, true, 1);
			InitDataProperty(0, cnt++, dtData, 			60, daCenter, 	false, 	"ems_no",			false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 			70, daRight, 	false, 	"net_wgt",			false, "", dfFloat, 3, true, true);
			InitDataProperty(0, cnt++, dtData, 			100,daRight, 	false, 	"grs_wgt",			true,  "", dfFloat, 3, true, true);
			InitDataProperty(0, cnt++, dtData, 			200,daLeft, 	false, 	"packages",			false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 			200,daLeft, 	false,	"prp_shp_nm", 		false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 			200,daLeft, 	false, 	"hzd_desc",			false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtHidden, 		0, 	daLeft, 	false,	"cntr_cgo_seq", 	false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtHidden, 		80, daRight, 	false,	"out_imdg_pck_qty1",true,  "", dfNullInteger, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 		80, daCenter, 	false,	"out_imdg_pck_cd1", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 		80, daRight, 	false,	"in_imdg_pck_qty1", false, "", dfNullInteger, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 		80, daCenter, 	false,	"in_imdg_pck_cd1",  false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 		80, daCenter, 	false,	"cntr_tpsz_cd",  	false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 		80, daCenter, 	false,	"in_pck_desc",  	false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 		80, daCenter, 	false,	"out_pck_desc",  	false, "", dfNone, 0, true, true);
			
			InitDataProperty(0, cnt++, dtHidden, 		80, daCenter, 	false,	"send_type",  		false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 		170, daCenter, 	false,	"msg_snd_no",  		false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 		110, daCenter, 	false,	"first_msg_snd_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden,	95, daCenter, 	false,	"imdg_subs_rsk_lbl_cd1", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden,	95, daCenter, 	false,	"imdg_subs_rsk_lbl_cd2", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden,	95, daCenter, 	false,	"imdg_subs_rsk_lbl_cd3", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden,	95, daCenter, 	false,	"imdg_subs_rsk_lbl_cd4", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 	100, daCenter, 	false,	"cntr_cnt", 		false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtHidden, 	100, daCenter, 	false,	"imdg_un_no_seq", 		false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 	100, daCenter, 	false,	"net_explo_wgt", 		false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 	100, daCenter, 	false,	"dg_list_local_yn", 		false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "d_type",		false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "vvd_cd",		false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "port_cd",		false, "", dfNone, 0, true, true);
			
			ShowButtonImage = 1;
			
			WaitImageVisible = false;

			CountPosition = 0;
			
			var cntCd = formObj.cnt_cd.value;
			
			if(cntCd == "GB") {
				InitDataCombo(0, "dcgo_mrn_polut_cd", "N|Y|P|PP", "N|Y|P|PP");
				//InitDataCombo(0, "dcgo_mrn_polut_cd", "Nil|P|PP", " |P|PP");
			} else {
				InitDataCombo(0, "dcgo_mrn_polut_cd", " |Y|N", " |Y|N");
			}
			
			InitDataCombo(0, "imdg_pck_grp_cd", " |Ⅰ|Ⅱ|Ⅲ|N", " |1|2|3|N");
			InitDataCombo(0, "imdg_lmt_qty_flg", " |Y|N", " |Y|N");

			InitDataValid(0, "bl_no", vtEngUpOther, "0123456789");
			InitDataValid(0, "pol_cd", vtEngUpOther, "0123456789");
			InitDataValid(0, "pod_cd", vtEngUpOther, "0123456789");
			InitDataValid(0, "cntr_no", vtEngUpOther, "0123456789");
			InitDataValid(0, "imdg_clss_cd", vtNumericOther, ".");		
			InitDataValid(0, "ems_no", vtEngUpOther, "-, ");
			InitDataValid(0, "packages", vtEngUpOther, "0123456789~!@#$%^&*()-_+={}[]/,.<> ");
			InitDataValid(0, "prp_shp_nm", vtEngUpOther, "0123456789~!@#$%^&*()-_+={}[]/,.<> ");
			InitDataValid(0, "hzd_desc", vtEngUpOther, "0123456789~!@#$%^&*()-_+={}[]/,.<> ");
			
			// 틀고정 설정 (cntr_no)
			FrozenCols = 8;
			
			// 문장이 길경우 ...으로 표시함
			Ellipsis = true;
			
			// 멀티로우 드로우로 선택 설정
			MultiSelection = true;
			
			// Ctrl키를 눌러 다중행을 선택함
			SelectionMode = smSelectionList;
			
			SelectHighLight = false;
			SelectFontBold = true;

			

		}
		break;
	}
}


/**
 * Combo Object 초기화
 * 
 * @param comboObj
 * @param comNo
 * @return
 */
function initCombo(comboObj, comNo) {

	// alert("comboObj ID : " + comboObj.id);

	var i = 0;

	switch (comboObj.id) {
		case "rtm_call_no": {	// Number of Calling (For RTM)
			i = 0;
	
			with (comboObj) {
				InsertItem(i++, "", "0");
				InsertItem(i++, "1", "1");
				InsertItem(i++, "2", "2");
				//InsertItem(i++, "3", "3");
				Code = "0";
			}
			break;
		}
		
	} // end switch

}


/**
 * Sheet관련 프로세스 처리
 * 
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return
 */
function doActionIBSheet(sheetObj, formObj, sAction) {

	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case SEARCH02: // Retrieve 버튼 

		if(!validateForm(sheetObj,formObj,sAction))return;

		formObj.f_cmd.value = SEARCH02;
		
		if (formObj.d_type[0].checked) {
			formObj.search_d_type.value = "D";
		} else if (formObj.d_type[1].checked) {
			formObj.search_d_type.value = "T";
		} else if (formObj.d_type[2].checked) {
			formObj.search_d_type.value = "L";
		}
		
		ComOpenWait(true);
		var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_1511GS.do", FormQueryString(formObj));
		ComOpenWait(false);

		var arrXml = sXml.split("|$$|");

		formObj.cntr_cnt.value = ""; // Total Container 필드 초기화
//		formObj.dg_list_local_yn.value = ComGetEtcData(arrXml[0], "dgListLocalYn");
		
//		var sentStatus = ComGetEtcData(arrXml[0], "ediSentStatus");
		if (ComBkgErrMessage(sheetObj, sXml)) {
			
			sheetObjects[0].LoadSearchXml(arrXml[0]);
			sheetObjects[1].LoadSearchXml(arrXml[1]);
//			if (ComBkgErrMessage(sheetObj, sXml)) {
//			
//			sheetObjects[0].LoadSearchXml(arrXml[0]);
//			sheetObjects[1].LoadSearchXml(arrXml[1]);
//			
//			//alert("dgListLocalYn : " + formObj.dg_list_local_yn.value);
			if (sheetObjects[0].RowCount > 0) {	
				formObj.dg_list_local_yn.value =sheetObjects[0].CellValue(1,"vsl_info_local_yn");
			}
			
			
//			if(formObj.dg_list_local_yn.value == "N") { // Booking쪽 데이타가 조회되면 비활성화 색상으로 변경
//				sheetObjects[1].ColBackColor("dg") = sheetObjects[1].RgbColor(192,192,192);
//			}
			
			
			if (sheetObjects[1].RowCount > 0) {
				// 조회된 컨테이너 Total Count를 setting한다.
				formObj.cntr_cnt.value = sheetObjects[1].CellValue(1,"cntr_cnt");
				
			}
		
		}

		IBS_CopyRowToForm(sheetObjects[0], formObj, 1, "frm_");
		if (sheetObjects[0].RowCount == 1) {

			formObj.frm_eta_d.value = ComGetMaskedValue(
					formObj.frm_eta_d.value, "ymd");
			formObj.frm_eta_t.value = ComGetMaskedValue(
					formObj.frm_eta_t.value, "hm");
			formObj.frm_etd_d.value = ComGetMaskedValue(
					formObj.frm_etd_d.value, "ymd");
			formObj.frm_etd_t.value = ComGetMaskedValue(
					formObj.frm_etd_t.value, "hm");
			
//			setSentStatusFiledColor(sentStatus); // Sent Status 필드 컬러변경
		}

//		formObj.bay_pln_id.value = "";
//		
		if(formObj.dg_list_local_yn.value == "N") { // Booking쪽 데이타가 조회되면  EDI Transmit, EDI  Cancel 버튼 비활성화
			ComBtnDisable("btn1_EDITransmit");

		} else {
			ComBtnEnable("btn1_EDITransmit");
		}

		// 조회 조건 값을 hidden으로 저장해 둔다.
		setSearchCond(sheetObjects[1], formObj);	
		break;


	
case IBSAVE: // 저장
	if(!validateForm(sheetObj,formObj,sAction))return;

	IBS_CopyFormToRow(formObj, sheetObjects[0], 1, "frm_");
	
	var vslInfoLocalYn = sheetObjects[0].CellValue(1, "vsl_info_local_yn");
	var dgListLocalYn = sheetObjects[1].CellValue(1, "dg_list_local_yn");
	var shee2RowSize = sheetObjects[1].RowCount;

	//alert("vslInfoLocalYn : " + vslInfoLocalYn + "\ndgListLocalYn : " + dgListLocalYn);
	
	
	if (vslInfoLocalYn == "N") {
		sheetObjects[0].RowStatus(1) = "I";
	}
	
//	for ( var i = 1; i <= shee2RowSize; i++) {
//		if (sheetObjects[1].CellValue(i, "dg_list_local_yn") == "N") {
//			sheetObjects[1].RowStatus(i) = "I";
//		}else{
//			sheetObjects[1].RowStatus(i) = "R";
//		}
//	} // end for(i)
	//alert(dgListLocalYn);
//	if (dgListLocalYn == "N") {
		
	for ( var i = 1; i <= shee2RowSize; i++) {
		if (sheetObjects[1].CellValue(i, "dg_list_local_yn") == "N") {
			if(sheetObjects[1].RowStatus(i) == "D") continue;
		
			sheetObjects[1].RowStatus(i) = "R";
//			alert('a')
		}
	} // end for(i)
//	}

	formObj.f_cmd.value = MULTI;
	var sParam = "";

	var sParamSheet1 = sheetObjects[0].GetSaveString();

	if (sParamSheet1 != "") {
		sParam += "&" + ComSetPrifix(sParamSheet1, "sheet1_");
	}

	var sParamSheet2 = sheetObjects[1].GetSaveString();

	if (sParamSheet2 != "") {
		sParam += "&" + ComSetPrifix(sParamSheet2, "sheet2_");

	}
	if (sParam == "") {
		ComShowCodeMessage('BKG00260');
		return;
	}

	sParam += "&" + FormQueryString(formObj);

	//alert(ComSetPrifix(sParamSheet2, "sheet2_"));

	
    if(!ComShowCodeConfirm("BKG00350")) {
    	return false;
    }
    
	ComOpenWait(true);
	var sXml = sheetObjects[0].GetSaveXml("ESM_BKG_1511GS.do", sParam);
	ComOpenWait(false);
	
	sheetObjects[0].LoadSaveXml(sXml);
	
	
	
	break;
	
	
case MULTI03: // 저장
	if(!validateForm(sheetObj,formObj,sAction))return;

	IBS_CopyFormToRow(formObj, sheetObjects[0], 1, "frm_");
	
	var vslInfoLocalYn = sheetObjects[0].CellValue(1, "vsl_info_local_yn");
//	var dgListLocalYn = sheetObjects[1].CellValue(1, "dg_list_local_yn");
	var shee2RowSize = sheetObjects[1].RowCount;

	//alert("vslInfoLocalYn : " + vslInfoLocalYn + "\ndgListLocalYn : " + dgListLocalYn);
	
	
	if (vslInfoLocalYn == "N") {
		sheetObjects[0].RowStatus(1) = "I";
	}
	//alert(dgListLocalYn);
	
	for ( var i = 1; i <= shee2RowSize; i++) {
		if (sheetObjects[1].CellValue(i, "dg_list_local_yn") == "N") {
			sheetObjects[1].RowStatus(i) = "I";
		}else{
			sheetObjects[1].RowStatus(i) = "R";
		}
	} // end for(i)
		
	formObj.f_cmd.value = MULTI;
	var sParam = "";

	var sParamSheet1 = sheetObjects[0].GetSaveString();

	if (sParamSheet1 != "") {
		sParam += "&" + ComSetPrifix(sParamSheet1, "sheet1_");
	}

	var sParamSheet2 = sheetObjects[1].GetSaveString();

	if (sParamSheet2 != "") {
		sParam += "&" + ComSetPrifix(sParamSheet2, "sheet2_");

	}
	if (sParam == "") {
		ComShowCodeMessage('BKG00260');
		return;
	}

	sParam += "&" + FormQueryString(formObj);

	//alert(ComSetPrifix(sParamSheet2, "sheet2_"));

	
    if(!ComShowCodeConfirm("BKG00350")) {
    	return false;
    }
    
	ComOpenWait(true);
	var sXml = sheetObjects[0].GetSaveXml("ESM_BKG_1511GS.do", sParam);
	ComOpenWait(false);
	
	sheetObjects[0].LoadSaveXml(sXml);
	
	
	
	break;
	
	
case MULTI01: // Flat File 생성 및 EDI전송
	
	IBS_CopyFormToRow(formObj, sheetObjects[0], 1, "frm_");			
	if(sheetObjects[0].IsDataModified == true || sheetObjects[1].IsDataModified == true) {
		//ComShowMessage("변경된 데이타가 있습니다. 먼저 저장 후 전송해 주세요!");
		ComShowCodeMessage('BKG06098');
		return;
	}

	if(!validateForm(sheetObj,formObj,sAction))return;
	
	if(!ComShowConfirm(ComGetMsg("BKG95003", "Transmit"))) {
    	return false;
    }
	
	var rowCnt = sheetObjects[1].RowCount;
	
	for(var i=1; i<=rowCnt; i++) {
		//sheetObjects[1].CellValue2(i,"ibflag") = "I";
		sheetObjects[1].RowStatus(i) = "I";
//		if(formObj.send_type_check_orgin.checked) {
//			sheetObj.CellValue2(i, "send_type") = "";
//		}
	}
	
//	formObj.send_type_check_orgin.checked = false;
	
	formObj.f_cmd.value = MULTI01;
//	formObj.trans_type.value = "ORIGIN_SEND";
	var sParam = "";

	var sParamSheet = sheetObjects[1].GetSaveString();

	if (sParamSheet != "") {
		sParam += "&" + sParamSheet;
	}

	sParam += "&" + FormQueryString(formObj);


    //alert(sParam);

	ComOpenWait(true);
	var sXml = sheetObjects[1].GetSaveXml("ESM_BKG_1511GS.do", sParam);
	ComOpenWait(false);
	
	sheetObjects[1].LoadSaveXml(sXml);
	
//	formObj.output1.value = sheetObjects[1].EtcData("originalFlatFile");
//	formObj.output2.value = sheetObjects[1].EtcData("updateFlatFile");
//	formObj.output3.value = sheetObjects[1].EtcData("cancelFlatFile");

	doActionIBSheet(sheetObjects[1], formObj, SEARCH02); // 재조회
	
	break;
	
	
case COMMAND02 : // Row Delete
	
	if (!validateForm(sheetObj, formObj, sAction))	return;
	
	var selectRow = sheetObj.SelectRow
	
	if(selectRow == "-1") return;
	
	if(ComShowCodeConfirm('BKG03037')){
		var sRowStr = sheetObj.GetSelectionRows("/");
		var arrSelectionRows = sRowStr.split("/");
		var maxLength = arrSelectionRows.length;
		for (var i=0; i<maxLength; i++) {
			//alert(arrSelectionRows[i] + " 행이 선택되었음");
			sheetObj.RowHidden(arrSelectionRows[i]) = true; // 선택된 행 숨기기
			//sheetObj.cellValue2(arrSelectionRows[i], "ibflag") = "D"; // 선택된 행 삭제 flag를 셋팅
			sheetObj.RowStatus(arrSelectionRows[i]) = "D"; // 선택된 행 삭제 flag를 셋팅
		}
	}
	break;
	
	
	
case IBDOWNEXCEL: // 엑셀
	if(!validateForm(sheetObj,formObj,sAction))return;
	
	ComOpenWait(true);
	sheetObjects[1].SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "check");
	ComOpenWait(false);
	break;

	}
	
	for ( var i = 1; i <= sheetObjects[1].RowCount; i++) {

		if(sheetObjects[1].CellValue(i, "dg_list_local_yn") == "Y") {
			if(sheetObjects[1].CellValue(i, "dg") =='-'){
				sheetObjects[1].CellBackColor(i, "dg") = sheetObjects[1].RgbColor(255, 180, 180);
			}else{
				
				sheetObjects[1].CellBackColor(i, "dg") = sheetObjects[1].RgbColor(255, 255, 0);
			}
		}	else{
			sheetObjects[1].CellBackColor(i, "dg") = sheetObjects[1].RgbColor(192,192,192);

//			sheetObjects[1].CellValue2(i,"dg")= "+";
		}	
	
	
	}
}



/**
 * 저장 후 이벤트
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	var formObj = document.form;
	if (ErrMsg == "") {
		ComShowCodeMessage('BKG00102');
		
		doActionIBSheet(sheetObjects[1], formObj, SEARCH02); // 재조회
		return false;
	} 
}

/**
 * 다중 저장시 PREFIX 붙여주기
 * 
 * @param sStr
 * @param sPrefix
 * @return
 */
function ComSetPrifix(sStr, sPrefix) {
	if (sStr == null || sStr == "" || sPrefix == null || sPrefix == "") {
		return sStr;
	}

	var regexp = RegExp(/&/g);
	sStr = sPrefix + sStr.replace(regexp, "&" + sPrefix);
	return sStr;
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {

	switch (sAction) {
		
		case SEARCH02:
//			if(formObj.port_cd.value == "BEANR") {
//				ComShowCodeMessage('BKG00651', formObj.port_cd.value);
//				return false;
//			}

			// 기본포멧체크
			if(!ComChkObjValid(formObj.d_type) || !ComChkObjValid(formObj.vvd_cd) || !ComChkObjValid(formObj.port_cd)) return false;
			break;
			
			
			
		case MULTI01 :
		case MULTI02 : //Flat File 생성 및 EDI전송(CANCEL 전송 포함) validation
			var currBlNo = "";
			var preBlNo = "";

			var sheet1RowCnt = sheetObjects[1].RowCount;
			
			if(sheet1RowCnt == 0) {
        		//ComShowMessage("전송할 데이타가 없습니다.");
        		ComShowCodeMessage("BKG01096");
        		return false;
			}

//			 조회시 사용된 조회조건 값이 변경된게 있는지 확인한다.
			if(!checkFirstSearchCond()) {
				return false;
			}
			
	        for(var i=1; i <= sheet1RowCnt; i++) {
	        	
	        	currBlNo = sheetObj.CellValue(i, "bl_no");
	        	
				if(sAction == MULTI01) { // EDI Transmit 버튼 클릭시
        			if(sheetObj.CellValue(i, "out_imdg_pck_qty1") == "") {
    	        		ComShowCodeMessage("BKG01101", "[Quter Qty]");
    	        		sheetObj.SelectCell(i, "out_imdg_pck_qty1")   
    					return false;
        			}
        			if(sheetObj.CellValue(i, "out_imdg_pck_cd1") == "") {
    	        		ComShowCodeMessage("BKG01101", "[Outer Code]");
    	        		sheetObj.SelectCell(i, "out_imdg_pck_cd1")   
    					return false;
        			}
        			if(sheetObj.CellValue(i, "ems_no") == "") {
    	        		ComShowCodeMessage("BKG01101", "[EMS]");
    	        		sheetObj.SelectCell(i, "ems_no")   
    					return false;
        			}
        			if(sheetObj.CellValue(i, "net_wgt") == "0") {
    	        		ComShowCodeMessage("BKG01101", "[Net Weight]");
    	        		sheetObj.SelectCell(i, "net_wgt")   
    					return false;
        			}
        			if(sheetObj.CellValue(i, "grs_wgt") == "0") {
    	        		ComShowCodeMessage("BKG01101", "[Cross Weight]");
    	        		sheetObj.SelectCell(i, "grs_wgt")   
    					return false;
        			}
        			if(sheetObj.CellValue(i, "packages") == "") {
    	        		ComShowCodeMessage("BKG01101", "[Packages]");
    	        		sheetObj.SelectCell(i, "packages")   
    					return false;
        			}

        			if(sheetObj.CellValue(i, "imdg_pck_grp_cd") == "") {
    	        		ComShowCodeMessage("BKG01101", "[Package Guoup]");
    	        		sheetObj.SelectCell(i, "imdg_pck_grp_cd")   
    					return false;
        			}
        			if(sheetObj.CellValue(i, "imdg_un_no") == "") {
    	        		ComShowCodeMessage("BKG01101", "[UN No.]");
    	        		sheetObj.SelectCell(i, "imdg_un_no")   
    					return false;
        			}

        		}		        	
	        	
	        	if(currBlNo == preBlNo) continue;
			
				if(sAction == MULTI02 && sheetObj.CellValue(i, "send_type") == "") {
	    			//ComShowMessage("선택한 B/L No.중 최초전송 B/L No.가 있습니다.");
	    			ComShowCodeMessage("BKG06096");
		        	return false;
	    		}
	    		
//	    		if(sAction == MULTI02 && sheetObj.CellValue(i, "send_type") == "C") {
//	    			//ComShowMessage("선택한 B/L No.중 이미 Cancel 전송한 B/L No.가 있습니다.");
//	    			ComShowCodeMessage("BKG06097", sheetObj.CellValue(i, "bl_no"));
//		        	return false;
//	    		}
	    		
//				if(sAction == MULTI01) { // EDI Transmit 버튼 클릭시(중복 컨테이너 skip)
//        			if(sheetObj.CellValue(i, "cntr_no") == "") {
//    	        		ComShowCodeMessage("BKG01101", "[Container No.]");
//    	        		sheetObj.SelectCell(i, "cntr_no")   
//    					return false;
//        			}
//				}	    		
	    		preBlNo = currBlNo;
	        } // end for(i)
			
			break;
		
		case COMMAND02 : // Row Delte 
			if(sheetObj.RowCount == 0) {
        		ComShowCodeMessage('BKG00095');
        		return false;
			}
			break;
						
		case IBDOWNEXCEL:
			if(sheetObj.RowCount == 0) {
        		ComShowCodeMessage('BKG00109');
        		return false;
			}
			
			break;

	} // end switch

	return true;
}

/**
 * 최초 조회조건 변경 check 
 * 
 * @return
 */
function checkFirstSearchCond() {
	var formObj = document.form;
	
	if (formObj.d_type[0].checked) {
		formObj.search_d_type.value = "D";
	} else if (formObj.d_type[1].checked) {
		formObj.search_d_type.value = "T";
	} else if (formObj.d_type[2].checked) {
		formObj.search_d_type.value = "L";
	}

	// 조회시 사용된 조회조건 값이 변경된게 있는지 확인한다.
	if(formObj.hid_d_type.value != formObj.search_d_type.value ||
			formObj.hid_vvd_cd.value != formObj.vvd_cd.value ||
			formObj.hid_port_cd.value!= formObj.port_cd.value ) {
		ComShowCodeMessage("BKG06118", formObj.hid_d_type.value +","+ formObj.hid_vvd_cd.value+","+formObj.hid_port_cd.value, formObj.search_d_type.value+","+formObj.vvd_cd.value+","+formObj.port_cd.value);
		return false;
	} 
	
	return true;
	
}


/**
 * 폼 필드 변경시 이벤트
 * 
 * @return
 */
function obj_change() {
	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	
	if (srcName == "vvd_cd" || srcName == "port_cd") {
		
		var vvdCd  = formObject.vvd_cd.value;
		var portCd = formObject.port_cd.value;
		
		if(srcName == "vvd_cd") { // vvd_cd 변경시 Vessel Code에 값 셋팅(vvd_cd의 1-4자리)
			formObject.frm_vsl_cd.value = srcValue.substr(0, 4);
			
		}
		
		ComOpenWait(true);
		
		// vvd와 port변경시  Bay-Plan Upload Required 정보를 조회한다.
		doActionIBSheet(sheetObjects[0], document.form, SEARCH05); // vvd, port로 로컬 위험물테이블에 저장된 상태인지 조회한다.
		//doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
		
		if(srcName == "vvd_cd" && formObject.frm_vsl_cd.value != "") { //vvd필드 변경시 Vessel Code 값 추출후 Vessel Name을 조회한다.
			doActionIBSheet(sheetObjects[0], document.form, SEARCH03);
		}
		
		ComOpenWait(false);
		
		eval("formObject." + srcName + ".focus()");
		
	} else if(srcName == "frm_vsl_cd") { // Vessel Code 필드 변경이면
		ComOpenWait(true);
		doActionIBSheet(sheetObjects[0], document.form, SEARCH03);
		ComOpenWait(false);

	} else if(srcName == "frm_brth_yd_cd") { // Berth Code 필드 변경이면
		//alert("frm_brth_yd_cd");
		ComOpenWait(true);
		doActionIBSheet(sheetObjects[0], document.form, SEARCH04);
		ComOpenWait(false);

	} else if(srcName == "filter_bl_no" || srcName == "filter_bl_no" ) { // filter_bl_no, filter_cntr_no 변경시
		
		if(sheetObjects[1].RowCount > 0) {
			nextFilterIdx = 0;
			sheetObjects[1].selectRow = 1;
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
	if ( (srcName == "vvd_cd" || srcName == "port_cd") && ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}


/**
 * 팝업버튼 클릭시 이벤트
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet2_OnPopupClick(sheetObj, Row, Col) {
	var formObj = document.form;
	
	with (sheetObj) {
		var sName = ColSaveName(Col);

		var sUrl = "";
		var sParam = "";
		var trnVal = "";
		
		switch (sName) {
			case "dg": // DG Inquiry
			
				if(formObj.dg_list_local_yn.value == "Y") { // 세관쪽 DG 테이블에 데이타가 있을경우만 팝업을 연다.
					
					var dType = "";
					if(formObj.d_type[0].checked) {
						dType = "D";
					} else if(formObj.d_type[1].checked) {
						dType = "T";
					} else if(formObj.d_type[2].checked) {
						dType = "L";
					}
					
					
					sUrl = "ESM_BKG_1512.do?";
					sParam = "callGubun=ESM_BKG_1511" 
						+ "&d_type="+dType
						+ "&vvd_cd="+formObj.vvd_cd.value
						+ "&port_cd="+formObj.port_cd.value
						+ "&bl_no="+sheetObj.CellValue(Row, 'bl_no')
						+ "&bkg_no="+sheetObj.CellValue(Row, 'bkg_no')
						+ "&cntr_no="+sheetObj.CellValue(Row, 'cntr_no')
						+ "&cntr_cgo_seq="+sheetObj.CellValue(Row, 'cntr_cgo_seq')
					    + "&berth_cd="+formObj.frm_brth_yd_cd.value
					    + "&berth_nm="+formObj.frm_yd_nm.value;
					
					//alert(sUrl + sParam);
					rtnVal = ComOpenWindowCenter(sUrl + sParam, "ESM_BKG_1512", 1024, 550, true);
					
					if (rtnVal != "N") {
						doActionIBSheet(sheetObjects[0], formObj, SEARCH02); // 재조회
					}			
					
				} 
				
				else {
					//ComShowMessage("You can open DG Inquiry only after pressing [Save] button");
					ComShowCodeMessage('BKG06100');
				}
				break;
			
			case "imdg_un_no" :
				ComOpenPopup("ESM_BKG_0204.do?imdg_un_no=" + sheetObj.CellValue(Row, 'imdg_un_no') + "&bkg_no=" + sheetObj.CellValue(Row, 'bkg_no'), 920, 450, "setSheet", '1,0,1,1,1,1,1', true, false, Row, Col, 1);
				break;
			
		} // end switch

	} // end with

}


/**
 * un_no 팝업 callback함수
 * @param aryPopupData
 * @param row
 * @param col
 * @param sheetIdx
 * @return
 */
function setSheet(aryPopupData, row, col, sheetIdx) {
	var sheetObj 	= sheetObjects[sheetIdx];
	var formObj 	= document.form;
	var colArray 	= aryPopupData[0];
	var imdgUnNo 	= colArray[2];
	var imdgUnNoSeq = colArray[3];
	var imdgClssCd 	= colArray[4]; 
	var imdgCompGrpCd = colArray[5];
	var imdgPckGrpCd = colArray[6];
	var prpShpNm 	= colArray[7];
	var emsNo = colArray[16];
	
//	alert(row + "/"+ col + "/"+ sheetIdx);
//	alert(imdgUnNo + "/" + imdgUnNoSeq);
	
	sheetObj.CellValue2(row, "imdg_un_no") = imdgUnNo;
	sheetObj.CellValue2(row, "imdg_un_no_seq") = imdgUnNoSeq;
	sheetObj.CellValue2(row, "imdg_clss_cd") = imdgClssCd;
	sheetObj.CellValue2(row, "imdg_comp_grp_cd") = imdgCompGrpCd;
	
	sheetObj.CellValue2(row, "ems_no") = emsNo;
	sheetObj.CellValue2(row, "imdg_pck_grp_cd") = imdgPckGrpCd;

}


/**
 * 조회 조건 값을 hidden으로 저장해 둔다.
 * (save버튼 클릭시 조회조건이 변경 되는것을 막기위해 사용)
 * @param sheetObj
 * @param formObj
 * @return
 */
function setSearchCond(sheetObj, formObj) {
	if(sheetObj.RowCount > 0) {
		formObj.hid_d_type.value = formObj.search_d_type.value;
		formObj.hid_vvd_cd.value = formObj.vvd_cd.value;
		formObj.hid_port_cd.value = formObj.port_cd.value;
	}
}
