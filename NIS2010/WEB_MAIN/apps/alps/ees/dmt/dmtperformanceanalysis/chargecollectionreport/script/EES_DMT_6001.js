/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_6001.js
*@FileTitle : Current Collection Status by Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.09.18 황효근
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
     * @class EES_DMT_6001 : EES_DMT_6001 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_6001() {
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
    

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		var sheetObj = sheetObjects[0];
		var formObj = document.form;

    	try {
    		var srcObj = window.event.srcElement;
    		var srcName = srcObj.getAttribute("name");

				switch(srcName) {
					case "btns_calendar":
						if(srcObj.style.cursor == "hand") {
		                    var cal = new ComCalendarFromTo();
		                    cal.select(formObj.fm_dt, formObj.to_dt, 'yyyy-MM-dd');
						}
	                    break;

					case "btn_Retrieve":
						doActionIBSheet(sheetObj,formObj,IBSEARCH);
						break;

					case "btn_New":
						doInit();
						break;

					case "btn_Minimize":
						var schCondDiv = document.getElementById("sch_cond_div");
	 					if(schCondDiv.style.display == 'block') {
	 						schCondDiv.style.display = 'none';
	 						sheetObj.style.height = sheetObj.GetSheetHeight(23);	//sheetObj.GetSheetHeight(23); //300+145;
	 					} else {
	 						schCondDiv.style.display = 'block';
	 						sheetObj.style.height = sheetObj.GetSheetHeight(17);	//sheetObj.GetSheetHeight(14); //300;
	 					}
	 					break;

					case "btn_Detail":
					case "btn_DetailA":
					case "btn_DetailB":
					case "btn_DetailC":
						doProcessPopup(srcName);
						break;

					case "btn_DownExcel":
						sheetObj.SpeedDown2Excel(-1, false, false, '', '', false, false, '', false);
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
    
    
	// 이벤트 처리 함수 선언
	function initControl() {
		axon_event.addListener('blur',	'obj_blur',	'to_mvmt_mon', 'fm_dt', 'to_dt'); //- 포커스 나갈때
 		axon_event.addListener('focus',	'obj_focus', 'to_mvmt_mon', 'fm_dt', 'to_dt'); //- 포커스 들어갈때
 		axon_event.addListenerFormat('keypress','obj_keypress', document.form); //- 키보드 입력할때
 		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
 		axon_event.addListener('mouseover', 'obj_mouseover',	'btn_DetailA', 'btn_DetailB', 'btn_DetailC');	// 말풍선 표시
		axon_event.addListener('mouseout',	'obj_mouseout',		'btn_DetailA', 'btn_DetailB', 'btn_DetailC');	// 말풍선 숨김
 		axon_event.addListener('click', 'ofc_flg_click', 'ofc_flg');
 		axon_event.addListener('click', 'dt_flg_click', 'dt_flg');
   		/*==============================================================================================================
	 		2017.07.04 : 2017.CSR #1386: [DMT] Report 내 조회 기능 추가 요청
	 		Monthly Invoiced & Collection by Office 메뉴에 존재하는 'Incl. CNTR Column' 체크 유/무 기능을 동일하게 추가 요청 드립니다.
    	(Summary Report by Customer 에 존재하는 Incl. D/C column과는 별개)
		===============================================================================================================*/  		
 		axon_event.addListener('click', 'incl_cntr_click', 'incl_cntr');
	}
	
	
	// 화면 초기화 설정
	function doInit() {
		var formObj = document.form;
		
		ComResetAll();
		
		// To MVMT Date 검색 조건 초기화
		dt_flg_click();
		
		// DEM/DET Office 검색 조건 초기화 (Default: RHQ)
		ofc_flg_click();
	}
	
	
	// MouseOver 이벤트 처리(말풍선  보여줌)
 	function obj_mouseover() {
 		var msg = '';
 		var x = event.x+document.body.scrollLeft;
 		var y = event.y+document.body.scrollTop;
 		x = x-255;
		y = y-20;
		
     	switch(event.srcElement.id) {
      		case 'btn_DetailA':
      			msg = "Detail for Incurred CNTR not A/R interfaced";
      			break;
      			
      		case 'btn_DetailB':
      			msg = "Detail for Billable2  CNTR not A/R interfaced";
      			break;
      			
      		case 'btn_DetailC':
      			msg = "Detail for Invoiced CNTR not A/R interfaced";
      			break;
     	}
 		
 		var content =	"<TABLE BORDER=0 CELLPADDING=1 CELLSPACING=0 BGCOLOR=#000000><TR><TD><TABLE WIDTH=100% BORDER=0 CELLPADDING=2 CELLSPACING=0 BGCOLOR=lightyellow"
 						+"><TR><TD style=font-family:tahoma;font-size:9pt;>"+msg+"</TD></TR></TABLE></TD></TR></TABLE>"; 
 		var skn = document.all("topdeck").style;
 		skn.left = x;
 		skn.top  = y;
 		document.all("topdeck").innerHTML = content;
 		skn.visibility = 'visible';
	}
      
	// Mouse Out 이벤트  처리 (말풍선 숨김)
	function obj_mouseout() {
		var skn = document.all("topdeck").style;
		skn.visibility = 'hidden';
	}
    
	
	function dt_flg_click() {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		
		with(formObj) {
			var dtFlg = ComGetObjValue(dt_flg);
			var ofcCurrDate = DmtComOfficeCurrDate(sheetObj, formObj);
			
			if(dtFlg == 'M') {
				ComEnableObject(to_mvmt_mon, true);
				ComEnableManyObjects(false, fm_dt, to_dt, btns_calendar);
				DmtComSetClassManyObjects('input1', to_mvmt_mon);
    	 		DmtComSetClassManyObjects('input2', fm_dt, to_dt);
				
    	 		//ComSetObjValue(to_mvmt_mon, ComGetNowInfo("ym"));
    	 		ComSetObjValue(to_mvmt_mon, ofcCurrDate.substring(0, 7));
				ComClearManyObjects(fm_dt, to_dt);
			} else {
				ComEnableObject(to_mvmt_mon, false);
				ComEnableManyObjects(true, fm_dt, to_dt, btns_calendar);
				DmtComSetClassManyObjects('input1', fm_dt, to_dt);
    	 		DmtComSetClassManyObjects('input2', to_mvmt_mon);
				
				// 조회기간(Period) 설정
                //=========================================================================================
                // 변경일자 : 2017.10.16 
                // 변경내용 : Period 를 12개월로 변경함.
                // 변경사유 : CSR #2236 [DMT] Current Collection Status by Office 메뉴 내 추가 개발 요청 건
                //==========================================================================================   	 		
				var fmDt = ComGetDateAdd(ofcCurrDate, "M", -1 * REPORT_INQUIRY_PERIOD);	
				var toDt = ofcCurrDate;
				ComSetObjValue(fm_dt, fmDt);
				ComSetObjValue(to_dt, toDt);
				
				ComClearManyObjects(to_mvmt_mon);
			}
		} // with-end
	}
	
	
	// DEM/DET Office Radio Button 클릭 이벤트 처리
	function ofc_flg_click() {
		var formObj = document.form;
		var ofcFlg = ComGetObjValue(formObj.ofc_flg);
		var comboObj = comboObjects[1];
		
		if(ofcFlg == 'R') {
			// RHQ
			doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND06);
			ComEnableObject(formObj.chk_sub_ofc, false);
			ComClearObject(formObj.chk_sub_ofc);
			
			// RHQ 선택시 로그인 지역의  RHQ Office Code를 Default.(SELHO는 All)
			var usrRhqOfcCd = ComGetObjValue(formObj.usr_rhq_ofc_cd);
	   		if(usrRhqOfcCd == 'SELHO')
	   			usrRhqOfcCd = "All";
	   		
	   		ComSetObjValue(comboObj, usrRhqOfcCd);
	   		ComEnableObject(formObj.grp_flg, true);
		} else {
			// Office
			doActionIBCombo(sheetObjects[0], formObj, comboObj, SEARCHLIST02);
			ComEnableObject(formObj.chk_sub_ofc, true);
			ComEnableObject(formObj.grp_flg, false);
			formObj.grp_flg.className = 'input2';
		}
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
         	/*
    	 	case "engup":
		    	// 영문대+숫자 
         		ComKeyOnlyAlphabet('uppernum', ',');
		        break;
         	case "int":
    	        //숫자 만입력하기
    	        ComKeyOnlyNumber(event.srcElement);
    	        break;
         	*/
         	default:
	         	// 숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber(event.srcElement);
    	 }
     }

	
	/*
	 * 다중선택된 DEM/DET Office의 하위점소(Sub Office) 조회기능 
	 */
	function doInclSubOfc() {
		var formObj = document.form;
		var comboObj = comboObjects[1];
		
		if(formObj.chk_sub_ofc.checked) {	// Sub Office 포함
			if( ComIsEmpty(comboObj.Code) ) {
				ComShowCodeMessage('COM12113', "Office");
				formObj.chk_sub_ofc.checked = false;
				return;
			}
			formObj.ofc_cd.value = ComGetObjValue(comboObj);
			formObj.tmp_ofc_cd.value = ComGetObjValue(comboObj);
			doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND01);
			
		} else {
			ComSetObjValue(comboObj, formObj.tmp_ofc_cd.value);
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

            case "sheet1":
                with (sheetObj) {
                    // 높이 설정
                    style.height = GetSheetHeight(17); //260;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);

					var HeadTitle1 = " ||Seq.|Year|Month|RHQ|Office|Tariff|Cur.|Incurred|Incurred|CMDT Exception|CMDT Exception|Exception|Exception|Billable1|Billable1|Discount|Discount|Billable2|Billable2|Invoiced|Invoiced|A/R Interfaced|A/R Interfaced|Collected in ERP|Collected in ERP|Collection AMT|Collection AMT|Collection AMT|Collection AMT|CTRL OFC|";
					var HeadTitle2 = " ||Seq.|Year|Month|RHQ|Office|Tariff|Cur.|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|vs Incurred(A) (%)|vs Billable1(B) (%)|vs Billable2(C) (%)|vs Invoiced(D) (%)|CTRL OFC|";
					//var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(33, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false, false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,	cnt++ ,	dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
                    InitDataProperty(0,	cnt++ ,	dtCheckBox,		35,		daCenter,	true,	"chk",				false,		"",		dfNone,			0,	true);
                    InitDataProperty(0,	cnt++ ,	dtSeq,			35,		daCenter,	true,	"seq");
                    
 					InitDataProperty(0, cnt++ , dtData,    		50,		daCenter,   true,	"year",		   		false,		"",		dfNone,			0,	false,	false);
 					InitDataProperty(0, cnt++ , dtData,    		45,		daCenter,   true,	"month",   			false,		"",		dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,    		50,		daCenter,   true,	"ofc_rhq_cd",  		false,		"",		dfNone,			0,	false,	false);
                    
                    InitDataProperty(0,	cnt++ ,	dtData,			50,		daCenter,	true,	"ofc_cd",			false,		"",		dfNone,			0,	false);
                    InitDataProperty(0,	cnt++ ,	dtData,			40,		daCenter,	true,	"dmdt_trf_cd",		false,		"",		dfNone,			0,	false);
                    //InitDataProperty(0,	cnt++ ,	dtAutoSum,		60,		daRight,	true,	"ttl_cntr",			false,		"",		dfNullInteger,	0,	false,	false, -1, false, true, "Total CNTR with Status F, C, I, N");
                    InitDataProperty(0,	cnt++ ,	dtData,			30,		daCenter,	true,	"curr_cd",			false,		"",		dfNone,			0,	false);
                    InitDataProperty(0,	cnt++ ,	dtAutoSum,		50,		daRight,	true,	"incr_cntr",		false,		"",		dfNullInteger,	0,	false,	false, -1, false, true, "DEM/DET Incurrence per Basic Tariff");
                    InitDataProperty(0,	cnt++ ,	dtAutoSum,		80,		daRight,	true,	"incr_amt",			false,		"",		dfNullFloat,	2,	false,	false, -1, false, true, "DEM/DET Incurrence per Basic Tariff");
                    InitDataProperty(0,	cnt++ ,	dtAutoSum,		50,		daRight,	true,	"cmdt_cntr",		false,		"",		dfNullInteger,	0,	false,	false, -1, false, true, "Exception per Commodity Exception Tariff");

                    InitDataProperty(0,	cnt++ ,	dtAutoSum,		80,		daRight,	true,	"cmdt_amt",			false,		"",		dfNullFloat,	2,	false,	false, -1, false, true, "Exception per Commodity Exception Tariff");
                    InitDataProperty(0,	cnt++ ,	dtAutoSum,		50,		daRight,	true,	"expt_cntr",		false,		"",		dfNullInteger,	0,	false,	false, -1, false, true, "Exception per S/C Exception Tariff/Before Booking");
                    InitDataProperty(0,	cnt++ ,	dtAutoSum,		80,		daRight,	true,	"expt_amt",			false,		"",		dfNullFloat,	2,	false,	false, -1, false, true, "Exception per S/C Exception Tariff/Before Booking");
                    InitDataProperty(0,	cnt++ ,	dtAutoSum,		50,		daRight,	true,	"bill_cntr1",		false,		"",		dfNullInteger,	0,	false,	false, -1, false, true, "Billable AMT1 = Incurred - CMDT EXPT - Exception");
                    InitDataProperty(0,	cnt++ ,	dtAutoSum,		80,		daRight,	true,	"bill_amt1",		false,		"",		dfNullFloat,	2,	false,	false, -1, false, true, "Billable AMT1 = Incurred - CMDT EXPT - Exception");
                    InitDataProperty(0,	cnt++ ,	dtAutoSum,		50,		daRight,	true,	"dc_cntr",			false,		"",		dfNullInteger,	0,	false,	false, -1, false, true, "Discount per After Booking");
                    InitDataProperty(0,	cnt++ ,	dtAutoSum,		80,		daRight,	true,	"dc_amt",			false,		"",		dfNullFloat,	2,	false,	false, -1, false, true, "Discount per After Booking");
                    InitDataProperty(0,	cnt++ ,	dtAutoSum,		50,		daRight,	true,	"bill_cntr",		false,		"",		dfNullInteger,	0,	false,	false, -1, false, true, "Billable AMT2 = Incurred - CMDT EXPT - Exception - Discount AMT");
                    InitDataProperty(0,	cnt++ ,	dtAutoSum,		80,		daRight,	true,	"bill_amt",			false,		"",		dfNullFloat,	2,	false,	false, -1, false, true, "Billable AMT2 = Incurred - CMDT EXPT - Exception - Discount AMT");
                    InitDataProperty(0,	cnt++ ,	dtAutoSum,		50,		daRight,	true,	"inv_cntr",			false,		"",		dfNullInteger,	0,	false,	false, -1, false, true, "Invoiced up to now");
                    InitDataProperty(0,	cnt++ ,	dtAutoSum,		80,		daRight,	true,	"inv_amt",			false,		"",		dfNullFloat,	2,	false,	false, -1, false, true, "Invoiced up to now");
                    InitDataProperty(0,	cnt++ ,	dtAutoSum,		50,		daRight,	true,	"coll_cntr",		false,		"",		dfNullInteger,	0,	false,	false, -1, false, true, "Collected up to now");
                    
                    InitDataProperty(0,	cnt++ ,	dtAutoSum,		80,		daRight,	true,	"coll_amt",			false,		"",		dfNullFloat,	2,	false,	false, -1, false, true, "Collected up to now");
                    InitDataProperty(0,	cnt++ ,	dtAutoSum,		50,		daRight,	true,	"inv_pay_cntr",		false,		"",		dfNullInteger,	0,	false,	false, -1, false, true, "Collected in ERP");
                    InitDataProperty(0,	cnt++ ,	dtAutoSum,		80,		daRight,	true,	"inv_pay_amt",		false,		"",		dfNullFloat,	2,	false,	false, -1, false, true, "Collected in ERP");
                    InitDataProperty(0,	cnt++ ,	dtAutoSum,		120,	daRight,	true,	"coll_rto_a",		false,		"",		dfNullFloat,	2,	false);
                    InitDataProperty(0,	cnt++ ,	dtAutoSum,		120,	daRight,	true,	"coll_rto_b",		false,		"",		dfNullFloat,	2,	false);
                    InitDataProperty(0,	cnt++ ,	dtAutoSum,		120,	daRight,	true,	"coll_rto_c",		false,		"",		dfNullFloat,	2,	false);
                    InitDataProperty(0,	cnt++ ,	dtAutoSum,		120,	daRight,	true,	"coll_rto_d",		false,		"",		dfNullFloat,	2,	false);
                    
 					// 컬럼 추가
 					InitDataProperty(0, cnt++ , dtHidden,    	70,		daCenter,   true,	"ctrl_ofc_cd",   	false,		"",		dfNone,			0,	false,	false);
                    InitDataProperty(0,	cnt++ ,	dtHidden,		0,		daRight,	true,	"all_coll_amt",		false,		"",		dfNullFloat,	2,	false);
                    
                    // 좌측 틀고정 컬럼 설정
					FrozenCols = SaveNameCol("curr_cd");
                    
                    CountPosition = 2;
 					ToolTipOption="balloon:true;width:50;";
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
	       		sheetObj.DoSearch("EES_DMT_6001GS.do", FormQueryString(formObj));
	       		ComOpenWait(false);
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
	    	case "office": 
	    		with (comboObj) { 
					//MultiSelect = false;
	    			UseAutoComplete = true;
					SetColAlign("left");
					DropHeight = 160;
					ColBackColor(0) = "#CCFFFD";
					
					//ValidChar(2);	// 영어대문자 사용
					//MaxLength = 6;
			    }
		    	break;
		    	
	    	case "tariff_type":
   	    		with (comboObj) { 
   					MultiSelect = true;
					SetColAlign("left");        
					SetColWidth("45");
					DropHeight = 160;
					ColBackColor(0) = "#CCFFFD";
   		    	}
   				break; 
		    	
	    	case "cntr_type":
   	    		with (comboObj) { 
   					MultiSelect = false;
					SetColAlign("left");        
					SetColWidth("45");
					DropHeight = 160;
					//ColBackColor(0) = "#CCFFFD";
   		    	}
   	    		
   	    		comboObj.InsertItem(0, "All",		"A");
   	    		comboObj.InsertItem(1, "Dry",		"D");
   	    		comboObj.InsertItem(2, "Reefer",	"R");
   	    		comboObj.InsertItem(3, "Special",	"S");
   				break;
	    }
	}
     
	
	// IBCombo 데이터 조회 및 세팅
	function doActionIBCombo(sheetObj, formObj, comboObj, formCmd) {
    	 sheetObj.ShowDebugMsg = false;
    	 sheetObj.WaitImageVisible = false;
    	 
    	 formObj.f_cmd.value = formCmd;
    	 var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
    	 
    	 switch(formCmd) {
    	 	case SEARCHLIST:	// tariff type
				var data = ComGetEtcData(sXml, "common_tariff_cd");
				if (data != undefined && data != '') {
					comboObj.InsertItem(0, "All", "All");
					var comboItems = data.split("|");
					
					for(var i=0; i < comboItems.length; i++) {
						var item = comboItems[i].split("=");
						comboObj.InsertItem(i+1, item[0], item[0]);
					}
				}
				break;
    	 	
    	 	case COMMAND06:	// RHQ
    	 		with (comboObj) { 
	    	 		RemoveAll();
					MultiSelect = false;
					SetColWidth("45");
					ValidChar(2);	// 영대문자만 사용
					//MaxLength = 6;
    	 		}
    	 		
    	 		var data = ComGetEtcData(sXml, "common_cd");
				if (data != undefined && data != '') {
					var comboItems = data.split("|");
					comboObj.InsertItem(0, "All", "All");
					
					for (var i = 0 ; i < comboItems.length ; i++) {
		    	    	comboObj.InsertItem(i+1, comboItems[i], comboItems[i]);		
		         	}
				}
				break;
    	 
    	 	case SEARCHLIST02: // Office
    	 		with (comboObj) { 
	    	 		RemoveAll();
					MultiSelect = true;
					SetColWidth("95");
					ValidChar(2, 2); // 영대문자, 특수문자만 가능
    	 		}
    	  		
				var data = ComGetEtcData(sXml, "OFC_CD");
				if (data != undefined && data != '') {
					var usrOfcCd = ComGetObjValue(formObj.usr_ofc_cd);
 					var idx = 0;
 					
 					// 로그인 Office가 멀티콤보 리스트에 없을 경우, 리스트 최상단에 추가
 					if(data.indexOf(usrOfcCd) == -1) {
 						comboObj.InsertItem(0, usrOfcCd, usrOfcCd);
 						idx = 1;
 					}
 					
 		    	    var comboItems = data.split("|");
 		    	    for (var i=0 ; i < comboItems.length ; i++) {
 		    	    	comboObj.InsertItem(idx+i, comboItems[i], comboItems[i]);
 		         	}
 	    	  		
 	    	  		// 로그인 User Office를 Default로 설정
	    	  		comboObj.Code = usrOfcCd;
				}
	    	    break;
	    	    
    	 	case COMMAND01:	// Incl. Sub Office
    	 		var subOfcCds = ComGetEtcData(sXml, "OFC_CD");
    	 	
    	 		if (subOfcCds != undefined && subOfcCds != '') {
    	 			var usrOfcCd = ComGetObjValue(formObj.usr_ofc_cd);
					
					if(comboObj.Code.indexOf(usrOfcCd) != -1 && subOfcCds.indexOf(usrOfcCd)==-1)
						subOfcCds = usrOfcCd + ',' + subOfcCds;
	    	   			
					comboObj.Code = subOfcCds;
		 		}
    	 		break;
    	 }
	}
	
	
	 /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        	switch(sAction) {
      			case IBSEARCH:
      				var dtFlg = ComGetObjValue(dt_flg);
      				if(dtFlg == 'M') {
      					if(!ComIsDate(to_mvmt_mon, "ym")) {
             				ComAlertFocus(fm_dt, ComGetMsg('COM12134', 'To MVMT Date Month'));
             				return false;
             			}
      					
      					var toMvmtMon = ComGetUnMaskedValue(to_mvmt_mon, 'ym');
      					var lastDay = ComGetLastDay(ComParseInt(toMvmtMon.substring(0, 4)), ComParseInt(toMvmtMon.substring(4)));
      					var startDt = toMvmtMon + '01';
      					var endDt = toMvmtMon + '' + lastDay;
      					
      					ComSetObjValue(start_dt, startDt);
      					ComSetObjValue(end_dt, endDt);
      					
      				} else {
      					if(!ComIsDate(fm_dt)) {
             				ComAlertFocus(fm_dt, ComGetMsg('COM12134', 'Period From Date'));
             				return false;
             			}
             			if(!ComIsDate(to_dt)) {
             				ComAlertFocus(to_dt, ComGetMsg('COM12134', 'Period To Date'));
             				return false;
             			}
             			
      					var startDt = ComGetUnMaskedValue(fm_dt, 'ymd');
             			var endDt = ComGetUnMaskedValue(to_dt, 'ymd');
             			/*
             			ComChkPeriod(fromDate, toDate)
             			0 : fromDate > toDate
             			1 : fromDate < toDate
             			2 : fromDate = toDate
             			*/
                        // 기간체크
                        if (ComChkPeriod(startDt, endDt) == 0) {
                        	ComShowCodeMessage("DMT01020");
                        	return false;
                        }
                        
	                      //=========================================================================================
	                     // 변경일자 : 2017.10.16 
	                     // 변경내용 : Period 를 12개월로 변경함.
	                     // 변경사유 : CSR #2236 [DMT] Current Collection Status by Office 메뉴 내 추가 개발 요청 건
	                     //========================================================================================== 
                        var limitDt = ComGetDateAdd(startDt, "M", REPORT_INQUIRY_PERIOD);
                        if (ComChkPeriod(endDt, limitDt) == 0) {
                        	ComShowCodeMessage("DMT00162", REPORT_INQUIRY_PERIOD + " month");
                        	return false;
                        }
      					
      					ComSetObjValue(start_dt, startDt);
      					ComSetObjValue(end_dt, endDt);
      				}
      				
                    // DEM/DET Office
                    var ofcCd = comboObjects[1].Code;
                    if(ComIsEmpty(ofcCd)) {
                    	ComShowCodeMessage('COM12113', "DEM/DET Office");
             			return false;
                    }
                    
                    ComSetObjValue(ofc_cd, ofcCd);
                    
                    // Tariff Type
                    var trfCd = comboObjects[0].Code;
                    if(ComIsEmpty(trfCd)) {
                    	ComShowCodeMessage('COM12113', "Tariff Type");
             			return false;
                    }
                    
                    // 전체선택이면, 'All'값을 제거해서 보냄.(DBDAO 내부로직 필요상)
                    if(trfCd.indexOf('All') != -1)
                    	trfCd = ComReplaceStr(trfCd, "All,", "");
                    	
                    ComSetObjValue(dmdt_trf_cd, trfCd);
        	
                    
                    // CNTR Type
                    var cntrType = comboObjects[2].Code;
                    if(ComIsEmpty(cntrType)) {
                    	ComShowCodeMessage('COM12113', "CNTR Type");
             			return false;
                    }
                    
                    // 전체선택이면, 전송할 Code값을 'A'로 설정. 나머지 경우는 그대로 보냄.(DBDAO 내부로직 필요상)
//                    if(cntrType == 'A')
//                    	cntrType = "D,R,S";
//                    
                    ComSetObjValue(dmdt_cntr_tp_cd, cntrType);
      				break;
      				
       	 	} // switch - end
        } // with(formObj) - end

        return true;
    }
    
    
    /*
  	 * 각 팝업 호출 처리
  	 */
  	function doProcessPopup(srcName) {
  		var sheetObj = sheetObjects[0];
   		var formObj = document.form;
  		var sUrl	 = '';
  		var sWidth	 = '';
  		var sHeight	 = '';
  		var paramVal = '';
  		
  		with(sheetObj) {
			if(CheckedRows("chk") == 0) {
     			ComShowCodeMessage('COM12114', 'Detail Charge');
     			return;
     		}
     		
     		var chkCnt = 0;
     		var chkRows = FindCheckedRow("chk").split("|");
     		
     		var prevOfcCd = CellValue(chkRows[0], "ofc_cd");
     		var chkTrfCd = '';
     		
     		for(var i=0; i < chkRows.length-1; i++) {
     			var currOfcCd = CellValue(chkRows[i], "ofc_cd");
     			
     			// 한 Office 에 대해서만 복수건 선택가능(서로 다른 Office의 항목이 선택되었는지 체크)
     			if(currOfcCd != prevOfcCd) {
     				ComShowCodeMessage('DMT01066');
 					return;
     			}
     			
     			var trfCd = CellValue(chkRows[i], "dmdt_trf_cd");
     			chkTrfCd += ',' + trfCd; 
     		}
     		
     		chkTrfCd = chkTrfCd.substring(1);
     		
     		var startDt	= ComGetObjValue(formObj.start_dt);
 			var endDt	= ComGetObjValue(formObj.end_dt);
 			var uclmFlg	= ComGetObjValue(formObj.uclm_flg);
     		var grpFlg	= ComGetObjValue(formObj.grp_flg);
     		var cntrTp	= ComGetObjValue(formObj.dmdt_cntr_tp_cd);
     		
     		paramVal = "?start_dt=" + startDt + "&end_dt=" + endDt + "&grp_flg=" + grpFlg
     					+ "&ofc_cd=" + prevOfcCd + "&dmdt_trf_cd=" + chkTrfCd +"&uclm_flg="+ uclmFlg + "&dmdt_cntr_tp_cd=" + cntrTp;
	  		
     		var dtlFlg = '';
     		
  			switch(srcName) {
	  			case 'btn_Detail':
	  				break;
	  				
	  			case 'btn_DetailA':
	  				dtlFlg = 'A';
	  				break;
	  				
	  			case 'btn_DetailB':
	  				dtlFlg = 'B';
	  				break;
	  				
	  			case 'btn_DetailC':
	  				dtlFlg = 'C';
	  				break;
	  		}
  		}
  		
  		sUrl	= 'EES_DMT_6002.do' + paramVal + "&dtl_flg=" + dtlFlg;
  		sWidth	= '1020';
  		sHeight	= '570';
  		
  		var sWinName = sUrl.substring(0, sUrl.indexOf('.do'));
		ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true);
  	}

     
	// Office IBMultiCombo 초기화
	function initComboValue_tariff_type() {
		ComSetObjValue(comboObjects[0], "All,DMIF,DTIC,DMOF,DTOC,CTIC,CTOC");
	}
	
	
	// CNTR Type IBMultiCombo 초기화
	function initComboValue_cntr_type() {
		ComSetObjValue(comboObjects[2], "A");
	}
	
	
	// 'Incl. Sub Office' 체크박스가 체크된 상태에서  Office 멀티콤보를 선택하지 못하도록 한다.
 	function office_OnCheckClick(comboObj, index, code) {
		var formObj = document.form;
   		
   		if(formObj.chk_sub_ofc.checked) {
   			if(comboObj.CheckIndex(index))
   				comboObj.CheckIndex(index) = false;
   			else
   				comboObj.CheckIndex(index) = true;
   			
   			ComShowCodeMessage('DMT00107');
   		}
 	}
	
	// 멀티콤보 KeyDown Event Catch
 	function office_OnKeyDown(comboObj, keycode, shift) {
		var formObj = document.form;
		
   		if(formObj.chk_sub_ofc.checked) {
   			ComShowCodeMessage('DMT00107');
   		}
 	}
	

	//Tariff Type IBMultiCombo 클릭 이벤트 처리
	function tariff_type_OnCheckClick(comboObj, index, code) {
	    if(index==0) {
	    	var bChk = comboObj.CheckIndex(index);
    		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
    			comboObj.CheckIndex(i) = bChk;
	    	}
	    } else if(comboObj.CheckIndex(0)) {
			comboObj.CheckIndex(0) = false;
	    } else if(comboObj.Code == 'DMIF,DTIC,DMOF,DTOC,CTIC,CTOC') {
	    	comboObj.CheckIndex(0) = true;
	    }
	}
	
	
	// 페이지에 Object 태그를 사용하여 IBSheet의 인스턴스를 생성완료 하면 Event가 발생한다.
	function sheet1_OnLoadFinish() {
		var formObj = document.form
		sheetObjects[0].WaitImageVisible = false;

		// Tariff Type MultiCombo List조회
		doActionIBCombo(sheetObjects[0], formObj, comboObjects[0], SEARCHLIST);
      	
		//OPEN화면 호출
      	doInit();
      	sheetObjects[0].WaitImageVisible = true;   
	} 
	


    // 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
    function sheet1_OnSearchEnd(sheetObj, ErrMsg)
    {
    	with(sheetObj)
    	{
    	
    		var all_coll_amt = 0;
    		for(var i=sheetObj.TopRow; i < sheetObj.LastRow ; i++) {
				all_coll_amt = all_coll_amt + eval(sheetObj.CellValue(i,"all_coll_amt"));
			}
			
			sheetObj.ShowSubSum("ofc_cd", "incr_cntr|incr_amt|cmdt_cntr|cmdt_amt|expt_cntr|expt_amt|dc_cntr|dc_amt|bill_cntr1|bill_amt1|bill_cntr|bill_amt|inv_cntr|inv_amt|coll_cntr|coll_amt|inv_pay_cntr|inv_pay_amt|all_coll_amt", -1, true, false, -1
					, "chk=;ofc_cd=%s;seq=S.TTL;coll_rto_a=Round(|all_coll_amt|/|incr_amt|, 4)*100;coll_rto_b=Round(|all_coll_amt|/|bill_amt1|, 4)*100;coll_rto_c=Round(|all_coll_amt|/|bill_amt|, 4)*100;coll_rto_d=Round(|all_coll_amt|/|inv_amt|, 4)*100");

    		var row = LastRow;
    		SumText(0, "chk")		= "Total / Average";
    		SumText(0, "seq")		= "Total / Average";
    		SumText(0, "ofc_cd")	= "Total / Average";
    		SumText(0, "dmdt_trf_cd") = "Total / Average";
    		SumText(0, "curr_cd")	= CellValue(row - 1, "curr_cd");
    		
    		var sumA = '0';
    		var sumB = '0';
    		var sumC = '0';
    		var sumD = '0';
    		
    		if(SumValue(0, "incr_amt") != '0')
    			sumA = ComRound(all_coll_amt/SumValue(0, "incr_amt"), 4)*100;
    		
    		if(SumValue(0, "bill_amt") != '0')
    			sumB = ComRound(all_coll_amt/SumValue(0, "bill_amt1"), 4)*100;
    		
    		if(SumValue(0, "inv_amt") != '0')
    			sumC = ComRound(all_coll_amt/SumValue(0, "bill_amt"), 4)*100;
    		
    		if(SumValue(0, "inv_amt") != '0')
    			sumD = ComRound(all_coll_amt/SumValue(0, "inv_amt"), 4)*100;
    			
    		SumValue(0, "coll_rto_a") = sumA;
    		SumValue(0, "coll_rto_b") = sumB;
    		SumValue(0, "coll_rto_c") = sumC;
    		SumValue(0, "coll_rto_d") = sumD;
    		
    		SetMergeCell(LastRow, 1, 1, 4);
    		CellAlign(row, "chk") = daRight;
    	}
    }
    
	/*==============================================================================================================
	 2017.07.04 : 2017.CSR #1386: [DMT] Report 내 조회 기능 추가 요청
	 Monthly Invoiced & Collection by Office 메뉴에 존재하는 'Incl. CNTR Column' 체크 유/무 기능을 동일하게 추가 요청 드립니다.
    (Summary Report by Customer 에 존재하는 Incl. D/C column과는 별개)
	===============================================================================================================*/    
	function incl_cntr_click() {
		var sheetObj = sheetObjects[0];
		var formObj = document.form;
		var inclCntr = ComGetObjValue(formObj.incl_cntr);
		
		var hiddenFlg = true;
		if(inclCntr == 'Y')	// CNTR Col 보여줌
			hiddenFlg = false;
			
		with(sheetObj) {
			ColHidden("incr_cntr")	  = hiddenFlg; 
			ColHidden("cmdt_cntr")	  = hiddenFlg; 
			ColHidden("expt_cntr")	  = hiddenFlg; 
			ColHidden("bill_cntr1")	  = hiddenFlg; 
			ColHidden("dc_cntr")	  = hiddenFlg; 
			ColHidden("bill_cntr")	  = hiddenFlg; 
			ColHidden("inv_cntr")	  = hiddenFlg; 
			ColHidden("coll_cntr")	  = hiddenFlg; 
			ColHidden("inv_pay_cntr") = hiddenFlg; 
		}
	}    
	/* 개발자 작업  끝 */