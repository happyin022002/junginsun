/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0292.js
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 안진응
*@LastVersion : 1.0
* 2009.06.16 안진응
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
     */

    /**
     * @extends
     * @class esm_bkg_0292_02 : esm_bkg_0292_02 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0292_02() {
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

    // 공통전역변수
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;

    var comboObjects = new Array();
    var comboCnt = 0;

    // sheet를 관리하는 변수값
    var blInfo          = 0;
//    var refInfo         = 1;
    var euDoRlseStsCntr = 1;
    var euDoRlseStsBl   = 2;
//    var blIss           = 4;
//    var otsRcvInfo      = 5;
    var demInfo         = 3;
    var demDtl          = 4;
    var totBlbAmt       = 5;

    var comboFlg = null;
    var cntrQtySum = 0;
    var frt_term_cd = null;

    var previewSheet = 1;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러<br>
     * @param {void}
     * @return void
     * @author An JinEung
     * @version 2009.11.01
     **/
    function processButtonClick(){

        var param = null;
        var sc_no = null;
        var cntr_no = null;

        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            //비활성화되었다면 리턴
            if(!ComIsBtnEnable(srcName)){
                return;
            }

            switch(srcName) {

                case "img_exp_del_dt":
                    var cal = new ComCalendar();
                    cal.select(formObject.exp_del_dt, 'yyyy-MM-dd');
                break;

                case "btn_cct":
					blOutstandingAmountPopOpen(true);
                break;
                case "btn_third_cct":
					blOutstandingAmountPopOpen(false);
                break;

                case "btn_erp":
					// => Live : /http://erp.hanjin.com/OA_HTML/OA.jsp?OAFunc=OAHOMEPAGE
					// => Test : /http://ktrp4vpa.hanjin.com:8000/OA_HTML/OA.jsp?OAFunc=OAHOMEPAGE
//                    ComOpenWindow('http://ktrp4vpa.hanjin.com:8000/OA_HTML/OA.jsp?OAFunc=OAHOMEPAGE', 'win4', 'width=1024,height=700');

					// CoBkg.js 의 ERP 호출하는 함수 실행
					callInboundErp();

                break;

                case "btn_tpb":
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
                    	condition += "&s_bkg_no_all="+sheetObjects[blInfo].CellValue(1, "blInfo_bkg_no");
                    	condition += "&s_bl_no_all="+sheetObjects[blInfo].CellValue(1, "blInfo_bl_no");
                    	condition += "&s_ots_sts_cd=" + otsStsCd;
                    	condition += "&pgmNo=ESD_TPB_0134";

//                    ComOpenWindow('/hanjin/ESD_TPB_0134.do'+condition, 'win4', 'width=1000,height=318');
                    ComOpenWindowCenter('/hanjin/ESD_TPB_0134.do'+condition, 'win4', 1024, 318, true);
                break;

                case "btn_bl_surr_rmk":
                    var condition = "?";
                        condition += "bkg_no="+sheetObjects[blInfo].CellValue(1, "blInfo_bkg_no");
                        condition += "&inquery_only=Y"+ "&pgmNo=ESM_BKG_0400";

//                    ComPostOpenWindow('/hanjin/ESM_BKG_0400.do'+condition, 'win3', 'width=900,height=300');
                    ComOpenWindowCenter('/hanjin/ESM_BKG_0400.do'+condition, 'bl_surr_rmk', 900, 300, true);
                break;

                case "btn_dem_retrieve":
                	doActionIBSheet(sheetObjects[blInfo], formObject,COMMAND05);
                	break;

                case "btn_dmdt":
                	var bkgNo  = sheetObjects[blInfo].CellValue(1, "blInfo_bkg_no");
                    var blNo   = sheetObjects[blInfo].CellValue(1, "blInfo_bl_no");
                    var trfCd  = document.getElementById("demur_type").value

                    var paramVal = "?call_flag=P&bkg_no=" + bkgNo + "&bl_no=" + blNo + "&dmdt_trf_cd=" + trfCd+ "&pgmNo=EES_DMT_3002P";

//                    ComOpenWindow('/hanjin/EES_DMT_3002P.do' + paramVal, 'win4', 'width=1010,height=670');
                    ComOpenWindowCenter('/hanjin/EES_DMT_3002P.do' + paramVal, 'dmdt', 1010, 670, true);
                	break;
               case "btn_save":
					doActionIBSheet(sheetObjects[blInfo], formObject,IBSAVE);
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
     * @param sheet_obj IBSheet Object
     * @return void
     * @author An JinEung
     * @version 2009.11.01
     **/
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * Sheet 기본 설정 및 초기화<br>
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     * @param {void}
     * @return void
     * @author An JinEung
     * @version 2009.11.01
     **/
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){


        	if (sheetObjects[i].id == "euDoRlseStsBl" || sheetObjects[i].id == "euDoRlseStsCntr" || sheetObjects[i].id == "demInfo") {
            	ComConfigSheet (sheetObjects[i] );

                initSheet(sheetObjects[i],i+1);

                ComEndConfigSheet(sheetObjects[i]);
        	} else {
                initSheet(sheetObjects[i],i+1);
        	}
        }

        //이벤트 선언 및 화면 초기화 처리를 한다.
        initControl();

//        document.form.bkg_no.value = "TAOYTS93P05";

        if (document.form.bkg_no.value != "") {
        	fnSearch();
        }
    }

    /**
    * 화면의 이벤트 처리와 버튼의 초기화를 선언한다.<br>
    * @param (void)
    * @return void
    * @author An JinEung
    * @version 2009.11.01
    **/
    function initControl() {
        axon_event.addListenerFormat('keypress',  'obj_keypress',    form); //- 키보드 입력할때
        axon_event.addListenerForm  ('click'   ,  'obj_click',       form);
        axon_event.addListenerForm  ('blur'    ,  'obj_deactivate' , form);
    }

    /**
     * 시트 초기설정값, 헤더 정의<br>
     * @param sheetObj IBSheet Object
     * @param sheetNo  IBSheet의 순서
     * @return void
     * @author An JinEung
     * @version 2009.11.01
     **/
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
        var prefix = "";
        var sheetID = sheetObj.id;

        switch(sheetID) {
            case "blInfo":
                with (sheetObj) {

                    /*********************************************
                    //12.EU D/O Release 기본 정보
                    **********************************************/

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
                    //SortEnable | ColumnMove |AllCheckEnable |UserResize |RowMove |Head3D
                    InitHeadMode(false, false, false, false, false,false)

                    var HeadTitle = " |POR|POL|POD|DEL|DELTerm|DELTerm Desc|ArrivalVessel|ETA|PKG1|PKG2|WGT1|WGT2|MEA1|MEA2|Partial|SOC|Consignee Nm|Consignee Addr|Notify Nm|Notify Addr|Shipper Nm|Shipper Addr|Split_flg|BKG NO|BL NO|BL TP CD|DSCH_LOC|OBL_ISS_RMK" +
				    		        " |INTER_RMK|DO_HLD_FLG|CSTMS_REF_NM|CSTMS_REF_CTNT|CSTMS_ASGN_NM|CSTMS_ASGN_CTNT|CY_OP_CD|INFO_CGO_FLG|SPLIT_FLG" +
				    		        " |BL회수여부|BL발행통수|O/BL ISSUE|OFFICE|DATE|O/BL RECEIVED|OFFICE|DATE|OTHER DOC RECEIVE|OFFICE|DATE|OTR DOC CGOR FLG| | | | | | | | |" +
				    		        " |TOT_OTS_STS_CD|TOT_OTS_CURR_CD1|TOT_OTS_CURR_CD2|TOT_OTS_CURR_CD3|TOT_OTS_CURR_CD4|TOT_OTS_CURR_CD5|TOT_OTS_AMT1|TOT_OTS_AMT2|TOT_OTS_AMT3|TOT_OTS_AMT4|TOT_OTS_AMT5|PPT_STS_CD|PPT_RCV_OFC_CD|PPT_RCV_USR_ID|PPT_RCV_DT|CCT_STS_CD|CCT_RCV_OFC_CD|CCT_RCV_USR_ID|CCT_RCV_DT|CCT_OTS_CURR_CD1|CCT_OTS_CURR_CD2|CCT_OTS_CURR_CD3|CCT_OTS_CURR_CD4|CCT_OTS_CURR_CD5|CCT_OTS_AMT1|CCT_OTS_AMT2|CCT_OTS_AMT3|CCT_OTS_AMT4|CCT_OTS_AMT5|N3PTY_PPT_STS_CD|N3PTY_PPT_RCV_OFC_CD|N3PTY_PPT_RCV_USR_ID|N3PTY_PPT_RCV_DT|N3PTY_CCT_STS_CD|N3PTY_CCT_RCV_OFC_CD|N3PTY_CCT_RCV_USR_ID|N3PTY_CCT_RCV_DT|N3PTY_CCT_OTS_CURR_CD1|N3PTY_CCT_OTS_CURR_CD2|N3PTY_CCT_OTS_CURR_CD3|N3PTY_CCT_OTS_CURR_CD4|N3PTY_CCT_OTS_CURR_CD5|N3PTY_CCT_OTS_AMT1|N3PTY_CCT_OTS_AMT2|N3PTY_CCT_OTS_AMT3|N3PTY_CCT_OTS_AMT4|N3PTY_CCT_OTS_AMT5";

				    var headCount = ComCountHeadTitle(HeadTitle);

				    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				    InitColumnInfo(headCount, 0, 0, true);

				    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				    InitHeadRow(0, HeadTitle, true);

				    var prefix="blInfo_";
				    //데이터속성    [ROW, COL,        DATATYPE,        WIDTH, DATAALIGN, COLMERGE, SAVENAME,                     KEYFIELD,     CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				    InitDataProperty(0,   cnt++ ,     dtHiddenStatus,  70,    daCenter,  false,    prefix +"ibflag");
				    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"por_cd"              ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"pol_cd"              ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,          90,    daCenter,  false,    prefix +"pod_cd"              ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,    prefix +"del_cd"              ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"de_term_cd"          ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"de_term_desc"        ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,          90,    daCenter,  false,    prefix +"arrival_vessel"      ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"vps_eta_dt"          ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"pck_qty"             ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"pck_tp_cd"           ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"act_wgt"             ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"wgt_ut_cd"           ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"meas_qty"            ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"meas_ut_cd"          ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"cntr_prt_flg"        ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"soc_flg"             ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"ccust_nm"            ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"ccust_addr"          ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"ncust_nm"            ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"ncust_addr"          ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"shipper_cust_nm"     ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"shipper_cust_addr"   ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"split_flg"           ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"bkg_no"              ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"bl_no"               ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"bl_tp_cd"            ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"dsch_loc"            ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"obl_iss_rmk"         ,   false,     "",        dfNone,     0,          false,       true);

				    InitDataProperty(0,   cnt++ ,     dtData,         200,    daCenter,  false,    prefix +"inter_rmk"           ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,         100,    daCenter,  false,    prefix +"do_hld_flg"          ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,         200,    daCenter,  false,    prefix +"cstms_ref_nm"        ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,         200,    daRight,   false,    prefix +"cstms_ref_ctnt"      ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,         200,    daCenter,  false,    prefix +"cstms_asgn_nm"       ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,         200,    daCenter,  false,    prefix +"cstms_asgn_ctnt"     ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,         70,     daCenter,  false,    prefix +"cy_op_cd"            ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,         70,     daCenter,  false,    prefix +"info_cgo_flg"        ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,         100,    daCenter,  false,    prefix +"do_split_flg"        ,   false,     "",        dfNone,     0,          false,       true);


				    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"obl_rdem_flg"         ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"obl_cpy_knt"          ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,          90,    daCenter,  false,   prefix +"obl_iss_tp_cd"        ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"obl_iss_ofc_cd"       ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"obl_iss_dt"           ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,          90,    daCenter,  false,   prefix +"obl_rdem_knt"         ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"obl_rdem_ofc_cd"      ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"obl_rdem_dt"          ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"bl_otr_doc_rcv_cd"    ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"otr_doc_rcv_ofc_cd"   ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"otr_doc_rcv_dt"       ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"otr_doc_cgor_flg"     ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"obl_iss_usr_id"       ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"obl_rdem_usr_id"      ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"otr_doc_rcv_usr_id"   ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"del_cnt_cd"           ,   false,     "",        dfNone,     0,          false,       true); // 조회하는 delevery의 국가코드이다. add by mgpark
				    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"ibd_doc_rcv_flg"      ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"ibd_doc_rcv_ofc_cd"   ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"ibd_doc_rcv_usr_id"   ,   false,     "",        dfNone,     0,          false,       true);
				    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"ibd_doc_rcv_dt"       ,   false,     "",        dfNone,     0,          false,       true);


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


