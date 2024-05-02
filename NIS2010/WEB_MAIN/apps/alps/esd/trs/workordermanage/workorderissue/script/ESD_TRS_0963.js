/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESD_TRS_0963.js
*@FileTitle : Bundling
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-31
*@LastModifier : kim_sang_geun
*@LastVersion : 1.0
* 2006-10-31 kim_sang_geun
* 1.0 최초 생성
--------------------------------------------------------
* history
* 2011.07.14 김영철 [CHM-201110224] [TRS] Flat rack CNTR Bundling 기능 추가요청 - SO화면에서 Bundling Data를 보여줌.
* 2011.07.20 김영철 [CHM-201112474] [TRS] Bundling 기능상에서 EQ TPSZ 호환성 부여요청
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @class ESD_TRS_0963 : BUNDLING SELECT POPUP
 */
function ESD_TRS_0908() {
    this.processButtonClick     = processButtonClick;
    this.setSheetObject         = setSheetObject;
    this.setComboObject         = setComboObject;
    this.setTabObject           = setTabObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;        
    this.initControl            = initControl;
    this.initTab                = initTab;
    this.doActionIBSheet        = doActionIBSheet;
    this.validateForm           = validateForm;
	this.autoBundling			= autoBundling;
	this.openerMainSheetCopy    = openerMainSheetCopy;
}
/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/

/* 공통전역변수 */
var sheetObjects = new Array();
var sheetCnt = 0;
var sheetObjSingle; //Single Transportation opener
var preSelectRow = 0;

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++] = sheet_obj;
}
	
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

	initControl();	
}

 /**
  * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
  * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
  * 
  * @param {ibsheet}
  *            sheetObj IBSheet Object
  * @param {int}
  *            sheetNo sheetObjects 배열에서 순번
  */
 function initControl() {
 	var formObj = document.form;

 	axon_event.addListenerForm  ('click', 'form_OnClick', formObj);
 } 
 
