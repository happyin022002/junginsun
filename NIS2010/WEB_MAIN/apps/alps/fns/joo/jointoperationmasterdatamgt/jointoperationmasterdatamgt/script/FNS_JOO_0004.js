/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : fns_joo_0004.js
 *@FileTitle : Entry and Inquiry of Basic Port Choose by Settlement Item
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.20
 *@LastModifier : 박희동
 *@LastVersion : 1.0
 * 2009.05.20 박희동
 * 1.0 Creation
 * -------------------------------------------------------------------------------------
 * History 
 * 2010.09.07 윤진영 CHM-201005740 JO-Basic Port Creation & Inquiry 의 port 선택 시 BLANK 값 추가 
 * 2010.10.21 이준범 [CHM-201006630-01] Unit Cost Basic Port 컬럼 삭제
 *            기존 Hidden으로 설정 된 컬럼에 대하여 DownExcel 시 보이지 않도록 옵션 변경
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
 * @class fns_joo_0004 : fns_joo_0004 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function fns_joo_0004() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업	*/

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

//Direction Change시에 해당하는 port를 가져오기 위함
//gPortComboItem[inx][0] ==> Lane Code  
//gPortComboItem[inx][1] ==> Dir  Code  
//gPortComboItem[inx][2] ==> Port Code  
var gPortComboItem;

//Copy눌렀을 경우 Carrier combo의 change event를 타지 못하게 막는다.
var gCopy = false;
//Copy눌렀을 경우 구carrier와 신carrier가 같은지 체크하기 위함
var gJoCrrCd = "";
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

var gTdrRdrCd = "";
var gTdrRdrNm = "";

var prefix="sheet1_";

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];

	/*******************************************************/
	var formObj = document.form;

	var srcName = window.event.srcElement.getAttribute("name");

	if (srcName == null) {
		return;
	}
	
	if (!JooBtnClickEnable(srcName)) {
		return;
	}	
	
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject1, formObj, IBSEARCH);
				break;
	
			case "btn_create":
				if (comboObjects[2].GetText(comboObjects[2].Code,1) == "C"){
					ComShowCodeMessage("JOO00175");
					return;
				}
				doActionIBSheet(sheetObject1, formObj, IBCREATE);
				break;
	
			case "btn_copy":
				if (sheetObject1.RowCount == 0){
					ComShowCodeMessage('JOO00011');//"There is no data to copy...");
					return;
				}
				
				//Copy는 조회된 상태에서만 가능하다.
				var cnt = sheetObject1.FindStatusRow("I|U|D");

				if (cnt>0){
					ComShowCodeMessage('JOO00012');
					return;
				}
				
				if (!ComShowCodeConfirm('JOO00013')){ //Are you sure to copy data?
					return;
				}
				gJoCrrCd = formObj.jo_crr_cd.Code;
				gCopy = true;
				
				//Carrier Code를 비워놓고 새로운 Carrier를 선택하도록 한다
				formObj.jo_crr_cd.Index2 = -1;
				formObj.jo_crr_cd.focus();
				break;
	
			case "btn_save":
				doActionIBSheet(sheetObject1, formObj, IBSAVE);
				break;
	
			case "btn_new":
				UF_reset();
				formObj.jo_crr_cd.focus();
				break;
	
