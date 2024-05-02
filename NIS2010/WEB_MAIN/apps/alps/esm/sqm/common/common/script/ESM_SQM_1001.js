/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_1001.js
*@FileTitle      : Load Excel
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.22
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.22 SQM USER
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends 
 * @class ESM_SQM_1001 : ESM_SQM_1001 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SQM_1001() {
	this.processButtonClick		= tprocessButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.doActionIBSheet 		= doActionIBSheet;
}

/* 개발자 작업	*/
var opener       = window.dialogArguments;
var initSheet    = opener.initSheetFn;

//공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

function processButtonClick(){
	var sheetObj = sheetObjects[0];
	var formObj  = document.form;
	
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		
		switch(srcName) {
			case "btn_LoadExcel":
				doActionIBSheet(sheetObj,formObj,IBLOADEXCEL);
				break;
				
			case "btn_Validation":
				doActionIBSheet(sheetObj,formObj,"Validation");
				break;
				
			case "btn_Apply":
				doActionIBSheet(sheetObj,formObj,"Apply");
				break;
				
			case "btn_Close":
				window.close();
				break;
		}
	} catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(ComGetMsg("COM12111", "", ""));
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * IBSheet Object 를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++] = sheet_obj;
}

function loadPage(){
	var formObj = document.form;
	
	loadingMode = true;
	
	for(i=0;i<sheetObjects.length;i++){
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	ComBtnDisable("btn_Apply");
	
	doActionIBSheet(sheetObjects[0],formObj,IBLOADEXCEL);
	
	loadingMode = false;
}

/**
 * Sheet 관련 프로세스 처리
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	
	switch(sAction) {
		case IBLOADEXCEL:                  // 로드 엑셀
			// Message Reset
			document.form.msg.value = "";
			
			ComBtnDisable("btn_Apply");
			
			// Sheet Reset
			sheetObj.reset();
			
			// Init Sheet
			initSheet(sheetObj,1);
			
			sheetObj.LoadExcel(-1, 1, "", -1, opener.loadExcelRowCnt, "");
			
			if ( opener.ComFuncCheck("setEditColorFn") ) {
				opener.setEditColorFn(sheetObj);
			}
			
			//cell editable 제어
			if ( opener.ComFuncCheck("setEditableCellFn") ) {
				opener.setEditableCellFn(sheetObj);
			}
			break;
			
		case "Validation":                  // 로드 엑셀 Validation
			ComOpenWait(true);
			
			if (ComShowConfirm (ComGetMsg("SQM00033")) != 1) {
				ComOpenWait(false);
				return false;
		    }
			
			loadExcelValidation(sheetObj, formObj);
			ComOpenWait(false);
			break;
			
		case "Apply":                  // 로드 엑셀 Apply
			ComOpenWait(true);
			
			if (ComShowConfirm (ComGetMsg("SQM00034")) != 1) {
				ComOpenWait(false);
				return false;
		    }
			
			loadExcelApply(sheetObj, formObj);
			ComOpenWait(false);
			break;
    }
}

/**
 * LoadExcel Validation
 */	
function loadExcelValidation(cSheetObj, formObj) {
	var pSheetObj = opener.sheetObjects[0];
	var aplyField = opener.loadExcelAplyField;
	var exField   = opener.loadExcelExField;
	var totFlg    = opener.loadExcelTotFlg;
	var screenVal = opener.loadExcelVal;
	var sectorFlg = opener.loadExcelsectorFlg;
	if(typeof(sectorFlg) == "undefined") sectorFlg = "N";
	var passFlg   = "Y";
	
	// Seq 번호별 Sorting
	pSheetObj.ColumnSort("seq", "ASC");		// 부모창 - 호출한 화면
	cSheetObj.ColumnSort("seq", "ASC");		// 자식창 - LoadExcel 화면
    
	// Message 초기화
	formObj.msg.value = "";
	
	var row      = cSheetObj.HeaderRows;
	var col      = 0;
	var lastRow1 = 0;
	var lastRow2 = 0;
	var chkItem1 = "";
	var chkItem2 = "";
	var colName  = "";
	var chk_rslt = true;
	var upd_cnt  = 0;
	var chk_cnt  = 0;
	var chk_cnt2 = 0; // 반영 필드일 지라도 반영제외 되어야 하는 row count
	var chk;
	
	// 공백 삭제
	while ( row <= cSheetObj.lastRow && cSheetObj.CellValue(row, "seq") == "" ) {
		cSheetObj.rowDelete(row, false);
	}
	
	// 정상적인 Seq
	while ( row <= cSheetObj.lastRow && !isNaN(cSheetObj.CellValue(row, "seq")) ) {
		row = row + 1;
	}
	
	lastRow1 = cSheetObj.lastRow;
	lastRow2 = pSheetObj.lastRow;
	
	// 01. 전체 건수 체크
	if ( lastRow1 != lastRow2 ) {
		formObj.msg.value = "Upload Failed:\n"
			              + "Columns and/or rows were added on the template.\n"
			              + "Please remove columns and/or rows you have added before upload.\n"
			              + "====================================================================================\n";
		ComOpenWait(false);
		return;
	}
	
	if ( totFlg ) { 
		lastRow1--;
	}
	
	// 02. 필드 Validation 체크
	for ( row = cSheetObj.HeaderRows; row <= lastRow1; row++ ) {
		
		for ( col = 0; col <= cSheetObj.lastCol; col++ ) {
			chkItem1 = cSheetObj.CellText(row, col);
			chkItem2 = pSheetObj.CellText(row, col);
			colName  = pSheetObj.ColSaveName(col);
			
			if ( chkItem1 != chkItem2 ) {
				// 변경 가능 필드 여부 확인
				if ( colName.toUpperCase() == "IBFLAG" ) {
					// Status 제외
				} else if ( exField.indexOf("|" + colName + "|") != -1 ) {
					// 변경 가능 필드 변경
					if ( aplyField.indexOf("|" + colName + "|") != -1 ) {
						passFlg = "Y";
						
						if(opener.ComFuncCheck("rowExceptionFn")){
							if(screenVal == "N" && colName == "grs_rpb_rev1"){
								if(cSheetObj.CellText(row, col-1) != pSheetObj.CellText(row, col)){
									passFlg = "Y";//변경
									cSheetObj.CellBackColor(row, col-1) = cSheetObj.RgbColor(255, 200, 100);
								}else{
									passFlg = "N";
								}
							}else{									
								if(!opener.rowExceptionFn(cSheetObj,row)){//sqm_cng_tp_cd가 'A'인지 체크
									if(cSheetObj.CellText(row, col-1) != pSheetObj.CellText(row, col))
										passFlg = "A";//sqm_cng_tp_cd가 'A'일때 변경
									else
										passFlg = "N";//sqm_cng_tp_cd가 'A' 변경되지 않음		
								}else{//sqm_cng_tp_cd가 'A'가 아닐 때 
									passFlg = "Y";//변경
										
								}
							}
			
						}
						
						
						
						if(passFlg == "Y"){
							// 반영 필드 변경시에만 Status 변경
							cSheetObj.CellBackColor(row, col) = cSheetObj.RgbColor(255, 200, 100);
							if ( opener.ComFuncCheck("validatesheetFn") ) {
								if(!opener.validatesheetFn(cSheetObj,row,colName)){
									formObj.msg.value = opener.msg;
									ComOpenWait(false);
									return false;
								}
							}
							cSheetObj.CellValue2(row, "ibflag") = "U";
							upd_cnt ++;
						}else if(passFlg == "A"){
							// 변경 불가 필드 변경
							cSheetObj.CellBackColor(row, col) = cSheetObj.RgbColor(255, 200, 200);		// Orange
							chk_cnt2 ++;
						}
					}
				} else {
					// 변경 불가 필드 변경
					cSheetObj.CellBackColor(row, col) = cSheetObj.RgbColor(255, 200, 200);		// Orange
					chk_cnt ++;
				}
			}
		}
	}
    
    // Key Value Checking Message
    if( chk_cnt > 0 ){
    	if(sectorFlg == "Y"){
    		formObj.msg.value = formObj.msg.value
            + "Upload Failed:\n"
            + "Items other than Active were changed.\n"
            + "Please correct other items except Active as they were downloaded.\n"
            + "====================================================================================\n";
    	}else if(sectorFlg == "C"){
	   		 formObj.msg.value = formObj.msg.value
	         + "Upload Failed:\n"
	         + "Items other than CMCB(PA) and CMCB(RA) were changed.\n"
	         + "Please correct items other than CMCB(PA) and CMCB(RA) as they were downloaded.\n"
	         + "====================================================================================\n";
    	}else{
    		 formObj.msg.value = formObj.msg.value
             + "Upload Failed:\n"
             + "Items other than Volume and G.RPB were changed.\n"
             + "Please correct items other than Volume and G.RPB as they were downloaded.\n"
             + "====================================================================================\n";
    	}
    	
    	chk_rslt = false;
    }
    
    if( chk_cnt2 > 0 ){
        formObj.msg.value = formObj.msg.value
                          + "Upload Failed:\n"
                          + "Volume and G.RPB having been changed in (Alloc = Qta) were changed.\n"
                          + "Please correct Volume and G.RPB as they were downloaded.\n"
                          + "====================================================================================\n";
        chk_rslt = false;
    }

    
//    // 기본 적인 validation chack 외에 다른 추가 적인 로직이 존재할경우
//    if( otherChkFlag == "Y" ){
//        var chk_rtn = chkValidation2(cSheetObj, pSheetObj);
//        
//        if(chk_rtn == true){                     // Update 내역이 존재할경우
//            upd_cnt++;
//        } else if(chk_rtn != false) {            // Check 자체가 필요없는 경우 false
//            formObj.msg.value=formObj.msg.value + chk_rtn;
//            chk_rslt = false;
//        }
//    }
    
    // 업데이트 할 건수가 없으면 Save 버튼 비활성 유지
    if ( upd_cnt == 0 ) {
        formObj.msg.value = formObj.msg.value
                          + "There are no contents to update!\n"
                          + "====================================================================================\n";
        chk_rslt = false;
    }
    
    // Validation 완료 후 활성화
    if ( chk_rslt ) {
    	formObj.msg.value = "All items were validated successfully!\n"
    		              + "If you want to save data, click 'Apply' button now!\n"
    		              + "====================================================================================\n";    
    	
    	ComBtnEnable("btn_Apply");
    }
}

/**
 * LoadExcel Apply
 */	
function loadExcelApply(cSheetObj, formObj) {
	var pSheetObj = opener.sheetObjects[0];
	var aplyField = opener.loadExcelAplyField;
	
	var aField = aplyField.substr(1, aplyField.length -2);
	
	cSheetObj.Copy2SheetCol(pSheetObj, aField, aField, -1, -1, -1, 0, true);

	var aplyArr = aplyField.split("|");
	
	var uRows   = cSheetObj.FindStatusRow("U");
	var uRowArr = uRows.split(";");
	
	for ( var i=0; i < uRowArr.length-1; i++ ) {
		pSheetObj.CellValue2(uRowArr[i], "ibflag") = "U";
	}
	window.returnValue = "S";
	window.close();
}
/* 개발자 작업  끝 */