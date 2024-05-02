/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0505.js
 *@FileTitle : B/L Inquiry(Add & Edit B/L) Customer Info
 *Open Issues : 
 *Change history :
 *@LastModifyDate : 2009.07.01
 *@LastModifier : 박상훈
 *@LastVersion : 1.0
 * 2009.07.01 박상훈
 * 1.0 Creation
 * 2012.02.23 채창호 [CHM-201216259-01]]:광양항, 경인항+인천항 MANIFEST 정보 변경사항 반영
 * 2012.03.05 민정호 [CHM-201216429] 기본 세관 CODE 지정 요청 (port : KRINC , KRGIN)
=========================================================*/

/**
 * JSDOC 생성을 위한 함수 정의 
 */
function esm_bkg_0505()
{
	this.processButtonClick				= processButtonClick;
	this.setSheetObject					= setSheetObject;
	this.setComboObject					= setComboObject;
	this.loadPage						= loadPage;
	this.t1sheet1_OnLoadFinish			= t1sheet1_OnLoadFinish;
	this.initSheet						= initSheet;
	this.doActionIBSheet				= doActionIBSheet;
	this.changeTextToNumberFormat		= changeTextToNumberFormat;
	this.changeNumberToTextFormat		= changeNumberToTextFormat;
	this.setTabObject					= setTabObject;
	this.initTab						= initTab;
	this.tab1_OnChange					= tab1_OnChange;
	this.initCombo						= initCombo;
	this.cboTrans_OnChange				= cboTrans_OnChange;
	this.cboCargoType_OnChange			= cboCargoType_OnChange;
	this.cboCargoSpec_OnChange			= cboCargoSpec_OnChange;
	this.cboGoods_OnChange				= cboGoods_OnChange;
	this.cboBizNo_OnChange				= cboBizNo_OnChange;
	this.cboPackage_OnChange			= cboPackage_OnChange;
	this.cboWarehouse_OnChange			= cboWarehouse_OnChange;
	this.validateForm					= validateForm;
	this.ComXml2ComboString2			= ComXml2ComboString2;
	this.resetForm						= resetForm;
	this.t1sheet1_OnChange				= t1sheet1_OnChange;
	this.ComAddComma3					= ComAddComma3;
}

/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

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

	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	var sheetObject3 = sheetObjects[2];
	var sheetObject4 = sheetObjects[3];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

		case "btn_Retrieve":
			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			break;

		case "btn_New":
			// 폼 초기화			
			resetForm(formObject);
			break;

		case "btn_Save":			
			doActionIBSheet(sheetObject2,document.form,IBSAVE);
			break;

		case "btn_BLBKGNoASSGN":
			doActionIBSheet(sheetObject1,document.form,COMMAND01);
			break;

		case "btn_t1RowAdd":
			
			var rowCnt = document.form.row_cnt.value;	
			
			for (var i = 1 ; i<= rowCnt ; i++){
				
				sheetObject1.DataInsert(-1);
				
				var prefix="kc_";
				sheetObject1.CellValue2(sheetObject1.SelectRow, prefix+"pck_tp_cd") = "";
				sheetObject1.CellValue2(sheetObject1.SelectRow, prefix+"cntr_wgt") = "0";
				sheetObject1.CellValue2(sheetObject1.SelectRow, prefix+"pck_qty") = "0";
				sheetObject1.CellValue2(sheetObject1.SelectRow, prefix+"meas_qty") = "0";
				sheetObject1.CellValue2(sheetObject1.SelectRow, prefix+"cntr_tpsz_cd") = "";
				sheetObject1.CellValue2(sheetObject1.SelectRow, prefix+"full_mty_cd") = "";
				sheetObject1.CellValue2(sheetObject1.SelectRow, prefix+"full_mty_cd") = "";	
				if( formObject.bkg_cgo_tp_cd.value == "P"){
					sheetObject1.CellValue2(sheetObject1.SelectRow, prefix+"full_mty_cd")		= "E";
				}else{
					sheetObject1.CellValue2(sheetObject1.SelectRow, prefix+"full_mty_cd")		= "F";
				}
			}			
			break;

		case "btn_t1Delete":
			doActionIBSheet(sheetObject1,document.form,IBDELETE);
			break;

		case "btn_t1LoadExcel":			
			sheetObject1.Redraw = false;
			var columns = "4=>kc_cntr_no|5=>kc_full_mty_cd|6=>kc_cntr_seal_no1|7=>kc_cntr_seal_no2|8=>kc_cntr_tpsz_cd|9=>kc_pck_qty|10=>kc_pck_tp_cd|11=>kc_cntr_wgt|12=>kc_wgt_ut_cd|13=>kc_meas_qty|14=>kc_meas_ut_cd|15=>kc_chk_empty";
			var oldCnt = sheetObject1.RowCount;
			var cnt = 0;
			sheetObject1.LoadExcel(1, 1, "", -1, -1, "", true, false, columns );
			ComOpenWait(true);
			for(var i=oldCnt+1; i <= sheetObject1.RowCount; i++) {
				// 엑셀에서 로드한 데이터 중 12번 컬럼이 P 이거나 E인 경우 MTY_CD 를 E로 설정
				if (sheetObject1.CellValue(i, "kc_chk_empty")=="P" || sheetObject1.CellValue(i, "kc_chk_empty")=="E" ) {
					sheetObject1.CellValue(i, "kc_full_mty_cd") = "E";
				}
				// CNTR_NO 체크하여 첫번째 문자가 97보다 크거나 같고 122보다 작거나 같으면 삭제처리
				if (sheetObject1.CellValue(i, "kc_cntr_no").length > 0 ) {
					var charCode = sheetObject1.CellValue(i, "kc_cntr_no").charCodeAt(0);
					if (97 <= charCode && charCode <= 122 ) sheetObject1.RowDelete(i, false);
				}				
			}
			// 중복 컨테이너 제거
			for(var i=1; i <= sheetObject1.RowCount; i++) {
				for(var j=1; j <= sheetObject1.RowCount;j++) {
					if (i==j) continue;
					
					if (sheetObject1.CellValue(i,"kc_cntr_no")==sheetObject1.CellValue(j, "kc_cntr_no")) {
						sheetObject1.RowDelete(j, false);
					}
				}
			}
			ComOpenWait(false);
			sheetObject1.Redraw = true;
			cnt = sheetObject1.RowCount - oldCnt;
			ComShowCodeMessage("BKG95021", cnt);
			break;

		case "btn_t3RowAdd":
			sheetObject3.DataInsert(-1);
			sheetObject3.CellValue2(sheetObject3.SelectRow, "ke_pck_tp_cd")		 	= "";
			sheetObject3.CellValue2(sheetObject3.SelectRow, "ke_divd_pck_ut_cd") 	= "";
			sheetObject3.CellValue2(sheetObject3.SelectRow, "ke_wgt_ut_cd") 		= "";
			sheetObject3.CellValue2(sheetObject3.SelectRow, "ke_prt_lodg_flg") 		= "";
			sheetObject3.CellValue2(sheetObject3.SelectRow, "ke_kr_xpt_pck_id") 	= "";
				
			break;			
		case "btn_t3Delete":
			doActionIBSheet(sheetObject3,document.form,IBDELETE);
			break;

		case "btn_t3LoadExcel":
			sheetObject3.LoadExcel();
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
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){

	sheetObjects[sheetCnt++] = sheet_obj;

}

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 * @param combo_obj
 * @return
 */