/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {

		var cnt = 0;
		var checkFlag = true;
		var selCheckFlag = true;

		switch(sheetNo) {
		   case 1:      //sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = GetSheetHeight(12);
					//전체 너비 설정
					SheetWidth = 750;
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
				   //전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 9, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(14, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);

					var HeadTitle0 = "|GP ID|GP Seq.|CNTR No.|TP/SZ|Status|Trans Mode|From|To|TRSP_SO_OFC_CTY_CD|TRSP_SO_SEQ|MTY_QYT|IBFLAG|Size";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle0, true);
					HeadRowHeight = 30; 

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtCheckBox,  	 30,	daCenter,  true,    "ibcheck");
					InitDataProperty(0, cnt++ , dtData, 	 	120,    daCenter,  true,	"mcntr_bdl_grp_seq", 	false,      "",     dfNone,     0,  false,      false);
					InitDataProperty(0, cnt++ , dtData, 	 	 80,    daCenter,  true,	"mcntr_bdl_seq", 		false,      "",     dfNone,     0,  false,      false);
					InitDataProperty(0, cnt++ , dtData,     	100,	daCenter,  true,    "eq_no",				false,		"",		dfNone,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,      	 50,    daCenter,  true,    "eq_tpsz_cd",			false,		"",		dfNone,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,     	 80,    daCenter,  true,    "bundl_sts",		    false,		"",		dfNone,		0,	false,		false);	
					InitDataProperty(0, cnt++ , dtData,      	 80,    daCenter,  true,    "trsp_crr_mod_cd",		false,		"",		dfNone,		0,	false,		false);			
					InitDataProperty(0, cnt++ , dtData,	  		100,  	daCenter,  true,    "fm_nod_cd",			false,		"",		dfNone,		0,	false,		false);		
					InitDataProperty(0, cnt++ , dtData,	  		100,  	daCenter,  true,    "to_nod_cd",			false,		"",		dfNone,		0,	false,		false);	
					InitDataProperty(0, cnt++ , dtHidden,    	 80,    daCenter,  true,    "trsp_so_ofc_cty_cd",	false,		"",	    dfNone,		0,	false,		false);	
					InitDataProperty(0, cnt++ , dtHidden,    	 80,    daCenter,  true,    "trsp_so_seq",          false,		"",	    dfNone,		0,	false,		false);	
					InitDataProperty(0, cnt++ , dtHidden,    	 80,    daCenter,  true,    "mty_bdl_cntr_qty",     false,		"",	    dfNone,		0,	false,		false);	
					InitDataProperty(0, cnt++ , dtHiddenStatus,   0, 	daCenter,  true,    "ibflag",               false,      "",     dfNone,     0,  false,      false);
					InitDataProperty(0, cnt++ , dtHidden,    	 80,    daCenter,  true,    "size",     			false,		"",	    dfNone,		0,	false,		false);	
				}
				break;
		   case 2:      //sheet2 init
			with (sheetObj) {
				// 높이 설정
				style.height = 0;
				//전체 너비 설정
				SheetWidth = 0;
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
				
			   //전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(6, 3, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false);

				var HeadTitle0 = "|TP/SZ|Trans Mode|From|To|COUNT";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);
				HeadRowHeight = 30; 

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,   0, daCenter, true, "ibflag");
				InitDataProperty(0, cnt++ , dtData,      50,    daCenter,  true,    "tpsz_cd",			false,		"",		dfNone,		0,	false,		false);
				InitDataProperty(0, cnt++ , dtData,      50,    daCenter,  true,    "trsp_crr_mod_cd",			false,		"",		dfNone,		0,	false,		false);
				InitDataProperty(0, cnt++ , dtData,      50,    daCenter,  true,    "fm_nod_cd",			false,		"",		dfNone,		0,	false,		false);
				InitDataProperty(0, cnt++ , dtData,      50,    daCenter,  true,    "to_nod_cd",			false,		"",		dfNone,		0,	false,		false);
				InitDataProperty(0, cnt++ , dtData,     50,    daCenter,  true,    "count",		    false,		"",		dfNone,		0,	false,		false);	
			}
			break;
	}
}

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	var formObject = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) {
			case "btn_bundling":
				if ( doActionIBSheet(sheetObjects[0],formObject,MULTI01) ) {
					openerMainSheetCopy("B");
					loadPage();
				}
			break;

			case "btn_remove_bundling":
				if ( doActionIBSheet(sheetObjects[0],formObject,MULTI02) ) {
					openerMainSheetCopy("R");
					loadPage();
				}
			break;
				
			case "btn_close":
				window.close();
			break;
			
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			errMsg = ComGetMsg("COM12111");
			ComShowMessage(errMsg);
		} else {
			ComShowMessage(e);
		}
	}
}

	
// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	var opener_obj = window.dialogArguments;
//	sheetObj.ShowDebugMsg = false;
    var openerMainSheet = opener_obj.sheetObjects[formObj.mainSheetArrayNo.value];
	switch(sAction) {
		case IBSEARCH:      //조회
			formObj.f_cmd.value = SEARCH;
		
			var queryStr = '';
			var countCheck = 'N';
			var tpSzCdrow;
			
			for(var i=2; i < openerMainSheet.RowCount+2; i++){
				if ( openerMainSheet.CellValue(i, "bundling_flg") == "Y" ){
					queryStr += '&ibflag=R';
					queryStr += '&trsp_so_ofc_cty_cd='+openerMainSheet.CellValue(i, 'trsp_so_ofc_cty_cd');
					queryStr += '&trsp_so_seq='+openerMainSheet.CellValue(i, 'trsp_so_seq');
				}
			}

			if ( queryStr != '' ){
				sheetObj.DoSearch("ESD_TRS_0963GS.do", TrsFrmQryString(formObj)+queryStr, false);
			}
		break;
		
		case MULTI01:      //Bundling
			formObj.f_cmd.value = MULTI01;
			if ( !autoBundling() ) {
				return false;
			}
			if(!validateForm(sheetObjects[0],formObj,sAction)) {
				return false;
			}
			sheetObj.DoSave("ESD_TRS_0963GS.do", TrsFrmQryString(formObj), 'ibcheck', false);
//			if (sheetObj.DoSave("ESD_TRS_0963GS.do", TrsFrmQryString(formObj), 'ibcheck', false)) {
//				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
//			}
		break;
		
		case MULTI02:      //Remove Bundling
			formObj.f_cmd.value = MULTI02;
			if(!validateForm(sheetObjects[0],formObj,sAction)) {
				return false;
			}
			sheetObj.DoSave("ESD_TRS_0963GS.do", TrsFrmQryString(formObj), 'ibcheck', false);
//			if (sheetObj.DoSave("ESD_TRS_0963GS.do", TrsFrmQryString(formObj), 'ibcheck', false)) {
//				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
//			}
		break;
	}
	return true;
}

