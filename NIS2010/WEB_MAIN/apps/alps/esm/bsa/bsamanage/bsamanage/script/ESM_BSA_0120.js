/*=========================================================
* Copyright(c) 2006 CyberLogitec
* @FileName : ESM_BSA_120.jsp
* @FileTitle : Carrier's Register
* Open Issues :
* Change history :
* @LastModifyDate : 2006-12-18
* @LastModifier : Kim Jong Beom
* @LastVersion : 1.0
*  2006-12-18 Kim Jong Beom
*  1.0 최초 생성
=========================================================
' History :
' 2008.05.07 PEJ R200804296325 css 파일 참조 확인 및 수정 요청
* 2009.09.29 남궁진호 ALPS 전환작업 1.0 Creation
* 2009.11.12 남궁진호  -CHM-200901152 : Carrier Code의 MDM 관리에 따른 변경요청
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
     * @class ESM_BSA_0120 : ESM_BSA_0120 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BSA_0120() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.isValidCarrier			= isValidCarrier;
    	this.sheet1_OnChange		= sheet1_OnChange;
    }
    
   	/* 개발자 작업	*/

 // 공통전역변수
 var sheetObjects = new Array();
 var sheetCnt = 0;
 var selValue = "";
 var selRow = 0;


 /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
 function processButtonClick() {
 	var sheetObject = sheetObjects[0];
 	var formObject = document.form;

 	try {
 		var srcName = window.event.srcElement.getAttribute("name");

 		switch(srcName) {

 			case "btn_retrieve":
 				doActionIBSheet(sheetObject,formObject,IBSEARCH);
 				break;

 			case "btn_rowadd":
 				sheetObject.DataInsert();
 				break;

 			case "btn_save":
 				doActionIBSheet(sheetObject,formObject,IBSAVE);
 				break;

 			case "btn_downexcel":
 				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
 				break;

 			case "btn_close":
 				self.close();
 				break;
 			 case "btn_ok":
 				var chkRow = sheetObject.FindCheckedRow("radio");
 				var bsaOpCd =formObject.bsa_op_cd.value;
 				
 				var arrRow = chkRow.split("|");
 				  for (idx=0; idx<arrRow.length-1; idx++){ 
 					  var crrCd = sheetObject.CellValue(arrRow[0],"crr_cd")
 				  }
 				 var param ="crr_cd="+crrCd
 				  +"&rdoOp_cd="+bsaOpCd
				  +"&f_cmd="+MULTI02;
 				
 				 if (arrRow.length == 2){
 					ComOpenWait(true); 
 					var sXml =sheetObj.GetSaveXml("ESM_BSA_0120GS.do",param);
 					ComOpenWait(false); 
 				}
 				comPopupOK();
 				break;

 		} // end switch
 	} catch(e) {
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
 function setSheetObject(sheet_obj) {
 	 sheetObjects[sheetCnt++] = sheet_obj;
 }

 /**
  * Sheet 기본 설정 및 초기화
  * body 태그의 onLoad 이벤트핸들러 구현
  * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
  */
 function loadPage() {
 	for (i=0; i<sheetObjects.length; i++) {
 		ComConfigSheet(sheetObjects[i]);
 		initSheet(sheetObjects[i], i+1, "");
 		ComEndConfigSheet(sheetObjects[i]);
 	}

 	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);  //Load시 조회
 }


 /**
  * 시트 초기설정값, 헤더 정의
  * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
  * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
  */
 function initSheet(sheetObj,sheetNo,header) {
 	var arrHeader = "";
 	var formObject = document.form;
 	switch(sheetNo) {
 		case 1:      //sheet1 init
 			with (sheetObj) {
 				style.height = GetSheetHeight(11) ;
 				SheetWidth = mainTable.clientWidth;
 				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
 				MergeSheet = msHeaderOnly;
 				Editable = true;
 				InitRowInfo(1, 1, 9, 100);
 				InitColumnInfo(4, 0, 0, true);
 				InitHeadMode(true, true, false, true, false, false);

 				var HeadTitle = "||Code|Name";
 				InitHeadRow(0, HeadTitle, true);

 				//데이터속성  DataRow, Col, [DataType], [Width], [DataAlign],
 				//          [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat],
 				//          [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort],
 				//          [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
 				var cnt = 0;
 				InitDataProperty(0, cnt++ , dtRadioCheck,20,    daCenter,  false,    "radio",   false,          "",       dfNone,	    0,     true,       true);
                InitDataProperty(0, cnt++ , dtCheckBox,  20,    daCenter,  false,    "checkbox",   false,          "",       dfNone,   	0,     true,       true);
 				InitDataProperty(0, cnt++, dtData,       55, 	daCenter,  true, "crr_cd",   true,  "", dfNone, 0, false, false,3);
 				InitDataProperty(0, cnt++, dtData,    	 200, 	daLeft,    true, "crr_nm",   false, "", dfNone, 0, false,  false,500);
 				
 				if(formObject.bsa_op_cd.value==""){
 					ColHidden(0)=true;
 					ColHidden(1)=true;
 				}
// 				InitDataValid(0, "crr_cd", 9); //vtEngUpOnly=9


 				HeadRowHeight = 10;
 				CountPosition  = 0 ;
 			}
 			break;

 	}
 }

 // Sheet관련 프로세스 처리
 function doActionIBSheet(sheetObj,formObj,sAction) {
 	sheetObj.ShowDebugMsg = false;

 	switch(sAction) {
 		case IBSEARCH:      //조회
 			if (!validateCond(sheetObj,formObj,sAction)) {
 				return false;
 			}
 			formObj.f_cmd.value = SEARCHLIST;
 			sheetObj.DoSearch4Post("ESM_BSA_0120GS.do", bsaFormString(formObj,getParam('ESM_BSA_0120')));
 			break;

 		case IBSAVE:        //저장
 			if (!validateForm(sheetObj,formObj,sAction)) {
 				return false;
 			}
 			formObj.f_cmd.value = MULTI;
 			sheetObj.DoSave("ESM_BSA_0120GS.do", bsaFormString(formObj,getParam('ESM_BSA_0120','S')), -1, false);
 			break;

 		case IBDOWNEXCEL:   //엑셀 다운로드
 			//sheetObj.SpeedDown2Excel(-1);
             var excelType = selectDownExcelMethod(sheetObj);
             switch (excelType) {
                 case "AY":
                     sheetObj.Down2Excel(0, false, false, true);
                     break;
                 case "DY":
                     sheetObj.Down2Excel(-1, false, false, true);
                     break;
                 case "AN":
                     sheetObj.SpeedDown2Excel(0, false, false);
                     break;
                 case "DN":
                     sheetObj.SpeedDown2Excel(-1, false, false);
                     break;
             }               
 			break;
 	}
 }

 /**
 * Carrier Code 입력값에 대한 유효성검증 프로세스 처리
 * MDM Carrier Code 체크
 */
function sheet1_OnChange(sheetObj,Row,Col,Value) {
	var formObj = document.form;
	
	if (sheetObj.ColSaveName(Col) == "crr_cd") {

		var param ="crr_cd="+Value
				  +"&f_cmd="+MULTI02;
		var sXml = sheetObj.GetSearchXml("ESM_BSA_0120GS.do", param); 
		
		var crrNm =ComXmlString(sXml, "crr_nm");
		if(crrNm==""){
			ComShowMessage(ComGetMsg('BSA10043',Value));
			sheetObj.CellValue2(Row, 'crr_cd') ="";
			sheetObj.CellValue2(Row, 'crr_nm') ="";
			
		}else{
			sheetObj.CellValue2(Row, 'crr_nm') =ComXmlString(sXml, "crr_nm");
		}
	}
}

 /**
  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  */
 function validateForm(sheetObj,formObj,sAction) {
 	with(formObj){
 	}

 	return true;
 }

   
 /**
  * 화면 조회값에 대한 유효성검증 프로세스 처리
  */
 function validateCond(sheetObj,formObj,sAction) {
 	with(formObj){
 	}

 	return true;
 }

	/* 개발자 작업  끝 */