//			case "btn_add":
//				if (formObj.jo_crr_cd.index == -1){ 
//					ComShowCodeMessage('JOO00008');
//					return;
//				}
//				
//				if (formObj.trd_cd.index == -1){
//					ComShowCodeMessage('JOO00009');
//					return;
//				}
//				
//				if (formObj.rlane_cd.index == -1){
//					ComShowCodeMessage('JOO00010');
//					return;
//				}
//				
//				var row = sheetObject1.DataInsert(-1);
//				sheetObject1.CellValue2(row, prefix+"jo_crr_cd") = formObj.jo_crr_cd.Code;
//				sheetObject1.CellValue2(row, prefix+"trd_cd"   ) = formObj.trd_cd.Code;
//				sheetObject1.CellValue2(row, prefix+"rlane_cd" ) = formObj.rlane_cd.Code;
//
//				sheetObject1.CellValue2(row, prefix+"jo_stl_itm_cd"        ) = "";
//				sheetObject1.CellValue2(row, prefix+"skd_dir_cd"           ) = "";
//
//				sheetObject1.CellValue2(row, prefix+"mnth_cond_cd"   ) = "";
//				sheetObject1.CellValue2(row, prefix+"port_cond_cd"   ) = "";
//				sheetObject1.CellValue2(row, prefix+"port_type_cd"   ) = "";
//				sheetObject1.CellValue2(row, prefix+"oper_type_cd"   ) = "";
//				
//				sheetObject1.CellValue2(row, prefix+"jo_stl_tgt_tp_cd"     ) = "";
//				sheetObject1.CellValue2(row, prefix+"n1st_stl_bzc_port_cd" ) = "";
//				sheetObject1.CellValue2(row, prefix+"n2nd_stl_bzc_port_cd" ) = "";
//				sheetObject1.CellValue2(row, prefix+"n3rd_stl_bzc_port_cd" ) = "";
//				sheetObject1.CellValue2(row, prefix+"n1st_stl_pair_port_cd") = ""; 
//				sheetObject1.CellValue2(row, prefix+"n2nd_stl_pair_port_cd") = ""; 
//				sheetObject1.CellValue2(row, prefix+"n3rd_stl_pair_port_cd") = "";
//				sheetObject1.CellValue2(row, prefix+"uc_bss_port_cd"       ) = "";
//				break;
	
			case "btn_del":
				JooRowHideDelete(sheetObject1, prefix+"del_chk");
				break;
	
			case "btn_downexcel":
				sheetObject1.SpeedDown2Excel(0,false,false,"","",false,false,"", false, prefix+"del_chk"+"|"+prefix+"uc_bss_port_cd"+"|"+prefix+"jo_crr_cd"+"|"+prefix+"trd_cd"+"|"+prefix+"rlane_cd"+"|"+prefix+"stl_tgt_vvd_bss_cd","",false,"",false);
				break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage('JOO00001');
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
 * IBCombo Object를 배열로 등록
 * param : combo_obj ==> 콤보오브젝트
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */ 
function setComboObject(combo_obj) {  
    comboObjects[comboCnt++] = combo_obj;  
}
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */

function loadPage(crrCombo,abbrCombo,dirCombo,codeSheet,nameSheet) {

	gTdrRdrCd = codeSheet;
	gTdrRdrNm = nameSheet;
	
	for (i = 0; i < sheetObjects.length; i++) {

		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1, codeSheet, nameSheet);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	//최초에는 trade만 조회하고 trade변경시에 lane을 읽어온다.
    for(var k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],k+1, crrCombo, abbrCombo, dirCombo);
    }
    
    initControl();
}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 **/
function initControl() {
	//** Date 구분자 **/
	DATE_SEPARATOR = "-";
	var formObj = document.form;
	
    //Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObj); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
    axon_event.addListenerFormat('keypress'        , 'obj_keypress'  , 	formObj); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    axon_event.addListenerFormat('keyup'           , 'form_keyup'    ,  formObj);    
    axon_event.addListenerFormat('onclick'         , 'obj_onclick'  , 	formObj); 	

    document.form.jo_crr_cd.focus();
}

