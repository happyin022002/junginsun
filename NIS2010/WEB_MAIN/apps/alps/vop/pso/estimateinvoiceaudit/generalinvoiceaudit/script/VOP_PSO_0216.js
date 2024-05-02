/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_pso_0216.js
*@FileTitle : TPB Interface
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.26
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.11.12 진마리아
* 1.0 Creation
*
* History
* 2012.11.26 진마리아 CHM-201220618-01 TPB 비용 정보 지정시 해당 정보를 TPB IF용 테이블에 저장하고 제어함
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
     * @class vop_pso_0216 : vop_pso_0216 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_pso_0216() {
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

 // ===================================================================================
 // 전역변수 추상함수
 // ===================================================================================
    
 // IBSheet 
 var sheetObjects = new Array();
 var sheetCnt = 0;

 var formObj = null;

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
 document.onclick = processButtonClick;

 /**
  * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
  */
 function processButtonClick() {

 	var srcName = window.event.srcElement.getAttribute("name");
 	
 	switch (srcName) {	
 		case "btn_Close":
 			window.dialogArguments.handlingTpbFlg(window.dialogArguments.sheetObjects[0]);
 			self.close();
 			break;
 			
 		case "btn_OK":
 			var sheetObj = sheetObjects[0];
 			if(sheetObj.CellValue(sheetObj.LastRow, "sheet1_n3pty_bil_tp_cd")==""){
	 			ComShowCodeMessage("PSO00003", "Billing Case");
	 			break;
	 		}else if(sheetObj.CellValue(sheetObj.LastRow, "sheet1_n3pty_vndr_seq")==""){
	 			ComShowCodeMessage("PSO00003", "Service Provider");
	 			break;
	 		}
 			comPopupOK();
 			break;
 	}
 }
 
 /**
  * IBSheet Object를 배열로 등록
  * @param {ibsheet} sheetObj    IBSheet Object  
  **/
 function setSheetObject(sheet_obj){
     sheetObjects[sheetCnt++] = sheet_obj;
 }

 /**
  * Sheet 기본 설정 및 초기화
  * body 태그의 onLoad 이벤트핸들러 구현
  * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
  **/
 function loadPage() {
     //전역 변수 설정 
     formObj = document.form;
     sheetCnt = sheetObjects.length ;   
     
     //시트 초기화 
     for(var i=0 ; i < sheetCnt ; i++) {
         ComConfigSheet (sheetObjects[i]);
         initSheet(sheetObjects[i],i+1);
         ComEndConfigSheet(sheetObjects[i]);              
     }
     doActionIBSheet(sheetObjects[0], formObj, SEARCH01);
 }

 /**
   * 시트 초기설정값, 헤더 정의
   * @param {ibsheet} sheetObj  sheet
   * @param {int} sheetNo 시트번호
   */
 function initSheet(sheetObj, sheetNo) {
 	var cnt = 0;	
 	with (sheetObj) {
 		switch (sheetObj.id) {
 		case "sheet1": 
             // 높이 설정
 			style.height = 70;
 								
 			//전체 너비 설정
 			SheetWidth = mainTable.clientWidth;

 			//Host정보 설정[필수][HostIp, Port, PagePath]
 			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

 			//전체Merge 종류 [선택, Default msNone]
 			MergeSheet = msHeaderOnly;

 			//전체Edit 허용 여부 [선택, Default false]
 			Editable = true;

 			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 			InitRowInfo(1, 1, 15, 100);

 			var HeadTitle1 = "|Billing Case|Amount|3rd Party|3rd Party|Remarks";
 			var headCount = ComCountHeadTitle(HeadTitle1);
 								
 			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 			InitColumnInfo(headCount, 0, 0, true);

 			// 해더에서 처리할 수 있는 각종 기능을 설정한다					
 			InitHeadMode(true, false, true, true, false,false);
 			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 			InitHeadRow(0, HeadTitle1, true);
            
 			var prefix = "sheet1_";
             //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,	prefix+"ibflag");         
 			InitDataProperty(0, cnt++ , dtCombo,      	120,    daCenter,	true,	prefix+"n3pty_bil_tp_cd"	,true,		"",		dfNone,		0,	true,		true);
 			InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	true,	prefix+"if_amt"				,false,		"",		dfNullFloat,2,	false,		false);			
 			InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	true,	prefix+"vndr_lgl_eng_nm"	,false,		"",		dfNone,		0,	false,		false);
 			InitDataProperty(0, cnt++ , dtPopupEdit,	90,		daCenter,	true,	prefix+"n3pty_vndr_seq"		,true,		"",		dfNone,		0,	true,		true);
            InitDataProperty(0, cnt++ , dtData,	    	100,	daCenter,	true,	prefix+"if_rmk"				,false,		"",		dfNone,		0,	true,		true);
            
            InitDataValid(0, prefix+"n3pty_vndr_seq", vtNumericOnly);
			CountPosition = 0;
			ShowButtonImage = 1;
			ShowMsgMode=false;
			SelectHighLight = false;
			
            break;		
 		}
 	}
 }
 
  // Sheet관련 프로세스 처리
 function doActionIBSheet(sheetObj, formObj, sAction) {
	 sheetObj.ShowDebugMsg = false;
	 sheetObj.WaitImageVisible=false;
     switch(sAction) {
	     
     case SEARCH01:		//TPB Billing Type 조회
    	formObj.f_cmd.value = SEARCH01;
     	var sParam = FormQueryString(formObj);
		var sXml = sheetObj.GetSearchXml("VOP_PSO_0216GS.do", sParam);
		var billTypeCd = ComGetEtcData(sXml, "billTypeCd");
		var billTypeNm = ComGetEtcData(sXml, "billTypeNm");
		//조회한 billing type 정보를 combo에 setting
		sheetObj.InitDataCombo(0, "sheet1_n3pty_bil_tp_cd", billTypeNm, billTypeCd);
		
		setBasicData(sheetObj);
		
     	break;
     }
 }
	 
 function setBasicData(sheetObj) {
	 var formObj = document.form;
	 var row = sheetObj.DataInsert(-1);
	 sheetObj.CellValue2(row, "sheet1_if_amt") = formObj.if_amt.value;
	 sheetObj.CellValue2(row, "sheet1_n3pty_bil_tp_cd") = formObj.n3pty_bil_tp_cd.value;
	 sheetObj.CellValue2(row, "sheet1_if_rmk") = formObj.if_rmk.value;
	 sheetObj.CellValue2(row, "sheet1_vndr_lgl_eng_nm") = "SERVICE PROVIDER";
	 sheetObj.CellValue2(row, "sheet1_n3pty_vndr_seq") = formObj.n3pty_vndr_seq.value;
 }
 
 /**
  * IBSheet Popup Event
  */
 function sheet1_OnPopupClick(sheetObj,Row,Col){
 	var prefix = "sheet1_";

 	switch (sheetObj.ColSaveName(Col)) {
 	case prefix + "n3pty_vndr_seq" :
 		ComOpenPopup('/hanjin/VOP_PSO_0205.do', 500, 420, 'setPrntUsrRoleCd', '0,0', true, false, Row, Col, 0);
 		break;
 	}
 }
 
 function setPrntUsrRoleCd(aryPopupData, row, col, sheetIdx){
		var sheetObj = sheetObjects[0];
		var prefix = "sheet1_";
		sheetObj.CellValue2(row,prefix+"n3pty_vndr_seq")= aryPopupData[0][1];
//		sheetObj.CellValue2(row,prefix+"vndr_lgl_eng_nm")= aryPopupData[0][2];
 }
 
 /**
  * IBSheet OnChange Event
  */
 function sheet1_OnChange(sheetObj,Row,Col) {
 	var formObj = document.form;
 	var prefix = "sheet1_";
 	switch (sheetObj.ColSaveName(Col)) {
	 	case prefix + "n3pty_vndr_seq" :   
	 		formObj.f_cmd.value = SEARCH02;
	 		
	 		var param = "f_cmd="+SEARCH02+"&n3pty_vndr_seq=" + sheetObj.CellValue(Row, Col); 
	 		var sXml = sheetObj.GetSearchXml("VOP_PSO_0216GS.do", param );
	
	 		var chkVndr = ComGetEtcData(sXml, "check_vndr");//X-사용가능
			if(chkVndr != "X"){
				ComShowCodeMessage("PSO00001", "Operator Code");
				sheetObj.CellValue2(Row, Col) = "";
				sheetObj.SelectCell(Row, Col);
			}
	
	 		break;
 	}
 }	
 
	/* 개발자 작업  끝 */