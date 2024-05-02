/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0102.js
*@FileTitle : Code Conversion for CPR
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.28
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.08.28 한동훈
* 1.0 Creation
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
     * @class FNS_INV_0102 : FNS_INV_0102 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function FNS_INV_0102() {
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
	
	 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	 document.onclick = processButtonClick;
	
	 /** 
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  없음  
	 * @return 없음
	 * @see #
	 * @author 한동훈
	 * @version 2009.10.19
	 */
     function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject1 = sheetObjects[0];

         /*******************************************************/
         var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

                                           
            switch(srcName) {
                 case "btn2_Row_Add":
                	 doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
                 break; 

 				case "btn2_Row_Delete": 					
 					if(!validateForm(sheetObjects[0],formObject,IBDELETE)) {
        				return false;
        			}
 					ComRowHideDelete(sheetObjects[0], "DelChk");
                 break;

 				case "btn1_Retrieve":
 					doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
                 break; 

 				case "btn1_New":
 					ComResetAll();
                 break;

 				case "btn1_Save":
 					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
                 break;
    
 				case "btn1_Down_Excel": 					
 					//sheetObjects[0].Down2Excel(0, false, false, true, "", "", false, false, "", false, "|ibflag|DelChk|seq|sc_no|rfa_no|cprt_conv_tp_cd");
 					sheetObjects[0].SpeedDown2Excel(0, false, false, "", "", false, false, "", false, "|ibflag|DelChk|seq|sc_no|rfa_no|cprt_conv_tp_cd");
                 break; 

 				case "btn1_Load_Excel":
 					//sheetObjects[0].LoadExcel();
 					sheetObjects[0].LoadExcel(0, 1, "", "-1", "-1", "", true, false, "1=>hjs_cd_ctnt|2=>cust_conv_cd_ctnt|3=>cd_rmk");
 					copy_end(sheetObjects[0],formObject)
                 break;

 				case "btn1_Copy_to_New":
 					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC05);
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
      * IBSheet Object를 sheetObjects 배열로 등록 <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  {IBSheet} sheetObj IBSheet Object
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
     }

     /** 
      * body 태그의 onLoad 이벤트핸들러 구현 <br>
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br> 
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  없음
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
     function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
 			//khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
 			//khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }
         ComSetFocus(document.form.sc_no2);
         initControl();
         axon_event.addListenerForm ('focusout', 'obj_focusout', document.form);
         axon_event.addListenerForm ('keyup', 'obj_keyup', document.form);
     }
     
     /** 
      * onLoad 이벤트핸들러시 호출 오브젝트에 대한 이벤트 <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  없음
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
	function initControl() {
	    //Axon 이벤트 처리1. 이벤트catch(개발자변경)
	    axon_event.addListenerFormat('keypress',       'obj_keypress',    form); //- 키보드 입력할때
	}
	
	/** 
	 * 업무 자바스크립트 OnKeyPress 이벤트 처리 (키보드가 눌릴 때)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 한동훈
      	 * @version 2009.10.19
	 */
	function obj_keypress(){
	    switch(event.srcElement.dataformat){
	        case "float":
	            //숫자+"."입력하기
	            ComKeyOnlyNumber(event.srcElement, ".");
	            break;
	        case "ymd":
	            //숫자+"-"입력하기
	        	ComKeyOnlyNumber(event.srcElement);
	            break;
	        case "eng":
	            //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
	            ComKeyOnlyAlphabet();
	            break;
	        case "engdn":
	            //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
	            ComKeyOnlyAlphabet('lower');
	            break;
	        case "engup":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('upper');
	            break;
	        case "num":
	        	//숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber('num');
	            break;
	        case "uppernum":
	        	//영문대+숫자 
	        	ComKeyOnlyAlphabet('uppernum');
	            break;
	        default:
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('upper');
	    }
	}
     
     /** 
      * Sheet 기본 설정 및 초기화 <br>
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다. <br> 
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param {IBSheet} sheetObj : 시트오브젝트
      * @param {int} sheetNo : 시트오브젝트 태그의 아이디에 붙인 일련번호  
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt = 0;
         switch(sheetObj.id) {
              case "sheet1":      //sheet1 init
                 with (sheetObj) {
 					// 높이 설정
 					style.height = 360;
 										
 					//전체 너비 설정
 					SheetWidth = mainTable.clientWidth;

 					//Host정보 설정[필수][HostIp, Port, PagePath]
 					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

 					//전체Merge 종류 [선택, Default msNone]
 					MergeSheet = msHeaderOnly;

 					//전체Edit 허용 여부 [선택, Default false]
 					Editable = true;

 					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 					InitRowInfo(1, 1, 15, 100);

 					var HeadTitle1 = "|Sel|Seq.|SML Code|Customer's Code|Remark(s)|sc_no|rfa_no|cprt_conv_tp_cd";
 					var headCount = ComCountHeadTitle(HeadTitle1);
 										
 					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 					InitColumnInfo(headCount, 0, 0, true);

 					// 해더에서 처리할 수 있는 각종 기능을 설정한다
 					InitHeadMode(true, true, true, true, false,false);

 					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 					InitHeadRow(0, HeadTitle1, true);

 					//데이터속성   [ROW, COL,	DATATYPE,		WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,	KEYFIELD,	CALCULOGIC,		DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daCenter,   false,  "ibflag");
					InitDataProperty(0, cnt++, dtDummyCheck, 	40,		daCenter, 	false,	"DelChk");
 					InitDataProperty(0, cnt++ , dtSeq,			40,		daCenter,	true,		"seq",					false,		"",				dfNone,		0,			true,		true);
 					InitDataProperty(0, cnt++ , dtData,			250,	daCenter,	true,		"hjs_cd_ctnt",			true,      "",				dfNone,		0,			true,		true,	20);
 					InitDataProperty(0, cnt++ , dtData,			300,	daCenter,	true,		"cust_conv_cd_ctnt",			true,      "",				dfNone,		0,			true,		true,	20);
 					InitDataProperty(0, cnt++ , dtData,			0,		daCenter,	true,		"cd_rmk",				false,		"",				dfNone,		0,			true,		true,	100);
 					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		"sc_no",				false,		"",				dfNone,		0,			true,		true);
 					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		"rfa_no",				false,		"",				dfNone,		0,			true,		true);
 					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		"cprt_conv_tp_cd",		false,		"",				dfNone,		0,			true,		true);
 					
 					InitDataValid(0, "hjs_cd_ctnt",   	vtEngUpOther, "0123456789");
 					InitDataValid(0, "cust_conv_cd_ctnt",   	vtEngUpOther, "0123456789");
 					
 					//CountPosition = 0;
 				}
                 break;
         }
     }

     /** 
      * 조회 저장등 서버 기능을 호출하는 doActionIBSheet <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  {IBSheet} sheetObj : 시트오브젝트  
      * @param  {object} formObj : 폼 오브젝트
      * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
      * @param  {int} Row : sheet에서 현재 마우스로 선택되어 있는 Row
      * @param  {int} Col : sheet에서 현재 마우스로 선택되어 있는 Col
      * @param  {String}Val : sheet에서 현재 마우스로 선택되어 있는 Row,Col 의 value값
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
     function doActionIBSheet(sheetObj,formObj,sAction, Row, Col, Val) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {         
         	case IBSEARCH_ASYNC01:      //조회		         		
				var Val = formObj.sc_no2.value;
				if(Val != ""){
					formObj.sc_no.value = Val;
					formObj.rfa_no.value = "X";
					formObj.f_cmd.value = SEARCH01;					
					var sXml = sheetObj.GetSearchXml("FNS_INV_0102GS.do", FormQueryString(formObj));
					
					var arrXml = sXml.split("|$$|");
					var dataVal = ComGetEtcData(arrXml[0],"customerName");
					
					if(dataVal == ""){          											
						ComShowCodeMessage("INV00041","["+Val+"]");
						formObj.sc_nm.value = "";
						formObj.sc_no2.value = "";
						ComSetFocus(formObj.sc_no2);
						return;
					}else{
						formObj.sc_nm.value = dataVal;
						doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
					}
				}	
            break; 
         	case IBSEARCH_ASYNC02:      //조회	
         		var Val = formObj.rfa_no2.value;
				if(Val != ""){
					formObj.rfa_no.value = Val;
					formObj.sc_no.value = "X";
					formObj.f_cmd.value = SEARCH01;					
					var sXml = sheetObj.GetSearchXml("FNS_INV_0102GS.do", FormQueryString(formObj));
					
					var arrXml = sXml.split("|$$|");
					var dataVal = ComGetEtcData(arrXml[0],"customerName");
					
					if(dataVal == ""){          											
						ComShowCodeMessage("INV00041","["+Val+"]");
						formObj.rfa_nm.value = "";
						formObj.rfa_no2.value = "";
						ComSetFocus(formObj.rfa_no2);						
					}else{
						formObj.rfa_nm.value = dataVal;
						doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
					}
				}
            break;
         	case IBSEARCH_ASYNC04:      //조회	
         		var Val = formObj.copy_text.value;
				if(Val != ""){					
					formObj.f_cmd.value = SEARCH03;					
					var sXml = sheetObj.GetSearchXml("FNS_INV_0102GS.do", FormQueryString(formObj));
					
					var arrXml = sXml.split("|$$|");
					var dataVal = ComGetEtcData(arrXml[0],"customerName");
					
					if(dataVal == ""){
						ComShowCodeMessage("INV00041","["+Val+"]");
						formObj.copy_text.value = "";
						ComSetFocus(formObj.copy_text);						
					}else{

					}
				}
            break;
 			case IBSEARCH:      //조회
 				if(validateForm(sheetObj,formObj,sAction) == false) return false;
				formObj.f_cmd.value = SEARCH;
				
				formObj.sc_no.value = formObj.sc_no2.value;
				formObj.rfa_no.value = formObj.rfa_no2.value;
				
				if(formObj.sc_no.value == "") formObj.sc_no.value = "X";
				if(formObj.rfa_no.value == "") formObj.rfa_no.value = "X";
				
				sheetObj.DoSearch("FNS_INV_0102GS.do", FormQueryString(formObj));								
				
				for (var i=1; i<=sheetObj.RowCount; i++) {
					sheetObj.CellEditable(i,'hjs_cd_ctnt') = false;
				}
				
 			break;
 			case IBSEARCH_ASYNC03:      //조회	
				if(Val != ""){
					formObj.f_cmd.value = SEARCH02;
					var sXml = sheetObj.GetSearchXml("FNS_INV_0102GS.do", FormQueryString(formObj));
					
					var arrXml = sXml.split("|$$|");
					var dataVal = ComGetEtcData(arrXml[0],"hjsCode");
					if(dataVal == ""){
						ComShowCodeMessage("INV00041","["+Val+"]");	
						sheetObj.SelectCell(Row, Col);
					}
				}
            break;   
 			case IBSAVE:        //저장
 				if(!validateForm(sheetObj,formObj,sAction)) return;
				if(sheetObj.RowCount == 0) return;
				formObj.f_cmd.value = MULTI;
				//var result = sheetObj.DoSave("FNS_INV_0020GS.do", FormQueryString(formObj));
				//return;
				var sParam = ComGetSaveString(sheetObjects);
				if (sParam == "") return; 

                sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
				var SaveXml = sheetObj.GetSaveXml("FNS_INV_0102GS.do", sParam );
				sheetObj.LoadSaveXml(SaveXml);
				if (SaveXml.indexOf(">OK<") > -1){
					for (var i=1; i<=sheetObj.RowCount; i++) {
						sheetObj.CellEditable(i,'hjs_cd_ctnt') = false;
					}
				}
 			break;

 			case IBINSERT:      // 입력
 				var sheetIdx = sheetObj.DataInsert(-1);
				sheetObj.CellText(sheetIdx,"sc_no") = formObj.sc_no.value;
				sheetObj.CellText(sheetIdx,"rfa_no") = formObj.rfa_no.value;
				sheetObj.CellText(sheetIdx,"cprt_conv_tp_cd") = formObj.cdTp.value;
 			break;
 			case IBSEARCH_ASYNC05:      // 복사
 				if(!validateForm(sheetObj,formObj,sAction)) return;
 				if(sheetObj.RowCount == 0) return; 				
 				
				var sParam = ComGetSaveString(sheetObjects);
				if (sheetObj.IsDataModified && sParam == "") return; 
				
				formObj.f_cmd.value = MULTI01;
				
				var copy_sc_no = formObj.copy_text.value;
				var copy_rfa_no = formObj.copy_text.value;
				if(formObj.copy_gb[0].checked != true){
					copy_sc_no = "X";
				}
				if(formObj.copy_gb[1].checked != true){
					copy_rfa_no = "X";
				}
				
				for (var i=1; i<=sheetObj.RowCount; i++) {
					sheetObj.CellText(i,"sc_no") = copy_sc_no;
					sheetObj.CellText(i,"rfa_no") = copy_rfa_no;
					sheetObj.CellText(i,"cprt_conv_tp_cd") = formObj.cdTp.value;
				}				
				
                //sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
				//var SaveXml = sheetObj.GetSaveXml("FNS_INV_0102GS.do", sParam );
				var params = FormQueryString(formObj);	
				params = params + "&" + ComSetPrifix(sheetObj.GetSaveString(true),"sheet1_");
				var SaveXml = sheetObj.GetSaveXml("FNS_INV_0102GS.do", params );
				sheetObj.LoadSaveXml(SaveXml);
				if (SaveXml.indexOf(">OK<") > -1){
					doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
					formObj.copy_text.value = "";
				}
 	 		break;
         }
     }

     /** 
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리하는 validateForm <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  {IBSheet} sheetObj : 시트오브젝트  
      * @param  {object} formObj : 폼 오브젝트
      * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
      * @return true, false
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
     function validateForm(sheetObj,formObj,sAction){
    	 switch (sAction) {
 			case IBDELETE:
	 			if (sheetObj.CheckedRows("DelChk") == 0) {
	 				ComShowMessage(msgs["INV00025"]);
	 				return false;
	 			} else if (sheetObj.CheckedRows("DelChk") > 0) {
	 				if(!ComShowCodeConfirm("INV00028")) return;
	 			}
	 			break;
 			case IBSEARCH:
 				if (ComIsNull(formObj.sc_no2) && ComIsNull(formObj.rfa_no2)) {
	         		ComShowCodeMessage('INV00004');
    				ComSetFocus(form.sc_no2);
	 				return false;
	 			}
 				/*
 				if (formObj.sc_no2.value == "" || formObj.rfa_no2.value =="") {
	         		ComShowCodeMessage('INV00004');
    				ComSetFocus(form.sc_no2);
	 				return false;
	 			}*/
 				break;
 			case IBSAVE:
 				
 				break;
 				
     	}
         return true;
     }
     
     /** 
      * 업무 자바스크립트 OnFocusOut 이벤트 처리 <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */ 
     function obj_focusout() {
 		var sheetObject = sheetObjects[0];
 		var formObject = document.form;
 		switch(event.srcElement.name){
 			case "sc_no2":
 				doActionIBSheet(sheetObjects[0],formObject,IBSEARCH_ASYNC01);
 			break;
 			case "rfa_no2":
 				doActionIBSheet(sheetObjects[0],formObject,IBSEARCH_ASYNC02);
 			break;
 			case "copy_text": 			
 				doActionIBSheet(sheetObjects[0],formObject,IBSEARCH_ASYNC04);
 				/*
 				if(formObject.copy_gb[0].checked == true){
 					doActionIBSheet(sheetObjects[0],formObject,IBSEARCH_ASYNC04);
 				}
 				if(formObject.copy_gb[1].checked == true){
 					doActionIBSheet(sheetObjects[0],formObject,IBSEARCH_ASYNC05);
 				}*/
 			break; 			
 	    }
	}
     
     /** 
      * 업무 자바스크립트 OnKeyUp 이벤트 처리 <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */ 
     function obj_keyup() {
 		var sheetObject = sheetObjects[0];
 		var formObject = document.form;
 		switch(event.srcElement.name){
 			case "sc_no2":
 				if(formObject.sc_no2.value == "") {
 					formObject.sc_nm.value = "";
 				}
 			break;
 			case "rfa_no2":
 				if(formObject.rfa_no2.value == "") {
 					formObject.rfa_nm.value = "";
 				}
 			break;
 		}	
	}
 	
     /** 
      * 업무 자바스크립트 OnChange 이벤트 처리 <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  {object} obj : 폼 오브젝트
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */ 
 	function text_onChange(obj){
 		/*
 		var formObject = document.form;
 		switch(obj.name){
 			case "sc_no2":
				doActionIBSheet(sheetObjects[0],formObject,IBSEARCH_ASYNC01);
			break;
			case "rfa_no2":
				doActionIBSheet(sheetObjects[0],formObject,IBSEARCH_ASYNC02);
			break;
			case "copy_text":
				
			break; 			
	    }
	    */
 	}
 	
 	/** 
     * 업무 자바스크립트 Sheet의 OnSelectCell 이벤트 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : 시트오브젝트  
     * @param  {int} OldRow : 포커스가 이동하기 전에 위치해 있는 sheet의 Row
     * @param  {int} OldCol : 포커스가 이동하기 전에 위치해 있는 sheet의 Col
     * @param  {int} NewRow : 포커스가 이동한 후에 위치해 있는 sheet의 Row
     * @param  {int} NewCol : 포커스가 이동한 후에 위치해 있는 sheet의 Col
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */
 	function sheet1_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol){
  		var Val = sheetObj.CellText(OldRow,OldCol);
  		sheet1_OnChange_event(sheetObj,OldRow,OldCol, Val);
  	}  
 	
 	/** 
     * 업무 자바스크립트 Sheet의 OnChange 이벤트 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : 시트오브젝트 
     * @param  {int} Row : 포커스가 위치해 있는 sheet의 Row
     * @param  {int} Col : 포커스가 위치해 있는 sheet의 Col 
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */
 	function sheet1_OnChange(sheetObj, Row, Col){
  		var Val = sheetObj.CellText(Row,Col);
		sheet1_OnChange_event(sheetObj,Row,Col, Val);
  	}
 	
 	/** 
     * 업무 자바스크립트 Sheet의 OnChange 이벤트에서 호출하는 함수<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : 시트오브젝트 
     * @param  {int} Row : 포커스가 위치해 있는 sheet의 Row
     * @param  {int} Col : 포커스가 위치해 있는 sheet의 Col 
     * @param  {int} Val : 포커스가 위치해 있는 sheet의 Row,Col의 value값
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */
 	function sheet1_OnChange_event(sheetObj,Row,Col, Val){
 		if(sheetObj.CellEditable(Row, Col) == false) return; 
 		if (sheetObj.ColSaveName(Col) == "hjs_cd_ctnt") {
 			document.form.cd.value = Val;
  			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC03, Row, Col, Val);
  		}
 	}
    
 	/** 
     * excel load 후, 기본 값 세팅<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : 시트오브젝트 
     * @param  {object} formObj : 폼 오브젝트
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */
 	function copy_end(sheetObj,formObj){
 		for (var i=1; i<=sheetObj.RowCount; i++) {
 			sheetObj.CellText(i,"sc_no") = formObj.sc_no.value;
			sheetObj.CellText(i,"rfa_no") = formObj.rfa_no.value;
			sheetObj.CellText(i,"cprt_conv_tp_cd") = formObj.cdTp.value;
		}
 	}
	/* 개발자 작업  끝 */