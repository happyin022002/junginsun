/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : esm_bkg_1201.js
*@FileTitle : BKG Dashboard (by Office)
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.16
*@LastModifier : Poong-Yeon Cho
*@LastVersion : 1.0
* 2013.10.16 Poong-Yeon Cho
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
     * @extends 
     * @class esm_bkg_1201  생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_1201() {
    	this.processButtonClick	   = processButtonClick;
    	this.setSheetObject 	  = setSheetObject;
    	this.loadPage 				  = loadPage;
    	this.initSheet 				  = initSheet; 
    	this.initControl        = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnClick     = sheet1_OnClick;
    	this.sheet1_OnKeyUp     = sheet1_OnKeyUp;
    	this.setComboObject 		= setComboObject;
    }
    
   	/* 개발자 작업	*/    
     
 // 공통전역변수
 var sheetObjects = new Array();
 var sheetCnt = 0;

 var comboCnt = 0;
 var comboObjects = new Array();
 
 //bkg staff 조회용 bkg office temp value 저장용 변수
 var t1_bkg_ofc_cd = '';
 //sales rep 조회용 bkg office temp value 저장용 변수
 var t2_bkg_ofc_cd = '';
 
 /**
  * IBSheet Object를 배열로 등록
  * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
  * 배열은 소스 상단에 정의
  */
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++] = sheet_obj;
}
     
 /**
   * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
   * ComComboObject생성자 메소드에서 호출됨
   * param : comboObj ==> 콤보오브젝트
   * 
   */
function setComboObject(combo_obj){
    comboObjects[comboCnt++] = combo_obj;
}
        
 /**
  * Sheet 기본 설정 및 초기화
  * body 태그의 onLoad 이벤트핸들러 구현
  * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
  */
function loadPage() {
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    
    for(var k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],comboObjects[k].id);
    }
    
    var formObject = document.form;
    
    //멀티콤보초기화
    with (formObject.combo_cust) {
        var i=0;
        MultiSelect = false;
        InsertItem(i++, "Z|ALL", "");
        InsertItem(i++, "S|Shipper", "S");
        InsertItem(i++, "C|Consignee", "C");
        InsertItem(i++, "N|Notifier", "N");
        InsertItem(i++, "F|Forwarder", "F");
        InsertItem(i++, "A|Also Notifier", "A");
        InsertItem(i++, "E|Export Reference", "E");
        InsertItem(i++, "B|Broker", "B");
        Code="04";
    }
    
  //멀티콤보초기화
    with (formObject.combo_gcust) {
        var i=0;
        MultiSelect = false;
        InsertItem(i++, "Z|ALL", "");
        InsertItem(i++, "S|Shipper", "S");
        InsertItem(i++, "C|Consignee", "C");
        InsertItem(i++, "N|Notifier", "N");
        InsertItem(i++, "F|Forwarder", "F");
        InsertItem(i++, "A|Also Notifier", "A");
        InsertItem(i++, "E|Export Reference", "E");
        InsertItem(i++, "B|Broker", "B");
        Code="04";
    }
  //멀티콤보초기화
    with (formObject.combo_ctrt) {
        var i=0;
        MultiSelect = false;
        InsertItem(i++, "S|SC NO", "S");
        InsertItem(i++, "R|RFA NO", "R");
        InsertItem(i++, "T|TAA NO", "T");
        Code="04";
    }
  // TOOLTIP SETTING
  doActionIBSheet(sheetObjects[2], formObject, SEARCH14);
  initCondition();
  formObject.f_bkg_ofc_cd.focus();
}

/**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */ 
function initCombo(comboObj, comboId) {
    var formObject = document.form;
}

