/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0510.js
*@FileTitle : Hold Notice Send
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.08.31 박미옥
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
     * @class ESM_BKG_0510 : ESM_BKG_0510 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0510() {
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
    var tabCnt = 0 ;
    var beforetab = 1;
    
    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
    
    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * 
     * @return 없슴
     * @author 박미옥
     */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
        var sheetObject3 = sheetObjects[2];
        var sheetObject4 = sheetObjects[3];

        /*******************************************************/
        var formObject = document.form;
        var sheetObj = sheetObjects[0];
        
        if (tabObjects[0].selectedIndex == 0) {
        	sheetObj = sheetObjects[0];
        }
		else if (tabObjects[0].selectedIndex == 1) {
			sheetObj = sheetObjects[1];
		}


        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

            case "img_dt":
    	        ComSetObjValue(formObject.sch_tp_cd, "ETA");
    	        setMandantorySearchType();
    	        var cal = new ComCalendarFromTo();
    		    cal.select(formObject.dt_s, formObject.dt_e, 'yyyy-MM-dd');
                break;
            
            case "btn_Retrieve":
            	doActionIBSheet(sheetObj,formObject,IBSEARCH);
                break;
            
            case "btn_CustomsResult":
            	doActionIBSheet(sheetObj,formObject,IBSEARCH_ASYNC03);
            	break;
            	
            case "btn_Fax_Send":
            	doActionIBSheet(sheetObj,formObject,IBSEARCH_ASYNC04);
                break;

            case "btn_Email_Send":
            	doActionIBSheet(sheetObj,formObject,IBSEARCH_ASYNC05);
                break;
            
            case "btn_DownExcel":
            	doActionIBSheet(sheetObj,formObject,IBDOWNEXCEL);
            	break;
            
            case "btn_ListPrint":
            	doActionIBSheet(sheetObj,formObject,IBSEARCH_ASYNC06);
                break;
                
            case "btn_SentHistory":
            	doActionIBSheet(sheetObj,formObject,IBSEARCH_ASYNC15);
            	break;

            case "btn_t1Preview":
            case "btn_t2Preview":
            	doActionIBSheet(sheetObj,formObject,IBSEARCH_ASYNC11);
                break;
            
            case "btn_t1FormSetting":
            case "btn_t2FormSetting":
            	doActionIBSheet(sheetObj,formObject,IBSEARCH_ASYNC13);
                break;
                
            case "btn_t2GotoTPB":
            	if (tabObjects[0].selectedIndex == 0) break;
            	doActionIBSheet(sheetObj,formObject,IBSEARCH_ASYNC10);
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
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
     * 배열은 소스 상단에 정의 <br>
     * 
     * @param {IBSheet} sheet_obj 필수, IBSheet 컨트롤
     * @return 없슴
     * @author 박미옥
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
     */
    function loadPage() {

        for(i=0;i<sheetObjects.length;i++) {
            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        for(k=0;k<tabObjects.length;k++) {
            initTab(tabObjects[k],k+1);
        }
        
        if (document.form.flag.value == "ESM_BKG_0510-01") {
        	tabObjects[0].selectedIndex = 1;
        }

        initControl();
        
        initForm();
        
        // 2017.10.20 팩스 전송 안된게 처리
        ComBtnDisable("btn_Fax_Send");

        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC14);
        
    	//US AMS Main Menu : VVD 입력시
    	if (!ComIsNull(document.form.vvd)) {
    		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    	}
    }
     
     
    /**
     * Form 데이터 초기화 작업. 화면 Open 또는 데이터 삭제 후 초기값을 설정한다.
     * 
     * @return 없슴
     * @author 박미옥
     */
    function initForm() {
 		with(document.form) {
 	        var endDay = ComGetNowInfo("ymd", "-");
 	        var startDay = ComGetDateAdd(endDay, "D", -14, "-");        
            dt_s.value = startDay;
            dt_e.value = endDay;
 		
 			//vvd.value        = "";
 			//pod_cd.value     = "";
 			del_cd.value     = "";
 		    snd_rslt_cd.value = "ALL";
 		    bl_no.value      = "";
 		    cntr_no.value    = "";
 			
	        ComSetObjValue(sch_tp_cd, "VVD");
 			
 			setMandantorySearchType();
 		}
    }
    
    
    
    /**
     * HTML 태그 이벤트를 등록한다. <br>
     * 
     * @return 없슴
     * @author 박미옥
     */
    function initControl() {
        axon_event.addListenerFormat("keypress","obj_KeyPress", form);
       	axon_event.addListener("click","obj_click", "sch_tp_cd", "vvd", "dt_s", "dt_e", "bl_no");
       	axon_event.addListener("keydown","ComKeyEnter", "vvd", "dt_s", "dt_e", "pod_cd", "del_cd", 
       			"snd_rslt_cd", "bl_no", "cntr_no");
    }
     
     
    /**
     * Click 이벤트를 처리한다.<br>
     * 
     * @return 없슴
     * @author 박미옥
     */
    function obj_click() {
        var formObject = document.form;
    	  
     	switch(event.srcElement.name) {
     	case "sch_tp_cd":
     		setMandantorySearchType();
     		break;
     	case "vvd":
     		ComSetObjValue(formObject.sch_tp_cd, "VVD");
     		setMandantorySearchType();
     		break;
     	case "dt_s":
     	case "dt_e":
     		ComSetObjValue(formObject.sch_tp_cd, "ETA");
     		setMandantorySearchType();
     		break;
     	case "bl_no":
     		ComSetObjValue(formObject.sch_tp_cd, "BL");
     		setMandantorySearchType();
     		break;
     	}
     }
     
    
    /**
      * 시트 초기설정값, 헤더 정의<br>
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
      * 
      * @param {ibsheet} sheetObj 필수, IBSheet 오브젝트
      * @param {number}  sheetNo  필수, IBSheet 오브젝트 일련번호
      * @return 없슴
      * @author 박미옥
      */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
        var sheetID = sheetObj.id;
        
        switch(sheetID) {
            case "t1sheet1":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 360;

                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 100);

                    var HeadTitle1 = "Status|||WD|BKG No.|SEQ|Status|Form|Loc|BL No.|VVD|POD|DEL|Office|Cust.Cd|Cust.Seq|Cust. Code|Customer Name|H|Hold Date|B/L|TYPE|Fax|||E-mail|||Result Date|Remark(s)";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 10, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);
                    

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,      WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 30,   daCenter,   false, "ibflag");
                    InitDataProperty(0, cnt++ , dtSeq,          30,   daCenter,   false, "seq");
                    InitDataProperty(0, cnt++ , dtDummyCheck,   30,   daCenter,   false, "chk",                  false,    "",      dfNone,            0,      true,       true,   -1,  false,  true,    "",       true);
                    InitDataProperty(0, cnt++ , dtHidden,       30,   daCenter,   false, "ntc_wd_yn",            false,    "",      dfNone,            0,      false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,       90,   daCenter,   false, "bkg_no",               false,    "",      dfNone,            0,      false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,       30,   daCenter,   false, "ntc_seq",              false,    "",      dfNone,            0,      false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,       30,   daCenter,   false, "hld_ntc_tp_cd",        false,    "",      dfNone,            0,      false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,       30,   daCenter,   false, "cstms_hld_ntc_fom_cd", false,    "",      dfNone,            0,      false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,       30,   daCenter,   false, "cstms_hld_loc_cd",     false,    "",      dfNone,            0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         90,   daCenter,   false, "bl_no",                false,    "",      dfNone,            0,      false,      false);
                                                                                                                
                    InitDataProperty(0, cnt++ , dtData,         80,   daCenter,   false, "vvd",                  false,    "",      dfNone,            0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         60,   daCenter,   false, "pod_cd",               false,    "",      dfNone,            0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         60,   daCenter,   false, "del_cd",               false,    "",      dfNone,            0,      false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,       30,   daCenter,   false, "ofc_cd",               false,    "",      dfNone,            0,      false,      false);
                                                                                                                
                    InitDataProperty(0, cnt++ , dtHidden,       20,   daCenter,   false, "cust_cnt_cd",          false,    "",      dfNone,            0,      false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,       50,   daCenter,   false, "cust_seq",             false,    "",      dfNone,            0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         80,   daCenter,   false, "cust_cd",              false,    "",      dfEngKey,          0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         230,  daLeft,     false, "cust_nm",              false,    "",      dfEngKey,          0,      true,       true,   200); 
                    InitDataProperty(0, cnt++ , dtData,         30,   daCenter,   false, "cstms_pre_hld_cd",     false,    "",      dfNone,            0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         100,  daCenter,   false, "pre_hld_dt",           false,    "",      dfUserFormat2,     0,      false,      false);
                    InitDataProperty(0, cnt++ , dtCombo,        60,   daCenter,   false, "hld_eclz_obl_flg",     false,    "",      dfNone,            0,      true,       true);
                    InitDataProperty(0, cnt++ , dtCombo,       100,   daCenter,   false, "cust_cntc_tp_cd",      false,    "",      dfNone,            0,      false,      false);                                      
                                                                                                                
                    InitDataProperty(0, cnt++ , dtData,         100,  daCenter,   false, "fax_no",               false,    "",      dfNone,            0,      true,       true,  20);
                    InitDataProperty(0, cnt++ , dtHidden,        50,  daLeft,     false, "hld_fax_snd_rslt",     false,    "",      dfNone,            0,      false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,        50,  daLeft,     false, "hld_fax_snd_rslt_nm",  false,    "",      dfNone,            0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         200,  daLeft,     false, "ntc_eml",              false,    "",      dfEngKey,          0,      true,       true,  200);
                    InitDataProperty(0, cnt++ , dtHidden,        50,  daLeft,     false, "hld_eml_snd_rslt",     false,    "",      dfNone,            0,      false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,        50,  daLeft,     false, "hld_eml_snd_rslt_nm",  false,    "",      dfNone,            0,      false,      false);
                                                                                                                
                    InitDataProperty(0, cnt++ , dtData,         100,  daCenter,   false, "hld_snd_dt",           false,    "",      dfUserFormat2,     0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         340,  daLeft,     false, "hld_diff_rmk",         false,    "",      dfEngKey,          0,      false,      false);
                                        
                    InitDataCombo(0, "hld_eclz_obl_flg", "Yes|No", "Y|N");
                                                            
                    InitUserFormat2(0, "pre_hld_dt", "####-##-## ##:##", "-|:" );
                    InitUserFormat2(0, "hld_snd_dt", "####-##-## ##:##", "-|:" );
                    
                    InitDataValid(0, "cust_cd", vtEngUpOther, "0123456789");
                    InitDataValid(0, "fax_no", vtNumericOther, "-");
                    
    				AutoRowHeight = false;
    				Ellipsis = true;
                    
                    CountPosition = 2;
                                        
               }
                break;
                
            case "t1sheet2":
                with (sheetObj) {
                	SheetFontSize = 6;
                    // 높이 설정
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = 900;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 100);

                    var HeadTitle1 = "||CHK|WD|BKG No.|SEQ|Status|Form|Loc|BL No.|VVD|POD|DEL|Office|||Cust. Code|Customer Name|H|Hold Date|B/L|TYPE|Fax|||E-mail|||Result Date|Remark(s)";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,      WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,  0,   daCenter,   false, "ibflag");
                    InitDataProperty(0, cnt++ , dtSeq,          10,   daCenter,   false, "seq");
                    InitDataProperty(0, cnt++ , dtHidden,        0,   daCenter,   false, "chk",                  false,    "",      dfNone,            0,      true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,       30,   daCenter,   false, "ntc_wd_yn",            false,    "",      dfNone,            0,      false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,       40,   daCenter,   false, "bkg_no",               false,    "",      dfNone,            0,      false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,       10,   daCenter,   false, "ntc_seq",              false,    "",      dfNone,            0,      false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,       15,   daCenter,   false, "hld_ntc_tp_cd",        false,    "",      dfNone,            0,      false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,       15,   daCenter,   false, "cstms_hld_ntc_fom_cd", false,    "",      dfNone,            0,      false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,       15,   daCenter,   false, "cstms_hld_loc_cd",     false,    "",      dfNone,            0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         60,   daCenter,   false, "bl_no",                false,    "",      dfNone,            0,      false,      false);
                                                                                                                
                    InitDataProperty(0, cnt++ , dtData,         55,   daCenter,   false, "vvd",                  false,    "",      dfNone,            0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         35,   daCenter,   false, "pod_cd",               false,    "",      dfNone,            0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         35,   daCenter,   false, "del_cd",               false,    "",      dfNone,            0,      false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,       30,   daCenter,   false, "ofc_cd",               false,    "",      dfNone,            0,      false,      false);
                                                                                                                
                    InitDataProperty(0, cnt++ , dtHidden,        0,   daCenter,   false, "cust_cnt_cd",          false,    "",      dfNone,            0,      false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,        0,   daCenter,   false, "cust_seq",             false,    "",      dfNone,            0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         50,   daCenter,   false, "cust_cd",              false,    "",      dfEngKey,          0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         80,   daLeft,     false, "cust_nm",              false,    "",      dfEngKey,          0,      true,       true,   200); 
                    InitDataProperty(0, cnt++ , dtData,         15,   daCenter,   false, "cstms_pre_hld_cd",     false,    "",      dfNone,            0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         70,   daCenter,   false, "pre_hld_dt",           false,    "",      dfUserFormat2,     0,      false,      false);
                    InitDataProperty(0, cnt++ , dtCombo,        25,   daCenter,   false, "hld_eclz_obl_flg",     false,    "",      dfNone,            0,      true,       true);
                    InitDataProperty(0, cnt++ , dtCombo,        60,   daCenter,   false, "cust_cntc_tp_cd",      false,    "",      dfNone,            0,      false,      false);                                      
                                                                                                                
                    InitDataProperty(0, cnt++ , dtData,         100,  daCenter,   false, "fax_no",               false,    "",      dfNone,            0,      true,       true,  20);
                    InitDataProperty(0, cnt++ , dtHidden,        50,  daLeft,     false, "hld_fax_snd_rslt",     false,    "",      dfNone,            0,      false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,        50,  daLeft,     false, "hld_fax_snd_rslt_nm",  false,    "",      dfNone,            0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         200,  daLeft,     false, "ntc_eml",              false,    "",      dfEngKey,          0,      true,       true,  200);
                    
                    InitDataProperty(0, cnt++ , dtHidden,        50,  daLeft,     false, "hld_eml_snd_rslt",     false,    "",      dfNone,            0,      false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,        50,  daLeft,     false, "hld_eml_snd_rslt_nm",  false,    "",      dfNone,            0,      false,      false);
                                                                                                                
                    InitDataProperty(0, cnt++ , dtData,         50,  daCenter,    false, "hld_snd_dt",           false,    "",      dfUserFormat2,     0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,          0,  daLeft,      false, "hld_diff_rmk",         false,    "",      dfEngKey,          0,      true,       true,  4000);

                                        
                    InitDataCombo(0, "hld_eclz_obl_flg", "Yes|No", "Y|N");
                                                            
                    InitUserFormat2(0, "pre_hld_dt", "####-##-## ##:##", "-|:" );
                    InitUserFormat2(0, "hld_snd_dt", "####-##-## ##:##", "-|:" );
                    
                    InitDataValid(0, "cust_cd", vtEngUpOther, "0123456789");
                    InitDataValid(0, "fax_no", vtNumericOther, "-");
                    

                    
                    CountPosition = 0;
                                        
               }
                break;

            case "t2sheet1":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 360;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 100);

                    var HeadTitle1 = "|||WD|BKG No.|SEQ|Status|Loc|BL No.|VVD|POD|DEL|Ofc|||Cust. Code|Customer Name|Form Type|H|Hold Date|C|Clear Date|TPB|B/L|TYPE|Fax|||E-mail|||Result Date|Remark(s)";
                    var headCount = ComCountHeadTitle(HeadTitle1);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 9, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);


                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,     WIDTH, DATAALIGN, COLMERGE, SAVENAME,    KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 30,   daCenter,   false,   "ibflag");
                    InitDataProperty(0, cnt++ , dtSeq,          30,   daCenter,   false,   "seq");
                    InitDataProperty(0, cnt++ , dtDummyCheck,   30,   daCenter,   false,   "chk",              false,    "",      dfNone,          0,      true,       true,   -1,  false,  true,    "",       true);
                    InitDataProperty(0, cnt++ , dtHidden,       30,   daCenter,   false,   "ntc_wd_yn",        false,    "",      dfNone,            0,      false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,       90,   daCenter,   false,   "bkg_no",           false,    "",      dfNone,          0,      false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,       30,   daCenter,   false,   "ntc_seq",          false,    "",      dfNone,          0,      false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,       30,   daCenter,   false,   "hld_ntc_tp_cd",    false,    "",      dfNone,          0,      false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,       30,   daCenter,   false,   "cstms_hld_loc_cd", false,    "",      dfNone,          0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         90,   daCenter,   true,    "bl_no",            false,    "",      dfNone,          0,      false,      false);
                    
                    InitDataProperty(0, cnt++ , dtData,         80,   daCenter,   false,   "vvd",              false,    "",      dfNone,          0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         60,   daCenter,   false,   "pod_cd",           false,    "",      dfNone,          0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         60,   daCenter,   false,   "del_cd",           false,    "",      dfNone,          0,      false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,       30,   daCenter,   false,   "ofc_cd",           false,    "",      dfNone,          0,      false,      false);
                    
                    InitDataProperty(0, cnt++ , dtHidden,        0,   daCenter,   false,   "cust_cnt_cd",      false,    "",      dfNone,          0,      false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,        0,   daCenter,   false,   "cust_seq",         false,    "",      dfNone,          0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         80,   daCenter,   false,   "cust_cd",          false,    "",      dfNone,          0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         230,  daLeft,     false,   "cust_nm",          false,    "",      dfNone,          0,      true,       true);
                    InitDataProperty(0, cnt++ , dtCombo,        70,   daCenter,   false,   "cstms_hld_ntc_fom_cd",false, "",      dfNone,          0,      true,       true);
                    InitDataProperty(0, cnt++ , dtData,         30,   daCenter,   false,   "cstms_pre_hld_cd", false,    "",      dfNone,          0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         100,  daCenter,   false,   "pre_hld_dt",       false,    "",      dfUserFormat2,   0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         30,   daCenter,   false,   "cstms_cfm_hld_cd", false,    "",      dfNone,          0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         100,  daCenter,   false,   "cfm_hld_dt",       false,    "",      dfUserFormat2,   0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,          50,  daCenter,   false,   "n3pty_bil_no_yn",  false,    "",      dfNone,          0,      false,      false);
                    InitDataProperty(0, cnt++ , dtCombo,        30,   daCenter,   false,   "hld_eclz_obl_flg", false,    "",      dfNone,          0,      true,       true);
                    InitDataProperty(0, cnt++ , dtCombo,        100,  daCenter,   false,   "cust_cntc_tp_cd",  false,    "",      dfNone,          0,      true,       true);

                    InitDataProperty(0, cnt++ , dtData,         100,  daCenter,   false, "fax_no",               false,    "",      dfNone,            0,      true,       true,  20);
                    InitDataProperty(0, cnt++ , dtHidden,        50,  daLeft,     false, "hld_fax_snd_rslt",     false,    "",      dfNone,            0,      false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,        50,  daLeft,     false, "hld_fax_snd_rslt_nm",  false,    "",      dfNone,            0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         200,  daLeft,     false, "ntc_eml",              false,    "",      dfEngKey,          0,      true,       true,  200);
                    InitDataProperty(0, cnt++ , dtHidden,        50,  daLeft,     false, "hld_eml_snd_rslt",     false,    "",      dfNone,            0,      false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,        50,  daLeft,     false, "hld_eml_snd_rslt_nm",  false,    "",      dfNone,            0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         100,  daCenter,   false,   "hld_snd_dt",         false,    "",      dfUserFormat2,   0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         340,  daLeft,     false,   "hld_diff_rmk",       false,    "",      dfEngKey,        0,      false,      false);

                    InitDataCombo(0, "hld_eclz_obl_flg", "Yes|No", "Y|N");         
                    InitDataCombo(0, "cstms_hld_ntc_fom_cd", "Event1|Event2|Event3|Event4|Event5", "E1|E2|E3|E4|E5");                                       
                    
                    InitUserFormat2(0, "pre_hld_dt", "####-##-## ##:##", "-|:" );
                    InitUserFormat2(0, "cfm_hld_dt", "####-##-## ##:##", "-|:" );
                    InitUserFormat2(0, "hld_snd_dt", "####-##-## ##:##", "-|:" );
                    
                    InitDataValid(0, "cust_cd", vtEngUpOther, "0123456789");
                    InitDataValid(0, "fax_no", vtNumericOther, "-");
                    
    				AutoRowHeight = false;
    				Ellipsis = true;
    				
                    CountPosition = 2;                                      
                }
               
                break;
                
            case "t2sheet2":
                with (sheetObj) {
                	SheetFontSize = 6;
                	
                    // 높이 설정
                    style.height = 0;
                    
                    //전체 너비 설정
                    SheetWidth = 900;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 100);

                    var HeadTitle1 = "||CHK|WD|BKG No.|SEQ|Status|Loc|BL No.|VVD|POD|DEL|Ofc|||Cust. Code|Customer Name|Form|H|Hold Date|C|Clear Date|TPB|B/L|TYPE|Fax|||E-mail|||Result Date|Remark(s)";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 9, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);
                    

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,     WIDTH, DATAALIGN, COLMERGE, SAVENAME,    KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 30,   daCenter,   false,   "ibflag");
                    InitDataProperty(0, cnt++ , dtSeq,          30,   daCenter,   false,   "seq");
                    InitDataProperty(0, cnt++ , dtHidden,       30,   daCenter,   false,   "chk",              false,    "",      dfNone,          0,      true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,       30,   daCenter,   false,   "ntc_wd_yn",        false,    "",      dfNone,            0,      false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,       90,   daCenter,   false,   "bkg_no",           false,    "",      dfNone,          0,      false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,       30,   daCenter,   false,   "ntc_seq",          false,    "",      dfNone,          0,      false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,       30,   daCenter,   false,   "hld_ntc_tp_cd",    false,    "",      dfNone,          0,      false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,       30,   daCenter,   false,   "cstms_hld_loc_cd", false,    "",      dfNone,          0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         60,   daCenter,   false,   "bl_no",            false,    "",      dfNone,          0,      false,      false);
                    
                    InitDataProperty(0, cnt++ , dtData,         50,   daCenter,   false,   "vvd",              false,    "",      dfNone,          0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         30,   daCenter,   false,   "pod_cd",           false,    "",      dfNone,          0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         30,   daCenter,   false,   "del_cd",           false,    "",      dfNone,          0,      false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,       30,   daCenter,   false,   "ofc_cd",           false,    "",      dfNone,          0,      false,      false);
                    
                    InitDataProperty(0, cnt++ , dtHidden,        0,   daCenter,   false,   "cust_cnt_cd",      false,    "",      dfNone,          0,      false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,        0,   daCenter,   false,   "cust_seq",         false,    "",      dfNone,          0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         50,   daCenter,   false,   "cust_cd",          false,    "",      dfNone,          0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         80,   daLeft,     false,   "cust_nm",          false,    "",      dfNone,          0,      true,       true);
                    InitDataProperty(0, cnt++ , dtCombo,        30,   daCenter,   false,   "cstms_hld_ntc_fom_cd",false, "",      dfNone,          0,      true,       true);
                    InitDataProperty(0, cnt++ , dtData,         15,   daCenter,   false,   "cstms_pre_hld_cd", false,    "",      dfNone,          0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         50,   daCenter,   false,   "pre_hld_dt",       false,    "",      dfUserFormat2,   0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         15,   daCenter,   false,   "cstms_cfm_hld_cd", false,    "",      dfNone,          0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         50,   daCenter,   false,   "cfm_hld_dt",       false,    "",      dfUserFormat2,   0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         30,   daCenter,   false,   "n3pty_bil_no_yn",  false,    "",      dfNone,          0,      false,      false);
                    InitDataProperty(0, cnt++ , dtCombo,        20,   daCenter,   false,   "hld_eclz_obl_flg", false,    "",      dfNone,          0,      true,       true);
                    InitDataProperty(0, cnt++ , dtCombo,        50,   daCenter,   false,   "cust_cntc_tp_cd",  false,    "",      dfNone,          0,      true,       true);

                    InitDataProperty(0, cnt++ , dtData,         100,  daCenter,   false, "fax_no",               false,    "",      dfNone,            0,      true,       true,  20);
                    InitDataProperty(0, cnt++ , dtHidden,        50,  daLeft,     false, "hld_fax_snd_rslt",     false,    "",      dfNone,            0,      false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,        50,  daLeft,     false, "hld_fax_snd_rslt_nm",  false,    "",      dfNone,            0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         200,  daLeft,     false, "ntc_eml",              false,    "",      dfEngKey,          0,      true,       true,  200);

                    InitDataProperty(0, cnt++ , dtHidden,        50,  daLeft,     false, "hld_eml_snd_rslt",     false,    "",      dfNone,            0,      false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,        50,  daLeft,     false, "hld_eml_snd_rslt_nm",  false,    "",      dfNone,            0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         50,   daCenter,   false,   "hld_snd_dt",         false,    "",      dfUserFormat2,   0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         30,   daLeft,     false,    "hld_diff_rmk",     false,    "",      dfNone,          0,      true,       true);

                    
                    

                    InitDataCombo(0, "hld_eclz_obl_flg", "Yes|No", "Y|N");         
                    InitDataCombo(0, "cstms_hld_ntc_fom_cd", "Event1|Event2|Event3|Event4|Event5", "E1|E2|E3|E4|E5");                                       
                    
                    InitUserFormat2(0, "pre_hld_dt", "####-##-## ##:##", "-|:" );
                    InitUserFormat2(0, "cfm_hld_dt", "####-##-## ##:##", "-|:" );
                    InitUserFormat2(0, "hld_snd_dt", "####-##-## ##:##", "-|:" );
                    
                    InitDataValid(0, "cust_cd", vtEngUpOther, "0123456789");
                    InitDataValid(0, "fax_no", vtNumericOther, "-");

                    
                    
                    CountPosition = 0;                                        
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
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
        
        sheetObj.WaitImageVisible = false;
        
    	var trgSheetObj = sheetObjects[2];
    	if (sheetObj.id == "t1sheet1") trgSheetObj = sheetObjects[2];
    	else trgSheetObj = sheetObjects[3];

        switch(sAction) {

            //조회
            case IBSEARCH:              	
                if (validateForm(sheetObj,formObj,sAction) == false) break;
             	
                ComOpenWait(true);
                
                if (sheetObj.id == "t1sheet1") {
                    formObj.f_cmd.value = SEARCH;
                    sheetObj.DoSearch("ESM_BKG_0510GS.do", FormQueryString(formObj));
                } else if (sheetObj.id == "t2sheet1") {
                    formObj.f_cmd.value = SEARCH01;
                    sheetObj.DoSearch("ESM_BKG_0510_01GS.do", FormQueryString(formObj));
                }
                
                ComOpenWait(false);
                
                break;

                
                
            // Go To TPB
            case IBSEARCH_ASYNC10:
            	var iCheckRow = sheetObj.CheckedRows("chk");
            	if (iCheckRow < 1) {
            		ComShowCodeMessage("BKG40090", "TPB Issue");
            		break;
            	} else if (iCheckRow > 1) {
            		ComShowCodeMessage("BKG40075");
            		break;
            	}
            	
            	var sCheckRow = sheetObj.FindCheckedRow("chk");
            	var arrRow = sCheckRow.split("|");

            	var param = "bkg_no="  + sheetObj.CellValue(arrRow, "bkg_no")  + "&" +
            	            "ntc_seq=" + sheetObj.CellValue(arrRow, "ntc_seq") + "&" +
            	            "bl_no="   + sheetObj.CellValue(arrRow, "bl_no")   + "&" +
            	            "cust_cd=" + sheetObj.CellValue(arrRow, "cust_cd") + "&" +
            	            "cust_nm=" + sheetObj.CellValue(arrRow, "cust_nm");
            	
            	ComOpenPopupWithTarget('/hanjin/ESM_BKG_1068.do?' + param, 605, 290, "", "none", true);
            	
            	break;
            
            	
            	
            // Customs Result
            case IBSEARCH_ASYNC03:
            	var iCheckRow = sheetObj.CheckedRows("chk");
            	if (iCheckRow < 1) {
            		ComShowCodeMessage("BKG00149");
            		break;
            	} else if (iCheckRow > 1) {
            		ComShowCodeMessage("BKG40075");
            		break;
            	}
            	
            	var sCheckRow = sheetObj.FindCheckedRow("chk");
            	var arrRow = sCheckRow.split("|");

            	var param = "&bl_no=" + sheetObj.CellValue(arrRow, "bl_no");
            	ComOpenPopupWithTarget('/hanjin/ESM_BKG_0034.do?pgmNo=ESM_BKG_0034-03&open_tab=2' + param, 1024, 635, "", "none", false);
            	break;            	
            	
            	
            	
            	// Fax 
            case IBSEARCH_ASYNC04:         
                if (validateForm(sheetObj,formObj,sAction) == false) break;
                
            	if (sheetObj.id == "t1sheet1") {
                    if (ComShowCodeConfirm("BKG40037", "Hold Notice") == false) {
                    	break;
                    }
            	} else {
                    if (ComShowCodeConfirm("BKG40037", "Hold Removal Notice") == false) {
                    	break;
                    }
            	}
            	

                ComOpenWait(true);
                
                if (sheetObj.id == "t1sheet1") {
                    formObj.f_cmd.value = MULTI01;
                } else {
                    formObj.f_cmd.value = MULTI11;
                }

                var sParam = FormQueryString(formObj);
                var sParamSheet = sheetObj.GetSaveString(false, true, "chk");
                if (sParamSheet != "") {
                    sParam += "&" + ComSetPrifix(sParamSheet, "sheet1_");
                }                

            	var sXml = "";
                if (sheetObj.id == "t1sheet1") {
            	    sXml = sheetObj.GetSaveXml("ESM_BKG_0510GS.do", sParam);
                } else {
                	sXml = sheetObj.GetSaveXml("ESM_BKG_0510_01GS.do", sParam);
                }

                sheetObj.LoadSaveXml(sXml);

                ComOpenWait(false);

                
				if(ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S") {
		    		doActionIBSheet(sheetObj,formObj,IBSEARCH);
				}
				
                break;
                
                
                
            	// Email
            case IBSEARCH_ASYNC05: 
                if (validateForm(sheetObj,formObj,sAction) == false) break;

            	if (sheetObj.id == "t1sheet1") {
                    if (ComShowCodeConfirm("BKG40038", "Hold Notice") == false) {
                    	break;
                    }
            	} else {
                    if (ComShowCodeConfirm("BKG40038", "Hold Removal Notice") == false) {
                    	break;
                    }
            	}

            	ComOpenWait(true);
            	
                if (sheetObj.id == "t1sheet1") {
                    formObj.f_cmd.value = MULTI02;
                } else {
                    formObj.f_cmd.value = MULTI12;
                }                

                var sParam = FormQueryString(formObj);
                var sParamSheet = sheetObj.GetSaveString(false, true, "chk");
                if (sParamSheet != "") {
                    sParam += "&" + ComSetPrifix(sParamSheet, "sheet1_");
                }

            	var sXml = "";
                if (sheetObj.id == "t1sheet1") {
            	    sXml = sheetObj.GetSaveXml("ESM_BKG_0510GS.do", sParam);
                } else {
                	sXml = sheetObj.GetSaveXml("ESM_BKG_0510_01GS.do", sParam);
                }

                sheetObj.LoadSaveXml(sXml);
				                
                ComOpenWait(false);
                
                
				if(ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S") {
		    		doActionIBSheet(sheetObj,formObj,IBSEARCH);
				}								

                break;
            	
                
                
            // Preview
            case IBSEARCH_ASYNC11:            	
         	    if (sheetObj.RowCount == 0) {
         	    	ComShowCodeMessage("BKG00395"); 
        	        break;
        	    }

         	    var sRowStr = sheetObj.GetSelectionRows("/");

            	//자바 스크립트 배열로 만들기
            	var arr = sRowStr.split("/");
               	if (arr.length < 1) {
            		ComShowCodeMessage("BKG00149");
            		break;
            	} else if (arr.length > 1) {
            		ComShowCodeMessage("BKG40075");
            		break;
            	}

            	var vRow = arr[0];

            	
                // 셋업정보 유무 체크
    		    sheetObj.WaitImageVisible = false;
            	
            	var vParam = "f_cmd=" + COMMAND03 + 
            	            "&ofc_cd=" + sheetObj.CellValue(vRow, "ofc_cd") + 
            	            "&pod_cd=" + sheetObj.CellValue(vRow, "pod_cd") + 
            	            "&hld_ntc_tp_cd=" + sheetObj.CellValue(vRow, "hld_ntc_tp_cd");

    	        var sXml = sheetObj.GetSearchXml("ESM_BKG_0510GS.do", vParam);  

    		    //sheetObj.WaitImageVisible = true;

    	        if (ComGetEtcData(sXml, "exist") == "no") {
					ComShowCodeMessage("BKG40077");
					sheetObj.SelectCell(vRow, "bl_no");
					break;
    	        }
    	        
            	
            	var bkg_no  = sheetObj.CellValue(vRow, "bkg_no");
            	var ntc_seq = sheetObj.CellValue(vRow, "ntc_seq");
            	var cust_nm = sheetObj.CellValue(vRow, "cust_nm").replace("'","''");
            	var remark  = sheetObj.CellValue(vRow, "hld_diff_rmk").replace("'","''");
            	var fom_cd  = sheetObj.CellValue(vRow, "cstms_hld_ntc_fom_cd");
            	
            	var usr_id  = formObj.usr_id.value;
            	var ofc_cd  = sheetObj.id == "t1sheet1" ? sheetObj.CellValue(vRow, "ofc_cd") : "";

                if (sheetObj.id == "t1sheet1") {
                	formObj.com_mrdTitle.value = "Hold Notice";
                	formObj.com_mrdBodyTitle.value = "Hold Notice";
                	formObj.com_mrdPath.value = "apps/alps/esm/bkg/inbounddocumentation/inboundnoticemgt/inboundnotice/report/ESM_BKG_0761.mrd";
                	formObj.com_mrdArguments.value = "/rv bkg_no['" + bkg_no + "'] ntc_seq['" + ntc_seq + "'] " + 
                	                                    "p_usr_id['" + usr_id + "'] p_ofc_cd['" + ofc_cd + "'] " + 
                	                                    "p_cust_nm['" + cust_nm + "'] p_remark['" + remark + "']";
                	                                                                                            
                } else {
                	formObj.com_mrdTitle.value = "Hold Notice";
                	formObj.com_mrdBodyTitle.value = "Hold Removal Notice";
                	formObj.com_mrdPath.value = "apps/alps/esm/bkg/inbounddocumentation/inboundnoticemgt/inboundnotice/report/ESM_BKG_0762.mrd";
                	formObj.com_mrdArguments.value = "/rv bkg_no['" + bkg_no + "'] ntc_seq['" + ntc_seq + "'] " + 
                	                                    "p_usr_id['" + usr_id + "'] p_ofc_cd['" + ofc_cd + "'] p_fom_cd['" + fom_cd + "'] " +
                	                                    "p_cust_nm['" + cust_nm + "'] p_remark['" + remark + "']";
                }               

                /* 메일 전송 전 테스트용~ */
            	/*formObj.com_mrdPath[1].value = "apps/alps/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_DBL.mrd";
            	formObj.com_mrdArguments[1].value = "/rv form_bkgNo[('" + bkg_no + "')] " +
													   " form_type[2] " +
													   " form_dataOnly[N] " +
													   " form_manifest[N] " +
													   " form_usrId[" + usr_id + "] " +
													   " form_hiddeData[N] " +
													   " form_level[(1)] " +
													   " form_remark[] " +
													   " form_Cntr[1] " +
													   " form_mainOnly[N] " +
													   " form_CorrNo[] " +
													   " form_his_cntr[BKG_CONTAINER] " +
													   " form_his_bkg[BKG_BOOKING] " +
													   " form_his_mkd[BKG_BL_MK_DESC] " +
													   " form_his_xpt[BKG_XPT_IMP_LIC] " +
													   " form_his_bl[BKG_BL_DOC] " +
													"/rp [] /riprnmargin";*/

            	ComOpenRDPopup();
           	    
            	break;
                
            	
            	
            // EXCEL DOWNLOAD
     		case IBDOWNEXCEL:
     			var rowSkipList = "";
     			for (var i=0; i<sheetObj.RowCount; i++) {
     				if (sheetObj.CellValue(i+1,"chk") == "0") {
     					rowSkipList += (i+1) + "|";
     				}
     			}
     			
     			sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "", rowSkipList, true, true);

     			break;

     			
     			
                // List Print
            case IBSEARCH_ASYNC06:
         	    if (sheetObj.RowCount == 0) {
        		    ComShowCodeMessage("BKG00395"); 
        	        break;
        	    }

         	    var iCheckRow = sheetObj.CheckedRows("chk");
           	    if (iCheckRow < 1) {
            		ComShowCodeMessage("BKG00149");
            		break;
            	}

            	trgSheetObj.RemoveAll();
            	sheetObj.Copy2SheetCol(trgSheetObj,"","",-1,-1,-1,1,false,false, "chk", "");             	

           		trgSheetObj.Down2Print(true, poLandscape, "Hold Notice Send"); 
            	
                break;
                
                
                
                // Form Setting
            case IBSEARCH_ASYNC13:
            	var iCheckRow = sheetObj.CheckedRows("chk");
            	if (iCheckRow < 1) {
            		ComShowCodeMessage("BKG00149");
            		break;
            	} else if (iCheckRow > 1) {
            		ComShowCodeMessage("BKG40075");
            		break;
            	}
            	
            	var sCheckRow = sheetObj.FindCheckedRow("chk");
            	var arrRow = sCheckRow.split("|");

            	var param = "&popUp=Y&ofc_cd=" + sheetObj.CellValue(arrRow[0], "ofc_cd") + 
            	            "&pod_cd=" + sheetObj.CellValue(arrRow[0], "pod_cd");
            	
            	if (sheetObj.id == "t1sheet1")            	
            		ComOpenPopupWithTarget('/hanjin/ESM_BKG_0511.do?pgmNo=ESM_BKG_0511' + param, 1020, 600, "", "none", true);
            	else 
            		ComOpenPopupWithTarget('/hanjin/ESM_BKG_0760.do?pgmNo=ESM_BKG_0760' + param, 1020, 700, "", "none", true);
            	
            	break;

            	
            	
            	// Cust Type 자동 조회
            case IBSEARCH_ASYNC14:
            	
            	//sheetObj.WaitImageVisible = false;
            	
            	var sXml = sheetObj.GetSearchXml("ESM_BKG_0000GS.do", "f_cmd=" + SEARCHLIST01 + "&cm_code=CD02129");
            	
            	//sheetObj.WaitImageVisible = true;
            	
        		if (sXml.length > 0) {
        			var arrCombo = ComXml2ComboString(sXml, "val", "name");
        			sheetObjects[0].InitDataCombo(0, "cust_cntc_tp_cd", arrCombo[1], arrCombo[0]);
        			sheetObjects[1].InitDataCombo(0, "cust_cntc_tp_cd", arrCombo[1], arrCombo[0]);
        			sheetObjects[2].InitDataCombo(0, "cust_cntc_tp_cd", arrCombo[1], arrCombo[0]);
        			sheetObjects[3].InitDataCombo(0, "cust_cntc_tp_cd", arrCombo[1], arrCombo[0]);
        		}
        		
            	break;
            	
            	
            	
            	// History
            case IBSEARCH_ASYNC15:
         	    if (sheetObj.RowCount == 0) {
         	    	ComShowCodeMessage("BKG00395"); 
        	        break;
        	    }

         	    var sRowStr = sheetObj.GetSelectionRows("/");

            	//자바 스크립트 배열로 만들기
            	var arr = sRowStr.split("/");
               	if (arr.length < 1) {
            		ComShowCodeMessage("BKG00149");
            		break;
            	} else if (arr.length > 1) {
            		ComShowCodeMessage("BKG40075");
            		break;
            	}

            	var arrRow = arr[0];

            	var param = "&autoSearchFlg=Y&sch_tp=B&bl_no=" + sheetObj.CellValue(arrRow, "bl_no");
            	ComOpenPopupWithTarget('/hanjin/ESM_BKG_0001.do?pgmNo=ESM_BKG_0001' + param, 1024, 700, "", "none", false);
            	            	
            	break;
         }
     }


    /**
      * IBTab Object를 배열로 등록<br>
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
      * 배열은 소스 상단에 정의 <br>
      * 
      * @param {object} tab_obj 필수, Tab 컨트롤
      * @return 없슴
      * @author 박미옥
      */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;
    }


    /**
     * Tab 기본 설정 <br>
     * 탭의 항목을 설정한다. <br>
     * 
     * @param {object} tabObj 필수, Tab 컨트롤
     * @param {int}    tabNo  필수, Tab 오브젝트 일련번호
     * @return 없슴
     * @author 박미옥
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                 with (tabObj) {
                     var cnt  = 0 ;
                     InsertTab( cnt++ , "Hold Notice" , -1 );
                     InsertTab( cnt++ , "Hold Removal Notice" , -1 );
                 }
             break;

         }
     }

    /**
     * Tab 클릭시 이벤트 관련 <br>
     * 선택한 탭의 요소가 활성화 된다. <br>
     * 
     * @param {object} tabObj 필수, Tab 컨트롤
     * @param {int}    nItem  필수, Tab 오브젝트 일련번호
     * @return 없슴
     * @author 박미옥
     */
    function tab1_OnChange(tabObj , nItem) {
         var objs = document.all.item("tabLayer");

         objs[nItem].style.display = "Inline";
         objs[beforetab].style.display = "none";


         //--------------- 요기가 중요 --------------------------//
         objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
         //------------------------------------------------------//
         beforetab= nItem;
    }

    
    /**
     * Tab1 Sheet1 변경 이벤트 발생 처리<br>
     * 
     * @param {ibsheet} sheetObj 필수. Sheet ID
     * @param {int}     Row      필수. Sheet Row
     * @param {int}     Col      필수. Sheet Col
     * @param {string}  Value    필수. Sheet 셀값
     * @return 없슴
     * @author 박미옥
     */
    function t1sheet1_OnChange(sheetObj, Row, Col, Value) {
    	sheet_Change(sheetObj, Row, Col, Value);
    }

    
    
    /**
     * Tab2 Sheet1 변경 이벤트 발생 처리<br>
     * 
     * @param {ibsheet} sheetObj 필수. Sheet ID
     * @param {int}     Row      필수. Sheet Row
     * @param {int}     Col      필수. Sheet Col
     * @param {string}  Value    필수. Sheet 셀값
     * @return 없슴
     * @author 박미옥
     */
    function t2sheet1_OnChange(sheetObj, Row, Col, Value) {
    	sheet_Change(sheetObj, Row, Col, Value);
    }

    
    /**
     * Sheet 변경 이벤트 발생시 프로세스 처리 <br>
     * 이메일 변경시 메일 형식 유효성을 체크한다.
     * 
     * @param {ibsheet} sheetObj 필수
     * @param {int}     Row      필수
     * @param {int}     Col      필수
     * @param {string}  Value    필수
     * @return 없슴
     */
    function sheet_Change(sheetObj, Row, Col, Value) {
    	with(sheetObj) {
    		switch (ColSaveName(Col)) {
    			
    		case "ntc_eml":
    			if (CellValue(Row, "chk") == "1") {
					if (CellValue(Row, Col) != "" && BkgIsEmailAddr(CellValue(Row, Col)) == false) {
						ComShowCodeMessage("BKG40021", CellValue(Row, Col));
						SelectCell(Row, "ntc_eml");
						break;
		    		} 
				}
    			break;
    		}
    	}
    }

    
    
    /**
     * Tab1 Sheet1 KewDown 이벤트 발생 처리<br>
     * 
     * @param {ibsheet} sheetObj 필수. Sheet ID
     * @param {int}     Row      필수. Sheet Row
     * @param {int}     Col      필수. Sheet Col
     * @param {string}  Value    필수. Sheet 셀값
     * @return 없슴
     * @author 박미옥
     */
    function t1sheet1_OnKeyDown(sheetObj, Row, Col, Value) {
    	sheet_KeyDown(sheetObj, Row, Col, Value);
    }

    
    
    /**
     * Tab2 Sheet1 KewDown 이벤트 발생 처리<br>
     * 
     * @param {ibsheet} sheetObj 필수. Sheet ID
     * @param {int}     Row      필수. Sheet Row
     * @param {int}     Col      필수. Sheet Col
     * @param {string}  Value    필수. Sheet 셀값
     * @return 없슴
     * @author 박미옥
     */
    function t2sheet1_OnKeyDown(sheetObj, Row, Col, Value) {
    	sheet_KeyDown(sheetObj, Row, Col, Value);
    }
    
    
    /**
     * Sheet Key down 이벤트 발생 시 프로세스 처리<br>
     * Fax No 또는 Email 인 경우 값이 변경되었으므로 체크박스를 체크해준다.<br>
     * 
     * @param {ibsheet} sheetObj 필수
     * @param {int}     Row      필수
     * @param {int}     Col      필수
     * @param {string}  Value    필수
     * @return 없슴
     */
    function sheet_KeyDown(sheetObj, Row, Col, Value) {
    	with(sheetObj) {
    		switch(ColSaveName(Col)) {
    		case "fax_no":
    		case "ntc_eml":
    			CellValue2(Row, "chk") = 1;
    			break;
    		}
    	}
    }

    
    /**
     * Tab1 Sheet1 Double Click 이벤트 발생 처리<br>
     * 
     * @param {ibsheet} sheetObj 필수. Sheet ID
     * @param {int}     Row      필수. Sheet Row
     * @param {int}     Col      필수. Sheet Col
     * @param {string}  Value    필수. Sheet 셀값
     * @return 없슴
     * @author 박미옥
     */
	function t1sheet1_OnDblClick(sheetObj, Row, Col) {
		sheet_DbClick(sheetObj, Row, Col);
	}

	
    /**
     * Tab2 Sheet1 Double Click 이벤트 발생 처리<br>
     * 
     * @param {ibsheet} sheetObj 필수. Sheet ID
     * @param {int}     Row      필수. Sheet Row
     * @param {int}     Col      필수. Sheet Col
     * @param {string}  Value    필수. Sheet 셀값
     * @return 없슴
     * @author 박미옥
     */
	function t2sheet1_OnDblClick(sheetObj, Row, Col) {
		sheet_DbClick(sheetObj, Row, Col);
	}

	/**
	 * Sheet 더블클릭 이벤트 발생 시 프로세스 처리<br>
	 * Remark 인 경우, 메모패드를 활성화하여 Edit 가능하도록 한다.<br>
	 * Customer 인 경우, Customer 명을 확인할 수 있도록 높이를 높여준다.<br>
	 * 
	 * @param {ibsheet} sheetObj 필수
	 * @param {int}     Row      필수
	 * @param {int}     Col      필수
	 * @return 없슴
	 */
	function sheet_DbClick(sheetObj, Row, Col) {
    	with(sheetObj) {
    		switch (ColSaveName(Col)) {
    		case "hld_diff_rmk":
    			CellEditable(Row, Col) = false;
    			ComShowMemoPad(sheetObj, Row, Col);
    			CellEditable(Row, Col) = true;
    			break;
    		case "cust_nm":
    			if (RowHeight(Row) == 20) {
    				RowHeight(Row) = 0;
    			} else {
        			RowHeight(Row) = 20;
    			}
    			break;
    		}
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
     */
    function validateForm(sheetObj,formObj,sAction){
        with(sheetObj) {
            switch(sAction) {
          	case IBSEARCH:
       	    	if (!ComChkValid(formObj)) return false;
       	    	
              	if(ComGetObjValue(formObj.sch_tp_cd) == "ETA" && 
              			!ComBkgMonthsBetweenCheck(formObj.dt_s.value, formObj.dt_e.value, 3)) {
              		ComShowCodeMessage("BKG40013", "3");
              		ComSetFocus(formObj.dt_e);
              		return false;
              	}

          		break;
          		
            	// Fax Send
            case IBSEARCH_ASYNC04:
            	//체크된 행의 번호를 읽어온다. 결과->"3|5|10|"
            	var sCheckRow = FindCheckedRow("chk");
            	var arrRow = sCheckRow.split("|");
            	if (arrRow.length <= 1) {
            		ComShowCodeMessage("BKG40018");
            		return false;
            	}

        		for (var i=1; i<Rows; i++) {
        			if (CellValue(i, "chk") == "1") {
    					if (CellValue(i, "ntc_wd_yn") != "Y") {
    						ComShowCodeMessage("BKG40077");
    						SelectCell(i, "bl_no");
    						return false;
    					}

    					if (CellValue(i, "fax_no") == "") {
    						ComShowCodeMessage("BKG00577");
    						SelectCell(i, "fax_no");
    						return false;
    					}
        			}
        		}

        		break;
        	
            	// Email Send
            case IBSEARCH_ASYNC05:
            	//체크된 행의 번호를 읽어온다. 결과->"3|5|10|"
            	var sCheckRow = FindCheckedRow("chk");
            	var arrRow = sCheckRow.split("|");
            	if (arrRow.length <= 1) {
            		ComShowCodeMessage("BKG40019");
            		return false;
            	}
            	
        		for (var i=1; i<Rows; i++) {
        			if (CellValue(i, "chk") == "1") {
    					if (CellValue(i, "ntc_wd_yn") != "Y") {
    						ComShowCodeMessage("BKG40077");
    						SelectCell(i, "bl_no");
    						return false;
    					}

    					if (CellValue(i, "ntc_eml") == "" || BkgIsEmailAddr(CellValue(i, "ntc_eml")) == false) {
    						ComShowCodeMessage("BKG00366");
    						SelectCell(i, "ntc_eml");
    						return false;
    		    		} 
        			}
        		}

        		break;
        		
          	}
        }

        return true;
    }
     
      
    /**
     * 선택된 필수 조건을 셋팅한다.<br>
     * 
     * @return 없슴
     */
    function setMandantorySearchType() {
    	with(document.form) {
    		setNotRequiredObject(vvd, dt_s, dt_e, bl_no);
    		
    		var schVal = ComGetObjValue(sch_tp_cd);    		
        	if (schVal == "VVD") {
    			setRequiredObject(vvd);
    		} else if (schVal == "ETA") {
    			setRequiredObject(dt_s, dt_e);
        	} else if (schVal == "BL") {
    			setRequiredObject(bl_no);
    		} 
    	}
    }
    
    /**
     * 필수 검색 조건을 설정한다.
     * 
     * @param [...] 가변 인자
     * @return 없슴
     */
    function setRequiredObject() {
    	for(var i=0; i<arguments.length; i++) {
    		setRequiredMode(arguments[i], true);
    	}
    	
    	if (arguments.length > 0) 
    		arguments[0].focus();
    }

    /**
     * 필수 검색 조건이 아님으로 설정한다.<br>
     * 
     * @param [...] 가변 인자
     * @return 없슴
     */
    function setNotRequiredObject() {
    	for(var i=0; i<arguments.length; i++) {
    		setRequiredMode(arguments[i], false);
    	}
    }
    
    /**
     * Object 의 Required 속성을 셋팅한다.<br>
     * 
     * @param {object}  obj         필수. 대상 HTML 오브젝트
     * @param {boolean} requireMode 필수. Required 속성 모드(true/false)
     * @return 없슴
     */
    function setRequiredMode(obj, requireMode) {    	
    	if (requireMode == true) {
    		obj.setAttribute("required", true);
    	} else {
    		obj.removeAttribute("required");
    	}
    }
     
    
	/* 개발자 작업  끝 */