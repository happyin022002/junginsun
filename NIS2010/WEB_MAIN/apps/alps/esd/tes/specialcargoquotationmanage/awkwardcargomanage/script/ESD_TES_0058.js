/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESD_TES_0058.js
*@FileTitle : Select Cost for Break Bulk
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.13
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.02.13 이혜민
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
	 * @author SM LINE
	 */
	
	/**
	 * @extends 
	 * @class ESD_TES_0058 : ESD_TES_0058 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESD_TES_0058() {
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
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var sheetObject3 = sheetObjects[2];
		var sheetObject4 = sheetObjects[3];
		var sheetObject5 = sheetObjects[4];
		var sheetObject6 = sheetObjects[5];
		var formObj = document.form;
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
			case "btn_Confirm":
				chkCostRmk(sheetObject5);
				doActionIBSheet(sheetObject5, formObj, IBSAVE);
				setDefault(sheetObject5, sheetObject6);
			break;
			
			case "btn_Close":
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
		var formObj = document.form;
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var sheetObject3 = sheetObjects[2];
		var sheetObject4 = sheetObjects[3];
		var sheetObject5 = sheetObjects[4];
		var sheetObject6 = sheetObjects[5];
		
		for(i=0;i<sheetObjects.length;i++){
	
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		doActionIBSheet(sheetObject1, formObj, SEARCH02);
		setDefault(sheetObject5, sheetObject6);
		if(formObj.tmp_bkg_no.value != ""){
			for(var i=sheetObject1.HeaderRows; i<=sheetObject1.LastRow; i++){
				if(formObj.tmp_bkg_no.value == sheetObject1.CellValue(i, "bkg_no")){
					sheetObject1.SelectCell(i, "bkg_no");
					break;
				}	
			}
		}
	}
	
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		var sheetid = sheetObj.id;
		switch(sheetid) {
	
		case "sheet1":
			with (sheetObj) {
	
				// 높이 설정
				style.height = 380;
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
	
				var HeadTitle1 = "Bkg NO.(B.Bulk)";
				var headCount = ComCountHeadTitle(HeadTitle1);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, true, true, true, false,false);
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, 		DATAALIGN,    COLMERGE, SAVENAME,  	KEYFIELD, 	CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtData,	90,	daCenter,	true,	"bkg_no" , 	false,	"", dfEngUpKey, 0,	false,	true,5);
				
				CountPosition = 0;
				ShowMsgMode=false;
				WaitImageVisible = false;
			}
			break;
	
		case "sheet2":
			with (sheetObj) {
				// 높이 설정
				style.height = 83;
				
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
				
				var HeadTitle1 = "Seq.|Container List|Type Size|Vol.";
				var headCount = ComCountHeadTitle(HeadTitle1);
				
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, true, true, true, false, false);
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtSeq, 		40, 	daCenter, false, "Seq", 		false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 		135, 	daCenter, true, "cntr_no", 		false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 		65, 	daCenter, true, "cntr_tpsz_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 		35, 	daCenter, true, "cntr_vol_qty", false, "", dfFloat,2, false, false);
				CountPosition = 0;
				
				WaitImageVisible = false;
			}
			break;	
		
		case "sheet3": 
			with (sheetObj) {
				// 높이 설정
				style.height = 163;
				
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")InitHostInfo(location.hostname, location.port, page_path);
				
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
				
				//전체Edit 허용 여부 [선택, Default false]
				Editable = false;
				
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 3, 100);
				
				var HeadTitle1 = "Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information";
				var HeadTitle2 = "Seq.|Length|Width|Height|Grs Weight|Unit.";
				
				var headCount = ComCountHeadTitle(HeadTitle1);
				
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, true, true, true, false, false);
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtSeq, 		40, daCenter, 	false, 	"Seq", 			false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtData,		62, daRight, 	true, 	"dim_len", 		false, "", dfInteger, 	0, false, 	false);
				InitDataProperty(0, cnt++, dtData, 		62, daRight, 	true, 	"dim_wdt", 		false, "", dfInteger, 	0, false, 	false);
				InitDataProperty(0, cnt++, dtData, 		62, daRight, 	true, 	"dim_hgt", 		false, "", dfInteger,	0, false, 	false);
				InitDataProperty(0, cnt++, dtData, 		95, daRight, 	true, 	"grs_wgt", 		false, "", dfFloat, 	3, false, 	false, 11);
				InitDataProperty(0, cnt++, dtData, 		39, daRight, 	false, 	"wgt_ut_cd", 	false, "", dfNone, 		0, false, 	false);
				
				WaitImageVisible = false;
				CountPosition = 0;
			}
			break;		
			
		case "sheet4": 
			with (sheetObj) {
				// 높이 설정
				style.height = 0;
				
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")InitHostInfo(location.hostname, location.port, page_path);
				
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
				
				//전체Edit 허용 여부 [선택, Default false]
				Editable = false;
				
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);
				var HeadTitle1 = "cntr_tpsz_cd|op_cntr_qty ";
				
				var headCount = ComCountHeadTitle(HeadTitle1);
				
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, true, true, true, false, false);
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cntr_tpsz_cd");
				InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "op_cntr_qty");
				
				WaitImageVisible = false;
			}
			break;		
			
		case "sheet5":
			with (sheetObj) {
				// 높이 설정
				style.height = 380;
				
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);
	
				var HeadTitle1 = "|Cost Code|bb_cgo_tp_seq|Code Description|Amount|Remark|||bkg_no|vvd|yd_cd|tml_so_ofc_cty_cd|tml_so_seq|io_bnd_cd|atb_dt";
				var headCount = ComCountHeadTitle(HeadTitle1);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false);
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				//데이터속성    [ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, 	COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,		"ibflag");
				InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"lgs_cost_cd", 		false,	"", dfNone, 0,	false,	false);
				InitDataProperty(0, cnt++ , dtHidden,		20,		daCenter,	true,		"bb_cgo_tp_seq", 	false,	"", dfNone, 0,	false,	false);
				InitDataProperty(0, cnt++ , dtData,			185,	daLeft,		true,		"bb_cgo_desc", 		false,	"", dfNone, 0,	false,	false);
				InitDataProperty(0, cnt++ , dtAutoSum,		85,		daRight,	true,		"inv_amt", 			false,	"", dfFloat, 2,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			70,		daLeft,		true,		"bb_cgo_rmk", 		false,	"", dfNone, 0,	true,	true);
				InitDataProperty(0, cnt++ , dtHidden,		20,		daCenter,	true,		"chk_yd_use_yn");
				InitDataProperty(0, cnt++ , dtHidden,		20,		daCenter,	true,		"chk_del_yn");
				InitDataProperty(0, cnt++ , dtHidden, 		50, 	daCenter, 	false, 		"bkg_no");
				InitDataProperty(0, cnt++ , dtHidden,		50, 	daCenter,	false, 		"vvd");
				InitDataProperty(0, cnt++ , dtHidden, 		50, 	daCenter,	false, 		"yd_cd");
				InitDataProperty(0, cnt++ , dtHidden, 		50, 	daCenter, 	false, 		"tml_so_ofc_cty_cd");
				InitDataProperty(0, cnt++ , dtHidden, 		50, 	daCenter,	false, 		"tml_so_seq");
				InitDataProperty(0, cnt++ , dtHidden, 		50, 	daCenter,	false, 		"io_bnd_cd");
				InitDataProperty(0, cnt++ , dtHidden, 		50, 	daCenter,	false, 		"atb_dt");
				
				AutoSumBottom = 1;
				CountPosition = 0;
				ShowMsgMode=false;
				WaitImageVisible = false;
			}
			break;
			
		case "sheet6": 
			with (sheetObj) {
				// 높이 설정
				style.height = 0;
				
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				 
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")InitHostInfo(location.hostname, location.port, page_path);
				
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
				
				//전체Edit 허용 여부 [선택, Default false]
				Editable = false;
				
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);
				var HeadTitle1 = "|lgs_cost_cd|inv_amt|bb_cgo_rmk|bkg_no|vvd|yd_cd|tml_so_ofc_cty_cd|tml_so_seq|io_bnd_cd|atb_dt ";
				
				var headCount = ComCountHeadTitle(HeadTitle1);
				
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, true, true, true, false, false);
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtStatus,	40,		daCenter,	true,  "ibflag");
				InitDataProperty(0, cnt++ , dtData, 	100, 	daCenter, 	false, "dtl_lgs_cost_cd");
				InitDataProperty(0, cnt++ , dtData, 	100, 	daCenter, 	false, "dtl_inv_amt");
				InitDataProperty(0, cnt++ , dtData,		70,		daLeft,		true,  "dtl_bb_cgo_rmk");
				InitDataProperty(0, cnt++ , dtData, 	50, 	daCenter, 	false, "bkg_no");
				InitDataProperty(0, cnt++ , dtData, 	50, 	daCenter, 	false, "vvd");
				InitDataProperty(0, cnt++ , dtData, 	50, 	daCenter, 	false, "yd_cd");
				InitDataProperty(0, cnt++ , dtData, 	50, 	daCenter, 	false, "tml_so_ofc_cty_cd");
				InitDataProperty(0, cnt++ , dtData, 	50, 	daCenter, 	false, "tml_so_seq");
				InitDataProperty(0, cnt++ , dtData, 	50, 	daCenter, 	false, "io_bnd_cd");
				InitDataProperty(0, cnt++ , dtData, 	50, 	daCenter,	false, "atb_dt");
				
				DataInsert(-1);
				Cellvalue2(1, "dtl_lgs_cost_cd") = "SVLDBB";
				DataInsert(-1);
				Cellvalue2(2, "dtl_lgs_cost_cd") = "CGMLDN";
				DataInsert(-1);
				Cellvalue2(3, "dtl_lgs_cost_cd") = "SVTLCK";
				DataInsert(-1);
				Cellvalue2(4, "dtl_lgs_cost_cd") = "SVLDMT";
				DataInsert(-1);
				Cellvalue2(5, "dtl_lgs_cost_cd") = "CGFRTX";
				DataInsert(-1);
				Cellvalue2(6, "dtl_lgs_cost_cd") = "SVOSIS";
				DataInsert(-1);
				Cellvalue2(7, "dtl_lgs_cost_cd") = "SVOSOT";
				DataInsert(-1);
				Cellvalue2(8, "dtl_lgs_cost_cd") = "SVTLLS";
				DataInsert(-1);
				Cellvalue2(9, "dtl_lgs_cost_cd") = "CGSVSV";
				
				WaitImageVisible = false;
			}
			break;			
		}
	}
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		var formObj = document.form;
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var sheetObject3 = sheetObjects[2];
		var sheetObject4 = sheetObjects[3];
		var sheetObject5 = sheetObjects[4];
		var sheetObject6 = sheetObjects[5];
		
		switch(sAction) {
			case IBSEARCH:      //BKG 정보 조회
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;
				var sXml = sheetObj.GetSearchXml("ESD_TES_0058GS.do", FormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				sheetObject3.LoadSearchXml(arrXml[0]); // cargo Info
				sheetObject4.LoadSearchXml(arrXml[1]); // tpsz Info
				sheetObject2.LoadSearchXml(arrXml[2]); // cntr Info
				setCntrTotal(sheetObject4);
				searchCustNm(arrXml[0]);
				ComOpenWait(false);
			break;
			
			case SEARCH01:      // Cost Code 조회
				formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchXml("ESD_TES_0058GS.do", FormQueryString(formObj));
				sheetObject5.LoadSearchXml(sXml); //cost Info
				afterSearch(sheetObject5);
			break;
			
			case SEARCH02:      // BKG NO 조회
				formObj.f_cmd.value = SEARCH02;
				var sXml = sheetObj.GetSearchXml("ESD_TES_0058GS.do", FormQueryString(formObj));
				sheetObject1.LoadSearchXml(sXml); //bkg no
			break;
			
			case IBSAVE: //저장
				var sParam = ComTesSetPrefix(ComGetSaveString(sheetObject5, false), "sheet5_");
				sParam = sParam + "&" +ComTesSetPrefix(ComGetSaveString(sheetObject6, false), "sheet6_");
				if (sParam == ""){
					return;
				} else {
					formObj.f_cmd.value = MULTI;
					sParam = sParam + "&f_cmd=" + formObj.f_cmd.value;
					var sXml = sheetObj.GetSaveXml("ESD_TES_0058GS.do", sParam);
					var nodeText = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
					if(nodeText == "S"){
						ComShowCodeMessage('TES90104'); //Data saved successfully
						doActionIBSheet(sheetObject1, formObj, SEARCH01);
					}
				}
			break;	
		}
	} 
	
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
		var formObj = document.form;
		var sheetObj5 = sheetObjects[4];
		var sheetObj6 = sheetObjects[5];
		if(sheetObj.RowCount < 1){
			return;
		}
		if(OldRow == NewRow){
			return;
		}
		formObj.bkg_no.value = sheetObj.CellValue(NewRow, "bkg_no");
		doActionIBSheet(sheetObj, formObj, IBSEARCH);
		doActionIBSheet(sheetObj, formObj, SEARCH01);
		setDefault(sheetObj5, sheetObj6);
	}
	
	function sheet5_OnChange(sheetObj, row, col, value) {
		var colName = sheetObj.ColSaveName(col);
		var sheetObject6 = sheetObjects[5];
		if (colName == "inv_amt") {
			if(row == "1" ||  row == "2" || row == "3" || row == "4"){ //SVLDBB
				sheetObject6.CellValue2(1, "dtl_inv_amt") = sheetObj.CellValue(1, "inv_amt")*1 + sheetObj.CellValue(2, "inv_amt")*1 + sheetObj.CellValue(3, "inv_amt")*1 + sheetObj.CellValue(4, "inv_amt")*1;
			}else if(row == "5" ||  row == "6" ){ //SVTLLS
				sheetObject6.CellValue2(8, "dtl_inv_amt") = sheetObj.CellValue(5, "inv_amt")*1 + sheetObj.CellValue(6, "inv_amt")*1;
			}else if(row == "7" ||  row == "10" ){ //SVTLCK
				sheetObject6.CellValue2(3, "dtl_inv_amt") = sheetObj.CellValue(7, "inv_amt")*1 + sheetObj.CellValue(10, "inv_amt")*1;
			}else if(row == "8"){ //SVLDMT
				sheetObject6.CellValue2(4, "dtl_inv_amt") = sheetObj.CellValue(8, "inv_amt")*1;
			}else if(row == "9"){ //CGMLDN
				sheetObject6.CellValue2(2, "dtl_inv_amt") = sheetObj.CellValue(9, "inv_amt")*1;
			}else if(row == "11"){ //CGSVSV
				sheetObject6.CellValue2(9, "dtl_inv_amt") = sheetObj.CellValue(11, "inv_amt")*1;
			}else if(row == "12" ||  row == "13" || row == "14"){ //SVOSOT
				sheetObject6.CellValue2(7, "dtl_inv_amt") = sheetObj.CellValue(12, "inv_amt")*1 + sheetObj.CellValue(13, "inv_amt")*1 + sheetObj.CellValue(14, "inv_amt")*1;
			}else if(row == "15"){ //SVOSIS
				sheetObject6.CellValue2(6, "dtl_inv_amt") = sheetObj.CellValue(15, "inv_amt")*1;
			}else if(row == "16" ||  row == "17" ||  row == "18"){ //CGFRTX
				sheetObject6.CellValue2(5, "dtl_inv_amt") = sheetObj.CellValue(16, "inv_amt")*1 + sheetObj.CellValue(17, "inv_amt")*1 + sheetObj.CellValue(18, "inv_amt")*1 ;
			}
		}
	}
	
	function chkCostRmk(sheetObj){
		var headCnt = sheetObj.HeaderRows;
		var sheetObject6 = sheetObjects[5];
		var orgValue = "";

		for(var i=headCnt; i<=sheetObj.LastRow; i++){
			if(sheetObj.CellValue(i, "lgs_cost_cd") == "SVLDBB"){
				orgValue =  sheetObj.CellSearchValue(i,"bb_cgo_rmk");
				if(orgValue != sheetObj.CellValue(i,"bb_cgo_rmk") ){
					sheetObject6.CellValue2(1, "dtl_bb_cgo_rmk") = "Y";
				}
			}else if(sheetObj.CellValue(i, "lgs_cost_cd") == "SVTLLS"){
				orgValue =  sheetObj.CellSearchValue(i,"bb_cgo_rmk");
				if(orgValue != sheetObj.CellValue(i,"bb_cgo_rmk") ){
					sheetObject6.CellValue2(8, "dtl_bb_cgo_rmk") = "Y";
				}
			}else if(sheetObj.CellValue(i, "lgs_cost_cd") == "SVTLCK"){
				orgValue =  sheetObj.CellSearchValue(i,"bb_cgo_rmk");
				if(orgValue != sheetObj.CellValue(i,"bb_cgo_rmk") ){
					sheetObject6.CellValue2(3, "dtl_bb_cgo_rmk") = "Y";
				}
			}else if(sheetObj.CellValue(i, "lgs_cost_cd") == "SVLDMT"){
				orgValue =  sheetObj.CellSearchValue(i,"bb_cgo_rmk");
				if(orgValue != sheetObj.CellValue(i,"bb_cgo_rmk") ){
					sheetObject6.CellValue2(4, "dtl_bb_cgo_rmk") = "Y";
				}
			}else if(sheetObj.CellValue(i, "lgs_cost_cd") == "CGMLDN"){
				orgValue =  sheetObj.CellSearchValue(i,"bb_cgo_rmk");
				if(orgValue != sheetObj.CellValue(i,"bb_cgo_rmk") ){
					sheetObject6.CellValue2(2, "dtl_bb_cgo_rmk") = "Y";
				}
			}else if(sheetObj.CellValue(i, "lgs_cost_cd") == "CGSVSV"){
				orgValue =  sheetObj.CellSearchValue(i,"bb_cgo_rmk");
				if(orgValue != sheetObj.CellValue(i,"bb_cgo_rmk") ){
					sheetObject6.CellValue2(9, "dtl_bb_cgo_rmk") = "Y";
				}
			}else if(sheetObj.CellValue(i, "lgs_cost_cd") == "SVOSOT"){
				orgValue =  sheetObj.CellSearchValue(i,"bb_cgo_rmk");
				if(orgValue != sheetObj.CellValue(i,"bb_cgo_rmk") ){
					sheetObject6.CellValue2(7, "dtl_bb_cgo_rmk") = "Y";
				}
			}else if(sheetObj.CellValue(i, "lgs_cost_cd") == "SVOSIS"){
				orgValue =  sheetObj.CellSearchValue(i,"bb_cgo_rmk");
				if(orgValue != sheetObj.CellValue(i,"bb_cgo_rmk") ){
					sheetObject6.CellValue2(6, "dtl_bb_cgo_rmk") = "Y";
				}
			}else if(sheetObj.CellValue(i, "lgs_cost_cd") == "CGFRTX"){
				orgValue =  sheetObj.CellSearchValue(i,"bb_cgo_rmk");
				if(orgValue != sheetObj.CellValue(i,"bb_cgo_rmk") ){
					sheetObject6.CellValue2(5, "dtl_bb_cgo_rmk") = "Y";
				}
			}
		}	
	}
	
	function setCntrTotal(sheetObj) {
		var headCnt = sheetObj.HeaderRows;
		var formObj = document.form;
		var cntrTtl;
		for(var i=headCnt; i<=sheetObj.LastRow; i++){
			if(i > 1){
				cntrTtl = cntrTtl + "," + sheetObj.CellValue(i, "cntr_tpsz_cd") + "X" + sheetObj.CellValue(i, "op_cntr_qty");
			}else{
				cntrTtl = sheetObj.CellValue(i, "cntr_tpsz_cd") + "X" + sheetObj.CellValue(i, "op_cntr_qty");
			}
		}
		formObj.cntr_total.value = cntrTtl;
	}
	
	function searchCustNm(sXml){
		var formObj = document.form;
		if(ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
			formObj.s_cust_cnt_cd.value = ComGetEtcData(sXml,"s_cust_cnt_cd");
			formObj.s_cust_seq.value = ComGetEtcData(sXml,"s_cust_seq");
			formObj.s_cust_nm.value = ComGetEtcData(sXml,"s_cust_nm");
			formObj.c_cust_cnt_cd.value = ComGetEtcData(sXml,"c_cust_cnt_cd");
			formObj.c_cust_seq.value = ComGetEtcData(sXml,"c_cust_seq");
			formObj.c_cust_nm.value = ComGetEtcData(sXml,"c_cust_nm");
			formObj.n_cust_cnt_cd.value = ComGetEtcData(sXml,"n_cust_cnt_cd");
			formObj.n_cust_seq.value = ComGetEtcData(sXml,"n_cust_seq");
			formObj.n_cust_nm.value = ComGetEtcData(sXml,"n_cust_nm");
		}else{
			formObj.s_cust_cnt_cd.value = "";
			formObj.s_cust_seq.value = "";
			formObj.s_cust_nm.value = "";
			formObj.c_cust_cnt_cd.value = "";
			formObj.c_cust_seq.value = "";
			formObj.c_cust_nm.value = "";
			formObj.n_cust_cnt_cd.value = "";
			formObj.n_cust_seq.value = "";
			formObj.n_cust_nm.value = "";
		}				    			    	
	}
	
	function afterSearch(sheetObj){
		var formObj = document.form;
		var headCnt = sheetObj.HeaderRows;
		var Row = sheetObj.RowCount;
		for(var i=headCnt; i<=sheetObj.LastRow; i++){
			if(sheetObj.CellValue(i, "chk_yd_use_yn") == "N"){	
				sheetObj.CellEditable(i,"cost_sel") = false;
				sheetObj.CellEditable(i,"inv_amt") = false;
				sheetObj.CellValue2(i, "bb_cgo_rmk") = "Not Used";
				sheetObj.CellEditable(i,"bb_cgo_rmk") = false;
			}else if(sheetObj.CellValue(i, "chk_del_yn") == "Y"){
				sheetObj.RowFontColor(i) = sheetObj.RgbColor(255, 0, 0);
				sheetObj.CellEditable(i,"cost_sel") = false;
				sheetObj.CellValue2(i, "inv_amt") = "";
				sheetObj.CellEditable(i,"inv_amt") = false;
				sheetObj.CellValue2(i, "bb_cgo_rmk") = "Cost Deleted";
				sheetObj.CellEditable(i,"bb_cgo_rmk") = false;
			}
		}
	}
	
	function afterLoadPage(sheetObj, formObj){
		formObj.s_cust_cnt_cd.value = "";
		formObj.s_cust_seq.value = "";
		formObj.s_cust_nm.value = "";
		formObj.c_cust_cnt_cd.value = "";
		formObj.c_cust_seq.value = "";
		formObj.c_cust_nm.value = "";
		formObj.n_cust_cnt_cd.value = "";
		formObj.n_cust_seq.value = "";
		formObj.n_cust_nm.value = "";
		formObj.cntr_total.value = "";
		sheetObj.RemoveAll();
	}
	
	function setDefault(sheetObj5, sheetObj6){
		var formObj = document.form;
		var headCnt1 = sheetObj5.HeaderRows;
		var headCnt2 = sheetObj6.HeaderRows;
		for(var i=headCnt1; i<=sheetObj5.LastRow; i++){
			sheetObj5.CellValue2(i , "bkg_no") = formObj.bkg_no.value;
			sheetObj5.CellValue2(i , "vvd") = formObj.vvd.value;
			sheetObj5.CellValue2(i , "yd_cd") = formObj.yd_cd.value;
			sheetObj5.CellValue2(i , "tml_so_ofc_cty_cd") = formObj.tml_so_ofc_cty_cd.value;
			sheetObj5.CellValue2(i , "tml_so_seq") = formObj.tml_so_seq.value;
			sheetObj5.CellValue2(i , "io_bnd_cd") = formObj.io_bnd_cd.value;
			sheetObj5.CellValue2(i , "atb_dt") = formObj.atb_dt.value;
		}
		for(var i=headCnt1; i<=sheetObj6.LastRow; i++){
			sheetObj6.CellValue2(i , "bkg_no") = formObj.bkg_no.value;
			sheetObj6.CellValue2(i , "vvd") = formObj.vvd.value;
			sheetObj6.CellValue2(i , "yd_cd") = formObj.yd_cd.value;
			sheetObj6.CellValue2(i , "tml_so_ofc_cty_cd") = formObj.tml_so_ofc_cty_cd.value;
			sheetObj6.CellValue2(i , "tml_so_seq") = formObj.tml_so_seq.value;
			sheetObj6.CellValue2(i , "io_bnd_cd") = formObj.io_bnd_cd.value;
			sheetObj6.CellValue2(i , "atb_dt") = formObj.atb_dt.value;
			sheetObj6.CellValue2(i , "dtl_inv_amt") = "";
			sheetObj6.CellValue2(i , "dtl_bb_cgo_rmk") = "";
		}
	}
	
	function ComTesSetPrefix(sStr, sPrefix) {
	    if (sStr == null || sStr == "" || sPrefix == null || sPrefix == "") {
	        return sStr;
	    }
	    var regexp = RegExp(/&/g);
	    sStr = sPrefix + sStr.replace(regexp, "&" + sPrefix);
	    return sStr;
	}

/* 개발자 작업  끝 */ 