//콤보 멀티 셀렉트 및 수정 여부 초기 설정
function initComboEditable(combo, comboId){
    with (combo) {
        if(comboId == "f_staff_id"){
            MultiSelect = false;
            UseAutoComplete = true; 
            UseEdit = true;
                        
        } else if(comboId == "f_rep_id"){
            MultiSelect = false;
            UseEdit = true;
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



//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    var sheetObject1 = sheetObjects[1];
                
    var comboObject1 = comboObjects[0]; 
    /*******************************************************/
    var formObject = document.form;
                
    var srcName = window.event.srcElement.getAttribute("name");

    switch(srcName) {

        case "btn_new":
            sheetObject1.RemoveAll();
//          initSheet(sheetObject1,1);
            formObject.reset();
            document.f_staff_id.RemoveAll();
            document.f_rep_id.RemoveAll();
            document.combo_cust.Text='';
            document.combo_gcust.Text='';
            document.combo_ctrt.Text='';
            initCondition();
            formObject.f_bkg_ofc_cd.focus();
            break;
        case "btn_downexcel":
            doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
            break;
        case "btn_retrieve":
            doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
            break;
        case "btn_template":
            var retVal = ComOpenPopup('/hanjin/ESM_BKG_1212.do', 820, 460, 'TemplateSet', '0,1,1,1,1,1,1,1,1,1', false,false, 0, 0, 0,"fra_pop");
            break;  
    } // end switch
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

    var cnt = 0;

    switch (sheetNo) {
    case 1: 
        with (sheetObj) {
            // 높이 설정
            style.height = GetSheetHeight(15) ;
            // 전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            // Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            // 전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

            // 전체Edit 허용 여부 [선택, Default false]
            Editable = false;
            
            // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo( 2, 1, 9, 100);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, true, true, false,false) ;

            var HeadTitle1 = "ibflag|SEQ.|Dest|BKG Office|Dwell notification|Dwell notification|Dwell candidate|Dwell candidate|Port skip|Port skip" +
            		"|TPB Issue|TPB Issue|Not updated\nContainer|Not updated\nContainer|OB/L\nreleased|OB/L\nreleased|Waiting\nBKG|Waiting\nBKG" +
            		"|Customer\nAdvisory|Customer\nAdvisory|Container\nFinal Confirm|Container\nFinal Confirm|Contract\nApplicability|Contract\nApplicability|Rated|Rated|RDN|RDN" +
            		"|US Hold|US Hold|ENS Hold|ENS Hold|301 (Terminal EDI)|301 (Terminal EDI)|Booker holding|Booker holding|COD|COD|SI Receipt|SI Receipt" +
            		"|Vessel Schedule Change|Vessel Schedule Change|Vessel Schedule\nDelay|Vessel Schedule\nDelay"+
            		"|SI Reject|SI Reject|BKG Receipt|BKG Receipt|DEM/DET|DEM/DET|PRD Delete\n(Ocean)|PRD Delete\n(Ocean)|PRD Delete\n(IRG)|PRD Delete\n(IRG)" +
            		"|A/N|A/N|Special Cargo\nApproval|Special Cargo\nApproval|Phase-out|Phase-out|VL Unmatch|VL Unmatch|VD Unmatch|VD Unmatch" +
            		"|Draft B/L|Draft B/L|Constraint (Link)|Constraint (Link)|Constraint (Inland)|Constraint (Inland)|Constraint (Route)|Constraint (Route)";
            
            var HeadTitle2 = "ibflag|SEQ.|Dest|BKG Office|Alarm|Count|Alarm|Count|Alarm|Count" +
            "|Alarm|Count|Alarm|Count|Alarm|Count|Alarm|Count" +
            "|Alarm|Count|Alarm|Count|Alarm|Count|Alarm|Count|Alarm|Count" +
            "|Alarm|Count|Alarm|Count|Alarm|Count|Alarm|Count|Alarm|Count|Alarm|Count" +
            "|Alarm|Count|Alarm|Count"+
            "|Alarm|Count|Alarm|Count|Alarm|Count|Alarm|Count|Alarm|Count" +
            "|Alarm|Count|Alarm|Count|Alarm|Count|Alarm|Count|Alarm|Count" +
            "|Alarm|Count|Alarm|Count|Alarm|Count|Alarm|Count";


            var headCount = ComCountHeadTitle(HeadTitle1);
            
            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 4, 0, true);
            
            
            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);
            InitHeadRow(1, HeadTitle2, true);

            // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
            // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
            // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
            // SAVESTATUS, FORMATFIX]
            //InitDataProperty(0, cnt++, dtStatus, 30, daCenter, false, "ibflag");
            InitDataProperty(0, cnt++, dtHiddenStatus, 80, daCenter, false,  "ibflag",        false,          "",       dfNone,    0,     false,      false);
            InitDataProperty(0, cnt++, dtDataSeq, 75, daCenter, false, "s_seq",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 75, daCenter, false, "dest",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "bkg_ofc_cd",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtImage, 50, daCenter, false, "lmt_dwl_ntfc",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cnt_dwl_ntfc",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtImage, 50, daCenter, false, "lmt_dwl_cnddt",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cnt_dwl_cnddt",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtImage, 50, daCenter, false, "lmt_port_skip",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cnt_port_skip",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtImage, 50, daCenter, false, "lmt_tpb",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cnt_tpb",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtImage, 50, daCenter, false, "lmt_not_upd_cntr",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cnt_not_upd_cntr",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtImage, 50, daCenter, false, "lmt_obl_rls",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cnt_obl_rls",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtImage, 50, daCenter, false, "lmt_wt_bkg",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cnt_wt_bkg",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtImage, 50, daCenter, false, "lmt_cust_adv_fx_snd",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cnt_cust_adv_fx_snd",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtImage, 50, daCenter, false, "lmt_cntr_fnl_cfm",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cnt_cntr_fnl_cfm",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtImage, 50, daCenter, false, "lmt_cntrt_app",  false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cnt_cntrt_app",  false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtImage, 50, daCenter, false, "lmt_rated",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cnt_rated",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtImage, 50, daCenter, false, "lmt_rdn",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cnt_rdn",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtImage, 50, daCenter, false, "lmt_us_hld",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cnt_us_hld",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtImage, 50, daCenter, false, "lmt_eur_hld",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cnt_eur_hld",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtImage, 50, daCenter, false, "lmt_301_tml",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cnt_301_tml",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtImage, 50, daCenter, false, "lmt_bkr_hld",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cnt_bkr_hld",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtImage, 50, daCenter, false, "lmt_cod",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cnt_cod",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtImage, 50, daCenter, false, "lmt_nw_wb_bl_instr",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cnt_nw_wb_bl_instr",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtImage, 50, daCenter, false, "lmt_vsl_skd_chg",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cnt_vsl_skd_chg",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtImage, 50, daCenter, false, "lmt_vsl_skd_dly_ntc",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cnt_vsl_skd_dly_ntc",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtImage, 50, daCenter, false, "lmt_e_si_rjt",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cnt_e_si_rjt",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtImage, 50, daCenter, false, "lmt_bkg_rcp_ntc",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cnt_bkg_rcp_ntc",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtImage, 50, daCenter, false, "lmt_dem_det",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cnt_dem_det",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtImage, 50, daCenter, false, "lmt_ocn_del",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cnt_ocn_del",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtImage, 50, daCenter, false, "lmt_irg_del",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cnt_irg_del",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtImage, 50, daCenter, false, "lmt_arr_ntc",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cnt_arr_ntc",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtImage, 50, daCenter, false, "lmt_spcl_cgo_apr",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cnt_spcl_cgo_apr",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtImage, 50, daCenter, false, "lmt_phse_out",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cnt_phse_out",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtImage, 50, daCenter, false, "lmt_vl_unmtch",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cnt_vl_unmtch",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtImage, 50, daCenter, false, "lmt_vd_unmtch",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cnt_vd_unmtch",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtImage, 50, daCenter, false, "lmt_drft_bl",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cnt_drft_bl",      false,          "",       dfNone,          0,     false,       false);
//          InitDataProperty(0, cnt++, dtImage, 50, daCenter, false, "lmt_nod_cnstr",      false,          "",       dfNone,          0,     false,       false);
//          InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cnt_nod_cnstr",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtImage, 50, daCenter, false, "lmt_lnk_cnstr",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cnt_lnk_cnstr",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtImage, 50, daCenter, false, "lmt_prd_cnstr",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cnt_prd_cnstr",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtImage, 50, daCenter, false, "lmt_rout_cnstr",      false,          "",       dfNone,          0,     false,       false);
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cnt_rout_cnstr",      false,          "",       dfNone,          0,     false,       false);
            ImageList(0) = "/hanjin/img/alps/icon_g.gif" ;
            ImageList(1) = "/hanjin/img/alps/icon_g.gif" ;
            ImageList(2) = "/hanjin/img/alps/icon_y.gif" ;
            ImageList(3) = "/hanjin/img/alps/icon_r.gif" ;
        }
        break;
        
    case 2: 
        with (sheetObj) {
            // 높이 설정
            style.height = 0 ;
            // 전체 너비 설정
            SheetWidth = 0;

            // Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            // 전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

            // 전체Edit 허용 여부 [선택, Default false]
            Editable = false;
            
            // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo( 1, 1, 9, 100);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, true, true, false,false) ;

            var HeadTitle = "||||||" ;

            var headCount = ComCountHeadTitle(HeadTitle);
            
            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);
            
            
            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, true)

            // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
            // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
            // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
            // SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++, dtSeq,  100, daCenter, false, "s_seq",           false,          "",       dfNone,    0,     false,   false);
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rpt_fom_nm",      false,          "",       dfNone,    0,     false,   false);
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "dbd_irr_tp_cd",   false,          "",       dfNone,    0,     false,   false);
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "col_nm",          false,          "",       dfNone,    0,     false,   false);
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "itm_hlp_desc",    false,          "",       dfNone,    0,     false,   false);
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "dp_seq",          false,          "",       dfNone,    0,     false,   false);
        }
        break;
    case 3: 
        with (sheetObj) {
            // 높이 설정
            style.height = 0 ;
            // 전체 너비 설정
            SheetWidth = 0;

            // Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            // 전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

            // 전체Edit 허용 여부 [선택, Default false]
            Editable = false;
            
            // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo( 1, 1, 9, 100);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, true, true, false,false) ;

            var HeadTitle = "|||" ;

            var headCount = ComCountHeadTitle(HeadTitle);
            
            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);
            
            
            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, true)

            // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
            // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
            // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
            // SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "dbd_irr_tp_cd",   false,          "",       dfNone,    0,     false,   false);
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "col_nm",          false,          "",       dfNone,    0,     false,   false);
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "dp_nm",          false,          "",       dfNone,    0,     false,   false);
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "itm_hlp_desc",          false,          "",       dfNone,    0,     false,   false);
        }
        break;
        
    }
}

