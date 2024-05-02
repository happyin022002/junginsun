/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_CGM_2001.js
 *@FileTitle : M.G.Set Model Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.26
 *@LastModifier : 박의수
 *@LastVersion : 1.0
 * 2009.05.26 박의수
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
 * @class ees_cgm_2001 : ees_cgm_2001 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ees_cgm_2001() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업  */

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var confirm_eq_spec_no = ""; // chungpa 20090923 combobox typing시 이전데이터 선택되는 bug해결용.  

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject  = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	
	/*******************************************************/
	var formObject = document.form;

	try {
	var srcName = window.event.srcElement.getAttribute("name");
	var formObj = document.form;

		switch (srcName) {

		case "Retrieve":
  	        with(document.eq_spec_no) { // chungpa 20090728 IBCOMBO new클릭시 편집가능설정
  	        	Style = 1; //편집불가능설정
  	        	//UseEdit = false;
 	  	    }			
			if((formObj.eq_spec_no.text == null) || (formObj.eq_spec_no.text == "")) {
				ComShowCodeMessage("CGM10004", "Model No")
				return;
			}
			
			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			formObj.page_status.value = "R";
			break;

		case "New":
			//document.eq_spec_no.Index = -1; // chungpa 20090804 new click 시 콤보 데이터 재클릭이벤트 안먹는 문제점.
			formObj.page_status.value = "I";
			initControl();
			
  	        with(document.eq_spec_no) { // chungpa 20090728 IBCOMBO new클릭시 편집가능설정
  	        	Style = 0; //편집가능설정
  	        	//UseEdit = true;
 	  	    }			
			break;

		case "Save":
			
			if(formObj.eq_spec_no.text == null || formObj.eq_spec_no.text == ""){
				ComShowCodeMessage("CGM10004", "Model No");
				return;
			}else //중복체크
			{
				if(sheetObject1.RowStatus(1)=="I")
				{
					formObj.f_cmd.value = SEARCH01;
					formObj.eq_spec_no_dup.value = formObj.eq_spec_no.text;
					var sXml = sheetObject1.GetSearchXml("EES_CGM_2001GS.do", FormQueryString(formObj));
					// 데이터 건수
					var dataCount = ComGetTotalRows(sXml);
					if(dataCount > 0){
						ComShowCodeMessage('CGM20011',formObj.eq_spec_no.text);
						formObj.eq_spec_no.text = '';
						return;
					}
				}
			}
			if(formObj.vndr_seq.text == null || formObj.vndr_seq.text == ""){
				ComShowCodeMessage("CGM10004", "Maker");
				return;
			}
			if(formObj.eq_tpsz_cd.text == null || formObj.eq_tpsz_cd.text == ""){
				ComShowCodeMessage("CGM10004", "Type");
				return;
			}
			
			
			doActionIBSheet(sheetObject1,formObject,IBSAVE);
  	        with(document.eq_spec_no) { // chungpa 20090728 IBCOMBO new클릭시 편집가능설정
  	        	Style = 1; //편집불가능설정
  	        	//UseEdit = false;
 	  	    }
			
			break;

		case "Delete":
		
			// 1. M.G.SET NO 가 없어야 삭제할 수 있으므 MGSET NO SHEET에 데이타가 있는지 검사한다.
			// (데이타가 존재하면 삭제 불가 메세지)
			if(sheetObject.rowCount != 0){
				ComShowCodeMessage("CGM10033");
				return;
			}
			
			formObj.f_cmd.value = SEARCH01;
     		var sXml = sheetObject1.GetSearchXml("EES_CGM_1002GS.do", FormQueryString(formObj));
     		// 데이터 건수
  	        var dataCount = ComGetTotalRows(sXml);
  	        if(dataCount > 0){
  	        	// a.You cannot delete specification number with chassis. Please contact system manager.
  	        	ComShowCodeMessage('CGM10033');
  	        	return;
  	        }

			// b.Are you sure that you want to delete this specification number? 
			if ( ComShowCodeConfirm("CGM10051") ,'delete specification number' ){  
				// 삭제할수 있도록 상태값을 변경합니다
				sheetObject1.RowStatus(1) = "D";
				doActionIBSheet(sheetObject1,formObject, IBDELETE);
			}else
			{
				return;
			}
			
  	        with(document.eq_spec_no) { // chungpa 20090728 IBCOMBO new클릭시 편집가능설정
  	        	Style = 1; //편집불가능설정
  	        	//UseEdit = false;
 	  	    }	
			break;

		} // end switch
		tRoleApply();
  }catch(e) {
    if( e == "[object Error]") {
     ComShowMessage(OBJECT_ERROR);
    } else {
     ComShowMessage(e);
    }
  }
}


