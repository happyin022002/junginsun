/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_MNR_0229.js
 *@FileTitle : M&R Estimate expense
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.16
 *@LastModifier : 민정호
 *@LastVersion : 1.0
 * 2009.10.16 민정호
 * 1.0 Creation 
 * --------------------------------------------------------
 * History
 * 2011.03.11 김종옥 [CHM-201109258-01] 조회항목 Execute Month, Cost Month 에 현재 전월 표시.
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
 * @class EES_MNR_0229 : EES_MNR_0229 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function EES_MNR_0229() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업	*/

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var HOOfc = "";
var initLoader = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
     /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
    /*******************************************************/
    var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
				case "btn_Retrieve":
					formObject.exe_gubun.value="1";
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
				case "btn_New":
					formObject.exe_gubun.value="1";
					doActionIBSheet(sheetObject1,formObject,IBCLEAR);
					break;	
				case "btn_Confirm": 
					formObject.exe_gubun.value="1";
					doActionIBSheet(sheetObject1,formObject,IBSAVE); 
					break;   	    
				case "cre_dt_cal_from":
					var cal = new ComCalendar();
					cal.setDisplayType('month');
					cal.select(formObject.month, "yyyy-MM");
					break;	    	
				case "exe_dt_cal_from":
					var cal = new ComCalendar();
					cal.setDisplayType('month');
					cal.select(formObject.exe_month, "yyyy-MM");
					break;
				case "btn_DownExcel":
					sheetObject1.SpeedDown2Excel(-1);
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
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	 MnrWaitControl(true);
     for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i + 1); 
        ComEndConfigSheet(sheetObjects[i]);
     }	              
	 doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
	 MnrWaitControl(false);
} 

 /**
  * 시트 초기설정값, 헤더 정의
  * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
  * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
  */
 function initSheet(sheetObj,sheetNo) {
     var cnt = 0;
		var sheetID = sheetObj.id;
     		switch(sheetID) {
	         case "sheet1":
	             with (sheetObj) {
	                 // 높이 설정
	                 style.height = 420;
	                 // 전체 너비 설정
	                 SheetWidth = mainTable.clientWidth;
	
	                 //Host정보 설정[필수][HostIp, Port, PagePath]
	                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                 //전체Merge 종류 [선택, Default msNone]
	                 MergeSheet = msHeaderOnly;
	
	                //전체Edit 허용 여부 [선택, Default false]
	                 Editable = false;
	 
	                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                 InitRowInfo(1, 1, 10, 100);
	
	                 var HeadTitle1 = "|Seq.|Actual Month|SYS Name|Rev Month|ACCT Code|Biz Unit|loc_cd|vsl_cd|skd_voy_no|skd_dir_cd|REV VVD|wo_no|cntr_tpsz_cd|cntr_qty|Estimated Cost|Actual Cost|Accural Cost|estm_vvd_tp_cd|estm_ioc_div_cd|estm_bc_div_cd";                        
	
					 var headCount = ComCountHeadTitle(HeadTitle1);
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);				
	
	                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                 InitHeadMode(false, false, false, true, false,false);
	
	                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                 InitHeadRow(0, HeadTitle1, true);
	
					 //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE,		SAVENAME,			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	false,		"ibflag");
					InitDataProperty(0, cnt++ , dtSeq,	60,	daCenter,	true,		"Seq");
					InitDataProperty(0, cnt++ , dtData,	90,	daCenter,	false,		"exe_yrmon",		false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,	90,	daCenter,	false,		"sys_src_id",		false,		"",			dfNone,			0,		true,		true);    					
					InitDataProperty(0, cnt++ , dtData,	90,	daCenter,	false,		"rev_yrmon",		false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,	90,	daCenter,	false,		"acct_cd",		 	false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,	90,	daCenter,	false,		"biz_ut_id",		false,		"",			dfNone,			0,		true,		true);
					
					//ColHidden start
					InitDataProperty(0, cnt++ , dtData,110,	daCenter,	false,		"loc_cd",			false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,110,	daCenter,	false,		"vsl_cd",		 	false,		"",			dfNone,			0,		true,		true);    					
					InitDataProperty(0, cnt++ , dtData,110,	daCenter,	false,		"skd_voy_no",		false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,110,	daCenter,	false,		"skd_dir_cd",		false,		"",			dfNone,			0,		true,		true);  
					//ColHidden end
					
					InitDataProperty(0, cnt++ , dtData,	 90,	daCenter,	false,		"rev_dir_cd",		false,		"",			dfNone,			0,		true,		true);
	
					//ColHidden start
					InitDataProperty(0, cnt++ , dtData,110,	daCenter,	false,		"wo_no",		false,		"",			dfNone,			0,		true,		true);    					
					InitDataProperty(0, cnt++ , dtData,110,	daCenter,	false,		"cntr_tpsz_cd",		false,		"",			dfNone,			0,		true,		true);    					
					InitDataProperty(0, cnt++ , dtData,110,	daCenter,	false,		"cntr_qty",		 	false,		"",			dfNone,			0,		true,		true);
					//ColHidden end
					
					InitDataProperty(0, cnt++ , dtData,	 110,	daRight,	false,		"estm_amt",		 	false,		"",			dfFloat,			2,		true,		true);    					
					InitDataProperty(0, cnt++ , dtData,	 110,	daRight,	false,		"actu_amt",		 	false,		"",			dfFloat,			2,		true,		true);
					InitDataProperty(0, cnt++ , dtData,	 110,	daRight,	false,		"accl_amt",		 	false,		"",			dfFloat,			2,		true,		true);
					
					//ColHidden start
					InitDataProperty(0, cnt++ , dtData,110,	daCenter,	false,		"estm_vvd_tp_cd",	false,		"",			dfNone,			0,		true,		true);    					
					InitDataProperty(0, cnt++ , dtData,110,	daCenter,	false,		"estm_ioc_div_cd",	false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,110,	daCenter,	false,		"estm_bc_div_cd",	false,		"",			dfNone,			0,		true,		true);  
					//ColHidden end
					
					ColHidden("loc_cd")=true;
					ColHidden("vsl_cd")=true;
					ColHidden("skd_voy_no")=true;
					ColHidden("skd_dir_cd")=true;
					
					ColHidden("wo_no")=true;
					ColHidden("cntr_tpsz_cd")=true;
					ColHidden("cntr_qty")=true;
					
					ColHidden("estm_vvd_tp_cd")=true;
					ColHidden("estm_ioc_div_cd")=true;
					ColHidden("estm_bc_div_cd")=true;
					
					 // 소계를 모두 상단으로 모인다.
//					ShowSubSum(1, "2|3|4|5|6|7", 1, true, true);
					
					
	             }
			break;  	
	         case "sheet2":
	             with (sheetObj) {
	                 // 높이 설정
	                 style.height = 0;
	                 // 전체 너비 설정
	                 SheetWidth = mainTable.clientWidth;
	
	                 //Host정보 설정[필수][HostIp, Port, PagePath]
	                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                 //전체Merge 종류 [선택, Default msNone]
	                 MergeSheet = msHeaderOnly;
	
	                //전체Edit 허용 여부 [선택, Default false]
	                 Editable = false;
	 
	                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                 InitRowInfo(1, 1, 10, 100);
	
	                 var HeadTitle1 = "|Seq.|Actual Month|SYS Name|Rev Month|ACCT Code|Biz Unit|Location|Vessel|Schedule Voyage Number|Vessel Direction Code|REV VVD|W/O No|TS|QTY|Estimated Cost|Actual Cost|Accural Cost|estm_vvd_tp_cd|estm_ioc_div_cd|estm_bc_div_cd";                        
	
					 var headCount = ComCountHeadTitle(HeadTitle1);
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);				
	
	                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                 InitHeadMode(false, false, false, true, false,false);
	
	                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                 InitHeadRow(0, HeadTitle1, true);
	
					 //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE,		SAVENAME,			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	false,		"ibflag");
					InitDataProperty(0, cnt++ , dtSeq,	100,	daCenter,	true,		"Seq");
					InitDataProperty(0, cnt++ , dtData,	90,	daCenter,	false,		"exe_yrmon",		false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,	90,	daCenter,	false,		"sys_src_id",		false,		"",			dfNone,			0,		true,		true);    					
					InitDataProperty(0, cnt++ , dtData,	90,	daCenter,	false,		"rev_yrmon",		false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,	90,	daCenter,	false,		"acct_cd",		 	false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,	90,	daCenter,	false,		"biz_ut_id",		false,		"",			dfNone,			0,		true,		true);
					
					InitDataProperty(0, cnt++ , dtData,110,	daCenter,	false,		"loc_cd",			false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,110,	daCenter,	false,		"vsl_cd",		 	false,		"",			dfNone,			0,		true,		true);    					
					InitDataProperty(0, cnt++ , dtData,110,	daCenter,	false,		"skd_voy_no",		false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,110,	daCenter,	false,		"skd_dir_cd",		false,		"",			dfNone,			0,		true,		true);  
		
					InitDataProperty(0, cnt++ , dtData,	 90,	daCenter,	false,		"rev_dir_cd",		false,		"",			dfNone,			0,		true,		true);
	
					InitDataProperty(0, cnt++ , dtData,110,	daCenter,	false,		"wo_no",		false,		"",			dfNone,			0,		true,		true);    					
					InitDataProperty(0, cnt++ , dtData,110,	daCenter,	false,		"cntr_tpsz_cd",		false,		"",			dfNone,			0,		true,		true);    					
					InitDataProperty(0, cnt++ , dtData,110,	daCenter,	false,		"cntr_qty",		 	false,		"",			dfNone,			0,		true,		true);
					
					InitDataProperty(0, cnt++ , dtData,	 110,	daRight,	false,		"estm_amt",		 	false,		"",			dfNullInteger,			0,		true,		true);    					
					InitDataProperty(0, cnt++ , dtData,	 110,	daRight,	false,		"actu_amt",		 	false,		"",			dfNullInteger,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,	 110,	daRight,	false,		"accl_amt",		 	false,		"",			dfNullInteger,			0,		true,		true);
					
					InitDataProperty(0, cnt++ , dtData,110,	daCenter,	false,		"estm_vvd_tp_cd",	false,		"",			dfNone,			0,		true,		true);    					
					InitDataProperty(0, cnt++ , dtData,110,	daCenter,	false,		"estm_ioc_div_cd",	false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,110,	daCenter,	false,		"estm_bc_div_cd",	false,		"",			dfNone,			0,		true,		true);  

	             }
			break;  	
     }
 }
 