//                    var HeadTitle = " |POR|POL|POD|DEL|DELTerm|ArrivalVessel|ETA|PKG1|PKG2|WGT1|WGT2|MEA1|MEA2|Partial|SOC|Consignee Nm|Consignee Addr|Notify Nm|Notify Addr|Shipper Nm|Shipper Addr|Split_flg|BKG NO|BL NO|BL TP CD|DSCH_LOC|OBL_ISS_RMK";
//
//                    var headCount = ComCountHeadTitle(HeadTitle);
//
//                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
//                    InitColumnInfo(headCount, 0, 0, true);
//
//                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
//                    InitHeadRow(0, HeadTitle, true);
//
//                    var prefix="blInfo_";
//                    //데이터속성    [ROW, COL,        DATATYPE,        WIDTH, DATAALIGN, COLMERGE, SAVENAME,                     KEYFIELD,     CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//                    InitDataProperty(0,   cnt++ ,     dtHiddenStatus,  70,    daCenter,  false,    prefix +"ibflag");
//                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"por_cd"              ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"pol_cd"              ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          90,    daCenter,  false,    prefix +"pod_cd"              ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,    prefix +"del_cd"              ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"de_term_cd"          ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          90,    daCenter,  false,    prefix +"arrival_vessel"      ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"vps_eta_dt"           ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"pck_qty"             ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"pck_tp_cd"           ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"act_wgt"             ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"wgt_ut_cd"           ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"meas_qty"            ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"meas_ut_cd"          ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"cntr_prt_flg"        ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"soc_flg"             ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"ccust_nm"            ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"ccust_addr"          ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"ncust_nm"            ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"ncust_addr"          ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"shipper_cust_nm"     ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"shipper_cust_addr"   ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"split_flg"           ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"bkg_no"              ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"bl_no"               ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"bl_tp_cd"            ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"dsch_loc"            ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"obl_iss_rmk"         ,   false,     "",        dfNone,     0,          false,       true);
//
//                    CountPosition = 0;
                }
                break;

