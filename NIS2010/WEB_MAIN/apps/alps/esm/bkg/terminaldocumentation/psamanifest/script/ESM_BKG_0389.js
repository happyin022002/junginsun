/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0389.js
*@FileTitle : NIS vs Portnet Reconciliation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.07.03 박상훈
* 1.0 Creation 
=========================================================*/

/**
 * JSDOC 생성을 위한 함수 정의
 */
function esm_bkg_0389()
{
	this.processButtonClick			= processButtonClick;
	this.setSheetObject				= setSheetObject;
	this.loadPage					= loadPage;
	this.initSheet					= initSheet;
	this.doActionIBSheet			= doActionIBSheet;
	this.setTabObject				= setTabObject;
	this.initTab					= initTab;
	this.tab1_OnChange				= tab1_OnChange;
	this.validateForm				= validateForm;
	this.t1sheet1_OnSearchEnd		= t1sheet1_OnSearchEnd;
	this.setComboObject				= setComboObject;
	this.initCombo					= initCombo;
	this.cboVVD_OnChange			= cboVVD_OnChange;
	this.portChange					= portChange;
	this.etdChange					= etdChange;
	this.changeViewType				= changeViewType;
	this.checkDifference			= checkDifference;
}

//공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;

//View TYPE
var viewType  = 0;
// Port, ETD 변경 여부
var changePortNEtd = true;

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	var sheetObject3 = sheetObjects[2];
	var comboObject1 = comboObjects[0];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

		case "btn_Retrieve":
			doActionIBSheet(sheetObjects[3],document.form, IBSEARCH);
			break;

		case "btn_New":
			formObject.reset();
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
			sheetObjects[2].RemoveAll();
			comboObjects[0].RemoveAll();	
			tabObjects[0].selectedIndex=0;
			break;

		case "btn_Save":
			doActionIBSheet(sheetObjects[2],document.form, IBSAVE);
			break;

		case "btn_DownExcel":
			sheetObjects[tabObjects[0].selectedIndex].Down2Excel(-1);
			break;

		case "btn_PSAIF":
			if (formObject.vvd.value.length < 1 ) {
				ComShowCodeMessage("BKG00115");
			}else {
				// EXCEL FILE UPLOAD
				var columnMappings = "1=>vvd_nm|11=>cntr_no|12=>port_cd|18=>cntr_tp_cd|25=>und_deck_tp_id|26=>special";				
				sheetObjects[2].RemoveAll();
				sheetObjects[2].LoadExcel(1, 1, "", 1, -1, "", false, false, columnMappings);
				ComOpenWait(true);
				sheetObjects[2].ColumnSort("cntr_no");
				for(var i=1; i <= sheetObject3.RowCount; i++) {
					sheetObject3.CellValue(i, "cntr_sz_cd") = sheetObject3.CellValue(i, "cntr_tp_cd").substring(0,2);
					sheetObject3.CellValue(i, "cntr_tp_cd") = sheetObject3.CellValue(i, "cntr_tp_cd").substring(2,4);
				}
				tabObjects[0].selectedIndex = 2;
				ComOpenWait(false);
				ComBtnEnable("btn_Save");
			}
			break;

		case "btn_JurongIF":
			if (formObject.vvd.value.length < 1) {
				ComShowCodeMessage("BKG00115");
			}else {
				// FILE UPLOAD
				var return_val = openUpload(formObject.subSysCd.value);
				if (return_val) {
					formObject.file_key.value = return_val;
					// FILE KEY를 이용하여 서버에서 파싱 처리
					doActionIBSheet(sheetObjects[3],document.form, COMMAND01);
				}
			}
			break;

		case "btn_Print":
			ComOpenWindowCenter("/hanjin/ESM_BKG_0876.do?pgmNo=ESM_BKG_0876", "0876", 1024, 720, false);
			break;
			
		case "btn_cal1":
			var cal = new ComCalendar(); 
			cal.setEndFunction("etdChange");
 			cal.select(formObject.eta_etd, 'yyyy-MM-dd');
 			
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

	for(var k=0;k<comboObjects.length;k++) {
        initCombo(comboObjects[k],k+1);
    }
		
	for(k=0;k<tabObjects.length;k++){
		initTab(tabObjects[k],k+1);
	}
	
	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
    axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    
    document.form.etd_dt.value = ComGetMaskedValue(ComGetNowInfo("ymd"),"ymd");
    document.form.eta_etd.value = document.form.etd_dt.value;
    document.form.eta_dt.value = document.form.etd_dt.value;
    
    ComBtnDisable("btn_Save");
    portChange();

}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {

	var cnt = 0;

	switch(sheetNo) {
	case 1:      //t1sheet1 init
	with (sheetObj) {
		// 높이 설정
		style.height = 377;
		//전체 너비 설정
		SheetWidth = mainTable.clientWidth;

		//Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

		//전체Merge 종류 [선택, Default msNone]
		MergeSheet = msHeaderOnly;

		//전체Edit 허용 여부 [선택, Default false]
		Editable = true;

		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo(2, 1, 3, 100);

		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(16, 0, 0, true);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(true, true, false, true, false,false)

		var HeadTitle1 = "Seq.|BKG No.|Container No.|ALPS|ALPS|ALPS|ALPS|ALPS|ALPS|ALPS|PSA|PSA|PSA|PSA|PSA|PSA";
		var HeadTitle2 = "Seq.|BKG No.|Container No.|TP|SZ|POD|NEXT POD|NEXT VVD|Special|Load|TP|SZ|POD|Special|Load|Diff";

		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle1, true);
		InitHeadRow(1, HeadTitle2, true);


		//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		InitDataProperty(0, cnt++ , dtDataSeq,		40,		daCenter,	true,		"Seq")
		InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"bkg_no",			false,          "",      dfNone,			0,     true,       true);
		InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,		"cntr_no",			false,          "",      dfNone,			0,     true,       true);
		InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,		"alps_cntr_tp_cd",	false,          "",      dfNone,			0,     true,       true);
		InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,		"alps_cntr_sz_cd",	false,          "",      dfNone,			0,     true,       true);
		InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,		"alps_port_cd",		false,          "",      dfNone,			0,     true,       true, 5);
		InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	true,		"next_pod",			false,          "",      dfNone,			0,     true,       true);
		InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,		"next_vvd",			false,          "",      dfNone,			0,     true,       true);
		InitDataProperty(0, cnt++ , dtData,			85,		daLeft,		true,		"alps_special",		false,          "",      dfNone,			0,     true,       true);
		InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"alps_load",		false,          "",      dfNone,			0,     true,       true);
		InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,		"psa_cntr_tp_cd",	false,          "",      dfNone,			0,     true,       true);
		InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,		"psa_cntr_sz_cd",	false,          "",      dfNone,			0,     true,       true);
		InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"psa_port_cd",		false,          "",      dfNone,			0,     true,       true, 5);
		InitDataProperty(0, cnt++ , dtData,			85,		daLeft,		true,		"psa_special",		false,          "",      dfNone,			0,     true,       true);
		InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"psa_load",			false,          "",      dfNone,			0,     true,       true);
		InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"psa_diff",			false,          "",      dfNone,			0,     true,       true);
		
		InitDataValid(0, "alps_port_cd", vtEngUpOther, "0123456789");
		InitDataValid(0, "psa_port_cd", vtEngUpOther, "0123456789");


	}
	break;

	case 2:      //t2sheet1 init
	with (sheetObj) {
		// 높이 설정
		style.height = 377;
		//전체 너비 설정
		SheetWidth = mainTable.clientWidth;

		//Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

		//전체Merge 종류 [선택, Default msNone]
		MergeSheet = msNone;

		//전체Edit 허용 여부 [선택, Default false]
		Editable = true;

		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo( 1, 1, 3, 100);

		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(9, 0, 0, true);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(true, true, false, true, false,false)

		var HeadTitle = "Seq.|Container No.|TP|SZ|POD|NEXT POD|NEXT VVD|Special|Load";

		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle, true);


		//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		InitDataProperty(0, cnt++ , dtDataSeq,			45,		daCenter,	false,	"Seq");
		InitDataProperty(0, cnt++ , dtData,				150,	daCenter,	false,	"cntr_no",		false,	"",	dfNone,			0,     true,       true);
		InitDataProperty(0, cnt++ , dtData,				105,	daCenter,	false,	"cntr_tp_cd",	false,	"",	dfNone,      		0,     true,       true);
		InitDataProperty(0, cnt++ , dtData,				105,	daCenter,	false,	"cntr_sz_cd",	false,	"",	dfNone, 		 	0,     true,       true);
		InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	false,	"port_cd",		false,	"",	dfNone,   	 	0,     true,       true, 5);
		InitDataProperty(0, cnt++ , dtHidden,			80,		daCenter,	false,	"next_pod",		false,	"",	dfNone,   	 	0,     true,       true);
		InitDataProperty(0, cnt++ , dtHidden,			80,		daCenter,	false,	"next_vvd",		false,	"",	dfNone,   	 	0,     true,       true);
		InitDataProperty(0, cnt++ , dtData,				200,	daLeft,		false,	"special",		false,	"",	dfNone,      		0,     true,       true);
		InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	false,	"stwg_cd",		false,	"",	dfNone,      		0,     true,       true);
		
		InitDataValid(0, "port_cd", vtEngUpOther, "0123456789");
		

	}
	break;

	case 3:      //t3sheet1 init
	with (sheetObj) {
		// 높이 설정
		style.height = 377;
		//전체 너비 설정
		SheetWidth = mainTable.clientWidth;

		//Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

		//전체Merge 종류 [선택, Default msNone]
		MergeSheet = msNone;

		//전체Edit 허용 여부 [선택, Default false]
		Editable = true;

		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo( 1, 1, 3, 100);

		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(9, 0, 0, true);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(true, true, false, true, false,false)

		var HeadTitle = "|Seq.|Container No.|TP|SZ|POD|Special|Load|VVD_NAME";

		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle, true);


		//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		InitDataProperty(0, cnt++ , dtHiddenStatus,		45,			daCenter,	false,	"ibflag");
		InitDataProperty(0, cnt++ , dtDataSeq,			45,			daCenter,	false,	"Seq");
		InitDataProperty(0, cnt++ , dtData,				150,		daCenter,	false,	"cntr_no",			false,	"",	dfNone,	  0,     true,       true);
		InitDataProperty(0, cnt++ , dtData,				145,		daCenter,	false,	"cntr_tp_cd",		false,	"",	dfNone,   0,     true,       true);
		InitDataProperty(0, cnt++ , dtData,				145,		daCenter,	false,	"cntr_sz_cd",		false,	"",	dfNone,   0,     true,       true);
		InitDataProperty(0, cnt++ , dtData,				145,		daCenter,	false,	"port_cd",			false,	"",	dfNone,   0,     true,       true, 5);
		InitDataProperty(0, cnt++ , dtData,				200,		daLeft,		false,	"special",			false,	"",	dfNone,   0,     true,       true);
		InitDataProperty(0, cnt++ , dtData,				90,			daCenter,	false, "und_deck_tp_id",	false,	"",	dfNone,   0,     true,       true);
		InitDataProperty(0, cnt++ , dtHidden,			90,			daCenter,	false, "vvd_nm",			false,	"",	dfNone,   0,     true,       true);
		
		InitDataValid(0, "port_cd", vtEngUpOther, "0123456789");		

	}
	break;
	
	case 4:      //t1sheet2 init
	with (sheetObj) {
		// 높이 설정
		style.height = 0;
		//전체 너비 설정
		SheetWidth = mainTable.clientWidth;

		//Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

		//전체Merge 종류 [선택, Default msNone]
		MergeSheet = msNone;

		//전체Edit 허용 여부 [선택, Default false]
		Editable = true;

		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo( 1, 1, 3, 100);

		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(1, 0, 0, true);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(true, true, false, true, false,false)

		var HeadTitle = "vvd";

		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle, true);

		//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		InitDataProperty(0, cnt++ , dtData,				150,		daCenter,	false,	"vvd",	false,	"",	dfNone,			0,     true,       true);

	}
	break;

	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {

	case IBSEARCH:      //조회	
		if(validateForm(sheetObj,formObj,sAction)) {
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			tabObjects[0].selectedIndex = 0;
			sheetObjects[0].Redraw = false;
			formObj.f_cmd.value = SEARCH;
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0389GS.do", FormQueryString(formObj));
			var arrXml = sXml.split("|$$|");
			if(arrXml.length > 0)
				sheetObjects[0].LoadSearchXml(arrXml[0]);
				// 정렬
				sheetObjects[0].ColumnSort("bkg_no|cntr_no");
			if(arrXml.length > 1){
				sheetObjects[1].LoadSearchXml(arrXml[1]);
				// 정렬
				sheetObjects[1].ColumnSort("cntr_no");
			}
			if(arrXml.length > 2){
				sheetObjects[2].LoadSearchXml(arrXml[2]);
				// 정렬
				sheetObjects[2].ColumnSort("cntr_no");				
			}
			checkDifference(sheetObjects[0]);
			// RADIO BOX에 따른 TAB 전환
			tabObjects[0].selectedIndex = viewType;
			sheetObjects[0].Redraw = true;
			ComBtnDisable("btn_Save");			
			ComOpenWait(false);
		}
		break;
		
	case COMMAND01:      // Jurong I/F 파싱	
		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);
		formObj.f_cmd.value = COMMAND01;
		var sXml = sheetObj.GetSearchXml("ESM_BKG_0389GS.do", FormQueryString(formObj));

		// sheet에 Load
		sheetObjects[2].LoadSearchXml(sXml);
		sheetObjects[2].ColumnSort("cntr_no");
		tabObjects[0].selectedIndex = 2;		
		ComOpenWait(false);
		ComBtnEnable("btn_Save");
		break;
		
	case IBSAVE:        //저장
		if(validateForm(sheetObj,formObj,sAction)) {
			if(ComShowCodeConfirm('BKG95003', 'save')) {
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI;
				var params = sheetObj.GetSaveString(true) + "&" + FormQueryString(formObj);
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0389GS.do", params);		
				sheetObj.LoadSaveXml(sXml);
				var state = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);   				  
				if (state == "S") {   
					doActionIBSheet(sheetObjects[3], formObj, IBSEARCH);
				}
				ComOpenWait(false);
			}
		}
		break;

	case SEARCH01:      // 코드조회
		formObj.f_cmd.value = SEARCH01;		
		sheetObj.DoSearch("ESM_BKG_0389GS.do", FormQueryString(formObj));
		break;
	}
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
			InsertTab( cnt++ , "Unmatch" , -1 );
			InsertTab( cnt++ , "ALPS" , -1 );
			InsertTab( cnt++ , "PSA" , -1 );

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
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
				
		if (formObj.rly_port.value.length < 5) {
			ComShowCodeMessage("BKG00424");
			formObj.rly_port.focus();
			return false;
		}
		
		if (formObj.vvd.value.length < 9) {
			ComShowCodeMessage("BKG00115");
			return false;
		}		
	}

	return true;
}

