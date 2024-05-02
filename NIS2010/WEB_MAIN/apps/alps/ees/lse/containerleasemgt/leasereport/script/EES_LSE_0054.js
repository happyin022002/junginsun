/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_LSE_0054.js
 *@FileTitle : Off Hire Result Vs DOL
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.05
 *@LastModifier : 진준성
 *@LastVersion : 1.0
 * 2009.08.05 진준성
 * 1.0 Creation
 * 2011.01.27 남궁진호 [CHM-201108164-01] 공통 팝업 (COM_ENS_051, COM_ENS_0C1) Open Size 조정
 * 2011.06.13 남궁진호 [CHM-201111467-01] [LSE] MDM에 R9 등록에 따른 추가 업무 진행 요청
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
 * @class EES_LSE_0054 : EES_LSE_0054 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function EES_LSE_0054() {
	this.processButtonClick		= tprocessButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initControl            = initControl;
	this.doActionIBSheet 		= doActionIBSheet;
	this.setTabObject 			= setTabObject;
	this.validateForm 			= validateForm;
	this.combo1_OnCheckClick 	= combo1_OnCheckClick;
	this.combo1_OnBlur 			= combo1_OnBlur;
	this.combo1_OnKeyDown 		= combo1_OnKeyDown;
	this.combo2_OnCheckClick 	= combo2_OnCheckClick;
	this.combo2_OnBlur 			= combo2_OnBlur;
	this.combo2_OnKeyDown 		= combo2_OnKeyDown;
}

/* 개발자 작업	*/
//공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

//Combo Object Array
var comboObjects = new Array();
var comboCnt = 0;

var arrTpSz  = new Array();
var arrTpSz2 = new Array();

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

