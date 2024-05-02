﻿/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_cni_0018.js
 *@FileTitle : [CPS_CNI_0018] Status
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.05.20
 *@LastModifier : 표준희
 *@LastVersion : 1.0
 * 2009.11.05 표준희
 * 1.0 Creation
 *----------------------------------------------------------
 * History
 * 2010.05.20 [CHM-201110840-01] 표준희
 * 제목 :CNI Status 화면-조회 옵션 보완
 * 내용 : Area 조회 옵션의 Dropdown 
 * Dropdown에 체크 박스를 두어 멀티 선택이 가능하도록 한다
 * Multi 선택 시, 선택 표시 창에 약자를 (,)를 두어 모두 표시한다
 * ex) America, Europe 선택 시 -> A, E
=========================================================*/



/**
 * [CPS_CNI_0018] Status
 * 
 * @extends
 * @class Status 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function cps_cni_0018() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject     = setSheetObject;
	this.setComboObject     = setComboObject;
	this.loadPage           = loadPage;
	this.initSheet          = initSheet;
	this.initControl        = initControl;
	this.initCombo         	= initCombo;
	this.doActionIBSheet    = doActionIBSheet;
	this.validateForm       = validateForm;
}

// 공통전역변수

//IBSheet 
var sheetObjects = new Array();
var sheetCnt = 0;
var sheet1 = null;
//HTML Form
var frm = null;
var frm2 = null;

//IBmultiCombo
var comboObjects = new Array();
var comboCnt = 0;

var area_cd = "";//area cd

var mainCode = "";
var locationCode = "";

//By Area Setting
var byAreaHeadTitle = "|seq|cgo_clm_div_cd|cgo_clm_no|clm_area_cd|hdlr_ofc_cd|cgo_clm_sts_cd|lit|hdlr_usr_id1|hpd|nhp|prlm_clm_ntc_dt|fmal_clm_rcv_dt|upd_dt|clmt_clm_tp_cd|clm_pty_abbr_nm1|trnk_ref_vvd_no|cgo_clm_ref_bl_no|crr_term_cd|por_cd|pol_cd|pod_cd|del_cd|fvd|n1st_pre_ts_loc_cd|n1st_pst_ts_loc_cd|clm_cgo_tp_nm|cgo_clm_tp_cd|mjr_clm_dmg_lss_cd|n3rd_labl_pty_cd|clmt_usd_amt|cgo_clm_stl_tp_cd|cgo_clm_stl_dt|cgo_clm_stl_usd_amt|labl_pty_rcvr_usd_amt";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * IBCombo Object를 배열에 등록
 * @param comboObj
 **/
