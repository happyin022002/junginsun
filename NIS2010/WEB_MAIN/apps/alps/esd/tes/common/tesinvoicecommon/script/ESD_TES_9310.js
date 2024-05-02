/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : esd_tes_9310.js
*@FileTitle : Notice on Old Invoice & CSR of TES
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : KimYongJin
*@LastVersion : 1.0
* 2010.11.08 KimYongJin
* 1.0 Creation
* 
* 2012.03.19 민정호 [CHM-201216851] 요구사항 개발진행
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author SM LINE
     */

    /**
     * @extends
     * @class esd_tes_9310 : esd_tes_9310 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esd_tes_9310() {
        this.processButtonClick    = tprocessButtonClick;
        this.setSheetObject        = setSheetObject;
        this.loadPage              = loadPage;
        this.initSheet             = initSheet;
        this.doActionIBSheet       = doActionIBSheet;
        this.validateForm          = validateForm;
    }

/* 개발자 작업 */


// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

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
            initSheet(sheetObjects[i], i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        //조회
        doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
        window.onunload = InitWinTopPendingTESWin;
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
                    style.height = 190;

                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 5, 100);

                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(11, 0, 0, true);

                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);
                                      
                    var HeadTitle0 = "S/N|Invoice\nOffice|S/P Invoice|S/P Invoice|S/P Invoice|Date|Date|Invoice User|Invoice User|Invoice\nStatus";
                    var HeadTitle1 = "S/N|Invoice\nOffice|Number|Currency|Amount|Received|Input|ID|Name|Invoice\nStatus";
                    // 헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(1, HeadTitle1, true);

                    // 데이터속성    [ROW, COL,    DATATYPE,  WIDTH,  DATAALIGN,   COLMERGE, SAVENAME,         KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]                    
                    InitDataProperty(0, cnt++, 	  dtSeq,     30,     daCenter,    true,   "");                    
                    InitDataProperty(0, cnt++,    dtData,    60,     daCenter,    true,    "inv_ofc_cd",    false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    150,    daLeft,      false,   "inv_no",        false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    70,     daCenter,    false,   "curr_cd",       false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    90,     daRight,     true,    "ttl_inv_amt",   false,    "",    dfFloat,   2,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    90,     daCenter,    false,   "rcv_dt",        false,    "",    dfDateYmd, 0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    90,     daCenter,    false,   "cre_dt",        false,    "",    dfDateYmd, 0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    80,     daCenter,    false,   "cre_usr_id",    false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    240,    daLeft,      false,   "cre_usr_nm",    false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    60,     daCenter,    true,    "tml_inv_sts_cd",false,    "",    dfNone,    0,    true,    true);
                    
                    ToolTipOption = "balloon:true; width:420; backcolor:#ffffff; forecolor:#14358B; icon:0;";                    
//                  CountPosition = 0;
                }
                break;

             case 2:      //sheet2 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 190;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 5, 100);

                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(10, 0, 0, true);

                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);
                    
                    var HeadTitle0 = "S/N|CSR\nOffice|CSR|CSR|CSR|Payment S/P|CSR Date|CSR User|CSR User|CSR\nStatus";
                    var HeadTitle1 = "S/N|CSR\nOffice|Number|Currency|Amount|Payment S/P|CSR Date|ID|Name|CSR\nStatus";
                    // 헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(1, HeadTitle1, true);

                    // 데이터속성    [ROW, COL,  DATATYPE,  WIDTH, DATAALIGN, COLMERGE,     SAVENAME,       KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, 	  dtSeq,     30,     daCenter,    true,   "");                    
                    InitDataProperty(0, cnt++,    dtData,    60,     daCenter,    true,    "inv_ofc_cd",      false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    150,    daCenter,    false,   "csr_no",          false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    70,     daCenter,    false,   "csr_curr_cd",     false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    90,     daRight,     false,   "csr_amt",         false,    "",    dfFloat,   2,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    240,    daLeft,      true,    "pay_sp",          false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    80,     daCenter,    true,    "cre_dt",          false,    "",    dfDateYmd, 0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    80,     daCenter,    false,   "cre_usr_id",      false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    150,    daLeft,      false,   "cre_usr_nm",      false,    "",    dfNone,    0,    true,    true);
                    InitDataProperty(0, cnt++,    dtData,    60,     daLeft,      true,    "if_status",       false,    "",    dfNone,    0,    true,    true);

//                  CountPosition = 0;
                }
                break;
        }
    }
  	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
  	document.onclick = processButtonClick;

  	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */	
  	function processButtonClick(){
 			
  		try {
  			var srcName = window.event.srcElement.getAttribute("name");

  			switch(srcName) {
				case "btn_close":
					InitWinTopPendingTESWin();
					window.close();
					break;	
  				
  			} // end switch
  		}catch(e) {			
  			if( e == "[object Error]") {
  				ComShowMessage(getMsg('COM12111'));
  			} else {
  				ComShowMessage(e);
  			}
  		}
  	}
  	
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, frmObj, sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

            case SEARCH01:      //조회
                if (validateForm(sheetObj, frmObj, sAction)) {
                    sheetObjects[0].WaitImageVisible = false;
                    sheetObjects[1].WaitImageVisible = false;
                    ComOpenWait(true);

                    frmObj.f_cmd.value = SEARCH09;
                    var xml = sheetObj.GetSearchXml("ESD_TES_9310GS.do", FormQueryString(frmObj));
                    
                    var rtnValue = xml.split("|$$|");                  
                    
                    sheetObjects[0].LoadSearchXml(rtnValue[0]);
                    sheetObjects[1].LoadSearchXml(rtnValue[1]);
                    
                    //if(rtnValue[1].indexOf("TR")==-1 && rtnValue[2].indexOf("TR")==-1){
                    //	self.close();
                    //}
                }
                break;

        }
    }

    /**
     * Sheet1의 OnSearchEnd 이벤트 처리
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        ComOpenWait(false);
        sheetObjects[1].WaitImageVisible = true;
        sheetObjects[0].WaitImageVisible = true;
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, frmObj, sAction) {
        with (frmObj) {
        }
        return true;
    }
    
  	function InitWinTopPendingTESWin(){
        try {
            // window.opener.top.document.PendingTESWin = false;
            Set_Cookie( "PendingTESWin", "N", 1, "", "", "" )
            
            
            // 하루에 한번만 열리기 OFC_CD , USER 별
            var formObject = document.form;
            var cookieKey = "TES9310OpenToday" + "_" + formObject.inv_ofc_cd.value + "_" + formObject.inv_usr_id.value;
            Set_Cookie( cookieKey, "Y", 1, "", "", "" )
            //alert("setCookie=" + cookieKey);
        } catch(e){}
    }
  	
  	
  	function sheet1_OnSort(sheetObj, Col, SortArrow) {
  		for(i=0; i<sheetObj.RowCount; i++){
  			sheetObj.CellText(i+2,0) = i+1;
  		}
  	}

  	function sheet2_OnSort(sheetObj, Col, SortArrow) {
  		for(i=0; i<sheetObj.RowCount; i++){
  			sheetObj.CellText(i+2,0) = i+1;
  		}
  	}
  	
/* 개발자 작업  끝 */