//            case "refInfo":
//
//                /****************************************************************
//                //13. EU D/O Release Reference 정보
//                *****************************************************************/
//
//                with (sheetObj) {
//                    // 높이 설정
//                    style.height = 0;
//                    //전체 너비 설정
//                    SheetWidth = mainTable.clientWidth;
//
//                    //Host정보 설정[필수][HostIp, Port, PagePath]
//                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
//
//                    //전체Merge 종류 [선택, Default msNone]
//                    //MergeSheet = msNone;
//                    MergeSheet = msHeaderOnly;
//
//                    //전체Edit 허용 여부 [선택, Default false]
//                    Editable = false;
//
//                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
//                    InitRowInfo( 1, 1, 3, 100);
//
//                    var HeadTitle = " |BKG_NO|INTER_RMK|DO_HLD_FLG|CSTMS_REF_NM|CSTMS_REF_CTNT|CSTMS_ASGN_NM|CSTMS_ASGN_CTNT|CY_OP_CD|INFO_CGO_FLG|SPLIT_FLG";
//
//                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
//                    InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, true);
//
//                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
//                    InitHeadMode(false, false, false, false, false,false)
//
//                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
//                    InitHeadRow(0, HeadTitle, true);
//
//                    var prefix="refInfo_";
//                    //데이터속성    [ROW, COL,    DATATYPE,        WIDTH,  DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD,     CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//                    InitDataProperty(0,   cnt++ , dtHiddenStatus,  30,     daCenter,  false,     prefix +"ibflag");
//                    InitDataProperty(0,   cnt++ , dtData,          200,    daCenter,  false,     prefix +"bkg_no"          , false,   "",    dfNone,      0,     false,       true);
//                    InitDataProperty(0,   cnt++ , dtData,          200,    daCenter,  false,     prefix +"inter_rmk"       , false,   "",    dfNone,      0,     false,       true);
//                    InitDataProperty(0,   cnt++ , dtData,          100,    daCenter,  false,     prefix +"do_hld_flg"      , false,   "",    dfNone,      0,     false,       true);
//                    InitDataProperty(0,   cnt++ , dtData,          200,    daCenter,  false,     prefix +"cstms_ref_nm"    , false,   "",    dfNone,      0,     false,       true);
//                    InitDataProperty(0,   cnt++ , dtData,          200,    daRight,   false,     prefix +"cstms_ref_ctnt"  , false,   "",    dfNone,      0,     false,       true);
//                    InitDataProperty(0,   cnt++ , dtData,          200,    daCenter,  false,     prefix +"cstms_asgn_nm"   , false,   "",    dfNone,      0,     false,       true);
//                    InitDataProperty(0,   cnt++ , dtData,          200,    daCenter,  false,     prefix +"cstms_asgn_ctnt" , false,   "",    dfNone,      0,     false,       true);
//                    InitDataProperty(0,   cnt++ , dtData,          70,     daCenter,  false,     prefix +"cy_op_cd"        , false,   "",    dfNone,      0,     false,       true);
//                    InitDataProperty(0,   cnt++ , dtData,          70,     daCenter,  false,     prefix +"info_cgo_flg"    , false,   "",    dfNone,      0,     false,       true);
//                    InitDataProperty(0,   cnt++ , dtData,          100,    daCenter,  false,     prefix +"do_split_flg"    , false,   "",    dfNone,      0,     false,       true);
//                    CountPosition = 0;
//                }
//            break;

            case "euDoRlseStsBl":

                /****************************************************************
                //17. B/L별 D/O의 STATUS(ASSIGN, RELEASE, ISSUE)별 상세 정보 추출
                *****************************************************************/

                with (sheetObj) {
                    // 높이 설정
                    style.height = 66;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    //SortEnable | ColumnMove |AllCheckEnable |UserResize |RowMove |Head3D
                    InitHeadMode(false, false, false, false, false, false)

                    var HeadTitle = " |Status|Status|D/O No.|Update Time|User ID|User Name|Office|BKG NO |RLSE STS CTNT";

                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,        DATATYPE,        WIDTH, DATAALIGN, COLMERGE, SAVENAME,              KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="euDoRlseStsBl_";
                    InitDataProperty(0,   cnt++ ,     dtHiddenStatus,  0,     daCenter,  false,   prefix +"ibflag");
                    InitDataProperty(0,   cnt++ ,     dtHidden,        150,   daCenter,  false,   prefix +"rlse_sts_cd"   ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          150,   daCenter,  false,   prefix +"rlse_sts_nm"   ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          100,   daCenter,  false,   prefix +"do_no"         ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          150,   daCenter,  false,   prefix +"evnt_dt"       ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          120,   daCenter,  false,   prefix +"evnt_usr_id"   ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          120,   daCenter,  false,   prefix +"upd_usr_nm"    ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          130,   daCenter,  false,   prefix +"evnt_ofc_cd"   ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtHidden,        0,     daCenter,  false,   prefix +"bkg_no"        ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtHidden,        0,     daCenter,  false,   prefix +"rlse_sts_ctnt" ,   false,     "",        dfNone,     0,          false,       true);

                    CountPosition = 0;
                    sheetObj.ScrollBar = 2;
                }
            break;

            case "euDoRlseStsCntr":

                /****************************************************************
                //Container별 D/O의 STATUS(ASSIGN, RELEASE, ISSUE)별 상세 정보 추출
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
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    //SortEnable | ColumnMove |AllCheckEnable |UserResize |RowMove |Head3D
                    InitHeadMode(false, false, false, false, false, false)

                    var HeadTitle = " |CNTR No|Status CD|Status|D/O No.|Update Time|User ID|OFC CD|Bkg No|STS SEQ|SEQ";

                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,        DATATYPE,        WIDTH, DATAALIGN, COLMERGE, SAVENAME,              KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="euDoRlseStsCntr_";
                    InitDataProperty(0,   cnt++ ,     dtHiddenStatus,  0,     daCenter,  false,   prefix +"ibflag");
                    InitDataProperty(0,   cnt++ ,     dtData,          100,   daCenter,  false,   prefix +"cntr_no"       ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtHidden,        150,   daCenter,  false,   prefix +"rlse_sts_cd"   ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"rlse_sts_nm"   ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          100,   daCenter,  false,   prefix +"do_no"         ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          120,   daCenter,  false,   prefix +"evnt_dt"       ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          120,   daCenter,  false,   prefix +"evnt_usr_id"   ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtHidden,        130,   daCenter,  false,   prefix +"evnt_ofc_cd"   ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtHidden,        100,   daCenter,  false,   prefix +"bkg_no"        ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtHidden,        100,   daCenter,  false,   prefix +"rlse_sts_seq"  ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtHidden,        100,   daCenter,  false,   prefix +"rlse_seq"      ,   false,     "",        dfNone,     0,          false,       true);

                    CountPosition = 0;
                    sheetObj.ScrollBar = 2;
                }
            break;


//            case "blIss":
//
//                /***********************************************************************
//                //22. 조회된 시점에 조회된 Original B/L 회수 여부와 발행 통수 및  Detail정보
//                ***********************************************************************/
//
//                with (sheetObj) {
//                    // 높이 설정
//                    //style.height = 110;
//                    style.height = 0;
//                    //전체 너비 설정
//                    SheetWidth = mainTable.clientWidth;
//
//                    //Host정보 설정[필수][HostIp, Port, PagePath]
//                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
//
//                    //전체Merge 종류 [선택, Default msNone]
//                    MergeSheet = msNone;
//
//                    //전체Edit 허용 여부 [선택, Default false]
//                    Editable = false;
//
//                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
//                    InitRowInfo( 1, 1, 3, 100);
//
//                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
//                    InitColumnInfo(18, 0, 0, true);
//
//                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
//                    InitHeadMode(true, true, false, true, false,false)
//
//                    var HeadTitle = " |BL회수여부|BL발행통수|O/BL ISSUE|OFFICE|DATE|O/BL RECEIVED|OFFICE|DATE|OTHER DOC RECEIVE|OFFICE|DATE|OTR DOC CGOR FLG| | | | |";
//
//                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
//                    InitHeadRow(0, HeadTitle, true);
//
//                    var prefix="blIss_";
//                    //데이터속성    [ROW, COL,        DATATYPE,        WIDTH, DATAALIGN, COLMERGE, SAVENAME,           KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//                    InitDataProperty(0,   cnt++ ,     dtHiddenStatus,  70,    daCenter,  false,   prefix +"ibflag");
//                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"obl_rdem_flg"         ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"obl_cpy_knt"          ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          90,    daCenter,  false,   prefix +"obl_iss_tp_cd"        ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"obl_iss_ofc_cd"       ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"obl_iss_dt"           ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          90,    daCenter,  false,   prefix +"obl_rdem_knt"         ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"obl_rdem_ofc_cd"      ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"obl_rdem_dt"          ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"bl_otr_doc_rcv_cd"    ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"otr_doc_rcv_ofc_cd"   ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"otr_doc_rcv_dt"       ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"otr_doc_cgor_flg"     ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"obl_iss_usr_id"       ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"obl_rdem_usr_id"      ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"otr_doc_rcv_usr_id"   ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"bl_tp_cd"             ,   false,     "",        dfNone,     0,          false,       true);  // 조회하는  bl type code이다 add by mgpark
//                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"del_cnt_cd"           ,   false,     "",        dfNone,     0,          false,       true); // 조회하는 delevery의 국가코드이다. add by mgpark
//
//                    CountPosition = 0;
//                }
//            break;
//
//            case "otsRcvInfo":
//                /****************************************************************
//                //11. 운임 결재 여부와 Outstanding Amounts 정보 추출
//                *****************************************************************/
//
//                with (sheetObj) {
//                    // 높이 설정
//                    style.height = 0;
//                    //전체 너비 설정
//                    SheetWidth = mainTable.clientWidth;
//
//                    //Host정보 설정[필수][HostIp, Port, PagePath]
//                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
//
//                    //전체Merge 종류 [선택, Default msNone]
//                    MergeSheet = msNone;
//
//                    //전체Edit 허용 여부 [선택, Default false]
//                    Editable = false;
//
//                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
//                    InitRowInfo( 1, 1, 3, 100);
//
//                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
//                    InitHeadMode(true, true, false, true, false,false)
//
//                    var HeadTitle = " |TOT_OTS_STS_CD|TOT_OTS_CURR_CD1|TOT_OTS_CURR_CD2|TOT_OTS_CURR_CD3|TOT_OTS_CURR_CD4|TOT_OTS_CURR_CD5|TOT_OTS_AMT1|TOT_OTS_AMT2|TOT_OTS_AMT3|TOT_OTS_AMT4|TOT_OTS_AMT5|PPT_STS_CD|PPT_RCV_OFC_CD|PPT_RCV_USR_ID|PPT_RCV_DT|CCT_STS_CD|CCT_RCV_OFC_CD|CCT_RCV_USR_ID|CCT_RCV_DT|CCT_OTS_CURR_CD1|CCT_OTS_CURR_CD2|CCT_OTS_CURR_CD3|CCT_OTS_CURR_CD4|CCT_OTS_CURR_CD5|CCT_OTS_AMT1|CCT_OTS_AMT2|CCT_OTS_AMT3|CCT_OTS_AMT4|CCT_OTS_AMT5|N3PTY_PPT_STS_CD|N3PTY_PPT_RCV_OFC_CD|N3PTY_PPT_RCV_USR_ID|N3PTY_PPT_RCV_DT|N3PTY_CCT_STS_CD|N3PTY_CCT_RCV_OFC_CD|N3PTY_CCT_RCV_USR_ID|N3PTY_CCT_RCV_DT|N3PTY_CCT_OTS_CURR_CD1|N3PTY_CCT_OTS_CURR_CD2|N3PTY_CCT_OTS_CURR_CD3|N3PTY_CCT_OTS_CURR_CD4|N3PTY_CCT_OTS_CURR_CD5|N3PTY_CCT_OTS_AMT1|N3PTY_CCT_OTS_AMT2|N3PTY_CCT_OTS_AMT3|N3PTY_CCT_OTS_AMT4|N3PTY_CCT_OTS_AMT5";
//
//                    var headCount = ComCountHeadTitle(HeadTitle);
//
//                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
//                    InitColumnInfo(headCount, 0, 0, true);
//
//                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
//                    InitHeadRow(0, HeadTitle, true);
//
//                    //데이터속성    [ROW, COL,    DATATYPE,        WIDTH,  DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD,     CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//                    var prefix="otsRcvInfo_";
//                    InitDataProperty(0,   cnt++ ,     dtHiddenStatus,  80,    daCenter,  false,   prefix +"ibflag");
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_sts_cd"         ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_curr_cd1"       ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_curr_cd2"       ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_curr_cd3"       ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_curr_cd4"       ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_curr_cd5"       ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_amt1"           ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_amt2"           ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_amt3"           ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_amt4"           ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_amt5"           ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"ppt_sts_cd"             ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"ppt_rcv_ofc_cd"         ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"ppt_rcv_usr_id"         ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"ppt_rcv_dt"             ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_sts_cd"             ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_rcv_ofc_cd"         ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_rcv_usr_id"         ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_rcv_dt"             ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_curr_cd1"       ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_curr_cd2"       ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_curr_cd3"       ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_curr_cd4"       ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_curr_cd5"       ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_amt1"           ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_amt2"           ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_amt3"           ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_amt4"           ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_amt5"           ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_ppt_sts_cd"       ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_ppt_rcv_ofc_cd"   ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_ppt_rcv_usr_id"   ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_ppt_rcv_dt"       ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_sts_cd"       ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_rcv_ofc_cd"   ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_rcv_usr_id"   ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_rcv_dt"       ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_curr_cd1" ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_curr_cd2" ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_curr_cd3" ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_curr_cd4" ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_curr_cd5" ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_amt1"     ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_amt2"     ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_amt3"     ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_amt4"     ,   false,     "",        dfNone,     0,          false,       true);
//                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_amt5"     ,   false,     "",        dfNone,     0,          false,       true);
//
//                    CountPosition = 0;
//                }
//            break;

            case "demInfo":

                /****************************************************************
                //DEM.DET I/F
                *****************************************************************/

                with (sheetObj) {
                    // 높이 설정
                    style.height = 92;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    //MergeSheet = msNone;
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    var HeadTitle = " |Seq\n|Container No.|F/T\nOver|Billable\nAmount|Billable\nAmount|Estimate\nFree Time|SAT\nExcl|SUN\nExcl|HOLI\nExcl|Estimate\nPOD LFD|Daily\nDemurrage|Fixed\nFree Time|Fixed\nPOD LFD";

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, false, false, false, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);


                    //데이터속성    [ROW, COL,    DATATYPE,        WIDTH,  DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD,     CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="demInfo_";
                    InitDataProperty(0,   cnt++ , dtHiddenStatus,  30,     daCenter,  false,     prefix +"ibflag");
                    InitDataProperty(0,   cnt++ , dtSeq,           40,     daCenter,  true,      prefix +"Seq");
                    InitDataProperty(0,   cnt++ , dtData,          100,    daCenter,  false,     prefix +"cntr_no"         , false,   "",    dfNone,      0,     false,       true);
                    InitDataProperty(0,   cnt++ , dtData,          60,     daCenter,  false,     prefix +"fx_ft_ovr_dys"   , false,   "",    dfNone,      0,     false,       true);
                    InitDataProperty(0,   cnt++ , dtData,          35,     daCenter,  false,     prefix +"bzc_trf_curr_cd" , false,   "",    dfNone,      0,     false,       true);
                    InitDataProperty(0,   cnt++ , dtData,          80,     daRight,   false,     prefix +"bil_amt"         , false,   "",    dfNumber,    0,     false,       true);
                    InitDataProperty(0,   cnt++ , dtData,          80,     daCenter,  false,     prefix +"ft_dys"          , false,   "",    dfNone,      0,     false,       true);
                    InitDataProperty(0,   cnt++ , dtCheckBox,      60,     daCenter,  false,     prefix +"xcld_sat_flg"    , false,   "",    dfNone,      0,     false,       true);
                    InitDataProperty(0,   cnt++ , dtCheckBox,      60,     daCenter,  false,     prefix +"xcld_sun_flg"    , false,   "",    dfNone,      0,     false,       true);
                    InitDataProperty(0,   cnt++ , dtCheckBox,      60,     daCenter,  false,     prefix +"xcld_hol_flg"    , false,   "",    dfNone,      0,     false,       true);
                    InitDataProperty(0,   cnt++ , dtHidden,        60,     daCenter,  false,     prefix +""                , false,   "",    dfNone,      0,     false,       true);
                    InitDataProperty(0,   cnt++ , dtHidden,        80,     daCenter,  false,     prefix +"cntr_rt_amt"     , false,   "",    dfNumber,    0,     false,       true);
                    InitDataProperty(0,   cnt++ , dtData,          70,     daCenter,  false,     prefix +"ft_dys_calc"     , false,   "",    dfNone,      0,     false,       true);
                    InitDataProperty(0,   cnt++ , dtData,          60,     daCenter,  false,     prefix +"ft_end_dt"       , false,   "",    dfDateYmd,   0,     false,       true);

                    CountPosition = 0;
                }
                break;

            case "demDtl":

                /****************************************************************
                //컨테이너 별 Demurrage
                *****************************************************************/

                with (sheetObj) {
                    // 높이 설정
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    //MergeSheet = msNone;
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    var HeadTitle = " |Invoicing|Settled|DEMCMNC|PaidUpto|Paid Amount|Paid Amount|CNTR_NO|BIL_AMT";

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, false, false, false, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,    DATATYPE,        WIDTH, DATAALIGN, COLMERGE,  SAVENAME,                    KEYFIELD,    CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="demDtl_";
                    InitDataProperty(0,   cnt++ , dtHiddenStatus,  30,    daCenter,  false,     prefix +"ibflag");
                    InitDataProperty(0,   cnt++ , dtData,          90,    daCenter,  false,     prefix +"dmdt_inv_sts_cd",  false,       "",         dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ , dtData,          90,    daCenter,  false,     prefix +"dmdt_ar_if_cd",    false,       "",         dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ , dtData,          80,    daCenter,  false,     prefix +"ft_end_dt",        false,       "",         dfDateYmd,  0,          false,       true);
                    InitDataProperty(0,   cnt++ , dtData,          80,    daCenter,  false,     prefix +"to_mvmt_dt",       false,       "",         dfDateYmd,  0,          false,       true);
                    InitDataProperty(0,   cnt++ , dtData,          40,    daCenter,  false,     prefix +"inv_curr_cd",      false,       "",         dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ , dtHidden,        80,    daRight,   false,     prefix +"bil_amt",          false,       "",         dfNumber,   0,          false,       true);
                    InitDataProperty(0,   cnt++ , dtHidden,        80,    daCenter,  false,     prefix +"cntr_no",          false,       "",         dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ , dtData,          70,    daCenter,  false,     prefix +"inv_chg_amt",      false,       "",         dfNumber,   0,          false,       true);

                    CountPosition = 0;
                }
            break;

            case "totBlbAmt":

                /****************************************************************
                //Total Billable Amount
                *****************************************************************/

                with (sheetObj) {
                    // 높이 설정
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 15, 100);

                    var HeadTitle1 = "|curr_cd|tot_bil_amt";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    prefix = "totBlbAmt_";
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN,   COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,         30,     daCenter,   true,       prefix + "ibflag");
                    InitDataProperty(0, cnt++ , dtData,                 100,    daCenter,   false,      prefix + "curr_cd",         false,      "",     dfNone,         0,      false,      true);
                    InitDataProperty(0, cnt++ , dtData,                 100,    daLeft,     false,      prefix + "tot_bil_amt",     false,      "",     dfNone,         0,      false,      true);

                    CountPosition = 0;
                }
                break;

