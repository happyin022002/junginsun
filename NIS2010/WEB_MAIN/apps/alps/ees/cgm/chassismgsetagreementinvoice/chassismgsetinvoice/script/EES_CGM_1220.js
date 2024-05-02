/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName		: EES_CGM_1220.js
*@FileTitle	: Chassis S/C Exception Inquiry
*Open Issues	:
*Change history :
*@LastModifyDate: 2014.03.20
*@LastModifier	: 정운
*@LastVersion	: 1.0
* 2014.03.20 정운
* 1.0 Creation
* 2014-04-02 by Jonghee HAN CSR Ticket : CHM-201429628, Title : Pricing-S/C Creation and Amendation 시, Amend Button 활성화 요청 Loc.Count Total 값 제거
* 2014-04-04 by Jonghee HAN CSR Ticket : CHM-201429628, Title : Pricing-S/C Creation and Amendation 시, Amend Button 활성화 요청 Seq. Column 추가
* 2015.12.18 CSR : CHM-201539416 SC EXEPTION 화면 변경
*				그리드에 Effective Date, Expire Date 추가
=========================================================*/
/**************************************************************************************** 
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * @extends 
	 * @class ees_cgm_1155 : ees_cgm_1155 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_CGM_1155() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject		= setSheetObject;
		this.loadPage				= loadPage;
		this.initSheet				= initSheet;
		this.initControl			= initControl;
		this.doActionIBSheet		= doActionIBSheet;
		this.validateForm			= validateForm;
	}
	
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var HeadTitleCnt =0;
	var headCnt = 0;
   
	var IBSEARCH01  = 29;
	var IBSEARCH02  = 30;
	var IBSEARCH03  = 31;
	var IBSEARCH04  = 32;
	var IBSEARCH05  = 33;
	var IBSEARCH06  = 34;
	
	var sccChk = "";
	var scNoChk = "";
   
	
	/**
	* Sheet 기본 설정 및 초기화
	* body 태그의 onLoad 이벤트핸들러 구현
	* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	*/
	function loadPage() {
		
		for(i=0;i<sheetObjects.length;i++){
		   //khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i] );
	 
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		//화면 Open시에 Period 값을 세팅한다. 
		form.sc_fm_dt.value = ComGetDateAdd(ComGetNowInfo("ymd"), "M", -1);
		form.sc_to_dt.value = ComGetNowInfo();
		
		initControl();
		
		//GRID 마지막 컬럼 길이 확장 금지
		//sheetObjects[0].ExtendLastCol = false;  
	
		//최초 Sheet Open 및 조회 시에 불필요한 컬럼을 Hidden으로 처리 
		for (var i=8 ; i < headCnt ; i++){
			sheetObjects[0].ColHidden(i) = true;
		}
		
		//sheetObjects[0].SheetWidth = 580;
		
	}

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];	
		
		/*******************************************************/
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch(srcName) {

			case "btn_new":		//조회조건 초기화
				sheetObjects[0].WaitImageVisible = false;
				sheetObjects[0].Redraw = false;
				sheetObjects[0].RemoveAll();
				sheetObjects[0].Redraw = true;
				sheetObjects[0].SheetWidth = 580;

				//불필요한 컬럼을 Hidden으로 처리 
				for (var i=4 ; i < headCnt ; i++){
					sheetObjects[0].ColHidden(i) = true;
				}
				
				formObject.sc_fm_dt.value = ComGetDateAdd(ComGetNowInfo("ymd"), "M", -1);
				formObject.sc_to_dt.value = ComGetNowInfo();
				formObject.loc_cd.value = "";
				formObject.sc_no.value = "";
				
				sccChk = "Y";
				scNoChk = "Y";
				break;
				
			case "btn_downexcel":	//DOWN EXCEL
				doActionIBSheet(sheetObjects[0], formObject, IBDOWNEXCEL);
				break;
				
			case "btn_Retrieve":	//조회
				sheetObjects[0].RemoveAll();
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
				break;
			
			case "cre_dt_cal":	//Period 설정
				var cal = new ComCalendarFromTo();
				cal.select(formObject.sc_fm_dt, formObject.sc_to_dt, 'yyyy-MM-dd');
				break;	
				
			case "eq_no_multi": //scc_cd 멀티입력 
				rep_Multiful_inquiry("loc_cd"); 
				break;
			
			case "eq_no_multi1": //scc_no 멀티입력
				rep_Multiful_inquiry("sc_no"); 
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
	* IBSheet Object를 배열로 등록
	* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	* 배열은 소스 상단에 정의
	*/
	function setSheetObject(sheet_obj){
	  sheetObjects[sheetCnt++] = sheet_obj;
	}
	
	/**
	* 초기 이벤트 등록 
	*/
	function initControl() {
		axon_event.addListenerFormat('keypress', 'obj_keypress'  , document.form);		//알파벳 대문자,숫자만 입력허용	
		axon_event.addListenerFormat('beforeactivate', 'obj_activate', document.form);	//form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
		axon_event.addListenerForm('blur',	'obj_deactivate',  document.form);			//- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
		axon_event.addListenerForm('change','obj_change',document.form);				//- 변경될때.
	}

	
	/**
	* 알파벳 대문자,숫자만 입력허용 하도록한다.
	*/
	function obj_keypress() {
		var formObject = document.form;
		
		switch (event.srcElement.name) {
			case "sc_fm_dt":
				ComKeyOnlyNumber(event.srcElement);
				break;
			case "sc_to_dt":
				ComKeyOnlyNumber(event.srcElement);
				break;		
			case "loc_cd":
				ComKeyOnlyAlphabet('uppernum', '44|45');
				break;
			case "sc_no":
				ComKeyOnlyAlphabet('uppernum', '44|45');
				break;
		}
	}

	/**
	 * Period FM  beforeactivate 이벤트 처리
	 * Period FM  beforeactivate -없애기
	 */	
	function obj_activate() {
		ComClearSeparator(event.srcElement);
	}
		
	/**
	* Period to  beforedeactivate 이벤트 처리
	* Period to  beforedeactivate YYYY-MM 포멧 처리
	*/	
	function obj_deactivate() {
		ComAddSeparator(event.srcElement);
	}
		
	/**
	 * Period TO  keyup 이벤트 처리
	 * Period TO  keyup 날짜 체크 처리
	 * @param fromToFlag
	 */
	function chkPeriod(fromToFlag) {
		var formObj = document.form;
		var chkFlag = true;
		
		if ( fromToFlag == 'from') {
			if ( !ComIsDate(formObj.sc_fm_dt.value, "ymd") ) {
				formObj.sc_fm_dt.value = "";
				formObj.sc_fm_dt.focus();
				chkFlag = false;
			}
		} else {
			if ( !ComIsDate(formObj.sc_to_dt.value, "ymd") ) {
				formObj.sc_to_dt.value = "";
				formObj.sc_to_dt.focus();
				chkFlag = false;
			}
		}		
	
		if(formObj.sc_fm_dt.value != "" && formObj.sc_to_dt.value != "") {
			if(formObj.sc_fm_dt.value.trimAll("-") > formObj.sc_to_dt.value.trimAll("-")) {
				ComShowMessage(ComGetMsg("CGM20079", "To", "FM")); //'{?msg1} should be same or later than {?msg2}.';
				formObj.sc_to_dt.value = "";
				formObj.sc_to_dt.focus();
				chkFlag = false;
			}
		} 
		
		return chkFlag;
	}	
	
	
	
	/**
	* 시트 초기설정값, 헤더 정의
	* @param  sheetObj, sheetNo, headTitle
	*/
	function initSheet(sheetObj, sheetNo, headTitle) {
		var cnt = 0;
	  
		switch (sheetNo) {
			case 1:	  //t1sheet1 init
				with (sheetObj) {
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
						// 높이 설정
					style.height = 500;
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msPrevColumnMerge;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 100, 100);  
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)
					
					CountPosition = 0;	//페이지카운트 없애기 
					
					if (headTitle==null || headTitle =="") {
						headTitle = "Seq.|SC No.|Customer Code|Customer Name|Effective\nDate|Expire\nDate|Freetime\nFlag|Loc. Count||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||"; 
//						InitColumnInfo(5, 0, 0, true);
					}
					
					headCnt  = headTitle.split("|").length;
					
					SheetWidth = mainTable.clientWidth;
					
					InitColumnInfo(headCnt, 0, 0, true);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, headTitle, true);
					
					sheetObj.FrozenCols = 8;
					
					//데이터속성	[ROW, COL, DATATYPE,    WIDTH,  DATAALIGN,  COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtSeq,		30,		daCenter,	true,	"seq");
					InitDataProperty(0, cnt++, dtAutoSum,	90,		daCenter,	false,	"sc_no",		false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,		100,	daCenter,	false,	"sc_cust_no",	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,		250,	daLeft,		false,	"sc_cust_nm",	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,		80,		daCenter,	false,	"eff_dt",		false,	"",	dfDateYmd,	0,	false,	false);
					InitDataProperty(0, cnt++, dtData,		80,		daCenter,	false,	"exp_dt",		false,	"",	dfDateYmd,	0,	false,	false);
					InitDataProperty(0, cnt++, dtData,		80,		daCenter,	false,	"ft_flg",		false,	"",	dfDateYmd,	0,	false,	false);
					InitDataProperty(0, cnt++, dtAutoSum,	70,		daCenter,	false,	"sc_loc_tcnt",	false,	"",	dfNone,		0,	false,	false);
					
					for(var i=1 ; i <= headCnt - 8; i++){
						InitDataProperty(0, cnt++ , dtAutoSum,	80,	daLeft,		false,	"scc"+(i),	false,	"",	dfNone,	0,	false,	 false,	0,	false,	false);
					}

				}
				break;
		}
	} 

	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		
			case IBSEARCH:	  //조회
				if(!validateForm(sheetObj,formObj,sAction)) return;  // VALIDATION
				
				sheetObj.Redraw = false;
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true); 
				
				formObj.f_cmd.value = SEARCH;
				var sXml = sheetObjects[0].GetSearchXml("EES_CGM_1220GS.do" , FormQueryString(form));
				
				//헤더 데이터를 설정한다.
				var hdr = ComGetEtcData(sXml, "header");
				var HeadTitle = "Seq.|SC No.|Customer Code|Customer Name|Effective\nDate|Expire\nDate|Freetime\nFlag|Loc. Count|" + hdr;  // 타이틀 조립
				
				HeadTitleCnt = HeadTitle.split("|").length;
				
				for ( var i=0; i<headCnt; i++ ) {
					if ( HeadTitleCnt <= i ) {
						sheetObj.ColHidden(i) = true;
					} else {
						sheetObj.ColHidden(i) = false;
					}
				}
				
				for ( var i=0; i<HeadTitleCnt; i++ ) {
					sheetObj.CellValue2(0,i) = HeadTitle.split("|")[i];	 
				}	 
				
				sheetObjects[0].LoadSearchXml(sXml);
				ComOpenWait(false); 
				
				break;
								
			case IBSEARCH01:
				formObj.f_cmd.value = SEARCH01;	
				sParam = FormQueryString(formObj);  
				var sXml = sheetObjects[0].GetSearchXml("EES_CGM_1220GS.do", sParam);
				var checkDisp = ComGetEtcData(sXml, "LOC_CD");
				if(checkDisp != "" && checkDisp.length != 0){
					alert("Invalid SCC Code: " + checkDisp);
					ComSetFocus(formObj.loc_cd);
					sccChk = "N";
				}else{
					sccChk = "Y";
					return;
				}
				break;
				
			case IBSEARCH02:
				formObj.f_cmd.value = SEARCH02;	
				sParam = FormQueryString(formObj);  
				var sXml = sheetObjects[0].GetSearchXml("EES_CGM_1220GS.do", sParam);
				var checkDisp = ComGetEtcData(sXml, "SC_NO");
				if(checkDisp != "" && checkDisp.length != 0){
					alert("Invalid SC No.: " + checkDisp);
					ComSetFocus(formObj.sc_no);
					scNoChk = "N";
				}else{
					scNoChk = "Y";
					return;
				}
				break;
							
			case IBDOWNEXCEL:	  // 엑섹다운로드
					sheetObj.Down2Excel(-1, false, false, false); // merge 안된 excel
				break;
		}
	}
	
	/**
	* GRID 조회종료후 이벤트 호출 (맨 마지막 TOTAL 라인을 생성-고정)
	*/
	function t1sheet1_OnSearchEnd(sheetObj, msg){

		//Loc.Count의 값을 설정
//		sheetObj.CellValue2(sheetObj.LastRow, "sc_loc_tcnt") = sheetObj.CellValue(sheetObj.LastRow-1, "sc_loc_tcnt");
		sheetObj.CellValue2(sheetObj.LastRow, "sc_loc_tcnt") = '';
		sheetObj.CellValue2(sheetObj.LastRow, "sc_no") = '';
		
		// 마지막 컬럼을 Hidden 처리한다.
		sheetObj.ColHidden(HeadTitleCnt-1) = true;
		
		sheetObj.CellValue2(sheetObj.LastRow, "seq") = "Total SC No. Count by Location";
		sheetObj.RowBackColor(sheetObj.LastRow) = sheetObj.RgbColor(201, 213, 235);
		sheetObj.SetMergeCell(sheetObj.LastRow, 0, 0, 5);
		sheetObj.RowHidden(sheetObj.LastRow-1) = true;
		sheetObj.Redraw = true;		
	}
	
	/**
	* 화면 폼입력값에 대한 유효성검증 프로세스 처리
	* @param sheetObj,formObj,sAction
	*/
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			switch (sAction) {
			
			case IBSEARCH:			
			
				// 날짜 공백 체크
				if (document.form.sc_fm_dt.value == '') {
					ComShowCodeMessage('CGM10004', 'Period ');
					document.form.sc_fm_dt.focus();
					return false;
				}
				if (document.form.sc_to_dt.value == '') {
					ComShowCodeMessage('CGM10004', 'Period ');
					document.form.sc_to_dt.focus();
					return false;
				}
			
				//날짜 Validation 체크
				if ( document.form.sc_fm_dt.value != '' ) {
					ComAddSeparator(event.srcElement);
					if ( !chkPeriod('from') ) {  
						return false;
					}
				} 
				if ( document.form.sc_to_dt.value != '' ) {
					ComAddSeparator(event.srcElement);
					if ( !chkPeriod('to') ) {
						return false;
					} 
				}
				
				// SCC Validation Check
				if(sccChk == "N"){
					alert("Please Check SCC Again");
					return;
				}
				
				// SCC Validation Check
				if(scNoChk == "N"){
					alert("Please Check SC No. Again");
					return;
				}
			}	
		}
		return true;
	}
	
	/**
	 * 셀을 클릭했을때 발생하는 이벤트 <br>
	 * 선택시 선택행 배경색 세팅
	 * @param sheetObj, row, col, value
	 */
	function t1sheet1_OnClick(sheetObj, row, col, value) {
		sheetObj.SelectHighLight = true;
	}
	
	/**
	* HTML Control의 Value가 변경되었을 경우 처리한다.
	*/
	function obj_change(){
	
		var obj	  = event.srcElement;
		var formObj  = document.form;
		var sheetObj = sheetObjects[0]; 

		switch(obj.name) {

		case "loc_cd":
			var sValue = formObj.loc_cd.value.split(",");
			var tempText = "";
			
			if(formObj.loc_cd.value == ""){
				sccChk = "Y";
			} else {
				for(var i=0; i<sValue.length; i++) {  
					tempText += sValue[i] + ',';
				}	  
				
				//마지막에 ,를 없애기 위함	 
				tempText = CgmDelLastDelim(tempText);
				formObj.loc_cd.value = tempText;
				
				doActionIBSheet(sheetObj, formObj, IBSEARCH01);
			}

			break;
			
		case "sc_no":
			var sValue = formObj.sc_no.value.split(",");
			var tempText = "";
			
			if(formObj.sc_no.value == ""){
				scNoChk = "Y";
			} else {
				for(var i=0; i<sValue.length; i++) {
					tempText += sValue[i] + ',';
				}	  
				
				//마지막에 ,를 없애기 위함	 
				tempText = CgmDelLastDelim(tempText);
				formObj.sc_no.value = tempText;
				
				doActionIBSheet(sheetObj, formObj, IBSEARCH02);
			}

			break;
		
		// 2015.02.04 CGM_SC_EXPT_VER 테이블에 2014년 이전 자료가 없어서 자바오류가 일어나므로 추가 Chang Young Kim
		case "sc_fm_dt" :
			if(obj.value < 20140101) {
				//msgs['COM12133'] = '{?msg1} must be {?msg3} than {?msg2}.';
				ComShowCodeMessage('COM12133', 'From Date', '"2014-01-01"', 'greater');
				ComClearObject(obj);
				ComSetFocus(obj);
			}
			
			break;
			
		}
	}

	/** 
	 * rep_Multiful_inquiry의 리턴처리 메서드
	 * @param	{Array}		rowArray	반환되는 Array
	 * @param	{String}	return_val	반환되는 form element명
	 */
	function getCgm_Multi(rowArray ,return_val) {
		var formObj = document.form;	 
		var tempText = "";	   
		//초기화	 
		eval("document.form." + return_val + ".value = '';");
 
		for(var i=0; i < rowArray.length; i++) {	 
			tempText +=  rowArray[i] + ',';	  
		}	 
		//마지막에 ,를 없애기 위함	  
		tempText = CgmDelLastDelim(tempText);		
		eval("document.form." + return_val + ".value = '" + tempText + "';");
	
		if(formObj.loc_cd.value != ""){
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH01);
		}
		
		if(formObj.sc_no.value != ""){
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH02);
		}
	}

	/* 개발자 작업  끝 */