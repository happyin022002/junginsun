/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_COA_0176.js
*@FileTitle : TS Allocation(SNT)
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.08
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2010.02.01 이행지
* 2010.05.17 윤진영 아키위배사항 formcommand에서 command 01~40 사용금지 적용
* 2010.12.01 김기종 Ticket ID:CHM-201004982-01 COA Architecture 위배사항 수정
* 1.0 Creation
=========================================================
* History
* 2010.04.15 이행지 FormQueryString => coaFormQueryString 변경
* 2013.01.14 서미진 [CHM-201322375] Period 조회시, 주차만 셋팅하여 default 값에 년도와 주차 pair가 맞지 않는 부분 수정 
=========================================================
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
     * @class ESM_COA_0176 : ESM_COA_0176 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_COA_0176() {
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
	
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch(srcName) {			
				case "btn_Retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
				
				case "btn_Creation":
					doActionIBSheet(sheetObject,formObject,IBCREATE);
					break;
				
				case "btn_Downexcel":
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
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
     * IBCombo Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
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
		
	}
	
	/**
     * 멀티콤보 항목을 설정한다.
     */
     function initCombo(comboObj, comboId) {
    	 with (comboObj) {
	    	 DropHeight = 300;
	    	 comboObj.InsertItem(0, 'All' ,'');
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
			case 1:      //sheet1 init
				with (sheetObj) {
					SheetWidth = mainTable.clientWidth;
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					MergeSheet = msPrevColumnMerge; //msHeaderOnly;
					Editable = false;
					InitRowInfo(1, 1, 9, 100);
					InitColumnInfo(13, 0, 0, true);
					InitHeadMode(true, true, false, true, false, false);
					
					var HeadTitle  = "From Trade|Lane|IOC|VVD|To Trade|Lane|IOC|VVD|T/S Volume|From VVD Expense|From VVD BSA|Slot Price|Assigned AMT";
					InitHeadRow(0, HeadTitle, false);	
					
					var cnt = 0;
					InitDataProperty(0, cnt++, dtData,    80, daCenter, true, "m_trd_cd",                false, "", dfNone,    0, false, false);
					InitDataProperty(0, cnt++, dtData,    80, daCenter, true, "m_rlane_cd",              false, "", dfNone,    0, false, false);
					InitDataProperty(0, cnt++, dtData,    40, daCenter, true, "m_ioc_cd",                false, "", dfNone,    0, false, false);
					InitDataProperty(0, cnt++, dtData,    90, daCenter, true, "m_vvd_cd",                false, "", dfNone,    0, false, false);
					
					InitDataProperty(0, cnt++, dtData,    80, daCenter, false, "d_trd_cd",               false, "", dfNone,    0, false, false);
					InitDataProperty(0, cnt++, dtData,    80, daCenter, false, "d_rlane_cd",             false, "", dfNone,    0, false, false);
					InitDataProperty(0, cnt++, dtData,    40, daCenter, false, "d_ioc_cd",               false, "", dfNone,    0, false, false);
					InitDataProperty(0, cnt++, dtData,    90, daCenter, false, "d_vvd_cd",               false, "", dfNone,    0, false, false);
					InitDataProperty(0, cnt++, dtAutoSum, 70, daRight,  false, "d_ts_qty",               false, "", dfFloatOrg, 1, false, false);
					InitDataProperty(0, cnt++, dtAutoSum,115, daRight,  false, "d_vvd_expense", 		   false, "", dfFloatOrg, 1, false, false);
					InitDataProperty(0, cnt++, dtAutoSum,105, daRight,  false, "d_fnl_hjs_bsa_capa",     false, "", dfFloatOrg, 1, false, false);
					InitDataProperty(0, cnt++, dtData,    70, daRight,  false, "d_slot_price",    	   false, "", dfFloatOrg, 1, false, false);
					InitDataProperty(0, cnt++, dtAutoSum,110, daRight,  false, "d_assign_amt",    	   false, "", dfFloatOrg, 1, false, false);
					
					HeadRowHeight = 10;
					CountPosition  = 0 ;
					style.height = GetSheetHeight(23) ;
				}
				break;		
		}
	}
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible=false;
		
		switch(sAction) {
			case IBCLEAR:          //조회
		        sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = INIT;
				var sXml = sheetObj.GetSearchXml("ESM_COA_0176GS.do", coaFormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				
				formObj.f_year.value = ComGetEtcData(arrXml[0], "fYear"); 
		        formObj.f_fm_mon.value = formObj.f_to_mon.value = ComGetNowInfo("mm");
		        formObj.f_fm_mon.value = ComLpad(formObj.f_fm_mon, 2, '0');
		        formObj.f_to_mon.value = ComLpad(formObj.f_to_mon, 2, '0');
		        formObj.f_fm_wk.value = formObj.f_to_wk.value = ComGetEtcData(arrXml[0],"prevWeek");
		        setPeriod(formObj.f_to_wk);
		        
				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], formObj.f_seltrade, "code", "code");
				if (arrXml.length > 1)
					ComXml2ComboItem(arrXml[1], formObj.f_selrlane, "code", "code");
				if (arrXml.length > 2)
					ComXml2ComboItem(arrXml[2], formObj.f_selioc, "code", "code");
				if (arrXml.length > 3)
					ComXml2ComboItem(arrXml[3], formObj.f_selcost, "code", "name");
				
				ComOpenWait(false);
				break;	
			case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				if(formObj.f_fm_mon.value != "" && formObj.f_fm_mon.value.length != 2) formObj.f_fm_mon.value = fillZero(formObj.f_fm_mon.value, 2, '0','left');
				if(formObj.f_to_mon.value != "" && formObj.f_to_mon.value.length != 2) formObj.f_to_mon.value = fillZero(formObj.f_to_mon.value, 2, '0','left');
				if(formObj.f_fm_wk.value != "" && formObj.f_fm_wk.value.length != 2) formObj.f_fm_wk.value = fillZero(formObj.f_fm_wk.value, 2, '0','left');
				if(formObj.f_to_wk.value != "" && formObj.f_to_wk.value.length != 2) formObj.f_to_wk.value = fillZero(formObj.f_to_wk.value, 2, '0','left');
				
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCHLIST;
				sheetObj.DoSearch4Post("ESM_COA_0176GS.do", coaFormQueryString(formObj,'param1|param2|param3|param4|param5|param6|param7|param8'));
				ComOpenWait(false);
				break;
			
			case IBDOWNEXCEL:   //엑셀 다운로드
				//sheetObj.Down2Excel(-1, false, false, true);
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
			
			case IBCREATE:      //생성
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				if (ComShowConfirm(ComGetMsg('COA10020')) == true) {
					ComOpenWait(true);
					formObj.f_cmd.value = MULTI01;
					sheetObj.DoSearch4Post("ESM_COA_0176GS.do", coaFormQueryString(formObj,'param1|param2|param3|param4|param5|param6|param7|param8'));
					ComOpenWait(false);
					var err_cd = sheetObj.EtcData("err_cd");
					var err_msg = sheetObj.EtcData("err_msg");
					if (err_cd == "00000") {
						ComShowCodeMessage('COA10018','CREATION');
					}
				}
				break;		
		}
	}
	
	/**
	* 화면 폼입력값에 대한 유효성검증 프로세스 처리
	*/
	function validateSheet(sheetObj) {
		with(sheetObj){
		}
		
		return true;
	}
	
	/**
 	 * trade코드 변경시 rLane 리스트를 리플래쉬 한다.
 	 */
 	function f_seltrade_OnChange(obj,value,text) {
 		 
 		if (loadingMode == true) return;
 		var formObj = document.form;
 		var sheetObj = sheetObjects[0];
		formObj.f_cmd.value = SEARCHLIST10;
		var sXml = sheetObj.GetSearchXml("ESM_COA_0176GS.do", coaFormQueryString(formObj));
		var arrXml = sXml.split("|$$|");
		if (arrXml.length > 0)
			ComXml2ComboItem(arrXml[0], formObj.f_selrlane, "code", "name");
		formObj.f_selrlane.InsertItem(0, "All", "All");
		formObj.f_selrlane.Index = 0;
 		
 	}
    
	
	
	/**
	* year, month, week가 변경되었을때 보여지는 Period를 변경한다.
	*/
	function setPeriod(obj) {
		ComCoaSetPeriod(obj);
	}
	
	
	/**
	* 검색시 필수입력사항 체크
	*/
	function chkValidSearch(){
		var formObj = document.form;
		
		with(formObj){
			if (f_year.value == "") {
				// [COM12114] : Year 를(을) 확인하세요.
				ComShowCodeMessage("COM12114", "Year");
				f_year.focus();
				return false;
			}
			if (f_fm_mon.value != "" && f_to_mon.value == ""){
				// [COM12114] : Month 를(을) 확인하세요.
				ComShowCodeMessage("COM12114", "Month");
				f_to_mon.focus();
				return false;
			}
			if (f_fm_mon.value == "" && f_to_mon.value != "") {
				// [COM12114] : Month 를(을) 확인하세요.
				ComShowCodeMessage("COM12114", "Month");
				f_fm_mon.focus();
				return false;
			}
			//2010.01.05 임시로 주석처리
			//        			if (f_fm_mon.value > f_to_mon.value) {
			//        			    // [COA10011] = Month의 From는(은) To보다 적거나 같아야 합니다.
			//        			    ComShowCodeMessage("COA10011","Month","From","To");
			//        			    f_to_mon.focus();
			//        			    return false;
			//        			}
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
				// [COM12138] : Month 과 Week 중 하나는 입력하세요.
				//        			   ComShowCodeMessage("COM12138", "Month", "Week");
				return false;
			}
			if(!isValidYear(f_year,false,true)) return false;
			if(!isValidMonth(f_fm_mon,false,true)) return false;
			if(!isValidMonth(f_to_mon,false,true)) return false;
			if(!isValidWeek(f_fm_wk,false,true)) return false;
			if(!isValidWeek(f_to_wk,false,true)) return false;
		}
		return true;
	}
	
	/**
	* 화면 폼입력값에 대한 유효성검증 프로세스 처리
	*/
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			if (f_year.value == "") {
				// [COM12114] : Year 를(을) 확인하세요.
				ComShowCodeMessage("COM12114", "Year");
				f_year.focus();
				return false;
			}
			if((f_chkprd[1].checked && f_fm_mon.value == "" && f_to_mon.value == "") 
				&& txtVsl_cd.value == "" && f_skd_voy_no.value == "" && f_dir_cd.value == ""){
				ComShowCodeMessage("COM12138", "Month", "VVD");
				return false;
			}
			if((f_chkprd[0].checked && f_fm_wk.value == ""  && f_to_wk.value == "") 
				&& txtVsl_cd.value == "" && f_skd_voy_no.value == "" && f_dir_cd.value == ""){
				ComShowCodeMessage("COM12138", "Week", "VVD");
				return false;
			}
			if(!isValidYear(f_year,false,true)) return false;
			if(!chkValidSearch()) return false;
			if(f_fm_mon.value == "" && f_fm_wk.value == ""){
				// [COM12138] : Month 과 Week 중 하나는 입력하세요.
				ComShowCodeMessage("COM12138", "Month", "Week");
				return false;
			}
		}
		return true;
	}
	/* 개발자 작업  끝 */