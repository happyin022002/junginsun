/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0533.js
 *@FileTitle : Inbond Arrival Manifest
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.19  
 *@LastModifier : 김도완
 *@LastVersion : 1.0
 * 2009.06.19 김도완
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
 * @class ESM_BKG-0533 : ESM_BKG-0533 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0533() {
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
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

//전역변수
var intervalId = "";

var loadPageCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject1 = sheetObjects[0];
    var sheetObject2 = sheetObjects[1];
	/** **************************************************** */
	var formObject = document.form;
	
	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		/*** (Tab) Container (S) ***/

		case "btn_t1SetArrivalDate":
			setArrDt(sheetObjects[0], document.form, "arr", "t1sheet1_", 0);
			break;
			
		case "btn_t1SetExportDate":
			setArrDt(sheetObjects[0], document.form, "xpt", "t1sheet1_", 0);
			break;
								
		/*** (Tab) Container (E) ***/


		/*** (Tab) B/L (S) ***/
		case "btn_t2SetArrivalDate":
			setArrDt(sheetObjects[1], document.form, "arr", "t2sheet1_", 1);
			break;
			
		case "btn_t2SetExportDate":
			setArrDt(sheetObjects[1], document.form, "xpt", "t2sheet1_", 1);
			break;

		/*** (Tab) B/L (E) ***/

		case "btn_Retrieve":
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;

		case "btn_Save":
			doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
			break;
			
		case "btn_TransAN":
			doActionIBSheet(sheetObjects[0], document.form, MULTI01);
			break;

		case "btn_TransExp":
			doActionIBSheet(sheetObjects[0], document.form, MULTI02);
			break;
			
		case "btn_SelectAll":
			sheetObjects[document.tab1.SelectedIndex].CheckAll2("t"+(document.tab1.SelectedIndex+1)+"sheet1_chk") = 1;
			break;	
			
		case "btn_DeselectAll":
			sheetObjects[document.tab1.SelectedIndex].CheckAll2("t"+(document.tab1.SelectedIndex+1)+"sheet1_chk") = 0;
			break;
		
		case "btn_DownExcel":
			ComOpenWait(true);
			sheetObjects[document.tab1.SelectedIndex].SpeedDown2Excel(-1);
			ComOpenWait(false);
			break;               

		case "btn_calendar":
            if(formObject.fromd.disabled) return;
			var cal = new ComCalendarFromTo();
            cal.select(formObject.fromd, formObject.tod, 'yyyy-MM-dd');
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
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj) {

	sheetObjects[sheetCnt++] = sheet_obj;

}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
		 
	for (i = 0; i < sheetObjects.length; i++) {

		// khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	for (k = 0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
	}
	
	initControl();
	
	loadPageCnt = 1;
	
    //US AMS Main Menu : VVD 입력시
	if (!ComIsNull(document.form.vvd)) {
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}
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
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * 
 * @param {ibsheet}
 *            sheetObj IBSheet Object
 * @param {int}
 *            sheetNo sheetObjects 배열에서 순번
 */
