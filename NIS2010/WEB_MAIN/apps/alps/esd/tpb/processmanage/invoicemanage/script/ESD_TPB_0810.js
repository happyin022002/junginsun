/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0810.js
*@FileTitle : Invoice Cancel Remark 
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-12
*@LastModifier : Park Sung-Jin
*@LastVersion : 1.2
* 2008-12-05 Kim Jin-seung 최초생성
* 2009-08-12 O Wan-Ki
* 2009-10-12 Park Sung-Jin 1.2 ALPS Migration 작업
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
     * @class ESD_TPB_0810 : ESD_TPB_0810 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_TPB_0810() {
    	this.processButtonClick     = processButtonClick;
        this.setSheetObject         = setSheetObject;
        this.setComboObject         = setComboObject;
        this.setTabObject           = setTabObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;        
        this.initControl            = initControl;
        this.initTab                = initTab;
        this.doActionIBSheet        = doActionIBSheet;
        this.validateForm           = validateForm;
    }
    
   	/* 개발자 작업	*/
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	function processButtonClick(){
		var srcName = window.event.srcElement.getAttribute("name");
		// form 이름에 주의하시기 바랍니다. 
		with(document.form) {
			switch (srcName) {
			case "btn_save":
			    var rtnVal = new Array(1);
			    rtnVal[0] = document.form.s_invoice_cancel_remark.value;

                if ( rtnVal==null || rtnVal.length==0){
                    /// There is no valid Message data! 
                    ComShowCodeMessage('TPB90045');
                    return;
                } else {
                       window.returnValue = rtnVal;
                       window.close();
                    // }
                }
				break;		
			case "btn_close":
			    window.returnValue = null; 
				window.close();
				break;
			} // end switch
		}// end with
	}
	/* 개발자 작업  끝 */