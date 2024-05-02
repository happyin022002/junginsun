/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_PRI_0104.js
*@FileTitle  : Guideline Route Note Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/25
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    var sheetObjects=new Array();
    var sheetCnt=0;
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
    document.onclick=processButtonClick;
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
                case "btn_RowAdd":
                    doActionIBSheet(sheetObject1,formObject,IBINSERT);
                    break;
                case "btn_RowCopy":
                    doActionIBSheet(sheetObject1,formObject,IBCOPYROW);
                    break;
                case "btn_Delete":
                    doActionIBSheet(sheetObject1,formObject,IBDELETE);
                    break;
                case "btn_Ok":
                    doActionIBSheet(sheetObject1,formObject,IBSAVE);
                    // 변경사항이 없을 경우에 창닫기
                    if (!sheetObject1.IsDataModified()) {
//                        window.returnValue="O";
                    	ComPopUpReturnValue("O");
                    }
                    break;
                case "btn_Close":
                	ComClosePopup(); 
                    break;
            } // end switch
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
     * @version 2009.05.20
     */
    function setSheetObject(sheet_obj){
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
     * @version 2009.05.20
     */
    function loadPage() {
    	if (!opener) opener = window.dialogArguments;
   	 	if (!opener) opener = window.opener;
   	 	if (!opener) opener = parent;
   	 
        try {
            for(i=0;i<sheetObjects.length;i++){
                ComConfigSheet (sheetObjects[i] );
                initSheet(sheetObjects[i],i+1);
                ComEndConfigSheet(sheetObjects[i]);
            }
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    		if (document.form.isEditable.value == "false") {
    			sheetObjects[0].SetEditable(0);
    			ComBtnDisable("btn_RowAdd");
    			ComBtnDisable("btn_RowCopy");
    			ComBtnDisable("btn_Delete");
    		}
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
     * @author 문동규
     * @version 2009.05.20
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var sheetId=sheetObj.id;
        switch(sheetId) {
            case "sheet1":
                with(sheetObj){                
	              var HeadTitle1="|Sel|Seq.|||||||Item|Surcharge|Content";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	              (headCount, 0, 0, true);
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1, ComboMaxHeight: 100 } );
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	              InitHeaders(headers, info);
	              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	                     {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"sel_chk" },
	                     {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
	                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
	                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gline_seq" },
	                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cust_tp_cd" },
	                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq" },
	                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq" },
	                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_note_seq" },
	                     {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"note_clss_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"chg_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"note_ctnt",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	               
	              InitColumns(cols);
	              SetEditable(1);
	              SetWaitImageVisible(0);
	              SetColProperty("note_clss_cd", {ComboText:itemComboText, ComboCode:itemComboValue} );
	              SetColProperty("chg_cd", {ComboText:scgComboText, ComboCode:scgComboValue} );
	              SetColHidden("chg_cd",1);
	              SetSheetHeight(170);
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
     * @version 2009.05.20
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:      //조회
                ComOpenWait(true);
                //sheet data를 메인페이지에서 가져온다.
                var sXml=opener.getSheetXml(8);
                sheetObj.LoadSearchData(sXml,{Sync:1} );
                checkSurcharge(sheetObj);
                ComOpenWait(false);
                break;
            case IBSAVE:        //저장
                ComOpenWait(true);
                if(validateForm(sheetObj,formObj,sAction)){
                    var sXml=ComPriSheet2Xml(sheetObj);
                    opener.setSheetXml(sXml, 8);
//                    window.returnValue="O";
                    ComPopUpReturnValue("O");
                }
                ComOpenWait(false);
                break;
            case IBINSERT:      // 입력
                var Row=sheetObj.DataInsert();
                sheetObj.SetCellValue(Row,"svc_scp_cd",formObj.svc_scp_cd.value,0);
                sheetObj.SetCellValue(Row,"gline_seq",formObj.gline_seq.value,0);
                sheetObj.SetCellValue(Row,"prc_cust_tp_cd",formObj.prc_cust_tp_cd.value,0);
                sheetObj.SetCellValue(Row,"cmdt_hdr_seq",formObj.cmdt_hdr_seq.value,0);
                sheetObj.SetCellValue(Row,"rout_seq",formObj.rout_seq.value,0);
                // key 채번                
                sheetObj.SetCellValue(Row,"rout_note_seq",parseInt(ComPriGetMax(sheetObj, "rout_note_seq")) + 1,0);
                break;
            case IBCOPYROW:      // 입력
                var Row=sheetObj.DataCopy();
                // key 채번
                sheetObj.SetCellValue(Row,"rout_note_seq",parseInt(ComPriGetMax(sheetObj, "rout_note_seq")) + 1,0);
                break;
            case IBDELETE:      // 삭제
                deleteRowCheck(sheetObj, "sel_chk", true);
                checkSurcharge(sheetObj);
                break;
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
     * @author 문동규
     * @version 2009.05.20
     */
    function validateForm(sheetObj,formObj,sAction){
        with(sheetObj){
            switch(sAction){
                case IBSAVE:
                    var saveStr=sheetObj.GetSaveString(false);
                    if (saveStr == "") {
                        return false;
                    }
                    var cnt=sheetObj.RowCount();
                    for (var i=1; i <= cnt; i++) {
                    	if (sheetObj.GetCellValue(i, "note_clss_cd") == "S") {
                    		if (ComIsEmpty(sheetObj.GetCellValue(i, "chg_cd"))) {
                                ComShowCodeMessage("PRI08010", i, "Surcharge");
                                sheetObj.SelectCell(i, "chg_cd");
                                return false;
                            }
                        }
                    }
                    break;
            }
        }
        return true;
    }
    /**
     * OnChange 이벤트 발생시 호출되는 function <br>
     * Item ComboBox에서 'Surcharge'가 선택 되었을 경우만 Surcharge 셀을 보여준다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 OnChange 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 OnChange 이벤트가 발생한 해당 셀의 Column Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 문동규
     * @version 2009.05.20
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value) {
        var colname=sheetObj.ColSaveName(Col);
        switch(colname) {
            case "note_clss_cd":
                checkSurcharge(sheetObj);
                break;
        }
    }
    /**
     * Item ComboBox에서 'Surcharge' 선택유무에 따라 Surcharge 셀을 보여주거나 감춘다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     checkSurcharge(sheetObj);
     *     checkSurcharge(sheetObj, "note_clss_cd", "chg_cd");
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} iColName 선택 Item ComboBox SaveName
     *                               default="note_clss_cd"
     * @param {string} sColName 선택 Surcharge ComboBox SaveName
     *                               default="chg_cd"
     * @return 없음
     * @author 문동규
     * @version 2009.05.20
     */
    function checkSurcharge(sheetObj, iColName, sColName) {
        iColName=(iColName == null) ? "note_clss_cd" : iColName;
        sColName=(sColName == null) ? "chg_cd" : sColName;
        var cnt=sheetObj.RowCount();
        var bool=false;
        var status;
        for (var i=1; i <= cnt; i++) {
        	if (sheetObj.GetCellValue(i, iColName) == "S") {
                bool=true;
                sheetObj.SetCellEditable(i, sColName,1);
            } else {
            	if (ComRtrim(sheetObj.GetCellValue(i, sColName)) != "") {
            		status=sheetObj.GetRowStatus(i);
                    sheetObj.SetCellValue(i, sColName," ",0);
                    sheetObj.SetRowStatus(i,status);
                }
                sheetObj.SetCellEditable(i, sColName,0);
            }
        }
        if (bool) {
            sheetObj.SetColHidden(sColName,0);
        } else {
            sheetObj.SetColHidden(sColName,1);
        }
    }
    /* 개발자 작업  끝 */
