/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_gem_0008_03.js
 *@FileTitle : Expense Office Maintenance - Office Matrix per Office
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.27
 *@LastModifier : 최정미
 *@LastVersion : 1.0
 * 2009.05.27 최정미
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
 * @author CLT
 */

/**
 * @extends
 * @class Expense Matrix per Office : Expense Matrix per Office 생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function cps_gem_0008_03(){
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.doActionIBSheet = doActionIBSheet;
	this.initControl = initControl;
	this.validateForm = validateForm;
	
	// add
	this.setComboObject = setComboObject;
	this.initCombo = initCombo;
	this.obj_keypress = obj_keypress;
	this.obj_deactivate = obj_deactivate;
	this.obj_activate = obj_activate;
	
	this.initProperty = initProperty;
	this.newButtonClear = newButtonClear;
	this.isOfficeGubun = isOfficeGubun;
	this.isLangCheck = isLangCheck;
	this.isDeltFlg = isDeltFlg;
	
	// sheet
	this.sheet1_OnClick = sheet1_OnClick;
}

/* 개발자 작업 */

//===================================================================================
//공통전역변수
//===================================================================================
var sheetObjects = new Array();
var sheetCnt = 0;

var sheet1 = null;

var frm = null;

//IBMultiCombo
var comboObjects = new Array();
var combo1 = null;
var comboCnt = 0;

/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
* 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
* @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
**/
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}

//===================================================================================
//초기화 
//===================================================================================
/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
	frm = document.form;
	sheet1 = sheetObjects[0];
	sheetCnt = sheetObjects.length ;
	
	for(i=0;i<sheetCnt;i++){		
		//khlee-시작 환경 설정 함수 이름 변경
        ComConfigSheet (sheetObjects[i] );

        initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
        ComEndConfigSheet(sheetObjects[i]);
	}

	// combo
	combo1 = comboObjects[0];
	comboCnt = comboObjects.length;
	
    // IBMultiCombo초기화
	for ( var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k]);
	}	
	
	// html컨트롤 이벤트초기화
    initControl();
	
	 //iframe 사이즈 자동조절
	 resizeIframe("t3frame");
}

/**
 * 화면 깜빡임 제거 하면서 로드시 초기Data조회
 * @param sheetObj
 * @return
 */
function sheet1_OnLoadFinish(sheetObj) {
	sheetObj.WaitImageVisible = false;
	
	// 초기속성 지정
	initProperty(IBSEARCH);
		
	// 초기Data조회
	doActionIBSheet(IBSEARCH);

	doActionIBSheet(sheetObj, document.form, IBCLEAR);
	sheetObj.WaitImageVisible = true;
}

/**
* 콤보 초기설정값
* @param {IBMultiCombo} comboObj  comboObj
*/
function initCombo(comboObj) {
	comboObj.MultiSelect = false;
	comboObj.UseCode = true;
	comboObj.LineColor = "#ffffff";
	comboObj.SetColAlign("left|left");
	comboObj.MultiSeparator = ",";
	comboObj.DropHeight = 200;
}

/**
* 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
* 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
*/
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetObj.id) {

	case "sheet1":
		with (sheetObj) {

			// 높이 설정
			style.height = 400;

			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 18, 100);

			var HeadTitle1 = "|Select|From Office|TO Office|Expense Group|Expense Code|Expense Name|Creator ID|DELT_FLG";

			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	60,		daCenter,	true,		"ibflag");
			InitDataProperty(0, cnt++ , dtCheckBox,		0,		daCenter,	true,		"delChk",		false,		"",			dfNone);
			
			InitDataProperty(0, cnt++ , dtCombo,		100,	daCenter,	true,		"snd_ofc_cd",		true,		"",			dfNone);
			InitDataProperty(0, cnt++ , dtCombo,		100,	daCenter,	true,		"rcv_ofc_cd", 		true,		"",			dfNone);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"gen_expn_cd_grp",	false,		"",			dfNone);
			InitDataProperty(0, cnt++ , dtCombo,		100,	daCenter,	true,		"gen_expn_cd",		true,		"",			dfNone);
			InitDataProperty(0, cnt++ , dtData,			400,	daLeft,		true,		"gen_expn_nm", 		false,		"",			dfNone);
			InitDataProperty(0, cnt++ , dtData,			0,		daCenter,	true,		"cre_usr_id",		false,		"",			dfNone);
			
			InitDataProperty(0, cnt++ , dtHidden, 		60, 	daCenter, 	true,		"delt_flg", 	false, "", dfNone);
			
			//InitDataCombo(0, "From", "SELAGA|SELCOL|SELPLP|SELFAC|SELFMP|SELPLS", "SELAGA|SELCOL|SELPLP|SELFAC|SELFMP|SELPLS",	"", "", 0);
			//InitDataCombo(0, "TO", "SELFAC|SELFAC|SELAGP|All", "SELFAC|SELFAC|SELAGP|All",	"", "", 0);
			//InitDataCombo(0, "Group", "910000|920000|930000|All", "910000|920000|930000|All",	"", "", 0);
			//InitDataCombo(0, "Code", "240601|223705|223402|All", "240601|223705|223402|All",	"", "", 0);
		}
		break;
	}
}

