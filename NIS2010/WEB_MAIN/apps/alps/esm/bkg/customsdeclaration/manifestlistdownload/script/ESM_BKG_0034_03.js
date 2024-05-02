/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0034_03.js
 *@FileTitle : B/L Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.05
 *@LastModifier : 이수빈
 *@LastVersion : 1.0
 * 2009.06.05 이수빈
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
	 * @class ESM_BKG_0034_03 : ESM_BKG_0034_03 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESM_BKG_0034_03() {
		this.setSheetObject = setSheetObject;
		this.loadPage = loadPage;
		this.initSheet = initSheet;
		this.doActionIBSheet = doActionIBSheet;
		this.validateForm = validateForm;
	} 
	
	/* 개발자 작업 */
	
	// 공통전역변수
	var tabObjects = new Array();
	var tabCnt = 0;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
			
	/**
	 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
	 * 상단에 정의
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	
	/**
	 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
	 * 추가한다
	 */
	function loadPage() {
	
		for (i = 0; i < sheetObjects.length; i++) {
			// khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
	
			initSheet(sheetObjects[i], i + 1);
			// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}

		if (document.form.bl_no.value != "") {
			doActionIBSheet(sheetObjects[1],document.form,IBSEARCH_ASYNC01);
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}
		
		if (parent.loadTabPage != undefined)
			// 페이지 로드 후 조회 되도록 해당 tab을 다시 호출하여 로드 
			parent.loadTabPage(2);
	}

	
	/**
	 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
	 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj, sheetNo) {
	
		var cnt = 0;
		switch(sheetNo) {
		case 1:
			with (sheetObj) {
				// 높이 설정
				style.height = 280;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);


				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false, false)

				var HeadTitle = "Seq.|C|Code|Q'ty|Entry Type & No.|Entry Type & No.|Receive Date/Time|Customs|VVD|Remark|SCAC|AMS File No.|Batch|||||||||cstms_loc_diff_flg|";
				var headCount = ComCountHeadTitle(HeadTitle);
				
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);


				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtSeq,		35,		daCenter,	false,		"Seq",				false,		"",	dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		35,		daCenter,	false,		"cstms_clr_cd",		false,		"",	dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		40,		daCenter,	false,		"dspo_cd",			false,		"",	dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		40,		daCenter,	false,		"cntr_qty",			false,		"",	dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		30,		daCenter,	true,		"entr_tp_no",		false,		"",	dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		110,	daCenter,	true,		"entr_no",			false,		"",	dfNone,			0,		false,		false);

				InitDataProperty(0, cnt++ , dtData,		130,	daCenter,	false,		"rcv_date",			false,		"",	dfUserFormat2,	0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		65,		daCenter,	false,		"rcv_loc_cd",		false,		"",	dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		75,		daCenter,	false,		"vvd",				false,		"",	dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		200,	daLeft,		false,		"cstms_rmk",		false,		"",	dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		45,		daCenter,	false,		"scac_cd",			false,		"",	dfNone,			0,		false,		false);

				InitDataProperty(0, cnt++ , dtData,		110,	daCenter,	false,		"ibd_ref_no",		false,		"",	dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		40,		daCenter,	false,		"cstms_bat_no",		false,		"",	dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,	45,		daCenter,	false,		"cnt_cd",			false,		"",	dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,	45,		daCenter,	false,		"io_bnd_cd",		false,		"",	dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,	45,		daCenter,	false,		"bl_no",			false,		"",	dfNone,			0,		false,		false);

				InitDataProperty(0, cnt++ , dtHidden,	45,		daCenter,	false,		"pol_cd",	false,		"",	dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,	45,		daCenter,	false,		"pod_cd",	false,		"",	dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,	45,		daCenter,	false,		"rcv_msg_tp_id",	false,		"",	dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,	45,		daCenter,	false,		"rcv_seq",			false,		"",	dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,	45,		daCenter,	false,		"rjct_flg",			false,		"",	dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,	45,		daCenter,	false,		"cstms_loc_diff_flg",false,		"",	dfNone,			0,		false,		false);

				InitUserFormat2(0, "rcv_date", "####-##-## ##:##:##", "-|:|:" );

				WordWrap = true;
				//토탈카운트표시 
				CountFormat = "[SELECTDATAROW / TOTALROWS]"; 
			}
			break;
			
		case 2:
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
				Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(3, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false, false);

				var HeadTitle = "Seq|Code|Desc";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, 0, 	dtSeq,		40,		daCenter,	false,		"Seq");
				InitDataProperty(0, 1, 	dtData,		90,		daCenter,	false,		"cstms_dspo_cd",	false,		"",	dfNone,			0,		false,		false);
				InitDataProperty(0, 2, 	dtData,		45,		daLeft,		false,		"cstms_dspo_nm",	false,		"",	dfNone,			0,		false,		false);
			}
			break;
		}
	}

	/**
	 * 시트 데이터 조회 후 처리 - SCAC 데이터에 따라 텍스트 컬러 세팅
	 * Black : SCAC = “SMLM” 인 경우
	 * Blue  : SCAC = “SMLM” 이 아닌 경우 (SNP 수신)
	 * Red   : MR/AR에 Rejection Message 가 포함되어 있는 경우, 2Z 인 경우 
	 */
	function t3sheet1_OnSearchEnd(sheetObj,ErrMsg)
	{   
	    for(i=1; i<sheetObj.RowCount+1; i++){
	    	if (sheetObj.CellValue(i, "dspo_cd") == "AR" || sheetObj.CellValue(i, "dspo_cd") == "MR"){
		       	if (sheetObj.CellValue(i, "rjct_flg") == "Y" || sheetObj.CellValue(i, "cstms_rmk") != "") {
		       		sheetObj.RowFontColor(i) = sheetObj.RgbColor(255, 0, 0); //red
		       	}
		       	
	    	}else{
		       	if (sheetObj.CellValue(i, "scac_cd") != "SMLM") {
		       		sheetObj.RowFontColor(i) = sheetObj.RgbColor(0, 0, 255); //blue
		       	}
	    	}
	    	
	    	if( (sheetObj.CellValue(i, "dspo_cd") == "1C" || sheetObj.CellValue(i, "dspo_cd") == "12")
	    		&& sheetObj.CellValue(i, "cstms_loc_diff_flg") == "Y") {
	    		
	    		sheetObj.CellBackColor(i, "rcv_loc_cd") = sheetObj.RgbColor(0, 255, 0); 
	    	}
	    	//2Z error의 경우 R02 라인 내용을 Remark로 빨간색 표기
	    	if( sheetObj.CellValue(i, "dspo_cd") == "2Z" && parent.document.form.cstms_file_tp_cd.value == "02" ) {
	       		sheetObj.CellFontColor(i, "cstms_rmk") = sheetObj.RgbColor(255, 0, 0); //red
	    	}
	    }
	}

	/**
	 * 시트 클릭 시 hidden 태그에 데이터 세팅
	 */
	function t3sheet1_OnClick(sheetObj, Row, Col) {
		var formObj = document.form;
		formObj.cnt_cd.value = sheetObj.CellValue(Row, "cnt_cd");
		formObj.io_bnd_cd.value = sheetObj.CellValue(Row, "io_bnd_cd");
		formObj.rcv_date.value = sheetObj.CellValue(Row, "rcv_date");
		formObj.rcv_seq.value = sheetObj.CellValue(Row, "rcv_seq");
	}

	/**
	 * 시트 위에 마우스 오버 시 툴팁 보여주기
	 */
	function t3sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
		//마우스 위치를 행과 컬럼과 값 가져오기
	    var Row = sheetObj.MouseRow;
	    var Col = sheetObj.MouseCol;
	    var sText;
	    
	    var sheetObj2 = sheetObjects[1];
	    if(sheetObj.ColSaveName(Col) == "dspo_cd") {
	    	for(var i=1; i<sheetObj2.RowCount; i++){
	    		if(sheetObj.CellText(Row, Col) == "AR") continue;
	    		if(sheetObj.CellText(Row, Col) == sheetObj2.CellText(i,"cstms_dspo_cd")){
	    			sText = sheetObj2.CellText(i,"cstms_dspo_nm");
	    			break;
	    		}
	    	}
	    	sheetObj.ToolTipText(Row,"dspo_cd") = sText;
	    }
	}
	
	/** 
	 * Sheet관련 프로세스 처리
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		//sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;
		
		switch (sAction) {
			case IBSEARCH: // 조회
				if (validateForm(sheetObj,formObj,sAction)) {
//					ComOpenWait(true);
					formObj.f_cmd.value = SEARCH01;
					sheetObj.DoSearch("ESM_BKG_0034_03GS.do", FormQueryString(formObj));

					formObj.cnt_cd.value = sheetObj.CellValue(1, "cnt_cd");
					formObj.io_bnd_cd.value = sheetObj.CellValue(1, "io_bnd_cd");
					formObj.rcv_date.value = sheetObj.CellValue(1, "rcv_date");
					formObj.rcv_seq.value = sheetObj.CellValue(1, "rcv_seq");
					
					var formP = parent.document.form;
					if (formP.pod_cd.value.substr(0,2) != 'US' && formP.del_cd.value.substr(0,2) == 'US')
					{
						sheetObj.ColBackColor("cstms_clr_cd") = sheetObj.RgbColor(239,240,243);
					}
//					ComOpenWait(false);
				}
				break;
				
			case IBSEARCH_ASYNC01: // DSPO_CD 에 마우스 오버시 Description 조회
				formObj.f_cmd.value = SEARCH04;
				formObj.cnt_cd.value = 'US';
				sheetObj.DoSearch("ESM_BKG_0034_03GS.do", FormQueryString(formObj));
				break;
		}
	}
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSEARCH: // 조회
			if (formObj.bl_no.value == "") {
				return false;
			} else {
				return true;
			}
			break;
		}
	}

	/**
	 * 탭 클릭 시 조회
	 */
	function tabLoadSheet(strBlNo) {
		var formObject = document.form;
		
		if (formObject.bl_no.value != strBlNo) {
			formObject.bl_no.value = strBlNo;

			doActionIBSheet(sheetObjects[1], formObject, IBSEARCH_ASYNC01);
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);

			if(sheetObjects[0].RowCount > 0){
				ComBtnEnable("btn_view");
			}
		}
	}

	/**
	 * 탭 데이터 초기화
	 */
	function tabClearSheet() {
		document.form.bl_no.value = "";
		sheetObjects[0].RemoveAll();
	}

	/**
	 * 탭 활성화 처리
	 */
	var enableFlag = true;
	function tabEnableSheet(flag) {
		var formObject = document.form;
		
		enableFlag = flag;
		
		sheetObjects[0].Editable = flag;
	}

	/**
	 * 시트 데이터 스트링으로 반환
	 */
	function getSaveString() {
		
		var sheetObj = sheetObjects[0];
		
		if(sheetObj.TotalRows > 0){
			var params;
		 	var rcv_date = sheetObj.CellValue(sheetObj.SelectRow, "rcv_date");
		 	var rcv_seq = sheetObj.CellValue(sheetObj.SelectRow, "rcv_seq");
		 	params = "&cnt_cd=US&io_bnd_cd=I&rcv_date="+rcv_date+"&rcv_seq="+rcv_seq;
			return params;
		}
		else{
			return "";
		}
	}

	/**
	 * 시트 데이터 xml 로 반환

	function getRDDataXml() {
		return RD_GetDataSearchXml(sheetObjects[0], 1);
	}
	 */
	
	/* 개발자 작업 끝 */