function setComboObject(comboObj){
	comboObjects[comboCnt++] = comboObj;
}

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	var sheetObject1 = sheetObjects[0];

	var frm = document.form;
	
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
			case "btn1_Inquiry by Class":
				var url = "CPS_CNI_0019.do";
				var display = "0,0,1,1,0,1,1,1,1,0,1,1";
				var win1 = ComOpenWindowCenter(url, "ClassWin", 600, 560, "", display);
				win1.focus();
				
				break;
			case "btn_Retrieve":
				sheet1.RemoveAll();//append mode로 paging 처리하므로 remove 해야함.
				frm.page_no.value = "1";
				doActionIBSheet(SEARCHLIST01);
				break;
	
			case "btn1_New":
				//if (ComShowCodeConfirm("CNI00015") ) { // "CNI00015=Do you want to initialize?"
				ComResetAll();
				ComSetObjValue(frm.from_period,ComGetNowInfo("yy") + "-01-01");
				ComSetObjValue(frm.to_period,ComGetNowInfo());
				ComSetObjValue(frm.period,"DON");
				ComSetObjValue(frm.vt, "G");
				ComSetObjValue(frm.status, "All");
				ComSetObjValue(frm.area, "All");
				for(var i = 0 ; i < frm.area.GetCount() ; i++) {
					frm.area.CheckIndex(i) = 1;
			 }				
				// By Area 선택 (전체 컬럼중에서 Inquery By Class 중 )
				setTemplate("63", "By Area",  byAreaHeadTitle);
				//}	
				break;
	
			case "btn1_DownExcel":
				sheet1.SpeedDown2Excel(1)
				break;
	
			case "btn1_Print":
				frm.page_no.value = ""; //페이지 번호 삭제
				doActionIBSheet(PRINT);
				break;
			
			case "btn1_Cargo":
				popupMainMiscView("15");
				break;

			case "btn1_TOC":
				popupMainMiscView("11");
				break;

			case "btn1_CODL1":
				popupMainMiscView("02");
				break;

			case "btn1_CODL2":
				popupMainMiscView("39");
				break;
		  
			case "btn1_POI":
				popupMainMiscView("14");
				break;
		  
			case "btn1_POR":
				//공통팝업 Location호출
				var locCd = frm.por_cd.value;
				locationCode = "POR";
				popupLocation(locCd);
				break;
				
			case "btn1_DEL":
				//공통팝업 Location호출
				var locCd = frm.del_cd.value;
				locationCode = "DEL";
				popupLocation(locCd);
				break ;	 
		    	
			case "btn1_Liable_Party":
			case "btn1_Surveyor":
			case "btn1_Claimant": 
			case "btn1_Claimant_Agent":
			case "btn1_Salvager":
			case "btn1_Insurer":
				mainCode = srcName.replace("btn1_", "").toLowerCase();
				popupMainCodeInquiry();
				break;	
			case "btn1_Approver":
				ComOpenPopupWithTarget("COM_ENS_091.do", 780, 560, "usr_id:clm_stl_auth_usr_id", "1,0,1,1,1", true);
				break;
			case "btn1_Handler":
				ComOpenPopupWithTarget("COM_ENS_091.do", 780, 560, "usr_id:hdlr_usr_id", "1,0,1,1,1", true);
				break;
			case "btns_from_period":
			case "btns_to_period":
				var result = srcName.replace("btns_", "");
			    calObj = eval("frm." + result );
				var vCal = new ComCalendar();
				vCal.setDisplayType('date');
				vCal.select(calObj, 'yyyy-MM-dd');
				break;
			case "btns_hndl_ofc_cd":
				popupOfficeCode();
				break;
				
		} // end switch
	} catch (e) {
		if( e == "[object Error]") {
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
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++] = sheet_obj;	
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

	frm = document.form;
	frm2 = document.form2;
	sheet1 = sheetObjects[0];
	sheetCnt = sheetObjects.length;
	// 시트 초기화
	for ( var i = 0; i < sheetCnt; i++) {

		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	// By Area 선택 (전체 컬럼중에서 Inquery By Class 중 )
	setTemplate("63", "By Area",  byAreaHeadTitle);
	
	
	// IBMultiCombo초기화
	comboCnt = comboObjects.length;
	
	for(var j=0; j<comboCnt; j++){
		initCombo(comboObjects[j],j+1);
	}
	
	initComboBoxValue();
	
	//Form 이벤트 등록
	initControl();
	
	//Period 기간 초기값 셋팅(GMT기준)
	var sXml2 = document.form2.sXml.value;
	var arrXml = sXml2.split("|$$|");
	
	var vCurDate = ComGetEtcData(arrXml[0], "CurrentDate");	
	if (ComIsDate(vCurDate)){
		ComSetObjValue(frm.from_period, vCurDate.substring(0,4) + "-01-01");
		ComSetObjValue(frm.to_period, vCurDate);
	}
	//area all select 
	for(var i = 0 ; i < frm.area.GetCount() ; i++) {
			frm.area.CheckIndex(i) = 1;
	}
	
	// 포커싱
	ComSetFocus(frm.period);
}
 

/**
  * Combo 기본 설정 
  * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
  * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
  **/
function initCombo(comboObj, comboNo) {

 	with (comboObj) {
 		comboObj.MultiSelect = false;
 		comboObj.UseCode = true;
 		comboObj.LineColor = "#ffffff";
		comboObj.SetColAlign("left|left");
 		comboObj.MultiSeparator = ",";
 		comboObj.DropHeight = 175;
 		if (comboNo > 3){
		    comboObj.BackColor = "#FFFFFF";
		} else {
			comboObj.BackColor = "#CCFFFD";
		}
 	}
} 
 /**
 * 초기 콤보 설정
 **/
function initComboBoxValue() {
	
	var sXml2 = document.form2.sXml.value;	
	var arrXml = sXml2.split("|$$|");
	var idx = 0;
	
	setMultiComboBox("period" ,  arrXml[idx] ); //Type of Period Date(36)
	ComSetObjValue(frm.period, "DON");
	idx++;
	
	setMultiComboBox("area" ,  arrXml[idx] ); //2. Area(09)
	idx++;
	
 	setMultiComboBox("status" ,  arrXml[idx] ); //3. Status Type(08)
	idx++;
	
	setMultiComboBox("cgo_clm_stl_tp_cd" ,  arrXml[idx] ); //4.Type of Settlement(07)
	idx++;
	
	setMultiComboBox("crr_term_cd" ,  arrXml[idx] ); //5.Carriage Term (06)
	idx++;
	
	setMultiComboBox("inci_plc_tp_cd" ,  arrXml[idx] ); //6.Place of Incident(14)
	idx++;
	
	setMultiComboBox("cgo_clm_tp_cd" ,  arrXml[idx] ); //7.Place of Incident(11)
	idx++;
	
 	// Area Cd Setting
 	var dataCount = ComGetTotalRows(arrXml[idx]);
 	if (dataCount > 0) {
 		var list = SheetXml2ListMap(arrXml[idx]);	
 		var listVO = list[0];
 		clmAreaCd = listVO["clm_area_cd"];
 		area_cd = clmAreaCd;
 		ComSetObjValue(frm.area, clmAreaCd);
 		ComSetObjValue(frm.usr_area, clmAreaCd);
	} 
 	ComSetObjValue(frm.vt, "G");
} 
/**
* Form 이벤트 등록
**/
function initControl() {
	axon_event.addListenerForm('keypress',        'obj_keypress', frm);
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', frm);
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', frm);
	axon_event.addListenerForm('keyup',			   'obj_keyup', frm); 
	//keydown
	axon_event.addListener  ('keydown', 'ComKeyEnter', 'form');
}

/**
  * 시트 초기설정값, 헤더 정의
  * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
  * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
  */
function initSheet(sheetObj,sheetNo) {
   var cnt = 0;
   switch(sheetObj.id) {
            case "sheet1":      //sheet1 init
                with (sheetObj) {
                    // 높이 설정
					style.height = 242;
										
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 15, CNI_PAGE_SIZE);

					var HeadTitle1 = "|Seq.|Class|Claim No.|A|HOFC|ROFC|Handler|Manager|STS|LIT|DOC|HPD|NHP|DON|DOF|DOU|" +
									 "T|Claimant|Claimant’s Agent|Lane|VVD|B/L No.|CNTR No.|TP/SZ|CNT|CT|POR|DOR|POL|POD|DEL|" +
									 "DDL|DOTB|LP DOTB|FVD|PRE_POT|ON_POT|Cargo|TOC|CODL|3rd Liable Party|Claim Amount|" +
									 "DOAK|DOFF|TOS|DOS|Settled Amount|POI|Liable Party|LP HOFC|LP DOF|LP CAMT|LP DOR|LP RAMT|Insurer|INS DOF|INS CAMT|INS DOR|INS RAMT|" +
									 "Surveyor|DOSV|Survey Fee|Salvager|DOSL|SL Amount|Applicant|APOFC|DOAP|Approver|AVSTS|AVOFC|DOAV|Approval No.|" +
									 "Plaintiff|PL Attorney|Court|Case No.|DOSSV|Defendant|Def. Attorney|DODAA|Legal Costs|" +
									 "INC No.|VOC No.|Period 1|Period 2|Period 3|Period 4|Period 5|Period 6";
					var headCount = ComCountHeadTitle(HeadTitle1);
										
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 4, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
                   
					//데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");

					InitDataProperty(0, cnt++ , dtSeq,			50,		daCenter,	true,		"seq",					false,      "",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			35,		daCenter,	true,		"cgo_clm_div_cd",		false,		"",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			75,		daCenter,	true,		"cgo_clm_no",			false,      "",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			25,		daCenter,	true,		"clm_area_cd",			false,		"",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"hdlr_ofc_cd",			false,      "",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"fmal_clm_rcv_ofc_cd",	false,		"",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"hdlr_usr_id1",			false,      "",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"hdlr_usr_id2",			false,		"",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,		"cgo_clm_sts_cd",		false,      "",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			25,		daCenter,	true,		"lit",					false,		"",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	true,		"cs_clz_dt",			false,      "",	dfDateYmd,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtAutoAvg,		50,		daRight,	true,		"hpd",					false,		"",	dfNullInteger,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtAutoAvg,		50,		daRight,	true,		"nhp",					false,      "",	dfNullInteger,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	true,		"prlm_clm_ntc_dt",		false,		"",	dfDateYmd,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	true,		"fmal_clm_rcv_dt",		false,      "",	dfDateYmd,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	true,		"upd_dt",				false,		"",	dfDateYmd,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			25,		daCenter,	true,		"clmt_clm_tp_cd",		false,      "",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			75,		daLeft,		true,		"clm_pty_abbr_nm1",		false,      "",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	true,		"clm_pty_abbr_nm2",		false,		"",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,		"slan_cd",				false,      "",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"trnk_ref_vvd_no",		false,		"",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,	    "cgo_clm_ref_bl_no",	false,		"",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,		"cgo_clm_ref_cntr_no",	false,      "",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"tp_sz",				false,		"",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,		50,		daRight,	true,		"cnt",				   	false,		"",	dfNullInteger,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,		"crr_term_cd",			false,      "",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"por_cd",				false,		"",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	true,		"rct_dt",				false,		"",	dfDateYmd,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"pol_cd",				false,      "",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"pod_cd",				false,		"",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"del_cd",				false,      "",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	true,		"de_dt",				false,		"",	dfDateYmd,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	true,		"clm_tm_bar_dt",		false,      "",	dfDateYmd,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	true,		"labl_tm_bar_dt",		false,		"",	dfDateYmd,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	    "fvd",					false,		"",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,		"n1st_pre_ts_loc_cd",	false,      "",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,		"n1st_pst_ts_loc_cd",	false,		"",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			80,		daLeft,		true,		"clm_cgo_tp_nm",		false,      "",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,		"cgo_clm_tp_cd",		false,		"",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,		"mjr_clm_dmg_lss_cd",	false,      "",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"n3rd_labl_pty_cd",		false,		"",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	true,		"clmt_usd_amt",			false,      "",	dfFloat,	2,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	true,		"cgo_clm_acknak_dt",	false,		"",	dfDateYmd,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	true,		"fact_fnd_dt",			false,		"",	dfDateYmd,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,		"cgo_clm_stl_tp_cd",	false,		"",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	true,		"cgo_clm_stl_dt",		false,      "",	dfDateYmd,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	true,		"cgo_clm_stl_usd_amt",	false,		"",	dfFloat,	2,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	    "inci_plc_tp_cd",		false,		"",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			80,		daLeft,		true,		"labl_clm_pty_no",		false,      "",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,		"hndl_ofc_cd",			false,		"",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	true,		"labl_pty_fmal_clm_dt",	false,      "",	dfDateYmd,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,	   	100,	daRight,	true,		"labl_pty_dmnd_amt",	false,		"",	dfFloat,	2,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	true,		"labl_pty_rcvr_dt",		false,      "",	dfDateYmd,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	true,		"labl_pty_rcvr_usd_amt",false,		"",	dfFloat,	2,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"insur_pty_abbr_nm",	false,      "",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	true,		"insur_fmal_clm_dt",	false,      "",	dfDateYmd,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	true,		"insur_dmnd_amt",		false,      "",	dfFloat,	2,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"ins_dor",				false,		"",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	true,		"insur_rcvr_amt",		false,      "",	dfFloat,	2,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"svey_clm_pty_abbr_nm",	false,		"",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	true,	    "svey_inp_dt",			false,		"",	dfDateYmd,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	true,		"svyr_fee_usd_amt",		false,      "",	dfFloat,	2,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"slaver_clm_pty_abbr_nm",false,		"",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	true,		"slv_dt",				false,      "",	dfDateYmd,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	true,		"slv_usd_amt",			false,		"",	dfFloat,	2,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"applicant",			false,      "",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"apofc",				false,		"",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"doap",					false,      "",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"approver",				false,		"",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"avsts",				false,      "",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"avofc",				false,		"",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	    "doav",					false,		"",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"approval_no",			false,      "",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"plt_nm",				false,		"",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,		"agn_clm_pty_abbr_nm",				false,		"",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"crt_nm",				false,      "",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"crt_cs_no",			false,		"",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	true,		"smns_sve_dt",			false,      "",	dfDateYmd,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"deft_nm",				false,		"",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,		"clm_pty_abbr_nm3",		false,      "",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	true,		"deft_atty_apnt_dt",	false,		"",	dfDateYmd,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	true,		"legal_costs",			false,      "",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"cgo_clm_inci_no",		false,		"",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	    "crm_voc_no",			false,		"",	dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtAutoAvg,		60,		daRight,	true,		"period1",				false,      "",	dfInteger,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtAutoAvg,		60,		daRight,	true,		"period2",				false,		"",	dfInteger,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtAutoAvg,		60,		daRight,	true,		"period3",				false,      "",	dfInteger,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtAutoAvg,		60,		daRight,	true,		"period4",				false,		"",	dfInteger,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtAutoAvg,		60,		daRight,	true,		"period5",				false,      "",	dfInteger,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtAutoAvg,		60,		daRight,	true,		"period6",				false,		"",	dfInteger,	0,			true,		true);

					CountFormat = "[SELECTDATAROW / TOTALROWS]";
					
					
               }

                break;
   }
}
 
 /**
  * row double click 시 CPS_CNI_0003 팝업창 띄움
  * @param {IBSheet} sheet
  * @param {long} row 해당 셀의 Row Index
  * @param {long} col 해당 셀의 Column Index
  */

