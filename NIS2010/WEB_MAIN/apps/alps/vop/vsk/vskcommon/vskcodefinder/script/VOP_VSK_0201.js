/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0201.js
*@FileTitle : Simulation No. Help
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.04
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.07.06 서창열
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
     * @class VOP_VSK_0201 : VOP_VSK_0201 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_VSK_0201() {
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
 
 var simData = new Object();


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
	
		case "btn_retrieve":
			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			break;
		
		case "btn_new":
			clearAllData(sheetObject1,formObject);
			break;
			
		case "btn_Select":
			var cnt  = sheetObject1.RowCount;
			if(cnt > 0){
				var simTemp = sheetObject1.CellValue(sheetObject1.SelectRow, "sheet1_simul_no");
				if(simTemp != ""){
					simTemp = ComReplaceStr(simTemp,"-","");
					simData.sim_dt = simTemp.substring(0,8);
					simData.sim_no = simTemp.substring(8,9);
	
					window.returnValue = simData;
					comPopupOK();
				}
			}else{
				ComShowCodeMessage("VSK00043");
				return;
			}

			break;
			
		case "btn_close":
			window.close();
			break;
			
		case "btns_search":
			openLandCdHelp(sheetObject1);
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

	     ComConfigSheet (sheetObjects[i] );
	
	     initSheet(sheetObjects[i],i+1);
	     
	     ComEndConfigSheet(sheetObjects[i]);

     }	
     initControl();
 	 document.form.vsl_slan_cd.focus();
 }

 
 /**
  * 이벤트 컨드롤 정의
  */
 function initControl() {
	var formObj = document.form;
 	axon_event.addListenerFormat ('keypress', 'obj_keypress', form);
// 	axon_event.addListenerFormat  ('keyup', 'obj_change' , form);
 	axon_event.addListenerFormat  ('keyup', 'obj_keyup' , form);
	axon_event.addListenerForm('focus', 'obj_focus', formObj);
}
 
