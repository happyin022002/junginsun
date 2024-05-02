/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0706.jsp
*@FileTitle  : Mark And Description for C/M
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/15
=========================================================*/
   	/* 개발자 작업	*/
	// 공통전역변수
	var sheetObjects=new Array();
	var sheetCnt=0;
	var callback_func='';
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick=processButtonClick;
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
            	case "btn_OK":
					var mf_desc=formObject.cntr_mf_mk_desc.value;
					var cmdt_desc=formObject.cntr_mf_gds_desc.value;
					if(!validateForm(formObject)){
						return;
					}
					
					var localopener = (opener || parent);
					
//					if (!opener) opener=parent;
					if(callback_func != ''){
						eval('localopener.'+callback_func)(mf_desc, cmdt_desc);
					}
                //break;
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
        for(i=0;i<sheetObjects.length;i++){
        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
        	//khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
    }
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(formObj){
        with(formObj){
        	if( ComChkLenByByte(ComGetObjValue(cntr_mf_mk_desc), 3500) == 0){
                ComShowCodeMessage("COM12142","Marks & Numbers","3500");
                return false;
            }
        	if( ComChkLenByByte(ComGetObjValue(cntr_mf_gds_desc), 3500) == 0){
                ComShowCodeMessage("COM12142","Description for Customs","3500");
                return false;
            }
		}
        return true;
    }
    
    /*
     * MOUSE PASTE 이벤트
     */
    function mousePaste(obj){
    	setTimeout(function(){
        	checkSpecial(obj);	//특수문자 제외 로직
    	}, 100)
    }    
	/* 개발자 작업  끝 */