//Sheet관련 프로세스 처리
function doActionIBSheet(sAction){
	switch (sAction) {
		case IBSEARCH: // OPEN	  		
			frm.f_cmd.value = SEARCH;
			var sXml = sheet1.GetSearchXml("CPS_GEM_0008_03GS.do", FormQueryString(frm));
			var arrXml = sXml.split("|$$|");
			
			var fromListData = ComGetEtcData(arrXml[0], "searchFromList");
			var toListData = ComGetEtcData(arrXml[0], "searchToList");
			sheet1.InitDataCombo(0, "snd_ofc_cd", fromListData, fromListData,	"", "", 0);
			sheet1.InitDataCombo(0, "rcv_ofc_cd", toListData, toListData,	"", "", 0);
			
			var langDiv = getColNameValue("sch_lang");
			// ---------------------------------
			// Sheet1의 Expense Code
			// ---------------------------------
			//alert(arrXml[0]);
			var genExpnCdListData = ComXml2ListMap(arrXml[0]);
			var tempGenExpnCdList = "";
			var tempGenExpnNmList = "";
			if(genExpnCdListData.length > 0) {
				for(var i=0; i<genExpnCdListData.length; i++) {
					var tempData = genExpnCdListData[i];
					if(i==0) {
						tempGenExpnCdList = "ALL|"+tempData["gen_expn_cd"];
						if (langDiv == "K") tempGenExpnNmList = "ALL\t전체|"+tempData["gen_expn_cd"]+"\t"+tempData["krn_abbr_nm"];
						else if (langDiv == "E") tempGenExpnNmList = "ALL\t전체|"+tempData["gen_expn_cd"]+"\t"+tempData["eng_abbr_nm"];
					} else {
						tempGenExpnCdList += "|"+tempData["gen_expn_cd"];
						if (langDiv == "K") tempGenExpnNmList += "|"+tempData["gen_expn_cd"]+"\t"+tempData["krn_abbr_nm"];
						else if (langDiv == "E") tempGenExpnNmList += "|"+tempData["gen_expn_cd"]+"\t"+tempData["eng_abbr_nm"];
					}
				}
			}			
			sheet1.InitDataCombo(0, "gen_expn_cd", tempGenExpnNmList, tempGenExpnCdList,	"", "", 0);
						
			// ---------------------------------
			// Group Expense
			// ---------------------------------
			var preCombo1 = combo1.Code;
			combo1.RemoveAll();
			var arrTempData = ComXml2ListMap(arrXml[1]);
			combo1.InsertItem(0, "|", "");
			var k = 1;
			for ( var i = 0; i < arrTempData.length; i++) {
				var tempData = arrTempData[i];
	
				if (langDiv == "K") {
					combo1.InsertItem(k++, tempData["gen_expn_cd"] + "|" + tempData["krn_abbr_nm"], tempData["gen_expn_cd"]);
				} else if (langDiv == "E") {
					combo1.InsertItem(k++, tempData["gen_expn_cd"] + "|" + tempData["eng_abbr_nm"], tempData["gen_expn_cd"]);
				}
			}
			combo1.Code = preCombo1;
			
			break;
			
		case SEARCHLIST: // 조회
			if (validateForm(sAction)) {
				frm.f_cmd.value = SEARCHLIST;
				frm.sch_expn_group.value = combo1.Code;
	
				var sXml = sheet1.GetSearchXml("CPS_GEM_0008_03GS.do", FormQueryString(frm));
				var arrXml = sXml.split("|$$|");
				
				//alert(ComGetTotalRows(sXml));
				if (arrXml.length > 0) {
					sheet1.LoadSearchXml(arrXml[0]);
					doActionIBSheet(IBSEARCH);
				}				
											
				// 검색된 데이터의 값을 Setting
				initProperty(sAction);
			}
			break;

		case SEARCHLIST01: // Group Expense
			frm.f_cmd.value = SEARCHLIST01;
			var sXml = sheet1.GetSearchXml("CPS_GEM_0008_03GS.do", FormQueryString(frm));
	
			var langDiv = getColNameValue("sch_lang");
			var preCombo1 = combo1.Code;
			combo1.RemoveAll();
			
			// ---------------------------------
			// Group Expense
			// ---------------------------------
			var arrTempData = ComXml2ListMap(sXml);
			combo1.InsertItem(0, "|", "");
			var k = 1;
			for ( var i = 0; i < arrTempData.length; i++) {
				var tempData = arrTempData[i];
	
				if (langDiv == "K") {
					combo1.InsertItem(k++, tempData["gen_expn_cd"] + "|" + tempData["krn_abbr_nm"], tempData["gen_expn_cd"]);
				} else if (langDiv == "E") {
					combo1.InsertItem(k++, tempData["gen_expn_cd"] + "|" + tempData["eng_abbr_nm"], tempData["gen_expn_cd"]);
				}
			}
			combo1.Code = preCombo1;
			break;
	
		case IBSAVE: // 저장
			if (validateForm(sAction)) {
				// 저장하시겠습니까?
				if (!ComCodeMsgBySave()) return;
					
				frm.f_cmd.value = MULTI;
				var sXml = sheet1.DoSave("CPS_GEM_0008_03GS.do", FormQueryString(frm),-1,false);
				if(sXml) {
					doActionIBSheet(IBSEARCH);
					// 검색된 데이터의 값을 Setting
					doActionIBSheet(SEARCHLIST);
				}
				
				/*
				var sParam = FormQueryString(frm);
				var sParam1 = sheet1.GetSaveString();
	
				//alert(sheet1.IsDataModified +"==>"+sParam1+"<");
				
				if (!sheet1.IsDataModified && sParam1 == "") {				
					ComCodeMsgByNoContentsSave();
					return; 
				}
				sParam = sParam + "&" + sParam1;
	
				var sXml = sheet1.GetSaveXml("CPS_GEM_0008_03GS.do", sParam);
				sheet1.LoadSearchXml(sXml);
				*/	
			}
			break;
	
		case IBINSERT: // 입력
			break;
	}
}

