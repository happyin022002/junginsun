	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : fns_inv_0087.js
	 *@FileTitle : Invoice Remark
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.06.05
	 *@LastModifier : 정휘택
	 *@LastVersion : 1.0
	 * 2009.06.05 정휘택
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
	 * fns_inv_0087 : fns_inv_0087 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     fns_inv_0087()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function fns_inv_0087() {
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
	
		var sheetObj2 = opener.sheetObjects[0];			   
		var row = sheetObj2.SelectRow;
		var inv_no = sheetObj2.CellValue(row, 5);
	
		document.form.inv_no.value = inv_no;
		document.form.inv_iss_rmk.value = sheetObj2.cellvalue(row,"inv_iss_rmk");
	
	
	}
	
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
	
			case "btn_new":
				formObject.inv_iss_rmk.value = "";
				sheetObject1.removeall();
	
				break; 
	
			case "btn_save":
				alert("btn_save");
				break; 
	
			case "btn_OK":
				var sheetObj2 = opener.sheetObjects[0];			   
				var row = sheetObj2.SelectRow;
				var remarks = "";    	         	 
				sheetObj2.cellvalue(row, "inv_iss_rmk") = formObject.inv_iss_rmk.value;
				window.close();
	
				break;
	
			case "btn_close":
	
				window.close();
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
	 * Remark 입력 길이 제한 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     remarkLengthCheck(thisObj, maxLengthByte)
	 * </pre>
	 * @param {object} Remark Object
	 * @param {int} 입력가능 최대 byte
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */ 
	function remarkLengthCheck(thisObj, maxLengthByte) { 
		var tempByteLength = 0, cutByteLength = 0;  
		for(var i = 0; i < thisObj.value.length; i++) {  
			if(escape(thisObj.value.charAt(i)).length > 4) {  
				tempByteLength += 2; 
			} else { 
				tempByteLength++;  
			} 
			if(tempByteLength < maxLengthByte) {  
				cutByteLength++;  
			} 
		}  
		if(tempByteLength > maxLengthByte) {  
	
			thisObj.blur();
			thisObj.focus();
			thisObj.value = thisObj.value.substring(0, cutByteLength+1);  
	
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
		break;
	
		case IBSAVE:        //저장
		break;
	
		case IBINSERT:      // 입력
		break;
	
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
	
		case 1:     
			with (sheetObj) {            	
	
				// 높이 설정
				style.height = 200;
	
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
				InitHeadMode(true, true, false, true, false,false);
	
				var HeadTitle1 = " |inv_no|inv_iss_rmk";
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false] 
				InitHeadRow(0, HeadTitle1, true);
	
				WaitImageVisible = false;
	
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,  30,    daCenter,  false,   "ibflag");
				InitDataProperty(0, cnt++ , dtData,          150,    daCenter,  false,   "inv_no", 	false,     "",      dfNone,    0,  false,	false);
				InitDataProperty(0, cnt++ , dtData,          150,    daCenter,  false,   "inv_iss_rmk", 	false,     "",      dfNone,    0,  false,	false);
	
				CountPosition = 0;   
	
			}
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
			//             if (!isNumber(formObj.iPage)) {
			//		return false;
			//		}
		}
	
		return true;
	}
	
	/* 개발자 작업  끝 */