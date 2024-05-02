/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_1001.js
*@FileTitle  : Load Excel
*@author     : CLT
*@version    : 1.0
*@since      : 2015/02/10
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends 
 * @class ESM_CSQ_1001 : ESM_CSQ_1001 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
/* 개발자 작업	*/
var opener=window.dialogArguments;
//공통전역변수
var sheetObjects=new Array();
var sheetCnt=0;
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
function processButtonClick(){
	var sheetObj=sheetObjects[0];
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
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
				ComClosePopup(); 
				break;
		}
	} catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(ComGetMsg("COM12111", "", ""));
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * IBSheet Object 를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++]=sheet_obj;
}
function loadPage(){
	var formObj=document.form;
	loadingMode=true;
	var opener = window.dialogArguments;
	if (!opener) opener=window.opener;
	if (!opener) opener = parent;
	
	for(i=0;i<sheetObjects.length;i++){
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		if(opener.loadExcelPageNumber == 0202){
			initSheet(0202); 
		}else if(opener.loadExcelPageNumber == 0204){
			initSheet(0204); 
		}else{
			opener.initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
		}
		ComEndConfigSheet(sheetObjects[i]);
	}
	ComBtnDisable("btn_Apply");
	ComBtnDisable("btn_Validation");
	loadingMode=false;
}
/**
 * Sheet 관련 프로세스 처리
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	var opener = window.dialogArguments;
	if (!opener) opener=window.opener;
	if (!opener) opener = parent;
	switch(sAction) {
		case IBLOADEXCEL:                  // 로드 엑셀
			// Message Reset
			document.form.msg.value="";
			ComBtnDisable("btn_Apply");
			var cnt = opener.loadExcelRowCnt;
			sheetObj.LoadExcel({ Mode:"HeaderMatch",WorkSheetNo:"1",StartRow:"1",EndRow:0,WorkSheetName:""});
			break;
		case "Validation":                  // 로드 엑셀 Validation
			ComOpenWait(true);
			if (ComShowConfirm (ComGetMsg("CSQ00033")) != 1) {
				ComOpenWait(false);
				return false;
		    }
			loadExcelValidation(sheetObj, formObj);
			ComOpenWait(false);
			break;
		case "Apply":                  // 로드 엑셀 Apply
			ComOpenWait(true);
			if (ComShowConfirm (ComGetMsg("CSQ00034")) != 1) {
				ComOpenWait(false);
				return false;
		    }
			loadExcelApply(sheetObj, formObj);
			ComOpenWait(false);
			break;
    }
}

function sheet1_OnLoadExcel(result) {
	var sheetObj=sheetObjects[0];
	var opener = window.dialogArguments;
	if (!opener) opener=window.opener;
	if (!opener) opener = parent;
	//load excel 성공했을경우
	if(result) {
		//Validation 버튼 활성화
		ComBtnEnable("btn_Validation");
		var totFlg = opener.loadExcelTotFlg;
		//TOTAL Row가 있으면
		if(totFlg){
			//Load된 데이터 Row에 TOTAL Row가 있으면 로우 삭제
			var totRow = sheetObj.FindText("bse_yr", "TOTAL");
			if(totRow != -1){
				sheetObj.RowDelete(totRow, 0);
			}
			//부모창에 setSumText가 있는지 확인 후 있으면 태움
			if(opener.ComFuncCheck("setSumText")){
				opener.setSumText(sheetObj);
			}
		}
	} 
	
	if(opener.loadExcelPageNumber == 0202 || opener.loadExcelPageNumber == 0204){
		for(i=1; i<sheet1.LastRow()+1; i++){
			if(sheet1.GetCellValue(i, "csq_act_flg") == 'Y'){
				sheet1.SetCellValue(i, "csq_act_flg",1);
			}else{
				sheet1.SetCellValue(i, "csq_act_flg",0);
			}
			
			if(sheet1.GetCellValue(i, "csq_mn_sctr_flg") == 'Y'){
				sheet1.SetCellValue(i, "csq_mn_sctr_flg",1);
			}else{
				sheet1.SetCellValue(i, "csq_mn_sctr_flg",0);
			}
			
			sheet1.InitCellProperty(i, "csq_act_flg", {Type:"CheckBox"});
			sheet1.InitCellProperty(i, "csq_mn_sctr_flg", {Type:"CheckBox"});
		}
	} // the end of the if clause
}

/**
 * LoadExcel Validation
 */	