function sheet1_OnChange(sheetObj, row , col , value) {
	var formObject = document.form;
	var colName = sheetObj.ColSaveName(col);

	switch(colName){
		case 'ibcheck':
			if ( formObject.manaul_flag.checked ){
				var maxGpId = "";
				var maxGpSeq = "";
				var selectCheck = "N";
				var stsCheck = "N";
				
				var iCheckRow = sheetObj.FindCheckedRow("ibcheck");
				var arrRow = iCheckRow.split("|");
			
				for (var idx=0; idx<arrRow.length - 1; idx++) {
					if ( arrRow[idx] == row ) {
						selectCheck = "Y";
					}
					if ( sheetObj.CellValue(row, "bundl_sts") != sheetObj.CellValue(arrRow[idx], "bundl_sts")){
						sheetObj.CellValue2(row, "ibcheck") = "N";
						return false;
					}
				}

				if ( sheetObj.CellValue(row, "bundl_sts") != "N" ){
					for( var i = 1; i<sheetObj.RowCount+1; i++ ){
						if (sheetObj.CellValue(i, "size") == sheetObj.CellValue(row, "size") &&
							sheetObj.CellValue(i, "mcntr_bdl_grp_seq") == sheetObj.CellValue(row, "mcntr_bdl_grp_seq") &&
							sheetObj.CellValue(i, "bundl_sts") == sheetObj.CellValue(row, "bundl_sts") ) {
							sheetObj.CellValue2(i, "ibcheck") = selectCheck;
						}
					}
				} else {
					if (selectCheck == "N"){
						maxGpId = "";
						maxGpSeq = "";
						for (var idx=0; idx<arrRow.length - 1; idx++) {
							sheetObj.CellValue2(arrRow[idx], "mcntr_bdl_grp_seq") = sheetObj.CellValue(arrRow[0], "trsp_so_ofc_cty_cd") + sheetObj.CellValue(arrRow[0], "trsp_so_seq");
							sheetObj.CellValue2(arrRow[idx], "mcntr_bdl_seq") = idx+1;
							if ( idx == 0 ){
								sheetObj.CellValue2(arrRow[idx], "mty_bdl_cntr_qty") = arrRow.length - 1;
							}
						}
					} else {
						if ( arrRow.length > 5 ){
							ComShowCodeMessage('TRS90324');
							sheetObj.CellValue2(row, "ibcheck") = "N";
							return;
						} else if ( arrRow.length == 2 ) {
							maxGpId = sheetObj.CellValue(row, "trsp_so_ofc_cty_cd") + sheetObj.CellValue(row, "trsp_so_seq");
							maxGpSeq = '1';
						} else {	
							for (var idx=0; idx<arrRow.length - 1; idx++) {
								if (sheetObj.CellValue(arrRow[idx], "size") != sheetObj.CellValue(row, "size")) {
									ComShowCodeMessage('TRS90345');
									sheetObj.CellValue2(row, "ibcheck") = "N";
									return;
								}

								if(sheetObj.CellValue(arrRow[idx], 'fm_nod_cd') != sheetObj.CellValue(row, 'fm_nod_cd') ||
								   sheetObj.CellValue(arrRow[idx], 'to_nod_cd') != sheetObj.CellValue(row, 'to_nod_cd') ) {
									ComShowCodeMessage('TRS90387','From/To');
									sheetObj.CellValue2(row, "ibcheck") = "N";
									return;
								}
								

								if(sheetObj.CellValue(arrRow[idx], 'trsp_crr_mod_cd') != sheetObj.CellValue(row, 'trsp_crr_mod_cd')) {
									ComShowCodeMessage('TRS90387','Trans Mode');
									sheetObj.CellValue2(row, "ibcheck") = "N";
									return;
								}
								
								if (sheetObj.CellValue(arrRow[idx], "mcntr_bdl_seq") != "" && sheetObj.CellValue(arrRow[idx], "mcntr_bdl_seq") != null){
									if ( maxGpSeq == null || maxGpSeq == "" ){
										maxGpSeq = sheetObj.CellValue(arrRow[idx], "mcntr_bdl_seq");
									} else if ( maxGpSeq < sheetObj.CellValue(arrRow[idx], "mcntr_bdl_seq")) {
										maxGpSeq = sheetObj.CellValue(arrRow[idx], "mcntr_bdl_seq");
									}
								}
								if ( sheetObj.CellValue(arrRow[idx], "mcntr_bdl_seq") == '1') {
									maxGpId = sheetObj.CellValue(arrRow[idx], "mcntr_bdl_grp_seq");
								}
							}
							maxGpSeq = eval(maxGpSeq)+1;
						}
					}
	
					sheetObj.CellValue2(row, "mcntr_bdl_grp_seq") = maxGpId;
					sheetObj.CellValue2(row, "mcntr_bdl_seq") = maxGpSeq;
					if (maxGpSeq == '1'){
						sheetObj.CellValue2(row, "mty_bdl_cntr_qty") = maxGpSeq;
					} else {
						for (var idx=0; idx<arrRow.length - 1; idx++) {
							if (sheetObj.CellValue(arrRow[idx], "mcntr_bdl_grp_seq") == maxGpId && 
								sheetObj.CellValue(arrRow[idx], "mcntr_bdl_seq") == '1'	) {
								sheetObj.CellValue2(arrRow[idx], "mty_bdl_cntr_qty") = maxGpSeq;
								break;
							}
						}
						sheetObj.CellValue2(row, "mty_bdl_cntr_qty") = 0;
					}
				}
			} else {
				sheetObj.CellValue2(row, "ibcheck") = "N";
			}
		break;
	}
}