function initControl() {
	var formObj = document.form;
	axon_event.addListenerForm('click','obj_click',formObj);         //- 변경될때.
	axon_event.addListenerFormat('change','obj_change',formObj);       //- 변경될때.
	axon_event.addListenerFormat('keypress','obj_keypress',formObj); //- 키 눌렸을때
	axon_event.addListenerFormat('blur','obj_blur',formObj);         //- 포커스 나갈때
	axon_event.addListenerFormat('focus','obj_focus',formObj);       //- 포커스 들어갈때
	axon_event.addListenerFormat('focus','obj_click',formObj);
	axon_event.addListenerForm('keydown','obj_keydown',	formObj); //- 키 눌렸을때
}

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject0 = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	var sheetObject2 = sheetObjects[2];
	/*******************************************************/
	var formObject = document.form;

	try {
		var srcObj  = window.event.srcElement;
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

		case "btn_DownExcel1":
			sheetObject1.SpeedDown2Excel(-1);
			break;

		case "btn_DownExcel2":
			sheetObject2.SpeedDown2Excel(-1);
			break;

		case "btn_Retrieve":
			if ( srcObj.style.filter == "" ) {
				sheetObject1.RemoveAll();
				sheetObject2.RemoveAll();
				doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
			}
			break;

		case "btn_New":
			sheetObjects[1].CellText(0,"agmt_no") = "Location";
			formObject.report_type[0].selected = true;
			formObject.agmt_seq.value    = "";
			document.form.loc_cd.className   = "input";
			document.form.agmt_seq.className = "input1";
			setAgmtSeq(sheetObjects[0], 2);
			sheetObject1.RemoveAll();
			sheetShowInit();
			sheetObject2.RemoveAll();
			formObject.year_month.value = "";
			formObject.loc_tp[0].selected = true;
			formObject.loc_cd.value = "";
			formObject.vndr_seq.value = "";
			formObject.vndr_nm.value = "";
			formObject.abbr_nm.value = "";
			formObject.agmt_seq.value = "";

			for(var i = 1 ; i < comboObjects[0].GetCount(); i++ ){
				comboObjects[0].CheckIndex(i)=false;
			}
			formObject.lstm_cd.value = "";
			for(var i = 1 ; i < comboObjects[1].GetCount(); i++ ){
				comboObjects[1].CheckIndex(i)=false;

			}
			comboObjects[0].CheckIndex(0) = true;
			comboObjects[1].CheckIndex(0) = true;
			formObject.cntr_tpsz_cd.value = "";
			formObject.term_change[1].selected = true;
			formObject.dii[0].selected = true;
			break;

		case "btns_calendar1":
			/*
    			var cal = new ComCalendar();
    			cal.select(formObject.year_month, "yyyy-MM");*/
			if ( srcObj.style.filter == "" ) {
				var cal = new ComCalendar();
				cal.setDisplayType('month');
				cal.select(formObject.year_month, "yyyy-MM");
			}
			break;

		case "btns_search1":      // loc_cd
		if ( srcObj.style.filter == "" ) {
			openPopup("1");
		}
		break;

		case "btns_search2":     // lessor
		if ( srcObj.style.filter == "" ) {
			openPopup("2");
		}
		break;

		case "btns_search3":	//agmt_seq
		if ( srcObj.style.filter == "" ) {
			openPopup("3");
		}
		break;

		case "btn_agmt_seq": // B/L No.
			if (document.getElementById("agmt_input").style.display == "block") {
 				setAgmtSeq(sheetObjects[0], 1);
			} else {
 				setAgmtSeq(sheetObjects[0], 2);
 			}
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
      * Agmt Seq. 값 설정
      */
     function setAgmtSeq(sheetObj, param) {

     	var formObject = document.form;
     	var rect = document.getElementById("td_agmt_seq").getBoundingClientRect();
		var arrAgmtSeq  = new Array();
		var vAgmtSeq = formObject.agmt_seq.value;
		
     	formObject.rect_top.value = formObject.rect_top.value == "" ? rect.top : formObject.rect_top.value;
     	formObject.rect_left.value = formObject.rect_left.value == "" ? rect.left : formObject.rect_left.value;

     	if (param == 1) {

			arrAgmtSeq = vAgmtSeq.split(',');
			
			//sheetObj.RemoveEtcData();
			
			for ( var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
      			sheetObj.CellValue(i, "agmt_seq") = "";
      		}
			
			for( var i=0 ; i<arrAgmtSeq.length ; i++){
				sheetObj.CellValue(i+1, "agmt_seq") = arrAgmtSeq[i];
			}

     		//  sheet 활성화
     		document.getElementById("agmt_input").style.display = "none";
     		document.getElementById("agmt_sheet").style.display = "block";

     		//  sheet 위치설정
     		document.getElementById("agmt_sheet").style.top = formObject.rect_top.value;
     		document.getElementById("agmt_sheet").style.left = formObject.rect_left.value;
			
			sheetObj.SelectCell(1,1);

     	} else if (param == 2) {
			
			//초기화
			vAgmtSeq = ""; 
			var j = 0;
			
     		// input 활성화
     		document.getElementById("agmt_input").style.display = "block";
     		document.getElementById("agmt_sheet").style.display = "none";

     		for ( var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
     			if (!ComIsEmpty(sheetObj.CellValue(i,  "agmt_seq"))) {
					if(j>=1){
						vAgmtSeq += ",";
					}
					
     				vAgmtSeq += sheetObj.CellValue(i, "agmt_seq");
					j++;
     			}
     		}
			formObject.agmt_seq.value = vAgmtSeq;
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
 * IBMultiCombo Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
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

	for(i=0;i<sheetObjects.length;i++){

		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet (sheetObjects[i] );

		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	initControl();

	/* IBMultiCombo 초기화 */
	for ( var k = 0 ; k < comboObjects.length ; k++ ) {
		initCombo(comboObjects[k], k+1);
	}
}

function sheet1_OnLoadFinish(){
	/* IBMulti Combo Item Setting */
	doActionIBSheet(sheetObjects[1], document.form,IBCREATE);
	initSheet(sheetObjects[1],1);
	doActionIBSheet(sheetObjects[1], document.form,IBSEARCH_ASYNC03);
	comboObjects[0].CheckIndex(0) = true;
	comboObjects[1].CheckIndex(0) = true;
	sheetShowInit();
	document.form.year_month.focus();
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
	case "sheet1":
		with (sheetObj) {

			// 높이 설정
			style.height = 202;
			//전체 너비 설정
			SheetWidth = 984;//mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 4, 10, 100);
			var HeadTitleTemp  = "";
			for(var i=0; i<arrTpSz.length; i++){
				HeadTitleTemp = HeadTitleTemp + "|" + arrTpSz[i];
			}
			var HeadTitle = "|LCC|SCC|DIV|Total" + HeadTitleTemp + "||";
			var headCount = ComCountHeadTitle(HeadTitle);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, false, true, false,false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			for(var j = 0; j < 4; j ++) {
    			cnt = 0;
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(j, cnt++ , dtHiddenStatus,     0,    daCenter, true,  "Status");
				InitDataProperty(j, cnt++ , dtData,           100,    daCenter, true,  "location",    false,  "",     dfNone);
				InitDataProperty(j, cnt++ , dtData,            80,    daCenter, true,  "agmt_no",     false,  "",     dfNone);
				InitDataProperty(j, cnt++ , dtData,            90,    daCenter, false, "div",         false,  "",     dfNone);
				InitDataProperty(j, cnt++ , dtData,            90,    daRight,  false, "div_total",   false,  "",     dfNullInteger);
				for(var i=0; i<arrTpSz2.length; i++){
					InitDataProperty(j, cnt++ , dtData,             50,    daRight,  true,  arrTpSz2[i] + "",          false,  "",     dfNullInteger,   0,  false,    true);
				}
				InitDataProperty(j, cnt++ , dtHidden,           0,    daCenter, false, "scc_cd",      false,  "",     dfNone);
				InitDataProperty(j, cnt++ , dtAutoSum,         90,    daRight,  false, "auto_sum",    false,  "",     dfNullInteger);
			}

			ColHidden("auto_sum") = true;
			SelectBackColor = LSE_SELECT_BACK_COLOR;
			CountPosition   = 0;
			FrozenCols = 5;
		}
		break;

	case "sheet2":
		with (sheetObj) {

			// 높이 설정
			style.height = 207;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo( 1, 1, 10, 100);

			var HeadTitle = "|Seq.|CNTR No.|TP/SZ|AGMT No.|Term|Ref No.|MVMT|On-hire\nDate|On-hire\nYard|F/Days|Off-hire\nDate|Off-hire\nYard|Used\nDays|BKG No|POL|POR|POD|DEL|ETD DT|ETA DT|VVD|Min\nO/H Days|Term\nChange|Direct\nInterchange in|Immediate\nExit|Rental\nCharge|LON|PUC|PCR|LOF|DOC|DCR|On-hire\nDrayage|Off-hire\nDrayage|M & R\nCost|DPP|G.TTL";
			var headCount = ComCountHeadTitle(HeadTitle);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false)

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,      30,	daCenter,	 true,	"Status");
			InitDataProperty(0, cnt++ , dtSeq,               30,    daCenter,    true,  "seq");
			InitDataProperty(0, cnt++ , dtData,      		 80,    daCenter,	 true,	"cntrno",		         false,	"",		dfNone);
			InitDataProperty(0, cnt++ , dtData,      		 45,	daCenter,	 true,	"cntr_tpsz_cd",	         false,	"",		dfNone);
			InitDataProperty(0, cnt++ , dtData,   			 90,    daCenter,	 true,	"agmt_no",			     false,	"",		dfNone);
			InitDataProperty(0, cnt++ , dtData,      		 40,    daCenter,	false,	"lstm_cd",				 false,	"",		dfNone);
			InitDataProperty(0, cnt++ , dtData,     	    110,    daLeft,	    false,	"ref_no",			     false,	"",		dfNone);
			InitDataProperty(0, cnt++ , dtData,      		 40,    daCenter, 	false,  "cnmv_sts_cd",  	     false, "",		dfNone);
			InitDataProperty(0, cnt++ , dtData,      		 80,	daCenter,	false,	"ohdate",		         false,	"",		dfDateYmd);
			InitDataProperty(0, cnt++ , dtData,      	  	 60,	daCenter,	false,	"ohloc",		         false,	"",		dfNone);
			InitDataProperty(0, cnt++ , dtData,      		 60,	daRight,	false,	"fdays",		         false,	"",		dfNullInteger);
			InitDataProperty(0, cnt++ , dtData,      		 80, 	daCenter,	false,	"ofhdate",		         false,	"",		dfDateYmd);
			InitDataProperty(0, cnt++ , dtData,      		 60, 	daCenter,	false,	"ofhloc",		         false,	"",		dfNone);
			InitDataProperty(0, cnt++ , dtData,      		 60, 	daRight,	false,	"useddays",		         false,	"",		dfNullInteger);
			InitDataProperty(0, cnt++ , dtData,   	   	 	 85,    daCenter,	false,	"bkg_no",				 false,	"",		dfNone);
			InitDataProperty(0, cnt++ , dtData,      		 60,    daCenter,	false,	"pol_cd",				 false,	"",		dfNone);
			InitDataProperty(0, cnt++ , dtData,      		 60,	daCenter,	false,	"por_cd",				 false,	"",		dfNone);
			InitDataProperty(0, cnt++ , dtData,      		 60,    daCenter,	false,	"pod_cd",			 	 false,	"",		dfNone);
			InitDataProperty(0, cnt++ , dtData,      		 60,    daCenter,	false,	"del_cd",				 false,	"",		dfNone);
			InitDataProperty(0, cnt++ , dtData,      		 80,    daCenter,	false,	"etd_dt",				 false,	"",		dfNone);
			InitDataProperty(0, cnt++ , dtData,      		 80,    daCenter,	false,	"eta_dt",				 false,	"",		dfNone);
			InitDataProperty(0, cnt++ , dtData,      		 75,    daCenter,	false,	"vvd",					 false,	"",		dfNone);
			InitDataProperty(0, cnt++ , dtData,      		 70, 	daRight,	false,	"minohdays",             false,	"",		dfNullInteger);
			InitDataProperty(0, cnt++ , dtCheckBox,          70, 	daCenter,	false,	"term_change",           false,	"",		dfNone);
			InitDataProperty(0, cnt++ , dtCheckBox,      	105, 	daCenter,	false,	"dii",                   false,	"",		dfNone);
			InitDataProperty(0, cnt++ , dtCheckBox,      	 80, 	daCenter,	false,	"immediately",           false,	"",		dfNone);
			InitDataProperty(0, cnt++ , dtData,      	     65,    daRight,	false,	"rental_charge",	     false,	"",		dfFloat,	"2");
			InitDataProperty(0, cnt++ , dtData,      	     65,    daRight,	false,	"lon",		             false,	"",		dfFloat,	"2");
			InitDataProperty(0, cnt++ , dtData,      	     65,    daRight,	false,	"puc",		             false,	"",		dfFloat,	"2");
			InitDataProperty(0, cnt++ , dtData,      	     65,    daRight,	false,	"pcr",		             false,	"",		dfFloat,	"2");
			InitDataProperty(0, cnt++ , dtData,      	     65,    daRight,	false,	"lof",		             false,	"",		dfFloat,	"2");
			InitDataProperty(0, cnt++ , dtData,      	     65,    daRight,	false,	"doc",		             false,	"",		dfFloat,	"2");
			InitDataProperty(0, cnt++ , dtData,      	     65,    daRight,	false,	"dcr",		             false,	"",		dfFloat,	"2");
			InitDataProperty(0, cnt++ , dtData,      	     65,    daRight,	false,	"on_hire_drayage",	     false,	"",		dfFloat,	"2");
			InitDataProperty(0, cnt++ , dtData,      	     65,    daRight,	false,	"off_hire_drayage",	     false,	"",		dfFloat,	"2");
			InitDataProperty(0, cnt++ , dtData,      	     65,    daRight,	false,	"m_r_cost",		         false,	"",		dfFloat,	"2");
			InitDataProperty(0, cnt++ , dtData,      	     65,    daRight,	false,	"dpp",		             false,	"",		dfFloat,	"2");
			InitDataProperty(0, cnt++ , dtData,      	    100,    daRight,	false,	"g_ttl",		         false,	"",		dfFloat,	"2");

			SelectBackColor = LSE_SELECT_BACK_COLOR;
		}
		break;
		
	case "sheet3":
		with (sheetObj) {

			// 높이 설정
      		style.height = 130;
      		// 전체 너비 설정
      		SheetWidth = 220;			
			
			//전체 너비 설정
			//SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo( 1, 1, 2, 100);

			var HeadTitle = "|agmt_seq";
			var headCount = ComCountHeadTitle(HeadTitle);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false)

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 80, daLeft, true,  "ibflag",  	 false, "", dfNone, 0, true, true, 12);
     		InitDataProperty(0, cnt++, dtData,         80, daLeft, true,  "agmt_seq",    false, "", dfNone, 0, true, true, 6);
			
			InitDataValid(0, "agmt_seq", vtNumericOnly); 
			CountPosition = 0;
		}
		
		var formObject = document.form;
		for ( var i = 1; i <= 30; i++) {
     		sheetObj.DataInsert(-1);
      		sheetObj.CellValue(i, "ibflag") = "R";
      	}
      	sheetObj.RowHidden(0) = true;
		break;		
	}
}