/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {

	sheetObjects[sheetCnt++] = sheet_obj;
}


/**
 * IBMultiCombo Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setComboObjects(combo_obj) {

	comboObjects[comboCnt++] = combo_obj;
}


/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
    for(var i=0;i<sheetObjects.length;i++){
        // 시작 환경 설정 함수 이름 변경
    	ComConfigSheet (sheetObjects[i] );
    	initSheet(sheetObjects[i],i+1);
    	// 마지막 환경 설정 함수 추가
    	ComEndConfigSheet(sheetObjects[i]);
    }
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
  
 	var sheetObject  = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	var formObj = document.form;
	
	axon_event.addListenerForm  ("beforedeactivate",	"obj_deactivate",	form,	"rdoCity");
	axon_event.addListenerFormat("beforeactivate",		"obj_activate",		form,	"mgst_fuel_capa");
	axon_event.addListener      ("keypress",			"obj_onkeypress",	"mgst_fuel_capa", "chss_tare_wgt", "chss_tare_wgtlb");
	axon_event.addListener      ("click",				"obj_onclick",		"mgst_vltg_capa", "chss_tare_wgt", "chss_tare_wgtlb");
	axon_event.addListener      ("focusout",			"obj_focusout",		"mgst_fuel_capa", "chss_tare_wgt", "chss_tare_wgtlb");
	axon_event.addListener      ("blur",				"obj_blur",			"eq_spec_no", "eq_tpsz_cd");

	comboCnt = 0;

	//IBMULTICOMBO RESET
	comboObjects[comboCnt++] = document.eq_spec_no;
	comboObjects[comboCnt++] = document.vndr_seq;
	comboObjects[comboCnt++] = document.eq_tpsz_cd;
 	
	for(var i=0; i< comboCnt; i++)
 	{
 		initCombo(comboObjects[i]);
 	}
	
	/*
    // COMBO RESET
	doActionIBSheet(sheetObject1, document.form, IBSEARCH_ASYNC01);
	doActionIBSheet(sheetObject1, document.form, IBSEARCH_ASYNC03);
	doActionIBSheet(sheetObject1, document.form, IBSEARCH_ASYNC02);
	*/
   	doActionIBSheet(sheetObjects[0], document.form, IBRESET);
   	
	// 화면 로딩 후 바로 신규 데이타 입력시 발생하는 에러를 방지하기 위하여 신규 행 생성 및 초기값 세팅
	initControl();
	tRoleApply();
    sheetObj.WaitImageVisible = true; 
 }
 
 /**
  * Form의 Conrol 를 초기화 시킨다.
  */
 function initControl(){
	// Form 객체 선언
	var formObj = document.form;
	var sheetObject  = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	
	sheetObject.RemoveAll();
	sheetObject1.RemoveAll();
	
	formObj.eq_spec_no.Index2 = -1;
	
	var row = sheetObject1.DataInsert(0);
	sheetObject1.CellValue(1, "eq_knd_cd") = "G";
	sheetObject1.CellValue(1, "mgst_vltg_capa") = "220";
	sheetObject1.CellValue(1, "eq_tpsz_cd") = "UMG";
	formObj.vndr_seq.Index2 = -1;
	formObj.eq_tpsz_cd.Code = "UMG";
	formObj.mgst_fuel_capa.value = "";
	formObj.mgst_vltg_capa[0].checked = true;
	sheetObject1.RowStatus(1)="I";
	

 }
 