function setComboObject(combo_obj){

	comboObjects[comboCnt++] = combo_obj;

}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

	var formObj = document.form;
	
	for(i=0;i<sheetObjects.length;i++){

		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet (sheetObjects[i] );

		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	for(k=0;k<tabObjects.length;k++){
		initTab(tabObjects[k],k+1);
	}
	
	for(k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],k+1);
	}
	// 키 입력 처리
	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObj);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form); //- 포커스 나갈때
}

/**
 * T1Sheet1 로드 완료 후 처리
 * @param sheetObj
 * @return
 */
function t1sheet1_OnLoadFinish(sheetObj) {
	var form = document.form;
		
	// MODE 에 따른 버튼 활성, 비활성 처리
	if (form.mode.value=='ADD') {
		ComBtnEnable('btn_BLBKGNoASSGN');
		ComBtnDisable('btn_Retrieve');
		// Trans 값 빈칸 처리
		comboObjects[0].Code="";
	}else {		
		ComBtnDisable('btn_BLBKGNoASSGN');
		ComBtnEnable('btn_Retrieve');		
		form.bl_no.className="input2";
		form.bl_no.readOnly = true;
	}
	
	// 코드성 데이터 조회 후 Combo 매핑 처리
	doActionIBSheet(sheetObjects[0], form, COMMAND09);
	
	// EDIT 모드라면 자동 조회
	if (form.mode.value=='EDIT') {
		doActionIBSheet(sheetObjects[0], form, IBSEARCH);
	}
	
	// TRANS TP 
	form.old_cstms_decl_tp_cd.value = form.cstms_decl_tp_cd.value; 
	//[CHM-201216259-01]:광양항, 경인항+인천항 MANIFEST 정보 변경사항 반영
	//값을 강제로 셋팅을 한다.
	getTaxCode();
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {

	var cnt = 0;
	var sheetid = sheetObj.id;
	switch(sheetid) {

	case "t1sheet1":
		with (sheetObj) {
			// 높이 설정
			style.height = 180;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = "|Sel|Seq.|Container No.|Load/Empty|Seal No1.|Seal No2.|Type|Package|Package|Weight|Weight|Measure|Measure|";
			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
//			InitHeadMode(true, true, false, true, false,false);
			InitHeadMode(true, true, true, true, false, false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			var prefix="kc_";
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,			0,		daCenter,	true,		prefix+"ibflag");
//			InitDataProperty(0, cnt++ , dtDummyCheck,			30,		daCenter,	true,		"Sel");
			InitDataProperty(0, cnt++ , dtCheckBox,				40,		daCenter,	true,		"Sel");
			InitDataProperty(0, cnt++ , dtDataSeq,				50,		daCenter,	true,		prefix+"Seq");
			InitDataProperty(0, cnt++ , dtData,					110,	daCenter,	true,		prefix+"cntr_no",			false,		"",	dfEngUpKey,		0,		true,		true);
			InitDataProperty(0, cnt++ , dtCombo,				90,		daCenter,	true,		prefix+"full_mty_cd",		false,		"",	dfNone,		0,		true,		true);
			InitDataProperty(0, cnt++ , dtData,					100,	daCenter,	true,		prefix+"cntr_seal_no1",		false,		"",	dfNone,		0,		true,		true);
			InitDataProperty(0, cnt++ , dtData,					100,	daCenter,	true,		prefix+"cntr_seal_no2",		false,		"",	dfNone,		0,		true,		true);
			InitDataProperty(0, cnt++ , dtCombo,				60,		daCenter,	true,		prefix+"cntr_tpsz_cd",		false,		"",	dfNone,		0,		true,		true);
			InitDataProperty(0, cnt++ , dtData,					90,		daRight,	true,		prefix+"pck_qty",			false,		"",	dfInteger,	0,		true,		true);
			InitDataProperty(0, cnt++ , dtCombo,				50,		daCenter,	true,		prefix+"pck_tp_cd",			false,		"",	dfNone,		0,		true,		true);
			InitDataProperty(0, cnt++ , dtData,					90,		daRight,	true,		prefix+"cntr_wgt",			false,		"",	dfFloat,	2,		true,		true);
			InitDataProperty(0, cnt++ , dtCombo,				50,		daCenter,	true,		prefix+"wgt_ut_cd",			false,		"",	dfNone,		0,		true,		true);
			InitDataProperty(0, cnt++ , dtData,					90,		daRight,	true,		prefix+"meas_qty",			false,		"",	dfFloat,	3,		true,		true);
			InitDataProperty(0, cnt++ , dtCombo,				50,		daCenter,	true,		prefix+"meas_ut_cd",		false,		"",	dfNone,		0,		true,		true);
			InitDataProperty(0, cnt++ , dtHidden,				0,		daCenter,	true,		prefix+"chk_empty",			false,		"",	dfNone,		0,		true,		true);

			InitDataCombo(0, prefix+"full_mty_cd", 	"F\tLoad|E\tEmpty", "F|E");
			InitDataCombo(0, prefix+"cntr_tpsz_cd", 	"D2|D4|D5|D7|R5", 	"D2|D4|D5|D7|R5");
			InitDataCombo(0, prefix+"pck_tp_cd", 		"AE\tAEROSOL", 	  	"AE");
			InitDataCombo(0, prefix+"wgt_ut_cd",  		"KGS|LBS", 			"KGS|LBS");
			InitDataCombo(0, prefix+"meas_ut_cd", 		"CBM|CBF", 			"CBM|CBF");

			ShowButtonImage = 2;
			DataRowMerge(0) = true;

		}
		break;
		
	case "t2sheet1":
		with (sheetObj) {
			// 높이 설정
			style.height = 0;
			//전체 너비 설정
			SheetWidth = 0;
			
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
			
			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;
			
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);
			
			var HeadTitle1 = "|Sel|Seq.|Data";
			var headCount = ComCountHeadTitle(HeadTitle1);
			
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
			
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false);
			
			
			
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"hd_ibflag");
			InitDataProperty(0, cnt++ , dtCheckBox,		30,		daCenter,	true,		"hd_Sel");
			InitDataProperty(0, cnt++ , dtSeq,			50,		daCenter,	true,		"hd_Seq");
			InitDataProperty(0, cnt++ , dtData,			200,	daCenter,	true,		"hd_data",	false,		"",	dfNone,		0,		true,		true);
			
			DataRowMerge(0) = true;
		}
		break;

	case "t3sheet1":
		with (sheetObj) {
			// 높이 설정
			style.height = 180;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = "|Sel|Seq.|Export License No.|Package|Package|Weight|Weight|Divide|Ship|동시포장|동시포장 Package|동시포장 Package";
			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,			40,		daCenter,	true,		"ibflag");
			InitDataProperty(0, cnt++ , dtDummyCheck,			30,		daCenter,	true,		"Sel");
			InitDataProperty(0, cnt++ , dtDataSeq,				30,		daCenter,	true,		"ke_Seq");
			InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	true,		"ke_xpt_lic_no",	false,		"",	dfNone,		0);
			InitDataProperty(0, cnt++ , dtData,					80,		daRight,	true,		"ke_pck_qty",		false,		"",	dfInteger,	0);
			InitDataProperty(0, cnt++ , dtCombo,				40,		daCenter,	true,		"ke_pck_tp_cd",		false,		"",	dfNone,		0);
			InitDataProperty(0, cnt++ , dtData,					80,		daRight,	true,		"ke_cntr_wgt",		false,		"",	dfFloat,	3);
			InitDataProperty(0, cnt++ , dtCombo,				80,		daCenter,	true,		"ke_wgt_ut_cd",		false,		"",	dfNone,		0);
			InitDataProperty(0, cnt++ , dtCombo,				110,	daCenter,	true,		"ke_prt_lodg_flg",	false,		"",	dfNone,		0);
			InitDataProperty(0, cnt++ , dtData,					110,	daCenter,	true,		"ke_prt_lodg_seq",	false,		"",	dfNone,		0);
			InitDataProperty(0, cnt++ , dtCombo,				110,	daCenter,	true,		"ke_kr_xpt_pck_id",	false,		"",	dfNone,		0);
			InitDataProperty(0, cnt++ , dtData,					80,		daRight,	true,		"ke_divd_pck_qty",	false,		"",	dfInteger,	0);
			InitDataProperty(0, cnt++ , dtCombo,				80,		daCenter,	true,		"ke_divd_pck_ut_cd",false,		"",	dfNone,		0);

			InitDataCombo(0, "ke_pck_tp_cd", 	 "AE|AR|PK|BG| ", 	   "AE|AR|PK|BG|");
			InitDataCombo(0, "ke_wgt_ut_cd", 	 "KGS|LBS| ", 		   "KGS|LBS|");
			InitDataCombo(0, "ke_prt_lodg_flg",  "Y|N| ", 			   "Y|N|");
			InitDataCombo(0, "ke_kr_xpt_pck_id", "A|B|C|D|E|F|G|H|I|J|K|L|M|N|O|P|Q|R|S|T|U|V|W|X|Y|Z| ",  "A|B|C|D|E|F|G|H|I|J|K|L|M|N|O|P|Q|R|S|T|U|V|W|X|Y|Z|");
			InitDataCombo(0, "ke_divd_pck_ut_cd", "AE|AR|AT|BA|BB|BC| ", "AE|AR|AT|BA|BB|BC|");

			DataRowMerge(0) = true;
		}
		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	var formObj1 = document.form;
	switch(sAction) {

	case IBSEARCH:      // 조회
	    formObj.f_cmd.value = SEARCH;
		if(validateForm(sheetObj,formObj,sAction)) {
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			sheetObj.RemoveAll();
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0505GS.do", FormQueryString(formObj) );
			var arrXml = sXml.split("|$$|");
			
			// GRID UPDATE
			sheetObjects[0].Redraw = false;    
			if(i > 0) sheetObjects[0].WaitImageVisible = false;	
			sheetObjects[0].LoadSearchXml(arrXml[0]); 
			sheetObjects[0].Redraw = true;
			
			sheetObjects[2].Redraw = false;    
			if(i > 0) sheetObjects[2].WaitImageVisible = false;	
			sheetObjects[2].LoadSearchXml(arrXml[1]); 
			sheetObjects[2].Redraw = true;
			
			// ETC DATA를 이용하여 CUSTOMER INFO 탭 구성
			// mode 복구
			var mode = formObj.mode.value;
			ComEtcDataToForm(formObj ,sheetObj);
			formObj.mode.value = mode;
			formObj.vvd.value = formObj.vvd_1.value;
			
			
			// CARGO TYPE 셋팅
			comboObjects[1].Code2 = formObj.bkg_cgo_tp_cd.value; 
			// CARGO SPEC 셋팅
			if (sheetObjects[0].EtcData("cargo_spec")=="1") {
				comboObjects[2].Code = "1";
			}else if (sheetObjects[0].EtcData("cargo_spec")=="2") {
				comboObjects[2].Code = "2";
			}else {
				comboObjects[2].Code = "";
			}
			if (formObj.cgo_spec_clear.value=="Y") comboObjects[2].Code="";
			// PACKAGE 셋팅
			comboObjects[3].Code2 = formObj.pck_tp_cd.value;
			// WAREHOUSE 셋팅
			comboObjects[4].Code2 = formObj.kr_cstms_wh_tp_cd.value;
			// 품목 코드 셋팅
			comboObjects[5].Code2 = formObj.cmdt_cd.value;
			// 검색결과의 Trans 코드 저장 
			formObj.old_cstms_decl_tp_cd.value = formObj.cstms_decl_tp_cd.value;
			// BizNo 셋팅
			// 값이 있는지 체크해서 있으면 지정하고 없으면 ADD
			var bizNo = ComGetMaskedValue(formObj.biz_rgst_no.value,  "saupja");
			var itemIndex = comboObjects[6].FindIndex(bizNo,0);
			if (itemIndex==-1) {
				comboObjects[6].InsertItem(-1, bizNo+"|", formObj.biz_rgst_no.value);
				comboObjects[6].Code2 = formObj.biz_rgst_no.value;
			}else {
				comboObjects[6].Index2 = itemIndex;
			}
			// 폼 데이터 중 숫자형태 처리
			changeTextToNumberFormat(formObj);
			formObj.tax_code1.value = ComLpad(formObj.tax_code1.value, 3, "0");
			formObj.tax_code2.value = ComLpad(formObj.tax_code2.value, 2, "0");
			
			getTaxCode();  // 세관 Code 세팅
			
			ComOpenWait(false);
		}
		break;

	case IBSAVE:	// 추가/수정/삭제
		if(ComShowCodeConfirm('BKG95003', 'save')){   // Do you want to ...?
			if(validateForm(sheetObj,formObj,sAction)) {
				sheetObjects[1].WaitImageVisible =false;
				ComOpenWait(true);
				sheetObjects[1].RemoveAll();
				sheetObjects[1].DataInsert(-1);
				sheetObjects[1].RowStatus(1) = "U";
				formObj.f_cmd.value = MULTI;
				changeNumberToTextFormat(formObj);
				ComBtnDisable("btn_Save");
				var params = ComGetSaveString(sheetObjects, true, true)+"&"+FormQueryString(formObj);
				sheetObjects[1].DoSave("ESM_BKG_0505GS.do", params, -1, false);
				// EDIT의 경우 처리하고 나면 한번 더 조회한다
				if (formObj.mode.value=='EDIT') {					
					doActionIBSheet(sheetObj, formObj, IBSEARCH);					
				}				
				tabObjects[0].SelectedIndex = 0;
				ComBtnEnable("btn_Save");
				ComOpenWait(false);
			}
		}
		break;

	case COMMAND01:      // Bkg, Bl NO Assign
		sheetObj.WaitImageVisible =false;
		ComOpenWait(true);
		formObj.f_cmd.value= COMMAND01;
		var sXml = sheetObj.getSearchXml("ESM_BKG_0505GS.do", FormQueryString(formObj), -1, false);
		sheetObjects[1].LoadSearchXml(sXml);
		var blNo  = sheetObjects[1].EtcData('bl_no');
		var bkgNo = sheetObjects[1].EtcData('bkg_no');
		formObj.bl_no.value  = blNo;
		formObj.bkg_no.value = bkgNo;
		ComOpenWait(false);
		break;
	
	case IBDELETE:		// ROW DELETE
		ComRowHideDelete(sheetObj,"Sel");
		break;
	
	case COMMAND09: 	// 코드 데이터 조회
		// 패키지 정보 조회 후 콤보들에 적용
		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);
		formObj.f_cmd.value= COMMAND09;
		var sXml = sheetObj.GetSearchXML("ESM_BKG_0505GS.do", FormQueryString(formObj));
		var arrXml = sXml.split("|$$|");		
		ComXml2ComboItem(arrXml[0], comboObjects[3],  "pck_cd",			"pck_cd|pck_nm");
		var comboXML  = ComXml2ComboString2(arrXml[0], "pck_cd", 		"pck_nm");
		var comboXML2 = ComXml2ComboString (arrXml[2], "cntr_tpsz_cd", 	"cntr_tpsz_cd");
		var prefix1="kc_";
		sheetObjects[0].InitDataCombo(0, prefix1+"pck_tp_cd", 			comboXML[0]+"| ",  comboXML[1]+"|");		
		sheetObjects[2].InitDataCombo(0, "ke_pck_tp_cd", 		comboXML[0]+"| ",  comboXML[1]+"|");
		sheetObjects[2].InitDataCombo(0, "ke_divd_pck_ut_cd",	comboXML[0]+"| ",  comboXML[1]+"|");
		ComXml2ComboItem(arrXml[1], comboObjects[5], "cmdt_cd", "rep_cmdt_cd|cmdt_cd");
		sheetObjects[0].InitDataCombo(0, prefix1+"cntr_tpsz_cd", 		comboXML2[0], comboXML2[1]);
		ComOpenWait(false);
		break;
	}
	
}

