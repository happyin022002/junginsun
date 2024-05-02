/* =========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName      : ESM_COA_0052.js
*@FileTitle     : LaneSimulation Step2 >> Port-tml Register (Port_Tml setting,Lane Projection,TML Transit Time)
*Open Issues    :
*Change history :
*@LastModifyDate: 2009-07-20
*@LastModifier  : jinyoung Yoon
*@LastVersion   : 1.0
========================================================= */

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab1 = 1;
var beforetab2 = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;
var loadingMode = false;
var p_sect_no = "";
var v_lod_ttl_qty = "";
var isDelFlg="false"; //SHEET에 삭제건이 있는 경우 TRUE를 갖는다.
var isAfterSecondSave = "false";

/* IBSheet Action */
//IBSEARCH       = 0;  // 조회
//IBSEARCHAPPEND = 1;  // 페이징 조회
//IBSAVE         = 2;  // 저장
//IBINSERT       = 3;  // 삽입
//IBCLEAR        = 4;  // 초기화
//IBDOWNEXCEL    = 5;  // 엑셀 다운로드
//IBLOADEXCEL    = 6;  // 엑셀 업로드
//IBCOPYROW      = 7;  // 행복사
//IBDELETE       = 8;  // 삭제
//RDPRINT        = 9;  // RD 연결
//IBROWSEARCH    = 10; // Row 조회
//IBCREATE       = 11; // Create
//IBRESET        = 12; // Reset
//IBBATCH        = 13; // Batch
IBEAISEND      = 14 //
IBEAIGET       = 15 //
IBCREATE2      = 16 //
IBCREATE3      = 17 //

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
     */
    function processButtonClick(){
        var sheetObject1 = sheetObjects[0]; // Port/TMNL Setting
        var sheetObject2 = sheetObjects[1]; // Route Projection - Lane G.RPB Projection
        var sheetObject3 = sheetObjects[2]; // Route Projection - Volume
        var sheetObject4 = sheetObjects[3]; // Route Projection - G.RPB
        var sheetObject5 = sheetObjects[4]; // TMNL Transit Time
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");
            if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
                case "btn_retrieve":
        					if(tabObjects[0].SelectedIndex==0){                     // Port/TMNL Setting
        						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
        					}else if(tabObjects[0].SelectedIndex==1){               // Route Projection
                                doActionIBSheet2(sheetObject2,formObject,IBSEARCH);
        					}else if(tabObjects[0].SelectedIndex==2){               // TMNL Transit Time
                                doActionIBSheet5(sheetObject5,formObject,IBSEARCH);
        					}
                break;

                case "btn_downexcel":
        					if(tabObjects[0].SelectedIndex==0){                     // Port/TMNL Setting
        						doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
        					}else if(tabObjects[0].SelectedIndex==1){               // Route Projection
                                doActionIBSheet2(sheetObject2,formObject,IBDOWNEXCEL);
        					}else if(tabObjects[0].SelectedIndex==2){               // TMNL Transit Time
                                doActionIBSheet5(sheetObject5,formObject,IBDOWNEXCEL);
        					}
                break;

                case "btn_save1":
        					if(tabObjects[0].SelectedIndex==0){                     // Port/TMNL Setting
        						doActionIBSheet(sheetObject1,formObject,IBSAVE);
                  }
                  break;

                case "btn_save2":
                  if(tabObjects[0].SelectedIndex==1){                     // Route Projection
                      doActionIBSheet2(sheetObject2,formObject,IBSAVE);
                  }
                  break;

                case "btn_save3":
                  if(tabObjects[1].SelectedIndex==0){                     //Route Projection - Volume
                      doActionIBSheet3(sheetObject3,formObject,IBSAVE);
                  }
                  break;

                case "btn_save4":
                    if(tabObjects[1].SelectedIndex==1){                     //Route Projection - G.RPB
                        doActionIBSheet4(sheetObject4,formObject,IBSAVE);
                    }
                    break;

                case "btn_save5":
          					if(tabObjects[0].SelectedIndex==2){                     // TMNL Transit Time
                                  doActionIBSheet5(sheetObject5,formObject,IBSAVE);
          					}
                    break;

                case "btn_create" :
          					if(tabObjects[0].SelectedIndex==1){                     // Route Projection
                                  doActionIBSheet3(sheetObject3,formObject,IBCREATE);
          					}
                    break;

                case "btn_creation" :
          					if (tabObjects[0].SelectedIndex==2){                    // TMNL Transit Time
                                  doActionIBSheet5(sheetObject5,formObject,IBCREATE);
          					}
                    break;

                case "btn_rowadd1":
                    if(tabObjects[0].SelectedIndex==0){                     // Port/TMNL Setting
                       doActionIBSheet(sheetObject1,formObject,IBINSERT);
                    }
                    break;

                case "btng_getopdays1":
          					if(tabObjects[0].SelectedIndex==0){                     // Port/TMNL Setting
                                  doActionIBSheet(sheetObject1,formObject,IBCREATE);
          					}
                    break;

                case "btng_getopdays2":
          					if(tabObjects[0].SelectedIndex==1){                     // Route Projection
                                  doActionIBSheet3(sheetObject3,formObject,IBINSERT);
          					}
                    break;

                case "prot_send":                                           // Route Projection
                    doActionIBSheet3(sheetObject3,formObject,IBCOPYROW);
                    break;

                default:
                    doActionPageMove(sheetObject1, formObject, srcName);

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
     * IBCombo Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
    }

    /**
    * Sheet 기본 설정 및 초기화
    * body 태그의 onLoad 이벤트핸들러 구현
    * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
    */
    function loadPage(c_slan_cd, slan_cd, dir_cd) {
    	loadingMode = true;
      // 텝 처리
      //---------------------------------------------
  		for(k=0;k<tabObjects.length;k++){
	  		initTab(tabObjects[k],k+1);
		  }
      // 멀티콤보 처리
      //---------------------------------------------
      for(k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],comboObjects[k].id);
      }
      // Sheet 처리
      //---------------------------------------------
      for(i=0;i<sheetObjects.length;i++){
      //khlee-시작 환경 설정 함수 이름 변경
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i+1,"");
        //khlee-마지막 환경 설정 함수 추가
        ComEndConfigSheet(sheetObjects[i]);
      }
      doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);

      loadingMode = false;

      document.tab2.Visible = true;
      sheetObj = sheetObjects[0];
      for(i=11;i<31;i++) {
        sheetObj.ColHidden(i)="true";
      }

      btn_retrieve.focus();
    }

    /**
     * 멀티콤보 항목을 설정한다.
     */
  	function initCombo(comboObj, comboId) {
  		with (comboObj) {
  			DropHeight = 300;
  			Index = 0;
  		}
  	}

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo, s3_header) {

        var indiCombo = "| |Y|N";
        var cnt = 0;
        switch(sheetNo) {
            case 1:      // Step2 :Tab1 : Port TML Setting
                with (sheetObj) {
                    SheetWidth = mainTable.clientWidth;                         //전체 너비 설정
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
                    MergeSheet = msHeaderOnly;                             //전체Merge 종류 [선택, Default msNone]
                    Editable = true;                                            //전체Edit 허용 여부 [선택, Default false]
                    InitRowInfo( 3, 1, 9, 100);                                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitColumnInfo(39, 0 , 0, true);                            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitHeadMode(false, false, false, true, false,false) ;      // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    var HeadTitle = "Del.|STS|S.Lane|Dir|Port|TMNL Code/Name|TMNL Code/Name|Turning Port\nIndicator|Port Day|Sea Day|Port Charge|ETB|ETB|ETB|ETD|ETD|ETD|Distance|Manu|Manu|Sea\nSPeed|Sea\nTime|Sea\nBuffer|Working\nHour|Port\nBuffer|In/Out Bound Cargo|In/Out Bound Cargo|In/Out Bound Cargo|In/Out Bound Cargo|Terminal\nProductivity.|Terminal\nProductivity.";
                    var HeadTitle1= "Del.|STS|S.Lane|Dir|Port|Code|Name|Turning Port\nIndicator|Port Day|Sea Day|Port Charge|NO.|DAY|TIME|NO.|DAY|TIME|Distance| IN |OUT |Sea\nSPeed|Sea\nTime|Sea\nBuffer|Working\nHour|Port\nBuffer|      IPC         |      IPC         |      Ocean       |      Ocean       |Count|Qty";
                    var HeadTitle2= "Del.|STS|S.Lane|Dir|Port|Code|Name|Turning Port\nIndicator|Port Day|Sea Day|Port Charge|NO.|DAY|TIME|NO.|DAY|TIME|Distance| IN |OUT |Sea\nSPeed|Sea\nTime|Sea\nBuffer|Working\nHour|Port\nBuffer|      IN          |      OUT         |       IN         |       OUT        |Count|Qty";

                    InitHeadRow(0, HeadTitle, true);                             //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(1, HeadTitle1, true);                            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(2, HeadTitle2, true);                            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    //데이터속성[         ROW,   COL,    DATATYPE,   WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,           KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN,    FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX]
                    InitDataProperty(     0,     cnt++,  dtDelCheck, 50,     daCenter,   true,       "delchk",           false,      "",         dfNone,     0,          true,       true);
                    InitDataProperty(     0,     cnt++,  dtStatus,   50,     daCenter,   true,       "ibflag",           false,      "",         dfNone,     0,          false,      false);
                    InitDataProperty(     0,     cnt++,  dtData,     100,    daCenter,   true,       "slan_cd",          false,      "",         dfNone,     0,          false,      false);
                    InitDataProperty(     0,     cnt++,  dtCombo,    60,     daCenter,   true,       "skd_dir_cd",       true,       "",         dfNone,     0,          true,       true);
                    InitDataProperty(     0,     cnt++,  dtData,     80,     daCenter,   true,       "port_cd",          true,      "",          dfNone,     0,          true,       true,       5,          true);
                    InitDataProperty(     0,     cnt++,  dtCombo,    60,     daCenter,   true,       "port_yd",          true,      "",          dfNone,     0,          true,       true);
                    InitDataProperty(     0,     cnt++,  dtData,     510,    daLeft,     true,       "tmnl_name",        false,      "",         dfNone,     0,          false,       false      );
                    InitDataProperty(     0,     cnt++,  dtCombo,    90,     daCenter,   true,       "turn_port_flg",    true,       "",         dfNone,     0,          true,       true);
                    InitDataProperty(     0,     cnt++,  dtData,     100,    daRight,    true,       "port_dys",         false,      "",         dfFloat,    0,          false,      false);
                    InitDataProperty(     0,     cnt++,  dtData,     100,    daRight,    true,       "sea_dys",          false,      "",         dfFloat,    0,          false,      false);
                    InitDataProperty(     0,     cnt++,  dtData,     131,    daCenter,   true,       "port_usd_amt",     false,      "",         dfNone,     0,          false,      false);
                    InitDataProperty(     0,     cnt++,  dtData,     50,     daCenter,   true,       "etb_dy_no",        false,      "",         dfInteger,  0);
                    InitDataProperty(     0,     cnt++,  dtCombo,    50,     daCenter,   true,       "etb_dy_cd",        false,      "",         dfNone,     0);
                    InitDataProperty(     0,     cnt++,  dtData,     50,     daCenter,   true,       "etb_tm_hrmnt",     false,      "",         dfTimeHm,   0);
                    InitDataProperty(     0,     cnt++,  dtData,     50,     daCenter,   true,       "etd_dy_no",        false,      "",         dfInteger,  0,          false,      false);
                    InitDataProperty(     0,     cnt++,  dtCombo,    50,     daCenter,   true,       "etd_dy_cd",        false,      "",         dfNone,     0,          false,      false);
                    InitDataProperty(     0,     cnt++,  dtData,     50,     daCenter,   true,       "etd_tm_hrmnt",     false,      "",         dfTimeHm,   0,          false,      false);
                    InitDataProperty(     0,     cnt++,  dtData,     60,     daRight,    true,       "lnk_dist",         false,      "",         dfFloat,    0,          true,       true);
                    InitDataProperty(     0,     cnt++,  dtData,     50,     daCenter,   true,       "mnvr_in_hrs",      false,      "",         dfFloat,    0,          true,       true);
                    InitDataProperty(     0,     cnt++,  dtData,     50,     daCenter,   true,       "mnvr_out_hrs",     false,      "",         dfFloat,    0,          true,       true);
                    InitDataProperty(     0,     cnt++,  dtData,     50,     daCenter,   true,       "lnk_spd",          false,      "",         dfFloat,    0,          true,       true);
                    InitDataProperty(     0,     cnt++,  dtData,     50,     daRight,    true,       "tztm_hrs",         false,      "",         dfFloat,    0,          false,      false);
                    InitDataProperty(     0,     cnt++,  dtData,     50,     daCenter,   true,       "sea_buf_hrs",      false,      "",         dfFloat,    0,          true,       true);
                    InitDataProperty(     0,     cnt++,  dtData,     70,     daRight,    true,       "act_wrk_hrs",      false,      "",         dfFloat,    0,          true,       true);
                    InitDataProperty(     0,     cnt++,  dtData,     60,     daCenter,   true,       "port_buf_hrs",     false,      "",         dfFloat,    0,          true,       true);
                    InitDataProperty(     0,     cnt++,  dtData,     50,     daCenter,   true,       "ib_ipcgo_qty",     false,      "",         dfInteger,  0,          true,       true);
                    InitDataProperty(     0,     cnt++,  dtData,     50,     daCenter,   true,       "ob_ipcgo_qty",     false,      "",         dfInteger,  0,          true,       true);
                    InitDataProperty(     0,     cnt++,  dtData,     50,     daCenter,   true,       "ib_ocn_cgo_qty",   false,      "",         dfInteger,  0,          true,       true);
                    InitDataProperty(     0,     cnt++,  dtData,     50,     daRight,    true,       "ob_ocn_cgo_qty",   false,      "",         dfInteger,  0,          true,       true);
                    InitDataProperty(     0,     cnt++,  dtData,     60,     daCenter,   true,       "crn_knt",          false,      "",         dfInteger,  0,          false,      false);
                    InitDataProperty(     0,     cnt++,  dtData,     60,     daCenter,   true,       "tml_prod_qty",     false,      "",         dfFloat,    0,          false,      false);
                    InitDataProperty(     0,     cnt++,  dtHidden,   0,      daRight,    true,       "vsl_dbl_call_seq", false,      "",         dfNone,     0,          false,      false);
                    InitDataProperty(     0,     cnt++,  dtHidden,   0,      daRight,    true,       "port_seq",         false,      "",         dfNone,     0,          false,      false);
                    InitDataProperty(     0,     cnt++,  dtHidden,   0,      daCenter,   true,       "zd",               false,      "",         dfNone,     0,          true,       true);
                    InitDataProperty(     0,     cnt++,  dtHidden,   0,      daCenter,   true,       "vol_cnt",          false,      "",         dfNone,     0,          true,       true);
                    InitDataProperty(     0,     cnt++,  dtHidden,   0,      daCenter,   true,       "stnd_svc_spd",     false,      "",         dfNone,     0,          true,       true);
                    InitDataProperty(     0,     cnt++,  dtHidden,   0,      daCenter,   true,       "row_num",          false,      "",         dfNone,     0,          true,       true);
                    InitDataProperty(     0,     cnt++,  dtHidden,   0,      daCenter,   true,       "tml_cd",           false,      "",         dfNone,     0,          true,       true);
                    InitDataProperty(     0,     cnt++,  dtHidden,   0,      daCenter,   true,       "turn_port_ind_cd", false,      "",         dfNone,     0,          true,       true);

                    CountPosition  = 0 ;
                    //InitDataValid(0, 9, vtEngUpOnly);
                    /*InitDataCombo(0,"skd_dir_cd", dir_cd,dir_cd);*/
                    InitDataCombo(0,"turn_port_flg", indiCombo,indiCombo);
     				InitDataCombo(0, "etb_dy_cd", "MON|TUE|WED|THU|FRI|SAT|SUN", "MON|TUE|WED|THU|FRI|SAT|SUN");
    				InitDataCombo(0, "etd_dy_cd", "MON|TUE|WED|THU|FRI|SAT|SUN", "MON|TUE|WED|THU|FRI|SAT|SUN");
                    style.height = GetSheetHeight(18) ;
                    //SetTitle = "Code|Name|Port Charge";
                    //InitDataCombo (0, 7, "","");
                    btn_calcuration_pre.style.display = "none";
                    btn_calcuration.style.display = "none";
                    btn_calcuration_next.style.display = "none";
                    SelectHighLight = false;
                    // 영문자 또는 숫자만 입력
                    InitDataValid(0, "port_cd", vtEngUpOther, "1234567890");
                }
                break;

            case 2:      // Route Projection - Lane G.RPB Projection
                with (sheetObj) {
                    SheetWidth = mainTable2.clientWidth;                             //전체 너비 설정
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
                    MergeSheet = msNone;                                            //전체Merge 종류 [선택, Default msNone]
                    Editable = true;                                                //전체Edit 허용 여부 [선택, Default false]
                    InitRowInfo( 1, 1, 9, 100);                                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitColumnInfo(16, 0 , 0, true);                                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitHeadMode(false, false, false, true, false,false) ;          // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    //var HeadTitle = "Del.|STS|No|S.Lane||R.Lane|OIC|Dir|BSA|Load|L/F(%)|G.RPB|G.REV||";
                    var HeadTitle = "STS|No||Trade|R.Lane|IOC|Dir|BSA|Load|L/F(%)|RPB|REV|port_info|port_dys|slan_cd";
                    var g_rev = "|grs_rpb_rev|*|lod_ttl_qty|";
                    InitHeadRow(0, HeadTitle, true);                                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]

                    //데이터속성[    ROW,   COL,    DATATYPE,   WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,       KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX]
                    InitDataProperty(0,     cnt++,  dtStatus,   30,     daCenter,   true,       "ibflag");
                    InitDataProperty(0,     cnt++,  dtData,     65,     daCenter,   false,      "",             false,      "",         dfNone,     0,          false,      false);
                    InitDataProperty(0,     cnt++,  dtHidden,   65,     daCenter,   false,      "sect_no",      false,      "",         dfNone,     0,          false,      false);
                    InitDataProperty(0,     cnt++,  dtData,     65,     daCenter,   false,      "trd_cd",       false,      "",         dfNone,     0,          false,      false);
                    InitDataProperty(0,     cnt++,  dtData,     65,     daCenter,   false,      "rlane_cd",     false,      "",         dfNone,     0,          false,      false);
                    InitDataProperty(0,     cnt++,  dtData,     65,     daCenter,   false,      "ioc_cd",       false,      "",         dfNone,     0,          false,      false);
                    InitDataProperty(0,     cnt++,  dtData,     65,     daCenter,   false,      "skd_dir_cd",   false,      "",         dfNone,     0,          false,      false);
                    InitDataProperty(0,     cnt++,  dtAutoSum,  65,     daRight,    false,      "bsa_capa",     false,      "",         dfInteger,  0,          false,      false);
                    InitDataProperty(0,     cnt++,  dtAutoSum,  65,     daRight,    false,      "lod_ttl_qty",  false,      "",         dfFloatOrg, 1,          false,      false);
                    InitDataProperty(0,     cnt++,  dtData,     70,     daRight,    false,      "ldf_rto",      false,      "",         dfNumber,   0,          false,      false);
                    InitDataProperty(0,     cnt++,  dtData,     70,     daRight,    false,      "grs_rpb_rev",  false,      "",         dfFloatOrg, 1,          true,       true);
                    InitDataProperty(0,     cnt++,  dtAutoSum,  50,     daRight,    false,      "grs_ttl_rev",  false,      g_rev,      dfFloatOrg, 1,          false,      false);
                    InitDataProperty(0,     cnt++,  dtHidden,   100,    daRight,    false,      "port_info",    false,      "",         dfNone,     0,          true,       true);
                    InitDataProperty(0,     cnt++,  dtHidden,   100,    daRight,    false,      "port_dys",     false,      "",         dfNone,     0,          true,       true);
                    InitDataProperty(0,     cnt++,  dtHidden,   100,    daRight,    false,      "sim_dt",       false,      "",         dfNone,     0,          true,       true);
                    InitDataProperty(0,     cnt++,  dtHidden,   100,    daRight,    false,      "sim_no",       false,      "",         dfNone,     0,          true,       true);


                    CountPosition  = 0 ;
                    style.height = GetSheetHeight(6) ;

                    //전체적으로 너비 재조정하기
                    //FitColWidth();
                }
                break;

            case 3:      // Route Projection - Volume
                var aryTitle = "";
                var colCnt = "";
                var colTotNum = "";

              if(s3_header == ""){headerInfo = "CNXGG|CNSHA|KRPUS|USLGB";}
                aryTitle = s3_header.split("|");
                colCnt = aryTitle.length;
                colTotNum = (colCnt+1)*3+2;

                with (sheetObj) {
                    SheetWidth = mainTable3.clientWidth;                                                             //전체 너비 설정
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);         //Host정보 설정[필수][HostIp, Port, PagePath]
                    MergeSheet = msNone;                                                                            //전체Merge 종류 [선택, Default msNone]
                    Editable = true;                                                                                //전체Edit 허용 여부 [선택, Default false]
                    InitRowInfo( 1, 1, 9, 100);                                                                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitColumnInfo(colTotNum , 0, 0, true);                                                         //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitHeadMode(false, false, false, true, false, false) ;                                         // 해더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable, ColumnMove, AllCheckEnable, UserResize, RowMove, Heade3D]
                    var HeadTitle = "STS|POL \ POD|" + s3_header + "|Total|" + s3_header + "|Total|" + s3_header + "|Total";
                    InitHeadRow(0, HeadTitle, true);                                                                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]

                    var tot = "" ;
                    var tot2 = "" ;
                    var tot3 = "" ;
                    var col = 0;

                    //데이터속성    [ROW,       COL,    DATATYPE,   WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,           KEYFIELD,       CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,         cnt++ , dtStatus,   30,     daCenter,   true,       "ibflag");
                    InitDataProperty(0,         cnt++ , dtData,     80,     daCenter,   false,      "pol_cd",           false,          "",         dfNone,      0,         false,      false);
                    for(j=0; j<colCnt; j++){
                        InitDataProperty(0,     cnt++ , dtAutoSum,  80,     daRight,    false,      aryTitle[j],        false,          "",         dfFloatOrg,     1,         true,       true, 5);
                        tot = tot + "|" + aryTitle[j] + "| ";
                        if(j != colCnt-1 ) tot = tot +  " + ";
                    }
                    InitDataProperty(0,         cnt++ , dtAutoSum,  100,    daRight,    false,      "tot",              false,          tot,        dfFloatOrg,     1,         false,       false);

                    for(j=0; j<colCnt; j++){
                        InitDataProperty(0,     cnt++ , dtAutoSum,  80,     daRight,    false,      aryTitle[j]+"_rto", false,          "",         dfFloatOrg,     1,         true,       true);
                        tot2 = tot2 + "|" + aryTitle[j] + "_rto" + "|";
                        if(j != colCnt-1 ) tot2 = tot2 +  " + ";
                    }
                    InitDataProperty(0,         cnt++ , dtAutoSum,  100,    daRight,    false,      "tot2",             false,          tot2,       dfFloatOrg,     1,         false,       false);


                    for(j=0; j<colCnt; j++){
                        InitDataProperty(0,     cnt++ , dtAutoSum,  80,     daRight,    false,      aryTitle[j]+"_lode",false,          "",         dfFloatOrg,     1,         true,       true);
                        tot3 = tot3 + "|" + aryTitle[j] + "_lode" + "|";
                        if(j != colCnt-1 ) tot3 = tot3 +  " + ";
                    }
                    InitDataProperty(0,         cnt++ , dtAutoSum,  100,    daRight,    false,      "tot3",             false,          tot3,       dfFloatOrg,     1,         false,       false);
                    //InitDataProperty(0,    			cnt++,  dtHidden,   100,    daRight,    false,      "sim_dt",       false,      "",         dfNone, 0,          true,       true);
                    //InitDataProperty(0,     		cnt++,  dtHidden,   100,    daRight,    false,      "sim_no",       false,      "",         dfNone, 0,          true,       true);

                    CountPosition  = 0 ;
                    style.height = GetSheetHeight(10) ;

                }
                cnt = 0;
                colCnt = sheetObj.LastCol+1;
                cnt = (colCnt -2)/3;

                for(j=2; j<colCnt; j++){
                    if(cnt+2<=j){
                        sheetObj.ColHidden(j) = true;
                    }
                }
                break;

            case 4:      // Route Projection - RPB
            	var aryTitle = "";
            	var colCnt = "";
            	var colTotNum = "";

            	if(s3_header == ""){headerInfo = "CNXGG|CNSHA|KRPUS|USLGB";}
            	aryTitle = s3_header.split("|");
            	colCnt = aryTitle.length;
            	colTotNum = (colCnt)+2;

            with (sheetObj) {
                SheetWidth = mainTable4.clientWidth;                                                             //전체 너비 설정
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);         //Host정보 설정[필수][HostIp, Port, PagePath]
                MergeSheet = msNone;                                                                            //전체Merge 종류 [선택, Default msNone]
                Editable = true;                                                                                //전체Edit 허용 여부 [선택, Default false]
                InitRowInfo( 1, 1, 9, 100);                                                                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitColumnInfo(colTotNum , 0, 0, true);                                                         //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitHeadMode(false, false, false, true, false, false) ;                                         // 해더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable, ColumnMove, AllCheckEnable, UserResize, RowMove, Heade3D]
                var HeadTitle = "STS|POL \ POD|" + s3_header;
                InitHeadRow(0, HeadTitle, true);                                                                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]

                //데이터속성    [ROW,    COL,    DATATYPE,   WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,       KEYFIELD,       CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0,         cnt++ , dtStatus,   30,     daCenter,   true,       "ibflag");
                InitDataProperty(0,         cnt++ , dtData,     80,     daCenter,   false,      "pol_cd",           false,          "",         dfNone,      0,         false,      false);
                for(j=0; j<colCnt; j++){
                    InitDataProperty(0,     cnt++ , dtData,  80,    daRight,     false,      aryTitle[j],        false,          "",         dfFloatOrg,     1,         true,       true);
                }
                CountPosition  = 0 ;
                style.height = GetSheetHeight(10) ;
            }
                break;
            case 5:      // TMNL Transit Time
            with (sheetObj) {
                SheetWidth = mainTable5.clientWidth;                         //전체 너비 설정
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
                MergeSheet = msPrevColumnMerge;                             //전체Merge 종류 [선택, Default msNone]
                Editable = true;                                            //전체Edit 허용 여부 [선택, Default false]
                InitRowInfo( 1, 1, 9, 100);                                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitColumnInfo(13, 0 , 0, true);                            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitHeadMode(true, false, false, true, false,false) ;      // 해더에서 처리할 수 있는 각종 기능을 설정한다
                var HeadTitle = "STS|Trade|R.Lane|Dir|Ind|Port Seq|TMNL|Port Day|Sea Day|Total Days|Ratio|sect_no";
                InitHeadRow(0, HeadTitle, true);                            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                //데이터속성[         ROW,   COL,    DATATYPE,   WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,       KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN,    FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX]
                InitDataProperty(0,     cnt++,  dtStatus,   50,     daCenter,   false,      "ibflag",          false,      "",         dfNone,     0,          false,      false);
                InitDataProperty(0,     cnt++,  dtData,     50,     daCenter,   true,       "trd_cd",          false,      "",         dfNone,     0,          false,      false);
                InitDataProperty(0,     cnt++,  dtData,     50,     daCenter,   true,       "rlane_cd",        false,      "",         dfNone,     0,          false,      false);
                InitDataProperty(0,     cnt++,  dtData,     40,     daCenter,   true,       "skd_dir_cd",      false,      "",         dfNone,     0,          false,      false);
                InitDataProperty(0,     cnt++,  dtData,     40,     daCenter,   true,       "vsl_dbl_call_seq",false,      "",         dfNone,     0,          false,      false);
                InitDataProperty(0,     cnt++,  dtData,     60,     daCenter,   true,       "port_seq",        false,      "",         dfNone,     0,          false,      false);
                InitDataProperty(0,     cnt++,  dtData,     70,     daCenter,   true,       "tml_cd",          false,      "",         dfNone,     0,          false,      false,       2,          true);
                InitDataProperty(0,     cnt++,  dtAutoSum,  70,     daRight,    true,       "port_dys",        false,      "",         dfFloatOrg, 2,          true,       true);
                InitDataProperty(0,     cnt++,  dtAutoSum,  70,     daRight,    true,       "sea_dys",         false,      "",         dfFloatOrg, 2,          true,       true);
                InitDataProperty(0,     cnt++,  dtAutoSum,  70,     daRight,    true,       "ttl_tz_dys",      false,      "|port_dys|+|sea_dys|",         dfFloatOrg, 2,          false,       false);
                InitDataProperty(0,     cnt++,  dtData,     60,     daCenter,   true,       "aply_voy_rto",    false,      "",         dfNumber,   0,          true,       true);
                InitDataProperty(0,     cnt++,  dtHidden,   0,      daCenter,   true,       "sect_no",         false,      "",         dfNone,     0,          true,       true);

                CountPosition  = 0 ;
                style.height = GetSheetHeight(18) ;
                // 영문자 또는 숫자만 입력
                InitDataValid(0, "tml_cd", vtEngUpOnly);
            }
            break;
        }
    }

 // Step2 :Tab1 : Port TML Setting ----------------------------------------------------------------
     /**
     * Tab1:Port/TMNL Setting
     * Sheet관련 프로세스 처리
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
        	case IBCLEAR:          //조회
		        sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = INIT;

				var sXml = formObj.sXml.value;
				var arrXml = sXml.split("|$$|");
				document.form.sXml.value = "";
				/*
				var sXml = sheetObj.GetSearchXml("ESM_COA_0051GS3.do", coaFormQueryString(formObj));
				var arrXml = sXml.split("|$$|");*/
				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], formObj.f_slan_cd, "code", "name");
				if (arrXml.length > 1)
					ComXml2ComboItem(arrXml[1], formObj.f_dept_cd2, "code", "name");
				if (arrXml.length > 2)
					ComXml2ComboItem(arrXml[2], formObj.f_sim, "code", "name");
				if (arrXml.length > 3)
					ComXml2ComboItem(arrXml[3], formObj.f_trd_cd, "code", "code");
				if (arrXml.length > 4)
					ComXml2ComboItem(arrXml[4], formObj.f_rlane_cd, "code", "code");
				if (arrXml.length > 5)
					ComXml2ComboItem(arrXml[5], formObj.f_dir_cd, "code", "code");
				if (arrXml.length > 6)
					ComCoaSetIBCombo(sheetObj, arrXml[6], "skd_dir_cd", false, 0);

				with(formObj) {
					ComSetObjValue(f_sim, ComCoaGetEtcData(arrXml[0], "f_sim"));
					ComSetObjValue(f_slan_cd,ComCoaGetEtcData(arrXml[0], "f_slan_cd"));
					ComSetObjValue(f_sim_dt,ComCoaGetEtcData(arrXml[0], "f_sim_dt"));
					ComSetObjValue(f_sim_no,ComCoaGetEtcData(arrXml[0], "f_sim_no"));
					ComSetObjValue(f_sim_rmk,ComCoaGetEtcData(arrXml[0], "f_sim_rmk"));
					ComSetObjValue(f_dept_cd,ComCoaGetEtcData(arrXml[0], "f_dept_cd"));
					ComSetObjValue(f_dept_cd2,ComCoaGetEtcData(arrXml[0], "f_dept_cd2"));
					ComSetObjValue(f_usr_id,ComCoaGetEtcData(arrXml[0], "f_usr_id"));
				}
				ComOpenWait(false);
				break;
            case IBSEARCH:      //조회
                //formObj.f_save_flg.value="false";
                formObj.f_cmd.value = SEARCHLIST01;
                if(!validateForm(sheetObj,formObj,sAction)) return false;
                // 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
                sheetObj.DoSearch4Post("ESM_COA_0052GS.do", coaFormQueryString(formObj));

                ComOpenWait(false);
                formObj.f_ext_flg.value = sheetObj.EtcData("extd_lane_flg");
                if(sheetObj.EtcData("vsl_clss_capa") != "null" && sheetObj.EtcData("vsl_cnt") != "null") {
                    var vsl_clss_capa = sheetObj.EtcData("vsl_clss_capa");
                    var vsl_cnt       = sheetObj.EtcData("vsl_cnt");
                    var vslClssCode = vsl_clss_capa.split("|");
                    var vslCntCode = vsl_cnt.split("|");
                    for(i=0;i<vslClssCode.length;i++) {
                      if(i==0) {
                        formObj.n1st_vsl_clss_cd.value  = vslClssCode[i];
                        formObj.n1st_vsl_clss_knt.value = vslCntCode[i];
                      } else if(i==1) {
                        formObj.n2nd_vsl_clss_cd.value  = vslClssCode[i];
                        formObj.n2nd_vsl_clss_knt.value = vslCntCode[i];
                      } else if(i==2) {
                        formObj.n3nd_vsl_clss_cd.value  = vslClssCode[i];
                        formObj.n3nd_vsl_clss_knt.value = vslCntCode[i];
                      }
                    }
                    formObj.f_min_speed.value      = sheetObj.EtcData("min_speed");
                    formObj.f_max_speed.value      = sheetObj.EtcData("max_speed");
                    formObj.f_svc_dur_dys.value    = sheetObj.EtcData("svc_dur_dys");
                    formObj.f_brth_itval_dys.value = sheetObj.EtcData("brth_itval_dys");
                }
                if(formObj.f_ext_flg.value == "Y"){
                    //td_sd.style.display = "none";
                    //td_pt.style.display = "none";
                    td_getPT.style.display = "block";
                }else{
                    //td_sd.style.display = "block";
                    //td_pt.style.display = "block";
                    td_getPT.style.display = "none";
                }
                //last row 비활성화
                if(formObj.f_calcu_btn_flg.value=="false") {
                    btn_calcuration_pre.style.display = "none";
                    btn_calcuration.style.display = "none";
                    btn_calcuration_next.style.display = "none";
                } else {
                    btn_calcuration_pre.style.display = "block";
                    btn_calcuration.style.display = "block";
                    btn_calcuration_next.style.display = "block";
                }
   				var rowPos = sheetObj.HeaderRows + sheetObj.RowCount;
				//if(formObj.f_save_flg.value=="true") {
				    setlastLowView(sheetObj,rowPos);
				//}
				if(rowPos > 0) {
				    //2009.12.14 윤진영 추가 김기원 요청.
				    // sheet 의 ETB first 항목을 폼으로 복사
				    formObj.fpeNo.value = sheetObj.CellValue(3,"etb_dy_no");
				    formObj.fpeCd.options[formObj.fpeCd.selectedIndex].text  = sheetObj.CellValue(3,"etb_dy_cd");
				    formObj.fpeCd.options[formObj.fpeCd.selectedIndex].value = sheetObj.CellValue(3,"etb_dy_cd");
				    var peHm = sheetObj.CellValue(3,"etb_tm_hrmnt");
				    peHm = peHm.substring(0,2)+":"+peHm.substring(2);
				    formObj.fpeHm.value = peHm;
				    //duration 1을 duration 2로 복사
				    var svc_dur_dys = formObj.f_svc_dur_dys.value;
				    if(svc_dur_dys != null && svc_dur_dys !="") {
				        formObj.f_svc_dur_dys_result.value = formObj.f_svc_dur_dys.value;
				    }
				}

                if(formObj.f_svc_dur_dys_result.value != "" && (formObj.f_svc_dur_dys.value==formObj.f_svc_dur_dys_result.value)) {
                    btn_calcuration_pre.style.display = "block";
                    btn_calcuration.style.display = "block";
                    btn_calcuration_next.style.display = "block";
                }

                formObj.f_slan_cd2.value = sheetObj.CellValue(3,"slan_cd");

                break;

            case IBROWSEARCH:  //Yard code조회
                formObj.f_cmd.value = SEARCHLIST02;
                var row_no = sheetObj.SelectRow;
                if (sheetObj.CellValue(row_no, "port_cd").length <5) return false;
                // 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				var sXml = sheetObj.GetSearchXml("ESM_COA_0052GS5.do",coaFormQueryString(formObj)+"&row_no="+row_no+"&port_cd="+sheetObj.CellValue(row_no,"port_cd")+"&skd_dir_cd="+sheetObj.CellValue(row_no,"skd_dir_cd"),true);

				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0)
					ComCoaSetIBCombo(sheetObj, arrXml[0], "port_yd", "" ,0, row_no);

				ComOpenWait(false);
				var sText  = sheetObj.GetComboInfo(row_no,sheetObj.SaveNameCol("port_yd"), "Text");
        		var idx   = sheetObj.GetComboInfo(row_no,sheetObj.SaveNameCol("port_yd"), "SelectedIndex");
        		if (idx < 0) idx =0;
        		//if (idx < 0) return;

				var arrText = sText.split("|");
				var schText	= arrText[idx];
				if (schText == undefined) return;
				var port_yd	= schText.split("\t");
				sheetObj.CellValue2(row_no,"port_yd") = port_yd[0];
				sheetObj.CellValue2(row_no,"tmnl_name") = port_yd[1];
				sheetObj.CellValue2(row_no,"port_usd_amt") = port_yd[2];


                break;

            case IBCREATE:        // 인터페이스  : Port day를 받아 온다
               if(sheetObj.CellValue(sheetObj.SelectRow, "vol_cnt") > 0 ){
            	   ComShowMessage(ComGetMsg("COA10045"));
                   return;
                }
                formObj.f_cmd.value = SEARCHLIST03;
                if(!validateForm(sheetObj,formObj,sAction)) return false;
                // 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
                sheetObj.DoSearch4Post("ESM_COA_0052GS.do", coaFormQueryString(formObj));
                ComOpenWait(false);

                var Result = sheetObj.EtcData("result");
                sheetObj.RemoveEtcData();
                if (Result=="OK"){
                      ComShowMessage(ComGetMsg("COA10006"));
                }

                break;

            case IBSAVE:        //저장
                if(!validateForm(sheetObj,formObj,sAction)) return false;
                if(!chkMendatory()){    //MENDATORY 항목 체크
                    return false;
                }


                var delCnt = 0;
                if(formObj.f_brth_itval_dys.value == '' || formObj.f_brth_itval_dys.value == null) {
              	  ComShowMessage(ComGetMsg("COA10048"));
               	  //frequency is empty..
                  return;
                }
                for(a=3;a<sheetObj.RowCount+3;a++) {
                    //if(sheetObj.CellValue(a,"ibflag")=="D") {
                	if(sheetObj.RowStatus(a)=="D") {
                        isDelFlg = "true";
                        delCnt++;
                    }
                }
                if(sheetObj.RowCount != delCnt) {
                    isDelFlg = "false";
                }
                if(formObj.f_save_flg.value=="false") {  //calculation 전은 false
                  formObj.f_cmd.value = MULTI01;
                } else {
                  if(isDelFlg=="false" && formObj.f_svc_dur_dys.value != formObj.f_svc_dur_dys_result.value) {
                	  ComShowMessage(ComGetMsg("COA10046"));
                	  //duration not match..
                    return;
//                } else if(isDelFlg=="false" && sheetObj.CellValue(sheetObj.SelectRow, "vol_cnt") < 1  ){
//              	  ComShowMessage(ComGetMsg("COA10047"));
                	  //저장 전에 Route Projection 데이터를 먼저 넣어야 합니다.
//                    return;
                  } else {
                    formObj.f_cmd.value = MULTI06;
                    isAfterSecondSave = "true";
                  }

                }

                var Row = sheetObj.ColValueDup("sect_no|slan_cd|rlane_cd|skd_dir_cd|port_cd|tmnl_cd|vsl_dbl_call_seq");
                if(Row != -1){
                    // [COM12115] >> Vessel가(이) 중복되었습니다.
                    ComShowMessage(ComGetMsg("COM12115", "Port Terminal"));
                    return false;
                }
                var tmpPortCd = "";
                var tmpYardCd = "";
                var insertflg = false;
                for(a=3;a<sheetObj.RowCount+3;a++) {
                  tmpPortCd += sheetObj.CellValue(a, "port_cd");
                  if(a-3 != sheetObj.RowCount-1) tmpPortCd += "|";
                  tmpYardCd += sheetObj.CellValue(a, "port_yd");
                  if(a-3 != sheetObj.RowCount-1) tmpYardCd += "|";
                  if(sheetObj.RowStatus(a)=="I" || sheetObj.RowStatus(a)=="U") {
                    insertflg=true;
                  }
                  sheetObj.CellValue(a,"row_num")=a-2;

                  sheetObj.CellValue(a,"tml_cd") = sheetObj.CellValue(a, "port_cd")+sheetObj.CellValue(a, "port_yd");
                }
