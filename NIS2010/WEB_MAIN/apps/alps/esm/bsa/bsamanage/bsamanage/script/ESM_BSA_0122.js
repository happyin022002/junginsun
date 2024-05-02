/*=========================================================
'주  시 스 템 : ENIS
'서브  시스템 : SPC Control J/O Slot [Other Carrier's Slot Swap Information]
'프로그램 ID  : apps/enis/esm/coa/bsamanage/bsamanage/jsp/ESM_BSA_122.jsp
'프로그램 명  : Other Carrier's Slot Swap Information
'프로그램개요 : Other Carrier's Slot Swap Information
'작   성   자 : Park Eun Ju
'작   성   일 : 2006.10.26
=========================================================================
' History :
* 2009.10.14 남궁진호 ALPS 전환  1.0 Creation
* 2012.08.24 이석준 [CHM-201219866] SPS INFO CREATION 의 OTHER SWAP NOTICE 삭제 기능 추가 요청
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
     * @class ESM_BSA_0122 : ESM_BSA_0122 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BSA_0122() {
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

	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch(srcName) {
				case "btn_save":
				    doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;
					
    			case "btng_rowadd":
    				doActionIBSheet(sheetObject,formObject,IBINSERT);
    				break;
				
				case "btn_close":
					self.close();
					break;
			
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(ComGetMsg("COM12111","",""));
			} else {
				ComShowMessage(e);
			}
		}
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
	* Sheet 기본 설정 및 초기화
	* body 태그의 onLoad 이벤트핸들러 구현
	* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	*/
	function loadPage(crrCombo) {
	
		for(i=0;i<sheetObjects.length;i++){
		
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			
			initSheet(sheetObjects[i],i+1, crrCombo);
			
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
 
			
	    }
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
//		sheetObjects[1].LoadSearchXml(document.form.sXml.value);
//		sheetObjects[1].Visible = false;
	}

   /**
	* 시트 초기설정값, 헤더 정의
	* param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	*/
	function initSheet(sheetObj,sheetNo, crrCombo) {
	
		var cnt = 0;
	
		switch(sheetNo) {
			case 1:      //sheet1 init
				with (sheetObj) {
					SheetWidth = mainTable.clientWidth; 	 	 	 //전체 너비 설정
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
					MergeSheet = msNone;									//전체Merge 종류 [선택, Default msNone]
					Editable = true;										//전체Edit 허용 여부 [선택, Default false]
					InitRowInfo( 1, 1, 9, 100);								//행정보설정[필.수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitColumnInfo(5, 0 , 0, true);							//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitHeadMode(true, true, false, true, false,false);		// 해더에서 처리할 수 있는 각종 기능을 설정한다
					var HeadTitle = "DEL|STS|From|Sub BSA|To";
					InitHeadRow(0, HeadTitle, false);						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					
					//데이터속성[ROW,COL,DATATYPE,WIDTH,DATAALIGN,COLMERGE,SAVENAME,KEYFIELD,CALCULOGIC,DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0,     cnt++ , dtDelCheck,     30,    daCenter,  true,    "del_chk");
					InitDataProperty(0,		cnt++,	dtStatus,	    40,		daCenter,	true,	"ibflag");
//					InitDataProperty(0,		cnt++,	dtHidden,	    80,	    daCenter,	true,	"bsa_seq1",	false,	"",	dfNone,     0,	false,	false);
					InitDataProperty(0,		cnt++,	dtCombo,		140,	daCenter,	true,	"bsa_fm_crr_cd",	false,	"",	dfNone,     0,	true,	true);
					InitDataProperty(0,		cnt++,	dtData,			150,	daRight,	true,	"crr_swap_capa",	false,	"",	dfNumber,	0,	true,	true);
					InitDataProperty(0,		cnt++,	dtCombo,		140,	daCenter,	true,	"bsa_to_crr_cd",	false,	"",	dfNone,	    0,	true,	true);
					
					CountPosition  = 0 ;
					style.height = GetSheetHeight(11) ;
					InitDataCombo(0, "bsa_fm_crr_cd", crrCombo, crrCombo);
					InitDataCombo(0, "bsa_to_crr_cd", crrCombo, crrCombo);
				}
				break;
		
//			case 2:      //sheet1 init
//				with (sheetObj) {
//					SheetWidth = mainTable.clientWidth; 	 	 	 //전체 너비 설정
//					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
//					MergeSheet = msNone;									//전체Merge 종류 [선택, Default msNone]
//					Editable = false;										//전체Edit 허용 여부 [선택, Default false]
//					InitRowInfo( 1, 1, 9, 100);								//행정보설정[필.수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
//					InitColumnInfo(9, 0 , 0, true);							//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
//					InitHeadMode(true, true, false, true, false,false);		// 해더에서 처리할 수 있는 각종 기능을 설정한다
//					var HeadTitle = "STS|bsa_seq|trd_cd|rlane_cd|dir_cd|vop_cd|vsl_capa|bsa_fm_dt|bsa_to_dt";
//					InitHeadRow(0, HeadTitle, false);						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
//					
//					//데이터속성[ROW,COL,DATATYPE,WIDTH,DATAALIGN,COLMERGE,SAVENAME,KEYFIELD,CALCULOGIC,DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//					InitDataProperty(0,		cnt++,	dtStatus,	40,		daCenter,	true,	"ibflag");
//					InitDataProperty(0,		cnt++,	dtData,		80,	    daCenter,	true,	"bsa_seq",	false,	"",	dfNone,     0,	true,	true);
//					InitDataProperty(0,		cnt++,	dtData,		80,	    daCenter,	true,	"trd_cd",	false,	"",	dfNone,     0,	true,	true);
//					InitDataProperty(0,		cnt++,	dtData,		80,	    daCenter,	true,	"rlane_cd",	false,	"",	dfNone,  	0,	true,	true);
//					InitDataProperty(0,		cnt++,	dtData,		80,	    daCenter,	true,	"dir_cd",	false,	"",	dfNone,	    0,	true,	true);
//					InitDataProperty(0,		cnt++,	dtData,		80,	    daCenter,	true,	"vop_cd",	false,	"",	dfNone,	    0,	true,	true);
//					InitDataProperty(0,		cnt++,	dtData,		80,	    daCenter,	true,	"vsl_capa",	false,	"",	dfNone,	    0,	true,	true);
//					InitDataProperty(0,		cnt++,	dtData,		80,	    daCenter,	true,	"bsa_fm_dt",false,	"",	dfNone,	    0,	true,	true);
//					InitDataProperty(0,		cnt++,	dtData,		80,	    daCenter,	true,	"bsa_to_dt",false,	"",	dfNone,	    0,	true,	true);
//					
//					CountPosition  = 0 ;
//					style.height = GetSheetHeight(0) ;
//
//				}
//				break;
		
		}
	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
//		var sheetObj2 = sheetObjects[1];
	
		switch(sAction) {
			case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				formObj.f_cmd.value = SEARCHLIST02;
				sheetObj.DoSearch4Post("ESM_BSA_0122GS.do", bsaFormString(formObj,getParam('ESM_BSA_0122')));
				break;
 
			case IBSAVE:        //저장
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				if(sheetObj.RowCount>0){
    				formObj.f_cmd.value = MULTI02;
    				sheetObj.DoSave("ESM_BSA_0122GS.do", bsaFormString(formObj,getParam('ESM_BSA_0122','S')), -1, false);
    				break;
				}else{
				    ComShowMessage(sheetObj.MessageText("UserMsg13"));
				    return false;
				}
				break;
				
			case IBINSERT:        //저장
				sheetObj.DataInsert();
				break;
		     
		}
	}


   /**
	* 화면 폼입력값에 대한 유효성검증 프로세스 처리
	*/
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
		}
	
		return true;
	}

	/* 개발자 작업  끝 */