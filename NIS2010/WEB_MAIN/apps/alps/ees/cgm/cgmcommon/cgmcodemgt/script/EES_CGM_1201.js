/*=========================================================
 *Copyright(c) 2013 CyberLogitec
 *@FileName : EES_CGM_1201.js
 *@FileTitle : Exception List Creation and Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.03.08
 *@LastModifier : 이영헌
 *@LastVersion : 1.0
 * 2013.03.08 이영헌
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
 * @class ees_cgm_1201 : ees_cgm_1201 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ees_cgm_1201() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject     = setSheetObject;
	this.loadPage           = loadPage;
	this.initSheet          = initSheet;
	this.initControl        = initControl;
	this.doActionIBSheet    = doActionIBSheet;
	this.setTabObject       = setTabObject;
	this.validateForm       = validateForm;
}

/* 개발자 작업 */

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt     = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	var sheetObj    = sheetObjects[0];

	/*******************************************************/
	var formObj = document.form;
	var change = 0;
    var sheet1RowCnt = sheetObjects[0].RowCount;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
			case "btns_calendar1": //달력버튼
				var cal = new ComCalendar();
				cal.setDisplayType('month');
				cal.select(formObj.eff_yrmon, 'yyyy-MM');           	 
				break;
			case "btn_retrieve":
				// IBSHEET 조회
				if(validateForm(sheetObjects[0],formObj,srcName)){
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
				}
				break;
	
			case "btn_new":
				//초기화 함수 호출
				objectClear();
				break;
				
			case "btn_save":
				for(var i=1; i <= sheet1RowCnt; i++) {
					if(sheetObj.CellValue(i,"ibflag")!='I' && sheetObj.CellValue(i,"ibflag")!='U' && sheetObj.CellValue(i,"ibflag")!='D'){
						change = change+1;
					}
				}
				if(change == sheet1RowCnt){
					ComShowMessage("Data was not changed!");
					break;
				}
				ComOpenWait(true);
				if(ComShowCodeConfirm('CGM10047')){
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
				}
				ComOpenWait(false);
				break;
				
			case "btn_RowAdd":
				sheetObj.DataInsert(-1);
				break;
				
			case "btn_RowDel":
				if(sheetObj.FindCheckedRow("del_chk") == ""){
					ComShowMessage("You did'nt check any Rows!");
				}else if(ComShowConfirm('Do you want to delete it?')){
					doActionIBSheet(sheetObj, formObj, IBDELETE);
				}
				break;
				
			case "btn_downexcel":
				doActionIBSheet(sheetObjects[0],document.form,"btn_downexcel","","");
				break;
				
			case "btn_loadexcel":
				ComShowMessage("Excel data can be loaded less than or equal to 400.");
				doActionIBSheet(sheetObjects[0],document.form,"btn_loadexcel");
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
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}


/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		// 시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		// 마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
}
 
//Axon 이벤트 처리
function initControl() {
	var formObj = document.form;
	
	axon_event.addListenerFormat('beforedeactivate',    'obj_blur',     form);   //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	axon_event.addListenerFormat('focus',   'obj_focus',    form);   //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	axon_event.addListenerFormat('keydown',	'obj_keydown',	form);   //- 키 눌렸을때
	axon_event.addListenerFormat('keyup',	'obj_keyup',	form);   //- 키 눌렸을때
	axon_event.addListenerFormat('keypress','obj_keypress',	form);   //- 키 눌렸을때 
	
	formObj.eff_yrmon.focus();
}

//Axon 이벤트 처리2. 이벤트처리함수
function obj_blur(){
	var formObj = document.form;
	var obj = event.srcElement;
	
    if (event.srcElement.name == "eff_yrmon"){
   		ComAddSeparator(formObj.eff_yrmon, "ym");
    }
}

//Axon 이벤트 처리2. 이벤트처리함수
function obj_focus(){
	var formObj = document.form;
	var obj = event.srcElement;
	
    if (event.srcElement.name == "eff_yrmon"){		
    	ComClearSeparator(formObj.eff_yrmon, "ym");
    	ComSetFocus(formObj.eff_yrmon);
    }	
}