/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	switch (sheetNo) {
	case 1: // t1sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 200;
			
			// 전체 너비 설정
			SheetWidth = 200;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(3, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			var HeadTitle = "Seq.|Range|Q'ty";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0,	cnt++,	dtData,			50,		daCenter,	true,	"desc1",	false,	"",	dfNone);
			InitDataProperty(0,	cnt++,	dtData,			250,	daCenter,	true,	"desc2",	false,	"",	dfNone);
			InitDataProperty(0,	cnt++,	dtData,			80,		daCenter,	true,	"desc3",	false,	"",	dfNone);
		}
		break;

	case 2: // t1sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 100;
			
			// 전체 너비 설정
			SheetWidth = 100;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(8, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			var HeadTitle = "ibflag|eq_spec_no|vndr_seq|eq_knd_cd|eq_tpsz_cd|mgst_vltg_capa|mgst_fuel_capa|chss_tare_wgt";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0,	cnt++,	dtStatus,	50,		daCenter,	true,	"ibflag");
			InitDataProperty(0,	cnt++,	dtData,		200,	daCenter,	true,	"eq_spec_no",		false,	"",	dfNone);
			InitDataProperty(0,	cnt++,	dtData,		150,	daCenter,	true,	"vndr_seq",			false,	"",	dfNone);
			InitDataProperty(0,	cnt++,	dtData,		150,	daCenter,	true,	"eq_knd_cd",		false,	"",	dfNone);
			InitDataProperty(0,	cnt++,	dtData,		150,	daCenter,	true,	"eq_tpsz_cd",		false,	"",	dfNone);

			InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"mgst_vltg_capa",	false,	"",	dfNone);
			InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"mgst_fuel_capa",	false,	"",	dfNone);
			InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"chss_tare_wgt",	false,	"",	dfNone);
		}
		break;
	}
}