//                if(insertflg) {
//                  for(a=3;a<sheetObj.RowCount+3;a++) {
//                    if(sheetObj.CellValue(a,"ibflag")=="R") {
//                      sheetObj.CellValue2(a,"ibflag")="I";
//                    }
//                  }
//                }
                formObj.f_port_arr.value = tmpPortCd; //distance를 구하기 위하여 sheet port_cd정보를 |로 연결해서 히든에 담는다.
                formObj.f_yard_arr.value = tmpYardCd; //distance를 구하기 위하여 sheet port_cd정보를 |로 연결해서 히든에 담는다.
                var bb="";
                // 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
                sheetObj.DoAllSave("ESM_COA_0052GS.do", coaFormQueryString(formObj));
                ComOpenWait(false);
                if(formObj.f_save_flg.value=="false") {
                  ComShowMessage(ComGetMsg("COA10049"));
                } else {
                  ComShowMessage(ComGetMsg("COA10050"));
                }
                doActionIBSheet(sheetObj,formObj,IBSEARCH);
                break;

            case IBINSERT:      // 입력
//                // Route Projection에 데이터가 입력되지 않았을때만 추가 할 수 있다.
//                //------------------------------------------------------
//
//                if(sheetObj.CellValue(sheetObj.SelectRow, "vol_cnt") <= 0 ){
//                    sheetObj.DataInsert();
//                    /* Row 추가 후 키정보를 바로위행의 정보를 입력한다.*/
//                    if(sheetObj.SelectRow > 3){
////                      sheetObj.CellValue2(sheetObj.SelectRow, "sectNo")     = sheetObj.CellValue(sheetObj.SelectRow-1, "sectNo");
////                      sheetObj.CellValue2(sheetObj.SelectRow, "sect_no")    = sheetObj.CellValue(sheetObj.SelectRow-1, "sect_no");
//                        sheetObj.CellValue2(sheetObj.SelectRow, "slan_cd")    = sheetObj.CellValue(sheetObj.SelectRow-1, "slan_cd");
////                      sheetObj.CellValue2(sheetObj.SelectRow, "rlane_cd")   = sheetObj.CellValue(sheetObj.SelectRow-1, "rlane_cd");
//                        sheetObj.CellValue2(sheetObj.SelectRow, "skd_dir_cd") = sheetObj.CellValue(sheetObj.SelectRow-1, "skd_dir_cd");
//                        sheetObj.CellValue2(sheetObj.SelectRow, "sim_dt")     = sheetObj.CellValue(sheetObj.SelectRow-1, "sim_dt");
//                        sheetObj.CellValue2(sheetObj.SelectRow, "sim_no")     = sheetObj.CellValue(sheetObj.SelectRow-1, "sim_no");
//                        sheetObj.CellValue(sheetObj.SelectRow, "port_seq")    = parseInt(sheetObj.CellValue(sheetObj.SelectRow-1, "port_seq"))+1;
//                    }
//                }
                   if(sheetObj.CellValue(sheetObj.SelectRow, "vol_cnt") > 0 ){
                	   ComShowMessage(ComGetMsg("COA10045"));
                       return;
                    }
				       var rowIdx = sheetObj.RowCount + sheetObj.HeaderRows;
				       if(rowIdx == sheetObj.HeaderRows){
				       	 sheetObj.DataInsert(-1);
				       	 resetRowSeq(sheetObj);

				       	 var rowIdx2 = sheetObj.RowCount + sheetObj.HeaderRows - 1;
				       	 sheetObj.CellValue(rowIdx2,"row_seq") = sheetObj.RowCount;
				       	 sheetObj.CellValue(rowIdx2,"etb_dy_no") = 0;
				       	 sheetObj.CellValue(rowIdx2,"etb_dy_cd") = "MON";
				       	 sheetObj.CellValue(rowIdx2,"etb_tm_hrmnt") = "00:00";
				       	 sheetObj.CellEditable(rowIdx2,"etd_dy_no") = false;
				       	 sheetObj.CellEditable(rowIdx2,"etd_dy_cd") = false;
				       	 sheetObj.CellEditable(rowIdx2,"etd_tm_hrmnt") = false;
				       	 sheetObj.SelectCell(rowIdx2,"port_cd", true);

				       	 //if(sheetObj.CellValue(rowIdx2,"ibflag") == "I"){
				       	 if(sheetObj.RowStatus(rowIdx2) == "I"){
				       		 sheetObj.CellEditable(rowIdx2,"tztm_hrs") = false;
				       		 sheetObj.CellEditable(rowIdx2,"sea_buf_spd") = false;
				       		 sheetObj.CellEditable(rowIdx2,"tml_prod_qty") = false;
				       		 sheetObj.CellEditable(rowIdx2,"crn_knt") = false;
				       	 }
				       }else{
				       	 sheetObj.DataInsert(-1);
				       	 resetRowSeq(sheetObj);
				       	 var lastRow = searchLastRow(sheetObj);

				       	 //2009 09 29 임창빈 수석 요청 전 포트의 skd_dir_cd를  add Row한 현재 포트에 셋팅한다
				       	sheetObj.CellValue(lastRow-1, "slan_cd") =  formObj.f_slan_cd.text;
 			       	  sheetObj.CellValue(lastRow-1, "skd_dir_cd") =  sheetObj.CellValue(lastRow-2,"skd_dir_cd");
				       	sheetObj.CellEditable(lastRow-1,"etb_dy_no") = false;
				       	sheetObj.CellEditable(lastRow-1,"etb_dy_cd") = false;
				       	sheetObj.CellEditable(lastRow-1,"etb_tm_hrmnt") = false;
				       	sheetObj.CellEditable(lastRow-1,"etd_dy_no") = false;
				       	sheetObj.CellEditable(lastRow-1,"etd_dy_cd") = false;
				       	sheetObj.CellEditable(lastRow-1,"etd_tm_hrmnt") = false;
				       	sheetObj.SelectCell(lastRow-1, "port_cd", true);

				       	//if(sheetObj.CellValue(lastRow-1,"ibflag") == "I"){
				       	if(sheetObj.RowStatus(lastRow-1) == "I"){
				       		sheetObj.CellEditable(lastRow-1,"tztm_hrs") = false;
				       		sheetObj.CellEditable(lastRow-1,"sea_buf_spd") = false;
				       		sheetObj.CellEditable(lastRow-1,"tml_prod_qty") = false;
				       		sheetObj.CellEditable(lastRow-1,"crn_knt") = false;

				       	}

				       	setlastLowViewUndo(sheetObj,lastRow-1);
				       	setlastLowView(sheetObj,lastRow);
				       	if(sheetObj.SelectRow > 3){
				       	  sheetObj.CellValue(sheetObj.SelectRow, "port_seq") = parseInt(sheetObj.CellValue(sheetObj.SelectRow-1, "port_seq"))+1;
				       	}
				       }
                break;

            case IBDOWNEXCEL:        //엑셀 다운로드
                var excelType = selectDownExcelMethod(sheetObj);
				switch (excelType) {
					case "AY":
                        sheetObj.Down2Excel(0, false, false, true);
                        break;
					case "DY":
                        sheetObj.Down2Excel(-1, true, false, true);
                        break;
   					case "AN":
                        sheetObj.SpeedDown2Excel(0, false, false);
                        break;
					case "DN":
                        sheetObj.SpeedDown2Excel(-1, false, false);
                        break;
                }
                break;

            case IBSEARCHAPPEND:  //Calculation
                formObj.f_cmd.value = MULTI09;
                if(!validateForm(sheetObj,formObj,sAction)) return false;
                // 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
                sheetObj.DoAllSave("ESM_COA_0052GS.do", coaFormQueryString(formObj));
                ComOpenWait(false);
                formObj.f_min_speed.value = sheetObj.EtcData("min_speed");
                formObj.f_max_speed.value = sheetObj.EtcData("max_speed");
                //Duration 2 구하기..
                var f_day  = sheetObj.CellValue("3","etb_dy_no");
                var f_hour = sheetObj.CellValue("3","etb_tm_hrmnt");
                var l_day  = sheetObj.CellValue(searchLastRow(sheetObj)-1,"etb_dy_no");
                var l_hour = sheetObj.CellValue(searchLastRow(sheetObj)-1,"etb_tm_hrmnt");
                formObj.f_svc_dur_dys_result.value = diff_date(f_day,f_hour,l_day,l_hour);  //ETB 종료 - ETB 시작
                //port,sea dys 구하기..
                for(i=3;i<searchLastRow(sheetObj)-1;i++) {
                  f_day  = sheetObj.CellValue(i,"etb_dy_no");       //입항
                  f_hour = sheetObj.CellValue(i,"etb_tm_hrmnt");
                  l_day  = sheetObj.CellValue(i,"etd_dy_no");       //출항
                  l_hour = sheetObj.CellValue(i,"etd_tm_hrmnt");
                  a_day  = sheetObj.CellValue(i+1,"etb_dy_no");     //입항 + 1로우
                  a_hour = sheetObj.CellValue(i+1,"etb_tm_hrmnt");
                  sheetObj.CellValue(i,"port_dys")= diff_date(f_day,f_hour,l_day,l_hour);
                  sheetObj.CellValue(i,"sea_dys")= diff_date(l_day,l_hour,a_day,a_hour);
                }

                //f_save_flg 값 설정 변경한다. (첫번째 저장과 최종 저장(no calc)을 구별하기 위함)
                formObj.f_save_flg.value = "true";
                break;
        }
    }


    function sheet1_OnSaveEnd(sheetObj,ErrMsg){
        var formObj = document.form;
        if(isDelFlg=="false" && isAfterSecondSave=="false") { //삭제 프로세스 경우 칼큐버튼 비활성화 유지한다. 20091209 윤진영
            formObj.f_calcu_btn_flg.value="true";
        } else {
            formObj.f_calcu_btn_flg.value="false";
        }

        if(isAfterSecondSave=="false" && formObj.f_calcu_btn_flg.value =="false"){
        	doActionIBSheet(sheetObj,formObj,IBSEARCH);
        }
    }

    /**
     * PORT와 TERMINAL코드의 LENGTH체크
     * 소솟점으로 받은 것을 %로 변환
     */
    function sheet1_OnChange(sheetObj, row, col, value){
        var formObj = document.form;

        // Port정보가 변경되었을때 max length를 체크한다.
        //-----------------------------------------------
        if(sheetObj.ColSaveName(col) == "port_cd"){
            if(value.length != 5 && value.length != 0){
                // [COM12174] >> PORT는(은) 5자리가 되어야 합니다.
                ComShowMessage(ComGetMsg("COM12174","PORT","5"))
                sheetObj.SelectCell(row, "port_cd", true);
            }
            var findRow = "1";
            var cnt = 1;
            var tmp = ""
            if(value == ""){
                cnt = "";
            }else{
                for(i=1; i<sheetObj.LastRow;i++){
                    // Section에 대한 Port 순번을 먹인다.
                    //-----------------------------------------------
                    if(sheetObj.CellValue(row, "skd_dir_cd") == sheetObj.CellValue(i, "skd_dir_cd")){
                        findRow = sheetObj.FindText("port_cd", value, i);
                        if(findRow != -1 && findRow != row){
                             cnt++;
                             i=findRow;
                        }
                    }
                }
            }
            sheetObj.CellValue(row, "vsl_dbl_call_seq") = cnt;
            doActionIBSheet(sheetObj,formObj,IBROWSEARCH);
        // Terminal정보가 변경되었을때 Max Length를 체크한다.
        //-----------------------------------------------
        }else if(sheetObj.ColSaveName(col) == "port_yd"){
            if(value.length != 2 && value.length != 0){
                // [COM12174] >> Terminal는(은) 2자리가 되어야 합니다.
                ComShowMessage(ComGetMsg("COM12174", "Terminal","2"))
                sheetObj.SelectCell(row, "port_yd", true);
            }
//        }else if(sheetObj.ColSaveName(col) == "port_yd"){
            //콤보코드와 텍스트를 가져온다.
            var sText = sheetObj.GetComboInfo(row,col, "Text");
            //각각 배열로 구성한다.
            var arrText = sText.split("|");
            var idx   = sheetObj.GetComboInfo(row,col, "SelectedIndex");
            //2행의 2컬럼의 콤보 텍스트와 코드를 확인한다.
            var arrTextCode = arrText[idx].split("	");
            sheetObj.CellValue(row, "tmnl_name") = arrTextCode[1];
            sheetObj.CellValue(row, "port_usd_amt") = arrTextCode[2];
        }
        // 변경된 Row의 상태가 Insert, Delete 일경우 Port seq를 다시 세팅한다.
        //-----------------------------------------------
        if(sheetObj.RowStatus(row) == "I"){
            param = sheetObj.CellValue(row, "port_seq");
            for(i=row+1; i<sheetObj.LastRow; i++){
                sheetObj.CellValue2(i, "port_seq") = ++param;
            }
        }
    }

    /**
     *
     */
    function sheet1_OnClick(sheetObj, row, col, value){
        var param;

        if(sheetObj.ColSaveName(col) == "delchk"){
            param = sheetObj.CellValue(row, "port_seq");
            if(sheetObj.RowStatus(row) == "I" || sheetObj.RowStatus(row) == "D"){
                for(i=row+1; i<sheetObj.LastRow; i++){
                    //ComShowMessage(i+":"+sheetObj.CellValue(i, "port_seq")+":"+param+":"+sheetObj.LastRow);
                    sheetObj.CellValue2(i, "port_seq") = param++;
                    //ComShowMessage(sheetObj.CellValue(i, "port_seq"));
                }
            }
        }
    }

    /**
     *
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
        var formObj = document.form;

        sheetObj.SumText(0, "ibflag") = "";
        sheetObj.SumText(0, "port_cd") = "Total";
        sheetObj.SumValue(0, "turn_port_flg") = sheetObj.SumValue(0, "port_dys") + sheetObj.SumValue(0, "sea_dys");

        //sheetObj.SumValue(0, "turn_port_ind_cd") = (parseFloat(sheetObj.SumValue(0, "port_dys"))+parseFloat(sheetObj.SumValue(0, "sea_dys"))).toFixed(3) ;

    }


//Step2 :Tab2 : Route Projection - Lane G.RPB Projection -----------------------------------------
    /**
     * Tab2 : Route Projection - Lane G.RPB Projection
     * Sheet관련 프로세스 처리
     */
    function doActionIBSheet2(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {
            case IBSEARCH:      //조회
                formObj.f_cmd.value = SEARCHLIST04;
                if(!validateForm(sheetObj,formObj,sAction))return false;
                //formObj.sim_dt.value = formObj.f_sim_dt.value;
                //formObj.sim_no.value = formObj.f_sim_no.value;
                // 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
                sheetObj.DoSearch4Post("ESM_COA_0052GS2.do", coaFormQueryString(formObj));
                ComOpenWait(false);
                break;

            case IBSAVE:        //저장
                formObj.f_cmd.value = MULTI02;
                for(i=1;i<sheetObj.LastRow;i++) {
                	sheetObj.CellValue2(i,"sim_dt")=formObj.f_sim_dt.value;
                	sheetObj.CellValue2(i,"sim_no")=formObj.f_sim_no.value;
                }
                if(!validateForm(sheetObj,formObj,sAction))return false;
                // 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
                sheetObj.DoSave("ESM_COA_0052GS2.do", coaFormQueryString(formObj));
                ComOpenWait(false);
                break;

            case IBDOWNEXCEL:        //엑셀 다운로드
                var excelType = selectDownExcelMethod(sheetObj);
				switch (excelType) {
					case "AY":
                        sheetObjects[1].Down2Excel(0, false, false, true);
                        if(tabObjects[1].SelectedIndex==0){                 //Route Projection - Volume
                           sheetObjects[2].Down2Excel(0, false, false, true);
                        }else if(tabObjects[1].SelectedIndex==1){           //Route Projection - G.RPB
                            sheetObjects[3].Down2Excel(0, false, false, true);
                        }
                        break;
					case "DY":
                        sheetObjects[1].Down2Excel(-1, true, false, true);
                        if(tabObjects[1].SelectedIndex==0){                 //Route Projection - Volume
                           sheetObjects[2].Down2Excel(-1, true, false, true);
                        }else if(tabObjects[1].SelectedIndex==1){           //Route Projection - G.RPB
                            sheetObjects[3].Down2Excel(-1, true, false, true);
                        }
                        break;
   					case "AN":
                        sheetObjects[1].SpeedDown2Excel(0, false, false);
                        if(tabObjects[1].SelectedIndex==0){                 //Route Projection - Volume
                           sheetObjects[2].SpeedDown2Excel(0, false, false);
                        }else if(tabObjects[1].SelectedIndex==1){           //Route Projection - G.RPB
                            sheetObjects[3].SpeedDown2Excel(0, false, false);
                        }
                        break;
					case "DN":
                        sheetObjects[1].SpeedDown2Excel(-1, false, false);
                        if(tabObjects[1].SelectedIndex==0){                 //Route Projection - Volume
                           sheetObjects[2].SpeedDown2Excel(-1, false, false);
                        }else if(tabObjects[1].SelectedIndex==1){           //Route Projection - G.RPB
                            sheetObjects[3].SpeedDown2Excel(-1, false, false);
                        }
                        break;
                }
//
//
//                sheetObjects[1].Down2Excel(-1, false, false, true);
//                if(tabObjects[1].SelectedIndex==0){                 //Route Projection - Volume
//                   sheetObjects[2].Down2Excel(-1, true, false, true);
//                }else if(tabObjects[1].SelectedIndex==1){           //Route Projection - G.RPB
//                    sheetObjects[3].Down2Excel(-1, true, false, true);
//                }
                break;
        }
    }
    /**
     *
     */
    function sheet2_OnSaveEnd(sheetObj,ErrMsg){
        var formObj = document.form;
        var sheetObj4 = sheetObjects[3];

        doActionIBSheet4(sheetObj4,formObj,IBSEARCH);

    }
    /**
     *
     */
    function sheet2_OnSearchEnd(sheetObj,ErrMsg){
        var formObj = document.form;

        sheetObj.SumText(0,0) = " ";
        sheetObj.SumText(0,3) = "TOTAL" ;

        sheetObj.SumText(0,"ldf_rto") = (parseFloat(sheetObj.SumValue(0,"lod_ttl_qty"))/parseFloat(sheetObj.SumValue(0,"bsa_capa"))*100).toFixed(2);
        sheetObj.SumText(0,"grs_rpb_rev") =(parseFloat(sheetObj.SumValue(0,"grs_ttl_rev"))/parseFloat(sheetObj.SumValue(0,"lod_ttl_qty"))).toFixed(2);
    }
    /**
     *
     */
    function sheet2_OnDblClick(sheetObj , row, col){
        var sheetObj3 = sheetObjects[2];
        var sheetObj4 = sheetObjects[3];
        var frmObj = document.form;
        if(sheetObj.CellValue(sheetObj.SelectRow, "port_dys")!="" && sheetObj.CellValue(sheetObj.SelectRow, "port_dys")!="0"){
            p_sect_no = sheetObj.CellValue(row, "sect_no");
            frmObj.f_sect_no.value = p_sect_no;
            v_lod_ttl_qty = sheetObj.CellValue(row, "lod_ttl_qty");
        		if(tabObjects[1].SelectedIndex==0){                     // Volume
                frmObj.rdoCode[0].checked = true;
                displayType("0");
          			doActionIBSheet3(sheetObj3,frmObj,IBSEARCH);
        		}else if(tabObjects[1].SelectedIndex==1){               // G.RPB
                doActionIBSheet4(sheetObj4,frmObj,IBSEARCH);
        		}

        }else{
            // [COM12114] >> Proforma SKD를(을) 확인하세요.
            ComShowMessage(ComGetMsg("COM12114", "Proforma SKD"));
            sheetObj3.RemoveAll();
        }
    }

