﻿/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0414.js
 *@FileTitle : Pick-Up Notice Sent History
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.08
 *@LastModifier : 박만건
 *@LastVersion : 1.0
 * 2009.10.08 박만건
 * 1.0 Creation
 =========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
  * @fileoverview Pick-Up Notice Sent History에서 공통으로 사용하는 자바스크립트 함수가 정의되어 있다.
  * @author Park Mangeon
  */

/**
 * @extends 
 * @class esm_bkg_0414 : esm_bkg_0414 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0414() {
    this.processButtonClick     = tprocessButtonClick;
    this.setSheetObject         = setSheetObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;
    this.initControl            = initControl;
    this.doActionIBSheet        = doActionIBSheet;
    this.setTabObject           = setTabObject;
    this.validateForm           = validateForm;
    this.obj_keypress           = obj_keypress;
    this.setComboObject         = setComboObject;
}
    
       /* 개발자 작업    */



//공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var sheetNames   = new Array("sheet1", "sheet2");
var sheetInits   = new Array(   false,    false);

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
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
      
    var sheetObject1 = sheetObjects[0];

    /*******************************************************/
    var formObject = document.form;

    //try {
    var srcName = window.event.srcElement.getAttribute("name");
    if (!ComIsBtnEnable(srcName)){ return; }
    switch(srcName) {
	    case "btn_snd_dt":
	        var cal = new ComCalendarFromTo();
		    formObject.sch_tp[0].checked = true;
		    fnToggleSchTp("D", formObject);
		    cal.select(formObject.snd_dt_fm, formObject.snd_dt_to, 'yyyy-MM-dd');
	 	    break;
        case "btn_Retrieve":
            doActionIBSheet(sheetObject1,formObject,IBSEARCH);
            break;
            
        case "btn_DownExcel":
        	doActionIBSheet(sheetObjects[1],formObject,IBDOWNEXCEL,"","");
        	break;
        
        case "btn_PkupSend":
        	fnMoveToPkupSend(sheetObjects[0], formObject);
        	break;
           
        case "btn_Print":
        	fnPrintSheet(sheetObjects[0]);
        	break;
        	
        case "btn_MasterData":
        	doActionIBSheet(sheetObjects[0],formObject,IBSEARCH_ASYNC10);
        	break;
        	
        case "btn_UsIor":
        	doActionIBSheet(sheetObjects[0],formObject,IBSEARCH_ASYNC11);
        	break;
        	

    } // end switch
        //}catch(e) {
        //    if( e == "[object Error]") {
        //        ComShowMessage(OBJECT_ERROR);
        //    } else {
        //        ComShowMessage(e);
        //    }
        //}
}

