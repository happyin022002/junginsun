/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1115.js
*@FileTitle : ESP Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.08.31 조재성
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/


/**
 * @extends 
 * @class EES_CGM_1115 : EES_CGM_1115 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function EES_CGM_1115() {
	this.processButtonClick		= tprocessButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initControl            = initControl;
	this.doActionIBSheet 		= doActionIBSheet;
	this.setTabObject 			= setTabObject;
	this.validateForm 			= validateForm;
}
    
/* 개발자 작업	*/

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var timer = 0;
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
 * @param 없음
 * @return 없음
 * @author 조재성
 * @version 2009.08.31
 */ 
function processButtonClick(){
    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
    /*******************************************************/
    var formObject = document.form;

    try {
    	var srcName = window.event.srcElement.getAttribute("name");
        switch(srcName) {
			case "btn_Retrieve":
				if(validateForm(sheetObject,formObject,IBSEARCH) != false){
					sheetObject.RemoveAll();
                	doActionIBSheet(sheetObject, formObject, IBSEARCH);
                }
				break;
								
			case "btn_New":
				initControl();
				break;
			case "btns_scc_cd":
	            var tmp = "SCC";
	            if(tmp == "RCC"){
            		//ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 450,"rcc_cd:crnt_loc_cd", "1,0,1,1,1,1,1", true);
            		//ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 450, "callBackLocation", "1,0,1,1,1,1,1", true, false);
            		ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 460, "callBackLocationSCC", "0,1,1,1,1,1,1", true, false);
            	} else if(tmp == "LCC") {
            		//ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 450,"lcc_cd:crnt_loc_cd", "1,0,1,1,1,1,1", true);
            		//ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 450, "callBackLocation", "1,0,1,1,1,1,1", true, false);
            		ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 460, "callBackLocationSCC", "0,1,1,1,1,1,1", true, false);	            		
            	} else if(tmp == "SCC") {
            		//ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 450,"scc_cd:crnt_loc_cd", "1,0,1,1,1,1,1", true);
            		ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 460, "callBackLocationSCC", "1,0,1,1,1,1,1", true, false);
            		//ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 450, "callBackLocationSCC", "0,1,1,1,1,1,1", true, false);	            		
            	}
	            break;
			case "btns_troughput_inq_fm_dys":
            	var cal = new ComCalendar();
            	cal.setDisplayType('month');
            	//cal.select(formObject.troughput_inq_fm_dys, "yyyy-MM");
            	cal.select(formObject.troughput_inq_fm_dys, "yyyy-MM");
				break;
				
			case "btns_troughput_inq_to_dys":
            	var cal = new ComCalendar();
            	cal.setDisplayType('month');
            	cal.select(formObject.troughput_inq_to_dys, "yyyy-MM");
				break;
				
			case "btns_turn_time_inq_fm_dys":
            	var cal = new ComCalendar();
            	cal.setDisplayType('month');
            	cal.select(formObject.turn_time_inq_fm_dys, "yyyy-MM");
				break;
			case "btns_turn_time_inq_to_dys":
            	var cal = new ComCalendar();
            	cal.setDisplayType('month');
            	cal.select(formObject.turn_time_inq_to_dys, "yyyy-MM");
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
 * IBSheet Object를 배열로 등록 <br>
 * @param  {object} sheet_obj	필수
 * @return 없음
 * @author 조재성
 * @version 2009.08.31
 */
function setSheetObject(sheet_obj){

   sheetObjects[sheetCnt++] = sheet_obj;

}

/**
 * Sheet 기본 설정 및 초기화 <br>
 * body 태그의 onLoad 이벤트핸들러 구현 <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2009.08.27
 */
function loadPage() {
    for(i=0;i<sheetObjects.length;i++){
    	// 시작 환경 설정 함수 이름 변경
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        // 마지막 환경 설정 함수 추가
        ComEndConfigSheet(sheetObjects[i]);
    }
}

/**
 * Sheet 로딩 후 기본 설정 및 초기화 <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2009.10.20
 */     
function sheet1_OnLoadFinish(sheetObj) {
    var formObject = document.form;    	
    sheetObj.WaitImageVisible = false;
 
  	// axon event 등록
    axon_event.addListenerFormat('keypress', 'obj_keypress', form);
    axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
    axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form);
    axon_event.addListener('change', 'obj_change' , 'crnt_scc_cd'); 
    axon_event.addListener('keyup', 'enterFire', 'crnt_scc_cd');
    axon_event.addListenerForm('keyup', 'obj_keyup', form);
    
    initControl();
    
    sheetObj.WaitImageVisible = true; 
}

/**
 * Form의 Conrol 를 초기화 시킨다. <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2009.08.31
 */
function initControl(){
    var formObj = document.form;
    var sheetObj1 = sheetObjects[0];

    //Form Object 초기화
    with(formObj){
    	crnt_scc_cd.value = "";
    	troughput_inq_fm_dys.value = "";
    	troughput_inq_to_dys.value = "";
    	turn_time_inq_fm_dys.value = "";
    	turn_time_inq_to_dys.value = "";

    }
	// Sheet Object 초기화
	sheetObj1.RemoveAll();

	// 초기값 설정
	
}