//===================================================================================
//Form 이벤트 처리
// ===================================================================================
/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 **/
function initControl() {
	//** Date 구분자 **/
 	DATE_SEPARATOR = "/";
 	
    //Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerForm('beforedeactivate',	'obj_deactivate',	form); //- 포커스 나갈때
	axon_event.addListenerForm('beforeactivate',	'obj_activate',		form); //- 포커스 들어갈때
	axon_event.addListenerForm('keypress',			'obj_keypress',		form); //- 키 눌렸을때
	//axon_event.addListenerForm('keyup',				'obj_keyup',		form); //- 키 올라올때
	//axon_event.addListener('change',   'obj_change',  'agmt_seq'); //- 변경될때.
}

/**
* HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
*/
function obj_keypress() {
	switch (event.srcElement.name) {
		case "sch_office_code":
			if(getColNameValue("sch_office_gbn") == "Y") ComKeyOnlyAlphabet('uppernum');
			else if(getColNameValue("sch_office_gbn") == "N") ComKeyOnlyNumber(event.srcElement);
			
			if(event.keyCode == 13) {doActionIBSheet(SEARCHLIST);}
			break;
	}
}

/**
 * HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
 **/
function obj_deactivate(){
	switch(event.srcElement.name){
		case "":
			break;
	}
}

