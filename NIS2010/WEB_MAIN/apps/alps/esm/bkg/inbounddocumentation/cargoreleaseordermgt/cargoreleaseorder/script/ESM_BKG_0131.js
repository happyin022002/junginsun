/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0131.js
 *@FileTitle : Cargo Release Order_Do List Check Report
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.14
 *@LastModifier : 박만건
 *@LastVersion : 1.0
 * 2009.08.14 박만건
 * 1.0 Creation
 =========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview Cargo Release Order_Do List Check Report에서 사용하는 JavaScript 함수가 정의되어 있다.
 * @author Park Mangeon
 */

/**
 * @extends
 * @class esm_bkg_0131 : esm_bkg_0131 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0131() {
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

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1; 

var sheetObjects = new Array();
var sheetCnt = 0;
var sheetNames   = new Array("sheet1", "sheet2");
var sheetInits   = new Array(   false,    false);

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
    /*******************************************************/
    var formObject = document.form;

    try {
        var srcName = window.event.srcElement.getAttribute("name");

        switch(srcName) {
                    
            case "btn_Retrieve":
                if (formObject.rd_flag[1].checked) {
                    formObject.vsl_cd.value     = formObject.vvd.value.substring(0,4);
                    formObject.skd_voy_no.value = formObject.vvd.value.substring(4,8);
                    formObject.skd_dir_cd.value = formObject.vvd.value.substring(8,9);
                }
                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"","");
                break;
            
            case "btn_DownExcel":
                if (formObject.rd_flag[1].checked) {
                    formObject.vsl_cd.value     = formObject.vvd.value.substring(0,4);
                    formObject.skd_voy_no.value = formObject.vvd.value.substring(4,8);
                    formObject.skd_dir_cd.value = formObject.vvd.value.substring(8,9);
                }
                doActionIBSheet(sheetObjects[1],formObject,IBDOWNEXCEL,"","");
                break;
            
//            case "btn_FullCNTRRelease":
//            	if(sheetObject.LastRow == 0) { return ; } // 조회된 적이 없을 경우 return한다.
//                fnMoveToFullCntrRelease(sheetObject);
//                break;
            
            case "btn_CargoRelease":
                //if(sheetObject.LastRow == 0) { return ; } // 조회된 적이 없을 경우 return한다.
            	fnMoveToCargoRelease(sheetObject);
                break;
            
            case "btn_Print":
                fnPrintSheet(sheetObject);
                break;
            
            case "btn_evnt_dt":
	        	formObject.rd_flag[0].checked = true;
	        	fnSetUpUIByRdFlag();
                var cal = new ComCalendarFromTo();
                cal.select(formObject.evnt_dt_fm, formObject.evnt_dt_to, 'yyyy-MM-dd');
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
 * @param {Object} sheet_obj 필수, 등록할 개체
 * @return void 
 * @author Park Mangeon
 * @version 2009.10.01
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
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
    fnSetUpUIByRdFlag();
    ComSetFocus(document.form.evnt_dt_fm);
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
    axon_event.addListenerForm('click', 'objClick', form );     //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
    axon_event.addListenerForm('focus', 'objFocus', form);
    axon_event.addListenerForm('keypress', 'objKeyPress', form);
    
    var formObj = document.form;
    formObj.evnt_dt_to.value=ComGetNowInfo('ymd','-');
    formObj.evnt_dt_fm.value=ComGetDateAdd(null, 'd', -21, '-');
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

    switch(sheetNo) {
        case 1:      //sheet1 init
            with (sheetObj) {

                // 높이 설정
                style.height = 420;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 2, 100);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(18, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false);

                var HeadTitle1 = "Seq.|B/L No.|VVD|LANE|POR|POL|POD|DEL|D/O No.|Release Date|Release OFC|Release Staff|Consignee|Notify|Remark(s)|Release Pop-up|Warehouse|";
                
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH,   DATAALIGN,  COLMERGE, SAVENAME,        KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,   INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtSeq,      30,    daCenter,    true,   "Seq");
                InitDataProperty(0, cnt++ , dtData,     90,    daCenter,    true,   "bl_no",           false,    "",      dfNone,            0,        false);
                InitDataProperty(0, cnt++ , dtData,     70,    daCenter,    true,   "vvd",             false,    "",      dfNone,            0,        false);
               
                InitDataProperty(0, cnt++ , dtData,     50,    daCenter,    true,   "slan_cd",          false,    "",      dfNone,            0,        false);
                InitDataProperty(0, cnt++ , dtData,     50,    daCenter,    true,   "por_cd",          false,    "",      dfNone,            0,        false);
                InitDataProperty(0, cnt++ , dtData,     50,    daCenter,    true,   "pol_cd",          false,    "",      dfNone,            0,        false);
                
                InitDataProperty(0, cnt++ , dtData,     50,    daCenter,    true,   "pod_cd",          false,    "",      dfNone,            0,        false);
                InitDataProperty(0, cnt++ , dtData,     50,    daCenter,    true,   "del_cd",          false,    "",      dfNone,            0,        false);

                InitDataProperty(0, cnt++ , dtData,     80,    daCenter,    true,   "do_no",           false,    "",      dfNone,            0,        false);
                InitDataProperty(0, cnt++ , dtData,    105,    daCenter,    true,   "evnt_dt",         false,    "",      dfNone,            0,        false);
                InitDataProperty(0, cnt++ , dtData,     90,    daCenter,    true,   "evnt_ofc_cd",     false,    "",      dfNone,            0,        false);
                InitDataProperty(0, cnt++ , dtData,     90,    daCenter,    true,   "evnt_usr_id",     false,    "",      dfNone,            0,        false);
                InitDataProperty(0, cnt++ , dtData,     150,   daLeft,      true,   "cn_nm",           false,    "",      dfNone,            0,        false);

                InitDataProperty(0, cnt++ , dtData,     150,   daLeft,      true,   "nf_nm",           false,    "",      dfNone,            0,        false);
                InitDataProperty(0, cnt++ , dtData,     150,   daLeft,      true,   "do_prn_rmk",      false,    "",      dfNone,            0,        false);
                InitDataProperty(0, cnt++ , dtData,     130,   daCenter,    true,   "cgor_rmk",        false,    "",      dfNone,            0,        false);
                InitDataProperty(0, cnt++ , dtData,     150,   daLeft,      true,   "wh_nm",           false,    "",      dfNone,            0,        false);
                InitDataProperty(0, cnt++ , dtHidden,     0,   daLeft,      true,   "bkg_no",          false,    "",      dfNone,            0,        false);
                
                CountFormat = "[ SELECTDATAROW / TOTALROWS ]";
                SelectionMode = smSelectionList;
                FrozenCols = 2;
                Ellipsis  = true;
                WaitImageVisible = false;
            }
            break;
        case 2:      //sheet1 init
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
                InitRowInfo(1, 1, 2, 100);
            
                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(17, 0, 0, true);
            
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false);
            
                var HeadTitle1 = "Seq.|B/L No.|VVD|LANE|POR|POL|POD|DEL|D/O No.|Release Date|Release OFC|Release Staff|Consignee|Notify|Remark(s)|Release Pop-up|Warehouse";
                
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                
            
                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,        KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtSeq,      30,    daCenter,    true,   "Seq");
                InitDataProperty(0, cnt++ , dtData,     90,    daCenter,    true,   "bl_no",           false,    "",      dfNone,            0,        false);
                InitDataProperty(0, cnt++ , dtData,     70,    daCenter,    true,   "vvd",             false,    "",      dfNone,            0,        false);
            
                InitDataProperty(0, cnt++ , dtData,     50,    daCenter,    true,   "slan_cd",          false,    "",      dfNone,            0,        false);
                InitDataProperty(0, cnt++ , dtData,     50,    daCenter,    true,   "por_cd",          false,    "",      dfNone,            0,        false);
                InitDataProperty(0, cnt++ , dtData,     50,    daCenter,    true,   "pol_cd",          false,    "",      dfNone,            0,        false);

                InitDataProperty(0, cnt++ , dtData,     50,    daCenter,    true,   "pod_cd",          false,    "",      dfNone,            0,        false);
                InitDataProperty(0, cnt++ , dtData,     50,    daCenter,    true,   "del_cd",          false,    "",      dfNone,            0,        false);

                InitDataProperty(0, cnt++ , dtData,     80,    daCenter,    true,   "do_no",           false,    "",      dfNone,            0,        false);
                InitDataProperty(0, cnt++ , dtData,    105,    daCenter,    true,   "evnt_dt",         false,    "",      dfNone,            0,        false);
                InitDataProperty(0, cnt++ , dtData,     90,    daCenter,    true,   "evnt_ofc_cd",     false,    "",      dfNone,            0,        false);
                InitDataProperty(0, cnt++ , dtData,     90,    daCenter,    true,   "evnt_usr_id",     false,    "",      dfNone,            0,        false);
                InitDataProperty(0, cnt++ , dtData,     300,   daLeft,      true,   "cn_nm",           false,    "",      dfNone,            0,        false);

                InitDataProperty(0, cnt++ , dtData,     300,   daLeft,      true,   "nf_nm",           false,    "",      dfNone,            0,        false);
                InitDataProperty(0, cnt++ , dtData,     300,   daLeft,      true,   "do_prn_rmk",      false,    "",      dfNone,            0,        false);
                InitDataProperty(0, cnt++ , dtData,     100,   daCenter,    true,   "cgor_rmk",        false,    "",      dfNone,            0,        false);
                InitDataProperty(0, cnt++ , dtData,     150,   daLeft,      true,   "wh_nm",           false,    "",      dfNone,            0,        false);
                                
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
            formObj.f_cmd.value = SEARCH;
            
            formObj.tot_cnt.value     = "";						  
            formObj.tot_teu.value     = "";							  
            formObj.tot_feu.value     = "";				
            formObj.tot_all_teu.value = "";		
      	
            if(validateForm(sheetObj,formObj,sAction)) {
            	
                // VVD, Duration일 경우 검사한다.
                if (formObj.rd_flag[0].checked == true) {
                    // maximum 1 month
                    if(!ComBkgMonthsBetweenCheck(formObj.evnt_dt_fm.value,formObj.evnt_dt_to.value, "1")){
                        ComShowCodeMessage("BKG40013", "1");
                        ComSetFocus(formObj.evnt_dt_to);
                        return false;
                    }

                    // Release Office / Release ID 둘중 하나는 반드시 입력해야 함
                    if(formObj.evnt_ofc_cd.value == "" && formObj.evnt_usr_id.value == "") {
                        // You didn't put it in OFC or ID column. Please insert either OFC or ID to retrieve data
                    	ComShowCodeMessage("BKG40078");
                    	ComSetFocus(formObj.evnt_ofc_cd);
                        return false;
                    }
                }
                    
                var sXml = "";
                if(sheetObj.id == "sheet1") {
                	ComOpenWait(true);
//                    sheetObj.DoSearch("ESM_BKG_0131GS.do",FormQueryString(formObj) ,"page_no=1", false);
                    sXml = sheetObj.GetSearchXml("ESM_BKG_0131GS.do", FormQueryString(formObj),"page_no=1", false);
                }       
                
                sheetObj.LoadSearchXml(sXml); 
                
                formObj.tot_cnt.value = ComGetEtcData(sXml, "totCnt");		
                formObj.tot_teu.value = ComGetEtcData(sXml, "totTeu");							  
                formObj.tot_feu.value = ComGetEtcData(sXml, "totFeu");	
                
                formObj.tot_all_teu.value = new Number(eval(formObj.tot_teu.value) + eval(formObj.tot_feu.value)*2).toFixed(2)
    			
            }
            break;
            
        case IBSEARCHAPPEND:
        	ComOpenWait(true);
            sheetObj.DoSearch("ESM_BKG_0131GS.do"
                    , CondParam 
                    ,"page_no=" + PageNo
                    , true
             );
            break;
        case IBDOWNEXCEL:
            formObj.f_cmd.value = SEARCH;
            if(validateForm(sheetObj,formObj,sAction)) {
            	
                // VVD, Duration일 경우 검사한다.
                if (formObj.rd_flag[0].checked == true) {
                    // maximum 1 month
                    if(!ComBkgMonthsBetweenCheck(formObj.evnt_dt_fm.value,formObj.evnt_dt_to.value, "1")){
                        ComShowCodeMessage("BKG40013", "1");
                        ComSetFocus(formObj.evnt_dt_to);
                        return false;
                    }

                    // Release Office / Release ID 둘중 하나는 반드시 입력해야 함
                    if(formObj.evnt_ofc_cd.value == "" && formObj.evnt_usr_id.value == "") {
                        // You didn't put it in OFC or ID column. Please insert either OFC or ID to retrieve data
                    	ComShowCodeMessage("BKG40078");
                    	ComSetFocus(formObj.evnt_ofc_cd);
                        return false;
                    }
                }

                if(sheetObj.id == "sheet2") {
        	        ComOpenWait(true);
        	    	sheetInit(1);
                	sheetObj.DoSearch("ESM_BKG_0131GS.do",FormQueryString(formObj) + "&excel_flg=Y");
                }
            }
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
     switch (sAction){
         case IBSEARCH:
             if(!ComChkValid(formObj)) return false;
             if (formObj.rd_flag[0].checked== true) {
	             if(!ComBkgMonthsBetweenCheck(formObj.evnt_dt_fm.value, formObj.evnt_dt_to.value, 3)) {
	                ComShowCodeMessage("BKG40013", "3"); //only less than {?msg1}-month periods allowed
	                return false;
	             }
             }
             break;
         case IBDOWNEXCEL:
             if(!ComChkValid(formObj)) return false;
             if (formObj.rd_flag[0].checked== true) {
	             if(!ComBkgMonthsBetweenCheck(formObj.evnt_dt_fm.value, formObj.evnt_dt_to.value, 3)) {
	                ComShowCodeMessage("BKG40013", "3"); //only less than {?msg1}-month periods allowed
	                return false;
	             }
             }
             break;
     }

    return true;
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
        if(rd_flag[0].checked == true) { // F  -- Release Date
            document.getElementsByName("evnt_dt_fm")[0].setAttribute("required", true);
            document.getElementsByName("evnt_dt_to")[0].setAttribute("required", true);
            
            document.getElementsByName("vvd")[0].removeAttribute("required");
            document.getElementsByName("vvd")[0].removeAttribute("fullfill");
            document.getElementsByName("pod_cd")[0].removeAttribute("required");
            document.getElementsByName("pod_cd")[0].removeAttribute("fullfill");
            
            document.getElementsByName("bl_no")[0].removeAttribute("required");
        } else if(rd_flag[1].checked == true) { // T  -- VVD
            document.getElementsByName("evnt_dt_fm")[0].removeAttribute("required");
            document.getElementsByName("evnt_dt_to")[0].removeAttribute("required");
        
            document.getElementsByName("vvd")[0].setAttribute("required", true);
            document.getElementsByName("vvd")[0].setAttribute("fullfill", true);
            document.getElementsByName("pod_cd")[0].setAttribute("required", true);
            document.getElementsByName("pod_cd")[0].setAttribute("fullfill", true);
        
            document.getElementsByName("bl_no")[0].removeAttribute("required");
        } else { // S BL
            document.getElementsByName("evnt_dt_fm")[0].removeAttribute("required");
	        document.getElementsByName("evnt_dt_to")[0].removeAttribute("required");
	        
	        document.getElementsByName("vvd")[0].removeAttribute("required");
	        document.getElementsByName("vvd")[0].removeAttribute("fullfill");
	        document.getElementsByName("pod_cd")[0].removeAttribute("required");
	        document.getElementsByName("pod_cd")[0].removeAttribute("fullfill");
	        
	        document.getElementsByName("bl_no")[0].setAttribute("required", true);
        }
    }
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
	    case "evnt_dt_fm":
	    	formObj.rd_flag[0].checked = true;
	    	fnSetUpUIByRdFlag();
	    	break;
	    case "evnt_dt_to":
	    	formObj.rd_flag[0].checked = true;
	    	fnSetUpUIByRdFlag();
	    	break;
	    case "evnt_ofc_cd":
	    	formObj.rd_flag[0].checked = true;
	    	fnSetUpUIByRdFlag();
	    	break;
	    case "evnt_usr_id":
	    	formObj.rd_flag[0].checked = true;
	    	fnSetUpUIByRdFlag();
	    	break;
	    case "vvd":
	    	formObj.rd_flag[1].checked = true;
	    	fnSetUpUIByRdFlag();
	    	break;
	    case "pod_cd":
	    	formObj.rd_flag[1].checked = true;
	    	fnSetUpUIByRdFlag();
	    	break;
	    case "del_cd":
	    	formObj.rd_flag[1].checked = true;
	    	fnSetUpUIByRdFlag();
	    	break;
	    case "bl_no":
	    	formObj.rd_flag[2].checked = true;
	    	fnSetUpUIByRdFlag();
	    	break;
	    case "rd_flag":
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
    case "evnt_dt_fm":
    	obj_KeyPress(event.srcElement);
	    break;
    case "evnt_dt_to":
    	obj_KeyPress(event.srcElement);
	    break;
    case "evnt_ofc_cd":
    	ComKeyOnlyAlphabet('uppernum');
	    break;
    case "vvd":
    	ComKeyOnlyAlphabet('uppernum');
	    break;
    case "pod_cd":
    	ComKeyOnlyAlphabet('uppernum');
	    break;
    case "del_cd":
    	ComKeyOnlyAlphabet('uppernum');
	    break;
    case "bl_no":
    	ComKeyOnlyAlphabet('uppernum');
	    break;
    }
}

 
/**
 * HTML개체에 대한 focus event발생시 처리 <br>
 * @param {void}
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function objFocus() {
    var objName = event.srcElement.name;
    var formObj = document.form;
    switch(objName) {
        case "evnt_dt_fm":
        	formObj.rd_flag[0].checked = true;
        	fnSetUpUIByRdFlag();
        	break;
        case "evnt_dt_to":
        	formObj.rd_flag[0].checked = true;
        	fnSetUpUIByRdFlag();
        	break;
        case "evnt_ofc_cd":
        	formObj.rd_flag[0].checked = true;
        	fnSetUpUIByRdFlag();
        	break;
        case "evnt_usr_id":
        	formObj.rd_flag[0].checked = true;
        	fnSetUpUIByRdFlag();
        	break;
        case "vvd":
        	formObj.rd_flag[1].checked = true;
        	fnSetUpUIByRdFlag();
        	break;
        case "pod_cd":
        	formObj.rd_flag[1].checked = true;
        	fnSetUpUIByRdFlag();
        	break;
        case "del_cd":
        	formObj.rd_flag[1].checked = true;
        	fnSetUpUIByRdFlag();
        	break;
        case "bl_no":
        	formObj.rd_flag[2].checked = true;
        	fnSetUpUIByRdFlag();
        	break;
    }
}


/**
 * Scroll이 닿을 때 Next Page처리<br>
 * @param {Object} sheetObj 필수, Sheet객체
 * @param {String} CondParam 필수, 조회조건
 * @param {int} PageNo 필수, 페이지 번호
 * @param {int} OnePageRows 선택, 페이지당 조회수
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
    doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, CondParam, PageNo);
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
	ComOpenWait(false);
	sheetObj.SpeedDown2Excel();
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
function sheet1_OnSearchEnd(sheetObj, errXml) {
	ComOpenWait(false);
}

/**
 * Cargo Release 화면으로 이동한다.<br>
 * @param {Object} sheetObj 필수, Sheet객체
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function fnMoveToCargoRelease(sheetObj) {
	var bkgNo = "";
	
	if (sheetObj.RowCount > 0) {
		var sRowStr = sheetObj.GetSelectionRows("|");
	    if (sRowStr == "0" ) { 
	    	// Please retrieve data first.
	     	ComShowCodeMessage("BKG00012");
	     	return ; 
	    }
	    
	    var sRowArr = sRowStr.split("|");
	    if(sRowArr.length > 1){
	        //alert("다중 선택을 할수 없습니다.");
	        ComShowCodeMessage("BKG00362");
	        return;
	    }
	    
	    bkgNo = sheetObj.CellValue(sRowArr[0], "bkg_no");

	    if(bkgNo=="") { 
	    	// Please retrieve data first.
	     	ComShowCodeMessage("BKG00012");
	    	return; // 조회 실패로 데이터가 없어도, No Search 인경우 sRowStr == 0을 통과함에 따라 처리
	    }  
	}

	var param="?bkg_no="+bkgNo+"&pgmNo=ESM_BKG_0128";
	
    ComOpenWindowCenter("/hanjin/ESM_BKG_0128.do"+param, "ESM_BKG_0128", 1024, 768, false);
}


/**
 * 선택된 row를 프린트 한다.<br>
 * @param {Object} sheetObj 필수, Sheet객체
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function fnPrintSheet(sheetObj) {
	sheetInit(1);
	var prtSheet = sheetObjects[1];
    //if(prtSheet.LastRow == 0) { return ; } // 조회된 적이 없을 경우 return한다.
    var sRowStr = sheetObj.GetSelectionRows("|");
    if (sRowStr == "0" ) { 
    	// Please retrieve data first.
     	ComShowCodeMessage("BKG00012");
    	return ; 
    }

    var sRowArr = sRowStr.split("|");
    var blNo = sheetObj.CellValue(sRowArr[0], "bl_no");
    if(blNo=="") { 
    	// Please retrieve data first.
     	ComShowCodeMessage("BKG00012");
    	return; // 조회 실패로 데이터가 없어도, No Search 인경우 sRowStr == 0을 통과함에 따라 처리
    }

    var sRowArr = sRowStr.split("|");

    prtSheet.removeAll();
    for (var idx=0; idx <sRowArr.length; idx++) {
        fnCopyRow(prtSheet, sheetObj, sRowArr[idx]);
    }
    prtSheet.Down2Print(true,2, "Cargo Release Order List Check Report");
}
      
/**
 * targetObj에 새로운 라인을 추가하여 source의 특정 row를 복사한다.<br>
 * @param {Object} targetObj 필수, 목적객체
 * @param {Object} sourceObj 필수, 소스객체
 * @param {int} row 필수, 행번호
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function fnCopyRow(targetObj, sourceObj, row) {
    var lastIdx = targetObj.LastCol;
    var newIdx = targetObj.DataInsert(-1);
    for (var idx=0; idx<=lastIdx; idx++) {
        targetObj.CellValue2(newIdx, targetObj.ColSaveName(idx)) = sourceObj.CellValue(row, targetObj.ColSaveName(idx));
    }
}
    
/**
 * ibSheet OnClick이벤트를 처리한다.<br>
 * @param {Object} sheetObj 필수, Sheet객체
 * @param {int} row 필수, 행번호
 * @param {int} col 필수, 열번호
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function sheet1_OnDblClick(sheetObj, row, col) {
    var eventCol = sheetObj.ColSaveName(col);
    var eventValue = sheetObj.CellValue(row, col); 
    switch (eventCol) {
	    case "cn_nm":
	    	if (eventValue != ""){
	    		ComShowMemoPad(sheetObj, row, "cn_nm", true, 200, 100, 200 );
	    	}
	    	break;
	    case "nf_nm":
	    	if (eventValue != ""){
	    		ComShowMemoPad(sheetObj, row, "nf_nm", true, 200, 100, 200 );
	    	}
	    	break;
	    case "do_prn_rmk":
	    	if (eventValue != ""){
	    		ComShowMemoPad(sheetObj, row, "do_prn_rmk", true, 200, 100, 200 );
	    	}
	    	break;
	    case "evnt_usr_id":
	    	if(eventValue != "") {
	    		ComUserPopup(eventValue);
	    	}
	    	break;
    }
}
     
   /* 개발자 작업  끝 */