/**
 * 시트 초기설정값, 헤더 정의 <br>
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
 * @param  {object} sheetObj	필수	 Sheet Object
 * @param  {int} sheetNo		필수 시트오브젝트 태그의 아이디에 붙인 일련번호
 * @return 없음
 * @author 조재성
 * @version 2009.08.31	
 */
function initSheet(sheetObj,sheetNo) {
    var cnt = 0;
			var sheetID = sheetObj.id;
    switch(sheetID) {
        case "sheet1":
            with (sheetObj) {
                // 높이 설정
                style.height = 442;
                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msAll;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 10, 100);
                
                var HeadTitle1 = "|||||20'||40'||45'||R5";
                
                var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, true, true, true, false,false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,		"Status");
				InitDataProperty(0, cnt++ , dtHidden,		300,	daCenter,	true,		"Division",	false,	"",		dfNone,		0,		false,	false);
				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"gubun",	false,	"",		dfNone,		0,		false,	false);
				InitDataProperty(0, cnt++ , dtData,			300,	daLeft,		true,		"subj",		false,	"",		dfNone,		0,		false,	false);
				InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		true,		"nul1",		false,	"",		dfNone,		0,		false,	false);
				InitDataProperty(0, cnt++ , dtData,			150,	daRight,	false,		"t20",		false,	"",		dfFloat,	2,		false,	false);
				InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		true,		"nul2",		false,	"",		dfNone,		0,		false,	false);
				InitDataProperty(0, cnt++ , dtData,			150,	daRight,	false,		"t40",		false,	"",		dfFloat,	2,		false,	false);
				InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		true,		"nul3",		false,	"",		dfNone,		0,		false,	false);				                                                                                                         		        
				InitDataProperty(0, cnt++ , dtData,			150,	daRight,	false,		"t45",		false,	"",		dfFloat,	2,		false,	false);
				InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		true,		"nul4",		false,	"",		dfNone,		0,		false,	false);				
				InitDataProperty(0, cnt++ , dtData,			100,	daRight,	false,		"r5",		false,	"",		dfFloat,	2,		false,	false);
														
				
				CountPosition = 0;
				EditableColorDiff = false;
			}
			break;
        case "sheet2": // chungpa 20091130 Hidden Sheet를 이용하여 윈도우 깜박임 없앰.
            with (sheetObj) {
                // 높이 설정

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			}
            break;			
    }
}

/**
 * BackEedJob 관련 Error 처리결과를 메세지로 보여준다.
 * @param errCode
 * @return
 */
function comShowBackEndErrorMsg(errCode) {
	ComShowCodeMessage(errCode);
	clearInterval(timer);
	ComOpenWait(false);
}
/**
* BackEndJob 처리 함수 Status='3' 이 될때까지 확인한다.
* @param	{없음}	void 
* @return	{없슴} 	void 
* @authro 조재성 
* @version 20090901
*/
function getBackEndJobStatus() {
    var sheetObj = sheetObjects[1]; // chungpa 20091130 Hidden Sheet를 이용하여 윈도우 깜박임 없앰.
    var formObj = document.form;
    
    formObj.f_cmd.value = SEARCH01;
	var sXml = sheetObj.GetSearchXml("EES_CGM_1115GS.do", FormQueryString(formObj));
	var arrXml = sXml.split("|$$|");
	var jobState = ComGetEtcData(arrXml[0], "jb_sts_flg");
	
	//ComDebug("chungpa ID: "+formObj.back_end_job_key.value+"   jobState: "+ jobState);
	
	if(jobState == "3") {
	 	getBackEndJobResult();
 	    clearInterval(timer);
    } else if(jobState == "4") {
 	    // BackEndJob을 실패 하였습니다.
 	    comShowBackEndErrorMsg('CGM20031');
		clearInterval(timer);	//chungpa 20091023 화면 focusing
		ComOpenWait(false);	  	//chungpa 20091023 화면 focusing   	    
    } else if(jobState == "5") {
 	    // 이미 BackEndJob 결과 파일을 읽었습니다.
 	    comShowBackEndErrorMsg('CGM20031');
		clearInterval(timer);	//chungpa 20091023 화면 focusing
		ComOpenWait(false);	  	//chungpa 20091023 화면 focusing   	    
    }  
}	

/**
* BackEndJob 결과 처리 함수
* @param	{없음}	void 
* @return	{없슴} 	void 
* @authro 조재성 
* @version 20090901
*/     
function getBackEndJobResult() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	formObj.f_cmd.value = SEARCH02;
	
	ComOpenWait(false);	//chungpa 20091023 화면 focusing
	
	var sXml = sheetObj.GetSearchXml("EES_CGM_1115GS.do", FormQueryString(formObj),-1,false);
	var arrXml = sXml.split("|$$|");
	//alert("arrXml : "+arrXml);
	if(arrXml.length > 0) {
		sheetObj.LoadSearchXml(arrXml[0]);
	}

	
	if (sheetObj.RowCount <= 0 ) {
		// There is no related data!
		ComCodeMsgByNoRelatedData();
		return;
	} else {
		//끝.
	}    	

}


