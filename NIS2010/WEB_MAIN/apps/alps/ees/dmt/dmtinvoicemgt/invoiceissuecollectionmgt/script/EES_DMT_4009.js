/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_4009.js
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
     * @class ui_dmt_4009 : ui_dmt_4009 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
function ui_dmt_4009() {
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
var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var COMMON_TARIFF_CD = "common_tariff_cd"; 
var USER_TARIFF_TYPE = "user_tariff_type"; 
var USER_TARIFF_TYPE_CD;
var USER_TARIFF_TYPE_CD2;

var ROWMARK = "|";
var FIELDMARK = "=";
var set_day = 180;
var USR_TRF_TP;    
var USR_TRF_TP2;    
var oldFmDate="";
var preToDate="";

var IBSEARCH_CHECK_ROLE		= 101;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         
         var sheetObject1 = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];
         
         /*******************************************************/
         var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

                case "btns_payer_cd":
                    openPopup('payc');
                break;
                
                case "btns_payer_cd2":
                	openPopup('payc2');
                	break;

                case "btns_cust_cd":
                    openPopup('cuno');
                break;
                
                case "btns_cust_cd2":
                	openPopup('cuno2');
                	break;
            
                case "btn1_excel":
                	if(formObject.tab_order.value == 0) {
	                    if( sheetObject1.RowCount == 0 ) {
	                        ComBtnDisable("btn1_excel");
	                        return;
	                    }                     
	                    sheetObject1.SpeedDown2Excel(-1);                	
                	}else{
                		if( sheetObject2.RowCount == 0 ) {
	                        ComBtnDisable("btn1_excel");
	                        return;
	                    }                     
	                    sheetObject2.SpeedDown2Excel(1);
                	}
                break;

                case "btn1_retrieve":
                	if(beforetab == 0) {
	                    doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                	}else if(beforetab == 1) {
	                    doActionIBSheet(sheetObject2,formObject,IBSEARCH);
                	}
                break;
                
                case "btn1_new":
                    var formObject = document.form;
                    formObject.reset();
