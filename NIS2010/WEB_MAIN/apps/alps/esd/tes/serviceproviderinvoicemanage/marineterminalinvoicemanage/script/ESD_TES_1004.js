/**
 * @fileoverview Off-Dock CY Invoice Revised Volume TP Input (Auto) 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author SM LINE
 */

/**
 * @extends Tes
 * @class ESD_TES_1004 : Off-Dock CY Invoice Revised Volume TP Input (Auto) 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESD_TES_1004() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.setComboObject = setComboObject;
	this.setTabObject = setTabObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.initTab = initTab;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm;
}

// 공통전역변수
var sheetObjects = new Array();
var opener_obj = window.dialogArguments;
var sheetCnt = 0;
var opener_obj;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 * @return
 */
function processButtonClick(){
    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    var sheetObj = sheetObjects[0];

    var formObject = document.form;

    try {
    	var srcName = window.event.srcElement.getAttribute("name");

    	switch(srcName) {
    		case "btng_rowadd":
    	        if (ComGetObjValue(formObject.isExcel) == "Y") return false;
	            doActionIBSheet(sheetObj,formObject,IBINSERT);
	            break;

   	    	case "btng_rowdel":
   	    		if (ComGetObjValue(formObject.isExcel) == "Y") return false;
	            doActionIBSheet(sheetObj,formObject,IBDELETE);
	            break;

    	    case "btng_loadexcel":
    	    	
    	    	for( var row=sheetObj.RowCount; sheetObj.RowCount > 0, row>=1; row-- ){
    	    		
    	 			if ( sheetObj.CellValue(row, "from_where")!=null && sheetObj.CellValue(row, "from_where") !='' && sheetObj.CellValue(row, "from_where").trim() == 'DB') {
    	 				sheetObj.RowStatus(row) = 'D';
    	 				sheetObj.RowHidden(row) = true;
    	 			} else {
    	 				sheetObj.RowDelete(row, false);
    	 			}
        		 	
    	    	}
    	    	
    	    	doActionIBSheet(sheetObj,formObject,IBLOADEXCEL);
    	    	break;
           
           case "btn_new":
        	   doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
               break;
           case "btn_save":
        	   doActionIBSheet(sheetObj,formObject,IBSAVE);
               break;
           case "btn_close":
               window.close();
               break;
               
       } // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(ComGetMsg('TES23028')); //ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 * @param {ibsheet} 	sheet_obj 	IBSheet Object
 * @return     
 */    
function setSheetObject(sheet_obj){
  sheetObjects[sheetCnt++] = sheet_obj;
}
 
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 * @return
 */
function loadPage() {

	for(i=0;i<sheetObjects.length;i++){
	    ComConfigSheet(sheetObjects[i]);
	    initSheet(sheetObjects[i],i+1);
	    ComEndConfigSheet(sheetObjects[i]);
	}
	
	var curr_cd = document.form.curr_cd.value;
	if (curr_cd != undefined && tes_isNoDecimalPointCurrCD(curr_cd)) {
		sheetObjects[0].InitDataProperty(0, 11, dtData,      70,    daRight,  false,    "fuel_rt",     	false,           "",       dfInteger,    0,     true,       true);
	} else {
		sheetObjects[0].InitDataProperty(0, 11, dtData,      70,    daRight,  false,    "fuel_rt",     	false,           "",       dfFloat,    2,     true,       true);
	}
	
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
}
 
	/**
  * 시트 초기설정값, 헤더 정의
  * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
  * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 * @param sheetObj
	 * @param sheetNo
	 * @return
	 */
	function initSheet(sheetObj,sheetNo) {

		var cnt = 0;

		switch(sheetNo) {
		 case 1:      //sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = 240;
									
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(19, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false, false);

				var HeadTitle = "STS|FROM_WHERE|TML_SO_OFC_CTY_CD|TML_SO_SEQ|TML_SO_DTL_SEQ|M.G.Set No.|Yard|Fueling Date|Current Running Hours|Fuel Q'ty (Gallon)|Currency|Fuel Rate|Fuel Amount|Labor Amount|Total Amount (USD)|Chassis No.|Reefer Container No.|W/O No.|exist";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus,     30,    daCenter,  false,    "ibflag");
				InitDataProperty(0, cnt++, dtHidden,    100,    daCenter,  false,    "from_where", false,           "",       dfNone,    0,     false, 	false);
				InitDataProperty(0, cnt++, dtHidden,    100,    daCenter,  false,    "tml_so_ofc_cty_cd", false,           "",       dfNone,    0,     false, 	false);
				InitDataProperty(0, cnt++, dtHidden,    100,    daCenter,  false,    "tml_so_seq",     	false,           "",       dfNone,    0,     false, 	false);
				InitDataProperty(0, cnt++, dtHidden,    100,    daCenter,  false,    "tml_so_dtl_seq",	false,           "",       dfNone,    0,     false, 	false);
				InitDataProperty(0, cnt++, dtData,      100,    daCenter,  false,    "mgst_no",     	 true,           "",       dfEngUpKey,    0,     false,       true, 10);
				InitDataProperty(0, cnt++, dtData,     60,    daCenter,  false,    "yd_cd",       	false,           "",       dfNone,    0,     false,       false);
				InitDataProperty(0, cnt++, dtData,      80,    daCenter,  false,    "fuel_dt",     	false,           "",       dfDateYmd,    0,     true,       true);
				InitDataProperty(0, cnt++, dtData,      150,    daRight,  false,    "mgst_run_hrs",	false,           "",       dfInteger,    0,     true,       true);
				InitDataProperty(0, cnt++, dtData,      120,    daRight,  false,    "fuel_qty",       	false,           "",       dfFloat,    1,     true,       true);
				InitDataProperty(0, cnt++, dtData,     70,    daCenter,  false,    "curr_cd",       	false,           "",       dfNone,    0,     false,       false);
				InitDataProperty(0, cnt++, dtData,      70,    daRight,  false,    "fuel_rt",     	false,           "",       dfFloat,    2,     true,       true);
				InitDataProperty(0, cnt++, dtData,      90,    daRight,  false,    "fuel_amt",      	false,           "",       dfFloat,    2,     false,       false);
				InitDataProperty(0, cnt++, dtData,      100,    daRight,  false,    "lbr_amt",       	false,           "",       dfFloat,    1,     true,       true);
				InitDataProperty(0, cnt++, dtData,      130,    daRight,  false,    "ttl_amt",       	false,           "",       dfFloat,    2,     false,       false);
				InitDataProperty(0, cnt++, dtData,      80,    daCenter,  false,    "chss_no",       	false,           "",       dfNone,    0,     true,       true);
				InitDataProperty(0, cnt++, dtData,      130,    daCenter,  false,    "rf_cntr_no",    	false,           "",       dfNone,    0,     true,       true);
				InitDataProperty(0, cnt++, dtData,      60,    daCenter,  false,    "wo_no",       	false,           "",       dfNone,    0,     true,       true);
				InitDataProperty(0, cnt++, dtHidden,      60,    daCenter,  false,    "exist",       	false,           "",       dfNone,    0,     true,       true);

		   }
			break;
		}
	}
	
 /**
  * Sheet 관련 프로세스 처리
  * @param {ibsheet} 	sheetObj 	IBSheet Object
  * @param {form} 		formObj		Form Object
  * @param {int}		sAction		실행할 액션 구분 값
  * @return
  */
 function doActionIBSheet(sheetObj,formObj,sAction) {
	 sheetObj.ShowDebugMsg = false;
	 switch(sAction) {
	 	case IBSEARCH:
	 		formObj.f_cmd.value = SEARCH;
	 		sheetObj.DoSearch4Post("ESD_TES_1004Popup.do", tesFrmQryStr(formObj));
	 		break;

	 	case IBSAVE: 
	 		
	 		if (sheetObj.RowCount > 0 && sheetObj.IsDataModified){
				checkEmptyDup(sheetObj, IBSAVE);
			} else {
				ComShowMessage(ComGetMsg('TES40056')); //ComShowMessage('저장할 data가 없습니다.'); 
				return false;
			}
	 		
	 		break;	
	 		
	 	case IBINSERT:		//Add Row
			var Row = sheetObj.DataInsert();	 	
			sheetObj.CellValue2(Row,"tml_so_ofc_cty_cd") = formObj.tml_so_ofc_cty_cd.value;
			sheetObj.CellValue2(Row,"tml_so_seq") = formObj.tml_so_seq.value;
			sheetObj.CellValue2(Row,"tml_so_dtl_seq") = formObj.tml_so_dtl_seq.value; 
			sheetObj.CellValue2(Row,"from_where") = "";
			sheetObj.CellValue2(Row,"curr_cd") = formObj.curr_cd.value; 
			sheetObj.CellValue2(Row,"yd_cd") = formObj.yd_cd.value; 
			break;
	
	 	case IBDELETE:		//Delete Row
		 	if (sheetObj.RowCount > 0) {
		 		var Row = sheetObj.SelectRow;
	 			if (sheetObj.CellValue(Row, "from_where") == null
	 					|| sheetObj.CellValue(Row, "from_where").trim() == ''
	 						|| sheetObj.CellValue(Row, "from_where").trim() != 'DB') {
	 				sheetObj.RowDelete(Row, false);
	 			} else {
	 				sheetObj.RowStatus(Row) = 'D';
	 				sheetObj.RowHidden(Row) = true;
	 			}
		 	}
	 		break;
	
	 	case IBLOADEXCEL:
	 		
	 		sheetObj.LoadExcel(-1); // false -> 엑셀로부터 무조건 읽어오기
	 		
	 		for( var row=1; row<=sheetObj.RowCount; row++ ){
	 			if(sheetObj.CellValue(row,"curr_cd") != formObj.curr_cd.value){
	 				//ComShowMessage(formObj.curr_cd.value);
	 				ComShowMessage("invalide curr_cd...");
	 				sheetObj.RemoveAll();
	 				break;
	 			}else if(sheetObj.CellValue(row,"yd_cd") != formObj.yd_cd.value){
	 				//ComShowMessage(formObj.yd_cd.value);
	 				ComShowMessage("invalide yd_cd...");
	 				sheetObj.RemoveAll();
	 				break;
	 			}
	 			
	 			if( sheetObj.CellValue(row,"tml_so_ofc_cty_cd") =="" 
	 						|| sheetObj.CellValue(row,"tml_so_seq") ==""
	 						|| sheetObj.CellValue(row,"tml_so_dtl_seq") =="" ){
	 				sheetObj.CellValue2(row,"tml_so_ofc_cty_cd") = formObj.tml_so_ofc_cty_cd.value;
	 				sheetObj.CellValue2(row,"tml_so_seq") = formObj.tml_so_seq.value;
	 				sheetObj.CellValue2(row,"tml_so_dtl_seq") = formObj.tml_so_dtl_seq.value; 	 	 				
	 			}
	 		}		
	 		
	 		break; 		
	 }
 }
  
