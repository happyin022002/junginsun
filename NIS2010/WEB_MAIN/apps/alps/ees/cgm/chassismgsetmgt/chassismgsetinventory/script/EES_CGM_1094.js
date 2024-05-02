/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_CGM_1094.js
 *@FileTitle : Chassis Long Staying Environment
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.22
 *@LastModifier : 조재성
 *@LastVersion : 1.0
 * 2009.07.22 조재성
 * 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/


/**
 * @extends 
 * @class EES_CGM_1094 : EES_CGM_1094 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function EES_CGM_1094() {
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

//공통전역변수
var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1; 

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var focusInBuVal = 0;

var CanMakeData = true;

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
 * @param 없음
 * @return 없음
 * @author 조재성
 * @version 2009.07.22
 */ 
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

		case "btn_retrieve":
			// IBSHEET 조회
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
			break;
		case "btn_save":
			doActionIBSheet(sheetObject2, formObject, IBSAVE);
			break;

		case "btn_new":
			initControl();
			break;

		//case "btn_close":
			//comPopupOK();
			//self.close();
			//break;
			
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
* IBSheet Object를 배열로 등록 <br>
* @param  {object} sheet_obj	필수
* @return 없음
* @author 조재성
* @version 2009.07.22
*/
function setSheetObject(sheet_obj){

	sheetObjects[sheetCnt++] = sheet_obj;

}


/**
* IBMultiCombo Object를 배열로 등록
* param : combo_obj ==> 콤보오브젝트
* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
* 배열은 소스 상단에 정의
*/
function setComboObject(combo_obj) {

	comboObjects[comboCnt++] = combo_obj;
}


/**
* Sheet 기본 설정 및 초기화 <br>
* body 태그의 onLoad 이벤트핸들러 구현 <br>
* @param  없음
* @return 없음
* @author 조재성
* @version 2009.07.22
*/
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		//시작 환경 설정 함수 이름 변경
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		
		//마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	var formObj = document.form;
	// axon event 등록
	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
	axon_event.addListenerFormat('blur', 'obj_blur', form);
	axon_event.addListenerFormat('focusin', 'obj_focusin', form);
	//axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
	//axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form);
	//axon_event.addListener('change', 'obj_change' , 'crnt_yd_cd');  
	//axon_event.addListener('change', 'obj_change', 'vndr_seq'); 
	//axon_event.addListener('focusout', 'obj_focusout', 'crnt_yd_cd');
	
	//화면 컨트롤
	initControl(sheetObjects[0]);
	
	// IBSHEET 조회
	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);	
}

/**
* Sheet 로딩 후 기본 설정 및 초기화 <br>
* @param  없음
* @return 없음
* @author 조재성
* @version 2009.10.20
*/     
function sheet1_OnLoadFinish(sheetObj) {
    sheetObj.WaitImageVisible = false;
 
    
    sheetObj.WaitImageVisible = true; 
}

/**
 * Form의 Conrol 를 초기화 시킨다. <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2009.07.22
 */
function initControl(){
	var formObj = document.form;
	var sheetObj = sheetObjects[0];

	// Form Object 초기화
	with(formObj){
		// 그리드 값을 폼 객체로 세팅
		staying_days.value		= 0;
		n1st_inq_fm_dys.value	= 0;
		n1st_inq_to_dys.value	= 15;
		n2nd_inq_fm_dys.value	= parseInt(n1st_inq_to_dys.value.parseInt()) + 1;
		n2nd_inq_to_dys.value	= 30;
		n3rd_inq_fm_dys.value	= parseInt(n2nd_inq_to_dys.value) + 1;
		n3rd_inq_to_dys.value	= 50;
		n4th_inq_fm_dys.value	= parseInt(n3rd_inq_to_dys.value) + 1;
		n4th_inq_to_dys.value	= 100;
		n5th_inq_fm_dys.value	= parseInt(n4th_inq_to_dys.value) + 1;
		n5th_inq_to_dys.value	= 180;
		n6th_inq_fm_dys.value	= parseInt(n5th_inq_to_dys.value) + 1;
	}
	
}

/**
 * 시트 초기설정값, 헤더 정의 <br>
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
 * @param  {object} sheetObj	필수	 Sheet Object
 * @param  {int} sheetNo		필수 시트오브젝트 태그의 아이디에 붙인 일련번호
 * @return 없음
 * @author 조재성
 * @version 2009.07.22
 */
