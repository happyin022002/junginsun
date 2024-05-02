/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1065.js
*@FileTitle : Rail Data Setup Pop-up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.10.28 박미옥
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
     * @class ESM_BKG_1065 : ESM_BKG_1065 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_1065() {
    	this.processButtonClick		= tprocessButtonClick;
    	//this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	//this.initSheet 				= initSheet;
    	//this.initControl            = initControl;
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
    
    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * 
     * @return 없슴
     */
    function processButtonClick(){
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

            case "img_avl_dt":
                var cal = new ComCalendar();
                cal.select(formObject.avl_dt, 'yyyy-MM-dd');
                break;
            
            case "img_fre_dt":
                var cal = new ComCalendar();
                cal.select(formObject.fre_dt, 'yyyy-MM-dd');
                break;
            
            case "btn_Setup":
            	doActionIBSheet(formObject,IBSAVE);
                break;                      

            case "btn_Close":
            	window.close();
                break; 
            
            } // end switch
        } catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }
    }


    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다 <br>
     * 
     * @return 없슴
     */
    function loadPage() {
        initControl();
    }
   
     
    /**
     * HTML 태그 이벤트를 등록한다. <br>
     * 
     * @return 없슴
     */
    function initControl() {
         axon_event.addListenerFormat("keypress","obj_KeyPress", form);
    }


    /**
     * Sheet관련 프로세스 처리 <br>
     * 
     * @param {ibsheet} sheetObj 필수,IBSheet 오브젝트
     * @param {object}  formObj  필수,HTML Form 오브젝트
     * @param {string}  sAction  필수,Action 명 
     * @return 없슴
     */
    function doActionIBSheet(formObj,sAction) {

    	switch(sAction) {
        case IBSAVE:
            if(validateForm(formObj,sAction) == false) break;
        
            var info = new Object();
            
            info.avl_dt     = formObj.avl_dt.value;
            info.fre_dt     = formObj.fre_dt.value;
            info.pkup_yd_cd = formObj.pkup_yd_cd.value;
            info.rtn_yd_cd  = formObj.rtn_yd_cd.value
            
            window.returnValue = info;

        	window.close();

        	break;
        }
    }
        

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * 
     * @param {ibsheet} sheetObj 필수,IBSheet 오브젝트
     * @param {object}  formObj  필수,HTML Form 오브젝트
     * @param {string}  sAction  필수,Action 명 
     * @return boolean Form 오브젝트 유효성 여부를 반환한다. 유효한 경우 true,  아닌 경우 false
     */
    function validateForm(formObj,sAction){
      	switch(sAction) {
     	case IBSEARCH:
  	    	if (!ComChkValid(formObj)) return false;
  	    	break;
        }
         	
        return true;
    }

    
    /* 개발자 작업  끝 */