/**
 * Sheet관련 프로세스 처리 <br>
 * @param  {object} sheetObj	필수	 Sheet Object
 * @param  {object} formObj	필수 Form Object
 * @param  {String} sAction	필수 Action Type
 * @return 없음
 * @author 조재성
 * @version 2009.08.27
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg = false;
    switch(sAction) {
		case IBSEARCH:      //조회
			if(validateForm(sheetObj,formObj,sAction))
		    {
	            //기존
				//formObj.f_cmd.value = SEARCH;
				//var sXml = sheetObj.GetSearchXml("EES_CGM_1115GS.do" , FormQueryString(formObj));
				//sheetObj.LoadSearchXml(sXml);
				
				//신규 BackEndJob
				formObj.f_cmd.value = SEARCH;
	            
	 			sheetObj.WaitImageVisible = false; 	//chungpa 20091023 화면 focusing	    	
				ComOpenWait(true);					//chungpa 20091023 화면 focusing
				
				var sXml = sheetObj.GetSearchXml("EES_CGM_1115GS.do" , FormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				var backEndJobKey = ComGetEtcData(arrXml[0], "BackEndJobKey");

				ComOpenWait(true);					//chungpa 20091023 화면 focusing
				if(backEndJobKey.length > 0)
				{
					formObj.back_end_job_key.value = backEndJobKey;
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					sheetObj.RequestTimeOut = 400000;
					timer=setInterval(getBackEndJobStatus, 3000); //3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
				}
		    }					
        break;
        case IBSEARCH_ASYNC09:
    	    //formObj.f_cmd.value = SEARCH;
    	    //formObj.loc_cd.value = formObj.scc_cd.value;		//   ( location)
    	    //var sXml = sheetObj.GetSearchXml("cgm_Check_LocationGS.do", FormQueryString(formObj));
	    	formObj.f_cmd.value = SEARCH17;
	    	formObj.eq_orz_cht_chktype.value = "SCC";
	    	formObj.eq_orz_cht_scc_cd.value = formObj.crnt_scc_cd.value;
     		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
    	    // 데이터 건수
    	    var dataCount = ComGetTotalRows(sXml);
    	    if(dataCount==0){
    	        ComShowCodeMessage('CGM10009','location cd');
    	        sheetObj.removeAll();
    	        formObj.crnt_scc_cd.value = "";
    	        formObj.crnt_scc_cd.focus();
    	        return false;
    	    }
    	    else
    	    {
    	    	return true;
    	    }
    	    break;	
        case IBSEARCH_ASYNC10: // no popup for Enter Key
    	    //formObj.f_cmd.value = SEARCH;
    	    //formObj.loc_cd.value = formObj.scc_cd.value;		//   ( location)
    	    //var sXml = sheetObj.GetSearchXml("cgm_Check_LocationGS.do", FormQueryString(formObj));
	    	formObj.f_cmd.value = SEARCH17;
	    	formObj.eq_orz_cht_chktype.value = "SCC";
	    	formObj.eq_orz_cht_scc_cd.value = formObj.crnt_scc_cd.value;
     		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
    	    // 데이터 건수
    	    var dataCount = ComGetTotalRows(sXml);
    	    if(dataCount==0){
    	    	sheetObj.removeAll();
    	    	formObj.crnt_scc_cd.value = "";
    	    	formObj.crnt_scc_cd.focus();
    	    	return false;
    	    }else
    	    {
    	    	return true;
    	    }
    	    break;

    }
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
 * @param  {object} sheetObj	필수	 Sheet Object
 * @param  {object} formObj	필수 Form Object
 * @param  {String} sAction	필수 Action Type (IBSEARCH, IBSEARCH_ASYNC01, RDPRINT, IBDOWNEXCEL)
 * @return {boolean}			false => validation 체크 오류, true => validation 체크 성공
 * @author 조재성
 * @version 2009.08.31
 */