///**
// * 조회결과가 오류가 발생했을 때 공통처리하는 함수
// * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
// */
//function sheet1_OnSearchEnd(sheetObj,errMsg){
//	var formObj = document.form;
//}



/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction) {

	switch(sAction) {
			case MULTI01: // Bundling
				var checkList = sheetObj.FindCheckedRow('ibcheck');
				if(checkList == ''){
					ComShowCodeMessage('COM12176');
					return false;
				}
				var checkArray = checkList.split('|');
				if ( sheetObj.CellValue(checkArray[0], 'bundl_sts') != 'N' ){
					ComShowCodeMessage('TRS90387','Bundling');
					sheetObj.SelectCell(checkArray[i], 'ibcheck');
					return false;
				}

				for(var i=0; i<checkArray.length-1; i++)
				{
					if ( sheetObj.CellValue(checkArray[i], 'bundl_sts') != 'N' ){
						ComShowCodeMessage('TRS90387','Bundling');
						sheetObj.SelectCell(checkArray[i], 'ibcheck');
						return false;
					}
				}
				break;
			case MULTI02:
				var checkList = sheetObj.FindCheckedRow('ibcheck');
				if(checkList == ''){
					ComShowCodeMessage('COM12176');
					return false;
				}
				var checkArray = checkList.split('|');

				for(var i=1; i<checkArray.length-1; i++)
				{
					if ( sheetObj.CellValue(checkArray[i], 'bundl_sts') == 'N' ){
						ComShowCodeMessage('TRS90387','No Bundled');
						sheetObj.SelectCell(checkArray[i], 'ibcheck');
						return false;
					}
				}
				break;
	}
	return true;
}



