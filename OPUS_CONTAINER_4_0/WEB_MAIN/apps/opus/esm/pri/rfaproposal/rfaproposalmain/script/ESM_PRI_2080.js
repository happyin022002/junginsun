/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2080.js
*@FileTitle  : RFA Proposal Creation [G/L Copy]
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/25
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
     * @class ESM_PRI_2080 : ESM_PRI_2080 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    /* 개발자 작업   */
    // 공통전역변수
    var sheetObjects=new Array();
    var sheetCnt=0;
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
    document.onclick=processButtonClick;
    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2009.10.09
     */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObj=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
                case "btn_OK":
                    doActionIBSheet(sheetObject1, formObj, IBSAVE);
                    break;
                case "btn_Close":
                	ComClosePopup(); 
                    break;
                case "btn_CheckAll":
                    var ele=formObj.elements;
                    var re=new RegExp();
                    var ename=null;
                    var isval=false;
                    re.compile("._chk$");
                    for (var i=0, n=ele.length; i < n; i++) {
                        if (ele.item(i).disabled) {
                            continue;
                        }
                        ename=ele.item(i).getAttribute("name")
                        if (re.test(ename)) {
                            formObj[ename].checked=true;
                        }
                    }
                    break;
                case "btn_UnCheckAll":
                    var ele=formObj.elements;
                    var re=new RegExp();
                    var ename=null;
                    re.compile("._chk$");
                    for (var i=0, n=ele.length; i < n; i++) {
                        if (ele.item(i).disabled) {
                            continue;
                        }
                        ename=ele.item(i).getAttribute("name")
                        if (re.test(ename)) {
                            formObj[ename].checked=false;
                        }
                    }
                    break;
                case "frm_rate_chk":
                    if (formObj.frm_rate_chk.checked) {
                    	if (!formObj.frm_loc_chk.disabled && sheetObject1.GetCellValue(1, "rt_loc_cnt") == "1") {
                            sheetObject1.SetCellValue(1, "loc_chk",1,0);
                            formObj.frm_loc_chk.checked=true;
                        }
                    	if (!formObj.frm_cmdt_chk.disabled && sheetObject1.GetCellValue(1, "rt_cmdt_cnt") == "1") {
                            sheetObject1.SetCellValue(1, "cmdt_chk",1,0);
                            formObj.frm_cmdt_chk.checked=true;
                        }
                    }
                    break;
                case "frm_arb_org_chk":
                    if (formObj.frm_arb_org_chk.checked) {
                    	if (!formObj.frm_loc_chk.disabled && sheetObject1.GetCellValue(1, "ao_loc_cnt") == "1") {
                            sheetObject1.SetCellValue(1, "loc_chk",1,0);
                            formObj.frm_loc_chk.checked=true;
                        }
                    }
                    break;
                case "frm_arb_des_chk":
                    if (formObj.frm_arb_des_chk.checked) {
                    	if (!formObj.frm_loc_chk.disabled && sheetObject1.GetCellValue(1, "ad_loc_cnt") == "1") {
                            sheetObject1.SetCellValue(1, "loc_chk",1,0);
                            formObj.frm_loc_chk.checked=true;
                        }
                    }
                    break;
                case "frm_loc_chk":
                    if (!formObj.frm_loc_chk.checked) {
                    	if (formObj.frm_rate_chk.checked && sheetObject1.GetCellValue(1, "rt_loc_cnt") == "1") {
                            sheetObject1.SetCellValue(1, "rate_chk",0,0);
                            formObj.frm_rate_chk.checked=false;
                        }
                    	if (formObj.frm_arb_org_chk.checked && sheetObject1.GetCellValue(1, "ao_loc_cnt") == "1") {
                            sheetObject1.SetCellValue(1, "arb_org_chk",0,0);
                            formObj.frm_arb_org_chk.checked=false;
                        }
                    	if (formObj.frm_arb_des_chk.checked && sheetObject1.GetCellValue(1, "ad_loc_cnt") == "1") {
                            sheetObject1.SetCellValue(1, "arb_des_chk",0,0);
                            formObj.frm_arb_des_chk.checked=false;
                        }
                    }
                    break;
                case "frm_cmdt_chk":
                    if (!formObj.frm_cmdt_chk.checked) {
                    	if (formObj.frm_rate_chk.checked && sheetObject1.GetCellValue(1, "rt_cmdt_cnt") == "1") {
                            sheetObject1.SetCellValue(1, "rate_chk",0,0);
                            formObj.frm_rate_chk.checked=false;
                        }
                    }
                    break;
            } // end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
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
     * @param {ibsheet} sheet_obj 필수 IBSheet Object
     * @return 없음
     * @author 문동규
     * @version 2009.10.09
     */
    function setSheetObject (sheet_obj) {
        sheetObjects[sheetCnt++]=sheet_obj;
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
     * @version 2009.10.09
     */
    function loadPage () {
        try {
            for (i=0; i < sheetObjects.length; i++) {
                ComConfigSheet(sheetObjects[i]);
                initSheet(sheetObjects[i], i + 1);
                ComEndConfigSheet(sheetObjects[i]);
            }
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        } catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        } finally {
            ComOpenWait(false);
        }
    }
    function initSheet (sheetObj, sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch (sheetID) {
            case "sheet1":  // hidden
                with(sheetObj){
                
			            //  if (location.hostname != "")
			              var HeadTitle="flag|Group\nLocation|Group\nCommodity|Origin\nArbitrary|Destination\nArbitrary|Rate|rt_cmdt_cnt|rt_loc_cnt|ao_loc_cnt|ad_loc_cnt";
			              var headCount=ComCountHeadTitle(HeadTitle);
			              //(headCount, 0, 0, true);
			
			              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			
			              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			              var headers = [ { Text:HeadTitle, Align:"Center"} ];
			              InitHeaders(headers, info);
			
			              var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"loc_chk" },
			                     {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cmdt_chk" },
			                     {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"arb_org_chk" },
			                     {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"arb_des_chk" },
			                     {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rate_chk" },
			                     {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rt_cmdt_cnt" },
			                     {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rt_loc_cnt" },
			                     {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ao_loc_cnt" },
			                     {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ad_loc_cnt" } ];
			               
			              InitColumns(cols);
			
			              SetEditable(1);
			              SetWaitImageVisible(0);
			              SetVisible(false);
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
     * @author 문동규
     * @version 2009.10.09
     */
    function doActionIBSheet (sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg(false);
        switch (sAction) {
            case IBSEARCH: // 조회
                ComOpenWait(true);
                formObj.f_cmd.value=SEARCH;
                 sheetObj.DoSearch("ESM_PRI_2080GS.do", FormQueryString(formObj) );
                ComOpenWait(false);
                break;
            case IBSAVE: // 저장
                ComOpenWait(true);
                if (!validateForm(sheetObj, formObj, sAction)) {
                    return;
                }
                if (!ComShowCodeConfirm('PRI00012')) {
                    return;
                }
                var ele=formObj.elements;
                var re=new RegExp();
                var ename=null;
                re.compile("._chk$");
                for (var i=0, n=ele.length; i < n; i++) {
                    if (ele.item(i).disabled) {
                        continue;
                    }
                    ename=ele.item(i).getAttribute("name")
                    if (re.test(ename)) {
                        sheetObj.SetCellValue(1, ename.replace("frm_",""), (ele.item(i).checked) ? "1" : "0");
                        sheetObj.SetCellValue(1, "ibflag", "U");
                        
                    }
                }
                formObj.f_cmd.value=MULTI;
                sheetObj.DoSave("ESM_PRI_2080GS.do", FormQueryString(formObj));
                ComOpenWait(false);
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
     * @author 문동규
     * @version 2009.05.20
     */
    function sheet1_OnSearchEnd (sheetObj, errMsg) {
        if (sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
            var colname;
            var b=false;
            var formObj=document.form;
            var re=new RegExp();
            re.compile("._chk$");
            for (var i=0, n=sheetObj.LastCol(); i <= n ;i++) {
                colname=sheetObj.ColSaveName(i);
                if (re.test(colname)) {
                	b=(sheetObj.GetCellValue(1, colname) == 0);
                    if (sheetObj.RowCount()<= 0) {
                        b=true;
                    }
                    if (formObj['frm_'+colname] != null) {
                        if (b) {
                            formObj['frm_'+colname].disabled=true;
                        } else {
                            formObj['frm_'+colname].checked=true;
                        }
                    }
                }
            }
            if (sheetObj.RowCount()> 0) {
                sheetObj.SetRowStatus(1,"R");
            }
        }
    }
    function validateForm (sheetObj, formObj, sAction) {
        with (sheetObj) {
            switch (sAction) {
                case IBSAVE:
                    var b=false;
                    var ele=formObj.elements;
                    var re=new RegExp();
                    var ename=null;
                    re.compile("._chk$");
                    for (var i=0, n=ele.length; i < n; i++) {
                        if (ele.item(i).disabled) {
                            continue;
                        }
                        ename=ele.item(i).getAttribute("name")
                        if (re.test(ename)) {
                            if (ele.item(i).checked) {
                                b=true;
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
    function sheet1_OnSaveEnd (sheetObj, errMsg) {
        if (sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
            ComPopUpReturnValue("OK");
        }
    }
    /* 개발자 작업  끝 */
