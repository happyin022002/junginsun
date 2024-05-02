/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VOP_VSK_9503.js
*@FileTitle : Vessel Loadable Info Upload
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.11
*@LastModifier : 박다은
*@LastVersion : 1.0
* 2014.03.11 박다은
* 1.0 Creation
* 
* 2014.04.16 박다은 [CHM-201429675] Voyage Performance내 Lane Code 구분
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

    /**
     * @extends
     * @class VOP_VSK_9503 : VOP_VSK_9503 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_VSK_9503() {
        this.processButtonClick = tprocessButtonClick;
        this.setSheetObject     = setSheetObject;
        this.loadPage           = loadPage;
        this.initSheet          = initSheet;
        this.initControl        = initControl;
        this.doActionIBSheet    = doActionIBSheet;
        this.validateForm       = validateForm;
    }

/* 개발자 작업 */


    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;


    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        var shtObj = sheetObjects[0];
        var frmObj = document.form;

            var srcName = window.event.srcElement.getAttribute("name");

            switch (srcName) {

                case "btn_retrieve":    // Retrieve
                	doActionIBSheet(shtObj, frmObj, IBSEARCH);
                    break;
                    
                case "btn_loadExcel":    // Upload Excel
                	shtObj.LoadExcel(-1, 1, "", -1, -1, "", false, false, "1=>1|2=>2|3=>3|4=>4|5=>5|6=>6|7=>7|8=>8|9=>9|10=>10|11=>11|12=>12|13=>13|14=>14|15=>15|16=>16|17=>17|18=>18|19=>19|20=>20|21=>21|22=>22|23=>23|24=>24|25=>25|26=>26|27=>27|28=>28|29=>29|30=>30|31=>31"); 
                	break;

                case "btn_save":   // Select
                    doActionIBSheet(shtObj, frmObj, MULTI);
                    break;
                    
                case "btn_downExcel":   // Select
                	shtObj.SpeedDown2Excel(-1, false, false, "","",false,false,"",false,"","",false,"",true);
                	break;

                case "btn_close":   // close
                    window.close();
                    break;


            } // end switch

    }


    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(shtObj) {
       sheetObjects[sheetCnt++] = shtObj;
    }


    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for (var i=0; i<sheetObjects.length; i++){
            // khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i], i+1);
            // khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        initControl();

        // sheet1_OnLoadFinish 메서드 반드시 참조
    }


    /**
     * 시트 초기설정값, 헤더 정의
     * param : shtObj ==> 시트오브젝트, shtNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(shtObj, shtNo) {
        with (shtObj) {
            switch (shtObj.id) {

                case "sheet1":
                    var cnt = 0;
                    // 높이 설정
                    style.height = 490;

                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                	//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                	InitRowInfo(4, 1, 1, 100);
                	
                	var HeadTitle1 = "ibflag |Lane|Ship's Type|Ship's Type|Declared BSA|Declared BSA|Declared BSA|Declared BSA|Declared BSA|Head Haul|Head Haul|Head Haul|Head Haul|Head Haul|Head Haul|Head Haul|Head Haul|Head Haul|Head Haul|Head Haul|Back Haul|Back Haul|Back Haul|Back Haul|Back Haul|Back Haul|Back Haul|Back Haul|Back Haul|Back Haul|Back Haul|Remark";
                	var HeadTitle2 = "ibflag |Lane|Ship's Type|Ship's Type|Declared BSA|Declared BSA|Declared BSA|Declared BSA|Declared BSA|New BSA(Max Space)|New BSA(Max Space)|New BSA(Max Space)|New BSA(Max Space)|New BSA(Max Space)|New BSA(Max Space)|Space 사용율\n(Design Capacity 대비)|Space 사용율\n(Design Capacity 대비)|Space 사용율\n(Design Capacity 대비)|기존 대비\n증감 수량|기존 대비\n증감 수량|New BSA(Max Space)|New BSA(Max Space)|New BSA(Max Space)|New BSA(Max Space)|New BSA(Max Space)|New BSA(Max Space)|Space 사용율\n(Design Capacity 대비)|Space 사용율\n(Design Capacity 대비)|Space 사용율\n(Design Capacity 대비)|기존 대비\n증감 수량|기존 대비\n증감 수량|Remark";
                	var HeadTitle3 = "ibflag |Lane|Design\nCapa.|Max Cargo \nWt in|H/C Occupation|H/C Occupation|Wt/TEU|Wt/TEU| Wt |H/C Occupation|H/C Occupation|H/C Occupation|H/C Occupation|Wt/TEU\n(Actual)|Wt|현재|New|New|New|New|H/C Occupation|H/C Occupation|H/C Occupation|H/C Occupation|Wt/TEU\n(Actual)|Wt|현재|New|New|New|New|Remark";
                	var HeadTitle4 = "ibflag |Lane|Design\nCapa.|Max Cargo \nWt in|Included|Excluded|Contract|Actual| Wt |Hold|Deck|Included|Excluded|Wt/TEU\n(Actual)|Wt|slot|slot|Weight|Included|Excluded|Hold|Deck|Included|Excluded|Wt/TEU\n(Actual)|Wt|slot|slot|Weight|Included|Excluded|Remark";
                	var headCount = ComCountHeadTitle(HeadTitle4);
                	
                	
                	//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                	InitColumnInfo(headCount, 0, 0, false);
                	
                	// 해더에서 처리할 수 있는 각종 기능을 설정한다
                	InitHeadMode(true, true, false, true, false, false)
                	
                	//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                	InitHeadRow(0, HeadTitle1, true);
                	InitHeadRow(1, HeadTitle2, true);
                	InitHeadRow(2, HeadTitle3, true);
                	InitHeadRow(3, HeadTitle4, true);


                    // Enter키를 눌렀을때 Tab키처럼 작동
                    EditEnterBehavior = "tab";

                    // 데이터속성 [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                	InitDataProperty(0, cnt++ , dtHiddenStatus,        52,       daCenter,          true,                "ibflag");
                	InitDataProperty(0, cnt++ , dtData,                52,       daCenter,          true,                "vsl_slan_ctnt" ,       	false,               "",                   dfNone,                    	 0,                   true,                true);
                	InitDataProperty(0, cnt++ , dtData,                80,       daRight,           true,                "cntr_dzn_capa" ,      	false,               "",                   dfInteger,                    0,                   true,                true);
                	InitDataProperty(0, cnt++ , dtData,                80,       daRight,           true,                "max_cgo_smr_mt_wgt" , 	false,               "",                   dfInteger,                    0,                   true,                true);
                	
                	InitDataProperty(0, cnt++ , dtData,                80,       daRight,           true,                "hc_incl_bsa_qty",    		false,               "",                   dfInteger,                    0,                   true,                true);
                	InitDataProperty(0, cnt++ , dtData,                80,       daRight,           true,                "hc_xcld_bsa_qty",    		false,               "",                   dfInteger,                    0,                   true,                true);
                	InitDataProperty(0, cnt++ , dtData,                80,       daRight,           true,                "ctrt_bsa_ut_wgt",    		false,               "",                   dfFloat,                    	 0,                   true,                true);
                	InitDataProperty(0, cnt++ , dtData,                80,       daRight,           true,                "act_bsa_ut_wgt",     		false,               "",                   dfFloat,                      0,                   true,                true);
                	InitDataProperty(0, cnt++ , dtData,                80,       daRight,           true,                "ttl_bsa_wgt",        		false,               "",                   dfFloat,                      0,                   true,                true);
                	
                	InitDataProperty(0, cnt++ , dtData,                52,       daRight,           true,                "hd_hul_hc_hld_qty"  , 	false,     	     	 "",        	       dfInteger,                    0,                   true,                true);
                	InitDataProperty(0, cnt++ , dtData,                52,       daRight,           true,                "hd_hul_hc_deck_qty",  	false,     	     	 "",        	   	   dfInteger,                    0,                   true,                true);
                	InitDataProperty(0, cnt++ , dtData,                52,       daRight,           true,                "hd_hul_hc_incl_qty", 		false,               "",                   dfInteger,                    0,                   true,                true);
                	InitDataProperty(0, cnt++ , dtData,                52,       daRight,           true,                "hd_hul_hc_xcld_qty", 		false,               "",                   dfInteger,                    0,                   true,                true);
                	InitDataProperty(0, cnt++ , dtData,                52,       daRight,           true,                "hd_hul_act_ut_wgt",  		false,               "",                   dfFloat,                      0,                   true,                true);
                	InitDataProperty(0, cnt++ , dtData,                52,       daRight,           true,                "hd_hul_ttl_wgt",     		false,               "",                   dfFloat,                      0,                   true,                true);
               
                	InitDataProperty(0, cnt++ , dtData,                52,       daRight,           true,                "hd_hul_crnt_slt_rt",  	false,               "",                   dfNullFloat,                  3,                   true,                true);
                	InitDataProperty(0, cnt++ , dtData,                52,       daRight,           true,                "hd_hul_new_slt_rt",   	false,               "",                   dfNullFloat,                	 3,                   true,                true);
                	InitDataProperty(0, cnt++ , dtData,                52,       daRight,           true,                "hd_hul_new_wgt_rt",   	false,               "",                   dfNullFloat,                  3,                   true,                true);
                	InitDataProperty(0, cnt++ , dtData,                52,       daRight,           true,                "hd_hul_incl_icrz_qty",	false,               "",                   dfInteger,                    0,                   true,                true);
                	InitDataProperty(0, cnt++ , dtData,                52,       daRight,           true,                "hd_hul_xcld_icrz_qty",	false,               "",                   dfInteger,                    0,                   true,                true);
                	
                	InitDataProperty(0, cnt++ , dtData,                52,       daRight,           true,                "bak_hul_hc_hld_qty", 		false,               "",                   dfInteger,                    0,                   true,                true);
                	InitDataProperty(0, cnt++ , dtData,                52,       daRight,           true,                "bak_hul_hc_deck_qty",		false,               "",                   dfInteger,                    0,                   true,                true);
                	InitDataProperty(0, cnt++ , dtData,                52,       daRight,           true,                "bak_hul_hc_incl_qty",		false,               "",                   dfInteger,                    0,                   true,                true);
                	InitDataProperty(0, cnt++ , dtData,                52,       daRight,           true,                "bak_hul_hc_xcld_qty",		false,               "",                   dfInteger,                    0,                   true,                true);
                	InitDataProperty(0, cnt++ , dtData,                52,       daRight,           true,                "bak_hul_act_ut_wgt", 		false,               "",                   dfFloat,                    	 0,                   true,                true);
                	InitDataProperty(0, cnt++ , dtData,                52,       daRight,           true,                "bak_hul_ttl_wgt",    		false,               "",                   dfFloat,                    	 0,                   true,                true);            
                	
                	InitDataProperty(0, cnt++ , dtData,                52,       daRight,           true,                "bak_hul_crnt_slt_rt", 	false,               "",                   dfNullFloat,                  3,                   true,                true);            
                	InitDataProperty(0, cnt++ , dtData,                52,       daRight,           true,                "bak_hul_new_slt_rt",  	false,               "",                   dfNullFloat,                  3,                   true,                true);            
                	InitDataProperty(0, cnt++ , dtData,                52,       daRight,           true,                "bak_hul_new_wgt_rt",  	false,               "",                   dfNullFloat,                  3,                   true,                true);            
                	InitDataProperty(0, cnt++ , dtData,                52,       daRight,           true,                "bak_hul_incl_icrz_qty",   false,            	 "",                   dfInteger,                    0,                   true,                true);            
                	InitDataProperty(0, cnt++ , dtData,                52,       daRight,           true,                "bak_hul_xcld_icrz_qty",   false,            	 "",                   dfInteger,                    0,                   true,                true);            
                	
                	InitDataProperty(0, cnt++ , dtData,                100,      daLeft,            true,                "ldb_capa_rmk",    		false,           	 "",                   dfNone,                       0,                   true,                true);            
                	
                    // Edit 가능한 셀과 불가능한 셀을 배경색으로 구분여부
                    EditableColorDiff = false;

                    ShowButtonImage = 3;
                    WaitImageVisible = false;
                    

                    break;
            }
        }
    }


    /**
     * Form의 Conrol 초기화 및 초기 이벤트 등록
     */
    function initControl() {
        // 기본 OnKeyPress 이벤트 (키입력)  - CoAcm.js에 정의
        axon_event.addListenerFormat("keypress", "frmObj_OnKeyPress", document.form);
        // OnChange 이벤트
        axon_event.addListener("change", "frmObj_OnChange", "rhq_cd_disp", "ar_ofc_cd", "agn_cd");
        // OnKeyUp 이벤트
        axon_event.addListener("keyup", "frmObj_OnKeyUp", "dir_agmt_no");
    }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {

        	case IBSEARCH:
                frmObj.f_cmd.value = SEARCH;
                shtObj.DoSearch("VOP_VSK_9503GS.do", FormQueryString(frmObj));
                
                
                break;
        
            case MULTI:
                if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value = MULTI;
                shtObj.DoAllSave("VOP_VSK_9503GS.do", FormQueryString(frmObj));
                ComOpenWait(false);
                break;
        }
    } 

    /**
     * IBSeet 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 저장 후 메시지
     */
    function sheet1_OnSaveEnd(shtObj, ErrMsg) {
        var shtObj = sheetObjects[0];
        var frmObj = document.form;

        if (ErrMsg != "") return;
    	ComShowCodeMessage('COM130102', 'Data');
    	doActionIBSheet(shtObj, frmObj, IBSEARCH);
    	
    }





/* 개발자 작업 끝 */