function loadExcelValidation(cSheetObj, formObj) {
	var opener = window.dialogArguments;
	if (!opener) opener=window.opener;
	if (!opener) opener = parent;

	//0055화면에서 조회시 initsheet를 타면서 sheetObjects[0]을 잃어버리기 때문에 opener.sheetObjects[0] 대신에 opener.sheet1를 써줌
	//Load Excel을 사용하는 모든 화면의 시트 이름이 sheet1로 지정되어있음. 만약 시트 이름을 바꾸게 되면 해당화면은 Load Excel 불가능. -> 시트이름은 항상 sheet1로 유지해야함.
//	var pSheetObj	=opener.sheetObjects[0];
	var pSheetObj	=opener.sheet1;

	var aplyField	=opener.loadExcelAplyField;
	var exField		=opener.loadExcelExField;
	var screenVal	=opener.loadExcelVal;
	var sectorFlg	=opener.loadExcelsectorFlg;
	if(typeof(sectorFlg) == "undefined") sectorFlg="N";
	var passFlg="Y";
	
	// Seq 번호별 Sorting
	pSheetObj.ColumnSort("seq", "ASC");		// 부모창 - 호출한 화면
	cSheetObj.ColumnSort("seq", "ASC");		// 자식창 - LoadExcel 화면
	
	// Message 초기화
	formObj.msg.value="";
	
	var row=cSheetObj.HeaderRows();
	var col=0;
	var lastRow1=0;
	var lastRow2=0;
	var chkItem1="";
	var chkItem2="";
	var colName="";
	var chk_rslt=true;
	var upd_cnt=0;
	var chk_cnt=0;
	var chk_cnt2=0; // 반영 필드일 지라도 반영제외 되어야 하는 row count
	var chk;
	
	// 공백 삭제
	while ( row <= cSheetObj.LastRow() && cSheetObj.GetCellValue(row, "seq") == "" ) {
		cSheetObj.rowDelete(row, false);
	}
	// 정상적인 Seq
	while ( row <= cSheetObj.LastRow() && !isNaN(cSheetObj.GetCellValue(row, "seq")) ) {
		row=row + 1;
	}
	
	lastRow1=cSheetObj.RowCount();
	lastRow2=pSheetObj.RowCount();
	// 01. 전체 건수 체크
	if ( lastRow1 != lastRow2 ) {
		formObj.msg.value="Upload Failed:\n"
			              + "Columns and/or rows were added on the template.\n"
			              + "Please remove columns and/or rows you have added before upload.\n"
			              + "====================================================================================\n";
		ComOpenWait(false);
		return;
	}
	// 02. 필드 Validation 체크
	for ( row=cSheetObj.HeaderRows(); row < lastRow1+cSheetObj.HeaderRows(); row++ ) {
		for ( col=0; col <= cSheetObj.LastCol(); col++ ) {
			chkItem1=cSheetObj.GetCellText(row, col);
			chkItem2=pSheetObj.GetCellText(row, col);
			colName=pSheetObj.ColSaveName(col);
			
			if ( chkItem1 != chkItem2 ) {
				// 변경 가능 필드 여부 확인
				if ( colName.toUpperCase() == "IBFLAG" ) {
					// Status 제외
				} else if ( exField.indexOf("|" + colName + "|") != -1 ) {
					// 변경 가능 필드 변경
					if ( aplyField.indexOf("|" + colName + "|") != -1 ) {
						passFlg="Y";
						//rowExceptionFn 0055,0220 화면만 있음(QTA Edit화면)
						if(opener.ComFuncCheck("rowExceptionFn")){
							if(!opener.rowExceptionFn(cSheetObj,row)){//csq_cng_tp_cd가 'A'인지 체크
								if(cSheetObj.GetCellText(row, col) != pSheetObj.GetCellText(row, col)){
									passFlg="A";//csq_cng_tp_cd가 'A'일때 변경
								}else{
									passFlg="Y";//csq_cng_tp_cd가 'A' 변경되지 않음
								}	
							}else{//csq_cng_tp_cd가 'A'가 아닐 때 
								passFlg="Y";//변경
							}
						}
						if(passFlg == "Y"){
							// 반영 필드 변경시에만 Status 변경
							cSheetObj.SetCellBackColor(row, col,"#FFC864");
							//validatesheetFn 0021, 0024,0027, 0030 화면만 있음(QTA Set up by H/O, RHQ 화면)
							if ( opener.ComFuncCheck("validatesheetFn") ) {
								if(!opener.validatesheetFn(cSheetObj,row,colName)){
									formObj.msg.value=opener.msg;
									ComOpenWait(false);
									return false;
								}
							}
							cSheetObj.SetCellValue(row, "ibflag","U",0);
							upd_cnt ++;
						}else if(passFlg == "A"){
							// 변경 불가 필드 변경
							cSheetObj.SetCellBackColor(row, col,"#FFC8C8");// pink
							chk_cnt2 ++;
						}
					}
				} else {
					// 변경 불가 필드 변경
					cSheetObj.SetCellBackColor(row, col,"#FFC8C8");// pink
					chk_cnt ++;
				}
			}
		}
	}
    // Key Value Checking Message
    if( chk_cnt > 0 ){
    	if(sectorFlg == "Y"){
    		formObj.msg.value=formObj.msg.value
            + "Upload Failed:\n"
            + "Items other than Active were changed.\n"
            + "Please correct other items except Active as they were downloaded.\n"
            + "====================================================================================\n";
    	}else if(sectorFlg == "C"){
	   		 formObj.msg.value=formObj.msg.value
	         + "Upload Failed:\n"
	         + "Items other than CMCB(PA) and CMCB(RA) were changed.\n"
	         + "Please correct other items except CMCB(PA) and CMCB(RA) as they were downloaded.\n"
	         + "====================================================================================\n";
    	}else{
    		 formObj.msg.value=formObj.msg.value
             + "Upload Failed:\n"
             + "Items other than Load and G.RPB were changed.\n"
             + "Please correct other items except Volume and G.RPB as they were downloaded.\n"
             + "====================================================================================\n";
    	}
    	chk_rslt=false;
    }
    if( chk_cnt2 > 0 ){
        formObj.msg.value=formObj.msg.value
                          + "Upload Failed:\n"
                          + "Volume and G.RPB having been changed in (Alloc=Qta) were changed.\n"
                          + "Please correct Volume and G.RPB as they were downloaded.\n"
                          + "====================================================================================\n";
        chk_rslt=false;
    }
    // 업데이트 할 건수가 없으면 Save 버튼 비활성 유지
    if ( upd_cnt == 0 ) {
        formObj.msg.value=formObj.msg.value
                          + "There are no contents to update!\n"
                          + "====================================================================================\n";
        chk_rslt=false;
    }
    // Validation 완료 후 활성화
    if ( chk_rslt ) {
    	formObj.msg.value="All items were validated successfully!\n"
    		              + "If you want to save data, click 'Apply' button now!\n"
    		              + "====================================================================================\n";    
    	ComBtnEnable("btn_Apply");
    }
}
/**
 * LoadExcel Apply
 */	
