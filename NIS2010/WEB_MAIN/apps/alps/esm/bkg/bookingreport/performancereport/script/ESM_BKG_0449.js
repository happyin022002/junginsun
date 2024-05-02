/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_BKG_0449.js
*@FileTitle : Comparison Result between Split Candidates.
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.02
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2011.06.02 김기종
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
     * @class ESM_BKG_0449 : ESM_BKG_0449 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0449() {
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
    var prefix="";
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		var sheetObject1 = sheetObjects[0];
		/*******************************************************/
		var formObject = document.form;
		
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch (srcName) {
				case "btn_close":
					window.close();
					break;
				
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
					break;	
					
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}
	
    function loadPage() {
    	try {
    		for (i = 0; i < sheetObjects.length; i++) {
    			ComConfigSheet(sheetObjects[i]);
    			initSheet(sheetObjects[i], i + 1);
    			ComEndConfigSheet(sheetObjects[i]);
    		}
    		
    		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    		document.form.sXml.value = null;
    	} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
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
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj, sheetNo) {

    	var cnt = 0;

    	switch (sheetNo) {
    	case 1: //sheet1 init
    		
			with (sheetObj) {

				// 높이 설정
				style.height = 300;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				
				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);
	
				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = false;
	
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);
	
				var HeadTitle  = "seq.|CNTR Nbr.|Share\nVolume|Match\n(M/U)|Split\nMaster|E-SI|Part Load-\nS/I Count|Duplicate S/I Ref.#";
	
				var headCount = ComCountHeadTitle(HeadTitle);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false, false);
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
				
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true,false);
				
				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
				// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
				// SAVESTATUS, FORMATFIX]
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, 	dtDataSeq, 		30, 	daCenter, 		true, 		prefix+"Seq", 				false, 			"", 	dfNone, 		0, 		false, 		false);
				
				InitDataProperty(0, cnt++ , dtData,			120,	daCenter,		true,		prefix+"cntr_no",			false,			"",      dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		true,		prefix+"share_vol",			false,			"",      dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,		true,		prefix+"match_flg",			false,			"",      dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,		true,		prefix+"master_exist_flg",	false,			"",      dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,		true,		prefix+"esi_exist_flg",		false,			"",      dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,		true,		prefix+"part_load_cnt",		false,			"",      dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			70,		daLeft,			true,		prefix+"dup_si_ref",		false,			"",      dfNone,		0,		false,		false);
				SelectionMode = 0;
				SelectFontBold = true;
			    SelectHighLight = false;
			}
			break;
			
    	case 2: //sheet2 init
		
			with (sheetObj) {
	
				// 높이 설정
				style.height = 100;
				// 전체 너비 설정
				SheetWidth = 350;
				
				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);
	
				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = false;
	
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 4, 100);
	
				var HeadTitle  = "Title|Count";
	
				var headCount = ComCountHeadTitle(HeadTitle);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false, false);
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
				
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true,true);
	
				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
				// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
				// SAVESTATUS, FORMATFIX]
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtData,			300,	daLeft,		true,		prefix+"title",			false,			"",      dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		prefix+"sum_col_val",			false,			"",      dfNone,		0,		false,		false);
				CountPosition = 0;
				Visible = true;
			}
			break;
    	}
    }
   //Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj, formObj, sAction) {
		switch (sAction) {
			case IBSEARCH: //조회
				
				formObj.f_cmd.value = SEARCH;
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				
				//var sXml = sheetObj.GetSearchXml("ESM_BKG_0449GS.do", FormQueryString(formObj));
				var sXml = ComGetObjValue(formObj.sXml);
				
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0) 
					sheetObjects[0].LoadSearchXml(arrXml[0]);
				if (arrXml.length > 1) 
					sheetObjects[1].LoadSearchXml(arrXml[1]);
				
				ComSetObjValue(formObj.sXml,"");
				ComOpenWait(false);
				break;
		}
	}
     /*
      *  Sheet Click Event
      */
     function sheet1_OnClick(sheetObj,rowIdx,colIdx,val) {
     	 with (sheetObj) { 
 	        if (ColSaveName(colIdx) == prefix+"dup_si_ref") {
 	    		ComShowMemoPad(sheetObj, null,sheetObj.SaveNameCol(prefix+"dup_si_ref"), true, null, null, 1000);
 	    	}
     	 }
     }	 
     /**
      * Sheet 조회완료 후 이벤트 발생
      */
     function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	  with (sheetObj) {
    		  var blueColor = RgbColor(0, 0, 255);
    	      var redColor  = RgbColor(255, 0, 0);
              for (var i = HeaderRows ; i <= LastRow; i++) {
            	  if (CellValue(i,"master_exist_flg") == "Y" && CellValue(i,"esi_exist_flg") =="N" ){
            		  CellFontColor(i,"cntr_no") = blueColor;
            	  }else if (CellValue(i,"master_exist_flg") == "N" && CellValue(i,"esi_exist_flg") == "Y" ){
            		  CellFontColor(i,"cntr_no") = redColor;
            	  }
              }
          }
     }
	/* 개발자 작업  끝 */