function initControl() {
	//** Date 구분자 **/
	DATE_SEPARATOR = "-";
	
	var formObject = document.form;
	//Axon 이벤트 처리1. 이벤트catch(개발자변경)
    //axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); //- 포커스 나갈때
    //axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject); //- 포커스 들어갈때
    axon_event.addListenerFormat('keypress',       'obj_KeyPress',    formObject); //- 키보드 입력할때
    axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    axon_event.addListener('click', 'chkClick', 'form');
    axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
}

 /**
    * 시트 초기설정값, 헤더 정의
    * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
    * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
    */
   function initSheet(sheetObj,sheetNo) {

       var cnt = 0;
				var sheetID = sheetObj.id;

       switch(sheetID) {

           case "t1sheet1":
               with (sheetObj) {
                   // 높이 설정
                   style.height = 360;
                   //전체 너비 설정
                   SheetWidth = mainTable.clientWidth;

                   //Host정보 설정[필수][HostIp, Port, PagePath]
                   if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                   //전체Merge 종류 [선택, Default msNone]
                   MergeSheet = msHeaderOnly;

                  //전체Edit 허용 여부 [선택, Default false]
                   Editable = true;

                   //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                   InitRowInfo( 1, 1, 10, 100);

                   var HeadTitle = "|Sel.|Seq.|Container No.|B/L No.|POD|Hub|DEL|Customs|L.USA|P/MIB No.|Type|Arrival Date|Arrival Date|A|Arrival Accept Date|Arrival Accept Date" +
                   		"|Export Date|Export Date|E|Export Accept Date|Export Accept Date|Available Date|Yard|ST|VVD|F|O|C|P/MIB Issue Date|P/MIB Accept Date||||||";
                   var headCount = ComCountHeadTitle(HeadTitle);

                   //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                   InitColumnInfo(headCount, 0, 0, true);

                   // 해더에서 처리할 수 있는 각종 기능을 설정한다
                   InitHeadMode(true, true, true, true, false,false);

                   //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                   InitHeadRow(0, HeadTitle, true);
                   var prefix = "t1sheet1_";
                   //var prefix = "";
                   
                   //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                   InitDataProperty(0, cnt++ , dtHiddenStatus,	130,daCenter,true,	prefix +"ibflag");
                   InitDataProperty(0, cnt++ , dtCheckBox,		40,	daCenter,false,	prefix +"chk",				false,		"",		dfNone,	0,	true,		true);
                   InitDataProperty(0, cnt++ , dtSeq,			30,	daCenter,true,	prefix +"seq");
                   InitDataProperty(0, cnt++ , dtData,			90,	daCenter,false,	prefix +"cntr_no",			false,		"",		dfNone,	0,	false,	true);
                   InitDataProperty(0, cnt++ , dtData,			90,	daCenter,false,	prefix +"bl_no",			false,		"",		dfNone,	0,	false,	true);
                   
                   InitDataProperty(0, cnt++ , dtData,			50,	daCenter,false,	prefix +"pod_cd",			false,		"",		dfNone,	0,	false,	true);
                   InitDataProperty(0, cnt++ , dtData,			50,	daCenter,false,	prefix +"hub_loc_cd",		false,		"",		dfNone,	0,	false,	true);
                   InitDataProperty(0, cnt++ , dtData,			50,	daCenter,false,	prefix +"del_cd",			false,		"",		dfNone,	0,	false,	true);
                   InitDataProperty(0, cnt++ , dtData,			60,	daCenter,false,	prefix +"cstms_loc_cd",		false,		"",		dfNone,	0,	false,	true);
                   InitDataProperty(0, cnt++ , dtData,			50,	daCenter,false,	prefix +"usa_lst_loc_cd",	false,		"",		dfNone,	0,	false,	true);
                   InitDataProperty(0, cnt++ , dtData,			90,	daCenter,false,	prefix +"ibd_trsp_no",		false,		"",		dfNone,	0,	false,	true);
                   
                   InitDataProperty(0, cnt++ , dtData,			50,	daCenter,false,	prefix +"ibd_tp_cd",		false,		"",		dfNone,	0,	false,	true);
                   InitDataProperty(0, cnt++ , dtData,			80,	daCenter,false,	prefix +"arr_dt",			false,		"",		dfDateYmd,	0,	true,	true);
                   InitDataProperty(0, cnt++ , dtData,			40,	daCenter,false,	prefix +"arr_time",			false,		"",		dfTimeHm ,	0,	true,	true);
                   InitDataProperty(0, cnt++ , dtData,			30,	daCenter,false,	prefix +"arr_flg",			false,		"",		dfNone,	0,	false,	true);
                   InitDataProperty(0, cnt++ , dtData,			80,	daCenter,false,	prefix +"trsp_auth_dt",		false,		"",		dfNone,	0,	false,	true);
                   
                   InitDataProperty(0, cnt++ , dtData,			40,	daCenter,false,	prefix +"trsp_auth_time",	false,		"",		dfNone,	0,	false,	true);
                   InitDataProperty(0, cnt++ , dtData,			80,	daCenter,false,	prefix +"xpt_dt",			false,		"",		dfDateYmd,	0,	true,	true);                   
                   InitDataProperty(0, cnt++ , dtData,			40,	daCenter,false,	prefix +"xpt_time",			false,		"",		dfTimeHm ,	0,	true,	true);
                   InitDataProperty(0, cnt++ , dtData,			30,	daCenter,false,	prefix +"xpt_flg",			false,		"",		dfNone,	0,	false,	true);
                   InitDataProperty(0, cnt++ , dtData,			80,	daCenter,false,	prefix +"xpt_acpt_dt",		false,		"",		dfNone,	0,	false,	true);
                   
                   InitDataProperty(0, cnt++ , dtData,			40,	daCenter,false,	prefix +"xpt_acpt_time",	false,		"",		dfNone,	0,	false,	true);
                   //InitDataProperty(0, cnt++ , dtData,			80,	daCenter,false,	prefix +"pkup_no",			false,		"",		dfNone,	0,	false,	true);
                   InitDataProperty(0, cnt++ , dtData,			95,	daCenter,false,	prefix +"aval_dt",			false,		"",		dfNone,	0,	false,	true);
                   InitDataProperty(0, cnt++ , dtData,			80,	daCenter,false,	prefix +"yd_cd",			false,		"",		dfNone,	0,	false,	true);
                   InitDataProperty(0, cnt++ , dtData,			80,	daCenter,false,	prefix +"cnmv_sts_cd",		false,		"",		dfNone,	0,	false,	true);
                   
                   InitDataProperty(0, cnt++ , dtHidden,		90,	daCenter,false,	prefix +"vvd",				false,		"",		dfNone,	0,	false,	true);
                   InitDataProperty(0, cnt++ , dtData,			30,	daCenter,false,	prefix +"frt_clt_flg",		false,		"",		dfNone,	0,	false,	true);
                   InitDataProperty(0, cnt++ , dtData,			30,	daCenter,false,	prefix +"obl_rdem_flg",		false,		"",		dfNone,	0,	false,	true);
                   InitDataProperty(0, cnt++ , dtData,			30,	daCenter,false,	prefix +"cstms_clr_cd",		false,		"",		dfNone,	0,	false,	true);
                   InitDataProperty(0, cnt++ , dtData,			120,daCenter,false,	prefix +"trsp_iss_dt",		false,		"",		dfNone,	0,	false,	true);

                   InitDataProperty(0, cnt++ , dtData,			120,daCenter,false,	prefix +"mjr_ibd_auth_dt",	false,		"",		dfNone,	0,	false,	true);
                   InitDataProperty(0, cnt++ , dtHidden,		30,	daCenter,false,	prefix +"bl_cntr_flag",		false,		"",		dfNone,	0,	false,	true);
                   InitDataProperty(0, cnt++ , dtHidden,		30,	daCenter,false,	prefix +"usdate",			false,		"",		dfNone,	0,	false,	true);
                   InitDataProperty(0, cnt++ , dtHidden,		30,	daCenter,false,	prefix +"arr_dt_before",	false,		"",		dfNone,	0,	false,	true);
                   InitDataProperty(0, cnt++ , dtHidden,		30,	daCenter,false,	prefix +"xpt_dt_before",	false,		"",		dfNone,	0,	false,	true);
                   InitDataProperty(0, cnt++ , dtHidden,		30,	daCenter,false,	prefix +"partial_cntr_no",	false,		"",		dfNone,	0,	false,	true);
                   InitDataProperty(0, cnt++ , dtHidden,		30,	daCenter,false,	prefix +"cstms_pod_cd",	false,		"",		dfNone,	0,	false,	true);
                   
                   CountPosition = 2;

                   // 틀고정 설정 (type)
	   			   FrozenCols = 11;     
	   			   
	   			   WaitImageVisible=false;
               }
               break;

           case "t2sheet1":
               with (sheetObj) {
                   // 높이 설정
                   style.height = 360;
                   //전체 너비 설정
                   SheetWidth = mainTable.clientWidth;

                   //Host정보 설정[필수][HostIp, Port, PagePath]
                   if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                   //전체Merge 종류 [선택, Default msNone]
                   MergeSheet = msHeaderOnly;

                  //전체Edit 허용 여부 [선택, Default false]
                   Editable = true;

                   //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                   InitRowInfo( 1, 1, 10, 100);

                   var HeadTitle = "|Sel.|Seq.|B/L No.|VVD|POD|Hub|DEL|Customs|L.USA|P/MIB No|Type|Arrival Date|Arrival Date|A|Arrival Accept Date|Arrival Accept Date" +
                   		"|Export Date|Export Date|E|Export Accept Date|Export Accept Date|F|O|C|P/MIB Issue Date|P/MIB Accept Date|||||";
                   var headCount = ComCountHeadTitle(HeadTitle);

                   //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                   InitColumnInfo(headCount, 0, 0, true);

                   // 해더에서 처리할 수 있는 각종 기능을 설정한다
                   InitHeadMode(true, true, true, true, false,false);

                   //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                   InitHeadRow(0, HeadTitle, true);
                   var prefix = "t2sheet1_";
                   
                   //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                   InitDataProperty(0, cnt++ , dtHiddenStatus,	130,daCenter,	true,	prefix +"ibflag");
                   InitDataProperty(0, cnt++ , dtCheckBox,		40,	daCenter,	false,	prefix +"chk",				false,		"",		dfNone,					0,		true,		true);
                   InitDataProperty(0, cnt++ , dtSeq,			30,	daCenter,	true,	prefix +"seq");
                   InitDataProperty(0, cnt++ , dtData,			90,	daCenter,	false,	prefix +"bl_no",			false,		"",		dfNone,					0,		false,	true);
                   InitDataProperty(0, cnt++ , dtHidden,		90,	daCenter,	false,	prefix +"vvd",				false,		"",		dfNone,					0,		false,	true);
                   
                   InitDataProperty(0, cnt++ , dtData,			50,	daCenter,	false,	prefix +"pod_cd",			false,		"",		dfNone,					0,		false,	true);
                   InitDataProperty(0, cnt++ , dtData,			50,	daCenter,	false,	prefix +"hub_loc_cd",		false,		"",		dfNone,					0,		false,	true);
                   InitDataProperty(0, cnt++ , dtData,			50,	daCenter,	false,	prefix +"del_cd",			false,		"",		dfNone,					0,		false,	true);
                   InitDataProperty(0, cnt++ , dtData,			60,	daCenter,	false,	prefix +"cstms_loc_cd",		false,		"",		dfNone,					0,		false,	true);
                   InitDataProperty(0, cnt++ , dtData,			50,	daCenter,	false,	prefix +"usa_lst_loc_cd",	false,		"",		dfNone,					0,		false,	true);
                   InitDataProperty(0, cnt++ , dtData,			90,	daCenter,	false,	prefix +"ibd_trsp_no",		false,		"",		dfNone,					0,		false,	true);

                   InitDataProperty(0, cnt++ , dtData,			50,	daCenter,	false,	prefix +"ibd_tp_cd",		false,		"",		dfNone,					0,		false,	true);
                   InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	false,	prefix +"arr_dt",			false,		"",		dfDateYmd,				0,		true,	true);
                   InitDataProperty(0, cnt++ , dtData,			40,	daCenter,	false,	prefix +"arr_time",			false,		"",		dfTimeHm,				0,		true,	true);
                   InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	false,	prefix +"arr_flg",			false,		"",		dfNone,					0,		false,	true);                   
                   InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	false,	prefix +"trsp_auth_dt",		false,		"",		dfNone,					0,		false,	true);
                   
                   InitDataProperty(0, cnt++ , dtData,			40,	daCenter,	false,	prefix +"trsp_auth_time",	false,		"",		dfNone,					0,		false,	true);                   
                   InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	false,	prefix +"xpt_dt",			false,		"",		dfDateYmd,				0,		true,	true);
                   InitDataProperty(0, cnt++ , dtData,			40,	daCenter,	false,	prefix +"xpt_time",			false,		"",		dfTimeHm,				0,		true,	true);
                   InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	false,	prefix +"xpt_flg",			false,		"",		dfNone,					0,		false,	true);
                   InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	false,	prefix +"xpt_acpt_dt",		false,		"",		dfNone,					0,		false,	true);
                   
                   InitDataProperty(0, cnt++ , dtData,			40,	daCenter,	false,	prefix +"xpt_acpt_time",	false,		"",		dfNone,					0,		false,	true);
                   InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	false,	prefix +"frt_clt_flg",		false,		"",		dfNone,					0,		false,	true);
                   InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	false,	prefix +"obl_rdem_flg",		false,		"",		dfNone,					0,		false,	true);
                   InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	false,	prefix +"cstms_clr_cd",		false,		"",		dfNone,					0,		false,	true);
                   InitDataProperty(0, cnt++ , dtData,			120,daCenter,	false,	prefix +"ibd_trsp_iss_dt",	false,		"",		dfNone,					0,		false,	true);
                   
                   InitDataProperty(0, cnt++ , dtData,			120,daCenter,	false,	prefix +"mjr_ibd_auth_dt",	false,		"",		dfNone,					0,		false,	true);
                   InitDataProperty(0, cnt++ , dtHidden,		30,	daCenter,	false,	prefix +"bl_cntr_flag",		false,		"",		dfNone,					0,		false,	true);
                   InitDataProperty(0, cnt++ , dtHidden,		30,	daCenter,	false,	prefix +"usdate",			false,		"",		dfNone,					0,		false,	true);
                   InitDataProperty(0, cnt++ , dtHidden,		30,	daCenter,	false,	prefix +"arr_dt_before",	false,		"",		dfNone,					0,	false,	true);
                   InitDataProperty(0, cnt++ , dtHidden,		30,	daCenter,	false,	prefix +"xpt_dt_before",	false,		"",		dfNone,					0,	false,	true);
                   InitDataProperty(0, cnt++ , dtHidden,		30,	daCenter,	false,	prefix +"cstms_pod_cd",	false,		"",		dfNone,					0,	false,	true);
                   

					//InitUserFormat2(0, "ArrivalDate", "####-##-## ##:##", "-|:" );
					//InitUserFormat2(0, "ArrivalAcceptDate", "####-##-## ##:##", "-|:" );
					//InitUserFormat2(0, "ExportDate", "####-##-## ##:##", "-|:" );
					//InitUserFormat2(0, "ExportAcceptDate", "####-##-## ##:##", "-|:" );
					//InitUserFormat2(0, "PMIBIssueDate", "####-##-## ##:##", "-|:" );
					//InitUserFormat2(0, "PMIBAcceptDate", "####-##-## ##:##", "-|:" );

                   CountPosition = 2; 
	
                   // 틀고정 설정 (type)
                   FrozenCols = 11;
					
                   WaitImageVisible=false;
               }
               break;


       }
   }

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	var selTab = document.tab1.SelectedIndex;
	if(selTab == 0){
		formObj.bl_cntr_gubun.value = "Cntr";
	}else{
		formObj.bl_cntr_gubun.value = "BL";
	}
	
	var prefix = "t"+(selTab+1)+"sheet1_";
	
	switch (sAction) {

	case IBSEARCH: // 조회

		if (validateForm(sheetObj, formObj, sAction))
		{
			
			if(formObj.arr_gubun.checked)
				formObj.arr_gubun.value = "1";
			else
				formObj.arr_gubun.value = "0";

			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0533GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(prefix));
	   	  	
			var arrXml = sXml.split("|$$|");
   	  		if (arrXml.length > 0) {
   	  			sheetObjects[selTab].LoadSearchXml(arrXml[0]);
   	  		}
   	  		if (arrXml.length > 1) {
   	  			sheetObjects[1].LoadSearchXml(arrXml[1]); 
   	  		}
   	  		ComOpenWait(false);
   	  		
		}
		
		break;

	case IBSAVE: // 저장
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			formObj.f_cmd.value = MULTI;
			var sParam = ComGetSaveString(sheetObjects[selTab]) + "&f_cmd=" + MULTI+ "&" + ComGetPrefixParam(prefix);
			var sXml = sheetObjects[selTab].GetSaveXml("ESM_BKG_0533GS.do", sParam);
			ComOpenWait(false);
			for ( var i = 1; i < sheetObjects[selTab].RowCount + 1; i++) {
				//if (sheetObjects[selTab].CellValue(i, prefix + "ibflag") != "R") {
				if (sheetObjects[selTab].RowStatus(i) != "R") {
					sheetObjects[selTab].CellValue2(i, prefix + "arr_dt_before") = 
						sheetObjects[selTab].CellValue(i, prefix + "arr_dt") + sheetObjects[selTab].CellValue(i, prefix + "arr_time")
					sheetObjects[selTab].CellValue2(i, prefix + "xpt_dt_before") = 
						sheetObjects[selTab].CellValue(i, prefix + "xpt_dt") + sheetObjects[selTab].CellValue(i, prefix + "xpt_time")
				}
			}
			if(sXml.indexOf("<TR-ALL>OK</TR-ALL>") > 0) {
				ComShowCodeMessage('BKG06022');
//				doActionIBSheet(sheetObjects[selTab], document.form, IBSEARCH);
			} else {
				ComShowCodeMessage('BKG00099');
			}
		}

		break;

	case MULTI01: // Arr Trans
		
		if (validateForm(sheetObjects[selTab], formObj, sAction))
		{
			
			formObj.f_cmd.value = MULTI01;
			var sParam = ComGetSaveString(sheetObjects[selTab]) + "&f_cmd=" + MULTI01
						+ "&" + ComGetPrefixParam(prefix);
			
			sheetObjects[selTab].WaitImageVisible = false;
			ComOpenWait(true,true);
			var sXml = sheetObjects[selTab].GetSaveXml("ESM_BKG_0533GS.do", sParam);
			var key = ComGetEtcData(sXml, "KEY");
			intervalId = setInterval("doActionValidationResult(sheetObjects["+selTab+"], '" + key + "');", 3000);
			
		}

		break;
	case MULTI02: // Exp Trans
	
		if (validateForm(sheetObjects[selTab], formObj, sAction))
		{
			
			formObj.f_cmd.value = MULTI02;
			var sParam = ComGetSaveString(sheetObjects[selTab]) + "&f_cmd=" + MULTI02+ "&" + ComGetPrefixParam(prefix);
			sheetObjects[selTab].WaitImageVisible = false;
			ComOpenWait(true,true);
			var sXml = sheetObjects[selTab].GetSaveXml("ESM_BKG_0533GS.do", sParam);
			var key = ComGetEtcData(sXml, "KEY");
			intervalId = setInterval("doActionValidationResult(sheetObjects["+selTab+"], '" + key + "');", 3000);
			
		}

		break;
	}
	
	// Partial Container Background Color 변경
	if(selTab == 0) { // Container TAB

		var cntrSheet = sheetObjects[selTab];
		var cntrSheetMaxSize = cntrSheet.RowCount;
		var partialCntrNo = "";
		
		for(var i=1; i <= cntrSheetMaxSize; i++) {
			partialCntrNo = cntrSheet.CellValue(i, "t1sheet1_partial_cntr_no");
			
			if(partialCntrNo != "") cntrSheet.RowBackColor(i) = sheetObjects[1].RgbColor(255,255,192);
		} // end for(i)
	}
}

