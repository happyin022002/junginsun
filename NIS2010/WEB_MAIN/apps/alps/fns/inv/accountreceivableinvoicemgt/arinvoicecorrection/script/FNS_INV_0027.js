/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0027.js
*@FileTitle : Ex Rate Update by Date or VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.08.26 최도순
* 1.0 Creation
* -------------------------------------------------------- 
* History
* 2011.10.24 권   민 [CHM-201114096] Service Management > A/R Invoice > Exchange Rate > Ex. Rate Update by Date or VVD Office Multi Check 기능 개발.
* 2012.03.21 권   민 [CHM-201216481] ONBOARD DATE 적용 개별환율 화주 일괄 업데이트 관련 개발 요청
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
	 * @class FNS_INV_0027 : FNS_INV_0027 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function FNS_INV_0027() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl            = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.validateForm 			= validateForm;
		this.getBackEndJobStatus	= getBackEndJobStatus;
		this.getBackEndJobLoadFile	= getBackEndJobLoadFile;
	}
	
	/* 개발자 작업	*/
	
	
	//공통전역변수
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	
	//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	/** 
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  없음  
	 * @return 없음
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];	
		var sheetObject2 = sheetObjects[1];	
		var sheetObject3 = sheetObjects[2];	
		var sheetObject4 = sheetObjects[3];	
		var sheetObject5 = sheetObjects[4];	
		/*******************************************************/
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");	
	
			switch(srcName) {
	
			case "btn_run":
				doActionIBSheet(sheetObject1,formObject,IBSAVE);
				break;
	
			case "btn_new":
				formObject.fm_if_dt.value = "";
				formObject.to_if_dt.value = "";
				formObject.io_bnd_cd.value = "";
				formObject.tot_cnt.value = "";
				formObject.good_cnt.value = "";
				formObject.no_good_cnt.value = "";
				formObject.run_opt[0].checked = true;				
				chkOption("N");
				formObject.inv_cust_cnt_cd.value = "";
				formObject.inv_cust_seq.value = "";
				formObject.fm_if_dt.focus();
				break;	
	
			case "btns_calendar1": //달력버튼
			var cal = new ComCalendar();
			cal.select(formObject.fm_if_dt, 'yyyy-MM-dd');
			break;
	
			case "btns_calendar2": //달력버튼
			var cal = new ComCalendar();
			cal.select(formObject.to_if_dt, 'yyyy-MM-dd');
			break;
	
			case "btn_invcust":
				var param = '?pgmNo=FNS_INV_0013&cust_cnt_cd='+formObject.inv_cust_cnt_cd.value+'&cust_seq='+formObject.inv_cust_seq.value+'&pop_yn=Y';
				var Row = 1;
				var Col = 1;
				ComOpenPopup('/hanjin/FNS_INV_0013.do'+param, 920, 650, '', '0,0', false, false, "", "", 0);
				break; 
			case "btn_custNm":
				param = '?pgmNo=FNS_INV_0086&cust_seq='+formObject.inv_cust_seq.value+'&cust_cnt_cd='+formObject.inv_cust_cnt_cd.value;
				ComOpenPopup('/hanjin/FNS_INV_0086.do' + param, 900, 450, 'getFNS_INV_0086_1', '1,0', false, false, Row, Col, 0);
				break;
			
			case "btn_downexcel":
				ComOpenWait(true);
				sheetObject5.SpeedDown2Excel(-1,false,false,'','',false,false,'',false);
				ComOpenWait(false);
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
	 * IBSheet Object를 sheetObjects 배열로 등록 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {IBSheet} sheetObj IBSheet Object
	 * @return 없음
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function setSheetObject(sheet_obj){
	
		sheetObjects[sheetCnt++] = sheet_obj;
	
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
	
		for(i=0;i<sheetObjects.length;i++){
	
			ComConfigSheet (sheetObjects[i] );	
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}	
	
		initControl();
		
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01); 		
	
		ComShowObject(document.form.btn_invcust,false);
		ComShowObject(document.form.btn_custNm,false);
		
		ComBtnDisable("btn_downexcel");
	
		document.form.fm_if_dt.focus();
	
	}
	
	/** 
	 * OnLoadFinish 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object        
	 * @return 없음
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */  	
	function sheet1_OnLoadFinish(sheetObj) {
		sheetObj.DataInsert(-1);
		sheetObj.DataInsert(-1);
		sheetObj.DataInsert(-1);
		sheetObj.DataInsert(-1);
		sheetObj.DataInsert(-1);
	
		sheetObj.CellValue(1,1) = '1';
		sheetObj.CellValue(2,1) = '3';
		sheetObj.CellValue(3,1) = '5';
		sheetObj.CellValue(4,1) = '7';
		sheetObj.CellValue(5,1) = '9';			
		sheetObj.CellValue(1,3) = '2';
		sheetObj.CellValue(2,3) = '4';
		sheetObj.CellValue(3,3) = '6';
		sheetObj.CellValue(4,3) = '8';
		sheetObj.CellValue(5,3) = '10';
	
		sheetObj.RowEditable(1)= false;
		sheetObj.RowEditable(2)= false;
		sheetObj.RowEditable(3)= false;
		sheetObj.RowEditable(4)= false;
		sheetObj.RowEditable(5)= false;
	}
	
	/** 
	 * OnLoadFinish 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object        
	 * @return 없음
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */  	
	function sheet3_OnLoadFinish(sheetObj) {
	
		sheetObj.DataInsert(-1);
		sheetObj.DataInsert(-1);
		sheetObj.DataInsert(-1);
		sheetObj.DataInsert(-1);
		sheetObj.DataInsert(-1);
	
		sheetObj.CellValue(1,1) = '1';
		sheetObj.CellValue(2,1) = '3';
		sheetObj.CellValue(3,1) = '5';
		sheetObj.CellValue(4,1) = '7';
		sheetObj.CellValue(5,1) = '9';			
		sheetObj.CellValue(1,3) = '2';
		sheetObj.CellValue(2,3) = '4';
		sheetObj.CellValue(3,3) = '6';
		sheetObj.CellValue(4,3) = '8';
		sheetObj.CellValue(5,3) = '10';
	
		sheetObj.RowEditable(1)= false;
		sheetObj.RowEditable(2)= false;
		sheetObj.RowEditable(3)= false;
		sheetObj.RowEditable(4)= false;
		sheetObj.RowEditable(5)= false;
	}
	
	/** 
	 * Sheet 기본 설정 및 초기화 <br>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다. <br> 
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {IBSheet} sheetObj : 시트오브젝트
	 * @param {int} sheetNo : 시트오브젝트 태그의 아이디에 붙인 일련번호  
	 * @return 없음
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function initSheet(sheetObj,sheetNo) {
	
		var cnt = 0;
		var sheetID = sheetObj.id;
		switch(sheetID) {
	
		case "sheet1":
			with (sheetObj) {
	
				// 높이 설정
				style.height = 105;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msNone;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 5, 100);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(5, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)
	
				var HeadTitle = "|seq|vvd|seq2|vvd2";
	
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true, true);
	
	
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,  40,    daCenter,  true,    "ibflag");
				InitDataProperty(0, cnt++ , dtData,	     		 40,    daCenter,  true,    "seq",		false,    "",      dfNone,		0,	false,		false, 0,false);
				InitDataProperty(0, cnt++ , dtData,     		 90,    daCenter,  true,    "vvd",      false,    "",      dfNone,		0,	true,		true, 9,false);
				InitDataProperty(0, cnt++ , dtData,	     		 40,    daCenter,  true,    "seq2",  	false, 	  "", 		dfNone,		0,	false,		false, 0,false);
				InitDataProperty(0, cnt++ , dtData,     		 90,    daCenter,  true,    "vvd2",      false,    "",      dfNone,		0,	true,		true, 9,false);
	
				CountPosition = 0;
				SelectHighLight = false;
				InitDataValid(0, "vvd", vtEngUpOther, "0123456789"); 
				InitDataValid(0, "vvd2", vtEngUpOther, "0123456789"); 
	
				RequestTimeOut = 1000;
				ScrollBar = 0;
				WaitImageVisible = false; 
			}
			break;
	
		case "sheet2":
			with (sheetObj) {
	
				// 높이 설정
				style.height = 0;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msNone;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 3, 100);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(3, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)
	
				var HeadTitle = "|seq|vvd";
	
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
	
	
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,  40,    daCenter,  true,    "ibflag");
				InitDataProperty(0, cnt++ , dtSeq,	     		 40,    daCenter,  true,    "seq",		false,    "",      dfNone,		0,	false,		false, 0,false);
				InitDataProperty(0, cnt++ , dtData,     		 90,    daCenter,  true,    "vvd",      false,    "",      dfNone,		0,	true,		true, 9,false);
	
				CountPosition = 0;
				InitDataValid(0, "vvd", vtEngUpOther, "0123456789"); 
	
				RequestTimeOut = 1000; 
				WaitImageVisible = false; 
	
			}
			break;	
	
		case "sheet3":
			with (sheetObj) {
	
				// 높이 설정
				style.height = 105;
				//전체 너비 설정
				SheetWidth = mainTable2.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msNone;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 5, 100);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(5, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)
	
				var HeadTitle = "|seq|bl_src_no|seq2|bl_src_no2";
	
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true, true);
	
	
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,  40,    daCenter,  true,    "ibflag");
				InitDataProperty(0, cnt++ , dtData,	     		 40,    daCenter,  true,    "seq",		false,    "",      dfNone,		0,	false,		false, 0,false);
				InitDataProperty(0, cnt++ , dtData,     		 90,    daCenter,  true,    "bl_src_no",      false,    "",      dfNone,		0,	true,		true, 12,false);
				InitDataProperty(0, cnt++ , dtData,	     		 40,    daCenter,  true,    "seq2",  	false, 	  "", 		dfNone,		0,	false,		false, 0,false);
				InitDataProperty(0, cnt++ , dtData,     		 90,    daCenter,  true,    "bl_src_no2",      false,    "",      dfNone,		0,	true,		true, 12,false);
	
				CountPosition = 0;
				SelectHighLight = false;
				InitDataValid(0, "bl_src_no", vtEngUpOther, "0123456789"); 
				InitDataValid(0, "bl_src_no2", vtEngUpOther, "0123456789"); 
	
				RequestTimeOut = 1000; 
				ScrollBar = 0;
				WaitImageVisible = false; 
			}
			break;
	
		case "sheet4":
			with (sheetObj) {
	
				// 높이 설정
				style.height = 0;
				//전체 너비 설정
				SheetWidth = mainTable2.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msNone;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 3, 100);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(3, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)
	
				var HeadTitle = "|seq|bl_src_no";
	
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
	
	
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,  40,    daCenter,  true,    "ibflag");
				InitDataProperty(0, cnt++ , dtSeq,	     		 40,    daCenter,  true,    "seq",		false,    "",      dfNone,		0,	false,		false, 0,false);
				InitDataProperty(0, cnt++ , dtData,     		 90,    daCenter,  true,    "bl_src_no",      false,    "",      dfNone,		0,	true,		true, 12,false);
	
				CountPosition = 0;
				InitDataValid(0, "bl_src_no", vtEngUpOther, "0123456789"); 
	
				RequestTimeOut = 1000; 
				WaitImageVisible = false; 
			}
			break;	
			
		case "sheet5":
			with (sheetObj) {
	
				// 높이 설정
				style.height = 0;
				//전체 너비 설정
				SheetWidth = mainTable2.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msNone;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 5, 100);
				
				var HeadTitle1 = "|AR IF NO|BL NO|BKG NO|ACT CUST CNT CD|ACT CUST SEQ|AR OFC CODE|VVD|POR|POL|POD|DEL|SVC SCOPE|SAILING DATE|SA DATE|USD EXCHG RATE|INV TOTAL LOCAL AMOUNT"
					
				var headCount = ComCountHeadTitle(HeadTitle1);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false);
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
	
	
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,  40,    daCenter,  true,    "ibflag");
				InitDataProperty(0, cnt++ , dtData,	     		 60,    daCenter,  true,    "ar_if_no",		false,    "",      dfNone,		0,	false,		false, 0,false);
				InitDataProperty(0, cnt++ , dtData,     		 50,    daCenter,  true,    "bl_src_no",      false,    "",      dfNone,		0,	true,		true, 12,false);
				InitDataProperty(0, cnt++ , dtData,	     		 50,    daCenter,  true,    "bkg_no",  	false, 	  "", 		dfNone,		0,	false,		false, 0,false);
				InitDataProperty(0, cnt++ , dtData,     		 70,    daCenter,  true,    "act_cust_cnt_cd",      false,    "",      dfNone,		0,	true,		true, 12,false);
				InitDataProperty(0, cnt++ , dtData,     		 70,    daCenter,  true,    "act_cust_seq",      false,    "",      dfNone,		0,	true,		true, 12,false);
				InitDataProperty(0, cnt++ , dtData,     		 70,    daCenter,  true,    "ar_ofc_cd",      false,    "",      dfNone,		0,	true,		true, 12,false);
				InitDataProperty(0, cnt++ , dtData,     		 50,    daCenter,  true,    "vvd",      false,    "",      dfNone,		0,	true,		true, 12,false);
				InitDataProperty(0, cnt++ , dtData,     		 50,    daCenter,  true,    "por_cd",      false,    "",      dfNone,		0,	true,		true, 12,false);
				InitDataProperty(0, cnt++ , dtData,     		 50,    daCenter,  true,    "pol_cd",      false,    "",      dfNone,		0,	true,		true, 12,false);
				InitDataProperty(0, cnt++ , dtData,     		 50,    daCenter,  true,    "pod_cd",      false,    "",      dfNone,		0,	true,		true, 12,false);
				InitDataProperty(0, cnt++ , dtData,     		 50,    daCenter,  true,    "del_cd",      false,    "",      dfNone,		0,	true,		true, 12,false);
				InitDataProperty(0, cnt++ , dtData,     		 70,    daCenter,  true,    "svc_scp_cd",      false,    "",      dfNone,		0,	true,		true, 12,false);
				InitDataProperty(0, cnt++ , dtData,     		 70,    daCenter,  true,    "sail_dt",      false,    "",      dfNone,		0,	true,		true, 12,false);
				InitDataProperty(0, cnt++ , dtData,     		 70,    daCenter,  true,    "sail_arr_dt",      false,    "",      dfNone,		0,	true,		true, 12,false);
				InitDataProperty(0, cnt++ , dtData,     		 70,    daCenter,  true,    "usd_xch_rt",      false,    "",      dfNone,		0,	true,		true, 12,false);
				InitDataProperty(0, cnt++ , dtData,     		 70,    daCenter,  true,    "inv_ttl_locl_amt",      false,    "",      dfNone,		0,	true,		true, 12,false);
				
				RequestTimeOut = 1000; 
				WaitImageVisible = false; 
			}
			break;
	
		}
	}
	
	/** 
	 * 조회 저장등 서버 기능을 호출하는 doActionIBSheet <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {IBSheet} sheetObj : 시트오브젝트  
	 * @param  {object} formObj : 폼 오브젝트
	 * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
	 * @return 없음
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
	
		case IBSEARCH_ASYNC01: // 화면 로딩시 AR_OFFICE_LIST 조회
		
		ComOpenWait(true);
		
		formObj.f_cmd.value = SEARCH02;
		var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));
	
		var sStr = ComGetEtcData(sXml,"ar_ofc_cd");

		var arrStr = sStr.split("|");
	
		/*MakeComboObject2(formObj.ar_ofc_cd, arrStr);
		
		var arrStr2 = "";
		var ar_ofc_cd = "";
	
		for(i=1;i<arrStr.length;i++){
			arrStr2 = arrStr[i].split("^");
			if(arrStr2[1]==arrStr2[3]){
				ar_ofc_cd = arrStr2[1];
	
				formObj.ar_ofc_cd.text = ar_ofc_cd;
				formObj.ofc.value = ar_ofc_cd;
				form.ofc_cd.value = form.ofc.value;	
			}
		}*/
		
		var arrStr2 = "";
		var arrStr3 = "";
	
		for(i=1;i<arrStr.length;i++){
			arrStr2 = arrStr[i].split("^");
			if(i==1){
				arrStr3 = arrStr2[1];
			}else{
				arrStr3 = arrStr3 + "|" + arrStr2[1];
			}
		}

		MakeComboObject3(formObj, formObj.ar_ofc_cd, arrStr3);
		
		ComOpenWait(false);
	
		break;	
	
	
		case IBSAVE:        //저장
	
		var row_cnt = sheetObjects[0].RowCount;
		var row = 0;
		var v_vvd = "";
		sheetObjects[1].RemoveAll();
	
		for (var i = 0; i < row_cnt; i++){
			for (var j = 1; j < 3; j++){	        			
				v_vvd = sheetObjects[0].CellValue(i+1, j*2);     			
	
				if (v_vvd != "") {
					sheetObjects[1].DataInsert(-1);
					row++;
					sheetObjects[1].CellValue(row, 2) = sheetObjects[0].CellValue(i+1, j*2);   				
				}	        			
			}	        		
		}
	
		var bl_row_cnt = sheetObjects[2].RowCount;
		var bl_row = 0;
		var v_bl_src_no = "";
		sheetObjects[3].RemoveAll();
	
		for (var i = 0; i < bl_row_cnt; i++){
			for (var j = 1; j < 3; j++){	        			
				v_bl_src_no = sheetObjects[2].CellValue(i+1, j*2);     			
	
				if (v_bl_src_no != "") {
					sheetObjects[3].DataInsert(-1);
					bl_row++;
					sheetObjects[3].CellValue(bl_row, 2) = sheetObjects[2].CellValue(i+1, j*2);   				
				}	        			
			}	        		
		}
	
		if(validateForm(sheetObj,formObj,sAction)){
			formObj.f_cmd.value = SEARCH01;
			var sXml = sheetObj.GetSaveXml("FNS_INV_0027GS.do",FormQueryString(formObj) + "&" + ComSetPrifix(sheetObjects[1].GetSaveString(false,true,"vvd"),"sheet1_")+ "&" + ComSetPrifix(sheetObjects[3].GetSaveString(false,true,"bl_src_no"),"sheet2_"));
			
			var backEndJobKey = ComGetEtcData(sXml, "BackEndJobKey")
	
			if(backEndJobKey.length > 0) {
				inputReadOnly(2);
				formObj.backendjob_key.value = backEndJobKey;
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				sheetObj.RequestTimeOut = 10000;
				timer = setInterval(getBackEndJobStatus, 3000);
			}
	
		}
		break;		
	
		}
	}
	
	
	
	/** 
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리하는 validateForm <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {IBSheet} sheetObj : 시트오브젝트  
	 * @param  {object} formObj : 폼 오브젝트
	 * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
	 * @return true, false
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			switch(sAction) {
			case IBSAVE:        //저장
				
			if(!checkOnBoardDateCust()){
				return;
			}
			if(formObj.run_opt[0].checked==true || formObj.run_opt[5].checked==true){
				if(formObj.ar_ofc_cd.text == ""){
					ComShowCodeMessage("INV00004");
					formObj.ar_ofc_cd.focus();
					return;
				}
				
				if(formObj.fm_if_dt.value==""||formObj.to_if_dt.value==""){
					ComShowCodeMessage("INV00004");
					formObj.fm_if_dt.focus();
					return;
				}
	
				if(ComGetDaysBetween(formObj.fm_if_dt.value,formObj.to_if_dt.value)>14){
					ComShowCodeMessage("INV00043");
					formObj.to_if_dt.focus();
					return;
				}
			}else if(formObj.run_opt[1].checked==true){
				if(formObj.ar_ofc_cd.text == ""){
					ComShowCodeMessage("INV00004");
					formObj.ar_ofc_cd.focus();
					return;
				}
				
				valCnt = 0;
				for(i=1;i<sheetObjects[1].RowCount+1;i++){
					if(sheetObjects[1].CellValue(i,"vvd")!="") valCnt = valCnt+1;
				}
	
				if(valCnt==0){
					ComShowCodeMessage("INV00004");
					sheetObjects[0].SelectCell(1,"vvd");
					return;
				}
	
				dupRow = sheetObjects[1].ColValueDup("vvd");
	
				if(dupRow!="-1" && sheetObjects[1].CellValue(dupRow,"vvd")!=""){
					ComShowCodeMessage("INV00052");
					fndRow = sheetObjects[0].FindText("vvd",sheetObjects[1].CellValue(dupRow,"vvd"));
					fndRow2 = sheetObjects[0].FindText("vvd2",sheetObjects[1].CellValue(dupRow,"vvd"));
					if(fndRow!='-1'){
						sheetObjects[0].SelectCell(fndRow,"vvd");
					}
					if(fndRow2!='-1'){
						sheetObjects[0].SelectCell(fndRow2,"vvd2");
					}
	
					return;
				}
	
			}else if(formObj.run_opt[2].checked==true || formObj.run_opt[4].checked==true){
				if(formObj.ar_ofc_cd.text == ""){
					ComShowCodeMessage("INV00004");
					formObj.ar_ofc_cd.focus();
					return;
				}
				
				if(formObj.fm_if_dt.value==""||formObj.to_if_dt.value==""){
					ComShowCodeMessage("INV00004");
					formObj.fm_if_dt.focus();
					return;
				}
	
				if(ComGetDaysBetween(formObj.fm_if_dt.value,formObj.to_if_dt.value)>14){
					ComShowCodeMessage("INV00043");
					formObj.to_if_dt.focus();
					return;
				}
	
				if(formObj.inv_cust_cnt_cd.value==""||formObj.inv_cust_seq.value==""){
					ComShowCodeMessage("INV00004");
					formObj.inv_cust_cnt_cd.focus();
					return;
				}
			}else{
				if(formObj.ar_ofc_cd.text == ""){
					ComShowCodeMessage("INV00004");
					formObj.ar_ofc_cd.focus();
					return;
				}
				
				valCnt = 0;
				for(i=1;i<sheetObjects[3].RowCount+1;i++){
					if(sheetObjects[3].CellValue(i,"bl_src_no")!="") valCnt = valCnt+1;
				}
	
				if(valCnt==0){
					ComShowCodeMessage("INV00004");
					sheetObjects[2].SelectCell(1,"bl_src_no");
					return;
				}
	
				dupRow = sheetObjects[3].ColValueDup("bl_src_no");
	
				if(dupRow!="-1" && sheetObjects[3].CellValue(dupRow,"bl_src_no")!=""){
					ComShowCodeMessage("INV00052");
					fndRow = sheetObjects[2].FindText("bl_src_no",sheetObjects[3].CellValue(dupRow,"bl_src_no"));
					fndRow2 = sheetObjects[2].FindText("bl_src_no2",sheetObjects[3].CellValue(dupRow,"bl_src_no"));
					if(fndRow!='-1'){
						sheetObjects[2].SelectCell(fndRow,"bl_src_no");
					}
					if(fndRow2!='-1'){
						sheetObjects[2].SelectCell(fndRow2,"bl_src_no2");
					}
	
					return;
				}
			}
			break;
			}
		}     
	
		return true;
	}
	
	/**
	 * sheet1 에서 TAB키 입력시 20개까지 행생성 해주는 함수<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *   sheet1_OnKeyDown(sheetObjects[0],1, 1,'1');
	 * </pre>
	 * @param object sheetObj
	 * @param number Row
	 * @param number Col
	 * @param number KeyCode
	 * @param boolean Shift
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
	function sheet1_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift) {
		//2009.10.19 스펙변경으로 일단 주석처리.
		/*
	    	 if(Row>4&&Row<20&&sheetObj.RowCount<20&&Col==2&&KeyCode==9){
				sheetObj.DataInsert(-1);
			}
		 */
	}
	
	/**
	 * 콤보 생성<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    MakeComboObject2(formObj.ar_ofc_cd, arrStr);
	 * </pre>
	 * @param object cmbObj
	 * @param String arrStr
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
	function MakeComboObject2(cmbObj, arrStr) {
		for (var i = 1; i < arrStr.length;i++ ) {
			var arrStr2 = arrStr[i].split("^");
			var ar_ofc_cd = arrStr2[1];
			cmbObj.InsertItem(i-1, ar_ofc_cd, arrStr[i]);			 
		}
	
		cmbObj.DropHeight = 190;
	}
	 
	 /**
	 * 콤보 생성<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    MakeComboObject3(formObj, formObj.ar_ofc_cd, arrStr);
	 * </pre>
	 * @param object formObj
	 * @param object cmbObj
	 * @param String arrStr
	 * @author	Kwon Min
	 * @version 2011.10.24
	 */
	function MakeComboObject3(formObj, cmbObj, arrStr) {
		/*
		for (var i = 1; i < arrStr.length;i++ ) {
			var arrStr2 = arrStr[i].split("^");
			var ar_ofc_cd = arrStr2[1];
			cmbObj.InsertItem(i-1, ar_ofc_cd, arrStr[i]);			 
		}
	
		cmbObj.DropHeight = 190;
		*/
		
		with (cmbObj) { 
	 		RemoveAll();
			MultiSelect = true;
			SetColWidth("95");
			ValidChar(2, 2); // 영대문자, 특수문자만 가능
 		}
  		
		//var usrOfcCd = ComGetObjValue(formObj.usr_ofc_cd);
			
		// 로그인 Office가 멀티콤보 리스트에 없을 경우, 리스트 최상단에 추가
		/*if(data.indexOf(usrOfcCd) == -1) {
			comboObj.InsertItem(0, usrOfcCd, usrOfcCd);
			idx = 1;
		}*/
		arrStr	= "ALL|"+arrStr;
	    var comboItems	= arrStr.split("|");
	    
	    //cmbObj.InsertItem(0, 'ALL', 'ALL');
	    
	    //var usrOfcCd = ComGetObjValue(formObj.usr_ofc_cd);
	    
	    for (var i=0 ; i < comboItems.length ; i++) {
	    	cmbObj.InsertItem(i, comboItems[i], comboItems[i]);
     	}
	    
	    //cmbObj.Code = usrOfcCd;
  		// 로그인 User Office를 Default로 설정
  		//comboObj.Code = usrOfcCd;
	}
	
	/**
	 * 콤보박스 ar_ofc_cd 데이터 변경시 실행되는 function<br>
	 * 해당 office 세팅<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *   ar_ofc_cd_OnChange(document.form,'HAMBB','HAMBB');
	 * </pre>
	 * @param object comboObj
	 * @param string value
	 * @param string text
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */	
	function ar_ofc_cd_OnChange(comboObj,value,text){ 
		arrStr = value.split("^");
		//document.form.ofc.value = arrStr[1];
		//document.form.ofc_cd.value = arrStr[1];
		document.form.ofc.value = arrStr;
		document.form.ofc_cd.value = arrStr;
	}
	 
	//AR Office Code IBMultiCombo 클릭 이벤트 처리
	function ar_ofc_cd_OnCheckClick(comboObj, index, code) {
	    if(index==0) {
	    	var bChk = comboObj.CheckIndex(index);
    		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
    			comboObj.CheckIndex(i) = bChk;
	    	}
	    } else if(comboObj.CheckIndex(0)) {
			comboObj.CheckIndex(0) = false;
	    } 
	}
	
	/**
	 * fm_if_dt,to_if_dt 변경시 날짜 유형 체크 후 masked value 세팅<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *   fn_ComGetMaskedValue('fm_if_dt');
	 * </pre>
	 * @param String elNm
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
	function fn_ComGetMaskedValue(elNm) {
	
		var formObj;
	
		if (elNm == "fm_if_dt") {
			formObj = form.fm_if_dt;
		} else {
			formObj = form.to_if_dt;
		}
		var value = formObj.value;
	
		if(value=="") return;
		value = ComReplaceStr(value,"-","");
		if (value.length < 8) {
			ComShowCodeMessage("INV00024");
			return;
		} 
	
		if (value.substring(4,6) > 12) {
			ComShowCodeMessage("INV00024");
			return;
		} 
		if (value.substring(4,6) == 00) {
			ComShowCodeMessage("INV00024");
			return;
		} 
		if (value.substring(6,8) > 31) {
			ComShowCodeMessage("INV00024");
			return;
		} 
		if (value.substring(6,8) == 00) {
			ComShowCodeMessage("INV00024");
			return;
		} 
		var ret = ComGetMaskedValue(value, "ymd")  ; 
		formObj.value = ret;
		
		if(elNm == "fm_if_dt"){
			if(form.to_if_dt.value==""){
				form.to_if_dt.value = ret;
			}
			form.to_if_dt.select(); 
		}
	}
	/**
	 * 라디오버튼 선택시 유형에 따라 화면 세팅<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *   chkOption('N');
	 * </pre>
	 * @param String checkedVal
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
	function chkOption(checkedVal){
		 if(checkedVal=="N" || checkedVal=="P"){
			sheetObjects[0].RemoveAll();
			sheetObjects[0].DataInsert(-1);
			sheetObjects[0].DataInsert(-1);
			sheetObjects[0].DataInsert(-1);
			sheetObjects[0].DataInsert(-1);
			sheetObjects[0].DataInsert(-1);
			sheetObjects[0].CellValue(1,1) = '1';
			sheetObjects[0].CellValue(2,1) = '3';
			sheetObjects[0].CellValue(3,1) = '5';
			sheetObjects[0].CellValue(4,1) = '7';
			sheetObjects[0].CellValue(5,1) = '9';			
			sheetObjects[0].CellValue(1,3) = '2';
			sheetObjects[0].CellValue(2,3) = '4';
			sheetObjects[0].CellValue(3,3) = '6';
			sheetObjects[0].CellValue(4,3) = '8';
			sheetObjects[0].CellValue(5,3) = '10';
			sheetObjects[0].RowEditable(1)= false;
			sheetObjects[0].RowEditable(2)= false;
			sheetObjects[0].RowEditable(3)= false;
			sheetObjects[0].RowEditable(4)= false;
			sheetObjects[0].RowEditable(5)= false;
			//sheetObjects[0].Editable=false;
	
			sheetObjects[2].RemoveAll();
			sheetObjects[2].DataInsert(-1);
			sheetObjects[2].DataInsert(-1);
			sheetObjects[2].DataInsert(-1);
			sheetObjects[2].DataInsert(-1);
			sheetObjects[2].DataInsert(-1);
			sheetObjects[2].CellValue(1,1) = '1';
			sheetObjects[2].CellValue(2,1) = '3';
			sheetObjects[2].CellValue(3,1) = '5';
			sheetObjects[2].CellValue(4,1) = '7';
			sheetObjects[2].CellValue(5,1) = '9';			
			sheetObjects[2].CellValue(1,3) = '2';
			sheetObjects[2].CellValue(2,3) = '4';
			sheetObjects[2].CellValue(3,3) = '6';
			sheetObjects[2].CellValue(4,3) = '8';
			sheetObjects[2].CellValue(5,3) = '10';
			sheetObjects[2].RowEditable(1)= false;
			sheetObjects[2].RowEditable(2)= false;
			sheetObjects[2].RowEditable(3)= false;
			sheetObjects[2].RowEditable(4)= false;
			sheetObjects[2].RowEditable(5)= false;
	
			ComShowObject(document.form.btns_calendar1,true);
			ComShowObject(document.form.btns_calendar2,true);
			document.form.fm_if_dt.disabled=false;
			document.form.to_if_dt.disabled=false;
			document.form.io_bnd_cd.disabled=true;
			document.form.fm_if_dt.className = "input1";
			document.form.to_if_dt.className = "input1";	
	
			document.form.inv_cust_cnt_cd.disabled=true;
			document.form.inv_cust_seq.disabled=true;
			document.form.inv_cust_cnt_cd.value="";
			document.form.inv_cust_seq.value="";
			document.form.cust_lgl_eng_nm.value="";
			document.form.inv_cust_cnt_cd.className = "input2";
			document.form.inv_cust_seq.className = "input2";
			ComShowObject(document.form.btn_invcust,false);
			ComShowObject(document.form.btn_custNm,false);
			document.all.dt_name.innerHTML ="&nbsp;&nbsp;Interface Date";
			
			sheetObjects[4].RemoveAll();
			ComBtnDisable("btn_downexcel");
			form.tot_cnt.value = "";
			form.good_cnt.value  = "";
			form.no_good_cnt.value  = "";
		}else if(checkedVal=="V"){
	
			sheetObjects[2].RemoveAll();
			sheetObjects[2].DataInsert(-1);
			sheetObjects[2].DataInsert(-1);
			sheetObjects[2].DataInsert(-1);
			sheetObjects[2].DataInsert(-1);
			sheetObjects[2].DataInsert(-1);
			sheetObjects[2].CellValue(1,1) = '1';
			sheetObjects[2].CellValue(2,1) = '3';
			sheetObjects[2].CellValue(3,1) = '5';
			sheetObjects[2].CellValue(4,1) = '7';
			sheetObjects[2].CellValue(5,1) = '9';			
			sheetObjects[2].CellValue(1,3) = '2';
			sheetObjects[2].CellValue(2,3) = '4';
			sheetObjects[2].CellValue(3,3) = '6';
			sheetObjects[2].CellValue(4,3) = '8';
			sheetObjects[2].CellValue(5,3) = '10';
			sheetObjects[2].RowEditable(1)= false;
			sheetObjects[2].RowEditable(2)= false;
			sheetObjects[2].RowEditable(3)= false;
			sheetObjects[2].RowEditable(4)= false;
			sheetObjects[2].RowEditable(5)= false;
	
			sheetObjects[0].RemoveAll();
			sheetObjects[0].DataInsert(-1);
			sheetObjects[0].DataInsert(-1);
			sheetObjects[0].DataInsert(-1);
			sheetObjects[0].DataInsert(-1);
			sheetObjects[0].DataInsert(-1);
			sheetObjects[0].CellValue(1,1) = '1';
			sheetObjects[0].CellValue(2,1) = '3';
			sheetObjects[0].CellValue(3,1) = '5';
			sheetObjects[0].CellValue(4,1) = '7';
			sheetObjects[0].CellValue(5,1) = '9';			
			sheetObjects[0].CellValue(1,3) = '2';
			sheetObjects[0].CellValue(2,3) = '4';
			sheetObjects[0].CellValue(3,3) = '6';
			sheetObjects[0].CellValue(4,3) = '8';
			sheetObjects[0].CellValue(5,3) = '10';
			sheetObjects[0].Editable=true;
	
			sheetObjects[0].ColBackColor(2) = sheetObjects[0].WebColor("#CCFFFD");
			sheetObjects[0].ColBackColor(4) = sheetObjects[0].WebColor("#CCFFFD");
	
			ComShowObject(document.form.btns_calendar1,false);
			ComShowObject(document.form.btns_calendar2,false);
			document.form.fm_if_dt.disabled=true;
			document.form.to_if_dt.disabled=true;
			document.form.fm_if_dt.value="";
			document.form.to_if_dt.value="";
			document.form.io_bnd_cd.disabled=false;
			document.form.fm_if_dt.className = "input2";
			document.form.to_if_dt.className = "input2";
	
			document.form.inv_cust_cnt_cd.disabled=true;
			document.form.inv_cust_seq.disabled=true;
			document.form.inv_cust_cnt_cd.value="";
			document.form.inv_cust_seq.value="";
			document.form.cust_lgl_eng_nm.value="";
			document.form.inv_cust_cnt_cd.className = "input2";
			document.form.inv_cust_seq.className = "input2";	
			ComShowObject(document.form.btn_invcust,false);
			ComShowObject(document.form.btn_custNm,false);
			document.all.dt_name.innerHTML ="&nbsp;&nbsp;Interface Date";
			
			sheetObjects[4].RemoveAll();
			ComBtnDisable("btn_downexcel");
			form.tot_cnt.value = "";
			form.good_cnt.value  = "";
			form.no_good_cnt.value  = "";
		}else if(checkedVal=="C" || checkedVal=="O"){//2012.03.21 [CHM-201216481] ON BOARD DATE value 조건 추가
			sheetObjects[0].RemoveAll();
			sheetObjects[0].DataInsert(-1);
			sheetObjects[0].DataInsert(-1);
			sheetObjects[0].DataInsert(-1);
			sheetObjects[0].DataInsert(-1);
			sheetObjects[0].DataInsert(-1);
			sheetObjects[0].CellValue(1,1) = '1';
			sheetObjects[0].CellValue(2,1) = '3';
			sheetObjects[0].CellValue(3,1) = '5';
			sheetObjects[0].CellValue(4,1) = '7';
			sheetObjects[0].CellValue(5,1) = '9';			
			sheetObjects[0].CellValue(1,3) = '2';
			sheetObjects[0].CellValue(2,3) = '4';
			sheetObjects[0].CellValue(3,3) = '6';
			sheetObjects[0].CellValue(4,3) = '8';
			sheetObjects[0].CellValue(5,3) = '10';
			sheetObjects[0].RowEditable(1)= false;
			sheetObjects[0].RowEditable(2)= false;
			sheetObjects[0].RowEditable(3)= false;
			sheetObjects[0].RowEditable(4)= false;
			sheetObjects[0].RowEditable(5)= false;
			//sheetObjects[0].Editable=false;
	
			sheetObjects[2].RemoveAll();
			sheetObjects[2].DataInsert(-1);
			sheetObjects[2].DataInsert(-1);
			sheetObjects[2].DataInsert(-1);
			sheetObjects[2].DataInsert(-1);
			sheetObjects[2].DataInsert(-1);
			sheetObjects[2].CellValue(1,1) = '1';
			sheetObjects[2].CellValue(2,1) = '3';
			sheetObjects[2].CellValue(3,1) = '5';
			sheetObjects[2].CellValue(4,1) = '7';
			sheetObjects[2].CellValue(5,1) = '9';			
			sheetObjects[2].CellValue(1,3) = '2';
			sheetObjects[2].CellValue(2,3) = '4';
			sheetObjects[2].CellValue(3,3) = '6';
			sheetObjects[2].CellValue(4,3) = '8';
			sheetObjects[2].CellValue(5,3) = '10';
			sheetObjects[2].RowEditable(1)= false;
			sheetObjects[2].RowEditable(2)= false;
			sheetObjects[2].RowEditable(3)= false;
			sheetObjects[2].RowEditable(4)= false;
			sheetObjects[2].RowEditable(5)= false;
	
			ComShowObject(document.form.btns_calendar1,true);
			ComShowObject(document.form.btns_calendar2,true);
			document.form.fm_if_dt.disabled=false;
			document.form.to_if_dt.disabled=false;
			document.form.io_bnd_cd.disabled=true;
			document.form.fm_if_dt.className = "input1";
			document.form.to_if_dt.className = "input1";	
	
			document.form.inv_cust_cnt_cd.disabled=false;
			document.form.inv_cust_seq.disabled=false;
			document.form.inv_cust_cnt_cd.className = "input1";
			document.form.inv_cust_seq.className = "input1";	
			ComShowObject(document.form.btn_invcust,true);
			ComShowObject(document.form.btn_custNm,true);
			document.all.dt_name.innerHTML = "&nbsp;&nbsp;Ex.Rate Appl. Date";	
			
			sheetObjects[4].RemoveAll();
			ComBtnDisable("btn_downexcel");
			form.tot_cnt.value = "";
			form.good_cnt.value  = "";
			form.no_good_cnt.value  = "";
		}else{
			sheetObjects[0].RemoveAll();
			sheetObjects[0].DataInsert(-1);
			sheetObjects[0].DataInsert(-1);
			sheetObjects[0].DataInsert(-1);
			sheetObjects[0].DataInsert(-1);
			sheetObjects[0].DataInsert(-1);
			sheetObjects[0].CellValue(1,1) = '1';
			sheetObjects[0].CellValue(2,1) = '3';
			sheetObjects[0].CellValue(3,1) = '5';
			sheetObjects[0].CellValue(4,1) = '7';
			sheetObjects[0].CellValue(5,1) = '9';			
			sheetObjects[0].CellValue(1,3) = '2';
			sheetObjects[0].CellValue(2,3) = '4';
			sheetObjects[0].CellValue(3,3) = '6';
			sheetObjects[0].CellValue(4,3) = '8';
			sheetObjects[0].CellValue(5,3) = '10';
			sheetObjects[0].RowEditable(1)= false;
			sheetObjects[0].RowEditable(2)= false;
			sheetObjects[0].RowEditable(3)= false;
			sheetObjects[0].RowEditable(4)= false;
			sheetObjects[0].RowEditable(5)= false;
	
			document.form.io_bnd_cd.disabled=true;
	
			sheetObjects[2].RemoveAll();
			sheetObjects[2].DataInsert(-1);
			sheetObjects[2].DataInsert(-1);
			sheetObjects[2].DataInsert(-1);
			sheetObjects[2].DataInsert(-1);
			sheetObjects[2].DataInsert(-1);
			sheetObjects[2].CellValue(1,1) = '1';
			sheetObjects[2].CellValue(2,1) = '3';
			sheetObjects[2].CellValue(3,1) = '5';
			sheetObjects[2].CellValue(4,1) = '7';
			sheetObjects[2].CellValue(5,1) = '9';			
			sheetObjects[2].CellValue(1,3) = '2';
			sheetObjects[2].CellValue(2,3) = '4';
			sheetObjects[2].CellValue(3,3) = '6';
			sheetObjects[2].CellValue(4,3) = '8';
			sheetObjects[2].CellValue(5,3) = '10';
			sheetObjects[2].Editable=true;
	
			sheetObjects[2].ColBackColor(2) = sheetObjects[0].WebColor("#CCFFFD");
			sheetObjects[2].ColBackColor(4) = sheetObjects[0].WebColor("#CCFFFD");
	
			ComShowObject(document.form.btns_calendar1,false);
			ComShowObject(document.form.btns_calendar2,false);
			document.form.fm_if_dt.disabled=true;
			document.form.to_if_dt.disabled=true;
			document.form.fm_if_dt.value="";
			document.form.to_if_dt.value="";
			document.form.fm_if_dt.className = "input2";
			document.form.to_if_dt.className = "input2";
	
			document.form.inv_cust_cnt_cd.disabled=true;
			document.form.inv_cust_seq.disabled=true;
			document.form.inv_cust_cnt_cd.value="";
			document.form.inv_cust_seq.value="";
			document.form.cust_lgl_eng_nm.value="";
			document.form.inv_cust_cnt_cd.className = "input2";
			document.form.inv_cust_seq.className = "input2";	
			ComShowObject(document.form.btn_invcust,false);
			ComShowObject(document.form.btn_custNm,false);
			document.all.dt_name.innerHTML ="&nbsp;&nbsp;Interface Date";
			
			sheetObjects[4].RemoveAll();
			ComBtnDisable("btn_downexcel");
			form.tot_cnt.value = "";
			form.good_cnt.value  = "";
			form.no_good_cnt.value  = "";
		}
	}
	
	/**
	 * 선택된 탭의 cust_cnt_cd 자릿수 체크하여  cust_seq로 포커스 이동 시켜주는 함수<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    checkCustLeng('DE');
	 * </pre>
	 * @param string value
	 * @author Choi Do Soon
	 * @version 2009.10.19
	 */
	function checkCustLeng(value){    	  
		 if(value.length==2){
			form.inv_cust_seq.focus(); 
		}
	}
	
	/**
	 * inv_cust_cnt_cd, inv_cust_seq 변경시 실행되는 function<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    fn_inv_cust_chg();
	 * </pre>
	 * @author Choi Do Soon
	 * @version 2009.10.19
	 */
	function fn_inv_cust_chg(){
		 if(form.inv_cust_cnt_cd.value!=''&&form.inv_cust_seq.value!=''){
			form.inv_cust_seq.value = ComLpad(form.inv_cust_seq.value.trim(), 6, "0");			  
			form.cust_cnt_cd.value = form.inv_cust_cnt_cd.value;
			form.cust_seq.value = form.inv_cust_seq.value;
			form.ofc_cd.value = form.ofc.value;
		}
	
		document.form.f_cmd.value = SEARCH03;
		var cust_nm = "";
		if ((form.inv_cust_cnt_cd.value.trim() != "" )&&(form.inv_cust_seq.value.trim() != "")&&(form.inv_cust_seq.value.trim() != "000000")){
			var sXml = sheetObjects[0].GetSearchXml("INVCommonGS.do", FormQueryString(document.form));
			cust_nm = ComGetEtcData(sXml,"cust_eng_nm");
			if (cust_nm == undefined) {
				form.cust_lgl_eng_nm.value="";
				form.inv_cust_seq.value="";
				ComShowCodeMessage("INV00008");
				form.inv_cust_cnt_cd.focus();
				return;   	    		  
			}else{ 	    	  
				form.cust_lgl_eng_nm.value=cust_nm;    
			}
		}
	}
	
	/**
	 * 팝업 (FNS_INV_0086) UI 처리 후 실행되는 function<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    getFNS_INV_0086_1(rowArray, 1, 1);
	 * </pre>
	 * @param String rowArray
	 * @param number row
	 * @param number col
	 * @author Choi Do Soon
	 * @version 2009.10.19
	 */
	function getFNS_INV_0086_1(rowArray, row, col) {    	 
		var colArray = rowArray[0];	
		document.form.inv_cust_cnt_cd.value = colArray[8];
		document.form.inv_cust_seq.value = ComLpad(colArray[9], 6, '0');
		fn_inv_cust_chg();
	}
	
	/**
	 * BackEndJob 관련 Status='3' 이 될때까지 확인한다.<br>
	 *
	 * @return 없음
	 * @see #doActionIBSheet
	 */
	function getBackEndJobStatus() {
		form.f_cmd.value = SEARCH02;
		var sXml = sheetObjects[0].GetSearchXml("FNS_INV_0027GS.do", FormQueryString(form));
		var arrXml = sXml.split("|$$|");
		var jobState = ComGetEtcData(arrXml[0], "jb_sts_flg")
		if(jobState == "3") {
			clearInterval(timer);
			getBackEndJobLoadFile();
			ComOpenWait(false);
			inputReadOnly(1);
	
		} else if(jobState == "4") {
			clearInterval(timer);
			// BackEndJob을 실패 하였습니다.
			ComShowCodeMessage("INV00089");
			ComOpenWait(false);
			inputReadOnly(1);
	
		} else if(jobState == "5") {
			clearInterval(timer);
			// 이미 BackEndJob 결과 파일을 읽었습니다.
			ComShowCodeMessage("INV00090");
			ComOpenWait(false);
			inputReadOnly(1);
	
		}
	}
	
	/**
	 * BackEndJob의 결과가 완료되면 결과를 조회한다.<br>
	 * 
	 * @return 없음
	 * @see #getBackEndJobStatus
	 */
	function getBackEndJobLoadFile() {
		form.f_cmd.value = SEARCH03;
		var sXml = sheetObjects[0].GetSearchXml("FNS_INV_0027GS.do", FormQueryString(form));
		var arrXml = sXml.split("|$$|");
		if(arrXml.length > 0) {
			
			if ( arrXml[0] != null){
				sheetObjects[4].LoadSearchXml(arrXml[0]);
			}
			
			if(ComGetEtcData(sXml,"TRANS_RESULT_KEY")=="S"){
				if(ComGetEtcData(sXml,"tot_cnt")==0){
					form.tot_cnt.value = ComGetEtcData(sXml,"tot_cnt");
					form.good_cnt.value  = ComGetEtcData(sXml,"good_cnt");
					form.no_good_cnt.value  = ComGetEtcData(sXml,"no_good_cnt");	
					//formObj.fm_if_dt.focus();
				}else{
					form.tot_cnt.value = ComGetEtcData(sXml,"tot_cnt");
					form.good_cnt.value  = ComGetEtcData(sXml,"good_cnt");
					form.no_good_cnt.value  = ComGetEtcData(sXml,"no_good_cnt");	
					
					if(form.good_cnt.value > 0){
						ComBtnEnable("btn_downexcel");
					}
				}
			}
	
			form.backendjob_key.value = "";
		}
	}
	
	/**
	 * 조건에 따라 해당 오브젝트의 사용여부를 설정한다.<br>
	 * 
	 * @param {int} flag
	 * @return 없음
	 * @see #getBackEndJobStatus, #doActionIBSheet
	 */
	function inputReadOnly(flag) {
		if(flag == 1) {
			ComBtnEnable("btn_run");
			ComBtnEnable("btn_new");
	
		} else if(flag == 2) {
			ComBtnDisable("btn_run");
			ComBtnDisable("btn_new");       	
		}
	}
	
	/**
	 * 선택된 탭의 fm_dt 자릿수 체크하여  to_dt로 포커스 이동 시켜주는 함수<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    checkCustLeng('20090901');
	 * </pre>
	 * @param string value
	 * @author Choi Do Soon
	 * @version 2009.11.10
	 */
	function checkFmDtLeng(value){    	  
		if(ComTrimAll(value," ", "-", ":").length==8){
			if(form.to_if_dt.value==""){
				form.to_if_dt.value = ComTrimAll(value," ", "-", ":");
			}
			form.to_if_dt.select(); 
		}
	}
	
	/**KEY Event<br>
	 * @author Choi Do Soon
	 * @version 2009.11.10
	 */
	
	function initControl() {
		//Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerFormat('keypress',       'obj_keypress',    form); //- 키보드 입력할때
	}
	
	/**KEY Event<br>
	 * @author Choi Do Soon
	 * @version 2009.11.10
	 */
	
	function obj_keypress(){
		switch(event.srcElement.dataformat){
		case "float":
			//숫자+"."입력하기
			ComKeyOnlyNumber(event.srcElement, ".");
			break;
		case "ymd":
			//숫자+"-"입력하기
			ComKeyOnlyNumber(event.srcElement);
			break;
		case "eng":
			//영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
			ComKeyOnlyAlphabet();
			break;
		case "engdn":
			//영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
			ComKeyOnlyAlphabet('lower');
			break;
		case "engup":
			//영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
			ComKeyOnlyAlphabet('upper');
			break;
		case "num":
			//숫자만입력하기(정수,날짜,시간)
			ComKeyOnlyNumber('num');
			break;
		case "uppernum":
			//영문대+숫자 
			ComKeyOnlyAlphabet('uppernum');
			break;
		default:
			//영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
			ComKeyOnlyAlphabet('upper');
		}
	}
	 
	 /**
	 * 입력된 customer code 로 on board date 를 이용하는 고객인지 체크하는 함수<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    checkOnBoardDateCust();
	 * </pre>
	 * @author Kwon Min
	 * @version 2012.03.21
	 */
	function checkOnBoardDateCust(){    
		if(event.keyCode == 0 || event.keyCode == 9){
			document.form.f_cmd.value = SEARCH17;
			var cng_indiv_cd = "";
			if ((form.inv_cust_cnt_cd.value.trim() != "" )&&(form.inv_cust_seq.value.trim() != "")&&(form.inv_cust_seq.value.trim() != "000000")){
				var sXml = sheetObjects[0].GetSearchXml("INVCommonGS.do", FormQueryString(document.form));
				cng_indiv_cd = ComGetEtcData(sXml,"cng_indiv_cd");
				if (cng_indiv_cd != "B") {
					ComShowCodeMessage("INV00156");
					return false;   	    		  
				}
			}
	 	}else{
	 		return false;
	 	}
		return true;
	}
/* 개발자 작업  끝 */