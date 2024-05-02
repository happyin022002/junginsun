/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_1158.jsp
 *@FileTitle : pre-checking for code accurary
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.03.18
 *@LastModifier : 류대영
 *@LastVersion : 1.0
* --------------------------------------------------------
* History
 *2013.05.10 류대영 [CHM-201324514] Pre-checking for code accuracy 다운 엑셀 화면 보완 요청
 =========================================================*/

/*******************************************************************************
 * 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 * [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7 기타 여분의 문자상수
 * COMMAND01=11; ~ COMMAND20=30;
 ******************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview Arrival Notice - Customer Code Validate과 관련된 Script가 정의되어 있다.
 * @author Ryu Daeyoung
 */

/**
 * @extends
 * @class esm_bkg_1158 : esm_bkg_1158 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_1158() {
    this.processButtonClick     = tprocessButtonClick;
    this.setSheetObject         = setSheetObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;
    this.initControl            = initControl;
    this.doActionIBSheet        = doActionIBSheet;
    this.setTabObject           = setTabObject;
    this.validateForm           = validateForm;
    this.obj_keypress           = obj_keypress;
}

   /* 개발자 작업 */

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var sheetNames   = new Array("t1sheet1", "t2sheet1", "t1excel", "t2excel");
var sheetInits   = new Array(     false,      false,     false,     false);

// 화면 전역 변수
var unMatchGrpCntU = 0; // unmatch search count 그리드 우측 상단에 표시되는 조회 count(group마다
						// delete되므로 필요)
var delCntM = 0;  // match delete count
var currPageM = 1; // match page number
var pageResetM = true;

/* javascript interval identifier */
var intervalId;

/* customer code Popup을 호출한 row */
var popupRow = 0;

/* tab1의 condition을 저장해둔다. */
var t1s1CondParam = "";
var t1s1NotAvailCmd = -999999; // constant다 수정하면 안됨

/* 조회조건이 변경되었는지 저장해 둔다 */
var gQueryStrChange = true;

/* 이전 버튼 enable disable상태를 저장한다. */
var gButtonStatus = true;

/* Sheet에서 발생하는 키 이벤트 Code를 저장한다. */
var gKeyCode = -999;

/* 화면 Default Size를 기록한다. constant로 사용 */
var gRowHeight = 10;
var gColWidthMdmCustNm   = 125;
var gColWidthMdmCustAddr = 125;
var gColWidthBkgCustNm   = 125;
var gColWidthBkgCustAddr = 125;
var gColWidthValCustNm   = 125;

var gT2ColWidthValMdmCustNm = 155;
var gT2ColWidthValMdmCustAddr = 155;
var gT2ColWidthValBkgCustNm = 155;
var gT2ColWidthValBkgCustAddr = 155;

/* 조회조건을 저장하는 변수 (조회조건이 변경되었는지 검사할때 사용) */
var gSearchSchTp = "";
var gSearchVvd = "";
var gSearchVpsEtdDtStart = "";
var gSearchVpsEtdDtEnd = "";
var gSearchPodCd = "";
var gSearchTsFlg = "";
var gSearchDelCd = "";
var gSearchPolCd = "";
var gSearchBlNo = "";

/* 색상을 저장하는 변수 (성능을 위해서 상수값 처리 20100204) */
var gColorReadOnly = 15986927; // RgbColor (239,240,243)
var gColorMdmCust  = 13697005; // RgbColor (237,255,208)
var gColorEditable = 0       ; // RgbColor (0,0,0)
var gColorBkgCust  = 13697023; // RgbColor (255,255,208)
var gColorValCust  = 13692159; // RgbColor (255,236,208)
var gColorDisabled = 13816530; // RgbColor (210,210,210)

var gFontColorBlack = 0       ; // RgbColor (0,0,0)
var gFontColorBlue  = 16711680; // RgbColor (0,0,255)

// Evaluation할 때에 row의 height를 구해둔다. 기본값은 10이다.
var gEvaluationRowHeight = 10;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {void}
 * @return {void}
 * @author Ryu Daeyoung
 * @version 2013.03.18
 */
