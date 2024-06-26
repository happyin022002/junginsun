/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1403.js
*@FileTitle : Un-match B/L Status Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.06.22 이승준
* 1.0 Creation
* -------------------------------------------------------- 
* History
* 2010.09.28 최도순 [CHM-201006155] Error B/L Status Report 결함 문의
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
     * @class esm_bkg_1403 : esm_bkg_1403 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_1403() {
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

    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var comboObjects = new Array();
    var comboCnt = 0;


    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /**
	  * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	  * <br><b>Example :</b>
	  * <pre>
	  *     processButtonClick();
	  * </pre>
	  * @return 없음
	  * @author 이승준
	  * @version 2009.04.17
	  */
        function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
             var sheetObject = sheetObjects[0];
             var sheetObject1 = sheetObjects[1];

             /*******************************************************/
             var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

                switch(srcName) {
	    	        case "btns_calendar1": //달력버튼
			        	var cal = new ComCalendar();
			        	cal.select(form.fm_dt, 'yyyy-MM-dd');
			        	break;
	    
	    	        case "btns_calendar2":
				        var cal = new ComCalendar();
				        cal.select(form.to_dt, 'yyyy-MM-dd');
				        break;
                
	                case "btn_Retrieve":
						doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
						break;
					
					case "btn_New":
						removeAll(formObject);
						
					    //getComboObject(comboObjects, 'bkg_rhq_cd').Code = form.strRhq_ofc_cd.value;
						
						break;
					
					case "btn_DownExcel":
						sheetObjects[1].Down2Excel();
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
         * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
         * 배열은 소스 상단에 정의 <br>
         * <br><b>Example :</b>
         * <pre>
         *     setSheetObject(sheetObj);
         * </pre>
         * @param {ibsheet} sheet_obj 필수 IBSheet Object
         * @return 없음
         * @author 이승준
         * @version 2009.04.17
         */ 
        function setSheetObject(sheet_obj){

           sheetObjects[sheetCnt++] = sheet_obj;
    			
        }
        /**
         * IBMulti Combo Object를 배열로 등록 <br>
         * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
         * 배열은 소스 상단에 정의 <br>
         * <br><b>Example :</b>
         * <pre>
         *     setComboObject(combo_obj);
         * </pre>
         * @param {ibCombo} combo_obj 필수 IBMulti Combo Object
         * @return 없음
         * @author 이승준
         * @version 2009.04.17
         */ 
        function setComboObject(combo_obj){
     		comboObjects[comboCnt++] = combo_obj;
     	}


        /**
         * Sheet 기본 설정 및 초기화 <br>
         * body 태그의 onLoad 이벤트핸들러 구현 <br>
         * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
         * <br><b>Example :</b>
         * <pre>
         *     loadPage();
         * </pre>
         * @return 없음
         * @author 이승준
         * @version 2009.04.17
         */
        function loadPage() {
        	 var form = document.form;

     		//IBMultiCombo초기화
      	    for(var k = 0; k < comboObjects.length; k++){
      	        initCombo(comboObjects[k], k + 1);
      	    }
        	 
        	 for(i=0;i<sheetObjects.length;i++){
    			//khlee-시작 환경 설정 함수 이름 변경
    			ComConfigSheet (sheetObjects[i] );
    			initSheet(sheetObjects[i],i+1);
    			//khlee-마지막 환경 설정 함수 추가
    			ComEndConfigSheet(sheetObjects[i]);
    		}
    		
     		axon_event.addListenerForm('keypress', 'obj_keypress', document.form);			
     	    axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
    	    axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
   	        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');   		        	    

   	        initIBComboItem();
    	    //doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);

    	    //sheetObjects[1].Editable = false;
    	    
    	    //김대호테스트
    	    /*
    	    form.rct_rhq_cd.Code = "";
    	    form.rt_aply_dt_from.value = "2009-01-01";
    	    form.rt_aply_dt_to.value = "2009-12-31";
    	    doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
    	    */
    	    
    	}
        
        
/** 
* Object 의 Keypress 이벤트핸들러 <br>
* 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  없음  
* @return 없음
* @see #
* @author 김대호
* @version 2009.10.21
*/ 
function obj_keypress(){
	var obj = event.srcElement;
 	if(obj.dataformat == null) return;
 	window.defaultStatus = obj.dataformat;
	switch(obj.dataformat){
 	case "ymd": //날짜 입력하기
		ComKeyOnlyNumber(obj,"-"); 
		break;
 	case "int": //숫자만 입력
 	case "number": //숫자만 입력 	
 		ComKeyOnlyNumber(obj);
 		break;
 	case "engup":
 		ComKeyOnlyAlphabet('upper');
 		break;
 	case "uppernum":
 		ComKeyOnlyAlphabet('uppernum');
 		break;
 	default:
 		//ComKeyOnlyNumber(obj);
 		break;
	}
}        

/**
 * OnKeyPress event를 처리한다. <br>
 * <br><b>Example :</b>
 * <pre>
 *     obj_keypress()
 * </pre>
 * @param 없음
 * @return 없음
 * @author 이승준
 * @version 2009.04.17
 */ 
function obj_activate() {
	ComClearSeparator (event.srcElement);	   
}

/**
 * Onbeforedeactivate  event를 처리한다. <br>
 * <br><b>Example :</b>
 * <pre>
 *     obj_deactivate()
 * </pre>
 * @param 없음
 * @return 없음
 * @author 이승준
 * @version 2009.04.17
 */ 
function obj_deactivate() {
    ComChkObjValid(event.srcElement);
}

/**
 * IBSHEET COMBO를 LOAD하는 함수<br>
 * <br><b>Example :</b>
 * <pre>
 * 		initCombo(comboObj, comboNo)
 * </pre>
 * @return 없음
 * @author 이승준
 * @version 2009.06.10
 */ 
function initCombo(comboObj, comboNo) {
    switch(comboObj.id) {
    
    case "bkg_rhq_cd":
        var i=0;
        with(comboObj) {
        	DropHeight = 200;
			UseAutoComplete = true;
			ValidChar(2, 0);    // 영문대문자만 입력
            MaxLength = 6;      // 6자리만 입력
        }
        break;    
    
    case "bkg_ofc_cd":
        var i=0;
        with(comboObj) {
        	DropHeight = 200;
			UseAutoComplete = true;
			ValidChar(2, 0);    // 영문대문자만 입력
            MaxLength = 6;      // 6자리만 입력
        }
        break;       
        
    case "bkg_ctrt_tp_cd":
        var i=0;
        with(comboObj) {
        	DropHeight = 200;
			UseAutoComplete = true;
        	ValidChar(2, 2);    // 영문대문자만 입력 + 특수문자
        }   
        
        case "ofc_tp_cd":
            var i=0;
            with(comboObj) {
            	DropHeight = 100;
    			UseAutoComplete = true;
            	ValidChar(2, 2);    // 영문대문자만 입력 + 특수문자
            }
        break;  
        
    }
}

/**
 * comboObjects[0]의 code값을 리턴<br>
 * <br><b>Example :</b>
 * <pre>
 * 		var code = getRctRhqCd();
 * </pre>
 * @return String <br>
 * @author 이승준
 * @version 2009.06.10
 */ 
function getRctRhqCd() {
	return comboObjects[0].Code;
}
/**
 * comboObjects[1]의 code값을 리턴<br>
 * <br><b>Example :</b>
 * <pre>
 * 		var code = getBkgOfcCd();
 * </pre>
 * @return String <br>
 * @author 이승준
 * @version 2009.06.10
 */ 
function getBkgOfcCd() {
	return comboObjects[1].Code;
}
/**
 * comboObjects[2]의 code값을 리턴<br>
 * <br><b>Example :</b>
 * <pre>
 * 		var code = getBkgCtrtTpCd();
 * </pre>
 * @return String <br>
 * @author 이승준
 * @version 2009.06.10
 */
function getBkgCtrtTpCd() {
	return comboObjects[2].Code;
}


/**
 * rct_rhq_cd combo 변경시 활성화됨<br>
 * qttn_ver_no로 조회한다.<br>
 * <br><b>Example :</b>
 * <pre>
 * 		
 * </pre>
 * @param {comboObj} comboObj    필수,comboObj Object
 * @param {String} code    
 * @param {String} text 
 * @return 없음   
 * @author 이승준
 * @version 2009.06.10
 */ 

	
function bkg_rhq_cd_OnChange(comboObj, code, text) {

	var officeObj = form.bkg_ofc_cd;
	
	officeObj.RemoveAll();
	if(comboObj.GetCount () > 0 && comboObj.Index != "-1") {
		
		var formObj = document.form;
		formObj.etc2.value 	= code;
		
		// 조직도 combo2
    	formObj.f_cmd.value = COMMAND02;
		var sXml = sheetObjects[0].GetSearchXml("RASCommonGS.do", FormQueryString(formObj));
		ComXml2ComboItem(sXml, formObj.bkg_ofc_cd, "cd", "cd");
		formObj.bkg_ofc_cd.Code = formObj.strOfc_cd.value;
		formObj.bkg_ofc_cd.InsertItem(0,'','');
	} 
	
}

 /**
  * IBMultiCombo 에 Item을 setting한다. <br>
  * <br><b>Example :</b>
  * <pre>
  *     initIBComboItem();
  * </pre>
  * @return 없음
  * @author 김대호
  * @version 2009.12.15
  */
function initIBComboItem() {
    var form = document.form;
    ComBkgTextCode2ComboItem(rhqComboValue,          rhqComboValue,         getComboObject(comboObjects, 'bkg_rhq_cd'),         "|", "\t" );
    getComboObject(comboObjects, 'bkg_rhq_cd').Code = form.strRhq_ofc_cd.value;
	ComBkgTextCode2ComboItem(contractTypeComboValue, contractTypeComboText, getComboObject(comboObjects, 'bkg_ctrt_tp_cd'),     "|", "\t" );
	ComBkgTextCode2ComboItem(officeTypeComboValue, officeTypeComboText, getComboObject(comboObjects, 'ofc_tp_cd'),     "|", "\t" );
	getComboObject(comboObjects, 'ofc_tp_cd').Code = 'B';
	}
         
/**
 * 시트 초기설정값, 헤더 정의 <br>
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
 * <br><b>Example :</b>
 * <pre>
 *     initSheet(sheetObj,1);
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
 * @return 없음
 * @author 이승준
 * @version 2009.04.17
 */  
function initSheet(sheetObj,sheetNo) {

	var cnt = 0;
    var sheetID = sheetObj.id;
    switch(sheetID) {
    
		case "sheet0":      //hidden 
         with (sheetObj) {
        	 // Host정보 설정[필수][HostIp, Port, PagePath]
			 if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);
									
         }
         break; 

		case "sheet1":      //sheet1 init
            with (sheetObj) {

                // 높이 설정
                style.height = 425;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                //MergeSheet = msHeaderOnly;
                MergeSheet = msPrevColumnMerge + msHeaderOnly;
               //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(3, 1, 10, 100);
                
                var HeadTitle1 = "RHQ|Office|Retroactive Day|Retroactive Day|Retroactive Day|Retroactive Day|Retroactive Day|Retroactive Day|Retroactive Day|Retroactive Day|Retroactive Day|Retroactive Day|Retroactive Day|Retroactive Day|Total|Total";
                var HeadTitle2 = "RHQ|Office|1~7|1~7|8~14|8~14|15~21|15~21|22~28|22~28|29~35|29~35|36~|36~|Total|Total";
                var HeadTitle3 = "RHQ|Office|Contract|Booking|Contract|Booking|Contract|Booking|Contract|Booking|Contract|Booking|Contract|Booking|Contract|Booking";

                var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
                
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false);

                
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                InitHeadRow(1, HeadTitle2, true);
                InitHeadRow(2, HeadTitle3, true);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtData,		65, daCenter,	true,	"bkg_rhq_cd",		false,	"",  dfNone,	0,	true,	true);
                InitDataProperty(0, cnt++ , dtData,		65, daCenter,	true,	"bkg_ofc_cd",		false,	"",  dfNone,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtAutoSum,	60, daCenter,	true,	"n1wk_ctrt_cnt",	false,	"",  dfInteger,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtAutoSum,	60, daCenter,	true,	"n1wk_bkg_cnt",		false,	"",  dfInteger,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtAutoSum,	60,	daCenter,	true,	"n2wk_ctrt_cnt",	false,	"",  dfInteger,	0,	true,	true);
				
				InitDataProperty(0, cnt++ , dtAutoSum,	60,	daCenter,	true,	"n2wk_bkg_cnt",		false,	"",  dfInteger,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtAutoSum,	60,	daCenter,	true,	"n3wk_ctrt_cnt",	false,	"",  dfInteger,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtAutoSum,	60,	daCenter,	true,	"n3wk_bkg_cnt",		false,	"",  dfInteger,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtAutoSum,	60,	daCenter,	true,	"n4wk_ctrt_cnt",	false,	"",  dfInteger,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtAutoSum,	60,	daCenter,	true,	"n4wk_bkg_cnt",		false,	"",  dfInteger,	0,	true,	true);
				
				InitDataProperty(0, cnt++ , dtAutoSum,	60,	daCenter,	true,	"n5wk_ctrt_cnt",	false,	"",  dfInteger,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtAutoSum,	60,	daCenter,	true,	"n5wk_bkg_cnt",		false,	"",  dfInteger,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtAutoSum,	60,	daCenter,	true,	"n6wk_ctrt_cnt",	false,	"",  dfInteger,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtAutoSum,	60,	daCenter,	true,	"n6wk_bkg_cnt",		false,	"",  dfInteger,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtAutoSum,	60,	daCenter,	true,	"ttl_ctrt_cnt",		false,	"|n1wk_ctrt_cnt|+|n2wk_ctrt_cnt|+|n3wk_ctrt_cnt|+|n4wk_ctrt_cnt|+|n5wk_ctrt_cnt|+|n6wk_ctrt_cnt|",  dfInteger,	0,	false,	false);
				
				InitDataProperty(0, cnt++ , dtAutoSum,	60,	daCenter,	true,	"ttl_bkg_cnt",		false,	"|n1wk_bkg_cnt|+|n2wk_bkg_cnt|+|n3wk_bkg_cnt|+|n4wk_bkg_cnt|+|n5wk_bkg_cnt|+||n6wk_bkg_cnt",  dfInteger,	0,	false,	false);

				SetMergeCell (0, 14, 2, 2);
           }
            break;

    }
}

