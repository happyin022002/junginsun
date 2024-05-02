/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VOP_VSK_0024.js
 *@FileTitle : Canal Transit List
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.03.03
 *@LastModifier : 유혁
 *@LastVersion : 1.0
 * 2009.09.09 유혁
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
 * @class VOP_VSK_0024 : VOP_VSK_0024 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_VSK_0024() {
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

/* 개발자 작업 */  

// 공통전역변수 
var sheetObjects = new Array();
var comboObjects = new Array();
var sheetCnt = 0;
var comboCnt = 0;

var psoTariffscgAmt = "";
var psoTariffDiffscgAmt = "";
var esti = 0;
var diff = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */

	var sheetObject1 = sheetObjects[0];

	/** **************************************************** */
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
		
		case "btn_Retrieve":
			var st_mon = formObj.start_month.value;
			if(st_mon != "" || st_mon != null) {
				formObj.end_month.value = st_mon;
			}
			if(checkPeriod()){
				doActionIBSheet(sheetObject1, formObj, IBSEARCH);
			}
			break;
			
		case "btn_Save":
			doActionIBSheet(sheetObject1, formObj, IBSAVE);
			break;

		case "btn_S/PRegistration":
			var sUrl = "/hanjin/VOP_VSK_0240.do";
			ComOpenPopupWithTarget(sUrl, 824, 630, "", "0,0", true);
			break;

		case "btn_TLCreation":
			doActionIBSheet(sheetObject1, formObj, SEARCH02);
			break;
			
		case "btn_TBCreation":
			doActionIBSheet(sheetObject1, formObj, SEARCH03);
			break;
		
		case "btn_cal1":
			var cal = new ComCalendar();
			cal.setDisplayType('month');
			cal.setEndFunction("clearSheet");
			cal.select(formObj.start_month, 'yyyy-MM');
			break;
			
		case "btn_cal2":
			var cal = new ComCalendar();
			cal.setDisplayType('month');
			cal.setEndFunction("clearSheet");
			cal.select(formObj.end_month, 'yyyy-MM');
			break;
			
		case "btns_search":
			var sUrl = "/hanjin/VOP_VSK_0202.do?vsl_slan_cd=" + formObj.vsl_slan_cd.value + "&intg_cd_id=CD00717";
			var rVal = ComOpenPopupWithTarget(sUrl, 458, 470, "", "0,0", true);
			if(rVal){
				formObj.vsl_slan_cd.value = rVal;
			}
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
 * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
 * @param combo_obj
 * @return
 */
function setComboObject(combo_obj){
	comboObjects[comboCnt++] = combo_obj;
}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	sheetControl("EGSUZ");
	for(var k=0; k<comboObjects.length; k++){
		initCombo(comboObjects[k],k+1);
	}
	
	initControl();
	
	// 날짜초기화
	var formObj = document.form;
	var today = new Date();
	with (formObj) {
		start_month.value = ComGetNowInfo("ym", "-");
		end_month.value = ComGetNowInfo("ym", "-");
	}
	
	// 콤보초기화
	doActionIBSheet(sheetObjects[0], formObj, COMMAND01);
	comboObjects[0].Code = "ALL";
	

	
	
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetId = sheetObj.id;

	switch (sheetId) {
	case "sheet1": // sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 460;
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
			InitRowInfo(4, 1, 4, 100);

			var HeadTitle1 = "Bound||VVD|Lane\nCode|S/P|Coastal SKD|Coastal SKD|Coastal SKD|BKG|Panama Transit Booking|Panama Transit Booking|Panama Transit Booking|Panama Transit Booking|Panama Transit Booking|Panama Transit Booking|Tier Surcharge|Tier Surcharge|Tier Surcharge|Tier Surcharge|Tier Surcharge|Tier Surcharge|Tier Surcharge|Tier Surcharge|Tier Surcharge|Saving Bunker\n/ Canal fee||||Calulation|Rehandling|Rehandling|Rehandling|SCD\nRate|Exchage\nRate|Rehandling\nCharge|Saving\nCost|TEU|TEU|Surcharge|Surcharge|Surcharge|Surcharge";
			var HeadTitle2 = "Bound||VVD|Lane\nCode|S/P|ETA|ETB|ETD|BKG\nStatus|BKG Period|Bidding\nPrice(USD)|BKG Status|BKG\nTransit Date|JIT Service Approval|JIT Service Approval|Ratio\n(%)|Speed (kts)|Port|Tier|TEU|Box|Ratio\n(%)|Estimate\nSurcharge|Diff|Saving Bunker\n/ Canal fee||||Calulation|Rehandling\nPort|Average\nGross\nProductivity|Rehandling\nQ'ty|SCD\nRate|Exchage\nRate|Rehandling\nCharge|Saving\nCost|Allowance|Loaded TEU|Visibility|Under ACP|Exceed ACP Cost|Exceed ACP Cost";
			var HeadTitle3 = "Bound||VVD|Lane\nCode|S/P|ETA|ETB|ETD|BKG\nStatus|BKG Period|Bidding\nPrice(USD)|BKG Status|BKG\nTransit Date|Y/N|Arrival Date|Ratio\n(%)|Speed (kts)|Port|Tier|TEU|Box|Ratio\n(%)|Estimate\nSurcharge|Diff|Saving Bunker\n/ Canal fee||||Calulation|Rehandling\nPort|Average\nGross\nProductivity|Rehandling\nQ'ty|SCD\nRate|Exchage\nRate|Rehandling\nCharge|Saving\nCost|Allowance|Loaded TEU|Range|CNTR Q'ty|Estimate|Actual";
			var HeadTitle4 = "Bound||VVD|Lane\nCode|S/P|ETA|ETB|ETD|BKG\nStatus|BKG Period|Bidding\nPrice(USD)|BKG Status|BKG\nTransit Date|Y/N|Arrival Date|Ratio\n(%)|Speed (kts)|Port|Tier|TEU|Box|Ratio\n(%)|Estimate\nSurcharge|Diff|Saving Bunker\n/ Canal fee||||Calulation|Rehandling\nPort|Average\nGross\nProductivity|Rehandling\nQ'ty|SCD\nRate|Exchage\nRate|Rehandling\nCharge|Saving\nCost|Allowance|Loaded TEU|Range|CNTR Q'ty|Estimate|Actual";
			
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, false, false, false, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
			InitHeadRow(2, HeadTitle3, true,true);
			InitHeadRow(3, HeadTitle4, true);
			
			var prefix = "sheet1_";
 
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			// InitDataProperty(0, cnt++ , dtHiddenStatus, 75, daCenter, true,
			// "hdnStatus");
			InitDataProperty(0, cnt++, dtData, 75, 		daCenter, 	true, 	prefix + "bound",							false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true,	prefix + "ibflag", 						false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 70, 		daCenter, 	true, 	prefix + "vvd",								false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 40, 		daCenter, 	true,	prefix + "vsl_slan_cd",					false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtHidden, 50, 		daCenter, 	true,	prefix + "vndr_seq",					false, "", dfNone, 0, true);

			InitDataProperty(0, cnt++, dtData, 97, 		daCenter, 	true,	prefix + "vps_eta_dt",					false, "", dfUserFormat2, 0, true);
			InitDataProperty(0, cnt++, dtData, 97, 		daCenter, 	true,	prefix + "vps_etb_dt",					false, "", dfUserFormat2, 0, true);
			InitDataProperty(0, cnt++, dtData, 97, 		daCenter, 	true,	prefix + "vps_etd_dt",					false, "", dfUserFormat2, 0, true);
			InitDataProperty(0, cnt++, dtData, 60, 		daCenter, 	true, 	prefix + "bkg_sts",						false, "", dfNone, 0, true);
			
			InitDataProperty(0, cnt++, dtCombo, 75, 		daCenter, 	true, 	prefix + "cnl_tz_bkg_prd_cd",		false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 80, 			daCenter, 	true, 	prefix + "cnl_bkg_amt",				false, "", dfNullInteger, 0, false);

			InitDataProperty(0, cnt++, dtCombo, 75, 		daCenter, 	true, 	prefix + "cnl_tz_bkg_proc_sts_cd",		false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 80, 			daCenter, 	true, 	prefix + "cnl_bkg_tz_dt",				false, "", dfUserFormat2, 0, true);
			InitDataProperty(0, cnt++, dtCombo, 50, 		daCenter, 	true, 	prefix + "cnl_ot_svc_apro_flg",			false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 100, 		daCenter, 	true, 	prefix + "cnl_ot_svc_arr_dt",			false, "", dfUserFormat2, 0, false);

			InitDataProperty(0, cnt++, dtHidden, 70, 	daCenter, 	true,	prefix + "scg_lmt_act_ratio",			false, "", dfNullFloat, 1, true);
			InitDataProperty(0, cnt++, dtHidden, 80, 	daCenter, 	true,	prefix + "scg_lmt_act_spd",			false, "", dfNullFloat, 1, true);
//			InitDataProperty(0, cnt++, dtData, 40, 		daRight, 	false,	"scg_lmt_opt_ratio",			false, "", dfNullFloat, 1, true);
//			InitDataProperty(0, cnt++, dtData, 40, 		daRight, 	false,	"scg_lmt_opt_spd",			false, "", dfNullFloat, 1, true);
			InitDataProperty(0, cnt++, dtData, 50, 		daCenter, 	true,	prefix + "scg_car_port_cd",				false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 30, 		daCenter, 	true,	prefix + "scg_car_tier",				false, "", dfNullInteger, 0, true);
			InitDataProperty(0, cnt++, dtData, 40, 		daCenter, 	true,	prefix + "scg_car_teu",					false, "", dfNullInteger, 0, true);
			InitDataProperty(0, cnt++, dtData, 40, 		daCenter, 	true,	prefix + "scg_car_box",					false, "", dfNullInteger, 0, true);
			InitDataProperty(0, cnt++, dtData, 50, 		daCenter, 	true,	prefix + "scg_car_ratio",				false, "", dfNullFloat, 1, true);
			InitDataProperty(0, cnt++, dtData, 70, 		daCenter, 	true,	prefix + "scg_car_esti_scg",			false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 70, 		daCenter, 	true,	prefix + "scg_car_diff_scg",			false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtHidden, 100, 	daCenter, 	true, 	prefix + "detail",						false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtHidden, 40, 	daCenter, 	true, 	prefix + "yd_cd",						false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtHidden, 40, 	daCenter, 	true, 	prefix + "clpt_seq",							false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtHidden, 40, 	daCenter, 	true, 	prefix + "vps_port_cd",							false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtImage, 80, 	daCenter, 	true, 	prefix + "calc",							false, "", dfNone, 0, true);


			InitDataProperty(0, cnt++, dtHidden, 80, 	daCenter, 	true, 	prefix + "rhd_port",						false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtHidden, 80, 	daCenter, 	true, 	prefix + "avr_gros_prd",					false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtHidden, 80, 	daCenter, 	true, 	prefix + "rhd_qty",							false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtHidden, 80, 	daCenter, 	true, 	prefix + "scd_rate",						false, "", dfNullFloat, 1, true);
			InitDataProperty(0, cnt++, dtHidden, 80, 	daCenter, 	true, 	prefix + "exh_rate",						false, "", dfNullFloat, 1, true);
			InitDataProperty(0, cnt++, dtHidden, 100, 	daCenter, 	true, 	prefix + "rhd_charge",					false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtHidden, 100, 	daCenter, 	true, 	prefix + "sv_cost",						false, "", dfNone, 0, true);
			
			InitDataProperty(0, cnt++, dtData, 80, 	daCenter, 	true, 	prefix + "allowance",						false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 80, 	daCenter, 	true, 	prefix + "load_teu",						false, "", dfNone, 0, true);
			
			InitDataProperty(0, cnt++, dtData, 80, 	daCenter, 	false, 	prefix + "visi_range",						false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 80, 	daCenter, 	false, 	prefix + "und_acp_qty",						false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 80, 	daCenter, 	false, 	prefix + "exd_acp_esti",					false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 80, 	daCenter, 	false, 	prefix + "exd_acp_actual",					false, "", dfNone, 0, true);
			
			
			InitUserFormat2(0, prefix + "vps_eta_dt", "####-##-## ##:##", "-|:");
			InitUserFormat2(0, prefix + "vps_etb_dt", "####-##-## ##:##", "-|:");
			InitUserFormat2(0, prefix + "vps_etd_dt", "####-##-## ##:##", "-|:");
			InitUserFormat2(0, prefix + "cnl_bkg_tz_dt", "####-##-##", "-"); 
			InitUserFormat2(0, prefix + "cnl_ot_svc_arr_dt", "####-##-## ##:##", "-|:"); 

			
			InitDataCombo(0, prefix+"cnl_tz_bkg_prd_cd", " |1st Period|2nd Period|3rd Period|Auction", " |F|S|T|A");
			InitDataCombo(0, prefix+"cnl_tz_bkg_proc_sts_cd", " |Ready|Processing|Booked|Fail", " |R|P|B|F");
			InitDataCombo(0, prefix+"cnl_ot_svc_apro_flg", " |No|Yes", " |N|Y");
			
			
			ImageList(0) = "img/btns_detail.gif";
			ImageList(1) = "img/blank.gif";
			ImageList(2) = "img/btns_next.gif";
			ImageList(3) = "img/blank.gif";
			
			SelectHighLight = false;
			CountPosition = 2;
			
			RowHeight(0) = 20;
			RowHeight(1) = 20;
			RowHeight(2) = 20;
		}
		break;

	}
}

