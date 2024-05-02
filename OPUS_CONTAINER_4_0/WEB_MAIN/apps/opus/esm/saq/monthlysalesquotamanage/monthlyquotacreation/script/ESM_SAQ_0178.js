/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAQ_0178.js
*@FileTitle  : COA I/F Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/10/15
=========================================================*/
/* 개발자 작업 */
// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
    var shtObj = sheetObjects[0];
    var frmObj = document.form;
    //        try {
    var srcName = ComGetEvent("name");
	if(ComGetBtnDisable(srcName)) return false;
    switch (srcName) {
        case "sel_div":
            if (frmObj.sel_div[0].checked) {
                frmObj.slct_yrmon.value = "";
                //Quarter Select 활성화
                frmObj.year.disabled = false;
                frmObj.qtr_cd.disabled = false;
                frmObj.year.className = "input1";
                frmObj.qtr_cd.className = "input1";
                //Cost Year Month 비활성화
                ComEnableManyObjects(false, frmObj.yr101, frmObj.yr102, frmObj.yr103, frmObj.yr104, frmObj.yr105, frmObj.yr106, frmObj.yr107, 
                                                    frmObj.yr108, frmObj.yr109, frmObj.yr110, frmObj.yr111, frmObj.yr112, frmObj.yr201, frmObj.yr202, 
                                                    frmObj.yr203, frmObj.yr204, frmObj.yr205, frmObj.yr206, frmObj.yr207, frmObj.yr208, frmObj.yr209, 
                                                    frmObj.yr210, frmObj.yr211, frmObj.yr212, frmObj.yr301, frmObj.yr302, frmObj.yr303, frmObj.yr304, 
                                                    frmObj.yr305, frmObj.yr306, frmObj.yr307, frmObj.yr308, frmObj.yr309, frmObj.yr310, frmObj.yr311, frmObj.yr312);
            } else {
                //Quarter Select 비활성화
                frmObj.year.disabled = true;
                frmObj.qtr_cd.disabled = true;
                frmObj.year.className = "input2";
                frmObj.qtr_cd.className = "input2";
                //Cost Year Month 활성화
                ComEnableManyObjects(true, frmObj.yr101, frmObj.yr102, frmObj.yr103, frmObj.yr104, frmObj.yr105, frmObj.yr106, frmObj.yr107, 
                                                    frmObj.yr108, frmObj.yr109, frmObj.yr110, frmObj.yr111, frmObj.yr112, frmObj.yr201, frmObj.yr202, 
                                                    frmObj.yr203, frmObj.yr204, frmObj.yr205, frmObj.yr206, frmObj.yr207, frmObj.yr208, frmObj.yr209, 
                                                    frmObj.yr210, frmObj.yr211, frmObj.yr212, frmObj.yr301, frmObj.yr302, frmObj.yr303, frmObj.yr304, 
                                                    frmObj.yr305, frmObj.yr306, frmObj.yr307, frmObj.yr308, frmObj.yr309, frmObj.yr310, frmObj.yr311, frmObj.yr312);
            }
            break;
        case "btn_interface":
            doActionIBSheet(sheetObjects[0], frmObj, IBSAVE);
            break;
        case "btn_close": // close
            ComClosePopup();
            break;
    } // end switch
    //        } catch(e) {
    //            if (e == "[object Error]") {
    //                ComShowMessage(OBJECT_ERROR);
    //            } else {
    //                ComShowMessage(e);
    //            }
    //        }
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
    var frmObj = document.form;
    optionSetting();
    searchYear();
    for (var i = 0; i < sheetObjects.length; i++) {
        // khlee-시작 환경 설정 함수 이름 변경
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        // khlee-마지막 환경 설정 함수 추가
        ComEndConfigSheet(sheetObjects[i]);
    }
    ComEnableManyObjects(false, frmObj.yr101, frmObj.yr102, frmObj.yr103, frmObj.yr104, frmObj.yr105, frmObj.yr106, frmObj.yr107, 
                                        frmObj.yr108, frmObj.yr109, frmObj.yr110, frmObj.yr111, frmObj.yr112, frmObj.yr201, frmObj.yr202, 
                                        frmObj.yr203, frmObj.yr204, frmObj.yr205, frmObj.yr206, frmObj.yr207, frmObj.yr208, frmObj.yr209, 
                                        frmObj.yr210, frmObj.yr211, frmObj.yr212, frmObj.yr301, frmObj.yr302, frmObj.yr303, frmObj.yr304, 
                                        frmObj.yr305, frmObj.yr306, frmObj.yr307, frmObj.yr308, frmObj.yr309, frmObj.yr310, frmObj.yr311, frmObj.yr312);
    setYearMonthObject(frmObj.year, frmObj.qtr_cd);
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : shtObj ==> 시트오브젝트, shtNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(shtObj, shtNo) {
    var cnt = 0;
    with(shtObj) {
        switch (shtObj.id) {
            case "memo_sheet1":
                break;
        }
    }
}
    