//Sheet관련 프로세스 처리
 function validate(sheetObj, sAction) {
     var formObj = document.form;
     switch (sAction) {
     case SEARCH01:
         for(var i=0; i<6; i++){
             if(formObj.s_kind[i].checked){

                 switch(i){
                     case 0: if (formObj.f_rhq_cd.value == '') return false; break;
                     case 1: if (formObj.f_bkg_ofc_cd.value == '') return false; break;
                     case 2: if (formObj.f_bkg_no.value == '') return false; break;
                     case 3: if (formObj.f_cust_cd.value == '') return false; break;
                     case 4: if (formObj.f_gcust_cd.value == '') return false; break;
                     case 5: if (formObj.f_ctrt_no.value == '') return false; break;
                 }
             }
         }
         break;
     }
     return true;
 }
 
//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
    switch (sAction) {
    case IBSEARCH:
        formObj.f_cmd.value = SEARCH01 ;

        if(!validate(sheetObj, SEARCH01)) return false;
        
        
        sheetObj.DoSearch("ESM_BKG_1201GS.do", FormQueryString(formObj));
        
        document.all.f_bat_st_dt.innerHTML = sheetObjects[0].EtcData("bat_st_dt");
        formObj.f_dbd_cre_dt.value = sheetObjects[0].EtcData("dbd_cre_dt");
        formObj.f_dbd_cre_seq.value = sheetObjects[0].EtcData("dbd_cre_seq");

        break;
        
    case SEARCH04:
        
        formObj.f_cmd.value = SEARCH04 ;
        var sXml = sheetObj.GetSearchXml("ESM_BKG_1201GS.do", FormQueryString(formObj));
        ComXml2ComboItem(sXml, formObj.f_staff_id, "usr_id", "usr_id");

        break;
        
    case SEARCH05:        
        
        formObj.f_cmd.value = SEARCH05 ;
        var sXml = sheetObj.GetSearchXml("ESM_BKG_1201GS.do", FormQueryString(formObj));
        ComXml2ComboItem(sXml, formObj.f_rep_id, "srep_cd", "srep_cd");

        break;
        
    case SEARCH07:
        formObj.f_cmd.value = SEARCH07;
        sheetObj.DoSearch("ESM_BKG_1201GS.do", FormQueryString(formObj));
        break;
        
    case SEARCH14:
        formObj.f_cmd.value = SEARCH14 ;
        sheetObj.DoSearch("ESM_BKG_1201GS.do", FormQueryString(formObj));
        break;
        
    case IBDOWNEXCEL:        //엑셀 다운로드
        var skipColList = '';
        var cnt = 0;
        for(var i=0; i<=sheetObj.LastCol ; i++){
            if( sheetObj.ColSaveName(i).substring(0,4) == 'lmt_'){
                if(cnt != 0){
                    skipColList += '|';
                }
                skipColList += sheetObj.ColSaveName(i);
                cnt++;
            }
        }
        sheetObj.SpeedDown2Excel(-1, false, false, '', '', false, false, '', false, skipColList );
        break;
    }
}