//            case "otsRcvPop":
//                /****************************************************************
//                //Total Billable Amount
//                *****************************************************************/
//
//                with (sheetObj) {
//                    // 높이 설정
//                    style.height = 0;
//                    //전체 너비 설정
//                    SheetWidth = mainTable.clientWidth;
//
//                    //Host정보 설정[필수][HostIp, Port, PagePath]
//                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
//
//                    //전체Merge 종류 [선택, Default msNone]
//                    MergeSheet = msAll;
//
//                   //전체Edit 허용 여부 [선택, Default false]
//                    Editable = true;
//
//                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
//                    InitRowInfo(1, 1, 15, 100);
//
//                    var HeadTitle1 = "|OUTSTANDING|OUTSTANDING";
//                    var headCount = ComCountHeadTitle(HeadTitle1);
//
//                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
//                    InitColumnInfo(headCount, 0, 0, true);
//
//                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
//                    InitHeadMode(true, true, false, true, false,false)
//
//                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
//                    InitHeadRow(0, HeadTitle1, true);
//
//                    prefix = "otsRcvPop_";
//                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN,   COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//                    InitDataProperty(0, cnt++ , dtHiddenStatus,         30,     daCenter,   true,       prefix + "ibflag");
//                    InitDataProperty(0, cnt++ , dtData,                 100,    daCenter,   false,      prefix + "curr_cd",         false,      "",     dfNone,         0,      false,      true);
//                    InitDataProperty(0, cnt++ , dtData,                 100,    daLeft,     false,      prefix + "tot_ots_amt",     false,      "",     dfNone,         0,      false,      true);
//
//                    CountPosition = 0;
//                }
//                break;

