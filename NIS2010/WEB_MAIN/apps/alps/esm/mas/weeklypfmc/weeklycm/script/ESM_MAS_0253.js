/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_MAS_0253.js
*@FileTitle : Chassis Cost
*Open Issues :
*@LastModifyDate : 2014-11-19
*@LastModifier : Je Ryang Yoo
*@LastVersion :
*  2014-11-18 Je Ryang Yoo
*  1.0 최초 생성
*  2015.08.31 손진환 [CHM-201536958] Split15-[그룹사 표준 코드 시행] SML 프로그램 대응 및 데이타 마이그레이션 작업 요청
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends 
 * @class ESM_MAS_0253 : ESM_MAS_0253 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_MAS_0253() {
    this.processButtonClick    = processButtonClick;  
    this.setYrWk               = setYrWk            ;
    this.setYrMon              = setYrMon          ;
    this.fnYearWeekSet         = fnYearWeekSet     ;
    this.setPeriod             = setPeriod         ;
    this.loadPage              = loadPage          ;
    this.initSheet             = initSheet         ;
    this.setSheetObject        = setSheetObject    ;
    this.sheet1_OnChange       = sheet1_OnChange   ;
    this.sheet1_OnSearchEnd    = sheet1_OnSearchEnd;
    this.doActionIBSheet       = doActionIBSheet   ;
    this.validateForm          = validateForm      ;
    this.setTabObject = setTabObject;
}

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var tab_no = 0;
var tab_no2 = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;
var loadingMode = false;

var EXCEL_LOAD_FLG = false;	//엑셀 로드 실행체크
var sRow = 0;

var tabItem = 0;

var loadPageCnt = 0;

/** 
 *버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의  
 */