// OFFICE에 해당되는 BKG STAFF를 조회해온다.
function searchBkgStaffCombo(){   
    if(document.form.f_bkg_ofc_cd.value != '' && t1_bkg_ofc_cd != document.form.f_bkg_ofc_cd.value) {
        doActionIBSheet(sheetObjects[0],document.form,SEARCH04);
        t1_bkg_ofc_cd = document.form.f_bkg_ofc_cd.value;
    }
}

//OFFICE에 해당되는 SALES REP을 조회해온다.
function searchSalesRepCombo(){
    if(document.form.f_bkg_ofc_cd.value != '' && t2_bkg_ofc_cd != document.form.f_bkg_ofc_cd.value) {
        doActionIBSheet(sheetObjects[0],document.form,SEARCH05);
        t2_bkg_ofc_cd = document.form.f_bkg_ofc_cd.value;
    }
}

// Template Popup에서 Apply 했을때 Report Item을 조회한다.
function searchReportItem(rpt_form_no){
    var formObj = document.form;
    formObj.f_rpt_fom_no.value = rpt_form_no;
    doActionIBSheet(sheetObjects[1],formObj,SEARCH07);
}

// 선택된 Template을 Sheet에 적용한다.
function setTemplateItem(){
    var mainSheetObj = sheetObjects[0];
    var itemSheetObj = sheetObjects[1];
    var colName_s1 = '';
    var colName_s2 = '';
    
    initSheet(mainSheetObj, 1);
    for(var i=0; i<=mainSheetObj.LastCol ; i++){
        if( mainSheetObj.ColSaveName(i).substring(0,4) == 'cnt_' || mainSheetObj.ColSaveName(i).substring(0,4) == 'lmt_'){
            mainSheetObj.ColHidden(i) = true;
        }
    }

    
    for(var j=1; j<itemSheetObj.RowCount+1; j++){
        colName_s1 = 'cnt_'+ itemSheetObj.CellValue(j,'col_nm').toLowerCase();
        colName_s2 = 'lmt_'+ itemSheetObj.CellValue(j,'col_nm').toLowerCase();
        
        mainSheetObj.ColHidden(colName_s1) = false;
        mainSheetObj.ColHidden(colName_s2) = false;
    }
}