//            case "sheet2":
//                with (sheetObj) {
//                    // 높이 설정
//                    style.height = 0;
//                    //전체 너비 설정
//                    SheetWidth = mainTable.clientWidth;
//
//                    //Host정보 설정[필수][HostIp, Port, PagePath]
//                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
//
//                    //전체Merge 종류 [선택, Default msNone]
//                    MergeSheet = msHeaderOnly;
//
//                    //전체Edit 허용 여부 [선택, Default false]
//                    Editable = true;
//
//                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
//                    InitRowInfo( 1, 1, 3, 100);
//
//                    var HeadTitle = "ibflag|partial|bl_no|bkg_no|split_no|bl_tp_cd";
//                    var headCount = ComCountHeadTitle(HeadTitle);
//                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
//                    InitColumnInfo(headCount, 0, 0, true);
//
//                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
//                    InitHeadMode(true, false, true, true, false,false)
//
//                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
//                    InitHeadRow(0, HeadTitle, true);
//
//                    prefix = "sheet2_";
//
//                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//                    InitDataProperty(0, cnt++ , dtHiddenStatus,     30, daCenter,  true,     prefix + "ibflag");
//                    InitDataProperty(0, cnt++ , dtData,             50, daCenter,  false,    prefix + "partial",            false,          "",      dfNone,      0,     false);
//                    InitDataProperty(0, cnt++ , dtData,             50, daCenter,  false,    prefix + "bl_no",              false,          "",      dfNone,      0,     false);
//                    InitDataProperty(0, cnt++ , dtData,             30, daCenter,  false,    prefix + "bkg_no",             false,          "",      dfNone,      0,     false);
//                    InitDataProperty(0, cnt++ , dtData,             30, daCenter,  false,    prefix + "split_flg",          false,          "",      dfNone,      0,     false);
//                    InitDataProperty(0, cnt++ , dtData,             30, daCenter,   false,   prefix + "bl_tp_cd",           false,          "",      dfNone,      0,     false,      true);
//
//                    CountPosition = 0;
//                }
//                break;
        }
    }

    /**
     * Sheet관련 프로세스 처리<br>
     * @param sheetObj IBSheet Object
     * @param formObj  UI 화면의 Object
     * @param sAction  IBSEARCH - 조회, COMMAND01, COMMAND02, COMMAND04
     * @return void
     * @author An JinEung
     * @version 2009.11.01
     **/
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
        switch(sAction) {

            case IBSEARCH:      //조회
            	ComOpenWait(true);

                //다중조회
                formObj.f_cmd.value = SEARCH;
//                var aryPrefix = new Array("blInfo_", "refInfo_", "euDoRlseStsCntr_", "euDoRlseStsBl_", "blIss_", "otsRcvInfo_", "demInfo_", "demDtl_", "totBlbAmt_"); //prefix 문자열 배열
                var aryPrefix = new Array("blInfo_", "euDoRlseStsCntr_", "euDoRlseStsBl_", "demInfo_", "demDtl_", "totBlbAmt_"); //prefix 문자열 배열
                var sXml = sheetObj.GetSearchXml("ESM_BKG_0292_02GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
                var arrXml = sXml.split("|$$|");

                if(undefined != ComGetEtcData(arrXml[0], "tpbStatus") && ComGetEtcData(arrXml[0], "tpbStatus") != 'null'){
                    document.getElementById("tpb_status").value = ComGetEtcData(arrXml[0], "tpbStatus");
                }

                if(undefined != ComGetEtcData(arrXml[0], "splitFlg") && ComGetEtcData(arrXml[0], "splitFlg") != 'null'){
              	  var splitFlg = ComGetEtcData(arrXml[0], "splitFlg");

              	  if (splitFlg == "N") {
              		  sheetObjects[euDoRlseStsBl].style.height = 66;
              		  sheetObjects[euDoRlseStsCntr].style.height = 0;

              		  document.form.split_flg[0].checked = true;
              	  } else {
              		  sheetObjects[euDoRlseStsBl].style.height = 0;
              		  sheetObjects[euDoRlseStsCntr].style.height = 66;

              		  document.form.split_flg[1].checked = true;
              	  }
                }

                //ETC DATA 처리 : LoadSearchXml 순간 OnSearchEnd Event 발생 (ETC Data로 OnSearchEnd Event에서 처리 할 경우 ETC 데이터 설정 부분을 LoadSearchXml 앞에서 처리 해야 함
                if(undefined != ComGetEtcData(arrXml[0], "demurType") && ComGetEtcData(arrXml[0], "demurType") != 'null'){
                    document.getElementById("demur_type").value = ComGetEtcData(arrXml[0], "demurType");
                }

                var t3Idx  = blInfo;

                for(var idx = 0; idx < arrXml.length; idx++){
                	t3Idx = blInfo + idx;

                	sheetObjects[t3Idx].Redraw = false;
                    if(idx > 0) {
                        sheetObjects[t3Idx].WaitImageVisible = false;
                    }

                    sheetObjects[t3Idx].LoadSearchXml(arrXml[idx]);
                    sheetObjects[t3Idx].Redraw = true;
                }
                
                /*********************** WEB OB/L 체크 추가 ************************/
                fnOblInterSerNoInfo(sheetObj,formObj,formObj.blInfo_bl_tp_cd.value, formObj.bkg_no.value);    
                /*********************** WEB OB/L 체크 추가 end*********************/
                
                ComOpenWait(false);

                break;

            case COMMAND05: //DEM Retrieve
	            if(validateForm(sheetObj,formObj,sAction)){

	                formObj.f_cmd.value = SEARCH;

	            	ComOpenWait(true);

	                //다중조회
//	                var aryPrefix = new Array("blInfo_", "refInfo_", "euDoRlseStsCntr_", "euDoRlseStsBl_", "blIss_", "otsRcvInfo_", "demInfo_", "demDtl_", "totBlbAmt_"); //prefix 문자열 배열
	                var aryPrefix = new Array("blInfo_", "euDoRlseStsCntr_", "euDoRlseStsBl_", "demInfo_", "demDtl_", "totBlbAmt_"); //prefix 문자열 배열
	                var sXml = sheetObj.GetSearchXml("ESM_BKG_0292_02GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
	                var arrXml = sXml.split("|$$|");

	                var t3Idx  = blInfo;
	                //idx의 값이 "demInfo_" 부터 시작하도록 맞춤
	                for(var idx = 3; idx < arrXml.length; idx++){
	                	t3Idx  = blInfo + idx;
	                	sheetObjects[t3Idx].Redraw = false;
	                    if(idx > 0) {
	                        sheetObjects[t3Idx].WaitImageVisible = false;
	                    }

	                    sheetObjects[t3Idx].LoadSearchXml(arrXml[idx]);
	                    sheetObjects[t3Idx].Redraw = true;
	                }

	                //ETC DATA 처리 : LoadSearchXml 순간 OnSearchEnd Event 발생 (ETC Data로 OnSearchEnd Event에서 처리 할 경우 ETC 데이터 설정 부분을 LoadSearchXml 앞에서 처리 해야 함
	                if(undefined != ComGetEtcData(arrXml[0], "demurType") && ComGetEtcData(arrXml[0], "demurType") != 'null'){
	                    document.getElementById("demur_type").value = ComGetEtcData(arrXml[0], "demurType");
	                }
	            }
	            break;
            case IBSAVE:   //저장

	            if(validateForm(sheetObj, formObj, sAction)){

	                formObj.f_cmd.value = MODIFY;

	                //Form의 값을 Sheet Row로 Copy
//	                CopyFormToRow(formObj, sheetObjects[refInfo], 1, "");
	                CopyFormToRow(formObj, sheetObjects[blInfo], 1, "");

//                  2010.04.09 수정 지침에 따라서 수정(안진응)
//	                sheetObjects[blInfo].CellValue2(1, "blInfo_ibflag") = 'U';
	                sheetObjects[blInfo].RowStatus(1) = "U";

	                var sParam1 = sheetObjects[blInfo].GetSaveString();   //EU D/O Release Reference 정보

	                //그리드의 변경 여부 체크
	                if(! sheetObjects[blInfo].IsDataModified){
	                    ComShowCodeMessage('BKG00743');
	                    return false;
	                }

	                var bkgNo = sheetObjects[blInfo].CellValue(1, "blInfo_bkg_no");

	                if( !ComShowCodeConfirm('COM12147') ){
	                    return false;
	                }

	                var aryPrefix = new Array("blInfo_");    //prefix 문자열 배열
	                var sparam = sParam1 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);

	                var sXml = sheetObjects[blInfo].GetSaveXml("ESM_BKG_0292_02GS.do", sparam);

	                sheetObjects[blInfo].LoadSaveXml(sXml);
	//                sXml = ComDeleteMsg(sXml);   /// 넘어온 메시지는 한번만 보이고 싶을 때 사용
	                //sheetObjects["blIss"].LoadSaveXml(sXml);
	            }
	            break;
        }
    }

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      * @param sheetObj IBSheet Object
      * @param formObj  UI 화면의 Object
      * @param sAction  IBSEARCH - 조회
      * @return void
      * @author An JinEung
      * @version 2009.11.01
      **/
    function validateForm(sheetObj,formObj,sAction){
    	var oForm = document.form;

    	switch(sAction) {
        case COMMAND05:
//        	if(ComIsEmpty(formObj.exp_del_dt.value)){
//                ComShowCodeMessage('BKG00887', 'Expect Delivery Date');
//                formObj.exp_del_dt.focus();
//                return false;
//            }

        	if(!ComChkObjValid(oForm.exp_del_dt)) {
                return false;
            }

            var toDay    = ComGetNowInfo('ymd','-').replace(eval("/-/gi"), "");
            var expDelDt = formObj.exp_del_dt.value.replace(eval("/-/gi"), "");

            //오늘 날짜 이전 날짜를 넣으면 경고 메세지
            if(toDay > expDelDt){
                ComShowCodeMessage('BKG40114', expDelDt);
                return false;
            }

        	return true;

            break;
        }

        return true;
    }



    //Axon 이벤트 처리2. 이벤트처리함수 --- start
    /**
     * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
     * @param void
     * @return void
     * @author An JinEung
     * @version 2009.11.01
     **/
    function obj_keypress(){
    	var keyCode = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
        var srcName = window.event.srcElement.getAttribute("name");

        if (keyCode == 13 && srcName == 'exp_del_dt') {
//             doActionIBSheet(sheetObjects[blInfo], document.form, COMMAND05);
           //기본정보가 조회 된 상태가 아니면 엔터키를 입력해도 조회 하지 않는다.
             if(sheetObjects[blInfo].CellValue(1,"blInfo_bkg_no") != undefined){
                 doActionIBSheet(sheetObjects[blInfo], document.form, COMMAND05);
             }
        }

        if(srcName == 'exp_del_dt'){
            ComKeyOnlyNumber(event.srcElement);
        }

    	switch(event.srcElement.dataformat){
            case "float":
                //숫자+"."입력하기
                ComKeyOnlyNumber(event.srcElement, ".");
                break;
            case "eng":
                //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
                //ComKeyOnlyAlphabet();
                ComKeyOnlyAlphabet('uppernum');
                break;
            case "engdn":
                //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
                ComKeyOnlyAlphabet('lower');
                break;
            case "engup":
                //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
                ComKeyOnlyAlphabet('upper');
                break;
            default:
                //숫자만입력하기(정수,날짜,시간)
                ComKeyOnlyNumber(event.srcElement);
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
            case "exp_del_dt":
                ComChkObjValid(event.srcElement);
            break;
        }
    }

    /**
     * 화면의 버튼을 비 활성화 시킨다.
     * @param  void
     * @return void
     * @author An JinEung
     * @version 2009.11.01
     **/
    function buttonColorSet(btn_name, color){
        var tds = document.getElementsByTagName("td");
        var curFlag = null;

        if (color == 'red') {
    	    curFlag = "hand";
        } else {
    	    curFlag = "default";
        }

        for(var i = 0; i < tds.length; i++) {
            var td=tds[i];

            if(td.name == '•' + btn_name){
           	    td.style.color = color;
           	    td.style.cursor = curFlag;

           	if (btn_name == "btn_split") {
           	    document.form.h_split.value = color;
           	}
                break;
            }else if(td.name == btn_name){
           	    td.style.color = color;
           	    td.style.cursor = curFlag;

           	    if (btn_name == "btn_split") {
           		    document.form.h_split.value = color;
           	    }
                break;
            }else{
           	    continue;
            }
        }
    }

    /**
     * S/O Info의 값을 Clear한다.
     * @param  void
     * @return void
     * @author An JinEung
     * @version 2009.11.01
     **/
    function fnCargoClear() {
        //모든 input 항목을 Clear 시킨다.
        for(var i=0; i<document.form.getElementsByTagName("input").length; i++) {
            if (document.form.getElementsByTagName("input")[i].name.substr(0, 12) == "frm_t1sheet1") {
            	document.form.getElementsByTagName("input")[i].value="";
            }
        }

        //Outstanding Amouts 항목을 클리어한다.
        var selOtsAmt = document.form.t3_tot_ots_amt;

        for (i=selOtsAmt.length-1; i>=0; i--){
        	selOtsAmt.options[i] = null
        }

        //Outstanding Demurrage Per B/L 항목을 Clear한다.
        var selDemAmt = document.form.t3_tot_bil_amt;

        for (i=selDemAmt.length-1; i>=0; i--){
            selDemAmt.options[i] = null
        }

    	sheetObjects[blInfo].RemoveAll();
     	sheetObjects[euDoRlseStsCntr].RemoveAll();
     	sheetObjects[euDoRlseStsBl].RemoveAll();
     	sheetObjects[demInfo].RemoveAll();
     	sheetObjects[totBlbAmt].RemoveAll();
    }



    /**
     * 화면의 조회 처리 모듈을 통합적으로 관리한다.
     * @param  void
     * @return void
     * @author An JinEung
     * @version 2009.11.01
     **/
    function fnSearch() {
    	fnCargoClear();

    	doActionIBSheet(sheetObjects[blInfo],document.form,IBSEARCH,"","");
    }

    //ERP로 부터 받아온 정보를 Select Box로 구성한다.
    function t3addSel(sheetObj) {
        var sel = document.form.t3_tot_ots_amt;
        var prefix="blInfo_";

        for (i=sel.length-1; i>=0; i--){
            sel.options[i] = null
        }

        //미신용 화주이면 미수금을 회수 했을 경우
        //2010.03.04 by sungho 수정
		//if(sheetObj.CellValue(1, prefix+"tot_ots_sts_cd")!='N'){
		if(sheetObj.CellValue(1, prefix+"tot_ots_sts_cd")=='Y' || sheetObj.CellValue(1, prefix+"tot_ots_sts_cd")=='C'){

//            document.getElementById("blInfo_tot_ots_sts_cd").value = "Y";

            // btn_cct disable
            document.getElementById("div_btn_cct").style.visibility="hidden";
            document.getElementById("div_btn_third_cct").style.visibility="hidden";

        } else if(sheetObj.CellValue(1, prefix+"tot_ots_sts_cd")=='N'){
            // btn_cct, div_btn_third_cct visible (안진응)
            
            if (sheetObj.CellValue(1, prefix+"cct_ots_curr_cd1") == "N") {
              document.getElementById("div_btn_cct").style.visibility="visible";
            }else {
              document.getElementById("div_btn_cct").style.visibility="hidden";
            }

            
            if (sheetObj.CellValue(1, prefix+"n3pty_cct_ots_curr_cd1") == "N") {
              document.getElementById("div_btn_third_cct").style.visibility="visible";
            } else {
              document.getElementById("div_btn_third_cct").style.visibility="hidden";
            }
        	
        } else {
			//2010.03.04 by sungho 추가
			document.form['t3_tot_ots_amt'][0] = new Option(sheetObj.CellValue(1, prefix+"tot_ots_amt1"));
			
			document.getElementById("t3_tot_ots_amt").className = "input2_1";
			
            // btn_cct disable
            document.getElementById("div_btn_cct").style.visibility="hidden";
            document.getElementById("div_btn_third_cct").style.visibility="hidden";
            
            return;
        }
        
        var unit   = "";
        var amount = "";
        var colorFlg = "";

        for (j=0; j<5; j++){
            unit   = sheetObj.CellValue(1, "blInfo_"+"tot_ots_curr_cd"+parseInt(j+1));
            amount = sheetObj.CellValue(1, "blInfo_"+"tot_ots_amt"+parseInt(j+1));
            if(! ComIsEmpty(unit)){
            	if (amount > 0) {
            		colorFlg = "Y";
            	}

            	document.form['t3_tot_ots_amt'][j] = new Option(unit+' '+ComAddCommaRun(amount), j);                
            }
        }
        
        if (colorFlg == "Y") {
        	//폰트 색상을 붉고 진하게 한다.
        	document.getElementById("t3_tot_ots_amt").className = "input2_1";
        } else {
        	document.getElementById("t3_tot_ots_amt").className = "input2";
        }
        
    }

    //TPB로 부터 받아온 정보로 이미지 구성 및 코드 값 세팅
    function tpbImgSet(tpbStatus) {
    	if(tpbStatus) null ? document.getElementById("tpb_status").value : tpbStatus;
    	
        if(document.getElementById("tpb_status").value == "1"){
            document.getElementById("tpb_icon").src = "img/btng_icon_green.gif";
            document.getElementById("tpb_cd").value = 'C';
            
            document.getElementById("tpb_cd").setAttribute("title", "Cleared");
        }else if(document.getElementById("tpb_status").value == "0"){
        	document.getElementById("tpb_icon").src = "img/btng_icon_r.gif";
            document.getElementById("tpb_cd").value = 'P';
            
            document.getElementById("tpb_cd").setAttribute("title", "Processing");
        }else{
            document.getElementById("tpb_icon").src = "img/btng_icon_g.gif";
            document.getElementById("tpb_cd").value = '';
            document.getElementById("btn_tpb").style.visibility = "hidden";
            
            document.getElementById("tpb_cd").removeAttribute("title");
        }
    }

