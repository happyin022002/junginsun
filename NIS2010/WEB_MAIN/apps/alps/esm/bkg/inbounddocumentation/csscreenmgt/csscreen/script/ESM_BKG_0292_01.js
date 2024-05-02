/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0292_01.js
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
     * @class esm_bkg_0292_01 : esm_bkg_0292_01 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0292_01() {
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
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;

    var comboObjects = new Array();
    var comboCnt = 0;
    
    // sheet를 관리하는 변수값
    var t2sheet1 = 0;
    var t2sheet2 = 1;
    var t2sheet3 = 2;
    
    var comboFlg = null;
    var cntrQtySum = 0;
    var frt_term_cd = null;
    
    var previewSheet = 1;
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러<br>
     * @param {void}
     * @return void
     * @author An JinEung
     * @version 2009.11.01
     **/
    function processButtonClick(){
             
        var param = null;
        var sc_no = null;
        var cntr_no = null;
        
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            //비활성화되었다면 리턴
            if(!ComIsBtnEnable(srcName)){
                return;
            }

            switch(srcName) {
                case "btn_Cop":
                	if (sheetObjects[t2sheet1].RowCount == 0) return;
                	
                	cntr_no = sheetObjects[t2sheet1].CellValue(sheetObjects[t2sheet1].SelectRow, "t2sheet1_cntr_no");

                	param="?pgmNo=ESD_SCE_0001&cntr_no="+cntr_no;
                    
//                	ComOpenWindow("/hanjin/ESD_SCE_0001.do"+param, "myWin", "scroll:no;status:no;help:no;dialogWidth:1024px;dialogHeight:650px;dialogLeft:0;dialogTop:0", true);
                	ComOpenWindowCenter("/hanjin/ESD_SCE_0001.do"+param, "myWin", 1024, 650, true);
                	break;
                case "btn_Movement":
                	if (sheetObjects[t2sheet1].RowCount == 0) return;
                	
                	cntr_no = sheetObjects[t2sheet1].CellValue(sheetObjects[t2sheet1].SelectRow, "t2sheet1_cntr_no").substring(0,10);
                	var check = sheetObjects[t2sheet1].CellValue(sheetObjects[t2sheet1].SelectRow, "t2sheet1_cntr_no").substring(10);
                	var tpsz_cd = sheetObjects[t2sheet1].CellValue(sheetObjects[t2sheet1].SelectRow, "t2sheet1_tpsz_cd");

                	
                	var fromDate = "";
                	var toDate = ComGetNowInfo();
                	
                	if (sheetObjects[t2sheet2].RowCount > 0) {
                   		fromDate = ComGetMaskedValue(sheetObjects[t2sheet2].Cellvalue(sheetObjects[t2sheet2].RowCount , "t2sheet2_event_dt").substring(0,8), "ymd");
                	} else {
                		fromDate = toDate ;
                	}
                  	param="?p_cntrno=" + cntr_no + "&" + "check_digit=" + check + "&" + "ctnr_tpsz_cd=" + tpsz_cd + "&pgmNo=EES_CTM_0408&pop_mode=1";
                               
              //    param="?p_cntrno=" + cntr_no + "&" + "p_date1=" + fromDate + "&" + "p_date2=" + toDate+ "&" + "check_digit=" + check + "&" + "ctnr_tpsz_cd=" + tpsz_cd + "&pgmNo=EES_CTM_0408&pop_mode=1";
                       	
                	ComOpenWindowCenter("/hanjin/EES_CTM_0408.do" + param, "EES_CTM_0408", 1020, 682, true);

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
            
        	if (sheetObjects[i].id == "t2sheet3") {
                initSheet(sheetObjects[i],i+1);
        		
        	} else {
            	ComConfigSheet (sheetObjects[i] );

                initSheet(sheetObjects[i],i+1);

                ComEndConfigSheet(sheetObjects[i]);
        	}
        }
        
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
            case "t2sheet1":      //t2sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 120;
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

                    var HeadTitle = "|Seq.|Container No.|Size|Last Event(VVD)|Date|Place(Node Code)|ACT NM";
                    var headCount = ComCountHeadTitle(HeadTitle);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, false, false, true, false,false)


                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    var prefix="t2sheet1_";

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,      30,    daCenter,  false,   prefix +"ibflag");
                    InitDataProperty(0, cnt++ , dtSeq,               40,    daCenter,  true,    prefix +"Seq");
                    InitDataProperty(0, cnt++ , dtData,              110,   daCenter,  false,   prefix +"cntr_no",       false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              100,   daCenter,  false,   prefix +"tpsz_cd",       false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              300,   daCenter,  false,   prefix +"lst_event",     false,          "",      dfNone,        0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              130,   daCenter,  false,   prefix +"event_dt",      false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              250,   daLeft,    false,   prefix +"nod_cd",        false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,  false,   prefix +"act_nm",        false,          "",      dfNone,      0,     false,       false);

                    WordWrap = true;
               	}
                break;

            case "t2sheet2":      //t2sheet2 init
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
                    var HeadTitle = "||Event Date|Activity|Location|VVD|Seal No.|MSG|B/L No.|Update Date|Container No.|Focus Flg";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, false, false, true, false,false)


                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    var prefix="t2sheet2_";

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,      30,    daCenter,  false,   prefix +"ibflag");
                    InitDataProperty(0, cnt++ , dtData,              80,    daCenter,  false,   prefix +"sts_nm",     false,          "",      dfNone,              0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              100,   daCenter,  false,   prefix +"event_dt",   false,          "",      dfUserFormat2,       0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              190,   daCenter,  false,   prefix +"act_nm",     false,          "",      dfNone,              0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              80,    daCenter,  false,   prefix +"loc_cd",     false,          "",      dfNone,              0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              110,   daCenter,  false,   prefix +"vvd",        false,          "",      dfNone,              0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              100,   daCenter,  false,   prefix +"seal_no",    false,          "",      dfNone,              0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              60,    daCenter,  false,   prefix +"msg",        false,          "",      dfNone,              0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              100,   daCenter,   false,   prefix +"bl_no",     false,          "",      dfNone,              0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              100,   daCenter,  false,   prefix +"upd_dt",     false,          "",      dfUserFormat2,       0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,  false,   prefix +"cntr_no",    false,          "",      dfNone,              0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,  false,   prefix +"fcus_flg",   false,          "",      dfNone,              0,     false,       false);

                                        