//Help 메시지를 Sheet에 풍선도움말로 보여준다.
function setBaloonHelp(){
    var mainSheetObj = sheetObjects[0];
    var itemSheetObj = sheetObjects[2];
    var colName = '';
    
    for(var i=0; i<=mainSheetObj.LastCol ; i++){
        if( mainSheetObj.ColSaveName(i).substring(0,4) == 'cnt_' || mainSheetObj.ColSaveName(i).substring(0,4) == 'lmt_'){
            colName = mainSheetObj.ColSaveName(i).substring(4);
            
            for(var j=1; j<itemSheetObj.RowCount+1; j++){
                if(colName == itemSheetObj.CellValue(j,'col_nm').toLowerCase()){
                    mainSheetObj.ToolTipText(0, mainSheetObj.ColSaveName(i)) = itemSheetObj.CellValue(j,'itm_hlp_desc') ;
                    continue;
                }
            }
        }
    }
}

function sheet2_OnSearchEnd(sheetObj,ErrMsg){
    var formObj = document.form;
    if(formObj.f_cmd.value == SEARCH07 ){
        setTemplateItem();
        setBaloonHelp();
    }
}

function sheet3_OnSearchEnd(sheetObj,ErrMsg){
    var formObj = document.form;
    if(formObj.f_cmd.value == SEARCH14 ){
        setBaloonHelp();
    }
}

