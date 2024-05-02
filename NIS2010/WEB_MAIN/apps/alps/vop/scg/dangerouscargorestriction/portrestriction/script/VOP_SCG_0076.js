/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_SCG_0076.js
*@FileTitle : DG Prohibition Summary by Port
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.07.30 장강철 jkc
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
 * @class VOP_SCG_0076 : VOP_SCG_0076 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_SCG_0076() {
	this.processButtonClick		= tprocessButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initControl            = initControl;
	this.doActionIBSheet 		= doActionIBSheet;
	this.setTabObject 			= setTabObject;
	this.validateForm 			= validateForm;
}

	/* 개발자 작업	*/

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

			case "btn_retrieve":
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			 break;

			 case "btn_Excel":
				 doActionIBSheet(sheetObjects[0],document.form,IBDOWNEXCEL);
			 break;

			 case "btn_new":
				 doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
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
 * IBTab Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++] = tab_obj;
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

	for (k = 0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
	}

	for(i=0;i<sheetObjects.length;i++){

		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet (sheetObjects[i] );

		initSheet(sheetObjects[i],i+1);

		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
}

function sheet1_OnLoadFinish(sheetObj) {
	doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
}

function initControl() {
	//Axon 이벤트 처리1. 이벤트catch(개발자변경)
	var formObj = document.form;
	formObj.imdg_clss_cd.DropHeight = 200;
	axon_event.addListener    ('keydown', 'ComKeyEnter', 'form');
	axon_event.addListenerForm('keypress', 'obj_keypress',    form  );
	axon_event.addListenerForm('keyup',    'obj_keyup',       form );
	axon_event.addListenerForm ('click',   'obj_click',       form );
	axon_event.addListenerForm ('blur',   'obj_blur',       form );
	axon_event.addListener    ('click',   'img_click',    "srch_port_cd");
	axon_event.addListener    ('click',   'img_click',    "btn_retrieve");
	axon_event.addListener    ('click',   'img_click',     "srch_imdg_un_no");

	// IBMultiCombo초기화
	for(var k=0; k<comboObjects.length; k++){
	  initCombo(comboObjects[k], k + 1);
	}

	ComEnableObject( formObj.imdg_un_no, false);
	ComEnableObject( document.all.srch_imdg_un_no, false);
}

/**
* 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
* @param {IBMultiCombo} combo_obj    IBMultiCombo Object
**/
function setComboObject(combo_obj){
	comboObjects[comboCnt++] = combo_obj;
}

/**
 * Tab 기본 설정
 * 탭의 항목을 설정한다.
 */
function initTab(tabObj, tabNo) {
	switch (tabNo) {
		case 1:
			with (tabObj) {

				var cnt = 0;
				InsertTab(cnt++, "Prohibition", -1);
				InsertTab(cnt++, "Restriction", -1);
			}
			break;
	}
}

/**
 * Combo 기본 설정
 * Combo의 항목을 설정한다.
 */
