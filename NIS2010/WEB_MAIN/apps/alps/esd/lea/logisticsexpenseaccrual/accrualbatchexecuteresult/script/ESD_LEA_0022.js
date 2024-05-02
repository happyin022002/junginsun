/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESD_LEA_0022.js
 *@FileTitle : Monthly Budget Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.04.08
 *@LastModifier : KIM HYUN HWA
 *@LastVersion : 1.0
 * 2015.04.08 KIM HYUN HWA
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
 * @extends
 * @class ESD_LEA_0022 : ESD_LEA_0022 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESD_LEA_0022() {
	this.processButtonClick		= processButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.setComboObject 		= setComboObject;    	
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initControl            = initControl;
	this.obj_blur				= obj_blur;
	this.obj_focus				= obj_focus;
	this.obj_keypress			= obj_keypress;    	    	
	this.doActionIBSheet 		= doActionIBSheet;
	this.setTabObject 			= setTabObject;
	this.validateForm 			= validateForm;
}

/* 개발자 작업	*/
// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var isCreate = 0;				// 데이터 생성 버튼 실행 여부
var isSave = 0;					// 저장 버튼 실행 여부 

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;
	
//	isRetrieve = 0;				// 조회시 Verify하지 않는다.
//	isApply = 0;				// 배치실행여부
//	isSave = 0;					// 저장

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
		case "btn_retrieve":

			sheetObject.RemoveAll();
			doActionIBSheet(sheetObject,formObject,IBSEARCH);			
			break;
		case "btn_create":
		
			ComOpenWait(true);
			doActionIBSheet(sheetObject,formObject,IBINSERT);
			
			for ( var n = 1; n <= sheetObject.RowCount; n++ ){
				sheetObject.CellValue2(n,"s_chk") = 1 ;
				sheetObject.CellValue2(n,"ibflag") = "U" ;
			}
		
			doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC02);

			doActionIBSheet(sheetObject,formObject,IBCREATE);
			ComOpenWait(false);
			break;			
		case "btn_save":
			ComOpenWait(true);
			if(sheetObject.RowCount < 1){
				return;
			}
			isSave = 1;			// 저장시구분
			
			for ( var n = 1; n <= sheetObject.RowCount; n++ ){
				if (sheetObject.RowStatus(n) == "U"){
				    sheetObject.CellValue2(n,"s_chk") = 1 ;
				} 
			}
			doActionIBSheet(sheetObject,formObject,IBSAVE);
			
			for ( var j = 1; j <= sheetObject.RowCount; j++ ){
				if (sheetObject.CellValue(j,"s_chk") == 1 ){
				    sheetObject.CellValue2(j,"ibflag") = "U" ;
				}
			}
			
			doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC01);
			ComOpenWait(false);
			break;			

		case "btn_downexcel":		
			if(sheetObject.RowCount < 1){
				return;
			}
			doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
			break;
		case "btn_Load_Excel":
			ComOpenWait(true);
			ComBtnDisable("btn_save");
			sheetObject.RemoveAll();
			sheetObject.LoadExcel();

			if(sheetObject.RowCount < 1){
				ComBtnDisable("btn_create");
			}else{
				
				for ( var i = 1; i <= sheetObject.RowCount; i++ ){
					sheetObject.CellValue2(i,"bse_yr") = formObject.bse_yr.value ;
				}
				ComBtnEnable("btn_create");
			}
			ComOpenWait(false);
			break;
//		case "btn_add":
//			var row = sheetObject.DataInsert(-1);
//			sheetObject.CellValue2(row,"bse_yr") = formObject.bse_yr.value ;
//			break;
//		case "btn_delete":
//
//			var row = sheetObject.SelectRow;
//			var col = sheetObject.SelectCol;
//				
//			sheetObject.RowDelete(row,false);
//			break;
			case "btn_close":
				window.close();
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
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	var sheetObj = sheetObjects[0];
	var formObj = document.form;

	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}

	ComBtnDisable( "btn_create" );		
	ComBtnDisable( "btn_save" );
	ComBtnDisable( "btn_Load_Excel" );
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetNo) {
	case 1: //IBSheet1 init
		with (sheetObj) {
			//높이 설정
			style.height = 300;
			//style.width = 800;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);
			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;
			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 10, 100);
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(12, 0, 0, true);
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			// ([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize],
			// [RowMove],[Head3D])
			InitHeadMode(true, true, true, true, false, false)

			var HeadTitle = "|Exe.Year|RHQ|Control\nOffice|System|Cost|Cost Description|Account|Monthly Budget|Total Budget||";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

            //데이터속성[ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	        
			InitDataProperty(0, cnt++, dtDummyCheck, 30, daCenter, false,"s_chk",         false, "", dfNone,  0, false, false);
			InitDataProperty(0, cnt++, dtData,   60,  daCenter, true, "bse_yr", 		  false, "", dfNone,  0, false, true);
			InitDataProperty(0, cnt++, dtData,   60,  daCenter, true, "rhq_cd", 		  false, "", dfNone,  0, false, false);
			InitDataProperty(0, cnt++, dtData,   60,  daCenter, true, "ctrl_ofc_cd",      false, "", dfNone,  0, false, true);
			InitDataProperty(0, cnt++, dtData,   60,  daCenter, true, "cost_src_sys_cd",  false, "", dfNone,  0, false, false);	
			InitDataProperty(0, cnt++, dtData,   60,  daCenter, true, "coa_cost_src_cd",  false, "", dfNone,  0, false, true);			
			InitDataProperty(0, cnt++, dtData,  180,  daLeft,   true, "lgs_cost_full_nm", false, "", dfNone,  0, false, false);
			InitDataProperty(0, cnt++, dtData,   50,  daCenter, true, "acct_cd",          false, "", dfNone,  0, false, false);
			InitDataProperty(0, cnt++, dtData,  120,  daRight,  true, "mon_bud_usd_amt",  false, "", dfFloat, 2, true, false);	
			InitDataProperty(0, cnt++, dtData,  120,  daRight,  true, "ttl_usd_amt",      false, "", dfFloat, 2, false, false);	
			InitDataProperty(0, cnt++, dtHidden,  0,  daCenter, true, "mnl_flg");
			InitDataProperty(0, cnt++, dtHiddenStatus, 0,  daCenter,  false,   "ibflag");

		
			SelectHighLight = false;
			//FocusAfterProcess = false;			
		}
		break;
	}
}