//                    formObject.combo2.focus();
                    
                    //Period Date 초기화
            		//사용자 Office 의 현재 날짜를 조회한다.
            		var ofcCurrDate = DmtComOfficeCurrDate(sheetObjects[0], formObject);
            		
            		// Tab1
        			var fmMvmtDt = ComGetDateAdd(formObject.ofcCurrDate, "D", -180);
            		var toMvmtDt = ofcCurrDate;
            		oldFmDate	= fmMvmtDt;
            		preToDate	= toMvmtDt;
            		ComSetObjValue(formObject.frdt, fmMvmtDt);
            		ComSetObjValue(formObject.todt, toMvmtDt);
            		sheetObject1.RemoveAll();
            		
            		// Tab2                		
            		var fmMvmtDt2= '2008-01-01';
            		var toMvmtDt2= ofcCurrDate;
            		oldFmDate2	= fmMvmtDt2
            		preToDate2	= toMvmtDt2
            		ComSetObjValue(formObject.frdt2, fmMvmtDt2);
            		ComSetObjValue(formObject.todt2, toMvmtDt2);
            		sheetObject2.RemoveAll();
            		
            		checkSrepFlag();	//Local S/Rep. 에 대한 초기화 작업
            		for(var k=0;k<comboObjects.length;k++){
                        //initCombo(comboObjects[k],k+1);
                        comboObjects[k].Code = "-1";
                        comboObjects[k].RemoveAll();
                    }                    
            		for(var k=0;k<comboObjects.length;k++){
                        initCombo(comboObjects[k],k+1);
                    }
            		ComSetObjValue(formObject.tab_order, beforetab);
            		
	                ComBtnDisable("btn1_detail");
	                ComBtnDisable("btn1_fax_send");
	                ComBtnDisable("btn1_email_send");
	                ComBtnDisable("btn1_excel");
                break;

                case "btn1_detail":
                	if(formObject.tab_order.value == 0) {
                		if( sheetObject1.RowCount == 0 ) {
        	                ComBtnDisable("btn1_detail");
    	                    return;
	                    }
	                    // Outstanding Inquiry by Customer & Issue - Detail(s) 팝업화면을 호출한다.
    	                openOutstandingInquiryDetail(sheetObject1);
                	}else if(formObject.tab_order.value == 1) {
                		if( sheetObject2.RowCount == 0 ) {
        	                ComBtnDisable("btn1_detail");
    	                    return;
	                    }
    	                openOutstandingInquiryDetail(sheetObject2);
                	}
                break;
            
                case "btns_calendarfm":
                    var cal = new ComCalendarFromTo();
                    cal.select(formObject.frdt, formObject.todt, 'yyyy-MM-dd');
                break;
                
                case "btns_calendarto":
                    var cal = new ComCalendarFromTo();
                    cal.select(formObject.frdt, formObject.todt, 'yyyy-MM-dd');
                break;
                
                case "btns_calendarfm2":
                    var cal = new ComCalendarFromTo();
                    cal.select(formObject.frdt2, formObject.todt2, 'yyyy-MM-dd');
                break;
                
                case "btns_calendarto2":
                    var cal = new ComCalendarFromTo();
                    cal.select(formObject.frdt2, formObject.todt2, 'yyyy-MM-dd');
                break;
                
                case "btn1_email_send":
                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC04);
                break;
                
                case "btn1_fax_send":
                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC05);
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
                case 'payc2':
                    ComOpenPopup('COM_ENS_041.do', 770, 470, "getPayerCd", "1,0,1,1,1,1,1", true);
                break;
                    
                case 'cuno':       // Customer Inquiry Popup
                case 'cuno2':
                    ComOpenPopup('COM_ENS_041.do', 770, 470, "getCustCd", "1,0,1,1,1,1,1", true);
                break;
                
                case 'scno2':
	  			case 'rfan2':
	  			case 'taano':
	  				var returntitle = '';
	  				if(flag == 'scno2')
	  					returntitle = 'S/C No.';
	  				else if(flag == 'rfan2')
	  					returntitle = 'RFA No.';
	  				else if(flag == 'taano')
	  					returntitle = 'TAA No.';
	  				var param = "?returnval=" + flag + "&returntitle=" + returntitle;
	  				ComOpenPopup('EES_DMT_MULTI.do'+param, 400, 380, 'getDmt_Multi', '1,0,1,1,1,1,1,1,1,1,1,1', true);
					break;
                
            } // switch-end
        } // with-end
        
    }
    
    /*
     * Customer 공통팝업에서 선택한 Customer Code값을 해당 필드에 설정 
     */
    function getPayerCd(aryPopupData) {
    	if(document.form.tab_order.value == 0) {
    		document.form.payc.value = aryPopupData[0][3];
            document.form.payn.value = aryPopupData[0][4];	
    	}else{
    		document.form.payc2.value = aryPopupData[0][3];
    		document.form.payn2.value = aryPopupData[0][4];	
    	}        
    }  
    
    /*
     * Customer 공통팝업에서 선택한 Customer Code값을 해당 필드에 설정 
     */
    function getCustCd(aryPopupData) {
    	if(document.form.tab_order.value == 0) {
        	document.form.cuno.value = aryPopupData[0][3];
            document.form.cude.value = aryPopupData[0][4];
    	}else if(beforetab == 1) {
    		document.form.cuno2.value = aryPopupData[0][3];
            document.form.cude2.value = aryPopupData[0][4];
    	}
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
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;
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
        
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
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
		var fmMvmtDt2= '2008-01-01';
		var toMvmtDt2= ofcCurrDate;		

		oldFmDate	= fmMvmtDt;
		preToDate	= toMvmtDt;
		oldFmDate2	= fmMvmtDt2
		preToDate2	= toMvmtDt2
		
		ComSetObjValue(formObject.frdt, fmMvmtDt);
		ComSetObjValue(formObject.todt, toMvmtDt); 
		ComSetObjValue(formObject.frdt2, fmMvmtDt2);
		ComSetObjValue(formObject.todt2, toMvmtDt2);		
		
        comboObjects[1].Code2 = USER_TARIFF_TYPE_CD;
        comboObjects[6].Code2 = USER_TARIFF_TYPE_CD2;
        
        checkSrepFlag();	//Local S/Rep. 에 대한 초기화 작업 (Tab2 Contract S/Rep 추가)
        
        ComBtnDisable("btn1_detail");
        ComBtnDisable("btn1_fax_send");
        ComBtnDisable("btn1_email_send");
        ComBtnDisable("btn1_excel");

  		//권한을 확인한다.
    	var sheetObj 	= sheetObjects[0];
    	doActionIBCombo(sheetObj,formObject,IBSEARCH_CHECK_ROLE);
        
    	if ( ComGetObjValue(formObject.role_permit) != "Y"){
    		tabObjects[0].TabEnable(0) = false;
    		tabObjects[0].SelectedIndex = 1;
    	}
    }

    function initControl() {
        axon_event.addListenerForm  ( 'blur'     , 'obj_blur'      , document.form ); //- 포커스 나갈때
        axon_event.addListenerFormat( 'focus'    , 'obj_focus'     , document.form ); //- 포커스 들어갈때
        axon_event.addListenerFormat( 'keypress' , 'obj_keypress'  , document.form ); //- 키보드 입력할때
        axon_event.addListener      ( 'keydown'  , 'ComKeyEnter'   , 'form'        );
//        axon_event.addListenerForm('click', 'obj_click', document.form);
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
        }else if ( ( obj.name == 'frdt2' || obj.name == 'todt2' ) && ComGetObjValue(formObj.frdt2) != "" && ComGetObjValue(formObj.todt2) != "" ) {
        	if ( ! ComChkObjValid(obj) ) {
        		if ( obj.name == 'frdt2'  ) {
        			ComSetObjValue(formObj.frdt2, oldFmDate2);
        		} else if (obj.name == 'todt2' ) {
        			ComSetObjValue(formObj.todt2, preToDate2);
        		}
        	} else {
        		oldFmDate2	= ComGetObjValue(formObj.frdt2);
        		preToDate2	= ComGetObjValue(formObj.todt2);
        	}
    	}else if(obj.name == 'payc' || obj.name == 'payc2') {
            doActionText(sheetObjects[0], formObj, obj, SEARCH20);
        }else if(obj.name == 'cuno' || obj.name == 'cuno2') {
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
                
            case 1: case 7: // TARIFF TYPE
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
                if(comboNo == 1){
                	doActionIBCombo(sheetObjects[0], formObject, SEARCHLIST);	
                }else{
                	doActionIBCombo(sheetObjects[1], formObject, SEARCHLIST);
                }           
            break; 
                
            case 2: case 6: // ISSUE OFFICE case 10:  
                with (comboObj) { 
                    MultiSelect = true; 
                    SetColAlign("left|left");   
                    SetColWidth("60|300");
                    ValidChar(2,0);		//영문 대문자
					IMEMode = 0;
                    DropHeight = 160;
                }
                if(comboNo == 2){
                	doActionIBCombo(sheetObjects[0], formObject, IBSEARCH_ASYNC02);	
                }else if(comboNo == 10){
                    	doActionIBCombo(sheetObjects[1], formObject, IBSEARCH_ASYNC04);                	
                }else{
                	doActionIBCombo(sheetObjects[1], formObject, IBSEARCH_ASYNC02);
                }
            break;
            
            case 3: case 8: // AR IF
                var logInOff = document.form.h_rhq_off.value;
                if ( logInOff == "NYCRA" || logInOff == "SELHO" ) {
                    with (comboObj) { 
                        MultiSelect = true; 
                        SetColAlign("left|left");   
                        SetColWidth("100|300");
                        DropHeight = 160;
                    }
                    comboObj.InsertItem( 0 , "All|"                                               , "All" );
                    comboObj.InsertItem( 1 , "No|"                                                , "N" );
                    comboObj.InsertItem( 2 , "Yes|"                                               , "Y" );
                    comboObj.InsertItem( 3 , "Hold|All Reasons"                                   , "H" );
                    comboObj.InsertItem( 4 , "Hold(Litigation)|Collection Agency/Litigation Only" , "L" );
                    comboObj.Code = comboNo == 3 ? "All,N,Y,H,L" : "N,Y";    
//                    comboObj.CheckIndex(0) = true;// Default : Uncollected
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
                    comboObj.Code2 = "A";
                }
            break;
            
            case 4: case 11: // Collection
                var logInOff = document.form.h_rhq_off.value;
                with (comboObj) { 
                    MultiSelect = false; 
                    SetColAlign("left");   
                    SetColWidth("100");
                    DropHeight = 160;
                }
                comboObj.InsertItem( 0 , "All|"                                               , "A" );
                comboObj.InsertItem( 1 , "Uncollected|"                                       , "N" );
                comboObj.InsertItem( 2 , "Collected|"                                         , "Y" );
                comboObj.Code2 = "N";
            break;
            
            case 5: case 12: // CUSTOMER TYPE
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
            
            case 9:

    	 		with (comboObj) { 
	    	 		RemoveAll();
					MultiSelect = false;
					SetColWidth("45");
					ValidChar(2);	// 영대문자만 사용
					//MaxLength = 6;
    	 		}
    			// RHQ
            	doActionIBCombo(sheetObjects[1], formObject, COMMAND06);
            	break;
            
         } 
    }

    function doActionIBCombo(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        sheetObj.WaitImageVisible = false;
        
        switch(sAction) {
                case SEARCHLIST:
                	var comboObj = (sheetObj == sheetObjects[0]) ? comboObjects[1] : comboObjects[6];
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
                    if(data2 == '') data2 = (sheetObj == sheetObjects[0]) ? 'CTIC,DMIF' : 'All,DMIF,DTIC,DMOF,DTOC,CTIC,CTOC';
                    comboObj.Code2 = data2;                    
                    if(sheetObj == sheetObjects[0]) {
                    	USR_TRF_TP = data2;
                        formObj.usr_trf_tp.value = data2;
                        USER_TARIFF_TYPE_CD = data2;
                    } else {
                    	USR_TRF_TP2 = data2;
                        formObj.usr_trf_tp2.value = data2;
                        USER_TARIFF_TYPE_CD2 = data2;
                    }
                break;
                
                case IBSEARCH_ASYNC02:
                	// 2010.03.18 수정
                    //2. Office comboList
                    formObj.f_cmd.value = SEARCHLIST02;
                    formObj.ots_flg.value = '';
                    var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
                    var ofc_cds = ComGetEtcData(sXml, "OFC_CD");
                    var ofc_nms = ComGetEtcData(sXml, "OFC_NM");
                    
                    if (ofc_cds != undefined && ofc_cds != '') {                    	
                    	var comboObj = (sheetObj == sheetObjects[0]) ? comboObjects[0] : comboObjects[5];
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
                    	var comboObj = (sheetObj == sheetObjects[0]) ? comboObjects[0] : comboObjects[5];        	 			
        	 			var usrOfcCd = ComGetObjValue(formObj.h_user_office);
    					
    					if(comboObj.Code.indexOf(usrOfcCd) != -1 && subOfcCds.indexOf(usrOfcCd)==-1)
    						subOfcCds = usrOfcCd + ',' + subOfcCds;
    	    	   			
    					comboObj.Code = subOfcCds;
    		 		}
        	 		break;
        	 		
                case IBSEARCH_ASYNC04: 
                	//Tab2 Issued Office comboList
                    formObj.f_cmd.value = SEARCHLIST02;
//                    formObj.shd_rhq_cd.value = 'SELHO';
                    formObj.ots_flg.value = 'Y';
                    var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
                    var ofc_cds = ComGetEtcData(sXml, "OFC_CD");
                    var ofc_nms = ComGetEtcData(sXml, "OFC_NM");
                    
                    if (ofc_cds != undefined && ofc_cds != '') {                    	
                    	var comboObj = comboObjects[9];
                    	var usrOfcCd = ComGetObjValue(formObj.h_user_office);
     					
     					comboObj.RemoveAll();
     					
                        with (comboObj) { 
                            MultiSelect = true; 
                            SetColAlign("left|left");   
                            SetColWidth("50|300");
                            ValidChar(2,0);		//영문 대문자
        					IMEMode = 0;
                            DropHeight = 160;
                        }
     					  					
     					var comboCodeArr = ofc_cds.split("|");                      
                        var comboTextArr = ofc_nms.split("|");

                        comboObj.InsertItem(0, "All|All", "All");
     					var idx = 1;
                        for (var i = 0 ; i < comboTextArr.length ; i++) {
                            comboObj.InsertItem(idx+i, comboCodeArr[i] + "|" + comboTextArr[i], comboCodeArr[i]);       
                        }                        
                        // 로그인 User Office를 Default로 설정
//    	    	  		comboObj.Code = usrOfcCd;
                    }
                    formObj.shd_rhq_cd.value = '';
                    break;
                    
                case IBSEARCH_ASYNC05:
                	// 2010.03.18 수정
                    //3. Sub Office comboList
                    formObj.f_cmd.value = COMMAND01;
                    var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
                    var subOfcCds = ComGetEtcData(sXml, "OFC_CD");
                    
        	 		if (subOfcCds != undefined && subOfcCds != '') {
                    	var comboObj = comboObjects[9];        	 			
        	 			var usrOfcCd = ComGetObjValue(formObj.h_user_office);
    					
    					if(comboObj.Code.indexOf(usrOfcCd) != -1 && subOfcCds.indexOf(usrOfcCd)==-1)
    						subOfcCds = usrOfcCd + ',' + subOfcCds;
    	    	   			
    					comboObj.Code = subOfcCds;
    		 		}
        	 		break;

        			
    				//로그인 User가 Security 상에서 Access 권한이 있는지 조회한다.
    			case IBSEARCH_CHECK_ROLE:

    				ComSetObjValue(formObj.f_cmd, COMMAND12);
    				ComOpenWait(true);
    				sheetObj.WaitImageVisible = false;
    				//*********************************************************************************
    				
    				var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));

    				//*********************************************************************************
    				ComOpenWait(false);
    				//*********************************************************************************

    				//3.조회결과 처리
    				ComSetObjValue(formObj.role_auth, 	handleNullString(ComGetEtcData(sXml, "ROLE_AUTH")));
    				ComSetObjValue(formObj.role_permit, handleNullString(ComGetEtcData(sXml, "ROLE_PERMIT")));
    				    				
    				break;

        	 	case COMMAND06:	// RHQ

    				ComSetObjValue(formObj.f_cmd, COMMAND06);
    				ComOpenWait(true);
    				sheetObj.WaitImageVisible = false;
        	    	var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));

    				ComOpenWait(false);
                	var comboObj = comboObjects[8];
        	 		var data = ComGetEtcData(sXml, "common_cd");
    				if (data != undefined && data != '') {
    					var comboItems = data.split("|");
    					
    					for (var i = 0 ; i < comboItems.length ; i++) {
    		    	    	comboObj.InsertItem(i, comboItems[i], comboItems[i]);		
    		         	}
    				}

        			var usrRhqOfcCd = ComGetObjValue(formObj.h_rhq_off);
      	   		
        	   		ComSetObjValue(comboObj, usrRhqOfcCd);
        	   		
        	   		formObj.shd_rhq_cd.value = usrRhqOfcCd;        	   		
        	   	 
        	   		doActionIBCombo(sheetObjects[1], formObj, IBSEARCH_ASYNC04);    
        	 		
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
                    style.height = 402;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 3, 1, 3, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle  = "|Seq.|Payer CD|Payer Name|Local S/Rep.|Count|Cur.|Billing AMT|TAX AMT|Payable AMT|Collected Status in ERP|Collected Status in ERP|Collected Status in ERP|Uncollected AMT|Auto Sending Setup|Auto Sending Setup|Auto Sending Setup|Auto Sending Setup|OTS Sheet|usrflg|dmifyn|dticyn|dmofyn|dtocyn|cticyn|ctocyn|dmdt_vt_inv_yn";
                    var HeadTitle1  = "|Seq.|Payer CD|Payer Name|Local S/Rep.|Count|Cur.|Billing AMT|TAX AMT|Payable AMT|Collected Amount|Collected Amount|Collected Date|Uncollected AMT|E-mail Address|Sending Cycle|OTS Sheet|OTS Sheet|OTS Sheet|usrflg|dmifyn|dticyn|dmofyn|dtocyn|cticyn|ctocyn|dmdt_vt_inv_yn";
                    var HeadTitle2  = "|Seq.|Payer CD|Payer Name|Local S/Rep.|Count|Cur.|Billing AMT|TAX AMT|Payable AMT|Charge|Tax|Collected Date|Uncollected AMT|E-mail Address|Sending Cycle|Group by|With CNTR List|With Invoice|usrflg|dmifyn|dticyn|dmofyn|dtocyn|cticyn|ctocyn|dmdt_vt_inv_yn";
                    
                    var headCount = ComCountHeadTitle(HeadTitle);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    InitHeadRow(1, HeadTitle1, true);
                    InitHeadRow(2, HeadTitle2, true);

                    //데이터속성    [ROW, COL   , DATATYPE   , WIDTH, DATAALIGN, COLMERGE, SAVENAME   , KEYFIELD, CALCULOGIC, DATAFORMAT    , POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    
                    InitDataProperty( 0 , cnt++ , dtCheckBox , 30   , daCenter , true    , "CheckBox" 		, false                                   );
                    InitDataProperty( 0 , cnt++ , dtSeq      , 40   , daCenter , true    , "SEQ"      		, false   , ""        , dfNone        	, 0         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtData     , 70   , daCenter , true    , "payerc"   		, false   , ""        , dfNone        	, 0         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtData     , 320  , daLeft   , true    , "payern"   		, false   , ""        , dfNone        	, 0         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtData     , 80   , daCenter , true    , "ob_srep_cd" 	, false   , ""        , dfNone        	, 0         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtAutoSum  , 50   , daCenter , true    , "invocn"   		, false   , ""        , dfNullInteger 	, 0         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtData     , 50   , daCenter , true    , "invocr"   		, false   , ""        , dfNone        	, 0         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtAutoSum  , 130  , daRight  , true    , "bllamt"   		, false   , ""        , dfNullFloat   	, 2         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtAutoSum  , 130  , daRight  , true    , "taxamt"   		, false   , ""        , dfNullFloat   	, 2         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtAutoSum  , 140  , daRight  , true    , "totamt"   		, false   , ""        , dfNullFloat   	, 2         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtAutoSum  , 100  , daRight  , true    , "col_charge"   	, false   , ""        , dfNullFloat   	, 2         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtAutoSum  , 100  , daRight  , true    , "col_tax"   		, false   , ""        , dfNullFloat   	, 2         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtData     , 100  , daCenter , true    , "col_date"   	, false   , ""        , dfNone        	, 0         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtAutoSum  , 150  , daRight  , true    , "uncol_amt"   	, false   , ""        , dfNullFloat   	, 2         , false     , false    );
                    
                    InitDataProperty( 0 , cnt++ , dtData     , 120  , daCenter  , true   , "eml_exist_flg" 	, false   , ""    , dfNone   		, 0         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtData     , 120  , daCenter  , true   , "snd_cyc_cd"   	, false   , ""    , dfNone   		, 0         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtData 	 , 80   , daCenter  , true   , "ots_sh_grp_cd"  , false   , ""    , dfNone   		, 0         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtData 	 , 70   , daCenter  , true   , "snd_cntr_list_flg" , false   , ""    , dfNone   		, 0         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtHidden 	 , 50   , daCenter  , true   , "snd_inv_flg"   	, false   , ""    , dfNone   		, 0         , false     , false    );
                    
                    InitDataProperty( 0 , cnt++ , dtHidden   , 0    , daCenter , true    , "useflg"   		, false   , ""        , dfNone       	, 0         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtHidden   , 50   , daCenter , true    , "dmifyn"   		, false   , ""        , dfNullInteger	, 0                                );
                    InitDataProperty( 0 , cnt++ , dtHidden   , 50   , daCenter , true    , "dticyn"   		, false   , ""        , dfNullInteger	, 0                                );
                    InitDataProperty( 0 , cnt++ , dtHidden   , 50   , daCenter , true    , "dmofyn"   		, false   , ""        , dfNullInteger	, 0                                );
                    InitDataProperty( 0 , cnt++ , dtHidden   , 50   , daCenter , true    , "dtocyn"   		, false   , ""        , dfNullInteger	, 0                                );
                    InitDataProperty( 0 , cnt++ , dtHidden   , 50   , daCenter , true    , "cticyn"   		, false   , ""        , dfNullInteger	, 0                                );
                    InitDataProperty( 0 , cnt++ , dtHidden   , 50   , daCenter , true    , "ctocyn"   		, false   , ""        , dfNullInteger	, 0                                );
                    InitDataProperty( 0 , cnt++ , dtHidden   , 70   , daCenter , true    , "dmdt_vt_inv_yn"	, false   , ""        , dfNone          , 0								   );
                    
                    CountPosition = 0;
                    
                    ToolTipOption = "balloon:true;width:50;";
                    ToolTipText(0,"invocn") = "Count of Invoices";
 