function form_OnClick() {
	var srcObj = window.event.srcElement;
 	var srcName = srcObj.getAttribute("name");
 	var srcValue = srcObj.getAttribute("value");
 	var formObj = document.form;
 	switch (srcName) {
	 	case "auto_flag" :
	 		if ( formObj.auto_flag.checked ){
	 			formObj.manaul_flag.checked = false;
	 			
	 			var iCheckRow = sheetObjects[0].FindCheckedRow("ibcheck");
				var arrRow = iCheckRow.split("|");
				
				for (var idx=0; idx<arrRow.length - 1; idx++) {
					sheetObjects[0].CellValue2(arrRow[idx], "ibcheck") = "N";
					if ( sheetObjects[0].CellValue(arrRow[idx], "bundl_sts") == "N"){
						sheetObjects[0].CellValue2(arrRow[idx], "mcntr_bdl_grp_seq") = '';
						sheetObjects[0].CellValue2(arrRow[idx], "mcntr_bdl_seq") = '';
					}
				}
	 		} else {
	 			formObj.auto_flag.checked = true;
	 		}
	 		break;	 		
	 	case "manaul_flag" :
	 		if ( formObj.manaul_flag.checked ){
	 			formObj.auto_flag.checked = false;

//	 			var iCheckRow = sheetObjects[0].FindCheckedRow("ibcheck");
//				var arrRow = iCheckRow.split("|");
//				
//				for (var idx=0; idx<arrRow.length - 1; idx++) {
//					sheetObjects[0].CellValue2(arrRow[idx], "ibcheck") = "N";
//					sheetObjects[0].CellValue2(arrRow[idx], "mcntr_bdl_grp_seq") = '';
//					sheetObjects[0].CellValue2(arrRow[idx], "mcntr_bdl_seq") = '';
//				}
	 		} else {
	 			formObj.manaul_flag.checked = true;
	 		}
	 		break;	 
 	}
 }

function autoBundling() {
	var formObject = document.form;
	var sheetObj0 = sheetObjects[0];
	var sheetObj1 = sheetObjects[1];
	var cntrTpSzCd = new Array();
	var bundleRadio = 0;
	var tpszCnt = 0;
	var noBundlCnt = 0;
	var message = "";

	if ( formObject.auto_flag.checked ){
		if ( formObject.bundle_radio[0].checked ){
			bundleRadio = 2;
		} else if ( formObject.bundle_radio[1].checked ){
			bundleRadio = 3;
		}else if ( formObject.bundle_radio[2].checked ){
			bundleRadio = 4;
		}
		
		for( var i = 1; i<sheetObj1.RowCount+1; i++ ){
			tpszCnt = ComParseInt(eval(sheetObj1.CellValue(i, "count"))/eval(bundleRadio));
			tpszCnt = tpszCnt * bundleRadio;
			noBundlCnt = eval(sheetObj1.CellValue(i, "count"))%eval(bundleRadio);
			for( var row = 1; row<sheetObj0.RowCount+1; row++ ){
				if ( sheetObj1.CellValue(i, "tpsz_cd") == sheetObj0.CellValue(row, "size") && 
					 sheetObj1.CellValue(i, "fm_nod_cd") == sheetObj0.CellValue(row, "fm_nod_cd") &&
					 sheetObj1.CellValue(i, "to_nod_cd") == sheetObj0.CellValue(row, "to_nod_cd") &&
					 sheetObj1.CellValue(i, "trsp_crr_mod_cd") == sheetObj0.CellValue(row, "trsp_crr_mod_cd") &&
					 sheetObj0.CellValue(row, "bundl_sts") == "N" ){
					if ( tpszCnt != 0 ){
						sheetObj0.CellValue2(row, "ibcheck") = "Y";
						tpszCnt = tpszCnt - 1;
						if(!autoBundlingCheck(sheetObj0, row , 0 , true, bundleRadio)){
							return false;
						}
					}
				}
			}
			if (noBundlCnt != 0 ){
				message = message + sheetObj1.CellValue(i, "tpsz_cd") + " : " + noBundlCnt + ", ";
			}
		}
		message = message.substring(0,message.length-2);
//		alert("message : "+ message);
		if ( message != "" && message != null ){
			if ( !ComShowCodeConfirm("TRS90386","'"+message+"'"+"CNTR can not be bundled with assigned bundling number. Do you like to proceed with bundling except for those CNTR?") ){
				var checkList = sheetObj0.FindCheckedRow('ibcheck');
				if(checkList != ''){
					var checkArray = checkList.split('|');	
					for(var i=0; i<checkArray.length-1; i++)
					{
						sheetObj0.CellValue2(checkArray[i], "ibcheck") = "N";
						sheetObj0.CellValue2(checkArray[i], "mcntr_bdl_grp_seq") = "";
						sheetObj0.CellValue2(checkArray[i], "mcntr_bdl_seq") = "";
					}
				}
				return false;
			}
		}
	}
	return true;
}

