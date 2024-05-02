/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_3009.js
*@FileTitle : Office Transfer History
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.07.14 황효근
* 1.0 Creation
* 2010.10.01 김태균 [CHM-201006227-01] [EES-DMT] [DMDT] Office Transfer Inquiry 화면 보완
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
     * @class EES_DMT_3009 : EES_DMT_3009 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_3009() {
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
		     	case "btns_calendar": //달력 버튼
	          		if(srcObj.style.cursor == "hand") {
						var cal = new ComCalendarFromTo();
						cal.select(formObj.fm_cre_dt, formObj.to_cre_dt, 'yyyy-MM-dd');
	          		}
					break;

				case "btn_Retrieve":
					doActionIBSheet(sheetObj,formObj,IBSEARCH);
					break;

				case "btn_New":
					//ComResetAll();
					doInit();	// 조회조건 초기화
					break; 
					
				case "btn_DownExcel":
					sheetObj.SpeedDown2Excel(-1, false, false, '', '', false, false, '', false, 'chk');
 					break;
		     
				case "btn_ByBKG":
				case "btn_ByCNTR":
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
    	 for(var i=0;i<sheetObjects.length;i++){
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
		//sheetObj.WaitImageVisible = false;
		
		ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.rhq_ofc_cd));
		
		// From Office
		doActionIBCombo(sheetObj, formObj, comboObjects[0], COMMAND08);
		
		// To Office
		doActionIBCombo(sheetObj, formObj, comboObjects[1], COMMAND08);
		
		// Tariff
		doActionIBCombo(sheetObj, formObj, comboObjects[2], SEARCHLIST);
		
	    // 조회조건 초기화
	    doInit();
	    //sheetObj.WaitImageVisible = true; 
 	}
	
	
 	/*
	 * INIT SETTING
	 */
	function doInit() {
		sheetObjects[0].RemoveAll();
		ComSetObjValue(document.form.cond_type, "date");
		
		//조회조건 부분적으로 활성화/비활성화  처리
		doEnableCondObj("date");
	}
     
     
	function initControl() {
		axon_event.addListenerForm  ('blur',	'obj_blur',		document.form, 'cond_type'); //- 포커스 나갈때
		axon_event.addListenerFormat('focus',	'obj_focus',	document.form); //- 포커스 들어갈때
		axon_event.addListenerFormat('keypress','obj_keypress', document.form); //- 키보드 입력할때
		axon_event.addListener('click',		'condType_click',	'cond_type');
		axon_event.addListener('keydown',	'ComKeyEnter',		'form');
		axon_event.addListener('mouseover', 'btn_mouseover',	'OTDate');	// onMouseover 이벤트(말풍선)
		axon_event.addListener('mouseout',	'btn_mouseout',		'OTDate');	// onMouseout 이벤트(말풍선)
	}
	
	
	// 'by ETA' onMouseover 이벤트  (버튼 말풍선  보여줌)
	function btn_mouseover() {
		var bak = 'lightyellow';
		var msg = 'Office Transferred Date';
		var content =	"<TABLE BORDER=0 CELLPADDING=1 CELLSPACING=0 BGCOLOR=#000000><TR><TD><TABLE WIDTH=100% BORDER=0 CELLPADDING=2 CELLSPACING=0 BGCOLOR="+bak
						+"><TR><TD style=font-family:tahoma;font-size:9pt;>"+msg+"</TD></TR></TABLE></TD></TR></TABLE>"; 
    	var x = event.x+document.body.scrollLeft;
		var y = event.y+document.body.scrollTop;
		var skn = document.all("topdeck").style;
		skn.left = x+10;
		skn.top  = y-20;
		document.all("topdeck").innerHTML = content;
		skn.visibility = 'visible';
     }
     
     // 'by ETA' onMouseout 이벤트  (버튼 말풍선 숨김)
     function btn_mouseout() {
    	 var skn = document.all("topdeck").style;
    	 skn.visibility = 'hidden';
     }

     
	/*
	 * From/To Office의 RHQ Select Object OnChange 이벤트 전달 
	 */
	function rhp_change() {
		var obj = event.srcElement;
		doRhqChange(obj);
	}
	
	/*
	 * From/To Office의 RHQ Select Object OnChange 이벤트 처리
	 */
	function doRhqChange(obj) {
		var formObj = document.form;
		
		// From/To Office RHQ의 선택된 항목 Text값(필요로 하는 값이 Text값)
		var rhqCd = ComGetObjValue(obj);
		ComSetObjValue(formObj.ofc_cd, rhqCd);
		
		// 선택된 RHQ에 속하는 Office Code 리스트를 설정할 IBMultiCombo Object 지정
		var comboObj = (obj.name == 'fm_rhq') ? comboObjects[0] : comboObjects[1];
		comboObj.RemoveAll();
		
		doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND08);
		comboObj.Code = 'All';
	}
	
	
	//포커스가 나갈 때
    function obj_blur(){
        //입력Validation 확인하기 + 마스크구분자 넣기
		 var obj = event.srcElement;
		 if(obj.name == 'bkg_no' || obj.name == 'bl_no' || obj.name == 'cntr_no') {
		 } else {
			 ComChkObjValid(obj);
		 }
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
      
	/*
	 * 검색구분(Date/CNTR) 선택 라디오 버튼 클릭 이벤트 처리 함수로 전달
	 */
	function condType_click() {
		doEnableCondObj(event.srcElement.value);
	}
	
      
	/*
	 * 검색구분(Date/CNTR) 선택 라디오 버튼 클릭 이벤트 처리
	 */
	function doEnableCondObj(condType) {
     	 var formObj = document.form;
     	 
     	 with (formObj) {
 	    	 switch(condType){
 	    	 	case "date":
 	    	 		// ******** 활성화 **********
 	    	 		// O/T Date
 	    	 		ComEnableManyObjects(true, fm_cre_dt, to_cre_dt, btns_calendar);
 	 	    		setClassManyObjects('input1', fm_cre_dt, to_cre_dt);
 	 	    		
 	 	    		// 일자 초기화 
 	 	    		var fmCreDt = ComGetDateAdd(null, "M", -1);
 	 	    		//var toCreDt = ComGetNowInfo();
 	 	    		var toCreDt = DmtComOfficeCurrDate(sheetObjects[0], formObj);
 	 	    		
 	 	    		ComSetObjValue(fm_cre_dt, fmCreDt);
 	 	    		ComSetObjValue(to_cre_dt, toCreDt);
 	 	    		
 	    	 		//ComEnableManyObjects(true, fm_rhq, to_rhq);
 	    	 		
 	    	 		// From RHQ가  Default값('All')이 아니면,
 	    	 		// Default값으로 초기화하고, 모든 RHQ에 속하는 Office Code를 조회해온다.
 	    	 		/*
 	    	 		if(fm_rhq.value != '') {
 	    	 			ComClearObject(fm_rhq);
 	    	 			doRhqChange(fm_rhq);
 	    	 		}*/
 	    	 		
 	    	 		// To RHQ가 로그인 점소 Office의 RHQ가 아니면,
 	    	 		// 로그인 RHQ로 초기화하고, 해당 RHQ에 속하는 Office Code를 조회해온다.
 	    	 		/*
 	    	 		if(ComGetObjValue(to_rhq) != rhq_ofc_cd.value) {
 	    	 			ComSetObjValue(to_rhq, rhq_ofc_cd.value);
 	    	 			doRhqChange(to_rhq);
 	    	 		}*/
 	    	 		
 	    	 		initComboValue_fm_ofc();
 	    	 		initComboValue_to_ofc();
 	    	 		initComboValue_tariff_type();
 	    	 		
 	    	 		// ******** 비활성화 **********
 	    	 		ComEnableManyObjects(false, bkg_no, bl_no, cntr_no);	//CNTR Disable
 	    	 		setClassManyObjects('input2', bkg_no, bl_no, cntr_no);	//비활성화 class (input2)
 	    	 		ComClearManyObjects(bkg_no, bl_no, cntr_no);
 	    	 		
 	    	 		// MULTI 입력 팝업창 아이콘  비활성
 	    	 		ComEnableManyObjects(false, btns_multisearch1, btns_multisearch2, btns_multisearch3);
 	    	 		break;
 	    	 	
 	    	 	case "cntr":
 	    	 		// ******** 비활성화 **********
 	    	 		// O/T Date
 	    	 		ComEnableManyObjects(false, fm_cre_dt, to_cre_dt, btns_calendar);
 	 	    		setClassManyObjects('input2', fm_cre_dt, to_cre_dt);
 	 	    		ComClearManyObjects(fm_cre_dt, to_cre_dt);
 	 	    		
 	 	    		ComSetObjValue(comboObjects[0], "");
 	 	    		ComSetObjValue(comboObjects[1], "");
 	 	    		ComSetObjValue(comboObjects[2], "");
 	 	    		
 	    	 		comboObjects[0].Enable = false;
 	    	 		comboObjects[1].Enable = false;
 	    	 		comboObjects[2].Enable = false;
 	    	 		
 	    	 		// ******** 활성화 **********
 	    	 		ComEnableManyObjects(true, bkg_no, bl_no, cntr_no);		//CNTR
 	    	 		setClassManyObjects('input1', bkg_no, bl_no, cntr_no);	//비활성화 class (input2)
 	    	 		
 	    	 		// MULTI 입력 팝업창 아이콘 활성
 	    	 		ComEnableManyObjects(true, btns_multisearch1, btns_multisearch2, btns_multisearch3);
 	    	 		break;
 	    	 }
     	 }
	}

	
	/*
	 * HTML Element ClassName 설정 함수
	 */
	function setClassManyObjects(clsNm, objs) {
		try {
              var args = arguments;
              if (args.length < 2) return;
              
              for(var i=1; i<args.length; i++) {
                  if (args[i].tagName != undefined) {
                 	 args[i].className = clsNm;
                  }
              }
		} catch(err) { ComFuncErrMsg(err.message); }
	}
	
	/*
	 * HTML Select Object의 선택 아이템을   특정 값(Text)의 항목으로 저정
	 */
	function setSelObjText(obj, sText) {
		for (var idx = 0; idx < obj.length; idx++) {
	        if (obj[idx].text == sText) {
	            obj[idx].selected = true;
	            break;
	        }
	    }
	}
	
    	
	// IBMultiCombo From Office 초기화
	function initComboValue_fm_ofc() {
		comboObjects[0].Enable = true;
		ComSetObjValue(comboObjects[0], "");
	}
	
	// IBMultiCombo To Office Type 초기화
	function initComboValue_to_ofc() {
		comboObjects[1].Enable = true;
		ComSetObjValue(comboObjects[1], ComGetObjValue(document.form.usr_ofc_cd));
	}
	
	// IBMultiCombo Tariff Type 초기화
	function initComboValue_tariff_type() {
		comboObjects[2].Enable = true;
		ComSetObjValue(comboObjects[2], "All,DMIF,DTIC,DMOF,DTOC,CTIC,CTOC");
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
	                 InitRowInfo( 1, 1, 7, 100);
	
	                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                 InitHeadMode(true, true, false, true, false, false);
	
	                 var HeadTitle1 = " |SEL|Seq.|STS|A/R|CNTR No.|T/S|Tariff|From|To|Reason";
	                 HeadTitle1 += "|BKG No.|B/L No.|VVD CD|POR|POL|POD|DEL|Cur.|Billable AMT|G/B|O/T Date|User OFC|User Name|svr_id|cntr_cyc_no|dmdt_chg_loc_div_cd|chg_seq|ofc_rhq_cd";
					
	                 var headCount = ComCountHeadTitle(HeadTitle1);
	                 
	                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                 InitColumnInfo(headCount, 0, 0, true);
	                 
	                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                 InitHeadRow(0, HeadTitle1, true);
	
	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,	daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtRadioCheck,	30,	daCenter,	false,	"chk");
					InitDataProperty(0, cnt++ , dtSeq,	   	40,		daCenter,	false,	"seq");
					InitDataProperty(0, cnt++ , dtData,   	40,		daCenter,	false,	"dmdt_chg_sts_cd",	false,	"", dfNone,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	40,		daCenter,	false,	"dmdt_ar_if_cd",	false,	"", dfNone,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	95,		daCenter,	false,	"cntr_no",			false,	"", dfNone,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	40,		daCenter,	false,	"cntr_tpsz_cd",		false,	"", dfNone,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	75,		daCenter,	false,	"dmdt_trf_cd",		false,	"", dfNone,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	80,		daCenter,	false,	"fm_ofc_cd",		false,	"", dfNone,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	80,		daCenter,	false,	"to_ofc_cd",		false,	"", dfNone,		0,	false,	true);
					
					InitDataProperty(0, cnt++ , dtData,   	230,	daLeft,		false,	"trns_rsn",			false,	"", dfNone,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	100,	daCenter,	false,	"bkg_no",			false,	"", dfNone,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	100,	daCenter,	false,	"bl_no",			false,	"", dfNone,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	100,	daCenter,	false,	"vvd_cd",			false,	"", dfNone,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	80,		daCenter,	false,	"por_cd",			false,	"", dfNone,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	80,		daCenter,	false,	"pol_cd",			false,	"", dfNone,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	80,		daCenter,	false,	"pod_cd",			false,	"", dfNone,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	80,		daCenter,	false,	"del_cd",			false,	"", dfNone,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	false,	"bzc_trf_curr_cd",	false,	"",	dfNone,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	100,	daRight,	true,	"bil_amt",			false,	"",	dfNullFloat,2,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	40,		daCenter,	false,	"chg_type",			false,	"", dfNone,		0,	false,	true, -1, false, true, "General/Balance Charge Type");
					
					InitDataProperty(0, cnt++ , dtData,   	90,		daCenter,	false,	"cre_dt",			false,	"", dfDateYmd,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	90,		daCenter,	false,	"cre_ofc_cd",		false,	"", dfNone,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	80,		daCenter,	false,	"usr_nm",				false,	"", dfNone,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtHidden,    0, 	daCenter,	true,	"svr_id",				false,  "",	dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    0, 	daCenter,	true,	"cntr_cyc_no",			false,  "",	dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    0, 	daCenter,	true,	"dmdt_chg_loc_div_cd",	false,	"",	dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    0, 	daCenter,	true,	"chg_seq",				false,  "",	dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    0, 	daCenter,	true,	"ofc_rhq_cd",			false,  "",	dfNone,		0,	false,  false);
					
					// 좌측 틀고정 컬럼 설정
					FrozenCols = SaveNameCol("cntr_tpsz_cd");
					ToolTipOption="balloon:true;width:50;";
					Ellipsis = true;
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
   	    	case "fm_ofc":
   	    	case "to_ofc":
   	    		with (comboObj) {
   					MultiSelect = false;
   					UseAutoComplete = true;
   					SetColAlign("left");
  					SetColWidth("60");
  					DropHeight = 160;
					//ColBackColor(0) = "#CCFFFD";
					//BackColor = "#CCFFFD";
					
					ValidChar(2);	// 영어대문자 사용
					MaxLength = 6;
   		    	}
   				break;
   				
   	    	case "tariff_type":
   	    		with (comboObj) { 
   					MultiSelect = true;
					SetColAlign("left|left");        
					SetColWidth("45|310");
					DropHeight = 160;
					//ColBackColor(0) = "#CCFFFD";
  					//ColBackColor(1) = "#CCFFFD";
  					//BackColor = "#CCFFFD";
   		    	}
   				break;
   	     }
   	}
   	
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
         
            case IBSEARCH:      //조회
            	if(!validateForm(sheetObj,formObj,sAction)) return;
            	
	            sheetObj.WaitImageVisible=false;
	        	ComOpenWait(true);
	        	
            	formObj.f_cmd.value = SEARCH;
            	sheetObj.DoSearch("EES_DMT_3009GS.do", FormQueryString(formObj));
            	ComOpenWait(false);
            	break;
         }
     }

	
	function doActionIBCombo(sheetObj, formObj, comboObj, formCmd, srcObj) {
		sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;
 
		formObj.f_cmd.value = formCmd;
		var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
 
		switch(comboObj.id) {
			case "fm_ofc":
			case "to_ofc":
				var subOfcCds = ComGetEtcData(sXml, "OFC_CD");
				if(subOfcCds != undefined && subOfcCds != '') {
					var comboItems = subOfcCds.split(",");
					addComboItem(comboObj,comboItems);
				}
	    	    break;
	        	
	        case "tariff_type":
		 		// Tariff type comboList
				var data = ComGetEtcData(sXml, COMMON_TARIFF_CD);
				if (data != undefined && data != '') {
					var comboItems = data.split(ROWMARK);
					addComboItem(comboObj,comboItems);
					comboItem = comboItems[0].split(FIELDMARK);
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
 			case "fm_ofc":
 			case "to_ofc":
		  		comboObj.InsertItem(0, "", "");
		  		for (var i = 0 ; i < comboItems.length ; i++) {
		  	   		//var comboItem = comboItems[i].split(FIELDMARK);
		  			comboObj.InsertItem(i+1, comboItems[i], comboItems[i]);
		  	   	}
		  		break;
 				
 			case "tariff_type":
		  		comboObj.InsertItem(0, "All|All", "All");
		  		for (var i = 0 ; i < comboItems.length ; i++) {
		  	   		var comboItem = comboItems[i].split(FIELDMARK);
		  				comboObj.InsertItem(i+1, comboItem[0] + "|" + comboItem[1], comboItem[0]);
		  	   	}
		  		break;
 		}
 	}
	
 	
 	// 멀티콤보 클릭 이벤트
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
 	
	
	/**
	 * 선택된 Row의 해당정보를 EES_DMT_3003.do 페이지로 전달해서 팝업으로 호출한다.
	 */
	function sheet1_OnDblClick(sheetObj,Row,Col) {
		if(sheetObj.ColSaveName(Col) == "chk") return;
		
		doProcessPopup('btn_ByCNTR');
	}
	
	 
	/*
	 * Grid에서 말풍선 처리
	 */
	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
		with(sheetObj){
			Row = MouseRow;
			Col = MouseCol;
			if (Row > 0) {
				var ttText='';
				var colSaveNm = ColSaveName(Col);
				
				if(colSaveNm == 'trns_rsn') {	// Remark 전체내용을 보여줌
					var corrRmk = CellValue(Row, "trns_rsn");
					if(corrRmk == '') return;
					ttText = corrRmk;
				}
				MouseToolTipText = ttText;
			} else {
				MouseToolTipText = "";
			}
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
    
	
	/*
  	 * 각 팝업 호출 처리
  	 */
  	function doProcessPopup(srcName) {
  		var formObj = document.form;
  		var sheetObj = sheetObjects[0];
  		var sUrl = '';
  		var sWidth	 = '';
  		var sHeight	 = '';
  		
  		with(sheetObj) {
	  		switch(srcName) {
		  		case 'm_bkg_no':	// BKG No. 멀티입력 팝업 호출
	  			case 'm_bl_no':		// B/L No. 멀티입력 팝업 호출
	  			case 'm_cntr_no':	// CNTR No. 멀티입력 팝업 호출
		  			var flag = ComReplaceStr(srcName,"m_","");
		  			
			  		// 멀티입력 팝업 타이틀 세부 내용 지정
	  				var returntitle = '';
	  				if(flag == 'bkg_no')
	  					returntitle = 'BKG No.';
	  				else if(flag == 'bl_no')
	  					returntitle = 'B/L No.';
	  				else if(flag == 'cntr_no')
	  					returntitle = 'CNTR No.';
	  				
	  				var param = "?returnval=" + flag + "&returntitle=" + returntitle;
	  				ComOpenPopup('EES_DMT_MULTI.do'+param, 400, 380, 'getDmt_Multi', '1,0,1,1,1,1,1,1,1,1,1,1', true);
	  				return;
					break;
	  		
		  		case 'btn_ByBKG':
		  			var chkRow = SelectRow;
		  			
		  			var bkgNo		= CellValue(chkRow , "bkg_no");
		  			var blNo		= CellValue(chkRow , "bl_no");
		  			var trfCd		= CellValue(chkRow , "dmdt_trf_cd");
		  			var chgStsCd	= CellValue(chkRow , "dmdt_chg_sts_cd");
		  			var paramVal	= "?call_flag=P"
		  								+ "&bkg_no=" + bkgNo
		  								+ "&bl_no=" + blNo
		  								+ "&dmdt_trf_cd=" + trfCd
		  								+ "&dmdt_chg_sts_cd=" + chgStsCd;
		  			
		  			// 동일한 RHQ OFC인 경우
		  			if(ComGetObjValue(formObj.rhq_ofc_cd) == CellValue(chkRow , "ofc_rhq_cd"))
		  				sUrl = 'EES_DMT_3002P.do';
		  			else
		  				sUrl = 'EES_DMT_3005P.do';
		  			
	  				sUrl	= sUrl + paramVal;
	          		sWidth	= '1010';
	          		sHeight	= '680';
	  				break;
	  		
		  		case 'btn_ByCNTR':
		  			var chkRow = SelectRow;
		  			
		  			var svrId		= CellValue(chkRow , "svr_id");
		  			var cntrNo		= CellValue(chkRow , "cntr_no");
		  			var cntrCycNo	= CellValue(chkRow , "cntr_cyc_no");
		  			var trfCd		= CellValue(chkRow , "dmdt_trf_cd");
		  			var chgLocDivCd	= CellValue(chkRow , "dmdt_chg_loc_div_cd");
		  			var chgSeq		= CellValue(chkRow , "chg_seq");
		  			var paramVal	= "?call_flag=P"
			  							+ "&svr_id=" + svrId
			  							+ "&cntr_no=" + cntrNo
			  							+ "&cntr_cyc_no=" + cntrCycNo
			  							+ "&dmdt_trf_cd=" + trfCd 
			  							+ "&dmdt_chg_loc_div_cd=" + chgLocDivCd
			  							+ "&chg_seq=" + chgSeq;
		  			
		  			// 동일한 RHQ OFC인 경우
		  			if(ComGetObjValue(formObj.rhq_ofc_cd) == CellValue(chkRow , "ofc_rhq_cd"))
		  				sUrl = 'EES_DMT_3003P.do';
		  			else
		  				sUrl = 'EES_DMT_3006P.do';
		  			
	  				sUrl	= sUrl + paramVal;
	          		sWidth	= '1010';
	          		sHeight	= '680';
	  				break;
	  		}
  		}
  		
  		if(sUrl != '') {
  			var sWinName = sUrl.substring(0, sUrl.indexOf('.do'));
  			var returnValue = ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true);
  			
  			if(returnValue == "Y") {
 				doActionIBSheet(sheetObj, document.form, IBSEARCH);
 			}
  		}
  	}


     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
        	 
        	 var condType = ComGetObjValue(cond_type);
        	 
        	 //******************** Date 조건  ************************
        	 if(condType == 'date') {
      			if(!ComIsDate(fm_cre_dt)) {
      				ComAlertFocus(fm_cre_dt, ComGetMsg('COM12134', 'O/T From Date'));
      				return false;
      			}
      			if(!ComIsDate(to_cre_dt)) {
      				ComAlertFocus(to_cre_dt, ComGetMsg('COM12134', 'O/T To Date'));
      				return false;
      			}
      			
      			var startDate = ComGetUnMaskedValue(fm_cre_dt, 'ymd');
      			var endDate = ComGetUnMaskedValue(to_cre_dt, 'ymd');
				//기간체크
      			if (startDate > endDate) {
					ComShowCodeMessage("COM12133", "'O/T From Date'", "'O/T To Date'", "earlier");
					return false;
				}
      			
      			/*
      			var fmRHQ = ComGetObjValue(fm_rhq);
      			var fmOfcCd = comboObjects[0].Code;
      			if(fmRHQ != '' && fmOfcCd == '') {
      				ComShowCodeMessage('COM12113', "From Office");
          			return false;
      			}
      			
      			var toRHQ = ComGetObjValue(to_rhq);
      			var toOfcCd = comboObjects[1].Code;
      			if(toRHQ != '' && toOfcCd == '') {
      				ComShowCodeMessage('COM12113', "To Office");
          			return false;
      			}
          		
          		// From Office
          		if(fmRHQ == '') {
          			ComSetObjValue(fm_ofc_cd, "");
          		} else {
          			ComSetObjValue(fm_ofc_cd, fmOfcCd);
          		}
          		
          		// To Office
          		if(toRHQ == '') {
          			ComSetObjValue(to_ofc_cd, "");
          		} else {
         			ComSetObjValue(to_ofc_cd, toOfcCd);
          		}
          		*/
          		
          		var fmOfcCd = comboObjects[0].Text;
          		var toOfcCd = comboObjects[1].Text;
          		
      			ComSetObjValue(fm_ofc_cd, fmOfcCd);
      			ComSetObjValue(to_ofc_cd, toOfcCd);
      			
      			var trfCd = comboObjects[2].Code;
          		if(trfCd.indexOf('All,') != -1) {
          			//trfCd = ComReplaceStr(trfCd, 'All,', '');
          			trfCd = '';
          		}
          		
          		ComSetObjValue(dmdt_trf_cd, trfCd);
      			
      		} else {
      			//******************** CNTR 조건  ************************
  				if(ComIsNull(bkg_no) && ComIsNull(bl_no) && ComIsNull(cntr_no)) {
      				ComShowCodeMessage('DMT00102', 'BKG No. or B/L No. or CNTR No.');
          			return false;
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
      			
      			var cntrNo = ComGetObjValue(cntr_no);
      			if(cntrNo != '') {
      				var arrCntrNo = cntrNo.split(',');
      				for(var i=0; i<arrCntrNo.length; i++) {
      					if(ComChkLen(arrCntrNo[i], 14) == 0) {	// 길이 초과
      						ComAlertFocus(cntr_no, ComGetMsg('COM12173', 'CNTR No.', '14'));
	                 			return false;
      					}
      				}
      			}
      			
      		} // if-else end
        	 
         } // with end

         return true;
     }
    


	/* 개발자 작업  끝 */