/**
 * Sheet관련 프로세스 처리 <br>
 * <br><b>Example :</b>
 * <pre>
 *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {form} formObj 필수 html form object
 * @param {int} sAction 필수 프로세스 플래그 상수
 * @return 없음
 * @author 이승준
 * @version 2009.04.17
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg = false;
    switch(sAction) {
      
    	case IBSEARCH:      //조회
    		
    		if (validateForm(sheetObj,formObj,sAction)) {
    			
	    		ComOpenWait(true);		
	    		sheetObj.WaitImageVisible = false;
				
    			formObj.f_cmd.value = SEARCH01;
   			    sheetObj.DoSearch("ESM_BKG_1403GS.do", FormQueryString(formObj));
	 			
				ComOpenWait(false);        		
    			
        	}
    	
    	    break;
    	
    }
    
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
 * <br><b>Example :</b>
 * <pre>
 *     if (validateForm(sheetObj,document.form,IBSAVE)) {
 *         로직처리;
 *     }
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {form} formObj 필수 html form object
 * @param {int} sAction 필수 프로세스 플래그 상수
 * @return bool <br>
 *          true  : 폼입력값이 유효할 경우<br>
 *          false : 폼입력값이 유효하지 않을 경우
 * @author 이승준
 * @version 2009.04.17
 */
