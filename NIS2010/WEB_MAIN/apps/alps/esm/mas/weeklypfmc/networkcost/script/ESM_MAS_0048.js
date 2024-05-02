/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_MAS_0048.js
*@FileTitle : Trunk IPC Internal Pricing
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.12
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2010.10.12 이행지
* 1.0 Creation
*=========================================================
* History
* 2010.10.22 이행지 [CHM-201006375-01][MAS] Trunk IPC와 Ocean간 내부거래 신규 추가 
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
     * @class ESM_MAS_0048 : ESM_MAS_0048 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_MAS_0048() {
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
	var sheetObjects = new Array();
	var sheetCnt = 0;

	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	function processButtonClick(){
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
				case "btn_Retrieve":		//조회
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
				case "btn_Save":			//저장
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;
			}
		} catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(ComGetMsg("COM12111", "", ""));
			} else {
				ComShowMessage(e);
			}
		}
	}
	
	function loadPage(){
		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		// Default YYYY-MM
		var nowYear = ComGetNowInfo("yy");
        var nowMon  = ComGetNowInfo("mm");
        if ( nowMon.length == 1 ) nowMon = "0" + nowMon; // 1월 -> 01월로 변환
        var nowYrMon = nowYear + "-" + nowMon;
        
        document.form.f_cost_yrmon.value = nowYrMon;
		
	}
    
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		switch(sheetNo) {
			case 1:		//sheet1 init
				with (sheetObj) {
					style.height = GetSheetHeight(10) ;
					
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;  //msNone; //msHeaderOnly //msPrevColumnMerge;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 9, 100);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(5, 0, 0, true);
					// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
					InitHeadMode(true, true, false, true, false, false);
					var HeadTitle =  "STS|NO.|YRMON|Trade|Unit Cost";
					
					//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					//데이터속성  DataRow, Col, [DataType], [Width], [DataAlign],
					//          [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat],
					//          [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort],
					//          [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
					var cnt = 0;
					InitDataProperty(0, cnt++, dtStatus,  30, daCenter, true,  "ibflag",			false, "", dfNone,    0, false, false);
					InitDataProperty(0, cnt++, dtData,    70, daCenter, true,  "no",				false,  "", dfNone,    0, false, false);
					InitDataProperty(0, cnt++, dtData,    70, daCenter, true,  "cost_yrmon",		true,  "", dfNone,    0, false, false);
					InitDataProperty(0, cnt++, dtData,   70, daCenter, true,  "trd_cd",			true,  "", dfNone,    0, false, false);
					InitDataProperty(0, cnt++, dtData,    70, daCenter, true,  "inter_prc_uc_amt",	false, "", dfNone,    0, true, true);
				}
				break;
		}
	}
	
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	
	function doActionIBSheet(sheetObj,formObj,sAction) {

		sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;	//  업무처리중 버튼사용 금지 처리
		
		switch(sAction) {
			case IBSEARCH:      //조회
				if (!validateCond(formObj)) {
					return false;
				}
				// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCHLIST;
				sheetObj.DoSearch4Post("ESM_MAS_0048GS.do", masFormQueryString(formObj));
				ComOpenWait(false);
				break;
			case IBSAVE:        //저장
//                ComAddSeparator_Local(formObj.f_cost_yrmon, "-");

                if(validateCond(formObj)){
                	ComOpenWait(true);
                    formObj.f_cmd.value = MULTI01;
                    sheetObj.DoSave("ESM_MAS_0048GS.do", masFormQueryString(formObj,'f_cmd',true), -1, false);
                    ComOpenWait(false);
                }
                break;
		}
		
	}
	
	/**
	 * 화면 조회값에 대한 유효성검증 프로세스 처리
	 */
	function validateCond(formObj) {
		var rt = false;
		with(formObj){
			if(!ComIsDate(formObj.f_cost_yrmon , "ym")){
				ComShowCodeMessage('MAS10002','YYYY-MM');
    			ComSetFocus(formObj.f_cost_yrmon);
			} else {
				rt = true;
			}
		}

		return rt;
	}
	/* 개발자 작업  끝 */