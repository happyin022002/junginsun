/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_4017.js
*@FileTitle : Outstanding Inquiry by Customer & Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.28
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.08.28 문중철
* 1.0 Creation
* -----------------------------------------------------------
* 2013.04.24 임창빈 [CHM-201324212] [DMT] OTS Inquiry 관련 보완 요청
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author 한진해운
     */

    /**
     * @extends 
     * @class ui_dmt_4017 : ui_dmt_4017 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
function ui_dmt_4017() {
    this.processButtonClick     = tprocessButtonClick;
    this.setSheetObject         = setSheetObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;
    this.initControl            = initControl;
    this.doActionIBSheet        = doActionIBSheet;
    this.setTabObject           = setTabObject;
    this.validateForm           = validateForm;
}
    
// 공통전역변수

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var COMMON_TARIFF_CD = "common_tariff_cd"; 
var USER_TARIFF_TYPE = "user_tariff_type"; 
var USER_TARIFF_TYPE_CD;

var ROWMARK = "|";
var FIELDMARK = "=";
var set_day = 180;
var USR_TRF_TP;    
var oldFmDate="";
var preToDate="";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         
         var sheetObject1 = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];
         var sheetObject3 = sheetObjects[2];
         /*******************************************************/
         var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

                case "btns_payer_cd":
                    openPopup('payc');
                break;

                case "btns_cust_cd":
                    openPopup('cuno');
                break;
            
                case "btn1_excel":
                    if( sheetObjects[0].RowCount == 0 ) {
                        ComBtnDisable("btn1_excel");
                        return;
                    }                     
//                    sheetObject1.SpeedDown2Excel(-1);
                    if ( formObject.currSelect.value != "USD" &&  formObject.currSelect.value != "KRW" ){
                    	sheetObject1.SpeedDown2Excel(1,false,false,"","",false,false,"",false,"CheckBox|bzc_trf_curr_cd|dmifyn|dticyn|dmofyn|dtocyn|cticyn|ctocyn","",true);
                    } else {
	                   	 for(var i=1;i<sheetObject1.RowCount+1;i++){
	                		 sheetObject1.Cellvalue2(i, "bzc_trf_curr_cd") = formObject.currSelect.value;
	                	 }
                    	sheetObject1.SpeedDown2Excel(1,false,false,"","",false,false,"",false,"CheckBox|dmifyn|dticyn|dmofyn|dtocyn|cticyn|ctocyn","",true);
                    }
                break;                

                case "btn1_det_excel": 
                    doActionIBSheet(sheetObject3,formObject,IBSEARCH_ASYNC06);
                    if( sheetObject3.RowCount == 0 ) {
                    	ComBtnDisable("btn1_det_excel");
                        return;
                    }
                    sheetObject3.SpeedDown2Excel(-1);
                break;

                case "btn1_retrieve":
                    doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                break;
                
                case "btn1_new":
                    var formObject = document.form;
                    formObject.reset();
                    formObject.combo2.focus();
                    
					//Period Date 초기화
					//사용자 Office 의 현재 날짜를 조회한다.
					var ofcCurrDate = DmtComOfficeCurrDate(sheetObjects[0], formObject);
					var fmMvmtDt = ComGetDateAdd(formObject.ofcCurrDate, "D", -180);
					var toMvmtDt = ofcCurrDate;
					
					oldFmDate	= fmMvmtDt;
					preToDate	= toMvmtDt;
					
					ComSetObjValue(formObject.frdt, fmMvmtDt);
					ComSetObjValue(formObject.todt, toMvmtDt);
					
                    sheetObject1.RemoveAll();
                    sheetObject2.RemoveAll();
                    for(var k=0;k<comboObjects.length;k++){
                        //initCombo(comboObjects[k],k+1);
                        comboObjects[k].Code = "-1";
                        comboObjects[k].RemoveAll();
                    }                    
                    for(var k=0;k<comboObjects.length;k++){
                        initCombo(comboObjects[k],k+1);
                    }
                  
                    checkSrepFlag()	//Local S/Rep. 에 대한 초기화 작업
                    
	                ComBtnDisable("btn1_detail");
	                ComBtnDisable("btn1_fax_send");
	                ComBtnDisable("btn1_email_send");
	                ComBtnDisable("btn1_excel");      
	                ComBtnDisable("btn1_det_excel");      
	                ComBtnDisable("btn1_save");           
                break;

                case "btn1_detail":
                    if( sheetObjects[0].RowCount == 0 ) {
                        ComBtnDisable("btn1_detail");
                        return;
                    }
                    document.form.chk_payer.value  = sheetObjects[0].CellValue(sheetObjects[0].SelectRow , 3);
                    document.form.chk_payer2.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow , 4);