function form_keyup(){
	ComKeyEnter('lengthnextfocus');
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo, codeSheet, nameSheet) {

	var cnt = 0;

	switch (sheetNo) {
	case 1: //sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 388;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false);

			var HeadTitle = "STS||Item|Dir|Status|Status|Status|Status|TDR/RDR|Basic|2nd|3rd|Pair Basic|Pair 2nd|Pair 3rd|Settlement Item Full Name|Unit Cost\nBasic Port|Carrier|Trade|Lane|Status";
			var headCount = ComCountHeadTitle(HeadTitle);

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
			
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtStatus      ,  30, daCenter, false, prefix+"ibflag");
			InitDataProperty(0, cnt++, dtCheckBox    ,  30, daCenter, false, prefix+"del_chk");
			InitDataProperty(0, cnt++, dtData        ,  50, daCenter, false, prefix+"jo_stl_itm_cd"        , true , "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtCombo       ,  40, daCenter, false, prefix+"skd_dir_cd"           , true , "", dfNone, 0, false, true );
			InitDataProperty(0, cnt++, dtCombo       ,  30, daCenter, false, prefix+"agmt_mon_cond_cd"     , true , "", dfNone, 0, true , true );
			InitDataProperty(0, cnt++, dtCombo       ,  30, daCenter, false, prefix+"agmt_port_cond_cd"    , false, "", dfNone, 0, true , true );
			InitDataProperty(0, cnt++, dtCombo       ,  30, daCenter, false, prefix+"agmt_port_tp_cond_cd" , false, "", dfNone, 0, true , true );
			InitDataProperty(0, cnt++, dtCombo       ,  30, daCenter, false, prefix+"agmt_op_tp_cond_cd"   , true , "", dfNone, 0, true , true );
			InitDataProperty(0, cnt++, dtCombo       ,  75, daCenter, false, prefix+"jo_stl_tgt_tp_cd"     , true , "", dfNone, 0, true , true );
			InitDataProperty(0, cnt++, dtCombo       ,  65, daCenter, false, prefix+"n1st_stl_bzc_port_cd" , true , "", dfNone, 0, true , true );
			InitDataProperty(0, cnt++, dtCombo       ,  65, daCenter, false, prefix+"n2nd_stl_bzc_port_cd" , false, "", dfNone, 0, true , true );
			InitDataProperty(0, cnt++, dtCombo       ,  65, daCenter, false, prefix+"n3rd_stl_bzc_port_cd" , false, "", dfNone, 0, true , true );
			InitDataProperty(0, cnt++, dtCombo       ,  65, daCenter, false, prefix+"n1st_stl_pair_port_cd", false, "", dfNone, 0, true , true );
			InitDataProperty(0, cnt++, dtCombo       ,  65, daCenter, false, prefix+"n2nd_stl_pair_port_cd", false, "", dfNone, 0, true , true );
			InitDataProperty(0, cnt++, dtCombo       ,  65, daCenter, false, prefix+"n3rd_stl_pair_port_cd", false, "", dfNone, 0, true , true );
			InitDataProperty(0, cnt++, dtData        , 170, daLeft  , false, prefix+"jo_stl_itm_nm"        , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden      ,  70, daCenter, false, prefix+"uc_bss_port_cd"       , false, "", dfNone, 0, true , true );
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  , false, prefix+"jo_crr_cd"            , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  , false, prefix+"trd_cd"               , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  , false, prefix+"rlane_cd"             , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden      ,   0, daCenter, false, prefix+"stl_tgt_vvd_bss_cd"   , true , "", dfNone, 0, true , true );

			InitDataCombo(0, prefix+"skd_dir_cd", "E|W|N|S", "E|W|N|S");
			InitDataCombo(0, prefix+"jo_stl_tgt_tp_cd" , nameSheet, codeSheet);
			InitDataCombo(0, prefix+"agmt_mon_cond_cd"     , UF_getComboStringForSheet(gMnthCondSheet, gMnthNameSheet), gMnthCondSheet);
			InitDataCombo(0, prefix+"agmt_port_cond_cd"    , UF_getComboStringForSheet(gPortCondSheet, gPortNameSheet), gPortCondSheet);
			InitDataCombo(0, prefix+"agmt_port_tp_cond_cd" , UF_getComboStringForSheet(gPortTypeSheet, gPtTpNameSheet), gPortTypeSheet);
			InitDataCombo(0, prefix+"agmt_op_tp_cond_cd"   , UF_getComboStringForSheet(gOperTypeSheet, gOperNameSheet), gOperTypeSheet);

		}
		break;

	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	
	if (!validateForm(sheetObj, formObj, sAction))
		return;

	switch (sAction) {
		case IBSEARCH: //조회
			sheetObj.RemoveAll();
			gCopy = false;
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("FNS_JOO_0004GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			break;

		case IBCREATE: //CREATE
			gCopy = false;
			sheetObj.RemoveAll();
			formObj.f_cmd.value = SEARCHLIST01;
			sheetObj.DoSearch("FNS_JOO_0004GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			break;

		//Rlane변경시 Port 읽어오기
		case IBROWSEARCH:
			gCopy = false;
			formObj.f_cmd.value = SEARCHLIST11;
			formObj.code.value = "";
			formObj.super_cd1.value = formObj.rlane_cd.Code;
			formObj.super_cd2.value = "";
			
	        var sXml = sheetObjects[1].GetSearchXml("JOOCommonGS.do", FormQueryString(formObj));
	        var basicPortCombo = ComGetEtcData(sXml, "portCode");
	        var portCombo = "     |";
	        portCombo += basicPortCombo;
	        
	        
	        sheetObj.InitDataCombo(0, prefix+"n1st_stl_bzc_port_cd" , basicPortCombo, basicPortCombo);
	        sheetObj.InitDataCombo(0, prefix+"n2nd_stl_bzc_port_cd" , portCombo, portCombo);
	        sheetObj.InitDataCombo(0, prefix+"n3rd_stl_bzc_port_cd" , portCombo, portCombo);
	        sheetObj.InitDataCombo(0, prefix+"n1st_stl_pair_port_cd", basicPortCombo, basicPortCombo);
	        sheetObj.InitDataCombo(0, prefix+"n2nd_stl_pair_port_cd", portCombo, portCombo);
	        sheetObj.InitDataCombo(0, prefix+"n3rd_stl_pair_port_cd", portCombo, portCombo);
	        sheetObj.InitDataCombo(0, prefix+"uc_bss_port_cd"       , portCombo, portCombo);
	        //formObj.jo_stl_itm_cd.focus();
	        break;
			
		case IBSAVE: //저장
			var SaveStr = ComGetSaveString(sheetObjects[0]);
			
			if (SaveStr == ""){
				ComShowCodeMessage("JOO00036");
				return false;
			}

			if (!ComShowCodeConfirm("JOO00046")){
				return false;
			}

			formObj.f_cmd.value = MULTI;

			sheetObj.WaitImageVisible=false;
			ComOpenWait(true);
			var sXml = sheetObj.GetSaveXml("FNS_JOO_0004GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			ComOpenWait(false);

			var RTNVAL = ComGetEtcData(sXml, "RTNVAL");
			if (RTNVAL == "E"){
				if (ComShowCodeConfirm("JOO00145")){
					doActionIBSheet(sheetObj, document.form, IBCOPYROW);					
				}
			}else if (RTNVAL == "W"){
				ComShowCodeMessage("JOO00146");
			}else{
				//Save Normally 조회되게...
				sheetObj.LoadSearchXml(sXml);
				doActionIBSheet(sheetObj, document.form, IBSEARCH);				
			}
			
			break;

		case IBCOPYROW: //삭제후 입력
			formObj.f_cmd.value = SEARCH01;

			var SaveStr = ComGetSaveString(sheetObjects[0]);
			sheetObj.WaitImageVisible=false;
			ComOpenWait(true);
			var sXml = sheetObj.GetSaveXml("FNS_JOO_0004GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			ComOpenWait(false);
			//Save Normally 조회되게...
			sheetObj.LoadSearchXml(sXml);
			doActionIBSheet(sheetObj, document.form, IBSEARCH);				
			break;

		// Carrier변경시 Trade Combo생성
		case IBSEARCH_ASYNC01 :
			//콤보필드를 초기화시킨다.
			comboObjects[1].RemoveAll();
								
			formObj.f_cmd.value = SEARCHLIST06;
			formObj.code.value = "";
			formObj.super_cd1.value = formObj.jo_crr_cd.Code;
			formObj.super_cd2.value = "";
			var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj));

			ComXml2ComboItem(sXml, formObj.trd_cd,"code","code");
			break;

		// Trade변경시 Rlane Combo 생성
		case IBSEARCH_ASYNC02 :
			//콤보필드를 초기화시킨다.
			comboObjects[2].RemoveAll();
								
			formObj.f_cmd.value = SEARCH08;
			formObj.code.value = "";
			formObj.super_cd1.value = formObj.jo_crr_cd.Code;
			formObj.super_cd2.value = formObj.trd_cd.Code;
			
			var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj));

			ComXml2ComboItem(sXml, formObj.rlane_cd, "code", "code|name|auth_cd");
			break;
	}
}

