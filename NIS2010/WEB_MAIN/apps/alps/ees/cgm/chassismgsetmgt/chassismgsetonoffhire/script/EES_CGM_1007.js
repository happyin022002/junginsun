/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_CGM_1007.js
 *@FileTitle : Chassis Pool Inquiry/Update
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.02
 *@LastModifier : 박의수
 *@LastVersion : 1.0
 * 2009.06.02 박의수
 * 1.0 Creation
 * 2009.07.16 조재성
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
 * @class ees_cgm_1007 : ees_cgm_1007 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ees_cgm_1007() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject     = setSheetObject;
	this.loadPage           = loadPage;
	this.initSheet          = initSheet;
	this.initControl        = initControl;
	this.doActionIBSheet    = doActionIBSheet;
	this.setTabObject       = setTabObject;
	this.validateForm       = validateForm;
}

/* 개발자 작업 */

// 공통전역변수
var tabObjects = new Array();
var tabCnt     = 0;
var beforetab  = 1;

var sheetObjects = new Array();
var sheetCnt     = 0;

var comboObjects = new Array();
var comboCnt = 0;


// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;
var gBtnName = ["btn_add",
                "btn_delete"];

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	var sheetObj    = sheetObjects[0];

	/*******************************************************/
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_add":
			
			//버튼 FLAG 상태에 따라 이벤트를 안먹게 리턴
			if(formObj.btn_status.value == "R") {
			    return;
			}
			var Row = sheetObj.DataInsert();
			sheetObj.CellValue(Row, "chss_pool_cdw") = ""; 


			// 추가된 행의 상태값을 INSERT 가 아닌  UPDATE 상태로 변경(조회후 업데이트 임.)
			sheetObj.RowStatus(i)="U";
				
			sheetObj.CellValue(i, "eq_knd_cd") = document.forms[0].eq_knd_cd.value;
			
			// CELL EDITABLE - FALSE
			sheetObj.CellEditable(Row, "eq_tpsz_cd") = false;
			sheetObj.CellEditable(Row, "crnt_yd_cd") = false;
			sheetObj.CellEditable(Row, "chss_pool_cd") = false;	

			// 콤보 함수 호출
			popupCall();
			break;

		case "btn_delete":
			//버튼 FLAG 상태에 따라 이벤트를 안먹게 리턴
			if(formObj.btn_status.value == "R") {
			    return;
			}
			// 화면에서만 삭제(DB에서는 삭제하면 안됨.)
			rowDelete(sheetObj);
			break;

		case "btn_loadexcel":
			doActionIBSheet(sheetObj,formObj,IBLOADEXCEL);
			
			// 추가된 행의 상태값을 INSERT 가 아닌 UPDATE 상태로 변경(조회후 업데이트 임.)
			for(i=1; i<sheetObj.rowCount+1; i++){
				sheetObj.RowStatus(i)="U";
			}
			// 콤보 함수 호출
			popupCall();
	    	break;

		case "btn_downexcel":
			doActionIBSheet(sheetObj,formObj,IBDOWNEXCEL);
	    	break;
	    	
		case "btn_retrieve":
			formObj.eq_no.value = "";
			//formObj.btn_status.value = "R"
			
			// 버튼 활성/비활성 처리 
	    	ComBtnDisable("btn_add");
	    	ComBtnDisable("btn_delete");
			//ComEnableObject(formObj.btn_add, false); //이미지 오브젝트 DISABLE 시키기
	    	
			// IBSHEET 조회
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
			
			// 버튼 활성/비활성 FLAG 
			formObj.btn_status.value = "R"

			// 콤보 함수 호출
			popupCall();
			break;

		case "btn_new":
			//초기화 함수 호출
			objectClear();
			
			// 버튼 활성/비활성 FLAG 
			formObj.btn_status.value = "N"
				
			// 버튼 활성/비활성 처리 
	    	ComBtnEnable("btn_add");
	    	ComBtnEnable("btn_delete");
			break;

		case "btn_update":
			// 체크박스가 선택된 행만을 대상으로 SAVE 로직을 태운다. chungpa
			var chkRows = sheetObj.FindCheckedRow("del_chk");
			var arrChkRows = chkRows.split("|");
			
			// 체크된 행만큼 루프를 돌면서 chss_pool_cdw 가  선택되지 않은 항목이 있으면 CGM10009 메시지 띄운다.
			var cellText;
			for(k=0; k < arrChkRows.length-1; k++){
				cellText = sheetObj.CellValue(arrChkRows[k], "chss_pool_cdw");
				/* // chungpa 20100114 add empty column start
				if(cellText == ""){
					ComShowCodeMessage("CGM10009", " To-Be Pool");
					return;
				}*/ // chungpa 20100114 add empty column end
			}
			if(arrChkRows.length-1 <= 0)
			{
				ComShowCodeMessage("CGM10009", " To-Be Pool");
				return;
			}
			
			//기존 bug
			// To-Be Pool 미선택 항목 검사
			//for(i=1; i<sheetObj.rowCount+1; i++){
			//	if(sheetObj.CellValue(i, "chss_pool_cdw") == ""){
			//		ComShowCodeMessage("CGM10009", " To-Be Pool");
			//		return;
			//	}
			//}
			doActionIBSheet(sheetObj, formObj, IBSAVE);
			
			//chungpa 20090720 save 후 검색조건에 따라 화면을 다시 뿌려준다. start
			//btn_retrieve 동일.  이용태수석요구사항.
			formObj.eq_no.value = "";
			//formObj.btn_status.value = "R"
			// 버튼 활성/비활성 처리 
	    	ComBtnDisable("btn_add");
	    	ComBtnDisable("btn_delete");
			//ComEnableObject(formObj.btn_add, false); //이미지 오브젝트 DISABLE 시키기
			// IBSHEET 조회
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
			// 버튼 활성/비활성 FLAG 
			formObj.btn_status.value = "R"
			// 콤보 함수 호출
			popupCall();
			//chungpa 20090720 save 후 검색조건에 따라 화면을 다시 뿌려준다. end
			break;

		// LOCATION 팝업(단건 선택일 경우 띠우는 방법)
		case "ComOpenPopupWithTargetLoc":
        	var tmp = formObj.location.text;
        	if(tmp == "RCC"){
        		ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 460,"setProgramNo2", "0,1,1,1,1,1", true, false);
        	}else if(tmp == "LCC"){
        		ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 460,"setProgramNo2", "0,1,1,1,1,1", true, false);
        	}else if(tmp == "SCC"){
        		ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 460,"setProgramNo2", "0,1,1,1,1,1", true, false);
        	}
  			break;

		case "ComOpenPopupWithTargetYard":
			// YARD 팝업(다건 선택일 경우 띠우는 방법)
			ComOpenPopup("/hanjin/COM_ENS_061.do", 800, 475, "setProgramNo", "0,1,1,1,1,1", true, false);
  			break;
		} // end switch
		tRoleApply();
	}catch(e) {
 		if( e == "[object Error]") {
     		ComShowMessage(OBJECT_ERROR);
 		} else {
     		ComShowMessage(e);
 		}
 	}
}


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
		// 시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		// 마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
}

