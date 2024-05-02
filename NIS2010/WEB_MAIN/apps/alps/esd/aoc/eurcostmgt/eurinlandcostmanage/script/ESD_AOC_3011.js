/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESD_AOC_3011.js
 *@FileTitle : Cost & Guideline Tariff Status Monitoring
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.05.03
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends 
 * @class ESD_AOC_3011 : ESD_AOC_3011 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESD_AOC_3011() {
    this.processButtonClick     = processButtonClick;
    this.setSheetObject         = setSheetObject;
    this.setComboObject         = setComboObject;
    this.setTabObject           = setTabObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;        
    this.initControl            = initControl;
    this.initTab                = initTab;
    this.doActionIBSheet        = doActionIBSheet;
    this.validateForm           = validateForm;
}
/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/

/* 공통전역변수 */
//var calPop = new ComCalendarGrid();
var curTab = 1;
var beforetab = 0;
var sheetObjects = new Array();
var sheetCnt = 0;
var Mincount = 0;

var comboObjects = new Array();
var comboCnt = 0 ;

var rdObjects = new Array();

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의  */
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
				
			case "btn_calendar":
				getCalendar();
				break;
				
			case "btn_country":
				ComOpenPopup('/hanjin/COM_ENS_0M1.do', 565, 480, 'getCountry', "1,0,1,1,1,1,1,1,1,1,1,1", true);
				break;

			case "btn_downexcel":
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
				break;

			case "btn_batch":
				doActionIBSheet(sheetObject,formObject,MULTI);
				break;
				
			case "btn_cancel":
				doActionIBSheet(sheetObject,formObject,MULTI01);
				break;

			case "btn_cost_tariff":
				goCostTrfMgmt();
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
	
	//MultiCombo초기화 
    for(var k=0;k<comboObjects.length;k++){
    	initCombo(comboObjects[k],comboObjects[k].id);
    }
	
	//Initializing
	doActionIBSheet(sheetObjects[0],document.form,SEARCH02);
