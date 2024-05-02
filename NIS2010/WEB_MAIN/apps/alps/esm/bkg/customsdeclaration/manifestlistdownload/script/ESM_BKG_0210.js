/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0210.js
 *@FileTitle : Customs Data Download
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.06.01
 *@LastModifier : 민정호
 *@LastVersion : 1.1
 * 2009.05.19 이수빈
 * 1.0 Creation
 * -------------------------------------------------------
 * History
 * 2011.06.01 민정호 [CHM-201111028] AMS - Customs Data Download (D/L) 화면 validation 추가
 * 2013.03.19 김보배 [CHM-201323547] [BKG] ACI - Customs Data Download 화면 보완
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/**
 * 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0210() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var isLoaded = false;
var vPod = "";
var vPol = "";
var intervalId = "";
var vStartRow = 2;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	var sheetObject3 = sheetObjects[2];
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_retrieve":
			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			break;

		case "btn_downexcel":
			doActionIBSheet(sheetObject1, formObject, IBDOWNEXCEL);
			break;

		case "btn_datadl":
			doActionIBSheet(sheetObject2, formObject, IBSAVE);
			break;

		case "btn_edi":
			doActionIBSheet(sheetObject2, formObject, SEARCH01);
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
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 * @param sheet_obj IBSheet Object
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
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
		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	if (document.form.customs.value.substring(0, 6) == 'Origin') {
		ComBtnDisable("btn_edi");
	}
	//화면에서 필요한 이벤트
	axon_event.addListenerForm("Click", "obj_Click", document.form);
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	//axon_event.addListenerForm("KeyDown", "obj_KeyDownShiftTab", document.form);
	
	document.form.vvd.focus();
	
	//US AMS Main Menu : VVD 입력시
	if (!ComIsNull(document.form.vvd))
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
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
			
	switch(sheetID) {
     	case "sheet0":      //sheet0 init
			with (sheetObj) {
	
				// 높이 설정
				style.height = 150;
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
				InitRowInfo(1, 1, 2, 100);
	
				var HeadTitle = " |Seq.|POL|ETD|POD|ETA|T.BDR|BDR Time|Full|Empty|Total M.B/L|Total H.B/L";
				var headCount = ComCountHeadTitle(HeadTitle) + 1;
	
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false, false)
	
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
	
				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT,
				// POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS,
				// FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus, 	30, daCenter, true,  "ibflag");
				InitDataProperty(0, cnt++, dtDataSeq, 		40, daCenter, false, "Seq");
				InitDataProperty(0, cnt++, dtData, 			80, daCenter, false, "pol_cd", 		false, "", dfNone, 		  0, false, false);
				InitDataProperty(0, cnt++, dtData, 		   120, daCenter, false, "vps_etd_dt", 	false, "", dfUserFormat2, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 			80, daCenter, false, "pod_cd", 		false, "", dfNone, 		  0, false, false);

				InitDataProperty(0, cnt++, dtData, 		   120, daCenter, false, "vps_eta_dt", 	false, "", dfUserFormat2, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 			50, daCenter, false, "bdr_flg", 	false, "", dfNone, 		  0, false, false);
				InitDataProperty(0, cnt++, dtData, 		   120, daCenter, false, "bdr_dt", 		false, "", dfUserFormat2, 0, false, false);
				InitDataProperty(0, cnt++, dtAutoSum, 		70, daCenter, false, "ful_cnt", 	false, "", dfNone, 		  0, false, false);
				InitDataProperty(0, cnt++, dtAutoSum, 		70, daCenter, false, "emp_cnt", 	false, "", dfNone, 		  0, false, false);

				InitDataProperty(0, cnt++, dtAutoSum, 		95, daCenter, false, "tot_mbl", 	false, "|8|+|9|", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtAutoSum, 		95, daCenter, false, "tot_hbl", 	false, "", dfNone, 		  0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 		10, daCenter, false, "clpt_seq");

				InitUserFormat2(0, "vps_etd_dt", "####-##-## ##:##", "-|:");
				InitUserFormat2(0, "vps_eta_dt", "####-##-## ##:##", "-|:");
				InitUserFormat2(0, "bdr_dt", "####-##-## ##:##", "-|:");
			}
			break;

     case "sheet2":      //sheet2 init
		with (sheetObj) {

			// 높이 설정
			style.height = 300;
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
			InitRowInfo(2, 1, 2, 50);

			var HeadTitle1 = " ||Seq.|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|SHPR|SHPR|CNEE|CNEE|NTFY|NTFY|BDR|C/A No.|Terminal EDI|Terminal EDI||||";
			var HeadTitle2 = " ||Seq.|B/L No.|BKG_NO|Cntr Mf No.|Filer|Empty|I/F|Error|POL|POD|Package|Package|Weight|Weight|N|A|N|A|N|A|BDR|C/A No.|EDI|Sent Time|DEL_CD|POD_NOD_CD|DEL_NOD_CD|BL_TYPE";
			var headCount = ComCountHeadTitle(HeadTitle1) + 3;

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT,
			// POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS,
			// FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 	30, daCenter, true,  "ibflag");
			InitDataProperty(0, cnt++, dtCheckBox, 		30, daCenter, true,  "Chk");
			InitDataProperty(0, cnt++, dtDataSeq,  		40, daCenter, true,  "Seq");
			InitDataProperty(0, cnt++, dtData, 	   		90, daCenter, false, "bl_nos", 	false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden,  	   100, daCenter, false, "bkg_no", 	false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtHidden,   100, daCenter, false, "cntr_mf_no", 	false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 		40, daCenter, false, "filer", 		false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 		50, daCenter, false, "emp_flg", 	false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 		35, daCenter, false, "if_flg", 		false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 		45, daCenter, false, "err_cd", 		false, "", dfNone, 0, false, false);
			
			InitDataProperty(0, cnt++, dtData, 		50, daCenter, false, "pol_cd", 		false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 		50, daCenter, false, "pod_cd", 		false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 		50, daRight,  false, "pck_qty", 	false, "", dfInteger, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 		25, daCenter, false, "pck_tp_cd", 	false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 		60, daRight,  false, "act_wgt", 	false, "", dfFloat, 0, false, false);
			
			InitDataProperty(0, cnt++, dtData, 		30, daCenter, false, "wgt_ut_cd", 	false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 		25, daCenter, false, "shpr_nm", 	false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 		25, daCenter, false, "shpr_ad", 	false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 		25, daCenter, false, "cnee_nm", 	false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 		25, daCenter, false, "cnee_ad", 	false, "", dfNone, 0, false, false);
			
			InitDataProperty(0, cnt++, dtData, 		25, daCenter, false, "ntfy_nm", 	false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 		25, daCenter, false, "ntfy_ad", 	false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 		35, daCenter, true,  "bdr_flg", 	false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 		70, daCenter, true,  "ca_no", 		false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 		35, daCenter, true,  "edi_flg", 	false, "", dfNone, 0, false, false);
			
			InitDataProperty(0, cnt++, dtData, 	   90, daCenter, true,  "edi_snd_dt", 	false, "", dfUserFormat2, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 	60, daCenter, true,  "del_cd", 		false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 	60, daCenter, true,  "pod_nod_cd", 	false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 	60, daCenter, true,  "del_nod_cd", 	false, "", dfNone, 0, false, false);
			// HBL인지 MBL인지(cntr_mf_no를 사용하도 될거 같은데 데이타가 일치하지 않는것이 있음)
			InitDataProperty(0, cnt++, dtHidden, 	60, daCenter, true,  "bl_type", 	false, "", dfNone, 0, false, false);
			
			InitDataProperty(0, cnt++, dtHidden, 	60, daCenter, true,  "bkg_pod_cd", 	false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 	60, daCenter, true,  "bkg_del_cd", 	false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 	60, daCenter, true,  "act_file_skd_dir_cd");

			InitUserFormat2(0, "edi_snd_dt", "####-##-## ##:##", "-|:");

			CountFormat = "[SELECTDATAROW / TOTALROWS]";
		}
		break;

  	case "sheet3":      //sheet3 init
		with (sheetObj) {// 높이 설정
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
			InitRowInfo(1, 1, 2, 100);
			var HeadTitle = "RESULT";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT,
			// POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS,
			// FORMATFIX]
			InitDataProperty(0, cnt++, dtData, 25, daCenter, false, "key", false, "", dfNone, 0, false, false);
		}
		break;

 	case "sheet1":      //sheet1 init
		with (sheetObj) {// 높이 설정
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
			InitRowInfo(1, 1, 2, 100);
			var HeadTitle2 = "||CNTR_NO|BKG_NO|BL_NO|POL|POD";
			var headCount2 = ComCountHeadTitle(HeadTitle2);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount2, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle2, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT,
			// POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS,
			// FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 	30, daCenter, true,  "ibflag");
			InitDataProperty(0, cnt++, dtCheckBox, 	40, 	daCenter, false, "del_chk");
			InitDataProperty(0, cnt++, dtData, 		100, 	daCenter, false, "cntr_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 		100, 	daCenter, false, "bkg_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 		100, 	daCenter, false, "bl_no", false, "", dfNone, 0, false, false);
			
			InitDataProperty(0, cnt++, dtData, 		100, 	daCenter, false, "pol_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 		100, 	daCenter, false, "pod_cd", false, "", dfNone, 0, false, false);
		}
		break;
 	case "sheet4":      //sheet1 init
	with (sheetObj) {// 높이 설정
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
			InitRowInfo(1, 1, 2, 100);
			var HeadTitle2 = "||CNTR_NO|BKG_NO|BL_NO|CNTR_MF_WGT|POL|POD";
			var headCount2 = ComCountHeadTitle(HeadTitle2);
	
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount2, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);
	
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle2, true);
	
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT,
			// POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS,
			// FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 	30, daCenter, true,  "ibflag");
			InitDataProperty(0, cnt++, dtCheckBox, 	40, 	daCenter, false, "del_chk");
			InitDataProperty(0, cnt++, dtData, 		100, 	daCenter, false, "cntr_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 		100, 	daCenter, false, "bkg_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 		100, 	daCenter, false, "bl_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 		100, 	daCenter, false, "cntr_mf_wgt", false, "", dfNone, 0, false, false);			
			
			InitDataProperty(0, cnt++, dtData, 		100, 	daCenter, false, "pol_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 		100, 	daCenter, false, "pod_cd", false, "", dfNone, 0, false, false);
		}
		break;		
	}
}

var allChkFlg = false;
var allChk = 0;

/**
 * Sheet관련 프로세스 처리
 * @param sheetObj Sheet
 * @param formObj form객체
 * @param sAction 작업처리코드
 * @param tabno 탭번호
 */
