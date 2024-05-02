/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESD_SPE_1007.js
*@FileTitle : EG vs Evaluator Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
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
     * @class ESD_SPE_1007 : ESD_SPE_1007 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_SPE_1007() {
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
    
	//공통전역변수
    var frm = null;
    var searchFlag = "0";
    var rhqXml = null;
    var ofcXml = null;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	// Combo Object Array
	var comboObjects = new Array();
	var comboCnt = 0;	
	

	    
	 /**
	  * IBSheet Object를 배열로 등록
	  * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	  * 배열은 소스 상단에 정의
	  */
	 function setSheetObject(sheet_obj){
	    sheetObjects[sheetCnt++] = sheet_obj;
	 }    	    
	 
	 /**
      * IBMultiCombo Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setComboObject(combo_obj) {
    	 comboObjects[comboCnt++] = combo_obj;
     }
     
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;    

	 
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	 function processButtonClick() {
	 	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	 	var sheetObj    = sheetObjects[0];

	 	/*******************************************************/
	 
	 	try {
	 		var srcName = window.event.srcElement.getAttribute("name");
	 		switch (srcName) {

	 			case "btn_retrieve":
	 				// IBSHEET 조회
	 				doActionIBSheet(sheetObjects[0], frm, IBSEARCH);	 				
//	 				if(validateForm(sheetObjects[0],frm,srcName)){
//	 				}
	 				break;
	 	

	 				
	 			case "btn_save":
 					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
	 				break;
	 				
	 			case "btn_RowAdd":
	 				doActionIBSheet(sheetObjects[0],document.form,IBCOPYROW);
	 				break;
	 				
	 			case "btn_RowDel":
	 				
	 				if(sheetObjects[1].FindCheckedRow("chk") == ""){

	 				}else if(ComShowCodeConfirm("COM12171","")){
	 					doActionIBSheet(sheetObjects[1], frm, IBDELETE);
	 				}	 				
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
	 * body 태그의 onLoad 이벤트핸들러 구현 <br>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br> 
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  없음
	 * @return 없음
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function loadPage() {
		frm = document.form;
	    for(i=0;i<sheetObjects.length;i++){
			 //-시작 환경 설정 함수 이름 변경
			 ComConfigSheet(sheetObjects[i]);
			 initSheet(sheetObjects[i],i+1);
			 //-마지막 환경 설정 함수 추가
			 ComEndConfigSheet(sheetObjects[i]);
		 }
	    
	     // combo 생성
	     doActionIBCombo(frm.s_eg_rhq_cd); // Level1
	     doActionIBCombo(frm.s_ev_svc_cate_cd); // Level3
	     //IBMultiCombo 설정
         for(var k = 0; k < comboObjects.length; k++){
       	  	 initCombo(comboObjects[k], k + 1);
         }
         initControl();
	}



 	function initControl() {
 		axon_event.addListener ('keydown', 'keydownEnter', 'form');
	}    
 	
 	 /**
 	  * HTML Control KeyDown 이벤트 호출
 	  */
 	 function keydownEnter() {
 	 	if (event.keyCode != 13) {
 	 		return;
 	 	}
 	 	doActionIBSheet(sheetObjects[0], frm, IBSEARCH);
 	 } 
 	
 	
    /**
     * Combo 기본 설정 
     * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
     * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
     */ 
    function initCombo(comboObj, comboNo) {
    	comboObj.ValidChar(2,0);
    	comboObj.UseAutoComplete = true;       	
    	 switch(comboObj.id) {
   	  		case "s_eg_rhq_cd":
        		comboObj.DropHeight = 250;
  			break;  
   	  		case "s_eg_ofc_cd":
   	  			comboObj.DropHeight = 250;
   	  			break;  
   	  		case "s_ev_svc_cate_cd":
   	  			comboObj.Index=0;
   	  			comboObj.DropHeight = 300;
   	  			break;  
   	  	}
    	
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
					// 높이 설정
					style.height = GetSheetHeight(7);
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				    //전체Edit 허용 여부 [선택, Default false]
				    Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 10, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(10, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false) ;

					var HeadTitle1 = "ibflag|EG ID|EG Name|Basic Evaluator ID|Basic Evaluator|ISINPUT";
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					HeadRowHeight = 12;
					//데이터속성    [ROW,   COL,  DATATYPE,    WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,            KEYFIELD, CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0,	cnt++,	dtHiddenStatus,	50,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtData,         80,  	daCenter,   true,   "eg_id",         	    false,   "",      dfNone,          0,          false,        false,  10);
					InitDataProperty(0, cnt++ , dtData,         120,  	daCenter,   true,   "eg_nm",                false,   "",      dfNone,          0,          false,        false,  10);
					InitDataProperty(0, cnt++ , dtPopupEdit,    170,  	daCenter,   true,   "bzc_evr_usr_id",      	false,    "",      dfNone,          0,          true,         true,   10);
					InitDataProperty(0, cnt++ , dtData,         170,  	daLeft,     true,   "bzc_evr_usr_nm",       false,    "",      dfNone,          0,          false,        false,  10);
					InitDataProperty(0, cnt++ , dtHidden,       170,  	daCenter,   true,   "per_evr_usr_id",       false,    "",      dfNone,          0,          true,         true,   10);
					InitDataProperty(0, cnt++ , dtHidden,       170,  	daLeft,     true,   "per_evr_usr_nm",       false,    "",      dfNone,          0,          false,        false,  10);					
					InitDataProperty(0, cnt++ , dtHidden,       100,  	daLeft,     true,   "ev_knd_seq",           false,   "",      dfNone,          0,          false,        false,  10);
					InitDataProperty(0, cnt++ , dtHidden,       100,  	daLeft,     true,   "ev_knd_cd",            false,   "",      dfNone,          0,          false,        false,  10);
					InitDataProperty(0, cnt++ , dtHidden,       100,  	daLeft,     true,   "isinput",              false,   "",      dfNone,          0,          false,        false,  10);
					
//					InitDataValid(0, "bzc_evr_usr_id"  , vtNumericOnly);
					
				}
				break;
	    	case 2:      //sheet2 init
		    	with (sheetObj) {
				// 높이 설정
				style.height = GetSheetHeight(10);
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			    //전체Edit 허용 여부 [선택, Default false]
			    Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 10, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(10, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false) ;

				var HeadTitle1 = "ibflag|EG ID|EG Name|Performance Evaluator ID|Performance Evaluator|Performance Evaluator ID|Performance Evaluator|ISINPUT";
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				HeadRowHeight = 12;
				//데이터속성    [ROW,   COL,  DATATYPE,    WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,            KEYFIELD, CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0,	cnt++,	dtHiddenStatus,	50,		daCenter,	false,	"ibflag");
				InitDataProperty(0, cnt++ , dtData,         80,  	daCenter,   true,   "eg_id",         	    false,   "",      dfNone,          0,          false,        false,  10);
				InitDataProperty(0, cnt++ , dtData,         120,  	daCenter,   true,   "eg_nm",                false,   "",      dfNone,          0,          false,        false,  10);
				InitDataProperty(0, cnt++ , dtHidden,       170,  	daCenter,   true,   "bzc_evr_usr_id",      	false,    "",      dfNone,          0,          true,         true,   10);
				InitDataProperty(0, cnt++ , dtHidden,       170,  	daLeft,     true,   "bzc_evr_usr_nm",       false,    "",      dfNone,          0,          false,        false,  10);
				InitDataProperty(0, cnt++ , dtPopupEdit,    170,  	daCenter,   true,   "per_evr_usr_id",       false,    "",      dfNone,          0,          true,         true,   10);
				InitDataProperty(0, cnt++ , dtData,         170,  	daLeft,     true,   "per_evr_usr_nm",       false,    "",      dfNone,          0,          false,        false,  10);
				InitDataProperty(0, cnt++ , dtHidden,       100,  	daLeft,     true,   "ev_knd_seq",           false,   "",      dfNone,          0,          false,        false,  10);
				InitDataProperty(0, cnt++ , dtHidden,       100,  	daLeft,     true,   "ev_knd_cd",            false,   "",      dfNone,          0,          false,        false,  10);
				InitDataProperty(0, cnt++ , dtHidden,       100,  	daLeft,     true,   "isinput",              false,   "",      dfNone,          0,          false,        false,  10);
				
//				InitDataValid(0, "bzc_evr_usr_id"  , vtNumericOnly);
				
			    }
	    		break;				
	    	case 3:      //sheet3 init
	    		with (sheetObj) {
	    		// 높이 설정
	    		style.height = 0;
	    		//전체 너비 설정
	    		SheetWidth = mainTable.clientWidth;
	    		
	    		//Host정보 설정[필수][HostIp, Port, PagePath]
	    		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	    		
	    		//전체Merge 종류 [선택, Default msNone]
	    		MergeSheet = msHeaderOnly;
	    		
	    		//전체Edit 허용 여부 [선택, Default false]
	    		Editable = true;
	    		
	    		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	    		InitRowInfo(1, 1, 10, 100);
	    		
	    		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	    		InitColumnInfo(2, 0, 0, true);
	    		
	    		// 해더에서 처리할 수 있는 각종 기능을 설정한다
	    		InitHeadMode(true, true, true, true, false,false) ;
	    		
	    		var HeadTitle1 = "ibflag|";
	    		
	    		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	    		InitHeadRow(0, HeadTitle1, true);
	    		
	    		HeadRowHeight = 12;
	    		//데이터속성    [ROW,   COL,  DATATYPE,    WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,            KEYFIELD, CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	    		InitDataProperty(0,	cnt++,	dtHiddenStatus,	50,		daCenter,	false,	"ibflag");
	    		InitDataProperty(0,	cnt++,	dtCheckBox,	    30,		daCenter,	false,	"chk");
	    		
	    	}
	    		break;				

			}
		}	
	 

	//SHEET 관련 프로세스 처리
	function doActionIBSheet(sheetObj, frm, sAction) {
		sheetObj.ShowDebugMsg = false;
		
		switch (sAction) {

			// SEARCH LOGIC
			case IBSEARCH:
				sheetObj.ShowDebugMsg = false;
				if(validateForm(sheetObj,frm,sAction)){
					searchFlag="1";
					sheetObjects[0].RemoveAll();
					sheetObjects[1].RemoveAll();
					frm.f_cmd.value = SEARCH01;
					var sParam = FormQueryString(frm);
					var sXml = sheetObj.GetSearchXml("ESD_SPE_1006GS.do", sParam);
					sheetObj.loadSearchXml(sXml);
					
				}
				break;
			case IBSEARCH02:
				sheetObj.ShowDebugMsg = false;
				if(validateForm(sheetObj,frm,sAction)){
					sheetObjects[1].RemoveAll();
					frm.f_cmd.value = SEARCH02;
					frm.eg_id.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"eg_id") ;
					var sParam = FormQueryString(frm);
					var sXml = sheetObj.GetSearchXml("ESD_SPE_1006GS.do", sParam);
					if(ComGetTotalRows(sXml)==1 && SpeXmlString(sXml,"per_evr_usr_id")==""){
						sheetObj.loadSearchXml("<SHEET><DATA TOTAL='0'></DATA></SHEET>");
					}else{
						sheetObj.loadSearchXml(sXml);
					}
					
				}
				break;
		
			// SAVE LOGIC
			case IBSAVE:
				if(!validateForm(sheetObj,frm,sAction)) return false;
				if (!ComShowCodeConfirm("COM130101")) return; // Do you want to save {?msg1}?
				
            	frm.f_cmd.value = MULTI01;
				var sParam = sheetObjects[0].GetSaveString(false, true) + "&" +sheetObjects[1].GetSaveString(false, true) + "&" + FormQueryString(frm);
			        var sXml = sheetObjects[0].GetSaveXml("ESD_SPE_1006GS.do", sParam);
					var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
					if (State != "S") {
						ComShowCodeMessage('COM130103', 'Data');
						return false;
					} else if (State == "S") {
						ComShowCodeMessage('COM130102', 'Data');
						if(sheetObjects[0].GetSaveString(false, true)!=""){
							doActionIBSheet(sheetObjects[0], frm, IBSEARCH);
						}else if(sheetObjects[1].GetSaveString(false, true)!=""){
							doActionIBSheet(sheetObjects[1], frm, IBSEARCH02);
						}
							
					}
					
		    				
				break;
			case IBDELETE :
	   	   		if(sheetObj.FindCheckedRow("chk") != ""){
					ComRowHideDelete(sheetObj,"chk"); 
				}
			    break;
			case "btn_downexcel":	// EXCEL DOWNLOAD
				sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "", "");
				break;
				
			case IBCOPYROW:	// Copy Row
				if (searchFlag=="0" && sheetObjects[0].RowCount == 0) {
					ComShowCodeMessage('SPE10008', ''); //조회후 추가하세요
					return false;
				}
				if (searchFlag=="1" && sheetObjects[0].RowCount == 0) {
					ComShowCodeMessage('SPE10002', 'EG ID'); //선택된 EG ID 가 없습니다
					return false;
				}
				if (sheetObjects[1].RowCount == 0) {
					ComShowCodeMessage('SPE10009', 'Evaluator'); //Basic Evaluator 를 먼저 저장하셔야합니다.
					return false;
				}
				var Row = sheetObjects[1].DataCopy();
				sheetObjects[1].CellValue2(Row, 'bzc_evr_usr_id')    = "" ;
				sheetObjects[1].CellValue2(Row, 'bzc_evr_usr_nm')    = "" ;
				sheetObjects[1].CellValue2(Row, 'per_evr_usr_id')    = "" ;
				sheetObjects[1].CellValue2(Row, 'per_evr_usr_nm')    = "" ;
				break;				
		}
	}


    // Combo관련 프로세스 처리
    function doActionIBCombo(comboObj) {
    	var sheetObj = sheetObjects[2];
        switch(comboObj.id) {
	    case "s_eg_rhq_cd":  
//	        frm.f_cmd.value = COMMAND01;
//
//	        rhqXml = sheetObj.GetSearchXml("ESD_SPE_COMGS.do", FormQueryString(frm));
//	        frm.s_eg_rhq_cd.RemoveAll();
//	    	ComXml2ComboItem(rhqXml, frm.s_eg_rhq_cd, "eg_ofc_cd", "eg_ofc_cd");
	    	
	    	rhqXml = search03CommonCombo("CD03373",frm.s_eg_rhq_cd,sheetObj);
	    	comboObj.InsertItem(0, "", "");
//	    	frm.s_eg_rhq_cd.Index=0;
	    	doActionIBCombo(frm.s_eg_ofc_cd)
	    	break;  
	    case "s_eg_ofc_cd":  
	    	frm.f_cmd.value = COMMAND02;
	        // eg_rhq_cd 에 값이 있으면 GRID office 값이 변경이 된다.
	        frm.eg_rhq_cd.value = "";	    	
	    	var sXml = sheetObj.GetSearchXml("ESD_SPE_COMGS.do", FormQueryString(frm));
	    	frm.s_eg_ofc_cd.RemoveAll();
	    
	    	ComXml2ComboItem(sXml, frm.s_eg_ofc_cd, "eg_ofc_cd", "eg_ofc_cd");
	    	comboObj.InsertItem(0, "", "");
//	    	frm.s_eg_ofc_cd.Index=0;
	    	break;  
	  	case "s_ev_svc_cate_cd":  
	  		searchCommonCombo("CD03377",frm.s_ev_svc_cate_cd,sheetObj);
	  		comboObj.InsertItem(0, "", "");
			break;  	    	

        }
    }

	 
	 /**
	  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	  */
	  function validateForm(sheetObj,frm,sAction){
	 	 switch(sAction) {
	 	 case IBSEARCH :
	 		 if(frm.s_eg_rhq_cd.Code  == ""){
	 			 ComShowCodeMessage('COM130201', 'Level 1'); //Level 1 값을 입력하셔야 합니다
	 			 return false;
	 		 }
//	 		 if(frm.s_eg_ofc_cd.Code  == ""){
//	 			 ComShowCodeMessage('COM130201', 'Level 2'); //Level 2 값을 입력하셔야 합니다
//	 			 return false;
//	 		 }
//	 		 if(frm.s_ev_svc_cate_cd.Code  == ""){
//	 			 ComShowCodeMessage('COM130201', 'Level 3'); //Level 3 값을 입력하셔야 합니다
//	 			 return false;
//	 		 }
	 		 break;
	 	 case IBSAVE :
			if(sheetObjects[0].RowCount<1){
				ComShowCodeMessage('COM130201', 'Basic Evaluator Grid'); //Grid 값을 입력하셔야 합니다
				return false;
			}
//			if(sheetObjects[1].RowCount<1){
//				ComShowCodeMessage('COM130201', 'Performance Evaluator Grid'); //Grid 값을 입력하셔야 합니다
//				return false;
//			}
         	if(sheetObjects[0].GetSaveString(false, true)=="" && sheetObjects[1].GetSaveString(false, true)==""){
        		return false;
        	}
	 		 break;	 		 
	 	 } // end switch()
	 	 return true;
	  }	 

      //업무 자바스크립트 OnKeyPress 이벤트 처리
      function keypressFormat() {
      	obj = event.srcElement;
    	    if(obj.dataformat == null) return;
    	    window.defaultStatus = obj.dataformat;
    	    switch(obj.dataformat) {
    	        case "engup":
    	        	ComKeyOnlyAlphabet('upper');
    	            break;
    	            
    	        case "number":
    	        	ComKeyOnlyNumber(obj);
    	            break;
    	    }
      }	  
	  
	  function s_eg_rhq_cd_OnChange(comboObj,Index_Code, Text){   
		doActionIBCombo(frm.s_eg_ofc_cd); // RHQ

	  }
	  
	  /**
	  * Sheet1 의 OnSearchEnd 이벤트처리 <br>
	  * @param  {object} sheetObj	필수	 Sheet Object
	  * @param  {string} ErrMsg		필수 String
	  */ 
	  function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	  	  with(sheetObj){
		  		if(Rowcount==0){
			  		ComShowCodeMessage('SPE10002', 'EG ID'); //EG ID 가 존재하지 않습니다.
			  		return;
			    }
   				if(CellValue(1,'bzc_evr_usr_id')!=""){
	   				 
   					doActionIBSheet(sheetObjects[1], frm, IBSEARCH02);
	   			}
	   	  }
	  } 
	    
	  
	  /**
	   * Sheet2 의 OnSearchEnd 이벤트처리 <br>
	   * @param  {object} sheetObj	필수	 Sheet Object
	   * @param  {string} ErrMsg		필수 String
	   * @return 없음
	   */ 
	  function sheet2_OnSearchEnd(sheetObj, ErrMsg){
		  with(sheetObj){
			  for(var i=1; i<= rowcount; i++){
				  if(cellValue(i,'per_evr_usr_id')==""){
					  // per_evr_usr_id null 이면 저장하지 않은 데이터여서 상태값을 입력으로 변경한다.
					  sheetObj.RowStatus(i)="I";
				  }
			  }
		  }
	  } 
	  
	  
      /**
      * sheet1 OnChange 이벤트
      * @param {ibsheet} sheet 해당 시트   
      * @param {long} row 해당 셀의 Row Index
      * @param {long} col 해당 셀의 Column Index
      * @param {string} value 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
      */
	  function sheet1_OnChange(sheetObj,Row, Col, Value) {
		  switch(Col){
		    case sheetObj.SaveNameCol("bzc_evr_usr_id") :
		    	bzcEvrUsrId_change(sheetObj,Row, Col, Value)
		    	break;
		  
		  }
		  
	  }
	  
	  
	  /**
	   * sheet2 OnChange 이벤트
	   * @param {ibsheet} sheet 해당 시트   
	   * @param {long} row 해당 셀의 Row Index
	   * @param {long} col 해당 셀의 Column Index
	   * @param {string} value 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
	   */
	  function sheet2_OnChange(sheetObj,Row, Col, Value) {
		  switch(Col){
		  case sheetObj.SaveNameCol("per_evr_usr_id") :
			  perEvrUsrId_change(sheetObj,Row, Col, Value)
			  break;
		  
		  }
		  
	  }
	  
		
		/**
		 * 사용자가 입력한 Basic Evaluator ID(USER_ID) 가 존재하는 값인지 조회한다..
		 */
		function  bzcEvrUsrId_change(sheetObj, row, col ,value){
			
			
			if(value ==""){
				return;
			}
			if(sheetObj.CellValue(row,"isinput") =="I"){
				sheetObjects[1].RemoveAll()
			}
			frm.f_cmd.value = COMMAND05;
			frm.usr_id.value = value;
			var sXml=sheetObjects[0].GetSearchXml("ESD_SPE_COMGS.do", FormQueryString(frm));
			var usr_id = SpeXmlString(sXml,"usr_id");
			var usr_nm = SpeXmlString(sXml,"usr_nm");
			if(usr_id==""){
				ComShowCodeMessage('COM132202', 'Basic Evaluator ID'); //사용할수 없는 Control Office 
				sheetObj.CellValue2(row,"bzc_evr_usr_id") = "";
			}else{
				sheetObj.CellValue2(row,"bzc_evr_usr_id") = usr_id;
				sheetObj.CellValue2(row,"bzc_evr_usr_nm") = usr_nm;
			}
		}
		
		/**
		 * 사용자가 입력한 Performance Evaluator ID(USER_ID) 가 존재하는 값인지 조회한다..
		 */
		function  perEvrUsrId_change(sheetObj, row, col ,value){
			
			if(value ==""){
				return;
			}
			sheetObj.SpaceDupCheck = false;
			var dupVal = sheetObj.ColValueDup("eg_id|per_evr_usr_id", false)
			if(dupVal> 0){
				if(sheetObj.CellValue(dupVal,"per_evr_usr_id")!=""){
					ComShowCodeMessage('COM12115','Performance Evaluator ID');
					sheetObj.CellValue2(row,"per_evr_usr_id")="";
					sheetObj.CellValue2(row,"bzc_evr_usr_nm")="";
					return;
				}
			}
			
			frm.f_cmd.value = COMMAND05;
			frm.usr_id.value = value;
			var sXml=sheetObjects[0].GetSearchXml("ESD_SPE_COMGS.do", FormQueryString(frm));
			var usr_id = SpeXmlString(sXml,"usr_id");
			var usr_nm = SpeXmlString(sXml,"usr_nm");
			if(usr_id==""){
				ComShowCodeMessage('COM132202', 'Performance Evaluator ID'); //사용할수 없는 Control Office 
				sheetObj.CellValue2(row,"per_evr_usr_id") = "";
			}else{
				sheetObj.CellValue2(row,"per_evr_usr_id") = usr_id;
				sheetObj.CellValue2(row,"per_evr_usr_nm") = usr_nm;
			}
		}
		
		
		/**
	 	 * sheet1의 OnPopupClick Event 처리부분.<br>
	 	 * @param sheetObj
	 	 * 
	 	 * @param Row
	 	 * @param Col
	 	 */
	    function sheet1_OnPopupClick(sheetObj,Row,Col) {
	 		with(sheetObj) {
				var sName = ColSaveName(Col);
				switch(sName) {
					case "bzc_evr_usr_id":		//Basic Evaluator ID Pop-up
						    var v_ofc_cd = frm.s_eg_rhq_cd.Code
							ComOpenPopup("/hanjin/COM_ENS_091.do?ofc_cd="+ v_ofc_cd, 770, 580, 'setPopupParam', '1,0,1,1,1', true, false, Row, Col, 0);
							
						break;
				}
	 		}
	    }	  
	    
	    
	    /**
	     * sheet1의 OnPopupClick Event 처리부분.<br>
	     * @param sheetObj
	     * 
	     * @param Row
	     * @param Col
	     */
	    function sheet2_OnPopupClick(sheetObj,Row,Col) {
	    	with(sheetObj) {
	    		var sName = ColSaveName(Col);
	    		switch(sName) {
	    		case "per_evr_usr_id":		//Basic Evaluator ID Pop-up
	    			var v_ofc_cd = frm.s_eg_rhq_cd.Code
	    			ComOpenPopup("/hanjin/COM_ENS_091.do?ofc_cd="+ v_ofc_cd, 770, 580, 'setPopupParam', '1,0,1,1,1', true, false, Row, Col, 1);
	    			
	    			break;
	    		}
	    	}
	    }	  
	    
		/**
		 * popup된 창으로 부터 파라미터를 전달받는 함수
		 * @param aryPopupData
		 * @param Row
		 * @param Col
		 * @param SheetIdx
		 * @return
		 */
		function setPopupParam(aryPopupData, Row, Col, SheetIdx) {
			var str = aryPopupData +"";
			var arr = str.split(',');
			var sheetObj =  sheetObjects[SheetIdx];
		
			sheetObj.CellValue2( Row,   Col ) = arr[4];
			sheetObj.CellValue2( Row, ++Col ) = arr[5];
			
	    }
	  
		function checkUsrId(strid, Row, Col){
			var sheetObj=sheetObjects[0];
			var sCondition = new Array (
					new Array("ComUser",strid,"COMMON") //Regional HQ
			);
			var comboList = MnrComSearchCombo(sheetObj,sCondition);
			for(var i = 0; i < comboList.length;i++)
			{
				if(comboList[i] != null){
					var xmlVal = comboList[i][0].split("|");
					//alert(xmlVal[0] + " ** "+ xmlVal[1]);
					sheetObjects[0].CellValue(Row,  sheetObjects[0].SaveNameCol("usr_nm")) = xmlVal[0];
					sheetObjects[0].CellValue(Row,  sheetObjects[0].SaveNameCol("usr_eml")) = xmlVal[1];
					return true;
				}else{
					ComShowCodeMessage("MNR00005", "USR_ID  ");
					sheetObjects[0].CellValue2(Row,   sheetObjects[0].SaveNameCol("cntc_usr_id") )= "";
					sheetObjects[0].CellValue(Row,   sheetObjects[0].SaveNameCol("usr_nm")) = "";
					sheetObjects[0].CellValue(Row,   sheetObjects[0].SaveNameCol("usr_eml")) = "";
					sheetObjects[0].SelectCell(Row, sheetObjects[0].SaveNameCol("cntc_usr_id"));
					return false;
				}
			}	
		}
		
		
		/**
		* sheet1 doubleClick후 이벤트 
		* @param {ibsheet} sheet 해당 시트   
		* @param {long} row 해당 셀의 Row Index
		* @param {long} col 해당 셀의 Column Index
		*/
		function sheet1_OnDblClick(sheetObj, row, col) {
			if(sheetObj.CellValue(row,"bzc_evr_usr_id") == "") {
				sheetObjects[1].RemoveAll();
			}else{
				doActionIBSheet(sheetObjects[1], frm, IBSEARCH02);	
			}
		}		
		
		
	  

	/* 개발자 작업  끝 */