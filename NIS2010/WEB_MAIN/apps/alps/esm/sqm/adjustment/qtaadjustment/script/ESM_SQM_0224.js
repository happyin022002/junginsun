/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0224.js
*@FileTitle      : RBCCO PFMC = QTA Setting for IAS Sector
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.01.23
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2014.01.23 SQM USER
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/


/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends
 * @class ESM_SQM_0224 : ESM_SQM_0224 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SQM_0224() {
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

//공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

function processButtonClick(){
    var sheetObject = sheetObjects[0];
    var formObj     = document.form;

    try {
        var srcName = window.event.srcElement.getAttribute("name");

        switch(srcName) {
            case "btn_Retrieve":
                doActionIBSheet(sheetObject, formObj, IBSEARCH);
                break;
            case "btn_RbccoPfmc":
                doActionIBSheet(sheetObject, formObj, MULTI);
                break;
            case "btn_Downexcel":
                doActionIBSheet(sheetObject,formObj,IBDOWNEXCEL);
                break;

        }
    } catch(e) {
        if( e == "[object Error]") {
            ComShowMessage(ComGetMsg("COM12111", "", ""));
        } else {
            ComShowMessage(e);
        }
    }
}

/**
 * IBSheet Object 를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * IBSheet Object 를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setComboObject(combo_obj){
    comboObjects[comboCnt++] = combo_obj;
}

function loadPage(){
    var formObj = document.form;
    loadingMode = true;
    for(i=0;i<sheetObjects.length;i++){
        //khlee-시작 환경 설정 함수 이름 변경
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
        ComEndConfigSheet(sheetObjects[i]);
    }
    doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);

    for(k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],comboObjects[k].id);
    }

    loadingMode = false;
}

 var initSheetFn = function initSheet(sheetObj,sheetNo) {
    var cnt = 0;

    switch(sheetNo) {
        case 1:     //sheet1 init
            with (sheetObj) {
                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                // Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                // 전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;  //msNone; //msHeaderOnly //msPrevColumnMerge;

                // 전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 9, 100);

                var HeadTitle1 =  "STS|SEQ|Year|Quarter|Office View|Trade|Sub Trade|R.Lane|Lane Bound|Month|Week|RHQ|Office|Load|G.RPB|G.REV|CM Cost(PA)|CM Cost(RA)|CMCB(PA)|CMCB(RA)|CM(PA)|CM(RA)|CMPB(PA)|CMPB(RA)";


                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(ComCountHeadTitle(HeadTitle1), 2, 0, true);

                // 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
                InitHeadMode(true, false, false, true, false, false);

                // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);

                // 전체 높이 설정
                style.height = GetSheetHeight(19);

                // 데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
                InitDataProperty(0, cnt++,  dtHiddenStatus,       30, daCenter,   true,   "ibflag",       false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtSeq,          30, 	daCenter,   true,   "seq",          false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         50, 	daCenter,   true,   "bse_yr",       false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         60, 	daCenter,   true,   "bse_qtr_cd",   false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         80, 	daCenter,   true,   "ofc_vw_cd",    false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         50, 	daCenter,   true,   "trd_cd",       false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         60, 	daCenter,   true,   "sub_trd_cd",  	false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         60, 	daCenter,   true,   "rlane_cd",     false,  "",     dfNone,     0,  false,  false);

                InitDataProperty(0, cnt++,  dtData,         80, 	daCenter,   true,   "dir_cd",       false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         50, 	daCenter,   true,   "bse_mon",      false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         50, 	daCenter,   true,   "bse_wk",       false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         60, 	daCenter,   true,   "rhq_cd",       false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         60, 	daCenter,   true,   "rgn_ofc_cd",   false,  "",     dfNone,     0,  false,  false);
                
                InitDataProperty(0, cnt++,  dtAutoSum,      80, daRight,    true,   "lod_qty",      false,  "",     dfInteger,  0,  true,   true);
                InitDataProperty(0, cnt++,  dtData,       	110,daRight,    true,   "grs_rpb_rev", 	false,  "",     dfInteger,  13, true,   true);
                InitDataProperty(0, cnt++,  dtAutoSum,      110,daRight,    true,   "grs_rev",      false,  "|grs_rpb_rev|*|lod_qty|",   dfInteger,  0,  false,  false);
                InitDataProperty(0,	cnt++,	dtAutoSum,		100,daRight,	true,	"pa_cm_cost",	false,	"|pa_cm_uc_amt|*|lod_qty|",		dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,		100,daRight,	true,	"ra_cm_cost",	false,	"|ra_cm_uc_amt|*|lod_qty|",		dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			100,daRight,	true,	"pa_cm_uc_amt",	false,	"",		dfInteger,	0,	true,	true);
				InitDataProperty(0,	cnt++,	dtData,			100,daRight,	true,	"ra_cm_uc_amt",	false,	"",		dfInteger,	0,	true,	true);
				InitDataProperty(0,	cnt++,	dtAutoSum,		100,daRight,	true,	"pa_cm",		false,	"|grs_rev|-|pa_cm_cost|",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,		100,daRight,	true,	"ra_cm",		false,	"|grs_rev|-|ra_cm_cost|",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			100,daRight,	true,	"pa_cmpb",		false,	"(|grs_rev|-|pa_cm_cost|)/|lod_qty|",		dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			100,daRight,	true,	"ra_cmpb",		false,	"(|grs_rev|-|ra_cm_cost|)/|lod_qty|",		dfInteger,	0,	false,	false);
				RangeBackColor(0, 13, 0, 15) = RgbColor(203,210,248);
				RangeBackColor(0, 20, 0, 23) = RgbColor(203,210,248);    
        }
            break;
    }
}

/**
* 멀티콤보 항목을 설정한다.
*/
function initCombo(comboObj, comboId) {
    switch(comboObj.id) {
        case "f_bse_yr":
        case "f_bse_qtr_cd":
            with (comboObj) {
                DropHeight = 300;
            }
            break;
        default:
            with (comboObj) {
                DropHeight = 300;
                Index      = 0;
            }
            break;
    }
}

/**
 * f_bse_yr가 바뀌었을때 period 의 year 변경
 */
function f_bse_yr_OnChange(obj, value, text) {
    period_change();
}

/**
 * f_bse_qtr_cd 바뀌었을때 period 의 week 기간변경
 */
function f_bse_qtr_cd_OnChange(obj, value, text) {
    var formObj = document.form;
    period_change();
    doActionIBSheet(sheetObjects[0], formObj, SEARCH01);
    setWeek(value);
}


/**
 * Sheet 관련 프로세스 처리
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg = false;

    switch(sAction) {
        case IBCLEAR:          // 화면 접속 시
            sheetObj.WaitImageVisible = false;

            ComOpenWait(true);

            formObj.f_cmd.value = INIT;

            var sXml   = sheetObj.GetSearchXml("ESM_SQM_0224GS.do", FormQueryString(formObj));
            var State  = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
            var arrXml = sXml.split("|$$|");

            if (arrXml.length > 0)
                ComXml2ComboItem(arrXml[0], formObj.f_bse_yr, "code", "name");
            if (arrXml.length > 1)
                ComXml2ComboItem(arrXml[1], formObj.f_bse_qtr_cd, "code", "name");
            if (arrXml.length > 2)
                ComSetYearQta(arrXml[2]);

            ComOpenWait(false);
            break;

        case SEARCH01:          // Week 콤보셋팅
            formObj.f_cmd.value = SEARCH01;
            var sXml = sheetObj.GetSearchXml("ESM_SQM_0224GS.do", FormQueryString(formObj));

            ComXml2ComboItem(sXml, formObj.f_bse_wk, "code", "name");
            comboObjects[2].Index = 0;
            break;

        case MULTI:          //
        	if (ComShowConfirm (ComGetMsg("SQM00012", "Apply")) != 1) {
                return false;
            }
            sheetObj.WaitImageVisible = false;
            ComOpenWait(true);
            ComSetSearchParams("f_cmd", MULTI);
            var sParam  = sheetObj.GetSaveString(true, true);
            var sXml = sheetObjects[0].GetSaveXml("ESM_SQM_0224GS.do", searchParams + "&" +sParam);
            var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
            ComOpenWait(false);
            if(State != "S"){
                ComShowMessage(ComResultMessage(sXml));
                return false;
            }else {
                ComShowCodeMessage('SQM00011','Data');
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
            }
            break;

        case IBSEARCH:          //화면 조회시
            sheetObj.WaitImageVisible = false;
            ComOpenWait(true);

            formObj.f_cmd.value = SEARCH;
            searchParams = FormQueryString(formObj);
            var sXml = sheetObj.GetSearchXml("ESM_SQM_0224GS.do", searchParams);
            sheetObj.LoadSearchXml(sXml);
            
            ComOpenWait(false);
            break;
            break;

        case IBDOWNEXCEL:       // 엑셀 다운로드
            ComOpenWait(true);
            sheetObj.Down2Excel(-1, false, false, true);
            ComOpenWait(false);
            break;
    }
}

/**
 *조회 함수를 이용하여 조회가 완료되고 발생하는 Event
 * @param sheetObj
 */
 function sheet1_OnSearchEnd(sheetObj){
    sheetObj.SumText(0, "grs_rpb_rev")  = ComAddComma((sheetObj.SumValue(0, "grs_rev")   / sheetObj.SumValue(0, "lod_qty")).toFixed(0));
	sheetObj.SumText(0, "pa_cm_uc_amt") = ComAddComma((sheetObj.SumValue(0, "pa_cm_cost") / sheetObj.SumValue(0, "lod_qty")).toFixed(0));
	sheetObj.SumText(0, "ra_cm_uc_amt") = ComAddComma((sheetObj.SumValue(0, "ra_cm_cost") / sheetObj.SumValue(0, "lod_qty")).toFixed(0));
	sheetObj.SumText(0, "pa_cmpb")      = ComAddComma((sheetObj.SumValue(0, "pa_cm")   / sheetObj.SumValue(0, "lod_qty")).toFixed(0));
	sheetObj.SumText(0, "ra_cmpb")      = ComAddComma((sheetObj.SumValue(0, "ra_cm")   / sheetObj.SumValue(0, "lod_qty")).toFixed(0));
	sheetObj.SumText(0, "seq") = "";
 	sheetObj.SumText(0, "ofc_vw_cd") = "TOTAL";
}

function setWeek(value){
	var formObj = document.form;
	if(value == "1Q"){
		formObj.f_fm_wk.value = "00";
		formObj.f_to_wk.value = "13";
	}else if(value == "2Q"){
		formObj.f_fm_wk.value = "14";
		formObj.f_to_wk.value = "26";
	}else if(value == "3Q"){
		formObj.f_fm_wk.value = "27";
		formObj.f_to_wk.value = "39";
	}else if(value == "4Q"){
		formObj.f_fm_wk.value = "40";
		formObj.f_to_wk.value = "53";
	}
}
/* 개발자 작업  끝 */