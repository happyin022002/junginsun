/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_OPF_1206.js
*@FileTitle : Reject Reason Remarks
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.07.30 김종옥
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
     * @class VOP_OPF_1206 : VOP_OPF_1206 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_OPF_1206() {
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

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1; 
var prefix1="sheet1_";
var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         var sheetObject1 = sheetObjects[1];

         /*******************************************************/
         var formObject = document.form;
		 var param="";
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
					case "btn_save":
						parent.document.form.rejectRmk.value= ComGetObjValue(formObject.rejectRmk);  
						parent.document.all.rejectRmkView.style.visibility="hidden";
						break; 
          
					case "btn_close":
						if(ComGetObjValue(formObject.isPop)=="C"){
							parent.document.all.codRemarkView.style.visibility="hidden";
						}else if(ComGetObjValue(formObject.isPop)=="R"){
							parent.document.all.rejectRmkView.style.visibility="hidden";
						}else if(ComGetObjValue(formObject.isPop)=="Q"){
							parent.document.all.qtyView.style.visibility="hidden";
						}
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

    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
        }

        return true;
    }

	/* 개발자 작업  끝 */