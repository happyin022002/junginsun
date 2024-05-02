/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0941.js
 *@FileTitle : Consignee Code Error Report
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.24
 *@LastModifier : 박만건
 *@LastVersion : 1.0
 * 2009.06.24 박만건
 * 1.0 Creation
 * -------------------------------------------------------
 * History
 * 2010.10.14 변종건 [CHM-201006146-01] [CNEE Code Error Report] 검색조건 및 결과값 추가
 * 2012.02.14 변종건 [CHM-201215951] Customer Error Code Report 화면 보완 
 *                  - Including non-validated code 조건 추가 및 Customer Type Code 에 Per B/L Type 추가
 * 2013.02.12 김진주 [CHM-201322860] Customer Code Error Report 보완 요청
 * 2013.02.19 김진주 [CHM-201322860] Customer Code Error Report 보완 요청
 =========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
  * @fileoverview Consignee Code Error Report에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
  * @author 한진해운
  */

/**
 * @extends 
 * @class esm_bkg_0941 : esm_bkg_0941 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0941() {
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
    this.funcAllRhqOnChange		= funcAllRhqOnChange;
//    this.funcShowValueRows		= funcShowValueRows;
}

   /* 개발자 작업    */


// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var sheetNames   = new Array("sheet1", "sheet2", "sheet3");
var sheetInits   = new Array(   false,    false,    false);

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

