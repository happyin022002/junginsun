/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_COA_0142.js
*@FileTitle : VVD Check List
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.24
*@LastModifier : 이연각
*@LastVersion : 1.0
* 1.0 Creation
=========================================================
* History
* 2007.03.27 박은주  최초 생성
* 2009.10.15 박수훈 New FrameWork 적용[0142]
* 2010.02.24 이연각 업무처리중 버튼사용 금지 처리
* 2010.04.14 이행지 FormQueryString =>coaFormQueryString 변경
* 2010.06.10 송호진 [Legacy전환] UI 표준안 적용 요청 관련 수정 : 
*                  CHM-200901714, CHM-200901715, CHM-200901716, CHM-200901717, CHM-200901718, CHM-200901719
* 2010.09.01 이일민 Ticket ID:CHM-201004982-01 COA Architecture 위배사항 수정
*/
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
	 * @class ESM_COA_0142 : ESM_COA_0142 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESM_COA_0142() {
		this.processButtonClick		= tprocessButtonClick;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.setSheetObject 		= setSheetObject;
		this.sheet1_OnSaveEnd       = sheet1_OnSaveEnd;
		this.doActionIBSheet 		= doActionIBSheet;
		this.validateForm 			= validateForm;
	}

	// 공통전역변수
	
	var sheetObjects = new Array();
	var sheetCnt = 0;	
	var sheet_height = 20; // sheet의 height
	
	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
				
				case "btn_Save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;
				
				case "btn_Close":
					window.close();
					break;			
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(ComGetMsg("COM12111"));
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
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}
	
	/**
	* 시트 초기설정값, 헤더 정의
	* param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	*/
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		
		switch(sheetNo) {
			case 1:      //sheet2 init
				with (sheetObj) {
					SheetWidth = mainTable.clientWidth;						//전체 너비 설정
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);		//Host정보 설정[필수][HostIp, Port, PagePath]
					MergeSheet = msHeaderOnly;									//전체Merge 종류 [선택, Default msNone]
					Editable = true;										//전체Edit 허용 여부 [선택, Default false]
					InitRowInfo( 2, 1, 9, 100);								//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitColumnInfo(13, 8, 0, true);							//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitHeadMode(true, true, false, true, false,false);		// 해더에서 처리할 수 있는 각종 기능을 설정한다
					var HeadTitle0 = "STS|Contract\nYYYY-MM|Sales\nYYYY-MM|Week|Trade|Lane|IOC|Vessel|Voy.|BND|Revenue Port|Revenue Port|Weekly\n Auto/Mnl" ;
					var HeadTitle1 = "STS|Contract\nYYYY-MM|Sales\nYYYY-MM|Week|Trade|Lane|IOC|Vessel|Voy.|BND|Port|ETD|Weekly\n Auto/Mnl" ;
					//        					var HeadTitle0 = "STS|SEQ|YYYY-MM|Week|Trade|Sub Trade|S. Lane|Lane|Type|Vessel|Voy.|BND|IOC|Revenue Port|Revenue Port|Weekly Mnl" ;
					//        					var HeadTitle1 = "STS|SEQ|YYYY-MM|Week|Trade|Sub Trade|S. Lane|Lane|Type|Vessel|Voy.|BND|IOC|Port|ETD|Weekly Mnl" ;
					InitHeadRow(0, HeadTitle0,true);						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(1, HeadTitle1,false);						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0,	cnt++,	dtStatus,	30,		daCenter,		true,		"ibflag");
					//        					InitDataProperty(0,	cnt++,	dtSeq,		30,		daCenter,		true,		"",					false,		"",		dfNone,	 	0,		false,	false);
					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,		true,		"cost_yrmon",		 true,		"",		dfDateYm,	0,		true,	true);
					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,		true,		"sls_yrmon",		false,		"",		dfDateYm,	0,		true,	true);
					InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,		true,		"cost_wk",			 true,		"",		dfNone,		0,		true,	true);
					InitDataProperty(0,	cnt++,	dtData,	    70,		daCenter,		true,		"trd_cd",			false,		"",		dfNone,		0,		false,	false);
					//InitDataProperty(0,	cnt++,	dtData,	    70,		daCenter,		true,		"sub_trd_cd",		false,		"",		dfNone,		0,		false,	false);
					//InitDataProperty(0,	cnt++,	dtData,	    50,		daCenter,		true,		"slan_cd",			false,		"",		dfNone,		0,		false,	false);
					InitDataProperty(0,	cnt++,	dtData,	    60,		daCenter,		true,		"rlane_cd",			false,		"",		dfNone,		0,		false,	false);
					InitDataProperty(0,	cnt++,	dtData,	    60,		daCenter,		true,		"ioc_cd",			false,		"",		dfNone,		0,		false,	false);
					//InitDataProperty(0,	cnt++,	dtData,	    40,		daCenter,		true,		"vsl_lane_tp_cd",	false,		"",		dfNone,		0,		false,	false);
					InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,		true,		"vsl_cd",			false,		"",		dfNone,		0,		false,	false);
					InitDataProperty(0,	cnt++,	dtData,		50,		daCenter,		true,		"skd_voy_no",		false,		"",		dfNone,		0,		false,	false);
					InitDataProperty(0,	cnt++,	dtData,	    40,		daCenter,		true,		"dir_cd",			false,		"",		dfNone,		0,		false,	false);
					//InitDataProperty(0,	cnt++,	dtData,	    40,		daCenter,		true,		"ioc_cd",			false,		"",		dfNone,		0,		false,	false);
					InitDataProperty(0,	cnt++,	dtData,	    70,		daCenter,		true,		"lst_lodg_port_cd",	false,		"",		dfNone,		0,		false,	false);
					InitDataProperty(0,	cnt++,	dtData,	   120,     daCenter,		true,		"lst_lodg_port_etd_dt",false,	"",		dfUserFormat2,0,	false,	false);
					InitDataProperty(0,	cnt++,	dtCombo,    70,     daCenter,		true,		"wky_mnl_flg",      false,      "",		dfNone,     0,	    true,	true);
					
					HeadRowHeight  = 10;
					CountPosition  = 0 ;
					style.height = GetSheetHeight(sheet_height) ;
					InitUserFormat2(0, "lst_lodg_port_etd_dt", "####-##-## ##:##:##", "-|:" );
					InitDataCombo(0, "wky_mnl_flg", " |Pre_Manual|Fix_Auto|Fix_Manual", " |P|A|M");
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
	* Save 후 메시지 처리
	*/
	function sheet1_OnSaveEnd(sheetObj, ErrMsg){
		if(ErrMsg == ""){
		// [COA10006] : 작업이 완료되었습니다.
			ComShowCodeMessage("COA10006");
		}
	}
	
	
	/**
	/**
	* Sheet관련 프로세스 처리
	*/
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;	// 업무처리중 버튼사용 금지 처리
		
		switch(sAction) {
			case IBSEARCH:      //조회
				ComOpenWait(true);
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				if(formObj.f_fm_mon.value != "" && formObj.f_fm_mon.value.length != 2) formObj.f_fm_mon.value = ComLpad(formObj.f_fm_mon.value, 2, '0');
				if(formObj.f_to_mon.value != "" && formObj.f_to_mon.value.length != 2) formObj.f_to_mon.value = ComLpad(formObj.f_to_mon.value, 2, '0');
				if(formObj.f_fm_wk.value != "" && formObj.f_fm_wk.value.length != 2) formObj.f_fm_wk.value = ComLpad(formObj.f_fm_wk.value, 2, '0');
				if(formObj.f_to_wk.value != "" && formObj.f_to_wk.value.length != 2) formObj.f_to_wk.value = ComLpad(formObj.f_to_wk.value, 2, '0');
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch4Post("ESM_COA_0142GS.do", coaFormQueryString(formObj));
				ComOpenWait(false);
				break;
			
			case IBSAVE:        //저장
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI;
				sheetObj.DoSave("ESM_COA_0142GS.do", coaFormQueryString(formObj,'f_cmd',true), -1, false);
				ComOpenWait(false);
				break;
		}
	}
	
	
	/**
	* 화면 폼입력값에 대한 유효성검증 프로세스 처리
	*/
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			// Year Check..
			if (f_year.value == "") {
			    // [COM12114] : Year 를(을) 확인하세요.
				ComShowCodeMessage("COM12114", "Year");
			    f_year.focus();
				return false;
			}

 		    if(!ComIsDate(f_year, "yyyy")){
 		    	// [COA10009] = 'Please enter Year correctly.\n\n Format : YYYY
 		    	ComShowCodeMessage('COA10009','Year','YYYY');
			    f_year.focus();
 		    	return false;
 		    }
 		    // 
			//f_chkprd
			if (f_fm_mon.value != "" && f_to_mon.value == ""){
				// [COM12114] : Month 를(을) 확인하세요.
				ComShowCodeMessage("COM12114", "Month")
				f_to_mon.focus();
				return false;
			}
			if (f_fm_mon.value == "" && f_to_mon.value != "") {
				// [COM12114] : Month 를(을) 확인하세요.
				ComShowCodeMessage("COM12114", "Month");
				f_fm_mon.focus();
				return false;
			}
			if (ComParseInt(f_fm_mon.value) > ComParseInt(f_to_mon.value)) {
				// [COA10011] = Month의 From는(은) To보다 적거나 같아야 합니다.
				ComShowCodeMessage("COA10011","Month","From","To");
				f_to_mon.focus();
				return false;
			}
			if (f_fm_wk.value != "" && f_to_wk.value == ""){
				// [COM12114] : Week 를(을) 확인하세요.
				ComShowCodeMessage("COM12114", "Week");
				f_to_wk.focus();
				return false;
			}
			if (f_fm_wk.value == "" && f_to_wk.value != ""){
				// [COM12114] : Week 를(을) 확인하세요.
				ComShowCodeMessage("COM12114", "Week");
				f_fm_wk.focus();
				return false;
			}
			if (f_fm_wk.value > f_to_wk.value) {
				// [COA10011] = Month의 From는(은) To보다 적거나 같아야 합니다.
				ComShowCodeMessage("COA10011","Week","From","To");
				f_to_wk.focus();
				return false;
			}
			if(f_fm_mon.value == "" && f_fm_wk.value == ""){
				//        			    ComShowCodeMessage("COM12138", "month", "week");
				return false;
			}
			if(!ComIsDate(f_year, "yyyy")){
				// [COA1009] = Year 값을 확인하십시오.
				ComShowCodeMessage('COA10009','Year','YYYY');
				
				return false;
			}
			if(!ComIsMonth(f_fm_mon)){
				// [COA1009] = Month 값을 확인하십시오.
				ComShowCodeMessage('COA10009','Month','MM');
				return false;
			}
			if(!ComIsMonth(f_to_mon)) {
				// [COA1009] = Month 값을 확인하십시오.
				ComShowCodeMessage('COA10009','Month','MM');
				return false;
			}
			if(!ComIsWeek(f_fm_wk)){
				// [COA1009] = Week 값을 확인하십시오.
				ComShowCodeMessage('COA10009','Week','WW');
				return false;
			}
			if(!ComIsWeek(f_to_wk)) {
				// [COA1009] = Week 값을 확인하십시오.
				ComShowCodeMessage('COA10009','Week','WW');
				return false;
			}
		}
		return true;
	}