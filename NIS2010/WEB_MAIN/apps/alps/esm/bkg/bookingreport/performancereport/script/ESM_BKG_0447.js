/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_BKG_0447.js
*@FileTitle : SR FAX  Recving List - EMLContents 조회 팝업
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.14
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2011.03.14 김기종
* 1.0 Creation
* 2011.10.04 정선용 [CHM-201112445] SI Automation System 구축
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
     * @class ESM_BKG_0447 : ESM_BKG_0447 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0447() {
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
    var prefix = "sheet1_";
    
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
				case "btn_Print":
					sheetObjects[1].Down2Print(true, poPortrait , "Mail Contents","0","3");
					break;	
				case "btn_Rotate":
					doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
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
    			style.height = 100;
    			// 전체 너비 설정
    			SheetWidth = mainTable.clientWidth;

    			// Host정보 설정[필수][HostIp, Port, PagePath]
    			if (location.hostname != "")
    				InitHostInfo(location.hostname, location.port, page_path);

    			// 전체Merge 종류 [선택, Default msNone]
    			MergeSheet = msNone;

    			// 전체Edit 허용 여부 [선택, Default false]
    			Editable = true;

    			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    			InitRowInfo(1, 1, 3, 100);

    			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    			InitColumnInfo(5, 0, 0, true);

    			// 해더에서 처리할 수 있는 각종 기능을 설정한다
    			InitHeadMode(true, true, true, true, false, false)

    			var HeadTitle = "Seq.|File Name|File Size|eml_atch_file_seq|atch_file_path_ctnt";

    			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    			InitHeadRow(0, HeadTitle, true);

    			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
    			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
    			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
    			// SAVESTATUS, FORMATFIX]
    			InitDataProperty(0, cnt++, dtDataSeq, 40, daCenter, false, prefix + "Seq", false, "", dfNone, 0, false, true);
    			InitDataProperty(0, cnt++, dtPopup, 560, daLeft, false, prefix + "eml_atch_file_nm", false, "", dfNone, 0, false, false);
    			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix + "eml_atch_file_sz_capa", false, "", dfInteger, 0, false, false);
    			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "eml_atch_file_seq");
    			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "atch_file_path_ctnt");
    			

    			MultiSelection = false;
    			SelectHighLight = true;
    			SheetBackColor = RgbColor(248, 248, 248);
    			SelectBackColor = RgbColor(236, 246, 247);
    			CountPosition = 2;
    		}
    		break;
    		
    	case 2: //sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 0;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(2, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			var HeadTitle = "Mail Contents";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true,true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "title", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 0, daLeft, false, "ctnt", false, "", dfNone, 0, true, true);
			SheetBackColor = RgbColor(0,0,0);
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
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0447GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
				sXml = "<?xml version='1.0' ?>" + sXml;
				sheetObj.LoadSearchXml(sXml);
				ComSetObjValue(formObj.eml_subj_ctnt,f_isNullBlank(ComGetEtcData(sXml, "eml_subj_ctnt")));
				ComSetObjValue(formObj.eml_org_subj_ctnt,f_isNullBlank(ComGetEtcData(sXml, "eml_org_subj_ctnt")));
				eml_mn_ctnt.innerHTML = "<pre>"+ComReplaceStr(f_isNullBlank( ComReplaceStr(ComReplaceStr(ComGetEtcData(sXml, "eml_mn_ctnt"),'<','&lt;' ),'>','&gt;')) ,"ERROR","<font color='red'>[ERROR]</font>") +"</pre>";
				
				with (sheetObjects[1]) {
					
				    DataInsert(-1);
					CellValue(1,"title") = "Subject";
					CellValue(1,"ctnt") = ComGetObjValue(formObj.eml_subj_ctnt);
					DataInsert(-1);
					CellValue(2,"title") = "Booking No";
					CellValue(2,"ctnt") = ComGetObjValue(formObj.bkg_no);
					DataInsert(-1);
					CellValue(3,"title") = "SI No";
					CellValue(3,"ctnt") = ComGetObjValue(formObj.sr_no);
					DataInsert(-1);
					CellValue(4,"title") = "Contents";
					CellValue(4,"ctnt") = ComLtrim(ComGetEtcData(sXml, "eml_mn_ctnt"));
					
					for (i = 1; i <= sheetObjects[0].RowCount; i++) {
						DataInsert(-1);
						CellValue(4+i,"title") = "Attach File.";
						CellValue(4+i,"ctnt") = sheetObjects[0].CellValue(i,prefix +"eml_atch_file_nm");
					}
					
				}	
				ComOpenWait(false);
				break;
				
			case COMMAND01: // OCR 재변환 요청				
				formObj.f_cmd.value = MULTI;
				var sParam = FormQueryString(formObj);
				ComOpenWait(true);
				
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0447GS.do", sParam);
				ComOpenWait(false);        		

				if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
					ComShowCodeMessage("BKG00497"); // "Saved."
				}
				break;
		}
	}
     function f_isNullBlank(val){
  	   if (typeof(val) == "undefined"){
  		   return  "";
  	   }
  	   return val;
     }
     /**
      * Sheet 조회완료 후 이벤트 발생
      */
     function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
     	with (sheetObj) {
     		ColFontUnderline(prefix + "eml_atch_file_nm") = true;
     		DataLinkMouse(prefix + "eml_atch_file_nm") = true;
     	}
     }
	  /**
	 * 파일 다운받기 <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {ibsheet} Row     	sheetObj의 선택된 Row
	 * @param {ibsheet} Col     	sheetObj의 선택된 Col
	 * @param {String} 	Value     	파일명
	 **/
	function sheet1_OnClick(sheetObj, Row, Col, Value) {
		if (sheetObj.ColSaveName(Col) == prefix + "eml_atch_file_nm") {
			var downloadLocation = sheetObj.CellValue(Row, prefix + "atch_file_path_ctnt");
			var downloadFileName = encodeURI(sheetObj.CellValue(Row, prefix + "eml_atch_file_nm"));
			
			var url = "/hanjin/FileDownload?downloadLocation=" + downloadLocation +"/"+downloadFileName+ "&downloadFileName=" + downloadFileName;
			var host = location.host;
			if (host.indexOf("localhost") > -1 || host.indexOf("127.0.0.1") > -1) {
				url = "http://alpsdev.hanjin.com:9400"+url;
			}
			hiddenFrame.location.href = url;
		}
	} 
	/* 개발자 작업  끝 */