function processButtonClick(){
    /** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
    var shtCnt = 0;
    var formObject = document.form;

    try {
        var srcName = window.event.srcElement.getAttribute("name");
        if (!ComIsBtnEnable(srcName)) {return;}

        switch(srcName) {
            case "btn_vps_etd_dt":
            	formObject.sch_tp[1].checked = true;
            	fnToggleSchTp(formObject.sch_tp[1].value, formObject);
                var cal = new ComCalendarFromTo();
                cal.select(formObject.vps_etd_dt_start, formObject.vps_etd_dt_end, 'yyyy-MM-dd');
                break;

            case "btn_Retrieve":
                // POD를 Cookie에 남긴다.
                setInqueryDataToForm(false);
                var maxdate = new Date(9999, 12, 31);
                ComSetCookie("esm_bkg_1158_pol_cd" + "_" + strUsr_id , form.pol_cd.value, maxdate);
                doActionIBSheet(sheetObjects[0],formObject,IBSEARCH,"","");
                break;

            case "btn_DownExcel":
                   setInqueryDataToForm(true);
                   doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL,"","");
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
 * 배열은 소스 상단에 정의<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {Object}
 *            sheet_obj 필수, Sheet개체
 * @return {void}
 * @author Ryu Daeyoung
 * @version 2013.03.18
 */
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화<br>
 * body 태그의 onLoad 이벤트핸들러 구현<br>
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {void}
 * @return {void}
 * @author Ryu Daeyoung
 * @version 2013.03.18
 */
function loadPage() {
    var formObj = document.form;

    for(i=0;i<sheetNames.length;i++){
    	if(sheetNames[i] == "t1sheet1" ) {
    		sheetInit(i);
    	}
    }

    for(k=0;k<tabObjects.length;k++){
        initTab(tabObjects[k],k+1);
    }

    initControl();
    initMail();
}

/**
 * Sheet를 초기화 하는 함수 <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {int}
 *            idx 필수, Sheet의 인덱스
 * @return {void}
 * @author Ryu Daeyoung
 * @version 2013.03.18
 */
function sheetInit(idx) {
	if (sheetInits[idx] == false) {
        ComConfigSheet (sheetObjects[idx] );
        initSheet(sheetObjects[idx],idx+1);
        ComEndConfigSheet(sheetObjects[idx]);
        sheetInits[idx] = true;
    }
}
 
/**
 * 화면을 Loading한 후 처리를 수행 - 해당 Operation은 자동 실행됨<br>
 * 자동조회가 필요한 경우 처리를 수행<br>
 *
 * @param {Object}
 *            sheetObj 필수, 시트객체
 * @return void
 * @author Ryu Daeyoung
 * @version 2013.03.18
 */
function t1sheet1_OnLoadFinish(sheetObj) {
	sheetObj.RowHeight(0) = 10;
	sheetObj.RowHeight(1) = 10;
}

/**
 * 시트 초기설정값, 헤더 정의<br>
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호<br>
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {Object}
 *            sheetObj 필수, Sheet개체
 * @param {int}
 *            sheetNo 필수, Sheet Index
 * @return {void}
 * @author Ryu Daeyoung
 * @version 2013.03.18
 */
function initSheet(sheetObj,sheetNo) {
    var sheetID = sheetObj.id;
    var cnt = 0;

    switch(sheetID) {
        case "t1sheet1":
            with (sheetObj) {
                // 높이 설정
                style.height = 422;
                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;
                // style.width = 1200;
                // Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                // 전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

                // 전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(2, 1, 3, 100);

                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(21, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, false, false, false, false,false);

                var HeadTitle1 = "| |#||||Name & Address from Code Input|Name & Address from Code Input|Customer Information on B/L|Customer Information on B/L|Suggesting Code|Suggesting Code|Suggesting Code|Code for\n A/N|Evaluation|@|Type|B/L No|TP|BKG_NO|val_cd_backup";
                var HeadTitle2 = "| |#|||Code|Code Name|Code Address|B/L Name|B/L Address|Code|Code Name|Code Address|Code for\n A/N|Evaluation|@|Type|B/L No|TP|BKG_NO|val_cd_backup";

                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                InitHeadRow(1, HeadTitle2, true);

                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,
				// SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
				// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE,
				// TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,    0,                     daCenter,    false,       "ibflag");
                InitDataProperty(0, cnt++ , dtImage,          20,                     daCenter,    true,        "grp_img_idx",       false,        "",    dfNone,        0,        true,        true);
                InitDataProperty(0, cnt++ , dtData,           30,                     daCenter,    true,        "grp_seq_view",      false,        "",    dfNone,        0,        false,        false);
                InitDataProperty(0, cnt++ , dtHidden,          0,                     daCenter,    true,        "grp_seq",           false,        "",    dfNone,        0,        false,        false);
                InitDataProperty(0, cnt++ , dtHidden,          0,                     daCenter,    true,        "lvl_cd",            false,        "",    dfNone,        0,        false,        false);

                InitDataProperty(0, cnt++ , dtData,            68,                    daCenter,    true,        "mdm_cust_cd",       false,        "",    dfNone,        0,        false,        false);
                InitDataProperty(0, cnt++ , dtData,            gColWidthMdmCustNm,    daLeft,      true,        "mdm_cust_nm",       false,        "",    dfNone,        0,        false,        false);
                InitDataProperty(0, cnt++ , dtData,            gColWidthMdmCustAddr,  daLeft,      true,        "mdm_cust_addr",     false,        "",    dfNone,        0,        false,        false, -1, false, false);
                InitDataProperty(0, cnt++ , dtData,            gColWidthBkgCustNm,    daLeft,      true,        "bkg_cust_nm",       false,        "",    dfNone,        0,        false,        false);
                InitDataProperty(0, cnt++ , dtData,            gColWidthBkgCustAddr,  daLeft,      true,        "bkg_cust_addr",     false,        "",    dfNone,        0,        false,        false, -1, false, false);
                InitDataProperty(0, cnt++ , dtData,            68,                    daCenter,    true,        "val_cust_cd",       false,        "",    dfNone,        0,        false,        false);
                InitDataProperty(0, cnt++ , dtData,            gColWidthValCustNm,    daLeft,      true,        "val_cust_nm",       false,        "",    dfNone,        0,        false,        false);
                InitDataProperty(0, cnt++ , dtData,            gColWidthMdmCustAddr,  daLeft,      true,        "val_cust_addr",     false,        "",    dfNone,        0,        false,       false);

                InitDataProperty(0, cnt++ , dtHidden,          90,                    daLeft,      true,        "cor_cust_cd",       false,        "",    dfUserFormat,  0,        true,        true,     6);
                InitDataProperty(0, cnt++ , dtHidden,          90,                    daLeft,      true,        "val_cd",            false,        "",    dfNone,        0,        true,        false);
                InitDataProperty(0, cnt++ , dtHidden,          20,                    daCenter,    true,        "mail_img_idx",      false,        "",    dfNone,        0,        true,        true);
                InitDataProperty(0, cnt++ , dtData,            50,                    daCenter,    true,        "bkg_cust_tp_cd_view", false,      "",    dfNone,        0,        false,        false,   -1,   false,     false);
                InitDataProperty(0, cnt++ , dtData,            90,                    daCenter,    true,        "bl_no",             false,        "",    dfNone,        0,        false,        false,   -1,   false,     false);
                InitDataProperty(0, cnt++ , dtHidden,          0,                     daCenter,    true,        "bkg_cust_tp_cd",    false,        "",    dfNone,        0,        false,        false,   -1,   false,     false);
                InitDataProperty(0, cnt++ , dtHidden,          0,                     daCenter,    true,        "bkg_no",            false,        "",    dfNone,        0,        false,        false);

                InitDataProperty(0, cnt++ , dtHidden,          0,                     daCenter,    true,        "val_cd_backup",     false,        "",    dfNone,        0,        false,       false);
                InitUserFormat(0,"cor_cust_cd", "LL######", "");
//                InitDataCombo (0, "val_cd", evtValue, evtCode,"");

                ImageList(0)  =  "img/btng_plus.gif";
                ImageList(1)  =  "img/btng_minus.gif";
//                ImageList(2)  =  "img/btng_mail.gif";
                ShowButtonImage = 1;

                WordWrap = true;
// CountFormat = "[ SELECTDATAROW / SEARCHROWS ] [ TOTALROWS Groups ]";
// CountFormat = "[ TOTALROWS Groups ] [ Total SEARCHROWS Rows ]";
                CountFormat = "[ TOTALROWS Groups ]";
                RowHeight(0) = 10;
                RowHeight(1) = 10;

                // EditEnterBehavior="down";
                EnterBehavior="down";

                FrozenCols = 6;
                WaitImageVisible = false;
            }
            break;

        case "t2sheet1":
            with (sheetObj) {
                // 높이 설정
                style.height = 420;
                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                // Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                // 전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

                // 전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 3, 100);

                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(19, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, false, false, false, false,false);

                var HeadTitle1 = "|#|bkg_no|Customer Code|MDM Name|MDM Address|B/L Name|B/L Address|val_cd|Evaluation|Back to the Unmatch|Type|B/L No.|bkg_cust_tp_cd|Validate OFC|Evaluater||org_cust_cd|";

                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                InitHeadRow(1, HeadTitle2, true);

                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,
				// SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
				// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE,
				// TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,   30,                         daCenter,    false,       "ibflag");
                InitDataProperty(0, cnt++ , dtSeq,            30,                         daCenter,    true,        "Seq",             false,        "",    dfNone,        0,        true,        false);
                InitDataProperty(0, cnt++ , dtHidden,         60,                         daCenter,    true,        "bkg_no",          false,        "",    dfNone,        0,        false,       true);
                InitDataProperty(0, cnt++ , dtData,           95,                         daCenter,    true,        "mdm_cust_cd",     false,        "",    dfNone,        0,        false,       true);
                InitDataProperty(0, cnt++ , dtData,           gT2ColWidthValMdmCustNm,    daLeft,      true,        "mdm_cust_nm",     false,        "",    dfNone,        0,        false,       true);

                InitDataProperty(0, cnt++ , dtData,           gT2ColWidthValMdmCustAddr,  daLeft,      true,        "mdm_cust_addr",   false,        "",    dfNone,        0,        false,       true);
                InitDataProperty(0, cnt++ , dtData,           gT2ColWidthValBkgCustNm,    daLeft,      true,        "bkg_cust_nm",     false,        "",    dfNone,        0,        false,       true);
                InitDataProperty(0, cnt++ , dtData,           gT2ColWidthValBkgCustAddr,  daLeft,      true,        "bkg_cust_addr",   false,        "",    dfNone,        0,        false,       true);
                InitDataProperty(0, cnt++ , dtHidden,         0,                          daCenter,    true,        "val_cd",          false,        "",    dfNone,        0,        false,       true);
                InitDataProperty(0, cnt++ , dtData,           95,                         daCenter,    true,        "val_cd_nm",       false,        "",    dfNone,        0,        false,       true);

                InitDataProperty(0, cnt++ , dtHidden,        125,                         daCenter,    true,        "val_cd_img_idx",  false,        "",    dfNone,        0,        true,        true);
                InitDataProperty(0, cnt++ , dtData,           50,                         daCenter,    true,        "bkg_cust_tp_cd_view", false,    "",    dfNone,        0,        false,       false,   -1,   false,     false);
                InitDataProperty(0, cnt++ , dtData,           90,                         daCenter,    true,        "bl_no",           false,        "",    dfNone,        0,        false,       true);
                InitDataProperty(0, cnt++ , dtHidden,          0,                         daCenter,    true,        "bkg_cust_tp_cd",  false,        "",    dfNone,        0,        false,       true);  
                InitDataProperty(0, cnt++ , dtData,          125,                         daCenter,    true,        "val_ofc_cd",      false,        "",    dfNone,        0,        false,       true);
                InitDataProperty(0, cnt++ , dtData,           70,                         daCenter,    true,        "val_usr_nm",      false,        "",    dfNone,        0,        false,       true);

                InitDataProperty(0, cnt++ , dtHidden,          0,                         daCenter,    true,        "val_usr_id",      false,        "",    dfNone,        0,        false,       true);
                InitDataProperty(0, cnt++ , dtHidden,          0,                         daCenter,    true,        "org_cust_cd",     false,        "",    dfNone,        0,        false,       true);
                InitDataProperty(0, cnt++ , dtHidden,          0,                         daCenter,    true,        "dummy",           false,        "",    dfNone,        0,        false,       true);

                // CountPosition = 0;
                ImageList(0)  =  "img/btng_delete.gif";
                ShowButtonImage = 1;
                WordWrap = true;
                CountFormat = "[ SELECTDATAROW / TOTALROWS ]";
                RowHeight(0) = 10;
                EditEnterBehavior="down";
                EnterBehavior="down";
                WaitImageVisible = false;
            }
            break;
    }
}

/**
 * 조회조건이 변경되었는지 검사<br>
 * 엑셀인 경우 변경된 조회조건을 저장하지는 않고, 변경여부만 검사한다.<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {boolean}
 *            isExcel 필수, Excel을 위한 조회인지 여부
 * @return {void}
 * @author Ryu Daeyoung
 * @version 2013.03.18
 */
function setInqueryDataToForm(isExcel) {
	var formObj = document.form;
	var beChanged = false;

	var vSchTp = ""
	for(var i = 0; i < formObj.sch_tp.length; i ++) {
		if (formObj.sch_tp[i].checked) {
			vSchTp = formObj.sch_tp[i].value;
			break;
		}
	}

	if(gSearchSchTp            != vSchTp
	   || gSearchVvd           != formObj.vvd.value
	   || gSearchVpsEtdDtStart != formObj.vps_etd_dt_start.value
	   || gSearchVpsEtdDtEnd   != formObj.vps_etd_dt_end.value
	   || gSearchPodCd         != formObj.pod_cd.value
	   || gSearchTsFlg         != (formObj.ts_flg.checked?"Y":"N")
	   || gSearchDelCd         != formObj.del_cd.value
	   || gSearchPolCd         != formObj.pol_cd.value
	   || gSearchBlNo          != formObj.bl_no.value
			  )
	{
		beChanged = true;
	}
	if (!isExcel) { // 엑셀의 경우 화면에 입력된 조회조건을 저장변수에 넣으면 안된다.)
		gSearchSchTp         = vSchTp;
		gSearchVvd           = formObj.vvd.value;
		gSearchVpsEtdDtStart = formObj.vps_etd_dt_start.value;
		gSearchVpsEtdDtEnd   = formObj.vps_etd_dt_end.value;
		gSearchPodCd         = formObj.pod_cd.value;
		gSearchTsFlg         = formObj.ts_flg.checked?"Y":"N";
		gSearchDelCd         = formObj.del_cd.value;
		gSearchPolCd         = formObj.pol_cd.value;
		gSearchBlNo          = formObj.bl_no.value;
	}

	gQueryStrChange = beChanged;
}

/**
 * Sheet관련 프로세스 처리<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {Object}
 *            sheetObj 필수, Sheet개체
 * @param {Object}
 *            formObj 필수, 폼개체
 * @param {String}
 *            sAction 필수, 작업코드
 * @param {String}
 *            CondParam 선택, 이전 조회 조건정보
 * @param {int}
 *            pageNo 선택, 페이지 번호
 * @return {void}
 * @author Ryu Daeyoung
 * @version 2013.03.18
 */
function doActionIBSheet(sheetObj,formObj,sAction,CondParam,PageNo) {
    // sheetObj.ShowDebugMsg = false;

    switch(sAction) {
        case IBSEARCH:      // 조회
            if(validateForm(sheetObj,formObj,sAction)){
            	ComOpenWait(true);
                formObj.f_cmd.value = t1s1NotAvailCmd;
                t1s1CondParam = FormQueryString(formObj);
            	if (beforetab == 0) { // UnMatch
                	sheetObjects[0].DoSearch("ESM_BKG_1158GS.do"
                                             ,t1s1CondParam.replace("f_cmd=" + t1s1NotAvailCmd, "f_cmd=" + SEARCH05)
                                               + "&mtch_chk_flg=N"
                                             ,"page_no=1"
                                             , false );
                } else { // Match
                	pageResetM = true;
                    sheetObjects[1].DoSearch("ESM_BKG_1158GS.do"
                                             ,t1s1CondParam.replace("f_cmd=" + t1s1NotAvailCmd, "f_cmd=" + SEARCH06)
                                               + "&mtch_chk_flg=Y"
                                             ,"page_no=1"
                                             , false );
                }

            	ComOpenWait(false);
            }
            break;

        case IBSEARCHAPPEND:
            if ( sheetObj.id == "t1sheet1"){
                sheetObj.DoSearch("ESM_BKG_1158GS.do"
                       , CondParam + "&mtch_chk_flg=N"
                       ,"page_no=" + PageNo
                       , true
                );
            }
            else if ( sheetObj.id == "t2sheet1"){
               sheetObj.DoSearch("ESM_BKG_1158GS.do"
                      , CondParam + "&mtch_chk_flg=Y"
                      ,"page_no=" + PageNo
                      , true
               );
            }
            break;
            
        case IBDOWNEXCEL:   // EXCEL 다운로드
            if (gQueryStrChange == true) {
                ComShowCodeMessage("BKG03053");
                return;
            }

        	// 20130510 CHM-201324514 Pre-checking for code accuracy 다운 엑셀 화면 보완 요청
            if (beforetab == 0) {
            	sheetObjects[0].Down2Excel(-1);
            }else {
            	sheetObjects[1].Down2Excel(-1);
            }
            break;
    }
}

/**
 * DoActionIBSheet의 Sub Function으로 동작한다.<br>
 * tab1에 대한 처리를 수행한다.<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {Object}
 *            sheetObj 필수, sheet개체
 * @param {String}
 *            sQueryString 필수, HTML String
 * @param {String}
 *            sSheetType 필수, A 둘다/ U unmatch/ M match)
 * @return {void}
 * @author Ryu Daeyoung
 * @version 2013.03.18
 */
function doActionValidationResult(sheetObj, sQueryString, sSheetType) {
    var queryString = sQueryString.replace("f_cmd=" + t1s1NotAvailCmd, "f_cmd=" + SEARCH05);
    var sXml = sheetObjects[2].GetSearchXml("ESM_BKG_1158GS.do" , queryString);
    var sJbStsFlg = "";

    if (sXml == "") {
    	// 서버가 내려간 경우 조회할 동안 해당과 같이 데이터가 들어온다.
        clearInterval(intervalId);
        // 오류가 났으므로 재조회 하도록 한다.
        ComShowCodeMessage("BKG01075");
    	ComOpenWait(false);
        fnBtnEnable(true);
        return;
    }

    // 에러가 발생했을 경우 대기상태를 종료한다.
    var txState = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
    if (txState == "F") {
        clearInterval(intervalId);
        // 오류가 났으므로 재조회 하도록 한다.
        ComShowCodeMessage("BKG01075");
        ComOpenWait(false);
        fnBtnEnable(true);
        return;
    }

    sJbStsFlg = ComGetEtcData(sXml, "jb_sts_flg");
    if (sJbStsFlg == "3" || sJbStsFlg == "4") {
        clearInterval(intervalId);
        sheetObjects[1].RemoveAll();
        sheetObjects[0].LoadSearchXml(sXml);
        fnBtnEnable(true);
        delCntM = 0;
        currPageM = 1;
        pageResetM = true;
        if (sJbStsFlg == "4") {
            // 오류가 났으므로 재조회 하도록 한다.
            ComShowCodeMessage("BKG01075");
            return;
        }
    }

    // unmatch로 변경하고 화면을 조정한다.
    tabObjects[0].selectedIndex = 0;
}

/**
 * IBTab Object를 배열로 등록<br>
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
 * 배열은 소스 상단에 정의<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {Object}
 *            tabObj 필수, tab개체
 * @return {void}
 * @author Ryu Daeyoung
 * @version 2013.03.18
 */
function setTabObject(tabObj){
    tabObjects[tabCnt++] = tabObj;
}

/**
 * Tab 기본 설정<br>
 * 탭의 항목을 설정한다.<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {Object}
 *            tabObj 필수, tab개체
 * @param {int}
 *            nItem 필수, index
 * @return {void}
 * @author Ryu Daeyoung
 * @version 2013.03.18
 */
function initTab(tabObj , tabNo) {
    switch(tabNo) {
        case 1:
            with (tabObj) {
                var cnt  = 0 ;
                InsertTab( cnt++ , "Not-Evaluated" , -1 );
                InsertTab( cnt++ , "Evaluated" , -1 );
            }
            break;
    }
}

/**
 * Tab 클릭시 이벤트 관련<br>
 * 선택한 탭의 요소가 활성화 된다.<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {Object}
 *            tabObj 필수, tab개체
 * @param {int}
 *            nItem 필수, index
 * @return {void}
 * @author Ryu Daeyoung
 * @version 2013.03.18
 */
function tab1_OnChange(tabObj , nItem){
    var objs = document.all.item("tabLayer");

    objs[nItem].style.display = "Inline";
    objs[beforetab].style.display = "none";

    // --------------- 요기가 중요 --------------------------//
    objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    // ------------------------------------------------------//
    beforetab= nItem;

    // ----------------------------------------------------
    // TAB2 선택
    // 1.tab2 선택시 VVD 항목으로 focus on
    // 2.이전 조회된 POD 가 있을경우 POD 출력(Cookie)이용
    // ----------------------------------------------------
    if (beforetab == 1) {
    	// 초기화를 늦춰서 tab이 변경될 때에 초기화 한다.
    	sheetInit(1);
    }
    fnBtnEnable(gButtonStatus);
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {Object}
 *            sheetObj 필수, Sheet개체
 * @param {Object}
 *            formObj 필수, 폼개체
 * @param {int}
 *            sAction 필수, 작업코드
 * @return {boolean} Validation 결과값
 * @author Ryu Daeyoung
 * @version 2013.03.18
 */
function validateForm(sheetObj,formObj,sAction){
    var formObj = document.form;
    switch (sAction){
        case IBSEARCH:
        	if (formObj.sch_tp[0].checked == true) {
	            if (formObj.vvd.value.trim() == ""
	           	    || formObj.pol_cd.value.trim() == "") {
	           	    ComShowCodeMessage("BKG01101", "VVD and POL");
	           	    ComSetFocus(formObj.vvd);
	           	    return false;
	            }
        	}else if (formObj.sch_tp[1].checked == true) {
	            if (formObj.vps_etd_dt_start.value.trim() == ""
	            	|| formObj.vps_etd_dt_end.value.trim() == ""
	           	    || formObj.pol_cd.value.trim() == "") {
	           	    ComShowCodeMessage("BKG01101", "POL");
	           	    ComSetFocus(formObj.vps_etd_dt_start);
	           	    return false;
	            }
        	}

        	if(!ComChkValid(formObj)) return false;

            // VVD, Duration일 경우 검사한다.
            if (formObj.sch_tp[2].checked == false) {
            	// maximum 7 day
                if(ComGetDaysBetween(formObj.vps_etd_dt_start.value,formObj.vps_etd_dt_end.value) > 6){
                    ComShowCodeMessage("BKG40008", "7");
                    ComSetFocus(formObj.vps_etd_dt_end);
                    return false;
                }
                // del는 2또는 5자리만 입력 가능
                if(formObj.del_cd.value.length > 2 && formObj.del_cd.value.length <5) {
                    ComShowCodeMessage("BKG40009");
                    ComSetFocus(formObj.del_cd);
                    return false;
                }
            }
            break;
    }
    return true;
}

/**
 * 초기화 작업 : 이벤트를 등록한다.<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {void}
 * @return {void}
 * @author Ryu Daeyoung
 * @version 2013.03.18
 */
function initControl() {
    // Axon 이벤트 처리1. 이벤트catch
    axon_event.addListenerForm('click', 'objClick', form );     // - form 전체 컨트롤
																// 중 dataformat
																// 속성이 있는 모든
																// 컨트롤의
																// onkeypress
																// 이벤트에 코드 처리
    axon_event.addListenerForm('keyup', 'objKeyUp', form );     // - form 전체 컨트롤
																// 중 dataformat
																// 속성이 있는 모든
																// 컨트롤의
																// onkeypress
																// 이벤트에 코드 처리
    axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
    axon_event.addListenerForm('keypress', 'objKeyPress', form);

    // 화면 초기화 정보등을 입력한다.
    var formObj = document.form;
    var sPolCd = ComGetCookie("esm_bkg_1158_pol_cd" + "_" + strUsr_id);
    formObj.pol_cd.value = sPolCd;
    formObj.vps_etd_dt_start.value=ComGetNowInfo('ymd','-');
    formObj.vps_etd_dt_end.value=ComGetNowInfo('ymd','-');
}

/**
 * 화면 개체에 클릭했을 때의 이벤트 처리<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {void}
 * @return {void}
 * @author Ryu Daeyoung
 * @version 2013.03.18
 */
function objClick() {
    var objName = event.srcElement.name;
    var formObj = document.form;
    switch(objName) {
        case "sch_tp":
            var vSchTp = "";
            for (var i=0; i<formObj.sch_tp.length; i++) {
                if (formObj.sch_tp[i].checked) {
                    vSchTp = formObj.sch_tp[i].value;
                }
            }
            formObj.sch_tp.value = vSchTp;
            // setInqueryDataToForm(); // change event가 정상적으로 동작하지 않아 click
			// event로 변경
            fnToggleSchTp(vSchTp, formObj);
            break;
        case "vvd":
        	formObj.sch_tp[0].checked = true;
        	fnToggleSchTp(formObj.sch_tp[0].value, formObj);
        	break;
        case "vps_etd_dt_start":
        	formObj.sch_tp[1].checked = true;
        	fnToggleSchTp(formObj.sch_tp[1].value, formObj);
        	break;
        case "vps_etd_dt_end":
        	formObj.sch_tp[1].checked = true;
        	fnToggleSchTp(formObj.sch_tp[1].value, formObj);
        	break;
        case "bl_no":
        	formObj.sch_tp[2].checked = true;
        	fnToggleSchTp(formObj.sch_tp[2].value, formObj);
        	break;
        case "ts_flg":
        	gQueryStrChange = true;
        	break;
    }
}

/**
 * 개체에서 키보드를 눌렀을때 발생하는 이벤트를 처리<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {void}
 * @return void
 * @author Ryu Daeyoung
 * @version 2013.03.18
 */
function objKeyPress() {
    var objName = event.srcElement.name;
    var formObj = document.form;
    switch(objName) {
	    case "vvd":
		    ComKeyOnlyAlphabet('uppernum');
		    break;
	    case "pol_cd":
	    	ComKeyOnlyAlphabet('uppernum');
		    break;
	    case "pod_cd":
	    	ComKeyOnlyAlphabet('uppernum');
		    break;
	    case "del_cd":
	    	ComKeyOnlyAlphabet('uppernum');
		    break;
	    case "bl_no":
	    	ComKeyOnlyAlphabet('uppernum');
		    break;
	    case "ofc_cd":
	    	ComKeyOnlyAlphabet('upper');
		    break;
	    case "vps_etd_dt_start":
	    	obj_KeyPress(event.srcElement);
		    break;
	    case "vps_etd_dt_end":
	    	obj_KeyPress(event.srcElement);
		    break;
    }
}

/**
 * sch_tp를 변경할 때에 조정되어야 할 화면 속성들을 정의한다.<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {String}
 *            vSchTp 필수, 조회조건 radio값
 * @param {String}
 *            formObj 필수, 폼개체
 * @return {void}
 * @author Ryu Daeyoung
 * @version 2013.03.18
 */
function fnToggleSchTp (vSchTp, formObj) {
    if (vSchTp=="B") {  // BL
    	document.getElementsByName("bl_no")[0].setAttribute("required", true);
        document.getElementsByName("pol_cd")[0].removeAttribute("fullfill");
        document.getElementsByName("pol_cd")[0].removeAttribute("required");
        document.getElementsByName("vvd")[0].removeAttribute("required");
        document.getElementsByName("vvd")[0].removeAttribute("fullfill");
        document.getElementsByName("vps_etd_dt_start")[0].removeAttribute("required");
    } else if (vSchTp=="V") {
        document.getElementsByName("bl_no")[0].removeAttribute("required");
        document.getElementsByName("pol_cd")[0].setAttribute("fullfill", true);
        document.getElementsByName("pol_cd")[0].setAttribute("required", true);
        document.getElementsByName("vvd")[0].setAttribute("required", true);
        document.getElementsByName("vvd")[0].setAttribute("fullfill", true);
        document.getElementsByName("vps_etd_dt_start")[0].removeAttribute("required");
        document.getElementsByName("vps_etd_dt_end")[0].removeAttribute("required");
    }else if (vSchTp=="D") {
        document.getElementsByName("bl_no")[0].removeAttribute("required");
        document.getElementsByName("pol_cd")[0].setAttribute("fullfill", true);
        document.getElementsByName("pol_cd")[0].setAttribute("required", true);
        document.getElementsByName("vvd")[0].removeAttribute("required");
        document.getElementsByName("vvd")[0].removeAttribute("fullfill");
        document.getElementsByName("vps_etd_dt_start")[0].setAttribute("required", true);
        document.getElementsByName("vps_etd_dt_end")[0].setAttribute("required", true);
    }
}

/**
 * Mail정보를 초기화 한다.<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {void}
 * @return {void}
 * @author Ryu Daeyoung
 * @version 2013.03.18
 */
function initMail() {
    var formObj = document.form;
    formObj.strUsr_nm.value = strUsr_nm;
    formObj.strUsr_email.value = strUsr_email;
    formObj.strOfc_cd.value = strOfc_cd;
}

/**
 * 수직스크롤바가 바닥에 닿았을 때 발생하는 이벤트 Catch<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {Object}
 *            sheetObj 필수, sheet개체
 * @param {String}
 *            CondParam 사용안함,
 * @param {String}
 *            PageNo 사용안함,
 * @param {String}
 *            OnePageRows 사용안함,
 * @return {void}
 * @author Ryu Daeyoung
 * @version 2013.03.18
 */
function t2sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
	currPageM += 1;
	alert("currPageM += 1:"+currPageM);
	doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, t1s1CondParam.replace("f_cmd=" + t1s1NotAvailCmd, "f_cmd=" + SEARCH06) + "&sheet_del_cnt=" + delCntM , currPageM);
}

