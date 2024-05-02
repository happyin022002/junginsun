﻿/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_2077.js
*@FileTitle : Inventory by Lessor & Agreement
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.09.10 조재성
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
     * @class EES_CGM_2077 : EES_CGM_2077 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_CGM_2077() {
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
 * @version 2009.09.10
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

            case "btns_vndr":
            	ComOpenPopup('/hanjin/COM_ENS_0C1.do', 700, 455, "callBackVendor", "0,1,1,1,1,1", true, false);
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
 * @version 2009.09.09
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
 * @version 2009.09.10
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
  	 comboObjects[comboCnt++] = document.agmt_lstm_cd;

   	 for(var k=0;k<comboObjects.length;k++){
         initCombo(comboObjects[k]);
     } 

   	 /*
     // Lease Term MultiCombo 값 설정
     doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC05);
	 */
 	 doActionIBSheet(sheetObjects[0], document.form, IBRESET);
 	 
     initControl();
     
     sheetObj.WaitImageVisible = true; 
 }
 
  /**
   * Form의 Conrol 를 초기화 시킨다. <br>
   * @param  없음
   * @return 없음
   * @author 조재성
   * @version 2009.09.10
   */
 function initControl(){
  	 var formObj = document.form;
  	 var sheetObj = sheetObjects[0];
  	 
  	 // Form Object 초기화
  	 with(formObj){
  		 crnt_ofc_cd.value  = "";
  		 vndr_seq.value		= "";
  	 }
  	 
  	 // MultiCombo 초기화
  	 for(var i=0; i<comboObjects.length; i++){
  		 comboObjects[i].Text2 = "";
  	 }
  	 
  	 // Sheet Object 초기화
  	 sheetObj.RemoveAll();
	 
  	 //formObj.crnt_ofc_cd.focus();
	 // 초기값 설정
     }


 /**
  * 시트 초기설정값, 헤더 정의 <br>
  * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
  * @param  {object} sheetObj	필수	 Sheet Object
  * @param  {int} sheetNo		필수 시트오브젝트 태그의 아이디에 붙인 일련번호
  * @return 없음
  * @author 조재성
  * @version 2009.09.10
  */
 function initSheet(sheetObj,sheetNo) {
     var cnt = 0;
	 var sheetID = sheetObj.id;
     switch(sheetID) {

         case "sheet1":
             with (sheetObj) {

                 // 높이 설정
                 style.height = 280;
                 //전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 //MergeSheet = msHeaderOnly;
                 MergeSheet = msPrevColumnMerge;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = true;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 1, 1, 3, 100);

                 var HeadTitle = "Lessor|AGMT No.|Ref.No|Total|UMG|CLG";
									
									
                 var headCount = ComCountHeadTitle(HeadTitle);

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(headCount, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(false, true, true, true, false,false)

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle, true);

                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++ , dtData,      120,    daCenter,  true,     "vndr_lgl_eng_nm",  	false,    "",      dfNone, 0, false, false);
                 InitDataProperty(0, cnt++ , dtData,      120,    daCenter,  false,     "agmt_no", 				false,    "",      dfNone, 0, false, false);
                 InitDataProperty(0, cnt++ , dtData,      150,    daCenter,  false,     "agmt_ref_no", 			false,    "",      dfNone, 0, false, false);
                 InitDataProperty(0, cnt++ , dtAutoSum,   185,    daRight,   false,     "eq_tpsz_cd_total",  	false,    "",      dfNone, 0, false, false);
                 InitDataProperty(0, cnt++ , dtAutoSum,   185,    daRight,   false,     "eq_tpsz_cd_umg",     	false,    "",      dfNone, 0, false, false);
                 InitDataProperty(0, cnt++ , dtAutoSum,  180,    daRight,   false,     "eq_tpsz_cd_clg",     	false,    "",      dfNone, 0, false, false);


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
	 			var sXml = sheetObj.GetSearchXml("EES_CGM_2077GS.do" , FormQueryString(formObj));
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

    	case IBSEARCH_ASYNC05:	// Term Code Combo 조회
	       	formObj.f_cmd.value = SEARCH;
	       	formObj.intg_cd_id.value = COM_CD_TYPE_CD01948;		// 코드Type 설정 ( AGREEMENT LEASE TERM CODE )
	   		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
	   			    			
	   		var sStr = ComGetEtcData(sXml,"comboList");    			
	   		var arrStr = sStr.split("@");

	  		makeComboObject(formObj.agmt_lstm_cd, arrStr, 0, 0, 0);
	  		comboObjects[0].DeleteItem(0);
	       	break;

    	case IBDOWNEXCEL:        //엑셀 다운로드
			sheetObj.SpeedDown2Excel(-1);
            break;
            
    	case IBRESET:
    		var idx = 0
    		var sXml2 = document.form2.sXml.value;
    		var arrXml = sXml2.split("|$$|");

    		//Lease Term
    		if ( arrXml[idx] == null ) {return;}
    		var vArrayListData = ComCgmXml2ListMap(arrXml[idx]);
    	    var arrStr3 = new Array();
    		for ( var i = 0; i < vArrayListData.length; i++) {
    		    vListData = vArrayListData[i];
    		    arrStr3[i] = vListData["code1"] + "|" + vListData["desc1"];
    		}
	  		makeComboObject(formObj.agmt_lstm_cd, arrStr3, 0, 0, 0);
	  		comboObjects[0].DeleteItem(0); // <= chungpa 20091229 확인 요망.
	  		idx++;
     	  	
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
 * @version 2009.09.10
 */ 
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		switch(sAction){
			case IBSEARCH:
//				
//				chungpa 20091029 office option처리함.
//				if(crnt_ofc_cd.value == ''){
//					ComShowCodeMessage('CGM10004','Office');
//					crnt_ofc_cd.focus();
//					return false;
//				} else {
//					return true;
//				}
				
				break;
		}
	}
	return true;
}

 /**
  * 콜백 함수. <br>
  * 공통팝업 ServiceProvider에서 선택한 Lessor Seq를 Form Object 인 vndr_seq에 설정한다.
  * @param  {Array} aryPopupData	필수	 Array Object
  * @param  {Int} row				필수 선택한 Row
  * @param  {Int} col				필수 선택한 Column
  * @param  {Int} sheetIdx			필수 Sheet Index
  * @return 없음
  * @author 조재성
  * @version 2009.07.16
  */   
 function callBackVendor(aryPopupData, row, col, sheetIdx){
     	 
    	var formObj = document.form;
     var vndrSeq = "";
     var i = 0;
     	 
     for(i = 0; i < aryPopupData.length; i++){
     	vndrSeq = vndrSeq + aryPopupData[i][2];
     		
     	if(i < aryPopupData.length - 1){
     		vndrSeq = vndrSeq + ",";
     	}
     }
     	 
     formObj.vndr_seq.value = vndrSeq;
     	 
 }	
  
