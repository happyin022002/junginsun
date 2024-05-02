/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESD_EAS_0011.js
 *@FileTitle : Drop Off Charge Tariff List 조회
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012-03-02
 *@LastModifier : sungho park
 *@LastVersion : 1.0
 * 2012-03-02 sungho park
 * 1.0 최초 생성
 * 2012-03-02 sungho park
 * =========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends Bkg
 * @class ESD_EAS_0011 : 예)Drop Off Charge Tariff List 조회 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function ESD_EAS_0011() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.setComboObject = setComboObject;
	this.setTabObject = setTabObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.initTab = initTab;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm;
}

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var shtObj = null;
var sheetrow = 0;

var comboObjects = new Array();
var comboCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

var IBSEARCH01 = 29;
var IBSEARCH02 = 30;
var IBSEARCH13 = 31;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 ****/
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	var sheetObject2 = sheetObjects[2];		
	/** *************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
		case "btn_Save":		
			
			if(!chkOffice()){
//				alert('User office is different.');
				ComShowCodeMessage("EAS90024");
				return;
			}			
			
			if(!chkSccYdChkRowAdd()){
				return;
			}
			
			if(!chkSccCdYn()){
				return;
			}
			
			if(!chkSccCdDup()){
//				alert('중복된 SCC Code가 있습니다.');
//				alert('Wrong SCC code is found.[1]');
				ComShowCodeMessage("EAS90025");
				return;
			}
			
			if(!chkSccCd()){
				return;
			}
						
			for (var i = parseFloat(sheetObject1.HeaderRows); i < parseFloat(sheetObject1.HeaderRows) + parseFloat(sheetObject1.RowCount); i++) {
				sheetObject1.CellValue(i,'curr_cd') = sheetObject1.CellText(i,'curr_cd');
			}			
			
			if(!chkUpload()){								
//				alert('잘 못 된 형식의 입력 데이타가 있습니다.');
//				alert('There is errors in data form.');
				ComShowCodeMessage("EAS90026");
				return;
			}
			
			if(!chkAllExempted()){
				return;
			}	
			
			if(!chkAllExempted2()){
				return;
			}			
			
// 이 기능 삭제			
//			if(!chkAllExemptedPort()){
//				return;
//			}				
			
			if(!chkSave()){
				return;
			}			
			
			doActionIBSheet(sheetObject1, formObject, IBSAVE);
			break;
		case "btn_DownExcel":
			doActionIBSheet(sheetObject1, formObject, IBDOWNEXCEL);
			break;
		case "btn_retrieve":
			if (!validateForm(formObject)) {
				return false;
			}		
			sheetObject.RemoveAll();
			sheetObject1.RemoveAll();
			sheetObject2.RemoveAll();
			
			doActionIBSheet(sheetObject, formObject, IBSEARCH);

			break;
		case "btn_new":
			sheetObject.RemoveAll();
			sheetObject1.RemoveAll();
			
			formObject.reset();
			
			ComBtnDisable("btn_NewVersion");	
			ComBtnDisable("btn_Revise");	
			ComBtnDisable("btn_DownExcel");	
			ComBtnDisable("btn_UploadExcel");				
			ComBtnDisable("btn_RowAdd");
			ComBtnDisable("btn_RowDelete");
			ComBtnDisable("btn_Save");			
			break;
		case "cnt_btn":
			with (formObject) {
				var v_cnt_cd = cnt_cd.value;
				var classId = "COM_ENS_0M1";
				var param = '?cnt_cd=' + v_cnt_cd + '&classId=' + classId;

				var v_display = "1,0,1,1,1,0,0";
				var chkStr = v_display.substring(0, 3)

				if (chkStr == "1,0") {
					ComOpenPopup('/hanjin/COM_ENS_0M1.do' + param, 565, 480,'getCOM_ENS_0M1_1', v_display, true);
				} else {
					return;
				}
			}
			break;
		case "btn_NewVersion":
			if(!chkNewVersion(sheetObject)){
//				alert('New Version 상태입니다.\n새버전을 추가 할 수 없습니다.');
				return;
			}

			if(!chkRevise(sheetObject)){
//				alert('Revise 상태입니다.\n새버전을 추가 할 수 없습니다.');
				return;
			}			
						
			if (document.form.search_choice[0].checked == true) {
				sheetObject1.RemoveAll();							
				processRowInsert(sheetObject);
				if (sheetObject1.RowCount == 0) {
					formObject.drff_chg_trf_ver_no.value = '';					// New Version 초기화
					doActionIBSheet(sheetObject1, formObject, IBSEARCH01);
				}								
				ComBtnEnable("btn_UploadExcel");				
				ComBtnDisable("btn_RowAdd");
				ComBtnDisable("btn_RowDelete");
				ComBtnEnable("btn_Save");				
			} else if (document.form.search_choice[1].checked == true) {
				sheetObject1.RemoveAll();
				processRowInsert(sheetObject);
				ComBtnEnable("btn_UploadExcel");				
				ComBtnEnable("btn_RowAdd");
				ComBtnEnable("btn_RowDelete");
				ComBtnEnable("btn_Save");				
			}
			setCellControl();
// 이 기능 삭제			
//			setPortAllExempted();
			break;
		case "btn_Revise":			
			if(!chkOffice()){
//				alert('User office is different.');
				ComShowCodeMessage("EAS90024");
				return;
			}
			
			if(!chkNewVersion(sheetObject)){
//				alert('New Version 상태입니다.\n이 버전을 수정 할 수 없습니다.');
				return;
			}
			if(!chkRevise(sheetObject)){
//				alert('Revise 상태입니다.\n이 버전을 수정 할 수 없습니다.');
				return;
			}			
			
			if (document.form.search_choice[0].checked == true) {
				ComBtnEnable("btn_UploadExcel");				
				ComBtnDisable("btn_RowAdd");
				ComBtnDisable("btn_RowDelete");								
				ComBtnEnable("btn_Save");
			} else if (document.form.search_choice[1].checked == true) {
				ComBtnEnable("btn_UploadExcel");				
				ComBtnEnable("btn_RowAdd");
				ComBtnEnable("btn_RowDelete");
				ComBtnEnable("btn_Save");
			}
			processRowUpdate(sheetObject);			
			setCellControl();
// 이 기능 삭제			
//			setPortAllExempted();			
			break;

 	    case "btn_UploadExcel":
			if(!chkOffice()){
//				alert('User office is different.');
				ComShowCodeMessage("EAS90024");
				return;
			} 	    	 	    	
			ComBtnDisable("btn_RowAdd");
			ComBtnDisable("btn_RowDelete");				
 	    	moveSheet13Load(); 	
            break;	
		case "btn_RowAdd":
			if(!chkOffice()){
//				alert('User office is different.');
				ComShowCodeMessage("EAS90024");
				return;
			}
			
			processRowInsertItem(sheetObject1);
			break;            
		case "btn_RowDelete":
			if(!chkOffice()){
//				alert('User office is different.');
				ComShowCodeMessage("EAS90024");
				return;
			}
			
			doActionIBSheet(sheetObject1, formObject, IBDELETE);
			break;					
		} // end switch

	} catch (e) {
		if (e == "[object Error]") {
			errMsg = ComGetMsg("COM12111");
			ComShowMessage(errMsg);
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
		initControl();
	}
	initButtonControl();	
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	sheetObj.UseUtf8 = true;

	switch (sheetNo) {
	case 1: //IBSheet1 init
		with (sheetObj) {
			var cnt = 0;
			// 높이 설정
			style.height = 200;

			// 전체 너비 설정
			// SheetWidth = mainTable.clientWidth;
			style.width = 600;
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 15, 6);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(8, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			var HeadTitle =  "|||Ver.|Effective|Effective|Creation|Creation";
			var HeadTitle1 = "|||Ver.|From|To|Office|ID";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			InitHeadRow(1, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]			
			InitDataProperty(0,  cnt++,  dtHiddenStatus		, 30	, daCenter	, false	,    "ibflag",		      	false,          "",       dfNone,    0,     false,   false);
			InitDataProperty(0,  cnt++,  dtHidden			, 30	, daCenter	, false	,    "drff_chg_trf_seq",	false,          "",       dfNone,    0,     false,   false);			
			InitDataProperty(0 , cnt++ , dtHidden			, 65   	, daCenter  , true  , "seq"     				, false  , ""        ,dfNone   		,0         , false     , false);
			InitDataProperty(0 , cnt++ , dtData    	, 65   	, daCenter  , true  , "drff_chg_trf_ver_no"     , false  , ""        ,dfNone    	,0         , false     , false);
			InitDataProperty(0 , cnt++ , dtData    	, 120   , daCenter  , false , "fm_eff_dt"             	, true   , ""        ,dfDateYmd    	,0         , false     , false);
			InitDataProperty(0 , cnt++ , dtData    	, 120   , daCenter  , false , "to_eff_dt"             	, false  , ""        ,dfDateYmd    	,0         , false     , false);
			InitDataProperty(0 , cnt++ , dtData    	, 120   , daCenter  , false , "cre_ofc_cd"             	, true   , ""        ,dfNone    	,0         , false     , false);
			InitDataProperty(0 , cnt++ , dtData    	, 120   , daCenter  , false , "cre_usr_id"             	, true   , ""        ,dfNone    	,0         , false     , false);

			sheetObj.CountPosition = 0;
			sheetObj.MultiSelection = false;

		}
		break;
	case 2: //IBSheet2 init
		with (sheetObj) {
			var cnt = 0;
			// 높이 설정
			style.height = GetSheetHeight(11);

			// 전체 너비 설정
			SheetWidth = mainTable1.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 15, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(20, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			var HeadTitle =  "|||||MT Location|MT Location|Origin\nContinent|POD\nCountry|Cur|Drop-off Rate|Drop-off Rate|Drop-off Rate|Drop-off Rate|Drop-off Rate|Drop-off Rate|Drop-off Rate";
			var HeadTitle1 = "|||||SCC|Port/\nInland|Origin\nContinent|POD\nCountry|Cur|All\nExempted|D2|D4|D5|R2|R5|R9";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			InitHeadRow(1, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus			,30		,daCenter  ,false	,"ibflag"				,false	,""	,dfNone,    0,     false,   false);
			InitDataProperty(0, cnt++, dtHidden			,30		,daCenter  ,false	,"del");				
			InitDataProperty(0, cnt++, dtHidden			,30		,daCenter  ,false	,"drff_chg_trf_seq"		,false	,""	,dfNone,    0,     false,   false);
			InitDataProperty(0, cnt++, dtHidden   		,30   	,daCenter  ,false   ,"drff_chg_trf_ver_no"  ,false  ,""        , dfNone    , 0         , false     , false);
			InitDataProperty(0, cnt++, dtHidden   		,30   	,daCenter  ,false   ,"drff_chg_trf_dtl_seq"	,false   ,""        , dfNone    , 0         , false     , false);
			InitDataProperty(0, cnt++, dtData    		,80   	,daCenter  ,false   ,"scc_cd"             	,true   ,""        , dfNone    , 0         , false     , false);
			InitDataProperty(0, cnt++, dtCombo    		,80   	,daCenter  ,false   ,"port_inlnd_cd"        ,false   ,""        , dfNone    , 0         , false     , false);
			InitDataProperty(0, cnt++, dtCombo    		,90   	,daCenter  ,true   ,"conti_cd"             	,false   ,""        , dfNone    , 0         , false     , false);
			InitDataProperty(0, cnt++, dtCombo    		,90   	,daCenter  ,true   ,"pod_cnt_cd"           	,false   ,""        , dfNone    , 0         , false     , false);
			InitDataProperty(0, cnt++, dtCombo    		,80   	,daCenter  ,true   ,"curr_cd"              	,true   ,""        , dfNone    , 0         , false     , false);
			InitDataProperty(0, cnt++, dtCombo    		,80   	,daCenter  ,true   ,"exp_flg"              	,true   ,""        , dfNone    , 0         , false     , false);
			InitDataProperty(0, cnt++, dtData    		,80   	,daCenter  ,false   ,"d2"     				,true  ,""        , dfNone    , 0         , false     , false);
			InitDataProperty(0, cnt++, dtData    		,80   	,daCenter  ,false   ,"d4"     				,true  ,""        , dfNone    , 0         , false     , false);
			InitDataProperty(0, cnt++, dtData    		,80   	,daCenter  ,false   ,"d5"     				,true  ,""        , dfNone    , 0         , false     , false);
			InitDataProperty(0, cnt++, dtData    		,80   	,daCenter  ,false   ,"r2"     				,true  ,""        , dfNone    , 0         , false     , false);
			InitDataProperty(0, cnt++, dtData    		,80   	,daCenter  ,false   ,"r5"     				,true  ,""        , dfNone    , 0         , false     , false);
			InitDataProperty(0, cnt++, dtData    		,80   	,daCenter  ,false   ,"r9"     				,true  ,""        , dfNone    , 0         , false     , false);			
			InitDataProperty(0, cnt++, dtHidden  		,80   	,daCenter  ,false   ,"curr_list_ctnt"     	,false  ,""        , dfNone    , 0         , true     , true);
			InitDataProperty(0, cnt++, dtHidden  		,80   	,daCenter  ,false   ,"scc_yd_chk"	     	,false   ,""        , dfNone    , 0         , false     , false);			
			InitDataProperty(0, cnt++, dtHidden  		,30   	,daCenter  ,false   ,"scc_dup_chk"	     	,false  ,""        , dfNone    , 0         , true     , true);			

			
			InitDataCombo(0, "port_inlnd_cd", " |Port Area|Inland", " |Y|N");
			InitDataCombo(0, "conti_cd", "Africa|America|Asia|Europe", " F|M|A|E");
			InitDataCombo(0, "pod_cnt_cd", "ALBANIA|ANDORRA|ARMENIA|AUSTRIA|Azerbaijan|BELARUS|BELGIUM|BULGARIA|Bosnia and Herzegovina|CROATIA|CYPRUS|CZECH REPUBLIC|DENMARK|ESTONIA|EUROPEAN COMMUNITY|FAROE ISLANDS|FINLAND|FRANCE|GEORGIA|GERMANY|GIBRALTAR|GREECE|GREENLAND|HUNGARY|Holy See (Vatican City State)|ICELAND|IRELAND|ISEL OF MAN|ISRAEL|ITALY|KAZAKHSTAN|KYRGYZSTAN|LATVIA|LEBANON|LIECHTENSTEIN|LITHUANIA|LUXEMBOURG|MALTA|MONACO|MONTENEGRO|Macedonia, The former Yugoslav Republic of|Moldova, Republic of|NETHERLANDS|NORWAY|POLAND|PORTUGAL|REPUBLIC OF KOSOVO|REPUBLIC OF SERBIA|ROMANIA|RUSSIAN FEDERATION|SAN MARINO|SLOVAKIA|SLOVENIA|SPAIN|SWEDEN|SWITZERLAND|SYRIAN ARAB REPUBLIC|Serbia and Montenegro|TURKEY|UKRAINE|United Kingdom|YUGOSLAVIA", "AL|AD|AM|AT|AZ|BY|BE|BG|BA|HR|CY|CZ|DK|EE|EU|FO|FI|FR|GE|DE|GI|GR|GL|HU|VA|IS|IE|IM|IL|IT|KZ|KG|LV|LB|LI|LT|LU|MT|MC|ME|MK|MD|NL|NO|PL|PT|KO|RS|RO|RU|SM|SK|SI|ES|SE|CH|SY|CS|TR|UA|GB|YU");
//			InitDataCombo(0, "curr_cd", "EUR|USD|ATS", " EUR|USD|ATS");			
			InitDataCombo(0, "exp_flg", "Y|N", " Y|N");			
			InitDataValid(0, "scc_cd", vtEngUpOnly);
			sheetObj.MultiSelection = false;

		}	
		break;
	case 3: //IBSheet2 init
		with (sheetObj) {
			var cnt = 0;
			// 높이 설정
			style.height = GetSheetHeight(11);
	
			// 전체 너비 설정
			SheetWidth = mainTable1.clientWidth;
	
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);
	
			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
	
			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;
	
			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 15, 100);
	
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(20, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)
	
			var HeadTitle =  "|||||MT Location|MT Location|Origin\nContinent|POD\nCountry|Cur|Drop-off Rate|Drop-off Rate|Drop-off Rate|Drop-off Rate|Drop-off Rate|Drop-off Rate|Drop-off Rate";
			var HeadTitle1 = "|||||SCC|Port/\nInland|Origin\nContinent|POD\nCountry|Cur|All\nExempted|D2|D4|D5|R2|R5|R9";
	
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			InitHeadRow(1, HeadTitle1, true);
	
			InitDataProperty(0, cnt++, dtData			,30		,daCenter  ,false	,"ibflag"				,false	 ,""        , dfNone    , 0         , false     , false);
			InitDataProperty(0, cnt++, dtData			,30		,daCenter  ,false	,"del"					,false);				
			InitDataProperty(0, cnt++, dtData			,30		,daCenter  ,false	,"drff_chg_trf_seq"		,false	 ,""        , dfNone    , 0         , false     , false);
			InitDataProperty(0, cnt++, dtData   		,30   	,daCenter  ,false   ,"drff_chg_trf_ver_no"  ,false   ,""        , dfNone    , 0         , false     , false);
			InitDataProperty(0, cnt++, dtData   		,30   	,daCenter  ,false   ,"drff_chg_trf_dtl_seq"	,false   ,""        , dfNone    , 0         , false     , false);
			InitDataProperty(0, cnt++, dtData    		,80   	,daCenter  ,false   ,"scc_cd"             	,false   ,""        , dfNone    , 0         , false     , false);
			InitDataProperty(0, cnt++, dtData    		,80   	,daCenter  ,false   ,"port_inlnd_cd"        ,false   ,""        , dfNone    , 0         , false     , false);
			InitDataProperty(0, cnt++, dtData    		,90   	,daCenter  ,false   ,"conti_cd"             ,false   ,""        , dfNone    , 0         , false     , false);
			InitDataProperty(0, cnt++, dtData    		,90   	,daCenter  ,false   ,"pod_cnt_cd"           ,false   ,""        , dfNone    , 0         , false     , false);
			InitDataProperty(0, cnt++, dtData    		,80   	,daCenter  ,false   ,"curr_cd"              ,false   ,""        , dfNone    , 0         , false     , false);
			InitDataProperty(0, cnt++, dtData    		,80   	,daCenter  ,false   ,"exp_flg"              ,false   ,""        , dfNone    , 0         , false     , false);
			InitDataProperty(0, cnt++, dtData    		,80   	,daCenter  ,false   ,"d2"     				,false   ,""        , dfNone    , 0         , false     , false);
			InitDataProperty(0, cnt++, dtData    		,80   	,daCenter  ,false   ,"d4"     				,false   ,""        , dfNone    , 0         , false     , false);
			InitDataProperty(0, cnt++, dtData    		,80   	,daCenter  ,false   ,"d5"     				,false   ,""        , dfNone    , 0         , false     , false);
			InitDataProperty(0, cnt++, dtData    		,80   	,daCenter  ,false   ,"r2"     				,false   ,""        , dfNone    , 0         , false     , false);
			InitDataProperty(0, cnt++, dtData    		,80   	,daCenter  ,false   ,"r5"     				,false   ,""        , dfNone    , 0         , false     , false);
			InitDataProperty(0, cnt++, dtData    		,80   	,daCenter  ,false   ,"r9"     				,false   ,""        , dfNone    , 0         , false     , false);
			InitDataProperty(0, cnt++, dtData  			,80   	,daCenter  ,false   ,"curr_list_ctnt"     	,false   ,""        , dfNone    , 0         , false     , false);
			InitDataProperty(0, cnt++, dtData  			,80   	,daCenter  ,false   ,"scc_yd_chk"	     	,false   ,""        , dfNone    , 0         , false     , false);
			InitDataProperty(0, cnt++, dtData  			,80   	,daCenter  ,false   ,"scc_dup_chk"	     	,false   ,""        , dfNone    , 0         , false     , false);			
		}	
		break;		
	}
}

function getCOM_ENS_0M1_1(rowArray) {
	var colArray = rowArray[0];
	document.all.cnt_cd.value = colArray[3];
	document.all.sel_cnt_nm.value = colArray[4];
}

/**
 * IBSheet Grid의 RowAdd 버튼 기능을 처리한다.
 */
