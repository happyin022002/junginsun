/*=========================================================
* Copyright(c) 2006 CyberLogitec
* @FileName : ESM_BSA_0035.js
* @FileTitle : Error Finder
* Open Issues :
* Change history :
* @LastModifyDate : 2014-12-10
* @LastModifier : Kim Yongseup
* @LastVersion : 1.0
*  2014-12-10 Kim Yongseup
*  1.0 최초 생성 
*=========================================================*/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
	/**
	 * @extends 
	 * @class ESM_BSA_0035 : ESM_BSA_0035 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESM_BSA_0035() {
	    this.processButtonClick		= processButtonClick;
	    this.loadPage 				= loadPage;
	    this.initSheet 				= initSheet;
	    this.setSheetObject 		= setSheetObject;
	    this.doActionIBSheet 		= doActionIBSheet;
	}

	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var sheet_selno = ""; //현재선택된 SHEET
	
	var JOINT_OPERATING  = "";
	var SPACE_CHARTERING = "";
	var SLOT_PRICE = "";
	
	var splitPos1 = new Array(0, 3, 6, 9, 12, 15);
	var splitPos2 = new Array(0, 3, 6, 9, 12, 15);
	
	var fixCnt1 = 20; //Sheet1 고정길이 
	var fixCnt2 = 17; //Sheet2 고정길이 
	var fixCnt3 = 17; //Sheet3 고정길이  
	
	var selRow = 0;
	var selValue = "";
	
	var sheet_height1 = 20; // sheet1의 height
	var sheet_height2 = 20; // sheet2의 height
	var sheet_height3 = 20; // sheet3의 height
	var zoomFlag1 = "close"; // Zoom Flag #1
	var zoomFlag2 = "close"; // Zoom Flag #2
	var zoomFlag3 = "close"; // Zoom Flag #3
	
	var first_load1 = true;  //최초 Load시만 sheet1 height 조정
	var first_load2 = true;  //최초 Load시만 sheet2 height 조정
	var first_load3 = true;  //최초 Load시만 sheet3 height 조정
	
	
	var comboObjects = new Array();
	var comboCnt = 0;
	var loadingMode = false;
	
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
		
		JOINT_OPERATING  = document.form.rdoOp_cd[0].value;
		SPACE_CHARTERING = document.form.rdoOp_cd[1].value;
		SLOT_PRICE = 	   document.form.rdoOp_cd[2].value;
		document.getElementById("tabLayer2").style.display = "none";
		document.getElementById("tabLayer3").style.display = "none";
		
		sheet_selno = JOINT_OPERATING; //현재선택된 SHEET (첫번째 쉬트)
//		set_Zoom();
		
		// 멀티콤보 처리
		loadingMode = true;
		loadCombo();
		
		for(k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],comboObjects[k].id);
		}
		loadingMode = false;
		
		document.form.cobTrade.Index = opener.document.form.cobTrade.Index;
		document.form.cobLane.Index = opener.document.form.cobLane.Index;
		document.form.cobDir.Index = opener.document.form.cobDir.Index;
	}
	
	function loadCombo() {
    	var formObj = document.form;
 		var sXml = formObj.sXml.value;

 		var arrXml = sXml.split("|$$|");
 		
 		if (arrXml.length > 0)
			ComXml2ComboItem(arrXml[0], formObj.cobTrade, "code", "code");
		if (arrXml.length > 1)
			ComXml2ComboItem(arrXml[1], formObj.cobLane, "code", "code");
		if (arrXml.length > 2)
			ComXml2ComboItem(arrXml[2], formObj.cobDir, "code", "code");
 		document.form.sXml.value="";
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
	* 배열은 소스 상단에 정의
	*/
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}
	
	
	/**
	* IBSheet의 콤보 컬럼에 데이터를 setting한다. <br>
	*/
	function setIBMultiCombo(sheetObj, sXml ,objName){
		if (sXml == undefined || sXml == ""){
			return;
		}
		var arrData = ComCoaXml2SheetMultiComboString(sXml, "code", "code");
		sheetObj.InitDataCombo(0,objName, arrData[1], arrData[0],"","");		
	}
	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var sheetObject3 = sheetObjects[2];
		var formObject = document.form;
		
		try {
			var srcName = window.event.srcElement.getAttribute("name");
		
			switch(srcName) {
				case "btn_retrieve":
					if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
						doActionIBSheet2(sheetObject2,formObject,IBSEARCH);
					} else if (sheet_selno == SLOT_PRICE) { //세번째 SHEET 이면
						doActionIBSheet3(sheetObject3,formObject,IBSEARCH);
					}
					break;
		
				case "btn_downexcel":
					if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
						doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
					} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
						doActionIBSheet2(sheetObject2,formObject,IBDOWNEXCEL);
					} else if (sheet_selno == SLOT_PRICE) { //두번째 SHEET 이면
						doActionIBSheet3(sheetObject3,formObject,IBDOWNEXCEL);
					}
					break;
		
				case "btns_calendar1":
					var cal = new ComCalendar();
					cal.select(formObject.txtSDate, 'yyyy-MM-dd');
					break;
		
				case "btns_calendar2":
					var cal = new ComCalendar();
					cal.select(formObject.txtEDate, 'yyyy-MM-dd');
					break;
		
				case "rdoOp_cd":
					if (formObject.rdoOp_cd[0].checked) { //JO 선택시
						document.getElementById("tabLayer1").style.display= "inline";
						document.getElementById("tabLayer2").style.display= "none";
						document.getElementById("tabLayer3").style.display= "none";
						sheet_selno = formObject.rdoOp_cd[0].value; //'J'
					} else if (formObject.rdoOp_cd[1].checked) { //SC 선택시
						document.getElementById("tabLayer1").style.display= "none";
						document.getElementById("tabLayer2").style.display= "inline";
						document.getElementById("tabLayer3").style.display= "none";
						sheet_selno = formObject.rdoOp_cd[1].value; //'S'
					} else if (formObject.rdoOp_cd[2].checked) { //SP 선택시
						document.getElementById("tabLayer1").style.display= "none";
						document.getElementById("tabLayer2").style.display= "none";
						document.getElementById("tabLayer3").style.display= "inline";
						sheet_selno = formObject.rdoOp_cd[2].value; //'P'
					}
