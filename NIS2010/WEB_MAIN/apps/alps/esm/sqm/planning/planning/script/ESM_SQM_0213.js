/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName       : ESM_SQM_0213.js
*@FileTitle      : QTA Set up for IAS Sector by Head Office
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.01.23
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2014.01.23 SQM USER
* 1.0 Creation
* History
* 2014.06.20 이혜민 [CHM-201430168] IAS Sector Sales - Main, Sector 구분자 추가를 위한 화면 변경
* 2015.06.15 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
* 2015.09.17 김용습 [CHM-201537764] [CSR 전환건] QTA Set up by Head Office for IAS Sector 화면 내 Raw Data Export 버튼 신규 생성 
* 2015.09.22 김용습 [CHM-201537819] [CSR 전환건] QTA Set up by Head Office for IAS Sector 화면 내 Freezing, Add-Freezing 버튼 Validation 추가
* 2015.12.06 [CHM-201539010] Add Freezing Validation 수정
* 2015.12.24 [CHM-201539088] IAS Sector QTA Planning - Freezing 배치 방식으로 전환
* 2016.01.28 Basic Data Creation for IAS Secotr 화면의 Creation 로직 변경
* 2016.04.22 [SQM] IAS Trade 판매목표 수립 Portion 연결 시스템 수정 요청 CSR
* 2016.06.14 Load가 있는데 GRBP가 있는지 없는지 체크하는 유효성 검사 주석 처리
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends
 * @class ESM_SQM_0213 : ESM_SQM_0213 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SQM_0213() {
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

var rowCnt = 0;
var max = 0;
var params = "";

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

function processButtonClick(){
    var sheetObject = sheetObjects[0];
    var formObj     = document.form;

    try {
        var srcName = window.event.srcElement.getAttribute("name");

        switch(srcName) {
            case "f_bse_tp_cd":
                f_bse_tp_cd_OnChange();
                break;
            case "btn_Retrieve":
                doActionIBSheet(sheetObject, formObj, IBSEARCH);
                break;
            case "btn_Save":
                doActionIBSheet(sheetObject, formObj, IBSAVE);
                break;
            case "btn_Creation":
                doActionIBSheet(sheetObject, formObj, IBCREATE);
                break;
            case "btn_AddCreation":
                doActionIBSheet(sheetObject, formObj, "AddCreation");
                break;
            case "btn_Freezing":
                doActionIBSheet(sheetObject, formObj, "Freezing");
                break;
            case "btn_AddFreezing":
                doActionIBSheet(sheetObject, formObj, "AddFreezing");
                break;
            case "btn_Transfer":
                doActionIBSheet(sheetObject, formObj, "Transfer");
                break;
            case "btn_Downexcel":
                doActionIBSheet(sheetObject, formObj, IBDOWNEXCEL);
                break;
            case "btn_Loadexcel":
                doActionIBSheet(sheetObject, formObj, "LoadExcel");
                break;
            case "btn_RawDataDownExcel":
				doActionIBSheet(sheetObject, formObj, "RawDataDownExcel");
				break;
            case "btn_sectoradd":
				doActionIBSheet(sheetObject, formObj, "AddSector");
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
    initControl();
    for(k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],comboObjects[k].id);
    }
    toggleButtons("INIT");
    loadingMode = false;
}

function initControl() {
    var formObj = document.form;
    axon_event.addListenerForm("click",     "obj_click",    formObj);
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
                InitRowInfo(2, 1, 9, 100);

                var HeadTitle1 =  "STS|SEQ|Year|Quarter|Office View|ofc_vw_cd|Trade|Sub Trade|IAS Region|R.Lane|Lane Bound|Trade Direction|P/F SKD Group|Supply|RHQ|Office|POL|POD|Main/Sector" +
                				  "|Previous Quarter Input Item|Previous Quarter Input Item|Previous Quarter Input Item|Input Item|Input Item|Input Item|Past MAS PFMC|Past MAS PFMC|Past MAS PFMC";
                var HeadTitle2 =  "STS|SEQ|Year|Quarter|Office View|ofc_vw_cd|Trade|Sub Trade|IAS Region|R.Lane|Lane Bound|Trade Direction|P/F SKD Group|Supply|RHQ|Office|POL|POD|Main/Sector|Load|G.RPB|G.REV|Load|G.RPB|G.REV|Load|G.RPB|G.REV";

                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);

                // 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
                InitHeadMode(true, false, false, true, false, false);

                // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                InitHeadRow(1, HeadTitle2, true);

                // 전체 높이 설정
                style.height = GetSheetHeight(18);

                // 데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
                InitDataProperty(0, cnt++,  dtStatus,   30,   daCenter,  true,  "ibflag",       false,  "", dfNone, 0,  false,  false);
                InitDataProperty(0, cnt++,  dtSeq,      30,   daCenter,  true,  "seq",          false,  "", dfNone, 0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,     50,   daCenter,  true,  "bse_yr",   	false,  "", dfNone, 0,  false,  false);
                if(loadExcelVal=="Y"){
                	InitDataProperty(0, cnt++,  dtHidden,   60,   daCenter,  true,  "bse_qtr_cd",   false,  "", dfNone, 0,  false,  false);
                }else{
                	InitDataProperty(0, cnt++,  dtData,     60,   daCenter,  true,  "bse_qtr_cd",   false,  "", dfNone, 0,  false,  false);
                }
                InitDataProperty(0, cnt++,  dtData,     80,   daCenter,  true,  "ofc_vw_nm",    false,  "", dfNone, 0,  false,  false);
                InitDataProperty(0, cnt++,  dtHidden,   80,   daCenter,  true,  "ofc_vw_cd",    false,  "", dfNone, 0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,     50,   daCenter,  true,  "trd_cd",       false,  "", dfNone, 0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,     70,   daCenter,  true,  "sub_trd_cd",   false,  "", dfNone, 0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,     80,   daCenter,  true,  "ias_rgn_cd",   false,  "", dfNone, 0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,     70,   daCenter,  true,  "rlane_cd",     false,  "", dfNone, 0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,     80,   daCenter,  true,  "dir_cd",   	false,  "", dfNone, 0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,     100,  daCenter,  true,  "hul_bnd_cd",   false,  "", dfNone, 0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,     90,   daCenter,  true,  "pf_grp_cd",    false,  "", dfNone, 0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,     70,   daCenter,  true,  "fnl_bsa_capa", false,  "", dfNone, 0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,     60,   daCenter,  true,  "rhq_cd",   	false,  "", dfNone, 0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,     60,   daCenter,  true,  "rgn_ofc_cd",   false,  "", dfNone, 0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,     60,   daCenter,  true,  "pol_cd",   	false,  "", dfNone, 0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,     60,   daCenter,  true,  "pod_cd",   	false,  "", dfNone, 0,  false,  false);
				InitDataProperty(0,	cnt++,	dtData,		90,  daCenter,	 true,	"sqm_mn_sctr_flg",		false,	"",	dfNone,	0,	false,	false);

                InitDataProperty(0, cnt++,  dtAutoSum,      80,   daRight,   true,  "pre_lod_qty",  	false,  "", dfInteger,  0,  false,   false);
                InitDataProperty(0, cnt++,  dtAutoSum,      80,   daRight,   true,  "pre_grs_rpb_rev",  false,  "", dfInteger,  0,  false,   false);
                InitDataProperty(0, cnt++,  dtAutoSum,      80,   daRight,   true,  "pre_grs_ttl_rev",  false,  "|pre_lod_qty|*|pre_grs_rpb_rev|",  dfInteger,  0,  false,  false);

                InitDataProperty(0, cnt++,  dtAutoSum,      80,   daRight,   true,  "lod_qty",  		false,  "", dfInteger,  0,  true,   false);
                InitDataProperty(0, cnt++,  dtAutoSum,      80,   daRight,   true,  "grs_rpb_rev",  	false,  "", dfInteger,  0,  true,   false);
                InitDataProperty(0, cnt++,  dtAutoSum,      80,   daRight,   true,  "grs_ttl_rev",  	false,  "|lod_qty|*|grs_rpb_rev|",  dfInteger,  0,  false,  false);
                
                InitDataProperty(0, cnt++,  dtAutoSum,      80,   daRight,   true,  "gid_lod_qty",  	false,  "", dfInteger,  0,  false,  false);
                InitDataProperty(0, cnt++,  dtAutoSum,      80,   daRight,   true,  "gid_grs_rpb_rev",  false,  "", dfInteger,  0,  false,  false);
                InitDataProperty(0, cnt++,  dtAutoSum,      80,   daRight,   true,  "gid_grs_ttl_rev",  false,  "|gid_lod_qty|*|gid_grs_rpb_rev|",  dfInteger,  0,  false,  false);
                

            }
            break;
    }
}