function initCombo(comboObj, comboNo) {
	var formObj = document.form;
	
	switch(comboObj.id) { 
		case "vndr_seq": 
			with (comboObj) { 
				MultiSelect = false;
				UseAutoComplete = true;	
				SetColAlign("left");        
				DropHeight = 160;
		   	}
			break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.WaitImageVisible = false;
	switch (sAction) {
	
	case COMMAND01: // WINDOW OPEN
		formObj.f_cmd.value = SEARCH01;
		var sParam = FormQueryString(formObj);
		var sXml = sheetObj.GetSearchXml("VOP_VSK_0024GS.do", sParam);
		
		var vendorSeq = ComGetEtcData(sXml, "vendorSeq");
		//var vendorNm = ComGetEtcData(sXml, "vendorNm");
		var vendorNm = ComGetEtcData(sXml, "vendorSeq");
		if(!vendorSeq){
			vendorSeq = "";
		}else{
			vendorSeq = "|" + vendorSeq;
		}
		if(!vendorNm){
			vendorNm = "";
		}else{
			vendorNm = "|" + vendorNm; 
		}
		
		var vendorSeqArr = ("ALL"+vendorSeq).split("|");	//
		var vendorNmArr = ("ALL"+vendorNm).split("|");	//
		
		//CTRL Combo Setting.
		appendMultiComboItem(getComboObject("vndr_seq"), vendorSeqArr, vendorNmArr, "", "DEF");
		break;

	case IBSEARCH: // 조회

		formObj.f_cmd.value = SEARCH;
		
		// 파나마인 경우 surcharge 정보를 표현하지 않는다.
		ComOpenWait(true);
		var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
		var sXml = sheetObj.GetSearchXml("VOP_VSK_0024GS.do", sParam);
		sheetObj.Redraw = false;
		sheetObj.LoadSearchXml(sXml);
		sheetObj.Redraw = true;
		ComOpenWait(false);
		break;
		
	case IBSAVE:
		
		var sParam = ComGetSaveString(sheetObjects, false);
		if (sParam == ""){
			return;
		} else {
			formObj.f_cmd.value = MULTI;
			sParam = FormQueryString(formObj)  + "&" + sParam;
		}
		
		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);
		var sXml = sheetObj.GetSaveXml("VOP_VSK_0024GS.do", sParam);
		ComOpenWait(false);
		sheetObj.LoadSaveXml(sXml);
		break;


		
	case SEARCH01: // Lane Code 조회
		ComOpenWait(true);
		formObj.f_cmd.value = COMMAND12;
		var sParam = FormQueryString(formObj);
		var sXml = sheetObj.GetSearchXml("VSK_GLOGS.do", sParam);
		ComOpenWait(false);
		
		var vsl_slan_nm = ComGetEtcData(sXml, "checkLane");
		if(vsl_slan_nm==null || vsl_slan_nm==""){
			ComShowCodeMessage('VSK00021', formObj.vsl_slan_cd.value);
			formObj.vsl_slan_cd.value = "";
		}
		break;

	case SEARCH02: // SPP 전달
		
		formObj.f_cmd.value = SEARCH02;
		var sParam = FormQueryString(formObj);
		
		if(sheetObj.RowCount > 0){

//			var monthCheck = false;
//			
//			// 첫날짜1일 체크
//			var start  = formObj.start_date.value;
//			var end = formObj.end_date.value;
//			if(start.substring(8)=="01"){
//				// 같은 month인지 체크
//				if(start.substring(0, 7) == end.substring(0, 7)){
//					// end_date가 말일인지 체크
//					if(end.substring(8) == ComGetLastDay(ComParseInt(start.substring(0,4)), ComParseInt(start.substring(5, 7)))){
//						// 주어진 기간은 한달임
//						monthCheck = true;
//					}
//				}
//			}
//
//			// 조회 기간이 한달이 안되는 경우 실행하지 않는다.
//			if(!monthCheck){
//				ComShowCodeMessage('VSK00068');
//				break;
//			}
//			
//			// Port가 ALL 인 경우 실행하지 않는다.
//			if(formObj.port_cd.value=="A"){
//				ComShowCodeMessage('VSK00059');
//				break;
//			}
			
			ComOpenWait(true);
			var sXml = sheetObj.GetSaveXml("VOP_VSK_0024GS.do", sParam);
			var msg = VskGetXmlNodeValue(sXml, "MESSAGE");
			ComOpenWait(false);
			
			if(msg!=""){
				ComShowMessage(msg);
			}
		}
		break;
		
	case SEARCH03: // 1년치 PAPAC 목록 전달
		
		formObj.f_cmd.value = SEARCH02
		formObj.bkg_sts.value = "TBCreate";
		
		var sParam = FormQueryString(formObj);
		
		if(sheetObj.RowCount > 0){
			
			// Port가 PAPAC가 아닌 경우 실행하지 않는다.
			if(formObj.port_cd.value!="PAPAC"){
				ComShowCodeMessage("VSK00019");
				return false;
			}
			
			// 조회 기간이 1년(Jan.~Dec.)이 아닌 경우 실행하지 않는다.
			if(formObj.start_month.value.substring(5)!="01" || formObj.end_month.value.substring(5)!="12"){
				ComShowCodeMessage("VSK00068");
				return false;
			}

			ComOpenWait(true);
			var sXml = sheetObj.GetSaveXml("VOP_VSK_0024GS.do", sParam);
			var msg = VskGetXmlNodeValue(sXml, "MESSAGE");
			ComOpenWait(false);
			
			if(msg!=""){
				ComShowMessage(msg);
			}
		}
		break;
	case COMMAND07:
		formObj.f_cmd.value = COMMAND07;
		var sParam = FormQueryString(formObj);
		alert(sParam);
		ComOpenWait(true);
		var sXml = sheetObj.GetSearchXml("VOP_VSK_0024GS.do", sParam);
		alert('2');

		
		psoTariffscgAmt = ComGetEtcData(sXml, "scgAmt");
		psoTariffDiffscgAmt = ComGetEtcData(sXml, "scgDiffAmt");
		ComOpenWait(false);
		alert(psoTariffscgAmt+"&&&"+psoTariffDiffscgAmt);

		
		if( psoTariffscgAmt != "" ){
			var m = psoTariffscgAmt;
			m = m.replace( "Round (" , "").replace(")","");
			var aa = m.split(",");
			
			esti = eval( aa[0] ) ;
			
		}
		
		if(psoTariffDiffscgAmt != "" ){
			var m = psoTariffDiffscgAmt;
			m = m.replace( "Round (" , "").replace(")","");
			var bb = m.split(",");
			diff = eval(bb[0]);
			
		}
		
		sheetObj.CellValue( sheetObj.SelectRow , "sheet1_scg_car_esti_scg") = setComma( esti.toFixed(2) );
		sheetObj.CellValue( sheetObj.SelectRow , "sheet1_scg_car_diff_scg") = setComma( (esti-diff).toFixed(2) ); 
		
		
		var s1 = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_rhd_qty");
		var s2 = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_scd_rate");
		var s3 = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_exh_rate"); 
		var ssum = s1 *  s3;
		
		//sheetObj.CellValue2(Row, "sheet1_rhd_charge") = setComma(ssum.toFixed(2));
		
		sheetObj.CellValue(sheetObj.SelectRow , "sheet1_sv_cost" ) = setComma(((esti-diff)-ssum).toFixed(2));
		esti = 0;
		diff = 0;
		psoTariffscgAmt = "";
		psoTariffDiffscgAmt = "";
		
		break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		// if (!isNumber(formObj.iPage)) {
		// return false;
		// }
	}

	return true;
}