function initCombo(comboObj, comboNo) {
	switch(comboObj.id) {
		case "imdg_clss_cd":

			with(comboObj) {
				SetTitle("Class|Definition");
				SetColWidth("50|700")
				DropHeight = 190;
				MultiSelect = false;
				MaxSelect = 1;
				UseAutoComplete = true;
			}
			break;
	}
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
				style.height = 395;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msAll;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 2, 1, 3, 100);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false, false);

				var HeadTitle = "Port|Class|UN No./Seq| |Registered\non Restriction|Prohibition|Prohibition|Prohibition|Prohibition|Prohibition|Prohibition|Prohibition|Prohibition|";
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]

				var HeadTitle1 = "Port|Class| | |Registered\non Restriction|Load|Discharge|T/S|Pass|Day Time\nOperation|Day Time\nIn-Land Transit|In-port\nOperation|Night Time\nOperation|";
				InitColumnInfo(HeadTitle.split("|").length, 0, 0, true);
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				InitHeadRow(1, HeadTitle1, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

				InitDataProperty(0, cnt++ , dtData,    65,    daCenter,  true,    "port_cd");
				InitDataProperty(0, cnt++ , dtData,    40,    daCenter,  true,   "imdg_clss_cd"             , false,      "",      dfNone,      0,     true,    true);
				InitDataProperty(0, cnt++ , dtData,   60,    daCenter,  false,    "imdg_un_no"              , false,      "",      dfNone,      0,     true,    true);
				InitDataProperty(0, cnt++ , dtData,   30,    daCenter,  false,    "imdg_un_no_seq"          , false,      "",      dfNone,      0,     true,    true);
				InitDataProperty(0, cnt++ , dtData,   90,    daCenter,  false,    "restric_regyn"           , false,      "",      dfNone,      0,     true,    true);
				InitDataProperty(0, cnt++ , dtData,   79,    daCenter,  false,    "prohi_lod_flg"           , false,      "",      dfNone,      0,     true,    true);
				InitDataProperty(0, cnt++ , dtData,   79,    daCenter,  false,    "prohi_dchg_flg"          , false,      "",      dfNone,      0,     true,    true);
				InitDataProperty(0, cnt++ , dtData,   79,    daCenter,  false,    "prohi_ts_flg"            , false,      "",      dfNone,      0,     true,    true);
				InitDataProperty(0, cnt++ , dtData,   79,    daCenter,  false,    "prohi_pass_flg"          , false,      "",      dfNone,      0,     true,    true);
				InitDataProperty(0, cnt++ , dtData,   96,    daCenter,  false,    "prohi_dy_tm_op_flg"      , false,      "",      dfNone,      0,     true,    true);
				InitDataProperty(0, cnt++ , dtData,   96,    daCenter,  false,    "prohi_dy_tm_inlnd_tz_flg", false,      "",      dfNone,      0,     true,    true);
				InitDataProperty(0, cnt++ , dtData,   96,    daCenter,  false,    "prohi_port_flg"          , false,      "",      dfNone,      0,     true,    true);
				InitDataProperty(0, cnt++ , dtData,   59,    daCenter,  false,    "prohi_ngt_flg"           , false,      "",      dfNone,      0,     true,    true);
				InitDataProperty(0, cnt++ , dtHidden, 96,    daCenter,  false,    "unno_exist_yn"           , false,      "",      dfNone,      0,     true,    true);

				RowMerge(1) = true;

				SetMergeCell(0, 2, 2, 2);
				SetMergeCell(0, 4, 2, 1);
				CellFont("FontBold", 0, 1, 0, 4) = true;

				ColHidden("imdg_un_no")     = true;
				ColHidden("imdg_un_no_seq") = true;
			}
			break;

		case 2:      //t1sheet2 init
			with (sheetObj) {

				// 높이 설정
				style.height = 395;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msAll;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 2, 1, 3, 100);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false, false);

				var HeadTitle = "Port|Class|UN No./Seq| |Registered\non Restriction|Restriction|Restriction|Restriction|Restriction|Restriction|Restriction|Restriction|Restriction";
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]

				var HeadTitle1 = "Port|Class|UN No./Seq | |Registered\non Restriction|Load|Discharge|T/S|Pass|Load|Discharge|T/S|Pass";
				InitColumnInfo(HeadTitle.split("|").length, 0, 0, true);
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				InitHeadRow(1, HeadTitle1, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

				InitDataProperty(0, cnt++ , dtData,   65,    daCenter,  true ,    "port_cd");
				InitDataProperty(0, cnt++ , dtData,   40,    daCenter,  true ,    "imdg_clss_cd"            , false,      "",      dfNone,      0,     true,    true);
				InitDataProperty(0, cnt++ , dtData,   60,    daCenter,  false,    "imdg_un_no"              , false,      "",      dfNone,      0,     true,    true);
				InitDataProperty(0, cnt++ , dtData,   30,    daCenter,  false,    "imdg_un_no_seq"          , false,      "",      dfNone,      0,     true,    true);
				InitDataProperty(0, cnt++ , dtData,   90,    daCenter,  false,    "restric_regyn"           , false,      "",      dfNone,      0,     true,    true);
				InitDataProperty(0, cnt++ , dtData,   79,    daCenter,  false,    "load_type"               , false,      "",      dfNone,      0,     true,    true);
				InitDataProperty(0, cnt++ , dtData,   79,    daCenter,  false,    "discharge"               , false,      "",      dfNone,      0,     true,    true);
				InitDataProperty(0, cnt++ , dtData,   79,    daCenter,  false,    "ts"                      , false,      "",      dfNone,      0,     true,    true);
				InitDataProperty(0, cnt++ , dtData,   79,    daCenter,  false,    "pass"                    , false,      "",      dfNone,      0,     true,    true);
				InitDataProperty(0, cnt++ , dtData,   96,    daLeft  ,  false,    "load_type_desc"          , false,      "",      dfNone,      0,     true,    true);
				InitDataProperty(0, cnt++ , dtData,   96,    daLeft  ,  false,    "discharge_desc"          , false,      "",      dfNone,      0,     true,    true);
				InitDataProperty(0, cnt++ , dtData,   96,    daLeft  ,  false,    "ts_desc"                 , false,      "",      dfNone,      0,     true,    true);
				InitDataProperty(0, cnt++ , dtData,   59,    daLeft  ,  false,    "pass_desc"               , false,      "",      dfNone,      0,     true,    true);

				RowMerge(1) = true;

				SetMergeCell(0, 2, 2, 2);
				SetMergeCell(0, 4, 2, 1);
				CellFont("FontBold", 0, 1, 0, 4) = true;

				ColHidden("imdg_un_no")     = true;
				ColHidden("imdg_un_no_seq") = true;
			}
			break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	
	switch(sAction) {
		case   IBCLEAR:      //초기화 1. Class Combo 가져오기
			formObj.f_cmd.value = SEARCH02;      //SEARCH02      searchUNClass
			var param =  FormQueryString(formObj);
			var sXml  =  sheetObj.GetSearchXml("SCG_COM_INTERNALGS.do", param);
			ComXml2ComboItem( sXml, formObj.imdg_clss_cd, "imdg_clss_cd","imdg_clss_cd|imdg_clss_cd_desc" );
			formObj.port_cd.focus();
			break;

		case  IBSEARCH:      //조회
			
			switch (beforetab){
				case 0 :
					doActionIBSheet(sheetObjects[0], formObj, "IBSEARCH01");
					break;
				case 1 :
					doActionIBSheet(sheetObjects[1], formObj, "IBSEARCH02");
					break;
			}
			break;
			
		case  "IBSEARCH01":      //Prohibition 조회
			if(!validateForm(sheetObj, formObj, sAction)){
				return;
			}
			formObj.f_cmd.value = SEARCH01;
			var param =  FormQueryString(formObj);
			sheetObj.DoSearch("VOP_SCG_0076GS.do", param );
			fnSetFont(sheetObj);
			//UNNO_EXIST_YN
			break;

		case  "IBSEARCH02":      //Restriction 조회
			if(!validateForm(sheetObj,formObj,sAction)){
				return;
			}
			formObj.f_cmd.value = SEARCH02;
			var param =  FormQueryString(formObj);
			sheetObj.DoSearch("VOP_SCG_0076GS.do", param );
			fnSetFont(sheetObj);
			//UNNO_EXIST_YN
			break;
			
		case  IBSEARCH_ASYNC01:      //조회   PORT_NM구하기
			formObj.f_cmd.value = SEARCH09;
			var aryPrefix       =  new Array("sheet1_");
			var param           =  FormQueryString(formObj) +"&" + ComGetPrefixParam( aryPrefix );
			var sXml            =  sheetObj.GetSearchXml("SCG_COM_EXTERNALGS.do", param);
			var port_cd_nm      =  ComGetEtcData(sXml,"port_cd_nm");   //port_cd_nm
			var msg = ComScgGetMessageFromXml(sXml);
			if( msg != "" ){
				ComShowMessage( msg);
				formObj.port_cd.value = "";
				formObj.port_cd_nm.value = "";
				formObj.port_cd.focus();
			}else{
				document.form.port_cd_nm.value = port_cd_nm;
				formObj.imdg_clss_cd.focus();
			}
			break;

		case IBSEARCH_ASYNC02:  //CheckUnNumber
			formObj.f_cmd.value = SEARCH01;
			var param =  FormQueryString(formObj) ;
			var sXml  =  sheetObj.GetSearchXml("SCG_COM_INTERNALGS.do", param);
			var sTotal = ComScgGetTotalValue(sXml);

			if( sTotal == "0"){
				ComShowCodeMessage("SCG50010", 'Data');
				formObj.imdg_un_no.value = "";
				formObj.imdg_un_no.focus();
			}
			break;

		case IBDOWNEXCEL:      // 삭제
			var paramObj = new Object();
			paramObj.title = "DG Prohibition Summary by Port";
			if (formObj.optclass[0].checked == true) {
				paramObj.cols = "11";
				paramObj.columnwidth = "1:10|2:10|3:10|4:10|5:10|6:10|7:10|8:12|9:12|10:12|11:12";
			}else{
				paramObj.cols = "13";
				paramObj.columnwidth = "1:10|2:7|3:7|4:5|5:10|6:10|7:10|8:10|9:10|10:10|11:10|12:10|13:10";
			}
			paramObj.datarowheight   = "1:25";
			var url = ComScgGetPgmTitle(sheetObj, paramObj);
			sheetObj.SpeedDown2Excel(-1, false, false, "", url, false, false, "", false, "", "", false, "", true );
			break;

		case IBINSERT:      // 입력
			fnNewGrid();
			formObj.port_cd.value      = "";
			formObj.port_cd_nm.value   = "";
			formObj.imdg_clss_cd.Code2 = "";
			formObj.port_cd.focus();
			formObj.imdg_un_no.value = "";
			break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction){

	switch ( sAction ){
		case IBSEARCH:
			if( !ComChkValid(formObj) ){
				return false;
			}
		break;
	}
	return true;
}