//Step2 :Tab2 : Route Projection - Route Projection - Volume------------------------------------
    /**
     * Tab2 : Route Projection - Volume
     * Sheet관련 프로세스 처리
     */
    function doActionIBSheet3(sheetObj, formObj, sAction){
        sheetObj.ShowDebugMsg = false;
        var slan_cd = "";
        var sim_dt  = "";
        var sim_no  = "";
//        var sect_no = "";
        var totSum  = 0;
//        var loadCnt = 0;
        var sheetObj2 = sheetObjects[1];

        slan_cd = sheetObj2.CellValue(sheetObj2.SelectRow, "slan_cd");
        sim_dt  = sheetObj2.CellValue(sheetObj2.SelectRow, "sim_dt");
        sim_no  = sheetObj2.CellValue(sheetObj2.SelectRow, "sim_no");
//        sect_no = sheetObj2.CellValue(sheetObj2.SelectRow, "sect_no");

        switch(sAction) {
            case IBSEARCH:      //조회
                formObj.f_cmd.value = SEARCHLIST05;
                if(!validateForm(sheetObj,formObj,sAction))return false;
                // 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
                formObj.f_sect_no.value = p_sect_no;
                var sXml = sheetObj.GetSearchXml("ESM_COA_0052GS3.do", coaFormQueryString(formObj)+"&sect_no="+p_sect_no);

                // GetSearchXml을 사용하여 가지고 온 xml로 부터
                // ETC-DATA의 특정정보(Header)를 조회한다.
                //------------------------------------------
                formObj.f_header.value = searchEtcData("header", sXml);
                var header = formObj.f_header.value;

                if(header != ""){
                    // header 정보 초기화
                    //-------------------------
                    sheetObj.Redraw = false;
                    sheetObj.RemoveAll();
                    sheetObj.Reset();
                    initSheet(sheetObj, 3, header);
                    sheetObj.Redraw = true;
                    // data를 로딩한다.
                    //-------------------------
                    sheetObj.LoadSearchXml(sXml);
                    // Form Data setting
                    //-------------------------
                    ComEtcDataToForm(formObj, sheetObj);             // ETC데이터를 form변수에 세팅한다.
                    sheetObj.RemoveEtcData();                          // ETC 데이타 삭제
                    //-------------------------
                }
                ComOpenWait(false);
                break;

            case IBSAVE:        // 저장
                formObj.f_cmd.value = MULTI03;
                if(!validateForm(sheetObj,formObj,sAction))return false;
//                loadCnt = sheetObj2.CellValue(sheetObj2.SelectRow, "lod_ttl_qty");
                totSum = sheetObj.SumValue(0, "tot");
                formObj.f_totsum.value = totSum;
                formObj.f_lod_ttl_qty.value = v_lod_ttl_qty;
                formObj.f_sect_no.value= p_sect_no;
                for(i=1;i<sheetObj.LastRow;i++) {
                	sheetObj.CellValue2(i,"sim_dt")=formObj.f_sim_dt.value;
                	sheetObj.CellValue2(i,"sim_no")=formObj.f_sim_no.value;
                }

                // 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
                sheetObj.DoAllSave("ESM_COA_0052GS3.do?totSum="+totSum+"&lod_ttl_qty="+v_lod_ttl_qty+"&sect_no="+p_sect_no, coaFormQueryString(formObj));
                ComOpenWait(false);

                var Result = sheetObj.EtcData("result");
                sheetObj.RemoveEtcData();

                if (Result=="OK"){
                      doActionIBSheet2(sheetObj2,formObj,IBSEARCH);
                }

                break;

            case IBCREATE:        //creation
                formObj.f_cmd.value = MULTI07;
                if(!validateForm(sheetObj,formObj,sAction))return false;
//                if(formObj.f_trd_cd.value == ""){
//                    ComShowMessage(ComGetMsg("COM12114","Trade"));
//                    formObj.f_trd_cd.focus();
//                    return false;
//                }
                if(formObj.f_prd_cd.value == ""){
                    ComShowMessage(ComGetMsg("COM12114","Source Period"));
                    formObj.f_prd_cd.focus();
                    return false;
                }
                sheetObjects[2].RemoveAll();
                sheetObjects[3].RemoveAll();
                // 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
                sheetObj.DoRowSearch("ESM_COA_0052GS3.do", coaFormQueryString(formObj));
                ComOpenWait(false);

                var Result = sheetObj.EtcData("result");
                sheetObj.RemoveEtcData();
                if (Result=="OK"){
                      ComShowMessage(ComGetMsg("COA10006"));
                      doActionIBSheet2(sheetObj2,formObj,IBSEARCH);
                }
                break;

            case IBCOPYROW:        // 인터페이스  : Port정보를 넘겨준다.
                formObj.f_cmd.value = COMMAND02;
                if(!validateForm(sheetObj,formObj,sAction)) return false;
                // 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
                sheetObj.DoRowSearch("ESM_COA_0052GS.do", coaFormQueryString(formObj));
                ComOpenWait(false);
                var Result = sheetObj.EtcData("result");
                sheetObj.RemoveEtcData();
                if (Result=="OK"){
                      ComShowMessage(ComGetMsg("COA10006"));
                }
                break;

            case IBINSERT:        // 인터페이스  : Port days를 받는다.
                formObj.f_cmd.value = COMMAND03;
                if(!validateForm(sheetObj,formObj,sAction)) return false;
                // 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
                sheetObj.DoRowSearch("ESM_COA_0052GS.do", coaFormQueryString(formObj));
                ComOpenWait(false);
                var Result = sheetObj.EtcData("result");
                sheetObj.RemoveEtcData();
                if (Result=="OK"){
                      ComShowMessage(ComGetMsg("COA10006"));
                }
                break;

        }
    }
    /**
     *
     */
    function sheet3_OnSearchEnd(sheetObj,ErrMsg){
        var formObj = document.form;
        var sheetObj2 = sheetObjects[1];

        sheetObj.SumText(0,0) = "";
        sheetObj.SumText(0,1) = "TOTAL" ;
    }

