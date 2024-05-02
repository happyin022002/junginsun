/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0672.js
*@FileTitle : Arrival Notice
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 박성호
*@LastVersion : 1.0
* 2009.06.03 박성호
* 1.0 Creation
* -------------------------------------------------------
* History
* 2012.09.03 김보배 [CHM-201219780] [BKG] Canada A/N 수정 요청
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
 * @class esm_bkg_0672 : esm_bkg_0672 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0672() {
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

/* 개발자 작업    */


// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

//var sheetObjects = new Array();
var sheetObjects = new Array();
var sheetNames = new Array("t2sheet1","t3sheet1","t4sheet1","t4sheet2");
var sheetCnt = 0;

var loadPageCnt = 0;

// 화면 전역 변수

/* javascript interval identifier */
var intervalId;


/* tab1의 condition을 저장해둔다. */
var t1s1CondParam = "";


/* 조회조건이 변경되었는지 저장해 둔다 */
var queryStrChange = true;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

    var shtCnt = 0;

    //var t1sheet1Obj = sheetObjects[shtCnt++];//0
    //var t1sheet2Obj = sheetObjects[shtCnt++];//1
    //var t2sheet1Obj = sheetObjects[shtCnt++];//0 ; Arrival Data
    var t2sheet1Obj = sheetObjects["t2sheet1"];
    var t3sheet1Obj = sheetObjects["t3sheet1"];//1 ; Customer
    var t4sheet1Obj = sheetObjects["t4sheet1"];//2
    var t4sheet2Obj = sheetObjects["t4sheet2"];//3
    //var t1sheet3Obj = sheetObjects[shtCnt++]; // for excel t1sheet1
    //var t1sheet4Obj = sheetObjects[shtCnt++]; // for excel t1sheet2

    /*******************************************************/
    var formObject = document.form;


    // try {
    var srcName = window.event.srcElement.getAttribute("name");
    if (!ComIsBtnEnable(srcName)) {
        return;
    }

    switch(srcName) {

        case "eta_dt_start":
            //if(formObject.sch_tp[0].checked == true) {return;}
            formObject.sch_tp[1].checked = true;
            var cal = new ComCalendar();
            cal.select(formObject.vps_eta_dt_start, 'yyyy-MM-dd');
            break;

        case "eta_dt_end":
            //if(formObject.sch_tp[0].checked == true) {return;}
            formObject.sch_tp[1].checked = true;
            var cal = new ComCalendarFromTo();
            cal.select(formObject.vps_eta_dt_start, formObject.vps_eta_dt_end, 'yyyy-MM-dd');
            break;

        case "btn_Retrieve":
            //t2sheet1Obj.UseZipFile = true;
            //alert(t2sheet1Obj.UseZipFile);
            ComSetCookie("esm_bkg_0672_pod_cd", form.pod_cd.value);
            //if(beforetab == 0){
            //	doActionIBSheet(sheetObjects[beforetab],formObject,IBSEARCH,"","");
            //}else
            if(beforetab == 0){//Arrival Data
                doActionIBSheet(t2sheet1Obj,formObject,IBSEARCH,"","");
            }else if(beforetab == 1){//Customer
                doActionIBSheet(t3sheet1Obj,formObject,IBSEARCH,"","");
            }else if(beforetab == 2){//Upload_Match
                doActionIBSheet(t4sheet1Obj,formObject,IBSEARCH,"","");
            }
            //doActionIBSheet(sheetObj,formObj,sAction,CondParam,PageNo)
            break;

        case "btn_DownExcel":
            //if(beforetab == 0){
            //doActionIBSheet(sheetObjects[beforetab],formObject,IBDOWNEXCEL,"","");
            //}else
            if(beforetab == 0){
                //doActionIBSheet(t2sheet1Obj,formObject,IBDOWNEXCEL,"","");
                //t2sheet1Obj.Down2Excel(true,false,true);//열린 탭에 따라 엑셀다운로드
				t2sheet1Obj.SpeedDown2Excel(-1);
            }else if(beforetab == 1){
                //doActionIBSheet(t2sheet1Obj,formObject,IBDOWNEXCEL,"","");
                //t3sheet1Obj.Down2Excel(true,false,true);//열린 탭에 따라 엑셀다운로드
				t3sheet1Obj.SpeedDown2Excel(-1);
            }else if(beforetab == 2){
                //doActionIBSheet(t2sheet1Obj,formObject,IBDOWNEXCEL,"","");
                t4sheet1Obj.ExcelPrint("App");
                t4sheet1Obj.Down2Excel(true,false,true);//열린 탭에 따라 엑셀다운로드
            }
            break;

        case "btn_Save":
            //if(beforetab == 0){
            //	doActionIBSheet(sheetObjects[beforetab],formObject,IBSAVE,"","");
            //}else
            if(beforetab == 0){
                doActionIBSheet(t2sheet1Obj,formObject,IBSAVE,"","");
            }else if(beforetab == 1){//Customer
                doActionIBSheet(t3sheet1Obj,formObject,IBSAVE,"","");
            }else if(beforetab == 2){//Upload_Match
                doActionIBSheet(t4sheet1Obj,formObject,IBSAVE,"","");
            }
            break;


        case "btn_ANSend":
            //0381로 이동 개발중
            fncANSendClick();

            break;


        /*****  TAB  Arrival Data (S)     *****/

        case "btn_t2selectAll":
            t2sheet1Obj.CheckAll(t2sheet1Obj.SaveNameCol("t2sheet1_Chk")) = 1;
            break;

        case "btn_t2deSelectAll":
            t2sheet1Obj.CheckAll(t2sheet1Obj.SaveNameCol("t2sheet1_Chk")) = 0;
            break;

        case "btn_t2cus":
            //0052로 분기
            //vvd값을 가져감
            fncT2CustomerInfoClick();
            break;

        case "btn_t2set":
            //0243으로 분기
            fncT2SetDataClick();
            break;

        //case "btn_t2rtn":
        //    alert("btn_t2rtn");
        //    break;

        /*****     TAB  Arrival Data (E)     *****/

        /*****  TAB  Customer (S)     *****/

        case "btn_t3cust":
            //0243로 분기
            //vvd값을 가져감
            fncT3CustomerInfoClick();
            break;

        case "btn_t3multi_contact":
            //<8.13>1044 으로 연결
            fncT3MultiContact();
            break;

        case "btn_t3master":
            fncT3MasterDataClick();
            break;

        /*****  TAB  Customer (E)     *****/



        /*****  TAB  Upload & Match Date (S)     *****/
        case "btn_t4downExcel":
            t4sheet1Obj.Down2Excel(true);//열린 탭에 따라 엑셀다운로드
            break;

        case "btn_t4uploadExcel":
            t4sheet1Obj.LoadExcel(-1,1,"",-1,-1,"",false);
            break;

        /*****  TAB  Upload & Match Date (E)     *****/

        case "btn_code_validate":
            var goUrl = "";
            var param = "";
            goUrl = "/hanjin/ESM_BKG_1054.do?";


            param += "1=1";
            //param += "&" + "bl_no="+clickBlNo;
            param += "&" + FormQueryString(document.form);
            param += "&pgmNo=ESM_BKG_1054-1";
            param += "&autoSearchFlg=N";

            //선택되지 않을경우는 No Action
            //location.href=goUrl + param;
            ComOpenWindowCenter(goUrl + param, "ESM_BKG_1054_01", 1024, 678, true);
            break;

        case "btn_template":

            var goUrl = "";
            var param = "";
            goUrl = "/hanjin/ESM_BKG_0375.do?";

            param += "1=1";
            param += "&pgmNo=ESM_BKG_0375&autoSearchFlg=Y";

            //선택되지 않을경우는 No Action
            //location.href=goUrl + param;
            ComOpenWindowCenter(goUrl + param,"ESM_BKG_0375",1024,620,true);

            break;


    } // end switch
//}catch(e) {
//    if( e == "[object Error]") {
//        ComShowMessage(OBJECT_ERROR);
//    } else {
//        ComShowMessage(e);
//    }
//}
}

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){

    //sheetObjects[sheetCnt++] = sheet_obj;
    //sheetObjects[sheetCnt++] = sheet_obj;
    sheetObjects[sheet_obj.id] = sheet_obj;

}



/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

    var formObj = document.form;

    for(i=0;i<sheetNames.length;i++){

        //khlee-시작 환경 설정 함수 이름 변경
        ComConfigSheet (sheetObjects[sheetNames[i]] );

        initSheet(sheetObjects[sheetNames[i]] ,i+1);
        //khlee-마지막 환경 설정 함수 추가
        ComEndConfigSheet(sheetObjects[sheetNames[i]] );

    //doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
    }




    for(k=0;k<tabObjects.length;k++){
        initTab(tabObjects[k],k+1);
    }

    if(parPgmNo == "ESM_BKG_0672-02"){
        tabObjects[0].selectedIndex = 1;
    }else if(parPgmNo == "ESM_BKG_0672-03"){
        tabObjects[0].selectedIndex = 2;
    }


    loadPageCnt = 1;

    initControl();
    initMail();

    if(parAutoSearchFlg != ""){
        formObj.vvd.value = parVvd;
        formObj.vps_eta_dt_start.value = parVpsEtaDtStart;
        formObj.vps_eta_dt_end.value = parVpsEtaDtEnd;
        formObj.pod_cd.value = parPodCd;
        formObj.del_cd.value = parDelCd;
		formObj.pol_cd.value = parPolCd;
        formObj.bl_no.value = parBlNo;
		formObj.cust_cnt_cd.value = parCustCntCd;
		formObj.cust_seq.value = parCustSeq;
		formObj.cust_nm.value = parCustNm;
		formObj.cust_ref_no.value = parCustRefNo;
		formObj.s_no.value = parSNo;
		formObj.c_no.value = parCNo;
		if(parTsFlg == "Y"){
            formObj.ts_flg.checked = true;
        }
    }else{
        //초기화시 VVD 포커스
        formObj.vvd.focus();
    }






    // 자동조회일 경우 아래를 동작한다. (따라서 load Page의 맨 아래에 있어야 한다.)
    if (parAutoSearchFlg == "Y" ) {

        document.getElementById("btn_Retrieve").fireEvent("onclick");
    }




}