// Sheet관련 프로세스 처리
function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
    switch (sAction) {
        case IBSAVE: // Interface 
            chkQtrtoYrmon();
            ComOpenWait(true);
            frmObj.f_cmd.value = MULTI01;
            //parameter changed[check again]CLT                 
            shtObj.GetSaveData("ESM_SAQ_0178GS.do", FormQueryString(frmObj));
            //parameter changed[check again]CLT                 
            var sxml = shtObj.GetSaveData("ESM_SAQ_0178GS.do", FormQueryString(frmObj));
            if (ComGetEtcData(sxml, "TRANS_RESULT_KEY") == "S") {
                ComShowCodeMessage("COM130102", "Data");
            }
            ComOpenWait(false);
            ComClosePopup();
            break;
    }
}

/**
 * 조회 조건의 Year 설정.
 */
function searchYear() {
    var today = new Date();
    var year = today.getFullYear();
    var date = ComGetNowInfo();
    var month = parseInt(date.substring(5, 7), 10);
    var verNo = "";
    var mon = 0;
    var hYear = 0;    
    
    switch (month) {
	    case 12:
	    case 11:
	    case 10:	
		      verNo = year + 1 + '1Q01';
		      hYear = year + 1;
		      mon = 1;
		      break;
	    case 9:
	    case 8:
	    case 7:
		      verNo = year + '4Q01';
		      hYear = year;
		      mon = 10;
		      break;
	    case 6:
	    case 5:
	    case 4:
		      verNo = year + '3Q01';
		      hYear = year;
		      mon = 7;
		      break;
	    case 3:
	    case 2:
	    case 1:
		      verNo = year + '2Q01';
		      hYear = year;
		      mon = 4;
		      break;
    }
    document.form.yr1.value = year;
    document.form.yr2.value = year - 1;
    document.form.yr3.value = year - 2;
    document.form.h_yr1.value = year;
    document.form.h_yr2.value = year - 1;
    document.form.h_yr3.value = year - 2;
    document.form.h_ver_no.value = verNo.substring(2, 8);
    document.form.h_mon.value = mon;
    document.form.h_year.value = hYear;
}

/**
 * check 된 월을 text area 에 setting
 */
function chkMon() {
    var formObj = document.form;
    var j = 0;
    var len = form.elements.length;
    var nameArr = new Array();
    var valueArr = new Array();
    for (i = 0; i < len; i++) {
        switch (form.elements[i].type) {
            case "checkbox":
                if (form.elements[i].checked == true) {
                    if (form.elements[i].name.substring(0, 3) == "yr1") {
                        valueArr[j] = formObj.yr1.value + form.elements[i].value;
                    } else if (form.elements[i].name.substring(0, 3) == "yr2") {
                        valueArr[j] = formObj.yr2.value + form.elements[i].value;
                    } else if (form.elements[i].name.substring(0, 3) == "yr3") {
                        valueArr[j] = formObj.yr3.value + form.elements[i].value;
                    }
                    name[j] = form.elements[i].name;
                    j++;
                }
                break;
        }
    }
    document.form.slct_yrmon.value = valueArr.toString();
}

/**
 * 선택된 Quarter 를 월로 변환
 */
function chkQtrtoYrmon() {
    var month = getQuarterToMonth(document.form.qtr_cd.value);
    var months = [month, month + 1, month + 2];
    for (var i = 0; i < months.length; i++) {
        if (months[i] < 10) {
            months[i] = "0" + months[i];
        }
    }
    document.form.stat_mon.value = month;
    document.form.h_months.value = months.toString();
}

/**
 * 조회 조건의 Year 설정.
 */
function SaqSearchYearCombo(elemName) {
    var objs = document.getElementsByName(elemName);
    var today = new Date();
    var year = today.getFullYear();
    var post = 5;
    for (var j = 0; j < objs.length; j++) {
        var obj = objs.item(j);
        for (var i = year; i > year - post; i--) {
            newOpt = document.createElement("OPTION");
            newOpt.text = i;
            newOpt.value = i;
            obj.add(newOpt);
        }
    }
    // default 값 현재 년도 setting
    if (objs.length == 1) obj.value = year;
}

/**
 * option setting
 */
function optionSetting() {
    SaqSearchYearCombo("year");
    SaqSearchOptionQuarter("qtr_cd");
}
/* 개발자 작업 끝 */