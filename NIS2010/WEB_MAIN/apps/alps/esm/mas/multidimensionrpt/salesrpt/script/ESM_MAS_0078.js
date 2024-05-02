/*=========================================================
'주  시 스 템 : ENIS
'서브  시스템 : Office Report-by Daily BKG Creation
'프로그램 ID  : ESM_MAS_0078.js
'프로그램 명  : Office Report-by Daily BKG Creation
'프로그램개요 :
'작   성   자 : Nam Sangwook
'작   성   일 : 2006.11.24
'수   정   자 : Park Eun Ju
'수   정   일 : 2007.02.22
=========================================================
* History
* 2008.02.26 PEJ N200802220016 MAS 조회 기간 관련 수정 요청
* 변경사항 : 2007.07, 2007.27 이전 데이터를 조회 할수 없도록 함
* 2008.06.03 PEJ N200805300001 MAS_화면 개발 및 수정
* 2008.07.15 PSH N200806277654 Office-Report by Daily BKG Creation Report(078) 관련 수정
* 2008.12.22 박상희 N200812100006 Inquiry by BKG 화면 수정 : Inqyiry by BKG(079 -> 061) 화면사용
* 2009.02.04 김태윤 N200901190016 - MAS_조직개편 관련 기능 수정
* 2009.02.16 박상희 N200902050040 - Inqyiry by BkG 팝업화면 가로 사이즈 수정
* 2009.02.24 김태윤 R200902230004 - Office report-by Daily BKG Creation 화면 오류 수정건
* 2009.10.07 김기식 Alps전환작업
* 2009.10.27 송호진 ESM_MAS_0061 호출 Argument 수정
* 2010.01.15 윤진영 CHM-200901919 검색조건 년도와 주차를 선택했을 때 주차에 해당하는 조직도가 combo에 setting.
* 2010.01.18 윤진영 CHM-200901902 Split 01-Daily BKG Creation 보완
* 2010.02.22 이연각 업무처리중 버튼사용 금지 처리
* 2010.04.20 윤진영 Bound Combo 연동 개발 (vvd period , loading port와)
* 2010.06.01 윤진영 tpsz checkbox,combo 개발
* 2010.06.01 윤진영 tpsz가 *2가 아닌 경우 rpb,cmb,opb를 load가 아닌 box로 계산되도록 수정
* 2010.06.01 윤진영 tpsz가 *2가 아닌 경우 rpb,cmb,opb의 title명에 (BOX) 붙도록 수정
* 2010.12.01 김기종 Ticket ID:CHM-201006305-01 MAS Architecture 위배사항 수정
* 2011.03.08 김상수 Ticket ID:CHM-201109234-01 lane simulation 기능 보완
*                    - showErrMessage -> ComShowMessage로 수정
* 2011.05.11 최윤성 [CHM-201110694-01] MAS Report 화면 combo box validation 추가
* 2011.06.23 최성민 [CHM-201111639-01] [MAS]CNEE 조회 기능 추가_Office Report by Daily BKG Creation
* 2012.01.03 이석준 [CHM-201114896-01] CM2 비용 반영 
=========================================================*/

/**
 * @fileoverview
 * @author 한진해운
 */

