	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : fns_inv_0098.js
	 *@FileTitle : Container No
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.05.04
	 *@LastModifier : 정휘택
	 *@LastVersion : 1.0
	 * 2009.05.04 정휘택
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
	 * fns_inv_0098 : fns_inv_0098 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     fns_inv_0098()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function fns_inv_0098() {
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
	
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1; 
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     processButtonClick()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
	
		/*******************************************************/
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
	
			switch(srcName) {
	
			case "btn_OK":
				if(document.form.ar_if_no.value!=""){
					closeContainerByIfNo();
				}else{
					closeContainer();
				}
				break;
	
			case "btn_close":
				window.close();                    	
				break; 
	
			case "btn_add":		        	
				sheetObject1.DataInsert(-1);
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
	 * 배열은 소스 상단에 정의 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     setSheetObject(sheetObj)
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function setSheetObject(sheetObj){
	
		sheetObjects[sheetCnt++] = sheetObj;
	
	}
	
	/**
	 * Sheet 기본 설정 및 초기화 <br>
	 * body 태그의 onLoad 이벤트핸들러 구현 <br>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     loadPage()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function loadPage() {
	
		for(i=0;i<sheetObjects.length;i++){
	
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
	
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
	
		}
	
		var row_cnt = opener.sheet_container.RowCount;
		var row = 0;
		var col = 0;
		var j=0;
	
		if(document.form.ar_if_no.value!=""){
	
			for (var i = 0; i < row_cnt; i++){
				if(document.form.ar_if_no.value==opener.sheet_container.CellValue(i+1, 'ar_if_no')){
	
					row = parseInt(j/4)+parseInt(1);
					col = parseInt(j%4)*parseInt(3);
	
					if(parseInt((j+1)%4) == 1) {
						sheetObjects[0].DataInsert(-1);
					}
	
					sheetObjects[0].CellValue2(row, col) = j+1;
					sheetObjects[0].CellValue2(row, col+1) = opener.sheet_container.CellValue(i+1, "cntr_tpsz_cd");
					sheetObjects[0].CellValue2(row, col+2) = opener.sheet_container.CellValue(i+1, "cntr_no");			        	
					j++;
				}
			}
	
		}else{
			for (var i = 0; i < row_cnt; i++){
	
				row = parseInt(i/4)+parseInt(1);
				col = parseInt(i%4)*parseInt(3);
				if(parseInt((i+1)%4) == 1) {
					sheetObjects[0].DataInsert(-1);
				}
	
				sheetObjects[0].CellValue2(row, col) = i+1;
				sheetObjects[0].CellValue2(row, col+1) = opener.sheet_container.CellValue(i+1, 1);
				sheetObjects[0].CellValue2(row, col+2) = opener.sheet_container.CellValue(i+1, 2);
	
			}
		}
	
	}
	
	/**
	 * OK 버튼 클릭시 parent 화면으로 Container 정보 전달 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     closeContainer()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function closeContainer() {
		var row_cnt = sheetObjects[0].RowCount;
		var row = 0;
		var v_tpsz = "";
		var v_cntr = "";
		opener.sheet_container.RemoveAll();
	
		var cnt_teu = 0;
		var cnt_feu = 0;
	
		for (var i = 0; i < row_cnt; i++){
			for (var j = 0; j < 4; j++){
	
				v_tpsz = sheetObjects[0].CellValue(i+1, j*3+1);
				v_cntr = sheetObjects[0].CellValue(i+1, j*3+2);
	
				if (v_tpsz != "" && v_cntr != "") {
					opener.sheet_container.DataInsert(-1);
					row++;
					opener.sheet_container.CellValue(row, 1) = sheetObjects[0].CellValue(i+1, j*3+1);
					opener.sheet_container.CellValue(row, 2) = sheetObjects[0].CellValue(i+1, j*3+2);
	
					if (sheetObjects[0].CellValue(i+1, j*3+1).substr(1,1) == "2") {
						cnt_teu++;
					} else {
						cnt_feu++;
					}
	
				}
	
			}
	
		}
	
		opener.document.form.bkg_teu_qty.value = cnt_teu;
		opener.document.form.bkg_feu_qty.value = cnt_feu;
	
		comPopupOK();
		window.close();
	
	}   
	
	
	/**
	 * OK 버튼 클릭시 parent 화면으로 Container 정보 전달 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     closeContainerByIfNo()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function closeContainerByIfNo() {
		var row_cnt = sheetObjects[0].RowCount;
		var row = 0;
		var v_tpsz = "";
		var v_cntr = "";
		for(k=1; k <= opener.sheet_container.RowCount;k++){
			if(opener.sheet_container.CellValue(k,'ar_if_no') == document.form.ar_if_no.value){
				opener.sheet_container.CellValue(k,'check') = 1;
			}
		}
	
		ComRowHideDelete(opener.sheet_container, "check");
	
		for (var i = 0; i < row_cnt; i++){
			for (var j = 0; j < 4; j++){
	
				v_tpsz = sheetObjects[0].CellValue(i+1, j*3+1);
				v_cntr = sheetObjects[0].CellValue(i+1, j*3+2);
	
				if (v_tpsz != "" && v_cntr != "") {
					insrow = opener.sheet_container.DataInsert(-1);
					row++;
					opener.sheet_container.CellValue(insrow, 'ar_if_no') =  document.form.ar_if_no.value;
					opener.sheet_container.CellValue(insrow, "cntr_tpsz_cd") = sheetObjects[0].CellValue(i+1, j*3+1);
					opener.sheet_container.CellValue(insrow, "cntr_no") = sheetObjects[0].CellValue(i+1, j*3+2);
					opener.sheet_container.CellValue(insrow, "cntr_seq") = row;
				}
	
			}
	
		}
	
		comPopupOK();
		window.close();
	
	}  
	
	/**
	 * 업무 자바스크립트 sheet1_OnChange 이벤트 처리 <br>
	 * Container Type/Size 조회 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     sheet1_OnChange(sheetObj,Row,Col,Value)
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} IBSheet의 OnChange 이벤트 발생 Row
	 * @param {int} IBSheet의 OnChange 이벤트 발생 Col
	 * @param {String} IBSheet의 OnChange 이벤트 발생 Value
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function sheet1_OnChange(sheetObj,Row,Col,Value){
	
		var formObj = document.form;
		var v_cntrCd = sheetObj.CellValue(Row, Col);
		var v_max_no = 0;    
		var cnt = 0;
		if((Col == 2 || Col == 5 || Col == 8 || Col == 11)){    
	
			for (var i = 0; i < sheetObj.RowCount; i++){
				for (var j = 2; j < 12; j=j+3){
					//alert(sheetObj.CellValue(i+1, j));            			
					if (v_cntrCd == sheetObj.CellValue(i+1, j) && v_cntrCd != ""){
						cnt++;  
					}
				}            		
			}       
	
			if (cnt > 1) {
				ComShowCodeMessage("INV00068");
				sheetObj.CellValue2(Row, Col-2) = "";
				sheetObj.CellValue2(Row, Col-1) = "";
				sheetObj.CellValue2(Row,Col) = "";
				return;
			}            	
	
			for (var i = 0; i < sheetObj.RowCount; i++){
				for (var j = 0; j < 4; j++){
					if (sheetObj.CellValue(i+1, j*3) != ""){
						v_max_no++;
					}
				}            		
			}    
	
			if (sheetObj.CellValue(Row, Col) != "") {
	
				formObj.cntr_no.value = sheetObj.CellValue(Row, Col);
				doActionIBSheet(sheetObj,document.form,IBSEARCH);   
	
				if (formObj.cntr_tpsz_cd.value != "") {
					sheetObj.CellValue2(Row, Col-1) = formObj.cntr_tpsz_cd.value;
				} else {
					ComShowCodeMessage("INV00056", formObj.cntr_no.value);
					sheetObj.CellValue2(Row, Col-2) = "";
					sheetObj.CellValue2(Row, Col-1) = "";
					sheetObj.CellValue2(Row, Col) = "";
	
					return;
				}
	
				sheetObj.CellValue2(Row, Col-2) = v_max_no+1;  
	
			}        		      		
	
		}        	
	
	}  
	
	/**
	 * 시트 초기설정값, 헤더 정의 <br> 
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     initSheet(sheetObj, 0)
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} sheetNo 시트오브젝트 태그의 아이디에 붙인 일련번호 
	 * @return 없음 
	 * @author 정휘택
	 * @version 2009.10.20     
	 */   
	function initSheet(sheetObj,sheetNo) {
	
		var cnt = 0;
	
		switch(sheetNo) {
		case 1:      //sheet1 init
		with (sheetObj) {
	
			// 높이 설정
			style.height = 220;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;
	
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;
	
			//전체Edit 허용 여부 [선택, Default false]
			var v_pagetype = document.form.pagetype.value;
			if (v_pagetype == "E") {
				Editable = true;
			} else {
				Editable = false;
			}
	
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo( 1, 1, 3, 100);
	
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(12, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false)
	
			var HeadTitle = "No.|TP/SZ|CNTR No.|No.|TP/SZ|CNTR No.|No.|TP/SZ|CNTR No.|No.|TP/SZ|CNTR No.";
	
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
	
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtData,    			 30,   daCenter,  	false,     "No1",   	false,          "",      dfNone,      	0,     false,      false);
			InitDataProperty(0, cnt++ , dtData,  		   	 40,   daCenter,    false,     "TPSZ1",    	false,          "",      dfNone,      	0,     false,      false);
			InitDataProperty(0, cnt++ , dtData,  		   	 90,   daCenter,    false,     "CNTRNo1",   false,          "",      dfNone,      	0,     true,       true);
			InitDataProperty(0, cnt++ , dtData,    			 30,   daCenter,  	false,     "No2",   	false,          "",      dfNone,  		0,     false,      false);
			InitDataProperty(0, cnt++ , dtData,  		   	 40,   daCenter,    false,     "TPSZ2",    	false,          "",      dfNone,      	0,     false,      false);
			InitDataProperty(0, cnt++ , dtData,    			 90,   daCenter,  	false,     "CNTRNo2",   false,          "",      dfNone,    	0,     true,       true);
			InitDataProperty(0, cnt++ , dtData,  		   	 30,   daCenter,    false,     "No3",    	false,          "",      dfNone,      	0,     false,      false);
			InitDataProperty(0, cnt++ , dtData,    			 40,   daCenter,  	false,     "TPSZ3",   	false,          "",      dfNone,     	0,     false,      false);
			InitDataProperty(0, cnt++ , dtData,  		   	 90,   daCenter,    false,     "CNTRNo3",   false,          "",      dfNone,      	0,     true,       true);
			InitDataProperty(0, cnt++ , dtData,    			 30,   daCenter,  	false,     "No4",   	false,          "",      dfNone,      	0,     false,      false);
			InitDataProperty(0, cnt++ , dtData,  		   	 40,   daCenter,    false,     "TPSZ4",    	false,          "",      dfNone,      	0,     false,      false);
			InitDataProperty(0, cnt++ , dtData,  		   	 90,   daCenter,    false,     "CNTRNo4",   false,          "",      dfNone,      	0,     true,       true);
	
		}
		break;
	
		}
	}
	
	/**
	 * Sheet관련 프로세스 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {form} formObj 필수 html form object
	 * @param {int} sAction 필수 프로세스 플래그 상수
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
	
		case IBSEARCH:      //조회
	
		formObj.f_cmd.value = SEARCH;
		var sXml = sheetObj.GetSearchXml("FNS_INV_0098GS.do", FormQueryString(formObj));
		var sStr = ComGetEtcData(sXml,"cntr_tpsz_cd");
	
		formObj.cntr_tpsz_cd.value = sStr;                
	
		break;    
	
		case IBSAVE:        //저장
	
		break;
	
		case IBINSERT:      // 입력
	
		break;
		}
	}
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     validateForm(sheetObj, document.form, IBSEARCH)
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {form} formObj 필수 html form object
	 * @param {int} sAction 필수 프로세스 플래그 상수
	 * @return boolean
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			//                if (!isNumber(formObj.iPage)) {
	//		return false;
	//		}
		}
	
		return true;
	}
	
	/* 개발자 작업  끝 */