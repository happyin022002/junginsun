/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0043.js
*@FileTitle : Country Code Help
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.14
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.05.12 유혁
* 1.0 Creation
* 
* History
* 2011.03.14 진마리아 CHM-201109291-01 Location Code(숫자포함)의 Validation 체크로직 수정
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
     * @class VOP_VSK_0043 : VOP_VSK_0043 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_VSK_0043() {
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
          
          var sheetObj = sheetObjects[0];
          
          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");
     		
             switch(srcName) {

 				case "btn_ok":
 					if(window.returnValue){
 						comPopupOK();
 					}
 					break;
 					
 				case "btn_close":
 					window.close();
 					break;
 					
 				case "btn_Retrieve":
 					if(formObject.port_cd.value!=''){
 						formObject.loc_cd.value = formObject.cnt_cd.value + formObject.port_cd.value;
 					}else{
 						formObject.loc_cd.value = '';
 					}
                	if(validateForm(sheetObj, document.form, IBSEARCH)){
						doActionIBSheet(sheetObj,document.form,IBSEARCH);
					}
                    break;
 				
 				case "btn_popup":
 					var sUrl = "/hanjin/COM_ENS_0M1.do";
					ComOpenPopupWithTarget(sUrl, 560, 470, "cnt_cd:cnt_cd|cnt_nm:cnt_nm", "1,0,1", true);
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
         
         initControl();
         
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
                     style.height = 280;
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
                     InitHeadMode(true, true, true, false, false,false)

                     var HeadTitle = "|Seq|Port Code|Port Name";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);


                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					InitDataProperty(0, cnt++ , dtHiddenStatus,		30,	daCenter,	false,	"ibflag");
 					InitDataProperty(0, cnt++ , dtSeq,					30,	daCenter,	false,	"Seq");
 					InitDataProperty(0, cnt++ , dtData,					100,	daCenter,	false,	"loc_cd",					false,	"",		dfNone,			0,			true,		true);
 					InitDataProperty(0, cnt++ , dtData,					170,	daLeft,		false,	"loc_nm",			false,	"",		dfNone,			0,			true,		true);
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

            	formObj.f_cmd.value = COMMAND13;
            	if(validateForm(sheetObj,formObj,sAction))
            		if ( sheetObj.id == "sheet1"){
            			ComOpenWait(true);
            			var sParam = FormQueryString(formObj);
            			var rXml = sheetObj.GetSearchXml("VOP_VSK_0043GS.do", sParam);
            			sheetObj.LoadSearchXml(rXml);
            			ComOpenWait(false);
            		}
            	break;
                 
            case SEARCH01:	// Country Name 조회
            	ComOpenWait(true);
				formObj.f_cmd.value = COMMAND14;
				var sParam = FormQueryString(formObj);
				var sXml = sheetObj.GetSearchXml("VOP_VSK_0043GS.do", sParam);
				ComOpenWait(false);
				var nm = ComGetEtcData(sXml, "cnt_nm");
				if(nm!=null){
					formObj.tmp_cnt_cd.value = formObj.cnt_cd.value;
					ComSetNextFocus();
				}else{
					ComShowCodeMessage('VSK00021', formObj.cnt_cd.value);
					formObj.cnt_cd.value = formObj.tmp_cnt_cd.value;
					formObj.cnt_cd.focus();
				}
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
     
     function sheet1_OnDblClick(sheetObj, Row, Col){
    	 window.returnValue = sheetObj.CellValue(sheetObj.SelectRow, 'loc_cd');
    	 comPopupOK();
   	}//end sheet1_OnDblClick
     
     function sheet1_OnClick(sheetObj, Row, Col){
    	 window.returnValue = sheetObj.CellValue(sheetObj.SelectRow, 'loc_cd');
   	}//end sheet1_OnDblClick
     
     function initControl() {
    	 var formObj = document.form;
    	 axon_event.addListenerForm("focus", "obj_activate", formObj);
    	 axon_event.addListenerForm('change', 'obj_change', formObj); 
    	 axon_event.addListener  ('keypress', 'eng_keypress' , 'cnt_cd', 'port_cd', 'loc_nm');	//- 영문 대문자만 입력하기
    	 axon_event.addListener ('keypress', 'enter_keypress', 'form');		//- Enter 키 처리
    	 axon_event.addListener ('keyup', "VskKeyFocus", 'form');			//- 자동포커스 처리
	}
     
     function obj_activate(){
    	 if(event.srcElement.options){
			event.srcElement.focus();
		}else{
			event.srcElement.select();
		}
     }

     function obj_change(){
     	var formObj = document.form;
     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {
             
             	case "cnt_cd":
             		with(formObj){
             			if(cnt_cd.value==''){
             				port_cd.value = '';
             				loc_nm.value = '';
             				tmp_cnt_cd.value = '';
             			}else{
             				if(ComChkLen(cnt_cd.value, 2)==2){		// 길이가 2이면 국가코드 조회
             					if(tmp_cnt_cd.value!=cnt_cd.value){
             						doActionIBSheet(sheetObjects[0], formObj, SEARCH01);
             					}
             				}
             			}
             		}
             		
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
      * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
      **/
     function eng_keypress() {
    	 var obj = event.srcElement;
    	 switch(obj.name){
    	 	case "loc_nm":
    	 		if(event.keyCode!=32){ // 공백입력가능
    				ComKeyOnlyAlphabet('uppernum');
    			}
    			break;
    	 	case "port_cd":
    	 		ComKeyOnlyAlphabet('uppernum');
    	 		break;
    	 	default:
    	 		ComKeyOnlyAlphabet('upper');		
    	 }
     }
      
     /**
      * 엔터키로 연결된 화면 대표 이벤트
      */
     function enter_keypress(){
     	VskKeyEnter();
     }

	/* 개발자 작업  끝 */