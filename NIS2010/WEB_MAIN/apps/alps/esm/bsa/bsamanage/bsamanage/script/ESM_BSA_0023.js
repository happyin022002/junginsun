/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_BSA_0023.js
*@FileTitle : Add Carriers
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
*=========================================================
* History :
* 2011.08.19 최성민 [CHM-201112943-01] Add Carrier Time-Out 에러 수정
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
 * @class ESM_BSA_0023 : ESM_BSA_0023 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BSA_0023() {
	this.processButtonClick		= tprocessButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initControl            = initControl;
	this.doActionIBSheet 		= doActionIBSheet;
	this.validateForm 			= validateForm;
}
    
// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;



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

			case "btn_save":
				doActionIBSheet(sheetObject,formObject,IBSAVE);
				break;

			case "btn_downexcel":
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
				break;

			case "btn_close":
				self.close();
				break;
			case "btn_add":
				var bsaOpCd = formObject.bsa_op_cd.value;
				var param = "?bsa_op_cd=" + bsaOpCd;
				ComOpenPopup("/hanjin/ESM_BSA_0120.do"+param, 406, 375,'getCrrCd', '1,0,1,1,1,1,1,1',true);
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
* popup close시 호출되는 함수
*
*/
function getCrrCd(rArray){
	        
//	var sheetObject = sheetObjects[0];
//	var formObject = document.form;
	var cArray = rArray[0];
//	var param ="crr_cd="+cArray[2]
//	  +"&f_cmd="+COMMAND01;
//	
//	ComOpenWait(true);   
//	var sXml = sheetObject.GetSaveXml("ESM_BSA_0023GS.do",param); 
//	var sResult = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
//	ComOpenWait(false);  
	if (cArray[2] != "") {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);  //Load시 조회
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


var UOC    = 3;  //필드수: 가변길이에서 보이는 한 필드는 실제는 UOC개 임
var fixCnt = 2;  //고정길이 컬럼수
var varCnt = 27; //가변길이 컬럼수 (초기적재)
var totCnt = fixCnt + varCnt; //전체 컬럼수 = 고정길이 + 가변길이

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo,header) {
	var arrHeader = "";
	
	switch(sheetNo) {
		case 1:      //sheet1 init
				if (header == "") { //UOC Dependent
					header = "|CRR1|CRR1|CRR1" + "|CRR2|CRR2|CRR2" + "|CRR3|CRR3|CRR3"
					       + "|CRR4|CRR4|CRR4" + "|CRR5|CRR5|CRR5" + "|CRR6|CRR6|CRR6"
					       + "|CRR7|CRR7|CRR7" + "|CRR8|CRR8|CRR8" + "|CRR9|CRR9|CRR9";
				}
				
				arrHeader = header.split("|");
				varCnt = arrHeader.length -1;
				totCnt = fixCnt + varCnt;

				with (sheetObj) {
					style.height = GetSheetHeight(8) ;
					SheetWidth = mainTable.clientWidth;
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					MergeSheet = msHeaderOnly;
					Editable = true;
					InitRowInfo(1, 1, 9, 100);
					InitColumnInfo(totCnt, 2, 0, true);
					InitHeadMode(true, true, false, true, false, false);

					var HeadTitle = "STS|JOB CD" + header;
					InitHeadRow(0, HeadTitle, true);

					//데이터속성  DataRow, Col, [DataType], [Width], [DataAlign],
					//          [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat],
					//          [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort],
					//          [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
					var cnt = 0;
					InitDataProperty(0, cnt++, dtStatus, 30, daCenter, true, "ibflag");
					InitDataProperty(0, cnt++, dtData,   95, daLeft,   true, "bsa_op_jb_nm", false, "", dfNone, 0, false, false);

					for (var i=0; i<(varCnt/UOC) ; i++) {
						InitDataProperty(0, cnt++, dtHidden,    0, daCenter, true, "D_ibflag"+i,    false, "", dfNone, 0, false, false);
						InitDataProperty(0, cnt++, dtHidden,    0, daCenter, true, "D_bsa_op_cd"+i, false, "", dfNone, 0, false, false);
						InitDataProperty(0, cnt++, dtCheckBox, 42, daCenter, true, "D_aply_flg"+i,  false, "", dfNone, 0, true,  true);
					}


					HeadRowHeight = 10;
					CountPosition  = 0 ;

	                WaitImageVisible = false;	 
				}
				break;

	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {

		case IBSEARCH:      //조회
			if (!validateForm(sheetObj,formObj,sAction)) {
				return false;
			}

			ComOpenWait(true);
			formObj.f_cmd.value = SEARCHLIST;
			var sXml = sheetObj.GetSearchXml("ESM_BSA_0023GS.do", bsaFormString(formObj,getParam('ESM_BSA_0023')));
			var header = GetEtcDataForExceptional(sXml, "header");
			var crrcd = GetEtcDataForExceptional(sXml, "crrCd");
			
			if (header != "") {
				formObj.crr_cd.value = crrcd;
				sheetObj.Redraw = false;
				sheetObj.Visible = false;
				sheetObj.RemoveAll();
				sheetObj.Reset();
				ComConfigSheet(sheetObjects[0]);
				initSheet(sheetObj, 1, header);
				sheetObj.Visible = true;
				sheetObj.Redraw = true;
				sheetObj.LoadSearchXml(sXml);
				sheetObj.RemoveEtcData(); // ETC 데이타 삭제
				
			}

			break;

		case IBSAVE:        //저장
			if (!validateForm(sheetObj,formObj,sAction)) {
				return false;
			}
			
			ComOpenWait(true);
			formObj.f_cmd.value = MODIFY;
			var sParam = bsaFormString(formObj,getParam('ESM_BSA_0023','S'));		
			var sParamSheet = sheetObj.GetSaveString(false);

			if (sParamSheet != "") {
				sParam = sParam + "&" + sParamSheet;
			}	
			
			var sXml = sheetObj.GetSaveXml("ESM_BSA_0023GS.do", sParam);
			var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
			
			if (backendJobKey != null && backendJobKey.length > 0) {
				ComSetObjValue(formObj.backendjob_key, backendJobKey);
				sheetObj.RequestTimeOut = 7200; //초 - 2시간
				backEndJobTimer = setInterval(getBackEndJobStatus, 5000);	//밀리초  - 5초
			}
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


function sheet1_OnChange(sheetObj,Row,Col,Value) {
	// Flag 변경시
	if (sheetObj.ColSaveName(Col).substring(0,10) == "D_aply_flg") {
		var TarCol = Col - (UOC - 1);
		if(sheetObj.CellValue(Row, Col) == sheetObj.CellSearchValue(Row, Col)){
			sheetObj.CellValue2(Row, TarCol) = "R";
		}
		else{
			sheetObj.CellValue2(Row, TarCol) = "U";
		}
	}
}

function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
	with (sheetObj) {
		if (LastRow > 0) {
			for (var k=0; k<LastCol; k++) {
				if (CellValue(0,k) == "SML") {
					CellBackColor(0,k) = RgbColor(222,251,248);
				}
			}
		}

		for (var i=1; i<LastRow+1; i++) {
			for (var j=1; j<LastCol+1; j++) {
				if (ColSaveName(j).substring(0,10)  == "D_aply_flg") {
					if (CellValue(i,j) == "1") {
						CellEditable(i,j) = false;
					} else if (CellValue(i,j) == "0") {
						CellEditable(i,j) = true;
					}
				}
				if (CellValue(0,j) == "SML") {
						CellEditable(i,j) = false;
				}
			}
		}
	}
	
	ComOpenWait(false);
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction) {
	switch (sAction) {
		case IBSAVE:		

			if (!sheetObj.IsDataModified) {
				ComShowCodeMessage("BSA00004");
				return false;
			}
				
			if (sheetObj.IsDataModified && sheetObj.GetSaveString() == "") {
				return false;
			}
		
			break;
	}
	return true;
}

/**
 * BackEndJob 관련 Status='3' 이 될때까지 확인한다.<br>
 * <br><b>Example :</b>
 * <pre>
 *      getBackEndJobStatus();
 * </pre>
 * @return 없음
 * @author 최성민
 * @version 2011.07.28
 */     
function getBackEndJobStatus() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	
	ComOpenWait(true);
	formObj.f_cmd.value = SEARCH02;
	var sXml = sheetObj.GetSearchXml("ESM_BSA_0023GS.do", bsaFormQueryString(formObj));
	var jobState = ComGetEtcData(sXml, "jb_sts_flg");
	
	if (jobState == "3") {
		getBackEndJobSearch();
		clearInterval(backEndJobTimer);
	} else if (jobState == "4") {
		ComShowCodeMessage("BSA00001");
		ComOpenWait(false);
		clearInterval(backEndJobTimer);
	} else if (jobState == "5") {
		ComShowCodeMessage("BSA00002");
		ComOpenWait(false);
		clearInterval(backEndJobTimer);
	}
}   

/**
 * BackEndJob의 결과가 완료되면 결과를 조회하여 메세지를 출력한다.<br>
 * <br><b>Example :</b>
 * <pre>
 *      getBackEndJobSearch();
 * </pre>
 * @return 없음
 * @author 최성민
 * @version 2011.07.28
 */       
function getBackEndJobSearch() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	formObj.f_cmd.value = SEARCH03;
	
	var sXml = sheetObj.GetSearchXml("ESM_BSA_0023GS.do", bsaFormQueryString(formObj));
	var message = ComGetEtcData(sXml, "message");
	
	if(message == "SUCCESS"){
		doActionIBSheet(sheetObj, document.form, IBSEARCH);
		// [BSA10006] : 작업이 완료되었습니다.
		ComShowCodeMessage("BSA10006");
	} else {
		ComOpenWait(false);
		ComShowCodeMessage("BSA00001");
	}
} 
