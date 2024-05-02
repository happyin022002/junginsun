/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_CGM_1152.js
 *@FileTitle : On-Hire Report Summary By Month
 *Open Issues :
 *Change history :
 *LastModifyDate : 2011.05.23
 *LastModifier : NK Jin-Ho
 *LastVersion : 1.0
* 2011.05.23 NK Jin-Ho
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
 * @class EES_CGM_1152 : EES_CGM_1152 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function EES_CGM_1152() {
	this.processButtonClick		= tprocessButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initControl            = initControl;
	this.doActionIBSheet 		= doActionIBSheet;
	this.setTabObject 			= setTabObject;
	this.validateForm 			= validateForm;
	this.combo1_OnCheckClick 	= combo1_OnCheckClick;
	this.combo1_OnBlur 		    = combo1_OnBlur;
	this.combo1_OnKeyDown 		= combo1_OnKeyDown;
}

/* 개발자 작업	*/
//공통전역변수
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
	axon_event.addListenerForm('keydown', 'obj_keydown',  formObj);   //- 키 눌렸을때
}

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	/*******************************************************/
	var formObject = document.form;

	try {
		var srcObj  = window.event.srcElement;
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

		case "btn_DownExcel":
			sheetObject1.SpeedDown2Excel(-1);
			break;

		case "btn_Retrieve":
			if ( srcObj.style.filter == "" ) {
				sheetObject1.RemoveAll();
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			}
			break;

		case "btn_New":
			sheetObject1.RemoveAll();
			formObject.period_stdt.value = "";
			formObject.period_eddt.value = "";
			formObject.loc_tp[0].selected = true;
			formObject.crnt_loc_cd.value = "";
			document.form.crnt_loc_cd.readOnly = true;
			document.form.crnt_loc_cd.className = "input2";
			ComEnableObject(document.form.btns_search1, false);
			formObject.term_change[1].selected = true;
			formObject.dii[0].selected = true;
			formObject.np[0].selected = true;
			for(var i = 1 ; i < comboObjects[0].GetCount(); i++ ){
				comboObjects[0].CheckIndex(i)=false;
			}
			formObject.lstm_cd.value = "";
			comboObjects[0].CheckIndex(0) = true;
			break;


		case "btns_calendar2":
			if ( srcObj.style.filter == "" ) {
				var cal = new ComCalendarFromTo();
				cal.select(formObject.period_stdt, formObject.period_eddt, 'yyyy-MM-dd');
			}
			break;
		case "btns_search1":      // loc_cd
		if ( srcObj.style.filter == "" ) {

			openPopup("1");

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
	doActionIBSheet(sheetObjects[0], document.form,IBCREATE);
	initSheet(sheetObjects[0],1);
	doActionIBSheet(sheetObjects[0], document.form,IBSEARCH_ASYNC03);
	comboObjects[0].CheckIndex(0) = true;
	document.form.period_stdt.focus();
	document.form.crnt_loc_cd.readOnly = true;
	document.form.crnt_loc_cd.className = "input2";
	ComEnableObject(document.form.btns_search1, false);
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
			style.height = 403;
			//전체 너비 설정
			SheetWidth = 984;//mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 2, 10, 100);
			var HeadTitleTemp  = "";
			for(var i=0; i<arrTpSz.length; i++){
				HeadTitleTemp = HeadTitleTemp + "|" + arrTpSz[i];
			}

			var HeadTitle = "|Month" + HeadTitleTemp + "|G.TTL|Ratio|";
			var headCount = ComCountHeadTitle(HeadTitle);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, false, true, false,false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			for(var i = 0; i < 2; i++) {
    			cnt = 0;
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(i, cnt++ , dtHiddenStatus,     0,     daCenter, true,  "Status");
				InitDataProperty(i, cnt++ , dtData,             80,    daCenter, true,  "ym",         false,  "",     dfNone);
				for(var j=0; j<arrTpSz2.length; j++){
					InitDataProperty(i, cnt++ , dtData,             70,    daRight,  true,  arrTpSz2[j] + "",          false,  "",     dfNone,   0,  false,    true);
				}
				InitDataProperty(i, cnt++ , dtData,             90,    daRight,  true,  "div_total",   false,  "",     dfNone,   0,  false,    true);
				InitDataProperty(i, cnt++ , dtData,             90,    daRight,  true,  "ratio",       false,  "",     dfNone,   0,  false,    true);
				InitDataProperty(i, cnt++ , dtAutoSum,          50,    daRight,  true,  "auto_sum",    false,  "",     dfNone,   0,  false,    true);
			}

			//-----------------------------------------------------------------------------------------------
			//[주의] ColHidden("auto_sum") = true; 설정시 동적 Header D5에 대한 Hidden 처리현상 발생
			// 오류를 회피하기 위하여 강제로 모든 Column에 대하여 ColHidden 메서드로 재정의한다. - by 장준우(2010.06.29)
			//-----------------------------------------------------------------------------------------------
			for(var j = 1; j <= LastCol; j++) {
				ColHidden(j) = (j == LastCol);
			}

			SelectBackColor = CGM_SELECT_BACK_COLOR;
			CountPosition   = 0;
			FrozenCols = 2;
		}
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

			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			var sXml = sheetObj.GetSearchXml("EES_CGM_1152GS.do", FormQueryString(formObj));

			if(ComGetTotalRows(sXml) > 2) {
				sheetObj.LoadSearchXml(sXml);

				var ratio     = "";
				var div_total = "";
				for(var i=0; i < arrTpSz2.length; i++){
					ratio = sheetObj.CellValue( sheetObj.LastRow  ,  arrTpSz2[i] );
					sheetObj.CellValue( sheetObj.LastRow ,  arrTpSz2[i] ) = ratio + "%";
				}
				if(sheetObj.RowCount > 0){
					div_total = sheetObj.CellValue( sheetObj.LastRow  , "div_total" );
					sheetObj.CellValue( sheetObj.LastRow ,  "div_total" ) = div_total + ".00%";
					sheetObj.CellValue( sheetObj.LastRow ,  "ratio" )     = "";

					var gttlRow  = sheetObjects[0].FindText(1, "G.TTL");
					var ratioRow = sheetObjects[0].FindText(1, "Ratio");
				}
			} else {
				sheetObj.LoadSearchXml("<SHEET><DATA TOTAL='0'></DATA></SHEET>");
			}

			ComOpenWait(false);
		}
	break;

	case IBCREATE:
		formObj.f_cmd.value = SEARCH04;
		formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
		var sStr = ComGetEtcData(sXml,"comboList");
		var arrStr = sStr.split("@");
		var arrTpSzCd ="";
		
		for (var i = 0; i < arrStr.length;i++ ) {
			var TpSzCd = arrStr[i].split("|");
			if (i == arrStr.length -1){
				arrTpSzCd = arrTpSzCd+TpSzCd[0];
			}else{
				arrTpSzCd = arrTpSzCd+TpSzCd[0]+",";
			}
       }
		arrTpSz   =  arrTpSzCd.split(",");
		arrTpSz2  =  arrTpSzCd.toLowerCase().split(",");
		formObj.arr_tpsz_cd.value =arrTpSzCd;
       	break;  

	case IBSEARCH_ASYNC03:
		formObj.f_cmd.value = SEARCH;
       	formObj.intg_cd_id.value = COM_CD_TYPE_CD01948;		// 코드Type 설정 ( AGREEMENT LEASE TERM CODE )
   		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
   			    			
   		var sStr = ComGetEtcData(sXml,"comboList");    			
   		var arrStr = sStr.split("@");
   		
  		makeComboObject(comboObjects[0], arrStr, 0, 0, 0);
  		comboObjects[0].InsertItem(0 , 'ALL','ALL');
  		comboObjects[0].Text ='ALL';
       	break;
       	
	case IBSEARCH_ASYNC05:	// Location 조회
		formObj.f_cmd.value = SEARCH17;
		var location =document.getElementById("loc_tp").value;
	
		if(location == "R")
		{
			formObj.eq_orz_cht_chktype.value = "RCC";
			formObj.eq_orz_cht_rcc_cd.value = formObj.crnt_loc_cd.value;
		}else if(location == "L")
		{
			formObj.eq_orz_cht_chktype.value = "LCC";
			formObj.eq_orz_cht_lcc_cd.value = formObj.crnt_loc_cd.value;
		}else if(location == "S")
		{
			formObj.eq_orz_cht_chktype.value = "SCC";
			formObj.eq_orz_cht_scc_cd.value = formObj.crnt_loc_cd.value;
		}else
		{
			formObj.eq_orz_cht_chktype.value = "";
			formObj.eq_orz_cht_scc_cd.value = "";
		}
		
		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
			// 데이터 건수
	    var dataCount = ComGetTotalRows(sXml);
	    if(dataCount==0){
	    	ComShowCodeMessage('CGM10009','location cd');
	   		formObj.crnt_loc_cd.value = "";
	    }
	    formObj.crnt_loc_cd.focus(); //validation후 focus는 location으로 가게 만든다. 
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
			case IBSEARCH:      //저장

			var periodStdt = formObj.period_stdt.value;
			periodStdt = periodStdt.replaceStr("-","");
			var periodEtdt = formObj.period_eddt.value;
			periodEtdt = periodEtdt.replaceStr("-","");
			if ( periodStdt == "" ) {
				ComShowCodeMessage("CGM20039");
				ComSetFocus(formObj.period_stdt);
				return false;
				break;
			}
			if ( periodEtdt == "" ) {
				ComShowCodeMessage("CGM20040");
				ComSetFocus(formObj.period_eddt);
				return false;
				break;
			}
			if ( Number(periodStdt) >= Number(periodEtdt)) {
				ComShowCodeMessage("CGM20041");
				formObj.period_eddt.value = "";
				ComSetFocus(formObj.period_eddt);
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
 		    sheetObjects[0].RemoveAll();
 			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}
	}
}