/**
 * Sheet 로딩 후 기본 설정 및 초기화 <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2009.10.20
 */     
 function sheet1_OnLoadFinish(sheetObj) {
     sheetObj.WaitImageVisible = false;

     var formObj = document.form;
	 var sheetObj = sheetObjects[0];
	 
     axon_event.addListener		("change",		"sheet1_OnChange",	"eq_no");
	 axon_event.addListenerFormat("keypress",	"obj_keypress",		form);
	 axon_event.addListenerForm	('keyup', 		'obj_keyup', 		form);
	
     // IBMULTI COMBO 초기화
	 // POOl
	 comboCnt = 0;
  	 comboObjects[comboCnt++] = document.chss_pool_cd;
  	 // LOCATION
  	 comboObjects[comboCnt++] = document.location;
  	 // Active Status
  	 comboObjects[comboCnt++] = document.aciac_div_cd;
  	 
  	 for(var k=0;k<comboObjects.length;k++){
  		 initCombo(comboObjects[k]);
	 }
  	 

	 // Active St. MultiCombo 값 초기화
  	 var arrActive = new Array();
   	 arrActive[0] = "A|Active";
  	 arrActive[1] = "I|In-active";
  	 makeComboObject(document.form.aciac_div_cd, arrActive, 1, 0, 1);
  	
	 // 콤보 초기화(GRID 안) - 화면 처음 loading시 한번만 해주면 조회할때는 계속 가져다 사용
	 //doActionIBSheet(sheetObj, formObj, SEARCH02); // 현재 사용안함. chungpa 20090717 주석처리 
	
  	 /*
  	 // 콤보 초기화(GRID 밖)
	 doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC04);
	 doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
	 
 	 //초기화 함수 호출(콤보값과 텍스트박스 값)
	 objectClear();
     
	 document.form.aciac_div_cd.Index2 = 1;
	 */
     doActionIBSheet(sheetObjects[0], document.form, IBRESET);
     
	 tRoleApply();
     sheetObj.WaitImageVisible = true; 
 } 

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	switch (sheetNo) {
	case 1: // sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 420;

			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 6, 100);

			var HeadTitle = "ibflag||Seq.|Chassis No.|Type/Size|Yard|Active Status|Current Pool|To-be Pool|eq_knd_cd|chss_rgst_upd_ofc_cd|chss_rgst_upd_id|chss_rgst_upd_dt";
			var headCount = ComCountHeadTitle(HeadTitle);
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
			
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			
			// 데이터속성 [ROW,	COL,	DATATYPE,		WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,			KEYFIELD,	CALCULOGIC,	DATAFORMAT,	POINTCOUNT,	UPDATEEDIT,	INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0,	cnt++,	dtHiddenStatus,	50,		daCenter,	false,	"ibflag");
			InitDataProperty(0,	cnt++,	dtCheckBox,		50,		daCenter,	false,	"del_chk");
			InitDataProperty(0,	cnt++,	dtDataSeq,		40,		daCenter,	false,	"seq");
			InitDataProperty(0,	cnt++,	dtData,			150,	daCenter,	false,	"eq_no",				true);
			InitDataProperty(0,	cnt++,	dtData,			120,	daCenter,	false,	"eq_tpsz_cd",			false,		"",			dfNone,		true,		false,		false);

			InitDataProperty(0,	cnt++,	dtData,			140,	daCenter,	false,	"crnt_yd_cd",			false,		"",			dfNone,		true,		false,		false);
			InitDataProperty(0,	cnt++,	dtData,			140,	daCenter,	false,	"aciac_div_cd",			false,		"",			dfNone,		true,		false,		false);
			
			InitDataProperty(0,	cnt++,	dtData,			170,	daCenter,	false,	"chss_pool_cd",			false,		"",			dfNone,		true,		false,		false);
			InitDataProperty(0,	cnt++,	dtCombo,		100,	daCenter,	false,	"chss_pool_cdw",		false);
			InitDataProperty(0,	cnt++,	dtHidden,		100,	daCenter,	false,	"eq_knd_cd",			false);
			InitDataProperty(0,	cnt++,	dtHidden,		100,	daCenter,	false,	"chss_rgst_upd_ofc_cd",	false);

			InitDataProperty(0,	cnt++,	dtHidden,		100,	daCenter,	false,	"chss_rgst_upd_id",		false);
			InitDataProperty(0,	cnt++,	dtHidden,		100,	daCenter,	false,	"chss_rgst_upd_dt",		false);
		}
		sheetObj.InitDataValid(0, "eq_no", vtEngUpOther, "1234567890"); // 영문 대문자와 숫자만 입력
		break;
	}
}


