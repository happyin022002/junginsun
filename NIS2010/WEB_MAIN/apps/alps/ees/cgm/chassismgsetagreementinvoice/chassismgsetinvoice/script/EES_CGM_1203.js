/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1203.js
*@FileTitle : CPS Payable Charge Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.11
*@LastModifier : 조경완
*@LastVersion : 1.0
* 2013.03.11 조경완 
* 1.0 Creation
* 2014-02-07 JongHee Han Payable Charge Creation Cost Month를 현재월로 Setting
* 2014-05-21 Chang Young Kim 
* 	CHM-201430040 [EES_CGM_1203] Payable Charge Creation_Audit 결과 Update 기능 개발
* 2014-08-20 Chang Young Kim
*  [CHM-201431524] COPS Invoice Audit 시, Charge Creation때, File Import 추가 수정 건
* 2015-04-02 Chang Young Kim
*  [CHM-201431711] COPS Charge Creation - Charge Audit Result & Payable Amount Confirm
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

	/**
	 * @extends 
	 * @class ees_cgm_1203 : ees_cgm_1203 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ees_cgm_1203() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl			= initControl;
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
	var chkRow = 0;
	var delStsCd = "";

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * @param 없음
	 * @return 없음
	 * @author 김창식
	 * @version 2009.07.20
	 */ 
	function processButtonClick(){
//		alert("processButtonClick");
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var comboObjpool = document.combo_pool.Text;
		/*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

				case "btn_Retrieve":
					if(validateForm(sheetObject1,formObject,IBSEARCH) != false) {
						doActionIBSheet(sheetObject1, formObject, IBSEARCH);
					}
					break;

				case "btn_New":
					initControl();
					break;
				
				/* 2014.05.23 Chang Young Kim_Added In accordance with the "CHM-201430040" (S) */
				case "btn_AuditResultUpdate":
					
					var iCheckRow = sheetObject1.CheckedRows("del_chk");
					var sChgSeq = formObject.chg_cre_seq.value;
					var paramRow;
					
					// 체크박스를 선택했는지 확인
					if(iCheckRow > 0){
						
						for(var i = 1; i <= sheetObject1.RowCount; i++){
							if(sheetObject1.CellValue(i, "del_chk") == 1){
								paramRow = i;
							}
						}
						
						// Charge Creation 된 대상건인지 확인
//						alert(sChgSeq);20131211
						if(sChgSeq != ''){
							var paramYear = sheetObject2.CellValue(sheetObject2.SelectRow, "cre_dt").substring(0,4);
							var paramMonth = sheetObject2.CellValue(sheetObject2.SelectRow, "cre_dt").substring(4,6);
							var paramDay = sheetObject2.CellValue(sheetObject2.SelectRow, "cre_dt").substring(6,8);
							
							var costYrmonDtseq = paramYear + "-" + paramMonth + "-" + paramDay;
							
							var param = "?cost_yrmon=" + formObject.cost_yrmon.value;
							param = param + "&vndr_seq=" + formObject.vndr_seq.value;
							param = param + "&chg_cre_seq=" + formObject.chg_cre_seq.value;
							param = param + "&lse_chg_sts_cd=" + formObject.lse_chg_sts_cd.value;
							param = param + "&cost_yrmon_dtseq=" + sheetObject2.CellValue(sheetObject2.SelectRow, "cost_yrmon_seq") + " / " + costYrmonDtseq;
							param = param + "&cost_yrmon_seq=" + sheetObject2.CellValue(sheetObject2.SelectRow, "cost_yrmon_seq");
							param = param + "&agmt_ofc_cty_cd=" + sheetObject2.CellValue(sheetObject2.SelectRow, "agmt_ofc_cty_cd");
							param = param + "&agmt_seq=" + sheetObject2.CellValue(sheetObject2.SelectRow, "agmt_seq");
							param = param + "&agmt_ref_no=" + sheetObject2.CellValue(sheetObject2.SelectRow, "agmt_ref_no");
							param = param + "&inv_no=" + sheetObject2.CellValue(sheetObject2.SelectRow, "inv_no");
							param = param + "&agmt_ver_no=" + sheetObject2.CellValue(sheetObject2.SelectRow, "agmt_ver_no");
							
							// Modal 형태로 Popup 호출.
							var sWinName = "Audit Result Update";
							ComOpenWindowCenter('/hanjin/EES_CGM_1211.do' + param, sWinName, 980, 600, true);
							//ComOpenPopup('/hanjin/EES_CGM_1031.do' + param, 980, 600, 'setCheckBox', '1,0', true, false, 3, 10, 0);
							
							chkRow = paramRow;
							// Retrieve 실행
							//var obj = document.getElementById("btn_Retrieve");
							//obj.fireEvent("onclick");
							doActionIBSheet(sheetObjects[0],formObject,IBSEARCH_ASYNC01);
							
						} else {
							ComShowCodeMessage('CGM10008');
						}
					} else {
						ComShowCodeMessage('CGM10008');
					}
					
					break;
				/* 2014.05.23 Chang Young Kim_Added In accordance with the "CHM-201430040" (E) */
				
				case "btn_InvoiceImportAudit":
					
					var iCheckRow = sheetObject1.CheckedRows("del_chk");
					var sChgSeq = formObject.chg_cre_seq.value;
					var paramRow;
					
//					// 체크박스를 선택했는지 확인
					if(iCheckRow > 0){
						if(parseInt(sheetObject1.CellValue(sheetObject1.SelectRow, "inv_cnt"), 10) > 0){
							if(!ComShowCodeConfirm('CGM20076')){
								return;
							}
						}
						
						if(sheetObject1.CellValue(sheetObject1.SelectRow, "lst_ver_flg") != 'Y'){
							if(!ComShowCodeConfirm('CGM20089')){
								return;
							}
						}						
//						
//						// Charge Creation 된 대상건인지 확인
//						if(sChgSeq != ''){
							for(var i = 1; i <= sheetObject1.RowCount; i++){
								if(sheetObject1.CellValue(i, "del_chk") == 1){
									paramRow = i;
								}
							}

							var param = "?cost_yrmon=" + formObject.cost_yrmon.value;
							param = param + "&vndr_seq=" + formObject.vndr_seq.value;
							param = param + "&chss_pool_cd=" + formObject.chss_pool_cd.value;
							param = param + "&agmt_ofc_cty_cd=" + sheetObject1.CellValue(paramRow, "agmt_ofc_cty_cd");
							param = param + "&agmt_seq=" + sheetObject1.CellValue(paramRow, "agmt_seq");
							param = param + "&agmt_ref_no=" + sheetObject1.CellValue(paramRow, "agmt_ref_no");
							param = param + "&agmt_ver_no=" + sheetObject1.CellValue(paramRow, "agmt_ver_no");
							
							// Modal 형태로 Popup 호출.
							var sWinName = "Invoice Import And Audit";
							ComOpenWindowCenter('/hanjin/EES_CGM_1204.do' + param, sWinName, 980, 550, true);
							
							chkRow = paramRow;
							// Retrieve 실행
							//var obj = document.getElementById("btn_Retrieve");
							//obj.fireEvent("onclick");
							doActionIBSheet(sheetObjects[0],formObject,IBSEARCH_ASYNC01);
//						} else {
//							ComShowCodeMessage('CGM10008');
//						}
					} else {
						ComShowCodeMessage('CGM10008');
					}
					
					break;
					
				case "btn_AuditResultCreation":
					
					var iCheckRow = sheetObject1.CheckedRows("del_chk");
					var sChgSeq = formObject.chg_cre_seq.value;
					var paramRow;
					
					// 체크박스를 선택했는지 확인
					if(iCheckRow > 0){
						
						for(var i = 1; i <= sheetObject1.RowCount; i++){
							if(sheetObject1.CellValue(i, "del_chk") == 1){
								paramRow = i;
							}
						}
						
						// Charge Creation 된 대상건인지 확인
//						alert(sChgSeq);20131211
						if(sChgSeq != ''){
							var paramYear = sheetObject2.CellValue(sheetObject2.SelectRow, "cre_dt").substring(0,4);
							var paramMonth = sheetObject2.CellValue(sheetObject2.SelectRow, "cre_dt").substring(4,6);
							var paramDay = sheetObject2.CellValue(sheetObject2.SelectRow, "cre_dt").substring(6,8);
							
							var costYrmonDtseq = paramYear + "-" + paramMonth + "-" + paramDay;
							
							var param = "?cost_yrmon=" + formObject.cost_yrmon.value;
							param = param + "&vndr_seq=" + formObject.vndr_seq.value;
							param = param + "&chg_cre_seq=" + formObject.chg_cre_seq.value;
							param = param + "&lse_chg_sts_cd=" + formObject.lse_chg_sts_cd.value;
							param = param + "&cost_yrmon_dtseq=" + sheetObject2.CellValue(sheetObject2.SelectRow, "cost_yrmon_seq") + " / " + costYrmonDtseq;
							param = param + "&cost_yrmon_seq=" + sheetObject2.CellValue(sheetObject2.SelectRow, "cost_yrmon_seq");
							param = param + "&agmt_ofc_cty_cd=" + sheetObject2.CellValue(sheetObject2.SelectRow, "agmt_ofc_cty_cd");
							param = param + "&agmt_seq=" + sheetObject2.CellValue(sheetObject2.SelectRow, "agmt_seq");
							param = param + "&agmt_ref_no=" + sheetObject2.CellValue(sheetObject2.SelectRow, "agmt_ref_no");
							param = param + "&inv_no=" + sheetObject2.CellValue(sheetObject2.SelectRow, "inv_no");
							param = param + "&agmt_ver_no=" + sheetObject2.CellValue(sheetObject2.SelectRow, "agmt_ver_no");
							param = param + "&chss_cop_inv_tp_cd=" + sheetObject2.CellValue(sheetObject2.SelectRow, "chss_cop_inv_tp_cd");
							
							// 하단 그리드의 Invoice Typr의 텍스트를 가져온다.
							var sInvTp = sheetObject2.GetComboInfo(sheetObject2.SelectRow, "chss_cop_inv_tp_cd", "Text");
							// 배열로 구성
							var arrInvTp = sInvTp.split("|");
							// Invoice Type Code의 현재 선택된 인덱스를 가져온다
							var idxInvTp = sheetObject2.GetComboInfo(sheetObject2.SelectRow, "chss_cop_inv_tp_cd", "SelectedIndex");

							param = param + "&chss_cop_inv_tp_nm=" + arrInvTp[idxInvTp];;
							
							// Modal 형태로 Popup 호출.
							var sWinName = "Payable Charge Audit Result And Payable Amount Confirm";
							ComOpenWindowCenter('/hanjin/EES_CGM_1205.do' + param, sWinName, 980, 620, true);
							//ComOpenPopup('/hanjin/EES_CGM_1031.do' + param, 980, 600, 'setCheckBox', '1,0', true, false, 3, 10, 0);
							
							chkRow = paramRow;
							// Retrieve 실행
							//var obj = document.getElementById("btn_Retrieve");
							//obj.fireEvent("onclick");
							doActionIBSheet(sheetObjects[0],formObject,IBSEARCH_ASYNC01);
							
						} else {
							ComShowCodeMessage('CGM10008');
						}
					} else {
						ComShowCodeMessage('CGM10008');
					}
					break;
						
				case "btn_Delete":
					if(validateForm(sheetObject1,formObject,IBDELETE) != false) {
						doActionIBSheet(sheetObject1, formObject, IBDELETE);
					}
					break;
					
				case "btns_cost_yrmon":
					var cal = new ComCalendar();
					cal.setDisplayType('month');
					cal.select(formObject.cost_yrmon, "yyyyMM");
					
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
	 * IBSheet Object를 배열로 등록 <br>
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
	 * @param  {object} sheetObj	필수
	 * @return 없음
	 * @author 김창식
	 * @version 2009.07.20
	 */
	function setSheetObject(sheet_obj){
//		alert("setSheetObject");
		sheetObjects[sheetCnt++] = sheet_obj;
		
	}

	/**
	 * Sheet 기본 설정 및 초기화 <br>
	 * body 태그의 onLoad 이벤트핸들러 구현 <br>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다 <br>
	 * @param  없음
	 * @return 없음
	 * @author 김창식
	 * @version 2009.05.28
	 */
	function loadPage() {
//		alert("loadPage");
		for(i=0;i<sheetObjects.length;i++) {
			
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i] );
			
			initSheet(sheetObjects[i],i+1);
			
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		initControl();
		
		comboObjects[comboCnt++] = document.combo_pool;
		
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k]);
		}
		
		var sXml2 = document.form2.sXml.value;
		var arrXml = sXml2.split("|$$|");
		
		if ( arrXml[1] == null ) {return;}

		var vArrayListData = ComCgmXml2ListMap(arrXml[1]);
		var arrStr1 = new Array();
		var arrStr2 = new Array();
		for ( var i = 0; i < vArrayListData.length; i++) {
			vListData = vArrayListData[i];
			arrStr1[i] = vListData["code1"];
			arrStr2[i] = vListData["code1"];
		}
		// combo control, 결과 문자열, Text Index, Code Index
		//MakeComboObject(formObj.agmt_lstm_cd, arrStr1, 0, 0); 
		MakeComboObject4(document.form.combo_pool, arrStr1, arrStr2);
	}

	function firstDayInPreviousMonth(yourDate) {
//		alert("firstDayInPreviousMonth");
		var d = new Date(yourDate);
		
		// 2014-02-07 JongHee Han Payable Charge Creation Cost Month를 현재월로 Setting
		d.setDate(1);
		d.setMonth(d.getMonth());
		return d;
	}

	function initControl(){
//		alert("initControl");
		/* 기존 버그 '201000'으로 나옴
		// 현재 날짜 가져오기
		// 현재 날짜 이전 월 호출로 변경 (2010.04.12)
		var today   = new Date();
		var year = today.getFullYear();
		var month = today.getMonth();
		var costYrmon = ComLpad(year, 4,"0") + "-" + ComLpad(month, 2,"0");
		*/
		
		// chungpa 20100104 신규 적용
		var d = firstDayInPreviousMonth(new Date()); //firstDayInPreviousMonth(new Date())
		var y = d.getYear();
		
		var m = "";
		// 2014-02-07 JongHee Han Payable Charge Creation Cost Month를 현재월로 Setting => 현재월 X, 전달 O
		var mtmp = d.getMonth(); // getMonth() method는 local time에 따라 명시된 날짜에 대한 달 (0부터 11까지) 을 반환
		
		/*
		 * 2015.01.12 Chang Young Kim : 기존 로직이 1월인 경우 그해의 00월을 가져옴 ex)201500
		 * 따라서 1월인 경우 [전년도12월]로 세팅
		 */ 
		if(mtmp == 0) {						// 1월
			y = y -1; // 전년도
			m = '12'; // 12월
		} else if(mtmp > 0 && mtmp < 10) {	// 2 ~ 10월
			m = '0'+mtmp; // 01 ~ 09
		} else {							// 11 ~ 12월
			m = ''+ mtmp; // 10 ~ 11
		}
		
		var costYrmon = y + "-" + m;
		
		// COST YMO
		document.form.cost_yrmon.value = costYrmon;
		
		// Sheet Object 초기화
		for(var i=0; i < sheetObjects.length; i++){
			sheetObjects[i].RemoveAll();
		}
		
		/* 2014.05.26 Chang Young Kim_Added In accordance with the "CHM-201430040" (S) */
		// Audit Result Update 버튼 비활성화
		ComBtnDisable("btn_AuditResultUpdate");
		/* 2014.05.26 Chang Young Kim_Added In accordance with the "CHM-201430040" (E) */
		// Import & Audit 버튼 비활성화
		ComBtnDisable("btn_InvoiceImportAudit");
		// Audit Result & P.Amt Confirm 비활성화
		ComBtnDisable("btn_AuditResultCreation");
		// Delete 버튼 비활성화
		ComBtnDisable("btn_Delete");
		
		var formObj = document.form;
		
		// axon event 등록
		axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);
		axon_event.addListenerFormat('keydown', 'obj_keydown', formObj);
