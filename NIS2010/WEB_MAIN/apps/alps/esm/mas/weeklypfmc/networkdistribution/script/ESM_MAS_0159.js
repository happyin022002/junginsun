/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0159.js
*@FileTitle : Commercial Based Unit Cost
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.24
*@LastModifier : 이연각
*@LastVersion : 1.0
=========================================================
* History
* 2008-07-22 : YJ Jeon
* 2008.07.22 전윤주 N200807218173 Commercial Base U/C 화면 추가
* 2008.09.11 박칠서 N200809040008 약정율 4자리까지 표시
* 2009.10.23 김기대 New FrameWork 적용
* 2010.02.24 이연각 업무처리중 버튼사용 금지 처리
* 2010.04.15 이행지 FormQueryString => masFormQueryString 변경
* 2010.12.01 김기종 Ticket ID:CHM-201006305-01 MAS Architecture 위배사항 수정
=========================================================*/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends 
 * @class ESM_MAS_0159 : ESM_MAS_0159 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_MAS_0159() {
    this.processButtonClick = processButtonClick ;
    this.loadPage           = loadPage           ;
    this.initSheet          = initSheet          ;
    this.setSheetObject     = setSheetObject     ;
    this.cobTrade_OnChange  = cobTrade_OnChange  ;
    this.setPeriod          = setPeriod          ;
    this.keyEnter_loc       = keyEnter_loc       ;
    this.sheet1_OnSaveEnd   = sheet1_OnSaveEnd   ;
    this.doActionIBSheet    = doActionIBSheet    ;
    this.validateSheet      = validateSheet      ;
    this.validateCond       = validateCond       ;
}


// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;
var loadingMode = false;
var sheet_height1 = 13; // sheet1의 height

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
    var sheetObject1 = sheetObjects[0];
    var formObject = document.form;

    try {
        var srcName = window.event.srcElement.getAttribute("name");
        //message("srcName = " + srcName);

        switch(srcName) {

            case "btn_Retrieve":
                doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                break;

            case "btn_Save":
                doActionIBSheet(sheetObject1,formObject,IBSAVE);
                break;

            case "btn_Downexcel":
                doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
                break;

            case "bu_zoom_in1":
                sheet_height1 = getSheetHeightCnt(sheetObject1,"MAX",0);
                sheetObject1.style.height = sheetObject1.GetSheetHeight(sheet_height1);
                div_zoom_in1.style.display = "none";
                div_zoom_out1.style.display = "inline";
                //parent.syncHeight();
                break;

            case "bu_zoom_out1":
                sheet_height1 = 8;
                sheetObject1.style.height = sheetObject1.GetSheetHeight(sheet_height1);
                div_zoom_in1.style.display = "inline";
                div_zoom_out1.style.display = "none";
                //parent.syncHeight();
                break;

            case "btn_Close":
                self.close();
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
 * Sheet 기본 설정 및 초기화
 */
function loadPage() {
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    loadingMode = true;
    doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    for(k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],comboObjects[k].id);
    }
	loadingMode = false;
	document.form.f_yearmonth.focus();
}

 /**
  * 멀티콤보 항목을 설정한다.
  */
 function initCombo(comboObj, comboId) {
 	with (comboObj) {
 		DropHeight = 300;
 		Index = 0;
 	}
 }
/**
 * 시트 초기설정값, 헤더 정의
 */
function initSheet(sheetObj, sheetNo) {
    var cnt = 0;

    switch(sheetNo) {
        case 1:      //sheet1 init
            with (sheetObj) {
                SheetWidth = mainTable1.clientWidth;
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                MergeSheet = msHeaderOnly; //msAll, msPrevColumnMerge, msHeaderOnly, msNone
                Editable = true;
                InitRowInfo(1, 1, 9, 100);
                InitColumnInfo(7, 1, 0, true);
                InitHeadMode(true, true, false, true, false, false)

                var HeadTitle = "STS|YYYY|Trade|R.Lane|IOC|Dir.|Unit Cost";
                InitHeadRow(0, HeadTitle, true);

                InitDataProperty(0, cnt++, dtStatus,   45, daCenter, true, "ibflag");
                InitDataProperty(0, cnt++, dtData,     80, daCenter, true, "cost_yr",         false, "", dfNone,    0, false, true, 4);

                InitDataProperty(0, cnt++, dtData,     60, daCenter, true, "fm_trd_cd",     false, "", dfNone,    0, false, true, 3);
                InitDataProperty(0, cnt++, dtData,     70, daCenter, true, "fm_rlane_cd",   false, "", dfNone,    0, false, true, 5);
                InitDataProperty(0, cnt++, dtData,     50, daCenter, true, "fm_ioc_cd",     false, "", dfNone,    0, false, true, 1);
                InitDataProperty(0, cnt++, dtData,     50, daCenter, true, "fm_skd_dir_cd", false, "", dfNone,    0, false, true, 1);

                InitDataProperty(0, cnt++, dtAutoSum, 230, daRight,  true, "ts_uc_amt",       false, "", dfFloatOrg,   2, true,  true);

                CellBackColor(0, "fm_trd_cd")     = RgbColor(222,251,248);
                CellBackColor(0, "fm_rlane_cd")   = RgbColor(222,251,248);
                CellBackColor(0, "fm_ioc_cd")     = RgbColor(222,251,248);
                CellBackColor(0, "fm_skd_dir_cd") = RgbColor(222,251,248);


                CountPosition  = 0 ;
                style.height = GetSheetHeight(sheet_height1) ;
            }
            break;
    }
}