//SHEET 관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	//sheetObj.ShowDebugMsg = true;
	sheetObj.ShowDebugMsg = false;
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	
	switch (sAction) {

	// SEARCH LOGIC
	case IBSEARCH:
		
		if(validateForm(sheetObj,formObj,sAction)){
			sheetObj.WaitImageVisible=false;
			ComOpenWait(true);	
			
			formObj.f_cmd.value = SEARCH;
			// 기존 sheetObj.DoSearch("EES_CGM_1007GS.do", FormQueryString(formObj));
			
			// 새로 적용 chungpa 20090826 
			var sXml = sheetObj.GetSearchXml("EES_CGM_1007GS.do" , FormQueryString(formObj));
			sheetObj.LoadSearchXml(sXml);
			
			ComOpenWait(false);	
			
			//Inactive일경우 색깔을 고쳐준다. chungpa 20090826 1007 color red
	 		var dataCount = ComGetTotalRows(sXml);	 		// 데이터 건수
			if(dataCount > 0){ 	 							// 데이터가 존재할 경우
				for(var i = 1; i <= sheetObj.RowCount; i++){
					if(sheetObj.cellValue(i,"aciac_div_cd") == "I")
					{
						//sheetObj.CellEditable(Row, "del_chk") = false;
						sheetObj.RowFontColor(i) = sheetObj.RgbColor(255, 0, 0);	// Row 전체 Font Color 를 Red 로 설정
					}
				}
			}
							
		}
		break;

	// SAVE LOGIC
	case IBSAVE:
		// 체크박스가 선택된 행만을 대상으로 SAVE 로직을 태운다.
		with(sheetObjects[0]) {
		    // 체크된 행번 가져오기, 결과:"1|2|3"
		    var chkRows = FindCheckedRow("del_chk")
		    
		    // 전체 행만큼 루프를 돌면서 체크된 행번 목록에 i가 없을 경우 i값의 ROW STATUS를 비운다.
		    /* chungpa 20090720 save bug fix.
		    for (i=1; i<LastRow+1; i++) {
		        if (chkRows.indexOf(i) < 0) {
		            RowStatus(i) = "";

		        }
		    }*/
		}
		sheetObj.WaitImageVisible=false;
		ComOpenWait(true);			
		formObj.f_cmd.value = MULTI;
		sheetObj.DoSave("EES_CGM_1007GS.do", FormQueryString(formObj));
		
		ComOpenWait(false);			
		break;

	// EXCEL FILE DATA - IBSHEET GRID LOADING
	case IBLOADEXCEL:		// EXCEL UPLOAD
		if(sheetObj.rowcount >= 1)
		{
			sheetObj.RemoveAll();
		}
		sheetObj.LoadExcel(); 
		break;
	
	case IBDOWNEXCEL:     	// EXCEL DOWNLOAD
		sheetObj.SpeedDown2Excel(-1,false,true,"","",false,false,"",true,"");
		break;			

	
	// IBSHEET GRID 밖에 콤보 추가 (POOL NAME)
 	case IBSEARCH_ASYNC02:	
   		
		formObj.f_cmd.value = SEARCH02;
		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
		var cols = ComCgmXml2ComboString(sXml, "code1", "desc1");
		
		//IBSHEET GRID 밖에 있는 콤보
 	  	ComCgmMakeMultiCombo1007(formObj.chss_pool_cd, cols, 0, 0);
		break;
		
	// IBSHEET GRID 밖에 콤보 추가 (LOCATION)
	case IBSEARCH_ASYNC04:
		formObj.f_cmd.value = SEARCH;
		formObj.intg_cd_id.value = COM_CD_TYPE_CD02117;

		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
		var sStr = ComGetEtcData(sXml,"comboList");
		var arrStr = sStr.split("@");
		
		// COMBO CONTROL, 결과 문자열, TEXT INDEX, CODE INDEX
		MakeComboObject2(formObj.location, arrStr, 0, 0);
		break;

	// IBSHEET GRID 안에 콤보 추가(TO-BE POOL)
	case SEARCH02:
		/* 현재 사용안함. chungpa 20090717 주석처리
		formObj.f_cmd.value = SEARCH02;
		var xml = sheetObj.GetSearchXml ("CgmCodeMgtGS.do", FormQueryString(formObj));
 	  	var cols = ComCgmXml2ComboString(xml, "code1", "code1|desc1", "\t");
 	  	*/
 	  	break;

    case IBSEARCH_ASYNC08:
    	formObj.f_cmd.value = SEARCH17;
    	var location = formObj.location.text;
    	
    	if(location == "RCC")
    	{
    		formObj.eq_orz_cht_chktype.value = "RCC";
    		formObj.eq_orz_cht_rcc_cd.value = formObj.scc_cd.value;
    	}else if(location == "LCC")
    	{
    		formObj.eq_orz_cht_chktype.value = "LCC";
    		formObj.eq_orz_cht_lcc_cd.value = formObj.scc_cd.value;
    	}else if(location == "SCC")
    	{
    		formObj.eq_orz_cht_chktype.value = "SCC";
    		formObj.eq_orz_cht_scc_cd.value = formObj.scc_cd.value;
    	}else
    	{
    		formObj.eq_orz_cht_chktype.value = "";
    		formObj.eq_orz_cht_scc_cd.value = "";
    	}
 		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
   		// 데이터 건수
        var dataCount = ComGetTotalRows(sXml);
        if(dataCount==0){
        	ComShowCodeMessage('CGM10009','location cd');
	   		formObj.scc_cd.value = "";
	   		formObj.scc_cd.focus();
        }
  	    break;		     	  	

	case IBRESET:
		var idx = 0
		var sXml2 = document.form2.sXml.value;
		var arrXml = sXml2.split("|$$|");

		//Location
		if ( arrXml[idx] == null ) {return;}
		var vArrayListData = ComCgmXml2ListMap(arrXml[idx]);
	    var arrStr1 = new Array();
		for ( var i = 0; i < vArrayListData.length; i++) {
		    vListData = vArrayListData[i];
		    arrStr1[i] = vListData["code1"] + "|" + vListData["desc1"];
		}
		MakeComboObject2(formObj.location, arrStr1, 0, 0);     
		idx++;        		

		//POOL
		if ( arrXml[idx] == null ) {return;}
		var cols = ComCgmXml2ComboString(arrXml[idx], "code1", "desc1");
		
		//IBSHEET GRID 밖에 있는 콤보
 	  	ComCgmMakeMultiCombo1007(formObj.chss_pool_cd, cols, 0, 0);
 	  	idx++;   
 	  	
 	  	
 		//초기화 함수 호출(콤보값과 텍스트박스 값)
 		objectClear();
 	    
  		break;  	    
	}
	//sheetObj.ShowDebugMsg = false;
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	  with(formObj){
  		 switch(sAction) {
  		 	case IBSEARCH: //chungpa 20090720 add to fix enter focus
  		 		if(formObj.eq_no.value == ''){

  					// 검색조건 값이 하나도 입력되지 않았을 경우(초기화면에서 바로 조회시)
  					if(form.crnt_yd_cd.value == ""){
  						if(formObj.scc_cd.value == ""){
  							if(formObj.chss_pool_cd.text == ""){
  								ComShowCodeMessage("CGM10004", "Pool Name or Location or Yard");
  								formObj.chss_pool_cd.focus();
  								
  								return false;
  							}
  						}
  					}
  					// Location을 RCC,LCC,SCC를 선택했을시는 Location Input Box에 값이 있어야 조회되도록 Validation 체크 추가 chungpa
  					if(formObj.location.text == undefined || formObj.location.text == "")
  					{
  						ComShowCodeMessage("CGM10004", "location");
  						formObj.location.focus();
  						return false;
  					}
     			}
       			break;
  		 }      
  	 }
	return true;
}


