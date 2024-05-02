/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_AGT_0038.js
*@FileTitle : Office code info
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 추경원
*@LastVersion : 1.0
* 2009.08.14 추경원 - 1.0 Creation
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
     * @class ESM_AGT_0038 : ESM_AGT_0038 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_AGT_0038() {
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
    var sRow = 0;

    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	var sheetObject = sheetObjects[0];
    	var formObject = document.form;

//    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
    		
    		switch(srcName) {
    			case "btn_retrieve":
    				doActionIBSheet(sheetObject,formObject,IBSEARCH);
    				break;

    			case "btn_rowadd":
    			    doActionIBSheet(sheetObject,formObject,IBINSERT);
    				break;
    			
    			case "btn_save":
    				doActionIBSheet(sheetObject,formObject,IBSAVE);
    				break;
    		} // end switch
    		
//    	}catch(e) {
//    		if( e == "[object Error]") {
//    			ComShowMessage(ComGetMsg("COM12111", "", ""));
//    		} else {
//    			ComShowMessage(e);
//    		}
//    	}
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
    		ComConfigSheet(sheetObjects[i]);

    		initSheet(sheetObjects[i],i+1);
    	    
    	    //khlee-마지막 환경 설정 함수 추가
    		ComEndConfigSheet(sheetObjects[i]);
    	}
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
    				style.height = GetSheetHeight(15);
    				
    				//전체 너비 설정
    				SheetWidth = mainTable.clientWidth;

    				//Host정보 설정[필수][HostIp, Port, PagePath]
    				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    				//전체Merge 종류 [선택, Default msNone]
    				MergeSheet = msHeaderOnly;

    			   	//전체Edit 허용 여부 [선택, Default false]
    				Editable = true;

    				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    				InitRowInfo(1, 1, 9, 100);

    				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitColumnInfo(8, 0, 0, true);

    				//해더기능설정(SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D)
    				InitHeadMode(true, true, false, true, false,false) ;

    				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				var HeadTitle = "DEL|STS|SEQ|Office|AR Office|CURR|Description|Delete";
    				InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,   DATATYPE,    WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtDelCheck,  40,    daCenter,  false,    "del",     false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++, dtStatus,    50,    daCenter,  false,    "ibflag",  false,    "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtSeq,       50,    daCenter,  true,     "",        false,    "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtPopupEdit, 130,    daCenter,  true,     "agn_cd",   true,     "",         dfNone,     0,          false,      true,       6);
                    InitDataProperty(0, cnt++, dtData,      130,    daCenter,  true,     "ar_ofc_cd", true,     "",         dfNone,     0,          true,       true,       6);
                    InitDataProperty(0, cnt++, dtCombo,     130,    daCenter,  true,     "curr_cd",  false,    "",         dfNone,     0,          true,       true);
    				InitDataProperty(0, cnt++, dtData,      350,   daLeft,    true,     "ofc_delt_rsn", false,    "",         dfNone,     0,          true,       true,       500);
                    InitDataProperty(0, cnt++, dtCombo,     80,    daCenter,  true,     "delt_flg", false,    "",         dfNone,     0,          true,       true);
    				
    				InitDataValid(0, "agn_cd",   vtEngUpOther, "");	//영대문자만 입력되도록 설정
                    InitDataValid(0, "ar_ofc_cd", vtEngUpOther, "");	//영대문자만 입력되도록 설정
                    InitDataCombo(0, "curr_cd", currText, currCode, "USD");
                    InitDataCombo(0, "delt_flg", "Y|N", "Y|N","N");
    			}
    			break;
    	}
    }

       // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;

    	switch(sAction) {
    	    case IBSEARCH:		//조회
//    			if(!validateForm(sheetObj,formObj,sAction)) return false;
    			formObj.f_cmd.value = SEARCH;
    			sheetObj.DoSearch4Post("ESM_AGT_0038GS.do", agtQryStr(formObj));
    			break;
    			
    		case IBSAVE:		//저장
//    			if(!validateForm(sheetObj,formObj,sAction))	return false;
    			formObj.f_cmd.value = MULTI;
    			sheetObj.DoSave("ESM_AGT_0038GS.do", agtQryStr(formObj));
    			break;
    			
    		case IBINSERT:		//입력
    			var Row = sheetObj.DataInsert();
    			break;
    	}
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	with(formObj){
    		if (!ComIsNumber(pagerows)) {
    			return false;
    		}
    		
    		switch(sAction) {
    		    case IBSEARCH:		//조회
    		    	formObj.hqofccd.readOnly = true;
    		    	
    		    	if(hqofccd.value == ""){
    		    		showErrMessage(getMsg("AGT10001", "H/Q Office Code ", "", ""));
    		    		hqofccd.readOnly = false;
    		    		hqofccd.focus();
    					return false;
    		    	}
    				break;
    				
    			case IBSAVE:		//저장
    				var sCnt = sheetObj.RowCount;
    				if(sCnt < 1){
    					showErrMessage(getMsg("AGT10004", "", "", ""));
    					return false;		    		
    				}
    				
    				var mCnt = sheetObj.RowCount("I") + sheetObj.RowCount("U") + sheetObj.RowCount("D");
    				if(mCnt < 1){
    					showErrMessage(getMsg("AGT10010", "", "", ""));
    					return false;		    		
    				}
    				break;
    		}
    	}

    	return true;
    }

    /**
     * 시트에서 Biz 공통 팝업 호출
     * - ComOpenPopup() 호출 : row, col 정보를 Parameter로 전달  
     */
    function sheet1_OnPopupClick(sheetObj, row, col) {
    	//Office Popup Click   
        if (sheetObj.ColSaveName(col) == "agn_cd") {
            var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1";    // Row PopUp
            var classId = "COM_ENS_071";
    	    var param = '?ofc_lev=6';
    		var chkStr = dispaly.substring(0,3) ;         
            
            if(chkStr == "1,0") {
            	//Radio PopUp  
               	ComOpenPopup('/hanjin/COM_ENS_071.do' + param, 770, 470, 'getESM_AGT_0038_1', "1,0,1,1,1,1,1", true, false, row, col);
            } 
        }
    }

    /**
     * Office : 팝업에서 Radio로 단일 선택을 한경우..
     */
    function getESM_AGT_0038_1(rowArray, row, col) {
        var sheetObj = sheetObjects[0];
        
    	var colArray = rowArray[0];
    	sheetObj.CellValue(row, col) = colArray[3];
    }

    /*
     * 그리드에서 컬럼값 변경시 처리
     */
    function sheet1_OnChange(sheetObj, row, col) {
    	var formObj = document.form;

    	if(sheetObj.ColSaveName(col) == "agn_cd"){
    		sRow = row;
    		formObj.param1.value = sheetObj.CellValue(row,col);
    	    formObj.target = "frmHidden";
    	    formObj.action = "ESM_AGT_0038FR.do";
    	    formObj.submit();
    	}
    }

    /*
     * Grid에 AR_OFFICE 정보를 세팅한다.
     */
    function setAROfficeInfo(){
    	var formObj  = document.form;
    	var sheetObj = sheetObjects[0];
    	
    	sheetObj.CellValue2(sRow, "ar_ofc_cd") = formObj.param2.value;
    }

	/* 개발자 작업  끝 */