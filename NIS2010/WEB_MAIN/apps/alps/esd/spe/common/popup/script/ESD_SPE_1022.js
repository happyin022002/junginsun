/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESD_SPE_1022.js
*@FileTitle : S/P Help
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.11
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.11 백형인
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
     * @class ESD_SPE_1022 : ESD_SPE_1022 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_SPE_1022() {
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
	//공통전역변수
    var frm = null;
    var ipageNo =1 ;

    var sheetObjects = new Array();
    var sheetCnt = 0;
    var selectVal;
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

      
        
    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
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

            	    case "btn_New":
        	            sheetObject.RemoveAll();
        	            formObject.reset();
            	        break;

                    case "btn_Close":
        	            self.close();
            	        break;

            	    case "btn_OK":
                        comPopupOK();
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
        	frm = document.form;
            for(i=0;i<sheetObjects.length;i++){
	   			 //-시작 환경 설정 함수 이름 변경
	   			 ComConfigSheet(sheetObjects[i]);
	   			 initSheet(sheetObjects[i],i+1);
	   			 //-마지막 환경 설정 함수 추가
	   			 ComEndConfigSheet(sheetObjects[i]);                
            }
          	initControl();
          	
          	// eg_id 값이 있는지 없는지로 grid 컬럼을 숨기거나 보여준다.
          	if(frm.eg_id.value ==""){
          		sheetObjects[0].ColHidden("eg_nm") = true;
          	}else{
          		sheetObjects[0].ColHidden("eg_nm") = false;
          	}

        }
        
         function initControl() {
          	var formObject = document.form;
              //Axon 이벤트 처리1. 이벤트catch(개발자변경)
              axon_event.addListenerFormat('keypress', 'keypressFormat', formObject);
              axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
          }

          //업무 자바스크립트 OnKeyPress 이벤트 처리
          function keypressFormat() {
          	obj = event.srcElement;
        	    if(obj.dataformat == null) return;
        	    window.defaultStatus = obj.dataformat;
        	    switch(obj.dataformat) {
        	        case "engup":
        	        	ComKeyOnlyAlphabet('upper');
        	            break;
        	            
        	        case "number":
        	        	ComKeyOnlyNumber(obj);
        	            break;
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
                case 1:      //IBSheet1 init
                    with (sheetObj) {
                        // 높이 설정
                        style.height = GetSheetHeight(10) ;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                        //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo(1, 1, 10, 100);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(11, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, true, true, false,false)

                        var HeadTitle = "||Code|Control Office|Name|Address|vndr_abbr_nm|prnt_vndr_seq|vndr_cnt_cd|org_vndr_seq|EG Name" ;

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, true);
                        HeadRowHeight = 12;
                        InitDataProperty(0, cnt++ , dtRadioCheck, 20,   daCenter,  false,    "radio",           false,          "",       dfNone,	    0,     true,        true);
                        InitDataProperty(0, cnt++ , dtCheckBox,   20,   daCenter,  false,    "checkbox",        false,          "",       dfNone,   	0,     true,       true);
                        
                        InitDataProperty(0, cnt++ , dtData,       60,   daCenter,  false,    "vndr_seq",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  false,    "ofc_cd",          false,          "",       dfNone,       0,     false,       true);                    
                        InitDataProperty(0, cnt++ , dtData,       150,  daLeft,    false,    "vndr_lgl_eng_nm", false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       300,  daLeft,    false,    "eng_addr",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,  false,    "vndr_abbr_nm",    false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,  false,    "prnt_vndr_seq",   false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,  false,    "vndr_cnt_cd",     false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,  false,    "org_vndr_seq",    false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,  false,    "eg_nm",           false,          "",       dfNone,       0,     false,       true);
                   }
                   break;
                   

            }
        }
        
      
      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction,a,PageNo) {
            sheetObj.ShowDebugMsg = false;
            
            switch(sAction) {
                        
               case IBSEARCH:         // 조회
            	    sheetObj.RemoveAll();
					frm.f_cmd.value = SEARCH01;
					var sParam = FormQueryString(frm);
//					ComOpenWait(true);
					var sXml = sheetObj.GetSearchXml("ESD_SPE_1022GS.do", sParam);
					sheetObj.loadSearchXml(sXml);
               break;

            }
        }

       /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
            with(formObj){
//                if (!ComIsNumber(vndr_cd)) {
//                	ComShowMessage(ComGetMsg("COM12122", "Service Provider Code"));
//                    return false;
//                }
//                
//                if (!ComIsNumber(pts_vndr_cd)) {
//                	ComShowMessage(ComGetMsg("COM12122", "Parent Service Provider Code"));
//                    return false;
//                }
            }

            return true;
        }

	/* 개발자 작업  끝 */