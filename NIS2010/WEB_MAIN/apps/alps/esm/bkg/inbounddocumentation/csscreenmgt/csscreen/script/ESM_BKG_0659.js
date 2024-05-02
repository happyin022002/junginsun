/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0659.js
*@FileTitle : DG Cargo Detail Pop-up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.07
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.05.07 박미옥
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
     * @class esm_bkg_0659 : esm_bkg_0659 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0659() {
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
     * 
     * @return 없슴
     * @author 박미옥
     * @version 2009.07.09
     */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1 = sheetObjects[0];
        /*******************************************************/
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

                case "btn_close":
                    window.close();
                    break;
                                    
            } // end switch
        } catch(e) {
            if ( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }
    }


    /**
     * IBSheet Object를 배열로 등록<br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
     * 배열은 소스 상단에 정의 <br>
     * 
     * @param {IBSheet} sheet_obj 필수, IBSheet 컨트롤
     * @return 없슴
     * @author 박미옥
     * @version 2009.07.09
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;                        
    }


    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다 <br>
     * 
     * @return 없슴
     * @author 박미옥
     * @version 2009.07.09
     */
    function loadPage() {

        for (var i=0;i<sheetObjects.length;i++) {

            ComConfigSheet(sheetObjects[i]);

            initSheet(sheetObjects[i],i+1);

            ComEndConfigSheet(sheetObjects[i]);
        }

        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
     


    /**
     * 시트 초기설정값, 헤더 정의<br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * 
     * @param {ibsheet} sheetObj 필수, IBSheet 오브젝트
     * @param {number}  sheetNo  필수, IBSheet 오브젝트 일련번호
     * @return 없슴
     * @author 박미옥
     * @version 2009.07.09
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 220;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll;

                    //전체Edit 허용 여부 [선택, Default false]
                    //Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(8, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    // ([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D])
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "Seq.|IMO \nClass|UN No.|Proper Shipping Name|Hazardous Contents|Save ID|File Path|Attach \nFile";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    // ([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,   60,    daCenter,   true,   "cntr_cgo_seq", false,  "",        dfNone,       0,      false,       false,      0,       false,     true);
                    InitDataProperty(0, cnt++ , dtData,   70,    daCenter,   true,   "imdg_clss_cd", false,  "",        dfNone,       0,      false,       false,      0,       false,     true);
                    InitDataProperty(0, cnt++ , dtData,   60,    daCenter,   true,   "imdg_un_no",   false,  "",        dfNone,       0,      false,       false,      0,       false,     false);
                    InitDataProperty(0, cnt++ , dtData,   200,   daLeft,     true,   "prp_shp_nm",   false,  "",        dfNone,       0,      false,       false,      0,       false,     false);
                    InitDataProperty(0, cnt++ , dtData,   200,   daLeft,     true,   "hzd_desc",     false,  "",        dfNone,       0,      false,       false,      0,       false,     false);
                    InitDataProperty(0, cnt++ , dtHidden, 50,    daLeft,     false,  "file_sav_id",  false,  "",        dfNone,       0,      false,       false,      0,       false,     false);
                    InitDataProperty(0, cnt++ , dtHidden, 100,   daLeft,     false,  "file_path_rmk",false,  "",        dfNone,       0,      false,       false,      0,       false,     false);
                    InitDataProperty(0, cnt++ , dtData,   150,   daLeft,     false,  "file_nm",      false,  "",        dfNone,       0,      false,       false,      0,       false,     false);

                    DataLinkMouse("file_nm") = true;
                    
                    ShowButtonImage = 2;
               }
               
               break;
        }
    }


    /**
     * Sheet관련 프로세스 처리 <br>
     * 
     * @param {ibsheet} sheetObj 필수,IBSheet 오브젝트
     * @param {object}  formObj  필수,HTML Form 오브젝트
     * @param {string}  sAction  필수,Action 명 
     * @return 없슴
     * @author 박미옥
     * @version 2009.07.09
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
        
        sheetObj.WaitImageVisible = false;
        
        switch(sAction) {

            case IBSEARCH:      //조회
            	if(!validateForm(sheetObj,formObj,sAction)) return;
            	
                ComOpenWait(true);
            
            	formObj.f_cmd.value = SEARCH;
                // (PageUrl, [CondParam], [PageParam], [IsAppend], [AppendRow])                	
            	sheetObj.DoSearch("ESM_BKG_0659GS.do", FormQueryString(formObj));
            	
            	ComOpenWait(false);
            	
                break;
        }
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * 
     * @param {ibsheet} sheetObj 필수,IBSheet 오브젝트
     * @param {object}  formObj  필수,HTML Form 오브젝트
     * @param {string}  sAction  필수,Action 명 
     * @return boolean Form 오브젝트 유효성 여부를 반환한다. 유효한 경우 true,  아닌 경우 false
     * @author 박미옥
     * @version 2009.07.09
     */
    function validateForm(sheetObj,formObj,sAction){
        switch(sAction) {
        //조회
        case IBSEARCH:
        	//1.기본체크-maxlength,필수입력 등 폼 전체 필드의 Validation 체크
        	if (!ComChkValid(formObj)) return false;

        	//2.업무체크-업무에서 필요한 Validation 체크
        	with(formObj) {
            }

        	break;
        }

        return true;
    }

    

    /**
     * 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event 처리 <br>
     * 
     * @param {ibsheet} sheetObj 필수,IBSheet 오브젝트
     * @param {int}     Row      필수,IBSheet Row
     * @param {int}     Col      필수,IBSheet Column
     * @param {string}  Value    필수,IBSheet Row, Col 해당 값
     * @return 없슴
     * @author 박미옥
     * @version 2009.07.09
     */
    function sheet1_OnClick(sheetObj,Row,Col,Value){
    	with(sheetObj) {
        	switch (ColSaveName(Col)) {
        	case "file_nm":
        		// 첨부파일이 있는 경우 파일 오픈
        		if (CellValue(Row, "file_sav_id") != "") {
            		location.href = "/hanjin/FileDownload?key="+CellValue(Row, "file_sav_id");
        		}

        		break;
        	}
    	}
    }


    /**
     * 조회 함수를 이용하여 조회가 완료되고 발생하는 Event 처리 <br>
     * 
     * @param {ibsheet} sheetObj 필수,IBSheet 오브젝트
     * @param {string}  ErrMsg   선택,에러 메시지
     * @return 없슴
     * @author 박미옥
     * @version 2009.07.09
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        with(sheetObj) {
        	var idx = 0;
            for (var i=0; i<RowCount; i++) {
            	idx = i+1;
            	// 첨부파일 여부 체크
            	// 첨부파일이 없는 경우 파일팝업 연결을 Disable 시킨다.(링크 해제시킴)
                if (CellValue(idx,"file_sav_id") != "") {
                	InitCellProperty(idx, "file_nm", dtPopup);
                }
            }
        }
    }

    
	/* 개발자 작업  끝 */