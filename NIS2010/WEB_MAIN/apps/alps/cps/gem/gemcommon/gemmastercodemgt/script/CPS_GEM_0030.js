/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_gem_0030.js
 *@FileTitle : Expense Code Maintenance for subsidiary
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.04.09
 *@LastModifier : 이준범
 *@LastVersion : 1.0
 * 2012.04.09 이준범
 * 1.0 Creation
 * --------------------------------------------------------
 * History
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
 * @class Expense Matrix per Office : Expense Matrix per Office 생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function cps_gem_0030(){
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
	this.isSumupGubun = isSumupGubun;
	this.isDeltFlg = isDeltFlg;
	
	// sheet
	this.sheet1_OnClick = sheet1_OnClick;
	this.sheet1_OnMouseMove = sheet1_OnMouseMove;
	this.combo1_OnChange = combo1_OnChange;
}

/* 개발자 작업 */

//===================================================================================
//공통전역변수
//===================================================================================
var sheetObjects = new Array();
var frm = null;
var sheet1 = null;
var sheetCnt = 0;

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
function setComboObject(combo_obj){
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
	
	for(i=0;i<sheetCnt;i++) {		
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
    for(var k=0; k<comboObjects.length; k++){
        initCombo(comboObjects[k]);
    }
    
	// html컨트롤 이벤트초기화
	initControl();	
}

/**
* 화면 깜빡임 제거 하면서 로드시 초기Data조회
* @param sheetObj
* @return
*/
function sheet1_OnLoadFinish(sheetObj) {
	sheetObj.WaitImageVisible = false;
	
	// 초기 Disabled
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
	comboObj.DropHeight = 190;
}

/**
* 시트 초기설정값, 헤더 정의
* param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
*/
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetObj.id) {

	case "sheet1":
		with (sheetObj) {

			// 높이 설정
			style.height = 420;

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
			InitRowInfo(2, 1, 18, 100);

			var HeadTitle1 = "|Select|Account|Account|Account|Account|Expense|TIC|Updated\nDate|Updated\nID|Created\nDate|Created\nID|";
			var HeadTitle2 = "|Select|Office|Code|Abbreviation(ENG)|Description(ENG)|Code|TIC|Updated\nDate|Updated\nID|Created\nDate|Created\nID|";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
			InitDataProperty(0, cnt++ , dtDelCheck,		50,		daCenter,	true,		"delChk");
			
			InitDataProperty(0, cnt++ , dtCombo,		60,		daCenter,	true,		"ofc_cd",			    true,		"",			dfNone,		0,		false,			true, 		6, 		false, true, "", true);
			InitDataProperty(0, cnt++ , dtData,			150,    daCenter,	true,		"subs_acct_cd",		    true,		"",			dfNone,		0,		false,			true, 		20, 	false, true, "", true);
			InitDataProperty(0, cnt++ , dtData,			150,	daLeft,		true,		"subs_acct_eng_nm",		true,		"",			dfNone,		0,		true,			true, 		100, 	false, true, "", true);
			InitDataProperty(0, cnt++, 	dtData, 		200, 	daLeft, 	true,		"subs_acct_eng_desc",   true, 		"", 		dfNone, 	0, 		true, 			true, 		4000, 	false, true, "", true);
			InitDataProperty(0, cnt++ , dtCombo,		70,		daCenter,	true,		"gen_expn_cd",	       	true,		"",			dfNone,		0,		true,			true);
			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"tic_cd", 		        false,		"",			dfNone, 	0, 		false, 			false);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"upd_dt",				false,		"",			dfDateYmd,	0,		false,			false);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"upd_usr_id",		    false,		"",			dfNone,		0,		false,			false);
			InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"cre_dt",		        false,		"",			dfDateYmd,	0,		false,			false);
			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"cre_usr_id",	        false,		"",			dfNone, 	0, 		false, 			false);			
			InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,		"delt_flg",	            false,		"",			dfNone, 	0, 		false, 			false);
						
			InitDataValid(0, "subs_acct_cd",   vtNumericOther, ",.-_/");
		}
		break;
	}
}