var comboObjects = new Array();
var combo1 = null;
var comboCnt = 0;
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

    /*******************************************************/
    var formObject = document.form;

    try {
        var srcName = window.event.srcElement.getAttribute("name");
        if (!ComIsBtnEnable(srcName)) {return;}
        
        switch(srcName) {
            case "btn_bkg_cre_dt":
                var cal = new ComCalendarFromTo();
                cal.select(formObject.bkg_cre_dt_s, formObject.bkg_cre_dt_e, 'yyyy-MM-dd');
                break;
            
            case "btn_val_dt":
                var cal = new ComCalendarFromTo();
                cal.select(formObject.val_dt_s, formObject.val_dt_e, 'yyyy-MM-dd');
                break;
            
            case "btn_eta_dt":
                var cal = new ComCalendarFromTo();
                cal.select(formObject.eta_dt_s, formObject.eta_dt_e, 'yyyy-MM-dd');
                break;
            
            case "btn_Retrieve":
            	sheetObjects[2].RemoveAll();
            	doActionIBSheet(sheetObject, formObject, IBSEARCH, "", "");
                break;
            case "btn_Save":
            	doActionIBSheet(sheetObject, formObject, IBSAVE, "", "");
            	break;
            case "btn_DownExcel":
                doActionIBSheet(sheetObjects[1],formObject,IBDOWNEXCEL,"","");
                break;
            case "ofc_cd_inq":
            	ComOpenPopupWithTarget('/hanjin/COM_ENS_071.do', 800, 470, "ofc_cd:ofc_cd", '0,0,1,1,1,1,1', true);
            	break;
            case "gso_cd_inq":
            	ComOpenPopupWithTarget('/hanjin/COM_ENS_071.do', 800, 470, "ofc_cd:gso_cd", '0,0,1,1,1,1,1', true);
            	break;
            case "rhq_cd_inq":
            	ComOpenPopupWithTarget('/hanjin/COM_ENS_071.do', 800, 470, "ofc_cd:rhq_cd", '0,0,1,1,1,1,1', true);
            	break;
            case "cust_cd_inq":
            	ComOpenPopupWithTarget('/hanjin/COM_ENS_041.do', 800, 470, "cust_cd:cust_cd", '0,0,1,1,1,1,1', true);
            	break;

            case "doc_usr_id_inq":
            	ComOpenPopupWithTarget('/hanjin/COM_ENS_091.do', 800, 560, "usr_id:doc_usr_id", '0,0,1,1,1,1,1', true);
            	break;

            case "val_usr_id_inq":
            	ComOpenPopupWithTarget('/hanjin/COM_ENS_091.do', 800, 560, "usr_id:val_usr_id", '0,0,1,1,1,1,1', true);
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
    for(i=0;i<sheetNames.length;i++){
    	sheetInit(i)
    }
    
    initControl();
    var formObj = document.form;
    formObj.err_flg.checked = true;    
    formObj.err_flg.value = 'Y';
    doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    

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
 * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
 * 
 * @param {IBMultiCombo}
 *            combo_obj IBMultiCombo Object
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
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

        case "sheet1":
            with (sheetObj) {

                // 높이 설정
                style.height = 350;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 15, 100);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(20, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false, false);

                var HeadTitle = "|Seq.|RHQ|BKG OFC|B/L No.|B/L Type|Customer\nType|MDM\nUpdate Date|Code Input Date\nin BKG|Code\nInput OFC|Inputer ID|Code\nin BKG|Code\nin A/N|Evaluation\nResult|Validate\nOFC|Validater ID|Validate\nDate";

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                //데이터속성    [ROW, COL,  DATATYPE,       WIDTH,   DATAALIGN,  COLMERGE,  SAVENAME,           KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]                
                InitDataProperty(0, cnt++ , dtHiddenStatus,    0,    daCenter,    false,    "ibflag");
                InitDataProperty(0, cnt++ , dtSeq,            40,    daCenter,    true,     "Seq");
                InitDataProperty(0, cnt++ , dtData,           70,    daCenter,    true,     "rhq_cd",  			false,     "",        dfNone,       0,        false,       false);
                InitDataProperty(0, cnt++ , dtData,           70,    daCenter,    true,     "bkg_ofc_cd",       false,     "",        dfNone,       0,        false,       false);
                InitDataProperty(0, cnt++ , dtData,           90,    daLeft,      true,     "bl_no",            false,     "",        dfNone,       0,        false,       false);
                InitDataProperty(0, cnt++ , dtCombo,           70,   daLeft,      true,     "cust_to_ord_flg",  false,     "",        dfNone,       0,        false,       false);
                InitDataProperty(0, cnt++ , dtData,           90,    daLeft,      true,     "cust_tp_cd_nm",    false,     "",        dfNone,       0,        false,       false);
                InitDataProperty(0, cnt++ , dtData,           80,    daCenter,    true,     "cd_cre_dt",        false,     "",        dfUserFormat, 0,        false,       false);
                InitDataProperty(0, cnt++ , dtData,           100,   daCenter,    true,     "cd_input_dt",      false,     "",        dfUserFormat, 0,        false,       false);
                InitDataProperty(0, cnt++ , dtData,           80,    daCenter,    true,     "cd_input_ofc_cd",  false,     "",        dfNone,       0,        false,       false);
                InitDataProperty(0, cnt++ , dtData,           80,    daCenter,    true,     "cd_input_usr_id",  false,     "",        dfNone,       0,        false,       false);
                InitDataProperty(0, cnt++ , dtData,           65,    daCenter,    true,     "err_cd",           false,     "",        dfNone,       0,        false,       false);
                InitDataProperty(0, cnt++ , dtData,           65,    daCenter,    true,     "crt_cd",           false,     "",        dfNone,       0,        false,       false);                 
                InitDataProperty(0, cnt++ , dtData,           80,    daCenter,    true,     "evl_rst_nm",       false,     "",        dfNone,       0,        false,       false);
                
                
                InitDataProperty(0, cnt++ , dtData,           80,    daCenter,    true,     "evl_ofc_cd",       false,     "",        dfNone,       0,        false,       false);
                InitDataProperty(0, cnt++ , dtData,           80,    daCenter,    true,     "evl_usr_id",       false,     "",        dfNone,       0,        false,       false);
                
                InitDataProperty(0, cnt++ , dtData,           80,    daCenter,    true,     "evl_dt",           false,     "",        dfUserFormat, 0,        false,       false);
                //InitDataProperty(0, cnt++ , dtHidden,          0,    daCenter,    true,     "ob_ev_cd",         false,     "",        dfNone,		0,        false,       false);
                //InitDataProperty(0, cnt++ , dtHidden,          0,    daCenter,    true,     "ib_ev_cd",         false,     "",        dfNone,		0,        false,       false);                
                //InitDataProperty(0, cnt++ , dtHidden,          0,    daCenter,    true,     "hq_ev_cd",         false,     "",        dfNone,		0,        false,       false);
                InitDataProperty(0, cnt++ , dtHidden,          0,      daLeft,    true,     "bkg_no",           false,     "",        dfNone,       0,        false,       false);
                
                InitDataProperty(0, cnt++ , dtHidden,          0,      daLeft,    true,     "bkg_cust_tp_cd",   false,     "",        dfNone,       0,        false,       false);                
                InitDataProperty(0, cnt++ , dtHidden,          0,      daLeft,    true,     "data_changed",     false,     "",        dfNone,       0,        false,       false);
                
                InitUserFormat(0,"cd_cre_dt", "####-##-##", "-");
                InitUserFormat(0,"cd_input_dt", "####-##-##", "-");
                InitUserFormat(0,"evl_dt", "####-##-##", "-");
                InitDataCombo( 0,"cust_to_ord_flg" , "Order B/L|Straight B/L", "Y|N");
                
                CountFormat = "[SELECTDATAROW / TOTALROWS]"; 
                WaitImageVisible = false;

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
                MergeSheet = msNone;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 15, 100);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(14, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false, false);

                var HeadTitle = "Seq.|B/L No.|B/L Type|Customer\nType|Code\nin BKG|Code\nin A/N|Code Create\nDate|Evaluation\nResult|Code Input\nOFC|Inputer ID|Code\nInput Date|Report OFC|Reporter ID|Rep. Date";

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                //데이터속성    [ROW, COL,  DATATYPE,       WIDTH,   DATAALIGN,  COLMERGE,  SAVENAME,           KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                //InitDataProperty(0, cnt++ , dtHiddenStatus, 0,     daCenter,    false,     "ibflag");
                InitDataProperty(0, cnt++ , dtSeq,            40,    daCenter,    true,     "Seq");
                InitDataProperty(0, cnt++ , dtData,           100,   daLeft,      true,     "bl_no",            false,     "",        dfNone,       0,        false,        false);
                InitDataProperty(0, cnt++ , dtCombo,          70,    daLeft,      true,     "cust_to_ord_flg",  false,     "",        dfNone,       0,        false,       false);
                InitDataProperty(0, cnt++ , dtData,           90,    daLeft,      true,     "cust_tp_cd_nm",    false,     "",        dfNone,       0,        false,        false);
                InitDataProperty(0, cnt++ , dtData,           60,    daCenter,    true,     "err_cd",           false,     "",        dfNone,       0,        false,        false);
                InitDataProperty(0, cnt++ , dtData,           60,    daCenter,    true,     "crt_cd",           false,     "",        dfNone,       0,        false,        false);
                                                            
                InitDataProperty(0, cnt++ , dtData,           80,    daCenter,    true,     "cd_cre_dt",        false,     "",        dfUserFormat, 0,        false,        false);
                InitDataProperty(0, cnt++ , dtData,           80,    daCenter,    true,     "evl_rst_nm",       false,     "",        dfNone,       0,        false,        false);
                InitDataProperty(0, cnt++ , dtData,           80,    daCenter,    true,     "cd_input_ofc_cd",  false,     "",        dfNone,       0,        false,        false);
                InitDataProperty(0, cnt++ , dtData,           80,    daCenter,    true,     "cd_input_usr_id",  false,     "",        dfNone,       0,        false,        false);
                InitDataProperty(0, cnt++ , dtData,           80,    daCenter,    true,     "cd_input_dt",      false,     "",        dfUserFormat, 0,        false,        false);
                                                            
                InitDataProperty(0, cnt++ , dtData,           80,    daCenter,    true,     "evl_ofc_cd",       false,     "",        dfNone,       0,        false,        false);
                InitDataProperty(0, cnt++ , dtData,           80,    daCenter,    true,     "evl_usr_id",       false,     "",        dfNone,       0,        false,        false);
                InitDataProperty(0, cnt++ , dtData,           80,    daCenter,    true,     "evl_dt",           false,     "",        dfUserFormat, 0,        false,        false);
                
                InitUserFormat(0,"cd_cre_dt", "####-##-##", "-");
                InitUserFormat(0,"cd_input_dt", "####-##-##", "-");
                InitUserFormat(0,"evl_dt", "####-##-##", "-");
                InitDataCombo( 0,"cust_to_ord_flg" , "Order B/L|Straight B/L", "Y|N");
                
            }
            break;
       
        case "sheet3":
    		with (sheetObj) 
    		{
    			style.height = 70;
    			SheetWidth = mainTable.clientWidth;
    			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    			MergeSheet = msNone;
    			Editable = true;

    			InitRowInfo(1, 1, 21, 100);    			
    			var HeadTitle1 = "ALL RHQ|RHQ CNT|AUTO|AUTO_2|AUTO CNT|Okay|Okay_2|Okay CNT|Wrong|Wrong2|Wrong CNT|Not-Ex|Not-Ex2|Not-Ex CNT|Multi|Multi2|Multi CNT|Skip|Skip2|Skip CNT";
    			var headCount = ComCountHeadTitle(HeadTitle1);

    			InitColumnInfo(22, 0, 0, true);
    			InitHeadMode(true, true, true, true, false, false);
    			InitHeadRow(0, HeadTitle1, true, true);
    			
    			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    			InitDataProperty(0, cnt++ , dtData,           50,    daCenter,    true,     "rhq_cd",  			false,     "",        dfNone,       0,        false,       false);
                InitDataProperty(0, cnt++ , dtData,           45,    daRight,     true,     "cnt1",    			false,     "",        dfNone,       0,        false,       false);
                InitDataProperty(0, cnt++ , dtData,           50,    daCenter,    true,     "evl_rslt1",        false,     "",        dfNone,       0,        false,       false);
                InitDataProperty(0, cnt++ , dtData,           45,    daRight,     true,     "auto",           	false,     "",        dfNone,       0,        false,       false);                                                            
                InitDataProperty(0, cnt++ , dtData,           55,    daRight,     true,     "auto2",           	false,     "",        dfNone,       0,        false,       false);
               
                InitDataProperty(0, cnt++ , dtData,           50,    daCenter,    true,     "evl_rslt2",        false,     "",        dfNone,       0,        false,       false);
                InitDataProperty(0, cnt++ , dtData,           40,    daRight,     true,     "okay",       		false,     "",        dfNone,       0,        false,       false);
                InitDataProperty(0, cnt++ , dtData,           55,    daRight,     true,     "okay2",       		false,     "",        dfNone,       0,        false,       false);
                InitDataProperty(0, cnt++ , dtData,           50,    daCenter,    true,     "evl_rslt3",  		false,     "",        dfNone,       0,        false,       false);
                InitDataProperty(0, cnt++ , dtData,           40,    daRight,     true,     "wronginput",  		false,     "",        dfNone,       0,        false,       false);
                
                InitDataProperty(0, cnt++ , dtData,           60,    daRight,     true,     "wronginput2",  	false,     "",        dfNone,       0,        false,       false);
                InitDataProperty(0, cnt++ , dtData,           50,    daCenter,    true,     "evl_rslt4",  		false,     "",        dfNone,       0,        false,       false);
                InitDataProperty(0, cnt++ , dtData,           40,    daRight,     true,     "notexisted",      	false,     "",        dfNone, 		0,        false,       false);                                            
                InitDataProperty(0, cnt++ , dtData,           55,    daRight,     true,     "notexisted2",      false,     "",        dfNone, 		0,        false,       false);
                InitDataProperty(0, cnt++ , dtData,           50,    daCenter,    true,     "evl_rslt5",        false,     "",        dfNone, 		0,        false,       false);
                
                InitDataProperty(0, cnt++ , dtData,           30,    daRight,     true,     "multi",       		false,     "",        dfNone,       0,        false,       false);
                InitDataProperty(0, cnt++ , dtData,           55,    daRight,     true,     "multi2",       	false,     "",        dfNone,       0,        false,       false);
                InitDataProperty(0, cnt++ , dtData,           50,    daCenter,    true,     "evl_rslt6",       	false,     "",        dfNone,       0,        false,       false);                
                InitDataProperty(0, cnt++ , dtData,           30,    daRight,     true,     "skip",           	false,     "",        dfNone, 		0,        false,       false);
                InitDataProperty(0, cnt++ , dtData,           55,    daRight,     true,     "skip2",           	false,     "",        dfNone, 		0,        false,       false);

                InitDataProperty(0, cnt++ , dtHidden,          0,    daCenter,    true,     "bb",         		false,     "",        dfNone,		0,        false,       false);                
                InitDataProperty(0, cnt++ , dtHidden,          0,    daCenter,    true,     "bb2",         		false,     "",        dfNone,		0,        false,       false);
    		}
    		break; 
    }
}