function sheet1_OnDblClick(sheetObj,Row, Col, CellX, CellY, CellW, CellH) {
    var formObj = document.form;
    var colName = sheetObj.ColSaveName(Col).substring(4);

    formObj.f_dest_cnt_cd.value = sheetObj.CellValue(Row,'dest');
    formObj.f_irr_tp_cd.value = colName;
    formObj.f_irr_tp_nm.value = sheetObj.CellValue(0,'cnt_'+colName);
    formObj.s_bkg_ofc_cd.value = sheetObj.CellValue(Row,'bkg_ofc_cd');
    if(sheetObj.ColSaveName(Col) == 'dest' || sheetObj.ColSaveName(Col) == 'bkg_ofc_cd'){
        formObj.f_irr_tp_nm.value = 'Booking List';
        var retVal = ComOpenPopup('/hanjin/ESM_BKG_1203.do?'+FormQueryString(formObj), 820, 460, 'TemplateSet', '1,0,1,1,1,1,1,1,1,1', false,false, 0, 0, 0,"dtl_pop");
        return;
    }else if(sheetObj.CellValue(Row,'cnt_'+colName).substring(0,2) == '0/') {
        ComShowMessage('Please select number larger than 0')
        return;
    };
    
    switch (colName){
        case 'cntrt_app' :
        case 'rated' :
        case 'dwl_ntfc' :
        case 'dwl_cnddt' :
        case 'port_skip' :
        case 'obl_rls' :
        case 'wt_bkg' :
        case 'cntr_fnl_cfm' :
        case 'eur_hld' :
        case '301_tml' :
        case 'bkr_hld' :
        case 'cod' :
        case 'nw_wb_bl_instr' :
        case 'vsl_skd_chg' :
        case 'vsl_skd_dly_ntc' :
        case 'e_si_rjt' :
        case 'bkg_rcp_ntc' :
        case 'ocn_del' :
        case 'irg_del' :
        case 'arr_ntc' :
        case 'phse_out' :
        case 'vl_unmtch' :
        case 'vd_unmtch' :
        case 'lnk_cnstr' :
        case 'nod_cnstr' :
        case 'rout_cnstr' :
        case 'prd_cnstr' :
        case 'drft_bl' :
            var retVal = ComOpenPopup('/hanjin/ESM_BKG_1203.do?'+FormQueryString(formObj), 820, 460, 'TemplateSet', '1,0,1,1,1,1,1,1,1,1', false,false, 0, 0, 0,"dtl_pop");
            break;
        case 'tpb' :
            var retVal = ComOpenPopup('/hanjin/ESM_BKG_1204.do?'+FormQueryString(formObj), 820, 460, 'TemplateSet', '1,0,1,1,1,1,1,1,1,1', false,false, 0, 0, 0,"dtl_pop");
            break;
        case 'not_upd_cntr' :
            var retVal = ComOpenPopup('/hanjin/ESM_BKG_1205.do?'+FormQueryString(formObj), 820, 460, 'TemplateSet', '1,0,1,1,1,1,1,1,1,1', false,false, 0, 0, 0,"dtl_pop");
            break;
        case 'rdn' :
        case 'cust_adv_fx_snd' :
            var retVal = ComOpenPopup('/hanjin/ESM_BKG_1206.do?'+FormQueryString(formObj), 820, 460, 'TemplateSet', '1,0,1,1,1,1,1,1,1,1', false,false, 0, 0, 0,"dtl_pop");
            break;
        case 'us_hld' :
            var retVal = ComOpenPopup('/hanjin/ESM_BKG_1207.do?'+FormQueryString(formObj), 820, 460, 'TemplateSet', '1,0,1,1,1,1,1,1,1,1', false,false, 0, 0, 0,"dtl_pop");
            break;
        case 'dem_det' :
            var retVal = ComOpenPopup('/hanjin/ESM_BKG_1208.do?'+FormQueryString(formObj), 820, 460, 'TemplateSet', '1,0,1,1,1,1,1,1,1,1', false,false, 0, 0, 0,"dtl_pop");
            break;
        case 'spcl_cgo_apr' :
            var retVal = ComOpenPopup('/hanjin/ESM_BKG_1209.do?'+FormQueryString(formObj), 820, 460, 'TemplateSet', '1,0,1,1,1,1,1,1,1,1', false,false, 0, 0, 0,"dtl_pop");
            break;
    }
}