//					set_Zoom();
					break;
		
				case "bu_zoom_in1": //next
				case "bu_zoom_in2":
				case "bu_zoom_in3":
					if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
						sheet_height1 = getSheetHeightCnt(sheetObject1,"MAX",1);
						sheetObject1.style.height = sheetObject1.GetSheetHeight(sheet_height1);
						zoomFlag1 = "open";
					} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
						sheet_height2 = ComGetSheetViewRows(sheetObject2,"MAX",1);
						sheetObject2.style.height = sheetObject2.GetSheetHeight(sheet_height2);
						zoomFlag2 = "open";
					} else if (sheet_selno == SLOT_PRICE) { //세번째 SHEET 이면
						sheet_height3 = ComGetSheetViewRows(sheetObject3,"MAX",1);
						sheetObject3.style.height = sheetObject3.GetSheetHeight(sheet_height3);
						zoomFlag3 = "open";
					}
//					set_Zoom();
					break;
		
				case "bu_zoom_out1": //next
				case "bu_zoom_out2":
				case "bu_zoom_out3":	
					if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
						sheet_height1 = getSheetHeightCnt(sheetObject1,"MIN",0);
						sheetObject1.style.height = sheetObject1.GetSheetHeight(sheet_height1);
						zoomFlag1 = "close";
					} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
						sheet_height2 = ComGetSheetViewRows(sheetObject2,"MIN",0);
						sheetObject2.style.height = sheetObject2.GetSheetHeight(sheet_height2);
						zoomFlag2 = "close";
					} else if (sheet_selno == SLOT_PRICE) { //세번째 SHEET 이면
						sheet_height3 = ComGetSheetViewRows(sheetObject3,"MIN",0);
						sheetObject3.style.height = sheetObject3.GetSheetHeight(sheet_height3);
						zoomFlag3 = "close";
					}