/**
 * Sheet관련 프로세스 처리<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj 필수, Sheet개체
 * @param {Object} formObj 필수, 폼개체
 * @param {String} sAction 필수, 작업코드
 * @param {String} CondParam 선택, 이전 조회 조건정보
 * @param {int} pageNo 선택, 페이지 번호
 * @return {void}
 * @author Park Mangeon
 * @version 2009.10.01
 */
function doActionIBSheet(sheetObj,formObj,sAction, sCondParam, PageNo) {
    //sheetObj.ShowDebugMsg = false;
    switch(sAction) {
    
    	case IBCLEAR:
			formObj.f_cmd.value = INIT;
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0941GS.do", FormQueryString(formObj));
			var arrXml = sXml.split("|$$|");
			ComXml2ComboItem(arrXml[0], formObj.val_cd, "val", "name");
			ComXml2ComboItem(arrXml[1], formObj.rhq_cd, "val", "val");
			ComXml2ComboItem(arrXml[2], formObj.cust_tp_cd, "val", "name");
			comboObjects[0].Index = 0;
			comboObjects[1].Index = 0;
			comboObjects[2].Index = 0;
    	break;

        case IBSEARCH:      //조회
            if(!validateForm(sheetObj,formObj,sAction)) {return; }

            ComOpenWait(true);
            formObj.f_cmd.value = SEARCH;
            var xml = sheetObj.GetSearchXml("ESM_BKG_0941GS.do", FormQueryString(formObj), "page_no=1", false);
            var rtnValue = xml.split("|$$|");                  
            
            sheetObjects[0].LoadSearchXml(rtnValue[0]);
            sheetObjects[2].LoadSearchXml(rtnValue[1]);  
            
            pagedMaxCnt = sheetObj.HeaderRows;//색상 변경을 위한 변수 초기화
            
//            if (formObj.err_flg.value == 'Y'){
//            	sheet3_ShowSubSum(sheetObj);
//            } 2011.12.16 요건변경으로 제거 유저(홍우리)의 잦은 변경으로 주석 처리
            break;
        
        case IBSEARCHAPPEND:
        	formObj.f_cmd.value = SEARCH;
        	ComOpenWait(true);
            sheetObj.DoSearch("ESM_BKG_0941GS.do", sCondParam,"page_no=" + PageNo , true );
        	break;  
        case IBSAVE:
        	if(!validateForm(sheetObj,formObj,sAction)) {return; }
        	if(!ComShowCodeConfirm("BKG00254")) {return;}
        	
        	formObj.f_cmd.value = MODIFY;
            var statusRow = sheetObj.FindStatusRow("U");
            var statusArray = statusRow.split(";");
            var sheetParam = "";
            //alert(FormQueryString(formObj));
            for (var idx = 0; idx < statusArray.length -1; idx++) {
            	sheetParam = sheetParam + "&ibflag=" + sheetObj.CellValue(statusArray[idx], "ibflag")
            	                        + "&bkg_no=" + sheetObj.CellValue(statusArray[idx], "bkg_no")
            	                        + "&bkg_cust_tp_cd=" + sheetObj.CellValue(statusArray[idx], "bkg_cust_tp_cd")
            	                        + "&ob_ev_cd=" + sheetObj.CellValue(statusArray[idx], "ob_ev_cd")
            	                        + "&ib_ev_cd=" + sheetObj.CellValue(statusArray[idx], "ib_ev_cd")
            	                        + "&hq_ev_cd=" + sheetObj.CellValue(statusArray[idx], "hq_ev_cd")
            	                        ;
            }
            
        	var sXml = sheetObj.getSaveXml("ESM_BKG_0941GS.do", "f_cmd=" + formObj.f_cmd.value + sheetParam );
        	var txState = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
            if (txState == "S") {
        		for (var i = 0; i < statusArray.length -1; i++) {
        			sheetObj.CellEditable(statusArray[i], "ib_ev_cd") = (sheetObj.CellValue(statusArray[i], "ob_ev_cd") == "1" && sheetObj.CellValue(statusArray[i], "evl_ofc_cd") == gUsrOfcCd);
        			sheetObj.CellEditable(statusArray[i], "hq_ev_cd") = (sheetObj.CellValue(statusArray[i], "ob_ev_cd") == "1" && gUserRhqOfcCd == "SELHO");  // SELHO오피스만 수정 가능

//        			alert("[" + statusArray[i] + "]" + sheetObj.RowStatus(statusArray[i]));
//        			sheetObj.CellValue(statusArray[i], "ob_ev_cd") = sheetObj.CellValue(statusArray[i], "ob_ev_cd");
//        			sheetObj.CellValue(statusArray[i], "ib_ev_cd") = sheetObj.CellValue(statusArray[i], "ib_ev_cd");
//        			sheetObj.CellValue(statusArray[i], "hq_ev_cd") = sheetObj.CellValue(statusArray[i], "hq_ev_cd");
        			sheetObj.CellValue(statusArray[i], "data_changed") = "";
        			sheetObj.RowStatus(statusArray[i]) = "R";
        			sheetObj.CellValue(statusArray[i], "ibflag") = "R";
        		}
        		ComShowCodeMessage("BKG00102");
            }
        	break;
        case IBDOWNEXCEL:
        	if(!validateForm(sheetObj,formObj,sAction)) {return; }
        	formObj.f_cmd.value = SEARCH;
        	ComOpenWait(true);
        	sheetInit(1);
        	sheetObj.DoSearch("ESM_BKG_0941GS.do", FormQueryString(formObj) + "&excel_flg=Y"  );
            break;
        	
    }
}