/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {

    var sheetID = sheetObj.id;

    var cnt = 0;

    switch(sheetID) {

        //----------------------------------------
        // Arrival Data
        //----------------------------------------
        case "t2sheet1":      // t2sheet1 init
            with (sheetObj) {
                // 높이 설정
                style.height = 292;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msAll;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 3, 100);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(31, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false,false)

                var HeadTitle = "||Seq.|VVD|B/L No.|D/T|CNTR\nType|DEL|HUB|Location\nof Good|POD ETA|DEL ETA|Available Date";
                HeadTitle    += "|Last Free\nto Pick Up|POD\nFIRMS|P/Up\nCY/CFS|P/Up\nFIRMS|Return\nCY|Form|Agent|Remark|Vessel\nFlag"
                HeadTitle    +=	"|is_validated|bkg_no|vsl_cd|skd_voy_no|skd_dir_cd|vsl_nm|ntc_rvis_flg|pod_cd|vsl_flg_cnt_nm";


                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);


                var prefix = "t2sheet1_";

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE              ,        SAVENAME               ,     KEYFIELD,     CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,    30,        daCenter,    false,        prefix +"ibflag");
                InitDataProperty(0, cnt++ , dtHidden,          20,        daCenter,    false,        prefix + "Chk",            false,        "",    dfNone,        0,        true,         true);
                InitDataProperty(0, cnt++ , dtData,            30,        daCenter,    true,         prefix + "seq",            false,        "",    dfNone,        0,        false,        false,		0,		false,		false);
                InitDataProperty(0, cnt++ , dtData,            100,       daCenter,    false,        prefix + "vvd",            false,        "",    dfNone,        0,        false,        false);
                InitDataProperty(0, cnt++ , dtData,            100,       daCenter,    false,        prefix + "bl_no",          false,        "",    dfNone,        0,        false,        false);
                InitDataProperty(0, cnt++ , dtData,            30,        daCenter,    false,        prefix + "de_term_cd",     false,        "",    dfNone,        0,        false,        false);
                InitDataProperty(0, cnt++ , dtData,            60,        daCenter,    false,        prefix + "cntr_type",      false,        "",    dfNone,        0,        false,        false);
                InitDataProperty(0, cnt++ , dtData,            60,        daCenter,    false,        prefix + "del_cd",         false,        "",    dfNone,        0,        false,        false);
                InitDataProperty(0, cnt++ , dtData,            60,        daCenter,    false,        prefix + "hub_loc_cd",     false,        "",    dfNone,        0,        false,        false);
                InitDataProperty(0, cnt++ , dtData,            130,       daCenter,    false,        prefix + "loc_good",       false,        "",    dfNone,        0,        false,        false);
                InitDataProperty(0, cnt++ , dtData,            95,        daCenter,    false,        prefix + "pod_arr_dt",     false,        "",    dfUserFormat2, 0,        false,        false);
                InitDataProperty(0, cnt++ , dtData,            95,        daCenter,    false,        prefix + "del_arr_dt",     false,        "",    dfUserFormat2, 0,        false,        false);
                InitDataProperty(0, cnt++ , dtData,            95,        daCenter,    false,        prefix + "pkup_aval_dt",   false,        "",    dfUserFormat2, 0,        false,        false);

                InitDataProperty(0, cnt++ , dtData,            95,        daCenter,    false,        prefix + "pkup_free_dt",   false,        "",    dfUserFormat2, 0,        false,        false);
                InitDataProperty(0, cnt++ , dtData,            60,        daCenter,    false,        prefix + "pod_firms",      false,        "",    dfNone,        0,        false,        false);
                InitDataProperty(0, cnt++ , dtData,            60,        daCenter,    false,        prefix + "pkup_yd_cd",     false,        "",    dfNone,        0,        false,        false);
                InitDataProperty(0, cnt++ , dtData,            60,        daCenter,    false,        prefix + "pkup_firms",     false,        "",    dfNone,        0,        false,        false);
                InitDataProperty(0, cnt++ , dtData,            60,        daCenter,    false,        prefix + "rtn_yd_cd",      false,        "",    dfNone,        0,        false,        false);
                InitDataProperty(0, cnt++ , dtCombo,           80,        daCenter,    false,        prefix + "an_fom_cd",      false,        "",    dfNone,        0,        true,         false);
                InitDataProperty(0, cnt++ , dtData,            80,        daCenter,    false,        prefix + "chn_agn_cd",     false,        "",    dfNone,        0,        true,         false,2);
                InitDataProperty(0, cnt++ , dtData,            120,       daLeft,      false,        prefix + "diff_rmk",       false,        "",    dfNone,        0,        false,        false);
                InitDataProperty(0, cnt++ , dtData,            45,        daCenter,    false,        prefix + "vsl_flg",        false,        "",    dfNone,        0,        false,        false);

                InitDataProperty(0, cnt++ , dtHidden,          80,        daCenter,    false,        prefix + "is_validated",   false,        "",    dfNone,        0,        false,        false);
                InitDataProperty(0, cnt++ , dtHidden,          80,        daCenter,    false,        prefix + "bkg_no",         false,        "",    dfNone,        0,        false,        false);
                InitDataProperty(0, cnt++ , dtHidden,          80,        daCenter,    false,        prefix + "vsl_cd",         false,        "",    dfNone,        0,        false,        false);
                InitDataProperty(0, cnt++ , dtHidden,          80,        daCenter,    false,        prefix + "skd_voy_no",     false,        "",    dfNone,        0,        false,        false);
                InitDataProperty(0, cnt++ , dtHidden,          80,        daCenter,    false,        prefix + "skd_dir_cd",     false,        "",    dfNone,        0,        false,        false);
                InitDataProperty(0, cnt++ , dtHidden,          80,        daCenter,    false,        prefix + "vsl_nm",         false,        "",    dfNone,        0,        false,        false);
                InitDataProperty(0, cnt++ , dtHidden,          80,        daCenter,    false,        prefix + "ntc_rvis_flg",   false,        "",    dfNone,        0,        false,        false);
                InitDataProperty(0, cnt++ , dtHidden,          80,        daCenter,    false,        prefix + "pod_cd",         false,        "",    dfNone,        0,        false,        false);
                InitDataProperty(0, cnt++ , dtHidden,          80,        daCenter,    false,        prefix + "vsl_flg_cnt_nm", false,        "",    dfNone,        0,        false,        false);


                InitDataCombo(0,   prefix + "an_fom_cd", "General|Door|CY|CFS Cargo|Special Cargo|Event", "GE|DR|CY|CF|SP|E1");

                InitUserFormat2(0, prefix + "pod_arr_dt", "####-##-## ##:##", "-|:" );
                InitUserFormat2(0, prefix + "del_arr_dt", "####-##-## ##:##", "-|:" );
                InitUserFormat2(0, prefix + "pkup_aval_dt", "####-##-## ##:##", "-|:" );
                InitUserFormat2(0, prefix + "pkup_free_dt", "####-##-##", "-|:" );


                InitDataValid(0, prefix + "chn_agn_cd", vtEngUpOther, "*");

                //CountFormat           = "[SELECTDATAROW / TOTALROWS]";
                CountPosition = 0;
                AutoRowHeight = false;
                MultiSelection = true;
                SelectionMode  = smSelectionList;

                WaitImageVisible = false;

                }
            break;

        //----------------------------------------
        // Customer
        //----------------------------------------
        case "t3sheet1":      // t3sheet1 init
            with (sheetObj) {
                // 높이 설정
                style.height = 298;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(2, 1, 3, 100);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(33, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false,false)

                var HeadTitle1 = "|Seq.|Chg Term|Chg|B/L No.|C/N|A.NF|S/C No.|DEL|Eval.|Date \nSet|Customer \nCode|Customer Name (B/L)|Customer Address(B/L)";
                HeadTitle1     += "|Fax|Fax|Fax|Fax|Fax|Fax";
                HeadTitle1     += "|E-mail|E-mail|E-mail|E-mail|E-mail|E-mail";
                HeadTitle1     += "|is_validated";

                var HeadTitle2 = "|Seq.|Chg Term|Chg|B/L No.|C/N|A.NF|S/C No.|DEL|Eval.|Date \nSet|Customer \nCode|Customer Name (B/L)|Customer Address(B/L)";
                HeadTitle2     += "|CNEE/NTFY IN B/L|CNEE/NTFY|CNEE/NTFY #2|BROKER #1|BROKER #2|One Time Only";
                HeadTitle2     += "|CNEE/NTFY IN B/L|CNEE/NTFY|CNEE/NTFY #2|BROKER #1|BROKER #2|One Time Only";
                HeadTitle2     += "|is_validated";


                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                InitHeadRow(1, HeadTitle2, true);

                var Status = 0;


                var prefix = "t3sheet1_";

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,    0,            daCenter,    false,       prefix+"ibflag");
                //InitDataProperty(0, cnt++ , dtCheckBox,        20,        daCenter,    true,        prefix + "Chk",            false,        "",    dfNone,        0,        true,        true);
                InitDataProperty(0, cnt++ , dtDataSeq,         30,				daCenter,    true,       prefix + "Seq",            false,        "",    dfNone,        0,        false,        false,		0,		false,		false);
                InitDataProperty(0, cnt++ , dtData,			   60,			   daCenter,	true,	     prefix + "frt_term_cd", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++ , dtCheckBox,        40,              daCenter,    true,        prefix+"chg_dp_flg",                  false,        "",    dfNone,        0,        true,        false);

                //InitDataProperty(0, cnt++ , dtCheckBox,	40,			daCenter,		true,	             prefix + "chg_dp_flg",				false,          "",      dfNone,			0,     true,       true,-1,false,true,"Charge");
                InitDataProperty(0, cnt++ , dtData,            100,             daCenter,    true,        prefix+"bl_no",                   false,        "",    dfNone,        0,        false,        false);
                InitDataProperty(0, cnt++ , dtCombo,           30,              daCenter,    true,        prefix+"bkg_cust_tp_cd",                   false,        "",    dfNone,        0,        false,        false);
                InitDataProperty(0, cnt++ , dtData,            30,             daCenter,    true,        prefix+"is_an",                   false,        "",    dfNone,        0,        false,        false);
                InitDataProperty(0, cnt++ , dtData,            100,             daCenter,    true,        prefix+"sc_no",                   false,        "",    dfNone,        0,        false,        false);
                InitDataProperty(0, cnt++ , dtData,            50,				daCenter,    true,        prefix+"del_cd",           false,        "",    dfNone,        0,        false,        false);

                InitDataProperty(0, cnt++ , dtData,            40,              daCenter,    true,        prefix+"evaluation_yn",               false,        "",    dfNone,        0,        false,        false);
                InitDataProperty(0, cnt++ , dtData,            40,				daCenter,    true,        prefix+"vsl_info_set_flg",            false,        "",    dfNone,        0,        false,        false);
                InitDataProperty(0, cnt++ , dtData,            80,				daLeft,      true,        prefix+"cust_cd",						false,        "",    dfNone,        0,        false,        false);
                false,        false
                InitDataProperty(0, cnt++ , dtData,            180,				daLeft,      true,        prefix+"cust_nm",						false,        "",    dfNone,        0,        false,        false);
                InitDataProperty(0, cnt++ , dtData,            180,				daLeft,		true,		  prefix+"cust_addr",					false,        "",    dfNone,        0,        false,        false);

                InitDataProperty(0, cnt++ , dtData,            110,				daLeft,    true,        prefix+"cust_fax_no",					false,        "",    dfNone,        0,        false,         false);
                InitDataProperty(0, cnt++ , dtData,            100,				daLeft,    true,        prefix+"fax1",						false,        "",    dfNone,        0,        true,         true);
                InitDataProperty(0, cnt++ , dtData,            100,				daLeft,    true,        prefix+"fax2",               false,        "",    dfNone,        0,        true,         true);
                InitDataProperty(0, cnt++ , dtData,            100,				daLeft,    true,        prefix+"fax3",            false,        "",    dfNone,        0,        true,         true);
                InitDataProperty(0, cnt++ , dtData,            100,             daLeft,    true,        prefix+"fax4",                false,        "",    dfNone,        0,        true,        true);

                InitDataProperty(0, cnt++ , dtData,            100,				daLeft,    true,        prefix+"fax5",              false,        "",    dfNone,        0,        true,         true);
                InitDataProperty(0, cnt++ , dtData,            100,				daLeft,    true,        prefix+"cust_eml",            false,        "",    dfNone,        0,        false,         false);
                InitDataProperty(0, cnt++ , dtData,            100,				daLeft,    true,        prefix+"eml1",           false,        "",    dfNone,        0,        true,         true);
                InitDataProperty(0, cnt++ , dtData,            100,				daLeft,    true,        prefix+"eml2",        false,        "",    dfNone,        0,        true,         true);
                InitDataProperty(0, cnt++ , dtData,            100,           daLeft,    true,        prefix+"eml3",              false,        "",    dfNone,        0,        true,         true);

                InitDataProperty(0, cnt++ , dtData,            100,          daLeft,    true,        prefix+"eml4",             false,        "",    dfNone,        0,        true,         true);
                InitDataProperty(0, cnt++ , dtData,            100,          daLeft,    true,        prefix+"eml5",             false,        "",    dfNone,        0,        true,         true);
                InitDataProperty(0, cnt++ , dtHidden,            100,          daCenter,    true,        prefix+"is_validated",             false,        "",    dfNone,        0,        true,         true);

                InitDataProperty(0, cnt++ , dtHidden,            100,          daCenter,    true,        prefix+"bkg_no",             false,        "",    dfNone,        0,        true,         true);
                InitDataProperty(0, cnt++ , dtHidden,            100,          daCenter,    true,        prefix+"is_validated",             false,        "",    dfNone,        0,        true,         true);
                InitDataProperty(0, cnt++ , dtHidden,            100,          daCenter,    true,        prefix+"vvd",             false,        "",    dfNone,        0,        true,         true);
                InitDataProperty(0, cnt++ , dtHidden,            100,          daCenter,    true,        prefix+"cust_cnt_cd",             false,        "",    dfNone,        0,        true,         true);
                InitDataProperty(0, cnt++ , dtHidden,            100,          daCenter,    true,        prefix+"cust_seq",             false,        "",    dfNone,        0,        true,         true);
                InitDataProperty(0, cnt++ , dtHidden,            100,          daCenter,    true,        prefix+"ib_cmdt_flg",             false,        "",    dfNone,        0,        true,         true);
                //InitDataProperty(0, cnt++ , dtPopup,           Remark,            daCenter,    true,        "Remark",               false,        "",    dfNone,        0,        true,         true);

                InitDataValid(0, prefix + "fax1", vtNumericOther, "-,");
                InitDataValid(0, prefix + "fax2", vtNumericOther, "-,");
                InitDataValid(0, prefix + "fax3", vtNumericOther, "-,");
                InitDataValid(0, prefix + "fax4", vtNumericOther, "-,");
                InitDataValid(0, prefix + "fax5", vtNumericOther, "-,");



                InitDataCombo(0, prefix+"bkg_cust_tp_cd", "CN|NF", "C|N");



                Ellipsis = true;
                WordWrap = false;

                //CountPosition = 0;
                AutoRowHeight = false;

                WaitImageVisible = false;

                }
            break;

        //----------------------------------------
        // Upload & Match
        //----------------------------------------
        case "t4sheet1":      // t4sheet1 init
            with (sheetObj) {
                // 높이 설정
                style.height = 300;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(2, 1, 3, 100);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(13, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false)

                var HeadTitle1  = "|Seq.|B/L|B/L";
                HeadTitle1 += "|Customer|Customer";
                HeadTitle1 += "|Broker/Husbanding Agent #1|Broker/Husbanding Agent #1";
                HeadTitle1 += "|Broker/Husbanding Agent #2|Broker/Husbanding Agent #2";
                HeadTitle1 += "|Hidden|Hidden|Hidden";

                var HeadTitle2 = "|Seq.|B/L No.|Name";
                HeadTitle2 +=  "|Fax|E-mail";
                HeadTitle2 +=  "|Fax|E-mail";
                HeadTitle2 +=  "|Fax|E-mail";
                HeadTitle2 +=  "|bkg_no|bkg_cust_tp_cd";
                HeadTitle2 +=  "|is_validated";



                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                InitHeadRow(1, HeadTitle2, false);

                var prefix = "t4sheet1_";
                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,    Status,            daCenter,    false,       prefix+"ibflag");
                InitDataProperty(0, cnt++ , dtDataSeq,         30,       daCenter,    true,       prefix + "Seq",            false,        "",    dfNone,        0,        false,        false,		0,		false,		false);
                InitDataProperty(0, cnt++ , dtData,            100,       daCenter,    true,       prefix +  "bl_no",            false,        "",    dfNone,        0,        false,       false);
                InitDataProperty(0, cnt++ , dtData,            180,      daLeft,    true,        prefix + "cust_nm",      false,        "",    dfNone,        0,        false,       false);
                InitDataProperty(0, cnt++ , dtData,            130,      daLeft,      true,        prefix + "fax_no1",          false,        "",    dfNone,        0,        true,       true);

                InitDataProperty(0, cnt++ , dtData,            130,      daLeft,      true,        prefix + "ntc_eml1",         false,        "",    dfNone,        0,        true,        true);
                InitDataProperty(0, cnt++ , dtData,            130,       daCenter,    true,        prefix + "fax_no2",          false,        "",    dfNone,        0,        true,        true);
                InitDataProperty(0, cnt++ , dtData,            130,      daLeft,      true,        prefix + "ntc_eml2",         false,        "",    dfNone,        0,        true,        true);
                InitDataProperty(0, cnt++ , dtData,            130,       daCenter,    true,        prefix + "fax_no3",       false,        "",    dfNone,        0,        true,        true);
                InitDataProperty(0, cnt++ , dtData,            130,      daLeft,      true,        prefix + "ntc_eml3",      false,        "",    dfNone,        0,        true,        true);

                InitDataProperty(0, cnt++ , dtHidden,            130,      daLeft,      true,        prefix + "bkg_no",      false,        "",    dfNone,        0,        true,        true);
                InitDataProperty(0, cnt++ , dtHidden,            130,      daLeft,      true,        prefix + "bkg_cust_tp_cd",      false,        "",    dfNone,        0,        true,        true);
                InitDataProperty(0, cnt++ , dtHidden,            100,          daCenter,    true,        prefix+"is_validated",             false,        "",    dfNone,        0,        true,         true);

                InitDataValid(0, prefix + "fax_no1", vtNumericOther, "-,");
                InitDataValid(0, prefix + "fax_no2", vtNumericOther, "-,");
                InitDataValid(0, prefix + "fax_no3", vtNumericOther, "-,");

                //CountPosition = 0;
                Ellipsis = true;
                AutoRowHeight = false;

                WaitImageVisible = false;

                }
            break;

        case "t4sheet2":      // t4sheet2 init
            with (sheetObj) {
                // 높이 설정
                style.height = 302;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(2, 1, 3, 100);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(13, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false)

                var HeadTitle1  = "| |B/L|B/L";
                HeadTitle1 += "|Customer|Customer";
                HeadTitle1 += "|Broker/Husbanding Agent #1|Broker/Husbanding Agent #1";
                HeadTitle1 += "|Broker/Husbanding Agent #2|Broker/Husbanding Agent #2";

                var HeadTitle2 = "| |B/L No.|Name";
                HeadTitle2 +=  "|Fax|E-mail";
                HeadTitle2 +=  "|Fax|E-mail";
                HeadTitle2 +=  "|Fax|E-mail";



                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                InitHeadRow(1, HeadTitle2, false);

                var prefix = "t4sheet2_";
                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,    Status,            daCenter,    false,       prefix+"ibflag");
                InitDataProperty(0, cnt++ , dtDataSeq,         30,       daCenter,    true,       prefix + "Seq");
                InitDataProperty(0, cnt++ , dtData,            95,       daCenter,    true,       prefix +  "bl_no",            false,        "",    dfNone,        0,        false,       false);
                InitDataProperty(0, cnt++ , dtData,            130,      daLeft,    true,        prefix + "cust_nm",      false,        "",    dfNone,        0,        false,       false);
                InitDataProperty(0, cnt++ , dtData,            130,      daLeft,      true,        prefix + "fax_no1",          false,        "",    dfNone,        0,        true,       true);

                InitDataProperty(0, cnt++ , dtData,            130,      daLeft,      true,        prefix + "ntc_eml1",         false,        "",    dfNone,        0,        true,        true);
                InitDataProperty(0, cnt++ , dtData,            75,       daCenter,    true,        prefix + "fax_no2",          false,        "",    dfNone,        0,        true,        true);
                InitDataProperty(0, cnt++ , dtData,            130,      daLeft,      true,        prefix + "ntc_eml2",         false,        "",    dfNone,        0,        true,        true);
                InitDataProperty(0, cnt++ , dtData,            75,       daCenter,    true,        prefix + "fax_no3",       false,        "",    dfNone,        0,        true,        true);
                InitDataProperty(0, cnt++ , dtData,            130,      daLeft,      true,        prefix + "ntc_eml3",      false,        "",    dfNone,        0,        true,        true);

                InitDataProperty(0, cnt++ , dtHidden,            130,      daLeft,      true,        prefix + "bkg_no",      false,        "",    dfNone,        0,        true,        true);
                InitDataProperty(0, cnt++ , dtHidden,            130,      daLeft,      true,        prefix + "bkg_cust_tp_cd",      false,        "",    dfNone,        0,        true,        true);
                InitDataProperty(0, cnt++ , dtHidden,            100,          daCenter,    true,        prefix+"is_validated",             false,        "",    dfNone,        0,        true,         true);

                CountPosition = 0;

                InitDataValid(0, prefix + "fax_no1", vtNumericOther, "-,");
                InitDataValid(0, prefix + "fax_no2", vtNumericOther, "-,");
                InitDataValid(0, prefix + "fax_no3", vtNumericOther, "-,");

                }
            break;


    }
}
var startDate;
var resultMsg;
// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction,CondParam,PageNo) {
    ////sheetObj.ShowDebugMsg = true;

    switch(sAction) {

        case IBSEARCH:      //조회



            if(validateForm(sheetObj,formObj,sAction)){

                //-------------------------------------
                // Arrival Data
                //-------------------------------------
                if ( sheetObj.id == "t2sheet1"){
                    startDate = new Date();
                    resultMsg = "";

                    //헤더행을 제외한 모든 데이터를 지운다.
                    formObj.f_cmd.value = SEARCH02;
                    //var addParam = "&cust_cnt_cd="+formObj.cust_cnt_cd_ib.value+"&cust_seq="+formObj.cust_seq_ib.value;
                    //alert(addParam);
                    //formObj.page_no.value = PageNo;

                    //alert("is_validated " + formObj.is_validated.value);return;
                    //ComOpenWait(true);
                    //sheetObjects["t2sheet1"].WaitImageVisible = false;
                    if(formObj.sch_tp[0].checked){
                        formObj.sch_tp.value = "V";
                    }else if(formObj.sch_tp[1].checked){
                        formObj.sch_tp.value = "D";
                    }else if(formObj.sch_tp[2].checked){
                        formObj.sch_tp.value = "B";
                    }

                    //alert("sch_tp         " + formObj.sch_tp.value);
                    //alert("pod_cd         " + formObj.pod_cd.value);
                    //alert("ts_flg         " + formObj.ts_flg.value);

                    //return;
					ComOpenWait(true);
                    sheetObj.DoSearch("ESM_BKG_0672GS.do"
                        ,FormQueryString(formObj)
                        + "&"
                        + ComGetPrefixParam("t2sheet1_")
                        );


                }
                else if ( sheetObj.id == "t3sheet1"){
                    //헤더행을 제외한 모든 데이터를 지운다.
                    formObj.f_cmd.value = SEARCH03;
                    //var addParam = "&cust_cnt_cd="+formObj.cust_cnt_cd_ib.value+"&cust_seq="+formObj.cust_seq_ib.value;
                    //alert(addParam);
                    //formObj.page_no.value = PageNo;
					ComOpenWait(true);
                    sheetObj.DoSearch("ESM_BKG_0672GS.do"
                        ,FormQueryString(formObj)
                        + "&"
                        + ComGetPrefixParam("t3sheet1_")

                        );
                }
                else if ( sheetObj.id == "t4sheet1"){
                    //헤더행을 제외한 모든 데이터를 지운다.

                    formObj.f_cmd.value = SEARCH04;
                    //var addParam = "&cust_cnt_cd="+formObj.cust_cnt_cd_ib.value+"&cust_seq="+formObj.cust_seq_ib.value;
                    //alert(addParam);
                    //formObj.page_no.value = PageNo;
					ComOpenWait(true);
                    sheetObj.DoSearch("ESM_BKG_0672GS.do"
                        ,FormQueryString(formObj)
                        + "&"
                        + ComGetPrefixParam("t4sheet1_")

                        );
                }
            }

            break;

        case IBSAVE:        //저장

            if ( sheetObj.id == "t2sheet1"){
                var prefix = "t2sheet1_";

                formObj.f_cmd.value = MULTI02;


                //var addParam = "&cust_cnt_cd="+formObj.cust_cnt_cd_ib.value+"&cust_seq="+formObj.cust_seq_ib.value;
                //if(validateForm(sheetObj,formObj,sAction)){

                var sParam = FormQueryString(formObj);
                sparam = sParam + "&" + ComGetPrefixParam("t2sheet1_");



                //2010.01.19
                //저장시에 모든 데이터를 넘겨 저장하도록 변경.
                //변경전

                /*******************************************************************
                    if(! sheetObj.IsDataModified){
						 //alert("Nothing has been changed after data is retrieved ");
                    	 ComShowCodeMessage('BKG00797');
                         return false;
                    }
                    sheetObj.DoSave("ESM_BKG_0672GS.do", sparam);
					********************************************************************/


                //변경후
				ComOpenWait(true);
                sheetObj.DoAllSave("ESM_BKG_0672GS.do", sparam);





            //}

            }else if ( sheetObj.id == "t3sheet1"){

                formObj.f_cmd.value = MULTI03;


                //var addParam = "&cust_cnt_cd="+formObj.cust_cnt_cd_ib.value+"&cust_seq="+formObj.cust_seq_ib.value;
                //if(validateForm(sheetObj,formObj,sAction)){

                var sParam = FormQueryString(formObj);

                sparam = sParam + "&" + ComGetPrefixParam("t3sheet1_");

                if(! sheetObj.IsDataModified){
                    //alert("Nothing has been changed after data is retrieved ");
                    ComShowCodeMessage('BKG00797');
                    return false;
                }
				ComOpenWait(true);
				sParam = sParam + "&" + sheetObj.GetSaveString(false, true);
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0672GS.do", sParam);
			    //sheetObj.DoSave("ESM_BKG_0672GS.do", sparam);
			    var key = ComGetEtcData(sXml, "KEY");

			    intervalId = setInterval("doActionValidationResult(sheetObjects['" + "t3sheet1" + "'], '" + key + "');", 3000);//sheetObjects['" + "t3sheet1" + "']


            }else if ( sheetObj.id == "t4sheet1"){

                formObj.f_cmd.value = MULTI04;


                //var addParam = "&cust_cnt_cd="+formObj.cust_cnt_cd_ib.value+"&cust_seq="+formObj.cust_seq_ib.value;
                //if(validateForm(sheetObj,formObj,sAction)){

                var sParam = FormQueryString(formObj);

                sparam = sParam + "&" + ComGetPrefixParam("t4sheet1_");


                if(! sheetObj.IsDataModified){
                    //alert("Nothing has been changed after data is retrieved ");
                    ComShowCodeMessage('BKG00797');
                    return false;
                }
				ComOpenWait(true);
                sheetObj.DoSave("ESM_BKG_0672GS.do", sparam);
            //}

            }
            break;

        case IBINSERT:      // 입력
            break;
        case IBSEARCHAPPEND:

            break;
        case IBDOWNEXCEL:   // EXCEL 다운로드
            if (queryStrChange == true) {
                ComShowCodeMessage("BKG03053");
                return;
            }

            break;

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
                //InsertTab( cnt++ , "Code Validation" , -1 );
                InsertTab( cnt++ , "Arrival Data" , -1 );
                InsertTab( cnt++ , "Customer" , -1 );
                InsertTab( cnt++ , "Upload & Match" , -1 );

                }
            break;

    }
}