/**
 * IBSheet Object를 배열로 등록
 */
function setSheetObject(sheet_obj) {
     sheetObjects[sheetCnt++] = sheet_obj;
}
 /**
  * IBCombo Object를 배열로 등록
  * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
  * 배열은 소스 상단에 정의
  */
 function setComboObject(combo_obj){
 	comboObjects[comboCnt++] = combo_obj;
 }



 /**
  * trade코드 변경시 rLane 리스트를 리플래쉬 한다.
  */
 function f_cobtrade_OnChange(obj,value,text) {
 	var formObj = document.form;
 	if (loadingMode == true) return;
 	if ("All"!=value) {
 		var sheetObj = sheetObjects[0];
 		formObj.f_cmd.value = SEARCHLIST02;
 		var sXml = sheetObj.GetSearchXml("ESM_MAS_0159GS2.do", masFormQueryString(formObj));
 		var arrXml = sXml.split("|$$|");
 		if (arrXml.length > 0)
 			ComXml2ComboItem(arrXml[0], formObj.f_coblane, "code", "name");
 		formObj.f_coblane.Index = 0;
 	} else {
 		formObj.f_coblane.RemoveAll();
 		formObj.f_coblane.InsertItem(0, "All", "All");
 		formObj.f_coblane.Index = 0;
 	}
 }

/**
 * year, month, week가 변경되었을때 보여지는 Period를 변경한다.
 */
function setPeriod(obj) {
	 ComMasSetPeriod3(obj);
}

//화면의 Enter-Key 처리
function keyEnter_loc(){
    var sheetObject1 = sheetObjects[0];
    var formObject = document.form;
    if (event.keyCode == 13) {
        doActionIBSheet(sheetObject1,formObject,IBSEARCH);
    }
}

function sheet1_OnSaveEnd(sheetObj,ErrMsg) {
//  if (ErrMsg == "") {
//  }
}

//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg = false;

	    switch(sAction) {
	    case IBCLEAR:          //조회	
	    	sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.f_cmd.value = INIT;
			
			var sXml = sheetObj.GetSearchXml("ESM_MAS_0159GS2.do", masFormQueryString(formObj));
			var arrXml = sXml.split("|$$|");
			if (0 < arrXml.length)
				ComXml2ComboItem(arrXml[0], formObj.f_cobtrade, "code", "name");
			if (1 < arrXml.length)
				ComXml2ComboItem(arrXml[1], formObj.f_coblane, "code", "name");
			if (2 < arrXml.length)
				ComXml2ComboItem(arrXml[2], formObj.f_cobdir, "code", "name");
			if (3 < arrXml.length)
				ComXml2ComboItem(arrXml[3], formObj.f_cobioc, "code", "name");
		
			formObj.f_yearmonth.value = ComGetNowInfo("ym");
			
			ComOpenWait(false);
			break;
        case IBSEARCH:      //조회
            if (validateCond(formObj,sAction)) {
            	// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
                formObj.f_cmd.value = SEARCHLIST01;
                sheetObj.DoSearch4Post("ESM_MAS_0159GS.do", masFormQueryString(formObj,'param1|param2|param3|param4'));
                ComOpenWait(false);
            }
            break;

        case IBSAVE:        // 저장
            if (validateSheet(sheetObj)) {
                if (sheetObj.RowCount > 0) {
                	// 업무처리중 버튼사용 금지 처리
    				sheetObj.WaitImageVisible = false;
    				ComOpenWait(true);
                    formObj.f_cmd.value = MULTI01;
                    sheetObj.DoAllSave("ESM_MAS_0159GS.do", masFormQueryString(formObj,'f_cmd',true));
                    ComOpenWait(false);
                }
            }
            break;

        case IBDOWNEXCEL:   //엑셀 다운로드
        //sheetObj.Down2Excel(-1, false, false, true);
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

// 화면 폼입력값에 대한 유효성검증 프로세스 처리
function validateSheet(sheetObj) {
    with(sheetObj){
    }

    return true;
}

// 화면 조회값에 대한 유효성검증 프로세스 처리
function validateCond(formObj,sAction) {
    with(formObj) {
        // msg1 + '  를(을) 확인하세요.';
        if (ComTrim(f_yearmonth.value) == "") {
            ComAlertFocus(f_yearmonth, ComGetMsg('COM12114','Year-Month'));
            return false;
        }
    }

    return true;
}