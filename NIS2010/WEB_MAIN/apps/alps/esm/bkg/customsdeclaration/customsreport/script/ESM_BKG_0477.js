/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : Esm_bkg_0477.js
 *@FileTitle : ESM_BKG-0477
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.03
 *@LastModifier : 김승민
 *@LastVersion : 1.0
 * 2009.06.03 김승민
 * 1.0 Creation
 * History :
 * 2010.12.17 이수진 [CHM-201007493] SEA-NACCS DOR User ID 표시 추가 및 검색 기능 개선 요청		 
 *           작업내용 : User ID에 영대/영소/숫자/_ 만 입력 가능하도록 수정 
	 
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
 * @class ESM_BKG-0477 : ESM_BKG-0477 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0477() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업 */
// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_resend":
			doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
			break;

		case "btn_retrieve":
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
			break;
		case "btn_view":
			doActionIBSheet(sheetObjects[0], formObject, SEARCH11);
			break;
        case "btns_calendar": //달력버튼
        	// 조회전 일땐 사용못하게 ...
            var cal = new ComCalendarFromTo();
            cal.select(formObject.start_snd_dt,formObject.end_snd_dt, 'yyyy-MM-dd');
            break;				

		break;

	} // end switch
} catch (e) {
	if (e == "[object Error]") {
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
* @param sheet_obj IBSheet Object
*/
function setSheetObject(sheet_obj) {

sheetObjects[sheetCnt++] = sheet_obj;

}

/**
* Sheet 기본 설정 및 초기화
* body 태그의 onLoad 이벤트핸들러 구현
* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
*/
function loadPage() {

for (i = 0; i < sheetObjects.length; i++) {

	// khlee-시작 환경 설정 함수 이름 변경
	ComConfigSheet(sheetObjects[i]);

	initSheet(sheetObjects[i], i + 1);
	// khlee-마지막 환경 설정 함수 추가
	ComEndConfigSheet(sheetObjects[i]);
}
initControl();
}



/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * 
 * @param {ibsheet}
 *            sheetObj IBSheet Object
 * @param {int}
 *            sheetNo sheetObjects 배열에서 순번 
 */
function initControl() {
// ** Date 구분자 **/
DATE_SEPARATOR = "-";
 
var formObject = document.form;
// Axon 이벤트 처리1. 이벤트catch(개발자변경)
axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); // - 키보드
axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
//axon_event.addListenerForm  ('blur', 'obj_deactivate',  formObject); //- 포커스 나갈때
//axon_event.addListenerFormat('focus',   'obj_activate',    formObject); //- 포커스 들어갈때
axon_event.addListener('keydown', 'ComKeyEnter', 'form');
axon_event.addListener('click', 'chkClick', 'form');

formObject.vvd_cd.focus(); 
}

/**
 * 조회조건 입력할 때 처리
 */
function obj_KeyUp() {
var formObject = document.form;
var srcName = window.event.srcElement.getAttribute("name");
var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
var srcValue = window.event.srcElement.getAttribute("value");
if (ComChkLen(srcValue, srcMaxLength) == "2") {
	ComSetNextFocus();
}
}

/**
 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
 */
function obj_keypress() {
	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which
			: event.charCode;
	var srcName = event.srcElement.getAttribute("name");
	var srcValue = event.srcElement.getAttribute("value");
	
switch (event.srcElement.dataformat) {
case "uppernum":
	// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	ComKeyOnlyAlphabet('uppernum');
	break;
case "upper":
	// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	ComKeyOnlyAlphabet('upper');
	break;	
case "uppernum2":
	// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	ComKeyAlphabetNChar('uppernum2');
	break;	
case "num":
	// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	ComKeyOnlyNumber('num', ':');
	break;
case "num2":
	// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	ComKeyOnlyNumber('num', '');
	break;
case "num3":
	// 영문과 숫자 입력할수 있고, 자동 변환없이 그대로 표시한다, 영문+숫자 -> ComKeyOnlyAlphabet('num');
	ComKeyOnlyAlphabet('num', '95');
	break;
case "ymd":
	// alert(srcValue.length);
	ComKeyOnlyNumber(event.srcElement);
	if (srcValue.length == 4) {
		document.form.elements[srcName].value = srcValue.substring(0, 4) + "-"
	}
	if (srcValue.length == 7) {
		document.form.elements[srcName].value = srcValue.substring(0, 7) + "-"
	}
	break;	
case "hm":
	// alert(srcValue.length);
	ComKeyOnlyNumber(event.srcElement);
	if (srcValue.length == 2) {
		document.form.elements[srcName].value = srcValue.substring(0, 4) + ":"
	}
	break;		
default:
	// 숫자만입력하기(정수,날짜,시간)
	ComKeyOnlyNumber(event.srcElement);
}
}

/**
 * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
 **/
function obj_activate(){
	//입력Validation 확인하기
	switch(event.srcElement.name){
		case "start_snd_dt":
			ComClearSeparator(event.srcElement);
			break;	
    	case "end_snd_dt":
    		ComClearSeparator(event.srcElement);
			break;
		default:
			break;
			//return;
			//ComAddSeparator(event.srcElement);
			//ComChkObjValid(event.srcElement);
	}
}

/**
 * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
 **/
function obj_deactivate(){
	//if (event.srcElement.getAttribute("required") != null) return;
	
    //입력Validation 확인하기
	switch(event.srcElement.name){
	
    	case "start_snd_dt":
    		ComAddSeparator(event.srcElement);
			break;
    	case "end_snd_dt":
    		ComAddSeparator(event.srcElement);
			break;
		default:
			break;
			//ComAddSeparator(event.srcElement);
			//ComChkObjValid(event.srcElement);
	}
}  

 /**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 * @param sheetObj 시트오브젝트
 * @param sheetNo 시트오브젝트 태그의 아이디에 붙인 일련번호
 */
function initSheet(sheetObj,sheetNo) {

    var cnt = 0;
			var sheetID = sheetObj.id;
			
    switch(sheetID) {
			case "sheet1":      //sheet1 init
            with (sheetObj) {
                // 높이 설정
                style.height = 420;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 3, 100);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(15, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false)

                var HeadTitle1 = "|Sel.|Seq.|MSG|SEND Date|Send Date|Office|User ID|VVD|POD|B/L No.|STS|Update|Update|";
                
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true,
        		"ibflag");	
                InitDataProperty(0, cnt++ , dtRadioCheck,	 30,    daCenter,  true,   "sel");
                InitDataProperty(0, cnt++ , dtDataSeq,      		 45,    daCenter,  true,   "seq");       
                InitDataProperty(0, cnt++ , dtData,   		 	 65,    daCenter,  true,   "jp_snd_log_id",    				false,          "",      dfNone,   	0,     false,       true);
                InitDataProperty(0, cnt++ , dtData,       	 80,   daCenter,  true,   "snd_dt",  	 	false,          "",      dfDateYmd,	0,     false,       true);
                InitDataProperty(0, cnt++ , dtData,       	 80,   daCenter,  true,   "snd_dt2",  	 	false,          "",      dfTimeHms,	0,     false,       true);
                                                                                                                                           	
                InitDataProperty(0, cnt++ , dtData,       	 70,    daCenter,  true,   "ofc_cd",       	false,          "",      dfNone,   	0,     false,       true);
                InitDataProperty(0, cnt++ , dtData,       	 85,    daCenter,  true,   "upd_usr_id",      	false,          "",      dfNone,   	0,     false,       true);
                InitDataProperty(0, cnt++ , dtData,       	 95,    daCenter,  true,   "vvd_cd",      			false,          "",      dfNone,	 	0,     false,       true);
                InitDataProperty(0, cnt++ , dtData,       	 65,    daCenter,  true,   "pod_cd",  	 				false,          "",      dfNone,   	0,     false,       true); 
                InitDataProperty(0, cnt++ , dtData,       	 130,    daCenter,  true,   "bl_no",  	 			false,          "",      dfNone,   	0,     false,       true);                    
                                                                                                                                           	
                InitDataProperty(0, cnt++ , dtData,       	 60,    daCenter,  true,   "log_flg",  	 				false,          "",      dfNone,   	0,     false,       true); 
                InitDataProperty(0, cnt++ , dtData,       	 100,   daCenter,  true,   "log_dt",  	 		false,          "",      dfDateYmd,	0,     false,       true);
                InitDataProperty(0, cnt++ , dtData,       	 50,    daCenter,  true,   "log_dt2",  	 		false,          "",      dfTimeHm,	0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,       	 50,    daCenter,  true,   "log_seq",  	 		false,          "",      dfTimeHm,	0,     false,       true);
                
                //카운트를 표시할 포지션 /0의 경우 비표시 
				CountPosition = 2; 
				//토탈카운트표시 
				CountFormat = "[SELECTDATAROW / TOTALROWS]"; 

           }
            break;


    }
}

