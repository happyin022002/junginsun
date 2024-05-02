/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0030.js
*@FileTitle : Korea Manifest Amend
*Open Issues : 
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.07.02 박상훈
* 1.0 Creation
=========================================================*/

/**
 * JSDOC 생성을 위한 함수 정의
 */
function esm_bkg_0030()
{
	this.processButtonClick 		= processButtonClick;
	this.doNew						= doNew;
	this.checkBtnStatus				= checkBtnStatus;
	this.setSheetObject				= setSheetObject;
	this.loadPage					= loadPage;
	this.initSheet					= initSheet;
	this.doActioIBSheet				= doActionIBSheet;
	this.validateForm				= validateForm;
	this.sheet1_OnLoadFinish		= sheet1_OnLoadFinish;
	this.sheet1_OnClick				= sheet1_OnClick;
	this.sheet1_OnDblClick			= sheet1_OnDblClick;
	this.addBlInfo					= addBlInfo;
	this.checkBound					= checkBound;
	this.initCombo					= initCombo;
	this.combo1_OnChange			= combo1_OnChange;
	this.combo1_OnKeyDown			= combo1_OnKeyDown;
	this.setComboObject				= setComboObject;
	this.changeErrorColor			= changeErrorColor;
	this.showAllRows				= showAllRows;
	this.showOnlyErrRows			= showOnlyErrRows;
	this.updateSummary				= updateSummary;	
}

//공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

		case "btn_Retrieve":
			sheetObject.RemoveAll();
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
			updateSummary();
			break;

		case "btn_New":
			doNew(formObject);
			updateSummary();
			break;

		case "btn_DownExcel":
			var exceptLines = "";
			var chkCnt = 0;
			// 체크 안된 데이터들 묶음
			for(var i=2; i < sheetObject.RowCount+2; i++) {
				if (sheetObject.CellValue(i, "Sel")==0) 
					exceptLines = exceptLines + "|" + i;
				else {
					chkCnt++;
				}
			}			
			if (chkCnt > 0) {
				sheetObject.Redraw = false;
				sheetObject.Down2Excel(-1, false, false, true, "", "", false, false, "", false, "Sel", exceptLines);
				sheetObject.Redraw = true; 
			}else {
				ComShowCodeMessage('BKG00394');
			}
			break;

		case "btn_Print":
			var chkCnt = 0;
			var params = "f_cmd="+SEARCH03;
			// 체크된 데이터들 묶음
			for(var i=1; i <= sheetObject.RowCount+1; i++) {
				if (sheetObject.CellValue(i, "Sel")==1) { 
					params = params + "&ibflag=R"+ 
							 "&in_type=" + formObject.in_type.value +
							 "&vvd=" + formObject.vvd.value +
					         "&pol_cd="+formObject.pol_cd.value+
					         "&pod_cd="+formObject.pod_cd.value+
					         "&yard_cd="+formObject.yard_cd.value+					         
					         "&bl_no="+sheetObject.CellValue(i, "bl_no")+
					         "&msn_no="+sheetObject.CellValue(i, "mst_bl_seq_no")+
					         "&bkg_no="+sheetObject.CellValue(i, "bkg_no");
					if (formObject.io_bnd_cd[0].checked) {
						params = params + "&io_bnd_cd=I";
					}else {
						params = params + "&io_bnd_cd=O";
					}
					chkCnt++;
				}
			}			
			if (chkCnt > 0) {	
				ComOpenWait(true);
				// Sheet2에 조회 XML 생성
				var sXml = sheetObject1.GetSearchXml("ESM_BKG_0030GS.do", params, "", true);
				sheetObject1.LoadSearchXml(sXml, false, -1, false);
				// 정렬
				sheetObject1.ColumnSort("snd_dt");
				ComOpenWait(false);
				if (sheetObject1.RowCount > 0) {
					ComOpenWindowCenter("/hanjin/ESM_BKG_0851.do?pgmNo=ESM_BKG_0851", "0851", 1024, 720, false);
				} else {
					ComShowCodeMessage('BKG00394');
				}
			}else {
				ComShowCodeMessage('BKG00394');
				ComOpenWait(false);
			}
			break;

		case "btn_BLInfo":
			addBlInfo();
			break;

		case "io_bnd_cd":
			checkBound();
			break;
		case "pol_cd":
			formObject.io_bnd_cd[1].checked=true;
			checkBound();
			formObject.pol_cd.focus();
			break;
		case "pod_cd":
			formObject.io_bnd_cd[0].checked=true;
			checkBound();
			formObject.pod_cd.focus();
			break;
		case "only_error":
			if (formObject.only_error[0].checked) {
				sheetObject.Redraw = false;
				showAllRows(sheetObject);
				sheetObject.Redraw = true;
			}else {
				sheetObject.Redraw = false;
				showOnlyErrRows(sheetObject);
				sheetObject.Redraw = true;
			}
			updateSummary();
			break;

		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * NEW 버튼 클릭시 초기화
 * @param formObject
 * @return
 */