document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 
     */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject1 = sheetObjects[0];
    	var sheetObject2 = sheetObjects[1];
    	/** **************************************************** */
        var formObject = document.form;
        
        try {
            var srcName = window.event.srcElement.getAttribute("name");
        
            switch(srcName) {
                case "btn_Retrieve":                	
                	if (tabItem == 0) {        				
                		doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
        			} else if (tabItem == 1){        				
        				doActionIBSheet(sheetObjects[1], document.form, SEARCH02);
        			}                    
                    break;
                
                case "btn_Downexcel":
                	if (tabItem == 0) {        				
                		doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
        			} else if (tabItem == 1){        				
        				doActionIBSheet(sheetObject2,formObject,IBDOWNEXCEL);
        			}
                    //doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
                    break;
                    
                case "btn_Loadexcel":
                	if (tabItem == 0) {        				
                		doActionIBSheet(sheetObject1,formObject,IBLOADEXCEL);
        			} else if (tabItem == 1){        				
        				doActionIBSheet(sheetObject2,formObject,IBLOADEXCEL);
        			}
                    //doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
                    break;
                    
                case "btn_save":                	
                	if (tabItem == 0) {        
                		doActionIBSheet(sheetObject1, document.form, MULTI01);
        			} else if (tabItem == 1){        				
        				//doActionIBSheet(sheetObject2, document.form, MULTI02);
        			}
                    break;
                
                case "btn_rowadd":
                	if (tabItem == 0) {     
                		sheetObject1.DataInsert(-1);   
        			} else if (tabItem == 1){        	
                		sheetObject2.DataInsert(-1);  
        			}
                    break;
                    
                case "btn_rowdel":
                	if (tabItem == 0) {   
    					if(sheetObject1.FindCheckedRow("del_chk") != ""){
    						//ComRowHideDelete(sheetObject1,"del_chk");
    						RowHideDelete(sheetObject1,"del_chk");
    					} else {    						
    						ComShowCodeMessage("MNR00150");
    					}
//                		sheetObject1.RowDelete(sheetObject1.SelectRow, false);
                		
        			} else if (tabItem == 1){        		
                		//sheetObject2.RowDelete(sheetObject2.SelectRow, false);
        			}
                    break;
                
                case "btn_Create":
                	if (tabItem == 0) {        				
                		doActionIBSheet(sheetObject1,document.form,IBCREATE);                		
        			} else if (tabItem == 1){        				
        				//doActionIBSheet2(sheetObject2,document.form,IBCREATE);
        			}
                    //doActionIBSheet(sheetObject,formObject,IBCREATE);
                    break;  
                    
                case "btn_ExceptionList":
                	ComOpenPopup("ESM_MAS_0250.do", 650, 380, '', '0,1,1,1,1,1', false);
                    
                	break;
                
                case "btn_UCCustomer":
                    ComOpenPopup("ESM_MAS_0251.do", 650, 380, '', '0,1,1,1,1,1', false);
                    
                    break;
                    
            } // end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        } finally {
        	ComOpenWait(false);
        }
        
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	var formObj = document.form;
    	
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		loadingMode = true;
		
		for (k = 0; k < tabObjects.length; k++) {
			initTab(tabObjects[k], k + 1);
		}
				
        loadingMode = false;
        
        // Save, Create 버튼 활성화, 비활성화 제어
    	if ( document.form.v_ofc_cd.value == 'SELAPM' || document.form.v_ofc_cd.value == 'CLTCO'
    		|| document.form.v_ofc_cd.value == 'SELOPE' || document.form.v_ofc_cd.value == 'SELCSG' || document.form.v_ofc_cd.value == 'SELOPB' 
    		|| document.form.v_ofc_cd.value == 'SELCON'){
    		//ComBtnEnable("btn_save");
    		hidden_Save.style.display = "Inline";
    		hidden_Loadexcel.style.display = "Inline";
    		hidden_Create.style.display = "Inline";
    		hidden_Add.style.display = "Inline";
    		hidden_Del.style.display = "Inline";
    	} else {
    		//ComBtnDisable("btn_save");
    		hidden_Save.style.display = "none";
    		hidden_Loadexcel.style.display = "none";
    		hidden_Create.style.display = "none";
    		hidden_Add.style.display = "none";
    		hidden_Del.style.display = "none";
    	}
		
        
        ComSetFocus(document.form.fr_year);
    }
   
   	/**
   	 * IBTab Object를 배열로 등록
   	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
   	 * 배열은 소스 상단에 정의
   	 */
   	function setTabObject(tab_obj) {
   		tabObjects[tabCnt++] = tab_obj;

   	}
   	 
   	/**
   	 * Tab 기본 설정
   	 * 탭의 항목을 설정한다.
   	 */
   	function initTab(tabObj, tabNo) {
   		switch (tabNo) {
   		case 1:
   			with (tabObj) {
   	            var cnt  = 0 ;
   	            InsertTab( cnt++ , "Chassis Cost" , -1 );
   	            InsertTab( cnt++ , "Chassis Unit Cost" , -1 );
   	            
   	            break;
   			}
   		}
   	}

   	/**
   	 * Tab 변경시 이벤트 관련
   	 * 선택한 탭의 정보를 조회.
   	 */
   	function tab1_OnChange(tabObj, nItem) {
   		var objs = document.all.item("tabLayer");

   		objs[nItem].style.display = "Inline";
   		objs[beforetab].style.display = "none";

   		tabItem = nItem;

   		document.form.tab_item.value = tabItem;
   		
   		var formObject = document.form;

   			if(tabItem == 0){   				 
   				 
   			}else if(tabItem == 1){
   				 /*f_trd_cd.style.display ="none";
   				 f_rlane_cd.style.display ="none";
   				 f_ioc_cd.style.display ="none";
   				 f_bkg_por_cd.style.display ="none";
   				 f_bkg_del_cd.style.display ="none";
   				 f_bkg_por_scc_cd.style.display ="";
   				 f_bkg_del_scc_cd.style.display ="";
   				 f_dir_cd.style.display ="none";
   				 f_cntr_tpsz_cd.style.display ="";*/
   			}   			

   		// --------------- 요기가 중요 --------------------------//
   		objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
   		// ------------------------------------------------------//
   		beforetab = nItem;
   		
   		
   	    //if(loadPageCnt == 0) return;
   	    
   	    //document.getElementById("btn_Retrieve").fireEvent("onclick");
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
                    SheetWidth = mainTable.clientWidth;
                    //전체 너비 설정
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
                    MergeSheet = msHeaderOnly;                          //전체Merge 종류 [선택, Default msNone]
                    Editable = true;                                    //전체Edit 허용 여부 [선택, Default false]
                    InitRowInfo(1 , 1, 9, 100);                         //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitColumnInfo(18, 0, 0, true);                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitHeadMode(true, true, false, true, false,false); // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    
                    var HeadTitle0  = "STS|SEL.|EFF QTR|FROM|TO|On-Street|On-TMNL|Migration|Rev Share|Credit\nMemo|Misc\nRe-bill|Own\nCHZ Cost|Chassis\nDray|Comm.\nS.Total|Total|Remark|Year|Quarter";                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true);

                    
                    //데이터속성    [ROW,    COL,    DATATYPE,       WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,	cnt++,   dtHiddenStatus, 30,     daCenter,   false,      "ibflag");
                    InitDataProperty(0,	cnt++, 	 dtRadioCheck,   30,     daCenter,   false,      "del_chk");                    
        			InitDataProperty(0,  cnt++,  dtData,         60,     daCenter,   true,       "cost_yr_qtr", 		false,  "",  dfNone,     0,  true,  true);
        			InitDataProperty(0,  cnt++,  dtData,         60,     daCenter,   true,       "eff_fm_yrmon",        false,  "",  dfDateYm,   0,  true,  true);
                    InitDataProperty(0,  cnt++,  dtData,         60,     daCenter,   true,       "eff_to_yrmon",        false,  "",  dfDateYm,   0,  true,  true);
                	InitDataProperty(0,  cnt++,  dtData,         80,     daRight,    true,       "on_st_amt",         	false,  "",  dfInteger,  0,  true,  true);
                    InitDataProperty(0,  cnt++,  dtData,         80,     daRight,    true,       "on_tml_amt",    		false,  "",  dfInteger,  0,  true,  true);
                    InitDataProperty(0,  cnt++,  dtData,         80,     daRight,    true,       "mig_amt",      		false,  "",  dfInteger,  0,  true,  true);
                    InitDataProperty(0,  cnt++,  dtData,         80,     daRight,    true,       "rev_shr_amt",      	false,  "",  dfInteger,  0,  true,  true);
                    InitDataProperty(0,  cnt++,  dtData,         80,     daRight,    true,       "cr_mm_amt",		    false,  "",  dfInteger,  0,  true,  true);
                    InitDataProperty(0,  cnt++,  dtData,         80,     daRight,    true,       "misc_re_bil_amt",     false,  "",  dfInteger,  0,  true,  true);
                    InitDataProperty(0,  cnt++,  dtData,         80,     daRight,    true,       "on_chss_amt",      	false,  "",  dfInteger,  0,  true,  true);
                    InitDataProperty(0,  cnt++,  dtData,         80,     daRight,    true,       "chss_dryg_amt",       false,  "",  dfInteger,  0,  true,  true);
                    InitDataProperty(0,  cnt++,  dtData,         80,     daRight,    true,       "com_sub_ttl_amt",     false,  "",  dfInteger,  0,  false, true);
                    InitDataProperty(0,  cnt++,  dtData,         90,     daRight,    true,       "com_ttl_amt",         false,  "",  dfInteger,  0,  false, true);
                    InitDataProperty(0,  cnt++,  dtData,        100,     daRight,    true,       "chss_rmk",      		false,  "",  dfNone,     0,  true,  true);
                    InitDataProperty(0,  cnt++,  dtHidden,       60,     daRight,    true,       "cost_yr",      		false,  "",  dfNone,     0,  true,  true);
                    InitDataProperty(0,  cnt++,  dtHidden,       60,     daRight,    true,       "cost_qtr_cd",      	false,  "",  dfNone,     0,  true,  true);
                    
                    //RangeBackColor(1, 7, 1, 10) = RgbColor(222, 251, 248); // dtCheckBox