//		axon_event.addListenerFormat('change', 'obj_change', document.form);		//- 변경될때
		axon_event.addListener('beforeactivate', 'obj_activate', "cost_yrmon");
		axon_event.addListener('beforedeactivate', 'obj_deactivate', "cost_yrmon");
		
	}
	
	/**
	 * 시트 초기설정값, 헤더 정의 <br>
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
	 * @param  {object} sheetObj	필수	 Sheet Object
	 * @param  {int} sheetNo		필수 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * @return 없음
	 * @author 김창식
	 * @version 2009.05.28
	 */
	function initSheet(sheetObj,sheetNo) {
//		alert("initSheet");
		var cnt = 0;

		switch(sheetNo) {
			case 1:	// sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 260;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 3, 100);

					var HeadTitle = "||AGMT No.|Ver.|From|To|Lessor|Lessor Name|Pool|Inv Count||||||";
					var headCount = ComCountHeadTitle(HeadTitle);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false)

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,false,		"ibflag");
					InitDataProperty(0, cnt++ , dtRadioCheck,	50,	daCenter,false,		"del_chk");
					InitDataProperty(0, cnt++ , dtData,			100,daCenter,false,		"agmt_no",			false, "", dfNone,	  0, false, true);
					InitDataProperty(0, cnt++ , dtData,			30,	daCenter,false,		"agmt_ver_no",	    false, "", dfNone,	  0, false, true);
					InitDataProperty(0, cnt++ , dtData,			100,daCenter,false,		"agmt_eff_dt",		false, "", dfUserFormat, 0, false, true);
					InitDataProperty(0, cnt++ , dtData,			100,daCenter,false,		"agmt_exp_dt",		false, "", dfUserFormat, 0, false, true);
					