function processRowInsert(sheetObj) {
	sheetObj.DataAutoTrim = false;
	with (sheetObj) {
		var newRow = sheetObj.DataInsert(0);
		sheetObj.CellEditable(newRow, "fm_eff_dt") 	= true;
		sheetObj.CellEditable(newRow, "to_eff_dt") 	= true;
		sheetObj.CellValue2(newRow, "seq") 			= sheetObj.RowCount;
		sheetObj.CellValue2(newRow, "fm_eff_dt") 	= "";
		sheetObj.CellValue2(newRow, "to_eff_dt") 	= "";
		sheetObj.CellValue2(newRow, "cre_ofc_cd") 	= document.all.ctrl_ofc_cd.value;
		sheetObj.CellValue2(newRow, "cre_usr_id") 	= document.all.ctrl_user_id.value;
		sheetObj.CellValue2(newRow, "to_eff_dt") 	= "";
	}
}



/**
 * IBSheet Grid의 RowAdd 버튼 기능을 처리한다.
 */
function processRowInsertItem(sheetObj) {
	sheetObj.DataAutoTrim = false;

	with (sheetObj) {

		var newRow = sheetObj.DataInsert(0);

		sheetObj.CellEditable(newRow, "scc_cd") = true;
		sheetObj.CellEditable(newRow, "port_inlnd_cd") = true;
		sheetObj.CellEditable(newRow, "conti_cd") = true;
		sheetObj.CellEditable(newRow, "pod_cnt_cd") = true;
		sheetObj.CellEditable(newRow, "curr_cd") = true;
		sheetObj.CellEditable(newRow, "exp_flg") = true;
		sheetObj.CellEditable(newRow, "d2") = true;
		sheetObj.CellEditable(newRow, "d4") = true;
		sheetObj.CellEditable(newRow, "d5") = true;
		sheetObj.CellEditable(newRow, "r2") = true;
		sheetObj.CellEditable(newRow, "r5") = true;
		sheetObj.CellEditable(newRow, "r9") = true;

		sheetObj.CellValue2(newRow, "scc_cd") = "";
		sheetObj.CellValue2(newRow, "port_inlnd_cd") = "";
		sheetObj.CellValue2(newRow, "conti_cd") = "";
		sheetObj.CellValue2(newRow, "pod_cnt_cd") = "";
		sheetObj.CellValue2(newRow, "curr_cd") = "";
		sheetObj.CellValue2(newRow, "exp_flg") = "";
		sheetObj.CellValue2(newRow, "d2") = "";
		sheetObj.CellValue2(newRow, "d4") = "";
		sheetObj.CellValue2(newRow, "d5") = "";
		sheetObj.CellValue2(newRow, "r2") = "";
		sheetObj.CellValue2(newRow, "r5") = "";
		sheetObj.CellValue2(newRow, "r9") = "";
		sheetObj.CellValue2(newRow, "drff_chg_trf_seq") = document.all.drff_chg_trf_seq.value;
		sheetObj.CellValue2(newRow, "drff_chg_trf_ver_no") = document.all.drff_chg_trf_ver_no.value;
		sheetObj.CellValue2(newRow, "curr_list_ctnt") = 'EUR|USD';
	}
}