/**
 * 숫자형태 콤마 등 추가
 * @param formObj
 * @return
 */
function changeTextToNumberFormat(formObj) {
	formObj.pck_qty.value 			= ComGetMaskedValue(formObj.pck_qty.value, 			"int");
	formObj.cntr_ttl_wgt.value  	= ComAddComma2(formObj.cntr_ttl_wgt.value, 	"#,###.0");
	formObj.meas_qty.value  		= ComAddComma3(formObj.meas_qty.value,		"#,###.000");
	formObj.bb_cgo_meas_qty.value  	= ComGetMaskedValue(formObj.bb_cgo_meas_qty.value, 	"float");
}

/**
 * 숫자형태 콤마 제거
 * @param formObj
 * @return
 */
function changeNumberToTextFormat(formObj) {
	formObj.pck_qty.value 			= ComGetUnMaskedValue(formObj.pck_qty.value, 		"int");
	formObj.cntr_ttl_wgt.value  	= ComGetUnMaskedValue(formObj.cntr_ttl_wgt.value, 	"float");
	formObj.meas_qty.value  		= ComGetUnMaskedValue(formObj.meas_qty.value, 		"float");
	formObj.meas_qty.value  		= ComGetUnMaskedValue(formObj.meas_qty.value, 		"float");
	formObj.bb_cgo_meas_qty.value  	= ComGetUnMaskedValue(formObj.bb_cgo_meas_qty.value,"float");
}

