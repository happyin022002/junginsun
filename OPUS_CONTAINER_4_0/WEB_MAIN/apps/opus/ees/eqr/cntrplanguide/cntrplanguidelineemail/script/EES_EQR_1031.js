/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_1031.js
*@FileTitle  : Guideline Mailing
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/09
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	var sheetObjects=new Array();
	var sheetCnt=0;
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 
	document.onclick=processButtonClick;
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 
    function processButtonClick() {
		var sheetObject=sheetObjects[0];
	    var sheetObject1=sheetObjects[1];
	    var sheetObject2=sheetObjects[2];
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(!ComIsBtnEnable(srcName) ) return;
            switch(srcName) {
     	        case "btn_retrieve":
    	            doActionIBSheet(sheetObject,formObject,SEARCH01);
        	    break;
    			case "btns_open_ofc":		//Office Code
    				openPopup();
    			break;
    			case "btn_close":
    				ComClosePopup();
    			break;
    			case "btn_mailsend":
    				sendMail();
    			break;        	        
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			//ComShowMessage(OBJECT_ERROR);
    			ComShowCodeMessage("EQR90004");
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
    	var formObj=document.form;
        for(i=0;i<sheetObjects.length;i++){
        	//시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            //initSheet(sheetObjects[i],i+1);  // 표현할 GRID 없으므로 주석처리
    		//마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
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
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
//           case IBSEARCH:      // 왼쪽 그리드 조회 (SINGLE BKG 오픈시 자동조회)
//                	                
//                formObj.f_cmd.value = SEARCHLIST;
//                sheetObj.DoSearch("EES_EQR_1052GS.do", eqrFormQryStr(formObj));
//
//                break;                
        }
    }
	/**
	 * Office Pop-up Open 부분<br>
	 */
	function openPopup() {
		ComOpenPopupWithTarget('/opuscntr/COM_ENS_071.do', 755, 500, "ofc_cd:f_ofccd", "1,0,1,1,1,1,1,1", true);
		return;
	}	
	/*
	 * 공통 메일발송에 화면 보내줄 정보를 조회
	 */
	function sendMail() {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
	    formObj.f_cmd.value=SEARCH;	
 	    var sXml=sheetObj.GetSearchData("EES_EQR_1031GS.do", FormQueryString(formObj));
		var subject="Newly updated Lane information of MT Reposition Guideline";
		var content="";
		var from="EQR@opuscntr.com"; // 송신자		
		var recipient=ComGetEtcData(sXml, "recipient");;    // 수신자
		var vsl_lane_cd=ComGetEtcData(sXml, "vsl_lane_cd");;  // 가장최근 저장된 lane 정보;
		content="Dears,<br>"
			    + "<br>" 			
				+ "MT Reposition Guideline for "+vsl_lane_cd+" Lane has been newly updated.<br>" 
				+ "Details could be refered at ▶ ALPS > Equipment Management > EQ Repositon > MTY Repo Guideline > Guideline Inquiry.<br>" 
				+ "Please maximize the MT loading based on the newly updated guideline without failure." 
				+ "<br>" 
				+ "<br>" 
			    + "<br>" 					
				+ "Best regards,<br>" 				
				+ "CTY-EQ." 	
		// 메일발송 공통화면으로 셋팅			
		document.form.com_subject.value=subject;    // 메일 제목 셋팅
		document.form.com_content.value=content;    // 메일 본문내용 셋팅
		document.form.com_from.value=from;       // 메일 발송자 셋팅
		document.form.com_recipient.value=recipient;  // 메일 수신자 셋팅		
		ComSendMailModal();  // 공통메일 화면 호출
	}	
	/* 개발자 작업  끝 */