function loadExcelApply(cSheetObj, formObj) {
	var opener = window.dialogArguments;
	if (!opener) opener	= window.opener;
	if (!opener) opener = parent;
	
//	var pSheetObj	= opener.sheetObjects[0];
	var pSheetObj	= opener.sheet1;
	var aplyField	= opener.loadExcelAplyField;
	var aField		= aplyField.substr(1, aplyField.length -2);
	cSheetObj.Copy2SheetCol(pSheetObj, aField, aField, -1, -1, -1, 0, true);
	ComClosePopup(); 
}


function initSheet(pageNumber) {
	var cnt=0;
	switch(pageNumber) {
		case 0202:		//sheet1 init
		    with(sheet1){
	        var HeadTitle1="STS|SEQ|Trade|Sub Trade|R.Lane|Lane Bound|POL|POD|Active|sctr_ofc_cre_flg|Main|";
	        SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:0 } );
	        var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);
	        var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Seq",       Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rlane_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"dir_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"pol_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"pod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",  	Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"csq_act_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"sctr_ofc_cre_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",  	Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"csq_mn_sctr_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"",  					KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
	      InitColumns(cols);
	      SetEditable(1);
	      SetSheetHeight(400);
	            }
			break;
		case 0204:		//sheet2 init
			with(sheetObj){
	        var HeadTitle1="STS|SEQ|Year|Quarter|Office View|Trade|Sub Trade|R.Lane|Lane Bound|RHQ|Office|POL|POD|Active|Main|";
	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	        var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);
	      	var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bse_yr",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bse_qtr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ofc_vw_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rhq_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rgn_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",  Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"csq_act_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",  Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"csq_mn_sctr_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
	      	InitColumns(cols);
	      	SetEditable(1);
	      	SetSheetHeight(400);
            	}
			break;
	}
}

/* 개발자 작업  끝 */