function validateForm(sheetObj,formObj,sAction){
    with(formObj){
		switch(sAction){
			case IBSEARCH:
				if(crnt_scc_cd.value == ''){
					ComShowCodeMessage('CGM10004','Location');
					crnt_scc_cd.focus();
					return false;
				}else {
					if(crnt_scc_cd.value.length != 5) // Location 자리수 고정 size=5
					{
						ComShowCodeMessage('CGM10044','SCC(5)');
						crnt_scc_cd.focus();
						return false;
					}
				}
   
				// TROUGHPUT_INQ_FM_DYS .............
				
				//코드 체크 강화.
				if(doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC10)== false)
				{
					returnfalse;
				}
				
				if(troughput_inq_fm_dys.value == ''){
    				ComShowCodeMessage('CGM10004','Period ');
    				troughput_inq_fm_dys.focus();
    				
    				return false;
    			}	
		 		if(troughput_inq_to_dys.value == ''){
    				ComShowCodeMessage('CGM10004','Period ');
    				troughput_inq_to_dys.focus();
    				
    				return false;
    			}

		 		var dt_str = ComReplaceStr(document.form.troughput_inq_fm_dys.value,"-","");
		 		var dt_end = ComReplaceStr(document.form.troughput_inq_to_dys.value,"-","");
	        	
	    		if(dt_str != '' && dt_end != ''){
	    			if(dt_end < dt_str){
	    				ComShowCodeMessage('COM12133','To date','From date','greater');
	    				troughput_inq_fm_dys.value='';
	    				troughput_inq_fm_dys.focus();
	    				return false;
	    			}
	    		}	
	    		
	    		var startDt = new Date();
	    		var endDt = new Date();
	    		endDt.setFullYear(parseInt(dt_end.substring(0,4)));
	    		endDt.setMonth(parseInt(dt_end.substring(4,6)-'00'));
	    		endDt.setDate(LastDay(parseInt(dt_end.substring(4,6)-'00'),parseInt(dt_end.substring(0,4))));
	    			    		
	    		startDt.setFullYear(parseInt(dt_str.substring(0,4)));
	    		startDt.setMonth(parseInt(dt_str.substring(4,6)-'00'));
	    		startDt.setDate(1);
	    		
	    		//ComDebug("  END getYear:"+ endDt.getYear()+ " getMonth:"+ endDt.getMonth() +  " getDate:"+ endDt.getDate());
	    		//ComDebug("  START getYear:"+ startDt.getYear()+ " getMonth:"+ startDt.getMonth() +  " getDate:"+ startDt.getDate());
		 		var resultDt1 = Math.floor(endDt.valueOf()/(24*60*60*1000)- startDt.valueOf()/(24*60*60*1000));
		 		//alert("resultDtl: " + resultDt1);
		 		if(resultDt1 > 365*2) //2년보다 검색기간이 길면 오류
		 		{	
		 			ComShowCodeMessage('CGM10011');
		 			troughput_inq_fm_dys.focus();
		 			return false
		 		}

		 		// TURN_TIME_INQ_FM_DYS .............
		 		
				if(turn_time_inq_fm_dys.value == ''){
    				ComShowCodeMessage('CGM10004','Period ');
    				turn_time_inq_fm_dys.focus();
    				
    				return false;
    			}	
		 		if(turn_time_inq_to_dys.value == ''){
    				ComShowCodeMessage('CGM10004','Period ');
    				turn_time_inq_to_dys.focus();
    				
    				return false;
    			}
		 		
		 		dt_str = ComReplaceStr(document.form.turn_time_inq_fm_dys.value,"-","");
		 		dt_end = ComReplaceStr(document.form.turn_time_inq_to_dys.value,"-","");
	        	

	    		if(dt_str != '' && dt_end != ''){
	    			if(dt_end < dt_str){
	    				ComShowCodeMessage('COM12133','To date','From date','greater');
	    				turn_time_inq_fm_dys.value='';
	    				turn_time_inq_to_dys.focus();
	    				return false;
	    			}
	    		}		
	    		
	    		startDt = new Date();
	    		endDt = new Date();
	    		endDt.setFullYear(parseInt(dt_end.substring(0,4)));
	    		endDt.setMonth(parseInt(dt_end.substring(4,6)-'00'));
	    		endDt.setDate(LastDay(parseInt(dt_end.substring(4,6)-'00'),parseInt(dt_end.substring(0,4))));
	    			    		
	    		startDt.setFullYear(parseInt(dt_str.substring(0,4)));
	    		startDt.setMonth(parseInt(dt_str.substring(4,6)-'00'));
	    		startDt.setDate(1);
	    		
	    		//ComDebug("  END getYear:"+ endDt.getYear()+ " getMonth:"+ endDt.getMonth() +  " getDate:"+ endDt.getDate());
	    		//ComDebug("  START getYear:"+ startDt.getYear()+ " getMonth:"+ startDt.getMonth() +  " getDate:"+ startDt.getDate());
		 		resultDt1 = Math.floor(endDt.valueOf()/(24*60*60*1000)- startDt.valueOf()/(24*60*60*1000));
		 		//alert("resultDtl: " + resultDt1);
		 		
		 		if(resultDt1 > 365*2) //2년보다 검색기간이 길면 오류
		 		{	
		 			ComShowCodeMessage('CGM10011');
		 			troughput_inq_fm_dys.focus();
		 			return false
		 		}
                break;
            }
    }
    return true;
}

/**
 * 콜백 함수. <br>
 * @param  {Array} aryPopupData	필수	 Array Object
 * @param  {Int} row				필수 선택한 Row
 * @param  {Int} col				필수 선택한 Column
 * @param  {Int} sheetIdx			필수 Sheet Index
 * @return 없음
 * @author 조재성
 * @version 2009.08.27
 */   
