/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0936.js
 *@FileTitle : DO Receiver and Ultimate Consignee(Incl. House BL No) Setting
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.08
 *@LastModifier : 박만건
 *@LastVersion : 1.0
 * 2009.07.08 박만건
 * 1.0 Creation
 =========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
  * @fileoverview DO Receiver and Ultimate Consignee(Incl. House BL No) Setting에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
  * @author 한진해운
  */

/**
 * @extends
 * @class esm_bkg_0936 : esm_bkg_0964 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0936() {
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

// 개발자 변수
var callCount = 0;  // loadpage에서 doActionIBSheet할 경우 2번 호출됨, 이를방지하기위해 사용
var bChanged = false;

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

//    try {
        var srcName = window.event.srcElement.getAttribute("name");

        switch(srcName) {

            case "btn_Save":
                doActionIBSheet(sheetObject,formObject,IBSAVE);
                break;
                
            case "btn_Mail_Send":					
				doActionIBSheet(sheetObject,formObject,MULTI01);                    
				break;                
            
            case "btn_Close":
                if (bChanged) {
                    if (!ComShowCodeConfirm("BKG00168")) {return;} 
                }
                    
                window.close();
                break;
        } // end switch
//    }catch(e) {
//        if( e == "[object Error]") {
//            ComShowMessage(OBJECT_ERROR);
//        } else {
//            ComShowMessage(e);
//        }
//    }
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
    axon_event.addListenerForm('change', 'obj_change', form );     //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
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

    for(i=0;i<sheetObjects.length;i++){
        //ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        //ComEndConfigSheet(sheetObjects[i]);
    }
    
    initControl();
    fncSetLoadData();
   
    /*
     * 해당 프로그램은 sheet1_OnLoadFinish를 사용할 수 없다.
     * OnLoadFinish는 Load되면서 화면에 표시되는 sheet에 대해서만 발생하므로,
     * 해당 sheet는 hidden이므로 이벤트를 발생시키지 않는다.
     * 따라서 loadPage에서 처리해야만 한다.
     * description by Park Mangeon
     * date 20091113 
     */
    if (callCount == 0) {
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        callCount = 1;
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
function doActionIBSheet(sheetObj,formObj,sAction) {
    //sheetObj.ShowDebugMsg = false;
    switch(sAction) {
        case IBSEARCH: 
            formObj.f_cmd.value = SEARCH;
            var sXml = sheetObj.getSearchXml("ESM_BKG_0936GS.do" ,FormQueryString(formObj));
            var errMsg = ComGetEtcData(sXml, "ERR_MSG");
            if (errMsg != "") {
                ComBtnDisable("btn_Save");
                ComShowCodeMessage(errMsg, formObj.do_no.value);
            } else {
                fnSetFormData(sXml);
            }
            break;
        case IBSAVE:        //저장
            if(!validateForm(sheetObj,formObj,sAction)) {return;};
            formObj.f_cmd.value = MODIFY;
            var sXml = sheetObj.getSaveXml("ESM_BKG_0936GS.do" ,FormQueryString(formObj));
            var sSuccMsg = ComBkgGetMessage(sXml);
            if (sSuccMsg != null && sSuccMsg != "") {
                ComShowMessage(sSuccMsg);
                bChanged = false;
                window.close();
            }
            break;
		case MULTI01: //Mail_Send
			if(!validateForm(sheetObj,formObj,sAction)) return false;
		    if(!ComShowCodeConfirm("BKG40038","Delivery Order")){
		        return;
		    }
		    
		    ComOpenWait(true);
			formObj.f_cmd.value = MULTI01;
			var sXml = sheetObj.getSaveXml("ESM_BKG_0936GS.do" ,FormQueryString(formObj));
            var sSuccMsg = ComBkgGetMessage(sXml);
            if (sSuccMsg != null && sSuccMsg != "") {
                ComShowMessage(sSuccMsg);
                bChanged = false;
//                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
//                window.close();
            }
            ComOpenWait(false);
            break;            
    }
}

/**
 * Xml정보에 있는 Etc Data를 폼에 입력한다.<br>
 * @param {String} sXml 필수, Xml정보
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function fnSetFormData(sXml) {
    var formObj = document.form;
    formObj.hbl_no.value         = ComGetEtcData(sXml, "hbl_no");
    formObj.rcvr_cnee_nm.value   = ComGetEtcData(sXml, "rcvr_cnee_nm");
    formObj.rcvr_co_nm.value     = ComGetEtcData(sXml, "rcvr_co_nm");
    formObj.rcvr_cnee_addr.value = ComGetEtcData(sXml, "rcvr_cnee_addr");
    formObj.rcvr_phn_no.value    = ComGetEtcData(sXml, "rcvr_phn_no");
    formObj.pic_nm.value         = ComGetEtcData(sXml, "pic_nm");
    formObj.rcvr_eml.value       = ComGetEtcData(sXml, "rcvr_eml");
    formObj.cfs_eml.value       = ComGetEtcData(sXml, "cfs_eml");
    formObj.mty_yd_eml.value       = ComGetEtcData(sXml, "mty_yd_eml");
    var custToOrdFlg             = ComGetEtcData(sXml, "cust_to_ord_flg");
    if (custToOrdFlg == "Y") {
        formObj.cust_to_ord_flg_nm.value = "Yes";
    } else {
        formObj.cust_to_ord_flg_nm.value = "No";
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
    if (formObj.rcvr_eml.value != "" && !ComIsEmailAddr(formObj.rcvr_eml.value)) {
        ComShowCodeMessage("BKG00245");
        formObj.rcvr_eml.focus();
        return false;
    }
    if (formObj.cfs_eml.value != "" && !ComIsEmailAddr(formObj.cfs_eml.value)) {
    	ComShowCodeMessage("BKG00245");
    	formObj.cfs_eml.focus();
    	return false;
    }
    if (formObj.mty_yd_eml.value != "" && !ComIsEmailAddr(formObj.mty_yd_eml.value)) {
    	ComShowCodeMessage("BKG00245");
    	formObj.mty_yd_eml.focus();
    	return false;
    }
    
    if(sAction ==MULTI01){ //mail send
    	if(ComIsNull(formObj.rcvr_eml.value)){
    		//msgs['BKG00388'] = "Data is invalid. ({?msg1} )"
    		ComShowCodeMessage("BKG00388","Customer E-Mail");
    		formObj.rcvr_eml.focus();
        	return false;
    	}
    	if(ComIsNull(formObj.cfs_eml.value)){
    		ComShowCodeMessage("BKG00388","CFS E-Mail");
    		formObj.cfs_eml.focus();
        	return false;
    	}
    	
    	
        // Survey Letter 첨부 시 evntDt를 검증한다. 
        if(!ComIsNull(formObj.atch_svey_ltr_flg.value) && !ComIsDate(formObj.evnt_dt.value)) {
	       	 //alert("날짜가 아닙니다.");
	       	 ComShowCodeMessage('COM12134', "Update Time [" + formObj.evnt_dt.value + "]");
	       	 return false;
        }    	
    	
    }
    return true;
}

/**
 * 파라미터로 받은 DO번호를 폼에 세팅한다.<br>
 * @param {void}
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function fncSetLoadData() {
    var formObj = document.form;
    formObj.do_no.value        = parDoNo ;
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
            
    switch(sheetID) {
        case "sheet1":      //sheetHidden init
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
                Editable = false;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 3, 100);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(1, 4, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false)

                var HeadTitle1 = "";
                                    
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);

                var prefix="sheet1_";

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,     0,    daCenter,    true,        prefix + "ibflag");
                  
                CountPosition = 0;
            }
            break;
    }
}

/**
 * XML로 부터 오류메시지가 있는지 검사하고 오류 메시지가 있을 경우 해당 메시지를 반환한다.<br>
 * @param {String} xmlStr 선택, 오류메시지를 포함하고 있는 xml
 * @return String 오류메시지
 * @author Park Mangeon
 * @version 2009.10.01
 */
function ComBkgGetMessage(xmlStr){
    if(xmlStr == null  || xmlStr == "" ) return;

    try {
        var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
        xmlDoc.loadXML(xmlStr);

        var xmlRoot = xmlDoc.documentElement;
        if(xmlRoot == null) return;

        var etcDataNode = xmlRoot.getElementsByTagName("MESSAGE").item(0);
        if(etcDataNode == null) return;
        
        return etcDataNode.firstChild.nodeValue;

    } catch(err) { ComFuncErrMsg(err.message); }
}
     
/**
 * Form Object가 변경될때 발생하는 이벤트를 처리한다.<br>
 * @param {void}
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function obj_change(){
    var objName = event.srcElement.name;
    var formObj = document.form;
    switch(objName) {
        case "hbl_no":
            bChanged = true;
            break;
        case "rcvr_cnee_nm":
            bChanged = true;
            break;
        case "rcvr_co_nm":
            bChanged = true;
            break;
        case "rcvr_phn_no":
            bChanged = true;
            break;
        case "pic_nm":
            bChanged = true;
            break;
        case "rcvr_eml":
            bChanged = true;
        case "cfs_eml":
        	bChanged = true;
            break;
        case "mty_yd_eml":
        	bChanged = true;
        	break;
    }
}

function fncTextareaMaxLine(obj){
    var str_line = obj;
    line = str_line.split("\r\n");
    ln = line.length;

    if(ln == 3 && event.keyCode == 13){
        event.returnValue = false;
    }
}

/* 개발자 작업  끝 */