/**
 * IBTab Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setTabObject(tab_obj){
	tabObjects[tabCnt++] = tab_obj;

}

/**
 * Tab 기본 설정
 * 탭의 항목을 설정한다.
 */
function initTab(tabObj , tabNo) {
	switch(tabNo) {
	case 1:
		with (tabObj) {

			var cnt  = 0 ;
			InsertTab( cnt++ , "Container Info." , -1 );
			InsertTab( cnt++ , "Customer Info." , -1 );
			InsertTab( cnt++ , "Export License Info." , -1 );

		}
		break;

	}
}

/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnChange(tabObj , nItem)
{
	var objs = document.all.item("tabLayer");

	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";

	//--------------- 요기가 중요 --------------------------//
	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
	//------------------------------------------------------//
	beforetab= nItem;
}

/**
 * Combo Object 초기화
 * @param comboObj
 * @param comNo
 * @return
 */
function initCombo(comboObj, comboNo) {
	var formObj = document.form;

	switch(comboObj.id) {
	case "cboTrans":
		var i=0;
		with(comboObj) {			 
			ColBackColor(0) = "#CCFFFD";			 
			MultiSelect = false;
			MaxSelect = 0;
			// IN BOUND
			if (formObj.io_bnd_cd.value=='I') {
				comboObj.InsertItem( i++, "Import" , 	  "I");
				comboObj.InsertItem( i++, "T/S Import" , "T");
				if (formObj.cstms_decl_tp_cd.value.length > 0) 
					comboObj.Code2 = formObj.cstms_decl_tp_cd.value;
				else
					comboObj.Code = "I";
			} else {
				comboObj.InsertItem( i++, "Export" , 	  "E");
				comboObj.InsertItem( i++, "T/S Export" , "R");
				if (formObj.cstms_decl_tp_cd.value.length > 0) 
					comboObj.Code2 = formObj.cstms_decl_tp_cd.value;
				else
					comboObj.Code = "E";
			}
		}
		break;
	case "cboCargoType":
		var i=0;
		with(comboObj) {
			DropHeight = 300;
			MultiSelect = false;
			MaxSelect = 0;
			SetColAlign("center|left");
			SetColWidth("60|120");
			SetTitle("Type|Description");
			ShowCol = 1;
			comboObj.InsertItem( i++, "F|Full Cargo" ,      "F");
			comboObj.InsertItem( i++, "P|Empty Reposition", "P");
			comboObj.InsertItem( i++, "R|Revenue Empty" ,   "R");
			comboObj.InsertItem( i++, "B|Break Bulk" ,      "B");

		}
		break;
	case "cboCargoSpec":
		var i=0;
		with(comboObj) {
			DropHeight = 260;
			MultiSelect = false;
			MaxSelect = 0;
			comboObj.InsertItem( i++, "" ,     				 "");
			comboObj.InsertItem( i++, "1. 국내개항간 외항선 운송" ,     				 "1");
			comboObj.InsertItem( i++, "2. 수출화물로써 국내개항에 일시 양륙하는 화물" ,  "2");
		}
		break;
	case "cboPackage":
		var i=0;
		with(comboObj) {
			DropHeight = 300;
			MultiSelect = false;
			MaxSelect = 0;
			SetColAlign("center|left");
			SetColWidth("60|200");
			SetTitle("Code|Description");
			var arrayKind = [ 'AE', 'AR', 'PK', 'LT' ];
			var arrayBondedType = [ 'AEROSOL', 'ARTICLES', 'PACKAGE', 'LT???' ];
			for(i=0; i < arrayKind.length; i++) {
				comboObj.InsertItem( i, arrayKind[i]+"|"+arrayBondedType[i], arrayKind[i]);
			}
		}
		break;
	case "cboWarehouse":
		var i=0;
		with(comboObj) {
			DropHeight = 300;
			MultiSelect = false;
			MaxSelect = 0;
			SetColAlign("center|left");
			SetColWidth("60|200");
			SetTitle("Code|Description");
			var arrayKind = [ 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R' ,'S' ];
			var arrayBondedType = [ '입항전 사전 수입신고', '차상반출', '부두 직통관', '부두 보운', '해상 간이 운송',
			                        '부두 경유 간이 보운', '보세운송', '의왕ICD', 'CY경유 간이 보운', '내장 통관',
			                        'CFS 경유 간이 보운', 'CFS', '자가 보세장치장', 'T/S', '내품  T/S',
			                        '자선', '타소 장치', 'Empty 컨테이너','부두창고' ];
			for(i=0; i < arrayKind.length; i++) {
				comboObj.InsertItem( i, arrayKind[i]+"|"+arrayBondedType[i], arrayKind[i]);
			}
		}
		break;
	case "cboGoods":
		var i=0;
		with(comboObj) {
			DropHeight = 300;
			MultiSelect = false;
			MaxSelect = 0;
			ShowCol = 0;
			SetColAlign("center|left");
			SetColWidth("60|80");
			var arrayKind = [ '00', '99' ];
			var arrayBondedType = [ '630700', '530620' ];
			for(i=0; i < arrayKind.length; i++) {
				comboObj.InsertItem( i, arrayKind[i]+"|"+arrayBondedType[i], arrayKind[i]);
			}
		}
		break;
	case "cboBizNo":
		var i=0;
		with(comboObj) {
			DropHeight = 300;
			MultiSelect = false;
			MaxSelect = 0;			 
			SetColAlign("center|left");
			SetColWidth("100|130");
			var arrayKind 		 = [ '401-85-08615', '105-81-59519', '137-85-00522', '416-85-06244', '506-85-03346' ];
			var arrayKindVal 	 = [ '4018508615', '1058159519', '1378500522', '4168506244', '5068503346' ];
			var arrayBondedType = [ '대우자동차', '효성', '동부제강', '현대하이스코', '동국제강㈜ '];
			for(i=0; i < arrayKind.length; i++) {
				comboObj.InsertItem( i, arrayKind[i]+"|"+arrayBondedType[i], arrayKindVal[i]);
			}
		}
		break;
	}
} 

/**
 * Trans Type 콤보 이벤트 처리 
 * @param comboObj
 * @param value
 * @param text
 * @return
 */ 
function cboTrans_OnChange(comboObj, value, text)
{
	document.form.cstms_decl_tp_cd.value = value;
}

/**
 * Cargo Type 콤보 이벤트 처리
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function cboCargoType_OnChange(comboObj, value, text) {
	var formObj = document.form;
	formObj.bkg_cgo_tp_cd.value = value;
	var prefix="kc_";
	// Empty 일 경우 연계처리
	if (value=='P') {
		
		
		 
		comboObjects[3].Code = 'CN';
		formObj.kr_cstms_bl_tp_cd.value = 'E';
		formObj.cgo_desc1.value = 'EMPTY CONTAINERS';
		formObj.s_cust_nm.value = 'SM LINE CORPORATION';
//		formObj.s_cust_addr.value = 'SM LINE CORPORATION';
		formObj.c_cust_nm.value = 'SM LINE CORPORATION';
//		formObj.c_cust_addr.value = 'SM LINE CORPORATION';
		formObj.n_cust_nm.value = 'SM LINE CORPORATION';
//		formObj.n_cust_addr.value = 'SM LINE CORPORATION';
		
		
		for(var i = 1 ; i <= sheetObjects[0].RowCount; i++){
			sheetObjects[0].CellValue2(i, prefix+"full_mty_cd")		= "E";
		}
	}else{
		for(var i = 1 ; i <= sheetObjects[0].RowCount; i++){
			sheetObjects[0].CellValue2(i, prefix+"full_mty_cd")		= "F";			
		}
//		formObj.cgo_desc1.value = '';
//		formObj.s_cust_nm.value = '';
//		formObj.s_cust_addr.value = '';
//		formObj.c_cust_nm.value = '';
//		formObj.c_cust_addr.value = '';
//		formObj.n_cust_nm.value = '';
//		formObj.n_cust_addr.value = '';
	}
}

/**
 * Cargo Spec 콤보 이벤트 처리
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function cboCargoSpec_OnChange(comboObj, value, text) {
	document.form.cgo_trsp_cd.value = value;
}

/**
 * 품목 콤보 이벤트 처리
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function cboGoods_OnChange(comboObj, value, text) {
	document.form.cmdt_cd.value = value;
}

/**
 * BizNo 콤보 이벤트 처리
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function cboBizNo_OnChange(comboObj, value, text) {
	var biz = value;
	if (biz=='') biz = text;
	var bizNo  = ComGetUnMaskedValue(biz,  "saupja");
	var bizNo2 = ComGetMaskedValue  (biz,  "saupja");
	 
	// 사업자 번호 검사
	if (ComIsSaupjaNo(bizNo2)) {
		// 입력값이 없는 값이면 추가하기	
		var itemIndex = comboObj.FindIndex(bizNo2,0);
		if (itemIndex==-1) {
			comboObj.InsertItem(-1, bizNo2+"|", bizNo);
			comboObj.Code2 = bizNo;
		}else {
			comboObj.Index2 = itemIndex;
		}
		document.form.biz_rgst_no.value = comboObj.Code;
	}else {
		ComShowCodeMessage('BKG40001');
		comboObj.Text2 = '';
	}
}

/**
 * 패키지 콤보 이벤트 처리
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function cboPackage_OnChange(comboObj, value, text) {
	document.form.pck_tp_cd.value = value;
}

/**
 * Wharehouse 콤보 이벤트 처리
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function cboWarehouse_OnChange(comboObj, value, text) {
	document.form.kr_cstms_wh_tp_cd.value = value;	
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	switch (sAction) {
		case IBSEARCH:
			if (formObj.bl_no.value.length < 12) {
				ComShowCodeMessage('BKG00266');
				formObj.bl_no.focus();
				return false;
			}
 			break;
		case IBSAVE:
			if (formObj.bl_no.value.length < 12) {
				ComShowCodeMessage('BKG00266');
				formObj.bl_no.focus();
				return false;
			}
			if (formObj.cstms_decl_tp_cd.value.length < 1) {
				ComShowCodeMessage('BKG00856');
				formObj.cboTrans.focus();
				return false;
			}
 			break;
	}
	return true;
}

/**
 * Sheet Comobo 에 XML 적용시 코드와 값 컬럼 2개를 적용할 수 있도록 수정된 함수 
 * @param xmlStr
 * @param codeCol
 * @param textCol
 * @return
 */
function ComXml2ComboString2(xmlStr, codeCol, textCol) {
	var rtnArr = new Array();

	if (xmlStr == null || xmlStr == "") {
		return;
	}
	if (codeCol == null || codeCol == "" || textCol == null || textCol == "") {
		return;
	}

	try {
		var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
		xmlDoc.loadXML(xmlStr);

		var xmlRoot = xmlDoc.documentElement;
		if (xmlRoot == null) {
			return;
		}

		var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
		if (dataNode == null || dataNode.attributes.length < 3) {
			return;
		}

		var col = dataNode.getAttribute("COLORDER");
		var colArr = col.split("|");
		var sep = dataNode.getAttribute("COLSEPARATOR");
		var total = dataNode.getAttribute("TOTAL");

		var dataChildNodes = dataNode.childNodes;
		if (dataChildNodes == null) {
			return;
		}

		var colListIdx = Array();
		for ( var i = 0; i < colArr.length; i++) {
			if (colArr[i] == codeCol) {
				colListIdx[0] = i;
			}
			if (colArr[i] == textCol) {
				colListIdx[1] = i;
			}		
		}

		var sCode = "";
		var sText = "";
		for ( var i = 0; i < dataChildNodes.length; i++) {
			if (dataChildNodes[i].nodeType != 1) {
				continue;
			}
			var arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);

			sCode += arrData[colListIdx[0]];
			sText += arrData[colListIdx[0]]+"\t"+arrData[colListIdx[1]];

			if (i != dataChildNodes.length - 1) {
				sCode += "|";
				sText += "|";
			}
		}
		rtnArr.push(sText);
		rtnArr.push(sCode);

	} catch (err) {
		ComFuncErrMsg(err.message);
	}

	return rtnArr;
}