function validateForm(sheetObj,formObj,sAction){
  switch (sAction) {
  
	case IBSEARCH: // 조회
		
 		var fmDtObj = form.fm_dt;
 		var toDtObj = form.to_dt;
 		var fmDtValue = fmDtObj.value.replace(/-/g, "");
 		var toDtValue = toDtObj.value.replace(/-/g, "");
 		var ctrtTp       = form.bkg_ctrt_tp_cd; 
 		var ofcTp = form.ofc_tp_cd;
	
 		if(!ComChkObjValid(fmDtObj)) { return false; }
		if(!ComChkObjValid(toDtObj)) { return false; }

 		if("" == fmDtValue || "" == toDtValue){
			 ComShowCodeMessage("BKG95025", "Period"); // "Please input {?msg2}."
			 if("" == fmDtValue){
				 ComSetFocus(fmDtObj);
			 }else{
				 ComSetFocus(toDtObj);
			 }
			 return false;
 		}
		
		if( "" != fmDtValue && "" != toDtValue && ( parseInt(fmDtValue,10) > parseInt(toDtValue, 10) ) ) {
			 ComShowCodeMessage("BKG95026", "From Date", "To Date");
			 ComSetFocus(fmDtObj);
			 return false;
 		}

		var fromAddDays = ComGetDateAdd(fmDtValue, "D", 31, "", true);
		if( parseInt(toDtValue,10) > parseInt(fromAddDays, 10) ) {
			ComShowCodeMessage("BKG95027", "1 Month"); // "The period of Date can't be over {?msg1}."
			ComSetFocus(fmDtObj);
			return false;
		}
    	
//		if(null == ctrtTp.Code || "" == ctrtTp.Code){
//			ComShowCodeMessage("BKG95031", "Contract Type");
//			event.returnValue = false;
//			ComSetFocus(ctrtTp);
//			return false;	
//		}
    	
		if(null == ofcTp.Code || "" == ofcTp.Code){
			ComShowCodeMessage("BKG95031", "Office Type");
			event.returnValue = false;
			ComSetFocus(ofcTp);
			return false;	
		}
		
		return true;
		break;

	}

    return true;
}