function sheet1_OnDblClick(sheet, row, col) {
 	var cgoClmNo = sheet1.CellValue(row , "cgo_clm_no");
 	//var sUrl = "CPS_CNI_0003_01.do?pgmNo=CPS_CNI_0003&ENU=Y&popupYn=Y&cgo_clm_no="+cgoClmNo; //메뉴없는 창 띄울때	
 	var sUrl = "/hanjin/alpsMain.screen?parentPgmNo=CPS_CNI_M001&pgmUrl=^hanjin^CPS_CNI_0003.do&mainPage=true&pgmNo=CPS_CNI_0003&cgo_clm_no="+cgoClmNo;
 	var winName = "CPS_CNI_0003";
  	var reqWin = ComOpenWindow(sUrl,winName,"width=1024,height=700, resizable=yes, scrollbars=yes, status=no");
 }
 
function sheet1_OnSearchEnd(sheet, ErrMsg) {

	if (sheet.RowCount <= 0) {
		ComShowCodeMessage("CNI00013");//msgs["CNI00013"] = "There is no data to search.";
	}
}

function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
	frm.page_no.value = PageNo;
	doActionIBSheet(SEARCHLIST01);
}   

//focus in
function obj_activate(){
	obj = event.srcElement;
	//readonly 일때 데이터 포맷 변경되는 것  방지
	if (obj.getAttribute("readOnly")) return;
	ComClearSeparator(obj);
} 