/**
 * 폼 초기화
 * @param formObj
 * @return
 */  
function resetForm(formObj) {

	// 콤보 초기화
	comboObjects[1].Code = '';
	comboObjects[2].Code = '';
	comboObjects[3].Code = '';
	comboObjects[4].Code = '';
	comboObjects[5].Code = '';
	comboObjects[6].Code2 = '';	
	// Sheet 초기화
	sheetObjects[0].RemoveAll();
	sheetObjects[2].RemoveAll();
	tabObjects[0].SelectedIndex = 0;
	// INPUT 값 초기화
	with(formObj) {		
		reset();
		bl_no.className="input1";
		bl_no.readOnly = false;
		bl_no.focus();		
	}
}

/**
 * Container NO 수정시 TYPE 조회
 * @param sheetOb
 * @param Row
 * @param Col
 * @param Val
 * @return
 */
function t1sheet1_OnChange(sheetObj, Row, Col, Val)
{
	var formObj = document.form;
	
	// CargoType 이 Break Bulk 이고 입력값이 IN BULK 의 경우 조회하지 않음
	if (Col==3 && Val == "IN BULK" && comboObjects[1].Code=="B") {
		// SKIP
	} else if (Col==3) {
		// 데이터 조회
		formObj.f_cmd.value = COMMAND02;
		var sXml = sheetObj.GetSearchXml("ESM_BKG_0505GS.do?cntr_no="+Val+"&f_cmd="+formObj.f_cmd.value);
		if (ComGetEtcData(sXml, "tpsz_cd")!=null && ComGetEtcData(sXml, "tpsz_cd").length > 1) {
			sheetObj.CellValue(Row, "kc_cntr_tpsz_cd") = ComGetEtcData(sXml, "tpsz_cd");
		}else {
			ComShowCodeMessage('BKG01028');
		}
	}
}

