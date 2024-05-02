/* =========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName      : ESD_PRD_0037.js
 *@FileTitle     : Canada CCT Manage
 *Open Issues    :
 *Change history :
 * 1.0 최초 생성 JunKun Lee
 * CSR: CHM-201217726-01 Rail Receiving (Cut Off) Date 산출 Logic 변경 및 추가 요청
 * 2012.11.02 정선용 [CHM-201221039] [PRD] Canada rail cut off 기능개선
========================================================= */

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var validateData = "";
var retValidate = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    var sheetObject1 = sheetObjects[0];
    var sheetObject2 = sheetObjects[1];
    /** **************************************************** */
    var formObject = document.form;

    try {
        var srcName = window.event.srcElement.getAttribute("name");
    
        /***********************************************************************
         * enterKey 처리
         **********************************************************************/
        var srcObj = window.event.srcElement.nodeName;
        var keyObj = window.event.keyCode;
      
        /****************************/
        switch (srcName) {

        case "btn_retrieve":
            doActionIBSheet(sheetObject1, formObject, IBSEARCH);
            break;

        case "btn_save":
            doActionIBSheet(sheetObject1, formObject, MULTI);
            break;

        case "btn_rowadd":
        	addRow(formObject);
			break;

        case "btn_rowdel":
        	deleteRow();
			break;
			
        case "btn_save2":
            doActionIBSheet(sheetObject2, formObject, MULTI02);
            break;
        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            ComShowMessage(ComGetMsg('COM12111'));
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
    for (i = 0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }

//	if(CRUD == "R") {
//    	ComBtnDisable("btn_save");
//	}

	//Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	axon_event.addListenerFormat('keypress',         'obj_keypress', 	form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
	
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	
	doActionIBSheet(sheetObjects[1], document.form, COMMAND01);
}


/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
    var cnt = 0;

    switch (sheetNo) {
    case 1: //sheet1 init
        with (sheetObj) {
            // 높이 설정
            style.height = 240;

            // 전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            // Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "")
                InitHostInfo(location.hostname, location.port, page_path);

            // 전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

            // 전체Edit 허용 여부 [선택, Default false]
            Editable = true;

            var HeadTitle  = "STS|Del|POR|POR\n(Node)|POL|Days from ETA(Canada)/ETB(US)|Days from ETA(Canada)/ETB(US)|Days from ETA(Canada)/ETB(US)|Days from ETA(Canada)/ETB(US)|Days from ETA(Canada)/ETB(US)|Days from ETA(Canada)/ETB(US)|Days from ETA(Canada)/ETB(US)|Cut Off Time|Update User|Update Date";
            var HeadTitle1 = "STS|Del|POR|POR\n(Node)|POL|SUN|MON|TUE|WED|THU|FRI|SAT|Cut Off Time|Update User|Update Date";
            
            var headCount = ComCountHeadTitle(HeadTitle);
            
            // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(2, 1, 9, 100);

            // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, false, true, false, false);
            
            // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, true);
            InitHeadRow(1, HeadTitle1, true);

            // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0,		cnt++,	dtHiddenStatus,	 30,	daCenter,		true,	"ibflag");
			InitDataProperty(0,		cnt++,	dtDelCheck,		 30,	daCenter,		true,	"check",			false,		"",			dfNone,				0,	true,	true);
			
			InitDataProperty(0,     cnt++,  dtData,			 60,	daCenter,		true,	"por_cd",			true,		"",         dfNone,				0,  false,	true,	5);
			InitDataProperty(0,     cnt++,  dtData,			 60,	daCenter,		true,	"por_nod_cd",			false,		"",         dfNone,				0,  false,	true,	7);
			InitDataProperty(0,     cnt++,  dtData,			 60,	daCenter,		true,	"pol_nod_cd",			true,		"",         dfNone,				0,  false,	true,	7);
			
			InitDataProperty(0,     cnt++,  dtData,			 40,	daCenter,		true,	"arr_sun_dys",		false,		"",         dfInteger,			0,  true,	true,	3);
			InitDataProperty(0,     cnt++,  dtData,			 40,	daCenter,		true,	"arr_mon_dys",		false,		"",         dfInteger,			0,  true,	true,	3);
			InitDataProperty(0,     cnt++,  dtData,			 40,	daCenter,		true,	"arr_tue_dys",		false,		"",         dfInteger,			0,  true,	true,	3);
			InitDataProperty(0,     cnt++,  dtData,			 40,	daCenter,		true,	"arr_wed_dys",		false,		"",         dfInteger,			0,  true,	true,	3);
			InitDataProperty(0,     cnt++,  dtData,			 40,	daCenter,		true,	"arr_thu_dys",		false,		"",         dfInteger,			0,  true,	true,	3);
			InitDataProperty(0,     cnt++,  dtData,			 40,	daCenter,		true,	"arr_fri_dys",		false,		"",         dfInteger,			0,  true,	true,	3);
			InitDataProperty(0,     cnt++,  dtData,			 40,	daCenter,		true,	"arr_sat_dys",		false,		"",         dfInteger,			0,  true,	true,	3);
            InitDataProperty(0,     cnt++,  dtData,          80,    daCenter,       true,   "cct_hrmnt",        false,      "",         dfTimeHm,           0,  true,   true);
            //InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  false,    "fmt_tztm_hrs",   true,  "",       dfUserFormat2, 0,     true,       true);
			
			InitDataProperty(0,     cnt++,  dtData,			 75,	daCenter,		true,	"upd_usr_id",		false,		"",         dfNone,				0,  false,	false);
			InitDataProperty(0,     cnt++,  dtData,			 75,	daCenter,		true,	"upd_dt",			false,		"",         dfUserFormat,		0,  false,	false);
			
			WaitImageVisible=false;
			
			InitUserFormat(0, "upd_dt", "####-##-##", "-" );
			InitViewFormat(0, "cct_hrmnt", "hh:mm");
			InitDataValid(0, "por_cd",         vtEngUpOther, "1234567890");
			InitDataValid(0, "pol_nod_cd",         vtEngUpOther, "1234567890");
			InitDataValid(0, "por_nod_cd",         vtEngUpOther, "1234567890");

        }
        break;
        
    case 2: //sheet1 init
	    with (sheetObj) {
	        // 높이 설정
	        style.height = 240;
	
	        // 전체 너비 설정
	        SheetWidth = mainTable.clientWidth;
	
	        // Host정보 설정[필수][HostIp, Port, PagePath]
	        if (location.hostname != "")
	            InitHostInfo(location.hostname, location.port, page_path);
	
	        // 전체Merge 종류 [선택, Default msNone]
	        MergeSheet = msHeaderOnly;
	
	        // 전체Edit 허용 여부 [선택, Default false]
	        Editable = true;
	        
	        var HeadTitle   = "ST|LRD|Canada|Canada|Canada|USA|USA|USA";
	        var HeadTitle1  = "ST|LRD|Adjusted\nLRD|ERD|Days b/w\nERD/LRD|Adjusted\nLRD|ERD|Days b/w\nERD/LRD";

            
	        var headCount = ComCountHeadTitle(HeadTitle);
	
	        // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	        InitRowInfo(2, 1, 9, 100);
	
	        // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	        InitColumnInfo(headCount, 0, 0, false);
	
	        // 해더에서 처리할 수 있는 각종 기능을 설정한다
	        InitHeadMode(true, true, false, true, false, false);
	        
	        // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
//	        InitHeadRow(0, HeadTitle, true);
            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, true);
            InitHeadRow(1, HeadTitle1, true);
	        // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0,		cnt++,	dtHiddenStatus,	 30,	daCenter,		true,	"ibflag");

            InitDataProperty(0,     cnt++,  dtImageText,	 50,	daCenter,		true,	"ltst_rcv_dy_cd",	false,		"",         dfNone,			0,  false,	false,	20);
	        //canada 용
	        InitDataProperty(0,     cnt++,  dtComboEdit,			 60,	daCenter,		true,	"adj_ltst_rcv_dy_cd",	false,		"",         dfNone,			0,  true,	false,	20);
	        InitDataProperty(0,     cnt++,  dtComboEdit,			 50,	daCenter,		true,	"ery_rcv_dy_cd",	false,		"",         dfNone,			0,  true,	false,	20);
	        InitDataProperty(0,     cnt++,  dtData,			80,	daCenter,		true,	"rcv_itval_dys",	false,		"",         dfNone,			0,  true,	false,	20);
	        //usa 용 
	        InitDataProperty(0,     cnt++,  dtComboEdit,			 60,	daCenter,		true,	"us_adj_ltst_rcv_dy_cd",	false,		"",         dfNone,			0,  true,	false,	20);
	        InitDataProperty(0,     cnt++,  dtComboEdit,			 50,	daCenter,		true,	"us_ery_rcv_dy_cd",	false,		"",         dfNone,			0,  true,	false,	20);
	        InitDataProperty(0,     cnt++,  dtData,			80,	daCenter,		true,	"us_rcv_itval_dys",	false,		"",         dfNone,			0,  true,	false,	20);
			
			WaitImageVisible=false;
			InitDataCombo(0, "adj_ltst_rcv_dy_cd", adj_ltst_rcv_dy_cdText, adj_ltst_rcv_dy_cdCode);
			InitDataCombo(0, "ery_rcv_dy_cd", ery_rcv_dy_cdText, ery_rcv_dy_cdCode);
			InitDataCombo(0, "us_adj_ltst_rcv_dy_cd", us_adj_ltst_rcv_dy_cdText, us_adj_ltst_rcv_dy_cdCode);
			InitDataCombo(0, "us_ery_rcv_dy_cd", us_ery_rcv_dy_cdText, us_ery_rcv_dy_cdCode);
			sheetObj.ImageList("myImage1") = "img/alps/ess1.gif";
	    }
	    break;
    }
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	var uid ;
	var sXml ;
	sheetObj.ShowDebugMsg = false;

	switch (sAction) {

	case IBSEARCH: //조회
		if (validateForm(sheetObj, formObj, sAction));
		formObj.f_cmd.value = SEARCH;
		sheetObj.DoSearch4Post("ESD_PRD_0037GS.do", PrdFQString(formObj));
	break;

        
	case COMMAND01:
		if (validateForm(sheetObj, formObj, sAction));
		formObj.f_cmd.value = COMMAND01;
		sheetObj.DoSearch4Post("ESD_PRD_0037GS.do", PrdFQString(formObj));
		break;
	
	case MULTI: //저장
		ComOpenWait(true, true);
		if (validateForm(sheetObj, formObj, sAction) != true) {
			ComOpenWait(false, false);
			break;
		}
		
		// Duplication Check
		if(!doActionIBSheet(sheetObj,formObj, SEARCH03)) {
			ComOpenWait(false, false);
			
    		return;
		}
		
		formObj.f_cmd.value = MULTI;
	
		var sParam = sheetObj.GetSaveString(false, true, "ibflag");
		if (sParam == "") {
			ComOpenWait(false, false);
			return;
		}
		sParam += "&" + FormQueryString(formObj);
		
		sXml = sheetObj.GetSaveXml("ESD_PRD_0037GS.do", sParam);
		
		var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
		if (State != "S") {
			ComShowCodeMessage('COM130103', 'Data');
			
			ComOpenWait(false, false);
			return false;
		} else if (State == "S") {
			ComShowCodeMessage('COM130102', 'Data');
		}
		
		ComOpenWait(false, false);
		
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		
		break;
		
	case SEARCH01:          // POL Check
	    formObj.f_cmd.value = SEARCH01;
		
		sXml = sheetObj.GetSearchXml("ESD_PRD_0037GS.do", PrdFQString(formObj));  
	  
	    if (sXml.length > 0) {
	    	retValidate = ComGetTotalRows(sXml);
		}
	    break;
	    
	case SEARCH02:          // POR Check
	    formObj.f_cmd.value = SEARCH02;
		
		sXml = sheetObj.GetSearchXml("ESD_PRD_0037GS.do", PrdFQString(formObj));  
	  
	    if (sXml.length > 0) {
	    	retValidate = ComGetTotalRows(sXml);
		}
	    break;
	    
	case SEARCH03:
    	formObj.f_cmd.value = SEARCH03;
		
    	var sParam = sheetObj.GetSaveString(false, true, "s_ibflag");
    	
    	if(sParam == null || sParam == "")
    		return false;
    	
    	sParam = "f_cmd=" + SEARCH03 + "&" + sParam;
    	var sXml = sheetObj.GetSaveXml("ESD_PRD_0037GS.do", sParam);
    	var dupChk = ComGetEtcData(sXml, "dupChk");
    	
    	if(dupChk == "0") {
    		return true;
    	} else {
    		ComShowCodeMessage('COM131302', 'POR & POL');
    		return false;
    	}
    	break;
	case MULTI02:
		ComOpenWait(true, true);
		formObj.f_cmd.value = MULTI02;
//		if (sParam == "") {
//			ComOpenWait(false, false);
//			return;
//		}
//		sParam += "&" + FormQueryString(formObj);
		var sParam = sheetObj.GetSaveString(false, true, "s_ibflag");
    	
    	if(sParam == null || sParam == "")
    		return false;	
//		sheetObj.ShowDebugMsg = true;
		sParam += "&" + FormQueryString(formObj);
		sXml = sheetObj.GetSaveXml("ESD_PRD_0037GS.do", sParam);
//		sheetObj.ShowDebugMsg = false;
		ComOpenWait(false, false);
		doActionIBSheet(sheetObjects[1], document.form, COMMAND01);
		break;
	}
}

