/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_2079.js
*@FileTitle : Inventory by Creation Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.09.11 조재성
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
     * @class EES_CGM_2079 : EES_CGM_2079 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_CGM_2079() {
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
 var tabCnt = 0 ;
 var beforetab = 1;

 var sheetObjects = new Array();
 var sheetCnt = 0;

 var comboObjects = new Array();
 var comboCnt = 0;
 
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
 * @param 없음
 * @return 없음
 * @author 조재성
 * @version 2009.09.11
 */ 
 function processButtonClick(){
      /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
      var sheetObject = sheetObjects[0];

      /*******************************************************/
      var formObject = document.form;

 	try {
 		var srcName = window.event.srcElement.getAttribute("name");

         switch(srcName) {

             case "btn_retrieve":
        		if(validateForm(sheetObject,formObject,IBSEARCH) != false) {
        			doActionIBSheet(sheetObject, formObject, IBSEARCH);
        		}
							break;

             case "btn_new":
            	initControl();
							break;

            case "btn_downexcel":
            	doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
                break;

            case "ComOpenPopupWithTargetOffice":
            	ComOpenPopupWithTarget('/hanjin/COM_ENS_071.do', 800, 480, "ofc_cd:crnt_ofc_cd", "0,1,1,1,1,1,1", true);
            	break;

			case "btns_Calendar2" :		// Agreement Date (To Date)
//				var cal = new ComCalendar();
				var cal = new ComCalendarFromTo();
//	    		cal.select(formObject.evnt_dt_end, "yyyy-MM-dd");
	    		cal.select(formObject.inq_fm_dys,  formObject.inq_to_dys,  'yyyy-MM-dd');
// 	    		cal.select(formObject.evnt_dt_end, "yyyy-MM-dd");
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
 * @version 2009.09.11
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
 * @version 2009.09.11
  */
 function loadPage() {
     for(i=0;i<sheetObjects.length;i++){
    	 //khlee-시작 환경 설정 함수 이름 변경
         ComConfigSheet (sheetObjects[i] );
         initSheet(sheetObjects[i],i+1);
         //khlee-마지막 환경 설정 함수 추가
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
     sheetObj.WaitImageVisible = false;
  
   	 // axon event 등록
     axon_event.addListenerFormat('keypress', 'obj_keypress', form);
     axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
     axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form);
     axon_event.addListener('change', 'obj_change' , 'crnt_ofc_cd');   	
     axon_event.addListener('keyup', 'enterFire', 'crnt_ofc_cd')     
     
  	 // Multi Combo 초기화
   	 for(var k=0;k<comboObjects.length;k++){
         initCombo(comboObjects[k]);
     } 

     initControl();
     
     sheetObj.WaitImageVisible = true; 
 }
 
  /**
   * Form의 Conrol 를 초기화 시킨다. <br>
   * @param  없음
   * @return 없음
   * @author 조재성
   * @version 2009.09.11
   */
 function initControl(){
  	 var formObj = document.form;
  	 var sheetObj = sheetObjects[0];
  	 
  	 // Form Object 초기화
  	 with(formObj){
  		 crnt_ofc_cd.value  = "";
         inq_fm_dys.value = "";
         inq_to_dys.value = "";
  	 }
  	 
  	 // MultiCombo 초기화
  	 for(var i=0; i<comboObjects.length; i++){
  		 comboObjects[i].Text2 = "";
  	 }
  	 
  	 // Sheet Object 초기화
  	 sheetObj.RemoveAll();
	 
	 // 초기값 설정
     }


   /**
  * 시트 초기설정값, 헤더 정의 <br>
  * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
  * @param  {object} sheetObj	필수	 Sheet Object
  * @param  {int} sheetNo		필수 시트오브젝트 태그의 아이디에 붙인 일련번호
  * @return 없음
  * @author 조재성
  * @version 2009.09.11
  */
 function initSheet(sheetObj,sheetNo) {
     var cnt = 0;
	 var sheetID = sheetObj.id;
     switch(sheetID) {

         case "sheet1":
             with (sheetObj) {

                 // 높이 설정
                 style.height = 140;
                 //전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = true;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 1, 1, 3, 100);

				 var HeadTitle = "Office|Total|UMG|CLG";
				 var headCount = ComCountHeadTitle(HeadTitle);
				 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(headCount, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(false, true, true, true, false,false)

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle, true);

                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++ , dtData,      260,    daCenter,  false,     "sts_evnt_ofc_cd", 		false,    "",      dfNone, 0, false, false);
                 InitDataProperty(0, cnt++ , dtAutoSum,   230,    daRight,   false,     "eq_tpsz_cd_total",  	false,    "",      dfNone, 0, false, false);
                 InitDataProperty(0, cnt++ , dtAutoSum,   230,    daRight,   false,     "eq_tpsz_cd_umg",     	false,    "",      dfNone, 0, false, false);
                 InitDataProperty(0, cnt++ , dtAutoSum,   230,    daRight,   false,     "eq_tpsz_cd_clg",     	false,    "",      dfNone, 0, false, false);


                 CountPosition = 0;

                 EditableColorDiff = false;
                }
                 break;
         }
     }

/**
 * Sheet관련 프로세스 처리 <br>
 * @param  {object} sheetObj	필수	 Sheet Object
 * @param  {object} formObj	필수 Form Object
 * @param  {String} sAction	필수 Action Type
 * @return 없음
 * @author 조재성
 * @version 2009.07.21
 */
 function doActionIBSheet(sheetObj,formObj,sAction) {
     sheetObj.ShowDebugMsg = false;
     switch(sAction) {

        case IBSEARCH:      //조회
	        // Form Object 값 설정
	    	formObj.f_cmd.value = SEARCH;
	 		formObj.eq_knd_cd.value = EQ_KND_CD_MGSET;
	 		
	 		// 조회실행
	 		if(validateForm(sheetObj,formObj,sAction))
	 		{
		 		sheetObj.WaitImageVisible=false;
		 		ComOpenWait(true);	 		 			
	 			var sXml = sheetObj.GetSearchXml("EES_CGM_2079GS.do" , FormQueryString(formObj));
	 			sheetObj.LoadSearchXml(sXml);
		 		ComOpenWait(false);	 		 			
	 		}
            break;

        case IBSEARCH_ASYNC02:	// Office Code 에 대한 Validation 체크 
		   	formObj.f_cmd.value = COMMAND01;
		   	formObj.ofc_cd.value = formObj.crnt_ofc_cd.value;
		   	var sXml = sheetObj.GetSearchXml("CgmValidationGS.do", FormQueryString(formObj));
		   	var sCheckResult = ComGetEtcData(sXml,"checkResult");    	
		   	
		   	if(sCheckResult == COM_VALIDATION_FALSE){
		   		ComShowCodeMessage('CGM10009','Office');
		   		formObj.crnt_ofc_cd.value = "";
		   		formObj.crnt_ofc_cd.focus();
		   	}
		   	break;

        case IBDOWNEXCEL:        //엑셀 다운로드
 	   		sheetObj.SpeedDown2Excel(-1);
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
 * @version 2009.09.11
 */ 
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		switch(sAction){
			case IBSEARCH:
				/*
				if(crnt_ofc_cd.value == ''){
					ComShowCodeMessage('CGM10004','Office');
					crnt_ofc_cd.focus();
					return false;
				} else {
					return true;
				}*/
				
				if(inq_fm_dys.value == '')
				{
       				ComShowCodeMessage('CGM10004','Period ');
    				inq_fm_dys.focus();
    				
    				return false;
				}
				if(inq_to_dys.value == '')
				{
       				ComShowCodeMessage('CGM10004','Period ');
    				inq_to_dys.focus();
    				
    				return false;
				}
				
 		 		if(inq_fm_dys.value != '' && inq_to_dys.value != ''){
	        		var dt_str = ComReplaceStr(document.form.inq_fm_dys.value,"-","");
	     			var dt_end = ComReplaceStr(document.form.inq_to_dys.value,"-","");
	 	        	
	
	 	    		if(dt_str != '' && dt_end != ''){
	 	    			if(dt_end < dt_str){
	 	    				ComShowCodeMessage('COM12133','To date','From date','greater');
	 	    				inq_fm_dys.value='';
	 	    				
	 	    				inq_fm_dys.focus();
	 	    				return false;
	 	    			}
	 	    		}
 		 		}
 		 		break;
		}
	}
	return true;
}

/**
 * Sheet1 의 OnSearchEnd 이벤트처리 <br>
 * @param  {object} sheetObj	필수	 Sheet Object
 * @param  {string} ErrMsg		필수 String
 * @return 없음
 * @version 2009.09.11
 */ 
function sheet1_OnSearchEnd(sheetObj, ErrMsg)
{
 	with(sheetObj)
 	{
         with(sheetObj)
         {
             //ShowSubSum(0, "1|2|3", -1, false, false,	-1,"");
         }
 		
 	}
}

/**
 * Sheet1 의 OnMouseDown 이벤트처리 <br>
 * @param  {Integer} Button	필수 Integer
 * @param  {integer} Shift	필수 Integer
 * @param  {Integer} X	필수 Integer
 * @param  {integer} Y	필수 Integer
 * @return 없음
 * @author 조재성
 * @version 2009.09.16
 */ 
 function sheet1_OnMouseDown (Button, Shift, X, Y){
	 var sheetObj = sheetObjects[0];
	 var formObj = document.form;
	 if(sheetObj.rowcount + 1 == sheetObj.mouseRow)
	 {
		 //alert("ROWCNT:"+ sheetObj.rowcount+"=>"+ sheetObj.MouseRow +":"+sheetObj.MouseCol)	 
		 //var groupValue1 = sheetObj.cellValue(sheetObj.MouseRow, "sts_evnt_ofc_cd");
		 //alert(groupValue1);
		 sheet1_OnDblClick(sheetObj, sheetObj.MouseRow, sheetObj.MouseCol, 0, 0, 0, 0);
	 }
	 
 }
 
/**
 * Sheet1 의 Double Click 할 경우 상세정보 화면표시 <br>
 * @author 조재성
 * @version 2009.09.11
 */      
function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
	
	var eqKndCd			= EQ_KND_CD_MGSET;
	var crntOfcCd		= document.form.crnt_ofc_cd.value;
	var inqFmDys 		= document.form.inq_fm_dys.value;
	var inqToDys		= document.form.inq_to_dys.value;
	
	var group1 = "";
	var groupValue1 = sheetObj.cellValue(Row, "sts_evnt_ofc_cd");
	
	var s2_group1 = "";
	var s2_groupValue1 = "";
	
  	var s3_gtotal = "";
	if(groupValue1.substring(0,6) == "SubSum")
	{
		s2_group1 = "SubSum";
		s2_groupValue1 = groupValue1.substring(9);
		
		groupValue1 = groupValue1.substring(9); // SubSum일경우 그룹바이명을 맞추어준다.
	}else if(groupValue1 == "TOTAL"){
  		s3_gtotal = "GTOTAL";
  	}else
	{
		s2_group1 = "";
		s2_groupValue1 = "";
	}

	var s2EqTpszCd = "";
	if(parseInt(Col) == 1)s2EqTpszCd="TOTAL";
	else if(parseInt(Col) == 2)s2EqTpszCd="UMG";
	else if(parseInt(Col) == 3)s2EqTpszCd="CLG";
	
	var param = "?program_id=2079";
	param = param + "&eq_knd_cd=" + eqKndCd;
	param = param + "&s_crnt_ofc_cd=" + crntOfcCd;
	param = param + "&s1_inq_fm_dys=" + inqFmDys;
	param = param + "&s1_inq_to_dys=" + inqToDys;
	
	param = param + "&s_group1=" + group1; 
	param = param + "&s_group1_val=" + groupValue1;
	param = param + "&s2_group1=" + s2_group1;
	param = param + "&s2_group1_val=" + s2_groupValue1;

	param = param + "&s2_eq_tpsz_cd=" + s2EqTpszCd;
	param = param + "&s3_gtotal=" + s3_gtotal;
	
	var seq = sheetObj.cellValue(Row, "Seq");
	if(Col >= 1 ){
		ComOpenPopup('/hanjin/EES_CGM_2084.do' + param, 900, 460, "", "1,0", true, false);
    }else
    {
  	    ComShowCodeMessage('CGM10016');
    }
 
}    

 /** 
  * Object 의 activate 이벤트에 대한 처리  <br>
  * @param  없음
  * @return 없음
  * @author 조재성
  * @version 2009.09.10
  */
 function obj_activate(){
   	ComClearSeparator(event.srcElement);
 } 

/** 
  * Object 의 deactivate 이벤트에 대한 처리  <br>
  * @param  없음
  * @return 없음
  * @author 조재성
  * @version 2009.09.10
  */
 function obj_deactivate(){
     	 var formObj = document.form;
     	 obj = event.srcElement;

     	 if(obj.name=="inq_fm_dys"  ){
         			
     		 with(formObj){
  	        			
     			 var creDtFr = ComReplaceStr(inq_fm_dys.value,"-","");
  	        }
  	        	
  	        ComChkObjValid(event.srcElement);
         }
       	if(obj.name=="inq_to_dys"  ){
    		with(formObj){
    			 var creDtFr = ComReplaceStr(inq_to_dys.value,"-","");
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
  * @version 2009.09.10
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
  	        if(obj.name=="crnt_ofc_cd") ComKeyOnlyAlphabet('upper',"44");//ComKeyOnlyAlphabet('uppernum');
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
  * @version 2009.09.10
  */  
 function obj_change(){
 	 var formObj = document.form;
 	 var sheetObj = sheetObjects[0]; 
 	 obj = event.srcElement;
 	 switch(obj.name){

	 	case "crnt_ofc_cd":
	 		var crntOfcCd = ComTrimAll(formObj.crnt_ofc_cd.value);
	   		if( formObj.crnt_ofc_cd.value.search(',') > 0 || (formObj.crnt_ofc_cd.value == '')) // 다중 yard code(,로 연결됨)이면 검사하지 않는다. 
	   		{
	   			break;
	   		}
	   		var arrCrntOfcCd = crntOfcCd.split(",");
	   		
	   		for(var i = 0; i < arrCrntOfcCd.length; i++){
	   		// 입력오류 체크 (예> ,,)
	 			if(arrCrntOfcCd[i] == ''){
	 				ComShowCodeMessage('CGM10009','Office');
	 				formObj.crnt_ofc_cd.value = "";
	 				ComSetFocus(formObj.crnt_ofc_cd);
	 				break;
	 			}else
	 			{
	    	 		if(formObj.crnt_ofc_cd.value != ''){
	    	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
	    	 		}
	 			}
	   		}
	 		break;
 	   	case "vndr_seq":
 	   		var vndrSeq = ComTrimAll(formObj.vndr_seq.value);
 	   		var arrVndrSeq = vndrSeq.split(",");
 	   		
 	   		for(var i = 0; i < arrVndrSeq.length; i++){
 	   		// 입력오류 체크 (예> ,,)
 	 			if(arrVndrSeq[i] == ''){
 	 				ComShowCodeMessage('CGM10009','Lessor');
 	 				formObj.vndr_seq.value = "";
     	 				ComSetFocus(formObj.vndr_seq);
     	 				break;
     	 			}
     	   		}	 

      	   	     	 break;
     	 }   
     }

/** 
 * Object 의 obj_focusout 이벤트에 대한 처리  <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2009.09.10
 */  
function obj_focusout(){
	 var formObj = document.form;
	 var sheetObj = sheetObjects[0];
	 obj = event.srcElement;
	 switch(obj.name){
	 	case "crnt_ofc_cd":

	 		break;
	 }
}

/** 
  * Combo Object 초기화  <br>
  * @param  {object} comboObj	필수 Combo Object
  * @return 없음
  * @author 조재성
  * @version 2009.09.09
  */ 
 function initCombo(comboObj) {
 	switch(comboObj.id) {
    	case "agmt_lstm_cd":
 	 		var cnt=0;
  	        with(comboObj) {
  	        	Code = "";
  	            Text = "";
  	            DropHeight = 180;
  	            MultiSelect = true;
  	            MaxSelect = 100;	    
  	            UseCode = true;
  	            Enable = true;
  	            
	        	ValidChar(2,3);         // 영어 대문자, 숫자포함+특수(',')
	            IMEMode = 0;            // 영문
	            MaxLength = 20;         // 100자까지 입력
  	        }
  	        
  	        break;
 	}
 }   

 /** 
  * Combo Object 에 값을 추가하는 처리 <br>
  * @param  {object} cmbObj	필수 Combo Object
  * @param  {String} arrStr	필수 대상 문자열 (다수의 경우는 '|' 로 구분) 
  * @param  {int} 	txtCol	필수 Combo Text에 표시할 Colume Index 번호
  * @param  {int} 	codeCol	필수 Combo Code 값에 설정할 Column Index 번호
  * @param  {int} 	opt		필수 공백문자 추가여부 (0:추가안함, 1:추가)
  * @return 없음
  * @author 조재성
  * @version 2009.09.10
  */ 
 function makeComboObject(cmbObj, arrStr, txtCol, codeCol, opt) {
 	cmbObj.RemoveAll();
 	
 	if(opt == 0) {
 		for (var i = 0; i < arrStr.length;i++ ) {
 			var arrCode = arrStr[i].split("|");
     		cmbObj.InsertItem(i, arrCode[txtCol], arrCode[codeCol]);
         }
 	} else if(opt == 1){
 		cmbObj.InsertItem(0,"","");
 		for (var i = 0; i < arrStr.length;i++ ) {
 			var arrCode = arrStr[i].split("|");
     		cmbObj.InsertItem(i+1, arrCode[txtCol], arrCode[codeCol]);
         }
 	}
 	
 	cmbObj.Index2 = "" ;
 } 

 /** 
  * CP Combo Object 에 값을 추가하는 처리 <br>
  * @param  {object} cmbObj	필수 Combo Object
  * @param  {String} arrStr	필수 대상 문자열 (다수의 경우는 '|' 로 구분) 
  * @param  {int} 	txtCol	필수 Combo Text에 표시할 Colume Index 번호
  * @param  {int} 	codeCol	필수 Combo Code 값에 설정할 Column Index 번호
  * @return 없음
  * @author 조재성
  * @version 2009.07.16
  */ 
 function makeCPMultiCombo(cmbObj, arrStr, txtCol, codeCol) {
    	cmbObj.RemoveAll();
 
    	// LOOP를 돌리기 위해 데이타 갯수를 구함 
    	if(arrStr == undefined ){
    		cmbObj.InsertItem(0, "Include Pool Chassis", "I" );
			cmbObj.InsertItem(1, "Exclude Pool Chassis", "E" );
			cmbObj.InsertItem(2, "Only Pool Chassis", "O" );
    	} else {
        	var arrCode = arrStr[0].split("|");
      	var arrCode2 = arrStr[1].split("|");
          	
          	for (var i = 0; i < arrCode.length;i++ ) {
          		var arrCode3 = arrCode[i].split("|");
          		var arrCode4 = arrCode2[i].split("|");
          		if(i==0)
          		{
          			cmbObj.InsertItem(0, "Include Pool Chassis", "I" );
          			cmbObj.InsertItem(1, "Exclude Pool Chassis", "E" );
          			cmbObj.InsertItem(2, "Only Pool Chassis", "O" );
          			cmbObj.InsertItem(i+3, arrCode4[txtCol], arrCode3[codeCol]);
          		}
          		else
          		{
          			cmbObj.InsertItem(i+3, arrCode4[txtCol], arrCode3[codeCol]);
          		}
          		
          	}
    	}

    	cmbObj.Index2 = "" ;
    } 

  /** 
   * 기본조건 입력 후 ENTER키 적용 <br>
   * @param  없음
   * @return 없음
   * @author 조재성
   * @version 2009.09.10
   */ 
   function enterFire() {
	   var formObj = document.form;
	   if(formObj.inq_fm_dys.value != '' && formObj.inq_to_dys.value)
	   {
		   if(event.keyCode == 13)
			   ComKeyEnter('search');
	   }
	 	 
   }  
	/* 개발자 작업  끝 */