/**
 * 초기화 작업 : 이벤트를 등록한다.<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return {void}
 * @author Park Mangeon
 * @version 2009.10.01
 */
function initControl() {
    //Axon 이벤트 처리1. 이벤트catch
    axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
    axon_event.addListenerForm('keypress', 'objKeyPress', form);
    axon_event.addListenerForm('keyup', 'objKeyUp', form);
    axon_event.addListenerForm('click', 'objClick', form);
    axon_event.addListenerForm('click', 'objChange', form);
	
	combo1 = comboObjects[0];
	comboCnt = comboObjects.length;

	// IBMultiCombo초기화
	for ( var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k]);
	}
}

/**
 * 콤보 초기설정값
 * @param {IBMultiCombo} comboObj  comboObj
 */
function initCombo(comboObj) {
	comboObj.DropHeight = 150;
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj 필수, Sheet개체
 * @param {Object} formObj 필수, 폼개체
 * @param {int} sAction 필수, 작업코드
 * @return {boolean} Validation 결과값
 * @author Park Mangeon
 * @version 2009.10.01
 */
function validateForm(sheetObj,formObj,sAction){
	switch(sAction) {
		case IBSEARCH:
		    with(formObj){
		    	if(formObj.bl_no.value.length == 0){
			    	if (!ComChkValid(formObj)) {return false; }
			    	
			    	if (formObj.dt_option[0].checked){
			    		var fromDate = formObj.bkg_cre_dt_s.value;
				    	var toDate   = formObj.bkg_cre_dt_e.value;
			    	} else if(formObj.dt_option[1].checked) {
			    		var fromDate = formObj.val_dt_s.value;
				    	var toDate   = formObj.val_dt_e.value;
			    	} else {
			    		var fromDate = formObj.eta_dt_s.value;
				    	var toDate   = formObj.eta_dt_e.value;
			    	}
		    		    	
			    	// [CHM-201322860] 조건에 관계없이 Maximum 조회 기간은 1주일로 한정 
			    	var iDays = ComGetDaysBetween(fromDate, toDate);
		    		if(iDays > 7) {
			    		ComShowCodeMessage("BKG40014", "1"); //only less than {?msg1} -week periods allowed
			    		return false;
			    	}
			    	
			    	if((comboObjects[1].Code == "") && (formObj.gso_cd.value.length == 0) && (formObj.ofc_cd.value.length == 0) ){
			    		ComShowCodeMessage("BKG08201");
			    		return false;
			    	} 	    	
		    	}
		    }
		    break;
		case IBSAVE:
			var statusRow = sheetObj.FindStatusRow("U");
			if (statusRow == "") {
				//Nothing changed
				ComShowCodeMessage("BKG00233");
				return false;
			}
			break;
	}

    return true;
}

/**
 * 수직스크롤바가 바닥에 닿았을 때 발생하는 이벤트 Catch<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj 필수, sheet개체
 * @param {String} CondParam 사용안함,
 * @param {String} PageNo 사용안함,
 * @param {String} OnePageRows 사용안함,
 * @return {void}
 * @author Park Mangeon
 * @version 2009.10.01
 */
function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
    doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, CondParam, PageNo);
}

