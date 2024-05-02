/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0770.js
*@FileTitle  : VVD Selection Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/02
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author 
     */
    /**
     * @extends 
     * @class esm_bkg_0770 : esm_bkg_0770 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
   	/* 개발자 작업	*/
 // 공통전역변수
 var sheetObjects=new Array();
 var sheetCnt=0;
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick=processButtonClick;
 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		
			if(ComGetBtnDisable(srcName)){
				return false;
			}

             switch(srcName) {
 		       case "btn_ok":
	    		  var opener = window.dialogArguments;
	    		  if (!opener) opener = parent;
	    		  	if (opener.getCOM_EMER_NO_POPUP == undefined) {
	    		  		return ComShowMessage('Cannot find opener.getCOM_EMER_NO_POPUP() or parent.getCOM_EMER_NO_POPUP() js function');
	    		  	}
	    		  	var item = document.getElementsByTagName("input");
	    		  	var rArray =  new Array(1); //데이터를 담고 있는 배열
	    			rArray[0] = new Array(item.length);
	    			for (var i=0; i < item.length; i++) {
	    				if ( item[i].type == "text" || item[i].type == "hidden" ) {
	    					rArray[0][i] = item[i].value;
	    				}
	    			}
	    		  	opener.getCOM_EMER_NO_POPUP(rArray);
	    		  	ComClosePopup();
 		    	  //comPopupOK();								
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
     function loadPage() {
    	 //READ ONLY
    	 //Own : OA (Own DG Approval) 
    	 //Partner 승인 : PA (Partner DG  Approval)
    	 if(document.form.pop_type.value=="PA" || document.form.pop_type.value=="OA" ){
    		 ComBtnDisable("btn_ok");
    		 setBookingEditable(document.form.pop_type.value, false);
    	 }
    	 initControl();
     }
     function setBookingEditable(type, isEnable) {
 		var formObj=document.form;
 		if(type=="PA"){
 	 		BkgEnableObject(formObj.imdg_emer_no, isEnable);
 	 		BkgEnableObject(formObj.ctrl_temp_ctnt, isEnable);
 	 		BkgEnableObject(formObj.emer_rspn_gid_no, isEnable);
 	 		BkgEnableObject(formObj.emer_temp_ctnt, isEnable);
 	 		BkgEnableObject(formObj.emer_rspn_gid_chr_no, isEnable);
 			
 		}else{
 	 		BkgEnableObject(formObj.imdg_emer_no, isEnable);
 	 		BkgEnableObject(formObj.ctrl_temp_ctnt, isEnable);
 	 		BkgEnableObject(formObj.emer_rspn_gid_no, isEnable);
 	 		BkgEnableObject(formObj.emer_temp_ctnt, isEnable);
 	 		BkgEnableObject(formObj.erap_no, isEnable);
 	 		BkgEnableObject(formObj.emer_rspn_gid_chr_no, isEnable);
 	 		BkgEnableObject(formObj.erap_cntc_no, isEnable);
 	 		BkgEnableObject(formObj.erap_apro_ref_no, isEnable);
 		}
 		
     }
     
     
     function initControl() {    	  
   	    //Axon 이벤트 처리1. 이벤트catch(개발자변경)
   	    axon_event.addListenerForm('keypress','obj_keypress', form);
   	} 
     function obj_keypress(){
 		switch (event.srcElement.name) {		
 		    case "ctrl_temp_ctnt":		    	
 		    	ComKeyOnlyNumber(event.srcElement, "-.");   	
 			break;
 		    case "emer_temp_ctnt":		    	
 		    	ComKeyOnlyNumber(event.srcElement, "-.");   	
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
/* 개발자 작업  끝 */