function initControl(){
	var formObj = document.form;
	axon_event.addListenerForm("keypress", "enter_keypress", formObj);	//- Enter 키 처리
    axon_event.addListenerForm("keyup", "VskKeyFocus", formObj);		//- 자동포커스 처리
    
    axon_event.addListenerForm("change", "obj_change", formObj);
    axon_event.addListenerForm("keypress", "obj_keypress", formObj);
    axon_event.addListenerForm("blur", "obj_beforedeactivate", formObj);
    axon_event.addListenerForm("focus", "obj_activate", formObj);
    axon_event.addListenerForm("keyup", "obj_keyup", formObj);
    
}

/**
 * 엔터키로 연결된 화면 대표 이벤트
 */
function enter_keypress(){
	VskKeyEnter();
}

function obj_change(){
	var srcName = event.srcElement.name;
	switch(event.srcElement.name){
		case "port_cd":
			 clearSheet();
			//alert( "value :: " + value );
			//alert( "text :: " + text );
			var val = document.form.port_cd.value;
			sheetControl(val);	
			break;
		case "vsl_slan_cd":
		case "start_month":			
		case "end_month":
		case "surcharge":
			clearSheet();
			break;
		default:
			break;
	}	
}

function obj_keypress(){

	var srcName = event.srcElement.name;
	switch(event.srcElement.name){
		case "vsl_slan_cd":
			ComKeyOnlyAlphabet("uppernum");
			break;
		
		case "start_month":
		case "end_month":
			ComKeyOnlyNumber();
			break;
			
	}
}

