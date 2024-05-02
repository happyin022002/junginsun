/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6013_03.js
*@FileTitle : S/C Quotation Rate Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.08.12 이승준
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
     * @class ESM_PRI_6013_03 : ESM_PRI_6013_03 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_6013_03() {
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
    var tabObjects = new Array();
    var tabCnt = 0;
    var beforetab = 1;
    
    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var tabLoad = new Array();
    tabLoad[0] = 0;
    tabLoad[1] = 0;
    
    var LoadingComplete = false;
    
    var arrTermOrg = new Array();
    var arrTermDest = new Array();
    var arrTransMode = new Array();
    
    var isOViaMandatory = false;
    var isDViaMandatory = false;
    var isDirCallVisible = false;
    
    //rout delete row
    var isDelete = false;
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
    
    /**
	  * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	  * <br><b>Example :</b>
	  * <pre>
	  *     processButtonClick();
	  * </pre>
	  * @return 없음
	  * @author 이승준
	  * @version 2009.04.17
	  */
    function processButtonClick() {
        /** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
    
        var sheetObject1 = sheetObjects[0];
    
        /** **************************************************** */
        var formObject = document.form;
    
        try {
            var srcName = window.event.srcElement.getAttribute("name");
      
            switch (srcName) {
            case "btn_Retrieve":
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
                break;
    
            case "gen_spcl_rt_tp_cd_radio":
				obj_click();
				break;   
                
            case "btn_All":
//            	if (validateForm(sheetObjects[9],document.form,IBSEARCH_ASYNC02)) {
	            	var sUrl = "/hanjin/ESM_PRI_6035.do?";
					sUrl += "qttn_no=" + formObject.qttn_no.value;
					sUrl += "&qttn_ver_no=" + formObject.qttn_ver_no.value; 
//					alert(sUrl)
					ComPriOpenWindowCenter(sUrl, "ESM_PRI_6035", 1000, 528, true);
//            	}
                break;
              
                
            } // end switch
        } catch (e) {
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }
    }
    
    /**
     * IBSheet Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj 필수 IBSheet Object
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */ 
    function setSheetObject(sheet_obj) {
        sheetObjects[sheetCnt++] = sheet_obj;
    }
    
    /**
     * Sheet 기본 설정 및 초기화 <br>
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     loadPage();
     * </pre>
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function loadPage() {
        for (var i = 0; i < sheetObjects.length; i++) {
            // khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
    
            initSheet(sheetObjects[i], i + 1);
            // khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        var iWidth = window.document.body.clientWidth;
        
//        if(iWidth > 1024) {
        	sheetColResize();
//        }
    }
    
    
    /**
     * LoadFinish 이벤트 시 발생한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function sheet4_OnLoadFinish(sheetObj) {
	   	sheetObj.WaitImageVisible = false; 
	   	doActionIBSheet(sheetObj, document.form, IBCLEAR);
	   	toggleButtons("CLEAR");
	    parent.loadTabPage();
//	   	sheetObj.WaitImageVisible = true; 
    }
    
    
    /**
     * 시트 초기설정값, 헤더 정의 <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function initSheet(sheetObj, sheetNo) {
    
        var cnt = 0;
        var sheetID = sheetObj.id;
        switch (sheetID) {
        case "sheet1":  // Grid 1
            with (sheetObj) {
                // 높이 설정
                style.height = 204;
                // 전체 너비 설정
//                SheetWidth = mainTable.clientWidth;
                SheetWidth = 260;
    
                // Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "")
                    InitHostInfo(location.hostname, location.port, page_path);
    
                // 전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;
    
                // 전체Edit 허용 여부 [선택, Default false]
                Editable = false;
    
                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 3, 100);
    
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(9, 0, 0, true);
    
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false, false)
    
                var HeadTitle = "|Seq.|Commodity Group|Commodity Group|qttn_no|qttn_ver_no|gen_spcl_rt_tp_cd|cmdt_hdr_seq|src_info_cd";
    
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
    
                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtDataSeq, 40, daCenter, false, "seq");
                InitDataProperty(0, cnt++, dtData,    180, daCenter, false, "prc_cmdt_def_cd", 	false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden,  180, daLeft, false, "prc_cmdt_def_nm", 	false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden,  90,  daLeft, false, "qttn_no", 		 	false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden,  90,  daLeft, false, "qttn_ver_no", 		false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden,  90,  daLeft, false, "gen_spcl_rt_tp_cd",  false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden,  90,  daLeft, false, "cmdt_hdr_seq", 		false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden,  90,  daLeft, false, "src_info_cd", 		false, "", dfNone, 0, false, false);
                
                Ellipsis = true;
                ShowButtonImage = 2;
                CountPosition = 0;
                ImageList(0) = "img/btns_calendar.gif";
//                ColHidden("del_chk") = true;
                WaitImageVisible = false;
            }
            break;
    
        case "sheet2":  // Grid 2
            with (sheetObj) {
                // 높이 설정
                style.height = 204;
                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;
    
                // Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "")
                    InitHostInfo(location.hostname, location.port, page_path);
    
                // 전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;
    
                // 전체Edit 허용 여부 [선택, Default false]
                Editable = false;
    
                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 3, 100);
    
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(12, 0, 0, true);
    
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false, false)
    
                var HeadTitle = "|Seq.|qttn_no|qttn_ver_no|gen_spcl_rt_tp_cd|cmdt_hdr_seq|rout_seq|Origin|O.Via|D.Via|Dest.|D/Call";
    
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
    
                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
//                InitDataProperty(0, cnt++, dtDataSeq, 35, daCenter, false, "seq");
                InitDataProperty(0, cnt++, dtData,   40, daCenter, false, "rn",    false,"",dfNone,0,false,	false);	
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "qttn_no", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "qttn_ver_no", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "gen_spcl_rt_tp_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "cmdt_hdr_seq", false, "", dfNone, 0, false, false);        
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "rout_seq", false, "", dfNone, 0, false, false);        
                InitDataProperty(0, cnt++, dtData, 104, daCenter, false, "org_rout_pnt_loc_def_cd", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtData, 104, daCenter, false, "org_rout_via_port_def_cd", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtData, 104, daCenter, false, "dest_rout_via_port_def_cd", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtData, 104, daCenter, false, "dest_rout_pnt_loc_def_cd", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtCheckBox, 42, daCenter, false, "dir_call_flg", false, "", dfNone, 0, true, true, -1, false, true, "", false);
                
                Ellipsis = true;
                ShowButtonImage = 2;
                CountPosition = 0;
//                ColHidden("del_chk") = true;
                WaitImageVisible = false;
                
            }
            break;
    
        case "sheet3":  // Grid 3 description
        	with (sheetObj) {
                // 높이 설정
                style.height = 84;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 15, 100);

                var HeadTitle1  = "|Sel.|Seq.|Commodity Group|Origin|Origin Via|Destination Via|Destination";
				var headCount = ComCountHeadTitle(HeadTitle1);
                
				 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);

                //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,		DATAALIGN, COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC,	
                //DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtDummyCheck, 40, daCenter, false, "chk");
                InitDataProperty(0, cnt++, dtDataSeq, 40, daCenter, false, "seq");
                InitDataProperty(0, cnt++ , dtData,	185,	daLeft,	true,  "prc_cmdt_def_nm",			false,	"",	dfNone,0,false,	false);	
				InitDataProperty(0, cnt++ , dtData,	185,	daLeft,	true,  "org_rout_pnt_loc_def_nm",	false,	"",	dfNone,0,false,	false);	
				InitDataProperty(0, cnt++ , dtData,	185,	daLeft,	true,  "org_rout_via_port_def_nm",	false,	"",	dfNone,0,false,	false);	
				InitDataProperty(0, cnt++ , dtData,	185,	daLeft,	true,  "dest_rout_via_port_def_nm",	false,	"",	dfNone,0,false,	false);	
				InitDataProperty(0, cnt++ , dtData,	185,	daLeft,	true,  "dest_rout_pnt_loc_def_nm",	false,	"",	dfNone,0,false,	false);	
				
				Ellipsis = true;
//				WordWrap = true;
				CountPosition = 0;
				ColHidden("chk") = true;
				ColHidden("seq") = true;
				//Editable  = false;
				SelectHighLight = false;
				WaitImageVisible = false;
		    }
            break;
            
        case "sheet4":  // Grid 4 Rate
        	with (sheetObj) {
                // 높이 설정
                style.height = 152;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = false;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 15, 100);

                var HeadTitle1  = "|Seq.|Per|Cargo Type|Cur.|Quotation|Eff.Date|Exp.Date|Source|Rate Adjust";
				var headCount = ComCountHeadTitle(HeadTitle1);
                
				 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false, false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);

                //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,		DATAALIGN, COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC,	
                //DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 	30, daCenter,   false, "ibflag");
                InitDataProperty(0, cnt++, dtDataSeq, 		40, daCenter,   true,  "seq");
				InitDataProperty(0, cnt++ , dtCombo,		100,daCenter,	true,  "rat_ut_cd",		false,	"",	dfNone,	0,	true,	true);	
				InitDataProperty(0, cnt++ , dtCombo,		100,daCenter,	true,  "prc_cgo_tp_cd",	false,	"",	dfNone,	0,	true,	true);	
				InitDataProperty(0, cnt++ , dtCombo,		100,daCenter,	true,  "curr_cd",		false,	"",	dfNone,	0,	true,	true);	
				InitDataProperty(0, cnt++ , dtData,			160,daRight,	true,  "qttn_rt_amt",	false,	"",	dfFloat,2,	true,	true);	
				
				InitDataProperty(0, cnt++ , dtData,			120,daCenter,	true,  "eff_dt",		false,	"",	dfNone,	0,	false,	false);	
				InitDataProperty(0, cnt++ , dtData,			120,daCenter,	true,  "exp_dt",		false,	"",	dfNone,	0,  false,	false);
				InitDataProperty(0, cnt++ , dtData,			120,daCenter,	true,  "src_info_nm",  	false,	"",	dfNone ,0,	false,	false);
				InitDataProperty(0, cnt++ , dtData,			120,daRight,	true,  "rate_adjust",  	false,	"",	dfFloat ,2,	false,	false);
				
                ShowButtonImage = 2;
                CountPosition = 0;
                WaitImageVisible = false;
		    }
            break;
            
            
        case "sheet5":  // commodity
            with (sheetObj) {
                // 높이 설정
                style.height = 100;
                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;
    
                // Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "")
                    InitHostInfo(location.hostname, location.port, page_path);
    
                // 전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;
    
                // 전체Edit 허용 여부 [선택, Default false]
                Editable = true;
    
                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 3, 100);
    
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(10, 0, 0, true);
    
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false, false)
    
                var HeadTitle = "5-1|5-2|5-3|5-4|cmdt_hdr_seq|cmdt_seq|prc_cmdt_tp_cd|prc_cmdt_def_cd|5-9|5-10";
    
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
    
                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtStatus, 30, daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "qttn_no", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "qttn_ver_no", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "gen_spcl_rt_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);        
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "cmdt_seq", true, "", dfNone, 0, false, false);     
                
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_cmdt_tp_cd", 	false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_cmdt_def_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_cmdt_def_nm", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "src_info_cd", true, "", dfNone, 0, false, false);  
                WaitImageVisible = false;
            }
            break;   
        
    	case "sheet6":  // point origin
            with (sheetObj) {
                // 높이 설정
                style.height = 100;
                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;
    
                // Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "")
                    InitHostInfo(location.hostname, location.port, page_path);
    
                // 전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;
    
                // 전체Edit 허용 여부 [선택, Default false]
                Editable = true;
    
                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 3, 100);
    
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(18, 0, 0, true);
    
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false, false)
    
                var HeadTitle = "|Sel.|Seq.|1|2|3|4|5|6|7|Location Type|Location Code|Description|src_info_cd|display_seq|Term|rcv_de_term_nm|Trans. Mode";
    
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
    
                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtStatus, 30,  daCenter,	false, "ibflag");
				InitDataProperty(0, cnt++ , dtData,	  40,  daCenter,	false, "chk");
				InitDataProperty(0, cnt++ , dtData,	  40,  daCenter,	false, "seq", false, "", dfNone, 0,	true, true);
                
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "qttn_no", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "qttn_ver_no", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gen_spcl_rt_tp_cd", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cmdt_hdr_seq", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_seq", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_dest_tp_cd", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_seq", false, "", dfNone, 0, true, true);
					
				InitDataProperty(0, cnt++ , dtData, 105, daCenter,	false, "rout_pnt_loc_tp_cd",  true,	 "",	dfNone,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtData, 100, daCenter,	false, "rout_pnt_loc_def_cd", true,  "",	dfNone,	0,	true,	true, 5);
				InitDataProperty(0, cnt++ , dtData, 190, daLeft,	false, "rout_pnt_loc_def_nm", false, "",	dfNone,	0,	false,	false);
					
				InitDataProperty(0, cnt++ , dtData, 90,  daCenter,	false, "src_info_cd",	 	  false, "",	dfNone,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtData, 90,  daCenter,	false, "display_seq",	 	  false, "",	dfNone,	0,	true,	true);
					
				InitDataProperty(0, cnt++ , dtData, 90,  daCenter,	false, "rcv_de_term_cd",	  false, "",	dfNone,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtData, 90,  daCenter,	false, "rcv_de_term_nm",	  false, "",	dfNone,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtData, 90,  daCenter,	false, "prc_trsp_mod_cd",	  false, "",	dfNone,	0,	true,	true);
				WaitImageVisible = false;
            }
            break; 
            
            
		case "sheet7":  // via origin
            with (sheetObj) {
                // 높이 설정
                style.height = 100;
                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;
    
                // Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "")
                    InitHostInfo(location.hostname, location.port, page_path);
    
                // 전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;
    
                // 전체Edit 허용 여부 [선택, Default false]
                Editable = true;
    
                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 3, 100);
    
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(15, 0, 0, true);
    
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false, false)
    
                var HeadTitle = "|Sel.|Seq.|1|2|3|4|5|6|7|Location Type|Location Code|Description|src_info_cd|display_seq";
                 var headCount = ComCountHeadTitle(HeadTitle);
                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(headCount, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, true, true, true, false,false)

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle, true);


//               데이터속성           	 [ROW,		  COL,		  DATATYPE,   WIDTH,	  DATAALIGN,              
//	  				  			  COLMERGE,	  SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, 
//	  			  				  POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, 	  FULLINPUT, 
//	  				  			  SORTENABLE, TOOLTIP, 	  ALLCHECK,   SAVESTATUS, FORMATFIX] 
					InitDataProperty(0, cnt++ , dtStatus, 30,  daCenter,	false, "ibflag");
 					InitDataProperty(0, cnt++ , dtData,	    	40,  daCenter,	false, "chk");
 					InitDataProperty(0, cnt++ , dtData,			40,  daCenter,	false, "seq",			 false,	"",	dfNone,	0,	true,	true);

 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "qttn_no", false, "", dfNone, 0, true, true);
 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "qttn_ver_no", false, "", dfNone, 0, true, true);
 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gen_spcl_rt_tp_cd", false, "", dfNone, 0, true, true);
 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cmdt_hdr_seq", false, "", dfNone, 0, true, true);
 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_seq", false, "", dfNone, 0, true, true);
 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_dest_tp_cd", false, "", dfNone, 0, true, true);
 					InitDataProperty(0, cnt++, dtData,   100, daCenter, false, "rout_via_seq",  false, "", dfNone, 0, true, true);
					
					InitDataProperty(0, cnt++, dtData, 105, daCenter, false, "rout_via_port_tp_cd",  false, "", dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++, dtData, 85,  daCenter, false, "rout_via_port_def_cd", false, "", dfNone,	0,	false,	false, 5);
					InitDataProperty(0, cnt++, dtData, 120, daCenter, false, "rout_via_port_def_nm", false, "", dfNone,	0,	false,	false);
					
					InitDataProperty(0, cnt++ , dtData,    90,  daCenter,	false, "src_info_cd",	 	  false, "",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,  	 90,  daCenter,	false, "display_seq",	 	  false, "",	dfNone,	0,	true,	true);
					WaitImageVisible = false;
            }
            break; 
            
            
		case "sheet8":  // point via
            with (sheetObj) {
                // 높이 설정
                style.height = 100;
                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;
    
                // Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "")
                    InitHostInfo(location.hostname, location.port, page_path);
    
                // 전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;
    
                // 전체Edit 허용 여부 [선택, Default false]
                Editable = true;
    
                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 3, 100);
    
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(15, 0, 0, true);
    
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false, false)
    
                 var HeadTitle = "|Sel.|Seq.|1|2|3|4|5|6|7|Location Type|Location Code|Description|src_info_cd|display_seq";
                 var headCount = ComCountHeadTitle(HeadTitle);
                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(headCount, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, true, true, true, false,false)

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle, true);


//               데이터속성           	 [ROW,		  COL,		  DATATYPE,   WIDTH,	  DATAALIGN,              
//	  				  			  COLMERGE,	  SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, 
//	  			  				  POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, 	  FULLINPUT, 
//	  				  			  SORTENABLE, TOOLTIP, 	  ALLCHECK,   SAVESTATUS, FORMATFIX] 
					InitDataProperty(0, cnt++ , dtStatus, 30,  daCenter,	false, "ibflag");
 					InitDataProperty(0, cnt++ , dtData,	    	40,  daCenter,	false, "chk");
 					InitDataProperty(0, cnt++ , dtData,			40,  daCenter,	false, "seq",			 false,	"",	dfNone,	0,	true,	true);

 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "qttn_no", false, "", dfNone, 0, true, true);
 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "qttn_ver_no", false, "", dfNone, 0, true, true);
 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gen_spcl_rt_tp_cd", false, "", dfNone, 0, true, true);
 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cmdt_hdr_seq", false, "", dfNone, 0, true, true);
 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_seq", false, "", dfNone, 0, true, true);
 					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_dest_tp_cd", false, "", dfNone, 0, true, true);
 					InitDataProperty(0, cnt++, dtData,   100, daCenter, false, "rout_via_seq",  false, "", dfNone, 0, true, true);
					
					InitDataProperty(0, cnt++, dtData, 105, daCenter, false, "rout_via_port_tp_cd",  false, "", dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++, dtData, 85,  daCenter, false, "rout_via_port_def_cd", false, "", dfNone,	0,	false,	false, 5);
					InitDataProperty(0, cnt++, dtData, 120, daCenter, false, "rout_via_port_def_nm", false, "", dfNone,	0,	false,	false);
					
					InitDataProperty(0, cnt++ , dtData,    90,  daCenter,	false, "src_info_cd",	 	  false, "",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,  	 90,  daCenter,	false, "display_seq",	 	  false, "",	dfNone,	0,	true,	true);
					WaitImageVisible = false;
            }
            break;      
            
            
		case "sheet9":  // point dest
            with (sheetObj) {
                // 높이 설정
                style.height = 100;
                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;
    
                // Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "")
                    InitHostInfo(location.hostname, location.port, page_path);
    
                // 전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;
    
                // 전체Edit 허용 여부 [선택, Default false]
                Editable = true;
    
                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 3, 100);
    
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(18, 0, 0, true);
    
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false, false)
    
                var HeadTitle = "|Sel.|Seq.|1|2|3|4|5|6|7|Location Type|Location Code|Description|src_info_cd|display_seq|Term|rcv_de_term_nm|Trans. Mode";
        	    
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
    
                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtStatus, 30,  daCenter,	false, "ibflag");
				InitDataProperty(0, cnt++ , dtData,	    40,  daCenter,	false, "chk");
				InitDataProperty(0, cnt++ , dtData,			40,  daCenter,	false, "seq", false, "", dfNone, 0,	true, true);
                
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "qttn_no", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "qttn_ver_no", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gen_spcl_rt_tp_cd", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cmdt_hdr_seq", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_seq", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_dest_tp_cd", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_seq", false, "", dfNone, 0, true, true);
					
				InitDataProperty(0, cnt++ , dtData, 105, daCenter,	false, "rout_pnt_loc_tp_cd",  true,	 "",	dfNone,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtData, 100, daCenter,	false, "rout_pnt_loc_def_cd", true,  "",	dfNone,	0,	true,	true, 5);
				InitDataProperty(0, cnt++ , dtData, 190, daLeft,	false, "rout_pnt_loc_def_nm", false, "",	dfNone,	0,	false,	false);
					
				InitDataProperty(0, cnt++ , dtData, 90,  daCenter,	false, "src_info_cd",	 	  false, "",	dfNone,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtData, 90,  daCenter,	false, "display_seq",	 	  false, "",	dfNone,	0,	true,	true);
					
				InitDataProperty(0, cnt++ , dtData, 90,  daCenter,	false, "rcv_de_term_cd",	  false, "",	dfNone,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtData, 90,  daCenter,	false, "rcv_de_term_nm",	  false, "",	dfNone,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtData, 90,  daCenter,	false, "prc_trsp_mod_cd",	  false, "",	dfNone,	0,	true,	true);
				WaitImageVisible = false;
            }
            break;
       
        }
    }
    
    
    /**
     * description sheet에서 전체로우의 데이터가 없는 경우 row delete.<br>
     * <br><b>Example :</b>
     * <pre>
     *    deleteRowEmpty(sheetObj, Row)
     * </pre>
     * @param {sheetObj} sheetObj    
     * @param {int} Row  
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
    function deleteRowEmpty(sheetObj, Row) {
 		
 		if(ComIsEmpty(sheetObj.CellValue(Row,"prc_cmdt_def_nm")) &&		
     		   ComIsEmpty(sheetObj.CellValue(Row,"org_rout_pnt_loc_def_nm")) &&
     		   ComIsEmpty(sheetObj.CellValue(Row,"org_rout_via_port_def_nm")) &&
     		   ComIsEmpty(sheetObj.CellValue(Row,"dest_rout_via_port_def_nm")) &&
     		   ComIsEmpty(sheetObj.CellValue(Row,"dest_rout_pnt_loc_def_nm")) ) {
     			
 			sheetObj.RowDelete(Row, false);
     	}
 	}
    
   
   
    /**
     * sheet에서 조회가 끝난 후 호출됨.<br>
     * 각 히든 sheet에서 decription sheet로 decription을 세팅함<br>
     * <br><b>Example :</b>
     * <pre>
     *    sheet5_OnSearchEnd(sheetObj, ErrMsg)
     * </pre>
     * @param {sheetObj} sheetObj    
     * @param {String} ErrMsg  
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function sheet5_OnSearchEnd(sheetObj, ErrMsg) {
 		if (ErrMsg == "") {
//        	sXmlContents += ComPriSheet2XmlContent(sheetObj, "prc_cmdt_def_nm");
//        	if (contentXml.length > 2) {
 			
 				sheetObjects[2].RemoveAll();
        		
	        	var arrData  = new Array();
	        	var arrXml = ComPriSheet2Xml(sheetObj, "prc_cmdt_def_nm");
	        	arrData = ComPriXml2Array(arrXml, "prc_cmdt_def_nm");

	        	if(typeof arrData != "undefined") {
//	        		sheetObjects[2].RemoveAll();
	        		
	        		for(var i=1; i<=sheetObjects[2].RowCount; i++) {
		        		
		        		sheetObjects[2].CellValue2(i+1,"prc_cmdt_def_nm") = "";
		        		
		        		deleteRowEmpty(sheetObjects[2], i+1);
		        	}
	        		
	        		var insertRow = 0;
		        	for(var i=0; i<arrData.length; i++) {
		        		var insertCount = arrData.length - sheetObjects[2].RowCount;
		        		
		        		//키값이 같은 것만 걸른다	
		        		if (sheetObj.CellValue(i+1, "qttn_no") == sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "qttn_no")
		                        && sheetObj.CellValue(i+1, "qttn_ver_no") == sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "qttn_ver_no")
		                        && sheetObj.CellValue(i+1, "gen_spcl_rt_tp_cd") == sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "gen_spcl_rt_tp_cd")
		                        && sheetObj.CellValue(i+1, "cmdt_hdr_seq") == sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "cmdt_hdr_seq")) {
		        				        			
		        			if(insertCount > 0 ) {
		        				insertRow++;
			        			sheetObjects[2].DataInsert();
			        			
			        		}
		        			if(insertRow == 0) continue;
			        		sheetObjects[2].CellValue2(insertRow,"prc_cmdt_def_nm") = arrData[i];
		        		}
		        		
		        		insertCount--;
		        		
		         		
		        	}
		        	//sheetObjects[2].CellValue(1,"vsl_slan_cd") = vsl_slan_cd;
	        	}
//        	}	
//	        	sheetObjects[2].SelectCell(1,"prc_cmdt_def_nm");
        }
    }
 	
 	/**
     * sheet에서 조회가 끝난 후 호출됨.<br>
     * 각 히든 sheet에서 decription sheet로 decription을 세팅함<br>
     * <br><b>Example :</b>
     * <pre>
     *    sheet6_OnSearchEnd(sheetObj, ErrMsg)
     * </pre>
     * @param {sheetObj} sheetObj    
     * @param {String} ErrMsg  
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function sheet6_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
//        	sXmlContents += ComPriSheet2XmlContent(sheetObj, "org_rout_pnt_loc_def_nm");
//        	if (contentXml.length > 3) {
        		
	        	var arrData  = new Array();
	        	var arrXml = ComPriSheet2Xml(sheetObj, "rout_pnt_loc_def_nm|rcv_de_term_nm");
	        	arrData = ComPriXml2Array(arrXml, "rout_pnt_loc_def_nm|rcv_de_term_nm");

	        	if(typeof arrData != "undefined" && arrData != null) {
//	        		sheetObjects[2].RemoveAll();
	        		
	        		for(var i=1; i<=sheetObjects[2].RowCount; i++) {
		        		
		        		sheetObjects[2].CellValue2(i+1,"org_rout_pnt_loc_def_nm") = "";
		        		
		        		deleteRowEmpty(sheetObjects[2], i+1);
		        	}
	        		
	        		var rcv_de_term_nm = "";

		        	for(var i=0; i<arrData.length; i++) {
		        		var insertCount = arrData.length - sheetObjects[2].RowCount;

		        		if(insertCount > 0) {
		        			sheetObjects[2].DataInsert();
		        			insertCount--;
		        		}
		        		//rcv_de_term_nm
		        		if(arrData[i][1] != "" && arrData[i][1] != null && arrData[i][1] != "undefined") 
		        			rcv_de_term_nm = "(" + arrData[i][1] + ")";
		        		
		        			sheetObjects[2].CellValue2(i+1,"org_rout_pnt_loc_def_nm") = arrData[i][0] + rcv_de_term_nm;
		        			
		        		
		        	}
		        	//sheetObjects[2].CellValue(1,"vsl_slan_cd") = vsl_slan_cd;
	        	}
//	        	sheetObjects[2].SelectCell(1,"org_rout_pnt_loc_def_nm");
//        	}	
        }
    }
 	
 	/**
     * sheet에서 조회가 끝난 후 호출됨.<br>
     * 각 히든 sheet에서 decription sheet로 decription을 세팅함<br>
     * <br><b>Example :</b>
     * <pre>
     *    sheet7_OnSearchEnd(sheetObj, ErrMsg)
     * </pre>
     * @param {sheetObj} sheetObj    
     * @param {String} ErrMsg  
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function sheet7_OnSearchEnd(sheetObj, ErrMsg) {
 		if (ErrMsg == "") {
//        	sXmlContents += ComPriSheet2XmlContent(sheetObj, "org_rout_via_port_def_nm");
//        	if (contentXml.length > 4) {
        		
	        	var arrData  = new Array();
	        	var arrXml = ComPriSheet2Xml(sheetObj, "rout_via_port_def_nm");
	        	arrData = ComPriXml2Array(arrXml, "rout_via_port_def_nm");

	        	if(typeof arrData != "undefined") {
//	        		sheetObjects[2].RemoveAll();
	        		
	        		for(var i=1; i<=sheetObjects[2].RowCount; i++) {
		        		
		        		sheetObjects[2].CellValue2(i+1,"org_rout_via_port_def_nm") = "";
		        		
		        		deleteRowEmpty(sheetObjects[2], i+1);
		        	}
	        		
		        	for(var i=0; i<arrData.length; i++) {
		        		var insertCount = arrData.length - sheetObjects[2].RowCount;

		        		if(insertCount > 0) {
		        			sheetObjects[2].DataInsert();
		        			insertCount--;
		        		}
		        		sheetObjects[2].CellValue2(i+1,"org_rout_via_port_def_nm") = arrData[i];
		        	}
		        	//sheetObjects[2].CellValue(1,"vsl_slan_cd") = vsl_slan_cd;
	        	}
//	        	sheetObjects[2].SelectCell(1,"rout_via_port_def_nm");
//        	}	
        }
    }
 	
 	/**
     * sheet에서 조회가 끝난 후 호출됨.<br>
     * 각 히든 sheet에서 decription sheet로 decription을 세팅함<br>
     * <br><b>Example :</b>
     * <pre>
     *    sheet8_OnSearchEnd(sheetObj, ErrMsg)
     * </pre>
     * @param {sheetObj} sheetObj    
     * @param {String} ErrMsg  
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function sheet8_OnSearchEnd(sheetObj, ErrMsg) {
 		
	   	if (ErrMsg == "") {
//	    	sXmlContents += ComPriSheet2XmlContent(sheetObj, "dest_rout_via_port_def_nm");
//	    	if (contentXml.length > 5) {

	    		var arrData  = new Array();
	        	var arrXml = ComPriSheet2Xml(sheetObj, "rout_via_port_def_nm");
	        	arrData = ComPriXml2Array(arrXml, "rout_via_port_def_nm");

	        	if(typeof arrData != "undefined") {
//	        		sheetObjects[2].RemoveAll();
	        		
	        		for(var i=1; i<=sheetObjects[2].RowCount; i++) {
		        		
		        		sheetObjects[2].CellValue2(i+1,"dest_rout_via_port_def_nm") = "";
		        		
		        		deleteRowEmpty(sheetObjects[2], i+1);
		        	}
	        		
		        	for(var i=0; i<arrData.length; i++) {
		        		var insertCount = arrData.length - sheetObjects[2].RowCount;

		        		if(insertCount > 0) {
		        			sheetObjects[2].DataInsert();
		        			insertCount--;
		        		}
		        		sheetObjects[2].CellValue2(i+1,"dest_rout_via_port_def_nm") = arrData[i];
		        	}
		        	//sheetObjects[2].CellValue(1,"vsl_slan_cd") = vsl_slan_cd;
	        	}
//	        	sheetObjects[2].SelectCell(1,"rout_via_port_def_nm");
//        	}	
	    }
          
    }
 	
 	/**
     * sheet에서 조회가 끝난 후 호출됨.<br>
     * 각 히든 sheet에서 decription sheet로 decription을 세팅함<br>
     * <br><b>Example :</b>
     * <pre>
     *    sheet9_OnSearchEnd(sheetObj, ErrMsg)
     * </pre>
     * @param {sheetObj} sheetObj    
     * @param {String} ErrMsg  
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function sheet9_OnSearchEnd(sheetObj, ErrMsg) {
 		if (ErrMsg == "") {

        	//if (contentXml.length > 6) {

        		var arrData  = new Array();
	        	var arrXml = ComPriSheet2Xml(sheetObj, "rout_pnt_loc_def_nm|rcv_de_term_nm");
	        	arrData = ComPriXml2Array(arrXml, "rout_pnt_loc_def_nm|rcv_de_term_nm");
	        	
	        	if(typeof arrData != "undefined") {
	        		
//	        		sheetObjects[2].RemoveAll();
	        		
	        		for(var i=1; i<=sheetObjects[2].RowCount; i++) {
		        		
		        		sheetObjects[2].CellValue2(i+1,"dest_rout_pnt_loc_def_nm") = "";
		        		
		        		deleteRowEmpty(sheetObjects[2], i+1);
		        	}

		        	for(var i=0; i<arrData.length; i++) {
		        		var insertCount = arrData.length - sheetObjects[2].RowCount;

		        		if(insertCount > 0) {
		        			sheetObjects[2].DataInsert();
		        			insertCount--;
		        		}

		        		var rcv_de_term_nm = "";
		        		if(arrData[i][1] != "" && arrData[i][1] != null && arrData[i][1] != "undefined") 
		        			rcv_de_term_nm = "(" + arrData[i][1] + ")";
		        		
		        			sheetObjects[2].CellValue2(i+1,"dest_rout_pnt_loc_def_nm") = arrData[i][0] + rcv_de_term_nm;
		        	}
		        	//sheetObjects[2].CellValue(1,"vsl_slan_cd") = vsl_slan_cd;
	        	}
	        	
        	//}	
 		}		

 		sheetObjects[2].SelectCell(1,"seq");
// 		makeLoadXml(sheetObjects[2]);
    }
    
 	/**
     * SPACIAL/GERNERAL 라디오 버튼의 현재 세팅값을 세팅한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *    setGenSpclRtTpCd(formObj)
     * </pre>
     * @param {form} formObj    
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function setGenSpclRtTpCd(formObj) {
 		if (formObj.gen_spcl_rt_tp_cd_radio[0].checked == true){
 			formObj.gen_spcl_rt_tp_cd.value = formObj.gen_spcl_rt_tp_cd_radio[0].value;
        } else if(formObj.gen_spcl_rt_tp_cd_radio[1].checked == true) {
        	formObj.gen_spcl_rt_tp_cd.value = formObj.gen_spcl_rt_tp_cd_radio[1].value;
        }
 	}
 	
 	/**
     * SPACIAL/GERNERAL 라디오 버튼의 현재 세팅값을 리턴한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *    getGenSpclRtTpCd(formObj)
     * </pre>
     * @param {form} formObj    
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function getGenSpclRtTpCd(formObj) {
 		if (formObj.gen_spcl_rt_tp_cd_radio[0].checked == true){
        	return formObj.gen_spcl_rt_tp_cd_radio[0].value;
        } else if(formObj.gen_spcl_rt_tp_cd_radio[1].checked == true) {
        	return formObj.gen_spcl_rt_tp_cd_radio[1].value;
        }
 	}
 
 	/**
     * sheet에서 cell을 클릭한 경우 발생. <br>
     * <br><b>Example :</b>
     * <pre>
     *     sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} OldRow 
     * @param {int} OldCol 
     * @param {int} NewRow 
     * @param {int} NewCol 
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    	doRowChange1(OldRow, NewRow, OldCol, NewCol);
    }
    
    /**
     * sheet에서 cell을 클릭한 경우 발생. <br>
     * <br><b>Example :</b>
     * <pre>
     *     sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} OldRow 
     * @param {int} OldCol 
     * @param {int} NewRow 
     * @param {int} NewCol 
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
        doRowChange(OldRow, NewRow, OldCol, NewCol);
    }
    
    
    var isFiredNested = false;
    var supressConfirm = false;
    /**
     * sheet2_OnSelectCell 이벤트 발생시 호출됨. <br>
     * 선택된 로우에 대한 상세 정보를 조회한다.<br>
     * 
     * <br><b>Example :</b>
     * <pre>
     *     doRowChange(OldRow, NewRow, OldCol, NewCol, sAction)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} OldRow 
     * @param {int} OldCol 
     * @param {int} NewRow 
     * @param {int} NewCol 
     * @param {String} sAction
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function doRowChange(OldRow, NewRow, OldCol, NewCol, sAction) {
        var formObj = document.form;
       
        if (!isFiredNested && (OldRow != NewRow)) {
            
            LoadingComplete = false;
            formObj.rout_seq.value = sheetObjects[1].CellValue(NewRow, "rout_seq");
            doActionIBSheet(sheetObjects[3], document.form, IBSEARCH);
            LoadingComplete = true;
	       
        }
    }
    
    /**
     * sheet1_OnSelectCell 이벤트 발생시 호출됨. <br>
     * 선택된 로우에 대한 상세 정보를 조회한다.<br>
     * 
     * <br><b>Example :</b>
     * <pre>
     *     doRowChange1(OldRow, NewRow, OldCol, NewCol, sAction)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} OldRow 
     * @param {int} OldCol 
     * @param {int} NewRow 
     * @param {int} NewCol 
     * @param {String} sAction
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function doRowChange1(OldRow, NewRow, OldCol, NewCol, sAction) {
        var formObj = document.form;
    
        if (!isFiredNested && (OldRow != NewRow)) {
            
            formObj.cmdt_hdr_seq.value = sheetObjects[0].CellValue(NewRow, "cmdt_hdr_seq");
            formObj.src_info_cd.value = sheetObjects[0].CellValue(NewRow, "seq");
            doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
	        
        }
    }
    
    
    /**
     * radio버튼 click 이벤트 발생시 호출되는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *     
     * </pre>
     * @param 없음
     * @returns 없음
     * @author 이승준
     * @version 2009.04.17
     */ 	
 	function obj_click()
 	{	 		
 		var formObj = document.form;
 		//제너럴 스페셜 세팅
        setGenSpclRtTpCd(formObj);
        
 		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 	}
 	
 	
 	
 	/**
     * Sheet관련 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {form} formObj 필수 html form object
     * @param {int} sAction 필수 프로세스 플래그 상수
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;
        switch (sAction) {
        
        case IBCLEAR: // 화면 로딩시 
            sheetObj.WaitImageVisible = false;
            var sXml = "";
            var arrTemp;
            
         	//제너럴 스페셜 세팅
            setGenSpclRtTpCd(formObj);
            
            // per combo
            formObj.f_cmd.value = SEARCH03;
            formObj.etc5.value = "PRS";
            sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
//            setIBCombo(sheetObj, sXml, "rat_ut_cd", true, 0);
//            setIBCombo(sheetObj, sXml, "rat_ut_cd", false, 0, "D4");
            setIBCombo(sheetObj, sXml, "rat_ut_cd", false, 0, "D4","",true);
            
            //공통 cargo
            formObj.f_cmd.value = SEARCH19;
            sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD02202");
//            setIBCombo(sheetObj, sXml, "prc_cgo_tp_cd", true, 0);
            setIBCombo(sheetObj, sXml, "prc_cgo_tp_cd", false, 0, "DR");
            
            //currency combo
            formObj.f_cmd.value = SEARCH06;
            sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
            setIBCombo(sheetObj, sXml, "curr_cd", false, 0, "USD");
            
            isDelete = false;
            
            sheetObj.WaitImageVisible = true;
            break;
            

        case IBSEARCH: // 조회
            if (!validateForm(sheetObj, document.form, sAction)) {
                return false;
            }
            
            try {
            	for (var i = 0; i < sheetObjects.length; i++) {
					sheetObjects[i].WaitImageVisible = false;
				}
            	
            	ComOpenWait(true);
            
	            //제너럴 스페셜 세팅
	            setGenSpclRtTpCd(formObj);
	            
	            isDelete = false;
	            
	            if (sheetObj.id == "sheet1") {
	                for (var i = 0; i < sheetObjects.length; i++) {
	                    sheetObjects[i].RemoveAll();
	                }
	
	                formObj.f_cmd.value = SEARCH01;
	                sheetObj.DoSearch("ESM_PRI_6013_03GS.do" , FormQueryString(formObj));
	                
	            } else if (sheetObj.id == "sheet2") {
	                for (var i = 1; i < sheetObjects.length; i++) {
	                    if (i == 4) {
	                        continue;
	                    }
	                    sheetObjects[i].RemoveAll();
	                }
	                
	                formObj.f_cmd.value = SEARCH02;
	                sheetObj.DoSearch("ESM_PRI_6013_03GS.do" , FormQueryString(formObj));
	                
	            } else if (sheetObj.id == "sheet4") {
	                for (var i = 3; i < sheetObjects.length; i++) {
	                    if (i == 4) {
	                        continue;
	                    }
	                    sheetObjects[i].RemoveAll();
	                }
	                
	                formObj.f_cmd.value = SEARCH03;
	                var sXml = sheetObj.GetSearchXml("ESM_PRI_6013_03GS.do" , FormQueryString(formObj));
	                var arrXml = sXml.split("|$$|");
	                
	                if (arrXml.length > 0) sheetObjects[4].LoadSearchXml(arrXml[0]);    // commodity.
	                if (arrXml.length > 1) sheetObjects[3].LoadSearchXml(arrXml[1]);    // Grid3.
	                if (arrXml.length > 2) sheetObjects[5].LoadSearchXml(arrXml[2]);    // Hidden. Grid2의 Origin Point.
	                if (arrXml.length > 3) sheetObjects[6].LoadSearchXml(arrXml[3]);    // Hidden. Grid2의 Origin Via.
	                if (arrXml.length > 4) sheetObjects[7].LoadSearchXml(arrXml[4]);    // Hidden. Grid2의 Destination Via.
	                if (arrXml.length > 5) sheetObjects[8].LoadSearchXml(arrXml[5]);    // Hidden. Grid2의 Destination Point.
	
	            }
	            
	            ComOpenWait(false);

            } catch (e) {
                if (e == "[object Error]") {
                    ComShowMessage(OBJECT_ERROR);
                } else {
                    ComShowMessage(e);
                }
            } finally {
               ComOpenWait(false);
            }
            
            setTypeFontStyle();
            
            break;
    
        }
    }
    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     if (validateForm(sheetObj,document.form,IBSAVE)) {
     *         로직처리;
     *     }
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {form} formObj 필수 html form object
     * @param {int} sAction 필수 프로세스 플래그 상수
     * @return bool <br>
     *          true  : 폼입력값이 유효할 경우<br>
     *          false : 폼입력값이 유효하지 않을 경우
     * @author 이승준
     * @version 2009.04.17
     */
    function validateForm(sheetObj, formObj, sAction) {
    	
    	var qttn_sts_cd  = parent.document.form.qttn_sts_nm_read.value;
    	
        switch (sAction) {
        case IBSEARCH: // 조회
            if (formObj.qttn_no.value == "" || formObj.qttn_ver_no.value == "") {
                return false;
            } else {
                return true;
            }
            break;
            
        case IBSEARCH_ASYNC02: 
			if (formObj.qttn_no.value == "" || formObj.qttn_ver_no.value == "") {
				return false;
			}
			
			if (sheetObjects[0].SearchRows == 0) {
				return false;
			}
			
			return true;
			break; 	
    
        }
    }
    
    /**
     * 버튼을 상황에 따라 활성화, 비활성화 한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     toggleButtons(mode)
     * </pre>
     * @param {String} mode    
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
    function toggleButtons(mode) {
    	
    	var qttn_sts_cd  = parent.document.form.qttn_sts_nm_read.value;
    	
    	var isEmpty = true;
    	var rate_g_cnt = parent.document.form.rate_g_cnt.value;
    	var rate_s_cnt = parent.document.form.rate_s_cnt.value;
	
    	if(document.form.gen_spcl_rt_tp_cd.value == "G" && rate_g_cnt != "0") {
    		isEmpty = false;
    	}
    	
    	if(document.form.gen_spcl_rt_tp_cd.value == "S" && rate_s_cnt != "0") {
    		isEmpty = false;
    	}
    	
        switch (mode) {
        case "CLEAR":
        	ComBtnDisable("btn_Retrieve");
            ComBtnDisable("btn_All");
            break;
        case "INIT":
        	ComBtnEnable("btn_Retrieve");
        	ComBtnEnable("btn_All");
        	break;
        case "READONLY":
        	ComBtnDisable("btn_Retrieve");
        	ComBtnDisable("btn_All");
            break;
            
        }
    }
    
    /**
     * Data 존재시 볼드체 세팅 <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 이벤트가 발생한 해당 셀의 Column Index
     * @param {string, int, number, bool} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 이승준
     * @version 2009.04.22
     */
    function setTypeFontStyle() {

    	parent.setTabStyle();
    	
    	var rate_g_cnt = parent.document.form.rate_g_cnt.value;
    	var rate_s_cnt = parent.document.form.rate_s_cnt.value;
    	
		if(rate_g_cnt != "0") {
			document.getElementById("gen_spcl_rt_tp_cd1").style.fontWeight = "bold";
		} else {
			document.getElementById("gen_spcl_rt_tp_cd1").style.fontWeight = "";
		}
		
		if(rate_s_cnt != "0") {
			document.getElementById("gen_spcl_rt_tp_cd2").style.fontWeight = "bold";
		} else {
			document.getElementById("gen_spcl_rt_tp_cd2").style.fontWeight = "";
		}
		
		
    }
    
    /**
     * 메인화면에서 호출한다.<br>
     * 메인화면에서 탭화면을 활성화시킨다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     tabLoadSheet(qttn_no, qttn_ver_no, svc_scp_cd, eff_dt, exp_dt, isAproUsr)
     * </pre>
     * @param {String} qttn_no   	
     * @param {String} qttn_ver_no 
     * @param {String} svc_scp_cd 
     * @param {String} eff_dt 
     * @param {String} exp_dt 
     * @param {boolean} isAproUsr  권한이 있는지 여부
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
    function tabLoadSheet(qttn_no, qttn_ver_no, svc_scp_cd, eff_dt, exp_dt, isAproUsr) {
        var formObject = document.form;
    
        if (formObject.qttn_no.value != qttn_no || formObject.qttn_ver_no.value != qttn_ver_no) {
        	formObject.qttn_no.value = qttn_no;
			formObject.qttn_ver_no.value = qttn_ver_no;
			formObject.svc_scp_cd.value = svc_scp_cd;
			formObject.eff_dt.value = eff_dt;
			formObject.exp_dt.value = exp_dt;
            
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
            
            if (enableFlag && isAproUsr) {
                toggleButtons("INIT");
            } else {
                toggleButtons("READONLY");
            }
        }
    }
    
    /**
     * 메인화면에서 호출한다.<br>
     * 메인화면에서 탭화면을 초기화시킨다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     tabClearSheet()
     * </pre>
     * @param 없음 
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
    function tabClearSheet() {
        var formObject = document.form;
    
        formObject.reset();
        
        for (var i = 0; i < sheetObjects.length; i++) {
            sheetObjects[i].RemoveAll();
        }
       
        toggleButtons("CLEAR");
    }
    
    var enableFlag = true;
    /**
     * 메인화면에서 호출한다.<br>
     * 메인화면에서 탭화면을 입력 조회 또는 조회만 할 수 있도록 한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     tabEnableSheet(flag)
     * </pre>
     * @param {boolean} flag	true; 입력,조회 false : 조회 
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
    function tabEnableSheet(flag) {
       
        if (enableFlag) {
            toggleButtons("INIT");
        } else {
            toggleButtons("READONLY");
        }
    }
    
    /**
 	 * window가 resize 시 sheet col width를 재조정한다.<br>
 	 * <br><b>Example :</b>
     * <pre>
     *    onResize="cellWidthResize();"
     * </pre>
     * @param 없음
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function sheetColResize() {
 		
// 		var sheetObj1 = sheetObjects[0];
 		var sheetObj2 = sheetObjects[1];
 		var sheetObj3 = sheetObjects[2];
 		var sheetObj4 = sheetObjects[3];
 		
 		sheetObj2.FitColWidth("0|7|0|0|0|0|0|21|19.5|19.5|21|6");
 		sheetObj3.FitColWidth("0|0|0|30|18|16.5|16.5|16");
 		sheetObj4.FitColWidth("0|6|10|10|10|16|12|12|12|12");
 		
 	}
    

	/* 개발자 작업  끝 */