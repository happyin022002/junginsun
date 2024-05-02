/* =========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1505.js
*@FileTitle  : Transmit Result Error Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
 ========================================================= */
/* 개발자 작업 */
// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		var shtObj = sheetObjects[0];
		var frmObj = document.form;
		try {
			var srcName = ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_close":
					ComClosePopup();
					break;
			} // end switch
		} catch(e) {
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
	function setSheetObject(shtObj) {
		sheetObjects[sheetCnt++] = shtObj;
	}


	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		for (var i = 0; i<sheetObjects.length; i++){
			// khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i+1);
			// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		// (sheet1_OnLoad에 적용시에 Bug로 인하여 오류발생 됨에 유의)
		var frmObj = document.form;
		if (frmObj.jp_msg_tp_id.value != "SAS111") {
			sheetObjects[0].SetColHidden("hbl_div", 1);
			sheetObjects[0].SetColHidden("hbl_no", 1);
		}
		if (frmObj.jp_msg_tp_id.value == "SAS108") {
			if (frmObj.sc108_rst_dtl.value != "") {
				var sc108RstDtlArr = frmObj.sc108_rst_dtl.value.split("/");
				var newRowNum = 0;
				var attrCtnt = "Discrepancy Identifier  ";
				with (sheetObjects[0]) {
					for (var k in sc108RstDtlArr) {
						if (sc108RstDtlArr[k] != "") {
							newRowNum = DataInsert(-1);
							SetCellValue(newRowNum, "attr_ctnt1",sc108RstDtlArr[k],0);
							switch (sc108RstDtlArr[k]) {
								case "H":
									SetCellValue(newRowNum, "attr_ctnt2","AMR and CMR have been done. AHR and CHR have not been",0);
									SetCellValue(newRowNum, "attr_ctnt4",attrCtnt + "(no House B/L)",0);
									break;
								case "M":
									SetCellValue(newRowNum, "attr_ctnt2","AMR and CMR have not been done. AHR and CHR have been",0);
									SetCellValue(newRowNum, "attr_ctnt4",attrCtnt + "(no Master B/L)",0);
									break;
								case "S":
									SetCellValue(newRowNum, "attr_ctnt2","There is vessel information discrepancy between master B/L and house B/L",0);
									SetCellValue(newRowNum, "attr_ctnt4",attrCtnt + "(Discrepancy in Vessel Information)",0);
									break;
								case "T":
									SetCellValue(newRowNum, "attr_ctnt2","Overdue Reporting",0);
									SetCellValue(newRowNum, "attr_ctnt4",(attrCtnt + "(Overdue Reporting)"),0);
									break;
								case "A":
									SetCellValue(newRowNum, "attr_ctnt2","Incomplete Advance Filing",0);
									SetCellValue(newRowNum, "attr_ctnt4",attrCtnt + "(Incomplete Advance Filing)",0);
									break;
								case "D":
									SetCellValue(newRowNum, "attr_ctnt2","ATD has not been done",0);
									SetCellValue(newRowNum, "attr_ctnt4",attrCtnt + "(Incomplete Departure Time Registration)",0);
									break;
							}
						}
					}
					SelectCell(HeaderRows(), "attr_ctnt2");
				}
			}
		} else {
			doActionIBSheet(sheetObjects[0], frmObj, IBSEARCH);
		}
	}


	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : shtObj == > 시트오브젝트, shtNo == > 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(shtObj, shtNo) {
			switch (shtObj.id) {
				case "sheet1":    // 트랜잭션을 위해 사용되는 Dummy Sheet
					with(shtObj){
						  var cnt = 0;
						  document.form.pagerows.value = 500;
						  var HeadTitle = "|Result Code|HBL|BL No.|Relevant|Error Details|Options & Solutions";
						  SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:0 } );
						  var info = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
						  var headers = [ { Text:HeadTitle, Align:"Center"} ];
						  InitHeaders(headers, info);
						  var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",      Wrap:1 },
								 {Type:"Text",     Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"attr_ctnt1",  Wrap:1 },
								 {Type:"Text",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"hbl_div",  Wrap:1 },
								 {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"hbl_no",  Wrap:1 },
								 {Type:"Text",     Hidden:0,  Width:125,  Align:"Center",  ColMerge:0,   SaveName:"attr_ctnt2",  Wrap:1 },
								 {Type:"Text",     Hidden:0,  Width:170,  Align:"Left",    ColMerge:0,   SaveName:"attr_ctnt4",  Wrap:1 },
								 {Type:"Text",     Hidden:0,  Width:170,  Align:"Left",    ColMerge:0,   SaveName:"attr_ctnt5",  Wrap:1 } ];
						  InitColumns(cols);
						  SetEditable(0);
						  SetWaitImageVisible(0);
						  SetSheetHeight(250);
				}
			break;
		}
	}
	// Sheet관련 프로세스 처리
	function doActionIBSheet(shtObj, frmObj, sAction) {
		switch(sAction) {
			case IBSEARCH:    //조회
				if (!ComChkValid(frmObj)) return;
				frmObj.f_cmd.value = SEARCH;
				shtObj.DoSearch("ESM_BKG_1505GS.do", FormQueryString(frmObj) );
				break;
		}
	}
/* 개발자 작업  끝 */