//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	//sheetObj.ShowDebugMsg = false;
	switch(sAction) {

	case IBSEARCH:      //조회
	if(validateForm(sheetObj,formObj,sAction))
		if (sheetObj.id == "sheet1"){
			formObj.f_cmd.value = SEARCH;

			sheetObj.Redraw = false;
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			var sXml = sheetObj.GetSearchXml("EES_LSE_0054GS.do", FormQueryString(formObj));
			ComOpenWait(false);

			if(ComGetTotalRows(sXml) > 1) {
				sheetObj.LoadSearchXml(sXml);

				var lRow = sheetObj.LastRow -4;
				var gTTL = "";
				var hiddenCnt = 0;
				var strCntrTpszCd = formObj.cntr_tpsz_cd.value ;

				for(var i = 0 ; i < arrTpSz2.length ; i++){
					gTTL= sheetObjects[1].CellValue(lRow ,arrTpSz2[i]);
					if( comboObjects[1].CheckIndex(0) == true ){
						if( Number(gTTL) <= 0 ){
							sheetObjects[1].ColHidden(arrTpSz2[i]) = true;
							hiddenCnt++;
						}else{
							sheetObjects[1].ColHidden(arrTpSz2[i]) = false;
						}
					}else{
						if( 0 <= strCntrTpszCd.indexOf(arrTpSz[i])) {
							if( Number(gTTL) <= 0 ){
								sheetObjects[1].ColHidden(arrTpSz2[i]) = true;
								hiddenCnt++;
							}else{
								sheetObjects[1].ColHidden(arrTpSz2[i]) = false;
							}
						}else{
							sheetObjects[1].ColHidden(arrTpSz2[i]) = true;
							hiddenCnt++;
						}
					}
				}
				if(  ((arrTpSz2.length - hiddenCnt) * 50) +  380  > 984 ){
					sheetObjects[1].SheetWidth = 984;
				}else{
					sheetObjects[1].SheetWidth = ((arrTpSz2.length - hiddenCnt) * 50) +  380 ;
				}

				if(sheetObj.SearchRows > 0) {
					sheetObj.RowDelete(sheetObj.LastRow -8, false);
					sheetObj.RowDelete(sheetObj.LastRow -7, false);
					sheetObj.RowDelete(sheetObj.LastRow -6, false);
					sheetObj.RowDelete(sheetObj.LastRow -5, false);
					sheetObj.RowDelete(sheetObj.LastRow -4, false);

					sheetObj.SetMergeCell(sheetObj.LastRow -3, 1, 4, 2);
					sheetObj.CellValue2(sheetObj.LastRow -3, "location") = "G.TTL";
				}
			} else {
				sheetObj.LoadSearchXml("<SHEET><DATA TOTAL='0'></DATA></SHEET>");
			}

			sheetObj.Redraw = true;
		}
	break;

	case IBCREATE:
		formObj.f_cmd.value = SEARCH02;
		sheetObj.WaitImageVisible = false;
		var sXml2 = sheetObj.GetSearchXml("EES_LSE_COMGS.do", FormQueryString(formObj));
		sheetObj.WaitImageVisible = true;

		if ( sXml2 != "" ) {
			comboObjects[1].InsertItem(0 , 'ALL','ALL');
			LseComXml2ComboItem(sXml2, comboObjects[1], "cntr_tpsz_nm", "cntr_tpsz_cd", "|");
			vOrcCntrTpszCd = ComGetEtcData(sXml2, "cntr_tpsz_cd");
			formObj.tysz.value = vOrcCntrTpszCd;
			arrTpSz   =  vOrcCntrTpszCd.replaceStr("|", ",").split(",");
			arrTpSz2  =  vOrcCntrTpszCd.toLowerCase().replaceStr("|", ",").split(",");
		}
		break;

	case IBSEARCH_ASYNC01:      //조회
	if(validateForm(sheetObj,formObj,sAction)) {
		if(sheetObj.id == "sheet2") {
			formObj.f_cmd.value = SEARCH01;

			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			sheetObj.DoSearch("EES_LSE_0054GS2.do",FormQueryString(formObj));
			ComOpenWait(false);
		}
	}
	break;

	case IBSEARCH_ASYNC02:      //조회
	if(validateForm(sheetObj,formObj,sAction)) {
		if(sheetObj.id == "sheet1") {
			formObj.f_cmd.value = SEARCH03;
			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",FormQueryString(formObj));
			sheetObj.WaitImageVisible = true;
			if ( ComGetEtcData(sXml, "ref_no") != undefined ) {
				formObj.contract_no.value = ComGetEtcData(sXml, "ref_no");

				for(var i = 0 ; i < comboObjects[0].GetCount(); i++ ){
					comboObjects[0].CheckIndex(i)=false;
				}
				comboObjects[0].CheckCode(ComGetEtcData(sXml, "lstm_cd")) = true;
				formObj.lstm_cd.value  = ComGetEtcData(sXml, "lstm_cd");
				formObj.vndr_seq.value = ComGetEtcData(sXml, "vndr_seq");
				formObj.abbr_nm.value  = ComGetEtcData(sXml, "vndr_abbr_nm");
				formObj.vndr_nm.value  = ComGetEtcData(sXml, "vndr_lgl_eng_nm");

			} else {
				ComShowCodeMessage("LSE01007");
				formObj.agmt_seq.value = "";
				formObj.contract_no.value = "";
				ComSetFocus(formObj.agmt_seq);
			}
		}
	}
	break;

	case IBSEARCH_ASYNC03:

		/* Lease Term Form Combo Item Setting */
		ComSetObjValue(formObj.f_cmd, SEARCH01);
		sheetObj.WaitImageVisible = false;
		var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", FormQueryString(formObj));
		sheetObj.WaitImageVisible = true;
		if ( sXml != "" ) {
			comboObjects[0].InsertItem(0 , 'ALL','ALL');
			LseComXml2ComboItem(sXml, comboObjects[0], "lease_term_nm", "lease_term_cd", "|");
		}
		vOrcLstmCd = ComGetEtcData(sXml, "lease_term_nm");
		break;

	case IBSEARCH_ASYNC04:	//조회(Form Lessor No. 입력시)
	if ( validateForm(sheetObj, formObj, sAction) ) {
		var param = "f_cmd="+SEARCH06+"&vndr_seq="+ComGetObjValue(formObj.vndr_seq);
		sheetObj.WaitImageVisible = false;
		var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", param);
		sheetObj.WaitImageVisible = true;

		if ( sXml != "" ) {
			if ( ComGetEtcData(sXml, "vndr_lgl_eng_nm") != undefined ) {
				ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
				ComSetObjValue(formObj.abbr_nm, ComGetEtcData(sXml, "vndr_abbr_nm"));
				ComSetFocus(formObj.vndr_nm);
			} else {
				ComShowCodeMessage("LSE01019");
				formObj.vndr_seq.value = "";
				formObj.vndr_nm.value  = "";
				ComSetFocus(formObj.vndr_seq);
			}
		} else {
			ComShowCodeMessage("LSE01019");
			formObj.vndr_seq.value = "";
			formObj.vndr_nm.value  = "";
			ComSetFocus(formObj.vndr_seq);
		}
	}
	break;
	case IBSEARCH_ASYNC05:	// Location 조회
	if(validateForm(sheetObj,formObj,sAction)) {
		if ( sheetObj.id == "sheet1") {
			var vLocTp = formObj.loc_tp.value;
			var param = "f_cmd="+SEARCH05+"&loc_tp="+ vLocTp + "CC"
			+"&loc_cd="+ComGetObjValue(formObj.loc_cd);
			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",param);
			sheetObj.WaitImageVisible = true;
			if ( sXml != "" ) {
				if ( ComGetEtcData(sXml, "rcc_cd") != undefined ) {
					if ( ComGetEtcData(sXml, "rcc_cd") != "" ) {
						var vLocCd = "";
						switch (vLocTp) {
						case "R":
							vLocCd = ComGetEtcData(sXml, "rcc_cd");
							break;

						case "L":
							vLocCd = ComGetEtcData(sXml, "lcc_cd");
							break;

						case "S":
							vLocCd = ComGetEtcData(sXml, "scc_cd");
							break;
						}
						formObj.loc_cd.value = vLocCd;
						ComSetFocus(formObj.loc_cd);
					} else {
						ComShowCodeMessage("LSE01037");
						formObj.loc_cd.value = "";
						ComSetFocus(formObj.loc_cd);
					}
				} else {
					var errMsg = LseComGetErrMsg(sXml);
					if ( errMsg != "" ) {
						ComShowMessage(errMsg);
					}
					formObj.loc_cd.value = "";
					ComSetFocus(formObj.loc_cd);
				}
			}
		}
	}
	break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with(sheetObj){
		with(formObj){
			switch(sAction) {
			case IBSEARCH:      //조회

			if ( formObj.year_month.value == "" ) {
				ComShowCodeMessage("LSE01010");
				ComSetFocus(formObj.year_month);
				return false;
				break;
			}

			if ( formObj.report_type[0].selected == true && formObj.agmt_seq.value == "" ) {
				ComShowCodeMessage("LSE01006");
				ComSetFocus(formObj.agmt_seq);
				return false;
				break;
			}

			if ( formObj.report_type[1].selected == true && formObj.loc_cd.value == "" ) {
				ComShowCodeMessage("LSE01046");
				ComSetFocus(formObj.loc_cd);
				return false;
				break;
			}

			if(formObj.cntr_tpsz_cd.value == ""  && comboObjects[1].CheckIndex(0) == false ){
				ComShowCodeMessage("LSE01015");
				formObj.combo2.focus();
				return false;
				break;
			}


			break;
			}
		}
	}
	return true;
}


