/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0982.js
*@FileTitle  : Internal Remark Popup
*@author     : CHAN WOO PARK
*@version    : 1.0
*@since      : 2015/04/28
=========================================================*/
/**
 * @fileoverview Defining scripts
 * @author author_name
 */
/**
 * @extends Bkg
 * @class ESD_TRS_0982 : 
 */
/*------------------ Defining general java script function   ------------------*/
// General global variable
var sheetObjects=new Array();
var sheetCnt=0;
document.onclick=processButtonClick;
/* Branch processing event handler with the name of button */
function processButtonClick(){
	/***** Adding additional sheet variables to use more than one sheet per a tab *****/
	var sheetObject=sheetObjects[0];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName = ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) {
			return false;
		}
		switch(srcName) {
		case "btn_RowAdd" :
			doActionIBSheet(sheetObject, formObject, IBINSERT);
			break;
		
		case "btn_RowDelete" :
			doActionIBSheet(sheetObject, formObject, IBDELETE);
			break;
		
		case "btn_Save" :
			doActionIBSheet(sheetObject, formObject, IBSAVE);
			break;
			
		case "btn_Close" :
			ComClosePopup();
			break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			errMsg=ComGetMsg("TRS90392" );
			ComShowMessage(errMsg);
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * Register IBSheet Object with array
 */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
* Setting sheets and initialization
* Implementing the onLoad event handler of body tag
* Adding the preceding function after loading page
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	var sheetObject=sheetObjects[0];
	var formObject=document.form;
	
	// 2015.06.03	CHAN WOO PARK
	// S/O Inquiry에서 호출 시 버튼 및 체크박스 비활성화 
	if(formObject.inter_rmk_cd.value == "I") {
		formObject.btn_RowAdd.style.display = "none";
		formObject.btn_RowDelete.style.display = "none";
		formObject.btn_Save.style.display = "none";
	}
	
	// 2015.08.26	CHAN WOO PARK
	// USA Rail에서 호출 시 S/O No, W/O No 칼럼 hidden 처리
	if(formObject.rail_chk.value == "Y") {
		sheetObject.SetColHidden(sheetObject.SaveNameCol("so_no"), 1);
		sheetObject.SetColHidden(sheetObject.SaveNameCol("wo_no"), 1);
	}
	
	doActionIBSheet(sheetObject,formObject,IBSEARCH);
	initControl();
}
/**
      * Loading the event of HTML Control <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     The order number of sheetObjects array
 **/
function initControl() {
}


function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:      //sheet1 : Main
			with(sheetObj){
				var HeadTitle0="||Module|Booking No.|CNTR No.|SO No.|WO No.|User|Date|Remark(s)";
				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle0, Align:"Center"} ];
				InitHeaders(headers, info);
	
				var cols = [ 
				         {Type:"Status",    Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag"},
			             {Type:"CheckBox",  Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk"},
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"inter_rmk_cd",         	KeyField:0,   CalcLogic:"",   Format:"",         	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",            	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Combo",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_no",             	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"so_no",    				KeyField:0,   CalcLogic:"",   Format:"",       		PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"wo_no",    				KeyField:0,   CalcLogic:"",   Format:"",       		PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"usr_id",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Date",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"upd_dt",      			KeyField:0,   CalcLogic:"",   Format:"YmdHm",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",  	ColMerge:1,   SaveName:"inter_rmk",         	KeyField:0,   CalcLogic:"",   Format:"",         	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"inter_rmk_seq",         KeyField:0,   CalcLogic:"",   Format:"",         	PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
			            ];
				
		      	InitColumns(cols);
		      	SetEditable(1);
		      	
		      	// ComboBox setting
		      	var eqnoStr = document.form.eq_no.value;
		      	SetColProperty("eq_no", { ComboText :"|" + eqnoStr, ComboCode : "|" + eqnoStr });
		      	
		        SetRangeBackColor(1, 19, 1, 32,"#555555");
		        SetSheetHeight(ComGetSheetHeight(sheetObj, 10));
		        resizeSheet();
			}
			break;
	}
}