/**
 * 숫자 형태 콤마 추가 함수 
 * @param obj
 * @param sFormat
 * @return
 */
function ComAddComma3(obj,sFormat)
{
	try {
		//첫번째 인자가 문자열 또는 HTML태그(Object)인 경우 처리
		var sVal = getArgValue(obj);

		switch(sFormat)
		{
		case "#,###" :
			return ComAddComma(sVal);
		case "#,###.0" :
			p = sVal.split(".");
			p[0] = ComAddComma(p[0]);
			if      (p.length == 1) return p[0]+".0";
			else if (p.length == 2) return p[0]+"."+p[1];
			else return "";
		case "#,###.00" :
			p = sVal.split(".");
			p[0] = ComAddComma(p[0]);
			if      (p.length == 1) return p[0]+".00";
			else if (p.length == 2) return p[0]+"."+p[1];
			else return "";
		case "#,###.000" :
			p = sVal.split(".");
			p[0] = ComAddComma(p[0]);
			if      (p.length == 1) return p[0]+".000";
			else if (p.length == 2) return p[0]+"."+p[1];
			else return "";
		}
	} catch(err) { ComFuncErrMsg(err.message); }
}
 
 

 
 
 /**
  * 세관 Code 강제로 세팅
  * @return
  */ 
function getTaxCode(){  
 	var form = document.form;
 	
	//[CHM-201216259-01]:광양항, 경인항+인천항 MANIFEST 정보 변경사항 반영
	//값을 강제로 셋팅을 한다.
	if(form.pod_cd.value == "KRGIN" || form.pod_cd.value == "KRINC" ){
		form.tax_code1.value ="020";
		form.tax_code2.value = "10";
	}else if (form.pol_cd.value  == "KRGIN" || form.pod_cd.value == "KRINC"){
		form.tax_code1.value ="020";
		form.tax_code2.value = "10";
	}else if (form.por_cd.value  == "KRGIN" || form.por_cd.value == "KRINC"){
		form.tax_code1.value ="020";
		form.tax_code2.value = "10";
	}else if (form.del_cd.value  == "KRGIN" || form.del_cd.value == "KRINC"){
		form.tax_code1.value ="020";
		form.tax_code2.value = "10";
	}
	//[CHM-201219636-01 ]세관 코드 오류 및 AN송부시 VESSEL명 오류에 대한 정정 요청 POD가 평택이면 016/10
	if(form.pod_cd.value == "KRPTK"){
		form.tax_code1.value ="016";
		form.tax_code2.value = "10";
	}
}	


