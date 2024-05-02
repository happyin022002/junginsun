/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0668_07.js
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 안진응
*@LastVersion : 1.0
* 2009.12.16 안진응
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
     * @class esm_bkg_0668_07 : esm_bkg_0668_07 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0668_07() {
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

    var sheetObjects = new Array();
    var sheetCnt = 0;

    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;
    var t1beforetab = 1;
    var t2beforetab = 1;
    
    var t7sheet1 = 0;
    var t7sheet2 = 1;
    var t7sheet3 = 2;
    
    var comboFlg = null;
    var cntrQtySum = 0;
    
    var chgFlag = null;
    var frt_term_cd = null;

    var t6previewSheet = 1;
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

             /*******************************************************/
             var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

                switch(srcName) {

                    case "btn_t7TemplateAuto": //"btn_t7TemplateAuto"
	                	var param="?pgmNo=ESM_BKG_0411";
//                    	ComOpenWindow("/hanjin/ESM_BKG_0411.do"+ param, "myWin", "scroll:no;status:no;help:no;dialogWidth:1024px;dialogHeight:470px;dialogLeft:0;dialogTop:0", true);
                    	
                    	ComOpenWindowCenter("/hanjin/ESM_BKG_0411.do"+ param, "ESM_BKG_0411", 1024, 710, true);
                		break;
                    case "btn_t7TemplateManual": //"btn_t7TemplateManual"
	                	var param="?pgmNo=ESM_BKG_1034";
//                		ComOpenWindow("/hanjin/ESM_BKG_1034.do"+ param, "myWin", "scroll:no;status:no;help:no;dialogWidth:1024px;dialogHeight:370px;dialogLeft:0;dialogTop:0", true);
                		ComOpenWindowCenter("/hanjin/ESM_BKG_1034.do"+ param, "ESM_BKG_1034", 1024, 650, true);
                    	break;
                    case "btn_t7SendManual": //"btn_t7SendManual"
//                    	if (sheetObjects[t7sheet1].RowCount == 0) return;

//	                	var bl_no = sheetObjects[sheetObjects.length-1].CellValue(1, "sheet2_bl_no");
	                	var bl_no = document.form.bl_no.value;

	                	var param="?pgmNo=ESM_BKG_1066&bl_no="+bl_no;
                    	
//                    	ComOpenWindow("/hanjin/ESM_BKG_1066.do"+ param, "myWin", "scroll:no;status:no;help:no;dialogWidth:1024px;dialogHeight:610px;dialogLeft:0;dialogTop:0", true);
                    	ComOpenWindowCenter("/hanjin/ESM_BKG_1066.do"+ param, "ESM_BKG_1066", 1024, 690, true);
                    	break;
                    case "btn_t7Preview": //"btn_t7Preview"
                    	fnPreview();
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
                
            	if (sheetObjects[i].id == "t7sheet1") {
                    initSheet(sheetObjects[i],i+1);            		
            	} else {
	            	ComConfigSheet (sheetObjects[i] );
	
	                initSheet(sheetObjects[i],i+1);
	
	                ComEndConfigSheet(sheetObjects[i]);
            	}
            }

            for(k=0;k<tabObjects.length;k++){
                initTab(tabObjects[k],k+1);
            }
            
//            document.form.bkg_no.value = "TAOYTS93P05";
			
			if (document.form.bkg_no.value != "") {
				fnSearch();
			}
            
        }

  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        var sheetID = sheetObj.id;
        
        switch(sheetID) {

//            case "sheet2":
//            	
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
//                   //전체Edit 허용 여부 [선택, Default false]
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
//					InitDataProperty(0, cnt++ , dtHiddenStatus,     30,	daCenter,  true,	 prefix + "ibflag");
//					InitDataProperty(0, cnt++ , dtData,      	    50,	daCenter,  false,    prefix + "partial",    		false,          "",      dfNone,      0,     false);
//					InitDataProperty(0, cnt++ , dtData,      		50,	daCenter,  false,    prefix + "bl_no",            	false,          "",      dfNone,      0,     false);
//					InitDataProperty(0, cnt++ , dtData,      		30,	daCenter,  false,    prefix + "bkg_no",   		    false,          "",      dfNone,      0,     false);
//					InitDataProperty(0, cnt++ , dtData,      		30,	daCenter,  false,    prefix + "split_flg", 		    false,          "",      dfNone,      0,     false);
//					InitDataProperty(0, cnt++ , dtData,			    30,	daCenter,	false,	 prefix + "bl_tp_cd",		    false,		    "",		dfNone,			0,		false,		true);
//					
//					CountPosition = 0;
//
//                }
//            	break;
			

            case "t7sheet1":      //t7sheet1 init
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
                    InitRowInfo(1, 1, 3, 100);

                    var HeadTitle = "|Cust Cd|Cust Nm|Pod Cd|Del Cd|Cust Addr|Cust_Seq|bkg cust tp cd|cust cnt cd";
                    var headCount = ComCountHeadTitle(HeadTitle);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
                    
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, false, true, true, false,false)
                    
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    var prefix = "t7sheet1_";

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,      0,     daCenter,    true,        prefix + "ibflag");
                    InitDataProperty(0, cnt++ , dtData,              70,    daCenter,    false,       prefix + "cust_cd",          false,      "",      dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,              80,    daCenter,    false,       prefix + "cust_nm",          false,      "",      dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,              60,    daCenter,    false,       prefix + "pod_cd",           false,      "",      dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,              60,    daCenter,    false,       prefix + "del_cd",           false,      "",      dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,              70,    daCenter,    false,       prefix + "cust_addr",        false,      "",      dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,              70,    daCenter,    false,       prefix + "cust_seq",         false,      "",      dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,              70,    daCenter,    false,       prefix + "bkg_cust_tp_cd",   false,      "",      dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,              70,    daCenter,    false,       prefix + "cust_cnt_cd",      false,      "",      dfNone,      0,     true,       true);
                    
                    CountPosition = 0;
                }
                break;

            case "t7sheet2":      //t7sheet2 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 135;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
                    
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;
                    
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;
                    
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

                    
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, false, false, true, false,false);

                    var HeadTitle1 = "|Seq|Container No.|Type|CNEE/NTFY|CNEE/NTFY #2|BROKER #1|BROKER #2|A.NOTIFY|CNEE/NTFY|CNEE/NTFY #2|BROKER #1|BROKER #2|One Time Only|E_CD1|E_CD2|E_CD3|E_CD4|E_CD5|E_NM1|E_NM2|E_NM3|E_NM4|E_NM5|F_CD1|F_CD2|F_CD3|F_CD4|F_CD5|F_NM1|F_NM2|F_NM3|F_NM4|F_NM5|Result Date|E_GDT|Sent ID|Result Date|F_GDT|Sent ID|Remark|Bkg No";

                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
                    
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    
                    var prefix = "t7sheet2_";

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,      0,     daCenter,    true,        prefix + "ibflag");
					InitDataProperty(0,	cnt++,	dtSeq,			    30, 	daCenter,	false,	      prefix + "seq");
                    InitDataProperty(0, cnt++ , dtData,              100,   daCenter,    true,        prefix + "cntr_no",           false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              80,    daCenter,    true,        prefix + "pkup_ntc_tp_cd",    false,      "",      dfNone,      0,     false,       false);

                    InitDataProperty(0, cnt++ , dtData,              100,   daLeft  ,    false,       prefix + "ntc_eml1",          false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              100,   daLeft  ,    false,       prefix + "ntc_eml2",          false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              100,   daLeft  ,    false,       prefix + "ntc_eml3",          false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              100,   daLeft  ,    false,       prefix + "ntc_eml4",          false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              100,   daLeft  ,    false,       prefix + "ntc_eml5",          false,      "",      dfNone,      0,     false,       false);
                    
                    InitDataProperty(0, cnt++ , dtData,              100,   daLeft  ,    false,       prefix + "fax_no1",           false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              100,   daLeft  ,    false,       prefix + "fax_no2",           false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              100,   daLeft  ,    false,       prefix + "fax_no3",           false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              100,   daLeft  ,    false,       prefix + "fax_no4",           false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              100,   daLeft  ,    false,       prefix + "fax_no5",           false,      "",      dfNone,      0,     false,       false);
                    

                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "eml_snd_rslt_cd1",        false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "eml_snd_rslt_cd2",        false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "eml_snd_rslt_cd3",        false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "eml_snd_rslt_cd4",        false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "eml_snd_rslt_cd5",        false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "eml_snd_rslt_nm1",        false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "eml_snd_rslt_nm2",        false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "eml_snd_rslt_nm3",        false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "eml_snd_rslt_nm4",        false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "eml_snd_rslt_nm5",        false,      "",      dfNone,      0,     false,       false);
                    
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "fax_snd_rslt_cd1",       false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "fax_snd_rslt_cd2",       false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "fax_snd_rslt_cd3",       false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "fax_snd_rslt_cd4",       false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "fax_snd_rslt_cd5",       false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "fax_snd_rslt_nm1",       false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "fax_snd_rslt_nm2",       false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "fax_snd_rslt_nm3",       false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "fax_snd_rslt_nm4",       false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "fax_snd_rslt_nm5",       false,      "",      dfNone,      0,     false,       false);

                    InitDataProperty(0, cnt++ , dtData,              100,   daCenter,    true,        prefix + "eml_snd_dt",        false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "eml_snd_gdt",       false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              100,   daCenter,    true,        prefix + "eml_snd_id",        false,      "",      dfNone,      0,     false,       false);

                    
                    InitDataProperty(0, cnt++ , dtData,              100,   daCenter,    true,        prefix + "fax_snd_dt",        false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "fax_snd_gdt",       false,      "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,              100,   daCenter,    true,        prefix + "fax_snd_id",        false,      "",      dfNone,      0,     false,       false);
                    
                    InitDataProperty(0, cnt++ , dtData,              150,   daCenter,    true,        prefix + "diff_rmk",          false,      "",      dfNone,      0,     false,       false);

                    InitDataProperty(0, cnt++ , dtHidden,            80,    daCenter,    true,        prefix + "bkg_no",            false,      "",      dfNone,      0,     false,       false);
                    
                    CountPosition = 0;
                    
                 // 문장이 길경우 글자 사이즈에 따라 [...] 으로 표시함
        			Ellipsis = true;
                }
                break;

            case "t7sheet3":      //t7sheet3 init
            with (sheetObj) {
                // 높이 설정
                style.height = 135;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;
                
                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                
                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;
                
                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;
                
                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 3, 100);

                
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, false, false, true, false,false);

                var HeadTitle1 = "|Seq|Container No.|Type|CNEE/NTFY|CNEE/NTFY #2|BROKER #1|BROKER #2|A.NOTIFY|CNEE/NTFY|CNEE/NTFY #2|BROKER #1|BROKER #2|One Time Only|E_CD1|E_CD2|E_CD3|E_CD4|E_CD5|E_NM1|E_NM2|E_NM3|E_NM4|E_NM5|F_CD1|F_CD2|F_CD3|F_CD4|F_CD5|F_NM1|F_NM2|F_NM3|F_NM4|F_NM5|Result Date|E_GDT|Sent ID|Result Date|F_GDT|Sent ID|Remark|Bkg No";

                var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
                
                
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                
                var prefix = "t7sheet3_";

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,      0,     daCenter,    true,        prefix + "ibflag");
				InitDataProperty(0,	cnt++,	dtSeq,			    30, 	daCenter,	false,	      prefix + "seq");
                InitDataProperty(0, cnt++ , dtData,              100,   daCenter,    true,        prefix + "cntr_no",           false,      "",      dfNone,      0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,              80,    daCenter,    true,        prefix + "pkup_ntc_tp_cd",    false,      "",      dfNone,      0,     false,       false);

                InitDataProperty(0, cnt++ , dtData,              100,   daLeft  ,    false,       prefix + "ntc_eml1",          false,      "",      dfNone,      0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,              100,   daLeft  ,    false,       prefix + "ntc_eml2",          false,      "",      dfNone,      0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,              100,   daLeft  ,    false,       prefix + "ntc_eml3",          false,      "",      dfNone,      0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,              100,   daLeft  ,    false,       prefix + "ntc_eml4",          false,      "",      dfNone,      0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,              100,   daLeft  ,    false,       prefix + "ntc_eml5",          false,      "",      dfNone,      0,     false,       false);
                
                InitDataProperty(0, cnt++ , dtData,              100,   daLeft  ,    false,       prefix + "fax_no1",           false,      "",      dfNone,      0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,              100,   daLeft  ,    false,       prefix + "fax_no2",           false,      "",      dfNone,      0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,              100,   daLeft  ,    false,       prefix + "fax_no3",           false,      "",      dfNone,      0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,              100,   daLeft  ,    false,       prefix + "fax_no4",           false,      "",      dfNone,      0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,              100,   daLeft  ,    false,       prefix + "fax_no5",           false,      "",      dfNone,      0,     false,       false);
                

                InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "eml_snd_rslt_cd1",        false,      "",      dfNone,      0,     false,       false);
                InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "eml_snd_rslt_cd2",        false,      "",      dfNone,      0,     false,       false);
                InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "eml_snd_rslt_cd3",        false,      "",      dfNone,      0,     false,       false);
                InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "eml_snd_rslt_cd4",        false,      "",      dfNone,      0,     false,       false);
                InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "eml_snd_rslt_cd5",        false,      "",      dfNone,      0,     false,       false);
                InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "eml_snd_rslt_nm1",        false,      "",      dfNone,      0,     false,       false);
                InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "eml_snd_rslt_nm2",        false,      "",      dfNone,      0,     false,       false);
                InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "eml_snd_rslt_nm3",        false,      "",      dfNone,      0,     false,       false);
                InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "eml_snd_rslt_nm4",        false,      "",      dfNone,      0,     false,       false);
                InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "eml_snd_rslt_nm5",        false,      "",      dfNone,      0,     false,       false);
                
                InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "fax_snd_rslt_cd1",       false,      "",      dfNone,      0,     false,       false);
                InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "fax_snd_rslt_cd2",       false,      "",      dfNone,      0,     false,       false);
                InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "fax_snd_rslt_cd3",       false,      "",      dfNone,      0,     false,       false);
                InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "fax_snd_rslt_cd4",       false,      "",      dfNone,      0,     false,       false);
                InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "fax_snd_rslt_cd5",       false,      "",      dfNone,      0,     false,       false);
                InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "fax_snd_rslt_nm1",       false,      "",      dfNone,      0,     false,       false);
                InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "fax_snd_rslt_nm2",       false,      "",      dfNone,      0,     false,       false);
                InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "fax_snd_rslt_nm3",       false,      "",      dfNone,      0,     false,       false);
                InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "fax_snd_rslt_nm4",       false,      "",      dfNone,      0,     false,       false);
                InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "fax_snd_rslt_nm5",       false,      "",      dfNone,      0,     false,       false);

                InitDataProperty(0, cnt++ , dtData,              100,   daCenter,    true,        prefix + "eml_snd_dt",        false,      "",      dfNone,      0,     false,       false);
                InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "eml_snd_gdt",       false,      "",      dfNone,      0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,              100,   daCenter,    true,        prefix + "eml_snd_id",        false,      "",      dfNone,      0,     false,       false);

                
                InitDataProperty(0, cnt++ , dtData,              100,   daCenter,    true,        prefix + "fax_snd_dt",        false,      "",      dfNone,      0,     false,       false);
                InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,    true,        prefix + "fax_snd_gdt",       false,      "",      dfNone,      0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,              100,   daCenter,    true,        prefix + "fax_snd_id",        false,      "",      dfNone,      0,     false,       false);
                
                InitDataProperty(0, cnt++ , dtData,              150,   daCenter,    true,        prefix + "diff_rmk",          false,      "",      dfNone,      0,     false,       false);

                InitDataProperty(0, cnt++ , dtHidden,            80,    daCenter,    true,        prefix + "bkg_no",            false,      "",      dfNone,      0,     false,       false);
                
                CountPosition = 0;
                
             // 문장이 길경우 글자 사이즈에 따라 [...] 으로 표시함
    			Ellipsis = true;
            }
            break;
                        
        }
    }

      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            //sheetObj.ShowDebugMsg = false;
            switch(sAction) {

               case IBSEARCH:      //조회
                	ComOpenWait(true);
           			sheetObjects[t7sheet1].WaitImageVisible = false;
           			
           			formObj.f_cmd.value = SEARCH;
           			
           			var aryPrefix = new Array("t7sheet1_", "t7sheet2_", "t7sheet3_"); //prefix 문자열 배열
                    var sXml = sheetObj.GetSearchXml("ESM_BKG_0668_07GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
	        		
	         		var arrXml = sXml.split("|$$|");

         			sheetObjects[t7sheet1].Redraw = false;
         			sheetObjects[t7sheet1].WaitImageVisible = false;
         			sheetObjects[t7sheet1].LoadSearchXml(arrXml[0]);
         			sheetObjects[t7sheet1].Redraw = true;

         			sheetObjects[t7sheet2].Redraw = false;
         			sheetObjects[t7sheet2].WaitImageVisible = false;
         			sheetObjects[t7sheet2].LoadSearchXml(arrXml[1]);
         			sheetObjects[t7sheet2].Redraw = true;

         			sheetObjects[t7sheet3].Redraw = false;
         			sheetObjects[t7sheet3].WaitImageVisible = false;
         			sheetObjects[t7sheet3].LoadSearchXml(arrXml[2]);
         			sheetObjects[t7sheet3].Redraw = true;

//         			sheetObjects[sheetObjects.length-1].Redraw = false;
//         			sheetObjects[sheetObjects.length-1].WaitImageVisible = false;
//         			sheetObjects[sheetObjects.length-1].LoadSearchXml(arrXml[3]);
//         			sheetObjects[sheetObjects.length-1].Redraw = true;
	         		
	         		sheetObjects[t7sheet1].WaitImageVisible = true;

	         		ComOpenWait(false);

                    break;
            }
        }

        /** 
         * isFloat(str) : 숫자값인지 체크, '.' 포함
         */ 
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
        
	     
     /**
     * 화면의 버튼을 비 활성화 시킨다.
     */
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

    function fnPickupClear() {
     	document.form.frm_t7sheet1_cust_cd_c.value = "";
     	document.form.frm_t7sheet1_cust_nm_c.value = "";
     	document.form.frm_t7sheet1_cust_addr_c.value = "";
     	document.form.frm_t7sheet1_cust_cd_n.value = "";
     	document.form.frm_t7sheet1_cust_nm_n.value = "";
     	document.form.frm_t7sheet1_cust_addr_n.value = "";
     	document.form.frm_t7sheet1_cust_cd_a.value = "";
     	document.form.frm_t7sheet1_cust_nm_a.value = "";

     	sheetObjects[t7sheet1].RemoveAll();
    	sheetObjects[t7sheet2].RemoveAll();
    	sheetObjects[t7sheet3].RemoveAll();
//     	sheetObjects[sheetObjects.length-1].RemoveAll();
    }	 	   
	        
    //화면의 조회 처리 모듈을 통합적으로 관리한다.
    function fnSearch() {
		doActionIBSheet(sheetObjects[t7sheet1],document.form,IBSEARCH);
    }

    /**
     * t7sheet1_OnSearchEnd 체크 로직
     */
   function t7sheet1_OnSearchEnd(sheetObj, ErrMsg){
        cntrQtySum = 0;
      	var maxRow = sheetObj.LastRow;
      	var prefix = "t7sheet1_";
      	var cellValue = "";
      	
         if (ErrMsg == "") {
             if(sheetObj.RowCount > 0){
          		for(i=1;i <= maxRow ; i++){
          			cellValue = sheetObj.CellValue( i,prefix + "bkg_cust_tp_cd");
          			
          			if (cellValue == "C") {
          				document.form.frm_t7sheet1_cust_cd_c.value = sheetObj.CellValue(i, prefix + "cust_cd");
          				document.form.frm_t7sheet1_cust_nm_c.value = sheetObj.CellValue(i, prefix + "cust_nm");
          				document.form.frm_t7sheet1_cust_addr_c.value = sheetObj.CellValue(i, prefix + "cust_addr");
          			} else if (cellValue == "N") {
          				document.form.frm_t7sheet1_cust_cd_n.value = sheetObj.CellValue(i, prefix + "cust_cd");
          				document.form.frm_t7sheet1_cust_nm_n.value = sheetObj.CellValue(i, prefix + "cust_nm");
          				document.form.frm_t7sheet1_cust_addr_n.value = sheetObj.CellValue(i, prefix + "cust_addr");        				
          			} else if (cellValue == "A") {
          				document.form.frm_t7sheet1_cust_cd_a.value = sheetObj.CellValue(i, prefix + "cust_cd");
          				document.form.frm_t7sheet1_cust_nm_a.value = sheetObj.CellValue(i, prefix + "cust_nm");
          			}
          		}         	   
             }
         } else {
        	 fnPickupClear();
         }
   }        	  
   
   /**
    * t7sheet2_OnSearchEnd 체크 로직
    */
    function t7sheet2_OnSearchEnd(sheetObj, ErrMsg){
        cntrQtySum = 0;
        
        if (ErrMsg == "") {
            if(sheetObj.RowCount > 0){
        		var maxRow = sheetObj.LastRow;
        		var cellValue = "";
        		var prefix = "t7sheet2_";
        		for(i=1;i <= maxRow ; i++){

         			//전송상태에 따라 글자색 설정
         			for(var q=1;q<6;q++){
         				// EMAIL
         				// 이메일 전송 성공/실패 코드 - EML_PROC_STS_CD
         				cellValue = sheetObj.CellValue( i,prefix + "eml_snd_rslt_cd"+q);

        				if(cellValue == "R"){  // 실패,빨간색
        					sheetObj.CellFontColor(i,prefix + "ntc_eml"+q) = sheetObj.RgbColor(255,0,0);
        				}else if(cellValue == "B"){  // 성공,파란색
        					sheetObj.CellFontColor(i,prefix + "ntc_eml"+q) = sheetObj.RgbColor(0,0,255);
        				}else if(cellValue == "X"){  // 검은색
        					sheetObj.CellFontColor(i,prefix + "ntc_eml"+q) = sheetObj.RgbColor(0,0,0);
        				}else if(cellValue == "P"){  // 진행중,핑크색
        					sheetObj.CellFontColor(i,prefix + "ntc_eml"+q) = sheetObj.RgbColor(255,0,192);
        				}

         				cellValue = sheetObj.CellValue( i,prefix + "eml_snd_rslt_nm"+q);
        				if(cellValue != "") {
        					sheetObj.ToolTipText(i, prefix + "ntc_eml"+q) = cellValue;
        				}

        				//FAX
        				cellValue = sheetObj.CellValue( i,prefix + "fax_snd_rslt_cd"+q);
        				if(cellValue == "R"){  // 실패,빨간색
        					sheetObj.CellFontColor(i,prefix + "fax_no"+q) = sheetObj.RgbColor(255,0,0);
        				}else if(cellValue == "B"){  // 성공,파란색
        					sheetObj.CellFontColor(i,prefix + "fax_no"+q) = sheetObj.RgbColor(0,0,255);
        				}else if(cellValue == "X"){  // 검은색
        					sheetObj.CellFontColor(i,prefix + "fax_no"+q) = sheetObj.RgbColor(0,0,0);
        				}else if(cellValue == "P"){  // 진행중,핑크색
        					sheetObj.CellFontColor(i,prefix + "fax_no"+q) = sheetObj.RgbColor(255,0,192);
        				}

        				cellValue = sheetObj.CellValue( i,prefix + "fax_snd_rslt_nm"+q);
        				if(cellValue != "") {
        					sheetObj.ToolTipText(i, prefix + "fax_no"+q) = cellValue;
        				}
         			
         			}
         			
         			cellValue = sheetObj.CellValue( i,prefix + "eml_snd_gdt");
            		if(cellValue != "") {
    					sheetObj.ToolTipText(i, prefix + "eml_snd_dt") = cellValue;
    				}
        		
	        		cellValue = sheetObj.CellValue(i,prefix + "fax_snd_gdt");
	        		if(cellValue != "") {
						sheetObj.ToolTipText(i, prefix + "fax_snd_dt") = cellValue;
					}
        		}
            }
        }
    }        
		       
    /**
     * t7sheet3_OnSearchEnd 체크 로직
     */
    function t7sheet3_OnSearchEnd(sheetObj, ErrMsg){
         cntrQtySum = 0;
         
         if (ErrMsg == "") {
             if(sheetObj.RowCount > 0){
         		var maxRow = sheetObj.LastRow;
         		var cellValue = "";
         		var prefix = "t7sheet2_";
         		for(i=1;i <= maxRow ; i++){

          			//전송상태에 따라 글자색 설정
          			for(var q=1;q<6;q++){
          				// EMAIL
          				// 이메일 전송 성공/실패 코드 - EML_PROC_STS_CD
          				cellValue = sheetObj.CellValue( i,prefix + "eml_snd_rslt_cd"+q);

         				if(cellValue == "R"){  // 실패,빨간색
         					sheetObj.CellFontColor(i,prefix + "ntc_eml"+q) = sheetObj.RgbColor(255,0,0);
         				}else if(cellValue == "B"){  // 성공,파란색
         					sheetObj.CellFontColor(i,prefix + "ntc_eml"+q) = sheetObj.RgbColor(0,0,255);
         				}else if(cellValue == "X"){  // 검은색
         					sheetObj.CellFontColor(i,prefix + "ntc_eml"+q) = sheetObj.RgbColor(0,0,0);
         				}else if(cellValue == "P"){  // 진행중,핑크색
         					sheetObj.CellFontColor(i,prefix + "ntc_eml"+q) = sheetObj.RgbColor(255,0,192);
         				}

          				cellValue = sheetObj.CellValue( i,prefix + "eml_snd_rslt_nm"+q);
         				if(cellValue != "") {
         					sheetObj.ToolTipText(i, prefix + "ntc_eml"+q) = cellValue;
         				}

         				//FAX
         				cellValue = sheetObj.CellValue( i,prefix + "fax_snd_rslt_cd"+q);
         				if(cellValue == "R"){  // 실패,빨간색
         					sheetObj.CellFontColor(i,prefix + "fax_no"+q) = sheetObj.RgbColor(255,0,0);
         				}else if(cellValue == "B"){  // 성공,파란색
         					sheetObj.CellFontColor(i,prefix + "fax_no"+q) = sheetObj.RgbColor(0,0,255);
         				}else if(cellValue == "X"){  // 검은색
         					sheetObj.CellFontColor(i,prefix + "fax_no"+q) = sheetObj.RgbColor(0,0,0);
         				}else if(cellValue == "P"){  // 진행중,핑크색
         					sheetObj.CellFontColor(i,prefix + "fax_no"+q) = sheetObj.RgbColor(255,0,192);
         				}

         				cellValue = sheetObj.CellValue( i,prefix + "fax_snd_rslt_nm"+q);
         				if(cellValue != "") {
         					sheetObj.ToolTipText(i, prefix + "fax_no"+q) = cellValue;
         				}
          			
          			}
          			
          			cellValue = sheetObj.CellValue( i,prefix + "eml_snd_gdt");
             		if(cellValue != "") {
     					sheetObj.ToolTipText(i, prefix + "eml_snd_dt") = cellValue;
     				}
         		
 	        		cellValue = sheetObj.CellValue(i,prefix + "fax_snd_gdt");
 	        		if(cellValue != "") {
 						sheetObj.ToolTipText(i, prefix + "fax_snd_dt") = cellValue;
 					}
         		}
             }
         }
    }        
     
     /**
      * IBTab Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setTabObject(tab_obj){
         tabObjects[tabCnt++] = tab_obj;
     }


     /**
      * Tab 기본 설정
      * 탭의 항목을 설정한다.
      */
    function initTab(tabObj , tabNo) {
          
     	 switch(tabNo) {
              case 1:
                	 with (tabObj) {

                      var cnt  = 0 ;
                      InsertTab( cnt++ , "Fax" , -1 );
                      InsertTab( cnt++ , "E-mail" , -1 );

           			BaseColor = "#F3F2F8";             			
                 }
                 break;
             case 2:
            	 with (tabObj) {

            		 var cnt  = 0 ;
            		 InsertTab( cnt++ , "Fax" , -1 );
            		 InsertTab( cnt++ , "E-mail" , -1 );

            		 BaseColor = "#F3F2F8";             			
            	 }
            	 break;

          }
    }

    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     *  B/L Info 안에 들어있는 텝
     */
    function t7tab1_OnChange(tabObj , nItem)
     {
    	 	var prefix = "t7sheet2_";
    	 	var sheetObj = sheetObjects[t7sheet2];
    	 	
			if(nItem == 0){//Fax
			
				sheetObj.ColHidden(prefix + "ntc_eml1") = true;
				sheetObj.ColHidden(prefix + "ntc_eml2") = true;
				sheetObj.ColHidden(prefix + "ntc_eml3") = true;
				sheetObj.ColHidden(prefix + "ntc_eml4") = true;
				sheetObj.ColHidden(prefix + "ntc_eml5") = true;

//				sheetObj.ColHidden(prefix + "eml_snd_rslt_cd1") = true;
//				sheetObj.ColHidden(prefix + "eml_snd_rslt_cd2") = true;
//				sheetObj.ColHidden(prefix + "eml_snd_rslt_cd3") = true;
//				sheetObj.ColHidden(prefix + "eml_snd_rslt_cd4") = true;
//				sheetObj.ColHidden(prefix + "eml_snd_rslt_cd5") = true;
//				
//				sheetObj.ColHidden(prefix + "eml_snd_rslt_nm1") = true;
//				sheetObj.ColHidden(prefix + "eml_snd_rslt_nm2") = true;
//				sheetObj.ColHidden(prefix + "eml_snd_rslt_nm3") = true;
//				sheetObj.ColHidden(prefix + "eml_snd_rslt_nm4") = true;
//				sheetObj.ColHidden(prefix + "eml_snd_rslt_nm5") = true;

				sheetObj.ColHidden(prefix + "eml_snd_dt") = true;
				sheetObj.ColHidden(prefix + "eml_snd_id") = true;

				sheetObj.ColHidden(prefix + "fax_no1") = false;
				sheetObj.ColHidden(prefix + "fax_no2") = false;
				sheetObj.ColHidden(prefix + "fax_no3") = false;
				sheetObj.ColHidden(prefix + "fax_no4") = false;
				sheetObj.ColHidden(prefix + "fax_no5") = false;

//				sheetObj.ColHidden(prefix + "fax_snd_rslt_cd1") = false;
//				sheetObj.ColHidden(prefix + "fax_snd_rslt_cd2") = false;
//				sheetObj.ColHidden(prefix + "fax_snd_rslt_cd3") = false;
//				sheetObj.ColHidden(prefix + "fax_snd_rslt_cd4") = false;
//				sheetObj.ColHidden(prefix + "fax_snd_rslt_cd5") = false;
//				
//				sheetObj.ColHidden(prefix + "fax_snd_rslt_nm1") = false;
//				sheetObj.ColHidden(prefix + "fax_snd_rslt_nm2") = false;
//				sheetObj.ColHidden(prefix + "fax_snd_rslt_nm3") = false;
//				sheetObj.ColHidden(prefix + "fax_snd_rslt_nm4") = false;
//				sheetObj.ColHidden(prefix + "fax_snd_rslt_nm5") = false;

				sheetObj.ColHidden(prefix + "fax_snd_dt") = false;
				sheetObj.ColHidden(prefix + "fax_snd_id") = false;			
			
			}else if(nItem == 1){//E-Mail
				sheetObj.ColHidden(prefix + "ntc_eml1") = false;
				sheetObj.ColHidden(prefix + "ntc_eml2") = false;
				sheetObj.ColHidden(prefix + "ntc_eml3") = false;
				sheetObj.ColHidden(prefix + "ntc_eml4") = false;
				sheetObj.ColHidden(prefix + "ntc_eml5") = false;
	
//				sheetObj.ColHidden(prefix + "eml_snd_rslt_cd1") = false;
//				sheetObj.ColHidden(prefix + "eml_snd_rslt_cd2") = false;
//				sheetObj.ColHidden(prefix + "eml_snd_rslt_cd3") = false;
//				sheetObj.ColHidden(prefix + "eml_snd_rslt_cd4") = false;
//				sheetObj.ColHidden(prefix + "eml_snd_rslt_cd5") = false;
//				
//				sheetObj.ColHidden(prefix + "eml_snd_rslt_nm1") = false;
//				sheetObj.ColHidden(prefix + "eml_snd_rslt_nm2") = false;
//				sheetObj.ColHidden(prefix + "eml_snd_rslt_nm3") = false;
//				sheetObj.ColHidden(prefix + "eml_snd_rslt_nm4") = false;
//				sheetObj.ColHidden(prefix + "eml_snd_rslt_nm5") = false;
	
				sheetObj.ColHidden(prefix + "eml_snd_dt") = false;
				sheetObj.ColHidden(prefix + "eml_snd_id") = false;
	
				sheetObj.ColHidden(prefix + "fax_no1") = true;
				sheetObj.ColHidden(prefix + "fax_no2") = true;
				sheetObj.ColHidden(prefix + "fax_no3") = true;
				sheetObj.ColHidden(prefix + "fax_no4") = true;
				sheetObj.ColHidden(prefix + "fax_no5") = true;
	
//				sheetObj.ColHidden(prefix + "fax_snd_rslt_cd1") = true;
//				sheetObj.ColHidden(prefix + "fax_snd_rslt_cd2") = true;
//				sheetObj.ColHidden(prefix + "fax_snd_rslt_cd3") = true;
//				sheetObj.ColHidden(prefix + "fax_snd_rslt_cd4") = true;
//				sheetObj.ColHidden(prefix + "fax_snd_rslt_cd5") = true;
//				
//				sheetObj.ColHidden(prefix + "fax_snd_rslt_nm1") = true;
//				sheetObj.ColHidden(prefix + "fax_snd_rslt_nm2") = true;
//				sheetObj.ColHidden(prefix + "fax_snd_rslt_nm3") = true;
//				sheetObj.ColHidden(prefix + "fax_snd_rslt_nm4") = true;
//				sheetObj.ColHidden(prefix + "fax_snd_rslt_nm5") = true;
	
				sheetObj.ColHidden(prefix + "fax_snd_dt") = true;
				sheetObj.ColHidden(prefix + "fax_snd_id") = true;			
			
			}


			t1beforetab= nItem;
 	    	
//	var objs = document.all.item("t1tabLayer");
//	
//	objs[nItem].style.display = "Inline";
//	objs[t1beforetab].style.display = "none";
//
//
//	//--------------- 요기가 중요 --------------------------//
//	objs[t1beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
//	//------------------------------------------------------//
			
     }     

     /**
      * Tab 클릭시 이벤트 관련
      * 선택한 탭의 요소가 활성화 된다.
      *  B/L Info 안에 들어있는 텝
      */
     function t7tab2_OnChange(tabObj , nItem)
      {
	  	 	var prefix = "t7sheet3_";
    	 	var sheetObj = sheetObjects[t7sheet3];
	
			if(nItem == 0){//Fax
			
				sheetObj.ColHidden(prefix + "ntc_eml1") = true;
				sheetObj.ColHidden(prefix + "ntc_eml2") = true;
				sheetObj.ColHidden(prefix + "ntc_eml3") = true;
				sheetObj.ColHidden(prefix + "ntc_eml4") = true;
				sheetObj.ColHidden(prefix + "ntc_eml5") = true;
	
//				sheetObj.ColHidden(prefix + "eml_snd_rslt_cd1") = true;
//				sheetObj.ColHidden(prefix + "eml_snd_rslt_cd2") = true;
//				sheetObj.ColHidden(prefix + "eml_snd_rslt_cd3") = true;
//				sheetObj.ColHidden(prefix + "eml_snd_rslt_cd4") = true;
//				sheetObj.ColHidden(prefix + "eml_snd_rslt_cd5") = true;
//				
//				sheetObj.ColHidden(prefix + "eml_snd_rslt_nm1") = true;
//				sheetObj.ColHidden(prefix + "eml_snd_rslt_nm2") = true;
//				sheetObj.ColHidden(prefix + "eml_snd_rslt_nm3") = true;
//				sheetObj.ColHidden(prefix + "eml_snd_rslt_nm4") = true;
//				sheetObj.ColHidden(prefix + "eml_snd_rslt_nm5") = true;
	
				sheetObj.ColHidden(prefix + "eml_snd_dt") = true;
				sheetObj.ColHidden(prefix + "eml_snd_id") = true;
	
				sheetObj.ColHidden(prefix + "fax_no1") = false;
				sheetObj.ColHidden(prefix + "fax_no2") = false;
				sheetObj.ColHidden(prefix + "fax_no3") = false;
				sheetObj.ColHidden(prefix + "fax_no4") = false;
				sheetObj.ColHidden(prefix + "fax_no5") = false;
	
//				sheetObj.ColHidden(prefix + "fax_snd_rslt_cd1") = false;
//				sheetObj.ColHidden(prefix + "fax_snd_rslt_cd2") = false;
//				sheetObj.ColHidden(prefix + "fax_snd_rslt_cd3") = false;
//				sheetObj.ColHidden(prefix + "fax_snd_rslt_cd4") = false;
//				sheetObj.ColHidden(prefix + "fax_snd_rslt_cd5") = false;
//				
//				sheetObj.ColHidden(prefix + "fax_snd_rslt_nm1") = false;
//				sheetObj.ColHidden(prefix + "fax_snd_rslt_nm2") = false;
//				sheetObj.ColHidden(prefix + "fax_snd_rslt_nm3") = false;
//				sheetObj.ColHidden(prefix + "fax_snd_rslt_nm4") = false;
//				sheetObj.ColHidden(prefix + "fax_snd_rslt_nm5") = false;
	
				sheetObj.ColHidden(prefix + "fax_snd_dt") = false;
				sheetObj.ColHidden(prefix + "fax_snd_id") = false;			
			
			}else if(nItem == 1){//E-Mail
				sheetObj.ColHidden(prefix + "ntc_eml1") = false;
				sheetObj.ColHidden(prefix + "ntc_eml2") = false;
				sheetObj.ColHidden(prefix + "ntc_eml3") = false;
				sheetObj.ColHidden(prefix + "ntc_eml4") = false;
				sheetObj.ColHidden(prefix + "ntc_eml5") = false;
	
//				sheetObj.ColHidden(prefix + "eml_snd_rslt_cd1") = false;
//				sheetObj.ColHidden(prefix + "eml_snd_rslt_cd2") = false;
//				sheetObj.ColHidden(prefix + "eml_snd_rslt_cd3") = false;
//				sheetObj.ColHidden(prefix + "eml_snd_rslt_cd4") = false;
//				sheetObj.ColHidden(prefix + "eml_snd_rslt_cd5") = false;
//				
//				sheetObj.ColHidden(prefix + "eml_snd_rslt_nm1") = false;
//				sheetObj.ColHidden(prefix + "eml_snd_rslt_nm2") = false;
//				sheetObj.ColHidden(prefix + "eml_snd_rslt_nm3") = false;
//				sheetObj.ColHidden(prefix + "eml_snd_rslt_nm4") = false;
//				sheetObj.ColHidden(prefix + "eml_snd_rslt_nm5") = false;
	
				sheetObj.ColHidden(prefix + "eml_snd_dt") = false;
				sheetObj.ColHidden(prefix + "eml_snd_id") = false;
	
				sheetObj.ColHidden(prefix + "fax_no1") = true;
				sheetObj.ColHidden(prefix + "fax_no2") = true;
				sheetObj.ColHidden(prefix + "fax_no3") = true;
				sheetObj.ColHidden(prefix + "fax_no4") = true;
				sheetObj.ColHidden(prefix + "fax_no5") = true;
	
//				sheetObj.ColHidden(prefix + "fax_snd_rslt_cd1") = true;
//				sheetObj.ColHidden(prefix + "fax_snd_rslt_cd2") = true;
//				sheetObj.ColHidden(prefix + "fax_snd_rslt_cd3") = true;
//				sheetObj.ColHidden(prefix + "fax_snd_rslt_cd4") = true;
//				sheetObj.ColHidden(prefix + "fax_snd_rslt_cd5") = true;
//				
//				sheetObj.ColHidden(prefix + "fax_snd_rslt_nm1") = true;
//				sheetObj.ColHidden(prefix + "fax_snd_rslt_nm2") = true;
//				sheetObj.ColHidden(prefix + "fax_snd_rslt_nm3") = true;
//				sheetObj.ColHidden(prefix + "fax_snd_rslt_nm4") = true;
//				sheetObj.ColHidden(prefix + "fax_snd_rslt_nm5") = true;
	
				sheetObj.ColHidden(prefix + "fax_snd_dt") = true;
				sheetObj.ColHidden(prefix + "fax_snd_id") = true;			
			
			}

			t2beforetab= nItem;
  	    	
      }     
     
    function fnPreview() {
    	var formObj = document.form;
    	
    	if (sheetObjects[t7sheet1].RowCount == 0) {
    		ComShowCodeMessage("BKG00395");
    		return;
    	}
		//RD 정보 구해오기
//    	var bkg_no = sheetObjects[sheetObjects.length-1].CellValue(1, "sheet2_bkg_no");
    	var bkg_no = document.form.bkg_no.value;
    	var ntc_seq = "";
    	var usr_id  = strUsr_id;
    	var ofc_cd  = strOfc_cd;

		if(bkg_no == ""){
			ComShowCodeMessage("BKG00149");
			return;
		}
		formObj.com_mrdTitle.value = "PickUp Notice";
        formObj.com_mrdBodyTitle.value = "PickUp Notice";
        formObj.com_mrdPath.value = "apps/alps/esm/bkg/inbounddocumentation/inboundnoticemgt/inboundnotice/report/ESM_BKG_5018.mrd"; 
        formObj.com_mrdArguments.value = "/rv bkg_no['" + bkg_no + "'] ntc_seq['" + ntc_seq + "'] usr_id['" + usr_id + "'] ofc_cd['" + ofc_cd + "']  form_ofcCd['" + strOfc_cd + "']" + 
        	                                 "p_pkup_ntc_fom_cd[''] p_pkup_yd_cd[''] p_rtn_yd_cd[''] p_rmk[''] form_revise_YN['']";

//        ComOpenRDPopup();
        ComOpenRDPopupModal();
    }
      
    function fnQueryExec(bkg_no, bl_no) {
    	if (bkg_no != "") {
        	
    		document.form.bkg_no.value = bkg_no;
    		document.form.bl_no.value = bl_no;
    		fnSearch();
        }     	
    }
    
//    function t7sheet2_OnClick(sheetObj, Row, Col){        	 
//    	var cellValue = "";
// 		var prefix = "t7sheet2_";
// 		
// 		var sSaveName = sheetObj.ColSaveName(Col);
// 		
// 		if (sSaveName == prefix + "pkup_no_disp") {
//	    	cellValue = sheetObj.CellValue(Row,prefix + "pkup_no");
//			
//			if(cellValue != "") {
//				sheetObj.CellValue2(Row,prefix + "pkup_no_disp") = cellValue;
//			}
// 		}
//    }
//
//    function t7sheet3_OnClick(sheetObj, Row, Col){        	 
//    	var cellValue = "";
// 		var prefix = "t7sheet3_";
// 		
// 		var sSaveName = sheetObj.ColSaveName(Col);
// 		
// 		if (sSaveName == prefix + "pkup_no_disp") {
//	    	cellValue = sheetObj.CellValue(Row,prefix + "pkup_no");
//			
//			if(cellValue != "") {
//				sheetObj.CellValue2(Row,prefix + "pkup_no_disp") = cellValue;
//			}
// 		}
//    }
/* 개발자 작업  끝 */