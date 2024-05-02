/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : ESM_PRI_3019.js
 *@FileTitle : TAA Creation & Amendment View
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.08.08
 *@LastModifier : 서미진
 *@LastVersion : 1.0
 * 2011.08.08 서미진
 * 1.0 Creation
* ===========================================================
* History
* 2013.09.05 전윤주 [CHM-201326372] Autorating 결과 계약 조회시 편의 기능 구현
	                            - Autorating 에서 사용된 commodity, Route 일 경우 색 변경해줌
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
     * @class ESM_PRI_3019 : ESM_PRI_3019 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_3019 () {
        this.processButtonClick = tprocessButtonClick;
        this.setSheetObject = setSheetObject;
        this.loadPage = loadPage;
        this.initSheet = initSheet;
        this.initControl = initControl;
        this.doActionIBSheet = doActionIBSheet;
        this.setTabObject = setTabObject;
        this.validateForm = validateForm;
    }

    /* 개발자 작업   */

    // 공통전역변수

    var sheetObjects = new Array();
    var sheetCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
    document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2009.11.20
     */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

        var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];

        /*******************************************************/
        var formObj = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");
            if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {
                if (getButtonTable(srcName).disabled) {
                    return false;
                }
            }

            switch(srcName) {

				case "btn_Close":  
					window.close();
				break;

            } // end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        } finally {
            ComOpenWait(false);
        }
    }

    /**
     * IBSheet Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj 필수, IBSheet Object
     * @return 없음
     * @author 문동규
     * @version 2009.11.20
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * Sheet 기본 설정 및 초기화 <br>
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     loadPage();
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2009.11.20
     */
    function loadPage() {
    	var formObj = document.form;
    	
        try {
            for(i=0;i<sheetObjects.length;i++){
                //khlee-시작 환경 설정 함수 이름 변경
                ComConfigSheet (sheetObjects[i] );
    
                initSheet(sheetObjects[i],i+1);
                //khlee-마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);
            }
            
            doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);

        } catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        } finally {
            ComOpenWait(false);
        }
    }

    /**
     * 시트 초기설정값, 헤더 정의 <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {int} sheetNo 필수, IBSheet Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 문동규
     * @version 2009.11.20
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
        var sheetID = sheetObj.id;

        switch(sheetID) {
            case "sheet1":  // hidden
                with (sheetObj) {
                    // 높이 설정
                    style.height = 150;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    var HeadTitle = "|TAA No|TAA Proposal No|Amdt Seq|Service Scope|Service Scope Name|Effective Date|Expire Date|Ctrt Cust Seq|Ctrt Cust Cnt Cd|prc-ctrt_cust_tp_cd|ctrt_cust_nm|ctrt_cust_val_sgm_cd|respb_srep_cd|respb_srep_nm|respb_sls_ofc_cd|cfm_flg|cfm_nm";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 6, 100);

                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    InitHeadRow(1, HeadTitle1, true);

                    // 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,30,  daCenter,   true,  "ibflag");
                    InitDataProperty(0, cnt++ , dtData,        40,  daCenter,   true,   "taa_no",               false, "",dfNone,    0,  true,   true);
                    InitDataProperty(0, cnt++ , dtData,        40,  daCenter,   true,   "taa_prop_no",          false, "",dfNone,    0,  true,   true);
                    InitDataProperty(0, cnt++ , dtData,        20,  daCenter,   true,   "amdt_seq",             false, "",dfNone,    0,  true,   true);
                    InitDataProperty(0, cnt++ , dtData,        50,  daCenter,   true,   "svc_scp_cd",           true,  "",dfNone,    0,  true,   true);
                    InitDataProperty(0, cnt++ , dtData,        50,  daCenter,   true,   "svc_scp_nm",           false, "",dfNone,    0,  true,   true);
                    InitDataProperty(0, cnt++ , dtData,        70,  daCenter,   true,   "eff_dt",               true,  "",dfDateYmd, 0,  true,   true);
                    InitDataProperty(0, cnt++ , dtData,        70,  daCenter,   true,   "exp_dt",               true,  "",dfDateYmd, 0,  true,   true);
                    InitDataProperty(0, cnt++ , dtData,        70,  daCenter,   true,   "ctrt_cust_seq",        true,  "",dfNone,    0,  true,   true);
                    InitDataProperty(0, cnt++ , dtData,        40,  daLeft,     true,   "ctrt_cust_cnt_cd",     true,  "",dfNone,    0,  true,   true);
                    InitDataProperty(0, cnt++ , dtData,        40,  daCenter,   true,   "prc_ctrt_cust_tp_cd",  false, "",dfNone,    0,  false,  true);
                    InitDataProperty(0, cnt++ , dtData,        40,  daCenter,   true,   "ctrt_cust_nm",         false, "",dfNone,    0,  false,  true);
                    InitDataProperty(0, cnt++ , dtData,        85,  daCenter,   true,   "ctrt_cust_val_sgm_cd", false, "",dfNone,    0,  false,  true);
                    InitDataProperty(0, cnt++ , dtData,        50,  daCenter,   true,   "respb_srep_cd",        false, "",dfNone,    0,  false,  true);
                    InitDataProperty(0, cnt++ , dtData,        50,  daCenter,   true,   "respb_srep_nm",        false, "",dfNone,    0,  false,  true);
                    InitDataProperty(0, cnt++ , dtData,        70,  daCenter,   true,   "respb_sls_ofc_cd",     false, "",dfNone,    0,  false,  true);
                    InitDataProperty(0, cnt++ , dtPopup,       70,  daCenter,   true,   "cfm_flg",              false, "",dfNone,    0,  false,  true);
                    InitDataProperty(0, cnt++ , dtPopup,       70,  daCenter,   true,   "cfm_nm",               false, "",dfNone,    0,  false,  true);
                    WaitImageVisible = false;

                    Visible = false;
                }
                break;

            case "sheet2":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 246;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    var HeadTitle = "|Seq.|taa_prop_no|amdt_seq|tri_prop_no|Tariff Rate Item\n(TRI)|Commodity|Commodity|Route|Route|Route|Route|Route nm|Route nm|Route nm|Route nm|Per|CGO\nType|Cur.|Rate|Note|note_conv_mapg_id|Duration|Duration|trf_pfx_cd|trf_no";
                    var HeadTitle1 = "|Seq.|taa_prop_no|amdt_seq|tri_prop_no|Tariff Rate Item\n(TRI)|Code|Description|Origin|Origin Via|Dest Via|Dest|Origin Nm|Origin Via Nm|Dest Via Nm|Dest Nm|Per|CGO\nType|Cur.|Rate|Note|note_conv_mapg_id|Effective|Expiration|trf_pfx_cd|trf_no";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1, 6, 100);

                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    InitHeadRow(1, HeadTitle1, true);

                    // 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,30,  daCenter, false, "ibflag");
//                    InitDataProperty(0, cnt++ , dtCheckBox,    50,  daCenter, true,  "chk",               false,  "",dfNone,   0,    true,   true);
                    InitDataProperty(0, cnt++ , dtDataSeq,     30,  daCenter, true,  "seq",               false,  "",dfNone,   0,    false,  false);
                    InitDataProperty(0, cnt++ , dtHidden,      10,  daCenter, true,  "taa_prop_no",       false,  "",dfNone,   0,    false,  false);  // Hidden
                    InitDataProperty(0, cnt++ , dtHidden,      10,  daCenter, true,  "amdt_seq",          false,  "",dfNone,   0,    false,  false);  // Hidden
                    InitDataProperty(0, cnt++ , dtHidden,      10,  daCenter, true,  "tri_prop_no",       true,   "",dfNone,   0,    false,  false);
                    InitDataProperty(0, cnt++ , dtData,        115, daCenter, true,  "tri_no",            false,   "",dfUserFormat,   0,    false,  false);
                    InitDataProperty(0, cnt++ , dtData,        50,  daCenter, true,  "cmdt_cd",           false,  "",dfNone,   0,    false,  false);
                    InitDataProperty(0, cnt++ , dtData,        120, daLeft,   true,  "cmdt_nm",           false,  "",dfNone,   0,    false,  false);

                    InitDataProperty(0, cnt++ , dtData,        108, daLeft,   true,  "org_pnt_loc_cd",    false,  "",dfNone,   0,    false,  false);
                    InitDataProperty(0, cnt++ , dtData,        60,  daLeft,   true,  "org_via_port_cd",   false,  "",dfNone,   0,    false,  false);
                    InitDataProperty(0, cnt++ , dtData,        60,  daLeft,   true,  "dest_via_port_cd",  false,  "",dfNone,   0,    false,  false);
                    InitDataProperty(0, cnt++ , dtData,        108, daLeft,   true,  "dest_pnt_loc_cd",   false,  "",dfNone,   0,    false,  false);

                    InitDataProperty(0, cnt++ , dtHidden,      120, daLeft,   true,  "org_pnt_loc_nm",    false,  "",dfNone,   0,    false,  false);
                    InitDataProperty(0, cnt++ , dtHidden,      70,  daLeft,   true,  "org_via_port_nm",   false,  "",dfNone,   0,    false,  false);
                    InitDataProperty(0, cnt++ , dtHidden,      70,  daLeft,   true,  "dest_via_port_nm",  false,  "",dfNone,   0,    false,  false);
                    InitDataProperty(0, cnt++ , dtHidden,      120, daLeft,   true,  "dest_pnt_loc_nm",   false,  "",dfNone,   0,    false,  false);

                    InitDataProperty(0, cnt++ , dtData,        35,  daCenter, true,  "rat_ut_cd",         false,  "",dfNone,   0,    false,  false);
                    InitDataProperty(0, cnt++ , dtData,        40,  daCenter, true,  "prc_cgo_tp_cd",     false,  "",dfNone,   0,    false,  false);
                    InitDataProperty(0, cnt++ , dtData,        38,  daCenter, true,  "curr_cd",           false,  "",dfNone,   0,    false,  false);
                    InitDataProperty(0, cnt++ , dtData,        62,  daRight,  true,  "fnl_frt_rt_amt",    false,  "",dfFloat,  0,    false,  false);

                    InitDataProperty(0, cnt++ , dtPopup,       70,  daLeft,   true,  "note_ctnt",         false,  "",dfNone,   0,   true,   true);
                    InitDataProperty(0, cnt++ , dtHidden,      70,  daLeft,   true,  "note_conv_mapg_id", false,  "",dfNone,   0,    false,  false);    // Hidden
                    InitDataProperty(0, cnt++ , dtData,        65,  daCenter, true,  "eff_dt",            false,  "",dfDateYmd,0,    false,  false);
                    InitDataProperty(0, cnt++ , dtData,        65,  daCenter, true,  "exp_dt",            false,  "",dfDateYmd,0,    false,  false);

                    InitDataProperty(0, cnt++ , dtHidden,      70,  daLeft,   true,  "trf_pfx_cd",        false,  "",dfNone,   0,    false,  false);    // Hidden
                    InitDataProperty(0, cnt++ , dtHidden,      70,  daLeft,   true,  "trf_no",            false,  "",dfNone,   0,    false,  false);    // Hidden
                    WaitImageVisible = false;
                    Ellipsis = true;
                    AutoRowHeight = false;

                    InitUserFormat(0, "tri_no", "######-####-###", "-");
                    ShowButtonImage = 2;
                    CountPosition = 0;
                }
                break;
        }
    }


    /**
     * Sheet관련 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {form} formObj 필수, html form object
     * @param {int} sAction 필수, 프로세스 플래그 상수
     * @return 없음
     * @author 문동규
     * @version 2009.11.20
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

            case IBSEARCH:      // Retrieve
                ComOpenWait(true);

                // Route Name 항목을 Clear
                formObj.org_pnt_loc_nm.value = "";
                formObj.org_via_port_nm.value = "";
                formObj.dest_via_port_nm.value = "";
                formObj.dest_pnt_loc_nm.value = "";
                
                formObj.f_cmd.value = SEARCH;
                var sXml = sheetObj.GetSearchXml("ESM_PRI_3019GS.do" , FormQueryString(formObj));
                var arrXml = sXml.split("|$$|");
                if (arrXml.length > 0) {
                    sheetObjects[0].LoadSearchXml(arrXml[0]);    // sheet1. hidden sheet - main 데이터
                }
                if (arrXml.length > 1) {
                    sheetObjects[1].LoadSearchXml(arrXml[1]);
                }
                ComOpenWait(false);
                break;
        }
    }

    /**
     * OnSelectCell 이벤트 발생시 호출되는 function <br>
     * 선택한 TRI 목록에 해당하는 Route Name을 보여준다.<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {int} OldRow 필수, 이전에 선택된 셀의 Row Index
     * @param {int} OldCol 필수, 이전에 선택된 셀의 Column Index
     * @param {int} NewRow 필수, 현재 선택된 셀의 Row Index
     * @param {int} NewCol 필수, 현재 선택된 셀의 Column Index
     * @return 없음
     * @author 문동규
     * @version 2009.11.30
     */
    function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
         if(sheetObj.CellValue(NewRow,"tri_prop_no")!="" && OldRow != NewRow){
            var formObj = document.form;
            formObj.org_pnt_loc_nm.value = sheetObj.CellValue(NewRow, "org_pnt_loc_nm").replace(/\|/g, "\n");
            formObj.org_via_port_nm.value = sheetObj.CellValue(NewRow, "org_via_port_nm").replace(/\|/g, "\n");
            formObj.dest_via_port_nm.value = sheetObj.CellValue(NewRow, "dest_via_port_nm").replace(/\|/g, "\n");
            formObj.dest_pnt_loc_nm.value = sheetObj.CellValue(NewRow, "dest_pnt_loc_nm").replace(/\|/g, "\n");
        }
    }
    
    /**
     * OnPopupClick 이벤트 발생시 호출되는 function <br>
     * Note Conversion Popup 을 호출한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {int} Row 필수, OnPopupClick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수, OnPopupClick 이벤트가 발생한 해당 셀의 Column Index
     * @return 없음
     * @author 문동규
     * @version 2009.12.07
     */      
    function sheet2_OnPopupClick(sheetObj, Row, Col) {
        var colName = sheetObj.ColSaveName(Col);
        var formObj = document.form;

        switch(colName) {
            case "note_ctnt":
                var sParam = "";
                sParam += "note_conv_mapg_id=" + sheetObj.CellValue(Row, "note_conv_mapg_id");
                sParam += "&note_ctnt="+ encodeURIComponent(sheetObj.CellValue(Row, "note_ctnt"));
                var sUrl = "/hanjin/ESM_PRI_3003.do?" + sParam;
                var rtnVal = ComPriOpenWindowCenter(sUrl, window, 800, 535, true);
                break;
        }
    }

    /**
     * OnSearchEnd 이벤트 발생시 호출되는 function <br>
     * Sheet 조회 완료 후 form 에 데이터를 보여줌 <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {string} ErrMsg 선택, 조회 후 메세지
     * @returns 없음
     * @author 문동규
     * @version 2009.11.30
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        if (sheetObj.RowCount == 0) {
            doActionIBSheet(sheetObj, document.form, IBCREATE);
            return;
        } else {
            var formObj = document.form;
            ComPriCopyRowToForm(sheetObj, formObj, 1);
            formObj.ctrt_cust_seq.value = ComLpad(sheetObj.CellValue(1, "ctrt_cust_seq"), 6, "0");
            formObj.eff_dt.value = sheetObj.CellText(1, "eff_dt");
            formObj.exp_dt.value = sheetObj.CellText(1, "exp_dt");
            formObj.old_svc_scp_cd.value = sheetObj.CellValue(1, "svc_scp_cd");
            formObj.taa_prop_no.value = sheetObj.CellValue(1, "taa_prop_no");
        }
        
        
    }

    /**
     * OnSearchEnd 이벤트 발생시 호출되는 function <br>
     * Sheet 조회 완료 후 Note Content 를 Tooltip 적용 <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {string} ErrMsg 선택, 조회 후 메세지
     * @returns 없음
     * @author 문동규
     * @version 2009.12.02
     */
    function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
        var formObj = document.form;
        
        for (var i = sheetObj.HeaderRows, n = sheetObj.HeaderRows + sheetObj.RowCount ; i < n ; i++) {
            sheetObj.ToolTipText(i, "note_ctnt") = sheetObj.CellValue(i, "note_ctnt");
        }
        
        //Autorating 에서 인자를 받아 색으로 표시해줌
        var m = sheetObj.LastCol;
    	var j = 0;

    	for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) { 
    		if (sheetObj.CellValue(i, "tri_no") == formObj.s_tri_no_clr.value) {
    			for (j = 0; j < m; j++) {
    				sheetObj.CellBackColor(i, j) = sheetObj.RgbColor(255,192,203);
    			}
    		}
    	}
    }


    /* 개발자 작업  끝 */