/**
* BackEndJob 실행결과조회.
*/
function doActionValidationResult(sheetObj, sKey) {
	var sXml = sheetObj.GetSearchXml("ESM_BKG_0533GS.do?f_cmd=" + SEARCH03
			+ "&key=" + sKey);
	var sJbStsFlg = ComGetEtcData(sXml, "jb_sts_flg");
	
	// 에러가 발생했을 경우 대기사항을 종료한다.
	if (!ComBkgErrMessage(sheetObj, sXml)) {
		clearInterval(intervalId);
		ComOpenWait(false);
		return;
	}
	if (sJbStsFlg == "SUCCESS") {
		clearInterval(intervalId);
		ComOpenWait(false);
		// 성공메시지 보여주고
		ComShowCodeMessage('BKG00101');
		doActionIBSheet(sheetObj, document.form, IBSEARCH);	
		return;
	} else if (sJbStsFlg == "FAIL") {
		// 에러
		clearInterval(intervalId);
		ComOpenWait(false);
		// 에러메시지 보여주고
		ComShowMessage(ComResultMessage(sXml));
	}
}

/**
 * IBTab Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++] = tab_obj;
}


 /**
  * Tab 기본 설정
  * 탭의 항목을 설정한다.
  */
 function initTab(tabObj , tabNo) {
      switch(tabNo) {
          case 1:
             with (tabObj) {

                 var cnt  = 0 ;
                 InsertTab( cnt++ , "Container" , -1 );
                 InsertTab( cnt++ , "B/L" , -1 );

             }
          break;

      }
 }