function initControl() {
	var formObject = document.form;

	axon_event.addListenerFormat('keypress', 'keypressFormat', formObject);
//	axon_event.addListener('keydown', 'ComKeyEnter', 'form');

}

//업무 자바스크립트 OnKeyPress 이벤트 처리
function keypressFormat() {
	var formObj = document.form;
	switch (event.srcElement.dataformat) {

	case "engup":
		ComKeyOnlyAlphabet('uppernum', ',');
		break;
	}
}

/* Sheet관련 프로세스 처리 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;

	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	var sheetObject2 = sheetObjects[2];	

	switch (sAction) {
	case IBSEARCH: //조회
		formObj.f_cmd.value = SEARCH;
		sheetObj.DoSearch4Post("ESD_EAS_0011GS.do", EasFrmQryString(formObj));
		break;

	case IBSEARCH01: //조회
		formObj.f_cmd.value = SEARCH01;
		sheetObj.DoSearch4Post("ESD_EAS_0011GS.do", EasFrmQryString(formObj));
		break;

	case IBSEARCH02: //조회
		formObj.f_cmd.value = SEARCH02;
		sheetObj.DoSearch4Post("ESD_EAS_0011GS.do", EasFrmQryString(formObj));
		break;

	case IBSEARCH13: //조회
		formObj.f_cmd.value = SEARCH13;		
		var param = sheetObject2.GetSaveString();
		sheetObj.DoSearch4Post("ESD_EAS_0011GS.do", EasFrmQryString(formObj) + '&' + param);
		break;		

	case IBCLEAR: //Clear
		sheetObj.RemoveAll();
		break;

	case IBDOWNEXCEL: //엑셀내려받기		
		sheetObj.SpeedDown2Excel(-1);
		break;

	case IBDELETE:
		sheetObj.RowHidden(sheetObj.SelectRow)= true;		//2.행 숨기기
		sheetObj.RowStatus(sheetObj.SelectRow)= "D";		//3.트랜잭션 상태 "삭제"로 만들기
		
//		ComRowHideDelete(sheetObj, "del");
		break;

	case IBSAVE: //저장
		formObj.is_save.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "ibflag");
		formObj.drff_chg_trf_seq.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "drff_chg_trf_seq");
		formObj.drff_chg_trf_ver_no.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "drff_chg_trf_ver_no");
		formObj.fm_eff_dt.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "fm_eff_dt");
		formObj.to_eff_dt.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "to_eff_dt")
		formObj.f_cmd.value = MULTI;

		for (var i = parseFloat(sheetObject1.HeaderRows); i < parseFloat(sheetObject1.HeaderRows) + parseFloat(sheetObject1.RowCount); i++) {
			sheetObject1.CellValue(i,'curr_cd') = sheetObject1.CellText(i,'curr_cd');
			
			if(sheetObject1.CellValue(i,'curr_list_ctnt') == ''){
				formObj.is_upload.value = 'Y';
			}else{
				formObj.is_upload.value = 'N';				
			}
			
			if(formObj.is_upload.value == 'Y'){
				sheetObject1.CellValue(i,'ibflag') = 'I';		// 파일 업로드시에 Delete하고 Insert한다. 파일 업로드시 모든 Row가 서버로 이동.
			}			
		}
		var param = sheetObject1.GetSaveString();
				
		var savexml = sheetObject1.GetSaveXml("ESD_EAS_0011GS.do",EasFrmQryString(formObj) + '&' + param);		
		sheetObject1.LoadSaveXml(savexml, true);
		break;
	}
}


/**
 * 조회 후 처리
 */
function sheet1_OnSearchEnd(sheetObj, errMsg) {		
	var formObject = document.form;
	var sheetObject1 = sheetObjects[1];

	if(formObject.f_cmd.value == SEARCH11){		//checkRfadata 일 경우
		return;
	}	
	
	formObject.drff_chg_trf_seq.value = sheetObj.CellValue(parseFloat(sheetObj.HeaderRows), "drff_chg_trf_seq");
	formObject.drff_chg_trf_ver_no.value = sheetObj.CellValue(parseFloat(sheetObj.HeaderRows), "drff_chg_trf_ver_no");

//	if (formObject.search_choice[0].checked == true) {
//		ComBtnEnable("btn_UploadExcel");		
//		ComBtnDisable("btn_RowAdd");
//		ComBtnDisable("btn_RowDelete");			
//	} else if (formObject.search_choice[1].checked == true) {		
//		ComBtnEnable("btn_UploadExcel");		
//		ComBtnEnable("btn_RowAdd");
//		ComBtnEnable("btn_RowDelete");		
//	}
	
//	ComBtnDisable("btn_UploadExcel");
//	ComBtnDisable("btn_RowAdd");	
//	ComBtnDisable("btn_RowDelete");

	
	if (sheetObj.RowCount > 0) {
		doActionIBSheet(sheetObject1, formObject, IBSEARCH02);
		if (sheetObject1.RowCount == 0) {
			doActionIBSheet(sheetObject1, formObject, IBSEARCH01); 
		}			
	} else {
		sheetObj.RemoveAll();
	}	
		
	 ComBtnEnable("btn_NewVersion");
	 ComBtnEnable("btn_Revise");	
	 ComBtnEnable("btn_DownExcel");	
	 ComBtnDisable("btn_UploadExcel");	 
	 ComBtnDisable("btn_RowAdd");
	 ComBtnDisable("btn_RowDelete");
	 ComBtnDisable("btn_Save");	
	 
}
 
 
 
 
 /**
  * sheet1 더블 클릭
  */
function sheet1_OnDblClick(sheetObj, Row, Col, Value) {
	var formObject = document.form;
			
	if(!chkOffice2()){
//		alert('User office is different.');
//		return;
	}		
	
	if(sheetObj.CellEditable(Row, Col) == true){
		return;
	}
	
	if(!chkNewVersion(sheetObj)){
//		alert('New Version 상태입니다.\n상세정보가 조회되지 않습니다.')
		return;
	}

	if(!chkRevise(sheetObj)){
//		alert('Revise 상태입니다.\n상세정보가 조회되지 않습니다.')
		return;
	}
		
	if (sheetObj.CellEditable(Row, Col) == false) {
		formObject.drff_chg_trf_seq.value = sheetObj.CellValue(Row,"drff_chg_trf_seq");
		formObject.drff_chg_trf_ver_no.value = sheetObj.CellValue(Row,"drff_chg_trf_ver_no");

		doActionIBSheet(sheetObjects[1], formObject, IBSEARCH02);
		if (document.form.search_choice[0].checked == true) {
			if (sheetObjects[1].RowCount == 0) {
				doActionIBSheet(sheetObjects[1], formObject, IBSEARCH01);
			}
		}
	} else {
//		sheetObjects[1].RemoveAll();
	}
} 
 
 /*
  * Grid에서 말풍선 처리
  */
 function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
 	with (sheetObj) {
 		Row = MouseRow;
 		Col = MouseCol;
 		 		
 		if (Row >= 0) {
 			var ttText = '';
 			var colSaveNm = ColSaveName(Col);
 			
 			if (colSaveNm == 'fm_eff_dt' || (Row == 0 && colSaveNm == 'to_eff_dt') ) { 				
 				var corrRmk = "Based on VL date.";
 				if (corrRmk == '')
 					return;
 				ttText = corrRmk;
 			}
 			MouseToolTipText = ttText;
 		} else {
 			MouseToolTipText = "";
 		}
 	}
 } 
 
