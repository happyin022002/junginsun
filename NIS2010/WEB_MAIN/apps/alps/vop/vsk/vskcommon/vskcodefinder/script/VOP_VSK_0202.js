/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_vsk_0202.js
*@FileTitle : Lane Code Help
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.03
*@LastModifier : 서창열
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
 * @class vop_vsk_0202 : vop_vsk_0202 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function vop_vsk_0202() {
	this.processButtonClick		= tprocessButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initControl            = initControl;
	this.initCombo				= initCombo;
	this.doActionIBSheet 		= doActionIBSheet;
	this.setTabObject 			= setTabObject;
	this.validateForm 			= validateForm;
	this.vsl_slan_cd_change		= vsl_slan_cd_change;
}

/* 개발자 작업	*/

 // 공통전역변수

 var sheetObjects = new Array();
 var sheetCnt = 0;
 
 var comboObjects = new Array();
 var comboCnt = 0;
 
 var LANE = "lane";
 var ROWMARK = "|";
 var FIELDMARK = ",";


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
				doActionIBSheet(sheetObject1,formObject,IBSEARCH,"grid");
				break;
			
			case "btn_Select":
				var cnt  = sheetObject1.RowCount;
				if(cnt > 0){
					comPopupOK();
				}else{
					window.close();
				}
					
				break;
				
			case "btn_close":
				window.close();
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
 * IBCombo Object를 배열로 등록
 * param : combo_obj ==> 콤보오브젝트
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */ 
function setComboObject(combo_obj) {  
    comboObjects[comboCnt++] = combo_obj;  
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
     
     for(var k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],k+1);
    }
     
     initControl();
     document.form.vsl_slan_cd.focus();
 }
 
 /**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */ 
