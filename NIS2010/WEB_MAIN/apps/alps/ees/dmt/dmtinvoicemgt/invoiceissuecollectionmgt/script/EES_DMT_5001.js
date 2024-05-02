/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_5001.js
*@FileTitle : A/R Interface Status Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.09.03 최성환
* 1.0 Creation
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
     * @class EES_DMT_5001 : EES_DMT_5001 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
	function EES_DMT_5001() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/

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
	var ROWMARK = "|";
	var FIELDMARK = "=";
	var PERIOD_GAP = 15;
	var USR_TRF_TP;


	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         
         var sheetObject1 = sheetObjects[0];
		 var sheetObject2 = sheetObjects[1];
		 var sheetObject3 = sheetObjects[2];
		 var sheetObject4 = sheetObjects[3];
         
         /*******************************************************/
         var formObj = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
    		var srcObj = window.event.srcElement;

            switch(srcName) {

	            case "btns_calendar": //달력 버튼
	         	if(srcObj.style.cursor == "hand") {
		            var cal = new ComCalendarFromTo();
		            if (formObj.tab_order.value == 0) {
		            	cal.select(formObj.fm_dt,  formObj.to_dt,  'yyyy-MM-dd');
		            } 
		            else if (formObj.tab_order.value == 1) {
		            	cal.select(formObj.fm_dt_t2,  formObj.to_dt_t2,  'yyyy-MM-dd');
		            }
		            else {
		            	cal.select(formObj.fm_if_dt,  formObj.to_if_dt,  'yyyy-MM-dd');
		            }
	         	}
				break;
		
 				case "btns_multisearch1":	// tab1 - invoice_no 조회조건 추가
 					if (srcObj.style.cursor == "hand") {
	 					openPopup('s_invoice_no');
 					}
 				break;
 				
 				case "btns_multisearch2":	// tab1 - bkg_no 조회조건 추가
 					if (srcObj.style.cursor == "hand") {
	 					openPopup('s_bkg_no');
 					}
 				break;

 				case "btns_multisearch3":	// tab3 - invoice_no name 변경
 					if (srcObj.style.cursor == "hand") {
	 					openPopup('invoice_no');
 					}
 				break;
 				
 				case "btns_multisearch4":	// tab3 - bkg_no name 변경
 					if (srcObj.style.cursor == "hand") {
	 					openPopup('bkg_no');
 					}
 				break;
 					
	 			case "btn_downexcel":
	 				if (formObj.tab_order.value == 0) {
	 					ComSetObjValue(formObj.login_ofc_cd, formObj.usr_ofc_cd)
	 					
	 					ComSetObjValue(formObj.btn_id, "btn_retrieve");
	 					if (ComGetObjValue(formObj.usr_ofc_cd) == "SAOSC") {
	 						if ( sheetObject1.Rows <= 2 ) { return; }
	 						ComSetObjValue(formObj.btn_id, "btn_downexcel"); // SAOSC Office에서 DownExcel 클릭시에만 동작 시를 구분한다.
		 					doActionIBSheet(sheetObject4,document.form,IBSEARCH);
//		 					sheetObject4.Down2Excel(-1, false, false, true);
		 					sheetObject4.SpeedDown2Excel(-1, false, false, '', '', false, false, '', false, 'chk');
	 					} else {
	 						sheetObject1.SpeedDown2Excel(-1, false, false, '', '', false, false, '', false, 'chk');
	 					}
	 					
		            } 
	 				else if (formObj.tab_order.value == 1) {
//		            	sheetObject2.SpeedDown2Excel();
		            	sheetObject2.SpeedDown2Excel(-1, false, false, '', '', false, false, '', false, 'chk');
		            }
	 				else {
//		            	sheetObject2.SpeedDown2Excel();
		            	sheetObject3.SpeedDown2Excel(-1, false, false, '', '', false, false, '', false, 'chk');
		            }
	 				
	 				break;
							
	 			case "btn_retrieve":
	 				
	 				ComSetObjValue(formObj.btn_id, "btn_retrieve");

	 				//tab클릭에 따라 해당하는 그리드 조회 
	 				var tabOrder = formObj.tab_order.value;
	 				
					if (tabOrder == 0) {
						doActionIBSheet(sheetObject1,document.form,IBSEARCH);
					} 
					else if (tabOrder == 1) {
						doActionIBSheet(sheetObject2,document.form,IBSEARCH);
					} 	
					else if (tabOrder == 2) {
						doActionIBSheet(sheetObject3,document.form,IBSEARCH);
					} 
					
	 				break;
							
	 			case "btn_new":
	 				initSearchControls();
					break; 
							
	 			case "btn_detail":
	 				if(ComIsBtnEnable(srcName)) {
						openPopupWindow(sheetObject1, formObj, srcName);
					}
	 				break;
							
	 			case "btn_print":
	 				alert(srcName);
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
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){

       sheetObjects[sheetCnt++] = sheet_obj;

    }

  	//페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
  	function setComboObject(combo_obj){
  		comboObjects[comboCnt++] = combo_obj;
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
 		 	//khlee-시작 환경 설정 함수 이름 변경
	 		ComConfigSheet (sheetObjects[i] );
	 		initSheet(sheetObjects[i],i+1);
	 		//khlee-마지막 환경 설정 함수 추가
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
		
		ComEnableObject(document.form.btns_multisearch1, true);
		ComEnableObject(document.form.btns_multisearch2, true);
		ComEnableObject(document.form.btns_multisearch3, true);
		ComEnableObject(document.form.btns_multisearch4, true);
    }

 	function initControl() {
        axon_event.addListenerForm  ( 'blur'     , 'obj_blur'      , document.form ); //- 포커스 나갈때
        axon_event.addListenerFormat( 'focus'    , 'obj_focus'     , document.form ); //- 포커스 들어갈때
		axon_event.addListenerFormat('keypress','obj_keypress', document.form); //- 키보드 입력할때
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');  //jsp name 옆에 id 추가 예)name="btn_retrieve" id="btn_Retrieve"
		axon_event.addListenerForm  ( 'change' , 'obj_change' , document.form );
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
	
	function obj_blur(){
         //입력Validation 확인하기 + 마스크구분자 넣기
         var obj = event.srcElement;
         
         if (obj.name == 'fm_dt'     || obj.name == 'to_dt'     || 
        	 obj.name == 'fm_dt_t2'  || obj.name == 'to_dt_t2'  || 
        	 obj.name == 'fm_if_dt'  || obj.name == 'to_if_dt') {
             ComChkObjValid(obj);
         } 
         else if(obj.name == 'cust_cd') {
        	 doActionText(sheetObjects[0], document.form, obj, SEARCH20);
         } 
         else if(obj.name == 'act_cust_cd') {
        	 doActionTextT2(sheetObjects[0], document.form, obj, SEARCH20);
         }
	}
     
	function obj_focus() {
		ComClearSeparator(event.srcElement);
		ComSetFocus(event.srcElement);
	}
	//tab1에서 office에서 a/r if or issue 둘 중에 하나를 선택할 시에.
    function obj_change(){
        obj = event.srcElement;
        var formObj = document.form;
        if(obj.name == "r_office"){
        	// a/r office
            if ( obj.value == "1") {
    			//tab1 a/r office 초기에는 a/r office를 로딩함. 
    			//doActionIBCombo(sheetObjects[0],formObj,IBSEARCH_ASYNC06,comboObjects[0]);
    			
    			//2010.04.23. -> a/r office를 tab1 issue office로 요청  	
    			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH_ASYNC01,comboObjects[0]);
    			//하위 점소 체크 해제
    			formObj.chk_sub_ofc.checked = false;
            } 
            // issue
            else if ( obj.value == "2") {
    			//tab1 issue office 	
    			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH_ASYNC01,comboObjects[0]);
    			//하위 점소 체크 해제
    			formObj.chk_sub_ofc.checked = false;
            }
        }
    }
	
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

	    switch(sheetObj.id) {
	        case "t1sheet1":      // sheet1 init
				with (sheetObj) {
	 				// 높이 설정
	 				style.height = 420;
	 				// 전체 너비 설정
	 				SheetWidth = mainTable.clientWidth;
	
	 				//Host정보 설정[필수][HostIp, Port, PagePath]
	 				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	 				//전체Merge 종류 [선택, Default msNone]
	 				MergeSheet = msHeaderOnly;
	
	 			   //전체Edit 허용 여부 [선택, Default false]
	 				Editable = true;
	
	 				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	 				InitRowInfo( 1, 1, 2, 100);
	
	 				var HeadTitle  = "|Sel.|Seq.|Office|SUBTOT|I/F DT|Tariff|INV No.|BKG No.|B/L No.|I/F No.|VVD CD|Port|I/F OFC|I/F Name|ISS DT|ISS OFC|ISS Name|Cur.|Billing AMT|Tax AMT|Payable AMT|Payer Flg|Payer CD|Payer Name|Shipper|Shipper|Consignee|Consignee|Notify|Notify|DMDT_INV_TP_CD";
	 				
	 				var headCount = ComCountHeadTitle(HeadTitle);
	 				
	 				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	 				InitColumnInfo(headCount, 0, 0, true);
	
	 				// 해더에서 처리할 수 있는 각종 기능을 설정한다
	 				InitHeadMode(true, true, false, true, false,false)
	
	 				
	 				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	 				InitHeadRow(0, HeadTitle, true);
	
	 				//데이터속성    [ROW, COL,  DATATYPE,		WIDTH,		DATAALIGN, COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	 				InitDataProperty(0, cnt++ , dtHiddenStatus,	30,			daCenter,	true,		"ibflag");	
	 				InitDataProperty(0, cnt++ , dtHidden,		50,			daCenter,	true,		"chk");       
	 				InitDataProperty(0, cnt++ , dtSeq,			45,			daCenter,	true,		"seq");
	 				InitDataProperty(0, cnt++ , dtData,			50,			daCenter,	true,		"ofc_cd",    		false,		"",			dfNone,			0,		false,		true);
	 				//SubTotal을 위한 필드(Hidden)
	 				InitDataProperty(0, cnt++ , dtHidden,		50,			daCenter,	true,		"subtot",    		false,		"",			dfNone,			0,		false,		true);
	 				InitDataProperty(0, cnt++ , dtData,			100,		daCenter,	true,		"ar_if_dt",      	false,		"",			dfNone,			0,		false,		true);
	 																																
	 				InitDataProperty(0, cnt++ , dtData,			50,			daCenter,	true,		"dmdt_trf_cd",     	false,		"",			dfNone,			0,		false,		true);
	 				InitDataProperty(0, cnt++ , dtData,			80,			daCenter,	true,		"dmdt_inv_no",     	false,		"",			dfNone,			0,		false,		true);
	 				InitDataProperty(0, cnt++ , dtData,			100,		daCenter,	true,		"bkg_no",     		false,		"",			dfNone,			0,		false,		true);
	 				InitDataProperty(0, cnt++ , dtData,			90,			daCenter,	true,		"bl_no",      		false,		"",			dfNone,			0,		false,		true);
	 				InitDataProperty(0, cnt++ , dtData,			90,			daCenter,	true,		"ar_if_no",      	false,		"",			dfNone,			0,		false,		true);
	 				InitDataProperty(0, cnt++ , dtData,			80,			daCenter,	true,		"vvd",       		false,		"",			dfNone,			0,		false,		true);
	 																													
	 				InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,		"port",      		false,		"",			dfNone,			0,		false,		true);
	 				InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,		"ar_if_ofc_cd",    	false,		"",			dfNone,			0,		false,		true);
	 				InitDataProperty(0, cnt++ , dtData,			80,			daLeft,		true,		"ar_if_usr_id",    	false,		"",			dfNone,			0,		false,		true);
	 				InitDataProperty(0, cnt++ , dtData,			80,			daCenter,	true,		"cre_dt",    		false,		"",			dfDateYmd,		0,		false,		true);
	 				InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,		"cre_ofc_cd",    	false,		"",			dfNone,			0,		false,		true);
	 				InitDataProperty(0, cnt++ , dtData,			100,		daLeft,		true,		"cre_usr_id",    	false,		"",			dfNone,			0,		false,		true);
	 				InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,		"inv_curr_cd",      false,		"",			dfNone,			0,		false,		true);
	 				InitDataProperty(0, cnt++ , dtAutoSum,		150,		daRight,	true,		"inv_chg_amt",		false,		"",			dfNullFloat,	2,		false,		true);
	 				InitDataProperty(0, cnt++ , dtAutoSum,		150,		daRight,	true,		"tax_amt",    		false,		"",			dfNullFloat,	2,		false,		true);
	 				InitDataProperty(0, cnt++ , dtAutoSum,		150,		daRight,	true,		"inv_amt",			false,		"",			dfNullFloat,	2,		false,		true);
	 				
	 				InitDataProperty(0, cnt++ , dtHidden,		60,	 		daCenter,	true,		"payer_flg",    	false,		"",			dfNone,			0,		false,		true);
	 				InitDataProperty(0, cnt++ , dtData,			60,	 		daCenter,	true,		"payer_cd",    		false,		"",			dfNone,			0,		false,		true);
	 				InitDataProperty(0, cnt++ , dtData,			230,		daLeft,		true,		"payer_nm",    		false,		"",			dfNone,			0,		false,		true);
	 				InitDataProperty(0, cnt++ , dtData,			60,	 		daCenter,	true,		"shipper_cd",  		false,		"",			dfNone,			0,		false,		true);
	 				InitDataProperty(0, cnt++ , dtData,			230,		daLeft,		true,		"shipper_nm",  		false,		"",			dfNone,			0,		false,		true);
	 																										
	 				InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,		"consignee_cd",		false,		"",			dfNone,			0,		false,		true);
	 				InitDataProperty(0, cnt++ , dtData,			230,		daLeft,		true,		"consignee_nm",		false,		"",			dfNone,			0,		false,		true);
	 				InitDataProperty(0, cnt++ , dtData,			60,	 		daCenter,	true,		"notify_cd",   		false,		"",			dfNone,			0,		false,		true);
	 				InitDataProperty(0, cnt++ , dtData,			230,		daLeft,		true,		"notify_nm",   		false,		"",			dfNone,			0,		false,		true);
	 				InitDataProperty(0, cnt++ , dtHidden,		  0,		daLeft,		true,		"dmdt_inv_tp_cd", 	false,		"",			dfNone,			0,		false,		true);
	 			
	 				FrozenCols = SaveNameCol("bkg_no");
	 			}
 				break;
 		   
 		case "t2sheet1":      // sheet2 init
 			with (sheetObj) {
 				// 높이 설정
 				style.height = 420;
 				// 전체 너비 설정
 				SheetWidth = mainTable.clientWidth;

 				//Host정보 설정[필수][HostIp, Port, PagePath]
 				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

 				//전체Merge 종류 [선택, Default msNone]
 				MergeSheet = msHeaderOnly;

 			   //전체Edit 허용 여부 [선택, Default false]
 				Editable = true;

 				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 				InitRowInfo( 1, 1, 2, 100);

 				// 해더에서 처리할 수 있는 각종 기능을 설정한다
 				InitHeadMode(true, true, false, true, false,false)

 			    var HeadTitle  = "|Seq.|A/R OFC|I/F DT|CHRG|Bound|Type|B/L No.|I/F No.|VVD CD|Port|INV No.|ISS DT|Cur.|AMT|payer_flg|A/R Actual Payer|A/R Actual Payer";

 				var headCount = ComCountHeadTitle(HeadTitle);
 				
 				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 				InitColumnInfo(headCount, 0, 0, true);
 				
 				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 				InitHeadRow(0, HeadTitle, true);

 				//데이터속성    [ROW, COL,  DATATYPE,		WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 				InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,		"ibflag");	
 				
 				InitDataProperty(0, cnt++ , dtSeq,			45,		daCenter,	true,		"seq");
 				InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"ar_ofc_cd",   		false,		"",			dfNone,			0,		false,		true);
 				
 				InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"if_dt", 			false,		"",			dfDateYmd,		0,		false,		true);
 				InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"chg_cd",     		false,		"",			dfNone,			0,		false,		true);
 				InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"io_bnd_cd",    	false,		"",			dfNone,			0,		false,		true);
 				InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,		"type",     		false,		"",			dfNone,			0,		false,		true);
 				InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,		"bl_no",     		false,		"",			dfNone,			0,		false,		true);
 				InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"if_no",     		false,		"",			dfNone,			0,		false,		true);
 				InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"vvd_cd",    		false,		"",			dfNone,			0,		false,		true);
 				
 				InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"port_cd",    		false,		"",			dfNone,			0,		false,		true);
 				InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"inv_no",    		false,		"",			dfNone,			0,		false,		true);
 				InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"iss_dt",   		false,		"",			dfDateYmd,		0,		false,		true);
 				InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"curr_cd",    		false,		"",			dfNone,			0,		false,		true);
 				InitDataProperty(0, cnt++ , dtAutoSum,		120,	daRight,	true,		"chg_amt",    		false,		"",			dfNullFloat,	2,		false,		true);
 				
 				InitDataProperty(0, cnt++ , dtHidden,		60,	 	daCenter,	true,		"payer_flg",    	false,		"",			dfNone,			0,		false,		true);
 				InitDataProperty(0, cnt++ , dtData,			60,	 	daCenter,	true,		"payer_cd",    		false,		"",			dfNone,			0,		false,		true);
 				InitDataProperty(0, cnt++ , dtData,			230,	daLeft,		true,		"payer_nm",    		false,		"",			dfNone,			0,		false,		true);
 				
 				FrozenCols = SaveNameCol("if_no");
 			}
 			break;

 		case "t3sheet1":      // sheet3 init
 			with (sheetObj) {
 				// 높이 설정
 				style.height = 420;
 				// 전체 너비 설정
 				SheetWidth = mainTable.clientWidth;

 				//Host정보 설정[필수][HostIp, Port, PagePath]
 				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

 				//전체Merge 종류 [선택, Default msNone]
 				MergeSheet = msHeaderOnly;

 			   //전체Edit 허용 여부 [선택, Default false]
 				Editable = true;

 				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 				InitRowInfo( 1, 1, 2, 100);

 				// 해더에서 처리할 수 있는 각종 기능을 설정한다
 				InitHeadMode(true, true, false, true, false,false)

 			    var HeadTitle  = "|Seq.|Collected OFC|DMT OFC|Tariff|INV No.|BKG No.|B/L No.|CUR|Billing AMT|Tax AMT|Collected Date|IF Date|IF No|Payer Code|Payer Name";

 				var headCount = ComCountHeadTitle(HeadTitle);
 				
 				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 				InitColumnInfo(headCount, 0, 0, true);
 				
 				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 				InitHeadRow(0, HeadTitle, true);

 				//데이터속성    [ROW, COL,  DATATYPE,		WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 				InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,		"ibflag");	
 				
 				InitDataProperty(0, cnt++ , dtSeq,			45,		daCenter,	true,		"seq");
 				InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,		"inv_pay_ofc_cd",	false,		"",			dfNone,			0,		false,		true);
 				InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,		"dmdt_ofc_cd",		false,		"",			dfNone,			0,		false,		true);
 				InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"dmdt_trf_cd",     	false,		"",			dfNone,			0,		false,		true);
 				InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"dmdt_inv_no", 		false,		"",			dfNone,			0,		false,		true);
 				InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,		"bkg_no",     		false,		"",			dfNone,			0,		false,		true);
 				InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,		"bl_no",    		false,		"",			dfNone,			0,		false,		true);
 				InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,		"inv_curr_cd",     	false,		"",			dfNone,			0,		false,		true);
 				InitDataProperty(0, cnt++ , dtData,		   100,		daRight,	true,		"inv_amt",     		false,		"",			dfNullFloat,	2,		false,		true);
 				InitDataProperty(0, cnt++ , dtData,		   100,		daRight,	true,		"tax_amt",     		false,		"",			dfNullFloat,	2,		false,		true);
 				InitDataProperty(0, cnt++ , dtData,		   110,		daCenter,	true,		"inv_pay_dt",    	false,		"",			dfNone,			0,		false,		true, -1, false, true, "Collected Local Date");
 				InitDataProperty(0, cnt++ , dtData,		   110,		daCenter,	true,		"if_dt",    		false,		"",			dfNone,			0,		false,		true, -1, false, true, "IF Local Date");
 				InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"if_no", 		   	false,		"",			dfNone,			0,		false,		true);
 				InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"payer_cd", 		false,		"",			dfNone,			0,		false,		true);
 				InitDataProperty(0, cnt++ , dtData,		   180,		daLeft,		true,		"payer_nm", 		false,		"",			dfNone,			0,		false,		true);
 				
 			}
 			break;
 			
        case "sheet3":      // sheet4 init
			with (sheetObj) {
 				// 높이 설정
 				style.height = 420;
 				// 전체 너비 설정
 				SheetWidth = mainTable.clientWidth;

 				//Host정보 설정[필수][HostIp, Port, PagePath]
 				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

 				//전체Merge 종류 [선택, Default msNone]
 				MergeSheet = msPrevColumnMerge + msHeaderOnly;

 			   //전체Edit 허용 여부 [선택, Default false]
 				Editable = true;

 				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 				InitRowInfo( 1, 1, 2, 100);

 				var HeadTitle  = "Office|SUBTOT|I/F DT|Tariff|INV No.|BKG No.|B/L No.|I/F No.|VVD CD|Port|I/F OFC|I/F Name|ISS DT|ISS OFC|ISS Name|Cur.|Billing AMT|Tax AMT|Payable AMT|Payer Flg|Payer CD|Payer Name|Shipper|Shipper|Consignee|Consignee|Notify|Notify|CNTR No.|Starting DT|Ending DT|Over days";
 				
 				var headCount = ComCountHeadTitle(HeadTitle);
 				
 				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 				InitColumnInfo(headCount, 0, 0, true);

 				// 해더에서 처리할 수 있는 각종 기능을 설정한다
 				InitHeadMode(true, true, false, true, false,false)

 				
 				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 				InitHeadRow(0, HeadTitle, true);

 				//데이터속성    [ROW, COL,  DATATYPE,		WIDTH,		DATAALIGN, COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 				InitDataProperty(0, cnt++ , dtData,			50,			daCenter,	true,		"ofc_cd",    		false,		"",			dfNone,			0,		false,		true);
 				//SubTotal을 위한 필드(Hidden)
 				InitDataProperty(0, cnt++ , dtHidden,		50,			daCenter,	true,		"subtot",    		false,		"",			dfNone,			0,		false,		true);
 				InitDataProperty(0, cnt++ , dtData,			85,			daCenter,	true,		"ar_if_dt",      	false,		"",			dfDateYmd,		0,		false,		true);
 																																
 				InitDataProperty(0, cnt++ , dtData,			50,			daCenter,	true,		"dmdt_trf_cd",     	false,		"",			dfNone,			0,		false,		true);
 				InitDataProperty(0, cnt++ , dtData,			80,			daCenter,	true,		"dmdt_inv_no",     	false,		"",			dfNone,			0,		false,		true);
 				InitDataProperty(0, cnt++ , dtData,			100,		daCenter,	true,		"bkg_no",     		false,		"",			dfNone,			0,		false,		true);
 				InitDataProperty(0, cnt++ , dtData,			90,			daCenter,	true,		"bl_no",      		false,		"",			dfNone,			0,		false,		true);
 				InitDataProperty(0, cnt++ , dtData,			90,			daCenter,	true,		"ar_if_no",      	false,		"",			dfNone,			0,		false,		true);
 				InitDataProperty(0, cnt++ , dtData,			80,			daCenter,	true,		"vvd",       		false,		"",			dfNone,			0,		false,		true);
 																													
 				InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,		"port",      		false,		"",			dfNone,			0,		false,		true);
 				InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,		"ar_if_ofc_cd",    	false,		"",			dfNone,			0,		false,		true);
 				InitDataProperty(0, cnt++ , dtData,			80,			daLeft,		true,		"ar_if_usr_id",    	false,		"",			dfNone,			0,		false,		true);
 				InitDataProperty(0, cnt++ , dtData,			80,			daCenter,	true,		"cre_dt",    		false,		"",			dfDateYmd,		0,		false,		true);
 				InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,		"cre_ofc_cd",    	false,		"",			dfNone,			0,		false,		true);
 				InitDataProperty(0, cnt++ , dtData,			100,		daLeft,		true,		"cre_usr_id",    	false,		"",			dfNone,			0,		false,		true);
 				InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,		"inv_curr_cd",      false,		"",			dfNone,			0,		false,		true);
 				InitDataProperty(0, cnt++ , dtData,			150,		daRight,	true,		"inv_chg_amt",		false,		"",			dfNullFloat,	2,		false,		true);
 				InitDataProperty(0, cnt++ , dtData,			150,		daRight,	true,		"tax_amt",    		false,		"",			dfNullFloat,	2,		false,		true);
 				InitDataProperty(0, cnt++ , dtData,			150,		daRight,	true,		"inv_amt",			false,		"",			dfNullFloat,	2,		false,		true);
 				
 				InitDataProperty(0, cnt++ , dtHidden,		60,	 		daCenter,	true,		"payer_flg",    	false,		"",			dfNone,			0,		false,		true);
 				InitDataProperty(0, cnt++ , dtData,			60,	 		daCenter,	true,		"payer_cd",    		false,		"",			dfNone,			0,		false,		true);
 				InitDataProperty(0, cnt++ , dtData,			230,		daLeft,		true,		"payer_nm",    		false,		"",			dfNone,			0,		false,		true);
 				InitDataProperty(0, cnt++ , dtData,			60,	 		daCenter,	true,		"shipper_cd",  		false,		"",			dfNone,			0,		false,		true);
 				InitDataProperty(0, cnt++ , dtData,			230,		daLeft,		true,		"shipper_nm",  		false,		"",			dfNone,			0,		false,		true);
 																										
 				InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,		"consignee_cd",		false,		"",			dfNone,			0,		false,		true);
 				InitDataProperty(0, cnt++ , dtData,			230,		daLeft,		true,		"consignee_nm",		false,		"",			dfNone,			0,		false,		true);
 				InitDataProperty(0, cnt++ , dtData,			60,	 		daCenter,	true,		"notify_cd",   		false,		"",			dfNone,			0,		false,		true);
 				InitDataProperty(0, cnt++ , dtData,			230,		daLeft,		true,		"notify_nm",   		false,		"",			dfNone,			0,		false,		true);
 				
 				InitDataProperty(0, cnt++ , dtData,			230,		daCenter,	true,		"cntr_no",   		false,		"",			dfNone,			0,		false,		true);
 				InitDataProperty(0, cnt++ , dtData,			230,		daCenter,	true,		"ft_cmnc_dt",   	false,		"",			dfNone,			0,		false,		true);
 				InitDataProperty(0, cnt++ , dtData,			230,		daCenter,	true,		"ft_end_dt",   		false,		"",			dfNone,			0,		false,		true);
 				InitDataProperty(0, cnt++ , dtData,			230,		daRight,	true,		"fx_ft_ovr_dys",   	false,		"",			dfNullInteger,	0,		false,		true);
 					
 				FrozenCols = SaveNameCol("bkg_no");
 			}
			
			break;
	    }
	}
	  
	 /**
  	 * Combo 기본 설정 
  	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
  	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
  	 */ 
	function initCombo(comboObj, comboNo) {
  	    var formObj = document.form
  		
  	    switch(comboObj.id) {
  	    	case "office": 
	        	with (comboObj) { 
					MultiSelect = true; 
					UseAutoComplete = true;
					SetColAlign("left|left");   
					SetColWidth("60|300");				
					DropHeight = 160;
					ColBackColor(0) = "#CCFFFD";
  					ColBackColor(1) = "#CCFFFD";
					ValidChar(2,2);		//영문 대문자
					IMEMode = 0;
					//ValidChar(2, 2);	// 영어대문자 사용
		    	}  	        	  
				break;   	    
  	    	case "tariff_type_t1": 
  	    	case "tariff_type_t3": 
  	        	with (comboObj) { 
					MultiSelect = true; 
					UseAutoComplete = true;
					SetColAlign("left|left");   
					SetColWidth("50|300");				
					DropHeight = 160;
					ColBackColor(0) = "#CCFFFD";
  					ColBackColor(1) = "#CCFFFD";
  					ValidChar(2,2);		//영문 대문자
					IMEMode = 0;
  		    	}
  	        	break;
  	    	case "office_t2": 
	        	with (comboObj) { 
					MultiSelect = true; 
					UseAutoComplete = true;
					SetColAlign("left|left");   
					SetColWidth("60|300");				
					DropHeight = 160;
					ColBackColor(0) = "#CCFFFD";
  					ColBackColor(1) = "#CCFFFD";
  					ValidChar(2,2);		//영문 대문자
					IMEMode = 0;
		    	}  	        	  
				break;  
  	    	case "office_t3": 
	        	with (comboObj) { 
					MultiSelect = true; 
					UseAutoComplete = true;
					SetColAlign("left|left");   
					SetColWidth("60|300");				
					DropHeight = 160;
					ColBackColor(0) = "#CCFFFD";
  					ColBackColor(1) = "#CCFFFD";
  					ValidChar(2,2);		//영문 대문자
					IMEMode = 0;
		    	}  	        	  
				break;  				
  	     		} 
	}		 

  	/**
 	 * Combo 관련 프로세스 처리
 	 */	
	function doActionIBCombo(sheetObj,formObj,sAction,sComboObj) {
		sheetObj.ShowDebugMsg = false;
 		sheetObj.WaitImageVisible = false;

 		switch(sAction) {
	 		//tab1: A/R Office comboList	
	 		case IBSEARCH_ASYNC06:    
					
				formObj.f_cmd.value = COMMAND10;
	    	    var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
	    	    sComboObj.RemoveAll();
	    	    if (sXml != undefined && sXml != '') {
		    	    var ofc_cds = ComGetEtcData(sXml, "OFC_CD");
		    	    var ofc_nms = ComGetEtcData(sXml, "OFC_NM");
	
		    	    var comboCodeArr = ofc_cds.split("|");			    	    
		    	    var comboTextArr = ofc_nms.split("|");
		    	    
		    	    
		    	    //추가사항.2010.03.15
		    	    sComboObj.InsertItem(0, "All|All", "All");
		    	    
		    	    // 로그인 User Office를 Default - 리스트에 없을시 item 추가해서 표시
			  		var usr_ofc_cd = formObj.usr_ofc_cd.value;
			  		var startIdx = 1;
			  		if(ofc_cds.indexOf(usr_ofc_cd) == -1) {
			  			sComboObj.InsertItem(1, usr_ofc_cd, usr_ofc_cd);
			  			startIdx = 2;
			  		}
			  		
			  		for (var i = 0 ; i < comboTextArr.length ; i++) {
		    	    	sComboObj.InsertItem(startIdx + i, comboCodeArr[i] + "|" + comboTextArr[i], comboCodeArr[i]);		
		         	}
			  		
			  		sComboObj.Code = usr_ofc_cd;
			  		
			  		/*
			  		sComboObj.Code = usr_ofc_cd;
			  		
			  		if(sComboObj.Code != usr_ofc_cd) {
			  			sComboObj.InsertItem(1, usr_ofc_cd, usr_ofc_cd);
			  			sComboObj.Code = usr_ofc_cd;
			  		}*/
	    	    }
		    	    
		    	
	    	    break;
	    	    
     		//tab1:Office comboList	
     		case IBSEARCH_ASYNC01:    
 				
 				formObj.f_cmd.value = SEARCHLIST02;
 	    	    var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
 	    	    sComboObj.RemoveAll();
 	    	    if (sXml != undefined && sXml != '') {
 		    	    var ofc_cds = ComGetEtcData(sXml, "OFC_CD");
 		    	    var ofc_nms = ComGetEtcData(sXml, "OFC_NM");
 	
 		    	    var comboCodeArr = ofc_cds.split("|");			    	    
 		    	    var comboTextArr = ofc_nms.split("|");
 		    	    //추가사항.2010.03.15
		    	    sComboObj.InsertItem(0, "All|All", "All");
		    	    
		    	    // 로그인 User Office를 Default - 리스트에 없을시 item 추가해서 표시
			  		var usr_ofc_cd = formObj.usr_ofc_cd.value;
			  		var startIdx = 1;
			  		if(ofc_cds.indexOf(usr_ofc_cd) == -1) {
			  			sComboObj.InsertItem(1, usr_ofc_cd, usr_ofc_cd);
			  			startIdx = 2;
			  		}
			  		
			  		for (var i = 0 ; i < comboTextArr.length ; i++) {
		    	    	sComboObj.InsertItem(startIdx + i, comboCodeArr[i] + "|" + comboTextArr[i], comboCodeArr[i]);		
		         	}
			  		
			  		sComboObj.Code = usr_ofc_cd;
 	    	    }
 	    	    

 	    	    break;
     		
 	    	//tab1:Tariff type comboList
     		case IBSEARCH_ASYNC02:     
 		 		
 				formObj.f_cmd.value = SEARCHLIST;
 				var xmlStr = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
 				sComboObj.RemoveAll();
 				
 				var data = ComGetEtcData(xmlStr, COMMON_TARIFF_CD);
 				if (data != undefined && data != '') {
 					var comboItems = data.split(ROWMARK);
 					addComboItem(sComboObj,comboItems);
 					comboItem = comboItems[0].split(FIELDMARK);
 				}	
 				
 				var data2 = ComGetEtcData(xmlStr, USER_TARIFF_TYPE);
 				// User Setup Tariff Type 이 없을 경우 Default값으로.
 				if(data2 == '') data2 = 'CTIC,DMIF';
 				
 				sComboObj.Code2 = data2;
 				USR_TRF_TP = data2;
 				formObj.usr_trf_tp.value = data2;
 				break;

 			//tab1/tab3:From Yard Code comboList
     		case IBSEARCH_ASYNC03:  
				//3. Sub Office comboList
     			var comboObj;
     			if (ComGetObjValue(formObj.tab_order) == 0) {
     				comboObj = comboObjects[0]; //office Combo Object
     			}
     			else {
     				comboObj = comboObjects[3]; //office Combo Object
     			}
     			ComSetObjValue(formObj.f_cmd, COMMAND01);

	    	    var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
	    	    if (sXml != undefined && sXml != '') {
	    	    	var subOfcCds = ComGetEtcData(sXml, "OFC_CD");
	    	    	if (subOfcCds != undefined && subOfcCds != '') {
	    	    		// 조회된 Sub Office 중에서  기존 콤보리스트에 없는 것은 제거한다.
	    	    		var arrOfcCd = subOfcCds.split(',');
	    	    		var str = '';
	    	    		for(var i=0; i<arrOfcCd.length; i++) {
	    	    			var idx = comboObj.FindIndex(arrOfcCd[i], 0);
	    	    			if(idx != -1)
	    	    				str = str + ',' + arrOfcCd[i];
	    	    		}
	    	    		str = str.substring(1);
	    	    		
	    	    		// 하위점소 조회대상 Office 목록에  로그인 Office 포함시, 하위점소 조회결과에 로그인 Office가 없을시 추가해준다.
	    	    		var usrOfcCd = ComGetObjValue(formObj.usr_ofc_cd);
	    	    		if(comboObj.Code.indexOf(usrOfcCd) != -1 && str.indexOf(usrOfcCd)==-1) {
	    	    			str = usrOfcCd + ',' + str;
	    	    		}
	    	    		comboObj.Code = str;
	    	    	 }
	    	    }
	    	   
     			break;
     			
         	//tab2:Office comboList	
     		case IBSEARCH_ASYNC04:    
 				
 				formObj.f_cmd.value = COMMAND10;
 	    	    var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
 	    	    sComboObj.RemoveAll();
 	    	    if (sXml != undefined && sXml != '') {
 		    	    var ofc_cds = ComGetEtcData(sXml, "OFC_CD");
 		    	    var ofc_nms = ComGetEtcData(sXml, "OFC_NM");
 	
 		    	    var comboCodeArr = ofc_cds.split("|");			    	    
 		    	    var comboTextArr = ofc_nms.split("|");
 		    	    
 		    	    //추가사항.2010.03.17
		    	    sComboObj.InsertItem(0, "All|All", "All");
		    	    
		    	    // 로그인 User Office를 Default - 리스트에 없을시 item 추가해서 표시
			  		var usr_ofc_cd_t2 = formObj.usr_ofc_cd_t2.value;
			  		var startIdx = 1;
			  		if(ofc_cds.indexOf(usr_ofc_cd_t2) == -1) {
			  			sComboObj.InsertItem(1, usr_ofc_cd_t2, usr_ofc_cd_t2);
			  			startIdx = 2;
			  		}
			  		
			  		for (var i = 0 ; i < comboTextArr.length ; i++) {
		    	    	sComboObj.InsertItem(startIdx + i, comboCodeArr[i] + "|" + comboTextArr[i], comboCodeArr[i]);		
		         	}
			  		
			  		sComboObj.Code = usr_ofc_cd_t2;
 	    	    }
 	    	    
 	    	    break;     	
 	 		//tab2:From Yard Code comboList
     		case IBSEARCH_ASYNC05:  
				//3. Sub Office comboList
				var comboObj = comboObjects[2]; //office_t2 Combo Object
				formObj.f_cmd.value = COMMAND01;
	    	    var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
	    	    if (sXml != undefined && sXml != '') {
	    	    	var subOfcCds = ComGetEtcData(sXml, "OFC_CD");
	    	    	if (subOfcCds != undefined && subOfcCds != '') {
	    	    		// 조회된 Sub Office 중에서  기존 콤보리스트에 없는 것은 제거한다.
	    	    		var arrOfcCd = subOfcCds.split(',');
	    	    		var str = '';
	    	    		for(var i=0; i<arrOfcCd.length; i++) {
	    	    			var idx = comboObj.FindIndex(arrOfcCd[i], 0);
	    	    			if(idx != -1)
	    	    				str = str + ',' + arrOfcCd[i];
	    	    		}
	    	    		str = str.substring(1);
	    	    		
	    	    		// 하위점소 조회대상 Office 목록에  로그인 Office 포함시, 하위점소 조회결과에 로그인 Office가 없을시 추가해준다.
	    	    		var usrOfcCd = ComGetObjValue(formObj.usr_ofc_cd);
	    	    		if(comboObj.Code.indexOf(usrOfcCd) != -1 && str.indexOf(usrOfcCd)==-1) {
	    	    			str = usrOfcCd + ',' + str;
	    	    		}
	    	    		comboObj.Code = str;
	    	    	 }
	    	    }
	    	   
     			break; 	    	    
         }
 		sheetObj.WaitImageVisible = true;
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

 			formObj.ofc_cd_t1.value = ComGetObjValue(comboObjects[0]);
 			formObj.ofc_cd.value = formObj.ofc_cd_t1.value;
 			doActionIBCombo(sheetObjects[0], formObj, IBSEARCH_ASYNC03);
 		} else {
 			ComSetObjValue(comboObjects[0], formObj.ofc_cd_t1.value);
 		}
 	}	
 	/*
 	 * 다중선택된 DEM/DET Office의 하위점소(Sub Office) 조회기능 
 	 */
 	function doInclSubOfcT2() {
 	
 		var formObj = document.form;
 	
 		if (formObj.chk_sub_ofc_t2.checked) { // Sub Office 포함
 			if (ComIsEmpty(comboObjects[2].Code)) {
 				ComShowCodeMessage('COM12113', "DEM/DET Office");
 				formObj.chk_sub_ofc_t2.checked = false;
 				return;
 			}

 			formObj.ofc_cd_t2.value = ComGetObjValue(comboObjects[2]);
 			formObj.ofc_cd.value = formObj.ofc_cd_t2.value;
 			doActionIBCombo(sheetObjects[0], formObj, IBSEARCH_ASYNC05);
 		} else {
 			ComSetObjValue(comboObjects[2], formObj.ofc_cd_t2.value);
 		}
 	}	
 	/*
 	 * 다중선택된 DEM/DET Office의 하위점소(Sub Office) 조회기능 
 	 */
 	function doInclSubOfcT3() {
 	
 		var formObj = document.form;
 	
 		if (formObj.chk_sub_ofc_t3.checked) { // Sub Office 포함
 			if (ComIsEmpty(comboObjects[3].Code)) {
 				ComShowCodeMessage('COM12113', "Collected Office");
 				formObj.chk_sub_ofc_t3.checked = false;
 				return;
 			}

 			formObj.ofc_cd_t3.value = ComGetObjValue(comboObjects[2]);
 			formObj.ofc_cd.value = formObj.ofc_cd_t3.value;
 			doActionIBCombo(sheetObjects[0], formObj, IBSEARCH_ASYNC03);
 		} else {
 			ComSetObjValue(comboObjects[3], formObj.ofc_cd_t3.value);
 		}
 	}	
 	
    /**
     * 콤보필드에 데이터를 추가해준다.
     */	
 	function addComboItem(comboObj,comboItems) {
 		var comboID = comboObj.id;
 		switch(comboID) {		
 			case "tariff_type_t1":
 			case "tariff_type_t3":
 				comboObj.InsertItem(0, "All|All", "All");
		  		for (var i = 0 ; i < comboItems.length ; i++) {
		  	   		var comboItem = comboItems[i].split(FIELDMARK);
		  				comboObj.InsertItem(i+1, comboItem[0] + "|" + comboItem[1], comboItem[0]);
		  	   	}
 			   	break;
 		}			   	
 	}
		    
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
	 		case IBSEARCH:      //조회
				if (!validateForm(sheetObj, formObj, sAction)) {
					return false;
				}
				
	 			if(sheetObj.id == "t1sheet1" || sheetObj.id == "sheet3"){
	 				//ComOpenWait Start
					sheetObj.WaitImageVisible=false;
			        ComOpenWait(true);
	 				
			        formObj.f_cmd.value = SEARCH01;
	 				sheetObj.DoSearch4Post("EES_DMT_5001-1GS.do",	FormQueryString(formObj));
	 				
	 				//ComOpenWait End
					ComOpenWait(false);
				} 
	 			else if(sheetObj.id == "t2sheet1"){
					//ComOpenWait Start
					sheetObj.WaitImageVisible=false;
			        ComOpenWait(true);
			        
					formObj.f_cmd.value = SEARCH02;
					sheetObj.DoSearch4Post("EES_DMT_5001-1GS.do",	FormQueryString(formObj));
					
					//ComOpenWait End
					ComOpenWait(false);
				}
	 			else if(sheetObj.id == "t3sheet1"){
					//ComOpenWait Start
					sheetObj.WaitImageVisible=false;
			        ComOpenWait(true);
			        
					formObj.f_cmd.value = SEARCH03;
					sheetObj.DoSearch4Post("EES_DMT_5001-1GS.do",	FormQueryString(formObj));
					
					//ComOpenWait End
					ComOpenWait(false);
				}	 			
	 			break;
		}
	}	 

	/**
	* 초기값 SETTING
	*/
	
	function doInit() {
		var formObj = document.form;
		var tabOrder = formObj.tab_order.value;
		with (formObj) {
			//tab1 a/r office 초기에는 a/r office를 로딩함. 
			//doActionIBCombo(sheetObjects[0],formObj,IBSEARCH_ASYNC06,comboObjects[0]);
			//2010.04.23. -> a/r office를 tab1 issue office로 요청  	
			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH_ASYNC01,comboObjects[0]);
			
			//tab1 tarrif type
			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH_ASYNC02,comboObjects[1]);
			
			//tab1
			//사용자 Office 의 현재 날짜를 조회한다.
			var ofcCurrDate = DmtComOfficeCurrDate(sheetObjects[0], formObj); 
			//조회한 날짜를 화면의 필드에 매핑 시킨다.
			ComSetObjValue(formObj.fm_dt, 	ComGetDateAdd(ofcCurrDate, "M", -1)); //1개월 이전 날짜.
			ComSetObjValue(formObj.to_dt,   ofcCurrDate);  //오늘 날짜.
			//formObj.fm_dt.value = ComGetDateAdd(null, "M", -1); //1개월 이전 날짜.
    		//formObj.to_dt.value = ComGetNowInfo("ymd"); //오늘 날짜.
    		
    		sheetObjects[0].RemoveAll();
    		
    		//tab2 a/r office
			doActionIBCombo(sheetObjects[1],formObj,IBSEARCH_ASYNC04,comboObjects[2]);
			
			//tab2
			var ofcCurrDateT2 = DmtComOfficeCurrDate(sheetObjects[1], formObj); 
			//조회한 날짜를 화면의 필드에 매핑 시킨다.
			ComSetObjValue(formObj.fm_dt_t2, 	ComGetDateAdd(ofcCurrDateT2, "M", -1)); //1개월 이전 날짜.
			ComSetObjValue(formObj.to_dt_t2,   	ofcCurrDateT2);  //오늘 날짜.
    		//formObj.fm_dt_t2.value = ComGetDateAdd(null, "M", -1); //1개월 이전 날짜.
    		//formObj.to_dt_t2.value = ComGetNowInfo("ymd"); //오늘 날짜.
    		sheetObjects[1].RemoveAll();
    		
    		//tab3 - collected office
			doActionIBCombo(sheetObjects[2],formObj,IBSEARCH_ASYNC01,comboObjects[3]);
			
			ComSetObjValue(formObj.fm_if_dt, 	ComGetDateAdd(ofcCurrDateT2, "M", -1)); //1개월 이전 날짜.
			ComSetObjValue(formObj.to_if_dt,    ofcCurrDateT2);  //오늘 날짜.  
			//tab3 tarrif type
			doActionIBCombo(sheetObjects[2],formObj,IBSEARCH_ASYNC02,comboObjects[4]);			
			
			sheetObjects[2].RemoveAll();
		}
	}  
	
	function initSearchControls() {
		var formObj = document.form;
		var tabOrder = formObj.tab_order.value;
		with (formObj) {
//			ComResetAll();
			if (tabOrder == 0) {
				ComClearManyObjects(cust_cd, cust_nm, ofc_cd_t1, s_cust_gubun, s_cust_cd);		
			 	DmtComSetClassManyObjects('input', cust_cd); 
			 	ComSetObjValue(r_office, "1");
			 	chk_sub_ofc.checked = false;
			 	ComSetObjValue(cust_type, "P");
			 	// 새로 추가한 s_invoice_no, s_bkg_no 초기화
			 	ComSetObjValue(s_invoice_no, "");
			 	ComSetObjValue(s_bkg_no, "");
			 	
			 	//tab1 office 	
			 	//tab1 a/r office 초기에는 a/r office를 로딩함. 
				//doActionIBCombo(sheetObjects[0],formObj,IBSEARCH_ASYNC06,comboObjects[0]);
				//2010.04.23. -> a/r office를 tab1 issue office로 요청  	
				doActionIBCombo(sheetObjects[0],formObj,IBSEARCH_ASYNC01,comboObjects[0]);

				
				//tab1 tarrif type
				doActionIBCombo(sheetObjects[0],formObj,IBSEARCH_ASYNC02,comboObjects[1]);
				
				//tab1
				//사용자 Office 의 현재 날짜를 조회한다.
				var ofcCurrDate = DmtComOfficeCurrDate(sheetObjects[0], formObj); 
				//조회한 날짜를 화면의 필드에 매핑 시킨다.
				ComSetObjValue(formObj.fm_dt, 	ComGetDateAdd(ofcCurrDate, "M", -1)); //1개월 이전 날짜.
				ComSetObjValue(formObj.to_dt,   ofcCurrDate);  //오늘 날짜.
				//formObj.fm_dt.value = ComGetDateAdd(null, "M", -1); //1개월 이전 날짜.
	    		//formObj.to_dt.value = ComGetNowInfo("ymd"); //오늘 날짜.
	    		
	    		sheetObjects[0].RemoveAll();
			} 
			else if (tabOrder == 1) {
				ComClearManyObjects(act_cust_cd, act_cust_nm, ofc_cd_t2, s_cust_gubun_t2, s_cust_cd_t2);		
			 	DmtComSetClassManyObjects('input', act_cust_cd); 
			 	chk_sub_ofc_t2.checked = false;
			 	ComSetObjValue(chg_cd, "");
			 	ComSetObjValue(io_bnd_cd, "");
			 	ComSetObjValue(type, "");
			 	
				//tab2 a/r office
				doActionIBCombo(sheetObjects[1],formObj,IBSEARCH_ASYNC04,comboObjects[2]);
				
				//tab2
				//사용자 Office 의 현재 날짜를 조회한다.
				var ofcCurrDateT2 = DmtComOfficeCurrDate(sheetObjects[1], formObj); 
				//조회한 날짜를 화면의 필드에 매핑 시킨다.
				ComSetObjValue(formObj.fm_dt_t2, 	ComGetDateAdd(ofcCurrDateT2, "M", -1)); //1개월 이전 날짜.
				ComSetObjValue(formObj.to_dt_t2,   	ofcCurrDateT2);  //오늘 날짜.
	    		//formObj.fm_dt_t2.value = ComGetDateAdd(null, "M", -1); //1개월 이전 날짜.
	    		//formObj.to_dt_t2.value = ComGetNowInfo("ymd"); //오늘 날짜.
	    		sheetObjects[1].RemoveAll();
			}
			else {
				ComClearManyObjects(ofc_cd_t3);		
			 	chk_sub_ofc_t3.checked = false;
			 	
				//tab3 collected office
			 	doActionIBCombo(sheetObjects[2],formObj,IBSEARCH_ASYNC01,comboObjects[3]);
				//tab3 tarrif type 추가
				doActionIBCombo(sheetObjects[2],formObj,IBSEARCH_ASYNC02,comboObjects[4]);
				
				//tab2
				//사용자 Office 의 현재 날짜를 조회한다.
				var ofcCurrDateT2 = DmtComOfficeCurrDate(sheetObjects[1], formObj); 
				//조회한 날짜를 화면의 필드에 매핑 시킨다.
				ComSetObjValue(formObj.fm_if_dt, 	ComGetDateAdd(ofcCurrDateT2, "M", -1)); //1개월 이전 날짜.
				ComSetObjValue(formObj.to_if_dt,    ofcCurrDateT2);  //오늘 날짜.    
	    		//formObj.fm_dt_t2.value = ComGetDateAdd(null, "M", -1); //1개월 이전 날짜.
	    		//formObj.to_dt_t2.value = ComGetNowInfo("ymd"); //오늘 날짜.
				ComSetObjValue(invoice_no, "");
			 	ComSetObjValue(bkg_no, "");
	    		sheetObjects[2].RemoveAll();
			}
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
                    InsertTab( cnt++ , "From DEM/DET",       -1 );
                    InsertTab( cnt++ , "From Other",         -1 );
                    InsertTab( cnt++ , "From ERP (DEM/DET)", -1 );
                }
                break;
        }
    }


    /**
 	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 	 */
 	function validateForm(sheetObj,formObj,sAction) {
 		 with(formObj){
 			//[설명]TAB 선택시 tab_order에 값 셋팅하기		
 		 	//1.  From DEM/DET : 0, From Other : 1
 			var tabOrder = tab_order.value;
 			//[TAB1]From DEM/DET 선택시
 			if (tabOrder == 0) {
 				ComSetObjValue(ofc_cd, 			comboObjects[0].Text);
 				ComSetObjValue(dmdt_trf_cd_t1, 	comboObjects[1].Text);
 				
 	 			if (ComGetObjValue(r_office) == '1') {
 	 				formObj.ofc_tp.value = "ar_if_ofc";
 	 			} 
 	 			else if (ComGetObjValue(r_office) == '2') {
 	 				formObj.ofc_tp.value = "issue_ofc";
 	 			}
 	 			
 	 			var ofcCd 		= ComGetObjValue(ofc_cd);
 	 			var dmdtTrfCd 	= ComGetObjValue(dmdt_trf_cd_t1);
 	 			
 	 			if (ofcCd == '') {
 	 				ComShowCodeMessage('DMT02002', 'Office');
 	 				return;
 	 			}
 				if (dmdtTrfCd == '') {
 					ComShowCodeMessage('DMT02002', 'Tariff Type');
 					return;
 				}
 				
 	 			// 조회조건 날짜 입력부분 유효성 체크
 	 			if (!validateFormDateField("fm_dt", "Period From Date", "to_dt", "Period To Date")) return false;

 			} 
 			//[TAB2]From Other 선택시
 			else if (tabOrder == 1) {
 				ComSetObjValue(ofc_cd, 			comboObjects[2].Text);
 				
 	 			var ofcCd 		= ComGetObjValue(ofc_cd);
 	 			if(ofcCd == ''){
 	 				ComShowCodeMessage('DMT02002', 'Office');
 	 				return;
 	 			}
 	 			
 	 			// 조회조건 날짜 입력부분 유효성 체크
 	 			if (!validateFormDateField("fm_dt_t2", "Period From Date", "to_dt_t2", "Period To Date")) return false;

 			}
 			//[TAB3]From ERP (DEM/DET) 선택시
 			else if (tabOrder == 2) {
 				ComSetObjValue(ofc_cd, 			comboObjects[3].Text);
 				ComSetObjValue(dmdt_trf_cd_t3, 	comboObjects[4].Text);
 				
 	 			var ofcCd = ComGetObjValue(ofc_cd);
 	 			var dmdtTrfCd 	= ComGetObjValue(dmdt_trf_cd_t3);
 	 			if (ofcCd == '') {
 	 				ComShowCodeMessage('DMT02002', 'Collected Office');
 	 				return;
 	 			}
 	 			if (dmdtTrfCd == '') {
 					ComShowCodeMessage('DMT02002', 'Tariff Type');
 					return;
 				}
 	 			
 	 			// 조회조건 날짜 입력부분 유효성 체크 	 			
 	 			if (!validateFormDateField("fm_if_dt",  "I/F Period From Date",       "to_if_dt",  "I/F Period To Date"))       return false;
 			} 			
 			
 		}
 		return true;
 	}

 	// 조회조건 날짜 입력부분 유효성 체크
 	function validateFormDateField(dateObj1Id, dateObj1Nm, dateObj2Id, dateObj2Nm) {

 		var formObj = document.form;
 		
 		if (!ComIsDate(eval("formObj." + dateObj1Id))) {
			ComAlertFocus(eval("formObj." + dateObj1Id), ComGetMsg('COM12134', dateObj1Nm));
			return false;
		}
		if (!ComIsDate(eval("formObj." + dateObj2Id))) {
			ComAlertFocus(eval("formObj." + dateObj2Id), ComGetMsg('COM12134', dateObj2Nm));
			return false;
		}
        if (ComChkPeriod(eval("formObj." + dateObj1Id + ".value"), eval("formObj." + dateObj2Id + ".value")) <= 0){
			ComShowCodeMessage('DMT01020');
			return false;
		} 
        else if (ComChkPeriod(eval("formObj." + dateObj1Id + ".value"), eval("formObj." + dateObj2Id + ".value")) > 0) {
			if (ComGetDaysBetween(eval("formObj." + dateObj1Id + ".value"), eval("formObj." + dateObj2Id + ".value")) > 365) {
				ComShowCodeMessage('DMT00162','1 Year');
				return false;
			}
		}
        
        return true;
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
 	 	 //1.  From DEM/DET : 0, From BKG Charge : 1
     	 formObj.tab_order.value =  beforetab;
         
     	 //tab1:Detail 버튼 생성, tab2: Detail 버튼 삭제
     	 var schCondDiv = document.getElementById("sch_cond_div");
     	 if (ComGetObjValue(formObj.tab_order) == 0) {
     		 schCondDiv.style.display = 'block';
	 	 } 
     	 else {
	 		 schCondDiv.style.display = 'none';
	 	 }
     	 
 	}

	function t1sheet1_OnLoadFinish() {   
		var formObj = document.form
		sheetObjects[0].WaitImageVisible = false;   
//      	initSearchControls();
      	doInit()
      	sheetObjects[0].WaitImageVisible = true;   
	}  
	
	function t2sheet1_OnLoadFinish() {   

	}  
	
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg){
    	with(sheetObj){
			//Payer CD delt가 Y인 플래그만 별도로 tooltip으로 상태를 알려줌.
			if ( RowCount <= 0 ) { return; }
            for ( var i = 1 ; i < LastRow ; i++ ) {
                if ( CellValue( i , "payer_flg" ) == "Y" ) {
                    ToolTipText( i , "payer_cd" ) = "Customer Code not available any more";
                    CellFontColor( i , "payer_cd" ) = RgbColor( 220 , 0 , 0 );
                }
            }  
            
            //IBSHEET에서는 기준 정렬은 하나만 존재야 하므로 
			//GROUPING이 되는 조건 ofc_cd+ar_if_dt+inv_curr_cd=> subtotal 필드를 별도록 생성 후 기준 열로 정함 
			//[최종:]subtotal을 기준으로 사용하는 대신에.. ofc_cd로 그룹핑을 한후 다시 ar_if_dt로 그룹 후 다시 curr_cd로 그룹 함.
			// 범위를 좁히면서 subtotal을 표현함.
			sheetObj.ShowSubSum("ofc_cd", 		"inv_chg_amt|tax_amt|inv_amt", -1, false, false, 0, "chk=;ofc_cd=%s;seq=S.TTL");
			sheetObj.ShowSubSum("ar_if_dt", 	"inv_chg_amt|tax_amt|inv_amt", -1, false, false, 0, "chk=;ofc_cd=%s;ar_if_dt=%s;seq=S.TTL");
//			sheetObj.ShowSubSum("inv_curr_cd", 	"inv_chg_amt|tax_amt|inv_amt", -1, false, false, 0, "chk=;ofc_cd=%s;ar_if_dt=%s;inv_curr_cd=%s;seq=S.TTL");
			SumText(0, "seq") = "TTL";
		}

    }

	function t2sheet1_OnSearchEnd(sheetObj, ErrMsg){
		with(sheetObj){
			//Payer CD delt가 Y인 플래그만 별도로 tooltip으로 상태를 알려줌.
			if ( RowCount <= 0 ) { return; }
            for ( var i = 1 ; i < LastRow ; i++ ) {
                if ( CellValue( i , "payer_flg" ) == "Y" ) {
                    ToolTipText( i , "payer_cd" ) = "Customer Code not available any more";
                    CellFontColor( i , "payer_cd" ) = RgbColor( 220 , 0 , 0 );
                }
            }   
			sheetObj.ShowSubSum("ar_ofc_cd", 	"chg_amt", -1, false, false, 0, "chk=;ar_ofc_cd=%s;seq=S.TTL");
			sheetObj.ShowSubSum("if_dt", 		"chg_amt", -1, false, false, 0, "chk=;ar_ofc_cd=%s;if_dt=%s;seq=S.TTL");
			SumText(0, "seq") = "TTL";
		}
	}
	
	 

	/*
	 * 각 공통팝업창 호출 함수 
	 */
	function openPopup(flag, arg) {
	  		
		var sheetObj = sheetObjects[0];
		var formObj	= document.form;
		var sUrl	= '';
		var sWidth	= '';
		var sHeight	= '';
		
		with(sheetObj) {
	  		switch(flag) {
	  			case 'cust_cd':		// Customer Inquiry Popup
					ComOpenPopup('COM_ENS_041.do', 770, 470, "getCustCd", "1,0,1,1,1,1,1", true);
					break;
	  			case 'act_cust_cd':		// Customer Inquiry Popup
				ComOpenPopup('COM_ENS_041.do', 770, 470, "getActCustCd", "1,0,1,1,1,1,1", true);
				break;					
	  		} // switch-end
		} // with-end
		
		if(sUrl.indexOf('.do') != -1) {
			//var sWinName = ComReplaceStr(sUrl, '.do', '');
  			var sWinName = sUrl.substring(0, sUrl.indexOf('.do'));
			ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true);
		} else if(sUrl != '') {
	  		ComOpenWindow('http://nis2010.hanjin.com/nis2010/grid/apps/nis2010/' + sUrl,'p'
						,'scrollbars=no,toolbar=no,location=no,resizable=yes,menubar=no, width=' + sWidth + ',height=' + sHeight + ',left=0,top=0');
		}
	}
	
    /*
  	 * Customer 공통팝업에서 선택한 Customer Code값을 해당 필드에 설정 
  	 */
    function getCustCd(aryPopupData) {
    	document.form.cust_cd.value = aryPopupData[0][3];
        document.form.cust_nm.value = aryPopupData[0][4];
    }
     /*
   	 * Act_Customer 공통팝업에서 선택한 Customer Code값을 해당 필드에 설정 
   	 */
     function getActCustCd(aryPopupData) {
     	document.form.act_cust_cd.value = aryPopupData[0][3];
        document.form.act_cust_nm.value = aryPopupData[0][4];
     }
	//Customer 체크
	function doActionText(sheetObj, formObj, object, formCmd) {
        sheetObj.ShowDebugMsg = false;
        sheetObj.WaitImageVisible = false;
        var cust_len = parseInt(ComGetLenByByte(ComGetObjValue(formObj.cust_cd)));

        if(cust_len == 0){
        	ComSetObjValue(formObj.s_cust_gubun, "");
            ComSetObjValue(formObj.cust_cd, "");
            ComSetObjValue(formObj.cust_nm, "");
        	return;
        }
       
        if(cust_len > 2) {
			var char_chk = ComGetObjValue(formObj.cust_cd).substring(0,2);
			//2자리가 영문자이면 CUSTOMER 조회
			if(ComIsAlphabet(char_chk)) {
				ComSetObjValue(formObj.s_cust_gubun, "2");
				ComSetObjValue(formObj.s_cust_cd, formObj.cust_cd.value);
			//아니면 VENDOR 조회
			}else{
				ComSetObjValue(formObj.s_cust_gubun, "1");
				ComSetObjValue(formObj.s_cust_cd, formObj.cust_cd.value);
			}
		}else{
			ComShowCodeMessage("DMT00165", "Payer");
			ComSetObjValue(formObj.s_cust_gubun, "");
            ComSetObjValue(formObj.cust_cd, "");
            ComSetObjValue(formObj.cust_nm, "");
            ComSetFocus(formObj.cust_cd);
			return;
		}
        
        ComSetObjValue(formObj.f_cmd, formCmd);
        var sXml    = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
        var custCd = ComGetEtcData(sXml, "PAYER_CODE");
        var custNm = ComGetEtcData(sXml, "PAYER_NM");
        var delt_flg = ComGetEtcData(sXml, "DELT_FLG");
        
        if(custNm == null || custNm == "" || custNm == undefined) {
            ComSetFocus(formObj.cust_cd);
            document.form.s_cust_gubun.value = "";
            document.form.cust_cd.value = "";
            document.form.cust_nm.value = "";   
            ComShowCodeMessage("DMT00165", "Payer");
        } else {
        	document.form.cust_nm.value = custNm;
            document.form.cust_cd.value = custCd;
        }
        sheetObj.WaitImageVisible = true;
    } 
	
	//Customer 체크
	function doActionTextT2(sheetObj, formObj, object, formCmd) {
        sheetObj.ShowDebugMsg = false;
        sheetObj.WaitImageVisible = false;
        var cust_len = parseInt(ComGetLenByByte(ComGetObjValue(formObj.act_cust_cd)));

        if(cust_len == 0){
        	ComSetObjValue(formObj.s_cust_gubun, "");
            ComSetObjValue(formObj.act_cust_cd, "");
            ComSetObjValue(formObj.act_cust_nm, "");
        	return;
        }
              
        if(cust_len > 2) {
			var char_chk = ComGetObjValue(formObj.act_cust_cd).substring(0,2);
			//2자리가 영문자이면 CUSTOMER 조회
			if(ComIsAlphabet(char_chk)) {
				ComSetObjValue(formObj.s_cust_gubun, "2");
	            ComSetObjValue(formObj.s_cust_cd, formObj.act_cust_cd.value);
			//아니면 VENDOR 조회
			}else{
				ComShowCodeMessage("DMT00165", "Payer");
				ComSetObjValue(formObj.s_cust_gubun, "");
	            ComSetObjValue(formObj.act_cust_cd, "");
	            ComSetObjValue(formObj.act_cust_nm, "");
	            ComSetFocus(formObj.act_cust_cd);
				return;
			}
		}else{
			ComShowCodeMessage("DMT00165", "Payer");
			ComSetObjValue(formObj.s_cust_gubun, "");
            ComSetObjValue(formObj.act_cust_cd, "");
            ComSetObjValue(formObj.act_cust_nm, "");
            ComSetFocus(formObj.act_cust_cd);
			return;
		}
        
        
        
        ComSetObjValue(formObj.f_cmd, formCmd);
        var sXml    = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
        var custCd = ComGetEtcData(sXml, "PAYER_CODE");
        var custNm = ComGetEtcData(sXml, "PAYER_NM");
        var delt_flg = ComGetEtcData(sXml, "DELT_FLG");
        
        if(custNm == null || custNm == "" || custNm == undefined) {
            ComSetFocus(formObj.act_cust_cd);
            document.form.s_cust_gubun.value = "";
            document.form.act_cust_cd.value = "";
            document.form.act_cust_nm.value = "";     
            ComShowCodeMessage("DMT00165", "Payer");
        } else {
        	document.form.act_cust_nm.value = custNm;
            document.form.act_cust_cd.value = custCd;
        }
        sheetObj.WaitImageVisible = true;
    } 
  	
	// 멀티콤보 Office Click Event Catch
	function office_OnCheckClick(comboObj, index, code) {
		var formObj = document.form;
		//추가사항.2010.03.15
		if(index==0) {
	    	var bChk = comboObj.CheckIndex(index);
    		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
    			comboObj.CheckIndex(i) = bChk;
	    	}
	    } else {
    		comboObj.CheckIndex(0) = false;
	    }
		
		
		if(formObj.chk_sub_ofc.checked) {
			if(comboObj.CheckIndex(index))
				comboObj.CheckIndex(index) = false;
			else
				comboObj.CheckIndex(index) = true;
	      
			ComShowCodeMessage('DMT00107');
		}
	}
	
	// 멀티콤보 Office_t2 Click Event Catch
	function office_t2_OnCheckClick(comboObj, index, code) {
		var formObj = document.form;
	  
		//추가사항.2010.03.15
		if(index==0) {
	    	var bChk = comboObj.CheckIndex(index);
    		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
    			comboObj.CheckIndex(i) = bChk;
	    	}
	    } else {
    		comboObj.CheckIndex(0) = false;
	    }
		
		if(formObj.chk_sub_ofc_t2.checked) {
			if(comboObj.CheckIndex(index))
				comboObj.CheckIndex(index) = false;
			else
				comboObj.CheckIndex(index) = true;
	      
			ComShowCodeMessage('DMT00107');
		}
	}	
	
	// 멀티콤보 Office Click Event Catch
	function office_t3_OnCheckClick(comboObj, index, code) {
		var formObj = document.form;
		//추가사항.2010.03.15
		if(index==0) {
	    	var bChk = comboObj.CheckIndex(index);
    		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
    			comboObj.CheckIndex(i) = bChk;
	    	}
	    } else {
    		comboObj.CheckIndex(0) = false;
	    }
		
		
		if(formObj.chk_sub_ofc_t3.checked) {
			if(comboObj.CheckIndex(index))
				comboObj.CheckIndex(index) = false;
			else
				comboObj.CheckIndex(index) = true;
	      
			ComShowCodeMessage('DMT00107');
		}
	}
	
  	 
	// 멀티콤보 Office KeyDown Event Catch
	function office_OnKeyDown(comboObj, keycode, shift) {
		var formObj = document.form;
	  
		if(formObj.chk_sub_ofc.checked) {
			ComShowCodeMessage('DMT00107');
		}
	}

	// 멀티콤보 Office_t2 KeyDown Event Catch
	function office_t2_OnKeyDown(comboObj, keycode, shift) {
		var formObj = document.form;
	  
		if(formObj.chk_sub_ofc_t2.checked) {
			ComShowCodeMessage('DMT00107');
		}
	}
	
	// 멀티콤보 Office KeyDown Event Catch
	function office_t3_OnKeyDown(comboObj, keycode, shift) {
		var formObj = document.form;
	  
		if(formObj.chk_sub_ofc_t3.checked) {
			ComShowCodeMessage('DMT00107');
		}
	}	
	
	//멀티콤보 클릭 이벤트 (Tariff Type Tab1)
	function tariff_type_t1_OnCheckClick(comboObj, index, code) {
	    if(index==0) {
	    	var bChk = comboObj.CheckIndex(index);
    		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
    			comboObj.CheckIndex(i) = bChk;
	    	}
	    } else {
    		comboObj.CheckIndex(0) = false;
	    }
	}
	
	//멀티콤보 클릭 이벤트 (Tariff Type Tab3)
	function tariff_type_t3_OnCheckClick(comboObj, index, code) {
		if(index==0) {
			var bChk = comboObj.CheckIndex(index);
			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
				comboObj.CheckIndex(i) = bChk;
			}
		} else {
			comboObj.CheckIndex(0) = false;
		}
	}	
	
	/**
	 * 팝업 호출
	 * @param sheetObj
	 * @param formObj
	 * @param srcName
	 * @return
	 */
	function openPopupWindow(sheetObj, formObj, srcName) {
		
		 if (srcName == "btn_detail") {
 			var invTpCd = sheetObj.CellValue(sheetObj.SelectRow,  "dmdt_inv_tp_cd");
 			if (invTpCd == 'R' || invTpCd == 'T') {
 				//4002
 				var url = "EES_DMT_4002.do"
 					+"?group_by=1"
 					+"&chg_type="
 					+"&ofc_cd="+sheetObj.CellValue(sheetObj.SelectRow,  "ofc_cd") 
 					+"&bkg_no="+sheetObj.CellValue(sheetObj.SelectRow,  "bkg_no")
 					+"&dmdt_trf_cd="+sheetObj.CellValue(sheetObj.SelectRow,  "dmdt_trf_cd") 
 					+"&invoice_no="+sheetObj.CellValue(sheetObj.SelectRow,  "dmdt_inv_no")
 					+"&cntr_no="
 					+"&invoice_issue=2"	
 					;
 				var returnValue = ComOpenWindowCenter(url, "EES_DMT_4002", EES_DMT_4002_WIDTH, EES_DMT_4002_HEIGHT, true);
 			} 
 			else if (invTpCd == 'M') {
 				//4004 
				var url = "EES_DMT_4004P.do"
 					+"?dmdt_inv_no="+sheetObj.CellValue(sheetObj.SelectRow,  "dmdt_inv_no")
 					+"&caller=5001"
 					;
				var returnValue = ComOpenWindowCenter(url, "EES_DMT_4004P", "1020","738", true);
 			}
		 }// End of the "btn_detail" action
	}
	 
	/*
	 * 더블클릭 팝업(4002/4004)
	 */
 	function t1sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
 		
 		openPopupWindow(sheetObj, document.form, "btn_detail");
 	}  	 
 	
	/*
  	 * 각 공통팝업창 호출 함수 
  	 */
  	function openPopup(flag, arg) {
  		
  		var sheetObj = sheetObjects[0];
  		var formObj	= document.form;
  		var sUrl	= '';
  		var sWidth	= '';
  		var sHeight	= '';
  		
  		with(sheetObj) {
	  		switch(flag) {
	  			case 's_invoice_no':		// CNTR No. 멀티입력 팝업 호출
	  			case 's_bkg_no':			// BKG No. 멀티입력 팝업 호출
	  			case 'invoice_no':		// CNTR No. 멀티입력 팝업 호출
	  			case 'bkg_no':			// BKG No. 멀티입력 팝업 호출
		  			var returntitle = '';
	  				if(flag == 'bkg_no' || flag == 's_bkg_no')
	  					returntitle = 'BKG No.';
	  				else if(flag == 'invoice_no' || flag == 's_invoice_no')
	  					returntitle = 'Invoice No.';
	  				
	  				var param = "?returnval=" + flag + "&returntitle=" + returntitle;
	  				ComOpenPopup('EES_DMT_MULTI.do'+param, 400, 380, 'getDmt_Multi', '1,0,1,1,1,1,1,1,1,1,1,1', true);
				break;	  			

	  		} // switch-end
  		} // with-end
  		
  		if (sUrl.indexOf('.do') != -1) {
  			var sWinName = ComReplaceStr(sUrl, '.do', '');
  			ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true);
  		} 
  		else if (sUrl != '') {
	  		ComOpenWindow('http://nis2010.hanjin.com/nis2010/grid/apps/nis2010/' + sUrl,'p'
						,'scrollbars=no,toolbar=no,location=no,resizable=yes,menubar=no, width=' + sWidth + ',height=' + sHeight + ',left=0,top=0');
  		}
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
	/* 개발자 작업  끝 */