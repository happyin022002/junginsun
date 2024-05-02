/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_gem_9999.js
 *@FileTitle : Log in Office Change Management
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.08
 *@LastModifier : 최정미
 *@LastVersion : 1.0
 * 2009.05.07 최정미
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2011-02-17 이준범 [CHM-201108627-01]
 * 제목: Request 권한 없는 office user의 접근 시 all data open 오류 해소 요청
 * 보완: Request 권한 없는 Office 에 대한 화면 Block
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
 * @class Expense Office Inquiry : Expense Office Inquiry 생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function cps_gem_9999(){
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.doActionIBSheet = doActionIBSheet;
	this.initControl = initControl;
	this.validateForm = validateForm;
	
	// add
	this.obj_keypress = obj_keypress;
	this.obj_deactivate = obj_deactivate;
	this.obj_activate = obj_activate;
	
	this.initProperty = initProperty;
	this.newButtonClear = newButtonClear;
	this.isOfficeGubun = isOfficeGubun;
	
	// sheet
	this.sheet1_OnClick = sheet1_OnClick;
}

/* 개발자 작업 */

//===================================================================================
//공통전역변수
//===================================================================================
var sheetObjects = new Array();
var frm = null;
var sheet1 = null;
var sheetCnt = 0;

/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++] = sheet_obj;
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
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
    var cnt = 0;
    switch(sheetObj.id) {

        case "sheet1":
            with (sheetObj) {

            	// 높이 설정
                style.height = 400;
                
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 7, 100);

                var HeadTitle1 = "|Select|Log in Office|GEM Office|From Date|To Date|Remark(s)|Creator ID|DELT_FLG";
                var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false,false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);

                //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,		DATAALIGN,	COLMERGE,	SAVENAME,			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,		0,		daCenter,	true,		"ibflag");
				InitDataProperty(0, cnt++ , dtCheckBox,			60,		daCenter,	true,		"delChk",		false,	"",	dfNone);
				
				InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	true,		"ofc_cd",		true,		"",			dfNone, 	0, 		true, 			true, 		6, false, true, "", true);
				InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	true,		"cng_ofc_cd",	true,		"",			dfNone, 	0, 		true, 			true, 		6, false, true, "", true);
				InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	true,		"cre_dt",		false,	"",	dfNone);
				InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	true,		"upd_dt",		false,	"",	dfNone);
				InitDataProperty(0, cnt++ , dtData,				450,	daLeft,		true,		"ofc_cng_rmk",	false,	"",	dfNone);
				InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	true,		"cre_usr_id",	false,	"",	dfNone);

				InitDataProperty(0, cnt++ , dtHidden, 			60, 	daCenter, 	true,		"delt_flg", 	false, "", dfNone);
				
				InitDataValid(0, "ofc_cd", vtEngUpOther, "1234567890");
				InitDataValid(0, "cng_ofc_cd", vtEngUpOther, "1234567890");
			}
			break;
    }
}

