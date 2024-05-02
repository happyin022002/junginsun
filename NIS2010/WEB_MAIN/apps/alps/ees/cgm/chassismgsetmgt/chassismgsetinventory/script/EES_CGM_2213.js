/*=========================================================
 *Copyright(c) 20114 CyberLogitec
 *@FileName : EES_CGM_2213.js
 *@FileTitle : Status Creation for Bare MG.Set Reposition
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.10.14
 *@LastModifier : 김승만
 *@LastVersion : 1.0
 * 2014.10.14 김승만
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
 * @class ees_cgm_2083 : ees_cgm_2083 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ees_cgm_2213() {
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

var comboObjects = new Array();
var comboCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	//var sheetObject2 = sheetObjects[1];

	/** *****************************************************/
	var formObject = document.form;

	//스크립트 에러 위치를 확인하기 위해 주석처리
	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
	
			case "btn_retrieve":
				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
				break;
	
			case "btn_Save":
				doActionIBSheet(sheetObject1, formObject, MULTI01);
				break;
			case "btn_new":
				formObject.reset();
				initControl();
				break;				
	
			case "btn_add":
				sheetObject1.DataInsert();
				var rcount = sheetObject1.SelectRow;

				break;	
				
            case "btn_rowcopy":
                doActionIBSheet(sheetObject1,formObject,IBCOPYROW);
                break;
                
			case "btn_downexcel":
 				sheetObject1.Down2Excel(0);
 				break;             
                
			case "btn_delete":
				doActionIBSheet(sheetObject1,document.form,REMOVE);
				break;
				
			case "btns_calendarto":
		    		var cal = new ComCalendarFromTo();
		            cal.select(formObject.fromdate,  formObject.todate,  'yyyy-MM-dd');
		    		break;			    		

          	case "toloc_btn":

            	var display 	  = "0,1,1,1,1,1";
            	var targetObjList = "loc_dpth_cd:tostatus|loc_cd:tolocation";
				var param 		  = "?depth=4&classId=COM_ENS_0O1";

				    ComOpenPopupWithTarget('/hanjin/COM_ENS_0O1.do' + param, 400, 470, targetObjList, display);
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
		initControl(sheetObjects[0]);
	}
}

function initControl(sheetObj){
	
  	// Form 객체 선언
  	 var formObj = document.form;
  	 var sheetObject1 = sheetObjects[0];
      // axon event 등록
  	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', formObj);
  	
  	//Form Object 초기화
  	with (formObj) {
  		tolocation.value = "";
  	}

	// Sheet Object 초기화
	sheetObject1.RemoveAll();
	
  }

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	switch (sheetNo) {
	case 1: // sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 400;
			
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 6, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(19, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			// 헤더에서 전체 선택 기능을 해제 세번째 파라메타를 false 로 변경
			InitHeadMode(true, true, true, true, true,true);  
			var HeadTitle = "|Seq||M.G.Set No|BMP/BMT|Type|MVMT|Chassis No|Container No|Staying Day|S/P Name|Mode|Return Yard|BMP/BMT Date|Update Date|Update User|Remarks";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,         SAVENAME,            KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

			InitDataProperty(0, cnt++ , dtHiddenStatus, 40, daCenter,   false,      "ibflag");
            InitDataProperty(0, cnt++,  dtDataSeq,      40, daCenter,   true,      "sts_seq"); 
            InitDataProperty(0, cnt++ , dtCheckBox,     30, daCenter,   false,     "del_chk",	        false, 		"", 	 dfNone,    	0,  	true,   true);
            InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	false,     "mgst_no",			false,      "",      dfNone,	    0,		false,	true,  11);
            InitDataProperty(0, cnt++ , dtCombo,		80,	daCenter,	false,     "mgst_bare_sts_cd",	false,      "",      dfNone,		0,		false,	true);
            //InitDataProperty(0, cnt++ , dtCheckBox,		50,	daCenter,	false,     "mgst_bare_bmt_flg",	false,      "",      dfNone);
            
            InitDataProperty(0, cnt++ , dtData,			40,	daCenter,	false,     "eq_tpsz_cd",		false,      "",      dfNone,		0,		false,	false,   3);
            InitDataProperty(0, cnt++ , dtData,			40,	daCenter,	false,     "mvmt",				false,      "",      dfNone,		0,		false,	false,	2);
            InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	false,     "chss_no",			false,      "",      dfNone,	    0,		false,	false,	11);
            InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	false,     "cntr_no",			false,      "",      dfNone,	    0,		false,	false,	14);
            InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	false,     "lsdays",			false,      "",      dfNone,		0,		false,	false,	40);
            
            InitDataProperty(0, cnt++ , dtPopup,		160,daLeft,		false,     "vndr_lgl_eng_nm",	true,    	"",      dfNone,		0,		true,	true);
            InitDataProperty(0, cnt++ , dtCombo,		80,	daCenter,	false,     "eq_trsp_mod_cd",	false,    	"",      dfNone,		0,		true,	true);
