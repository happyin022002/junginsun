/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_0138.js
*@FileTitle : Inquiry Office
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.24
*@LastModifier : 이연각
*@LastVersion : 1.0
* 2009.11.19 송호진
* 1.0 Creation
*  2007-04-24 Jeon Yun Ju
*  1.0 최초 생성
* =========================================================
* History
* 2008.05.02 임옥영 R200804296327 CSS파일 경로 변경
* 2008.09.05 전성진 CSR No.N200809030003
* 						- 7레벨 추가
* 2009.03.10 임옥영 R200903100006   COA Office Report-Graph 오류
* 2009.11.19 송호진 ALPS FW 전환
* 2010.02.24 이연각 업무처리중 버튼사용 금지 처리
* 2010.09.01 김기종 Ticket ID:CHM-201004982-01 COA Architecture 위배사항 수정
=========================================================
****************************************************************************************
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
     * @class ESM_COA_0138 : ESM_COA_0138 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_COA_0138() {
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
	var loadingMode = false;

	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
	function processButtonClick() {
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch(srcName) {
	
				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
					
				case "btn_downexcel":
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;
							
				case "btn_close":
					window.close();
				break;
					
			} // end switch
		} catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}
	
	/**
	 * Sheet 기본 설정 및 초기화
	 */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		loadingMode = true;
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		// 멀티콤보 처리
        //---------------------------------------------
        for(k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],comboObjects[k].id);
        }
        loadingMode = false;
		btn_retrieve.focus();
	}
	 /**
     * 멀티콤보 항목을 설정한다.
     */
     function initCombo(comboObj, comboId) {
    	 with (comboObj) {
	    	 DropHeight = 300;
	    	 if (comboId == "f_sls_ofc_cd"){
	    		 comboObj.InsertItem(0, 'All' ,'');
	    	 }
	    	 Index = 0;
    	 }
     }	
	/**
	 * 시트 초기설정값, 헤더 정의
	 */
	function initSheet(sheetObj,sheetNo) {
		var formObj = document.form;
	
		switch(sheetNo) {
			case 1:      //sheet1 init
				with (sheetObj) {
					SheetWidth = mainTable.clientWidth;
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					MergeSheet = msHeaderOnly; //msNone;
					Editable = true;
					InitRowInfo(1, 1, 10, 100);
					InitColumnInfo(8, 4, 0, true);
					InitHeadMode(true, true, false, true, false, false);
	
					var HeadTitle = "SEQ|Office CD|HQ|Sub HQ|Area|Sales Office|Sub Office|Sub Office2|";
					InitHeadRow(0, HeadTitle, true);
					
					cnt = 0;
					
					InitDataProperty(0, cnt++, dtSeq,  50, daCenter,   true, "");				
					InitDataProperty(0, cnt++, dtData, 90, daCenter,   true, "ofc_cd",	false, "", dfNone, 0, true,  true);	
					InitDataProperty(0, cnt++, dtData, 90, daCenter,   true, "root2",   false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 90, daCenter,   true, "root3",   false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 90, daCenter,   true, "root4",  	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 90, daCenter,   true, "root5",  	false, "", dfNone, 0, true,  true);
					InitDataProperty(0, cnt++, dtData, 90, daCenter,   true, "root6",  	false, "", dfNone, 0, true,  true);
					InitDataProperty(0, cnt++, dtData, 90, daCenter,   true, "root7",  	false, "", dfNone, 0, true,  true);
													
					//콤보항목설정[ROW, COL, COMBO-TEXT, COMBO-CODE, DEFAULT-TEXT]				
	
					HeadRowHeight = 10;
					CountPosition = 0;
	
					style.height = GetSheetHeight(20) ;
	
				}
				break;
	
		}
	}

	/**
	 * IBSheet Object를 배열로 등록
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	/**
     * IBCombo Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
    }
    
	function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
		with(sheetObj) {
		}
	}
	/**
     * Office Level 변경시 Office combo변경
     */
    function f_rhq_cd_OnChange(obj, code){
    	 if (loadingMode == true) return;  
    	 var formObj = document.form;
         var sheetObj = sheetObjects[0];
         if(obj.Text != ""){
         	formObj.f_cmd.value = SEARCHLIST10;
         	
 			var sXml = sheetObj.GetSearchXml("ESM_COA_0138GS.do", coaFormQueryString(formObj));
 			var arrXml = sXml.split("|$$|");
 			if (arrXml.length > 0)
 			ComXml2ComboItem(arrXml[0], formObj.f_sls_ofc_cd, "code", "code");
 			formObj.f_sls_ofc_cd.InsertItem(0, 'All' ,'');
 			formObj.f_sls_ofc_cd.Index=0;
         }
    }
    
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
	
	
		switch(sAction) {
			case IBCLEAR:          //조회
		        sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = INIT;
				var sXml = sheetObj.GetSearchXml("ESM_COA_0138GS.do", coaFormQueryString(formObj));
				
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], formObj.f_rhq_cd, "code", "name");
				if (arrXml.length > 1)
					ComXml2ComboItem(arrXml[1], formObj.f_sls_ofc_cd, "code", "code");
				
				formObj.f_ofc_cd.value = ComGetEtcData(arrXml[0], "f_ofc_cd"); 
		        formObj.f_ofc_lvl.value = ComGetEtcData(arrXml[0], "f_ofc_lvl"); 
		        
				ComOpenWait(false);
				break	
			case IBSEARCH:      //조회
				if (!validateCond(formObj)) {
					return false;
				}
				// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch4Post("ESM_COA_0138GS.do", coaFormQueryString(formObj, 'param1|param2|param3|param4|param5|param6'));
				ComOpenWait(false);
	//			var xml = sheetObj.GetSearchXml("ESM_COA_138GS.do", FormQueryString(formObj));
	//			formObj.aa.value= xml;
				break;
				
			
			case IBDOWNEXCEL:   //엑셀 다운로드
				sheetObj.SpeedDown2Excel(-1);
				break;			
				
		}
	}
	
	/**
	 * 화면 조회값에 대한 유효성검증 프로세스 처리
	 */
	function validateCond(formObj) {
		with(formObj){
		}
	
		return true;
	}


	/* 개발자 작업  끝 */