/**
 * Excel Down을 위한 조회가 끝나면 Excel을 다운로드 한다.<br>
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
  * Sheet3의 조회후 처리<br>
  */
 function sheet3_OnSearchEnd(sheetObj, errXml) {
	 // 	ViewOptionAllRhq = document.form.region_cd.value;
	 // 	funcShowValueRows();
}
 
/**
 * Sheet1의 조회후 처리<br>
 * Column의 색성을 설정한다.
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
	var formObj = document.form;
	
	if (formObj.mtch_flg[2].checked) { 
		sheetObj.ColHidden("ob_ev_cd") = true;
		sheetObj.ColHidden("ib_ev_cd") = true;
		sheetObj.ColHidden("hq_ev_cd") = true;
	} else {
		sheetObj.ColHidden("ob_ev_cd") = false;
		sheetObj.ColHidden("ib_ev_cd") = false;
		sheetObj.ColHidden("hq_ev_cd") = false;

		var isBlInputOfc = (formObj.ofc_cd.value == gUsrOfcCd);
		
	    var startRow = 1;
	    var maxRow = sheetObj.LastRow;

	    if (maxRow < 100) {
	        startRow = 1;
	    } else if ((maxRow%100.0) == 0 ) {
	        startRow = maxRow - 100 ;
	        if (startRow < 1) {
	            startRow = 1;
	        }
	    } else {
	        startRow = maxRow - ((maxRow - 1.0)%100.0);
	    }
		
		for (var i = startRow; i <= maxRow; i ++) {
			sheetObj.CellEditable(i, "ob_ev_cd") = isBlInputOfc && ((sheetObj.CellValue(i, "ib_ev_cd") != "1") && (sheetObj.CellValue(i, "hq_ev_cd") != "1"));
			sheetObj.CellEditable(i, "ib_ev_cd") = (sheetObj.CellValue(i, "ob_ev_cd") == "1" && sheetObj.CellValue(i, "evl_ofc_cd") == gUsrOfcCd);
			sheetObj.CellEditable(i, "hq_ev_cd") = (sheetObj.CellValue(i, "ob_ev_cd") == "1" && gUserRhqOfcCd == "SELHO");  // SELHO오피스만 수정 가능
		}
	}
	
	sheetObj.ColFontUnderline("bl_no") = true;
	sheetObj.ColFontColor("bl_no") = sheetObj.RgbColor(0,0,255);
	
	sheetObj.ColBackColor("bkg_ofc_cd") = sheetObj.RgbColor(192,192,225);
	sheetObj.ColBackColor("cust_to_ord_flg") = sheetObj.RgbColor(192,192,225);
	sheetObj.ColBackColor("bl_no") = sheetObj.RgbColor(192,192,225);
	sheetObj.ColBackColor("cust_tp_cd_nm") = sheetObj.RgbColor(192,192,225);
	
	sheetObj.ColBackColor("cd_cre_dt") = sheetObj.RgbColor(190,255,255);
	
	sheetObj.ColBackColor("cd_input_dt") = sheetObj.RgbColor(192,192,225);
	sheetObj.ColBackColor("cd_input_ofc_cd") = sheetObj.RgbColor(192,192,225);
	sheetObj.ColBackColor("cd_input_usr_id") = sheetObj.RgbColor(192,192,225);
	sheetObj.ColBackColor("err_cd") = sheetObj.RgbColor(192,192,225);
	
	sheetObj.ColBackColor("crt_cd") = sheetObj.RgbColor(255,215,235);
	sheetObj.ColBackColor("evl_rst_nm") = sheetObj.RgbColor(255,215,235);
	sheetObj.ColBackColor("evl_ofc_cd") = sheetObj.RgbColor(255,215,235);
	sheetObj.ColBackColor("evl_usr_id") = sheetObj.RgbColor(255,215,235);
	sheetObj.ColBackColor("evl_dt") = sheetObj.RgbColor(255,215,235);

	
	ComOpenWait(false);
}

/**
 * Customer Validation Sheet 클릭시 발생하는 Event<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Objet} sheetObj 필수, Sheet개체
 * @param {int} row 필수, 행
 * @param {int} col 필수, 열
 * @return {void}
 * @author Park Mangeon
 * @version 2009.10.01
 */
