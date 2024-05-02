/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_MAS_0113.js
*@FileTitle : Select Creation Type
*Open Issues :
*Change history :2009.09.11 박수훈 New FrameWork 적용
*@LastModifyDate : 2009.09.11
*@LastModifier : 박수훈
*@LastVersion : 1.0
* 2009.09.11 박수훈
* 1.0 Creation
=========================================================*/
// 공통전역변수


var sheetObjects = new Array();
var sheetCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */

document.onclick = processButtonClick;
    
    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        var formObject = document.form;
    
        try {
            var srcName = window.event.srcElement.getAttribute("name");
            
            switch(srcName) {
                case "btn_Close":
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
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
            if (!ComIsNumber(iPage)) {
                return false;
            }
        }
    
        return true;
    }