//                    document.form.tftp.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow , 10);
                    document.form.tftp.value = comboObjects[1].Code;
                    ComSetObjValue( formObject.isof , comboObjects[0].Code );
                    ComSetObjValue( formObject.arif , comboObjects[2].Code );
                    ComSetObjValue( formObject.cutp , comboObjects[3].Code );  
                    var tArif = formObject.arif.value;
                    var logInOff = document.form.h_rhq_off.value;
                    if ( logInOff != "NYCRA" && logInOff != "SELHO" ) {
                        if ( tArif == "A" ) {
                            tArif = "Y,N";
                        }
                    }                      
                    var param = "?isof=" + formObject.isof.value +
                                "&tftp=" + formObject.tftp.value +
                                "&frdt=" + formObject.frdt.value +
                                "&todt=" + formObject.todt.value +
                                "&arif=" + tArif +
                                "&payc=" + formObject.chk_payer.value +
                                "&cutp=" + formObject.cutp.value +
                                "&cuno=" + formObject.cuno.value +
                                "&cude=" + formObject.cude.value +
                                "&scno=" + formObject.scno.value +
                                "&rfan=" + formObject.rfan.value +
                                "&payn=" + formObject.chk_payer2.value+
                                "&prg_ex_in_cd=" + formObject.prg_ex_in_cd.value +
                    			"&sal_tm=" + comboObjects[4].Code +
                    			"&sal_rep=" + formObject.sal_rep.value +
                    			"&curr_sel=" + formObject.curr_sel.value;
                    ComOpenPopup( "/hanjin/EES_DMT_4018.do"+param , 1030, 730 , "" , "1,0,1,1,1,1,1,1" , true );
                break;
            
                case "btns_calendarfm":
                    var cal = new ComCalendarFromTo();
                    cal.select(formObject.frdt, formObject.todt, 'yyyy-MM-dd');
                break;
                
                case "btns_calendarto":
                    var cal = new ComCalendarFromTo();
                    cal.select(formObject.frdt, formObject.todt, 'yyyy-MM-dd');
                break;
                
                case "btn1_email_send":
                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC04);
                break;
                
                case "btn1_fax_send":
                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC05);
                break;
                
                case "btn1_save":
                	doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
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
    
    /*
     * 각 공통팝업창 호출 함수 
     */
    function openPopup(flag, arg) {
        
        var sheetObj = sheetObjects[0];
        var formObj = document.form;
        var sUrl    = '';
        var sWidth  = '';
        var sHeight = '';
        
        with(sheetObj) {
            switch(flag) {
                case 's_bkg_no':        // BKG No. 멀티입력 팝업 호출
                case 's_bl_no':     // B/L No. 멀티입력 팝업 호출
                case 's_cntr_no':       // CNTR No. 멀티입력 팝업 호출
                    var param = "?returnval=" + flag;
                    ComOpenPopup('EES_MNR_MULTI.do'+param, 400, 380, 'getMnr_Multi', '1,0,1,1,1,1,1,1,1,1,1,1', true);
                    break;
                case 'payc':       // Customer Inquiry Popup
                    ComOpenPopup('COM_ENS_041.do', 770, 470, "getPayerCd", "1,0,1,1,1,1,1", true);
                break;
                    
                case 'cuno':       // Customer Inquiry Popup
                    ComOpenPopup('COM_ENS_041.do', 770, 470, "getCustCd", "1,0,1,1,1,1,1", true);
                break;
            } // switch-end
        } // with-end
        
    }
    
    /*
     * Customer 공통팝업에서 선택한 Customer Code값을 해당 필드에 설정 
     */
    function getPayerCd(aryPopupData) {
        document.form.payc1.value = aryPopupData[0][3];
        document.form.payn.value = aryPopupData[0][4];
    }  
    
    /*
     * Customer 공통팝업에서 선택한 Customer Code값을 해당 필드에 설정 
     */
    function getCustCd(aryPopupData) {
        document.form.cuno.value = aryPopupData[0][3];
        document.form.cude.value = aryPopupData[0][4];
    }      
    
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
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        // IBMultiCombo초기화 
        for(var k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],k+1);
        }
        
        //html컨트롤 이벤트초기화
        initControl();
        
        // 초기 날짜 값 셋팅
        var formObject = document.form; 
        
		//Period Date 초기화
		//사용자 Office 의 현재 날짜를 조회한다.
		var ofcCurrDate = DmtComOfficeCurrDate(sheetObjects[0], formObject);
		var fmMvmtDt = ComGetDateAdd(formObject.ofcCurrDate, "D", -180);
		var toMvmtDt = ofcCurrDate;

		oldFmDate	= fmMvmtDt;
		preToDate	= toMvmtDt;
		
		ComSetObjValue(formObject.frdt, fmMvmtDt);
		ComSetObjValue(formObject.todt, toMvmtDt); 
		
        comboObjects[1].Code2 = USER_TARIFF_TYPE_CD;
        
        checkSrepFlag()	//Local S/Rep. 에 대한 초기화 작업
        
        ComBtnDisable("btn1_detail");
        ComBtnDisable("btn1_fax_send");
        ComBtnDisable("btn1_email_send");
        ComBtnDisable("btn1_excel");     
        ComBtnDisable("btn1_det_excel");      
        ComBtnDisable("btn1_save");     
    }

    function initControl() {
        axon_event.addListenerForm  ( 'blur'     , 'obj_blur'      , document.form ); //- 포커스 나갈때
        axon_event.addListenerFormat( 'focus'    , 'obj_focus'     , document.form ); //- 포커스 들어갈때
        axon_event.addListenerFormat( 'keypress' , 'obj_keypress'  , document.form ); //- 키보드 입력할때
        axon_event.addListener      ( 'keydown'  , 'ComKeyEnter'   , 'form'        );
    }

    function obj_blur(){
        //입력Validation 확인하기 + 마스크구분자 넣기
        var obj = event.srcElement;
        var formObj = document.form
    	
        if ( ( obj.name == 'frdt' || obj.name == 'todt' ) && ComGetObjValue(formObj.frdt) != "" && ComGetObjValue(formObj.todt) != "" ) {
        	if ( ! ComChkObjValid(obj) ) {
        		if ( obj.name == 'frdt'  ) {
        			ComSetObjValue(formObj.frdt, oldFmDate);
        		} else if (obj.name == 'todt' ) {
        			ComSetObjValue(formObj.todt, preToDate);
        		}
        	} else {
        		oldFmDate	= ComGetObjValue(formObj.frdt);
        		preToDate	= ComGetObjValue(formObj.todt);
        	}
        	
        }else if(obj.name == 'payc1') {
            doActionText(sheetObjects[0], formObj, obj, SEARCH20);
        }else if(obj.name == 'cuno') {
            doActionText2(sheetObjects[0], formObj, obj, SEARCH19);
        }
    }
    
    function obj_focus() {
        ComClearSeparator(event.srcElement);
        ComSetFocus(event.srcElement);
    }
    
    //업무 자바스크립트 OnKeyPress 이벤트 처리
    function obj_keypress() {
         switch(event.srcElement.dataformat){
            case "engup":
                // 영문대+숫자 
                ComKeyOnlyAlphabet('uppernum', ',');
                break;
            case "engup2":
                // 영문대+숫자+예외문자
                DmtComKeyOnlyAlphabet('uppernum', ',');
                break;
            case "int":
                //숫자 만입력하기
                ComKeyOnlyNumber(event.srcElement);
                break;
            default:
                // 숫자만입력하기(정수,날짜,시간)
                ComKeyOnlyNumber(event.srcElement);
         }
     }
    
    /** 
     * IBCombo Object를 배열로 등록
     * param : combo_obj ==> 콤보오브젝트
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */ 
    function setComboObject(combo_obj) {  
        comboObjects[comboCnt++] = combo_obj;  
    }
   
    /**
     * Combo 기본 설정 
     * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
     * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
     */ 
    function initCombo(comboObj, comboNo) {
        var formObject = document.form
        
        switch(comboNo) {  
                
            case 1: // TARIFF TYPE
                with (comboObj) { 
                    MultiSelect = true; 
//                    UseAutoComplete = true; 
                    SetColAlign("left|left"); 
                    SetColWidth("60|300");
                    ValidChar(2,0);
                    IMEMode = 0;                    
                    DropHeight = 160;
                    MaxLength = 6;
                }
                doActionIBCombo(sheetObjects[0], formObject, IBSEARCH_ASYNC02);
            break; 
                
            case 2: // ISSUE OFFICE
                with (comboObj) { 
                    MultiSelect = true; 
                    SetColAlign("left|left");   
                    SetColWidth("50|300");
                    DropHeight = 160;
                }
                doActionIBCombo(sheetObjects[0], formObject, SEARCHLIST);
            break;
            
            case 3: // AR IF
                var logInOff = document.form.h_rhq_off.value;
                if ( logInOff == "NYCRA" || logInOff == "SELHO" ) {
                    with (comboObj) { 
                        MultiSelect = true; 
                        SetColAlign("left|left");   
                        SetColWidth("100|300");
                        DropHeight = 160;
                    }
                    comboObj.InsertItem( 0 , "All|"                                               , "A" );
                    comboObj.InsertItem( 1 , "No|"                                                , "N" );
                    comboObj.InsertItem( 2 , "Yes|"                                               , "Y" );
                    comboObj.InsertItem( 3 , "Hold|All Reasons"                                   , "H" );
                    comboObj.InsertItem( 4 , "Hold(Litigation)|Collection Agency/Litigation Only" , "L" );
                    comboObj.Code2 = "N";                    
                } else {
                    with (comboObj) { 
                        MultiSelect = false; 
    //                    UseAutoComplete = true; 
                        SetColAlign("left");   
                        SetColWidth("100");
                        DropHeight = 160;
                    }
                    comboObj.InsertItem( 0 , "All|"                                               , "A" );
                    comboObj.InsertItem( 1 , "No|"                                                , "N" );
                    comboObj.InsertItem( 2 , "Yes|"                                               , "Y" );
                    comboObj.Code2 = "N";
                }
            break;
            
            case 4: // CUSTOMER TYPE
                with (comboObj) { 
                    MultiSelect = true; 
//                    UseAutoComplete = true; 
                    SetColAlign("left|left");   
                    SetColWidth("60|300");
                    DropHeight = 160;
                }
                comboObj.InsertItem( 0 , "All"  , "A" );
                comboObj.InsertItem( 1 , "SHPR" , "S" );
                comboObj.InsertItem( 2 , "CNEE" , "C" );
                comboObj.InsertItem( 3 , "NTFY" , "N" );
                comboObj.Code2 = "A,S,C,N";
            break;

            case 5: // SALES OFFICE
                with (comboObj) { 
                    MultiSelect = true; 
                    SetColAlign("left|left");   
                    SetColWidth("50|300");
                    DropHeight = 160;
                }
                comboObj.InsertItem( 0 , "All" , "All" );
                comboObj.InsertItem( 1 , "SELSCA" , "SELSCA" );
                comboObj.InsertItem( 2 , "SELSCU" , "SELSCU" );
                comboObj.InsertItem( 3 , "SELSCI" , "SELSCI" );
                comboObj.InsertItem( 4 , "SELSCS" , "SELSCS" );
                comboObj.InsertItem( 5 , "SELSCB" , "SELSCB" );
                comboObj.InsertItem( 6 , "SELSCO" , "SELSCO" );
                comboObj.InsertItem( 7 , "PUSSCS" , "PUSSCS" );
                comboObj.InsertItem( 8 , "PUSSCE" , "PUSSCE" );
                comboObj.InsertItem( 9 , "Others" , "Others" );
                comboObj.Code2 = "All,SELSCA,SELSCU,SELSCI,SELSCS,SELSCB,SELSCO,PUSSCS,PUSSCE,Others";
            break;
         } 
    }

    function doActionIBCombo(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        sheetObj.WaitImageVisible = false;
        
        switch(sAction) {
                case SEARCHLIST:  
                    var comboObj = comboObjects[1];
                    formObj.f_cmd.value = SEARCHLIST;
                    var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));                    
                    
                    // Tariff type comboList
                    var data = ComGetEtcData(sXml, COMMON_TARIFF_CD);
                    if (data != undefined && data != '') {
                        var comboItems = data.split(ROWMARK);
                        addComboItem(comboObj,comboItems);
                        comboItem = comboItems[0].split(FIELDMARK);
                    }
                    
                    var data2 = ComGetEtcData(sXml, USER_TARIFF_TYPE);
                    // User Setup Tariff Type 이 없을 경우 Default값으로.
                    if(data2 == '') data2 = 'CTIC,DMIF';
                    
                    comboObj.Code2 = data2;
                    USR_TRF_TP = data2;
                    formObj.usr_trf_tp.value = data2;
                    USER_TARIFF_TYPE_CD = data2;
                   
                break;
                
                case IBSEARCH_ASYNC02:
                	// 2010.03.18 수정
                    //2. Office comboList
                    formObj.f_cmd.value = SEARCHLIST02;
                    var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
                    var ofc_cds = ComGetEtcData(sXml, "OFC_CD");
                    var ofc_nms = ComGetEtcData(sXml, "OFC_NM");
                    
                    if (ofc_cds != undefined && ofc_cds != '') {
                    	var comboObj = comboObjects[0];
                    	var usrOfcCd = ComGetObjValue(formObj.h_user_office);
     					var idx = 0;
     					
     					// 로그인 Office가 멀티콤보 리스트에 없을 경우, 리스트 최상단에 추가
     					if(ofc_cds.indexOf(usrOfcCd) == -1) {
     						comboObj.InsertItem(0, usrOfcCd, usrOfcCd);
     						idx = 1;
     					}
     					
     					var comboCodeArr = ofc_cds.split("|");                      
                        var comboTextArr = ofc_nms.split("|");
                        
                        for (var i = 0 ; i < comboTextArr.length ; i++) {
                            comboObj.InsertItem(idx+i, comboCodeArr[i] + "|" + comboTextArr[i], comboCodeArr[i]);       
                        }
                        
                        // 로그인 User Office를 Default로 설정
    	    	  		comboObj.Code = usrOfcCd;
                    }
                    break;
                
                case IBSEARCH_ASYNC03:
                	// 2010.03.18 수정
                    //3. Sub Office comboList
                    formObj.f_cmd.value = COMMAND01;
                    var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
                    var subOfcCds = ComGetEtcData(sXml, "OFC_CD");
                    
        	 		if (subOfcCds != undefined && subOfcCds != '') {
        	 			var comboObj = comboObjects[0];
        	 			var usrOfcCd = ComGetObjValue(formObj.h_user_office);
    					
    					if(comboObj.Code.indexOf(usrOfcCd) != -1 && subOfcCds.indexOf(usrOfcCd)==-1)
    						subOfcCds = usrOfcCd + ',' + subOfcCds;
    	    	   			
    					comboObj.Code = subOfcCds;
    		 		}
        	 		break;
                

        }
        sheetObj.WaitImageVisible = true;
    }
    
     /**
      * 콤보필드에 데이터를 추가해준다.
      */    
    function addComboItem(comboObj,comboItems) {
        comboObj.InsertItem(0, "All|All", "All");
        for (var i = 0 ; i < comboItems.length ; i++) {
            var comboItem = comboItems[i].split(FIELDMARK);
            comboObj.InsertItem(i+1, comboItem[0] + "|" + comboItem[1], comboItem[0]);
        }
    }
    
  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
        var sheetID = sheetObj.id;

        switch(sheetID) {
        
            case "sheet1":      // sheet1 init
             
                with (sheetObj) {
                    // 높이 설정
                    style.height = 170;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 2, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

//                    var HeadTitle  = "|Seq.|Payer CD|Payer Name|Local S/Rep.|Count|Cur.|Billing AMT|TAX AMT|Payable AMT|usrflg|dmifyn|dticyn|dmofyn|dtocyn|cticyn|ctocyn";
                    var HeadTitle  = "||Seq|Payer CD|Payer Name|Shipper CD|Shipper name|Incurred Cur|Incurred Amount|CMDT Amount|Except Amount|Net Amount|After DC amount|Billing Amount(Invoice Amount)|Tax Amount|Payable Amount|Collected amount|OTS RMKS|Sales RMKS|dmifyn|dticyn|dmofyn|dtocyn|cticyn|ctocyn"

                    var headCount = ComCountHeadTitle(HeadTitle);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL   , DATATYPE   , WIDTH, DATAALIGN, COLMERGE, SAVENAME   , KEYFIELD, CALCULOGIC, DATAFORMAT    , POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    
                    InitDataProperty( 0   , cnt++ , dtHiddenStatus ,  0    , daCenter  , true     , "ibflag"                                           );  
                    InitDataProperty( 0 , cnt++ , dtCheckBox , 30   , daCenter , true    , "CheckBox" 	, false                                   );
                    InitDataProperty( 0 , cnt++ , dtSeq      , 40   , daCenter , true    , "SEQ"      	, false   , ""        , dfNone        	, 0         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtData     , 70   , daCenter , true    , "payerc"   	, false   , ""        , dfNone        	, 0         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtData     , 320  , daLeft   , true    , "payern"   	, false   , ""        , dfNone        	, 0         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtData     , 70   , daCenter , true    , "sh_cd"   	, false   , ""        , dfNone        	, 0         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtData     , 320  , daLeft   , true    , "sh_nm"   	, false   , ""        , dfNone        	, 0         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtHidden   , 80   , daCenter , true    , "bzc_trf_curr_cd"  , false    , ""         , dfNone        );  
                    InitDataProperty( 0 , cnt++ , dtAutoSum  , 130  , daRight  , true    , "org_chg_amt"   	, false   , ""        , dfFloat   	, 2         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtAutoSum  , 130  , daRight  , true    , "cmdt_expt_amt"   	, false   , ""        , dfFloat   	, 2         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtAutoSum  , 130  , daRight  , true    , "dmdt_expt_amt"   	, false   , ""        , dfFloat   	, 2         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtAutoSum  , 130  , daRight  , true    , "net_expt_amt"   	, false   , ""        , dfFloat   	, 2         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtAutoSum  , 130  , daRight  , true    , "dc_amt"   	, false   , ""        , dfFloat   	, 2         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtAutoSum  , 130  , daRight  , true    , "bil_amt"   	, false   , ""        , dfFloat   	, 2         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtAutoSum  , 130  , daRight  , true    , "tax_amt"   	, false   , ""        , dfFloat   	, 2         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtAutoSum  , 130  , daRight  , true    , "inv_chg_amt"   	, false   , ""        , dfFloat   	, 2         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtAutoSum  , 130  , daRight  , true    , "inv_amt"   	, false   , ""        , dfFloat   	, 2         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtData     , 320  , daLeft   , true    , "dmdt_payr_ots_rmk"   	, false   , ""        , dfNone        	, 0         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtData     , 320  , daLeft   , true    , "ots_rmk"   	, false   , ""        , dfNone        	, 0         , true     , false    );
                    InitDataProperty( 0 , cnt++ , dtHidden   , 50   , daCenter , true    , "dmifyn"   	, false   , ""        , dfNullInteger	, 0                                );
                    InitDataProperty( 0 , cnt++ , dtHidden   , 50   , daCenter , true    , "dticyn"   	, false   , ""        , dfNullInteger	, 0                                );
                    InitDataProperty( 0 , cnt++ , dtHidden   , 50   , daCenter , true    , "dmofyn"   	, false   , ""        , dfNullInteger	, 0                                );
                    InitDataProperty( 0 , cnt++ , dtHidden   , 50   , daCenter , true    , "dtocyn"   	, false   , ""        , dfNullInteger	, 0                                );
                    InitDataProperty( 0 , cnt++ , dtHidden   , 50   , daCenter , true    , "cticyn"   	, false   , ""        , dfNullInteger	, 0                                );
                    InitDataProperty( 0 , cnt++ , dtHidden   , 50   , daCenter , true    , "ctocyn"   	, false   , ""        , dfNullInteger	, 0                                );
                    
                    CountPosition = 0;
                    AutoRowHeight = false;
                    ToolTipOption = "balloon:true;width:50;";
                    ToolTipText(0,"invocn") = "Count of Invoices";
 
//                    sheetObj.ColHidden("ob_srep_cd") = true;
               }
            break;
        
            case "sheet2":      // sheet2 init
             
                with (sheetObj) {
                    // 높이 설정
                    style.height = 215;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 2, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle  = "Sales OFC|Incurred Amt|CMDT Amt|Except Amt|Net Amt|After DC Amt|Billing Amt|Tax Amt|Payable Amt|Collected Amt"

                    var headCount = ComCountHeadTitle(HeadTitle);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL   , DATATYPE   , WIDTH, DATAALIGN, COLMERGE, SAVENAME   , KEYFIELD, CALCULOGIC, DATAFORMAT    , POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    
                    InitDataProperty( 0 , cnt++ , dtData     , 65   , daCenter , true    , "ofc_cd"   	, false   , ""        , dfNone        	, 0         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtAutoSum  , 110  , daRight  , true    , "org_chg_amt"   	, false   , ""        , dfFloat   	, 2         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtAutoSum  , 90   , daRight  , true    , "cmdt_expt_amt"   	, false   , ""        , dfFloat   	, 2         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtAutoSum  , 90   , daRight  , true    , "dmdt_expt_amt"   	, false   , ""        , dfFloat   	, 2         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtAutoSum  , 110  , daRight  , true    , "net_expt_amt"   	, false   , ""        , dfFloat   	, 2         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtAutoSum  , 90   , daRight  , true    , "dc_amt"   	, false   , ""        , dfFloat   	, 2         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtAutoSum  , 110  , daRight  , true    , "bil_amt"   	, false   , ""        , dfFloat   	, 2         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtAutoSum  , 90   , daRight  , true    , "tax_amt"   	, false   , ""        , dfFloat   	, 2         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtAutoSum  , 110  , daRight  , true    , "inv_chg_amt"   	, false   , ""        , dfFloat   	, 2         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtAutoSum  , 110  , daRight  , true    , "inv_amt"   	, false   , ""        , dfFloat   	, 2         , false     , false    );

                    CountPosition = 0;
               }
            break;
            
            case "sheet3":      // sheet2 init
             
                with (sheetObj) {
                    // 높이 설정
                    style.height = 0;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 2, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle  = "Seq.|Payer CD|Payer Name|SHPR Code|SHPR NM|CNEE Code|CNEE NM|NFTY Code|NFTY NM|VVD CD|BKG No.|B/L No.|CNTR No.|POR|POL|POD|DEL|SC|RFA|TAA|CMDT Code|CMDT|Type"
                    	           + "|F/D|Over|From YD|To YD|From Date|To Date|F/D CMNC|F/D END|Incur Cur.|INCURRED|CMDT|EXCEPT|Estibillable bilable|AFTER DC Cur|AFTER DC|" +
                    	           		"Billing Cur.|Billing AMT|TAX AMT|Payable AMT|INV No.|INV RMK|AR|AR Date|Issue DT|INV Over Days|Local S/Rep.|Sales OFC|Sales Rep.";

                    var headCount = ComCountHeadTitle(HeadTitle); 
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL   , DATATYPE   , WIDTH, DATAALIGN, COLMERGE, SAVENAME   , KEYFIELD, CALCULOGIC, DATAFORMAT    , POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

                    InitDataProperty( 0   , cnt++ , dtSeq          , 30    , daCenter  , true     , "SEQ"                                              );
                    InitDataProperty( 0   , cnt++ , dtData         , 70    , daCenter  , true     , "payerc"   	    , false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtData         , 320   , daLeft    , true     , "payern"   	    , false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtData         , 80    , daCenter  , true     , "sh_cust_cd"	, false    , ""         , dfNone 		);
                    InitDataProperty( 0   , cnt++ , dtData         , 120   , daLeft	   , false     , "sh_cust_nm"	, false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtData         , 80    , daCenter  , true     , "cn_cust_cd"	, false    , ""         , dfNone 		);
                    InitDataProperty( 0   , cnt++ , dtData         , 120   , daLeft	   , false     , "cn_cust_nm"	, false    , ""         , dfNone 		);
                    InitDataProperty( 0   , cnt++ , dtData         , 80    , daCenter  , true     , "nf_cust_cd"	, false    , ""         , dfNone 		);
                    InitDataProperty( 0   , cnt++ , dtData         , 120   , daLeft	   , false     , "nf_cust_nm"	, false    , ""         , dfNone 		);
                    
                    InitDataProperty( 0   , cnt++ , dtData         , 75    , daCenter  , true     , "vvdcdd"   		, false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtData         , 95    , daCenter  , true     , "bkgnoo"   		, false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtHidden       , 85    , daCenter  , true     , "blnooo"   		, false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtData         , 85    , daCenter  , true     , "cntr_no"   	, false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtData         , 45    , daCenter  , true     , "por_cd"   		, false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtData         , 45    , daCenter  , true     , "pol_cd"   		, false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtData         , 45    , daCenter  , true     , "pod_cd"   		, false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtData         , 45    , daCenter  , true     , "del_cd"   		, false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtData         , 80    , daCenter  , true     , "sc_no"			, false    , ""         , dfNone 		);
                    InitDataProperty( 0   , cnt++ , dtData         , 80    , daCenter  , true     , "rfa_no"		, false    , ""         , dfNone 		);
                    
                    InitDataProperty( 0   , cnt++ , dtData         , 80    , daCenter  , true     , "taa_no"		, false    , ""         , dfNone 		);
                    InitDataProperty( 0   , cnt++ , dtData         , 80    , daCenter  , true     , "cmdt_cd"		, false    , ""         , dfNone 		);
                    InitDataProperty( 0   , cnt++ , dtData         , 110   , daCenter  , true     , "cmdt_nm"		, false    , ""         , dfNone		);
                    InitDataProperty( 0   , cnt++ , dtData         , 50    , daCenter  , true     , "tarftp"   		, false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtData         , 50    , daCenter  , true     , "ft_dys"   		, false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtData         , 50    , daCenter  , true     , "fx_ft_ovr_dys"   		, false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtData         , 80    , daCenter  , true     , "fm_mvmt_yd_cd"   		, false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtData         , 80    , daCenter  , true     , "to_mvmt_yd_cd"   		, false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtData         , 80    , daCenter  , true     , "fm_mvmt_dt"   		, false    , ""         , dfDateYmd        );
                    InitDataProperty( 0   , cnt++ , dtData         , 80    , daCenter  , true     , "to_mvmt_dt"   		, false    , ""         , dfDateYmd        );

                    InitDataProperty( 0   , cnt++ , dtData         , 80    , daCenter  , true     , "ft_cmnc_dt"   		, false    , ""         , dfDateYmd        );
                    InitDataProperty( 0   , cnt++ , dtData         , 80    , daCenter  , true     , "ft_end_dt"   		, false    , ""         , dfDateYmd        );   
                    InitDataProperty( 0   , cnt++ , dtData         , 80    , daCenter  , true     , "bzc_trf_curr_cd"   		, false    , ""         , dfNone        );   
                    InitDataProperty( 0   , cnt++ , dtData         , 110   , daRight   , true     , "org_chg_amt"	, false    , ""         , dfFloat   , 2 );
                    InitDataProperty( 0   , cnt++ , dtData         , 110   , daRight   , true     , "cmdt_expt_amt"		, false    , ""         , dfFloat   , 2 );
                    InitDataProperty( 0   , cnt++ , dtData         , 110   , daRight   , true     , "sc_rfa_expt_amt"	, false    , ""         , dfFloat   , 2 );
                    InitDataProperty( 0   , cnt++ , dtData         , 110   , daRight   , true     , "net_expt_amt"	, false    , ""         , dfFloat   , 2 );
                    InitDataProperty( 0   , cnt++ , dtData         , 80    , daCenter  , true     , "chg_curr_cd"   		, false    , ""         , dfNone        );   
                    InitDataProperty( 0   , cnt++ , dtData         , 110   , daRight   , true     , "aft_expt_dc_amt"	, false    , ""         , dfFloat   , 2 );

                    InitDataProperty( 0   , cnt++ , dtData         , 40    , daCenter  , true     , "currcy"  		, false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtData         , 110   , daRight   , true     , "bilamt"   		, false    , ""         , dfFloat   , 2 );
                    InitDataProperty( 0   , cnt++ , dtData         , 110   , daRight   , true     , "taxamt"   		, false    , ""         , dfFloat   , 2 );
                    InitDataProperty( 0   , cnt++ , dtData         , 110   , daRight   , true     , "invamt"   		, false    , ""         , dfFloat   , 2 );
                    
                    InitDataProperty( 0   , cnt++ , dtData         , 70    , daCenter  , true     , "invnoo"   		, false    , ""         , dfNone        );
                    
                    InitDataProperty( 0   , cnt++ , dtData         , 120   , daLeft	   , false     , "inv_rmk"		, false    , ""         , dfNone 		);
                    InitDataProperty( 0   , cnt++ , dtData         , 60    , daCenter  , true     , "dmdt_ar_if_cd"	, false    , ""         , dfNone 		); 
                    InitDataProperty( 0   , cnt++ , dtData         , 60    , daCenter  , true     , "ar_if_dt"	, false    , ""         , dfDateYmd 		);  
                    InitDataProperty( 0   , cnt++ , dtData         , 80    , daCenter  , true     , "issedt"   		, false    , ""         , dfNone     ); 
                    InitDataProperty( 0   , cnt++ , dtData         , 80    , daCenter  , true     , "oveday"   		, false    , ""         , dfNone     ); 
                    InitDataProperty( 0   , cnt++ , dtData         , 60    , daCenter  , true     , "ob_srep_cd"	, false    , ""         , dfNone 		);  
                    InitDataProperty( 0   , cnt++ , dtData         , 120   , daCenter  , false     , "ib_sls_ofc_cd"		, false    , ""         , dfNone 		);
                    InitDataProperty( 0   , cnt++ , dtData         , 120   , daCenter  , false     , "ib_srep_cd"		, false    , ""         , dfNone 		);

                    CountPosition = 0;
               }
            break;
        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

            case IBSEARCH:      //조회
            
                if ( validateForm(sheetObj,formObj,sAction) ) {
                    formObj.f_cmd.value = SEARCH;
                    sheetObj.Reset();
                    sheetObjects[1].Reset();
                    initSheet(sheetObj, 0);
                    initSheet(sheetObjects[1], 0);
                    
                    document.form.payc.value = "";
                    document.form.payc.value = document.form.payc1.value;
                    ComSetObjValue( formObj.isof , comboObjects[0].Code );
                    ComSetObjValue( formObj.tftp , comboObjects[1].Code );
                    var logInOff = document.form.h_rhq_off.value;
                    if ( logInOff == "NYCRA" || logInOff == "SELHO" ) {
                        ComSetObjValue( formObj.arif , comboObjects[2].Code );
                    } else {
                        if ( comboObjects[2].Code == "A" ) {
                            ComSetObjValue( formObj.arif , "Y,N" );                            
                        } else {
                            ComSetObjValue( formObj.arif , comboObjects[2].Code );                            
                        }
                    }
                    ComSetObjValue( formObj.cutp , comboObjects[3].Code );
                    
					ComOpenWait(true);
					sheetObj.WaitImageVisible = false;

//                    sheetObj.DoSearch4Post( "EES_DMT_4017GS.do" , FormQueryString(formObj) );

        			//sheetObj.DoSave("EES_DMT_4013GS.do", FormQueryString(formObj), -1, false);
           			var sParam = FormQueryString(formObj);
        			
        			var sXml = sheetObj.GetSaveXml("EES_DMT_4017GS.do", sParam);
        			var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");

    				if (backendJobKey != undefined && backendJobKey != '') {
						ComSetObjValue(formObj.backendjob_key, backendJobKey);
						sheetObj.WaitImageVisible = false;
						sheetObj.RequestTimeOut = 10000;
						timer = setInterval(getBackEndJobStatus, 3000); // 3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
//						timer = setInterval("getBackEndJobStatus(sheetObjects[0], '" + key + "');", 3000); 
					}
					
//					ComOpenWait(false);

//					formObj.f_cmd.value = SEARCH01;
//					sheetObjects[1].Reset();
//	                initSheet(sheetObjects[1], 0);
//	                    
//					ComOpenWait(true);					
//					sheetObjects[1].WaitImageVisible = false;
//					sheetObjects[1].DoSearch4Post( "EES_DMT_4017GS.do" , FormQueryString(formObj) );					
//					ComOpenWait(false);
//                    
                }
            
            break;
            

            case IBSEARCH_ASYNC09:      //조회
            
                if ( validateForm(sheetObj,formObj,sAction) ) {
                    
					formObj.f_cmd.value = SEARCH01;
					sheetObj.Reset();
	                initSheet(sheetObj, 0);
	                    
					ComOpenWait(true);					
					sheetObj.WaitImageVisible = false;
					sheetObj.DoSearch4Post( "EES_DMT_4017GS.do" , FormQueryString(formObj) );					
					ComOpenWait(false);
                    
                }
            
            break;
            
            case IBSEARCH_ASYNC06:      //조회
                
                if ( validateForm(sheetObj,formObj,sAction) ) {
                    formObj.f_cmd.value = SEARCH02;
                    sheetObj.Reset();
                    initSheet(sheetObj, 0);

                    document.form.payc.value = "";
                    document.form.payc.value = document.form.payc1.value;
                    ComSetObjValue( formObj.isof , comboObjects[0].Code );
                    ComSetObjValue( formObj.tftp , comboObjects[1].Code );
                    var logInOff = document.form.h_rhq_off.value;
                    if ( logInOff == "NYCRA" || logInOff == "SELHO" ) {
                        ComSetObjValue( formObj.arif , comboObjects[2].Code );
                    } else {
                        if ( comboObjects[2].Code == "A" ) {
                            ComSetObjValue( formObj.arif , "Y,N" );                            
                        } else {
                            ComSetObjValue( formObj.arif , comboObjects[2].Code );                            
                        }
                    }
                    ComSetObjValue( formObj.cutp , comboObjects[3].Code );
                    
					ComOpenWait(true);
					sheetObj.WaitImageVisible = false;

                    sheetObj.DoSearch4Post( "EES_DMT_4017GS.do" , FormQueryString(formObj) );
					
					ComOpenWait(false);
                    
                }
            
            break;
            
            case IBSEARCH_ASYNC04: // SEND2EAMIL ALL OF THEM
	            if(sheetObj.CheckedRows("CheckBox") == 0) {
	     			ComShowCodeMessage('COM12114', 'payer code');
	     			return;
	     		}            
            
            	if(!ComShowCodeConfirm('DMT01139')) return false;

				var today = new Date();
				var year = today.getYear();
				var month = today.getMonth() + 1;
				var day = today.getDate();
				if (month < 10) {
				   month = "0" + month;
				}
				  if (day < 10) {
				   day = "0" + day;
				}
				  
				var currDate = year + "-" + month + "-" + day;// 현재 날짜 생성
				ComSetObjValue( formObj.rd_fxeml_eml_atch_file , currDate );
				
					document.form.payc.value = "";
	                document.form.payc.value = document.form.payc1.value;
                    ComSetObjValue( formObj.isof , comboObjects[0].Code );
                    ComSetObjValue( formObj.tftp , comboObjects[1].Code );
                    var logInOff = document.form.h_rhq_off.value;
                    if ( logInOff == "NYCRA" || logInOff == "SELHO" ) {
                        ComSetObjValue( formObj.arif , comboObjects[2].Code );
                    } else {
                        if ( comboObjects[2].Code == "A" ) {
                            ComSetObjValue( formObj.arif , "Y,N" );                            
                        } else {
                            ComSetObjValue( formObj.arif , comboObjects[2].Code );                            
                        }
                    }
                    ComSetObjValue( formObj.cutp , comboObjects[3].Code );
                

//////////////// Sheet Set Check!!
                    var dmif_cnt = 0;
                    var dtic_cnt = 0;
                    var dmof_cnt = 0;
                    var dtoc_cnt = 0;
                    var ctic_cnt = 0;
                    var ctoc_cnt = 0;
                    
                    for ( var z01 = 1 ; z01 < sheetObjects[0].RowCount+1 ; z01++  ) {
                        if ( sheetObjects[0].CellValue(z01,1) == 1 ) {
                        	dmif_cnt+= parseInt(sheetObjects[0].CellValue(z01,"dmifyn"));
                        	dtic_cnt+= parseInt(sheetObjects[0].CellValue(z01,"dticyn"));
                        	dmof_cnt+= parseInt(sheetObjects[0].CellValue(z01,"dmofyn"));
                        	dtoc_cnt+= parseInt(sheetObjects[0].CellValue(z01,"dtocyn"));
                        	ctic_cnt+= parseInt(sheetObjects[0].CellValue(z01,"cticyn"));
                        	ctoc_cnt+= parseInt(sheetObjects[0].CellValue(z01,"ctocyn"));
                        }
                    }
                    
                    if(dmif_cnt > 0) {
                    	document.form.trftpp.value = "DMIF";
                    	formObj.f_cmd.value = SEARCH;
                    	var sXml = sheetObjects[0].GetSearchXml("EES_DMT_4101GS.do",FormQueryString(formObj));
                    	var rtnRemark = ComGetEtcData(sXml, "rtnRemark");
                    	if ( rtnRemark == undefined || rtnRemark == '' ) {
                    		ComShowCodeMessage("DMT01120","[DMIF]");
                    		return false;
                    	}
                    }

                    if(dtic_cnt > 0) {
                    	document.form.trftpp.value = "DTIC";
                    	formObj.f_cmd.value = SEARCH;
                    	var sXml = sheetObjects[0].GetSearchXml("EES_DMT_4101GS.do",FormQueryString(formObj));
                    	var rtnRemark = ComGetEtcData(sXml, "rtnRemark");
                    	if ( rtnRemark == undefined || rtnRemark == '' ) {
                    		ComShowCodeMessage("DMT01120","[DTIC]");
                    		return false;
                    	}
                    }

                    if(dmof_cnt > 0) {
                    	document.form.trftpp.value = "DMOF";
                    	formObj.f_cmd.value = SEARCH;
                    	var sXml = sheetObjects[0].GetSearchXml("EES_DMT_4101GS.do",FormQueryString(formObj));
                    	var rtnRemark = ComGetEtcData(sXml, "rtnRemark");
                    	if ( rtnRemark == undefined || rtnRemark == '' ) {
                    		ComShowCodeMessage("DMT01120","[DMOF]");
                    		return false;
                    	}
                    }

                    if(dtoc_cnt > 0) {
                    	document.form.trftpp.value = "DTOC";
                    	formObj.f_cmd.value = SEARCH;
                    	var sXml = sheetObjects[0].GetSearchXml("EES_DMT_4101GS.do",FormQueryString(formObj));
                    	var rtnRemark = ComGetEtcData(sXml, "rtnRemark");
                    	if ( rtnRemark == undefined || rtnRemark == '' ) {
                    		ComShowCodeMessage("DMT01120","[DTOC]");
                    		return false;
                    	}
                    }

                    if(ctic_cnt > 0) {
                    	document.form.trftpp.value = "CTIC";
                    	formObj.f_cmd.value = SEARCH;
                    	var sXml = sheetObjects[0].GetSearchXml("EES_DMT_4101GS.do",FormQueryString(formObj));
                    	var rtnRemark = ComGetEtcData(sXml, "rtnRemark");
                    	if ( rtnRemark == undefined || rtnRemark == '' ) {
                    		ComShowCodeMessage("DMT01120","[CTIC]");
                    		return false;
                    	}
                    }

                    if(ctoc_cnt > 0) {
                    	document.form.trftpp.value = "CTOC";
                    	formObj.f_cmd.value = SEARCH;
                    	var sXml = sheetObjects[0].GetSearchXml("EES_DMT_4101GS.do",FormQueryString(formObj));
                    	var rtnRemark = ComGetEtcData(sXml, "rtnRemark");
                    	if ( rtnRemark == undefined || rtnRemark == '' ) {
                    		ComShowCodeMessage("DMT01120","[CTOC]");
                    		return false;
                    	}
                    }
 ////////////////// Sheet Set Check!! END............
                    
                var tPayerCd = "";
                for ( var z01 = 1 ; z01 < sheetObjects[0].RowCount+1 ; z01++  ) {
                    if ( sheetObjects[0].CellValue(z01,1) == 1 ) {
                        tPayerCd = sheetObjects[0].CellValue(z01,3) + "," + tPayerCd;
                    }
                }
                document.form.paycMail.value = tPayerCd;
                
                var tPayerNm = "";
                for ( var z01 = 1 ; z01 < sheetObjects[0].RowCount+1 ; z01++  ) {
                    if ( sheetObjects[0].CellValue(z01,1) == 1 ) {
                        tPayerNm = ComReplaceStr( sheetObjects[0].CellValue(z01,4) , "'" , " " ) + "|" + tPayerNm;
                    }
                }
                document.form.paynMail.value = tPayerNm;
                
                var tTariff = "";
//                for ( var z01 = 1 ; z01 < sheetObjects[0].RowCount+1 ; z01++  ) {
//                    if ( sheetObjects[0].CellValue(z01,0) == 1 ) {
//                        tTariff = sheetObjects[0].CellValue(z01,10) + "," + tTariff;
//                    }
//                }
                if(dmif_cnt > 0) {
                	tTariff = "DMIF" + "," + tTariff;
                }

                if(dtic_cnt > 0) {
                	tTariff = "DTIC" + "," + tTariff;
                }

                if(dmof_cnt > 0) {
                	tTariff = "DMOF" + "," + tTariff;
                }

                if(dtoc_cnt > 0) {
                	tTariff = "DTOC" + "," + tTariff;
                }

                if(ctic_cnt > 0) {
                	tTariff = "CTIC" + "," + tTariff;
                }

                if(ctoc_cnt > 0) {
                	tTariff = "CTOC" + "," + tTariff;
                }
                
                document.form.tarfMail.value = tTariff;
                
                formObj.f_cmd.value = SEARCH08;
                
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
                
                var sXml08 = sheetObj.GetSaveXml("DMTCommonFaxEmailGS.do", FormQueryString(formObj));
                
				ComOpenWait(false);
                
                alert(dmtGetMsgText(sXml08));
            break;
            
            case IBSEARCH_ASYNC05: // SEND2FAX ALL OF THEM
	            if(sheetObj.CheckedRows("CheckBox") == 0) {
	     			ComShowCodeMessage('COM12114', 'payer code');
	     			return;
	     		} 
	            if(!ComShowCodeConfirm('DMT01140')) return false;

	                document.form.payc.value = "";
	                document.form.payc.value = document.form.payc1.value;
                    ComSetObjValue( formObj.isof , comboObjects[0].Code );
                    ComSetObjValue( formObj.tftp , comboObjects[1].Code );
                    var logInOff = document.form.h_rhq_off.value;
                    if ( logInOff == "NYCRA" || logInOff == "SELHO" ) {
                        ComSetObjValue( formObj.arif , comboObjects[2].Code );
                    } else {
                        if ( comboObjects[2].Code == "A" ) {
                            ComSetObjValue( formObj.arif , "Y,N" );                            
                        } else {
                            ComSetObjValue( formObj.arif , comboObjects[2].Code );                            
                        }
                    }
                    ComSetObjValue( formObj.cutp , comboObjects[3].Code );
                
//                var comboTariff = (formObj.tftp.value).split(",");
//                for (var i = 0 ; i < comboTariff.length ; i++) {
//                    if ( comboTariff[i] != "All" ){
//                        document.form.trftpp.value = comboTariff[i];
//                        formObj.f_cmd.value = SEARCH;
//                        var sXml = sheetObjects[0].GetSearchXml("EES_DMT_4101GS.do",FormQueryString(formObj));
//                        var rtnRemark = ComGetEtcData(sXml, "rtnRemark");
//                        if ( rtnRemark == undefined || rtnRemark == '' ) {
//                            ComShowCodeMessage("DMT01120","["+comboTariff[i]+"]");
//                            return false;
//                        }
//                    }
//                }
   //////////////// Sheet Set Check!!
                    var dmif_cnt = 0;
                    var dtic_cnt = 0;
                    var dmof_cnt = 0;
                    var dtoc_cnt = 0;
                    var ctic_cnt = 0;
                    var ctoc_cnt = 0;
                    
                    for ( var z01 = 1 ; z01 < sheetObjects[0].RowCount+1 ; z01++  ) {
                        if ( sheetObjects[0].CellValue(z01,1) == 1 ) {
                        	dmif_cnt+= parseInt(sheetObjects[0].CellValue(z01,"dmifyn"));
                        	dtic_cnt+= parseInt(sheetObjects[0].CellValue(z01,"dticyn"));
                        	dmof_cnt+= parseInt(sheetObjects[0].CellValue(z01,"dmofyn"));
                        	dtoc_cnt+= parseInt(sheetObjects[0].CellValue(z01,"dtocyn"));
                        	ctic_cnt+= parseInt(sheetObjects[0].CellValue(z01,"cticyn"));
                        	ctoc_cnt+= parseInt(sheetObjects[0].CellValue(z01,"ctocyn"));
                        }
                    }
                    
                    if(dmif_cnt > 0) {
                    	document.form.trftpp.value = "DMIF";
                    	formObj.f_cmd.value = SEARCH;
                    	var sXml = sheetObjects[0].GetSearchXml("EES_DMT_4101GS.do",FormQueryString(formObj));
                    	var rtnRemark = ComGetEtcData(sXml, "rtnRemark");
                    	if ( rtnRemark == undefined || rtnRemark == '' ) {
                    		ComShowCodeMessage("DMT01120","[DMIF]");
                    		return false;
                    	}
                    }

                    if(dtic_cnt > 0) {
                    	document.form.trftpp.value = "DTIC";
                    	formObj.f_cmd.value = SEARCH;
                    	var sXml = sheetObjects[0].GetSearchXml("EES_DMT_4101GS.do",FormQueryString(formObj));
                    	var rtnRemark = ComGetEtcData(sXml, "rtnRemark");
                    	if ( rtnRemark == undefined || rtnRemark == '' ) {
                    		ComShowCodeMessage("DMT01120","[DTIC]");
                    		return false;
                    	}
                    }

                    if(dmof_cnt > 0) {
                    	document.form.trftpp.value = "DMOF";
                    	formObj.f_cmd.value = SEARCH;
                    	var sXml = sheetObjects[0].GetSearchXml("EES_DMT_4101GS.do",FormQueryString(formObj));
                    	var rtnRemark = ComGetEtcData(sXml, "rtnRemark");
                    	if ( rtnRemark == undefined || rtnRemark == '' ) {
                    		ComShowCodeMessage("DMT01120","[DMOF]");
                    		return false;
                    	}
                    }

                    if(dtoc_cnt > 0) {
                    	document.form.trftpp.value = "DTOC";
                    	formObj.f_cmd.value = SEARCH;
                    	var sXml = sheetObjects[0].GetSearchXml("EES_DMT_4101GS.do",FormQueryString(formObj));
                    	var rtnRemark = ComGetEtcData(sXml, "rtnRemark");
                    	if ( rtnRemark == undefined || rtnRemark == '' ) {
                    		ComShowCodeMessage("DMT01120","[DTOC]");
                    		return false;
                    	}
                    }

                    if(ctic_cnt > 0) {
                    	document.form.trftpp.value = "CTIC";
                    	formObj.f_cmd.value = SEARCH;
                    	var sXml = sheetObjects[0].GetSearchXml("EES_DMT_4101GS.do",FormQueryString(formObj));
                    	var rtnRemark = ComGetEtcData(sXml, "rtnRemark");
                    	if ( rtnRemark == undefined || rtnRemark == '' ) {
                    		ComShowCodeMessage("DMT01120","[CTIC]");
                    		return false;
                    	}
                    }

                    if(ctoc_cnt > 0) {
                    	document.form.trftpp.value = "CTOC";
                    	formObj.f_cmd.value = SEARCH;
                    	var sXml = sheetObjects[0].GetSearchXml("EES_DMT_4101GS.do",FormQueryString(formObj));
                    	var rtnRemark = ComGetEtcData(sXml, "rtnRemark");
                    	if ( rtnRemark == undefined || rtnRemark == '' ) {
                    		ComShowCodeMessage("DMT01120","[CTOC]");
                    		return false;
                    	}
                    }
 ////////////////// Sheet Set Check!! END............
                var tPayerCd = "";
                for ( var z01 = 1 ; z01 < sheetObjects[0].RowCount+1 ; z01++  ) {
                    if ( sheetObjects[0].CellValue(z01,1) == 1 ) {
                        tPayerCd = sheetObjects[0].CellValue(z01,3) + "," + tPayerCd;
                    }
                }
                document.form.paycMail.value = tPayerCd;
                
                var tPayerNm = "";
                for ( var z01 = 1 ; z01 < sheetObjects[0].RowCount+1 ; z01++  ) {
                    if ( sheetObjects[0].CellValue(z01,1) == 1 ) {
                        tPayerNm = ComReplaceStr( sheetObjects[0].CellValue(z01,4) , "'" , " " ) + "|" + tPayerNm;
                    }
                }
                document.form.paynMail.value = tPayerNm;
                
                var tTariff = "";
//                for ( var z01 = 1 ; z01 < sheetObjects[0].RowCount+1 ; z01++  ) {
//                    if ( sheetObjects[0].CellValue(z01,0) == 1 ) {
//                        tTariff = sheetObjects[0].CellValue(z01,10) + "," + tTariff;
//                    }
//                }
                if(dmif_cnt > 0) {
                	tTariff = "DMIF" + "," + tTariff;
                }

                if(dtic_cnt > 0) {
                	tTariff = "DTIC" + "," + tTariff;
                }

                if(dmof_cnt > 0) {
                	tTariff = "DMOF" + "," + tTariff;
                }

                if(dtoc_cnt > 0) {
                	tTariff = "DTOC" + "," + tTariff;
                }

                if(ctic_cnt > 0) {
                	tTariff = "CTIC" + "," + tTariff;
                }

                if(ctoc_cnt > 0) {
                	tTariff = "CTOC" + "," + tTariff;
                }                
                document.form.tarfMail.value = tTariff;
                
                formObj.f_cmd.value = SEARCH09;
                
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
                
                var sXml09 = sheetObj.GetSaveXml("DMTCommonFaxEmailGS.do", FormQueryString(formObj));
                
                ComOpenWait(false);
                
                alert(dmtGetMsgText(sXml09));
            break;
            
            case IBSAVE:        //저장
            	
                formObj.f_cmd.value = MULTI; // updateOTSInquiryByDetailListRemark
                sheetObj.WaitImageVisible = false;                
				sheetObj.DoSave("EES_DMT_4017GS.do", FormQueryString(formObj));
				
				break;
        }
    }



    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
            if(ComTrim(ComGetObjValue(formObj.combo2)) == "") {
                ComAlertFocus(formObj.combo2, ComGetMsg('DMT02002', "Issue Office"));
                return false;
            }
            if(ComTrim(ComGetObjValue(formObj.combo1)) == "") {
                ComAlertFocus(formObj.combo1, ComGetMsg('DMT02002', "Tariff Type"));
                return false;
            }
            if(ComTrim(ComGetObjValue(formObj.combo3)) == "") {
                ComAlertFocus(formObj.combo3, ComGetMsg('DMT02002', "A/R I/F"));
                return false;
            }
            if(ComTrim(ComGetObjValue(formObj.frdt)) == "") {
                ComAlertFocus(formObj.frdt, ComGetMsg('DMT02002', "Issued Date"));
                return false;
            }
            if(ComTrim(ComGetObjValue(formObj.todt)) == "") {
                ComAlertFocus(formObj.todt, ComGetMsg('DMT02002', "Issued Date"));
                return false;
            }
        }

        return true;
    }

    /*
     * 다중선택된 DEM/DET Office의 하위점소(Sub Office) 조회기능 
     */
    function doInclSubOfc() {
        var formObj = document.form;
    
        if (formObj.chk_sub_ofc.checked) { // Sub Office 포함
            if (ComIsEmpty(comboObjects[0].Code)) {
                ComShowCodeMessage('COM12113', "DEM/DET Office");
                formObj.chk_sub_ofc.checked = false;
                return;
            }
            formObj.ofc_cd.value = ComGetObjValue(comboObjects[0]);
            formObj.tmp_ofc_cd.value = ComGetObjValue(comboObjects[0]);
            doActionIBCombo(sheetObjects[0], formObj, IBSEARCH_ASYNC03);
        } else {
            ComSetObjValue(comboObjects[0], formObj.tmp_ofc_cd.value);
        }
    }
    
    function checkSrepFlag() {
    	var sheetObj = sheetObjects[0];
        var formObj = document.form;

        if (formObj.chk_srep_flg1.checked) {
            formObj.chk_srep_flg.value = "Y";
//    		sheetObj.ColHidden("ob_srep_cd") = false;
            with (formObj) {
	    		ComEnableManyObjects(true, ob_srep_cd);	// Disable (True) 처리
	    		DmtComSetClassManyObjects('input', ob_srep_cd);
            }
        } else {
            formObj.chk_srep_flg.value = "N";
//        	sheetObj.ColHidden("ob_srep_cd") = true;
            with (formObj) {
	        	ComEnableManyObjects(false, ob_srep_cd)	// Disable (false) 처리
	        	DmtComSetClassManyObjects('input2', ob_srep_cd);	// 회색 처리
	        	ComClearManyObjects(ob_srep_cd);					// 초기화 및 사용 금지
            }
        }
    }
    
    function combo1_OnKeyDown(comboObj, KeyCode, Shift) {
        if ( KeyCode == 13 ) {
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
    }
    
    function combo3_OnKeyDown(comboObj, KeyCode, Shift) {
        if ( KeyCode == 13 ) {
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
    }
    
    function combo4_OnKeyDown(comboObj, KeyCode, Shift) {
        if ( KeyCode == 13 ) {
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
    }    
    
    //멀티콤보 클릭 이벤트
    function combo1_OnCheckClick(comboObj, index, code) {
        if(index==0) {
            //checked
            var bChk = comboObj.CheckIndex(index);
            for(var i = 1 ; i < comboObj.GetCount() ; i++) {
                comboObj.CheckIndex(i) = bChk;
            }
        } else {
            comboObj.CheckIndex(0) = false;
        }
    }   

    //멀티콤보 클릭 이벤트
    function combo3_OnCheckClick(comboObj, index, code) {
        if(index==0) {
            //checked
            var bChk = comboObj.CheckIndex(index);
            for(var i = 1 ; i < comboObj.GetCount() ; i++) {
                comboObj.CheckIndex(i) = bChk;
            }
        } else {
            comboObj.CheckIndex(0) = false;
        }
    }  
    
    //멀티콤보 클릭 이벤트
    function combo4_OnCheckClick(comboObj, index, code) {
        if(index==0) {
            //checked
            var bChk = comboObj.CheckIndex(index);
            for(var i = 1 ; i < comboObj.GetCount() ; i++) {
                comboObj.CheckIndex(i) = bChk;
            }
        } else {
            comboObj.CheckIndex(0) = false;
        }
    }      

    //멀티콤보 클릭 이벤트
    function sal_tm_OnCheckClick(comboObj, index, code) {
        if(index==0) {
            //checked
            var bChk = comboObj.CheckIndex(index);
            for(var i = 1 ; i < comboObj.GetCount() ; i++) {
                comboObj.CheckIndex(i) = bChk;
            }
        } else {
            comboObj.CheckIndex(0) = false;
        }
    }          

    function sal_tm_OnKeyDown(comboObj, KeyCode, Shift) {
        if ( KeyCode == 13 ) {
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
    } 
    
    function combo2_OnCheckClick(comboObj, index, code) {
        var formObj = document.form;
        
        if(formObj.chk_sub_ofc.checked) {
   			if(comboObj.CheckIndex(index))
   				comboObj.CheckIndex(index) = false;
   			else
   				comboObj.CheckIndex(index) = true;
   			
   			ComShowCodeMessage('DMT00107');
   		}
    }
    
	// 멀티콤보 KeyDown Event Catch (2010.03.18 추가)
 	function combo2_OnKeyDown(comboObj, keycode, shift) {
		var formObj = document.form;
		
   		if(formObj.chk_sub_ofc.checked) {
   			ComShowCodeMessage('DMT00107');
   		}
 	}
 	

    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
        with (sheetObj) {
            
            if ( RowCount <= 0 ) {
                ComBtnDisable("btn1_detail");
                ComBtnDisable("btn1_fax_send");
                ComBtnDisable("btn1_email_send");
                ComBtnDisable("btn1_excel");         
                ComBtnDisable("btn1_det_excel");  
                ComBtnDisable("btn1_save");
                return; 
            }
            
            for ( var x = 1 ; x < LastRow ; x++ ) {
                if ( CellValue( x , 9 ) == "Y" ) {
                    ToolTipText( x , 2 ) = "Payer Code not available any more";
                    CellFontColor( x , 2 ) = RgbColor( 220 , 0 , 0 );
                }
            }            
            
            ComBtnEnable("btn1_detail");
            ComBtnEnable("btn1_fax_send");
            ComBtnEnable("btn1_email_send");
            ComBtnEnable("btn1_excel");   
            ComBtnEnable("btn1_det_excel");
            ComBtnEnable("btn1_save");
            
            SumText  ( 0 , "SEQ"      ) = "Total";
            CellAlign( 0 , "SEQ"      ) = daCenter;
            
           
        }
        
        doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC09);
    }    
    
    function sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y){
            document.form.chk_payer.value = sheetObjects[0].CellValue(sheetObjects[0].MouseRow , 3);
            document.form.chk_payer2.value = sheetObjects[0].CellValue(sheetObjects[0].MouseRow , 4);
    }
    
    function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
    	if ( Row > 0 && Col != 1 && Col != 17 ) {
        	var formObject = document.form;
            document.form.chk_payer.value = sheetObjects[0].CellValue(sheetObjects[0].MouseRow , 3);
            document.form.chk_payer2.value = sheetObjects[0].CellValue(sheetObjects[0].MouseRow , 4);
//            document.form.tftp.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow , 10);
            document.form.tftp.value = comboObjects[1].Code;
                    ComSetObjValue( formObject.isof , comboObjects[0].Code );
                    ComSetObjValue( formObject.arif , comboObjects[2].Code );
                    ComSetObjValue( formObject.cutp , comboObjects[3].Code );
                    var tArif = formObject.arif.value;
                    var logInOff = document.form.h_rhq_off.value;
                    if ( logInOff != "NYCRA" && logInOff != "SELHO" ) {
                        if ( tArif == "A" ) {
                            tArif = "Y,N";
                        }
                    }   
                    var param = "?isof=" + formObject.isof.value +
                                "&tftp=" + formObject.tftp.value +
                                "&frdt=" + formObject.frdt.value +
                                "&todt=" + formObject.todt.value +
                                "&arif=" + tArif +
                                "&payc=" + formObject.chk_payer.value +
                                "&cutp=" + formObject.cutp.value +
                                "&cuno=" + formObject.cuno.value +
                                "&cude=" + formObject.cude.value +
                                "&scno=" + formObject.scno.value +
                                "&rfan=" + formObject.rfan.value +
                    			"&prg_ex_in_cd=" + formObject.prg_ex_in_cd.value +
                    			"&sal_tm=" + comboObjects[4].Code +
                    			"&sal_rep=" + formObject.sal_rep.value +
                    			"&curr_sel=" + formObject.curr_sel.value;
                                //"&payn=" + formObject.chk_payer2.value ;
                    ComOpenPopup( "/hanjin/EES_DMT_4018.do"+param , 1030, 730 , "" , "1,0,1,1,1,1,1,1" , true );
    	}
    }
    

    function sheet1_OnClick( sheetObj , Row , Col , Value ) {
        with (sheetObj) {
        	if ( Row > 0 && Col == 3 ) {
        		document.form.payc.value = sheetObj.CellValue(Row, 3);
        		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC09);
        	}
        }
    }
    
    //Payer 체크
    function doActionText(sheetObj, formObj, object, formCmd) {
        sheetObj.ShowDebugMsg = false;
        sheetObj.WaitImageVisible = false;
        var cust_len = parseInt(ComGetLenByByte(ComGetObjValue(formObj.payc1)));
        
        if(cust_len == 0) {
            ComSetObjValue(formObj.payn, "");
            return;
        }
        
        if(cust_len == 6) {
            ComSetObjValue(formObj.s_cust_gubun, "1");
            ComSetObjValue(formObj.s_cust_cd, formObj.payc1.value);
        }else if(cust_len > 6) {
            ComSetObjValue(formObj.s_cust_gubun, "2");
            ComSetObjValue(formObj.s_cust_cd, formObj.payc1.value);
        }else {
            ComSetObjValue(formObj.s_cust_gubun, "");
            ComSetObjValue(formObj.payc1, "");
            ComSetObjValue(formObj.payn, "");
            ComSetFocus(formObj.payc1);
            ComShowCodeMessage("COM12143", "Payer", "6");
            return;
        }
        ComSetObjValue(formObj.f_cmd, formCmd);
        var sXml    = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
        var cust_cd = ComGetEtcData(sXml, "PAYER_CODE");
        var cust_nm = ComGetEtcData(sXml, "PAYER_NM");
        var delt_flg = ComGetEtcData(sXml, "DELT_FLG");
        
        
        if(cust_nm == null || cust_nm == "") {
            ComShowCodeMessage("COM132201", "Payer", "8");
            ComSetFocus(formObj.payc1);
                document.form.s_cust_gubun.value = "";
                document.form.payc1.value = "";
                document.form.payn.value = "";                
        }else{
            ComSetObjValue(formObj.payn, cust_nm);
            document.form.payc1.value = cust_cd;
        }
        sheetObj.WaitImageVisible = true;
        
    }
    
    //Customer 체크
    function doActionText2(sheetObj, formObj, object, formCmd) {
        sheetObj.ShowDebugMsg = false;
        sheetObj.WaitImageVisible = false;
        var cust_len = parseInt(ComGetLenByByte(ComGetObjValue(formObj.cuno)));
        var tCuno = ComGetObjValue(formObj.cuno);
        
        if(cust_len == 0) {
            ComSetObjValue(formObj.cude, "");
            return;
        }
        
        
        
        if(cust_len == 2) {
            ComSetObjValue(formObj.cust_cnt_cd, tCuno);
            ComSetObjValue(formObj.cust_seq   , "0000");
        }else if(cust_len > 2) {
            ComSetObjValue(formObj.cust_cnt_cd, tCuno.substring(0,2));
            ComSetObjValue(formObj.cust_seq   , tCuno.substring(2,cust_len));
        }else {
            ComSetObjValue(formObj.cust_cnt_cd, "");
            ComSetObjValue(formObj.cust_seq   , "");
            ComSetFocus(formObj.cuno);
            ComShowCodeMessage("COM12143", "Customer Code ", "8");
            return;
        }
        ComSetObjValue(formObj.f_cmd, formCmd);

        var sXml    = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
        var cust_nm = ComGetEtcData(sXml, "CUST_NM");
        
        
        if(cust_nm == null || cust_nm == "") {
            ComShowCodeMessage("COM132201", "Customer Code", "8");
            
            document.form.cuno.value = "";
            document.form.cude.value = "";
            document.form.cust_cnt_cd.value = "";
            document.form.cust_seq.value = "";
            ComSetFocus(formObj.cuno);
        }else{
            ComSetObjValue(formObj.cude, cust_nm);
            //document.form.payc.value = cust_cd;
        }
        sheetObj.WaitImageVisible = true;
        
    }    
    
    function keyPress() {
        var obj = event.srcElement;
        var eventKey = window.event.keyCode ;
        if( eventKey == 13 ) {
            if ( obj.name == "payc1" || obj.name == "cuno" ) {
                if(obj.name == 'payc1') {
                    doActionText(sheetObjects[0], document.form, obj, SEARCH20);
                }else if(obj.name == 'cuno') {
                    doActionText2(sheetObjects[0], document.form, obj, SEARCH19);
                }                
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
            } else {
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
            }
        }
    }
    document.onkeypress = keyPress ;
    
    function open5101(){ // HOLD REASON ENTRY
        ComOpenPopupWithTarget('/hanjin/EES_DMT_5101.do?invoiceNo=LGT025949', 540, 380, "", "0,1,1,1,1,1,1", true);
    }
    
    