/**
*조회 함수를 이용하여 조회가 완료되고 발생하는 Event
* @param sheetObj
* @param ErrMsg
*/
function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	 //RPB SUM 계산 (sum(REV) / sum(load))	
	sheetObj.SumText(0, "grs_rpb_rev") = ComAddComma((sheetObj.SumValue(0, "grs_ttl_rev")/sheetObj.SumValue(0, "lod_qty")).toFixed(0));
	sheetObj.SumText(0, "gid_grs_rpb_rev") = ComAddComma((sheetObj.SumValue(0, "gid_grs_ttl_rev")/sheetObj.SumValue(0, "gid_lod_qty")).toFixed(0));
	sheetObj.SumText(0, "pre_grs_rpb_rev") = ComAddComma((sheetObj.SumValue(0, "pre_grs_ttl_rev")/sheetObj.SumValue(0, "pre_lod_qty")).toFixed(0));
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

        case "f_ofc_vw_cd":
            with (comboObj) {
                DropHeight = 300;
                Index      = 1;
            }
            break;

        case "f_pf_grp_cd":
            with (comboObj) {
                SetTitle("R/Lane|Group");
                SetColAlign("center|center");
                SetColWidth("50|30");

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
    setLaneCombo();
}

/**
* f_bse_qtr_cd 바뀌었을때 period 의 week 기간변경
*/
function f_bse_qtr_cd_OnChange(obj, value, text) {
    period_change();
    setLaneCombo();
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
            var sXml   = sheetObj.GetSearchXml("ESM_SQM_0213GS.do", FormQueryString(formObj));
            var State  = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
            var arrXml = sXml.split("|$$|");

            if (arrXml.length > 0)
                ComXml2ComboItem(arrXml[0], formObj.f_bse_yr, "code", "name");
            if (arrXml.length > 1)
                ComXml2ComboItem(arrXml[1], formObj.f_bse_qtr_cd, "code", "name");
            if (arrXml.length > 2)
                ComSetYearQta(arrXml[2]);
            if (arrXml.length > 3)
                ComXml2ComboItem(arrXml[3], formObj.f_ofc_vw_cd, "code", "name");
            if (arrXml.length > 4)
                ComXml2ComboItem(arrXml[4], formObj.f_sub_trd_cd, "code", "name");
            if (arrXml.length > 5)
                ComXml2ComboItem(arrXml[5], formObj.f_ias_rgn_cd, "code", "name");
            if (arrXml.length > 6)
                ComXml2ComboItem(arrXml[6], formObj.f_dir_cd, "code", "name");
            if (arrXml.length > 7)
                ComXml2ComboItem(arrXml[7], formObj.f_hul_bnd_cd, "code", "name");
            if (arrXml.length > 8)
                ComXml2ComboItem(arrXml[8], formObj.f_rhq_cd, "code", "name");
            ComOpenWait(false);
            break;

        case IBSEARCH:          // Retrieve
            ComOpenWait(true);
            setWeek();
            formObj.f_cmd.value = SEARCH01;
            searchParams = FormQueryString(formObj);

            var rtnXml = sheetObj.GetSearchXml("ESM_SQM_0213GS2.do", searchParams);
            sheetObj.LoadSearchXml(rtnXml);
            //연간/분기에 따라서 그리드 항목을 보여줬다 감췄다 함
            if (ComGetObjValue(document.form.f_bse_tp_cd) == "Y") {
                sheetObj.ColHidden("bse_qtr_cd") = true;
            } else {
                sheetObj.ColHidden("bse_qtr_cd") = false;
            }
            // ETC의 값을 폼변수에 넣어준다.(f_p_cnt, f_c_cnt, f_t_cnt)
//          IBS_EtcDataToForm(formObj, sheetObj);
            formObj.f_p_cnt.value = sheetObj.EtcData("p_cnt");
            formObj.f_c_cnt.value = sheetObj.EtcData("c_cnt");
            formObj.f_t_cnt.value = sheetObj.EtcData("t_cnt");
            sheetObj.RemoveEtcData();
            ComOpenWait(false);
            toggleButtons("SEARCH");

            sheetObj.SumText(0,0) = "";
            sheetObj.SumText(0,3) = "TOTAL";
            break;

        case IBSAVE:          // Save

            if (sheetObj.isDataModified == false) {
                ComShowCodeMessage("SQM00006");  //There is no data to save
                return false;
            } else if (ComShowConfirm (ComGetMsg("SQM00004")) != 1) { //Do you want to save?
                return false;
            }

            ComOpenWait(true);
            ComSetSearchParams("f_cmd", MULTI01);
            sheetObj.DoSave("ESM_SQM_0213GS.do", searchParams, -1, false);
            ComOpenWait(false);

            var State = sheetObj.EtcData("TRANS_RESULT_KEY");
            if(State != "S"){
                ComShowMessage(ComResultMessage(sXml));
                return false;
            }else if(State == "S"){
                ComShowCodeMessage('SQM00001','Data');  //{?msg1} saved successfully.
            }
            break;

        case IBCREATE:          // Creation
            if (sheetObj.isDataModified == true) {
                ComShowCodeMessage("SQM00030",'Creation'); //There are modified data.\nPlease save before you click {?msg1}.
                return false;
            }
            if (ComShowConfirm (ComGetMsg('SQM00012','Creation')) != 1) { //Do you want to {?msg1}?
                return false;
            }

            ComOpenWait(true);
            ComSetSearchParams("f_cmd", MULTI02);
            sheetObj.DoSearch("ESM_SQM_0213GS.do", searchParams);
            ComOpenWait(false);

            var State = sheetObj.EtcData("TRANS_RESULT_KEY");
            if(State != "S"){
                ComShowMessage(ComResultMessage(sXml));
                return false;
            }else if(State == "S"){
//                ComShowCodeMessage('SQM00010','Data'); //{?msg1} was created successfully.
            	ComShowCodeMessage('SQM00059'); // 배치로 변경
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
            }
            break;

        case "AddCreation":          // AddCreation Popup
        	var rtn = window.showModalDialog("ESM_SQM_0214.do?" + searchParams, null, "dialogHeight:385px;dialogWidth:885px;center:yes;resizable:no;scroll:no;status:no;unadorned:yes;");
        	if(rtn == "S") doActionIBSheet(sheetObj, formObj, IBSEARCH);
        	break;
        	

        case "AddSector":          // Sector Add
//        	paramObj = new Object();
//        	paramObj.id = "ESM_SQM_0213";
        	searchParams = searchParams+"&ui_id=ESM_SQM_0213";
        	var rtn = window.showModalDialog("ESM_SQM_0222.do?" + searchParams, null, "dialogHeight:395px;dialogWidth:885px;center:yes;resizable:no;scroll:no;status:no;unadorned:yes;");
        	if(rtn == "S") doActionIBSheet(sheetObj, formObj, IBSEARCH);
        	break;
        	

        case "Freezing":          // Freezing
        	
        	//시작(Load가 0이 아닌데 Grpb가 0인 데이터 찾아내는 유효성 검사)
        	//2016.06.14 Sector 수립에서 더이상 RPB는 관리하지 않기로 해서 아래 주석 처리
//        	var param = "f_cmd="         + COMMAND02
//            + "&f_bse_tp_cd="  + ComGetObjValue(document.form.f_bse_tp_cd)
//            + "&f_bse_yr="     + ComGetObjValue(document.form.f_bse_yr)
//            + "&f_bse_qtr_cd=" + ComGetObjValue(document.form.f_bse_qtr_cd)
//            ;
//        	
//        	var rtnXml = sheetObjects[0].GetSearchXml("ESM_SQM_0213GS2.do", param);
//        	
//        	var arrXml = rtnXml.split("<TR><![CDATA[");
//        	var processedArrXml = [];
//        	var combindedArrayData = '';
//        	
//        	if(arrXml[0].indexOf("TOTAL='0'") == -1){
//        		for(a=1; a<arrXml.length; a++){ // 첫번째 배열은 버림. 불필요한 내용이 들어 있으므로
//        			processedArrXml[a] = arrXml[a].replace("]]></TR>",'');
//        			processedArrXml[a] = processedArrXml[a].replace(" ",''); // 공백 제거
//        			if(processedArrXml[a].indexOf("</DATA>") > -1){ // 마지막 배열의 </DATA></SHEET> 문자를 제거하기 위해 만든 if절
//        				processedArrXml[a] = processedArrXml[a].replace("</DATA>",'');
//            			processedArrXml[a] = processedArrXml[a].replace("</SHEET>",'');
//        			}
//        			combindedArrayData = combindedArrayData + processedArrXml[a];
//            	}
//        		ComShowCodeMessage('SQM00053', ComGetObjValue(document.form.f_bse_yr), ComGetObjValue(document.form.f_bse_qtr_cd), combindedArrayData);
//        		return false;
//        	}
        	//끝
        	

            if (sheetObj.isDataModified == true) {
                ComShowCodeMessage("SQM00030",'Freezing'); //There are modified data.\nPlease save before you click {?msg1}.
                return false;
            }
            if (ComShowConfirm (ComGetMsg('SQM00063')) != 1) { 
                return false;
            }

            ComOpenWait(true);
            ComSetSearchParams("f_cmd", MULTI03);
            sheetObj.DoSearch("ESM_SQM_0213GS.do", searchParams);
            ComOpenWait(false);

            var State = sheetObj.EtcData("TRANS_RESULT_KEY");
            if(State != "S"){
                ComShowMessage(ComResultMessage(sXml));
                return false;
            }else if(State == "S"){
                ComShowCodeMessage('SQM00059');
            }
            // 데이터 생성 후 버튼 컨트롤
            formObj.f_p_cnt.value = sheetObj.EtcData("p_cnt");
            formObj.f_c_cnt.value = sheetObj.EtcData("c_cnt");
            formObj.f_t_cnt.value = sheetObj.EtcData("t_cnt");
            sheetObj.RemoveEtcData();
            toggleButtons("SEARCH");
            break;

        case "AddFreezing":          // AddFreezing Popup
        	
        	window.showModalDialog("ESM_SQM_0215.do?" + searchParams, null, "dialogHeight:385px;dialogWidth:885px;center:yes;resizable:no;scroll:no;status:no;unadorned:yes;");
        	break;

        case "Transfer":          // 1Q Transfer
            if (ComShowConfirm (ComGetMsg('SQM00012','1Q Transfer')) != 1) { //Do you want to {?msg1}?
                return false;
            }

            ComOpenWait(true);
            ComSetSearchParams("f_cmd", MULTI04);
            sheetObj.DoSearch("ESM_SQM_0213GS.do", searchParams);
            ComOpenWait(false);

            var State = sheetObj.EtcData("TRANS_RESULT_KEY");
            if(State != "S"){
                ComShowMessage(ComResultMessage(sXml));
                return false;
            }else if(State == "S"){
                ComShowCodeMessage('SQM00010','Data'); //{?msg1} was created successfully.
            }
            // 데이터 생성 후 버튼 컨트롤
            formObj.f_p_cnt.value = sheetObj.EtcData("p_cnt");
            formObj.f_c_cnt.value = sheetObj.EtcData("c_cnt");
            formObj.f_t_cnt.value = sheetObj.EtcData("t_cnt");
            sheetObj.RemoveEtcData();
            toggleButtons("SEARCH");
            break;

        case "LoadExcel":          // LoadExcel
            loadExcelRowCnt    = sheetObj.HeaderRows + sheetObj.TotalRows;
            loadExcelTotFlg    = true;      // 화면에 Total Row 존재 여부
            loadExcelVal = ComGetObjValue(formObj.f_bse_tp_cd); //자식창 inisheet시에 bse_tp_cd히든 여부 설정
            if(ComGetObjValue(formObj.f_bse_tp_cd) == "Y")
                loadExcelExField   = "|bse_qtr_cd|ofc_vw_cd|trd_cd|sub_trd_cd|ias_rgn_cd|hul_bnd_cd|gid_lod_qty|gid_grs_rpb_rev|gid_grs_ttl_rev|lod_qty|grs_rpb_rev|grs_ttl_rev|pre_lod_qty|pre_grs_rpb_rev|pre_grs_ttl_rev|";      // 비교 제외 필드
            else
                loadExcelExField   = "|ofc_vw_cd|trd_cd|sub_trd_cd|ias_rgn_cd|hul_bnd_cd|gid_lod_qty|gid_grs_rpb_rev|gid_grs_ttl_rev|lod_qty|grs_rpb_rev|grs_ttl_rev|pre_lod_qty|pre_grs_rpb_rev|pre_grs_ttl_rev|";     // 비교 제외 필드
            loadExcelAplyField = "|lod_qty|grs_rpb_rev|";       // 반영 필드

            var rtn = window.showModalDialog("ESM_SQM_1001.do?" + searchParams, window, "dialogHeight:620px;dialogWidth:1050px;center:yes;resizable:yes;scroll:yes;status:no;unadorned:yes;");
            if(rtn == "S")
                doActionIBSheet(sheetObj, formObj, IBSAVE);
            break;

        case IBDOWNEXCEL:       // 엑셀 다운로드
            ComOpenWait(true);
            sheetObj.Down2Excel(-1, false, false, true);
            ComOpenWait(false);
            break;
            
        case "RawDataDownExcel":		// Raw Data 엑셀 다운로드
			ComOpenWait(true);

			var param = "f_cmd="         + COMMAND01
			          + "&f_bse_tp_cd="  + ComGetObjValue(formObj.f_bse_tp_cd)
			          + "&f_bse_yr="     + ComGetObjValue(formObj.f_bse_yr)
			          + "&f_bse_qtr_cd=" + ComGetObjValue(formObj.f_bse_qtr_cd)
			          ;
			
			document.location.href = "ESM_SQM_0213DL.do?" + param;
			
			ComOpenWait(false);
			break;

  }
}


