/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_3006.js
*@FileTitle : Charge Inquiry by CNTR
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.07.13 황효근
* 1.0 Creation
*---------------------------------------------------------
* History
* 2010.10.26 황효근 [CHM-201006671-01] [EES-DMT] T/S Demurrage Free Time 변경(FM_MVMT_DT 전송 파라미터 추가)
* 2010.11.01 황효근 [] [EES-DMT] T/S Demurrage Free Time 재조정(FM_MVMT_YD_CD 전송 파라미터 추가)
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
     * @class EES_DMT_3006 : EES_DMT_3006 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_3006() {
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
	// User별 Tariff Type Set-Up 정보
	var USR_TRF_TP;
	
	// Action이 포함된 기능버튼 구분을 위한 변수 정의
	var IBPRECAL	= 99;
	var IBWEBCANCEL = 98;
	var IBCONFIRM	= 97;
	var IBDELCANCEL = 96;
	var IBDRCANCEL	= 95;
	var IBDRSAVE	= 94;
	

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObj1 = sheetObjects[0];
		/*******************************************************/
		var formObj = document.form;

		try {
			var srcObj = window.event.srcElement;
     		var srcName = srcObj.getAttribute("name");
         		
			// 그리드 하단 버튼 클릭시  비활성화 상태이면 그냥 return
			if(!ComIsBtnEnable(srcName)) return;

             switch(srcName) {
             	case "btn_PreCal":
             		doActionIBSheet(sheetObj1,formObj,IBPRECAL);
					break;
					
             	case "btn_WebCancel":
             		doActionIBSheet(sheetObj1,formObj,IBWEBCANCEL);
					break;

             	case "btn_Retrieve":
             		ComSetObjValue(formObj.est_mk, "");
					doActionIBSheet(sheetObj1,formObj,IBSEARCH);
					break;

				case "btn_New":
					ComResetAll();
					initBtns();
					ComSetDisplay('tbl_webmty', false);
					break;
					
				case "btn_Save":
 					doActionIBSheet(sheetObj1,formObj,IBSAVE);
 					break;
				
 				case "btn_Confirm":
 					doActionIBSheet(sheetObj1,formObj,IBCONFIRM);
 					break;
 					
 				case "btn_DELCancel":
 					doActionIBSheet(sheetObj1,formObj,IBDELCANCEL);
 					break;
 				
 				case "btn_DRCancel":
 					doActionIBSheet(sheetObj1,formObj,IBDRCANCEL);
 					break;
 					
 				case "btn_Close":
 					//window.returnValue = "Y";
					window.close();
					break;
 					
 				case "btns_calendar1": //달력 버튼
             		if(srcObj.style.cursor == "hand") {
						var cal = new ComCalendar();
						cal.select(formObj.fm_mvmt_dt, 'yyyy-MM-dd');
             		}
					break;
		         
		        case "btns_calendar2": //달력 버튼
		        	if(srcObj.style.cursor == "hand") {
		                var cal = new ComCalendar();
		                cal.select(formObj.to_mvmt_dt, 'yyyy-MM-dd');
		        	}
	                break;
 					
 				//---- 팝업 처리 ------
 				case "btn_Demand":
				case "btn_Billing":
				case "btn_OFCTrans":
				case "btn_Delete":
				case 'btn_Partial':
				case 'btn_CalcDetail':
				case 'btn_CorrHistory':
				case 'btn_OTHistory':
				case 'btn_ROInfo':
				case 'btn_MVMTInq':
				case 'btn_ExceptionInq':
 				//default:
 					doProcessPopup(srcName);
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
		 
		 // 팝업으로 호출시에 타이틀 표시 처리
    	 if(ComGetObjValue(document.form.call_flag) == "P") {
        	 var spanObj = document.getElementById("title2");
        	 spanObj.innerText = " Charge Inquiry by CNTR";
        	 ComSetDisplay('btnCloseLayer', true);
    	 } 
		 
		 
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
	}
	
	 
	// 페이지에 Object 태그를 사용하여 IBSheet의 인스턴스를 생성완료 하면 Event가 발생한다.
   	function sheet1_OnLoadFinish() {
		var formObj = document.form;
 		var sheetObj = sheetObjects[0];
 		sheetObj.WaitImageVisible = false;
		
 		doActionIBCombo(sheetObj, formObj, comboObjects[0], SEARCHLIST);
 		
 		initComboValue_tariff_type();
		initBtns();
		
		/*********************************************
         * 팝업으로 호출시 처리 (Retrieve 실행)
         **********************************************/
		if(ComGetObjValue(formObj.call_flag) == "P") {
			var chg_type = (ComGetObjValue(formObj.chg_seq) == "1") ? "G" : "B";
			ComSetObjValue(formObj.chg_type, chg_type);
			
			// 검색조건 항목 비활성화
			ComEnableManyObjects(false, formObj.cntr_no, formObj.chg_type);
			
			
			var opener = window.dialogArguments;
			var opnSheetObj = opener.sheetObjects[0];
			
			if(opnSheetObj.CellValue(opnSheetObj.SelectRow, "to_mvmt_sts_cd") == 'PC') {
				// PreCal 정보 조회
				ComSetObjValue(formObj.est_mk, "P");
			}
			
			// Retrieve 실행
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
		}
 		
        sheetObj.WaitImageVisible = true; 
   	}
	 
	
	/**
	  * 화면 초기화
	  */
	function initBtns() {
		// 버튼 활성화 상태 초기화
		DmtComEnableManyBtns(false, 'btn_CalcDetail','btn_CorrHistory', 'btn_OTHistory', 'btn_ROInfo', 'btn_MVMTInq');
		
		document.getElementById("btn_ROInfo").style.color = "";
	}
	
	
	function initControl() {
		axon_event.addListenerFormat('blur',	'obj_blur',		form);		//- 포커스 나갈때
		axon_event.addListenerFormat('keypress','obj_keypress', form);		//- 키보드 입력할때
		axon_event.addListener('focus',		'obj_focus',		'cntr_no'); //- 포커스 들어갈때
		axon_event.addListener('keydown',	'ComKeyEnter',		'form');
		axon_event.addListener('mouseover',	'obj_mouseover',	'td_ch', 'rlse_dt');
		axon_event.addListener('mouseout',	'obj_mouseout',		'td_ch', 'rlse_dt');
	}
	
	
	// onMouseover 이벤트  (버튼 말풍선  보여줌)
    function obj_mouseover() {
    	var msg = '';

    	switch(event.srcElement.id){
     		case 'td_ch':
     		case 'ch':
     			msg = "Carrier's Haulage";
     			break;
     			
     		case "rlse_dt":
     			msg = "Cargo Release Date";
     			break;
    	}
    		
    	var bak = 'lightyellow';
   	 	var content =	"<TABLE BORDER=0 CELLPADDING=1 CELLSPACING=0 BGCOLOR=#000000><TR><TD><TABLE WIDTH=100% BORDER=0 CELLPADDING=2 CELLSPACING=0 BGCOLOR="+bak
   	 				+"><TR><TD style=font-family:tahoma;font-size:9pt;>"+msg+"</TD></TR></TABLE></TD></TR></TABLE>"; 
   	 	var x = event.x+document.body.scrollLeft;
		var y = event.y+document.body.scrollTop;
		var skn = document.all("topdeck").style;
		skn.left = x-10;
		skn.top  = y+10;
		document.all("topdeck").innerHTML = content;
		skn.visibility = 'visible';
    }
    
    // onMouseout 이벤트  (버튼 말풍선 숨김)
	function obj_mouseout() {
		var skn = document.all("topdeck").style;
		skn.visibility = 'hidden';
	}
    
	
	
	//포커스가 나갈 때
	function obj_blur(){
		//입력Validation 확인하기 + 마스크구분자 넣기
		var obj = event.srcElement;
		ComChkObjValid(obj);
	}
    
    /**
     * HTML Control Foucs in
     */
	function obj_focus(){
		var obj = event.srcElement;
		ComClearSeparator(obj);
         
		//글자가 있는 경우 블럭으로 선택할수 있도록 한다.
		if (obj.getAttribute("isContentEditable") && obj.getAttribute("value") != null && obj.value.length >=1 ) obj.select();
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
	
	
 	// IBMultiCombo Tariff Type 초기화
  	function initComboValue_tariff_type() {
 		var formObj = document.form;
  		
   		if(ComGetObjValue(formObj.call_flag)=='M') {
   			// 'M'emu를 통해서 호출
   			comboObjects[0].Enable = true;
   			comboObjects[0].Code = USR_TRF_TP;
   			ComSetObjValue(formObj.usr_trf_tp, USR_TRF_TP);
   		} else {
   			// 'P'opup으로 호출
   			comboObjects[0].Enable = false;
   			comboObjects[0].Code = ComGetObjValue(formObj.dmdt_trf_cd);
   		}
  	}
	

	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {

		var cnt = 0;
		switch(sheetNo) {
			case 1:	// sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 100;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 7, 100);

					var HeadTitle1 = "|Over Day|Over Day|Rate per Day|Over Day|Cur.|Charge AMT";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	false,	"hidStatus");
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	false,	"rt_over",	false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	false,	"rt_under",	false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			120,	daRight,	false,	"rt_rate",	false,	"",	dfNullFloat,2,	true,	true);
					InitDataProperty(0, cnt++ , dtAutoSum,		120,	daCenter,	false,	"rt_day",	false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,	"rt_cur_cd",false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	false,	"rt_chrg",	false,	"",	dfNullFloat,2,	true,	true);

					CountPosition = 0;
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
	    var formObj = document.form;
	    switch(comboObj.id) {  
	    	case "tariff_type":
	    		with (comboObj) { 
					MultiSelect = false;
					UseAutoComplete = true;
					SetColAlign("left|left");        
					SetColWidth("45|300");
					DropHeight = 160;
					ColBackColor(0) = "#CCFFFD";
  					ColBackColor(1) = "#CCFFFD";
		    	}
				break;
			
	    	case "to_mvmt_sts":
				with (comboObj) { 
    				MultiSelect = false;
					SetColAlign("left");
					SetColWidth("60");
					DropHeight = 170;
					ColBackColor(0) = "#CCFFFD";
   		    	}
				addComboItem(comboObj, 'DMIF');
   	    		break;
	    } // switch end
	}
	
	

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
	    sheetObj.ShowDebugMsg = false;
	    
	    switch(sAction) {
	        case IBSEARCH:		// 조회
	        	if(!validateForm(sheetObj,formObj,sAction)) return;
	        	
		        sheetObj.WaitImageVisible=false;
		    	ComOpenWait(true);
		    	
	        	formObj.f_cmd.value = SEARCH;
	        	sheetObj.DoSearch("EES_DMT_3006GS.do", FormQueryString(formObj));
	        	
	        	formObj.bil_cur.value = formObj.bzc_trf_curr_cd.value;
	        	formObj.expt_cost_cur.value = "USD" ;
	        	
	        	break;
	    }
	}
	
	/**
	 * Tariff Type 코드와 Description 정보를 IBSheet를 통해 가져온다.
	 * @param sheetObj
	 * @param formObj
	 * @param comboObj
	 * @param formCmd
	 * @return
	 */
	function doActionIBCombo(sheetObj, formObj, comboObj, formCmd) {
		sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;
   	 
		formObj.f_cmd.value = formCmd;
		var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
   	 
		switch(comboObj.id) {
	        case "tariff_type":
		 		// Tariff type comboList
				var data = ComGetEtcData(sXml, COMMON_TARIFF_CD);
				if (data != undefined && data != '') {
					var comboItems = data.split(ROWMARK);
					addComboItem(comboObj,comboItems);
				}
				
				// User별 Tariff Type Set-Up 값 조회
 				var data2 = ComGetEtcData(sXml, USER_TARIFF_TYPE);
 				
 				// User별 Tariff Type Set-Up 값이 없을 경우 Default값으로 세팅.
 				if(data2 == '')
 					data2 = 'DMIF';
 				else {
 					// Tariff Type Set-Up값이 여러 건일 경우 첫번째 Tariff Type으로 설정
 					data2 = data2.split(',')[0];
 				}
 				
 				// Tariff Type IBMultiCombo 초기값 설정
 				comboObj.Code = data2;
 				
 				// IBMultiCombo Tariff Type 초기화 함수(initComboValue_tariff_type())에서 사용하기 위해 전역변수(USR_TRF_TP)에 세팅
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
 		switch(comboObj.id) {
 			case "tariff_type":
		  		for (var i = 0 ; i < comboItems.length ; i++) {
		  	   		var comboItem = comboItems[i].split(FIELDMARK);
		  				comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[0]);
		  	   	}
		  		break;
		  		
 			case "to_mvmt_sts":
		  		switch(comboItems) {
		 			case "DTOC":
						comboObj.InsertItem(0, "", "");
		 				comboObj.InsertItem(1, "OC", "OC");
		 				comboObj.InsertItem(2, "DR", "DR");
						break;
		 			case "CTOC":
						comboObj.InsertItem(0, "", "");
		 				comboObj.InsertItem(1, "VL", "VL");
		 				comboObj.InsertItem(2, "DR", "DR");
						break;
		 			case "DMOF":
						comboObj.InsertItem(0, "", "");
		 				comboObj.InsertItem(1, "VL", "VL");
		 				comboObj.InsertItem(2, "EN", "EN");
		 				comboObj.InsertItem(3, "TN", "TN");
		 				comboObj.InsertItem(4, "DR", "DR");
						break;
		 			case "DMIF":
		 				comboObj.InsertItem(1, "ID", "ID");
		 				comboObj.InsertItem(1, "ID", "ID");
						comboObj.InsertItem(0, "", "");
		 				comboObj.InsertItem(1, "ID", "ID");
		 				comboObj.InsertItem(2, "EN", "EN");
		 				comboObj.InsertItem(3, "TN", "TN");
		 				comboObj.InsertItem(4, "DR", "DR");
		 				comboObj.InsertItem(5, "XX", "XX");
						break;
		 			case "DTIC":
		 			case "CTIC":
						comboObj.InsertItem(0, "", "");
		 				comboObj.InsertItem(1, "MT", "MT");
		 				comboObj.InsertItem(2, "DR", "DR");
		 				comboObj.InsertItem(3, "CS", "CS");
		 				comboObj.InsertItem(4, "XX", "XX");
						break;
		  		}
		  		break;	
 		}
 	}
 	
 	// Tariff Type IBCombo OnChagne 이벤트 발생시 처리
 	function tariff_type_OnChange(comboObj, value, text) {
 		/*
 		var toMvmtStsCombo = comboObjects[1];
 		toMvmtStsCombo.RemoveAll();
 		addComboItem(toMvmtStsCombo, value);
 		*/
 	}
 	
 	
    /**
  	 * IBSheet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
  	 */
	function sheet1_OnSearchEnd(sheetObj,ErrMsg) {

  		ComOpenWait(false);
  		
		if(ErrMsg != '') return;
		
		var formObj = document.form;
		with(formObj) {
  			var cntrNo = ComGetObjValue(cntr_no);
        	
        	// Sheet에 존재하는 EtcData의 값을 Form 객체에 채운다.
        	ComEtcDataToForm(formObj, sheetObj);
        	
        	// 'Dual Type Exception' Checkbox 표시
        	if(ComGetObjValue(dul_tp_expt_flg) == 'Y')
        		dul_tp_expt_chk.checked = true;
        	else
        		dul_tp_expt_chk.checked = false;
  			
  			// 'Unclaimed Cargo' Checkbox 표시
        	if(ComGetObjValue(uclm_flg) == 'Y')
        		uclm_chk.checked = true;
        	else
        		uclm_chk.checked = false;
        	
        	var retCntrNo = ComGetObjValue(cntr_no);
        	var bilAmt = '0';
        	var aftExptDcAmt = '0';
        	
        	if(retCntrNo == '') {
        		// 조회 데이터 없음
        		ComSetObjValue(cntr_no, cntrNo);
        		//ComClearManyObjects(dmdt_chg_sts_desc, xcld_sat_flg, xcld_sun_flg, xcld_hol_flg, total_amt, aft_expt_dc_amt, bil_amt);
        		ComClearManyObjects(dmdt_chg_sts_desc, total_amt, aft_expt_dc_amt, bil_amt);
        		
        		ComSetDisplay('tbl_webmty', false);
        		DmtComEnableManyBtns(false, 'btn_CalcDetail','btn_CorrHistory', 'btn_OTHistory', 'btn_ROInfo', 'btn_MVMTInq');
        		document.getElementById("btn_ROInfo").style.color = "";
        		
        	} else {
        		// 그리드의 조회결과가 없을시에도 DoSave 나  DoAllSave 실행하기 위해.
        		// Web이 "Y" 인 경우(web_ind_flg = 'Y') 일 때만, Web M'ty / Grace End 필드를 보여준다. 
        		if(ComGetObjValue(web_ind_flg) == 'Y') {
        			ComSetDisplay('tbl_webmty', true);
        		} else {
        			ComSetDisplay('tbl_webmty', false);
        		}
        		
        		// 조회 데이터 존재
        		var chgStsCd = ComGetObjValue(dmdt_chg_sts_cd);
        		
        		// Billable AMT
        		bilAmt = ComGetObjValue(bil_amt);
        		
        		// Charge AMT TOTAL
        		var totalAmt = sheetObj.CellValue(sheetObj.LastRow, "rt_chrg");
        		var xchRt = parseFloat(ComGetObjValue(xch_rt));
        		
        		if(totalAmt == '') totalAmt = '0';
        		
        		if(xchRt != 1) {
        			totalAmt = parseFloat(totalAmt) * xchRt;
        			totalAmt = DMTtrimCurrencyAmount(ComGetObjValue(bzc_trf_curr_cd), totalAmt);
        		}
        		
        		// Total AMT
        		total_amt.value = ComAddComma2(totalAmt+'', "#,###.00");
        		
        		// D/C by AMT or %
        		aftExptDcAmt = parseFloat(totalAmt - bilAmt).toFixed(2);
        		
        		/*
        		var xcldFlgs = ComGetObjValue(xcld_flgs);
        		var arrXcldFlgs = xcldFlgs.split('|');
        		for(var i=0; i<3; i++) {
        			if(arrXcldFlgs[i] == 'N') arrXcldFlgs[i] = "";
        		}*/
        		
        		// xcld_sat_flg(Y/N) | xcld_sun_flg(Y/N) | xcld_hol_flg(Y/N) 형태로 받아옴  --> 예) Y|Y|Y, N|N|N
        		// 'Y' 값이면  체크박스 체크시킴
        		//ComSetObjValue(xcld_sat_flg, arrXcldFlgs[0]);
        		//ComSetObjValue(xcld_sun_flg, arrXcldFlgs[1]);
        		//ComSetObjValue(xcld_hol_flg, arrXcldFlgs[2]);
        		
        		
        		// 데이터 조회 후, Charge Status에 따른 버튼 활성화 상태 설정
        		DmtComEnableManyBtns(true, 'btn_CalcDetail','btn_CorrHistory', 'btn_OTHistory', 'btn_ROInfo', 'btn_MVMTInq');
        		
        		// D/C by AMT or % 필드값 설정
	        	aft_expt_dc_amt.value = ComAddComma2(aftExptDcAmt+'', "#,###.00");	
	        	// Billable AMT 필드값 설정
	        	bil_amt.value = ComAddComma2(bilAmt+'', "#,###.00");
	        	
	        	if( ComGetObjValue(roll_ovr) == 'S')
			  		document.getElementById("btn_ROInfo").style.color = 'red';
	        	else
	        		document.getElementById("btn_ROInfo").style.color = '';

        	} // if else - end
        	
        	
        	var awkGauge = "";
        	var bkgCgoTp = ComGetObjValue(dmdt_bkg_cgo_tp_cd);
        	
        	// Cargo Type이 'AWK' 인 경우, Awkward In/Out-Gauge 정보 표시 (예: AWK - In Gauge)
        	if(bkgCgoTp == 'AWK') {
        		awkGauge = ComGetObjValue(awk_gauge);
        		if(awkGauge == 'I')
        			awkGauge = "In";
        		else
        			awkGauge = "Out";
        		
        		awkGauge = " - " + awkGauge + " Gauge";
        	}
        	
        	ComSetObjValue(dmdt_bkg_cgo_tp_cd, bkgCgoTp + awkGauge);
    	
		} // with(formObj) - end
        	
	}
        
	
	/**
     * 저장후 처리
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg){
    	 
    	 ComOpenWait(false);
    	 
		 if(ErrMsg != '') {	// 저장 오류 발생
			 //ComShowCodeMessage('COM12151', "Tariff Type");
		 } else {
			var formObj = document.form;
			var fCmd = formObj.f_cmd.value;
			
			if(fCmd == MULTI) {	// Confirm
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
				
				/*var chkRows = sheetObj.FindCheckedRow("chk").split("|");
				for(var i=0; i < chkRows.length-1; i++) {
					sheetObj.CellValue(chkRows[i], "dmdt_chg_sts_cd") = 'C';
				}
				//전체 UnCheck --> sheetObj.RowStatus(i)가  모두  'R' 로  바뀜
				sheetObj.CheckAll("chk") = 0;*/
				
			} else if(fCmd == MULTI01) {	// DelCancel
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
			}
		 }
    }
	

	/*
  	 * 각 팝업 호출 처리
  	 */
  	function doProcessPopup(srcName) {
  		
  		var sheetObj = sheetObjects[0];
  		var sUrl = '';
  		var sWidth	 = '';
  		var sHeight	 = '';
  		
  		var formObj = document.form;
  		var chgStsCd = ComGetObjValue(formObj.dmdt_chg_sts_cd);
  		
  		with(sheetObj) {
	  		switch(srcName) {
	  			case 'btn_CalcDetail':
	  				var est_mk			= ComGetObjValue(formObj.est_mk);
	  				var svr_id			= ComGetObjValue(formObj.svr_id);
	  				var cntr_no			= ComGetObjValue(formObj.cntr_no);
	  				var cntr_cyc_no		= ComGetObjValue(formObj.cntr_cyc_no);
	  				var dmdt_trf_cd		= ComGetObjValue(formObj.dmdt_trf_cd);
	  				var dmdt_chg_loc_div_cd = ComGetObjValue(formObj.dmdt_chg_loc_div_cd);
	  				var chg_seq			= ComGetObjValue(formObj.chg_seq);
	  				var ofc_cd			= ComGetObjValue(formObj.ofc_cd);
	  				var cntr_tpsz_cd	= ComGetObjValue(formObj.cntr_tpsz_cd);
	  				var bkg_no			= ComGetObjValue(formObj.bkg_no);
	  				var bl_no			= ComGetObjValue(formObj.bl_no);
	  				var fm_mvmt_dt		= ComGetUnMaskedValue(formObj.fm_mvmt_dt, "ymd"); // 2010.10.26 추가
	  				var fm_mvmt_yd_cd	= ComGetObjValue(formObj.fm_mvmt_yd_cd);			// 2010.11.01 추가
	  				var paramVal		= "?est_mk=" + est_mk + "&svr_id=" + svr_id + "&cntr_no=" + cntr_no
	  										+ "&cntr_cyc_no=" + cntr_cyc_no	+ "&dmdt_trf_cd=" + dmdt_trf_cd + "&dmdt_chg_loc_div_cd=" + dmdt_chg_loc_div_cd 
	  										+ "&chg_seq=" + chg_seq + "&ofc_cd=" + ofc_cd + "&cntr_tpsz_cd=" + cntr_tpsz_cd + "&bkg_no=" + bkg_no + "&bl_no=" + bl_no
	  										+ "&fm_mvmt_dt=" + fm_mvmt_dt
	  										+ "&fm_mvmt_yd_cd=" + fm_mvmt_yd_cd
	  										;
	  				
	  				sUrl	= 'EES_DMT_3107.do' + paramVal;
              		sWidth	= '920';
              		sHeight	= '780';
             		break;

	  			case 'btn_CorrHistory':
	  				var svr_id		= ComGetObjValue(formObj.svr_id);
	  				var cntr_no		= ComGetObjValue(formObj.cntr_no);
	  				var cntr_cyc_no	= ComGetObjValue(formObj.cntr_cyc_no);
	  				var dmdt_trf_cd	= ComGetObjValue(formObj.dmdt_trf_cd);
	  				var dmdt_chg_loc_div_cd = ComGetObjValue(formObj.dmdt_chg_loc_div_cd);
	  				var chg_seq		= ComGetObjValue(formObj.chg_seq);
	  				var chg_type	= ComGetObjValue(formObj.chg_type);
	  				
	  				var ofc_cd		= ComGetObjValue(formObj.ofc_cd);
	  				var cntr_tpsz_cd= ComGetObjValue(formObj.cntr_tpsz_cd);
	  				var bkg_no		= ComGetObjValue(formObj.bkg_no);
	  				var bl_no		= ComGetObjValue(formObj.bl_no);
	  				var paramVal	= "?svr_id=" + svr_id + "&cntr_no=" + cntr_no + "&cntr_cyc_no=" + cntr_cyc_no
	  									+ "&dmdt_trf_cd=" + dmdt_trf_cd + "&dmdt_chg_loc_div_cd=" + dmdt_chg_loc_div_cd + "&chg_seq=" + chg_seq
	  									+ "&chg_type=" + chg_type + "&ofc_cd=" + ofc_cd + "&cntr_tpsz_cd=" + cntr_tpsz_cd + "&bkg_no=" + bkg_no + "&bl_no=" + bl_no;
	  				
	  				sUrl	= 'EES_DMT_3103.do' + paramVal;
              		sWidth	= '919';
              		sHeight	= '460';
             		break;
             		
	  			case 'btn_OTHistory':
	  				var ofc_cd		= ComGetObjValue(formObj.ofc_cd);
	  				var svr_id		= ComGetObjValue(formObj.svr_id);
	  				var cntr_no		= ComGetObjValue(formObj.cntr_no);
	  				var cntr_cyc_no	= ComGetObjValue(formObj.cntr_cyc_no);
	  				var dmdt_trf_cd	= ComGetObjValue(formObj.dmdt_trf_cd);
	  				var dmdt_chg_loc_div_cd = ComGetObjValue(formObj.dmdt_chg_loc_div_cd);
	  				var chg_seq		= ComGetObjValue(formObj.chg_seq);
	  				var paramVal	= "?ofc_cd=" + ofc_cd + "&svr_id=" + svr_id + "&cntr_no=" + cntr_no + "&cntr_cyc_no=" + cntr_cyc_no
	  									+ "&dmdt_trf_cd=" + dmdt_trf_cd + "&dmdt_chg_loc_div_cd=" + dmdt_chg_loc_div_cd + "&chg_seq=" + chg_seq;
	  				sUrl	= 'EES_DMT_3105.do' + paramVal;
              		sWidth	= '817';
              		sHeight	= '370';
             		break;
             	
	  			case 'btn_ROInfo':
	  				var paramVal = "?bkg_no=" + ComGetObjValue(formObj.bkg_no);
	  				sUrl	= 'ESM_BKG_0724.do' + paramVal;
              		sWidth	= '1000';
              		sHeight	= '450';
	  				break;
             		
	  			case 'btn_MVMTInq':
	  				var cntrNo = ComGetObjValue(formObj.cntr_no);
	  				var cntrTpszCd = ComGetObjValue(formObj.cntr_tpsz_cd);
	  				var paramVal =	"?pop_mode=Y&p_cntrno=" + cntrNo.substring(0,10) +
	                        		"&check_digit=" + cntrNo.substring(10,11) +
			                        "&ctnr_tpsz_cd=" + cntrTpszCd;
					sUrl	= 'EES_CTM_0408.do' + paramVal;
					sWidth	= '1020';
					sHeight	= '690';
	  				break;
	  				
	  		} // switch-end
  		} // with-end
  		
  		
  		if(sUrl != '') {
  			var sWinName = sUrl.substring(0, sUrl.indexOf('.do'));
  			var returnValue = ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true);
  			
  			if(returnValue == "Y") {
 				ComSetObjValue(formObj.est_mk, "");
 				doActionIBSheet(sheetObj, formObj, IBSEARCH);
 			}
  		}
  	}
	
	
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	with(formObj){
			switch(sAction) {
				case IBSEARCH:      //조회
					var cntrNo = ComGetObjValue(cntr_no);
					
					if(cntrNo == '') {
						ComShowCodeMessage('DMT00102', "CNTR No.");
						ComSetFocus(cntr_no);
						return false;
					}
					
					var trfCd = comboObjects[0].Code;
					
					// 화면 Open 구분  --> call_flag=='M': 메뉴 , call_flag=='P': 팝업호출
					var callFlag = call_flag.value;
					
					if(callFlag == 'M') {
						var locDivCd;
						
						//[Menu로 화면을 Open한 경우] DTOC => POR, DMOF => POL, DTIC => DEL, DMIF => POD, CTOC => POR, CTIC => DEL
						if(trfCd == 'DTOC' || trfCd == 'CTOC')
							locDivCd = 'POR';
						else if(trfCd == 'DMOF')
							locDivCd = 'POL';
						else if(trfCd == 'DTIC' || trfCd == 'CTIC')
							locDivCd = 'DEL';
						else if(trfCd == 'DMIF')
							locDivCd = 'POD';
							
						ComSetObjValue(dmdt_chg_loc_div_cd, locDivCd);
					}
					
					ComSetObjValue(dmdt_trf_cd, trfCd);
					break;
					
				case IBSAVE:
					var chgStsCd = ComGetObjValue(dmdt_chg_sts_cd);
					var to_mvmt_sts = ComGetObjValue("to_mvmt_sts_cd");
					
					if( (chgStsCd == 'F' || chgStsCd == 'U' || chgStsCd == 'L') && to_mvmt_sts == 'DR') {
					
					}
					else {
     					ComShowCodeMessage('DMT03018');
     					return false;
     				}
     				break;
					
				case IBCONFIRM:      //Confirm
         			var chgStsCd = ComGetObjValue(dmdt_chg_sts_cd);
     				if(chgStsCd != 'F') {
     					//ComShowCodeMessage('DMT03018');
     					ComBtnDisable("btn_Confirm");
     					return false;
     				}
     				
     				ComSetObjValue(ibflag, "U");
             		break;
             	
             	case IBDELCANCEL:
             		var chgStsCd = ComGetObjValue(dmdt_chg_sts_cd);
     				if(chgStsCd != 'D') {
     					ComBtnDisable("btn_DELCancel");
     					return false;
     				}
             		
             		ComSetObjValue(ibflag, "U");
             		break;
             		
             	case IBPRECAL:	
             	case IBDRSAVE:
             		var drDt = ComGetObjValue(dr_dt);
             		if(drDt == '') {
             			ComShowCodeMessage('DMT02002', 'D/R Date');
             			ComSetFocus(dr_dt);
             			return false;
             		}
             		
             		drDt = ComGetUnMaskedValue(dr_dt, "ymd");
             		if(ComChkPeriod(drDt, CURR_DATE) == 1) { //1 : fromDate < toDate
             			ComShowCodeMessage('DMT01031', 'D/R Date', 'current date');
             			ComSetFocus(dr_dt);
             			return false;
             		}
             		
             		if(sheetObj.CheckedRows("chk") == 0) {
             			ComShowCodeMessage('COM12114', 'CNTR');
             			return false;
             		}
             		
             		var chkRows = sheetObj.FindCheckedRow("chk").split("|");
             		for(var i=0; i < chkRows.length-1; i++) {
             			
             			var fmMvmtDt = sheetObj.CellValue(chkRows[i], "fm_mvmt_dt");
     					if(ComChkPeriod(drDt, fmMvmtDt) == 1) {
                 			ComShowCodeMessage('DMT01031', 'D/R Date', 'From date');
                 			sheetObj.SelectRow = chkRows[i];
                 			return false;
                 		}
             			
             			var chgStsCd = sheetObj.CellValue(chkRows[i], "dmdt_chg_sts_cd");
             			var to_mvmt_sts = sheetObj.CellValue(chkRows[i], "to_mvmt_sts_cd");
             			
         				if((chgStsCd == 'F' && to_mvmt_sts == 'DR') || chgStsCd == 'U' || chgStsCd == 'L') {
         				
         				} else {
         					ComShowCodeMessage('DMT01059');
         					sheetObj.SelectRow = chkRows[i];
         					return false;
         				}
             		}
             		break;
			} // switch - end	
    	} // with - end

        return true;
    }


	/* 개발자 작업  끝 */