// focus out
function obj_deactivate(){
	obj = event.srcElement;
	
	ComChkObjValid(obj);
	if (obj.name == "clm_cgo_tp_cd")  {
		if (ComIsNull(obj.value)) {
			ComSetObjValue(frm.clm_cgo_tp_nm,"");
		}
		return;
	}
	if (ComIsNull(obj.value)) {
		return;
	}
}

/**
 * HTML Control KeyPress 이벤트 호출
 **/
function obj_keypress() {
	obj = event.srcElement;
	
    if(obj.dataformat == null) return;
    
    window.defaultStatus = obj.dataformat;

    switch(obj.dataformat) {
        case "ymd":
        case "ym":
        case "hms":
        case "hm":
        case "jumin":
        case "saupja":
            ComKeyOnlyNumber(obj);
            break;
        case "int":
            if(obj.name=="txtInt") ComKeyOnlyNumber(obj, "-")
            else ComKeyOnlyNumber(obj);
            break;
        case "float":
            ComKeyOnlyNumber(obj, "-.");
            break;
        case "eng":
            ComKeyOnlyAlphabet(); 
            break;
        case "engup":
            ComKeyOnlyAlphabet('uppernum');
            break;
        case "engdn":
            if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
            else ComKeyOnlyAlphabet('lower');
            break;
    }
}
/**
 * HTML Control KeyUp 이벤트 호출
 **/
