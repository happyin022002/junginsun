/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0241.js
*@FileTitle : P/F SKD Type Help (Pop-Up) 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.04
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.04.30 서창열
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
     * @class VOP_VSK_0241 : VOP_VSK_0241 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_VSK_0241() {
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
			
			case "btn_retrieve":
				doActionIBSheet(sheetObject1,formObject,IBSEARCH);
				break;

			case "btn_new":
				ClearData(sheetObject1,formObject);
				break;

			case "btn_close":
				window.close();
				break;
				
			case "btn_search":
				openLandCdHelp(sheetObject1);
				break;	
				
			case "btn_Select":

				var cnt  = sheetObject1.RowCount;
				if(cnt > 0){
					comPopupOK();
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
     
     var read_only	= document.form.read_only.value;
     
     //alert(document.form.pf_svc_tp_cd.value);
     
     if(read_only == "Y"){
    	 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

    	 document.form.vsl_slan_cd.disabled	= true;
    	 document.form.btn_search.style.visibility	= "hidden";
    	 ComBtnDisable("btn_retrieve");
    	 ComBtnDisable("btn_new");
    	 ComBtnDisable("btn_Select");
     }
 }

   /**
  * 시트 초기설정값, 헤더 정의
  * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
  * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
  */
     
 /**
  * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
  * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
  * @param {ibsheet} sheetObj    IBSheet Object
  * @param {int}     sheetNo     sheetObjects 배열에서 순번
  **/
 function initControl() {
	 var formObj = document.form;
	 
	 axon_event.addListenerForm		('focus'	, 'obj_focus'		, formObj);
	 axon_event.addListenerFormat	('keypress'	, 'obj_keypress'	, form);
  	 axon_event.addListenerFormat	('keyup'	, 'obj_change' 		, form);
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
  * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
  **/
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
         	if(event.srcElement.name=="vsl_slan_nm"){
         		if(event.keyCode!=32){ // 공백입력가능
         			ComKeyOnlyAlphabet('upper');
         		}
         	}else{
         		ComKeyOnlyAlphabet('upper');
         	}
             break;
         case "uppernum":
             //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
         	ComKeyOnlyAlphabet('uppernum','32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126');
             break;    
         default:
             //숫자만입력하기(정수,날짜,시간)
             ComKeyOnlyNumber(event.srcElement);
     }
 }
     
 /**
  * 필드 데이타가 CHANGE될 경우 이벤트
  */
 function obj_change(){
	var formObject = document.form;
	var sheetObject1 = sheetObjects[0];
	
 	try {
 		var srcName = window.event.srcElement.getAttribute("name");
 		
 		switch(srcName) {
 			case "vsl_slan_cd":
 				var cnt = formObject.vsl_slan_cd.value;
		
 				if(ComChkLen(formObject.vsl_slan_cd,3) == 2){
					doActionIBSheet(sheetObject1,formObject,SEARCH02);
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
     
 function initSheet(sheetObj,sheetNo) {
     var cnt = 0;

     switch(sheetNo) {
         case 1:      // sheet1 init
             with (sheetObj) {
                 // 높이 설정
                 style.height = 300;
                 // 전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
//                 MergeSheet = msNone;
                 MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = true;

                 var HeadTitle1 = "|Lane|Lane Name|P/F SKD|Jointed|Created Date|Live";
                 var HeadTitle2 = "|Lane|Lane Name|Type|VSL Class|Created Date|Live";
                 var headCount = ComCountHeadTitle(HeadTitle1);

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo(2, 1, 3, 100);
                 
                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(headCount, 0, 0, true);
                 
                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, true, false, true, false,false)
                 
                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle1, true);
                 InitHeadRow(1, HeadTitle2, true);
                 
                 var prefix="sheet1_";

                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,		prefix+"ibflag",		false,	"",     dfNone,				0,			true,		true);
				 InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,		prefix+"vsl_slan_cd",	false,	"",		dfNone,				0,			true,		true);
				 InitDataProperty(0, cnt++ , dtData,			190,	daLeft,		true,		prefix+"vsl_slan_nm",	false,	"",		dfNone,				0,			true,		true);
				 InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		prefix+"pf_svc_tp_cd",	false,	"",		dfNone,				0,			true,		true);
				 InitDataProperty(0, cnt++ , dtData,			150,	daLeft,		true,		prefix+"vsl_class",		false,	"",		dfNone,				0,			true,		true);
				 InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix+"cre_dt",		false,	"",		dfUserFormat2,		0,			true,		true);
				 InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,		prefix+"slan_stnd_flg",	false,	"",		dfNone,				0,			true,		true);
				 
				 InitUserFormat2(0, prefix+"cre_dt", "####-##-## ##:##", "-|:" );
             }
             
             break;
         }
     }

 /*
  * Sheet관련 프로세스 처리
  */
 function doActionIBSheet(sheetObj,formObj,sAction) {
     sheetObj.ShowDebugMsg = false;
     switch(sAction) {

        case IBSEARCH:      //조회
        	if(formObj.vsl_slan_cd.value == ""){
        		formObj.vsl_slan_cd.focus();
        		ComShowCodeMessage("VSK00067");
        		return;
        	}
        	
        	sheetObj.WaitImageVisible = false;
  		    ComOpenWait(true);
  		  
        	formObj.f_cmd.value = SEARCH;
        	
        	var sParam = "f_cmd=" 	+ formObj.f_cmd.value 
        							+"&vsl_slan_cd=" + formObj.vsl_slan_cd.value
        							+"&pf_svc_tp_cd=" + formObj.pf_svc_tp_cd.value;
        	
        	sheetObj.DoSearch("VOP_VSK_0241GS.do", sParam + "&" + ComGetPrefixParam("sheet1_"));
        	
        	showSheetData(sheetObj,formObj);
        	ComOpenWait(false);
        	
        	break;
             
        case SEARCH02:
        	sheetObj.WaitImageVisible = false;
  		    ComOpenWait(true);
			 formObj.f_cmd.value = SEARCH02;
			 //var sXml = sheetObj.GetSearchXml("VOP_VSK_0241GS.do?op_=0241" , FormQueryString(formObj));
			 var sXml = sheetObj.GetSearchXml("VOP_VSK_0241GS.do" , FormQueryString(formObj));
   		  	 var checkLane = ComGetEtcData(sXml, "checkLane");
   		  	 
   		  	 if(checkLane == undefined){
				sheetObj.LoadSearchXml(sXml);
				formObj.vsl_slan_cd.value = "";	
				formObj.vsl_slan_cd.focus();
   		  	 }
   		  	 
   		  	 ComOpenWait(false);
			  
   		  	 break;    
     }
 }