/**
 * Tab 클릭시 이벤트 관련 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnChange(tabObj, nItem) {
    var objs = document.all.item("tabLayer");

    objs[nItem].style.display = "Inline";
    objs[beforetab].style.display = "none";

    beforetab = nItem;		
    //--------------- 요기가 중요 --------------------------//
    objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    //------------------------------------------------------//

	if (loadPageCnt != 0) {
		if (validateForm(sheetObjects[nItem], document.form, IBSEARCH_ASYNC01))
			doActionIBSheet(sheetObjects[nItem], document.form, IBSEARCH);
	}
	
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	var selTab = document.tab1.SelectedIndex;
	var prefix = "t"+(selTab+1)+"sheet1_";
	
	switch (sAction) {
	case IBSEARCH: // 조회
		
		if(!formObj.arr_gubun.checked) {
			
			if(formObj.vvd.value == "") {
				ComShowCodeMessage("BKG00251");
				ComSetFocus(formObj.vvd);
				return false;
			}
			
			if(!ComChkObjValid(formObj.vvd) || !ComChkObjValid(formObj.pod)) return false;

		} else {
			
			if(formObj.fromd.value != "" && formObj.tod.value != "" && formObj.vvd.value == "" && formObj.eq_ofc.value == "" ) {
				ComShowCodeMessage("BKG06113", "Arrival Date + VVD", "Arrival Date + EQ Office");
				ComSetFocus(formObj.vvd);
				return false;
			}
			
			if(formObj.vvd.value != "" ) {
				if(!ComChkObjValid(formObj.vvd)) return false;
			}
			
			if(formObj.pod.value != "" ) {
				if(!ComChkObjValid(formObj.pod)) return false;
			}

			if(!ComChkObjValid(formObj.fromd) || !ComChkObjValid(formObj.tod)) return false;
			
			if(chkDateTimeValid(formObj.fromd, "ymd") == "false"){
				return false;
			}
			if(chkDateTimeValid(formObj.fromt, "hm") == "false"){
				return false;
			}
			if(chkDateTimeValid(formObj.tod, "ymd") == "false"){
				return false;
			}
			if(chkDateTimeValid(formObj.tot, "hm") == "false"){
				return false;
			}

			// from - to 범위 : 10일 이내
			if(ComGetDaysBetween(formObj.fromd.value, formObj.tod.value) > 10) {
				ComShowCodeMessage('BKG50472');
				ComSetFocus(formObj.fromd);
				return false;
			}
			
				
			
		}
		
		return true;
		break;
	case IBSAVE: // 저장		

		if(selTab == 0)	{
			return partialGroupDateCheck(); //동일 CNTR인데 서로 다른 날짜가 입력되는 경우 alert msg 팝업
		} 
		
		return true;
		break;		
	case MULTI01: // Transmit Arrival
		var type = "";
		var chked = 0;
		for(var i = 1; i < sheetObj.RowCount+1; i++){
			if(sheetObj.CellValue(i, prefix+"chk") == 1){

				type = sheetObj.CellValue(i, prefix+"ibd_tp_cd");
				if(type == "63"){
					ComShowCodeMessage('BKG06072');
					return false;
				}
				
				if(sheetObj.CellValue(i, prefix+"arr_dt") == ""){
					ComShowCodeMessage('BKG06073');
					return false;
				}

//				if(sheetObj.CellValue(i, prefix+"arr_flg") == "Y"){
//					ComShowCodeMessage('BKG06074');
//					return false;
//				}
				
				if (sheetObj.CellValue(i, prefix + "arr_dt").replace("-", "").replace("-", "") + ""
						+ sheetObj.CellValue(i, prefix + "arr_time").replace(":", "") != sheetObj.CellValue(i,
						prefix + "arr_dt_before").replace("-", "").replace("-", "").replace(":", "")) {
					ComShowCodeMessage('BKG06075');
					return false;
				}
				
				chked++;
			}
		}
		if(chked == 0){
			//BKG00249, No Selected Row
			ComShowCodeMessage('BKG00249');
			return false;
		}
		return true;
		break;	
	case MULTI02: // Transmit Export
		var type = "";
		var chked = 0;
		for(var i = 1; i < sheetObj.RowCount+1; i++){
			if(sheetObj.CellValue(i, prefix+"chk") == 1){
				type = sheetObj.CellValue(i, prefix+"ibd_tp_cd");
				if(type == "61"){
					ComShowCodeMessage('BKG06076');
					return false;
				}
//				if(sheetObj.CellValue(i, prefix+"xpt_flg") == "Y"){
//					ComShowCodeMessage('BKG06077');
//					return false;
//				}
				
				if(sheetObj.CellValue(i, prefix+"xpt_dt") == ""){
					ComShowCodeMessage('BKG06078');
					return false;
				}
				if(sheetObj.CellValue(i, prefix+"xpt_dt").replace("-", "").replace("-", "")+""+ sheetObj.CellValue(i, prefix+"xpt_time").replace(":","") != sheetObj.CellValue(i, prefix+"xpt_dt_before").replace("-", "").replace("-", "").replace(":","")){
					ComShowCodeMessage('BKG06079');
					return false;
				}
				
				chked++;
			}
		}
		if(chked == 0){
			//BKG00249, No Selected Row
			ComShowCodeMessage('BKG00249');
			return false;
		}
	
		return true;
		break;	
	case IBSEARCH_ASYNC01: // Tab Search
		if(formObj.arr_gubun.checked)
			formObj.arr_gubun.value = "1";
		else
			formObj.arr_gubun.value = "0";
		
		if(formObj.arr_gubun.value == "on" || formObj.arr_gubun.value == "1"){
			if(formObj.fromd.value == "" || formObj.tod.value == ""){
				return false;
			}
		}else{
			if (formObj.vvd.value == "") {
				formObj.vvd.focus();
				return false;
			}
			if (formObj.vvd.value.length != 9) {
				formObj.vvd.focus();
				return false;
			}		
		}

		// 61 이 포함되는 경우, hub도 필수.
		if(formObj.ibd_tp_cd.value.indexOf("1") > 0){
			if(formObj.hub.value == ""){
				formObj.hub.focus();
				return false;
			}
		}
		return true;
		break;		
	}	
	return true;
}

/**
 * Arrival Date 또는 Export Date 입력후 저장시 동일 CNTR 를 찾는 로직 (Partial CNTR 인 경우)<br>
 * 동일 CNTR인데 서로 다른 날짜가 입력되는 경우 alert msg 팝업메시지를 보여준다.<br>
 * 
 * @return
 */