/**
 * HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
 */
function obj_beforedeactivate() {
	var formObj = document.form;
	var obj = event.srcElement;
	switch (event.srcElement.name) {
		case "start_month":
		//case "end_month":
			ComChkObjValid(event.srcElement);
			break;
	}
}

/**
 * HTML Control의 포커스 들어가는 이벤트에서 마스크 구분자를 제거한다.
 */
function obj_activate() {
	// 마스크구분자 없애기
	switch (event.srcElement.name) {
		case "start_month":
//		/case "end_month":
			ComClearSeparator(event.srcElement);
			break;	
	}
	if(event.srcElement.options){
		event.srcElement.focus();
	}else{
		event.srcElement.select();
	}
}

function obj_keyup(){
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
	var obj = event.srcElement;
	switch (event.srcElement.name) {
		case "vsl_slan_cd":
			if(ComChkLen(obj.value, 3)==2){
				doActionIBSheet(sheetObj, formObj, SEARCH01);
				formObj.vsl_slan_cd.focus();
			}
			break;
	}
}

function sheet1_OnClick(sheetObj, Row, Col){
	var formObj = document.form;
	
	// Detail 버튼을 클릭하는 경우 VOP_VSK_0246 화면을 띄운다.
	if(Col==25){
		alert(Row+"---"+Col);
		alert(sheetObj.CellValue(Row, Col));
		if(sheetObj.CellValue(Row, Col) == '2'){
			var vvd = sheetObj.CellValue(Row, "sheet1_vvd");
			formObj.vsl_cd.value = vvd.substring(0,4);
			formObj.skd_voy_no.value = vvd.substring(4,8);
			formObj.skd_dir_cd.value = vvd.substring(8);
			formObj.yd_cd.value = sheetObj.CellValue(Row, "sheet1_yd_cd");
			formObj.scg_car_tier.value = sheetObj.CellValue(Row, "sheet1_scg_car_tier");
			formObj.vps_etb_dt.value = sheetObj.CellValue(Row, "sheet1_vps_etb_dt");
			alert('x');
			doActionIBSheet(sheetObj, formObj, COMMAND07);
			
			//alert( "계산궈궈" );
		}
	}
	/*
	if(Col==18){
		if(sheetObj.CellValue(Row, Col) == '0'){
			var sUrl = "/hanjin/VOP_VSK_0246.do?vvd=" + sheetObj.CellValue(Row, 2) + "&vsl_slan_cd=" + sheetObj.CellValue(Row, 3) + "&bound=" + sheetObj.CellValue(Row, 1) + "&vps_port_cd=" + sheetObj.CellValue(Row, 10);
			ComOpenPopupWithTarget(sUrl, 1000, 620, "", "0,0", true);			
		}
	}*/
	
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	
	var formObj = document.form;
	
	// 파나마인 경우 surcharge 정보를 표현하지 않는다.
	var prefix = "sheet1_";
	if("PAPAC"==formObj.port_cd.value){
		sheetObj.ColBackColor(prefix + "scg_lmt_act_ratio") = sheetObj.RgbColor(240, 240, 240);
		sheetObj.ColBackColor(prefix + "scg_lmt_act_spd") = sheetObj.RgbColor(240, 240, 240);
		sheetObj.ColBackColor(prefix + "scg_car_port_cd") = sheetObj.RgbColor(240, 240, 240);
		sheetObj.ColBackColor(prefix + "scg_car_tier") = sheetObj.RgbColor(240, 240, 240);
		sheetObj.ColBackColor(prefix + "scg_car_teu") = sheetObj.RgbColor(240, 240, 240);
		sheetObj.ColBackColor(prefix + "scg_car_ratio") = sheetObj.RgbColor(240, 240, 240);
		sheetObj.ColBackColor(prefix + "detail") = sheetObj.RgbColor(240, 240, 240);
	}
	
	for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows + sheetObj.RowCount; i++){
		// SPEED가 음수인경우 빨간색표시
		if(sheetObj.CellValue(i, "sheet1_scg_lmt_act_spd") < 0){
			sheetObj.CellFontColor(i, "sheet1_scg_lmt_act_spd") = sheetObj.RgbColor(255, 0, 0);
		}
		
		if(sheetObj.CellValue(i, prefix + "cnl_tz_bkg_proc_sts_cd") == "F"){
			sheetObj.CellValue2(i, prefix + "cnl_ot_svc_apro_flg") = "N";
		}
		
		if(sheetObj.CellValue(i, prefix + "cnl_ot_svc_apro_flg") == "Y"){
			sheetObj.CellEditable(i, prefix + "cnl_ot_svc_arr_dt") = true;
		}else{
			sheetObj.CellValue(i, prefix + "cnl_ot_svc_arr_dt") = "";
			sheetObj.CellEditable(i, prefix + "cnl_ot_svc_arr_dt") = false;
		}
		
		if(sheetObj.CellValue(i, prefix + "cnl_tz_bkg_prd_cd") == "A"){
			sheetObj.CellEditable(i, prefix + "cnl_bkg_amt") = true;
		}else{
			sheetObj.CellEditable(i, prefix + "cnl_bkg_amt") = false;
		}
	}
	
	var esti = 0;
	var diff = 0;
	
	if("EGSUZ"==formObj.port_cd.value){
		for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows + sheetObj.RowCount; i++){
		
			/*if( sheetObj.CellValue(i, "sheet1_scg_car_esti_scg") != "" ){
				var m = sheetObj.CellValue(i, "sheet1_scg_car_esti_scg");
				m = m.replace( "Round (" , "").replace(")","");
				var aa = m.split(",");
				esti = eval(aa[0]);
				//alert( esti );
				
				sheetObj.CellValue2(i, "sheet1_scg_car_esti_scg")=  setComma( esti.toFixed(2) );
			}
			if( sheetObj.CellValue(i, "sheet1_scg_car_diff_scg") != "" ){
				var n = sheetObj.CellValue(i, "sheet1_scg_car_diff_scg");
				n = n.replace( "Round (" , "").replace(")","");
				var bb = n.split(",");
				diff = eval(bb[0]);
				
				sheetObj.CellValue2(i, "sheet1_scg_car_diff_scg")= setComma( diff.toFixed(2) );
				
			}*/
			
			if( sheetObj.CellValue(i, "sheet1_scd_rate") != ""  ){
				
			}else{
				sheetObj.CellValue2(i, "sheet1_scd_rate") = 0.0;
			}
			
			if( sheetObj.CellValue(i, "sheet1_exh_rate") != ""  ){
				
			}else{
				sheetObj.CellValue2(i, "sheet1_exh_rate") = 0.0;
			}
			
			var s1 = sheetObj.CellValue(i, "sheet1_rhd_qty");
			var s2 = sheetObj.CellValue(i, "sheet1_scd_rate");
			var s3 = sheetObj.CellValue(i, "sheet1_exh_rate"); 
			//var frm = sheetObj.CellValue(i, "sheet1_scg_car_diff_scg");
			var ssum = s1 *  s3;
			
			sheetObj.CellValue2(i, "sheet1_rhd_charge") = setComma(ssum.toFixed(2));
			
			//sheetObj.CellValue2(i, "sheet1_sv_cost") = setComma((Number(esti)-ssum).toFixed(2));
			esti = 0;
		}
	}
	
	
}