//                    InitDataValid(0, "cost_wk", vtNumericOnly);
//                    InitDataValid(0, "slan_cd", vtEngUpOther, "0123456789");
//                    InitDataValid(0, "rlane_cd", vtEngUpOther, "0123456789");

                    CountPosition  = 0 ;
                    //style.height = GetSheetHeight(13) ;
                    sheetObj.style.height = 370;    //sheetObj.GetSheetHeight(13);
                    //Edit 가능한 셀과 불가능한 셀을 배경색으로 구분하여 표시 (업로드시)
                    EditableColorDiff = true;
                    WaitImageVisible = false;
                }            
                break;
            case 2:      //sheet2 init
                with (sheetObj) {
                    SheetWidth = mainTable.clientWidth;
                //전체 너비 설정
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
                    MergeSheet = msHeaderOnly;                          //전체Merge 종류 [선택, Default msNone]
                    Editable = true;                                    //전체Edit 허용 여부 [선택, Default false]
                    InitRowInfo(1 , 1, 9, 100);                         //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitColumnInfo(16, 0, 0, true);                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitHeadMode(true, true, false, true, false,false); // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    
                    var HeadTitle0  = "STS|Eff QTR|FROM|TO|Type|Box|Share|Total\nShare|Estimated\nAmount|On-street\nU/C|Common\nS.TTL|Common\nU/C|Standard\nU/C|||";                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true);

                    
                    //데이터속성    [ROW,    COL,    DATATYPE,       WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,     cnt++,  dtHiddenStatus, 		30,     daCenter,   true,       "ibflag");
                    InitDataProperty(0,     cnt++,  dtData,      60,     daCenter,   true,       "cost_yr_qtr",      false,      "",         dfNone,       0,  false,  true);
                    InitDataProperty(0,     cnt++,  dtData,      60,     daCenter,   true,       "eff_fm_yrmon",     false,      "",         dfDateYm,     0,  false,  true, 2, true);
                    InitDataProperty(0,     cnt++,  dtData,      60,     daCenter,   true,       "eff_to_yrmon",     false,      "",         dfDateYm,     0,  false,  true, 3, true);
                    InitDataProperty(0,     cnt++,  dtData,      90,     daLeft,   true,       "cost_tp_nm",       false,      "",         dfNone,       0,  false,  true, 5, true);
                    InitDataProperty(0,     cnt++,  dtData,      80,     daRight,    true,       "bkg_bx_qty",    	 false,      "",         dfInteger,    0,  false,  true);
                    InitDataProperty(0,     cnt++,  dtData,      60,     daRight,    true,       "cost_tp_bx_rt",    false,      "",         dfNone,       0,  false,  true);
                    InitDataProperty(0,     cnt++,  dtData,      60,     daRight,    true,       "cost_tp_bx_rt_ttl",    false,      "",         dfNone,       0,  false,  true);
                    InitDataProperty(0,     cnt++,  dtData,     120,     daRight,    true,       "estm_amt",      	 false,      "",         dfNumber,     0,  false,  true);
                    InitDataProperty(0,     cnt++,  dtData,      80,     daRight,    true,       "on_st_ut_cost",	 false,      "",         dfNumber,     0,  false,  true);
                    InitDataProperty(0,     cnt++,  dtData,      80,     daRight,    true,       "com_sub_ttl",      false,      "",         dfNumber,     0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,      80,     daRight,    true,       "com_ut_cost",      false,      "",         dfNumber,     0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,      85,     daRight,    true,       "stnd_ut_cost",     false,      "",         dfNumber,     0,  false,  false);
                    InitDataProperty(0,  cnt++,  dtHidden,       60,     daRight,    true,       "cost_yr",      	 false,      "",         dfNone,       0,  true,   true);
                    InitDataProperty(0,  cnt++,  dtHidden,       60,     daRight,    true,       "cost_qtr_cd",      false,      "",         dfNone,       0,  true,   true);
                    InitDataProperty(0,  cnt++,  dtHidden,       60,     daRight,    true,       "cost_tp_cd",      false,      "",         dfNone,       0,  true,   true);
