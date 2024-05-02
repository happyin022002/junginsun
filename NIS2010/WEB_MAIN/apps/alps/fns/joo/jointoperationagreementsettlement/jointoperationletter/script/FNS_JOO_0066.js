/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : fns_joo_0066.js
 *@FileTitle : Inquiry of Vendor / Customer Code
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.18
 *@LastModifier : 함대성
 *@LastVersion : 1.0
 * 2009.06.18 함대성
 * 1.0 Creation
 * History
 * 2010.11.03 CHM-201006730-01 진마리아  Summary of Monthly Clearance Status by Carrier 기능에  Due Date,  Remark 컬럼 추가
 * 2010.11.08 이준범 [CHM-201006731-01]
 * 1. 대상 기능
 *   - JO Member Information Creation(JOO_0066)
 *   - Inquiry of JO Member Information(JOO_0067)
 * 2. 보완 대상
 *   - Revenue Lane 정보 반영 
 *   - MS Office( Excel, Worl, Power Point등) 첨부
 *   - Carrier Name등 컬럼 반영
 * 2010.12.02 이준범 [CHM-201007349-01]
 * 1. 보완 기능 
 *   - JO Member Information Creation
 *   - Inquiry of JO Member Information
 * 2. 보완 요청 사항
 *   - 컬럼 추가 : PIC of SML(ID),  Name of PIC,  RHQ, Office, Start Date,  Creation Date
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
 * @class fns_joo_0066 : fns_joo_0066 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function fns_joo_0066() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;

	this.obj_keypress = obj_keypress;
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
var prefix = "sheet1_";

var currRow; // Row 단위로 데이터를 전송할 때 필요한 전역변수
var frm = null;
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];

	/*******************************************************/
	var formObject = document.form;

	//try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject, formObject, IBSEARCH);
				break;

			case "btn_new":
		    	ComResetAll();
		    	formObject.jo_crr_cd.Code2 = "ALL";
		    	formObject.rlane_cd.Code2 = "ALL";
		    	break;
			
			case "btn_save":
				doActionIBSheet(sheetObject, formObject, IBSAVE);
				break;
			
			case "btn2_Row_Copy":
				var row = sheetObject.DataCopy();
				sheetObject.RowStatus(row) = "I";
	    		//Copy되는 항목 일부 제외
				sheetObject.CellValue2(row , prefix+"crr_cntc_seq") = "";
				sheetObject.CellValue2(row , prefix+"file_cnt") = "";
				sheetObject.CellValue2(row , prefix+"cre_dt") = "";
				sheetObject.CellValue2(row , prefix+"rid") = "";
				break;
				
			case "btn_insert":				
				
				if (sheetObject.CellValue(sheetObject.HeaderRows, prefix+"jo_crr_cd") == ""){
					sheetObject.RemoveAll();
				}
				var inx = sheetObject.DataInsert();
				sheetObject.SelectCell(inx, "",true);
		    	UF_setSheetCombo(sheetObject, inx);
				break;		

			case "btn_add":				
				
				if (sheetObject.CellValue(sheetObject.HeaderRows, prefix+"jo_crr_cd") == ""){
					sheetObject.RemoveAll();
				}
				var inx = sheetObject.DataInsert(-1);		
				sheetObject.SelectCell(inx, "",true);
		    	UF_setSheetCombo(sheetObject, inx);
				break;
				
			case "btn_delete":
				if (sheetObject.RowCount <= 0) {
					// There is no related data!
					ComCodeMsgByNoRelatedData();
					return;
				}
								
				JooRowHideDelete(sheetObject, prefix+"del_chk");
				break;				
				
			case "btn_downexcel":
				sheetObject.SpeedDown2Excel();
				break;
				
		} // end switch
