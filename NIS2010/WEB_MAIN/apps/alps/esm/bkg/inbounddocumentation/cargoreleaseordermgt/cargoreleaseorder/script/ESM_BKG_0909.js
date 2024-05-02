/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0909.js
*@FileTitle : Cargo Release Order_E-D/O inquiry _Main
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 곽영범
*@LastVersion : 1.0
* 2009.09.21 곽영범
* 1.0 Creation
===========================================================*/

function esm_bkg_0909() {
    this.processButtonClick     = tprocessButtonClick;
    this.setSheetObject         = setSheetObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;
    this.initControl            = initControl;
    this.doActionIBSheet        = doActionIBSheet;
    this.setTabObject           = setTabObject;
    this.validateForm           = validateForm;
}

//공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetNames = new Array("master","container","bkg_do_ref","bkg_cgo_rlse","otsRcvInfo","test_foc","sheet_bl_status");
var sheetCnt = 0;

var comboObjects = new Array();
var combo1 = null;
var comboCnt = 0;

var btnMode = "";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    var sheetObject1 = sheetObjects[sheetNames[0]];
    var sheetObject2 = sheetObjects[sheetNames[1]];
    var sheetObject3 = sheetObjects[sheetNames[2]];
    var sheetObject4 = sheetObjects[sheetNames[3]];

    /*******************************************************/
    var formObject = document.form;

    //try {
    var srcName = window.event.srcElement.getAttribute("name");

    switch(srcName) {
        case "btn_Retrieve":

            doActionIBSheet(sheetObject1, formObject, IBSEARCH);
            break;
        case "btn_start_date":
            var cal = new ComCalendar();
            cal.select(formObject.start_date, 'yyyy-MM-dd');
            break;
        case "btn_end_date":
            var cal = new ComCalendarFromTo();
            cal.select(formObject.start_date, formObject.end_date, 'yyyy-MM-dd');
            break;
        case "btn_Transmit":
            //btnMode = "SAVE";
            //fncBtnTransmit();
            break;

        case "btn_Save":
            btnMode = "SAVE";
            fncBtnSave();
            break;
        case "btn_Hold":
            btnMode = "HOLD";
            fncBtnHold();
            break;
        case "btn_History":
            //doActionIBSheet(sheetObject1, formObject, IBSEARCH);
            fncBtnHistory();
            break;
        case "btn_Hold_History":
            //doActionIBSheet(sheetObject1, formObject, IBSEARCH);
            fncBtnHoldHistory();
            break;
        case "btn_DownExcel":
            if(sheetObject1.rowcount < 1){//결과가 없을경우
                ComShowCodeMessage("BKG00109");
            }else{
                //mySheet.Down2Excel([Mode], [UseOpenFile], [NewSheet], [Merge], [SaveAsName],
                //         [ReportPageUrl], [HideExcelMsg],[WriteTreeLevel], [WorkSheetName],
                //         [FocusFirstSheet],[ColumnSkipList],[RowSkipList],[bProtect],[bFormula],
                //         [IncludeImageType])



                //sheetObject1.Down2Excel(true, false, false, true, "",
                //	                    "", false, false, "",
                //	                    true);//열린 탭에 따라 엑셀다운로드

                sheetObject1.SpeedDown2Excel(-1, false,false, "", "");


            }
            break;
            
            
        case "btn_CFlag":
        	doActionIBSheet(sheetObject1, formObject, IBSEARCH_ASYNC02);
        	break;
        	
        	
        	
//        case "btn_Print":
//            formObject.f_cmd.value = MULTI11;
//            //var addParam = "&cust_cnt_cd="+formObj.cust_cnt_cd_ib.value+"&cust_seq="+formObj.cust_seq_ib.value;
//            //alert(addParam);
//            //formObj.page_no.value = PageNo;
//
//            sheetObjects["master"].DoSearch("ESM_BKG_0946GS.do"
//                ,FormQueryString(formObject)
//                );
//
//            //doActionIBSheet(sheetObject1, formObject, IBSEARCH);
//            break;

        case "btn_tpb":
            //					var sheetObjMaster = sheetObjects["master"];
            //					var formObj = document.form;
            //					var selRow = sheetObjMaster.SelectRow ;
            //                    var bkgNo  = sheetObjMaster.CellValue(selRow, "master_" + "bkg_no");
            //
            //					var condition = "?";
            //                    condition += "s_vndr_cust_div_cd=C";
            //                    condition += "&s_bkg_no_all="+bkgNo;
            //                    condition += "&s_n3pty_src_sub_sys_cd=TRS";
            //                    condition += "&s_n3pty_src_sub_sys_cd_check=TRS";
            //                    condition += "&pgmNo=ESD_TPB_0116";
            //
            //                    ComOpenWindow('/hanjin/ESD_TPB_0116.do'+condition, 'win4', 'width=1024,height=568');
            //					break;

            var sheetObjMaster = sheetObjects["master"];
            var formObj = document.form;
            var selRow = sheetObjMaster.SelectRow ;
            var bkgNo  = sheetObjMaster.CellValue(selRow, "master_" + "bkg_no");
            var frDate = ComGetDateAdd(null, "D", -60);
            var toDate = ComGetNowInfo("ymd", "");
            var otsStsCd = "";

            if (document.form.tpb_status.value == "1") {
                otsStsCd = "P";
            } else {
                otsStsCd = "T";
            }

            var condition = "?";
            condition += "s_state=BKG";
            condition += "&s_ots_sts_cd=" + otsStsCd;
            condition += "&s_bkg_no_all="+bkgNo;
            condition += "&s_bl_no_all="+sheetObjMaster.CellValue(selRow, "master_" + "bl_no");

            //condition += "&s_n3pty_src_sub_sys_cd=TES";
            //condition += "&s_n3pty_src_sub_sys_cd_check=TES";
            //condition += "&s_sdate=" + frDate;
            //condition += "&s_edate=" + toDate;

            condition += "&pgmNo=ESD_TPB_0134";

            //ComOpenWindow('/hanjin/ESD_TPB_0116.do'+condition, 'win4', 'width=1024,height=568');
//            ComOpenWindow('/hanjin/ESD_TPB_0134.do'+condition, 'win4', 'width=1024,height=348');

            ComOpenWindowCenter('/hanjin/ESD_TPB_0134.do'+condition, 'win4', 1024, 340, true);
            break;


        case "btn_erp":
            // => Live : /http://erp.hanjin.com/OA_HTML/OA.jsp?OAFunc=OAHOMEPAGE
            // => Test : /http://ktrp4vpa.hanjin.com:8000/OA_HTML/OA.jsp?OAFunc=OAHOMEPAGE
//            ComOpenWindow('http://ktrp4vpa.hanjin.com:8000/OA_HTML/OA.jsp?OAFunc=OAHOMEPAGE', 'erp', 'width=1024,height=700');

            // CoBkg.js 의 ERP 호출하는 함수 실행
			callInboundErp();

            break;
        case "btn_dmdt":
            var sheetObjMaster = sheetObjects["master"];
            var formObj = document.form;
            var selRow = sheetObjMaster.SelectRow ;
            var bkgNo  = sheetObjMaster.CellValue(selRow, "master_" + "bkg_no");
            var blNo   = sheetObjMaster.CellValue(selRow, "master_" + "bl_no");
            var trfCd  = formObj.demur_type.value;

            var paramVal = "?call_flag=P&bkg_no=" + bkgNo + "&bl_no=" + blNo + "&dmdt_trf_cd=" + trfCd;
            //alert(paramVal);
            //ComOpenWindow('/hanjin/EES_DMT_3002P.do' + paramVal, 'dmdt', 'width=1010,height=670');
			ComOpenWindowCenter('/hanjin/EES_DMT_3002P.do' + paramVal, 'dmdt', 1010, 670, true);

            break;
        case "btn_srnd":

            var sheetObjMaster = sheetObjects["master"];
            var formObj = document.form;
            var selRow = sheetObjMaster.SelectRow ;
            var bkgNo  = sheetObjMaster.CellValue(selRow, "master_" + "bkg_no");

            if(bkgNo == ""){
				ComOpenWait(false);
                return;
            }
            var condition = "?";
            condition += "bkg_no="+bkgNo;
            condition += "&inquery_only=Y";
            condition += "&pgmNo=ESM_BKG_0400";

//            ComPostOpenWindow('/hanjin/ESM_BKG_0400.do'+condition, 'bl_surr_rmk', 'width=900,height=300');
            ComOpenWindowCenter('/hanjin/ESM_BKG_0400.do'+condition, 'bl_surr_rmk', 900, 300, true);
            break;
        case "btn_test_frt":
            //alert(srcName);
            fncTestFrt();
            break;
        case "btn_test_obl":
            //alert(srcName);
            fncTestObl();
            break;
        case "btn_test_cstms":
            //alert(srcName);
            fncTestCstms();
            break;


        case "btn_remark":
        	doActionIBSheet(sheetObject1, formObject, IBSEARCH_ASYNC01);
        	break;
        case "btn_unChecked":
        	doActionIBSheet(sheetObject1, formObject, COMMAND01);
        	break;        	

    } // end switch
//}catch(e) {
//	if( e == "[object Error]") {
//		alert("KYB test 지금은 사용하실 수가 없습니다 ");
//	} else {
//		ComShowMessage(e);
//	}
//}
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
 * 콤보 Object를 배열로 등록
 * @param combo_obj 콤보오브젝트
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}


function initCombo(comboObj) {
	comboObj.MultiSelect = true;
	comboObj.UseCode = false;
	comboObj.LineColor = "#ffffff";
	comboObj.SetColAlign("left|left");
	comboObj.MultiSeparator = ",";
}


/**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.

    function initTab(tabObj , tabNo) {
        with (tabObj) {
            var cnt  = 0 ;
            InsertTab( cnt++ , "Overall" , -1 );
            InsertTab( cnt++ , "Container" , -1 );
            InsertTab( cnt++ , "House B/L" , -1 );
        }
    }
     */


/**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.

    function tab1_OnChange(tabObj , nItem)
    {
        var objs = document.all.item("tabLayer");

    	objs[nItem].style.display = "Inline";
    	objs[beforetab].style.display = "none";

    	beforetab= nItem;
    }

    */