/**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */ 
function initCombo(comboObj, comboNo, crrCombo, abbrCombo, dirCombo) {
    var formObj = document.form
    
    switch(comboNo) {  
    	case 1: 
           with (comboObj) { 
				MultiSelect = false; 
				UseAutoComplete = true;	
				SetColAlign("left");        
				SetColWidth("30");
 				DropHeight = 160;
 				ValidChar(2,0);//영문대문자만 입력가능
 				MaxLength=3;
 		    }
            var comboItems = crrCombo.split("|");
            UF_addComboItem(comboObj, comboItems);           	
 			break; 
 			
    	case 2: 
            with (comboObj) { 
 				MultiSelect = false; 
 				UseAutoComplete = true;	
 				SetColAlign("left");        
 				SetColWidth("30");
  				DropHeight = 160;  				
 				ValidChar(2,0);//영문대문자만 입력가능
 				MaxLength=3;
  		    }
  			break;
  			
  		//rlane_cd, re_divr_cd, auth_cd
    	case 3: 
            with (comboObj) { 
 				MultiSelect = false; 
 				UseAutoComplete = true;	
 				SetColAlign("left|left|left");        
 				SetColWidth("50|30|0");
  				DropHeight = 160;
 				ValidChar(2,1);//영문대문자+숫자만 입력가능
 				MaxLength=5;
  		    }
  			break;
  			
    	case 4: 
            with (comboObj) { 
 				MultiSelect = false; 
 				UseAutoComplete = true;	
 				SetColAlign("left");        
 				SetColWidth("30");
  				DropHeight = 160;
 				ValidChar(2,2);//영문대문자와 특수문자 입력가능
 				MaxLength=3;
  		    }
            var comboItems = abbrCombo.split("|");
            UF_addComboItem(comboObj, comboItems);           	
  			break;
  			
    	case 5: 
            with (comboObj) { 
 				MultiSelect = false; 
 				UseAutoComplete = true;	
 				SetColAlign("left");        
 				SetColWidth("30");
  				DropHeight = 160;
 				ValidChar(2,0);//영문대문자만 입력가능
 				MaxLength=1;
  		    }

            var comboItems = dirCombo.split("|");
            
            comboObj.InsertItem(0, "|");
            for(var i=0; i< comboItems.length; i++){
            	comboObj.InsertItem(i+1, comboItems[i]+"|"+comboItems[i]);
            }
  			break; 
 	} 
}

