/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0658.js
*@FileTitle  : Stop Off Cargo Order 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

 // 공통전역변수
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
		
        try {
        	var srcName=ComGetEvent("name");
        	switch(srcName) {    							
				case "btn_Save": 		
					validateForm(formObject);
				break;
				case "btn_Close":
					ComClosePopup(); 
				break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage("COM12111");
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
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }        	
        var formObject=document.form;
        var parentObject ;
        if (opener && opener.sheetObjects) parentObject =opener.document.form; 
        else if (parent && parent.sheetObjects) parentObject =parent.document.form; 
        
		if(!parentObject) {
			ComShowCodeMessage("COM12111");
		} else {
			formObject.stop_off_loc_cd.value=parentObject.stop_off_loc_cd.value;
	        formObject.stop_off_cntc_phn_no.value=parentObject.stop_off_cntc_phn_no.value;
	        formObject.stop_off_cntc_pson_nm.value=parentObject.stop_off_cntc_pson_nm.value;
	        formObject.stop_off_diff_rmk.value=parentObject.stop_off_diff_rmk.value;
		}

    	initControl();
    }
    function initControl() {
    }
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":      //sheet1 init
            	with(sheetObj){
	            	var HeadTitle="|";
	
	            	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	            	var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	            	var headers = [ { Text:HeadTitle, Align:"Center"} ];
	            	InitHeaders(headers, info);
	
	            	var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	            	             {Type:"Radio",     Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"chk" } ];
	            	 
	            	InitColumns(cols);
	
	            	SetVisible(0);
            	}
            	break;
        }
    }        
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj) {
		formObj.f_cmd.value=SEARCH;
		var sXml=sheetObj.GetSearchData("ESM_BKG_0658GS.do" , FormQueryString(formObj));
		if(ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
            var formObject=document.form;
			var stopOffLocCd=ComGetObjValue(formObject.stop_off_loc_cd);
			var stopOffCntcPhnNo=ComGetObjValue(formObject.stop_off_cntc_phn_no);
			var stopOffCntcPsonNm=ComGetObjValue(formObject.stop_off_cntc_pson_nm);
			var stopOffDiffRmk=ComGetObjValue(formObject.stop_off_diff_rmk);
			var calllFunc=formObject.calllFunc.value;
			if(calllFunc != ''){		
				if (ComFuncCheck("opener." + calllFunc)) ComFunc(new Array(stopOffLocCd, stopOffCntcPhnNo, stopOffCntcPsonNm, stopOffDiffRmk));
				else if (ComFuncCheck("parent." + calllFunc)) ComFunc(new Array(stopOffLocCd, stopOffCntcPhnNo, stopOffCntcPsonNm, stopOffDiffRmk));
			}         			
			ComClosePopup(); 
		} else {
			sheetObj.LoadSearchData(sXml);
		}
    }

     /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(formObject){
		var stopOffLocCd=ComGetObjValue(formObject.stop_off_loc_cd);
		var stopOffCntcPhnNo=ComGetObjValue(formObject.stop_off_cntc_phn_no);
		var stopOffCntcPsonNm=ComGetObjValue(formObject.stop_off_cntc_pson_nm);
		var stopOffDiffRmk=ComGetObjValue(formObject.stop_off_diff_rmk);
    	if(ComIsNull(ComGetObjValue(formObject.stop_off_loc_cd))){
			var calllFunc=ComGetObjValue(formObject.calllFunc);
			if(calllFunc != ''){		
				if (ComFuncCheck("opener." + calllFunc)) ComFunc(new Array(stopOffLocCd, stopOffCntcPhnNo, stopOffCntcPsonNm, stopOffDiffRmk));
				else if (ComFuncCheck("parent." + calllFunc)) ComFunc(new Array(stopOffLocCd, stopOffCntcPhnNo, stopOffCntcPsonNm, stopOffDiffRmk));
			}         			
			ComClosePopup(); 
    	}else{
        	if(formObject.stop_off_loc_cd.value.length > 5){
        		ComShowCodeMessage("COM12173","Location","5");
        	}else if(formObject.stop_off_cntc_phn_no.value.length > 20){
        		ComShowCodeMessage("COM12173","Tel","20");
        	}else if(formObject.stop_off_cntc_pson_nm.value.length > 30){
        		ComShowCodeMessage("COM12173","Contact Point","30");
        	}else{
        		doActionIBSheet(sheetObjects[0], formObject);
        	}    		
    	}
    }
	/* 개발자 작업  끝 */
