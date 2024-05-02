/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_1030.js
*@FileTitle  : Empty Repo Guideline Email
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/09
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0 ;
var comObjects=new Array();
var pri_combo_cd="";
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
document.onclick=processButtonClick;
	/**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj){
	   sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
	 * 추가한다
	 */
	function loadPage() {
		var formObj=document.form;
	    for(i=0;i<sheetObjects.length;i++){
	    	//시작 환경 설정 함수 이름 변경
	        ComConfigSheet(sheetObjects[i]);
	        initSheet(sheetObjects[i],i+1);
			//마지막 환경 설정 함수 추가
	        ComEndConfigSheet(sheetObjects[i]);
	    }
	}
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
	function processButtonClick() {
		/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
		var sheetObject=sheetObjects[0];
		/** **************************************************** */
		var formObj=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch (srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObj,IBSEARCH);
				break;
				case "btn_save":
					doActionIBSheet(sheetObject, formObj, MULTI);
				break;
				case "btn_new":
					init_form();//화면 초기화.
				break;
				case "btn_downexcel":
					doActionIBSheet(sheetObject,formObj,IBDOWNEXCEL);
				break;
				case "btns_open_ofc":		//Office Code
					openPopup();
				break;
				case "btn_row_add":		// row add
					sheetObject.DataInsert();
				break;	
			} // end switch
		} catch (e) { 
			if (e == "[object Error]") {
				ComShowCodeMessage("EQR01109");//The service is not available now
			} else {
				alert(e);
			}
		}
	}
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction) {
	    switch(sAction) {
	       case IBSEARCH:      //조회
	    	   	ComOpenWait(true);
				sheetObj.RemoveAll();
				formObj.f_cmd.value=SEARCH;
				sheetObj.DoSearch("EES_EQR_1030GS.do", FormQueryString(formObj) );
	       break;
		   case MULTI:	// Save
			    formObj.f_cmd.value=MULTI;
				sheetObj.DoSave("EES_EQR_1030GS.do",FormQueryString(formObj));
		   break;
	       case IBDOWNEXCEL:   //엑셀 다운로드
	       		if(sheetObj.RowCount() > 0){
	 	       		sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
				}else{
					ComShowCodeMessage("EQR01104");//조회된 데이터가 없습니다
				}
	       break;
	    }
	}
	/**
	 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
	 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj, sheetNo){
		var cnt=0;
		switch (sheetNo) {
			case 1: // sheet1 init
			    with(sheetObj){
			      var HeadTitle="Del|Seq|User ID|User Name|RHQ|Office Code|e-Mail|";
			      HeadTitleCnt=ComCountHeadTitle(HeadTitle);
	
			      SetConfig( { SearchMode:2, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
			      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
	
			      var cols = [ {Type:"DelCheck",  Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"delchk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Seq",       Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"gline_rcpt_usr_id",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:20 },
				             {Type:"Text",      Hidden:0,  Width:250,  Align:"Center",  ColMerge:0,   SaveName:"usr_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ar_hd_qtr_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:0,   SaveName:"gline_rcpt_eml",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
				             {Type:"Status",    Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			       
			      InitColumns(cols);
			      SetSheetHeight(410);
			}
			break;
		}
	}
	/**
	 * 조회 완료 이벤트 후 로직 <br>
	 */
	function sheet1_OnSearchEnd(sheetObj, code, ErrMsg) {
		ComOpenWait(false);
	}
	 /**
	 * 셀을 마우스 클릭했을때 발생하는 이벤트 <br>
	 */
	function sheet1_OnClick(sheetObj, Row, Col, Value) {
		var formObj=document.form;
	}
	/*
	 * Grid sheet 에서 onchange event 발생시 처리
	 */
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var formObj=document.form;
		var colName=sheetObj.ColSaveName(Col);
		if( colName == "gline_rcpt_usr_id" ) {	// User ID 
			var usr_id=sheetObj.GetCellValue(Row, colName);	// usr id 입력값
			// GRID 에 동일한 ID 가 존재하는지 검사
			for( i=1; i < sheetObj.RowCount()+1; i++) {
				var row_value=sheetObj.GetCellValue(i, "gline_rcpt_usr_id");
			    if(i != Row && usr_id == row_value) {  // 동일 row 존재(입력row 는 비교대상 제외)   
			    	// 중복 USR ID 존재
		 			ComShowCodeMessage("EQR01140");	// There is duplicate user id
		 			sheetObj.SetCellValue(Row, "gline_rcpt_usr_id","",0);
					return false;		    	
			    }
			}
			formObj.f_cmd.value=SEARCH01; 
	  		var sXml=sheetObj.GetSearchData("EES_EQR_1030GS.do?usr_id="+usr_id, FormQueryString(formObj));
	 		var usr_id=ComGetEtcData(sXml,"gline_rcpt_usr_id")
	 		//USR_ID_VAL -- T:중복없음(사용가능), F:중복존재 입력불가
	 		var dup_chk=ComGetEtcData(sXml,"usr_id_val")
	 		if(dup_chk=="F") { // 중복 데이터 존재
	 			ComShowCodeMessage("EQR01140");	// There is duplicate user id
	 			sheetObj.SetCellValue(Row, "gline_rcpt_usr_id","",0);
				return false;
	 		}else {  // 중복 아님
	 			if(usr_id!=null && usr_id !="") {  // 존재하는 USER ID
	 				sheetObj.SetCellValue(Row, "gline_rcpt_usr_id",ComGetEtcData(sXml,"gline_rcpt_usr_id"),0);
	 	 			sheetObj.SetCellValue(Row, "usr_nm",ComGetEtcData(sXml,"usr_nm"),0);
	 	 			sheetObj.SetCellValue(Row, "ar_hd_qtr_ofc_cd",ComGetEtcData(sXml,"ar_hd_qtr_ofc_cd"),0);
	 	 			sheetObj.SetCellValue(Row, "ofc_cd",ComGetEtcData(sXml,"ofc_cd"),0);
	 	 			sheetObj.SetCellValue(Row, "gline_rcpt_eml",ComGetEtcData(sXml,"gline_rcpt_eml"),0);
	 			}else {  // 존재하지 않는 USER ID
	 				ComShowCodeMessage("EQR01141"); // This user id isn\'t available.
	 				sheetObj.SetCellValue(Row, "gline_rcpt_usr_id","",0);
	 				return false;
	 			}
	 		} 		
		}else if( colName == "gline_rcpt_eml" ) { // EMAIL
		    //메일 주소 유효성 검증
			if(ComIsEmailAddr(sheetObj.GetCellValue(Row, colName))==false){
				ComShowCodeMessage("EQR01142");
				return false;				
			}
		} 		
	}
	// 저장후 메세지 표현
	function sheet1_OnSaveEnd(sheetObj, code, errMsg){
		var formObj=document.form;
		if (errMsg == "") {
			ComShowCodeMessage("EQR01001");		
		}
	}
	/**
	 * New 버튼 클릭시 화면 초기화.
	 */
	function init_form() {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		formObj.f_rhqcd.value=""; // rhq office 기본값
		formObj.f_ofccd.value=""; // office code 지우기
		sheetObj.RemoveAll(); // GRID 제거
	}
	/**
	 * Office Pop-up Open 부분<br>
	 */
	function openPopup() {
		ComOpenPopupWithTarget('/opuscntr/COM_ENS_071.do', 755, 500, "ofc_cd:f_ofccd", "1,0,1,1,1,1,1,1", true);
		return;
	}