/**
 * IBMULTI COMBO
 */
function initCombo(comboObj) {
    switch(comboObj.id) {

    // LOCATION
    case "chss_pool_cd":
    	with(comboObj){
        	Code = "";
	        Text = "";
        	DropHeight = 100;
        	MultiSelect = false;
        	MaxSelect = 1;
        	UseCode = true;
            Enable = true;
	        UseAutoComplete = true;           
    	}
    	break;
    
    case "location":
    	with(comboObj){
        	Code = "";
            Text = "";
            DropHeight = 100;
            MultiSelect = false;
            MaxSelect = 1;	    
            UseCode = true;
            Enable = true;
            UseAutoComplete = true;   
    	}
    	break;
    	
	case "aciac_div_cd":
 		var cnt=0;
        with(comboObj) {
        	Code = "";
            Text = "";
            DropHeight = 100;
            MultiSelect = false;
            MaxSelect = 1;	    
            UseCode = true;
            Enable = true;
            UseAutoComplete = true;
        }
        break;    	
    }
}


/** 
 * IBSHEET GRID 밖에 콤보 추가(POOL COMBO)
 */ 
function ComCgmMakeMultiCombo1007(cmbObj, arrStr, txtCol, codeCol) {
	cmbObj.RemoveAll();
	cmbObj.InsertItem(0, "", "");

	// LOOP를 돌리기 위해 데이타 갯수를 구함 
	var arrCode = arrStr[0].split("|");
	for (var i = 0; i < arrCode.length;i++ ) {
		var arrCode2 = arrCode[i].split("|");
		cmbObj.InsertItem(i+1, arrCode2[txtCol], arrCode2[codeCol]);
	}
	cmbObj.Index2 = "" ;
}
/** 
 * IBSHEET GRID 밖에 콤보(LOCATION COMBO)
 */ 