function img_click(){
	 var obj = event.srcElement;
	 var formObj = document.form;
	 if(obj.name == "srch_port_cd"){
			 var port_cd = document.form.port_cd.value;
			  ComOpenPopup('/hanjin/VOP_VSK_0043.do?port_cd='+port_cd, 427, 520, "setPortNm", "0,0", true);
	 }
	 if(obj.name == "srch_imdg_un_no"){
		 if( obj.className == ""){
			  return;
		 }
		 var imdg_un_no = formObj.imdg_un_no.value;
		 ComOpenPopup("/hanjin/VOP_SCG_3005.do?imdg_un_no="+imdg_un_no,940, 420, "setUnnoAndClassCd", "0,1,1,1,1,1,1,1,1,1", true,false);
	}
}

/**
 * Unno Help 팝업으로 Unno, seq, ClassCd 구하기
 * @param  {Array} aryPopupData  필수   Array Object
 * @param  {Int} row             선택 선택한 Row
 * @param  {Int} col             선택 선택한 Column
 * @param  {Int} sheetIdx        선택 Sheet Index
 * @return 없음
 */
function setUnnoAndClassCd(aryPopupData){
	  with(document.form){
		imdg_un_no.value     = aryPopupData[0][2];
	}
}

/**
 * @param  {Array} aryPopupData 필수   Array Object
 * @return 없음
 */
