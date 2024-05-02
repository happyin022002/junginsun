/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TES_9090.js
*@FileTitle : User Password
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.10.06 yOng hO lEE
=========================================================*/

/**
 * @fileoverview User Password Input 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author SM LINE
 */

/**
 * @extends Tes
 * @class ESD_TES_9090 : User Password Input 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESD_TES_9090() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.setComboObject = setComboObject;
	this.setTabObject = setTabObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.initTab = initTab;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm;
}

/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

	/** 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	function processButtonClick(){
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			// form 이름에 주의하시기 바랍니다. 
			
			with(document.form) {
				switch (srcName) {
					// 버튼 이름으로 case를 넣어 주셔야 합니다. '
					
					case "btng_confirm":		
						if(document.form.openerUIName.value == "034" || document.form.openerUIName.value == "035" || document.form.openerUIName.value == "036"|| document.form.openerUIName.value == "0027"){
							document.form.f_cmd.value = SEARCH01;
						}else{				
							document.form.f_cmd.value = SEARCH;
						}
						action ='ESD_TES_9090.do';
						submit();
					case "btn_ok":		
						if(document.form.openerUIName.value == "034" || document.form.openerUIName.value == "035" || document.form.openerUIName.value == "036"|| document.form.openerUIName.value == "0027"){
							document.form.f_cmd.value = SEARCH01;
						}else{				
							document.form.f_cmd.value = SEARCH;
						}			
						action ='ESD_TES_9090.do';
						submit();	
						break;
					case "btn_close":						
						window.close();							
						break;						
				} // end switch
			}// end with
		} catch(e) {
			if( e = "[object Error]") {
				ComShowCodeMessage('TES21025');
			} else {
				ComShowMessage(e);
			}
		}
	}

	
	/**
	 * 
	 * @param {Object}	theForm
	 * @return
	 */
	function fnChkForm(theForm) {
		return true;
	}
	
	/**
	 * 
	 */
	function enter(){
		if ((event.keyCode==13)){
			if(document.form.openerUIName.value == "034" || document.form.openerUIName.value == "035" || document.form.openerUIName.value == "036"||document.form.openerUIName.value == "0027"){
				document.form.f_cmd.value = SEARCH01;
			}else{				
				document.form.f_cmd.value = SEARCH;
			}
			document.formaction ='ESD_TES_9090.do';
			document.form.submit();
		}
	}
	