/**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
function setSheetObject(sheet_obj){
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
        if(sheetNames[i] == "master" || sheetNames[i] == "container"){
            ComConfigSheet (sheetObjects[sheetNames[i]]);
        }

        initSheet(sheetObjects[sheetNames[i]] ,i+1);
        //khlee-마지막 환경 설정 함수 추가

        if(sheetNames[i] == "master" || sheetNames[i] == "container"){
            ComEndConfigSheet(sheetObjects[sheetNames[i]] );
        }

    //doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
    }
    combo1 = comboObjects[0];
	comboCnt = comboObjects.length;
	// IBMultiCombo초기화
	for ( var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k]);
	}
    
    
    
    initControl();

    //초기화
    formObj.start_date.value = ComGetNowInfo('ymd','-');
    formObj.start_time.value = "00:00";
    formObj.end_date.value = ComGetNowInfo('ymd','-');
    formObj.end_time.value = "23:59";

    ComBtnDisable("btn_Transmit");
    ComBtnDisable("btn_Save");
    ComBtnDisable("btn_Hold");
    ComBtnDisable("btn_History");
	ComBtnDisable("btn_Hold_History");


}

/**
	 * 화면의 Control의 초기값과 이벤트를 설정한다.
	 */

function initControl() {
    /*
		var formObject = document.form;
		formObject.edo_rqst_dt_s.value = ComGetNowInfo("ymd", "");	//현재일자를 설정
		formObject.edo_rqst_dt_e.value = ComGetNowInfo("ymd", "");	//현재일자를 설정

		axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
		axon_event.addListenerForm  ('beforeactivate',   'obj_activate',    form);
		axon_event.addListenerFormat('keypress',         'obj_keypress',    form); //- 키보드 입력할때
	    */
    axon_event.addListenerForm('click', 'obj_click', form );     //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    axon_event.addListenerForm('keyup', 'obj_keyup', form );     //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    //axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
    axon_event.addListenerForm ('blur', 'obj_deactivate', form);
    axon_event.addListenerForm ('activate', 'obj_activate', form);
}