function callBackLocationSCC(aryPopupData, row, col, sheetIdx){
     	 
    var formObj = document.form;
    var location = "SCC";
    var crntLocCd = "";
    var i = 0;
    
    for(i = 0; i < aryPopupData.length; i++){
    	if(location == 'RCC'){
    		crntLocCd = crntLocCd + aryPopupData[i][11];
    	} else if(location == 'LCC'){
    		crntLocCd = crntLocCd + aryPopupData[i][10];
    	} else if(location == 'SCC'){
    		crntLocCd = crntLocCd + aryPopupData[i][8];
    	}
     		
    	if(i < aryPopupData.length - 1){
    		crntLocCd = crntLocCd + ",";
     	}
    }
     	 
    formObj.crnt_scc_cd.value = crntLocCd;
     	 
}

/** 
 * Object 의 activate 이벤트에 대한 처리  <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2009.08.31
 */
function obj_activate(){
    ComClearSeparator(event.srcElement);
    
} 

/** 
 * Object 의 deactivate 이벤트에 대한 처리  <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2009.08.27
 */
function obj_deactivate(){
	var formObj = document.form;
 	obj = event.srcElement;

	 if(obj.name=="troughput_inq_fm_dys"  ){
		 with(formObj){
	     	 var creDtFr = ComReplaceStr(troughput_inq_fm_dys.value,"-","");
	     }
	     ComChkObjValid(event.srcElement);
     }
   	if(obj.name=="troughput_inq_to_dys"  ){
			
		 with(formObj){
	     	 var creDtFr = ComReplaceStr(troughput_inq_to_dys.value,"-","");
	     }
	     ComChkObjValid(event.srcElement);
   	}
	if(obj.name=="turn_time_inq_fm_dys"  ){
		 with(formObj){
	     	 var creDtFr = ComReplaceStr(troughput_inq_fm_dys.value,"-","");
	     }
	     ComChkObjValid(event.srcElement);
    }
   	if(obj.name=="turn_time_inq_to_dys"  ){
			
		 with(formObj){
	     	 var creDtFr = ComReplaceStr(troughput_inq_to_dys.value,"-","");
	     }
	     ComChkObjValid(event.srcElement);
   	}

}	

/** 
 * Object 의 Keypress 이벤트에 대한 처리  <br>
 * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2009.08.31
 */ 
function obj_keypress(){
   	obj = event.srcElement;
   	if(obj.dataformat == null) return;
   	 	
   	window.defaultStatus = obj.dataformat;
   	 
   	switch(obj.dataformat) {
   	 	case "ym": case "ymd":
 		ComKeyOnlyNumber(obj);
 		break;
 	case "int":
 		if(obj.name=="vndr_seq") ComKeyOnlyNumber(obj,",");
 		else ComKeyOnlyNumber(obj);
        break;
 	case "float":
        ComKeyOnlyNumber(obj, "-.");
        break;    
    case "eng":
    	if(obj.name=="vndr_seq") 
    		ComKeyOnlyNumber(obj,",");
    	else 
    		ComKeyOnlyAlphabet();
        break;
    case "engup":
        if(obj.name=="crnt_scc_cd") ComKeyOnlyAlphabet('upper');//ComKeyOnlyAlphabet('uppernum');
        else if(obj.name=="crnt_yd_cd") ComKeyOnlyAlphabet('uppernum',"44");
        else ComKeyOnlyAlphabet('upper');
        break;
    case "engdn":
        if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
        else ComKeyOnlyAlphabet('lower');
   	        break;
   	}
} 

/** 
 * Object 의 change 이벤트에 대한 처리  <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2009.08.31
 */  
function obj_change(){
    var formObj = document.form;
 	var sheetObj = sheetObjects[0]; 
 	obj = event.srcElement;
 	switch(obj.name){
	 	case "crnt_scc_cd":
	 		var crntLocCd = ComTrimAll(formObj.crnt_scc_cd.value);
	   		if( formObj.crnt_scc_cd.value.search(',') > 0 || (formObj.crnt_scc_cd.value == '')) // 다중 scc_cd code(,로 연결됨)이면 검사하지 않는다. 
	   		{
	   			break;
	   		}    	 		
	   		var arrCrntLocCd = crntLocCd.split(",");
	   		for(var i = 0; i < arrCrntLocCd.length; i++){
	   		// 입력오류 체크 (예> ,,)
	 			if(arrCrntLocCd[i] == ''){
	 				ComShowCodeMessage('CGM10009','Location');
	 				formObj.crnt_scc_cd.value = "";
	 				ComSetFocus(formObj.crnt_scc_cd);
	 				break;
	 			}else{
	    	 		    if(formObj.crnt_scc_cd.value != ''){
	    	 		    	doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC09);
	    	 		    }
	 			}
	   		}
	 		break;
    }   
}

/**
 * Sheet1 의 Double Click 할 경우 상세정보 화면표시 <br>
 * @author 조재성 / update select sheet 1
 * @version 2009.08.13
 */   
var sheet1_click_val = "";
function sheet1_OnClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
    var sheetObj2 = sheetObjects[1];
  	var formObject = document.form;
  	
  	sheet1_click_val = sheetObj.CellValue(Row,Col);
  	//sheetObj.SelectCell(Row, Col);
	//alert("sheet1_OnClick>>>>" + Row + " : "+ Col);
  	//alert(sheet1_click_val);
	
 }
 