function autoBundlingCheck(sheetObj, row , col , value){
	var formObj = document.form;
	
	var maxGpId = "";
	var maxGpSeq = "";
	var selectCheck = "N";
	var bundleRadio = 0;
	var idx=0;
	var idx2=0;
	var gpSeqCnt = 0;
	var gpSeqRow = 0;

	if ( formObj.bundle_radio[0].checked ){
		bundleRadio = 2;
	} else if ( formObj.bundle_radio[1].checked ){
		bundleRadio = 3;
	}else if ( formObj.bundle_radio[2].checked ){
		bundleRadio = 4;
	}
	
	var iCheckRow = sheetObj.FindCheckedRow("ibcheck");
	var arrRow = iCheckRow.split("|");
	
	if ( arrRow.length-1 == 1 ) {
		maxGpId = sheetObj.CellValue(row, "trsp_so_ofc_cty_cd") + sheetObj.CellValue(row, "trsp_so_seq");
		maxGpSeq = '1';
	} else {
		for (idx=0; idx<arrRow.length - 1; idx++) {
			if (sheetObj.CellValue(arrRow[idx], "mcntr_bdl_seq") == "1" && sheetObj.CellValue(arrRow[idx], "mty_bdl_cntr_qty") != bundleRadio &&
				sheetObj.CellValue(arrRow[idx], "mty_bdl_cntr_qty") != "" && sheetObj.CellValue(arrRow[idx], "mty_bdl_cntr_qty") != null){
				
				gpSeqRow = 0;
				for(i=0; i<bundleRadio ;i++){
					gpSeqRow = sheetObj.FindText("mcntr_bdl_grp_seq", sheetObj.CellValue(arrRow[idx], "mcntr_bdl_grp_seq"), gpSeqRow);
					if ( gpSeqRow != -1 ){
						if ( maxGpSeq < sheetObj.CellValue(gpSeqRow, "mcntr_bdl_seq") ){
							maxGpSeq = sheetObj.CellValue(gpSeqRow, "mcntr_bdl_seq");
						}
					}
					gpSeqRow++;
				}
				
				if ( bundleRadio == maxGpSeq ){
					maxGpSeq = "";
				} else {
					maxGpId = sheetObj.CellValue(arrRow[idx], "trsp_so_ofc_cty_cd") + sheetObj.CellValue(arrRow[idx], "trsp_so_seq");
				}
				
			}
		}

		if ( maxGpSeq == "" ){
			maxGpId = sheetObj.CellValue(row, "trsp_so_ofc_cty_cd") + sheetObj.CellValue(row, "trsp_so_seq");
			maxGpSeq = '0';
		}
		maxGpSeq = eval(maxGpSeq)+1;
	}
	sheetObj.CellValue2(row, "mcntr_bdl_grp_seq") = maxGpId;
	sheetObj.CellValue2(row, "mcntr_bdl_seq") = maxGpSeq;
	
	gpSeqRow = sheetObj.FindText("mcntr_bdl_seq", "1", sheetObj.FindText("mcntr_bdl_grp_seq", maxGpId, 0));
	sheetObj.CellValue2(gpSeqRow, "mty_bdl_cntr_qty") = maxGpSeq;
	if (gpSeqRow != row ){
		sheetObj.CellValue2(row, "mty_bdl_cntr_qty") = 0;
	}
	
	return true;
}