function doNew(formObject)
{
	formObject.reset();
	sheetObjects[0].RemoveAll();
	checkBound();
	formObject.vvd.focus();
	checkBtnStatus();
}

/**
 * 버튼 상태 처리 
 * @return
 */
function checkBtnStatus()
{
	var sheetObj = sheetObjects[0];
	
	if (sheetObj.RowCount < 1) {
		ComBtnDisable("btn_DownExcel");
		ComBtnDisable("btn_Print");
		ComBtnDisable("btn_BLInfo");	
	}else {
		ComBtnEnable("btn_DownExcel");
		ComBtnEnable("btn_Print");
		ComBtnEnable("btn_BLInfo");
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

	for(i=0;i<sheetObjects.length;i++){

		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet (sheetObjects[i] );

		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);		
	}
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
    axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
    axon_event.addListener('keydown', 'ComKeyEnter', 'form');		 
           
}


/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {

	var cnt = 0;

	switch(sheetNo) {
	case 1:      //sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 350;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 2, 100);

			var HeadTitle1 = "Sel|Seq.|B/L No.|BKG No.|MSN|STS|TP|FE|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|SHPR|SHPR|CNEE|CNEE|NTFY|NTFY|CNTR|BAC|W/H|DESC|T/R|S/C|ELNO|ELNO|Customer Name|CM|BZ|||";
			var HeadTitle2 = "Sel|Seq.|B/L No.|BKG No.|MSN|STS|TP|FE|POL|POD|Package|Package|Weight|Weight|Measure|Measure|N|A|N|A|N|A|CNTR|BAC|W/H|DESC|T/R|S/C| | |Customer Name|CM|BZ|||";


			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 8, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false,false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			//데이터속성           [ROW, COL,  DATATYPE,   WIDTH,      DATAALIGN, COLMERGE,   SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtCheckBox,	50,			daCenter,	true,		"Sel");
			InitDataProperty(0, cnt++ , dtDataSeq,	30,			daCenter,	true,		"Seq");
			InitDataProperty(0, cnt++ , dtData,		90,			daCenter,	true,		"bl_no",				false,		"",	dfNone,			0,	false,  false);
			InitDataProperty(0, cnt++ , dtData,		90,			daCenter,	true,		"bkg_no",				false,		"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		40,			daCenter,	true,		"mst_bl_seq_no",		false,		"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		50,			daCenter,	true,		"kr_bl_amdt_sts_cd",	false,		"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		40,			daCenter,	true,		"cstms_decl_tp_cd",		false,		"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		40,			daCenter,	true,		"bkg_cgo_tp_cd",		false,		"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		40,			daCenter,	true,		"pol_cd",				false,		"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		40,			daCenter,	true,		"pod_cd",				false,		"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		60,			daRight,	true,		"pck_qty",				false,		"",	dfInteger,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		25,			daCenter,	true,		"pck_tp_cd",			false,		"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		70,			daRight,	true,		"cntr_ttl_wgt",			false,		"",	dfFloat,		3,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		35,			daCenter,	true,		"wgt_ut_cd",			false,		"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		70,			daRight,	true,		"meas_qty",				false,		"",	dfFloat,		3,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		35,			daCenter,	true,		"bl_meas_ut_cd",		false,		"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		30,			daCenter,	true,		"s_nm",					false,		"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		30,			daCenter,	true,		"s_addr",				false,		"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		30,			daCenter,	true,		"c_nm",					false,		"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		30,			daCenter,	true,		"c_addr",				false,		"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		30,			daCenter,	true,		"n_nm",					false,		"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		30,			daCenter,	true,		"n_addr",				false,		"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		50,			daCenter,	true,		"cntr_cnt",				false,		"",	dfNullInteger,	0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		40,			daCenter,	true,		"bd_area_cd",			false,		"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		40,			daCenter,	true,		"wh",					false,		"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		40,			daCenter,	true,		"cgo_desc1",			false,		"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		40,			daCenter,	true,		"mf_snd_dt",			false,		"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		40,			daCenter,	true,		"kr_cstms_bl_tp_cd",	false,		"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		30,			daCenter,	true,		"elno_a",				false,		"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		30,			daCenter,	true,		"elno_b",				false,		"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		200,		daLeft,		true,		"cust_nm",				false,		"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		40,			daCenter,	true,		"cmdt_cd",				false,		"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		40,			daCenter,	true,		"biz_rgst_no",			false,		"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtHidden,	40,			daCenter,	true,		"error_check",			false,		"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtHidden,	40,			daCenter,	true,		"c_trns_seq",			false,		"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtHidden,	40,			daCenter,	true,		"dmst_port_cd",			false,		"",	dfNone,			0,	false,	false);
		}
		break;
	case 2:      //sheet2 init
	with (sheetObj) {
		
		// 높이 설정
		style.height = 0;
		//전체 너비 설정
		SheetWidth = mainTable.clientWidth;
		
		//Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
		//전체Merge 종류 [선택, Default msNone]
		MergeSheet = msHeaderOnly;
		
		//전체Edit 허용 여부 [선택, Default false]
		Editable = true;
		
		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo(1, 1, 2, 100);
		
		var HeadTitle1 = "MSN|MRN_NO|BL_TP_CD|P1|C1|BL_NO|SEND_DT";
		var headCount = ComCountHeadTitle(HeadTitle1);
		
		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(headCount, 8, 0, true);
		
		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(true, true, true, true, false,false);
		
		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle1, true);
		
		//데이터속성           [ROW, COL,  DATATYPE,   WIDTH,      DATAALIGN, COLMERGE,   SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		InitDataProperty(0, cnt++ , dtData,		140,		daCenter,	true,		"msn_no");
		InitDataProperty(0, cnt++ , dtData,		140,		daCenter,	true,		"mrn_no");
		InitDataProperty(0, cnt++ , dtData,		140,		daCenter,	true,		"bl_tp_cd");
		InitDataProperty(0, cnt++ , dtData,		140,		daCenter,	true,		"p1");
		InitDataProperty(0, cnt++ , dtData,		140,		daCenter,	true,		"c1");
		InitDataProperty(0, cnt++ , dtData,		140,		daCenter,	true,		"bl_no");
		InitDataProperty(0, cnt++ , dtData,		140,		daCenter,	true,		"snd_dt");
		
		CountPosition  = 0;
	}
	break;
	case 3:      //sheet3 init
		with (sheetObj) {
			
			// 높이 설정
			style.height = 0;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
			
			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;
			
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 2, 100);
			
			var HeadTitle1 = "BKG_NO|CNTR_NO|TP_CD";
			var headCount = ComCountHeadTitle(HeadTitle1);
			
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 8, 0, true);
			
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false,false);
			
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			
			//데이터속성           [ROW, COL,  DATATYPE,   WIDTH,      DATAALIGN, COLMERGE,   SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtData,		140,		daCenter,	true,		"bkg_no");
			InitDataProperty(0, cnt++ , dtData,		140,		daCenter,	true,		"cntr_no");
			InitDataProperty(0, cnt++ , dtData,		140,		daCenter,	true,		"bkg_cgo_tp_cd");
			
			CountPosition  = 0;
		}
		break;

	}
}