/**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
function initSheet(sheetObj,sheetNo) {

    var cnt = 0;
    var sheetID = sheetObj.id;

    switch(sheetObj.id) {
        case "master":      //master init
            with (sheetObj) {
                // 높이 설정
                style.height = 182;

                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = false;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 5, 100);

                var HeadTitle = " |No.|B/L|PCS|VVD|POD|DEL|HUB|Last Update|Freight|Freight|O. B/L|O. B/L|Customs Clearance|Customs Clearance|Cargo Release|Cargo Release|Partial|Consignee Name|Remark(s)|do_hld_flg|obl_ttl_knt|bkg_no|por_cd";
                var headCount = ComCountHeadTitle(HeadTitle);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false);

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                var prefix = "master_";

                //데이터속성    [ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0,	cnt++,	dtHiddenStatus,	20, 	daCenter,	false,	prefix + "ibflag");
                InitDataProperty(0,	cnt++,	dtSeq,			30, 	daCenter,	false,	prefix + "seq");
                InitDataProperty(0,	cnt++,	dtData,			100, 	daCenter,	false,	prefix + "bl_no",		false,		"",		dfNone,			0,			false);
                InitDataProperty(0,	cnt++,	dtData,			40, 	daCenter,	false,	prefix + "pcs_qty",		false,		"",		dfNone,			0,			false);

                InitDataProperty(0,	cnt++,	dtData,			90, 	daCenter,	false,	prefix + "vvd_cd",		false,		"",		dfNone,			0,			false);
                InitDataProperty(0,	cnt++,	dtData,			60, 	daCenter,	false,	prefix + "pod_cd",		false,		"",		dfNone,			0,			false);
                InitDataProperty(0,	cnt++,	dtData,			60, 	daCenter,	false,	prefix + "del_cd",		false,		"",		dfNone,			0,			false);
                InitDataProperty(0,	cnt++,	dtData,			60, 	daCenter,	false,	prefix + "hub_cd",		false,		"",		dfNone,			0,			false);
                InitDataProperty(0,	cnt++,	dtData,			100, 	daCenter,	false,	prefix + "last_up_dt",	false,		"",		dfNone,			0,			false);
                InitDataProperty(0,	cnt++,	dtData,			20, 	daCenter,	false,	prefix + "frt_clt_flg",	false,		"",		dfNone,			0,			false);
                InitDataProperty(0,	cnt++,	dtData,			90, 	daCenter,	false,	prefix + "f_last_dt",	false,		"",		dfNone,			0,			false);
                InitDataProperty(0,	cnt++,	dtData,			20, 	daCenter,	false,	prefix + "obl_rdem_flg",		false,		"",		dfNone,			0,			false);
                InitDataProperty(0,	cnt++,	dtData,			90, 	daCenter,	false,	prefix + "o_last_dt",		false,		"",		dfNone,			0,			false);
                InitDataProperty(0,	cnt++,	dtData,			20, 	daCenter,	false,	prefix + "cstms_clr_cd",		false,		"",		dfNone,			0,			true);
                InitDataProperty(0,	cnt++,	dtData,			100, 	daCenter,	false,	prefix + "c_last_dt",		false,		"",		dfNone,			0,			true);
                InitDataProperty(0,	cnt++,	dtData,			20, 	daCenter,	false,	prefix + "tml_snd",		false,		"",		dfNone,			0,			true);
                InitDataProperty(0,	cnt++,	dtData,			90, 	daCenter,	false,	prefix + "tml_last_dt",		false,		"",		dfNone,			0,			true);
                InitDataProperty(0,	cnt++,	dtHidden,			90, 	daCenter,	false,	prefix + "prt_ind",		false,		"",		dfNone,			0,			true);
                InitDataProperty(0,	cnt++,	dtData,			120, 	daLeft,		false,	prefix + "cust_nm",		false,		"",		dfNone,			0,			false);
                InitDataProperty(0,	cnt++,	dtData,			90, 	daCenter,	false,	prefix + "inter_rmk",		false,		"",		dfNone,			0,			true);
                InitDataProperty(0,	cnt++,	dtHidden,			90, 	daCenter,	false,	prefix + "do_hld_flg",		false,		"",		dfNone,			0,			true);
                InitDataProperty(0,	cnt++,	dtHidden,			90, 	daCenter,	false,	prefix + "obl_ttl_knt",		false,		"",		dfNone,			0,			true);

                InitDataProperty(0,	cnt++,	dtHidden,			90, 	daCenter,	false,	prefix + "bkg_no",		false,		"",		dfNone,			0,			true);
                InitDataProperty(0,	cnt++,	dtHidden,			90, 	daCenter,	false,	prefix + "por_cd",		false,		"",		dfNone,			0,			true);

                AutoRowHeight = false;
                WaitImageVisible = false;
                }
            break;


        case "container":      //sheet1 init
            with (sheetObj) {
                // 높이 설정
                style.height = 62;

                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = false;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 5, 100);

                var HeadTitle = " |Seq.|Container No.";
                var headCount = ComCountHeadTitle(HeadTitle);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false);

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                var prefix = "container_";
                //데이터속성    [ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0,	cnt++,	dtHiddenStatus,	20, 	daCenter,	false,	prefix + "ibflag");
                InitDataProperty(0,	cnt++,	dtSeq,			30, 	daCenter,	false,	prefix + "seq");
                InitDataProperty(0,	cnt++,	dtData,			100, 	daCenter,	false,	prefix + "cntr_no",		false,		"",		dfNone,			0,			false);
                CountPosition = 0;

                WaitImageVisible = false;
                }
            break;

        case "bkg_do_ref":      //sheet1 init
            with (sheetObj) {
                // 높이 설정
                style.height = 62;

                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = false;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 5, 100);

                var HeadTitle = " |Seq.|bkg_no|inter_rmk|do_hld_flg|bl_no";
                var headCount = ComCountHeadTitle(HeadTitle);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false);

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                var prefix = "bkg_do_ref_";
                //데이터속성    [ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0,	cnt++,	dtHiddenStatus,	20, 	daCenter,	false,	prefix + "ibflag");
                InitDataProperty(0,	cnt++,	dtSeq,			30, 	daCenter,	false,	prefix + "seq");
                InitDataProperty(0,	cnt++,	dtData,			100, 	daCenter,	false,	prefix + "bkg_no",		false,		"",		dfNone,			0,			false);
                InitDataProperty(0,	cnt++,	dtData,			100, 	daCenter,	false,	prefix + "inter_rmk",		false,		"",		dfNone,			0,			false);
                InitDataProperty(0,	cnt++,	dtData,			100, 	daCenter,	false,	prefix + "do_hld_flg",		false,		"",		dfNone,			0,			false);
                InitDataProperty(0,	cnt++,	dtData,			100, 	daCenter,	false,	prefix + "bl_no",		false,		"",		dfNone,			0,			false);
                CountPosition = 0;
                }
            break;

        case "bkg_cgo_rlse":      //sheet1 init
            with (sheetObj) {
                // 높이 설정
                style.height = 62;

                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = false;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 5, 100);

                var HeadTitle = " |Seq.|bl_no|frt_clt_flg|obl_rdem_flg|cstms_clr_cd|bl_rcv_knt|pod_cd|del_cd";
                var headCount = ComCountHeadTitle(HeadTitle);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false);

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                var prefix = "bkg_cgo_rlse_";
                //데이터속성    [ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0,	cnt++,	dtHiddenStatus,	20, 	daCenter,	false,	prefix + "ibflag");
                InitDataProperty(0,	cnt++,	dtSeq,			30, 	daCenter,	false,	prefix + "seq");
                InitDataProperty(0,	cnt++,	dtData,			100, 	daCenter,	false,	prefix + "bl_no",		false,		"",		dfNone,			0,			false);
                InitDataProperty(0,	cnt++,	dtData,			100, 	daCenter,	false,	prefix + "frt_clt_flg",		false,		"",		dfNone,			0,			false);
                InitDataProperty(0,	cnt++,	dtData,			100, 	daCenter,	false,	prefix + "obl_rdem_flg",		false,		"",		dfNone,			0,			false);
                InitDataProperty(0,	cnt++,	dtData,			100, 	daCenter,	false,	prefix + "cstms_clr_cd",		false,		"",		dfNone,			0,			false);
                InitDataProperty(0,	cnt++,	dtData,			100, 	daCenter,	false,	prefix + "bl_rcv_knt",		false,		"",		dfNone,			0,			false);
				InitDataProperty(0,	cnt++,	dtData,			100, 	daCenter,	false,	prefix + "pod_cd",		false,		"",		dfNone,			0,			false);
				InitDataProperty(0,	cnt++,	dtData,			100, 	daCenter,	false,	prefix + "del_cd",		false,		"",		dfNone,			0,			false);

                CountPosition = 0;
                }
            break;
        case "otsRcvInfo":
            /****************************************************************
                //운임 결재 여부와 Outstanding Amounts 정보 추출
                *****************************************************************/

            with (sheetObj) {
                // 높이 설정
                style.height = 0;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = false;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 3, 100);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false)

                var HeadTitle = " |TOT_OTS_STS_CD|TOT_OTS_CURR_CD1|TOT_OTS_CURR_CD2|TOT_OTS_CURR_CD3|TOT_OTS_CURR_CD4|TOT_OTS_CURR_CD5|TOT_OTS_AMT1|TOT_OTS_AMT2|TOT_OTS_AMT3|TOT_OTS_AMT4|TOT_OTS_AMT5|PPT_STS_CD|PPT_RCV_OFC_CD|PPT_RCV_USR_ID|PPT_RCV_DT|CCT_STS_CD|CCT_RCV_OFC_CD|CCT_RCV_USR_ID|CCT_RCV_DT|CCT_OTS_CURR_CD1|CCT_OTS_CURR_CD2|CCT_OTS_CURR_CD3|CCT_OTS_CURR_CD4|CCT_OTS_CURR_CD5|CCT_OTS_AMT1|CCT_OTS_AMT2|CCT_OTS_AMT3|CCT_OTS_AMT4|CCT_OTS_AMT5|N3PTY_PPT_STS_CD|N3PTY_PPT_RCV_OFC_CD|N3PTY_PPT_RCV_USR_ID|N3PTY_PPT_RCV_DT|N3PTY_CCT_STS_CD|N3PTY_CCT_RCV_OFC_CD|N3PTY_CCT_RCV_USR_ID|N3PTY_CCT_RCV_DT|N3PTY_CCT_OTS_CURR_CD1|N3PTY_CCT_OTS_CURR_CD2|N3PTY_CCT_OTS_CURR_CD3|N3PTY_CCT_OTS_CURR_CD4|N3PTY_CCT_OTS_CURR_CD5|N3PTY_CCT_OTS_AMT1|N3PTY_CCT_OTS_AMT2|N3PTY_CCT_OTS_AMT3|N3PTY_CCT_OTS_AMT4|N3PTY_CCT_OTS_AMT5";

                var headCount = ComCountHeadTitle(HeadTitle);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                //데이터속성    [ROW, COL,    DATATYPE,        WIDTH,  DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD,     CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                var prefix="otsRcvInfo_";
                InitDataProperty(0,   cnt++ ,     dtHiddenStatus,  80,    daCenter,  false,   prefix +"ibflag");
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_sts_cd"         ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_curr_cd1"       ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_curr_cd2"       ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_curr_cd3"       ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_curr_cd4"       ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_curr_cd5"       ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_amt1"           ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_amt2"           ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_amt3"           ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_amt4"           ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_amt5"           ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"ppt_sts_cd"             ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"ppt_rcv_ofc_cd"         ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"ppt_rcv_usr_id"         ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"ppt_rcv_dt"             ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_sts_cd"             ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_rcv_ofc_cd"         ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_rcv_usr_id"         ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_rcv_dt"             ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_curr_cd1"       ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_curr_cd2"       ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_curr_cd3"       ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_curr_cd4"       ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_curr_cd5"       ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_amt1"           ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_amt2"           ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_amt3"           ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_amt4"           ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_amt5"           ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_ppt_sts_cd"       ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_ppt_rcv_ofc_cd"   ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_ppt_rcv_usr_id"   ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_ppt_rcv_dt"       ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_sts_cd"       ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_rcv_ofc_cd"   ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_rcv_usr_id"   ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_rcv_dt"       ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_curr_cd1" ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_curr_cd2" ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_curr_cd3" ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_curr_cd4" ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_curr_cd5" ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_amt1"     ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_amt2"     ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_amt3"     ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_amt4"     ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_amt5"     ,   false,     "",        dfNone,     0,          false,       true);

                CountPosition = 0;
                }
            break;

        case "test_foc":      //master init
            with (sheetObj) {
                // 높이 설정
                style.height = 182;

                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = false;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 5, 100);

                var HeadTitle = " |No|B/L|PCS|VVD|POD|DEL|HUB|Last Update|Freight|Freight|O. B/L|O. B/L|Customs Clearance|Customs Clearance|Cargo Release|Cargo Release|Partial|Consignee Name|Remark(s)|do_hld_flg|obl_ttl_knt|bkg_no";
                var headCount = ComCountHeadTitle(HeadTitle);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false);

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                var prefix = "test_foc_";

                //데이터속성    [ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0,	cnt++,	dtHiddenStatus,	20, 	daCenter,	false,	prefix + "ibflag");
                InitDataProperty(0,	cnt++,	dtSeq,			30, 	daCenter,	false,	prefix + "seq");
                InitDataProperty(0,	cnt++,	dtData,			100, 	daCenter,	false,	prefix + "bl_no",		false,		"",		dfNone,			0,			false);
                InitDataProperty(0,	cnt++,	dtData,			40, 	daCenter,	false,	prefix + "pcs_qty",		false,		"",		dfNone,			0,			false);

                InitDataProperty(0,	cnt++,	dtData,			90, 	daCenter,	false,	prefix + "vvd_cd",		false,		"",		dfNone,			0,			false);
                InitDataProperty(0,	cnt++,	dtData,			60, 	daCenter,	false,	prefix + "pod_cd",		false,		"",		dfNone,			0,			false);
                InitDataProperty(0,	cnt++,	dtData,			60, 	daCenter,	false,	prefix + "del_cd",		false,		"",		dfNone,			0,			false);
                InitDataProperty(0,	cnt++,	dtData,			60, 	daCenter,	false,	prefix + "hub_cd",		false,		"",		dfNone,			0,			false);
                InitDataProperty(0,	cnt++,	dtData,			100, 	daCenter,	false,	prefix + "last_up_dt",	false,		"",		dfNone,			0,			false);
                InitDataProperty(0,	cnt++,	dtData,			20, 	daCenter,	false,	prefix + "frt_clt_flg",	false,		"",		dfNone,			0,			false);
                InitDataProperty(0,	cnt++,	dtData,			90, 	daCenter,	false,	prefix + "f_last_dt",	false,		"",		dfNone,			0,			false);
                InitDataProperty(0,	cnt++,	dtData,			20, 	daCenter,	false,	prefix + "obl_rdem_flg",		false,		"",		dfNone,			0,			false);
                InitDataProperty(0,	cnt++,	dtData,			90, 	daCenter,	false,	prefix + "o_last_dt",		false,		"",		dfNone,			0,			false);
                InitDataProperty(0,	cnt++,	dtData,			20, 	daCenter,	false,	prefix + "cstms_clr_cd",		false,		"",		dfNone,			0,			true);
                InitDataProperty(0,	cnt++,	dtData,			100, 	daCenter,	false,	prefix + "c_last_dt",		false,		"",		dfNone,			0,			true);
                InitDataProperty(0,	cnt++,	dtData,			20, 	daCenter,	false,	prefix + "tml_snd",		false,		"",		dfNone,			0,			true);
                InitDataProperty(0,	cnt++,	dtData,			90, 	daCenter,	false,	prefix + "tml_last_dt",		false,		"",		dfNone,			0,			true);
                InitDataProperty(0,	cnt++,	dtData,			90, 	daCenter,	false,	prefix + "prt_ind",		false,		"",		dfNone,			0,			true);
                InitDataProperty(0,	cnt++,	dtData,			120, 	daLeft,		false,	prefix + "cust_nm",		false,		"",		dfNone,			0,			false);
                InitDataProperty(0,	cnt++,	dtData,			90, 	daCenter,	false,	prefix + "inter_rmk",		false,		"",		dfNone,			0,			true);
                InitDataProperty(0,	cnt++,	dtHidden,			90, 	daCenter,	false,	prefix + "do_hld_flg",		false,		"",		dfNone,			0,			true);
                InitDataProperty(0,	cnt++,	dtHidden,			90, 	daCenter,	false,	prefix + "obl_ttl_knt",		false,		"",		dfNone,			0,			true);

                InitDataProperty(0,	cnt++,	dtHidden,			90, 	daCenter,	false,	prefix + "bkg_no",		false,		"",		dfNone,			0,			true);

                AutoRowHeight = false;
                }
            break;

        case "sheet_bl_status":      //bl_status
            with (sheetObj) {
                // 높이 설정
                style.height = 100;

                //전체 너비 설정
                SheetWidth = mainTable_sheet_bl_status.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = false;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 5, 100);

                var HeadTitle = " |No|bl_status|bl_cpy_knt";
                HeadTitle +="|bl_rlse|bl_rlse_ofc_cd|bl_rlse_usr_id|bl_rlse_dt";
                HeadTitle +="|obl_rdem_knt|obl_rdem_ofc_cd|obl_rdem_usr_id|obl_rdem_dt";
                HeadTitle +="|bl_ibd|bl_ibd_ofc_cd|bl_ibd_usr_id|bl_ibd_dt";
                HeadTitle +="|bl_otr_doc_rcv_cd|otr_doc_rcv_ofc_cd|otr_doc_rcv_usr_id|otr_doc_rcv_dt";
                HeadTitle +="|cnt_cd|del_cd|obl_iss_rmk";


                var headCount = ComCountHeadTitle(HeadTitle);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(24, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false);

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                var prefix = "sheet_bl_status_";

                //데이터속성    [ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0,	cnt++,	dtHiddenStatus,	20, 	daCenter,	false,	prefix + "ibflag");
                InitDataProperty(0,	cnt++,	dtSeq,			30, 	daCenter,	false,	prefix + "seq");
                InitDataProperty(0,	cnt++,	dtData,			30, 	daCenter,	false,	prefix + "bl_status",		false,		"",		dfNone,			0,			false);
                InitDataProperty(0,	cnt++,	dtData,			40, 	daCenter,	false,	prefix + "bl_cpy_knt",		false,		"",		dfNone,			0,			false);

                InitDataProperty(0,	cnt++,	dtData,			90, 	daCenter,	false,	prefix + "bl_rlse",		false,		"",		dfNone,			0,			false);
                InitDataProperty(0,	cnt++,	dtData,			60, 	daCenter,	false,	prefix + "bl_rlse_ofc_cd",		false,		"",		dfNone,			0,			false);
                InitDataProperty(0,	cnt++,	dtData,			60, 	daCenter,	false,	prefix + "bl_rlse_usr_id",		false,		"",		dfNone,			0,			false);
                InitDataProperty(0,	cnt++,	dtData,			60, 	daCenter,	false,	prefix + "bl_rlse_dt",		false,		"",		dfNone,			0,			false);

                InitDataProperty(0,	cnt++,	dtData,			30, 	daCenter,	false,	prefix + "obl_rdem_knt",	false,		"",		dfNone,			0,			false);
                InitDataProperty(0,	cnt++,	dtData,			20, 	daCenter,	false,	prefix + "obl_rdem_ofc_cd",	false,		"",		dfNone,			0,			false);
                InitDataProperty(0,	cnt++,	dtData,			90, 	daCenter,	false,	prefix + "obl_rdem_usr_id",	false,		"",		dfNone,			0,			false);
                InitDataProperty(0,	cnt++,	dtData,			20, 	daCenter,	false,	prefix + "obl_rdem_dt",		false,		"",		dfNone,			0,			false);

                InitDataProperty(0,	cnt++,	dtData,			90, 	daCenter,	false,	prefix + "bl_ibd",		false,		"",		dfNone,			0,			false);
                InitDataProperty(0,	cnt++,	dtData,			20, 	daCenter,	false,	prefix + "bl_ibd_ofc_cd",		false,		"",		dfNone,			0,			true);
                InitDataProperty(0,	cnt++,	dtData,			30, 	daCenter,	false,	prefix + "bl_ibd_usr_id",		false,		"",		dfNone,			0,			true);
                InitDataProperty(0,	cnt++,	dtData,			20, 	daCenter,	false,	prefix + "bl_ibd_dt",		false,		"",		dfNone,			0,			true);

                InitDataProperty(0,	cnt++,	dtData,			90, 	daCenter,	false,	prefix + "bl_otr_doc_rcv_cd",		false,		"",		dfNone,			0,			true);
                InitDataProperty(0,	cnt++,	dtData,			90, 	daCenter,	false,	prefix + "otr_doc_rcv_ofc_cd",		false,		"",		dfNone,			0,			true);
                InitDataProperty(0,	cnt++,	dtData,			30, 	daLeft,		false,	prefix + "otr_doc_rcv_usr_id",		false,		"",		dfNone,			0,			false);
                InitDataProperty(0,	cnt++,	dtData,			90, 	daCenter,	false,	prefix + "otr_doc_rcv_dt",		false,		"",		dfNone,			0,			true);

                InitDataProperty(0,	cnt++,	dtData,			90, 	daCenter,	false,	prefix + "cnt_cd",		false,		"",		dfNone,			0,			true);
                InitDataProperty(0,	cnt++,	dtData,			90, 	daCenter,	false,	prefix + "del_cd",		false,		"",		dfNone,			0,			true);
                InitDataProperty(0,	cnt++,	dtData,			90, 	daCenter,	false,	prefix + "obl_iss_rmk",		false,		"",		dfNone,			0,			true);

                AutoRowHeight = false;
                }
            break;

    }
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
    //sheetObj.ShowDebugMsg = false;

    var formObj = document.form;
    switch(sAction) {

        case IBSEARCH:      //조회
        	       
            if(!validateForm(sheetObj,formObj,sAction)) return;

            var tmpBlNo = formObj.bl_no.value;

            if(!formObj.sch_tp[0].checked){
                formObj.bl_no.value = "";
            }

            ComBtnDisable("btn_Transmit");
            ComBtnDisable("btn_Save");
            ComBtnDisable("btn_Hold");
            ComBtnDisable("btn_History");
			ComBtnDisable("btn_Hold_History");

            formObj.bkg_no.value = "";
            formObj.req_pod_cd.value = "";
            //값들 클리어
            formObj.inter_rmk.value = "";

            sheetObjects["container"].RemoveAll();
            //sheetObjects["bkg_do_ref"].RemoveAll();
            //sheetObjects["bkg_cgo_rlse"].RemoveAll();




            formObj.f_cmd.value = SEARCH;
			ComOpenWait(true);
            if (sheetObj.id=="master"){

                sheetObj.DoSearch("ESM_BKG_0909GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("master_"));
            }
            formObj.bl_no.value = tmpBlNo;
            break;

            
        case IBSEARCH_ASYNC01:

            var sheetObjMaster = sheetObjects["master"];
            var sheetObjRef = sheetObjects["bkg_do_ref"];
            var selRow = sheetObjMaster.SelectRow ;

            sheetObjRef.RemoveAll();

            if (sheetObjMaster.CellValue(selRow,"master_" + "inter_rmk") != formObj.inter_rmk.value){
                Row = sheetObjRef.DataInsert();

                prefix = "bkg_do_ref_";
                sheetObjRef.CellValue(Row,prefix + "bkg_no") = formObj.bkg_no.value;
                sheetObjRef.CellValue(Row,prefix + "inter_rmk") = formObj.inter_rmk.value;
                sheetObjRef.CellValue(Row,prefix + "bl_no") = sheetObjMaster.CellValue(selRow,"master_" + "bl_no");
            } else {
            	ComShowCodeMessage("BKG00917");
            	break;
            }


            ComOpenWait(true);            

            var sParam = "&f_cmd=" + MULTI20;
            var sParamSheet = sheetObjRef.GetSaveString();
            if (sParamSheet != "") {
                sParam += "&" + sParamSheet;
            }

            var sXml = sheetObj.GetSaveXml("ESM_BKG_0909GS.do", sParam);
			sheetObj.LoadSaveXml(sXml);
			
			ComOpenWait(false);

        	break;
        	
        	
        	// C flag/CNTR
        case IBSEARCH_ASYNC02:

        	var sheetObjMaster = sheetObjects["master"];
        	var selRow = sheetObjMaster.SelectRow ;
        	
        	if (sheetObjMaster.RowCount == 0) {
        		ComShowCodeMessage("BKG00395"); 
        		break;
        	}
        	
			var bl_no = sheetObjMaster.CellValue(selRow, "master_" + "bl_no"); 
			
			param="?bl_no="+bl_no+ "&pgmNo=ESM_BKG_0041";

			ComOpenWindowCenter("/hanjin/ESM_BKG_0041.do"+param, "ESM_BKG_0041", 1024, 650, false);
        	
			break;

        	//WEB B/L Printed Checked
        case COMMAND01:

        	var sheetObjMaster = sheetObjects["master"];
        	var selRow = sheetObjMaster.SelectRow ;
        	var bl_no = sheetObjMaster.CellValue(selRow, "master_" + "bl_no");
        	
        	ComOpenWait(true);        	
        	fnOblInterSerNoSave(sheetObj,formObj,formObj.bl_status.value, bl_no, "ESM_BKG_0909");
        	ComOpenWait(false);
        	
			break;
    }

}