function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var prefix = "sheet1_";
	if(sheetObj.CellValue(Row, prefix + "cnl_tz_bkg_proc_sts_cd") == "F"){
		sheetObj.CellValue2(Row, prefix + "cnl_ot_svc_apro_flg") = "N";
	}
	
	if(sheetObj.CellValue(Row, prefix + "cnl_ot_svc_apro_flg") == "Y"){
		sheetObj.CellEditable(Row, prefix + "cnl_ot_svc_arr_dt") = true;
	}else if(sheetObj.CellValue(Row, prefix + "cnl_ot_svc_apro_flg") != "Y"){
		sheetObj.CellValue2(Row, prefix + "cnl_ot_svc_arr_dt") = "";
		sheetObj.CellEditable(Row, prefix + "cnl_ot_svc_arr_dt") = false;
	}
	
	if(sheetObj.CellValue(Row, prefix + "cnl_tz_bkg_prd_cd") == "A"){
		sheetObj.CellEditable(Row, prefix + "cnl_bkg_amt") = true;
	}else if(sheetObj.CellValue(Row, prefix + "cnl_tz_bkg_prd_cd") != "A"){
		sheetObj.CellValue2(Row, prefix + "cnl_bkg_amt") = "";
		sheetObj.CellEditable(Row, prefix + "cnl_bkg_amt") = false;
	}
	
	
	
	
	//var esti = 0;
	//var diff = 0;
	
	/*if( Col = "sheet1_scg_car_esti_scg" && psoTariffscgAmt != "" ){
		var m = psoTariffscgAmt;
		m = m.replace( "Round (" , "").replace(")","");
		var aa = m.split(",");
		esti = eval(aa[0]);
		//alert( esti );
		
		CellValue(Row, Col) =  setComma( esti.toFixed(2) );
		
		var s1 = sheetObjects[0].CellValue(Row, "sheet1_rhd_qty");
		var s2 = sheetObjects[0].CellValue(Row, "sheet1_scd_rate");
		var s3 = sheetObjects[0].CellValue(Row, "sheet1_exh_rate"); 
		var frm = sheetObjects[0].CellValue(Row, "sheet1_scg_car_diff_scg");
		var ssum = s1 * s2 * s3;
		
		//sheetObj.CellValue2(Row, "sheet1_rhd_charge") = setComma(ssum.toFixed(2));
		
		CellValue(Row, "sheet1_sv_cost") = setComma((Number(esti)-ssum).toFixed(2));
		esti = 0;
	}
	
	if( Col = "sheet1_scg_car_diff_scg" && psoTariffDiffscgAmt != "" ){
		var n = psoTariffDiffscgAmt;
		n = n.replace( "Round (" , "").replace(")","");
		var bb = n.split(",");
		diff = eval(bb[0]);
		
		CellValue(i, "sheet1_scg_car_diff_scg")= setComma( diff.toFixed(2) );
		
	}
	
	*/
	
	
	
}