/**
* onChange event
* f_sub_trd_cd 바뀌었을때  f_lane_cd 콤보조회
*/
function f_sub_trd_cd_OnChange(obj, value, text) {
    setLaneCombo();
 }

/**
* onChange event
* f_ias_rgn_cd 바뀌었을때  f_lane_cd 콤보조회
*/
function f_ias_rgn_cd_OnChange(obj, value, text) {
    setLaneCombo();
}

/**
 *  f_sub_trd_cd, f_ias_rgn_cd 변경시 f_rlane_cd를 변경한다.
 */
function setLaneCombo(){
    var formObj = document.form;
    var sub_trd_cd = ComGetObjValue(formObj.f_sub_trd_cd);
    var ias_rgn_cd = ComGetObjValue(formObj.f_ias_rgn_cd);

    if ( (sub_trd_cd != ""  && sub_trd_cd != "All" ) || (ias_rgn_cd != "" && ias_rgn_cd != "All")  ) {
        var param = "f_cmd=" + SEARCH02
        + "&code_name=rLaneControlSector"
        + "&code_param=null"
        + "&all_flag=All"
        + "&" + FormQueryString(formObj);

        var xmlStr = sheetObjects[0].GetSearchXml("CommonGS.do", param);
        ComXml2ComboItem(xmlStr, formObj.f_rlane_cd, "code", "name");
        formObj.f_rlane_cd.Index = 0;
    } else {
        formObj.f_rlane_cd.RemoveAll();
        formObj.f_rlane_cd.InsertItem(0, "All", "All");
        formObj.f_rlane_cd.Index = 0;
    }
}

