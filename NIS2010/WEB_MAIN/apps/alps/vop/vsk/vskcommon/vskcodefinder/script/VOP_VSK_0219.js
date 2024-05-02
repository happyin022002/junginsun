/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0219.js
*@FileTitle : VSL Code Help
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.03
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.04.27 서창열
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
 * @class VOP_VSK_0219 : VOP_VSK_0219 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_VSK_0219() {
	this.processButtonClick		= tprocessButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initControl            	= initControl;
	this.doActionIBSheet 		= doActionIBSheet;
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
      
      var sheetObject = sheetObjects[0];
      
      /*******************************************************/
      var formObject = document.form;

 	try {
 		var srcName = window.event.srcElement.getAttribute("name");

         switch(srcName) {

			case "btn_Retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
			
			case "btn_ok":
				var cnt  = sheetObject.RowCount;

				if(cnt > 0){
					 window.returnValue = sheetObj.CellValue(sheetObj.SelectRow, 'vsl_cd');
					 comPopupOK();
				}
				break;
				
			case "btn_close":
				window.close();
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

         ComConfigSheet (sheetObjects[i] );

         initSheet(sheetObjects[i],i+1);

         ComEndConfigSheet(sheetObjects[i]);
     }
     
     initControl();
 }
 
/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 **/
function initControl() {
	//** Date 구분자 **/
	DATE_SEPARATOR = "/";
	var formObj = document.form;
	
    //Axon 이벤트 처리1. 이벤트catch
    axon_event.addListenerFormat('keypress', 'obj_keypress', formObj); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    axon_event.addListenerForm('focus', 'obj_focus', formObj);
    axon_event.addListener  ('keypress', 'engnum_keypress' , 'vsl_cd'); //- Vessel Code 입력 시 영문 대문자/숫자만 입력하기
    axon_event.addListener  ('keypress', 'eng_keypress' , 'vsl_eng_nm', 'crr_cd'); //- 영문 대문자만 입력하기

	axon_event.addListener ('keypress', 'enter_keypress', 'form');		//- Enter 키 처리
	axon_event.addListener ('keyup', "VskKeyFocus", 'form');			//- 자동포커스 처리
}

function obj_focus() {
	if(event.srcElement.options){
		event.srcElement.focus();
	}else{
		event.srcElement.select();
	}
}

/**
 * HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
 **/
function obj_keypress(){
	switch(event.srcElement.dataformat){
		case "int":
	        //숫자 만입력하기
	        ComKeyOnlyNumber(event.srcElement);
			break;
		case "float":
	        //숫자+"."입력하기
	        ComKeyOnlyNumber(event.srcElement, ".");
			break;
		default:
	        //숫자만입력하기
	        ComKeyOnlyNumber(event.srcElement);
	}
}

/**
 * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
 **/
function engnum_keypress() {
    //영대문자 자동변환
    ComKeyOnlyAlphabet('uppernum');
}

/**
 * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
 **/
function eng_keypress() {
	var obj = event.srcElement;
	switch(obj.name){
		case "vsl_eng_nm":
			if(event.keyCode!=32){ // 공백입력가능
				//::2014-05-07::CHM-201430142-Vessel name 검색시 숫자값 입력 가능 요청:://
				////ComKeyOnlyAlphabet('upper');
			}
			break;
	 	default:
	 		ComKeyOnlyAlphabet('upper');
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
            	 
            	 tabIndex = -1;
            	 
                 // 높이 설정
                 style.height = 237;
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
                 InitColumnInfo(4, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, true, true, true, false,false)

                 var HeadTitle = "|Code|Vessel Name|Carrier Code";

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle, true);
                 
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	false,	"ibflag",				false,	"",      	dfNone,			0,			true,		true);
				InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	false,	"vsl_cd",			false,	"",			dfNone,			0,			true,		true);
				InitDataProperty(0, cnt++ , dtData,			280,		daLeft,		false,	"vsl_eng_nm",		false,	"",			dfNone,			0,			true,		true);
				InitDataProperty(0, cnt++ , dtData,			100,		daCenter,	false,	"crr_cd",				false,	"",			dfNone,			0,			true,		true);
 										
 					//CountPosition = 0;
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
        	if(validateForm(sheetObj,formObj,sAction)){
        		ComOpenWait(true);
	        	formObj.f_cmd.value = COMMAND16;
	        	var rXml = sheetObj.GetSearchXml("VOP_VSK_0219GS.do", FormQueryString(formObj));
	        	sheetObj.LoadSearchXml(rXml);
	        	ComOpenWait(false);
        	}
	        break;
     }
 }



 /**
  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  */
 function validateForm(sheetObj,formObj,sAction){
	 var vsl_cd 	= formObj.vsl_cd;
	 var vsl_eng_nm = formObj.vsl_eng_nm;
	 var crr_cd 	= formObj.crr_cd;
 
     with(formObj){
    	 if (ComChkLen(vsl_cd, 2)==1 && ComChkLen(vsl_eng_nm, 2)==1 && ComChkLen(crr_cd, 2)==1){
    		 vsl_cd.focus();
    		 ComShowCodeMessage('VSK00022', "2", "vessel code");
    		 
    		 return false;
    	 }
     }

     return true;
 }
 
 /**
  * 부모창에 선택값 리턴
  */

 function sheet1_OnDblClick(sheetObj, Row, Col) {
	 window.returnValue = sheetObj.CellValue(sheetObj.SelectRow, 'vsl_cd');
	 comPopupOK();
 }
 
function sheet1_OnClick(sheetObj, Row, Col){
	window.returnValue = sheetObj.CellValue(sheetObj.SelectRow, 'vsl_cd');
}//end sheet1_OnDblClick

/**
 * 엔터키로 연결된 화면 대표 이벤트
 */
function enter_keypress(){
	VskKeyEnter();
}


/* 개발자 작업  끝 */