function initSheet(sheetObj,sheetNo) {
	var cnt = 0;

	switch (sheetNo) {
	case 1: // t1sheet1 init
	with (sheetObj) {

		// 높이 설정
		style.height = 80;

		//전체 너비 설정
		SheetWidth = mainTable.clientWidth;

		//Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

		//전체Merge 종류 [선택, Default msNone]
		MergeSheet = msHeaderOnly;

		//전체Edit 허용 여부 [선택, Default false]
		Editable = true;

		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo(1, 1, 3, 100);

		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(11, 0, 0, true);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(true, true, true, true, false, false)
		var HeadTitle = "|n1st_inq_fm_dys|n1st_inq_to_dys|n2nd_inq_fm_dys|n2nd_inq_to_dys|n3rd_inq_fm_dys|n3rd_inq_to_dys|n4th_inq_fm_dys|n4th_inq_to_dys|n5th_inq_fm_dys|n5th_inq_to_dys";

		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle, true);

		//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		InitDataProperty(0,	cnt++,	dtStatus,	50,		daCenter,	true,	"ibflag");
	  //InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"stay_dys_inp_usr_id",	false,	"",	dfNone,	0,	false,	false);
		InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"n1st_inq_fm_dys",		false,	"",	dfNone,	0,	false,	false);
		InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"n1st_inq_to_dys",		false,	"",	dfNone,	0,	false,	false);
		InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"n2nd_inq_fm_dys",		false,	"",	dfNone,	0,	false,	false);
		InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"n2nd_inq_to_dys",		false,	"",	dfNone,	0,	false,	false);
		InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"n3rd_inq_fm_dys",		false,	"",	dfNone,	0,	false,	false);
		InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"n3rd_inq_to_dys",		false,	"",	dfNone,	0,	false,	false);
		InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"n4th_inq_fm_dys",		false,	"",	dfNone,	0,	false,	false);
		InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"n4th_inq_to_dys",		false,	"",	dfNone,	0,	false,	false);
		InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"n5th_inq_fm_dys",		false,	"",	dfNone,	0,	false,	false);
		InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"n5th_inq_to_dys",		false,	"",	dfNone,	0,	false,	false);
	}
	break;

	case 2:
		with (sheetObj) {

			// 높이 설정
			style.height = 80;

			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(11, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			var HeadTitle = "|n1st_inq_fm_dys|n1st_inq_to_dys|n2nd_inq_fm_dys|n2nd_inq_to_dys|n3rd_inq_fm_dys|n3rd_inq_to_dys|n4th_inq_fm_dys|n4th_inq_to_dys|n5th_inq_fm_dys|n5th_inq_to_dys";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,  INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
		  //InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"stay_dys_inp_usr_id",	false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"n1st_inq_fm_dys",		false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"n1st_inq_to_dys",		false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"n2nd_inq_fm_dys",		false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"n2nd_inq_to_dys",		false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"n3rd_inq_fm_dys",		false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"n3rd_inq_to_dys",		false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"n4th_inq_fm_dys",		false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"n4th_inq_to_dys",		false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"n5th_inq_fm_dys",		false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"n5th_inq_to_dys",		false,	"",	dfNone,	0,	false,	false);
			
		}
		break;
	}
}