//Step2 :Tab2 : Route Projection - Route Projection - G.RPB------------------------------------

    /**
     * Tab2 : Route Projection - G.RPB
     * Sheet관련 프로세스 처리
     */
    function doActionIBSheet4(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        var slan_cd = "";
        var sim_dt  = "";
        var sim_no  = "";
//        var sect_no = "";
        var sheetObj2 = sheetObjects[1];

        slan_cd = sheetObj2.CellValue(sheetObj2.SelectRow, "slan_cd");
        sim_dt  = sheetObj2.CellValue(sheetObj2.SelectRow, "sim_dt");
        sim_no  = sheetObj2.CellValue(sheetObj2.SelectRow, "sim_no");
//        sect_no = sheetObj2.CellValue(sheetObj2.SelectRow, "sect_no");

        switch(sAction) {
            case IBSEARCH:          //조회
                formObj.f_cmd.value = SEARCHLIST06;
                if(!validateForm(sheetObj,formObj,sAction))return false;
                // 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
                var sXml = sheetObj.GetSearchXml("ESM_COA_0052GS4.do", coaFormQueryString(formObj)+"&sect_no="+p_sect_no);

                // GetSearchXml을 사용하여 가지고 온 xml로 부터
                // ETC-DATA의 특정정보(Header)를 조회한다.
                //------------------------------------------
                formObj.f_header.value = searchEtcData("header", sXml);
                var header = formObj.f_header.value;
                if(header != ""){
                    // header 정보 초기화
                    //-------------------------
                    sheetObj.Redraw = false;
                    sheetObj.RemoveAll();
                    sheetObj.Reset();
                    initSheet(sheetObj, 4, header);
                    sheetObj.Redraw = true;
                    // data를 로딩한다.
                    //-------------------------
                    sheetObj.LoadSearchXml(sXml);
                    // Form Data setting
                    //-------------------------
//                    ComEtcDataToForm(formObj, sheetObj);             // ETC데이터를 form변수에 세팅한다.
                    sheetObj.RemoveEtcData();                          // ETC 데이타 삭제
                    //-------------------------
                }
                ComOpenWait(false);
                break;

            case IBSAVE:            //저장
                formObj.f_cmd.value = MULTI04;
                if(!validateForm(sheetObj,formObj,sAction)) return false;
                // 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
                sheetObj.DoSave("ESM_COA_0052GS4.do", coaFormQueryString(formObj)+"&sect_no="+p_sect_no);
                ComOpenWait(false);
                var Result = sheetObj.EtcData("result");
                sheetObj.RemoveEtcData();
                if (Result=="OK"){
                    doActionIBSheet2(sheetObj2,formObj,IBSEARCH);
                }
                break;

        }
    }

    /**
     *
     */
    function sheet4_OnSearchEnd(sheetObj, ErrMsg){
        var formObj = document.form;

//        sheetObj.SumText(0, "ibflag") = "";
//        sheetObj.SumText(0, "tml_cd") = "Total";
    }