function setPortNm(aryPopupData){
	var formObject = document.form;
	formObject.port_cd.value = aryPopupData[0][2];
	formObject.port_cd_nm.value = aryPopupData[0][3];
}

/**
 *
 */
function obj_keypress(){
	obj = event.srcElement;
	var formObj = document.form;
	switch(obj.name ) {
		case "port_cd":
			ComKeyOnlyAlphabet('uppernum');
			break;

		case "imdg_un_no":
			ComKeyOnlyNumber(obj);
			break;

	} // end switch
}

/**
 * Form 내의 Object Onkeyup 이벤트시 처리.
 *
 * @return void
 */
function obj_keyup(){
	obj = event.srcElement;
	var formObj = document.form;

	switch(obj.name ) {

		case "port_cd"://Un No 또는 Seq 입력시 prp_shp_nm 가져오기
			if( formObj.port_cd.value.length  == 5    ){
				formObj.port_cd_nm.value = "";
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
			} else {
				formObj.port_cd_nm.value = "";
				formObj.imdg_clss_cd.Code2 = "";
				fnNewGrid();
			}
			break;

		case 'imdg_un_no':
			fnNewGrid();
			if( formObj.imdg_un_no.value.length == 4  ){
				doActionIBSheet(sheetObjects[0], formObj,IBSEARCH_ASYNC02);
			}
			break;
   } // end switch
}