/**
 * Sheet1 의 cell을 edit 할 경우 <br>
 * @author 조재성
 * @version 2009.08.12
 */   
function sheet1_OnChange(sheetObj, Row, Col)
{
    var formObject = document.form;
	  	
    with(sheetObj)
    {

    }

}  
 /**
  * float값을 유효숫자(2자리)만큼 잘라내는 함수
  * @param	{text}	sVal	필수		숫자 텍스트 데이터
  * @return	{float} rVal			변환된 float데이터 
  * @authro 조재성 
  * @version 20090827
  */
function returnFloat(sVal)
{
	var comp;
 	/* 바로 float값이 들어오기 때문에 텍스트 처리하지 않는다. 
 	if(strAllTrim(sVal)=="")
 		comp=0;
 	else
 		comp=parseFloat(sVal);
		comp = parseInt(comp*100)/100;    		
 	*/
 	comp = parseInt(sVal*100)/100;
    return comp;
}

/**
 * sheet1 Search End 시 계산 함수
 * @param	{sheetObj}	sheetObj	필수		sheetObject
 * @param	{text}		ErrMsg		필수		sheetObject
 * @return	{없슴} 		void 
 * @authro 조재성 
 * @version 20090901
 */  
function sheet1_OnSearchEnd(sheetObj, ErrMsg)
{
	with(sheetObj)
	{
		// Import Turn Time Total(Day)
		// Turn Time IC-ID (Day) + Turn Time ID-MT (Day) + Import Turn Time Adjustment (Day)
		CellValue(6,"t20") = parseFloat(CellValue(3,"t20")) + parseFloat(CellValue(4,"t20")) + parseFloat(CellValue(5,"t20"));
		CellValue(6,"t40") = parseFloat(CellValue(3,"t40")) + parseFloat(CellValue(4,"t40")) + parseFloat(CellValue(5,"t40"));
		CellValue(6,"t45") = parseFloat(CellValue(3,"t45")) + parseFloat(CellValue(4,"t45")) + parseFloat(CellValue(5,"t45"));
		CellValue(6,"r5") = parseFloat(CellValue(3,"r5")) + parseFloat(CellValue(4,"r5")) + parseFloat(CellValue(5,"r5"));
		// Chassis Requirement - Import Subtotal (Unit)
		// Import Weekly Throughput (Box) / 7 * Import Turn Time Total (Day)
		CellValue(7,"t20") = parseFloat(CellValue(2,"t20")) / 7 * parseFloat(CellValue(6,"t20"));
		CellValue(7,"t40") = parseFloat(CellValue(2,"t40")) / 7 * parseFloat(CellValue(6,"t40"));
		CellValue(7,"t45") = parseFloat(CellValue(2,"t45")) / 7 * parseFloat(CellValue(6,"t45"));
		CellValue(7,"r5") = parseFloat(CellValue(2,"r5")) / 7 * parseFloat(CellValue(6,"r5"));
		// Export Turn Time Total (Day)
		// Turn Time MT-OP (Day) + Turn Time OP-OC (Day) + Turn Time OC-EN (Day) + Export Turn Time Adjustment (Day)
		CellValue(14,"t20") = parseFloat(CellValue(10,"t20")) + parseFloat(CellValue(11,"t20")) + parseFloat(CellValue(12,"t20")) + parseFloat(CellValue(13,"t20"));
		CellValue(14,"t40") = parseFloat(CellValue(10,"t40")) + parseFloat(CellValue(11,"t40")) + parseFloat(CellValue(12,"t40")) + parseFloat(CellValue(13,"t40"));
		CellValue(14,"t45") = parseFloat(CellValue(10,"t45")) + parseFloat(CellValue(11,"t45")) + parseFloat(CellValue(12,"t20")) + parseFloat(CellValue(13,"t45"));
		CellValue(14,"r5") = parseFloat(CellValue(10,"r5")) + parseFloat(CellValue(11,"r5")) + parseFloat(CellValue(12,"r5")) + parseFloat(CellValue(13,"r5"));
		// Chassis Requirement - Export Subtotal (Unit)
		// Export Weekly Throughput (Box) / 7 * Export Turn Time Adjustment (Day)
		CellValue(15,"t20") = parseFloat(CellValue(9, "t20")) / 7 * parseFloat(CellValue(14, "t20"));
		CellValue(15,"t40") = parseFloat(CellValue(9, "t40")) / 7 * parseFloat(CellValue(14, "t40"));
		CellValue(15,"t45") = parseFloat(CellValue(9, "t45")) / 7 * parseFloat(CellValue(14, "t45"));
		CellValue(15,"r5") = parseFloat(CellValue(9, "r5")) / 7 * parseFloat(CellValue(14, "r5"));
		// Empty Turn Time Total (Day)
		// Turn Time MT-EN (Day) + Empty Turn Time Adjustment (Day)
		CellValue(20,"t20") = parseFloat(CellValue(18,"t20")) + parseFloat(CellValue(19,"t20"));
		CellValue(20,"t40") = parseFloat(CellValue(18,"t40")) + parseFloat(CellValue(19,"t40"));
		CellValue(20,"t45") = parseFloat(CellValue(18,"t45")) + parseFloat(CellValue(19,"t45"));
		CellValue(20,"r5") = parseFloat(CellValue(18,"r5")) + parseFloat(CellValue(19,"r5"));
		// Chassis Requirement - Empty Subtotal (Unit)
		// Empty Weekly Throughput (Box)/7 * Empty Turn Time Total (Day)
		CellValue(21,"t20") = parseFloat(CellValue(17,"t20"))/7 * parseFloat(CellValue(20,"t20"));
		CellValue(21,"t40") = parseFloat(CellValue(17,"t40"))/7 * parseFloat(CellValue(20,"t40"));
		CellValue(21,"t45") = parseFloat(CellValue(17,"t45"))/7 * parseFloat(CellValue(20,"t45"));
		CellValue(21,"r5") = parseFloat(CellValue(17,"r5"))/7 * parseFloat(CellValue(20,"r5"));
		
		// chungpa 20091104 added Domestic subtotal
		// chassis requirement - Domestic subtotal (Unit)
		// Domestic Weekly Throughput (Box)/7 * Dometic Turn Time Adjustment (Day) (Day)
		CellValue(25,"t20") = parseFloat(CellValue(23,"t20"))/7 * parseFloat(CellValue(24,"t20"));
		CellValue(25,"t40") = parseFloat(CellValue(23,"t40"))/7 * parseFloat(CellValue(24,"t40"));
		CellValue(25,"t45") = parseFloat(CellValue(23,"t45"))/7 * parseFloat(CellValue(24,"t45"));
		CellValue(25,"r5") = parseFloat(CellValue(23,"r5"))/7 * parseFloat(CellValue(24,"r5"));
		
		// Chassis Requirement - Grand Total (Unit)
		// [Chassis Requirement - Import Subtotal (Unit)] + [Chassis Requirement - Export Subtotal (Unit)]
		// + [Chassis Requirement - Empty Subtotal (Unit)] + [Chassis Turn Time Adjustment (Day)]
		
		CellValue(26,"t20") = parseFloat(CellValue(7,"t20")) + parseFloat(CellValue(15,"t20")) + parseFloat(CellValue(21,"t20")) + parseFloat(CellValue(25,"t20"));
		CellValue(26,"t40") = parseFloat(CellValue(7,"t40")) + parseFloat(CellValue(15,"t40")) + parseFloat(CellValue(21,"t40")) + parseFloat(CellValue(25,"t40"));
		CellValue(26,"t45") = parseFloat(CellValue(7,"t45")) + parseFloat(CellValue(15,"t45")) + parseFloat(CellValue(21,"t45")) + parseFloat(CellValue(25,"t45"));
		CellValue(26,"r5") = parseFloat(CellValue(7,"r5")) + parseFloat(CellValue(15,"r5")) + parseFloat(CellValue(21,"r5")) + parseFloat(CellValue(25,"r5"));
		// Final Adjusted Chassis ESP (Unit)
		// Chassis Requirement - Grand Total (Unit) * 
		//	{ 1	+ (Maintenance and Repair Factor (%)+Sales Volume Increase Factor (%)+Utilization Factor (%)+Other Factor (%)) /100}
		CellValue(31,"t20") = parseFloat(CellValue(26,"t20")) * ( 1+ (parseFloat(CellValue(27,"t20"))+parseFloat(CellValue(28,"t20"))+parseFloat(CellValue(29,"t20"))+parseFloat(CellValue(30,"t20"))) / 100 );
		CellValue(31,"t40") = parseFloat(CellValue(26,"t40")) * ( 1+ (parseFloat(CellValue(27,"t40"))+parseFloat(CellValue(28,"t40"))+parseFloat(CellValue(29,"t40"))+parseFloat(CellValue(30,"t40"))) / 100 );
		CellValue(31,"t45") = parseFloat(CellValue(26,"t45")) * ( 1+ (parseFloat(CellValue(27,"t45"))+parseFloat(CellValue(28,"t45"))+parseFloat(CellValue(29,"t45"))+parseFloat(CellValue(30,"t45"))) / 100 );
		CellValue(31,"r5") = parseFloat(CellValue(26,"r5")) * ( 1+ (parseFloat(CellValue(27,"r5"))+parseFloat(CellValue(28,"r5"))+parseFloat(CellValue(29,"r5"))+parseFloat(CellValue(30,"r5"))) / 100 );
		
		/*
		ShowSubSum("Division", "3|4|5|6", -1, false, false, 0, "");
		
		// SubSum 텍스트 설정
		var aSubSum = FindSubSumRow("Division").split("|");
		
		alert(aSubSum);
		
		// SubSum 문구
		var aString = new Array();
		aString[0] = "Chassis Requirement - Import Subtotal (Unit)";
		aString[1] = "Chassis Requirement - Export Subtotal (Unit)";
		aString[2] = "Chassis Requirement - Empty Subtotal (Unit)";
		aString[3] = "Chassis Requirement - Domestic Subtotal (Unit)";
		aString[4] = "Final Adjusted Chassis ESP (Unit)";				
		
		for (var j = 0; j < aSubSum.length; j ++)
		{
			CellText(aSubSum[j], "subj") = aString[j];
		}
		*/
		//계산후 값을 적용한다. 
		var color1 = RgbColor(190, 255, 170);
		var color2 = RgbColor(190, 190, 255);
		for(var i = 1; i <= LastRow; i ++)
		{
			/*
			if (0 == CellValue(i, "t20")  &&  0 == CellValue(i, "t40")  &&  0 == CellValue(i, "t45")  &&  0 == CellValue(i, "r5")){
				CellBackColor(i, "t20") = color1;
				CellBackColor(i, "t40") = color1;
				CellBackColor(i, "t45") = color1;
				CellBackColor(i, "r5") = color1;
			}*/
			
			if( i== 5 || i==13 || i==19 || i==24 || i==27 || i==28 || i==29 || i==30)
			{
				CellBackColor(i, "t20") = color1;
				CellBackColor(i, "t40") = color1;
				CellBackColor(i, "t45") = color1;
				CellBackColor(i, "r5") = color1;
			}
			
			if( i== 7 || i==15 || i==21 || i==25 || i==31)
			{
				CellBackColor(i, "t20") = color2;
				CellBackColor(i, "t40") = color2;
				CellBackColor(i, "t45") = color2;
				CellBackColor(i, "r5") = color2;
			}
			
			
			if(CellText(i, "subj") == "Chassis Requirement - Grand Total (Unit)")
			{
				RowMerge(i) = true;	
				DataRowMerge(0)= true;
			}else if(CellText(i, "subj") == "Maintenance and Repair Factor (%)")
			{
				RowMerge(i) = true;	
				DataRowMerge(0)= true;
			}else if(CellText(i, "subj") == "Sales Volume Increase Factor (%)")
			{
				RowMerge(i) = true;
				DataRowMerge(0)= true;
			}else if(CellText(i, "subj") == "Utilization Factor (%)")
			{
				RowMerge(i) = true;
				DataRowMerge(0)= true;
			}else if(CellText(i, "subj") == "Other Factors (%)")
			{
				RowMerge(i) = true;
				DataRowMerge(0)= true;
			}else if(CellText(i, "subj") == "Final Adjusted Chassis ESP (Unit)")
			{
				RowMerge(i) = true;
				DataRowMerge(0)= true;
			}
			
			
			
			
			if(	CellText(i, "subj") == "Final Adjusted Chassis ESP (Unit)")
			{
				CellFont("FontBold", i,"gubun") = true;
				CellFont("FontBold", i,"subj") = true;
			}
		}		
	}
	

}
/** 
 * 해당 달의 last day얻기  <br>
 * @param  month,year
 * @return date
 * @author 조재성
 * @version 2009.08.25
 */     