/**
 * SHEET 관련 프로세스 처리
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	var formObj = document.form;
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case IBSEARCH: // 조회
		sheetObject1.RemoveAll();
		formObj.f_cmd.value = SEARCH;
		sheetObject1.DoSearch("EES_CGM_2001GS.do",FormQueryString(formObj));

		// 조회된 값 콤보 매칭
		formObj.vndr_seq.Text2    = ''; //chungpa 20100222 lessor display null bug
		formObj.vndr_seq.Code     = sheetObj.CellValue(1, "vndr_seq");
		formObj.eq_tpsz_cd.Code   = sheetObj.CellValue(1, "eq_tpsz_cd");
		
		// Weight 값 입력
		formObj.chss_tare_wgt.value = ComAddComma(sheetObj.CellValue(1, "chss_tare_wgt"));
		formObj.chss_tare_wgtlb.value = ComAddComma(chgKgLbs(sheetObj.CellValue(1, "chss_tare_wgt")));

		// 라디오버튼 값 셋팅
		if(sheetObject1.CellValue(1, "mgst_vltg_capa") == "220") {
			formObj.mgst_vltg_capa[0].checked = true;
		} else {
			formObj.mgst_vltg_capa[1].checked = true;
		}
		break;

	case IBSAVE: // 저장
		sheetObj.WaitImageVisible=false;
		ComOpenWait(true);		
		formObj.f_cmd.value = MULTI;
		
		//ComDebug("chungpa2>>"+ sheetObj.RowStatus(1));
		//ComDebug("chungpa2>>"+ sheetObject1.RowStatus(1));
		
		if(sheetObj.DoSave("EES_CGM_2001GS.do", FormQueryString(formObj))){
			// 2. 저장된 값을 콤보박스에 추가하기 위하여 새로 고침
			doActionIBSheet(sheetObject1, formObj, IBSEARCH_ASYNC01);
			// 3. 그리드에 있는 값으로 콤보박스에 해당값을  셋팅
			formObj.eq_spec_no.text = sheetObject1.CellValue(1, "eq_spec_no");
			ComShowCodeMessage("CGM00003");
		}else{
			
		}
		ComOpenWait(false);
		
		break;

	case IBDELETE: // 삭제
		sheetObj.WaitImageVisible=false;
		ComOpenWait(true);		
		formObj.f_cmd.value = REMOVE;
		if(sheetObj.DoSave("EES_CGM_2001GS.do", FormQueryString(formObj))){
			// 콤보박스에서 목록을 제거해주기 위하여 새로 고침을 합니다.
			doActionIBSheet(sheetObject1, formObj, IBSEARCH_ASYNC01);
			loadPage();
		} else {
			sheetObject1.RowStatus(1) = "U";
		}
		
		ComOpenWait(false);			
		break;
		
    // COMBO - MODEL NO
	case IBSEARCH_ASYNC01:
		formObj.f_cmd.value = SEARCH03;
		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
		//ComDebug(sXml);
		var sStr = ComGetEtcData(sXml,"comboList");
		var arrStr = sStr.split("@");

		MakeComboObject1(formObj.eq_spec_no, arrStr, 0);
		break;

    // COMBO - MAKER
	case IBSEARCH_ASYNC03:
   		
		formObj.f_cmd.value = SEARCH05;
		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
		var sStr = ComGetEtcData(sXml,"comboList");
		var arrStr = sStr.split("@");

		MakeComboObjectManufacture(formObj.vndr_seq, arrStr, 1);
		break;

    // COMBO - TYPE/SIZE
	case IBSEARCH_ASYNC02:
		
		formObj.f_cmd.value = SEARCH04;
		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
		var sStr = ComGetEtcData(sXml,"comboList");
		var arrStr = sStr.split("@");

		MakeComboObject1(formObj.eq_tpsz_cd, arrStr, 0);
		break;

	// M.G.SET NO 데이타 조회
    case SEARCH06:
    	//ComDebug("chungpa3--1>>"+ sheetObject1.RowStatus(1)+" :" + formObj.eq_spec_no.Text);
        sheetObj.RemoveAll();
        //ComDebug("chungpa3>>"+ sheetObject1.RowStatus(1)+" :" + formObj.eq_spec_no.Text);
        formObj.f_cmd.value = SEARCH06;
        
        sheetObject.DoSearch("CgmCodeMgtGS.do",FormQueryString(formObj));
        gridList = ComGetEtcData(sXml, "gridList");

        if(gridList < 1) {
            ComShowCodeMessage("CGM10003","Location ");
        }
        sheetObject1.RemoveAll();
		formObj.f_cmd.value = SEARCH;
		sheetObject1.DoSearch("EES_CGM_2001GS.do",FormQueryString(formObj));

		if(sheetObject1.rowCount > 0) //조회된 데이터가 있다면  new상태가 아니므로 편집불가능상태임.
		{
		      with(document.eq_spec_no) { // chungpa 20090728 IBCOMBO new클릭시 편집가능설정
		        	Style = 1; //편집불가능설정
		        	//UseEdit = false;
		 	  }	
		      
		      //ComDebug("chungpa4-1>>"+ sheetObject1.RowStatus(1));
		      formObj.page_status.value == "R"	 //Read모드로 초기화
		}else
		{
			//ComDebug("chungpa4-2>>"+ sheetObject1.RowStatus(1));
			if(formObj.page_status.value == "I") //Insert 유지
			{
				sheetObject1.removeAll();
				var row = sheetObject1.DataInsert(0);
				sheetObject1.CellValue(1, "eq_knd_cd") = "G";
				if(formObj.mgst_vltg_capa[0].checked == true) {
					sheetObject1.CellValue(1, "mgst_vltg_capa") = "220"; 
				} else {
					sheetObject1.CellValue(1, "mgst_vltg_capa") = "440";
				}
				sheetObject1.RowStatus(1) = "I";
				//ComDebug("chungpa4-3>>"+ sheetObject1.RowStatus(1));
				
			}
		}
		formObj.vndr_seq.Text2    = ''; //chungpa 20100222 lessor display null bug
		formObj.vndr_seq.Code     = sheetObject1.CellValue(1, "vndr_seq");   // 조회된 값 MAKER 콤보 매핑
		formObj.eq_tpsz_cd.Code   = sheetObject1.CellValue(1, "eq_tpsz_cd"); // 조회된 값 TYPE  콤보 매핑
		
		// Weight 값 입력
		formObj.chss_tare_wgt.value = ComAddComma(sheetObject1.CellValue(1, "chss_tare_wgt"));
		formObj.chss_tare_wgtlb.value = ComAddComma(chgKgLbs(sheetObject1.CellValue(1, "chss_tare_wgt")));

		if(sheetObject1.CellValue(1, "mgst_vltg_capa") == "220") { // 라디오버튼 값
			formObj.mgst_vltg_capa[0].checked = true;
		} else {
			formObj.mgst_vltg_capa[1].checked = true;
		}

		formObj.mgst_fuel_capa.value= sheetObject1.CellValue(1, "mgst_fuel_capa"); // 연료 적재량
		//ComDebug("chungpa4>>"+ sheetObject1.RowStatus(1));
        break;

	case IBRESET:
		var idx = 0
		var sXml2 = document.form2.sXml.value;
		var arrXml = sXml2.split("|$$|");
		
   		// CGM_EQ_SPEC 테이블에서 Spec No 리스트
		if ( arrXml[idx] == null ) {return;}
		var vArrayListData = ComCgmXml2ListMap(arrXml[idx]);
	    var arrStr1 = new Array();
		for ( var i = 0; i < vArrayListData.length; i++) {
		    vListData = vArrayListData[i];
		    arrStr1[i] = vListData["code1"] + "|" + vListData["desc1"];
		}
		MakeComboObject1(formObj.eq_spec_no, arrStr1, 0);
		idx++;        		
		
		//Type/Size
		if ( arrXml[idx] == null ) {return;}
		var vArrayListData2 = ComCgmXml2ListMap(arrXml[idx]);
	    var arrStr2 = new Array();
		for ( var i = 0; i < vArrayListData2.length; i++) {
		    vListData = vArrayListData2[i];
		    arrStr2[i] = vListData["code1"] + "|" + vListData["desc1"];
		}
		MakeComboObject1(formObj.eq_tpsz_cd, arrStr2, 0);
  		idx++;
  		
		// Manufacturer
		if ( arrXml[idx] == null ) {return;}
		var vArrayListData3 = ComCgmXml2ListMap(arrXml[idx]);
	    var arrStr3 = new Array();
		for ( var i = 0; i < vArrayListData3.length; i++) {
		    vListData = vArrayListData3[i];
		    arrStr3[i] = vListData["code1"] + "|" + vListData["desc1"];
		}
		MakeComboObjectManufacture(formObj.vndr_seq, arrStr3, 1);
  		idx++;

		break;        
	}
}


/**
 * IBMULTI COMBO
 */
