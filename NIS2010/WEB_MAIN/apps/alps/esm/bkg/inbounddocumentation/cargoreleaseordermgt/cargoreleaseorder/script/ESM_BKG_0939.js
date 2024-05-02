﻿/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0939.js
 *@FileTitle : India Cargo Release Performance
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.18
 *@LastModifier : 박만건
 *@LastVersion : 1.0
 * 2009.08.18 박만건
 * 1.0 Creation
 * ------------------------------------------------------
 * History
 * 2012.05.08 김보배 [CHM-201217621] [BKG] India Cargo Release Performance 기능 보완
 * 2012.07.23 김보배 [CHM-201219143] [BKG] India Cargo Release Performance 기능 보완 요청
 =========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview India Cargo Release Performance 에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author 한진해운
 */

/**
 * @extends
 * @class esm_bkg_0939
 */
function esm_bkg_0939() {
    this.processButtonClick     = tprocessButtonClick;
    this.setSheetObject         = setSheetObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;
    this.initControl            = initControl;
    this.doActionIBSheet        = doActionIBSheet;
    this.setTabObject           = setTabObject;
    this.validateForm           = validateForm;
}

/* 개발자 작업  */

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return {void}
 * @author Park Mangeon
 * @version 2009.10.01
 */
function processButtonClick(){
     /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
     var sheetObject = sheetObjects[0];
     //var sheetObject = sheetObjects[1];

     /*******************************************************/
     var formObject = document.form;

    try {
        var srcName = window.event.srcElement.getAttribute("name");

        switch(srcName) {
            case "btn_Retrieve":
                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"","");
                break;

            case "btn_DownExcelWeeklyReport":
                // monthly total이 0일경우 다운로드 받을 수 없다.
                if(sheetObjects[0].CellValue(4, "monthly") == 0){ return;}
                sheetObjects[0].Down2Excel();
            break;

            case "btn_DownExcelDoRlseList":
                sheetObjects[1].SpeedDown2Excel();
            break;

            case "btn_CargoRelease":
                fnMoveToFullCntrRelease(sheetObjects[1]);
            break;

            case "btn_evnt_dt":
				formObject.rd_flag[0].checked = true;
				fnSetUpUIByRdFlag();
                var cal = new ComCalendarFromTo();
                cal.select(formObject.evnt_dt_fm, formObject.evnt_dt_to, 'yyyy-MM-dd');
                break;
                
            case "btn_evnt_dt_ym":
				formObject.rd_flag[1].checked = true;
				fnSetUpUIByRdFlag();
                var cal = new ComCalendar();
                cal.setDisplayType('month');
                cal.select(formObject.evnt_dt_ym, 'yyyy-MM');
                break;
                
        } // end switch
    }catch(e) {
        if( e == "[object Error]") {
            ComShowMessage(OBJECT_ERROR);
        } else {
            ComShowMessage(e);
        }
    }
}

/**
 * IBSheet Object를 배열로 등록<br>
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
 * 배열은 소스 상단에 정의<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheet_obj 필수, Sheet개체
 * @return {void}
 * @author Park Mangeon
 * @version 2009.10.01
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++] = sheet_obj;
}



/**
 * Sheet 기본 설정 및 초기화<br>
 * body 태그의 onLoad 이벤트핸들러 구현<br>
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return {void}
 * @author Park Mangeon
 * @version 2009.10.01
 */
function loadPage() {
	var formObj = document.form;
	fnSetComboBox(formObj.dmdt_pay_tp_cd, gDmdtCode, gDmdtValue, "|", "", "ALL", true, "");
    
	for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    fnSetUpUIByRdFlag();
    initControl();
    
}