//Sheet관련 프로세스 처리
function doActionIBSheet(sAction){
	//sheetObj.ShowDebugMsg = false;
	//alert("sAction : "+sAction);
	switch (sAction) {
   	
		case IBSEARCH: // OPEN
	  		
			frm.f_cmd.value = SEARCH;
			var sXml = sheet1.GetSearchXml("GEM_COMMONGS.do", FormQueryString(frm));			
			var arrXml = sXml.split("|$$|");
			
			// ---------------------------------
  			// BU Office List(LEVEL2)
  			// ---------------------------------
			var comboListData = ComGetEtcData(sXml, "searchBUOfficeList").split("|");
			if(typeof comboListData != "undefined" && comboListData != "") {
				var ofcLvl = frm.sch_lvl1;
				ofcLvl.length = 0;
				ComAddComboItem(ofcLvl,"","");
				
				for(var i=0 ; i < comboListData.length ; i++ ) {
					ComAddComboItem(ofcLvl,comboListData[i],comboListData[i]);
				}
			}

			frm.f_cmd.value = SEARCH;
			var sXml = sheet1.GetSearchXml("CPS_GEM_0004GS.do", FormQueryString(frm));
		
			var arrXml = sXml.split("|$$|");
			var authFlg  = "";
			
			// 로그인 오피스 정보 
			if (arrXml.length > 0) {			
				var list = ComXml2ListMap(arrXml[0]);
				var officeLevelVo  = list[0];
		
				authFlg  = officeLevelVo["auth_flg"];	
			}
			// 권한 없는 Office 가 로그인 시 화면 닫음
			if ( authFlg == null || authFlg == "" || authFlg == "NNNN") {
				goNoAuthority();
				return false;
		    }
			
			// 현지법인 조직 코드만 조회
			frm.f_cmd.value = SEARCHLIST04;
			var sXml = sheet1.GetSearchXml("GEM_COMMONGS.do", FormQueryString(frm));			
			var arrXml = sXml.split("|$$|");
			var comboListData = ComGetEtcData(arrXml, "searchMinorList");			
			if(typeof comboListData != "undefined" && comboListData != "") {
				sheet1.InitDataCombo(0, "ofc_cd",  " |"+comboListData, " |"+comboListData,	"", "", 0);
			}
			//비용코드 조회
			var sXml = sheet1.GetSearchXml("GEM_COMMONGS.do?f_cmd=" + SEARCHLIST05);
			var arrXml = sXml.split("|$$|");
			var comboListData = ComGetEtcData(arrXml, "searchExpenseCdByRoleList");

			if(typeof comboListData != "undefined" && comboListData != "") {			
				sheet1.InitDataCombo(0, "gen_expn_cd", comboListData, comboListData,	"", "", 0);				
			}
			
	 	   	break;
		case SEARCHLIST: // 조회
			if(validateForm(sAction))
    		{
    			frm.f_cmd.value = SEARCHLIST;    			
    			var sXml = sheet1.GetSearchXml("CPS_GEM_0030GS.do", FormQueryString(frm));
    			var arrXml = sXml.split("|$$|");
	  			if (arrXml.length > 0) {
	  				sheet1.LoadSearchXml(arrXml[0]);
	  			}
	  			// 조회된 그리드의 특정항목 Edittable = false 시킴
      			//initProperty(sAction);
   	   		}
   	   		break;
		case SEARCHLIST02: // LEVEL4 조회
			frm.f_cmd.value = SEARCHLIST02;
			var sXml = sheet1.GetSearchXml("GEM_COMMONGS.do", FormQueryString(frm));
			
			// ---------------------------------
  			// Minor List(LEVEL4)
  			// ---------------------------------
			var comboListData = ComGetEtcData(sXml, "searchMinorList").split("|");
			if(typeof comboListData != "undefined" && comboListData != "") {
				var ofcLvl = frm.sch_lvl3;
				ofcLvl.length = 0;
				ComAddComboItem(ofcLvl,"","");
				
				for(var i=0 ; i < comboListData.length ; i++ ) {
					ComAddComboItem(ofcLvl,comboListData[i],comboListData[i]);
				}
			}
			
			break;
		case IBSAVE: // 저장
			if(validateForm(sAction)) {
				// 저장하시겠습니까?
				if(!ComCodeMsgBySave()) return;
				
				frm.f_cmd.value = MULTI;    		
				var sXml = sheet1.DoSave("CPS_GEM_0030GS.do", FormQueryString(frm),-1, false);
				if(sXml) doActionIBSheet(SEARCHLIST);
			}			
			break;
	}
}