//    /**
//     * refInfo를 저장하고 나서 처리할 사항
//     */
//    function refInfo_OnSaveEnd(sheetObj, ErrMsg){
//         //if (ErrMsg == "") {
//             //ComBkgSaveCompleted();  //서버메세지 처리
//            fnSearch();
//         //}
//    }

    /**
     * blInfo를 저장하고 나서 처리할 사항
     */
    function blInfo_OnSaveEnd(sheetObj, ErrMsg){
         //if (ErrMsg == "") {
             //ComBkgSaveCompleted();  //서버메세지 처리
             fnSearch();
         //}
    }


    /**
     * EU D/O Release 기본 정보 조회 IBSheet를 조회하고 나서 처리할 사항
     */
    function blInfo_OnSearchEnd(sheetObj, ErrMsg){

    	//Wait Image Show Hidden
        ComOpenWait(false);

        document.form.blInfo_inter_rmk.value = "";

        if (ErrMsg == "") {
            if(sheetObj.RowCount > 0){
                //Grid의 Data를 Html의 인자값으로 Copy한다.
                ComCopyRowToForm(sheetObj, 1, form, "");

                //조회 조건
                document.getElementById("bkg_no").value = sheetObj.CellValue(1,"blInfo_bkg_no");
                document.getElementById("bl_no").value  = sheetObj.CellValue(1,"blInfo_bl_no");

           	    if (sheetObj.CellValue(1, "blInfo_do_hld_flg") == "") {
             	    sheetObj.CellValue2(1, "blInfo_do_hld_flg") = "N";
             	}

                // 2010.02.08 refInfo ==> blInfo
                //Hold 여부에 따라서 빨강 또는 회색으로 글씨 처리
                if(sheetObj.CellValue(1, "blInfo_do_hld_flg") =='N'){
                    document.getElementById("hold_flag").className = "input2";
                    //document.getElementById("hold_flag").value = 'Hold'; 2009-11-04 윤윤환 수석 India D/O와 동일하게 처리 (Hold 시에만 빨간색 글씨)
                    //Hold Event에 대한 값 세팅 :CargoReleaseOrderBCImpl.java holdDo에서 Hold or Un-Hold 구분 값

                }else if(sheetObj.CellValue(1, "blInfo_do_hld_flg") =='Y'){
                    document.getElementById("hold_flag").className = "input2_1";
                    document.getElementById("hold_flag").value = 'Hold';
                    //Hold Event에 대한 값 세팅 :CargoReleaseOrderBCImpl.java holdDo에서 Hold or Un-Hold 구분 값
                }else{
                    document.getElementById("hold_flag").className = "input2";
                    //document.getElementById("hold_flag").value = 'Hold'; 2009-11-04 윤윤환 수석 India D/O와 동일하게 처리 (Hold 시에만 빨간색 글씨)
                    //Hold Event에 대한 값 세팅 :CargoReleaseOrderBCImpl.java holdDo에서 Hold or Un-Hold 구분 값
                }


                // 2010.02.08 blIss ==> blInfo

                if (document.form.blInfo_bl_tp_cd.value == "") {
                    document.form.blInfo_bl_tp_cd.value = "B";
                }

                //조회된 시점에 Original B/L회수여부가 Y값이면 파란색 N이면 빨간색으로 표시
                if( document.getElementById("blInfo_obl_rdem_flg").value =='Y'){
                    document.getElementById("blInfo_obl_rdem_flg").style.color='blue';
                }else if(document.getElementById("blInfo_obl_rdem_flg").value =='N'){
                    document.getElementById("blInfo_obl_rdem_flg").style.color='red';
                }


                //D/O EVENT에서 변경되기 전의 값 -->
                document.getElementById("pre_ctnt").value = document.getElementById("blInfo_obl_rdem_knt").value;

                // BL이 Surrender이면 OB/L Received쪽  Remark조회 버튼을 enable 및 필드는 Y로 Setting, 아닐경우 button disable (add by mgpark)
                if (sheetObj.CellValue(1, "blInfo_bl_tp_cd") == "S") {
                    document.getElementById("bl_surr_rmk_flg").value = "Y";
                    document.getElementById("div_btn_bl_surr_flg").style.visibility="visible";
                } else {
                    document.getElementById("bl_surr_rmk_flg").value = "";
                    document.getElementById("div_btn_bl_surr_flg").style.visibility="hidden";
                }


                // otsRcvInfo ==> blInfo
                t3addSel(sheetObj);

                ComBtnEnable("btn_cct");
                ComBtnEnable("btn_third_cct");
                ComBtnEnable("btn_erp");

                //2009-11-26 임진영 추가
                //조회된 시점에 Y값이면 파란색 N이면 빨간색으로 표시
                if( document.getElementById("blInfo_tot_ots_sts_cd").value =='Y'){
                    document.getElementById("blInfo_tot_ots_sts_cd").style.color='blue';
                }else if(document.getElementById("blInfo_tot_ots_sts_cd").value =='N'){
                    document.getElementById("blInfo_tot_ots_sts_cd").style.color='red';
                }

            }

            /*************************************************************
                TPB 설정 시작 0 : 빨강 1 : 녹색 -1 : 회색
            *************************************************************/
            tpbImgSet(document.getElementById("tpb_status").value);

            //버튼 활성화
            ComBtnEnable("btn_erp");
            ComBtnEnable("btn_dem_retrieve");
            ComBtnEnable("btn_dmdt");
            ComBtnEnable("btn_history");

        } else {
       	  	fnAllSheetClear();
        }
    }