function sheet1_OnClick(sheetObj, row, col) {
    var colName = sheetObj.ColSaveName(col);
    var dtValue = sheetObj.CellValue(row,col);
    
    switch(colName) {
        case "ob_ev_cd":
        	if (sheetObj.CellEditable(row,col)) {
        		if (sheetObj.CellValue(row, "data_changed") == "") {
        			sheetObj.CellValue(row, "data_changed") = "C";
        		}
        	}
        	break;
        case "ib_ev_cd":
        	if (sheetObj.CellEditable(row,col)) {
        		if (sheetObj.CellValue(row, "data_changed") == "") {
        			sheetObj.CellValue(row, "data_changed") = "C";
        		}
        	}
        	break;
        case "hq_ev_cd":
        	if (sheetObj.CellEditable(row,col)) {
        		if (sheetObj.CellValue(row, "data_changed") == "") {
        			sheetObj.CellValue(row, "data_changed") = "C";
        		}
        	}
        	break;
    }
}
 
/**
 * 화면에있는 개체를 Click할 때 발생하는 이벤트 처리<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return {void}
* @author Park Mangeon
 * @version 2009.10.01
 */
function objClick() {
    var objName = event.srcElement.name;
    var formObj = document.form;
    switch(objName) {
		case "mtch_flg":
			if (formObj.mtch_flg[3].checked) {		
				comboObjects[0].Enable = true;
			} else {
				comboObjects[0].Index = 0;
				comboObjects[0].Enable = false;
			}
			break;
			
		case "err_flg":
			if (formObj.err_flg.checked == true) {
				formObj.err_flg.value = 'Y';
			}else {
				formObj.err_flg.value = '';
			}			
			break;
			
			
		case "dt_option":
			if (formObj.dt_option[0].checked) {						//BKG Period
				formObj.bkg_cre_dt_s.required = true;
				formObj.bkg_cre_dt_s.className = "input1";
				formObj.bkg_cre_dt_e.required = true;
				formObj.bkg_cre_dt_e.className = "input1";
				
				formObj.val_dt_s.required = null;
				formObj.val_dt_s.className = "input";
				formObj.val_dt_e.required = null;
				formObj.val_dt_e.className = "input";
				
				formObj.eta_dt_s.required = null;
				formObj.eta_dt_s.className = "input";
				formObj.eta_dt_e.required = null;
				formObj.eta_dt_e.className = "input";
				
				formObj.val_dt_s.value = "";
				formObj.val_dt_e.value = "";
				formObj.eta_dt_s.value = "";
				formObj.eta_dt_e.value = "";
				
				document.getElementById("bkg_dt").style.display = "Inline";
				document.getElementById("rpt_dt").style.display = "none";
				document.getElementById("eta_dt").style.display = "none";
			} else if(formObj.dt_option[1].checked){	//Report Period
				formObj.bkg_cre_dt_s.required = null;
				formObj.bkg_cre_dt_s.className = "input";
				formObj.bkg_cre_dt_e.required = null;
				formObj.bkg_cre_dt_e.className = "input";
				
				formObj.val_dt_s.required = true;
				formObj.val_dt_s.className = "input1";
				formObj.val_dt_e.required = true;
				formObj.val_dt_e.className = "input1";
				
				formObj.eta_dt_s.required = null;
				formObj.eta_dt_s.className = "input";
				formObj.eta_dt_e.required = null;
				formObj.eta_dt_e.className = "input";
				
				formObj.bkg_cre_dt_s.value = "";
				formObj.bkg_cre_dt_e.value = "";
				formObj.eta_dt_s.value = "";
				formObj.eta_dt_e.value = "";
				
				document.getElementById("bkg_dt").style.display = "none";
				document.getElementById("rpt_dt").style.display = "Inline";
				document.getElementById("eta_dt").style.display = "none";
			} else {	 //ETA
				formObj.bkg_cre_dt_s.required = null;
				formObj.bkg_cre_dt_s.className = "input";
				formObj.bkg_cre_dt_e.required = null;
				formObj.bkg_cre_dt_e.className = "input";

				formObj.val_dt_s.required = null;
				formObj.val_dt_s.className = "input";
				formObj.val_dt_e.required = null;
				formObj.val_dt_e.className = "input";
				
				formObj.eta_dt_s.required = true;
				formObj.eta_dt_s.className = "input1";
				formObj.eta_dt_e.required = true;
				formObj.eta_dt_e.className = "input1";
				
				formObj.bkg_cre_dt_s.value = "";
				formObj.bkg_cre_dt_e.value = "";
				formObj.eta_dt_s.value = "";
				formObj.eta_dt_e.value = "";
				
				document.getElementById("bkg_dt").style.display = "none";
				document.getElementById("rpt_dt").style.display = "none";
				document.getElementById("eta_dt").style.display = "Inline";
			}
			break;
    }
}
/**
 * 화면에있는 개체를 Change할 때 발생하는 이벤트 처리<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return {void}
* @author Park Mangeon
 * @version 2009.10.01
 */