//	} catch (e) {
//		if (e == "[object Error]") {
//			ComShowCodeMessage('JOO00001');
//		} else {
//			ComShowMessage(e);
//		}
//	}
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
function loadPage(crrCombo) {
	
	 frm = document.form;
	 
	for (i = 0; i < sheetObjects.length; i++) {

		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	//combo 초기화
	for(var k=0;k<comboObjects.length;k++){
	    initCombo(comboObjects[k], k+1, crrCombo);
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
	    //Axon 이벤트 처리1. 이벤트catch
		var formObject = document.form;
	    //axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject); 			  //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	    //axon_event.addListenerFormat('focus',    'obj_activate',    formObject,	'agmt_no');             //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
		axon_event.addListenerFormat('keypress', 'obj_keypress_loc', formObject);
		//axon_event.addListenerFormat('keypress', 'obj_keypress', document.form);
	    //axon_event.addListenerFormat('change',	 'obj_change',	formObject);
  }

 /*
	//포멧 처리를 하지 않기 위해   
	if(obj.name == "jo_cntc_phn_no" || obj.name == "jo_cntc_fax_no"){  
		ComKeyOnlyNumber(obj, "-");	 
	}	else if(obj.name=="mnr_prnr_eml") {  
		MnrKeyOnlyAlphabet('lowereml');     
	} 	else {
		ComKeyOnlyAlphabet('lower');  	
	}      
break; 
*/
// 업무 자바스크립트 OnKeyPress 이벤트 처리
function obj_keypress_loc() {
	switch(event.srcElement.dataformat){
     case "float":
         //숫자+"."입력하기
         ComKeyOnlyNumber(event.srcElement, ".");
         break;
     case "eng":
         //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
         ComKeyOnlyAlphabet();
         break;
     case "engdn":
         //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
         ComKeyOnlyAlphabet('lower');
         break;
     case "engup":
         //영문 대문자만 입력하기
         ComKeyOnlyAlphabet('upper');
         break;
     case "int":
         //숫자만입력하기(정수,날짜,시간)
         ComKeyOnlyNumber(event.srcElement);
         break;
     case "uppernum":
         //영문 대문자+숫자
         ComKeyOnlyAlphabet('uppernum'); 
         break;
     case "tel":
        // 숫자+"-"입력하기
        ComKeyOnlyNumber(event.srcElement, "-"); 
        break;
  }
} 
 
 /**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	switch (sheetObj.id) {
	case  "sheet1": //t1sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 400;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			//MergeSheet = msNone;
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			//Editable = false;
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			//InitRowInfo(1, 1, 3, 100);
			InitRowInfo(1, 1, 15, 100);
			
			var HeadTitle1 = "|SEL|Carrier|Lane|SEQ|Attachment|Carrier Full Name|Contact Person|E-mail Address|Tel. No.|Fax No.|Service In charge|Office Address|PIC of SML(ID)|Name of PIC|RHQ|Office|Start Date|Creation Date|crr_cntc_seq";
			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
 
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]			
			InitDataProperty(0, cnt++,  dtHiddenStatus,     0,          daCenter,      false,           prefix+"ibflag");
			
            InitDataProperty(0, cnt++ , dtCheckBox,         30,         daCenter,       true,           prefix+"del_chk",               false,          "",      dfNone,      		0);
            InitDataProperty(0, cnt++ , dtComboEdit,		50,			daCenter,		true,			prefix+"jo_crr_cd",				false,          "",      dfNone,      		0,      false,      true,      3);
            InitDataProperty(0, cnt++ , dtComboEdit,		60,			daCenter,		true,			prefix+"rlane_cd",				false,          "",      dfNone,      		0,      true,       true,      5);
            InitDataProperty(0, cnt++ , dtData,				30,			daCenter,		true,			prefix+"rid",			        false,          "",      dfNone,      		0,      false,      false);
            InitDataProperty(0, cnt++ , dtPopup,			80,			daCenter,		true,			prefix+"file_cnt",				false,	        "",	     dfNone,	  		0,	   	true,	    true,	 200);
            InitDataProperty(0, cnt++ , dtData,				180,		daLeft,			true,			prefix+"crr_nm",        		false,          "",      dfNone,      		0,      false,      false);
            InitDataProperty(0, cnt++ , dtData,				160,		daLeft,			true,			prefix+"cntc_pson_nm",			true,           "",      dfNone,      		0,      true,       true,    100);
            InitDataProperty(0, cnt++ , dtData,				140,		daLeft,			true,			prefix+"jo_cntc_eml",			false,          "",      dfNone,      		0,      true,       true,    200);
            InitDataProperty(0, cnt++ , dtData,				160,		daLeft,			true,			prefix+"jo_cntc_phn_no",		false,          "",      dfNone,      		0,      true,       true,     30);
            InitDataProperty(0, cnt++ , dtData,				140,		daLeft,			true,			prefix+"jo_cntc_fax_no",	    false,          "",      dfNone,      		0,      true,       true,     30);
            InitDataProperty(0, cnt++ , dtData,				140,		daLeft,			true,			prefix+"svc_in_chg_nm",			true,           "",      dfNone,      		0,      true,       true,    100);
            InitDataProperty(0, cnt++ , dtData,				160,		daLeft,			true,			prefix+"jo_cntc_ofc_addr",		true,           "",      dfNone,      		0,      true,       true,    200);
            InitDataProperty(0, cnt++ , dtData,				100,		daCenter,		true,			prefix+"jo_cntc_pic_id",		false,          "",      dfNone,    		0,      true,       true,     20);
            InitDataProperty(0, cnt++ , dtData,				160,		daLeft,			true,			prefix+"usr_nm",		        false,          "",      dfNone,     		0,      false,      false,    100);
            InitDataProperty(0, cnt++ , dtData,				 80,		daCenter,		true,			prefix+"ar_hd_qtr_ofc_cd",      false,          "",      dfNone,      		0,      false,      false,      6);
            InitDataProperty(0, cnt++ , dtData,				 80,		daCenter,		true,			prefix+"ofc_cd",                false,          "",      dfNone,            0,      false,      false,      6);
            InitDataProperty(0, cnt++ , dtData,				70,		    daCenter,		true,			prefix+"jo_cntc_st_dt",         false,          "",      dfUserFormat2,     0,      true,       true,     10);
            InitDataProperty(0, cnt++ , dtData,				70,		    daCenter,		true,			prefix+"cre_dt",                false,          "",      dfUserFormat2,     0,      false,      false,     10);
            
            InitDataProperty(0, cnt++ , dtHidden,			30,			daCenter,		true,			prefix+"crr_cntc_seq",			false,          "",      dfNone,      		0,      false,      false);
            
            InitDataCombo(0, prefix+"jo_crr_cd"    , crrSheet, crrSheet, "", "");
			InitDataValid(0, prefix+"jo_crr_cd"    , vtEngUpOnly);//영문대문자
			InitDataValid(0, prefix+"rlane_cd"     , vtEngUpOther, "0123456789");//영문대문자+숫자
			InitDataValid(0, prefix+"jo_cntc_eml"  , vtEngOther, "1234567890@.-_");
			InitUserFormat2(0, prefix+"jo_cntc_st_dt" , "####-##-##", "-");
			InitUserFormat2(0, prefix+"cre_dt" , "####-##-##", "-");
			
		 CountPosition = 0;		 	
		}
		break;

	}
}

// combo object 초기화
function initCombo(comboObj, comboNo, crrCombo) {
    var formObject = document.form
    switch(comboObj.id) {  
    	case "jo_crr_cd":   
           with (comboObj) { 
				MultiSelect = false; 
				UseAutoComplete = true;	
				SetColAlign("left|left");        
				SetColWidth("0|30");
 				DropHeight = 160;
                ValidChar(2,0);
                MaxLength = 3;
                
                
 		    }
            var comboItems = ("ALL,ALL|"+crrCombo).split("|");
            addComboItem(comboObj, comboItems); 
            formObject.jo_crr_cd.Index = 0;
 			break; 
 			
    	case "rlane_cd": 
            with (comboObj) { 
 				MultiSelect = false; 
 				UseAutoComplete = true;	
 				SetColAlign("left");        
 				SetColWidth("50");
  				DropHeight = 160;
  		    }
//            var comboItems = ("ALL,ALL"+"").split("|");
//            addComboItem(comboObj, comboItems); 
//            formObject.rlane_cd.text = "ALL";
  			break; 
    } 
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
		case IBSEARCH: // 조회
		
			if (validateForm(sheetObj, formObj, sAction)){
				formObj.f_cmd.value = SEARCH;

				var sXml = sheetObj.GetSearchXml("FNS_JOO_0066GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));

				sheetObj.LoadSearchXml(sXml);
			}

			 
		break;
			
		case IBSAVE:

			var SaveStr = ComGetSaveString(sheetObjects);
			
			if (!validateForm(sheetObj, formObj, sAction)){
				return;
			}
			if (SaveStr == ""){
				ComShowCodeMessage('JOO00036'); //저장할 데이타가 없음
				return;
			}	
			//저장할것인가?
			if (!ComShowCodeConfirm('JOO00046')){
				return;
			}
			//sheetObj.WaitImageVisible=false;
			ComOpenWait(true);
            try{
				formObj.f_cmd.value = MULTI; 
				var sXml = sheetObj.GetSaveXml("FNS_JOO_0066GS.do",ComGetSaveString(sheetObj) + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
				sheetObj.LoadSearchXml(sXml);
            }finally{
            	ComOpenWait(false);
            }
            
            doActionIBSheet(sheetObj, formObj, IBSEARCH);
		break;
			
		case REMOVE:
			if(!validateForm(sheetObj,formObj,sAction))return;
            sheetObj.WaitImageVisible=false;
            ComOpenWait(true);
			formObj.f_cmd.value = REMOVE;
			var sXml = sheetObj.GetSaveXml("FNS_JOO_0066GS.do", FormQueryString(formObj)); 
			sheetObj.LoadSearchXml(sXml);

			reset0066(2);
			//초기화 function
            ComOpenWait(false);
		break; 
		
		case IBSEARCH_ASYNC01:
			formObj.f_cmd.value = SEARCH17;
			formObj.super_cd1.value = sheetObj.CellValue(currRow, prefix+"jo_crr_cd");
			formObj.super_cd2.value = "";
			formObj.code.value = "";
			sheetObj.WaitImageVisible=false;
			var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj));
			var comboItems = ComGetEtcData(sXml, "rlane_cd");				
		    sheetObj.CellComboItem(currRow, prefix+"rlane_cd", comboItems, comboItems);
		    sheetObj.CellValue2(currRow, prefix+"rlane_cd") = ""; //Change Event가 발생하지 않는다.
			
			break;
	}
}

//조회조건필드인 Lane SVC Type 데이터 조회
function doActionIBCombo(sheetObj,formObj,sAction,sComboObj, sComboKey) {
	//alert('sheetObj__>'+sheetObj+', formObj__>'+formObj+', sAction__>'+sAction+', sComboAction__>'+sComboAction+', sComboKey__>'+sComboKey);
    switch(sAction) {
         
       case IBSEARCH:

			if (sComboObj.id == "rlane_cd"){
				
				var joCrrCd = formObj.jo_crr_cd.Code;
				
				if (joCrrCd == "ALL") joCrrCd = "";
					
				formObj.f_cmd.value = SEARCHLIST07;
				formObj.super_cd1.value = joCrrCd;
				formObj.super_cd2.value = "";
				formObj.code.value = "";
				sheetObj.WaitImageVisible=false;
				formObj.rlane_cd.RemoveAll();
				var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj));
				var comboItems = ("ALL,ALL|"+ComGetEtcData(sXml, sComboKey)).split("|");				
				addComboItem(sComboObj, comboItems);
				sComboObj.Index = 0;
			}
														
	        break;
    }
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
 	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
		case IBSEARCH: //조회
		if(formObj.jo_crr_cd.text.length == 0){
			ComShowCodeMessage('JOO00115', 'Carrier Code');   
			formObj.jo_crr_cd.focus();
			return false;
		}else if(formObj.rlane_cd.text.length == 0){
			ComShowCodeMessage('JOO00115', 'Revenue Code');   
			formObj.rlane_cd.focus();
			return false;
		}
		break;
			
		case IBSAVE:   //저장
		
		for (var inx=sheetObj.HeaderRows; inx <= sheetObj.LastRow; inx++){

			var cntcPsonNm = sheetObj.CellValue(inx, prefix+"cntc_pson_nm");
			var svcInChgNm = sheetObj.CellValue(inx, prefix+"svc_in_chg_nm");
			var joCntcOfcAddr = sheetObj.CellValue(inx, prefix+"jo_cntc_ofc_addr");
		
			if(cntcPsonNm == "" || svcInChgNm == "" || joCntcOfcAddr == "") {
				return false;
			}
		}
		break;
		
		case REMOVE:   //삭제 
		if(formObj.jo_crr_cd.text.length == 0){
			ComShowCodeMessage('JOO00115', 'Carrier Code'); 
			formObj.jo_crr_cd.focus();
			return false;
		}
		if(formObj.crr_cntc_seq.text.length == 0){
			ComShowCodeMessage('JOO00115', 'Seq');
			formObj.crr_cntc_seq.focus();
			return false;
		}
		break;
	} 
	
	return true;
}
 
function sheet1_OnChange(sheetObj, Row, Col, Value) {

	var saveName = sheetObj.ColSaveName(Col); 

	if (saveName == prefix+"jo_crr_cd"){
		UF_setSheetCombo(sheetObj, Row);
		
	}else if (saveName == prefix+"jo_cntc_pic_id") {
			
			var joCntcPicId = sheetObj.CellValue(Row, prefix+"jo_cntc_pic_id");		
			
			if (!ComIsNull(joCntcPicId)) {
				frm.f_cmd.value = SEARCH02;			
				var sXml = sheetObj.GetSearchXml("FNS_JOO_0066GS.do?jo_cntc_pic_id=" + joCntcPicId, FormQueryString(frm));
				var usrNm = ComGetEtcData(sXml,"USR_NM");
				var ofcCd = ComGetEtcData(sXml,"OFC_CD");
				var arHdQtrOfcCd = ComGetEtcData(sXml,"AR_HD_QTR_OFC_CD");

				if ( usrNm != null ) {
					sheetObj.CellValue2(Row, prefix+"usr_nm") = usrNm;
					sheetObj.CellValue2(Row, prefix+"ofc_cd") = ofcCd;
					sheetObj.CellValue2(Row, prefix+"ar_hd_qtr_ofc_cd") = arHdQtrOfcCd;
				}else{
					ComShowCodeMessage("JOO00117", "user ID");
					sheetObj.CellValue(Row,  prefix+"jo_cntc_pic_id") = "";
					sheetObj.CellValue(Row,  prefix+"usr_nm") = "";
					sheetObj.CellValue(Row,  prefix+"ar_hd_qtr_ofc_cd") = "";
					sheetObj.CellValue(Row,  prefix+"ofc_cd") = "";
					sheetObj.SelectCell(Row, prefix+"jo_cntc_pic_id");
				}
			}else{
				sheetObj.CellValue(Row,  prefix+"jo_cntc_pic_id") = "";
				sheetObj.CellValue(Row,  prefix+"usr_nm") = "";
				sheetObj.CellValue(Row,  prefix+"ar_hd_qtr_ofc_cd") = "";
				sheetObj.CellValue(Row,  prefix+"ofc_cd") = "";
			}
	}
	
	
}	


//Carrier코드 변경시 Reset
function jo_crr_cd_OnChange(comboObj, idx_cd, text){
	var formObj = document.form;
	sheetObjects[0].RemoveAll();
	comboObjects[1].Index2 = -1;
	comboObjects[1].RemoveAll();
	comboObj.Enable = false;
	doActionIBCombo(sheetObjects[0], formObj, IBSEARCH, comboObjects[1], "rlane_cd");
	comboObj.Enable = true;		
}

function rlane_cd_OnChange(comboObj, idx_cd, text){
	sheetObjects[0].RemoveAll();
}

function rlane_cd_OnFocus(comboObj){
//	var formObj = document.form;
//	if (comboObj.GetCount() == 0){
//		comboObj.Enable = false;
//		doActionIBCombo(sheetObjects[0], formObj, IBSEARCH, comboObj, "rlane_cd");
//		comboObj.Enable = true;		
//	}
}

function sheet1_OnPopupClick(sheetObj, Row, Col){
	
	var saveName = sheetObj.ColSaveName(Col);
	
	if (saveName == prefix+"file_cnt"){
		
		var joCrrCd    = sheetObj.CellValue(Row, prefix+"jo_crr_cd");
		var crrCntcSeq = sheetObj.CellValue(Row, prefix+"crr_cntc_seq");
		
		if (crrCntcSeq == "") {
			//ComShowCodeMessage('JOO00003');
			return;
		}
		
		var param = "?jo_crr_cd="+joCrrCd+"&crr_cntc_seq="+crrCntcSeq+"&edit_able="+"Y";
		ComOpenPopup("/hanjin/FNS_JOO_0082.do"+param, 835, 450, "popupFinish", "1,0,1,1,1,1,1,1", true, false, 0, 0, 0, "pop1");		
	}
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	
	for (var i=sheetObj.HeaderRows; i <= sheetObj.LastRow; i++){
		UF_setSheetCombo(sheetObj, i);
	}
}

function UF_setSheetCombo(sheetObj, Row){
	var rlaneSheet = " |";
	var joCrrCd = sheetObj.CellValue(Row, prefix+"jo_crr_cd");
	
	for (var inx=0; inx < arrCrrRlane.length; inx++){
		if (arrCrrRlane[inx][0] == joCrrCd){
			rlaneSheet = rlaneSheet + arrCrrRlane[inx][1] + "|"; 
		}
	}
	if (rlaneSheet.length > 0){
		rlaneSheet = rlaneSheet.substring(0,rlaneSheet.length-1);
	}
    sheetObj.CellComboItem(Row, prefix+"rlane_cd" , rlaneSheet, rlaneSheet);
}
/* 개발자 작업  끝 */