//            InitDataProperty(0, cnt++ , dtPopupEdit,	80,	daLeft,		false,     "org_yd_cd",			true,    	"",      dfNone,		0,		true,	true,7);
            InitDataProperty(0, cnt++ , dtPopupEdit,	90,	daCenter,	false,     "rtn_yd_cd",			true,    	"",      dfNone,		0,		true,	true,7);
            InitDataProperty(0, cnt++ , dtData,			100,daCenter,	false,     "mgst_bare_evnt_dt",	false,    	"",      dfUserFormat,	0,		true,	true);
            InitDataProperty(0, cnt++ , dtData,			80,daCenter,	false,     "upd_dt",    		false,    	"",      dfUserFormat,	0,		false,	false);
            InitDataProperty(0, cnt++ , dtData,			80,daLeft,		false,     "upd_usr_id",		false,    	"",      dfNone,		0,		false,	false);
            InitDataProperty(0, cnt++ , dtData,			180,daLeft,		false,     "bare_mgst_rmk",		false,    	"",      dfNone,		0,		true,	true);
           
            InitDataProperty(0, cnt++ , dtHidden,       85, daCenter,  	true,      "vndr_seq",       	false,  	"", 	 dfNone,        0, 		true,    true);
            InitDataProperty(0, cnt++ , dtHidden,       85, daCenter,  	true,      "mgst_bare_sts_seq", false,  	"", 	 dfNone,        0, 		true,    true);
            
            InitDataCombo(0, "mgst_bare_sts_cd", "BMP|BMT", 	"BMP|BMT");            
            InitDataCombo(0, "eq_trsp_mod_cd",   "Truck|Rail", 	"T|R");
            
			InitDataValid(0, "mgst_no",   vtEngUpOther, "1234567890"); // 영문 대문자와 숫자만 입력
			InitDataValid(0, "chss_no",   vtEngUpOther, "1234567890"); // 영문 대문자와 숫자만 입력            
			InitDataValid(0, "cntr_no",   vtEngUpOther, "1234567890"); // 영문 대문자와 숫자만 입력    
			InitDataValid(0, "rtn_yd_cd", vtEngUpOther, "1234567890"); // 영문 대문자와 숫자만 입력   
			
			InitUserFormat(0, "mgst_bare_evnt_dt", "####-##-##", "-");
			InitUserFormat(0, "upd_dt",            "####-##-##", "-");

		}
		//값 입력 조건 제한

		break;
	}
}
function sheet1_OnLoadFinish(sheetObj) {
	sheetObj.WaitImageVisible = false;

}
// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
	   	
	case IBSEARCH:
		
		if(validateForm(sheetObj,formObj,sAction)){
			sheetObjects[0].RemoveAll();
			formObj.f_cmd.value = SEARCH;
			var sParam = FormQueryString(formObj);
			var sXml = sheetObj.GetSearchXml("EES_CGM_2213GS.do", sParam);
			sheetObj.loadSearchXml(sXml);
		}
		break;
		
	case IBCOPYROW:

		if (sheetObj.RowCount == 0) {
			ComShowCodeMessage("CGM20087");
			return false;
		}
		 
		var Row = sheetObj.DataCopy();
		
		// 기본값 설정
		sheetObj.CellValue2(Row, 'bare_mgst_rmk')    = "";     // remark 는 공백               	
		sheetObj.CellValue2(Row, "mgst_bare_sts_seq")= "";     // SEQ 초기화			    	
		sheetObj.CellValue2(Row, "mgst_bare_sts_cd") = "BMT";  // BMT 로 셋팅
		
		sheetObj.CellEditable(Row, 'mgst_no') = false;  // M.G.Set No 수정안되는 상태로 셋팅

		break;
		
	case REMOVE:
		ComRowHideDelete(sheetObj,"del_chk");
		break;		
		
	case MULTI01: 
		formObj.f_cmd.value = MULTI01;
		sheetObj.DoSave("EES_CGM_2213GS.do", FormQueryString(formObj), -1,false);
		
		break;
		
	case IBSEARCH_ASYNC01:
		formObj.f_cmd.value = COMMAND01;
		//mgset no 존재 여부 확인
		
		var sXml = sheetObj.GetSearchXml("EES_CGM_2213GS.do", FormQueryString(formObj));
		var sCheckResult = ComGetEtcData(sXml,"chkMgset");
		
		if(sCheckResult=="T"){		
			formObj.f_cmd.value = COMMAND02;
			var sXml = sheetObj.GetSearchXml("EES_CGM_2213GS.do", FormQueryString(formObj));
			var sCheckResult = ComGetEtcData(sXml,"eq_tpsz_cd");
			sheetObj.CellValue2(sheetObj.SelectRow, "eq_tpsz_cd")= ComGetEtcData(sXml,"eq_tpsz_cd");
			
			//type CLG,UMG 별 활성화 
			if(sCheckResult=="CLG"){
				sheetObj.CellEditable(sheetObj.SelectRow, "cntr_no") = true;
			}else if(sCheckResult=="UMG"){
				sheetObj.CellEditable(sheetObj.SelectRow, "chss_no") = true;

			}
		}else if(sCheckResult=="F"){
			ComShowCodeMessage("COM132202", "M.G Set No");		//수정사항
			sheetObj.CellValue(sheetObj.SelectRow,"mgst_no")="";

		}	
		break;
		
	case IBSEARCH_ASYNC02:
		formObj.f_cmd.value = COMMAND03;
		var sXml = sheetObj.GetSearchXml("EES_CGM_2213GS.do", FormQueryString(formObj));
		var sCheckResult = ComGetEtcData(sXml,"chk_eqno");
		if(sCheckResult=="T"){
			formObj.f_cmd.value = COMMAND04;
			var sXml = sheetObj.GetSearchXml("EES_CGM_2213GS.do", FormQueryString(formObj));
			var sCheckResult1 = ComGetEtcData(sXml,"mvmt");
			var sCheckResult2 = ComGetEtcData(sXml,"lsdays");
			sheetObj.CellValue2(sheetObj.SelectRow, "mvmt")=sCheckResult1;
			sheetObj.CellValue2(sheetObj.SelectRow, "lsdays")=sCheckResult2;
		}else if(sCheckResult=="F"){
			ComShowCodeMessage("COM132202", "Container No");		//수정사항
			sheetObj.CellValue(sheetObj.SelectRow,"cntr_no")="";
		}
		
		
		break;
		
	case IBSEARCH_ASYNC03:
		formObj.f_cmd.value = COMMAND05;
		var sXml = sheetObj.GetSearchXml("EES_CGM_2213GS.do", FormQueryString(formObj));
		var sCheckResult = ComGetEtcData(sXml,"chk_chsno");
		if(sCheckResult=="T"){
			formObj.f_cmd.value = COMMAND06;
			var sXml = sheetObj.GetSearchXml("EES_CGM_2213GS.do", FormQueryString(formObj));
			var sCheckResult1 = ComGetEtcData(sXml,"mvmt");
			var sCheckResult2 = ComGetEtcData(sXml,"lsdays");
			sheetObj.CellValue2(sheetObj.SelectRow, "mvmt")=sCheckResult1;
			sheetObj.CellValue2(sheetObj.SelectRow, "lsdays")=sCheckResult2;
		}else if(sCheckResult=="F"){
			ComShowCodeMessage("COM132202", "Chassis No");		//수정사항
			sheetObj.CellValue(sheetObj.SelectRow,"chss_no")="";
		}
		break;

			
	}
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	switch(sAction) {
	case "btn_retrieve" : 
		
		 break;
	}
	return true;
}