/**
 * Customer Validation Sheet 클릭시 발생하는 Event<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {Objet}
 *            sheetObj 필수, Sheet개체
 * @param {int}
 *            row 필수, 행
 * @param {int}
 *            col 필수, 열
 * @return {void}
 * @author Ryu Daeyoung
 * @version 2013.03.18
 */
function t1sheet1_OnClick(sheetObj, row, col) {
    var colName = sheetObj.ColSaveName(col);
    var dtValue = sheetObj.CellValue(row,col);

    switch(colName) {
        case "grp_img_idx":
        	var cellImageIdx = sheetObj.CellImage(row, col);
        	if ( cellImageIdx > -1) {
        		var maxrow = sheetObj.LastRow;
        		for (var i = row + 1; i < maxrow; i ++) {
        			if (sheetObj.CellValue(row, "grp_seq").parseInt() == sheetObj.CellValue(i, "grp_seq").parseInt()) {
        				if (cellImageIdx == 0) { // 현재 hidden임
        					sheetObj.RowHidden(i) = false;
        				} else {
        					sheetObj.RowHidden(i) = true;
        				}
        			} else {
        				break;
        			}
        		}

        		if (cellImageIdx == 0) {
        			sheetObj.CellImage(row, col) = 1;
        		} else {
        			sheetObj.CellImage(row, col) = 0;
        		}
        	}
        	break;
        case "val_cust_nm":
            gEvaluationRowHeight = sheetObj.RowHeight(row);
            break;
        case "val_cd":
            gEvaluationRowHeight = sheetObj.RowHeight(row);
            break;
        case "val_cust_nm":
            gEvaluationRowHeight = sheetObj.RowHeight(row);
            break;
        case "cor_cust_cd":
            gEvaluationRowHeight = sheetObj.RowHeight(row);
            break;
        default:
            gEvaluationRowHeight = sheetObj.RowHeight(row);
            break;
    }
}