/**
 * 
 * @param {ibsheet} sheetObj 	IBSheet Object
 * @param {int}		row			selected row
 * @param {int}		col			selected column
 * @return
 */
function sheet1_OnPopupClick(sheetObj, row, col) {
	 
	if (sheetObj.ColSaveName(col) == "yd_cd") {
		
		var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; // com_ens_051_dispaly.value;
		var classId = "COM_ENS_061";
		var param = '?classId=' + classId;
		var chkStr = dispaly.substring(0, 3);
		
		// radio PopUp
		if (chkStr == "1,0") {
			ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 770, 480, 'getYard', dispaly, true);
		} else {
			ComShowMessage(ComGetMsg('TES21906')); // ComShowMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
		return;
		}		
		
	} else if (sheetObj.ColSaveName(col) == "curr_cd") {
		
		var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; // com_ens_051_dispaly.value;
		var classId = "COM_ENS_N13";
		var param = '?classId=' + classId+"&cnt_cd=&curr_cd=&curr_desc=";
		var chkStr = dispaly.substring(0, 3);
		
		// radio PopUp
		if (chkStr == "1,0") {
			ComOpenPopup('/hanjin/COM_ENS_N13.do' + param, 770, 480, 'getCurrCd', dispaly, true);
		} else {
			ComShowMessage(ComGetMsg('TES21906')); // ComShowMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
		return;
		}				
	}

	
}  

