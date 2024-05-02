/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_3599.js
*@FileTitle  : Tariff Rule Compare
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/22
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/* 개발자 작업  */
// 공통전역변수
var sheetObjects=new Array();
var sheetCnt=0;
//저장 메세지를 구분하기 위해 사용됨.
var supressConfirm=false;
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
 * <br><b>Example :</b>
 * <pre>
 *     processButtonClick();
 * </pre>
 * @return 없음
 * @author 송민석
 * @version 2010.10.19
 */
function processButtonClick(){
     /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/          
     var sheetObject1=sheetObjects[0];          
     /*******************************************************/
     var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        switch(srcName) {
            case "btn_Close":
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
 * IBSheet Object를 배열로 등록 <br>
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
 * 배열은 소스 상단에 정의 <br>
 * <br><b>Example :</b>
 * <pre>
 *     setSheetObject(sheetObj);
 * </pre>
 * @param {ibsheet} sheet_obj 필수 IBSheet Object
 * @return 없음
 * @author 최성민
 * @version 2010.10.19
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++]=sheet_obj;
}
/**
* Sheet 기본 설정 및 초기화 <br>
* body 태그의 onLoad 이벤트핸들러 구현 <br>
* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
* <br><b>Example :</b>
* <pre>
*     loadPage();
* </pre>
* @return 없음
* @author 송민석
* @version 2010.10.19
*/
function loadPage() {
}
/* 개발자 작업  끝 */