function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
	//sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;
	
	switch (sAction) {
	case IBSEARCH: //조회
		
		if (!validateForm(sheetObj, formObj, sAction)) return false;
		
		ComOpenWait(true, true);
		sheetObj.Redraw = false;
		
		formObj.f_cmd.value = SEARCH;
		var vvd = formObj.vvd.value.trim();
		formObj.vsl_cd.value = vvd.substring(0, 4);
		formObj.skd_voy_no.value = vvd.substring(4, 8);
		formObj.skd_dir_cd.value = vvd.substring(8, 9);
		formObj.sheet_id.value = sheetObjects[0].id; // sheet0
		
		var sXml = sheetObj.GetSearchXml("ESM_BKG_0210GS.do", FormQueryString(formObj));
		var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
		sheetObj.LoadSearchXml(sXml);
		
		sheetObj.Redraw = true;
		
		if (State == "S") {
			if (formObj.customs.value.substring(0, 6) == 'Origin') {
				sheetObj.ColumnSort("vps_etd_dt", "ASC");
			} else {
				sheetObj.ColumnSort("vps_eta_dt", "ASC");
			}
		}else{
			sheetObj.RemoveAll();
		}

		//Sheet2를 초기화시킨다.
		sheetObjects[1].CheckAll2("Chk") = 0;
		sheetObjects[1].RemoveAll();
		formObj.mbl_tot.value = "";
		formObj.hbl_tot.value = "";
		formObj.bl_ttl.value = "";
		formObj.total.value = "0";

		// POL & POD 입력의 경우 상세화면도 조회한다.
		if (formObj.pol_cd.value != "" && formObj.pod_cd.value != "") {
			if (sheetObj.RowCount > 0) {
				sheet0_OnDblClick(sheetObj, 1, 1);
			}
			else{
				ComOpenWait(false);
			}
		}
		else{
			ComOpenWait(false);
		}
		break;

	case IBSEARCHAPPEND: // 하단 상세 그리드 조회

		if (formObj.pol_cd.value == "" || formObj.pod_cd.value == "") {
			ComOpenWait(true);
		}
		formObj.f_cmd.value = SEARCH;
		
		sheetObj.CheckAll2("Chk") = 0;
		formObj.selected.value = "";
		formObj.sheet_id.value = sheetObjects[1].id;  // sheet2
		formObj.mbl_tot.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "tot_mbl");
		formObj.hbl_tot.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "tot_hbl");

		formObj.bl_ttl.value = parseInt(replaceAll(formObj.mbl_tot.value,",","")) + parseInt(formObj.hbl_tot.value);
		CommaInput(formObj.bl_ttl);
		
		/*
		 * 20100419 경종윤
		 * 과장님 오류가 있어서.. 고쳤슴다.
		 */
		if(formObj.bl_ttl.value != "NaN") {
			formObj.total.value = formObj.bl_ttl.value;
		} else {
			formObj.total.value = "0";
		}
		
		sheetObj.Redraw = false;
		var vClptSeq = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "clpt_seq");
		var sXml = sheetObjects[1].GetSearchXml("ESM_BKG_0210GS.do?pol_cd=" + vPol + "&pod_cd=" + vPod + "&clpt_seq="+ vClptSeq, FormQueryString(formObj));
		var arrXml = sXml.split("|$$|");
		sheetObjects[1].LoadSearchXml(arrXml[0]);
		sheetObjects[1].ColumnSort("bl_nos", "ASC");
		
		allChkFlg = false;
		allChk = 0;
		
		sheetObj.Redraw = true;
		ComOpenWait(false);
		sheetObjects[3].LoadSearchXml(arrXml[1]);
		sheetObjects[4].LoadSearchXml(arrXml[2]);

		break;

	case IBSAVE: // Data Download