/**
* yard name 설정
* @param {array}	rowArray	yard 관련 정보가 담겨있는 배열
* @return
*/
function getYard(rowArray) {
	var colArray = rowArray[0];
	sheetObjects[0].CellValue2( sheetObjects[0].SelectRow , "yd_cd" ) = colArray[3];
}

/**
* currency 설정
* @param {array}	rowArray	currency 관련 정보가 담겨있는 배열
* @return
*/
function getCurrCd(rowArray) {
	var colArray = rowArray[0];
	sheetObjects[0].CellValue2( sheetObjects[0].SelectRow , "curr_cd" ) = colArray[2];
}

/**
 * sheet 데이터 변경 시 발생하는 이벤트
 * @param {sheet}	sheetObj	ibsheet
 * @param {int}		row			해당 셀의 Row Index
 * @param {int}		col			해당 셀의 Column Index
 * @param {string}	Value		변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
 * @return
 */  
function sheet1_OnChange(sheetObj, row, col, Value) {
	 	 
	var sName = sheetObj.ColSaveName(col);
	
	if( sName!=null && sName!='' ){
		
		if(sName=="fuel_qty"||sName=="fuel_rt"){
			sheetObj.CellValue2(row, "fuel_amt") = sheetObj.CellValue(row, "fuel_qty")*sheetObj.CellValue(row, "fuel_rt");
			sheetObj.CellValue2(row, "ttl_amt") = parseFloat(sheetObj.CellValue(row, "fuel_amt"), 10) 
												+ parseFloat(sheetObj.CellValue(row, "lbr_amt"), 10);
		}
		
		if(sName=="lbr_amt"){
			sheetObj.CellValue2(row, "ttl_amt") = parseFloat(sheetObj.CellValue(row, "fuel_amt"), 10) 
			+ parseFloat(sheetObj.CellValue(row, "lbr_amt"), 10);
		}

		if(sName=="mgst_no"||sName=="chss_no"||sName=="rf_cntr_no"||sName=="fuel_rt"){
			if(sName=="mgst_no"){
				sheetObj.CellValue2(row, "mgst_no") = ComGetMaskedValue(sheetObj.CellValue(row, "mgst_no"), "engup" );
			}
			checkEmptyDup(sheetObj, '');
		}
		
	}
	
}
 
	
	