/**
 * @extends
 * @class ESM_MAS_0078 : ESM_MAS_0078 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_MAS_0078() {
	this.processButtonClick = processButtonClick;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.setSheetObject = setSheetObject;
	this.sheet1_OnSearchEnd = sheet1_OnSearchEnd;
	this.sheet2_OnSearchEnd = sheet2_OnSearchEnd;
	this.sheet1_OnDblClick = sheet1_OnDblClick;
	this.chgOffice = chgOffice;
	this.changeCostYrmon = changeCostYrmon;
	this.getCOM_ENS_021_1 = getCOM_ENS_021_1;
	this.getCOM_ENS_021_2 = getCOM_ENS_021_2;
	this.f_trd_cd_OnChange = f_trd_cd_OnChange;
	this.validateForm = validateForm;
	this.display = display;
	this.chgViewColumn = chgViewColumn;
	this.viewSheet = viewSheet;
	this.comPopupLoc = comPopupLoc;
	this.changeTitle = changeTitle;
	this.doActionIBSheet = doActionIBSheet;
 }

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;
var loadingMode = false;
document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
     */
    function processButtonClick(){
        var sheetObject = sheetObjects[0];
        var formObject = document.form;
        var srcName = window.event.srcElement.getAttribute("name");

        try {
            switch(srcName) {
                case "btn_retrieve":
                    doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    break;

                case "btn_branchView":
                    doActionIBSheet(sheetObject,formObject,IBSEARCHAPPEND);
                    break;

                case "btn_downexcel":
                    doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
                    break;

                case "btns_calendar1":
                     var cal = new ComCalendar();
                     cal.select(formObject.f_fm_date, 'yyyy-MM-dd');
                     //cal.select(formObject.f_fm_date, 'f_fm_date', 'yyyy-MM-dd');
                    break;

                case "btns_calendar2":
                     var cal = new ComCalendar();
                     cal.select(formObject.f_to_date, 'yyyy-MM-dd');
                     //cal.select(formObject.f_to_date, 'f_to_date', 'yyyy-MM-dd');
                    break;

                case "bu_prev":
                    sheetObject.style.height = sheetObject.GetSheetHeight(100);
                    div_toggle_prev.style.display = "none";
                    div_toggle_next.style.display = "inline";
                    break;

                case "bu_next":
                    sheetObject.style.height = sheetObject.GetSheetHeight(18);
                    div_toggle_prev.style.display = "inline";
                    div_toggle_next.style.display = "none";
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
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        var formObj = document.form;

        loadingMode = true;
        doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
        // 멀티콤보 처리
    	//---------------------------------------------
    	for(k=0;k<comboObjects.length;k++){
    		initCombo(comboObjects[k], comboObjects[k].id);
    	}
    	//---------------------------------------------
    	loadingMode = false;

        for(i=0;i<sheetObjects.length;i++){
            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i], i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        viewSheet();
        display();
        chgViewColumn();

        formObj.f_fm_date.value = ComGetNowInfo();
        formObj.f_to_date.value = ComGetNowInfo();
        btn_retrieve.focus();
    }
     /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
     function initCombo (comboObj, comboId) {
     	with (comboObj) {
     		Index = 0;
     		DropHeight = 300;
     		
     		if(comboId == "f_sls_ofc_cd"){
        		ValidChar(2,1); // 영어대문자 사용, 숫자포함 시
        		MaxLength = 6;
        	} else if(comboId == "f_trd_cd"){
        		ValidChar(2,0); // 영어대문자 사용
        		MaxLength = 3;
        	} else if(comboId == "f_rlane_cd"){
        		ValidChar(2,1); // 영어대문자 사용, 숫자포함 시
        		MaxLength = 5;
        	} else if(comboId == "f_skd_dir_cd"){
        		ValidChar(2,0); // 영어대문자 사용
        		MaxLength = 1;
        	} else if(comboId == "f_loc_cd"){
        		ValidChar(2,1); // 영어대문자 사용, 숫자포함 시
        		MaxLength = 5;
        	} else if(comboId == "f_vvd_cd"){
        		ValidChar(2,1); // 영어대문자 사용, 숫자포함 시
        		MaxLength = 9;
        	} else if(comboId == "f_cntr_tpsz_cd"){
        		ValidChar(2,1); // 영어대문자 사용, 숫자포함 시
        		MaxLength = 4;
        	}
     	}
     }
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj, sheetNo) {
        var cnt = 0;
        var colCnt = 0;
        var colTotNum = 0;
        var aryTitle = new Array();
        var t1 = "";
        var formObj = document.form;

        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
                    MergeSheet = msHeaderOnly;                      //전체Merge 종류 [선택, Default msNone]
                    Editable = true;                               //전체Edit 허용 여부 [선택, Default false]
                    InitRowInfo( 1, 1, 9, 100);                      //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitColumnInfo(35, 0, 0, true);          //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitHeadMode(true, false, false, true, false,false); // 해더에서 처리할 수 있는 각종 기능을 설정한다

                    var temp_tpsz_cd = getComboObjValue(formObj.f_cntr_tpsz_cd);
                    var calc_grpb;
                    var calc_cmb;
                    var calc_opb;
                    var title_grpb;
                    var title_cmb;
                    var title_opb;
                    var title_op;
                    if(formObj.f_istpsz.checked && (temp_tpsz_cd.substring(temp_tpsz_cd.length-1,temp_tpsz_cd.length)!=2 || temp_tpsz_cd=='')) {
                    	calc_grpb = "|rev|/|box|";
                    	calc_cmb  = "|cm|/|box|";
                    	calc_opb  = "(|cm|-|op_cost|)/|box|";
                      	title_rpb= "RPB(BOX)";
                       	title_cmb = "BKG CMB(BOX)";
                       	title_op  = "OP|OP Cost"
                    	title_opb = "OPB(BOX)";
                    } else {
                    	calc_grpb = "|rev|/|load|";
                    	calc_cmb  = "|cm|/|load|";
                    	calc_opb  = "(|cm|-|op_cost|)/|load|";
                      	title_rpb = "RPB";
                       	title_cmb = "BKG CMB";
                       	title_op  = "OP|OP Cost"
                       	title_opb = "OPB";
                    }
                    var HeadTitle = "";
//                    if(getComboObjValue(formObj.f_pro_lvl) == "M") {                    
//                    } else {
//                    	HeadTitle = "Trade|Lane|Bound|VVD|Week|BKG POR|BKG POL|BKG POD|REV POL|REV POD|BKG DEL|C.Office|L.Office|CNEE NM|C.S.REP|L.S.REP|SC No|RFA No|SHPR NM|CMDT|CMDT NM|BKG NO|TPSZ|Load\n(BOX)|Load\n(TEU)|REV|BKG CM|OP|BKG CM Cost|BKG CM2|CM2 Cost|OP Cost|"+title_rpb+"|"+title_cmb+"|"+title_opb ;
//                    }
                    
                	HeadTitle = "Trade|Lane|Bound|VVD|Week|BKG POR|BKG POL|BKG POD|REV POL|REV POD|BKG DEL|C.Office|L.Office|CNEE NM|C.S.REP|L.S.REP|SC No|RFA No|SHPR NM|CMDT|CMDT NM|BKG NO|TPSZ|Load\n(BOX)|Load\n(TEU)|REV|BKG CM|BKG CM Cost|BKG CM2|CM2 Cost|"+title_rpb+"|"+title_cmb+"|"+title_op +"|"+title_opb ;                    
                    InitHeadRow(0, HeadTitle, true);                                          //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,     50,  daCenter, true,  "trd_cd",       false,  "",  dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     50,  daCenter, true,  "rlane_cd",     false,  "",  dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     50,  daCenter, true,  "dir_cd",       false,  "",  dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     80,  daCenter, true,  "vvd_cd",       false,  "",  dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     50,  daCenter, true,  "cost_wk",      false,  "",  dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     60,  daCenter, true,  "bkg_por_cd",   false,  "",  dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     60,  daCenter, true,  "bkg_pol_cd",   false,  "",  dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     60,  daCenter, true,  "bkg_pod_cd",   false,  "",  dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     60,  daCenter, true,  "rev_pol_cd",   false,  "",  dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     60,  daCenter, true,  "rev_pod_cd",   false,  "",  dfNone,      0,  false,  false);

                    InitDataProperty(0, cnt++ , dtData,     60,  daCenter, true,  "bkg_del_cd",   false,  "",  dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     70,  daCenter, true,  "c_ofc_cd",     false,  "",  dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     70,  daCenter, true,  "l_ofc_cd",     false,  "",  dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     70,  daCenter, true,  "cnee_nm",     false,  "",  dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     70,  daCenter, true,  "c_rep_cd",     false,  "",  dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     70,  daCenter, true,  "l_rep_cd",     false,  "",  dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     70,  daCenter, true,  "sc_no",        false,  "",  dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     80,  daCenter, true,  "rfa_no",       false,  "",  dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     200, daLeft,   true,  "shpr_nm",      false,  "",  dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     70,  daCenter, true,  "cmdt_cd",      false,  "",  dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     150, daLeft,   true,  "cmdt_nm",      false,  "",  dfNone,      0,  false,  false);

                    InitDataProperty(0, cnt++ , dtData,     90,  daLeft,   true,  "bkg_no",       false,  "",  dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     50, daRight,  true,  "spcl_cntr_tpsz_cd",          false,  "",  dfNone,  0,  false,  false);
                    InitDataProperty(0, cnt++ , dtAutoSum,  100, daRight,  true,  "box",          false,  "",  dfFloatOrg,  2,  false,  false);
                    InitDataProperty(0, cnt++ , dtAutoSum,  100, daRight,  true,  "load",          false,  "",  dfFloatOrg,  2,  false,  false);
                    InitDataProperty(0, cnt++ , dtAutoSum,  90,  daRight,  true,  "rev",          false,  "",  dfFloatOrg,  2,  false,  false);
                    InitDataProperty(0, cnt++ , dtAutoSum,  90,  daRight,  true,  "cm",           false,  "",  dfFloatOrg,  2,  false,  false);
//                    InitDataProperty(0, cnt++ , dtAutoSum,  90,  daRight,  true,  "op",           false,  "|cm|-|op_cost|",  dfFloatOrg,  2,  false,  false);                    
                    InitDataProperty(0, cnt++ , dtAutoSum,    90,  daRight,  true,  "cm_cost",      false,  "",  dfFloatOrg,  2,  false,  false);                    	
                    InitDataProperty(0, cnt++ , dtAutoSum,    90,  daRight,  true,  "cm2",      false,  "",  dfFloatOrg,  2,  false,  false);
                    InitDataProperty(0, cnt++ , dtAutoSum,    90,  daRight,  true,  "own_fdr",      false,  "",  dfFloatOrg,  2,  false,  false);
//                    InitDataProperty(0, cnt++ , dtAutoSum,  80,  daRight,  true,  "op_cost",      false,  "",  dfFloatOrg,  2,  false,  false);
                    InitDataProperty(0, cnt++ , dtAutoSum,  90,  daRight,  true,  "grpb",         false,  calc_grpb,  dfFloatOrg,  2,  false,  false);

                    InitDataProperty(0, cnt++ , dtAutoSum,  100,  daRight,  true,  "cmb",          false, calc_cmb,  dfFloatOrg,  2,  false,  false);
                    
                    InitDataProperty(0, cnt++ , dtAutoSum,  90,  daRight,  true,  "op",           false,  "|cm|-|op_cost|",  dfFloatOrg,  2,  false,  false);
                    InitDataProperty(0, cnt++ , dtAutoSum,  80,  daRight,  true,  "op_cost",      false,  "",  dfFloatOrg,  2,  false,  false);
                    
                    InitDataProperty(0, cnt++ , dtAutoSum,  80,  daRight,  true,  "opb",          false,  calc_opb,  dfFloatOrg,  2,  false,  false);

                    CountPosition  = 0 ;
                    style.height = GetSheetHeight(9) ;

                    if(getComboObjValue(formObj.f_pro_lvl) == "C") {
                    	ColHidden("opb") = true;
                    	ColHidden("op_cost") = true;
                    } else {
                    	ColHidden("opb") = false;
                    	ColHidden("op_cost") = false;
                    }

                    if(formObj.f_istpsz.checked) {
                    	sheetObj.ColHidden("spcl_cntr_tpsz_cd") = false;
                    	sheetObj.ColHidden("box") = false;
                    }
                }
                break;

            case 2:      //sheet1 init
                with (sheetObj) {
                    SheetWidth = mainTable2.clientWidth;             //전체 너비 설정
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
                    MergeSheet = msHeaderOnly;                      //전체Merge 종류 [선택, Default msNone]
                    Editable = false;                               //전체Edit 허용 여부 [선택, Default false]
                    InitRowInfo( 1, 1, 9, 50);                      //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitColumnInfo(25, 0, 0, true);          //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitHeadMode(true, false, false, true, false,false); // 해더에서 처리할 수 있는 각종 기능을 설정한다

                    var HeadTitle = "" ;
                    HeadTitle = "Trade|Lane|Bound|VVD|Week|BKG POR|BKG POL|BKG POD|REV POL|REV POD|BKG DEL|C.Office|L.Office|CNEE NM|C.S.REP|L.S.REP|SC No|RFA No|SHPR NM|CMDT|CMDT NM|BKG NO|STP Cost|Oth Vol\nActivity Cost|Net STP\nLoss" ;
                    InitHeadRow(0, HeadTitle, true);                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,     80,  daCenter, true,  "trd_cd",       false,  "",  dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     80,  daCenter, true,  "rlane_cd",     false,  "",  dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     80,  daCenter, true,  "dir_cd",       false,  "",  dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     80,  daCenter, true,  "vvd_cd",       false,  "",  dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     70,  daCenter, true,  "cost_wk",      false,  "",  dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     70,  daCenter, true,  "bkg_por_cd",   false,  "",  dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     70,  daCenter, true,  "bkg_pol_cd",   false,  "",  dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     70,  daCenter, true,  "bkg_pod_cd",   false,  "",  dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     70,  daCenter, true,  "rev_pol_cd",   false,  "",  dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     70,  daCenter, true,  "rev_pod_cd",   false,  "",  dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     70,  daCenter, true,  "bkg_del_cd",   false,  "",  dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     70,  daCenter, true,  "c_ofc_cd",     false,  "",  dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     70,  daCenter, true,  "l_ofc_cd",     false,  "",  dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     70,  daCenter, true,  "cnee_nm",      false,  "",  dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     70,  daCenter, true,  "c_rep_cd",     false,  "",  dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     70,  daCenter, true,  "l_rep_cd",     false,  "",  dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     70,  daCenter, true,  "sc_no",        false,  "",  dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     80,  daCenter, true,  "rfa_no",       false,  "",  dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     200, daLeft,   true,  "shpr_nm",      false,  "",  dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     70,  daLeft,   true,  "cmdt_cd",      false,  "",  dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     150, daLeft,   true,  "cmdt_nm",      false,  "",  dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     80,  daLeft,   true,  "bkg_no",       false,  "",  dfNone,      0,  false,  false);

                    InitDataProperty(0, cnt++ , dtAutoSum,  90,  daRight,  true,  "svc_trns_prc_amt",      false,  "",  dfFloatOrg,  2,  false,  false);
                    InitDataProperty(0, cnt++ , dtAutoSum,  90,  daRight,  true,  "otr_prc_amt",      false,  "",  dfFloatOrg,  2,  false,  false);
                    InitDataProperty(0, cnt++ , dtAutoSum,  90,  daRight,  true,  "stp_profit",      false,  "",  dfFloatOrg,  2,  false,  false);

//                    RangeBackColor(1, colCnt+5, 1, colTotNum-1) = RgbColor(222, 251, 248);
                    CountPosition  = 0 ;
                    style.height = GetSheetHeight(7) ;


                }
                break;

        }
    }

     /**
     * Sheet관련 프로세스 처리
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        var sheetObj2 = sheetObjects[1];
        formObj.f_fm_date.value = ComReplaceStr(formObj.f_fm_date.value,"-","");
        formObj.f_to_date.value = ComReplaceStr(formObj.f_to_date.value,"-","");
        switch(sAction) {
        	case IBCLEAR:          //조회

		        sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = INIT;
				var sXml = document.form.sXml.value;
				document.form.sXml.value = "";
				var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
				var arrXml = sXml.split("|$$|");

				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], formObj.f_pro_vw, "code", "name");
				if (arrXml.length > 1)
					ComXml2ComboItem(arrXml[1], formObj.f_ofc_vw, "code", "name");
				if (arrXml.length > 2)
					ComXml2ComboItem(arrXml[2], formObj.f_pro_lvl, "code", "name");

				if (arrXml.length > 3)
					ComXml2ComboItem(arrXml[3], formObj.f_rhq_cd, "code", "name");
				if (arrXml.length > 4)
					ComXml2ComboItem(arrXml[4], formObj.f_sls_ofc_cd, "code", "code");
				if (arrXml.length > 5)
					ComXml2ComboItem(arrXml[5], formObj.f_trd_cd, "code", "code");
				if (arrXml.length > 6)
					ComXml2ComboItem(arrXml[6], formObj.f_rlane_cd, "code", "code");
				if (arrXml.length > 7)
					ComXml2ComboItem(arrXml[7], formObj.f_skd_dir_cd, "code", "code");

				if (arrXml.length > 8)
					ComXml2ComboItem(arrXml[8], formObj.f_loc_cd, "code", "code");
				if (arrXml.length > 9)
					ComXml2ComboItem(arrXml[9], formObj.f_vvd_cd, "code", "code");
				if (arrXml.length > 10)
					ComXml2ComboItem(arrXml[10], formObj.f_cntr_tpsz_cd, "code", "code");


				ComOpenWait(false);
				break;

            case IBSEARCH:          // 첫번째 Sheet 조회
                if(!validateForm(sheetObj, formObj, sAction)) return false;
                // 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
                formObj.f_cmd.value = SEARCHLIST01;
                sheetObj.DoSearch4Post("ESM_MAS_0078GS.do", masFormQueryString(formObj));
                ComOpenWait(false);
                break;

            case IBSEARCHAPPEND:  // 두번째 Sheet조회
            	// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
                formObj.f_cmd.value = SEARCHLIST02;
                if(ComGetObjValue(formObj.f_pro_vw) == "R") sheetObj2.DoSearch4Post("ESM_MAS_0078GS2.do", masFormQueryString(formObj));
                ComOpenWait(false);
                break;

            case IBDOWNEXCEL:       //엑셀 다운로드
                //sheetObj.SpeedDown2Excel(-1, true, true);
                var excelType = selectDownExcelMethod(sheetObj);
                switch (excelType) {
                    case "AY":
                        sheetObj.Down2Excel(0, false, false, true);
                        if(getComboObjValue(formObj.f_pro_vw) == "R")sheetObj2.Down2Excel(0, true, false, true);
                        break;
                    case "DY":
                        sheetObj.Down2Excel(-1, false, false, true);
                        if(getComboObjValue(formObj.f_pro_vw) == "R" && sheetObj2.LastRow>1)sheetObj2.Down2Excel(-1, true, false, true);
                        break;
                    case "AN":
                        sheetObj.SpeedDown2Excel(0, false, false);
                        if(getComboObjValue(formObj.f_pro_vw) == "R")sheetObj2.SpeedDown2Excel(0, true, false);
                        break;
                    case "DN":
                        sheetObj.SpeedDown2Excel(-1, false, false);
                        if(getComboObjValue(formObj.f_pro_vw) == "R")sheetObj2.SpeedDown2Excel(-1, true, false);
                        break;
                }
                break;

        }
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
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * Total값을 재계산한다.
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    	 var formObj = document.form;
    	 var sheetObj = sheetObjects[0];
         if(formObj.f_istpsz.checked) {
             sheetObj.SumValue(0, "grpb")  = eval("("  + sheetObj.SumValue(0,"rev")  + "/" + sheetObj.SumValue(0, "box")  + ")").toFixed(2);
             sheetObj.SumValue(0, "cmb")  = eval("("  + sheetObj.SumValue(0,"cm")    + "/" + sheetObj.SumValue(0, "box")  + ")").toFixed(2);
             sheetObj.SumValue(0, "opb")  = eval("(("  + sheetObj.SumValue(0,"cm")+ "-" +  sheetObj.SumValue(0,"op_cost")  + ")/" + sheetObj.SumValue(0, "box")  + ")").toFixed(2);
         }
         else if(eval(sheetObj.SumValue(0, "load")) > 0){
            sheetObj.SumValue(0, "grpb")  = eval("("  + sheetObj.SumValue(0,"rev")  + "/" + sheetObj.SumValue(0, "load")  + ")").toFixed(2);
            sheetObj.SumValue(0, "cmb")  = eval("("  + sheetObj.SumValue(0,"cm")    + "/" + sheetObj.SumValue(0, "load")  + ")").toFixed(2);
            sheetObj.SumValue(0, "opb")  = eval("(("  + sheetObj.SumValue(0,"cm")+ "-" +  sheetObj.SumValue(0,"op_cost")  + ")/" + sheetObj.SumValue(0, "load")  + ")").toFixed(2);
        } else {
            sheetObj.SumValue(0, "grpb") = "0";
            sheetObj.SumValue(0, "cmb") = "0";
        }
    }

    /**
     * search 후에 branch cm의 합계를 구해서 뿌려준다.
     */
    function sheet2_OnSearchEnd(sheetObj, ErrMsg){
        var sheetObj1 = sheetObjects[0];
        var sheetObj2 = sheetObjects[1];
        var fromObj = document.form;
        var brancCm = 0;
        if(getComboObjValue(document.form.f_ofc_vw) == "C"){
        	brancCm = parseFloat(sheetObj1.SumValue(0, "cm")) - parseFloat(sheetObj2.SumValue(0, "stp_profit"));
        } else {
        	brancCm = parseFloat(sheetObj1.SumValue(0, "cm")) + parseFloat(sheetObj2.SumValue(0, "stp_profit"));
        }
        document.form.branch_cm.value = Math.round(brancCm*100)/100;
        document.form.branch_cm.value = ComAddComma(document.form.branch_cm);
    }

    /**
     * BKG NO가 있을경우 Inquiry by BKG화면을 열어준다.
     */
    function sheet1_OnDblClick(sheetObj, row, col, value){
        var formObj = document.form;
        var param = "";

        if(formObj.f_isbkg.checked){
            param =  "?f_pro_vw="+getComboObjValue(formObj.f_pro_vw)
                    +"&f_pro_lvl="+getComboObjValue(formObj.f_pro_lvl)
                    +"&f_s_bkg_no="+sheetObj.CellValue(row, "bkg_no")
                    +"&pgmNo=ESM_MAS_0061";
            ComOpenWindow('ESM_MAS_0061POP.do' + param, 'Inquiry by BKG'
					, 'width=850,height=850,menubar=0,status=1,scrollbars=0,resizable=1');
        }
    }

    // 콤보 처리
    //--------------------------------------------------------------------
    /**
     * S/C 검색결과를 반환한다.
     */
    function getCOM_ENS_021_1(rowArray) {
        var colArray = rowArray[0];
//        ComShowMessage(rowArray.length+" ::::: " + colArray[0]+":"+colArray[1]+":"+colArray[2]+":"+colArray[3]+":"+colArray[4]+":"+colArray[5]+":"+colArray[6]+":"+colArray[7]+":"+colArray[8]);
        document.all.f_sc_no.value = colArray[2];
    }

    /**
     * RFA 검색결과를 반환한다.
     */
    function getCOM_ENS_021_2(rowArray) {
        var colArray = rowArray[0];
//        ComShowMessage(rowArray.length+ " : " + colArray[0]+":"+colArray[1]+":"+colArray[2]+":"+colArray[3]+":"+colArray[4]+":"+colArray[5]+":"+colArray[6]+":"+colArray[7]+":"+colArray[8]);
        document.all.f_rfa.value = colArray[2];
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
			if(formObj.f_fm_date.value == "" && formObj.f_to_date.value == ""){
			    // [MAS10002] : Period을(를) 입력하세요..
			    ComAlertFocus(formObj.f_fm_date, ComGetMsg("MAS10002", "Period"));
			    return false;
			}
			if(formObj.f_vsl_cd.value != "" && formObj.f_skd_voy_no.value != "" && formObj.f_dir_cd.value !="" ) {
			    if(ComGetDaysBetween(formObj.f_fm_date.value,formObj.f_to_date.value) > 31){
			        // VVD입력시 조회범위를 1달로 할수 있다.
			        // ['MAS10008'] : 1 Month 을(를)  초과할수 없습니다.
			        ComAlertFocus(f_to_date, ComGetMsg("MAS10008", "1 Month"));
			        return false;
			    }
			} else {
    			if( parseInt(getComboObjValue(formObj.f_rhq_cd)) < 3){
    			    if(ComGetDaysBetween(formObj.f_fm_date.value,formObj.f_to_date.value) > 0){
    			        // ['MAS10008'] : 1 Days 을(를)  초과할수 없습니다.
    			        ComAlertFocus(f_to_date, ComGetMsg("MAS10008", "1 Days"));
    			        return false;
    			    }
    			} else {
    			    if(ComGetDaysBetween(formObj.f_fm_date.value,formObj.f_to_date.value) > 6){
    			        // ['MAS10008'] : 7 Days 을(를)  초과할수 없습니다.
    			        ComAlertFocus(f_to_date, ComGetMsg("MAS10008", "7 Days"));
    			        return false;
    			    }
    			}
    			if(ComParseInt(ComReplaceStr(formObj.f_fm_date.value,"-","")) < 20070701){
    			    // 2007년 07월, 27주 이전데이터는 조회 할수 없습니다. DW, CRM 시스템에서 조회 하시기 바랍니다.
    				ComShowMessage(ComGetMsg("MAS10037"));
    			    return false;
    			}
			}
        }

        return true;
    }
     /**
     * trade변경시 R.Lane combo변경
     */
     function f_trd_cd_OnChange(obj) {
     	if (loadingMode == true)
     		return;
     	var formObj = document.form;
     	var sheetObj = sheetObjects[0];
     	if (obj.Text != "") {
     		formObj.f_cmd.value = SEARCHLIST11;
     		var sXml = sheetObj.GetSearchXml("ESM_MAS_0078GS.do", masFormQueryString(formObj));
     		var arrXml = sXml.split("|$$|");
     		if (arrXml.length > 0)
     			ComXml2ComboItem(arrXml[0], formObj.f_rlane_cd, "code", "code");
     		formObj.f_rlane_cd.Index = 0;
     	}
     }
    /**
     * 체크박스 선택 유무에 따라서 Sheet의 항목을 동적으로 변경한다.
     */
    function display(){
        var formObj = document.form;
        var sheetObj1 = sheetObjects[0];
        var sheetObj2 = sheetObjects[1];

        // Data를 초기화 한다.
        sheetObj1.RemoveAll();
        sheetObj2.RemoveAll();

        // 항목을 체크 유무에 따라서 설정한다.
        if(formObj.f_isvvd.checked){
            sheetObj1.ColHidden("trd_cd")   = false;
            sheetObj1.ColHidden("rlane_cd") = false;
            sheetObj1.ColHidden("dir_cd")   = false;
            sheetObj1.ColHidden("cost_wk")  = false;
            sheetObj1.ColHidden("vvd_cd")   = false;
            sheetObj2.ColHidden("trd_cd")   = false;
            sheetObj2.ColHidden("rlane_cd") = false;
            sheetObj2.ColHidden("dir_cd")   = false;
            sheetObj2.ColHidden("cost_wk")  = false;
            sheetObj2.ColHidden("vvd_cd")   = false;
        } else {
            sheetObj1.ColHidden("trd_cd")   = true;
            sheetObj1.ColHidden("rlane_cd") = true;
            sheetObj1.ColHidden("dir_cd")   = true;
            sheetObj1.ColHidden("cost_wk")  = true;
            sheetObj1.ColHidden("vvd_cd")   = true;
            sheetObj2.ColHidden("trd_cd")   = true;
            sheetObj2.ColHidden("rlane_cd") = true;
            sheetObj2.ColHidden("dir_cd")   = true;
            sheetObj2.ColHidden("cost_wk")  = true;
            sheetObj2.ColHidden("vvd_cd")   = true;
        }
        if(formObj.f_isweek.checked || formObj.f_isvvd.checked){
            sheetObj1.ColHidden("cost_wk") = false;
            sheetObj2.ColHidden("cost_wk") = false;
        } else {
            sheetObj1.ColHidden("cost_wk") = true;
            sheetObj2.ColHidden("cost_wk") = true;
        }
        if(formObj.f_issrep.checked){
            sheetObj1.ColHidden("c_rep_cd") = false;
            sheetObj1.ColHidden("l_rep_cd") = false;
            sheetObj2.ColHidden("c_rep_cd") = false;
            sheetObj2.ColHidden("l_rep_cd") = false;
        } else {
            sheetObj1.ColHidden("c_rep_cd") = true;
            sheetObj1.ColHidden("l_rep_cd") = true;
            sheetObj2.ColHidden("c_rep_cd") = true;
            sheetObj2.ColHidden("l_rep_cd") = true;
        }
        if(formObj.f_isshpr.checked){
            sheetObj1.ColHidden("shpr_nm") = false;
            sheetObj2.ColHidden("shpr_nm") = false;
        } else {
            sheetObj1.ColHidden("shpr_nm") = true;
            sheetObj2.ColHidden("shpr_nm") = true;
        }
        
       //This hide and show the column CNEE
       //Du.Phan 20110621
        if(formObj.f_iscnee.checked){
            sheetObj1.ColHidden("cnee_nm") = false;
            sheetObj2.ColHidden("cnee_nm") = false;
        } else {
            sheetObj1.ColHidden("cnee_nm") = true;
            sheetObj2.ColHidden("cnee_nm") = true;
        }
        
        if(formObj.f_isbkg.checked){
            sheetObj1.ColHidden("bkg_no") = false;
            sheetObj2.ColHidden("bkg_no") = false;
        } else {
            sheetObj1.ColHidden("bkg_no") = true;
            sheetObj2.ColHidden("bkg_no") = true;
        }
        if(formObj.f_bkg_sts.checked){
           document.getElementById("subTitle").innerHTML = "Waiting BKG Include";
        } else {
           document.getElementById("subTitle").innerHTML = "Firm BKG Only";
        }
        if(formObj.f_isroute.checked){
            sheetObj1.ColHidden("bkg_por_cd")   = false;
            sheetObj2.ColHidden("bkg_por_cd")   = false;
            if(formObj.f_prd_cd[0].checked){
            	sheetObj1.ColHidden("bkg_pol_cd")   = false;
            	sheetObj2.ColHidden("bkg_pol_cd")   = false;
            	sheetObj1.ColHidden("bkg_pod_cd")   = false;
            	sheetObj2.ColHidden("bkg_pod_cd")   = false;

            	sheetObj1.ColHidden("rev_pol_cd")   = true;
            	sheetObj2.ColHidden("rev_pol_cd")   = true;
            	sheetObj1.ColHidden("rev_pod_cd")   = true;
            	sheetObj2.ColHidden("rev_pod_cd")   = true;
            }else{
            	sheetObj1.ColHidden("bkg_pol_cd")   = true;
            	sheetObj2.ColHidden("bkg_pol_cd")   = true;
            	sheetObj1.ColHidden("bkg_pod_cd")   = true;
            	sheetObj2.ColHidden("bkg_pod_cd")   = true;

            	sheetObj1.ColHidden("rev_pol_cd")   = false;
            	sheetObj2.ColHidden("rev_pol_cd")   = false;
            	sheetObj1.ColHidden("rev_pod_cd")   = false;
            	sheetObj2.ColHidden("rev_pod_cd")   = false;
            }
            sheetObj1.ColHidden("bkg_del_cd")   = false;
            sheetObj2.ColHidden("bkg_del_cd")   = false;
        } else {
            sheetObj1.ColHidden("bkg_por_cd")   = true;
            sheetObj2.ColHidden("bkg_por_cd")   = true;
            sheetObj1.ColHidden("bkg_pol_cd")   = true;
            sheetObj2.ColHidden("bkg_pol_cd")   = true;
            sheetObj1.ColHidden("bkg_pod_cd")   = true;
            sheetObj2.ColHidden("bkg_pod_cd")   = true;
            sheetObj1.ColHidden("rev_pol_cd")   = true;
            sheetObj2.ColHidden("rev_pol_cd")   = true;
            sheetObj1.ColHidden("rev_pod_cd")   = true;
            sheetObj2.ColHidden("rev_pod_cd")   = true;
            sheetObj1.ColHidden("bkg_del_cd")   = true;
            sheetObj2.ColHidden("bkg_del_cd")   = true;
        }
        if(formObj.f_issc.checked){
            sheetObj1.ColHidden("sc_no")   = false;
            sheetObj2.ColHidden("sc_no")   = false;
            sheetObj1.ColHidden("rfa_no")   = false;
            sheetObj2.ColHidden("rfa_no")   = false;
        } else {
            sheetObj1.ColHidden("sc_no")   = true;
            sheetObj2.ColHidden("sc_no")   = true;
            sheetObj1.ColHidden("rfa_no")   = true;
            sheetObj2.ColHidden("rfa_no")   = true;
        }
        if(formObj.f_iscmdt.checked){
            sheetObj1.ColHidden("cmdt_cd")   = false;
            sheetObj2.ColHidden("cmdt_cd")   = false;
            sheetObj1.ColHidden("cmdt_nm")   = false;
            sheetObj2.ColHidden("cmdt_nm")   = false;
        } else {
            sheetObj1.ColHidden("cmdt_cd")   = true;
            sheetObj2.ColHidden("cmdt_cd")   = true;
            sheetObj1.ColHidden("cmdt_nm")   = true;
            sheetObj2.ColHidden("cmdt_nm")   = true;
        }
        if(formObj.f_istpsz.checked){
        	formObj.f_cntr_tpsz_cd.Enable=true;
        	initSheet(sheetObj1,1);
        } else {
        	formObj.f_cntr_tpsz_cd.Index=0;
        	formObj.f_cntr_tpsz_cd.Enable=false;
        	sheetObj1.ColHidden("spcl_cntr_tpsz_cd") = true;
        	sheetObj1.ColHidden("box") = true;
        	initSheet(sheetObj1,1);
        }
    }

    /**
     * View Level이 CM/OP이냐에 따라서 Sheet의 컬럼 을
     */
    function chgViewColumn(){
        var sheetObj = sheetObjects[0];
        var sheetObj2 = sheetObjects[1];
        var formObj = document.form;

        if(getComboObjValue(formObj.f_pro_lvl) == "C"){
            sheetObj.ColHidden("op_cost") = true;
            sheetObj.ColHidden("opb") = true;
            sheetObj.ColHidden("op") = true;
            if (getComboObjValue(formObj.f_pro_lvl) == "C"){
                sheetObj.ColHidden("cm2") = true;
                sheetObj.ColHidden("own_fdr") = true;
            } else {
                sheetObj.ColHidden("cm2") = false;
                sheetObj.ColHidden("own_fdr") = false;
            }
//        } else {
//            if(getComboObjValue(formObj.f_pro_vw) == "R"){
//            	sheetObj.ColHidden("op_cost") = false;
//                sheetObj.ColHidden("opb") = false;
//                sheetObj.ColHidden("op") = false;
//            }
        } else if(getComboObjValue(formObj.f_pro_lvl) == "O"){
        	sheetObj.ColHidden("op_cost") = false;
        	sheetObj.ColHidden("opb") = false;
        	sheetObj.ColHidden("op") = false;
        }

    }

     function f_pro_vw_OnChange(obj, code){
    	 if (loadingMode == true)
       		return;
    	 viewSheet();
     }
    /**
     * Office View 콤보 변경시 Sheet2 Title 변경
     *
     * @return
     */
    function f_ofc_vw_OnChange(obj, code){
    	if (loadingMode == true)
      		return;

        var sheetObj = sheetObjects[1];
        var formObj = document.form;

        // Sheet2의 Title 변경
        if(getComboObjValue(formObj.f_ofc_vw)=="C"){
        	sheetObj.CellValue(0,"svc_trns_prc_amt") = "STP Cost";
        	sheetObj.CellValue(0,"stp_profit") = "Net STP\nLoss";
        }else{
        	sheetObj.CellValue(0,"svc_trns_prc_amt") = "STP Revenue";
        	sheetObj.CellValue(0,"stp_profit") = "Net STP\nIncome";
        }
    }
     function f_pro_lvl_OnChange(obj, code){
    	 if (loadingMode == true)
       		return;
    	 chgViewColumn();
     }
     /**
      * Office View 콤보 변경시 Sheet2 Title 변경
      *
      * @return
      */
     function f_cntr_tpsz_cd_OnChange(obj, code){
    	  if (loadingMode == true)
       		return;
         var sheetObj1 = sheetObjects[0];
         var sheetObj2 = sheetObjects[1];
         var formObj = document.form;
         sheetObj1.RemoveAll();
         sheetObj2.RemoveAll();
         // Sheet2의 Title 변경
         var temp_tpsz_cd = getComboObjValue(formObj.f_cntr_tpsz_cd);
         initSheet(sheetObj1,1);
    }

    /**
     * Profit view가 Office profit 일경우 Branch View sheet를 보여준다.
     *
     * @return
     */
    function viewSheet(){
        var sheetObj = sheetObjects[1];
        var formObj = document.form;
        if(getComboObjValue(formObj.f_pro_vw) == "P"){
            btn_branch.style.display = "none";
            td_branch.style.display  = "none";
            if (formObj.f_pro_lvl.GetCount () == 1) {
				formObj.f_pro_lvl.InsertItem(-1, "OP", "O");
			}
            ComSetObjValue(formObj.f_pro_lvl,"C");
//            sheetObj.Redraw = false;
//            sheetObj.RemoveAll();
//            sheetObj.Reset();
//            initSheet(sheetObj, 2);
//            sheetObj.Redraw = true;
        } else {
            btn_branch.style.display = "block";
            td_branch.style.display  = "block";
            if (formObj.f_pro_lvl.GetCount () == 2) {
				formObj.f_pro_lvl.DeleteItem("O");
				formObj.f_pro_lvl.Code = "C";
			}
        }
        display();
        parent.syncHeight();
        
      //Profit Level 에 OP 권한 확인
        ComMasOpCheckOfcCd(formObj.f_pro_lvl, ComGetObjValue(formObj.f_usr_lgn_ofc_cd));
    }

     /**
     * S/C, RFA 검색 팝업창 띄우기
     */
    function comPopupLoc(flag, value) {
        display = "1,0,1,1,1,1,1,1";
        var cont_tp = "";
        var cont_no = "";

        if(value != ""){
            cont_tp = value.substring(0,3);
            cont_no = value.substring(3);
        }
        var param = "?cont_tp="+cont_tp+"&cont_no="+cont_no+"&flag="+flag;
        if(flag == 1){
            var targetFun = "getCOM_ENS_021_1";
        }else{
            var targetFun = "getCOM_ENS_021_2";
        }
        //comPopup('/hanjin/COM_ENS_021.do' + param, 780, 480, targetFun, display, true);    // radio PopUp
        ComOpenPopup('/hanjin/COM_ENS_021.do' + param, 780, 480, targetFun, display, true);
    }