/**
 * unmatch 시트의 마우스 더블클릭 이벤트를 처리한다.<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {Objet}
 *            sheetObj 필수, Sheet개체
 * @param {int}
 *            row 필수, 행
 * @param {int}
 *            col 필수, 열
 * @return {void}
 * @author Ryu Daeyoung
 * @version 2013.03.18
 */
function  t1sheet1_OnDblClick(sheetObj, row, col) {
    var colName = sheetObj.ColSaveName(col);
    var dtValue = sheetObj.CellValue(row,col);
    
    switch(colName) {
        case "mdm_cust_cd":
        	if (sheetObj.CellValue(row, "lvl_cd").parseInt() == 1
                 && dtValue != "") {
                // Not-Existence가 아닌 경우만 처리한다.
                if (sheetObj.CellValue(row, "val_cd") != "N"
                	 && sheetObj.CellValue(row, "val_cd") != "O"
                     && sheetObj.CellValue(row, "val_cd") != "S" ) {

                	var rowHeight = sheetObj.RowHeight(row);
                	sheetObj.CellValue2(row, "cor_cust_cd") = dtValue;
                	sheetObj.RowHeight(row) = rowHeight;
                	var rtnVal = fnValCdOperation(sheetObj, row, col);
                    if (rtnVal) {
                        sheetObj.CellValue2(row, "val_cd_backup") = sheetObj.CellValue(row, "val_cd");
                    }
                }
            }
            break;
        case "val_cust_cd":
            if (sheetObj.CellValue(row, "lvl_cd").parseInt() == 1
                    && dtValue != "") {
                // OK, Not-Existence가 아닌 경우만 처리한다.
                if (sheetObj.CellValue(row, "val_cd") != "N"
                      && sheetObj.CellValue(row, "val_cd") != "O"
                      && sheetObj.CellValue(row, "val_cd") != "S") {
                	var rowHeight = sheetObj.RowHeight(row);
                	sheetObj.CellValue2(row, "cor_cust_cd") = dtValue;
                	var rtnVal = fnValCdOperation(sheetObj, row, col);
                	sheetObj.RowHeight(row) = rowHeight;
                    if (rtnVal) {
                        sheetObj.CellValue2(row, "val_cd_backup") = sheetObj.CellValue(row, "val_cd");
                    }
                }
            }
            break;
        case "mdm_cust_nm":
            if (dtValue != "") {
                fnToggleCellSize(sheetObj, row, col, gRowHeight,  gColWidthMdmCustNm);
            }
            break;
        case "mdm_cust_addr":
            if (dtValue != "") {
                fnToggleCellSize(sheetObj, row, col, gRowHeight,  gColWidthMdmCustAddr);
            }
            break;
        case "bkg_cust_nm":
            if (dtValue != "") {
                fnToggleCellSize(sheetObj, row, col, gRowHeight,  gColWidthBkgCustNm);
            }
            break;
        case "bkg_cust_addr":
            if (dtValue != "") {
                fnToggleCellSize(sheetObj, row, col, gRowHeight,  gColWidthBkgCustAddr);
            }
            break;
        case "val_cust_nm":
            if (dtValue != "") {
                fnToggleCellSize(sheetObj, row, col, gRowHeight,  gColWidthValCustNm);
            }
            break;
        case "val_cust_addr":
            if (dtValue != "") {
                fnToggleCellSize(sheetObj, row, col, gRowHeight,  gColWidthValCustNm);
            }
            break;
        case "bl_no":
			if (sheetObj.CellValue(row, "bkg_no").trim() == "") { return; }

			var bkgNo = sheetObj.CellValue(row, "bkg_no");
        	var sUrl = "/hanjin/alpsMain.screen";
        	sUrl += "?parentPgmNo=ESM_BKG_M001";
        	sUrl += "&pgmUrl=^hanjin^ESM_BKG_0079.do";
        	sUrl += "&pgmNo=ESM_BKG_0079";
        	sUrl += "&bkg_no="+bkgNo;
        	sUrl += "&openTab=B5";
        	ComOpenWindowCenter(sUrl, "ESM_BKG_0079", 1024, 700, true, 'yes');
        	break;
    }
}