/**
* 조회 후 처리
*/
function sheet2_OnSearchEnd(sheetObj, errMsg) {
 	var formObject = document.form; 	
 	for (i = parseFloat(sheetObj.HeaderRows); i < parseFloat(sheetObj.HeaderRows) + parseFloat(sheetObj.RowCount); i++) { 		
 	 	sheetObj.CellComboItem(i,"curr_cd",sheetObj.CellValue(i,'curr_list_ctnt'),sheetObj.CellValue(i,'curr_list_ctnt'));
 	}
 	
 	
//	ComBtnDisable("btn_UploadExcel");				
//	ComBtnDisable("btn_RowAdd");
//	ComBtnDisable("btn_RowDelete");
//	ComBtnDisable("btn_Save");	 	
}

/**
 * 셀의 값이 바뀌었을 때 발생하는 Event
 */
function sheet2_OnChange(sheetObj, Row, Col, Value) {
 	var formObj = document.form;
 	// SCC변경시
	if(Col == 5){
		formObj.scc_cd2.value = sheetObj.CellValue(Row,'scc_cd');
		formObj.f_cmd.value = SEARCH12;		   
		sheetObj.WaitImageVisible = false;		  
		sheetObj.DoSearch4Post("ESD_EAS_0011GS.do", EasFrmQryString(formObj));
		if(sheetObj.EtcData("SCC_YD_CHK") == 'Y'){
//  이 기능 삭제			
//			sheetObj.CellValue2(Row, "port_inlnd_cd") = sheetObj.EtcData("PORT_INLND_CD2");		
			sheetObj.CellComboItem(Row, "curr_cd", sheetObj.EtcData("CURR_LIST_CTNT2"), sheetObj.EtcData("CURR_LIST_CTNT2"));
			sheetObj.CellBackColor(Row,'scc_cd') = sheetObj.RgbColor(192,192,192);
			sheetObj.CellValue(Row,'scc_yd_chk') = 'Y';
		}else{
//			alert("잘못된 SCC_CD("+formObj.scc_cd2.value+")입니다.(SCC_YD_CHK:N)");
//			alert("SCC '"+formObj.scc_cd2.value+"' is wrong.");		
			ComShowCodeMessage('EAS90037', formObj.scc_cd2.value);
			sheetObj.CellBackColor(Row,'scc_cd') = sheetObj.RgbColor(255, 0, 0);	
			sheetObj.CellValue(Row,'scc_yd_chk') = 'N';
		}
		sheetObj.WaitImageVisible = true;
	}

	// All Exempted 변경시
	if(Col == 10){
		if(sheetObj.CellValue(Row,'exp_flg') == 'Y'){
			sheetObj.CellValue2(Row,'d2') = 'E';
			sheetObj.CellValue2(Row,'d4') = 'E';
			sheetObj.CellValue2(Row,'d5') = 'E';
			sheetObj.CellValue2(Row,'r2') = 'E';
			sheetObj.CellValue2(Row,'r5') = 'E';
			sheetObj.CellValue2(Row,'r9') = 'E';
			sheetObj.CellEditable(Row, "d2") = false;
			sheetObj.CellEditable(Row, "d4") = false;
			sheetObj.CellEditable(Row, "d5") = false;
			sheetObj.CellEditable(Row, "r2") = false;
			sheetObj.CellEditable(Row, "r5") = false;
			sheetObj.CellEditable(Row, "r9") = false;
		}else{
			sheetObj.CellValue2(Row,'d2') = '0';
			sheetObj.CellValue2(Row,'d4') = '0';
			sheetObj.CellValue2(Row,'d5') = '0';
			sheetObj.CellValue2(Row,'r2') = '0';
			sheetObj.CellValue2(Row,'r5') = '0';
			sheetObj.CellValue2(Row,'r9') = '0';
			sheetObj.CellEditable(Row, "d2") = true;
			sheetObj.CellEditable(Row, "d4") = true;
			sheetObj.CellEditable(Row, "d5") = true;
			sheetObj.CellEditable(Row, "r2") = true;
			sheetObj.CellEditable(Row, "r5") = true;
			sheetObj.CellEditable(Row, "r9") = true;			
		}
	}
	
	if(Col > 10 && Col <= 16){
		if(sheetObj.CellValue(Row,Col) != 'E'){
			if(isNumber(sheetObj.CellValue(Row,Col))){
				sheetObj.CellValue2(Row,Col) = sheetObj.CellValue(Row,Col)*1;
			}
		}
	}
}  

 /*
  * 저장 후 처리 
  */
 function sheet2_OnSaveEnd(sheetObj, errMsg) {
	var formObject = document.form; 
	if (!validateForm(formObject)) {
		return false;
	}		
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];	
	sheetObject.RemoveAll();	
	sheetObject1.RemoveAll();	
	doActionIBSheet(sheetObject, formObject, IBSEARCH); 	
 } 

/**
* 화면 폼입력값에 대한 유효성검증 프로세스 처리
*/
function validateForm(formObj) {
	var result = true;
	// 검색 조건 입력 여부
	if (!isInputField(formObj)) {
		result = false;
	}
	// 변경여부 확인
	return result;
}

/**
* 화면 폼입력값에 대한 유효성검증 프로세스 처리
*/
function isInputField(formObj) {
	var result = true;

	if (formObj.search_choice[0].checked == true) {	
		if (ComIsEmpty(formObj.cnt_cd)) {
//			alert("Country code is missing.");
			ComShowCodeMessage("EAS90038");
			result = false;			
		}
	}
	
	if (formObj.search_choice[1].checked == true) {	
		if (ComIsEmpty(formObj.rfa_no)) {
//			alert("RFA number is missing.");
			ComShowCodeMessage("EAS90039");
			result = false;			
		}
	}
	
	
//	if (ComIsEmpty(formObj.cnt_cd) && ComIsEmpty(formObj.rfa_no)) {
//		ComShowCodeMessage("EAS90023");
//		result = false;
//	}
	
	return result;
}

//#############################################################################
//#############################################################################
//#############################################################################
/**
* 버튼제어
*/
function initButtonControl() {
	 ComBtnDisable("btn_NewVersion");
	 ComBtnDisable("btn_Revise");	 
	 ComBtnDisable("btn_RowAdd");
	 ComBtnDisable("btn_RowDelete");
	 ComBtnDisable("btn_DownExcel");
	 ComBtnDisable("btn_UploadExcel");
	 ComBtnDisable("btn_Save");
}

/**
* IBSheet Grid의 Revise 버튼 기능을 처리한다.
*/
function processRowUpdate(sheetObj) {
	sheetObj.DataAutoTrim = false;
	sheetObj.CellEditable(sheetObj.SelectRow, "fm_eff_dt") = true;
	sheetObj.CellEditable(sheetObj.SelectRow, "to_eff_dt") = true;
}

/**
* New Version 버튼 검증
*/
function chkNewVersion(sheetObj) {
 	var formObject = document.form;
 	var sw = true;
 	for (var i = parseFloat(sheetObj.HeaderRows); i < parseFloat(sheetObj.HeaderRows) + parseFloat(sheetObj.RowCount); i++) {
 		if(sheetObj.CellValue(i,'drff_chg_trf_ver_no') == ''){
 			sw = false;
 		}
 	} 	 	
// 	if(sw == false){
// 		alert('New Version 상태입니다.');
// 	} 	
 	return sw;
}

/*
 * Revise 버튼 체크
 */
function chkRevise(sheetObj){
 	var formObject = document.form;
 	var sw = true;
 	for (var i = parseFloat(sheetObj.HeaderRows); i < parseFloat(sheetObj.HeaderRows) + parseFloat(sheetObj.RowCount); i++) {
 		if(sheetObj.CellEditable(i,'fm_eff_dt') == true){
 			sw = false;
 		}
 	} 	 	
// 	if(sw == false){
// 		alert('Revise 상태입니다.');
// 	}
 	return sw;	
}

/*
 * rfa_no
 */
function selectWhere() {
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	
	if( document.form.search_choice[0].checked == true ) {		
		document.form.cnt_cd.value = "";
		document.form.cnt_cd.focus();
		document.form.sel_cnt_nm.value = "";
		
		document.form.search_choice[1].checked = false;
		document.form.rfa_no.value = "";
		
//		 ComBtnDisable("btn_RowAdd");
//		 ComBtnDisable("btn_RowDelete");		
	} else if( document.form.search_choice[1].checked == true ) {		
		document.form.rfa_no.value = "";
		document.form.rfa_no.focus();
		
		document.form.search_choice[0].checked = false;
		document.form.cnt_cd.value = "";
		document.form.sel_cnt_nm.value = "";
		
//		 ComBtnEnable("btn_RowAdd");
//		 ComBtnEnable("btn_RowDelete");
	}
	sheetObject.RemoveAll();
	sheetObject1.RemoveAll();	
}

/*
 * rfa_no checkRfadata
 */
function checkRfadata() {	
	var formObj  = document.form;
	var sheetObj = sheetObjects[0];
	
	var doc_rfa = document.form.rfa_no.value.toUpperCase();	
	var checkRfa = '';
		
	if(!ComIsEmpty(doc_rfa)) {			
		formObj.f_cmd.value = SEARCH11;		
		sheetObj.WaitImageVisible = false;	
		sheetObj.DoSearch4Post("ESD_EAS_0011GS.do", EasFrmQryString(formObj));		
		checkRfa = sheetObj.EtcData("rfaChk");
		
		if(checkRfa != 'Y'){
//			alert("RFA does not exist.");
			ComShowCodeMessage("EAS90040");
			document.form.rfa_no.value = "";
		}		
	}			
}