/**
 * Sheet관련 프로세스 처리 <br>
 * @param  {object} sheetObj	필수	 Sheet Object
 * @param  {object} formObj	필수 Form Object
 * @param  {String} sAction	필수 Action Type
 * @return 없음
 * @author 조재성
 * @version 2009.07.21
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSEARCH:      //조회
			formObj.f_cmd.value = SEARCH01;
			sheetObj.DoSearch("EES_CGM_1094GS.do", FormQueryString(formObj));
			
			// 그리드 값을 폼 객체로 세팅
			if(sheetObj.RowCount=='0') // 리턴데이터가 없으면.
			{
				formObj.staying_days.value		= 0; //chungpa 20091015 staying_days.
				formObj.n1st_inq_fm_dys.value	= 0;
				formObj.n1st_inq_to_dys.value	= 15;
				formObj.n2nd_inq_fm_dys.value	= parseInt(formObj.n1st_inq_to_dys.value.parseInt()) + 1;
				formObj.n2nd_inq_to_dys.value	= 30;
				formObj.n3rd_inq_fm_dys.value	= parseInt(formObj.n2nd_inq_to_dys.value) + 1;
				formObj.n3rd_inq_to_dys.value	= 50;
				formObj.n4th_inq_fm_dys.value	= parseInt(formObj.n3rd_inq_to_dys.value) + 1;
				formObj.n4th_inq_to_dys.value	= 100;
				formObj.n5th_inq_fm_dys.value	= parseInt(formObj.n4th_inq_to_dys.value) + 1;
				formObj.n5th_inq_to_dys.value	= 180;
				formObj.n6th_inq_fm_dys.value	= parseInt(formObj.n5th_inq_to_dys.value) + 1;
			}else
			{
				formObj.staying_days.value		= sheetObj.CellValue(1,"n1st_inq_fm_dys"); //chungpa 20091015 staying_days.
				formObj.n1st_inq_fm_dys.value	= sheetObj.CellValue(1,"n1st_inq_fm_dys");
				formObj.n1st_inq_to_dys.value	= sheetObj.CellValue(1,"n1st_inq_to_dys");
				formObj.n2nd_inq_fm_dys.value	= sheetObj.CellValue(1,"n2nd_inq_fm_dys");
				formObj.n2nd_inq_to_dys.value	= sheetObj.CellValue(1,"n2nd_inq_to_dys");
				formObj.n3rd_inq_fm_dys.value	= sheetObj.CellValue(1,"n3rd_inq_fm_dys");
				formObj.n3rd_inq_to_dys.value	= sheetObj.CellValue(1,"n3rd_inq_to_dys");
				formObj.n4th_inq_fm_dys.value	= sheetObj.CellValue(1,"n4th_inq_fm_dys");
				formObj.n4th_inq_to_dys.value	= sheetObj.CellValue(1,"n4th_inq_to_dys");
				formObj.n5th_inq_fm_dys.value	= sheetObj.CellValue(1,"n5th_inq_fm_dys");
				formObj.n5th_inq_to_dys.value	= sheetObj.CellValue(1,"n5th_inq_to_dys");
				formObj.n6th_inq_fm_dys.value	= parseInt(formObj.n5th_inq_to_dys.value) + 1;
				
				CanMakeData = false; // 따로 데이터를 편집하기 전까진 자동으로 데이터를 생성하지 않는다. 
			}
			sheetObj.RowStatus(1) = "U"; // I,R,U,D
			break;
		case IBSAVE:
			var actionFlag = false; 
			formObj.f_cmd.value = MULTI;
			
			sheetObj.RemoveAll();
			sheetObj.DataInsert(-1);
			sheetObj.CellValue(1, "n1st_inq_fm_dys") =  formObj.n1st_inq_fm_dys.value;
			sheetObj.CellValue(1, "n1st_inq_to_dys") =  formObj.n1st_inq_to_dys.value;
			sheetObj.CellValue(1, "n2nd_inq_fm_dys") =  formObj.n2nd_inq_fm_dys.value;
			sheetObj.CellValue(1, "n2nd_inq_to_dys") =  formObj.n2nd_inq_to_dys.value;
			sheetObj.CellValue(1, "n3rd_inq_fm_dys") =  formObj.n3rd_inq_fm_dys.value;
			sheetObj.CellValue(1, "n3rd_inq_to_dys") =  formObj.n3rd_inq_to_dys.value;
			sheetObj.CellValue(1, "n4th_inq_fm_dys") =  formObj.n4th_inq_fm_dys.value;
			sheetObj.CellValue(1, "n4th_inq_to_dys") =  formObj.n4th_inq_to_dys.value;
			sheetObj.CellValue(1, "n5th_inq_fm_dys") =  formObj.n5th_inq_fm_dys.value;
			sheetObj.CellValue(1, "n5th_inq_to_dys") =  formObj.n5th_inq_to_dys.value;
			
			for(i=1;i<sheetObj.LastRow+1;i++)
			{
			  sheetObj.RowStatus(i) = "U";
			}
			
			if(actionFlag){
			    // Status 가 OK 가 아닌 ROW 를 Save 시도시 CGM10007 메시지 출력
	        	ComShowCodeMessage("CGM10007");
			} else {
	 			if(sheetObj.DoSave("EES_CGM_1094GS.do", FormQueryString(formObj)))
	 			{
	 				ComShowCodeMessage("CGM00003");
	 			}else
	 			{
	 				
	 			}
			}
		 	//var params = sheetObj.GetSaveString(true);		
			break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
 * @param  {object} sheetObj	필수	 Sheet Object
 * @param  {object} formObj	필수 Form Object
 * @param  {String} sAction	필수 Action Type (IBSEARCH, IBSEARCH_ASYNC01, RDPRINT, IBDOWNEXCEL)
 * @return {boolean}			false => validation 체크 오류, true => validation 체크 성공
 * @author 조재성
 * @version 2009.07.21
 */ 
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		switch(sAction){
		case IBSEARCH:

			break;
		}
	}
}

