/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EES_CGM_2075.js
*@FileTitle : M.G.Set Inventory Detail
*Open Issues :
*@LastModifyDate : 2015.06.22
*@LastModifier : Chang Young Kim
*@LastVersion : 1.0
* 2015.06.22 Chang Young Kim
* 1.0 Creation
*@Change history :
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends 
 * @class EES_CGM_2075 : EES_CGM_2075 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function EES_CGM_2075() {
	this.processButtonClick		= tprocessButtonClick;
	this.setSheetObject			= setSheetObject;
	this.loadPage				= loadPage;
	this.initSheet				= initSheet;
	this.initControl			= initControl;
	this.doActionIBSheet		= doActionIBSheet;
	this.setTabObject			= setTabObject;
	this.validateForm			= validateForm;
}
	
/* 개발자 작업	*/

 // 공통전역변수
 var tabObjects = new Array();
 var tabCnt = 0 ;
 var beforetab = 1;

 var sheetObjects = new Array();
 var sheetCnt = 0;

 var comboObjects = new Array();
 var comboCnt = 0;
 
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * @param 없음
	 * @return 없음
	 * @author Chang Young Kim
	 * @version 2015.06.23
	 */
	function processButtonClick() {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
		/*******************************************************/
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch(srcName) {
			
				case "btn_retrieve":
					if(validateForm(sheetObject,formObject,IBSEARCH) != false) {
						doActionIBSheet(sheetObject, formObject, IBSEARCH);
					}
					break;
				
				case "btn_new":
					initControl();
					break;
				
				case "btn_downexcel":
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;
				
				case "btns_eq_no":		// Genset No
					rep_Multiful_inquiry("eq_no");
					break;
				
				case "btns_loc_no":		// Location
					rep_Multiful_inquiry("loc_list");
					break;
				
				case "btn_cntr_mvmt":
					// 버튼이 활성화 되어있을때만 기능
					if (ComIsBtnEnable(srcName)) {
						var sUrl = "/hanjin/EES_CTM_0408.do?" 
							+ "p_cntrno=" + sheetObject.Cellvalue(sheetObject.SelectRow, "cntr_chss").substring(0, 10)
							+ "&check_digit=" + sheetObject.Cellvalue(sheetObject.SelectRow, "cntr_chss").substring(10, 11);
						
						ComOpenPopupWithTarget(sUrl, 1020, 682, "", "0,0", false, "yes");
					}
					break;
				
				case "btn_chss_mvmt":
					// 버튼이 활성화 되어있을때만 기능
					if (ComIsBtnEnable(srcName)) {
						var sUrl = "/hanjin/EES_CGM_1105.do?pgmNo=EES_CGM_1105"
							+ "&eq_no=" + sheetObject.CellValue(sheetObject.SelectRow, "cntr_chss")
							+ "&to_day=" + sheetObject.CellValue(sheetObject.SelectRow, "sts_upd_dt");
						
						ComOpenPopup(sUrl, 1000, 600, "", "1,0", false);
					}
					break;
					
				case "btn_mst_inq":
					// 버튼이 활성화 되어있을때만 기능
					if (ComIsBtnEnable(srcName)) {
						var sUrl = "/hanjin/EES_CGM_2006.do?pgmNo=EES_CGM_2006"
							+ "&eq_no=" + sheetObject.CellValue(sheetObject.SelectRow, "eq_no");
						
						ComOpenPopup(sUrl, 1024, 600, "", "1,0", false);
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
	 * IBSheet Object를 배열로 등록 <br>
	 * @param  {object} sheet_obj	필수
	 * @return 없음
	 * @author Chang Young Kim
	 * @version 2015.06.23
	 */
	function setSheetObject(sheet_obj){
	
		sheetObjects[sheetCnt++] = sheet_obj;
	
	}

	/**
	 * Sheet 기본 설정 및 초기화 <br>
	 * body 태그의 onLoad 이벤트핸들러 구현 <br>
	 * @param  없음
	 * @return 없음
	 * @author Chang Young Kim
	 * @version 2015.06.23
	 */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		// Multi Combo 초기화
		comboObjects[comboCnt++] = document.aciac_div_cd;
		comboObjects[comboCnt++] = document.eq_tpsz_cd;
		comboObjects[comboCnt++] = document.atch_dtch;
		
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k]);
		}
	}

	/**
	 * Sheet 로딩 후 기본 설정 및 초기화 <br>
	 * @param  없음
	 * @return 없음
	 * @author Chang Young Kim
	 * @version 2009.10.20
	 */	 
	function sheet1_OnLoadFinish(sheetObj) {
		sheetObj.WaitImageVisible = false;
		
		// axon event 등록
		axon_event.addListenerFormat('keypress', 'obj_keypress', form);
			
		doActionIBSheet(sheetObjects[0], document.form, IBRESET);
		
		initControl();	
		
		sheetObj.WaitImageVisible = true; 
	}

	/**
	 * Form의 Conrol 를 초기화 시킨다. <br>
	 * @param  없음
	 * @return 없음
	 * @author Chang Young Kim
	 * @version 2015.06.23
	 */
	function initControl(){
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		
		// Form Object 초기화
		with(formObj) {
			loc_cd.value		= "L";
			loc_list.value		= "";
			eq_no.value			= "";
			sty_dys_ov.value	= "";
		}
		
		// Sheet Object 초기화
		sheetObj.RemoveAll();
		
		// 버튼 설정 초기화
		funcBtnCtrl("");
		
		// 초기값 설정
		for(var k=0;k<comboObjects.length;k++){
			comboObjects[k].Index2 = 0;
		}
		
	}


	/**
	 * 시트 초기설정값, 헤더 정의 <br>
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
	 * @param  {object} sheetObj	필수	 Sheet Object
	 * @param  {int} sheetNo		필수 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * @return 없음
	 * @author Chang Young Kim
	 * @version 2015.06.23
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		var sheetID = sheetObj.id;
		switch(sheetID) {
	
		case "sheet1":
			with (sheetObj) {
			
				// 높이 설정
				style.height = 430;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msAll;
				
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 3, 100);
				
				var HeadTitle = "|SEQ|LCC|SCC|M.G.Set No.|Type|Term|AGMT|Active|Damage|Disposal|Attach/Detach\nStatus|Latest\nYard|Status\nUpdate Date|Staying\nDays|CNTR/CHSS|MVMT\nStatus|MVMT\nEvent Date|Attach Date|Attach Time|Attach Yard|Detach Date|Detach Time|Detach Yard|Attach/Detach\nUpdate Date|Attach/Detach\nUpdate Time|Attach/Detach\nUpdate Office|Attach/Detach\nUpdate User Name";
				var headCount = ComCountHeadTitle(HeadTitle);
				
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 6, 0, true);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				// [SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D] 
				InitHeadMode(true, true, true, true, false,false)
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				
				//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "ibflag");
				InitDataProperty(0, cnt++, dtDataSeq, 30, daCenter, true, "Seq");
				InitDataProperty(0, cnt++, dtData, 50,  daCenter, false, "lcc_cd",            false, "", dfNone,	0, false, false);
				InitDataProperty(0, cnt++, dtData, 50,  daCenter, false, "scc_cd",            false, "", dfNone,	0, false, false);
				InitDataProperty(0, cnt++, dtData, 90,  daCenter, false, "eq_no",             false, "", dfNone,	0, false, false);
				InitDataProperty(0, cnt++, dtData, 50,  daCenter, false, "eq_tpsz_cd",        false, "", dfNone,	0, false, false);
				InitDataProperty(0, cnt++, dtData, 50,  daCenter, false, "agmt_lstm_cd",      false, "", dfNone,	0, false, false);
				InitDataProperty(0, cnt++, dtData, 70,  daCenter, false, "agmt_no",           false, "", dfNone,	0, false, false);
				InitDataProperty(0, cnt++, dtData, 70,  daCenter, false, "aciac_div_cd",      false, "", dfNone,	0, false, false);
				InitDataProperty(0, cnt++, dtData, 70,  daCenter, false, "dmg_flg",           false, "", dfNone,	0, false, false);
				InitDataProperty(0, cnt++, dtData, 70,  daCenter, false, "disp_flg",          false, "", dfNone,	0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "atch_dtch",         false, "", dfNone,	0, false, false);
				InitDataProperty(0, cnt++, dtData, 70,  daCenter, false, "lst_yd",            false, "", dfNone,	0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daRight,  false, "sts_upd_dt",        false, "", dfDateYmd,	0, false, false);
				InitDataProperty(0, cnt++, dtData, 70,  daRight,  false, "stay_dys",          false, "", dfInteger,	0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cntr_chss",         false, "", dfNone,	0, false, false);
				InitDataProperty(0, cnt++, dtData, 70,  daCenter, false, "chss_mvmt_sts_cd",  false, "", dfNone,	0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daRight,  false, "chss_mvmt_dt",      false, "", dfDateYmd,	0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daRight,  false, "atch_dt_ymd",       false, "", dfDateYmd,	0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daRight,  false, "atch_dt_hd",        false, "", dfTimeHm,	0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "atch_yd_cd",        false, "", dfNone,	0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daRight,  false, "dtch_dt_ymd",       false, "", dfDateYmd,	0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daRight,  false, "dtch_dt_hd",        false, "", dfTimeHm,	0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "dtch_yd_cd",        false, "", dfNone,	0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daRight,  false, "upd_dt_ymd",        false, "", dfDateYmd,	0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daRight,  false, "upd_dt_hd",         false, "", dfTimeHm,	0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "ofc_cd",            false, "", dfNone,	0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daLeft,   false, "usr_nm",            false, "", dfNone,	0, false, false);
				
				CountPosition = 2;
				
				EditableColorDiff = false;
			}
			break;
		}
	}
	
	/** 
	 * Combo Object 초기화  <br>
	 * @param  {object} comboObj	필수 Combo Object
	 * @return 없음
	 * @author Chang Young Kim
	 * @version 2015.06.23
	 */ 
	function initCombo(comboObj) {
		switch(comboObj.id) {
				
			case "aciac_div_cd":
				var cnt=0;
				with(comboObj) {
					Code = "";
					Text = "";
					DropHeight = 100;
					MultiSelect = false;
					MaxSelect = 1;		
					UseCode = true;
					Enable = true;
					comboObj.UseAutoComplete = true;
				}
				
				break;
				
			case "eq_tpsz_cd":
				var cnt=0;
				with(comboObj) {
					Code = "";
					Text = "";
					DropHeight = 100;
					MultiSelect = false;
					MaxSelect = 1;
					UseCode = true;
					Enable = true;
					comboObj.UseAutoComplete = true;
					
				}
				
				break;
				
			case "atch_dtch":
				var cnt=0;
				with(comboObj) {
					Code = "";
					Text = "";
					DropHeight = 100;
					MultiSelect = false;
					MaxSelect = 1;		
					UseCode = true;
					Enable = true;
					comboObj.UseAutoComplete = true;
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
	 * @author Chang Young Kim
	 * @version 2015.06.23
	 */
	 function doActionIBSheet(sheetObj,formObj,sAction) {
		 sheetObj.ShowDebugMsg = false;
		 switch(sAction) {
			case IBSEARCH:	  //조회
				// Form Object 값 설정
				formObj.f_cmd.value = SEARCH;
				
				// 조회실행
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);
//				prompt("", FormQueryString(formObj));
				var sXml = sheetObj.GetSearchXml("EES_CGM_2075GS.do" , FormQueryString(formObj));
				sheetObj.LoadSearchXml(sXml);
				ComOpenWait(false);
				 break;
				
			case IBDOWNEXCEL:		//엑셀 다운로드
				sheetObj.SpeedDown2Excel(-1);
				break;
				
			case IBRESET:
				var sXml2 = document.form2.sXml.value;
				var arrXml = sXml2.split("|$$|");
				
				//Type/Size
				if ( arrXml[0] == null ) {return;}
				var vArrayListData = ComCgmXml2ListMap(arrXml[0]);
				var arrStr2 = new Array();
				
				for ( var i = 0; i < vArrayListData.length; i++) {
					vListData = vArrayListData[i];
					arrStr2[i] = vListData["code1"] + "|" + vListData["desc1"];
				}
				
				makeComboObject1(formObj.eq_tpsz_cd, arrStr2, 0, 0, 2);
				
				// Active St. MultiCombo 값 초기화
				var arrActive = new Array();
				arrActive[0] = "Y|Active";
				arrActive[1] = "N|In-active";
				makeComboObject2(document.form.aciac_div_cd, arrActive, 1, 0, 2);
				
				// Attach/Detach 값 초기화
				var arrActive = new Array();
				arrActive[0] = "Attached|Attached";
				arrActive[1] = "Detached|Detached";
				makeComboObject3(document.form.atch_dtch, arrActive, 1, 0, 2);
				
				break;
		}
	}

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
	 * @param  {object} sheetObj	필수	 Sheet Object
	 * @param  {object} formObj	필수 Form Object
	 * @param  {String} sAction	필수 Action Type (IBSEARCH, IBSEARCH_ASYNC01, RDPRINT, IBDOWNEXCEL)
	 * @return {boolean}			false => validation 체크 오류, true => validation 체크 성공
	 * @author Chang Young Kim
	 * @version 2009.07.21
	 */ 
	function validateForm(sheetObj,formObj,sAction){
		// 유저 요청으로 필수조건 해제
//		with(formObj){
//			switch(sAction){
//				case IBSEARCH:
//					if(ComIsEmpty(eq_no.value)){
//						// msgs['CGM10004'] = 'Mandatory field is missing. Please enter({?msg1}).';
//						ComShowCodeMessage('CGM10004',' Genset No ');
//						eq_no.focus();
//						return false;
//					}
//					break;
//			}
//			return true;
//		}
	}
	
	/**
	 * 콜백 함수. <br>
	 * @param	{Array} aryPopupData	필수 Array Object
	 * @param	{Int} row				필수 선택한 Row
	 * @param	{Int} col				필수 선택한 Column
	 * @param	{Int} sheetIdx			필수 Sheet Index
	 * @return	없음
	 * @author	Chang Young Kim
	 * @version	2015.06.22
	 */   
	function callBackEqNo(aryPopupData, row, col, sheetIdx){
			 
		var formObj = document.form;
		var sEqNo = "";
		var i = 0;
		
		for(i = 0; i < aryPopupData.length; i++){
			
			sEqNo = sEqNo + aryPopupData[i][3];
			
			if(i < aryPopupData.length - 1){
				sEqNo = sEqNo + ",";
			}
		}
			 
		formObj.eq_no.value = sEqNo;
			 
	}
	
	/**
	 * Object 의 Keypress 이벤트에 대한 처리  <br>
	 * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
	 * @param  없음
	 * @return 없음
	 * @author Chang Young Kim
	 * @version 2015.06.23
	 */ 
	function obj_keypress(){
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
				if(obj.name == "eq_no" || obj.name == "loc_list") ComKeyOnlyAlphabet('uppernum',"44");
				else ComKeyOnlyAlphabet('upper');
				break;
			case "engdn":
				ComKeyOnlyAlphabet('lower');
				break;
		}
	}
	
	/** 
	 * Combo Object 에 값을 추가하는 처리 <br>
	 * 초기 로딩시 콤보세팅 안되는 스크립트 문제로 펑션을 다수 생성함(3개)
	 * 
	 * @param  {object} cmbObj	필수 Combo Object
	 * @param  {String} arrStr	필수 대상 문자열 (다수의 경우는 '|' 로 구분) 
	 * @param  {int}	txtCol	필수 Combo Text에 표시할 Colume Index 번호
	 * @param  {int}	codeCol	필수 Combo Code 값에 설정할 Column Index 번호
	 * @param  {int}	opt		필수 공백문자 추가여부 (0:추가안함, 1:공백 추가, 2:All 추가)
	 * @return 없음
	 * @author Chang Young Kim
	 * @version 2015.06.23
	 */ 
	function makeComboObject1(cmbObj, arrStr, txtCol, codeCol, opt) {
		cmbObj.RemoveAll();
		
		if(opt == 0) {
			for (var i = 0; i < arrStr.length;i++ ) {
				var arrCode = arrStr[i].split("|");
				cmbObj.InsertItem(i, arrCode[txtCol], arrCode[codeCol]);
			}
		} else if(opt == 1){
			cmbObj.InsertItem(0,"","");
			for (var i = 0; i < arrStr.length;i++ ) {
				var arrCode = arrStr[i].split("|");
				cmbObj.InsertItem(i+1, arrCode[txtCol], arrCode[codeCol]);
			}
		} else if(opt == 2){
			cmbObj.InsertItem(0,"All","");
			for (var i = 0; i < arrStr.length;i++ ) {
				var arrCode = arrStr[i].split("|");
				cmbObj.InsertItem(i+1, arrCode[txtCol], arrCode[codeCol]);
			}
		}
		
		cmbObj.Index2 = "" ;
	}
	function makeComboObject2(cmbObj, arrStr, txtCol, codeCol, opt) {
		cmbObj.RemoveAll();
		
		if(opt == 0) {
			for (var i = 0; i < arrStr.length;i++ ) {
				var arrCode = arrStr[i].split("|");
				cmbObj.InsertItem(i, arrCode[txtCol], arrCode[codeCol]);
			}
		} else if(opt == 1){
			cmbObj.InsertItem(0,"","");
			for (var i = 0; i < arrStr.length;i++ ) {
				var arrCode = arrStr[i].split("|");
				cmbObj.InsertItem(i+1, arrCode[txtCol], arrCode[codeCol]);
			}
		} else if(opt == 2){
			cmbObj.InsertItem(0,"All","");
			for (var i = 0; i < arrStr.length;i++ ) {
				var arrCode = arrStr[i].split("|");
				cmbObj.InsertItem(i+1, arrCode[txtCol], arrCode[codeCol]);
			}
		}
		
		cmbObj.Index2 = "" ;
	}
	function makeComboObject3(cmbObj, arrStr, txtCol, codeCol, opt) {
		cmbObj.RemoveAll();
		
		if(opt == 0) {
			for (var i = 0; i < arrStr.length;i++ ) {
				var arrCode = arrStr[i].split("|");
				cmbObj.InsertItem(i, arrCode[txtCol], arrCode[codeCol]);
			}
		} else if(opt == 1){
			cmbObj.InsertItem(0,"","");
			for (var i = 0; i < arrStr.length;i++ ) {
				var arrCode = arrStr[i].split("|");
				cmbObj.InsertItem(i+1, arrCode[txtCol], arrCode[codeCol]);
			}
		} else if(opt == 2){
			cmbObj.InsertItem(0,"All","");
			for (var i = 0; i < arrStr.length;i++ ) {
				var arrCode = arrStr[i].split("|");
				cmbObj.InsertItem(i+1, arrCode[txtCol], arrCode[codeCol]);
			}
		}
		
		cmbObj.Index2 = "" ;
	}

	/**
	 * rep_Multiful_inquiry 사용시 받는부분
	 * 소스에 붙여서 사용하세요
	 * Location : 팝업에서 단일 선택을 한경우..
	 */
	function getCgm_Multi(rowArray,ret_val) {
		var formObj = document.form;  
		var tempText = ""; 
		
		for(var i=0; i<rowArray.length; i++) {
			var colArray = rowArray[i];
			tempText +=  rowArray[i] + ',';
		}
		
		//마지막에 ,를 없애기 위함
		tempText = CgmDelLastDelim(tempText);
		tempText = tempText.toUpperCase();
		
		eval("document.form." + ret_val + ".value = '" + tempText + "';");
	}
	
	/**
	 * Sheet1 의 OnSearchEnd 이벤트처리 <br>
	 * @param  {object} sheetObj	필수 Sheet Object
	 * @param  {string} ErrMsg		필수 String
	 * @return 없음
	 * @version 2015.06.24
	 */ 
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		
		var sCntrChss = null; // 컨테이너/샤시 구분자
		
		with(sheetObj)
		{
			if(RowCount > 0) { // 조회 결과가 있으면
				sCntrChss = sheetObj.CellValue(1, "cntr_chss").substring(3,4); // 조회 후 최초 SelectRow가 없기 때문에 row를 1로 fix
				
				funcBtnCtrl(sCntrChss); // 버튼 컨트롤
			}
		}
	}
	
	/**
	 * Sheet1의 OnClick 이벤트처리 <br>
	 * @param  {object} sheetObj	Sheet Object
	 * @param  {string} Row			String
	 * @param  {string} Col			String
	 * @param  {string} Value		String
	 * @return 없음
	 * @version 2015.06.24
	 * @author Chang Young Kim
	 */ 
	function sheet1_OnClick(sheetObj, Row, Col, Value) {
		
		var sCntrChss = null; // 컨테이너/샤시 구분자
		
		with(sheetObj)
		{
			if(Row > 0) { // 헤더 제외
				sCntrChss = sheetObj.CellValue(Row, "cntr_chss").substring(3,4);
				
				funcBtnCtrl(sCntrChss); // 버튼 컨트롤
			}
		}
	}
	
	/**
	 * CNTR MVMT, CHSS MVMT, MASTER INQ 버튼 컨트롤<br>
	 * 
	 * @param {string} sCntrChss String : U / Z / Other
	 * @return n/a
	 * @version 2015.06.24
	 * @author Chang Young Kim
	 */
	function funcBtnCtrl(sCntrChss) {
		
		switch(sCntrChss) {
		
		case "Z": // Chassis
			ComBtnDisable("btn_cntr_mvmt");
			ComBtnEnable("btn_chss_mvmt");
			ComBtnEnable("btn_mst_inq");
			break;
		
		case "U": // Container
			ComBtnEnable("btn_cntr_mvmt");
			ComBtnDisable("btn_chss_mvmt");
			ComBtnEnable("btn_mst_inq");
			break;
		
		default:
			ComBtnDisable("btn_cntr_mvmt");
			ComBtnDisable("btn_chss_mvmt");
			ComBtnDisable("btn_mst_inq");
			break;
		} // end switch
	}

/* 개발자 작업  끝 */