//		if (!validateForm(sheetObj, formObj, sAction)) return false;
		
		ComOpenWait(true);
		if (!validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(false);
			return false;
		}

		var sParam;
		if (sheetObjects[0].CheckedRows(1) > 0) {
			formObj.f_cmd.value = MULTI;
			sParam = ComGetSaveString(sheetObjects[0]) + "&" + FormQueryString(formObj);
		} else if (sheetObjects[1].CheckedRows(1) > 0) {
			formObj.f_cmd.value = ADD;
			if(formObj.pol_cd.value == ""){
				formObj.v_pol.value = vPol;
			}
			if(formObj.pod_cd.value == ""){
				formObj.v_pod.value = vPod;
			}
			if (document.form.customs.value == 'Origin US' || document.form.customs.value == 'US') {
				for(var i=2; i<sheetObjects[1].RowCount+2; i++) {
					if (sheetObjects[1].CellValue(i, "Chk") == 1) {
						sheetObjects[1].CellValue2(i, "act_file_skd_dir_cd") = formObj.act_file_skd_dir_cd[formObj.act_file_skd_dir_cd.selectedIndex].value;
					}
				}
			}
            sParam = ComGetSaveString(sheetObjects[1]) + "&" + FormQueryString(formObj);
		}
		var sXml = sheetObj.GetSaveXml("ESM_BKG_0210GS.do", sParam);
		if (ComBkgErrMessage(sheetObjects[0], sXml)) {
			//다운로드 시 30초 이상 걸리는 경우가 발생해서 BackEndJob으로 돌림  3초마다
			var key = ComGetEtcData(sXml, "KEY");
			intervalId = setInterval("doActionValidationResult(sheetObjects[2], '" + key + "');", 3000);
		} else {
			ComOpenWait(false);
		}
		
		break;

	case IBDOWNEXCEL: // EXCEL DOWNLOAD
		if (sheetObjects[0].RowCount == 0) {
			ComShowCodeMessage("BKG00109");
			return;
		} else {
			sheetObjects[0].SpeedDown2Excel(-1, false, false, "", "", false, false, "", true);
		}
		if (sheetObjects[1].RowCount > 0) {
			sheetObjects[1].SpeedDown2Excel(-1, false, false, "", "", false, false, "", true);
		}
		break;

	case SEARCH01: //EDI 전송
		var sheet = sheetObjects[0];
		var param = "";

		if(!formObj.chkAllPol.checked){
			// 체크된 B/L 에 해당하는 Container 체크
			checkCntrNo(sheetObjects[3]);
		}
		
		if (sheetObjects[1].CheckedRows("Chk") == 0 || sheetObjects[3].CheckedRows("del_chk") == 0) {
			if(!formObj.chkAllPol.checked){
				ComShowCodeMessage('BKG00249', ''); // No Seleted Row.
				return false;
			}
			else{
				param = "&allPol=Y";
			}
		}
		param = param + "&inListType=D&inVvdCd=" + formObj.vvd.value + 
			"&inPodCd=" + sheet.CellValue(sheet.SelectRow, "pod_cd") + 
			//"&inPolCd=" + sheet.CellValue(sheet.SelectRow, "pol_cd") +
			"&inBkgCgoTpCd=" + formObj.bkg_cgo_tp_cd.value ;
        ComOpenWindowCenter("ESM_BKG_0723.do?pgmNo=ESM_BKG_0723"+param, "edi", 400, 430, true);
		break;

	case SEARCH03:
		formObj.f_cmd.value = SEARCH;
		formObj.sheet_id.value = sheetObjects[3].id; // sheet1

		ComOpenWait(true, true);
		if(formObj.chkAllPol.checked){
			sheetObj.DoSearch("ESM_BKG_0210GS.do?clpt_seq="+ vClptSeq, FormQueryString(formObj));
			// 모든 pol에 해당하는 전체  Container 체크
			sheetObj.CheckAll2("del_chk") = 1;
		}
		else{
			sheetObj.DoSearch("ESM_BKG_0210GS.do?pol_cd=" + vPol + "&pod_cd=" + vPod + "&clpt_seq="+ vClptSeq, FormQueryString(formObj));
		}
		ComOpenWait(false);
	}
}

