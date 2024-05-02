/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EesDmt6011Event.java
*@FileTitle : Uncollected status by Aging
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.26
*@LastModifier : 정 운
*@LastVersion : 1.0
* 2013.11.26 정 운
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
     * @class EES_DMT_6011 : EES_DMT_6011 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_6011() {
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
    
    //column의 개수를 파악하기위해 전역변수 설정
    var headCount = null;
    

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		var sheetObj = sheetObjects[0];
		var formObj  = document.form;

    	try {
    		var srcObj = window.event.srcElement;
    		var srcName = srcObj.getAttribute("name");

				switch(srcName) {

					case "btn_Retrieve":
						doActionIBSheet(sheetObj,formObj,IBSEARCH);
						break;
						
					case "btn_Detail":
						
				 		var currFlg	= ComGetObjValue(formObj.curr_flg);
				 		
				 		// USD 경우 마지막 Row인 전체 Total에 대해서는 Detail 조회 불가능
				 		// LOCAL 경우 전체 Total이 존재 하지 않으므로 모든 Row에 대한 조회 가능하도록 수정 (2016.08.10)
				 		if(currFlg =='U'){
				 			if(sheetObj.SelectRow != sheetObj.LastRow) doProcessPopup();
				 		}else{
				 			doProcessPopup();
				 		}
						
				 		// 수정 전 소스(2016.08.10)
				 		// if(sheetObj.SelectRow != sheetObj.LastRow) doProcessPopup();
				 		
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

					case "btn_DownExcel":
						sheetObj.SpeedDown2Excel(-1, false, false, '', '', false, false, '', false, 'chk');
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
        
        // Year IBMultiCombo 초기화
        initComboValue_f_year();
        
    	// Office IBMultiCombo 초기화
    	initComboValue_tariff_type();
        
    	// CNTR Type IBMultiCombo 초기화
    	initComboValue_cntr_type();

    	// CNTR Type IBMultiCombo 초기화
    	initComboValue_status();
        
        
        //html컨트롤 이벤트초기화
        initControl();
    }
    
    
	// 이벤트 처리 함수 선언
	function initControl() {
		axon_event.addListenerFormat('keypress','obj_keypress', document.form); //- 키보드 입력할때
 		axon_event.addListener('click', 'ofc_flg_click', 'ofc_flg');
   		axon_event.addListener('click', 'incl_incurred_click', 'incl_incurred');	// 'Incurred Amt' CheckBox 클릭시
   		axon_event.addListener('click', 'incl_exception_click', 'incl_exception');	// 'Exception Amt' CheckBox 클릭시
   		axon_event.addListener('click', 'incl_discount_click', 'incl_discount');	// 'Discount Amt' CheckBox 클릭시
	}
	
	
	// 화면 초기화 설정
	function doInit() {
		var formObj = document.form;
		
		ComResetAll();
			
		// DEM/DET Office 검색 조건 초기화 (Default: RHQ)
		ofc_flg_click();
		
		// 'Incurred Amt' CheckBox 체크시 로직 실행
		incl_incurred_click();
		
		// 'Exception Amt' CheckBox 체크시 로직 실행
		incl_exception_click();
		
		// 'Discount Amt' CheckBox 체크시 로직 실행
		incl_discount_click();
	}
	
	
	// 'CNTR' CheckBox 체크시 발생이벤트 처리
	function incl_cntr_column_click() {
		var sheetObj = sheetObjects[0];
		var formObj  = document.form;
		var inclCntrColumn = ComGetObjValue(formObj.incl_cntr_column);
		var hiddenFlg = true;
				
		if(inclCntrColumn == 'C')	// CNTR Col 보여줌
			hiddenFlg = false;
		
		with(sheetObj) {
				ColHidden("g030_incr_qty") = hiddenFlg;
				ColHidden("g030_expt_qty") = hiddenFlg;
				ColHidden("g030_dcnt_qty") = hiddenFlg;
				ColHidden("g030_bill_qty") = hiddenFlg;
				ColHidden("g060_incr_qty") = hiddenFlg;
				ColHidden("g060_expt_qty") = hiddenFlg;
				ColHidden("g060_dcnt_qty") = hiddenFlg;
				ColHidden("g060_bill_qty") = hiddenFlg;
				ColHidden("g090_incr_qty") = hiddenFlg;
				ColHidden("g090_expt_qty") = hiddenFlg;
				ColHidden("g090_dcnt_qty") = hiddenFlg;
				ColHidden("g090_bill_qty") = hiddenFlg;
				ColHidden("g180_incr_qty") = hiddenFlg;
				ColHidden("g180_expt_qty") = hiddenFlg;
				ColHidden("g180_dcnt_qty") = hiddenFlg;
				ColHidden("g180_bill_qty") = hiddenFlg;
				ColHidden("g181_incr_qty") = hiddenFlg;
				ColHidden("g181_expt_qty") = hiddenFlg;
				ColHidden("g181_dcnt_qty") = hiddenFlg;
				ColHidden("g181_bill_qty") = hiddenFlg;
				ColHidden("total_incr_qty") = hiddenFlg;
				ColHidden("total_expt_qty") = hiddenFlg;
				ColHidden("total_dcnt_qty") = hiddenFlg;
				ColHidden("total_bill_qty") = hiddenFlg;
			}		
	}
	
	
	// 'Incurred Amt' CheckBox 체크시 발생이벤트 처리
	function incl_incurred_click() {
		var sheetObj = sheetObjects[0];
		var formObj  = document.form;		
		var inclIncurredAmt = ComGetObjValue(formObj.incl_incurred);
		var hiddenFlg = true;
				
		if(inclIncurredAmt == 'I')	// Incurred Amt 보여줌
			hiddenFlg = false;
		
		with(sheetObj) {
				ColHidden("g015_incr_amt") = hiddenFlg;
				ColHidden("g015_incr_qty") = hiddenFlg;
				ColHidden("g030_incr_amt") = hiddenFlg;
				ColHidden("g030_incr_qty") = hiddenFlg;
				ColHidden("g060_incr_amt") = hiddenFlg;
				ColHidden("g060_incr_qty") = hiddenFlg;
				ColHidden("g090_incr_amt") = hiddenFlg;
				ColHidden("g090_incr_qty") = hiddenFlg;
				ColHidden("g180_incr_amt") = hiddenFlg;
				ColHidden("g180_incr_qty") = hiddenFlg;
				ColHidden("g181_incr_amt") = hiddenFlg;
				ColHidden("g181_incr_qty") = hiddenFlg;
				ColHidden("total_incr_amt") = hiddenFlg;
				ColHidden("total_incr_qty") = hiddenFlg;
			}		
	}
	
	// 'Exception Amt' CheckBox 체크시 발생이벤트 처리
	function incl_exception_click() {
		var sheetObj = sheetObjects[0];
		var formObj  = document.form;
		var inclExceptionAmt = ComGetObjValue(formObj.incl_exception);
		var hiddenFlg = true;
				
		if(inclExceptionAmt == 'E')	// Exception Amt 보여줌
			hiddenFlg = false;
		
		with(sheetObj) {
				ColHidden("g015_expt_amt") = hiddenFlg;
				ColHidden("g015_expt_qty") = hiddenFlg;
				ColHidden("g030_expt_amt") = hiddenFlg;
				ColHidden("g030_expt_qty") = hiddenFlg;
				ColHidden("g060_expt_amt") = hiddenFlg;
				ColHidden("g060_expt_qty") = hiddenFlg;
				ColHidden("g090_expt_amt") = hiddenFlg;
				ColHidden("g090_expt_qty") = hiddenFlg;
				ColHidden("g180_expt_amt") = hiddenFlg;
				ColHidden("g180_expt_qty") = hiddenFlg;
				ColHidden("g181_expt_amt") = hiddenFlg;
				ColHidden("g181_expt_qty") = hiddenFlg;
				ColHidden("total_expt_amt") = hiddenFlg;
				ColHidden("total_expt_qty") = hiddenFlg;
			}		
	}
	
	
	// 'Discount Amt' CheckBox 체크시 발생이벤트 처리
	function incl_discount_click() {
		var sheetObj = sheetObjects[0];
		var formObj  = document.form;
		var inclDiscountAmt = ComGetObjValue(formObj.incl_discount);
		var hiddenFlg = true;
				
		if(inclDiscountAmt == 'D')	// Discount Amt 보여줌
			hiddenFlg = false;
		
		with(sheetObj) {
				ColHidden("g015_dcnt_amt") = hiddenFlg;
				ColHidden("g015_dcnt_qty") = hiddenFlg;
				ColHidden("g030_dcnt_amt") = hiddenFlg;
				ColHidden("g030_dcnt_qty") = hiddenFlg;
				ColHidden("g060_dcnt_amt") = hiddenFlg;
				ColHidden("g060_dcnt_qty") = hiddenFlg;
				ColHidden("g090_dcnt_amt") = hiddenFlg;
				ColHidden("g090_dcnt_qty") = hiddenFlg;
				ColHidden("g180_dcnt_amt") = hiddenFlg;
				ColHidden("g180_dcnt_qty") = hiddenFlg;
				ColHidden("g181_dcnt_amt") = hiddenFlg;
				ColHidden("g181_dcnt_qty") = hiddenFlg;
				ColHidden("total_dcnt_amt") = hiddenFlg;
				ColHidden("total_dcnt_qty") = hiddenFlg;
			}		
	}
	
	
	// DEM/DET Office Radio Button 클릭 이벤트 처리
	function ofc_flg_click() {
		var formObj = document.form;
		var ofcFlg = ComGetObjValue(formObj.ofc_flg);
		var comboObj = comboObjects[0];
		
		if(ofcFlg == 'R') {
			// RHQ
			doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND06);
			ComEnableObject(formObj.chk_sub_ofc, false);
			ComClearObject(formObj.chk_sub_ofc);
			
			// RHQ 선택시 로그인 지역의  RHQ Office Code를 Default.
			var usrRhqOfcCd = ComGetObjValue(formObj.usr_rhq_ofc_cd);
	   		
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
		var comboObj = comboObjects[0];
		
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
                    InitRowInfo(3, 1, 3, 100);

					var HeadTitle1 = "Office|DMT type|Currency|Within 15days|Within 15days|Within 15days|Within 15days|Within 15days|Within 15days|Within 15days|Within 15days|Within 16-30days|Within 16-30days|Within 16-30days|Within 16-30days|Within 16-30days|Within 16-30days|Within 16-30days|Within 16-30days|31-60 days|31-60 days|31-60 days|31-60 days|31-60 days|31-60 days|31-60 days|31-60 days|61-90 days|61-90 days|61-90 days|61-90 days|61-90 days|61-90 days|61-90 days|61-90 days|91-180 days|91-180 days|91-180 days|91-180 days|91-180 days|91-180 days|91-180 days|91-180 days|Over 180 days|Over 180 days|Over 180 days|Over 180 days|Over 180 days|Over 180 days|Over 180 days|Over 180 days|Total|Total|Total|Total|Total|Total|Total|Total";
					var HeadTitle2 = "Office|DMT type|Currency|Incurred|Incurred|Exception|Exception|Discount|Discount|Billable|Billable|Incurred|Incurred|Exception|Exception|Discount|Discount|Billable|Billable|Incurred|Incurred|Exception|Exception|Discount|Discount|Billable|Billable|Incurred|Incurred|Exception|Exception|Discount|Discount|Billable|Billable|Incurred|Incurred|Exception|Exception|Discount|Discount|Billable|Billable|Incurred|Incurred|Exception|Exception|Discount|Discount|Billable|Billable|Incurred|Incurred|Exception|Exception|Discount|Discount|Billable|Billable";
					var HeadTitle3 = "Office|DMT type|Currency|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT";				
					
					headCount = ComCountHeadTitle(HeadTitle3);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(59, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false, false);
 
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
                    InitHeadRow(2, HeadTitle3, true);

                  //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,	cnt++ ,	dtData,		50,		daCenter,	true,	"ofc_cd",			false,		"",		dfNone,			0,	false);
                    InitDataProperty(0,	cnt++ ,	dtData,		80,		daCenter,	true,	"dmdt_trf_cd",		false,		"",		dfNone,			0,	false);                      
                    InitDataProperty(0,	cnt++ ,	dtData,		80,		daCenter,	true,	"bzc_trf_curr_cd",		false,		"",		dfNone,			0,	false);
                    InitDataProperty(0,	cnt++ ,	dtHidden,		80,		daRight,	true,	"g015_incr_qty",	false,		"",		dfNullInteger,	0,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtHidden,		80,		daRight,	true,	"g015_incr_amt",	false,		"",		dfNullFloat,	2,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtHidden,		80,		daRight,	true,	"g015_expt_qty",	false,		"",		dfNullInteger,	0,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtHidden,		80,		daRight,	true,	"g015_expt_amt",	false,		"",		dfNullFloat,	2,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtHidden,		80,		daRight,	true,	"g015_dcnt_qty",	false,		"",		dfNullInteger,	0,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtHidden,		80,		daRight,	true,	"g015_dcnt_amt",	false,		"",		dfNullFloat,	2,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtData,		80,		daRight,	true,	"g015_bill_qty",	false,		"",		dfNullInteger,	0,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtData,		85,		daRight,	true,	"g015_bill_amt",	false,		"",		dfNullFloat,	2,	false,	false, -1, false, true);  
                    
                    InitDataProperty(0,	cnt++ ,	dtHidden,		80,		daRight,	true,	"g030_incr_qty",	false,		"",		dfNullInteger,	0,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtHidden,		80,		daRight,	true,	"g030_incr_amt",	false,		"",		dfNullFloat,	2,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtHidden,		80,		daRight,	true,	"g030_expt_qty",	false,		"",		dfNullInteger,	0,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtHidden,		80,		daRight,	true,	"g030_expt_amt",	false,		"",		dfNullFloat,	2,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtHidden,		80,		daRight,	true,	"g030_dcnt_qty",	false,		"",		dfNullInteger,	0,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtHidden,		80,		daRight,	true,	"g030_dcnt_amt",	false,		"",		dfNullFloat,	2,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtData,		80,		daRight,	true,	"g030_bill_qty",	false,		"",		dfNullInteger,	0,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtData,		85,		daRight,	true,	"g030_bill_amt",	false,		"",		dfNullFloat,	2,	false,	false, -1, false, true);          
                                                                                                                             
                    InitDataProperty(0,	cnt++ ,	dtHidden,		80,		daRight,	true,	"g060_incr_qty",	false,		"",		dfNullInteger,	0,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtHidden,		80,		daRight,	true,	"g060_incr_amt",	false,		"",		dfNullFloat,	2,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtHidden,		80,		daRight,	true,	"g060_expt_qty",	false,		"",		dfNullInteger,	0,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtHidden,		80,		daRight,	true,	"g060_expt_amt",	false,		"",		dfNullFloat,	2,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtHidden,		80,		daRight,	true,	"g060_dcnt_qty",	false,		"",		dfNullInteger,	0,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtHidden,		80,		daRight,	true,	"g060_dcnt_amt",	false,		"",		dfNullFloat,	2,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtData,		80,		daRight,	true,	"g060_bill_qty",	false,		"",		dfNullInteger,	0,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtData,		80,		daRight,	true,	"g060_bill_amt",	false,		"",		dfNullFloat,	2,	false,	false, -1, false, true);        
                                                                                                                             
                    InitDataProperty(0,	cnt++ ,	dtHidden,		80,		daRight,	true,	"g090_incr_qty",	false,		"",		dfNullInteger,	0,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtHidden,		80,		daRight,	true,	"g090_incr_amt",	false,		"",		dfNullFloat,	2,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtHidden,		80,		daRight,	true,	"g090_expt_qty",	false,		"",		dfNullInteger,	0,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtHidden,		80,		daRight,	true,	"g090_expt_amt",	false,		"",		dfNullFloat,	2,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtHidden,		80,		daRight,	true,	"g090_dcnt_qty",	false,		"",		dfNullInteger,	0,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtHidden,		80,		daRight,	true,	"g090_dcnt_amt",	false,		"",		dfNullFloat,	2,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtData,		80,		daRight,	true,	"g090_bill_qty",	false,		"",		dfNullInteger,	0,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtData,		80,		daRight,	true,	"g090_bill_amt",	false,		"",		dfNullFloat,	2,	false,	false, -1, false, true);        
                                                                                                                             
                    InitDataProperty(0,	cnt++ ,	dtHidden,		80,		daRight,	true,	"g180_incr_qty",	false,		"",		dfNullInteger,	0,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtHidden,		80,		daRight,	true,	"g180_incr_amt",	false,		"",		dfNullFloat,	2,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtHidden,		80,		daRight,	true,	"g180_expt_qty",	false,		"",		dfNullInteger,	0,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtHidden,		80,		daRight,	true,	"g180_expt_amt",	false,		"",		dfNullFloat,	2,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtHidden,		80,		daRight,	true,	"g180_dcnt_qty",	false,		"",		dfNullInteger,	0,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtHidden,		80,		daRight,	true,	"g180_dcnt_amt",	false,		"",		dfNullFloat,	2,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtData,		80,		daRight,	true,	"g180_bill_qty",	false,		"",		dfNullInteger,	0,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtData,		80,		daRight,	true,	"g180_bill_amt",	false,		"",		dfNullFloat,	2,	false,	false, -1, false, true);        
                                                                                                             	        
                    InitDataProperty(0,	cnt++ ,	dtHidden,		80,		daRight,	true,	"g181_incr_qty",	false,		"",		dfNullInteger,	0,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtHidden,		80,		daRight,	true,	"g181_incr_amt",	false,		"",		dfNullFloat,	2,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtHidden,		80,		daRight,	true,	"g181_expt_qty",	false,		"",		dfNullInteger,	0,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtHidden,		80,		daRight,	true,	"g181_expt_amt",	false,		"",		dfNullFloat,	2,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtHidden,		80,		daRight,	true,	"g181_dcnt_qty",	false,		"",		dfNullInteger,	0,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtHidden,		80,		daRight,	true,	"g181_dcnt_amt",	false,		"",		dfNullFloat,	2,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtData,		80,		daRight,	true,	"g181_bill_qty",	false,		"",		dfNullInteger,	0,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtData,		90,		daRight,	true,	"g181_bill_amt",	false,		"",		dfNullFloat,	2,	false,	false, -1, false, true);        
                                                  
                    InitDataProperty(0,	cnt++ ,	dtHidden,		80,		daRight,	true,	"total_incr_qty",	false,		"|g015_incr_qty| + |g030_incr_qty| + |g060_incr_qty| + |g090_incr_qty| + |g180_incr_qty| + |g181_incr_qty|",		dfNullInteger,	0,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtHidden,		80,		daRight,	true,	"total_incr_amt",	false,		"|g015_incr_amt| + |g030_incr_amt| + |g060_incr_amt| + |g090_incr_amt| + |g180_incr_amt| + |g181_incr_amt|",		dfNullFloat,	2,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtHidden,		80,		daRight,	true,	"total_expt_qty",	false,		"|g015_expt_qty| + |g030_expt_qty| + |g060_expt_qty| + |g090_expt_qty| + |g180_expt_qty| + |g181_expt_qty|",		dfNullInteger,	0,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtHidden,		80,		daRight,	true,	"total_expt_amt",	false,		"|g015_expt_amt| + |g030_expt_amt| + |g060_expt_amt| + |g090_expt_amt| + |g180_expt_amt| + |g181_expt_amt|",		dfNullFloat,	2,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtHidden,		80,		daRight,	true,	"total_dcnt_qty",	false,		"|g015_dcnt_qty| + |g030_dcnt_qty| + |g060_dcnt_qty| + |g090_dcnt_qty| + |g180_dcnt_qty| + |g181_dcnt_qty|",		dfNullInteger,	0,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtHidden,		80,		daRight,	true,	"total_dcnt_amt",	false,		"|g015_dcnt_amt| + |g030_dcnt_amt| + |g060_dcnt_amt| + |g090_dcnt_amt| + |g180_dcnt_amt| + |g181_dcnt_amt|",		dfNullFloat,	2,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtData,		80,		daRight,	true,	"total_bill_qty",	false,		"|g015_bill_qty| + |g030_bill_qty| + |g060_bill_qty| + |g090_bill_qty| + |g180_bill_qty| + |g181_bill_qty|",		dfNullInteger,	0,	false,	false, -1, false, true);
                    InitDataProperty(0,	cnt++ ,	dtData,		80,		daRight,	true,	"total_bill_amt",	false,		"|g015_bill_amt| + |g030_bill_amt| + |g060_bill_amt| + |g090_bill_amt| + |g180_bill_amt| + |g181_bill_amt|",		dfNullFloat,	2,	false,	false, -1, false, true);        

                    
                    // 좌측 틀고정 컬럼 설정
					FrozenCols = SaveNameCol("g015_incr_qty");
                    
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
	       		
	       		sheetObj.removeAll();
	       		sheetObj.WaitImageVisible=false;
       			ComOpenWait(true);
       			
       			formObj.f_cmd.value = COMMAND01;
	         	
	         	var sXml = sheetObj.GetSaveXml("EES_DMT_6011GS.do", FormQueryString(formObj));
				var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
				if (backendJobKey != undefined && backendJobKey != '') {
					ComSetObjValue(formObj.backendjob_key, backendJobKey);
					sheetObj.WaitImageVisible = false;
					sheetObj.RequestTimeOut = 10000;
					timer = setInterval(getBackEndJobStatus, 3000); // 3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
				}       			
	       		break;
	    }
	}
	
	
	/**
	 * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
	 */
	 function getBackEndJobStatus() {
	 	var formObj = document.form;
	 	var sheetObj = sheetObjects[0];
	
	 	//It gets a status of backendjob. 2
	 	ComSetObjValue(formObj.f_cmd, COMMAND02);
	 	var sXml		= sheetObj.GetSearchXml("EES_DMT_6011GS.do", FormQueryString(formObj));
	 	var jobState 	= ComGetEtcData(sXml, "jb_sts_flg");

	 	// jobState == "2" BackEndJob 진행중......
	 	if (jobState == "3") {
	 		clearInterval(timer);
	 		// BackEndJob이 성공 하였습니다.
	 		getBackEndJobLoadFile();
		 	ComOpenWait(false);

	 	}
	 	else if (jobState == "4") {
	 		clearInterval(timer);
	 		ComOpenWait(false);
	 		// BackEndJob을 실패 하였습니다.
            ComShowCodeMessage("DMT01166");
	 	}
	 	else if (jobState == "5") {
	 		clearInterval(timer);
	 		// 이미 BackEndJob 결과 파일을 읽었습니다.
	 		ComOpenWait(false);
	 		ComShowCodeMessage("DMT01167");
	 	}
	 }

	 
	// BackEndJob 성공종료시 결과데이터를 반영한다.
	function getBackEndJobLoadFile() {
	 	var formObj = document.form;
	 	var sheetObj = sheetObjects[0];
	 	
	 	var fCmd = SEARCH;	 	
	 	ComSetObjValue(formObj.f_cmd, fCmd);	 	
	 	var sXml = sheetObj.DoSearch("EES_DMT_6011GS.do", FormQueryString(formObj));

	 	ComOpenWait(false);
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
		    
	    	case "f_year":
   	    		with (comboObj) { 
   					MultiSelect = false;
					SetColAlign("left");        
					SetColWidth("45");
					DropHeight = 160;
					ColBackColor(0) = "#CCFFFD";
   		    	}
   	    		
   	    		var ofcCurrDate = DmtComOfficeCurrDate(sheetObjects[0], formObj);
   	    		
   	    		//year를 10년까지만 조회 
   	    		for(var i = 0 ; i < 10 ; i++){
   	   	    		var Date = ComGetDateAdd(ofcCurrDate, "Y", -i);
   	   	    		var year = Date.substring(0, 4);
   	   	    		comboObj.InsertItem(i, year, year);
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
   				
	    	case "status":
   	    		with (comboObj) { 
					MultiSelect = true;
					SetColAlign("left");        
					SetColWidth("120");
					DropHeight = 170;
					ColBackColor(0) = "#CCFFFD";
					BackColor = "#CCFFFD";
					addComboItem(comboObj, comboNo);
   		    	}
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
					
					//All 추가
					comboObj.InsertItem(0, 'All', 'All');
					
					for (var i = 0 ; i < comboItems.length ; i++) {
		    	    	comboObj.InsertItem(i+1, comboItems[i], comboItems[i]);		
		         	}
				}
				comboObj.Code = 'All';
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
      				
                    // DEM/DET Office
                    var ofcCd = comboObjects[0].Code;
                    if(ComIsEmpty(ofcCd)) {
                    	ComShowCodeMessage('COM12113', "DEM/DET Office");
             			return false;
                    }
                    
                    ComSetObjValue(ofc_cd, ofcCd);
                    
                    // Tariff Type
                    var trfCd = comboObjects[2].Code;
                    if(ComIsEmpty(trfCd)) {
                    	ComShowCodeMessage('COM12113', "Tariff Type");
             			return false;
                    }
                    
                    // 전체선택이면, 'All'값을 제거해서 보냄.(DBDAO 내부로직 필요상)
                    if(trfCd.indexOf('All') != -1)
                    	trfCd = ComReplaceStr(trfCd, "All,", "");
                    	
                    ComSetObjValue(dmdt_trf_cd, trfCd);
        	
                    
                    // CNTR Type
                    var cntrType = comboObjects[3].Code;
                    if(ComIsEmpty(cntrType)) {
                    	ComShowCodeMessage('COM12113', "CNTR Type");
             			return false;
                    }
                    
                    // 전체선택이면, 전송할 Code값을 'A'로 설정. 나머지 경우는 그대로 보냄.(DBDAO 내부로직 필요상)
                    if(cntrType == 'A')
                    	cntrType = "D,R,S";
                    
                    ComSetObjValue(dmdt_cntr_tp_cd, cntrType);
      				break;
      				
       	 	} // switch - end
        } // with(formObj) - end

        return true;
    }
    
    // Year IBMultiCombo 초기화
	function initComboValue_f_year() {
		var newDate = new Date();
	    var year = newDate.getFullYear();

	    ComSetObjValue(comboObjects[1], year);
	}
    
	// Office IBMultiCombo 초기화
	function initComboValue_tariff_type() {
		ComSetObjValue(comboObjects[2], "All,DMIF,DTIC,DMOF,DTOC,CTIC,CTOC");
	}
	
	
	// CNTR Type IBMultiCombo 초기화
	function initComboValue_cntr_type() {
		ComSetObjValue(comboObjects[3], "A");
	}
	

	// Office IBMultiCombo 초기화
	function initComboValue_status() {
		ComSetObjValue(comboObjects[4], "F,C");
	}
	

    /**
     * 콤보필드에 데이터를 추가해준다.
     */	
 	function addComboItem(comboObj,comboItems) {
 		switch(comboObj.id) {

 			case "status":
				comboObj.InsertItem(0, "All", "A");
 				comboObj.InsertItem(1, "Finished",	"F");
 				comboObj.InsertItem(2, "Confirmed",	"C");
 				comboObj.InsertItem(3, "Long Staying", "L");
				break;
 		}
 	}

  	/**
  	 * Status 멀티콤보 CheckClick 이벤트 처리
  	 * @param comboObj
  	 * @param index
  	 * @param code
  	 * @return
  	 */
  	function status_OnCheckClick(comboObj, index, code) {
		var formObj = document.form;
		//var codes = comboObj.Code;
		
		with (formObj) {
			if(index == 0) {
				if(comboObj.CheckIndex(0))	// All check
					comboObj.Code = "A,F,C,L";
				else // All uncheck
					comboObj.Code = '';
			} else if(comboObj.CheckIndex(0)) {
				comboObj.CheckIndex(0) = false;
			}
		}
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
		doActionIBCombo(sheetObjects[0], formObj, comboObjects[2], SEARCHLIST);
      	
		//OPEN화면 호출
      	doInit();
      	sheetObjects[0].WaitImageVisible = true;   
	} 
	


    // 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
    function sheet1_OnSearchEnd(sheetObj, ErrMsg)
    {
		var formObj = document.form;

    	with(sheetObj)
    	{
//    		var row = LastRow;
    		
    		//조회 후 LastRow의 모든 column에 BackColor를 설정해준다.
//    		for(var i=0; i <= headCount; i++){
//        		sheetObj.cellBackColor(row, i) = sheetObj.RgbColor(247, 225, 236);
//    		}
    		
    		for(var i=TopRow; i <= LastRow ; i++) {
				 if(CellValue(i, 'dmdt_trf_cd')=='') {
					 for(var j=0; j <= headCount; j++){
			        		cellBackColor(i, j) = RgbColor(247, 225, 236);
			    		}
					 
					 if(CellValue(i, 'ofc_cd')!='' && CellValue(i, 'bzc_trf_curr_cd')=='' ) {
						 CellText(i, "dmdt_trf_cd")   = "OFC.TTL";
						 cellBackColor(i, j) = RgbColor(200, 225, 236);
					 }
					 else{
						 CellText(i, "dmdt_trf_cd")   = "CUR.TTL";
					 }	
				 }
			}
    		
    		if ( ComGetObjValue(formObj.curr_flg) == 'U' ){

	    		for(var j=0; j <= headCount; j++){
	        		cellBackColor(LastRow, j) = RgbColor(255, 255, 255);
	    		}
	    		
      			CellText(LastRow, "dmdt_trf_cd")   = "Total";
    		}
//    		sheetObj.CellText(row, "ofc_cd")		= "(Total)";
//    		sheetObj.CellText(row, "dmdt_trf_cd")   = "(Total)";
//    		sheetObj.CellAlign(row, "ofc_cd") = daCenter;
//    		sheetObj.CellAlign(row, "dmdt_trf_cd") = daCenter;
    	}
    	
    }
    
    /*
  	 * 각 팝업 호출 처리
  	 */
  	function doProcessPopup() {
  		var sheetObj = sheetObjects[0];
   		var formObj = document.form;
  		var sUrl	 = '';
  		var sWidth	 = '';
  		var sHeight	 = '';
  		var paramVal = '';
  		with(sheetObj) {			     		     				     		
     		var trfCd = CellValue(SelectRow, "dmdt_trf_cd");
     		var trfCombo = ComGetObjValue(formObj.tariff_type);
     		var prevOfcCd = CellValue(SelectRow, "ofc_cd");     		
     		var year = ComGetObjValue(formObj.f_year);
 			var uclmFlg	= ComGetObjValue(formObj.uclm_flg);
     		var grpFlg	= ComGetObjValue(formObj.grp_flg);
     		var cntrTp	= ComGetObjValue(formObj.dmdt_cntr_tp_cd);
     		
     		// 로직 변경으로 인한 추가 (Edit by Wonki Eo)
     		var currFlg	= ComGetObjValue(formObj.curr_flg);
     		var bzcTrfCurrCd = CellValue(SelectRow, "bzc_trf_curr_cd");

     		// 과거 소스 ( 2016.08.10 이전 )
			// paramVal = "?start_dt=" + (year + '0101') + "&end_dt=" + (year + '1231') + "&grp_flg=" + grpFlg + "&ofc_cd=" + prevOfcCd
			// 			+ "&uclm_flg=" + uclmFlg + "&dmdt_cntr_tp_cd=" + cntrTp + "&dmdt_chg_sts_cd=" + comboObjects[4].Code;
			// if(trfCd != 'S.TTL') {
			//     			paramVal += "&dmdt_trf_cd=" + trfCd;
			// }
     		
   	
     		
     		if (currFlg =='U'){
	     		if(trfCd != 'CUR.TTL' && trfCd != 'OFC.TTL') {
		 			paramVal = paramVal = "?start_dt=" + (year + '0101') + "&end_dt=" + (year + '1231') + "&grp_flg=" + grpFlg + "&ofc_cd=" + prevOfcCd
		 			+ "&uclm_flg=" + uclmFlg + "&dmdt_cntr_tp_cd=" + cntrTp + "&dmdt_chg_sts_cd=" + comboObjects[4].Code + "&dmdt_trf_cd=" + trfCd;
		 		}else if (trfCd == 'CUR.TTL' || trfCd == 'OFC.TTL'){
		     		paramVal = "?start_dt=" + (year + '0101') + "&end_dt=" + (year + '1231') + "&grp_flg=" + grpFlg + "&ofc_cd=" + prevOfcCd
		 			+ "&uclm_flg=" + uclmFlg + "&dmdt_cntr_tp_cd=" + cntrTp + "&dmdt_chg_sts_cd=" + comboObjects[4].Code ;
		     		
		     		
		     		// Tariff Type 이 All 이 아닌 경우에 대한 예외 조건
		     		if ( !ComIsContainsChars(trfCombo,"All") ){
		     			paramVal += "&dmdt_trf_cd=" + trfCombo;
		     		}
		     		
		     		
		 		}
     		}
     		else if (currFlg =='L'){
     			if(trfCd != 'CUR.TTL') {
		 			paramVal = paramVal = "?start_dt=" + (year + '0101') + "&end_dt=" + (year + '1231') + "&grp_flg=" + grpFlg + "&ofc_cd=" + prevOfcCd
		 			+ "&uclm_flg=" + uclmFlg + "&dmdt_cntr_tp_cd=" + cntrTp + "&dmdt_chg_sts_cd=" + comboObjects[4].Code + "&dmdt_trf_cd=" + trfCd 
		 			+ "&bzc_trf_curr_cd=" + bzcTrfCurrCd ;
		 		}else if (trfCd == 'CUR.TTL'){
		     		paramVal = "?start_dt=" + (year + '0101') + "&end_dt=" + (year + '1231') + "&grp_flg=" + grpFlg + "&ofc_cd=" + prevOfcCd
		 			+ "&uclm_flg=" + uclmFlg + "&dmdt_cntr_tp_cd=" + cntrTp + "&dmdt_chg_sts_cd=" + comboObjects[4].Code
		 			+ "&bzc_trf_curr_cd=" + bzcTrfCurrCd ;
		     		
		     		// Tariff Type 이 All 이 아닌 경우에 대한 예외 조건
		     		if ( !ComIsContainsChars(trfCombo,"All") ){
		     			paramVal += "&dmdt_trf_cd=" + trfCombo;
		     		}
		     		
		 		}
     		}
     		
  		}
  		
  		sUrl	= 'EES_DMT_6013.do' + paramVal;  		
  		sWidth	= '1020';
  		sHeight	= '570';
  		
  		var sWinName = sUrl.substring(0, sUrl.indexOf('.do'));
		ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true);
  	}
  	
    /**
     * Booking Creation 화면 이동
     * @param sheetObj Sheet
     * @param Row Row Index
     * @param Col Col Index
     */
    function sheet1_OnDblClick(sheetObj, Row, Col) {
  		var formObj = document.form;
 		var currFlg	= ComGetObjValue(formObj.curr_flg);
 		
 		// 
 		if(currFlg =='U'){
 			if(Row != sheetObj.LastRow) doProcessPopup();
 		}else{
 			doProcessPopup();
 		}
    }
       	
    

	/* 개발자 작업  끝 */