function obj_keyup() {
}

 
// Sheet관련 프로세스 처리
function doActionIBSheet(sAction) {
	frm.f_cmd.value = sAction;
	
	switch (sAction) {
		case SEARCHLIST01: // Retrieve
			if (validateForm(sAction)) {
				var from_period = ComGetObjValue(frm.from_period);
				var to_period = ComGetObjValue(frm.to_period);
				var from_clmt_usd_amt = ComGetObjValue(frm.from_clmt_usd_amt);
				var to_clmt_usd_amt = ComGetObjValue(frm.to_clmt_usd_amt);
				var from_cgo_clm_stl_usd_amt = ComGetObjValue(frm.from_cgo_clm_stl_usd_amt);
				var to_cgo_clm_stl_usd_amt = ComGetObjValue(frm.to_cgo_clm_stl_usd_amt);
				// Form Object Mask Clear
				ComClearSeparator(frm.from_period);
				ComClearSeparator(frm.to_period);
				ComClearSeparator(frm.from_clmt_usd_amt);
				ComClearSeparator(frm.to_clmt_usd_amt);
				ComClearSeparator(frm.from_cgo_clm_stl_usd_amt);
				ComClearSeparator(frm.to_cgo_clm_stl_usd_amt);
				// Form Object Data 
				var vFormData = FormQueryString(frm);
				
				ComSetObjValue(frm.from_period,from_period);
				ComSetObjValue(frm.to_period,to_period);
				ComSetObjValue(frm.from_clmt_usd_amt,from_clmt_usd_amt);
				ComSetObjValue(frm.to_clmt_usd_amt,to_clmt_usd_amt);
				ComSetObjValue(frm.from_cgo_clm_stl_usd_amt,from_cgo_clm_stl_usd_amt);
				ComSetObjValue(frm.to_cgo_clm_stl_usd_amt,to_cgo_clm_stl_usd_amt);
				
				//페이지 번호 셋팅
				// Request
				var sXml = sheet1.GetSearchXml("CPS_CNI_0018GS.do", vFormData ,"",true );
				//에러 체크
				if (getErrorMsg(sheet1,sXml)) {
					return;
				}
				
				var list = SheetXml2ListMap(sXml);
				if (list.length == 0) {
					ComShowCodeMessage("CNI00013");
				} else {
				    sheet1.LoadSearchXml(sXml, true);
				    sheet1.SumText(0,"seq")="TOTAL";
				}  
				
			}
			break;
		case PRINT:
			if (validateForm(sAction)) {
				
				var from_period = ComGetObjValue(frm.from_period);
				var to_period = ComGetObjValue(frm.to_period);
				var from_clmt_usd_amt = ComGetObjValue(frm.from_clmt_usd_amt);
				var to_clmt_usd_amt = ComGetObjValue(frm.to_clmt_usd_amt);
				var from_cgo_clm_stl_usd_amt = ComGetObjValue(frm.from_cgo_clm_stl_usd_amt);
				var to_cgo_clm_stl_usd_amt = ComGetObjValue(frm.to_cgo_clm_stl_usd_amt);
				// Form Object Mask Clear
				ComClearSeparator(frm.from_period);
				ComClearSeparator(frm.to_period);
				ComClearSeparator(frm.from_clmt_usd_amt);
				ComClearSeparator(frm.to_clmt_usd_amt);
				ComClearSeparator(frm.from_cgo_clm_stl_usd_amt);
				ComClearSeparator(frm.to_cgo_clm_stl_usd_amt);
				ComSetObjValue(frm.com_mrdArguments, "");
				ComSetObjValue(frm.com_mrdBodyTitle, "");
				ComSetObjValue(frm.com_mrdPath, "");
				// Form Object Data 
				var vFormData = FormQueryString(frm);
				ComSetObjValue(frm.from_period,from_period);
				ComSetObjValue(frm.to_period,to_period);
				ComSetObjValue(frm.from_clmt_usd_amt,from_clmt_usd_amt);
				ComSetObjValue(frm.to_clmt_usd_amt,to_clmt_usd_amt);
				ComSetObjValue(frm.from_cgo_clm_stl_usd_amt,from_cgo_clm_stl_usd_amt);
				ComSetObjValue(frm.to_cgo_clm_stl_usd_amt,to_cgo_clm_stl_usd_amt);
				frm.page_no.value = "";//전건조회를 위해 실처리는 DAO 에서 함.
				
				//리포트 프로그램ID
				var report_id = ComGetObjValue(frm.report_id);
				//리포트 타이틀명
				var report_title = ComGetObjValue(frm.report_title)
				
				var rf = "/rf ["+ RDServerIP + "/CPS_CNI_0063.do]";
				
				var rpost =  "/rpost ["+ vFormData +"]";
				var rpaper = "/rpaper [A4]";

				if (frm.usr_area.value == "A") {
					rpaper = "/rpaper [LETTER]";
				}
				
				var rv = "/rv " + getCondAllValue();
				frm.com_mrdArguments.value = rf + " " + rv + " " + rpost + " " + rpaper;
				frm.com_mrdBodyTitle.value = "Container Cargo Claim List by " + report_title;		
				frm.com_mrdPath.value = "apps/alps/cps/cni/containercargoclaimreport/containercargoclaimreport/report/CPS_CNI_00" + report_id  + ".mrd";
				//var feature = "resizable=yes,width=1000,height=600";
				
				popupRd(1000,600);
				//ComOpenRDPopup(feature); 
				
			}
			break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sAction) {
	 
	 if (ComGetObjValue(frm.period) == "") {
		 ComShowCodeMessage("CNI00003", "period");
		 frm.period.focus();
		 return false; 
	 }
			 
	 if (ComGetObjValue(frm.period)!= "" && ComGetObjValue(frm.from_period) == "") {
		 ComShowCodeMessage("CNI00003", "period date"); 
		 frm.from_period.focus();
		 return false;
	 }
	 if (ComGetObjValue(frm.period) != "" && ComGetObjValue(frm.from_period) == "") {
		 ComShowCodeMessage("CNI00003", "period date");
		 frm.to_period.focus();
		 return false;
	 }
	 var from_clmt_usd_amt = ComReplaceStr(ComGetObjValue(frm.from_clmt_usd_amt).trim(),",","");
	 var to_clmt_usd_amt   = ComReplaceStr(ComGetObjValue(frm.to_clmt_usd_amt).trim(),",","");
	 
	 if (!ComIsNull(from_clmt_usd_amt) && !ComIsNull(to_clmt_usd_amt) && 
	      parseFloat(from_clmt_usd_amt) >= parseFloat(to_clmt_usd_amt)){
		 ComShowCodeMessage("CNI00036");
		 frm.to_clmt_usd_amt.focus();
		 return false;
	 }
	 var from_cgo_clm_stl_usd_amt = ComReplaceStr(ComGetObjValue(frm.from_cgo_clm_stl_usd_amt).trim(),",","");
	 var to_cgo_clm_stl_usd_amt   = ComReplaceStr(ComGetObjValue(frm.to_cgo_clm_stl_usd_amt).trim(),",","");
	 
	 if (!ComIsNull(from_cgo_clm_stl_usd_amt) && !ComIsNull(to_cgo_clm_stl_usd_amt) && 
	      parseFloat(from_cgo_clm_stl_usd_amt) >= parseFloat(to_cgo_clm_stl_usd_amt)){
		  ComShowCodeMessage("CNI00036");
		  frm.to_cgo_clm_stl_usd_amt.focus();
		  return false;
	 }
	 
	 if (ComGetObjValue(frm.clmt_clm_pty_abbr_nm).trim() == "") {
	 	 ComSetObjValue(frm.clmt_clm_pty_no, ""); 
	 }
	 if (ComGetObjValue(frm.clmt_clm_agn_pty_abbr_nm).trim() == "") {
	 	 ComSetObjValue(frm.clmt_clm_agn_pty_no, ""); 
	 }
	 if (ComGetObjValue(frm.insur_clm_pty_abbr_nm).trim() == "") {
	 	 ComSetObjValue(frm.insur_clm_pty_no, ""); 
	 }
	 if (ComGetObjValue(frm.clm_liable_pty_abbr_nm).trim() == "") {
	 	 ComSetObjValue(frm.labl_clm_pty_no, ""); 
	 }
	 if (ComGetObjValue(frm.slv_clm_pty_abbr_nm).trim() == "") {
	 	 ComSetObjValue(frm.slv_clm_pty_no, ""); 
	 }
	 if (ComGetObjValue(frm.clm_surveyor_pty_abbr_nm).trim() == "") {
	 	 ComSetObjValue(frm.svey_clm_pty_no, ""); 
	 }
	 
	 return true;
}
       
function setTemplate(reportId, reportTitle, sheetHeadTitle){
	
	//선택한 템플릿 셋팅
	ComSetObjValue(frm.report_id, reportId);
	ComSetObjValue(frm.report_title, reportTitle);
	if (reportId == "75" || reportId == "74") {
		ComSetObjValue(frm.period,"DOF");
	}	  
	var vSaveColName = sheetHeadTitle.split('|');
    var vColCount = vSaveColName.length;
    var vSheetColCount = sheet1.LastCol+1;
    
    for(var idx=1;idx<=vSheetColCount;idx++){
    	sheet1.ColHidden(idx) = false;
    }
    
    sheet1.RemoveAll();
    
    for(var idx=1; idx<vColCount; idx++){
    	if (sheet1.SaveNameCol((vSaveColName[idx].toLowerCase())) > 0) {
    	    sheet1.MoveColumnPos(vSaveColName[idx].toLowerCase(),idx);
    	} 
    }
    
    for(var jdx=vColCount;jdx<=vSheetColCount;jdx++){
    	sheet1.ColHidden(jdx) = true;
    }
    
}
//===================================================================================
//IBCombo 이벤트 처리
//===================================================================================
/**
* MultiSelect속성을 이용하는 경우, 체크박스를 클릭하는 순간 발생한다.
* @return
*/
function area_OnCheckClick(comboObj, index, code) {
  
	if( index==0 && code == "All" ) {	
	   	//checked
	   	var bChk = comboObj.CheckIndex(index);	   
	   		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
	   			comboObj.CheckIndex(i) = bChk;
	   		}
	} else {
		comboObj.CheckIndex(0) = false;
	}
}