/**
*  Office View에 따라 Field 이름이 다르게 보이도록 한다.
   - Contract View 일때는 C.Office, C.S.Rep
   - Loading View 일때는  L.Office, L.Rep
*/

    function changeTitle(param) {
        var sheetObj = sheetObjects[0];
        var sheetObj2 = sheetObjects[1];
        if(param=="C"){
            sheetObj.CellValue(0,"ofc_cd") = "C.Office";
            sheetObj.CellValue(0,"srep_cd") = "C.S.Rep";
        }else{
            sheetObj.CellValue(0,"ofc_cd") = "L.Office";
            sheetObj.CellValue(0,"srep_cd") = "L.Rep";
        }
    }

    /**
     * T.VVD Period 선택시 REV. POL, Loading Port, Period VVD 항목을 활성화시킴
     *
     * @return
     */
    function f_prd_cd_OnClick(){
    	var formObj = document.form;

    	if(formObj.f_prd_cd[0].checked){
    		tr_route2.style.display = "none";
    	} else {
    		tr_route2.style.display = "block";
    	}
    	display();
    	f_rlane_cd_OnChange(formObj.f_rlane_cd);

    }

     /**
     * Office Level 변경시 Office combo변경
     */
     function f_rhq_cd_OnChange(obj, code){
     	 if (loadingMode == true) return;
     	 chgOffice(obj);
     }

     /**
     * 본부 콤보변경시...
     */
     function chgOffice(obj){
     	var formObj = document.form;
        var sheetObj = sheetObjects[0];
        if(obj.Text != ""){
        	formObj.f_cmd.value = SEARCHLIST13;
     		var sXml = sheetObj.GetSearchXml("ESM_MAS_0078GS.do", masFormQueryString(formObj));
     		var arrXml = sXml.split("|$$|");
     		if (arrXml.length > 0)
     		ComXml2ComboItem(arrXml[0], formObj.f_sls_ofc_cd, "code", "code");
     		formObj.f_sls_ofc_cd.Index=0;
        }
     }

    /**
     * T.VVD Period 가 선택되고 Trade, RLane이 모두 선택되었을때만 데이터를 조회한다.
     * Loading Port List, Period VVD List 를 조회한다.
     *
     * @return
     */
    function f_rlane_cd_OnChange(obj, code){
    	if (loadingMode == true) return;
    	var formObj = document.form;
    	var sheetObj = sheetObjects[0];
    	var param = "";

    	if(formObj.f_prd_cd[1].checked &&
    			getComboObjValue(formObj.f_trd_cd) != ""
//    		   && getComboObjValue(formObj.f_rlane_cd) != "" // Rlane이 선택되지 않으면 combo를 초기회 하기 위해서 사용하지 않음
    		   ){

    		formObj.f_cmd.value = SEARCHLIST12;
     		var sXml = sheetObj.GetSearchXml("ESM_MAS_0078GS.do", masFormQueryString(formObj));
     		var arrXml = sXml.split("|$$|");
     		if (arrXml.length > 0)
     			ComXml2ComboItem(arrXml[0], formObj.f_loc_cd, "code", "code");
     		if (arrXml.length > 1)
         		ComXml2ComboItem(arrXml[1], formObj.f_vvd_cd, "code", "code");
     		formObj.f_loc_cd.Index=0;
     		formObj.f_vvd_cd.Index=0;

    	}
    }

    /**
     * Loading Port 값 변경시 선택한 값을 REV POL에 입력한다.
     *
     * @return
     */
    function f_loc_cd_OnChange(obj, code){
    	if (loadingMode == true) return;
    	var formObj = document.form;

    	formObj.f_rev_pol_cd.value = getComboObjValue(formObj.f_loc_cd);
    }

    /**
     * Period VVD 값 변경시 선택한 값을  VVD에 입력한다.
     * @return
     */
    function f_vvd_cd_OnChange(obj, code){
    	if (loadingMode == true) return;
    	var formObj = document.form;
    	var f_vvd_cd = getComboObjValue(formObj.f_vvd_cd);

    	formObj.f_vsl_cd.value     = f_vvd_cd.substr(0,4);
    	formObj.f_skd_voy_no.value = f_vvd_cd.substr(4,4);
    	formObj.f_dir_cd.value     = f_vvd_cd.substr(8,1);
    }

    /**
     * T.VVD Period 가 선택되고 Trade, RLane, Dir 이 모두 선택되었을때만 데이터를 조회한다.
     * Loading Port List, Period VVD List 를 조회한다.
     * Dir콤보 onChange시 동작한다.
     *
     * @return
     */
    function f_skd_dir_cd_OnChange(obj, code){
    	 if (loadingMode == true) return;
    	 var formObj = document.form;
    	 f_rlane_cd_OnChange(obj);
    }
     function getComboObjValue(obj){
  	 	if (ComGetObjValue(obj) == "All") return "";
  	 	return ComGetObjValue(obj);
  	 }