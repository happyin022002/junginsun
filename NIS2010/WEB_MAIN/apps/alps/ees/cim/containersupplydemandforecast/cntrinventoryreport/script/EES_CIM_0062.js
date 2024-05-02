/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EES_CIM_0062.jsp
*@FileTitle : Mailing Service Setting
*Open Issues : 장비 과부족현황 Mailing (2014.03 ~ 2014.04)
*Change history :
*@LastModifyDate : 2014.03.31
*@LastModifier : Kim Chang Young
*@LastVersion : 1.0
* 2014.03.31 Kim Chang Young
* 1.0 Creation
=========================================================*/
	/**
	 * @extends 
	 * @class EES_CIM_0062 : EES_CIM_0062 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_CIM_0062() {
		this.processButtonClick		= tprocessButtonClick;
		this.fnCheckToggle			= fnCheckToggle;
		this.setSheetObject			= setSheetObject;
		this.loadPage				= loadPage;
		this.initSheet				= initSheet;
		this.initControl			= initControl;
		this.doActionIBSheet		= doActionIBSheet;
		this.sheet1_OnSearchEnd		= sheet1_OnSearchEnd;
		this.sheet1_OnChange		= sheet1_OnChange;
	}
	
	var sheetObjects = new Array();
	var sheetCnt = 0;

	var rXml = null;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var shtCnt = 0;
		var sheetObject1 = sheetObjects[shtCnt++];
		/*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

				case "btn_Retrieve":
					
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					
					break;

				case "btn_new":
					
					var arrXml = rXml.split("|$$|");   //<<=== 프레임웤에서 시트와 시트사이에 사용하는 문자입니다.
					
					if (arrXml.length > 0){ 
						sheetObject1.LoadSearchXml(arrXml);
					}
						
					break;
					
				case "btn_save":
					
					// UNION : 저장 후 조회, MDM : 저장 전(최초) 조회
					if(formObject.select_type.value == "UNION") {
						if(!ComIsModifiedSheets(sheetObject1)){
							// msgs['COM130503'] = 'There is no updated data to save.';
							ComShowCodeMessage("COM130503");
							return;
						}
					}
					
					// msgs['CIM00008'] = 'Do you want to save ?';
					if(!ComShowConfirm(ComGetMsg("CIM00008"))){
						return;
					}
					
					doActionIBSheet(sheetObject1, document.form, IBSAVE);
					
					break;
					
				case "btn_check":
					ComOpenWait(true);
					
					fnCheckToggle(sheetObject1, "sconti_chk", true);
					
					ComOpenWait(false);
					break;
					
				case "btn_uncheck":
					ComOpenWait(true);
					
					fnCheckToggle(sheetObject1, "sconti_chk", false);
					
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
	 * check box의 값을 전체 세팅한다.
	 */
	function fnCheckToggle(shtObj, colSaveName, bCheck) {
		shtObj.CheckAll(colSaveName) = bCheck;
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
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {

		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		initControl();
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}

	/**
	* 초기 이벤트 등록 
	*/
	function initControl() {
//		axon_event.addListener('keydown', 'ComKeyEnter', 'form');							//엔터키 조회 이벤트처리
//		axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);				//form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
//		axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form);				//form OnBeforeDeactivate이벤트에 코드 처리
//		axon_event.addListenerForm('keypress', 'obj_keypress'  , form);						//알파벳 대문자,숫자만 입력허용
//		axon_event.addListenerFormat('blur', 'obj_blur', form);
	}

	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
		
		var cnt = 0;
		var shtID = sheetObj.id;

		switch(shtID) {
			case "sheet1":	//sheet1 init
				with (sheetObj) {

					// 높이 설정
					style.height = 490;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msPrevColumnMerge;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 20, 100);
					
					var HeadTitle = "Sub Conti Hidden|Chk|Sub Conti|CN Hidden|Chk|CN|Description|";
					
					var headCount = ComCountHeadTitle(HeadTitle);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, false, false, true, false,false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHidden,		70,	  daCenter,	true,	"sconti_cd_h",	false,	"",	dfNone, 0, false, false);
					InitDataProperty(0, cnt++ , dtCheckBox,		40,	  daCenter,	true,	"sconti_chk",	false,	"",	dfNone, 0, true, true);
					InitDataProperty(0, cnt++ , dtData,			70,	  daCenter,	true,	"sconti_cd",	false,	"",	dfNone, 0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		70,	  daCenter,	true,	"cnt_cd_h",		false,	"",	dfNone, 0, false, false);
					InitDataProperty(0, cnt++ , dtCheckBox,		40,	  daCenter,	true,	"cnt_chk",		false,	"",	dfNone, 0, true, true);
					InitDataProperty(0, cnt++ , dtData,			70,	  daCenter,	true,	"cnt_cd",		false,	"",	dfNone, 0, false, false);
					InitDataProperty(0, cnt++ , dtData,			200,  daLeft,	true,	"cnt_nm",		false,	"",	dfNone, 0, false, false);
					InitDataProperty(0,	cnt++,	dtHiddenStatus,	30,	  daCenter,	false,	"ibflag");
					
					CountPosition = 2;
				}
				break;
				
			}
	}
	
	/**
	 * Sheet관련 프로세스 처리
	*/  
	function doActionIBSheet(sheetObj,formObj,sAction) {
//		sheetObj.ShowDebugMsg = true;
		switch(sAction) {

			case IBSEARCH:	  //Retrieve
				
				for(var idx=0; idx < sheetObjects.length; idx++) {
					sheetObjects[idx].RemoveAll();
				}
				
				formObj.f_cmd.value = SEARCH;
				
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);
				
				rXml = sheetObj.GetSearchXml("EES_CIM_0062GS.do",FormQueryString(formObj));
				
				formObj.select_type.value = ComGetEtcData(rXml, "select_type");
				
				var arrXml = rXml.split("|$$|");   //<<=== 프레임웤에서 시트와 시트사이에 사용하는 문자입니다.
				
				if (arrXml.length > 0){ 
					sheetObj.LoadSearchXml(arrXml);
				}
				
				
				
				ComOpenWait(false); 
				break;

			case IBSAVE:	//저장
				formObj.f_cmd.value = MULTI;

				var sParam = ComGetSaveString(sheetObj, false, false, "cnt_chk");
				
				ComOpenWait(true);
				var sXml = sheetObj.GetSaveXml("EES_CIM_0062GS.do", sParam + "&" + FormQueryString(formObj));
				ComOpenWait(false);
				
				if( typeof (sXml) == "undefined" ) return;
				
				var sExcptn = ComGetEtcData(sXml,"Exception");
				
				if(ComIsEmpty(sExcptn)){
				
					var msg = CimComGetErrMsg(sXml);
					
					if(!ComIsEmpty(msg)){
						if(msg.indexOf("successfully") > 0){ // 저장 성공이면
							doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
						}
					}
				}
			
				break;	
				
		 }
	 }
	
	/**
	 * sheet1 조회종료
	 * sheet1 조회종료후 이벤트 호출
	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		var formObj = document.form;
		
		// 저장 후 조회가 아닌경우 return (UNION : 저장 후 조회, MDM : 저장전 조회)
		if(formObj.select_type.value != "UNION") return;
		
		var sContiCd = null;
		
		var arrCntGrp = [];
		var arrContiGrp = [];
		
		// each group of sconti_cd
		var nFirstRow = 0;
		var nLastRow = 0;
		
		with(sheetObj) {
			
			for(var idx = 1; idx <= RowCount; idx++) {
				if(CellValue(idx, "cnt_chk") == 1 && sContiCd != CellValue(idx, "sconti_cd")) {
					arrCntGrp.push(idx);
					sContiCd = CellValue(idx, "sconti_cd");
				} 
			}
			
			for(var jdx = 0; jdx < arrCntGrp.length; jdx++) {
				
				nFirstRow = FindText("sconti_cd", CellValue(arrCntGrp[jdx], "sconti_cd") );
				
				for(var kdx = nFirstRow; kdx <= RowCount; kdx++) {
					
					if(CellValue(arrCntGrp[jdx], "sconti_cd") != CellValue(kdx, "sconti_cd")) {
						nLastRow = kdx - 1;
						break;
					} else if(kdx == RowCount) {
						nLastRow = RowCount;
					}
				}
				
				arrContiGrp.push(nLastRow)
				
				for(var mdx = 0; mdx < arrContiGrp.length; mdx++) {
					
					for(var ndx = nFirstRow; ndx <= arrContiGrp[mdx]; ndx++ ) {
						CellValue2(ndx, "sconti_chk") = 1;
						RowStatus(ndx) = "R";
					}
				}
				
			}
		}
	}
	
	/**
	 * sheet1 편집
	 * sheet1 셀의 값이 바뀌었을 때 발생하는 Event
	 */
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var arrScontiGrp = [];
		var sumCntChk = 0;
		
		with(sheetObj) {
			// first sconti_cd Row
			var nFirstRow = FindText("sconti_cd", CellValue(Row, "sconti_cd") );
			
			for(var idx = nFirstRow; idx <= RowCount; idx++) {
				if(CellValue(Row, "sconti_cd") == CellValue(idx, "sconti_cd")) {
					arrScontiGrp.push(idx);
				}else if(CellValue(Row, "sconti_cd") != CellValue(idx, "sconti_cd")) {
					break;
				}
			}
			
			switch(ColSaveName(Col)) {
			case "sconti_chk":
				
				for(var jdx=0; jdx < arrScontiGrp.length; jdx++) {
					CellValue2(arrScontiGrp[jdx], "sconti_chk") = Value;
					CellValue2(arrScontiGrp[jdx], "cnt_chk") = Value;
				}
				
				break;
				
			case "cnt_chk":
				
				for(var kdx=0; kdx < arrScontiGrp.length; kdx++) {
					sumCntChk = sumCntChk + CellValue(arrScontiGrp[kdx], "cnt_chk");
				}
				
				if(sumCntChk == 0) {
					CellValue(Row, "sconti_chk") = 0;
				}else {
					for(var mdx=0; mdx < arrScontiGrp.length; mdx++) {
						CellValue2(arrScontiGrp[mdx], "sconti_chk") = 1;
					}
				}
				
				break;
			}
		}
	} 