/**
 * Carrier Code 변경 => reset
 * @param comboObj
 * @param idx_cd
 * @param text
 * @return
 */
function jo_crr_cd_OnChange(comboObj, idx_cd, text){
	var formObj = document.form;

	//copy버튼을 눌렀을 경우는 change event를 타면 안된다.
	if (gCopy){
		//Copy했는데 기존 Carrier와 같다면 에러message
		if (gJoCrrCd == idx_cd){
			ComShowCodeMessage('JOO00014');
			formObj.jo_crr_cd.Index2 = -1;
			formObj.jo_crr_cd.focus();
			return;
		}
		//변경된 Carrier로 Insert한 것처럼 처리한다.
		for (var inx=sheetObjects[0].HeaderRows; inx<=sheetObjects[0].LastRow; inx++){
			sheetObjects[0].CellValue2(inx,prefix+"jo_crr_cd") = idx_cd;
			sheetObjects[0].RowStatus(inx) = "I";
		}
	}else{
		//reset하고 trade code list를 조회한다.
		sheetObjects[0].RemoveAll();

		comboObjects[1].Index2=-1;
		comboObjects[2].Index2=-1;
		comboObjects[3].Index2=-1;
		comboObjects[4].Index2=-1;
		comboObjects[1].RemoveAll();
		comboObjects[2].RemoveAll();
	}
}

/**
 * Trade Code Focus 획득 => Trade Combo List 작성
 * @param comboObj
 * @return
 */
function trd_cd_OnFocus(comboObj){
	var formObj = document.form;
	
	if (comboObjects[0].Code.length < 3){
		ComShowCodeMessage("JOO00008");
		formObj.jo_crr_cd.focus();
		return;
	}
	
	if (comboObj.GetCount() == 0){
		comboObj.Enable = false;
		doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC01);
		comboObj.Enable = true;
	}
}

/**
 * Trade 코드 변경시 하위 조건 reset
 * @param comboObj
 * @param idx_cd
 * @param text
 * @return
 */
function trd_cd_OnChange(comboObj, idx_cd, text){
	var formObj = document.form;
	
	sheetObjects[0].RemoveAll();
	comboObjects[2].Index2=-1;
	comboObjects[2].RemoveAll();
}

/**
 * Rlane Code Focus 획득시 Rlane Combo Code List 조회
 * @param comboObj
 * @return
 */
function rlane_cd_OnFocus(comboObj){
	var formObj = document.form;
	
	if (comboObjects[1].Code.length < 3){
		ComShowCodeMessage("JOO00009");
		formObj.trd_cd.focus();
		return;
	}

	if (comboObj.GetCount() == 0){
		comboObj.Enable = false;
		doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC02);
		comboObj.Enable = true;
	}
}

/**
 * Rlane 변경시 ==> 이하 조건 reset
 * @param comboObj
 * @param code
 * @param text
 * @return
 */