/**
 * HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
 */
function obj_blur(){
	var obj = event.srcElement;
	var formObj  = document.form;
	switch(obj.name){
	case "period_stdt":
		//숫자이면서 천단위 구분을 하지 않는다.
		ComChkObjValid(obj);
		break;
	case "period_eddt":
		//숫자이면서 천단위 구분을 하지 않는다.
		ComChkObjValid(obj);
		break;
	case "btns_calendar3":
		//숫자이면서 천단위 구분을 하지 않는다.
		ComChkObjValid(obj);
		break;
	case "agmt_seq":
		if ( document.form.agmt_seq.value == null || document.form.agmt_seq.value == "" ) {
			document.form.contract_no.value = "";
		}
		break;
	case "vndr_seq":
		if ( document.form.vndr_seq.value == null || document.form.vndr_seq.value == "" ) {
			document.form.vndr_nm.value = "";
			document.form.abbr_nm.value = "";
		}
		break;
	case "year_month":
		var strYear      = "";
		var strMonth     = "";
		var strYearMonth = formObj.year_month.value ;
		if(strYearMonth != null && strYearMonth.length == 6){
			if(strYearMonth != null && strYearMonth.length == 7){
				strYearMonth = strYearMonth.replaceStr("-" , "");
			}
			strYear  = strYearMonth.substring(0,4);
			strMonth = strYearMonth.substring(4);
			formObj.period_stdt.value = strYear + "-" + strMonth + "-01" ;
			formObj.period_eddt.value = strYear + "-" + strMonth + "-" + GetLastDay(strYear,strMonth);
		}
		ComChkObjValid(obj);
		break;
	default:
		//Validation 전체 체크(길이,format,최대,최소 등등)
		break;
	}
}