function initCombo(comboObj, comboNo) {
    var formObject = document.form
    switch(comboNo) {  
          case 1: 
           with (comboObj) { 
				MultiSelect = false; 
				UseAutoComplete = true;	
				SetColAlign("left|left");        
				SetColWidth("30|150");
				BackColor = "#CCFFFD";
				FontColor = "#000000";
				ColBackColor(0) = "#CCFFFD";
				ColFontColor(0) = "#000000";
				ColBackColor(1) = "#CCFFFD";
				ColFontColor(1) = "#000000";					
 					DropHeight = 160;
 		    	}
 			doActionIBCombo(sheetObjects[0],formObject,IBSEARCH,comboObj,SEARCH,LANE);
 			break; 
 	     } 
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
	var formObject = document.form;
	
    //Axon 이벤트 처리1. 이벤트catch
    axon_event.addListenerFormat ('keypress', 'obj_keypress', form);
	axon_event.addListenerFormat  ('keyup', 'obj_change' , form);
	axon_event.addListenerForm('focus', 'obj_focus', formObject);

    doActionIBSheet(sheetObjects[0], formObject, IBSEARCH, "ComCd");
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
    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
    var sheetObject1 = sheetObjects[0];
    /*******************************************************/
	try {
		var srcName = window.event.srcElement.getAttribute("name");
        switch(srcName) {

            case "vsl_slan_cd":
            	formObject.vsl_slan_nm.value = "";
            	var cnt = formObject.vsl_slan_cd.value;
				cnt = cnt.length;

				if(cnt == 3){
					doActionIBSheet(sheetObjects[0], formObject, IBSEARCH, "ComCd");
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
 	
 // 조회조건필드인 Lane SVC Type 데이터 조회
function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboAction,sComboKey) {

    sheetObj.ShowDebugMsg = false;
    switch(sAction) {

       case IBSEARCH:      // 조회

			if(validateForm(sheetObj,formObj,sAction))
			if (sheetObj.id == "sheet1") {				
				//콤보필드를 초기화시킨다.
				sComboObj.RemoveAll();
									
				formObj.f_cmd.value = SEARCH;
				//var sXml = sheetObj.GetSearchXml("VOP_VSK_0202GS.do?op_=0202", FormQueryString(formObj));
				var sXml = sheetObj.GetSearchXml("VSK_COMGS.do", FormQueryString(formObj));

				var comboItems = ComGetEtcData(sXml, sComboKey).split(ROWMARK);
				addComboItem(sComboObj,comboItems);				

			};
														
            break;
    }
}

/**
 * 콤보필드에 데이터를 추가해준다.
 */	
function addComboItem(comboObj,comboItems) {
	for (var i = 0 ; i < comboItems.length ; i++) {
		var comboItem = comboItems[i].split(FIELDMARK);
		comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[1]);
	}   		
	comboObj.InsertItem(0, "ALL","");
	comboObj.Index = 0; 

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
					 style.height = 262;
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
					
					 var HeadTitle = "|Lane|Lane Name|Lane Service Type";
					
					 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					 InitHeadRow(0, HeadTitle, true);
					 
					 var prefix="sheet1_";
					
					 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	prefix+"ibflag",				false,	"",      	dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	false,	prefix+"vsl_slan_cd",			false,	"",			dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			210,	daLeft	,	false,	prefix+"vsl_slan_nm",			false,	"",			dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			50,	daCenter,	false,	prefix+"vsl_svc_tp_cd",			false,	"",			dfNone,			0,			true,		true);
										
					CountPosition = 0;
         		}
         		
         		break;

         }
     }

   // Sheet관련 프로세스 처리
 function doActionIBSheet(sheetObj,formObj,sAction,flag) {
     sheetObj.ShowDebugMsg = false;
     switch(sAction) {
        case IBSEARCH:      //조회
        	  if(flag == "grid"){
        		  sheetObj.WaitImageVisible = false;
        		  ComOpenWait(true);
        		  
	        	  formObj.f_cmd.value = COMMAND11;
	        	  var tempVslSvcTpCd = comboObjects[0].Text;
	        	  if(tempVslSvcTpCd == "ALL" || tempVslSvcTpCd == ""){
	        		  formObj.vsl_svc_tp_cd.value = "";
	        	  }else{
	        		  formObj.vsl_svc_tp_cd.value = tempVslSvcTpCd;
	        	  }

	              //sheetObj.DoSearch("VOP_VSK_0202GS.do?op_=0202",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
	        	  sheetObj.DoSearch("VOP_VSK_0202GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
	        	  
	        	  ComOpenWait(false);
        	  }else{
        		  
        		  if(formObj.vsl_slan_cd.value == ""){
        			  return;
        		  }
        		  sheetObj.WaitImageVisible = false;
        		  ComOpenWait(true);
        		  
        		  formObj.f_cmd.value = COMMAND12;
        		  //var sXml = sheetObj.GetSearchXml("VOP_VSK_0202GS.do?op_=0202" , FormQueryString(formObj));
        		  var sXml = sheetObj.GetSearchXml("VOP_VSK_0202GS.do" , FormQueryString(formObj));
        		  
        		  var checkLane = ComGetEtcData(sXml, "checkLane");
      			
      			  if(checkLane == undefined){
      				  sheetObj.LoadSearchXml(sXml);
      				  formObj.vsl_slan_cd.value = "";	
      				  formObj.vsl_slan_cd.focus();
      			  }else{
      				  var vslSlanNm = ComGetEtcData(sXml, "checkLane").split("|");
      				
      				  if(vslSlanNm == ""){
      					  ComShowCodeMessage('VSK00021', formObj.vsl_slan_cd.value);
      					  formObj.vsl_slan_cd.value = "";	
      				  }else{
      					  formObj.vsl_slan_nm.focus();
      				  }
      			  }
      			 ComOpenWait(false);
        	  }
        	
             break;
		case IBINSERT:      // 입력
             break;
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
  * 부모창에 선택값 리턴
  */

function sheet1_OnDblClick(sheetObj, Row, Col) {
	 comPopupOK();
}
 
function sheet1_OnClick(sheetObj, Row, Col){
	window.returnValue = sheetObj.CellValue(sheetObj.SelectRow, 'sheet1_vsl_slan_cd');
}



 /**
  * Enter키 이벤트
  * @param sheetObj
  * @param formObj
  * @return
  */
 function doSearch(){

 	var formObject = document.form;

 	doActionIBSheet(sheetObjects[0], formObject, IBSEARCH,"grid");
 }
/* 개발자 작업  끝 */