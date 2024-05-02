/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_COA_9001.jsp
*@FileTitle :Week Copy
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 
* 2014-06-18 CHOI DUK WOO 
* 1.0 최초 생성 
========================================================= */

/* 공통전역변수 */
var sheetObjects = new Array();
var sheetCnt = 0;
var timer = null;
var back_end_job_sts = 3;//Save 버튼이나 Close 버튼 컨트롤
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
    var formObject = document.form;

    loadingMode = true;

    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
   
    //년-주 창에 셋팅
    doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
    var cnt = 0;

    switch(sheetNo) {
        case 1:      //sheet1 init
            with (sheetObj) {
                style.height = GetSheetHeight(14) ;
                SheetWidth = mainTable2.clientWidth;                         //전체 너비 설정
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);     //Host정보 설정[필수][HostIp, Port, PagePath]
                InitRowInfo(1 , 1, 9, 100);                                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitColumnInfo(1, 0, 0, true);                             //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitHeadMode(true, true, false, true, false, false);         //해더에서 처리할 수 있는 각종 기능을 설정한다
                var HeadTitle  = "STS";
                InitHeadRow(0, HeadTitle, false);                           //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtStatus,  30,   daCenter, true, "ibflag");              

                WaitImageVisible = false;

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
    sheetObjects[sheetCnt++] = sheet_obj;
}

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;


	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		var sheetObject = sheetObjects[0];
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
			    //저장
    			case "btn_save":
                
    				if(validateForm(formObject)){
    					
    					if (back_end_job_sts == 2){
    						ComShowMessage(ComGetMsg("COA00003","Back-end Job"));
    						return false;
    					}
    					if(formObject.f_src_week.value >= formObject.f_tar_week.value){
		    			 	ComShowCodeMessage('COA10072');
		    			 	formObject.f_src_week.focus();
		    			 	return false;
	    				}
    					
    					if(ComShowConfirm(ComGetMsg('COA10052'))){    						
    						 doActionIBSheet(sheetObject,formObject,IBSAVE);
    						
	    			 	 }
    				}
    				break;
    			case "btn_close":
					if (back_end_job_sts == 2){
						ComShowMessage(ComGetMsg("COA00003","Back-end Job"));
						return false;
					}    				
					window.close();
					break;
			} // end switch
		} catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(ComGetMsg("COM12111", "", ""));
			} else {
				ComShowMessage(e);
			}
		}
	}

    /**
     * Sheet관련 프로세스 처리
     */
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {
	        case IBCLEAR:          //조회
	        	sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = INIT;
				
				var sXml = sheetObj.GetSearchXml("ESM_COA_0021GS.do", coaFormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				
				
				if (0 < arrXml.length) {
				   prevWeek = ComGetEtcData(arrXml[0],"prevWeek");
				   fYear = ComGetEtcData(arrXml[0], "fYear"); 
	//			   frmObj.f_yrtype[1].onclick = function(){setYrWk(fYear,prevWeek)};
				  
				   setYrWk(fYear,prevWeek);
				}
				
	//			setYrMon();  // 월/주 입력 창에 금월 셋팅
	
				ComOpenWait(false);
				break;
				
            case IBSAVE:        //저장
                if(!validateForm (formObj)) return false;
                
                if(formObj.f_class_id.value == "ESM_COA_0024") {
                	formObj.f_cmd.value = MULTI01;
			 	}
		 	                  
//             	sheetObj.DoAllSave("ESM_COA_0173GS.do", coaFormQueryString(formObj,'f_cmd',true), -1, false);
            	var sXml = sheetObj.GetSaveXml("ESM_COA_9001GS.do", coaFormQueryString(formObj));
            	var save_result = ComGetEtcData(sXml, "TRANS_RESULT_KEY")
            	
            	if (save_result == 'S'){
            		ComShowMessage(ComGetMsg("COA00004","Data Copy"));
            		window.close();
            	} else {
            		ComShowMessage(ComGetMsg("COA00005","Data Copy","Data Copy"));
            	}
//                ComOpenWait(false);
                break;
                
        }
    }
        
    function setYrWk(fYear, prevWeek){
    	var formObj = document.form;
    	with(formObj){
//    		var nowYear = fYear;
    		var nowYrweek = fYear+prevWeek;	
    		
    		f_src_week.value = ComGetMaskedValue(nowYrweek,'yw');
    		f_tar_week.value = ComGetMaskedValue(nowYrweek,'yw');
    	}
    }
    
	/**
	* 화면 폼입력값에 대한 유효성검증 프로세스 처리
	*/
	function validateForm(formObj){
		with(formObj){
            if(!ComChkObjValid(f_src_week, null, null, "yw")) return false;
            if(!ComChkObjValid(f_tar_week, null, null, "yw")) return false;
		}
		return true;
	}
	
	/**
	 * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
	 */
	function getBackEndJobStatus() {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];

		formObj.f_cmd.value = COMMAND02;
		var sXml = sheetObj.GetSearchXml("ESM_COA_0173GS.do", FormQueryString(formObj));
		var jobState = ComGetEtcData(sXml, "jb_sts_flg");
		back_end_job_sts = jobState;

		if (jobState == "3") { // 성공
			ComOpenWait(false);
			ComShowMessage(ComGetMsg("COA00004","Data Copy"));
			clearInterval(timer);
			window.close();
		} else if (jobState == "4") {
			ComOpenWait(false);
			ComShowCodeMessage("COA00001");
			sheetObj.WaitImageVisible = true;
			clearInterval(timer);
		} else if (jobState == "5") {
			ComOpenWait(false);
			ComShowCodeMessage("COA00002");
			
			clearInterval(timer);
		}
	}
	
	/**
	* 저장메세지 지정
	*/
	function sheet1_OnSaveEnd(sheetObj,errMsg){
		if(errMsg == ""){
			ComShowMessage(ComGetMsg("COA00004","Data"));
		}
	}