/**
 * IBSheet Object를 배열로 등록<br>
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
 * 배열은 소스 상단에 정의<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheet_obj 필수, 등록할 개체
 * @return void 
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

    for(i=0;i<sheetNames.length;i++){
    	if(sheetNames[i] == "sheet1") {
    		sheetInit(i);
        }
    }

    initControl();
    
    if (parAutoSearchFlg == "Y") {
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
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
function sheetInit(idx) {
	if (sheetInits[idx] == false) {
        ComConfigSheet (sheetObjects[idx] );
        initSheet(sheetObjects[idx],idx+1);
        ComEndConfigSheet(sheetObjects[idx]);
        sheetInits[idx] = true;
    }
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
function sheetInit(idx) {
	if (sheetInits[idx] == false) {
        ComConfigSheet (sheetObjects[idx] );
        initSheet(sheetObjects[idx],idx+1);
        ComEndConfigSheet(sheetObjects[idx]);
        sheetInits[idx] = true;
    }
}
 
/**
 * 초기화 작업 : 이벤트를 등록한다.<br><br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function initControl() {
    //Axon 이벤트 처리1. 이벤트catch
    //대문자로 변경
    axon_event.addListenerForm('click', 'objClick', form );     //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
    axon_event.addListenerForm('change', 'objChange', form );
    axon_event.addListenerForm ('keypress', 'objKeyPress', form);
    var formObj = document.form;
   
    if(strCnt_cd.indexOf('US') == 0){
    	formObj.ofc_cd.value = "PHXSA";  // default office - login office
    }else{
    	formObj.ofc_cd.value = strOfc_cd;  // default office - login office
    }
   
    // calendar 처리 (from은 3주전, to는 오늘)
    formObj.snd_dt_to.value=ComGetNowInfo('ymd','-');
    formObj.snd_dt_fm.value=ComGetDateAdd(null, 'd', -6, '-');
   
    // 버튼처리
    if (strCnt_cd== null || strCnt_cd != "US") {
	    ComBtnDisable("btn_PrePickup");
	    ComBtnDisable("btn_PreHold");
    }
   
    /* PARAMETER VARIABLE INIT */
    if (parSchTp != "") {
    	for (var idx = 0; idx < formObj.sch_tp.length; idx ++ ) {
    		if (formObj.sch_tp[idx].value == parSchTp) {
    			formObj.sch_tp[idx].checked = true;
    			break;
    		}
    	}
    }
    
    if (parBlNo != "") {
    	formObj.bl_no.value = parBlNo;
    }
    
    var schTp = "";
   
    for (var idx = 0; idx < formObj.sch_tp.length; idx++) {
	    if (formObj.sch_tp[idx].checked == true) {
		    schTp = formObj.sch_tp[idx].value;
		    break;
	    }
    }
   
    if (schTp == "") {
	    formObj.sch_tp[1].checked = true;
	    schTp = formObj.sch_tp[1].value;
    }
    fnToggleSchTp(schTp, formObj);
   
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
	var sheetID = sheetObj.id;
	switch (sheetID) {
        case "sheet1":
            with (sheetObj) {
            // 높이 설정
            style.height = 430;
            //전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

            //전체Edit 허용 여부 [선택, Default false]
            Editable = true;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(1, 1, 3, 200);

            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(28, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, false, true, false,false);

            var HeadTitle1 = "|Seq.|B/L No.|Container No.|Type|MVMT|Update Date|F|O|C|Pick No|Verify|Sent Result|Sent Result|Fax/E-mail Address|Sent RQST|Final Sent|TP|||Code|Customer|Send\nOFC|Send ID|User Name|||";

            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);

            //데이터속성    [ROW, COL,  DATATYPE,     WIDTH, DATAALIGN, COLMERGE,  SAVENAME,              KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++ , dtHiddenStatus,  40,  daCenter,    true,   "ibFlag");
            InitDataProperty(0, cnt++ , dtSeq,           30,  daCenter,    true,   "Seq");
            InitDataProperty(0, cnt++ , dtData,          90,  daCenter,    true,   "bl_no",                 false,        "",    dfNone,        0,        false,    false);
            InitDataProperty(0, cnt++ , dtData,          90,  daCenter,    true,   "cntr_no",               false,        "",    dfNone,        0,        false,    false);
            InitDataProperty(0, cnt++ , dtData,          70,  daCenter,    true,   "ntc_knd_cd_desc",       false,        "",    dfNone,        0,        false,    false);
            InitDataProperty(0, cnt++ , dtData,          50,  daCenter,    true,   "edi_322_mvmt_cd",       false,        "",    dfNone,        0,        false,    false);
            InitDataProperty(0, cnt++ , dtData,         110,  daCenter,    true,   "pkup_ntc_evnt_dt",      false,        "",    dfUserFormat2, 0,        false,    false);
            InitDataProperty(0, cnt++ , dtData,          25,  daCenter,    true,   "frt_clt_flg",           false,        "",    dfNone,        0,        false,    false);
            InitDataProperty(0, cnt++ , dtData,          25,  daCenter,    true,   "obl_clt_flg",           false,        "",    dfNone,        0,        false,    false);
            InitDataProperty(0, cnt++ , dtData,          25,  daCenter,    true,   "cstms_clr_flg",         false,        "",    dfNone,        0,        false,    false);
            InitDataProperty(0, cnt++ , dtData,          70,  daCenter,    true,   "pkup_no",               false,        "",    dfNone,        0,        false,    false);
            InitDataProperty(0, cnt++ , dtCheckBox,      50,  daCenter,    true,   "mnl_flg",               false,        "",    dfNone,        0,        false,    false);
            
            InitDataProperty(0, cnt++ , dtData,          20,  daCenter,    true,   "bkg_ntc_snd_rslt_cd",   false,        "",    dfNone,        0,        false,    false);
            InitDataProperty(0, cnt++ , dtData,         200,  daLeft,      true,   "bkg_ntc_snd_rslt_ctnt", false,        "",    dfNone,        0,        false,    false);
            InitDataProperty(0, cnt++ , dtData,         150,  daLeft,      true,   "ntc_fax_no_eml",        false,        "",    dfNone,        0,        false,    false);
            InitDataProperty(0, cnt++ , dtData,         100,  daCenter,    true,   "snd_rqst_dt",           false,        "",    dfNone,        0,        false,    false);
            InitDataProperty(0, cnt++ , dtData,         100,  daCenter,    true,   "snd_dt",                false,        "",    dfNone,        0,        false,    false);
            
            InitDataProperty(0, cnt++ , dtData,          40,  daCenter,    true,   "cust_tp_cd",            false,        "",    dfNone,        0,        false,    false);
            InitDataProperty(0, cnt++ , dtHidden,        20,  daCenter,    true,   "cust_cnt_cd",           false,        "",    dfNone,        0,        false,    false);
            InitDataProperty(0, cnt++ , dtHidden,        40,  daCenter,    true,   "cust_seq",              false,        "",    dfNone,        0,        false,    false);
            InitDataProperty(0, cnt++ , dtData,          60,  daCenter,    true,   "cust_cd",               false,        "",    dfNone,        0,        false,    false);
            InitDataProperty(0, cnt++ , dtData,         215,  daLeft,      true,   "cust_nm",               false,        "",    dfNone,        0,        false,    false);
            
            InitDataProperty(0, cnt++ , dtData,          50,  daCenter,    true,   "snd_ofc_cd",            false,        "",    dfNone,        0,        false,    false);
            InitDataProperty(0, cnt++ , dtData,          80,  daCenter,    true,   "snd_usr_id",            false,        "",    dfNone,        0,        false,    false);
            InitDataProperty(0, cnt++ , dtData,         150,  daLeft,      true,   "usr_nm",                false,        "",    dfNone,        0,        false,    false);
            InitDataProperty(0, cnt++ , dtHidden,         0,  daLeft,      true,   "bkg_no",                false,        "",    dfNone,        0,        false,    false);
            InitDataProperty(0, cnt++ , dtHidden,         0,  daLeft,      true,   "ntc_seq" ,              false,        "",    dfNone,        0,        false,    false);
            
            InitDataProperty(0, cnt++ , dtHidden,         0,  daLeft,      true,   "snd_gdt",               false,        "",    dfNone,        0,        false,    false);

            MultiSelection = false;
            WaitImageVisible = false;
            AutoRowHeight = false;
            
            InitUserFormat2(0, "pkup_ntc_evnt_dt", "####-##-## ##:##", "-|:" );
        }
        break;
        
        case "sheet2":
            with (sheetObj) {
            // 높이 설정
            style.height = 0;
            //전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

            //전체Edit 허용 여부 [선택, Default false]
            Editable = true;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(1, 1, 3, 100);

            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(22, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, false, true, false,false);

            var HeadTitle1 = "Seq.|B/L No.|Container No.|Type|MVMT|Update Date|F|O|C|Pick No|Verify|Sent Result|Sent Result|Fax/E-mail Address|Sent RQST|Final Sent|TP|Code|Customer|Send\nOFC|Send ID|User Name";

            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);

            //데이터속성    [ROW, COL,  DATATYPE,     WIDTH, DATAALIGN, COLMERGE,  SAVENAME,              KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++ , dtSeq,           30,  daCenter,    true,   "Seq");
            InitDataProperty(0, cnt++ , dtData,          90,  daCenter,    true,   "bl_no",                 false,        "",    dfNone,        0,        false,    false);
            InitDataProperty(0, cnt++ , dtData,          90,  daCenter,    true,   "cntr_no",               false,        "",    dfNone,        0,        false,    false);
            InitDataProperty(0, cnt++ , dtData,         110,  daCenter,    true,   "ntc_knd_cd_desc",       false,        "",    dfNone,        0,        false,    false);
            InitDataProperty(0, cnt++ , dtData,          50,  daCenter,    true,   "edi_322_mvmt_cd",       false,        "",    dfNone,        0,        false,    false);
            InitDataProperty(0, cnt++ , dtData,         110,  daCenter,    true,   "pkup_ntc_evnt_dt",      false,        "",    dfUserFormat2, 0,        false,    false);
            InitDataProperty(0, cnt++ , dtData,          25,  daCenter,    true,   "frt_clt_flg",           false,        "",    dfNone,        0,        false,    false);
            InitDataProperty(0, cnt++ , dtData,          25,  daCenter,    true,   "obl_clt_flg",           false,        "",    dfNone,        0,        false,    false);
            InitDataProperty(0, cnt++ , dtData,          25,  daCenter,    true,   "cstms_clr_flg",         false,        "",    dfNone,        0,        false,    false);
            InitDataProperty(0, cnt++ , dtData,          70,  daCenter,    true,   "pkup_no",               false,        "",    dfNone,        0,        false,    false);
            InitDataProperty(0, cnt++ , dtCheckBox,      50,  daCenter,    true,   "mnl_flg",               false,        "",    dfNone,        0,        false,    false);

            InitDataProperty(0, cnt++ , dtData,          20,  daCenter,    true,   "bkg_ntc_snd_rslt_cd",   false,        "",    dfNone,        0,        false,    false);
            InitDataProperty(0, cnt++ , dtData,         200,  daLeft,      true,   "bkg_ntc_snd_rslt_ctnt", false,        "",    dfNone,        0,        false,    false);
            InitDataProperty(0, cnt++ , dtData,         150,  daLeft,      true,   "ntc_fax_no_eml",        false,        "",    dfNone,        0,        false,    false);
            InitDataProperty(0, cnt++ , dtData,         100,  daCenter,    true,   "snd_rqst_dt",           false,        "",    dfNone,        0,        false,    false);
            InitDataProperty(0, cnt++ , dtData,         100,  daCenter,    true,   "snd_dt",                false,        "",    dfNone,        0,        false,    false);
            
            InitDataProperty(0, cnt++ , dtData,          40,  daCenter,    true,   "cust_tp_cd",            false,        "",    dfNone,        0,        false,    false);
            InitDataProperty(0, cnt++ , dtData,          60,  daCenter,    true,   "cust_cd",              false,        "",    dfNone,        0,        false,    false);
            InitDataProperty(0, cnt++ , dtData,         215,  daCenter,    true,   "cust_nm",              false,        "",    dfNone,        0,        false,    false);
            
            InitDataProperty(0, cnt++ , dtData,          50,  daCenter,    true,   "snd_ofc_cd",            false,        "",    dfNone,        0,        false,    false);
            InitDataProperty(0, cnt++ , dtData,          80,  daCenter,    true,   "snd_usr_id",            false,        "",    dfNone,        0,        false,    false);
            InitDataProperty(0, cnt++ , dtData,         150,  daLeft,      true,   "usr_nm",                false,        "",    dfNone,        0,        false,    false);
            
            InitUserFormat2(0, "pkup_ntc_evnt_dt", "####-##-## ##:##", "-|:" );
            
        }
        break;

    }
}