//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
	case IBSEARCH:      //조회
		if(validateForm(sheetObj,formObj,sAction)) {
			formObj.f_cmd.value = SEARCH;
			sheetObj.Redraw = false;
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			var sXml = sheetObj.getSearchXml("ESM_BKG_0030GS.do", FormQueryString(formObj));
			var arrXml = sXml.split("|$$|");
			sheetObj.LoadSearchXml(arrXml[0]);
			sheetObjects[2].LoadSearchXml(arrXml[1]);
			changeErrorColor(sheetObj);
			if (formObj.only_error[1].checked) showOnlyErrRows(sheetObj);			
			sheetObj.Redraw = true;			
			// MRN UPDATE
			formObj.mrn_no.value = sheetObj.EtcData('mrn_no') + sheetObj.EtcData('mrn_chk_no');			
			checkBtnStatus();
			ComOpenWait(false);
		}
		break;
	}

}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		if (formObj.vvd.value.length < 8) {
			ComShowCodeMessage('BKG00115');
			formObj.vvd.focus();
			return false;
		}
		if (formObj.io_bnd_cd[0].checked) {
			if (formObj.pod_cd.value.length < 5) {
				ComShowCodeMessage('BKG00203');
				formObj.pod_cd.focus();
				return false;
			}
		}else {
			if (formObj.pol_cd.value.length < 5) {
				ComShowCodeMessage('BKG00209');
				formObj.pol_cd.focus();
				return false;
			}
		}
	}

	return true;
}