function partialGroupDateCheck() {
	
	var currPartialCntrNo = "";
	var prePartialCntrNo = "";
	var currCntrNo = "";
	var preCntrNo = "";

	var sheetObj = sheetObjects[0]
	var sheetRowCnt = sheetObj.RowCount;
	
	var disArrDtCntrNoList = "";
	var disExpDtCntrNoList = "";
	
	var currArrDate = "";
	var preArrDate = "";
	var currExpDate = "";
	var preExpDate = "";
	
	var subPartialCntrNo = "";
	
	
	for(var i=1; i <= sheetRowCnt; i++) {
		
		if(sheetObj.RowStatus(i) != 'U') continue;
		
		currPartialCntrNo = sheetObj.CellValue(i, "t1sheet1_partial_cntr_no");
		
		if(currPartialCntrNo == "" || currPartialCntrNo == prePartialCntrNo) continue;
		
		preArrDate = "";
		preExpDate = "";
		// 현시점부터 뒤로 비교
		for(var j=i; j<=sheetRowCnt; j++) {
			
			currArrDate = sheetObj.CellValue(j, "t1sheet1_arr_dt") + sheetObj.CellValue(j, "t1sheet1_arr_time");
			currExpDate = sheetObj.CellValue(j, "t1sheet1_xpt_dt") + sheetObj.CellValue(j, "t1sheet1_xpt_time");
			subPartialCntrNo = sheetObj.CellValue(j, "t1sheet1_partial_cntr_no");
			
			if(j == i) {
				preArrDate = currArrDate;
				preExpDate = currExpDate;
			}
			
			if(currPartialCntrNo != subPartialCntrNo) break;
			
			if(currArrDate != preArrDate) {
				disArrDtCntrNoList += subPartialCntrNo + ", ";
			}

			if(currExpDate != preExpDate) {
				disExpDtCntrNoList += subPartialCntrNo + ", ";
			}
			
			preArrDate = currArrDate;
			currExpDate = preExpDate;
			
		} // end for(j)
		
		preArrDate = "";
		preExpDate = "";
		// 현시점부터 앞으로 비교
		for(var j=i; j>=1; j--) {
			
			currArrDate = sheetObj.CellValue(j, "t1sheet1_arr_dt") + sheetObj.CellValue(j, "t1sheet1_arr_time");
			currExpDate = sheetObj.CellValue(j, "t1sheet1_xpt_dt") + sheetObj.CellValue(j, "t1sheet1_xpt_time");
			subPartialCntrNo = sheetObj.CellValue(j, "t1sheet1_partial_cntr_no");
			
			if(j == i) {
				preArrDate = currArrDate;
				preExpDate = currExpDate;
			}
			
			if(currPartialCntrNo != subPartialCntrNo) break;
			
			if(currArrDate != preArrDate) {
				disArrDtCntrNoList += subPartialCntrNo + ", ";
			}

			if(currExpDate != preExpDate) {
				disExpDtCntrNoList += subPartialCntrNo + ", ";
			}
			
			preArrDate = currArrDate;
			currExpDate = preExpDate;
			
		} // end for(j)

		
		prePartialCntrNo = currPartialCntrNo;
		
	} // end for(i)
	
	if(disArrDtCntrNoList != "") {
		disArrDtCntrNoList = disArrDtCntrNoList.substring(0, disArrDtCntrNoList.lastIndexOf(","));
	}

	if(disExpDtCntrNoList != "") {
		disExpDtCntrNoList = disExpDtCntrNoList.substring(0, disExpDtCntrNoList.lastIndexOf(","));
	}
	
	if(disArrDtCntrNoList != "" && disExpDtCntrNoList != "") {
		ComShowMessage(ComGetMsg("BKG06112", "Arrival", disArrDtCntrNoList) + "\n" + ComGetMsg("BKG06112", "Export ", disExpDtCntrNoList));
		return false;
	} else if(disArrDtCntrNoList != "" && disExpDtCntrNoList == "") {
		ComShowCodeMessage("BKG06112", "Arrival", disArrDtCntrNoList);
		return false;
		
	} else if(disArrDtCntrNoList == "" && disExpDtCntrNoList != "") {
		ComShowCodeMessage("BKG06112", "Export", disExpDtCntrNoList);
		return false;
		
	}

	return true;
	
}