function obj_keypress(){    
    obj = event.srcElement;
    if(obj.dataformat == null) return;
    window.defaultStatus = obj.dataformat;
    
    switch(obj.dataformat) {
        case "ym":
            if(obj.name=="eff_yrmon") ComKeyOnlyNumber(this, "-");
            break;
        case "engup":
        	if(obj.name == "sc_no") {
	            ComKeyOnlyAlphabet('uppernum');
        	}else if(obj.name == "ctrt_ofc_cd") {
        		ComKeyOnlyAlphabet('upper');
        	}else if(obj.name == "cre_ofc_cd") {
        		ComKeyOnlyAlphabet('upper');
        	}
            break;
    }        
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	switch (sheetNo) {
	case 1: // sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 420;

			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 6, 100);

			var HeadTitle = "ibflag||Seq.|Creation\nOffice|Contract\nRHQ|Contract\nOffice|Group Customer\nCode|Group Customer\nName|Customer Code|Customer Name|CNTR Customer\nType|S/C No|E.Month|SCC|Remark(s)|||||||";
			var headCount = ComCountHeadTitle(HeadTitle);
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
			
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			
			// 데이터속성 [ROW,	COL,	DATATYPE,		WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,	KEYFIELD,	CALCULOGIC,	DATAFORMAT,	POINTCOUNT,	UPDATEEDIT,	INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0,	cnt++,	dtHiddenStatus,	50,		daCenter,	false,	"ibflag");
			InitDataProperty(0,	cnt++,	dtCheckBox,		30,		daCenter,	false,	"del_chk");
			InitDataProperty(0,	cnt++,	dtDataSeq,		30,		daCenter,	false,	"seq");
			InitDataProperty(0, cnt++,	dtData,			80,	 	daCenter,	false,	"cre_ofc_cd",		false,	"",	dfNone,			0, false,	false,	6);
			InitDataProperty(0, cnt++,	dtData,			80,	 	daCenter,	false,	"rhq_cd",			false,	"",	dfNone,			0, false,	false,	6);
			InitDataProperty(0, cnt++,  dtData,			80,  	daCenter,	false,	"ctrt_ofc_cd",		false,	"",	dfNone,			0, true,	true,	6);
			InitDataProperty(0, cnt++,  dtData,			110,	daCenter,	false,	"cust_grp_id",		false,	"",	dfNone,			0, true,	true,	20);
			InitDataProperty(0, cnt++,  dtData,			225,	daLeft,		false,	"cust_grp_nm",		false,	"",	dfNone,			0, false,	false,	50);
			InitDataProperty(0, cnt++,  dtData,			110,	daCenter,	false,	"cust_cd",			false,	"",	dfNone,			0, true,	true,	8);
			InitDataProperty(0, cnt++,  dtData,			225,	daLeft,		false,	"cust_lgl_eng_nm",	false,	"",	dfNone,			0, false,	false,	100);
			InitDataProperty(0, cnt++,  dtCombo,		110, 	daCenter,	false,	"sc_cust_tp_cd",	false,	"",	dfNone,			0, true,	true,	5);
			InitDataProperty(0, cnt++,  dtData,			110,	daCenter,	false,	"sc_no",			true,	"",	dfNone,			0, false,	true,	20);
			InitDataProperty(0, cnt++,  dtData,			90,	 	daCenter,	false,	"eff_yrmon",		true,	"",	dfUserFormat,	0, false,	true,	6);
			InitDataProperty(0, cnt++,  dtPopupEdit,	80,	 	daCenter,	false,	"loc_cd",			true,	"",	dfNone,			0, false,	true,	5);
			InitDataProperty(0, cnt++,  dtData,			225,	daLeft,		false,	"usa_sc_expt_rmk",	false,	"",	dfNone,			0, true,	true,	1000);
			
			InitDataProperty(0, cnt++ , dtHidden,     	85, 	daCenter,  	true,    "err1",       		false,  "", dfNone,         0, true,    true);
            InitDataProperty(0, cnt++ , dtHidden,     	85, 	daCenter,  	true,    "err2",       		false,  "", dfNone,         0, true,    true);
            InitDataProperty(0, cnt++ , dtHidden,       85, 	daCenter,  	true,    "err3",       		false,  "", dfNone,         0, true,    true);
            InitDataProperty(0, cnt++ , dtHidden,       85, 	daCenter,  	true,    "err4",       		false,  "", dfNone,         0, true,    true);
			InitDataProperty(0, cnt++ , dtHidden,     	85, 	daCenter,  	true,    "insflg",       	false,  "", dfNone,         0, true,    true);
            InitDataProperty(0, cnt++ , dtHidden,     	85, 	daCenter,  	true,    "updflg",       	false,  "", dfNone,         0, true,    true);
            InitDataProperty(0, cnt++ , dtHidden,       85, 	daCenter,  	true,    "delflg",       	false,  "", dfNone,         0, true,    true);
			
            InitDataValid(0, "cre_ofc_cd", vtEngUpOnly);
			InitDataValid(0, "ctrt_ofc_cd", vtEngUpOnly);
			InitDataValid(0, "cust_grp_id", vtEngUpOther, "1234567890-");
			InitDataValid(0, "cust_cd", vtEngUpOther, "1234567890");
			InitDataValid(0, "sc_no", vtEngUpOther, "1234567890");
			InitDataValid(0, "loc_cd", vtEngUpOnly);
			InitDataCombo(0, "sc_cust_tp_cd", 	"BCO|NVOC|Other", 	"BC|NV|OT");
			InitUserFormat(0, "eff_yrmon", "####-##", "-");
			
			ShowButtonImage = 4;
			
			ImageList(0) = "/hanjin/img/btns_search.gif";
			DataLinkMouse("loc_cd") = true;
		}
		break;
		
	case 2: // sheet2 init
		with (sheetObj) {
	
			// 높이 설정
			style.height = 420;
	
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;
	
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
	
			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;
	
			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 6, 100);
	
			var HeadTitle = "ibflag||Seq.|Creation\nOffice|Contract\nRHQ|Contract\nOffice|Group Customer\nCode|Group Customer\nName|Customer Code|Customer Name|CNTR Customer\nType|S/C No|E.Month|SCC|Remark(s)|||||||";
			var headCount = ComCountHeadTitle(HeadTitle);
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
			
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false);
	
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			
			// 데이터속성 [ROW,	COL,	DATATYPE,		WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,	KEYFIELD,	CALCULOGIC,	DATAFORMAT,	POINTCOUNT,	UPDATEEDIT,	INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0,	cnt++,	dtHiddenStatus,	50,		daCenter,	false,	"ibflag");
			InitDataProperty(0,	cnt++,	dtCheckBox,		30,		daCenter,	false,	"del_chk");
			InitDataProperty(0,	cnt++,	dtDataSeq,		30,		daCenter,	false,	"seq");
			InitDataProperty(0, cnt++,	dtData,			80,	 	daCenter,	false,	"cre_ofc_cd",		false,	"",	dfNone,			0, false,	false,	6);
			InitDataProperty(0, cnt++,	dtData,			80,	 	daCenter,	false,	"rhq_cd",			false,	"",	dfNone,			0, false,	false,	6);
			InitDataProperty(0, cnt++,  dtData,			80,  	daCenter,	false,	"ctrt_ofc_cd",		false,	"",	dfNone,			0, true,	true,	6);
			InitDataProperty(0, cnt++,  dtData,			110,	daCenter,	false,	"cust_grp_id",		false,	"",	dfNone,			0, true,	true,	20);
			InitDataProperty(0, cnt++,  dtData,			225,	daLeft,		false,	"cust_grp_nm",		false,	"",	dfNone,			0, false,	false,	50);
			InitDataProperty(0, cnt++,  dtData,			110,	daCenter,	false,	"cust_cd",			false,	"",	dfNone,			0, true,	true,	8);
			InitDataProperty(0, cnt++,  dtData,			225,	daLeft,		false,	"cust_lgl_eng_nm",	false,	"",	dfNone,			0, false,	false,	100);
			InitDataProperty(0, cnt++,  dtCombo,		110, 	daCenter,	false,	"sc_cust_tp_cd",	false,	"",	dfNone,			0, true,	true,	5);
			InitDataProperty(0, cnt++,  dtData,			110,	daCenter,	false,	"sc_no",			true,	"",	dfNone,			0, false,	true,	20);
			InitDataProperty(0, cnt++,  dtData,			90,	 	daCenter,	false,	"eff_yrmon",		true,	"",	dfUserFormat,	0, false,	true,	6);
			InitDataProperty(0, cnt++,  dtPopupEdit,	80,	 	daCenter,	false,	"loc_cd",			true,	"",	dfNone,			0, false,	true,	5);
			InitDataProperty(0, cnt++,  dtData,			225,	daLeft,		false,	"usa_sc_expt_rmk",	false,	"",	dfNone,			0, true,	true,	1000);
			
			InitDataProperty(0, cnt++ , dtHidden,     	85, 	daCenter,  	true,    "err1",       		false,  "", dfNone,         0, true,    true);
	        InitDataProperty(0, cnt++ , dtHidden,     	85, 	daCenter,  	true,    "err2",       		false,  "", dfNone,         0, true,    true);
	        InitDataProperty(0, cnt++ , dtHidden,       85, 	daCenter,  	true,    "err3",       		false,  "", dfNone,         0, true,    true);
	        InitDataProperty(0, cnt++ , dtHidden,       85, 	daCenter,  	true,    "err4",       		false,  "", dfNone,         0, true,    true);
			InitDataProperty(0, cnt++ , dtHidden,     	85, 	daCenter,  	true,    "insflg",       	false,  "", dfNone,         0, true,    true);
	        InitDataProperty(0, cnt++ , dtHidden,     	85, 	daCenter,  	true,    "updflg",       	false,  "", dfNone,         0, true,    true);
	        InitDataProperty(0, cnt++ , dtHidden,       85, 	daCenter,  	true,    "delflg",       	false,  "", dfNone,         0, true,    true);
			
	        InitDataValid(0, "cre_ofc_cd", vtEngUpOnly);
			InitDataValid(0, "ctrt_ofc_cd", vtEngUpOnly);
			InitDataValid(0, "cust_grp_id", vtEngUpOther, "1234567890-");
			InitDataValid(0, "cust_cd", vtEngUpOther, "1234567890");
			InitDataValid(0, "sc_no", vtEngUpOther, "1234567890");
			InitDataValid(0, "loc_cd", vtEngUpOnly);
			InitDataCombo(0, "sc_cust_tp_cd", 	"BCO|NVOC|Other", 	"BC|NV|OT");
			InitUserFormat(0, "eff_yrmon", "####-##", "-");
			
			ShowButtonImage = 4;
			
			ImageList(0) = "/hanjin/img/btns_search.gif";
			DataLinkMouse("loc_cd") = true;
		}
		break;
	}
}