/**
 * match 시트의 마우스 더블클릭 이벤트를 처리한다.<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {Objet}
 *            sheetObj 필수, Sheet개체
 * @param {int}
 *            row 필수, 행
 * @param {int}
 *            col 필수, 열
 * @return {void}
 * @author Ryu Daeyoung
 * @version 2013.03.18
 */
function  t2sheet1_OnDblClick(sheetObj, row, col) {
    var colName = sheetObj.ColSaveName(col);
    var dtValue = sheetObj.CellValue(row,col);

    switch(colName) {
        case "mdm_cust_nm":
            if (dtValue != "") {
                fnToggleCellSize(sheetObj, row, col, gRowHeight,  gT2ColWidthValMdmCustNm);
            }
            break;
        case "mdm_cust_addr":
            if (dtValue != "") {
                fnToggleCellSize(sheetObj, row, col, gRowHeight,  gT2ColWidthValMdmCustAddr);
            }
            break;
        case "bkg_cust_nm":
            if (dtValue != "") {
                fnToggleCellSize(sheetObj, row, col, gRowHeight,  gT2ColWidthValBkgCustNm);
            }
            break;
        case "bkg_cust_addr":
            if (dtValue != "") {
                fnToggleCellSize(sheetObj, row, col, gRowHeight,  gT2ColWidthValBkgCustAddr);
            }
            break;
        case "bl_no":
			var bkgNo = sheetObj.CellValue(row, "bkg_no");
        	var sUrl = "/hanjin/alpsMain.screen";
        	sUrl += "?parentPgmNo=ESM_BKG_M001";
        	sUrl += "&pgmUrl=^hanjin^ESM_BKG_0079.do";
        	sUrl += "&pgmNo=ESM_BKG_0079";
        	sUrl += "&bkg_no="+bkgNo;
        	sUrl += "&openTab=B5";
        	ComOpenWindowCenter(sUrl, "ESM_BKG_0079", 1024, 700, true, 'yes');
        	break;
    }
}