/** 
* sheet1 데이터 조회후 발생하는 OnSearchEnd 이벤트핸들러 <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} sheetObj : 시트오브젝트  
* @param  {string} errMsg : 에러메세지  
* @return 없음
* @see #
* @author 김대호
* @version 2010.01.05
*/ 
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with(sheetObj) {
	
		if(sheetObj.RowCount > 1) {
			ShowSubSum("bkg_rhq_cd", "2|3|4|5|6|7|8|9|10|11|12|13|14|15", -1, false, false, 0, "bkg_rhq_cd=%s;bkg_ofc_cd=Sub Total");
		}		
		
		SetMergeCell (LastRow, 0, 0, 2);
		SumText(0, "bkg_rhq_cd") = "Grand Total";    			
		SumBackColor = RgbColor(0,255,255);
		
	}
}



/**
 * 화면을 전체 리셋한다.<br>
 * <br><b>Example :</b>
 * <pre>
 *     removeAll(formObj)
 * </pre>
 * @param {formObj} formObj    
 * @return 없음
 * @author 이승준
 * @version 2009.06.10
 */
function removeAll(formObj) {
	
	formObj.reset();
	comboObjects[0].Index = "-1";
	comboObjects[1].Index = "-1";
	comboObjects[1].RemoveAll();
	comboObjects[2].Index = "-1";
	
	formObj.bkg_rhq_cd.Code = form.strRhq_ofc_cd.value;  	 		
	
	sheetObjects[1].RemoveAll();

} 

	/* 개발자 작업  끝 */