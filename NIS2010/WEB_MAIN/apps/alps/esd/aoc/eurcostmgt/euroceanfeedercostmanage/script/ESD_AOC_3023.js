/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESD_AOC_3023.js
*@FileTitle : Ocean Feeder Cost Management Cost Detail (EUR)
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================
* History
* 2015.02.03 CHM-201533794 전지예 [AOC] 45' Cost 추가
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
     * @class ESD_AOC_3023 : esd_aoc_3023 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esd_aoc_3023() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0; 

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;
/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;

			case "btn_downexcel":
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
				break;

			case "btn_close":
				window.close();
				break;


		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage("AOC90004");
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * IBSheet Object를 배열로 등록
 * comSheetObject(id)에서 호출한다
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
function loadPage(){
	for(i=0;i<sheetObjects.length;i++){
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	document.form.amt20.value = ComAddComma2(document.form.amt20.value+"","#,###.00");
	document.form.amt40.value = ComAddComma2(document.form.amt40.value+"","#,###.00");
	document.form.amt45.value = ComAddComma2(document.form.amt45.value+"","#,###.00");	// 45' Cost 추가
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	initControl();
}


/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 */
function initControl() {
//    axon_event.addListener('click', 'obj_click', 'manual');    		//Click
//    axon_event.addListener('keyup', 'obj_keyup', 'boo_bkg_no'); 		//Key Up
//    axon_event.addListenerFormat('blur',    'obj_blur',     form);	//Blur
//    axon_event.addListenerFormat('focus',   'obj_focus',    form);	//Focus
//    axon_event.addListenerFormat('keypress','obj_keypress', form);	//Key Press 
}


/**
 * HTML Control의 objClick이벤트에서 영문숫자만 입력 처리한다. <br>
 */
function obj_click() {
}


/**
 * HTML Control의 objKeyup이벤트에서 영문숫자만 입력 처리한다. <br>
 */
function obj_keyup() {
}


/**
 * HTML Control의 onBlur이벤트에서 Validation을 체크한다. <br>
 */
function obj_blur(){
}

/**
 * HTML Control의 onFocus이벤트에서 마스크 구분자를 제거한다. <br>
 */
function obj_focus(){
//            ComClearSeparator(event.srcElement);
}

/**
 * HTML Control의 onKeypress이벤트에서 숫자만 입력되게 한다. <br>
 */
function obj_keypress(){
	switch(event.srcElement.dataformat){
		case "engup":		//영문대문자
	 		ComKeyOnlyAlphabet('upper');
	 		break;
	 		
		case "engupnum":	//숫자+"영문대분자"입력하기
			ComKeyOnlyAlphabet('uppernum');
			break;

		case "num":			//숫자 입력하기
			ComKeyOnlyNumber(event.srcElement);
			break;
		
		case "engnum":		//숫자+"영문대소"입력하기
			ComKeyOnlyAlphabet('num'); 
			break;
			
		case "engupcomma":	//영문대문자+Comma
			ComKeyOnlyAlphabet('upper', '44');
	        break;
		
		default:
	}
}
//Axon 이벤트 처리2. 이벤트처리함수 --- end

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
	var cnt = 0;
	switch(sheetNo) {
		case 1:      //sheet1 init
			with (sheetObj) {
				//높이 설정
				style.height = GetSheetHeight(20);
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msPrevColumnMerge;   //msAll / msPrevColumnMerge / msHeaderOnly

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 23);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, false, false, true, false, false) ;

				var HeadTitle1 =  "Node/Link|Activity\nGroup|Cost\nElement|Cost\nElement|Cost\nCode|Cost Code Description|20'|20'|20'|40'|40'|40'|45'|45'|45'";
				var HeadTitle2 =  "Node/Link|Activity\nGroup|Cost\nElement|Cost\nElement|Cost\nCode|Cost Code Description|System\nSource|System\nAmount|Remark (USD)|System\nSource|System\nAmount|Remark (USD)|System\nSource|System\nAmount|Remark (USD)";

				var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
                
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);

				//데이터속성[		ROW,COL,	DATATYPE,    	 WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,			KEYFIELD, 	CALCULOGIC,	DATAFORMAT,		POINTCOUNT,	UPDATEEDIT,	INSERTEDIT,	EDITLEN,	FULLINPUT,	SORTENABLE,	TOOLTIP,	ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, 	dtData,   		   150,	daLeft, 	true,    	"trf_rout_desc",	false, 		"", 		dfNone, 		0, 			false, 		false, 			30, 	false,	 	false, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		    85,	daLeft, 	true,    	"act_grp",      	false, 		"", 		dfNone, 		0, 			false, 		false, 			30, 	false,	 	false, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,   		70,	daCenter, 	true,    	"stnd_cost_cd", 	false, 		"", 		dfNone, 		0, 			false, 		false, 			30, 	false,	 	false, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		   135,	daLeft, 	true,    	"stnd_cost_nm", 	false, 		"", 		dfNone, 		0, 			false, 		false, 			30, 	false,	 	false, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		    50,	daCenter, 	true,    	"src_cd",  			false, 		"", 		dfNone, 		0, 			false, 		false, 			30, 	false,	 	false, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		   200,	daLeft, 	true,    	"src_nm",  			false, 		"", 		dfNone, 		0, 			false, 		false, 			30, 	false,	 	false, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   			60,	daCenter, 	true,    	"sys_src_cd_20ft",  false, 		"", 		dfNone, 		0, 			false, 		false, 			30, 	false,	 	false, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   			60,	daRight, 	true,    	"trf_amt_20ft",		false, 		"", 		dfNullFloatOrg, 2, 			false, 		false, 			30, 	false,	 	false, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		   180,	daLeft, 	true,    	"calc_rmk_20ft",    false, 		"", 		dfNone, 		0, 			false, 		false, 			30, 	false,	 	false, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		    60,	daCenter, 	true,    	"sys_src_cd_40ft",  false, 		"", 		dfNone, 		0, 			false, 		false, 			30, 	false,	 	false, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		    60,	daRight, 	true,    	"trf_amt_40ft",  	false, 		"", 		dfNullFloatOrg, 2, 			false, 		false, 			30, 	false,	 	false, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		   180,	daLeft, 	true,    	"calc_rmk_40ft",    false, 		"", 		dfNone, 		0, 			false, 		false, 			30, 	false,	 	false, 		"", 		false);
				// 45' Cost 추가
				InitDataProperty(0, cnt++, 	dtData,   		    60,	daCenter, 	true,    	"sys_src_cd_45ft",  false, 		"", 		dfNone, 		0, 			false, 		false, 			30, 	false,	 	false, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		    60,	daRight, 	true,    	"trf_amt_45ft",  	false, 		"", 		dfNullFloatOrg, 2, 			false, 		false, 			30, 	false,	 	false, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		   180,	daLeft, 	true,    	"calc_rmk_45ft",    false, 		"", 		dfNone, 		0, 			false, 		false, 			30, 	false,	 	false, 		"", 		false);
			}
		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction, chkflg) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSEARCH:		//Retrieve
			if(!validateForm(sheetObj,formObj,sAction)) return;
	   		formObj.f_cmd.value = SEARCH;
	   		sheetObj.DoSearch4Post("ESD_AOC_3023GS.do", AocFrmQryString(formObj));
	   		break;
	   		
		case IBDOWNEXCEL:	//Down Excel
			if(!validateForm(sheetObj,formObj,sAction)) return;
			sheetObj.SpeedDown2Excel(-1, false, false);
			break;
	}
}

/**
* 화면 폼입력값에 대한 유효성검증 프로세스 처리
*/
function validateForm(sheetObj,formObj,sAction){
	switch(sAction){
		case MULTI:
			//그리드 데이터 없을 경우
			if( sheetObj.RowCount <= 0 ){
				return false;
			}
			break;
	}
	
	return true;
}

/**
 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet1_OnSearchEnd(sheetObj,errMsg) {
}