function MakeComboObject2(cmbObj, arrStr, txtCol, codeCol) {
	cmbObj.RemoveAll();
	// All 필요할때 아래 주석 제거
	//cmbObj.InsertItem(0,"","");
	//cmbObj.InsertItem(0, "", "");
	
	for (var i = 0; i < arrStr.length;i++ ) {
		var arrCode = arrStr[i].split("|");
		cmbObj.InsertItem(i, arrCode[1], arrCode[codeCol]);
     	}
	cmbObj.Index2 = "" ;
}


/**
 * 기본 오브젝트 초기화 
 */
function objectClear(){
	var formObj = document.form;
	var sheetObj  = sheetObjects[0];

	// 데이타 초기화
	sheetObj.RemoveAll();

	// 화면 초기화
	comboObjects[0].Index2 = 0;
	comboObjects[1].Index2 = 0;
	comboObjects[2].Index2 = 1;
	
	formObj.scc_cd.value = "";
	formObj.crnt_yd_cd.value  = "";
}


/**
 * PROGRAM NO(YARD) 입력부분(팝업에서 다건선택)
 */   
function setProgramNo(aryPopupData, row, col, sheetIdx){
	var formObj = document.form;
	var crnt_yd_cd = "";
	var i = 0;

	for(i = 0; i < aryPopupData.length; i++){
		crnt_yd_cd += aryPopupData[i][3];
		
		if(i < aryPopupData.length - 1){
			crnt_yd_cd += ",";
		}
	}
	formObj.crnt_yd_cd.value = crnt_yd_cd;
}
/**
 * PROGRAM NO(LOCATION) 입력부분(팝업에서 다건선택)
 */   
function setProgramNo2(aryPopupData, row, col, sheetIdx){
	var formObj = document.form;
	var tmp = formObj.location.text;
	var scc_cd = "";
	var i = 0;

	if(tmp == "RCC") {
		for(i = 0; i < aryPopupData.length; i++){
			scc_cd += aryPopupData[i][11];
			
			if(i < aryPopupData.length - 1){
				scc_cd += ",";
			}
		}
		formObj.scc_cd.value = scc_cd;
	}
	else if(tmp == "LCC") {
		for(i = 0; i < aryPopupData.length; i++){
			scc_cd += aryPopupData[i][10];
			
			if(i < aryPopupData.length - 1){
				scc_cd += ",";
			}
		}
		formObj.scc_cd.value = scc_cd;
	}
	else if(tmp == "SCC") {
		for(i = 0; i < aryPopupData.length; i++){
			scc_cd += aryPopupData[i][8];
			
			if(i < aryPopupData.length - 1){
				scc_cd += ",";
			}
		}
		formObj.scc_cd.value = scc_cd;
	}
}

 /**
  * Location Multi-Combo 의 OnChange 이벤트처리 <br>
  * @param  {object} ComboObj	필수	 Sheet Object
  * @param  {int} 	Index_Code	필수
  * @param  {string} Text		필수
  * @return 없음
  * @author 조재성
  * @version 2009.07.16
  */ 
 function location_OnChange(ComboObj, Index_Code, Text){
 	document.form.scc_cd.value = "";
 }

/**
 * POOL NAME 콤보 생성
 */ 
function popupCall(){
	var formObj = document.form;
	var sheetObj  = sheetObjects[0];
	
	// IBSheet Combo(To-Be Pool) 콤보
	formObj.f_cmd.value = SEARCH02;
	var xml = sheetObj.GetSearchXml ("CgmCodeMgtGS.do", FormQueryString(formObj));
  	var cols = ComCgmXml2ComboString(xml, "code1", "code1|desc1", "\t");
  	// chungpa 20100114 add empty column start
  	var Cols1 = " |"+cols[1];
  	var Cols0 = " |"+cols[0];
  	// chungpa 20100114 add empty column end.
  	sheetObj.InitDataCombo(0, "chss_pool_cdw", Cols1, Cols0);
}