function tab1_OnClick(tabObj, tabIndex){




    if(sheetObjects["t2sheet1"].IsDataModified){
        //alert("변경된 Data가 있습니다. 저장해주십시오.");
        ComShowCodeMessage("BKG00986");
        tabObj.selectedIndex = 0;
    }else if(sheetObjects["t3sheet1"].IsDataModified){
        //alert("변경된 Data가 있습니다. 저장해주십시오.");
        ComShowCodeMessage("BKG00986");
        tabObj.selectedIndex = 0;
    }else if(sheetObjects["t4sheet1"].IsDataModified){
        //alert("변경된 Data가 있습니다. 저장해주십시오.");
        ComShowCodeMessage("BKG00986");
        tabObj.selectedIndex = 0;
    }

}

/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 */

function tab1_OnChange(tabObj , nItem)
{

    //beforetab == 0 ; Arrival Data
    //beforetab == 1 ; Customer

    //	if(beforetab == 0 && nItem != 0){
    //		//탭 이동시 Sheet 의 수정정보를 체크.
    //		if(sheetObjects["t2sheet1"].IsDataModified){
    //			//alert("변경된 Data가 있습니다. 저장해주십시오.");
    //			ComShowCodeMessage("BKG00986");
    //			tabObj.selectedIndex = 0;
    //			beforetab = 1;
    //			nItem = 0;
    //
    //		}
    //	}

    var objs = document.all.item("tabLayer");

    objs[nItem].style.display = "Inline";
    objs[beforetab].style.display = "none";

    /*
         if(nItem==0 &&tabLoad[0]!=1)
            frameLayer0.document.location = 'tab1.jsp?frame=Tab1';
        else if(nItem==1 &&tabLoad[1]!=1)
            frameLayer1.document.location = 'tab3.jsp?frame=Tab2';
    */


    //--------------- 요기가 중요 --------------------------//
    objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    //------------------------------------------------------//
    beforetab= nItem;

    //----------------------------------------------------
    //TAB2 선택
    //1.tab2 선택시 VVD 항목으로 focus on
    //2.이전 조회된 POD 가 있을경우 POD 출력(Cookie)이용
    //----------------------------------------------------

    if(beforetab == 2){
        ComBtnDisable("btn_DownExcel");
    }else{
        ComBtnEnable("btn_DownExcel");
    }

    if(loadPageCnt == 0) return;

    document.getElementById("btn_Retrieve").fireEvent("onclick");

}