function addRow(formObj) {
	with (sheetObjects[0]) {
		var nowRow = SelectRow;
		nowRow = DataInsert(-1);
		return true;
	}
}

/**
 * row delete
 */
function deleteRow() {
	with (sheetObjects[0]) {
		var sRowStr = FindCheckedRow("check");
		var arr = sRowStr.split("|");

		for ( var i = 0; i < arr.length - 1; i++) {
			RowStatus(arr[i]) = "D";
			RowHidden(arr[i]) = "true";
		}
	}
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
    with (formObj) {
        //            if (!isNumber(iPage)) {
        //
        // return false;
        // }
    }
    return true;
}

function sheet1_OnChange(sheetObj, Row, Col, Value){
	if(Value == "") return;
	
	var formObject = document.form;
	var colName = sheetObj.ColSaveName(Col);
	    	
	// delchk의 경우 예외 처리 (Insert Row의 경우 먼저 삭제되고 event생긴다.
	if (colName == "check") {
		if(sheetObj.CellValue(Row,colName) == undefined || sheetObj.CellValue(Row,colName) == 0) { return; }
	}
	
	validateData = sheetObj.CellValue(Row, colName);
	
    if(colName == "pol_nod_cd") {
    	formObject.frm_loc_cd.value = Value;
    	if(Value.length == 5){
    		if (!fnChkPorCode(sheetObj, Row, colName, Value)) { 
            	return false;
            }
    	} else if (!fnChkPolCode(sheetObj, Row, colName, Value)) {
        	return false;
        }
    } else if(colName == "por_cd") {
    	formObject.frm_loc_cd.value = Value;
        if (!fnChkPorCode(sheetObj, Row, colName, Value)) { 
        	return false;
        }
    } else if(colName == "por_nod_cd" ) {
    	//por_cd 와 por_nod_cd의 loc 이 같은지 확인 
    	if( Value.length > 5 &&  sheetObj.CellValue(Row,"por_cd") != Value.substr(0,5) ) {
    		
    		ComShowMessage(ComGetMsg('PRD90059'));
    		sheetObj.CellValue2(Row, colName) = "";
    		sheetObj.SelectCell(Row, "por_nod_cd");
    	}
    }
    
    if(colName == "pol_nod_cd" || colName == "por_cd") {
	    if(sheetObj.ColValueDup("pol_nod_cd|por_cd|por_nod_cd") > 0) {
	    	ComShowCodeMessage('COM131302', 'POR & POL');
	    	sheetObj.SelectCell(Row, "por_cd");
	    	
			return false;
		}
    }
}