//                    CountPosition = 0;
                    
                    InitUserFormat2(0, prefix +"event_dt", "####-##-## ##:##", "-|:" );
                    InitUserFormat2(0, prefix +"upd_dt", "####-##-## ##:##", "-|:" );
               	}
                break;
            case "t2sheet3":      //t2sheet3 init
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
	                var HeadTitle = "||Event Date|Activity|Location|VVD|Seal No.|MSG|B/L No.|Update Date|Container No.|Focus Flg";
	                var headCount = ComCountHeadTitle(HeadTitle);
	    
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 0, 0, true);
	    
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, false, false, true, false,false)
	    
	    
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle, true);
	    
	                var prefix="t2sheet3_";
	    
	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,      30,    daCenter,  false,   prefix +"ibflag");
	                InitDataProperty(0, cnt++ , dtData,              90,    daCenter,  false,   prefix +"sts_nm",     false,          "",      dfNone,              0,     false,       false);
	                InitDataProperty(0, cnt++ , dtData,              120,   daCenter,  false,   prefix +"event_dt",   false,          "",      dfUserFormat2,       0,     false,       false);
	                InitDataProperty(0, cnt++ , dtData,              220,   daCenter,  false,   prefix +"act_nm",     false,          "",      dfNone,              0,     false,       false);
	                InitDataProperty(0, cnt++ , dtData,              110,   daCenter,  false,   prefix +"loc_cd",     false,          "",      dfNone,              0,     false,       false);
	                InitDataProperty(0, cnt++ , dtData,              110,   daCenter,  false,   prefix +"vvd",        false,          "",      dfNone,              0,     false,       false);
	                InitDataProperty(0, cnt++ , dtData,              100,   daCenter,  false,   prefix +"seal_no",    false,          "",      dfNone,              0,     false,       false);
	                InitDataProperty(0, cnt++ , dtData,              80,    daCenter,  false,   prefix +"msg",        false,          "",      dfNone,              0,     false,       false);
	                InitDataProperty(0, cnt++ , dtData,              100,   daCenter,  false,   prefix +"bl_no",      false,          "",      dfNone,              0,     false,       false);
	                InitDataProperty(0, cnt++ , dtData,              100,   daCenter,  false,   prefix +"upd_dt",     false,          "",      dfUserFormat2,       0,     false,       false);
	                InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,  false,   prefix +"cntr_no",    false,          "",      dfNone,              0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,  false,   prefix +"fcus_flg",   false,          "",      dfNone,              0,     false,       false);
	                            
	    
	                InitUserFormat2(0, prefix +"event_dt", "####-##-## ##:##", "-|:" );
	                InitUserFormat2(0, prefix +"upd_dt", "####-##-## ##:##", "-|:" );
	    
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
//                    InitDataProperty(0, cnt++ , dtData,             30, daCenter,  false,    prefix + "bl_tp_cd",           false,          "",      dfNone,         0,      false,      true);
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
            	ComOpenWait(true);
            	
            	sheetObjects[t2sheet1].WaitImageVisible = false;
            	
            	formObj.f_cmd.value = SEARCH;
                var aryPrefix = new Array("t2sheet1_", "t2sheet3_"); //prefix 문자열 배열
                var sXml = sheetObj.GetSearchXml("ESM_BKG_0292_01GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));

                var arrXml = sXml.split("|$$|");

                sheetObjects[t2sheet1].Redraw = false;
                sheetObjects[t2sheet1].WaitImageVisible = false;
                sheetObjects[t2sheet1].LoadSearchXml(arrXml[0]);
                sheetObjects[t2sheet1].Redraw = true;

                sheetObjects[t2sheet3].Redraw = false;
                sheetObjects[t2sheet3].WaitImageVisible = false;
                sheetObjects[t2sheet3].LoadSearchXml(arrXml[1]);
                sheetObjects[t2sheet3].Redraw = true;
                
                sheetObjects[t2sheet1].WaitImageVisible = true;
                    
	            break;
        }
    }
        
    /**
     * t2sheet1의 조회가 완료된 시점에 값을 설정한다.
     * t2sheet3의 값이 존재하는 경우, t2sheet3 첫번째 Row의 Container에 해당하는 정보를 t2sheet3에서 읽어서 t2sheet2에 표시한다.
     * @param Object sheetObj IBSheet Object
     * @param Object ErrMsg   에러메시지
     * @return void
     * @author An JinEung
     * @version 2009.11.01
     **/
    function t2sheet3_OnSearchEnd(sheetObj, ErrMsg){
        var cntrNo = null;
        var emptyXml = "<SHEET>	<DATA  TOTAL='0'> </DATA> </SHEET>";
        
        if (ErrMsg == "") {
            
            
            if(sheetObj.RowCount > 0){
                cntrNo = sheetObjects[t2sheet1].CellValue(1, "t2sheet1_cntr_no");
                
                //t2sheet3에 값이 존재하는지를 체크한다. 값이 없는 경우에는 t2sheet2를 모두 지운다.
                if (sheetObjects[t2sheet3].RowCount > 0) {
                    
                    copyMovementDetail(cntrNo);
                } else {                    
//                    sheetObjects[t2sheet2].RemoveAll();
                	sheetObjects[t2sheet2].LoadSearchXml(emptyXml);
                }
            } else {
//                sheetObjects[t2sheet2].RemoveAll();
            	sheetObjects[t2sheet2].LoadSearchXml(emptyXml);
            }
        }
    }
    
     /**
      * t2sheet1의 목록을 더블클릭할 때 발생하는 이벤트
      * @param Object  sheetObj IBSheet Object
      * @param Integer row      Row의 위치
      * @param Integer col      Col의 위치
      * @return void
      * @author An JinEung
      * @version 2009.11.01
      **/
    function t2sheet1_OnDblClick(sheetObj, row, col){
        if (sheetObj.RowCount > 0) {
            
            var cntrNo = sheetObj.CellValue(row, "t2sheet1_cntr_no");

            copyMovementDetail(cntrNo);         
//            fnRowDisplay(cntrNo);
        }
    }
    
    
    /**
     * Container No를 비교하여 t2sheet3의 값을 t2sheet2로 이동한다.
     * @param String  cntrNo Container No.
     * @return void
     * @author An JinEung
     * @version 2009.11.01
     **/
    function copyMovementDetail(cntrNo) {
        sheetObjects[t2sheet2].RemoveAll(); //모든 Row를 지운 후, 값을 비교하여 Container No가 일치하는 것만 넣어준다.
        
        var prefix7 = "t2sheet2_";
        var prefix8 = "t2sheet3_";
        var row7 = 0;
        
        var fcusRow = 0;
        
        for(i=0;i<sheetObjects[t2sheet3].RowCount;i++){
            if (sheetObjects[t2sheet3].CellValue(i+1,prefix8+ "cntr_no") == cntrNo) {
                row7 = sheetObjects[t2sheet2].DataInsert(-1);           //마지막 열에 Row를 추가한다.

                sheetObjects[t2sheet2].CellValue2(row7,prefix7+ "sts_nm")     = sheetObjects[t2sheet3].CellValue(i+1,prefix8+ "sts_nm"); 
                sheetObjects[t2sheet2].CellValue2(row7,prefix7+ "event_dt")   = sheetObjects[t2sheet3].CellValue(i+1,prefix8+ "event_dt"); 
                sheetObjects[t2sheet2].CellValue2(row7,prefix7+ "act_nm")     = sheetObjects[t2sheet3].CellValue(i+1,prefix8+ "act_nm"); 
                sheetObjects[t2sheet2].CellValue2(row7,prefix7+ "loc_cd")     = sheetObjects[t2sheet3].CellValue(i+1,prefix8+ "loc_cd"); 
                sheetObjects[t2sheet2].CellValue2(row7,prefix7+ "vvd")        = sheetObjects[t2sheet3].CellValue(i+1,prefix8+ "vvd"); 
                sheetObjects[t2sheet2].CellValue2(row7,prefix7+ "seal_no")    = sheetObjects[t2sheet3].CellValue(i+1,prefix8+ "seal_no"); 
                sheetObjects[t2sheet2].CellValue2(row7,prefix7+ "msg")        = sheetObjects[t2sheet3].CellValue(i+1,prefix8+ "msg"); 
                sheetObjects[t2sheet2].CellValue2(row7,prefix7+ "bl_no")      = sheetObjects[t2sheet3].CellValue(i+1,prefix8+ "bl_no"); 
                sheetObjects[t2sheet2].CellValue2(row7,prefix7+ "upd_dt")     = sheetObjects[t2sheet3].CellValue(i+1,prefix8+ "upd_dt"); 
                sheetObjects[t2sheet2].CellValue2(row7,prefix7+ "cntr_no")    = sheetObjects[t2sheet3].CellValue(i+1,prefix8+ "cntr_no"); 
                sheetObjects[t2sheet2].CellValue2(row7,prefix7+ "fcus_flg")   = sheetObjects[t2sheet3].CellValue(i+1,prefix8+ "fcus_flg");
                
                if (sheetObjects[t2sheet3].CellValue(i+1,prefix8+ "fcus_flg") == "Y") {
                	fcusRow = row7;
                }
                
                if (sheetObjects[t2sheet3].CellValue(i+1,prefix8+ "sts_nm") != "Actual") {
                    sheetObjects[t2sheet2].RowBackColor(row7) = sheetObjects[t2sheet2].RgbColor(102, 204, 0);
                }
            }
        }

        sheetObjects[t2sheet2].SelectRow = fcusRow;
    }

    /**
     * t2sheet1의 조회가 완료된 시점에 값을 설정한다.
     * @param Object sheetObj IBSheet Object
     * @param Object ErrMsg   에러메시지
     * @return void
     * @author An JinEung
     * @version 2009.11.01
     **/
    function t2sheet1_OnSearchEnd(sheetObj, ErrMsg){
        
    	ComOpenWait(false);
    	
    	if (ErrMsg != "") {
            fnMovementClear();
        }
        
        if (sheetObj.RowCount > 0) {
        	buttonColorSet("btn_Cop", 'red');
        	buttonColorSet("btn_Movement", 'red');
      	} else {
        	buttonColorSet("btn_Cop", 'gray');
        	buttonColorSet("btn_Movement", 'gray');
        }
    }

    /**
     * Movement의 값을 Clear한다.
     * @param  void
     * @return void
     * @author An JinEung
     * @version 2009.11.01
     **/
    function fnMovementClear() {
    	sheetObjects[t2sheet1].RemoveAll();
    	sheetObjects[t2sheet2].RemoveAll();
    	sheetObjects[t2sheet3].RemoveAll();
    }
    
    /**
     * 화면의 조회 처리 모듈을 통합적으로 관리한다.
     * @param  void
     * @return void
     * @author An JinEung
     * @version 2009.11.01
     **/
    function fnSearch() {
    	fnMovementClear();
    	doActionIBSheet(sheetObjects[t2sheet1],document.form,IBSEARCH,"","");
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
     
    function fnQueryExec(bkg_no) {
    	if (bkg_no != "") {
        	
    		document.form.bkg_no.value = bkg_no;
    		fnSearch();
        }     	
    }
    
//    /**
//     * t2sheet1의 조회가 완료된 시점에 값을 설정한다.
//     * t2sheet2의 값이 존재하는 경우, t2sheet1 첫번째 Row의 Container에 해당하는 정보를 t2sheet2에 표시한다.
//     * @param Object sheetObj IBSheet Object
//     * @param Object ErrMsg   에러메시지
//     * @return void
//     * @author An JinEung
//     * @version 2009.11.01
//     **/
//    function t2sheet2_OnSearchEnd(sheetObj, ErrMsg){    
//    	var prefix = "t2sheet2_";
//    	if (sheetObj.RowCount > 0) {
//    		//조회된 데이터의 색상을 표시한다.
//    		
//    		for(i=0;i<sheetObj.RowCount;i++){
//                if (sheetObj.CellValue(i+1,prefix+ "sts_nm") != "Actual") {
//                	sheetObj.RowBackColor(i+1) = sheetObj.RgbColor(102, 204, 0);
//                }
//            }
//    		
//    		var fist_cntr_no = sheetObjects[t2sheet1].CellValue(1, "t2sheet1_cntr_no");
//	
//    		fnRowDisplay(fist_cntr_no);
//    	}
//    }
//     
//    /**
//     * 인수로 받은 Container에 해당하는 정보를 t2sheet2에 표시한다.
//     * @param String fist_cntr_no
//     * @return void
//     * @author An JinEung
//     * @version 2009.11.01
//     **/     
//    function fnRowDisplay(fist_cntr_no) {
//    	var sheetObj = sheetObjects[t2sheet2];
//    	var fcusRow = 0;
//    	
//    	for(var idx=1; idx <= sheetObj.RowCount; idx++){
// 	        //INVOICE 정보 중 첫 번째 컨테이너 번호에 매치 되는 해당 정보만 보이도록  나머지 로우는 히든 처리
// 	        if(fist_cntr_no != sheetObj.CellValue(idx, "t2sheet2_cntr_no")){
// 	        	sheetObj.RowHidden(idx) = true;
// 	        } else {
// 	        	sheetObj.RowHidden(idx) = false;
// 	        	
// 	            if (sheetObj.CellValue(idx, "t2sheet2_fcus_flg") == "Y") {
// 	            	fcusRow = idx;
// 	            } 	        	
// 	        }
// 	    }
//    	
//    	sheetObj.SelectRow = fcusRow;
//    }
    /* 개발자 작업  끝 */