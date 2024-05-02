/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0064.js
*@FileTitle : Other(s) Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.03
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.07.15 정명훈
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
     * @class VOP_VSK_0064 : VOP_VSK_0064 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_VSK_0064() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/


 // 공통전역변수

 var sheetObjects = new Array();
 var sheetCnt = 0;


 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
 function processButtonClick(){
 	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

 	var sheetObject1 = sheetObjects[0];

 	/*******************************************************/
 	var formObject = document.form;

 	try {
 		var srcName = window.event.srcElement.getAttribute("name");

 		switch(srcName) {

	 		case "Retrieve":
	 			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
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
  * IBSheet Object를 배열로 등록
  * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
  * 배열은 소스 상단에 정의
  */
 function setSheetObject(sheet_obj){

 	sheetObjects[sheetCnt++] = sheet_obj;

 }



 /**
  * Sheet 기본 설정 및 초기화
  * body 태그의 onLoad 이벤트핸들러 구현
  * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
  */
 function loadPage() {

 	for(i=0;i<sheetObjects.length;i++){

 		//khlee-시작 환경 설정 함수 이름 변경
 		ComConfigSheet (sheetObjects[i] );

 		initSheet(sheetObjects[i],i+1);
 		//khlee-마지막 환경 설정 함수 추가
 		ComEndConfigSheet(sheetObjects[i]);

 	}

 	ComChkObjValid(document.form.name);
 	initControl();
 	grd_nm_change();
 }

  /**
   * 이벤트 컨트롤 정의
   */
function initControl() {
	var formObj = document.form;
	axon_event.addListenerForm('focus', "obj_activate", formObj);
	axon_event.addListenerFormat("keypress", "obj_keypress",  formObj);
	axon_event.addListenerFormat("keyup",    "obj_keyup",     formObj);
	axon_event.addListener      ("change",   "grd_nm_change", "grd_nm");
}

function obj_activate(){
	if(event.srcElement.options){
		event.srcElement.focus();
	}else{
		event.srcElement.select();
	}
}

  /**
   * KEY PRESS 이벤트
   */
  function obj_keypress() {
  	switch(event.srcElement.dataformat){
  		case "float":
  			//숫자+"."입력하기
  			ComKeyOnlyNumber(event.srcElement, ".");
  			break;
  		case "eng":
  			//영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
  			ComKeyOnlyAlphabet();
  			break;
  		case "engdn":
  			//영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
  			ComKeyOnlyAlphabet('lower');
  			break;
  		case "engup":
  			//영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
  			if(event.srcElement.name=="name"){
 				if(event.keyCode!=32){ // 공백도입력
 					ComKeyOnlyAlphabet('upper');
 				}
 			}else{
 				ComKeyOnlyAlphabet('upper');
 			}
  			break;
  		default:
  			//
  	}

  	switch(event.srcElement.name){
  	
  		case "grd_nm": case "code": case "name": 
  			if(event.keyCode==13){
  				doSearch();
  			}
  			break;
  	}  	
  	
  }

  /**
   * 필드 데이타가 CHANGE될 경우 이벤트
   */
  function obj_keyup(){

  	var formObject = document.form;
  	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
  	var sheetObject1 = sheetObjects[0];
  	/*******************************************************/
  	try {
  		var srcName = window.event.srcElement.getAttribute("name");
  		
  		switch(srcName) {
  				
  			default:
  				obj_nextfocus(event.srcElement);
  				break;   				


  		} // end switch
  	}catch(e) {
  		if( e == "[object Error]") {
  			ComShowCodeMessage('VSK00011');
  		} else {
  			ComShowMessage(e);
  		}
  	}
  } 	

  /**
   * 이벤트
   */
  function grd_nm_change() {
	  clearAllData(sheetObjects[0], form);

	  var valGrdNm = form.grd_nm.value;
	  if(valGrdNm == "CD00717"){
		  document.getElementById("code").setAttribute("maxLength", "1");
	  } else if(valGrdNm == "CD01827" || valGrdNm == "CD01819"){
		  document.getElementById("code").setAttribute("maxLength", "2");
	  } else if(valGrdNm == "CD01830"){
		  document.getElementById("code").setAttribute("maxLength", "3");		  
	  } else if(valGrdNm == "CD0XXXX"){
		  document.getElementById("code").setAttribute("maxLength", "3");		  
	  }
  }   

  // 인자로 받은 HTML태그(Object)의 다음 HTML태그(Object)로 포커스를 이동
  function obj_nextfocus(obj) {
  	var objMaxLength = obj.getAttribute("maxlength");
  	var objValue = obj.getAttribute("value");
  	
  	if (ComChkLen(objValue, objMaxLength) == 2) {
  		ComSetNextFocus(obj);
  	}
  }   

 /**
  * 시트 초기설정값, 헤더 정의
  * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
  * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
  */
 function initSheet(sheetObj,sheetNo) {

 	var cnt = 0;
 	var sheetId = sheetObj.id;

 	switch(sheetId) {
 	case "sheet1":      // sheet1 init
 		with (sheetObj) {
 			// 높이 설정
 			style.height = 460;
 			// 전체 너비 설정
 			SheetWidth = mainTable.clientWidth;

 			//Host정보 설정[필수][HostIp, Port, PagePath]
 			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

 			//전체Merge 종류 [선택, Default msNone]
 			MergeSheet = msHeaderOnly;

 			//전체Edit 허용 여부 [선택, Default false]
 			Editable = false;

 			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 			InitRowInfo( 1, 1, 3, 100);

 			var HeadTitle = "Code|Description ";
 			var headCount = ComCountHeadTitle(HeadTitle);
 			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 			InitColumnInfo(headCount, 0, 0, true);

 			// 해더에서 처리할 수 있는 각종 기능을 설정한다
 			InitHeadMode(true, true, false, true, false,false);


 				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 			InitHeadRow(0, HeadTitle, true);

 			var prefix = "sheet1_";	

 			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 			InitDataProperty(0, cnt++ , dtData,		100,	daCenter,		true,		prefix+"code",						false,	"",		dfNone,			0,			true,		true);
 			InitDataProperty(0, cnt++ , dtData,		200,	daLeft,		true,		prefix+"name",						false,	"",		dfNone,			0,			true,		true);

 			//FitColWidth("0|30|");
 			//DataRowMerge(0) = true;

 		}
 		break;



 	}
 }
  


 // Sheet관련 프로세스 처리
 function doActionIBSheet(sheetObj,formObj,sAction) {
 	sheetObj.ShowDebugMsg = false;
 	sheetObj.WaitImageVisible = false;
 	switch(sAction) {

		case IBSEARCH:      //조회
			if(validateForm(sheetObj, formObj, sAction)){
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;
				var prefix = "sheet1_";	//prefix 
				var sXml = sheetObj.GetSearchXml("VOP_VSK_0064GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
				sheetObj.LoadSearchXml(sXml);
				ComOpenWait(false);
			}
		break;
 	}	
 }

 /**
  * 화면을 초기화 한다.
  * @param sheetObj
  * @param formObj
  * @return
  */
 function clearAllData(sheetObj1, formObj){
 	formObj.code.value = "";
 	formObj.name.value = "";

 	sheetObj1.RemoveAll();
 	
 	formObj.code.focus();
 } 
  
  /**
   * Enter키 이벤트
   * @param sheetObj
   * @param formObj
   * @return
   */
  function doSearch(){
  	var formObject = document.form;
  	doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
  }   


 /**
  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  */
 function validateForm(sheetObj,formObj,sAction){
 	return true;
 }
    
  

	/* 개발자 작업  끝 */