/**
* HTML Control Foucs in
*/
function obj_activate(){
   ComClearSeparator(event.srcElement);
}

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	try	{
		var srcName = window.event.srcElement.getAttribute("name");
		//alert("srcName : "+srcName);
		switch (srcName) {
			case "btn_Retrieve":
				doActionIBSheet(SEARCHLIST);
				break;
				
			case "btn_New":
				// Do you want to initialize unsaved data?
				if(!ComCodeMsgByInitializeUnsaved()) return;
				ComResetAll();
				initProperty(IBSEARCH);
				//combo1.RemoveAll();
				break;
				
			case "btn_Save":
				doActionIBSheet(IBSAVE);
				break;
				
			case "btn_DownExcel":
				if (sheet1.RowCount <= 0) {
					// There is no related data!
					ComCodeMsgByNoRelatedData();
					return;
				}
				
				//sheet1.Down2Excel(1, false, false, true, "", "", false, false, "Office", false, "1");
				sheet1.SpeedDown2Excel(1,false,false,"","",false,false, "Office", false, "1");
				
				break;

			case "btn_RowAdd":
				if (sheet1.RowCount <= 0) {
					// There is no related data!
					ComCodeMsgByNoRelatedData();
					return;
				}
				
				// Row Add시 속성값 초기화하기
				var row = sheet1.DataInsert(-1);				
				sheet1.SelectCell(row,"snd_ofc_cd",true);
				
				sheet1.CellEditable(row, "gen_expn_cd_grp") = false;
				sheet1.CellText(row,"gen_expn_cd") = "";
				//sheet1.InitDataCombo(0, "gen_expn_cd", "", " ",	"", "", 0);
				sheet1.CellComboItem(row, "gen_expn_cd", " ", " ", 0);
				
				sheet1.CellEditable(row, "gen_expn_nm") = false;
				sheet1.CellEditable(row, "cre_usr_id") = false;
				
				break;
				
			case "btn_RowDelete":
				if (sheet1.RowCount <= 0) {
					// There is no related data!
					ComCodeMsgByNoRelatedData();
					return;
				}
								
				ComRowHideDelete(sheet1, "delChk");
				break;
			
		} // end switch
	}
	catch (e){
		if (e == "[object Error]"){
			// 지금은 사용하실 수가 없습니다.
			ComCodeMsgByNoUsed();
		}
	}
}

//===================================================================================
//Private function
//===================================================================================
/**
* 화면 폼입력값에 대한 유효성검증 프로세스 처리
*/
function validateForm(sAction){
	if (!ComChkValid(frm)) return false;
	
	if(sAction == IBSAVE) {
		
	}
	return true;
}

/**
* 검색된 데이터의 값을 체크해서 속성값을 Edittable시킴
* @return
*/
function initProperty(sAction) {
	switch (sAction) {
		case IBSEARCH: //Open시
			// 초기 Disabled
			var obj = frm.sch_office_code;
			obj.disabled = true;
			obj.className = "input2";
			
			break;
			
		case SEARCHLIST:	// Retrive시
			if (sheet1.RowCount > 0) {
				for(var row=0; row<=sheet1.LastRow; row++) {
					sheet1.CellEditable(row, "snd_ofc_cd") = false;
					sheet1.CellEditable(row, "rcv_ofc_cd") = false;
					sheet1.CellEditable(row, "gen_expn_cd_grp") = false;
					sheet1.CellEditable(row, "gen_expn_cd") = false;
					sheet1.CellEditable(row, "gen_expn_nm") = false;
					sheet1.CellEditable(row, "cre_usr_id") = false;
				}
			}			
			break;
	}
}

/**
* New버튼 클릭시 초기화 이벤트
*/
function newButtonClear() {
	
}

/**
 * Office인경우 Y, Expense인경우 N
 */
function isOfficeGubun(val) {
	var obj = frm.sch_office_code;
	obj.disabled = false;
	obj.className = "input";
	obj.value = "";
	obj.focus();
}

/**
* 검색 언어 선택시 Expense, Accout, Group Expense의 값을 변경
*/
function isLangCheck(val) {
	// group expense
	doActionIBSheet(SEARCHLIST01);
}

/**
* Delete Data를 조회한다.
*/
function isDeltFlg(val) {
	doActionIBSheet(SEARCHLIST);
}

/**
 * Sheet1의 DATA 입력시 중복체크
 */
