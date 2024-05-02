/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESD_TRS_0260.js
 *@FileTitle : Delivery Monitor
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
===============================================================================
 History

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
 * @class ESD_TRS_0260 : ESD_TRS_0260 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESD_TRS_0260() {
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
var request = null;

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

			case "btn_downexcel":
				doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
				break;
				
			case "btn_ofc_cd":
				ComOpenPopup('/hanjin/COM_ENS_071.do', 700, 430, 'getSoOffice', '1,0,1,1,1,1,1,1');
				break;

			case "btn_detail":
			    if (sheetObject.SelectRow > 0) {
					popUpCall(sheetObject,sheetObject.SelectRow);
				}
				break;
			case "btns_frmnode": //FromNode Popup창
				openHireYardPopup('getFromNode');
			break;

			case "btns_vianode": //ViaNode Popup창
				openHireYardPopup('getViaNode');
			break;

			case "btns_tonode": //ToNode Popup창
				openHireYardPopup('getToNode');
			break;

			case "btns_dorloc": //DoorLocation Popup창
				openHireYardPopup('getDorLoc');
			break;				
				
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage("TRS90392");
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

	//Initializing
	initControl();
	initForm();

     var formObj = document.form;
	 // formObj.s_ofc_cd.value = "PHXSC";
	 // formObj.f_year.value = "2014";
	 // formObj.i_fm_wm.value = "01";
	 // formObj.i_to_wm.value = "02";
	
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
				style.height = GetSheetHeight(17);
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;   //msAll / msPrevColumnMerge / msHeaderOnly

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 25);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false, false);

				var HeadTitle1 = 				"Sts|SEQ|Week|Date|S/O Office|CY/Door|Bound|From|Via|To|Door|Door Name|S/O|W/O|D/O|Vol.|BKG DESC|BKG DESC2|BKG DESC3|FM_DT|TO_DT";

				var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
                
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				//데이터속성[		ROW,COL,	DATATYPE,    	 WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,						KEYFIELD, 	CALCULOGIC,	DATAFORMAT,	POINTCOUNT,	UPDATEEDIT,	INSERTEDIT,	EDITLEN,	FULLINPUT,	SORTENABLE,	TOOLTIP,	ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, 	dtHiddenStatus,	20,	daCenter,	true,		"ibflag",   		false, 		"", 		dfNone, 	0, 			false, 		false,  		 0, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtSeq,   		40,	daCenter, 	true,    	"seq", 				false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		60,	daCenter, 	true,    	"yr_week", 			false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		140,daCenter, 	true,    	"dt_period", 		false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		70,daCenter, 	true,    	"so_ofc_cd",  		false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtCombo,   		60,	daCenter, 	true,    	"so_tp_cd",   		false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		45,	daCenter, 	true,    	"bnd_cd",   		false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		55,	daCenter, 	true,    	"fm_nod_cd",   		false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		55,	daCenter, 	true,    	"via_nod_cd",   	false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		55,	daCenter, 	true,    	"to_nod_cd",   		false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		55,	daCenter, 	true,    	"dor_nod_cd",   	false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   	   100,	daLeft, 	true,    	"dor_nm",   		false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);								
				InitDataProperty(0, cnt++, 	dtData,   		55,daRight, 	true,    	"so_cnt",   		false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		55,daRight, 	true,    	"wo_cnt",      		false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		55,daRight, 	true,    	"do_cnt",      		false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		55,daRight, 	true,    	"cntr_cnt",      	false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,  		300,daLeft, 	true,    	"bkg_desc",      	false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,  		300,daLeft, 	true,    	"bkg_desc2",      	false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);	
				InitDataProperty(0, cnt++, 	dtHidden,  		300,daLeft, 	true,    	"bkg_desc3",      	false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);						
				InitDataProperty(0, cnt++, 	dtHidden,  		100,daCenter, 	true,    	"fm_dt",      		false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,  		100,daCenter, 	true,    	"to_dt",      		false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataCombo(0, 'so_tp_cd', "CY|DR", "C|Z");				
			}
			break;
			
		case 2:      //sheet1 init
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
				InitRowInfo(1, 1, 24);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false, false);

				var HeadTitle1 = 				"Sts|SEQ";

				var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
                
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				//데이터속성[		ROW,COL,	DATATYPE,    	 WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,						KEYFIELD, 	CALCULOGIC,	DATAFORMAT,	POINTCOUNT,	UPDATEEDIT,	INSERTEDIT,	EDITLEN,	FULLINPUT,	SORTENABLE,	TOOLTIP,	ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, 	dtHiddenStatus,	20,	daCenter,	true,		"ibflag",   					false, 		"", 		dfNone, 	0, 			false, 		false,  		 0, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtSeq,   		40,	daCenter, 	true,    	"seq", 							false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);		
			}
			break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction, chkflg) {
	//sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSEARCH:		//Retrieve
			if(!validateForm(sheetObj,formObj,sAction)) return;	   		
	   		formObj.f_cmd.value = SEARCH02;
            sheetObj.DoSearch4Post("ESD_TRS_0260GS.do", TrsFrmQryString(formObj));
	   		break;	   		
		case SEARCH01:		//Combo List
			if(!validateForm(sheetObj,formObj,sAction)) return;
			formObj.f_cmd.value = SEARCH01;
			var sXml = sheetObj.GetSearchXml("ESD_TRS_0260GS.do", TrsFrmQryString(formObj));
			var arrXml = sXml.split("|$$|");
		  	ComXml2ComboItem(arrXml[0], formObj.combo_svc_scp, "val", "name");
		  	ComXml2ComboItem(arrXml[1], formObj.combo_cust_tp, "val", "name");
		  	ComXml2ComboItem(arrXml[2], formObj.combo_pnl_div, "val", "name");
		  	ComXml2ComboItem(arrXml[3], formObj.combo_pnl_tp, "val", "name");
		  	ComXml2ComboItem(arrXml[4], formObj.combo_rev_tp, "val", "name");
			break;

		case IBDOWNEXCEL:	//Down Excel
			//if(!validateForm(sheetObj,formObj,sAction)) return;
			sheetObj.SpeedDown2Excel(-1, false, false);
			break;
	}
}