//===================================================================================
//Form 이벤트 처리
//===================================================================================
/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 **/
function initControl() {
	//** Date 구분자 **/
 	DATE_SEPARATOR = "/";
 	//keypress

    //Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerForm('beforedeactivate',	'obj_deactivate',	form); //- 포커스 나갈때
	axon_event.addListenerForm('beforeactivate',	'obj_activate',		form); //- 포커스 들어갈때
	axon_event.addListenerForm('keypress',			'obj_keypress',		form); //- 키 눌렸을때
	//axon_event.addListenerForm('keyup',				'obj_keyup',		form); //- 키 올라올때
	//axon_event.addListener('change',   'obj_change',  'agmt_seq'); //- 변경될때.
}

/**
* HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
**/
function obj_keypress(){
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

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	//var sheetObject = sheetObjects[0];
	
	/** **************************************************** */
	//var formObject = document.form;
	
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
				newButtonClear();
				ComResetAll();
				frm.sch_lvl1.focus();
				break;
			case "btn_Save":
				doActionIBSheet(IBSAVE);
				break;
			case "btn_DownExcel":
				if (sheet1.RowCount <= 0 ) {
					// There is no related data!
					ComCodeMsgByNoRelatedData();
					return false;
				}
				sheet1.SpeedDown2Excel(1,false,false,"","",false,false,"Account Information ",false,"delt_flg","delt_flg");
				break;
				
			case "btn2_Row":
				var row = sheet1.DataInsert(-1);
				break;
				
			case "btn2_Delete":
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
	
	if(sAction == SEARCHLIST) {
		if(frm.sch_lvl2.value != '') {
			if(!isRadioUnselected("sch_hohq_gbn")) {
				// Please select a office type
				ComShowCodeMessage("GEM01038","an office type");
				return false;
			}
		}
	}
	else if(sAction == IBSAVE) {
		
	}
	return true;
}

/**
* 조회된 그리드의 특정항목 Edittable = false 시킴
* @return
*/
function initProperty(sAction) {
	switch (sAction) {

		case SEARCHLIST: //조회
			// 1. 로딩시 비활성화 항목 : ofc_cd, ofc_eng_nm, ctr_cd, ap_ctrl_ofc_cd, locl_curr_cd
			for(var row=2; row<=sheet1.LastRow; row++) {			
				sheet1.CellEditable(row,"ofc_cd") = false;
				sheet1.CellEditable(row, "ofc_eng_nm") = false;
				//sheet1.CellEditable(row, "ctr_cd") = false;
				sheet1.CellEditable(row, "ap_ctrl_ofc_cd") = false;
				//sheet1.CellEditable(row, "locl_curr_cd") = false;
				//sheet1.CellEditable(row, "hisPopup") = false;
				
				// 이미지 변경하기
				if(sheet1.CellValue(row, "ofc_his_cnt") == "0") {
					sheet1.CellImage(row, "hisPopup") = 1;
				} else {
					sheet1.CellImage(row, "hisPopup") = 0;
				}
			}
			break;	
	}
}

/**
* New버튼 클릭시 초기화 이벤트
*/
function newButtonClear() {
	// 활성, 비활성 초기화
	// 초기 Disabled
	initProperty(IBSEARCH);
	
	// app_div_gubun
	var colName = "sch_app_div_gbn";
	var c = document.getElementsByName(colName);	
	var k = 1;
	for (var i = 0; i < c.length; i++)	{
		if(c[0].checked == true) {
			if(k < c.length) {
				var subCol = colName+k;
				eval('document.all.'+subCol+'.checked = false');
				eval('document.all.'+subCol+'.disabled = false');
			}
		}
		k++;
	}
}

