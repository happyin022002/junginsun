/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_5005.js
*@FileTitle  : Rating Unit Information Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/21
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/* 개발자 작업  */
// 공통전역변수
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1; 
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
 * <br><b>Example :</b>
 * <pre>
 *     processButtonClick();
 * </pre>
 * @return 없음
 * @author SHKIM
 * @version 2012.04.13
 */
function processButtonClick(){
    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    var sheetObject1=sheetObjects[0];
    var sheetObject2=sheetObjects[1];
    /*******************************************************/
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        if(ComGetBtnDisable(srcName)) return false;
        switch(srcName) {
            case "btn_add":
                if (validateForm(sheetObjects[1],document.form,IBSEARCH)) {
                    doActionIBSheet(sheetObjects[1], formObject, IBINSERT);
                }                          
                break;
            case "btn_del":
                doActionIBSheet(sheetObjects[1], formObject, IBDELETE);
                break;
            case "btn_retrieve":
                if (validateForm(sheetObjects[1],document.form,IBSEARCH)) {
                    doActionIBSheet(sheetObjects[1], formObject, IBSEARCH);
                }
                break;
            case "btn_new":
                removeAll(document.form);
                doActionIBSheet(sheetObjects[1], document.form, IBCLEAR);
                break;
            case "btn_save":
                if (validateForm(sheetObjects[1],document.form,IBSAVE)) {
                    doActionIBSheet(sheetObjects[1], formObject, IBSAVE);
                }
                break;
            case "btn_delete":
                if (validateForm(sheetObjects[1],document.form,IBDELETE)) {
                    doActionIBSheet(sheetObjects[1], formObject, IBDELETE);
                }       
                break;                    
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
 * IBSheet Object를 배열로 등록 <br>
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
 * 배열은 소스 상단에 정의 <br>
 * <br><b>Example :</b>
 * <pre>
 *     setSheetObject(sheetObj);
 * </pre>
 * @param {ibsheet} sheet_obj 필수 IBSheet Object
 * @return 없음
 * @author SHKIM
 * @version 2012.04.13
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
 * @author SHKIM
 * @version 2012.04.17
 */
function loadPage() {
    for(i=0;i<sheetObjects.length;i++){
        //khlee-시작 환경 설정 함수 이름 변경
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
        ComEndConfigSheet(sheetObjects[i]);
    }

    sheet1_onloadfinish(sheetObjects[1]);

    doActionIBSheet(sheetObjects[1], document.form, IBCLEAR);
    doActionIBSheet(sheetObjects[1], document.form, IBCREATE);
    //IBMultiCombo초기화
    for ( var k=0; k < comboObjects.length; k++) {
        initCombo(comboObjects[k], k + 1);
    }
    
}

/**
 * LoadFinish 이벤트 시 발생한다. <br>
 * <br><b>Example :</b>
 * <pre>
 *     
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @return 없음
 * @author SHKIM
 * @version 2012.04.13
 */
function sheet1_onloadfinish(sheetObj) {
    sheetObj.SetWaitImageVisible(0);
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
 * @author SHKIM
 * @version 2012.04.17
 */ 
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    var sheetID=sheetObj.id;
    switch(sheetID) {
        case "sheet0":      //hidden 
            with (sheetObj) {
                SetVisible(0);
            }
            break; 
        case "sheet1":      //hidden 
            with(sheetObj){
            var HeadTitle="|Sel.|Del Check|Seq.|Seq.Property|SVC Scope Property|SVC Scope Property Name ";
            SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
            var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            var headers = [ { Text:HeadTitle, Align:"Center"} ];
            InitHeaders(headers, info);
            var cols = [{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                        {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
                        {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
                        {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
                        {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
                        {Type:"Combo", 	   Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_ppt_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 },
                        {Type:"Text",      Hidden:0, Width:550,  Align:"Left",    ColMerge:0,   SaveName:"svc_scp_ppt_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0   } ];
                InitColumns(cols);
                SetEditable(1);
                SetWaitImageVisible(0);
                InitComboNoMatchText(1, "" , 1);
                SetColHidden("del_chk",1);
                resizeSheet();//SetSheetHeight(462);
            }
            break;
    }
}
function resizeSheet(){ ComResizeSheet(sheetObjects[1]); }

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
 * @author SHKIM
 * @version 2012.04.13
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
        case IBCLEAR:
            comboObjects[0].RemoveAll();
            formObj.f_cmd.value=SEARCH01;
            var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
            ComPriXml2ComboItem(sXml, svc_scp_cd, "cd", "cd|nm");
            break;    
        case IBCREATE: // selectBox
            sheetObjects[1].RemoveAll();
            break;
        case IBSEARCH:      //조회
            try {
                sheetObj.SetColProperty("svc_scp_ppt_cd", {ComboText:"", ComboCode:""} );
                sheetObjects[1].RemoveAll();
                sheetObj.SetWaitImageVisible(0);
                ComOpenWait(true);
                formObj.f_cmd.value=SEARCH;
                sheetObj.SelectHighLight=true;
                sheetObj.DoSearch("ESM_PRI_5005GS.do", FormQueryString(formObj) );
            } catch (e) {
                if (e == "[object Error]") {
                    ComShowMessage(OBJECT_ERROR);
                } else {
                    ComShowMessage(e.message);
                }
            } finally {
                ComOpenWait(false);
            }    
             break;
        case IBSAVE:        //저장
            var preIbflag=sheetObjects[1].GetRowStatus(1);
            if(preIbflag == "U"){
                return;
            }
            formObj.f_cmd.value=MULTI;
            var sParam="";
            var sParamSheet1=sheetObjects[1].GetSaveString();
            sParam=sParamSheet1;
            if (sheetObjects[1].IsDataModified()&& sParamSheet1 == "") {
                return;
            }
            sParam += "&" + FormQueryString(formObj);
            if (!ComPriConfirmSave()) {
                return false;
            }
            try {
                ComOpenWait(true);
                var sXml=sheetObjects[1].GetSaveData("ESM_PRI_5005GS.do", sParam);
                sheetObjects[1].LoadSaveData(sXml);
            } catch (e) {
                if (e == "[object Error]") {
                    ComShowMessage(OBJECT_ERROR);
                } else {
                    ComShowMessage(e.message);
                }
            } finally {
                ComOpenWait(false);
            }    
            break;
        case IBINSERT: // Row Add
            var idx=sheetObj.DataInsert(-1);
            formObj.f_cmd.value=SEARCH01;
            var sXml=sheetObj.GetSearchData("ESM_PRI_5004GS.do", FormQueryString(formObj));
            var rtnValue=sXml.split("|$$|");     
            var comboXml=ComXml2ComboString(rtnValue[0] , "svc_scp_ppt_cd", "svc_scp_ppt_desc");
            var oneLength=comboXml[0].split("|");
            var twoLength=comboXml[1].split("|");
            var text1="";
            var text2="";
            for(var i=0; i<oneLength.length; i++){
                text1="|" + oneLength[i]+"\t"+twoLength[i];
                text2=text2 + text1;
            }
            sheetObj.SetCellValue(idx,4,formObj.locSvcScpCd.value,0);// 강제로 값 세팅
            sheetObj.SetColProperty("svc_scp_ppt_cd", {ComboText:text2, ComboCode:"|"+comboXml[0]} );
            break;
        case IBDELETE: // Delete
            deleteRowCheck(sheetObj, "chk", true);
         break;  
    }
}

function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    ComOpenWait(false);
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
 * @return bool <br>
 *          true  : 폼입력값이 유효할 경우<br>
 *          false : 폼입력값이 유효하지 않을 경우
 * @author SHKIM
 * @version 2012.04.17
 */
function validateForm(sheetObj,formObj,sAction){
    switch (sAction) {
        case IBSEARCH:
            var locSvcScpNm=formObj.svc_scp_nm.value;
            if(locSvcScpNm == null || locSvcScpNm == ''){
                ComShowCodeMessage("COM130403","Service Scope");
                return false;
            }
            break;
        case IBINSERT:
            var locSvcScpNm=formObj.svc_scp_nm.value;
            if(locSvcScpNm == null || locSvcScpNm == ''){
                ComShowCodeMessage("COM130403","Service Scope");
                return false;
            }
            break; 
        case IBSAVE: // 저장
        	var Row=sheetObj.ColValueDup("svc_scp_ppt_cd");
    	    if(Row > -1){
    	        ComShowCodeMessage('PRI00302');
    	        sheetObj.SelectCell(Row, "svc_scp_ppt_cd");
    	        return false;
    	    }
    	    
            var locSvcScpNm=formObj.svc_scp_nm.value;
            if(locSvcScpNm == null || locSvcScpNm == ''){
                ComShowCodeMessage("COM130403","Service Scope");
                return false;
            }
            var rowCnt = getValidRowCount(sheetObjects[1]);
            if (sheetObj.IsDataModified()) {
                clearTooltip();
                var rowM=sheetObj.ColValueDup("svc_scp_ppt_cd",false);
                if (rowM >= 0) {
                    sheetObj.SelectHighLight=false;
                    var msg=ComGetMsg("PRI00302");
                    for (var i=sheetObj.LastRow(); i >= 0; i--) {
                        if(sheetObj.GetCellValue(i,"svc_scp_cd") == sheetObj.GetCellValue(rowM,"svc_scp_cd")) {
                            add2Tooltip(i, "svc_scp_cd", msg);
                        }
                    }
                    alert(msg);
                    return false;
                }              
                //중복 cd 체크
                var sParam=sheetObj.GetSaveString();
                if(sParam == null || sParam == ''){
                    return false;  // 선택한 값이 없습니다.
                }
                var locSaveStr=sParam.split("&");
            } else {
                ComShowCodeMessage("PRI00301");
                return false;
            }
            sheetObj.SelectHighLight=true;
            return true;
            break;
        case IBDELETE:
            var locSvcScpNm=formObj.svc_scp_nm.value;
            if(locSvcScpNm == null || locSvcScpNm == ''){
                ComShowCodeMessage("COM130403","Service Scope");
                return false;
            }
            
            
            sheetObj.FindCheckedRow("chk");
            var locChk=0; var locChkAll=0;
            for( var i=1 ; i<=sheetObj.RowCount(); i++){
                locChk=sheetObj.GetCellValue(i,"chk"); // no '0' , yes '1'
                locChkAll=locChkAll+locChk;
            }
            if(locChkAll < 1){
                var msg=ComGetMsg("PRI04006");
                alert(msg); return false;
            }
            break;
    }
    return true;
}

/**
 * tooltip을 제거한다. <br>
 * <br><b>Example :</b>
 * <pre>
 *     clearTooltip()
 * </pre>
 * @param 없음
 * @return 없음
 * @author SHKIM
 * @version 2012.04.17
 */
function clearTooltip() {
    var sheetObj=sheetObjects[1];
    for (var i=sheetObj.HeaderRows(), n=sheetObj.HeaderRows()+sheetObj.RowCount(); i < n; i++) {
        for (var j=0; j <= sheetObj.LastCol(); j++) {
            sheetObj.SetCellBackColor(i, j,sheetObj.GetEditableColor());
            sheetObj.SetToolTipText(i, j,"");
        }
    }
}

/**
 * tooltip을 생성한다. <br>
 * <br><b>Example :</b>
 * <pre>
 *     add2Tooltip(row, col, msg)
 * </pre>
 * @param {int} row
 * @param {int} col
 * @param {String} msg 
 * @return 없음
 * @author SHKIM
 * @version 2012.04.17
 */
function add2Tooltip(row, col, msg) {
    var sheetObj=sheetObjects[1];
    var toolTip = sheetObj.GetToolTipText(row, col) + "\n- " +  msg;
    
    sheetObj.SetCellBackColor(row, col,"#FF0000");
    sheetObj.SetToolTipText(row, col, toolTip);
}

/**
 * 화면 전체를 리셋한다.<br>
 * 데이터가 변경된 경우 저장한다.
 * <br><b>Example :</b>
 * <pre>
 *     searchConditionReset(formObj,gubun)
 * </pre>
 * @param {form} formObj 
 * @param {String} gubun    
 * @return 없음
 * @author SHKIM
 * @version 2012.04.17
 */
function removeAll(formObj) {
    if (sheetObjects[1].IsDataModified()) {
        if (ComShowCodeConfirm("PRI00006")) {
            doActionIBSheet(sheetObjects[1], formObj, IBSAVE);
        } else {
            formObj.reset();
            sheetObjects[1].RemoveAll();
        }
    } else {    
        formObj.reset();
        sheetObjects[1].RemoveAll();
    }
}

/**
 * sheet를 클릭시 발생한다.<br>
 * 체크박스를 언체크 한다.
 * <br><b>Example :</b>
 * <pre>
 *     sheet1_OnClick(sheetObj, Row, Col, Value)
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} Row 
 * @param {int} Col   
 * @param {String} Value   
 * @return 없음
 * @author SHKIM
 * @version 2012.04.17
 */
function sheet1_OnClick(sheetObj, Row, Col, Value)  {
    var colName=sheetObj.ColSaveName(Col);
    if (colName == "chk") {
        if (Value == "0") {
            sheetObj.SetCellValue(Row, "del_chk","0");
        }
    }   
}

/**
 * OnSaveEnd 시 발생한다.<br>
 * <br><b>Example :</b>
 * <pre>
 *     searchConditionReset(formObj,gubun)
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {String} ErrMsg    
 * @return 없음
 * @author SHKIM
 * @version 2012.04.17
 */
function sheet1_OnSaveEnd(sheetObj, code, Msg)  {
    if (code >= 0) {
    	doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
    }
}

/**
 * IBCombo Object를 배열로 등록 <br>
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
 * 배열은 소스 상단에 정의 <br>
 * <br><b>Example :</b>
 * <pre>
 *     setComboObject(combo_obj);
 * </pre>
 * @param {ibcombo} combo_obj 필수 IBCombo Object
 * @return 없음
 * @author SHKIM
 * @version 2012.04.17
 */
function setComboObject(combo_obj){
    comboObjects[comboCnt++]=combo_obj;
}

/**
 * OnChange 이벤트 발생시 호출되는 function <br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
 * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
 * @param {int} text 필수 화면에 표시된 글자
 * @return 없음
 * @author SHKIM
 * @version 2012.04.17
 */
function svc_scp_cd_OnChange(comboObj, oldindex, oldtext, oldcode, newindex , text , code) {
    sheetObjects[1].RemoveAll();
    var formObj=document.form;
    //var arrText=text.split("|");
    // SVC_SCP 바뀌면 svc_scp_nm세팅하고 Duration 재조회.
    if (text != null && text.length > 1) {
        formObj.locSvcScpCd.value=code;
        //sheetObjects[1].InitDataCombo(0,"svc_scp_cd", "|"+arrText[0],  arrText[0]); // 하나
        formObj.svc_scp_nm.value=comboObj.GetText(code, 1);
        selectedGlineSeq=null;
        doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
    }
    
    //empty value
    if(text == "" && code == "") {
    	removeAll(formObj);
    }
}


/**
 * IBMultiCombo에서 OnBlur 이벤트 발생시 호출되는 function <br>
 * svc_scp_cd 콤보에서 포커스가 나가면 선택한 값에 대한 description을 보여준다. <br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param {object} comboObj 필수 IBMultiCombo Object
 * @returns 없음
 * @author shkim
 * @version 2012.04.24
 */
function svc_scp_cd_OnBlur(comboObj) {
    var formObj=document.form;
    var code=comboObj.FindItem(comboObj.GetSelectCode(), 0);
    if (code == null) {
    	formObj.svc_scp_nm.value='';
    }
    if (code != null && code != "") {
        var text=comboObj.GetText(code, 1);
        if (text != null && text != "" && text != formObj.svc_scp_nm.value) {
            formObj.locSvcScpCd.value=comboObj.GetText(code, 0);                
            formObj.svc_scp_nm.value=comboObj.GetText(code, 1);
            doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
        }
    }
}

/**
 * OnChange 이벤트 발생시 호출되는 function <br>
 * Amend Seq.가 0일 경우 Main Duration을 변경할 경우 Main의 Effective,Expire Date도 변경한다. <br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
 * @return 없음
 * @author shkim
 * @version 2012.04.24
 */  
function sheet1_OnChange(sheetObj, Row, Col, Value)
{
	/*
	var locSvcScpCd= sheetObj.GetCellValue(Row,Col);
    if(locSvcScpCd.length < 5){
    	sheetObjects[1].SetCellValue(Row,Col,"",0);
        sheetObjects[1].SetCellValue(Row,Col+1,"",0);
        return false;
    }
    */
	
	var colname=sheetObj.ColSaveName(Col);
    switch(colname)
    {
        case "svc_scp_ppt_cd":
        	
        	if (Value==undefined || Value=="" || Value==null || Value=="null") {
        		sheetObj.SetCellValue(Row,"svc_scp_ppt_desc","",0);
        		return;
        	}
        	
        	//콤보코드와 텍스트를 가져온다.
        	var sText = sheetObj.GetComboInfo(Row,Col, "Text");
        	var sCode = sheetObj.GetComboInfo(Row,Col, "Code");
        	
        	//각각 배열로 구성한다.
        	var arrText = sText.split("|");
        	var arrCode = sCode.split("|");	
        	
        	for(i=1; i<arrCode.length; i++) {
       		 var sVal = sheetObj.GetCellValue(Row,Col);
                if(sVal == arrCode[i]) {
                	var desc = arrText[i].substring(4);
                	var splitDesc = desc.split("|");    
                	sheetObj.SetCellValue(Row,"svc_scp_ppt_desc",splitDesc[0],0);
                    break;            
                }
        	}
        	
        	
            break;
    }
	
	

	
	
	
}

function initCombo(comboObj, comboNo) {
    switch (comboObj.options.id) {
    case "svc_scp_cd":
        with (comboObj) {
            SetMaxLength(3);
            SetUseAutoComplete(1);
            ValidChar(2);
        }
        break;
    }
}
/* 개발자 작업  끝 */