function obj_deactivate() {
	var formObj = document.form;
	switch (event.srcElement.name) {		
		case "pol_cd":
			if(formObj.bkg_cgo_tp_cd.value == "P"){
				formObj.f_cmd.value = SEARCH01;
				formObj.loc_cd.value = formObj.pol_cd.value;
				var rXml = sheetObjects[0].GetSearchXml("ESM_BKG_0554GS.do", FormQueryString(formObj));
				var loc_nm = ComGetEtcData(rXml, "loc_nm");				
				
				if (loc_nm == undefined){					
					ComShowCodeMessage('BKG00061',formObj.pol_cd.value);
					formObj.loc_cd.value="";
					formObj.pol_cd.value="";
					formObj.s_cust_addr.value="";
				}else{
					document.getElementById("s_cust_addr").value = loc_nm;
					formObj.loc_cd.value="";
        		}				
			}
			
			break;
		case "pod_cd":
			if(formObj.bkg_cgo_tp_cd.value == "P"){
				formObj.f_cmd.value = SEARCH01;
				formObj.loc_cd.value = formObj.pod_cd.value;
				var rXml = sheetObjects[0].GetSearchXml("ESM_BKG_0554GS.do", FormQueryString(formObj));
				var loc_nm = ComGetEtcData(rXml, "loc_nm");				
				
				if (loc_nm == undefined){					
					ComShowCodeMessage('BKG00061',formObj.pod_cd.value);
					formObj.loc_cd.value="";
					formObj.pod_cd.value="";
					formObj.c_cust_addr.value="";
					formObj.n_cust_addr.value="";
				}else{
					document.getElementById("c_cust_addr").value = loc_nm;
					document.getElementById("n_cust_addr").value = loc_nm;
					formObj.loc_cd.value="";
					
        		}	
			}			
			break;
	}
}

//function cboTrans_OnChange(){
//	var formObj = document.form;
//	if(formObj.cboTrans.Code == "T"){
//		formObj.ts_pod_cd.disabled = false;
//	}else{
//		formObj.ts_pod_cd.disabled = true;
//	}
//}