function selectText(obj) {	
	if( obj.name == "cnt_cd" || obj.name == "sel_cnt_nm" ) {
		document.form.search_choice[0].checked = true;
		document.form.search_choice[1].checked = false;		
	}else if( obj.name == "rfa_no") {
		document.form.search_choice[0].checked = false;
		document.form.search_choice[1].checked = true;
	}
	
	selectWhere();
}

 
//############################################################################################################### 
 
 
 /*
 * Save버튼체크
 */
 function chkSave(){
 	var sheetObject = sheetObjects[0];
 	var sheetObject1 = sheetObjects[1];
 	var formObject = document.form;	
 	var sw = true;
 
	if(sheetObject.RowCount == 0){
//		alert("버전 헤더 정보를 입력 해 주세요.");
		sw = false;
	}else{
		var i2 = parseFloat(sheetObject.HeaderRows);	  		
  		if(!chkEffectiveDate(sheetObject.CellValue(i2,'fm_eff_dt'),
  							 sheetObject.CellValue(i2+1,'fm_eff_dt'))){
//  			alert( "마지막날짜는 시작날짜 뒤로 선택하십시오.");
//  			alert("From date must be earlier than To date");  
  			ComShowCodeMessage("EAS90027");
  			sw = false;
  		}  			
	}  	
	  	
	if(sw == true){ 
	  	for (var i = parseFloat(sheetObject.HeaderRows); i < parseFloat(sheetObject.HeaderRows) + parseFloat(sheetObject.RowCount); i++) {
	  		if(sheetObject.CellValue(i,'fm_eff_dt') == ''){
//	  			alert("Please input Effective From date.");
	  			ComShowCodeMessage("EAS90028");
	  			sw = false;
	  		}  		
	  	} 	  	
	}
	
	if(sw == true){	
	 	if(sheetObject1.RowCount == 0){
//	 		alert("Please input detailed information of the 1st version.");
	 		ComShowCodeMessage("EAS90029");
	 		sw = false;
	 	}
	}
	
	if(sw == true){	
	  	for (var i = parseFloat(sheetObject1.HeaderRows); i < parseFloat(sheetObject1.HeaderRows) + parseFloat(sheetObject1.RowCount); i++) {
	  		if(sheetObject1.CellValue(i,'scc_cd') == ''){	  			
	  			sheetObject1.CellBackColor(i,'scc_cd') = sheetObject1.RgbColor(255, 0, 0);
	  			sw = false;
	  		}  	
	  		if(sheetObject1.CellValue(i,'port_inlnd_cd') == ''){	  			
	  			sheetObject1.CellBackColor(i,'port_inlnd_cd') = sheetObject1.RgbColor(255, 0, 0);	  			
	  			sw = false;
	  		}
	  			  		
//	  		if(sheetObject1.CellValue(i,'conti_cd') == ''){	  			
//	  			sheetObject1.CellBackColor(i,'conti_cd') = sheetObject1.RgbColor(255, 0, 0);
//	  			sw = false;
//	  		}  		  		
	  		if(sheetObject1.CellValue(i,'curr_cd') == ''){	  			
	  			sheetObject1.CellBackColor(i,'curr_cd') = sheetObject1.RgbColor(255, 0, 0);
	  			sw = false;
	  		}

	  		if(sheetObject1.CellValue(i,'exp_flg') == ''){	  			
	  			sheetObject1.CellBackColor(i,'exp_flg') = sheetObject1.RgbColor(255, 0, 0);	  			
	  			sw = false;
	  		}  
	  		if(sheetObject1.CellValue(i,'d2') == ''){	  
	  			sheetObject1.CellBackColor(i,'d2') = sheetObject1.RgbColor(255, 0, 0);
	  			sw = false;
	  		}
	  		if(sheetObject1.CellValue(i,'d2') == 'E'){	
	  			sheetObject1.CellValue2(i,'d2') = 0; 
	  		}
	  		if(sheetObject1.CellValue(i,'d4') == ''){
	  			sheetObject1.CellBackColor(i,'d4') = sheetObject1.RgbColor(255, 0, 0);	  			
	  			sw = false;
	  		}  
	  		if(sheetObject1.CellValue(i,'d4') == 'E'){	
	  			sheetObject1.CellValue2(i,'d4') = 0; 
	  		}	  		
	  		if(sheetObject1.CellValue(i,'d5') == ''){	  			
	  			sheetObject1.CellBackColor(i,'d5') = sheetObject1.RgbColor(255, 0, 0);	  			
	  			sw = false;
	  		} 	 
	  		if(sheetObject1.CellValue(i,'d5') == 'E'){	
	  			sheetObject1.CellValue2(i,'d5') = 0; 
	  		}	  	  		
	  		if(sheetObject1.CellValue(i,'r2') == ''){
	  			sheetObject1.CellBackColor(i,'r2') = sheetObject1.RgbColor(255, 0, 0);	  			
	  			sw = false;
	  		} 	
	  		if(sheetObject1.CellValue(i,'r2') == 'E'){	
	  			sheetObject1.CellValue2(i,'r2') = 0; 
	  		}	  	  		
	  		if(sheetObject1.CellValue(i,'r5') == ''){	  			
	  			sheetObject1.CellBackColor(i,'r5') = sheetObject1.RgbColor(255, 0, 0);
	  			sw = false;
	  		}
	  		if(sheetObject1.CellValue(i,'r5') == 'E'){	
	  			sheetObject1.CellValue2(i,'r5') = 0; 
	  		}	  	  		
	  		if(sheetObject1.CellValue(i,'r9') == ''){
	  			sheetObject1.CellBackColor(i,'r9') = sheetObject1.RgbColor(255, 0, 0);	  			
	  			sw = false;
	  		} 	  		
	  		if(sheetObject1.CellValue(i,'r9') == 'E'){	
	  			sheetObject1.CellValue2(i,'r9') = 0; 
	  		}	  	  		
	  	} 
	}

	if(sw == false){
//		alert('필수 입력 항목이 없습니다. 확인 바랍니다.');
//		alert('No rate inputted. Please input.');
		ComShowCodeMessage("EAS90030");
	}
	
 	return sw;
 } 
 
/*
 * Effective Date 날짜 체크
 */ 
function chkEffectiveDate(start_date, end_date){	  
	if( (parseFloat(start_date) - parseFloat(end_date)) < 0 ){
		return false;
	}
	return true;
}
 
/*
 * Office별 권한 체크
 */ 
function chkOffice(){
	var sheetObject = sheetObjects[0];
 	var formObject = document.form;	
 	
 	if(sheetObject.CellValue(sheetObject.SelectRow,'cre_ofc_cd') == formObject.ctrl_ofc_cd.value){ 	 		
 		ComBtnEnable("btn_UploadExcel"); 
 		if (formObject.search_choice[1].checked == true) {
	 		ComBtnEnable("btn_RowAdd");
	 		ComBtnEnable("btn_RowDelete");
 		}
 		ComBtnEnable("btn_Save"); 		
 		
 		return true;
 	}else{ 	 		
 		ComBtnDisable("btn_UploadExcel"); 		
 		ComBtnDisable("btn_RowAdd");
 		ComBtnDisable("btn_RowDelete");
 		ComBtnDisable("btn_Save"); 		
 		
 		return false;
 	}
}

 /*
  * Office별 권한 체크
  */ 
 function chkOffice2(){
 	var sheetObject = sheetObjects[0];
  	var formObject = document.form;	
  	
  	if(sheetObject.CellValue(sheetObject.SelectRow,'cre_ofc_cd') == formObject.ctrl_ofc_cd.value){ 	 		
  		return true;
  	}else{ 	 		
  		return false;
  	}
 } 

/*
 * Cell Control 체크
 */ 
function setCellControl(){
	var sheetObject1 = sheetObjects[1];
		
	for (var i = parseFloat(sheetObject1.HeaderRows); i < parseFloat(sheetObject1.HeaderRows) + parseFloat(sheetObject1.RowCount); i++) {		
		sheetObject1.CellEditable(i, "port_inlnd_cd") = true;	
		sheetObject1.CellEditable(i, "conti_cd") = true;
		sheetObject1.CellEditable(i, "pod_cnt_cd") = true;
		sheetObject1.CellEditable(i, "curr_cd") = true;
		sheetObject1.CellEditable(i, "exp_flg") = true;
		sheetObject1.CellEditable(i, "d2") = true;
		sheetObject1.CellEditable(i, "d4") = true;
		sheetObject1.CellEditable(i, "d5") = true;
		sheetObject1.CellEditable(i, "r2") = true;
		sheetObject1.CellEditable(i, "r5") = true;
		sheetObject1.CellEditable(i, "r9") = true;		
	}
}
 
//##########################################################################################################
 
 /** excel 로드
  * 
  * @param sheetObj
  * @return
  */
 function sheet2_OnLoadExcel(sheetObj){	
 	moveSheetLoad(); 	
 } 
  
//###############################################################################################################
           
  /** 
  * Upload 전에 임시로 원본을 옮겨놓는다.
  * 
  * @param 
  * @return
  */ 
 function moveSheet13Load(){
	var formObject = document.form;	
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	var sheetObject2 = sheetObjects[2];
		
	sheetObject2.RemoveAll();
	
	if (formObject.search_choice[0].checked == true) {
		sheetObject1.RemoveAll();	
	
		formObject.drff_chg_trf_ver_no.value = '';					// New Version 초기화
		formObject.f_cmd.value = SEARCH01;
		
		sheetObject2.DoSearch4Post("ESD_EAS_0011GS.do", EasFrmQryString(formObject));		
		  	
	} else if (formObject.search_choice[1].checked == true) {
		sheetObject1.RemoveAll();		
	}	
 	sheetObject1.LoadExcel(-1,1,"","-1","-1","",false,false,"");    
 }  
  
  /** 
  * Upload 전에 임시로 원본을 옮겨놓는다.
  * 
  * @param 
  * @return
  */ 
 function moveSheet13(){	 	    
 }  
 
 /*
  * moveSheetLoad
  */
 function moveSheetLoad(){
 	var formObject = document.form;
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	var sheetObject2 = sheetObjects[2];
 	
 	if(formObject.search_choice[1].checked == true){
 	 	sheetObject2.RemoveAll(); 		

 	 	for (var m = parseFloat(sheetObject1.HeaderRows); m < parseFloat(sheetObject1.HeaderRows) + parseFloat(sheetObject1.RowCount); m++) {
 	 		var newRow = sheetObject2.DataInsert(0);
 	 		sheetObject2.CellValue(newRow,'scc_cd') = sheetObject1.CellValue(m,'scc_cd');  
 	 	}
 	
 		// RFA일 경우
 		doActionIBSheet(sheetObject2, formObject, IBSEARCH13);
 		return;
 	}	
 }
  