/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
    var formObj = document.form;
    with(formObj){
        switch (sAction){
            case IBSEARCH:
                if(!ComChkValid(formObj)) return false;

                if(formObj.sch_tp[0].checked == true) {
                    // del또는 pod 둘중 하나는 반드시 입력 되어야 함
                    if(formObj.pod_cd.value == "") {
                        ComShowCodeMessage("BKG40115");
                        return false;
                    }

                    // del는 2또는 5자리만 입력 가능
                    if(formObj.del_cd.value.length > 2 && formObj.del_cd.value.length <5) {
                        ComShowCodeMessage("BKG40009");
                        ComSetFocus(formObj.del_cd);
                        return false;
                    }
                }

                if(formObj.sch_tp[1].checked == true) {
                    // del또는 pod 둘중 하나는 반드시 입력 되어야 함
                    if(formObj.pod_cd.value == "") {
                        ComShowCodeMessage("BKG40116");
                        return false;
                    }

                    // del는 2또는 5자리만 입력 가능
                    if(formObj.del_cd.value.length > 2 && formObj.del_cd.value.length <5) {
                        ComShowCodeMessage("BKG40009");
                        ComSetFocus(formObj.del_cd);
                        return false;
                    }

                }

                // Customer Code, S/C No는 하나가 있으면 같이 존재해야 함
                if( formObj.cust_cnt_cd.value.trim() != "" && formObj.cust_seq.value.trim() == "") {
                    ComShowCodeMessage("BKG03050","CUSTOMER CODE","CUSTOMER CODE");
                    ComSetFocus(formObj.cust_seq);
                    return;
                } else if( formObj.cust_seq.value.trim() != "" && formObj.cust_cnt_cd.value.trim() == "") {
                    ComShowCodeMessage("BKG03050","CUSTOMER CODE","CUSTOMER CODE");
                    ComSetFocus(formObj.cust_cnt_cd);
                    return;
                }

                if( formObj.s_no.value.trim() != "" && formObj.c_no.value.trim() == "") {
                    ComShowCodeMessage("BKG03051","S/C No","S/C No");
                    ComSetFocus(formObj.c_no);
                    return;
                } else if( formObj.c_no.value.trim() != "" && formObj.s_no.value.trim() == "") {
                    ComShowCodeMessage("BKG03051","S/C No","S/C No");
                    ComSetFocus(formObj.s_no);
                    return;
                }

                //alert(ComGetDaysBetween(formObj.vps_eta_dt_start.value,formObj.vps_eta_dt_end.value));

                if(formObj.sch_tp[0].checked
                    && formObj.vvd.value == ""){
                    ComShowCodeMessage("BKG00626","VVD");
                    ComSetFocus(formObj.vvd);
                    return false;
                }
                if(formObj.sch_tp[1].checked
                    && formObj.vps_eta_dt_start.value == ""){
                    ComShowCodeMessage("BKG00626","POD ETA");
                    ComSetFocus(formObj.vps_eta_dt_start);
                    return false;
                }
                if(formObj.sch_tp[1].checked
                    && formObj.vps_eta_dt_end.value == ""){
                    ComShowCodeMessage("BKG00626","POD ETA");
                    ComSetFocus(formObj.vps_eta_dt_end);
                    return false;
                }
                if(formObj.sch_tp[1].checked
                    && (ComGetDaysBetween(formObj.vps_eta_dt_start.value,formObj.vps_eta_dt_end.value) > 6
                        || ComGetDaysBetween(formObj.vps_eta_dt_start.value,formObj.vps_eta_dt_end.value) < 0 )
                    ){
                    ComShowCodeMessage("BKG40014", "1");
                    ComSetFocus(formObj.vps_eta_dt_end);
                    return false;
                }
                //Duration일경우 날짜 비교.
                //2009.07.21 Duration check 추가
                //if(formObj.sch_tp[1].checked
                //	&& !ComBkgMonthsBetweenCheck(formObj.vps_eta_dt_start.value,formObj.vps_eta_dt_end.value, 2)) {
                //	ComShowCodeMessage("BKG01049", "2");
                //	ComSetFocus(formObj.vps_eta_dt_end);
                //	return false;
                //}

                // 날짜 검증

                break;
            case IBSAVE:
                if(!ComChkValid(formObj)) return false;

                break;
            case IBDELETE:
                if(!ComChkValid(formObj)) return false;
                break;
        }
        }

    return true;
}





/**
 * 초기화 작업 : 이벤트를 등록한다.
 * @return
 */
function initControl() {
    //Axon 이벤트 처리1. 이벤트catch
    axon_event.addListenerForm('click', 'obj_click', form );     //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    axon_event.addListenerForm('keyup', 'obj_keyup', form );     //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
    axon_event.addListenerForm ('blur', 'obj_deactivate', form);
    axon_event.addListenerForm ('activate', 'obj_activate', form);


    // 화면 초기화 정보등을 입력한다.
    var formObj = document.form;

    if (parSchTp != null && parSchTp != "") {
        for ( var idx = 0; idx < formObj.sch_tp.length; idx ++ ) {
            if (formObj.sch_tp[idx].value == parSchTp ){
                formObj.sch_tp[idx].checked = true;
                break;
            }

        }
    }

    if (parPodCd != null && parPodCd != "") {
        formObj.pod_cd.value = parPodCd;
    } else {
        var sPodCd = ComGetCookie("esm_bkg_0672_pod_cd");
        formObj.pod_cd.value = sPodCd;
    }

    if (parVvd != null && parVvd != "") {
        formObj.vvd.value = parVvd;
        formObj.sch_tp[0].checked = true;
        fnToggleSchTp("V", formObj);  // Search type 변경
    }

    if (parDelCd != null && parDelCd != "") {
        formObj.del_cd.value = parDelCd;
    }

    if (parBlNo != null && parBlNo != "") {
        formObj.bl_no.value = parBlNo;
    }

    //alert(parEvalFlg);

    for(var k=0;k<formObj.is_validated.options.length;k++){
        if(formObj.is_validated.options[k].value == parEvalFlg){
            formObj.is_validated.options[k].selected = true;
        }
    }

    // calendar 처리

    formObj.vps_eta_dt_start.value=ComGetNowInfo('ymd','-');
    formObj.vps_eta_dt_end.value=ComGetDateAdd(null, 'd', 6, '-');


//formObj.vps_eta_dt_start.value="20080611";
//formObj.vps_eta_dt_end.value="20080611";

}

/**
 * 화면 개체에 클릭했을 때의 이벤트 처리
 * @return
 */
function obj_click() {
    var objName = event.srcElement.name;
    var formObj = document.form;

    switch(objName) {
        case "vsl_info_set_flg":
            matchUnmatchSetup();
            break;
        case "sch_tp":
            var vSchTp = "";
            for (var i=0; i<formObj.sch_tp.length; i++) {
                if (formObj.sch_tp[i].checked) {
                    vSchTp = formObj.sch_tp[i].value;
                }
            }
            formObj.sch_tp.value = vSchTp;
            fnToggleSchTp(vSchTp, formObj);
            break;
    }
}


function fnToggleSchTp (vSchTp, formObj) {
    if (vSchTp=="B") {  // BL
        document.getElementsByName("bl_no")[0].setAttribute("required", true);
        //document.getElementsByName("bl_no")[0].setAttribute("fullfill", true);
        document.getElementsByName("pod_cd")[0].removeAttribute("fullfill");
        document.getElementsByName("vvd")[0].removeAttribute("required");
        document.getElementsByName("vvd")[0].removeAttribute("fullfill");
        document.getElementsByName("vps_eta_dt_start")[0].removeAttribute("required");
        document.getElementsByName("vps_eta_dt_end")[0].removeAttribute("required");
    } else    if (vSchTp=="V") {
        document.getElementsByName("bl_no")[0].removeAttribute("required");
        //document.getElementsByName("bl_no")[0].removeAttribute("fullfill");
        document.getElementsByName("pod_cd")[0].removeAttribute("fullfill");
        document.getElementsByName("vvd")[0].setAttribute("required", true);
        document.getElementsByName("vvd")[0].setAttribute("fullfill", true);
        document.getElementsByName("vps_eta_dt_start")[0].removeAttribute("required");
        document.getElementsByName("vps_eta_dt_end")[0].removeAttribute("required");
    }else if (vSchTp=="D") {
        document.getElementsByName("bl_no")[0].removeAttribute("required");
        //document.getElementsByName("bl_no")[0].removeAttribute("fullfill");
        document.getElementsByName("pod_cd")[0].setAttribute("fullfill", true);
        document.getElementsByName("vvd")[0].removeAttribute("required");
        document.getElementsByName("vvd")[0].removeAttribute("fullfill");
        document.getElementsByName("vps_eta_dt_start")[0].setAttribute("required", true);
        document.getElementsByName("vps_eta_dt_end")[0].setAttribute("required", true);
    }
}


/**
 * 화면 개체가 변경되었을 때의 이벤트 처리
 * @return
 */