//	doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
//	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	
	initControl();
}

 
/**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */ 
function initCombo(comboObj, comboId) {
	var formObject = document.form
	if( comboId == "combo_rhq" ){
		comboObj.DropHeight = 200;
		comboObj.MultiSelect = true;
		comboObj.MultiSeparator=",";
		comboObj.UseEdit = false;
		comboObj.Enable = false;
//		comboObj.BackColor = "#CCFFFD";
    } else if( comboId == "combo_sts" ){
		comboObj.DropHeight = 200;
		comboObj.MultiSelect = true;
		comboObj.MultiSeparator=",";
		comboObj.UseEdit = false;
//		comboObj.BackColor = "#CCFFFD";
    } else{
    	MultiSelect = false;
 		UseEdit = true;
    }
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
    axon_event.addListenerFormat('blur',    'obj_blur',     form);	//Blur
//    axon_event.addListenerFormat('focus',   'obj_focus',    form);	//Focus
    axon_event.addListenerFormat('keypress','obj_keypress', form);	//Key Press 
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
	var elementObj = event.srcElement;
	var formObj = document.form;

 	switch(elementObj.name){ 	    	
 		case "cnt_cd":
 			if(!isNull(elementObj.value)){
 				formObj.f_cmd.value = SEARCH03;
				var sXml = sheetObjects[1].GetSearchXml("ESD_AOC_3011GS.do", FormQueryString(formObj), true);
				var err_flg = ComGetEtcData(sXml, "err_flg");
				
				if( err_flg == "Y" ){
					ComShowCodeMessage("COM132201", "Country Code");
					formObj.cnt_cd.value = "";
					ComAlertFocus(formObj.cnt_cd, "");
					return false;
				}
 			}
 			break;
 	}
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
	var srcName = event.srcElement.getAttribute("name");
	var srcValue = event.srcElement.getAttribute("value");
	
	switch(event.srcElement.dataformat){
		case "engup":		//영문대문자
	 		ComKeyOnlyAlphabet('upper');
	 		break;
	 		
		case "engupnum":	//숫자+영문대분자 입력하기
			ComKeyOnlyAlphabet('uppernum');
			break;

		case "num":			//숫자 입력하기
			ComKeyOnlyNumber(event.srcElement);
			break;
		
		case "engnum":		//숫자+영문대소 입력하기
			ComKeyOnlyAlphabet('num'); 
			break;
			
		case "engupcomma":	//영문대문자+Comma
			ComKeyOnlyAlphabet('upper', '44');
	        break;
	        
		case "engupnumcomma":	//숫자+영문대분자+Comma
			ComKeyOnlyAlphabet('upper', '44|48|49|50|51|52|53|54|55|56|57');
	        break;
	        
		case "ymd":
			ComKeyOnlyNumber(event.srcElement);
			if (srcValue.length == 4) {
				document.form.elements[srcName].value = srcValue.substring(0, 4) + "-"
			}
			if (srcValue.length == 7) {
				document.form.elements[srcName].value = srcValue.substring(0, 7) + "-"
			}
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
				style.height = GetSheetHeight(18);
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;   //msAll / msPrevColumnMerge / msHeaderOnly

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(3, 1, 24);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, false, false, true, true, false) ;

				var HeadTitle1 =  "RHQ|Tariff\nType|Delivery\nCountry|BND|Interval|Cost Tariff|Cost Tariff|Cost Tariff|Cost Tariff|Cost Tariff|Cost Tariff|Cost Tariff|Cost Tariff|Cost Tariff|Cost Tariff|Cost Tariff|Guideline Tariff|Guideline Tariff|Guideline Tariff|Guideline Tariff|Guideline Tariff|Guideline Tariff|Guideline Tariff|Guideline Tariff|Guideline Tariff|Guideline Tariff|Guideline Tariff|Guideline Tariff";
				var HeadTitle2 =  "RHQ|Tariff\nType|Delivery\nCountry|BND|Interval|No|Status|Status|Effective Period|Effective Period|Creation\nDate|Creation\nUser|Creation\nUser|Update\nDate|Update\nUser|Update\nUser|No|Amend\nSEQ|Status|Status|Effective Period|Effective Period|Creation\nDate|Creation\nUser|Creation\nUser|Update\nDate|Update\nUser|Update\nUser";
				var HeadTitle3 =  "RHQ|Tariff\nType|Delivery\nCountry|BND|Interval|No|Status|Status|From|To|Creation\nDate|Creation\nUser|Creation\nUser|Update\nDate|Update\nUser|Update\nUser|No|Amend\nSEQ|Status|Status|From|To|Creation\nDate|Creation\nUser|Creation\nUser|Update\nDate|Update\nUser|Update\nUser";

				var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 5, 0, true);
                
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
				InitHeadRow(2, HeadTitle3, true);

				//데이터속성[		ROW,COL,	DATATYPE,    	 WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,			KEYFIELD, 	CALCULOGIC,	DATAFORMAT,		POINTCOUNT,	UPDATEEDIT,	INSERTEDIT,	EDITLEN,	FULLINPUT,	SORTENABLE,	TOOLTIP,	ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, 	dtData,   			50,	daCenter, 	true,    	"rhq_cd", 			false, 		"", 		dfNone, 		0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   			60,	daCenter, 	true,    	"trf_tp",  			false, 		"", 		dfNone, 		0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   			60,	daCenter, 	true,    	"cnt_cd",   		false, 		"", 		dfNone, 		0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    40,	daCenter, 	true,    	"io_bnd_cd",      	false, 		"", 		dfNone, 		0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    60,	daRight, 	true,    	"itval",      		false, 		"", 		dfNullInteger, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    80,	daCenter, 	true,    	"cost_trf_no",      false, 		"", 		dfNone, 		0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,   		40,	daCenter, 	true,    	"cost_trf_sts_cd",  false, 		"", 		dfNone, 		0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   			70,	daCenter, 	true,    	"cost_trf_sts_nm",  false, 		"", 		dfNone, 		0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   			80,	daCenter, 	true,    	"eff_fm_dt",   		false, 		"", 		dfDateYmd, 		0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		    80,	daCenter, 	true,    	"eff_to_dt",  		false, 		"", 		dfDateYmd, 		0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   	    	80,	daCenter, 	true,    	"c_cre_dt",      	false, 		"", 		dfDateYmd, 		0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,   		80,	daLeft, 	true,    	"c_cre_usr_id",     false, 		"", 		dfNone, 		0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		   120,	daLeft, 	true,    	"c_cre_usr_nm",     false, 		"", 		dfNone, 		0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   			80,	daCenter, 	true,    	"c_upd_dt", 		false, 		"", 		dfDateYmd, 		0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,   		80,	daLeft, 	true,    	"c_upd_usr_id", 	false, 		"", 		dfNone, 		0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		   120,	daLeft, 	true,    	"c_upd_usr_nm", 	false, 		"", 		dfNone, 		0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   			80,	daCenter, 	true,    	"ihc_trf_no", 		false, 		"", 		dfNone, 		0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    50,	daRight, 	true,    	"amdt_seq",    		false, 		"", 		dfNone, 		0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,   	    40,	daCenter, 	true,    	"fic_prop_sts_cd",  false, 		"", 		dfNone, 		0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		    70,	daCenter, 	true,    	"fic_prop_sts_nm",  false, 		"", 		dfNone, 		0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		    80,	daCenter, 	true,    	"eff_dt",   		false, 		"", 		dfDateYmd, 		0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		    80,	daCenter, 	true,    	"exp_dt",   		false, 		"", 		dfDateYmd, 		0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		    80,	daCenter, 	true,    	"p_cre_dt",  		false, 		"", 		dfDateYmd, 		0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,   		80,	daLeft, 	true,    	"p_cre_usr_id", 	false, 		"", 		dfNone, 		0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		   120,	daLeft, 	true,    	"p_cre_usr_nm", 	false, 		"", 		dfNone, 		0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		    80,	daCenter, 	true,    	"p_upd_dt",  		false, 		"", 		dfDateYmd, 		0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,   		80,	daLeft, 	true,    	"p_upd_usr_id", 	false, 		"", 		dfNone, 		0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		   120,	daLeft, 	true,    	"p_upd_usr_nm", 	false, 		"", 		dfNone, 		0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
			}
		break;
		
		
		case 2:      //sheet2 init
			with (sheetObj) {
				//높이 설정
				style.height = GetSheetHeight(0);
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;   //msAll / msPrevColumnMerge / msHeaderOnly
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 23);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, false, true, true, true, false) ;
	
				var HeadTitle =  "Sts|RHQ";
	
				var headCount = ComCountHeadTitle(HeadTitle);
	
	            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	            InitColumnInfo(headCount, 0, 0, true);
	            
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
	
				//데이터속성[		ROW,COL,	DATATYPE,    	 WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, 	CALCULOGIC,	DATAFORMAT,	POINTCOUNT,	UPDATEEDIT,	INSERTEDIT,	EDITLEN,	FULLINPUT,	SORTENABLE,	TOOLTIP,	ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, 	dtHiddenStatus,		20,	daCenter,	true,		"ibflag",   	false, 		"", 		dfNone, 	0, 			false, 		false,  		 0, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   			50,	daCenter, 	true,    	"rhq_cd",  		false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
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
	   		sheetObj.DoSearch4Post("ESD_AOC_3011GS.do", AocFrmQryString(formObj));
	   		break;
	   		
		case SEARCH01:		//RHQ Office Code
			if(!validateForm(sheetObj,formObj,sAction)) return;
			formObj.f_cmd.value = SEARCH01;
			var sXml = sheetObj.GetSearchXml("ESD_AOC_3011GS.do", AocFrmQryString(formObj));
			formObj.rhq_cd.value = ComGetEtcData(sXml, "rhq_cd");
			formObj.shq_flg.value = ComGetEtcData(sXml, "shq_flg");
			if( formObj.shq_flg.value == "Y" ){
				comboObjects[0].enable = true;
				comboObjects[0].Text = "All";
			} else{
				comboObjects[0].enable = false;
				comboObjects[0].Code = formObj.rhq_cd.value;
			}
			break;
			
		case SEARCH02:		//Combo List
			if(!validateForm(sheetObj,formObj,sAction)) return;
			formObj.f_cmd.value = SEARCH02;
			var sXml = sheetObj.GetSearchXml("ESD_AOC_3011GS.do", AocFrmQryString(formObj));
			var arrXml = sXml.split("|$$|");
		  	ComXml2ComboItem(arrXml[0], formObj.combo_rhq, "val", "name");
		  	ComXml2ComboItem(arrXml[1], formObj.combo_sts, "val", "name");
		  	comboObjects[0].Code = formObj.rhq_cd.value;
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
		case IBDOWNEXCEL:
			//그리드 데이터 없을 경우
			if( sheetObj.RowCount <= 0 ){
				return false;
			}
			break;
	}
	
	return true;
}