// IBSheet 관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction, srcName) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH:      //Retrieve
			formObj.f_cmd.value=SEARCH;
 			sheetObj.DoSearch("ESD_TRS_0982GS.do", TrsFrmQryString(formObj));
 			break;
 			
		case IBINSERT:
			var row = 0;
			var bkg_no = (formObj.bkg_no.value == null) ? "" : formObj.bkg_no.value;
			var eq_no = (formObj.eq_no.value == null) ? "" : formObj.eq_no.value;
			var so_no = (formObj.so_no.value == null) ? "" : formObj.so_no.value;
			var wo_no = (formObj.wo_no.value == null) ? "" : formObj.wo_no.value;
			var usr_id = formObj.usr_id.value;
			var inter_rmk_cd = (formObj.inter_rmk_cd.value == "B") ? "BKG" : "TRS";
			
			row = sheetObj.DataInsert(-1);
			sheetObj.SetCellValue(row, "chk", 1, 0);	// Set checkBox enabled
			sheetObj.SetCellValue(row, "bkg_no", bkg_no);	// Set current Booking No.
			sheetObj.SetCellValue(row, "eq_no", eq_no);	// Set current Equipment No.
			sheetObj.SetCellValue(row, "so_no", so_no);	// Set current S/O No.
			sheetObj.SetCellValue(row, "wo_no", wo_no);	// Set current W/O No.
			sheetObj.SetCellValue(row, "usr_id", usr_id);	// Set current User Id
			sheetObj.SetCellValue(row, "upd_dt", "");	// Set current Date
			sheetObj.SetCellValue(row, "inter_rmk_cd", inter_rmk_cd);	// Set Internal Remark Code(B : BKG, T : TRS)
			
			// eq_no가 1개 이상이면 SetCellEditable True
			var eq_noArr = eq_no.split("|");
			if (eq_noArr.length > 1) 
				sheetObj.SetCellEditable(row, "eq_no", 1);
			
			// Internal Remark 입력 창 활성화
			formObj.inter_rmk.disabled = false;
			
			// 선택한 row의 Internal Remark를 가져옴
			var inter_rmk = sheetObj.GetCellValue(row, "inter_rmk");
			formObj.inter_rmk.value = inter_rmk;
			
			// 현재 row 정보를 hidden에 저장
			formObj.focus_row.value = row;
			
			break;
		case IBDELETE:
			// 선택된 row가 없을 때 에러메시지 출력
			if(sheetObj.CheckedRows("chk") == 0) {
				ComShowCodeMessage("TRS90386", "No Target Data!");
				return;
	        }
			
			// 선택한 row들 hidden 처리 및 트랜잭션 상태(ibflag) 'D'로 설정
			ComRowHideDelete(sheetObj, "chk");
			
			// 주석 필요
			var formObject = document.form;
			formObject.inter_rmk.value = "";
			formObject.focus_row.value = "";
			formObject.inter_rmk.disabled = true;
			
			break;
		case IBSAVE:
			if (validateForm(sheetObj, formObj)) {
				// 체크되어 있지 않은 Insert row들은 save 전에 삭제
				for (var row = sheetObj.HeaderRows() + sheetObj.RowCount(); row > sheetObj.HeaderRows(); row--) {
					var chk = sheetObj.GetCellValue(row, "chk");
					var status = sheetObj.GetCellValue(row, "ibflag");
					if (status == "I" && chk == 0)
						sheetObj.RowDelete(row, false);
				}
				
				formObj.f_cmd.value=MULTI;
	 			sheetObj.DoSave("ESD_TRS_0982GS.do", TrsFrmQryString(formObj));
			}
			break;
	}
}

/**
 * sheet1 click 시 일어나는 이벤트
 */
