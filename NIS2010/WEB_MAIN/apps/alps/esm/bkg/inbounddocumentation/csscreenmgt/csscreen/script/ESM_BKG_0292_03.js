/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0292_03.js
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 안진응
*@LastVersion : 1.0
* 2009.06.16 안진응
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
     * @class esm_bkg_0292_03 : esm_bkg_0292_03 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0292_03() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.setTabObject           = setTabObject;
        this.validateForm           = validateForm;
    }

    /* 개발자 작업  */

    // 공통전역변수

    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var t4sheet1 = 0;
    var t4sheet2 = 1;
    var t4sheet3 = 2;
    var t4sheet4 = 3;
    
    var comboFlg = null;
    var cntrQtySum = 0;
    var frt_term_cd = null;
    
    var previewSheet = 1;

     /**
      * IBSheet Object를 배열로 등록<br>
      * @param sheet_obj IBSheet Object
      * @return void
      * @author An JinEung
      * @version 2009.11.01
      **/
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }

     /**
      * Sheet 기본 설정 및 초기화<br>
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      * @param {void}
      * @return void
      * @author An JinEung
      * @version 2009.11.01
      **/
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            
        	if (sheetObjects[i].id == "t4sheet4") {
                initSheet(sheetObjects[i],i+1);
        	} else {
            	ComConfigSheet (sheetObjects[i] );

                initSheet(sheetObjects[i],i+1);

                ComEndConfigSheet(sheetObjects[i]);        		
        	}
        }
        