//Sheet관련 프로세스 처리
function doActionIBSheet(sAction){
	//sheetObj.ShowDebugMsg = false;
	//alert("sAction : "+sAction);
	switch (sAction) {

		case INIT:      //Open
		
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
		    }
		   	break;
		case IBSEARCH: // OPEN
	  				
	 	   	break;
		case SEARCHLIST: // 조회
			if(validateForm(sAction))
      		{
      			frm.f_cmd.value = SEARCHLIST;
      			
      			var sXml = sheet1.GetSearchXml("CPS_GEM_9999GS.do", FormQueryString(frm));
      			
      			var arrXml = sXml.split("|$$|");
	  			if (arrXml.length > 0) {
	  				sheet1.LoadSearchXml(arrXml[0]);
	  			}
	  			
	  			// 검색된 데이터의 값을 Setting
				initProperty(sAction);
     	   	}
     	   	break;     	
		case IBSAVE: // 저장
			if (validateForm(sAction)) {
				frm.f_cmd.value = MULTI;
				var sXml = sheet1.DoSave("CPS_GEM_9999GS.do", FormQueryString(frm),-1,false);
				if(sXml) {
					doActionIBSheet(IBSEARCH);
					// 검색된 데이터의 값을 Setting
					doActionIBSheet(SEARCHLIST);
				}
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

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
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
				// Do you want to initialize?
				if(!ComCodeMsgByInitialize()) return;
				newButtonClear();
				ComResetAll();
				break;
			case "btn_Save":
				doActionIBSheet(IBSAVE);
				break;
			case "btn_DownExcel":
				if (sheet1.RowCount <= 0 ) {
					// There is no related data!
					ComCodeMsgByNoRelatedData();
					return;
				} else {
					sheet1.SpeedDown2Excel(1,false,false,"","",false,false," Expense Office Inquiry");
				}
				break;
			case "btn_RowAdd":
				if (sheet1.RowCount <= 0) {
					// There is no related data!
					ComCodeMsgByNoRelatedData();
					return;
				}
				
				// Row Add시 속성값 초기화하기
				var row = sheet1.DataInsert(-1);				
				sheet1.SelectCell(row,"ofc_cd",true);
				sheet1.CellEditable(row, "cre_dt") = false;
				sheet1.CellEditable(row, "upd_dt") = false;
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
	
	if(sAction == SEARCHLIST) {
		
	} else if(sAction == IBSAVE) {
		// 저장하시겠습니까?
		if (!ComCodeMsgBySave()) return;
		
		for(var row=0; row<=sheet1.LastRow; row++) {
			var ibflag = sheet1.CellValue(row, "ibflag");
			if(ibflag == "I") {
				// ---------------------------------
				// Sheet1의 Office Code 중복체크
				// ---------------------------------
		 		if(!getOfficeCodeByDupCheck(row, "LOG")) return;
				if(!getOfficeCodeByDupCheck(row, "CNG")) return;
				if(!getOfficeChangeCodeByDupCheck(row)) return;
			}
		}
		
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
					sheet1.CellEditable(row, "ofc_cd") = false;
					sheet1.CellEditable(row, "cng_ofc_cd") = false;
					sheet1.CellEditable(row, "cre_dt") = false;
					sheet1.CellEditable(row, "upd_dt") = false;
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
	// 초기 Disabled
	initProperty(IBSEARCH);
	
}

/**
 * Log in Office인경우 Y, GEM Office인경우 N
 */
function isOfficeGubun(val) {
	var obj = frm.sch_office_code;
	obj.disabled = false;
	obj.className = "input";
	obj.value = "";
	obj.focus();
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
function getOfficeCodeByDupCheck(row, gubun) {
 	var rtn = false;	
 	var sndOfcCd = sheet1.CellValue(row, "ofc_cd");
	var rcvOfcCd = sheet1.CellValue(row, "cng_ofc_cd");
	var param = "";
	
	if(gubun == "LOG") {
		frm.f_cmd.value = SEARCHLIST01;		
		param += "&hdn_ofc_cd="+sndOfcCd;
	} else if(gubun == "CNG") {
		frm.f_cmd.value = SEARCHLIST02;		
		param += "&hdn_ofc_cd="+rcvOfcCd;
	}
	
 	var command = frm.f_cmd.value; 
	var URL = "CPS_GEM_9999GS.do?f_cmd="+command;
	var sXml = sheet1.GetSearchXml(URL+param);
	
	var errCode = ComGetEtcData(sXml, "code");
	frm.error1.value = errCode;
	if (errCode != "1") {
		if (errCode == "2") {
			if(gubun == "LOG") {
				//GEM01015	오피스코드가 존재 하지 않습니다.
				ComShowCodeMessage("GEM01015", "Log in Office");
				sheet1.SelectCell(row,"ofc_cd",true);
				sheet1.CellValue2(row, "ofc_cd") = "";
			} else if(gubun == "CNG") {
				//GEM01015	오피스코드가 존재 하지 않습니다.
				ComShowCodeMessage("GEM01015", "GEM Office");
				sheet1.SelectCell(row,"cng_ofc_cd",true);
				sheet1.CellValue2(row, "cng_ofc_cd") = "";
			}					
			rtn = false;
		}
	}  else rtn = true;
	
	return rtn;
}

/**
 * Sheet1의 GEM_CNG_OFC Table ofc_cd, cng_ofc_cd 입력시 중복체크
 */
function getOfficeChangeCodeByDupCheck(row) {
 	var rtn = false;	
	var sndOfcCd = sheet1.CellValue(row, "ofc_cd");
	var rcvOfcCd = sheet1.CellValue(row, "cng_ofc_cd");
	
	var param = "";
	param += "&hdn_ofc_cd="+sndOfcCd;
	param += "&sch_office_code="+rcvOfcCd;
	
	frm.f_cmd.value = SEARCHLIST03;
 	var command = frm.f_cmd.value; 
	var URL = "CPS_GEM_9999GS.do?f_cmd="+command;
	var sXml = sheet1.GetSearchXml(URL+param);
	
	var errCode = ComGetEtcData(sXml, "code");
	frm.error1.value = errCode;
	if (errCode != "1") {
		if (errCode == "2") {
			//GEM00002	입력 데이터가 중복되었습니다.
			ComShowCodeMessage("GEM00002", "Log in Office ~ GEM Office");
			sheet1.SelectCell(row,"cng_ofc_cd",true);
			sheet1.CellValue2(row, "cng_ofc_cd") = "";					
			rtn = false;
		}
	}  else rtn = true;
	
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
	
}

/**
* 셀의 값이 바뀌었을 때 발생하는 Event
* @param sheetObj
* @param row
* @param col
* @return
*/
function sheet1_OnChange(sheetObj, row, col) {
	switch (sheetObj.ColSaveName(col)) {
		case "ofc_cd" :
			// ---------------------------------
			// Sheet1의 Office Code 중복체크
			// ---------------------------------
	 		if(!getOfficeCodeByDupCheck(row, "LOG")) return;
			
			break;
	 	case "cng_ofc_cd" :
	 		// ---------------------------------
			// Sheet1의 Office Code 중복체크
			// ---------------------------------
	 		if(!getOfficeCodeByDupCheck(row, "CNG")) return;
	 		
	 		break;		
	}
}
/* 개발자 작업 끝 */