/**
 * 콤보 초기설정값, 헤더 정의
 * param : comboObj ==> 콤보오브젝트, sheetNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initCombo(comboObj, comboNo) {
	switch(comboObj.id) {
	case "combo1":
		with(comboObj) {
			DropHeight = 250;
			MultiSelect = true;
			//MaxSelect = 1;
			MultiSeparator = ",";
			Style = 0;
			UseAutoComplete = true;
			//영문(대)+특수문자 - Lease Term
			ValidChar(2,2);
		}

		break;

	case "combo2":
		with(comboObj) {
			DropHeight = 200;
			MultiSelect = true;
			//MaxSelect = 1;
			MultiSeparator = ",";
			Style = 0;
			UseAutoComplete = true;
			//영문(대)+특수문자,숫자 - TP/SZ
			ValidChar(2,3);
		}
		break;

	}
}
/**
 * MultiSelect속성을 이용하는 경우, 체크박스를 클릭하는 순간 발생한다.
 * @return
 */
function combo1_OnCheckClick(comboObj, index, code) {
	if(index==0) {
		var bChk = comboObj.CheckIndex(index);
		if(bChk){
			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
				comboObj.CheckIndex(i) = false;
			}
		}
	} else {
		comboObj.CheckIndex(0) = false;
	}
}