//        document.form.bkg_no.value = "SGNY1030003";
        
        if (document.form.bkg_no.value != "") {
        	fnSearch();
        }        
    }
         
     /**
      * 시트 초기설정값, 헤더 정의<br>
      * @param sheetObj IBSheet Object
      * @param sheetNo  IBSheet의 순서
      * @return void
      * @author An JinEung
      * @version 2009.11.01
      **/
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
        var prefix = "";
        var sheetID = sheetObj.id;
        
        switch(sheetID) {        
            case "t4sheet1":      //t4sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 100;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    var HeadTitle = "|Seq.|Container No.|TP/SZ|Bound|S/O\nRequire|S/O\nIssued|POD|DEL|Delivery\nTerm|Last S/O Status";
                    var headCount = ComCountHeadTitle(HeadTitle);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, false, true, true, false,false);                    

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    var prefix = "t4sheet1_";
                    
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,      30,    daCenter,  false,   prefix +"ibflag");
                    InitDataProperty(0, cnt++ , dtSeq,               30,    daCenter,  false,   prefix +"Seq");
                    InitDataProperty(0, cnt++ , dtData,              100,   daCenter,  false,   prefix +"cntr_no",          false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              50,    daCenter,  false,   prefix +"cntr_tpsz_cd",     false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              50,    daCenter,  false,   prefix +"bnd_cd",           false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,            70,    daCenter,  false,   prefix +"req_cnt",          false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              70,    daCenter,  false,   prefix +"iss_cnt",          false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              90,    daCenter,  false,   prefix +"pod_cd",           false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              90,    daCenter,  false,   prefix +"del_cd",           false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              70,    daCenter,  false,   prefix +"de_term_cd",       false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              80,    daCenter,  false,   prefix +"sts_cd",           false,      "",      dfNone,      0,     false,       false);

                    CountPosition = 0;

                }
                break;                    
            case "t4sheet2":      //t4sheet2 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 100;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
    
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;
    
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;
    
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    var HeadTitle = "|TP/SZ|CNTR Q'ty|Hidden\nColumn";
                    var headCount = ComCountHeadTitle(HeadTitle);
    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
    
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, false, true, true, false,false)
    
    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
    
                    prefix = "t4sheet2_";
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,  0,    daCenter,    true,     prefix + "ibflag");
                    InitDataProperty(0, cnt++ , dtData,         50,    daCenter,    false,    prefix + "cntr_tpsz_cd",     false,          "",      dfNone,      0,     false);
                    InitDataProperty(0, cnt++ , dtData,         70,    daCenter,    false,    prefix + "cntr_qty",         false,          "",      dfNullFloat, 2,     false);
                    InitDataProperty(0, cnt++ , dtHidden,       70,    daCenter,    false,    prefix + "hidden",           false,          "",      dfNullFloat, 2,     false);
                        
                    CountPosition = 0;
                       
                    ScrollBar = 2;
                }
                break;
            case "t4sheet3":      //t4sheet3 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 240;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    var HeadTitle = "|Seq.|S/P Code|S/P Name|S/P Tel No|Cost Mode|From-To|S/O Status|Office|User ID|S/O No|S/O Date|W/O No|W/O Date|Container No.";
                    var headCount = ComCountHeadTitle(HeadTitle);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 8, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, false, true, true, false,false);                    

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    var prefix = "t4sheet3_";
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,      0,     daCenter,    true,        prefix + "ibflag");
                    InitDataProperty(0, cnt++ , dtSeq,               30,    daCenter,    false,       prefix + "Seq");
                    InitDataProperty(0, cnt++ , dtData,              70,    daCenter,    false,       prefix + "sp_code",         false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              130,   daCenter,    false,       prefix + "sp_name",         false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              80,    daCenter,    false,       prefix + "sp_tel_no",       false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              80,    daCenter,    false,       prefix + "cost_mode",       false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              120,   daCenter,    false,       prefix + "nod_cd",          false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              70,    daCenter,    false,       prefix + "sts_cd",          false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              60,    daCenter,    false,       prefix + "ofc_cd",          false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              70,    daCenter,    false,       prefix + "usr_id",          false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              80,    daCenter,    false,       prefix + "so_no",           false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              110,   daCenter,    false,       prefix + "so_date",         false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              80,    daCenter,    false,       prefix + "wo_no",           false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              110,   daCenter,    false,       prefix + "wo_date",         false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    false,       prefix + "cntr_no",         false,      "",      dfNone,      0,     false,       false);

                    CountPosition = 0;

                    WordWrap = true;
                    
                    ToolTipOption="balloon:true;width:320;forecolor:#0000FF;icon:1";
                }
                break;
                    
            case "t4sheet4":      //t4sheet4 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
    
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;
    
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;
    
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);
    
                    var HeadTitle = "|Seq.|S/P Code|S/P Name|S/P Tel No|Cost Mode|From-To|S/O Status|Office|User ID|S/O No|S/O Date|W/O No|W/O Date|Container No.|User Name";
                    var headCount = ComCountHeadTitle(HeadTitle);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
    
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, false, true, true, false,false);                    
    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
    
                    var prefix = "t4sheet4_";
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,      0,     daCenter,    true,        prefix + "ibflag");
                    InitDataProperty(0, cnt++ , dtSeq,               30,    daCenter,    false,       prefix + "Seq");
                    InitDataProperty(0, cnt++ , dtData,              70,    daCenter,    false,       prefix + "sp_code",          false,      "",      dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,              80,    daCenter,    false,       prefix + "sp_name",          false,      "",      dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,              80,    daCenter,    false,       prefix + "sp_tel_no",        false,      "",      dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,              60,    daCenter,    false,       prefix + "cost_mode",        false,      "",      dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,              120,   daCenter,    false,       prefix + "nod_cd",           false,      "",      dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,              70,    daCenter,    false,       prefix + "sts_cd",           false,      "",      dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,              60,    daCenter,    false,       prefix + "ofc_cd",           false,      "",      dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,              60,    daCenter,    false,       prefix + "usr_id",           false,      "",      dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,              70,    daCenter,    false,       prefix + "so_no",            false,      "",      dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,              100,   daCenter,    false,       prefix + "so_date",          false,      "",      dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,              70,    daCenter,    false,       prefix + "wo_no",            false,      "",      dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,              100,   daCenter,    false,       prefix + "wo_date",          false,      "",      dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    false,       prefix + "cntr_no",          false,      "",      dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    false,       prefix + "usr_nm",           false,      "",      dfNone,      0,     true,       true);
    
                    CountPosition = 0;
                }
                break;
                    