/**
* Sheet관련 프로세스 처리
* @param sheetObj Sheet
* @param formObj form객체
* @param sAction 작업처리코드
* @param CondParam CondParam
* @param PageNo PageNo
*/
function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
sheetObj.ShowDebugMsg = false;
switch (sAction) {

case IBSAVE: // 조회
	if (validateForm(sheetObj, formObj, sAction)) {
		formObj.f_cmd.value = MULTI;
		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);
		sheetObj.DoSave("ESM_BKG_0477GS.do", FormQueryString(formObj));
		ComOpenWait(false);
		doActionIBSheet(sheetObj, formObj, IBSEARCH);
	}
	break;

case IBSEARCH: // 조회
	if (validateForm(sheetObj, formObj, sAction)) {
		if ( formObj.date_check.checked )
			formObj.date_check.value = "Y";
		else
			formObj.date_check.value = "";
		//alert(formObj.date_check.value);
		formObj.f_cmd.value = SEARCH;
		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);
		sheetObj.DoSearch("ESM_BKG_0477GS.do", FormQueryString(formObj));
		ComOpenWait(false);

	}
	break;
case IBSEARCHAPPEND:  // 페이징 조회
	if (!validateForm(sheetObj,formObj,IBSEARCH)) return false;
	if ( formObj.date_check.checked )
		formObj.date_check.value = "Y";
	else
		formObj.date_check.value = "";	
	formObj.f_cmd.value = SEARCH;
	sheetObj.WaitImageVisible = false;
	ComOpenWait(true);
	if(PageNo >= 1){
		sheetObj.DoSearch("ESM_BKG_0477GS.do", CondParam, "iPage=" + PageNo, true);
	}else{
		sheetObj.DoSearch("ESM_BKG_0477GS.do", FormQueryString(formObj), "iPage=1", false);
	}
	ComOpenWait(false);
	break;	