/**
 * Sheet1 의 OnSearchEnd 이벤트처리 <br>
 * @param  {object} sheetObj	필수	 Sheet Object
 * @param  {string} ErrMsg		필수 String
 * @return 없음
 * @version 2009.07.16
 */ 
function sheet1_OnSearchEnd(sheetObj, ErrMsg)
{
	with(sheetObj)
	{

	}
}

/** 
 * Object 의 activate 이벤트에 대한 처리  <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2009.07.22
 */
function obj_activate(){
	ComClearSeparator(event.srcElement);
} 

/** 
 * Object 의 deactivate 이벤트에 대한 처리  <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2009.07.22
 */
function obj_deactivate(){
	ComChkObjValid(event.srcElement);
}

/** 
 * Object 의 Keypress 이벤트에 대한 처리  <br>
 * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2009.07.22
 */ 
function obj_keypress(){
	obj = event.srcElement;
    if(obj.dataformat == null) return;
    window.defaultStatus = obj.dataformat;
    
    var formObj = document.form;
    switch(obj.dataformat) {
        case "ymd":
        case "ym":
        case "hms":
        case "hm":
        case "jumin":
        case "saupja":
            ComKeyOnlyNumber(obj);
            break;
        case "int":
        	if(obj.name=="staying_days")
        	{
//				chungpa 20091029 현업 삭제요청.        		
//        		if(event.keyCode == 13) // Enter키이면 검색.
//        		{
//        			// IBSHEET 조회
//        			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
//        			return;
//        		}
        		ComKeyOnlyNumber(obj);
        	}else if(obj.name=="n1st_inq_fm_dys")
            {
            	ComKeyOnlyNumber(obj);
            }else if(obj.name=="n1st_inq_to_dys")
            {
            	ComKeyOnlyNumber(obj);
            }else if(obj.name=="n2nd_inq_fm_dys")
            {
            	ComKeyOnlyNumber(obj);
            }else if(obj.name=="n2nd_inq_to_dys")
            {
            	ComKeyOnlyNumber(obj);
            }else if(obj.name=="n3rd_inq_fm_dys")
            {
            	ComKeyOnlyNumber(obj);
            }else if(obj.name=="n3rd_inq_to_dys")
            {
            	ComKeyOnlyNumber(obj);
            }else if(obj.name=="n4th_inq_fm_dys")
    		{
            	ComKeyOnlyNumber(obj);
    		}else if(obj.name=="n4th_inq_to_dys")
            {
    			ComKeyOnlyNumber(obj);
            }else if(obj.name=="n5th_inq_fm_dys")
            {
            	ComKeyOnlyNumber(obj);
            }else if(obj.name=="n5th_inq_to_dys")
            {
            	ComKeyOnlyNumber(obj);
            }else if(obj.name=="n6th_inq_fm_dys")
            {
            	ComKeyOnlyNumber(obj);
            }
            break;
        case "float":
            ComKeyOnlyNumber(obj, "-.");
            break;
        case "eng":
            ComKeyOnlyAlphabet(); break;
        case "engup":
            if(obj.name=="txtEngUp2") ComKeyOnlyAlphabet('uppernum')
            else ComKeyOnlyAlphabet('upper');
            break;
        case "engdn":
            if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
            else ComKeyOnlyAlphabet('lower');
            break;
    }	

} 

