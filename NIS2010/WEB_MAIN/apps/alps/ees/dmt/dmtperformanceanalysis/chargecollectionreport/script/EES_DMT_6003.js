/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_6003.js
*@FileTitle : Monthly Invoiced &amp; Collection by Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.09.25 황효근
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
     * @class EES_DMT_6003 : EES_DMT_6003 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_6003() {
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
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
 		  var sheetObj = sheetObjects[0];
          /*******************************************************/
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
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
					break;
				
				case "btn_New":
					doInit();
					break;
				
				case "btn_DownExcel":
			/*==============================================================================================================
				 2017.07.04 : CSR #1373: [DMT] Monthly Invoiced & Collection by Office
				 2. 해당 메뉴에서 Incl. CNTR Column 체크하지 않고 Retreive 후 Down Excel 하면 CNTR Column이 포함되어 나옴 -> 
				 체크하지 않았을 시에는 Down Excel data에도 CNTR Column 포함되지 않게 변경 요청
			 ===============================================================================================================*/
					sheetObj.SpeedDown2Excel(-1, false, false, '', '', false, false, '', false);
					break;
				
				case "btn_Minimize":
					var schCondDiv = document.getElementById("sch_cond_div");
 					if(schCondDiv.style.display == 'block') {	// 조건 선택부분 보임 상태
 						schCondDiv.style.display = 'none';
 						sheetObj.style.height = 470;
 					} else {
 						schCondDiv.style.display = 'block';
 						sheetObj.style.height = 350;
 					}
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
  		axon_event.addListener('blur',	'obj_blur',	'to_mvmt_mon', 'fm_dt', 'to_dt');	//- 포커스 나갈때
   		axon_event.addListener('focus',	'obj_focus', 'to_mvmt_mon', 'fm_dt', 'to_dt');	//- 포커스 들어갈때
   		axon_event.addListenerFormat('keypress','obj_keypress', document.form);			//- 키보드 입력할때
   		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
   		axon_event.addListener('click', 'ofc_flg_click', 'ofc_flg');		// DEM/DET Office 라디오버튼 클릭시
   		axon_event.addListener('click', 'dt_flg_click', 'dt_flg');			// Date 라디오버튼 클릭시
   		axon_event.addListener('click', 'incl_cntr_click', 'incl_cntr');	// 'Incl. CNTR Column' CheckBox 클릭시
  	}
      
   
	// 화면 초기화 설정
	function doInit() {
		var formObj = document.form;
		
		ComResetAll();
		
		// To MVMT Date 검색 조건 초기화
		dt_flg_click();
		
		// DEM/DET Office 검색 조건 초기화 (Default: RHQ)
		ofc_flg_click();
		
		
		// 'Incl. CNTR Column' CheckBox 체크시 로직 실행
		incl_cntr_click();
	}
      
	
	// 'Incl. CNTR Column' CheckBox 체크시 발생이벤트 처리
	function incl_cntr_click() {
		var sheetObj = sheetObjects[0];
		var formObj = document.form;
		var inclCntr = ComGetObjValue(formObj.incl_cntr);
		
		var hiddenFlg = true;
		if(inclCntr == 'Y')	// CNTR Col 보여줌
			hiddenFlg = false;
			
		with(sheetObj) {
			ColHidden("bill_cntr")		= hiddenFlg; 
			ColHidden("inv_cntr")		= hiddenFlg;
			//ColHidden("inv_m_cntr")		= hiddenFlg;
			ColHidden("inv_tot_cntr")	= hiddenFlg;
			ColHidden("coll_cntr")		= hiddenFlg;
			//ColHidden("coll_m_cntr")	= hiddenFlg;
			ColHidden("coll_tot_cntr")	= hiddenFlg;
			
			// 2017.07.24 일 하기항목 추가함.
			ColHidden("ar_if_cntr")	    = hiddenFlg;
			ColHidden("ar_if_tot_cntr")	= hiddenFlg;
		}
	}
	

	// Date 라디오버튼 클릭 이벤트 처리
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
		var comboObj = comboObjects[0];
		
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
                     style.height = 350;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 3, 1, 7, 100);
                     
                     var HeadTitle1 = "|Seq.|YEAR|MONTH|RHQ|Office|Charge|Bound|Cur.|Billable2|Billable2|Invoiced|Invoiced|Invoiced|Invoiced|Invoiced|A/R I/F|A/R I/F|A/R I/F|A/R I/F|A/R I/F|A/R I/F|Collected (in ERP)|Collected (in ERP)|Collected (in ERP)|Collected (in ERP)|Collected (in ERP)|CTRL OFC";
                     var HeadTitle2 = "|Seq.|YEAR|MONTH|RHQ|Office|Charge|Bound|Cur.|Auto|Auto| Auto | Auto |Manual|Total|Total|Auto|Auto|Manual|Other|Total|Total|Auto|Auto|Manual|Total|Total|CTRL OFC";
                     var HeadTitle3 = "|Seq.|YEAR|MONTH|RHQ|Office|Charge|Bound|Cur.|CNTR|AMT|CNTR|AMT| AMT |CNTR|AMT|CNTR|AMT| AMT |AMT|CNTR|AMT|CNTR|AMT| AMT |CNTR|AMT|CTRL OFC"; 
                     //var headCount = ComCountHeadTitle(HeadTitle1);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(28, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     InitHeadRow(1, HeadTitle2, true); 
                     InitHeadRow(2, HeadTitle3, true);                    

                     //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 	                InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,   true,		"ibflag");
 	                InitDataProperty(0, cnt++ , dtSeq,	 		 	50,		daCenter,	true,		"seq",      		false,	"",		dfNone,					0,	false,		false);
 					InitDataProperty(0, cnt++ , dtData,    			70,		daCenter,   true,		"year",		   		false,	"",		dfNone,					0,	false,		false);
 					InitDataProperty(0, cnt++ , dtData,    			70,		daCenter,   true,		"month",   			false,	"",		dfNone,					0,	false,		false);
 					InitDataProperty(0, cnt++ , dtData,    			70,		daCenter,   true,		"ofc_rhq_cd",  		false,	"",		dfNone,					0,	false,		false); 	                
 	                InitDataProperty(0, cnt++ , dtData,    			70,		daCenter,   true,		"ofc_cd",   		false,	"",		dfNone,					0,	false,		false);
 					InitDataProperty(0, cnt++ , dtData,    			60,		daCenter,   true,		"tariff",   		false,	"",		dfNone,					0,	false,		false);
 					InitDataProperty(0, cnt++ , dtData,    			60,		daCenter,   true,		"io_bnd",  			false,	"",		dfNone,					0,	false,		false);		
 					InitDataProperty(0, cnt++ , dtData,   			60,		daCenter,   true,		"curr_cd",  		false,	"",		dfNone,					0,	false,		false);

 					InitDataProperty(0, cnt++ , dtAutoSum, 			50,		daRight,	true,		"bill_cntr",		false,	"",		dfNullInteger,			0,	false,		false,	-1, false, true, "Status: F, C, I with To Date within the period");
 					InitDataProperty(0, cnt++ , dtAutoSum,  		100,	daRight,	true,		"bill_amt",			false,	"",		dfNullFloat,			2,	false,		false,	-1, false, true, "Status: F, C, I with To Date within the period");
 					InitDataProperty(0, cnt++ , dtAutoSum,  		50,		daRight,	true,		"inv_cntr", 		false,	"",		dfNullInteger,			0,	false,		false,	-1, false, true, "Invoice Issued within the period");
 					InitDataProperty(0, cnt++ , dtAutoSum,  		100,	daRight,	true,		"inv_amt",    		false,	"",		dfNullFloat,			2,	false,		false,	-1, false, true, "Invoice Issued within the period");
 					
 					//InitDataProperty(0, cnt++ , dtAutoSum,  		50,		daRight,	true,		"inv_m_cntr", 		false,	"",		dfNullInteger,			0,	false,		false,	-1, false, true, "Invoice Issued within the period");
 					InitDataProperty(0, cnt++ , dtAutoSum,  		100,	daRight,	true,		"inv_m_amt",    	false,	"",		dfNullFloat,			2,	false,		false,	-1, false, true, "Invoice Issued within the period");
 					InitDataProperty(0, cnt++ , dtAutoSum,  		50,		daRight,	true,		"inv_tot_cntr",		false,	"|inv_cntr|", dfNullInteger,	0,	false,		false,	-1, false, true, "Invoice Issued within the period");
 					InitDataProperty(0, cnt++ , dtAutoSum,  		100,	daRight,	true,		"inv_tot_amt",		false,	"|inv_amt|+|inv_m_amt|", dfNullFloat,2,false,	false,	-1, false, true, "Invoice Issued within the period");
 					
 					InitDataProperty(0, cnt++ , dtAutoSum,  		50,		daRight,	true,		"ar_if_cntr",		false,	"",		dfNullInteger,			0,	false,		false,	-1, false, true, "A/R interfaced within the period");
 					InitDataProperty(0, cnt++ , dtAutoSum,  		100,	daRight,	true,		"ar_if_amt",		false,	"",		dfNullFloat,			2,	false,		false,	-1, false, true, "A/R interfaced within the period");
 					InitDataProperty(0, cnt++ , dtAutoSum,  		100,	daRight,	true,		"ar_if_m_amt",		false,	"",		dfNullFloat,			2,	false,		false,	-1, false, true, "A/R interfaced within the period");
 					InitDataProperty(0, cnt++ , dtAutoSum,  		100,	daRight,	true,		"ar_if_oth_amt",	false,	"",		dfNullFloat,			2,	false,		false,	-1, false, true, "A/R interfaced within the period");
 					InitDataProperty(0, cnt++ , dtAutoSum,  		50,		daRight,	true,		"ar_if_tot_cntr",   false,	"|ar_if_cntr|", dfNullInteger,	0,	false,		false,	-1, false, true, "A/R interfaced within the period");
 					InitDataProperty(0, cnt++ , dtAutoSum,  		100,	daRight,	true,		"ar_if_tot_amt",    false,	"|ar_if_amt|+|ar_if_m_amt|+|ar_if_oth_amt|", dfNullFloat, 2, false, false,	-1, false, true, "A/R interfaced within the period");
 					
 					InitDataProperty(0, cnt++ , dtAutoSum,  		50,		daRight,	true,		"coll_cntr",		false,	"",		dfNullInteger,			0,	false,		false,	-1, false, true, "A/R interfaced within the period");
 					InitDataProperty(0, cnt++ , dtAutoSum,  		100,	daRight,	true,		"coll_amt",			false,	"",		dfNullFloat,			2,	false,		false,	-1, false, true, "A/R interfaced within the period");
 					//InitDataProperty(0, cnt++ , dtAutoSum,  		50,		daRight,	true,		"coll_m_cntr",  	false,	"",		dfNullInteger,			0,	false,		false,	-1, false, true, "A/R interfaced within the period");
 					InitDataProperty(0, cnt++ , dtAutoSum,  		100,	daRight,	true,		"coll_m_amt",		false,	"",		dfNullFloat,			2,	false,		false,	-1, false, true, "A/R interfaced within the period");
 					InitDataProperty(0, cnt++ , dtAutoSum,  		50,		daRight,	true,		"coll_tot_cntr",   	false,	"|coll_cntr|", dfNullInteger,	0,	false,		false,	-1, false, true, "A/R interfaced within the period");
 					InitDataProperty(0, cnt++ , dtAutoSum,  		100,	daRight,	true,		"coll_tot_amt",    	false,	"|coll_amt|+|coll_m_amt|", dfNullFloat, 2, false, false,	-1, false, true, "A/R interfaced within the period");
 					
 					// 컬럼 추가
 					InitDataProperty(0, cnt++ , dtHidden,    		70,		daCenter,   true,		"ctrl_ofc_cd",   	false,	"",		dfNone,					0,	false,		false);
 					
 					// 좌측 틀고정 컬럼 설정
					FrozenCols = SaveNameCol("bill_cntr");
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
	       		sheetObj.DoSearch("EES_DMT_6003GS.do", FormQueryString(formObj));
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
 	    }
 	}
   
   
	// IBCombo 데이터 조회 및 세팅
 	function doActionIBCombo(sheetObj, formObj, comboObj, formCmd) {
     	 sheetObj.ShowDebugMsg = false;
     	 sheetObj.WaitImageVisible = false;
     	 
     	 formObj.f_cmd.value = formCmd;
     	 var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
     	 
     	 switch(formCmd) {
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
	          				ComShowCodeMessage('COM12180');
	          				ComSetFocus(to_mvmt_mon);
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
	          				ComAlertFocus(fm_dt, ComGetMsg('COM12134', 'From Date'));
	          				return false;
	          			}
	          			if(!ComIsDate(to_dt)) {
	          				ComAlertFocus(to_dt, ComGetMsg('COM12134', 'To Date'));
	          				return false;
	          			}
	          			
	   					var startDt = ComGetUnMaskedValue(fm_dt, 'ymd');
	          			var endDt = ComGetUnMaskedValue(to_dt, 'ymd');
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
                    var ofcCd = comboObjects[0].Code;
                    if(ComIsEmpty(ofcCd)) {
                    	ComShowCodeMessage('COM12113', "DEM/DET Office");
             			return false;
                    }
                    
                    ComSetObjValue(ofc_cd, ofcCd);
	   				
	                break;
   				
    	 	} // switch - end
         } // with - end

         return true;
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
      

    // 페이지에 Object 태그를 사용하여 IBSheet의 인스턴스를 생성완료 하면 Event가 발생한다.
	function sheet1_OnLoadFinish() {
  		var formObj = document.form
  		sheetObjects[0].WaitImageVisible = false;
        	
  		//OPEN화면 호출
        doInit();
        sheetObjects[0].WaitImageVisible = true;   
  	}
      

 	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
 		with(sheetObj){
 			
 			// 1단계 소계 기준컬럼 - Office
 			ShowSubSum("ofc_cd", "bill_cntr|bill_amt|inv_cntr|inv_amt|inv_m_amt|inv_tot_cntr|inv_tot_amt|ar_if_cntr|ar_if_amt|ar_if_m_amt|ar_if_oth_amt|ar_if_tot_cntr|ar_if_tot_amt|coll_cntr|coll_amt|coll_m_amt|coll_tot_cntr|coll_tot_amt", -1, false, false, -1
 						, "ofc_cd=%s;tariff=;curr_cd=;seq=S.TTL");
 			
 			// 2단계 소계 기준컬럼 - Charge
 			ShowSubSum("tariff", "bill_cntr|bill_amt|inv_cntr|inv_amt|inv_m_amt|inv_tot_cntr|inv_tot_amt|ar_if_cntr|ar_if_amt|ar_if_m_amt|ar_if_oth_amt|ar_if_tot_cntr|ar_if_tot_amt||coll_cntr|coll_amt|coll_m_amt|coll_tot_cntr|coll_tot_amt", -1, false, false, -1
						, "ofc_cd=%s;tariff=%s;curr_cd=;seq=S.TTL");
 			
 			SumText(0, "seq") = "TTL";
 		}
 	}
    
    
	/* 개발자 작업  끝 */