case SEARCH11: // 저장
	if (validateForm(sheetObj, formObj, sAction)) {
		var jpSndLogId = "";
		var sndDt = "";
		var sndDt2 = "";
		var logSeq = "";
		var ofcCd = "";
		var bl_no = "";
		for(var i=1; i <= sheetObjects[0].RowCount; i++) {
			if (sheetObjects[0].CellValue(i, "sel") == 1) {
				jpSndLogId = sheetObjects[0].CellValue(i, "jp_snd_log_id");
				sndDt = sheetObjects[0].CellValue(i, "snd_dt");
				sndDt2 = sheetObjects[0].CellValue(i, "snd_dt2");
				logSeq = sheetObjects[0].CellValue(i, "log_seq");
				ofcCd = sheetObjects[0].CellValue(i, "ofc_cd");
				blNo = sheetObjects[0].CellValue(i, "bl_no");
				break;
			}			
		}		
		var sUrl = "/hanjin/ESM_BKG_0478.do?pgmNo=ESM_BKG_0478&jpSndLogId="+jpSndLogId+"&blNo="+blNo+"&sndDt="+sndDt+sndDt2+"&logSeq="+logSeq+"&ofcCd="+ofcCd;
		//var sUrl = "/hanjin/ESM_BKG_0456.do?bl_no="+selectedBlNumber;
		//ComOpenWindowCenter(sUrl, "ESM_BKG_0458", 1024, 768, false);
		ComOpenWindowCenter(sUrl, "ESM_BKG_0478", 600, 380, false);
	}

	break;
}
}

/**
* Sheet에서 스크롤시 페이징 처리
* @param sheetObj Sheet
* @param CondParam CondParam
* @param PageNo PageNo
* @param OnePageRows OnePageRows
*/
function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
	//alert("test");
	doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, CondParam, PageNo);
}