/**
 * combo1_OnBlur
 */
function combo1_OnBlur(comboObj, Index_Code, Text) {
	var formObj = document.form;
	if( comboObj.CheckIndex(0)){
		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
			comboObj.CheckIndex(i) = false;
		}
		formObj.lstm_cd.value = "";
	}else if(comboObj.Text == ""){
		comboObj.CheckIndex(0) = true;
		formObj.lstm_cd.value = "";
	}else{
	    formObj.lstm_cd.value = ComGetObjValue(comboObj);
	}
}


/**
 * combo1_OnKeyDown
 */
function combo1_OnKeyDown(comboObj, KeyCode, Shift) {
	with(comboObj) {
		if ( KeyCode == 188 &&  comboObj.CheckIndex(0)){
			comboObj.Text = "";
		}else if(KeyCode == 13){
 		    sheetObjects[1].RemoveAll();
 		    sheetObjects[2].RemoveAll();
 			doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
		}
	}
}

/**
 * MultiSelect속성을 이용하는 경우, 체크박스를 클릭하는 순간 발생한다.
 * @return
 */
function combo2_OnCheckClick(comboObj, index, code) {
	if(index==0) {
		var bChk = comboObj.CheckIndex(index);
		if(bChk){
			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
				comboObj.CheckIndex(i) = false;
			}
		}
	} else {
		comboObj.CheckIndex(0) = false;
	}
}

/**
 * combo2_OnBlur
 */
function combo2_OnBlur(comboObj, Index_Code, Text) {
	var formObj = document.form;
	if( comboObj.CheckIndex(0)){
		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
			comboObj.CheckIndex(i) = false;
		}
		formObj.cntr_tpsz_cd.value = "";
	}else if(comboObj.Text == ""){
		comboObj.CheckIndex(0) = true;
		formObj.cntr_tpsz_cd.value = "";
	}else{
	    formObj.cntr_tpsz_cd.value = ComGetObjValue(comboObj);
	}
}

/**
 * combo2_OnKeyDown
 */
function combo2_OnKeyDown(comboObj, KeyCode, Shift) {
	with(comboObj) {
		if ( KeyCode == 188 &&  comboObj.CheckIndex(0)){
			comboObj.Text = "";
		}else if(KeyCode == 13){
 		    sheetObjects[1].RemoveAll();
 		    sheetObjects[2].RemoveAll();
 			doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
		}
	}
}

/**
 * Pop-up Open 부분<br>
 * @param type 1:Agreement(include Ver.) for FORM, 2:Lessor for FORM, 3:Currency for FORM
 * @param object 대상 Object
 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
 */
function openPopup(type, Row, Col) {
	var formObj = document.form;

	if ( type == "1" ) {
		var sUrl    = '/hanjin/COM_ENS_051.do';
		var iWidth  = 800;
		var iHeight = 430;
		var sTargetObjList = "";
		var sDisplay = "1,0,1,1,1,1,1,1";

		if(formObj.loc_tp.value == "R"){
		    sTargetObjList = "rcc_cd:loc_cd";
		}else{
			sTargetObjList = "scc_cd:loc_cd";
		}

		ComOpenPopupWithTarget(sUrl, iWidth, iHeight, sTargetObjList, sDisplay, true);

	} else if ( type == "2") {
		ComOpenPopup('/hanjin/COM_ENS_0C1.do', 705, 450, 'setPopData_Lessor', '1,0,1,1,1,1,1,1', true);

	} else if ( type == "3") {
		ComOpenPopup('/hanjin/EES_LSE_0091.do', 805, 450, 'setPopData_Agreement', '1,0', true);

	}
}