//SHEET 관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	
	switch (sAction) {

		// SEARCH LOGIC
		case IBSEARCH:
			if(validateForm(sheetObj,formObj,sAction)){
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
				formObj.f_cmd.value = SEARCH;
				var sParam = FormQueryString(formObj);
				var sXml = sheetObj.GetSearchXml("EES_CGM_1201GS.do", sParam);
				sheetObj.loadSearchXml(sXml);
			}
			break;
			
		case SEARCH01:
			formObj.f_cmd.value = SEARCH01;
			sheetObj.WaitImageVisible = false;
			
			var sXml = sheetObj.GetSearchXml("EES_CGM_1201GS.do", FormQueryString(formObj));
			var valResult = ComGetEtcData(sXml, "cust_nm");
			var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
			if(valResult == "" || State != "S"){
				ComShowCodeMessage('CGM20023', "Customer Code");
				formObj.cust_nm.value = "";
				break;
			}else{
				formObj.cust_nm.value = valResult;
			}
			break;
			
		case SEARCH02:
			formObj.f_cmd.value = SEARCH02;
			sheetObj.WaitImageVisible = false;
			
			var sXml = sheetObj.GetSearchXml("EES_CGM_1201GS.do", FormQueryString(formObj));
			var valResult = ComGetEtcData(sXml, "scc_cd");
			var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
			if(valResult == "" || State != "S"){
				ComShowCodeMessage('CGM20023', "SCC");
				formObj.scc_cd.value = "";
				break;
			}else{
				formObj.scc_cd.value = valResult;
			}
			break;
			
		case SEARCH03:
			formObj.f_cmd.value = SEARCH03;
			sheetObj.WaitImageVisible = false;
			
			var sXml = sheetObj.GetSearchXml("EES_CGM_1201GS.do", FormQueryString(formObj));
			formObj.chk_dup.value = ComGetEtcData(sXml, "chk_dup");
			break;
			
		case SEARCH04:
			formObj.f_cmd.value = SEARCH04;
			sheetObj.WaitImageVisible = false;
			
			var sXml = sheetObj.GetSearchXml("EES_CGM_1201GS.do", FormQueryString(formObj));
			var valResult = ComGetEtcData(sXml, "cust_grp_nm");
			var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
			if(valResult == "" || State != "S"){
				ComShowCodeMessage('CGM20023', "Group Customer Code");
				formObj.cust_grp_nm.value = "";
				break;
			}else{
				formObj.cust_grp_nm.value = valResult;
			}
			break;
			
		case IBSEARCH_ASYNC01:	// RHQ_CD 조회
			formObj.f_cmd.value = COMMAND01;
			var sXml = sheetObj.GetSearchXml("CgmValidationGS.do", FormQueryString(formObj), '', true);
			var valResult = ComGetEtcData(sXml, "rhq_cd");
			var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
			if(valResult == "" || State != "S"){
				ComShowCodeMessage('CGM20023', "Contract RHQ");
				formObj.rhq_cd.value = "";
				break;
			}else{
				formObj.rhq_cd.value = valResult;
			}
			break;
	
		// SAVE LOGIC
		case IBSAVE:
			// 동일한  sc_no|eff_yrmon|loc_cd 있으면  첫번째 중복행에 대해서  메세지 출력
			var dupRows = sheetObj.ColValueDupRows("sc_no|eff_yrmon|loc_cd",false);
			var arrRow = dupRows.split(",");
			if (dupRows != ""){
				//오류메시지 : 데이터가 중복됩니다.
				ComShowCodeMessage("CGM10017", sheetObj.CellValue(arrRow[0], "sc_no")+", "+sheetObj.CellValue(arrRow[0], "eff_yrmon")+", "+sheetObj.CellValue(arrRow[0], "loc_cd"));
				for (var i = 1; i <= sheetObj.RowCount ; i++){
					if (sheetObj.CellValue(i,"sc_no") == sheetObj.CellValue(arrRow[0],"sc_no") &&
						sheetObj.CellValue(i,"eff_yrmon") == sheetObj.CellValue(arrRow[0],"eff_yrmon") &&
						sheetObj.CellValue(i,"loc_cd") == sheetObj.CellValue(arrRow[0],"loc_cd") &&
						sheetObj.RowStatus(i) == "I"){
						sheetObj.SelectCell(i, "sc_no", true);
					}
				}
				return;
			}
			
			sheetObj.WaitImageVisible=false;
			
			formObj.f_cmd.value = MULTI;
 	        var sParam = ComGetSaveString(sheetObjects[0]);
 	        if(sParam=="")break;
 	        if (sheetObj.IsDataModified){
 	           sParam += "&" + FormQueryString(formObj);
 	           ComOpenWait(true);
 	        }
			var sXml = sheetObj.GetSaveXml("EES_CGM_1201GS.do", sParam);
			
			//삭제성공
			var delsuc = 0;
			//삭제실패
			var delfal = 0;
			//등록성공
			var inssuc = 0;
			//등록실패
			var insfal = 0;
			//수정성공
			var updsuc = 0;
			//수정실패
			var updfal = 0;
			//failcnt
			var failcnt = 0;
			var failflg = false;
			
			var checkCnt = 0;
			
//			var msg = ComXmlStringOfItmCnt(sXml, "vndr_seq", 0);
//			if (msg == "") {ComOpenWait(false); return;}
			
			sheetObjects[1].LoadSaveXml(sXml);
			ComOpenWait(false);
			var sheetcnt = 1;
			
			//삭제 count를 구하고 각 해당 Column 값 맵핑
			for (var i = sheetObjects[1].RowCount; 1 <= i ; i--){
				if (sheetObjects[1].RowStatus(i) == "D" && sheetObjects[1].CellValue(i,"delflg") == "") {
					var sc_nol     = sheetObjects[1].CellValue(i,"sc_no");
					var eff_yrmonl = sheetObjects[1].CellValue(i,"eff_yrmon");
					var loc_cdl    = sheetObjects[1].CellValue(i,"loc_cd");
					sheetObjects[1].RowDelete(i, false);
					for (var j = 1; j <= sheetObj.RowCount ; j++){
						if (sheetObj.RowStatus(j) == "D" && 
							sheetObj.CellValue(j,"sc_no")   == sc_nol &&
							sheetObj.CellValue(j,"eff_yrmon") == eff_yrmonl &&
							sheetObj.CellValue(j,"loc_cd") == loc_cdl){
							sheetObj.RowDelete(j, false);
							delsuc = delsuc + 1;
						}
					}
				} else if (sheetObjects[1].RowStatus(i) == "I"){
					var sc_nol     = sheetObjects[1].CellValue(i,"sc_no");
					var eff_yrmonl = sheetObjects[1].CellValue(i,"eff_yrmon");
					var loc_cdl    = sheetObjects[1].CellValue(i,"loc_cd");
					for (var j = 1; j <= sheetObj.RowCount ; j++){
						if (sheetObj.RowStatus(j) == "I" && 
							sheetObj.CellValue(j,"sc_no")   == sc_nol &&
							sheetObj.CellValue(j,"eff_yrmon") == eff_yrmonl &&
							sheetObj.CellValue(j,"loc_cd") == loc_cdl){
							if (sheetObjects[1].CellValue(i,"cre_ofc_cd") != ""){
								sheetObj.CellValue2(j, "cre_ofc_cd") = sheetObjects[1].CellValue(i,"cre_ofc_cd");
							}
							if (sheetObjects[1].CellValue(i,"rhq_cd") != ""){
								sheetObj.CellValue2(j, "rhq_cd") = sheetObjects[1].CellValue(i,"rhq_cd");
							}
							if (sheetObjects[1].CellValue(i,"cust_grp_nm") != ""){
								sheetObj.CellValue2(j, "cust_grp_id") = sheetObjects[1].CellValue(i,"cust_grp_id");
								sheetObj.CellValue2(j, "cust_grp_nm") = sheetObjects[1].CellValue(i,"cust_grp_nm");
							}
							if (sheetObjects[1].CellValue(i,"cust_lgl_eng_nm") != ""){
								sheetObj.CellValue2(j, "cust_lgl_eng_nm") = sheetObjects[1].CellValue(i,"cust_lgl_eng_nm");
							}
						}
					}
				}
			}

			//color 원복
			for (var i = 1; i <= sheetObj.RowCount; i++){
				setsheetRowColorBlack(i);				
			}
			
			for (var i = 1; i <= sheetObj.RowCount; i++){
				if (sheetObj.RowStatus(i) == "I" || sheetObj.RowStatus(i) == "U" || sheetObj.RowStatus(i) == "D") {
					if (sheetObjects[1].CellValue(sheetcnt, "err1") == "B"){
						sheetObj.CellEditable(i,"sc_no") = false;
						sheetObj.CellEditable(i,"eff_yrmon") = false;
						sheetObj.CellEditable(i,"loc_cd") = false;
						sheetObj.CellValue(i,"err1") = "";
						if(sheetObj.CellValue(i, "rhq_cd") == "" && sheetObj.CellValue(i, "ctrt_ofc_cd") == ""){
							setsheetRowColorRed(i);
						} else {
							sheetObj.CellFontColor(i,"rhq_cd") = sheetObj.RgbColor(255, 0, 0);
							sheetObj.CellFontColor(i,"ctrt_ofc_cd") = sheetObj.RgbColor(255, 0, 0);
						}
						sheetObj.RowStatus(i) = "I";
						failflg = true;
				    }
//					if (sheetObjects[1].CellValue(sheetcnt, "err2") == "B"){
//						sheetObj.CellEditable(i,"sc_no") = false;
//						sheetObj.CellEditable(i,"eff_yrmon") = false;
//						sheetObj.CellEditable(i,"loc_cd") = false;
//						sheetObj.CellValue(i,"err2") = "";
//						if(sheetObj.CellValue(i, "cust_grp_id") == "" && sheetObj.CellValue(i, "cust_grp_nm") == ""){
//							setsheetRowColorRed(i);
//						} else {
//							sheetObj.CellFontColor(i,"cust_grp_id") = sheetObj.RgbColor(255, 0, 0);
//							sheetObj.CellFontColor(i,"cust_grp_nm") = sheetObj.RgbColor(255, 0, 0);
//						}
//						sheetObj.RowStatus(i) = "I";
//						failflg = true;
//				    }
					if (sheetObjects[1].CellValue(sheetcnt, "err3") == "B"){
						sheetObj.CellEditable(i,"sc_no") = false;
						sheetObj.CellEditable(i,"eff_yrmon") = false;
						sheetObj.CellEditable(i,"loc_cd") = false;
						sheetObj.CellValue(i,"err3") = "";
						if(sheetObj.CellValue(i, "cust_cd") == "" && sheetObj.CellValue(i, "cust_lgl_eng_nm") == ""){
							setsheetRowColorRed(i);
						} else {
							sheetObj.CellFontColor(i,"cust_cd") = sheetObj.RgbColor(255, 0, 0);
							sheetObj.CellFontColor(i,"cust_lgl_eng_nm") = sheetObj.RgbColor(255, 0, 0);
						}
						sheetObj.RowStatus(i) = "I";
						failflg = true;
				    }
					if (sheetObjects[1].CellValue(sheetcnt, "err4") == "B"){
						sheetObj.CellEditable(i,"sc_no") = true;
						sheetObj.CellEditable(i,"eff_yrmon") = true;
						sheetObj.CellEditable(i,"loc_cd") = true;
						sheetObj.CellValue(i,"err4") = "";
						sheetObj.CellFontColor(i,"loc_cd") = sheetObj.RgbColor(255, 0, 0);
						sheetObj.RowStatus(i) = "I";
						failflg = true;
				    }
					
					if (failflg == true) failcnt = failcnt + 1;
				    failflg = false;
				    
				    if (sheetObj.RowStatus(i) == "I" && sheetObjects[1].CellValue(sheetcnt, "insflg") == "E"){
						sheetObj.CellEditable(i,"sc_no") = true;
						sheetObj.CellEditable(i,"eff_yrmon") = true;
						sheetObj.CellEditable(i,"loc_cd") = true;
						sheetObj.CellValue(i,"err1") = "";
						sheetObj.CellValue(i,"err3") = "";
						sheetObj.CellValue(i,"err4") = "";
						sheetObj.CellValue(i, "insflg") = "";
						setsheetRowColorRed(i);
						sheetObj.RowStatus(i) = "I";
						insfal = insfal + 1;
				    } else if (sheetObj.RowStatus(i) == "I" && 
				    		   sheetObjects[1].CellValue(sheetcnt, "err1") != "B" &&
				    		   sheetObjects[1].CellValue(sheetcnt, "err3") != "B" &&
				    		   sheetObjects[1].CellValue(sheetcnt, "err4") != "B" ){
						sheetObj.CellEditable(i,"sc_no") = false;
						sheetObj.CellEditable(i,"eff_yrmon") = false;
						sheetObj.CellEditable(i,"loc_cd") = false;
						sheetObj.RowStatus(i) = "R";
						inssuc = inssuc + 1;
				    }
				    
				    if (sheetObj.RowStatus(i) == "U" && sheetObjects[1].CellValue(sheetcnt, "updflg") == "E"){
						sheetObj.CellValue(i,"err1") = "";
						sheetObj.CellValue(i,"err3") = "";
						sheetObj.CellValue(i,"err4") = "";
						sheetObj.CellValue(i, "updflg") = "";
						setsheetRowColorRed(i);
						sheetObj.RowStatus(i) = "U";
						updfal = updfal + 1;
				    } else if (sheetObj.RowStatus(i) == "U" && 
				    		   sheetObjects[1].CellValue(sheetcnt, "err1") != "B" &&
				    		   sheetObjects[1].CellValue(sheetcnt, "err3") != "B" &&
				    		   sheetObjects[1].CellValue(sheetcnt, "err4") != "B" ){
						sheetObj.CellValue(i,"err1") = "";
						sheetObj.CellValue(i,"err3") = "";
						sheetObj.CellValue(i,"err4") = "";
						sheetObj.RowStatus(i) = "R";
						updsuc = updsuc + 1;
				    }
				    
				    if (sheetObjects[1].CellValue(sheetcnt, "delflg") == "E"){
				    	sheetObj.CellEditable(i,"sc_no") = true;
						sheetObj.CellEditable(i,"eff_yrmon") = true;
						sheetObj.CellEditable(i,"loc_cd") = true;
						sheetObj.RowStatus(i) = "D";
				    }
				    sheetcnt = sheetcnt + 1;
				}
			}
			
			var insfalstr = "";
			if (insfal != 0){
				insfalstr = "Insert Fail : " + insfal.toString()+ "\n";
			} else {
				insfalstr = "";
			}
			
			var updfalstr = "";
			if (updfal != 0){
				updfalstr = "Update Fail : " + updfal.toString()+ "\n";
			} else {
				updfalstr = "";
			}
			
			var delfalstr = "";
			if (delfal != 0){
				delfalstr = "Delete Fail : " + delfal.toString()+ "\n";
			} else {
				delfalstr = "";
			}
			
			var failstr = "";
			if (failcnt != 0){
				failstr = "Data Fail   : " + failcnt.toString()+ "\n";
			} else {
				failstr = "";
			}
			
			//실패한 데이터들만 남기고 저장된 데이터들은 Hidden
			checkCnt = failcnt + insfal + updfal;
			if (checkCnt != 0){
				for(var i=1 ; i <= sheetObj.RowCount ; i++){
					if(sheetObj.RowStatus(i) == "R"){
						sheetObj.RowHidden(i) = true;
					}
				}
			}
			
			var sMsg = "";
			if (inssuc > 0 || updsuc > 0 || delsuc > 0){
				sMsg = ComGetMsg("CGM00003", "", "", "");
			}
			if (failcnt > 0){
				sMsg = sMsg + ComGetMsg("CGM20054", "", "", "");
			}
			if (insfal > 0 || updfal > 0 || delfal > 0){
				sMsg = sMsg + ComGetMsg("CGM20055", "", "", "");
			}
			
			ComShowMessage (sMsg);
			break;
			
		case IBDELETE :
			if (sheetObj.id == 'sheet1') {  
	   	   		if(sheetObj.FindCheckedRow("del_chk") != ""){
					ComRowHideDelete(sheetObj,"del_chk"); 
				}
			}
		    break;
	
		// EXCEL FILE DATA - IBSHEET GRID LOADING
		case "btn_loadexcel":		// EXCEL UPLOAD
			sheetObj.RemoveAll();
			sheetObjects[1].RemoveAll();
			formObj.eff_yrmon.value = "";
			formObj.sc_no.value = "";
			formObj.ctrt_ofc_cd.value = "";
			formObj.cre_ofc_cd.value = "";
			sheetObj.Redraw = false;
			sheetObj.LoadExcel(-1, 1, "", -1, 401, "", true, false, "");
			sheetObj.Redraw = true;
			break;
		
		case "btn_downexcel":	// EXCEL DOWNLOAD
//			sheetObj.SpeedDown2Excel(1);
			sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "ibflag|del_chk", "");
			break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
 function validateForm(sheetObj,formObj,sAction){
	 switch(sAction) {
	 case "btn_retrieve" : 
		 if(formObj.eff_yrmon.value == "" && formObj.sc_no.value == ""){
			 ComShowCodeMessage('CGM10004', "EFF.Month or S/C No.");
			 return false;
		 }
		 break;
	 } // end switch()
	 return true;
 }