/**
 * Tab1 Sheet1 조회 후 Difference Font 색 처리 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function t1sheet1_OnSearchEnd(sheetObj, ErrMsg)
{
	with(sheetObj)
	{
		for (var i = 2; i <= LastRow; i ++)
		{
			if ("Y" == CellValue(i, "PSA_DIFF"))
				CellFontColor(i, "PSA_DIFF") = RgbColor(255, 0, 0);		// 글자는 붉은색
		}

	}
}

//페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
function setComboObject(combo_obj){
	  comboObjects[comboCnt++] = combo_obj;
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
	case "cboVVD":
		with (comboObj) {
			SetColAlign("left");
			SetColWidth("120");
			DropHeight = 400;
			ShowCol = 0;
			SetTitle("VVD");
			MultiSelect = false;
			MaxSelect = 1 ;
		}
		break;
	}
}

function cboVVD_OnKeyDown(comboObj, KeyCode, Shift) {
	document.form.vvd.value = comboObj.Text;
}  

/**
 * VVD 콤보 변경 처리 
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function cboVVD_OnChange(comboObj,value,text) {
	document.form.vvd.value = value;
	if (value=="") document.form.vvd.value = text;
}

/**
 * PORT 변경시 재 조회 처리 
 * @return
 */
function portChange()
{
	changePortNEtd = true;
	
	var form = document.form;
	
	// 변경사항이 있으면 다시 코드 조회
	if (changePortNEtd) {
		
		if (form.rly_port.value.length > 4 && form.eta_etd.value.length == 10) {
			comboObjects[0].Enable = false;
			// VVD 목록 조회
			ComOpenWait(true);
			doActionIBSheet(sheetObjects[3],document.form, SEARCH01);		
			// 조회후 변경사항 초기화
			changePortNEtd = false;
			// COMBO에 반영
			comboObjects[0].RemoveAll();
			for(var i=1; i <= sheetObjects[3].RowCount; i++ ) {
				comboObjects[0].InsertItem(i-1, sheetObjects[3].CellValue(i,"vvd"), sheetObjects[3].CellValue(i,"vvd"));
			}
			ComOpenWait(false);
			comboObjects[0].Enable = true;
		}
	}
}