function dmtGetMsgText(xmlStr){

    try {
        var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
        xmlDoc.loadXML(xmlStr);

        var xmlRoot = xmlDoc.documentElement;
        if(xmlRoot == null) return;

        var msgNode = xmlRoot.getElementsByTagName("MESSAGE").item(0);
        if(msgNode == null) 
         return;
        else
         return msgNode.firstChild.nodeValue;
   } catch(err) { ComFuncErrMsg(err.message); }
   
}


/**
 * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
 */
function getBackEndJobStatus() {
		
 	var formObj = document.form;
 	var sheetObj = sheetObjects[0];

 	//It gets a status of backendjob. 2
 	ComSetObjValue(formObj.f_cmd, COMMAND03);

 	var params		= "f_cmd=" + COMMAND03 + "&backendjob_key=" + ComGetObjValue(formObj.backendjob_key);
 	var sXml		= sheetObj.GetSearchXml("EES_DMT_4017GS.do", params);
 	
 	var arrXml = sXml.split("|$$|");
	var sJbStsFlg = ComGetEtcData(arrXml[0], "jb_sts_flg");

	if (sJbStsFlg == "SUCCESS") {
		clearInterval(timer);
		ComOpenWait(false);
		sheetObjects[0].LoadSearchXml(arrXml[0]);
		formObj.currSelect.value = formObj.curr_sel.value;
	} else if (sJbStsFlg == "FAIL") {
		// 에러
		clearInterval(timer);
		ComOpenWait(false);
		// 에러메시지 보여주고
		ComShowMessage(ComResultMessage(arrXml[0]));
	}
 }
 