/**
 * M.G.Set 중복 체크
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	switch(sheetObj.ColSaveName(Col)) {
		case "mgst_no":
			var formObj = document.form;
			var row_value = sheetObj.CellText(Row, Col);
			formObj.mgst_no.value = row_value;
			if(row_value.length >0){
				doActionIBSheet(sheetObj,document.form,IBSEARCH_ASYNC01); 	//입력 코드 validation 체크
			}
			break;
		
		case "cntr_no":
			var formObj = document.form;
			var row_value = sheetObj.CellText(Row, Col);
			formObj.cntr_no.value = row_value;
			if(row_value.length >0){
				doActionIBSheet(sheetObj,document.form,IBSEARCH_ASYNC02); 	//입력 코드 validation 체크
			}
			break;
			
		case "chss_no":
			var formObj = document.form;
			var row_value = sheetObj.CellText(Row, Col);
			formObj.chss_no.value = row_value;
			if(row_value.length >0){
				doActionIBSheet(sheetObj,document.form,IBSEARCH_ASYNC03); 	//입력 코드 validation 체크
			}
			break;
	 	    
		case "rtn_yd_cd" :
			var formObj = document.form;
  			formObj.f_cmd.value = COMMAND01;
		   	formObj.yd_cd.value =sheetObj.CellValue(Row, "rtn_yd_cd");
		   	if(formObj.yd_cd.value!="")
		   	{
		   		var sXml = sheetObj.GetSearchXml("Check_YardGS.do", FormQueryString(formObj));
			   	var sCheckResult = ComGetEtcData(sXml,"checkResult");
			   	if(sCheckResult == COM_VALIDATION_FALSE){
			   		ComShowCodeMessage('CGM10009','Return Yard');
			   		sheetObj.CellValue(Row, "rtn_yd_cd") = "";
			   		sheetObj.SelectCell(Row, Col, true);
			   	} else {

			   	}
		   	}
	 	    break;		 	    
	}
}

function sheet1_OnSearchEnd(sheetObj, Row, Col){

}

/**
 * Object 의 deactivate 이벤트에 대한 처리  <br>
 * @param  없음
 * @return 없음
 * @author 최민회
 * @version 2009.05.20
 */