function getSheetKeyByDupCheck(row) {
	var rtn = false;
	
	var sndOfcCd = sheet1.CellValue(row, "snd_ofc_cd");
	var rcvOfcCd = sheet1.CellValue(row, "rcv_ofc_cd");
	var genExpnCd = sheet1.CellValue(row, "gen_expn_cd");
	var langDiv = getColNameValue("sch_lang");
	
	frm.f_cmd.value = SEARCHLIST03;
	var command = frm.f_cmd.value; 
	var URL = "CPS_GEM_0008_03GS.do?f_cmd="+command;
	var param = "";
	param += "&hdn_ofc_cd="+sndOfcCd;
	param += "&sch_office_code="+rcvOfcCd;
	param += "&sch_gen_expn_cd="+genExpnCd;
	
	var sXml = sheet1.GetSearchXml(URL+param);
	
	var errCode = ComGetEtcData(sXml, "code");
	if (errCode != "1") {
		if (errCode == "2") {
			//GEM00002	입력 데이터가 중복되었습니다.
			ComShowCodeMessage("GEM00002", "Office Matrix");
			sheet1.CellValue2(row, "gen_expn_cd") = "";
			sheet1.CellValue2(row, "gen_expn_nm") = "";
			rtn = false;
		}
	} else rtn = true;
	
	return rtn;
}
//===================================================================================
//Sheet 이벤트 처리
//===================================================================================
/**
 * 셀을 클릭했을때 발생하는 이벤트 <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {ibsheet} row     	sheetObj의 선택된 Row
 * @param {ibsheet} col     	sheetObj의 선택된 Col
 **/
function sheet1_OnClick(sheetObj, row, col, value) {
	//alert("OnClick : "+sheetObj+"=="+row+"=="+col+"=="+value);
}

