/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0964.js
*@FileTitle  : S/O Office Popup 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/

/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 예)Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */
/**
 * @extends Bkg
 * @class ESD_TRS_0964 : 예)Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
	/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/
	var sheetObjects=new Array();
	var sheetCnt=0;
	/**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++) {
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
	        //khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		goSoOfficeCode(sheetObjects[0]);
		//html컨트롤 이벤트초기화
		initControl();
	}
	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {int}     sheetNo     sheetObjects 배열에서 순번
	 **/
	function initControl() {
	//		axon_event.addListener  ('keypress', 'engnum_keypress', 'boo_bkg_no', 'vvd_vvd');
	//		axon_event.addListener  ('click', 'manual_click', 'manual');    //BKG Creation탭의 manual이 바뀐경우
	//		axon_event.addListener  ('keyup', 'bkgno_keyup', 'boo_bkg_no'); //BKG Creation탭의 Booking No가 바뀐경우
	//		axon_event.addListenerFormat('blur',    'obj_blur',     form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onblur이벤트에 코드 처리
	//		axon_event.addListenerFormat('focus',   'obj_focus',    form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onfocus이벤트에 코드 처리
	//		axon_event.addListenerFormat('keypress','obj_keypress', form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리   
	//		axon_event.addListener  ('change', 'customer_change', 'cus_cust_nm');     //Cust탭의 Cusromer_nm이 바뀐경우
	}
	//Axon 이벤트 처리2. 이벤트처리함수 --- start
	/**
	* HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
	 **/
//	function engnum_keypress() {
//	}
	/**
	 * BKG Creation manual. <br>
	 **/
//	function manual_click() {
//	}
	/**
	 * BKG Creation탭의 Booking No가 바뀐경우 기능을 처리한다. <br>
	 **/
//	function bkgno_keyup() {
//	}
	/**
	 * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
	 **/
//	function obj_blur(){
//	}
	/**
	 * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
	 **/
//	function obj_focus(){
//	}
	/**
	 * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
	 **/
//	function obj_keypress(){
//	}
	//Axon 이벤트 처리2. 이벤트처리함수 --- end
	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick=processButtonClick;
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject=sheetObjects[0];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_apply":
					goApply(sheetObject);
				break;
				case "btn_close":
					ComClosePopup(); 
				break;
			} // end switch
		} catch(e) {
			if( e == "[object Error]") {
				errMsg=ComGetMsg("TRS90106");
				ComShowMessage(errMsg);
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetNo) {
			case 1:      //sheet1 init
			    with(sheetObj){
				      var HeadTitle="Seq|Sel.|STS|Office code";
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"chk1" },
				             {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"ofc_cd_name",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:200,  Align:"Left",    ColMerge:1,   SaveName:"ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				      InitColumns(cols);
				      SetEditable(1);//전체Edit허용여부[선택,Defaultfalse]
				      SetSheetHeight(260);// 높이 설정
		            }
			break;
		}
	}
	//라디오 버튼을 클릭시 데이터를 검색한다.
	function sheet_OnChange(sheetObj, Row, Col, Value) {
		if( sheetObj.ColSaveName(Col) == "chk1" ) {
			if( Value == "1" ) {
				sheetObj.SetRowStatus(Row,"I");
			} else {
				sheetObj.SetRowStatus(Row,"R");
			}
		}
	}
	function goApply(sheetObj) {
		var opener_obj;
		opener_obj = window.dialogArguments;
		if(!opener_obj)
			opener_obj=opener;
		if(!opener_obj)
			opener_obj=parent;
		
		var sRow=sheetObj.FindCheckedRow("chk1");
		var arrRow=sRow.split("|");	
		var doc_rtn="";
		for( var i=0; i < arrRow.length; i++ ) {	
			doc_rtn=doc_rtn + doSepRemove(sheetObj.GetCellValue(arrRow[i], "ofc_cd_name"), " ")+",";
		}
		doc_rtn=doc_rtn.substring(0, doc_rtn.length-1);
		opener_obj.rtn_office_code(doc_rtn);
		ComClosePopup(); 
	}
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction) {
		switch(sAction) {
			case IBSEARCH: //조회 101
				formObj.f_cmd.value=SEARCH03;
				sheetObj.DoSearch("ESD_TRS_0964GS.do", TrsFrmQryString(formObj), {Sync:2} );
			break;
		}
	}
	function goSoOfficeCode(sheetObj) {
		doActionIBSheet(sheetObj, document.form, IBSEARCH);
	}
	/**
	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
	*/
	function sheet_OnSearchEnd(sheetObj, Code, errMsg){
		if(Code < 0){
			ComShowMessage(errMsg);
		}
		var lv_ofc=document.form.ctrl_ofc_cd.value;
		var lv_row=sheetObj.FindText("ofc_cd", lv_ofc, 0, -1, false);
		sheetObj.SelectCell(lv_row, "ofc_cd_name", false);
	}