/** 
 * Object 의 focusin 이벤트에 대한 처리  <br>
 * form FOCUS_IN 처리.  <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2009.07.28
 */ 
function obj_focusin(){
	var formObj = document.form;
	var obj   	= event.srcElement;
	
	CanMakeData = true; // 자동 데이터 생성 true로 설정.
	
	if(obj.name=="staying_days")
	{
		focusInBuVal = parseInt(formObj.staying_days.value); 
	}else if(obj.name=="n1st_inq_fm_dys")
    {
		
    }else if(obj.name=="n1st_inq_to_dys")
    {
    	focusInBuVal = parseInt(formObj.n1st_inq_to_dys.value);
    }else if(obj.name=="n2nd_inq_fm_dys")
    {

    }else if(obj.name=="n2nd_inq_to_dys")
    {
    	focusInBuVal = parseInt(formObj.n2nd_inq_to_dys.value);
    }else if(obj.name=="n3rd_inq_fm_dys")
    {

    }else if(obj.name=="n3rd_inq_to_dys")
    {
    	focusInBuVal = parseInt(formObj.n3rd_inq_to_dys.value);
    }else if(obj.name=="n4th_inq_fm_dys")
	{

	}else if(obj.name=="n4th_inq_to_dys")
    {
		focusInBuVal = parseInt(formObj.n4th_inq_to_dys.value);
    }else if(obj.name=="n5th_inq_fm_dys")
    {

    }else if(obj.name=="n5th_inq_to_dys")
    {
    	focusInBuVal = parseInt(formObj.n5th_inq_to_dys.value);
    }
}

/** 
  * Object 의 blur 이벤트에 대한 처리  <br>
  * form FOCUS_OUT 처리.  <br>
  * @param  없음
  * @return 없음
  * @author 조재성
  * @version 2009.07.24
  */  