function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	
	if(sheetObj.RowCount > 0){
		var usdate = sheetObj.CellValue(1, "t1sheet1_usdate");
		
		var d = usdate.substring(0, 10);
		var t = usdate.substring(11);
		document.form.set_arr_d[0].value = d;
		document.form.set_arr_t[0].value = "00:00";
	}
}


function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	
	if(sheetObj.RowCount > 0){
		var usdate = sheetObj.CellValue(1, "t2sheet1_usdate");
		
		var d = usdate.substring(0, 10);
		var t = usdate.substring(11);
		document.form.set_arr_d[1].value = d;
		document.form.set_arr_t[1].value = "00:00";
	}
}

function t1sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	if(ErrMsg == ""){
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
}

function setArrDt(sObj, fObj, field_id, prefix, idx){
	
	try{
		
		
		if(sObj.CheckedRows(prefix+"chk") == 0){
			//BKG00249, No Selected Row
			ComShowCodeMessage('BKG00249');
			return;
		}
		var dt = chkDateTimeValid(fObj.set_arr_d[idx], "ymd");
		if(dt == "false") return;
		
		
		var hm = chkDateTimeValid(fObj.set_arr_t[idx], "hm");
		if(hm == "false") return;
		
		for(var i = 1; i < sObj.RowCount+1; i ++){
			if(sObj.CellValue(i, prefix+"chk") == 1){ 
				
				
				sObj.CellValue(i, prefix+field_id+"_dt") = dt;
				sObj.CellValue(i, prefix+field_id+"_time") = hm;

				
				if(idx == 0) { // Container Tab일 경우만
					
					var currPartialCntrNo = sObj.CellValue(i, prefix+"partial_cntr_no");
					
					if(currPartialCntrNo == "") continue;
					
					var subPartialCntrNo = "";
					var subDate = "";
					
					
					// 이후 검색
					for(var j=i; j <= sObj.RowCount; j++) {
						
						subPartialCntrNo = sObj.CellValue(j, prefix+"partial_cntr_no");
						if(subPartialCntrNo == "") continue;
						
						if(currPartialCntrNo == subPartialCntrNo) {
						
							subDate = sObj.CellValue(j, prefix+field_id+"_dt") + sObj.CellValue(j, prefix+field_id+"_time");
							
							if(subDate == "") {
								sObj.CellValue2(j, prefix+field_id+"_dt") = dt;
								sObj.CellValue2(j, prefix+field_id+"_time") = hm;
							}
						
						} else {
							break;
						}
					} // end for(j)
					
					// 이전 검색
					for(var j=i; j >= 1; j--) {
						
						subPartialCntrNo = sObj.CellValue(j, prefix+"partial_cntr_no");
						if(subPartialCntrNo == "") continue;
						
						if(currPartialCntrNo == subPartialCntrNo) {
							
							subDate = sObj.CellValue(j, prefix+field_id+"_dt") + sObj.CellValue(j, prefix+field_id+"_time");
							
							if(subDate == "") {
								sObj.CellValue2(j, prefix+field_id+"_dt") = dt;
								sObj.CellValue2(j, prefix+field_id+"_time") = hm;
							}
						
						} else {
							break;
						}
					} // end for(j)
					
				}
				
				
			}
		}
	}catch(e){
		ComShowMessage(e);
	}
}

