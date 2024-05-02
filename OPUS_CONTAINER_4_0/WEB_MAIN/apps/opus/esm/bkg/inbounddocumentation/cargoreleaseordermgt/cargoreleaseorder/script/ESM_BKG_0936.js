/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0936.js
*@FileTitle  : DO Receiver and Ultimate Consignee(Incl. House BL No) Setting
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/18
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
  * @fileoverview DO Receiver and Ultimate Consignee(Incl. House BL No) Setting에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
  * @author
  */
/**
 * @extends
 * @class esm_bkg_0936 : esm_bkg_0964 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0936() {
    this.processButtonClick=tprocessButtonClick;
    this.setSheetObject=setSheetObject;
    this.loadPage=loadPage;
    this.initSheet=initSheet;
    this.initControl=initControl;
    this.doActionIBSheet=doActionIBSheet;
    this.setTabObject=setTabObject;
    this.validateForm=validateForm;
}
    /* 개발자 작업  */
// 공통전역변수
var sheetObjects=new Array();
var sheetCnt=0;
// 개발자 변수
var callCount=0;  // loadpage에서 doActionIBSheet할 경우 2번 호출됨, 이를방지하기위해 사용
var bChanged=false;
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return {void}
 * @author
 * @version 2009.10.01
 */
function processButtonClick(){
    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    var sheetObject=sheetObjects[0];
    /*******************************************************/
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        switch(srcName) {
            case "btn_Save":
            	doActionIBSheet(sheetObject,formObject,IBSAVE);
            	
                break;
            case "btn_Close":
            	if (bChanged) {
                    if (!ComShowCodeConfirm("BKG00168")) {return;} 
                }
  ComClosePopup(); 
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
 * IBSheet Object를 배열로 등록<br>
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
 * 배열은 소스 상단에 정의<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheet_obj 필수, Sheet개체
 * @return {void}
 * @author
 * @version 2009.10.01
 */
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * 초기화 작업 : 이벤트를 등록한다.<br><br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return void
 * @author
 * @version 2009.10.01
 */
function initControl() {
    //Axon 이벤트 처리1. 이벤트catch
    axon_event.addListenerForm('change', 'obj_change', form );     //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
}
/**
 * Sheet 기본 설정 및 초기화<br>
 * body 태그의 onLoad 이벤트핸들러 구현<br>
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return {void}
 * @author
 * @version 2009.10.01
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
        initSheet(sheetObjects[i],i+1);
    }
   
    initControl();
    fncSetLoadData();
   
    /*
     * 해당 프로그램은 sheet1_OnLoadFinish를 사용할 수 없다.
     * OnLoadFinish는 Load되면서 화면에 표시되는 sheet에 대해서만 발생하므로,
     * 해당 sheet는 hidden이므로 이벤트를 발생시키지 않는다.
     * 따라서 loadPage에서 처리해야만 한다.
     */
    if (callCount == 0) {
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        callCount=1;
    }
}
/**
 * Sheet관련 프로세스 처리<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj 필수, Sheet
 * @param {Object} formObj 필수, form객체
 * @param {int} sAction 필수, 작업처리코드
 * @return void
 * @author
 * @version 2009.10.01
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
    switch(sAction) {
        case IBSEARCH: 
            formObj.f_cmd.value=SEARCH;
            var sXml=sheetObj.GetSearchData("ESM_BKG_0936GS.do" ,FormQueryString(formObj));
            var errMsg=ComGetEtcData(sXml, "ERR_MSG");
            if (errMsg != "") {
                ComBtnDisable("btn_Save");
                ComShowCodeMessage(errMsg, formObj.do_no.value);
            } else {
                fnSetFormData(sXml);
            }
            break;
        case IBSAVE:        //저장
    
        	if(!validateForm(sheetObj,formObj,sAction)) {return;};
            formObj.f_cmd.value=MODIFY;
            
            
            var sparam= FormQueryString(formObj);
            var sXml=sheetObj.GetSaveData("ESM_BKG_0936GS.do", sparam);
            sheetObj.LoadSaveData(sXml);
            
            var state = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
            if (state == "S"){
            	ComClosePopup();
            }

            break;
    }
}
/**
 * Xml정보에 있는 Etc Data를 폼에 입력한다.<br>
 * @param {String} sXml 필수, Xml정보
 * @return void
 * @author
 * @version 2009.10.01
 */
function fnSetFormData(sXml) {
    var formObj=document.form;
    formObj.hbl_no.value=ComGetEtcData(sXml, "hbl_no");
    formObj.rcvr_cnee_nm.value=ComGetEtcData(sXml, "rcvr_cnee_nm");
    formObj.rcvr_co_nm.value=ComGetEtcData(sXml, "rcvr_co_nm");
    formObj.rcvr_phn_no.value=ComGetEtcData(sXml, "rcvr_phn_no");
    formObj.pic_nm.value=ComGetEtcData(sXml, "pic_nm");
    formObj.rcvr_eml.value=ComGetEtcData(sXml, "rcvr_eml");
    var custToOrdFlg=ComGetEtcData(sXml, "cust_to_ord_flg");
    if (custToOrdFlg == "Y") {
        formObj.cust_to_ord_flg_nm.value="Yes";
    } else {
        formObj.cust_to_ord_flg_nm.value="No";
    }
}
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리를 수행<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj 필수, Sheet
 * @param {Object} formObj 필수, Form 객체
 * @param {int} sAction 필수, 처리할 작업 코드
 * @return boolean 유효성 여부
 * @author
 * @version 2009.10.01
 */
function validateForm(sheetObj,formObj,sAction){
    if (formObj.rcvr_eml.value != "" && !ComIsEmailAddr(formObj.rcvr_eml.value)) {
        ComShowCodeMessage("BKG00245");
        return false;
    }
    return true;
}
/**
 * 파라미터로 받은 DO번호를 폼에 세팅한다.<br>
 * @param {void}
 * @return void
 * @author
 * @version 2009.10.01
 */
function fncSetLoadData() {
    var formObj=document.form;
    formObj.do_no.value=parDoNo ;
}
/**
 * 시트 초기설정값, 헤더 정의<br>
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호<br>
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj 필수, Sheet개체
 * @param {int} sheetNo 필수, Sheet Index
 * @return {void}
 * @author
 * @version 2009.10.01
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    var sheetID=sheetObj.id;
    switch(sheetID) {
        case "sheet1":      //sheetHidden init
            with(sheetObj){
	          var HeadTitle1="";
	          var prefix="sheet1_";
	
	          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:4, DataRowMerge:1 } );
	
	          var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	          var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	          InitHeaders(headers, info);
	
	          var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" } ];
	           
	          InitColumns(cols);
	
	          SetEditable(0);
	          SetCountPosition(0);
	          SetVisible(0);
	          }
              break;
    }
}
/**
 * XML로 부터 오류메시지가 있는지 검사하고 오류 메시지가 있을 경우 해당 메시지를 반환한다.<br>
 * @param {String} xmlStr 선택, 오류메시지를 포함하고 있는 xml
 * @return String 오류메시지
 * @author
 * @version 2009.10.01
 */
function ComBkgGetMessage(xmlStr){
    if(xmlStr == null  || xmlStr == "" ) return;
    try {
        var xmlDoc=new ActiveXObject("Microsoft.XMLDOM" );
        xmlDoc.loadXML(xmlStr);
        var xmlRoot=xmlDoc.documentElement;
        if(xmlRoot == null) return;
        var etcDataNode=xmlRoot.getElementsByTagName("MESSAGE").item(0);
        if(etcDataNode == null) return;
        return etcDataNode.firstChild.nodeValue;
    } catch(err) { ComFuncErrMsg(err.message); }
}
/**
 * Form Object가 변경될때 발생하는 이벤트를 처리한다.<br>
 * @param {void}
 * @return void
 * @author
 * @version 2009.10.01
 */
function obj_change(){
    var objName=event.srcElement.name;
    var formObj=document.form;
    switch(objName) {
        case "hbl_no":
            bChanged=true;
            break;
        case "rcvr_cnee_nm":
            bChanged=true;
            break;
        case "rcvr_co_nm":
            bChanged=true;
            break;
        case "rcvr_phn_no":
            bChanged=true;
            break;
        case "pic_nm":
            bChanged=true;
            break;
        case "rcvr_eml":
            bChanged=true;
            break;
    }
}
/* 개발자 작업  끝 */
