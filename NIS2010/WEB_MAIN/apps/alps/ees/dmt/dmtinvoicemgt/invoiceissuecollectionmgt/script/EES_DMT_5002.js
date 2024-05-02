/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_5002.js
*@FileTitle : Invoice Interface to A/R 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.10.09 최성환
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
     * @class EES_DMT_5002 : EES_DMT_5002 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
	function EES_DMT_5002() {
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
	
	var comboObjects = new Array();
	var comboCnt = 0;
	
	var COMMON_TARIFF_CD = "common_tariff_cd";
	var USER_TARIFF_TYPE = "user_tariff_type"; 
	var ROWMARK = "|";
	var FIELDMARK = "=";
	var PERIOD_GAP = 15;
	var USR_TRF_TP;


 	//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

 	//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
 	 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
 	 
		var sheetObject1 = sheetObjects[0];
 	 
 	 /*******************************************************/
		
		var formObj = document.form;
		
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			var srcObj = window.event.srcElement;

			switch(srcName) {
	         	case "btns_calendar": //달력 버튼
		         	if(srcObj.style.cursor == "hand") {
			            var cal = new ComCalendarFromTo();
			            cal.select(formObj.fm_dt,  formObj.to_dt,  'yyyy-MM-dd');
		         	}
					break;
					
	 			case "btn_retrieve":
					doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
					
					var totRowCnt = sheetObject1.RowCount;
	    			if(totRowCnt > 0){
	    				buttonMode("RETRIEVE");
	    			} 
					
					
					break;
					
	 			case "btn_new":
	 				//Form.reset()하고, IBSheet.RemoveAll()처리한다. 
	 				//IBMultiCombo의 경우 id="myCombo"이면 "initComboValue_myCombo()"
	 				ComResetAll();
 					doInit();	// 조회조건 초기화
 					buttonMode("NEW");
 					break;
					
 				case "btn_minimize":
 					var schCondDiv = document.getElementById("sch_cond_div");
 					
 					if(schCondDiv.style.display == 'block') {
 						DmtComShowObject(schCondDiv,  false);
 						sheetObject1.style.height = 350+120;
 					} else {
 						DmtComShowObject(schCondDiv,  true);
 						sheetObject1.style.height = 350;
 					}

 					break;	 	
 					
	 			case "btn_detail":
	 				
	 				var totRowCnt = sheetObject1.RowCount;
	    			if(totRowCnt > 0){
	    				if(ComIsBtnEnable(srcName)) {
							openPopupWindow(sheetObject1, formObj, srcName);
						}
	    			} 
	    			
	 				
	 				break;
	 				
	 			case "btn_downexcel":
	 				sheetObject1.SpeedDown2Excel(-1, false, false, '', '', false, false, '', false); 
	 				
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
 	
		//html컨트롤 이벤트초기화
		initControl();
		
	}
	 
  	/**
 	 * BUTTON MODE
 	 */
 	function buttonMode(mode) {
 		 var formObj = document.form;
 		 with (formObj) {
 			 if(mode == "NEW"){
 				DmtComEnableManyBtns(false, "btn_detail", "btn_downexcel");
 			 }else if(mode == "RETRIEVE"){
 				DmtComEnableManyBtns(true,  "btn_detail", "btn_downexcel");
 			 } 
 		 }
 	}
	 
    /**
     * 인자로 받은 HTML태그(Object)의 obj.style.display 속성을 변경하여 화면에 표시여부를 변경시킨다. <br>
     * 주로 Tab형태 div 태그를 사용할때 이 함수를 사용한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     ComShowObject(txtName,  true);   // 결과 : txtName컨트롤을 show한다.
     *     ComShowObject(txtName,  false);  // 결과 : txtName컨트롤을 hide한다.
     * </pre>
     * @param {object} obj     필수,대상 HTML태그(Object)
     * @param {bool}   bShow   필수,표시여부를 true/false로 설정한다.
     * @return 없음
     * @see #ComShowManyObjects
     */
	function DmtComShowObject(obj, bShow) {
        try {
            if (bShow) {
                obj.style.display = "block";
            } else {
                obj.style.display = "none";
            }
        } catch(err) { ComFuncErrMsg(err.message); }
    }
	
	function initControl() {
        axon_event.addListenerForm  ( 'blur'     , 'obj_blur'      , document.form ); //- 포커스 나갈때
        axon_event.addListenerFormat( 'focus'    , 'obj_focus'     , document.form ); //- 포커스 들어갈때
        axon_event.addListener('keydown', 'ComKeyEnter', 'form');  //jsp name 옆에 id 추가 예)name="btn_retrieve" id="btn_Retrieve"
		axon_event.addListenerFormat('keypress','obj_keypress', document.form); //- 키보드 입력할때
		axon_event.addListener('click', 'condType_click', 'cond_type'); //조회 date or inv radio button
	}

	function condType_click() {
		doEnableCondObj(event.srcElement.value);
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
         if ( ( obj.name == 'fm_dt' || obj.name == 'to_dt' ) && document.form.fm_dt.value != "" && document.form.to_dt.value != "" ) {
             ComChkObjValid(obj);
         } else if(obj.name == 'cust_cd') {
        	 doActionText(sheetObjects[0], document.form, obj, SEARCH20);
         }
	}
     
	function obj_focus() {
		ComClearSeparator(event.srcElement);
		ComSetFocus(event.srcElement);
	}
	
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {

		 var cnt = 0;

		 switch(sheetNo) {
		 	case 1:      // sheet1 init
            	with (sheetObj) {
                    // 높이 설정
                    style.height = 372
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

                    var HeadTitle  = "|Seq.|Payer|Count|Cur.|Billing AMT|TAX AMT|Payable AMT|Payer Name|payerFlg";
                    
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
     				InitColumnInfo(headCount, 0, 0, true);
     				
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,	WIDTH,		DATAALIGN, COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,   	daCenter,   true,       "ibflag");	
					InitDataProperty(0, cnt++ , dtSeq,			45,		daCenter,	true,		"seq");
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"payer_cd",			false,		"",			dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,		70,		daCenter,	true,		"inv_cnt",			false,		"",			dfInteger,		0,		false,		true);
					
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"inv_curr_cd",		false,		"",			dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,		150,	daRight,	true,		"inv_chg_amt",		false,		"",			dfFloat,		2,		false,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,		150,	daRight,	true,		"tax_amt",			false,		"",			dfFloat,		2,		false,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,		150,	daRight,	true,		"inv_amt",			false,		"",			dfFloat,		2,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			0,		daLeft,		true,		"payer_nm",			false,		"",			dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		"payer_flg",			false,		"",			dfNone,			0,		false,		true);
								
					ToolTipOption = "balloon:true;width:50;";
					ToolTipText(0,"inv_cnt") = "Count of Invoices";
 					CountPosition = 2;
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
  	    var formObject = document.form
  		
  	    switch(comboObj.id) {
  	    	case "office": 
	        	with (comboObj) { 
					MultiSelect = false; 
					UseAutoComplete = true;
					SetColAlign("left|left");   
					SetColWidth("60|300");				
					DropHeight = 160;
					ColBackColor(0) = "#CCFFFD";
  					ColBackColor(1) = "#CCFFFD";
					ValidChar(2,0);		//영문 대문자
					IMEMode = 0;
		    	}  	        	  

				break;   	    
  	    	case "tariff_type": 
  	        	with (comboObj) { 
					MultiSelect = true; 
					UseAutoComplete = false;
					SetColAlign("left|left");   
					SetColWidth("50|300");				
					DropHeight = 160;
					ColBackColor(0) = "#CCFFFD";
  					ColBackColor(1) = "#CCFFFD";
					ValidChar(2,0);		//영문 대문자
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
 		      	
     		//Office comboList	
     		case IBSEARCH_ASYNC01:    
 				
 				formObj.f_cmd.value = SEARCHLIST02;
 	    	    var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
 	    	    sComboObj.RemoveAll();
 	    	    if (sXml != undefined && sXml != '') {
 		    	    var ofc_cds = ComGetEtcData(sXml, "OFC_CD");
 		    	    var ofc_nms = ComGetEtcData(sXml, "OFC_NM");
 	
 		    	    var comboCodeArr = ofc_cds.split("|");			    	    
 		    	    var comboTextArr = ofc_nms.split("|");
 		    	    for (var i = 0 ; i < comboTextArr.length ; i++) {
 		    	    	sComboObj.InsertItem(i, comboCodeArr[i] + "|" + comboTextArr[i], comboCodeArr[i]);		
 		         	}
 	    	    }
 	    	    
 	    	    // 로그인 User Office를 Default - 리스트에 없을시 item 추가해서 표시
    	  		var usr_ofc_cd = formObj.usr_ofc_cd.value;
    	  		sComboObj.Code = usr_ofc_cd;
    	  		
    	  		if(sComboObj.Code != usr_ofc_cd) {
    	  			sComboObj.InsertItem(0, usr_ofc_cd, usr_ofc_cd);
    	  			sComboObj.Code = usr_ofc_cd;
    	  		}
 	    	    break;
     		
 	    	//Tariff type comboList
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

         }
 		sheetObj.WaitImageVisible = true;
     }	
 	
    /**
     * 콤보필드에 데이터를 추가해준다.
     */	
 	function addComboItem(comboObj,comboItems) {
 		var comboID = comboObj.id;
 		switch(comboID) {		
 			case "tariff_type":
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
 				
	 		    //ComOpenWait Start
			 	sheetObj.WaitImageVisible=false;
			 	ComOpenWait(true);
 				
			 	formObj.f_cmd.value = SEARCH;
 				sheetObj.DoSearch4Post("EES_DMT_5002GS.do",	FormQueryString(formObj));
 				
 				//ComOpenWait End
				ComOpenWait(false);
				
	 			break;
	
		}
	}

	function sheet1_OnLoadFinish() {   
		var formObject = document.form
		sheetObjects[0].WaitImageVisible = false;   

		//OPEN화면 호출
      	doInit();
      	
      	sheetObjects[0].WaitImageVisible = true;   
	}  
	
	
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
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
//			sheetObj.ShowSubSum("ofc_cd", 		"inv_chg_amt|tax_amt|inv_amt", -1, false, false, 0, "chk=;ofc_cd=%s;seq=S.TTL");
//			sheetObj.ShowSubSum("ar_if_dt", 	"inv_chg_amt|tax_amt|inv_amt", -1, false, false, 0, "chk=;ofc_cd=%s;ar_if_dt=%s;seq=S.TTL");
//			sheetObj.ShowSubSum("inv_curr_cd", 	"inv_chg_amt|tax_amt|inv_amt", -1, false, false, 0, "chk=;ofc_cd=%s;ar_if_dt=%s;inv_curr_cd=%s;seq=S.TTL");
			SumText(0, "seq") = "TTL";
		}
	}
	
	/**
 	 * INIT SETTING
 	 */
	function doInit() {
 		var formObj = document.form;
 		with (formObj) {
	 		//combo reset
			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH_ASYNC01,comboObjects[0]);
			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH_ASYNC02,comboObjects[1]);

			doEnableCondObj("date");
			chk_hold_box.checked = false;
			
			ComClearManyObjects(chk_hold, ofc_cd, dmdt_trf_cd, cust_cd, cust_nm, s_cust_gubun, s_cust_cd);
			
			buttonMode("NEW");
 		}
 	}

 	function doEnableCondObj(condType) {
 		var formObj = document.form;
 		with (formObj) {

 			switch(condType){
 				
 			 	case "date":
 			 		//date
 			 		ComEnableManyObjects(true, fm_dt, to_dt, btns_calendar);
 			 		DmtComSetClassManyObjects('input1', fm_dt, to_dt); 
 			 		
 					// 초기 날짜 값 셋팅 (6달전의 오늘날짜- 오늘날짜)
 			 		var sheetObj = sheetObjects[0];
 			 		var formObj  = document.form;
 					//사용자 Office 의 현재 날짜를 조회한다.
 					var ofcCurrDate = DmtComOfficeCurrDate(sheetObj, formObj); 
 					//조회한 날짜를 화면의 필드에 매핑 시킨다.
 					ComSetObjValue(formObj.fm_dt, 	ComGetDateAdd(ofcCurrDate, "M", -6)); //6개월 이전 날짜.
 					ComSetObjValue(formObj.to_dt,   ofcCurrDate); 
 					
 					//formObj.fm_dt.value = ComGetDateAdd(null, "M", -6); //6개월 이전 날짜.
 					//formObj.to_dt.value = ComGetNowInfo("ymd"); //오늘 날짜.

 			 		//inv
 			 		ComEnableManyObjects(false, bkg_no, bl_no, inv_no, btns_bkg_multisearch, btns_bl_multisearch, btns_inv_multisearch);
 			 		ComClearManyObjects(bkg_no, bl_no, inv_no);		
 			 		DmtComSetClassManyObjects('input2', bkg_no, bl_no, inv_no); 
 		
 			 		break;
 			 	case "inv":
 			 		//date
 			 		ComEnableManyObjects(false, fm_dt, to_dt, btns_calendar);
 			 		DmtComSetClassManyObjects('input2', fm_dt, to_dt); 		
 			 		ComClearManyObjects(fm_dt, to_dt);
 			 					 	
 			 		//inv
 			 		ComEnableManyObjects(true, bkg_no, bl_no, inv_no, btns_bkg_multisearch, btns_bl_multisearch, btns_inv_multisearch);
 			 		ComClearManyObjects(bkg_no, bl_no, inv_no);		
 			 		DmtComSetClassManyObjects('input1', bkg_no, bl_no, inv_no);

 			 		break;
 			}
 			  			
 		} // end of the with (formObj) 
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
				
	  			case 'bkg_no':		// BKG No. 멀티입력 팝업 호출
	  			case 'bl_no':		// B/L No. 멀티입력 팝업 호출
	  			case 'inv_no':		// INV No. 멀티입력 팝업 호출
		  			var returntitle = '';
	  				if(flag == 'bkg_no')
	  					returntitle = 'BKG No.';
	  				else if(flag == 'bl_no')
	  					returntitle = 'B/L No.';
	  				else if(flag == 'inv_no')
	  					returntitle = 'INV No.';
	  				
					var param = "?returnval=" + flag + "&returntitle=" + returntitle;
	  				ComOpenPopup('EES_DMT_MULTI.do'+param, 400, 380, 'getDmt_Multi', '1,0,1,1,1,1,1,1,1,1,1,1', true);
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

	//Customer 체크
	function doActionText(sheetObj, formObj, object, formCmd) {
        sheetObj.ShowDebugMsg = false;
        sheetObj.WaitImageVisible = false;
        var cust_len = parseInt(ComGetLenByByte(ComGetObjValue(formObj.cust_cd)));
//        alert(cust_len);
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
  	 
	/*
	 * 멀티입력 팝업 페이지가 닫힌 후, 호출되는 Opener 함수
	 * - 해당 필드에 멀티 입력값을 설정해준다.
	 */
	function getDmt_Multi(rArray, return_val) {
    	var targObj = eval("document.form." + return_val);
    	var retStr = rArray.toString().toUpperCase();
    	
    	ComSetObjValue(targObj, retStr);
	}  	
  	 
	//멀티콤보 클릭 이벤트
	function tariff_type_OnCheckClick(comboObj, index, code) {
	    if(index==0) {
	    	var bChk = comboObj.CheckIndex(index);
    		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
    			comboObj.CheckIndex(i) = bChk;
	    	}
	    } else {
    		comboObj.CheckIndex(0) = false;
	    }
	}
	
	// caller: ComResetAll호출 후 아래 적용.
   	// IBMultiCombo Office 초기화
   	function initComboValue_office() {
   		comboObjects[0].Enable = true;
   		ComSetObjValue(comboObjects[0], document.form.usr_ofc_cd.value);
   	}
   	// IBMultiCombo Tariff Type 초기화
   	function initComboValue_tariff_type() {
   		document.form.usr_trf_tp.value = USR_TRF_TP;
   		comboObjects[1].Enable = true;
   		ComSetObjValue(comboObjects[1], document.form.usr_trf_tp.value);
   	}
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction)
	{
		 
		 with(formObj){
	     		// office Combo Check
	     		//2010.02.22 OFFICE 코드 없어도 조회 하도록. Code -> Text로 수정함
	     		if(comboObjects[0].Text == '') {  
	     			ComShowCodeMessage('COM12113', "Office CD");
	     			return false;
	     		}
	     		
			 	// Tariff Type Combo Check
	     		if(comboObjects[1].Code == '') {
	     			ComShowCodeMessage('COM12113', "Tariff Type");
	     			return false;
	     		}
	     		
			 	//check 여부.
			 	ComSetObjValue(chk_hold, "");  //재조회를 위해  clear.
	     		if(chk_hold_box.checked){
	     			ComSetObjValue(chk_hold, "Y");
	     		} else {
	     			ComSetObjValue(chk_hold, "N");
	     		}
	     		
	     		var condType = ComGetObjValue(cond_type);
	     		//******************** Date 조건  ************************
	     		if(condType == 'date') {
	     			if(!ComIsDate(fm_dt)) {
	     				ComAlertFocus(fm_dt, ComGetMsg('COM12134', 'Period From Date'));
	     				return false;
	     			}
	     			if(!ComIsDate(to_dt)) {
	     				ComAlertFocus(to_dt, ComGetMsg('COM12134', 'Period To Date'));
	     				return false;
	     			}
	     			
	                if (ComChkPeriod(fm_dt.value, to_dt.value) <= 0){
	        			ComShowCodeMessage('DMT01020');
	        			return false;
	        		} 
	                
	     		     			
	     		//******************** INV 조건  ************************	
	     		} else if(condType == 'inv') {
	     			if(ComIsNull(bkg_no) && ComIsNull(bl_no) && ComIsNull(inv_no)) {
	     				ComShowCodeMessage('DMT00102', 'INV No. or BKG No. or B/L No.');
	         			return false;
	 				}
	     			
	     			var invNo = ComGetObjValue(inv_no);
	     			if (invNo != '') {
	     				var arrInvNo = invNo.split(',');
	     				for (var i=0; i<arrInvNo.length; i++) {
	     					// 인도지역에서 발행한 invoice no 는 12자리, 그 이외는 모두 9자리 입니다.
	     					if (ComChkLen(arrInvNo[i], 9) != 2 && ComChkLen(arrInvNo[i], 12) != 2) {
	     						ComAlertFocus(inv_no, ComGetMsg('COM12175', 'INV No.', '9', '12'));
	                 			return false;
	     					}
	     				}
	     			}
	     			
	     			var bkgNo = ComGetObjValue(bkg_no);
	     			if(bkgNo != '') {
	     				var arrBkgNo = bkgNo.split(',');
	     				for(var i=0; i<arrBkgNo.length; i++) {
	     					if(ComChkLen(arrBkgNo[i], 11) != 2 && ComChkLen(arrBkgNo[i], 12) != 2 && ComChkLen(arrBkgNo[i], 13) != 2) {
	     						ComAlertFocus(bkg_no, ComGetMsg('DMT00119', 'BKG No.', '11~13'));
	                 			return false;
	     					}
	     				}
	     			}
	     			
	     			var blNo = ComGetObjValue(bl_no);
	     			if(blNo != '') {
	     				var arrBlNo = blNo.split(',');
	     				for(var i=0; i<arrBlNo.length; i++) {
	     					if(ComChkLen(arrBlNo[i], 10) != 2 && ComChkLen(arrBlNo[i], 12) != 2) {
	     						ComAlertFocus(bl_no, ComGetMsg('COM12175', 'B/L No.', '10', '12'));
	                 			return false;
	     					}
	     				}
	     			}
	     			

	     		}
	     		    		
	     		//주요 필수 정보 셋팅.
//				ComSetObjValue(ofc_cd, 			comboObjects[0].Code);
				ComSetObjValue(ofc_cd, 			comboObjects[0].Text);
				ComSetObjValue(dmdt_trf_cd, 	comboObjects[1].Code);
				

		} // end of the with clause
		return true;
	}

	/*
	 * 더블클릭 팝업(5003)
	 */
 	function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
		
 		var formObj = document.form;
 		
 		//hold 버튼 권한 여부 / 권한이 있으면 hold 버튼이 보이고 / 그외는 버튼 자체를 숨김
		var holdAuth = "";
		if(holdAuthority(ComGetObjValue(formObj.usr_ofc_cd))){
			holdAuth = "Y";
		} else {
			holdAuth = "N";
		}
			
 		ComSetObjValue(formObj.ofc_cd, 			comboObjects[0].Code);
		ComSetObjValue(formObj.dmdt_trf_cd, 	comboObjects[1].Code);
 		
		var url = "EES_DMT_5003.do"
 			+"?ofc_cd="+ComGetObjValue(formObj.ofc_cd)
 			+"&dmdt_trf_cd="+ComGetObjValue(formObj.dmdt_trf_cd)
 			+"&chk_hold="+ComGetObjValue(formObj.chk_hold)
 			+"&cond_type="+ComGetObjValue(formObj.cond_type)
 			+"&fm_dt="+ComGetObjValue(formObj.fm_dt)
 			+"&to_dt="+ComGetObjValue(formObj.to_dt)
 			+"&inv_no="+ComGetObjValue(formObj.inv_no)
 			+"&bkg_no="+ComGetObjValue(formObj.bkg_no)
 			+"&bl_no="+ComGetObjValue(formObj.bl_no)
 			+"&sh_cust_cd="+sheetObj.CellValue(sheetObj.SelectRow,  "payer_cd")
 			+"&sh_cust_nm="+sheetObj.CellValue(sheetObj.SelectRow,  "payer_nm")
 			+"&sh_inv_curr_cd="+sheetObj.CellValue(sheetObj.SelectRow,  "inv_curr_cd")
 			+"&hold_auth="+holdAuth
 			;

 		var returnValue = ComOpenWindowCenter(url, "EES_DMT_5003", "940","705", true);
 		if(returnValue == "Y") {
 			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 		}
 	}  
	 	 
	/**
	 * EES_DMT_5003 팝업 호출
	 * @param sheetObj
	 * @param formObj
	 * @param srcName
	 * @return
	 */
	function openPopupWindow(sheetObj, formObj, srcName) {
 		 if(srcName == "btn_detail") {
	 		
 			//hold 버튼 권한 여부 / 권한이 있으면 hold 버튼이 보이고 / 그외는 버튼 자체를 숨김
 			var holdAuth = "";
 			if(holdAuthority(ComGetObjValue(formObj.usr_ofc_cd))){
 				holdAuth = "Y";
 			} else {
 				holdAuth = "N";
 			}
 			
	 		ComSetObjValue(formObj.ofc_cd, 			comboObjects[0].Code);
			ComSetObjValue(formObj.dmdt_trf_cd, 	comboObjects[1].Code);
	 		
			var url = "EES_DMT_5003.do"
	 			+"?ofc_cd="+ComGetObjValue(formObj.ofc_cd)
	 			+"&dmdt_trf_cd="+ComGetObjValue(formObj.dmdt_trf_cd)
	 			+"&chk_hold="+ComGetObjValue(formObj.chk_hold)
	 			+"&cond_type="+ComGetObjValue(formObj.cond_type)
	 			+"&fm_dt="+ComGetObjValue(formObj.fm_dt)
	 			+"&to_dt="+ComGetObjValue(formObj.to_dt)
	 			+"&inv_no="+ComGetObjValue(formObj.inv_no)
	 			+"&bkg_no="+ComGetObjValue(formObj.bkg_no)
	 			+"&bl_no="+ComGetObjValue(formObj.bl_no)
	 			+"&sh_cust_cd="+sheetObj.CellValue(sheetObj.SelectRow,  "payer_cd")
	 			+"&sh_cust_nm="+sheetObj.CellValue(sheetObj.SelectRow,  "payer_nm")
	 			+"&sh_inv_curr_cd="+sheetObj.CellValue(sheetObj.SelectRow,  "inv_curr_cd")
	 			+"&hold_auth="+holdAuth
	 			;
//			alert(url);
	 		var returnValue = ComOpenWindowCenter(url, "EES_DMT_5003", "940","705", true);
	 		if(returnValue == "Y") {
	 			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	 		}

 		 }
	} 	 
   /**
	* Hold 권한 대상 - 로그인 오피스코드와 동일할 경우에만 Hold 버튼 활성화 및 처리가능.
	* @param ofcCd
	* @return boolean
	*/ 
	function holdAuthority(ofcCd){
		//권한 대상
		var props   = new Array("SELCON", "NYCRAO", "NYCRA");//SELCON/NYCRAO/NYCRA 
		for(var j=0; j<props.length; j++){
			 if(ofcCd == props[j]){
				 return true;
			 }
		}
//			return true; //테스트 시 사용.
		return false;
	}	 
	/* 개발자 작업  끝 */