/**
* IBMultiComboBox 설정<br>
* @param {select box} 콤보 객체
* @param {xml} code , name의 xml
* @param {String} 초기 선택 Code 
*/
function setMultiComboBox(pComboObjId, pXML) {
	var vComboObj      = null; // IBMultiComboBox
	var vArrayListData = ""; 
	var vListData      = "";
	var vCaptionText   = "";
	vComboObj = getComboObject(pComboObjId);
	if (vComboObj == null || pXML == null ) {
		return;
	}
   
	var vArrayListData = SheetXml2ListMap(pXML);
	
	for (var idx = 0; idx < vArrayListData.length; idx++) {
	    vListData = vArrayListData[idx];
		vCaptionText = vListData["code"] + " |" + vListData["name"];
		vComboObj.InsertItem(idx, vCaptionText, vListData["code"]);
	} //end for
	if (pComboObjId == "status") {
		vComboObj.InsertItem(0, "ALL|All Status", "All");
		vComboObj.Index = 0;
	} else if (pComboObjId == "area") {
		vComboObj.InsertItem(0, "ALL|All Area", "All");
		vComboObj.Index = 0;
		vComboObj.SetColWidth("30|90|0");
		vComboObj.MultiSelect = true;
	} else {
		vComboObj.InsertItem(0, "", "");
		vComboObj.Index = 0;
	}	
}