//                    InitDataProperty(0,     cnt++,  dtHidden,      50,     daRight,    true,       "doil_uc_amt",      false,      "",         dfFloatOrg,  6,  true,   true);
                    
                    //RangeBackColor(1, 7, 1, 10) = RgbColor(222, 251, 248);
//                    InitDataValid(0, "cost_wk", vtNumericOnly);
//                    InitDataValid(0, "slan_cd", vtEngUpOther, "0123456789");
//                    InitDataValid(0, "rlane_cd", vtEngUpOther, "0123456789");

                    CountPosition  = 0 ;
                    //style.height = GetSheetHeight(13) ;
                    sheetObj.style.height = 400;    //sheetObj.GetSheetHeight(13);
                    //Edit 가능한 셀과 불가능한 셀을 배경색으로 구분하여 표시 (업로드시)
                    EditableColorDiff = true;
                    WaitImageVisible = false;
                }
                break;
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
     * S.Lane code의 유효성 체크
     */
    function sheet1_OnChange(sheetObj, row, col, value){
        var formObj = document.form;
        
        //EFF QTR에 입력된 yyyy-qtr을 연/쿼터로 분리
        if (sheetObj.ColSavename(col) == "cost_yr_qtr") {
        	if (sheetObj.CellValue(row, "cost_yr_qtr").length == 7) {
        		sheetObj.CellValue2(row, "cost_yr") = sheetObj.CellValue(row, "cost_yr_qtr").substr(0,4);
        		sheetObj.CellValue2(row, "cost_qtr_cd") = sheetObj.CellValue(row, "cost_yr_qtr").substr(5,2);
        	}
        }
//        if(sheetObj.ColSavename(col) == "on_tml_amt" || sheetObj.ColSavename(col) == "mig_amt" || sheetObj.ColSavename(col) == "rev_shr_amt" || sheetObj.ColSavename(col) == "cr_mm_amt" || 
//        sheetObj.ColSavename(col) == "misc_re_bil_amt" || sheetObj.ColSavename(col) == "on_chss_amt" || sheetObj.ColSavename(col) == "chss_dryg_amt") {
	        var subTtl = 0;
        	for (i=6; i<=12; i++) {	// On-TMNL부터 Chassis Dray 컬럼의 합을 구함
        		subTtl = subTtl + eval(sheetObj.CellValue(row, i));
        	}
        	
        	sheetObj.CellValue2(row, "com_sub_ttl_amt") = subTtl;
//        	sheetObj.CellValue2(row, "com_sub_ttl_amt") = sheetObj.CellValue(row, "on_tml_amt") + sheetObj.CellValue(row, "mig_amt") + sheetObj.CellValue(row, "rev_shr_amt") + sheetObj.CellValue(row, "cr_mm_amt")
//	        	 + sheetObj.CellValue(row, "misc_re_bil_amt") + sheetObj.CellValue(row, "on_chss_amt") + sheetObj.CellValue(row, "chss_dryg_amt");
	        sheetObj.CellValue2(row, "com_ttl_amt") = eval(sheetObj.CellValue(row, "on_st_amt"))  + subTtl;
//        }
        
    }

    function sheet2_OnSearchEnd(sheetObj, errMsg){
    	// Query에서 합을 구하게 하였음 - 조회 직후 데이터상태가 update가 되는 현상이 있어 주석처리 하였음.
    	/*for (i=1; i<sheetObj.LastRow+1; i++) {	    	
	    	var subTtl = 0;
	     	for (j=5; j<=12; j++) {	// On-Street부터 Chassis Dray 컬럼의 합을 구함 (Total값)
	     		subTtl = subTtl + eval(sheetObj.CellValue(i, j));
	     	}
	     	sheetObj.CellValue2(i, "com_ttl_amt") = subTtl;     	
    	}*/
//    	if(sheetObj.RowCount > 0){
//	    	sheetObj.RowBackColor(sheetObj.LastRow) = sheetObj.RgbColor(201, 213, 235); // 토탈 - 연한 파란색
//	     	sheetObj.RowBackColor(sheetObj.LastRow-1) = sheetObj.RgbColor(255, 217, 236); // 서브토탈 - 분홍색
//    	}
    	for (i=1; i<sheetObj.LastRow+1;i++) {
    		if (sheetObj.CellValue(i,"cost_tp_cd") == "S")
    			sheetObj.RowBackColor(i) = sheetObj.RgbColor(255, 217, 236); // 서브토탈 - 분홍색
    		if (sheetObj.CellValue(i,"cost_tp_cd") == "T")
    			sheetObj.RowBackColor(i) = sheetObj.RgbColor(201, 213, 235); // 토탈 - 연한 파란색
    	}
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {    
			case SEARCH01: //sheet1 조회					
                if(!validateForm(sheetObj,formObj,sAction)) return false;
                
                // 업무처리중 버튼사용 금지 처리  
                ComOpenWait(true);                
                formObj.f_cmd.value = SEARCHLIST01;
                sheetObj.DoSearch("ESM_MAS_0253GS.do", masFormQueryString(formObj));
                
  	            //initVariable(); //초기값 세팅
                ComOpenWait(false);
                break;
 
			case SEARCH02: //sheet2 조회				
                if(!validateForm(sheetObj,formObj,sAction)) return false;
                // 업무처리중 버튼사용 금지 처리
                ComOpenWait(true);
                //sheetObjects[1].ReSet();
                formObj.f_cmd.value = SEARCHLIST02; 
                sheetObjects[1].DoSearch("ESM_MAS_0253GS.do", masFormQueryString(formObj));
                
  	            //initVariable(); //초기값 세팅
                ComOpenWait(false);
                break;
			
			case MULTI01:                //저장
                if(!validateForm(sheetObj,formObj,sAction)) {
                	return false;
                }
                
                ComOpenWait(true);
                formObj.f_cmd.value = MULTI01;                	
                sheetObj.DoSave("ESM_MAS_0253GS.do", FormQueryString(formObj), -1, true);
//                sheetObj.DoSave("ESM_MAS_0253GS.do", masFormQueryString(formObj,'f_cmd',true), -1, false);
//				var sParam = FormQueryString(formObj) + "&" + sheetObj.GetSaveString(1);
//				alert(sheetObj.GetSaveString(1));
//				var rtnXml = sheetObj.GetSaveXml("ESM_MAS_0253GS.do", sParam);
//				sheetObj.LoadSaveXml(rtnXml);
				ComOpenWait(false);
                
                //Load Excel 사용시
                if(EXCEL_LOAD_FLG) {
                	if(sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
  						initVariable(); //저장이 완료되면 전역변수 초기화
  					}
                }
                break;
                            	            
            case IBDOWNEXCEL:           //엑셀 다운로드
                //sheetObj.SpeedDown2Excel(-1);
                var excelType = selectDownExcelMethod(sheetObj);
                switch (excelType) {
                    case "AY":
                        sheetObj.Down2Excel(0, false, false, true);
                        break;
                    case "DY":
                        sheetObj.Down2Excel(-1, false, false, true);
                        break;
                    case "AN":
                        sheetObj.SpeedDown2Excel(0, false, false);
                        break;
                    case "DN":
                        sheetObj.SpeedDown2Excel(-1, false, false);
                        break;
                }               
                break;
             	
        	case IBLOADEXCEL:
	        	ComOpenWait(true);
	        	sheetObj.RemoveAll();	        	
//	        	EXCEL_LOAD_FLG = sheetObj.LoadExcel(-1, 1, "", "-1", "-1", "", false);	  
                sheetObj.LoadExcel(-1, 1, "", -1, -1, "");   
	        	
                for (i=1; i< sheetObj.LastRow+1; i++) {
                	 //EFF QTR에 입력된 yyyy-qtr을 연/쿼터로 분리
                	if (sheetObj.CellValue(i, "cost_yr_qtr").length == 7) {
                		sheetObj.CellValue2(i, "cost_yr") = sheetObj.CellValue(i, "cost_yr_qtr").substr(0,4);
                		sheetObj.CellValue2(i, "cost_qtr_cd") = sheetObj.CellValue(i, "cost_yr_qtr").substr(5,2);
                	}
                }
                
//	        	if(EXCEL_LOAD_FLG) {
//	        		ComShowObject(document.getElementById("btn_Rowdelete"),  true);
//	        	}
				break;	
				
        	case IBCREATE:
        		/*var selChk = false;
        		for (i=1; i<sheetObj.LastRow+1; i++) {
        			if (sheetObj.CellValue(i, "del_chk") == "1") {
        				selChk = true;
        			}
        		}
        		if (!selChk) {
        			ComShowCodeMessage("MAS10015", "Creation Data");
        			return;
        		}
        	    if (ComShowConfirm(ComGetMsg('MAS10020')) == true) {
        	    	ComOpenWait(true); 
            		sheetObj.Redraw = false;
            		formObj.f_cmd.value = MULTI02;  

                    sheetObj.DoSave("ESM_MAS_0253GS.do", FormQueryString(formObj), -1, false);
                    sheetObj.Redraw = true;
      			  	ComOpenWait(false); 
        	    }
                break;*/
        		if(!validateForm(sheetObj,formObj,sAction)) {
	               	return false;
	            }	           	            	
	           	if (!ComShowCodeConfirm("MAS10020")) {
	           		return false;
	           	}  
	           	
	           	/*
                sheetObj.Redraw = false;
                ComOpenWait(true);
                formObj.f_cmd.value = COMMAND01;                
                ComSetObjValue(formObj.f_cost_yr, sheetObj.CellText(sheetObj.SelectRow, "cost_yr"));
                ComSetObjValue(formObj.f_cost_qtr_cd, sheetObj.CellText(sheetObj.SelectRow, "cost_qtr_cd"));
                ComSetObjValue(formObj.f_eff_fm_yrmon, sheetObj.CellText(sheetObj.SelectRow, "eff_fm_yrmon"));
                ComSetObjValue(formObj.f_eff_to_yrmon, sheetObj.CellText(sheetObj.SelectRow, "eff_to_yrmon"));
                //alert(FormQueryString(formObj));                
                sheetObj.DoSearch("ESM_MAS_0253GS.do", FormQueryString(formObj));          
                doActionIBSheet(sheetObj, formObj, SEARCH01);
                

                ComOpenWait(false);
                sheetObj.Redraw = true;
                */
	           	
                formObj.f_cmd.value = COMMAND01;                
                ComSetObjValue(formObj.f_cost_yr, sheetObj.CellText(sheetObj.SelectRow, "cost_yr"));
                ComSetObjValue(formObj.f_cost_qtr_cd, sheetObj.CellText(sheetObj.SelectRow, "cost_qtr_cd"));
                ComSetObjValue(formObj.f_eff_fm_yrmon, sheetObj.CellText(sheetObj.SelectRow, "eff_fm_yrmon"));
                ComSetObjValue(formObj.f_eff_to_yrmon, sheetObj.CellText(sheetObj.SelectRow, "eff_to_yrmon"));
               
                var sXml = sheetObj.GetSaveXml("ESM_MAS_0253GS.do", FormQueryString(formObj))
                backendJobKey = ComGetEtcData(sXml, "KEY");
                ComOpenWait(true);
                intervalId = setInterval(doActionValidationResult, 3000);
                //alert(backendJobKey);
                
                //alert(intervalId);

                
                break;
        }
    }
  
    
    /**
     * BackEndJob 실행결과조회<br>
     * 
     * @param sheetObj
     * @param sKey
     */
    function doActionValidationResult() {
        ComOpenWait(true);
       // alert("doActionValidationResult");
        var sXml = sheetObjects[0].GetSearchXml("ESM_MAS_0253GS.do?f_cmd=" + COMMAND09 + "&key=" + backendJobKey);
        var sJbStsFlg = ComGetEtcData(sXml, "jb_sts_flg");

        //ComShowMessage("doActionValidationResult "+sJbStsFlg);
        
        var jobState = ComGetEtcData(sXml, "jb_sts_flg");
        if (jobState == "3") {//성공
            ComOpenWait(false);
            
            ComShowCodeMessage("MAS00016");

            clearInterval(intervalId);
        } else if (jobState == "4") {
            ComShowCodeMessage("MAS00001");
            ComOpenWait(false);
            clearInterval(intervalId);
        } else if (jobState == "5") {
            ComShowCodeMessage("MAS00002");
            ComOpenWait(false);
            clearInterval(intervalId);
        }
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){    	
    	//공통 체크	       
    	with(formObj){    
    		if (fr_year.value > to_year.value) {
        		ComShowMessage(ComGetMsg("COM12114", "Year"));
        		fr_year.focus();
        		return;
    		}
    		
    		if (fr_qtr.value != "" && (fr_qtr.value < 1 || fr_qtr.value > 4)) {
        		ComShowMessage(ComGetMsg("COM12114", "QTR"));
        		fr_qtr.focus();
        		return;
    		}
    		
    		if (to_qtr.value != "" && (to_qtr.value < 1 || to_qtr.value > 4)) {
        		ComShowMessage(ComGetMsg("COM12114", "QTR"));
        		to_qtr.focus();
        		return;
    		}    		

        } 
        
    	//버튼별 체크
        switch (sAction) {       
        	case SEARCH01: // 조회        		
        		if (formObj.fr_year.value == "" || formObj.fr_qtr.value == "" || formObj.to_year.value == "" || formObj.to_qtr.value == "") {
					ComShowMessage("Please enter correct date.\nFormat: From:YYYY-Qtr ~ To:YYYY-Qtr");
					//formObj.pod_cd.focus();
					return false;
				}        		
				break;
			
        	case SEARCH02: // 조회        		
        		if (formObj.fr_year.value == "" || formObj.fr_qtr.value == "" || formObj.to_year.value == "" || formObj.to_qtr.value == "") {
					ComShowMessage("Please enter correct date.\nFormat: From:YYYY-Qtr ~ To:YYYY-Qtr");
					//formObj.pod_cd.focus();
					return false;
				}        		
				break;			
        	
        	case IBSAVE: // 저장
	  			if(EXCEL_LOAD_FLG) {
//	  				if(!checkValidationAllData(sheetObj)) {  					
//	  					return false;
//	  				}
	  			}    	  			
				break;
	  	
	  		case IBCREATE:
	  			/*if ( formObj.f_yrtype[0].checked ) {
	  				ComShowCodeMessage('MAS10003','Creation','YYYY-WW');
	  				return false;
	  			}*/
				break;
				
	  		case IBDELETE:
	  			if(sheetObj.RowCount < 1) {
	  				return false;
	  			}
				break;
        }
        
        return true;
    }
    
    
   /**
 	* 업로드한 데이터를 저장할때 체크하는 function<br>
 	* <br><b>Example :</b>
 	* <pre>
 	* 
 	* </pre>
 	* @param {ibsheet} sheetObj 필수 IBSheet Object
 	* @return 없음
 	* @author 최성민
 	* @version 2011.03.22
 	*/
 	function checkValidationAllData(sheetObj) {
 		var formObj = document.form;
 		var check = 0;

		// 오류셀 색지정
		var color = sheetObj.RgbColor(255, 255, 0); // 노랑
		
		ComOpenWait(true);
		// 오류색 초기화
		for ( var i = sheetObj.HeaderRows; sheetObj.RowCount > 0 && i <= sheetObj.LastRow; i++) {
			if(color == sheetObj.RowBackColor(i)) {
				sheetObj.RowBackColor(i) = 0;
			}
		}

		
		formObj.f_cmd.value = COMMAND01;
		var sParam = FormQueryString(formObj);
		var sParamSheet = sheetObj.GetSaveString();
			
		if (sParamSheet != "") {
			sParam = sParam + "&" + sParamSheet;
		} else {
			return false;
		}

		var sXml = sheetObj.GetSearchXml("ESM_MAS_0253GS.do", sParam);
		var errData = ComGetEtcData(sXml, "key"); //ROW INDEX
		alert(errData);
		if(errData != "") {
			var errArr = errData.split("|");
			
			for (var i=0; i<errArr.length; i++) { 
        		sheetObj.RowBackColor(parseInt(errArr[i]) + sheetObj.HeaderRows) = color;
        		check ++;
        	}
			
			//focus 이동
			sheetObj.SelectCell(parseInt(errArr[0]) + sheetObj.HeaderRows, 1, false);
		}
		
 		if(check > 0) {
 			ComShowCodeMessage('MAS10015', 'month VVD, vessel class');
 			return false;
 		} else {
 			return true;
 		}
 	}
 	
 	/**
 	 * batch job monitoring 
 	 * 
 	 * @return 없음
 	 * @author 서미진
 	 * @version 2013.02.06
 	 */ 
 	function monitoringBatchJob(){
 		//개발시에는 모니터링을 하지 않는다.
 		if(location.hostname == "localhost"){
 			return;
 		}
 		var sheetObj = sheetObjects[0];
 		var formObj = document.form;
 		formObj.f_cmd.value = SEARCH01;
 		var sXml = sheetObj.GetSearchXml("ESM_COA_0253GS.do", FormQueryString(formObj));
 		var BatchStatus = ComGetEtcData(sXml, "BatchStatus");
 		if( BatchStatus == "P" ){
 			setTimeout(monitoringBatchJob,3000);
 		}else{
 			ComBtnEnable("btn_Create");
 			ComShowCodeMessage('MAS10018',"Creation"); 
 			ComOpenWait(false);
 			doActionIBSheet(sheetObj,formObj,IBSEARCH);
 		}
 	}
	
	/**
	 * 전역변수를 초기화 하는 함수 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 		initVariable();
	 * </pre>
	 * @return 없음
	 * @author 최성민
	 * @version 2011.02.28
	 */
	function initVariable() {
		EXCEL_LOAD_FLG = false;		
		ComShowObject(document.getElementById("btn_Rowdelete"),  false);
	}           
	
	
	/**
	 * IBSheet의 특정 컬럼을 기준으로 체크된 행을 모두 숨기면서 트랜잭션 상태를 삭제 상태("D")로 변경한다. <br>
	 * col인자는 기능을 처리할 기준이 되는 체크컬럼 Index로 반드시 체크박스형태(dtCheckBox, dtDelCheck, dtDummyCheck, dtRadioCheck) 이어야 한다. <br>
	 * 삭제 상태로 숨겨진 행은 실제로 서버에 전달되지 않으므로 나중에 DoSave함수를 이용하여 서버에 전달하도록 한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     ComRowHideDelete(sheetObj, "sel");	//"sel"컬럼이 체크된 행을 숨기고 삭제상태로 만든다.
     * <pre>
     * </pre>
     * @param {ibsheet} 	sheetObj    필수,IBSheet Object
     * @param {int,string} 	col    		필수,삭제처리할 기준 컬럼의 인덱스 또는 SaveName[체크박스형태]
     * @param {bool} 	isMsg    		선택,삭제처리할 기준 컬럼의 인덱스 또는 SaveName[체크박스형태]
     * @returns int<br>
     *          -1 : 숨기기삭제 실패한 경우<br>
     *          그외  : 숨기기삭제 성공한 경우 처리된 행의 개수로 0개 이상의 값을 리턴한다.<br>
	 */
	function RowHideDelete(sheetObj, col, isMsg) {
   	    if (isMsg==undefined || isMsg==null) isMsg = true;
		var org_col = col;
		//컬럼Index가 아닌 경우 SaveName인 경우 -> 컬럼Index를 가져온다.
		col = ComIsNumber(col)?ComParseInt(col):sheetObj.SaveNameCol(col);
		
		//컬럼 인자의 유효성 확인하기
		if (col< 0 || col > sheetObj.LastCol) {
			ComShowMessage("[ComRowHideDelete] '" + sheetObj.id + "'의 '" + org_col + "' 컬럼은 존재하지 않습니다.");
			return -1;
		}
		
		//체크박스에 체크된 행 전체를 문자열로 가져온다. 결과 : "1|3|5|"
		var sRow = sheetObj.FindCheckedRow(col);
		if (sRow == "") {
			if(isMsg) ComShowCodeMessage("COM12189");
			return 0;
		}
		
		//가져온 행을 배열로 만들기 
		var arrRow = sRow.split("|"); //결과 : "1|3|5|"
		
		sheetObj.RedrawSum = false;	//합계 계산하지 않기, dtAutoSumEx가 있는 경우를 대비

		//기준컬럼의 DataType이 dtDelCheck이면 그냥 숨기기만하고, dtDelCheck가 아닌 경우만 숨기고, 트랜잭션 바꾼다.
		if (sheetObj.ReadDataProperty(0, col, dpDataType) == dtDelCheck) {
			//역순으로 삭제 처리하기(중간에 입력상태의 행이 있을수도 있으므로 반드시 역순으로 처리한다.)
			for (var idx=arrRow.length-2; idx>=0; idx--){
				var row = arrRow[idx];
				sheetObj.RowHidden(row)= true;		//2.행 숨기기
			}
		} else {
			//역순으로 삭제 처리하기(중간에 입력상태의 행이 있을수도 있으므로 반드시 역순으로 처리한다.)
			for (var idx=arrRow.length-2; idx>=0; idx--){
				var row = arrRow[idx];
				//sheetObj.CellValue2(row, col)= 0;	//1.체크박스 없애기 (체크된데이터만 다른 처리 하는 경우도 있으므로)
				sheetObj.RowHidden(row)= true;		//2.행 숨기기
				sheetObj.RowStatus(row)= "D";		//3.트랜잭션 상태 "삭제"로 만들기
			}
		}

		sheetObj.RedrawSum = true;	//합계 계산하기
		
		return arrRow.length-1;
	}
	
	