/**
 * Unmatch Case Sheet에서 Click Event발생시 동작할 내용 처리<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {Objet}
 *            sheetObj 필수, Sheet개체
 * @param {Object}
 *            formObj 필수, 폼개체
 * @param {int}
 *            row 필수, 행
 * @param {int}
 *            col 필수, 열
 * @param {int}
 *            defRowHeight 필수, 높이
 * @param {int}
 *            defColWidth 필수, 너비
 * @return {void}
 * @author Ryu Daeyoung
 * @version 2013.03.18
 */
function fnToggleCellSize(sheetObj, row, col, defRowHeight, defColWidth) {
    var colName = sheetObj.ColSaveName(col);

    if (sheetObj.RowHeight(row) == defRowHeight && sheetObj.ColWidth(col) == defColWidth) {
        sheetObj.RowHeight(row) = 0;
        sheetObj.ColWidth(col) = defColWidth;
    } else {
        sheetObj.RowHeight(row) = defRowHeight;
        sheetObj.ColWidth(col) = defColWidth;
    }
}

/**
 * Match Case Sheet에서 Click Event발생시 동작할 내용 처리<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {Objet}
 *            sheetObj 필수, Sheet개체
 * @param {Object}
 *            formObj 필수, 폼개체
 * @param {int}
 *            row 필수, 행
 * @param {int}
 *            col 필수, 열
 * @return {void}
 * @author Ryu Daeyoung
 * @version 2013.03.18
 */
