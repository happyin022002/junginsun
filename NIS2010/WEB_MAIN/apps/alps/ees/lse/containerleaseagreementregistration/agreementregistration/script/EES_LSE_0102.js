/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EES_LSE_0102.js
*@FileTitle : Interest calculation
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.09
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2011.03.09 박명신
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
	/**
	 *@fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
	 * @author 박명신
	 */

	/**
	 * @extends
	 * @class EES_LSE_0102 : EES_LSE_0102 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ees_lse_0102() {
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
	var sheetObjects = new Array();
	var sheetCnt = 0;

	// Combo Object Array
	var comboObjects = new Array();
	var comboCnt = 0;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {	
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		/*******************************************************/
	
		var formObj = document.form;	
		
		try {
			var srcObj  = window.event.srcElement;
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "btn_Calculation":				
					doActionIBSheet(sheetObject1, formObj, IBSEARCH);
 					break;	
					
				case "btn_New":
					doActionIBSheet(sheetObject1, formObj, IBCREATE);
					break;	
						
				case "btn_DownExcel":	
				     if(sheetObject1.RowCount > 0){
					 	var pageUrl = "./apps/alps/ees/lse/containerleaseagreementregistration/agreementregistration/jsp/EES_LSE_0102_FORM.jsp";
						pageUrl = pageUrl + "?" + FormQueryString(formObj);					
						sheetObject2.DirectDown2Excel(pageUrl, "", -1, true);				
						sheetObject1.SpeedDown2Excel(-1, true);
					 } else {
					 	ComShowCodeMessage("LSE01045");
					 }
					break;			
			} // end switch
		} catch (e) {	
			if ( e == "[object Error]") {
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

	/**
	 * IBMultiCombo Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}
	
	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		/* IBMultiCombo 초기화 */
		for ( var k = 0 ; k < comboObjects.length ; k++ ) {
	        initCombo(comboObjects[k], k + 1);
	    }
		
		/* IBSheet 초기화 */
		for( var i = 0 ; i < sheetObjects.length ; i++ ) {
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );

			initSheet(sheetObjects[i],i + 1);

			//khlee-마지막 환경 설정 함수 추가
 			ComEndConfigSheet(sheetObjects[i]);
 		}
			
		/* Axon Control Setting*/
		initControl();	
		
	}

	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		var sheetid = sheetObj.id;
		
		switch(sheetid){
			case "sheet1" :
				with (sheetObj) {
					// 높이 설정	
                    style.height = 360;
                    	
					// 전체 너비 설정		
                    SheetWidth = mainTable.clientWidth;
                    
					//Host정보 설정[필수][HostIp, Port, PagePath
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                   
				   //전체Merge 종류 [선택, Default msNone]
				    MergeSheet = msHeaderOnly;
                    
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;	
								
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]		
					InitRowInfo( 1, 1, 10, 100);	
								 	
					var HeadTitle1 = "|Number Of Payment|Principal Balance|Principal|Interest|Installation";
					var headCount = ComCountHeadTitle(HeadTitle1);
                			   
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]				
                    InitColumnInfo(headCount, 0, 0, true);					
                   	
				    //해더에서 처리할 수 있는 각종 기능을 설정한다
				    InitHeadMode(true, true, true, true, false,false);
                	    	
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);	

                    //  dtComboEdit [ROW, COL,  DATATYPE,         WIDTH,  DATAALIGN, 		COLMERGE, 	SAVENAME,  KEYFIELD,CALCULOGIC,DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,   40,	    daCenter,	   	true,	    "ibflag");
					InitDataProperty(0, cnt++ , dtData,		  	  180,		daCenter,	   	true,	    "seq",			false,	"",		dfNone,	    	0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			  180,		daRight,	   	true,	    "bal",			false,	"",		dfFloat,	    2,			false,		false);
					InitDataProperty(0, cnt++ , dtAutoSum,		  180,		daRight,	   	true,	    "principal",	false,	"",		dfFloat,	    2,			false,		false);					
					InitDataProperty(0, cnt++ , dtAutoSum,		  180,		daRight,	   	true,	    "interest",		false,	"",		dfFloat,	  	2,			false,		false);
					InitDataProperty(0, cnt++ , dtAutoSum,		  180,		daRight,	   	true,	    "installment",	false,	"",		dfFloat,	    2,			false,		false);
																																	
					//SELECT 로우 배경색       
					SelectionMode   = smSelectionRow;    
					SelectHighLight = true; 		           
					SelectFontBold  = false; 	         
					SelectBackColor = LSE_SELECT_BACK_COLOR;
									
					CountPosition = 0;
 				}
 				break;
			case "sheet2" :
				with (sheetObj) {
					// 높이 설정	
                    style.height = 0;
                    	
					// 전체 너비 설정	
                    SheetWidth = mainTable.clientWidth;
                    
					//Host정보 설정[필수][HostIp, Port, PagePath
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
       					           
					//전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;
								    
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;		
								
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 3, 11);	 			  
										                			   
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(6, 0, 0, true); 	 
					
                    var HeadTitle = "상태"; 
                  
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false, true); 
					
					var title1 = 90;
                    var title2 = 90	
                    var content1 = 100;	
                    var content2 = 100; 
                    var content3 = 100; 
					
                    //1
                    var drCnt = 0;

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(drCnt, cnt++ , dtHiddenStatus,30,    daCenter,  true,    "Status");
                    InitDataProperty(drCnt, cnt++ , dtData,    title1,      daCenter,  false,    "",  false,     "",      dfNone,        0,          false,        false);
                    InitDataProperty(drCnt, cnt++ , dtData,    content1,    daRight,  false,    "principal",  false,     "",      dfNone,        0,          false,        false);
                    InitDataProperty(drCnt, cnt++ , dtData,    title2,      daCenter,  false,    "",  false,     "",      dfNone,        0,          false,        false);
                    InitDataProperty(drCnt, cnt++ , dtData,    content2,    daRight,  false,    "quantity",  false,     "",      dfNone,        0,          false,        false);
                    InitDataProperty(drCnt, cnt++ , dtData,    content3,    daRight,  false,    "temp1",  false,     "",      dfNone,        0,          false,        false);
					
                    //2
                    drCnt++;
                    cnt = 0;

					InitDataProperty(drCnt, cnt++ , dtHiddenStatus,30,    daCenter,  true,    "Status");
                    InitDataProperty(drCnt, cnt++ , dtData,    title1,      daCenter,  false,    "",  false,     "",      dfNone,        0,          false,        false);
                    InitDataProperty(drCnt, cnt++ , dtData,    content1,    daRight,  false,    "i_rate",  false,     "",      dfNone,        0,          false,        false);
                    InitDataProperty(drCnt, cnt++ , dtData,    title2,      daCenter,  false,    "",  false,     "",      dfNone,        0,          false,        false);
                    InitDataProperty(drCnt, cnt++ , dtData,    content2,    daRight,  false,    "u_price",  false,     "",      dfNone,        0,          false,        false);
                    InitDataProperty(drCnt, cnt++ , dtData,    content3,    daRight,  false,    "temp2",  false,     "",      dfNone,        0,          false,        false);
					
                    //3
                    drCnt++;
                    cnt = 0;
						
                    InitDataProperty(drCnt, cnt++ , dtHiddenStatus,30,    daCenter,  true,    "Status");
                    InitDataProperty(drCnt, cnt++ , dtData,    title1,      daCenter,  false,    "",  false,     "",      dfNone,        0,          false,        false);
                    InitDataProperty(drCnt, cnt++ , dtData,    content1,    daRight,  false,    "n_payment",  false,     "",      dfNone,        0,          false,        false);
                    InitDataProperty(drCnt, cnt++ , dtData,    title2,      daCenter,  false,    "",  false,     "",      dfNone,        0,          false,        false);
                    InitDataProperty(drCnt, cnt++ , dtData,    content2,    daRight,  false,    "pmt",  false,     "",      dfNone,        0,          false,        false);
                    InitDataProperty(drCnt, cnt++ , dtData,    content3,    daRight,  false,    "pmt_diem",  false,     "",      dfNone,        0,          false,        false);
                  		  
					CountPosition = 0;  
                    DataRowHeight = 10; 
                    SelectFontBold = false;
                    ScrollBar  = 0;
					SelectHighLight = false;
 				}
 				break;	
		}
 	}

	/**
	 * 콤보 초기설정값, 헤더 정의
	 * param : comboObj ==> 콤보오브젝트, sheetNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initCombo(comboObj, comboNo) {
	    switch(comboObj.id) {	
			//콤보가 없어서 일단 지움
	    }
	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		switch(sAction) {
			case IBCREATE:
				sheetObj.WaitImageVisible = false;
				formObj.reset();			
				formObj.n_payment.value = parseFloat(parseFloat(ComGetObjValue(formObj.contract_period)) * parseFloat(ComGetObjValue(formObj.payment_term))).toFixed(0);  
				formObj.n_payment.value = ComAddComma2(formObj.n_payment.value, "#,###");	  		
				sheetObj.RemoveAll();	 	
		        sheetObj.WaitImageVisible = true;
	            break;	

			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
					if ( sheetObj.id == "sheet1") {
						ComSetObjValue(formObj.f_cmd, SEARCH);
						
						sheetObj.WaitImageVisible = false;
						ComOpenWait(true);	
						sheetObj.Redraw = false;	
						sheetObj.DoSearch4Post("EES_LSE_0102GS.do", FormQueryString(formObj));
						sheetObj.Redraw = true;	
						ComOpenWait(false);	
						sheetObj.WaitImageVisible = true;
					}
				}
				break;
		}
	}	
	
	function sheet1_OnLoadFinish(sheetObj) {
		var formObj = document.form;		
		/* IBMulti Combo Item Setting */	
		doActionIBSheet(sheetObj, formObj, IBCREATE);
	}
	

	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		var formObj = document.form;	
		if ( ErrMsg == "" ) {		
			if(sheetObj.RowCount > 0){	
				var insVal = Math.round(sheetObj.CellValue(1,"installment")) * -1;		
				ComSetObjValue(formObj.pmt,insVal);		 	
				formObj.pmt.value = ComAddComma2(formObj.pmt.value, "#,###.00");  
						
				var pmtDive = 0;	
				if(formObj.payment_term[0].checked){
					pmtDive = 91;		
				} else {
					pmtDive = 30;	
				}					
				var pmtDiem = parseFloat(-1 * parseFloat(insVal) / parseFloat(ComGetObjValue(formObj.quantity)) / pmtDive).toFixed(2);
				
				ComSetObjValue(formObj.pmt_diem,pmtDiem);								
				formObj.pmt_diem.value = ComAddComma2(formObj.pmt_diem.value, "#,###.00");		
			}	
		}		
	}
	
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */	
	function validateForm(sheetObj, formObj, sAction) {
    	switch(sAction) {	
    		case IBSEARCH:      //조회
    		if ( formObj.i_rate.value == "" ) {
				ComShowCodeMessage("LSE01156",'Interest Rates');
				ComSetFocus(formObj.i_rate);
				return false;
				break;
			}
			if ( formObj.u_price.value == "" ) {
				ComShowCodeMessage("LSE01156",'Unit Price');
				ComSetFocus(formObj.u_price);
				return false;
				break;
			}
			if ( formObj.quantity.value == "" ) {
				ComShowCodeMessage("LSE01156",'Quantity');
				ComSetFocus(formObj.quantity);
				return false;
				break;
			}
		}		

		return true;
	}	
			
	// Axon 이벤트 처리
  	// 1. 이벤트catch
    function initControl() {        
	    //Axon 이벤트 처리1. 이벤트catch  
		var formObject = document.form;       
	    axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject); 			//- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	    axon_event.addListenerFormat('focus',    'obj_activate',    formObject);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListenerFormat('change',	 'obj_change',		formObject); 			//- 변경될때.
		axon_event.addListenerForm('keydown',	 'obj_keydown',		formObject); //- 키 눌렸을때
		axon_event.addListenerForm('click',		 'obj_click',	formObject); //- 클릭하였을 때
	}   	
					
	//Axon 이벤트 처리2. 이벤트처리함수   
	function obj_deactivate(){	      
	    ComChkObjValid(event.srcElement); 
	} 
	
	function obj_activate(){		   
	    ComClearSeparator(event.srcElement);
	}       
	
	/**
	 * OnChange Event 처리
	 */
	function obj_change(){	
		var obj      = event.srcElement;
		var formObj  = document.form;
		if ( ComTrim(obj.value) != "" ) {
			switch(obj.name) {			
				     	
	    		case "contract_period":
					formObj.n_payment.value = parseInt(parseInt(ComGetObjValue(formObj.contract_period)) * parseInt(ComGetObjValue(formObj.payment_term))).toFixed(0);  
					formObj.n_payment.value = ComAddComma2(formObj.n_payment.value, "#,###");
				   	break;	
							
				case "quantity":			
					if(ComGetObjValue(formObj.quantity) != "" && ComGetObjValue(formObj.u_price) != ""){
						formObj.principal.value = parseFloat(parseInt(ComTrimAll(ComGetObjValue(formObj.quantity),","))  * parseFloat(ComTrimAll(ComGetObjValue(formObj.u_price),","))).toFixed(2); 
						formObj.principal.value = ComAddComma2(formObj.principal.value, "#,###.00");
					}	
				   	break;		
								
				case "u_price":
					if(ComGetObjValue(formObj.quantity) != "" && ComGetObjValue(formObj.u_price) != ""){
						formObj.principal.value = parseFloat(parseInt(ComTrimAll(ComGetObjValue(formObj.quantity),","))  * parseFloat(ComTrimAll(ComGetObjValue(formObj.u_price),","))).toFixed(2);  
						formObj.principal.value = ComAddComma2(formObj.principal.value, "#,###.00");
					}			
				   	break;		
			}
	    }
	}

	/**
	 * Key-Press Event 처리
	 */
  	function obj_keypress() {
		var obj = event.srcElement;

		switch(obj.dataformat) {
	        case "ymd":
	        case "ym":
	        case "hms":
	        case "hm":
	        case "int":
	            ComKeyOnlyNumber(obj);
	            break;
	        case "float":
	            ComKeyOnlyNumber(obj, "-.");
	            break;
	        case "double":
	            ComKeyOnlyNumber(obj, "-.");
	            break;
	        case "eng":
	            ComKeyOnlyAlphabet();
	            break;
	        case "engup":	
	            ComKeyOnlyAlphabet('upper');
	            break;
	        case "engdn":
	            ComKeyOnlyAlphabet('lower');
	            break;
	        default:
	            ComKeyOnlyNumber(obj);
	        	break;
	    }
  	}

			
   	/**
	 * Key-Down Event 처리
	 */	
   	function obj_keydown() {
   		var obj      = event.srcElement;
   		var vKeyCode = event.keyCode;	
   		var formObj  = document.form;
				
   		if ( vKeyCode == 13 ) {
   			obj_change(obj);
   			ComKeyEnter("lengthnextfocus");
   			if (obj.name =="u_price"){
   				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH); 
   			}
   		}
   	}
	
	/**
     * Click Event 처리
     */
   	function obj_click() {
   		var obj      = event.srcElement;
  		var vKeyCode = event.keyCode;
  		var formObj  = document.form;

  		switch (obj.name) {
  			case "payment_term":
  				if(obj.value != "") {
					formObj.n_payment.value = parseFloat(parseFloat(ComGetObjValue(formObj.contract_period)) * parseFloat(ComGetObjValue(formObj.payment_term))).toFixed(0);  
					formObj.n_payment.value = ComAddComma2(formObj.n_payment.value, "#,###");		
  				}
  				break;
  		}
   	}
  	// 2. 이벤트처리함수 -- End
	/* 개발자 작업  끝 */