/**
 * f_rlane_cd 바뀌었을때 POL, POD 변경
 */
function f_rlane_cd_OnChange(obj, value, text) {
    var formObj  = document.form;
    var sheetObj = sheetObjects[0];

    if(value != "" && value != "All") {
        var code_name  = new Array("polCdSector", "podCdSector", "bsaSector");
        var code_param = new Array(value, value, value);
        var all_flag   = new Array("All", "All", "All");

        var param = "f_cmd="        + SEARCH02
                  + "&code_name="   + code_name
                  + "&code_param="  + code_param
                  + "&all_flag="    + all_flag
                  + "&" + FormQueryString(formObj);
        var sXml   = sheetObj.GetSearchXml("CommonGS.do", param);
        var arrXml = sXml.split("|$$|");

        if (arrXml.length > 0) {
            ComXml2ComboItem(arrXml[0], formObj.f_pol_cd, "code", "name");
            formObj.f_pol_cd.Index = 0;
        }
        if (arrXml.length > 1) {
            ComXml2ComboItem(arrXml[1], formObj.f_pod_cd, "code", "name");
            formObj.f_pod_cd.Index = 0;
        }
        if (arrXml.length > 2) {
        	ComXml2ComboItem(arrXml[2], formObj.f_fnal_bsa_capa, "code", "name");
        	formObj.f_fnal_bsa_capa.Index = 0;
        }

        var param2 = "f_cmd="   + SEARCH01
        + "&code_name=pfGroup"
        + "&code_param="    + value
        + "&all_flag="
        + "&" + FormQueryString(formObj);
        var sXml2   = sheetObj.GetSearchXml("CommonGS.do", param2);
        var arrXml2 = sXml2.split("|$$|");

        if (sXml2.length > 0) {
            ComXml2ComboItem(arrXml2[0], formObj.f_pf_grp_cd, "code", "name");
            formObj.f_pf_grp_cd.InsertItem(0, "All|All", "All");
            formObj.f_pf_grp_cd.Index = 0;
        }
    }
}