// Step2 :Tab3 :  TMNL Transit Time ------------------------------------------------------------
    /**
     * Tab3 : TMNL Transit Time
     * Sheet관련 프로세스 처리
     */
    function doActionIBSheet5(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {
            case IBSEARCH:          //조회
                formObj.f_cmd.value = SEARCHLIST07;
                if(!validateForm(sheetObj,formObj,sAction)) return false;
                // 업무처리중 버튼사용 금지 처리
                sheetObj.WaitImageVisible = false;
                ComOpenWait(true);
                sheetObj.DoSearch4Post("ESM_COA_0052GS5.do", coaFormQueryString(formObj));
                ComOpenWait(false);
                break;

            case IBSAVE:            //저장
                formObj.f_cmd.value = MULTI05;
                if(!validateForm(sheetObj,formObj,sAction)) return false;
                // 업무처리중 버튼사용 금지 처리
                sheetObj.WaitImageVisible = false;
                ComOpenWait(true);
                sheetObj.DoSave("ESM_COA_0052GS5.do", coaFormQueryString(formObj));
                ComOpenWait(false);
                break;

            case IBCREATE:           // 운항일수 생성
                formObj.f_cmd.value = MULTI08;
                if(!validateForm(sheetObj,formObj,sAction)) return false;
                // 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
                sheetObj.DoSearch4Post("ESM_COA_0052GS5.do", coaFormQueryString(formObj));
                ComOpenWait(false);
                var Result = sheetObj.EtcData("result");
                sheetObj.RemoveEtcData();
                if(Result=="OK"){
                      ComShowMessage(ComGetMsg("COA10006"));
                      doActionIBSheet5(sheetObj,formObj,IBSEARCH);
                }
                break;

            case IBDOWNEXCEL:        //엑셀 다운로드
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

        }
    }

	/**
     *
     */
    function sheet5_OnSearchEnd(sheetOjb, ErrMsg){
        var formObj = document.form;

        sheetObj.SumText(0, "ibflag") = "";
        sheetObj.SumText(0, "tml_cd") = "Total";
    }



    /**
     * Service Lane변경시 해당 Simulation No를 조회한다.
     */
    function chgSLane(obj){
    	 var formObj = document.form;
      	 var sheetObj = sheetObjects[0];

      	if (ComGetObjValue(obj) != "") {
         	var simNo = ComGetObjValue(formObj.f_sim);
 	 		formObj.f_cmd.value = SEARCHLIST10;
 	 		var sXml = sheetObj.GetSearchXml("ESM_COA_0052GS5.do", coaFormQueryString(formObj));
 	 		var arrXml = sXml.split("|$$|");

 	 		if (arrXml.length > 0)
 	 			ComXml2ComboItem(arrXml[0], formObj.f_sim, "code", "name");

 	 		ComSetObjValue(formObj.f_sim,simNo);
 	 		if (ComTrim(simNo) != ""){
 	 			setSimNo(formObj.f_sim);
 	 		}
         }
    }

    /**
     * SLane 데이터 변경시 Simulation Number combo box를 다시 세팅한다.
     */
    function f_slan_cd_OnChange(cboObj, value, text){
    	if (loadingMode == true) return;
     	if(ComTrim(value) != "" ) { // S.Lane
     		chgSLane(cboObj);
     	}
    }
     function f_sim_OnChange(cboObj, value, text){
     	if (loadingMode == true) return;
     	setSimNo(cboObj);
     }
     function f_dept_cd2_OnChange(cboObj, value, text){
     	if (loadingMode == true) return;
     	chgSLane(cboObj);
     }


	/**
	 * Simulation No Combo box에서 데이터 선택시 아래의 input box에 데이터를 입력한다.
	 */
	function setSimNo(Obj) {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		if (ComGetObjValue(Obj) != "") {
			var param = "f_cmd=" + SEARCH01;
			param = param + "&f_sim=" + ComGetObjValue(Obj);
			param = param + "&f_slan_cd=" + ComGetObjValue(formObj.f_slan_cd);

			var sXml = sheetObj.GetSearchXml("CommonUtilGS.do", param);
			var arrXml = sXml.split("|$$|");
			if (0 < arrXml.length && ComGetEtcData(arrXml[0], "sim_dt") != undefined) {
				ComSetObjValue(formObj.f_sim_dt, ComGetEtcData(arrXml[0], "sim_dt"));
				ComSetObjValue(formObj.f_sim_no, ComGetEtcData(arrXml[0], "sim_no"));
				ComSetObjValue(formObj.f_sim_rmk, ComGetEtcData(arrXml[0], "sim_rmk"));
				ComSetObjValue(formObj.f_usr_id, ComGetEtcData(arrXml[0], "sim_usr_id"));
				ComSetObjValue(formObj.f_dept_cd, ComGetEtcData(arrXml[0], "sim_dept_cd"));
				ComAddSeparator(formObj.f_sim_dt);
			}
		}
	}

    function setCalcuration() {
        var sheetObj = sheetObjects[0];
        var formObj = document.form;
        doActionIBSheet(sheetObj,formObj,IBSEARCHAPPEND);
    }

    /**
     * Yard Code를 전반적으로 다시 세팅한다.
     */
    function setYardInfo(){
        var sheetObj = sheetObjects[0];
        var formObj = document.form;
        var i;

        for(i=1; i<= sheetObj.LastRow; i++){
            if(sheetObj.CellValue(i,"port_cd").length == 5){
                sheetObj.SelectCell(i,"port_cd");

                doActionIBSheet(sheetObj,formObj,IBROWSEARCH);
            }
        }
    }

     /**
      * trade코드 변경시 rLane 리스트를 리플래쉬 한다.
      */
     function f_trd_cd_OnChange(obj) {
     	if (loadingMode == true) return;
     	var formObj = document.form;
         var sheetObj = sheetObjects[0];
         if(obj.Text != ""){
         	formObj.f_cmd.value = SEARCHLIST11;
 			var sXml = sheetObj.GetSearchXml("ESM_COA_0052GS5.do", coaFormQueryString(formObj));

 			var arrXml = sXml.split("|$$|");
 			if (arrXml.length > 0)
 				ComXml2ComboItem(arrXml[0], formObj.f_rlane_cd, "code", "code");
 			formObj.f_rlane_cd.Index = 0;

         }
     }

    /**
     * Sheet3에서 View 정보에 따라서 계산을 진행한다.
     * cheak box 클릭시 처리
     */
    function displayType(param1){
        var rowNo = 0;
        var formObj = document.form;
        var sheetObj3  = sheetObjects[2];
        var sheetObj2 = sheetObjects[1];
        var colCnt = 0;        // 총 컬럼수
        var cnt = 0;
        var k = 2;

        colCnt = sheetObj3.LastCol+1;
        cnt = (colCnt -2)/3;
        if(param1 == 0){//단가
            btn_create.style.display = "";
            btn_save3.style.display = "";
            btn_create_right.style.display = "";
            btn_create_left.style.display = "";
            btn_save3_right.style.display = "";
            btn_save3_left.style.display = "";
            sheetObj3.Editable = true;
            for(i=2; i<colCnt; i++){
                if(i<cnt+2){
                    sheetObj3.ColHidden(i) = false;
                }else{
                    sheetObj3.ColHidden(i) = true;
                }
            }

        }else if(param1 == 1){//퍼센트
            btn_create.style.display = "none";
            btn_save3.style.display = "none";
            btn_create_right.style.display = "none";
            btn_create_left.style.display = "none";
            btn_save3_right.style.display = "none";
            btn_save3_left.style.display = "none";
            sheetObj3.Editable = false;

            k=2;
            for(i=2; i<colCnt; i++){ // column
                if(cnt+2<=i && i<(cnt*2)+2){
                    sheetObj3.ColHidden(i) = false;

                    for(j=1; j<sheetObj3.LastRow; j++){ // Row

                        var status = sheetObj3.CellValue(j,"ibflag") ;
                        if(parseFloat(sheetObj3.SumValue(0, "tot"))>0){
                            sheetObj3.CellValue2(j, i) = ((parseFloat(sheetObj3.CellValue(j, k))/parseFloat(sheetObj3.SumValue(0, "tot")))*100).toFixed(6);
                        }
                        // 마지막 Total 값을 계산한다.
                        if(i==(cnt*2)+1 && j == sheetObj3.LastRow-1 && parseFloat(sheetObj3.SumValue(0, "tot"))>0) {
                            sheetObj3.SumValue(0, i) = ((parseFloat(sheetObj3.SumValue(0, "tot"))/parseFloat(sheetObj3.SumValue(0, "tot")))*100).toFixed(6);
                        }

                        if(status == "R") sheetObj3.CellValue2(j,"ibflag") = "R";
                    }
                    k++;
                }else{
                    sheetObj3.ColHidden(i) = true;
                }
            }

        }else if(param1 ==2){//퍼센트 * 로드
            btn_create.style.display = "none";
            btn_save3.style.display = "none";
            btn_create_right.style.display = "none";
            btn_create_left.style.display = "none";
            btn_save3_right.style.display = "none";
            btn_save3_left.style.display = "none";

            sheetObj3.Editable = false;

            k=2;
            for(i=2; i<colCnt; i++){
                if(i>=(cnt*2)+2){
                    sheetObj3.ColHidden(i) = false;
                    for(j=1; j<sheetObj3.LastRow; j++){
                        var status = sheetObj3.CellValue(j,"ibflag") ;
                        if(parseFloat(sheetObj3.SumValue(0, "tot"))>0){
                            sheetObj3.CellValue2(j, i) = (parseFloat(sheetObj3.CellValue(j, k))/parseFloat(sheetObj3.SumValue(0, "tot")))*parseFloat(v_lod_ttl_qty);
                        } else {
                             sheetObj3.CellValue2(j, i) = 0;
                        }
                        // 마지막 Total 값을 계산한다.
                        if(i==(colCnt-1) && j == sheetObj3.LastRow-1 && parseFloat(sheetObj3.SumValue(0, "tot"))>0) {
                            sheetObj3.SumValue(0, i) = (parseFloat(sheetObj3.SumValue(0, "tot"))/parseFloat(sheetObj3.SumValue(0, "tot")))*parseFloat(v_lod_ttl_qty);
                        }else{
                            sheetObj3.SumValue(0, i) = "0";
                        }
                        if(status == "R") sheetObj3.CellValue2(j,"ibflag") = "R";
                    }
                    k++;
                }else{
                    sheetObj3.ColHidden(i) = true;
                }
            }
        }
    }

    /**
     * 상태표시를 제거한다.
     */
    function closeStatus(){
//        zu_openRunning(false);
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
                    InsertTab( cnt++, "   Port TMNL Setting   " , -1 );
                    InsertTab( cnt++, "   Route Projection   " , -1 );
                    InsertTab( cnt++, "   TMNL Transit Time   " , -1 );
                }
             break;
             case 2:
                with (tabObj) {
                    var cnt  = 0 ;
                    InsertTab( cnt++, "   Volume   " , -1 );
                    InsertTab( cnt++, "   RPB   " , -1 );
                }
             break;
        }
    }

	/**
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	 */
		function tab1_OnChange(tabObj , nItem){
			var objs = document.all.item("tabLayer");
			var formObj = document.form;

			objs[nItem].style.display = "inline";
			objs[beforetab1].style.display = "none";
			//--------------- 요기가 중요 --------------------------//
      var pre_idx =  objs[nItem].style.zIndex;
      pre_idx--;
			objs[beforetab1].style.zIndex = pre_idx ;
			//------------------------------------------------------//

			beforetab1= nItem;
      if(nItem == 0){
        if(formObj.f_ext_flg.value == "Y"){
           td_getPT.style.display = "block";
        }else{
           td_getPT.style.display = "none";
        }
      }else if(nItem == 1){
	      if(formObj.f_ext_flg.value == "Y"){
	        //td_sd.style.display = "none";
	        //td_pt.style.display = "none";
	      }else{
	        //td_sd.style.display = "block";
	        //td_pt.style.display = "block";
	      }
	    }
		}


		/**
		 * Tab 클릭시 이벤트 관련
		 * 선택한 탭의 요소가 활성화 된다.
		 */
		function tab2_OnChange(tabObj , nItem){
			var objs = document.all.item("tabLayer2");
			var formObj = document.form;

			objs[nItem].style.display = "Inline";
			objs[beforetab2].style.display = "none";

			//--------------- 요기가 중요 --------------------------//
			objs[beforetab2].style.zIndex = objs[nItem].style.zIndex -1 ;
			//------------------------------------------------------//
			beforetab2= nItem;

		}


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
			if (f_slan_cd.Text == "") {
			    ComShowMessage(ComGetMsg("COA10002","S.Lane"));
			    f_slan_cd.focus();
			    return false;
			}
			if(f_sim_dt.value == "") {
			    ComShowMessage(ComGetMsg("COA10002","Simulation Date"));
			    f_sim_dt.focus();
			    return false;
			}
			if(f_sim_no.value == "") {
			    ComShowMessage(ComGetMsg("COA10002","Simulation Number"));
			    f_sim_no.focus();
			    return false;
			}
        }
        return true;
    }

    /**
     * Step 단계별로 화면 이동
     */
    function doActionPageMove(sheetObj, formObj, btnName){
        formObj.f_cmd.value = "";
        formObj.method = "POST";
        formObj.target = "";


        // MultCombo 일경우 submit()으로 넘기면 데이터를 정상적으로 넘길수 었기 때문에 아래와 같이 GET 방식으로 데이터를 넘긴다
        if (btnName == "step01"){
            formObj.action = "ESM_COA_0051.do?f_slan_cd="+formObj.f_slan_cd.Code+"&pgmNo=ESM_COA_0051";
            formObj.submit();
        }else if(btnName == "step02"){
            formObj.action = "ESM_COA_0052.do?f_slan_cd="+formObj.f_slan_cd.Code+"&pgmNo=ESM_COA_0051";
            formObj.submit();
        }else if(btnName == "step03"){
            formObj.action = "ESM_COA_0053.do?f_slan_cd="+formObj.f_slan_cd.Code+"&pgmNo=ESM_COA_0051";
            formObj.submit();
        }else if(btnName == "step04"){
            formObj.action = "ESM_COA_0054.do?f_slan_cd="+formObj.f_slan_cd.Code+"&pgmNo=ESM_COA_0051";
            formObj.submit();
        }
    }

    /**
     * Row_SEQ 순차적으로 다시 생성
     * @param sheetObj
     * @return
     */

    function resetRowSeq(sheetObj){
    	var headCnt = sheetObj.HeaderRows;
    	var rowCnt = sheetObj.RowCount;
    	var prefix = "";
    	var idx = 0;
    	var vIbFlag = "";

    	for(var i=0; i<rowCnt; i++){
    		//if(sheetObj.CellValue(i+headCnt, prefix+"ibflag") != "D"){
    		if(sheetObj.RowStatus(i+headCnt) != "D"){
    			//vIbFlag = sheetObj.CellValue(i+headCnt, prefix+"ibflag");
    			vIbFlag = sheetObj.RowStatus(i+headCnt);
    			idx++;
    			sheetObj.CellValue2(i+headCnt, prefix+"row_seq") = idx;
    			//sheetObj.CellValue2(i+headCnt, prefix+"ibflag") = vIbFlag;
    			sheetObj.RowStatus(i+headCnt) = vIbFlag;
    		}
    	}
    }
    /**
     * Delete된 Row를 제외한 마지막 로우를 찾늗다
     * @param sheetObj
     * @return
     */

    function searchLastRow(sheetObj){
    	var headCnt = sheetObj.HeaderRows;
    	var rowCnt = sheetObj.RowCount;
    	var totalCnt = headCnt+rowCnt;
    	var idx = 0;



    	for(var i=totalCnt-1; i>headCnt-1; i--){

    		if(sheetObj.CellValue(i, 0) != "D"){

    			idx = i;

    			break;
    		}
    	}
    	return idx+1;
    }


    /**
     * 첫번재 로우의 Manu In은 항상 가려져야 한다
     * 만약 첫번째 로우를 Delete하면 하위 로우중 Delete Flag가 아닌 로우의 Manu In을 가져준다
     * @param sheetObj
     * @return
     */
    function searchFirstRow(sheetObj){
    	var headCnt = sheetObj.HeaderRows;
    	var rowCnt = sheetObj.RowCount;
    	var totalCnt = headCnt+rowCnt;
    	var idx = 0;
    	var rtnIdx = 0;
    	var prefix = "";
    	var grayColor = sheetObj.RgbColor(eval("239"),eval("235"),eval("239"));

    	for(var i=headCnt; i<totalCnt; i++){
    		if(sheetObj.CellValue(i, 0) != "D"){
    			idx = i;
    			break;
    		}
    	}

    	sheetObj.CellEditable(idx, "etb_dy_no") = true;
    	sheetObj.CellEditable(idx, "etb_dy_cd") = true;
    	sheetObj.CellEditable(idx, "etb_tm_hrmnt") = true;

    	sheetObj.CellEditable(idx, prefix+"mnvr_in_hrs") = false;
    	sheetObj.CellFontColor(idx,prefix+"mnvr_in_hrs") = grayColor;

    }

    /**
     * 날짜 비교후(l - f) 일단 위로 환산해서 return 한다.
     * 소수점 한자리 자름 (반올림X)
     * @param f_day,f_hour,l_day,l_hour
     * @return float
     */
    function diff_date(f_day,f_hour,l_day,l_hour) {
       var from_dt = new Date('0000', '00', f_day, f_hour.substring(0,2),f_hour.substring(2));
       var to_dt   = new Date('0000', '00', l_day, l_hour.substring(0,2),l_hour.substring(2));
       return(parseInt(((to_dt.getTime() - from_dt.getTime()) / 1000 / 60 / 60 / 24)*10)/10);
    }