function rlane_cd_OnChange(comboObj, code, text){
	var formObj = document.form;
	sheetObjects[0].RemoveAll();

	//Bound, Round, Cycle
	formObj.jo_stl_opt_cd.value = comboObj.GetText(code, 1);
	//AUTH_CD 에 따라 Button Control
	setAuth(comboObj.GetText(code, 2));
	//IBSheet내의 Port를 조회하여 Combo로 setting한다.
	doActionIBSheet(sheetObjects[0], formObj, IBROWSEARCH);
}

//Rlane의 Focus Out때 Port List를 조회한다.
//2010.02.09 문제점...onBlur 안하고 retrieve 버튼 누를 경우 IBSheet내의 Combo를 인식하지 못하는 경우 발생한다.
//function rlane_cd_OnBlur(comboObj){
//	var formObj = document.form;
//	if (comboObj.Code.length == 5){
//		doActionIBSheet(sheetObjects[0], formObj, IBROWSEARCH);
//	}
//}

function setAuth(auth){
	if (auth == null || auth == undefined){
		auth = "R";
	}
	var editable = true;
	if (auth == "R"){
		editable = false;
	}
	JooSetBtnClass("C", editable);
	for (var i = 0; i < sheetObjects.length; i++) {
		sheetObjects[i].Editable = editable;
	}
}

//ABBR 변경시 clear
function jo_stl_itm_cd_OnChange(comboObj, idx_cd, text){
	sheetObjects[0].RemoveAll();
}