/**
 * 저장을 BackEndJob으로 하기 때문에 저장버튼 클릭 후 완료되었는지 확인하는 로직
 * @param sheetObj 시트오브젝트
 * @param sKey BackEndJob Key
 */
function doActionValidationResult(sheetObj, sKey) {
	var sXml = sheetObjects[2].GetSearchXml("ESM_BKG_0210GS.do?f_cmd=" + SEARCH03 + "&key=" + sKey);
	var sJbStsFlg = ComGetEtcData(sXml, "jb_sts_flg");
	// 에러가 발생했을 경우 대기사항을 종료한다.
	if (!ComBkgErrMessage(sheetObjects[2], sXml)) {
		clearInterval(intervalId);
		ComOpenWait(false);
		return;
	}
	if (sJbStsFlg == "SUCCESS") {
		clearInterval(intervalId);
		ComOpenWait(false);
		// 성공메시지 보여주고
		ComShowMessage(ComResultMessage(sXml));
		// sheet2다시 조회
		sheetObjects[1].RemoveAll();
		document.form.selected.value = "0";
		if (document.form.f_cmd.value == MULTI) {
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "", 1);
		} else {
			doActionIBSheet(sheetObjects[1], document.form, IBSEARCHAPPEND, "", 1);
		}
		return;
	} else if (sJbStsFlg == "FAIL") {
		// 에러
		clearInterval(intervalId);
		ComOpenWait(false);
		// 에러메시지 보여주고 종료
		ComShowCodeMessage('BKG95019');  // Failed to download. Please try again.
	}
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
			if (!ComChkRequired(formObj))
				return false;
			if (!ComChkValid(formObj))
				return false;
			if (formObj.pageNo.value == "ESM_BKG-0210_2") {
				if (formObj.pod_cd.value == "" && formObj.customs_cd.value == "") {
					ComShowMessage(ComGetMsg("BKG01030"));
					formObj.pod_cd.focus();
					return false;
				}
			}
			return true;
			break;
		case IBSAVE:		
			if (sheetObjects[1].CheckedRows(1) == 0) {
				//선택된 내역이 없을경우
				ComShowCodeMessage('BKG00333'); // Nothing To Select
				return false;
			}
			
			var iChkRow = sheetObjects[1].FindCheckedRow("Chk");
			var arrRow = iChkRow.split("|");
			var vBl_No = 0;
			var vIndex = 1;
			var vCntrMfWgt = 0;
			var vCntrMfWgt20 = '';
			
			for (var idx=0; idx<arrRow.length-1; idx++){ 
				vBl_No = sheetObjects[1].CellValue(arrRow[idx], "bl_nos");
				
				while(vIndex > 0){
					vIndex = sheetObjects[4].FindText('bl_no',vBl_No,vIndex);
					if(vIndex > 0){
						vCntrMfWgt = sheetObjects[4].CellValue(vIndex,"cntr_mf_wgt");
						vCntrMfWgt20 = String(parseInt(vCntrMfWgt)*20);	
//						alert("vBl_No = "+vBl_No+
//								"\n vIndex = "+vIndex+
//								"\n vCntrMfWgt = "+vCntrMfWgt+
//								"\n vCntrMfWgt20 = "+vCntrMfWgt20);
						if(vCntrMfWgt20.length > 8){
							ComShowCodeMessage('BKG01125',vBl_No,vCntrMfWgt);
							return false;
						}				
						vIndex = vIndex + 1;
					}
				}
				vIndex = 1;
			}
			
			if (document.form.customs.value == 'Origin US' || document.form.customs.value == 'US') {
				if (sheetObjects[1].CellValue(2, "pol_cd").substring(0,2) == 'CA') {
					var vActFlg = true;
					var vActDirCd = "";
					for ( var i = 2; i < sheetObjects[1].RowCount + 2; i++) {
						if (sheetObjects[1].CellValue(i, "act_file_skd_dir_cd") != "") {
							vActDirCd = sheetObjects[1].CellValue(i, "act_file_skd_dir_cd");
							break;
						}
					}
					if (vActDirCd != "" && vActDirCd != formObj.act_file_skd_dir_cd[formObj.act_file_skd_dir_cd.selectedIndex].value) {
						if (ComShowCodeConfirm('BKG04022', formObj.act_file_skd_dir_cd[formObj.act_file_skd_dir_cd.selectedIndex].value)) {
							sheetObjects[1].CheckAll("Chk") = 1;
							return true;
						} else {
							return false;
						}
					}
				}
			}
			if (!ComShowCodeConfirm("BKG00350")) {
				return false;
			}
			break;
		}
	return true;
}