/**
* HTML Control의 Value가 변경되었을 경우 처리한다.
*/
function obj_change(){
	var obj      = event.srcElement;
	var formObj  = document.form;
	//if ( ComTrim(ComGetObjValue(obj)) != "" ) {
	switch(obj.name) {
	case "period_stdt":		//Location Code
	if(formObj.period_eddt.value != ""){
		checkEffectiveDate( formObj.period_stdt , formObj.period_eddt ) ;
	}
	break;

	case "period_eddt":		//Location Code
	if(formObj.period_stdt.value != ""){
		checkEffectiveDate( formObj.period_stdt , formObj.period_eddt ) ;
	}
	break;
	case "crnt_loc_cd":		//Location Code
	if ( ComTrim(obj.value) != "" ) {
		if(document.form.loc_tp.value == "R" || document.form.loc_tp.value == "L" || document.form.loc_tp.value == "S"){
			doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC05);
		}
	}
	break;
	case "loc_tp":		//Location Type
	formObj.crnt_loc_cd.value = "";
	
	formObj.crnt_loc_cd.readOnly = false;
	formObj.crnt_loc_cd.className = "input";
	ComEnableObject(formObj.btns_search1, true);
	if(obj.value == "R"){
		formObj.crnt_loc_cd.maxLength = 5;
	}else if(obj.value == "L"){
		formObj.crnt_loc_cd.maxLength = 5;
	}else if(obj.value == "S"){
		formObj.crnt_loc_cd.maxLength = 5;
	}else{
		formObj.crnt_loc_cd.maxLength = 5;
	}
	ComSetNextFocus(obj);
	break;
	}