//					set_Zoom();
					break;		
					
				case "btn_close":
                    window.close();
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
	* 시트 초기설정값, 헤더 정의
	* param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	*/
	function initSheet(sheetObj,sheetNo) {
		var formObj = document.form;
		var head0    = "";
		
		var cnt = 0;
		var HeadTitle0 = "";
		var n = 0;
		
		switch(sheetNo) {
			case 1:      //sheet1 init
		
				with (sheetObj) {
					if (first_load1 == true) { style.height = GetSheetHeight(sheet_height1); }
					first_load1 = false;
		
					SheetWidth = mainTable1.clientWidth;
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					MergeSheet = msHeaderOnly;
		
					Editable = true;
					InitRowInfo(1, 1, 9, 100);
					InitColumnInfo(10, 0, 0, true);
					InitHeadMode(true, true, false, true, false, false);
		
					HeadTitle0 = "Seq.|VVD|From|To|Trade|R.Lane|Dir.|OPR|Loadable\nCapacity|Reverse\nFlag";
		
					//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle0, true);
							
					//데이터속성  DataRow, Col, [DataType], [Width], [DataAlign],
					//          [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat],
					//          [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort],
					//          [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
					cnt = 0;
					
					InitDataProperty(0, cnt++, dtData,    30, daCenter, true, "bsa_seq",              false, "", dfInteger, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    75, daCenter, true, "vvd_cd",               false, "", dfNone,    0, false,  false);
					InitDataProperty(0, cnt++, dtData,    75, daCenter, true, "bsa_fm_dt",            false, "", dfDateYmd, 0, false,  false);
					InitDataProperty(0, cnt++, dtData,    75, daCenter, true, "bsa_to_dt",            false, "", dfDateYmd, 0, false,  false);					
					InitDataProperty(0, cnt++, dtData,    40, daCenter, true, "trd_cd",               false, "", dfNone,    0, false, false);
					InitDataProperty(0, cnt++, dtData,    50, daCenter, true, "rlane_cd",             false, "", dfNone,    0, false, false);
					InitDataProperty(0, cnt++, dtData,    40, daCenter, true, "dir_cd",               false, "", dfNone,    0, false, false);
					InitDataProperty(0, cnt++, dtData,    40, daCenter, true, "vop_cd",               false, "", dfNone,    0, false, false);					
					InitDataProperty(0, cnt++, dtData, 	  110, daRight,  true, "vsl_capa",            false, "", dfInteger, 0, false,  false);
					InitDataProperty(0, cnt++, dtData,    75, daCenter, true, "reverse_flg",          false, "", dfNone,    0, false,  false);
					
					CountPosition  = 0 ;
				}
				break;
		
			case 2:      //sheet2 init
				
				with (sheetObj) {
				if (first_load2 == true) { style.height = GetSheetHeight(sheet_height2); }
				first_load2 = false;
	
				SheetWidth = mainTable1.clientWidth;
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				MergeSheet = msHeaderOnly;
	
				Editable = true;
				InitRowInfo(1, 1, 9, 100);
				InitColumnInfo(8, 0, 0, true);
				InitHeadMode(true, true, false, true, false, false);
	
				HeadTitle0 = "Seq.|VVD|From|To|Trade|R.Lane|Dir.|Reverse\nFlag";
	
				//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);
						
				//데이터속성  DataRow, Col, [DataType], [Width], [DataAlign],
				//          [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat],
				//          [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort],
				//          [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
				cnt = 0;
				
				InitDataProperty(0, cnt++, dtData,    30, daCenter, true, "bsa_seq",              false, "", dfInteger, 0, false, false);
				InitDataProperty(0, cnt++, dtData,    75, daCenter, true, "vvd_cd",               false, "", dfNone,    0, false,  false);
				InitDataProperty(0, cnt++, dtData,    75, daCenter, true, "bsa_fm_dt",            false, "", dfDateYmd, 0, false,  false);
				InitDataProperty(0, cnt++, dtData,    75, daCenter, true, "bsa_to_dt",            false, "", dfDateYmd, 0, false,  false);					
				InitDataProperty(0, cnt++, dtData,    40, daCenter, true, "trd_cd",               false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtData,    50, daCenter, true, "rlane_cd",             false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtData,    40, daCenter, true, "dir_cd",               false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtData,    75, daCenter, true, "reverse_flg",          false, "", dfNone,    0, false,  false);
				
				CountPosition  = 0 ;
				
				}
				break;
				
			case 3:      //sheet3 init
				
				with (sheetObj) {
				if (first_load3 == true) { style.height = GetSheetHeight(sheet_height3); }
				first_load3 = false;
	
				SheetWidth = mainTable1.clientWidth;
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				MergeSheet = msHeaderOnly;
	
				Editable = true;
				InitRowInfo(1, 1, 9, 100);
				InitColumnInfo(8, 0, 0, true);
				InitHeadMode(true, true, false, true, false, false);
	
				HeadTitle0 = "Seq.|VVD|From|To|Trade|R.Lane|Dir.|Reverse\nFlag";
	
				//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);
						
				//데이터속성  DataRow, Col, [DataType], [Width], [DataAlign],
				//          [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat],
				//          [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort],
				//          [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
				cnt = 0;
				
				InitDataProperty(0, cnt++, dtData,    30, daCenter, true, "bsa_seq",              false, "", dfInteger, 0, false, false);
				InitDataProperty(0, cnt++, dtData,    75, daCenter, true, "vvd_cd",               false, "", dfNone,    0, false,  false);
				InitDataProperty(0, cnt++, dtData,    75, daCenter, true, "bsa_fm_dt",            false, "", dfDateYmd, 0, false,  false);
				InitDataProperty(0, cnt++, dtData,    75, daCenter, true, "bsa_to_dt",            false, "", dfDateYmd, 0, false,  false);					
				InitDataProperty(0, cnt++, dtData,    40, daCenter, true, "trd_cd",               false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtData,    50, daCenter, true, "rlane_cd",             false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtData,    40, daCenter, true, "dir_cd",               false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtData,    75, daCenter, true, "reverse_flg",          false, "", dfNone,    0, false,  false);
				
				CountPosition  = 0 ;
				}
				break;
		}
	}	
	
	/**
	* 콤보 항목 설정
	*/
	function initCombo (comboObj, comboNo) {
		with (comboObj) {
			DropHeight = 300;
			comboObj.InsertItem(0, 'All' ,'All'); 
			Index = 0;
		}
	}
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		
		switch(sAction) {		
			case IBSEARCH:      //조회
				sheetObj.WaitImageVisible = true;
				
				if (!validateCond(formObj, sAction)) {
					return false;
				}				
				
				formObj.f_cmd.value = SEARCHLIST01;
								
				sheetObj.DoSearch("ESM_BSA_0035GS.do", FormQueryString(formObj));
				
				sheetObj.InitHeadMode(true, true, false, true, false, false); //Sort가능
		
				break;
		
			case IBDOWNEXCEL:   //엑셀 다운로드
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
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet2(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		
		switch(sAction) {		
			case IBSEARCH:      //조회
				sheetObj.WaitImageVisible = true;
				
				if (!validateCond(formObj, sAction)) {
					return false;
				}				
				
				formObj.f_cmd.value = SEARCHLIST02;
								
				sheetObj.DoSearch("ESM_BSA_0035GS.do", FormQueryString(formObj));
				
				sheetObj.InitHeadMode(true, true, false, true, false, false); //Sort가능
		
				break;
		
			case IBDOWNEXCEL:   //엑셀 다운로드
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
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet3(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		
		switch(sAction) {		
			case IBSEARCH:      //조회
				sheetObj.WaitImageVisible = true;
				
				if (!validateCond(formObj, sAction)) {
					return false;
				}				
				
				formObj.f_cmd.value = SEARCHLIST03;
								
				sheetObj.DoSearch("ESM_BSA_0035GS.do", FormQueryString(formObj));
				
				sheetObj.InitHeadMode(true, true, false, true, false, false); //Sort가능
		
				break;
		
			case IBDOWNEXCEL:   //엑셀 다운로드
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
	* 화면 조회값에 대한 유효성검증 프로세스 처리
	*/
	function validateCond(formObj, sAction) {
		with(formObj){	
			if (ComTrim(txtSDate.value) == "") {
				//ComShowMessage(ComGetMsg('COM12130','Period','First Element'));
				//formObj.txtSDate.focus();
				ComAlertFocus(txtSDate, ComGetMsg('COM12130','Period','First Element'));
	
				return false;
			}
		}		
		return true;
	}
	
	//화면의 Enter-Key 처리
	function keyEnter_loc(){
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var sheetObject3 = sheetObjects[2];
		var formObject = document.form;
		if (event.keyCode == 13) {
			if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
				doActionIBSheet(sheetObject1,formObject,IBSEARCH);
			} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
				doActionIBSheet2(sheetObject2,formObject,IBSEARCH);
			} else if (sheet_selno == SLOT_PRICE) { //두번째 SHEET 이면
				doActionIBSheet3(sheetObject3,formObject,IBSEARCH);
			}
		}
	}
	
	//화면의 Zoom 처리
	function set_Zoom() {
		if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
			if (zoomFlag1 == "open") {
				div_zoom_in1.style.display  = "none";  
				div_zoom_out1.style.display = "inline";
			} else if (zoomFlag1 == "close") {
				div_zoom_in1.style.display  = "inline"; 
				div_zoom_out1.style.display = "none";
			} 
			div_zoom_in2.style.display  = "none";
			div_zoom_out2.style.display = "none";
			div_zoom_in3.style.display  = "none";
			div_zoom_out3.style.display = "none";
		
		} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
			div_zoom_in1.style.display  = "none";
			div_zoom_out1.style.display = "none";
			div_zoom_in3.style.display  = "none";
			div_zoom_out3.style.display = "none";
			if (zoomFlag2 == "open") {
				div_zoom_in2.style.display  = "none";  
				div_zoom_out2.style.display = "inline";
			} else if (zoomFlag2 == "close") {
				div_zoom_in2.style.display  = "inline"; 
				div_zoom_out2.style.display = "none";
			}		
		} else if (sheet_selno == SLOT_PRICE) { //두번째 SHEET 이면
			div_zoom_in1.style.display  = "none";
			div_zoom_out1.style.display = "none";
			div_zoom_in2.style.display  = "none";
			div_zoom_out2.style.display = "none";
			if (zoomFlag3 == "open") {
				div_zoom_in3.style.display  = "none";  
				div_zoom_out3.style.display = "inline";
			} else if (zoomFlag3 == "close") {
				div_zoom_in3.style.display  = "inline"; 
				div_zoom_out3.style.display = "none";
			}		
		}
	}
	
	//추가------------------------------------------------------------------------------------------------------
	
	/**
	* IBSheet의 GetSearchXml 함수 또는 GetSaveXml 함수를 통해 받아온 XML 문자열을 파싱하여 그 안에 ETC-DATA로 넣은 KEY의 값을 리턴한다.
	* <br><b>Example :</b>
	* <pre>
	*     xmlStr = mySheet.GetSearchXml("list.jsp");
	*     sValue = ComGetEtcData(xmlStr, "UserId");
	*     예를 들어 xmlStr의 내용이 아래와 같다면 sValue의 값은 "ibs006"이 된다.
	*     xmlStr ======================================================
	*       &lt;?xml version='1.0' ?&gt;
	*       &lt;SHEET&gt;
	*         &lt;ETC-DATA&gt;
	*              &lt;ETC KEY="UserId"&gt;ibs006&lt;/ETC&gt;
	*              &lt;ETC KEY="UserName"&gt;khlee&lt;/ETC&gt;
	*         &lt;/ETC-DATA&gt;
	*       &lt;/SHEET&gt;
	*     xmlStr ======================================================
	* </pre>
	* @param   {string} xmlStr     필수,IBSheet를 통해 받아온 xml 문자열
	* @param   {string} etcName    필수,xml 문자열에서 추출하고자하는 ETC Key이름
	* @return  string, ETC-DATA로 넣은 KEY의 값
	* @version 3.4.0.50
	*/
	function GetEtcDataForExceptional0035(xmlStr,etcName){
		if(xmlStr == null  || xmlStr == "" || etcName == null || etcName == "") return;
		
		try {
			var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
			xmlDoc.loadXML(xmlStr);
			
			var xmlRoot = xmlDoc.documentElement;
			if(xmlRoot == null) return;
			
			var etcDataNode = xmlRoot.getElementsByTagName("ETC-DATA").item(0);
			if(etcDataNode == null) return;
			
			var etcNodes = etcDataNode.childNodes;
			if(etcDataNode == null) return;
			
			for(var i=0;i<etcNodes.length;i++){
				if(etcNodes[i].nodeType!=1 || etcNodes[i].attributes.length == 0) continue;
				
				if(etcNodes[i].attributes(0).text==etcName) {
					if (etcNodes[i].firstChild==null) {
						return "";
					} else {
						return etcNodes[i].firstChild.nodeValue;
					}
				}
			}
		} catch(err) { ComFuncErrMsg(err.message); }
	}
	
	function ComAddSeparator_Local(obj, sFormat) {
		try {
			//obj.value = obj.value.substring(0, obj.value.indexOf("-")) + obj.value.substring(obj.value.indexOf("-")+1, obj.value.length);
		} catch(err) { ComFuncErrMsg(err.message); }
	}
	/**
	* trade코드 변경시 rLane 리스트를 리플래쉬 한다.
	*/
	function cobTrade_OnChange(obj) {
		if (loadingMode == true) return; 
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		var param = "";
		var trd_cd = "";
		sheetObj.WaitImageVisible = false;
		
		if(obj.Text != ""){
			trd_cd = obj.Code;
			param = "f_cmd="+SEARCHLIST01;
			param = param+"&trd_cd="+trd_cd;
			param = param+"&code=rLane";
			var sXml = sheetObj.GetSearchXml("ESM_BSA_CODE.do", param);
			
			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], formObj.cobLane, "code", "code");
			formObj.cobLane.Index = 0;
		}
		sheetObj.WaitImageVisible = true;
	}