function f_staff_id_OnFocus(comboObj){
    searchBkgStaffCombo();
}

function f_rep_id_OnFocus(comboObj){
    searchSalesRepCombo();
}

function chgCondition(obj){
    var formObj = document.form;
    for(var i=0; i<6; i++){
        if(obj == formObj.s_kind[i]){
            formObj.f_rhq_cd.disabled = true;
            formObj.f_bkg_ofc_cd.disabled = true;
            formObj.f_sub_bkg_ofc_cd.disabled = true;
            formObj.f_bkg_no.disabled = true;
            formObj.combo_cust.Enable = false; formObj.f_cust_cd.disabled = true;
            formObj.combo_gcust.Enable = false; formObj.f_gcust_cd.disabled = true;
            formObj.combo_ctrt.Enable = false; formObj.f_ctrt_no.disabled = true;
            
            switch(i){
                case 0: formObj.f_rhq_cd.disabled = false; break;
                case 1: formObj.f_bkg_ofc_cd.disabled = false; formObj.f_sub_bkg_ofc_cd.disabled = false; break;
                case 2: formObj.f_bkg_no.disabled = false; break;
                case 3: formObj.combo_cust.Enable = true; formObj.f_cust_cd.disabled = false; break;
                case 4: formObj.combo_gcust.Enable = true; formObj.f_gcust_cd.disabled = false; break;
                case 5: formObj.combo_ctrt.Enable = true; formObj.f_ctrt_no.disabled = false; break;
            }
            break;
        }
    }
}

function initCondition(){
    var formObj = document.form;
    formObj.f_rhq_cd.disabled = true;
    formObj.f_bkg_ofc_cd.disabled = false;
    formObj.f_sub_bkg_ofc_cd.disabled = false;
    formObj.f_bkg_no.disabled = true;
    formObj.combo_cust.Enable = false; formObj.f_cust_cd.disabled = true;
    formObj.combo_gcust.Enable = false; formObj.f_gcust_cd.disabled = true;
    formObj.combo_ctrt.Enable = false; formObj.f_ctrt_no.disabled = true;
}
