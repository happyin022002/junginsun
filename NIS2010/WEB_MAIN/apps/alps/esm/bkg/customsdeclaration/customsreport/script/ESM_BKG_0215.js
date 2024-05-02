/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_02151.js
*@FileTitle : DownLoad History
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.05.20손윤석
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/**
 * JSDOC 을 위한 함수 정의
 */
function esm_bkg_0215() {
    this.processButtonClick		= processButtonClick;
    this.setSheetObject 		= setSheetObject;
    this.loadPage 				= loadPage;
    this.initSheet 				= initSheet;
    this.doActionIBSheet 		= doActionIBSheet;
    this.validateForm 			= validateForm;
}
    
// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
		case "btn_retrieve":	// 조회
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			break; 

		case "btn_downexcel":	// 엑셀 다운로드
			doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
			break;
		case "rad_mrn":			// MRN 선택
			sheetObject1.removeAll();
			//mrn_no 조회
			formObject.txt_mrn.readOnly 	= false;
			formObject.txt_vvd.readOnly 	= true;
			formObject.txt_pol.readOnly 	= true;
			formObject.txt_pod.readOnly 	= true;
			formObject.date_from.readOnly 	= true;
			formObject.date_to.readOnly 	= true;

			formObject.txt_mrn.value		= '';
			formObject.txt_vvd.value 		= '';
			formObject.txt_pol.value 		= '';
			formObject.txt_pod.value 		= '';
			formObject.date_from.value 		= '';
			formObject.date_to.value 		= '';

			formObject.txt_mrn.className    = "input1";
			formObject.txt_vvd.className    = "input2";
			formObject.txt_pol.className    = "input2";
			formObject.txt_pod.className    = "input2";
			formObject.date_from.className  = "input2";
			formObject.date_to.className    = "input2";

			formObject.rad_vvd.checked 		= false;
			formObject.rad_dat.checked 		= false;
			formObject.txt_mrn.focus();
			break;
		case "rad_vvd":			// VVD 선택
			sheetObject1.removeAll();
			//vvd, pol, pod 조회
			formObject.txt_mrn.readOnly 	= true;

			formObject.txt_vvd.readOnly 	= false;
			formObject.txt_pol.readOnly 	= false;
			formObject.txt_pod.readOnly 	= false;
			formObject.date_from.readOnly 	= true;
			formObject.date_to.readOnly 	= true;

			formObject.txt_mrn.value 		= '';
			formObject.txt_vvd.value 		= '';
			formObject.txt_pol.value		= '';
			formObject.txt_pod.value		= '';
			formObject.date_from.value 		= '';
			formObject.date_to.value 		= '';

			formObject.txt_mrn.className    = "input2";
			formObject.txt_vvd.className    = "input1";
			formObject.txt_pol.className    = "input1";
			formObject.txt_pod.className    = "input1";
			formObject.date_from.className  = "input2";
			formObject.date_to.className    = "input2";

			formObject.rad_mrn.checked 		= false;
			formObject.rad_dat.checked 		= false;
			formObject.txt_vvd.focus();
			break;
		case "rad_dat":			// DATE 선택
			sheetObject1.removeAll();
			//날짜 조회
			formObject.txt_mrn.readOnly 	= true;
			formObject.txt_vvd.readOnly 	= true;
			formObject.txt_pol.readOnly 	= true;
			formObject.txt_pod.readOnly 	= true;
			formObject.date_from.readOnly 	= false;
			formObject.date_to.readOnly 	= false;

			formObject.txt_mrn.value 		= '';
			formObject.txt_vvd.value 		= '';
			formObject.txt_pol.value 		= '';
			formObject.txt_pod.value 		= '';

			formObject.txt_mrn.className    = "input2";
			formObject.txt_vvd.className    = "input2";
			formObject.txt_pol.className    = "input2";
			formObject.txt_pod.className    = "input2";
			formObject.date_from.className  = "input1";
			formObject.date_to.className    = "input1";

			formObject.rad_mrn.checked 		= false;
			formObject.rad_vvd.checked 		= false;

			//formObject.date_from.value = time.now();
			var now   = new Date();
			var year  = now.getFullYear();
			var month = now.getMonth() + 1;	// 1월=0,12월=11이므로 1더함
			var day   = now.getDate();
			if(month < 10) month = '0' + month;
			if(day < 10) day = '0' + day;
			var dateval = '' + year + '-' + month + '-' + day;
			formObject.date_from.value = dateval;
			formObject.date_to.value = dateval;
			formObject.date_from.focus();
			break;
		case "btn_calendar":		// Calendar 이벤트
			formObject.txt_mrn.readOnly 	= true;
			formObject.txt_vvd.readOnly 	= true;
			formObject.txt_pol.readOnly 	= true;
			formObject.txt_pod.readOnly 	= true;
			formObject.date_from.readOnly 	= false;
			formObject.date_to.readOnly 	= false;
			formObject.txt_mrn.className    = "input2";
			formObject.txt_vvd.className    = "input2";
			formObject.txt_pol.className    = "input2";
			formObject.txt_pod.className    = "input2";
			formObject.date_from.className  = "input1";
			formObject.date_to.className    = "input1";
			formObject.rad_mrn.checked = false;
			formObject.rad_vvd.checked = false;
			formObject.rad_dat.checked = true;

			var cal = new ComCalendarFromTo();
			cal.select(formObject.date_from, formObject.date_to, 'yyyy-MM-dd');
			break;
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
 * IBSheet Object를 배열로 등록
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
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){

		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet (sheetObjects[i] );

		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
}

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

			// 높이 설정
			style.height = 302;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo( 1, 1, 3, 100);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(12, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false)

			var HeadTitle = "|Seq|MRN|VVD|POL|POD|Office|User ID|B/L Count|AC|Date|Date";

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			var prefix = "";
			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,			daCenter,	false, prefix + "ibflag");
			InitDataProperty(0, cnt++ , dtDataSeq,   	40,   		daCenter,  	true,  prefix + "Seq");
			InitDataProperty(0, cnt++ , dtData,  	   170,  		daCenter,	false, prefix + "mrn",      false, "",	dfNone, 	0, true, true);
			InitDataProperty(0, cnt++ , dtData,  	   110,  		daCenter,	false, prefix + "vvd",      false, "",	dfNone, 	0, true, true);
			InitDataProperty(0, cnt++ , dtData,  	   100,  		daCenter,  	false, prefix + "pol",      false, "",	dfNone, 	0, true, true);
			InitDataProperty(0, cnt++ , dtData,  	  	80,   		daCenter,  	false, prefix + "pod",      false, "",	dfNone, 	0, true, true);
			InitDataProperty(0, cnt++ , dtData,  		75,   		daCenter,	false, prefix + "office",   false, "",	dfNone, 	0, true, true);
			InitDataProperty(0, cnt++ , dtData, 		75,   		daCenter,  	false, prefix + "userid",   false, "",	dfNone, 	0, true, true);
			InitDataProperty(0, cnt++ , dtData,  		90,   		daRight,  	false, prefix + "blcount",  false, "",	dfNone, 	0, true, true);
			InitDataProperty(0, cnt++ , dtData,  		60,   		daCenter,	false, prefix + "ac",       false, "",	dfNone, 	0, true, true);
			InitDataProperty(0, cnt++ , dtData,  		90,   		daCenter,  	false, prefix + "dt",       false, "",	dfDateYmd,	0, true, true);
			InitDataProperty(0, cnt++ , dtData,  		80,   		daCenter,  	false, prefix + "dt2",      false, "",	dfNone,		0, true, true);

			CountPosition = 0;
		}
		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	
	var formObject = document.form;

	switch(sAction) {
	case IBSEARCH:      //조회
		formObj.f_cmd.value = SEARCH;
		var ret = ComGetPrefixParam("sheet1_");
		if(validateForm(sheetObj, formObject,sAction)) {
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			sheetObj.DoSearch("ESM_BKG_0215GS.do", FormQueryString(formObj));
			ComOpenWait(false);
		}
		break;
	case IBDOWNEXCEL:      // 엑셀 다운로드
		sheetObj.SpeedDown2Excel(1);
		break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction)
{
	if(formObj.rad_mrn.checked)
	{
		if(formObj.txt_mrn.value == '')
		{
			ComShowCodeMessage("BKG00888", "MRN");
			formObj.txt_mrn.focus();
			return false;
		}
	}
	else if(formObj.rad_vvd.checked)
	{
		if(formObj.txt_vvd.value == '')
		{
			ComShowCodeMessage("BKG00888", "VVD");
			formObj.txt_vvd.focus();
			return false;
		}

		if(formObj.txt_pol.value == '' && formObj.txt_pod.value == '')
		{
			ComShowCodeMessage("BKG00888", "POL or POD");
			formObj.txt_pol.focus();
			return false;
		}
	}
	else if(formObj.rad_dat.checked)
	{
		if(formObj.date_from.value == '')
		{
			ComShowCodeMessage("BKG00888", "Date");
			formObj.date_from.focus();
			return false;
		}
		if(formObj.date_to.value == '')
		{
			ComShowCodeMessage("BKG00888", "Date");
			formObj.date_to.focus();
			return false;
		}

		if(formObj.date_from.value.length == 10)
		{
			if(formObj.date_to.value.length == 10)
			{
				if(!ComIsDate(formObj.date_from.value))
				{
					ComShowCodeMessage("COM12132");
					formObj.date_from.focus();
					return false;
				}
				else if(!ComIsDate(formObj.date_to.value))
				{
					ComShowCodeMessage("COM12132");
					formObj.date_to.focus();
					return false;
				}

				if(ComChkPeriod(formObj.date_from.value, formObj.date_to.value) < 1)
				{
					ComShowCodeMessage("COM132002");
					formObj.date_from.focus();
					return false;
				}

				var days = ComGetDaysBetween(formObj.date_from.value, formObj.date_to.value);
				if(days > 7)
				{
					ComShowCodeMessage("COM132001", days, "7");
					formObj.date_from.focus();
					return false;
				}
			}
			else
			{
				ComShowCodeMessage("COM12132");
				formObj.date_to.focus();
				return false;
			}
		}
		else
		{
			ComShowCodeMessage("COM12132");
			formObj.date_from.focus();
			return false;
		}
	}

	return true;
}
