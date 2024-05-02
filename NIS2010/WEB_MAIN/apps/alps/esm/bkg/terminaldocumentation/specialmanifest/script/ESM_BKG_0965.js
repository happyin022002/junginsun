/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0965.js
 *@FileTitle : ESM_BKG_0965
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.28
 *@LastModifier : 경종윤
 *@LastVersion : 1.0
 * 2009.07.28 경종윤
 * 1.0 Creation
 * ------------------------------------------------------
 * HISTORY 
 * 2011.04.06 이수진 [CHM-201109635] (ANRBS) DG Declare EDI Transmit 로직 보완 작업
 * => 전송된 케이스에는 색상으로 표시되도록 수정
 * 2012.03.14 김경섭 [CHM-201216605] ANCS Main Menu 관련 ESM_BKG_0044,0494,0965,0970 화면의 POD조회 추가. 
 * 2012.11.14 김보배 [CHM-201221354] [BKG] [EU DG신고화면] Net Explosive Weight Data- Interface 보완
 * 2013.03.13 김보배 [CHM-201323641] [BKG] [ANRBS] DG-DECLARE: system problem (Data Append)
 * 2013.04.11 김보배 [CHM-201323920] [BKG] ANRBS DG Declare 화면상 데이터 오토변경 기능 제거 요청
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
 * @class ESM_BKG_0965 : ESM_BKG_0965 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0965() {

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
		case "btn2_RowAdd":

			var row = sheetObject2.DataInsert(-1);
			//alert("row : " + row);

			sheetObject2.CellEditable(row, "bl_no") = true;
			sheetObject2.CellEditable(row, "pol_cd") = true;
			sheetObject2.CellEditable(row, "pod_cd") = true;
			sheetObject2.CellEditable(row, "cntr_no") = true;

			// 조회 조건 값을 hidden으로 저장해 둔다.
			setSearchCond(sheetObject2, formObject);
			
			break;

		case "btn2_Delete":
			doActionIBSheet(sheetObject2, formObject, COMMAND02);
			break;

		case "btn1_BayPlan":	// Bay-Plan 팝업 버튼
			formObject.currMainPageListCnt.value = sheetObject2.RowCount;
			var retObj = openBayPlanPop(formObject, "2", true, "ESM_BKG_0965");
			
			if(retObj != undefined && retObj.length > 0 && sheetObject2.RowCount > 0) {
				// Cell Position setting
				setCellPnsNoByCntrNo(sheetObject2,retObj);
			}
			
			break;
			
		case "btn1_Retrieve":
			var visibleFlag = formObject.bay_plan_upload_check.disabled;
			var checkFlag = formObject.bay_plan_upload_check.checked;
			var bayPlnId = "";

			// Bay-Plan Upload Required -> 체크시 Bay_Plan Popup을 Open한다.
			if (!visibleFlag && checkFlag) {
				//alert("팝업 열자~");

				var rtnVal = openBayPlanPop(formObject, "1", true, "ESM_BKG_0965");				

				if (rtnVal != null) {
					formObject.bay_pln_id.value = rtnVal.cd;
				} else {
					formObject.bay_pln_id.value = "";
					break;
				}

			}

			doActionIBSheet(sheetObject1, formObject, SEARCH02);
			
			sheetObjects[1].SelectRow = sheetObjects[1].HeaderRows ;

			
			break;
			
		case "btn1_Append_Retrieve":  // booking쪽 데이타를 조회해서 그리드에 append한다.
			doActionIBSheet(sheetObject1, formObject, SEARCH14);
			break;

		case "btn1_New":
			
			pageReset(formObject);
			formObject.port_cd.Index2=0;
			// Declaration init
			initDeclarationType(formObject.init_d_type.value);
			
			break;

		case "btn1_Save":
			doActionIBSheet(sheetObject1, formObject, IBSAVE);
			break;

		case "btn1_EDITransmit":
			doActionIBSheet(sheetObject2, formObject, MULTI01);
			
			break;

		case "btn1_EDICancel":
			doActionIBSheet(sheetObject2, formObject, MULTI02);
			break;

		case "btn1_SentResult":
			openDetail(sheetObject2, sheetObject2.SelectRow);
			break;

		case "btn1_DownExcel":
			doActionIBSheet(sheetObject2, formObject, IBDOWNEXCEL);
			// sheetObject2.SpeedDown2Excel(-1);
			break;

		case "btn1_Filter" :	// BL_NO, CNTR_NO FILTER
			doActionIBSheet(sheetObject2, formObject, COMMAND01);
			break;
		
			
		case "d_type1": // Declration 선택시(Discharging)
		case "d_type2": // Declration 선택시(Trasit)
		case "d_type3": // Declration 선택시(Loading)
		case "d_type4": // Declration 선택시(Pre-Carriage)
		case "d_type5": // Declration 선택시(On-Carriage)
			
			var dTypeVal = declarationCheckValue();  // 선택된 체크박스 값 구하기
			
			dTypeCheckValidate(dTypeVal, srcName);	// 체크 벨리데이션
			
			if(formObject.d_type.value != "" && formObject.vvd_cd.value != "" && formObject.port_cd.Code != "") {
				doActionIBSheet(sheetObject1, formObject, SEARCH06); // DG List Copy 체크박스 활성화/비활성화 판단
				doActionIBSheet(sheetObjects[0], document.form, SEARCH01); //Bay-Plan Upload Required 체크박스 활성화/비활성화 판다.
			}
			
			// barge CheckBox 활성화/비활성화 
			if(formObject.d_type.value != "P" && formObject.d_type.value != "O") {
				formObject.barge_check.disabled = true;
				formObject.barge_check.checked = false;
				formObject.barge_flag.value = "N";
			} else {
				formObject.barge_check.disabled = false;
			}
			
			break;
		case "filter_bl_no" : 
			visibleFalse("1");
			break;
		case "filter_cntr_no" : 
			visibleFalse("2");
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
 * 컨테이별 Cell Position을 Bay-Plan Detail Popup에서 전달 받은 
 * 값으로 셋팅한다.
 * @param sheetObj
 * @param arrObj
 * @return
 */
function setCellPnsNoByCntrNo(sheetObj, arrObj) {
	var mainCntrNo = "";
	var sheetLength = sheetObj.RowCount;
	var arrObjLength = arrObj.length;
	var arrSubObj = null;
	var changeCnt = 0;

	ComOpenWait(true);
	for(var i = 1; i <= sheetLength; i++) {
		mainCntrNo = sheetObj.CellValue(i, "cntr_no");
		
		for(var j = 0; j < arrObjLength; j++) {
			arrSubObj = arrObj[j].split("|");
			
			if(mainCntrNo == arrSubObj[0]) {
				sheetObj.CellValue2(i, "cell_psn_no") = arrSubObj[1];
				sheetObj.CellBackColor(i, "cell_psn_no") = sheetObj.RgbColor(0x87,0xce,0xeb);
				changeCnt++;
			} else {
				continue;
			}
		} // end for(j)
		
	} // end for(i)
	ComOpenWait(false);
	
	ComShowMessage("[" + changeCnt + "] Changed");
}

/**
 * 페이지 초기화
 * @param formObject
 * @return
 */
function pageReset(formObject) {
	ComResetAll();
	formObject.ack_rcv_sts_cd_name.style.backgroundColor = "white";
}

/**
 * 필터조건 visible
 * @param searchType ("1" : B/L No. 활성화, "2" : Container No. 활성화)
 * @return
 */
function visibleFalse(searchType) {
	
	var formObject = document.form;
	
	if(searchType == "1") {
		
		formObject.filter_cntr_no.readOnly = true;
		formObject.filter_cntr_no.value = "";
		formObject.filter_bl_no.readOnly = false;
		
	} else {
		
		formObject.filter_bl_no.readOnly = true;
		formObject.filter_bl_no.value = "";
		formObject.filter_cntr_no.readOnly = false;
		
	}
}

/**
 * declaration 필드 선택값 리턴
 * 
 * @return
 */
function declarationCheckValue() {
	
	var formObj = document.form;
	var retVal = "";

	for ( var i = 1; i <= 5; i++) {
		var dTypeFlag = "formObj.d_type" + i + ".checked";
		var dTypeValue = "formObj.d_type" + i + ".value";
		
		if (eval(dTypeFlag)) {
			retVal += eval(dTypeValue);
		}
	} // end for(i)

	return retVal;
}

/**
 * Agent or Agent Forwarder 콤보 셋팅
 * 
 * @return
 */
function settingAgent(dTypeVal) {
	var formObj = document.form;
	
	//alert(dTypeVal);
	
	switch (dTypeVal) {	// Agent or	Agent Forwarder 콤보 셋팅
	
		case "LP": // Loading + On-carriage
		case "P": // Pre-carriage
		case "O": // On-Carriage
			formObj.anr_role_div_cd.Code = "DF"; // Forward
			break;
		case "DO": // Discharging + Pre-carriage
			formObj.anr_role_div_cd.Code = "BO"; // Forward
			break;
		default:
			formObj.anr_role_div_cd.Code = "DA"; // Agent
			break;
	} // end switch
}

/**
 * Declaration 체크 Validation
 * @return
 */
function dTypeCheckValidate(dTypeVal, srcName) {
	
	var formObj = document.form;
	
	//alert("srcName : " + srcName + "\ndTypeVal : " + dTypeVal);
	
	switch (srcName) {
	
		case "d_type1" :	// Discharging 
			switch (dTypeVal) {
				case "DT" :
				case "DL" :
				case "DP" :
				case "DLP" :
					formObj.d_type1.checked = false;
			
			}
			break;
		case "d_type2" : 	// Transit
			switch (dTypeVal) {
				case "DT" :
				case "TL" :
				case "TP" :
				case "TO" :
				case "TLP" :
				case "DTO" :
					formObj.d_type2.checked = false;
			}
			break;
		case "d_type3" : 	// Loading
			switch (dTypeVal) {
				case "DL" :
				case "TL" :
				case "LO" :
				case "DLO" :
					formObj.d_type3.checked = false;
			}
			break;
		case "d_type4" : 	// Pre-Carriage
			switch (dTypeVal) {
				case "DP" :
				case "TP" :
				case "PO" :
				case "DPO" :
					formObj.d_type4.checked = false;
			}
			break;
		case "d_type5" : 	// On-Carriage
			switch (dTypeVal) {
				case "TO" :
				case "LO" :
				case "PO" :
				case "LPO" :
					formObj.d_type5.checked = false;
			}
			break;
		default : 
			formObj.d_type1.checked = false;
			break;
			
	} // end switch
	
	var newType = declarationCheckValue();
	formObj.d_type.value = (newType == "LP") ? "PL" : newType;
	
	var viewText = new Array();
	
	viewText[0] = "Vessel Name"; 
	viewText[1] = "Barge Name"; 
	
	if(formObj.d_type.value == "P" || formObj.d_type.value == "O") {
		layoutView.innerHTML = viewText[1];
	} else {
		layoutView.innerHTML = viewText[0];
	}
	
	setCrrDtHeader(formObj.d_type.value);
	
	settingAgent(newType);
	
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
function loadPage(dType) {
	var formObj = document.form;

	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	// doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

	// Declaraion Init
	initDeclarationType(dType);

	
	var comboObjMaxLen = comboObjects.length;
	for (i = 0; i < comboObjMaxLen; i++) {
		// IBCombo 초기화
		initCombo(comboObjects[i], i + 1);
	}

	// Agent or Agent Forwader 콤보 셋팅
	settingAgent();
	
	// 초기 비활성화 버튼 셋팅
	ComBtnDisable("btn1_EDITransmit");
	ComBtnDisable("btn1_EDICancel");
	ComBtnDisable("btn1_Append_Retrieve");
	
	// 화면에서 필요한 이벤트
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');

	axon_event.addListenerForm('change', 'obj_change', document.form); // change
	axon_event.addListenerForm('click', 'obj_click', document.form); // click
	
	doActionIBSheet(sheetObjects[0], formObj, COMMAND11);
	
}

/**
 *  Declaration 필드를 초기화 셋팅한다.<br>
 * @return
 */
function initDeclarationType(dType) {
	
	var formObj = document.form;
	
	if (dType == "D") {
		formObj.d_type1.checked = true;
		formObj.d_type.value = "D"; 
	} else if (dType == "T") {
		formObj.d_type2.checked = true;
		formObj.d_type.value = "T"; 
	} else if (dType == "L") {
		formObj.d_type3.checked = true;
		formObj.d_type.value = "L"; 
	} else if (dType == "P") {
		formObj.d_type4.checked = true;
		formObj.d_type.value = "P"; 
	} else if (dType == "O") {
		formObj.d_type5.checked = true;
		formObj.d_type.value = "O"; 
	} else {
		formObj.d_type1.checked = true;
		formObj.d_type.value = "D"; 
	}

	setCrrDtHeader(formObj.d_type.value);
}

/**
 * sheet header(Carriage Date) 타이틀 변경
 * @param dType
 */
function setCrrDtHeader(dType) {
	if(dType == "PL" || dType == "P") {
		sheetObjects[1].CellValue2(0, "crr_dt") = "Pre-Carriage Date";
	} else {
		sheetObjects[1].CellValue2(0, "crr_dt") = "On-Carriage Date";
	}
}


/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	var sheetId = sheetObj.id;

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
			// "|d_type|vvd_cd|port_cd|eta_d|eta_t|etd_d|etd_t|yd_cd|loc_nm|vsl_cd|vsl_nm|vsl_cnt_cd|lloyd_no|call_sgn_no|anr_role_div_cd|ssr_no|ack_rslt_id";
			var HeadTitle1 = "|d_type|vvd_cd|port_cd|eta_d|eta_t|etd_d|etd_t|yd_cd|loc_nm|auto_snd_tp_cd|vsl_cd|vsl_nm|vsl_cnt_cd|lloyd_no|call_sgn_no" +
					"|anr_role_div_cd|ssr_no|ack_rslt_id|local_db_yn";
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
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "d_type",		false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "vvd_cd",		false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "port_cd",		false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "eta_d",			false, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "eta_t",			false, "", dfTimeHm, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "etd_d",			false, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "etd_t",			false, "", dfTimeHm, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, 	 true, "brth_yd_cd",	false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, 	 true, "yd_nm",			false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, 	 true, "auto_snd_tp_cd", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 50, daLeft, 	 true, "vsl_cd",		false, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, 	 true, "vsl_eng_nm",	false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, 	 true, "vsl_cnt_cd",	false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, 	 true, "lloyd_no",		false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, 	 true, "call_sgn_no",	false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 50, daLeft, 	 true,"anr_role_div_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, 	 true, "svc_rqst_no",	false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, 	 true, "ack_rcv_sts_cd",	false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 50, daLeft, 	 true, "local_db_yn",	false, "", dfNone, 0, false, false);

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
			//style.height = 150;
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

			var HeadTitle1 = "merge_bl_no|Sel.|Seq.|bkg_no|B/L No.|POL|POD|Container No.|DG\nInquiry|Cell Position|Class|Compati\n-bility|UN No.|S.D/G|Flash\nPoint|Package\nGroup|Forwarder\nCode|Carriage\nType|On-Carriage Date|SSR\n(Feeder)|Vessel Name\n(Feeder)|Lloy No\n(Feeder)|VVD\n(Feeder)"
							+"|Outer\nQty|Outer\nCode|EMS|Net Weight|Gross Weight|Net Explosive WGT|Packages|Substance|Hazardous Contents|cntr_cgo_seq|in_imdg_pck_qty1|in_imdg_pck_cd1|cntr_tpsz_cd|in_pck_desc|out_pck_desc|Send Type|Send Type\nto Original"
							+"|Msg Snd No|First Msg Snd No|Sub Label 1|Sub Label 2|Sub Label 3|Sub Label 4|Scr File No|group_cnt|DG_SHORT_NM_CNT|CNTR_CNT|IMDG_UN_NO_SEQ"
							+"|dtHiddenStatus"; // ibflag 는 항상 마지막 줄에 오도록 유지 - merge 깨짐 방지
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
			InitDataProperty(0, cnt++, dtHidden, 		90, daCenter, 	 true, 	"merge_bl_no", 	false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtDummyCheck, 	40, daCenterTop, true, 	"check");
			InitDataProperty(0, cnt++, dtData, 			30, daCenterTop, true, 	"seq",				false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtHidden,		100,daCenterTop, true, 	"bkg_no",			true,  "", dfNone, 0, false, false, 12);
			
			InitDataProperty(0, cnt++, dtData, 			100,daCenterTop, true, 	"bl_no",			true,  "", dfNone, 0, false, false, 12);
			InitDataProperty(0, cnt++, dtData, 			50, daCenterTop, true, 	"pol_cd",			false, "", dfNone, 0, false, false, 5);
			InitDataProperty(0, cnt++, dtData, 			50, daCenterTop, true, 	"pod_cd",			true,  "", dfNone, 0, false, false, 5);
			InitDataProperty(0, cnt++, dtData, 			100,daCenterTop, true,	"cntr_no", 			true,  "", dfNone, 0, false, false, 14);
			InitDataProperty(0, cnt++, dtPopup, 		50, daCenter, 	false,	"dg",				false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 			80, daCenterTop, true,	"cell_psn_no",		false, "", dfNone, 0, true, true, 7);
			InitDataProperty(0, cnt++, dtData, 			50, daCenter, 	false,	"imdg_clss_cd", 	false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 			60, daCenter, 	false,	"imdg_comp_grp_cd", false,  "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtPopup, 		70, daCenter, 	false,	"imdg_un_no", 		true,  "", dfNone, 0, true, true, 4);
			InitDataProperty(0, cnt++, dtCombo, 		60, daCenter, 	false,	"dg_short_nm", 		false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 			50, daRight, 	false,	"flsh_pnt_cdo_temp",false, "", dfNullFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtCombo, 		60, daCenter, 	false,	"imdg_pck_grp_cd", 	false, "", dfNone, 0, true, true, 1);
			//InitDataProperty(0, cnt++, dtCombo, 		60, daCenter, 	false, 	"agent",			false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtPopup,			80, daCenter, 	false, 	"fwrd_id",			false, "", dfNone, 0, true, true, 6);
			InitDataProperty(0, cnt++, dtCombo, 		60, daCenter, 	false, 	"c_type",			false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 		   120, daCenter, 	true, 	"crr_dt", 			false, "", dfDateYmd, 0, true, true);			

			InitDataProperty(0, cnt++, dtData, 			120, daRight, 	false,	"fdr_svc_rqst_no", 	false, "", dfNone, 0, true, true, 14);
//			InitDataProperty(0, cnt++, dtComboEdit, 	100, daCenter, 	false,	"fdr_vsl_nm", 		false, "", dfNone, 0, true, true);
//			InitDataProperty(0, cnt++, dtComboEdit, 	100, daCenter, 	false,	"fdr_vsl_lloyd_no", false, "", dfNone, 0, true, true, 7);
			InitDataProperty(0, cnt++, dtPopupEdit,		100, daCenter, 	false,	"fdr_vsl_nm", 		false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtPopupEdit,		100, daCenter, 	false,	"fdr_vsl_lloyd_no", false, "", dfNone, 0, true, true, 7);
			InitDataProperty(0, cnt++, dtData, 			100, daCenter, 	false,	"fdr_vvd_id", 		false, "", dfNone, 0, true, true, 9);
			
			InitDataProperty(0, cnt++, dtData, 			80, daRight, 	false,	"out_imdg_pck_qty1",true,  "", dfNullInteger, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 			80, daCenter, 	false,	"out_imdg_pck_cd1", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 			60, daCenter, 	false, 	"ems_no",			false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 			70, daRight, 	false, 	"net_wgt",			false, "", dfFloat, 3, true, true);
			InitDataProperty(0, cnt++, dtData, 			100, daRight, 	false, 	"grs_wgt",			true,  "", dfFloat, 3, true, true);
			InitDataProperty(0, cnt++, dtData, 			130, daRight, 	false, 	"net_explo_wgt",		true,  "", dfFloat, 3, true, true);
			InitDataProperty(0, cnt++, dtData, 			200,daLeft, 	false, 	"packages",			false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 			200,daLeft, 	false,	"prp_shp_nm", 		false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 			0,  daLeft, 	false, 	"hzd_desc",			false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtHidden, 		0, 	daLeft, 	false,	"cntr_cgo_seq", 	false, "", dfNone, 0, true, true);
			
			InitDataProperty(0, cnt++, dtHidden, 		80, daRight, 	false,	"in_imdg_pck_qty1", false, "", dfNullInteger, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 		80, daCenter, 	false,	"in_imdg_pck_cd1",  false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 		80, daCenter, 	false,	"cntr_tpsz_cd",  	false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 		80, daCenter, 	false,	"in_pck_desc",  	false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 		80, daCenter, 	false,	"out_pck_desc",  	false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 			80, daCenter, 	false,	"send_type",  		false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtDummyCheck,	80, daCenterTop, true, 	"send_type_check_orgin");
			InitDataProperty(0, cnt++, dtData, 			110, daCenter, 	false,	"msg_snd_no",  		false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 			110, daCenter, 	false,	"first_msg_snd_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 		95, daCenter, 	false,	"imdg_subs_rsk_lbl_cd1", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 		95, daCenter, 	false,	"imdg_subs_rsk_lbl_cd2", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 		95, daCenter, 	false,	"imdg_subs_rsk_lbl_cd3", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 		95, daCenter, 	false,	"imdg_subs_rsk_lbl_cd4", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 		110, daCenter, 	false,	"scr_file_no", 		false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 		110, daCenter, 	false,	"group_cnt", 		false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtHidden, 		100, daCenter, 	false,	"dg_short_nm_cnt", 	false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 		100, daCenter, 	false,	"cntr_cnt", 		false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtHidden, 		100, daCenter, 	false,	"imdg_un_no_seq", 		false, "", dfNone, 0, false, false);
//			InitDataProperty(0, cnt++, dtHidden, 		100, daCenter, 	false,	"net_explo_wgt", 		false, "", dfNone, 0, false, false);
			
			// ibflag 는 항상 마지막 줄 유지 - merge 깨짐 방지
			InitDataProperty(0, cnt++, dtHiddenStatus, 	30, daCenter, 	 true, 	"ibflag");
			
 
			//InitDataCombo(0, "agent", " |A|F|AF|", " |A|F|B");
			InitDataCombo(0, "c_type", " |TBN|ROAD|RAIL|BARGE|MARINTIME"," |X|T|R|B|V");
			InitDataCombo(0, "dg_short_nm", " |AMN|SPR|ZTG"," |AMN|SPR|ZTG");
			
			InitDataCombo(0, "imdg_pck_grp_cd", " |I|II|III|N", " |1|2|3|N");

			ShowButtonImage = 1;
			
			WaitImageVisible = false;
			
			MultiSelection = false;
			
			CountPosition = 0;

			InitDataValid(0, "bl_no", vtEngUpOther, "0123456789");
			InitDataValid(0, "pol_cd", vtEngUpOther, "0123456789");
			InitDataValid(0, "pod_cd", vtEngUpOther, "0123456789");
			InitDataValid(0, "cntr_no", vtEngUpOther, "0123456789");
			
			InitDataValid(0, "cell_psn_no", vtNumericOnly);
			InitDataValid(0, "imdg_clss_cd", vtNumericOther, ".");
			//InitDataValid(0, "imdg_un_no", vtNumericOnly);
			
			InitDataValid(0, "ems_no", vtEngUpOther, "-, ");
			//InitDataValid(0, "imdg_pck_grp_cd", vtEngUpOther, "0123456789");
			//InitDataValid(0, "flsh_pnt_cdo_temp", vtEngUpOther, "0123456789");
			InitDataValid(0, "fdr_svc_rqst_no", vtNumericOnly);
			
			InitDataValid(0, "out_imdg_pck_cd1", vtEngUpOther, "0123456789");
			InitDataValid(0, "ems_no", vtEngUpOther, "0123456789-, ");
			
//			InitDataValid(0, "fwrd_id", vtEngUpOther, "0123456789");

			InitDataValid(0, "packages", vtEngOther, "0123456789~!@#$%^&*()-_+={}[]/,.<> ");
			InitDataValid(0, "prp_shp_nm", vtEngOther, "0123456789~!@#$%^&*()-_+={}[]/,.<> ");
			InitDataValid(0, "hzd_desc", vtEngOther, "0123456789~!@#$%^&*()-_+={}[]/,.<> ");
			
			InitViewFormat(0, "crr_dt", "yyyymmdd");
			
			InitDataValid(0, "fdr_vvd_id", vtEngUpOther, "0123456789");
			
			
			// 틀고정 설정 (cntr_no)
			FrozenCols = 9;
			
			// 문장이 길경우 ...으로 표시함
			Ellipsis = true;
			
			// 멀티로우 드로우로 선택 설정
			MultiSelection = true;
			
			// Ctrl키를 눌러 다중행을 선택함
			SelectionMode = smSelectionList;

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
		case "anr_role_div_cd": {
			i = 0;
	
			with (comboObj) {
				InsertItem(i++, "Agent", "DA");
				InsertItem(i++, "Agent and Forwarder", "BO");
				InsertItem(i++, "Forwarder", "DF");
				Code = "0";
			}
			break;
		}
		
		case "reason_resending": {
			i = 0;
	
			with (comboObj) {
				InsertItem(i++, "", "");
				InsertItem(i++, "Mistake in previous notification", "CAM");
				InsertItem(i++, "Operation not carried out", "CAO");
				InsertItem(i++, "Change of dates of stay of truck/train/barge in the port", "CHD");
				InsertItem(i++, "Change of means of transport", "CHM");
				InsertItem(i++, "Change of name of vessel", "CHV");
				InsertItem(i++, "Specify TBN-container", "TBC");
				InsertItem(i++, "Specify TBN-forwarder", "TBF");
				InsertItem(i++, "Specify TBN-vessel/barge name", "TBN");
				
				Code = "";
			}
			break;
		}
		case "port_cd":{
			
			with (comboObj) {
				BackColor = "#CCFFFD";
				Style = 1;//0 -편집 가능,1 -편집 불가능
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
function doActionIBSheet(sheetObj, formObj, sAction, row, col) {

	sheetObj.ShowDebugMsg = false;
	
	switch (sAction) {
	
		case COMMAND02 :
			if (!validateForm(sheetObj, formObj, sAction))	return;
			
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

		case SEARCH01: // Bay-Plan Upload Required 활성/비활성 여부 판단
	
			if (!validateForm(sheetObj, formObj, sAction))	return;
	
			formObj.f_cmd.value = SEARCH01;
			var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0965GS.do", FormQueryString(formObj));
			var crntCellPsnNoYn = ComGetEtcData(sXml, "crntCellPsnNoYn");
	
			if (crntCellPsnNoYn == "N") {
				// bay_plan_upload_check 필드 활성화
				formObj.bay_plan_upload_check.disabled = false;
			} else {
				// bay_plan_upload_check 필드 비활성화
				formObj.bay_plan_upload_check.disabled = true; 
			}
	
			break;
	
		case SEARCH02: // Retrieve버튼 클릭시 조회
	
			if(!validateForm(sheetObj,formObj,sAction))return;
	
			formObj.f_cmd.value = SEARCH02;
			
			if(!formObj.dg_list_copy_check.disabled) {
				if(formObj.dg_list_copy_check.checked) {
					formObj.dg_list_copy_flag.value = 'Y';
				} else {
					formObj.dg_list_copy_flag.value = 'N';
				}				
			} else {
				formObj.dg_list_copy_flag.value = 'N';
			}

			if(!formObj.barge_check.disabled) {

				if(formObj.barge_check.checked) {
					formObj.barge_flag.value = 'Y';
				} else {
					formObj.barge_flag.value = 'N';
				}
			} else {
				formObj.barge_flag.value = 'N';
			}
			
			ComOpenWait(true);
			var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0965GS.do", FormQueryString(formObj));
			ComOpenWait(false);
	
			var arrXml = sXml.split("|$$|");
	
			formObj.cntr_cnt.value = ""; // Total Container 필드 초기화
			formObj.dg_list_local_yn.value = ComGetEtcData(arrXml[0], "dgListLocalYn");
			
			var sentStatus = ComGetEtcData(arrXml[0], "ediSentStatus");
	
			if (ComBkgErrMessage(sheetObj, sXml)) {
				
				sheetObjects[0].LoadSearchXml(arrXml[0]);
				sheetObjects[1].LoadSearchXml(arrXml[1]);
	
				if(formObj.dg_list_local_yn.value == "N") { // Booking쪽 데이타가 조회되면 
					// 비활성화 색상으로 변경
					sheetObjects[1].ColBackColor("dg") = sheetObjects[1].RgbColor(192,192,192); 
					
					if(sheetObjects[1].RowCount > 0 && sheetObjects[1].CellValue(1,"dg_short_nm_cnt") != "0") {
						// Attention: this VVD contains SPECIAL DG (ZTG/AMN/SPR)
						ComShowCodeMessage('BKG06117'); 
					}
				} else { // 세관쪽에 저장된 데이타가 조회되면.
					// 전송된 케이스에는 색상으로 표시되도록 수정 (Send 정보가 존재하는 경우)
					for ( var i = 1; i <= sheetObjects[1].Rows; i++) {						
						
						if(sheetObjects[1].cellValue(i,"msg_snd_no") != ""){							
							sheetObjects[1].CellBackColor(i,"seq") = sheetObjects[1].RgbColor(200,255,200);
							sheetObjects[1].CellBackColor(i,"bkg_no") = sheetObjects[1].RgbColor(200,255,200);
							sheetObjects[1].CellBackColor(i,"bl_no") = sheetObjects[1].RgbColor(200,255,200);
							sheetObjects[1].CellBackColor(i,"pol_cd") = sheetObjects[1].RgbColor(200,255,200);
							sheetObjects[1].CellBackColor(i,"pod_cd") = sheetObjects[1].RgbColor(200,255,200);
							sheetObjects[1].CellBackColor(i,"cntr_no") = sheetObjects[1].RgbColor(200,255,200);
						}

					}
				}
				
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
			}
	
			setSentStatusFiledColor(sheetObjects[1], sentStatus); // Sent Status 필드 컬러변경
			
			formObj.bay_pln_id.value = "";
			sheetObjects[1].CheckAll2("check") = 0;
			
			if(formObj.dg_list_local_yn.value == "N") { 
				// Booking쪽 데이타가 조회되면  EDI Transmit, EDI  Cancel 버튼 비활성화
				ComBtnDisable("btn1_EDITransmit");
				ComBtnDisable("btn1_EDICancel");
				ComBtnDisable("btn1_Append_Retrieve");
			} else {
				// local쪽 데이타가 조회되면  EDI Transmit, EDI  Cancel 버튼 활성화
				ComBtnEnable("btn1_EDITransmit");
				ComBtnEnable("btn1_EDICancel");
				ComBtnEnable("btn1_Append_Retrieve");
			}
			
			// 조회 조건 값을 hidden으로 저장해 둔다.
			setSearchCond(sheetObjects[1], formObj);
	
			break;
			
		case SEARCH03 : // Vessel Code로 Vessel Name을 조회한다.
	
			//if (!validateForm(sheetObj, formObj, sAction))	return;
			formObj.f_cmd.value = SEARCH03;
			ComOpenWait(true);
			var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0965GS.do", FormQueryString(formObj));
			ComOpenWait(false);
			var vesselName = ComGetEtcData(sXml, "vesselName");
			
			//alert("vesselName : " + vesselName );
			
			formObj.frm_vsl_eng_nm.value = (vesselName == undefined) ? "" : vesselName;
			break;
	
		case SEARCH04 : // Berth Code로 Name을 조회한다.
	
			//if (!validateForm(sheetObj, formObj, sAction))	return;
			formObj.f_cmd.value = SEARCH04;
			var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0965GS.do", FormQueryString(formObj));
			var yardName = ComGetEtcData(sXml, "yardName");
			
			//alert("yardName : " + yardName );
			
			formObj.frm_yd_nm.value = (yardName == undefined) ? "" : yardName;
			
			break;

		case SEARCH05: // vvd, port로 로컬 위험물테이블에 저장된 상태인지 조회한다.
	
			if (!validateForm(sheetObj, formObj, sAction))	return;
			
			formObj.f_cmd.value = SEARCH05;
			var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0965GS.do", FormQueryString(formObj));
			var retVal = ComGetEtcData(sXml, "retVal");
	
			 //alert("retVal : " +retVal);
	
			formObj.bay_plan_upload_check.checked = false;
			if (retVal == "Y") {
				formObj.bay_plan_upload_check.disabled = true; // bay_plan_upload_check 필드 활성화
			} else {
				formObj.bay_plan_upload_check.disabled = false; // bay_plan_upload_check 필드 비활성화
																 
				doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
			}
	
			break;
			
		case SEARCH06 : // Declaration check시 copy checkbox 활성화/비활성화 판단
			formObj.f_cmd.value = SEARCH06;
			var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0965GS.do", FormQueryString(formObj));
			var dgListCopyYn = ComGetEtcData(sXml, "dgListCopyYn");
			
			//alert("dgListCopyYn : " + dgListCopyYn + "\nformObj.dg_list_copy_check.checked : " + formObj.dg_list_copy_check.checked);
			formObj.dg_list_copy_check.checked = false;
			if(dgListCopyYn == "Y") {
				formObj.dg_list_copy_check.disabled = false;
			} else {
				formObj.dg_list_copy_check.disabled = true;
			}
			
			
			break;
			
		case IBSAVE: // 저장
			
			if(!validateForm(sheetObj,formObj,sAction))return;
			
			IBS_CopyFormToRow(formObj, sheetObjects[0], 1, "frm_");
			
			var vslInfoLocalYn = sheetObjects[0].CellValue(1, "local_db_yn");
			var dgListLocalYn = formObj.dg_list_local_yn.value;
			var shee2RowSize = sheetObjects[1].RowCount;

			//alert("vslInfoLocalYn : " + vslInfoLocalYn + "\ndgListLocalYn : " + dgListLocalYn);
			
			if (vslInfoLocalYn == "N") {
				//sheetObjects[0].CellValue2(1, "ibflag") = "I";
				sheetObjects[0].RowStatus(1) = "I";
			}
	
			if (dgListLocalYn == "N") {
				for ( var i = 1; i <= shee2RowSize; i++) {
					
					//if(sheetObjects[1].CellValue(i, "ibflag") == "D") continue;
					if(sheetObjects[1].RowStatus(i) == "D") continue;
					
					//sheetObjects[1].CellValue2(i, "ibflag") = "I";
					sheetObjects[1].RowStatus(i) = "I";
				} // end for(i)
			}
	
			formObj.f_cmd.value = MULTI;
			var sParam = "";
			
			var sParamSheet1 = sheetObjects[0].GetSaveString();
			if (sParamSheet1 != "") {
				sParam += "&" + ComSetPrifix(sParamSheet1, "sheet1_");
			}
			//alert("sParamSheet1 : " + sParamSheet1);
	
			var sParamSheet2 = "";
			
			//alert("sParamSheet2 : " + sParamSheet2);
			if (sheetObjects[1].GetSaveString() != "") {
				
				for(var i = 0; i <=  sheetObjects[1].RowCount; i++) {
					if(sheetObjects[1].CellValue(i, "seq") == "A") {
						if(sheetObjects[1].RowStatus(i) == "D") {
							sheetObjects[1].RowStatus(i) = "";
						} else {
							sheetObjects[1].RowStatus(i) = "I";
						}
						
					}
				} // end for(i)
				
				sParamSheet2 = sheetObjects[1].GetSaveString();
				
				sParam += "&" + ComSetPrifix(sParamSheet2, "sheet2_");				
			} else {
				
				if(vslInfoLocalYn != "Y" && dgListLocalYn != "Y") {
					return false;
				}
			}
	
			if (sParam == "") {
				ComShowCodeMessage('BKG00260');
				return;
			}
	
			sParam += "&" + FormQueryString(formObj);
	
			//alert(sParam);
			
            if(!ComShowCodeConfirm("BKG00350")) {
            	return false;
            }
            
			ComOpenWait(true);
			var sXml = sheetObjects[0].GetSaveXml("ESM_BKG_0965GS.do", sParam);
			ComOpenWait(false);
			
	        var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
	        xmlDoc.async="false";
	        xmlDoc.loadXML(sXml);

	        var dataNode = xmlDoc.documentElement.getElementsByTagName("TR-ALL").item(0);
			
	        if(dataNode.text == "OK") {
	        	formObj.bay_plan_upload_check.disabled = true;
	        	ComShowCodeMessage('BKG00166'); //Data Saved Successfully!!
	        } else {
	        	ComShowCodeMessage('BKG00167'); //Data Save Action Failed!!
	        }
			
	
			if (dataNode.text == "OK" && ComBkgErrMessage(sheetObj, sXml)) {
				formObj.dg_list_copy_check.checked = false;
				formObj.dg_list_copy_check.disabled = true;
				formObj.dg_list_copy_flag.value = "N";

				doActionIBSheet(sheetObj, formObj, SEARCH02); // 재조회
			}

			break;
	
		case IBDOWNEXCEL: // 엑셀
			
			if(!validateForm(sheetObj,formObj,sAction))return;
			
			ComOpenWait(true);
			sheetObjects[1].SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "check");
			ComOpenWait(false);

			break;
	
		case COMMAND01 : // BL_NO, CNTR_NO Filter
			
			if(!validateForm(sheetObj,formObj,sAction))return;
			
			var searchText = "";
			var idx = -1;
			var currRowIdx = 0;
			
			if(nextSearchIdx == 0) {
				currRowIdx = sheetObjects[1].SelectRow;
			} else {
				currRowIdx = nextSearchIdx;
			}
			
			//alert("currRowIdx : " + currRowIdx);
			
			if(!formObj.filter_bl_no.readOnly) {
				searchText = formObj.filter_bl_no.value;			
				idx = sheetObjects[1].FindText("bl_no", searchText, currRowIdx, 2, false);
			} else {
				searchText = formObj.filter_cntr_no.value;			
				idx = sheetObjects[1].FindText("cntr_no", searchText, currRowIdx, 2, false);

			}
			
			if(idx == -1) {
				//ComShowMessage("No Search [" + searchText + "]");
				ComShowCodeMessage(ComGetMsg("BKG06101", searchText));
				nextSearchIdx = 0;
			} else {
				
				if(!formObj.filter_bl_no.readOnly) {
					sheetObjects[1].SelectCell(idx, "bl_no", false);
				} else {
					sheetObjects[1].SelectCell(idx, "cntr_no", false);
				}
				
				sheetObjects[1].SelectFontBold  = true;
				sheetObjects[1].SelectBackColor = sheetObjects[1].RgbColor(255,255,192);
				
				nextSearchIdx = idx + 1;
				
			}
			
			break;
			
		case MULTI01: // Flat File 생성 및 EDI전송
			
			IBS_CopyFormToRow(formObj, sheetObjects[0], 1, "frm_");
			if(sheetObjects[0].IsDataModified == true || sheetObjects[1].IsDataModified == true) {
				//ComShowMessage("변경된 데이타가 있습니다. 먼저 저장 후 전송해 주세요!");
				ComShowCodeMessage('BKG06098');
				return;
			}
			
			if(!validateForm(sheetObj,formObj,sAction)) return false;
			
			formObj.f_cmd.value = MULTI01;
			formObj.trans_type.value = "ORIGIN_SEND";
	
			if(!ComShowConfirm(ComGetMsg("BKG95003", "Transmit"))) {
            	// send type 조회시 상태로 초기화
            	initSearchValue(sheetObjects[1], "send_type", "AC");
            	sheetObjects[1].CheckAll2("check") = 0;
				return false;
            }
			

			var rowCnt = sheetObjects[1].RowCount;
			
			for(var i=1; i<=rowCnt; i++) {
				
				if(sheetObj.CellValue(i, "check") == 1) {
					sheetObjects[1].RowStatus(i) = "I";

					/*
					 * Send Type to Oringinal 체크시 Send Type 을 최초 전송 상태로 변경 한다.(double calling 문제로 추가)
					 */
					if(sheetObj.CellValue(i, "send_type_check_orgin") == 1) {
						sheetObj.CellValue2(i, "send_type") = "";
					}
					
				} else {
					sheetObjects[1].RowStatus(i) = "";
				}

				
			} // end for(i)
			
			var sParam = "";
			
			var sParamSheet = sheetObjects[1].GetSaveString();

			if (sParamSheet != "") {
				sParam += "&" + sParamSheet;
			}
			
			sParam += "&" + FormQueryString(formObj);
			
			ComOpenWait(true);
			var sXml = sheetObjects[1].GetSaveXml("ESM_BKG_0965GS.do", sParam);
			sheetObjects[1].LoadSaveXml(sXml);
			ComOpenWait(false);
			
//			formObj.output1.value = sheetObjects[1].EtcData("originalFlatFile");
//			formObj.output2.value = sheetObjects[1].EtcData("updateFlatFile");
//			formObj.output3.value = sheetObjects[1].EtcData("cancelFlatFile");

			doActionIBSheet(sheetObjects[1], formObj, SEARCH02); // 재조회
			
			break;

		case MULTI02: // Flat File 생성 및 EDI전송(CANCEL 전송)
			
			IBS_CopyFormToRow(formObj, sheetObjects[0], 1, "frm_");
			if(sheetObjects[0].IsDataModified == true || sheetObjects[1].IsDataModified == true) {
				//ComShowMessage("변경된 데이타가 있습니다. 먼저 저장 후 전송해 주세요!");
				ComShowCodeMessage('BKG06098');
				return;
			}


			if(!validateForm(sheetObj,formObj,sAction))return;
			
			formObj.f_cmd.value = MULTI01;
			formObj.trans_type.value = "CANCEL_SEND";
			
   			if(!ComShowConfirm(ComGetMsg("BKG95003", "[EDI Cancel Transmit]"))) {
            	return false;
            }
			
			var sParam = "";
			
            var rowCnt = sheetObjects[1].RowCount;
			
			for(var i=1; i<=rowCnt; i++) {
				
				if(sheetObj.CellValue(i, "check") == 1) {
					//sheetObjects[1].CellValue2(i,"ibflag") = "I";
					sheetObjects[1].RowStatus(i) = "I";
				} else {
					//sheetObjects[1].CellValue2(i,"ibflag") = "";
					sheetObjects[1].RowStatus(i) = "";
				}
				
			}
			
			var sParamSheet = sheetObjects[1].GetSaveString();
	
			if (sParamSheet != "") {
				//sParam += "&" + ComSetPrifix(sParamSheet2, "sheet2_");
				sParam += "&" + sParamSheet;
	
			}
	
			if (sParam == "") {
				ComShowCodeMessage('BKG00743');
				return;
			}
	
			sParam += "&" + FormQueryString(formObj);

			//alert(sParam);
	
			ComOpenWait(true);
			var sXml = sheetObjects[1].GetSaveXml("ESM_BKG_0965GS.do", sParam);
			sheetObjects[1].LoadSaveXml(sXml);
			ComOpenWait(false);
			
//			formObj.output1.value = sheetObjects[1].EtcData("originalFlatFile");
//			formObj.output2.value = sheetObjects[1].EtcData("updateFlatFile");
//			formObj.output3.value = sheetObjects[1].EtcData("cancelFlatFile");
			
			doActionIBSheet(sheetObjects[1], formObj, SEARCH02); // 재조회
			
			break;
			
		case SEARCH11 : //  입력시 validation (bl_no / pol_cd / pod_cd)
			
			formObj.f_cmd.value = SEARCH11;
			ComOpenWait(true);
			var sXml = sheetObjects[1].GetSearchXml("ESM_BKG_0965GS.do", FormQueryString(formObj));
			ComOpenWait(false);
			
			var retVal = ComGetEtcData(sXml, "retVal");
			var cond_type = formObj.cond_type.value;
			//alert("retVal : " + retVal );
			
			if(retVal == "0") { // 없는 데이타 이면
				if(cond_type == "bl_no") {
					ComShowCodeMessage('BKG06012', "[B/L No.]");
				} else if(cond_type == "pol_cd") {
					ComShowCodeMessage('BKG06012', "[POL]");
				} else if(cond_type == "pod_cd") {
					ComShowCodeMessage('BKG06012', "[POD]");
				}
				sheetObjects[1].CellValue2(row, col) = "";
				sheetObjects[1].SelectCell(row, col);
				
			} else {
				if(cond_type == "bl_no") {
					
					var runFlag = true;
					
					for(var i = 1; i < row; i++) {
						if(formObj.cond_value.value == sheetObjects[1].CellValue(i, "bl_no")) {
							runFlag = false;
							break;
						}
					}
					
					if(runFlag) {
						doActionIBSheet(sheetObjects[1],formObj,SEARCH13, row, col); // input validation
					} else {
						//ComShowMessage("중복된 B/L No.가 있습니다.");
//						ComShowCodeMessage('BKG06099');
//						sheetObjects[1].CellValue2(row, "bl_no") = "";
//						return false;
					}
				}
			}
			
			break;

		case SEARCH12 : //  입력시 validation (cntr_no)
			
			formObj.f_cmd.value = SEARCH12;
			ComOpenWait(true);
			var sXml = sheetObjects[1].GetSearchXml("ESM_BKG_0965GS.do", FormQueryString(formObj));
			ComOpenWait(false);
			
			var retVal = ComGetEtcData(sXml, "retVal");
			var cond_type = formObj.cond_type.value;
			//alert("retVal : " + retVal );
			
			if(retVal == "0") {
				if(cond_type == "cntr_no") {
					ComShowCodeMessage('BKG06012', "[Container No.]");
				}
				sheetObjects[1].CellValue2(row, col) = "";
				sheetObjects[1].SelectCell(row, col);
			}
			
			break;

		case SEARCH13 : //  B/L No.로 데이타를 찾아온다.
			
			formObj.f_cmd.value = SEARCH13;
			formObj.bl_no.value = formObj.cond_value.value;
			
			ComOpenWait(true);
			var sXml = sheetObjects[1].GetSearchXml("ESM_BKG_0965GS.do", FormQueryString(formObj));
			ComOpenWait(false);
			
			sheetObjects[1].RowDelete(row, false);
			
			// 조회된 데이타가 있으면 마지막 행에 append한다.
			sheetObjects[1].LoadSearchXml(sXml, true, row, false);

			//sheetObjects[1].RowDelete(sheetObjects[1].RowCount, false);
			
			formObj.bl_no.value = "";
			
			for(var i = row; i <=  sheetObjects[1].RowCount; i++) {
				
				sheetObjects[1].CellValue2(i, "seq") = "";
				//sheetObjects[1].CellValue2(i, "ibflag") = "I";
				sheetObjects[1].RowStatus(i) = "I";
			} // end for(i)
			break;
			
		case SEARCH14 : //  추가할 booking쪽 dg 데이타를 조회한다.
			
			IBS_CopyFormToRow(formObj, sheetObjects[0], 1, "frm_");
			if(sheetObjects[0].IsDataModified == true || sheetObjects[1].IsDataModified == true) {
				//ComShowMessage("변경된 데이타가 있습니다. 먼저 저장 후 전송해 주세요!");
				ComShowCodeMessage('BKG06098');
				return;
			}
			
   			if(!ComShowConfirm(ComGetMsg("BKG95003", "[append from BKG data]"))) {
            	return false;
            }
			
			formObj.f_cmd.value = SEARCH14;
			formObj.bl_no.value = formObj.cond_value.value;
			
			ComOpenWait(true);
			var sXml = sheetObjects[1].GetSearchXml("ESM_BKG_0965GS.do", FormQueryString(formObj));
			ComOpenWait(false);
			
			//sheetObjects[1].RowDelete(row, false);
			
			var appendRow = sheetObjects[1].RowCount + 1;
			// 조회된 데이타가 있으면 마지막 행에 append한다.
			sheetObjects[1].LoadSearchXml(sXml, true, appendRow, false);

			//sheetObjects[1].RowDelete(sheetObjects[1].RowCount, false);
			
			formObj.bl_no.value = "";
			
			for(var i = appendRow; i <=  sheetObjects[1].RowCount; i++) {
				sheetObjects[1].CellValue2(i, "seq") = "A";
//				sheetObjects[1].RowStatus(i) = "I";
				sheetObjects[1].CellBackColor(i, "seq") = sheetObjects[1].RgbColor(255, 255, 0);
			} // end for(i)
			break;
			
			
		case SEARCH07: // Feeder Name, Lloyd No Combo setting
			formObj.f_cmd.value = SEARCH07;
			var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0965GS.do", FormQueryString(formObj));
			var feederName = "";
			var feederLloydNo = "";
			var displayTextOffeederNameLloyNo = "";
			
			var oldLloyd = sheetObjects[1].CellValue(row, "fdr_vsl_lloyd_no");
			var oldName = sheetObjects[1].CellValue(row, "fdr_vsl_nm");
			// Feeder Name, Lloyd No Combo Setting
			if(sheetObjects[1].RowCount > 0) {
				feederName = ComGetEtcData(sXml, "feederName");
				feederLloydNo = ComGetEtcData(sXml, "feederLloydNo");
				displayTextOffeederNameLloyNo = ComGetEtcData(sXml, "displayTextOffeederNameLloyNo");
				
				// Feeder Name, Lloyd No Combo Setting
				sheetObjects[1].CellComboItem(row, "fdr_vsl_nm", displayTextOffeederNameLloyNo, feederName, 0);
				sheetObjects[1].CellComboItem(row, "fdr_vsl_lloyd_no", displayTextOffeederNameLloyNo, feederLloydNo, 1);
				
//				sheetObjects[1].CellValue2(row, "fdr_vsl_lloyd_no") = oldLloyd;
//				sheetObjects[1].CellValue2(row, "fdr_vsl_nm") = oldName;
				

			}
			break;
		case COMMAND11 : //  PORT 조회
			
			formObj.f_cmd.value = SEARCH11;
			ComOpenWait(true);
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0000_1GS.do", FormQueryString(formObj)+"&cnt_cd=BE&cstms_div_id=EUR_BE_PORT_LIST");
			ComXml2ComboItem(sXml, formObj.port_cd, "pod_cd", "pod_cd");
			formObj.port_cd.Index2=0;
			ComOpenWait(false);
			
			break;		
			
			
	}

	if(sAction == SEARCH02) { // SEARCH버튼 클릭시만
			
		for ( var i = 1; i <= sheetObjects[1].RowCount; i++) {
	
			
			// 그리드내에 Null String 필드는 노란색으로 변경
			if(sheetObjects[1].CellValue(i, "dg_short_nm") == "") {
				sheetObjects[1].CellBackColor(i, "dg_short_nm") = sheetObjects[1].RgbColor(255, 255, 0);
			}
			if(sheetObjects[1].CellValue(i, "c_type") == "") {
				sheetObjects[1].CellBackColor(i, "c_type") = sheetObjects[1].RgbColor(255, 255, 0);
			}
			
			if(sheetObjects[1].CellValue(i, "fdr_svc_rqst_no") == "") {
				sheetObjects[1].CellBackColor(i, "fdr_svc_rqst_no") = sheetObjects[1].RgbColor(255, 255, 0);
			}
			
			if(sheetObjects[1].CellValue(i, "imdg_clss_cd") == "") {
				sheetObjects[1].CellBackColor(i, "imdg_clss_cd") = sheetObjects[1].RgbColor(255, 255, 0);
			}		
			if(sheetObjects[1].CellValue(i, "flsh_pnt_cdo_temp") == "" ) {
				if(sheetObjects[1].CellValue(i, "imdg_clss_cd") == "3" ) {
					sheetObjects[1].CellBackColor(i, "flsh_pnt_cdo_temp") = sheetObjects[1].RgbColor(255, 128, 64);
				} 
			}
	
			if(sheetObjects[1].CellValue(i, "cell_psn_no") == "") {
				sheetObjects[1].CellBackColor(i, "cell_psn_no") = sheetObjects[1].RgbColor(255, 255, 0);
			}
			if(sheetObjects[1].CellValue(i, "imdg_un_no") == "") {
				sheetObjects[1].CellBackColor(i, "imdg_un_no") = sheetObjects[1].RgbColor(255, 255, 0);
			}
			if(sheetObjects[1].CellValue(i, "imdg_pck_grp_cd") == "") {
				sheetObjects[1].CellBackColor(i, "imdg_pck_grp_cd") = sheetObjects[1].RgbColor(255, 255, 0);
			}
			if(sheetObjects[1].CellValue(i, "dcgo_mrn_polut_cd") == "") {
				sheetObjects[1].CellBackColor(i, "dcgo_mrn_polut_cd") = sheetObjects[1].RgbColor(255, 255, 0);
			}
			if(sheetObjects[1].CellValue(i, "imdg_lmt_qty_flg") == "") {
				sheetObjects[1].CellBackColor(i, "imdg_lmt_qty_flg") = sheetObjects[1].RgbColor(255, 255, 0);
			}
			if(sheetObjects[1].CellValue(i, "ems_no") == "") {
				sheetObjects[1].CellBackColor(i, "ems_no") = sheetObjects[1].RgbColor(255, 255, 0);
			}
			if(sheetObjects[1].CellValue(i, "net_wgt") == "") {
				sheetObjects[1].CellBackColor(i, "net_wgt") = sheetObjects[1].RgbColor(255, 255, 0);
			}
			if(sheetObjects[1].CellValue(i, "grs_wgt") == "") {
				sheetObjects[1].CellBackColor(i, "grs_wgt") = sheetObjects[1].RgbColor(255, 255, 0);
			}
			
			
			if(formObj.dg_list_local_yn.value == "N") { // Booking쪽 데이타가 조회되면 Container No.를 수정할 수 있게 한다.
				sheetObjects[1].CellEditable(i, "cntr_no") = true;
			} else {
				sheetObjects[1].CellEditable(i, "cntr_no") = false;
			}
			
			if(sheetObjects[1].CellValue(i, "c_type") == "V") { // Carriage Type == Marintime
				setMandatoryFeederInfo2(i, true);
			} else {
				setMandatoryFeederInfo2(i, false);
			}
			
		} // end for(i)
	}

	
}
 /**
 * 
 * @param flag
 * @return
 */
function setMandatoryFeederInfo2(row, flag) {
	sheetObjects[1].CellEditable(row,"fdr_svc_rqst_no") = flag;
	sheetObjects[1].CellEditable(row,"fdr_vsl_nm") = flag;
	sheetObjects[1].CellEditable(row,"fdr_vsl_lloyd_no") = flag;
	sheetObjects[1].CellEditable(row,"fdr_vvd_id") = flag;
	
	if(!flag) {
		sheetObjects[1].CellValue2(row,"fdr_svc_rqst_no") = "";
		sheetObjects[1].CellValue2(row,"fdr_vsl_nm") = "";
		sheetObjects[1].CellValue2(row,"fdr_vsl_lloyd_no") = "";
		sheetObjects[1].CellValue2(row,"fdr_vvd_id") = "";
	}
}
 /**
  * 
  * @param flag
  * @return
  */
 function setMandatoryFeederInfo(row, flag) {
	var blNo = sheetObjects[1].CellValue(row, "bl_no");
	var cntrNo = sheetObjects[1].CellValue(row, "cntr_no");
//	alert("row"+ row);
//	alert("flag"+flag);
//	alert("bl_no"+ blNo);

	var currKey = "";
	var nextKey = "";
	
 	sheetObjects[1].CellEditable(row,"fdr_svc_rqst_no") = flag;
 	sheetObjects[1].CellEditable(row,"fdr_vsl_nm") = flag;
 	sheetObjects[1].CellEditable(row,"fdr_vsl_lloyd_no") = flag;
 	sheetObjects[1].CellEditable(row,"fdr_vvd_id") = flag;

	for(var i = 1; i <=  sheetObjects[1].RowCount; i++) {
		
		currKey = blNo + cntrNo;
		nextKey = sheetObjects[1].CellValue(i, "bl_no") + sheetObjects[1].CellValue(i, "cntr_no");
		
		if(currKey == nextKey) {		 	
		 	if(!flag) {		 	
		 	 	sheetObjects[1].CellEditable(i,"fdr_svc_rqst_no") = flag;
		 	 	sheetObjects[1].CellEditable(i,"fdr_vsl_nm") = flag;
		 	 	sheetObjects[1].CellEditable(i,"fdr_vsl_lloyd_no") = flag;
		 	 	sheetObjects[1].CellEditable(i,"fdr_vvd_id") = flag;
		 	 	
		 		sheetObjects[1].CellValue2(i,"fdr_svc_rqst_no") = "";
		 		sheetObjects[1].CellValue2(i,"fdr_vsl_nm") = "";
		 		sheetObjects[1].CellValue2(i,"fdr_vsl_lloyd_no") = "";
		 		sheetObjects[1].CellValue2(i,"fdr_vvd_id") = "";
		 	}
		} else {

		}
	} // end for(i)
	

 }


/**
 * sheet 필드중 send_type = "AC" 인 로우를 대상으로 send_type, msg_snd_no를 조회시 값으로 되돌린다.
 * @param sheetObj
 * @param colName
 * @param targetValue
 * @return
 */
function initSearchValue(sheetObj, colName, targetValue) {
	var rowCnt = sheetObj.RowCount;
	
	// send type 조회시 상태로 초기화
	ComOpenWait(true);
	for(var i=1; i<=rowCnt; i++) {
		if(sheetObj.CellValue(i,"send_type") == targetValue) {
			sheetObj.CellValue2(i,"send_type") = sheetObj.CellSearchValue(i,"send_type");
			sheetObj.CellValue2(i,"msg_snd_no") = sheetObj.CellSearchValue(i,"msg_snd_no");
		}
	}
	ComOpenWait(false);
}

/**
 * Sent Status 컬러 변경
 * 
 * @return
 */
function setSentStatusFiledColor(sheetObj, sentStatus) {
	
	var formObj = document.form;
	//var sentStatus = formObj.frm_ack_rcv_sts_cd.value
	var obj = formObj.ack_rcv_sts_cd_name;
	var maxCnt = sheetObj.RowCount;
	
	var nullSendTypeCnt = 0;
	
	for(var i = 1; i <= maxCnt; i++) {
		
		if(sheetObj.CellValue(i, "send_type") == "") nullSendTypeCnt++;
		
	} // end for(i)
	
	obj.style.color = "white";
	
	if(nullSendTypeCnt == maxCnt) {
		formObj.ack_rcv_sts_cd_name.value = "All not sent";
		obj.style.backgroundColor = "gray";
	} else {
		if (sentStatus == "FAIL") { // Fail
			formObj.ack_rcv_sts_cd_name.value = "FAIL";
			obj.style.backgroundColor = "red";

		} else { // SUCCESS
			formObj.ack_rcv_sts_cd_name.value = "SUCCESS";
			obj.style.backgroundColor = "blue";
		}
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
	
		case COMMAND02 : // Row Delete
		
			if(sheetObj.RowCount == 0) {
        		ComShowCodeMessage('BKG00095');
        		return false;
			}
			
			break;
			
		case SEARCH02:
		case SEARCH04:
			// 기본포멧체크
			if(!ComChkObjValid(formObj.d_type) || !ComChkObjValid(formObj.vvd_cd) || formObj.port_cd.Code == "" ) return false;
			break;
			
		case SEARCH01:
		case SEARCH03:
		case SEARCH05:
			if(formObj.d_type.value != "" && formObj.vvd_cd.value != "" && formObj.port_cd.Code != "") {
				//기본포멧체크
				if(!ComChkObjValid(formObj.d_type) || !ComChkObjValid(formObj.vvd_cd) ) return false;
			}
			break;
			
		case IBSAVE:
			var sheet1RowCnt = sheetObjects[1].RowCount;
			
			if(sheet1RowCnt == 0) return false;

			//기본포멧체크
			if (!ComChkValid(formObj)) return false;
			
			// 조회시 사용된 조회조건 값이 변경된게 있는지 확인한다.
			if(formObj.hid_d_type.value != formObj.d_type.value ||
					formObj.hid_vvd_cd.value != formObj.vvd_cd.value ||
					formObj.hid_port_cd.value!= formObj.port_cd.Code) {
				ComShowCodeMessage("BKG06118", formObj.hid_d_type.value +","+ formObj.hid_vvd_cd.value+","+formObj.hid_port_cd.value, formObj.d_type.value+","+formObj.vvd_cd.value+","+formObj.port_cd.Code);
				return false;
			}
			
			for(var i=1; i<=sheet1RowCnt; i++) {
				
				//if(sheetObjects[1].CellValue(i, "ibflag") == "D") continue;
				if(sheetObjects[1].RowStatus(i) == "D") continue;
				
				if(sheetObjects[1].CellValue(i, "imdg_clss_cd") == "3" && sheetObjects[1].CellValue(i, "flsh_pnt_cdo_temp") == ""  ) {
	        		ComShowCodeMessage("BKG00540", "[Container No. : " + sheetObjects[1].CellValue(i, "cntr_no") + "]");
	        		sheetObjects[1].SelectCell(i, "flsh_pnt_cdo_temp");
	        		return false;
				}
				
				// Carriage Ttype = "MARITIME"일 경우. SSR(Feeder), Vessel Name(Feeder), Lloy No(Feeder), VVd(Feeder)필드는 필수
				if(sheetObjects[1].CellValue(i,"c_type") == "V") {
					// fdr_ssr 필수 설정
					if(sheetObjects[1].CellValue(i,"fdr_svc_rqst_no") == "" ) {
						ComShowCodeMessage('BKG01101', "[SSR(Feeder)]");
						sheetObjects[1].SelectCell(i, "fdr_svc_rqst_no");
						return false;
					}
					
					if(sheetObjects[1].CellValue(i,"fdr_vsl_nm") == "" ) {
						ComShowCodeMessage('BKG01101', "[Vessel Name(Feeder)]");
						sheetObjects[1].SelectCell(i, "fdr_vsl_nm");
						return false;
					}
					if(sheetObjects[1].CellValue(i,"fdr_vsl_lloyd_no") == "" ) {
						ComShowCodeMessage('BKG01101', "[Lloyd No(Feeder)]");
						sheetObjects[1].SelectCell(i, "fdr_vsl_lloyd_no");
						return false;
					}
					if(sheetObjects[1].CellValue(i,"fdr_vvd_id") == "" ) {
						ComShowCodeMessage('BKG01101', "[VVD(Feeder)]");
						sheetObjects[1].SelectCell(i, "fdr_vvd_id");
						return false;
					}
					
				}

			} // end for(i)
			
				
			
			break;
		
		case IBDOWNEXCEL:
			if(sheetObj.RowCount == 0) {
        		ComShowCodeMessage('BKG00109');
        		return false;
			}
			
			break;
			
		case COMMAND01 : // Filter
			
			var filterBlNo = formObj.filter_bl_no.value;
			var filterCntrNo = formObj.filter_cntr_no.value;

			if(filterBlNo == "" && filterCntrNo == "") {
				//ComShowMessage("Filter 검색 조건을 입력후 사용하세요!");
				ComShowCodeMessage('BKG06095');
				ComSetFocus(formObj.filter_bl_no);
				
				return false;
			}
			
			if(sheetObj.RowCount == 0) {
        		ComShowCodeMessage('BKG00095');
        		return false;
			}
			
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
			
			// 조회시 사용된 조회조건 값이 변경된게 있는지 확인한다.
			if(formObj.hid_d_type.value != formObj.d_type.value ||
					formObj.hid_vvd_cd.value != formObj.vvd_cd.value ||
					formObj.hid_port_cd.value!= formObj.port_cd.Code) {
				ComShowCodeMessage("BKG06118", formObj.hid_d_type.value +","+ formObj.hid_vvd_cd.value+","+formObj.hid_port_cd.value, formObj.d_type.value+","+formObj.vvd_cd.value+","+formObj.port_cd.Code);
				return false;
			}

			var checkCnt = 0;
			var cancelCheckCnt = 0;
			var firstCheckCnt = 0;
			var updateCheckCnt = 0;
			
	        for(var i=1; i <= sheet1RowCnt; i++) {
	        	
	        	if(sheetObj.CellValue(i, "check") == "1") {
	        		
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
	        			if(sheetObj.CellValue(i, "cell_psn_no") == "") {
	    	        		ComShowCodeMessage("BKG01101", "[Cell Position]");
	    	        		sheetObj.SelectCell(i, "cell_psn_no")   
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

	        			if(sheetObj.CellValue(i, "c_type") == "V") {
	        				if(sheetObjects[1].CellValue(i,"c_type") == "V") {
	        					// fdr_ssr 필수 설정
	        					if(sheetObjects[1].CellValue(i,"fdr_svc_rqst_no") == "" ) {
	        						ComShowCodeMessage('BKG01101', "[SSR(Feeder)]");
	        						sheetObjects[1].SelectCell(i, "fdr_svc_rqst_no");
	        						return false;
	        					}
	        					
	        					if(sheetObjects[1].CellValue(i,"fdr_vsl_nm") == "" ) {
	        						ComShowCodeMessage('BKG01101', "[Vessel Name(Feeder)]");
	        						sheetObjects[1].SelectCell(i, "fdr_vsl_nm");
	        						return false;
	        					}
	        					if(sheetObjects[1].CellValue(i,"fdr_vsl_lloyd_no") == "" ) {
	        						ComShowCodeMessage('BKG01101', "[Lloyd No(Feeder)]");
	        						sheetObjects[1].SelectCell(i, "fdr_vsl_lloyd_no");
	        						return false;
	        					}
	        					if(sheetObjects[1].CellValue(i,"fdr_vvd_id") == "" ) {
	        						ComShowCodeMessage('BKG01101', "[VVD(Feeder)]");
	        						sheetObjects[1].SelectCell(i, "fdr_vvd_id");
	        						return false;
	        					}
	        					
	        				}
	        			}
	        			
	        			if((formObj.anr_role_div_cd.Code == "BO" && formObj.d_type.value == "PL")
	        				|| formObj.d_type.value == "P"
	        				|| (formObj.anr_role_div_cd.Code == "BO" && formObj.d_type.value == "DO")
	        				|| formObj.d_type.value == "O" ) {
	        				
	        				if(sheetObjects[1].CellValue(i,"crr_dt") == "") {
	        					ComShowCodeMessage('BKG01101', sheetObjects[1].CellValue(0,"crr_dt"));
        						sheetObjects[1].SelectCell(i, "crr_dt");
        						return false;
	        				}
	        				
	        			}
	        			
	        		}		        	
		        	
		        	if(currBlNo == preBlNo) continue;

		        	checkCnt++;
	        		
	        		//if(sheetObj.CellValue(i, "send_type") == "C") cancelCheckCnt++;
	        		//if(sheetObj.CellValue(i, "send_type") == "") firstCheckCnt++;

	        		if(sheetObj.CellValue(i, "send_type") == "O" || sheetObj.CellValue(i, "send_type") == "U") updateCheckCnt++;

	        		if(sAction == MULTI02 && sheetObj.CellValue(i, "send_type") == "") {
	        			//ComShowMessage("선택한 B/L No.중 최초전송 B/L No.가 있습니다.");
	        			ComShowCodeMessage("BKG06096");
	        			sheetObj.SelectRow = i;
	    	        	return false;
	        		}
	        		
	        		
	        		if(sAction == MULTI02 && sheetObj.CellValue(i, "send_type") == "C") {
	        			//ComShowMessage("선택한 B/L No.중 이미 Cancel 전송한 B/L No.가 있습니다.");
	        			ComShowCodeMessage("BKG06097", sheetObj.CellValue(i, "bl_no"));
	        			sheetObj.SelectRow = i;
	    	        	return false;
	        		}
	        		
					if(sAction == MULTI01) { // EDI Transmit 버튼 클릭시 (중복 컨테이너 skip)
	        			if(sheetObj.CellValue(i, "cntr_no") == "") {
	    	        		ComShowCodeMessage("BKG01101", "[Container No.]");
	    	        		sheetObj.SelectCell(i, "cntr_no")   
	    					return false;
	        			}
					}
	        		

	        		preBlNo = currBlNo;
	        		
	        	}
	        	

	        }
	        
	        if(checkCnt == 0) {
	        	//ComShowMessage("전송할 row를 먼저 체크해 주세요");
        		ComShowCodeMessage("BKG01097");
	        	return false;
	        } else {
	        	
	        	if(formObj.anr_role_div_cd.Code == "") {
	        		ComShowCodeMessage("BKG01101", "[Agent or Agent Forwader]");
					ComSetFocus(formObj.anr_role_div_cd);   
					return false;
	        		
	        	}
	        	
	        	if(sAction == MULTI02) { // EDI Cancel 버튼 클릭시.
	        		// 같은 first_msg_snd_no를 같이 체크한다.
	        		if(!groupCheck("", "BKG06110")) return false;
	        		
        		} else { // EDI Transmit 버튼 클릭시
        			if(updateCheckCnt > 0) {
	        			// 같은 first_msg_snd_no를 같이 체크한다. 전송 Flag를 "AC" 셋팅한다.
		        		if(!groupCheck("AC", "BKG06111")) return false;
        			}
	        		
        		}
	        }

			
			break;
	
	} // end switch

	return true;
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
		formObj.hid_d_type.value = formObj.d_type.value;
		formObj.hid_vvd_cd.value = formObj.vvd_cd.value;
		formObj.hid_port_cd.value = formObj.port_cd.Code;
	}
}

/**
 * 같은 first_msn_snd_no 그룹별로 체크박스를 체크한다.<br>
 * 
 * @param autoCancelFlag
 * @param confirmMsgCode
 * @return
 */
function groupCheck(autoCancelFlag, confirmMsgCode) {
	
	var currBlNo = "";
	var preBlNo = "";
	var subCurrBlNo = "";
	var subPreBlNo = "";
	var msgSndNo = "";
	var subMsgSndNo = "";
	var firstMsgSndNo = "";
	var subFirstMsgSndNo = "";

	var groupCnt = 0;
	var sheetObj = sheetObjects[1]
	var sheet1RowCnt = sheetObj.RowCount;
	
	var bLList = "";
	
	var sendType = "";
	var subSendType = "";
	
	
	for(var i=1; i <= sheet1RowCnt; i++) {
     	currBlNo = sheetObj.CellValue(i, "bl_no");
     	
    	if(currBlNo == preBlNo) continue;

    	if(sheetObj.CellValue(i, "check") == "1") {
    		firstMsgSndNo = sheetObj.CellValue(i, "first_msg_snd_no");
    		sendType = sheetObj.CellValue(i, "send_type");
    		msgSndNo = sheetObj.CellValue(i, "msg_snd_no");

    		subCurrBlNo = "";
    		subPreBlNo  = "";
    		// 현재 기준 이후 check
    		for(var j=i ; j<=sheet1RowCnt; j++) {
    			
    			subCurrBlNo = sheetObj.CellValue(j, "bl_no");
    			subSendType = sheetObj.CellValue(j, "send_type");
    			if(sendType == "C") {
    				continue;
    			}
    			
    			subFirstMsgSndNo = sheetObj.CellValue(j, "first_msg_snd_no");

        		//alert("after" + "\nsubCurrBlNo : "+ subCurrBlNo + "\nfirstMsgSndNo : " + firstMsgSndNo + "\nsubFirstMsgSndNo : " + subFirstMsgSndNo);
        		
    			if(subFirstMsgSndNo != "" && firstMsgSndNo == subFirstMsgSndNo) {
    				if(sheetObj.CellValue(j, "check") == "0" && subSendType != "C") {
    					if(autoCancelFlag != "") {
    						sheetObj.CellValue2(j, "send_type") = "AC"; // AUTO CACNCEL FLAG 셋팅
    						sheetObj.CellValue2(j, "msg_snd_no") = msgSndNo; // AUTO CACNCEL 대상 msg_snd_no를 같게 assign한다.
    					}
    					if(subPreBlNo != subCurrBlNo) {
    						bLList += subCurrBlNo + ",";
    					}
    					sheetObj.CellValue2(j, "check") = 1;
    				}
    				
    			} else {
    				continue;
    			}
    			
    			subPreBlNo = subCurrBlNo; 
    		} // end for(j)

    		
    		subCurrBlNo = "";
    		subPreBlNo  = "";
    		subFirstMsgSndNo = "";
    		// 현재 기준 이전 check
    		for(var j=i ; j>0; j--) {
    			
    			subCurrBlNo = sheetObj.CellValue(j, "bl_no");
    			subSendType = sheetObj.CellValue(j, "send_type");
    			
    			if(sendType == "C") {
    				continue;
    			}    			
    			
    			subFirstMsgSndNo = sheetObj.CellValue(j, "first_msg_snd_no");
        		//alert("before" + "\nsubCurrBlNo : "+ subCurrBlNo + "\nfirstMsgSndNo : " + firstMsgSndNo + "\nsubFirstMsgSndNo : " + subFirstMsgSndNo);
    			
    			if(subFirstMsgSndNo != "" && firstMsgSndNo == subFirstMsgSndNo) {
    				if( sheetObj.CellValue(j, "check") == "0" && subSendType != "C") {
    					
    					if(autoCancelFlag != "") {
    						sheetObj.CellValue2(j, "send_type") = "AC"; // AUTO CACNCEL FLAG 셋팅
    						sheetObj.CellValue2(j, "msg_snd_no") = msgSndNo; // AUTO CACNCEL 대상 msg_snd_no를 같게 assign한다.
    					}
    					if(subPreBlNo != subCurrBlNo) { 
    						bLList += subCurrBlNo + ",";
    					}
    					
    					sheetObj.CellValue2(j, "check") = 1;
    				}
    				
    			} else {
    				continue;
    			}    
    			
    			subPreBlNo = subCurrBlNo; 
    		} // end for(j)
    		
    	}
    	
    	//bLList += "\n";
    	
    	preBlNo = currBlNo;
	 } // end for(i)
	
	if(bLList != "") {
	
		bLList = bLList.substring(0, bLList.lastIndexOf(","));
		
		if(autoCancelFlag != "AC") { // EDI Cancel 버튼 클릭시...  
			if(!ComShowConfirm(ComGetMsg(confirmMsgCode) + "\n\n" + "Auto Check B/L No. List \n\n" + bLList)) {
            	// check box checked 해제 
            	sheetObjects[1].CheckAll2("check") = 0;
            	
            	return false;
		    }
			
		} else { // Auto Cancel일 경우
			if(!ComShowConfirm(ComGetMsg(confirmMsgCode) + "\n\n" + "Auto Cancel B/L No. List \n\n" + bLList)) {
            	// send type 조회시 상태로 초기화
            	initSearchValue(sheetObjects[1], "send_type", "AC");
            	
            	// check box checked 해제 
            	sheetObjects[1].CheckAll2("check") = 0;
            	
            	return false;
		    }
		}
	
	}
	
	return true;
	
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

		switch (sName) {
		case "fwrd_id":
			var sUrl = "/hanjin/ESM_BKG_0969.do";
			var rtnVal = ComOpenWindowCenter(sUrl, "ESM_BKG_0969", 600, 400, true);
			if (rtnVal != null) {
				sheetObj.CellValue(Row, 'fwrd_id') = rtnVal.cd;
				// sheetObj.CellValue2(Row, 'fwrd_nm') = rtnVal.nm;
			}
			break;

		case "dg":
			if(formObj.dg_list_local_yn.value == "Y") { // 세관쪽 DG 테이블에 데이타가 있을경우만 팝업을 연다.
				sUrl = "ESM_BKG_0967.do?";
				sParam = "callGubun=ESM_BKG_0965" 
					+ "&d_type="+formObj.d_type.value
					+ "&vvd_cd="+formObj.vvd_cd.value
					+ "&port_cd="+formObj.port_cd.Code
					+ "&bl_no="+sheetObj.CellValue(Row, 'bl_no')
					+ "&bkg_no="+sheetObj.CellValue(Row, 'bkg_no')
					+ "&cntr_no="+sheetObj.CellValue(Row, 'cntr_no')
					+ "&cntr_cgo_seq="+sheetObj.CellValue(Row, 'cntr_cgo_seq')
				    + "&berth_cd="+formObj.frm_brth_yd_cd.value
				    + "&berth_nm="+formObj.frm_yd_nm.value;
				
				
				//alert(sUrl + sParam);
				rtnVal = ComOpenWindowCenter(sUrl + sParam, "ESM_BKG_0967", 1024, 690, true);
				
				//alert("rtnVal : " + rtnVal);
				if (rtnVal != "N") {
					doActionIBSheet(sheetObjects[0], formObj, SEARCH02); // 재조회
				}
				
			} else {
				//ComShowMessage("You can open DG Inquiry only after pressing [Save] button");
				ComShowCodeMessage("BKG06100");
				 
			}

			break;
		case "fdr_vsl_nm" :
		case "fdr_vsl_lloyd_no" :
			
			var sUrl = "/hanjin/ESM_BKG_1097.do";
			var rtnVal = ComOpenWindowCenter(sUrl, "ESM_BKG_1097", 600, 400, true);
			if (rtnVal != null) {
				sheetObj.CellValue(Row, 'fdr_vsl_lloyd_no') = rtnVal.cd;
				sheetObj.CellValue(Row, 'fdr_vsl_nm') = rtnVal.nm;
			}
			
			break;
			
		case "imdg_un_no" :
			//ComOpenPopup("ESM_BKG_0204.do?imdg_un_no=" + sheetObj.CellValue(Row, 'imdg_un_no') + "&bkg_no=" + sheetObj.CellValue(Row, 'bkg_no'), 920, 450, "getCOM_UNNO_POPUP", '1,0,1,1,1,1,1', true, false, 0, 0, 0, "ESM_BKG_0204");
			//ComOpenPopup("ESM_BKG_0204.do?imdg_un_no=" + sheetObj.CellValue(Row, 'imdg_un_no') + "&bkg_no=" + sheetObj.CellValue(Row, 'bkg_no'), 920, 450, "setSheet", '1,0,1,1,1,1,1', true, false, 0, 0, 0, "ESM_BKG_0204");
			ComOpenPopup("ESM_BKG_0204.do?imdg_un_no=" + sheetObj.CellValue(Row, 'imdg_un_no') + "&bkg_no=" + sheetObj.CellValue(Row, 'bkg_no'), 920, 450, "setSheet", '1,0,1,1,1,1,1', true, false, Row, Col, 1);
			break;
		} // end switch

	} // end with

}

/*
 * 2012.03.15
 * input에서 콤보로 바뀌면서 onchange 부분을 따로 처리함 */
function port_cd_OnChange(comboObj) {
	var formObject = document.form;
	
	ComOpenWait(true);
	
	var dType  = formObject.d_type.value;
	var vvdCd  = formObject.vvd_cd.value;
	var portCd = formObject.port_cd.Code;

	
	// vvd, port로 로컬 위험물테이블에 저장된 상태인지 조회한다.
	doActionIBSheet(sheetObjects[0], document.form, SEARCH05);
	
	if(formObject.frm_vsl_cd.value != "") { //vvd필드 변경시 Vessel Code 값 추출후 Vessel Name을 조회한다.
		doActionIBSheet(sheetObjects[0], document.form, SEARCH03);
	}

	
	ComOpenWait(false);
	
	if(dType != "" && vvdCd != "" && portCd != "") {
		doActionIBSheet(sheetObjects[0], formObject, SEARCH06); // DG List Copy 체크박스 활성화/비활성화 판단
	}		
	
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
	
	
	if (srcName == "vvd_cd" ) {//|| srcName == "port_cd" 콤보로 처리함
		
		ComOpenWait(true);
		
		var dType  = formObject.d_type.value;
		var vvdCd  = formObject.vvd_cd.value;
		var portCd = formObject.port_cd.Code;

		if(srcName == "vvd_cd") { // vvd_cd 변경시 Vessel Code에 값 셋팅(vvd_cd의 1-4자리)
			formObject.frm_vsl_cd.value = srcValue.substr(0, 4);
		}
		
		// vvd, port로 로컬 위험물테이블에 저장된 상태인지 조회한다.
		doActionIBSheet(sheetObjects[0], document.form, SEARCH05);
		
		if(formObject.frm_vsl_cd.value != "") { //vvd필드 변경시 Vessel Code 값 추출후 Vessel Name을 조회한다.
			doActionIBSheet(sheetObjects[0], document.form, SEARCH03);
		}

		
		ComOpenWait(false);
		
		if(dType != "" && vvdCd != "" && portCd != "") {
			doActionIBSheet(sheetObjects[0], formObject, SEARCH06); // DG List Copy 체크박스 활성화/비활성화 판단
		}		
		
		//ComSetFocus(formObject.bay_plan_upload_check);
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
	if (srcName == "vvd_cd"  && ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}


/**
 * 시트를 클릭했을 때 처리
 */
function sheet2_OnClick(sheetObj, row, col) {

	var rowCnt = sheetObj.RowCount;
	var check = sheetObj.CellValue(row, "check");
	var mergeBlNo = sheetObj.CellValue(row, "merge_bl_no");
	var sendTypeCheckOrgin = sheetObj.CellValue(row, "send_type_check_orgin");
	var colSaveName = sheetObj.ColSaveName(col);

	/* Row Focus 색상 및 글자  기본값으로 변경 */
	sheetObj.SelectFontBold  = false;
	sheetObj.SelectBackColor = "16186087";
	
	switch(colSaveName) {
		/* 긴 문자열 MemoPad 처리*/
		case "packages" :
		case "prp_shp_nm" :
		case "hzd_desc" :
			ComShowMemoPad(sheetObj, null, null, false, 250, 80);
			break;
			
		/* Check Box 클릭시 머리클릭 처리*/
		case "check" :
			
			for ( var i = row; i <= rowCnt; i++) {

				if (check == 1) {

					if (i == row) continue;

					if (mergeBlNo == sheetObj.CellValue(i, "merge_bl_no")) {
						sheetObj.CellValue2(i, "check") = 0;
					}

				} else if (check == 0) {

					if (i == row) continue;

					if (mergeBlNo == sheetObj.CellValue(i, "merge_bl_no")) {

						sheetObj.CellValue2(i, "check") = 1;

					}

				}
				
			} // end for(i)

			break;
			
			/* Send Type to Original 클릭시*/
		case "send_type_check_orgin" :
			
			for ( var i = 1; i <= rowCnt; i++) {
				if (sendTypeCheckOrgin == 1) {
					if (i == row) continue;
					if (mergeBlNo == sheetObj.CellValue(i, "merge_bl_no")) {
						sheetObj.CellValue2(i, "send_type_check_orgin") = 0;
					}
				} else if (sendTypeCheckOrgin == 0) {
					if (i == row) continue;
					if (mergeBlNo == sheetObj.CellValue(i, "merge_bl_no")) {
						sheetObj.CellValue2(i, "send_type_check_orgin") = 1;
					}
				}
			} // end for(i)

			break;
			
		case "fdr_vsl_nm" :
		case "fdr_vsl_lloyd_no" :
			break;
		
	} // end switch

}

/**
 * sheet2 Change 이벤트
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function sheet2_OnChange(sheetObj, row, col, value) {
	
	var rowCnt = sheetObj.RowCount;
	var colSaveName = sheetObj.ColSaveName(col);
	var formObj = document.form;
	
	switch(colSaveName) {

		case "imdg_clss_cd":
		case "imdg_un_no":
		case "dg_short_nm":
			if(sheetObj.CellValue(row, "c_type") == "V") { // Carriage Type = Marintime
				setMandatoryFeederInfo(row,true);
			}
		break;
	
		case "fwrd_id":
			var preKey = "";
			var currKey = "";
			var nextKey = "";
			
			var blNo = sheetObj.CellValue(row, "bl_no");
			
			if(blNo != "") {
			
				currKey = blNo;
				
				// fwrd_id 값 변경시 다음 로우도 같은 키값이면... 같은fwrd_id 값은 복사해 준다.
				for(var i = row; i <= rowCnt; i++) {
					
					nextKey = sheetObj.CellValue(i+1, "bl_no");
					
					if(currKey == nextKey) {
						sheetObj.CellValue2(i+1, "fwrd_id") = value;
					} else {
						break;
					}
				} // end for(i)

				// fwrd_id 값 변경시 이전 로우도 같은 키값이면... 같은 fwrd_id 값은 복사해 준다.
				for(var i = row; i >= 1; i--) {
					
					preKey  = sheetObj.CellValue(i-1, "bl_no");
					
					if(preKey == currKey) {
						sheetObj.CellValue2(i-1, "fwrd_id") = value;
					} else {
						break;
					}
				} // end for(i)
				
			}
			
			if(sheetObj.CellValue(row, "c_type") == "V") { // Carriage Type = Marintime
				setMandatoryFeederInfo(row,true);
			}
			break;

		//case "agent":
		case "c_type":
			
			if(sheetObj.CellValue(row, "c_type") == "V") { // Carriage Type = Marintime
				setMandatoryFeederInfo(row,true);
			} else {
				setMandatoryFeederInfo(row,false);
			}
			
			var preKey = "";
			var currKey = "";
			var nextKey = "";
			
			var blNo = sheetObj.CellValue(row, "bl_no");
			var cntrNo = sheetObj.CellValue(row, "cntr_no");
			
			if(blNo != "") {
			
				currKey = blNo + cntrNo;
				
				// c_type값 변경시 다음 로우도 같은 키값이면... 같은 c_type값은 복사해 준다.
				for(var i = row; i <= rowCnt; i++) {
					
					nextKey = sheetObj.CellValue(i+1, "bl_no") + sheetObj.CellValue(i+1, "cntr_no");

					if(currKey == nextKey) {
						sheetObj.CellValue2(i+1, "c_type") = value;
					} else {
						break;
					}
				} // end for(i)

				// c_type값 변경시 이전 로우도 같은 키값이면... 같은c_type값은 복사해 준다.
				for(var i = row; i >= 1; i--) {
					
					preKey  = sheetObj.CellValue(i-1, "bl_no") + sheetObj.CellValue(i-1, "cntr_no");
					
					if(preKey == currKey) {
						sheetObj.CellValue2(i-1, "c_type") = value;
					} else {
						break;
					}
				} // end for(i)
				
			}
			break;
			
		case "bl_no" :
			formObj.cond_type.value = "bl_no";
			formObj.cond_value.value = value;
			doActionIBSheet(sheetObjects[1],formObj,SEARCH11, row, col); // input validation
			break;
		case "pol_cd" : 
			formObj.cond_type.value = "pol_cd";
			formObj.cond_value.value = value;
			doActionIBSheet(sheetObjects[1],formObj,SEARCH11, row, col); // input validation
			break;
		case "pod_cd" : 
			formObj.cond_type.value = "pod_cd";
			formObj.cond_value.value = value;
			doActionIBSheet(sheetObjects[1],formObj,SEARCH11, row, col); // input validation
			break;
			
		case "cntr_no" :			
			formObj.cond_type.value = "cntr_no";
			formObj.cond_value.value = value;
			doActionIBSheet(sheetObjects[1],formObj,SEARCH12, row, col); // input validation
			break;
			
		case "fdr_vsl_nm" :
			
			
			var preKey = "";
			var currKey = "";
			var nextKey = "";
			
			var blNo = sheetObj.CellValue(row, "bl_no");
			var cntrNo = sheetObj.CellValue(row, "cntr_no");
			
			if(blNo != "") {
			
				currKey = blNo + cntrNo;
				
				// fdr_vsl_nm 값 변경시 다음 로우도 같은 키값이면... 같은 fdr_vsl_nm 값은 복사해 준다.
				for(var i = row; i <= rowCnt; i++) {
					
					nextKey = sheetObj.CellValue(i+1, "bl_no") + sheetObj.CellValue(i+1, "cntr_no");
					
					if(currKey == nextKey) {
						sheetObj.CellValue2(i+1, "fdr_vsl_nm") = value;
					} else {
						break;
					}
				} // end for(i)

				// fdr_vsl_nm 값 변경시 이전 로우도 같은 키값이면... 같은 fdr_vsl_nm 값은 복사해 준다.
				for(var i = row; i >= 1; i--) {
					
					preKey  = sheetObj.CellValue(i-1, "bl_no") + sheetObj.CellValue(i-1, "cntr_no");
					
					if(preKey == currKey) {
						sheetObj.CellValue2(i-1, "fdr_vsl_nm") = value;
					} else {
						break;
					}
				} // end for(i)
				
			}
			break;
		case "fdr_vsl_lloyd_no" :
	
			
			var sName = sheetObj.GetComboInfo(row, "fdr_vsl_nm", "Code");
			var sCode = sheetObj.GetComboInfo(row, "fdr_vsl_lloyd_no", "Code");
			var arrName = sName.split("|");
			var arrCode = sCode.split("|");
			
			var idx   = sheetObj.GetComboInfo(row, colSaveName, "SelectedIndex");

			//alert(arrName[idx] + "||" + arrCode[idx]);
			
//			if(colSaveName == "fdr_vsl_nm") {
//				sheetObj.CellValue(row, "fdr_vsl_lloyd_no") = (arrCode[idx]=="") ? "" :arrCode[idx];
//			} else {				
//				sheetObj.CellValue(row, "fdr_vsl_nm") = (arrName[idx]=="") ? "" : arrName[idx];
//			}
			
			var preKey = "";
			var currKey = "";
			var nextKey = "";
			
			var blNo = sheetObj.CellValue(row, "bl_no");
			var cntrNo = sheetObj.CellValue(row, "cntr_no");
			
			if(blNo != "") {
			
				currKey = blNo + cntrNo;
				
				// fdr_vsl_lloyd_no 값 변경시 다음 로우도 같은 키값이면... 같은 fdr_vsl_lloyd_no 값은 복사해 준다.
				for(var i = row; i <= rowCnt; i++) {
					
					nextKey = sheetObj.CellValue(i+1, "bl_no") + sheetObj.CellValue(i+1, "cntr_no");
					
					if(currKey == nextKey) {
						sheetObj.CellValue2(i+1, "fdr_vsl_lloyd_no") = value;
					} else {
						break;
					}
				} // end for(i)

				// fdr_vsl_lloyd_no 값 변경시 이전 로우도 같은 키값이면... 같은 fdr_vsl_lloyd_no 값은 복사해 준다.
				for(var i = row; i >= 1; i--) {
					
					preKey  = sheetObj.CellValue(i-1, "bl_no") + sheetObj.CellValue(i-1, "cntr_no");
					
					if(preKey == currKey) {
						sheetObj.CellValue2(i-1, "fdr_vsl_lloyd_no") = value;
					} else {
						break;
					}
				} // end for(i)
				
			}
			
			break;
			
		case "crr_dt" :
			
			var preKey = "";
			var currKey = "";
			var nextKey = "";
			
			var blNo = sheetObj.CellValue(row, "bl_no");
			var cntrNo = sheetObj.CellValue(row, "cntr_no");
			
			if(blNo != "") {
			
				currKey = blNo + cntrNo;
				
				// crr_dt값 변경시 다음 로우도 같은 키값이면... 같은 crr_dt값은 복사해 준다.
				for(var i = row; i <= rowCnt; i++) {
					
					//currKey = sheetObj.CellValue(i, "bl_no");
					nextKey = sheetObj.CellValue(i+1, "bl_no") + sheetObj.CellValue(i+1, "cntr_no");
					
					if(currKey == nextKey) {
						sheetObj.CellValue2(i+1, "crr_dt") = value;
					} else {
						break;
					}
				} // end for(i)

				// crr_dt값 변경시 이전 로우도 같은 키값이면... 같은 crr_dt값은 복사해 준다.
				for(var i = row; i >= 1; i--) {
					
					preKey  = sheetObj.CellValue(i-1, "bl_no") + sheetObj.CellValue(i-1, "cntr_no"); 
					//currKey = sheetObj.CellValue(i, "bl_no");
					
					if(preKey == currKey) {
						sheetObj.CellValue2(i-1, "crr_dt") = value;
					} else {
						break;
					}
				} // end for(i)
				
			}
			break;
			
		case "fdr_svc_rqst_no":			

			var preKey = "";
			var currKey = "";
			var nextKey = "";
			
			var blNo = sheetObj.CellValue(row, "bl_no");
			var cntrNo = sheetObj.CellValue(row, "cntr_no");
			
			if(blNo != "") {
			
				currKey = blNo + cntrNo;
				
				// fdr_svc_rqst_no 값 변경시 다음 로우도 같은 키값이면... 같은 fdr_svc_rqst_no 값은 복사해 준다.
				for(var i = row; i <= rowCnt; i++) {
					
					nextKey = sheetObj.CellValue(i+1, "bl_no") + sheetObj.CellValue(i+1, "cntr_no");
					
					if(currKey == nextKey) {
						sheetObj.CellValue2(i+1, "fdr_svc_rqst_no") = value;
					} else {
						break;
					}
				} // end for(i)

				// fdr_svc_rqst_no 값 변경시 이전 로우도 같은 키값이면... 같은 fdr_svc_rqst_no 값은 복사해 준다.
				for(var i = row; i >= 1; i--) {
					
					preKey  = sheetObj.CellValue(i-1, "bl_no") + sheetObj.CellValue(i-1, "cntr_no");
					
					if(preKey == currKey) {
						sheetObj.CellValue2(i-1, "fdr_svc_rqst_no") = value;
					} else {
						break;
					}
				} // end for(i)
				
			}
			break;
			
		case "fdr_vvd_id" :

			var preKey = "";
			var currKey = "";
			var nextKey = "";
			
			var blNo = sheetObj.CellValue(row, "bl_no");
			var cntrNo = sheetObj.CellValue(row, "cntr_no");
			
			if(blNo != "") {
			
				currKey = blNo + cntrNo;
				
				// fdr_vvd_id 값 변경시 다음 로우도 같은 키값이면... 같은 fdr_vvd_id 값은 복사해 준다.
				for(var i = row; i <= rowCnt; i++) {
					
					nextKey = sheetObj.CellValue(i+1, "bl_no") + sheetObj.CellValue(i+1, "cntr_no");
					
					if(currKey == nextKey) {
						sheetObj.CellValue2(i+1, "fdr_vvd_id") = value;
					} else {
						break;
					}
				} // end for(i)

				// fdr_vvd_id 값 변경시 이전 로우도 같은 키값이면... 같은 fdr_vvd_id 값은 복사해 준다.
				for(var i = row; i >= 1; i--) {
					
					preKey  = sheetObj.CellValue(i-1, "bl_no") + sheetObj.CellValue(i-1, "cntr_no");
					
					if(preKey == currKey) {
						sheetObj.CellValue2(i-1, "fdr_vvd_id") = value;
					} else {
						break;
					}
				} // end for(i)
				
			}
			
			break;	
			
	}
	
}	

/**
 * 상세화면을 오픈한다.
 * 
 * @return
 */
function openDetail(sheetObj,Row) {
	
	if(sheetObj.RowCount == 0) {
		ComShowCodeMessage('BKG00095');
		return false;
	}
	
    var formObj = document.form;
	
	var sUrl = "ESM_BKG_0970_P.do?";
	var sParam = "callGubun=ESM_BKG_0965" 
	+ "&d_type="+formObj.d_type.value
	+ "&vvd_cd="+formObj.vvd_cd.value
	+ "&port_cd="+formObj.port_cd.Code
	+ "&bl_no="+sheetObj.CellValue(Row, 'bl_no')
	+ "&cntr_no="+sheetObj.CellValue(Row, 'cntr_no')
	+ "&cntr_cgo_seq="+sheetObj.CellValue(Row, 'cntr_cgo_seq');
	
	//alert(sUrl + sParam);
	rtnVal = ComOpenWindowCenter(sUrl + sParam, "ESM_BKG_0970_P", 1020, 600, true);
}


/**
 * 데이터 영역의 셀을 마우스로 더블클릭했을 때 발생하는 Event
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet2_OnDblClick(sheetObj,Row,Col) {
	
	var colSaveName = sheetObj.ColSaveName(Col);
	
	switch(colSaveName) {
		case "seq" :
		case "bl_no" :
		case "pol_cd" :
		case "pod_cd" :
		case "cntr_no" :
			
			if(!sheetObj.CellEditable(Row, colSaveName)) {
				//alert("colSaveName : " + colSaveName + "\n editable : " + sheetObj.CellEditable(Row, colSaveName) + "\nsheetObj.MouseRow : " + sheetObj.MouseRow );
				
				openDetail(sheetObj,sheetObj.MouseRow);
			}
			
			break;
	} // end switch()
	
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
	
 	sheetObj.CellValue(row, "imdg_un_no") = imdgUnNo;
 	sheetObj.CellValue(row, "imdg_un_no_seq") = imdgUnNoSeq;
 	sheetObj.CellValue(row, "imdg_clss_cd") = imdgClssCd;
 	sheetObj.CellValue(row, "imdg_comp_grp_cd") = imdgCompGrpCd;
 	
 	sheetObj.CellValue(row, "ems_no") = emsNo;
 	sheetObj.CellValue(row, "imdg_pck_grp_cd") = imdgPckGrpCd;

}