function obj_focus() {
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
             ComKeyOnlyAlphabet('upper');
         case "uppernum":
             //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
             ComKeyOnlyAlphabet('uppernum');    
             break;
         default:
             //숫자만입력하기(정수,날짜,시간)
             ComKeyOnlyNumber(event.srcElement);
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
             
         	case "vsl_slan_cd":
         		// 0015 화면에서만 Check(0001 화면에서는 Lane Code 를 등록하지 않고 사용가능).
         		if(formObject.uiflg.value == "B"){
	 	        	var cnt = formObject.vsl_slan_cd.value;
	 				cnt = cnt.length;
	 	
	 				if(cnt == 3){
	 					doActionIBSheet(sheetObjects[0], formObject, SEARCH02);
	 				}
         		}
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
  * 시트 초기설정값, 헤더 정의
  * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
  * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
  */
 function initSheet(sheetObj,sheetNo) {

     var cnt = 0;

     switch(sheetNo) {
         case 1:      // sheet1 init
             with (sheetObj) {
                 // 높이 설정
                 style.height = 277;
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

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(8, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, true, true, true, false,false)

                 var HeadTitle = "|Seq.|Lane|Lane Name|Simulation No.|Created Date|Remark(s)|";

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle, true);

                 var prefix = "sheet1_";
                 //데이터속성    [ROW, COL,  	DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,	prefix+"ibflag");
				InitDataProperty(0, cnt++ , dtSeq,			30,		daCenter,	true,	prefix+"Sel");
				InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	prefix+"vsl_slan_cd",					false,	"",		dfNone,			0,			true,		true);
				InitDataProperty(0, cnt++ , dtData,			220,	daLeft,	true,	prefix+"vsl_slan_nm",			false,	"",		dfNone,			0,			true,		true);
				InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	prefix+"simul_no",			false,	"",		dfNone,			0,			true,		true);
				InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	prefix+"cre_dt",			false,	"",		dfUserFormat2,			0,			true,		true);
				
				InitDataProperty(0, cnt++ , dtData,			90,		daLeft,	true,	prefix+"pf_skd_rmk",		false,	"",		dfNone,		0,			true,		true);
				InitDataProperty(0, cnt++ , dtHidden,		90,		daLeftTop,	true,	prefix+"uiflg",			false,	"",		dfNone,			0,			true,		true);
				
				InitUserFormat2(0, prefix+"cre_dt", "####-##-## ##:##", "-|:" );
				
				WaitImageVisible = false;

		   }
             break;

     }
 }

   // Sheet관련 프로세스 처리
 function doActionIBSheet(sheetObj,formObj,sAction) {
     sheetObj.ShowDebugMsg = false;
     switch(sAction) {

        case IBSEARCH:      //조회
        	if(validateForm(sheetObj,formObj,sAction)){

        		//formObj.f_cmd.value = SEARCH;
        		ComOpenWait(true);
        		formObj.f_cmd.value = COMMAND20;
        		sheetObj.DoSearch("VOP_VSK_0201GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
        		ComOpenWait(false);
        	}
             break;

        case SEARCH02:
			//formObj.f_cmd.value = SEARCH02;
        	//ComOpenWait(true);
        	formObj.f_cmd.value = COMMAND12;
			var sParam = FormQueryString(formObj);
			//var sXml = sheetObj.GetSearchXml("VOP_VSK_0202GS.do?op_=0202", sParam);
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0202GS.do", sParam);
			//ComOpenWait(false);
			var checkLane = ComGetEtcData(sXml, "checkLane");
			if(checkLane == undefined){
				sheetObj.LoadSearchXml(sXml);
				formObj.vsl_slan_cd.value = "";	
				formObj.vsl_slan_cd.focus();
			}else{
				var vslSlanNm = ComGetEtcData(sXml, "checkLane").split("|");
				formObj.vsl_slan_cd.focus();
			}
			
		break;

		case IBINSERT:      // 입력
             break;
     }
 }

     
 /**
  * 화면을 초기화 한다.
  * @param sheetObj
  * @param formObj
  * @return
  */
 function clearAllData(sheetObj1,formObj){
 	formObj.vsl_slan_cd.value = ""; 	

 	sheetObj1.RemoveAll();

 }
     
 /**
  * Lane Code Help 파일을 오픈한다
  */
 function openLandCdHelp(sheetObj){
    var targetObjList = "sheet1_vsl_slan_cd:vsl_slan_cd";
    var v_display = "0,0";
    var vsl_slan_cd = document.form.vsl_slan_cd.value;
 	ComOpenPopupWithTarget('/hanjin/VOP_VSK_0202.do?vsl_slan_cd='+vsl_slan_cd, 420, 470, targetObjList, v_display, true);

 }

 /**
  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  */
 function validateForm(sheetObj,formObj,sAction){
 	switch(sAction) {

 		case IBSEARCH:      //조회
 			
 			if(ComIsNull(formObj.vsl_slan_cd.value)){
 				ComShowCodeMessage('VSK00027', "Lane Code");
 				formObj.vsl_slan_cd.focus();
 				return false;
 			}
 			
 			if(formObj.vsl_slan_cd.value.length <3){
 				ComShowCodeMessage('VSK00027', "Lane Code");
 				formObj.vsl_slan_cd.focus();
 				return false;
 			}
 			break;
 	}

     return true;
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
  * 부모창에 선택값 리턴
  */

 function sheet1_OnDblClick(sheetObj, Row, Col) {
	 var simTemp = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet1_simul_no");
		if(simTemp != ""){
			simTemp = ComReplaceStr(simTemp,"-","");
			simData.sim_dt = simTemp.substring(0,8);
			simData.sim_no = simTemp.substring(8,9);
			window.returnValue = simData;
			comPopupOK();
		}
 }

	/* 개발자 작업  끝 */