function chkDateTimeValid(obj, gubun){
	var rtn = "";
	if(gubun == "ymd"){
		var tmp = obj.value.replace('-', '').replace('-', '').replace('/', '').replace('/', '');
		if(tmp.length < 8) {
			//BKG00920, Please enter a valid date format: YYYYMMDD
			ComShowCodeMessage('BKG00921');
			obj.focus();
			return "false";
		}
		var year = parseInt(tmp.substring(0, 4));
		var mon = parseInt(eval(tmp.substring(4, 6))) - 1;
		var days = parseInt(eval(tmp.substring(6, 8)));
		
		d = new Date(year, mon, days);
		
		var yearD = d.getFullYear();
		var monD = d.getMonth();
		var daysD = d.getDate();
		
		if(year != yearD || mon != monD || days != daysD){
			//BKG00714, Please Check Date
			ComShowCodeMessage('BKG00714');
			obj.focus();
			return "false";
		}
	
		var arrDtM = "";
		if(monD+1 < 10) arrDtM = "0"+(monD+1);
		else arrDtM = ""+(monD+1);
		var arrDtD = "";
		if(daysD < 10) arrDtD = "0"+daysD;
		else arrDtD = ""+daysD;
		
		rtn = yearD+"-"+arrDtM+"-"+arrDtD;
		
	}else if (gubun == "hm"){
		var tmp = obj.value.replace(':', '');		
		if(tmp.length < 4) {
			//BKG00714, Please Check Date
			ComShowCodeMessage('BKG00714');
			obj.focus();
			return "false";
		}
		var hh = parseInt(eval(tmp.substring(0, 2)));
		if( ! (0 <= hh && hh <= 23)){
			//BKG00714, Please Check Date
			ComShowCodeMessage('BKG00714');
			obj.focus();
			return "false";
		}
		var mi = parseInt(eval(tmp.substring(2, 4)));
		if( ! (0 <= mi && mi <= 59)){
			//BKG00714, Please Check Date
			ComShowCodeMessage('BKG00714');
			obj.focus();
			return "false";
		}
		var arrDtH = "";
		if(hh < 10) arrDtH = "0"+hh;
		else arrDtH = ""+hh;
		var arrDtMi = "";
		if(mi < 10) arrDtMi = "0"+mi;
		else arrDtMi = ""+mi;
		
		rtn = arrDtH+":"+arrDtMi;
	}
	return rtn;
}