/**
* combo id 로 해당 comboObject를 찾아 반환한다.
* @param comboId
**/
function getComboObject(pComboObjId){
	var vCnt = comboObjects.length;
	if (vCnt > 0) {
		for(var i=0; i<vCnt; i++){
			if(comboObjects[i].id == pComboObjId){
				return comboObjects[i];
			} //end if 
		} // end for
	}// end if
	return null;
}

function setMainCodeInquiry(partyVo) {
	switch(mainCode){
		case "claimant":
			frm.clmt_clm_pty_no.value = partyVo.clm_pty_no;
			frm.clmt_clm_pty_abbr_nm.value = partyVo.clm_pty_abbr_nm;
			break;
		case "claimant_agent":
			frm.clmt_clm_agn_pty_no.value = partyVo.clm_pty_no;
			frm.clmt_clm_agn_pty_abbr_nm.value = partyVo.clm_pty_abbr_nm;
			break;	
		case "insurer":
			frm.insur_clm_pty_no.value = partyVo.clm_pty_no;
			frm.insur_clm_pty_abbr_nm.value = partyVo.clm_pty_abbr_nm;
			break;
		case "liable_party":
			frm.labl_clm_pty_no.value = partyVo.clm_pty_no;
			frm.clm_liable_pty_abbr_nm.value = partyVo.clm_pty_abbr_nm;
			break;
		case "salvager":
			frm.slv_clm_pty_no.value = partyVo.clm_pty_no;
			frm.slv_clm_pty_abbr_nm.value = partyVo.clm_pty_abbr_nm;
		 	break;
		case "surveyor":
			frm.svey_clm_pty_no.value = partyVo.clm_pty_no;
			frm.clm_surveyor_pty_abbr_nm.value = partyVo.clm_pty_abbr_nm;
			break;
	}
} 

