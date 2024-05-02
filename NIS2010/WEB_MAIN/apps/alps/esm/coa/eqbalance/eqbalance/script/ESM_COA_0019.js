/*=========================================================
 * *Copyright(c) 2006 CyberLogitec
*@FileName : ESM_COA_0019.js
*@FileTitle : Repo U/C 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이연각
*@LastVersion : 1.0
* 2008-05-06 전윤주 
* 2009-08-28 박수훈
* 1.0 최초 생성
=========================================================
* History
* 2009.04.20 전윤주 N200904070092 COA_CM 계산 수식 변경 (장비비 조회 메뉴에서 제외) 
* 2009.08.28 박수훈 0019 화면 New FramWork 적용
* 2010.02.22 이연각 업무처리중 버튼사용 금지 처리
* 2010.05.28 송호진 [Legacy전환] UI 표준안 적용 요청 관련 수정 : 
*                  CHM-200901714, CHM-200901715, CHM-200901716, CHM-200901717, CHM-200901718, CHM-200901719
* 2010.09.01 이일민 Ticket ID:CHM-201004982-01 COA Architecture 위배사항 수정
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCH=3;
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
     * @class ESM_COA_0019 : ESM_COA_0019 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_COA_0019() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.setSheetObject 		= setSheetObject;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    	this.changeSearchSheet 		= changeSearchSheet;
    	this.changeLocationHierarchy= changeLocationHierarchy;
    }
    


 var sheetObjects = new Array();
 var sheetCnt = 0;
 var comboObjects = new Array();
 var comboCnt = 0;
 var loadingMode = false;

 /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
 	function processButtonClick(){
 		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다. *****/
 		var sheetObject = sheetObjects[0];
 		var sheetObject1 = sheetObjects[1];
 		var sheetObject2 = sheetObjects[2];

 		/*******************************************************/
 		var formObject = document.form;

 		try {
 			var srcName = window.event.srcElement.getAttribute("name");
 			switch(srcName) {
 				case "btn_Retrieve":
 					if (formObject.p_choice.value == "0") {
 						doActionIBSheet(sheetObject,formObject,IBSEARCH);
 					}
 					break;
 				case "btn_Downexcel":
 					if (formObject.p_choice.value == "0") {
 						doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
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
 	* Sheet 기본 설정 및 초기화
 	* body 태그의 onLoad 이벤트핸들러 구현
 	* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 	*/
 	function loadPage() {
 		for(i=0;i<sheetObjects.length;i++){
 			ComConfigSheet(sheetObjects[i]);
 			initSheet(sheetObjects[i],i+1);
 			ComEndConfigSheet(sheetObjects[i]);
 		}
		loadingMode = true;
        doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
        for(k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],comboObjects[k].id);
        }
        loadingMode = false;
		ComSetFocus(document.form.f_cost_yrmon);
 	}

 	/**
    * 멀티콤보 항목을 설정한다.
    */
	function initCombo(comboObj, comboId) {
		with (comboObj) {
			DropHeight = 300;
			Index = 0;
		}
	}	

 	/**
 	* 시트 초기설정값, 헤더 정의
 	* param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 	* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 	*/
 	function initSheet(sheetObj,sheetNo) {
 		switch(sheetNo) {
 			case 1:	//sheet1 init
 				var cnt = 0;
 				with (sheetObj) {

 					SheetWidth = mainTable.clientWidth;//전체 너비 설정
 					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
 					MergeSheet = msPrevColumnMerge;//전체Merge 종류 [선택, Default msNone]
 					Editable = false;//전체Edit 허용 여부 [선택, Default false]
 					InitRowInfo( 1, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 					InitColumnInfo(6, 0, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 					InitHeadMode(true, true, false, true, false,false);// 해더에서 처리할 수 있는 각종 기능을 설정한다

 					var HeadTitle = null ;
 					HeadTitle = "ECC|Origin / Dest.|TP/SZ|MT Steve.|MT Trans.|MT Transit Time" ;
 					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 					InitHeadRow(0, HeadTitle, false);

 					//데이터속성	[ROW, COL,	DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					InitDataProperty(0, cnt++ , dtData,	120,	daCenter,	true,	"ecc_cd",				false,		"",		dfNone,		0,	false,		false);
 					InitDataProperty(0, cnt++ , dtData,	100,	daCenter,	false,	"cntr_org_dest_cd",		false,		"",		dfNone,		0,	false,		false);
 					InitDataProperty(0, cnt++ , dtData,	50,		daCenter,	false,	"cntr_tpsz_cd",			false,		"",		dfNone,		0,	false,		false);
 					InitDataProperty(0, cnt++ , dtData,	100,	daRight,	false,	"mty_stvg_uc_amt",	false,		"",		dfFloatOrg,	2,	false,		false);
 					InitDataProperty(0, cnt++ , dtData,	100,	daRight,	false,	"mty_trsp_uc_amt",	false,		"",		dfFloatOrg,	2,	false,		false);
 					InitDataProperty(0, cnt++ , dtData,	100,	daRight,	false,	"mty_tz_dys",		false,		"",		dfFloatOrg,	2,	false,		false);

 					CountPosition	= 2 ;
 					style.height = GetSheetHeight(21) ;
 				}
 				break;
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
	 * IBCombo Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}

	/**
 	* Sheet관련 프로세스 처리
 	*/
 	function doActionIBSheet(sheetObj,formObj,sAction) {
 		sheetObj.ShowDebugMsg = false;
 		switch(sAction) {

			case IBCLEAR:          //조회
		        sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = INIT;
				var sXml = sheetObj.GetSearchXml("ESM_COA_0019GS.do", coaFormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], formObj.f_cntr_tpsz_cd, "code", "name");
				if (arrXml.length > 1)
					ComXml2ComboItem(arrXml[1], formObj.f_mty_ecc_cd, "code", "name");
				if (arrXml.length > 2)
					ComXml2ComboItem(arrXml[2], formObj.f_mty_lcc_cd, "code", "name");
				if (arrXml.length > 3)
					ComXml2ComboItem(arrXml[3], formObj.f_mty_rcc_cd, "code", "name");
				ComOpenWait(false);
				break;

 			case IBSEARCH:	//조회
 				if(validateForm(sheetObj,formObj,sAction)) {
 					// 업무처리중 버튼사용 금지 처리
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
 					formObj.f_cmd.value = SEARCH;
 					sheetObj.DoSearch4Post("ESM_COA_0019GS.do", coaFormQueryString(formObj));
 					ComOpenWait(false);
 				}
 				break;

 			case IBINSERT:	// 입력
 				sheetObj.DataInsert();
 				break;

 			case IBCOPYROW:		//행 복사
 				sheetObj.DataCopy();
 				break;

 			case IBDOWNEXCEL:		//엑셀 다운로드
 				var excelType = selectDownExcelMethod(sheetObj);
 				switch (excelType) {
 					case "AY":
 						sheetObj.Down2Excel(0, false, false, true);
 						break;
 					case "DY":
 						sheetObj.Down2Excel(-1, false, false, true);
 						break;
 					case "AN":
 						sheetObj.SpeedDown2Excel(0, false, false);
 						break;
 					case "DN":
 						sheetObj.SpeedDown2Excel(-1, false, false);
 						break;
 				}

 				break;

 			case IBLOADEXCEL:		//엑셀 업로드
 				sheetObj.LoadExcel();
 				break;

 		}
 	}

 	/**
 	* 화면 폼입력값에 대한 유효성검증 프로세스 처리
 	*/
 	function validateForm(sheetObj,formObj,sAction){
 		with(formObj){
 			if(formObj.f_cost_yrmon.value == "") {
    			ComShowCodeMessage('COA10002','YYYY-MM');
    			ComSetFocus(formObj.f_cost_yrmon);
    			rt = false;
    			
 			}else if (ComAddSeparator(f_cost_yrmon, "ym")) {
 				return true;
 			}
 		}
 		return false;
 	}

 	/**
  	* keyEnter를 눌렀을때 쉬트 Retrieve
  	*/
 	function changeSearchSheet(){ 	
 		if(event.keyCode == 13){
 			var fObj = document.form;
 			if(fObj.p_choice.value == "0") {//sheet1
 				doActionIBSheet(sheetObjects[0],fObj,IBSEARCH);
 			}
 		}
 	}

 	/**
  	 * 콤보 박스 활성화
  	 */
 	function changeLocationHierarchy(val) {
 		//ecc, rcc hidden
 		shtObj = sheetObjects[0];
 		if(val == 'R'){//RCC
 		    shtObj.CellValue2(0, 0) = 'RCC';
 	        document.all.ecc_selbox.style.display = "none";
 	        document.all.lcc_selbox.style.display = "none";
 	        document.all.rcc_selbox.style.display = "inline";
 		} else if(val == 'L'){//LCC
 		    shtObj.CellValue2(0, 0) = 'LCC';
 	        document.all.ecc_selbox.style.display = "none";
 	        document.all.lcc_selbox.style.display = "inline";
 	        document.all.rcc_selbox.style.display = "none";
 		} else if(val == 'E') {//ECC
 		    shtObj.CellValue2(0, 0) = 'ECC';
 	        document.all.ecc_selbox.style.display = "inline";
 	        document.all.lcc_selbox.style.display = "none";
 	        document.all.rcc_selbox.style.display = "none";
 		}
 	}