/**
 * SHEET1 로드 완료 이벤트 처리
 * @param sheetObj
 * @return
 */
function sheet1_OnLoadFinish(sheetObj) {
	for(var k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],k+1);
    }
	
	// TYPE 비활성화 체크
	checkBound();
	doNew(document.form);
	
	if (document.form.strOfc_cd.value.substring(0,5)=="SELSC") {
    	document.form.io_bnd_cd[1].checked = true;
    	checkBound();
    }
}

/**
 * 클릭시 처리
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Val
 * @return
 */
function sheet1_OnClick(sheetObj, Row, Col, Val) {
	if (Row > 1 && Col == 2) {
		if (sheetObj.CellValue(Row, "Sel")==0)
			sheetObj.CellValue(Row, "Sel")=1;
		else
			sheetObj.CellValue(Row, "Sel")=0;
	}
}

/**
 * 더블클릭 처리
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Val
 * @return
 */
function sheet1_OnDblClick(sheetObj, Row, Col, Val) {
	if (Row > 1)
	{
		addBlInfo(); 
	}
}

/**
 * BL INFO 로 넘김
 * @return
 */
function addBlInfo()
{
	 var form = document.form;
	 var row = sheetObjects[0].SelectRow;
	 var params;
	 
	 // 체크되어있으면 EDIT 로 그 외에는 ADD BL로 처리
	 if (sheetObjects[0].CellValue(row, "Sel")==1) {
		 params="pgmNo=ESM_BKG_0031&mode=EDIT&io_bnd_cd=";
		 if (form.io_bnd_cd[0].checked) {
		 	params = params + "I";
		 	params = params + "&port_cd="+form.pod_cd.value;
		 	if (form.pod_cd.value==sheetObjects[0].CellValue(row,"pod_cd")) {
		 		params = params + "&cgo_spec_clear=Y";
		 	}
		 } else {
		 	params = params + "O";
		 	params = params +"&port_cd="+form.pol_cd.value;
		 }
		 params = params + "&pol_cd="+form.pol_cd.value+"&pod_cd="+form.pod_cd.value;
		 params = params + "&vvd="+form.vvd.value+"&bl_no="+sheetObjects[0].CellValue(row, "bl_no");
		 params = params + "&bkg_no="+sheetObjects[0].CellValue(row, "bkg_no");
		 params = params + "&cstms_decl_tp_cd="+sheetObjects[0].CellValue(row,"cstms_decl_tp_cd");
		 params = params + "&c_trns_seq="+sheetObjects[0].CellValue(row,"c_trns_seq");
		 params = params + "&dmst_port_cd="+sheetObjects[0].CellValue(row,"dmst_port_cd");
		 params = params + "&msn_no="+sheetObjects[0].CellValue(row, "mst_bl_seq_no");
		 params = params + "&in_type="+form.in_type.value;
		 
		 
	 }else {
	 	params = "pgmNo=ESM_BKG_0031&mode=ADD&io_bnd_cd=";
	 	if (form.io_bnd_cd[0].checked) {
		 	params = params + "I";
		 	params = params + "&port_cd="+form.pod_cd.value;
		 } else {
		 	params=params + "O";
		 	params = params +"&port_cd="+form.pol_cd.value;
		 }
		 params = params + "&pol_cd="+form.pol_cd.value + "&pod_cd=" + form.pod_cd.value + "&vvd="+form.vvd.value;	
	 }
	 
	 ComOpenPopup("/hanjin/ESM_BKG_0031.do?"+params, 1024, 600, "0002", "1,0", false);
}