/**
 * ETD 변경시 재 조회 처리 
 * @return
 */
function etdChange()
{
	changePortNEtd = true;
	
	var form = document.form;
	
	form.etd_dt.value = "";
	form.eta_dt.value = "";
	if (form.trans_tp_cd.value=="E") {
		form.etd_dt.value = form.eta_etd.value;
	}else {
		form.eta_dt.value = form.eta_etd.value;
	}
	
	// 변경사항이 있으면 다시 코드 조회
	if (changePortNEtd) {
		
		if (form.rly_port.value.length > 4 && form.eta_etd.value.length == 10) {
			comboObjects[0].Enable = false;
			// VVD 목록 조회
			ComOpenWait(true);
			doActionIBSheet(sheetObjects[3],document.form, SEARCH01);		
			// 조회후 변경사항 초기화
			changePortNEtd = false;
			// COMBO에 반영
			comboObjects[0].RemoveAll();
			for(var i=1; i <= sheetObjects[3].RowCount; i++ ) {
				comboObjects[0].InsertItem(i-1, sheetObjects[3].CellValue(i,"vvd"), sheetObjects[3].CellValue(i,"vvd"));
			}
			ComOpenWait(false);
			comboObjects[0].Enable = true;
		}
	}
}

/**
 * View Type 변경 처리
 * @param val
 * @return
 */