/**
 * 기본 오브젝트 초기화 
 */
function objectClear(){
	var formObj = document.form;
	var sheetObj  = sheetObjects[0];

	// 데이타 초기화
	sheetObj.RemoveAll();
	sheetObjects[1].RemoveAll();
	formObj.eff_yrmon.value = "";
	formObj.sc_no.value = "";
	formObj.ctrt_ofc_cd.value = "";
	formObj.cre_ofc_cd.value = "";
}

/**
* process when input retrieve keyword
*/
function obj_KeyUp() {
	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
}

/** 
  * Object 의 Keydown 이벤트에 대한 처리  <br>
  * 객체가 agmt_no 일 경우에만 enter 키 발생시 조회실행.  <br>
  * @param  없음
  * @return 없음
  * @author 
  * @version 2013.03.19
  */ 
 function obj_keydown(){
	var formObj = document.form;
 	obj = event.srcElement;
 	
 	switch(obj.name){
 		case 'sc_no':
 	 		ComKeyEnter();
 			break;
 		case 'ctrt_ofc_cd':
 	 		ComKeyEnter();
 			break;
 		case 'cre_ofc_cd':
 	 		ComKeyEnter();
 			break;
 	}
 }

function setsheetRowColorRed(cnt){
	sheetObjects[0].CellFontColor(cnt,2) = sheetObjects[0].RgbColor(255, 0, 0);
	sheetObjects[0].CellFontColor(cnt,3) = sheetObjects[0].RgbColor(255, 0, 0);
	sheetObjects[0].CellFontColor(cnt,4) = sheetObjects[0].RgbColor(255, 0, 0);
	sheetObjects[0].CellFontColor(cnt,5) = sheetObjects[0].RgbColor(255, 0, 0);
	sheetObjects[0].CellFontColor(cnt,6) = sheetObjects[0].RgbColor(255, 0, 0);
	sheetObjects[0].CellFontColor(cnt,7) = sheetObjects[0].RgbColor(255, 0, 0);
	sheetObjects[0].CellFontColor(cnt,8) = sheetObjects[0].RgbColor(255, 0, 0);
	sheetObjects[0].CellFontColor(cnt,9) = sheetObjects[0].RgbColor(255, 0, 0);
	sheetObjects[0].CellFontColor(cnt,10) = sheetObjects[0].RgbColor(255, 0, 0);
	sheetObjects[0].CellFontColor(cnt,11) = sheetObjects[0].RgbColor(255, 0, 0);
	sheetObjects[0].CellFontColor(cnt,12) = sheetObjects[0].RgbColor(255, 0, 0);
	sheetObjects[0].CellFontColor(cnt,13) = sheetObjects[0].RgbColor(255, 0, 0);
	sheetObjects[0].CellFontColor(cnt,14) = sheetObjects[0].RgbColor(255, 0, 0);
	sheetObjects[0].CellFontColor(cnt,15) = sheetObjects[0].RgbColor(255, 0, 0);
}

