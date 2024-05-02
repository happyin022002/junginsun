/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_dmt_3003.js
*@FileTitle : Charge Calculation by CNTR
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.06.25 황효근
* 1.0 Creation
*---------------------------------------------------------
* History
* 2010.10.26 황효근 [CHM-201006671-01] [EES-DMT] T/S Demurrage Free Time 변경(FM_MVMT_DT 전송 파라미터 추가)
* 2010.11.01 황효근 [] [EES-DMT] T/S Demurrage Free Time 재조정(FM_MVMT_YD_CD 전송 파라미터 추가)
* 2011.09.19 권   민 [CHM-201113398-01][DMT] Charge Deletion Request 관련 Status 표시 관련
* 2012.12.11 김현화 [CHM-201221701-01]OP-MT Detention 계산 방법 보완 2차( to_mvmt_sts 추가 : MT )
* 2013.04.01 임창빈 [ALPS 통합 로그] Remark(s) 항목에 1000자리 이상 입력으로 에러 발생으로 입력 자리수를 제한하는 로직 추가
*            java.sql.SQLException: ORA-12899: value too large for column "NISADM"."DMT_CHG_CALC"."CORR_RMK" (actual: 1148, maximum: 1000)
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
     * @class ees_dmt_3003 : ees_dmt_3003 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_dmt_3003() {
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
	var IBDRSAVE	   = 94;
	var IBDRCANCEL	   = 95;
	var IBDELREQCANCEL = 96;	//DEL Cancel : 기능개선으로 DEL Request Cancel 로 변경됨	2015.02.14
	var IBCONFIRM	   = 97;
	var IBWEBCANCEL    = 98;
	var IBPRECAL	   = 99;
	
	
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObj = sheetObjects[0];
		/*******************************************************/
		var formObj = document.form;

		try {
			var srcObj = window.event.srcElement;
     		var srcName = srcObj.getAttribute("name");
         		
			// 그리드 하단 버튼 클릭시  비활성화 상태이면 그냥 return
			if(!ComIsBtnEnable(srcName)) return;

             switch(srcName) {
             	case "btn_PreCal":
             		doActionIBSheet(sheetObj,formObj,IBPRECAL);
					break;
					
             	case "btn_WebCancel":
             		doActionIBSheet(sheetObj,formObj,IBWEBCANCEL);
					break;

             	case "btn_Retrieve":
             		ComSetObjValue(formObj.est_mk, "");
					doActionIBSheet(sheetObj,formObj,IBSEARCH);
					break;

				case "btn_New":
					ComResetAll();
					doInit();
					break;
					
				case "btn_Close":
 					window.returnValue = "Y";
					window.close();
					break;
					
				case "btn_Save":
//					var toMvmtSts = ComGetObjValue(formObj.to_mvmt_sts);
//					if(toMvmtSts == "DR") {
//						if(!ComShowCodeConfirm("DMT01156", "\nDo you want to make DR?"))
//		             		return false;
//
//					}
 					 doActionIBSheet(sheetObj,formObj,IBSAVE);
 					break;
				
 				case "btn_Confirm":
 					doActionIBSheet(sheetObj,formObj,IBCONFIRM);
 					break;
 					
// 				case "btn_DelReqCancel":
// 					doActionIBSheet(sheetObj,formObj,IBDELREQCANCEL);
// 					break;
 				
 				case "btn_DRCancel":
 					doActionIBSheet(sheetObj,formObj,IBDRCANCEL);
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
				case 'btn_CalcDetail':
				case 'btn_CorrHistory':
				case 'btn_OTHistory':
				case 'btn_ROInfo':
				case 'btn_MVMTInq':
				case 'btn_ExceptionInq':
 				//default:
 					doProcessPopup(srcName);
 					break;	
 				case 'btn_Partial':
//					if (!ComShowCodeConfirm("DMT01156", "\nDo you want to make DR?"))
//	             		return false;
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
		var formObj = document.form;
		
		// 팝업으로 호출시에 타이틀 표시 처리
		if(ComGetObjValue(formObj.call_flag) == "P") {
			var spanObj = document.getElementById("title2");
       	 	spanObj.innerText = " Charge Calculation by CNTR";
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
		doInit();
		
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
			doActionIBSheet(sheetObj,formObj,IBSEARCH);
		}
 		
        sheetObj.WaitImageVisible = true; 
   	} 
	 
	 
	// 화면 초기화
	function doInit() {
		var formObj = document.form;
		
		initBtns();
		ComSetDisplay('tbl_webmty', false);
		
		with(formObj) {
			if(ComGetObjValue(formObj.call_flag)=='M') {
				ComEnableObject(cntr_no, true);
				DmtComSetClassManyObjects('input1', cntr_no);
			}
			
			ComEnableManyObjects(true, chg_type, fm_mvmt_dt, fm_mvmt_yd_cd, btns_calendar1);	        			
			DmtComSetClassManyObjects('input1', fm_mvmt_dt, fm_mvmt_yd_cd);
			
			ComEnableManyObjects(true, to_mvmt_dt, to_mvmt_yd_cd, btns_calendar2);
			DmtComSetClassManyObjects('input1', to_mvmt_dt, to_mvmt_yd_cd);
			
			//comboObjects[0].Enable = true;
			comboObjects[1].Enable = true;
		}
	}
	 
	
	/**
	  * 화면 초기화
	  */
	function initBtns() {
		// 버튼 활성화 상태 초기화
		DmtComEnableManyBtns(false, 'btn_PreCal','btn_Save','btn_Confirm','btn_Demand','btn_Billing','btn_OFCTrans','btn_Delete'
									,'btn_Partial','btn_DRCancel','btn_CalcDetail','btn_CorrHistory','btn_ROInfo'
									,'btn_MVMTInq','btn_ExceptionInq', 'btn_OTHistory');
		
		document.getElementById("btn_PreCal").style.color = '';
		document.getElementById("btn_ROInfo").style.color = '';
		
		ComSetDisplay('btn_WebCancel', false);
	}
	
	
	function initControl() {
		axon_event.addListenerFormat('blur',	'obj_blur',		document.form); //- 포커스 나갈때
		axon_event.addListenerFormat('focus',	'obj_focus',	document.form); //- 포커스 들어갈때
		axon_event.addListenerFormat('keypress','obj_keypress', document.form); //- 키보드 입력할때
		axon_event.addListener('keydown',	'obj_keydown',		'form');
		axon_event.addListener('keyup',		'obj_keyup',		'fm_mvmt_yd_cd', 'to_mvmt_yd_cd');
		axon_event.addListener('mouseover', 'obj_mouseover',	'td_ch', 'rlse_dt');
		axon_event.addListener('mouseout',	'obj_mouseout',		'td_ch', 'rlse_dt');
	   	axon_event.addListenerForm('click', 'uclm_chk_click', form); //- Unclaimed Cargo CheckBox 클릭시 이벤트 발생시 처리

	}
	
	
	// keydown 이벤트 처리
	function obj_keydown() {
		// Remark(s) 항목입력 후, Enter키 조회 기능은 제외 
		if(event.srcElement.name == 'corr_rmk') return;
		
		ComKeyEnter();
	}
	
	
	/*
	 * KeyUp 이벤트 처리 - From/To Yard Code Validation 처리 함수
	 */
	function obj_keyup() {
		var keyValue = event.keyCode;
		if(keyValue == 9) return;	// tab키인 경우
		 
		var srcObj = event.srcElement;
		
		var formObj = document.form;
		var ydCd = ComTrim(ComGetObjValue(srcObj));
		
		if (ydCd.length == 7) {
			formObj.yd_cd1.value = ydCd;
			doActionIBCombo(sheetObjects[0], formObj, comboObjects[1], SEARCH14, srcObj);
		}
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
	
	// Unclaimed Cargo CheckBox 클릭시 이벤트 발생시 처리
	function uclm_chk_click() {
		var frmObj = document.form;
		
		if(frmObj.uclm_chk.checked == true){
			frmObj.uclm_flg.value= "Y";
 		} else if (frmObj.uclm_chk.checked == false){
			frmObj.uclm_flg.value= "N";
 		}		
	}

	//포커스가 나갈 때
	function obj_blur(){
		//입력Validation 확인하기 + 마스크구분자 넣기
		var obj = event.srcElement;
		
	 	if(obj.name == 'fm_mvmt_yd_cd' || obj.name == 'to_mvmt_yd_cd') {
	 		if(obj.value.length > 0 && obj.value.length < 7) {
	 			ComSetObjValue(document.form.chk_yd_cd, "N");
	 			ComShowCodeMessage('DMT00110', 'Yard');
	 			ComClearObject(obj);
	 			ComSetFocus(obj);
	 		}
	 	} else
	 		ComChkObjValid(obj);
	}
    
    /**
     * HTML Control Foucs in
     */
	function obj_focus(){
		var obj = event.srcElement;
        
        //글자가 있는 경우 블럭으로 선택할수 있도록 한다.
        if (obj.getAttribute("isContentEditable") && obj.getAttribute("value") != null && obj.value.length >=1 ) {
        	ComClearSeparator(obj);
        	obj.select();
        }
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
                    InitHeadMode(true, true, true, true, false, false);

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
  					BackColor = "#CCFFFD";
		    	}
				break;
			
	    	case "to_mvmt_sts":
				with (comboObj) { 
    				MultiSelect = false;
    				UseAutoComplete = true;
					SetColAlign("left");
					SetColWidth("60");
					DropHeight = 170;
					ColBackColor(0) = "#CCFFFD";
					BackColor = "#CCFFFD";
					
					ValidChar(2);	// 영어대문자 사용
					MaxLength = 2;
   		    	}
				addComboItem(comboObj, 'DMIF');
   	    		break;
	    } // switch end
	}
	
	

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
	    sheetObj.ShowDebugMsg = false;
	    
	    if(!validateForm(sheetObj,formObj,sAction)) return;
	 	
        sheetObj.WaitImageVisible=false;
    	ComOpenWait(true);
    	
	    switch(sAction) {
	        case IBSEARCH:		// 조회
	        	formObj.f_cmd.value = SEARCH;
	        	sheetObj.DoSearch("EES_DMT_3003GS.do", FormQueryString(formObj));
	        	
	        	var deltRqstStsCd = ComGetObjValue(formObj.dmdt_delt_rqst_sts_cd);
	        	
   		        // 1. 파랑색 : Charge Deletion 요청한 상태로 Charge Deletion 취소가 가능한 상태입니다.(승인처리가 전혀 이루어지지 않은 상태임)
   		        if (deltRqstStsCd == 'R') {
	        		 formObj.dmdt_chg_sts_desc.style.color       = "1e90ff";
	        		 formObj.dmdt_chg_sts_desc.style.fontWeight  = "bold"; 	   		            
   		        }
   		        // 2. 분홍색 : Charge Deletion 요청에 대해서 승인처리가 진행중인 상태로 Charge Deletion 취소가 불가한 상태입니다.
   		        else if (isProcessingInactive(deltRqstStsCd)) {
	        		 formObj.dmdt_chg_sts_desc.style.color       = "ff64ff";
	        		 formObj.dmdt_chg_sts_desc.style.fontWeight  = "bold"; 	   		            
   		        }
   		        // 3. 녹색 : Charge Deletion 요청에 대해서 필수최종승인단계까지의 처리가 완료된 상태입니다.
   		        else if (deltRqstStsCd == 'X') {
	        		 formObj.dmdt_chg_sts_desc.style.color       = "cff058";
	        		 formObj.dmdt_chg_sts_desc.style.fontWeight  = "bold"; 	   		            
   		        } 	   		        
   		        // 4. 빨간색 : 기존 상태값으로 Charge Deletion 요청에 대해서 취소한 상태입니다.
   		        else if (isProcessingInactiveReject(deltRqstStsCd)) {
	        		 formObj.dmdt_chg_sts_desc.style.color       = "ff0000";
	        		 formObj.dmdt_chg_sts_desc.style.fontWeight  = "bold"; 	
   		        } 
   		        // 5. 검정색 : 그 이외의 상태입니다.
   		        else { 
	        		 formObj.dmdt_chg_sts_desc.style.color       = "000000";
	        		 formObj.dmdt_chg_sts_desc.style.fontWeight  = ""; 	 
   		        }
	        break;
	        	
	        case IBSAVE:		// Save
				formObj.f_cmd.value = MODIFY;
         		var sXml = sheetObj.GetSaveXml("EES_DMT_3003GS.do", FormQueryString(formObj));
         		sheetObj.LoadSaveXml(sXml);
         		
				break;
	        	
	        case IBCONFIRM:		// Confirm
				formObj.f_cmd.value = MULTI;
				var sXml = sheetObj.GetSaveXml("EES_DMT_3003GS.do", FormQueryString(formObj));
				sheetObj.LoadSaveXml(sXml);
				break;
 				
			case IBDELREQCANCEL:	// Delete Request Cancel
				 formObj.f_cmd.value = MULTI01;
				 var sXml = sheetObj.GetSaveXml("EES_DMT_3003GS.do", FormQueryString(formObj));
				 sheetObj.LoadSaveXml(sXml);
				 break;
               
			case IBPRECAL:
	         	formObj.f_cmd.value = MULTI02;
	         	var sXml = sheetObj.GetSaveXml("EES_DMT_3003GS.do", FormQueryString(formObj));
         		sheetObj.LoadSaveXml(sXml);
	         	break;
	         	
			case IBWEBCANCEL:
	         	formObj.f_cmd.value = MODIFY01;
	         	var sXml = sheetObj.GetSaveXml("EES_DMT_3003GS.do", FormQueryString(formObj));
	         	sheetObj.LoadSaveXml(sXml);
	         	break;
	         	
			case IBDRCANCEL:	// D/R Cancel
				formObj.f_cmd.value = REMOVE;
	
				var sXml = sheetObj.GetSaveXml("EES_DMT_3003GS.do", FormQueryString(formObj));
				sheetObj.LoadSaveXml(sXml);
				break;
	    }
	}
	
	/**
	 * Tariff Type 코드와 Description 정보를 IBSheet를 통해 가져온다.
	 */
	function doActionIBCombo(sheetObj, formObj, comboObj, formCmd, srcObj) {
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
				
	        case "to_mvmt_sts":
 	        	var data = ComGetEtcData(sXml, "YD");
				
				if (data != undefined && data != '') {
					ComSetObjValue(formObj.chk_yd_cd, "Y");

					// Yard Code 입력후에  해당 오브젝트 위치로 포커스를 이동시킨다.
					if(srcObj.name == 'fm_mvmt_yd_cd')
						formObj.to_mvmt_dt.focus();
					else {
						formObj.to_mvmt_sts.focus();
					}
				} else {
					ComSetObjValue(formObj.chk_yd_cd, "N");
					ComShowCodeMessage('DMT00110', "Yard");
					ComClearObject(srcObj);
					srcObj.focus();
				}
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
	 				comboObj.InsertItem(2, "MT", "MT"); //2012.12.11 추가
	 				comboObj.InsertItem(3, "DR", "DR");
	 				comboObj.InsertItem(4, "XX", "XX"); //2016.09.22 추가

					break;
					
	 			case "CTOC":
					comboObj.InsertItem(0, "", "");
	 				comboObj.InsertItem(1, "VL", "VL");
	 				comboObj.InsertItem(2, "MT", "MT"); //2012.12.11 추가
	 				comboObj.InsertItem(3, "DR", "DR");
	 				comboObj.InsertItem(4, "XX", "XX"); //2016.09.22 추가

					break;
						
	 			case "DMOF":
	 				comboObj.InsertItem(0, "", "");
	 				comboObj.InsertItem(1, "VL", "VL");
	 				comboObj.InsertItem(2, "MT", "MT");	// OC-MT 기능 추가 (2018.02.28)
	 				comboObj.InsertItem(3, "EN", "EN");
	 				comboObj.InsertItem(4, "TN", "TN");
	 				comboObj.InsertItem(5, "DR", "DR");
	 				comboObj.InsertItem(6, "XX", "XX"); //2016.09.22 추가
					break;
					
	 			case "DMIF":
					comboObj.InsertItem(0, "", "");
	 				comboObj.InsertItem(1, "ID", "ID");
	 				comboObj.InsertItem(2, "EN", "EN");
	 				comboObj.InsertItem(3, "TN", "TN");
	 				comboObj.InsertItem(4, "DR", "DR");
	 				comboObj.InsertItem(5, "XX", "XX");
	 				
	 				if(ComGetObjValue(document.form.dmdt_chg_loc_div_cd) == 'TSP')
	 					comboObj.InsertItem(6, "VL", "VL");
	 				break;
					
	 			case "DTIC":
	 			case "CTIC":
					comboObj.InsertItem(0, "", "");
	 				comboObj.InsertItem(1, "MT", "MT");
	 				comboObj.InsertItem(2, "DR", "DR");
//		 			comboObj.InsertItem(3, "CS", "CS");
	 				comboObj.InsertItem(3, "XX", "XX");
					break;
		  		}
		  		break;	
 		}
 	}
 	
 	// Tariff Type IBCombo OnChagne 이벤트 발생시 처리
 	function tariff_type_OnChange(comboObj, value, text) {
 		var toMvmtStsCombo = comboObjects[1];
 		toMvmtStsCombo.RemoveAll();
 		addComboItem(toMvmtStsCombo, value);
 	}
 	
	// Tariff Type IBCombo OnChagne 이벤트 발생시 처리
 	function tariff_type_OnKeyDown(comboObj, keyCode, shift) {
 		//if(keyCode == 13) ComKeyEnter();
 	}
 	
	// To MVMT STS IBCombo OnFocus 이벤트 발생시 처리
 	function to_mvmt_sts_OnFocus(comboObj) {
 		comboObj.Code = comboObj.Code;
 	}
 	
 	
    /**
  	 * IBSheet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
  	 */
	function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
  		
  		ComOpenWait(false);
  		
  		// 조회 오류 발생시
  		if(ErrMsg != '') return;
  		
  		var formObj = document.form;
  		
  		with(formObj) {
			var fCmd = ComGetObjValue(f_cmd);
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
        	
        	// 조회 데이터 없음
        	if(retCntrNo == '') {
        		ComSetObjValue(cntr_no, cntrNo);
        		//ComClearManyObjects(dmdt_chg_sts_desc, xcld_sat_flg, xcld_sun_flg, xcld_hol_flg, total_amt, aft_expt_dc_amt, bil_amt);
        		ComClearManyObjects(dmdt_chg_sts_desc, total_amt, aft_expt_dc_amt, bil_amt);
        		comboObjects[1].Code = '';
        		
        		// 버튼 활성화 상태 초기화
        		DmtComEnableManyBtns(false, 'btn_PreCal','btn_Save','btn_Confirm','btn_Demand','btn_Billing','btn_OFCTrans','btn_Delete'
        									,'btn_Partial','btn_DRCancel','btn_CalcDetail','btn_CorrHistory','btn_ROInfo'
        									,'btn_MVMTInq','btn_ExceptionInq', 'btn_OTHistory');
        		
        		ComSetDisplay('btn_WebCancel', false);
        		document.getElementById("btn_ROInfo").style.color = "";
        		
        	} else {
        		// 그리드의 조회결과가 없을시에도 DoSave 나  DoAllSave 실행하기 위해.
        		/*
        		if(sheetObj.SearchRows == 0) {
	        		var row = sheetObj.DataInsert(-1);
	        		sheetObj.CellValue(row, "rt_chrg") = "0";
	        		sheetObj.RowHidden(row) = true;
	        		sheetObj.RowHidden(sheetObj.LastRow) = true;
        		}*/
        		
        		// ********** 조회 데이터 존재 ************
        		
        		// 조회 Option 비활성화
        		comboObjects[0].Enable = false;
        		ComEnableManyObjects(false, cntr_no, chg_type);
        		DmtComSetClassManyObjects('input2', cntr_no, chg_type);
        		
        		var chgStsCd = ComGetObjValue(dmdt_chg_sts_cd);
        		var toMvmtStsCd = ComGetObjValue(to_mvmt_sts_cd);
        		
        		var comboObj = comboObjects[1];
        		comboObj.Code = toMvmtStsCd;
        		
        		if(toMvmtStsCd != '' && comboObj.Code == '') {
        			comboObj.InsertItem(comboObj.GetCount(), toMvmtStsCd, toMvmtStsCd);
        			comboObj.Code = toMvmtStsCd;
        		}
        		
        		// Tariff Type 이 'DTIC' 이고, To MVMT Status가 'OC'인  경우   예외처리
//        		if(ComGetObjValue(dmdt_trf_cd)=='DTIC' && toMvmtStsCd == 'OC') {
//        			comboObjects[1].InsertItem(5, "OC", "OC");
//        		}
        		
        		
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
        		/*
        		ComSetObjValue(xcld_sat_flg, arrXcldFlgs[0]);
        		ComSetObjValue(xcld_sun_flg, arrXcldFlgs[1]);
        		ComSetObjValue(xcld_hol_flg, arrXcldFlgs[2]);
        		*/
        		
        		// Charge Sequence 에  따른  fm_mvmt_dt, fm_mvmt_yd_cd / to_mvmt_dt, to_mvmt_yd_cd, to_mvmt_sts_cd  활성/비활성  처리
        		var chgSeq = ComGetObjValue(chg_seq);
        		var chgMaxSeq = ComGetObjValue(chg_max_seq);
        		
        		if(chgSeq == '1') { // General Charge
        			ComEnableManyObjects(true, fm_mvmt_dt, fm_mvmt_yd_cd, btns_calendar1);	        			
        			DmtComSetClassManyObjects('input1', fm_mvmt_dt, fm_mvmt_yd_cd);
        			
        			if(chgMaxSeq == '1') { // General Charge만 존재 - From/To 둘다 활성화
        				ComEnableManyObjects(true, to_mvmt_dt, to_mvmt_yd_cd, btns_calendar2);
	        			DmtComSetClassManyObjects('input1', to_mvmt_dt, to_mvmt_yd_cd);
	        			comboObjects[1].Enable = true;
        			} else {
	        			ComEnableManyObjects(false, to_mvmt_dt, to_mvmt_yd_cd, btns_calendar2);
	        			DmtComSetClassManyObjects('input2', to_mvmt_dt, to_mvmt_yd_cd);
	        			comboObjects[1].Enable = false;
        			}
        			
        		} else if(chgSeq < chgMaxSeq) { // From/To 모두 비활성화
        			ComEnableManyObjects(false, fm_mvmt_dt, fm_mvmt_yd_cd, btns_calendar1);	        			
        			DmtComSetClassManyObjects('input2', fm_mvmt_dt, fm_mvmt_yd_cd);
        			
        			ComEnableManyObjects(false, to_mvmt_dt, to_mvmt_yd_cd, btns_calendar2);
        			DmtComSetClassManyObjects('input2', to_mvmt_dt, to_mvmt_yd_cd);
        			comboObjects[1].Enable = false;
        			
        		} else { // chg_seq == chg_max_seq(마직막 Balance Charge)
        			ComEnableManyObjects(false, fm_mvmt_dt, fm_mvmt_yd_cd, btns_calendar1);	        			
        			DmtComSetClassManyObjects('input2', fm_mvmt_dt, fm_mvmt_yd_cd);
        			
        			ComEnableManyObjects(true, to_mvmt_dt, to_mvmt_yd_cd, btns_calendar2);
        			DmtComSetClassManyObjects('input1', to_mvmt_dt, to_mvmt_yd_cd);
        			comboObjects[1].Enable = true;
        		}
        		
        		
        		// 데이터 조회 후, Charge Status에 따른 버튼 활성화 상태 설정
        		DmtComEnableManyBtns(true,	'btn_Demand', 'btn_Billing', 'btn_OFCTrans', 'btn_DRCancel', 'btn_CalcDetail'
        								, 'btn_CorrHistory', 'btn_ROInfo', 'btn_MVMTInq' ,'btn_ExceptionInq', 'btn_OTHistory');
        		
        		
        		// Web이 "Y" 인 경우(web_ind_flg = 'Y') 일 때만, Web M'ty / Grace End 필드와 'Web Cancel' 버튼을 보여준다. 
        		if(ComGetObjValue(web_ind_flg) == 'Y') {
        			ComSetDisplay('tbl_webmty', true);
        			ComSetDisplay('btn_WebCancel', true);
        		} else {
        			ComSetDisplay('tbl_webmty', false);
        			ComSetDisplay('btn_WebCancel', false);
        		}
        		
        		// PreCal 처리후  Retrieve시, 'Pre Cal.' 버튼  비활성시키고 , 빨간색으로 변경
        		if(ComGetObjValue(est_mk) == 'P') {
        			document.getElementById("btn_PreCal").style.color = 'red';
        			
        			DmtComEnableManyBtns(false, 'btn_PreCal','btn_Save','btn_Confirm','btn_Demand','btn_Billing','btn_OFCTrans','btn_Delete'
        					,'btn_Partial','btn_DRCancel');
        			
        		} 
        		else {
        			document.getElementById("btn_PreCal").style.color = '';
        			DmtComEnableManyBtns(true, 'btn_PreCal', 'btn_Save');
        			
        			// 2015-09-01 save 활성/비활성 조건 추가
        			if(chgStsCd != 'L' && ComGetObjValue(dr_cancel_btn_flg) == 'Y')
    					ComBtnDisable("btn_Save");
        		
        			// Charge Status 에  따른  버튼 활성화/비활성화 설정
	        		if(chgStsCd == 'F')
	        			ComBtnEnable("btn_Confirm");
	        		else
	        			ComBtnDisable("btn_Confirm");
	        		
	        		// Deletion Cancel 에서 기능개선으로 Delete Request Cancel 로 변경됨. 2015.02.14 =====================
//	        		if(chgStsCd == 'D') {
//        				ComBtnDisable("btn_Delete");
//        				ComBtnEnable("btn_DelReqCancel");
//        			} else {
//        				ComBtnEnable("btn_Delete");
//        				ComBtnDisable("btn_DelReqCancel");
//        			}	        		
	        		var deltRqstStsCd = ComGetObjValue(formObj.dmdt_delt_rqst_sts_cd);
	        		//DEL Request 버튼 상태 설정
	        		if (chgStsCd == 'D') {
	        			ComBtnDisable("btn_Delete");
	        		}
	        		else {
	        			if (isProcessingInactiveReject(deltRqstStsCd)) {
		        			ComBtnEnable("btn_Delete");
		        		}
	        			else if (deltRqstStsCd == 'N'  || deltRqstStsCd == 'R') {
		        			ComBtnEnable("btn_Delete");
		        		}
	        			else {
	        				ComBtnDisable("btn_Delete");
	        			}
	        		}
	        		//DEL REQ Cancel 버튼 상태 설정
//	        		if (deltRqstStsCd == 'R') {
//	        			ComBtnEnable("btn_DelReqCancel");
//	        		}
//	        		else {
//	        			ComBtnDisable("btn_DelReqCancel");
//	        		}
	        		//=====================================================================================================

	        		
        			if(chgStsCd == 'F' || chgStsCd == 'C' || chgStsCd == 'L' || chgStsCd == 'I'){
        				// 2015-09-01 Partial 활성/비활성 조건 추가
        				if(chgStsCd != 'L' && ComGetObjValue(dr_cancel_btn_flg) == 'Y') {
        					ComBtnDisable("btn_Partial");
        				}
        				else {
        					ComBtnEnable("btn_Partial");
        				}
        			} else
	        			ComBtnDisable("btn_Partial");
	        		
	        		// Charge Type이 Balance인 경우에만  'DRCancel'버튼 활성화
	        		if(ComGetObjValue(chg_seq) == '1' || ComGetObjValue(dr_cancel_btn_flg) == 'Y')	// Charge Type: General
	        			ComBtnDisable("btn_DRCancel");
	        		else
	        			ComBtnEnable("btn_DRCancel");			// Charge Type: Balance
        		}	
        		
        		
        		// D/C by AMT or % 필드값 설정
	        	aft_expt_dc_amt.value = ComAddComma2(aftExptDcAmt+'', "#,###.00");	
	        	
	        	// Billable AMT 필드값 설정
	        	bil_amt.value = ComAddComma2(bilAmt+'', "#,###.00");
	        	
	        	
	        	if(ComGetObjValue(roll_ovr) == 'S')
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
  		
//  		ComBtnEnable("btn_DelReqCancel");
	}
        
	
	/**
     * 저장후 처리
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg){
    	ComOpenWait(false);
    	 
    	// 저장 오류 발생
		if(ErrMsg != '') return;
		 
		var formObj = document.form;
		var fCmd = formObj.f_cmd.value;
		
		if(fCmd == MULTI02) {	// Pre Calculation 처리이후
			ComSetObjValue(formObj.est_mk, "P");
			
			// 'Pre Cal.' 버튼 색깔을 빨간색으로 변경
			document.getElementById("btn_PreCal").style.color = "red";
			
		} else if(fCmd == REMOVE) {
			if(ComGetObjValue(formObj.call_flag) == "P") {
				window.returnValue = "Y";
				self.close();
			}
		}
		
		doActionIBSheet(sheetObj,formObj,IBSEARCH);
    }
	

	/*
  	 * 각 팝업 호출 처리
  	 */
  	function doProcessPopup(srcName) {
  		var sheetObj = sheetObjects[0];
  		var formObj = document.form;
  		var sUrl = '';
  		var sWidth	 = '';
  		var sHeight	 = '';
  		var paramVal = '';
  		var sScroll = 'no';
  		
  		var chgStsCd      = ComGetObjValue(formObj.dmdt_chg_sts_cd);
		var cntrNo        = ComGetObjValue(formObj.cntr_no);
  		var bkgNo		  = ComGetObjValue(formObj.bkg_no);
  		var trfCd         = comboObjects[0].Code;
		var deltRqstStsCd = ComGetObjValue(formObj.dmdt_delt_rqst_sts_cd) //2011.10.10
  		
  		with(sheetObj) {
	  		switch(srcName) {
	  			case 'btn_Demand':
     				if( !(chgStsCd == 'F' || chgStsCd == 'C' || chgStsCd == 'I' || chgStsCd == 'L' || chgStsCd == 'U') ) {
     					ComShowCodeMessage('DMT01077');
        				return;
     				}
     				chgStsCd = "F,C,I,L,U";
     				paramVal =	"?group_by=2"
		     	 	 			+"&chg_type="	+ ComGetObjValue(formObj.chg_type)
		     	 	 			+"&ofc_cd="		+ ComGetObjValue(formObj.ofc_cd)
		     	 				+"&dmdt_chg_sts_cd=" + chgStsCd
		     	 				+"&bkg_no="		+ ComGetObjValue(formObj.bkg_no)
		     	 				+"&dmdt_trf_cd="+ ComGetObjValue(formObj.dmdt_trf_cd)
		     	 				+"&cntr_no="	+ ComGetObjValue(formObj.cntr_no)
		     	 				+"&dmdt_inv_no="
		     	 				+"&invoice_issue=1"	//Invoice Issue BEFORE
		     	 				;
     				
             		sUrl	= 'EES_DMT_3109.do' + paramVal;
              		sWidth	= EES_DMT_3109_WIDTH;
              		sHeight	= EES_DMT_3109_HEIGHT;
	  				break;
	  				
	  			case 'btn_Billing':
             		var invIssue = '1'; // before:1, after:2
             		var invNo    = '';
             		var ofcCd    = '';
             		
             		if (chgStsCd == 'I') {
	  					invIssue = '2';
	  					invNo    = ComGetObjValue(formObj.dmdt_inv_no);
	  					ofcCd    = ComGetObjValue(formObj.cre_ofc_cd);
	  				} 
             		else {
	            		if (deltRqstStsCd == 'R') {
	            			ComShowCodeMessage('DMT01154');
	            			return;   
	            		}
	            		else if (isProcessingInactive(deltRqstStsCd)) {
	            			ComShowCodeMessage('DMT01176', bkgNo, cntrNo, trfCd);
	            			return;         					
	            		}
	            		else if (chgStsCd != 'C') {
	             			ComShowCodeMessage('DMT01076', 'Billing');
	             			return;
	             		}
	            		else {
	            			ofcCd = ComGetObjValue(formObj.ofc_cd);
	            		}
             		}
	  				
         			paramVal =	"?group_by=2"
		        				+ "&chg_type="		+ ComGetObjValue(formObj.chg_type)
		        				+ "&ofc_cd="		+ ofcCd
		        				+ "&bkg_no="		+ bkgNo
		        				+ "&dmdt_trf_cd="	+ trfCd
		        				+ "&invoice_no="	+ invNo
		        				+ "&invoice_issue=" + invIssue;
			        				
			        sUrl	= 'EES_DMT_4002.do' + paramVal;
              		sWidth	= EES_DMT_4002_WIDTH;
              		sHeight	= EES_DMT_4002_HEIGHT;
             		break;	
	  		
	  			case 'btn_OFCTrans':	
	  				if (deltRqstStsCd == 'R') {
     					ComShowCodeMessage('DMT01153');
     					return;   
     				}
     				else if (isProcessingInactive(deltRqstStsCd)) {
     					ComShowCodeMessage('DMT01176', bkgNo, cntrNo, trfCd);
     					return;         					
     				}
	  				// 2016.07.19 [ Confirm ] Status 조건 추가
     				else if (chgStsCd != 'F' && chgStsCd != 'L' && chgStsCd != 'N' && chgStsCd != 'C' ) {
     					ComShowCodeMessage('DMT01019');
     					return;
     				}
             		
             		var fmOfcCd = ComGetObjValue(formObj.ofc_cd);
             		var ofcRhqCd = ComGetObjValue(formObj.ofc_rhq_cd);
		  			var paramVal = "?fm_ofc_cd=" + fmOfcCd + "&ofc_rhq_cd=" + ofcRhqCd;
             		
             		sUrl	= 'EES_DMT_3101.do' + paramVal;
              		sWidth	= '618';
              		sHeight	= '490';
             		break;
             		
	  			case 'btn_Delete':
        			// Charge Deletion 요청상태 코드값 변경에 따라 체크로직을 DMT 공통함수로 변환함. 
        			if (!isValidChgDeltRqst(bkgNo, cntrNo, trfCd, deltRqstStsCd)) return;  
//           		2011.10.10 KHH [CHM-201113639-01]
//        			if(delt_rqst_sts=='R'){
//        				ComShowCodeMessage('DMT01155');
//        				return;
//        			}		
        			
	  				if (chgStsCd == 'D') {
		  				ComShowCodeMessage("DMT00176", ComGetObjValue(formObj.bkg_no));
	  					return;
	  				}
	  				else if (chgStsCd == 'I') {
	  					ComShowCodeMessage('DMT01026');
	  					return;
	  				}
	  				
	  				var paramVal      = '';
	  				var deltRqstStsCd = ComGetObjValue(formObj.dmdt_delt_rqst_sts_cd);
        			if (deltRqstStsCd == 'R' && paramVal == '') {
        				var svrId_r 		= ComGetObjValue(formObj.svr_id);
        				var cntrNo_r		= ComGetObjValue(formObj.cntr_no);
        				var cntrCycNo_r		= ComGetObjValue(formObj.cntr_cyc_no);
        				var trfCd_r			= ComGetObjValue(formObj.dmdt_trf_cd);
        				var chgLocDivCd_r	= ComGetObjValue(formObj.dmdt_chg_loc_div_cd);
        				var chgSeq_r		= ComGetObjValue(formObj.chg_seq);
        				var chgDeltStsCd_r  = ComGetObjValue(formObj.dmdt_delt_rqst_sts_cd);
    		  			
    		  			paramVal  = "?";
    		  			paramVal += "sys_area_grp_id="      + svrId_r;
    		  			paramVal += "&cntr_no="             + cntrNo_r;
    		  			paramVal += "&cntr_cyc_no="         + cntrCycNo_r;
    		  			paramVal += "&dmdt_trf_cd="         + trfCd_r;
    		  			paramVal += "&dmdt_chg_loc_div_cd=" + chgLocDivCd_r;
    		  			paramVal += "&chg_seq="             + chgSeq_r;
    		  			paramVal += "&chg_delt_sts_cd="     + chgDeltStsCd_r;
    		  			paramVal += "&prnt_mnu_id="         + "EES_DMT_3014";
    		  			paramVal += "&save_flg="            + "D";
        			}
	  				
	  				sUrl	= 'EES_DMT_3104.do'+paramVal;
              		sWidth	= '770';
              		sHeight	= '720';   
	  			break;
	  				
	  			case 'btn_Partial':
         			if (deltRqstStsCd == 'R') {
     					ComShowCodeMessage('DMT01155');
     					return;   
     				}
     				else if (isProcessingInactive(deltRqstStsCd)) {
     					ComShowCodeMessage('DMT01176', bkgNo, cntrNo, trfCd);
     					return;         					
     				} 	  				
     				else if (ComGetObjValue(formObj.dul_tp_expt_flg) == 'Y') {
	  					ComShowCodeMessage('DMT03069', 'Partial');
	  					return;
	  				}
	  				
	  				var svr_id				= ComGetObjValue(formObj.svr_id);
	  				var cntr_no				= ComGetObjValue(formObj.cntr_no);
	  				var cntr_cyc_no			= ComGetObjValue(formObj.cntr_cyc_no);
	  				var dmdt_trf_cd			= ComGetObjValue(formObj.dmdt_trf_cd);
	  				var dmdt_chg_loc_div_cd = ComGetObjValue(formObj.dmdt_chg_loc_div_cd);
	  				var cntr_tpsz_cd		= ComGetObjValue(formObj.cntr_tpsz_cd);
	  				var dmdt_chg_sts_cd		= ComGetObjValue(formObj.dmdt_chg_sts_cd);
	  				
	  				var bkg_no		= ComGetObjValue(formObj.bkg_no);
	  				var bl_no		= ComGetObjValue(formObj.bl_no);
	  				var paramVal	= "?svr_id=" + svr_id + "&cntr_no=" + cntr_no + "&cntr_cyc_no=" + cntr_cyc_no
	  									+ "&dmdt_trf_cd=" + dmdt_trf_cd + "&dmdt_chg_loc_div_cd=" + dmdt_chg_loc_div_cd
	  									+ "&bkg_no=" + bkg_no + "&bl_no=" + bl_no + "&cntr_tpsz_cd=" + cntr_tpsz_cd
	  									+ "&dmdt_chg_sts_cd=" + dmdt_chg_sts_cd;
	  				
	  				sUrl	= 'EES_DMT_3102.do' + paramVal;
              		sWidth	= '880';
              		sHeight	= '430';
              		
              		//ComOpenWindow(sUrl, 'EES_DMT_3102', 'width='+sWidth+',height='+sHeight);
              		//return;
             		break;
             		
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
	  				var fm_mvmt_dt		= ComGetUnMaskedValue(formObj.fm_mvmt_dt, "ymd");	// 2010.10.26 추가
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
              		
              		//ComOpenWindow(sUrl, 'EES_DMT_3107', 'width='+sWidth+',height='+sHeight);
              		//return;
             		break;

	  			case 'btn_CorrHistory':
	  				var svr_id			= ComGetObjValue(formObj.svr_id);
	  				var cntr_no			= ComGetObjValue(formObj.cntr_no);
	  				var cntr_cyc_no		= ComGetObjValue(formObj.cntr_cyc_no);
	  				var dmdt_trf_cd		= ComGetObjValue(formObj.dmdt_trf_cd);
	  				var dmdt_chg_loc_div_cd = ComGetObjValue(formObj.dmdt_chg_loc_div_cd);
	  				var chg_seq			= ComGetObjValue(formObj.chg_seq);
	  				var chg_type		= ComGetObjValue(formObj.chg_type);
	  				
	  				var ofc_cd			= ComGetObjValue(formObj.ofc_cd);
	  				var cntr_tpsz_cd	= ComGetObjValue(formObj.cntr_tpsz_cd);
	  				var bkg_no			= ComGetObjValue(formObj.bkg_no);
	  				var bl_no			= ComGetObjValue(formObj.bl_no);
	  				var paramVal		= "?svr_id=" + svr_id + "&cntr_no=" + cntr_no + "&cntr_cyc_no=" + cntr_cyc_no
	  										+ "&dmdt_trf_cd=" + dmdt_trf_cd + "&dmdt_chg_loc_div_cd=" + dmdt_chg_loc_div_cd + "&chg_seq=" + chg_seq
	  										+ "&chg_type=" + chg_type + "&ofc_cd=" + ofc_cd + "&cntr_tpsz_cd=" + cntr_tpsz_cd + "&bkg_no=" + bkg_no + "&bl_no=" + bl_no;
	  				
	  				sUrl	= 'EES_DMT_3103.do' + paramVal;
              		sWidth	= '919';
              		sHeight	= '460';
             		break;
             		
	  			case 'btn_OTHistory':
	  				var ofc_cd			= ComGetObjValue(formObj.ofc_cd);
	  				var svr_id			= ComGetObjValue(formObj.svr_id);
	  				var cntr_no			= ComGetObjValue(formObj.cntr_no);
	  				var cntr_cyc_no		= ComGetObjValue(formObj.cntr_cyc_no);
	  				var dmdt_trf_cd		= ComGetObjValue(formObj.dmdt_trf_cd);
	  				var dmdt_chg_loc_div_cd = ComGetObjValue(formObj.dmdt_chg_loc_div_cd);
	  				var chg_seq			= ComGetObjValue(formObj.chg_seq);
	  				var paramVal		= "?ofc_cd=" + ofc_cd + "&svr_id=" + svr_id + "&cntr_no=" + cntr_no + "&cntr_cyc_no=" + cntr_cyc_no
	  										+ "&dmdt_trf_cd=" + dmdt_trf_cd + "&dmdt_chg_loc_div_cd=" + dmdt_chg_loc_div_cd + "&chg_seq=" + chg_seq;
	  				
	  				sUrl	= 'EES_DMT_3105.do' + paramVal;
              		sWidth	= '817';
              		sHeight	= '360';
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
	  				
	  			case 'btn_ExceptionInq':
	  				var scNo = ComGetObjValue(formObj.sc_no);
	  				var rfaNo = ComGetObjValue(formObj.rfa_no);
	  				
	  				if(scNo != '' && rfaNo != '') scNo = '';
	  				
	  				paramVal =	"?caller=3003"
	  							+ "&sc_no=" + scNo
	  							+ "&rfa_no=" + rfaNo
	  							+ "&trf_cd=" + ComGetObjValue(formObj.dmdt_trf_cd)
	  							;

	  				sUrl	= 'EES_DMT_2007_1.do' + paramVal;
              		sWidth	= '1020';
              		sHeight	= '780';
              		sScroll = 'yes';
	  				break;
	  				
	  		} // switch-end
  		} // with-end
  		
  		
  		if(sUrl != '') {
  			var sWinName = sUrl.substring(0, sUrl.indexOf('.do'));
  			var returnValue = ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true, sScroll);
  			
  			if(returnValue == "Y") {
 				doActionIBSheet(sheetObj, formObj, IBSEARCH);
 			}
  		}
  	}
	
	
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	
    	with(formObj){
    		var chgStsCd      = ComGetObjValue(dmdt_chg_sts_cd);
		    var deltRqstStsCd = ComGetObjValue(dmdt_delt_rqst_sts_cd);
			var cntrNo 		  = ComGetObjValue(cntr_no);
			var bkgNo 		  = ComGetObjValue(bkg_no);
			var trfCd		  = comboObjects[0].Code;
			
			switch(sAction) {
				case IBSEARCH:      //조회
					if (cntrNo == '') {
						ComShowCodeMessage('DMT00102', "CNTR No.");
						ComSetFocus(cntr_no);
						return false;
					}
					
					// 화면 Open 구분  --> call_flag=='M'enu: 메뉴 , call_flag=='P'opup: 팝업호출
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
				case IBWEBCANCEL:
					// Status가 Invoiced인 경우  오류 처리
					var chgStsCd = ComGetObjValue(dmdt_chg_sts_cd);
             		if(chgStsCd == 'I') {
             			var msg = (sAction == IBSAVE) ? 'save' : 'web cancel';
             			ComShowCodeMessage('DMT01068', msg);
            			return false;
             		}
             		
             		// Balance Charge가 없거나(General Charge) 있으면 마지막 Balance Charge만 가능
             		if(ComGetObjValue(chg_seq) != ComGetObjValue(chg_max_seq)) {
             			ComShowCodeMessage('DMT01030');
            			return false;
             		}
             		
             		// 필수입력 체크(CNTR No.)
					if(ComIsEmpty(cntr_no)) {
						ComShowCodeMessage('DMT03028', 'CNTR No.');
						ComSetFocus(cntr_no);
            			return false;
					}
					
					// 필수입력 체크(From MVMT Date)
             		if(ComIsEmpty(fm_mvmt_dt)) {
             			ComShowCodeMessage('DMT03028', 'From MVMT Date');
						ComSetFocus(fm_mvmt_dt);
            			return false;
             		}
             		
             		// 필수입력 체크(From MVMT Yard)
             		if(ComIsEmpty(fm_mvmt_yd_cd)) {
             			ComShowCodeMessage('DMT03028', 'From MVMT Yard');
						ComSetFocus(fm_mvmt_yd_cd);
            			return false;
             		}
             		
             		
             		if(sAction == IBSAVE) {
	             		/*
	             		Status가 Long Staying, Unfinished, No Charge, 또는 Error 인 경우
						To Date/Yard/Status가 필수항목이 아님 .
						셋 중 하나라도 입력되면 셋 다 필수입력항목이며, 
						셋 다 없으면 없는 상태로 Pre Cal. / Save 가능함
	             		 */
	             		if(chgStsCd == 'L' || chgStsCd == 'U' || chgStsCd == 'N' || chgStsCd == 'E') {
	             			
	             			if( !ComIsNull(to_mvmt_dt) || !ComIsNull(to_mvmt_yd_cd) || ComGetObjValue(comboObjects[1]) != '' ) {
	             				if(ComIsNull(to_mvmt_dt)) {
	             					ComShowCodeMessage('DMT02002', 'To MVMT Date');
	             					ComSetFocus(to_mvmt_dt);
	                    			return false;
	             				}
	             				
	             				if(ComIsNull(to_mvmt_yd_cd)) {
	             					ComShowCodeMessage('DMT02002', 'To MVMT Yard');
	             					ComSetFocus(to_mvmt_yd_cd);
	                    			return false;
	             				}
	             				
	             				if(ComGetObjValue(comboObjects[1]) == '') {
	             					ComShowCodeMessage('DMT02002', 'To MVMT Status');
	                    			return false;
	             				}
	             			}
	             		} else if(chgStsCd == 'F' || chgStsCd == 'C' || chgStsCd == 'D') {
	             			
	             			if(ComIsNull(to_mvmt_dt)) {
             					ComShowCodeMessage('DMT02002', 'To MVMT Date');
             					ComSetFocus(to_mvmt_dt);
                    			return false;
             				}
             				
             				if(ComIsNull(to_mvmt_yd_cd)) {
             					ComShowCodeMessage('DMT02002', 'To MVMT Yard');
             					ComSetFocus(to_mvmt_yd_cd);
                    			return false;
             				}
             				
             				if(ComGetObjValue(comboObjects[1]) == '') {
             					ComShowCodeMessage('DMT02002', 'To MVMT Status');
                    			return false;
             				}
	             		}
	             		
	             		
						if(!ComIsNull(fm_mvmt_dt) && !ComIsNull(to_mvmt_dt)) {
		             		var fmMvmtDt = ComGetObjValue(fm_mvmt_dt);
		             		var toMvmtDt = ComGetObjValue(to_mvmt_dt);
		             		
		             		/*
		          	    	 ComChkPeriod(fromDate, toDate)
		          	    	 0 : fromDate > toDate
		          	    	 1 : fromDate < toDate
		          	    	 2 : fromDate = toDate
		          	    	 */
							if(ComChkPeriod(fmMvmtDt, toMvmtDt) == 0) {
								ComShowCodeMessage('DMT01020');
		            			return false;
		            		}
							
							var toMvmtStsCd = comboObjects[1].Code;
							if(toMvmtStsCd == 'DR') {
								//User Office별 현재일자 조회(2010.04.06 수정)
								var currDt = DmtComOfficeCurrDate(sheetObj, formObj);
								if(ComChkPeriod(toMvmtDt, currDt) == 1) {
			            			ComShowCodeMessage('DMT01031', 'D/R Date', 'current date');
			            			return false;
			            		}
							}
	             		}
             		}
					
             		
					// 필수입력 체크(Remark(s))
             		if(ComIsNull(corr_rmk)) {
						ComShowCodeMessage('DMT01038');
						ComSetFocus(corr_rmk);
            			return false;
					}
					
					if(ComGetLenByByte(corr_rmk) < 10) {
						ComShowCodeMessage('COM12143', 'Remark(s)', '10');
						ComSetFocus(corr_rmk);
     					return false;
					}

					if(ComGetLenByByte(corr_rmk) > 1000) {
						ComShowCodeMessage('COM12142', 'Remark(s)', '1000');
						ComSetFocus(corr_rmk);
     					return false;
					}
					
					var deltRqstStsCd = ComGetObjValue(dmdt_delt_rqst_sts_cd);
					var cntrNo        = ComGetObjValue(cntr_no);
			  		var bkgNo		  = ComGetObjValue(bkg_no);
			  		var trfCd         = comboObjects[0].Code;
					
					if (deltRqstStsCd == 'R') {
     					ComShowCodeMessage('DMT01155');
     					return false;
     				}
     				else if (isProcessingInactive(deltRqstStsCd)) {
     					ComShowCodeMessage('DMT01176', bkgNo, cntrNo, trfCd);
     					return false;         					
     				}    
					
					// Web Cancel 실행시
					if(sAction == IBWEBCANCEL) {
						if(!ComShowCodeConfirm('DMT01037')) return false;
						
						// To 정보 초기화
						ComSetObjValue(to_mvmt_dt, "");
						ComSetObjValue(to_mvmt_yd_cd, "");
						ComSetObjValue(comboObjects[1], "");
						
						ComSetObjValue(web_cancel_flg, "Y");
						ComSetObjValue(corr_rmk, "Web Cancel: " + ComGetObjValue(corr_rmk));
					} else {	
						// Save 실행시
						ComSetObjValue(web_cancel_flg, "N");
					}
					
					// To MVMT Status Code 설정
					ComSetObjValue(to_mvmt_sts_cd, comboObjects[1].Code);
     				break;
					
				case IBCONFIRM:      //Confirm
     				if(chgStsCd != 'F') {
     					//ComShowCodeMessage('DMT03018');
     					ComBtnDisable("btn_Confirm");
     					return false;
     				}
     				// 2015-08-27 : request 처리 항목은 Confirm 불가능하도록 조건 추가
     				if (deltRqstStsCd == 'R') {	
            			ComShowCodeMessage('DMT01154');
            			return false;   
            		}
     				
     				ComSetObjValue(ibflag, "U");
             		break;
             	
             	case IBDELREQCANCEL:
//             		///////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    				CHM-201533805 [DMT] Deletion Cancel 기능 개선(기존 : 삭제된 Charge 의 상태를 원상태로 복구시킨다.) 2015.02.10
//             		Charge Deletion 요청건에 대해서 승인처리가 발생되지 않았을 경우, Charge Deletion 요청에 대해서 취소시킨다.
//             		///////////////////////////////////////////////////////////////////////////////////////////////////////////////                		
//     				if(chgStsCd != 'D') {
//     					ComBtnDisable("btn_DelReqCancel");
//     					return false;
//     				}
         			if (!isValidChgDeltRqstCancel(bkgNo, cntrNo, trfCd, deltRqstStsCd)) {
     					return false;	
         			}              		
//             		///////////////////////////////////////////////////////////////////////////////////////////////////////////////
             		if(!ComShowCodeConfirm('DMT01171', "inactivation request"))          		
             			return false;
             		
             		ComSetObjValue(ibflag, "U");
             		break;
             		
             	case IBDRCANCEL:
             	    if (deltRqstStsCd =='R'){
           	         	ComShowCodeMessage('DMT01155');
        				return;
           	        }
             	    
             	    if (isProcessingInactive(deltRqstStsCd)) {
             	    	ComShowCodeMessage('DMT01176', bkgNo, cntrNo, trfCd);
             	    	return;
             	    }
             	    
             		if(!ComShowCodeConfirm('DMT01039'))
             			return false;
             		
             		if(chgStsCd == 'I') {
             			ComShowCodeMessage('DMT01043');
             			return false;
             		}
             		break;
             		
             	case IBPRECAL:
             		var chgStsCd = ComGetObjValue(dmdt_chg_sts_cd);
             		if(chgStsCd == 'I') {
             			ComShowCodeMessage('DMT01068', 'pre cal.');
            			return false;
             		}
             		
             		// Balance Charge가 없거나(General Charge) 있으면 마지막 Balance Charge만 가능
             		if(ComGetObjValue(chg_seq) != ComGetObjValue(chg_max_seq)) {
             			ComShowCodeMessage('DMT01030');
            			return false;
             		}
             		
             		// 필수입력 체크(CNTR No.)
					if(ComIsEmpty(cntr_no)) {
						ComShowCodeMessage('DMT03028', 'CNTR No.');
						ComSetFocus(cntr_no);
            			return false;
					}
					
					// 필수입력 체크(From MVMT Date)
             		if(ComIsEmpty(fm_mvmt_dt)) {
             			ComShowCodeMessage('DMT03028', 'From MVMT Date');
						ComSetFocus(fm_mvmt_dt);
            			return false;
             		}
             		
             		// 필수입력 체크(From MVMT Yard)
             		if(ComIsEmpty(fm_mvmt_yd_cd)) {
             			ComShowCodeMessage('DMT03028', 'From MVMT Yard');
						ComSetFocus(fm_mvmt_yd_cd);
            			return false;
             		}
             		
             		/*
             		Status가 Long Staying, Unfinished, No Charge, 또는 Error 인 경우
					To Date/Yard/Status가 필수항목이 아님 .
					셋 중 하나라도 입력되면 셋 다 필수입력항목이며, 
					셋 다 없으면 없는 상태로 Pre Cal. / Save 가능함
             		 */
             		if(chgStsCd == 'L' || chgStsCd == 'U' || chgStsCd == 'N' || chgStsCd == 'E') {
             			
             			if( !ComIsNull(to_mvmt_dt) || !ComIsNull(to_mvmt_yd_cd) || ComGetObjValue(comboObjects[1]) != '' ) {
             				if(ComIsNull(to_mvmt_dt)) {
             					ComShowCodeMessage('DMT02002', 'To MVMT Date');
             					ComSetFocus(to_mvmt_dt);
                    			return false;
             				}
             				
             				if(ComIsNull(to_mvmt_yd_cd)) {
             					ComShowCodeMessage('DMT02002', 'To MVMT Yard');
             					ComSetFocus(to_mvmt_yd_cd);
                    			return false;
             				}
             				
             				if(ComGetObjValue(comboObjects[1]) == '') {
             					ComShowCodeMessage('DMT02002', 'To MVMT Status');
                    			return false;
             				}
             			}
             		} else if(chgStsCd == 'F' || chgStsCd == 'C' || chgStsCd == 'D') {
             			
             			if(ComIsNull(to_mvmt_dt)) {
         					ComShowCodeMessage('DMT02002', 'To MVMT Date');
         					ComSetFocus(to_mvmt_dt);
                			return false;
         				}
         				
         				if(ComIsNull(to_mvmt_yd_cd)) {
         					ComShowCodeMessage('DMT02002', 'To MVMT Yard');
         					ComSetFocus(to_mvmt_yd_cd);
                			return false;
         				}
         				
         				if(ComGetObjValue(comboObjects[1]) == '') {
         					ComShowCodeMessage('DMT02002', 'To MVMT Status');
                			return false;
         				}
             		}
             		
             		 
             		if(!ComIsNull(fm_mvmt_dt) && !ComIsNull(to_mvmt_dt)) {
             		
	             		//var fmMvmtDt = ComGetUnMaskedValue(fm_mvmt_dt, "ymd");
	             		//var toMvmtDt = ComGetUnMaskedValue(to_mvmt_dt, "ymd");
	             		var fmMvmtDt = ComGetObjValue(fm_mvmt_dt);
	             		var toMvmtDt = ComGetObjValue(to_mvmt_dt);
	             		
	             		/*
	          	    	 ComChkPeriod(fromDate, toDate)
	          	    	 0 : fromDate > toDate
	          	    	 1 : fromDate < toDate
	          	    	 2 : fromDate = toDate
	          	    	 */
						if(ComChkPeriod(fmMvmtDt, toMvmtDt) == 0) {
							ComShowCodeMessage('DMT01020');
	            			return false;
	            		}
						
						var toMvmtStsCd = comboObjects[1].Code;
						if(toMvmtStsCd == 'DR') {
							//User Office별 현재일자 조회(2010.04.06 수정)
							var currDt = DmtComOfficeCurrDate(sheetObj, formObj);
							if(ComChkPeriod(toMvmtDt, currDt) == 1) {
		            			ComShowCodeMessage('DMT01031', 'D/R Date', 'current date');
		            			return false;
		            		}
						}
             		}
             		
             		// To MVMT Status Code 설정
					ComSetObjValue(to_mvmt_sts_cd, comboObjects[1].Code);
					
             		break;
             		
			} // switch - end	
    	} // with - end

        return true;
    }
    
    

	/* 개발자 작업  끝 */