/**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
function validateForm(sheetObj,formObj,sAction){
    with(formObj){
        //            if (!isNumber(formObj.iPage)) {
        //                return false;
        //            }
        
        if(formObj.sch_tp[0].checked && formObj.bl_no.value == ""){
        	ComShowCodeMessage("COM130404","B/L No.","B/L No");
        	return false;
        }
     

        //날짜를 2주로 제한
        //날짜를 4주로 제한 2017.07.24 박준훈 과장 요청
        if((ComGetDaysBetween(formObj.start_date.value,formObj.end_date.value) > 27
            || ComGetDaysBetween(formObj.start_date.value,formObj.end_date.value) < 0 )
        ){
            ComShowCodeMessage("BKG40014", "4");
            //ComSetFocus(formObj.vps_eta_dt_end);
            return false;
        }

    }

    return true;
}

/**
 * Dbl Click 시 발생
 */

function master_OnDblClick(sheetObj,Row, Col){
    var formObj = document.form;

    var prefix = "master_";

    formObj.bkg_no.value = sheetObj.CellValue(Row,prefix + "bkg_no");
    formObj.req_pod_cd.value = sheetObj.CellValue(Row,prefix + "pod_cd");
    formObj.curr_bl_no.value = sheetObj.CellValue(Row,prefix + "bl_no");




    fncSearchSheet2();
}


