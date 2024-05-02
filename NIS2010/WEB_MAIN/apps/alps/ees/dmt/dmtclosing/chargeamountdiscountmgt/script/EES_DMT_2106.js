/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EES_DMT_2106.js
*@FileTitle : Warning message.
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.07
*@LastModifier : 김현화
*@LastVersion : 1.0
* 2011.12.07 김현화
* 1.0 Creation
* 2011.12.07 KIM HYUN HWA [CHM-201114630-01][DMT]After-BKG-DAR Request 화면/기능 보완 - DR & Balance 관련
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
     * @class EES_DMT_2106 : EES_DMT_2106 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_2106() {    
    	this.processButtonClick		= tprocessButtonClick;
    	this.loadPage 				= loadPage;
 
    }     
   	/* 개발자 작업	*/    

    
	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
	
		/*******************************************************/
		var formObject = document.form;
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
				case "btn_Close": 
					  window.close();
				break;  
					
			} // end switch
		} catch(e) {
			if( e == "[object Error]") {
				ComFuncErrMsg(e); 
			} else {
				ComFuncErrMsg(e); 
			}	
		}
	}

	function loadPage() {
		
    
	}

	/* 개발자 작업  끝 */ 