function showSheetData(sheetObj,formObj){
	var prefix = "sheet1_";
	var cnt = sheetObj.RowCount;
	
	for(var i=0; i<=cnt; i++){
		if(sheetObj.CellValue(i,prefix+"slan_stnd_flg") == "Y"){
			var pinkColor = sheetObj.RgbColor(eval("255"),eval("166"),eval("255"));
			sheetObj.CellBackColor(i,prefix+"vsl_slan_cd") = pinkColor;
			sheetObj.CellBackColor(i,prefix+"vsl_slan_nm") = pinkColor;
			sheetObj.CellBackColor(i,prefix+"pf_svc_tp_cd") = pinkColor;
			sheetObj.CellBackColor(i,prefix+"vsl_class") = pinkColor;
			sheetObj.CellBackColor(i,prefix+"cre_dt") = pinkColor;
			sheetObj.CellBackColor(i,prefix+"slan_stnd_flg") = pinkColor;
			
			break;
		}
	}
}

 /**
  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  */
 function validateForm(sheetObj,formObj,sAction){
     with(formObj){
//             if (!isNumber(formObj.iPage)) {
//                 return false;
//             }
     }

     return true;
 }
 
 /**
  * Lane Code Help 파일을 오픈한다
  */
 function openLandCdHelp(sheetObj){
    var targetObjList = "sheet1_vsl_slan_cd:vsl_slan_cd";
    var v_display = "0,0";
    
	ComOpenPopupWithTarget('/hanjin/VOP_VSK_0202.do', 420, 470, targetObjList, v_display, true);
 }
 
 function ClearData(sheetObj,formObj){
	 formObj.vsl_slan_cd.value = "";
	 formObj.vsl_slan_cd.focus();
	 
	 sheetObj.RemoveAll();
}
 
 /**
  * 부모창에 선택값 리턴
  */

 function sheet1_OnDblClick(sheetObj, Row, Col) {
	 comPopupOK();
 }
 
 function Search(){
	 var formObj = document.form;
	 doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
 }

 /* 개발자 작업  끝 */