/**
 * f_bse_tp_cd 바뀌었을때 qtr_cd, week 변경
 */
function f_bse_tp_cd_OnChange() {
    var formObj    = document.form;
    var bse_tp_cd  = ComGetObjValue(formObj.f_bse_tp_cd);
    var div_qtr    = document.getElementById("div_qtr");
    var div_period = document.getElementById("div_period");

    if (bse_tp_cd == "Y") {
        div_qtr.style.display = "none";
        div_period.style.display = "none";
        formObj.f_bse_qtr_cd.style.display = "none";
    } else {
        div_qtr.style.display = "inline";
        div_period.style.display = "inline";
        formObj.f_bse_qtr_cd.style.display = "inline";
    }
    period_change();
    setLaneCombo();
    toggleButtons("SEARCH");
}

/**
 *  선택된 RHQ 에 해당하는 Office 정보 가져와서 ComboBox 셋팅
 */
function f_rhq_cd_OnChange(obj, value, text) {
    var formObj  = document.form;
    var sheetObj = sheetObjects[0];

    if (value != "All") {
        var sXml = sheetObj.GetSearchXml("CommonGS.do", "f_cmd="+ SEARCH01 + "&code_name=officeForPlan&code_param=" + value + "&all_flag=All");
        var arrXml = sXml.split("|$$|");

        if (arrXml.length > 0) {
            ComXml2ComboItem(arrXml[0], formObj.f_rgn_ofc_cd, "code", "name");
            formObj.f_rgn_ofc_cd.Index = 0;
        }
    } else {
        formObj.f_rgn_ofc_cd.RemoveAll();
        formObj.f_rgn_ofc_cd.Index = 0;
    }
}