/**
 * Sheet관련 프로세스 처리
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;

	switch (sAction) {
	case IBSEARCH:
		sheetObj.WaitImageVisible=false;
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH;
		sheetObj.DoSearch("ESD_LEA_0022GS.do", FormQueryString(formObj));
		sheetObj.FocusAfterProcess = false;
		ComOpenWait(false);		
		break;
	case IBSAVE:
		sheetObj.WaitImageVisible=false;
		ComOpenWait(true);
		formObj.f_cmd.value = MULTI;
		sheetObj.DoSave("ESD_LEA_0022GS.do", FormQueryString(formObj),-1,false);
		ComOpenWait(false);		
		break;
	case IBSEARCH_ASYNC01:
		//sheetObj.WaitImageVisible=false;
		//ComOpenWait(true);
		formObj.f_cmd.value = MULTI03;
		sheetObj.DoSave("ESD_LEA_0022GS.do", FormQueryString(formObj),-1,false);
		//ComOpenWait(false);		
		break;	

	case IBINSERT:
         //sheetObj.WaitImageVisible=false;
		 //ComOpenWait(true);
		 formObj.f_cmd.value = MULTI01;
		 sheetObj.DoSave("ESD_LEA_0022GS.do", FormQueryString(formObj),-1,false);
		 //ComOpenWait(false);
		break;
	case IBSEARCH_ASYNC02:
		
		 formObj.f_cmd.value = MULTI04;
		 sheetObj.DoSave("ESD_LEA_0022GS.do", FormQueryString(formObj),-1,false);
		break;		
	case IBCREATE:
		
		//sheetObj.WaitImageVisible=false;
		//ComOpenWait(true);
		formObj.f_cmd.value = MULTI02;
	
		   var savexml = sheetObj.GetSaveXml("ESD_LEA_0022GS.do", leaFormQueryString(formObj));
		 
		    if (savexml != "")sheetObj.LoadSaveXml(savexml,true);
		   	var ret = sheetObj.EtcData("BATCH_EXE_RESULT");
		     	
		   // if (ret != "") ComShowMessage(sheetObj.EtcData("BATCH_EXE_RESULT"));
		    if (ret != "") ComShowMessage(" Monthly Budget Creation Start!It will take about 20 minutes.");
		    
		//ComOpenWait(false);
		break;	
	case IBDOWNEXCEL:
		if(sheetObj.RowCount > 0){
			sheetObj.Down2Excel(-1);
		}
		break;

	}
}

/**
 * 저장 후 실행
 */
function sheet1_OnSaveEnd(sheetObj,ErrMsg){	
	//if(document.form.rhq_cd.value=="" && sheetObj.Rowcount){
//	var saveMsgFlg = ComIsNull(ErrMsg);
//	if(isApply == 0){		
//		if (saveMsgFlg) {
//			ComShowCodeMessage("LEA90026");  //Data Saved Successfully!!
//		} else {
//			ComShowCodeMessage("LEA90027");  //Data Save Action Failed!!
//			return;
//		}
//		
//	    if(document.form.exe_yrmon.value!=""){
//	    	doActionIBSheet(sheetObj, document.form, IBSEARCH);
//	    }
//	}else{
//		ComBtnDisable( "btn_apply" );		// isApply == 1		
//	}
	ComBtnDisable("btn_create");
	ComBtnDisable("btn_save");
}

/**
 * 조회 후 실행
 */
function sheet1_OnSearchEnd(sheetObj,ErrMsg){
	ComBtnEnable("btn_Load_Excel");
	
	if (sheetObj.RowCount == 0){
		ComBtnDisable("btn_save");
	   if(document.form.rhq_cd.value==""){	
		  ComBtnEnable("btn_create");
	   }else{
		   ComBtnDisable("btn_create");   
	   }
	}else{
		ComBtnEnable("btn_save");
		ComBtnDisable("btn_create");
	}
	
}


/* 개발자 작업  끝 */