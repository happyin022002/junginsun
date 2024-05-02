/*=========================================================
* *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESM_BKG_1015.js
*@FileTitle : Relay Vessel Group Assign by relay Port_VVD Assign
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/10
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   	/* 개발자 작업	*/
// 공통전역변수
var sheetObjects=new Array();
var sheetCnt=0;
var prefix2="sheet2_";
var opener_obj=window.dialogArguments;
if (!opener_obj) opener_obj=parent;
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
		var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
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
					var parentObj=opener_obj.document.form;
					var parentRefSheet=eval(opener_obj.sheetObjects[1]);
					ComSetObjValue(parentObj.assignFlag,formObject.assignTpCd.value);
					with(parentRefSheet){
						for(var iRow=1;iRow<=RowCount();iRow++){
							 if (formObject.formerVvdChk.checked){ 
								 SetCellValue(iRow,prefix2+"old_vvd",GetCellValue(iRow,prefix2+"former_vvd"));
								 SetCellValue(iRow,prefix2+"former_vvd",ComGetObjValue(formObject.formerVvd));
							 }else if (formObject.nextVvdChk.checked){ 
								 SetCellValue(iRow,prefix2+"old_vvd",GetCellValue(iRow,prefix2+"next_vvd"));
								SetCellValue(iRow,prefix2+"next_vvd",ComGetObjValue(formObject.nextVvd));
							 }
						}
					}
					eval('opener_obj.callback_0950')();
					ComClosePopup(); 
					break;
				case "btn_close":
					ComClosePopup(); 
					break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e.message);
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
		//axon_event.addListenerForm  ('Change', 'bkg1015_Change', document.form);
		//axon_event.addListenerFormat('keypress','bkg1015_keypress',document.form); 
    }
    /*
	* onChange 이벤트 처리
	*/
	function bkg1015_Change(){
		obj=ComGetEvent();
		var formObject=document.form; 
		switch(ComGetEvent("name")){
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
		obj=ComGetEvent();
	    if(obj.dataformat == null) return;
	    window.defaultStatus=obj.dataformat; 
		var formObject=document.form; 
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
    
    function bkg1015_Blur(obj){
    	var formObj=document.form;
	    switch(ComGetEvent("name")) {
			case "formerVvd":
				ComSetObjValue(formObj.assignTpCd,"F");
				formObj.formerVvdChk.checked=true;
    			break;
	    	case "nextVvd":
				ComSetObjValue(formObj.assignTpCd,"N");
				formObj.nextVvdChk.checked=true;
    			break; 
    		default:
    			break;
    	}
	}
	/* 개발자 작업  끝 */ 