/**
 *  주차정보를 세팅한다.
 */
function setWeek(){
	var formObj  = document.form;
	var qta  = ComGetObjValue(formObj.f_bse_qtr_cd);
	var bse_tp_cd  = ComGetObjValue(formObj.f_bse_tp_cd);
	
	if (bse_tp_cd == "Q" ) {
		formObj.f_fm_wk.value = qtaWeekArr[qta][0].substring(3);
		formObj.f_to_wk.value = qtaWeekArr[qta][1].substring(3);
	} else {
		formObj.f_fm_wk.value = "00";
		formObj.f_to_wk.value = "53";
		
	}
}


 /**
  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  */
 function validateForm(sheetObj, formObj, sAction){
    switch(sAction) {
        case IBSAVE:  // 화면 저장시에
            break;
    }
    return true;
 }

/**
 * Trade Dir. 클릭시 콤보를 변경한다.
 */
function obj_click() {
    var formObj = document.form;
    var srcName = window.event.srcElement.getAttribute("name");

    with(formObj) {

        switch(srcName) {

            case "f_click":
                if ( f_click.checked ) {
                    div_trd_dir.style.display = "inline";
                    div_dir_cd.style.display  = "none";
                    document.all("div_dir").innerHTML = "Trade Dir.";
                } else {
                    div_trd_dir.style.display = "none";
                    div_dir_cd.style.display  = "inline";
                    document.all("div_dir").innerHTML = "Lane Bound";
                }
                break;
        }
    }
}