function t2sheet1_OnClick(sheetObj, row, col) {
    var colName = sheetObj.ColSaveName(col);
    var dtValue = sheetObj.CellValue(row ,col);
    switch(colName) {
        case "val_usr_nm":
        	var valUsrNm = sheetObj.CellValue(row, "val_usr_nm");
        	if (valUsrNm.trim() != "") {
                ComUserPopup(sheetObj.CellValue(row, "val_usr_id"));
        	}
        	break;
    }
}
 
/**
 * Unmatch case의 조회 이후 처리<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {Object}
 *            sheetObj 필수, Sheet개체
 * @param {String}
 *            errStr 필수, 메시지 문자열
 * @return void
 * @author Ryu Daeyoung
 * @version 2013.03.18
 */
function t1sheet1_OnSearchEnd(sheetObj, errStr) {
    var startRow = 2;
    var maxRow = sheetObj.LastRow;

    sheetObj.RowHeight(1) = 10;

    if (sheetObj.RowCount == 0) {
    	unMatchGrpCntU = 0;
    	sheetObj.TotalRows =  unMatchGrpCntU;
    	ComOpenWait(false);
    	return; // 조회된 데이터가 없으면 빠져나간다.
    }

    for (var idx = 2; idx<= maxRow; idx ++ ) {
    	sheetObj.RowHeight(idx) = 10;

    	if (sheetObj.CellValue(idx, "lvl_cd").parseInt() == 2) {
    		sheetObj.RowEditable(idx) = false;
    		sheetObj.RowHidden(idx) = true;
    	} else {
    		fnt1sheet1CellBackColor(sheetObj, idx, false);
    		fnt1sheet1CellFont(sheetObj, idx);
    		with (sheetObj) {
    			CellFont("FontBold", idx,"val_cust_cd") = true;
    			CellFont("FontBold", idx,"mdm_cust_cd") = true;
    			CellFont("FontBold", idx,"cor_cust_cd") = true;
    		}
    	}
    	sheetObj.CellFontUnderline(idx,"bl_no") = true;
    }

    // delete시 재조회를 하지 않기 위해 global변수에 unmatch개수를 저장한다.
    unMatchGrpCntU = sheetObj.CellValue(maxRow, "grp_seq").parseInt();
    sheetObj.TotalRows =  unMatchGrpCntU;
    ComOpenWait(false);
}

/**
 * match Tab에 데이터 Search후 처리<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {Object}
 *            sheetObj 필수, Sheet개체
 * @param {String}
 *            errStr 필수, 메시지 문자열
 * @return void
 * @author Ryu Daeyoung
 * @version 2013.03.18
 */
function t2sheet1_OnSearchEnd(sheetObj, errStr) {
    var startRow = 1;
    var maxRow = sheetObj.LastRow;

    if (pageResetM) {
		delCntM = 0;
	    currPageM = 1;
	    pageResetM = false;
    }

    sheetObj.RowHeight(0) = 10;
    if (maxRow < 100) {
        startRow = 1;
    } else if ((maxRow%100.0) == 0 ) {
        startRow = maxRow - 100 ;
        if (startRow < 1) {
            startRow = 1;
        }
    } else {
        startRow = maxRow - ((maxRow - 1.0)%100.0);
    }

    // IB Sheet가 발생시키는 문제로 인해 해당 영역 수정
    for (var i = 1; i< startRow; i ++ ) {
        sheetObj.RowHeight(i) = 10;
    }

    if (startRow - delCntM >= 1) {
    	startRow -= delCntM;
    }

    for (var idx = startRow; idx <= maxRow; idx ++) {
        // Auto Match가 아닌 것은 Bold 처리 (2009-08-21 - 심영우과장 요청)
        if (sheetObj.CellValue(idx, "val_cd") != "A" && sheetObj.CellValue(idx, "val_cd") != "C") {
            sheetObj.CellFont("FontBold", idx,"bkg_no", idx, "bl_no") = true;
        }

        if (sheetObj.CellValue(idx, "val_cd_img_idx") == -1) {
            fnT2sheet1CellBackColor(sheetObj, idx, false);
            sheetObj.CellEditable(idx, "val_cd_img_idx") = false;
        } else {
            fnT2sheet1CellBackColor(sheetObj, idx, true);
            sheetObj.CellEditable(idx, "val_cd_img_idx") = true;
        }

        sheetObj.CellFontUnderline(idx,"bl_no") = true;
        sheetObj.RowHeight(idx) = 10;
    }
    ComOpenWait(false);
}
 
 /**
	 * 사용자의 오퍼레이션에 따라 Cell의 값 변경 및 propagate를 처리하고, Cell Font 등을 설정한다.<br>
	 * <br>
	 * <b>Example : </b>
	 *
	 * <pre>
  * </pre>
	 *
	 * @param {Object}
	 *            sheetObj 필수, Sheet개체
	 * @param {int}
	 *            row 필수, row번호
	 * @return {void}
	 * @author Ryu Daeyoung
	 * @version 2013.03.18
	 */
