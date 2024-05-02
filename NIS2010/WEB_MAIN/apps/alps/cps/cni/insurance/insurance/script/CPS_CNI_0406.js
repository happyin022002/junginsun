/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CPS_CNI_0406.js
*@FileTitle : Detail2
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.10.12 윤세영
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
     * @class CPS_CNI_0406 : CPS_CNI_0406 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function CPS_CNI_0406() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.loadPage 				= loadPage;
    }
    
   	/* 개발자 작업	*/


	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){

		/*******************************************************/
		var formObject = document.form;
		try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
				case "btn_confirm":
				
			        if (!ComChkValid(formObject)) return false;

					var len = ComGetLenByByte(formObject.contents.value);
					if (len > 4000) {
						ComAlertFocus(formObject.contents, ComGetMsg("CNI09009", "Contents", "4000"));
					} else {
						eval("opener.form."+formObject.pop_cont_col.value).value= formObject.contents.value;
						
						//Interest와 Subject Matter Insured인 경우 name필드에도 세팅함.
						var pop_cont_col = formObject.pop_cont_col.value;
						if (pop_cont_col == "int_desc") {
							opener.form.int_desc_nm.value = formObject.contents.value;
						} else if (pop_cont_col == "subj_mat_ins_desc") {
							opener.form.subj_mat_ins_desc_nm.value = formObject.contents.value;
						}
						window.close();
					}
					
	            break;
				
				case "btn_close":
					window.close();
				break;  

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			alert("An unknown error occurred(in JavaScript source). Please verify your entry and try again. If the problem persists, please contact your system administrator.");
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	form.contents.value = form.pop_cont_hidden.value;
    }

	
	/* 개발자 작업  끝 */