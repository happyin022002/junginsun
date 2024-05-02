/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_4011.jsp 
*@FileTitle  : Average Cost Creation popup
*@author     : CLT
*@version    : 1.0
*@since      : 2015/07/20
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    var sheetObjects=new Array();
    var sheetCnt=0;
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
             var sheetObject=sheetObjects[0];
             /*******************************************************/
             var formObject=document.form;
        	try {
        		var srcName=ComGetEvent("name");
        		if(ComGetBtnDisable(srcName)) return false;
                switch(srcName) {
            	    case "btn_Close":
            	    	ComClosePopup(); 
            	        break;
            	    case "btn_Save":
        	            doActionIBSheet(sheetObject,formObject,IBSAVE);
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
         * Sheet 기본 설정 및 초기화
         * body 태그의 onLoad 이벤트핸들러 구현
         * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
         */
        function loadPage() {
        
            for(i=0;i<sheetObjects.length;i++){
    		    //khlee-시작 환경 설정 함수 이름 변경
                ComConfigSheet(sheetObjects[i]);
                initSheet(sheetObjects[i],i+1);
    		    //khlee-마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);
            }
        }
       /**
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
        function initSheet(sheetObj,sheetNo) {
            var cnt=0;
            switch(sheetNo) {
                case 1:      //sheet2 init
                    with(sheetObj){
		                  var HeadTitle="||" ;
		                  var HeadTitle1="||" ;
		
		                  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
		
		                  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		                  var headers = [ { Text:HeadTitle, Align:"Center"},
		                              { Text:HeadTitle1, Align:"Center"} ];
		                  InitHeaders(headers, info);
		
		                  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                         {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dummy",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		                   
		                  InitColumns(cols);
		
		                  SetEditable(1);//전체Edit허용여부[선택,Defaultfalse]
		                  SetVisible(false);
                  }
                    break;
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
         * Sheet 관 프로세스 처리
         */
    	function doActionIBSheet(sheetObj,formObj,sAction) {
    		sheetObj.ShowDebugMsg(false);
    		switch(sAction) {
    			case IBSAVE:        //저장
    				if(!validateForm(sheetObj,formObj,sAction))return false;
    				//업무처리중 버튼사용 금지 처리
//    		    	sheetObj.SetWaitImageVisible(0);
    			    ComOpenWait(true);
    		        formObj.f_cmd.value=MULTI01;
    		        //sheetObj.SetEtcData("BatchStatus","");
     		        //sheetObj.DoSearch("ESM_COA_4011GS.do", coaFormQueryString(formObj) );
    		        //var BatchStatus=sheetObj.GetEtcData("BatchStatus");
    		        
                    var sXml=sheetObj.GetSearchData("ESM_COA_4011GS.do", coaFormQueryString(formObj) );    
                    var BatchStatus = ComGetEtcData(sXml, "BatchStatus");
                    sheetObj.LoadSearchData(sXml,{Sync:0} );
                    
    				switch(BatchStatus){
    					case "R": // 작업 submit	
    						sheet1.RemoveAll();
    				        ComBtnDisable("btn_Save");
    						monitoringBatchJob();
    						break;
    					case "P"://해당 작업이 진행 중 
    						ComShowCodeMessage("COA00003", "Average Cost Creation");
    						ComOpenWait(false);  
    						break;
    					default: break;							
    				}  
    				break;
    		}
    	}
       /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
        	switch (sAction) {
            	case IBSAVE:
            		if(formObj.f_target_yrmon.value==""){
            			ComShowCodeMessage('COA10009','Taget Month','YYYY-MM');
            			return false;
            		}
            		if(formObj.f_fm_yrmm.value=="" || formObj.f_to_yrmm.value==""){
            			ComShowCodeMessage('COA10009','Period','YYYY-MM');
            			return false;
            		}
            		var yrdif=(formObj.f_to_yrmm.value.substring(0,4)-formObj.f_fm_yrmm.value.substring(0,4))*52;
            		var wkdif=formObj.f_to_yrmm.value.substring(5)-formObj.f_fm_yrmm.value.substring(5);
            		var duration=yrdif+wkdif;
            		//2017.01.11 NYK Add
            		if(formObj.f_cost_type.value=="acm_gen" && duration>4){
                        ComShowCodeMessage('COA10073', '5');
                        return false;
                    }
            		if(formObj.f_cost_type.value=="acm_oth" && duration>4){
            			ComShowCodeMessage('COA10073', '5');
            			return false;
            		}
            		if((formObj.f_cost_type.value=="nod_full" || formObj.f_cost_type.value=="nod_empty"|| formObj.f_cost_type.value=="trans_full"|| formObj.f_cost_type.value=="trans_empty"|| formObj.f_cost_type.value=="nod_full") && duration>2){
            			ComShowCodeMessage('COA10073', '3');
            			return false;
            		}
            		if((formObj.f_cost_type.value=="nod_incen" || formObj.f_cost_type.value=="trans_incen") && duration>11){
            			ComShowCodeMessage('COA10073', '12');
            			return false;
            		}
            		
            		formObj.f_cmd.value=SEARCH01;
             		sheetObj.DoSearch("ESM_COA_4011GS.do", coaFormQueryString(formObj) );
            		var TagetYrMonStatus=sheetObj.GetEtcData("TagetYrMonStatus");
            		if(TagetYrMonStatus=="Y"){
            			if(!ComShowConfirm('('+formObj.f_target_yrmon.value+')  '+ComGetMsg('COA10074'))){
            				return false;
            			}
            		}else{
            			if(!ComShowConfirm(ComGetMsg('COA10020'))){
            				return false;
            			}
            		}
            }
            return true;
        }
        /**
         * batch job monitoring 
         * 
         * @return 없음
         * @author 서미진
         * @version 2013.02.06
         */ 
        function monitoringBatchJob(){
        	//개발시에는 모니터링을 하지 않는다.
        	if(location.hostname == "localhost"){
        		return;
        	}
        	var sheetObj=sheetObjects[0];
        	var formObj=document.form;
        	formObj.f_cmd.value=SEARCH02;
         	var sXml=sheetObj.GetSearchData("ESM_COA_4011GS.do", FormQueryString(formObj));
        	var BatchStatus=ComGetEtcData(sXml, "BatchStatus");
        	if( BatchStatus == "P" ){
        		setTimeout(monitoringBatchJob,1000);
        	}else{
        		//20150817.ADD
        		if( BatchStatus == "E" ){
        			ComShowCodeMessage('COA10075');
            	} else {
            		ComBtnEnable("btn_Save");
            		ComShowCodeMessage('COA10018',"Creation");
            	}        		
        		ComOpenWait(false);
        	}
        }