//Miscellaneous 팝업창에서 호출한 함수
function setMiscCode(miscCdVO){
	var clss_clm_misc_cd = miscCdVO.clss_clm_misc_cd;
	
	switch(clss_clm_misc_cd){
		case "02":
			frm.mjr_clm_dmg_lss_cd.value = miscCdVO.clm_misc_cd;
			break;
		case "39":
			frm.n3rd_labl_pty_cd.value = miscCdVO.clm_misc_cd;
			break;
		case "11":
			frm.cgo_clm_tp_cd.value = miscCdVO.clm_misc_cd;
			break;
		case "14":
			frm.inci_plc_tp_cd.value = miscCdVO.clm_misc_cd;
			break;
		case "15":
			frm.clm_cgo_tp_cd.value = miscCdVO.clm_misc_cd;
			frm.clm_cgo_tp_nm.value = miscCdVO.clm_misc_nm;
			break;	
	}
}

/**
 * 리포터 파라메터 값 전달을 위한 문자열 처리 
 * @return
 */
function getCondAllValue(){
	
	var vObjects = frm.elements;
	var vCondStr = "";
	for ( var kdx = 0; kdx < vObjects.length; kdx++) {
		var vObj   = vObjects[kdx];
		var vObjTp = vObj.type;
		var vObjNm = vObj.name;
    	
		if (typeof(vObjNm) == "undefined" || vObjNm == "" || vObjTp == "hidden"){
			continue;
		}
		vCondStr += "p_" + vObjNm + "[" +  ComGetObjValue(vObj) + "]";
	} //end for
	return vCondStr;
}
/**
 * 공통팝업 Location Setting
 * @param rowArray
 * @return
 */
function setLocation(rowArray) { 
 	if (locationCode == "POR"){
        frm.por_cd.value = rowArray[0][3];
    } else if ( locationCode == "DEL") {
        frm.del_cd.value = rowArray[0][3]; 
    }	    
}
/**
 * Handler Office Code Setting
 * 팝업창 결과 처리
 * @param ofcCd
 * @return 없음
 */ 
function setOfficeCode(ofcCd){
	frm.hndl_ofc_cd.value = ofcCd;
}
 
 /**
 * 에러처러 공통 함수
 * @class IBSheet의 Search 후에 Exception시 해당 메세지를 보여준다 
 * @param {IBSheet} pSheetObj 해당 IBSheet
 * @param {string} pXml 서버에서 조회한 결과 XML
 * @throws
 * @author 정행룡
 * @since 2009.11.12
 */
function getErrorMsg(pSheetObj, pXml){
	var vErrorMsg = ComGetEtcData(pXml,"Exception");
	if (vErrorMsg != undefined && vErrorMsg != null && vErrorMsg != "" ) {
		pSheetObj.LoadSearchXml(pXml);//에러 메세지 처리
		return true;
	}
	return false;
} 