/**
 * 키 입력 제한(JSP 파일  해당 텍스트 필드에 DATAFORMAT에 셋팅해줌.)
 */
function obj_keypress(){
	 obj = event.srcElement;
	 if(obj.dataformat == null){
		 return;
	 }
	 window.defaultStatus = obj.dataformat;
	 
	 switch(obj.dataformat) {
  	    case "engup":
	        if(obj.name == "scc_cd"){
	        	ComKeyOnlyAlphabet("uppernum");
	        }
	        break;

  	    case "isnum":
	    	ComKeyOnlyNumber(obj);
	    	break;

  	    case "engbc":
  	    	CgmKeyOnlyAlphabet("uppernum");
	    	break;
	 }
 }


/**
 * 1. XML 데이타를 해당행에 컬럼별로 나눠서 넣어줌.
 * 2. EXPIRY DATE CODE 변경시 날짜 선택 여부 ENABLE DISABLE
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var formObj  = document.form;
	var sheetObj = sheetObjects[0];
	var prefix   = "";
	var chk      = true;

	with (sheetObj) {
		var colName = ColSaveName(Col);
		switch (colName) {
		
		case "del_chk":
			if(sheetObj.CellValue(Row,"del_chk")!="1")
			{
				sheetObj.CellValue(Row,"chss_pool_cdw") = "";
			}
			break;
			
		case "chss_pool_cdw":
			if (sheetObj.CellValue(Row,"chss_pool_cdw").length > 0) //선택이 되었으면 체크박스를 체크해준다. 
			{
				sheetObj.CellValue(Row,"del_chk")="1";
			}
			break;
		
		case "eq_no":
			
			/*
			formObj.eq_no.value = sheetObj.cellValue(Row, "eq_no");
			// CHASSIS NO 중복 체크
		 	var invRefNoCol = sheetObj.SaveNameCol("eq_no");
		 	if (Col == invRefNoCol && Row !=0) { 
		 		var CellValue = sheetObj.cellValue(Row, Col);
		 		var Row2 = sheetObj.FindText(Col, CellValue, -1);
			
		 		if(Row2 > 0){
		 			Row2 = sheetObj.FindText(Col, CellValue, Row2+1);
		       
		 			if (Row2 > 0) {
		 				ComShowCodeMessage("CGM10031", "Chassis No");
						// 해당 Cell 값을 Null로 설정
						sheetObj.cellValue(Row, Col) = '';
						// 그리드에 포커스 이동
						sheetObj.SelectCell(Row, Col, true);
		 			}
				}
			}
			*/
			if(Row >1){
				// chassis no 체크
				for(i=1; i<sheetObj.rowCount; i++){
					if(sheetObj.CellValue(i, "eq_no")== Value && Row != i  && sheetObj.CellValue(i, "eq_no")!='')
 					{
						// 체크 메시지 출력
			        	// ComShowMessage('CGM20007');

						//ComShowMessage("Chassis No :" +sheetObj.CellValue(i, "eq_no") +" is duplicated.");
						
			        	ComShowCodeMessage("CGM10017", "Chassis No");
			        	// 해당 Cell 값을 Null로 설정
						sheetObj.CellValue(Row, "eq_no") = "";
			        	return false;
 					}
				}
			} 
			
		 	
		 	//서버 중복 체크
		 	var eqNo = Value;

			// XML에 담긴 값을 해당컬럼에 값을 넣어줌
			if(eqNo.length > 0) {
				formObj.f_cmd.value = SEARCH;
				document.form.eq_no.value = eqNo;

				var sXml = sheetObj.GetSearchXml("EES_CGM_1007GS.do", FormQueryString(formObj));
				//alert("############" + sXml);

				if(DomXml2String(sXml, "eq_no") == null || DomXml2String(sXml, "eq_no") == "") {
					// 데이타가 없으므로 해당셀을 지워주고 포커스 이동 한다

					// 서버에 메세지 등록되면 교체해 준다
					ComShowCodeMessage("CGM10017", "Chassis No");

					// 해당 Cell 값을 Null로 설정
					sheetObj.CellValue2(Row, Col) = "";
					// 그리드에 포커스 이동
					sheetObj.SelectCell(Row, Col, true);
					formObj.eq_no.value = "";
					return;
				} else {
					// 데이타가 있으므로 해당 셀에 값을 세팅해 준다
					sheetObj.CellValue2(Row, "ibflag")               = "U";
					sheetObj.CellValue2(Row, "eq_tpsz_cd")           = DomXml2String(sXml, "eq_tpsz_cd");
					sheetObj.CellValue2(Row, "crnt_yd_cd")           = DomXml2String(sXml, "crnt_yd_cd");
					sheetObj.CellValue2(Row, "aciac_div_cd")         = DomXml2String(sXml, "aciac_div_cd"); //필드 추가됨
					sheetObj.CellValue2(Row, "chss_pool_cd")         = DomXml2String(sXml, "chss_pool_cd");
					sheetObj.CellValue2(Row, "eq_knd_cd")            = DomXml2String(sXml, "eq_knd_cd");
					sheetObj.CellValue2(Row, "chss_rgst_upd_ofc_cd") = DomXml2String(sXml, "chss_rgst_upd_ofc_cd");

					sheetObj.CellValue2(Row, "chss_rgst_upd_id")     = DomXml2String(sXml, "chss_rgst_upd_id");
					sheetObj.CellValue2(Row, "chss_rgst_upd_dt")     = DomXml2String(sXml, "chss_rgst_upd_dt");
					formObj.eq_no.value = "";
					
			 		// Inactive일경우 색깔을 고쳐준다. chungpa 20090826 1007 color red
					// AddRow중에는 color적용이 안된다. 아래 코드 무효.
					if(DomXml2String(sXml, "aciac_div_cd") == "I")
					{
						RowFontColor(Row) = RgbColor(255, 0, 0);	// Row 전체 Font Color 를 Red 로 설정
					}
				}
			}
			break;
		}
	}
}

 /**
  * 엑셀 업로드시 체크
  * @param sheetObj
  * @author Chae-Shung Cho
  * @version 2009.10.22
  */