function obj_deactivate(){
	 var formObj = document.form;
	 obj = event.srcElement;

	 if(obj.name=="fromdate"  ){
		 with(formObj){
			 var creDtFr = ComReplaceStr(fromdate.value,"-","");
        }
        ComChkObjValid(event.srcElement);
   }
 	if(obj.name=="todate"  ){
		 with(formObj){
			 var creDtFr = ComReplaceStr(todate.value,"-","");
        }
        ComChkObjValid(event.srcElement);
  }
}

/** 
 * Combo Object 초기화  <br>
 * @param  {object} comboObj	필수 Combo Object
 * @return 없음
 * @author 조재성
 * @version 2009.07.16
 */
function initCombo(comboObj) {
	switch (comboObj.id) {
	
	case "status":
		var cnt = 0;
		with (comboObj) {
			Code = "";
			Text = "";
			BackColor = "#FFFFFF";
			DropHeight = 100;
			MultiSelect = false;
			MaxSelect = 1;
			UseCode = true;
			Enable = true;
		}
		break;
	}
}

/*
 * 설  명 : 필드의 값을 대문자로 바꾼 후 세팅한다.
 *          0-9 까지의 정수도 수용한다.
 *          onblur 이벤트에서 사용함.
 * 인자 1 :
 * 리턴값 :
 * 예제파일: EES_EQR_059.jsp
 */
function upperCase_Num() {
	var obj = event.srcElement;

	//백스페이스 및 방향키등등..일경우.. 리턴처리
	if (window.event.keyCode==8 || window.event.keyCode==9 ||
		window.event.keyCode==16 || window.event.keyCode==35 ||
        window.event.keyCode==36 || window.event.keyCode==37 ||
        window.event.keyCode==39 || window.event.keyCode==46){
		return;
	}

	var ret = /[^a-zA-Z^0-9|\,]/g;
	var val = obj.value.replace(ret,'');
	obj.value = val.toUpperCase();
}

function sheet1_OnPopupClick(sheetObj, row, col){
		switch (sheetObj.ColSaveName(col)) {
   		case "vndr_lgl_eng_nm" :
   			ComOpenPopup('/hanjin/COM_ENS_0C1.do' , 800, 475, 'setPrntUsrRoleCd','1,0,1,1,1', true, false, row, col, 0);
   			break

 	    case "rtn_yd_cd" :
 	    	ComOpenPopup('/hanjin/COM_ENS_061.do?pgmNo=COM_ENS_061&mode=yard' , 800, 475, 'setPrntUsrRoleCd','1,0,1,1,1', true, false, row, col, 0);
 	        break;
		}
	}

/**
 * 시트네 팝업 값 넣기
 * @param aryPopupData
 * @param row
 * @param col
 * @param sheetIdx
 * @return
 */
function setPrntUsrRoleCd(aryPopupData, row, col, sheetIdx){
	var sheetObj = sheetObjects[0];
	var formObject = document.form;

		var  spName= "";
		var  spCd= "";
		var i = 0;
		if(col == 10){  //vndr_lgl_eng_nm
			   for(i = 0; i < aryPopupData.length; i++){
				   spName =  aryPopupData[i][4];
				   if(i < aryPopupData.length - 1){
					   spName = spName + ",";
				   }
			   }
			   sheetObj.CellValue2(row, "vndr_seq") =aryPopupData[0][2];
			   sheetObj.CellValue2(row, "vndr_lgl_eng_nm")  =  aryPopupData[0][4];

		}else if(col==12){  // rtn_yd_cd
			for(i = 0; i < aryPopupData.length; i++){
				   spName =  aryPopupData[i][3];
				   if(i < aryPopupData.length - 1){
					   spName = spName + ",";
				   }
			   }
			sheetObj.CellValue2(row, "rtn_yd_cd") = spName;
		}
}

function sheet1_OnSaveEnd(sheetObj, errMsg){
	doActionIBSheet(sheetObj, document.form, IBSEARCH);
}

/* 개발자 작업 끝 */