//            case "sheet2":
//                with (sheetObj) {
//                    // 높이 설정
//                    style.height = 0;
//                    //전체 너비 설정
//                    SheetWidth = mainTable.clientWidth;
//
//                    //Host정보 설정[필수][HostIp, Port, PagePath]
//                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
//
//                    //전체Merge 종류 [선택, Default msNone]
//                    MergeSheet = msHeaderOnly;
//
//                    //전체Edit 허용 여부 [선택, Default false]
//                    Editable = true;
//
//                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
//                    InitRowInfo( 1, 1, 3, 100);
//
//                    var HeadTitle = "ibflag|partial|bl_no|bkg_no|split_no|bl_tp_cd";
//                    var headCount = ComCountHeadTitle(HeadTitle);
//                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
//                    InitColumnInfo(headCount, 0, 0, true);
//
//                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
//                    InitHeadMode(true, false, true, true, false,false)
//
//                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
//                    InitHeadRow(0, HeadTitle, true);
//
//                    prefix = "sheet2_";
//                    
//                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//                    InitDataProperty(0, cnt++ , dtHiddenStatus,     30, daCenter,  true,     prefix + "ibflag");
//                    InitDataProperty(0, cnt++ , dtData,             50, daCenter,  false,    prefix + "partial",            false,          "",      dfNone,      0,     false);
//                    InitDataProperty(0, cnt++ , dtData,             50, daCenter,  false,    prefix + "bl_no",              false,          "",      dfNone,      0,     false);
//                    InitDataProperty(0, cnt++ , dtData,             30, daCenter,  false,    prefix + "bkg_no",             false,          "",      dfNone,      0,     false);
//                    InitDataProperty(0, cnt++ , dtData,             30, daCenter,  false,    prefix + "split_flg",          false,          "",      dfNone,      0,     false);
//                    InitDataProperty(0, cnt++ , dtData,             30, daCenter,   false,   prefix + "bl_tp_cd",           false,          "",     dfNone,         0,      false,      true);
//                    
//                    CountPosition = 0;
//                }
//                break;
        }
    }

    /**
     * Sheet관련 프로세스 처리<br>
     * @param sheetObj IBSheet Object
     * @param formObj  UI 화면의 Object
     * @param sAction  IBSEARCH - 조회, COMMAND01, COMMAND02, COMMAND04
     * @return void
     * @author An JinEung
     * @version 2009.11.01
     **/
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
        switch(sAction) {

            case IBSEARCH:      //조회
            	sheetObjects[t4sheet1].WaitImageVisible = false;
            	
            	formObj.f_cmd.value = SEARCH;
                var aryPrefix = new Array("t4sheet1_", "t4sheet2_", "t4sheet4_"); //prefix 문자열 배열
                var sXml = sheetObj.GetSearchXml("ESM_BKG_0292_03GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
                
                var arrXml = sXml.split("|$$|");

                sheetObjects[t4sheet1].Redraw = false;
                sheetObjects[t4sheet1].WaitImageVisible = false;                            
                sheetObjects[t4sheet1].LoadSearchXml(arrXml[0]);
                sheetObjects[t4sheet1].Redraw = true;

                sheetObjects[t4sheet2].Redraw = false;
                sheetObjects[t4sheet2].WaitImageVisible = false;                            
                sheetObjects[t4sheet2].LoadSearchXml(arrXml[1]);
                sheetObjects[t4sheet2].Redraw = true;

                sheetObjects[t4sheet4].Redraw = false;
                sheetObjects[t4sheet4].WaitImageVisible = false;                            
                sheetObjects[t4sheet4].LoadSearchXml(arrXml[2]);
                sheetObjects[t4sheet4].Redraw = true;
                
                sheetObjects[t4sheet1].WaitImageVisible = true;

                ComOpenWait(false);
                
                break;
        }
    }
        
     /**
      * t4sheet4의 조회가 완료된 시점에 값을 설정한다.
      * t4sheet4의 값이 존재하는 경우, t4sheet1 첫번째 Row의 Container에 해당하는 정보를 t4sheet4에서 읽어서 t4sheet3에 표시한다.
      * @param Object sheetObj IBSheet Object
      * @param Object ErrMsg   에러메시지
      * @return void
      * @author An JinEung
      * @version 2009.11.01
      **/
    function t4sheet4_OnSearchEnd(sheetObj, ErrMsg){
    	var cntrNo = null;
    	var emptyXml = "<SHEET>	<DATA  TOTAL='0'> </DATA> </SHEET>";
    	
        if (ErrMsg == "") {
             
         
         if(sheetObj.RowCount > 0){
                 cntrNo = sheetObjects[t4sheet1].CellValue(1, "t4sheet1_cntr_no");
                 
                 //t4sheet4에 값이 존재하는지를 체크한다. 값이 없는 경우에는 t4sheet3를 모두 지운다.
                 if (sheetObjects[t4sheet4].RowCount > 0) {
                     
                     copySoInfoDetail(cntrNo);
                 } else {
                     
//                     sheetObjects[t4sheet3].RemoveAll();
                	 sheetObjects[t4sheet3].LoadSearchXml(emptyXml);
                 }
            } else {
//            	sheetObjects[t4sheet3].RemoveAll();
            	sheetObjects[t4sheet3].LoadSearchXml(emptyXml);
            }
        }
    }

     /**
      * t4sheet1의 목록을 더블클릭할 때 발생하는 이벤트
      * @param Object  sheetObj IBSheet Object
      * @param Integer row      Row의 위치
      * @param Integer col      Col의 위치
      * @return void
      * @author An JinEung
      * @version 2009.11.01
      **/
    function t4sheet1_OnDblClick(sheetObj, row, col){
        if (sheetObj.RowCount > 0) {
         
            var cntrNo = sheetObj.CellValue(row, "t4sheet1_cntr_no");

            copySoInfoDetail(cntrNo);            
        }
    }

    /**
     * Container No를 비교하여 t4sheet4의 값을 t4sheet3로 이동한다.
     * @param String  cntrNo Container No.
     * @return void
     * @author An JinEung
     * @version 2009.11.01
     **/
    function copySoInfoDetail(cntrNo) {
         sheetObjects[t4sheet3].RemoveAll(); //모든 Row를 지운 후, 값을 비교하여 Container No가 일치하는 것만 넣어준다.
         
         var prefix1 = "t4sheet3_";
         var prefix2 = "t4sheet4_";
         var row = 0;
            for(i=0;i<sheetObjects[t4sheet4].RowCount;i++){
             if (sheetObjects[t4sheet4].CellValue(i+1,prefix2+ "cntr_no") == cntrNo) {
                 row = sheetObjects[t4sheet3].DataInsert(-1);            //마지막 열에 Row를 추가한다.
                 
                 sheetObjects[t4sheet3].CellValue2(row,prefix1+ "sp_code")       = sheetObjects[t4sheet4].CellValue(i+1,prefix2+ "sp_code"); 
                 sheetObjects[t4sheet3].CellValue2(row,prefix1+ "sp_name")       = sheetObjects[t4sheet4].CellValue(i+1,prefix2+ "sp_name"); 
                 sheetObjects[t4sheet3].CellValue2(row,prefix1+ "sp_tel_no")     = sheetObjects[t4sheet4].CellValue(i+1,prefix2+ "sp_tel_no"); 
                 sheetObjects[t4sheet3].CellValue2(row,prefix1+ "cost_mode")     = sheetObjects[t4sheet4].CellValue(i+1,prefix2+ "cost_mode"); 
                 sheetObjects[t4sheet3].CellValue2(row,prefix1+ "nod_cd")        = sheetObjects[t4sheet4].CellValue(i+1,prefix2+ "nod_cd"); 
                 sheetObjects[t4sheet3].CellValue2(row,prefix1+ "sts_cd")        = sheetObjects[t4sheet4].CellValue(i+1,prefix2+ "sts_cd"); 
                 sheetObjects[t4sheet3].CellValue2(row,prefix1+ "ofc_cd")        = sheetObjects[t4sheet4].CellValue(i+1,prefix2+ "ofc_cd"); 
                 sheetObjects[t4sheet3].CellValue2(row,prefix1+ "usr_id")        = sheetObjects[t4sheet4].CellValue(i+1,prefix2+ "usr_id"); 
                 sheetObjects[t4sheet3].CellValue2(row,prefix1+ "so_no")         = sheetObjects[t4sheet4].CellValue(i+1,prefix2+ "so_no"); 
                 sheetObjects[t4sheet3].CellValue2(row,prefix1+ "so_date")       = sheetObjects[t4sheet4].CellValue(i+1,prefix2+ "so_date"); 
                 sheetObjects[t4sheet3].CellValue2(row,prefix1+ "wo_no")         = sheetObjects[t4sheet4].CellValue(i+1,prefix2+ "wo_no"); 
                 sheetObjects[t4sheet3].CellValue2(row,prefix1+ "wo_date")       = sheetObjects[t4sheet4].CellValue(i+1,prefix2+ "wo_date"); 
                 sheetObjects[t4sheet3].CellValue2(row,prefix1+ "cntr_no")       = sheetObjects[t4sheet4].CellValue(i+1,prefix2+ "cntr_no"); 
                 
                 sheetObjects[t4sheet3].ToolTipText(row,prefix1+ "usr_id")       = sheetObjects[t4sheet4].CellValue(i+1, prefix2+ "usr_nm");
             }
        }
    }

     /**
      * t4sheet2의 조회가 완료된 시점에 값을 설정한다.
      * @param Object sheetObj IBSheet Object
      * @param Object ErrMsg   에러메시지
      * @return void
      * @author An JinEung
      * @version 2009.11.01
      **/
    function t4sheet2_OnSearchEnd(sheetObj, ErrMsg){
       cntrQtySum = 0;
       
       if (ErrMsg == "") {
            if(sheetObj.RowCount > 0){
               for(var i=1; i<=sheetObj.RowCount; i++) {                   
                   //Bkg Qty와  Cntr Qty가 소수인 경우 연두색 굵은 문자로 설정한다. 102, 204, 0
                   if (isFloat(sheetObj.CellValue(i,"t4sheet2_cntr_qty")) == true) {
                       sheetObj.CellFont("FontBold", i, "t4sheet2_cntr_qty") = true;       //Bold 값을 설정
                       sheetObj.CellFontColor(i, "t4sheet2_cntr_qty" ) = sheetObj.RgbColor(255, 0, 0);     //연두색 설정
                   }
               }
            }
       }
    }


     /**
      * 화면의 버튼을 비 활성화 시킨다.
      * @param  void
      * @return void
      * @author An JinEung
      * @version 2009.11.01
      **/
    function buttonColorSet(btn_name, color){
        var tds = document.getElementsByTagName("td");
        var curFlag = null;
     
        if (color == 'red') {
    	    curFlag = "hand";
        } else {
    	    curFlag = "default";
        }
     
        for(var i = 0; i < tds.length; i++) {
            var td=tds[i];

            if(td.name == '•' + btn_name){
           	    td.style.color = color;
           	    td.style.cursor = curFlag;
           	 
           	if (btn_name == "btn_split") {
           	    document.form.h_split.value = color;
           	}
                break;
            }else if(td.name == btn_name){
           	    td.style.color = color;
           	    td.style.cursor = curFlag;
           	 
           	    if (btn_name == "btn_split") {
           		    document.form.h_split.value = color;
           	    }
                break;
            }else{
           	    continue;
            }
        }
    }
       
     /**
      * t4sheet1의 조회가 완료된 시점에 값을 설정한다.
      * @param Object sheetObj IBSheet Object
      * @param Object ErrMsg   에러메시지
      * @return void
      * @author An JinEung
      * @version 2009.11.01
      **/
    function t4sheet1_OnSearchEnd(sheetObj, ErrMsg){
    	if (ErrMsg != "") {
        	fnSoInfoClear();
        }
    }

    /**
     * S/O Info의 값을 Clear한다.
     * @param  void
     * @return void
     * @author An JinEung
     * @version 2009.11.01
     **/
    function fnSoInfoClear() {
    	sheetObjects[t4sheet1].RemoveAll();
    	sheetObjects[t4sheet2].RemoveAll();
    	sheetObjects[t4sheet3].RemoveAll();
    	sheetObjects[t4sheet4].RemoveAll();
    }
    
    /**
     * 화면의 조회 처리 모듈을 통합적으로 관리한다.
     * @param  void
     * @return void
     * @author An JinEung
     * @version 2009.11.01
     **/
    function fnSearch() {
    	
    	fnSoInfoClear();
    	
    	doActionIBSheet(sheetObjects[t4sheet1],document.form,IBSEARCH,"","");
    }
    
    /**
     * Float 여부를 체크한다.
     * @param  Object  fVal 체크할 값
     * @return Boolean True - Float, False - Float가 아님
     * @author An JinEung
     * @version 2009.11.01
     **/
    function isFloat(fVal) {
    	var temp = 0;
    	var sVal = null;
    	
    	
    	var sIdx = fVal.toString().indexOf(".");
    	
    	if (sIdx > 0) {
	    	var sTemp = fVal.toString();
    		
    		sVal = sTemp.substring(parseInt(sIdx) + 1);
	    	
	    	if (parseInt(sVal) > 0 ) {
	    		return true;
	    	} else {
	    		return false;
	    	}
    	} else {
    		return false;
    	}
    }
    
    function fnQueryExec(bkg_no) {
    	if (bkg_no != "") {         	
      		document.form.bkg_no.value = bkg_no;
      		fnSearch();
        }     	
    }     
   
