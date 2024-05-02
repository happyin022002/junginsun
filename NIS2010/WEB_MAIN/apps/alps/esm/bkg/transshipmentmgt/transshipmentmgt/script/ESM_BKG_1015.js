/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1015.js
*@FileTitle : Relay Vessel Group Assign by relay Port_VVD Assign
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.09.21 최영희
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
     * @class ESM_BKG_1015 : ESM_BKG_1015 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_1015() {
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
var prefix2="sheet2_";
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
		var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "btn_save":
					if(ComIsEmpty(formObject.formerVvd) &&ComIsEmpty(formObject.nextVvd)){
						ComShowCodeMessage("BKG00007"); 
						return;
					}
					if(!ComIsEmpty(formObject.formerVvd) &&!ComIsEmpty(formObject.nextVvd)){
						ComShowCodeMessage("BKG02013"); 
						return;
					}

					if(!ComIsEmpty(formObject.formerVvd) && ComChkLen(formObject.formerVvd) !=2){
						return;
					}

					if(!ComIsEmpty(formObject.nextVvd) && ComChkLen(formObject.nextVvd) !=2){
						return;
					}

					var parentObj = window.dialogArguments.document.form;
					var parentRefSheet = eval(window.dialogArguments.sheetObjects[1]);
					 
					ComSetObjValue(parentObj.assignFlag,formObject.assignTpCd.value);
				 
					with(parentRefSheet){
						for(var iRow=1;iRow<Rows;iRow++){
							 if (formObject.formerVvdChk.checked){ 
                                CellValue(iRow,prefix2+"old_vvd")= CellValue(iRow,prefix2+"former_vvd");
								CellValue(iRow,prefix2+"former_vvd")=ComGetObjValue(formObject.formerVvd);	
								ComSetObjValue(parentObj.newVvd,ComGetObjValue(formObject.formerVvd));
							 }else if (formObject.nextVvdChk.checked){ 
                                CellValue(iRow,prefix2+"old_vvd")= CellValue(iRow,prefix2+"next_vvd"); 
								CellValue(iRow,prefix2+"next_vvd")=ComGetObjValue(formObject.nextVvd);		
								ComSetObjValue(parentObj.newVvd,ComGetObjValue(formObject.nextVvd)); 
							 }
						}
					}
					window.close();
					eval('window.dialogArguments.callback_0950')();
					
					break;

				case "btn_close":
					window.close();
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
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
		if (ComGetObjValue(document.form.formerTrnkFlg)=="Y"){
			document.form.formerVvd.readOnly=true;
            document.form.formerVvdChk.disabled=true;
		}
		if (ComGetObjValue(document.form.nextTrnkFlg)=="Y"){
			document.form.nextVvd.readOnly=true;
			document.form.nextVvdChk.disabled=true;
		}

		axon_event.addListenerForm  ('Change', 'bkg1015_Change', document.form);
		axon_event.addListenerFormat('keypress','bkg1015_keypress',document.form); 
    }
 
    /*
	* onChange 이벤트 처리
	*/
	function bkg1015_Change(){
		obj = event.srcElement; 
		var formObject = document.form; 
		switch(event.srcElement.name){
    	
	    	case "formerVvd":
				ComSetObjValue(formObject.assignTpCd,"F");
				formObject.formerVvdChk.checked=true;
				
    			break;
	    	case "nextVvd":
				ComSetObjValue(formObject.assignTpCd,"N");
				formObject.nextVvdChk.checked=true;
				 
    			break; 
    		default:
    			break;
    			 
    	}
		 
	}

	/*
	 * KeyPress Event 처리
	 */
    function bkg1015_keypress(){
		obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat; 
	    switch(obj.dataformat){ 
	        case "num": 
	        	ComKeyOnlyNumber(event.srcElement);
	            break;	 
			 case "engup": 
				 ComKeyOnlyAlphabet('uppernum'); 
	            break; 
	    }
		
		var formObject = document.form; 
		switch(event.srcElement.name){
    	
	    	case "formerVvd":
				ComSetObjValue(formObject.assignTpCd,"F");
				formObject.formerVvdChk.checked=true;
				
    			break;
	    	case "nextVvd":
				ComSetObjValue(formObject.assignTpCd,"N");
				formObject.nextVvdChk.checked=true;
				 
    			break; 
    		default:
    			break;
    			 
    	}
	}

	/* 개발자 작업  끝 */ 