/**
 * 조회 후 처리
 * @param sheetObj Sheet
 * @param ErrMsg 에러메시지
 */
function sheet0_OnSearchEnd(sheetObj, ErrMsg) {
	if (ErrMsg == "") {
		if (document.form.customs.value.substring(0, 6) == 'Origin') {
			sheetObj.ColumnSort("vps_etd_dt", "ASC");
		} else {
			sheetObj.ColumnSort("vps_eta_dt", "ASC");
		}
	}
	document.form.selected.value = "";
	if (document.form.customs.value == 'Origin US' || document.form.customs.value == 'US') {
		document.form.act_file_skd_dir_cd[0].selected = true;
	}
	if (sheetObj.RowCount > 0) {
		sheetObj.CellValue2(sheetObj.LastRow, 1) = "";
		sheetObj.CellValue2(sheetObj.LastRow, "bdr_dt") = "SUM";
		sheetObj.CellAlign(sheetObj.LastRow, "bdr_dt") = daCenter;
	}
}

/**
 * 상세조회
 * @param sheetObj Sheet
 * @param Row Row Index
 * @param Col Col Index
 */
function sheet0_OnDblClick(sheetObj, Row, Col) {
	sheetObjects[1].RemoveAll();
	// 상세조회할때 POL, POD을 세팅하고 조회한다. 저장 후 다시 상세조회 시 사용하기 위해서.
	vPod = sheetObj.CellValue(Row, "pod_cd");
	vPol = sheetObj.CellValue(Row, "pol_cd");
	
	if(document.form.chkAllPol != undefined && document.form.chkAllPol.checked){
		document.form.chkAllPol.checked = false;
	}
	if (document.form.customs.value == 'Origin US' || document.form.customs.value == 'US') {
		if (vPol.substring(0,2) == 'CA')
		{
			if (document.form.vvd.value.substring(8) == "E")
			{
				document.form.act_file_skd_dir_cd[2].selected = true;
			}
			else
			{
				document.form.act_file_skd_dir_cd[1].selected = true;
			}
		}
	}
	doActionIBSheet(sheetObjects[1], document.form, IBSEARCHAPPEND, FormQueryString(document.form), 1);
}