//********************************************************************************************************************************
 
/*
 * Upload시 체크
 */
function chkUpload(){
	var sw = true;

	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	var sheetObject2 = sheetObjects[2];
		
	var tmpSccCd1		= '';
	var tmpSccCd3		= '';	
	var tmpSccCd		= '';
	var tmpPortInlndCd 	= '';	// port_inlnd_cd
	var tmpContiCd		= '';	// conti_cd
	var tmpPodCntCd		= '';	// pod_cnt_cd
	var tmpCurrCd 		= '';	// curr_cd
	var tmpExpFlg		= '';	// exp_flg
	var tmpD2			= '';	//	d2
	var tmpD4			= '';	//	d4
	var tmpD5			= '';	//	d5
	var tmpR2			= '';	//	r2
	var tmpR5			= '';	//	r5
	var tmpR9			= '';	//	r9
	 		
 	for (var i = parseFloat(sheetObject1.HeaderRows); i < parseFloat(sheetObject1.HeaderRows) + parseFloat(sheetObject1.RowCount); i++) {
 		
		tmpSccCd		= sheetObject1.CellText(i,'scc_cd').toUpperCase(); 	
		tmpPortInlndCd	= sheetObject1.CellText(i,'port_inlnd_cd').toUpperCase();
		tmpContiCd 		= sheetObject1.CellText(i,'conti_cd').toUpperCase();
		tmpPodCntCd 	= sheetObject1.CellText(i,'pod_cnt_cd').toUpperCase(); 	
		tmpCurrCd 		= sheetObject1.CellText(i,'curr_cd').toUpperCase();
		tmpCurrListCtnt	= sheetObject1.CellText(i,'curr_list_ctnt').toUpperCase(); 			
		tmpExpFlg 		= sheetObject1.CellText(i,'exp_flg').toUpperCase();
		tmpD2 		= sheetObject1.CellText(i,'d2');
		tmpD4 		= sheetObject1.CellText(i,'d4');
		tmpD5 		= sheetObject1.CellText(i,'d5');
		tmpR2 		= sheetObject1.CellText(i,'r2');
		tmpR5 		= sheetObject1.CellText(i,'r5'); 			
 			 			
 		// Port/Inland 체크 		 			
			if(!(tmpPortInlndCd == 'Inland'.toUpperCase() || tmpPortInlndCd == 'Port Area'.toUpperCase())){
 				sheetObject1.CellBackColor(i,'port_inlnd_cd') = sheetObject1.RgbColor(255, 0, 0);
 				sw = false;
			}
 				 			
 		// Origin Contet 체크 		
//			if(!(tmpContiCd == '' || tmpContiCd == 'Africa'.toUpperCase() || tmpContiCd == 'America'.toUpperCase() || 
//				 tmpContiCd == 'Asia'.toUpperCase() || tmpContiCd == 'Europe'.toUpperCase() )){
// 				sheetObject1.CellBackColor(i,'conti_cd') = sheetObject1.RgbColor(255, 0, 0);
// 				sw = false;
// 			}
				 			
 		// POD Country 체크									
 			if(!checkPodCountry(tmpPodCntCd)){
 				sheetObject1.CellBackColor(i,'pod_cnt_cd') = sheetObject1.RgbColor(255, 0, 0); 
 				sw = false;
 			}
 		
 		// Curr_cd 체크
			if(!checkCurCd(tmpSccCd,tmpCurrCd, tmpCurrListCtnt)){
 				sheetObject1.CellBackColor(i,'curr_cd') = sheetObject1.RgbColor(255, 0, 0); 	
 				sw = false;
 			}
 	 		
 		// All Exempted 체크			
			if(!(tmpExpFlg.toUpperCase() == 'Y' || tmpExpFlg.toUpperCase() == 'N')){
 				sheetObject1.CellBackColor(i,'exp_flg') = sheetObject1.RgbColor(255, 0, 0);
 				sw = false;
 			}			
			
 		
 		// D2 체크
		if(tmpD2 != 'E'){
			if(check1000Value(tmpD2)){
				if(!checkRate2(tmpD2)){
					sheetObject1.CellBackColor(i,'d2') = sheetObject1.RgbColor(255, 0, 0);
	 				sw = false;
				}
			}else{
 				sheetObject1.CellBackColor(i,'d2') = sheetObject1.RgbColor(255, 0, 0);		
 				sw = false;
			}
		}
 		// D4 체크
		if(tmpD4 != 'E'){
			if(check1000Value(tmpD4)){
				if(!checkRate2(tmpD4)){
					sheetObject1.CellBackColor(i,'d4') = sheetObject1.RgbColor(255, 0, 0);
	 				sw = false;
				}
			}else{
 				sheetObject1.CellBackColor(i,'d4') = sheetObject1.RgbColor(255, 0, 0);	
 				sw = false;
			}
		} 		
 		// D5 체크
		if(tmpD5 != 'E'){
			if(check1000Value(tmpD5)){
				if(!checkRate2(tmpD5)){
					sheetObject1.CellBackColor(i,'d5') = sheetObject1.RgbColor(255, 0, 0);
	 				sw = false;
				}
			}else{
 				sheetObject1.CellBackColor(i,'d5') = sheetObject1.RgbColor(255, 0, 0);		
 				sw = false;
			}
		} 		
 		// R2 체크
		if(tmpR2 != 'E'){
			if(check1000Value(tmpR2)){
				if(!checkRate2(tmpR2)){
					sheetObject1.CellBackColor(i,'r2') = sheetObject1.RgbColor(255, 0, 0);
	 				sw = false;
				}
			}else{
 				sheetObject1.CellBackColor(i,'r2') = sheetObject1.RgbColor(255, 0, 0);	
 				sw = false;
			}
		} 		
 		// R5 체크
		if(tmpR5 != 'E'){
			if(check1000Value(tmpR5)){
				if(!checkRate2(tmpR5)){
					sheetObject1.CellBackColor(i,'r5') = sheetObject1.RgbColor(255, 0, 0);
	 				sw = false;
				}
			}else{
 				sheetObject1.CellBackColor(i,'r5') = sheetObject1.RgbColor(255, 0, 0);		
 				sw = false;
			}
		} 		
 		// R9 체크
		if(tmpR9 != 'E'){
			if(check1000Value(tmpR9)){
				if(!checkRate2(tmpR9)){
					sheetObject1.CellBackColor(i,'r9') = sheetObject1.RgbColor(255, 0, 0);
	 				sw = false;
				}
			}else{
 				sheetObject1.CellBackColor(i,'r9') = sheetObject1.RgbColor(255, 0, 0);	
 				sw = false;
			}
		} 		 		 		
 	} 		
 
 	if(sw == false){
// 		alert('Excel로 Upload한 데이터가 잘  못 되어 있습니다.');
 	}
 	return sw;
}

/*
 * 소수점 2자리 체크
 */
function checkRate2(strValue)
{
    var digitStr = "01234567890.,-";
    var isOK = true;
    var firstDotPos;
    var numUnderDotStr;

    // 숫자 . ,만으로 되어있는지 체크
    for (var i=0; i<strValue.length; i++) {
        if (digitStr.indexOf(strValue.charAt(i)) == -1) {
            isOK = false;
        }
    }

    // 소수점이 하나만 있는지 체크
    firstDot = strValue.indexOf(".");
    if (firstDot != -1) { // 소수점이 하나이상 존재
        if (strValue.indexOf(".", firstDot+1) != -1) { // 소수점이 두개이상 존재
            isOK = false;
        } else {
            numUnderDotStr = strValue.substr(firstDot+1);
            if (numUnderDotStr.length > 2) { // 소수점 아래 숫자가 3개 이상이면
                isOK = false;
            }
        }
    }

    if (isOK == false) {
        return false;
    }

    return true;
}

/*
 * 1000자리체크
 */
function check1000Value(strValue) {
  var strValue2 = strValue;	 
  strValue = strValue.split(',').join('');
  
  if(strValue2 == strValue){
	  return true;
  }
  
  var reg = /(^[+-]?\d+)(\d{3})/;   // 정규식

  while (reg.test(strValue))
	  strValue = strValue.replace(reg, '$1' + ',' + '$2');
  
  if(strValue2 == strValue){
	  return true;
  }else{
	  return false;
  }
}

/*
 * Pod Country 검증
 */ 
function checkPodCountry(pod){
	var sw = false;
//	var podCountry = "ALBANIA|ANDORRA|ARMENIA|AUSTRIA|Azerbaijan|BELARUS|BELGIUM|BULGARIA|Bosnia and Herzegovina|CROATIA|CYPRUS|CZECH REPUBLIC|" +
//			  		 "DENMARK|ESTONIA|EUROPEAN COMMUNITY|FAROE ISLANDS|FINLAND|FRANCE|GEORGIA|GERMANY|GIBRALTAR|GREECE|GREENLAND|HUNGARY|" +
//			  		 "Holy See (Vatican City State)|ICELAND|IRELAND|ISEL OF MAN|ISRAEL|ITALY|KAZAKHSTAN|KYRGYZSTAN|LATVIA|LEBANON|LIECHTENSTEIN|" +
//			  		 "LITHUANIA|LUXEMBOURG|MALTA|MONACO|MONTENEGRO|Macedonia, The former Yugoslav Republic of|Moldova, Republic of|NETHERLANDS|NORWAY|" +
//			  		 "POLAND|PORTUGAL|REPUBLIC OF KOSOVO|REPUBLIC OF SERBIA|ROMANIA|RUSSIAN FEDERATION|SAN MARINO|SLOVAKIA|SLOVENIA|SPAIN|SWEDEN|" +
//			  		 "SWITZERLAND|SYRIAN ARAB REPUBLIC|Serbia and Montenegro|TURKEY|UKRAINE|United Kingdom|YUGOSLAVIA";
//	
//	var podArray = podCountry.split('|');
//	
//	for(var i=0; i<podArray.length; i++){
//		if(podArray[i].toUpperCase() == pod.toUpperCase()){
//			sw = true;
//		}
//	}
	
	sw = true;
	return sw;
}