/**
* 셀의 값이 바뀌었을 때 발생하는 Event
* @param sheetObj
* @param row
* @param col
* @return
*/
function sheet1_OnChange(sheetObj, row, col) {
	var sndOfcCd = sheetObj.CellValue(row, "snd_ofc_cd");
	var rcvOfcCd = sheetObj.CellValue(row, "rcv_ofc_cd");
	var genExpnCd = sheetObj.CellValue(row, "gen_expn_cd");
	var langDiv = getColNameValue("sch_lang");
	
	switch (sheetObj.ColSaveName(col)) {
		case "snd_ofc_cd" :
			
			// ---------------------------------
			// Sheet1의 Expense Code 중복체크
			// ---------------------------------
	 		if(!getSheetKeyByDupCheck(row)) return;
	 		
			frm.f_cmd.value = SEARCHLIST02;
			var command = frm.f_cmd.value; 
			var URL = "CPS_GEM_0008_03GS.do?f_cmd="+command;
			var param = "";
			param += "&hdn_ofc_cd="+sndOfcCd;
			param += "&sch_office_code="+rcvOfcCd;
			
			var sXml = sheetObj.GetSearchXml(URL+param);			
			// ---------------------------------
			// Sheet1의 Expense Code
			// ---------------------------------
			var genExpnCdListData = ComXml2ListMap(sXml);
			var tempGenExpnCdList = "";
			var tempGenExpnNmList = "";
			if(genExpnCdListData.length > 0) {
				for(var i=0; i<genExpnCdListData.length; i++) {
					var tempData = genExpnCdListData[i];
					if(i==0) {
						tempGenExpnCdList = tempData["gen_expn_cd"];
						if(langDiv == "K") tempGenExpnNmList = tempData["gen_expn_cd"]+"\t"+tempData["krn_abbr_nm"];
						else if(langDiv == "E") tempGenExpnNmList = tempData["gen_expn_cd"]+"\t"+tempData["eng_abbr_nm"];
					} else {
						tempGenExpnCdList += "|"+tempData["gen_expn_cd"];
						if(langDiv == "K") tempGenExpnNmList += "|"+tempData["gen_expn_cd"]+"\t"+tempData["krn_abbr_nm"];
						else if(langDiv == "E") tempGenExpnNmList += "|"+tempData["gen_expn_cd"]+"\t"+tempData["eng_abbr_nm"];
					}
				}
			}
			
			sheetObj.CellComboItem(row, "gen_expn_cd", tempGenExpnNmList, tempGenExpnCdList);
			break;
	 	case "rcv_ofc_cd" :
			
	 		// ---------------------------------
			// Sheet1의 Expense Code 중복체크
			// ---------------------------------
	 		if(!getSheetKeyByDupCheck(row)) return;
	 		
			frm.f_cmd.value = SEARCHLIST02;
			var command = frm.f_cmd.value; 
			var URL = "CPS_GEM_0008_03GS.do?f_cmd="+command;
			var param = "";
			param += "&hdn_ofc_cd="+sndOfcCd;
			param += "&sch_office_code="+rcvOfcCd;
			
			var sXml = sheetObj.GetSearchXml(URL+param);
			// ---------------------------------
			// Sheet1의 Expense Code
			// ---------------------------------
			var genExpnCdListData = ComXml2ListMap(sXml);
			var tempGenExpnCdList = "";
			var tempGenExpnNmList = "";
			if(genExpnCdListData.length > 0) {
				for(var i=0; i<genExpnCdListData.length; i++) {
					var tempData = genExpnCdListData[i];
					if(i==0) {
						tempGenExpnCdList = tempData["gen_expn_cd"];
						if(langDiv == "K") tempGenExpnNmList = tempData["gen_expn_cd"]+"\t"+tempData["krn_abbr_nm"];
						else if(langDiv == "E") tempGenExpnNmList = tempData["gen_expn_cd"]+"\t"+tempData["eng_abbr_nm"];
					} else {
						tempGenExpnCdList += "|"+tempData["gen_expn_cd"];
						if(langDiv == "K") tempGenExpnNmList += "|"+tempData["gen_expn_cd"]+"\t"+tempData["krn_abbr_nm"];
						else if(langDiv == "E") tempGenExpnNmList += "|"+tempData["gen_expn_cd"]+"\t"+tempData["eng_abbr_nm"];
					}
				}
			}
			
			sheetObj.CellComboItem(row, "gen_expn_cd", tempGenExpnNmList, tempGenExpnCdList);
			break;
			
	 	case "gen_expn_cd" :
	 		if(sheetObj.CellValue(row, "gen_expn_cd") == "") {
	 			sheetObj.CellValue2(row, "gen_expn_cd") = "";
	 			sheetObj.CellValue2(row, "gen_expn_nm") = "";
	 			return;
	 		}
 	 		// ---------------------------------
			// Sheet1의 Expense Code 중복체크
			// ---------------------------------
	 		if(!getSheetKeyByDupCheck(row)) return;
	 		
	 		// ---------------------------------
			// Sheet1의 Expense Code Name 조회
			// ---------------------------------
	 		frm.f_cmd.value = SEARCHLIST03;
			var command = frm.f_cmd.value; 
			var URL = "CPS_GEM_0007GS.do?f_cmd="+command;
			var param = "";
			param += "&prnt_gen_expn_cd="+genExpnCd;
			
			var sXml = sheetObj.GetSearchXml(URL+param);
			var genExpnNmListData = ComXml2ListMap(sXml);
			if(genExpnNmListData.length > 0) {
				for(var i=0; i<genExpnNmListData.length; i++) {
					var tempData = genExpnNmListData[i];
					if(langDiv == "K") sheetObj.CellValue2(row, "gen_expn_nm") = tempData["krn_abbr_nm"];
					else if(langDiv == "E") sheetObj.CellValue2(row, "gen_expn_nm") = tempData["eng_abbr_nm"];
				}
			}
	 		break;
	}
}

/**
* 선택된 Item이 변경되었을 때 이벤트가 발생한다.
* @param comboObj
* @param index_cd
* @param text
* @return
*/
function combo1_OnChange(comboObj, index_cd, text) {
	// 다음 포커스로 이동
	comFocusChange('document.form.sch_lang[0]');
}

/**
 * 선택된 Item이 변경되었을 때 이벤트가 발생한다.
 * @param comboObj
 * @param KeyCode
 * @param Shift
 * @return
 */
function combo1_OnKeyUp(comboObj, KeyCode, Shift) {
	var sText = comboObj.Text;
	// 숫6자리만 입력
	if ((KeyCode >= 48 && KeyCode <= 57) || (KeyCode >= 96 && KeyCode <= 105) ) {
		if (sText.length == 6) {
			frm.sch_expn_group.value = sText;
			// 다음 포커스로 이동
			comFocusChange('document.form.sch_lang[0]');
		}
	} else { 
		comboObj.Text = ""; 
	}
}
/* 개발자 작업 끝 */