function obj_keyup() {
    var objName = event.srcElement.name;
    var formObj = document.form;
    //var form = document.form;

    // 변경이 일어나면 변경 flag를 true로 변경한다.(여기는 queryStrChange를 위한 if문처럼 사용한다. 다른 이벤트를 처리하기 위해서는 별도 switch문을 사용할 것)
    switch(objName) {
        case "sch_tp":
        case "vvd":
        case "vps_eta_dt_start":
        case "vps_eta_dt_end":
        case "pod_cd":
        case "del_cd":
        case "bl_no":
        case "cust_cnt_cd":
        case "cust_seq":
        case "cust_nm":
        case "po_no":
        case "s_no":
        case "c_no":
            queryStrChange = true;
            break;
    }
}

/**
  * Form Object가 Deactive될때 발생하는 이벤트를 처리한다.
  * @return
  */
function obj_deactivate(){
    var objName = event.srcElement.name;
    var formObj = document.form;
    switch(objName) {
        case "vps_eta_dt_start":
            ComChkObjValid(event.srcElement);
            break;
        case "vps_eta_dt_end":
            ComChkObjValid(event.srcElement);
            break;
    }
}

/**
 * Form Object가 Active될때 발생하는 이벤트를 처리한다.
 * @return
 */
function obj_activate(){
    var objName = event.srcElement.name;
    var formObj = document.form;
    //var form = document.form;
    switch(objName) {
        case "vvd":
            formObj.sch_tp[0].checked = true;
            fnToggleSchTp("V", formObj);
            break;

        case "vps_eta_dt_start":
            formObj.sch_tp[1].checked = true;
            fnToggleSchTp("D", formObj);
            formObj.vps_eta_dt_start.value = formObj.vps_eta_dt_start.value.replace(eval("/-/gi"), "");
            break;
        case "vps_eta_dt_end":
            formObj.sch_tp[1].checked = true;
            fnToggleSchTp("D", formObj);
            formObj.vps_eta_dt_end.value = formObj.vps_eta_dt_end.value.replace(eval("/-/gi"), "");
            break;
        case "bl_no":
            formObj.sch_tp[2].checked = true;
            fnToggleSchTp("B", formObj);
            break;
    }
}



/**
  * Mail정보를 초기화 한다.
  * @return
  */
function initMail() {
    var formObj = document.form;
    formObj.strUsr_nm.value = strUsr_nm;
    formObj.strUsr_email.value = strUsr_email;
    formObj.strOfc_cd.value = strOfc_cd;
}

/**
 * Groupmail을 발송한다.
 * @param sheetObj
 * @param row
 * @param col
 * @return
 */
function mailCustCodeRequest(sheetObj, row, col) {
    var formObj = document.form;
    var mailFrom = "From: " + strUsr_email;
    var mailTo = "\n To: ...USER INPUT...";
    var mailTitle = "\nTitle: Customer Code Request";
    var mailBody1 = "<br/><br/>Please, create following customer master data in CRM system.";
    var mailBody2 = "<br/>BKG No. :" + sheetObj.CellValue(row, "bkg_no") ;
    var mailBody3 = "<br/>";
    var mailBody4 = "<br/><br/>BEST REGARDS";
    var mailBody5 = "<br/>Staff: " + strUsr_nm;
    var mailBody6 = "<br/>Office: " + strOfc_cd + "<br/></br>";

    if (sheetObj.CellValue(row, "bkg_cust_tp_cd") == "C") {
        mailBody3 = mailBody3 + "Consignee";
    } else if (sheetObj.CellValue(row, "bkg_cust_tp_cd") == "N") {
        mailBody3 = mailBody3 + "Notifier";
    }

    //var mailData = mailFrom + mailTo + mailTitle + mailBody1 + mailBody2 + mailBody3 + mailBody4 + mailBody5 + mailBody6;
    formObj.gw_contents.value="";
    formObj.gw_args[0].value="name;" + strUsr_nm ;
    formObj.gw_args[1].value="message;" + mailBody1 + mailBody2 + mailBody3 + mailBody4 + mailBody5 + mailBody6;
    ComOpenGroupwareMail(sheetObj,formObj);
    //return ComShowConfirm(mailData);
    return true;
}


/**
 * 해당길이를 채울경우 다음으로 포커스 이동
 */
function fncNextFocusByMax(srcObj,maxLength,nextObj){

    if(srcObj.value.length == maxLength){
        nextObj.focus();
    }
}



/*-------------------------------------------------------------------------------------------*/
//0672_02.js 시작

/* Arrival Data */

/**
      *
      * @param sheetObj
      * @param Row
      * @param Col
      * @return
      */
function t2sheet1_OnChange(sheetObj, Row, Col, Value) {
    if(sheetObj.ColSaveName(Col) == sheetObj.id + "_" + "an_fom_cd"
        || sheetObj.ColSaveName(Col) == sheetObj.id + "_" + "diff_rmk"
        || sheetObj.ColSaveName(Col) == sheetObj.id + "_" + "chn_agn_cd"
        || sheetObj.ColSaveName(Col) == sheetObj.id + "_" + "vsl_flg"
      ){
        sheetObj.RowStatus(Row) = "U";
        t2sheet1_OnClick(sheetObj, Row, Col, Value);
    //alert("org " + sheetObj.CellValue(Row,sheetObj.SaveNameCol(sheetObj.id + "_" + "an_fom_cd"))		)
    //sheetObj.CellValue2(Row,sheetObj.SaveNameCol(sheetObj.id + "_" + "Chk")) = 1;
    }


}


//수직스크롤바가 바닥에 닿았을 때 발생하는 이벤트 Catch
function t2sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
    //    alert('scroll next');
    doActionIBSheet(sheetObj, document.form, IBSEARCH, CondParam, PageNo);
//alert("PageNo " + PageNo);
}

function t2sheet1_OnScroll(sheetObj,OlTopRow, OldLeftCol, NewTopRow, NewLeftCo) {
//alert('scroll');
}

//YYYY-MM-DD 에서 DDMONYY(DDMMMYY) 형태로의 변환
function convMM2MMM(mm){
    var mStr = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];

    mm = mm.replace('-','');
    mm = mm.replace('-','');
    var vYYYY = mm.substring(0,4);
    var vYY = mm.substring(2,4);
    var vMM = mm.substring(4,6);
    var iMM = eval(vMM);
    var vDD = mm.substring(6,8);

    var retStr = vDD + mStr[iMM-1] + vYY;

    return retStr;

}

//DDMONYY(DDMMMYY) 에서  YYYY-MM-DD형태로의 변환
function convMMM2MM(mmm){
    var mStr = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
    var iStr = ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"];

    var vYY = mmm.substring(5,7);

    var vYYYY = "20"+vYY;

    var vMMM = mmm.substring(2,5);
    for(var i=0;i<mStr.length;i++){
        if(mStr[i] == vMMM){
            vMM = iStr[i];
            break;
        }
    }

    var vDD = mmm.substring(0,2);

    var retStr = vYYYY + vMM + vDD;

    return retStr;

}

//Tab2 가 Retrieve시
function t2sheet1_retrieve(){
    var formObj = document.form;

    //1. 필수 조회 조건 입력 여부 검사    VVD or Duration로 조회 됨.
    //1. [필수 조회 조건 미입력]  :[공통 메세지] 표시하고 해당 항목으로 Focus On.
    if(formObj.sch_tp[0].checked){
        if(formObj.vvd.value == ""){
            ComShowCodeMessage("BKG00404");
            formObj.vvd.focus();
        }

    }
    if(formObj.sch_tp[1].checked){
        if(formObj.vps_eta_dt_start.value == "" || formObj.vps_eta_dt_end.value == ""){
            ComShowCodeMessage("BKG00404");
            formObj.vps_eta_dt_start.focus();
        }

    }
    //2. 날짜 포맷입력 확인 필요.
    //2. [날짜입력 포맷 검사] :[공통 메세지] 표시하고 해당 항목으로 Focus On.

    //3. 입력 날짜 기간 검사 ( To 가 From보다 적을 경우 )
    //3.[입력 날짜 기간  검사] : [BKG00156] 표시하고 해당 항목으로 Focus On."
    var sDate = convMMM2MM(formObj.vps_eta_dt_start.value);
    var eDate = convMMM2MM(formObj.vps_eta_dt_end.value);
    var check3 = ComChkPeriod(sDate,eDate);
    if(!(check3 == 1 || check3 == 2)){
        ComShowCodeMessage("BKG00156");
        formObj.vps_eta_dt_end.focus();
    }
    //
    //<EXCEPTION>




    var formObj = document.form;
    //1. 초기 상태로 설정하고 VVD 항목으로 Focus On
    formObj.vvd.focus();
    //2. Duration : Default 값은 FM는 조회일자, TO은 조회일자에서 2주 이후 일자를 Setting 해줌.
    formObj.vps_eta_dt_start.value = convMM2MMM(ComGetNowInfo());
    formObj.vps_eta_dt_end.value = convMM2MMM(ComGetDateAdd(ComGetNowInfo(),'D',14));
//3. POD: 이전 조회된 POD Code가 있을 경우 보여 짐. ( Cookie 활용 )"

}

/**
 * t2sheet1 의 데이터 조회완료시
 * @param sheetObj
 * @param ErrMsg
 * @return
 */

function t2sheet1_OnSearchEnd(sheetObj, ErrMsg){
    //1.결과 값이 없을경우 save 버튼 disable
    //is_validated 의 값에 따라 처리

    //alert("search "+sheetObj.id + "  end");
    with(sheetObj)
    {

        if(rowcount < 1){
            ComBtnDisable("btn_Save");
        }else{
            ComBtnEnable("btn_Save");
        }

        //CheckAll2("t2sheet1_Chk")  = true;

        }

    ComOpenWait(false);
//t2sheet1_OnScroll(sheetObj,1,1,1,1);
//startTimer();//검색완료후 색깔처리

//sheetObjects["t2sheet1"].WaitImageVisible = true;
//ComOpenWait(false);

//endDate = new Date();
//vTime = endDate.getTime() - startDate.getTime();
//vSec = Math.round(vTime/1000);
//resultMsg = resultMsg + "\n(DB조회) 처리시간 : " + vSec + "초입니다.";

}

var timerId;
/********************************************************
* 타이머 관리 함수
**************************************************************/
function startTimer() {
    timerId = setInterval("fncAfterFinishSetting()",200);
//fncAfterFinishSetting();
}
function stopTimer() {
    clearInterval(timerId);
    endDate = new Date();
    vTime = endDate.getTime() - startDate.getTime();
    vSec = Math.round(vTime/1000);
    resultMsg = resultMsg + "\n(DB조회 + 화면) 처리시간 : " + vSec + "초입니다.";

    //alert(resultMsg);
    gStartRow = 1;

    //sheetObjects["t2sheet1"].WaitImageVisible = true;
    ComOpenWait(false);

}


var rNum = 1;
var gStartRow = 1;
/********************************************************
* 색깔 처리 함수
**************************************************************/
function fncAfterFinishSetting(){
    var sheetObj = sheetObjects["t2sheet1"];
    with(sheetObj){
        var startRow = gStartRow;
        for(var i=startRow;i <= startRow+100;i++){

            //1.수정가능 처리
            if(CellValue(i,"t2sheet1_"+"is_validated") == "Y"){
                CellEditable(i,"t2sheet1_" + "an_fom_cd") = true;
                //CellEditable(i,"t2sheet1_" + "diff_rmk") = true;
                CellEditable(i,"t2sheet1_" + "chn_agn_cd") = true;
            //<8.7>1.왼쪽 체크박스에대한 선택은 수정 가능 Row 체크가 되도록 해주세요.나머지는 비활성화 회색 처리 ( All체크를하더라도 수정가능 필드만 체크 되도록^^)
            //CellEditable(i,"t2sheet1_" + "Chk") = true;
            //<7.31> 2.1 Code Validation에서 Clear 된 Data를 대상은 Row 색을 흰색,  Non-Clear된 Data는 회색처리
            //RowBackColor(i) = RgbColor(255,255,255);

            }else{
                CellEditable(i,"t2sheet1_" + "an_fom_cd") = false;
                //CellEditable(i,"t2sheet1_" + "diff_rmk") = false;
                CellEditable(i,"t2sheet1_" + "chn_agn_cd") = false;
                //CellEditable(i,"t2sheet1_" + "Chk") = false;
                //<7.31> 2.1 Code Validation에서 Clear 된 Data를 대상은 Row 색을 흰색,  Non-Clear된 Data는 회색처리
                RowBackColor(i) = RgbColor(255,192,192);

            }

            //bl_no가 없으면 두껍게
            if(CellValue(i,"t2sheet1_"+"bl_no") == ""){
                CellFont("FontBold",i,"t2sheet1_"+"vvd") = true;
                CellEditable(i,"t2sheet1_" + "an_fom_cd") = false;
                //CellEditable(i,"t2sheet1_" + "diff_rmk") = false;
                CellEditable(i,"t2sheet1_" + "chn_agn_cd") = false;

                //라인 수정불가
                RowEditable(i) = false;

                //Merge
                RowMerge(i) = true;

                //배경색 지정
                //for(var x=2;x < 19;x++){
                RowBackColor(i) = RgbColor(0,192,0);
            //}
            }else{//vvd별 그룹이 아니면
                CellValue(i,"t2sheet1_"+"Seq") = rNum++;
            }
            sheetObjects["t2sheet1"].RowStatus(i) = "R";

        }
        gStartRow = startRow + 100;

        window.status = gStartRow + "번까지 종료";
        if(gStartRow >= sheetObj.RowCount){
            stopTimer();
        }
        }
}

