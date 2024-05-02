/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1064.js
*@FileTitle : Pick up Upload
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.04
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.11.04 박미옥
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
     * @class ESM_BKG_1064 : ESM_BKG_1064 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_1064() {
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
     */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObj = sheetObjects[0];
        /*******************************************************/
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

            case "btn_FileImport":
            	doActionIBSheet(sheetObjects[1],formObject,IBSEARCH_ASYNC01);
            	break;

            case "btn_New":
            	doActionIBSheet(sheetObj,formObject,IBRESET);
            	break;
            	
            case "btn_DownExcel":
            	doActionIBSheet(sheetObj,formObject,IBDOWNEXCEL);
            	break;
            	
            case "btn_Verify":
            	doActionIBSheet(sheetObj,formObject,IBSEARCH_ASYNC02);
            	break;
            	
            case "btn_Close":
                window.close();
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
     */
    function loadPage() {

        for(var i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        initForm();
    }

     
    /**
     * Form 데이터 초기화 작업. 화면 Open 또는 데이터 삭제 후 초기값을 설정한다.
     * 
     * @return 없슴
     */
    function initForm() {
 		with(document.form) {
 			file_name.value = "";
 		    ComSetObjValue(rail_cd, "BN");
 		}
    }
     
     
    /**
     * 시트 초기설정값, 헤더 정의<br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * 
     * @param {ibsheet} sheetObj 필수, IBSheet 오브젝트
     * @param {number}  sheetNo  필수, IBSheet 오브젝트 일련번호
     * @return 없슴
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
        var sheetID = sheetObj.id;

        switch(sheetID) {
        case "sheet1":
            with (sheetObj) {

                // 높이 설정
                style.height = 350;
                
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 2, 100);

                var HeadTitle1 = "|Sel.|Seq.|Container|B/L No.|Pick up No.|AVL DT|FRE DT|PICK YD|Remark(s)||CNTR USE||BL_CHCK||YD_CHECK||AVL_CHECK||FRE_CHECK";
                var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false,false);
                

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                
                AutoRowHeight = false;

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus, 30,   daCenter,  false,  "ibflag");
                InitDataProperty(0, cnt++ , dtDummyCheck,   40,   daCenter,  false,  "chk",                   false,  "",    dfNone,  0,  true,  true);
                InitDataProperty(0, cnt++ , dtDataSeq,      30,   daCenter,  false,  "seq");
                                                                                     
                InitDataProperty(0, cnt++ , dtData,         80,   daCenter,  false,  "cntr_no",               false,  "",    dfEngUpKey,    0,  true,  true,  14);
                InitDataProperty(0, cnt++ , dtData,         90,   daCenter,  false,  "bl_no",                 false,  "",    dfEngUpKey,    0,  true,  true,  13);
                InitDataProperty(0, cnt++ , dtData,         80,   daCenter,  false,  "pkup_no",               false,  "",    dfEngUpKey,    0,  true,  true,  20);
                InitDataProperty(0, cnt++ , dtData,         80,   daCenter,  false,  "pkup_aval_dt",          false,  "",    dfUserFormat2, 0,  true,  true);
                InitDataProperty(0, cnt++ , dtData,         80,   daCenter,  false,  "lst_free_dt",           false,  "",    dfUserFormat2, 0,  true,  true);
                InitDataProperty(0, cnt++ , dtData,         70,   daCenter,  false,  "pkup_yd_cd",            false,  "",    dfEngUpKey,    0,  true,  true,  7);                                                                                                                                                                                                                                           
                InitDataProperty(0, cnt++ , dtData,         250,  daLeft,    false,  "remark",                false,  "",    dfNone,        0,  false, false);

                InitDataProperty(0, cnt++ , dtHidden,       40,   daCenter,  false,  "cntr_no_chk_flg",       false,  "",    dfNone,        0,  false, false);
                InitDataProperty(0, cnt++ , dtData,         100,  daCenter,  false,  "cntr_no_chk_msg",       false,  "",    dfNone,        0,  false, false);
                InitDataProperty(0, cnt++ , dtHidden,       40,   daCenter,  false,  "bl_no_chk_flg",         false,  "",    dfNone,        0,  false, false);
                InitDataProperty(0, cnt++ , dtData,         100,  daCenter,  false,  "bl_no_chk_msg",         false,  "",    dfNone,        0,  false, false);
                InitDataProperty(0, cnt++ , dtHidden,       40,   daCenter,  false,  "pkup_yd_cd_chk_flg",    false,  "",    dfNone,        0,  false, false);
                InitDataProperty(0, cnt++ , dtData,         100,  daCenter,  false,  "pkup_yd_cd_chk_msg",    false,  "",    dfNone,        0,  false, false);
                InitDataProperty(0, cnt++ , dtHidden,       40,   daCenter,  false,  "pkup_aval_dt_chk_flg",  false,  "",    dfNone,        0,  false, false);
                InitDataProperty(0, cnt++ , dtData,         100,  daCenter,  false,  "pkup_aval_dt_chk_msg",  false,  "",    dfNone,        0,  false, false);
                InitDataProperty(0, cnt++ , dtHidden,       40,   daCenter,  false,  "lst_free_dt_chk_flg",   false,  "",    dfNone,        0,  false, false);
                InitDataProperty(0, cnt++ , dtData,         100,  daCenter,  false,  "lst_free_dt_chk_msg",   false,  "",    dfNone,        0,  false, false);
                         
                InitUserFormat2(0, "pkup_aval_dt", "####-##-##", "-|:" );
                InitUserFormat2(0, "lst_free_dt", "####-##-##", "-|:" );
                
                InitDataValid(0, "cntr_no", vtEngUpOther, "0123456789");
                InitDataValid(0, "bl_no", vtEngUpOther, "0123456789");
                InitDataValid(0, "pkup_no", vtEngUpOther, "0123456789");
                InitDataValid(0, "pkup_yd_cd", vtEngUpOther, "0123456789");
           }

        break;


        case "sheet2":
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
                InitRowInfo(1, 1, 2, 100);

                var HeadTitle1 = "1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|";
                var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, true, false, true, false,false);
                

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtData,  270,   daLeft,  false,  "col1");
                InitDataProperty(0, cnt++ , dtData,   30,   daLeft,  false,  "col2");
                InitDataProperty(0, cnt++ , dtData,   30,   daLeft,  false,  "col3");
                InitDataProperty(0, cnt++ , dtData,   30,   daLeft,  false,  "col4");
                InitDataProperty(0, cnt++ , dtData,   30,   daLeft,  false,  "col5");
                InitDataProperty(0, cnt++ , dtData,   30,   daLeft,  false,  "col6");
                InitDataProperty(0, cnt++ , dtData,   30,   daLeft,  false,  "col7");
                InitDataProperty(0, cnt++ , dtData,   30,   daLeft,  false,  "col8");
                InitDataProperty(0, cnt++ , dtData,   30,   daLeft,  false,  "col9");
                InitDataProperty(0, cnt++ , dtData,   30,   daLeft,  false,  "col10");
                InitDataProperty(0, cnt++ , dtData,   30,   daLeft,  false,  "col11");
                InitDataProperty(0, cnt++ , dtData,   30,   daLeft,  false,  "col12");
                InitDataProperty(0, cnt++ , dtData,   30,   daLeft,  false,  "col13");
                InitDataProperty(0, cnt++ , dtData,   30,   daLeft,  false,  "col14");
                InitDataProperty(0, cnt++ , dtData,   30,   daLeft,  false,  "col15");
                InitDataProperty(0, cnt++ , dtData,   30,   daLeft,  false,  "col16");
                InitDataProperty(0, cnt++ , dtData,   30,   daLeft,  false,  "col17");
                InitDataProperty(0, cnt++ , dtData,   30,   daLeft,  false,  "col18");
                InitDataProperty(0, cnt++ , dtData,   30,   daLeft,  false,  "col19");
                InitDataProperty(0, cnt++ , dtData,   30,   daLeft,  false,  "col20");
                InitDataProperty(0, cnt++ , dtStatus,  3,   daCenter,false,  "ibflag");
                
                CountPosition = 0;
           }

        break;
        
        
        case "sheet3":
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
                InitRowInfo(1, 1, 2, 100);

                var HeadTitle1 = "Chk|Bkg No|B/L No.|CNTR PRT FLG|Container|TP|AVL DT|FRE DT|Pick up No.|PICK YD|RTN YD|F|O|C|CRE DT|CRE OFC|CRE USER|SN|POD|C LOC|DEL|Filer|TERM|ROUTE GUIDE|RAIL MOVE|TRUCK MOVE|ETA DT||||VSL|DEP DT|ARR DT|";
                var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false);                    

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtData,         40,   daCenter,  false,  "chk_yn",               false,  "",    dfNone,        0,   false,     false);
                InitDataProperty(0, cnt++ , dtData,         60,   daCenter,  false,  "bkg_no",               false,  "",    dfNone,        0,   false,     false);
                InitDataProperty(0, cnt++ , dtData,         100,  daCenter,  false,  "bl_no",                false,  "",    dfNone,        0,   false,     false);
                InitDataProperty(0, cnt++ , dtData,         100,  daCenter,  false,  "cntr_prt_flg",         false,  "",    dfNone,        0,   false,     false);
                
                
                InitDataProperty(0, cnt++ , dtData,         100,  daCenter,  false,  "cntr_no",              false,  "",    dfNone,        0,   false,     false);
                InitDataProperty(0, cnt++ , dtData,         40,   daCenter,  false,  "cntr_tpsz_cd",         false,  "",    dfNone,        0,   false,     false);
                                                                                                                                               
                InitDataProperty(0, cnt++ , dtData,         70,   daCenter,  false,  "pkup_aval_dt",         false,  "",    dfUserFormat2, 0,   true,      true);
                InitDataProperty(0, cnt++ , dtData,         70,   daCenter,  false,  "lst_free_dt",          false,  "",    dfUserFormat2, 0,   true,      true);
                InitDataProperty(0, cnt++ , dtData,         80,   daCenter,  false,  "pkup_no",              false,  "",    dfEngUpKey,    0,   true,      true,    20);
                InitDataProperty(0, cnt++ , dtData,         70,   daCenter,  false,  "pkup_yd_cd",           false,  "",    dfEngUpKey,    0,   true,      true,    7);
                InitDataProperty(0, cnt++ , dtData,         70,   daCenter,  false,  "rtn_yd_cd",            false,  "",    dfEngUpKey,    0,   true,      true,    7);                                                                                                                                            
                                                                                                                                                    
                InitDataProperty(0, cnt++ , dtData,         20,   daCenter,  false,  "frt_clt_flg",          false,  "",    dfNone,        0,   false,     false);
                InitDataProperty(0, cnt++ , dtData,         20,   daCenter,  false,  "obl_rdem_flg",         false,  "",    dfNone,        0,   false,     false);
                InitDataProperty(0, cnt++ , dtData,         20,   daCenter,  false,  "cstms_clr_cd",         false,  "",    dfNone,        0,   false,     false);
                InitDataProperty(0, cnt++ , dtData,         70,   daCenter,  false,  "pkup_cre_dt",          false,  "",    dfUserFormat2, 0,   false,     false);
                InitDataProperty(0, cnt++ , dtData,         70,   daCenter,  false,  "ofc_cd",               false,  "",    dfNone,        0,   false,     false);
                InitDataProperty(0, cnt++ , dtData,         80,   daCenter,  false,  "pkup_cre_usr_id",      false,  "",    dfNone,        0,   false,     false);
                InitDataProperty(0, cnt++ , dtData,         25,   daCenter,  false,  "pkup_ntc_snd_knt",     false,  "",    dfNone,        0,   false,     false);
                                                                                                                                                                                                                                                                                                  
                InitDataProperty(0, cnt++ , dtData,         60,   daCenter,  false,  "pod_cd",               false,  "",    dfNone,        0,   false,     false);
                InitDataProperty(0, cnt++ , dtData,         60,   daCenter,  false,  "ibd_trsp_hub_cd",      false,  "",    dfNone,        0,   false,     false);
                InitDataProperty(0, cnt++ , dtData,         60,   daCenter,  false,  "del_cd",               false,  "",    dfNone,        0,   false,     false);
                InitDataProperty(0, cnt++ , dtData,         50,   daCenter,  false,  "usa_cstms_file_cd",    false,  "",    dfNone,        0,   false,     false);
                InitDataProperty(0, cnt++ , dtData,         60,   daCenter,  false,  "de_term_cd",           false,  "",    dfNone,        0,   false,     false);                                                                                                                                              
                                                                                                                                                   
                InitDataProperty(0, cnt++ , dtData,         200,  daLeft,    false,  "route_guide",          false,  "",    dfNone,        0,   false,     false);
                InitDataProperty(0, cnt++ , dtData,         120,  daCenter,  false,  "rail_move",            false,  "",    dfNone,        0,   false,     false);
                InitDataProperty(0, cnt++ , dtData,         120,  daCenter,  false,  "truck_move",           false,  "",    dfNone,        0,   false,     false);
                InitDataProperty(0, cnt++ , dtData,         120,  daCenter,  false,  "ata_dt",               false,  "",    dfUserFormat2, 0,   false,     false);
                InitDataProperty(0, cnt++ , dtData,         60,   daCenter,  false,  "vsl_cd",               false,  "",    dfNone,        0,   false,     false);
                InitDataProperty(0, cnt++ , dtData,         60,   daCenter,  false,  "skd_voy_no",           false,  "",    dfNone,        0,   false,     false);
                InitDataProperty(0, cnt++ , dtData,         60,   daCenter,  false,  "skd_dir_cd",           false,  "",    dfNone,        0,   false,     false);
                InitDataProperty(0, cnt++ , dtData,         100,  daCenter,  false,  "vvd",                  false,  "",    dfNone,        0,   false,     false);
                InitDataProperty(0, cnt++ , dtData,          70,  daCenter,  false,  "rail_dep_dt",          false,  "",    dfUserFormat2, 0,   false,     false);
                InitDataProperty(0, cnt++ , dtData,          70,  daCenter,  false,  "rail_arr_dt",          false,  "",    dfUserFormat2, 0,   false,     false);

                InitUserFormat2(0, "pkup_aval_dt", "####-##-## ##:##", "-|:" );
                InitUserFormat2(0, "lst_free_dt", "####-##-## ##:##", "-|:" );
                InitUserFormat2(0, "pkup_cre_dt", "####-##-## ##:##:##", "-|:" );
                InitUserFormat2(0, "ata_dt", "####-##-## ##:##:##", "-|:" );                
                InitUserFormat2(0, "rail_dep_dt", "####-##-## ##:##:##", "-|:" );
                InitUserFormat2(0, "rail_arr_dt", "####-##-## ##:##:##", "-|:" );
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
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
        sheetObj.WaitImageVisible = false;

        switch(sAction) {
        
        // File Import
        case IBSEARCH_ASYNC01:
        	
        	var type = ComGetObjValue(formObj.rail_cd);
        	var file = "";
    	    if (type == "CY" || type == "NS") {
        		file = sheetObj.OpenFileDialog("", "", "", "*.xls|*.xls|*.xlsx|*xlsx");	
    	    } else {
        		file = sheetObj.OpenFileDialog("", "", "", "*.txt|*.txt");	
    	    }
        	        	
        	if (file == "" || file == "<USER_CANCEL>") break;

        	
            ComOpenWait(true);

            
        	for (var i=0; i<sheetObjects.length; i++) {
            	sheetObjects[i].RemoveAll();
        	}
        	
       		formObj.file_name.value = file;

    	    if (type == "CY" || type == "NS") {
    	    	sheetObj.LoadExcel(0, 1, file);
    	    } else {
            	if (sheetObj.LoadText(0, "", file) == true) {
            		if (type == "CN") funcWrapFileData();
            	}
    	    }
        	    	    
        	
    	    // 파일 내용 서버로 전송 후 Parsing 결과를 Load
            if(validateForm(sheetObj,formObj,sAction) == false) {
                ComOpenWait(false);
            	break;
            }
            
            if (sheetObj.RowCount < 1) {
                ComOpenWait(false);
            	break;
            }

            
            formObj.f_cmd.value = COMMAND01;
            var sParam = FormQueryString(formObj);
            var sParamSheet1 = sheetObjects[1].GetSaveString();
            if (sParamSheet1 != "") {
                sParam += "&" + ComSetPrifix(sParamSheet1, "sheet1_");
            }
            
            var sXml = sheetObj.GetSearchXml("ESM_BKG_1064GS.do", sParam);

			sheetObjects[0].LoadSearchXml(sXml);
			sheetObjects[0].ColumnSort("bl_no|cntr_no");
			
			fncRemoveFileInfoDup();
			
			ComOpenWait(false);
			
            break;
            
            
            
            // Sheet 데이터를 Verify 후 유효한 데이터에 한하여 메인 화면으로 
            // 데이터 이전. (단, 체크 데이터 한정)
        case IBSEARCH_ASYNC02:
        	
        	if (sheetObj.RowCount == 0) {
        		ComShowCodeMessage("BKG40055");
        		break;
        	}
        	
            if (sheetObj.CheckedRows("chk")  < 1) {
        		ComShowCodeMessage("BKG00249");
        		break;
            }

            ComOpenWait(true);
            
            formObj.f_cmd.value = COMMAND02;
            var sParam = FormQueryString(formObj);
            var sParamSheet1 = sheetObj.GetSaveString(true);
            if (sParamSheet1 != "") {
                sParam += "&" + ComSetPrifix(sParamSheet1, "sheet1_");
            }
        
            var sXml = sheetObj.GetSearchXml("ESM_BKG_1064GS.do", sParam);
            var arrXml = sXml.split("|$$|");

            sheetObjects[0].LoadSearchXml(arrXml[0]); // 조회 결과
            sheetObjects[2].LoadSearchXml(arrXml[1]); // Upload 조회
            
            fncVerifyAfter();
            
            ComOpenWait(false);
            			
            if (sheetObjects[0].RowCount == 0) {
            	window.close();
            }
            
        	break;
        	
        	
        	
        	// New
        case IBRESET:
        	
        	if (ComIsModifiedSheets(sheetObj) == true) {
            	if (ComShowCodeMessage("BKG00254") == true) {
            		doActionIBSheet(sheetObj,formObject,IBSEARCH_ASYNC02);
                	break;
            	}
        	}
        	
        	for (var i=0; i<sheetObjects.length; i++) {
            	sheetObjects[i].RemoveAll();
        	}
        	
        	initForm();
        	
        	break;
        	
        	
        	
        	// Dow Excel
        case IBDOWNEXCEL:
        	sheetObj.SpeedDown2Excel(-1, false, false, "","", false, false, "", false, "", "", true, true);

        	break;
        }
    }
    
    
    /**
     * File 업로드(Text 파일 한정) 후 이메일 내용 앞뒤에 구분자를 추가한다. <br>
     * (자바에서 공백이 사라지는 것을 방지하기 위해)
     * 
     * @return 없슴
     */
    function funcWrapFileData() {
    	var sheetObj = sheetObjects[1];
    	var iRow = 0;
    	var val = "";
    	
    	with(sheetObj) {
        	for (var i=0; i<RowCount; i++) {
        		iRow = i+1;
        		
        		val = CellValue(iRow, "col1");
        		CellValue2(iRow, "col1") = "[" + val + "]";
        	}
    	}
    }    
    
    
    /**
     * 중복 데이터 자동 삭제 처리한다.(Container No. 비교하여 삭제) <br>
     * @return 없슴
     */
    function fncRemoveFileInfoDup() {
    	with(sheetObjects[0]) {
    		
			if (ColValueDup("bl_no|cntr_no") > 0) {
				var len = RowCount;
				for (var i=0; i<len; i++) {
					for (var j=len-1; j>i; j--) {
						if ( (CellValue(i+1, "bl_no") == CellValue(j+1, "bl_no")) &&
								(CellValue(i+1, "cntr_no") == CellValue(j+1, "cntr_no")) ) 
						{
							RowDelete(j+1, false);
						}
					}
					
					len = RowCount;
				}
			}
    	}
    }
    
    
    /**
     * Verify 완료 후 호출되는 함수
     * 유효한 데이터를 호출한 화면으로 이동시킨다.
     * 즉, 체크결과가 모두 Y인 Sheet1 데이터를 쉬트에서 삭제하고 
     * Sheet1 데이터가 재검색된 Sheet3 데이터를 호출한 화면으로 복사한다.
     * @return 없슴
     */
    function fncVerifyAfter() {
		with(sheetObjects[0]) {
			for(var i=RowCount; i>0; i--) {
    			if (CellValue(i, "chk") == "1" &&
					CellValue(i, "cntr_no_chk_flg")      == "Y" &&
					CellValue(i, "bl_no_chk_flg")        == "Y" &&
					CellValue(i, "pkup_aval_dt_chk_flg") == "Y" &&
					CellValue(i, "lst_free_dt_chk_flg")  == "Y" &&
					CellValue(i, "pkup_yd_cd_chk_flg")   == "Y") 
				{
					RowDelete(i, false);
				}
			}
		}

    	dialogArguments.fncSetPkupNo(fncGetPkupNo(sheetObjects[2]));     
    }
    

    /**
     * 유효한 데이터를 메인 페이지로 이동한다.
     * 
     * @param {ibsheet} sheetObj 필수,IBSheet 오브젝트
     * @return 없슴
     */
    function fncGetPkupNo(sheetObj) {
    	var resultList = new Array();
    	var obj = null;
    	var cnt = 0;
    	
    	with (sheetObj) {	

    		var idx = 0;

        	for (var i=0; i<RowCount; i++) {
    			idx = i+1;
    			
				obj = new Object(); 

				obj.chk  			     = CellValue(idx, "chk_yn")=="Y"?"1":"0";
				obj.bkg_no               = CellValue(idx, "bkg_no");
				obj.bl_no                = CellValue(idx, "bl_no");
				obj.cntr_prt_flg         = CellValue(idx, "cntr_prt_flg");
				obj.cntr_no              = CellValue(idx, "cntr_no");
				obj.cntr_tpsz_cd         = CellValue(idx, "cntr_tpsz_cd");
				obj.pkup_aval_dt         = CellValue(idx, "pkup_aval_dt");
				obj.lst_free_dt          = CellValue(idx, "lst_free_dt");
				obj.pkup_no              = CellValue(idx, "pkup_no");
				obj.pkup_yd_cd           = CellValue(idx, "pkup_yd_cd");
				obj.rtn_yd_cd            = CellValue(idx, "rtn_yd_cd");
				obj.frt_clt_flg          = CellValue(idx, "frt_clt_flg");
				obj.obl_rdem_flg         = CellValue(idx, "obl_rdem_flg");
				obj.cstms_clr_cd         = CellValue(idx, "cstms_clr_cd");
				obj.pkup_cre_dt          = CellValue(idx, "pkup_cre_dt");
				obj.ofc_cd               = CellValue(idx, "ofc_cd");
				obj.pkup_cre_usr_id      = CellValue(idx, "pkup_cre_usr_id");
				obj.pkup_ntc_snd_knt     = CellValue(idx, "pkup_ntc_snd_knt");
				obj.pod_cd               = CellValue(idx, "pod_cd");
				obj.ibd_trsp_hub_cd      = CellValue(idx, "ibd_trsp_hub_cd");
				obj.del_cd               = CellValue(idx, "del_cd");
				obj.usa_cstms_file_cd    = CellValue(idx, "usa_cstms_file_cd");
				obj.de_term_cd           = CellValue(idx, "de_term_cd");
				obj.route_guide          = CellValue(idx, "route_guide");
				obj.rail_move            = CellValue(idx, "rail_move");
				obj.truck_move           = CellValue(idx, "truck_move");
				obj.ata_dt               = CellValue(idx, "ata_dt");
                obj.vsl_cd               = CellValue(idx, "vsl_cd");
                obj.skd_voy_no           = CellValue(idx, "skd_voy_no");
                obj.skd_dir_cd           = CellValue(idx, "skd_dir_cd");
				obj.vvd                  = CellValue(idx, "vvd");
				obj.rail_dep_dt          = CellValue(idx, "rail_dep_dt");
				obj.rail_arr_dt          = CellValue(idx, "rail_arr_dt");
				
				resultList[cnt++] = obj;
    		}
    	}
    	
    	return resultList;
    }


    /**
    * Sheet1 Click 이벤트 발생 처리<br>
    * 
    * @param {ibsheet} sheetObj 필수. Sheet ID
    * @param {int}     Row      필수. Sheet Row
    * @param {int}     Col      필수. Sheet Col
    * @return 없슴
    * @author 박미옥
    */
    function sheet1_OnClick(sheetObj, row, col) {

        switch(sheetObj.ColSaveName(col)) {
        case "remark":
        	if (sheetObj.CellValue(row, col) != "") {
            	ComShowMemoPad(sheetObj, row, col, true, 300, 100, 200 );
            }
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
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
        }

        return true;
    }


	/* 개발자 작업  끝 */