function setsheetRowColorBlack(cnt){
	sheetObjects[0].CellFontColor(cnt,2) = sheetObjects[0].RgbColor(0, 0, 0);
	sheetObjects[0].CellFontColor(cnt,3) = sheetObjects[0].RgbColor(0, 0, 0);
	sheetObjects[0].CellFontColor(cnt,4) = sheetObjects[0].RgbColor(0, 0, 0);
	sheetObjects[0].CellFontColor(cnt,5) = sheetObjects[0].RgbColor(0, 0, 0);
	sheetObjects[0].CellFontColor(cnt,6) = sheetObjects[0].RgbColor(0, 0, 0);
	sheetObjects[0].CellFontColor(cnt,7) = sheetObjects[0].RgbColor(0, 0, 0);
	sheetObjects[0].CellFontColor(cnt,8) = sheetObjects[0].RgbColor(0, 0, 0);
	sheetObjects[0].CellFontColor(cnt,9) = sheetObjects[0].RgbColor(0, 0, 0);
	sheetObjects[0].CellFontColor(cnt,10) = sheetObjects[0].RgbColor(0, 0, 0);
	sheetObjects[0].CellFontColor(cnt,11) = sheetObjects[0].RgbColor(0, 0, 0);
	sheetObjects[0].CellFontColor(cnt,12) = sheetObjects[0].RgbColor(0, 0, 0);
	sheetObjects[0].CellFontColor(cnt,13) = sheetObjects[0].RgbColor(0, 0, 0);
	sheetObjects[0].CellFontColor(cnt,14) = sheetObjects[0].RgbColor(0, 0, 0);
	sheetObjects[0].CellFontColor(cnt,15) = sheetObjects[0].RgbColor(0, 0, 0);
}