/**
 * Set Data 버튼을 클릭할경우 발생
 * @return
 */
var clickSheetObj;
var clickRow = 0;
var clickParam = "";
var clickBkg = "";
var clickBlNo = "";
function fncT2SetDataClick(){

    var goUrl = "";
    goUrl = "/hanjin/ESM_BKG_0243.do?";

    if(clickSheetObj == null){
        return;
    }

    if(clickRow < 1){
        //alert("데이터를 선택후 실행하십시오.");
        //<7.31>3.1 대상 선택 없이 팝업 버튼 클릭 시 [BKG00149] 메세지 출력 후 작업 중지
        ComShowCodeMessage("BKG00149");
        return;
    }


    var sRowStr = clickSheetObj.GetSelectionRows("/");
    var arr = sRowStr.split("/");
    var paramVVD = "";
    var tmpVVD = "";

    //한개이고 bl 이 없는 그룹핑 한 애들.
    if(arr.length == 1
        && clickSheetObj.CellValue(arr[0],"t2sheet1_"+"bl_no") == ""){

        return;
    }

    //alert("선택한 개수 " + arr.length);
    for(var x=0;x<arr.length;x++){

        if(clickSheetObj.CellValue(arr[x],"t2sheet1_"+"vvd") != tmpVVD ){
            //alert("동일 VVD를 선택하세요");
            //	return;
            paramVVD += clickSheetObj.CellValue(arr[x],"t2sheet1_"+"vvd") + "/";
            tmpVVD = clickSheetObj.CellValue(arr[x],"t2sheet1_"+"vvd");
        }

        if(clickSheetObj.CellValue(arr[x],"t2sheet1_"+"bl_no") == ""){//그룹핑한 애.
            continue;
        }else if(clickSheetObj.CellValue(arr[x],"t2sheet1_"+"is_validated") != "Y"){
            //alert("Code Validation 된 데이터가 없습니다.");
            //<8.26>Code Validation 된 데이터가 없습니다
            ComShowCodeMessage("BKG04003");
            return;
        }

    }
    //alert(paramVVD);

    form.vvd0243list.value = paramVVD;

    ComOpenWindowCenter(goUrl+encodeURI(clickParam),"ESM_BKG_0243",720,490,true);


}
/**
* OnClick 보다 앞서실행되는 Mouse click이다.
* 헤더 클릭을 제어하기 위함.
*/
function t2sheet1_OnMouseDown(sheetObj, button, shift, x, y){
    if(sheetObj.MouseRow == 0 && sheetObj.MouseCol == 2){
        sheetObj.SelectRow = 1;
        sheetObj.SelectRow = 2;
        sheetObj.SelectRow = 3;
        sheetObj.SelectRow = 4;
    }
}

function t2sheet1_OnClick(sheetObj, Row, Col, Value){
    //-클릭한 곳의 데이터를 팝업으로 넘긴다.
    //-넘길데이터의 목록
    //1.Arrival Vessel
    //2.VVD   (vvd)
    //3.ETA POD(pod_arr_dt)
    //4.ETA DEL(del_arr_dt)
    //5.Available Date(pkup_aval_dt)
    //6.Last Free Date to Pickup(pkup_free_dt)
    //7.Full CNTR P/UP CY(yd_cstms_no)
    //8.Empty Return CY(rtn_yd_cd)
    //9.A/N Form Type
    //10.chn_agn_cd
    //11.Revise 여부
	//12.diff_rmk 2011.08.04

    var colName = sheetObj.ColSaveName(Col);




    clickRow = Row;
    clickSheetObj = sheetObj;
    //var arrColNames = new Array("vsl_nm","vvd","pod_arr_dt","del_arr_dt","pkup_aval_dt","pkup_free_dt","pkup_yd_cd","rtn_yd_cd","an_fom_cd","chn_agn_cd","ntc_rvis_flg","bkg_no","vsl_cd","skd_voy_no","skd_dir_cd","pod_cd");
    //var arrColNames = new Array("vsl_nm","vvd","pod_arr_dt","del_arr_dt","pkup_aval_dt","pkup_free_dt","pkup_yd_cd","rtn_yd_cd","an_fom_cd","chn_agn_cd","diff_rmk","ntc_rvis_flg","bkg_no","vsl_cd","skd_voy_no","skd_dir_cd","pod_cd"); //2011.08.04 diff_rmk 추가
    var arrColNames = new Array("vsl_nm","vvd","vsl_flg","pod_arr_dt","del_arr_dt","pkup_aval_dt","pkup_free_dt","pkup_yd_cd","rtn_yd_cd","an_fom_cd","chn_agn_cd","diff_rmk","ntc_rvis_flg","bkg_no","vsl_cd","skd_voy_no","skd_dir_cd","pod_cd","vsl_flg_cnt_nm");   //2016.05.17 vsl_flg, vsl_flg_cnt_nm 추가

    clickParam = "1=1";
    clickParam = "&row="+Row;

    //alert(sheetObj.CellText(Row,"t2sheet1_" + "chn_agn_cd"));

    for(var i=0;i<arrColNames.length;i++){
        //팝업에서 날짜형식을 포맷팅된 상태로 받기 위함.
        if(arrColNames[i] != "an_fom_cd"){
        	if(arrColNames[i] == "diff_rmk"){ //2011.08.04 Remark 값 encode
        		clickParam += "&" + arrColNames[i] + "="+encodeURIComponent(sheetObj.CellText(Row,"t2sheet1_" + arrColNames[i]));
        	}else{
        		clickParam += "&" + arrColNames[i] + "="+sheetObj.CellText(Row,"t2sheet1_" + arrColNames[i]);
        	}
            //clickParam += "&" + arrColNames[i] + "="+sheetObj.CellText(Row,"t2sheet1_" + arrColNames[i]);
        }else{
            clickParam += "&" + arrColNames[i] + "="+sheetObj.CellValue(Row,"t2sheet1_" + arrColNames[i]);
        }
    }

    //alert(clickParam);

    clickBkg = sheetObj.CellText(Row,"t2sheet1_" + "bkg_no");
    clickBlNo = sheetObj.CellText(Row,sheetObj.id + "_" + "bl_no");

//if(colName != "Chk"){
//	sheetObj.CellValue(Row,sheetObj.id + "_" + "Chk") = 1;
//}

}
/**
* 더블클릭 이벤트 발생시
**/
function t2sheet1_OnDblClick(sheetObj, Row, Col, Value){
    var colName = sheetObj.ColSaveName(Col);


    if( sheetObj.CellValue(Row,"t2sheet1_"+"is_validated") == "Y"
        && colName == "t2sheet1_" + "diff_rmk"){
        //sheetObj.CellEditable(Row, colName) = false;
        ComShowMemoPad(sheetObj, Row, colName, false, 200, 100, 200 );
    //sheetObj.CellEditable(Row, colName) = true;
    }else{
        fncT2SetDataClick();
    }
}

/**
 * Customer Info Popup
 * @return
 */

function fncT2CustomerInfoClick(){
    var goUrl = "";
    var param = "";
    if(clickSheetObj == null){
        return;
    }
    var sRowStr = clickSheetObj.GetSelectionRows("/");
    var arr = sRowStr.split("/");

    if(arr.length > 1){
        //alert("다중 선택을 할수 없습니다.");
        ComShowCodeMessage("BKG04007");
        return;
    }


    goUrl = "/hanjin/ESM_BKG_0242.do?";
    if(clickBkg == ""){
        //alert("데이터를 선택후 실행하십시오");
        //<7.31>3.1 대상 선택 없이 팝업 버튼 클릭 시 [BKG00149] 메세지 출력 후 작업 중지
        ComShowCodeMessage("BKG00149");
        return;
    }
    param += "1=1";
    //param += "&cust_cnt_cd="+encodeURI(custCntCd3)+"&cust_seq="+encodeURI(custSeq3);
    param += "&bkg_no="+encodeURI(clickBkg);
    param += "&tab_idx=0";
    param += "&pgmNo=ESM_BKG_0242";


    ComOpenWindowCenter(goUrl + param,"ESM_BKG_0242",570,380,true);

}


function fncANSendClick(){
    var goUrl = "";
    var param = "";
    goUrl = "/hanjin/ESM_BKG_0381.do?";

    //alert("clickRow  " + clickRow);
    //alert(clickSheetObj.id+"_is_validated");

    //alert(          clickSheetObj.CellValue(              clickRow,clickSheetObj.id+"_is_validated"             )   );
    //if(clickBlNo == "" || clickSheetObj.CellValue(clickRow,clickSheetObj.id+"_is_validated") != "Y"){
    //<7.31>Code Validation을 수행하지 않은대상을 선택 후 A/N Send 버튼 클릭 시 [BKG04003] 경고 메세지 후 작업 중지
    //	ComShowCodeMessage("BKG04003");
    //	return;
    //}


    param += "1=1";
    //param += "&" + "bl_no="+clickBlNo;
	//2010-03-23 ; 이후 뜨는창의 스크립트 오류로 인해 값을 초기화함. by sungho
	document.form.f_cmd.value = "";
    param += "&" + FormQueryString(document.form);
	//param += "&" + "f_cmd=102&pagerows=100&vvd0243list=&sch_tp=V&vvd=HNBL0048E&vps_eta_dt_start=2010-03-23&vps_eta_dt_end=2010-03-29&pod_cd=USLGB&del_cd=&pol_cd=&bl_no=&is_validated=&cust_cnt_cd=&cust_seq=&cust_nm=&cust_ref_no=&s_no=&c_no=&an_seq=&strUsr_nm=NAME%20OF%20TES_MTRBS&strUsr_email=noreply%40cyberlogitec.com&strOfc_cd=MTRBS&gw_subject=Customer%20Code%20Request&gw_contents=&gw_template=template.htmlmail&gw_args=name%3B&gw_args=";

    param += "&pgmNo=ESM_BKG_0381";
    param += "&autoSearchFlg=Y";

    //선택되지 않을경우는 No Action
    //location.href=goUrl + param;
    ComOpenWindowCenter(goUrl + encodeURI(param), "ESM_BKG_0381", 1024, 640, true);
}
/**
 * 저장완료시 호출
 * @param sheetObj
 * @param errMsg
 * @return
 */
function t2sheet1_OnSaveEnd(sheetObj, errMsg){
    if (errMsg == "") {
        ComBkgSaveCompleted();
		ComOpenWait(false);
    //doActionIBSheet(sheetObj,document.form,IBSEARCH);
    }
}



/**
 * seq 에서 포커스를 떠날시
 * 숫자를 자동으로 앞에 0을 넣어 6자리로 만들기
 * @param obj
 * @return
 */
function fncCustSeqBlur(obj){
    var orgV = obj.value;

    if(orgV.length < 1){
        obj.value = "";
    }else{
        obj.value = fncSeqTo6(orgV);
    }


}
/**
 * 숫자를 자동으로 앞에 0을 넣어 6자리로 만들기
 * @param str
 * @return
 */
function fncSeqTo6(str){

    var currentObjLen = str.length;

    if(currentObjLen < 1) return;

    var retStr = "";
    for(var i=0;i<6-currentObjLen;i++){
        retStr += "0";
    }

    return retStr + str;
}

