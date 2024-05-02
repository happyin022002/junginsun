/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6008.js
*@FileTitle : S/C Quotation Rate Creation - G/L Copy Option
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.06.19 이승준
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
     * @extends Pri
     * @class ESM_PRI_6008 : ESM_PRI_6008 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_6008() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.setTabObject           = setTabObject;
        this.validateForm           = validateForm;
    }

    /* 개발자 작업   */


    // 공통전역변수
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return 없음
     * @author 이승준
     * @version 2009.08.21
     */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

        var sheetObject1 = sheetObjects[0];

        /*******************************************************/
        var formObj = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {


                case "btn_OK":
                    if (ComShowCodeConfirm('PRI03006')) {
                        doActionIBSheet(sheetObject1, formObj, IBSAVE);
                    }
                    break;

                case "btn_Close":
                    window.close();
                    break;

                case "btn_CheckAll":
                    var ele = formObj.elements;
                    var re = new RegExp();
                    var ename = null;
                    re.compile("._chk$");
                    for (var i = 0, n = ele.length; i < n; i++) {
                        if (ele.item(i).disabled) {
                            continue;
                        }
                        ename = ele.item(i).getAttribute("name")
                        if (re.test(ename)) {
                            formObj[ename].checked = true;
                        }
                    }
                    if (formObj.svc_scp_cd.value == "TPW") {
                        openCommodityGroupTpw();
                    }
                    break;

                case "btn_UnCheckAll":
                    var ele = formObj.elements;
                    var re = new RegExp();
                    var ename = null;
                    re.compile("._chk$");
                    for (var i = 0, n = ele.length; i < n; i++) {
                        if (ele.item(i).disabled) {
                            continue;
                        }
                        ename = ele.item(i).getAttribute("name")
                        if (re.test(ename)) {
                            formObj[ename].checked = false;
                        }
                    }
                    if (formObj.svc_scp_cd.value == "TPW") {
                        formObj.cmdt_tpw_mst.value = "";
                        formObj.cmdt_tpw_dtl.value = "";
                    }
                    break;
                    
                case "frm_cmdt_tpw_chk":
                    // Commodity(TPW) Group Check
                    if (formObj.frm_cmdt_tpw_chk.checked) {
                        openCommodityGroupTpw();
                    } else {
                        formObj.frm_rate_chk.checked = false;
                        formObj.cmdt_tpw_mst.value = "";
                        formObj.cmdt_tpw_dtl.value = "";
                    }
                    break;

                case "frm_rate_chk":
                    if (formObj.frm_rate_chk.checked) {
                        formObj.frm_loc_chk.checked = true;
                        if (formObj.svc_scp_cd.value == "TPW") {
                            formObj.frm_cmdt_tpw_chk.checked = true;
                            openCommodityGroupTpw();
                        } else {
                            formObj.frm_cmdt_chk.checked = true;
                        }
                    }
                    break;

                case "frm_cmdt_chk":
                    if (!formObj.frm_cmdt_chk.checked) {
                        formObj.frm_rate_chk.checked = false;
                    }
                    break;
                    
                case "frm_loc_chk":
                    if (!formObj.frm_loc_chk.checked) {
                        formObj.frm_rate_chk.checked = false;
                    }
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
     * IBSheet Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj 필수 IBSheet Object
     * @return 없음
     * @author 이승준
     * @version 2009.08.21
     */
    function setSheetObject (sheet_obj) {
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
     * @author 이승준
     * @version 2009.08.21
     */
    function loadPage () {
    
        for (i = 0; i < sheetObjects.length; i++) {
            ComConfigSheet(sheetObjects[i]);
    
            initSheet(sheetObjects[i], i + 1);
    
            ComEndConfigSheet(sheetObjects[i]);
        }
    
        document.form.estm_mqc_qty.value = ComGetUnMaskedValue(document.form.estm_mqc_qty.value, "int");
        
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    
    }
    
    /**
     * 시트 초기설정값, 헤더 정의 <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 이승준
     * @version 2009.08.21
     */
    function initSheet (sheetObj, sheetNo) {
    
        var cnt = 0;
        var sheetID = sheetObj.id;
        switch (sheetID) {
    
            case "sheet1":
                with (sheetObj) {
    
                    // 높이 설정
//                    style.height = 130;
                    style.height = 0;
    
                    //전체 너비 설정
                    SheetWidth = 600;
    
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "")
                        InitHostInfo(location.hostname, location.port, page_path);
    
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;
    
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;
    
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);
    
//                    var HeadTitle = "flag|Group\nLocation|Group\nCommodity|Group\nCommodity TPW|Rate|qttn_no|qttn_ver_no|cmdt_tpw_mst|cmdt_tpw_dtl";
                    
                    var HeadTitle = "flag|Group\nLocation|Group\nCommodity|Group\nCommodity TPW|Rate";
                    var headCount = ComCountHeadTitle(HeadTitle);
    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
    
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);
    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
    
                    // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN,
                    // COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT,
                    // POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT,
                    // SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 50, daCenter, false, "ibflag");
                    InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "loc_chk");
                    InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "cmdt_chk");
                    InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "cmdt_tpw_chk");
                    InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "rate_chk");