function obj_blur(){
	var formObj = document.form;
	var obj   	= event.srcElement;
	
	if(CanMakeData == false)return;  // 적용안하는 상황: EnterKey로 데이터 불러왔을 때, 이전 데이터가 같을 때
		
	if(obj.name=="staying_days")
	{
		formObj.n1st_inq_fm_dys.value = parseInt(formObj.staying_days.value);
		formObj.n1st_inq_to_dys.value = parseInt(formObj.n1st_inq_fm_dys.value)+1;
		formObj.n2nd_inq_fm_dys.value = parseInt(formObj.n1st_inq_to_dys.value)+1;
		formObj.n2nd_inq_to_dys.value = parseInt(formObj.n2nd_inq_fm_dys.value)+1;
		formObj.n3rd_inq_fm_dys.value = parseInt(formObj.n2nd_inq_to_dys.value)+1;
		formObj.n3rd_inq_to_dys.value = parseInt(formObj.n3rd_inq_fm_dys.value)+1;
		formObj.n4th_inq_fm_dys.value = parseInt(formObj.n3rd_inq_to_dys.value)+1;
		formObj.n4th_inq_to_dys.value = parseInt(formObj.n4th_inq_fm_dys.value)+1;
		formObj.n5th_inq_fm_dys.value = parseInt(formObj.n4th_inq_to_dys.value)+1;
		formObj.n5th_inq_to_dys.value = parseInt(formObj.n5th_inq_fm_dys.value)+1;
		formObj.n6th_inq_fm_dys.value = parseInt(formObj.n5th_inq_to_dys.value)+1;
	}else if(obj.name=="n1st_inq_fm_dys")
    {
		formObj.n1st_inq_to_dys.value = parseInt(formObj.n1st_inq_fm_dys.value)+1;
		formObj.n2nd_inq_fm_dys.value = parseInt(formObj.n1st_inq_to_dys.value)+1;
		formObj.n2nd_inq_to_dys.value = parseInt(formObj.n2nd_inq_fm_dys.value)+1;
		formObj.n3rd_inq_fm_dys.value = parseInt(formObj.n2nd_inq_to_dys.value)+1;
		formObj.n3rd_inq_to_dys.value = parseInt(formObj.n3rd_inq_fm_dys.value)+1;
		formObj.n4th_inq_fm_dys.value = parseInt(formObj.n3rd_inq_to_dys.value)+1;
		formObj.n4th_inq_to_dys.value = parseInt(formObj.n4th_inq_fm_dys.value)+1;
		formObj.n5th_inq_fm_dys.value = parseInt(formObj.n4th_inq_to_dys.value)+1;
		formObj.n5th_inq_to_dys.value = parseInt(formObj.n5th_inq_fm_dys.value)+1;
		formObj.n6th_inq_fm_dys.value = parseInt(formObj.n5th_inq_to_dys.value)+1;
    }else if(obj.name=="n1st_inq_to_dys")
    {
    	if(parseInt(formObj.n1st_inq_fm_dys.value)>=parseInt(formObj.n1st_inq_to_dys.value))
    	{
    		ComShowCodeMessage('CGM10042','Long Staying Days Period');
    		formObj.n1st_inq_to_dys.value = focusInBuVal;
		   	return;
    	}
		formObj.n2nd_inq_fm_dys.value = parseInt(formObj.n1st_inq_to_dys.value)+1;
		formObj.n2nd_inq_to_dys.value = parseInt(formObj.n2nd_inq_fm_dys.value)+1;
		formObj.n3rd_inq_fm_dys.value = parseInt(formObj.n2nd_inq_to_dys.value)+1;
		formObj.n3rd_inq_to_dys.value = parseInt(formObj.n3rd_inq_fm_dys.value)+1;
		formObj.n4th_inq_fm_dys.value = parseInt(formObj.n3rd_inq_to_dys.value)+1;
		formObj.n4th_inq_to_dys.value = parseInt(formObj.n4th_inq_fm_dys.value)+1;
		formObj.n5th_inq_fm_dys.value = parseInt(formObj.n4th_inq_to_dys.value)+1;
		formObj.n5th_inq_to_dys.value = parseInt(formObj.n5th_inq_fm_dys.value)+1;
		formObj.n6th_inq_fm_dys.value = parseInt(formObj.n5th_inq_to_dys.value)+1;
    }else if(obj.name=="n2nd_inq_fm_dys")
    {
		formObj.n2nd_inq_to_dys.value = parseInt(formObj.n2nd_inq_fm_dys.value)+1;
		formObj.n3rd_inq_fm_dys.value = parseInt(formObj.n2nd_inq_to_dys.value)+1;
		formObj.n3rd_inq_to_dys.value = parseInt(formObj.n3rd_inq_fm_dys.value)+1;
		formObj.n4th_inq_fm_dys.value = parseInt(formObj.n3rd_inq_to_dys.value)+1;
		formObj.n4th_inq_to_dys.value = parseInt(formObj.n4th_inq_fm_dys.value)+1;
		formObj.n5th_inq_fm_dys.value = parseInt(formObj.n4th_inq_to_dys.value)+1;
		formObj.n5th_inq_to_dys.value = parseInt(formObj.n5th_inq_fm_dys.value)+1;
		formObj.n6th_inq_fm_dys.value = parseInt(formObj.n5th_inq_to_dys.value)+1;
    }else if(obj.name=="n2nd_inq_to_dys")
    {
    	if(parseInt(formObj.n2nd_inq_fm_dys.value)>=parseInt(formObj.n2nd_inq_to_dys.value))
    	{
    		ComShowCodeMessage('CGM10042','Long Staying Days Period');
    		formObj.n2nd_inq_to_dys.value = focusInBuVal;
		   	return;
    	}    	
		formObj.n3rd_inq_fm_dys.value = parseInt(formObj.n2nd_inq_to_dys.value)+1;
		formObj.n3rd_inq_to_dys.value = parseInt(formObj.n3rd_inq_fm_dys.value)+1;
		formObj.n4th_inq_fm_dys.value = parseInt(formObj.n3rd_inq_to_dys.value)+1;
		formObj.n4th_inq_to_dys.value = parseInt(formObj.n4th_inq_fm_dys.value)+1;
		formObj.n5th_inq_fm_dys.value = parseInt(formObj.n4th_inq_to_dys.value)+1;
		formObj.n5th_inq_to_dys.value = parseInt(formObj.n5th_inq_fm_dys.value)+1;
		formObj.n6th_inq_fm_dys.value = parseInt(formObj.n5th_inq_to_dys.value)+1;
    }else if(obj.name=="n3rd_inq_fm_dys")
    {
		formObj.n3rd_inq_to_dys.value = parseInt(formObj.n3rd_inq_fm_dys.value)+1;
		formObj.n4th_inq_fm_dys.value = parseInt(formObj.n3rd_inq_to_dys.value)+1;
		formObj.n4th_inq_to_dys.value = parseInt(formObj.n4th_inq_fm_dys.value)+1;
		formObj.n5th_inq_fm_dys.value = parseInt(formObj.n4th_inq_to_dys.value)+1;
		formObj.n5th_inq_to_dys.value = parseInt(formObj.n5th_inq_fm_dys.value)+1;
		formObj.n6th_inq_fm_dys.value = parseInt(formObj.n5th_inq_to_dys.value)+1;
    }else if(obj.name=="n3rd_inq_to_dys")
    {
    	if(parseInt(formObj.n3rd_inq_fm_dys.value)>=parseInt(formObj.n3rd_inq_to_dys.value))
    	{
    		ComShowCodeMessage('CGM10042','Long Staying Days Period');
    		formObj.n3rd_inq_to_dys.value = focusInBuVal;
		   	return;
    	}       	
		formObj.n4th_inq_fm_dys.value = parseInt(formObj.n3rd_inq_to_dys.value)+1;
		formObj.n4th_inq_to_dys.value = parseInt(formObj.n4th_inq_fm_dys.value)+1;
		formObj.n5th_inq_fm_dys.value = parseInt(formObj.n4th_inq_to_dys.value)+1;
		formObj.n5th_inq_to_dys.value = parseInt(formObj.n5th_inq_fm_dys.value)+1;
		formObj.n6th_inq_fm_dys.value = parseInt(formObj.n5th_inq_to_dys.value)+1;
    }else if(obj.name=="n4th_inq_fm_dys")
	{
		formObj.n4th_inq_to_dys.value = parseInt(formObj.n4th_inq_fm_dys.value)+1;
		formObj.n5th_inq_fm_dys.value = parseInt(formObj.n4th_inq_to_dys.value)+1;
		formObj.n5th_inq_to_dys.value = parseInt(formObj.n5th_inq_fm_dys.value)+1;
		formObj.n6th_inq_fm_dys.value = parseInt(formObj.n5th_inq_to_dys.value)+1;
	}else if(obj.name=="n4th_inq_to_dys")
    {
    	if(parseInt(formObj.n4th_inq_fm_dys.value)>=parseInt(formObj.n4th_inq_to_dys.value))
    	{
    		ComShowCodeMessage('CGM10042','Long Staying Days Period');
    		formObj.n4th_inq_to_dys.value = focusInBuVal;
		   	return;
    	}       			
		formObj.n5th_inq_fm_dys.value = parseInt(formObj.n4th_inq_to_dys.value)+1;
		formObj.n5th_inq_to_dys.value = parseInt(formObj.n5th_inq_fm_dys.value)+1;
		formObj.n6th_inq_fm_dys.value = parseInt(formObj.n5th_inq_to_dys.value)+1;
    }else if(obj.name=="n5th_inq_fm_dys")
    {
    	formObj.n5th_inq_to_dys.value = parseInt(formObj.n5th_inq_fm_dys.value)+1;
		formObj.n6th_inq_fm_dys.value = parseInt(formObj.n5th_inq_to_dys.value)+1;
    }else if(obj.name=="n5th_inq_to_dys")
    {
    	if(parseInt(formObj.n5th_inq_fm_dys.value)>=parseInt(formObj.n5th_inq_to_dys.value))
    	{
    		ComShowCodeMessage('CGM10042','Long Staying Days Period');
    		formObj.n5th_inq_to_dys.value = focusInBuVal;
		   	return;
    	}      	
    	formObj.n6th_inq_fm_dys.value = parseInt(formObj.n5th_inq_to_dys.value)+1;
    }
}
 
/** 
 * Object 의 change 이벤트에 대한 처리  <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2009.07.22
 */  
function obj_change(){
	var formObj = document.form;
	var sheetObj = sheetObjects[0]; 
	obj = event.srcElement;

}

/** 
 * Object 의 obj_focusout 이벤트에 대한 처리  <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2009.07.22
 */  
function obj_focusout(){
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	obj = event.srcElement;

}

/* 개발자 작업  끝 */