/**
* 243에서 온 값들을 설정하는 함수.
**/
function fncSetupFrom243(doc,selectVVD){
    //var arrColNames = new Array("pod_arr_dt","del_arr_dt","pkup_aval_dt","pkup_free_dt","pkup_yd_cd","rtn_yd_cd","chn_agn_cd","ntc_rvis_flg","an_fom_cd","vsl_nm");
    //var arrColNames = new Array("pod_arr_dt","del_arr_dt","pkup_aval_dt","pkup_free_dt","pkup_yd_cd","rtn_yd_cd","chn_agn_cd","diff_rmk","ntc_rvis_flg","an_fom_cd","vsl_nm"); //2011.08.04 diff_rmk 추가
    var arrColNames = new Array("vsl_flg","pod_arr_dt","del_arr_dt","pkup_aval_dt","pkup_free_dt","pkup_yd_cd","rtn_yd_cd","chn_agn_cd","diff_rmk","ntc_rvis_flg","an_fom_cd","vsl_nm"); //2016.05.17 vsl_flg 추가
    //alert("sheet name : " + opener.sheetObjects[0].id);
    //alert('formObj.row.value ' + formObj.row.value);
    //alert('formObj.pod_arr_dt.value ' + formObj.pod_arr_dt.value);
    //sheetObjects["t2sheet1"].WaitImageVisible = true;

    //alert(doc.getElementById("vsl_nm").value);
    var sheetObj = sheetObjects["t2sheet1"];

    var sRowStr = sheetObj.GetSelectionRows("/");
    var arr = sRowStr.split("/");

    if(typeof(sheetObj) != "undefined"){

        for(var x=0;x<arr.length;x++){
            //alert(selectVVD + " " + opener.sheetObjects[0].CellValue(x,"t2sheet1_" + "vvd") );
            if(selectVVD != sheetObj.CellValue(arr[x],"t2sheet1_" + "vvd")
                || sheetObj.CellValue(arr[x],"t2sheet1_" + "bl_no") == ""){
                continue;
            }
            sheetObj.RowStatus(arr[x]) = "U";
            for(var i=0;i<arrColNames.length;i++){
                var valObj = doc.getElementById(arrColNames[i]);


                //그룹핑 데이터일 경우 실행하지 않음.
                if(sheetObj.CellValue(arr[x],"t2sheet1_" + "bl_no") == ""){
                    continue;
                }
                //ntc_rvis_flg는 특별히 checkbox 에서 값을 읽어서 설정해야되므로 다음과 같이 처리.
                var sheetVal = sheetObj.CellValue(arr[x],"t2sheet1_" + arrColNames[i]);

                if(arrColNames[i] == "vsl_flg"){
	                if(valObj.checked){
	                    sheetObj.CellValue(arr[x],"t2sheet1_" + arrColNames[i]) = "Y";
	                }else{
	                    sheetObj.CellValue(arr[x],"t2sheet1_" + arrColNames[i]) = "N";
	                }
	            }else if(arrColNames[i] == "ntc_rvis_flg"){
                    if(valObj.checked){
                        sheetObj.CellValue(arr[x],"t2sheet1_" + arrColNames[i]) = "Y";
                    }else{
                        sheetObj.CellValue(arr[x],"t2sheet1_" + arrColNames[i]) = "N";
                    }
                }else{
                    if(sheetVal != valObj.value){
                        sheetObj.CellValue(arr[x],"t2sheet1_" + arrColNames[i]) = valObj.value;
                    }
                }

            }

        //opener.sheetObjects[0].CellValue(arr[x],"t2sheet1_" + "Chk") = true;
        }

    }else{
        alert("부모창이 없습니다");
    }

//sheetObjects["t2sheet1"].WaitImageVisible = false;

}



//0672_02.js 끝
/*-------------------------------------------------------------------------------------------*/




/*-------------------------------------------------------------------------------------------*/
//0672_03.js 시작

/* Customer */

/**
      *
      * @param sheetObj
      * @param Row
      * @param Col
      * @return
      */
function t3sheet1_OnChange(sheetObj, Row, Col, Value) {

    var colName = sheetObj.ColSaveName(Col);


    //sheetObj.CellValue2(Row,sheetObj.SaveNameCol(sheetObj.id + "_" + "Chk")) = 1;

    if(colName == "t3sheet1_" + "fax1"
        || colName == "t3sheet1_" + "fax2"
        || colName == "t3sheet1_" + "fax3"
        || colName == "t3sheet1_" + "fax4"
        || colName == "t3sheet1_" + "fax5"
        ){


    }

    //<7.29>3.2 Email : Focus Out시 Email 포맷에 대한 Valdation 체크 ( 값이 있을 경우만)
    if(colName == "t3sheet1_" + "eml1"
        || colName == "t3sheet1_" + "eml2"
        || colName == "t3sheet1_" + "eml3"
        || colName == "t3sheet1_" + "eml4"
        || colName == "t3sheet1_" + "eml5"
        ){
        if(sheetObj.CellValue(Row,Col) != ""
            && !ComIsEmailAddr(sheetObj.CellValue(Row,Col))){
            ComShowCodeMessage("BKG00366");
            sheetObj.SelectCell(Row, Col);
            return;
        }

    }

}


//수직스크롤바가 바닥에 닿았을 때 발생하는 이벤트 Catch
function t3sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
    //    alert('scroll next');
    doActionIBSheet(sheetObj, document.form, IBSEARCH, CondParam, PageNo);
//alert("PageNo " + PageNo);
}

function t3sheet1_OnScroll(sheetObj,OlTopRow, OldLeftCol, NewTopRow, NewLeftCo) {
//alert('scroll');
}

//Tab2 가 Retrieve시
function t3sheet1_retrieve(){
    var formObj = document.form;

    //1. 필수 조회 조건 입력 여부 검사    VVD or Duration로 조회 됨.
    //1. [필수 조회 조건 미입력]  :[공통 메세지] 표시하고 해당 항목으로 Focus On.
    if(formObj.sch_tp[0].checked){
        if(formObj.vvd.value == ""){
            ComShowCodeMessage("BKG00404");
            formObj.vvd.focus();
        }

    }
    if(formObj.sch_tp[1].checked){
        if(formObj.vps_eta_dt_start.value == "" || formObj.vps_eta_dt_end.value == ""){
            ComShowCodeMessage("BKG00404");
            formObj.vps_eta_dt_start.focus();
        }

    }
    //2. 날짜 포맷입력 확인 필요.
    //2. [날짜입력 포맷 검사] :[공통 메세지] 표시하고 해당 항목으로 Focus On.

    //3. 입력 날짜 기간 검사 ( To 가 From보다 적을 경우 )
    //3.[입력 날짜 기간  검사] : [BKG00156] 표시하고 해당 항목으로 Focus On."
    var sDate = convMMM2MM(formObj.vps_eta_dt_start.value);
    var eDate = convMMM2MM(formObj.vps_eta_dt_end.value);
    var check3 = ComChkPeriod(sDate,eDate);
    if(!(check3 == 1 || check3 == 2)){
        ComShowCodeMessage("BKG00156");
        formObj.vps_eta_dt_end.focus();
    }
    //
    //<EXCEPTION>




    var formObj = document.form;
    //1. 초기 상태로 설정하고 VVD 항목으로 Focus On
    formObj.vvd.focus();
    //2. Duration : Default 값은 FM는 조회일자, TO은 조회일자에서 2주 이후 일자를 Setting 해줌.
    formObj.vps_eta_dt_start.value = convMM2MMM(ComGetNowInfo());
    formObj.vps_eta_dt_end.value = convMM2MMM(ComGetDateAdd(ComGetNowInfo(),'D',14));
//3. POD: 이전 조회된 POD Code가 있을 경우 보여 짐. ( Cookie 활용 )"

}

/**
 * t3sheet1 의 데이터 조회완료시
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function t3sheet1_OnSearchEnd(sheetObj, ErrMsg){
    //1.결과 값이 없을경우 save 버튼 disable
    //is_validated 의 값에 따라 처리
    //alert("search t3sheet1 end");
    with(sheetObj)
    {
        RowHeight(0) = 10;
        RowHeight(1) = 10;

        if(rowcount < 1){
            ComBtnDisable("btn_Save");
        }else{
            ComBtnEnable("btn_Save");
        }


        ComOpenWait(false);

        return;
        //HKGA33268605

        for(var i=2;i <= RowCount+1;i++){
            if(CellValue(i,"t3sheet1_"+"ib_cmdt_flg") == "1"){
                RangeFontBold(i,0, i,30) = true;
            }
            if(CellValue(i,"t3sheet1_"+"is_validated") == "Y"){

                //CellEditable(i,"t3sheet1_" + "cust_fax_no") = true;
                CellEditable(i,"t3sheet1_" + "fax1") = true;
                CellEditable(i,"t3sheet1_" + "fax2") = true;
                CellEditable(i,"t3sheet1_" + "fax3") = true;
                CellEditable(i,"t3sheet1_" + "fax4") = true;
                CellEditable(i,"t3sheet1_" + "fax5") = true;

                //CellEditable(i,"t3sheet1_" + "ntc_eml") = true;
                CellEditable(i,"t3sheet1_" + "eml1") = true;
                CellEditable(i,"t3sheet1_" + "eml2") = true;
                CellEditable(i,"t3sheet1_" + "eml3") = true;
                CellEditable(i,"t3sheet1_" + "eml4") = true;
                CellEditable(i,"t3sheet1_" + "eml5") = true;


            }else{
                //CellEditable(i,"t3sheet1_" + "cust_fax_no") = false;
                CellEditable(i,"t3sheet1_" + "fax1") = false;
                CellEditable(i,"t3sheet1_" + "fax2") = false;
                CellEditable(i,"t3sheet1_" + "fax3") = false;
                CellEditable(i,"t3sheet1_" + "fax4") = false;
                CellEditable(i,"t3sheet1_" + "fax5") = false;

                //CellEditable(i,"t3sheet1_" + "ntc_eml") = false;
                CellEditable(i,"t3sheet1_" + "eml1") = false;
                CellEditable(i,"t3sheet1_" + "eml2") = false;
                CellEditable(i,"t3sheet1_" + "eml3") = false;
                CellEditable(i,"t3sheet1_" + "eml4") = false;
                CellEditable(i,"t3sheet1_" + "eml5") = false;

                RowBackColor(i) = RgbColor(255,192,192);

            }
        }
        //CheckAll2("t2sheet1_Chk")  = true;

        }


}



/**
 * Set Data 버튼을 클릭할경우 발생
 * @return
 */

var clickParam3 = "";




function t3sheet1_OnClick(sheetObj, Row, Col, Value){
    //-클릭한 곳의 데이터를 팝업으로 넘긴다.
    //-넘길데이터의 목록
    //1.Arrival Vessel
    //2.VVD   (vvd)
    //3.ETA POD(pod_arr_dt)
    //4.ETA DEL(del_eta_dt)
    //5.Available Date(pkup_aval_dt)
    //6.Last Free Date to Pickup(pkup_free_dt)
    //7.Full CNTR P/UP CY(yd_cstms_no)
    //8.Empty Return CY(rtn_yd_cd)
    //9.A/N Form Type
    //10.Agent
    //11.Revise 여부
    var colName = sheetObj.ColSaveName(Col);


    clickRow = Row;
    clickSheetObj = sheetObj;


    clickParam3 = "1=1";
    vvdByCustomerInfo3 = sheetObj.CellText(Row,"t3sheet1_" + "vvd");
    custCntCd3 =  sheetObj.CellText(Row,"t3sheet1_" + "cust_cnt_cd");
    custSeq3 =  sheetObj.CellText(Row,"t3sheet1_" + "cust_seq");
    custNm3 =  sheetObj.CellText(Row,"t3sheet1_" + "cust_nm");
    clickBkg = sheetObj.CellText(Row,"t3sheet1_" + "bkg_no");
    clickBlNo = sheetObj.CellText(Row,"t3sheet1_" + "bl_no");
//<7.29>2.3 Consignee Name(B/L) : 25자리까지 잘라서 보여주되 해당 항목을 클릭하면 메모장으로 Full Name이 보이게 해주세요 ( 공통 기능 사용 )
//<7.29>2.4 Consignee Address(B/L) : 30자리까지 잘라서 보여주되 해당 항목을 클릭하면 메모장으로 Full Name이 보이게 해주세요 ( 공통 기능 사용 )

}


function t3sheet1_OnDblClick(sheetObj, Row, Col, Value){
    var colName = sheetObj.ColSaveName(Col);
    //alert(sheetObj.RowHeight(Row));

    //if(colName == "t3sheet1_" + "cust_nm" || colName == "t3sheet1_" + "cust_addr"){
    //	ComShowMemoPad(sheetObj, Row, colName, true, 200, 100, 200 );
    //}
    if((colName == "t3sheet1_" + "cust_nm" || colName == "t3sheet1_" + "cust_addr")){
        if(sheetObj.RowHeight(Row) == 20){
            sheetObj.RowHeight(Row) = 0;
            sheetObj.ColWidth(Col) = 0;

        }else{
            sheetObj.RowHeight(Row) = 20;
            sheetObj.ColWidth(Col)  = 180;

        }
    }

    if(colName == "t3sheet1_" + "bl_no"
        || colName == "t3sheet1_" + "bkg_cust_tp_cd"
        || colName == "t3sheet1_" + "sc_no"
        || colName == "t3sheet1_" + "del_cd"
        || colName == "t3sheet1_" + "evaluation_yn"
        || colName == "t3sheet1_" + "vsl_info_set_flg"
        || colName == "t3sheet1_" + "cust_cd"
        ){
        fncT3CustomerInfoClick();
    }
}