/**
 * DeliveryLoc(Country) Pop-up Return Value 처리 부분<br>
 * @param {arry} returnedValues Pop-up 화면의 Return value array
 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
 * @param 대상IBSheet의 Sheet Array index
 */
function getCOM_ENS_0M1_2(aryPopupData, Row, Col, SheetIdx) {
	var sheetObj = sheetObjects[SheetIdx];
	var formObj  = document.form;

	if ( aryPopupData.length > 0 ) {
		ComSetObjValue(formObj.loc_cd, aryPopupData[0][3]);
	}
}

/**
 * DeliveryLoc(Yard) Pop-up Return Value 처리 부분<br>
 * @param {arry} returnedValues Pop-up 화면의 Return value array
 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
 * @param 대상IBSheet의 Sheet Array index
 */
function setPopData_DeliveryLoc(aryPopupData, Row, Col, SheetIdx) {
	var sheetObj = sheetObjects[SheetIdx];
	var formObj  = document.form;

	if ( aryPopupData.length > 0 ) {
		ComSetObjValue(formObj.loc_cd, aryPopupData[0][3]);
	}
}

/**
 * Currency Pop-up Return Value 처리 부분<br>
 * @param {arry} returnedValues Pop-up 화면의 Return value array
 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
 * @param 대상IBSheet의 Sheet Array index
 */
function setPopData_Agreement(aryPopupData, Row, Col, SheetIdx) {
	var formObj  = document.form;
	var sheetObj = sheetObjects[1];
	if ( aryPopupData.length > 0 ) {
		ComSetObjValue(formObj.agmt_seq, aryPopupData[0][4]);
		ComSetObjValue(formObj.contract_no, aryPopupData[0][5]);
	}
}

/**
 * Lessor(Service Provider) Pop-up Return Value 처리 부분<br>
 * @param {arry} returnedValues Pop-up 화면의 Return value array
 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
 * @param 대상IBSheet의 Sheet Array index
 */
function setPopData_Lessor(aryPopupData, Row, Col, SheetIdx) {
	var sheetObj = sheetObjects[SheetIdx];
	var formObj  = document.form;

	if ( aryPopupData.length > 0 ) {
		formObj.vndr_seq.value = ComLtrim(aryPopupData[0][2],"0");
		formObj.vndr_nm.value  = aryPopupData[0][4];
		formObj.abbr_nm.value  = aryPopupData[0][5];
	}
}

/**
 * HTML Control의 Value가 변경되었을 경우 처리한다.
 */
function obj_change(){
	var obj      = event.srcElement;
	var formObj  = document.form;
	switch(obj.name) {

	case "vndr_seq":
		if ( formObj.vndr_seq.value != null && formObj.vndr_seq.value != "" ) {
			doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC04);
		}
		break;

	case "loc_cd":
		if(formObj.loc_cd.value.length == 5){
			ComChkObjValid(obj);
			doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC05);
		}
		break;
	case "year_month":
		var strYear      = "";
		var strMonth     = "";
		var strYearMonth = formObj.year_month.value ;
		if(strYearMonth != null && strYearMonth.length == 6){
			if(strYearMonth != null && strYearMonth.length == 7){
				strYearMonth = strYearMonth.replaceStr("-" , "");
			}
			strYear  = strYearMonth.substring(0,4);
			strMonth = strYearMonth.substring(4);
			formObj.period_stdt.value = strYear + "-" + strMonth + "-01" ;
			formObj.period_eddt.value = strYear + "-" + strMonth + "-" + GetLastDay(strYear,strMonth);
		}
		break;
	}
}
/**
 * HTML Control의 키보드 이벤트 방 포멧처리 한다.
 */
function obj_keypress() {
	var obj = event.srcElement;
	switch(obj.dataformat) {
	case "ymd":
	case "ym":
	case "hms":
	case "hm":
	case "jumin":
	case "saupja":
	case "int":
		ComKeyOnlyNumber(obj);
		break;
	case "float":
		ComKeyOnlyNumber(obj, "-.");
		break;
	case "eng":
		ComKeyOnlyAlphabet();
		break;
	case "engup":
		if(obj.name == "loc_cd") {
            ComKeyOnlyAlphabet('uppernum');
    	}else{
    		ComKeyOnlyAlphabet('upper');
    	}
		break;
	case "engdn":
		ComKeyOnlyAlphabet('lower');
		break;
	default:
		ComKeyOnlyNumber(obj);
	break;
	}
}

/**
 * HTML Control의 클릭이벤트 처리한다.
 */
function obj_click() {
	var obj = event.srcElement;
	switch(obj.name) {
	    case "report_type":

	    if(document.form.report_type[0].selected == true){
			//by location
			sheetObjects[1].CellText(0,"location") = "LCC";
			sheetObjects[1].CellText(0,"agmt_no")  = "SCC";
			document.form.loc_cd.className   = "input";
			document.form.agmt_seq.className = "input1";

		}else if(document.form.report_type[1].selected == true){
			//by agreement
			sheetObjects[1].CellText(0,"location") = "LCC / SCC";
			sheetObjects[1].CellText(0,"agmt_no")  = "AGMT No.";
			document.form.loc_cd.className   = "input1";
			document.form.agmt_seq.className = "input";
		}
		break;
	}
}