/*
 * Curr Cd 검증
 */
function checkCurCd(tmpSccCd, tmpCurrCd, tmpCurrListCtnt){ 
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	var sheetObject2 = sheetObjects[2];	
				
	if(parseFloat(sheetObject2.RowCount) > 0){
		if(tmpCurrListCtnt == ''){	 
			tmpCurrListCtnt = sheetObject2.CellValue(sheetObject2.FindText('scc_cd', tmpSccCd, 0),'curr_list_ctnt');
		}
	}else{
		return true;		// row add인경우, curr_list_ctnt가 없음.
	}
	 
	var sw = false;	
	var curArray = tmpCurrListCtnt.split('|');
	
	for(var i=0; i<curArray.length; i++){		
		if(curArray[i].toUpperCase() == tmpCurrCd.toUpperCase()){
			sw = true;
		}
	}	
	return sw;
}
 
 
/*
 * SCC 존재 여부 검사
 */
function chkSccCd(){
	var sheetObject1 = sheetObjects[1];
	var sheetObject2 = sheetObjects[2];
	var sw = true;
	
	if(sheetObject2.RowCount == 0){
		return true;
	}
	
	if(parseFloat(sheetObject2.RowCount) != parseFloat(sheetObject1.RowCount)){
//		alert('업로드 엑셀 자료의 SCC Code개수가 잘 못 되어 있습니다.');
//		alert('Wrong SCC code is found.[2]');		
		ComShowCodeMessage("EAS90031");
		return false;
	}

 	for (var i = parseFloat(sheetObject1.HeaderRows); i < parseFloat(sheetObject1.HeaderRows) + parseFloat(sheetObject1.RowCount); i++) {
 		for (var j = parseFloat(sheetObject2.HeaderRows); j < parseFloat(sheetObject2.HeaderRows) + parseFloat(sheetObject2.RowCount); j++) {
 	 		if( sheetObject1.CellValue(i,'scc_cd') == sheetObject2.CellValue(j,'scc_cd')){
 	 			sheetObject1.CellValue(i,'scc_dup_chk') = 'Y';
 	 		}
 		}  
 	}	 

 	for (var k = parseFloat(sheetObject1.HeaderRows); k < parseFloat(sheetObject1.HeaderRows) + parseFloat(sheetObject1.RowCount); k++) { 	
 		if(sheetObject1.CellValue(k,'scc_dup_chk') != 'Y'){ 			 		
 			sheetObject1.CellBackColor(k,'scc_cd') = sheetObject1.RgbColor(255, 0, 0);	 		
 			sw = false;
 		}
 	}
 	
 	if(sw == false){ 	
// 		alert('업로드 엑셀 자료의 SCC Code에서 잘 못 된게 있습니다.');
//		alert('Wrong SCC code is found.[3]');
 		ComShowCodeMessage("EAS90032");
 	}
 	return sw;
}
 
/*
 * RFA시에 SCC 검증
 */
function chkSccCdYn(){
	var formObject = document.form;		 
	var sheetObject1 = sheetObjects[1];
	var sheetObject2 = sheetObjects[2];
	var sw = true;	 
 
	if(sheetObject2.RowCount == 0){
		return true;
	}
	
	if (formObject.search_choice[1].checked == true) {	
	 	for (var k = parseFloat(sheetObject2.HeaderRows); k < parseFloat(sheetObject2.HeaderRows) + parseFloat(sheetObject2.RowCount); k++) { 	
	 		if(sheetObject2.CellValue(k,'scc_yd_chk') != 'Y'){ 			 			 		
	 			sw = false;
	 		}
	 	}
	 	
	 	if(sw == false){
//	 		alert('업로드 엑셀 자료에 잘 못 된 SCC Code가 있습니다.');
//	 		alert('Wrong SCC code is found.[4]');
			ComShowCodeMessage("EAS90033");	 		
	 	}
	}
 	return sw;	
}

 /*
  * RFA Row Add시에 SCC 검증
  */ 
function chkSccYdChkRowAdd(){
	var formObject = document.form;		 
	var sheetObject1 = sheetObjects[1];
	var sw = true;	 	

	if (formObject.search_choice[1].checked == true) {	
	 	for (var k = parseFloat(sheetObject1.HeaderRows); k < parseFloat(sheetObject1.HeaderRows) + parseFloat(sheetObject1.RowCount); k++) { 	
	 		if(sheetObject1.CellValue(k,'scc_yd_chk') == 'N'){ 			 			 		
	 			sw = false;
	 		}
	 	}
	 	
	 	if(sw == false){
//	 		alert('잘 못 된 SCC Code가 있습니다.');
//	 		alert('Wrong SCC code is found.[5]');	 
			ComShowCodeMessage("EAS90034");
	 	}
	}
 	return sw;	
}
  
 
/*
 * Port인 경우는 data handling을 불허함과 동시에,system이 자동으로 All Exempted "Y"와 모든 Rate "E"로 처리하고 회색으로 동결
 * 이 기능 삭제
 */
// function setPortAllExempted(){
// 	var sheetObject = sheetObjects[0];
// 	var sheetObject1 = sheetObjects[1];
// 	var formObject = document.form;	
// 	var sw = true;
// 	
//	if (formObject.search_choice[1].checked == true) {
//		return sw;
//	}	 
//	
//  	for (var i = parseFloat(sheetObject1.HeaderRows); i < parseFloat(sheetObject1.HeaderRows) + parseFloat(sheetObject1.RowCount); i++) {
// 		if(sheetObject1.CellValue(i,'port_inlnd_cd') == 'Y'){ 
//  			
//  			sheetObject1.CellValue(i,'exp_flg') = 'Y';
//  			sheetObject1.CellEditable(i, "exp_flg") = false;
//  			sheetObject1.CellEditable(i, "d2") = false;
//  			sheetObject1.CellEditable(i, "d4") = false;
//  			sheetObject1.CellEditable(i, "d5") = false;
//  			sheetObject1.CellEditable(i, "r2") = false;
//  			sheetObject1.CellEditable(i, "r5") = false;
//  			sheetObject1.CellEditable(i, "r9") = false;
//  		}
//	}		
// }
 
 /*
  * 중복여부 검사 
  */
 function chkSccCdDup(){
 	var sheetObject1 = sheetObjects[1];	 
 	var arr_rows = null;
 	var rowDup = sheetObject1.ColValueDupRows('scc_cd',false);
 		


 	var sheetObject1 = sheetObjects[1];	 
 	var arr_rows = null;
 	var formObject = document.form;
 	var rowDup = sheetObject1.ColValueDupRows('scc_cd',false);
 	var sw = true;
	var tmpSccCd		= '';
	var tmpContiCd		= '';	// conti_cd
	var tmpPodCntCd		= '';	// pod_cnt_cd
	var tmpSccCd2		= '';
	var tmpContiCd2		= '';	// conti_cd
	var tmpPodCntCd2	= '';	// pod_cnt_cd
 	  		
	if(formObject.search_choice[0].checked == true){		
	 	if (rowDup!=null && rowDup.trim()!=''){
	 		arr_rows = rowDup.split(',');
	 		
	 		for (var i=0; arr_rows!=null && i<arr_rows.length; i++){
	 			sheetObject1.CellBackColor(arr_rows[i],'scc_cd') = sheetObject1.RgbColor(255, 0, 0);
	 	    }		
	 		return false;
	 	}else{
	 		return true;
	 	}	
			
	}else if(formObject.search_choice[1].checked == true){	
	 	if (rowDup === null || rowDup.trim() == ''){	
			return true;
		} 	
	 	
	  	for (var i = parseFloat(sheetObject1.HeaderRows); i < parseFloat(sheetObject1.HeaderRows) + parseFloat(sheetObject1.RowCount); i++) {
	  		tmpSccCd		= sheetObject1.CellText(i,'scc_cd').trim().toUpperCase(); 	
			tmpContiCd 		= sheetObject1.CellText(i,'conti_cd').trim().toUpperCase();
			tmpPodCntCd 	= sheetObject1.CellText(i,'pod_cnt_cd').trim().toUpperCase();
		  	for (var j = parseFloat(sheetObject1.HeaderRows); j < parseFloat(sheetObject1.HeaderRows) + parseFloat(sheetObject1.RowCount); j++) {
		  		if(i!=j){	  	
			  		tmpSccCd2		= sheetObject1.CellText(j,'scc_cd').trim().toUpperCase(); 	
					tmpContiCd2 	= sheetObject1.CellText(j,'conti_cd').trim().toUpperCase();
					tmpPodCntCd2 	= sheetObject1.CellText(j,'pod_cnt_cd').trim().toUpperCase();
			  		
					if(tmpSccCd+tmpContiCd+tmpPodCntCd != ''){					
						if(tmpSccCd+tmpContiCd+tmpPodCntCd == tmpSccCd2+tmpContiCd2+tmpPodCntCd2){
							sheetObject1.CellBackColor(i,'scc_cd') = sheetObject1.RgbColor(255, 0, 0);
							sheetObject1.CellBackColor(i,'conti_cd') = sheetObject1.RgbColor(255, 0, 0);
							sheetObject1.CellBackColor(i,'pod_cnt_cd') = sheetObject1.RgbColor(255, 0, 0);
							sw = false;
						}
					}
		  		}
		  	}
	  	}  	  	  	
	}
  	return sw;
 }
  
  /*
   * Save시에 Port시에 All Exempted Y/N과 우측의 Rate 입력여부와 비교 checking 
   * 이 기능 삭제
   */  