function fncSearchSheet2(){
    var formObj = document.form;
    var sheetObj = sheetObjects["container"];

	ComOpenWait(true);

    //alert(FormQueryString(formObj));
    formObj.f_cmd.value = SEARCH02;
    sheetObj.DoSearch("ESM_BKG_0909GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("container_"));

    return;



}
/**
 * Dbl Click 종료후 발생
 */
function container_OnSearchEnd(sheetObj, ErrMsg){
    var formObj = document.form;
    var Row = sheetObjects["master"].SelectRow ;

    var prefix = "master_";

    formObj.inter_rmk.value = sheetObjects["master"].CellValue(Row, prefix + "inter_rmk");
    formObj.obl_ttl_knt.value = sheetObjects["master"].CellValue(Row, prefix + "obl_ttl_knt");
    var doHldFlg = sheetObjects["master"].CellValue(Row, prefix + "do_hld_flg");

    //formObj.do_hld_flg.style.color = "gray";
    if(doHldFlg == "Y"){
        formObj.do_hld_flg.value = "HOLD";
        //alert(document.getElementById("btn_Hold").innerText);
        document.getElementById("btn_Hold").innerText = "Hold Removal";
    }else{
        formObj.do_hld_flg.value = "";
        document.getElementById("btn_Hold").innerText = "Hold";
    }

    for(var i=0;i<formObj.info_frt_clt_flg.options.length;i++){
    	if(sheetObjects["master"].CellValue(Row, prefix + "frt_clt_flg")== null ||
    			sheetObjects["master"].CellValue(Row, prefix + "frt_clt_flg") == ""){
            formObj.info_frt_clt_flg.selectedIndex = 1;
            break;
    	}
        if(sheetObjects["master"].CellValue(Row, prefix + "frt_clt_flg")
            == formObj.info_frt_clt_flg.options[i].value){
            formObj.info_frt_clt_flg.selectedIndex = i;
            break;
        }
    }

    for(var i=0;i<formObj.info_obl_rdem_flg.options.length;i++){

        if(sheetObjects["master"].CellValue(Row, prefix + "obl_rdem_flg")
            == formObj.info_obl_rdem_flg.options[i].value){
            formObj.info_obl_rdem_flg.selectedIndex = i;
            break;
        }else{
            formObj.info_obl_rdem_flg.selectedIndex = 1;
        }
    }


    //sheetObjects["master"].CellValue(Row, prefix + "cstms_clr_cd") = "J";
    
    
    	

    for(var i=0;i<formObj.info_cstms_clr_cd.options.length;i++){
        var sheetValue = sheetObjects["master"].CellValue(Row, prefix + "cstms_clr_cd");


        //세관쪽의 Flag일경우 특수처리
//        if(sheetValue == "E" || sheetValue == "T" || sheetValue == "I" || sheetValue == "W"){
//            sheetValue = "Y";
//        }else if(sheetValue == "H"){
//            sheetValue = "N";
//        }

        //2010.04.13 수정시작
        //조회된 값을 그대로 보여주도록 수정.아닐경우만 N으로 하드코딩
        if(sheetValue != "Y"
        	&& sheetValue != "J"
        		
        	&& sheetValue != "D"
        	&& sheetValue != "E"
        	&& sheetValue != "H"
        	&& sheetValue != "I"
        	&& sheetValue != "P"
        	&& sheetValue != "T"        	
        	&& sheetValue != "W"
        	&& sheetValue != "H"
        	&& sheetValue != "V"
            
            ){
        	sheetValue = "N";
        }

      //2010.04.13 수정끝
        var objValue = formObj.info_cstms_clr_cd.options[i].value;
        if( sheetValue == objValue){
            formObj.info_cstms_clr_cd.selectedIndex = i;
            break;
        }
    }
    



    //Erp 정보가져오기

    fncGetErpDem(sheetObj, formObj);


}




/**
	* ERP, DEM DET 정보 가져오기
	*/
function fncGetErpDem(sheetObj,formObj){

    var sheetObjMaster = sheetObjects["master"];
    var selRow = sheetObjects["master"].SelectRow ;
    var prefix = "master_";

    var param = "&f_cmd=" + SEARCH03 +
                "&bkg_no=" + sheetObjMaster.CellValue(selRow, prefix + "bkg_no") +
                "&bl_no=" + sheetObjMaster.CellValue(selRow, prefix + "bl_no") +
                "&req_pod_cd=" + sheetObj.CellValue(selRow, prefix + "pod_cd");
    
    var sXml = sheetObj.GetSearchXml("ESM_BKG_0909GS.do", param);
    
    var arrXml = sXml.split("|$$|");

    //ETC DATA 처리 : LoadSearchXml 순간 OnSearchEnd Event 발생 (ETC Data로 OnSearchEnd Event에서 처리 할 경우 ETC 데이터 설정 부분을 LoadSearchXml 앞에서 처리 해야 함
    //demur Type
    if(undefined != ComGetEtcData(arrXml[0], "demurType")){
        formObj.demur_type.value = ComGetEtcData(arrXml[0], "demurType");
    }
    //TPB
    if(undefined != ComGetEtcData(arrXml[0], "tpbStatus") && ComGetEtcData(arrXml[0], "tpbStatus") != 'null'){
        formObj.tpb_status.value = ComGetEtcData(arrXml[0], "tpbStatus");
        //alert(formObj.tpb_status.value);
        tpbImgSet(formObj.tpb_status.value);
    }

    //ots ERP Count
    for(var k=formObj.tot_ots_amt.options.length;k > -1; k--){
        formObj.tot_ots_amt.remove(k);
    }

	//ERP 데이터 입력
    for(var x=0;x < ComGetEtcData(arrXml[0], "otsCnt");x++){
        var oOption = document.createElement("OPTION");
        formObj.tot_ots_amt.options.add(oOption);

        oOption.innerText = ComGetEtcData(arrXml[0], "ots"+x);

		//tot_ots_amt 의 값이 0 이면 검은색, 아니면 붉은색
        var _otsValue = parseFloat(ComGetEtcData(arrXml[0], "ots"+x));
		if(_otsValue == 0 ){//있다(검은색)
			document.getElementById("tot_ots_amt").className="input2";
		}else{
			document.getElementById("tot_ots_amt").className="input2_1";
		}
    }


    //demAMT Clear
    for(var k=formObj.tot_bil_amt.options.length;k > -1; k--){
        formObj.tot_bil_amt.remove(k);
    }


    var oTotBilAmt = document.createElement("OPTION");
    formObj.tot_bil_amt.options.add(oTotBilAmt);

    if(undefined != ComGetEtcData(arrXml[0], "demAMT") && ComGetEtcData(arrXml[0], "demAMT") != 'null'){
        oTotBilAmt.innerText = ComGetEtcData(arrXml[0], "demAMT");
		//demAMT 의 값이 0 이면 검은색, 아니면 붉은색
        var _demAmtValue = ComGetEtcData(arrXml[0], "demAMT");
		if( _demAmtValue == "USD 0.0"){//있다(검은색)
			document.getElementById("tot_bil_amt").className="input2";
			document.getElementById("dem_status").style.color='blue';
			document.getElementById("dem_status").className="input2";
		}else{
			document.getElementById("tot_bil_amt").className="input2_1";
			document.getElementById("dem_status").style.color='red';
			document.getElementById("dem_status").className="input2_1";
		}
    //alert(formObj.tpb_status.value);
    //tpbImgSet(formObj.tpb_status.value);
    }

    //dem status
    if(undefined != ComGetEtcData(arrXml[0], "demStatus") && ComGetEtcData(arrXml[0], "demStatus") != 'null'){
        formObj.dem_status.value = ComGetEtcData(arrXml[0], "demStatus");
    //alert(formObj.tpb_status.value);
    //tpbImgSet(formObj.tpb_status.value);
    }

    //Original Bill of Lading Status 정보 가져오기
    fncGetBLStatus();
    
	//WEB B/L Printed : Serial Number
    //fnOblInterSerNoCheck(sheetObj,formObj,formObj.bl_status.value, formObj.bkg_no.value);    
    fnOblInterSerNo(sheetObj, formObj, formObj.bl_status.value, formObj.bkg_no.value);

}

/**
	* Original Bill of Lading Status 정보 가져오기
	*/
function fncGetBLStatus(){

    var formObj = document.form;
    var sheetObj = sheetObjects["sheet_bl_status"];

	//alert("bkg_no " + formObj.bkg_no.value);
	//alert("bl_no " + formObj.curr_bl_no.value);

    //alert(FormQueryString(formObj));
    formObj.f_cmd.value = SEARCH04;
    //sheetObj.DoSearch("ESM_BKG_0909GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet_bl_status_"));
    var sXml = sheetObj.GetSearchXml("ESM_BKG_0909GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet_bl_status_"));

    formObj.prt_ind.value = ComGetEtcData(sXml, "prt_ind");
    sheetObj.LoadSearchXml(sXml);
}


/**
	* Original Bill of Lading Status 정보 Form 설정
	*/
function sheet_bl_status_OnSearchEnd(sheetObj, ErrMsg){

    var formObj = document.form;
    var sheetObj = sheetObjects["sheet_bl_status"];

    //2010-01-21
    //prt_ind 값을 ETC data 에서 꺼내옴.



    var colName = new Array("bl_cpy_knt"
        ,"bl_status","bl_rlse_ofc_cd","bl_rlse_usr_id","bl_rlse_dt"
        ,"obl_rdem_knt","obl_rdem_ofc_cd","obl_rdem_usr_id","obl_rdem_dt"
        ,"bl_otr_doc_rcv_cd","otr_doc_rcv_ofc_cd","otr_doc_rcv_usr_id","otr_doc_rcv_dt"
        ,"bl_ibd","bl_ibd_ofc_cd","bl_ibd_usr_id","bl_ibd_dt"
        ,"obl_iss_rmk"
        );

    for(var i=0;i<colName.length;i++){
        //alert(colName[i]);
        //alert(formObj.bl_otr.options.length);

        if(colName[i] == "bl_otr_doc_rcv_cd"){
            for(var j=0;j<formObj.bl_otr_doc_rcv_cd.options.length;j++){
                //sheetObj.CellValue(1, "sheet_bl_status_" + colName[i])="LG";
                if(sheetObj.CellValue(1, "sheet_bl_status_" + colName[i])
                    == formObj.bl_otr_doc_rcv_cd.options[j].value){
                    formObj.bl_otr_doc_rcv_cd.selectedIndex = j;
                    break;
                }
            }

        }else{
            document.getElementsByName(colName[i])[0].value = sheetObj.CellValue(1,"sheet_bl_status_" + colName[i]);
        }
    }

    if (sheetObj.CellValue(1, "sheet_bl_status_" + "bl_status") == "S")
    {
        document.getElementById("btn_srnd").style.visibility = "visible";
    }
    else{
        document.getElementById("btn_srnd").style.visibility = "hidden";
    }

    //alert(document.getElementsByName("bl_ibd")[0].value);
    //alert(formObj.bl_ibd.value);
    
    ComOpenWait(false);
    
    //2010.04.22
    //Customs Clearance 의 값이 없을경우 사용하지 않음.
    var Row = sheetObjects["master"].SelectRow ;
    var prefix = "master_";
    //alert(sheetObjects["master"].CellValue(Row, prefix + "cstms_clr_cd"));
    if(sheetObjects["master"].CellValue(Row, prefix + "cstms_clr_cd") == "X"){
    	document.getElementById("info_cstms_clr_cd").disabled = true;    	
    }else{
    	document.getElementById("info_cstms_clr_cd").disabled = false;
    }
    

    //버튼처리

    ComBtnEnable("btn_Transmit");
    ComBtnEnable("btn_Save");
    ComBtnEnable("btn_Hold");
    ComBtnEnable("btn_History");
	ComBtnEnable("btn_Hold_History");
	
	
	
}