/**
 * Customer Info Popup
 * @return
 */
var vvdByCustomerInfo3 = "";
var custCntCd3 = "";
var custSeq3 = "";
var custNm3 = "";
function fncT3CustomerInfoClick(){
    fncT2CustomerInfoClick();
}
/**
 * Master Data Popup ; 240번으로 cust_cnt_cd , cust_seq 를 가지고 이동
 * @return
 */
function fncT3MasterDataClick(){
    var goUrl = "";
    var param = "";
    goUrl = "/hanjin/ESM_BKG_0240.do?";

    if(custCntCd3 == "" || custSeq3 == ""){
        //alert("데이터를 선택후 실행하십시오");
        ComShowCodeMessage("BKG04007");
        return;
    }

    var sRowStr = clickSheetObj.GetSelectionRows("/");
    var arr = sRowStr.split("/");

    if(arr.length > 1){
        //alert("다중 선택을 할수 없습니다.");
        ComShowCodeMessage("BKG04007");
        return;
    }


    param += "1=1";
    param += "&cust_cnt_cd="+encodeURI(custCntCd3)+"&cust_seq="+encodeURI(custSeq3);
    param += "&pgmNo=ESM_BKG_0240";

    //선택되지 않을경우는 No Action
    if(custCntCd3 == "" || custSeq3 == ""){
        return;
    }else{
        //location.href=goUrl + param;
        ComOpenWindowCenter(goUrl + param,"ESM_BKG_0240",1024,670,true);
    }


}

function fncT3MultiContact(){
    var goUrl = "";
    var param = "";
    goUrl = "/hanjin/ESM_BKG_1044.do?";

    if(clickSheetObj == null){
        ComShowCodeMessage("BKG04007");
        return;
    }

    var sRowStr = clickSheetObj.GetSelectionRows("/");
    var arr = sRowStr.split("/");

    if(arr.length > 1){
        //alert("다중 선택을 할수 없습니다.");
        ComShowCodeMessage("BKG04007");
        return;
    }

    if(custCntCd3 == "" || custSeq3 == ""){
        ComShowCodeMessage("BKG04007");
        return;
    }


    param += "1=1";
    param += "&cust_cnt_cd="+encodeURI(custCntCd3)
    +"&cust_seq="+encodeURI(custSeq3)
    +"&cust_nm="+encodeURIComponent(custNm3)
    ;
    param += "&pgmNo=ESM_BKG_1044";

    //선택되지 않을경우는 No Action

    //location.href=goUrl + param;
    ComOpenWindowCenter(goUrl + param,"ESM_BKG_1044",800,360,true);


}

function t3sheet1_OnSaveEnd(sheetObj, errMsg){
    if (errMsg == "") {
        ComBkgSaveCompleted();
		ComOpenWait(false);
    //doActionIBSheet(sheetObj,document.form,IBSEARCH);
    }
}




//0672_03.js 끝
/*-------------------------------------------------------------------------------------------*/





/*-------------------------------------------------------------------------------------------*/
//0672_04.js 시작

/* Upload_Match */

/**
      *
      * @param sheetObj
      * @param Row
      * @param Col
      * @return
      */
function t4sheet1_OnChange(sheetObj, Row, Col) {
    var prefix = "t4sheet1_";
    var colName = sheetObj.ColSaveName(Col);

    if(colName == prefix + "fax_no1"
        || colName == prefix + "fax_no2"
        || colName == prefix + "fax_no3"
        ){


    }

    //<8.25>3.2 Email : Focus Out시 Email 포맷에 대한 Valdation 체크 ( 값이 있을 경우만)
    if(colName == prefix + "ntc_eml1"
        || colName == prefix + "ntc_eml2"
        || colName == prefix + "ntc_eml3"

        ){
        if(sheetObj.CellValue(Row,Col) != ""
            && !ComIsEmailAddr(sheetObj.CellValue(Row,Col))){
            ComShowCodeMessage("BKG40021");
            sheetObj.SelectCell(Row, Col);
            return;
        }

    }



}


//수직스크롤바가 바닥에 닿았을 때 발생하는 이벤트 Catch
function t4sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
    //    alert('scroll next');
    doActionIBSheet(sheetObj, document.form, IBSEARCH, CondParam, PageNo);
//alert("PageNo " + PageNo);
}

function t4sheet1_OnScroll(sheetObj,OlTopRow, OldLeftCol, NewTopRow, NewLeftCo) {
//alert('scroll');
}


/**
 * t4sheet1 의 데이터 조회완료시
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function t4sheet1_OnSearchEnd(sheetObj, ErrMsg){
    //1.결과 값이 없을경우 save 버튼 disable
    //is_validated 의 값에 따라 처리

    //alert("search t4sheet1 end");
    with(sheetObj)
    {

        if(rowcount < 1){
            ComBtnDisable("btn_Save");
        }else{
            ComBtnEnable("btn_Save");
        }


        //CheckAll2("t2sheet1_Chk")  = true;
        //t4sheet2 그리드로 데이터 복사
        var xmlStr = IBS_GetDataSearchXml(sheetObj);//sheet를 xml 로 변환
        sheetObjects["t4sheet2"].LoadSearchXml(xmlStr,false);//xml 데이터를 로딩

        }

    ComOpenWait(false);
}
/**
 * 저장완료후
 * @param sheetObj
 * @param errMsg
 * @return
 */
function t4sheet1_OnSaveEnd(sheetObj, errMsg)
{
    var formObj = document.form;
	ComOpenWait(false);

//if (errMsg != null && errMsg != "") {
//	 ComShowMessage(errMsg);
//}

}

/**
 * 엑셀업로드후
 * @param sheetObj
 * @return
 */
function t4sheet1_OnLoadExcel(sheetObj){
    //alert("엑셀업로드 후 이벤트");
    var sheetOrg;
    var sheetNew;
    var cnt = 0;
    var lineNumber = 0;
    var colName = 0;

    sheetOrg = sheetObj;
    //sheetNew = sheetObjects[3];
    sheetNew = sheetObjects["t4sheet2"];
    sheetOrg.DataAutoTrim = true;
    sheetNew.DataAutoTrim = true;

    //alert(sheetOrg.id);
    //alert(sheetNew.id);
    ComBtnDisable("btn_Save");

	//2010-03-30 by sungho
	//엑셀업로드시 알수없는 데이터가 들어감을 처리
	for(var i=1;i <= sheetOrg.RowCount+1;i++){
		if(sheetOrg.CellValue(i,"t4sheet1_"+"bl_no") == ""){
			sheetOrg.RowDelete(i,false);
		}
	}



    if(sheetOrg.RowCount != sheetNew.RowCount){
        //ComShowMessage("Excel Data의 Row수가 다릅니다.\n다시조회후 사용하십시오.");
		ComShowCodeMessage("BKG43041");
        return;
    }

    //alert(sheetOrg.RowCount);

    for(var i=2;i <= sheetOrg.RowCount+1;i++){
        //1.데이터를 비교하여 키값이 다를경우 오류 리턴
        //2.key ; bl_no,cust_nm
        //3.bkg_no,bkg_cust_tp_cd 값을 세팅 ; 엑셀업로드시 없으므로

        sheetOrg.CellValue(i,"t4sheet1_"+"bkg_no") = sheetNew.CellValue(i,"t4sheet2_"+"bkg_no");
        sheetOrg.CellValue(i,"t4sheet1_"+"bkg_cust_tp_cd") = sheetNew.CellValue(i,"t4sheet2_"+"bkg_cust_tp_cd");
        sheetOrg.CellValue(i,"t4sheet1_"+"is_validated") = sheetNew.CellValue(i,"t4sheet2_"+"is_validated");


    }

    for(var i=2;i <= sheetOrg.RowCount+1;i++){
        //1.데이터를 비교하여 키값이 다를경우 오류 리턴
        //2.key ; bl_no,cust_nm
        //3.bkg_no,bkg_cust_tp_cd 값을 세팅 ; 엑셀업로드시 없으므로


        if(sheetOrg.CellValue(i,"t4sheet1_" + "ntc_eml1") != ""
            && !ComIsEmailAddr(sheetOrg.CellValue(i,"t4sheet1_" + "ntc_eml1"))){
            ComShowCodeMessage("BKG40021");
            sheetOrg.SelectCell(i, "t4sheet1_"+"ntc_eml1");
            cnt++;
            break;
        }
        if(sheetOrg.CellValue(i,"t4sheet1_" + "ntc_eml2") != ""
            && !ComIsEmailAddr(sheetOrg.CellValue(i,"t4sheet1_" + "ntc_eml2"))){
            ComShowCodeMessage("BKG40021");
            sheetOrg.SelectCell(i, "t4sheet1_"+"ntc_eml2");
            cnt++;
            break;
        }
        if(sheetOrg.CellValue(i,"t4sheet1_" + "ntc_eml3") != ""
            && !ComIsEmailAddr(sheetOrg.CellValue(i,"t4sheet1_" + "ntc_eml3"))){
            ComShowCodeMessage("BKG40021");
            sheetOrg.SelectCell(i, "t4sheet1_"+"ntc_eml3");
            cnt++;
            break;
        }
        //ComKeyOnlyNumber(this, "-")


        if(fncDiff( sheetOrg.CellValue(i,"t4sheet1_"+"bl_no"),sheetNew.CellValue(i,"t4sheet2_"+"bl_no") )){
            ComShowCodeMessage("BKG40022");
            //alert("bl_no , row : " + i);
            cnt++;
            break;
        }
        if(fncDiff( sheetOrg.CellValue(i,"t4sheet1_"+"cust_nm"),sheetNew.CellValue(i,"t4sheet2_"+"cust_nm") )){
            ComShowCodeMessage("BKG40022");
            //alert("cust_nm , row : " + i);
            cnt++;
            break;
        //break;
        }


    }

    if(cnt < 1){
        ComBtnEnable("btn_Save");
    }
}
/**
 * 두개의 문자열 비교
 * 동일 ; 리턴 true
 * @param orgStr
 * @param newStr
 * @return
 */
function fncDiff(orgStr,newStr){
    orgStr = orgStr.replace(eval("/\\r\\n/gi"), " ").trim();
    newStr = newStr.replace(eval("/\\r\\n/gi"), " ").trim();

    //alert("["+orgStr+"]" +"["+newStr+"]");


    if(orgStr != newStr){
        return true;
    }else{
        return false;
    }
}
/**
* 두번 클릭시 펼쳐지도록
**/
function t4sheet1_OnDblClick(sheetObj, Row, Col, Value){
    var colName = sheetObj.ColSaveName(Col);
    var prefix = "t4sheet1_";
    //alert(sheetObj.RowHeight(Row));

    //if(colName == "t3sheet1_" + "cust_nm" || colName == "t3sheet1_" + "cust_addr"){
    //	ComShowMemoPad(sheetObj, Row, colName, true, 200, 100, 200 );
    //}
    if((colName == prefix + "cust_nm")){
        if(sheetObj.RowHeight(Row) == 20){
            sheetObj.RowHeight(Row) = 0;
            sheetObj.ColWidth(Col) = 0;

        }else{
            sheetObj.RowHeight(Row) = 20;
            sheetObj.ColWidth(Col)  = 200;

        }
    }
}






//0672_04.js 끝
/*-------------------------------------------------------------------------------------------*/

/**
 * BackEndJob : retrieve<br>
 *
 * @param sheetObj
 * @param sKey
 */
function doActionValidationResult(t3sheet1, sKey) {
var sXml = t3sheet1.GetSearchXml("ESM_BKG_0672GS.do?f_cmd=" + SEARCH07 + "&key=" + sKey);
var sJbStsFlg = ComGetEtcData(sXml, "jb_sts_flg");

// ending waiting status in case of erro
if (!ComBkgErrMessage(t3sheet1, sXml)) {
clearInterval(intervalId);
ComOpenWait(false);
return;
}
if (sJbStsFlg == "SUCCESS") {
clearInterval(intervalId);
ComOpenWait(false);
ComShowCodeMessage('BKG00102');
doActionIBSheet(t3sheet1,document.form,IBSEARCH,"","");
return;
} else if (sJbStsFlg == "FAIL") {
clearInterval(intervalId);
ComOpenWait(false);
ComShowMessage(ComResultMessage(sXml));
}
}



    /* 개발자 작업  끝 */