/**
 * 초기화 작업 : 이벤트를 등록한다.<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function initControl() {
    axon_event.addListenerForm('click', 'objClick', form );     //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
    axon_event.addListenerForm('keypress', 'objKeyPress', form);
    
//    var formObj = document.form;
//    form.evnt_ofc_cd.value = strOfcCd;
}

/**
 * form object 클릭 이벤트를 처리한다.<br>
 * @param {void}
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function objClick() {
    var objName = event.srcElement.name;
    var formObj = document.form;
    switch(objName) {
        case "rd_flag":
            fnSetUpUIByRdFlag();
            break;
        case "evnt_dt_fm":
        	formObj.rd_flag[0].checked = true;
        	fnSetUpUIByRdFlag();
        	break;
        case "evnt_dt_to":
        	formObj.rd_flag[0].checked = true;
        	fnSetUpUIByRdFlag();
        	break;
        case "evnt_dt_ym":
        	formObj.rd_flag[1].checked = true;
        	fnSetUpUIByRdFlag();
        	break;
        	
    }
}

 
/**
 * 개체에서 키보드를 눌렀을때 발생하는 이벤트를 처리<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function objKeyPress() {
    var objName = event.srcElement.name;
    var formObj = document.form;
    switch(objName) {
        case "evnt_ofc_cd":
	        ComKeyOnlyAlphabet('upper');
            break;
	    case "evnt_dt_fm":
	   	    obj_KeyPress(event.srcElement);
		    break;
	    case "evnt_dt_to":
	   	    obj_KeyPress(event.srcElement);
		    break;
	    case "evnt_dt_ym":
	   	    obj_KeyPress(event.srcElement);
		    break;
        case "bl_no":
	        ComKeyOnlyAlphabet('uppernum');
            break;
        case "cntr_no":
	        ComKeyOnlyAlphabet('uppernum');
            break;
    }
}

/**
 * 시트 초기설정값, 헤더 정의<br>
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호<br>
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj 필수, Sheet개체
 * @param {int} sheetNo 필수, Sheet Index
 * @return {void}
 * @author Park Mangeon
 * @version 2009.10.01
 */
function initSheet(sheetObj,sheetNo) {

    var cnt = 0;
    var sheetId = sheetObj.id;

    switch(sheetId) {

        case "sheet2":
            with (sheetObj) {

                // 높이 설정
                style.height = 282;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = false;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 15, 100);

                var HeadTitle1 = "No.|Type|B/L No|HB/L No.|Container No|POD|DEL|Ultimate Consignee|Receipt Company|D/O No|Validity Date|Release Date|Release Office|Staff ID";
                var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);

                //데이터속성    [ROW, COL,  DATATYPE,  WIDTH, DATAALIGN, COLMERGE,  SAVENAME,                  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtSeq,     50,    daCenter,    true,   "Seq");
                InitDataProperty(0, cnt++ , dtData,    100,   daCenter,    true,   "dmdt_pay_tp_cd_desc", false,        "",        dfNone,      0,        false,        false);
                InitDataProperty(0, cnt++ , dtData,    100,   daCenter,    true,   "bl_no",                    false,        "",        dfNone,      0,        false,        false);
                InitDataProperty(0, cnt++ , dtData,    100,   daCenter,    true,   "hbl_no",                    false,        "",        dfNone,      0,        false,        false);
                InitDataProperty(0, cnt++ , dtData,    100,   daCenter,    true,   "cntr_no",                  false,        "",        dfNone,      0,        false,        false);
                InitDataProperty(0, cnt++ , dtData,    100,   daCenter,    true,   "pod_cd",                   false,        "",        dfNone,      0,        false,        false);
                InitDataProperty(0, cnt++ , dtData,    100,   daCenter,    true,   "del_cd",                   false,        "",        dfNone,      0,        false,        false);
                InitDataProperty(0, cnt++ , dtData,    150,   daCenter,    true,   "rcvr_cnee_nm",                   false,        "",        dfNone,      0,        false,        false);
                InitDataProperty(0, cnt++ , dtData,    150,   daCenter,    true,   "rcvr_co_nm",                   false,        "",        dfNone,      0,        false,        false);
                InitDataProperty(0, cnt++ , dtData,    100,   daCenter,    true,   "do_no",                    false,        "",        dfNone,      0,        false,        false);
                InitDataProperty(0, cnt++ , dtData,    100,   daCenter,    true,   "do_vty_dt",                false,        "",        dfNone,      0,        false,        false);
                InitDataProperty(0, cnt++ , dtData,    120,   daCenter,    true,   "evnt_dt",                  false,        "",        dfTimeHm,   0,        false,        false);
                InitDataProperty(0, cnt++ , dtData,    100,   daCenter,    true,   "evnt_ofc_cd",              false,        "",        dfNone,      0,        false,        false);
                InitDataProperty(0, cnt++ , dtData,    0,     daCenter,    true,   "evnt_usr_id",              false,        "",        dfNone,      0,        false,        false);

                CountPosition = 0;
                
                MultiSelection = false;
                WaitImageVisible = false;
        }
        break;

         case "sheet1":
            with (sheetObj) {
                
                //AutoSizeMode=false;
                
                // 높이 설정
                //style.height = 100;
                //전체 너비 설정
                //SheetWidth = mainTable.clientWidth;
                SheetWidth = 989;
                //alert(SheetWidth);
                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = false;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 5, 100);

                var HeadTitle1 = "|1ST Week|2ND Week|3Rd Week|4th Week|5th Week|Monthly";
                var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 1, true);
                //Rows = 5;
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, false, false, false, false,false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);

                //데이터속성    [ROW, COL,  DATATYPE,        WIDTH, DATAALIGN,    COLMERGE,    SAVENAME,                       KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtData,            142,        daCenter,    true,        "dmdt_pay_tp_cd_desc");
                InitDataProperty(0, cnt++ , dtData,            142,        daCenter,    true,        "first_wk",                false,        "",        dfInteger,            0,        true,        true);
                InitDataProperty(0, cnt++ , dtData,            142,        daCenter,    true,        "second_wk",            false,        "",        dfInteger,            0,        true,        true);
                InitDataProperty(0, cnt++ , dtData,            142,        daCenter,    true,        "third_wk",                false,        "",        dfInteger,            0,        true,        true);
                InitDataProperty(0, cnt++ , dtData,            142,        daCenter,    true,        "forth_wk",                false,        "",        dfInteger,            0,        true,        true);
                InitDataProperty(0, cnt++ , dtData,            142,        daCenter,    true,        "fifth_wk",                false,        "",        dfInteger,            0,        true,        true);
                InitDataProperty(0, cnt++ , dtData,            0,          daCenter,    true,        "monthly",                false,        "",        dfInteger,            0,        true,        true);

                CountPosition = 0;

                //해더컬럼정보[선택][컬럼,표시글자,컬럼정렬]
                InitHeadColumn("dmdt_pay_tp_cd_desc", "General|Extension|Examination|Total", daCenter);
                
                MultiSelection = false;
                WaitImageVisible = false;
        }
        break;
    }
}