function sheet1_OnLoadExcel(sheetObj){
	var formObj  = document.form;
	var sheetObj = sheetObjects[0];
	var prefix   = "";
	var chk      = true;
	
	// chassis no 체크
	for(iChk=1; iChk<sheetObj.rowCount+1; iChk++){
		
		var cellValue = sheetObj.cellValue(iChk, "eq_no"); 
		//alert(cellValue);
		if (cellValue != ''){
			formObj.f_cmd.value = SEARCH;
			document.form.eq_no.value = cellValue;
			var sXml = sheetObj.GetSearchXml("EES_CGM_1007GS.do", FormQueryString(formObj));
			//alert("############" + sXml);

			if(DomXml2String(sXml, "eq_no") == null || DomXml2String(sXml, "eq_no") == "") {
				// 데이타가 있으므로 해당 셀에 값을 세팅해 준다
				sheetObj.CellValue2(iChk, "ibflag")               = "U";
				sheetObj.CellValue2(iChk, "eq_no")          	  = "";
				sheetObj.CellValue2(iChk, "eq_tpsz_cd")           = "";
				sheetObj.CellValue2(iChk, "crnt_yd_cd")           = "";
				sheetObj.CellValue2(iChk, "aciac_div_cd")         = "";
				sheetObj.CellValue2(iChk, "chss_pool_cd")         = "";
				sheetObj.CellValue2(iChk, "eq_knd_cd")            = "";
				sheetObj.CellValue2(iChk, "chss_rgst_upd_ofc_cd") = "";
				sheetObj.CellValue2(iChk, "chss_rgst_upd_id")     = "";
				sheetObj.CellValue2(iChk, "chss_rgst_upd_dt")     = "";
				formObj.eq_no.value = "";
			} else {
				// 데이타가 있으므로 해당 셀에 값을 세팅해 준다
				sheetObj.CellValue2(iChk, "ibflag")               = "U";
				sheetObj.CellValue2(iChk, "eq_tpsz_cd")           = DomXml2String(sXml, "eq_tpsz_cd");
				sheetObj.CellValue2(iChk, "crnt_yd_cd")           = DomXml2String(sXml, "crnt_yd_cd");
				sheetObj.CellValue2(iChk, "aciac_div_cd")         = DomXml2String(sXml, "aciac_div_cd"); //필드 추가됨
				sheetObj.CellValue2(iChk, "chss_pool_cd")         = DomXml2String(sXml, "chss_pool_cd");
				sheetObj.CellValue2(iChk, "eq_knd_cd")            = DomXml2String(sXml, "eq_knd_cd");
				sheetObj.CellValue2(iChk, "chss_rgst_upd_ofc_cd") = DomXml2String(sXml, "chss_rgst_upd_ofc_cd");
				sheetObj.CellValue2(iChk, "chss_rgst_upd_id")     = DomXml2String(sXml, "chss_rgst_upd_id");
				sheetObj.CellValue2(iChk, "chss_rgst_upd_dt")     = DomXml2String(sXml, "chss_rgst_upd_dt");
				formObj.eq_no.value = "";
		 		// Inactive일경우 색깔을 고쳐준다. chungpa 20090826 1007 color red
				// AddiChk중에는 color적용이 안된다. 아래 코드 무효.
				if(DomXml2String(sXml, "aciac_div_cd") == "I")
				{
					sheetObj.RowFontColor(iChk) = sheetObj.RgbColor(255, 0, 0);	// iChk 전체 Font Color 를 Red 로 설정
				}
			}			
		}
	}
	
}
 

/**
 * 선택된 ROW 삭제 
 */
