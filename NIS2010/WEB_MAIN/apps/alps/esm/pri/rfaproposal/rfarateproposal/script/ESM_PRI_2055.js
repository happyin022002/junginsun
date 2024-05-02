/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : ESM_PRI_2055.jsp
 *@FileTitle : RFA Proposal Creation - Rate [M/B]
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.04.20
 *@LastModifier : 전지예
 *@LastVersion : 1.0
 * 2015.04.20 전지예
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
     * @class ESM_PRI_2055 : ESM_PRI_6064 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_2055() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/
    

    // 공통전역변수

    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
    
	 /** 
	  * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	  * <br><b>Example :</b>
	  * <pre>
	  * </pre>
	  *
	  * @return 없음
	  */ 
	function processButtonClick() {
		 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		 var sheetObject1 = sheetObjects[0];

		/*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {
				if (getButtonTable(srcName).disabled) {
					return false;
				}
			}
			
			switch(srcName) {
				case "btn_close":
			   	 	self.close();
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
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 *
	 * @param  {object}   sheet_obj 필수, sheet Object
	 * @return 없음
	 */ 
	function setSheetObject(sheet_obj) {
		
		sheetObjects[sheetCnt++] = sheet_obj;
		
	}
    
	 /** 
	  * Sheet 기본 설정 및 초기화
	  * body 태그의 onLoad 이벤트핸들러 구현
	  * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	  * <br><b>Example :</b>
	  * <pre>
	  * </pre>
	  * 
	  * @return 없음
	  */ 
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
			
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
			
		}
		ComOpenWait(true);
		loadInitData();
		ComOpenWait(false);
		self.focus();
	}
	
	/**  
	 * 화면 loading시 필요한 최초 데이터를 조회해서<br>
	 * 화면에 Setting 해 놓는다.
	 *  
	 * <br><b>Example :</b>
	 * <pre>
	 *   loadInitData();
	 * </pre>
	 * 
	 * @return 없음
	 */	   
	function loadInitData() {
		var formObj = document.form;
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
	}
	 
	/** 
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {object} sheetObj 필수, sheet Object
	 * @param {String} sheetNo 필수, sheet의 ID
	 * @return 없음
	 */ 
	function initSheet(sheetObj,sheetNo) {

		var cnt = 0;
		sheetObj.WaitImageVisible = false;
		
		switch(sheetObj.id) {
			case "sheet1":
				with (sheetObj) {
					// 높이 설정
					style.height = 200;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msPrevColumnMerge + msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 7, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(13, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);

					var HeadTitle1 = "|Route|Status|cost_yrmon|fcntr_ecc_cd";
 					var headCount = ComCountHeadTitle(HeadTitle1);
					
 					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,   true,   	"ibflag");
					
 					InitDataProperty(0, cnt++ , dtData,			70,	daCenter,		true,		"loc_cd",						false,	"",		dfNone,			0,		false,	false);
 					InitDataProperty(0, cnt++ , dtData,			70,	daCenter,		true,		"cntr_io_vol_sts_nm",	false,	"",		dfNone,			0,		false,	false);

 					InitDataProperty(0, cnt++ , dtHidden,		30,	daCenter,		true,		"cost_yrmon");
 					InitDataProperty(0, cnt++ , dtHidden,		30,	daCenter,		true,		"fcntr_ecc_cd");
 			}
			break;
				
			case "sheet2":
				with (sheetObj) {
					// 높이 설정
					style.height = 200;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msPrevColumnMerge + msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 7, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(13, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);

					var HeadTitle1 = "|Route|Status|cost_yrmon|fcntr_ecc_cd";
 					var headCount = ComCountHeadTitle(HeadTitle1);
					
 					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,   true,   	"ibflag");
					
 					InitDataProperty(0, cnt++ , dtData,			70,	daCenter,		true,		"loc_cd",						false,	"",		dfNone,			0,		false,	false);
 					InitDataProperty(0, cnt++ , dtData,			70,	daCenter,		true,		"cntr_io_vol_sts_nm",	false,	"",		dfNone,			0,		false,	false);
 					
 					InitDataProperty(0, cnt++ , dtHidden,		30,	daCenter,		true,		"cost_yrmon");
 					InitDataProperty(0, cnt++ , dtHidden,		30,	daCenter,		true,		"fcntr_ecc_cd");
 			}
			break;
				
			case "sheet3":
				with (sheetObj) {
					// 높이 설정
					style.height = 200;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msPrevColumnMerge + msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 7, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(13, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);

					var HeadTitle1 = "|Type|Status";
 					var headCount = ComCountHeadTitle(HeadTitle1);
					
 					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,   true,   	"ibflag");
					
 					InitDataProperty(0, cnt++ , dtData,			70,	daCenter,		true,		"cntr_tpsz_cd",				false,	"",		dfNone,			0,		false,	false);
 					InitDataProperty(0, cnt++ , dtData,			70,	daCenter,		true,		"cntr_io_vol_sts_nm",	false,	"",		dfNone,			0,		false,	false);
 			}
			break;
		}
	}


	/** 
	 * sheet에 관련된 실제 Action(Retrieve, Add, Delete)을 일으키는 함수
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {object} sheetObj 필수, sheet Object
	 * @param {object} formObj 필수, html document form Object
	 * @param {int} sAction 필수, action의 구분
	 * @return 없음
	 */   
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {

 			case IBSEARCH:	 //조회
 				ComOpenWait(true);
 				if ( sheetObj.id == "sheet1"){
 					if(!validateForm(sheetObj,formObj,sAction)){
 						ComOpenWait(false);
 						return false;
 					}
 					formObj.f_cmd.value = SEARCH01;
 					sheetObj.DoSearch("ESM_PRI_2055GS.do", FormQueryString(formObj) + "&cntr_tpsz_cd=D4&org_dest_tp_cd=O");
 				}
 				if ( sheetObj.id == "sheet2"){
 					if(!validateForm(sheetObj,formObj,sAction)){
 						ComOpenWait(false);
 						return false;
 					}
 					formObj.f_cmd.value = SEARCH01;
 					sheetObj.DoSearch("ESM_PRI_2055GS.do", FormQueryString(formObj) + "&cntr_tpsz_cd=D4&org_dest_tp_cd=D");
 				}
 				ComOpenWait(false);
				break;
				
 			case IBSEARCH_ASYNC01:	// 클릭 시 조회
 		    	formObj.f_cmd.value = SEARCH02;
 		    	var param = "&fcntr_ecc_cd=" + sheetObj.CellValue(sheetObj.SelectRow, "fcntr_ecc_cd") + "&cost_yrmon=" + sheetObj.CellValue(sheetObj.SelectRow, "cost_yrmon");
 		    	sheetObjects[2].DoSearch("ESM_PRI_2055GS.do", FormQueryString(formObj) + param);
 				break;
 				
 			case IBSAVE:
 				formObj.f_cmd.value = MULTI;
 				sheetObj.GetSaveXml("ESM_PRI_2055GS.do", FormQueryString(formObj));
 				break;
		}
	}
	
	/** 
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 * <br><b>Example :</b>
	 * <pre>
	 *	  if (!validateForm(sheetObj,document.form,sAction)) {
	 *		  return false;
	 *	   }
	 * </pre>
	 * @param {object} sheetObj 필수, sheet Object
	 * @param {object} formObj 필수, html document form Object
	 * @param {int} sAction 필수, action의 구분
	 *
	 * @return boolean, true: 유효, false: 비유효
	 */
	function validateForm(sheetObj,formObj,sAction) {
		
		return true;
		
	}
	
    /** 
     * sheet를 이용해 조회를 했을경우 조회 완료후 자동 호출됨 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {object} sheetObj 필수, sheet Object
     * @param {String} ErrMsg 필수, sheet의 결과 메시지
     * @return 없음
     */          
    function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
    	document.getElementById("mb_port").innerHTML = sheetObj.CellValue(1, "loc_cd");
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
    }

    /** 
     * sheet를 이용해 조회를 했을경우 조회 완료후 자동 호출됨 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {object} sheetObj 필수, sheet Object
     * @param {String} ErrMsg 필수, sheet의 결과 메시지
     * @return 없음
     */          
    function sheet3_OnSearchEnd(sheetObj,ErrMsg) {
    	if (ErrMsg == "") {
    		doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
    	}
    }
    
    /** 
     * sheet를 마우스 클릭 했을경우 자동 호출됨 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {object} sheetObj 필수, sheet Object
     * @param {int} row 필수, 클릭된 row index
     * @param {int} col 필수, 클릭된 col index
     * @param {string} value 필수, 클릭된 cell의 값
     * @return 없음
     */    	
	function sheet1_OnClick(sheetObj,row, col, value) {
		document.getElementById("mb_port").innerHTML = sheetObj.CellValue(row, "loc_cd");
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
	}
	
    /** 
     * sheet를 마우스 클릭 했을경우 자동 호출됨 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {object} sheetObj 필수, sheet Object
     * @param {int} row 필수, 클릭된 row index
     * @param {int} col 필수, 클릭된 col index
     * @param {string} value 필수, 클릭된 cell의 값
     * @return 없음
     */    	
	function sheet2_OnClick(sheetObj,row, col, value) {
		document.getElementById("mb_port").innerHTML = sheetObj.CellValue(row, "loc_cd");
		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC01);
	}