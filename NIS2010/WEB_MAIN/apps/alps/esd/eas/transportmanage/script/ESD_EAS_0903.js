/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : ESD_EAS_0903GS.jsp
*@FileTitle : Route UnMatch List Detail 조회
*Open Issues :
*Change history :
*@LastModifyDate : 2007-12-03
*@LastModifier : HoSam_Lee
*@LastVersion : 1.0
* 2007-12-03 HoSam_Lee
* 1.0 최초 생성
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

	/**
	 * @extends Bkg
	 * @class ESD_EAS_0903 : 예)Route UnMatch List 조회 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESD_EAS_0903() {
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
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;

	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
		
		 /******************************************************/
		 var formObject = document.form;
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
			case "btn_downexcel":
				sheetObject.ExcelPrint = "";
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
				break;
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
			case "bttn_save":
				doActionIBSheet(sheetObject,formObject,IBSAVE);
				break;
			case "btn_close":
			    window.returnValue = null;
			    window.close();
			    break;				
			case "btn_new":
				sheetObject.RemoveAll();
				formObject.reset();
				break;				
			case "btns_office": 
			//if( validation_check() ) {
				var ofc_cd = formObject.ctrl_ofc_cd.value;
				ComOpenWindow('ESD_EAS_COM_0001.screen?ctrl_ofc_cd='+ofc_cd, 'ESD_EAS_COM_001', 'top=200, left=200, width=410, height=400, toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=0');
			//}
			break;
			case "btn_detail":
				//openWindow('ESD_EAS_0903.do?inv_no=PUS-07-05-TS-20', 'ESD_EAS_0903', 'top=200, left=200, width=800, height=600, toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=1');
				sheet1_OnDblClick(sheetObject, sheetObject.SelectRow, sheetObject.SelectCol);
				break;

			} // end switch
		} catch(e) {
			if( e == "[object Error]") {
				errMsg = ComGetMsg("COM12111" );
				ComShowMessage(errMsg);
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
//	function setDocumentObject(sheet_obj){
//		docObjects[sheetCnt++] = sheet_obj;
//	}
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
			ComConfigSheet(sheetObjects[i]);
	       initSheet(sheetObjects[i],i+1);
	       //khlee-마지막 환경 설정 함수 추가
	       ComEndConfigSheet(sheetObjects[i]);
		}
		doActionIBSheet(sheetObjects[0],document.form,COMMAND01);
		doActionIBSheet(sheetObjects[1],document.form,COMMAND02);

	}

	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
		sheetObj.UseUtf8 = true;
		switch(sheetNo) {
			case 1:	  //IBSheet1 init
				with (sheetObj) {
					var cnt = 0;
					// 높이 설정
					style.height = 100;
										
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 2, 1, 10, 10);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(8, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)

					var HeadTitle1 = "B/L Information|B/L Information|B/L Information|B/L Information|B/L Information|B/L Information|B/L Information|B/L Information";
					var HeadTitle2 = "BKG NO|B/L NO|RCV Term|DEL Term|POR|POL|POD|DEL";
	
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);					
				   
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtData,      100,    daCenter, false,    "bkg_no",			false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,      100,    daCenter, false,    "bl_no",            false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "rcv_term",     	false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "del_term",      	false,          "",       dfNone,    0,     false,       true); 
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "bkg_por",          false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "bkg_pol",          false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "bkg_pod",          false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "bkg_del",          false,          "",       dfNone,    0,     false,       true);
														
				}
				break;
				
			case 2:	  //IBSheet2 init
				with (sheetObj) {
					var cnt = 0;
					// 높이 설정
					style.height = 280;
										
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 2, 1, 10, 10);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(17, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)

					var HeadTitle1 = "S/O Detail|S/O Detail|S/O Detail|S/O Detail|S/O Detail|S/O Detail|S/O Detail|S/O Detail|S/O Detail|S/O Detail|S/O Detail|S/O Detail|S/O Detail|S/O Detail|S/O Detail|S/O Detail|S/O Detail";
					var HeadTitle2 = "SEQ|Container|T/S|ORG - DEST|Move|Office|S/O Date|User ID|S/O STS|CUR|S/O AMT|W/O NO|W/O Date|INV AMT|INV STS|INV User|S/O Remark";
	
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);					
  
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtSeq,   	 40,    daCenter, false,    "seq",          false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,      100,    daCenter, false,    "cntr_no",     	false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       50,    daCenter, false,    "tp_sz",		false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,      150,    daCenter, false,    "org_dest",     false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       50,    daCenter, false,    "move",         false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       50,    daCenter, false,    "ofc_cd",     	false,          "",       dfNone,    0,     false,       true);

					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "so_date",      false,          "",       dfNone,    0,     false,       true); 
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "so_user",      false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "so_sts",       false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "curr",         false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "amt",          false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "wo_no",        false,          "",       dfNone,    0,     false,       true);

					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "wo_date",      false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "inv_amt",      false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       50,    daCenter, false,    "inv_sts",      false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "inv_user",     false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "so_rmk",       false,          "",       dfNone,    0,     false,       true);
															
				}
				break;
		}
	}


	
	/* Sheet관련 프로세스 처리 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		   case COMMAND01:	  //Detail Top 조회
				
				formObj.f_cmd.value = SEARCH01;
//				prompt('',"ESD_EAS_0903GS.do?"+EasFrmQryString(formObj));
//				return;
				sheetObj.DoSearch4Post("ESD_EAS_0903GS.do", EasFrmQryString(formObj));
				break;
				
				
		   case COMMAND02:	  //Detail Down 조회
				
				formObj.f_cmd.value = SEARCH02;
//				prompt('',"ESD_EAS_0903GS.do?"+EasFrmQryString(formObj));
//				return;
				sheetObj.DoSearch4Post("ESD_EAS_0903GS.do", EasFrmQryString(formObj));
				break;

			case IBCLEAR:	   //Clear
				sheetObj.RemoveAll();
				break;
			case IBDOWNEXCEL:  //엑셀내려받기
				sheetObj.SpeedDown2Excel(true);
				break;
		}
	}
	

	/**
	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
	 */
	function sheet1_OnSearchEnd(sheetObj,errMsg){

	}

	function sheet1_OnClick(sheetObj, Row,Col,Value){

	}
	

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(formObj){

formObj = document.form;
	var result = true ;
	// 검색 조건 입력 여부
	if( !isInputField(formObj) ) {
		result = false ;
	}

	if( formObj.search_choice[0].checked == true ){
	
		if( isEmpty(formObj.somonth) || !chkMonthValue(formObj.somonth.value) ){
			showErrMessage(getMsg('EAS90001', 'S/O Month'));
			result = false;
		}
	}else if( formObj.search_choice[1].checked == true ){
	
		if( ( isEmpty(formObj.fromsodate) || !chkDateValue(formObj.fromsodate.value) ) && ( isEmpty(formObj.tosodate) || !chkDateValue(formObj.tosodate.value) ) ){
			showErrMessage(getMsg('EAS90001', 'S/O Date'));
			result = false;
			
		}
	}

	return result;
}

function isInputField(formObj) {
	var result    = true ;

	if( document.form.ctrl_ofc_cd.value=="" ) {
		showErrMessage(getMsg('EAS90001'));
		result = false;
	}
	return result;
}
	