//    /**
//     * EU D/O Release Reference 정보 조회 IBSheet를 조회하고 나서 처리할 사항
//     */
//    function refInfo_OnSearchEnd(sheetObj, ErrMsg){
//        if (ErrMsg == "") {
//            if(sheetObj.RowCount > 0){
//           	    if (sheetObj.CellValue(1, "refInfo_do_hld_flg") == "") {
//             	    sheetObj.CellValue2(1, "refInfo_do_hld_flg") = "N";
//             	}
//
//           	    //Grid의 Data를 Html의 인자값으로 Copy한다.
//                ComCopyRowToForm(sheetObj, 1, form, "");
//
//                //Hold 여부에 따라서 빨강 또는 회색으로 글씨 처리
//                if(sheetObj.CellValue(1, "refInfo_do_hld_flg") =="N"){
//                    document.getElementById("hold_flag").className = "input2";
//                    document.getElementById("hold_flag").value = "";
//                    //Hold Event에 대한 값 세팅 :CargoReleaseOrderBCImpl.java holdDo에서 Hold or Un-Hold 구분 값
//                }else if(sheetObj.CellValue(1, "refInfo_do_hld_flg") =="Y"){
//                    document.getElementById("hold_flag").className = "input2_1";
//                    document.getElementById("hold_flag").value = "Hold";
//                    //Hold Event에 대한 값 세팅 :CargoReleaseOrderBCImpl.java holdDo에서 Hold or Un-Hold 구분 값
//                }
//            }
//        }
//    }

//    /**
//     * Hidden IBSheet를 조회하고 나서 처리할 사항
//     */
//    function blIss_OnSearchEnd(sheetObj, ErrMsg){
//
//        if (ErrMsg == "") {
//            if(sheetObj.RowCount > 0){
//                //Grid의 Data를 Html의 인자값으로 Copy한다.
//                ComCopyRowToForm(sheetObj, 1, form, "");
//            }
//
//            if (document.form.blIss_bl_tp_cd.value == "") {
//            	document.form.blIss_bl_tp_cd.value = "B";
//            }
//
//            if (document.form.blIss_otr_doc_cgor_flg.value == "N") {
//            	document.form.blIss_otr_doc_cgor_flg.value = "Non-Accept";
//            } else if (document.form.blIss_otr_doc_cgor_flg.value == "N") {
//            	document.form.blIss_otr_doc_cgor_flg.value = "Accept";
//            } else {
//            	document.form.blIss_otr_doc_cgor_flg.value = "";
//            }
//
//            //조회된 시점에 Original B/L회수여부가 Y값이면 파란색 N이면 빨간색으로 표시
//            if( document.getElementById("blIss_obl_rdem_flg").value =='Y'){
//            }else if(document.getElementById("blIss_obl_rdem_flg").value =='N'){
//                document.getElementById("blIss_obl_rdem_flg").style.color='red';
//            }
//
//            //D/O EVENT에서 변경되기 전의 값 -->
//            document.getElementById("pre_ctnt").value = document.getElementById("blIss_obl_rdem_knt").value;
//
//            // BL이 Surrender이면 OB/L Received쪽  Remark조회 버튼을 enable 및 필드는 Y로 Setting, 아닐경우 button disable (add by mgpark)
//            if (sheetObj.CellValue(1, "blIss_bl_tp_cd") == "S") {
//            	document.getElementById("bl_surr_rmk_flg").value = "Y";
//             	document.getElementById("div_btn_bl_surr_flg").style.visibility="visible";
//            } else {
//             	document.getElementById("bl_surr_rmk_flg").value = "";
//             	document.getElementById("div_btn_bl_surr_flg").style.visibility="hidden";
//            }
//        }
//
//        //OBL Cancel 버튼 활성화
////          ComBtnEnable("btn_obl_cancel");
//    }

    /**
     * Hidden IBSheet를 조회하고 나서 처리할 사항
     */
    function totBlbAmt_OnSearchEnd(sheetObj, ErrMsg){
        var sel = document.form.t3_tot_bil_amt;

        //SELECT BOX 초기화
        for (i=sel.length-1; i>=0; i--){
        	sel.options[i] = null
        }

        var currCd = "";
        var bilAmt = "";
        var demSts = false;

        if (sheetObj.RowCount > 0) {
        	for (j=0; j<sheetObj.RowCount; j++){
        		currCd  = sheetObj.CellValue(parseInt(j+1), "totBlbAmt_"+"curr_cd");
        		bilAmt  = sheetObj.CellValue(parseInt(j+1), "totBlbAmt_"+"tot_bil_amt");

        		if (parseInt(bilAmt) > 0) {
        			demSts = true;
        		}

        		document.form['t3_tot_bil_amt'][j] = new Option(currCd+' '+ComAddCommaRun(bilAmt), j);
       	  	}
       	  	if (demSts == true) {
       	  		document.getElementById("demur_sts").value = "N";
                document.getElementById("demur_sts").style.color='red';
                
                document.getElementById("t3_tot_bil_amt").className = "input2_1";
       	  	} else {
       	  		document.getElementById("demur_sts").value = "Y";
                document.getElementById("demur_sts").style.color='blue';
                
                document.getElementById("t3_tot_bil_amt").className = "input2";
       	  	}
        } else {
        	document.getElementById("demur_sts").value = "Y";
            document.getElementById("demur_sts").style.color='blue';
            document.form['t3_tot_bil_amt'][0] = new Option('0');
            document.getElementById("t3_tot_bil_amt").className = "input2";
        }
    }