//                    sheetObj.ColHidden("ob_srep_cd") = true;
               }
            break;
            
            case "sheet2":      // sheet2 init
            	
            	with (sheetObj) {
            	// 높이 설정
            	style.height = 374;
            	// 전체 너비 설정
            	SheetWidth = mainTable.clientWidth;
            	
            	//Host정보 설정[필수][HostIp, Port, PagePath]
            	if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
            	
            	//전체Merge 종류 [선택, Default msNone]
            	MergeSheet = msHeaderOnly;
            	
            	//전체Edit 허용 여부 [선택, Default false]
            	Editable = true;
            	
            	//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            	InitRowInfo( 3, 1, 3, 100);
            	
            	// 해더에서 처리할 수 있는 각종 기능을 설정한다
            	InitHeadMode(true, true, true, true, false,false)
            	
            	var HeadTitle  = "|Seq.|Contract OFC|Contract S/Rep.|Contract|Contract nbr|Contract Cust code|Contract Cust name|Payer CD|Payer Name|Count|Cur.|Billing AMT|TAX AMT|Payable AMT|Collected Status in ERP|Collected Status in ERP|Collected Status in ERP|Uncollected AMT|Auto Sending Setup|Auto Sending Setup|Auto Sending Setup|Auto Sending Setup|OTS Sheet|usrflg|dmifyn|dticyn|dmofyn|dtocyn|cticyn|ctocyn|dmdt_vt_inv_yn|usd_locl_xch_rt";
            	var HeadTitle1  = "|Seq.|Contract OFC|Contract S/Rep.|Contract|Contract nbr|Contract Cust code|Contract Cust name|Payer CD|Payer Name|Count|Cur.|Billing AMT|TAX AMT|Payable AMT|Collected Amount|Collected Amount|Collected Date|Uncollected AMT|E-mail Address|Sending Cycle|OTS Sheet|OTS Sheet|OTS Sheet|usrflg|dmifyn|dticyn|dmofyn|dtocyn|cticyn|ctocyn|dmdt_vt_inv_yn|usd_locl_xch_rt";
            	var HeadTitle2  = "|Seq.|Contract OFC|Contract S/Rep.|Contract|Contract nbr|Contract Cust code|Contract Cust name|Payer CD|Payer Name|Count|Cur.|Billing AMT|TAX AMT|Payable AMT|Charge|Tax|Collected Date|Uncollected AMT|E-mail Address|Sending Cycle|Group by|With CNTR List|With Invoice|usrflg|dmifyn|dticyn|dmofyn|dtocyn|cticyn|ctocyn|dmdt_vt_inv_yn|usd_locl_xch_rt";
            	
            	var headCount = ComCountHeadTitle(HeadTitle)+1;
            	
            	//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            	InitColumnInfo(headCount, 0, 0, true);
            	
            	//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            	InitHeadRow(0, HeadTitle, true);
            	InitHeadRow(1, HeadTitle1, true);
            	InitHeadRow(2, HeadTitle2, true);
            	
            	//데이터속성    [ROW, COL   , DATATYPE   , WIDTH, DATAALIGN, COLMERGE, SAVENAME   , KEYFIELD, CALCULOGIC, DATAFORMAT    , POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            	
            	InitDataProperty( 0 , cnt++ , dtCheckBox , 30   , daCenter , true    , "CheckBox" 		, false                                   );
            	InitDataProperty( 0 , cnt++ , dtSeq      , 40   , daCenter , true    , "SEQ"      		, false   , ""        , dfNone        	, 0         , false     , false    );
            	InitDataProperty( 0 , cnt++ , dtData   	 , 90   , daCenter , true    , "ctrt_ofc_cd" 	, false   , ""        , dfNone        	, 0         , false     , false    );
            	InitDataProperty( 0 , cnt++ , dtData     , 110  , daCenter , true    , "ctrt_srep_cd" 	, false   , ""        , dfNone        	, 0         , false     , false    );
            	InitDataProperty( 0 , cnt++ , dtData     , 70   , daCenter , true    , "ctrt_tp" 		, false   , ""        , dfNone        	, 0         , false     , false    );
            	InitDataProperty( 0 , cnt++ , dtHidden   , 90   , daCenter , true    , "ctrt_no" 		, false   , ""        , dfNone        	, 0         , false     , false    );  
            	InitDataProperty( 0 , cnt++ , dtHidden   , 120  , daCenter , true    , "ctrt_cust_cd" 	, false   , ""        , dfNone        	, 0         , false     , false    );
            	InitDataProperty( 0 , cnt++ , dtHidden   , 320  , daLeft   , true    , "ctrt_cust_nm" 	, false   , ""        , dfNone        	, 0         , false     , false    );   
            	InitDataProperty( 0 , cnt++ , dtHidden   , 70   , daCenter , true    , "payerc"   		, false   , ""        , dfNone        	, 0         , false     , false    );
            	InitDataProperty( 0 , cnt++ , dtHidden   , 320  , daLeft   , true    , "payern"   		, false   , ""        , dfNone        	, 0         , false     , false    );       	
            	
            	InitDataProperty( 0 , cnt++ , dtAutoSum  , 50   , daCenter , true    , "invocn"   		, false   , ""        , dfNullInteger 	, 0         , false     , false    );
            	InitDataProperty( 0 , cnt++ , dtData     , 50   , daCenter , true    , "invocr"   		, false   , ""        , dfNone        	, 0         , false     , false    );
            	InitDataProperty( 0 , cnt++ , dtAutoSum  , 130  , daRight  , true    , "bllamt"   		, false   , ""        , dfNullFloat   	, 2         , false     , false    );
            	InitDataProperty( 0 , cnt++ , dtAutoSum  , 130  , daRight  , true    , "taxamt"   		, false   , ""        , dfNullFloat   	, 2         , false     , false    );
            	InitDataProperty( 0 , cnt++ , dtAutoSum  , 140  , daRight  , true    , "totamt"   		, false   , ""        , dfNullFloat   	, 2         , false     , false    );
            	InitDataProperty( 0 , cnt++ , dtAutoSum  , 100  , daRight  , true    , "col_charge"   	, false   , ""        , dfNullFloat   	, 2         , false     , false    );
            	InitDataProperty( 0 , cnt++ , dtAutoSum  , 100  , daRight  , true    , "col_tax"   		, false   , ""        , dfNullFloat   	, 2         , false     , false    );
            	InitDataProperty( 0 , cnt++ , dtData     , 100  , daCenter , true    , "col_date"   	, false   , ""        , dfNone        	, 0         , false     , false    );
            	InitDataProperty( 0 , cnt++ , dtAutoSum  , 150  , daRight  , true    , "uncol_amt"   	, false   , ""        , dfNullFloat   	, 2         , false     , false    );
            	
            	InitDataProperty( 0 , cnt++ , dtHidden   , 120  , daCenter  , true   , "eml_exist_flg" 	, false   , ""    , dfNone   		, 0         , false     , false    );
            	InitDataProperty( 0 , cnt++ , dtHidden   , 120  , daCenter  , true   , "snd_cyc_cd"   	, false   , ""    , dfNone   		, 0         , false     , false    );
            	InitDataProperty( 0 , cnt++ , dtHidden   , 80   , daCenter  , true   , "ots_sh_grp_cd"  , false   , ""    , dfNone   		, 0         , false     , false    );
            	InitDataProperty( 0 , cnt++ , dtHidden   , 70   , daCenter  , true   , "snd_cntr_list_flg" , false   , ""    , dfNone   		, 0         , false     , false    );
            	InitDataProperty( 0 , cnt++ , dtHidden 	 , 50   , daCenter  , true   , "snd_inv_flg"   	, false   , ""    , dfNone   		, 0         , false     , false    );
            	
            	InitDataProperty( 0 , cnt++ , dtHidden   , 0    , daCenter , true    , "useflg"   		, false   , ""        , dfNone       	, 0         , false     , false    );
            	InitDataProperty( 0 , cnt++ , dtHidden   , 50   , daCenter , true    , "dmifyn"   		, false   , ""        , dfNullInteger	, 0                                );
            	InitDataProperty( 0 , cnt++ , dtHidden   , 50   , daCenter , true    , "dticyn"   		, false   , ""        , dfNullInteger	, 0                                );
            	InitDataProperty( 0 , cnt++ , dtHidden   , 50   , daCenter , true    , "dmofyn"   		, false   , ""        , dfNullInteger	, 0                                );
            	InitDataProperty( 0 , cnt++ , dtHidden   , 50   , daCenter , true    , "dtocyn"   		, false   , ""        , dfNullInteger	, 0                                );
            	InitDataProperty( 0 , cnt++ , dtHidden   , 50   , daCenter , true    , "cticyn"   		, false   , ""        , dfNullInteger	, 0                                );
            	InitDataProperty( 0 , cnt++ , dtHidden   , 50   , daCenter , true    , "ctocyn"   		, false   , ""        , dfNullInteger	, 0                                );
            	InitDataProperty( 0 , cnt++ , dtHidden   , 70   , daCenter , true    , "dmdt_vt_inv_yn"	, false   , ""        , dfNone          , 0								   );
            	InitDataProperty( 0 , cnt++ , dtHidden   , 70   , daCenter , true    , "usd_locl_xch_rt"	, false   , ""        , dfNone          , 0								   );
            	
            	InitDataProperty( 0 , cnt++ , dtHidden   , 70   , daCenter , true    , "inv_list"		, false   , ""        , dfNone          , 0								   );
            	
            	CountPosition = 0;
            	
            	ToolTipOption = "balloon:true;width:50;";
            	ToolTipText(0,"invocn") = "Count of Invoices";
            	
//              sheetObj.ColHidden("ob_srep_cd") = true;
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
//                	sheetObj.Reset();
//                  initSheet(sheetObj, 0);
                    if(formObj.tab_order.value == 0) {
                		formObj.f_cmd.value = SEARCH;                        
                        ComSetObjValue( formObj.isof , comboObjects[0].Code );
                        ComSetObjValue( formObj.ctof , '' );
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
                        ComSetObjValue( formObj.coll , comboObjects[3].Code );
                        ComSetObjValue( formObj.cutp , comboObjects[4].Code );
                	}else{
                		formObj.f_cmd.value = SEARCH01;
                        ComSetObjValue( formObj.ctof , comboObjects[5].Code );
                        ComSetObjValue( formObj.isof , comboObjects[9].Code );
                        ComSetObjValue( formObj.tftp , comboObjects[6].Code );
                        var logInOff = document.form.h_rhq_off.value;
                        if ( logInOff == "NYCRA" || logInOff == "SELHO" ) {
                        	ComSetObjValue( formObj.arif , comboObjects[7].Code );
                        } else {
                            if ( comboObjects[7].Code == "A" ) {
                                ComSetObjValue( formObj.arif , "Y,N" );                            
                            } else {
                                ComSetObjValue( formObj.arif , comboObjects[7].Code );                            
                            }
                        }
                        ComSetObjValue( formObj.coll , comboObjects[10].Code );
                        ComSetObjValue( formObj.cutp , comboObjects[11].Code );

                        if ( formObj.chk_c_cust.checked ){
                        	ComSetObjValue( formObj.chk_ctrt_cust , "Y" );
                        } else {
                        	ComSetObjValue( formObj.chk_ctrt_cust , "N" );                        	
                        }
                        if ( formObj.chk_c_no.checked ){
                        	ComSetObjValue( formObj.chk_ctrt_no , "Y" );
                        } else {
                        	ComSetObjValue( formObj.chk_ctrt_no , "N" );                        	
                        }
                        if ( formObj.chk_payr.checked ){
                        	ComSetObjValue( formObj.chk_payr_info , "Y" );
                        } else {
                        	ComSetObjValue( formObj.chk_payr_info , "N" );                        	
                        }
                        if ( formObj.curr_flg[0].checked ){
                        	ComSetObjValue( formObj.chk_usd , "Y" );
                        } else {
                        	ComSetObjValue( formObj.chk_usd , "N" );                        	
                        }
                	}
                    ComOpenWait(true);
                    sheetObj.WaitImageVisible = false;
                    sheetObj.DoSearch4Post( "EES_DMT_4009GS.do" , FormQueryString(formObj) );
                    ComOpenWait(false);
                }
            
            break;
            
            case IBSEARCH_ASYNC04: // SEND2EAMIL ALL OF THEM
	            if(sheetObj.CheckedRows("CheckBox") == 0) {
	     			ComShowCodeMessage('COM12114', 'payer code');
	     			return;
	     		}            

            	var iCheckRow = sheetObj.FindCheckedRow("CheckBox")
            	var arrRow = iCheckRow.split("|");
            	for (idx=0; idx<arrRow.length-1; idx++){
            		if( sheetObj.CellValue(arrRow[idx], "dmdt_vt_inv_yn") == "Y") {
                    	ComShowCodeMessage('DMT01175');
                    	break;
            		}
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
                    ComSetObjValue( formObj.coll , comboObjects[3].Code );
                    ComSetObjValue( formObj.cutp , comboObjects[4].Code );
                

//////////////// Sheet Set Check!!
                    var dmif_cnt = 0;
                    var dtic_cnt = 0;
                    var dmof_cnt = 0;
                    var dtoc_cnt = 0;
                    var ctic_cnt = 0;
                    var ctoc_cnt = 0;
                    
                    for ( var z01 = 1 ; z01 < sheetObjects[0].RowCount+3 ; z01++  ) {
                        if ( sheetObjects[0].CellValue(z01,0) == 1 ) {
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
                for ( var z01 = 1 ; z01 < sheetObjects[0].RowCount+3 ; z01++  ) {
                    if ( sheetObjects[0].CellValue(z01,0) == 1 ) {
                        tPayerCd = sheetObjects[0].CellValue(z01,2) + "," + tPayerCd;
                    }
                }
                document.form.paycMail.value = tPayerCd;
                
                var tPayerNm = "";
                for ( var z01 = 1 ; z01 < sheetObjects[0].RowCount+3 ; z01++  ) {
                    if ( sheetObjects[0].CellValue(z01,0) == 1 ) {
                        tPayerNm = ComReplaceStr( sheetObjects[0].CellValue(z01,3) , "'" , " " ) + "|" + tPayerNm;
                    }
                }
                document.form.paynMail.value = tPayerNm;
                
                var tTariff = "";
//                for ( var z01 = 1 ; z01 < sheetObjects[0].RowCount+3 ; z01++  ) {
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
	            
            	var iCheckRow = sheetObj.FindCheckedRow("CheckBox")
            	var arrRow = iCheckRow.split("|");
            	for (idx=0; idx<arrRow.length-1; idx++){
            		if( sheetObj.CellValue(arrRow[idx], "dmdt_vt_inv_yn") == "Y") {
                    	ComShowCodeMessage('DMT01175');
                    	break;
            		}
            	}
            	
	            if(!ComShowCodeConfirm('DMT01140')) return false;

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
                    ComSetObjValue( formObj.coll , comboObjects[3].Code );
                    ComSetObjValue( formObj.cutp , comboObjects[4].Code );
                
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
                    
                    for ( var z01 = 1 ; z01 < sheetObjects[0].RowCount+3 ; z01++  ) {
                        if ( sheetObjects[0].CellValue(z01,0) == 1 ) {
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
                for ( var z01 = 1 ; z01 < sheetObjects[0].RowCount+3 ; z01++  ) {
                    if ( sheetObjects[0].CellValue(z01,0) == 1 ) {
                        tPayerCd = sheetObjects[0].CellValue(z01,2) + "," + tPayerCd;
                    }
                }
                document.form.paycMail.value = tPayerCd;
                
                var tPayerNm = "";
                for ( var z01 = 1 ; z01 < sheetObjects[0].RowCount+3 ; z01++  ) {
                    if ( sheetObjects[0].CellValue(z01,0) == 1 ) {
                        tPayerNm = ComReplaceStr( sheetObjects[0].CellValue(z01,3) , "'" , " " ) + "|" + tPayerNm;
                    }
                }
                document.form.paynMail.value = tPayerNm;
                
                var tTariff = "";
//                for ( var z01 = 1 ; z01 < sheetObjects[0].RowCount+3 ; z01++  ) {
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
        }
    }

    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj , tabNo) {
        switch(tabNo) {
            case 1:
                with (tabObj) {
                    var cnt  = 0 ;
                    InsertTab( cnt++ , "DMT OFC",       -1 );
                    InsertTab( cnt++ , "Contract OFC",  -1 );
                }
                break;
        }
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        	var tab_no = formObj.tab_order.value;
        	
        	if(tab_no == 0) {
        		if(ComTrim(ComGetObjValue(formObj.combo2)) == "") {
                    ComAlertFocus(formObj.combo2, ComGetMsg('DMT02002', "Issue Office"));
                    return false;
                }
        		if(ComTrim(ComGetObjValue(formObj.combo1)) == "") {
                    ComAlertFocus(formObj.combo1, ComGetMsg('DMT02002', "Tariff Type"));
                    return false;
                }
        		if(ComTrim(ComGetObjValue(formObj.combo5)) == "") {
                    ComAlertFocus(formObj.combo5, ComGetMsg('DMT02002', "A/R I/F Status"));
                    return false;
                }
        		if(ComTrim(ComGetObjValue(formObj.combo3)) == "") {
                    ComAlertFocus(formObj.combo3, ComGetMsg('DMT02002', "Collection Status"));
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
        	}else{
        		if(ComTrim(ComGetObjValue(formObj.combo6)) == "") {
                    ComAlertFocus(formObj.combo7, ComGetMsg('DMT02002', "Contract Office"));
                    return false;
                }
        		if(ComTrim(ComGetObjValue(formObj.combo9)) == "") {
                    ComAlertFocus(formObj.combo9, ComGetMsg('DMT02002', "Issue Office"));
                    return false;
                }
        		if(ComTrim(ComGetObjValue(formObj.combo6)) == "") {
                    ComAlertFocus(formObj.combo6, ComGetMsg('DMT02002', "Tariff Type"));
                    return false;
                }
        		if(ComTrim(ComGetObjValue(formObj.combo8)) == "") {
                    ComAlertFocus(formObj.combo8, ComGetMsg('DMT02002', "A/R I/F Status"));
                    return false;
                }
        		if(ComTrim(ComGetObjValue(formObj.combo10)) == "") {
                    ComAlertFocus(formObj.combo10, ComGetMsg('DMT02002', "Collection Status"));
                    return false;
                }
        		if(ComTrim(ComGetObjValue(formObj.frdt2)) == "") {
                    ComAlertFocus(formObj.frdt2, ComGetMsg('DMT02002', "Issued Date"));
                    return false;
                }
                if(ComTrim(ComGetObjValue(formObj.todt2)) == "") {
                    ComAlertFocus(formObj.todt2, ComGetMsg('DMT02002', "Issued Date"));
                    return false;
                }
        	}
        }

        return true;
    }

    /*
     * 다중선택된 DEM/DET Office의 하위점소(Sub Office) 조회기능 
     */
    function doInclSubOfc(tabNo) {
        var formObj = document.form;
        if(tabNo == 0) {
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
        } else if(tabNo == 1) {
        	if (formObj.chk_sub_ofc2.checked) { // Sub Office 포함
                if (ComIsEmpty(comboObjects[5].Code)) {
                    ComShowCodeMessage('COM12113', "DEM/DET Office");
                    formObj.chk_sub_ofc2.checked = false;
                    return;
                }
                formObj.ofc_cd.value = ComGetObjValue(comboObjects[5]);
                formObj.tmp_ofc_cd.value = ComGetObjValue(comboObjects[5]);
                doActionIBCombo(sheetObjects[1], formObj, IBSEARCH_ASYNC03);
            } else {
                ComSetObjValue(comboObjects[5], formObj.tmp_ofc_cd.value);
            }	
        } else { // 3 추가
        	if (formObj.chk_sub_ofc3.checked) { // Sub Office 포함
                if (ComIsEmpty(comboObjects[9].Code)) {
                    ComShowCodeMessage('COM12113', "DEM/DET Office");
                    formObj.chk_sub_ofc8.checked = false;
                    return;
                }
                formObj.ofc_cd.value = ComGetObjValue(comboObjects[9]);
                formObj.tmp_ofc_cd.value = ComGetObjValue(comboObjects[9]);
                doActionIBCombo(sheetObjects[1], formObj, IBSEARCH_ASYNC05);
            } else {
                ComSetObjValue(comboObjects[9], formObj.tmp_ofc_cd.value);
            }	
        }
    
        
    }
    
    function checkSrepFlag(sheetObj) {
//    	var sheetObj = sheetObjects[0];
        var formObj = document.form;

        if (formObj.chk_srep.checked) {
            formObj.chk_srep_flg.value = "Y";
//    		sheetObj.ColHidden("ob_srep_cd") = false;
            with (formObj) {
	    		ComEnableManyObjects(true, ob_srep_cd);	// Disable (True) 처리
	    		DmtComSetClassManyObjects('input', ob_srep_cd);
            }
        } else {
            formObj.chk_srep.value = "N";
//        	sheetObj.ColHidden("ob_srep_cd") = true;
            with (formObj) {
	        	ComEnableManyObjects(false, ob_srep_cd)	// Disable (false) 처리
	        	DmtComSetClassManyObjects('input2', ob_srep_cd);	// 회색 처리
	        	ComClearManyObjects(ob_srep_cd);					// 초기화 및 사용 금지
            }
        }
        if (formObj.chk_srep2.checked) {
        	formObj.chk_srep_flg2.value = "Y";
//    		sheetObj.ColHidden("ob_srep_cd") = false;
        	with (formObj) {
        		ComEnableManyObjects(true, ob_srep_cd2);	// Disable (True) 처리
        		DmtComSetClassManyObjects('input', ob_srep_cd2);
        	}
        } else {
        	formObj.chk_srep2.value = "N";
//        	sheetObj.ColHidden("ob_srep_cd") = true;
        	with (formObj) {
        		ComEnableManyObjects(false, ob_srep_cd2)	// Disable (false) 처리
        		DmtComSetClassManyObjects('input2', ob_srep_cd2);	// 회색 처리
        		ComClearManyObjects(ob_srep_cd2);					// 초기화 및 사용 금지
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
    
    function combo5_OnKeyDown(comboObj, KeyCode, Shift) {
        if ( KeyCode == 13 ) {
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
    }
    
    function combo6_OnKeyDown(comboObj, KeyCode, Shift) {
    	if ( KeyCode == 13 ) {
    		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
    	}
    }
    
    function combo9_OnKeyDown(comboObj, KeyCode, Shift) {
    	if ( KeyCode == 13 ) {
    		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
    	}
    }
    
    function combo10_OnKeyDown(comboObj, KeyCode, Shift) {
    	if ( KeyCode == 13 ) {
    		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
    	}
    }    
    
    function combo11_OnKeyDown(comboObj, KeyCode, Shift) {
    	if ( KeyCode == 13 ) {
    		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
    	}
    }
    
	function combo12_OnChange(cboObj, Index_Code, Text) {
		
        var formObj = document.form;

        formObj.shd_rhq_cd.value = Text;        	   		
   	 
   		doActionIBCombo(sheetObjects[1], formObj, IBSEARCH_ASYNC04);
	}
    
    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
	function tab1_OnChange(tabObj , nItem){

    	 var objs = document.all.item("tabLayer");
    	 var formObj = document.form;
    	 objs[nItem].style.display = "Inline";
    	 objs[beforetab].style.display = "none";
	
	 	 //--------------- 요기가 중요 --------------------------//
    	 objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
	 	 //------------------------------------------------------//
    	 beforetab= nItem;
    	 
	 	 //[설명]TAB 선택시 tab_order에 값 셋팅하기
    	 formObj.tab_order.value =  beforetab;
        
    	 //tab1:Detail 버튼 생성, tab2: Detail 버튼 삭제
//    	 var schCondDiv = document.getElementById("sch_cond_div");
//    	 if (ComGetObjValue(formObj.tab_order) == 0) {
//    		 schCondDiv.style.display = 'block';
//	 	 } 
//    	 else {
//	 		 schCondDiv.style.display = 'none';
//	 	 }
    	 
//    	 sheetObjects[beforetab]
    	 
    	 with (sheetObjects[beforetab]) {
             
             if (RowCount <= 0)  {
                 ComBtnDisable("btn1_detail");
                 ComBtnDisable("btn1_fax_send");
                 ComBtnDisable("btn1_email_send");
                 ComBtnDisable("btn1_excel");                 
             }else{
            	 ComBtnEnable("btn1_detail");
                 ComBtnEnable("btn1_fax_send");
                 ComBtnEnable("btn1_email_send");
                 ComBtnEnable("btn1_excel");
             }
    	 }
	}

	function sheet1_OnLoadFinish() {
		var formObj = document.form
		sheetObjects[0].WaitImageVisible = false;   
//     	initSearchControls();
     	doInit();
     	sheetObjects[0].WaitImageVisible = true;   
	}  
	
	function sheet2_OnLoadFinish() {
		var formObj = document.form
		sheetObjects[1].WaitImageVisible = false;   
//     	initSearchControls();
     	doInit();
     	sheetObjects[1].WaitImageVisible = true;
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
    function combo5_OnCheckClick(comboObj, index, code) {
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
    function combo7_OnCheckClick(comboObj, index, code) {
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
    function combo9_OnCheckClick(comboObj, index, code) {
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
    
//    
//    function combo7_OnCheckClick(comboObj, index, code) {
//        var formObj = document.form;
//        
//        if(formObj.chk_sub_ofc.checked) {
//   			if(comboObj.CheckIndex(index))
//   				comboObj.CheckIndex(index) = false;
//   			else
//   				comboObj.CheckIndex(index) = true;
//   			
//   			ComShowCodeMessage('DMT00107');
//   		}
//    }
    
	// 멀티콤보 KeyDown Event Catch (2010.03.18 추가)
 	function combo2_OnKeyDown(comboObj, keycode, shift) {
		var formObj = document.form;
		
   		if(formObj.chk_sub_ofc.checked) {
   			ComShowCodeMessage('DMT00107');
   		}
 	} 	
 	
 	function combo6_OnKeyDown(comboObj, keycode, shift) {
 		var formObj = document.form;
 		
 		if(formObj.chk_sub_ofc2.checked) {
 			ComShowCodeMessage('DMT00107');
 		}
 	} 	
 	
 	function combo10_OnKeyDown(comboObj, keycode, shift) {
 		var formObj = document.form;
 		
 		if(formObj.chk_sub_ofc3.checked) {
 			ComShowCodeMessage('DMT00107');
 		}
 	}
 	

    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
        with (sheetObj) {
            
            if (RowCount <= 0)  {
                ComBtnDisable("btn1_detail");
                ComBtnDisable("btn1_fax_send");
                ComBtnDisable("btn1_email_send");
                ComBtnDisable("btn1_excel");                
                return; 
            }
            
            for (var x = 1 ; x < LastRow ; x++) {
                if (CellValue( x , 9 ) == "Y") {
                    ToolTipText(   x , 2 ) = "Payer Code not available any more";
                    CellFontColor( x , 2 ) = RgbColor( 220 , 0 , 0 );
                }
                // Virtual Invoice 를 가지고 있는 Payer 에는 빨간색 볼드체로 표현해준다.
                else if (CellValue(x, "dmdt_vt_inv_yn") == "Y") {
                	CellFont("FontColor", x, 1, x, 9) = RgbColor(255, 0, 0);
                	CellFont("FontBold" , x, 1, x, 9) = true;
                }
            }            
            
            ComBtnEnable("btn1_detail");
            ComBtnEnable("btn1_fax_send");
            ComBtnEnable("btn1_email_send");
            ComBtnEnable("btn1_excel");
            
            SumText  ( 0 , "SEQ"      ) = "Total";
            CellAlign( 0 , "SEQ"      ) = daCenter;
        }
    }    
    
    function sheet2_OnSearchEnd(sheetObj, ErrMsg){
    	with (sheetObj) {
    		
    		if (RowCount <= 0)  {
    			ComBtnDisable("btn1_detail");
    			ComBtnDisable("btn1_fax_send");
    			ComBtnDisable("btn1_email_send");
    			ComBtnDisable("btn1_excel");                
    			return; 
    		}
    		
    		for (var x = 1 ; x < LastRow ; x++) {
    			if (CellValue( x , 9 ) == "Y") {
    				ToolTipText(   x , 2 ) = "Payer Code not available any more";
    				CellFontColor( x , 2 ) = RgbColor( 220 , 0 , 0 );
    			}
    			// Virtual Invoice 를 가지고 있는 Payer 에는 빨간색 볼드체로 표현해준다.
    			else if (CellValue(x, "dmdt_vt_inv_yn") == "Y") {
    				CellFont("FontColor", x, 1, x, 9) = RgbColor(255, 0, 0);
    				CellFont("FontBold" , x, 1, x, 9) = true;
    			}
    		}            
    		
    		ComBtnEnable("btn1_detail");
    		ComBtnEnable("btn1_fax_send");
    		ComBtnEnable("btn1_email_send");
    		ComBtnEnable("btn1_excel");
    		
    		SumText  ( 0 , "SEQ"      ) = "Total";
    		CellAlign( 0 , "SEQ"      ) = daCenter;
    		
			var formObj = document.form;

			ColHidden("ctrt_cust_cd") = !formObj.chk_c_cust.checked;
			ColHidden("ctrt_cust_nm") = !formObj.chk_c_cust.checked;
			ColHidden("ctrt_no") = !formObj.chk_c_no.checked;
			ColHidden("payerc") = !formObj.chk_payr.checked;
			ColHidden("payern") = !formObj.chk_payr.checked;
    	}
    }    
    
    function sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y){
        document.form.chk_payer.value  = sheetObjects[0].CellValue(sheetObjects[0].MouseRow , 2);
        document.form.chk_payer2.value = sheetObjects[0].CellValue(sheetObjects[0].MouseRow , 3);
    }
    
    function sheet2_OnMouseDown(sheetObj, Button, Shift, X, Y){
    	document.form.chk_payer.value  = sheetObjects[1].CellValue(sheetObjects[1].MouseRow , 2);
    	document.form.chk_payer2.value = sheetObjects[1].CellValue(sheetObjects[1].MouseRow , 3);
    }
    
    function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
    	
        // Outstanding Inquiry by Customer & Issue - Detail(s) 팝업화면을 호출한다.
        openOutstandingInquiryDetail(sheetObj);
    }
    
    function sheet2_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
    	
    	// Outstanding Inquiry by Customer & Issue - Detail(s) 팝업화면을 호출한다.
    	openOutstandingInquiryDetail(sheetObj);
    }
    
    //Payer 체크
    function doActionText(sheetObj, formObj, object, formCmd) {
        sheetObj.ShowDebugMsg = false;
        sheetObj.WaitImageVisible = false;
        if(formObj.tab_order.value == 0) {
        	var cust_len = parseInt(ComGetLenByByte(ComGetObjValue(formObj.payc)));
            
            if(cust_len == 0) {
                ComSetObjValue(formObj.payn, "");
                return;
            }
            
            if(cust_len == 6) {
                ComSetObjValue(formObj.s_cust_gubun, "1");
                ComSetObjValue(formObj.s_cust_cd, formObj.payc.value);
            }else if(cust_len > 6) {
                ComSetObjValue(formObj.s_cust_gubun, "2");
                ComSetObjValue(formObj.s_cust_cd, formObj.payc.value);
            }else {
                ComSetObjValue(formObj.s_cust_gubun, "");
                ComSetObjValue(formObj.payc, "");
                ComSetObjValue(formObj.payn, "");
                ComSetFocus(formObj.payc);
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
                ComSetFocus(formObj.payc);
                    document.form.s_cust_gubun.value = "";
                    document.form.payc.value = "";
                    document.form.payn.value = "";                
            }else{
                ComSetObjValue(formObj.payn, cust_nm);
                document.form.payc.value = cust_cd;
            }
        } else {
        	var cust_len = parseInt(ComGetLenByByte(ComGetObjValue(formObj.payc2)));
            
            if(cust_len == 0) {
                ComSetObjValue(formObj.payn2, "");
                return;
            }
            
            if(cust_len == 6) {
                ComSetObjValue(formObj.s_cust_gubun, "1");
                ComSetObjValue(formObj.s_cust_cd, formObj.payc2.value);
            }else if(cust_len > 6) {
                ComSetObjValue(formObj.s_cust_gubun, "2");
                ComSetObjValue(formObj.s_cust_cd, formObj.payc2.value);
            }else {
                ComSetObjValue(formObj.s_cust_gubun, "");
                ComSetObjValue(formObj.payc2, "");
                ComSetObjValue(formObj.payn2, "");
                ComSetFocus(formObj.payc);
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
                ComSetFocus(formObj.payc2);
                    document.form.s_cust_gubun.value = "";
                    document.form.payc2.value = "";
                    document.form.payn2.value = "";                
            }else{
                ComSetObjValue(formObj.payn2, cust_nm);
                document.form.payc2.value = cust_cd;
            }
        }
        
        sheetObj.WaitImageVisible = true;
        
    }
    
    //Customer 체크
    function doActionText2(sheetObj, formObj, object, formCmd) {
        sheetObj.ShowDebugMsg = false;
        sheetObj.WaitImageVisible = false;
        
        if(formObj.tab_order.value == 0) {
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
        }else{
        	var cust_len = parseInt(ComGetLenByByte(ComGetObjValue(formObj.cuno2)));
            var tCuno = ComGetObjValue(formObj.cuno2);
            
            if(cust_len == 0) {
                ComSetObjValue(formObj.cude2, "");
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
                ComSetFocus(formObj.cuno2);
                ComShowCodeMessage("COM12143", "Customer Code ", "8");
                return;
            }
            ComSetObjValue(formObj.f_cmd, formCmd);

            var sXml    = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
            var cust_nm = ComGetEtcData(sXml, "CUST_NM");
            
            
            if(cust_nm == null || cust_nm == "") {
                ComShowCodeMessage("COM132201", "Customer Code", "8");
                
                document.form.cuno2.value = "";
                document.form.cude2.value = "";
                document.form.cust_cnt_cd.value = "";
                document.form.cust_seq.value = "";
                ComSetFocus(formObj.cuno2);
            }else{
                ComSetObjValue(formObj.cude2, cust_nm);
                //document.form.payc.value = cust_cd;
            }
        }        
        sheetObj.WaitImageVisible = true;
    }    
    
    function keyPress() {
        var obj = event.srcElement;
        var eventKey = window.event.keyCode ;
        if( eventKey == 13 ) {
            if ( obj.name == "payc" || obj.name == "cuno" || obj.name == "payc2" || obj.name == "cuno2" ) {
                if(obj.name == 'payc' || obj.name == 'payc2') {
                    doActionText(sheetObjects[0], document.form, obj, SEARCH20);
                }else if(obj.name == 'cuno' || obj.name == 'cuno2') {
                    doActionText2(sheetObjects[0], document.form, obj, SEARCH19);
                }                
                doActionIBSheet(sheetObjects[document.form.tab_order.value], document.form, IBSEARCH);
            } else {
                doActionIBSheet(sheetObjects[document.form.tab_order.value], document.form, IBSEARCH);
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

	/*
	 * Outstanding Inquiry by Customer & Issue - Detail(s) 팝업화면을 호출한다.
	 */
   function openOutstandingInquiryDetail(sheetObj) {
	   var formObj = document.form;
	   ComSetObjValue(formObj.chk_payer,  sheetObj.CellValue(sheetObj.SelectRow, 2));
	   ComSetObjValue(formObj.chk_payer2, sheetObj.CellValue(sheetObj.SelectRow, 3));
	   
	   if(formObj.tab_order.value == 0) {
		   ComSetObjValue(formObj.tftp,       comboObjects[1].Code);
		   ComSetObjValue(formObj.isof, 	  comboObjects[0].Code);
		   ComSetObjValue(formObj.arif, 	  comboObjects[2].Code);
		   ComSetObjValue(formObj.coll, 	  comboObjects[3].Code);
		   ComSetObjValue(formObj.cutp, 	  comboObjects[4].Code);

		   var tArif    = ComGetObjValue(formObj.arif);
		   var logInOff = ComGetObjValue(formObj.h_rhq_off);

		   if (logInOff != "NYCRA" && logInOff != "SELHO") {
		       if (tArif == "A") {
		           tArif = "Y,N";
		       }
		   }          

		   var param = "?isof=" + ComGetObjValue(formObj.isof) +
		               "&tftp=" + ComGetObjValue(formObj.tftp) +
		               "&frdt=" + ComGetObjValue(formObj.frdt) +
		               "&todt=" + ComGetObjValue(formObj.todt) +
		               "&arif=" + tArif +
		               "&coll=" + ComGetObjValue(formObj.coll) +
		               "&payc=" + ComGetObjValue(formObj.chk_payer) +
		               "&cutp=" + ComGetObjValue(formObj.cutp) +
		               "&cuno=" + ComGetObjValue(formObj.cuno) +
		               "&cude=" + ComGetObjValue(formObj.cude) +
		               "&scno=" + ComGetObjValue(formObj.scno) +
		               "&rfan=" + ComGetObjValue(formObj.rfan) +
		               "&payn=" + ComGetObjValue(formObj.chk_payer2) +
		               "&prg_ex_in_cd=" + ComGetObjValue(formObj.prg_ex_in_cd);
		   ComOpenPopup("/hanjin/EES_DMT_4011.do"+param , 1030, 730 , "" , "1,0,1,1,1,1,1,1" , true);
	   }else {
		   ComSetObjValue(formObj.tftp,       comboObjects[6].Code);
		   ComSetObjValue(formObj.ctof, 	  comboObjects[5].Code);
		   ComSetObjValue(formObj.isof, 	  comboObjects[9].Code);
		   ComSetObjValue(formObj.arif, 	  comboObjects[7].Code);
		   ComSetObjValue(formObj.coll, 	  comboObjects[10].Code);
		   ComSetObjValue(formObj.cutp, 	  comboObjects[11].Code);

		   var tArif    = ComGetObjValue(formObj.arif);
		   var logInOff = ComGetObjValue(formObj.h_rhq_off);

		   if (logInOff != "NYCRA" && logInOff != "SELHO") {
		       if (tArif == "A") {
		           tArif = "Y,N";
		       }
		   }
		   
		   ComSetObjValue(formObj.chk_payer,  sheetObj.CellValue(sheetObj.SelectRow, "payerc"));
		   
		   var param = "?ctof=" + ComGetObjValue(formObj.ctof) +
		   			   "&isof="	+ ComGetObjValue(formObj.isof) +
		               "&tftp=" + ComGetObjValue(formObj.tftp) +
		               "&frdt=" + ComGetObjValue(formObj.frdt2) +
		               "&todt=" + ComGetObjValue(formObj.todt2) +
		               "&arif=" + tArif +
		               "&coll=" + ComGetObjValue(formObj.coll) +
		               "&payc=" + ComGetObjValue(formObj.chk_payer) +
		               "&cutp=" + ComGetObjValue(formObj.cutp) +
		               "&cuno=" + ComGetObjValue(formObj.cuno2) +
		               "&cude=" + ComGetObjValue(formObj.cude2) +
		               "&payn=" + ComGetObjValue(formObj.chk_payer2) +	   		   		   
		               "&ctrt_ofc_cd=" + sheetObj.CellValue(sheetObj.SelectRow, "ctrt_ofc_cd") +	
		               "&ctrt_srep_cd=" + sheetObj.CellValue(sheetObj.SelectRow, "ctrt_srep_cd") +		  	   		   		   
		               "&ctrt_tp=" + sheetObj.CellValue(sheetObj.SelectRow, "ctrt_tp") +		   		   		   
		               "&ctrt_no=" + sheetObj.CellValue(sheetObj.SelectRow, "ctrt_no") + 		   		   
		               "&ctrt_cust_cd=" + sheetObj.CellValue(sheetObj.SelectRow, "ctrt_cust_cd") +	  
		               "&payerc=" + sheetObj.CellValue(sheetObj.SelectRow, "payerc") +	 
		               "&inPayr=" + formObj.payc2.value +	
		               "&scno=" + ComGetObjValue(formObj.scno2) +
		               "&rfan=" + ComGetObjValue(formObj.rfan2) +
		               "&taano=" + ComGetObjValue(formObj.taano) +
		               "&grop_cust=" + ComGetObjValue(formObj.grop_cust) +
		               "&ctrt_cust=" + ComGetObjValue(formObj.ctrt_cust) +
		               "&ctrtFlg=Y" 
		               ;
           if ( !formObj.curr_flg[0].checked ){
        	   param = param + "&invocr=" + sheetObj.CellValue(sheetObj.SelectRow, "invocr");
           }		             

		   ComOpenPopup("/hanjin/EES_DMT_4011.do"+param , 1030, 730 , "" , "1,0,1,1,1,1,1,1" , true);
	   }
	  // doActionIBSheet(sheetObj,formObj,IBSEARCH);
   }
   	
	/*
     * 멀티입력 팝업 페이지가 닫힌 후, 호출되는 Opener 함수
     * - 해당 필드에 멀티 입력값을 설정해준다.
     */
    function getDmt_Multi(rArray, return_val) {
    	var targObj = eval("document.form." + return_val);
    	var retStr = rArray.toString().toUpperCase();
    	
    	ComSetObjValue(targObj, retStr);
    }

    /**
     * 서버로부터 정상적으로 전달받지 못한 데이터를 처리해주는 함수 
     */
    function handleNullString(sVal) {
   	
        if (sVal == undefined || sVal == "null" || sVal.length == 0) return "";

        return ComTrim(sVal);
    }
