/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0133.js
*@FileTitle : EDI Submission (Philips)-Location code
*Open Issues :
*Change history :
*@LastModifyDate : 2012-12-04
*@LastModifier : 9011620
*@LastVersion : 1.0
* 2012.12.04 9011620
* 1.0 Creation
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
	 * @class FNS_INV_0133 : FNS_INV_0133 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function FNS_INV_0133() {
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initControl            = initControl;
	this.doActionIBSheet 		= doActionIBSheet;
	this.validateForm 			= validateForm;
}

// Common variable.
var sheetObjects = new Array();
var sheetCnt = 0;

// IBMultiCombo
var comboObjects = new Array();
var combo1 = null;
var comboCnt = 0;

var cust_cd_input = false;


// Define event handle for button.
document.onclick = processButtonClick;

/** 
 * Selecting logic by button's name.
 */
function processButtonClick(){
	// Selection sheet.
	var sheetObj = sheetObjects[0];
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
		
			case "btn_add":
					doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
                break;
                 
             case "btn_delete":
            	 if(!validateForm(sheetObjects[0],formObj,IBDELETE)) {
     				return false;
     			 }
            	ComRowHideDelete(sheetObjects[0], "del_chk");
            	break;

				
			case "btn_retrieve" :
				
				yuyutyuty
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
				break;
				
			case "btn_save" :
				doActionIBSheet(sheetObj, formObj, IBSAVE);
				break;
				
			case "btn_new" :
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
				break;
			}
	} catch(e) {
		if ( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * Add sheet to array.
 * 
 * @param sheet_obj
 */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Add combo object to array.
 * 
 * @param combo_obj
 */
function setComboObject(combo_obj){
	comboObjects[comboCnt++] = combo_obj;
}

/** 
 * Initialize.
 */
function loadPage() {
	var formObj = document.form;

	for (var i=0; i<sheetObjects.length; i++) {
		// Call initial setting.
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i+1);
		
		// Call latest setting.
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	initControl();
	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);

}

/**
 * Initialize sheet and header.
 * Coding logic by sheet's count.
 * 
 * @param sheetObj
 * @param sheetNo
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	var sheetID = sheetObj.id;

	switch (sheetID) {
	case "sheet1" :
		with (sheetObj) {
			style.height = 350;
			SheetWidth = mainTable.clientWidth;
		
			// Set host information(Request:HostIp, Port, PagePath).
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			// Merge kind(Option:Default msNone).
			MergeSheet = msPrevColumnMerge; //msPrevColumnMerge + msHeaderOnly; or msHeaderOnly;

			// Set use edit(Option:Default false).
			Editable = true;
			sheetObj.EditableColorDiff = false;

			// Set row information(Request:HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=100).
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle = "|Seq|Sel.|Customer code|Customer code|Customer Name|Customer Address|Philps Location Code|Remark";
			var headCount = ComCountHeadTitle(HeadTitle);

			// Set column information(Request:COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false).
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, false, true, true, false,false)

			// Set header row information(Request:ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false).
			InitHeadRow(0, HeadTitle, true);

			var rowCnt = 0;
			
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,  0,    	daCenter,  	false,   "ibflag");
			InitDataProperty(0, cnt++ , dtSeq,  		50,    	daCenter,  	false,   "seq");
			InitDataProperty(0, cnt++ , dtCheckBox,		60,		daCenter,	false,	 "del_chk",				false,	"",	dfNone,		0,	true,		true);
			InitDataProperty(0,	cnt++,	dtData,			40,		daRight,	false,	 "cust_cnt_cd",			false,	"",	dfNone,		0,	false,		true,2,true);
			InitDataProperty(0,	cnt++,	dtData,			60,		daCenter,	false,	 "cust_seq",			false,	"",	dfNone,		0,	false,		true,6,true);
			InitDataProperty(0,	cnt++,	dtData,			400,	daLeft,		false,	 "cust_nm",				false,	"",	dfNone,		0,	false,		false);
			InitDataProperty(0,	cnt++,	dtData,			400,	daLeft,		false,	 "cust_addr",			false,	"",	dfNone,		0,	false,		false);
			InitDataProperty(0, cnt++ , dtData,     	150,    daCenter,  	false,   "phils_loc_cd_ctnt",  	true,  	"", dfNone,		0,	true,		true, 50);
			InitDataProperty(0, cnt++ , dtData,	     	150,    daLeft,  	false,   "phils_loc_cd_rmk", 	false, 	"",	dfNone,		0,	true,		true, 500);
							
			WaitImageVisible = false; 
		}
		break;			
	}
}


/** 
 * Initialize object's event.
 */
function initControl() {
	var formObj = document.form;

	// Catching event.
	axon_event.addListenerFormat("keypress", "obj_keypress", formObj);
//	axon_event.addListenerFormat("focus", "obj_activate", formObj);
//	axon_event.addListenerForm("keyup", "obj_keyup", formObj);
//	axon_event.addListenerForm("blur", "obj_deactivate", formObj);
	axon_event.addListenerForm("change", "obj_onchange", formObj);
}
	
/**
 * On key press.
 */
function obj_keypress() {
	var formObj = document.form;

	switch (event.srcElement.dataformat) {
	case "float" :
		// Only number or '.'.
		ComKeyOnlyNumber(event.srcElement, ".-"); 
		break;
	case "int" :
		// Only number.
		ComKeyOnlyNumber(event.srcElement,"-"); 
		break;
	case "engup" :
		switch (event.srcElement.name) {
		case "retr_input" :
			// Only upper case or number.
			ComKeyOnlyAlphabet('uppernum'); 
			break;
		case "ar_if_no" :
			ComKeyOnlyAlphabet('uppernum'); 
			break;
		case "cust_cnt_cd" :
			// Only upper case.		    	        
			ComKeyOnlyAlphabet('upper');
			break;
		case "port" :		    	        
			ComKeyOnlyAlphabet('upper'); 
			break;
		}
		break;
	default :
		ComKeyOnlyNumber(event.srcElement);
		break;
	}
}

/**
 * Function for retrieve, save.
 * 
 * @param sheetObj
 * @param formObj
 * @param sAction
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;

	switch (sAction) {
	
		
	case IBSEARCH : // Retrieve.
		if (validateForm(sheetObj,formObj,sAction)) {
			
			formObj.f_cmd.value = SEARCH;
			var queryParam =  FormQueryString(formObj);
			
			var sXml = sheetObj.GetSearchXml("FNS_INV_0133GS.do", queryParam);

			var arrXml = sXml.split("|$$|");

			if (sXml.indexOf("ERROR") < 1) {
				if (arrXml[0] != null) {
					sheetObj.LoadSearchXml(arrXml[0]);
					if (sheetObjects[0].RowCount==0) {
						ComShowCodeMessage("COM130401");
					}
				}
			}
			
			cust_cd_input =false;
		}

		break;
		
	case IBSAVE : // save.
		
		if (validateForm(sheetObj,formObj,sAction)) {
		
			formObj.f_cmd.value = MULTI;
			var sParam = FormQueryString(formObj);
			var sParam1 = sheetObj.GetSaveString(true); 				  
	
			if (sParam1 == "") {				
				return; 
			} else {
				sParam1 = ComSetPrifix(sParam1, "sheet1_");
				sParam = sParam + "&" + sParam1;
			}
			

			var sXml = sheetObj.GetSearchXml("FNS_INV_0133GS.do", sParam);
		
			var arrXml = sXml.split("|$$|");
	
			if (sXml.indexOf("ERROR") < 1) {
					
				// 성공했으므로 reload한다.
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			} else {
				ComShowCodeMessage("INV00053");
			}
		}
		
		break;
		
	case IBINSERT : // insert.

		var sheetIdx = sheetObj.DataInsert(-1);

	break;
	
	}
}


/**
 * Checking validation values.
 * 
 * @param sheetObj  
 * @param formObj
 * @param sAction
 * @return boolean
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {

	case IBSAVE : // C,U,D.
		with (formObj) {
				
			//1. Data의 변화가 있는지 체크한다.
			var chkCnt = 0;
			var idx = sheetObj.RowCount;
			var isChanged = false;

			if (!(idx > 0)) {
				ComShowCodeMessage("INV00091");
				return false;
			}
				
			for (var i=1; i<idx+1; i++) {
				if (sheetObj.CellValue(i,"ibflag") =='I' || sheetObj.CellValue(i,"ibflag") == 'U' || sheetObj.CellValue(i,"ibflag") == 'D') {
					isChanged= true;
				}
			}
			
			if (!isChanged) {
				ComShowCodeMessage("INV00091");
				return false;
			}
			
			for (var i=1; i<idx+1; i++) {
				// 2. Cust Nm이 null인지 체크한다.
				if (sheetObj.CellValue(i,"cust_nm").trim() =='') {
					ComShowCodeMessage("INV00054");
					sheetObj.SelectCell(i, 'cust_seq');
					return false;
				}

				// 3. LOC CD가 null 인지 체크한다
				if (sheetObj.CellValue(i,"phils_loc_cd_ctnt").trim() =='') {
					ComShowCodeMessage("INV00004");
					sheetObj.SelectCell(i, 'phils_loc_cd_ctnt');
					return false;
				}
			}
		}
		break;
		
	case IBDELETE:
		if (sheetObj.CheckedRows("del_chk") == 0) {
			ComShowMessage(msgs["INV00025"]);
			return false;
		} else if (sheetObj.CheckedRows("del_chk") > 0) {
			if(!ComShowCodeConfirm("INV00028")) return;
		}
		break;
		
	}
	return true;
}

/**
 * On change in grid.
 * 
 * @param sheetObj
 * @param row
 * @param col
 * @param value
 */
function sheet1_OnChange(sheetObj, row, col, value) {
	var formObj = document.form;
	var colSaveName = sheetObj.ColSaveName(col);

	switch (colSaveName) {

	case "cust_cnt_cd":
		
		sheetObj.cellValue2(row,'cust_cnt_cd') = value.toUpperCase();

		if (sheetObj.cellValue(row,'cust_seq') != "") {
			if(!fn_cust_nm_sheet(sheetObj, row, col)){
				sheetObj.SelectCell(row, 'cust_cnt_cd');
			}
		}
		break;
		
	case "cust_seq":
				
		if (sheetObj.cellValue(row,'cust_cnt_cd') != "") {
			if(!fn_cust_nm_sheet(sheetObj, row, col)){
				sheetObj.SelectCell(row, 'cust_seq');
			}
		}
		
		break;
	default :
		break;
	}
}
 
 /**
  * On blur in grid.
  * 
  * @param sheetObj
  * @param row
  * @param col
  * @param value
  */
 function sheet1_OnBlur(sheetObj, row, col, value) {
	 var formObj = document.form;
	 var colSaveName = sheetObj.ColSaveName(col);
	 
	 switch (colSaveName) {
	 
	 case "cust_cnt_cd":
		 
		 sheetObj.cellValue2(row,'cust_cnt_cd') = value.toUpperCase();
		 break;
	 default :
		 break;
	 }
 }


 /**
  * Retrieve customer's name.
  */
 function fn_cust_nm_sheet(sheetObj,row,col) {
	 document.form.f_cmd.value = SEARCH03;
	 var cust_cnt_cd = sheetObj.CellValue(row,'cust_cnt_cd');
	 var cust_seq = sheetObj.CellValue(row,'cust_seq');
	 var cust_nm= "";
	 var cust_addr = "";
	 
	 if (cust_cnt_cd.trim()!="" && cust_seq.trim()!="") {
		 cust_seq = ComLpad(cust_seq.trim(), 6, "0");		
		 sheetObj.CellValue2(row,'cust_seq') = cust_seq;

		 // 중복 체크를한다.
		 var idx = sheetObj.RowCount;
		 for (var i =1;i<idx+1;i++) {
			 var custCntCdTmp = sheetObj.CellValue(i,'cust_cnt_cd');
			 var custSeqTmp = sheetObj.CellValue(i,'cust_seq');
			 if ( i != row && cust_cnt_cd == custCntCdTmp && cust_seq == custSeqTmp) {
				 sheetObj.CellValue2(row,'cust_nm') = "";
				 ComShowCodeMessage("INV00034");
				 return false;
			 }
		 }
		 
		 var queryParam = 	"f_cmd=103&cust_cnt_cd="+cust_cnt_cd+"&cust_seq="+cust_seq;
		 var sXml = sheetObjects[0].GetSearchXml("INVCommonGS.do", queryParam);
		 
		 cust_nm = ComGetEtcData(sXml,"cust_eng_nm");
		 cust_addr = ComGetEtcData(sXml,"locl_addr");
		 
		 if (cust_nm == undefined) {
			 sheetObj.CellValue2(row,'cust_nm') = "";
			 ComShowCodeMessage("INV00008");
			 return false;
		 } else {
			 sheetObj.CellValue2(row,'cust_nm') = cust_nm;
			 sheetObj.CellValue2(row,'cust_addr') = cust_addr;
			 return true;
		 }
	 }
 }
 

/* 개발자 작업  끝 */