//}
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
		if(obj.name == "crnt_loc_cd") {
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
* HTML Control의 포커스 들어가는 이벤트에서 마스크 구분자를 제거한다.
*/
function obj_focus(){
	var obj  = event.srcElement;
	if( obj.readOnly ) {
		ComSetNextFocus(obj);
	} else {
		//마스크구분자 없애기
		if(obj.name == "period_stdt" ||  obj.name == "period_eddt"){
		    if(obj.value.length == 10 ){
		        ComClearSeparator(event.srcElement);
		    }
		}
	}
}
/**
* sheet1_OnSearchEnd
* 그리드 조회 후 이벤트 처리
*/
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with(sheetObj) {
		if(SearchRows > 0) {
			for(var i = LastRow -2; i > LastRow -4; i--) {
				for(var j = 0; j < LastCol; j++) {
					CellText(i +2, j) = CellText(i, j);
				}
			}

			sheetObj.RowDelete(LastRow -3, false);
			sheetObj.RowDelete(LastRow -2, false);
			sheetObj.CellValue2(LastRow -1, "rcc") = "G.TTL";
			sheetObj.CellValue2(LastRow, "rcc") = "Ratio";
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
		switch(formObj.loc_tp.value) {
		case "R" :	//RCC
		ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430,"rcc_cd:crnt_loc_cd", "1,0,1,1,1,1,1", true);
		break;
		case "L" :	//LCC
		ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430,"lcc_cd:crnt_loc_cd", "1,0,1,1,1,1,1", true);
		break;
		case "S" :	//SCC
		ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430,"scc_cd:crnt_loc_cd", "1,0,1,1,1,1,1", true);
		break;

		default : 	//do nothing
		}

	}
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
				    sheetObjects[0].RemoveAll();
				    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			    }
	    }
	}
}
/* 개발자 작업  끝 */