/**
 * In / Out Bound 구분에 따른 처리
 * @return
 */
function checkBound()
{
	var formObj = document.form;
	
	if (formObj.io_bnd_cd[0].checked) {
		// IN-BOUND
		comboObjects[0].Enable=false;
		formObj.in_type.value ="";
		formObj.pod_cd.className="input1";
		formObj.pod_cd.disabled = false;
		formObj.pol_cd.className="input2";
		formObj.pol_cd.disabled = true;
		formObj.pol_cd.value="";
		formObj.yard_cd.className="input";
		formObj.yard_cd.disabled = false;
	}else {
		// OUT-BOUND
		comboObjects[0].Enable=true;
		formObj.in_type.value="A";
		comboObjects[0].Code2 = "A";
		formObj.pod_cd.className="input2";
		formObj.pod_cd.disabled = true;
		formObj.pod_cd.value = "";		
		formObj.pol_cd.className="input1";
		formObj.pol_cd.disabled = false;
		formObj.yard_cd.className="input2";
		formObj.yard_cd.disabled = true;
		formObj.yard_cd.value = "";
	}
	
}

/**
 * 콤보 초기화
 * @param comboObj
 * @param comboNo
 * @return
 */
function initCombo(comboObj, comboNo) {
	var cnt = 0;	
	switch(comboObj.id) {
	case "combo1":
		with (comboObj) {
			SetColAlign("center|left");
			SetColWidth("50|100");			
			DropHeight = 400;
			ShowCol = 0;
			SetTitle("Type|Description");
			MultiSelect = false;
			MaxSelect = 1 ;
			InsertItem(cnt ++, "A|미주 LOCAL", "A");
			InsertItem(cnt ++, "B|아/구주 LOCAL", "B");
			InsertItem(cnt ++, "C|T/S", "C");
			InsertItem(cnt ++, "D|A+B+C+M", "D");
			InsertItem(cnt ++, "M|eMpty Local", "M");
			Code = "A";
		}
		break;    	            
	}
}

/**
 * TYPE 콤보 변경시 처리 
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function combo1_OnChange(comboObj,value,text) {
	var form = document.form;
	form.in_type.value = value;
}

/**
 * 키 누를때 선택되게 하기
 * @param comboObj
 * @param key
 * @param shift
 * @return
 */
function combo1_OnKeyDown(comboObj, key, shift) {
	
	if (key==65) comboObj.Code = "A"; //아스키 코드
	if (key==66) comboObj.Code = "B";
	if (key==67) comboObj.Code = "C";
	if (key==68) comboObj.Code = "D";
	if (key==77) comboObj.Code = "M";
	
}

//페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
function setComboObject(combo_obj){
	comboObjects[comboCnt++] = combo_obj;	
}

/**
 * 그리드의 비지니스 에러 판단 (컬러 변경 처리)
 * @return
 */