function rowDelete(sheetObj){
	for(i=sheetObj.rowCount; i>0; i--){
		if(sheetObj.CellValue(i, "ibflag") != ""   &&  sheetObj.CellValue(i, "del_chk")=="1") {
			sheetObj.RowDelete(i, false);
		}
	}
}


/**
 * 저장 완료시 처리
 */
function sheet1_OnSaveEnd(ErrMsg) {
    if (ErrMsg == "[object]") {
		// 성공메세지 띠우고 GRID 초기화
		ComShowCodeMessage("CGM00002", "To-Be Pool");
		sheetObjects[0].removeAll();
    }
}


///////////////////////////////////////////////////////////////////////////////////////////////////
// 아래 DomXml2String 은 컬럼 매핑등 수정없이 그대로 사용(지우지 말것)
///////////////////////////////////////////////////////////////////////////////////////////////////


/**
 * 숫자, 영어대문자, 콤마(KeyOnlyAlphabet을 가져다가 콤마만 허용하도록 추가)
 */
function CgmKeyOnlyAlphabet(sFlag){   
    try { 
        var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
        var bCanNum  = false;
        //ComDebug('key  = '+keyValue);

        if (sFlag==undefined || sFlag==null || sFlag.constructor!=String) sFlag="";
        sFlag = sFlag.toLowerCase();

        if (sFlag.length > 3){
            if (sFlag.substr(sFlag.length-3)=="num") bCanNum=true;
            if (sFlag.length > 5) sFlag = sFlag.substr(0,5);
        }
          
        if(keyValue >= 97 && keyValue <= 122){                  //소문자
            if (sFlag=="upper") event.keyCode = keyValue + 65 - 97;
             event.returnValue = true;
        } else if(keyValue >= 65 && keyValue <= 90){            //대문자
            if (sFlag=="lower") event.keyCode = keyValue + 97 - 65;
             event.returnValue = true;
        } else if(bCanNum && keyValue >= 48 && keyValue <= 57) {//숫자
             event.returnValue = true;
        } else if(keyValue == 44){         // ,
    event.returnValue = true; 
  } else {   
             event.returnValue = false;
        }
        return true;
    } catch(err) { ComFuncErrMsg(err.message); }
}

 /** 
 * Combo Object 에 값을 추가하는 처리 <br>
 * @param  {object} cmbObj	필수 Combo Object
 * @param  {String} arrStr	필수 대상 문자열 (다수의 경우는 '|' 로 구분) 
 * @param  {int} 	txtCol	필수 Combo Text에 표시할 Colume Index 번호
 * @param  {int} 	codeCol	필수 Combo Code 값에 설정할 Column Index 번호
 * @param  {int} 	opt		필수 공백문자 추가여부 (0:추가안함, 1:추가)
 * @return 없음
 * @author 조재성
 * @version 2009.09.23
 */ 
function makeComboObject(cmbObj, arrStr, txtCol, codeCol, opt) {
	cmbObj.RemoveAll();
	
	if(opt == 0) {
		for (var i = 0; i < arrStr.length;i++ ) {
			var arrCode = arrStr[i].split("|");
    		cmbObj.InsertItem(i, arrCode[txtCol], arrCode[codeCol]);
        }
	} else if(opt == 1){
		cmbObj.InsertItem(0,"","");
		for (var i = 0; i < arrStr.length;i++ ) {
			var arrCode = arrStr[i].split("|");
    		cmbObj.InsertItem(i+1, arrCode[txtCol], arrCode[codeCol]);
        }
	}
	
	cmbObj.Index2 = "" ;
}  
 
/**
 * 유효값체크 로직(자리수에 맞춰서)
 * @author 조재성 2009.09.30
 */
function obj_keyup(){
	 var formObj = document.form;
	 var sheetObj = sheetObjects[0];
	 obj = event.srcElement;
	 switch(obj.name){
 	 	case "scc_cd":
	 		var crntLocCd = ComTrimAll(formObj.scc_cd.value);
	   		var arrCrntLocCd = crntLocCd.split(",");
	   		
	   		for(var i = 0; i < arrCrntLocCd.length; i++){
	   		// 입력오류 체크 (예> ,,)
	 			if(arrCrntLocCd[i] == ''){
	 				ComShowCodeMessage('CGM10009','Location');
	 				formObj.scc_cd.value = "";
	 				ComSetFocus(formObj.scc_cd);
	 				break;
	 			}else{
	    	 		//if(formObj.scc_cd.value != ''){
	    	 		if(formObj.scc_cd.value.length == 5){
	    	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC08);
	    	 		}
	    	 	}
	 		}
	 		break;
	}
}
	 
 /**
  * 기능(ex:btn_save)에 권한(trole) 적용  <br>
  * @param  없음
  * @return 없음
  * @author 조재성
  * @version 2010.03.05
  */     
  function tRoleApply() {
	  var formObj = document.form;
	  if(formObj.trole.value == "Authenticated")
	  {

	  }else
	  {
		  ComBtnDisable("btn_add");
		  ComBtnDisable("btn_delete");
		  ComBtnDisable("btn_update");
	  }
  } 	 
/* 개발자 작업 끝 */