function initCombo(comboObj) {
    switch(comboObj.id) {
    	// MODEL NO
    	case "eq_spec_no":
    		with(comboObj){
    			DropHeight = 220;
    			MultiSelect = false;
    			//MaxSelect = 1;
    			
	        	ValidChar(1,3);         // 영어 사용, 숫자포함, 특수문자 포함.
	            IMEMode = 0;            // 영문
	            MaxLength = 20;         // 20자까지 입력
    		}
    		break;
    	// MAKER
	    case "vndr_seq":
	        with(comboObj) {
	        	DropHeight = 120;
	        	MultiSelect = false;
	        	//MaxSelect = 1;
	        }
	        break;
	    // M.G.SET TYPE/SIZE
	    case "eq_tpsz_cd":
	    	with(comboObj){
	        	DropHeight = 100;
	        	MultiSelect = false;
	        	//MaxSelect = 1;
	    	}
	    	break;
	}
}


/**
 * 콤보 오브젝트 생성
 */
function MakeComboObject1(cmbObj, arrStr, col) {
	cmbObj.RemoveAll();
	for (var i=0; i<arrStr.length; i++) {
		var arrCode = arrStr[i].split("|");
		cmbObj.InsertItem(i, arrCode[1], arrCode[0]);
	}
}
 
 /**
  * 콤보 오브젝트 생성
  */
 function MakeComboObjectManufacture(cmbObj, arrStr, col) {
	cmbObj.RemoveAll();
	cmbObj.InsertItem(0, "", "");
	cmbObj.InsertItem(1, "Thermo King Corporation","113272"); // chungpa 20100226 초주의! 하드코딩 DATA 113272
	for (var i=0; i<arrStr.length; i++) {
		var arrCode = arrStr[i].split("|");
		cmbObj.InsertItem(i+2, arrCode[1], arrCode[0]);
	}
	cmbObj.Index2 = "" ;	  
 }
 
 /**
  * 콤보 오브젝트 생성 + '' for 0 Index.
  */
 function MakeComboObject2(cmbObj, arrStr, col) {
 	cmbObj.RemoveAll();
 	cmbObj.InsertItem(0, '', '');
 	for (var i=1; i<=arrStr.length; i++) {
 		var arrCode = arrStr[i-1].split("|");
 		cmbObj.InsertItem(i, arrCode[1], arrCode[0]);
 	}
 }
 