/****************************************************
* 저장 버튼 클릭시
* //test bl_no ; TAOA14018502
***************************************************/
function fncBtnSave(){
    var formObj = document.form;

    var sheetObjMaster = sheetObjects["master"];
    var sheetObjCgoRlse = sheetObjects["bkg_cgo_rlse"];
    var sheetObjOblByCgo = sheetObjects["sheet_bl_status"];

    var Row;
    var selRow;
    var prefix;

    selRow = sheetObjMaster.SelectRow ;
    
    var del_cd = sheetObjMaster.CellValue(selRow,"master_" + "del_cd");
    if(del_cd.indexOf("CA") == 0 ){
    	ComShowCodeMessage("BKG08321","Canada","CA");//O/BL receipt update is not allowed for canada destination cargo. please use CA cargo release to update it.
    	return;
    }

    //HOLD 이면 중지
    var holdValue = sheetObjMaster.CellValue(selRow,"master_" + "do_hld_flg");
    if(holdValue == "Y"){
        //alert("B/L was Held");
        ComShowCodeMessage("BKG00649");
		ComOpenWait(false);
        return;
    }
   
    if (formObj.info_obl_rdem_flg.value == "Y"
        && formObj.bl_status.value == "B" ) {

        if((formObj.obl_rdem_knt.value == "" || formObj.obl_rdem_knt.value == "0") &&	
            (formObj.bl_ibd.value       == "" || formObj.bl_ibd.value       == "0") &&
            formObj.bl_otr_doc_rcv_cd.value == "" ){

            ComShowCodeMessage("BKG40118");
			ComOpenWait(false);
            return;

        }   
    }

	//WEB B/L Printed : B/L Receive 변경했을경우
/*    if ( sheetObjMaster.CellValue(selRow,"master_" + "obl_rdem_flg") == "N" && formObj.info_obl_rdem_flg.value == "Y") {
    	//체크 ID 가 없을 경우 메세지 출력
        if ( formObj.bl_status.value == "B" && document.getElementById("obl_inter_ser_no").innerHTML != "" && formObj.obl_inter_ser_no_chk_usr_id.value == "") {
    		ComShowCodeMessage("BKG95098");
            return;
    	}
    }  */  
    
	var comboCount = comboObjects[0].GetCount();
    if(formObj.bl_status.value == "B" && comboCount>0 && formObj.bl_otr_doc_rcv_cd.value == ""){
    	//Serial No 생성 불가한 17곳의 POR_CD에서는 Validation 대상에서 제외
    	if(!porCodeCheck(sheetObjMaster, formObj.blInfo_por_cd.value)){
	    	if(!oBlInterSerNoChecked(sheetObjMaster, formObj.bl_no.value)){
	    		ComShowCodeMessage("BKG95126");
	            return;
	    	}
    	}
    }

    //숫자가 넘치지 않도록.
    var t_obl_rdem_knt = formObj.obl_rdem_knt.value;
    var t_bl_ibd = formObj.bl_ibd.value;
    var t_bl_cpy_knt = formObj.bl_cpy_knt.value;

    if(t_obl_rdem_knt == ""){
        t_obl_rdem_knt = 0;
    }

    if(t_bl_ibd == ""){
        t_bl_ibd = 0;
    }

    if(t_bl_cpy_knt == ""){
        t_bl_cpy_knt = 0;
    }

    t_obl_rdem_knt = parseInt(t_obl_rdem_knt);
    t_bl_ibd = parseInt(t_bl_ibd);
    t_bl_cpy_knt = parseInt(t_bl_cpy_knt);



    if(
        (parseInt(t_obl_rdem_knt) + parseInt(t_bl_ibd)) > parseInt(t_bl_cpy_knt)){
        //The number of B/L Received you inputted is bigger than B/Ls released in B/L Issue Screen.
        ComShowCodeMessage('BKG40065');
		ComOpenWait(false);
        return;
    }


    /**************************
		* 2. BKG_CGO_RLSE UPDATE.
		***************************/
    sheetObjCgoRlse.RemoveAll();

    if(    (sheetObjMaster.CellValue(selRow,"master_" + "frt_clt_flg") != formObj.info_frt_clt_flg.value)
        || (sheetObjMaster.CellValue(selRow,"master_" + "obl_rdem_flg") != formObj.info_obl_rdem_flg.value)
        || (
        		(sheetObjMaster.CellValue(selRow,"master_" + "cstms_clr_cd") != formObj.info_cstms_clr_cd.value)
        		&&(sheetObjMaster.CellValue(selRow,"master_" + "cstms_clr_cd") != "X")
        		)
         
        || (sheetObjOblByCgo.CellValue(1,"sheet_bl_status_" + "bl_ibd") != formObj.bl_ibd.value)
        ){
        Row = sheetObjCgoRlse.DataInsert();

        prefix = "bkg_cgo_rlse_";
        //alert(formObj.info_frt_clt_flg.value);
        sheetObjCgoRlse.CellValue(Row,prefix + "bl_no") = sheetObjMaster.CellValue(selRow,"master_" + "bl_no");
       
        // Freight 변경 내역이 없을 경우
        if(sheetObjMaster.CellValue(selRow,"master_" + "frt_clt_flg") == formObj.info_frt_clt_flg.value){
        	sheetObjCgoRlse.CellValue(Row,prefix + "frt_clt_flg") = "";
        }else{        
        	sheetObjCgoRlse.CellValue(Row,prefix + "frt_clt_flg") = formObj.info_frt_clt_flg.value;
        }
        
        // O/BL 변경 내역이 없을 경우
        if(sheetObjMaster.CellValue(selRow,"master_" + "obl_rdem_flg") == formObj.info_obl_rdem_flg.value){
        	sheetObjCgoRlse.CellValue(Row,prefix + "obl_rdem_flg") = "";
        }else{        
        	sheetObjCgoRlse.CellValue(Row,prefix + "obl_rdem_flg") = formObj.info_obl_rdem_flg.value;
        }        
        
        if(sheetObjMaster.CellValue(selRow,"master_" + "cstms_clr_cd") == "X"){
        	sheetObjCgoRlse.CellValue(Row,prefix + "cstms_clr_cd") = "X";                	
        }else{
        	// Customs 변경 내역이 없을 경우
        	if(sheetObjMaster.CellValue(selRow,"master_" + "cstms_clr_cd") == formObj.info_cstms_clr_cd.value){
        		sheetObjCgoRlse.CellValue(Row,prefix + "cstms_clr_cd") = "";
        	}else{
        		sheetObjCgoRlse.CellValue(Row,prefix + "cstms_clr_cd") = formObj.info_cstms_clr_cd.value;
        	}
        }
        //alert("formObj.bl_ibd.value " +formObj.bl_ibd.value);

        sheetObjCgoRlse.CellValue(1,prefix + "bl_rcv_knt") = formObj.bl_ibd.value;

		sheetObjCgoRlse.CellValue(1,prefix + "pod_cd") = sheetObjMaster.CellValue(selRow,"master_" + "pod_Cd");
		sheetObjCgoRlse.CellValue(1,prefix + "del_cd") = sheetObjMaster.CellValue(selRow,"master_" + "del_cd");


    }


    /**************************
		* 3. BL_STATUS UPDATE.
		***************************/


    if(sheetObjOblByCgo.CellValue(1,"sheet_bl_status_" + "obl_rdem_knt") != formObj.obl_rdem_knt.value) {
        //alert("obl_rdem_knt");
        sheetObjOblByCgo.CellValue(1,"sheet_bl_status_" + "obl_rdem_knt") = formObj.obl_rdem_knt.value;

    }

    if(sheetObjOblByCgo.CellValue(1,"sheet_bl_status_" + "bl_otr_doc_rcv_cd") != formObj.bl_otr_doc_rcv_cd.value) {
        //alert("bl_otr_doc_rcv_cd");
        sheetObjOblByCgo.CellValue(1,"sheet_bl_status_" + "bl_otr_doc_rcv_cd") = formObj.bl_otr_doc_rcv_cd.value;

    }

    //alert(sheetObjOblByCgo.CellValue(1,"sheet_bl_status_" + "bl_otr_doc_rcv_cd"));


    //변경사항이 없으면 처리하지 않음.
    if(sheetObjCgoRlse.Rows < 2 && !sheetObjOblByCgo.IsDataModified){
        //alert("You didn't change any item.?Nothing to be saved.");
        ComShowCodeMessage("BKG40083");
		ComOpenWait(false);
        return;
    }


    /**************************
		* 99. 실제 처리실행
		***************************/
    //test bl_no ; TAOA14018502
    formObj.f_cmd.value = MULTI01;
    var aryPrefix = null;
    aryPrefix = new Array("bkg_cgo_rlse_", "sheet_bl_status_");    //prefix 문자열 배열

   
    var sParam1 = sheetObjects["bkg_cgo_rlse"].GetSaveString(true);
    var sParam2 = sheetObjects["sheet_bl_status"].GetSaveString(true);

	if(!sheetObjects["sheet_bl_status"].IsDataModified){
		sheetObjects["sheet_bl_status"].RemoveAll();
		sParam3 = "";
	}


    sParam = sParam1 + "&" + sParam2 ;
   
    sheetObjMaster.CellValue(selRow,"master_" + "frt_clt_flg") = formObj.info_frt_clt_flg.value;
    sheetObjMaster.CellValue(selRow,"master_" + "obl_rdem_flg") = formObj.info_obl_rdem_flg.value;    
   
    /*
    if(sheetObjMaster.CellValue(selRow,"master_" + "cstms_clr_cd") == "X"){
    	sheetObjCgoRlse.CellValue(Row,prefix + "cstms_clr_cd") = "X";                	
    }else{
    	sheetObjCgoRlse.CellValue(Row,prefix + "cstms_clr_cd") = formObj.info_cstms_clr_cd.value;
    }
    */

    //두 Sheet 중 값이 있는 Sheet를 이용 Submit
   	if(sheetObjCgoRlse.Rows > 1){

        sheetObjCgoRlse.DoSave("ESM_BKG_0909GS.do"
            ,FormQueryString(formObj) + "&" + sParam + "&" + ComGetPrefixParam(aryPrefix)
            ,-1
            ,false);
    }else if(sheetObjOblByCgo.IsDataModified){

        sheetObjOblByCgo.DoSave("ESM_BKG_0909GS.do"
            ,FormQueryString(formObj) + "&" + sParam + "&" + ComGetPrefixParam(aryPrefix)
            ,-1
            ,false);
    }
//alert(rXml);

}
/****************************************************
* Transmit 버튼 클릭시
* //test bl_no ; TAOA14018502
***************************************************/
//function fncBtnTransmit(){
//
//
//    //모든 버튼들을 비활성화.
//    ComBtnDisable("btn_Transmit");
//    ComBtnDisable("btn_Save");
//    ComBtnDisable("btn_Hold");
//    ComBtnDisable("btn_History");
//	ComBtnDisable("btn_Hold_History");
//
//
//
//    var formObj = document.form;
//
//    var sheetObjMaster = sheetObjects["master"];
//    var sheetObjRef = sheetObjects["bkg_do_ref"];
//    var sheetObjCgoRlse = sheetObjects["bkg_cgo_rlse"];
//
//    selRow = sheetObjMaster.SelectRow ;
//
//    var Row;
//    var selRow;
//    var prefix;
//
//    selRow = sheetObjMaster.SelectRow ;
//
//    //HOLD 이면 중지
//    var holdValue = sheetObjMaster.CellValue(selRow,"master_" + "do_hld_flg");
//    if(holdValue == "Y"){
//        //alert("B/L was Held");
//        ComShowCodeMessage("BKG00649");
//
//        //모든 버튼들을 활성화.
//        ComBtnEnable("btn_Transmit");
//        ComBtnEnable("btn_Save");
//        ComBtnEnable("btn_Hold");
//        ComBtnEnable("btn_History");
//		ComBtnEnable("btn_Hold_History");
//		ComOpenWait(false);
//        return;
//    }
//
//
//    /**************************
//		* 1. BKG_CGO_RLSE UPDATE.
//		***************************/
//    sheetObjCgoRlse.RemoveAll();
//
//
//    if(    (sheetObjMaster.CellValue(selRow,"master_" + "frt_clt_flg") != formObj.info_frt_clt_flg.value)
//        || (sheetObjMaster.CellValue(selRow,"master_" + "obl_rdem_flg") != formObj.info_obl_rdem_flg.value)
//        || (sheetObjMaster.CellValue(selRow,"master_" + "cstms_clr_cd") != formObj.info_cstms_clr_cd.value)
//        ){
//        Row = sheetObjCgoRlse.DataInsert();
//
//        prefix = "bkg_cgo_rlse_";
//        //alert(formObj.info_frt_clt_flg.value);
//        sheetObjCgoRlse.CellValue(Row,prefix + "bl_no") = sheetObjMaster.CellValue(selRow,"master_" + "bl_no");
//        sheetObjCgoRlse.CellValue(Row,prefix + "frt_clt_flg") = formObj.info_frt_clt_flg.value;
//        sheetObjCgoRlse.CellValue(Row,prefix + "obl_rdem_flg") = formObj.info_obl_rdem_flg.value;
//        
//        if(sheetObjCgoRlse.CellValue(Row,prefix + "cstms_clr_cd") != ""){
//        	sheetObjCgoRlse.CellValue(Row,prefix + "cstms_clr_cd") = formObj.info_cstms_clr_cd.value;
//        }
//    }
//
//
//    if(sheetObjCgoRlse.Rows < 2){
//        //alert("You didn't change any item.?Nothing to be saved.");
//        ComShowCodeMessage("BKG40083");
//
//        //모든 버튼들을 활성화.
//        ComBtnEnable("btn_Transmit");
//        ComBtnEnable("btn_Save");
//        ComBtnEnable("btn_Hold");
//        ComBtnEnable("btn_History");
//		ComBtnEnable("btn_Hold_History");
//		ComOpenWait(false);
//        return;
//    }
//
//    //alert("ok 2 ");
//    //return;
//
//    //POD가 'US'가  아니면 처리하지 않는다.
//
//	//POD 가 'CA'인것도 EDI 송신할수 있도록 변경한다.
//
//    if(!(
//		(sheetObjMaster.CellValue(selRow,"master_" + "pod_cd").substring(0,2) == "CA"	&& sheetObjMaster.CellValue(selRow,"master_" + "del_cd").substring(0,2) == "US")
//		 ||
//		(sheetObjMaster.CellValue(selRow,"master_" + "pod_cd").substring(0,2) == "US"	&& sheetObjMaster.CellValue(selRow,"master_" + "del_cd").substring(0,2) == "US")
//
//		))
//    {
//			//
//			//EDI 전송을 하지 않는다.
//			//
//
//
//
//        //alert("EDI Transmit is only available to B/Ls with POD USA. The B/L [Value] is  POD [Value] So, It is not applicable");
//        ComShowCodeMessage("BKG04021",sheetObjMaster.CellValue(selRow,"master_" + "bl_no"),sheetObjMaster.CellValue(selRow,"master_" + "pod_cd"));
//
//        //모든 버튼들을 활성화.
//        ComBtnEnable("btn_Transmit");
//        ComBtnEnable("btn_Save");
//        ComBtnEnable("btn_Hold");
//        ComBtnEnable("btn_History");
//		ComBtnEnable("btn_Hold_History");
//		ComOpenWait(false);
//        return;
//    }
//
//    
//
//    //by sungho
//    //2009.10.28
//    //Partial 값이 'Y'이면 [F,O,C]값이 변경되더라도 'SAVE' 불가.
//    //2010.04.22
//    //Alert 창 띄우기 제거 by sungho
//    //var partialValue = sheetObjMaster.CellValue(selRow,"master_" + "prt_ind");
//
//
//    //if(partialValue == "Y"){
//        //alert("The B/L is Partial One");
//    //    ComShowCodeMessage("BKG40092");
//    //}
//
//
//
//
//    if(!ComShowCodeConfirm("BKG40084")){
//
//        //모든 버튼들을 활성화.
//        ComBtnEnable("btn_Transmit");
//        ComBtnEnable("btn_Save");
//        ComBtnEnable("btn_Hold");
//        ComBtnEnable("btn_History");
//		ComBtnEnable("btn_Hold_History");
//		ComOpenWait(false);
//        return;
//    }
//
//
//
//    /**************************
//		* 99. 실제 처리실행
//		***************************/
//    //test bl_no ; TAOA14018502
//    formObj.f_cmd.value = MULTI02;
//    var aryPrefix = null;
//    aryPrefix = new Array("bkg_do_ref_", "bkg_cgo_rlse_");    //prefix 문자열 배열
//
//
//    var sParam1 = sheetObjects["bkg_do_ref"].GetSaveString(true);
//    var sParam2 = sheetObjects["bkg_cgo_rlse"].GetSaveString(true);
//
//
//    sParam = sParam1 + "&" + sParam2 ;
//
//	ComOpenWait(true);
//    sheetObjCgoRlse.DoSave("ESM_BKG_0909GS.do"
//        ,FormQueryString(formObj) + "&" + sParam + "&" + ComGetPrefixParam(aryPrefix)
//        ,-1
//        ,false);
////alert(rXml);
//
//
//
////if(ComGetEtcData(rXml, "TRANS_RESULT_KEY") == "S"){
////	master_OnDblClick(sheetObjMaster,selRow, 1);//다시 더블클릭을 실행한다.
////	ComShowCodeMessage("BKG00166");
////}
//
//}
/**************************************************
* Hold
***************************************************/
function fncBtnHold(){
    var formObj = document.form;
    var sheetObj = sheetObjects["bkg_do_ref"];
    var sheetObjMaster = sheetObjects["master"];
    selRow = sheetObjMaster.SelectRow ;
       
    var del_cd = sheetObjMaster.CellValue(selRow,"master_" + "del_cd");
    if(del_cd.indexOf("CA") == 0 ){
    	ComShowCodeMessage("BKG08321","Canada","CA");//O/BL receipt update is not allowed for Canada destination cargo. please use CA cargo release to update it.
    	return;
    }
    

    //by sungho
    //2009.10.28
    //Partial 값이 'Y'이면 [F,O,C]값이 변경되더라도 'SAVE' 불가.
    //2010.04.22
    //Alert 창 띄우기 제거 by sungho
    //var partialValue = sheetObjMaster.CellValue(selRow,"master_" + "prt_ind");

    //if(partialValue == "Y"){
        //alert("The B/L is Partial One");
    //    ComShowCodeMessage("BKG40092");
    //}

    sheetObj.RemoveAll();

    var Row = sheetObj.DataInsert();
    var selRow = sheetObjects["master"].SelectRow ;
    var prefix = "bkg_do_ref_";

    //alert(sheetObjects["master"].CellValue(selRow,"master_" + "do_hld_flg"));return;

    sheetObj.CellValue(Row,prefix + "bkg_no") = formObj.bkg_no.value;
    sheetObj.CellValue(Row,prefix + "bl_no") = sheetObjMaster.CellValue(selRow,"master_" + "bl_no");

    if(sheetObjMaster.CellValue(selRow,"master_" + "do_hld_flg") == "Y"){
        sheetObj.CellValue(Row,prefix + "do_hld_flg") = "N";
    }else if(sheetObjMaster.CellValue(selRow,"master_" + "do_hld_flg") == "N"){
        sheetObj.CellValue(Row,prefix + "do_hld_flg") = "Y";
    }else{
        sheetObj.CellValue(Row,prefix + "do_hld_flg") = "N";
    }

    //return;
    formObj.f_cmd.value = MULTI03;

    var aryPrefix = null;
    aryPrefix = new Array("bkg_do_ref_");    //prefix 문자열 배열
    var sParam1 = sheetObjects["bkg_do_ref"].GetSaveString(true);
    sParam = sParam1;

    sheetObj.DoSave("ESM_BKG_0909GS.do"
        ,FormQueryString(formObj) + "&" + sParam + "&" + ComGetPrefixParam(aryPrefix)
        ,-1
        ,false	);

}
/**
  * Form Object가 Deactive될때 발생하는 이벤트를 처리한다.
  * @return
  */
