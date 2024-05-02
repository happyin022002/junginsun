/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : ESM_BKG_0000_1.js
 *@FileTitle : Booking Reactive
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.07.03
 *@LastModifier : 문경일
 *@LastVersion : 1.0
 * 2009.07.03 문경일
 * 1.0 Creation
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

function ESM_BKG_0000_1() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업	*/
var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	var formObject = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
			case "btn_AR_Batch":
				doActionIBSheet(sheetObjects[0],formObject, COMMAND11);
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

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
}

function initSheet(sheetObj, sheetNo) {
	var cnt = 0;

	switch (sheetNo) {
		case 1: //sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = 0;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msAll;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(8, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false, false)

			}
			break;
		//2015/03/05 양동훈 수정
		case 2://sheet2
			with(sheetObj){
			// 높이 설정
            style.height = 350;
            //전체 너비 설정
            style.width = 800;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msPrevColumnMerge;

           //전체Edit 허용 여부 [선택, Default false]
            Editable = true;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(1, 1, 4, 100);

            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(5, 0, 0, true);
            
            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, false, false, true, false, true)
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            
			var headTitle = "Status|No.|BKG_NO|CNTR_NO|CYC_NO";
			InitHeadRow(0, headTitle, true);
            
            
            
			// 데이터속성                   [ROW,	COL,	DATATYPE,		WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,				KEYFIELD,	CALCULOGIC,	DATAFORMAT,		POINTCOUNT,	UPDATEEDIT,	INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0,		cnt++,	dtStatus,		70,		daCenter,	false,		"ibflag"); // [필수]
			InitDataProperty(0,		cnt++,	dtDataSeq,		40,		daCenter,	false,		"seq");
			InitDataProperty(0,		cnt++,	dtData,			100,		daCenter,	false,		"bkg_no",			false,		"",			dfNone,			0,			false,		false);
			InitDataProperty(0,		cnt++,	dtData,			100,	daCenter,	false,		"cntr_no",			false,		"",			dfNone,			0,			false,		false);
			InitDataProperty(0,		cnt++,	dtData,			80,	daCenter,	false,		"cnmv_cyc_no",			false,		"",			dfNone,			0,			true,		false);
			
		}
			break;
		//2015/03/05양동훈 수정 끝
	}
}

function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
//		case IBSEARCH: // 화면 로딩시 코드 조회
//			formObj.f_cmd.value = COMMAND10;
//			var sXml = sheetObj.GetSearchXml("ESM_BKG_0000_1GS.do", FormQueryString(formObj));
//			
//			break;
		case COMMAND11: // Batch Execute
			formObj.f_cmd.value=COMMAND11;
            sParam=FormQueryString(formObj);
            var sXml=sheetObj.GetSearchData("ESM_BKG_0000_3GS.do", sParam);
       	    if (ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S") 
       	    {
       	    	monCnt=1;
       	    	jobId=ComGetEtcData(sXml,"JOB_ID");
                timeId=setTimeout("monitoringBatchJob()", 1000*3);
                alert("Success");
       	    } else {
       	    	ComBkgErrMessage(sheetObj, sXml);
       	    	ComOpenWait(false);
       	    }
        	break;
//		case IBSEARCH_ASYNC07:
//            var sParam="&f_cmd=" + SEARCH04 + "&job_id=" + jobId;
//            var sXml=sheetObj.GetSearchData("ESM_BKG_1063GS.do", sParam);
//        	if (ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S") 
//        	{
//            	var jobStatus=ComGetEtcData(sXml,"BATCH_STATUS");
//       	    	if (jobStatus == "0" || jobStatus == "1" || jobStatus == "3" || jobStatus == "10") // None. Running or Starting or Restart 
//       	    	{ 
//       	    		if (monCnt < 200) { // Limited to 10 minutes, monitoring.(3sec*200=10min)
//           	    		monCnt++;
//           	    		// Continued monitoring
//           	    		timeId=setTimeout("monitoringBatchJob()", 1000*3);
//       	    		} else {
//           	    		ComOpenWait(false);       	    		
//       	    		}
//       	    	} 
//       	    	else 
//       	    	{
//       	    		ComOpenWait(false);       	    		
//       	    		alert(getBatchStatusDesc(jobStatus));
//       	    	}
//       	    } else {
//       	    	ComBkgErrMessage(sheetObj, sXml);
//       	    	ComOpenWait(false);
//       	    }
//        	break;
//			formObj.f_cmd.value = COMMAND10;
//			var sXml = sheetObj.GetSaveData("ESM_BKG_0000_3GS.do", FormQueryString(formObj));
//			var state = ComGetEtcData(sXml,"isSuccess");
//			if ( state == "Y" ) {
//				ComShowMessage(ComGetMsg("BKG08248"));
//			}else{
//				ComShowMessage(ComGetMsg("BKG08249"));
//			}
//			break;
//		case COMMAND14:
//			formObj.f_cmd.value = COMMAND14;
//			var sXml = sheetObj.GetSearchXml("ESM_BKG_0000_1GS.do", FormQueryString(formObj));
//			var state = ComGetEtcData(sXml,"isSuccess");
//			if(state=='Y'){
//				ComShowCodeMessage('BKG06071');
//			}else{
//				ComShowCodeMessage('BKG00202');
//			}
//			alert(sXml);
//			break;
//	//수정종료
//	//2015/03/05 양동훈 수정
//		case SEARCH16:
//			formObj.f_cmd.value = SEARCH16;
////			var sXml = sheetObj.GetSearchXml("ESM_BKG_0000_1GS.do", FormQueryString(formObj));
////			sheetObj.LoadSearchXml(sXml, true);
//			/*
//			 * 위의 방식대로 처리해도 나옴. 하지만 검색할 때마다 결과가 append 되서 나옴
//			 */
//			var sParam = FormQueryString(formObj);
////			sheetObj.DoSearch("ESM_BKG_0000_1GS.do",sParam);
//			sheetObj.DoSearch("ESM_BKG_0000_1GS.do", sParam);
////			alert(FormQueryString(formObj)+ "&" + ComGetPrefixParam(""));
//			break;
//		case COMMAND15:
//			formObj.f_cmd.value = COMMAND15;
//			sheetObj.DoSave("ESM_BKG_0000_1GS.do", FormQueryString(formObj));
//			doActionIBSheet(sheetObjects[1], document.form, SEARCH16);
//
//			
////			var param = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
////			alert(param);
////			sheetObj.DoSave("ESM_BKG_0000_1GS.do", param);
//			break;
	}
	//수정종료
    /**
     * Monitoring batch status
     * @return 
     */
}
function monitoringBatchJob() {
	var sheetObj=null;
    if (tabObjects[0].SetSelectedIndex() == 0) {
    	sheetObj=sheetObjects[0];
    }
	else if (tabObjects[0].SetSelectedIndex() == 1) {
		sheetObj=sheetObjects[1];
	}
	doActionIBSheet(sheetObj,document.form,IBSEARCH_ASYNC07);
}
/* 개발자 작업  끝 */