function chkClick(){
	if(event.srcElement.name == "arr_gubun"){
		
		var sr = event.srcElement;
		if(sr.checked){
			form.fromd.className = "input1";
			form.tod.className = "input1";
			form.fromt.className = "input1";
			form.tot.className = "input1";
			
			form.fromd.readOnly = false;
			form.tod.readOnly = false;
			form.fromt.readOnly = false;
			form.tot.readOnly = false;
			
			form.eq_ofc.className = "input"; 
			form.eq_ofc.readOnly = false;
			
			form.vvd.value = "";
			form.pod.value = ""
			form.vvd.readOnly = false;
			form.pod.readOnly = false;
			form.vvd.className = "input";
			form.pod.className = "input";
				
		}else{
			form.fromd.className = "input2";
			form.tod.className = "input2";
			form.fromt.className = "input2";
			form.tot.className = "input2";

			form.fromd.readOnly = true;
			form.tod.readOnly = true;
			form.fromt.readOnly = true;
			form.tot.readOnly = true;
			
			form.fromd.value = "";
			form.tod.value = "";
			form.fromt.value = "00:00";
			form.tot.value = "23:59";

			form.eq_ofc.value = "";
			form.eq_ofc.className = "input2"; 
			form.eq_ofc.readOnly = true;
			
			form.vvd.readOnly = false;
			form.pod.readOnly = false;
			form.vvd.className = "input1";
			form.pod.className = "input1";
				
		}
	}
	
}

/**
 * 키보드가 눌릴 때 dataformat으로 세팅하고 엔터키를 누를때 조회한다.
 * @author 김도완.
 * CoBkg.js를 같이 사용하지 못하는 예외상황이 발생하여 따로 구현함.
 * ymd에 대한 포맷에 대한 처리가 예외적.
*/
function obj_KeyPress(){
	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	var srcName = event.srcElement.getAttribute("name");
	var srcValue = event.srcElement.getAttribute("value");
	
	switch(event.srcElement.dataformat) {
   	case "ymd":
   		ComKeyOnlyNumber(event.srcElement);
   		if (srcValue.length == 4) {
   			event.srcElement.value = srcValue.substring(0,4) + "-"
   		}
   		if (srcValue.length == 7) {
   			event.srcElement.value = srcValue.substring(0,7) + "-"
   		}
       	break;
   	case "ymdhm":
   		ComKeyOnlyNumber(event.srcElement);
   		if (srcValue.length == 4) {
   			document.form.elements[srcName].value = srcValue.substring(0,4) + "-"
   		}
   		if (srcValue.length == 7) {
   			document.form.elements[srcName].value = srcValue.substring(0,7) + "-"
   		}
   		if (srcValue.length == 10) {
   			document.form.elements[srcName].value = srcValue.substring(0,10) + " "
   		}
   		if (srcValue.length == 13) {
   			document.form.elements[srcName].value = srcValue.substring(0,13) + ":"
   		}
       	break;
   	case "ym":
   	case "yw":
   	case "jumin":
   	case "saupja":	//숫자 + "-"
   		ComKeyOnlyNumber(event.srcElement, "-"); break;
   	case "hms":
   	case "hm":		//숫자 + ":"
   		ComKeyOnlyNumber(event.srcElement, ":"); 
       	if (srcValue.length == 2) {
       		event.srcElement.value = srcValue.substring(0,2) + ":"
   		}
   		break;
   		
   	case "yy":		//숫자 + "0"
   		ComKeyOnlyNumber(event.srcElement, "0"); break;
       case "int":		//숫자
           ComKeyOnlyNumber(event.srcElement);	break;
       case "float":	//숫자+"."
           ComKeyOnlyNumber(event.srcElement, "."); break;
       case "eng":		//영문 + 숫자
       	// 영문은 기본 대문자로 한다.(포멧에 대소문자 구분 + 숫자가 없음)
           ComKeyOnlyAlphabet('uppernum'); break;  
       case "engup":	//영문대문자
           ComKeyOnlyAlphabet('upper'); break;
       case "engdn":	//영문소문자
           ComKeyOnlyAlphabet('upper'); break;
       case "engupspace": //영문대문자 + Space
           if(event.keyCode != 32) {
           	ComKeyOnlyAlphabet('uppernum');
           }
       	break;
       case "etc": //모든 문자 가능하지만 영문은 대문자로
	        if(keyValue >= 97 && keyValue <= 122) {//소문자
               event.keyCode = keyValue + 65 - 97;
           }
       	break;
       default: 		//영문 + 숫자
       	ComKeyOnlyAlphabet('uppernum'); break;
   }
}

/* 개발자 작업 끝 */