/**
 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet1_OnSearchEnd(sheetObj, errMsg) {
	var formObj = document.form;

	var countCheck = 'N';
	var tpSzCdrow;
	var size = '';
	
	if( errMsg != '' ) {
		ComShowMessage(errMsg);
	}else{
		for( var i = 1; i<sheetObjects[0].RowCount+1; i++){
			size = sheetObjects[0].CellValue(i, "eq_tpsz_cd").substring(1,2);
			if ( eval(size) >= 4 ) size = '4';
			sheetObjects[0].CellValue2(i, "size") = size;
		}
		for( var i = 1; i<sheetObjects[0].RowCount+1; i++){
			if ( sheetObjects[0].CellValue(i, "bundl_sts") == "N" ){
				if ( sheetObjects[1].RowCount == 0 ) {
					tpSzCdrow = sheetObjects[1].DataInsert(-1);					
					sheetObjects[1].CellValue2(tpSzCdrow, "tpsz_cd") = sheetObjects[0].CellValue(i, "size");
					sheetObjects[1].CellValue2(tpSzCdrow, "fm_nod_cd") = sheetObjects[0].CellValue(i, "fm_nod_cd");
					sheetObjects[1].CellValue2(tpSzCdrow, "to_nod_cd") = sheetObjects[0].CellValue(i, "to_nod_cd");
					sheetObjects[1].CellValue2(tpSzCdrow, "trsp_crr_mod_cd") = sheetObjects[0].CellValue(i, "trsp_crr_mod_cd");
					sheetObjects[1].CellValue2(tpSzCdrow, "count") = "1";
				} else {
					for( var j = 1; j<sheetObjects[1].RowCount+1; j++){
						if ( sheetObjects[0].CellValue(i, "size") == sheetObjects[1].CellValue(j, "tpsz_cd") &&
							 sheetObjects[0].CellValue(i, "fm_nod_cd") == sheetObjects[1].CellValue(j, "fm_nod_cd") &&
							 sheetObjects[0].CellValue(i, "to_nod_cd") == sheetObjects[1].CellValue(j, "to_nod_cd") &&
							 sheetObjects[0].CellValue(i, "trsp_crr_mod_cd") == sheetObjects[1].CellValue(j, "trsp_crr_mod_cd")) {
							sheetObjects[1].CellValue2(j, "count") = eval(sheetObjects[1].CellValue(j, "count"))+1;
							countCheck = "Y";
							break;
						}
					}
	
					if ( countCheck == "N" ){
						tpSzCdrow = sheetObjects[1].DataInsert(-1);
						sheetObjects[1].CellValue2(tpSzCdrow, "tpsz_cd") = sheetObjects[0].CellValue(i, "size");
						sheetObjects[1].CellValue2(tpSzCdrow, "fm_nod_cd") = sheetObjects[0].CellValue(i, "fm_nod_cd");
						sheetObjects[1].CellValue2(tpSzCdrow, "to_nod_cd") = sheetObjects[0].CellValue(i, "to_nod_cd");
						sheetObjects[1].CellValue2(tpSzCdrow, "trsp_crr_mod_cd") = sheetObjects[0].CellValue(i, "trsp_crr_mod_cd");
						sheetObjects[1].CellValue2(tpSzCdrow, "count") = "1";
					}
					countCheck = "N";
				}
			}
		}
	}
}
 
 function openerMainSheetCopy(gpYn) {

	var opener_obj = window.dialogArguments;
	var openerMainSheet = opener_obj.sheetObjects[0];
	 
	var iCheckRow = sheetObjects[0].FindCheckedRow("ibcheck");
	var arrRow = iCheckRow.split("|");
	
	for (var idx=0; idx<arrRow.length - 1; idx++) {
		 for(var i=2; i < openerMainSheet.RowCount+2; i++){
			if ( sheetObjects[0].CellValue(arrRow[idx], "trsp_so_ofc_cty_cd") == openerMainSheet.CellValue(i, 'trsp_so_ofc_cty_cd') &&
				 sheetObjects[0].CellValue(arrRow[idx], "trsp_so_seq") == openerMainSheet.CellValue(i, 'trsp_so_seq') ){
				if ( gpYn == "B"){
					openerMainSheet.CellValue2(i,"mcntr_bdl_grp_seq") = sheetObjects[0].CellValue(arrRow[idx], "mcntr_bdl_grp_seq");
					openerMainSheet.CellValue2(i,"mcntr_bdl_seq") = sheetObjects[0].CellValue(arrRow[idx], "mcntr_bdl_seq");
					openerMainSheet.CellValue2(i,"bundling_no") = sheetObjects[0].CellValue(arrRow[idx], "mty_bdl_cntr_qty");
				} else {
					openerMainSheet.CellValue2(i,"mcntr_bdl_grp_seq") = "";
					openerMainSheet.CellValue2(i,"mcntr_bdl_seq") = "";
					openerMainSheet.CellValue2(i,"bundling_no") = "1";
				}
				openerMainSheet.CellValue2(i, 'po_sp_type') = ""; 
				openerMainSheet.CellValue2(i, 'po_cust_nomi_trkr_flg') = ""; 						
				openerMainSheet.CellValue2(i, 'cust_cnt_cd_seq') = "";
				openerMainSheet.CellValue2(i, 'po_cust_cnt_cd') = "";
				openerMainSheet.CellValue2(i, 'po_cust_seq') = "";	
				openerMainSheet.CellValue2(i, 'po_cust_cnt_cd') = "";
				openerMainSheet.CellValue2(i, 'po_cust_seq') = "";
//				openerMainSheet.CellValue2(i, 'po_local_curr_cd') = "";
				openerMainSheet.CellValue2(i, 'po_trsp_agmt_ofc_cty_cd') = "";
				openerMainSheet.CellValue2(i, 'po_trsp_agmt_seq') = "";
				openerMainSheet.CellValue2(i, 'po_trsp_agmt_rt_tp_cd') = "";
				openerMainSheet.CellValue2(i, 'po_way_type') = "";
				openerMainSheet.CellValue2(i, 'po_trsp_agmt_rt_tp_nm') = "";
				openerMainSheet.CellValue2(i, 'po_sp_type') = "";
				openerMainSheet.CellValue2(i, 'po_cust_nomi_trkr_flg') = "";
				openerMainSheet.CellValue2(i, 'po_basic_rt') = "";
				openerMainSheet.CellValue2(i, 'po_fuel_scg_rt') = "";
				openerMainSheet.CellValue2(i, 'po_over_wgt_scg_rt') = "";
				openerMainSheet.CellValue2(i, 'po_local_curr_tot_amt') = "";
				openerMainSheet.CellValue2(i, 'po_usd_curr_tot_amt') = "";
				openerMainSheet.CellValue2(i, 'po_rtn_cd') = "";
				openerMainSheet.CellValue2(i, 'po_rtn_msg') = "";

				openerMainSheet.CellValue2(i, 'trsp_dflt_vndr_flg') = ""; 
				openerMainSheet.CellValue2(i, 'vndr_seq') = "";
				openerMainSheet.CellValue2(i, 'vndr_nm') = "";
			}
		}
	 }
 }