/**
 * Sheet관련 프로세스 처리<br><br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj 필수, Sheet
 * @param {Object} formObj 필수, form객체
 * @param {int} sAction 필수, 작업처리코드
 * @param {String} CondParam 필수, 서버전송 정보
 * @param {int} PageNo 선택, 페이지 번호
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function doActionIBSheet(sheetObj,formObj,sAction,CondParam,PageNo) {
    //sheetObj.ShowDebugMsg = false;
    switch(sAction) {

        case IBSEARCH:      //조회
        
            if (validateForm(sheetObj, formObj, sAction) == false) break;

        	ComOpenWait(true);
            formObj.f_cmd.value = SEARCH;
            sheetObj.DoSearch("ESM_BKG_0414GS.do"
                   ,FormQueryString(formObj)
                   , "page_no=1"
                   , false
                   );
               
               //조회 완료이벤트 발생후 로직처리필요.(sheet1_OnSearchEnd 함수로 이동)
            break;
            
        case IBSEARCHAPPEND:
        	ComOpenWait(true);
            sheetObj.DoSearch("ESM_BKG_0414GS.do"
                   , CondParam + "&mtch_chk_flg=N"
                   ,"page_no=" + PageNo
                   , true
            );
            break;

        case IBDOWNEXCEL:   // EXCEL 다운로드
            if (validateForm(sheetObj, formObj, sAction) == false) break;
        
        	formObj.f_cmd.value = SEARCH;
	        ComOpenWait(true);
	    	sheetInit(1);
	    	sheetObj.DoSearch("ESM_BKG_0414GS.do"
	              , FormQueryString(formObj)  + "&excel_flg=Y"
	             );
            break;
     
            
        case IBSEARCH_ASYNC10:
        	if (sheetObj.RowCount == 0) {
     	    	ComShowCodeMessage("BKG00395"); 
    	        break;
    	    }

     	    var sRowStr = sheetObj.GetSelectionRows("/");

        	//자바 스크립트 배열로 만들기
        	var arr = sRowStr.split("/");
           	if (arr.length > 1) {
        		ComShowCodeMessage("BKG40075");
        		break;
        	}

        	var param = "&autoSearchFlg=Y" +
        		        "&cust_cnt_cd=" + sheetObj.CellValue(arr[0], "cust_cnt_cd") +
        	            "&cust_seq=" + ComLpad(sheetObj.CellValue(arr[0], "cust_seq"),6,"0");
        	
        	ComOpenPopupWithTarget('/hanjin/ESM_BKG_0240.do?pgmNo=ESM_BKG_0240' + param, 1024, 670, "", "none", true);
        	
        	break;
        	
        	
        	
        case IBSEARCH_ASYNC11:
        	var param = "&eq_ofc_cd=" + formObj.usr_ofc_cd.value;
        	ComOpenPopupWithTarget('/hanjin/ESD_SCE_0056.do?pgmNo=ESD_SCE_0056' + param, 1024, 610, "", "none", true);
        	break;
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
    var formObj = document.form;
    switch (sAction){
        case IBSEARCH:
            if(!ComChkValid(formObj)) return false;
            
            // maximum조회기간이 3개월
            if(formObj.sch_tp[0].checked
            		&& !ComBkgMonthsBetweenCheck(formObj.snd_dt_fm.value,formObj.snd_dt_to.value,  3))
			{
            	ComShowCodeMessage("BKG40013", "3");
        		ComSetFocus(formObj.snd_dt_to);
        		return false;
            }
            break;
        
        case IBDOWNEXCEL:
            if(!ComChkValid(formObj)) return false;
            
            // maximum조회기간이 3개월
            if(formObj.sch_tp[0].checked
            		&& !ComBkgMonthsBetweenCheck(formObj.snd_dt_fm.value,formObj.snd_dt_to.value,  3))
			{
            	ComShowCodeMessage("BKG40013", "3");
        		ComSetFocus(formObj.snd_dt_to);
        		return false;
            }
        	break;
    }

    return true;
}

/**
 * Sheet의 Search후 작업 처리<br>
 * Fail이 발생한 전송건에 대한 색상을 설정한다.<br>
 * Global Date를 Tooltip정보로 설정한다.<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj 필수, Sheet개체
 * @param {String} errStr 필수, 메시지 문자열
 * @returns void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function sheet1_OnSearchEnd(sheetObj, errXml) {
	ComOpenWait(false);
	var startRow = 1;
    var maxRow = sheetObj.LastRow;
    
    if (sheetObj.RowCount < 0) {return;}

    //sheetObj.RowHeight(0) = 10;
    if (maxRow < 100) {
        startRow = 1;
    } else if ((maxRow%100.0) == 0 ) {
        startRow = maxRow - 200 ;
        if (startRow < 1) {
            startRow = 1;
        }
    } else {
        startRow = maxRow - ((maxRow - 1.0)%200.0);
    }
    
    var vColorRed  = sheetObj.RgbColor(255,0,0);  // 성능 향상을 위해 변수로 적용 20100204
    var vColorBlue = sheetObj.RgbColor(0,0,255);
    var vColorPink = sheetObj.RgbColor(255,0,192);

    var rsltCd = "";
    for (var idx = startRow; idx <= maxRow; idx ++) {
//        if (sheetObj.CellValue(idx, "bkg_ntc_snd_rslt_cd") == "F") {  // TODO: 코드 확인해야함
//            sheetObj.RowFontColor(idx) = sheetObj.vColorRed;  // fail은 Row가 Red로
//        }
		with (sheetObj) {
		    rsltCd = CellValue(idx, "bkg_ntc_snd_rslt_cd"); 
		    
		    if (rsltCd == "F") { // Red
		    	CellFont("FontColor", idx,"bkg_ntc_snd_rslt_cd") = vColorRed;
		    	CellFont("FontColor", idx,"bkg_ntc_snd_rslt_ctnt") = vColorRed;
		    	CellFont("FontColor", idx,"ntc_fax_no_eml") = vColorRed;
		    } else if (rsltCd == "S" ) { // blue
		    	CellFont("FontColor", idx,"bkg_ntc_snd_rslt_cd") = vColorBlue;
		    	CellFont("FontColor", idx,"bkg_ntc_snd_rslt_ctnt") = vColorBlue;
		    	CellFont("FontColor", idx,"ntc_fax_no_eml") = vColorBlue;
		    } else { // pink
		    	CellFont("FontColor", idx,"bkg_ntc_snd_rslt_cd") = vColorPink;
		    	CellFont("FontColor", idx,"bkg_ntc_snd_rslt_ctnt") = vColorPink;
		    	CellFont("FontColor", idx,"ntc_fax_no_eml") = vColorPink;
		    }
	        sheetObj.ToolTipText(idx, "snd_dt") = sheetObj.CellValue(idx, "snd_gdt");
		}
    }
}
 

    /**
     * Sheet1 더블클릭 이벤트 발생 처리<br>
     * 
     * @param {ibsheet} sheetObj 필수. Sheet ID
     * @param {int}     Row      필수. Sheet Row
     * @param {int}     Col      필수. Sheet Col
     * @return 없슴
     */
    function sheet1_OnDblClick(sheetObj,Row,Col) {
       	with(sheetObj) {
       		// Pickup No 는 더블 클릭 시 보여줌
       		switch (ColSaveName(Col)) {
       		case "cust_nm":
       	        if(sheetObj.RowHeight(Row) == 20){
       	            sheetObj.RowHeight(Row) = 0;

       	        } else {
       	            sheetObj.RowHeight(Row) = 20;
       	        }
       			
       			break;
       		}
       	}    	
    }
    
    
