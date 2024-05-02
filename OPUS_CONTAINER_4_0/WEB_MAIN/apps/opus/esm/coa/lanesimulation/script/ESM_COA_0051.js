/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0051.js
*@FileTitle  : LaneSimulation Step1 >> Vessel Register (Service Lane & Deployed Vessels Setting)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/02
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// 공통전역변수
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var loadingMode=false;
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
     */
    function processButtonClick(){
        var sheetObject=sheetObjects[0];
        var sheetObject1=sheetObjects[1];
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
                case "btn_filemgmt":
                    doActionIBSheet(sheetObject,formObject,IBSEARCHAPPEND);
                    break;
                case "btn_lane":
                    doActionIBSheet(sheetObject,formObject,IBBATCH);
                    break;
                case "btn_retrieve":
                    doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    break;
                case "btn_new":
                    sheetObject.RemoveAll();
                    sheetObject1.RemoveAll();
                    formObject.reset();
                    ComSetObjValue(formObject.f_slan_cd,"");
                    ComSetObjValue(formObject.f_sim,"");
                    ComSetObjValue(formObject.f_dept_cd2,"");
                    if (formObject.f_ext_flg[1].checked)  formObject.f_ext_flg[0].checked=true;
                    // VSL & BSA I/F 버튼 비활성화
                    td_bsa.style.display="none";
                    formObject.f_dept_cd.value=formObject.f_dept_cd_1.value;
                    formObject.f_sim_dt.value=ComGetNowInfo("");
                    formObject.f_usr_id.value=formObject.usr_id.value;
                    viewBtn();
                    doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
                    document.form.f_slan_cd.focus();
                    break;
                case "btn_downexcel":
                    doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
                    break;
                case "btn_save":
                    doActionIBSheet(sheetObject,formObject,IBSAVE);
                    break;
                case "btn_rowadd1":
                    doActionIBSheet(sheetObject,formObject,IBINSERT);
                    break;
                case "btn_secdel":
                    doActionIBSheet(sheetObject,formObject,IBDELETE);
                    break;
                case "btn_rowadd2":
                    doActionIBSheet2(sheetObject1,formObject,IBINSERT);
                    break;
                case "btn_save2":
                    doActionIBSheet2(sheetObject1,formObject,IBSAVE);
                    break;
                case "radCode":
                    for(k=0; k<2; k++){
                        if(formObject.radCode[k].checked == true){
                            calculate(sheetObject1, formObject.radCode[k].value);
                        }
                    }
                    break;
                case "bu_zoom_in1": //next
                    if(sheetObject1.LastRow()>9){
                        //no support[check again]CLT sheetObject1.style.height=sheetObject1.GetSheetHeight(sheetObject1.LastRow()+3);
                        parent.syncHeight();
                        set_Zoom("open");
                    }
                    break;
                case "bu_zoom_out1": //next
                    //no support[check again]CLT sheetObject1.style.height=sheetObject1.GetSheetHeight(9);
                    parent.syncHeight();
                    set_Zoom("close");
                    break;
                default:
                    doActionPageMove(sheetObject, formObject, srcName);
            } // end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        }
    }
    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * IBCombo Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++]=combo_obj;
    }
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
         loadingMode=true;
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);  //khlee-시작 환경 설정 함수 이름 변경
            //sheetObjects[i].UseWindowTheme = false ;
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);           //khlee-마지막 환경 설정 함수 추가
        }
        // 멀티콤보 처리
        //---------------------------------------------
        for(k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],comboObjects[k].id);
        }
        doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
        document.form.f_slan_cd.focus();
        loadingMode=false;
    }
     /**
      * 멀티콤보 항목을 설정한다.
      */
      function initCombo(comboObj, comboId) {
          with (comboObj) {
              SetDropHeight(300);
              Index=0;
          }
      }
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var i=0;
        var formObject=document.form;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {
	                (17, 0 , 0, true);                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                var HeadTitle="Del.|STS|No.|S.Lane|Trade|Sub Trade|R.Lane|IOC|Dir.|No of Vessels|sect_no|vsl_cnt";
	
	                SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_chk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
					{Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"sect_desc",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"slan_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0 },
					{Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0 },
					{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
					{Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ioc_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0 },
					{Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0 },
					{Type:"Int",       Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"freq_no",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0 },
					{Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"sect_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cnt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"extd_lane_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"sim_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"sim_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"sim_rmk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"dept_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	                 
	                InitColumns(cols);
	
	                SetEditable(1);//전체Edit허용여부[선택,Defaultfalse]
	                SetGetCountPosition(0);
	                SetGetWaitImageVisible(0);
	                

                }
                break;
            case 2:      //sheet2 init
                with (sheetObj) {
                    //no support[check again]CLT style.height=GetSheetHeight(9) ;
                (52, 4, 0, true);                             //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                var HeadTitle="Del.|STS|No.|Register|vsl_flg|Vessel\nClass|OPR|OPR2|vop_flg|Dir.|VSL Capa.|BSA Capa.|Final\nCompany BSA|L/F(%)|" +
                "Joint Operating Carrier's BSA|Joint Operating Carrier's BSA|Joint Operating Carrier's BSA|Joint Operating Carrier's BSA|Joint Operating Carrier's BSA|" +
                "Joint Operating Carrier's BSA|Joint Operating Carrier's BSA|Joint Operating Carrier's BSA|Joint Operating Carrier's BSA|Joint Operating Carrier's BSA|" +
                "Company BSA\nbefore Sub|Company BSA\nbefore Sub|"+
                "Lease|Lease|Lease|Lease|Lease|" +
                "Charter in|Charter in|Charter in|Charter in|Charter in|"+
                "Lease(Income)|Lease(Income)|Lease(Income)|Lease(Income)|Lease(Income)|" +
                "Charter in(Expense)|Charter in(Expense)|Charter in(Expense)|Charter in(Expense)|Charter in(Expense)|"+
                "Sim Div Cd|Sim Dt|Sim No.|Sect No.|vsl_chg|mdm_vsl_yn";
                var HeadTitle1="Del.|STS|No.|Register|vsl_flg|Vessel\nClass|OPR|OPR2|vop_flg|Dir.|VSL Capa.|BSA Capa.|Final\nCompany BSA|L/F(%)|"+"" +
                "OTH1|OTH2|OTH3|OTH4|OTH5|" +
                "OTH1|OTH2|OTH3|OTH4|OTH5|" +
                "Company BSA\nbefore Sub|Company BSA\nbefore Sub|"+
                "Sub OTH1|Sub OTH2|Sub OTH3|Sub OTH4|Sub OTH5|" +
                "Sub OTH1|Sub OTH2|Sub OTH3|Sub OTH4|Sub OTH5|" +
                "Sub OTH1|Sub OTH2|Sub OTH3|Sub OTH4|Sub OTH5|" +
                "Sub OTH1|Sub OTH2|Sub OTH3|Sub OTH4|Sub OTH5|" +
                "Sim Div Cd|sim_dt|Sim No.|sect No.|vsl_chg|mdm_vsl_yn" ;
                var fnl_hjs_bsa="IF(|sim_div_cd|==1, IF(|vop_flg| == 1, (|bsa_capa|-(|otr_crr_bsa_capa1|+|otr_crr_bsa_capa2|+|otr_crr_bsa_capa3|+|otr_crr_bsa_capa4|+|otr_crr_bsa_capa5|))-(|sub_lse_capa1|+|sub_lse_capa2|+|sub_lse_capa3|+|sub_lse_capa4|+|sub_lse_capa5|)+(|sub_chtr_capa1|+|sub_chtr_capa2|+|sub_chtr_capa3|+|sub_chtr_capa4|+|sub_chtr_capa5|)"
                +", (|otr_crr_bsa_capa1|+|otr_crr_bsa_capa2|+|otr_crr_bsa_capa3|+|otr_crr_bsa_capa4|+|otr_crr_bsa_capa5|)-(|sub_lse_capa1|+|sub_lse_capa2|+|sub_lse_capa3|+|sub_lse_capa4|+|sub_lse_capa5|)+(|sub_chtr_capa1|+|sub_chtr_capa2|+|sub_chtr_capa3|+|sub_chtr_capa4|+|sub_chtr_capa5|))"
                +", )";
                var hjs_bsa_bef="IF(|sim_div_cd|==1, IF(|vop_flg| == 1, |bsa_capa|-(|otr_crr_bsa_capa1|+|otr_crr_bsa_capa2|+|otr_crr_bsa_capa3|+|otr_crr_bsa_capa4|+|otr_crr_bsa_capa5|)"
                +", (|otr_crr_bsa_capa1|+|otr_crr_bsa_capa2|+|otr_crr_bsa_capa3|+|otr_crr_bsa_capa4|+|otr_crr_bsa_capa5|))"
                +", 0)";

                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"},
                                { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"",                       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
				{Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vsl_seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"ComboEdit", Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",                 KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
				{Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vsl_flg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				{Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"vsl_clss_capa",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				{Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vsl_oshp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
				{Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vop_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
				{Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vop_flg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"vsl_capa",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"bsa_capa",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0 },
				{Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"fnl_hjs_bsa_capa",       KeyField:0,   CalcLogic:fnl_hjs_bsa,Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"ldf_rto",                KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0 },
				{Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"otr_crr_bsa_capa1",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0 },
				{Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"otr_crr_bsa_capa2",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0 },
				{Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"otr_crr_bsa_capa3",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0 },
				{Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"otr_crr_bsa_capa4",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0 },
				{Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"otr_crr_bsa_capa5",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0 },
				{Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"cal_otr_crr_bsa_capa1",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"cal_otr_crr_bsa_capa2",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"cal_otr_crr_bsa_capa3",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"cal_otr_crr_bsa_capa4",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"cal_otr_crr_bsa_capa5",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"hjs_bfr_bsa_capa",       KeyField:0,   CalcLogic:hjs_bsa_bef,Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"cal_hjs_bfr_bsa_capa",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"sub_lse_capa1",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0 },
				{Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"sub_lse_capa2",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0 },
				{Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"sub_lse_capa3",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0 },
				{Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"sub_lse_capa4",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0 },
				{Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"sub_lse_capa5",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0 },
				{Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"sub_chtr_capa1",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0 },
				{Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"sub_chtr_capa2",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0 },
				{Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"sub_chtr_capa3",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0 },
				{Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"sub_chtr_capa4",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0 },
				{Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"sub_chtr_capa5",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0 },
				{Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"cal_sub_lse_capa1",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0 },
				{Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"cal_sub_lse_capa2",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0 },
				{Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"cal_sub_lse_capa3",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0 },
				{Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"cal_sub_lse_capa4",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0 },
				{Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"cal_sub_lse_capa5",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0 },
				{Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"cal_sub_chtr_capa1",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0 },
				{Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"cal_sub_chtr_capa2",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0 },
				{Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"cal_sub_chtr_capa3",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0 },
				{Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"cal_sub_chtr_capa4",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0 },
				{Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"cal_sub_chtr_capa5",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0 },
				{Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"sim_div_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
				{Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"sect_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
				{Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"vsl_chg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
				{Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"mdm_vsl_yn",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
				{Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"sim_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
				{Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"sim_dt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 } ];
				                 
				                InitColumns(cols);
				
				                SetEditable(1);//전체Edit허용여부[선택,Defaultfalse]
				                SetGetCountPosition(0);
				                SetGetWaitImageVisible(0);
				                                                                                                 SetGetRangeBackColor(1, 14, 1, 23,"#DEFBF8");// ENIS
				                SetGetRangeBackColor(1, 26, 1, 50,"#DEFBF8");// ENIS
				                SetHeaderGetRowHeight(10);
				

                }
                break;
        }
    }
    /*
     * Sheet1관련 프로세스 처리
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        var tmp=0;
        var trade="";
        var cboObj=comboObjects[0];
        var formObj=document.form;
        trade=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trd_cd");
        switch(sAction) {
            case IBCLEAR:          //조회
                ComOpenWait(true);
                formObj.f_cmd.value=INIT;
                var sXml=formObj.sXml.value;
                var arrXml=sXml.split("|$$|");
                document.form.sXml.value="";
                /*
                 var sXml=sheetObj.GetSearchData("ESM_COA_0051GS3.do", coaFormQueryString(formObj));
                var arrXml=sXml.split("|$$|");
                */
                if (arrXml.length > 0)
                    ComXml2ComboItem(arrXml[0], formObj.f_slan_cd, "code", "name");
                if (arrXml.length > 1)
                    ComXml2ComboItem(arrXml[1], formObj.f_dept_cd2, "code", "name");
                if (arrXml.length > 2)
                    ComXml2ComboItem(arrXml[2], formObj.f_sim, "code", "name");
                if (arrXml.length > 3)
                    ComCoaSetIBCombo(sheetObj, arrXml[3], "trd_cd", true, 0);
                if (arrXml.length > 4)
                    ComCoaSetIBCombo(sheetObj, arrXml[4], "sub_trd_cd", true, 0);
                if (arrXml.length > 5)
                    ComCoaSetIBCombo(sheetObj, arrXml[5], "ioc_cd", true, 0);
                if (arrXml.length > 6)
                    ComCoaSetIBCombo(sheetObj, arrXml[6], "skd_dir_cd", true, 0);
                if (arrXml.length > 7)
                    ComCoaSetIBCombo(sheetObjects[1], arrXml[7], "vsl_cd", true, 0);
                if (arrXml.length > 8)
                    ComCoaSetIBCombo(sheetObjects[1], arrXml[8], "vsl_oshp_cd", true, 0);
                if (arrXml.length > 9)
                    ComCoaSetIBCombo(sheetObjects[1], arrXml[9], "vop_cd", true, 0);
                with(formObj) {
                    ComSetObjValue(f_sim, ComCoaGetEtcData(arrXml[0], "f_sim"));
                    ComSetObjValue(f_slan_cd,ComCoaGetEtcData(arrXml[0], "f_slan_cd"));
                    ComSetObjValue(f_sim_dt,ComCoaGetEtcData(arrXml[0], "f_sim_dt"));
                    ComSetObjValue(f_sim_no,ComCoaGetEtcData(arrXml[0], "f_sim_no"));
                    ComSetObjValue(f_sim_rmk,ComCoaGetEtcData(arrXml[0], "f_sim_rmk"));
                    ComSetObjValue(f_dept_cd,ComCoaGetEtcData(arrXml[0], "f_dept_cd"));
                    ComSetObjValue(f_dept_cd2,ComCoaGetEtcData(arrXml[0], "f_dept_cd2"));
                    ComSetObjValue(f_usr_id,ComCoaGetEtcData(arrXml[0], "f_usr_id"));
                    ComSetObjValue(f_dept_cd_1,ComCoaGetEtcData(arrXml[0], "f_dept_cd"));
                    ComSetObjValue(usr_id,ComCoaGetEtcData(arrXml[0], "f_usr_id"));
                }
                ComOpenWait(false);
                break;
            case IBBATCH:
                if(!validateForm(sheetObj,formObj,sAction)) return false;
                formObj.f_cmd.value=SEARCHLIST03;
                 sheetObj.DoSearch("ESM_COA_0051GS.do", coaFormQueryString(formObj+"&"+'f_dept_cd_1|usr_id|f_ext_flg|f_sim|f_dept_cd|f_usr_id|f_sim_dt|f_sim_no') );
                //Flag 초기값 INS로 셋팅
                //09/8/26 추가 윤진영 sim_dt(formObj),sim_no(formObj),sect_no(ibsheetObj) 존재하면 상태를 UPDATE로 변경*/
                for(i=1; i<=sheetObj.LastRow(); i++){
                       var sim_dt=formObj.f_sim_dt.value;
                       var sim_no=ComGetObjValue(formObj.f_sim_no);
                       var sect_no=sheetObj.GetCellValue(i,"sect_no");
                    //var status = sheetObj.CellValue(i,"ibflag") ;
                       var status=sheetObj.GetRowStatus(i);
                    if(sim_dt !="" && sim_no !="" && sect_no !="") {
                        //sheetObj.CellValue2(i, "ibflag") = "U";
                        sheetObj.SetRowStatus(i,"U");
                    } else if(status == "R") {
                         //sheetObj.CellValue2(i, "ibflag") = "I";
                        sheetObj.SetRowStatus(i,"I");
                     }
                }
                break;
            case IBSEARCH:      //조회
                if(!validateForm(sheetObj,formObj,sAction)) return false;
                if(ComGetObjValue(formObj.f_sim_no) == "") {
                    ComShowMessage(ComGetMsg("COA10002","Simulation No"));
                    return false;
                }
                ComOpenWait(true);
                formObj.f_cmd.value=SEARCHLIST01;
                 sheetObj.DoSearch("ESM_COA_0051GS.do",coaFormQueryString(formObj+"&"+'f_dept_cd_1|usr_id|f_ext_flg|f_sim|f_dept_cd|f_usr_id') );
                //sheetObj.DoSearch("ESM_COA_0051GS.do",FormQueryString(formObj));
                ComOpenWait(false);
                break;
            case IBROWSEARCH:   // sub trade에 대한 정보를 조회한다.
                formObj.f_cmd.value=SEARCH02;
                formObj.f_srow.value=sheetObj.GetSelectRow();
                formObj.f_trd_cd.value=trade;
                formObj.f_flag.value="subTrade";
//conversion of function[check again]CLT                 sheetObj.DoRowSearch( ROW,coaFormQueryString(formObj"&f_dept_cd_1|usr_id|f_ext_flg|f_slan_cd|f_dept_cd|f_usr_id|f_sim_dt|f_usr_id)" );
                break;
            case IBSAVE:        //저장(Sheet1:Save)
                if(!validateForm(sheetObj,formObj,sAction))  return false;
                for(i=1; i<sheetObj.LastRow()+1; i++){
                    sheetObj.SetCellValue(i,"sim_dt",ComGetObjValue(formObj.f_sim_dt));
                    sheetObj.SetCellValue(i,"sim_rmk",ComGetObjValue(formObj.f_sim_rmk));
                    sheetObj.SetCellValue(i,"sim_no",ComGetObjValue(formObj.f_sim_no));
                    sheetObj.SetCellValue(i,"dept_cd",ComGetObjValue(formObj.f_dept_cd));
                }
                //formObj.sim_rmk.value = formObj.f_sim_rmk.value;
                //formObj.sim_no.value = formObj.f_sim_no.value;
                // 업무처리중 버튼사용 금지 처리
                formObj.f_ext_flg.value="Y";
                ComOpenWait(true);
                formObj.f_cmd.value=MULTI01;
                sheetObj.DoSave("ESM_COA_0051GS.do", coaFormQueryString(formObj));
                ComOpenWait(false);
                if (sheetObj.GetEtcData("sim_no") == undefined){
                    formObj.f_sim_no.value="";
                }else{
                    formObj.f_sim_no.value=sheetObj.GetEtcData("sim_no");
                }
                var newLane="";
                if (sheetObj.GetEtcData("newLane") != undefined){
                    newLane=sheetObj.GetEtcData("newLane");
                }
                //new Lane 버튼을 선택한 후 기존 Lane을 시뮬레이션 할 경우 existing lane으로 변경해준다.
                if(newLane == "Y")  formObj.f_ext_flg[1].checked=true;
                if(newLane == "N")  formObj.f_ext_flg[0].checked=true;
                if(newLane == "N") {
                    strUrl="ESM_COA_0150.do";
                    strUrl += "?f_slan_cd="+ComGetObjValue(formObj.f_slan_cd);
                    strUrl += "&f_sim_dt="+ComGetObjValue(formObj.f_sim_dt);
                    strUrl += "&f_sim_no="+ComGetObjValue(formObj.f_sim_no);
                    strUrl += "&f_dept_cd="+ComGetObjValue(formObj.f_dept_cd);
                    strUrl += "&f_usr_id="+ComGetObjValue(formObj.f_usr_id);
                    ComOpenWindow(strUrl,'_Inqury','width=700, height=500,menubar=0,status=0,scrollbars=0,resizable=0');
                }
                if(newLane != "") {
                    ComSetObjValue(formObj.f_txtTmp,ComGetObjValue(formObj.f_dept_cd) + "|" + ComTrimAll(formObj.f_sim_dt.value,"-") + "|" + ComGetObjValue(formObj.f_sim_no)) ;
                    chgSLane(formObj.f_slan_cd);
                    ComSetObjValue(formObj.f_dept_cd2,ComGetObjValue(formObj.f_dept_cd));
                }
                sheetObj.RemoveEtcData();                          // ETC 데이타 삭제
                break;
            case IBINSERT:      // 입력
                /* simulation number에는 6개 까지 section number를 입력할수 있다. */
                if(sheetObj.RowCount()< 6){
                    /* 검색조건의 simulation number가 선택되지 않으면 선택하라는 메시지를 뿌려준다.*/
                    if(ComGetObjValue(formObj.f_slan_cd) == ""){
                        // [COM12113] > S.Lane 를(을) 선택하세요.
                        ComShowMessage(ComGetMsg("COM12113","S.Lane",""));
                        ComSetFocus(formObj.f_slan_cd);
                        return false;
                    }
                    if(formObj.f_sim_dt.value == ""){
                        // [COM12113] > S.Lane 를(을) 선택하세요.
                        ComShowMessage(ComGetMsg("COM12113","S.Lane",""));
                        formObj.f_sim_dt.focus();
                        return false;
                    }
                   sheetObj.DataInsert();
                   for(i=1; i<sheetObj.LastRow()+1; i++){
if(parseInt(tmp)<parseInt(sheetObj.GetCellValue(i, "sect_no")))tmp=sheetObj.GetCellValue(i, "sect_no");
                   }
                   tmp=parseInt(tmp) + 1;
                   /* slan_cd, sim_dt, sim_no, sect_no를 새로운 행에 입력한다.*/
                   sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sect_no",ComLpad(tmp+"",3,0));
                   sheetObj.SetCellText(sheetObj.GetSelectRow(), 2 ,"Sec." +tmp);
                   sheetObj.SetCellValue(sheetObj.GetSelectRow(), "slan_cd",cboObj.GetSelectText());
                   sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sim_dt",ComTrimAll(formObj.f_sim_dt.value,"-"));
                   sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sim_no",formObj.f_sim_no.value);
                   if(sheetObj.RowCount()> "1"){
sheetObj.SetCellValue(sheetObj.GetSelectRow(), "freq_no",sheetObj.GetCellValue(1,"freq_no"));
                   }
                }else{
                    // [COA10007] > 최대 6까지  입력할수 있습니다.
                    ComShowMessage(ComGetMsg("COA10007","6"));
                }
                break;
            case IBDELETE:        // 행 삭제(마스터 테이블과 관련된 모든 테이블을 삭제한다)
if(ComShowConfirm(ComGetMsg("COM12165", sheetObj.GetCellValue(sheetObj.GetSelectRow(), 2)))){
                    ComOpenWait(true);
                    formObj.f_cmd.value=REMOVE01;
                    sheetObj.DoSave("ESM_COA_0051GS.do", coaFormQueryString(formObj,'f_dept_cd_1|usr_id|f_srow|f_trd_cd|f_flag|f_ext_flg|f_slan_cd|f_sim|f_dept_cd|f_usr_id'));
                    ComOpenWait(false);
                }
                break;
            case IBDOWNEXCEL:        //엑셀 다운로드
                var excelType=selectDownExcelMethod(sheetObj);
                switch (excelType) {
                    case "AY":
                         sheetObjects[0].Down2Excel({ HiddenColumn:0,Merge:true});
                         sheetObjects[1].Down2Excel({ HiddenColumn:0,Merge:true});
                        break;
                    case "DY":
                         sheetObjects[0].Down2Excel({ HiddenColumn:-1,Merge:true});
                         sheetObjects[1].Down2Excel({ HiddenColumn:-1,Merge:true});
                        break;
                       case "AN":
                         sheetObjects[0].Down2Excel({ HiddenColumn:0});
                         sheetObjects[1].Down2Excel({ HiddenColumn:0});
                        break;
                    case "DN":
                         sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol(                        sheetObjects[0]), SheetDesign:1,Merge:1 });
                         sheetObjects[1].Down2Excel( {DownCols: makeHiddenSkipCol(                        sheetObjects[1]), SheetDesign:1,Merge:1 });
                        break;
                }
                break;
        }
    }
    /*
     * Sheet2관련 프로세스 처리
     */
    function doActionIBSheet2(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        var sheetObj1=sheetObjects[0];
        var sim_dt=ComReplaceStr(formObj.f_sim_dt.value,"-","");
        var sim_no=ComGetObjValue(formObj.f_sim_no);
        var sect_no=sheetObj1.GetCellValue(sheetObj1.GetSelectRow(), 'sect_no');
        var slan_cd=ComGetObjValue(formObj.f_slan_cd);
        var row=sheetObj.GetSelectRow();
        var vsl_cd=sheetObj.GetCellValue(sheetObj.GetSelectRow(),"vsl_cd");
        var skd_dir_cd=sheetObj1.GetCellValue(sheetObj1.GetSelectRow(), "skd_dir_cd");
//        formObj.f_sim_dt.value = ComReplaceStr(formObj.f_sim_dt.value,"-","");
        switch(sAction) {
            case IBSEARCH:      //조회
                ComOpenWait(true);
                formObj.f_cmd.value=SEARCHLIST02;
//-----------윤진영추가 0807----------------------------
                ComSetObjValue(formObj.f_sect_no,sect_no);
                ComSetObjValue(formObj.f_skd_dir_cd,skd_dir_cd);
//------------------------------------------------------
                 sheetObj.DoSearch("ESM_COA_0051GS2.do",coaFormQueryString(formObj+"&"+'f_dept_cd_1|usr_id|f_txtTmp|f_ext_flg|f_slan_cd|f_sim|f_dept_cd|subtitle') );
                //TODO 마지막 slot price 의 seq노출은 가려준다
                //sheetObj1.CellValue(sheet"vsl_seq",);
                ComOpenWait(false);
                break;
            case IBSAVE:        //저장
                if(!validateForm2(sheetObj,formObj,sAction)){
                    return false;
                }
                if(!chkMendatory()){    //MENDATORY 항목 체크
                    return false;
                }
                for(i=2; i<sheetObj.LastRow()+1; i++){
                    sheetObj.SetCellValue(i,"sim_dt",formObj.f_sim_dt.value);
                    sheetObj.SetCellValue(i,"sim_no",formObj.f_sim_no.value);
                }
                //formObj.sect_no.value = sect_no;
                for(i=0; i< sheetObj.LastRow(); i++){
                    sheetObj.SetCellValue(i, "sect_no",sect_no,0);
                }
                //formObj.f_skd_dir_cd.value = skd_dir_cd;
                ComOpenWait(true);
                formObj.f_cmd.value=MULTI02;
                sheetObj.DoSave("ESM_COA_0051GS2.do", coaFormQueryString(formObj,'f_dept_cd_1|f_ext_flg|f_slan_cd|f_sim|f_dept_cd|f_sim_dt|f_sim_no|f_usr_id|subtitle'), false);
                ComOpenWait(false);
                if(sheetObj.GetEtcData("Result")=="OK"){
                    var vessel=sheetObj.GetEtcData("vessel");
                    // 신규배를 COMBO 항목으로 추가하기 위해서 다시 세팅
                    sheetObj.SetColProperty("vsl_cd", {ComboText:vessel, ComboCode:vessel} );
                    sheetObj.RemoveEtcData();
                    for(i=2; i<sheetObj.LastRow(); i++){
                        sheetObj.SetCellEditable(i,"vsl_clss_capa",0);
                        sheetObj.SetCellEditable(i,"vsl_oshp_cd",0);
                        sheetObj.SetCellEditable(i,"vop_cd",0);
                        sheetObj.SetCellEditable(i,"vsl_capa",0);
                        sheetObj.SetCellValue(i, "vsl_flg","N",0);
                        //sheetObj.CellValue(i, "ibflag")         = "R";
                        sheetObj.SetRowStatus(i,"R");
                    }
                    doActionIBSheet(sheetObj1,formObj,IBSEARCH);
                }
                break;
            case IBROWSEARCH:
                formObj.f_cmd.value=SEARCH01;
                formObj.f_flag.value="";  // sheet1번의 subtrade onChange 와 같은 H.do를 사용하므로.. 분기 처리 reset
                formObj.f_srow.value=row;
                ComSetObjValue(formObj.f_vsl_cd,vsl_cd);
                ComSetObjValue(formObj.f_skd_dir_cd,skd_dir_cd);
//conversion of function[check again]CLT                 sheetObj.DoRowSearch( ROW,coaFormQueryString(formObj) );
                var row=sheetObj.GetSelectRow();
                if (sheetObj.GetCellValue(row, "mdm_vsl_yn") == "N") {
                    sheetObj.SetCellEditable(row,"vsl_clss_capa",1);
                    sheetObj.SetCellEditable(row,"vsl_oshp_cd",1);
                    sheetObj.SetCellEditable(row,"vop_cd",1);
                    sheetObj.SetCellEditable(row,"vsl_capa",1);
                    sheetObj.SetCellValue(row, "vsl_chg","0");
//                    if(confirm('Vessel is not exist. Do you want to input data?')){
//                        noRtnPopup("ESM_COA_148.do" + param, 'width=500, height=590, menubar=no, status=no,scrollbars=no, resizable=yes');
//                    }
                } else {
                    sheetObj.SetCellEditable(row,"vsl_clss_capa",0);
                    sheetObj.SetCellEditable(row,"vsl_oshp_cd",0);
                    sheetObj.SetCellEditable(row,"vop_cd",0);
                    sheetObj.SetCellEditable(row,"vsl_capa",0);
                    sheetObj.SetCellValue(row, "vsl_chg","1");
                }
                break;
            case IBINSERT:      // 입력
                var sRow=sheetObj.FindStatusRow("I|U|R");
                var arRow=sRow.split(";").length-2;
                var cyRow=parseInt(sheetObj.LastRow())-1;
                /* No of Vessels와 작거나 같을때까지만 Row를 추가한다.*/
                if(sheetObj1.GetCellValue(sheetObj1.GetSelectRow(), "freq_no") >arRow){
                    /* Row Insert는 마지막 Row 위에 삽입된다.*/
                    sheetObj.SetSelectRow(cyRow);
                    sheetObj.DataInsert();
                    sheetObj.SetCellValue(sheetObj.GetSelectRow(), "slan_cd",slan_cd,0);
                    sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sim_dt",sim_dt,0);
                    sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sim_no",sim_no,0);
                    sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sect_no",sect_no,0);
                    sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sim_div_cd","1",0);
                }else{
                    // [COA10008] >> No of Vessels을(를)  초과할수 없습니다.
                    ComShowMessage(ComGetMsg("COA10008","No of Vessels",""));
                    //ComShowMessage("Cannot choose more than the No of Vessels.");
                }
                /* Sheet1 의 DIR을 sheet2에 셋팅 */
                for(i=2; i< sheetObj.LastRow(); i++){
                    sheetObj.SetCellValue(i,"skd_dir_cd",skd_dir_cd,0);
                }
                break;
        }
    }
    /**
     * Step 단계별로 화면 이동
     */
    function doActionPageMove(sheetObj, formObj, btnName){
        formObj.f_cmd.value="";
        formObj.method="POST";
        formObj.target="";
        // MultCombo 일경우 submit()으로 넘기면 데이터를 정상적으로 넘길수 었기 때문에 아래와 같이 GET 방식으로 데이터를 넘긴다
        if (btnName == "step01"){
            formObj.action("ESM_COA_0051.do?f_slan_cd="+formObj.f_slan_cd.SetSelectCode+"&pgmNo=ESM_COA_0051");
            formObj.submit();
        }else if(btnName == "step02"){
            formObj.action("ESM_COA_0052.do?f_slan_cd="+formObj.f_slan_cd.SetSelectCode+"&pgmNo=ESM_COA_0051");
            formObj.submit();
        }else if(btnName == "step03"){
            formObj.action("ESM_COA_0053.do?f_slan_cd="+formObj.f_slan_cd.SetSelectCode+"&pgmNo=ESM_COA_0051");
            formObj.submit();
        }else if(btnName == "step04"){
            formObj.action("ESM_COA_0054.do?f_slan_cd="+formObj.f_slan_cd.SetSelectCode+"&pgmNo=ESM_COA_0051");
            formObj.submit();
        }
    }
    /**
     * Step 단계별로 클릭 시 화면 display
     */
//  function InvOnChange( dst , m  ){
//      document.getElementById(dst).style.display=m;
//  }
    /**
     * Trade combo 변경시 sub Trade combo의 값을 변경시켜준다
     */
    function s1sheet1_OnChange(sheetObj, row, col, value){
        var comboValue="";
        var frmObj=document.form;
        /* trade code 변경시 sub Trade code list를 조회한다.*/
        if (sheetObj.ColSaveName(col) == "trd_cd") {
            doActionIBSheet(sheetObj, frmObj, IBROWSEARCH);
            /* trade code 변경시 S.Lane 과 조합하여 R.Lane을 자동완성 시켜준다. - setVesselInfo1() 같이 수정할것 */
			s_slan_cd=sheetObj.GetCellValue(sheetObj.GetSelectRow(),"slan_cd");
			s_trd_cd=sheetObj.GetCellValue(sheetObj.GetSelectRow(),"trd_cd");
			sheetObj.GetCellValue2(sheetObj.SetSelectRow,"rlane_cd")(s_slan_cd + s_trd_cd.substring(0,2));
        }
        // 첫번째 Row에서 No of Vessels 변경시 다른 section에도 모두 적용시킨다. if (sheetObj.ColSaveName(col) == "freq_no" && row == 1)
        // 모든 Row 체크하도록 변경함.
        if(sheetObj.ColSaveName(col) == "freq_no"){
        	if (sheetObj.GetCellValue(row,"vsl_cnt") != 0 && sheetObj.GetCellValue(row,"vsl_cnt") > value ){
                // [COA10013] : No of Vessels의 갯수와 일치하지 않습니다
                ComShowMessage(ComGetMsg("COA10013", "Vessel"));
                sheetObj.SetCellValue(row,"freq_no",sheetObj.GetCellValue(row,"vsl_cnt"),0);
                sheetObj.SelectCell(row, col);
                return false;
            }
        }
        if (sheetObj.ColSaveName(col) == "freq_no" ){
            for(i=1; i<= sheetObj.RowCount(); i++){
                sheetObj.SetCellValue(i,"freq_no",value,0);
            }
        }
    }
    /**
     * sheet2의 배 정보가 변경되면 배에대한 정보를 조회한다.
     */
    function s1sheet2_OnChange(sheetObj, row, col, value){
        var formObject=document.form;
        // Vessel code 변경시 Vessel 정보를 조회한다.
        //-----------------------------------------------
        var inputData=sheetObj.GetCellValue(row, "hjs_bfr_bsa_capa");    //dddd 부분을 input name 으로 바꿔주세요 ㅡ
          /*var splitData=inputData.split(".");  // "." 으로 나눈다.
           if (splitData.length==1){  //.이 없으면
            inputData=inputData+".0";
           } else if (splitData.length ==1){     //. 이 있을때는 ㅡ
            var split1=splitData[0].length;
            if (split1 == 1 ){   //소수점 뒤에 1자리 수이면
             inputData=inputData ;
            } else if (split1 > 2) {  //소수점 뒤가 2자리수 이상이면 ㅡ
             inputData=(Math.round(inputData*100))/10; //소수전 3째자리에서 반올림 ㅡ
            }
           }*/
          //sheetObj.CellValue(row, "hjs_bfr_bsa_capa") = inputData;
        // 비용 계산을 위해서 vop_cd가 변경되면 vop_flg를 변경 시켜준다
        if(sheetObj.ColSaveName(col) == "vop_cd" ){
            if (value == "vop_cd") {
                sheetObj.SetCellValue(row,"vop_flg","1");
            } else {
                sheetObj.SetCellValue(row,"vop_flg","0");
            }
        }
        if(sheetObj.ColSaveName(col) == "vsl_cd" && sheetObj.GetCellValue(row,"vsl_cd").length == 4){
            // Vessel 정보를 제외한 나머지 정보를 모두 초기화한다.
            for(j=14;j<46;j++){
                sheetObj.SetCellValue(row,j,"",0);
            }
            doActionIBSheet2(sheetObj, formObject, IBROWSEARCH);
        // load factor(%) 소숫점으로 입력하고 %로 보여준다.
        // 2007.02.01 제외
        //-----------------------------------------------
        }
    }
    /**
     * BSA Slot Swap Vol&Cost
     * 0 : BSA Slot Swap Vol
     * 1 : BSA Slot Swap Cost
     */
    function calculate(sheetObj, param1){
        var rowNo=0;
        var formObj=document.form;
        var blnBSA, blnRev;
        if (param1 == 0) {
            btn_rowadd2.style.display="";
            btn_save2.style.display="";
            btn_rowadd3.style.display="";
            btn_save3.style.display="";
            btn_rowadd4.style.display="";
            btn_save4.style.display="";
            sheetObj.SetEditable(1);
            blnBSA=false;
            blnRev=true;
        } else {
            btn_rowadd2.style.display="none";
            btn_save2.style.display="none";
            btn_rowadd3.style.display="none";
            btn_save3.style.display="none";
            btn_rowadd4.style.display="none";
            btn_save4.style.display="none";
            sheetObj.SetEditable(0);
            blnBSA=true;
            blnRev=false;
        }
        rowNo=sheetObj.LastRow();
        sheetObj.SetColHidden("otr_crr_bsa_capa1",blnBSA);
        sheetObj.SetColHidden("otr_crr_bsa_capa2",blnBSA);
        sheetObj.SetColHidden("otr_crr_bsa_capa3",blnBSA);
        sheetObj.SetColHidden("otr_crr_bsa_capa4",blnBSA);
        sheetObj.SetColHidden("otr_crr_bsa_capa5",blnBSA);
        sheetObj.SetColHidden("cal_otr_crr_bsa_capa1",blnRev);
        sheetObj.SetColHidden("cal_otr_crr_bsa_capa2",blnRev);
        sheetObj.SetColHidden("cal_otr_crr_bsa_capa3",blnRev);
        sheetObj.SetColHidden("cal_otr_crr_bsa_capa4",blnRev);
        sheetObj.SetColHidden("cal_otr_crr_bsa_capa5",blnRev);
        sheetObj.SetColHidden("hjs_bfr_bsa_capa",blnBSA);
        sheetObj.SetColHidden("cal_hjs_bfr_bsa_capa",blnRev);
        sheetObj.SetColHidden("sub_lse_capa1",blnBSA);
        sheetObj.SetColHidden("sub_lse_capa2",blnBSA);
        sheetObj.SetColHidden("sub_lse_capa3",blnBSA);
        sheetObj.SetColHidden("sub_lse_capa4",blnBSA);
        sheetObj.SetColHidden("sub_lse_capa5",blnBSA);
        sheetObj.SetColHidden("sub_chtr_capa1",blnBSA);
        sheetObj.SetColHidden("sub_chtr_capa2",blnBSA);
        sheetObj.SetColHidden("sub_chtr_capa3",blnBSA);
        sheetObj.SetColHidden("sub_chtr_capa4",blnBSA);
        sheetObj.SetColHidden("sub_chtr_capa5",blnBSA);
        sheetObj.SetColHidden("cal_sub_lse_capa1",blnRev);
        sheetObj.SetColHidden("cal_sub_lse_capa2",blnRev);
        sheetObj.SetColHidden("cal_sub_lse_capa3",blnRev);
        sheetObj.SetColHidden("cal_sub_lse_capa4",blnRev);
        sheetObj.SetColHidden("cal_sub_lse_capa5",blnRev);
        sheetObj.SetColHidden("cal_sub_chtr_capa1",blnRev);
        sheetObj.SetColHidden("cal_sub_chtr_capa2",blnRev);
        sheetObj.SetColHidden("cal_sub_chtr_capa3",blnRev);
        sheetObj.SetColHidden("cal_sub_chtr_capa4",blnRev);
        sheetObj.SetColHidden("cal_sub_chtr_capa5",blnRev);
        /* BSA & Slot Swap Vol 이 선택되었을때 */
        if(param1 == 0){
        /* BSA & Slot Swap Rev. & Cost 이 선택되었을때 */
        }else{
            for(i=2; i<=rowNo; i++){
                //var status = sheetObj.CellValue(i,"ibflag") ;
            	var status=sheetObj.GetRowStatus(i) ;
                if(i == rowNo){/* Slot Cost 는 그대로 이동*/
                    sheetObj.SetCellValue(i, "cal_otr_crr_bsa_capa1","0",0);
                    sheetObj.SetCellValue(i, "cal_otr_crr_bsa_capa2","0",0);
                    sheetObj.SetCellValue(i, "cal_otr_crr_bsa_capa3","0",0);
                    sheetObj.SetCellValue(i, "cal_otr_crr_bsa_capa4","0",0);
                    sheetObj.SetCellValue(i, "cal_otr_crr_bsa_capa5","0",0);
                    sheetObj.SetCellValue(i, "cal_hjs_bfr_bsa_capa",sheetObj.GetCellValue(rowNo, "hjs_bfr_bsa_capa"),0);
                }else{
                /*
                 * Vessel Operation code가  자사이면
                 * Other Carrier BSA Capacity Slot Cost * Other Carrier BSA Capacity
                 */
				sheetObj.SetCellValue(i, "cal_otr_crr_bsa_capa1",parseFloat(sheetObj.GetCellValue(rowNo, "otr_crr_bsa_capa1")) * parseFloat(sheetObj.GetCellValue(i,"otr_crr_bsa_capa1")),0);
				sheetObj.SetCellValue(i, "cal_otr_crr_bsa_capa2",parseFloat(sheetObj.GetCellValue(rowNo, "otr_crr_bsa_capa2")) * parseFloat(sheetObj.GetCellValue(i,"otr_crr_bsa_capa2")),0);
				sheetObj.SetCellValue(i, "cal_otr_crr_bsa_capa3",parseFloat(sheetObj.GetCellValue(rowNo, "otr_crr_bsa_capa3")) * parseFloat(sheetObj.GetCellValue(i,"otr_crr_bsa_capa3")),0);
				sheetObj.SetCellValue(i, "cal_otr_crr_bsa_capa4",parseFloat(sheetObj.GetCellValue(rowNo, "otr_crr_bsa_capa4")) * parseFloat(sheetObj.GetCellValue(i,"otr_crr_bsa_capa4")),0);
				sheetObj.SetCellValue(i, "cal_otr_crr_bsa_capa5",parseFloat(sheetObj.GetCellValue(rowNo, "otr_crr_bsa_capa5")) * parseFloat(sheetObj.GetCellValue(i,"otr_crr_bsa_capa5")),0);
				if(sheetObj.GetCellValue(i, "vop_cd") == "vop_cd")  sheetObj.SetCellValue(i, "cal_hjs_bfr_bsa_capa","0",0);
				else sheetObj.SetCellValue(i, "cal_hjs_bfr_bsa_capa",parseFloat(sheetObj.GetCellValue(rowNo, "hjs_bfr_bsa_capa")) * parseFloat(sheetObj.GetCellValue(i,"hjs_bfr_bsa_capa")),0);
				sheetObj.SetCellValue(i, "cal_sub_lse_capa1",parseFloat(sheetObj.GetCellValue(rowNo, "sub_lse_capa1"))  * parseFloat(sheetObj.GetCellValue(i,"sub_lse_capa1")),0);
				sheetObj.SetCellValue(i, "cal_sub_lse_capa2",parseFloat(sheetObj.GetCellValue(rowNo, "sub_lse_capa2"))  * parseFloat(sheetObj.GetCellValue(i,"sub_lse_capa2")),0);
				sheetObj.SetCellValue(i, "cal_sub_lse_capa3",parseFloat(sheetObj.GetCellValue(rowNo, "sub_lse_capa3"))  * parseFloat(sheetObj.GetCellValue(i,"sub_lse_capa3")),0);
				sheetObj.SetCellValue(i, "cal_sub_lse_capa4",parseFloat(sheetObj.GetCellValue(rowNo, "sub_lse_capa4"))  * parseFloat(sheetObj.GetCellValue(i,"sub_lse_capa4")),0);
				sheetObj.SetCellValue(i, "cal_sub_lse_capa5",parseFloat(sheetObj.GetCellValue(rowNo, "sub_lse_capa5"))  * parseFloat(sheetObj.GetCellValue(i,"sub_lse_capa5")),0);
				sheetObj.SetCellValue(i, "cal_sub_chtr_capa1",parseFloat(sheetObj.GetCellValue(rowNo, "sub_chtr_capa1")) * parseFloat(sheetObj.GetCellValue(i,"sub_chtr_capa1")),0);
				sheetObj.SetCellValue(i, "cal_sub_chtr_capa2",parseFloat(sheetObj.GetCellValue(rowNo, "sub_chtr_capa2")) * parseFloat(sheetObj.GetCellValue(i,"sub_chtr_capa2")),0);
				sheetObj.SetCellValue(i, "cal_sub_chtr_capa3",parseFloat(sheetObj.GetCellValue(rowNo, "sub_chtr_capa3")) * parseFloat(sheetObj.GetCellValue(i,"sub_chtr_capa3")),0);
				sheetObj.SetCellValue(i, "cal_sub_chtr_capa4",parseFloat(sheetObj.GetCellValue(rowNo, "sub_chtr_capa4")) * parseFloat(sheetObj.GetCellValue(i,"sub_chtr_capa4")),0);
				sheetObj.SetCellValue(i, "cal_sub_chtr_capa5",parseFloat(sheetObj.GetCellValue(rowNo, "sub_chtr_capa5")) * parseFloat(sheetObj.GetCellValue(i,"sub_chtr_capa5")),0);
                }
                if(status == "R") //sheetObj.SetCellValue(i, "ibflag","R",0);
                    sheetObj.SetRowStatus(i,"R");
            }
        }
    }
    /**
     * sheet1저장후 simulation number select box를 리로딩한다.
     * [새로 입력된 항목을 리로딩하기위해서]
     */
    function s1sheet1_OnSaveEnd(sheetObj, ErrMsg){
        var formObj=document.form;
        var cboObj=comboObjects[0];
        formObj.f_txtTmp.value=ComGetObjValue(formObj.f_sim_dt) + "|" + ComGetObjValue(formObj.f_sim_no);
    }
    /**
     * new Lane 또는  existing Lane 셋팅
     * */
    function s1sheet1_OnSearchEnd(sheetObj,ErrMsg){
        var formObj=document.form;
        extd_lane_flg=sheetObj.GetCellValue(1, "extd_lane_flg"); //(Y:existing lane,N:new lane)
        if(formObj.f_cmd.value == SEARCHLIST01){
            if(extd_lane_flg == "Y")  formObj.f_ext_flg[1].checked=true;
            else formObj.f_ext_flg[0].checked=true;
        }
    }
    /**
     * sheet2에 데이터를 바인딩하고난 후에 타는 로직
     */
    function s1sheet2_OnSearchEnd(sheetObj,ErrMsg){
        var sheetObj1=sheetObjects[0];
        var no=sheetObj1.GetCellValue(sheetObj1.GetSelectRow(),"freq_no");
        var formObj=document.form;
        var extd_lane_flg=formObj.f_ext_flg[1].checked;
        /* 조회된 내용이 없으면 No of Vessels 수만큼 Row를 추가하고 마지막줄은 ESM_COA_051.xml의 내용을 추가한후 기본정보를 입력한다.*/
        if(sheetObj.RowCount()== 0){
             sheetObj.DoSearch("apps/opus/esm/coa/lanesimulation/jsp/ESM_COA_0051GS3.jsp" );
            for( i=0; i<no ; i++){
                sheetObj.DataInsert(0);
                sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sim_div_cd","1",0);
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "slan_cd",sheetObj1.GetCellValue(sheetObj1.GetSelectRow(), "slan_cd"),0);
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sim_dt",sheetObj1.GetCellValue(sheetObj1.GetSelectRow(), "sim_dt"),0);
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sim_no",sheetObj1.GetCellValue(sheetObj1.GetSelectRow(), "sim_no"),0);
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sect_no",sheetObj1.GetCellValue(sheetObj1.GetSelectRow(), "sect_no"),0);
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "skd_dir_cd",sheetObj1.GetCellValue(sheetObj1.GetSelectRow(), "skd_dir_cd"),0);
            }
            sheetObj.SetCellValue(sheetObj.LastRow(), "sim_div_cd","2",0);
			sheetObj.SetCellValue(sheetObj.LastRow(), "slan_cd",sheetObj1.GetCellValue(sheetObj1.GetSelectRow(), "slan_cd"),0);
			sheetObj.SetCellValue(sheetObj.LastRow(), "sim_dt",sheetObj1.GetCellValue(sheetObj1.GetSelectRow(), "sim_dt"),0);
			sheetObj.SetCellValue(sheetObj.LastRow(), "sim_no",sheetObj1.GetCellValue(sheetObj1.GetSelectRow(), "sim_no"),0);
			sheetObj.SetCellValue(sheetObj.LastRow(), "sect_no",sheetObj1.GetCellValue(sheetObj1.GetSelectRow(), "sect_no"),0);
             sheetObj.InitCellProperty(sheetObj.LastRow(), "hjs_bfr_bsa_capa",{ Type:"Data",Align:"Right",Format:"dfFloatOrg",PointCount:0} );
        }
        // Existing Lane 이면, VSL & BSA I/F 버튼 활성화
        if(extd_lane_flg)  td_bsa.style.display="block";
    }
    /**
    * sheet1을 더블클릭하여 상세조회한다
    */
    function s1sheet1_OnDblClick(sheetObj , row, col){
        var sheetObject1=sheetObjects[1];
        var formObject=document.form;
        // BSA & Slot Swap Vol를 디폴드로 선택한다.
        formObject.radCode[0].checked=true;
        calculate(sheetObject1, "0");
        // No of Vessels를 입력하면 아래 그리드에 데이터를 조회[초기화]한다.
        if(sheetObj.GetCellValue(sheetObj.GetSelectRow(),"freq_no")>0){
            doActionIBSheet2(sheetObject1,formObject,IBSEARCH);
            formObject.subtitle.value=sheetObj.GetCellValue(row,2) + " / "
            + " / " + sheetObj.GetCellValue(row,"trd_cd") + " / " + sheetObj.GetCellValue(row,"ioc_cd")+ " / " + sheetObj.GetCellValue(row,"skd_dir_cd");
        }else{
            // [COM12130] > Sec.의 Frequancy를(을) 입력하세요.
        	ComShowMessage(ComGetMsg("COM12130", sheetObj.GetCellValue(sheetObj.GetSelectRow(), 2), "Frequancy"));
        }
    }
    /**
     * Vessel 항목에서 Enter시 Vessel 정보를 제조회한다
     */
    function s1sheet2_OnKeyDown(sheetObj, row, col, KeyCode, Shift){
        if(sheetObj.ColSaveName(col) == "vsl_cd") {
            if (KeyCode ==13){
                doActionIBSheet2(sheetObj, document.form, IBROWSEARCH);
            }
        }
    }
    /**
     * Service Lane변경시 해당 Simulation No를 조회한다.
     */
    function chgSLane(obj){
        var formObj=document.form;
         var sheetObj=sheetObjects[0];
         if (ComGetObjValue(obj) != "") {
            var simNo=ComGetObjValue(formObj.f_sim);
             formObj.f_cmd.value=SEARCHLIST10;
              var sXml=sheetObj.GetSearchData("ESM_COA_0051GS3.do", coaFormQueryString(formObj));
             var arrXml=sXml.split("|$$|");
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
        var chars="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        text=text.toUpperCase();
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        if(ComTrim(value) != "" ) { // S.Lane
            chgSLane(cboObj);
        }else{
            formObj.f_sim.RemoveAll();
        }
        if(!ComIsContainsCharsOnly(text, chars)){
            //[COM12123] : 는(은) 문자를 입력해야합니다.
            ComShowMessage(ComGetMsg("COM12123","S.Lane"));
            return false;
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
     function setSimNo(Obj){
         var formObj=document.form;
         var sheetObj=sheetObjects[0];
         if (ComGetObjValue(Obj) != "") {
             var param="f_cmd="+SEARCH01;
               param=param + "&f_sim="+ComGetObjValue(Obj);
               param=param + "&f_slan_cd="+ComGetObjValue(formObj.f_slan_cd);
              var sXml=sheetObj.GetSearchData("CommonUtilGS.do", param);
             var arrXml=sXml.split("|$$|");
               if (0<arrXml.length && ComGetEtcData(arrXml[0],"sim_dt") != undefined) {
                  ComSetObjValue(formObj.f_sim_dt,ComGetEtcData(arrXml[0],"sim_dt"));
                  ComSetObjValue(formObj.f_sim_no,ComGetEtcData(arrXml[0],"sim_no"));
                  ComSetObjValue(formObj.f_sim_rmk,ComGetEtcData(arrXml[0],"sim_rmk"));
                  ComSetObjValue(formObj.f_usr_id,ComGetEtcData(arrXml[0],"sim_usr_id"));
                  ComSetObjValue(formObj.f_dept_cd,ComGetEtcData(arrXml[0],"sim_dept_cd"));
                  ComSetObjValue(formObj.f_usr_id,ComGetEtcData(arrXml[0],"sim_usr_id"));
                  ComAddSeparator(formObj.f_sim_dt);
               }
         }
     }
    /**
     * 날짜에 대한 Max Simulation No 를 세팅한다.
     */
    function getMaxSimNo(param) {
        var frmObj=document.form;
        frmObj.f_sim_dt.value=get_NowDate("");
        convert_Date(frmObj.f_sim_dt);
        //ComAddSeparator(frmObj.f_sim_dt);
        frmObj.f_sim_no.value=param;
        frmObj.f_sim_rmk.value="";
        chgSLane(frmObj.f_slan_cd);
    }
    /**
     * 상태표시를 제거한다.
     */
    function closeStatus(){
//        zu_openRunning(false);
    }
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
            if (f_slan_cd.GetSelectCode()== "") {
                ComShowMessage(ComGetMsg("COA10002","S.Lane"));
                f_slan_cd.focus();
                return false;
            }
            if(f_sim_dt.value == "") {
                ComShowMessage(ComGetMsg("COA10002","Simulation Date"));
                f_sim_dt.focus();
                return false;
            }
        }
        return true;
    }
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm2(sheetObj,formObj,sAction){
        var sheetObj1=sheetObjects[0];
        var cnt=sheetObj1.GetCellValue(sheetObj1.GetSelectRow(), "freq_no");
        var sRow=sheetObj.FindStatusRow("I|U|R");
        var arRow=sRow.split(";").length-2;
        var Row=sheetObj.ColValueDup("vsl_cd", false);
        with(formObj){
            if(cnt < arRow){
                // [COA10013] : No of Vessels의 갯수와 일치하지 않습니다
                ComShowMessage(ComGetMsg("COA10013", "No of Vessels"));
                return false;
            }
            if(Row != "-1" && Row != sheetObj.LastRow()){
                // [COM12115] >> Vessel가(이) 중복되었습니다.
                ComShowMessage(ComGetMsg("COM12115", "Vessel"));
                return false;
            }
            if(sheetObj1.GetCellValue(sheetObj1.GetSelectRow(), 1)!="R"){
                // [COA10014] : 마스터을(를) 먼저 저장하세요.
                ComShowMessage(ComGetMsg("COA10014", "Master"));
                return false;
            }
        }
        return true;
    }
    //화면의 Zoom 처리
    function set_Zoom(zoomFlag) {
        if (zoomFlag == "open") {
            div_zoom_in1.style.display="none";
            div_zoom_out1.style.display="inline";
        } else if (zoomFlag == "close") {
            div_zoom_in1.style.display="inline";
            div_zoom_out1.style.display="none";
        }
        parent.syncHeight();
    }
    //New Lane 선택시 Lane Info I/F 버튼 비활성화
    //윤진영 수정 20090805 버튼 id 에 formObj 삭제
    function viewBtn(){
        var formObj=document.form;
        if(formObj.f_ext_flg[1].checked) {
            btn_lane.style.display="none"
            btn_lane_pre.style.display="none"
            btn_lane_end.style.display="none"
            td_bsa.style.display="none"
            td_bsa_pre.style.display="none"
            td_bsa_end.style.display="none"
        } else {
            btn_lane.style.display="block"
            btn_lane_pre.style.display="block"
            btn_lane_end.style.display="block"
                        td_bsa.style.display="block"
            td_bsa_pre.style.display="block"
            td_bsa_end.style.display="block"
        }
        if(formObj.f_ext_flg[0].checked){
            btn_lane.style.display="none"
            btn_lane_pre.style.display="none"
            btn_lane_end.style.display="none"
                        td_bsa.style.display="none"
            td_bsa_pre.style.display="none"
            td_bsa_end.style.display="none"
        }else{
            btn_lane.style.display="block"
            btn_lane_pre.style.display="block"
            btn_lane_end.style.display="block"
                        td_bsa.style.display="block"
            td_bsa_pre.style.display="block"
            td_bsa_end.style.display="block"
        }
    }
    //Continent Pair 팝업 전 Validation check
    function callContiPair(){
        var formObj=document.form;
        var rtnValue=true;
        if (ComGetObjValue(formObj.f_slan_cd) == "") {
            ComShowMessage(ComGetMsg("COA10002","S.Lane"));
            rtnValue=false;
        } else if(ComGetObjValue(formObj.f_sim_dt) == "") {
            ComShowMessage(ComGetMsg("COA10002","Simulation Date"));
            rtnValue=false;
        } else if(ComGetObjValue(formObj.f_sim_no) == "") {
            ComShowMessage(ComGetMsg("COA10002","Simulation No"));
            rtnValue=false;
        }
        if(rtnValue){
          var param="?f_slan_cd="+ComGetObjValue(formObj.f_slan_cd);
          param += "&f_sim_dt="+ComGetObjValue(formObj.f_sim_dt);
          param += "&f_sim_no="+ComGetObjValue(formObj.f_sim_no);
          param += "&f_dept_cd="+ComGetObjValue(formObj.f_dept_cd);
          param += "&f_usr_id="+ComGetObjValue(formObj.f_usr_id);
          ComOpenWindowCenter("/opuscntr/ESM_COA_0150.do" + param,"PopupEsmCoa0150",700,500,false);
        }
    }
    /**
     * TC/O Hire Table Popup을  콜한다.
     */
    function callFmt() {
        var formObj=document.form;
        var param="?f_slan_cd="+ComGetObjValue(formObj.f_slan_cd);
        ComOpenWindow('ESM_COA_0165.do' + param,'Hire_Poupu', 'width=900, height=450,menubar=0,status=0,scrollbars=0,resizable=1');
    }
    /**
     * BSA by VVD Popup을 콜한다.
     */
    function callBSAbyVVD(){
        var formObj=document.form;
        var sheetObj1=sheetObjects[0];
        var sheetObj2=sheetObjects[1];
        var param="";
        var row=sheetObj1.GetSelectRow();
        var vsl="";      // sheet에 있는 모든 Vessel
        var i_vsl="";    // Insert 상태의 Vessel 정보
        var r_vsl="";    // Read 상태의 Vessel정보
        var i_cnt=0;       // Insert 상태의 vessel의 갯수
        /*
         * ibflag = R,D,I
         * 3가지 상태에 대해서 각각 Popup에 조회 되는 데이터가 달라진다.
         * R, D 인 vessel 인경우 popup에 조회되지만 선택할수 없도록함(R,D 만 존재하는 경우 기간에 속한 모든 Vessel이 조회된다.)
         * I만 존재하는 경우 vessel 이 하나라도 존재하면 해당 vessel 만 popup에 조회된다
         * R, D, I 가 모두 존재할 경우 해당 vessel 만 popup에 조회된다.
         */
        for(k=2;k<sheetObj2.LastRow();k++){
            if(ComTrim(sheetObj2.Cellvalue(k,"vsl_cd")) != ""){
                 vsl=vsl +"'"+sheetObj2.Cellvalue(k,"vsl_cd")+"'," ;
            }
            // Insert 상태의 Vessel 정보['AAAA','BBB']
            if(ComTrim(sheetObj2.Cellvalue(k,"vsl_cd")) != "" && sheetObj2.Cellvalue(k,"ibflag") == "I"){
                 i_vsl=i_vsl +"'"+sheetObj2.Cellvalue(k,"vsl_cd")+"'," ;
                 i_cnt++;
            // Read 상태의 Vessel 정보['AAAA','Y','BBB','Y','N'] => 팝업에 해당하는 정보는 disable 시키기 위해서
            } else if(ComTrim(sheetObj2.Cellvalue(k,"vsl_cd")) != "" && sheetObj2.Cellvalue(k,"ibflag") != "I"){
                 r_vsl=r_vsl + ",'" + sheetObj2.Cellvalue(k,"vsl_cd") + "','Y'" ;
            }
        }
        if(vsl != "") vsl=vsl +"''";
        if(i_vsl != "") i_vsl=i_vsl +"''";
        if(r_vsl != "") r_vsl=r_vsl +",'N'";
        param="f_slan_cd="  + ComGetObjValue(formObj.f_slan_cd)
				+"&f_sect_no="   + sheetObj1.GetCellValue(row,"sect_no")
				+"&trd_cd="    + sheetObj1.GetCellValue(row,"trd_cd")
				+"&rlane_cd="  + sheetObj1.GetCellValue(row,"rlane_cd")
				+"&ioc_cd="    + sheetObj1.GetCellValue(row,"ioc_cd")
				+"&skd_dir_cd="+ sheetObj1.GetCellValue(row,"skd_dir_cd")
              +"&vsl="       + vsl
              +"&i_vsl="     + vsl
              +"&r_vsl="     + r_vsl
              +"&i_cnt="     + i_cnt;
        if (sheetObj2.LastRow()>= 2){
            ComOpenWindowCenter("/opuscntr/ESM_COA_0166.do?" + param,"vvd_Poupu",1000,580,false);
        }
    }
    /** Sheet2 Mendatory 항목
     vop_cd 가  자사 일때 : Register, Vessel Class, Port Class, OPR, OPR2, BSA Capa
     vop_cd 가  OTH 일때 : Register, OPR
     */
    function chkMendatory(){
        var sheetObj2=sheetObjects[1];
        var lastrow=sheetObj2.LastRow();
        for(i=2; i<sheetObj2.LastRow(); i++){
             var register=sheetObj2.cellText(i,3);
             if(sheetObj2.cellText(i,"vop_cd")== "" ) {
                ComShowMessage(ComGetMsg("COA10002",register +" OPR2"));
                return false;
             }
             if(sheetObj2.cellText(i,"ldf_rto")== "0" ) {
                ComShowMessage(ComGetMsg("COA10002",register +" L/F(%)"));
                return false;
             }
             if(sheetObj2.GetCellValue(i,"vop_cd")=="vop_cd"){//OPR2 가 자사 일때 추가체크되는 Mendatory 항목
            	 if(sheetObj2.GetCellValue(i,"vsl_clss_capa")== "0" ) {
                    ComShowMessage(ComGetMsg("COA10002",register +" Vessel Class"));
                    return false;
                 }
            	 if(sheetObj2.GetCellValue(i,"port_clss_capa")== "0" ) {
                    ComShowMessage(ComGetMsg("COA10002",register +" Port Class"));
                    return false;
                 }
                 if(sheetObj2.cellText(i,"vsl_oshp_cd")== "" ) {
                    ComShowMessage(ComGetMsg("COA10002",register +" OPR"));
                    return false;
                 }
                 if(sheetObj2.GetCellValue(i, "bsa_capa")== "0" ) {
                    ComShowMessage(ComGetMsg("COA10002",register +" BSA Capa"));
                    return false;
                 }
             }
             if(sheetObj2.GetCellValue(lastrow, "hjs_bfr_bsa_capa") == "0" || sheetObj2.GetCellValue(lastrow, "hjs_bfr_bsa_capa") == "") {
                    ComShowMessage(ComGetMsg("COA10044"));
                    return false;
             }
            //BSA 에 값이 있을 때, Slot Cost 항목 Mendatory 처리함.
            if( (sheetObj2.cellText(i,"otr_crr_bsa_capa1") != 0 && sheetObj2.cellText(lastrow,"otr_crr_bsa_capa1")==0) ||
                (sheetObj2.cellText(i,"otr_crr_bsa_capa2") != 0 && sheetObj2.cellText(lastrow,"otr_crr_bsa_capa2")==0) ||
                (sheetObj2.cellText(i,"otr_crr_bsa_capa3") != 0 && sheetObj2.cellText(lastrow,"otr_crr_bsa_capa3")==0) ||
                (sheetObj2.cellText(i,"otr_crr_bsa_capa4") != 0 && sheetObj2.cellText(lastrow,"otr_crr_bsa_capa4")==0) ||
                (sheetObj2.cellText(i,"otr_crr_bsa_capa5") != 0 && sheetObj2.cellText(lastrow,"otr_crr_bsa_capa5")==0) ||
                (sheetObj2.cellText(i,"sub_lse_capa1") != 0 && sheetObj2.cellText(lastrow,"sub_lse_capa1")==0) ||
                (sheetObj2.cellText(i,"sub_lse_capa2") != 0 && sheetObj2.cellText(lastrow,"sub_lse_capa2")==0) ||
                (sheetObj2.cellText(i,"sub_lse_capa3") != 0 && sheetObj2.cellText(lastrow,"sub_lse_capa3")==0) ||
                (sheetObj2.cellText(i,"sub_lse_capa4") != 0 && sheetObj2.cellText(lastrow,"sub_lse_capa4")==0) ||
                (sheetObj2.cellText(i,"sub_lse_capa5") != 0 && sheetObj2.cellText(lastrow,"sub_lse_capa5")==0) ||
                (sheetObj2.cellText(i,"sub_chtr_capa1") != 0 && sheetObj2.cellText(lastrow,"sub_chtr_capa1")==0) ||
                (sheetObj2.cellText(i,"sub_chtr_capa2") != 0 && sheetObj2.cellText(lastrow,"sub_chtr_capa2")==0) ||
                (sheetObj2.cellText(i,"sub_chtr_capa3") != 0 && sheetObj2.cellText(lastrow,"sub_chtr_capa3")==0) ||
                (sheetObj2.cellText(i,"sub_chtr_capa4") != 0 && sheetObj2.cellText(lastrow,"sub_chtr_capa4")==0) ||
                (sheetObj2.cellText(i,"sub_chtr_capa5") != 0 && sheetObj2.cellText(lastrow,"sub_chtr_capa5")==0)
                ) {
                ComShowMessage(ComGetMsg("COA10044"));
                return false;
            }
        }
        return true;
    }
    /**
     * Set Sub Trade 버튼 클릭시 sub trade 자동셋팅한다.
     */
    function setVesselInfo1(){
        var sheetObj=sheetObjects[0];
        var formObj=document.form;
        var i;
        for(i=1; i<= sheetObj.LastRow(); i++){
        	if(sheetObj.GetCellValue(i,"trd_cd").length == 3){
                sheetObj.SelectCell(i,"trd_cd");
                doActionIBSheet(sheetObj,formObj,IBROWSEARCH);
                /* trade code 변경시 S.Lane 과 조합하여 R.Lane을 자동완성 시켜준다. s1sheet1_OnChange() 같이 수정할 것.*/
				s_slan_cd=sheetObj.GetCellValue(sheetObj.GetSelectRow(),"slan_cd");
				s_trd_cd=sheetObj.GetCellValue(sheetObj.GetSelectRow(),"trd_cd");
				sheetObj.GetCellValue2(sheetObj.SetSelectRow,"rlane_cd")(s_slan_cd + s_trd_cd.substring(0,2));
            }
        }
    }
     /**
     * Vessel Code를 전반적으로 다시 세팅한다.
     */
    function setVesselInfo2(){
        var sheetObj1=sheetObjects[1];
        var formObj=document.form;
        var i;
        for(i=1; i<= sheetObj1.LastRow(); i++){
        	if(sheetObj1.GetCellValue(i,"vsl_cd").length == 4 && sheetObj1.GetCellValue(i,"vsl_cd") != 'XXXX'){
                sheetObj1.SelectCell(i,"vsl_cd");
                formObj
                doActionIBSheet2(sheetObj1,formObj,IBROWSEARCH);
            }
        }
    }
    /**
     * T/S Volume 화면 오픈
     */
    function callTSVolume(){
        var formObj=document.form;
        var param="f_sim_dt="  +ComGetObjValue(formObj.f_sim_dt) + "&f_sim_no=" +ComGetObjValue(formObj.f_sim_no);
        ComOpenWindowCenter("ESM_COA_0169.do?"+param, "TS_Volume",400,430,false);
    }
        /**
         * slan_cd,sim_no 콤보박스 변경시 sheet 초기화
         */
    function setSheetNew() {
      if(document.form.f_cmd.value=='') {
      //if(formObj.f_cmd.value != "MULTI01" && )
    if(sheetObjects[0].RowCount()> 0) sheetObjects[0].RemoveAll();
          if(sheetObjects[1].RowCount()> 0) sheetObjects[1].RemoveAll();
      }
    }
    /**
     * Non Operating Expense 화면 오픈
     */
    function callNonOpExpn(){
        var formObj=document.form;
        var param="f_sim_dt="  +ComGetObjValue(formObj.f_sim_dt) + "&f_sim_no=" +ComGetObjValue(formObj.f_sim_no);
        ComOpenWindowCenter("ESM_COA_0164.do?"+param, "Non_Op_Expn",400,480,false);
    }