function sheet1_OnChangeSum(sheetObj, Row)
 {
 	with(sheetObj)
 	{
 		SumText(0, "Seq") = "Total/%";
 		//SumText(0, "TPSZ") = "Grand Total";
 		
 		CellAlign(Row, "TPSZ") = daCenter;
 	}
 }

/**
 * Sheet1 의 OnSearchEnd 이벤트처리 <br>
 * @param  {object} sheetObj	필수	 Sheet Object
 * @param  {string} ErrMsg		필수 String
 * @return 없음
 * @version 2009.09.10
 */ 
function sheet1_OnSearchEnd(sheetObj, ErrMsg)
{
 	with(sheetObj)
 	{
         with(sheetObj)
         {
             ShowSubSum(0, "3|4|5", -1, false, false,	-1,"vndr_lgl_eng_nm=Sub Total");
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
		 //var groupValue1 = sheetObj.cellValue(sheetObj.MouseRow, "vndr_lgl_eng_nm");
		 //alert(groupValue1);
		 sheet1_OnDblClick(sheetObj, sheetObj.MouseRow, sheetObj.MouseCol, 0, 0, 0, 0);
	 }
	 
 }
 /**
 * Sheet1 의 Double Click 할 경우 상세정보 화면표시 <br>
 * @author 조재성
 * @version 2009.09.10
 */      
function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
	
	var eqKndCd			= EQ_KND_CD_MGSET;
	var crntOfcCd		= document.form.crnt_ofc_cd.value;
	var vndrSeq			= document.form.vndr_seq.value;
	var agmtLstmCd		= document.agmt_lstm_cd.Text;
	
	var group1 = "";
	
	var groupValue1 = "";
	if(sheetObj.cellValue(Row, "vndr_lgl_eng_nm") == "Sub Total")
	{
		groupValue1 = sheetObj.cellValue(Row, "vndr_lgl_eng_nm"); // "123456.VENDER"
	}else{
		//기존 groupValue1 = sheetObj.cellValue(Row, "vndr_lgl_eng_nm").substring(0,6); // "123456.VENDER"
		var dispText = sheetObj.cellValue(Row, "vndr_lgl_eng_nm");
		if(dispText.length >=8)
		{
			groupValue1 = dispText.substr(dispText.indexOf('(')+1,6);
		}else
		{
			groupValue1 = dispText;
		}
	}
	
	
	var s2_group1 = "";
	var s2_groupValue1 = "";
	
  	var s3_gtotal = "";
	if(groupValue1 == "Sub Total")
	{
		s2_group1 = "SubSum";
		//s2_groupValue1 = groupValue1.substring(9);
		//기존 s2_groupValue1 = sheetObj.CellValue(Row-1,"vndr_lgl_eng_nm" ).substring(0,6);
		
		var dispText = sheetObj.cellValue(Row-1, "vndr_lgl_eng_nm");
		if(dispText.length >=8)
		{
			s2_groupValue1 = dispText.substr(dispText.indexOf('(')+1,6);
		}else
		{
			s2_groupValue1 = dispText;
		}
		
		
		//groupValue1 = groupValue1.substring(9); // SubSum일경우 그룹바이명을 맞추어준다.
		groupValue1 = s2_groupValue1;
	}else if(groupValue1 == "TOTAL"){
  		s3_gtotal = "GTOTAL";
  	}else{
		s2_group1 = "";
		s2_groupValue1 = "";
	}
	var s2AgmtNo = sheetObj.cellValue(Row, "agmt_no");
	var s2AgmtRefNo = sheetObj.cellValue(Row, "agmt_ref_no");
	
	//if(comboObjects[2].Code == "") 선택이 안되었을때는 Code == ""
	
	if(parseInt(Col) == 3)s2EqTpszCd="TOTAL";
	else if(parseInt(Col) == 4)s2EqTpszCd="UMG";
	else if(parseInt(Col) == 5)s2EqTpszCd="CLG";
	
	var param = "?program_id=2077";
	param = param + "&eq_knd_cd=" + eqKndCd;
	param = param + "&s_crnt_ofc_cd=" + crntOfcCd;
	param = param + "&s_vndr_seq=" + vndrSeq;
	param = param + "&s_agmt_lstm_cd=" + agmtLstmCd;
	
	param = param + "&s_group1=" + group1; 
	param = param + "&s_group1_val=" + groupValue1;
	param = param + "&s2_group1=" + s2_group1;
	param = param + "&s2_group1_val=" + s2_groupValue1;

	param = param + "&s2_agmt_no=" + s2AgmtNo;
	param = param + "&s2_agmt_ref_no=" + s2AgmtRefNo;
	param = param + "&s2_eq_tpsz_cd=" + s2EqTpszCd;
  	param = param + "&s3_gtotal=" + s3_gtotal;
	
	//alert(param);
	var seq = sheetObj.cellValue(Row, "Seq");
	if(Col > 2 ){
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
	 
	//ComChkObjValid(event.srcElement);
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
//			chungpa 20091029 office option처리함.	 		
//	 		var crntOfcCd = ComTrimAll(formObj.crnt_ofc_cd.value);
//	   		if( formObj.crnt_ofc_cd.value.search(',') > 0 || (formObj.crnt_ofc_cd.value == '')) // 다중 yard code(,로 연결됨)이면 검사하지 않는다. 
//	   		{
//	   			break;
//	   		}
//	   		var arrCrntOfcCd = crntOfcCd.split(",");
//	   		
//	   		for(var i = 0; i < arrCrntOfcCd.length; i++){
//	   		// 입력오류 체크 (예> ,,)
//	 			if(arrCrntOfcCd[i] == ''){
//	 				ComShowCodeMessage('CGM10009','Office');
//	 				formObj.crnt_ofc_cd.value = "";
//	 				ComSetFocus(formObj.crnt_ofc_cd);
//	 				break;
//	 			}else
//	 			{
//	    	 		if(formObj.crnt_ofc_cd.value != ''){
//	    	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
//	    	 		}
//	 			}
//	   		}
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
	   if(formObj.crnt_ofc_cd.value != '')
	   {
		   if(event.keyCode == 13)
			   ComKeyEnter('search');
	   }
	 	 
   }  
	/* 개발자 작업  끝 */