/**
 * Booking Creation 화면 이동
 * @param sheetObj Sheet
 * @param Row Row Index
 * @param Col Col Index
 */
function sheet2_OnDblClick(sheetObj, Row, Col) {
	if (sheetObj.ColSaveName(Col) != "bl_nos") return;
	
	ComBkgCall0079(sheetObj.CellValue(Row, "bkg_no"));

//	var sParam = "&bl_no=" + sheeObj.CellValue(Row, Col) + "&bkg_no=" + sheetObj.CellValue(Row, "bkg_no");
//	var sParam = "&bl_no=" + sheeObj.CellValue(Row, Col) + "&bkg_no=" + sheetObj.CellValue(Row, "bkg_no");
//	ComOpenWindow2("ESM_BKG_0079.do?pgmNo=ESM_BKG_0079" + sParam, "popup", "width=1024,height=768");
//	var param= "?bl_no="+sheetObj.CellValue(rowIdx, prefix+"bl_no");
//	ComOpenWindowCenter2("/hanjin/ESM_BKG_0079_Q.do"+sParam, "BL Preview", 1024,740,true,"scrollbars=yes,resizable=yes");
//	ComOpenWindowCenter2("/hanjin/ESM_BKG_0079_Q.do"+param, "Booking Main", 1024,740,false,"scrollbars=yes,resizable=yes");
}

var vDisableChkCnt = 0;
/**
 * sheet2(상세조회) 조회 후 BDR 이후 및 에러의 경우 체크박스 처리
 * @param sheetObj Sheet
 * @param ErrMsg 에러메시지
 */