/**
 * Excel에 대한 Search 종료시 이벤트 처리한다.(엑셀 추출)<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj 필수, Sheet개체
 * @param {String} errStr 필수, 메시지 문자열
 * @returns void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function sheet2_OnSearchEnd(sheetObj, errXml) {
	sheetObj.SpeedDown2Excel();
	ComOpenWait(false);
}


/**
 * sch_tp를 변경할 때에 조정되어야 할 화면 속성들을 정의한다.<br>
 * @param {String} vSchTp 필수, 조회조건 radio속성
 * @param {Object} formObj 필수, 폼객체
 * @return void
 */
function fnToggleSchTp (vSchTp, formObj) {
    
    if (vSchTp=="D") {
        document.getElementsByName("snd_dt_fm")[0].setAttribute("required", true);
        document.getElementsByName("snd_dt_to")[0].setAttribute("required", true);
        document.getElementsByName("bl_no")[0].removeAttribute("required");
        document.getElementsByName("cntr_no")[0].removeAttribute("required");

    } else if (vSchTp=="B") {
        document.getElementsByName("snd_dt_fm")[0].removeAttribute("required");
        document.getElementsByName("snd_dt_to")[0].removeAttribute("required");
        document.getElementsByName("bl_no")[0].setAttribute("required", true);
        document.getElementsByName("cntr_no")[0].removeAttribute("required");
    } else if (vSchTp == "C") {
        document.getElementsByName("snd_dt_fm")[0].removeAttribute("required");
        document.getElementsByName("snd_dt_to")[0].removeAttribute("required");
        document.getElementsByName("bl_no")[0].removeAttribute("required");
        document.getElementsByName("cntr_no")[0].setAttribute("required", true);
    }
}