function getComboObject(comboId){
	var cnt = comboObjects.length;
	if(cnt > 0){
		for(var i=0; i<cnt; i++){
			if(comboObjects[i].id == comboId){
				return comboObjects[i];
			}
		}
	}
	
	return null;
}

function appendMultiComboItem(comboObj, optionCdArr, optionDescArr, selCode, sFlag){
	comboObj.RemoveAll();
	
	if(optionCdArr != null){
		if(sFlag == "DEF"){
			for(var i=0; i<optionCdArr.length; i++) {
				comboObj.InsertItem(i, optionDescArr[i], optionCdArr[i]);
			}
		}else{
			for(var i=0; i<optionCdArr.length; i++) {
				comboObj.InsertItem(i, optionDescArr[i], optionCdArr[i]);
			}
		}
    	
		comboObj.Code2 = selCode;
	}
}

function clearSheet(){
	sheetObjects[0].RemoveAll();
	
}

function vndr_seq_OnChange(comboObj, value, text){
	clearSheet();
}

function checkPeriod(){
	var formObj = document.form;
	var start_month = formObj.start_month.value;
	var end_month = formObj.end_month.value;
	var port_cd = formObj.port_cd.value;
	
	monthToDate();
	
	var start_date = formObj.start_date.value;
	var end_date = formObj.end_date.value;
	
	if(ComChkPeriod(start_date, end_date) < 1){
		ComShowCodeMessage("VSK00025", "End date", "start date");
	}
	
	if("PAPAC"==port_cd){
		return true;
	}
	
	// EGSUZ로 조회하는 경우 조회 기간이 1달 이내인지 확인한다.
	var tmp_date = ComGetDateAdd(start_date, "M", 1);
	tmp_date = ComGetDateAdd(tmp_date, "D", -1);
	
	if(ComGetDaysBetween(tmp_date, end_date)>0){
		ComShowCodeMessage('VSK00018');
		return false;
	}else{
		return true;
	}
	
}

