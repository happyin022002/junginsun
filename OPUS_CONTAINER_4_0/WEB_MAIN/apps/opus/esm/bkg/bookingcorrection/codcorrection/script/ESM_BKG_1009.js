/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1009.js
*@FileTitle  : COD Remark
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/10
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// 공통전역변수
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1; 
var prefix1="sheet1_";
var sheetObjects=new Array();
var sheetCnt=0;
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject=sheetObjects[0];
         var sheetObject1=sheetObjects[1];
         /*******************************************************/
         var formObject=document.form;
		 var param="";
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
					case "btn_save":
						if (ComGetObjValue(formObject.isPop)=="R"){
							parent.document.all.codRemarkView1.style.visibility="hidden";
						}else{
							parent.document.form.codRemark.value=ComGetObjValue(formObject.diff_rmk);
							if (!ComIsEmpty(formObject.diff_rmk)){  
								parent.ComBtnColor("btn_remark","blue");
							} else {
								parent.ComBtnColor("btn_remark","#737373");					
							}
							parent.document.all.codRemarkView.style.visibility="hidden";
						}
						ComClosePopup();
					break; 
					case "btn_close":
						if (ComGetObjValue(formObject.isPop)=="R"){
							parent.document.all.codRemarkView1.style.visibility="hidden";
						}else{
							parent.document.all.codRemarkView.style.visibility="hidden";
						}
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
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	document.form.diff_rmk.value = parent.document.form.codRemark.value;
        for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
        }
        $(".pop_close").on("click", function(){
        	if (ComGetObjValue(document.form.isPop)=="R"){
				parent.document.all.codRemarkView1.style.visibility="hidden";
			}else{
				parent.document.all.codRemarkView.style.visibility="hidden";
			}
        });
    }
  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                break;
        }
    }
  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
		var arrPreFix=new Array("sheet1_");
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