/**
* 화면 폼입력값에 대한 유효성검증 프로세스 처리
*/
function validateForm(sheetObj,formObj,sAction){
	switch(sAction){
		case IBSEARCH:
			if( formObj.s_ofc_cd.value == "" ){
				ComShowCodeMessage("COM130403","S/O Office Code");
				return false;
			}

			//Year의 입력 체크
			if( formObj.f_year.value.length != 4 ){
				ComShowCodeMessage("COM132201","Year");
				return false;
			}

			if( formObj.i_fm_wm.value.length != 2 ){
				ComShowCodeMessage("COM132201","Month/Week");
				return false;
			}

			if( formObj.i_to_wm.value.length != 2 ){
				ComShowCodeMessage("COM132201","Month/Week");
				return false;
			}

			//최대 조회 기간 1개월 여부 체크
			var diffDate = ComGetDaysBetween(formObj.s_fm_date, formObj.s_to_date);
			if( diffDate > 31 ){
				ComShowCodeMessage("TRS90391","One Months");
				return false;
			}

			break;
		case IBDOWNEXCEL:
			//그리드 데이터 없을 경우
			if( sheetObj.RowCount <= 0 ){
				return false;
			}
			break;
	}
	
	return true;
}


function initForm(){
	document.form.reset();
	document.getElementById("div_period").innerHTML = "";
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

/**
 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet1_OnSearchEnd(sheetObj,errMsg) {
	for( var i = parseInt(sheetObj.HeaderRows); i <= sheetObj.LastRow; i++ ){
		if (  sheetObj.CellValue(i, 'so_tp_cd') == 'Z' && sheetObj.CellValue(i, 'bnd_cd') == 'I' && (sheetObj.CellValue(i, 'cntr_cnt') != sheetObj.CellValue(i, 'do_cnt') )   ) {
			sheetObj.RowFontColor(i) = sheetObj.RgbColor(0,0,255);
		}
		
		if (  (sheetObj.CellValue(i, 'cntr_cnt') != sheetObj.CellValue(i, 'wo_cnt') ) ) {			
			sheetObj.RowFontColor(i) = sheetObj.RgbColor(155,0,0);
		}
		
		if (  (sheetObj.CellValue(i, 'cntr_cnt') != sheetObj.CellValue(i, 'so_cnt') ) ) {			
			sheetObj.RowFontColor(i) = sheetObj.RgbColor(255,0,0);
		}		
	}
}

function sheet1_OnDblClick(sheetObj, Row, Col, Value){
	//한 건의 팝업 처리
	popUpCall(sheetObj,Row);
}


function popUpCall(sheetObj, p_row){	
	if( sheetObj.RowCount <= 0 ){
		ComShowCodeMessage("COM130401");
		return;
	}
	
	var vStart = ",('";
	var vEnd = "')";
	var vSeparator = "','";
	var sUrl = "/hanjin/ESD_TRS_0270.do";
	var param = ""; // "?s_view=" + view_div;
	var vCond = "";
	var p_url = "";
	var formObj = document.form;
	var formObj2 = document.form2;

    //Detail 조회조건
	formObj2.s_sts_cd.value = formObj.s_sts_cd.value;
	formObj2.s_do_yn.value  = formObj.s_do_yn.value;
	formObj2.s_bkg_no.value = formObj.s_bkg_no.value;
	formObj2.s_cntr_no.value = formObj.s_cntr_no.value;
	formObj2.s_so_no.value  = formObj.s_so_no.value;
	formObj2.s_wo_no.value  = formObj.s_wo_no.value;

	formObj2.s_fm_dt.value  = removeChr(sheetObj.CellValue(p_row, "fm_dt"), ".");
	formObj2.s_to_dt.value  = removeChr(sheetObj.CellValue(p_row, "to_dt"), ".");
	formObj2.s_so_ofc_cd.value  = sheetObj.CellValue(p_row, "so_ofc_cd");
	formObj2.s_so_tp_cd.value  = sheetObj.CellValue(p_row, "so_tp_cd");
	formObj2.s_bnd_cd.value  = sheetObj.CellValue(p_row, "bnd_cd");
	formObj2.s_fm_nod_cd.value  = sheetObj.CellValue(p_row, "fm_nod_cd");
	formObj2.s_via_nod_cd.value  = sheetObj.CellValue(p_row, "via_nod_cd");
	formObj2.s_to_nod_cd.value  = sheetObj.CellValue(p_row, "to_nod_cd");
	formObj2.s_dor_nod_cd.value  = sheetObj.CellValue(p_row, "dor_nod_cd");
	formObj2.s_yr_week.value  = sheetObj.CellValue(p_row, "yr_week");
	
	//BKG NO가 614개보다 작으면 DETAIL은 BKG NO로 직접 조회하도록 한다.
	if (sheetObj.CellValue(p_row, "bkg_desc") != null) {
		formObj2.s_bkg_no.value = sheetObj.CellValue(p_row, "bkg_desc") + sheetObj.CellValue(p_row, "bkg_desc2") + sheetObj.CellValue(p_row, "bkg_desc3"); 
	}
	
	//document.form.s_param.value = document.form.s_search.value + "&s_cond=" + vCond;
	var myOption = "width=1024,height=700,menubar=0,status=0,scrollbars=0,resizable=1";
	window.open(sUrl + param, p_url, myOption);
	
}

function getSoOffice(rowArray){
	var colArray = rowArray[0];
	document.form.s_ofc_cd.value = colArray[3];
	document.form.s_ofc_cd.focus();
}

function chkWM(param){
	if( param == "W" ){
	    document.getElementById("div_wm").innerHTML = "Week";
	} else{
		document.getElementById("div_wm").innerHTML = "Month";
	}
	
	document.form.i_fm_wm.value = "";
	document.form.i_to_wm.value = "";
}

function setPeriod(obj){
	var formObj = document.form;
	if( obj == null ){
		return;
	}
	
	if( chkValidPeriod() ){
		var sheetObj = sheetObjects[1];
		sheetObj.RemoveEtcData();
		formObj.s_fm_date.value = "";
		formObj.s_to_date.value = "";
		document.getElementById("div_period").innerHTML = ".....";
		formObj.f_cmd.value = SEARCH08;
		sheetObj.DoSearch4Post("ESD_TRS_0999GS.do", TrsFrmQryString(formObj));
		
		var fm_date = sheetObj.EtcData("FM_DATE");
		var to_date = sheetObj.EtcData("TO_DATE");
		
		if( fm_date != null && to_date != null ){
			formObj.s_fm_date.value = doSepRemove(doSepRemove(fm_date, " "), "-");
			formObj.s_to_date.value = doSepRemove(doSepRemove(to_date, " "), "-");
			document.getElementById("div_period").innerHTML = "( " + fm_date + " ~ " + to_date + " )";
//			ComBtnEnable("btn_retrieve");
		}
	}
}

function chkValidPeriod(){
	var formObj = document.form;

	with(formObj){
		if( i_fm_wm.value.length == 1 ){
			i_fm_wm.value = "0" + i_fm_wm.value;
		}
		if( i_to_wm.value.length == 1 ){
			i_to_wm.value = "0" + i_to_wm.value;
		}
		if( f_year.value.length == "" || i_fm_wm.value == "" || i_to_wm.value == "" ){
			return false;
		}
		if( f_year.value.length != 4 ){
			return false;
		}
		if( f_chkprd[1].checked && i_fm_wm.value > i_to_wm.value ){
			ComShowMessage(ComGetMsg("TRS90386","Month of From should be equal to or less than To."));
			i_to_wm.focus();
			return false;
		}	
		if( f_chkprd[0].checked && i_fm_wm.value > i_to_wm.value ){
			ComShowMessage(ComGetMsg("TRS90386","Week of From should be equal to or less than To."));
			i_to_wm.focus();
			return false;
		}
		if( f_chkprd[1].checked ){
			if( ComParseInt(f_year.value) <= 1900
			|| ComParseInt(i_fm_wm.value) <= 0 || ComParseInt(i_fm_wm.value) > 12
			|| ComParseInt(i_to_wm.value) <= 0 || ComParseInt(i_to_wm.value) > 12 ){
				return false;
			}
		}
		if(f_chkprd[0].checked){
			if( ComParseInt(f_year.value) <= 1900
			|| ComParseInt(i_fm_wm.value) <= 0 || ComParseInt(i_fm_wm.value) >= 54
			|| ComParseInt(i_to_wm.value) <= 0 || ComParseInt(i_to_wm.value) >= 54 ){
				return false;
			}
		}
	}
	return true;
}

function createHttpRequest() {
	try{
		request = new XMLHttpRequest();
	} catch(trymicrosoft) {
		try{
			request = new ActiveXObject("Msxml2.XMLHTTP");
		} catch(othermicosoft) {
			try{
				request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch(failed) {
				request = null;
			}
		}
	}
	if( request == null ) {
		ComShowMessage("Error Request XMLHttp");
	}
}

function chkSubOfc(obj) {
	var ofcCd = "";
	var objOfc;
	if( obj.checked == true ){
		if( obj.name == "s_sub_ofc1" ){
			if( document.form.s_ofc_cd.value == "" ){
				obj.checked = false;
				ComShowCodeMessage("COM130201", "S/O Office Code");
				return false;
			}
			ofcCd = document.form.s_ofc_cd.value
		}
		
		var url = "ESD_TRS_0002GS.do?f_cmd="+SEARCH11+"&ctrl_so_office="+ofcCd;
		createHttpRequest();
		request.open("GET", url, false);
		if( obj.name == "s_sub_ofc1" ){
			request.onreadystatechange = subCtrtCntrOfc1;
		}
		request.send(null);	
	} else{
		if( obj.name == "s_sub_ofc1" ){
			objOfc = document.form.s_ofc_cd
		}
		if( objOfc.value.length >= 5 ){
			objOfc.value = objOfc.value.substr(0,objOfc.value.indexOf(","))
		}
	}
}

function subCtrtCntrOfc1() {
	if( request.readyState == 4 ) {
		if( request.status == 200 ) {
			var docXml = request.responseXML;
			var rowXml = docXml.getElementsByTagName("row-count")[0];
			var subXml = null;
			var text_ofc = "";
			for( var n = 0; n < rowXml.firstChild.nodeValue; n++ ) {
				subXml = docXml.getElementsByTagName("sub-office")[n];
				text_ofc = text_ofc+subXml.firstChild.nodeValue+",";
			}
			if( text_ofc.length < 1 ) {
				document.form.s_ofc_cd.checked = false;
				ComShowMessage("No Data!");
			}
			document.form.s_ofc_cd.value = text_ofc.substring(0, text_ofc.length - 1);
		}
	}
}

//  string을 읽어들여 db 저장을 위해 특정문자('-')를 제거
function removeChr(str, chr) {
	var value = "";
	for ( var i = 0; i < str.length; i++ ) {
		var ch = str.charAt(i);
		if ( ch != chr ) value = value + ch;
	}
	return value;
}

/*
 * 외부 콤보박스의 리스트 가져오기 (ESD_TRS_0003.js에도 존재).
 */
function getComboList(obj, comObj, sep) { //object, 값을 받는부분, 'Node종류
	var formObj = document.form;
	var lvobj = doSepRemove(obj.value.toUpperCase(), " ");
	var charval = "Y";
	obj.value = lvobj;

	for (var i = 0; i < lvobj.length; i++) {
		var oneChar = lvobj.charAt(i)
		if (oneChar != "") {
			if (  (oneChar >= "a" && oneChar <= "z" ) || (oneChar >= "A" && oneChar <= "Z" )    ){
			}else {
				charval ="N";
				break;
			}
		} else {
			charval ="N";
			break;
		}
	}
	if(charval!="Y") {
		var errMessage = ComGetMsg('COM12130','Location','Node Code','');  
		ComShowMessage(errMessage);
		obj.value = "";
		obj.focus();
		return false;
	}
	if( lvobj == "" ) {
		obj.value = "";
		if(obj.name == 'search_fm_loc') yard_obj = document.search_fm_yard;
		else if(obj.name == 'search_via_loc') yard_obj = document.search_to_yard;
		else if(obj.name == 'search_to_loc') yard_obj = document.search_to_yard;
		else if(obj.name == 'search_door_loc') yard_obj = document.search_door_yard;

		var locValue = obj.value;
		if(ComTrim(locValue) == ''){
			yard_obj.RemoveAll();
			return;
		}
//	}else if( lvobj.length != 5 ) {
//		ComShowCodeMessage("TRS90074");
//		if(sep=="F"){
//			formObj.search_fm_loc.select();
//			formObj.search_fm_loc.focus();
//		}else if(sep=="V"){
//			formObj.search_via_loc.select();
//			formObj.search_via_loc.focus();
//		}else if(sep=="T"){
//			formObj.search_to_loc.select();
//			formObj.search_to_loc.focus();
//		}else if(sep=="D"){
//			formObj.search_door_loc.select();
//			formObj.search_door_loc.focus();
//		}
	}else{
		if( sep == 'F' ) {
			lvFromNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
		}else if( sep == 'V' ){
			lvViaNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
		}else if( sep == 'T' ){
			lvToNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
		}else if( sep == 'D' ){
			lvDoorLoc = getZoneCombo(comObj, sheetObjects[0], formObj, lvobj);
		}else{
		}
		comObj.focus();
	}
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
 * Location : 팝업에서 단일 선택을 한경우..
 */
function getTRS_ENS_906(rowArray,returnval) {
	var formObject = document.form;
	
	if(returnval=="Booking No."){
		var x2=document.form.s_bkg_no.value;
		if(x2==""){
			document.form.s_bkg_no.value = rowArray;
			formObject.s_bkg_no.focus();
		}else{
			document.form.s_bkg_no.value = document.form.s_bkg_no.value+","+rowArray;
			formObject.s_bkg_no.focus();
		}
	}else if(returnval=="Container No."){
		var x4=document.form.s_cntr_no.value;
		if(x4==""){
			document.form.s_cntr_no.value = rowArray;
			formObject.s_cntr_no.focus();
		}else{
		    document.form.s_cntr_no.value = document.form.s_cntr_no.value+","+rowArray;
			formObject.s_cntr_no.focus();
		}
	}else if(returnval=="S/O No."){
		var x5=document.form.s_so_no.value;
		if(x5==""){
			document.form.s_so_no.value = rowArray;
			formObject.s_so_no.focus();
		}else{
			document.form.s_so_no.value = document.form.s_so_no.value+","+rowArray;
			formObject.s_so_no.focus();
		}
	}else if(returnval=="W/O No."){
		var x5=document.form.s_wo_no.value;
		if(x5==""){
			document.form.s_wo_no.value = rowArray;
			formObject.s_wo_no.focus();
		}else{
			document.form.s_wo_no.value = document.form.s_wo_no.value+","+rowArray;
			formObject.s_wo_no.focus();
		}
	}else{
	}
}

/**
 * 공통 Node popup
 */
function openHireYardPopup(objName) {
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var classId = objName;
	var xx1 = ""; //CONTI
	var xx2 = ""; //SUB CONTI
	var xx3 = ""; //COUNTRY
	var xx4 = ""; //STATE
	var xx5 = ""; //CONTROL OFFIC
	var xx6 = ""; //LOC CODE
	var xx7 = ""; //LOC NAME
	var xx8 = "";
	var xx9 = "";
	if( objName == "getDorLoc" ) {
		v6 = "zone"
	} else {
		v6 = "yard";
	}
	
	var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+"&mode="+v6;
	ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 772, 450, objName, '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
 * From Node 팝업에 대한 리턴값
 */
function getFromNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.search_fm_loc.value = lvLoc;
	getYardCombo(document.search_fm_yard, sheetObjects[0], formObject, lvLoc);
	document.search_fm_yard.CODE = lvYard;
}

/**
 * Via Node 팝업에 대한 리턴값
 */
function getViaNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.search_via_loc.value = lvLoc;
	getYardCombo(document.search_via_yard, sheetObjects[0], formObject, lvLoc);
	document.search_via_yard.CODE = lvYard;
}

/**
 * To Node 팝업에 대한 리턴값
 */
function getToNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.search_to_loc.value = lvLoc;
	getYardCombo(document.search_to_yard, sheetObjects[0], formObject, lvLoc);
	document.search_to_yard.CODE = lvYard;
}

/**
 * Door Location 팝업에 대한 리턴값
 */
function getDorLoc(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
		
	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.search_door_loc.value = lvLoc;
	getZoneCombo(document.search_door_yard, sheetObjects[0], formObject, lvLoc);
	document.search_door_yard.CODE = lvYard;
}