function sheet1_OnSearchEnd(sheet, ErrMsg) {
	sheet.ColFontColor("pol_nod_cd") = sheet.RgbColor(255, 0, 0);
}


function sheet2_OnSearchEnd(sheet, ErrMsg) {
	if ( sheet.RowCount > 0 ){
		for(var i=sheet.HeaderRows; i<sheet.HeaderRows + sheet.RowCount; i++){
			
			// LRD 값에 * 가 있으면
			var lrdStr = sheet.CellValue(i, "ltst_rcv_dy_cd");
			if(lrdStr.length > 0 && lrdStr.substr(0, 1) == "*") {
				// 주어진 문자값에서 * 를 제거한다.
				lrdStr = lrdStr.substr(1, lrdStr.length);
				// *를 제거한 값을 다시 세팅한다.
				sheet.CellValue(i, "ltst_rcv_dy_cd") = lrdStr;
				sheet.CellImage(i, "ltst_rcv_dy_cd") = 0;
			}
		}
	}
}
	
function fnChkPolCode(sheetObj, Row, colName, Value) {
	var sheetId = sheetObj.id;
	validateData = Value.toUpperCase();
	
	if(sheetId == "sheet1") {
    	if(Value.length == 0) {
    		return true;
    	} else if( Value.length == 7 ) {
    		doActionIBSheet(sheetObj, document.form, SEARCH01); // pol 은 ca 만 가능
    		
            if(retValidate == "" || retValidate < 1) {
            	ComShowMessage(ComGetMsg('PRD90139'));
            	sheetObj.CellValue2(Row, colName) = "";
            	sheetObj.SelectCell(Row, colName);
                return false;
        	}
    	} else {
    		ComShowMessage(ComGetMsg('PRD90139'));
    		sheetObj.CellValue2(Row, colName) = "";
        	sheetObj.SelectCell(Row, colName);
            return false;
    	}
	}
	return true;
}

function fnChkPorCode(sheetObj, Row, colName, Value) {
	var sheetId = sheetObj.id;
	validateData = Value.toUpperCase();
	
	if(sheetId == "sheet1") {
    	if(Value.length == 0) {
    		return true;
    	} else if( Value.length == 5 ) {
    		doActionIBSheet(sheetObj, document.form, SEARCH02);
    		
            if(retValidate == "" || retValidate < 1) { 
            	ComShowMessage(ComGetMsg('PRD90139'));
            	sheetObj.CellValue2(Row, colName) = "";
            	sheetObj.SelectCell(Row, colName);
                return false;
        	}
    	} else {
    		ComShowMessage(ComGetMsg('PRD90139'));
    		sheetObj.CellValue2(Row, colName) = "";
        	sheetObj.SelectCell(Row, colName);
            return false;
    	}
	}
	return true;
}