function changeErrorColor(sheetObj)
{

	for(var i=2; i < sheetObj.RowCount +2; i++) {
		// BL_NO 색 변경
		if (sheetObj.CellValue(i, "error_check")=="E") sheetObj.CellFontColor(i, "bl_no") = sheetObj.RgbColor(255, 0, 0);
		// 에러 컬럼 체크 
		if (sheetObj.CellValue(i, "wh")=="N") sheetObj.CellFontColor(i, "wh") = sheetObj.RgbColor(255, 0, 0);
		if (sheetObj.CellValue(i, "cgo_desc1")=="N") sheetObj.CellFontColor(i, "cgo_desc1") = sheetObj.RgbColor(255, 0, 0);
		if (sheetObj.CellValue(i, "s_nm")=="N") sheetObj.CellFontColor(i, "s_nm") = sheetObj.RgbColor(255, 0, 0);
		if (sheetObj.CellValue(i, "s_addr")=="N") sheetObj.CellFontColor(i, "s_addr") = sheetObj.RgbColor(255, 0, 0);
		if (sheetObj.CellValue(i, "c_nm")=="N") sheetObj.CellFontColor(i, "c_nm") = sheetObj.RgbColor(255, 0, 0);
		if (sheetObj.CellValue(i, "n_nm")=="N") sheetObj.CellFontColor(i, "n_nm") = sheetObj.RgbColor(255, 0, 0);
		if (sheetObj.CellValue(i, "cmdt_cd")=="N") sheetObj.CellFontColor(i, "cmdt_cd") = sheetObj.RgbColor(255, 0, 0);
		if (sheetObj.CellValue(i, "biz_rgst_no")=="N") sheetObj.CellFontColor(i, "biz_rgst_no") = sheetObj.RgbColor(255, 0, 0);
		if (sheetObj.CellValue(i, "cntr_cnt")=="0") sheetObj.CellFontColor(i, "cntr_cnt") = sheetObj.RgbColor(255, 0, 0);
		if (sheetObj.CellValue(i, "pck_qty")=="0") sheetObj.CellFontColor(i, "pck_qty") = sheetObj.RgbColor(255, 0, 0);
		if (sheetObj.CellValue(i, "cntr_ttl_wgt")=="0") sheetObj.CellFontColor(i, "cntr_ttl_wgt") = sheetObj.RgbColor(255, 0, 0);
		if (sheetObj.CellValue(i, "elno_b")=="U") sheetObj.CellFontColor(i, "elno_b") = sheetObj.RgbColor(255, 0, 0);
		// IN BOUND
		if (document.form.io_bnd_cd[0].checked) {
			if (sheetObj.CellValue(i, "bd_area_cd")=="N") sheetObj.CellFontColor(i, "bd_area_cd") = sheetObj.RgbColor(255, 0, 0);
			if (sheetObj.CellValue(i, "c_addr")=="N") sheetObj.CellFontColor(i, "c_addr") = sheetObj.RgbColor(255, 0, 0);
			if (sheetObj.CellValue(i, "n_addr")=="N") sheetObj.CellFontColor(i, "n_addr") = sheetObj.RgbColor(255, 0, 0);
		}
	}
}

/**
 * 그리드 숨김 해제
 * @param sheetObj
 * @return
 */
function showAllRows(sheetObj) {
	for(var i=2; i < sheetObj.RowCount +2; i++) {
		sheetObj.RowHidden(i) = false;
	}
}

/**
 * 그리드에서 에러 행만 보여줌
 * @param sheetObj
 * @return
 */
function showOnlyErrRows(sheetObj) {
	for(var i=2; i < sheetObj.RowCount +2; i++) {
		if (sheetObj.CellValue(i, "error_check")!="E")
			sheetObj.RowHidden(i) = true;
	}	
}
 
/**
 * 통계 정보 UPDATE
 * @return
 */