/**
* 화면 폼입력값에 대한 유효성검증 프로세스 처리
* @param sheetObj Sheet
* @param formObj form객체
* @param sAction 작업처리코드
*/
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: // 조회
 		if ( !formObj.date_check.checked && formObj.vvd_cd.value=="" && formObj.usr_id.value=="" && formObj.ofc_cd.value=="")
 		{
 				ComShowCodeMessage('BKG06004');
 				formObj.start_snd_dt.focus();
 				return false;  			
 		}
 			
		if ( formObj.date_check.checked )
 		{
 			if ( formObj.start_snd_dt.value == "" )
 			{
 				ComShowCodeMessage('BKG00528');
 				formObj.start_snd_dt.focus();
 				return false; 				
 			}
 			if ( formObj.start_snd_dt2.value == "" || formObj.start_snd_dt2.value.length != "5" )
 			{
 				ComShowCodeMessage('BKG00528');
 				formObj.start_snd_dt2.focus();
 				return false; 				
 			} 			
 			if ( formObj.end_snd_dt.value == "" )
 			{
 				ComShowCodeMessage('BKG00528');
 				formObj.end_snd_dt.focus();
 				return false; 				
 			} 		
 			if ( formObj.end_snd_dt2.value == "" || formObj.end_snd_dt2.value.length != "5" )
 			{
 				ComShowCodeMessage('BKG00528');
 				formObj.end_snd_dt2.focus();
 				return false; 				
 			}  
 			
 			
 			if ( formObj.start_snd_dt2.value.substring(0, 1)==":" || formObj.start_snd_dt2.value.substring(1, 2)==":" )
 			{
 				ComShowCodeMessage('BKG00528');
 				formObj.start_snd_dt2.focus();
 				return false; 				
 			} else {
 				var hh = parseInt(eval(formObj.start_snd_dt2.value.substring(0, 2)));
 				if (!(0 <= hh && hh <= 23)) {
 					ComShowCodeMessage('BKG00528');
	 				formObj.start_snd_dt2.focus();
	 				return false;
	 			}
 			}
 			if ( formObj.start_snd_dt2.value.substring(3, 4)==":" || formObj.start_snd_dt2.value.substring(4, 5)==":" )
 			{
 				ComShowCodeMessage('BKG00528');
 				formObj.start_snd_dt2.focus();
 				return false; 				
 			} else { 			
	 			var mi = parseInt(eval(formObj.start_snd_dt2.value.substring(3, 5)));
	 			if (!(0 <= mi && mi <= 59)) {
	 				ComShowCodeMessage('BKG00528');
	 				formObj.start_snd_dt2.focus();
	 				return false;
	 			}
 			}

 			if ( formObj.end_snd_dt2.value.substring(0, 1)==":" || formObj.end_snd_dt2.value.substring(1, 2)==":" )
 			{
 				ComShowCodeMessage('BKG00528');
 				formObj.start_snd_dt2.focus();
 				return false; 				
 			} else { 			
	 			var hh2 = parseInt(eval(formObj.end_snd_dt2.value.substring(0, 2)));
	 			if (!(0 <= hh2 && hh2 <= 23)) {
	 				ComShowCodeMessage('BKG00528');
	 				formObj.end_snd_dt2.focus();
	 				return false;
	 			}
 			}
 			if ( formObj.end_snd_dt2.value.substring(3, 4)==":" || formObj.end_snd_dt2.value.substring(4, 5)==":" )
 			{
 				ComShowCodeMessage('BKG00528');
 				formObj.start_snd_dt2.focus();
 				return false; 				
 			} else { 	 			
	 			var mi2 = parseInt(eval(formObj.end_snd_dt2.value.substring(3, 5)));
	 			if (!(0 <= mi2 && mi2 <= 59)) {
	 				ComShowCodeMessage('BKG00528');
	 				formObj.end_snd_dt2.focus();
	 				return false;
	 			} 	
 			}
 		}
		if ( formObj.vvd_cd.value != "" && formObj.vvd_cd.value.length != 9 ) {
			ComShowCodeMessage('BKG00251');
			formObj.vvd_cd.focus();
			return false;	
		}	
		
		if (!ComChkValid(formObj)) 
		{
			formObj.start_snd_dt.focus();
			return false;	
		}
		
		return true;
		break;
	case IBSAVE: // 조회
		var vIsCheck = false;
		//alert(sheetObj.RowCount);
		for(var i=1; i <= sheetObj.RowCount; i++) {
			if (sheetObj.CellValue(i, "sel") == 1) {
				vIsCheck = true;
				break;
			}
		}
		if (!vIsCheck) {
			ComShowCodeMessage('BKG00249','');
			return false;
		}				
		return true;
		break;	
	case SEARCH11: // 조회
		var vIsCheck = false;
		//alert(sheetObj.RowCount);
		for(var i=1; i <= sheetObj.RowCount; i++) {
			if (sheetObj.CellValue(i, "sel") == 1) {
				vIsCheck = true;
				break;
			}
		}
		if (!vIsCheck) {
			ComShowCodeMessage('BKG00249','');
			return false;
		}				
		return true;
		break;			
		
	}
}

/**
* 날짜로 조회여부에 따른 날짜필드 초기화
*/
function chkClick(){
	if(event.srcElement.name == "date_check"){
		
		var sr = event.srcElement;
		if(sr.checked){
			form.start_snd_dt.className = "input";
			form.end_snd_dt.className = "input";
			form.start_snd_dt2.className = "input";
			form.end_snd_dt2.className = "input";
		}else{
			form.start_snd_dt.className = "input2";
			form.end_snd_dt.className = "input2";
			form.start_snd_dt2.className = "input2";
			form.end_snd_dt2.className = "input2";
			
			//form.start_snd_dt.value = "";
			//form.end_snd_dt.value = "";
			//form.start_snd_dt2.value = "00:00";
			//form.end_snd_dt2.value = "23:59";

		}
	}
	
}
/* 개발자 작업 끝 */