function objChange() {
    var objName = event.srcElement.name;
    var formObj = document.form;
    switch(objName) {
		case "ofc_tp_cd":
			// validate office 찍으면 체크박스 disable
			if(formObj.ofc_tp_cd.value == 'V'){
				formObj.non_val_flg.checked = false;
				formObj.non_val_flg.disabled = true;
			}else{
				formObj.non_val_flg.disabled = false;
			}
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
	   case "bkg_cre_dt_s":
 	       obj_KeyPress(event.srcElement);
 		   break;
 	   case "bkg_cre_dt_e":
 	       obj_KeyPress(event.srcElement);
 		   break;
       case "rhq_cd":
 	       ComKeyOnlyAlphabet('upper');
           break;
       case "gso_cd":
 	       ComKeyOnlyAlphabet('upper');
           break;
       case "ofc_cd":
 	       ComKeyOnlyAlphabet('upper');
           break;
	   case "val_dt_s":
 	       obj_KeyPress(event.srcElement);
 		   break;
 	   case "val_dt_e":
 	       obj_KeyPress(event.srcElement);
 		   break;
       case "cust_cd":
 	       ComKeyOnlyAlphabet('uppernum');
           break;
       case "bl_no":
 	       ComKeyOnlyAlphabet('uppernum');
           break;
    }
}
 