function obj_deactivate(){
    var objName = event.srcElement.name;
    var formObj = document.form;
    switch(objName) {
        case "start_date":
            ComChkObjValid(event.srcElement);
            break;
        case "end_date":
            ComChkObjValid(event.srcElement);
            break;
        case "start_time":
            ComChkObjValid(event.srcElement);
            break;
        case "end_time":
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

        case "start_date":
            formObj.start_date.value = formObj.start_date.value.replace(eval("/-/gi"), "");
            break;
        case "end_date":
            formObj.end_date.value = formObj.end_date.value.replace(eval("/-/gi"), "");
            break;
        case "start_time":
            formObj.start_time.value = formObj.start_time.value.replace(eval("/:/gi"), "");
            break;
        case "end_time":
            formObj.end_time.value = formObj.end_time.value.replace(eval("/:/gi"), "");
            break;

    }
}


function fncBtnHistory(){
    var goUrl = "";
    var param = "";
    var formObj = document.form;


    var sheetObjMaster = sheetObjects["master"];
    selRow = sheetObjMaster.SelectRow ;

    goUrl = "/hanjin/ESM_BKG_0923.do?";


    param += "1=1";
    param += "&bl_no="+sheetObjMaster.CellValue(selRow,"master_" + "bl_no");
    ;
    param += "&pgmNo=ESM_BKG_0923";

    //선택되지 않을경우는 No Action

    //location.href=goUrl + param;
    ComOpenWindowCenter(goUrl + param,"ESM_BKG_0923",800,420,true);
}

function fncBtnHoldHistory(){
	var goUrl = "";
    var param = "";
    var formObj = document.form;


    var sheetObjMaster = sheetObjects["master"];
    selRow = sheetObjMaster.SelectRow;

    goUrl = "/hanjin/ESM_BKG_0711.do?";


    param += "1=1";
    param += "&bl_no="+sheetObjMaster.CellValue(selRow,"master_" + "bl_no");
	param += "&bkg_no="+sheetObjMaster.CellValue(selRow,"master_" + "bkg_no");
    param += "&pgmNo=ESM_BKG_0711";

    //선택되지 않을경우는 No Action

    //location.href=goUrl + param;
    ComOpenWindowCenter(goUrl + param,"ESM_BKG_0711",800,440,true);


}



/************************************************
* 데머리지 가꼬 오기 (안쓰는거얌)!!!!!!
*************************************************/
/*
function fncGetDem(){
    return;



    var formObj = document.form;
    //다중조회

    formObj.f_cmd.value = SEARCH03;

    var aryPrefix = new Array("otsRcvInfo_"); //prefix 문자열 배열
    //alert(FormQueryString(formObj));
    var sXml = sheetObjects["otsRcvInfo"].GetSearchXml("ESM_BKG_0909GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
//alert(sXml);

}*/