//					InitDataProperty(0, cnt++ , dtData,			50,	daCenter,false,		"agmt_lstm_cd",		false, "", dfNone,	  0, false, true);
					InitDataProperty(0, cnt++ , dtData,			100,daCenter,false,		"vndr_seq",			false, "", dfNone,	  0, false, true);
					InitDataProperty(0, cnt++ , dtData,			320,daLeft,  false,		"vndr_lgl_eng_nm",	false, "", dfNone,	  0, false, true);
					InitDataProperty(0, cnt++ , dtData,			100,daCenter,false,		"chss_pool_cd"	,	false, "", dfNone,	  0, false, true);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,false,		"inv_cnt",			false, "", dfNone,	  0, false, true);
					
					InitDataProperty(0, cnt++ , dtHidden,		50,	daLeft,  false,		"lse_chg_sts_desc",	false, "", dfNone,	  0, false, true);
					InitDataProperty(0, cnt++ , dtHidden,		30,	daCenter,false,		"lse_chg_sts_cd");
					InitDataProperty(0, cnt++ , dtHidden,		30,	daCenter,false,		"agmt_ofc_cty_cd");
					InitDataProperty(0, cnt++ , dtHidden,		30,	daCenter,false,		"agmt_seq");
					InitDataProperty(0, cnt++ , dtHidden,		30,	daCenter,false,		"agmt_ref_no");
					InitDataProperty(0, cnt++ , dtHidden,		40,	daCenter, true,  	"lst_ver_flg");
					
					InitUserFormat(0, "agmt_eff_dt", "####-##-##", "-" );
					InitUserFormat(0, "agmt_exp_dt", "####-##-##", "-" );
					
					EditableColorDiff = false;
					SelectHighLight = true;
				}
				
				break;
					
			case 2:	  // sheet2 init
				with (sheetObj) {
					// 높이 설정
					style.height = 190;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 2, 1, 3, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(21, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false)

					var HeadTitle	= "|Seq|Last\nVer.|Status|Invoice\nType|Original\nInvoice No|Invoice No|SML|Invoice|Rate Sum\n(A)|Credit Sum\n(B)|Tax Sum\n(C)|Creation\nOffice|User ID|Created\nDate||||||";
					var HeadTitle2	= "|Seq|Last\nVer.|Status|Invoice\nType|Original\nInvoice No|Invoice No|Payable Amount\n(A+C-B)|Request Total|Rate Sum\n(A)|Credit Sum\n(B)|Tax Sum\n(C)|Creation\nOffice|User ID|Created\nDate||||||";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					InitHeadRow(1, HeadTitle2, true);

					//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,	daCenter,false,	"ibflag");
					InitDataProperty(0, cnt++ , dtData,	30,		daCenter, true,  "cost_yrmon_seq",		false, "", dfNone,	0, false, true);
					InitDataProperty(0, cnt++ , dtData,	40,		daCenter, true,  "lst_ver_flg",			false, "", dfNone,	0, false, true);
					InitDataProperty(0, cnt++ , dtData,	160,	daLeft,   true,  "lse_chg_sts_desc",	false, "", dfNone,	0, false, true);
					InitDataProperty(0, cnt++ , dtCombo,100,	daCenter, true,  "chss_cop_inv_tp_cd",	false, "", dfNone,	0, false, true);
					InitDataProperty(0, cnt++ , dtData,	100,	daCenter, true,  "org_inv_no",			false, "", dfNone,	0, false, true);
					InitDataProperty(0, cnt++ , dtData,	100,	daCenter, true,  "inv_no",				false, "", dfNone,	0, false, true);
					InitDataProperty(0, cnt++ , dtData,	110,	daRight,  true,  "pay_lse_chg_amt",		false, "", dfFloat,	2, false, true);
//					InitDataProperty(0, cnt++ , dtData,	120,	daRight,  false, "lse_chg_smry_amt",	false, "", dfFloat,	2, false, true);
					InitDataProperty(0, cnt++ , dtData,	110,	daRight,  false, "inv_smry_amt",		false, "", dfFloat,	2, false, true);
					InitDataProperty(0, cnt++ , dtData,	90,		daRight,  true,  "debit_amt",			false, "", dfFloat,	2, false, true);
					InitDataProperty(0, cnt++ , dtData,	90,		daRight,  true,  "cr_smry_amt",			false, "", dfFloat,	2, false, true);
					InitDataProperty(0, cnt++ , dtData,	90,		daRight,  true,  "tax_smry_amt",		false, "", dfFloat,	2, false, true);
					InitDataProperty(0, cnt++ , dtData,	60,		daCenter, true,  "cre_ofc_cd",			false, "", dfNone,	0, false, true);
					InitDataProperty(0, cnt++ , dtData,	80,		daCenter, true,  "cre_usr_id",			false, "", dfNone,	0, false, true);
					InitDataProperty(0, cnt++ , dtData,	60,		daCenter, true,  "cre_dt",				false, "", dfDateYmd, 0, false, true);
					
					InitDataProperty(0, cnt++ , dtHidden,	50,	daCenter, true,  "lse_chg_sts_cd",		false, "", dfNone,	0, false, true);
					InitDataProperty(0, cnt++ , dtHidden,	95,	daCenter, true,  "chg_cre_seq",			false, "", dfNone, 0, false, true);

					InitDataProperty(0, cnt++ , dtHidden,	95,	daCenter, true,  "agmt_ofc_cty_cd",		false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++ , dtHidden,	95,	daCenter, true,  "agmt_seq",			false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++ , dtHidden,	95,	daCenter, true,  "agmt_ref_no",			false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++ , dtHidden,	95,	daCenter, true,  "agmt_ver_no",			false, "", dfNone, 0, false, true);

					CountPosition  = 0;
					SelectionMode  = smSelectionFree;
					
				}
				break;

		}
	}

	/**
	 * Sheet관련 프로세스 처리 <br>
	 * @param  {object} sheetObj	필수	 Sheet Object
	 * @param  {object} formObj	필수 Form Object
	 * @param  {String} sAction	필수 Action Type
	 * @return 없음
	 * @author 김창식
	 * @version 2009.07.20
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
//		alert("doActionIBSheet");
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {

			case IBSEARCH:		//조회 (Retrieve 버튼을 클릭했을 때)
				formObj.f_cmd.value = SEARCH;
				formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
				formObj.chg_cre_seq.value = '';
				
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);	 	
				var sXml = sheetObj.GetSearchXml("EES_CGM_1203GS.do" , FormQueryString(formObj) ,'',true);

				sheetObjects[0].LoadSearchXml(sXml);
				sheetObjects[1].RemoveAll();
				
				/* 2014.05.26 Chang Young Kim_Added In accordance with the "CHM-201430040" (S) */
				// Audit Result Update 버튼 비활성화
				ComBtnDisable("btn_AuditResultUpdate");
				/* 2014.05.26 Chang Young Kim_Added In accordance with the "CHM-201430040" (E) */
				ComBtnDisable("btn_InvoiceImportAudit");
				// Audit Result & P.Amt Confirm 비활성화
				ComBtnDisable("btn_AuditResultCreation");
				// Audit Result & P.Amt Confirm 비활성화
				ComBtnDisable("btn_Delete");
				ComOpenWait(false);	 	
				break;
				
			case IBSEARCH_ASYNC01:	  //조회 (팝업창을 닫으면서 Retrieve 할때)
				formObj.f_cmd.value = SEARCH;
				formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
				
				var sXml = sheetObj.GetSearchXml("EES_CGM_1203GS.do" , FormQueryString(formObj) ,'',true);
				sheetObjects[0].LoadSearchXml(sXml);
				sheetObjects[1].RemoveAll();
				
				// sheet1 의 click 이벤트를 발생시킨다.
				if(chkRow != 0){
					sheetObjects[0].CellValue2(chkRow, "del_chk") = 1;
				}
				var Col = sheetObjects[0].SaveNameCol("del_chk");
				var Row;
				for(var i=1; i <= sheetObjects[0].RowCount; i++){
					if(sheetObjects[0].cellValue(i,"del_chk") == 1){
						Row = i;
//						sheetObjects[0].cellValue2(i,"del_chk") = 0;
						sheetObjects[0].SelectCell(Row, Col);
						sheet1_OnClick(sheetObjects[0], Row, Col);
						break;
					}
					else{
						/* 2014.05.26 Chang Young Kim_Added In accordance with the "CHM-201430040" (S) */
						// Audit Result Update 버튼 비활성화
						ComBtnDisable("btn_AuditResultUpdate");
						/* 2014.05.26 Chang Young Kim_Added In accordance with the "CHM-201430040" (E) */
						// Import & Audit 버튼 비활성화
						ComBtnDisable("btn_InvoiceImportAudit");
						// Audit Result & P.Amt Confirm 비활성화
						ComBtnDisable("btn_AuditResultCreation");
						// Audit Result & P.Amt Confirm 비활성화
						ComBtnDisable("btn_Delete");
					}
				}
				
				break;

			case IBDELETE:	  // 삭제
				
				var iCheckRow = sheetObj.CheckedRows("del_chk");
				var chgCreSeq = document.form.chg_cre_seq.value;
				
				if(iCheckRow > 0){
					if(chgCreSeq != ''){
						
						var sCheckRow = sheetObjects[1].SelectRow;
//						var arrCheckRows = sCheckRows.split("|");
						
						// Charge Creation 대상 체크 ('H','A','S' 상태)
//						for(var i=0; i<arrCheckRows.length-1; i++){
						var lseChgStsCd = sheetObjects[1].cellValue(sCheckRow,"lse_chg_sts_cd");

						if(lseChgStsCd != 'H' && lseChgStsCd != 'A' && lseChgStsCd != 'S'){
							ComShowCodeMessage('CGM20015', sheetObjects[1].cellValue(sCheckRow,"lse_chg_sts_desc"));
							return;
						}
//						}

				 		sheetObj.WaitImageVisible=false;
				 		ComOpenWait(true);	
				 		
						formObj.f_cmd.value = REMOVE;
						formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;

						var sXml = sheetObjects[1].GetSaveXml("EES_CGM_1203GS.do", FormQueryString(formObj));
						 		
						if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" )
						{
							sheetObjects[1].RemoveAll();
							sheetObjects[0].RemoveAll();
							ComShowCodeMessage('CGM00003');
							doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
						}else{
							ComShowCodeMessage('CGM20032');
						}
						ComOpenWait(false);	
						
						/* 2014.05.26 Chang Young Kim_Added In accordance with the "CHM-201430040" (S) */
						// Audit Result Update 버튼 비활성화
						ComBtnDisable("btn_AuditResultUpdate");
						/* 2014.05.26 Chang Young Kim_Added In accordance with the "CHM-201430040" (E) */
						// Import & Audit 버튼 비활성화
						ComBtnDisable("btn_InvoiceImportAudit");
						// Audit Result & P.Amt Confirm 비활성화
						ComBtnDisable("btn_AuditResultCreation");
						// Audit Result & P.Amt Confirm 비활성화
						ComBtnDisable("btn_Delete");
						
					}
						
				} else {
					ComShowCodeMessage('CGM10008');
				}
				
				break;
				
			case IBSEARCH_ASYNC03:	// pool list Combo 조회
			
				formObj.f_cmd.value = SEARCH02;
				var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj), '', true);

				var cols = ComCgmXml2ComboString(sXml, "code1", "code1");
				ComCgmMakeMultiCombo(formObj.combo_pool, cols[0], cols[1], 1);
				
				break;
				
			case IBSEARCH_ASYNC04:	// CHASSIS COP INVOICE TYPE CODE : Sheet2 Invoice Type dtCombo 조회
				
				formObj.f_cmd.value = SEARCH;
				
				formObj.intg_cd_id.value = COM_CD_TYPE_CD03300;		// 코드Type 설정 ( CHASSIS COP INVOICE TYPE CODE )
				var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj), '', true);
				
				var comboValues = ComGetEtcData(sXml,"comboList");
				
    			addCellComboItem(sheetObj,comboValues,"chss_cop_inv_tp_cd",false);
				
		}
	}

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
	 * @param  {object} sheetObj	필수	 Sheet Object
	 * @param  {object} formObj	필수 Form Object
	 * @param  {String} sAction	필수 Action Type 
	 * @return {boolean}			false => validation 체크 오류, true => validation 체크 성공
	 * @author 김창식
	 * @version 2009.07.20
	 */  
	function validateForm(sheetObj,formObj,sAction){
//		alert("validateForm");
		with(formObj){
			switch(sAction){
				case IBSEARCH:
					if(cost_yrmon.value == ''){
						ComShowCodeMessage('CGM10004','Cost Month');
						cost_yrmon.focus();
						return false;
					} else {
						return true;
					}
					break;
				
				case IBDELETE:
					if(delStsCd == "C"){
						ComShowCodeMessage('CGM20051');
						return false;
					}
					break;
			}
		}

		return true;
	}

	/** 
	 * Object 의 Keydown 이벤트에 대한 처리  <br>
	 * 객체가 agmt_no 일 경우에만 enter 키 발생시 조회실행.  <br>
	 * @param  없음
	 * @return 없음
	 * @author 김창식
	 * @version 2009.07.21
	 */ 
	function obj_keydown(){
//		alert("obj_keydown");
		ComKeyEnter();
	}
		
	/** 
	 * Object 의 Keypress 이벤트에 대한 처리  <br>
	 * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
	 * @param  없음
	 * @return 없음
	 * @author 김창식
	 * @version 2009.07.20
	 */ 
	function obj_keypress(){
//		alert("obj_keypress : " + event.srcElement.name);
		obj = event.srcElement;
		if(obj.dataformat == null) return;

		window.defaultStatus = obj.dataformat;

		switch(obj.dataformat) {
			case "ym": case "ymd":
				ComKeyOnlyNumber(obj);
				break;
			case "int":
				ComKeyOnlyNumber(obj);
				break;
			case "float":
				ComKeyOnlyNumber(obj, "-.");
				break;	
			case "eng":
				ComKeyOnlyAlphabet(); 
				break;
			case "engup":
				ComKeyOnlyAlphabet('upper');
				break;
			case "engdn":
				ComKeyOnlyAlphabet('lower');
				break;
		}
	}
	
	/** 
	 * Object 의 activate 이벤트에 대한 처리  <br>
	 * @param  없음
	 * @return 없음
	 * @author 김창식
	 * @version 2009.07.20
	 */
	function obj_activate(){
//		alert("obj_activate : " + event.srcElement.name);
		ComClearSeparator(event.srcElement);
		ComSetFocus(event.srcElement);
	}
	
	/** 
	 * Object 의 deactivate 이벤트에 대한 처리  <br>
	 * @param  없음
	 * @return 없음
	 * @author 김창식
	 * @version 2009.07.20
	 */
	function obj_deactivate(){
//		alert("obj_deactivate : " + event.srcElement.name);
		if(!ComChkObjValid(event.srcElement)) {
			ComSetFocus(event.srcElement);
		}
	}

	/**
	 * Sheet1 의 OnSaveEnd 이벤트처리 (Charge Creation)<br>
	 * @param  {object} sheetObj	필수	 Sheet Object
	 * @param  {string} ErrMsg		필수 String
	 * @return 없음
	 * @version 2009.07.20
	 */ 
	function sheet1_OnSaveEnd(sheetObj, errMsg) {
//		alert("sheet1_OnSaveEnd");
		if(errMsg =='') {   
			ComShowCodeMessage('CGM00003');
		}
	}
	 
	/**
	 * Sheet1 의 Click 할 경우 선택한 Cell의 값과 동일한 Row를 반전 처리 <br>
	 * @author 김창식
	 * @version 2009.08.18
	 */
	function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH){
//		alert("sheet1_OnClick");
		sheetObj.CellValue2(Row, "del_chk") = 1;
		var formObj = document.form;
		
		
		var vndrSeq			= sheetObj.CellValue(Row, "vndr_seq");
		var chssPoolCd		= sheetObj.CellValue(Row, "chss_pool_cd");
		var agmtOfcCtyCd	= sheetObj.CellValue(Row, "agmt_ofc_cty_cd");
		var agmtSeq			= sheetObj.CellValue(Row, "agmt_seq");
		var agmtVerNo		= sheetObj.CellValue(Row, "agmt_ver_no");

		// 체크처리
//		if(sheetObj.ColSaveName(Col)=='del_chk'){
//			sheetObj.cellValue2(Row,"del_chk") = sheetObj.cellValue(Row,"del_chk") == 0?1:0;
//		}
		
		formObj.vndr_seq.value = vndrSeq;
		formObj.chss_pool_cd.value = chssPoolCd;
		
		// sheet2 데이터 삭제
		sheetObjects[1].RemoveAll();
		
		// Charge Creation 대상
//		if(chgCreSeq == ""){
//			
//			ComBtnDisable("btn_InvoiceImportAudit");
//			ComBtnDisable("btn_AuditResultCreation");
//			ComBtnDisable("btn_Delete");
//			
//			formObj.chg_cre_seq.value = "";
//			
//		// Charge Creation 완료	
//		} else {

			// Invoice Import & Audit Button 비활성화 처리
//			if(sheetObj.ColSaveName(Col)=='del_chk'){
				var iCheckRow = sheetObj.CheckedRows("del_chk");
				var sCheckRows = sheetObj.FindCheckedRow("del_chk");
				var arrCheckRows = sCheckRows.split("|");
				
				// Invoice Import & Audit 대상 ('H' 또는 'A' 상태가 아니면 비활성 처리)
				if(iCheckRow > 0){
					var auditImportBtn = true;
//					for(var i=0; i<arrCheckRows.length-1; i++){
//						var lseChgStsCd = sheetObj.cellValue(arrCheckRows[i],"lse_chg_sts_cd");
//						if(lseChgStsCd != ''){
//							auditImportBtn = false;
//							break;
//						}
//					}
						
//					var deleteBtn = true;
//					var auditResultBtn = true;
//					for(var i=0; i<arrCheckRows.length-1; i++){
//						var lseChgStsCd = sheetObj.cellValue(arrCheckRows[i],"lse_chg_sts_cd");
//						delStsCd = sheetObj.cellValue(arrCheckRows[i],"lse_chg_sts_cd");
//						if(lseChgStsCd != 'H' && lseChgStsCd != 'A' && lseChgStsCd != 'C'){
//							deleteBtn = false;
////							auditResultBtn = false;
//							break;
//						}
//					}
//					
//					for(var i=0; i<arrCheckRows.length-1; i++){
//						var lseChgStsCd = sheetObj.cellValue(arrCheckRows[i],"lse_chg_sts_cd");
//						if(lseChgStsCd != 'S' && lseChgStsCd != 'A' && lseChgStsCd != 'C'){
//							auditResultBtn = false;
//							break;
//						}
//					}
//
					if(auditImportBtn){
						ComBtnEnable("btn_InvoiceImportAudit");
					} else {
						ComBtnDisable("btn_InvoiceImportAudit");
					}
//					
//					if(deleteBtn){
//						ComBtnEnable("btn_Delete");
//					} else {
//						ComBtnDisable("btn_Delete");
//					}
//					
//					if(auditResultBtn){
//						// Audit Result & P.Amt Confirm Button 활성화
//						ComBtnEnable("btn_AuditResultCreation");
//					} else {
//						ComBtnDisable("btn_AuditResultCreation");
//					}
//					ComBtnEnable("btn_AuditResultCreation");
					
				} else {
					// 체크된 것이 없으면 비활성화.
					/* 2014.05.26 Chang Young Kim_Added In accordance with the "CHM-201430040" (S) */
					ComBtnDisable("btn_AuditResultUpdate");
					/* 2014.05.26 Chang Young Kim_Added In accordance with the "CHM-201430040" (E) */
					ComBtnDisable("btn_InvoiceImportAudit");
					ComBtnDisable("btn_AuditResultCreation");
					ComBtnDisable("btn_Delete");
				}
//			}
			
			// Charge Creation 결과 목록 조회
			formObj.f_cmd.value = SEARCH01;
			formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;

			formObj.agmt_ofc_cty_cd.value = agmtOfcCtyCd;
			formObj.agmt_seq.value = agmtSeq;
			/* 2014.08.04 Chang Young Kim Added In accordance with the "미확정 CHM" (S) */
			formObj.agmt_ver_no.value = agmtVerNo;
			/* 2014.08.04 Chang Young Kim Added In accordance with the "미확정 CHM" (E) */
			
//			prompt("1", FormQueryString(formObj)); return;
			var sXml = sheetObj.GetSearchXml("EES_CGM_1203GS.do" , FormQueryString(formObj), '', true );	 	
			sheetObjects[1].LoadSearchXml(sXml);
			
			/* 2014.05.26 Chang Young Kim_Added In accordance with the "CHM-201430040" (S) */
			ComBtnDisable("btn_AuditResultUpdate");
			/* 2014.05.26 Chang Young Kim_Added In accordance with the "CHM-201430040" (E) */
			ComBtnDisable("btn_AuditResultCreation");
			ComBtnDisable("btn_Delete");
//		}

	} 
	
	/**
	 * Created Results 그리드의 OnClick Event
	 * 
	 * lse_chg_sts_cd 코드 상세
	 *  H : Charge created
	 *  A : Invoice File Imported & Audited
	 *  S : P.Amt Confirmed
	 *  C : Invoice Confirmed
	 * 
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
	 * @param CellX
	 * @param CellY
	 * @param CellW
	 * @param CellH
	 */
	function sheet2_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH){

		var formObj = document.form;
		var deleteBtn = true;
//		var auditResultBtn = true;
		
		// 2015.04.07 Chang Young Kim Invoice Confirmed(C) : delete 버튼 비활성화로 변경하여 사용치 않게됨
		delStsCd = sheetObj.cellValue(sheetObj.SelectRow,"lse_chg_sts_cd");
		
		// 2015.04.07 Chang Young Kim Audit Result Update Button Control 추가
		var auditUpdBtn = true;
		
		var chgCreSeq = sheetObj.CellValue(Row,"chg_cre_seq");
		var lseChgStsCd = sheetObj.CellValue(Row, "lse_chg_sts_cd");
		
		// 2015.04.07 Chang Young Kim lseChgStsCd와 같은 내용으로 주석
//		var lseChgStsCd1 = sheetObj.cellValue(sheetObj.SelectRow,"lse_chg_sts_cd");
		
		
		
		/* 2015.04.07 Chang Young Kim 
		 * P.Amt Confirmed(S) : delete 버튼 비활성화
		 * Invoice Confirmed(C) : delete 버튼 활성화 후 validation에서 막음
		 * 따라서  Invoice Confirmed(C) : delete 버튼 비활성화로 변경
		 */
//		if(lseChgStsCd1 != 'H' && lseChgStsCd1 != 'A' && lseChgStsCd1 != 'C'){
		if(lseChgStsCd != 'H' && lseChgStsCd != 'A'){
			deleteBtn = false;
			auditUpdBtn = false;
		}
		
		/* 2015.04.07 Chang Young Kim 
		 * Charge created(H) : "Audit Result & P.Amt Confirm" 버튼 비활성화 
		 * 그러나 CHSS-COPS는 최초 상태 : Invoice File Imported & Audited(A)
		 * 따라서 주석화
		 */
//		var lseChgStsCd2 = sheetObj.cellValue(sheetObj.SelectRow,"lse_chg_sts_cd");
//		if(lseChgStsCd2 != 'S' && lseChgStsCd2 != 'A' && lseChgStsCd2 != 'C'){
//			auditResultBtn = false;
//		}
		// 2015.04.07 Chang Young Kim 하단 그리드 선택시 무조건 활성화
		ComBtnEnable("btn_AuditResultCreation");
		
		
		if(deleteBtn){
			ComBtnEnable("btn_Delete");
		} else {
			ComBtnDisable("btn_Delete");
		}
		
		if(auditUpdBtn){
			/* 2014.05.26 Chang Young Kim_Added In accordance with the "CHM-201430040" (S) */
			// Audit Result Update 버튼 비활성화
			ComBtnEnable("btn_AuditResultUpdate");
			/* 2014.05.26 Chang Young Kim_Added In accordance with the "CHM-201430040" (E) */
			// Audit Result & P.Amt Confirm Button 활성화
//			ComBtnEnable("btn_AuditResultCreation");
		} else {
			/* 2014.05.26 Chang Young Kim_Added In accordance with the "CHM-201430040" (S) */
			// Audit Result Update 버튼 비활성화
			ComBtnDisable("btn_AuditResultUpdate");
			/* 2014.05.26 Chang Young Kim_Added In accordance with the "CHM-201430040" (E) */
//			ComBtnDisable("btn_AuditResultCreation");
		}
		
		formObj.chg_cre_seq.value = chgCreSeq;
		formObj.lse_chg_sts_cd.value = lseChgStsCd;
		
	}

	/** 
	 * MultiCombo 의 초기화  <br>
	 * @param  없음
	 * @return 없음
	 * @author 김창식
	 * @version 2009.09.17
	 */ 
	 function initCombo(comboObj) {
//		alert("initCombo");
		switch(comboObj.id) {
			case "combo_pool":
				with(comboObj) {
					Code = "";
					Text = "";
					DropHeight = 100;
					MultiSelect = false;
					MaxSelect = 1;
					UseCode = true;
					comboObj.UseAutoComplete = true;
					SetColWidth("100");
				}
				break;
			}
	}

	function MakeComboObject4(cmbObj, arrStr, arrStr2) {
		cmbObj.RemoveAll();
		cmbObj.InsertItem(0,"","");
		for (var i = 0; i < arrStr.length;i++ ) {
			var arrCode = arrStr[i].split("|");
			cmbObj.InsertItem(i+1, arrStr[i], arrStr2[i]);
		}
		cmbObj.Index2 = "" ;
	}
	
	
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		with(sheetObj)
		{
			for(var idx = HeaderRows; idx <= LastRow; idx++){
				if(CellValue(idx, "lst_ver_flg") == 'N') {
					RowFontColor(idx) = WebColor("#777777");
				}
			}
		}
	}

	function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
		with(sheetObj)
		{
			for(var idx = HeaderRows; idx <= LastRow; idx++){
				if(CellValue(idx, "lst_ver_flg") == 'N') {
					CellBackColor(idx, "lst_ver_flg") = RgbColor(244, 187, 26);
				}
			}
			
			FocusAfterProcess = false;
		}
	}
	
	/** 
	 * OnLoadFinish 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object        
	 * @return 없음
	 * @see #
	 * @author Chang Young Kim
	 * @version 2009.10.19
	 */
	function sheet2_OnLoadFinish(sheetObj){
		sheetObjects[1].WaitImageVisible = false; 
		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC04);
		sheetObjects[1].WaitImageVisible = true; 
	}
	
	/** 
	 * sheet상에서 데이타를 받아 sheet의 콤보박스에 세팅. <br>
	 * curr_cd : currency code 세팅
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {IBSheet} sheetObj : 시트오브젝트  
	 * @param  {String} comboValues : 세팅할 값
	 * @param  {String} colName : sheet에서 세팅할 컬럼
	 * @return (boolean) isCellCombo : CellComboItem, InitDataCombo
	 * @see #
	 * @author 한동훈
	 * @version 2009.10.19
	 */		
	function addCellComboItem(sheetObj,comboValues,colName,isCellCombo) {
		var sRow = sheetObj.SelectRow;
		var comboTxt = "";
		var comboVal = "";
		var comboItems;
		var comboItem;
		var ROWMARK = "@";
		var FIELDMARK = "|";

//		comboValues = "|"+" "+comboValues;
		if (comboValues != undefined) {
			comboItems = comboValues.split(ROWMARK);
			for (var i = 0 ; i < comboItems.length ; i++) {
				comboItem = comboItems[i].split(FIELDMARK);
				if (comboItem[0] != "") {
					comboVal += comboItem[0];
					comboTxt += comboItem[1];
				}
				if (i < comboItems.length-1) {
					comboVal += FIELDMARK;
					comboTxt += FIELDMARK;
				}				
			}
		}
		
		if (isCellCombo) {
			sheetObj.CellComboItem(sRow,colName,comboTxt,comboVal);
		}
		else {
			sheetObj.InitDataCombo(0,colName,comboTxt,comboVal);
		}
	}
//	 /**
//	 * HTML Control의 onchange 이벤트에서 Validation을 체크한다. <br>
//	 **/
//	function obj_change() {
//		ComChkObjValid(event.srcElement);
//		var obj = event.srcElement;
//		var formObj = document.form;
//		var sheetObj = sheetObjects[0];
//		if (ComTrim(obj.value) != "") {
//			alert(obj.name);3
//			switch (obj.name) {
//				case "cost_yrmon":
//					if(validateForm(sheetObj,formObj,IBSEARCH) != false) {
//						doActionIBSheet(sheetObj, formObj, IBSEARCH);
//					}
//					break;
//			}
//		}
//}
/* 개발자 작업  끝 */