/**
 * 화면 개체에 클릭했을 때의 이벤트 처리<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function objClick() {
   var objName = event.srcElement.name;
   var formObj = document.form;
   switch(objName) {
       case "sch_tp":
           var vSchTp = "";
           for (var i=0; i<formObj.sch_tp.length; i++) {
               if (formObj.sch_tp[i].checked) {
                   vSchTp = formObj.sch_tp[i].value;
               }
           }
           formObj.sch_tp.value = vSchTp;
           fnToggleSchTp(vSchTp, formObj);
           break;
       case "snd_dt_fm":
    	   formObj.sch_tp[0].checked = true;
    	   fnToggleSchTp("D", formObj);
    	   break;
       case "snd_dt_to":
    	   formObj.sch_tp[0].checked = true;
    	   fnToggleSchTp("D", formObj);
    	   break;
       case "bl_no":
    	   formObj.sch_tp[1].checked = true;
    	   fnToggleSchTp("B", formObj);
    	   break;
       case "cntr_no":
    	   formObj.sch_tp[2].checked = true;
    	   fnToggleSchTp("C", formObj);
    	   break;
   }
}
 
/**
 * 업무 자바스크립트 OnKeyPress 이벤트 처리<br>
 * @param {void}
 * @return void
 */
function objKeyPress() {
    var objName = event.srcElement.name;
    var formObj = document.form;
    switch(objName) {
    	case "vvd":
    		ComKeyOnlyAlphabet('uppernum');
    		break;
    	case "pod_cd":
    		ComKeyOnlyAlphabet('upper');
    		break;
    	case "del_cd":
    		ComKeyOnlyAlphabet('upper');
    		break;
    	case "bl_no":
    		ComKeyOnlyAlphabet('uppernum');
    		break;
    	case "cntr_no":
    		ComKeyOnlyAlphabet('uppernum');
    		break;
    	case "ofc_cd":
    		ComKeyOnlyAlphabet('upper');
    		break;
    	case "snd_dt_fm":
    		obj_KeyPress(event.srcElement);
    		break;
    	case "snd_dt_to":
    		obj_KeyPress(event.srcElement);
    		break;
    }
}