/**
 * 개체에서 키보드를 땠을때 발생하는 이벤트를 처리<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function objKeyUp() {
    ComKeyEnter('LengthNextFocus');
}

function sheet3_ShowSubSum(sheetObj){
	sheetObjects[2].HideSubSum();	
	sheetObjects[2].ShowSubSum("bb", "1|3|6|9|12|15|18", 0, false, false, -1, "rhq_cd=Total;evl_rslt1=Auto-m;evl_rslt2=Ok;evl_rslt3=Wrong;evl_rslt4=Not-Ex;evl_rslt5=Multi;evl_rslt6=Skip;auto2=Round(|auto|/|cnt1|*100,2);okay2=Round(|okay|/|cnt1|*100,2);wronginput2=Round(|wronginput|/|cnt1|*100,2);notexisted2=Round(|notexisted|/|cnt1|*100,2);multi2=Round(|multi|/|cnt1|*100,2);skip2=Round(|skip|/|cnt1|*100,2)");

	sheetObjects[2].CellText(1, 4)  = "(" + sheetObjects[2].CellText(1, 4) + "%)";
	sheetObjects[2].CellText(1, 7)  = "(" + sheetObjects[2].CellText(1, 7) + "%)";
	sheetObjects[2].CellText(1,10)  = "(" + sheetObjects[2].CellText(1,10) + "%)";
	sheetObjects[2].CellText(1,13)  = "(" + sheetObjects[2].CellText(1,13) + "%)";
	sheetObjects[2].CellText(1,16)  = "(" + sheetObjects[2].CellText(1,16) + "%)";
	sheetObjects[2].CellText(1,19)  = "(" + sheetObjects[2].CellText(1,19) + "%)";
}

function sheet3_OnDblClick(sheetObj, row, col){
 // alert(sheetObj.CellValue(row, "ofc_cd_name")+" -- "+sheetObj.CellValue(row, "ofc_cd")+'<<<');
}

function sheet1_OnDblClick(sheetObj,rowIdx,colIdx) {
		if( colIdx == sheetObj.SaveNameCol("bl_no")){			
			var param= "?pgmNo=ESM_BKG_0079&bkg_no="+sheetObj.CellValue(rowIdx, "bl_no");
			ComOpenWindowCenter2("/hanjin/ESM_BKG_0079.do"+param, "Booking Main", 1024,740,true,"scrollbars=yes,resizable=yes");
		}
}	

// /**
//  * RHQ 변경처리 
//  * @param obj
//  * @return
//  */
// function funcAllRhqOnChange(obj)
// {
// 	ViewOptionAllRhq = obj.value;
// 	funcShowValueRows();	
// }
 
// /**************************************************************************************************
//  * IBSheet 내용을 특정 데이타만 걸러내서 보여주기
//  * @param sheetObj : IBSheetName
//  *        flagName : IBSheet에서 Show,Hidden여부를 판단할 대상필드명
//  *        hiddenValue : IBSheet에서 Hidden여부를 결정지을 값
//  * @return void
//  **************************************************************************************************/
// function funcShowValueRows()
// {
//     var sheetObj = sheetObjects[2];
//     
// 	if(ViewOptionAllRhq == '')
// 	{
// 		for(var i=1;i < sheetObj.RowCount + 2; i++)
// 		{
// 			sheetObj.RowHidden(i) = false;
// 		}
// 	}    
// 	else
// 	{
// 		for(var i=1;i <= sheetObj.RowCount + 2; i++)
// 		{
// 			if(ViewOptionAllRhq != '')
// 			{
// 				if (sheetObj.CellValue(i, "rhq_cd") != ViewOptionAllRhq) {
// 					sheetObj.RowHidden(i) = true;
// 					continue;
// 				}
// 			}
// 			sheetObj.RowHidden(i) = false;			
// 		}
// 	}
// }
    /* 개발자 작업  끝 */