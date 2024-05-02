/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_COA_173.jsp
*@FileTitle :Average U/C Copy
*Open Issues :
*Change history :
	' 2010.01.07 김기식  ALPS FrameWork 적용
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 
* 2009-09-10 CHOI IN KYUNG 
* 1.0 최초 생성
=========================================================
* History
* 2011.03.08 김상수 Ticket ID:CHM-201109234-01 lane simulation 기능 보완
*                    - showErrMessage -> ComShowMessage로 수정
* 2011.12.23 최성민 [CHM-201114896-01] [COA] CM2 추가 개발 요청
* 2012.08.02 이석준[CHM-201219334-01] EQ Holding Cost 화면 Month Copy 기능 추가
* 2012.08.27 이석준[CHM-201219844-01]   ABC(PA)/STP Cost(RA)화면에 Month Copy 기능 추가 
* 2012.09.10 이석준 [CHM-201220070-01] EQ Repo Cost (PA) 화면에 Month Copy 기능 추가 
* 2012.09.12 이석준 [CHM-201220073-01] EMU Cost (RA) 에 Month Copy 기능 추가
* 2012.10.15 이석준 [CHM-201220161-01] 실시간 영업현황 관련 UI
* 2013.05.07 성미영 [CHM-201324182] Daily Hire by Cht-VSL / AVG hire by Own VSL / SMU 단가 화면 전월 copy 기능 추가
* 2013.05.10 최성민 [CHM-201324573-01] [COA] Domestic Saving Credit 화면 버튼 추가 
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
	// 월/주 입력 창에 금월 셋팅
	setYrMon();
	document.form.f_src_mon.focus();
    loadingMode = false;
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
    					if(formObject.f_src_mon.value >= formObject.f_tar_mon.value){
		    			 	ComShowCodeMessage('COA10051');
		    			 	formObject.f_src_mon.focus();
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
            case IBSAVE:        //저장
                if(!validateForm (formObj)) return false;
                
                if(formObj.f_class_id.value == "ESM_COA_0125") {
                	formObj.f_cmd.value = MULTI02;
			 	} else if(formObj.f_class_id.value == "ESM_COA_0182") {
			 		formObj.f_cmd.value = MULTI01;
			 		formObj.f_cost_use_tp_cd.value = "C";
			 	} else if(formObj.f_class_id.value == "ESM_COA_0013") {
			 		formObj.f_cmd.value = MULTI03;
			 	} else if(formObj.f_class_id.value == "ESM_COA_0012") { // ABC/STP Copy
			 		formObj.f_cmd.value = MULTI04;
			 	} else if(formObj.f_class_id.value == "ESM_COA_0009") { // EQ Repo Copy
			 		formObj.f_cmd.value = MULTI05;
			 	} else if(formObj.f_class_id.value == "ESM_COA_0115") { // EMU Cost
			 		formObj.f_cmd.value = MULTI06;
			 	} else if(formObj.f_class_id.value == "ESM_COA_0021") { // Manual Cost Set up
			 		formObj.f_cmd.value = MULTI07;
			 	} else if(formObj.f_class_id.value == "ESM_COA_0042") { // Dailyhire by Cht-VSL (PA)
			 		formObj.f_cmd.value = MULTI08;
			 	} else if(formObj.f_class_id.value == "ESM_COA_0043") { // AVG-hire by Own-VSL (PA)
			 		formObj.f_cmd.value = MULTI09;
			 	} else if(formObj.f_class_id.value == "ESM_COA_0117") { // SMU Cost (RA)
			 		formObj.f_cmd.value = MULTI10;
			 	} else if(formObj.f_class_id.value == "ESM_COA_0014") { // Domestic Saving Credit
			 		formObj.f_cmd.value = MULTI11;
			 	} else if(formObj.f_class_id.value == "ESM_COA_0177") { // Lane Table (1Cycle)
			 		formObj.f_cmd.value = MULTI12;
			 	} else {
			 		formObj.f_cmd.value = MULTI01 ;
			 		formObj.f_cost_use_tp_cd.value = "A";
			 	}
		 	   
                if (formObj.f_class_id.value == "ESM_COA_0009"){ // EQ Repo는 back-end로 처리 한다.
                	ComOpenWait(true);
                	 var sXml = sheetObj.GetSaveXml("ESM_COA_0173GS.do", coaFormQueryString(formObj));
                     var backEndJobKey = ComGetEtcData(sXml, "BackEndJobKey")
                     if (backEndJobKey.length > 0) {
                    	 formObj.backendjob_key.value = backEndJobKey;                    	         
                         sheetObj.RequestTimeOut = 7200;
                         timer = setInterval(getBackEndJobStatus, 5000); // 5초 후에 getBackEndJobStatus함수 실행 - 재귀호출                                             
                     }
                } else {
//                	sheetObj.DoAllSave("ESM_COA_0173GS.do", coaFormQueryString(formObj,'f_cmd',true), -1, false);
                	var sXml = sheetObj.GetSaveXml("ESM_COA_0173GS.do", coaFormQueryString(formObj));
                	var save_result = ComGetEtcData(sXml, "TRANS_RESULT_KEY")
                	
                	if (save_result == 'S'){
                		ComShowMessage(ComGetMsg("COA00004","Data Copy"));
                		window.close();
                	} else {
                		ComShowMessage(ComGetMsg("COA00005","Data Copy","Data Copy"));
                	}
                }
//                ComOpenWait(false);
                break;
                
        }
    }
    
	/**
     * 입력창에 금월 셋팅
     * 사용 : setYrMon()
     *
     * @param NONE
     * @return NONE
     */
    function setYrMon(){
    	var formObj = document.form;
    	with(formObj){
            var nowYear = ComGetNowInfo("yy");
            var nowMon  = ComGetNowInfo("mm").lpad(2, "0");
    		var nowYrMon = nowYear + nowMon;

    		f_src_mon.value = ComGetMaskedValue(nowYrMon,'ym');
    		f_tar_mon.value = ComGetMaskedValue(nowYrMon,'ym');
    		//addDash(f_src_mon , 4);
    		//addDash(f_tar_mon , 4);
    	}
    }

	/**
	* 화면 폼입력값에 대한 유효성검증 프로세스 처리
	*/
	function validateForm(formObj){
		with(formObj){
            if(!ComChkObjValid(f_src_mon, null, null, "yw")) return false;
            if(!ComChkObjValid(f_src_mon, null, null, "yw")) return false;
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