/**
 * 데이터 유효성 체크
 * M.G.Set No|EQ_TPSZ_CD--M.G.Set No|EQ_TPSZ_CD... (CRLG120914|CLG--FVGS275502|UMG)
 * EQ_TPSZ_CD - CLG - Reefer Container No., UMG - Chassis No.
 * @return
 */ 
function setMGSetNo(){
	var sMgstNo = document.form.tmp_mgst_no_result.value;
	
	var arrMgsts = sMgstNo.split('--');
	
	var arrMgSetNo = new Array();
	var arrEqTpSzCd = new Array();
	
	var tmp_validation = 0;
	
	for( var i=0; i<arrMgsts.length; i++ ){
		var arrMgst = arrMgsts[i].split('|');	//arrMgst[0] : MGSet No, arrMgst[1] : EQ_TPSZ_CD
		arrMgSetNo[i] = arrMgst[0];
		arrEqTpSzCd[i] = arrMgst[1];
	}
		
	for( var row=1; row<=sheetObjects[0].RowCount; row++ ){
		if( sheetObjects[0].CellValue(row, 'ibflag') != 'D' ){
			
			for( var i=0; i<arrMgSetNo.length; i++ ){
				if( sheetObjects[0].CellValue(row, "mgst_no") == arrMgSetNo[i] ){		
					
					sheetObjects[0].CellValue2(row, "exist") = "Y";
					
					if( arrEqTpSzCd[i] == 'CLG' && sheetObjects[0].CellValue(row, "chss_no") != ""){
						tmp_validation++;
						sheetObjects[0].RowFontColor(row) = sheetObjects[0].RgbColor(255,0,0);
					} else if( arrEqTpSzCd[i] == 'UMG' && sheetObjects[0].CellValue(row, "rf_cntr_no") != ""){
						tmp_validation++;
						sheetObjects[0].RowFontColor(row) = sheetObjects[0].RgbColor(255,0,0);
					} else {
						sheetObjects[0].RowFontColor(row) = sheetObjects[0].RgbColor(0,0,0);
					}
				}
			}
			
		}		
	}
	
	for( var row=1; row<=sheetObjects[0].RowCount; row++ ){
		if( sheetObjects[0].CellValue(row, "ibflag") != 'D' && sheetObjects[0].CellValue(row, "exist") != "Y" ){
			tmp_validation++;
			sheetObjects[0].RowFontColor(row) = sheetObjects[0].RgbColor(255,0,0);			
		}
	}
		
	if( tmp_validation > 0 ){
		if( document.form.isExcel.value == 'Y') ComShowMessage(ComGetMsg('TES23055', tmp_validation));
		else ComShowMessage(ComGetMsg('TES60105', tmp_validation));
		return false;
	}
	
	return true;
}

 /**
  * setMGSetNo 실행 후 정상이면 저장한다.
  * @return
  */
