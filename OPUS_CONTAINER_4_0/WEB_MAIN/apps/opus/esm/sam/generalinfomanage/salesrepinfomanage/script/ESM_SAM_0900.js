/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAM_0900.js
*@FileTitle  : Change Sales Rep
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/22
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/* 개발자 작업	*/
//공통전역변수
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var saveFlg=""; //save시 insert, update 를 구별하기 위한 flg
//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
		case "btn_save":
			doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
			break;
		case "btn_close":
			ComClosePopup(); 
			break;
		}
	} catch (e) {
		if (e == "[object Error]") {
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
function setSheetObject(sheet_obj) {
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
 * @author 이창원
 * @version 2011.05.21
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	//IBMultiCombo초기화
	for(var k=0; k < comboObjects.length; k++){
		initCombo(comboObjects[k], k + 1);
	}
	initControl();
	document.form.srep_prmry_flg.value=document.form.org_flg.value;
	saveFlg=document.form.srep_prmry_flg.value;
	checkUserCodeName();
}
function initControl(){
	axon_event.addListenerFormat("keypress","obj_Keypress", document.form);     
	axon_event.addListenerForm('change', 'obj_change', document.form); // change
}
/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
 function initSheet(sheetObj, sheetNo) {
	 var cnt=0;
	 var sheetID=sheetObj.id;
	 switch (sheetID) {
	 case "sheet1": //sheet1 init
	 with (sheetObj) {
	        var HeadTitle="";
	        var headCount=ComCountHeadTitle(HeadTitle);
	        var prefix="sheet1";

	        SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

	        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	        var headers = [ { Text:HeadTitle, Align:"Center"} ];
	        InitHeaders(headers, info);

	        var cols = [{}];
	         
	        InitColumns(cols);

	        SetEditable(0);
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
  *     doActionIBSheet(sheetObj, document.form, SEARCH)
  * </pre>
  * @param {ibsheet} sheetObj 필수 IBSheet Object
  * @param {form} formObj 필수 html form object
  * @param {int} sAction 필수 프로세스 플래그 상수
  * @return 없음
  * @author 이창원
  * @version 2011.05.21
  */
  function doActionIBSheet(sheetObj, formObj, sAction) {
	  try {
		  sheetObj.ShowDebugMsg(false);
		  switch (sAction) {
		  case IBSEARCH: //조회
		  formObj.f_cmd.value=SEARCH;
		  var sXml=sheetObj.GetSearchData("ESM_SAM_0900GS.do", FormQueryString(formObj));
		  var ofc_cd=(ComGetEtcData(sXml, "ofc_cd") == undefined) ? "" : ComGetEtcData(sXml, "ofc_cd");
		  var srep_nm=(ComGetEtcData(sXml, "srep_nm") == undefined) ? "" : ComGetEtcData(sXml, "srep_nm");
		  var srep_prmry_flg=ComGetEtcData(sXml, "srep_prmry_flg");
		  if(ofc_cd == "") {
			  formObj.srep_cd.value="";
			  formObj.ofc_cd.value="";
			  formObj.srep_nm.value="";
			  formObj.srep_prmry_flg.value="";
			  ComShowCodeMessage("COM130402", "S.Rep Code");
		  }else{
			  formObj.ofc_cd.value=ofc_cd;
			  formObj.srep_nm.value=srep_nm;
			  formObj.srep_prmry_flg.value=srep_prmry_flg;
			  if(srep_prmry_flg == ""){
				  saveFlg="";
			  } else {
				  saveFlg=formObj.srep_prmry_flg.value;
			  }
		  }
		  break;	
		  case IBSAVE: // 저장
		  if(validateForm(sheetObj,formObj,sAction)){
			  formObj.f_cmd.value=MULTI;
			  formObj.key.value=saveFlg;
			  var sXml=sheetObj.GetSaveData("ESM_SAM_0900GS.do", FormQueryString(formObj));
			  var result=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
			  if(result != "F"){
				  ComShowCodeMessage("COM130102", "Data");
				  window.returnValue="Y";
				  ComClosePopup(); 
			  }else{
				  ComShowCodeMessage("COM130103", "Data");
			  }
			  break;	
		  }		
		  }
	  }catch(e){
		  if (e == "[object Error]") {
			  ComShowMessage(OBJECT_ERROR);
		  } else {
			  ComShowMessage(e.message);
		  }
	  }
  }
  /**
   * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
   **/
  function obj_Keypress(){
	  var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	  var srcName=ComGetEvent("name");
	  var srcValue=event.srcElement.getAttribute("value");
	  switch(event.srcElement.dataformat) {
	  case "engupnum"://숫자+"영문대분자"입력하기
	  ComKeyOnlyAlphabet('uppernum'); break;
	  default:     //영문 + 숫자
	  ComKeyOnlyAlphabet('uppernum'); break;
	  }
  }
  /**
   * 폼 필드 변경시 이벤트
   * 
   * @return
   */
  function obj_change() {
	  var formObject=document.form;
	  var srcName=ComGetEvent("name");
	  var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
	  var srcValue=window.event.srcElement.getAttribute("value");
	  if (srcName == "srep_cd")  {
		  doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	  }
  }
  /**
  * User Auth 확인<br>
  * <br><b>Example :</b>
  * <pre>
  *     촏차
  * </pre>
  * @param {formObj} formObj
  * @return 없음
  * @author 이창원
  * @version 2011.06.16
  */
  function checkUserCodeName() {   
	  var formObj=document.form;
	  var sheetObj=sheetObjects[0];
	  if(formObj.usr_id.value.length>0){
		  var userAuth=checkUserAuth(formObj, sheetObj);
		  if(userAuth != ''){
			  formObj.srep_cd.readOnly=false;  
			  formObj.srep_cd.setAttribute("className","input1");
		  } else{
			  formObj.srep_cd.readOnly=true;
			  formObj.srep_cd.setAttribute("className","input2");
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
   * @author 이창원
   * @version 2011.05.21
   */
  function validateForm(sheetObj, formObj, sAction) {
	  switch(sAction) {
	  case IBSAVE:		//저장
	  if(saveFlg == "Y" && formObj.srep_prmry_flg.value == "N"){
		  ComShowCodeMessage("COM12118", "other S.rep" ,"Primary Flg");  // Check flg
		  return false;
	  }
	  else if(formObj.srep_prmry_flg.value == saveFlg){
		  ComShowCodeMessage("COM130402", "Primary Flg"); // no exist flg
		  return false;
	  }
	  break;
	  }	
	  return true;
  }
     /* 개발자 작업  끝 */
