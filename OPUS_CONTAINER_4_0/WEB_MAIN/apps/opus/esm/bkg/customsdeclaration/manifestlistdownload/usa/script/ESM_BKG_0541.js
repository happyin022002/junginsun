/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0541.js
*@FileTitle  : US AMS: Main Menu
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
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author 
 */

/**
 * @extends 
 * @class US AMS: Main Menu : US AMS: Main Menu 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0541() {
    this.processButtonClick     = tprocessButtonClick;
    this.loadPage               = loadPage;
}

/* 개발자 작업  */

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
 function processButtonClick(){
    var formObject = document.form;

    try {
        var srcName = ComGetEvent("name");
        var isOpen = false;
        var sUrl = "";
        var sId = "";

        switch(srcName) {

            /*
             * Origin Office
             */
            // Preparation
            case "btn_1_1": // 1. C/M Data Input Checklist
                sUrl = "ESM_BKG_0111.do?pid=ESM_BKG_M045&mainPage=true&pgmNo=ESM_BKG_0111_02";
                sId = "ESM_BKG_0111";
                break;  

            case "btn_1_2": // 2. House B/L Data Input Checklist
                sUrl = "ESM_BKG_0393.do?pid=ESM_BKG_M045&mainPage=true&pgmNo=ESM_BKG_0393";
                sId = "ESM_BKG_0393";
                break;  
                
                
            // Manifest Transmit
            case "btn_2_1": // 1. Customs Data Download(D/L) - Origin Office
                sUrl = "ESM_BKG_0210.do?pid=ESM_BKG_M045&mainPage=true&pgmNo=ESM_BKG-0210_1";
                sId = "ESM_BKG_0210";
                break;  
            
            case "btn_2_2": // 2. Manifest Transmit (MI)
                sUrl = "ESM_BKG_0613.do?pid=ESM_BKG_M045&mainPage=true&pgmNo=ESM_BKG_0613";
                sId = "ESM_BKG_0613";
                break;
                
            case "btn_2_3": // 3. Vessel Departure Manifest (HI)
                sUrl = "ESM_BKG_0543.do?pid=ESM_BKG_M045&mainPage=true&pgmNo=ESM_BKG_0543";
                sId = "ESM_BKG_0543";
                break;
                
                
            // Manifest Amend
            case "btn_3_1": // 1. Amendment Transmit (AI)
                sUrl = "ESM_BKG_0028.do?pid=ESM_BKG_M045&mainPage=true&pgmNo=ESM_BKG_0028_1";
                sId = "ESM_BKG_0028";
                break;              
            
            case "btn_3_2": // 2. B/L Inquiry
                sUrl = "ESM_BKG_0034.do?pid=ESM_BKG_M045&mainPage=true&pgmNo=ESM_BKG_0034-01";
                sId = "ESM_BKG_0034";
                break;
                
                
            /*
             * U.S. Office
             */
            // I/B Documentation
            case "btn_IB_1": // //1. Customs Data Download(D/L) - U.S. Office
                sUrl = "ESM_BKG_0210.do?pid=ESM_BKG_M046&mainPage=true&pgmNo=ESM_BKG-0210_2";
                sId = "ESM_BKG_0210";
                break;  
                
            case "btn_IB_2": // 2. Manifest Transmit (MI)
                sUrl = "ESM_BKG_0613.do?pid=ESM_BKG_M046&mainPage=true&pgmNo=ESM_BKG_0613_2";
                sId = "ESM_BKG_0613";
                break;
                
            case "btn_IB_3": // 3. EDA Adjust 
                sUrl = "ESM_BKG_0233.do?pid=ESM_BKG_M046&mainPage=true&pgmNo=ESM_BKG_0233";
                sId = "ESM_BKG_0233";
                break;
                
            case "btn_IB_4": // 4. Vessel Arrival Manifest (HI)
                sUrl = "ESM_BKG_0514.do?pid=ESM_BKG_M046&mainPage=true&pgmNo=ESM_BKG_0514";
                sId = "ESM_BKG_0514";
                break;
                
            case "btn_IB_5": // 5. C/A Report (I/B)
                sUrl = "ESM_BKG_0568.do?pid=ESM_BKG_M046&mainPage=true&pgmNo=ESM_BKG_0568-1";
                sId = "ESM_BKG_0568";
                break;
                
            case "btn_IB_6": // 6. Amendment Transmit (AI) 
                sUrl = "ESM_BKG_0028.do?pid=ESM_BKG_M046&mainPage=true&pgmNo=ESM_BKG_0028_2";
                sId = "ESM_BKG_0028";
                break;
                
            case "btn_IB_7": // 7. B/L Inquiry 
                sUrl = "ESM_BKG_0034.do?pid=ESM_BKG_M046&mainPage=true&pgmNo=ESM_BKG_0034-03";
                sId = "ESM_BKG_0034";
                break;
                
            case "btn_IB_8": // 8. B/L Inquiry by Container
                sUrl = "ESM_BKG_0518.do?pid=ESM_BKG_M046&mainPage=true&pgmNo=ESM_BKG_0518";
                sId = "ESM_BKG_0518";
                break;
                
            case "btn_IB_9": // 9. Pre-Hold Notice Send
                sUrl = "ESM_BKG_0510.do?pid=ESM_BKG_M046&mainPage=true&pgmNo=ESM_BKG_0510";
                sId = "ESM_BKG_0510";
                break;
                
            
            // In-Bond Trans.
            case "btn_IT_1": // 1. P/MIB Generate
                sUrl = "ESM_BKG_0408.do?pid=ESM_BKG_M046&mainPage=true&pgmNo=ESM_BKG_0408";
                sId = "ESM_BKG_0408";
                break;
            
            case "btn_IT_2": // 2. In-Bond Arrival Manifest
                sUrl = "ESM_BKG_0533.do?pid=ESM_BKG_M046&mainPage=true&pgmNo=ESM_BKG_0533";
                sId = "ESM_BKG_0533";
                break;
            
            case "btn_IT_3": // 3. In-Transit Goods Manifest (SED Form 7513)
                sUrl = "ESM_BKG_0150.do?pid=ESM_BKG_M046&mainPage=true&pgmNo=ESM_BKG_0150";
                sId = "ESM_BKG_0150";
                break;
                
                
            // Code / Set-Up
            case "btn_CS_1": // 1. Entry Type Set-Up
                sUrl = "ESM_BKG_0540.do?mainPage=true&pgmNo=ESM_BKG_0540";
                sId = "ESM_BKG_0540";
                break;
            
            case "btn_CS_2": // 2. Customs Result Code Setup
                sUrl = "ESM_BKG_0947.do?mainPage=true&pgmNo=ESM_BKG_0947";
                sId = "ESM_BKG_0947";
                break;

                
            /*
             * E.T.C
             */
            // Stowage Plan
            case "btn_4_1": // 1. Vessel Stowage Plan Transmit (BAPLIE)
                sUrl = "ESM_BKG_1023.do?pgmNo=ESM_BKG_1023";
                sId = "ESM_BKG_1023";
                break;
                                
            
            // Report
            case "btn_AMS_1": // 1. Transmission History
                sUrl = "ESM_BKG_0507.do?pgmNo=ESM_BKG_0507";
                sId = "ESM_BKG_0507";
                break;
                
            case "btn_AMS_2": // 2. Receiving History
                sUrl = "ESM_BKG_0428.do?pgmNo=ESM_BKG_0428";
                sId = "ESM_BKG_0428";
                break;
                
            case "btn_AMS_3": // 3. Transmission Status Cross-Check
                sUrl = "ESM_BKG_0359.do?pgmNo=ESM_BKG_0359";
                sId = "ESM_BKG_0359";
                break;
                
            case "btn_AMS_4": // 4. AMS Report
                sUrl = "ESM_BKG_0041.do?pgmNo=ESM_BKG_0041_01&mainPage=true";
                sId = "ESM_BKG_0041";
                break;
                
            case "btn_AMS_5": // 5. Auto Filing NVOCC Transmission Status
                sUrl = "ESM_BKG_0574.do?pgmNo=ESM_BKG_0574";
                sId = "ESM_BKG_0574";
                break;
                
        } // end switch
        if (sId != "") module_pop(sUrl, sId);
    }catch(e) {
        if( e == "[object Error]") {
            ComShowMessage(OBJECT_ERROR);
        } else {
            ComShowMessage(e);
        }
    }
 }
 
 /**
  * 링크화면 오픈
  */
 function module_pop(url, id) {
     try {
        var btn_nm = ComGetEvent("name");
        var obj = document.getElementById(btn_nm);
        if (ComIsBtnEnable(btn_nm)) {
            var winObj = window.open(url + "&parentPgmNo=ESM_BKG_M001");
            winObj.focus();
        }
     } catch(err) { alert(err.message); }
 }
 
 /**
  * Office Type에 따라 버튼 비활성 처리
  */                  
 function loadPage() {
     if (document.form.ofcType.value == "US") {
         ComBtnDisable("btn_1_1");
         ComBtnDisable("btn_1_2");
         ComBtnDisable("btn_2_1");
         ComBtnDisable("btn_2_2");
         ComBtnDisable("btn_2_3");
         ComBtnDisable("btn_3_1");
         ComBtnDisable("btn_3_2");
     } else {
         ComBtnDisable("btn_IB_1");
         ComBtnDisable("btn_IB_2");
         ComBtnDisable("btn_IB_3");
         ComBtnDisable("btn_IB_4");
         ComBtnDisable("btn_IB_5");
         ComBtnDisable("btn_IB_6");
         ComBtnDisable("btn_IB_7");
         ComBtnDisable("btn_IB_8");
         ComBtnDisable("btn_IB_9");
         ComBtnDisable("btn_IT_1");
         ComBtnDisable("btn_IT_2");
         ComBtnDisable("btn_IT_3");
         ComBtnDisable("btn_CS_1");
         ComBtnDisable("btn_CS_2");
     }
    }
  
 /**
  * 버튼에 마우스 오버 시 처리
  */
 function obj_MouseOver() {
    var btn_nm = ComGetEvent("name");
    var obj = document.getElementById(btn_nm);
    if (ComIsBtnEnable(btn_nm)) {
        obj.style.textDecoration = "underline";
        obj.style.color = "#30A5D0";
    }
 }

 /**
  * 버튼에 마우스 아웃 시 처리
  */
 function obj_MouseOut() {
    var btn_nm = ComGetEvent("name");
    var obj = document.getElementById(btn_nm);
    if (ComIsBtnEnable(btn_nm)) {
        obj.style.textDecoration = "none";
        obj.style.color = "#737373";
    }
 }
/* 개발자 작업  끝 */