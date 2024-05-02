/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : UI_COM_SYS_009.js
*@FileTitle : 프로그램 매핑
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
      for(i=0;i<sheetObjects.length;i++){
          ComConfigSheet(sheetObjects[i]);
          initSheet(sheetObjects[i],i+1);
          ComEndConfigSheet(sheetObjects[i]);
      }
      
      var formObject = document.form;
      formObject.pgm_no_form.value = "000_000_M000";
      doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
      doActionIBSheet2(sheetObjects[1],formObject,IBSEARCH);
	}

	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
    var cnt = 0;
		sheetObj.UseUtf8 = true;
		switch(sheetNo) {
             case 1:      //IBSheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 240 ;
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
                    InitColumnInfo(5, 0, 0, true);
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, true, true, false,false) ;
                    var HeadTitle = "||Level|Menu No|Menu Name|Korean Office Name";
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,     KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,  false,   "auth");
                    InitDataProperty(0, cnt++ , dtData,       70,  daCenter,    false,   "level",        false,        "",       dfNone,     0,       false,       true);
                    InitDataProperty(0, cnt++ , dtData,       100,  daCenter,    false,   "pgm_no",       false,        "",       dfNone,     0,       false,       false);
                    InitDataProperty(0, cnt++ , dtData,      180,  daLeft,      false,   "pgm_nm",       false,        "",       dfNone,	   0,       false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,    180,  daLeft,      false,   "pgm_nm",       false,        "",       dfNone,	   0,       false,       false);
                 
                    InitTreeInfo(1, "level");
               }
             break;
			case 2:	  //IBSheet2 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 240 ;
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
                    InitColumnInfo(5, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false) ;

                    var HeadTitle = "|STS|Program ID|Program Name|Program Name" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);

                    //데이터속성    [ROW,  COL,    DATATYPE,    WIDTH,  DATAALIGN, COLMERGE,     SAVENAME,     KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtCheckBox,     50,    daCenter,  false,   "check_val");
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 40,    daCenter,  false,   "ibflag");
                    InitDataProperty(0, cnt++ , dtData,         100,    daLeft,    false,   "pgm_no",           true,        "",     dfNone,           0,    false,       false);
                    InitDataProperty(0, cnt++ , dtData,        150,    daLeft,    false,   "pgm_nm",           true,        "",     dfNone,           0,    false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,      150,    daLeft,    false,   "pgm_nm",      true,        "",     dfNone,           0,    false,       false);
                    
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
			/*
				이곳에 document.form 혹은 document.form[0]식으로 코딩하시는 것을 삼가해 주십시오.
				메뉴가 적용되면 left_menu.jsp에 form 이 존재할 것이기 때문에 더이상 form[0]이 아닙니다.
				(순서상도 form[1]이 되겠죠?) 
				그리고 위에서 with(document.form)라고 했기때문에 (브라우저의 DOM 객체중 특정부분만 잡는다는 의미니깐!)
				document.form.f_cmd.value = INSERT;   이런식의 코딩은 지양해주십시오.
			*/
			switch(srcName) {
				case "btn_save":
					doActionIBSheet2(sheetObject1,formObject,IBSAVE);
					break;
		      
				case "btn_close":
		            self.close();
		            break;
		    
		      case "btn_DownExcel":
		    	  doActionIBSheet2(sheetObject1,formObject,IBDOWNEXCEL);
				break;

			} // end switch
		}catch(e) {			
			/*
				자바 스크립트 에러가 발생할시 오동작이 납니다. 고객에게 이 경우 아래의 메세지가 뿌려지게 해야합니다.
				물론 화면에서 다음의 메세지를 보시면 무조건 '자바스크립트 에러구나'라고 확인하실수 가 있습니다.
			*/
			if( e == "[object Error]") {
				ComFuncErrMsg(getMsg('COM12111'));
			} else {
				ComFuncErrMsg(e);
			}
		}
	}
	
	/* Sheet관련 프로세스 처리 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		   case IBSEARCH:	  //조회
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				formObj.f_cmd.value = SEARCH03;//role_cd 추가로 메소드 변경
				sheetObj.DoSearch4Post("searchProgramMapping.do", FormQueryString(formObj));
				sheetObj.ShowTreeLevel(1,1);
				break;
			case IBCLEAR:	   //Clear
				sheetObj.RemoveAll();
				break;
			case IBDOWNEXCEL:  //엑셀내려받기
				sheetObj.SpeedDown2Excel(true);
				break;
		}
	}
	
	/* Sheet관련 프로세스 처리 */
	function doActionIBSheet2(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		   case IBSEARCH:	  //조회
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				formObj.f_cmd.value = SEARCH02;
				sheetObj.DoSearch4Post("searchProgramMapping.do", FormQueryString(formObj));
				break;
			case IBSAVE:		//저장
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				formObj.f_cmd.value = MULTI;
				sheetObj.DoSave("searchProgramMapping.do", FormQueryString(formObj),"ibflag",false);
				break;
			case IBCLEAR:	   //Clear
				sheetObj.RemoveAll();
				break;
			case IBDOWNEXCEL:  //엑셀내려받기
				sheetObj.SpeedDown2Excel(true);
				break;
		}
	}
	
	function chkBox(sheetNo,checked) {
    	
	       //alert(1);
	      //alert(sheetNo);
	        		if(checked==true)
	        		{
	        		    for ( var idx = 1; idx <= sheetObjects[sheetNo].RowCount; idx++) {     
	        	        	 	if(sheetObjects[sheetNo].CellValue(idx,'check_val') == 1 )
	        	        	 	{
	        	        		 	
	        	        		 	sheetObjects[sheetNo].RowHidden(idx) = false;
	        	        	 	}
	        	        	 	else
	        	        		 {
	        	        	 		sheetObjects[sheetNo].RowHidden(idx) = true;
	        	        		 }
	        	        	  
	        	   			}
	        		}
	        		else
	        		{
	        			for ( var idx = 1; idx <= sheetObjects[sheetNo].RowCount; idx++) {     
	             			sheetObjects[sheetNo].RowHidden(idx) = false;
	             		}
	        		}
	    	   
	   
	    } 
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			/**
			 * @TODO 개발자 분들께서 넣어 주셔야 합니다. 
			 */
			//if (!isNumber(formObj.iPage)) {
			//	return false;
		   // }
		}
		
		return true;
	}
  
	
	
  /**
   */
  function sheet1_OnDblClick(sheetObj, Row, Col) {
      var formObject = document.form;
      formObject.pgm_no_form.value = sheetObj.CellValue(Row,"pgm_no");
    	doActionIBSheet2(sheetObjects[1],formObject,IBSEARCH);
  }