function initControl() {  
    //Axon 이벤트 처리1. 이벤트catch  
    axon_event.addListenerForm  ('blur', 'obj_deactivate',  form); 			  //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
    axon_event.addListenerFormat('focus',   'obj_activate',    form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
    axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
}    

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * HTML Control의 deactivate 이벤트 <br>
 **/
function obj_deactivate(){    
	obj = event.srcElement;       
    ComChkObjValid(event.srcElement); 
} 

/**
 * HTML Control의 activate 이벤트 <br>
 **/
function obj_activate(){   
    ComClearSeparator(event.srcElement);
} 
 
/**
 * HTML Control의 keypress 이벤트 <br>
 **/     
function obj_keypress(){     
    obj = event.srcElement;    
    if(obj.dataformat == null) return; 
    window.defaultStatus = obj.dataformat;
		              
    switch(obj.dataformat) {  
        case "ymd":   
        case "int":    
			ComKeyOnlyNumber(obj); 
            break;     
        case "float":   
            ComKeyOnlyNumber(obj, ".");
            break; 
        case "eng":   
            ComKeyOnlyAlphabet();
			break;   
        case "engup": 
        	ComKeyOnlyAlphabet('uppernum');   
        break;	  
    }
} 	      
 
 /**
  * sheet1에서 SearchEnd이벤트를 처리한다.
  * @param sheetObj
  * @return
  */
  function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
	  MnrWaitControl(false);
  }
	
  /**
   * sheet1에서 SearchEnd이벤트를 처리한다.
   * @param sheetObj
   * @return
   */
   function sheet2_OnSearchEnd(sheetObj,ErrMsg) {
	    //sheetObj.SpeedDown2Excel(-1);  
	    sheetObjects[0].style.height = 500;
	    sheetObjects[1].style.height = 0;
		MnrWaitControl(false);
   }
 
 function sheet1_OnSaveEnd(sheetObj,ErrMsg){  
 	if (ErrMsg == "") {  
		ComShowCodeMessage("MNR00340");   
		MnrWaitControl(false);	
	} 	
 	MnrWaitControl(false);
 }	
	
 // Sheet관련 프로세스 처리
 function doActionIBSheet(sheetObj,formObj,sAction) {
 	// 현재 날짜 가져오기
 	var today   = new Date();
 	var year = today.getFullYear();
 	var month = today.getMonth();
 	
     sheetObj.ShowDebugMsg = false;
     switch(sAction) {
			case IBSEARCH:      //조회
				ComOpenWait(false);
				if(validateForm(sheetObj,formObj,sAction))					
					if (sheetObj.id == "sheet1"){	
						MnrWaitControl(true);
						formObj.f_cmd.value = SEARCH;     						
						sheetObj.DoSearch("EES_MNR_0229GS.do",FormQueryString(formObj));
					}
				break; 
				
			case IBCLEAR:        //초기화
				MnrWaitControl(true);
				ComOpenWait(false);
			    sheetObj.WaitImageVisible = false;

				//쉬트 초기화   
				for(i=0;i<sheetObjects.length;i++){   
					sheetObjects[i].RemoveAll();    
		        }  
											    	
				formObj.month.value = dateFormat(year,4) + "-" + dateFormat(month,2);
				formObj.exe_month.value = dateFormat(year,4) + "-" + dateFormat(month,2);
				
				sheetObj.WaitImageVisible = true;
				MnrWaitControl(false);    			
				break;
			
			case IBSAVE:  
				ComOpenWait(false);
				if(validateForm(sheetObj,formObj,sAction)) { 
					 MnrWaitControl(true);
					 formObj.f_cmd.value = MODIFY;     
					 var sXml = sheetObj.GetSaveXml("EES_MNR_0229GS.do",FormQueryString(formObj)); 
					 sheetObj.LoadSaveXml(sXml);        
				}	 
				break;
     }
 }
 
 /**
  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  */
 function validateForm(sheetObj,formObj,sAction){
     with(formObj){
	 	switch(sAction) {  	
			//RE-Bidding 
			case IBSEARCH:  
				if(formObj.month.value == "") {
					ComAlertFocus(formObj.month, ComGetMsg('MNR00003'));
					return false;
				}  
			break;
			
			case IBSAVE:  
				if(formObj.exe_month.value == "") {
					ComAlertFocus(formObj.month, ComGetMsg('MNR00003'));
					return false;
				}  
			break;	 	
     	}
	 }	
     return true;
 }

 function dateFormat(n, digits) {
 	var zero = '';
 	n = n.toString();

 	if (n.length < digits) {
 		for (i = 0; i < digits - n.length; i++)
 	    zero += '0';
 	}
 	return zero + n;
 }	  

/* 개발자 작업 끝 */