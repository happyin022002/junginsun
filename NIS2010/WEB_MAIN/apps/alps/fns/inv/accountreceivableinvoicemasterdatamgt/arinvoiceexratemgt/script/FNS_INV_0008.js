/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0008.js
*@FileTitle : Ex. Rate Entry by Date
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.04.27 김세일
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
	 * @class fns_inv_0008 : fns_inv_0008 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function fns_inv_0008() {
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
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	var ROWMARK = "|";
	var FIELDMARK = "=";
	
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
		/*******************************************************/
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
	
			switch(srcName) {
	
				case "btn_retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break; 
		
				case "btn_new":
					sheetObjects[0].RemoveAll();
					doActionIBSheet(sheetObjects[0],document.form,IBRESET);
					break; 
		
				case "btn_save":
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
					break;
		
				case "btn_downExcel":
					//hidden 필드 안나오게 수정 2009.08.07 최도순
					sheetObjects[0].Down2Excel(-1,false,false,true,'','',false,false,'',false,"DelChk");
		
					break; 
		
				case "btn_loadExcel":
					sheetObjects[0].LoadExcel();
					break; 
		
				case "btn_add":
					doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
					break;  
		
				case "btn_copy":
					sheetObjects[0].DataCopy();
					break; 
		
				case "btn_del":
					ComRowHideDelete(sheetObjects[0], "DelChk");
		
					break;                                         
		
				case "btns_calendar1": //달력버튼
				var cal = new ComCalendar();
				cal.select(formObject.fm_dt1, 'yyyy-MM-dd');
				break;
		
				case "btns_calendar2": //달력버튼
				var cal = new ComCalendar();
				cal.select(formObject.to_dt1, 'yyyy-MM-dd');
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
		
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01); 	
	
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
	
		switch(sheetNo) {
		case 1:      //sheet1 init
		with (sheetObj) {
	
			// 높이 설정
			style.height = 440;
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
			InitColumnInfo(18, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false,false)
	
			var HeadTitle = "|Sel.|Seq.|From Date|To Date|Bound|Currency|Description|Ex. Rate|Updated By|Updated Date|xch_rt_tp_cd|cust_cnt_cd|cust_seq|ivs_xch_rt|locl_curr_cd|ar_ofc_cd|";
	
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
	
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,  40,    daCenter,  true,    "ibflag");
			InitDataProperty(0, cnt++, dtCheckBox, 40,daCenter, false, "DelChk");  
			InitDataProperty(0, cnt++ , dtSeq,    			 50,   daCenter,  	false,     "Seq");
			InitDataProperty(0, cnt++ , dtPopupEdit, 		 110,  daCenter,  	false,     "fm_dt",   			false,          "",      dfDateYmd,    	0,     false,       true);
			InitDataProperty(0, cnt++ , dtPopupEdit,  	  110,  daCenter,    false,     "to_dt",    			false,          "",      dfDateYmd,    	0,     false,       true);
	
			InitDataProperty(0, cnt++ , dtCombo,    		 90,   daCenter,  	false,     "io_bnd_cd",    			false,          "",      dfNone,     		0,     false,       true);
	
			InitDataProperty(0, cnt++ , dtCombo,    		 90,   daCenter,  	false,     "chg_curr_cd",    	false,          "",      dfNone,     		0,     false,       true);
			InitDataProperty(0, cnt++ , dtData,     		 140,  daLeft,  	  false,     "curr_nm", 	false,          "",      dfNone,      	0,     false,       false);
			InitDataProperty(0, cnt++ , dtData,  		   	 100,  daRight,	    false,     "inv_xch_rt",    		false,          "",      dfNullFloat,   6,     true,       true);
			InitDataProperty(0, cnt++ , dtData,    			 130,  daCenter,  	false,     "upd_usr_id",   	false,          "",      dfNone,      	0,     false,       false);
			InitDataProperty(0, cnt++ , dtData,    			 90,   daCenter,  	false,     "upd_dt",   false,          "",      dfDateYmd,     0,     false,       false);                      
			InitDataCombo(0,  "io_bnd_cd",   "ALL|O/B|I/B",  " |O|I");
	
			InitDataProperty(0, cnt++ , dtHidden,  0,    daCenter,  true,    "xch_rt_tp_cd");
			InitDataProperty(0, cnt++ , dtHidden,  0,    daCenter,  true,    "cust_cnt_cd");
			InitDataProperty(0, cnt++ , dtHidden,  0,    daCenter,  true,    "cust_seq");
			InitDataProperty(0, cnt++ , dtHidden,  0,    daCenter,  true,    "ivs_xch_rt");
			InitDataProperty(0, cnt++ , dtHidden,  0,    daCenter,  true,    "locl_curr_cd");
			InitDataProperty(0, cnt++ , dtHidden,  0,    daCenter,  true,    "ar_ofc_cd");
			InitDataProperty(0, cnt++ , dtHidden,  0,    daCenter,  true,    "pre_inv_xch_rt");
	
			PopupImage  =  "img/btns_calendar.gif";
			InitComboNoMatchText(true);								
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
			var sXml = sheetObj.GetSearchXml("FNS_INV_0008GS.do", FormQueryString(formObj));
			var sStr = ComGetEtcData(sXml,"ar_ofc_cd");
			var arrStr = sStr.split("|");						
		
			MakeComboObject2(formObj.ar_ofc_cd2, arrStr);
		
			var arrStr2 = "";
			var ar_ofc_cd = "";
		
			for(var i=1;i<arrStr.length;i++){
				arrStr2 = arrStr[i].split("^");
				if(arrStr2[1]==arrStr2[3]){
					ar_ofc_cd = arrStr2[1];
		
					formObj.ar_ofc_cd2.text = ar_ofc_cd;
					formObj.ar_ofc_cd.value = ar_ofc_cd;
		
					formObj.ar_ofc_cd_1.value = ar_ofc_cd;
					formObj.locl_curr_cd_1.value = arrStr2[4];
		
					formObj.locl_curr_cd.value = arrStr2[4];
					formObj.ar_ctrl_ofc_cd.value = arrStr2[5];
					formObj.loc_cd.value = arrStr2[6].substring(0,2);	
		
					formObj.xch_rt_tp_cd.value = arrStr2[12];	
					formObj.xch_rt_n3rd_tp_cd.value = arrStr2[19];	
				}
			}
		
			//====== combo list ====================//
			var comboValues = ComGetEtcData(sXml, "currInfo");	
			addCellComboItem(sheetObj,comboValues,"chg_curr_cd",false);						
			//====== combo list ====================//
		
			var ret = ComGetNowInfo("ymd" )      //결과 : 2008-11-01
			formObj.fm_dt1.value = ret;
		
			var lastDay = ComGetLastDay(ComGetNowInfo("yy" ), ComGetNowInfo("mm" ))  //결과 : 29
			formObj.to_dt1.value = ret;
			
			ComOpenWait(false);
			break;
		
		
			case IBSEARCH:      //조회
			
			ComOpenWait(true);
			
			formObj.f_cmd.value = SEARCH01;
			var fm_dt = formObj.fm_dt1.value.split("-");
			var to_dt = formObj.to_dt1.value.split("-");
			formObj.fm_dt.value = fm_dt[0]+fm_dt[1]+fm_dt[2];
			formObj.to_dt.value = to_dt[0]+to_dt[1]+to_dt[2];
			
			var xch_rt_tp_cd = formObj.xch_rt_tp_cd.value;
			
			if(xch_rt_tp_cd!="C" && xch_rt_tp_cd!="D"){
				xch_rt_tp_cd = formObj.xch_rt_n3rd_tp_cd.value;
			}
			
			formObj.xch_rt_tp_cd.value = xch_rt_tp_cd;
			
			sheetObj.DoSearch("FNS_INV_0008GS.do",FormQueryString(formObj));
			
			ComOpenWait(false);
		
			break;
		
			case IBSAVE:        //저장
			if(!validateForm(sheetObj,formObj,sAction)) return;
			ComOpenWait(true);
			formObj.f_cmd.value = MULTI;
			sheetObj.DoSave("FNS_INV_0008GS.do", FormQueryString(formObj),-1,false); 
			ComOpenWait(false);
			break;
		
			case IBINSERT:      // 입력
			var sheetIdx = sheetObj.DataInsert(-1);
			
			var xch_rt_tp_cd = formObj.xch_rt_tp_cd.value;
			
			if(xch_rt_tp_cd!="C" && xch_rt_tp_cd!="D"){
				xch_rt_tp_cd = formObj.xch_rt_n3rd_tp_cd.value;
			}
			
			sheetObj.CellText(sheetIdx,"xch_rt_tp_cd") = xch_rt_tp_cd;
			sheetObj.CellText(sheetIdx,"cust_cnt_cd") = "XX";
			sheetObj.CellText(sheetIdx,"cust_seq") = "0";
			sheetObj.CellText(sheetIdx,"locl_curr_cd") = document.form.locl_curr_cd.value;
			sheetObj.CellText(sheetIdx,"ar_ofc_cd") = document.form.ar_ofc_cd.value;
			var loc_cd = formObj.loc_cd.value;
			if (loc_cd == 'VN') {
				sheetObj.InitDataCombo(0,  "io_bnd_cd",   "ALL",  " ","ALL");
			} else {
				sheetObj.InitDataCombo(0,  "io_bnd_cd",   "ALL|O/B|I/B",  " |O|I","ALL");
			}
			sheetObj.CellText(1,"chg_curr_cd") = "USD";
				
			break;
		
			case IBRESET: // New
		
			var ret = ComGetNowInfo("ym" )      //결과 : 2008-11
			formObj.fm_dt1.value = ret+"-01";
		
			var lastDay = ComGetLastDay(ComGetNowInfo("yy" ), ComGetNowInfo("mm" ))  //결과 : 29
			formObj.to_dt1.value = ret+"-"+lastDay;
			formObj.io_bnd_cd.value="";
		
			formObj.ar_ofc_cd2.text = formObj.ar_ofc_cd_1.value;
			formObj.locl_curr_cd.value = formObj.locl_curr_cd_1.value;
		
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
	
			for (var i=1; i<=sheetObj.RowCount; i++) {
				if (sheetObj.RowStatus(i) == "I") {
					var fmDt = sheetObj.CellText(i,"fm_dt");
					var toDt = sheetObj.CellText(i,"to_dt");
					var fmDt1 = formObj.fm_dt1.value;
					var toDt1 = formObj.to_dt1.value;
					if ((formObj.xch_rt_tp_cd.value!='C'&&formObj.xch_rt_tp_cd.value!='D')
						&&(formObj.xch_rt_n3rd_tp_cd.value!='C'&&formObj.xch_rt_n3rd_tp_cd.value!='D')){
						ComShowCodeMessage("INV00077");
						return;
					}
					if ((fmDt < fmDt1) || (fmDt > toDt1) || (toDt < fmDt1) || (toDt > toDt1) || (fmDt > toDt)) {
						ComShowCodeMessage("INV00024");
						return;
					}
					if (sheetObj.CellText(i,"chg_curr_cd").trim() == ""){
						ComShowCodeMessage("INV00041");
						return;
					}
	
					if (sheetObj.CellText(i,"inv_xch_rt").trim() == ""){
						ComShowCodeMessage("INV00041");
						return;
					} else {
						if (RateCheck(sheetObj, i, ComTrimAll(sheetObj.CellText(i,"inv_xch_rt"),",")) == 0 ) {
							return;
						}
					}
				} else if (sheetObj.RowStatus(i) == "U") {
					if (sheetObj.CellText(i,"inv_xch_rt").trim() == ""){
						ComShowCodeMessage("INV00041");
						return;
					} else {
						if (RateCheck(sheetObj, i, ComTrimAll(sheetObj.CellText(i,"inv_xch_rt"),",")) == 0 ) {
							return;
						}
					}
	
					if (sheetObj.CellText(i,"pre_inv_xch_rt").trim() != ""&&sheetObj.CellText(i,"pre_inv_xch_rt").trim() != "0"){
						if (!ComShowCodeConfirm("INV00126")){
							return false;
						}else{
							return true;
						}
					}
	
				}	
	
			}
		}
	
		return true;
	}
	
	/**
	 * 엑셀 업로드시 Sheet를 세팅하여준다.<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    sheet1_OnLoadExcel(sheetObjects[0]);
	 * </pre>
	 * @param object sheetObj
	 * @author Choi Do Soon
	 * @version 2009.10.08
	 */
	function sheet1_OnLoadExcel(sheetObj){
		for (var i=1; i<=sheetObj.RowCount; i++) {
			if (sheetObj.RowStatus(i) == "I") {
				
				var xch_rt_tp_cd = formObj.xch_rt_tp_cd.value;
				
				if(xch_rt_tp_cd!="C" && xch_rt_tp_cd!="D"){
					xch_rt_tp_cd = formObj.xch_rt_n3rd_tp_cd.value;
				}
				
				sheetObj.CellText(i,"xch_rt_tp_cd") = xch_rt_tp_cd;
				sheetObj.CellText(i,"cust_cnt_cd") = "XX";
				sheetObj.CellText(i,"cust_seq") = "0";
				sheetObj.CellText(i,"locl_curr_cd") = document.form.locl_curr_cd.value;
				sheetObj.CellText(i,"ar_ofc_cd") = document.form.ar_ofc_cd.value;
			}
		}
	}
	
	/**
	 * 그리드 날짜 항목 입력시 날짜 validation한다.<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    sheet1_OnPopupClick(SheetObjects[0], 1,1);
	 * </pre>
	 * @param object sheetObj
	 * @param number row
	 * @param number col
	 * @param string Value
	 * @author Choi Do Soon
	 * @version 2009.10.08
	 */
	function sheet1_OnPopupClick(sheetObj, row,col){
		if (sheetObj.ColSaveName(col) == "fm_dt") {
			var cal = new ComCalendarGrid("fm_dt");
			cal.endFunction ="ComCalendar_tmpEndFunction2";
			cal.select(sheetObj, row, col, 'yyyy-MM-dd');
	
		}
		if (sheetObj.ColSaveName(col) == "to_dt") {
			var cal2 = new ComCalendarGrid("to_dt");
			cal2.select(sheetObj, row, col, 'yyyy-MM-dd');
		}
	
	}
	
	/**
	 * 달력팝업 종류후 실행되는 fuction<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    ComCalendar_tmpEndFunction2()
	 * </pre>
	 * @author Choi Do Soon
	 * @version 2009.10.08
	 */
	function ComCalendar_tmpEndFunction2(){
		sheetObjects[0].SelectCell(sheetObjects[0].SelectRow, "to_dt",true,sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "fm_dt")); 
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
	 * @version 2009.10.08
	 */
	function MakeComboObject2(cmbObj, arrStr) {
		cmbObj.DropHeight = 190;
		for (var i = 1; i < arrStr.length;i++ ) {
			var arrStr2 = arrStr[i].split("^");
			var ar_ofc_value = arrStr2[1];
			var ar_ofc_cd = arrStr2[1]+"|"+arrStr2[4]+"|"+arrStr2[5];
			cmbObj.InsertItem(i-1, ar_ofc_value, arrStr[i]);
		}
	}      
	
	
	/**
	 * 콤보박스 ar_ofc_cd 데이터 변경시 실행되는 function<br>
	 * 해당 office세팅<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *   ar_ofc_cd2_OnChange(document.form,'HAMBB','HAMBB');
	 * </pre>
	 * @param object comboObj
	 * @param string value
	 * @param string text
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */	
	function ar_ofc_cd2_OnChange(comboObj,value,text) {
		var arrStr = comboObj.Code.split("^");
		var ar_ofc_cd = arrStr[1];
		document.form.ar_ofc_cd.value = ar_ofc_cd;
		document.form.locl_curr_cd.value = arrStr[4];
		document.form.ar_ctrl_ofc_cd.value = arrStr[5];
		document.form.loc_cd.value = arrStr[6].substring(0,2);
		document.form.xch_rt_tp_cd.value = arrStr[12];
		document.form.xch_rt_n3rd_tp_cd.value = arrStr[19];	
		sheetObjects[0].RemoveAll();
	
	}
	
	
	/**
	 * 그리드내 콤보필드에 데이터를 추가해준다.
	 */		
	function addCellComboItem(sheetObj,comboValues,colName,isCellCombo) {
		var sRow = sheetObj.SelectRow;
		var comboTxt = "";
		var comboVal = "";
		var comboItems;
		var comboItem;
	
		comboValues = "|"+" "+comboValues;
		if (comboValues != undefined) {
			comboItems = comboValues.split(ROWMARK);
			for (var i = 1 ; i < comboItems.length ; i++) {
				comboItem = comboItems[i].split(FIELDMARK);
				if ((comboItem[0] != "")&&(comboItem[0] != form.locl_curr_cd.value)) {
					comboTxt += comboItem[0];
					comboVal += comboItem[0];
				}
				if (i < comboItems.length-1&&(comboItem[0] != "")&&(comboItem[0] != form.locl_curr_cd.value)) {
					comboTxt += ROWMARK;
					comboVal += ROWMARK;
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
	
	function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode) {
		if (sheetObj.ColSaveName(Col) == "fm_dt"){
			fmDtVal = sheetObj.CellValue(Row, Col).replace('-','');
		}  
	}
	
	/**
	 * 그리드 날짜 항목 입력시 날짜 validation한다.<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    sheet1_OnPopupClick(SheetObjects[0], 1,1,'20090901');
	 * </pre>
	 * @param object sheetObj
	 * @param number Row
	 * @param number Col
	 * @param string Value
	 * @author Choi Do Soon
	 * @version 2009.10.08
	 */
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		if (sheetObj.ColSaveName(Col) == "fm_dt"){
			sheetObj.SelectCell(Row, "to_dt",true,Value) 
		}
	}
	
	/**
	 * 경리환율을 조회하여 입력한 항목과 비교한다.<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *   RateCheck(shhetObjects[0], 1, '0.1111');
	 * </pre>
	 * @param object sheetObj
	 * @param number Row
	 * @param string Value
	 * @author Choi Do Soon
	 * @version 2009.10.08
	 */	
	function RateCheck(sheetObj, Row, Value) {
		document.form.f_cmd.value = SEARCH04;
	
		var effDt = sheetObj.CellText(Row,"fm_dt").substring(0,7);
		document.form.eff_dt.value = ComReplaceStr(effDt,"-",""); 
		document.form.curr_cd.value = sheetObj.CellValue(Row,"chg_curr_cd");
	
		var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(document.form));
		var usd_locl_xch_rt = ComGetEtcData(sXml,"usd_locl_xch_rt");
		var valRate = Value/usd_locl_xch_rt
		if((valRate > 1.5) ||((valRate < 0.5))) {
			ComShowCodeMessage("INV00016");
			return 0;
		} else {
			return 1;
		}
	
	}
	
	/**
	 * fm_dt 변경시 날짜 유형 체크 후 masked value 세팅<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *   fn_ComGetMaskedValue('20090101');
	 * </pre>
	 * @param String value
	 * @author Choi Do Soon
	 * @version 2009.10.08
	 */
	function fn_ComGetMaskedValue(elNm) {
	
		var formObj;
		if (elNm == "fm_dt1") {
			formObj = form.fm_dt1;
		} else {
			formObj = form.to_dt1;
		}
		var value = formObj.value;
		if (value=="") return;
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
		
		if(elNm == "fm_dt1"){
			if(form.to_dt1.value==""){
				form.to_dt1.value = ret;
			}
			form.to_dt1.select(); 
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
			if(form.to_dt1.value==""){
				form.to_dt1.value = ComTrimAll(value," ", "-", ":");
			}
			form.to_dt1.select(); 
		}
	}
	 
	/**
	 * Sheet retrieve 종료시 Sheet산 Col Copy<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     sheet1_OnSearchEnd(sheetObjects[0],'');
	 * </pre>
	 * @param object sheetObj
	 * @param string ErrMsg
	 * @author Choi Do Soon
	 * @version 2009.10.08
	 */
	function sheet1_OnSearchEnd(sheetObj,ErrMsg){      		
		sheetObj.Copy2SheetCol(sheetObj,"inv_xch_rt","pre_inv_xch_rt") 
	}

/* 개발자 작업  끝 */