function updateSummary()
{
	ComOpenWait(true);
	
	var sheetObj = sheetObjects[0];
	var formObj  = document.form;
	
	var bl_local=0, bl_ts =0, bl_empty =0;
	var cntr_local=0, cntr_ts=0, cntr_empty=0;
	var cntrRow, prev_cntr_no="";
	
	sheetObjects[2].ColumnSort("cntr_no", "ASC");
	
	// 루프돌며 계산
	for(var i=2; i < sheetObj.RowCount+2; i++) {
		
		// HIDDEN 은 패스~
		if (sheetObj.RowHidden(i)) continue;
		
		// EMPTY CHECK
		if (sheetObj.CellValue(i, "bkg_cgo_tp_cd")=="P" || sheetObj.CellValue(i, "bkg_cgo_tp_cd")=="E" || sheetObj.CellValue(i, "bkg_cgo_tp_cd")=="R" ) {
			bl_empty++;
			
			
			cntrRow = sheetObjects[2].FindText("bkg_no", sheetObj.CellValue(i, "bkg_no"));
			while(cntrRow > 0 ) {
				sheetObjects[2].CellValue(cntrRow, "bkg_cgo_tp_cd") = "E";
				cntrRow = sheetObjects[2].FindText("bkg_no", sheetObj.CellValue(i, "bkg_no"), cntrRow+1);
			}
		}else {
			// EMPTY 가 아닌 경우 LOCAL / TS 구분
			// LOCAL 의 경우
			if (sheetObj.CellValue(i, "cstms_decl_tp_cd")=="I" || sheetObj.CellValue(i, "cstms_decl_tp_cd")=="E" ) {
				bl_local++;
				
				
				cntrRow = sheetObjects[2].FindText("bkg_no", sheetObj.CellValue(i, "bkg_no"));
				while(cntrRow > 0 ) {
					sheetObjects[2].CellValue(cntrRow, "bkg_cgo_tp_cd") = "L";
					cntrRow = sheetObjects[2].FindText("bkg_no", sheetObj.CellValue(i, "bkg_no"), cntrRow+1);
				}
			}else {
			// TS 의 경우
				bl_ts++;
				
				cntrRow = sheetObjects[2].FindText("bkg_no", sheetObj.CellValue(i, "bkg_no"));
				while(cntrRow > 0 ) {
					sheetObjects[2].CellValue(cntrRow, "bkg_cgo_tp_cd") = "T";
					cntrRow = sheetObjects[2].FindText("bkg_no", sheetObj.CellValue(i, "bkg_no"), cntrRow+1);
				}
			}
			
		}
				
	}
	
	// 컨테이너 갯수 계산
	for(var i=1; i <= sheetObjects[2].RowCount; i++ ) {
		
		// BKG_NO 가 메인에서 Hidden 이면 카운트 하지 않음
		cntrRow = sheetObjects[0].FindText("bkg_no", sheetObjects[2].CellValue(i, "bkg_no"));
		if (cntrRow > 0 && sheetObjects[0].RowHidden(cntrRow)) continue;
		
		// COUNT
		if (prev_cntr_no != sheetObjects[2].CellValue(i, "cntr_no")) {
			if (sheetObjects[2].CellValue(i, "bkg_cgo_tp_cd")=="E") cntr_empty++;
			if (sheetObjects[2].CellValue(i, "bkg_cgo_tp_cd")=="L") cntr_local++;
			if (sheetObjects[2].CellValue(i, "bkg_cgo_tp_cd")=="T") cntr_ts++;
		}
		prev_cntr_no = sheetObjects[2].CellValue(i, "cntr_no");
	}
	
	
	// 계산결과 뿌려주기
	formObj.bl_local.value = bl_local;
	formObj.bl_ts.value = bl_ts;
	formObj.bl_empty.value = bl_empty;
	formObj.cntr_local.value = cntr_local;
	formObj.cntr_ts.value = cntr_ts;
	formObj.cntr_empty.value = cntr_empty;
	formObj.bl_total.value = bl_local + bl_ts + bl_empty;
	formObj.cntr_total.value = cntr_local + cntr_ts + cntr_empty;
	
	ComOpenWait(false);
	comboObjects[0].Enable = formObj.io_bnd_cd[1].checked;
}
 /**
 * 조회조건 입력할 때 처리
 */
 function obj_KeyUp() {
 	 var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
 	 var formObject = document.form;
 	var srcName = window.event.srcElement.getAttribute("name");
 	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
 	var srcValue = window.event.srcElement.getAttribute("value");
 	if (keyValue != 9 && keyValue !=16 &&ComChkLen(srcValue, srcMaxLength) == "2") {
 		ComSetNextFocus();
 	}
 }