/**
 * Sheet관련 프로세스 처리<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj 필수, Sheet
 * @param {Object} formObj 필수, form객체
 * @param {int} sAction 필수, 작업처리코드
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function doActionIBSheet(sheetObj,formObj,sAction,CondParam,PageNo) {
    //sheetObj.ShowDebugMsg = false;
    
    switch(sAction) {

      case IBSEARCH:      //조회
             if(!validateForm(sheetObj,formObj,sAction)) {return;}
             
             if(formObj.rd_flag[0].checked == true) {
             	if (!ComBkgMonthsBetweenCheck(formObj.evnt_dt_fm.value, formObj.evnt_dt_to.value, 1, "-")) {
             		// only less than {?msg1}-month periods allowed
             		ComShowCodeMessage("BKG40013", "1");
             		return;
             	}
             }
             
             formObj.f_cmd.value = SEARCH;
             ComOpenWait(true);
             var sXml = sheetObj.GetSearchXml("ESM_BKG_0939GS.do" , FormQueryString(formObj),"page_no=1", false);
             var sXmlArr = sXml.split("|$$|");
             sheetObjects[0].LoadSearchXml(sXmlArr[0], false);
             sheetObjects[1].LoadSearchXml(sXmlArr[1], false);
             ComOpenWait(false);
             
          break;
          
//      case IBSEARCHAPPEND:
//            sheetObj.DoSearch("ESM_BKG_0939GS.do"
//                    , CondParam 
//                    ,"page_no=" + PageNo
//                    , true
//             );
//            break;
    }
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리를 수행<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj 필수, Sheet
 * @param {Object} formObj 필수, Form 객체
 * @param {int} sAction 필수, 처리할 작업 코드
 * @return boolean 유효성 여부
 * @author Park Mangeon
 * @version 2009.10.01
 */
function validateForm(sheetObj,formObj,sAction){
    if(!ComChkValid(formObj)) return false;
    return true;
}


