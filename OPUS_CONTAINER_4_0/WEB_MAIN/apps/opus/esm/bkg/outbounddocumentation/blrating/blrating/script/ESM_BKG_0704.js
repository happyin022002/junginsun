/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0704.js
*@FileTitle  : DOC Adjustment 
*@author     : CLT
*@version    : 1.0
*@since      : 2015/
=========================================================
*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
* @author CLT
 */
/**
 * @extends
 * @class ESM_BKG_0704 : ESM_BKG_0704 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
	/* 개발자 작업	*/
	// 공통전역변수
	var tabObjects=new Array();
	var tabCnt=0;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var btn_calc=false;
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick=processButtonClick;
	/**
	 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
	 * 추가한다
	 */
	function loadPage() {
		for (var i=0; i < sheetObjects.length; i++) {
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		var formObj = document.form;
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	}
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		switch(sheetObj.id) {
        case "sheet1":      //sheet1 init
		    with(sheetObj){
			      var HeadTitle="|Charge Code|POR/POL";
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"Status" },
			             {Type:"Text",      Hidden:0,  Width:200,   Align:"Center",  ColMerge:1,   SaveName:"charge_code",	KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"PopupEdit", Hidden:0,  Width:200,   Align:"Center",  ColMerge:1,   SaveName:"doc_loc_cd",	KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1 ,   EditLen:5, AcceptKeys:"E", InputCaseSensitive:1 } 
			             ];
			      SetColProperty(0 , 3, {EditLen:5, AcceptKeys:"E", InputCaseSensitive:1});
//			      SetColProperty(0 ,  "doc_loc_cd" , {EditLen:"5" , FullInput:1, InputCaseSensitive:1});
			      InitColumns(cols);
			      SetSheetHeight(135);
	      		}
			break;
		}
	}
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject=sheetObjects[0];
		/** **************************************************** */
		var formObj=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
				case "btn_save":
					doActionIBSheet(sheetObject, formObj, IBSAVE);
					break;
				case "btn_close":
					ComClosePopup(); 
					break;
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	
	// handling sheet process
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
			case IBSEARCH:      //Default
				sheetObj.SetWaitImageVisible(1);
				formObj.f_cmd.value=SEARCH;
				var sXml=sheetObj.GetSearchData("ESM_BKG_0704GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchData(sXml);
				sheetObj.SetWaitImageVisible(0);
				break;
			case IBSAVE:
				if(!validateForm(sheetObj, formObj, sAction)) return;
				
				formObj.f_cmd.value=MULTI;
				var sParam=sheetObjects[0].GetSaveString();
				sParam += "&" + FormQueryString(formObj); // hidden param value
				
				ComOpenWait(true);
				var sXml=sheetObj.GetSaveData("ESM_BKG_0704GS.do", sParam);
				var State=ComGetEtcData(sXml,"TRANS_RESULT_KEY");
				if(State != null){
					if ( State == "S" ) {
						sheetObj.LoadSaveData(sXml);
						ComShowMessage(ComGetMsg("BKG06071"));
					}
				}
				ComOpenWait(false);
				break;
		}
	}
	
	/**
	 * validation doc_loc_cd
	 */
	function validateForm(sheetObj, formObj, sAction){
		var t_doc_loc = sheetObj.GetCellValue(sheetObj.GetSelectRow(), "doc_loc_cd");
		if (t_doc_loc.length == 0){
			return true;
		}else if(t_doc_loc.length < 5 ) {
			ComShowCodeMessage("BKG95018","POR/POL","5");
			return false;
		}else if (t_doc_loc.length == 5) {
	    	formObj.f_cmd.value=SEARCH01;
			var sParam=sheetObj.GetSaveString();
			sParam += "&" + FormQueryString(formObj); // hidden param value
	    	
			var sXml=sheetObj.GetSearchData("ESM_BKG_0704GS.do", sParam);
			var loc_flg=ComGetEtcData(sXml, "doc_loc_flg");
			if(loc_flg != "Y"){
				ComShowCodeMessage("BKG00461");     
				return false;	
			}
		}
		return true;
	}


	
	/**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * Sheet1 on popup click event handling
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function sheet1_OnPopupClick(sheetObj, Row, Col) {
		ComOpenPopup('/opuscntr/COM_ENS_051.do?pgmNo=COM_ENS_051', 800, 640, 'setCallBack0704',  "1,0,1,1,1", false);
	}
	
	/**
	 * Sheet1 on popup return method
	 * @param rArray
	 * @return
	 */
	function setCallBack0704(rArray){
		if(rArray!=null){
			sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "doc_loc_cd",rArray[0][3]);
		}
	 }

//	/* 개발자 작업  끝 */