//TPB로 부터 받아온 정보로 이미지 구성 및 코드 값 세팅
function tpbImgSet(tpbStatus) {
    if(tpbStatus) null ? document.getElementById("tpb_status").value : tpbStatus;

    if(document.getElementById("tpb_status").value == "1"){
        document.getElementById("tpb_icon").src = "img/btng_icon_green.gif";
        document.getElementById("tpb_cd").value = 'C';
        document.getElementById("btn_tpb").style.visibility = "visible";
    }else if(document.getElementById("tpb_status").value == "0"){
        document.getElementById("tpb_icon").src = "img/btng_icon_r.gif";
        document.getElementById("tpb_cd").value = 'P';
        document.getElementById("btn_tpb").style.visibility = "visible";
    }else{
        document.getElementById("tpb_icon").src = "img/btng_icon_g.gif";
        document.getElementById("tpb_cd").value = '';
        document.getElementById("btn_tpb").style.visibility = "hidden";
    }
}




function bkg_cgo_rlse_OnSaveEnd(sheetObj, ErrMsg){
    var formObj = document.form;
    var sheetObjMaster = sheetObjects["master"];
    var selRow = sheetObjMaster.SelectRow ;

    if (ErrMsg == "Data Saved Successfully!!" || 
    		ErrMsg == "<||> # Info Type : APP(BKG40085)<||> # Info Message : The B/L you selected for Carriers' Release is not applicable to transmit.<||>") {
        //저장시 나온 데이터를 Master sheet 에 수정
        sheetObjMaster.CellValue(selRow,"master_" + "inter_rmk") = formObj.inter_rmk.value;
        sheetObjMaster.CellValue(selRow,"master_" + "frt_clt_flg") = formObj.info_frt_clt_flg.value;
        sheetObjMaster.CellValue(selRow,"master_" + "obl_rdem_flg") = formObj.info_obl_rdem_flg.value;

        if(sheetObjMaster.CellValue(selRow,"master_" + "cstms_clr_cd") == "X"){
        	sheetObj.CellValue(1,"bkg_cgo_rlse_" + "cstms_clr_cd") = "X";                	
        }else{
        	sheetObj.CellValue(1,"bkg_cgo_rlse_" + "cstms_clr_cd") = formObj.info_cstms_clr_cd.value;
        }
        

        master_OnDblClick(sheetObjMaster,selRow, 1);//다시 더블클릭을 실행한다.


    }
	ComOpenWait(false);

    //모든 버튼들을 활성화
    ComBtnEnable("btn_Transmit");
    ComBtnEnable("btn_Save");
    ComBtnEnable("btn_Hold");
    ComBtnEnable("btn_History");
	ComBtnEnable("btn_Hold_History");

}

function bkg_do_ref_OnSaveEnd(sheetObj, ErrMsg){
    //alert("bkg_do_ref_OnSaveEnd");
    var formObj = document.form;
    var sheetObjMaster = sheetObjects["master"];
    var selRow = sheetObjMaster.SelectRow ;

    if (ErrMsg == "Data Saved Successfully!!"  || 
    	ErrMsg == "<||> # Info Type : APP(BKG40085)<||> # Info Message : The B/L you selected for Carriers' Release is not applicable to transmit.<||>") {
        sheetObjMaster.CellValue(selRow,"master_" + "do_hld_flg") = sheetObj.CellValue(1,"bkg_do_ref_" + "do_hld_flg");
        master_OnDblClick(sheetObjMaster,selRow, 1);//다시 더블클릭을 실행한다.
		ComOpenWait(false);
    }

}
/************************************************
Obl Grid 데이터 조회 완료후
************************************************/
function sheet_bl_status_OnSaveEnd(sheetObj, ErrMsg){
    //alert("sheet_bl_status");
    var formObj = document.form;
    var sheetObjMaster = sheetObjects["master"];
    var selRow = sheetObjMaster.SelectRow ;

    if (ErrMsg == "Data Saved Successfully!!" || 
    		ErrMsg == "<||> # Info Type : APP(BKG40085)<||> # Info Message : The B/L you selected for Carriers' Release is not applicable to transmit.<||>") {
        master_OnDblClick(sheetObjMaster,selRow, 1);//다시 더블클릭을 실행한다.
		ComOpenWait(false);
    }
}

/*****************************************************************
* 조회된 bl 을 dbl click
******************************************************************/
function master_OnSearchEnd(sheetObj, ErrMsg){
    var formObj = document.form;


    //alert(sheetObj.CellText(1,"master_"+"bl_no"));
    if(sheetObj.CellText(1,"master_"+"bl_no") != ""){
        master_OnDblClick(sheetObj,1, 5);
        formObj.blInfo_por_cd.value = sheetObj.CellValue(1, "master_por_cd");
    }
    else{
        ComOpenWait(false);
        //combo
        //formObj.info_frt_clt_flg.options[0].selected = true;
        formObj.info_frt_clt_flg.selectedIndex = 0;
        formObj.info_obl_rdem_flg.selectedIndex = 0;
        formObj.info_cstms_clr_cd.selectedIndex = 0;
        //input
        formObj.demur_type.value = "";
        formObj.dem_status.value = "";
        formObj.curr_bl_no.value = "";
        //combo 초기화
        for(var k=formObj.tot_ots_amt.options.length;k > -1; k--){
            formObj.tot_ots_amt.remove(k);
        }
        for(var k=formObj.tot_bil_amt.options.length;k > -1; k--){
            formObj.tot_bil_amt.remove(k);
        }

        //OBL 부분 초기화

        //var sheetObj = sheetObjects["sheet_bl_status"];

        var colName = new Array("bl_cpy_knt"
            ,"bl_status","bl_rlse_ofc_cd","bl_rlse_usr_id","bl_rlse_dt"
            ,"obl_rdem_knt","obl_rdem_ofc_cd","obl_rdem_usr_id","obl_rdem_dt"
            ,"bl_otr_doc_rcv_cd","otr_doc_rcv_ofc_cd","otr_doc_rcv_usr_id","otr_doc_rcv_dt"
            ,"bl_ibd","bl_ibd_ofc_cd","bl_ibd_usr_id","bl_ibd_dt"
            ,"obl_iss_rmk"
            );

        for(var i=0;i<colName.length;i++){
            //alert(colName[i]);
            //alert(formObj.bl_otr.options.length);

            if(colName[i] == "bl_otr_doc_rcv_cd"){
                formObj.bl_otr_doc_rcv_cd.selectedIndex = 0;

            }else{
                document.getElementsByName(colName[i])[0].value = "";
            }
        }


    }
}

/*****************************************************************
* B/L Receive[ComboBox]를 'N'으로 변경할 경우 나머지 값들 초기화.
******************************************************************/
function blStatusInitByObl(){
    var formObj = document.form;

    var sheetObj = sheetObjects["sheet_bl_status"];

    var colName = new Array("bl_cpy_knt"
        ,"bl_status","bl_rlse_ofc_cd","bl_rlse_usr_id","bl_rlse_dt"
        ,"obl_rdem_knt","obl_rdem_ofc_cd","obl_rdem_usr_id","obl_rdem_dt"
        ,"bl_otr_doc_rcv_cd","otr_doc_rcv_ofc_cd","otr_doc_rcv_usr_id","otr_doc_rcv_dt"
        ,"bl_ibd","bl_ibd_ofc_cd","bl_ibd_usr_id","bl_ibd_dt"
        ,"obl_iss_rmk"
        );





    if (formObj.info_obl_rdem_flg.selectedIndex == 1) {

        formObj.obl_rdem_knt.value = "";
        formObj.obl_rdem_ofc_cd.value = "";
        formObj.obl_rdem_usr_id.value = "";
        formObj.obl_rdem_dt.value = "";

        formObj.bl_ibd.value = "";
        formObj.bl_ibd_ofc_cd.value = "";
        formObj.bl_ibd_usr_id.value = "";
        formObj.bl_ibd_dt.value = "";

		/*
        formObj.bl_otr.selectedIndex = 0;
        formObj.bl_otr_ofc_cd.value = "";
        formObj.bl_otr_usr_id.value = "";
        formObj.bl_otr_dt.value = "";
		*/

		formObj.bl_otr_doc_rcv_cd.selectedIndex = 0;
		formObj.otr_doc_rcv_ofc_cd.value = "";
		formObj.otr_doc_rcv_usr_id.value = "";
		formObj.otr_doc_rcv_dt.value = "";

        sheetObj.CellValue(1, "sheet_bl_status_" + "obl_rdem_knt") = "";
        sheetObj.CellValue(1, "sheet_bl_status_" + "obl_rdem_ofc_cd") = "";
        sheetObj.CellValue(1, "sheet_bl_status_" + "obl_rdem_usr_id") = "";
        sheetObj.CellValue(1, "sheet_bl_status_" + "obl_rdem_dt") = "";

        sheetObj.CellValue(1, "sheet_bl_status_" + "bl_ibd") = "";
        sheetObj.CellValue(1, "sheet_bl_status_" + "bl_ibd_ofc_cd") = "";
        sheetObj.CellValue(1, "sheet_bl_status_" + "bl_ibd_usr_id") = "";
        sheetObj.CellValue(1, "sheet_bl_status_" + "bl_ibd_dt") = "";

        sheetObj.CellValue(1, "sheet_bl_status_" + "bl_otr_doc_rcv_cd") = "";
        sheetObj.CellValue(1, "sheet_bl_status_" + "otr_doc_rcv_ofc_cd") = "";
        sheetObj.CellValue(1, "sheet_bl_status_" + "otr_doc_rcv_usr_id") = "";
        sheetObj.CellValue(1, "sheet_bl_status_" + "otr_doc_rcv_dt") = "";

    }
}


/*****************************************************************
*
*****************************************************************/
function fncTestFrt(){
    var formObj = document.form;
    var sheetObj = sheetObjects["test_foc"];

    sheetObj.DataInsert();

    formObj.f_cmd.value = MULTI16;
    sheetObj.DoAllSave("ESM_BKG_0909GS.do"
        ,FormQueryString(formObj)
        ,false);
}

/*****************************************************************
*
*****************************************************************/
function fncTestObl(){
    var formObj = document.form;
    var sheetObj = sheetObjects["test_foc"];

    sheetObj.DataInsert();

    formObj.f_cmd.value = MULTI17;
    sheetObj.DoAllSave("ESM_BKG_0909GS.do"
        ,FormQueryString(formObj)
        ,false);
}

/*****************************************************************
*
*****************************************************************/
function fncTestCstms(){
    var formObj = document.form;
    var sheetObj = sheetObjects["test_foc"];

    sheetObj.DataInsert();

    formObj.f_cmd.value = MULTI18;
    sheetObj.DoAllSave("ESM_BKG_0909GS.do"
        ,FormQueryString(formObj)
        ,false);
}