/**
* 화면 폼입력값에 Null Check
*/
function isNull(itemValue){
   if(itemValue==null || itemValue=="" || itemValue=="undefined"){
   	return true;
   }
   else{
   	return false;
   }
}


function goCostTrfMgmt(){
	//그리드 데이터 없을 경우
	if( sheetObjects[0].RowCount <= 0 ){
		ComShowCodeMessage("COM130401");
		return;
	}
	//Tariff No 없을 경우
	if( sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"cost_trf_no") == "" ){
		ComShowCodeMessage("AOC90011");
		return;
	}
	//Checking Status( B:Created, U:Updated, C:Confirmed ) B/U/C 상태가 아니면 메시지 띄움
	if( sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"cost_trf_sts_cd") != "B"
	&& sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"cost_trf_sts_cd") != "U"
	&& sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"cost_trf_sts_cd") != "C" ){
		ComShowCodeMessage("AOC90012");
		return;
	}
	
	//Inland / Ocean Feeder 구분으로 호출 팝업창 결정
	if( sheetObjects[0].Cellvalue(sheetObjects[0].SelectRow,"trf_tp") == "Inland" ){
		var sUrl = "/hanjin/ESD_AOC_3002.do";
		var winNm = "ESD_AOC_3002";
		var param = '?trf_no='+sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"cost_trf_no");
		var myOption = "width=1024,height=640,menubar=0,status=0,scrollbars=0,resizable=1";
	} else{
		var sUrl = "/hanjin/ESD_AOC_3022.do";
		var winNm = "ESD_AOC_3022";
		var param = '?trf_no='+sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"cost_trf_no");
		var myOption = "width=1024,height=640,menubar=0,status=0,scrollbars=0,resizable=1";
	}
	window.open(sUrl + param, winNm, myOption);
}


