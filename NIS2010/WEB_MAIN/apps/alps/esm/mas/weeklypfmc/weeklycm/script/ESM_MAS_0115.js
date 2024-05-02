/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_MAS_0115.js
*@FileTitle :EMU Cost (RA)
*Open Issues :
*Change history : CSR NO. R200802265271 MAS 조회 기간 관련 수정 요청  
*               : CSR No. N200802290005 MAS_EMU, 샤시 비용 관련 수정
*@LastModifyDate : 2009.09.11
*@LastModifier :Jeon Yunju
* 
*Change history :  
* 
* 2008.08.12 전윤주 CSR NO. N200807170013 EMU 단가 조회 화면 변경 
*                  - POD 조회 조건 추가 포함 
* 2009.01.23 전윤주 CSR No. N200901230005 MAS_EMU Credit 내 EQ Cost 제외 
* 2009.04.14 전윤주 CSR No. N200904070092 EMU Internal EQ rental Base 에서 EQ Cost 제외 
* 2009.09.11 박수훈 0115 화면 New FrameWork 적용
* 2010.02.08 전윤주 from ECC validation check에 space 한 자리일 경우도 추가 (IBcombo 다른 항목 선택 후 빈 항목으로 오면 space 한 자리로 인식)
* 2010.02.22 이연각 업무처리중 버튼사용 금지 처리
* 2010.06.10 송호진 [Legacy전환] UI 표준안 적용 요청 관련 수정 : 
*                  CHM-200901714, CHM-200901715, CHM-200901716, CHM-200901717, CHM-200901718, CHM-200901719
* 2010.09.01 김기종 Ticket ID:CHM-201004982-01 MAS Architecture 위배사항 수정
* 2011.05.13 김민아 [CHM-201110694-01] MAS Report 화면 combo box validation 추가 - 자리수, 영문대문자, 숫자 입력 제한
* 2012.03.22 김종준 [CHM-201217091-01] EMU 관련 로직 보완/변경 검토 요청의 건 -EMU(RA) Origin Credit Ratio 추가 
* 2012.09.12 이석준 [CHM-201220073-01] EMU Cost (RA) 에 Month Copy 기능 추가
* 2013.09.04 김수정 [CHM-201326480] EMU_RA 화면 MB Data 없는 경우 Pre Simulation 화면과 동일 조건으로 Data 조회하도록 변경
* 2015.08.31 손진환 [CHM-201536958] Split15-[그룹사 표준 코드 시행] SML 프로그램 대응 및 데이타 마이그레이션 작업 요청
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
     * @class ESM_MAS_0115 : ESM_MAS_0115 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_MAS_0115() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initCombo 				= initCombo;
    	this.setSheetObject 		= setSheetObject;
    	this.setComboObject 		= setComboObject;
    	this.sheet1_OnSearchEnd     = sheet1_OnSearchEnd;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.cobTrade_OnChange 		= cobTrade_OnChange;
    	this.changeSearchSheet 		= changeSearchSheet;
    	this.f_from_ecc_cd_OnKeyDown= f_from_ecc_cd_OnKeyDown;
    	this.f_pod_ecc_cd_OnKeyDown = f_pod_ecc_cd_OnKeyDown;
    	this.f_to_ecc_cd_OnKeyDown  = f_to_ecc_cd_OnKeyDown;
    	this.validateCond 			= validateCond;
    }

    
 // 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var comboObjects = new Array();
	var comboCnt = 0;
	var loadingMode = false;
	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 pass */
	function processButtonClick() {
		var sheetObject = sheetObjects[0];
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;

				case "btn_DownExcel":
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;
					
				case "btn_Month_Copy":		//팝업창(Month Copy)
		     	       var display = "0,1";
		     	       ComOpenPopup("ESM_MAS_0173.do?classId=ESM_MAS_0115", 250, 200, "AverageUcCopy", display, true, false);
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
        
    	if ( document.form.v_ofc_cd.value == 'SELAPM' || document.form.v_ofc_cd.value == 'CLTCO'
    		|| document.form.v_ofc_cd.value == 'SELCTY' || document.form.v_ofc_cd.value == 'SELOPE' || document.form.v_ofc_cd.value == 'SELCSG'){
    		ComBtnEnable("btn_Month_Copy");
    	} else {
    		ComBtnDisable("btn_Month_Copy");
    	}
    	
        doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
        // 멀티콤보 처리
        //---------------------------------------------
        for(k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],comboObjects[k].id);
        }
        loadingMode = false;
		ComSetFocus(document.form.f_cost_yrmon);
	}	

	
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
		switch(sheetNo) {
				case 1:			//sheet1 init
					with (sheetObj) {
						style.height = GetSheetHeight(16) ;
						SheetWidth = mainTable.clientWidth;//전체 너비 설정
						if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
						MergeSheet = msHeaderOnly;//전체Merge 종류 [선택, Default msNone]
						Editable = false;//전체Edit 허용 여부 [선택, Default false]
						InitRowInfo(3, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
						InitColumnInfo(21, 0, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
						InitHeadMode(true, false, false, true, false, false)// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]

						var HeadTitle	= "YYYY-MM|Route|Route|Route|EQ TP/SZ|EMU cost (MT Repo Cost)|EMU cost (MT Repo Cost)|EMU cost (MT Repo Cost)|Base cost (For EMU Credit)|Base cost (For EMU Credit)|Base cost (For EMU Credit)|EMU Credit|OP Rule|DEL Rule|OP\nCredit\nRatio|DEL\nCredit\nRatio|M/B(%)|M/B(%)|M/B(%)|M/B(%)|Manual";
						var HeadTitle1  = "YYYY-MM|OP ECC|POD ECC|DEL ECC|EQ TP/SZ|OP ECC|DEL ECC|TTL|OP\n(Trans + Steve)|POD\n(Steve)|TTL|EMU Credit|OP Rule|DEL Rule|OP\nCredit\nRatio|DEL\nCredit\nRatio|Status|OP ECC|Status|DEL ECC|Manual";
						var HeadTitle2  = "YYYY-MM|OP ECC|POD ECC|DEL ECC|EQ TP/SZ|OP ECC|DEL ECC|TTL|OP\n(Trans + Steve)|POD\n(Steve)|TTL|EMU Credit|OP Rule|DEL Rule|OP\nCredit\nRatio|DEL\nCredit\nRatio|Status|OP ECC|Status|DEL ECC|Manual";

						//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
						InitHeadRow(0, HeadTitle, true);
						InitHeadRow(1, HeadTitle1, true);
						InitHeadRow(2, HeadTitle2, true);						
						//데이터속성	DataRow, Col, [DataType], [Width], [DataAlign],
						//					[ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat],
						//					[PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort],
						//					[ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
						var cnt = 0;
						InitDataProperty(0, cnt++, dtData,		60, daCenter,	true, "cost_yrmon",				false, "", dfNone,		    0, false, false);
						InitDataProperty(0, cnt++, dtData,		55, daCenter,	true, "org_loc_cd",				false, "", dfNone,		    0, false, false);
						InitDataProperty(0, cnt++, dtData,		55, daCenter,	true, "pod_ecc_cd",				false, "", dfNone,		    0, false, false);
						InitDataProperty(0, cnt++, dtData,		55, daCenter,	true, "dest_loc_cd",			false, "", dfNone,		    0, false, true);
						
						InitDataProperty(0, cnt++, dtData,		60, daCenter,	true, "cntr_tpsz_cd",			false, "", dfNone,		    0, false, true);
					
						InitDataProperty(0, cnt++, dtData,		60, daRight,	true, "repo_ut_amt_por",        false, "", dfNullFloatOrg,	2, false, true);
						InitDataProperty(0, cnt++, dtData,		60, daRight,	true, "repo_ut_amt_del",        false, "", dfNullFloatOrg,	2, false, true);
						InitDataProperty(0, cnt++, dtData,		70, daRight,	true, "bse_ut_amt",		     	false, "", dfNullFloatOrg,	2, false, true);
						
						InitDataProperty(0, cnt++, dtData,	   100, daRight,	true, "sim_mty_cost_amt_por",	false, "", dfNullFloatOrg,	2, false, true);
						InitDataProperty(0, cnt++, dtData,		80, daRight,	true, "sim_mty_cost_amt_pod",	false, "", dfNullFloatOrg,	2, false, true);
						InitDataProperty(0, cnt++, dtData,		80, daRight,	true, "sim_mty_cost_amt_ttl",	false, "", dfNullFloatOrg,	2, false, true);
						InitDataProperty(0, cnt++, dtData,		80, daRight,	true, "emu_adj_mty_cost_amt_ttl",	false, "", dfNullFloatOrg,	2, false, true);
						
						InitDataProperty(0, cnt++, dtData,		60, daCenter,	true, "op_stg",		            false, "", dfNone,	       -1, false, true);
						InitDataProperty(0, cnt++, dtData,		60, daCenter,	true, "del_stg",		        false, "", dfNone,	       -1, false, true);
						InitDataProperty(0, cnt++, dtData,		50, daCenter,	true, "op_eq_repo_cr_rto",		false, "", dfNone,	       -1, false, true);
						InitDataProperty(0, cnt++, dtData,		50, daCenter,	true, "del_eq_repo_cr_rto",		false, "", dfNone,	       -1, false, true);
						
						
//						InitDataProperty(0, cnt++, dtData,		50, daCenter,	true, "eq_repo_cr_rto",		    false, "", dfNone,	       -1, false, true);
						
						InitDataProperty(0, cnt++, dtData,		50, daCenter,	true, "por_sts",		        false, "", dfNone,	        0, false, true); 
						InitDataProperty(0, cnt++, dtData,		60, daRight,	true, "por_rto",		        false, "", dfNullFloatOrg,	0, false, true); //CSR No. N200802290005 M/B 추가
						InitDataProperty(0, cnt++, dtData,		50, daCenter,	true, "del_sts",		        false, "", dfNone,	        0, false, true); 
						InitDataProperty(0, cnt++, dtData,		60, daRight,	true, "del_rto",		        false, "", dfNullFloatOrg,	0, false, true); //CSR No. N200802290005 M/B 추가
						InitDataProperty(0, cnt++, dtHidden,    60, daCenter,	true, "mnl_rqst_flg");

						RangeBackColor(1, 1, 1, 3) = RgbColor(222, 251, 248);
						RangeBackColor(1, 5, 1, 7) = RgbColor(222, 251, 248);
						RangeBackColor(1, 8, 1, 11) = RgbColor(222, 251, 248);
						RangeBackColor(1, 14, 1, 17) = RgbColor(222, 251, 248);

						HeadRowHeight = 10;
						CountPosition	= 0 ;
					}
					break;

		}
	}
	
	/**
     * 콤보 항목을 설정한다. 
     */
    function initCombo (comboObj, comboId) {
    	 with (comboObj) {
	    	 DropHeight = 300;
	    	 switch(comboObj.id) {
	    	 	case "f_cntr_tpsz_cd":
	    	    	IMEMode = 0;
	    	    	ValidChar(2, 1);
	    	    	MaxLength = 4;
	    	    	break;
	    	 	case "f_from_ecc_cd":
	    	 		comboObj.InsertItem(0, '' ,'');
	    	 		IMEMode = 0;
	    	    	ValidChar(2, 1);
	    	    	MaxLength = 5;
	    	 		break;
	    	 	case "f_pod_ecc_cd":
	    	 		comboObj.InsertItem(0, '' ,'');
	    	 		IMEMode = 0;
	    	    	ValidChar(2, 1);
	    	    	MaxLength = 5;
	    	 		break;
	    	 	case "f_to_ecc_cd":
	    	 		comboObj.InsertItem(0, '' ,'');
	    	 		IMEMode = 0;
	    	    	ValidChar(2, 1);
	    	    	MaxLength = 5;
	    	 		break;
	    	 }
	    	 Index = 0;
    	 }
    }

	
	/**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj) {
		 sheetObjects[sheetCnt++] = sheet_obj;
	}

 	/**
     * IBCombo Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의 by.yjjeon
     */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
    }
	
	/**
	* 시트 색상 바꾸기
	*/
	function sheet1_OnSearchEnd(sheetObj,errMsg){	   
		sheetObj.RangeFontColor(1,7,sheetObj.RowCount+2,7) = sheetObj.RgbColor(0,0,255);
		sheetObj.RangeFontColor(1,10,sheetObj.RowCount+2,10) = sheetObj.RgbColor(0,0,255);	
		
		for(i=sheetObj.HeaderRows; i<sheetObj.HeaderRows + sheetObj.SearchRows; i++){
			
			if(sheetObj.CellValue(i, "mnl_rqst_flg") == "Y" || sheetObj.CellValue(i, "mnl_rqst_flg") == "1")
				sheetObj.RowFontColor(i) = sheetObj.RgbColor(2525,0,0);
		}
	}

	/**
	* Sheet1관련 프로세스 처리 pass
	*/
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBCLEAR:          //조회
		        sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = INIT;
				var sXml = sheetObj.GetSearchXml("ESM_MAS_0115GS.do", FormQueryString(formObj));
				
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], formObj.f_cntr_tpsz_cd, "code", "code");
				if (arrXml.length > 1)
					ComXml2ComboItem(arrXml[1], formObj.f_from_ecc_cd, "code", "code");
				if (arrXml.length > 2)
					ComXml2ComboItem(arrXml[2], formObj.f_pod_ecc_cd, "code", "code");
				if (arrXml.length > 3)
					ComXml2ComboItem(arrXml[3], formObj.f_to_ecc_cd, "code", "code");
				ComOpenWait(false);
				break;
			case IBSEARCH:			//조회
				if (!validateCond(formObj)) return false;
				// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch4Post("ESM_MAS_0115GS.do", masFormQueryString(formObj));
				ComOpenWait(false);
				break;

			case IBDOWNEXCEL:	 //엑셀 다운로드
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

		}
	}


	/**
	* keyEnter변형 sheet1, sheet2
	*/
	function changeSearchSheet(){	
		if(event.keyCode == 13){
			var fObj = document.form;
				doActionIBSheet(sheetObjects[0],fObj,IBSEARCH);
		}
	}
	
	/**
	* keyEnter변형 combo1
	*/
	function f_from_ecc_cd_OnKeyDown(cboObj, KeyCode,Shift){
		if(KeyCode == 13){
			var fObj = document.form;
				doActionIBSheet(sheetObjects[0],fObj,IBSEARCH);
		}
	}	
	
	/**
	* keyEnter변형 combo2
	*/
	function f_pod_ecc_cd_OnKeyDown(cboObj, KeyCode,Shift){
		if(KeyCode == 13){
			var fObj = document.form;
				doActionIBSheet(sheetObjects[0],fObj,IBSEARCH);
		}
	}	
	
	/**
	* keyEnter변형 combo3
	*/
	function f_to_ecc_cd_OnKeyDown(cboObj, KeyCode,Shift){
		if(KeyCode == 13){
			var fObj = document.form;
				doActionIBSheet(sheetObjects[0],fObj,IBSEARCH);
		}
	}	
	

	/**
	 * 화면 조회값에 대한 유효성검증 프로세스 처리 pass
	 */
	function validateCond(formObj) {
		
		if(ComIsNull(formObj.f_cost_yrmon)) {
			ComShowCodeMessage('MAS10002', 'YYYY-MM');
			ComSetFocus(formObj.f_cost_yrmon);
			return false;	
		}
		
		if ((formObj.f_from_ecc_cd.Text == "")|| (formObj.f_from_ecc_cd.Text == " ")){
			ComShowCodeMessage('MAS10002', 'fromECC');
			ComSetFocus(formObj.f_cost_yrmon);			
			formObj.f_from_ecc_cd.focus();			
			return false;
		}
		
//		if (formObj.f_pod_ecc_cd.Text == ""){
//			ComShowCodeMessage('MAS10002', 'POD');
//			ComSetFocus(formObj.f_cost_yrmon);			
//			formObj.f_pod_ecc_cd.focus();			
//			return false;
//		}	
			
		if(formObj.f_cost_yrmon.value < "2007-07"){
		    // 2007년 07월, 27주 이전데이터는 조회 할수 없습니다. DW, CRM 시스템에서 조회 하시기 바랍니다.
			ComShowCodeMessage("MAS10037");
		    return false;
		}
		
		return true;
	}