function saveMGSetNo(){
	if( setMGSetNo() ){
		document.form.f_cmd.value = MULTI;
		var param = sheetObjects[0].GetSaveString(false,false);
		if( param !=null && param != "" ){								
			var savexml = sheetObjects[0].GetSaveXml("ESD_TES_1004Popup.do", param+'&'+tesFrmQryStr(document.form));
			sheetObjects[0].LoadSaveXml(savexml,true);
		}
	}
}
 
/**
 * Excel 로드 완료 후 실행
 * @return
 */
 function sheet1_OnLoadExcel(sheetObj){
	checkEmptyDup(sheetObj, IBLOADEXCEL);
	sheetObj.Editable = false;
	ComSetObjValue(document.form.isExcel, "Y");
}
 
 /**
  * 
  * @param {ibsheet} 	sheetObj 	IBSheet Object
  * @param {int}		sAction		실행할 액션 구분 값
  * @return
  */
 function checkEmptyDup(sheetObj, sAction){
	var methodName='';
	if (sheetObj.RowCount > 0){		
		
		//mgst_no 는 필수값
 		//fuel_rt 중복 체크
 		var preRT = 0;
 		var nextRT = 0;		
		for( var i=1; i<=sheetObj.RowCount; i++ ){
			if( sheetObj.CellValue(i, 'ibflag') != 'D' && (sheetObj.CellValue(i, 'mgst_no') == null || sheetObj.CellValue(i, 'mgst_no') == '') ){
				ComShowMessage( ComGetMsg('TES60104', "M.G.Set No.") );
				sheetObj.RowFontColor(i) = sheetObj.RgbColor(255,0,0);
				return false;
			}
			
			nextRT = sheetObj.CellValue(i, 'fuel_rt');
 			if( i != 1 && preRT != nextRT ) {
 				sheetObj.RowFontColor(i) = sheetObj.RgbColor(255,0,0);
 				ComShowMessage(ComGetMsg('TES60106'));
 				return false;
 			}	
 			preRT = nextRT;
		}
		
// 		//fuel_rt 중복 체크
// 		var preRT = 0;
// 		var nextRT = 0;
// 		for( var i=1; i<= sheetObj.RowCount; i++ ){
// 			nextRT = sheetObj.CellValue(i, 'fuel_rt');
// 			if( i != 1 && preRT != nextRT ) {
// 				sheetObj.RowFontColor(i) = sheetObj.RgbColor(255,0,0);
// 				ComShowMessage(ComGetMsg('TES60106'));
// 			}
// 			preRT = nextRT;
//		} 	
 		
		//mgst_no 중복 체크
 		var duprow = sheetObj.ColValueDupRows("mgst_no", false);
 		if( duprow != null && duprow != "" ) {	//MGSet No 중복
 			ComShowMessage(ComGetMsg('TES23030', 'M.G.Set No.')); 			
 			var arrDupRows = duprow.split(",");			
			for( var i=0; i< arrDupRows.length; i++ ){
				sheetObj.RowFontColor(arrDupRows[i]) = sheetObj.RgbColor(255,0,0);
			} 			
 			return false;
 		}
 		
		var sMgstNos = "";
		var tmp = "@";
		var rowCnt = 0;	//ibflag != 'D' 경우의 row count 
		
		for( var row=1; row<=sheetObj.RowCount; row++ ){			
			if( sheetObj.CellValue(row, 'ibflag') != 'D' ) rowCnt++;
		}
		
		for( var row=1, i=0; row<=sheetObj.RowCount; row++ ){
			
			if( sheetObj.CellValue(row, 'ibflag') != 'D' ){
				i++;
				if( i==rowCnt ) tmp = "";
				sMgstNos = sMgstNos+"`"+sheetObj.CellValue(row, "mgst_no")+"`"+tmp;
			}
		}
		
		if( sAction == IBSAVE ) methodName ='saveMGSetNo';
		else methodName ='setMGSetNo';
		
		document.form.tmp_mgst_no.value = sMgstNos;
		
		if( sAction == IBSAVE && (document.form.tmp_mgst_no.value == null || document.form.tmp_mgst_no.value == "") ) {
			document.form.f_cmd.value = MULTI;
			var param = sheetObjects[0].GetSaveString(false,false);
			if( param !=null && param != "" ){								
				var savexml = sheetObjects[0].GetSaveXml("ESD_TES_1004Popup.do", param+'&'+tesFrmQryStr(document.form));
				sheetObjects[0].LoadSaveXml(savexml,true);
			}
		} else {
			tes_getInputValueInvoice('tmp_mgst_no_result', SEARCH08, 'tmp_mgst_no', methodName);
		}
	}
	
 }

	/**
	 * 조회가 완료되고 실행되는 이벤트
	 * @param {ibsheet}	sheet		IBSheet Object
	 * @param {string}	ErrMsg		error message
	 * @return
	 */	
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		ComSetObjValue(document.form.isExcel, "");
		sheetObj.Editable = true;
	}
	
	/**
	 * 저장 완료되고 발생하는 이벤트
	 * @param {sheet}	ibsheet
	 * @param {string}	ErrMsg		error message
	 * @return
	 */	
	function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
		 ComSetObjValue(document.form.isExcel, "");
		 sheetObj.Editable = true;
		 
		 var sumTotAmt = 0;
		 var sumQty = 0;
		 for( var i=1; i<=sheetObj.RowCount; i++){
			 sumTotAmt = sumTotAmt + parseFloat(sheetObj.CellValue(i, "ttl_amt"), 10);
			 sumQty = sumQty + parseFloat(sheetObj.CellValue(i, "fuel_qty"), 10);
		 }
		 
		 var opener_sheet = opener_obj.sheetObjects[2];
		 opener_sheet.CellValue2( opener_sheet.SelectRow, "inv_amt" ) = sumTotAmt;
		 opener_sheet.CellEditable( opener_sheet.SelectRow, "inv_amt" ) = false;
		 
		 if( opener_sheet.CellValue( opener_sheet.SelectRow, "lane_cd" ) == null || opener_sheet.CellValue( opener_sheet.SelectRow, "lane_cd" ) == '' )
			 opener_sheet.CellValue2( opener_sheet.SelectRow, "lane_cd" ) = 'OTH';
		 
		 opener_sheet.CellValue2( opener_sheet.SelectRow, "calc_vol_qty" ) = sumQty;
		 opener_sheet.CellEditable( opener_sheet.SelectRow, "calc_vol_qty" ) = false;
		 
		 
	}
	 