/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_gem_0008_01.js
 *@FileTitle : Expense Office Maintenance - Office Code
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.27
 *@LastModifier : 최정미
 *@LastVersion : 1.0
 * 2009.05.27 최정미
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2011-02-17 이준범 [CHM-201108627-01]
 * 제목: Request 권한 없는 office user의 접근 시 all data open 오류 해소 요청
 * 보완: Request 권한 없는 Office 에 대한 화면 Block 
 * 2011.03.28 [CHM-201109333-01]
 * 개발자 : 이준범
 * Title: 사무국 권한 명확화 요청
 * DESC : 사무국 SELPLP 소속 사용자 중, 슈퍼유저 와 일반유저를 구분하여, 데이터 조회 할 수 있도록  SQL 수정
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
function cps_gem_0008_01(){
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
	
	 //iframe 사이즈 자동조절
	 resizeIframe("t1frame");
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

			var HeadTitle1 = "|Select|Office|Name|Center|AP CTRL|CUR|Unit|Level|Parent|Company\nDIV|Regional\nDIV|Sales\nDIV|Sum Up|Sum Up|Approval|Approval|Approval|Approval|History|hisCnt|deltFlg";
			var HeadTitle2 = "|Select|Office|Name|Center|AP CTRL|CUR|Unit|Level|Parent|Company\nDIV|Regional\nDIV|Sales\nDIV|Office|Month|RQST|RHQ l BU|TIC|COM|History|hisCnt|deltFlg";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 3, 0, true);

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
			InitDataProperty(0, cnt++ , dtDelCheck,		50,		daCenter,	true,		"Del");
			
			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"ofc_cd",			false,		"",			dfNone,		0,		true,			true);
			InitDataProperty(0, cnt++ , dtData,			200,	daLeft,		true,		"ofc_eng_nm",		false,		"",			dfNone,		0,		true,			true);
			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"ctr_cd", 			false,		"",			dfNone,		0,		true,			true, 		6, false, true, "", true);
			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"ap_ctrl_ofc_cd",	false,		"",			dfNone,		0,		true,			true);
			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"locl_curr_cd",		true,		"",			dfNone, 	0, 		true, 			true, 		3, false, true, "", true);
			InitDataProperty(0, cnt++, 	dtData, 		60, 	daRight, 	true,		"rqst_ut_val", 		true, 		"", 		dfInteger, 	0, 		true, 			true, 		5, false, true, "", true);
			InitDataProperty(0, cnt++ , dtCombo,		40,		daCenter,	true,		"gen_expn_ofc_lvl",	false,		"",			dfNone,		0,		true,			true);
			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"prnt_ofc_cd", 		true,		"",			dfNone, 	0, 		true, 			true, 		6, false, true, "", true);
			InitDataProperty(0, cnt++ , dtCombo,		100,	daCenter,	true,		"ofc_co_div_cd",	true,		"",			dfNone,		0,		true,			true);
			InitDataProperty(0, cnt++ , dtCombo,		100,	daCenter,	true,		"rgn_ofc_flg",		true,		"",			dfNone,		0,		true,			true);
			InitDataProperty(0, cnt++ , dtCombo,		80,		daCenter,	true,		"sls_ofc_flg",		true,		"",			dfNone,		0,		true,			true);
			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"expn_smry_ofc_cd",	false,		"",			dfNone, 	0, 		true, 			true, 		6, false, true, "", true);
			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"expn_smry_yrmon", 	false,		"",			dfDateYm,	0,		true,			true);
			InitDataProperty(0, cnt++ , dtCheckBox,		60,		daCenter,	true,		"rqst_auth_flg",	true,		"",			dfNone,		0,		true,			true);
			InitDataProperty(0, cnt++ , dtCheckBox,		80,		daCenter,	true,		"rhq_auth_flg",		true,		"",			dfNone,		0,		true,			true);
			InitDataProperty(0, cnt++ , dtCheckBox,		60,		daCenter,	true,		"tic_auth_flg",		true,		"",			dfNone,		0,		true,			true);
			InitDataProperty(0, cnt++ , dtCheckBox,		60,		daCenter,	true,		"cmit_auth_flg",	true,		"",			dfNone,		0,		true,			true);
			InitDataProperty(0, cnt++ , dtImage,		0,		daCenter,	true,		"hisPopup", 		false,		"",			dfNone,		0,		true,			true);
			
			// dtHidden
			InitDataProperty(0, cnt++ , dtHidden, 		60, 	daCenter, 	true,	"ofc_his_cnt", 	false, "", dfNone);
			InitDataProperty(0, cnt++ , dtHidden, 		60, 	daCenter, 	true,	"delt_flg", 	false, "", dfNone);
						
			InitDataCombo(0, "gen_expn_ofc_lvl", "1|2|3|4", "1|2|3|4",	"", "", 0);
			InitDataCombo(0, "ofc_co_div_cd", "Own|Subsidiary|Etc", "O|S|E",	"", "",0);
			InitDataCombo(0, "rgn_ofc_flg", "Y|N", "Y|N",	"", "", 0);
			InitDataCombo(0, "sls_ofc_flg", "Y|N", "Y|N",	"", "", 0);
			
			InitDataValid(0, "locl_curr_cd", vtEngUpOnly);
			InitDataValid(0, "prnt_ofc_cd", vtEngUpOther, "1234567890");
			InitDataValid(0, "expn_smry_ofc_cd", vtEngUpOther, "1234567890");
						
			ImageList(0) = "img/btns_search_off.gif";
			ImageList(1) = "img/btns_search.gif";
			
			ShowButtonImage = 2;
			sheetObj.HeadRowHeight = 23;
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
			
	 	   	break;
		case SEARCHLIST: // 조회
			if(validateForm(sAction))
    		{
    			frm.f_cmd.value = SEARCHLIST;     		   
    			var sXml = sheet1.GetSearchXml("CPS_GEM_0011GS.do", FormQueryString(frm));
    			var arrXml = sXml.split("|$$|");
	  			if (arrXml.length > 0) {
	  				sheet1.LoadSearchXml(arrXml[0]);
	  			}
	  			
	  			// 조회된 그리드의 특정항목 Edittable = false 시킴
      			initProperty(sAction);
   	   		}
   	   		break;     	
		case SEARCHLIST01: // LEVEL3 조회
			frm.f_cmd.value = SEARCHLIST01;
			var sXml = sheet1.GetSearchXml("GEM_COMMONGS.do", FormQueryString(frm));
			
			// ---------------------------------
  			// Major List(LEVEL3)
  			// ---------------------------------
			var comboListData = ComGetEtcData(sXml, "searchMajorList").split("|");
			//alert("comboListData : "+comboListData);
			if(typeof comboListData != "undefined" && comboListData != "") {
				var ofcLvl = frm.sch_lvl2;
				ofcLvl.length = 0;
				ComAddComboItem(ofcLvl,"","");
				
				for(var i=0 ; i < comboListData.length ; i++ ) {
					ComAddComboItem(ofcLvl,comboListData[i],comboListData[i]);
				}
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
		case SEARCHLIST03: // SUMUP OFFICE 조회
			frm.f_cmd.value = SEARCHLIST03;
			var sXml = sheet1.GetSearchXml("CPS_GEM_0011GS.do", FormQueryString(frm));
			
			var preCombo1 = combo1.Code;
			
			// ---------------------------------
			// SUMUP Office List
			// ---------------------------------
			var arrTempData = ComGetEtcData(sXml, "searchSumUpList").split("|");
			combo1.InsertItem(0, "|", "");
			var k = 1;
			for(var i=0 ; i < arrTempData.length ; i++ ) {
				var tempData = arrTempData[i];
				
				combo1.InsertItem(k++, tempData, tempData);				
			}
			combo1.Code = preCombo1;
						
			break;
		case IBSAVE: // 저장
			if(validateForm(sAction)) {
				// 저장하시겠습니까?
				if(!ComCodeMsgBySave()) return;
				
				frm.f_cmd.value = MULTI;    			
				var sXml = sheet1.DoSave("CPS_GEM_0008_01GS.do", FormQueryString(frm),-1,false);
				if(sXml) doActionIBSheet(SEARCHLIST);
				/*
				var sParam = FormQueryString(frm);
				var sParam1 = sheet1.GetSaveString(); 
				
				//alert(sheet1.IsDataModified +"==>"+sParam1+"<");
				
				if (!sheet1.IsDataModified && sParam1 == "") {				
					ComCodeMsgByNoContentsSave();
					return; 
				} 	
				sParam = sParam + "&" + sParam1;
				
    			var sXml = sheet1.GetSaveXml("CPS_GEM_0008_01GS.do", sParam);
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
	    	ComKeyOnlyAlphabet('uppernum');
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
				
				//sheet1.Down2Excel(1,false,false,true,"","",false,false," Expense Office Inquiry",false,"ofc_his_cnt|delt_flg","ofc_his_cnt|delt_flg");
				sheet1.SpeedDown2Excel(1,false,false,"","",false,false," Expense Office Inquiry",false,"ofc_his_cnt|delt_flg","ofc_his_cnt|delt_flg");
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
		case IBSEARCH: //Open시
			// 초기 Disabled
			var obj = frm.sch_office_code;
			obj.disabled = true;
			obj.className = "input2";
			
			// SUMUP Office Reset
			combo1.RemoveAll();
			combo1.Enable = false;
					
			break;
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
* Office인경우 Y, Parent인경우 N
*/
function isOfficeGubun(val) {
	// 초기 Disabled
	//ComEnableObject(frm.sch_office_code,  true);
	
	var obj = frm.sch_office_code;
	obj.disabled = false;
	obj.className = "input";
	obj.value = "";
	obj.focus();
}

/**
* Sumup Office를 선택했을때 OfficeList를 조회한다.
*/
function isSumupGubun(val) {
	var colValue = val.value;
	
	if(colValue == "Y") {
		combo1.Enable = true;
		doActionIBSheet(SEARCHLIST03);
	} else {
		combo1.RemoveAll();
		combo1.Enable = false;
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
* 셀을 클릭했을때 발생하는 이벤트 <br>
* @param {ibsheet} sheetObj    IBSheet Object
* @param {ibsheet} row     	sheetObj의 선택된 Row
* @param {ibsheet} col     	sheetObj의 선택된 Col
**/
function sheet1_OnClick(sheetObj, row, col, value) {
	var strOfcCd = sheetObj.CellValue(row,"ofc_cd");
	
	switch (sheetObj.ColSaveName(col)) {
		case "Del" :  			
			// ---------------------------------
			// GEM_OFC_HIS Popup 
			// ---------------------------------
			if(sheetObj.CellValue(row, "delt_flg") == "N") {
	   			var param = "ofc_cd=" + strOfcCd;
	   			var url = "CPS_GEM_0109.do?"+param;
	   			var winName = "CPS_GEM_0109";
	   			
	   			var win = ComOpenWindowCenter(url,winName,700,410, false);
	   			win.focus();
			}
			break;
		case "hisPopup" :   			
   			// ---------------------------------
  			// GEM_OFC_HIS Popup 
  			// ---------------------------------
   			if(sheetObj.CellValue(row, "delt_flg") == "N") {
	   			var param = "ofc_cd=" + strOfcCd;
	   			var url = "CPS_GEM_0109.do?"+param;
	   			var winName = "CPS_GEM_0109";
	   			
	   			var win = ComOpenWindowCenter(url,winName,700,410, false);
	   			win.focus();
   			}
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

/**
* 선택된 Item이 변경되었을 때 이벤트가 발생한다.
* @param comboObj
* @param index_cd
* @param text
* @return
*/
function combo1_OnChange(comboObj, index_cd, text) {
	frm.sch_sumup_office.value = index_cd;
	// 다음 포커스로 이동
	comFocusChange('document.form.sch_delt_flg');
}
/* 개발자 작업 끝 */