/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0123.js
*@FileTitle : Vessel Information
*Open Issues :
*Change history :
* 2007-01-17 Kim Jong Beom
* 2009.10.23 김기대 New FrameWork 적용
* 2010.02.22 이연각 업무처리중 버튼사용 금지 처리
*@LastModifyDate : 2010.02.22
*@LastModifier : 이연각
*@LastVersion : 1.0
=========================================================
* History
* 2007-01-17 Kim Jong Beom
* 2009.10.23 김기대 New FrameWork 적용
* 2010.02.22 이연각 업무처리중 버튼사용 금지 처리
* 2010.04.14 이행지 FormQueryString =>masFormQueryString 변경
=========================================================
*/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends 
 * @class ESM_MAS_0123 : ESM_MAS_0123 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_MAS_0123() {
    this.processButtonClick = processButtonClick ;
    this.loadPage           = loadPage           ;
    this.initSheet          = initSheet          ;
    this.setSheetObject     = setSheetObject     ;
    this.doActionIBSheet    = doActionIBSheet    ;
    this.validateForm       = validateForm       ;
    this.validateCond       = validateCond       ;
}



// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;


/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
    var sheetObject = sheetObjects[0];
    var formObject = document.form;
  
    try {
        var srcName = window.event.srcElement.getAttribute("name");
          
        switch(srcName) {
    
            case "btn_Retrieve":
                doActionIBSheet(sheetObject,formObject,IBSEARCH);
                break;
            
            case "btn_Downexcel":
                doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
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


/* Sheet 기본 설정 및 초기화 */
function loadPage() {
    for (i=0; i<sheetObjects.length; i++) {
    	ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i+1, "");
        ComEndConfigSheet(sheetObjects[i]);
    }
    
    //doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);  //Load시 조회
}


/* 시트 초기설정값, 헤더 정의 */
function initSheet(sheetObj,sheetNo,header) {
    var cnt = 0;
    var HeadTitle = "";

    switch(sheetNo) {
        case 1:      //sheet1 init
            with (sheetObj) {
                style.height = GetSheetHeight(8) ;
                SheetWidth = mainTable.clientWidth;
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                MergeSheet = msHeaderOnly;
                Editable = false;
                InitRowInfo(1, 1, 9, 500);
                InitColumnInfo(7, 1, 0, true);
                InitHeadMode(true, true, false, true, false, false);
                  
                HeadTitle = "STS|Seq|Vessel|Vessel Name|Crr|D.Capa|P.Capa";
                InitHeadRow(0, HeadTitle, true);
                
                cnt = 0;
                InitDataProperty(0, cnt++, dtStatus,    30, daCenter, true, "ibflag");
                InitDataProperty(0, cnt++, dtSeq,       30, daCenter, true, "ibseq");
                  
                InitDataProperty(0, cnt++, dtData,      70, daCenter, true, "vsl_cd",          false,  "", dfNone,    0, true, true);
                InitDataProperty(0, cnt++, dtData,     270, daLeft,   true, "vsl_eng_nm",      false,  "", dfNone,    0, true, true);
                InitDataProperty(0, cnt++, dtData,      50, daCenter, true, "crr_cd",          false,  "", dfNone,    0, true, false);
                InitDataProperty(0, cnt++, dtData,      80, daRight,  true, "cntr_dzn_capa",   false,  "", dfInteger, 0, true, false);
                InitDataProperty(0, cnt++, dtData,      80, daRight,  true, "cntr_vsl_clss_capa",  false,  "", dfInteger, 0, true, false);
                  
                HeadRowHeight = 10;
                CountPosition = 0 ;
                  
                //MassOfSearch = 1; //대용량 조회 (Append방식) 2010.03.30 주석처리
            }
            break;

    }
}


/* IBSheet Object를 배열로 등록 */
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++] = sheet_obj;
}

/* Sheet관련 프로세스 처리 */
function doActionIBSheet(sheetObj,formObj,sAction,PageNo) {
    sheetObj.ShowDebugMsg = false;
  
    switch(sAction) {
  
        case IBSEARCH:      //조회
            if (!validateCond(formObj)) {
               return false;
            }
            // 업무처리중 버튼사용 금지 처리
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
            formObj.f_cmd.value = SEARCHLIST;
            sheetObj.DoSearch4Post("ESM_MAS_0123GS.do", masFormQueryString(formObj));
            ComOpenWait(false);
            break;

        case IBDOWNEXCEL:   //엑셀 다운로드
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

/* 화면 폼입력값에 대한 유효성검증 프로세스 처리 */
function validateForm(sheetObj) {
	with(sheetObj){
	}

	return true;
}

/* 화면 조회값에 대한 유효성검증 프로세스 처리 */
function validateCond(formObj) {
	with(formObj){
	}

	return true;
}