/**
* Delete Data를 조회한다.
*/
function isDeltFlg(val) {
	doActionIBSheet(SEARCHLIST);
}

//===================================================================================
//Sheet 이벤트 처리
//===================================================================================
/**
* 셀의 값이 바뀌었을 때 발생하는 Event <br>
* @param {ibsheet} sheetObj IBSheet Object
* @param {ibsheet} row     	sheetObj의 선택된 Row
* @param {ibsheet} col     	sheetObj의 선택된 Col
* @param {ibsheet} value   	변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
**/
function sheet1_OnChange(sheetObj, row, col, value) {	
	
	switch (sheetObj.ColSaveName(col)) {
    
	case "ofc_cd":
		// 조직별 매핑된 비용 코드만 조회
		var sXml = sheetObj.GetSearchXml("GEM_COMMONGS.do?f_cmd=" + SEARCHLIST05 + "&sch_lvl2=" + value );
		var arrXml = sXml.split("|$$|");
		var comboListData = ComGetEtcData(arrXml, "searchExpenseCdByRoleList");

		if(typeof comboListData != "undefined" && comboListData != "") {			
			sheetObj.InitDataCombo(0, "gen_expn_cd", comboListData, comboListData,	"", "", 0);
			sheetObj.CellValue2(row, "gen_expn_cd") = "";
		}
        break;
        
	case "subs_acct_cd" :
		
		var ofcCd = sheetObj.CellValue(row, "ofc_cd");
		
		frm.f_cmd.value = SEARCHLIST01;
		var param = "?ofc_cd=" + ofcCd + "&subs_acct_cd=" + value;			
		var sXml = sheetObj.GetSearchXml("CPS_GEM_0030GS.do"+param, FormQueryString(frm));			
		var arrXml = sXml.split("|$$|");
		
		var errCode = ComGetEtcData(arrXml[0], "code").split("|");
		if (errCode != "0") {
			//GEM01015	ENG	W	입력 데이터가 중복되었습니다.
			ComShowCodeMessage("GEM00002", "Account Code");
			sheetObj.CellValue2(row, "subs_acct_cd") = "";
		}
		
		var rowCnt = sheetObj.RowCount;
		
		for(var i=1; i<=rowCnt; i++) {			
			if((sheetObj.CellValue(i, "ofc_cd") == ofcCd)&&(sheetObj.CellValue(i, "subs_acct_cd") == value)){
				ComShowCodeMessage("GEM00002", "Account Code");
				sheetObj.CellValue2(row, "subs_acct_cd") = "";			
			}
		}
		
		break;
	}
}

/**
* 셀을 클릭했을때 발생하는 이벤트 <br>
* @param {ibsheet} sheetObj    IBSheet Object
* @param {ibsheet} row     	sheetObj의 선택된 Row
* @param {ibsheet} col     	sheetObj의 선택된 Col
**/
function sheet1_OnClick(sheetObj, row, col, value) {
	var strOfcCd = sheetObj.CellValue(row,"ofc_cd");
	
	switch (sheetObj.ColSaveName(col)) {
        
    case "subs_acct_eng_desc":
    	sheetObj.CellEditable(row, col) = false;
        ComShowMemoPad(sheetObj, row, col, false, 200, 150);
        sheetObj.CellEditable(row, col) = true;
        break;
	}
}

/**
* sheet1 MouseMove 이벤트 
* @param {ibsheet} sheet 해당 시트   
* @param {int} button 마우스버튼 방향, 1:왼쪽, 2:오른쪽
* @param {lnt} shift Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
* @param {long} X X 좌표
* @param {long} Y Y 좌표
*/
function sheet1_OnMouseMove(sheetObj, row, col, value, button, shift, X, Y) {
	var sName = sheet1.ColSaveName(sheet1.MouseCol);
	if ("hisPopup" == sName) {		
		sheet1.MousePointer = "Hand";
	} else {
		sheet1.MousePointer = "Default";
	}	
}

/* 개발자 작업 끝 */