function changeViewType(val) {
	viewType = val;
	tabObjects[0].selectedIndex = val;
}
 
/**
 * ALPS vs PSA 비교처리 
 * 
 * @param sheetObj
 * @return
 */ 
function checkDifference(sheetObj) {
	
	var diff;
	
	for(var i=2; i <= sheetObj.RowCount +1 ; i++) {
		
		diff = "N";

		with(sheetObj) {
			// TP 비교
			if (CellValue(i, "alps_cntr_tp_cd")!=CellValue(i, "psa_cntr_tp_cd")) {
				CellBackColor(i,"psa_cntr_tp_cd") = RgbColor(100, 255, 100);
				diff = "Y";
			}
			// SZ 비교
			if (CellValue(i, "alps_cntr_sz_cd")!=CellValue(i, "psa_cntr_sz_cd")) {
				CellBackColor(i,"psa_cntr_sz_cd") = RgbColor(100, 255, 100);
				diff = "Y";
			}
			// PORT 비교
			if (document.form.trans_tp_cd.value=="E") {
				if (CellValue(i, "alps_port_cd")!=CellValue(i, "psa_port_cd")) {
					CellBackColor(i,"psa_port_cd") = RgbColor(100, 255, 100);
					diff = "Y";
				}
			}else {
				if (CellValue(i, "next_pod")!=CellValue(i, "psa_port_cd")) {
					CellBackColor(i, "psa_port_cd") = RgbColor(100,255,100);
					diff = "Y";
				}
			}
			// SPECIAL 비교
			if (CellValue(i, "alps_special")!=CellValue(i, "psa_special")) {
				CellBackColor(i,"psa_special") = RgbColor(100, 255, 100);
				diff = "Y";
			}
			// LOAD 비교
			if (CellValue(i, "alps_load")!=CellValue(i, "psa_load")) {
				CellBackColor(i,"psa_load") = RgbColor(100, 255, 100);
				diff = "Y";
			}
			
			CellValue(i, "psa_diff") = diff;
			
			if (diff=="Y") {			
				CellFontColor(i, "psa_diff") = RgbColor(255, 0, 0);		// 글자는 붉은색
			}else {
				CellFontColor(i, "psa_diff") = RgbColor(0, 0, 0);		// 글자는 검정색
			}
		}
	}
 	
}