/**
 * 화면의 모든 버튼들의 Enable/Disable 을 처리
 */
function toggleButtons(step) {
    var formObj = document.form;

    switch (step) {
        case "INIT":
            ComBtnDisable("btn_Save");
            ComBtnDisable("btn_Creation");
            ComBtnDisable("btn_AddCreation");
            ComBtnDisable("btn_Freezing");
            ComBtnDisable("btn_AddFreezing");
            ComBtnDisable("btn_Transfer");
            ComBtnDisable("btn_Downexcel");
            ComBtnDisable("btn_Loadexcel");
            ComBtnDisable("btn_sectoradd");

            ComSetDisplay("btn_AddCreation", false)
            ComSetDisplay("btn_AddFreezing", false)
            break;
            
        case "SEARCH":
        	
            if (formObj.f_p_cnt.value == "0" )    { // Planning Data가 없을 때

                ComBtnDisable("btn_Save");
                ComBtnEnable("btn_Creation");
                ComBtnDisable("btn_AddCreation");
                ComBtnDisable("btn_Freezing");
                ComBtnDisable("btn_AddFreezing");
                ComBtnDisable("btn_Transfer");
                ComBtnDisable("btn_Downexcel");
                ComBtnDisable("btn_Loadexcel");
                if (ComGetObjValue(formObj.f_bse_tp_cd) == "Y" ) { // 연간이고
                    ComSetDisplay("btn_Transfer", true);
                    ComBtnDisable("btn_Transfer");
                } else {
                    ComBtnDisable("btn_Transfer");
                    ComSetDisplay("btn_Transfer", false);
                }
                ComSetDisplay("btn_Creation", true);
                ComSetDisplay("btn_AddCreation", false);
                ComSetDisplay("btn_Freezing", true);
                ComSetDisplay("btn_AddFreezing", false);
                ComBtnDisable("btn_sectoradd");

            } else { // Planning Data 가 있을 때

                ComBtnEnable("btn_Save");
                ComBtnDisable("btn_Creation");
                ComBtnEnable("btn_AddCreation");
                ComSetDisplay("btn_Creation", false);
                ComSetDisplay("btn_AddCreation", true);

                if( formObj.f_c_cnt.value == "0" ) { // confirm Data 가 없을 경우

                    ComBtnEnable("btn_Freezing");
                    ComBtnDisable("btn_AddFreezing");
                    ComSetDisplay("btn_Freezing", true);
                    ComSetDisplay("btn_AddFreezing", false);

                    if (ComGetObjValue(formObj.f_bse_tp_cd) == "Y" ) {
                        ComBtnDisable("btn_Transfer");
                        ComSetDisplay("btn_Transfer", true);
                    } else {
                        ComBtnDisable("btn_Transfer");
                        ComSetDisplay("btn_Transfer", false);
                    }

                    ComBtnEnable("btn_sectoradd");
                } else { // confirm Data 가 있을 경우

                    ComBtnDisable("btn_Freezing");
                    ComBtnEnable("btn_AddFreezing");
                    ComSetDisplay("btn_Freezing", false);
                    ComSetDisplay("btn_AddFreezing", true);
                    if (ComGetObjValue(formObj.f_bse_tp_cd[0]) == "Y" ) {
                        if (formObj.f_t_cnt.value == "0") {
                            ComBtnEnable("btn_Transfer");
                            ComSetDisplay("btn_Transfer", true);
                        } else {
                            ComBtnDisable("btn_Transfer");
                            ComSetDisplay("btn_Transfer", true);
                        }
                    } else {
                        ComBtnDisable("btn_Transfer");
                        ComSetDisplay("btn_Transfer", false);
                    }

                    ComBtnDisable("btn_sectoradd");
                }
                ComBtnEnable("btn_Downexcel");
                ComBtnEnable("btn_Loadexcel");

            }
            break;
    }
}