/**
 * 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
 * @param sheetObj
 * @param ErrMsg
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with(sheetObj) {
		if(SearchRows > 1) {
			//합계 Title Merge 처리
			var strRows2 = ComFindAll(sheetObj, "location", "G.TTL");
			var arrStrRows2 = strRows2.split("|");

			for(var i = 0; i < arrStrRows2.length; i++) {
				var vRowIdx = parseInt(arrStrRows2[i]);
				//------------------------------------------------------------------
				//주)업무상 sheetObjects[1].RowHidden(lRow)= true; 후처리가 되어있슴
				// 자료의 Copy는 RowHidden 행을 제외하여 진행한다. - by 장준우(2010.06.30)
				//------------------------------------------------------------------
				CellAlign(vRowIdx +5, "div") = daCenter;

				for(var j = 0; j < LastCol; j++) {
					CellText(vRowIdx +5, j) = CellText(vRowIdx, j);
				}
			}
		}
	}
}

/**
 * sheet1_OnDblClick
 * 그리드 더블클릭시 이벤트 처리
 * SUMMARY 에 해당하는 DETAIL 조회
 */
function sheet1_OnDblClick(sheet_obj , Row, Col, CellX, CellY, CellW, CellH) {
	var formObj  = document.form;
	var sheetObject1 = sheetObjects[1];
	var sRow = sheetObject1.SelectRow ;
	var sCol = sheetObject1.SelectCol ;
	//if(sheetObjects[1].CellValue( sRow , "location") != "G.TTL"){
	    if(sheetObjects[1].CellValue( sRow , "div") != "Off-Hired"){
		    return;
	    }
	//}else{
	    //return;
	//}
	if(sCol > 4 ){
		formObj.detail_cntr_tp_sz.value  = sheetObject1.CellText(0 , sCol);
	}else{
		formObj.detail_cntr_tp_sz.value  = "";
	}
	if(document.form.report_type[0].selected == true){
		formObj.detail_rcc.value      = sheetObjects[1].CellValue( sRow , "agmt_no");
		formObj.detail_agmt_seq.value = "";
		formObj.detail_scc_cd.value   = sheetObjects[1].CellValue( sRow , "agmt_no");
	}else if(document.form.report_type[1].selected == true){
		formObj.detail_rcc.value      = "";
		formObj.detail_agmt_seq.value = sheetObjects[1].CellValue( sRow , "agmt_no").substring(3);
		formObj.detail_scc_cd.value   = sheetObjects[1].CellValue( sRow , "scc_cd");
	}

	sheetObjects[2].RemoveAll();
	doActionIBSheet(sheetObjects[2],document.form,IBSEARCH_ASYNC01);

}

/**
 * sheet1_OnMouseDown
 * 마우스가 눌러졌을때 발생하는 Event 처리
 * SUMMARY 에 해당하는 DETAIL 조회
 */
function sheet1_OnMouseDown(sheetObj , Button, Shift, X, Y) {
	var formObj  = document.form;
	var sheetObject1 = sheetObjects[1];
	var sRow = sheetObj.MouseRow  ;
	var sCol = sheetObj.MouseCol  ;

	if(sRow > sheetObj.HeaderRows && sRow == sheetObj.LastRow -2){
		//if(sheetObjects[1].CellValue( sRow , "location") != "G.TTL"){
		    if(sheetObjects[1].CellValue( sRow , "div") != "Off-Hired"){
			    return;
		    }
		//}else{
		    //return;
		//}
		if(sCol > 4 ){
			formObj.detail_cntr_tp_sz.value  = sheetObject1.CellText(0 , sCol);
		}else{
			formObj.detail_cntr_tp_sz.value  = "";
		}
		if(document.form.report_type[0].selected == true){
			formObj.detail_rcc.value      = sheetObjects[1].CellValue( sRow , "agmt_no");
			formObj.detail_agmt_seq.value = "";
			formObj.detail_scc_cd.value   = sheetObjects[1].CellValue( sRow , "agmt_no");
		}else if(document.form.report_type[1].selected == true){
			formObj.detail_rcc.value      = "";
			formObj.detail_agmt_seq.value = sheetObjects[1].CellValue( sRow , "agmt_no").substring(3);
			formObj.detail_scc_cd.value   = sheetObjects[1].CellValue( sRow , "scc_cd");
		}

		sheetObjects[2].RemoveAll();
		doActionIBSheet(sheetObjects[2],document.form,IBSEARCH_ASYNC01);
	}
}

/**
 * sheet TY/SZ 초기화 처리
 */
function sheetShowInit(){
	for(var i=0; i<arrTpSz2.length; i++){
		sheetObjects[1].ColHidden(arrTpSz2[i]) = false;
	}
	sheetObjects[1].SheetWidth = 984;
}

/**
 * HTML Control의 포커스 들어가는 이벤트에서 마스크 구분자를 제거한다.
 */
function obj_focus(){
	var obj  = event.srcElement;
	if( obj.readOnly ) {
		ComSetNextFocus(obj);
	} else {
		//마스크구분자 없애기
		ComClearSeparator(event.srcElement);
	}
}
/**
 * 마지막 일자 구하기
 */
function GetLastDay(yyyy, mm) {
	var m = parseInt(mm,10) - 1;
	var end = new Array(31,28,31,30,31,30,31,31,30,31,30,31);
	if ((yyyy % 4 == 0 && yyyy % 100 != 0) || yyyy % 400 == 0) {
		end[1] = 29;
	}
	return end[m];
}
 /**
 * Key-Down Event 처리
 */
 function obj_keydown() {
 	var obj      = event.srcElement;
 	var vKeyCode = event.keyCode;
 	var formObj  = document.form;
 	var srcObj  = window.event.srcElement;
 	if ( vKeyCode == 13 ) {
 		switch(obj.name) {
 		    case "aaa":
 		    default :
 			    if ( srcObj.style.filter == "" ) {
 				    sheetObjects[1].RemoveAll();
 				    sheetObjects[2].RemoveAll();
 				    doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
 			    }
 	    }
 	}
 }
/* 개발자 작업  끝 */