function fnSetCopyEvaluatation(sheetObj, row) {
    var vMax = sheetObj.LastRow;
    var vCorCustCd = sheetObj.CellValue(row, "cor_cust_cd");
    var vGrpSeq = sheetObj.CellValue(row, "grp_seq");
    var vValCd = sheetObj.CellValue(row, "val_cd");
    var vRowHeight = 0;  // 변경전 row의 높이를 저장

    for(var idx = row; idx <= vMax; idx ++) {
        /* 그룹번호가 다르면, 작업을 종료한다. */
    	if (vGrpSeq != sheetObj.CellValue(idx, "grp_seq")) {
    		break;
    	}

        /*
		 * 공통 row높이를 저장
		 */
    	vRowHeight = sheetObj.RowHeight(idx);
        sheetObj.CellValue2(idx, "val_cd") = vValCd;

        /* 사용자에 의해 Evaluation되는 개체 */
        if (idx == row) {
        	/* Background Color 처리 */
        	if (vValCd == "" || vValCd == "-") {
        		fnt1sheet1CellBackColor(sheetObj, idx, false);
        	} else {
        		fnt1sheet1CellBackColor(sheetObj, idx, true);
        	}

        	/* Editable 처리 */
        	if (vValCd == "N") {
        	    sheetObj.CellEditable(idx,"cor_cust_cd") = false;
        	    // sheetObj.CellEditable(idx,"val_cd") = false; // 메일을 발송하고 나면
				// disable한다.
        	} else if(vValCd == "O" || vValCd == "S") {
        	    sheetObj.CellEditable(idx,"cor_cust_cd") = false;
        	} else {
        		sheetObj.CellEditable(idx,"cor_cust_cd") = true;
        	}

        	/* Font 처리 */
            fnt1sheet1CellFont(sheetObj, idx);
        }

        /* Propagate되는 개체 */
        if (vValCd == "O" || vValCd == "S") { // OK, SKIP
        	sheetObj.CellValue2(idx, "cor_cust_cd") = sheetObj.CellValue(idx, "mdm_cust_cd"); // 원
																								// 입력값
    	} else if (vValCd == "N") { // Not-Existence
    		sheetObj.CellValue2(idx, "cor_cust_cd") = "";  // 초기화
        } else {
        	sheetObj.CellValue2(idx, "cor_cust_cd") = vCorCustCd; // Evaluation한
																	// 값
        }

        /*
		 * 공통 처리 validation 정보가 없어진 경우에는 R상태로 변경 row높이를 복원
		 */
        if ((vValCd == "-" || vValCd == "" ) && vCorCustCd.trim() == "") {
        	sheetObj.RowStatus(idx) = "R";
        }
        sheetObj.RowHeight(idx) = vRowHeight;
    }
}


/**
 * 화면 전체에 대한 버튼 사용 가능 처리 프로세스<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {boolean}
 *            flac 필수, Enable/Disable
 * @return {void}
 * @author Ryu Daeyoung
 * @version 2013.03.18
 */
function fnBtnEnable( flag) {
    if (flag == true) {
        ComBtnEnable("btn_Retrieve");
        ComBtnEnable("btn_DownExcel");
    } else {
        ComBtnDisable("btn_Retrieve");
        ComBtnDisable("btn_DownExcel");
    }
    gButtonStatus = flag;
}

/**
 * unmatch 시트의 row의 background color를 설정한다.<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {Object}
 *            sheetObj 필수, Sheet개체
 * @param {int}
 *            row 필수, 선택된 Cell
 * @param {boolean}
 *            bSelect 필수, 셀이 선택되었는지 여부
 * @return {void}
 * @author Ryu Daeyoung
 * @version 2013.03.18
 */
function fnt1sheet1CellBackColor(sheetObj, row, bSelect) {
    with(sheetObj) {
        if (bSelect == false) {
        	CellBackColor(row, "grp_img_idx") = gColorReadOnly;
        	CellBackColor(row, "grp_seq_view") = gColorReadOnly;
        	CellBackColor(row, "mdm_cust_cd") = gColorMdmCust;
            CellBackColor(row, "mdm_cust_nm") = gColorMdmCust;
            CellBackColor(row, "mdm_cust_addr") = gColorMdmCust;

            CellBackColor(row, "bkg_cust_nm") = gColorBkgCust;
            CellBackColor(row, "bkg_cust_addr") = gColorBkgCust;

            CellBackColor(row, "val_cust_cd") = gColorValCust;
            CellBackColor(row, "val_cust_nm") = gColorValCust;
            CellBackColor(row, "val_cust_addr") = gColorValCust;

            CellBackColor(row, "cor_cust_cd") = gColorEditable;
            CellBackColor(row, "val_cd") = gColorEditable;
            CellBackColor(row, "mail_img_idx") = gColorReadOnly;
            CellBackColor(row, "bkg_cust_tp_cd_view") = gColorReadOnly;
            CellBackColor(row, "bl_no") = gColorReadOnly;
        } else {
            RowBackColor(row) = gColorDisabled;
        }
    }
}

/**
 * match 시트의 background color를 설정한다.<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {Object}
 *            sheetObj 필수, Sheet개체
 * @param {int}
 *            row 필수, 선택된 Cell
 * @param {boolean}
 *            bSelect 필수, 셀이 선택되었는지 여부
 * @return {void}
 * @author Ryu Daeyoung
 * @version 2013.03.18
 */
function fnT2sheet1CellBackColor(sheetObj, row, bSelect) {
    with(sheetObj) {
        // CellBackColor(row, "mdm_cust_cd") = gColorDisabled;
        CellBackColor(row, "mdm_cust_nm") = gColorBkgCust;
        CellBackColor(row, "mdm_cust_addr") = gColorBkgCust;

        CellBackColor(row, "bkg_cust_nm") = gColorValCust;
        CellBackColor(row, "bkg_cust_addr") = gColorValCust;

        CellBackColor(row, "val_cd_nm") = gColorBkgCust;
        if (bSelect == false) {
            CellBackColor(row, "val_cd_img_idx") = gColorReadOnly;
        } else {
            CellBackColor(row, "val_cd_img_idx") = gColorEditable;
        }
    }
}

/**
 * 각 Cell의 Font / Under bar처리를 한다.<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {Object}
 *            sheetObj 필수, Sheet개체
 * @param {int}
 *            row 필수, 선택된 Cell
 * @return void
 * @author Ryu Daeyoung
 * @version 2013.03.18
 */
function fnt1sheet1CellFont(sheetObj, row) {
    with (sheetObj) {
    	var vValCustCd = CellValue(row,"val_cust_cd"); // 성능을 위해 값을 받아와서 처리한다
														// 20100204
    	var vCorCustCd = CellValue(row,"cor_cust_cd");
    	var vMdmCustCd = CellValue(row,"mdm_cust_cd");
    	var vValCd     = CellValue(row, "val_cd");
        // Evaluation한 Customer Code와 Correct code가 동일한지 검사하여 폰트 처리
        if (vValCustCd != "" && vValCustCd != vCorCustCd) {
            CellFont("FontColor", row,"val_cust_cd") = gFontColorBlack;
            CellFontUnderline(row,"val_cust_cd") = true;
        } else {
            CellFont("FontColor", row,"val_cust_cd") = gFontColorBlue;
            CellFontUnderline(row,"val_cust_cd") = false;
        }

        // Bkg에 입력한 Customer Code와 Correct Code가 동일한지 검사하여 폰트 처리
        if (vMdmCustCd != "" && vMdmCustCd != vCorCustCd) {
            CellFont("FontColor", row,"mdm_cust_cd") = gFontColorBlack;
            CellFontUnderline(row,"mdm_cust_cd") = true;
        } else {
            CellFont("FontColor", row,"mdm_cust_cd") = gFontColorBlue;
            CellFontUnderline(row,"mdm_cust_cd") = false;
        }

        // Correct Code가 그냥 입력한 것일 경우 색상 처리
        if (vCorCustCd != vValCustCd && vCorCustCd != vMdmCustCd) {
            CellFont("FontColor", row,"cor_cust_cd") = gFontColorBlue;
        } else {
            CellFont("FontColor", row,"cor_cust_cd") = gFontColorBlack;
        }

        // Not-Existence 또는 OK일 경우 Data는 선택할 수 없도록 under bar를 제거한다.
        if (vValCd == "N" || vValCd == "O" || vValCd == "S") {
            CellFontUnderline(row,"mdm_cust_cd") = false;
            CellFontUnderline(row,"val_cust_cd") = false;
        }
    }
}

    /* 개발자 작업 끝 */