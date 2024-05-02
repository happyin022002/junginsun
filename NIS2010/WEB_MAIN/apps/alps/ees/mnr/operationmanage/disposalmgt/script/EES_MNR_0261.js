	/*=========================================================
	 *Copyright(c) 2012 CyberLogitec
	 *@FileName : EES_MNR_0261.js 
	 *@FileTitle : Not Pick-up Container No
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2012.04.12
	 *@LastModifier : 신혜정
	 *@LastVersion : 1.0
	 * 2012.04.12 신혜정
	 * 1.0 Creation 
	=========================================================*/
	/****************************************************************************************
			  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
								[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
								기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
	 ***************************************************************************************/
	
	/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
	
	/**
	 * @extends 
	 * @class EES_MNR_0261 : EES_MNR_0261 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_MNR_0261() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.doActionIBSheet 		= doActionIBSheet;
		this.validateForm 			= validateForm;
	}
	
	/* 개발자 작업	*/
	
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		var sheetObject1 = sheetObjects[0];
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch(srcName) {
            case "btn_downexcel":
                doActionIBSheet(sheetObject1, formObject, IBDOWNEXCEL);
                break;	
			case "btn_close":    
				self.close();  
				break;   
			} // end switch
		}catch(e) {
			if (e == "[object Error]") {
				ComFuncErrMsg(e);
			} else {
				ComFuncErrMsg(e);
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
		MnrWaitControl(true);
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		MnrWaitControl(false);
	}	
	
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj, sheetNo) {
	
		var cnt = 0;
	
		with (sheetObj) {
            // 높이 설정
            style.height = 382;

            // 전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            // Host정보 설정[필수][HostIp, Port, PagePath
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            // 전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

            // 전체Edit 허용 여부 [선택, Default false]
            Editable = false;

            // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(1, 1, 10, 100);

            var HeadTitle1 = "|Seq|Disposal No|Invoice No|Buyer|Eq No|TP/SZ|Term|MVMT|Yard|Request Date|Post Date|Bidding Start Date|Bidding Closing Date|Pick-up Start Date|Pick-up Closing Date|Price";
            var headCount = ComCountHeadTitle(HeadTitle1);

            // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 4, 0, true);

            // 헤더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, true, true, false, false);

            // 헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);
	
            // dtComboEdit [ROW, COL, DATATYPE, 	WIDTH,	DATAALIGN,	COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus,	0,  daCenter,   true,	"ibflag");
			InitDataProperty(0, cnt++, dtSeq,    	30,		daCenter,   true,	"Seq"); 
			InitDataProperty(0, cnt++, dtData,	    100,	daCenter,	true,	"disp_no",			false,		"",		dfNone,			0,		false,		false);			
			InitDataProperty(0, cnt++, dtData,	    100,	daCenter,	true,	"inv_no",			false,		"",		dfNone,			0,		false,		false);
			InitDataProperty(0, cnt++, dtData,		135,	daLeft,	    false,	"buyer_name",		false,		"",		dfNone,			0,		false,		false);
            InitDataProperty(0, cnt++, dtData,      80,    	daCenter,   true,	"eq_no");
            InitDataProperty(0, cnt++, dtData,      40,  	daCenter,   true,	"eq_tpsz_cd");                       
            InitDataProperty(0, cnt++, dtData,      40,    	daCenter,   true,	"lstm_cd");
            InitDataProperty(0, cnt++, dtData,		50,		daCenter,	false,	"mvmt_cd",			false,		"",		dfNone,			0,		false,		false);            
            InitDataProperty(0, cnt++, dtData,		80,		daCenter,	false,	"disp_yd_cd",		false,		"",		dfNone,			0,		false,		false);
            InitDataProperty(0, cnt++, dtData,		90,		daCenter,	false,	"rqst_dt",			false,		"",		dfNone,			0,		false,		false);
            InitDataProperty(0, cnt++, dtData,		90,		daCenter,	false,	"disp_bultn_dt",	false,		"",		dfNone,			0,		false,		false);
            InitDataProperty(0, cnt++, dtData,   	110,	daCenter,  	false,	"disp_st_dt",      	false,		"",     dfNone,    		0,		true,       true);
			InitDataProperty(0, cnt++, dtData,   	120,	daCenter,  	false,	"disp_end_dt",		false,		"",     dfNone,    		0,		true,       true);
			InitDataProperty(0, cnt++, dtData,   	110,	daCenter,  	false,	"disp_pkup_st_dt",	false,		"",     dfNone,    		0,		true,       true);
			InitDataProperty(0, cnt++, dtData,   	120,	daCenter,  	false,	"disp_pkup_end_dt",	false,		"",     dfNone,    		0,		true,       true);
			InitDataProperty(0, cnt++, dtData,   	70,		daRight,  	false,	"part_amt",        	false,		"",     dfFloat,		0,		true,       true);

            // SELECT 로우 배경색
            SelectionMode   = smSelectionRow;
            SelectHighLight = true;
            SelectFontBold  = false;
            SelectBackColor = RgbColor(SelectBackColorR, SelectBackColorG, SelectBackColorB);

            CountPosition = 0;
		}
	}
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBCLEAR:
				doIBCLEAR(sheetObj, formObj, sAction);
				break;
			case IBSEARCH:      //조회
                if (validateForm(sheetObj,formObj,sAction)) {	
                    formObj.f_cmd.value = SEARCH;
                    sheetObj.DoSearch4Post("EES_MNR_0261GS.do", FormQueryString(formObj));
                }
				break;
			case IBDOWNEXCEL:
				sheetObj.SpeedDown2Excel(-1);
				break;
		}
	}
	
	function doIBCLEAR(sheetObj, formObj, sAction){
		MnrWaitControl(true);
		sheetObjects[0].RemoveAll();

		MnrWaitControl(false);
	}
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		with (formObj) {
			if (!ComChkObjValid(formObj))
				return false;
		}
		return true;
	}