//    /**
//    * t4sheet1의 조회가 완료된 시점에 값을 설정한다.
//    * t4sheet3의 값이 존재하는 경우, t4sheet1 첫번째 Row의 Container에 해당하는 정보를 t4sheet3에 표시한다.
//    * @param Object sheetObj IBSheet Object
//    * @param Object ErrMsg   에러메시지
//    * @return void
//    * @author An JinEung
//    * @version 2009.11.01
//    **/
//    function t4sheet3_OnSearchEnd(sheetObj, ErrMsg){    
//    	var prefix = "t4sheet3_";
//    	if (sheetObj.RowCount > 0) {
//            for(i=0;i<sheetObj.RowCount;i++){
//            	sheetObj.ToolTipText(i+1, prefix+ "usr_id")       = sheetObj.CellValue(i+1, prefix+ "usr_nm");
//            }
//    		
//    		var fist_cntr_no = sheetObjects[t4sheet1].CellValue(1, "t4sheet1_cntr_no");
//	
//    		fnRowDisplay(fist_cntr_no);
//    	}
//    }
//    
//    /**
//    * 인수로 받은 Container에 해당하는 정보를 t4sheet3에 표시한다.
//    * @param String fist_cntr_no
//    * @return void
//    * @author An JinEung
//    * @version 2009.11.01
//    **/     
//    function fnRowDisplay(fist_cntr_no) {
//		var sheetObj = sheetObjects[t4sheet3];
//   	
//		for(var idx=1; idx <= sheetObj.RowCount; idx++){
//	        //INVOICE 정보 중 첫 번째 컨테이너 번호에 매치 되는 해당 정보만 보이도록  나머지 로우는 히든 처리
//	        if(fist_cntr_no != sheetObj.CellValue(idx, "t4sheet3_cntr_no")){
//	        	sheetObj.RowHidden(idx) = true;
//	        } else {
//	        	sheetObj.RowHidden(idx) = false;
//	        }
//	    }
//   }    
    /* 개발자 작업  끝 */