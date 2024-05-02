/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0803.jsp
*@FileTitle : Collection Agency Remarks
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-12
*@LastModifier : O Wan-Ki
*@LastVersion : 1.0
* 2009-08-12 O Wan-Ki 1.0 최초 생성
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
     * @class ESD_TPB_0803 : ESD_TPB_0803 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_TPB_0803() {
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
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			// form 이름에 주의하시기 바랍니다. 
			with(document.form) {
				switch (srcName) {
					// 버튼 이름으로 case를 넣어 주셔야 합니다. 
					case "btn_retrieve":
						f_cmd.value = SEARCH;
						action ='ESD_TPB_0803.do';
						submit();	
						break;
					case "btn_save":
//						opener.form.s_clt_agn_rmk.value = s_clt_agn_rmk.value;
						window.returnValue = s_clt_agn_rmk.value;
						ComShowCodeMessage('COM12149','Data','','');
						window.close();
						break;
					case "btn_close":
						window.close();
						break;
				} // end switch
			}// end with
		} catch(e) {
			if( e = "[object Error]") {
				ComShowCodeMessage('COM12111');
			} else {
				ComShowMessage(e);
			}
		}
	}
	

	/* 개발자 작업  끝 */