/**
 * Trans 변경시 처리
 * @return
 */
function trans_tp_change()
{
	
	var form = document.form;
	
	if (form.trans_tp_cd.value=="E") {
		document.all.spanEtdEta.innerHTML = "ETD";
		sheetObjects[0].CellValue(1,12) = "POD";
		sheetObjects[0].CellValue(1,5) = "POD";
		sheetObjects[1].CellValue(0,4) = "POD";
		sheetObjects[2].CellValue(0,5) = "POD";
		form.eta_etd.value = form.etd_dt.value;
		sheetObjects[0].ColHidden("next_pod") = true;		
		sheetObjects[0].ColHidden("next_vvd") = true;
		sheetObjects[1].ColHidden("next_pod") = true;
		sheetObjects[1].ColHidden("next_vvd") = true;
	}else {
		document.all.spanEtdEta.innerHTML = "ETA";
		sheetObjects[0].CellValue(1,5) = "POL";
		sheetObjects[0].CellValue(1,12) = "NEXT POD";
		sheetObjects[1].CellValue(0,4) = "POL";
		sheetObjects[2].CellValue(0,5) = "NEXT POD";
		form.eta_etd.value = form.eta_dt.value;
		sheetObjects[0].ColHidden("next_pod") = false;
		sheetObjects[0].ColHidden("next_vvd") = false;
		sheetObjects[1].ColHidden("next_pod") = false;
		sheetObjects[1].ColHidden("next_vvd") = false;
	}
	
	etdChange();
	
}