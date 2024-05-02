/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0968.js
*@FileTitle :  DG Declare Main Menu (EU)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.07.31 경종윤
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
     * @class esm_bkg_0968 : esm_bkg_0968 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0968() {
    	this.processButtonClick		= processButtonClick;
    	this.loadPage 				= loadPage;
    }

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
    
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	var formObject = document.form;
    	try {
       		var srcName = window.event.srcElement.getAttribute("id");
       		var isOpen = false;
       		var sUrl = "";
       		var sId = "";
       		
       		var ofcCd = formObject.ofcCd.value;
       		var sId = "";
       		
       		//alert("ofcCd : " + ofcCd);
       		
       		if(ofcCd != "ANRSO") { // 기타 유럽
           		switch(srcName) {
					case "btn_1_1":
						sUrl = "ESM_BKG_0966.do&pgmNo=ESM_BKG_0966&d_type=D";
						sId = "ESM_BKG_0966";
						break;
					case "btn_1_2":
						sUrl = "ESM_BKG_0966.do&pgmNo=ESM_BKG_0966&d_type=T";
						sId = "ESM_BKG_0966";
						break;
					case "btn_1_3":
						sUrl = "ESM_BKG_0966.do&pgmNo=ESM_BKG_0966&d_type=L";
						sId = "ESM_BKG_0966";
						break;
					case "btn_2_1":
						sUrl = "ESM_BKG_0970.do&pgmNo=ESM_BKG_0970&callGubun=ESM_BKG_0966";
						sId = "ESM_BKG_0970";
						break;
           		} // end switch()
       			
       		} else { // 벨기에

           		switch(srcName) {
					case "btn_1_1":
						sUrl = "ESM_BKG_0965.do&pgmNo=ESM_BKG_0965&d_type=D";
						sId = "ESM_BKG_0965";
						break;
					case "btn_1_2":
						sUrl = "ESM_BKG_0965.do&pgmNo=ESM_BKG_0965&d_type=T";
						sId = "ESM_BKG_0965";
						break;
					case "btn_1_3":
						sUrl = "ESM_BKG_0965.do&pgmNo=ESM_BKG_0965&d_type=L";
						sId = "ESM_BKG_0965";
						break;
					case "btn_1_4":
						sUrl = "ESM_BKG_0965.do&pgmNo=ESM_BKG_0965&d_type=P";
						sId = "ESM_BKG_0965";
						break;
					case "btn_1_5":
						sUrl = "ESM_BKG_0965.do&pgmNo=ESM_BKG_0965&d_type=O";
						sId = "ESM_BKG_0965";
						break;
					case "btn_2_1":
						sUrl = "ESM_BKG_0970.do&pgmNo=ESM_BKG_0970&callGubun=ESM_BKG_0965";
						sId = "ESM_BKG_0970";
						break;
					case "btn_3_1":
						sId = "";
						var sParam = "pageType=MAIN";
						ComOpenWindowCenter("/hanjin/ESM_BKG_0969.do?"+sParam, "ESM_BKG_0969", 600, 400, false);
						break;
					case "btn_3_2":
						sId = "";
						var sParam = "pageType=MAIN";
						//var sParam = "vvd_cd="+vvdCd+"&pol_cd="+polCd+"&pod_cd="+podCd;
						ComOpenWindowCenter("/hanjin/ESM_BKG_0977.do?"+sParam, "ESM_BKG_0977", 600, 400, false);
						break;
						
           		} // end switch

       			
       		} // end if
       		
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
     * 
     * @param url
     * @param id
     * @return
     */
    function module_pop(url, id) {
        try {
        	var btn_nm = window.event.srcElement.getAttribute("id");
        	var obj = document.getElementById(btn_nm);
        	if (ComIsBtnEnable(btn_nm)) {
	            var iWidth = 1040;
	            var iHeight = 700;
	            var leftpos = (screen.width - iWidth)/2;    if(leftpos<0) leftpos=0;
	            var toppos  = (screen.height- iHeight)/2;   if(toppos<0)  toppos=0;
	            var sFeatures = "status=no, width="+iWidth+", height="+iHeight+", resizable=yes, scrollbars=yes, left="+leftpos+", top="+toppos;
	            var winObj = window.open("/hanjin/alpsMain.screen?parentPgmNo=ESM_BKG_M001&pgmUrl=^hanjin^" + url, id, sFeatures);
	            winObj.focus();
        	}
        } catch(err) { 
        	ComShowMessage(err.message); 
        }
    }
    
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */                  
    function loadPage() {
    	 axon_event.addListener('MouseOver', 'obj_MouseOver', "form");
    	 axon_event.addListener('MouseOut', 'obj_MouseOut', "form");
	}
    
    /**
     * 마우스오버 이벤트
     * @return
     */
    function obj_MouseOver() {
    	var btn_nm = window.event.srcElement.getAttribute("id");
    	var obj = document.getElementById(btn_nm);
    	if (ComIsBtnEnable(btn_nm)) {
        	obj.style.textDecoration = "underline";
        	obj.style.color = "#30A5D0";
    	}
    }
    
    /**
     * 마우스 아웃 이벤트
     * @return
     */
    function obj_MouseOut() {
    	var btn_nm = window.event.srcElement.getAttribute("id");
    	var obj = document.getElementById(btn_nm);
    	if (ComIsBtnEnable(btn_nm)) {
        	obj.style.textDecoration = "none";
        	obj.style.color = "#737373";
    	}
    }

	/* 개발자 작업  끝 */