//    /**
//     * Hidden IBSheet를 조회하고 나서 처리할 사항
//     * 운임 결재 여부와 Outstanding Amounts 정보 추출
//     */
//    function otsRcvInfo_OnSearchEnd(sheetObj, ErrMsg){
//
//        if (ErrMsg == "") {
//            if(sheetObj.RowCount > 0){
//                //Grid의 Data를 Html의 인자값으로 Copy한다.
//                ComCopyRowToForm(sheetObj, 1, form, "");
//                t3addSel(sheetObj);
//
//                ComBtnEnable("btn_cct");
//                ComBtnEnable("btn_third_cct");
//                ComBtnEnable("btn_erp");
//            }
//        }
//    }

    /**
     * Hidden IBSheet를 조회하고 나서 처리할 사항
     * B/L별 D/O의 STATUS(ASSIGN, RELEASE, ISSUE)별 상세 정보 추출
     */
    function euDoRlseStsCntr_OnSearchEnd(sheetObj, ErrMsg){

        if (ErrMsg == "") {
       	    if (document.form.blInfo_do_split_flg.value == "N") return;

       	    if(sheetObj.RowCount > 0){

                //D/O의 최종 상태를 Hidden Value에 세팅한다.
                for(var idx=1; idx <= sheetObj.RowCount; idx++){

                    //취소 직전의 값을 담는다.
                    if(sheetObj.CellValue(idx, "euDoRlseStsCntr_rlse_sts_cd") != 'C'){
                        document.getElementById("rlse_sts_cd").value = sheetObj.CellValue(idx, "euDoRlseStsCntr_rlse_sts_cd");
                    }

                    //마지막 Row의 값을 세팅한다.
                    if(idx == sheetObj.RowCount){
                        document.getElementById("last_rlse_sts_cd").value = sheetObj.CellValue(idx, "euDoRlseStsCntr_rlse_sts_cd");
                    }

                }

                //히든 값에  D/O 번호를 세팅한다.
                document.getElementById("h_do_no").value = sheetObj.CellValue(1, "euDoRlseStsCntr_do_no");

                var headRow = sheetObjects[euDoRlseStsCntr].HeaderRows;
                var splitYn = false;

                for(var idx=headRow; idx <= sheetObjects[euDoRlseStsCntr].LastRow; idx++){
                	if (sheetObjects[euDoRlseStsCntr].CellValue(idx, "euDoRlseStsCntr_rlse_sts_cd") == "R") {
                		splitYn = true;
                	}
                }

                //조회 결과가 Cancel만 존재 할때
                if(splitYn == false){
                    document.form.split_flg[0].disabled = false;
                    document.form.split_flg[1].disabled = false;
                } else {
               	  	document.form.split_flg[0].disabled = true;
               	  	document.form.split_flg[1].disabled = true;
                }

                //D/O EVENT에서 변경되기 전의 값 -->
                document.getElementById("pre_ctnt").value = sheetObj.CellValue(1, "doRlseSts_rlse_sts_cd");
            }
        }
    }

    /**
     * Hidden IBSheet를 조회하고 나서 처리할 사항
     * B/L별 D/O의 STATUS(ASSIGN, RELEASE, ISSUE)별 상세 정보 추출
     */
    function euDoRlseStsBl_OnSearchEnd(sheetObj, ErrMsg){

        if (ErrMsg == "") {

	        if (document.form.blInfo_do_split_flg.value == "Y") return;

	        if(sheetObj.RowCount > 0){

	            //D/O의 최종 상태를 Hidden Value에 세팅한다.
	            for(var idx=1; idx <= sheetObj.RowCount; idx++){

	                //취소 직전의 값을 담는다.
	                if(sheetObj.CellValue(idx, "euDoRlseStsBl_rlse_sts_cd") != 'C'){
	                    document.getElementById("rlse_sts_cd").value = sheetObj.CellValue(idx, "euDoRlseStsBl_rlse_sts_cd");
	                }

	                //마지막 Row의 값을 세팅한다.
	                if(idx == sheetObj.RowCount){
	                    document.getElementById("last_rlse_sts_cd").value = sheetObj.CellValue(idx, "euDoRlseStsBl_rlse_sts_cd");
	                }
	            }

	            //히든 값에  D/O 번호를 세팅한다.
		        document.getElementById("h_do_no").value = sheetObj.CellValue(1, "euDoRlseStsBl_do_no");

		        //조회 결과가 Cancel만 존재 할때
		        if(sheetObj.RowCount == 1 && sheetObj.CellValue(1, "euDoRlseStsBl_rlse_sts_cd") == 'C'){
		        	document.form.split_flg[0].disabled = false;
		            document.form.split_flg[1].disabled = false;
		        } else {
		        	document.form.split_flg[0].disabled = true;
		            document.form.split_flg[1].disabled = true;
		        }

	            //D/O EVENT에서 변경되기 전의 값 -->
	            document.getElementById("pre_ctnt").value = sheetObj.CellValue(1, "euDoRlseStsBl_rlse_sts_cd");
            }
        }
    }

    /************************************************************************************
         IBSHEET의 OnSearchEnd Event 처리 끝
     ************************************************************************************/

     /**
      * CCT,Third Office(CCT)  팝업용 조회 처리 <br>
      */
     function blOutstandingAmountPopOpen(flag){

//         if (sheetObjects[blInfo].RowCount == 0) {
//             alert("Outstanding Amount 값이 존재하지 않습니다.")
//             return;
//         }

         var maxRow = sheetObjects[blInfo].LastRow;
         var cellValue = "";
         var prefix = "blInfo_";

         var curr_cd = "";
         var ots_amt = 0;

         var strXmlBody = "";
         var xmlCnt = 0;

         for(i=1;i <= maxRow ; i++){

             //전송상태에 따라 글자색 설정
             for(var q=1;q<6;q++){
                 if (flag == true) { // CCT를 선택한 경우
                     if (sheetObjects[blInfo].CellValue(i, prefix + "cct_ots_amt" + q) > 0) {
                         curr_cd = sheetObjects[blInfo].CellValue(i, prefix + "cct_ots_curr_cd" + q);
                         ots_amt = sheetObjects[blInfo].CellValue(i, prefix + "cct_ots_amt" + q);

                         strXmlBody = strXmlBody + "<TR><![CDATA[" + curr_cd + "☜☞☜☞" + ots_amt + "☜☞]]></TR>";

                         xmlCnt = parseInt(xmlCnt) + 1;
                     }
                 } else {            // Third Office(CCT)를
                     if (sheetObjects[blInfo].CellValue(i, prefix + "n3pty_cct_ots_amt" + q) > 0) {
                         curr_cd = sheetObjects[blInfo].CellValue(i, prefix + "n3pty_cct_ots_curr_cd" + q);
                         ots_amt = sheetObjects[blInfo].CellValue(i, prefix + "n3pty_cct_ots_amt" + q);

                         strXmlBody = strXmlBody + " <TR><![CDATA[" + curr_cd + "☜☞☜☞" + ots_amt + "☜☞]]></TR>";

                         xmlCnt = parseInt(xmlCnt) + 1;
                     }
                 }
             }
         }

         if (parseInt(xmlCnt) > 0) {
             var sXml = "";
             sXml = "<SHEET> ";
             sXml = sXml + "<DATA COLORDER='otsRcvPop_curr_cd|otsRcvPop_ibflag|otsRcvPop_tot_ots_amt|otsRcvPop_pagerows|' COLSEPARATOR='☜☞' TOTAL='" + xmlCnt + "'>"
             sXml = sXml + strXmlBody;
             sXml = sXml + "</DATA> </SHEET>";

//             var sXml = IBS_GetDataSearchXml(sheetObjects["otsRcvPop"]);
             document.form.oaXmlData.value = sXml;
             ComOpenPopup("/hanjin/ESM_BKG_1022.do", 400, 320, "", "1,0", true);
         }
     }

    function setSplitFlag(splitFlg) {
	   	if (splitFlg == "N") {
	   		sheetObjects[euDoRlseStsBl].style.height = 66;
	   		sheetObjects[euDoRlseStsCntr].style.height = 0;
	   		document.form.blInfo_do_split_flg.value = "N";
	    } else {
	       	document.form.blInfo_do_split_flg.value = "Y";
	   		sheetObjects[euDoRlseStsBl].style.height = 0;
	   		sheetObjects[euDoRlseStsCntr].style.height = 66;
	   	}
    }

    function fnAllSheetClear() {
	   	sheetObjects[blInfo].RemoveAll();
	   	sheetObjects[euDoRlseStsCntr].RemoveAll();
	   	sheetObjects[euDoRlseStsBl].RemoveAll();
	   	sheetObjects[demInfo].RemoveAll();
	   	sheetObjects[demDtl].RemoveAll();
	   	sheetObjects[totBlbAmt].RemoveAll();
    }

    function fncTextareaMaxLine(obj) {
        var str_line = obj;
        line = str_line.split("\r\n");
        ln = line.length;

        if(ln == 5 && event.keyCode == 13){
            event.returnValue = false;
        }
    }

    /**
    * Hidden IBSheet를 조회하고 나서 처리할 사항
    */
    function demInfo_OnSearchEnd(sheetObj){
	 //Wait Image Show Hidden
        ComOpenWait(false);
    }

    /**
    * Hidden IBSheet를 조회하고 나서 처리할 사항
    */
    function demDtl_OnSearchEnd(sheetObj){

        var invTotBilAmt = 0;

        //컨테이너 정보의 첫 번째 컨테이너 번호
        var fist_cntr_no = sheetObjects[demInfo].CellValue(1, "demInfo_cntr_no");

        for(var idx=1; idx <= sheetObj.RowCount; idx++){
            //INVOICE 정보 중 첫 번째 컨테이너 번호에 매치 되는 해당 정보만 보이도록  나머지 로우는 히든 처리
            if(fist_cntr_no != sheetObjects[demDtl].CellValue(idx, "demDtl_cntr_no")){
                sheetObjects[demDtl].RowHidden(idx) = true;
            }
//          invTotBilAmt += parseInt(sheetObjects[demDtl].CellValue(idx, "demDtl_bil_amt"));
        }
//       document.getElementById("invTotBilAmt").value = invTotBilAmt;
   }

    /**
    * Grid의 OnClick 이벤트가 발생하면 처리 할 사항 : 클릭 된 컨테이너 번호에 해당하는 INVOICE 정보를 보여준다.
    */
   function demInfo_OnDblClick(sheetObj, row, col){

       //컨테이너 정보의 첫 번째 컨테이너 번호
       var click_cntr_no = sheetObj.CellValue(row, "demInfo_cntr_no");

       /* 팝업 분기로 로직 필요 없음 2009-12-08 임진영
       for(var idx=1; idx <= sheetObjects["demDtl"].RowCount; idx++){
           //INVOICE 정보 중 첫 번째 컨테이너 번호에 매치 되는 해당 정보만 보이도록  나머지 로우는 히든 처리
           if(click_cntr_no != sheetObjects["demDtl"].CellValue(idx, "demDtl_cntr_no")){
               sheetObjects["demDtl"].RowHidden(idx) = true;
           }else{
               sheetObjects["demDtl"].RowHidden(idx) = false;
           }
       }
       */

       //클릭 시 상세 팝업 호출
       demDtlPopOpen(click_cntr_no);
   }

    /**
     * DEM.DET 상세 정보 팝업
     */
    function demDtlPopOpen(cntr_no){
        var sXml = IBS_GetDataSearchXml(sheetObjects[demDtl]);
        document.form.demDtlXmlData.value = sXml;

        var condition = "?";
            condition += "cntr_no="+cntr_no;
//        ComOpenWindow('/hanjin/ESM_BKG_1072.do'+condition, 'demDtl', 'width=500,height=225');
        ComOpenWindowCenter('/hanjin/ESM_BKG_1072.do'+condition, 'demDtl', 500, 275, true);
    }

    function fnQueryExec(bkg_no) {
    	if (bkg_no != "") {
     		document.form.bkg_no.value = bkg_no;
     		fnSearch();
        }
    }
    /* 개발자 작업  끝 */