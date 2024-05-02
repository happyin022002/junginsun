/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0100.js
*@FileTitle : VVD Ex.Rate Creation by S/A Date
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.07.07 김세일
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
	 * @class fns_inv_0100 : fns_inv_0100 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function fns_inv_0100() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl            = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.setTabObject 			= setTabObject;
		this.validateForm 			= validateForm;
		this.initCombo				= initCombo;
		this.setComboObject 		= setComboObject;
	}
	
	/* 개발자 작업	*/
	
	// 공통전역변수
	var sheetObjects = new Array();
	var comboObjects = new Array();
	var sheetCnt = 0;
	var ROWMARK = "|";
	var FIELDMARK = "=";
	var retrieveFlg = 0;  
	var comboCnt = 0;
	
	var rdObjects = new Array();
	var rdCnt = 0;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
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
	
		/*******************************************************/
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
	
			switch(srcName) {
				case "btn2_Row_Add":
					if (retrieveFlg == 1) {
						var idx = sheetObject1.DataInsert(-1);
						
						if(formObject.svr_id.value!="EUR"){		 					
							// 1번째 Item을 삭제.
							sheetObject1.CellValue(idx,"io_bnd_cd") = form.bnd_cd.value;
		
							if(form.bnd_cd.value=='O'){
								sheetObject1.CellValue(idx,"etda_cd") = "ETD";
							}else if(form.bnd_cd.value=='I'){
								sheetObject1.CellValue(idx,"etda_cd") = "ETA";
							}
						}else{
							sheetObject1.CellValue(idx,"io_bnd_cd") = "";
							sheetObject1.CellValue(idx,"svc_scp_cd") = "";
							sheetObject1.CellValue(idx,"vps_port_cd") = "";
						}
					}
		
					break; 
		
				case "btn2_Row_Copy":
					if (retrieveFlg == 1) {
						var idx = sheetObject1.DataCopy();
						if(formObject.svr_id.value!="EUR"){		 
							sheetObject1.CellValue(idx,"io_bnd_cd") = form.bnd_cd.value;
						}
					}
		
					break;
		
				case "btn2_Delete":
					if (retrieveFlg == 1) {	
						var sRow = sheetObject1.FindCheckedRow("DelChk");
						if (sRow == "") {
							ComShowCodeMessage("COM12189");
							return 0;
						}
		
						var arrRow = sRow.split("|");
		
						for (var idx=arrRow.length-2; idx>=0; idx--){
							var row = arrRow[idx];
							sheetObject1.RowDelete(row,false);
						}
		
						//ComRowHideDelete(sheetObject1, "DelChk");
					}
					break;
		
				case "btn3_Row_Add":
					if (retrieveFlg == 1) {
						var idx = sheetObject2.DataInsert(-1);
						//sheetObjects[1].CellValue2(idx,"io_bnd_cd") = "O";
						sheetObjects[1].CellValue2(idx,"xch_rt_rvs_flg") = form.xch_rt_rvs_flg.value;
						sheetObjects[1].CellValue2(idx,"locl_curr_cd") = form.locl_curr_cd.value;
						sheetObjects[1].CellValue2(idx,"ar_ofc_cd") = form.ar_ofc_cd.Text;
						sheetObjects[1].CellValue2(idx,"xch_rt_tp_cd") = "V";
					}
		
					break; 
		
				case "btn3_Row_Copy":
					if (retrieveFlg == 1) {
						var idx = sheetObject2.DataCopy();
						sheetObjects[1].CellValue2(idx,"xch_rt_tp_cd") = "V";
					}
		
					break;
		
				case "btn3_Delete":
					if (retrieveFlg == 1) {
		
						var sRow = sheetObject2.FindCheckedRow("DelChk");
						if (sRow == "") {
							ComShowCodeMessage("COM12189");
							return 0;
						}
		
						var arrRow = sRow.split("|");
		
						for (var idx=arrRow.length-2; idx>=0; idx--){
							var row = arrRow[idx];
							sheetObject2.RowDelete(row,false);
						}
		
					}
					break;
		
				case "btn1_Retrieve":
					retrieveFlg = 1;
		
					doActionIBSheet(sheetObject1,document.form,IBSEARCH);
					break; 
		
				case "btn1_New":
					retrieveFlg == 0;
					doActionIBSheet(sheetObject1,document.form,IBCLEAR);
					break;
		
				case "btn1_Save":
					if (retrieveFlg == 1) {	
						doActionIBSheet(sheetObject1,document.form,IBSAVE);
					}
					break;
		
				case "btns_calendar": //달력버튼
					var cal = new ComCalendar();
					cal.select(formObject.etd_dt, 'yyyy-MM-dd');
					break;
				
				case "btn_downexcel":
					ComOpenWait(true);
					sheetObject3.SpeedDown2Excel(-1,false,false,'','',false,false,'',false,false,'',false,'',true);
					ComOpenWait(false);
					break;
				case "btn_print":
					if (sheetObjects[0].CheckedRows("DelChk") == 0) {
						ComShowMessage(msgs["INV00025"]);
						return false;
					 }
					
					var cur_cd = "'";
					var chg_curr_cds = "";	
					for (var i=1; i<=sheetObjects[1].RowCount; i++) {
			    		 if(sheetObjects[1].cellText(i,"DelChk") == "1"){
			    			 chg_curr_cds = sheetObjects[1].cellText(i,"chg_curr_cds");
			    			 cur_cd = cur_cd + chg_curr_cds + "','";
			    		 }
					}
					cur_cd = cur_cd + "'";

					var vvd_cd = "";
					var io_bnd_cd = "";
					var cnt = 0;
					for (var i=1; i<=sheetObjects[0].RowCount; i++) {
			    		 if(sheetObjects[0].cellText(i,"DelChk") == "1"){
			    			 cnt++;
			    			 vvd_cd = sheetObjects[0].cellText(i,"vvd_cd");
			    			 io_bnd_cd = sheetObjects[0].cellText(i,"io_bnd_cd");
			    			 rdOpen(vvd_cd, cur_cd, cnt);
			    			 rdObjects[0].SetAppendReport(1);
			    		 }
					}
					rdObjects[0].SetAppendReport(0); 
					rdObjects[0].CMPrint(); //인쇄 시작
	
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
		initRdConfig(rdObjects[0]);
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01); 	
		
		ComBtnDisable("btn_downexcel");
		ComBtnDisable("btn_print");
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
				style.height = 422;
		
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
		
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
		
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
		
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 15, 100);
		
				var HeadTitle1 = "|Sel.|VVD|Seq.|Scope|Port|Bound|ETA/D|ETA/D|USD to LCL|VSL SKD|Lane|Ex.Rate";
				var headCount = ComCountHeadTitle(HeadTitle1);
		
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
		
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false);
		
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
		
				//데이터속성   [ROW, COL,	DATATYPE,		WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,	KEYFIELD,	CALCULOGIC,		DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
		
				InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	true,		"DelChk",			false,		"",				dfNone,		0,			true,		true);
				InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"vvd_cd",			false,      "",				dfNone,		0,			false,		true);
				InitDataProperty(0, cnt++ , dtData,			35,		daCenter,	true,		"clpt_seq",		false,      "",				dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtCombo,		55,		daCenter,	true,		"svc_scp_cd",		true,		"",				dfNone,		0,			true,		true);
				InitDataProperty(0, cnt++ , dtCombo,		50,		daCenter,	true,		"vps_port_cd",	true,      "",				dfNone,		0,			true,		true);
				InitDataProperty(0, cnt++ , dtCombo,		50,		daCenter,	true,		"io_bnd_cd",		false,		"",				dfNone,		0,			true,		true);
				InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,		"etda_cd",			false,      "",				dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"etda_dt",			false,      "",				dfDateYmd,	0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"inv_xch_rt",		false,		"",				dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtPopup,			60,		daCenter,	true,		"vsl_pop",			false,      "",				dfNone,		0,			true,		true);
				InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,		"slan_cd",			false,		"",				dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtPopup,			60,		daCenter,	true,		"exRate_pop",	false,      "",				dfNone,		0,			true,		true);
		
				InitDataCombo(0, "svc_scp_cd", "AEW|TPW", "AEW|TPW");
				InitDataCombo(0, "vps_port_cd", "DEHAM|NLRTM|GBFXT|USOAK", "DEHAM|NLRTM|GBFXT|USOAK");
				InitDataCombo(0, "io_bnd_cd", "I|O", "I|O");
		
				InitDataValid(0, "vvd_cd", vtEngUpOther, "0123456789"); 
		
				InitComboNoMatchText(true);
				ShowButtonImage = 1;
				//CountPosition = 0;
				WaitImageVisible = false; 
				SelectHighLight = false;
			}
			break;
		
			case 2:      //sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = 422;
		
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
		
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
		
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
		
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 15, 100);
		
				var HeadTitle1 = "|Sel.|Cur.|Ex. Rate|Inverse|Inverse Rate||||||";
				var headCount = ComCountHeadTitle(HeadTitle1);
		
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
		
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false);
		
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
		
				//데이터속성   [ROW, COL,	DATATYPE,		WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,	KEYFIELD,	CALCULOGIC,		DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
				InitDataProperty(0, cnt++, dtCheckBox, 40,daCenter, false, "DelChk");  
				InitDataProperty(0, cnt++ , dtComboEdit,		50,		daCenter,	true,		"chg_curr_cds",	false,      "",				dfNone,		0,			true,		true,3,true);
				InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,		"inv_xch_rts",			false,		"",				dfNullFloat,   6,			true,		true);
				InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"xch_rt_rvs_flg",			false,      "",				dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,		"ivs_xch_rts",			false,		"",				dfNullFloat,   6,			false,		false);
				InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		"chg_curr_cd");
				InitDataProperty(0, cnt++ , dtHidden,		80,		daRight,	true,		"inv_xch_rt",			false,		"",				dfNone,		0,			true,		true);
				InitDataProperty(0, cnt++ , dtHidden,		80,		daRight,	true,		"ivs_xch_rt",			false,		"",				dfNone,		0,			true,		true);
				InitDataProperty(0, cnt++ , dtHidden,		80,		daRight,	true,		"locl_curr_cd",			false,		"",				dfNone,		0,			true,		true);
				InitDataProperty(0, cnt++ , dtHidden,		80,		daRight,	true,		"ar_ofc_cd",			false,		"",				dfNone,		0,			true,		true);
				InitDataProperty(0, cnt++ , dtHidden,  		0,    daCenter,  true,    "xch_rt_tp_cd");
		
				InitDataCombo(0, "chg_curr_cds", "|USD|GBP|DKK|CHF", "|USD|GBP|DKK|CHF");
				InitDataValid(0, "chg_curr_cds", vtEngUpOnly); 
				AllowNoneTextOnEditCombo = false;
		
				//CountPosition = 0;
				WaitImageVisible = false; 
			}
			break;	
			
			case 3:      //sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = 0;
		
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
		
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
		
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
		
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 15, 100);
		
				var HeadTitle1 = "|VVD|VVD|VVD|Port|Scope|Bound|Cur.|Locl Cur.|Ex.Rate|Ex.Rate Type";
				var headCount = ComCountHeadTitle(HeadTitle1);
		
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
		
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false);
		
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
		
				//데이터속성   [ROW, COL,	DATATYPE,		WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,	KEYFIELD,	CALCULOGIC,		DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,	0,	daCenter,	true,		"ibflag");
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,		"vsl_cd",		false,      "",				dfNone);
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,		"skd_voy_no",	false,      "",				dfNone);
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,		"skd_dir_cd",	false,      "",				dfNone);
				InitDataProperty(0, cnt++ , dtData,		80,		daRight,	true,		"port_cd",		false,		"",				dfNone);
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,		"svc_scp_cd",	false,      "",				dfNone);
				InitDataProperty(0, cnt++ , dtData,		80,		daRight,	true,		"io_bnd_cd",	false,		"",				dfNone);
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,		"chg_curr_cd",	false,		"",				dfNone);
				InitDataProperty(0, cnt++ , dtData,		80,		daRight,	true,		"locl_curr_cd",	false,		"",				dfNone);
				InitDataProperty(0, cnt++ , dtData,		80,		daRight,	true,		"inv_xch_rt",	false,		"",				dfNone);
				InitDataProperty(0, cnt++ , dtData,  	80,     daCenter,   true,   	"xch_rt_tp_cd",	false,		"",				dfNone);
				
				WaitImageVisible = false; 
				
			}
			break;	
		}
	}
	
	/** 
	 * 조회 저장등 서버 기능을 호출하는 doActionIBSheet <br>
	 * <br><b>Example :</b>
	 * <pre>2
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
			var ret = ComGetNowInfo("ymd" )      //결과 : 2008-11
			formObj.etd_dt.value = ret;
		
			formObj.f_cmd.value = SEARCH01;
			var sXml = sheetObj.GetSearchXml("FNS_INV_0100GS.do", FormQueryString(formObj));
		
			//===========office list =======================//
			var sStr = ComGetEtcData(sXml,"ar_ofc_cd");
			var arrStr = sStr.split("|");
		
			MakeComboObject2(formObj.ar_ofc_cd, arrStr);
		
			var arrStr2 = "";
			var ar_ofc_cd = "";
		
			for(i=1;i<arrStr.length;i++){
				arrStr2 = arrStr[i].split("^");
				if(arrStr2[1]==arrStr2[3]){
					ar_ofc_cd = arrStr2[1];
		
					formObj.ar_ofc_cd.text = ar_ofc_cd;
					formObj.ofc_cd.value = ar_ofc_cd;
					formObj.svr_id.value = arrStr2[7];
		
					formObj.locl_curr_cd.value = arrStr2[4];
					formObj.xch_rt_rvs_flg.value = arrStr2[8];
					formObj.org_ofc_cd.value = ar_ofc_cd;
					formObj.org_curr_cd.value = arrStr2[4];
				}
			}
				
			//====== currInfo combo list ====================//
			var comboValues = ComGetEtcData(sXml, "currInfo");	
			addCellComboItem(sheetObjects[1],comboValues,"chg_curr_cds",false);						
			//====== currInfo combo list ====================//
		
			
			if(formObj.svr_id.value=="EUR"){
				formObj.svc_scp_cd.Enable = false;
				formObj.vps_port_cd.Enable = false;
		
				document.all.tri_ctnt.style.display = "Inline";
				document.all.bnd_ctnt.style.display = "none";
		
				sheetObjects[0].InitDataProperty(0, 2 , dtData,		100,	daCenter,	true,		"vvd_cd",			false,      "",				dfNone,		0,			false,		true);
				sheetObjects[0].InitDataProperty(0, 4 , dtCombo,		55,		daCenter,	true,		"svc_scp_cd",			false,		"",				dfNone,		0,			false,		false);
				sheetObjects[0].InitDataProperty(0, 5 , dtCombo,		50,		daCenter,	true,		"vps_port_cd",	false,      "",				dfNone,		0,			false,		true);
				sheetObjects[0].InitDataProperty(0, 6 , dtCombo,		50,		daCenter,	true,		"io_bnd_cd",			false,		"",				dfNone,		0,			false,		false); 					
		
			}else{
				document.all.tri_ctnt.style.display = "none";
				document.all.bnd_ctnt.style.display = "Inline";					
			}	
			
			ComOpenWait(false);
			break;    
		
			case IBSEARCH:      //조회
			
			ComOpenWait(true);
			sheetObjects[1].RemoveAll();
			form.etd_dt2.value = ComReplaceStr(form.etd_dt.value,"-","");
		
			if(form.svr_id.value=='EUR'){
				if(formObj.tri_yn.value=="Y"){
					formObj.f_cmd.value = SEARCH03;
				}else{
					formObj.f_cmd.value = SEARCH04;
				}
			}else{
				if(formObj.bnd_cd.value=="T"){
					formObj.f_cmd.value = SEARCH03;
				}else{
					formObj.f_cmd.value = SEARCH02;
				}
			}
		
			sheetObj.DoSearch("FNS_INV_0100GS.do",FormQueryString(formObj));
			
			ComOpenWait(false);
		
			break;
		
			case IBSAVE:        //저장
			if(validateForm(sheetObj,formObj,sAction)) return;
			
			var iCheckRow = sheetObjects[0].FindCheckedRow("DelChk"); 
			var iCheckRow2 = sheetObjects[1].FindCheckedRow("DelChk"); 
			if (iCheckRow== "") {
				ComShowCodeMessage("INV00025");
				return false;
			}
		
			if (iCheckRow2== "") {
				ComShowCodeMessage("INV00025");
				return false;
			}
			ComOpenWait(true);
			formObj.f_cmd.value = MULTI;
			var sXml = sheetObj.GetSaveXml("FNS_INV_0100GS.do",FormQueryString(formObj) + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(false,true,"DelChk"),"sheet1_") + "&" + ComSetPrifix(sheetObjects[1].GetSaveString(false,true,"DelChk"),"sheet2_"));
			
			sheetObjects[2].LoadSaveXml(sXml);
			
			ComBtnEnable("btn_downexcel");
			ComBtnEnable("btn_print");
			
			ComOpenWait(false);
			break;
		
			case IBINSERT:      // 입력
		
			break;
			case IBCLEAR: //NEW
			var ret = ComGetNowInfo("ymd" )      //결과 : 2008-11
			formObj.etd_dt.value = ret;
		
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
		
			form.ar_ofc_cd.Text = form.org_ofc_cd.value;
			form.locl_curr_cd.value = form.org_curr_cd.value;
			if(form.svr_id.value!='EUR'){
				form.bnd_cd.value = "O";
			}else{
				form.tri_yn.value = "N";
			}
			form.svc_scp_cd.text = "ALL";
			form.vps_port_cd.text = "ALL";
			
			ComBtnDisable("btn_downexcel");
			ComBtnDisable("btn_print");
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
				case IBSEARCH:        //조회
				break;
				case IBSAVE:        //저장
				if (sheetObjects[0].RowCount < 0) {
					ComShowCodeMessage("INV00001");
					return true;
				} else {
					for (var i=1; i<=sheetObjects[0].RowCount; i++) {
						if(sheetObjects[0].CellValue(i,"DelChk")=="1"){
							if (sheetObjects[0].CellText(i,"vvd_cd").trim() == ""){
								ComShowCodeMessage("INV00007",i+" Line");
								return true;
							}
		
							if (sheetObjects[0].CellText(i,"inv_xch_rt").trim() != ""&&sheetObjects[0].CellText(i,"inv_xch_rt").trim() != "0"){
								if (!ComShowCodeConfirm("INV00126")){
									return true;
								}else{
									return false;
								}
							}
		
							if(form.svr_id.value!='EUR'){
								if (sheetObjects[0].CellText(i,"svc_scp_cd").trim() == ""){
									ComShowCodeMessage("INV00006",i+" Line");
									return true;
								}else{
									sheetObjects[0].CellValue2(i,"svc_scp_cd")=sheetObjects[0].CellText(i,"svc_scp_cd").trim()
								}
								if (sheetObjects[0].CellText(i,"vps_port_cd").trim() == ""){
									ComShowCodeMessage("INV00007",i+" Line");
									return true;
								}else{
									sheetObjects[0].CellValue2(i,"vps_port_cd")=sheetObjects[0].CellText(i,"vps_port_cd").trim()
								}
								if (sheetObjects[0].CellText(i,"io_bnd_cd").trim() == ""){
									ComShowCodeMessage("INV00004",i+" Line");
									return true;
								}
							}
						}
		
					}
				}	
		
				if (sheetObjects[1].RowCount < 0) {
					ComShowCodeMessage("INV00001");
					return true;
				} else {
					for (var i=1; i<=sheetObjects[1].RowCount; i++) {
						if(sheetObjects[1].CellValue(i,"DelChk")=="1"){
							if (sheetObjects[1].CellText(i,"chg_curr_cds").trim() == ""){
								ComShowCodeMessage("INV00004",i+" Line");
								return true;
							}
							if (sheetObjects[1].CellText(i,"inv_xch_rts").trim() == ""){
								ComShowCodeMessage("INV00004",i+" Line");
								return true;
							}
						}
					}
				}
				break;
			}
		}
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
			var arOfcValue = arrStr2[1];
			cmbObj.InsertItem(i-1, arOfcValue, arrStr[i]);
		}
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
		var arrStr2;
		
		comboValues = "|"+" "+comboValues;
	
		if (colName == 'chg_curr_cds') {
			if (comboValues != undefined) {
				comboItems = comboValues.split(ROWMARK);
	
				for (var i = 1 ; i < comboItems.length ; i++) {
					arrStr2 = comboItems[i].split("^");
					comboItem = comboItems[i].split(FIELDMARK);
					if ((comboItem[0] != "")&&(comboItem[0] != form.locl_curr_cd.value)) {
						comboTxt += arrStr2[0];
						comboVal += arrStr2[0]+"^"+ arrStr2[1];
					}
					if (i < comboItems.length-1) {
						comboTxt += ROWMARK;
						comboVal += ROWMARK;
					}				
				}
			}
		} else {
			if (comboValues != undefined) {
				comboItems = comboValues.split(ROWMARK);
				for (var i = 2 ; i < comboItems.length ; i++) {
					comboItem = comboItems[i].split(FIELDMARK);
	
					if ((comboItem[0] != "")&&(comboItem[0] != form.locl_curr_cd.value)) {
						comboTxt += comboItem[0];
						comboVal += comboItem[0];
					}
					if (i < comboItems.length-1) {
	
						comboTxt += ROWMARK;
						comboVal += ROWMARK;
					}
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
	
	/**
	 * Vps Port CD 입력시 값세팅<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     vps_port_cd_OnBlur(form.ar_ofc_cd);
	 * </pre>
	 * @param object cmbObj
	 * @author Choi Do Soon
	 * @version 2009.10.08
	 */
	function vps_port_cd_OnBlur(comboObj){
		if(comboObj.Text!=''){
			upperText = comboObj.Text.toUpperCase();
			var itemindex = comboObj.FindIndex ( upperText, 0);
			if(itemindex==-1){
				comboObj.Text2 ="ALL";
			}else{
				comboObj.Text2 = upperText;
			}
		}
	}
	
	/**
	 * currency 변경시 description 처리<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     sheet2_OnChange(sheetObjects[0],1,1,'USD');
	 * </pre>
	 * @param object sheetObj
	 * @param number Row
	 * @param number col
	 * @param string sValue
	 * @author Choi Do Soon
	 * @version 2009.10.08
	 */
	function sheet2_OnChange(sheetObj,Row,col,sValue){
		
		if(sheetObj.ColSaveName(col) == "chg_curr_cds")
		{
			var chgCurr = sheetObj.CellValue(Row,"chg_curr_cds").split("^");
			var chgCurrCd = chgCurr[0];
			var chgCurNm = chgCurr[1];
			if(chgCurr!="" && chgCurNm==undefined){
				ComShowCodeMessage("INV00041","Currency");
				sheetObj.CellValue(Row,"chg_curr_cds") = "";
				sheetObj.SelectCell(Row,"chg_curr_cds");
				return;
			}
	
			sheetObj.CellText(Row,"chg_curr_cd") = chgCurrCd;
			sheetObj.CellText(Row,"curr_nm") = chgCurNm;
		}
		
		if (sheetObj.ColSaveName(col) == "inv_xch_rts") {
			
			if(sheetObj.CellValue(Row,"inv_xch_rts")==""){
				sheetObj.CellValue(Row,"inv_xch_rts")="";
				sheetObj.CellValue(Row,"inv_xch_rt")="";
				sheetObj.CellValue(Row,"ivs_xch_rts")=""; 
				sheetObj.CellValue(Row,"ivs_xch_rt")="";
			}
	
			document.form.f_cmd.value = SEARCH04;
			var effDt = ComGetNowInfo("ym" )  ;
			document.form.eff_dt.value = ComReplaceStr(effDt,"-",""); 
			document.form.curr_cd.value = sheetObj.CellValue(Row,"chg_curr_cd");
			var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(document.form));
			var usd_locl_xch_rt = ComGetEtcData(sXml,"usd_locl_xch_rt");
	
			var sValue = "";
			var ivs_rate ="";
			var valRate ="";
	
			if(usd_locl_xch_rt ==""){
				ComShowCodeMessage("INV00001");
				sheetObj.CellValue(Row,"inv_xch_rts")=sheetObj.CellValue(Row,"inv_xch_rt");
				sheetObj.CellValue(Row,"ivs_xch_rts")=sheetObj.CellValue(Row,"ivs_xch_rt");
				sheetObj.SelectCell(Row,"inv_xch_rts");
				return;
			}else {
				sValue = sheetObj.CellValue(Row,"inv_xch_rts");
				valRate = sValue/usd_locl_xch_rt;
				ivs_rate = 1/sValue;
				ivs_rate = ComRound(ivs_rate, 4);
	
				//2010.01.13 역환율 계산 없앰 이상희과장
				/*
				if(form.xch_rt_rvs_flg.value=='Y'){
					if((ivs_rate > 1.5) ||((ivs_rate < 0.5))) {
 	    	        	ComShowCodeMessage("INV00016");
 	    	        	sheetObj.CellValue(Row,"inv_xch_rts")=sheetObj.CellValue(Row,"inv_xch_rt");
 	    	        	sheetObj.CellValue(Row,"ivs_xch_rts")=sheetObj.CellValue(Row,"ivs_xch_rt");
 	    	        	sheetObj.SelectCell(Row,"inv_xch_rts");
 	    	        	return;
 	    	        }
				}else{
				 */
				if((valRate > 1.5) ||((valRate < 0.5))) {
					ComShowCodeMessage("INV00016");
					sheetObj.CellValue(Row,"inv_xch_rts")=sheetObj.CellValue(Row,"inv_xch_rt");
					sheetObj.CellValue(Row,"ivs_xch_rts")=sheetObj.CellValue(Row,"ivs_xch_rt");
					sheetObj.SelectCell(Row,"inv_xch_rts");
					return;
				}
				//}	 					
			}
	
			sheetObj.CellValue(Row,"ivs_xch_rts") = ivs_rate;
	
			//2010.01.13 역환율 계산 없앰 이상희과장
			/*if (form.xch_rt_rvs_flg.value=='Y') {
				sheetObj.CellValue(Row,"inv_xch_rt") = ivs_rate;
				sheetObj.CellValue(Row,"ivs_xch_rt") = sValue;
			} else {
			 */
			sheetObj.CellValue(Row,"inv_xch_rt") = sValue;
			sheetObj.CellValue(Row,"ivs_xch_rt") = ivs_rate; 						
			//}
	
		}
	
	}	
	
	
	/**
	 * 콤보박스 ar_ofc_cd 데이터 변경시 실행되는 function<br>
	 * 해당 office세팅<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *   ar_ofc_cd_OnChange(document.form,'HAMBB','HAMBB');
	 * </pre>
	 * @param object comboObj
	 * @param string value
	 * @param string text
	 * @author Choi Do Soon
	 * @version 2009.10.08
	 */		 
	function ar_ofc_cd_OnChange(comboObj,value,text) {
		var arrStr = comboObj.Code.split("^");
		document.form.ar_ofc_cd2.value = arrStr[1];
		document.form.ofc_cd.value = arrStr[1];
		document.form.locl_curr_cd.value = arrStr[4];
		document.form.svr_id.value = arrStr[7];
		form.xch_rt_rvs_flg.value = arrStr[8];
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
	
		//if(document.form.svr_id.value!="EUR"){
			document.form.vps_port_cd.RemoveAll();
	
			document.form.f_cmd.value = SEARCH01;
			var sXml = sheetObjects[0].GetSearchXml("FNS_INV_0100GS.do", FormQueryString(document.form));
	
			var portStr = ComGetEtcData(sXml,"portList");
			var arrPortStr = portStr.split("|");
	
			MakeComboObject(document.form.vps_port_cd, arrPortStr);
			document.form.vps_port_cd.text = "ALL";   
	
			//====== port combo list ====================//
			addCellComboItem(sheetObjects[0],portStr,"vps_port_cd",false);	
			
			document.form.svc_scp_cd.RemoveAll();
			
			//================== scope list ===============//
			if(document.form.svr_id.value =='KOR'){
				var scpStr = "ALL|OTH"
			}else{
				var scpStr = ComGetEtcData(sXml,"svc_scp_cd");
			}
			var arrScpStr = scpStr.split("|");
		
			MakeComboObject(document.form.svc_scp_cd, arrScpStr);
			document.form.svc_scp_cd.text = "ALL";
		
			//================== scope list ===============//
			   	
			//====== scope combo list ====================//
			addCellComboItem(sheetObjects[0],scpStr,"svc_scp_cd",false);						
			//====== scope combo list ====================//
		
		//}
	
	}
	
	/**
	 * Option 선택시 form disable여부 세팅<br>
	 * 해당 office세팅<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *   fn_option('V');
	 * </pre>
	 * @param string value
	 * @author Choi Do Soon
	 * @version 2009.10.08
	 */
	 /*
   	function fn_option(value){

		if (value=="V") {
			form.vvd_cd.disabled = false ;
			form.etd_dt.disabled = true;
			form.vvd_cd.className = "input";				
			form.etd_dt.className = "input2";
			form.etd_dt.value = "";
		} else {
			form.vvd_cd.disabled = true ;				
			form.etd_dt.disabled = false;
			form.vvd_cd.className = "input2";
			form.etd_dt.className = "input1";
			form.etd_dt.value = ComGetNowInfo("ymd", "-");
			form.vvd_cd.value = "" ;
		}

		retrieveFlg == 0;

		form.etd_dt.value = ComGetNowInfo("ymd" ) ;

    	sheetObjects[0].RemoveAll();
    	sheetObjects[1].RemoveAll();
    	form.vvd_cd.value="";

    	form.ar_ofc_cd.Text = form.org_ofc_cd.value;
    	form.locl_curr_cd.value = form.org_curr_cd.value;
    	form.bnd_cd.value = "O";
        form.svc_scp_cd.text = "ALL";
        form.vps_port_cd.text = "ALL";
     }
	 */
	/**
	 * etd_dt 변경시 날짜 유형 체크 후 masked value 세팅<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *   fn_ComGetMaskedValue('20090101');
	 * </pre>
	 * @param String value
	 * @author Choi Do Soon
	 * @version 2009.10.08
	 */
	function fn_ComGetMaskedValue(value) {
	
		var value = form.etd_dt.value;
		value = ComReplaceStr(value,"-","");
		
		if (value=="") return;
		
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
	
		var days = ComGetLastDay(value.substring(0,4), value.substring(4,6));
		if (value.substring(6,8) > days) {
			ComShowCodeMessage("INV00024");
			return;
		} 
		if (value.substring(6,8) == 00) {
			ComShowCodeMessage("INV00024");
			return;
		} 
	
		var ret = ComGetMaskedValue(value, "ymd")  ;     
		form.etd_dt.value = ret;
	}
	
	
	/**
	 * 그리드 팝업버튼 클릭시 해당 화면을 호출한다.<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    sheet1_OnPopupClick(SheetObjects[0], 1,1);
	 * </pre>
	 * @param object sheetObj
	 * @param number Row
	 * @param number Col
	 * @author Choi Do Soon
	 * @version 2009.10.08
	 */
	function sheet1_OnPopupClick(sheetObj, Row,Col){
		var formObject = document.form;
		var param = "";
		if (sheetObj.ColSaveName(Col) == "vsl_pop") {
			var vvdCd = sheetObj.CellValue(Row,"vvd_cd");
			var vsl_cd = vvdCd.substring(0,4);
			var skd_voy_no = vvdCd.substring(4,8);
			var skd_dir_cd = vvdCd.substring(8,9);
	
			param = "vsl_cd="+vsl_cd+"&skd_voy_no="+skd_voy_no+"&skd_dir_cd="+skd_dir_cd;
			ComOpenPopup('/hanjin/VOP_VSK_0019.do?pgmNo=VOP_VSK_0019&'+param, 1000, 630, '', '0,0'); 
		} else if (sheetObj.ColSaveName(Col) == "exRate_pop") {
			var vvvCd = sheetObj.CellValue(Row,"vvd_cd");
			var loclCurrCd = document.form.locl_curr_cd.value;
			var ioBndCd = sheetObj.CellValue(Row,"io_bnd_cd");
	
			param = 'vvvcd='+vvvCd+'&locl_curr_cd='+loclCurrCd+'&io_bnd_cd='+ioBndCd;
			ComOpenPopup('/hanjin/FNS_INV_0006.do?pgmNo=FNS_INV_0006&'+param, 1000, 600, '', '0,0');    	
		}
	
	}
	
	function changeTriYn(){
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
	
		if(document.form.tri_yn.value=="Y"){
			sheetObjects[0].InitDataProperty(0, 2 , dtData,		100,	daCenter,	true,		"vvd_cd",			false,      "",				dfNone,		0,			false,		true);
			sheetObjects[0].InitDataProperty(0, 4 , dtCombo,		55,		daCenter,	true,		"svc_scp_cd",			false,		"",				dfNone,		0,			true,		true);
			sheetObjects[0].InitDataProperty(0, 5 , dtCombo,		50,		daCenter,	true,		"vps_port_cd",	false,      "",				dfNone,		0,			false,		true);
			sheetObjects[0].InitDataProperty(0, 6 , dtCombo,		50,		daCenter,	true,		"io_bnd_cd",			false,		"",				dfNone,		0,			true,		true); 		
		}else{
			sheetObjects[0].InitDataProperty(0, 2 , dtData,		100,	daCenter,	true,		"vvd_cd",			false,      "",				dfNone,		0,			false,		true);
			sheetObjects[0].InitDataProperty(0, 4 , dtCombo,		55,		daCenter,	true,		"svc_scp_cd",			true,		"",				dfNone,		0,			false,		false);
			sheetObjects[0].InitDataProperty(0, 5 , dtCombo,		50,		daCenter,	true,		"vps_port_cd",	true,      "",				dfNone,		0,			false,		true);
			sheetObjects[0].InitDataProperty(0, 6 , dtCombo,		50,		daCenter,	true,		"io_bnd_cd",			false,		"",				dfNone,		0,			false,		false); 					
		}
	}
	
	function MakeComboObject(cmbObj, arrStr) {
		//IBMultiCombo초기화
		for (var i = 0; i < arrStr.length;i++ ) {
			cmbObj.InsertItem(i, arrStr[i], arrStr[i]);
		}
		cmbObj.DropHeight = 190;
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
		var rowCnt = sheetObj.RowCount;
		
		for(var i=1; i <= rowCnt ; i++){
			if(sheetObj.CellValue(i,'inv_xch_rt')!=''&&sheetObj.CellValue(i,'inv_xch_rt')!='0'){
				sheetObj.CellBackColor(i,'inv_xch_rt') = sheetObj.WebColor("FFFF00");
			}
		}
		sheetObj.SelectCell(0,0,false);
	}
	
	/**
     * RD Object 초기화 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initRdConfig(rdObject)
     * </pre>
     * @param {rdviewer} rdObject Rdviewer Object
     * @return 없음
     * @author 정휘택
     * @version 2009.10.20
     */ 
    function initRdConfig(rdObject){
	     var Rdviewer = rdObject;
	     Rdviewer.style.height = 0;
	     Rdviewer.style.width = 0;
	    
	     Rdviewer.AutoAdjust = true;
	     Rdviewer.ViewShowMode(0);
	    
		 Rdviewer.setbackgroundcolor(128,128,128);
		 Rdviewer.SetPageLineColor(128,128,128);
	 }
    
    /**
	 * print화면 오픈
	 * @param vvd VVD
	 * @param io_bnd_cd io_bnd_cd
	 */
	function rdOpen(vvd_cd, cur_cd, cnt) {
		var rdFile = "FNS_INV_0100.mrd";		
		var rdParam = "/rv frm1_vvd_cd["+vvd_cd+"] frm1_cur_cd["+cur_cd+"] frm1_cnt["+cnt+"]";
		var rdUrl = "apps/alps/fns/inv/accountreceivableinvoicemasterdatamgt/arinvoiceexratemgt/report/";
		
		rdObjects[0].FileOpen(RD_path + rdUrl + rdFile, RDServer + rdParam + "/rpagenuminit [1] /riprnmargin /rwait");
		//rdObjects[0].FileOpen("http://localhost:7001/hanjin/" + rdUrl + rdFile, RDServer + rdParam + "/rpagenuminit [1] /riprnmargin /rwait");
	}
/* 개발자 작업  끝 */