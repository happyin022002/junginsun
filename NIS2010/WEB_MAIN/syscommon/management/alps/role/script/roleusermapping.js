/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : roleusermapping.js
*@FileTitle : 사용자 매핑
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-13
*@LastModifier : SeongWook Kim
*@LastVersion : 1.0
* 2006-09-13 SeongWook Kim
* 1.0 최초 생성
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/* 공통전역변수 */
//var calPop = new calendarPopupGrid();
var sheetObjects = new Array();
var sheetCnt = 0;

/* 업무별전역변수는 아래 부분에 추가 선언하여 사용한다. */

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
	function loadPage() {
		var formObject = document.form;

		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}

    	doActionIBSheet(sheetObjects[0],formObject,SEARCH01);
    	doActionIBSheet(sheetObjects[1],formObject,SEARCH02);
	}

	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
    var cnt = 0;
		//sheetObj.UseUtf8 = true;
		switch(sheetNo) {
             case 1:      //IBSheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 340 ;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;
                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(4, 0, 0, true);
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, true, true, false,false) ;
                    var HeadTitle = "Level|OfficeCode|English Office Name|Korean Office Name";
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,     KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    //InitDataProperty(0, cnt++ , dtCheckBox,   20,  daCenter,    false,   "checkbox");
                    InitDataProperty(0, cnt++ , dtData,       70,  daCenter,    false,   "level",        false,        "",       dfNone,     0,       false,       true);
                    InitDataProperty(0, cnt++ , dtData,       80,  daCenter,    false,   "ofc_cd",       false,        "",       dfNone,     0,       false,       false);
                    InitDataProperty(0, cnt++ , dtData,      180,  daLeft,      false,   "ofc_eng_nm",   false,        "",       dfNone,	   0,       false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,      180,  daLeft,      false,   "ofc_krn_nm",   false,        "",       dfNone,	   0,       false,       false);
                    
                    InitTreeInfo(0, "level");
               }
             break;
			case 2:	  //IBSheet2 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 340 ;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 14, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(6, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false) ;

                    var HeadTitle = "|STS|User ID|OfficeCode|User Name|User Local Name" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);

                    //데이터속성    [ROW,  COL,    DATATYPE,    WIDTH,  DATAALIGN, COLMERGE,     SAVENAME,     KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtCheckBox,     50,    daCenter,  false,   "check_val");
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 40,    daCenter,  false,   "ibflag");
                    InitDataProperty(0, cnt++ , dtData,         80,    daLeft,    false,   "usr_id",           true,        "",     dfNone,           0,    false,       false);
                    InitDataProperty(0, cnt++ , dtData,       	80,    daCenter,  false,   "ofc_cd",       true,        "",     dfNone,     	  0,    false,       false);
                    InitDataProperty(0, cnt++ , dtData,        150,    daLeft,    false,   "usr_nm",           true,        "",     dfNone,           0,    false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,      150,    daLeft,    false,   "usr_locl_nm",      true,        "",     dfNone,           0,    false,       false);
                    
               }                                                      
               break;
		}
	}

	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */	
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 ****/
		var sheetObject = sheetObjects[0];
		var sheetObject1 = sheetObjects[1];
		/******************************************************/
		var formObject = document.form;
			
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			/***********************************************************************************************************
				이미지 클릭 이벤트 처리, popup도 역시 이곳에서 함
				공통코드: CoFormControl.js 에 정의 되어있습니다. 이 변수를 통하여 ServiceCommand에서 분기 합니다.		
			**********************************************************************************************************/
			
			switch(srcName) {
				case "btn_save":
					doActionIBSheet(sheetObject1,formObject,MULTI);
					//self.close();
					break;
				case "btn_close":
					self.close();
					break;
				case "btn_DownExcel":
					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
					break;
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(ComGetMsg('COM12111'));
			} else {
				ComShowMessage(e);
			}
		}
	}
	
	/* Sheet관련 프로세스 처리 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		    case SEARCH01:	  //조회
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				formObj.f_cmd.value = SEARCH01;
				sheetObj.DoSearch4Post("searchUserMapping.do", FormQueryString(formObj));
				break;
			case SEARCH02:	  //조회
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				formObj.f_cmd.value = SEARCH02;
				sheetObj.DoSearch("searchUserMapping.do", FormQueryString(formObj));
				break;
			case MULTI:		//저장
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				formObj.f_cmd.value = MULTI;
				sheetObj.DoSave("searchUserMapping.do", FormQueryString(formObj),-1, false);
				break;
			case IBCLEAR:	   //Clear
				sheetObj.RemoveAll();
				break;
			case IBDOWNEXCEL:  //엑셀내려받기
				sheetObj.SpeedDown2Excel(true);
				break;
		}
	}
	
	function chkBox(checked) {
		if(checked==true){
		    for ( var idx = 1; idx <= sheetObjects[1].RowCount; idx++) {
		    	if(sheetObjects[1].CellValue(idx,'check_val') == 1 ){
	        		sheetObjects[1].RowHidden(idx) = false;
	        	} else {
	        		sheetObjects[1].RowHidden(idx) = true;
	        	}
	        	  
	   		}
		} else {
			for ( var idx = 1; idx <= sheetObjects[1].RowCount; idx++) {     
     			sheetObjects[1].RowHidden(idx) = false;
     		}
		}
	} 
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
//		with(formObj){}
		return true;
	}
    
  /**
   */
	function sheet1_OnDblClick(sheetObj, Row, Col) {
    	var formObject = document.form;
    	formObject.ofc_cd.value = sheetObj.CellValue(Row,"ofc_cd");
    	doActionIBSheet(sheetObjects[1],formObject,SEARCH02);
    	if(formObject.showAll.checked) chkBox(true);
	}