function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
	vDisableChkCnt = 0;
	//BDR 이후에 Origin메뉴의 경우 체크박스 Disabled
	var sheet0 = sheetObjects[0];
	if (document.form.customs.value.substring(0, 6) == 'Origin') {
		var findIdx = sheet0.findText("pod_cd", vPod);
	}
	
	for (i = 2; i < sheetObj.RowCount + 2; i++) {
		if(sheet0.CellText(findIdx, "bdr_flg") == 'Y'){
			sheetObj.CellValue2(i, "Chk") = '0';
			sheetObj.CellEditable(i, "Chk") = false;
			vDisableChkCnt++;
		}
		
		//에러 있으면 체크박스 Disabled
		if (sheetObj.CellValue(i, "err_cd") != "") {
			sheetObj.ToolTipText(i, "err_cd") = error_desc(sheetObj.CellValue(i, "err_cd"));
			sheetObj.CellValue2(i, "Chk") = '0';
			sheetObj.CellEditable(i,"Chk") = false;
			vDisableChkCnt++;
		}
		
		switch (sheetObj.CellText(i, "filer")) {
		case '1':
			sheetObj.ToolTipText(i, "filer") = 'CARRIER’S FILING NVOCC';
			break;
		case '2':
			sheetObj.ToolTipText(i, "filer") = 'SELF-FILING NVOCEE';
			break;
		case '3':
			sheetObj.ToolTipText(i, "filer") = 'NOT APPLICABLE';
			break;
		}
	}
	//HB/L의 경우 파란색글자
	var blueColor = sheetObj.RgbColor(0, 0, 255);
	for (i = 2; i < sheetObj.RowCount + 2; i++) {
		if (sheetObj.CellText(i, "cntr_mf_no") != '')
			// sheetObj.RowFontColor(i) = blueColor;
			sheetObj.CellFont("FontColor", i, "bl_nos") = blueColor;
	}

	//빨간색글자
	var redColor = sheetObj.RgbColor(255, 0, 0);
	for (i = 2; i < sheetObj.RowCount + 2; i++) {
		for (j = 16; j < 28; j++) {
			//Customer 정보가 N의 경우
			if (sheetObj.CellText(i, j) == 'N') {
				sheetObj.CellFont("FontColor", i, j) = redColor;
			}
		}
		//에러코드
//		sheetObj.CellFont("FontColor", i, "err_cd") = redColor;
		sheetObj.CellFontColor(i, "err_cd") = sheetObj.RgbColor(255, 0, 0);
		sheetObj.CellFont("FontUnderline", i, "err_cd") = true;
		sheetObj.CellFont("FontUnderline", i, "bl_nos") = true;
	}
	
	//sheetObj.SelectRow = sheetObj.HeaderRows;
	if(sheetObj.RowCount == "1"){
		sheetObj.SelectHighLight = false;
	}
	

}

/**
 * 시트에 마우스 오버 시 툴팁 보여주기
 * @param sheetObj 시트오브젝트
 * @param Button 마우스버튼 방향
 * @param Shift Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
 * @param X X 좌표
 * @param Y Y 좌표
 */
function sheet2_OnMouseMove(sheetObj, Button, Shift, X, Y) {
	//마우스 위치를 행과 컬럼과 값 가져오기
	Row = sheetObj.MouseRow;
	Col = sheetObj.MouseCol;
	sText = sheetObj.CellText(Row, Col);

	// 풍선도움말 만들기
	// MouseToolTipText = sText;

	if (sheetObj.ColSaveName(Col) == "err_cd" && sText != "") {
		sheetObj.MousePointer = "Hand";
	} else if (sheetObj.ColSaveName(Col) == "bl_nos") {
		sheetObj.MousePointer = "Hand";
	} else {
		sheetObj.MousePointer = "Default";
	}
}

/**
 * sheet2 All 체크시 체크플래그 세팅
 * @param sheetObj 시트오브젝트
 * @param Button 마우스버튼 방향
 * @param Shift Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
 * @param X X 좌표
 * @param Y Y 좌표
 */
function sheet2_OnMouseDown(sheetObj, Button, Shift, X, Y) {
	if ((sheetObj.MouseRow == 0 || sheetObj.MouseRow == 1) && sheetObj.MouseCol == 1) {
		allChkFlg = true;
		
		if(allChk == 0) {
			allChk = 1;
		}else{
			allChk = 0;
		}
	}
	else{
		allChkFlg = false;
		if (Shift != 1) {
 			vStartRow = sheetObj.MouseRow;
 		}
	}
}

/**
 * sheet2 All 체크시 체크개수세팅
 * @param sheetObj 시트오브젝트
 * @param Button 마우스버튼 방향
 * @param Shift Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
 * @param X X 좌표
 * @param Y Y 좌표
 */
