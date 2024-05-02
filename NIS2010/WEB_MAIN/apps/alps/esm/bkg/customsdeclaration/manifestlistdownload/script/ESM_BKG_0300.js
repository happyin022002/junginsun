/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0300.js
*@FileTitle : ESM_BKG_0300
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.17
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.06.17 경종윤
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
     * @class ESM_BKG_0300 : ESM_BKG_0300 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0300() {
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

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
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
 	 * 화면 로딩 완료 후 이벤트
 	 * @param sheetObj
 	 * @return
 	 */
 	function sheet1_OnLoadFinish(sheetObj) {
 		var formObj = document.form;
     	
		//화면에서 필요한 이벤트
    	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
    	axon_event.addListener('keydown', 'obj_ComKeyEnter', 'form');
    	
		doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
    	
 	 }   
    
    
    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){

       sheetObjects[sheetCnt++] = sheet_obj;
			
    }

    
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject = sheetObjects[0];
         /*******************************************************/
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

					case "btn_retrieve":
						doActionIBSheet(sheetObject,formObject,IBSEARCH);
						break;
					
					case "btn_save":
						doActionIBSheet(sheetObject,formObject,IBSAVE);
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
						style.height = 100;
						//전체 너비 설정
						SheetWidth = mainTable.clientWidth;
						
						//Host정보 설정[필수][HostIp, Port, PagePath]
						if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
						
						//전체Merge 종류 [선택, Default msNone]
						MergeSheet = msHeaderOnly;
						
						//전체Edit 허용 여부 [선택, Default false]
						Editable = true;
						
						//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
						InitRowInfo(1, 1, 3, 100);
						
						//var HeadTitle1 = "| |Harmonized Tariff Code|Description|Category";
						var HeadTitle1 = "|ofc_cd|HDR_CTNT|FTR_CTNT|DECL_ADDR|BOD_CTNT";
						var headCount = ComCountHeadTitle(HeadTitle1);

						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
						InitColumnInfo(headCount, 0, 0, true);
						
						// 해더에서 처리할 수 있는 각종 기능을 설정한다
						InitHeadMode(true, true, false, true, false,false);
						
						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
						InitHeadRow(0, HeadTitle1, true);
						
						//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(0,		cnt++ , dtHiddenStatus,			30,		daCenter,		true,		"ibflag");
						InitDataProperty(0,		cnt++ , dtData,					100,	daCenter,		true,		"ofc_cd", false, "", dfNone, 0, false, false);
						InitDataProperty(0,		cnt++ , dtData,					100,	daCenter,		true,		"hdr_ctnt", false, "", dfNone, 0, false, false);
						InitDataProperty(0,		cnt++ , dtData,					100,	daCenter,		true,		"ftr_ctnt", false, "", dfNone, 0, false, false);
						InitDataProperty(0,		cnt++ , dtData,					100,	daCenter,		true,		"decl_addr",false, "", dfNone, 0, false, false);
						InitDataProperty(0,		cnt++ , dtData,					100,	daCenter,		true,		"bod_ctnt", false, "", dfNone, 0, false, false);

						CountPosition = 0;
						
						sheetObj.DataInsert(-1);
						//sheetObj.CellValue2(1, "ibflag") = "U";
						sheetObj.RowStatus(1) = "U";

				}
				break;


		}
	}
    
	/**
	 * Sheet관련 프로세스 처리
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {

			case IBSEARCH :	//조회
				if(!validateForm(sheetObj,formObj,sAction)) return false;

				doActionIBSheet(sheetObj,formObj,SEARCH01); // Office Code 등록 유무 조회
				
				var exitOrg = sheetObj.EtcData("retExitOrg");
		        
		        if(exitOrg != "0") {
		        	
					formObj.f_cmd.value = SEARCH;
					sheetObj.DoSearch("ESM_BKG_0300GS.do", FormQueryString(formObj) );
	
		            if(sheetObj.RowCount == 1){
			            IBS_CopyRowToForm(sheetObj, formObj, 1, "form1_");
	
		            } else if(sheetObj.RowCount == 0){
						
			        	initForm();	
		            }
		            
		        } else {
		        	initForm();	
		        	
		        }
		        
				break;
				
		    case IBSAVE :	// 저장,수정
		    	if(!validateForm(sheetObj,formObj,sAction)) return;
		    	
				doActionIBSheet(sheetObj,formObj,SEARCH01); // Office Code 등록 유무 조회
				
				var exitOrg = sheetObj.EtcData("retExitOrg");
		        
		        if(exitOrg != "0") {

		    		IBS_CopyFormToRow(formObj, sheetObj, 1, "form1_");
		            
			        sheetObj.CellValue2(1,"ofc_cd") = formObj.ofc_cd.value;
	
			    	formObj.f_cmd.value = MULTI;
			        sheetObj.DoSave("ESM_BKG_0300GS.do", FormQueryString(formObj), -1, false);

		        }

		        break;

		    case SEARCH01 :	// Office Code 등록유무 조회
		    	
				formObj.f_cmd.value = SEARCH01;
		    	sheetObj.DoSearch("ESM_BKG_0300GS.do", FormQueryString(formObj) );
		    	break;
		}
	}

	/**
	 * 폼 클리어
	 * 
	 * @return
	 */
	function initForm() {
		sheetObjects[0].RemoveAll();
		sheetObjects[0].DataInsert(-1);	
		
		IBS_CopyRowToForm(sheetObjects[0], document.form, 1, "form1_");		
	}
	
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	
     	switch(sAction) {
	 		case IBSEARCH :
				//기본포멧체크
				if (!ComChkValid(formObj)) return false;
	 			
	 			break;
	 	
	 		case IBSAVE:
				//기본포멧체크
				if (!ComChkValid(formObj)) return false;
	 			
	 			break;
        }

        return true;
    }
    
    /**
     * Enter 이벤트
     * @return
     */
    function obj_ComKeyEnter() {
    	
     	var formObject = document.form;
     	var srcName = window.event.srcElement.getAttribute("name");
     	
     	if(srcName != "form1_hdr_ctnt" && srcName != "form1_ftr_ctnt" 
     		&& srcName != "form1_decl_addr" && srcName != "form1_bod_ctnt") {
     		ComKeyEnter();
     	}
    	
    }
    
    /**
     * 조회 후 이벤트
     * @param sheetObj
     * @param ErrMsg
     * @return
     */
	function sheet1_OnSearchEnd(sheetObj,ErrMsg){

		var exitOrg = sheetObj.EtcData("retExitOrg");
        
        if(exitOrg == "0") {
        	//ComShowMessage("사용가능한 Office Code가 아닙니다.");
        	ComShowCodeMessage("BKG01107");
        	return false;
        } else if(exitOrg == "") {
			if (ErrMsg == "") {
				if(sheetObj.RowCount == 0) {
					ComShowCodeMessage("BKG00889");
					return false;
				}
			}
        	
        } else {
		
        }
	}
	
	/**
	 * 저장 후 이벤트
	 * @param sheetObj
	 * @param ErrMsg
	 * @return
	 */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {

		if (ErrMsg == "") {
			ComShowCodeMessage('BKG00102');
			return false;
		}
    }