/**
 * 화면 개체에 클릭했을 때의 이벤트 처리<br>
 * notice Auto Code선택에 따라 화면을 Enable Disable한다.<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function objChange() {
   var objName = event.srcElement.name;
   var formObj = document.form;
   switch(objName) {
       case "ntc_knd_auto_cd":
    	   // Manual일 경우 CheckBox들을 Disable한다.
    	   if (formObj.ntc_knd_auto_cd[2].selected == true
    			   && formObj.ntc_knd_auto_cd[2].value == "M") {
    		   formObj.ntc_knd_fc_flg.disabled = true;
    		   formObj.ntc_knd_wo_flg.disabled = true;
    	   } else {
    		   formObj.ntc_knd_fc_flg.disabled = false;
    		   formObj.ntc_knd_wo_flg.disabled = false;
    	   }
    	   break;
   }
}

/**
 * 수직스크롤바가 바닥에 닿았을 때 발생하는 이벤트 Catch<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj 필수, Sheet
 * @param {String} CondParam 필수, Query 
 * @param {int} PageNo 필수, next Page no
 * @param {int} OnePageRows 필수, page size
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
    doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, CondParam, PageNo);
}

/**
 * Sheet Click시 발생하는 Event<br>
 * FOC가 Clear된 경우에는 Pick-Up번호를 보여준다.<br>
 * @param {Object} sheetObj 필수, Sheet
 * @param {int} PageNo 필수, next Page no
 * @param {int} OnePageRows 필수, page size
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function sheet1_OnClick(sheetObj, row, col) {
   var colName = sheetObj.ColSaveName(col);
   var dtValue = sheetObj.CellValue(row,col);
   
   switch(colName) {
       case "pic_no_view":
    	   // FOC가 Clear된 경우에는 Pick-Up번호를 보여준다.
    	   if (sheetObj.CellValue(row, "foc_flg") == "Y") {
    		   if (sheetObj.CellValue(row,"pkup_no") == "" ) {
    			   sheetObj.CellValue2(row, "pkup_no_view" ) = "- N/A -";
    		   } else {
    			   sheetObj.CellValue2(row, "pkup_no_view" ) = sheetObj.CellValue(row,"pkup_no");
    		   }
    	   }
           break;
   }

}

/**
 * Pickup Send 화면으로 이동한다.<br>
 * @param {Object} sheetObj 필수, Sheet객체
 * @param {Object} formObj 필수, 폼객체
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function fnMoveToPkupSend(sheetObj, formObj) {
	 
     var blNo   = "";
     
	 var sRowStr = sheetObj.GetSelectionRows("|");
     if (sRowStr != "0" ) {   
	     var sRowArr = sRowStr.split("|");
	     if(sRowArr.length > 1){
	         ComShowCodeMessage("BKG00362");
	         return;
	     }	
	
	     if(sRowArr.length == 1) {
	         blNo = sheetObj.CellValue(sRowArr[0], "bl_no");
	     }
     }
     
     var param = "&schTp=B" + "&bl_no=" + blNo;
	 ComOpenPopupWithTarget('/hanjin/ESM_BKG_1066.do?pgmNo=ESM_BKG_1066' + param, 1024, 690, "", "none", true);
}

/**
 * 선택된 row를 프린트 한다.<br>
 * @param {Object} sheetObj 필수, Sheet객체
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function fnPrintSheet(sheetObj) {
    var prtSheet = sheetObjects[1];
    if(prtSheet.LastRow == 0) { return ; } // 조회된 적이 없을 경우 return한다.
    var sRowStr = sheetObj.GetSelectionRows("|");
    if (sRowStr == "0" ) { return ; }
    
    var sRowArr = sRowStr.split("|");
     prtSheet.removeAll();
    for (var idx=0; idx <sRowArr.length; idx++) {
        fnCopyRow(prtSheet, sheetObj, sRowArr[idx]);
    }
    
    prtSheet.Down2Print(true,2, "Cargo Release Order List Check Report");
}
 
/* 개발자 작업  끝 */