//                    InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "qttn_no");
//                    InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "qttn_ver_no");
//                    InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "cmdt_tpw_mst");
//                    InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "cmdt_tpw_dtl");
                    WaitImageVisible = false;
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
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {form} formObj 필수 html form object
     * @param {int} sAction 필수 프로세스 플래그 상수
     * @return 없음
     * @author 이승준
     * @version 2009.08.21
     */
    function doActionIBSheet (sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;
        switch (sAction) {
            case IBSEARCH: // 조회
            	try {
            		ComOpenWait(true);
	                formObj.f_cmd.value = SEARCH03;
	                sheetObj.doSearch("ESM_PRI_6005GS.do", FormQueryString(formObj));
	                ComOpenWait(false);

            	} catch (e) {
            	    if (e == "[object Error]") {
            	        ComShowMessage(OBJECT_ERROR);
            	    } else {
            	        ComShowMessage(e);
            	    }
            	} finally {
            	   ComOpenWait(false);
            	}
                break;

            case IBSAVE: // 저장
                if (!validateForm(sheetObj, formObj, sAction)) {
                    return;
                }

                var ele = formObj.elements;
                var re = new RegExp();
                var ename = null;
                re.compile("._chk$");
                for (var i = 0, n = ele.length; i < n; i++) {
                    if (ele.item(i).disabled) {
                        continue;
                    }
                    ename = ele.item(i).getAttribute("name")
                    if (re.test(ename)) {
                        sheetObj.CellValue2(1, ename.replace("frm_","")) = (ele.item(i).checked) ? "2" : "1";
                    }
                }
                
                try {
            		ComOpenWait(true);
	                formObj.f_cmd.value = MULTI01;
	                sheetObj.doSave("ESM_PRI_6008GS.do", FormQueryString(formObj),-1,false);
	                ComOpenWait(false);

                } catch (e) {
                    if (e == "[object Error]") {
                        ComShowMessage(OBJECT_ERROR);
                    } else {
                        ComShowMessage(e);
                    }
                } finally {
                   ComOpenWait(false);
                }
                
                window.returnValue = "OK";
               
//                ComShowCodeMessage('PRI00110');
//                window.returnValue = "OK";
//                dialogArguments.setTabStyle();
//                dialogArguments.loadTabPage();
//                window.close();

                break;
        }
    }
    
    /**
     * OnSearchEnd 이벤트 발생시 호출되는 function <br>
     * 데이터가 없는 항목은 선택을 못하게 한다.<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @author 이승준
     * @version 2009.05.20
     */
    function sheet1_OnSearchEnd (sheetObj, errMsg) {
        if (errMsg == "") {
            
            var colname;
            var b = false;
            var formObj = document.form;
            var re = new RegExp();
            re.compile("._chk$");

            for (var i = 0, n = sheetObj.LastCol; i <= n ;i++) {
                colname = sheetObj.ColSaveName(i);
                if (re.test(colname)) {
//                    if (sheetObj.RowCount <= 0) {
//                        return;
//                    }
//                    if (sheetObj.CellValue(1, colname) == 0) {
//                        formObj['frm_'+colname].disabled = true;
//                    }

                    b = (sheetObj.CellValue(1, colname) == 0);
                    if (sheetObj.RowCount <= 0) {
                        b = true;
                    }

                    if (b) {
                        formObj['frm_'+colname].disabled = true;
                    }
                }
            }

            if (formObj.svc_scp_cd.value == "TPW") {
                formObj.frm_cmdt_chk.disabled = true;
                sheetObj.CellValue(1, "cmdt_chk") = 0;
            } else {
                formObj.frm_cmdt_tpw_chk.disabled = true;
                sheetObj.CellValue(1, "cmdt_tpw_chk") = 0;
            }
            if (sheetObj.RowCount > 0) {
                sheetObj.RowStatus(1) = "R";
            }
        }
    }
    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     if (validateForm(sheetObj,document.form,IBSAVE)) {
     *         로직처리;
     *     }
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {form} formObj 필수 html form object
     * @param {int} sAction 필수 프로세스 플래그 상수
     * @returns bool <br>
     *          true  : 폼입력값이 유효할 경우<br>
     *          false : 폼입력값이 유효하지 않을 경우
     * @author 이승준
     * @version 2009.08.21
     */
    function validateForm (sheetObj, formObj, sAction) {
        with (sheetObj) {
            switch (sAction) {
                case IBSAVE:
                    var b = false;
                    var ele = formObj.elements;
                    var re = new RegExp();
                    var ename = null;
                    re.compile("._chk$");
                    for (var i = 0, n = ele.length; i < n; i++) {
                        if (ele.item(i).disabled) {
                            continue;
                        }
                        ename = ele.item(i).getAttribute("name")
                        if (re.test(ename)) {
                            if (ele.item(i).checked) {
                                b = true;
                                break;
                            }
                        }
                    }

                    if (!b) {
                        ComShowCodeMessage('PRI01043');
                        return false;
                    }
                    break;
            }
        }
    
        return true;
    }
    
    /**
     * OnSaveEnd 이벤트 발생시 호출되는 function <br>
     * 저장 후 로직을 처리한다.<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
    function sheet1_OnSaveEnd (sheetObj, errMsg) {
        if (errMsg == "") {
            ComShowCodeMessage('PRI00110');
            window.returnValue = "OK";
            dialogArguments.setTabStyle();
            dialogArguments.loadTabPage();
            window.close();
        }
    }

    /**
     * Commodity Group (TPW) Popup 을 Open 한다.<br>
     * Popup에서 받은 return 값을 Hidden Field에 넣는다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     openCommodityGroupTpw ();
     * </pre>
     * @return 없음
     * @author 이승준
     * @version 2009.07.01
     */
    function openCommodityGroupTpw () {
    	var formObj = document.form;
    	
        var sUrl = "/hanjin/ESM_PRI_0063.do?svc_scp_cd="+formObj.svc_scp_cd.value;

        sUrl += "&prc_cust_tp_cd="+formObj.prc_cust_tp_cd.value+"&eff_dt="+formObj.eff_dt.value+"&exp_dt="+formObj.exp_dt.value;
        
        var rtnVal = ComPriOpenWindowCenter(sUrl, window, 787, 338, true);
        
        if (rtnVal != null) {
            var master = rtnVal.master;
            var detail = rtnVal.detail;
            var dtlarr = new Array();

            var msb = new StringBuffer();
            var dsb = new StringBuffer();

            // master
            for (var i = 0, n = master.length; i < n; i++) {
                if (i != 0) {
                    msb.append(";");
                }
                msb.append(master[i].svc_scp_cd).append("|");
                msb.append(master[i].gline_seq).append("|");
                msb.append(master[i].prc_cust_tp_cd).append("|");
                msb.append(master[i].grp_cmdt_seq);
            }

            // detail
            for (var i = 0, n = detail.length; i < n; i++) {
                if (i != 0) {
                    dsb.append(",");
                }                                
                dtlarr = new Array();
                dtlarr = detail[i];

                for (var j = 0, k = dtlarr.length; j < k; j++) {

                    if (j != 0) {
                        dsb.append(";");
                    }
                    dsb.append(dtlarr[j].svc_scp_cd).append("|");
                    dsb.append(dtlarr[j].gline_seq).append("|");
                    dsb.append(dtlarr[j].prc_cust_tp_cd).append("|");
                    dsb.append(dtlarr[j].grp_cmdt_seq).append("|");
                    dsb.append(dtlarr[j].grp_cmdt_dtl_seq); 
                }
            }
            
            formObj.cmdt_tpw_mst.value = msb.toString();
            formObj.cmdt_tpw_dtl.value = dsb.toString();
           
        } else {
            formObj.frm_cmdt_tpw_chk.checked = false;
            formObj.cmdt_tpw_mst.value = "";
            formObj.cmdt_tpw_dtl.value = "";
        }

    }

    
    /* 개발자 작업  끝 */