function sheet1_OnClick(sheetObj, row, col, value) {
	var colName = sheetObj.ColSaveName(col);

	var sheetObject = sheetObjects[0];
	var formObject = document.form;
	var usr_id_row = sheetObject.GetCellValue(row, "usr_id");
	var usr_id = formObject.usr_id.value;
	
	switch (colName) {
		case "chk":
		case "bkg_no":
		case "eq_no":
		case "so_no":
		case "wo_no":
		case "usr_id":
		case "upd_dt":
		case "inter_rmk":
			// 본인이 입력한 Internal Remark만 수정할 수 있도록 조건 설정
			if (usr_id == usr_id_row && formObject.inter_rmk_cd.value != "I") {
				// Internal Remark 입력 창 활성화
				formObject.inter_rmk.disabled = false;
				
				// 선택한 row의 Internal Remark를 가져옴
				var inter_rmk = sheetObject.GetCellValue(row, "inter_rmk");
				formObject.inter_rmk.value = inter_rmk;
				
				// 현재 row 정보를 hidden에 저장
				formObject.focus_row.value = row;
			} else {
				// 선택한 row의 Internal Remark를 가져옴
				var inter_rmk = sheetObject.GetCellValue(row, "inter_rmk");
				formObject.inter_rmk.value = inter_rmk;
				
				// Internal Remark 창 비활성화
				formObject.inter_rmk.disabled = true;
			}
			break;
	}
}

/**
 * Remark TextArea에서 focus가 벗어났을 때 IBSheet에 remark 내용을 반영하는 함수
 */
function inter_rmk_onBlur() {
	// formObject, sheetObject 선언
	var formObject = document.form;
	var sheetObject = sheetObjects[0];
	
	// 선택된 row의 위치와 internal remark를 가져옴.
	var inter_rmk = formObject.inter_rmk.value;
	var row = formObject.focus_row.value
	
	// 선택된 row에 internal remark를 저장한다.
	sheetObject.SetCellValue(row, sheetObject.SaveNameCol("inter_rmk"), inter_rmk);
	sheetObject.SetCellValue(row, sheetObject.SaveNameCol("chk"), 1);
}

/**
 * Search가 완료된 후 User ID 일치여부에 따라 Chk 활성화/비활성화
 */
function sheet1_OnSearchEnd(sheetObj, errMsg) {
	for(var row = sheetObj.HeaderRows(); row < sheetObj.HeaderRows() + sheetObj.RowCount(); row++) {
		var formObj = document.form;
		var usr_id_row = sheetObj.GetCellValue(row, "usr_id");
		var usr_id = formObj.usr_id.value;
		
		// S/O Inquiry에서 호출 시에는 CheckBox 모두 비활성화
		// 그 외에는 User ID에 따라서 결정
		if (formObj.inter_rmk_cd.value == "I") {
			sheetObj.SetCellEditable(row, "chk", 0);
		} else {
			if (usr_id_row == usr_id) { // User ID 일치 시
				sheetObj.SetCellEditable(row, "chk", 1);	// checkBox 활성화
			} else { // User ID 불일치 시
				sheetObj.SetCellEditable(row, "chk", 0);
			}
		}
	}
	// Internal Remark 입력내용 삭제 및 창 비활성화
	formObj.inter_rmk.value = "";
	formObj.inter_rmk.disabled = true;
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj) {
	// 체크된 row들에 대해 검증
	var chkRows = sheetObj.FindCheckedRow("chk");
	var chkArray = chkRows.split("|");
	
	// Insert나 Update 상태에서 Internal remark가 없을 경우 에러 메시지 출력
	for (var idx = 0; idx < chkArray.length; idx++) {
		var ibflag = sheetObj.GetCellValue(chkArray[idx], "ibflag");
		var inter_rmk = sheetObj.GetCellValue(chkArray[idx], "inter_rmk");
		if (ibflag != "D" && inter_rmk == "") {
			ComShowMessage(ComGetMsg("TRS90428"));
			return false;
		}
	} // end for
	return true;
}

/**
 * handling process after save
 */
function sheet1_OnSaveEnd(sheetObj, ErrMsg){
	// Save 이후 화면 갱신을 위해 Search 수행
	doActionIBSheet(sheetObj, document.form, IBSEARCH);	
}

//UI 표준화관련 하단 여백 설정
function resizeSheet(){
	    ComResizeSheet(sheetObjects[0], 250);
}