function LastDay(month,year) {
	var ds = String(month+1)+'/0/'+String(year);
	var dd = new Date(ds);
	return dd.getDate();
} 

  /** 
   * 기본조건 입력 후 ENTER키 적용 <br>
   * @param  없음
   * @return 없음
   * @author 조재성
   * @version 2009.08.14
   */ 
   function enterFire() {
	   var formObj = document.form;
	   var sheetObj = sheetObjects[0];
	   if(event.keyCode == 13)
	   {
		   if(validateForm(sheetObj,formObj,IBSEARCH))
		   {
			   ComKeyEnter('search');
		   }
	   }
	 	 
   }    

/**
 * 유효값체크 로직(자리수에 맞춰서)
 * @author 조재성 2009.09.30
 */
function obj_keyup(){
    	 var formObj = document.form;
    	 var sheetObj = sheetObjects[0];
    	 obj = event.srcElement;
    	 switch(obj.name){
	 	 	 case "crnt_scc_cd":
		 		var crntLocCd = ComTrimAll(formObj.crnt_scc_cd.value);
		   		if( formObj.crnt_scc_cd.value.search(',') > 0 || (formObj.crnt_scc_cd.value == '')) // 다중 scc_cd code(,로 연결됨)이면 검사하지 않는다. 
		   		{
		   			break;
		   		}    	 		
		   		var arrCrntLocCd = crntLocCd.split(",");
		   		for(var i = 0; i < arrCrntLocCd.length; i++){
		   		// 입력오류 체크 (예> ,,)
		 			if(arrCrntLocCd[i] == ''){
		 				ComShowCodeMessage('CGM10009','Location');
		 				formObj.crnt_scc_cd.value = "";
		 				ComSetFocus(formObj.crnt_scc_cd);
		 				break;
		 			}else{
		    	 		    //if(formObj.crnt_scc_cd.value != ''){
		    	 		    if(formObj.crnt_scc_cd.value.length == 5){
		    	 		    	doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC10);
		    	 		    }
		 			}
		   		}
		 		break;
    	 }
}   
	/* 개발자 작업  끝 */