function sheet2_OnMouseUp(sheetObj, Button, Shift, X, Y) {
	var formObj = document.form;
	if (allChkFlg)
	{	
		if (sheetObj.CheckedRows("Chk") > 0){
			formObj.selected.value = parseInt(replaceAll(formObj.bl_ttl.value,",","")) - vDisableChkCnt;
		}
		else { 
			formObj.selected.value = "0";
		}
	}
//	if (formObj.selected.value != formObj.bl_ttl.value) {
	if (replaceAll(formObj.selected.value,",","") != replaceAll(formObj.bl_ttl.value,",","")) {
		formObj.selected.style.color = "red";
		formObj.selected.style.fontWeight = "bold";
	} else {
		formObj.selected.style.color = "black";
		formObj.selected.style.fontWeight = "normal";
	}
	if (Shift == 1) {
 		for ( var i = vStartRow; i <= sheetObj.SelectRow; i++) {
 			if (sheetObj.CellEditable(i, "Chk")) {
 	 			sheetObj.CellValue2(i, "Chk") = "1";
			}
 		}
 	}
}

/**
 * sheet2 체크시 form의 selected B/L Count항목에 체크한 BL개수 세팅
 * @param sheetObj Sheet
 * @param Row Row Index
 * @param Col Col Index
 * @param Value 변경값
 */
function sheet2_OnChange(sheetObj, Row, Col, Value) {
	var formObj = document.form;
	if (!allChkFlg) {
		formObj.selected.value = sheetObj.CheckedRows("Chk");
	}
}

/**
 * Terminal EDI 전송 시 CntrNo 체크
 * @param sheetObj 시트오브젝트
 */
function checkCntrNo(sheetObj){
	var formObj = document.form;
	var idx;
	var blNo;
	
	sheetObj.CheckAll2("del_chk") = 0;
	for ( var h=2; h<=sheetObjects[1].RowCount+2; h++ ){
		if(sheetObjects[1].CellValue(h, "Chk") == 0) continue;
		blNo = sheetObjects[1].CellValue(h, "bl_nos");
		idx = sheetObj.findText("bl_no", blNo);
		for ( var i=idx; i<= sheetObj.RowCount; i++ ){
			if(sheetObj.CellValue(i, "bl_no") != blNo) break;
			sheetObj.CellValue2(i, "del_chk") = sheetObjects[1].CellValue(h, "Chk");
		}
	}
}

/**
 * 에러코드값
 * @param error_type 에러타입
 */
function error_desc(error_type) {
	var error_desc;
	switch (error_type) {
	case "B":
		error_desc = "B/L No.is not Assigned";
		break;
	case "S":
		error_desc = "BKG Status is not Firmed";
		break;
	case "H":
		error_desc = "H.B/L & AMS File No.is missing for Filer Type '01'";
		break;
	case "C":
		error_desc = "Container No.or Seal No. is missing";
		break;
	case "P":
		error_desc = "Piece count un-match (M.B/L & H.B/L TTL vs. C/M Sum ) or C/M is missing";
		break;
	case "F":
		error_desc = "Filer Type is missing";
		break;
	case "A":
		error_desc = "Consignee(or Notify in case of “To Order”) information is missing";
		break;
	case "D":
		error_desc = "Number of C/M limitation is exceed (maximum is 1,000 count)";
		break;
	case "E":
		error_desc = ComGetMsg("BKG06145"); //"There is no CNTR No. in BKG No. please check it again.";
		break;
	}
	return error_desc;
}

/**
 * 조회조건 입력할 때 MaxLength까지 입력하면 다음탭으로 이동
 */
function obj_KeyUp() {
	 var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	var formObject = document.form;
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	if (keyValue != 9 && keyValue !=16 &&ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}

/**
 * Terminal EDI 전송 시 All Pol 체크, 언체크 시 Container 조회
 */
function obj_Click() {
	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	
	if (srcName == "chkAllPol") {
		if(sheetObjects[0].TotalRows == 0) {
			formObject.chkAllPol.checked = false;
			ComShowCodeMessage('BKG00882'); // Please retrieve data first.
			return;
		}
		if(sheetObjects[1].TotalRows > 0) {
			sheetObjects[1].CheckAll2("Chk") = 0;
		}
		doActionIBSheet(sheetObjects[3], formObject, SEARCH03);
	}
}

/**
 * 값을 치환
 * @param strTemp 
 * @param strValue1 
 * @param strValue2 치환 변수
 * @return
 */
 function replaceAll(strTemp,strValue1,strValue2) {
      while(1){
     	 if(strTemp.indexOf(strValue1) != -1)
     		 strTemp = strTemp.replace(strValue1,strValue2);
     	 else
     		 break;
      }
      return strTemp;
 }