//   function chkAllExemptedPort(){
//   	var sheetObject = sheetObjects[0];
//   	var sheetObject1 = sheetObjects[1];
//   	var formObject = document.form;	
//   	var sw = true;
//   	
//   	// Country일경우에 
//  	if (formObject.search_choice[1].checked == true) {
//  		return sw;
//  	}
//  		
//	for (var i = parseFloat(sheetObject1.HeaderRows); i < parseFloat(sheetObject1.HeaderRows) + parseFloat(sheetObject1.RowCount); i++) {		    		
//		if(sheetObject1.CellValue(i,'port_inlnd_cd').trim() == 'Y'){  		  		    		
//			if((sheetObject1.CellValue(i,'exp_flg').trim()+
//				sheetObject1.CellValue(i,'d2')+sheetObject1.CellValue(i,'d4')+sheetObject1.CellValue(i,'d5')+
//			    sheetObject1.CellValue(i,'r2')+sheetObject1.CellValue(i,'r5')+sheetObject1.CellValue(i,'r9')) != 'YEEEEEE'){  
//
//				 sheetObject1.CellBackColor(i,'port_inlnd_cd') = sheetObject1.RgbColor(255, 0, 0);    			
//				 sheetObject1.CellBackColor(i,'exp_flg') = sheetObject1.RgbColor(255, 0, 0);
//				 sheetObject1.CellBackColor(i,'d2') = sheetObject1.RgbColor(255, 0, 0);
//				 sheetObject1.CellBackColor(i,'d4') = sheetObject1.RgbColor(255, 0, 0);
//				 sheetObject1.CellBackColor(i,'d5') = sheetObject1.RgbColor(255, 0, 0);
//				 sheetObject1.CellBackColor(i,'r2') = sheetObject1.RgbColor(255, 0, 0);
//				 sheetObject1.CellBackColor(i,'r5') = sheetObject1.RgbColor(255, 0, 0);
//				 sheetObject1.CellBackColor(i,'r9') = sheetObject1.RgbColor(255, 0, 0);
//				 sw = false;
//			} 
//		}
//	}	 
//    		
//  	if(sw == false){
//  		alert("Only when All Exempted is 'Y', all of the rates should be 'E'.");
//  	}  	
//    	
//  	return sw;
//   }  
   
   
   /*
    * Save시에 All Exempted Y/N과 우측의 Rate 입력여부와 비교 checking 
    */  
function chkAllExempted(){
    	var sheetObject = sheetObjects[0];
    	var sheetObject1 = sheetObjects[1];
    	var formObject = document.form;	
    	var sw = true;    	
       	var d2 = '';
       	var d4 = '';
       	var d5 = '';
       	var r2 = '';
       	var r5 = '';
       	var r9 = '';    	
    	
//   	if (formObject.search_choice[1].checked == true) {
//   		return sw;
//   	}
    	       		
     	for (var i = parseFloat(sheetObject1.HeaderRows); i < parseFloat(sheetObject1.HeaderRows) + parseFloat(sheetObject1.RowCount); i++) {     		     	
        	if(sheetObject1.CellValue(i,'d2').trim() == '0' || sheetObject1.CellValue(i,'d2').trim() == '0.0' || sheetObject1.CellValue(i,'d2').trim() == '0.00'){
        		d2 = 'E';	
        	}else{
        		d2 = sheetObject1.CellValue(i,'d2').trim();
        	}
        	if(sheetObject1.CellValue(i,'d4').trim() == '0' || sheetObject1.CellValue(i,'d4').trim() == '0.0' || sheetObject1.CellValue(i,'d4').trim() == '0.00'){
        		d4 = 'E';	
        	}else{
        		d4 = sheetObject1.CellValue(i,'d4').trim();
        	}
        	if(sheetObject1.CellValue(i,'d5') == '0' || sheetObject1.CellValue(i,'d5').trim() == '0.0' || sheetObject1.CellValue(i,'d5').trim() == '0.00'){
        		d5 = 'E';	
        	}else{
        		d5 = sheetObject1.CellValue(i,'d5');
        	}
        	if(sheetObject1.CellValue(i,'r2').trim() == '0' || sheetObject1.CellValue(i,'r2').trim() == '0.0' || sheetObject1.CellValue(i,'r2').trim() == '0.00'){
        		r2 = 'E';	
        	}else{
        		r2 = sheetObject1.CellValue(i,'r2').trim();
        	}
        	if(sheetObject1.CellValue(i,'r5').trim() == '0' || sheetObject1.CellValue(i,'r5').trim() == '0.0' || sheetObject1.CellValue(i,'r5').trim() == '0.00'){
        		r5 = 'E';	
        	}else{
        		r5 = sheetObject1.CellValue(i,'r5').trim();
        	}
        	if(sheetObject1.CellValue(i,'r9').trim() == '0' || sheetObject1.CellValue(i,'r9').trim() == '0.0' || sheetObject1.CellValue(i,'r9').trim() == '0.00'){
        		r9 = 'E';	
        	}else{
        		r9 = sheetObject1.CellValue(i,'r9').trim();
        	}    		
     		     	               		
     		if(sheetObject1.CellValue(i,'exp_flg').trim() == 'Y'){        		     		
   	    		if((d2.toUpperCase()+d4.toUpperCase()+d5.toUpperCase()+
     	       		r2.toUpperCase()+r5.toUpperCase()+r9.toUpperCase()) != 'EEEEEE'){     				
   	    			
     				 sheetObject1.CellBackColor(i,'exp_flg') = sheetObject1.RgbColor(255, 0, 0);
     				 sheetObject1.CellBackColor(i,'d2') = sheetObject1.RgbColor(255, 0, 0);
     				 sheetObject1.CellBackColor(i,'d4') = sheetObject1.RgbColor(255, 0, 0);
     				 sheetObject1.CellBackColor(i,'d5') = sheetObject1.RgbColor(255, 0, 0);
     				 sheetObject1.CellBackColor(i,'r2') = sheetObject1.RgbColor(255, 0, 0);
     				 sheetObject1.CellBackColor(i,'r5') = sheetObject1.RgbColor(255, 0, 0);
     				 sheetObject1.CellBackColor(i,'r9') = sheetObject1.RgbColor(255, 0, 0);
     				 sw = false;
     			} 
     		}
     	}	 
     	
   	if(sw == false){
//   		alert("When All Exempted is 'Y', all of the rates should be 'E'.");
   		ComShowCodeMessage("EAS90035");
   	}  	
     	
   	return sw;
}
   
   
   /*
   * Save시에 All Exempted Y/N과 우측의 Rate 입력여부와 비교 checking 
   */  
function chkAllExempted2(){
   	var sheetObject = sheetObjects[0];
   	var sheetObject1 = sheetObjects[1];
   	var formObject = document.form;	
   	var sw = true;
   	var d2 = '';
   	var d4 = '';
   	var d5 = '';
   	var r2 = '';
   	var r5 = '';
   	var r9 = '';
   	
//  	if (formObject.search_choice[1].checked == true) {
//  		return sw;
//  	}
  		
    for (var i = parseFloat(sheetObject1.HeaderRows); i < parseFloat(sheetObject1.HeaderRows) + parseFloat(sheetObject1.RowCount); i++) {
    		
    	if(sheetObject1.CellValue(i,'d2').trim() == '0' || sheetObject1.CellValue(i,'d2').trim() == '0.0' || sheetObject1.CellValue(i,'d2').trim() == '0.00'){
    		d2 = 'E';	
    	}else{
    		d2 = sheetObject1.CellValue(i,'d2').trim();
    	}
    	if(sheetObject1.CellValue(i,'d4').trim() == '0' || sheetObject1.CellValue(i,'d4').trim() == '0.0' || sheetObject1.CellValue(i,'d4').trim() == '0.00'){
    		d4 = 'E';	
    	}else{
    		d4 = sheetObject1.CellValue(i,'d4').trim();
    	}
    	if(sheetObject1.CellValue(i,'d5') == '0' || sheetObject1.CellValue(i,'d5').trim() == '0.0' || sheetObject1.CellValue(i,'d5').trim() == '0.00'){
    		d5 = 'E';	
    	}else{
    		d5 = sheetObject1.CellValue(i,'d5');
    	}
    	if(sheetObject1.CellValue(i,'r2').trim() == '0' || sheetObject1.CellValue(i,'r2').trim() == '0.0' || sheetObject1.CellValue(i,'r2').trim() == '0.00'){
    		r2 = 'E';	
    	}else{
    		r2 = sheetObject1.CellValue(i,'r2').trim();
    	}
    	if(sheetObject1.CellValue(i,'r5').trim() == '0' || sheetObject1.CellValue(i,'r5').trim() == '0.0' || sheetObject1.CellValue(i,'r5').trim() == '0.00'){
    		r5 = 'E';	
    	}else{
    		r5 = sheetObject1.CellValue(i,'r5').trim();
    	}
    	if(sheetObject1.CellValue(i,'r9').trim() == '0' || sheetObject1.CellValue(i,'r9').trim() == '0.0' || sheetObject1.CellValue(i,'r9').trim() == '0.00'){
    		r9 = 'E';	
    	}else{
    		r9 = sheetObject1.CellValue(i,'r9').trim();
    	}  
    	    	
    	if(sheetObject1.CellValue(i,'exp_flg').trim() == 'N'){      		    	
    		if((d2.toUpperCase()+d4.toUpperCase()+d5.toUpperCase()+
    			r2.toUpperCase()+r5.toUpperCase()+r9.toUpperCase()) == 'EEEEEE'){
    			 sheetObject1.CellBackColor(i,'exp_flg') = sheetObject1.RgbColor(255, 0, 0);
    			 sheetObject1.CellBackColor(i,'d2') = sheetObject1.RgbColor(255, 0, 0);
    			 sheetObject1.CellBackColor(i,'d4') = sheetObject1.RgbColor(255, 0, 0);
    			 sheetObject1.CellBackColor(i,'d5') = sheetObject1.RgbColor(255, 0, 0);
    			 sheetObject1.CellBackColor(i,'r2') = sheetObject1.RgbColor(255, 0, 0);
    			 sheetObject1.CellBackColor(i,'r5') = sheetObject1.RgbColor(255, 0, 0);
    			 sheetObject1.CellBackColor(i,'r9') = sheetObject1.RgbColor(255, 0, 0);
    			 sw = false;
    		} 
    	}
  	}	 
    	
  	if(sw == false){
//  	alert("When All Exempted is 'N', one of the rate should not be 'E'.");
  		ComShowCodeMessage("EAS90036");
  	}  	
    	
  	return sw;
}   
   

/*
 * 문자/숫자 구분
 */   
function isNumber(s) {
   s += ''; // 문자열로 변환
   s = s.replace(/^\s*|\s*$/g, ''); // 좌우 공백 제거
   if (s == '' || isNaN(s)) return false;
   return true;
}   