function checkLoadAndGrpb() {
    	
    	var param = "f_cmd="         + COMMAND02
        + "&f_bse_tp_cd="  + ComGetObjValue(document.form.f_bse_tp_cd)
        + "&f_bse_yr="     + ComGetObjValue(document.form.f_bse_yr)
        + "&f_bse_qtr_cd=" + ComGetObjValue(document.form.f_bse_qtr_cd)
        ;
    	
    	var rtnXml = sheetObjects[0].GetSearchXml("ESM_SQM_0213GS2.do", param);
    	
    	var arrXml = rtnXml.split("<TR><![CDATA[");
    	var processedArrXml = [];
    	var combindedArrayData = '';
    	
    	if(arrXml[0].indexOf("TOTAL='0'") == -1){
    		for(a=1; a<arrXml.length; a++){ // 첫번째 배열은 버림. 불필요한 내용이 들어 있으므로
    			processedArrXml[a] = arrXml[a].replace("]]></TR>",'');
    			processedArrXml[a] = processedArrXml[a].replace(" ",''); // 공백 제거
    			if(processedArrXml[a].indexOf("</DATA>") > -1){ // 마지막 배열의 </DATA></SHEET> 문자를 제거하기 위해 만든 if절
    				processedArrXml[a] = processedArrXml[a].replace("</DATA>",'');
        			processedArrXml[a] = processedArrXml[a].replace("</SHEET>",'');
    			}
    			combindedArrayData = combindedArrayData + processedArrXml[a];
        	}
    		ComShowCodeMessage('SQM00053',combindedArrayData);
    		return false;
    	}
}

/* 개발자 작업  끝 */