//DIR 변경시 clear
function skd_dir_cd_OnChange(comboObj, idx_cd, text){
	sheetObjects[0].RemoveAll();
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
		case IBCREATE: //저장용 조회
			if (formObj.jo_crr_cd.Code.length < 3){
				ComShowCodeMessage('JOO00008');
				formObj.jo_crr_cd.focus();
				return false;
			}

			if (formObj.trd_cd.Code.length < 3){
				ComShowCodeMessage('JOO00009');
				formObj.trd_cd.focus();
				return false;
			}

			if (formObj.rlane_cd.Code.length < 5){
				ComShowCodeMessage('JOO00010');
				formObj.rlane_cd.focus();
				return false;
			}

			if (formObj.jo_stl_itm_cd.Code.length != 0){
				ComShowCodeMessage('JOO00015');
				formObj.jo_stl_itm_cd.Index2=-1;
				formObj.skd_dir_cd.Index2=-1;
				return false;
			}

			if (formObj.skd_dir_cd.Code.length != 0){
				ComShowCodeMessage('JOO00016');
				formObj.skd_dir_cd.Index2=-1;
				return false;
			}
			break;
			
		case IBSEARCH: //조회
			if (formObj.jo_crr_cd.Code.length < 3){
				ComShowCodeMessage('JOO00008');
				formObj.jo_crr_cd.focus();
				return false;
			}

			if (formObj.trd_cd.Code.length < 3){
				ComShowCodeMessage('JOO00009');
				formObj.trd_cd.focus();
				return false;
			}

			if (formObj.rlane_cd.Code.length < 5){
				ComShowCodeMessage('JOO00010');
				formObj.rlane_cd.focus();
				return false;
			}
			break;

		case IBSAVE:   //저장
			if (formObj.jo_crr_cd.Code.length < 3){
				ComShowCodeMessage('JOO00008');
				formObj.jo_crr_cd.focus();
				return false;
			}

			if (formObj.trd_cd.Code.length < 3){
				ComShowCodeMessage('JOO00009');
				formObj.trd_cd.focus();
				return false;
			}

			if (formObj.rlane_cd.Code.length < 5){
				ComShowCodeMessage('JOO00010');
				formObj.rlane_cd.focus();
				return false;
			}
			
			var joStlOptCd = formObj.rlane_cd.GetText(formObj.rlane_cd.Code, 1);

			for(var inx=sheetObj.HeaderRows; inx <= sheetObj.LastRow; inx++){
				var status = sheetObj.RowStatus(inx);
				if (status == "R" || status == "D") 
					continue;

				//del_chk 체크만 하고 Row Delete 버튼을 누르지 않은 경우를 방지하기 위함 
				if ((status == "I" || status == "U") && sheetObj.CellValue(inx, prefix+"del_chk") == "1" && !sheetObj.RowHidden(inx)){
					ComShowCodeMessage("JOO00079");
					sheetObj.SelectCell(inx,prefix+"del_chk",true);
					return false;
				}
				var joStlItmCd = sheetObj.CellValue(inx,prefix+"jo_stl_itm_cd"); 
				if (joStlItmCd == ""){
					ComShowCodeMessage('JOO00017', inx);
					sheetObj.SelectCell(inx,prefix+"jo_stl_itm_cd",true);
					return false;
				}
				var skdDirCd       = sheetObj.CellValue(inx,prefix+"skd_dir_cd"); 
				if (skdDirCd == ""){
					ComShowCodeMessage('JOO00018', inx);
					sheetObj.SelectCell(inx,prefix+"skd_dir_cd",true);
					return false;
				}
				
//				var stlTgtVvdBssCd = sheetObj.CellValue(inx,prefix+"stl_tgt_vvd_bss_cd"); 
//				if (stlTgtVvdBssCd == ""){
//					ComShowCodeMessage('JOO00019', inx);
//					sheetObj.SelectCell(inx,prefix+"stl_tgt_vvd_bss_cd",true);
//					return false;
//				}
				
				var mnthCondCd = sheetObj.CellValue(inx,prefix+"agmt_mon_cond_cd");
				if (mnthCondCd == ""){
					ComShowCodeMessage('JOO00019', inx + " Month Option ");
					sheetObj.SelectCell(inx,prefix+"agmt_mon_cond_cd",true);
					return false;
				}

				var portCondCd = sheetObj.CellValue(inx,prefix+"agmt_port_cond_cd");
				if (portCondCd == ""){
					ComShowCodeMessage('JOO00019', inx + " Port Option ");
					sheetObj.SelectCell(inx,prefix+"agmt_port_cond_cd",true);
					return false;
				}

				//Round인 경우는 PortCondCd, PortTypeCd를 입력하지 않아도 저장되게 한다.
				//2009.10.22 Round여도  다른월에 포함된 것을 제외하기 위해 First, Last는 필요하다.
				if (joStlOptCd == "B" || joStlOptCd == "C"){
					var portTypeCd = sheetObj.CellValue(inx,prefix+"agmt_port_tp_cond_cd");
					if (portTypeCd == ""){
						ComShowCodeMessage('JOO00019', inx + " Port Type ");
						sheetObj.SelectCell(inx,prefix+"agmt_port_tp_cond_cd",true);
						return false;
					}
				}
				var operTypeCd = sheetObj.CellValue(inx,prefix+"agmt_op_tp_cond_cd");
				if (operTypeCd == ""){
					ComShowCodeMessage('JOO00019', inx + " Operation Type ");
					sheetObj.SelectCell(inx,prefix+"agmt_op_tp_cond_cd",true);
					return false;
				}
				
				var joStlTgtTpCd   = sheetObj.CellValue(inx,prefix+"jo_stl_tgt_tp_cd"); 
				if (joStlTgtTpCd == ""){
					ComShowCodeMessage('JOO00020', inx);
					sheetObj.SelectCell(inx,prefix+"jo_stl_tgt_tp_cd",true);
					return false;
				}
				
				var bss1st = sheetObj.CellValue(inx,prefix+"n1st_stl_bzc_port_cd");
				var bss2nd = sheetObj.CellValue(inx,prefix+"n2nd_stl_bzc_port_cd");
				var bss3rd = sheetObj.CellValue(inx,prefix+"n3rd_stl_bzc_port_cd");
				
				var par1st = sheetObj.CellValue(inx,prefix+"n1st_stl_pair_port_cd"); 
				var par2nd = sheetObj.CellValue(inx,prefix+"n2nd_stl_pair_port_cd"); 
				var par3rd = sheetObj.CellValue(inx,prefix+"n3rd_stl_pair_port_cd");

				var untPort = sheetObj.CellValue(inx,prefix+"uc_bss_port_cd");
				
				if (bss1st == ""){
					ComShowCodeMessage('JOO00021', inx);
					sheetObj.SelectCell(inx,prefix+"n1st_stl_bzc_port_cd",true);
					return false;
				}

				if (bss1st == bss2nd){
					ComShowCodeMessage('JOO00022', inx);
					sheetObj.SelectCell(inx,prefix+"n2nd_stl_bzc_port_cd",true);
					return false;
				}

				if (bss1st == bss3rd){
					ComShowCodeMessage('JOO00023', inx);
					sheetObj.SelectCell(inx,prefix+"n3rd_stl_bzc_port_cd",true);
					return false;
				}
				
				if (bss2nd != "" && bss2nd == bss3rd){
					ComShowCodeMessage('JOO00024', inx);
					sheetObj.SelectCell(inx,prefix+"n3rd_stl_bzc_port_cd",true);
					return false;
				}
				
				//2009.10.01 Settlement Option이 Bound, Round이고 서남아지역이면 Pair Port는 Optional이 됨 by 박효숙차장
				//2010.02.10 Pair Port는 Local이면 모두 Optional이다. (By 박효숙 차장)
				//           즉 Cycle은 Basic Port를 넣지 않으므로 무조건 AR_HQ_OFC_CD = 'SELHO'면 mandatory check
				//if (joStlOptCd == "C" || gHqOfcCd != "SINRS"){
				if (gHqOfcCd == "SELHO"){
					if (par1st == ""){
						ComShowCodeMessage('JOO00025', inx);
						sheetObj.SelectCell(inx,prefix+"n1st_stl_pair_port_cd",true);
						return false;
					}
	
					if (par1st == par2nd){
						ComShowCodeMessage('JOO00026', inx);
						sheetObj.SelectCell(inx,prefix+"n2nd_stl_pair_port_cd",true);
						return false;
					}
	
					if (par1st == par3rd){
						ComShowCodeMessage('JOO00027', inx);
						sheetObj.SelectCell(inx,prefix+"n3rd_stl_pair_port_cd",true);
						return false;
					}
					
					if (par2nd != "" && par2nd == par3rd){
						ComShowCodeMessage('JOO00028', inx);
						sheetObj.SelectCell(inx,prefix+"n3rd_stl_pair_port_cd",true);
						return false;
					}
					
					if (bss1st == par1st){
						ComShowCodeMessage('JOO00029', inx);
						sheetObj.SelectCell(inx,prefix+"n1st_stl_bzc_port_cd",true);
						return false;
					}
				}
				
//				if (untPort == ""){
//					ComShowCodeMessage('JOO00030', inx);
//					sheetObj.SelectCell(inx,prefix+"uc_bss_port_cd",true);
//					return false;
//				}
			}
			break;
	}
	return true;
}