function getCalendar() {
	var cal = new ComCalendarFromTo();
	cal.displayType = "date";
	cal.select(document.form.fm_dt, document.form.to_dt, 'yyyy-MM-dd');
}


function getCountry(rowArray) {
	var colArray = rowArray[0];
	if( document.form.cnt_cd.value != ""){
		document.form.cnt_cd.value = document.form.cnt_cd.value + "," + colArray[3];
	} else{
		document.form.cnt_cd.value = colArray[3];
	}
	document.form.cnt_cd.focus();
}

/**
* 팝업호출
*/
function so_OnPopupClick(val) {
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var classId ="getCOM_ENS_so";
	var xx1=val;  //CONTI
	var xx2="";  //SUB CONTI
	var xx3="";  //COUNTRY
	var xx4="";  //STATE
	var xx5="";  //CONTROL OFFIC
	var xx6="";  //LOC CODE
	var xx7="";  //LOC NAME
	var xx8="";
	var xx9="";
	var title = val;

	var param ="?returnval="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+"&returntitle="+title;
	ComOpenPopup('/hanjin/ESD_TRS_0906.do' + param, 412, 330, 'getCOM_ENS_906', '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
* Multi Select
*/
function getTRS_ENS_906(rowArray,returnval) {
	var formObject = document.form;

	if(returnval=="cnt_cd") {
		var x1=document.form.cnt_cd.value;
		if(x1==""){
			document.form.cnt_cd.value = rowArray;
		}else{
			document.form.cnt_cd.value = document.form.cnt_cd.value+","+rowArray;
		}
		document.form.cnt_cd.value = document.form.cnt_cd.value.toUpperCase()
		formObject.cnt_cd.focus();
	} else if(returnval=="cost_trf_no") {
		var x1=document.form.cost_trf_no.value;
		if(x1==""){
			document.form.cost_trf_no.value = rowArray;
		}else{
			document.form.cost_trf_no.value = document.form.cost_trf_no.value+","+rowArray;
		}
		document.form.cost_trf_no.value = document.form.cost_trf_no.value.toUpperCase()
		formObject.cost_trf_no.focus();
	} else if(returnval=="ihc_trf_no") {
		var x1=document.form.ihc_trf_no.value;
		if(x1==""){
			document.form.ihc_trf_no.value = rowArray;
		}else{
			document.form.ihc_trf_no.value = document.form.ihc_trf_no.value+","+rowArray;
		}
		document.form.ihc_trf_no.value = document.form.ihc_trf_no.value.toUpperCase()
		formObject.ihc_trf_no.focus();
	}
}


function combo_sts_OnCheckClick(comboObj, index, code) {
	if( code == "" ){
		if( comboObj.CheckIndex(0) == false ){
			comboObj.Code = "";
			comboObj.CheckIndex(0) = false;
		} else{
			comboObj.Code = "";
			comboObj.CheckIndex(0) = true;
		}
	} else{
		comboObj.CheckIndex(0) = false;
	}
}

function combo_rhq_OnCheckClick(comboObj, index, code) {
	if( code == "" ){
		if( comboObj.CheckIndex(0) == false ){
			comboObj.Code = "";
			comboObj.CheckIndex(0) = false;
		} else{
			comboObj.Code = "";
			comboObj.CheckIndex(0) = true;
		}
	} else{
		comboObj.CheckIndex(0) = false;
	}
}