function monthToDate(){
	
	var formObj = document.form;
	var start_month = formObj.start_month.value;
	var end_month = formObj.end_month.value;
	
	formObj.start_date.value = start_month + "-01";
	formObj.end_date.value = end_month + "-" + ComGetLastDay(end_month.substring(0, 4), ComParseInt(end_month.substring(5,7)));
}

function sheetControl(val){
	var prefix = "sheet1_";
	if( val == "EGSUZ" ){
		
		//sheetObjects[0].ColHidden(prefix+"scg_car_box") = true;
		//SUZ 항목
		//sheetObjects[0].ColHidden(prefix + "scg_lmt_act_ratio") = false;
		//sheetObjects[0].ColHidden(prefix + "scg_lmt_act_spd") = false;		

		sheetObjects[0].ColHidden(prefix + "scg_car_port_cd") = false;
		sheetObjects[0].ColHidden(prefix + "scg_car_tier") = false;
		sheetObjects[0].ColHidden(prefix + "scg_car_teu") = false;
		sheetObjects[0].ColHidden(prefix + "scg_car_ratio") = false;		
		//sheetObjects[0].ColHidden(prefix + "detail") = false;

		
		sheetObjects[0].ColHidden(prefix+"scg_car_box") = false;
		sheetObjects[0].ColHidden(prefix+"scg_car_esti_scg") = false;
		sheetObjects[0].ColHidden(prefix+"scg_car_diff_scg") = false;
		
//		sheetObjects[0].ColHidden(prefix+"rhd_port") = false;
//		sheetObjects[0].ColHidden(prefix+"avr_gros_prd") = false;
//		sheetObjects[0].ColHidden(prefix+"rhd_qty") = false;
//		sheetObjects[0].ColHidden(prefix+"scd_rate") = false;
//		sheetObjects[0].ColHidden(prefix+"exh_rate") = false;
//		sheetObjects[0].ColHidden(prefix+"rhd_charge") = false;
//		sheetObjects[0].ColHidden(prefix+"sv_cost") = false;
		
		sheetObjects[0].ColHidden(prefix + "calc") = false;
		
		//PAPAC항목
		sheetObjects[0].ColHidden(prefix+"allowance") = true;
		sheetObjects[0].ColHidden(prefix+"load_teu") = true;
		sheetObjects[0].ColHidden(prefix+"visi_range") = true;
		sheetObjects[0].ColHidden(prefix+"und_acp_qty") = true;
		sheetObjects[0].ColHidden(prefix+"exd_acp_esti") = true;
		sheetObjects[0].ColHidden(prefix+"exd_acp_actual") = true;
		
		sheetObjects[0].ColHidden(prefix+"cnl_tz_bkg_prd_cd") = true;
		sheetObjects[0].ColHidden(prefix+"cnl_tz_bkg_proc_sts_cd") = true;
		sheetObjects[0].ColHidden(prefix+"cnl_bkg_tz_dt") = true;
		sheetObjects[0].ColHidden(prefix+"cnl_ot_svc_apro_flg") = true;
		sheetObjects[0].ColHidden(prefix+"cnl_ot_svc_arr_dt") = true;
		sheetObjects[0].ColHidden(prefix+"cnl_bkg_amt") = true;

		sheetObjects[0].ColHidden(prefix+"bkg_sts") = false;

		
	}else{
		
		//SUZ항목
		
		//sheetObjects[0].ColHidden(prefix + "scg_lmt_act_ratio") = true;
		//sheetObjects[0].ColHidden(prefix + "scg_lmt_act_spd") = true;		

		sheetObjects[0].ColHidden(prefix + "scg_car_port_cd") = true;
		sheetObjects[0].ColHidden(prefix + "scg_car_tier") = true;
		sheetObjects[0].ColHidden(prefix + "scg_car_teu") = true;
		sheetObjects[0].ColHidden(prefix + "scg_car_ratio") = true;		
		//sheetObjects[0].ColHidden(prefix + "detail") = true;

		
		sheetObjects[0].ColHidden(prefix+"scg_car_box") = true;
		sheetObjects[0].ColHidden(prefix+"scg_car_esti_scg") = true;
		sheetObjects[0].ColHidden(prefix+"scg_car_diff_scg") = true;
		
		sheetObjects[0].ColHidden(prefix+"rhd_port") = true;
		sheetObjects[0].ColHidden(prefix+"avr_gros_prd") = true;
		sheetObjects[0].ColHidden(prefix+"rhd_qty") = true;
		sheetObjects[0].ColHidden(prefix+"scd_rate") = true;
		sheetObjects[0].ColHidden(prefix+"exh_rate") = true;
		sheetObjects[0].ColHidden(prefix+"rhd_charge") = true; 
		sheetObjects[0].ColHidden(prefix+"sv_cost") = true;
		sheetObjects[0].ColHidden(prefix +"calc") = true;
		
		//PAPAC항목
		sheetObjects[0].ColHidden(prefix+"allowance") = false;
		sheetObjects[0].ColHidden(prefix+"load_teu") = false;
		sheetObjects[0].ColHidden(prefix+"visi_range") = false;
		sheetObjects[0].ColHidden(prefix+"und_acp_qty") = false;
		sheetObjects[0].ColHidden(prefix+"exd_acp_esti") = false;
		sheetObjects[0].ColHidden(prefix+"exd_acp_actual") = false;
		
		sheetObjects[0].ColHidden(prefix+"cnl_tz_bkg_prd_cd") = false;
		sheetObjects[0].ColHidden(prefix+"cnl_tz_bkg_proc_sts_cd") = false;
		sheetObjects[0].ColHidden(prefix+"cnl_bkg_tz_dt") = false;
		sheetObjects[0].ColHidden(prefix+"cnl_ot_svc_apro_flg") = false;
		sheetObjects[0].ColHidden(prefix+"cnl_ot_svc_arr_dt") = false;
		sheetObjects[0].ColHidden(prefix+"cnl_bkg_amt") = false;
		sheetObjects[0].ColHidden(prefix+"bkg_sts") = true;

    
	}
	
} 

function setComma( strval ){
	var tmp = strval.split('.');
    var minus = false;
    var str = new Array();


    if(tmp[0].indexOf('-') >= 0) {
        minus = true;
        tmp[0] = tmp[0].substring(1, tmp[0].length); 
    }
    
    var v = tmp[0].replace(/,/gi,'');
    for(var i=0; i<=v.length; i++) {
        str[str.length] = v.charAt(v.length-i);
        if(i%3==0 && i!=0 && i!=v.length) {
            str[str.length] = '.';
        }
    }
    
    str = str.reverse().join('').replace(/\./gi,',');
    if(minus) str = '-' + str;


    return (tmp.length==2) ? str + '.' + tmp[1] : str;

}