/**
 * Sheet1_OnChange
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var sName = sheetObj.ColSaveName(Col);

	//ITEM 변경시 TDR/RDR Combo setting 
	if (sName == prefix+"jo_stl_itm_cd"){
		UF_setTdrRdrCombo(sheetObj, Row);
	}
}

/**
 * Sheet1_OnSearchEnd
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	gCopy = false;
	//TDR/RDR combo setting
	for (var inx=sheetObj.HeaderRows; inx<=sheetObj.LastRow; inx++){
		UF_setTdrRdrCombo(sheetObj, inx);
	}
}

/**
 * 해당 row의 TDR/RDR combo setting
 * @param sheetObj
 * @param Row
 * @return
 */
function UF_setTdrRdrCombo(sheetObj, Row){
	
	var code = "";
	var name = "";
	var arrCode = gTdrRdrCd.split("|");
	var arrName = gTdrRdrNm.split("|");
	
	var joStlItmCd = sheetObj.CellValue(Row,prefix+"jo_stl_itm_cd");

	for (var inx=0; inx < arrCode.length; inx++){
		//S/H인 경우는 TDR/RDR이 SKD만 나오고 그 외에는 RDR, TDR, UI중 선택하도록 COMBO로 만든다. 
		if (joStlItmCd == "S/H"){
			if (arrCode[inx] == "S"){
				code = code + arrCode[inx] + "|";
				name = name + arrName[inx] + "|";
			}
		}else{
			if (arrCode[inx] != "S"){
				code = code + arrCode[inx] + "|";
				name = name + arrName[inx] + "|";
			}
		}
	}
	if (code.length > 0){
		code = code.substring(0,code.length-1);
		name = name.substring(0,name.length-1);
	}
    sheetObj.CellComboItem(Row, prefix+"jo_stl_tgt_tp_cd", name, code);
}

/**
 * 초기화
 * @return
 */
function UF_reset(){
	sheetObjects[0].RemoveAll();

	comboObjects[0].Index2=-1;
	comboObjects[1].Index2=-1;
	comboObjects[2].Index2=-1;
	comboObjects[3].Index2=-1;
	comboObjects[4].Index2=-1;
	comboObjects[1].RemoveAll();
	comboObjects[2].RemoveAll();
	gCopy = false;
}
/* 개발자 작업  끝 */