/**
 * 조회후 Row 값의 Sum을 설정한다.<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj 필수, Sheet개체
 * @param {String} errStr 필수, 메시지 문자열
 * @returns void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    var row = sheetObj.LastRow;
    for(var col=1; col<=sheetObj.LastCol; col++) {
        sheetObj.CellValue2(row,col) = sheetObj.ComPuteSum("|" + col +"|");
    }
}
        
/**
 * radio버튼에 따라 상단 조회조건 상태를 변경한다.<br>
 * @param {void}
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function fnSetUpUIByRdFlag() {
    var formObj = document.form;
    with(formObj) {
        if(rd_flag[0].checked == true) { // F
            document.getElementsByName("evnt_dt_fm")[0].setAttribute("required", true);
            document.getElementsByName("evnt_dt_to")[0].setAttribute("required", true);
            document.getElementsByName("evnt_dt_ym")[0].removeAttribute("required");
            
        } else {
            document.getElementsByName("evnt_dt_fm")[0].removeAttribute("required");
            document.getElementsByName("evnt_dt_to")[0].removeAttribute("required");
            document.getElementsByName("evnt_dt_ym")[0].setAttribute("required", true);
        }
    }
}        

/**
 * Full Release Container화면으로 이동한다.<br>
 * @param {Object} sheetObj 필수, Sheet 객체
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function fnMoveToFullCntrRelease(sheetObj) {
    var sRowStr = sheetObj.GetSelectionRows("|");
    
    var sRowArr = sRowStr.split("|");
    if(sRowArr.length > 1){
        //alert("다중 선택을 할수 없습니다.");
        ComShowCodeMessage("BKG00362");
        return;
    }
    
    var blNo = "";
    if (sRowStr != "0" ) {
        blNo = sheetObj.CellValue(sRowArr[0], "bl_no");
    }
    
    var goUrl = "";
    var param = "";
    goUrl = "/hanjin/ESM_BKG_0680.do?";
    param += "mainPage=true"
    param += "&pgmNo=ESM_BKG_0680";
    if (blNo != "") {
        param += "&bl_no=" + blNo;
    }
    
    //선택되지 않을경우는 No Action
    location.href=goUrl + param;
}

 /**
  * Sheet를 초기화 하는 함수
  * <br><b>Example : </b>
  * <pre>
  * </pre>
  * @param {int} idx 필수, Sheet의 인덱스
  * @return {void}
  * @author Park Mangeon
  * @version 2009.10.01
  */
 function fnSetComboBox(element, codes, values, splitChr, othCode, othValue, bOthAppendFirst, initValue) {
     var bComboExists = false;

     for(var i=element.options.length;i >= 0;i--){
     	element.remove(i);
     }          

     if (othCode != undefined && othCode != null ){
     	if (bOthAppendFirst) {
 	        var othCodeArr = othCode.split(splitChr);
 	        var othValueArr = othValue.split(splitChr);
 	        for(var m=0; m<othCodeArr.length; m++) {
 	            var oOption = document.createElement("OPTION");
 	            element.options.add(oOption);                     
 	            oOption.innerText = othValueArr[m];       
 	            oOption.value = othCodeArr[m];     
 	            if(initValue == othCodeArr[m]){
 	                oOption.selected = true;
 	                bComboExists = true;
 	            }
 	        }

     	}
     }


     var codeArr = codes.split(splitChr);
     var valueArr = values.split(splitChr);

     for(var m=0; m<codeArr.length -1; m++) {
         var oOption = document.createElement("OPTION");
         element.options.add(oOption);                     
         oOption.innerText = valueArr[m];       
         oOption.value = codeArr[m];     
         if(initValue == codeArr[m]){
             oOption.selected = true;
             bComboExists = true;
         }
     }

     if (othCode != undefined && othCode != null ){
     	if (!bOthAppendFirst) {
 	        var othCodeArr = othCode.split(splitChr);
 	        var othValueArr = othValue.split(splitChr);

 	        for(var m=0; m<othCodeArr.length; m++) {
 	            var oOption = document.createElement("OPTION");
 	            element.options.add(oOption);                     
 	            oOption.innerText = othValueArr[m];       
 	            oOption.value = othCodeArr[m];     
 	            if(initValue == othCodeArr[m]){
 	                oOption.selected = true;
 	                bComboExists = true;
 	            }
 	        }

     	}
     }

     if (!bComboExists) {
     	element.value = valueArr[0];
     }
     
 }

/* 개발자 작업  끝 */