/**
* 콜백 함수. <br>
* @param  {Array} aryPopupData	필수	 Array Object
* @param  {Int} row				필수 선택한 Row
* @param  {Int} col				필수 선택한 Column
* @param  {Int} sheetIdx			필수 Sheet Index
* @return 없음
* @author 
* @version 2013.03.21
*/   
function callBackLocation(aryPopupData, row, col, sheetIdx){
   var sheetObj = sheetObjects[0];
   var crntLocCd = "";
   var i = 0;
   
   for(i = 0; i < aryPopupData.length; i++){
	   crntLocCd = crntLocCd + aryPopupData[i][9];
	   if(i < aryPopupData.length - 1){
		   crntLocCd = crntLocCd + ",";
	   }
   }
   sheetObj.CellValue2(row, "loc_cd") = crntLocCd;
}

function sheet1_OnPopupClick(sheetObj, Row, Col, value) {
	if (sheetObj.ColSaveName(Col) == "loc_cd") {
		ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 460, "callBackLocation", "1,0,1,1,1,1,1", true, false, Row);
	}
}

/**
* Sheet1 의 Change 이벤트를 정의한다.
* @param SheetObj
* @param Row
* @param Col
* @param Value
*/
function sheet1_OnChange(sheetObj, Row, Col, Value){
	var formObj = document.form;
	if(sheetObj.ColSaveName(Col) == "ctrt_ofc_cd" && sheetObj.CellValue(Row,"ctrt_ofc_cd") != ""){
		formObj.ofc_cd.value = sheetObj.CellValue(Row, "ctrt_ofc_cd");
		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
		if(formObj.rhq_cd.value != ""){
			sheetObj.CellValue2(Row,"rhq_cd") = formObj.rhq_cd.value;
		}else{
			sheetObj.CellValue2(Row,"rhq_cd") = "";
			sheetObj.CellValue2(Row,"ctrt_ofc_cd") = "";
		}
	}
	if(sheetObj.ColSaveName(Col) == "cust_grp_id"){
		formObj.cust_grp_id.value = sheetObj.CellValue(Row, "cust_grp_id");
		doActionIBSheet(sheetObj, formObj, SEARCH04);
		if(formObj.cust_grp_nm.value != ""){
			sheetObj.CellValue2(Row,"cust_grp_nm") = formObj.cust_grp_nm.value;
		}else{
			if(sheetObj.CellValue(Row,"cust_cd") != ""){
				sheetObj.CellValue2(Row,"cust_grp_id") = sheetObj.CellValue(Row,"cust_cd");
				sheetObj.CellValue2(Row,"cust_grp_nm") = formObj.cust_nm.value;
			} else{
				sheetObj.CellValue2(Row,"cust_grp_id") = "";
				sheetObj.CellValue2(Row,"cust_grp_nm") = "";
			}
		}
	}
	if(sheetObj.ColSaveName(Col) == "cust_cd"){
		formObj.f_cmd.value = SEARCH01;
		formObj.chk_cust_cd.value = sheetObj.CellValue(Row, "cust_cd");
		doActionIBSheet(sheetObj, formObj, SEARCH01);
		if(formObj.cust_nm.value != ""){
			sheetObj.CellValue2(Row,"cust_lgl_eng_nm") = formObj.cust_nm.value;
			if(sheetObj.CellValue(Row,"cust_grp_id") == ""){
				sheetObj.CellValue2(Row,"cust_grp_id") = sheetObj.CellValue(Row,"cust_cd");
				sheetObj.CellValue2(Row,"cust_grp_nm") = formObj.cust_nm.value;
			}
		}else{
			sheetObj.CellValue2(Row,"cust_cd") = "";
			sheetObj.CellValue2(Row,"cust_lgl_eng_nm") = "";
		}
	}
	if(sheetObj.ColSaveName(Col) == "loc_cd" && sheetObj.CellValue(Row,"loc_cd") != ""){
		formObj.f_cmd.value = SEARCH02;
		formObj.chk_loc_cd.value = sheetObj.CellValue(Row, "loc_cd");
		doActionIBSheet(sheetObj, formObj, SEARCH02);
		sheetObj.CellValue2(Row, "loc_cd") = formObj.scc_cd.value;
	}
	if(sheetObj.CellValue(Row,"ibflag") != "D" && (sheetObj.ColSaveName(Col) == "sc_no" || sheetObj.ColSaveName(Col) == "eff_yrmon" || sheetObj.ColSaveName(Col) == "loc_cd")
			&& sheetObj.CellValue(Row,"sc_no") != "" && sheetObj.CellValue(Row,"eff_yrmon") != "" && sheetObj.CellValue(Row,"loc_cd") != ""){
		formObj.f_cmd.value = SEARCH03;
		formObj.chk_sc_no.value = sheetObj.CellValue(Row,"sc_no");
		formObj.chk_eff_yrmon.value = sheetObj.CellValue(Row,"eff_yrmon");
		formObj.chk_loc_cd.value = sheetObj.CellValue(Row,"loc_cd");
		doActionIBSheet(sheetObj, formObj, SEARCH03);
		if(sheetObj.CellValue(Row,"ibflag") == "I" && formObj.chk_dup.value == "Y"){
			ComShowMessage(Row + " Row's SC NO., E.Month, SCC are duplicated.");
		}
	}
	if(sheetObj.ColSaveName(Col) == "eff_yrmon" && sheetObj.CellValue(Row,"eff_yrmon") != ""){
		var effMon = "";
		effMon = sheetObj.CellValue(Row,"eff_yrmon");
		if(effMon.substr(4) > 12){
			ComShowMessage(Row + " Row's E.Month Range is incorrect.");
		}
	}
}
/* 개발자 작업 끝 */