//  function diff_date(sheetObj) {
//     var f_day = sheetObj.CellValue("3","etb_dy_no");
//     var f_hour = sheetObj.CellValue("3","etb_tm_hrmnt");
//     var l_day = sheetObj.CellValue(searchLastRow(sheetObj)-1,"etb_dy_no");
//     var l_hour = sheetObj.CellValue(searchLastRow(sheetObj)-1,"etb_tm_hrmnt");
//     var from_dt = new Date('0000', '00', f_day, f_hour.substring(0,2),f_hour.substring(2));
//     var to_dt   = new Date('0000', '00', l_day, l_hour.substring(0,2),l_hour.substring(2));
//     return(parseInt(((to_dt.getTime() - from_dt.getTime()) / 1000 / 60 / 60 / 24)*10)/10);
//  }'
    /**
     * grid 출력 후 last 로우 Color 셋팅
     * @param sheetObj
     * @param formObj
     * @return
     */
    function setlastLowView(sheetObj,rowPos){
    	var rdInx = rowPos - 1;
    	var prefix = "";
    	var rtnRowCnt = getRowCount(sheetObj);
    	if(rtnRowCnt > 0){
    		//회색
    		var grayColor = sheetObj.RgbColor(eval("239"),eval("235"),eval("239"));
    		//흰색
    		var withrColor = sheetObj.RgbColor(eval("255"),eval("255"),eval("255"));
    		sheetObj.CellEditable(rdInx, prefix+"lnk_dist") = false;
    		sheetObj.CellEditable(rdInx, prefix+"lnk_spd") = false;
    		sheetObj.CellEditable(rdInx, prefix+"tztm_hrs") = false;
    		sheetObj.CellEditable(rdInx, prefix+"sea_buf_hrs") = false;
    		sheetObj.CellEditable(rdInx, prefix+"sea_buf_spd") = false;
    		//sheetObj.CellEditable(rdInx, prefix+"mnvr_in_hrs") = true;
    		sheetObj.CellEditable(rdInx, prefix+"mnvr_out_hrs") = false;
    		sheetObj.CellEditable(rdInx, prefix+"act_wrk_hrs") = false;
    		sheetObj.CellEditable(rdInx, prefix+"port_buf_hrs") = false;
    		sheetObj.CellEditable(rdInx, prefix+"ib_ipcgo_qty") = false;
    		sheetObj.CellEditable(rdInx, prefix+"ob_ipcgo_qty") = false;
    		sheetObj.CellEditable(rdInx, prefix+"ib_ocn_cgo_qty") = false;
    		sheetObj.CellEditable(rdInx, prefix+"ob_ocn_cgo_qty") = false;
    		sheetObj.CellEditable(rdInx, prefix+"tml_prod_qty") = false;
    		sheetObj.CellEditable(rdInx, prefix+"crn_knt") = false;
    		sheetObj.CellEditable(3,"mnvr_in_hrs") = false;
    		//sheetObj.CellEditable(rdInx, prefix+"turn_port_flg") = false;

    		sheetObj.CellFontColor(rdInx,prefix+"etd_dy_no") = grayColor;
    		sheetObj.CellFontColor(rdInx,prefix+"etd_dy_cd") = grayColor;
    		sheetObj.CellFontColor(rdInx,prefix+"etd_tm_hrmnt") = grayColor;
    		sheetObj.CellFontColor(rdInx,prefix+"lnk_dist") = grayColor;
    		sheetObj.CellFontColor(rdInx,prefix+"lnk_spd") = grayColor;
    		sheetObj.CellFontColor(rdInx,prefix+"tztm_hrs") = grayColor;
    		sheetObj.CellFontColor(rdInx,prefix+"sea_buf_hrs") = grayColor;
    		sheetObj.CellFontColor(rdInx,prefix+"sea_buf_spd") = grayColor;
    		sheetObj.CellFontColor(rdInx,prefix+"mnvr_out_hrs") = grayColor;
    		sheetObj.CellFontColor(rdInx,prefix+"act_wrk_hrs") = grayColor;
    		sheetObj.CellFontColor(rdInx,prefix+"port_buf_hrs") = grayColor;
    		sheetObj.CellFontColor(rdInx,prefix+"ib_ipcgo_qty") = grayColor;
    		sheetObj.CellFontColor(rdInx,prefix+"ob_ipcgo_qty") = grayColor;
    		sheetObj.CellFontColor(rdInx,prefix+"ib_ocn_cgo_qty") = grayColor;
    		sheetObj.CellFontColor(rdInx,prefix+"ob_ocn_cgo_qty") = grayColor;
    		sheetObj.CellFontColor(rdInx,prefix+"tml_prod_qty") = grayColor;
    		sheetObj.CellFontColor(rdInx,prefix+"crn_knt") = grayColor;
    		//sheetObj.CellFontColor(rdInx,prefix+"turn_port_flg") = grayColor;
    		sheetObj.CellBackColor(rdInx,prefix+"mnvr_in_hrs") = withrColor;
    		sheetObj.CellBackColor(3,"mnvr_in_hrs") = grayColor;
   			sheetObj.CellFontColor(3,"mnvr_in_hrs") = grayColor;
    	}
    }

    /**
     * grid 출력 후 last 로우 Color 셋팅
     * @param sheetObj
     * @param formObj
     * @return
     */
    function setlastLowViewUndo(sheetObj,rowPos){
    	var rdInx = rowPos - 1;
    	var prefix = "";
    	var rtnRowCnt = getRowCount(sheetObj);

    	if(rtnRowCnt > 0){
    		//회색
    		var grayColor = sheetObj.RgbColor(eval("239"),eval("235"),eval("239"));
    		//흰색
    		var withrColor = sheetObj.RgbColor(eval("255"),eval("255"),eval("255"));
    		//검은색
    		var blackColor = sheetObj.RgbColor(eval("0"),eval("0"),eval("0"));

    		sheetObj.CellEditable(rdInx, prefix+"lnk_dist") = true;
    		sheetObj.CellEditable(rdInx, prefix+"lnk_spd") = true;
    		sheetObj.CellEditable(rdInx, prefix+"tztm_hrs") = false;
    		sheetObj.CellEditable(rdInx, prefix+"sea_buf_hrs") = true;
    		sheetObj.CellEditable(rdInx, prefix+"sea_buf_spd") = false;
    		sheetObj.CellEditable(rdInx, prefix+"mnvr_in_hrs") = true;
    		sheetObj.CellEditable(rdInx, prefix+"mnvr_out_hrs") = true;
    		sheetObj.CellEditable(rdInx, prefix+"act_wrk_hrs") = true;
    		sheetObj.CellEditable(rdInx, prefix+"port_buf_hrs") = true;
    		sheetObj.CellEditable(rdInx, prefix+"ib_ipcgo_qty") = true;
    		sheetObj.CellEditable(rdInx, prefix+"ob_ipcgo_qty") = true;
    		sheetObj.CellEditable(rdInx, prefix+"ib_ocn_cgo_qty") = true;
    		sheetObj.CellEditable(rdInx, prefix+"ob_ocn_cgo_qty") = true;
    		sheetObj.CellEditable(rdInx, prefix+"tml_prod_qty") = false;
    		sheetObj.CellEditable(rdInx, prefix+"crn_knt") = false;
    		sheetObj.CellEditable(rdInx, prefix+"turn_port_flg") = true;

    		sheetObj.CellFontColor(rdInx,prefix+"etd_dy_no") = blackColor;
    		sheetObj.CellFontColor(rdInx,prefix+"etd_dy_cd") = blackColor;
    		sheetObj.CellFontColor(rdInx,prefix+"etd_tm_hrmnt") = blackColor;
    		sheetObj.CellFontColor(rdInx,prefix+"lnk_dist") = blackColor;
    		sheetObj.CellFontColor(rdInx,prefix+"lnk_spd") = blackColor;
    		sheetObj.CellFontColor(rdInx,prefix+"tztm_hrs") = blackColor;
    		sheetObj.CellFontColor(rdInx,prefix+"sea_buf_hrs") = blackColor;
    		sheetObj.CellFontColor(rdInx,prefix+"sea_buf_spd") = blackColor;
    		sheetObj.CellFontColor(rdInx,prefix+"mnvr_in_hrs") = blackColor;
    		sheetObj.CellFontColor(rdInx,prefix+"mnvr_out_hrs") = blackColor;
    		sheetObj.CellFontColor(rdInx,prefix+"act_wrk_hrs") = blackColor;
    		sheetObj.CellFontColor(rdInx,prefix+"port_buf_hrs") = blackColor;
    		sheetObj.CellFontColor(rdInx,prefix+"ib_ipcgo_qty") = blackColor;
    		sheetObj.CellFontColor(rdInx,prefix+"ob_ipcgo_qty") = blackColor;
    		sheetObj.CellFontColor(rdInx,prefix+"ib_ocn_cgo_qty") = blackColor;
    		sheetObj.CellFontColor(rdInx,prefix+"ob_ocn_cgo_qty") = blackColor;
    		sheetObj.CellFontColor(rdInx,prefix+"tml_prod_qty") = blackColor;
    		sheetObj.CellFontColor(rdInx,prefix+"crn_knt") = blackColor;
    		sheetObj.CellFontColor(rdInx,prefix+"turn_port_flg") = blackColor;
    		//sheetObjects[1].CellBackColor(rdInx,prefix+"mnvr_in_hrs") = withrColor;

    	}
    }

    function getRowCount(sheetObj){
    	var headCnt = sheetObj.HeaderRows;
    	var rowCnt = sheetObj.RowCount;
    	var totalCnt = headCnt+rowCnt;
    	var idx = 0;
    	var rtnIdx = 0;
    	for(var i=headCnt; i<totalCnt; i++){
    		if(sheetObj.CellValue(i, 0) != "D"){
    			idx++;
    		}
    	}
    	return idx;
    }
        /** Sheet2 Mendatory 항목
     vop_cd 가  Company(자사) 일때 : Register, Vessel Class, Port Class, OPR, OPR2, BSA Capa
     vop_cd 가  OTH 일때 : Register, OPR
     */
    function chkMendatory(){
        var sheetObj2 = sheetObjects[0];
        var lastrow = sheetObj2.LastRow;
        for(i=4; i<sheetObj2.LastRow; i++){
             var register =  sheetObj2.cellText(i,3);
             if(sheetObj2.CellValue(i,"skd_dir_cd")== 0 ) {
                ComShowMessage(ComGetMsg("COA10002",register +" Skd Dir Cd"));
    		        return false;
             }
             if(sheetObj2.CellValue(i,"port_cd")== 0 ) {
                ComShowMessage(ComGetMsg("COA10002",register +" Port Cd"));
    		        return false;
             }
             if(sheetObj2.CellValue(i, "port_yd")== 0 ) {
                ComShowMessage(ComGetMsg("COA10002",register +" Port Yard"));
    		        return false;
             }
             if(sheetObj2.CellValue(i, "turn_port_flg")== 0 ) {
                ComShowMessage(ComGetMsg("COA10002",register +" Turn Port Flag"));
    		        return false;
             }
        }
        return true;
    }


    /**
     * 다음 페이지를 보여주는 버튼.
     */
    function show_next() {
      var sheetObj = sheetObjects[0];
      with(sheetObj) {
        if(!sheetObj.ColHidden(11)) {
          for(i=11;i<31;i++) {
            sheetObj.ColHidden(i)="true";
          }
          var hiddenArr = new Array(3,4,5,7);
          for(i=0;i<11;i++) {
            sheetObj.ColHidden(i)="false";
          }
          sheetObj.CellValue(0,"port_yd") = "TMNL Code/Name";
          arrow_direction.innerHTML = "<input class='input2' style='font-weight:bold;font:14px;color:#ff0080;' type='button' value=' ▶ ' onClick='show_next();'>";
        } else {
          for(i=0;i<11;i++) {
            sheetObj.ColHidden(i)="true";
          }
          var hiddenArr = new Array(3,4,5,7);
          for(i=0;i<hiddenArr.length;i++) {
            sheetObj.ColHidden(hiddenArr[i])="false";
          }
          sheetObj.CellValue(0,"port_yd") = "Code";
          for(i=11;i<31;i++) {
            sheetObj.ColHidden(i)="false";
          }
          arrow_direction.innerHTML = "<input class='input2' style='font-weight:bold;font:14px;color:#ff0080;' type='button' value=' ◀ ' onClick='show_next();'>";
        }
      }
    }
    function chgFfe(f_name) {
      var sheetObj = sheetObjects[0];
      var formObj = document.form;
      if(sheetObj.RowCount > 0) {
        switch(f_name) {
          case 1:
            var strNo = formObj.fpeNo.value;
            if(strNo != null && (strNo==0 || strNo==1)) {
              sheetObj.CellValue("3","etb_dy_no") = formObj.fpeNo.value;
            } else {
              formObj.fpeNo.value = 0;
            }
          break;
          case 2:
            sheetObj.CellValue("3","etb_dy_cd") = formObj.fpeCd.options[formObj.fpeCd.selectedIndex].text;
          break;
          case 3:
            var tmpStr = ComGetMaskedValue(formObj.fpeHm.value,'hm');
            if(tmpStr != "" && tmpStr != null) {
              sheetObj.CellValue("3","etb_tm_hrmnt") = tmpStr;
              formObj.fpeHm.value = tmpStr;
            } else {
              sheetObj.CellValue("3","etb_tm_hrmnt") = "00:00";
              formObj.fpeHm.value = "00:00";
            }
          break;
        }
      } else {
        return false;
      }
    }
    function freQuencyChg() {
        var sheetObj = sheetObjects[0];
        var formObj = document.form;
        if(formObj.n1st_vsl_clss_knt.value=="" || formObj.n1st_vsl_clss_knt.value==null) return;
        var vsl_cnt  = sheetObj.EtcData("vsl_cnt");
        vsl_cnt = vsl_cnt.substring(0,vsl_cnt.length-1);
        var vslCntCode  = vsl_cnt.split("|");
        var arrSum=0;
        var freQuencyNum = formObj.f_brth_itval_dys.value;
        j = vslCntCode.length;
        if(j == 1) {
            arrSum = parseInt(vslCntCode[0]);
        } else if(j == 2) {
            arrSum = parseInt(vslCntCode[0])+parseInt(vslCntCode[1]);
        } else if(j == 3) {
            arrSum = parseInt(vslCntCode[0])+parseInt(vslCntCode[1])+parseInt(vslCntCode[2]);
        } else {
          return;
        }
        formObj.f_svc_dur_dys.value = freQuencyNum * arrSum;
    }