/** 
 * MAKER 변경시 그리드로 코드값 전송
 */
function vndr_seq_OnChange(comboObj, Index_Code, Text){
	var sheetObject1 = sheetObjects[1];
    
	sheetObject1.CellValue(1, "vndr_seq") = Index_Code;
}


/** 
 * TYPE 변경시 그리드로 값 전송
 */
 function eq_tpsz_cd_OnChange(comboObj, Index_Code, Text){
 	var sheetObject1 = sheetObjects[1];
 	var comboValuec  = comboObj.GetText(Index_Code,0);

 	sheetObject1.CellValue(1, "eq_tpsz_cd") = comboValuec;
 }
  
/**
 * IBTAB OBJECT를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++] = tab_obj;
}


/**
 * TAB 기본 설정 탭의 항목을 설정한다.
 */
function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {
		}
		break;
	}
}


/**
 * TAB 클릭시 이벤트 관련 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnChange(tabObj, nItem) {

	var objs = document.all.item("tabLayer");

	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";

	// 요기가 중요 *********************************************************
	objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
	// *******************************************************************
	beforetab = nItem;
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		// if (!isNumber(formObj.iPage)) {
		// return false;
		// }
	}
	return true;
}


/**
 * SPECIFICATION NO FOCUS 
 * 그리드 바깥에 있는 콤보 접근 방법
 */
function obj_blur(comboObj, Index_Code, Text){
	
	var formObj      = document.form;
	var sheetObject1 = sheetObjects[1];
	
	sheetObject1.CellValue(1, "eq_spec_no") = formObj.eq_spec_no.text;
	sheetObject1.CellValue(1, "eq_tpsz_cd") = formObj.eq_tpsz_cd.text;
}


/** 
 * MODEL NO 변경시 그리드로 값 전송
 */
function eq_spec_no_OnChange(comboObj, Index_Code, Text){
	var formObj      = document.form;
	var sheetObj     = sheetObjects[0];
	var sheetObj1    = sheetObjects[1];
	
	//ComDebug("chungpa1-0>>"+ formObj.eq_spec_no.Text + " :"+ formObj.eq_spec_no.Code);
	if(Text.length > 20) // chungpa 20090803 MAXLEN cannot be over more than 20 
	{
		ComShowCodeMessage('CGM10019','eq_spec_no(20)');
		//document.eq_spec_no.Text2 = Text.substring(0,19); // chungpa text로 초기화가 안됨
		document.eq_spec_no.Text2 = '';	// 명백한 오류상황이므로 20자가 넘을 경우 빈칸으로 초기화함.
		sheetObj1.CellValue(1, "eq_spec_no") = '';
		return;
	}

	//var comboValuea  = comboObj.GetText(Index_Code,0);
	confirm_eq_spec_no  = formObj.eq_spec_no.Text;// comboObj.GetText(Index_Code,0);
	sheetObj1.CellValue2(1, "eq_spec_no") = confirm_eq_spec_no;
	//ComDebug("chungpa comboV1:"+ confirm_eq_spec_no);

	// M.G.Set No 조회
	doActionIBSheet(sheetObj, formObj, SEARCH06);
	
	//ComDebug("chungpa1-1>>"+ sheetObj1.RowStatus(1));
	//sheetObj1.CellValue(1, "ibflag") = "U";
}