/**
 * Form Object  OnChange 이벤트 처리.
 * @param  void
 * @return void
 */
function obj_click(){
	obj = event.srcElement;
	var formObj = document.form;
	var doc     = document.all;

	switch(obj.name ) {
		case "optclass":
			if(obj.value == "class"){

				formObj.imdg_clss_cd.Enable = true;
				ComEnableObject( formObj.imdg_un_no, false);
				ComEnableObject( document.all.srch_imdg_un_no, false);

				sheetObjects[0].ColHidden("imdg_un_no")     = true;
				sheetObjects[0].ColHidden("imdg_un_no_seq") = true;
				sheetObjects[1].ColHidden("imdg_un_no")     = true;
				sheetObjects[1].ColHidden("imdg_un_no_seq") = true;
				fnNewGrid();
			}

			if(obj.value == "unno"){
				formObj.imdg_clss_cd.Enable = false;
				ComEnableObject( formObj.imdg_un_no, true);
				ComEnableObject( document.all.srch_imdg_un_no, true);
				formObj.imdg_un_no.focus();
				sheetObjects[0].ColHidden("imdg_un_no")     = false;
				sheetObjects[0].ColHidden("imdg_un_no_seq") = false;
				sheetObjects[1].ColHidden("imdg_un_no")     = false;
				sheetObjects[1].ColHidden("imdg_un_no_seq") = false;
				fnNewGrid()
			}
			formObj.imdg_clss_cd.Code2 = "";
			break;
	} // end switch
}

/**
 *
 * <pre>
 *    Grid 데이타 크리어
 * </pre>
 *
 * @param
 * @return
 * @author jang kang cheol
 */
function fnNewGrid(){
	for(var i=0; i<sheetObjects.length; i++){
		sheetObjects[i].RemoveAll();
	}
//	var cnt = sheetObjects[0].RowCount;
//	var formObj  = document.form;
//
//	for(var j=1;j<= cnt;j++ ){
//		sheetObjects[0].RowDelete(2, false);
//	}
}

function obj_blur(){
	var obj = event.srcElement;
	var formObj = document.form;

	switch (obj.name){
		case "port_cd":
			 if( formObj.port_cd.value !=""   ){
				 if( !ComChkValid(formObj) ){
					 obj.focus();
					 obj.select();
					 return;
				 }
				 return;
			 }
			 break;
	}
}

/**
 *
 * <pre>
 *     조회후 ClassNo에, Unno가 등록되어있을경우, Bold 와 Red Font Color 사용
 * </pre>
 *
 * @param
 * @return
 * @author jang kang cheol
 */
function fnSetFont(sheetObj){
	for(var i=0;i<sheetObj.RowCount;i++){
		if( sheetObj.CellValue(i+sheetObj.HeaderRows,"unno_exist_yn") == "Y" ){
			sheetObj.CellFontColor( i+sheetObj.HeaderRows  , "imdg_clss_cd") = sheetObj.RgbColor(255, 0, 0);

			//alert( sheetObj.RgbColor(255, 0, 0)  );
			sheetObj.CellFont("FontBold", i+sheetObj.HeaderRows, "imdg_clss_cd") = true;
		}
	}
}

/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnChange(tabObj, nItem) {
	var objs = document.all.item("tabLayer");

	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";

	//--------------- 요기가 중요 --------------------------//
	objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
	//------------------------------------------------------//
	beforetab = nItem;
}


function sheet2_OnMouseMove(Button, Shift, X, Y) {

	if(sheetObjects[1].MouseRow > 1 && sheetObjects[1].MouseCol > 8){
		//alert(sheetObjects[1].MouseRow + ", " + sheetObjects[1].MouseCol);
		var sText = sheetObjects[1].CellValue(sheetObjects[1].MouseRow, sheetObjects[1].MouseCol);
		sheetObjects[1].MouseToolTipText = sText;
	}
}

/* 개발자 작업  끝 */