/**
 * HTML OBJECT의 이벤트 처리
 */
function obj_focusout() {
	var sheetObject1 = sheetObjects[1];
	var formObj = document.form;
	var obj = event.srcElement;

    ComChkObjValid(event.srcElement);

	switch(obj.name){
        case "mgst_fuel_capa":

        	//연료 적재량 변경 값에서 콤마를 제거한 후 그리드로 전송
    		sheetObject1.CellValue(1, "mgst_fuel_capa") = formObj.mgst_fuel_capa.value.replaceStr(",");
        	break;
        	
        case "chss_tare_wgt":
    		if(ComTrim(obj.value) != "" ){
        		formObj.chss_tare_wgtlb.value  = ComAddComma(chgKgLbs(obj.value.replaceStr(",")));
        	}
    		sheetObject1.CellValue(1, "chss_tare_wgt") = formObj.chss_tare_wgt.value.replaceStr(",");
        	break;

        case "chss_tare_wgtlb":
        	if(ComTrim(obj.value) != ""){
        		formObj.chss_tare_wgt.value  = ComAddComma(chgLbKgs(obj.value.replaceStr(",")));
        	}
        	sheetObject1.CellValue(1, "chss_tare_wgt") = formObj.chss_tare_wgt.value.replaceStr(",");
        	break;
    }
}


/**
 * 사용전압 값 변경시 그리드로 전송
 * 
 */
function obj_onclick(radioObj){
	
	var formObj      = document.form;
	var sheetObject1 = sheetObjects[1];

	if(formObj.mgst_vltg_capa[0].checked == true) {
		sheetObject1.CellValue(1, "mgst_vltg_capa") = "220"; 
	} else {
		sheetObject1.CellValue(1, "mgst_vltg_capa") = "440";
	}
}


/**
 * HTML OBJECT의 이벤트 처리
 */
function obj_onkeypress() {
	ComKeyOnlyNumber(event.srcElement);
}


/**
 * AXON 이벤트 처리2. 이벤트처리함수
 */
function obj_deactivate(){
    ComChkObjValid(event.srcElement);
}


/**
 * AXON 이벤트 처리2. 이벤트처리함수
 */
function obj_activate(){
    ComClearSeparator(event.srcElement);
    ComIsNumber(event.srcElement, ",");
}

 
/**
 * eq_spec_no 로드 후 기본적으로 eq_spec_no는 편집이 불가능함.
 * @author 조재성 20090803 2001 bug fix
 * @param sheetObj
 * @return 없슴
 */
function eq_spec_no_OnLoadFinish(sheetObj) {
      with(document.eq_spec_no) { // chungpa 20090728 IBCOMBO new클릭시 편집가능설정
        	Style = 1; //편집불가능설정
        	//UseEdit = false;
 	    }	
}

 /**
 * 기능(ex:btn_save)에 권한(trole) 적용  <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2010.03.05
 */     
 function tRoleApply() {
	  var formObj = document.form;
	  if(formObj.trole.value == "Authenticated")
	  {

	  }else
	  {
		  ComBtnDisable("Save");
		  ComBtnDisable("Delete");
	  }
 } 
 
 /**
  * 단위환산 : Kg >> Lbs
  * 공식 : Kg = Lbs * 0.45359
  */
 function chgKgLbs(kgs){
 	return ComRound(kgs * 2.2046, 0);
 }
 /**
  * 단위환산 : Lbs >> Kg
  * 공식 : Lbs = Kg * 2.2046
  */
 function chgLbKgs(lbs){
 	return ComRound(lbs * 0.45359, 0);
 }
 
/* 개발자 작업 끝 */
