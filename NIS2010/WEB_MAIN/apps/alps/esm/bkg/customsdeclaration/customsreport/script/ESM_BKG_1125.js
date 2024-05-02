/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_BKG_1125.js
*@FileTitle : CANADA ACI : ACI Monitoring
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.13
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2011.07.13 김봉균
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
     * @class ESM_BKG_1125 : ESM_BKG_1125 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_1125() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnKeyUp     = sheet1_OnKeyUp;
    }
    
   	/* 개발자 작업	*/

    
	// 공통전역변수
	
	var sheetObjects = new Array();
	var sheetCnt = 0;

    var comboObjects = new Array();
    var combo1 = null;
    var comboCnt = 0;	
	
    //전역변수
    var intervalId = "";

    
    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){

    	sheetObjects[sheetCnt++] = sheet_obj;
    }
    
    /**
     * 콤보 Object를 comboObjects 배열에 등록
     * @param combo_obj
     * @return
     */
    function setComboObject(combo_obj) {
    	comboObjects[comboCnt++] = combo_obj; 
    }
    
    
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */                    
    function loadPage() {
    	var formObj = document.form;
    	
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		  //MultiCombo초기화 
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],comboObjects[k].id);
	    }
	    
		//화면에서 필요한 이벤트
		initControl();

	}
    
     function initControl() {
     	var formObject = document.form;
     	
     	axon_event.addListenerForm  ('click', 'bkg_click',  formObject); //- onClick     
        axon_event.addListenerForm  ('blur', 'bkg_blur',  formObject); //- 포커스 나갈때     
        axon_event.addListenerFormat('focus', 'bkg_focus',    formObject); //- 포커스 들어갈때
        axon_event.addListenerForm  ('change', 'bkg_change', formObject);
        axon_event.addListenerFormat('beforedeactivate', 'bkg_deactivate',  formObject); //- 포커스 나갈때     
        axon_event.addListenerFormat('beforeactivate', 'bkg_activate',    formObject); //- 포커스 들어갈때
        axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
        axon_event.addListenerFormat('keyup', 'obj_KeyUp', formObject); //- 키보드 입력할때
        axon_event.addListener      ('keydown', 'ComKeyEnter', 'form');

 		// IBMultiCombo초기화
 	    for(var k=0; k<comboObjects.length; k++){
 	        initCombo(comboObjects[k]);
 	    }
     	doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);        
     }
     
  	/**
   	 * Combo 기본 설정 
   	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
   	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
  	* @param {object} combo 필수, 초기화하는 IBMultiCombo Object.
  	* @param {String} comboId 필수,combo ID
  	* @return 없음. 
   	 */ 
   	function initCombo(comboObj, comboId) {
   		comboObj.DropHeight = 150;
   	}
   	
          
/*********************** KEY EVENT START ********************/ 	 
	function bkg_keypress(){
	    switch(event.srcElement.dataformat){
	    	case "ymd":
	        //number
	        ComKeyOnlyNumber(event.srcElement, "-");
	        break;
	    	case "engup":
	        //영문대문자
    			ComKeyOnlyAlphabet('upper');
	        break;
	      case "engupnum":
	        //숫자+"영문대분자"입력하기
	      	ComKeyOnlyAlphabet('uppernum');
	        break;
	      case "num":
	        //숫자 입력하기
	        ComKeyOnlyNumber(event.srcElement);
	        break;
	      case "custname":
	        //영문,숫자,공백,기타문자(.,등)
	        ComKeyOnlyAlphabet('uppernum','40|41|46|44|32|42|38|35|45');
	      break;	            
	      default:
	      break;
	    }
	}  
	
	
	var preVvd;//이전에 조회했던 VVD에서 Focus Out 되면 재조회 하지 않는다.
	var prePodCd;
	/**
     * HTML Control의 onBlur을 제어한다.
     **/
    function bkg_blur() {
    	var formObj = document.form;    	
	    switch (event.srcElement.getAttribute("name")) {
	    	case "p_from_dt":
	    		ComAddSeparator(event.srcElement);
					break;	    		
	    	case "p_to_dt":
	    		ComAddSeparator(event.srcElement);
					break;	    		
//	    	case "bkg_from_dt":
//	    		ComAddSeparator(event.srcElement);
//					break;	    		
//	    	case "bkg_to_dt":
//	    		ComAddSeparator(event.srcElement);
//					break;	    		
			default:
				break;
	    }
    }           

	/**
	 * HTML Control의 onFocus 이벤트에서 Validation을 체크한다. <br>
	 **/
	function bkg_focus(){
		//입력Validation 확인하기
		switch(event.srcElement.name){	
	    	case "p_from_dt":
	    		ComClearSeparator(event.srcElement);
					break;
	    	case "p_to_dt":
	    		ComClearSeparator(event.srcElement);
					break;
		}
	}       
	
	function div_init(){
		initSheet(sheetObjects[0],1);
		//sheetObjects[0].RangeBackColor(1,8,2,14)=sheetObjects[0].RgbColor(203,210,248);
		form.div_total_bl_cnt.value      = "";
		form.div_acc_bl_cnt.value       = "";
		form.div_rej_bl_cnt.value       = "";
		form.div_nrcv_bl_cnt.value       = "";
		form.div_donld_bl_cnt.value     = "";
		form.div_rlse_bl_cnt.value     = "";
		form.div_unsent_bl_cnt.value     = "";
		form.div_podirr_bl_cnt.value     = "";
		
		form.div_total_cms_cnt.value     = "";
		form.div_total_shaas_ens.value     = "";
		form.div_total_nycna_ens.value     = "";
		form.div_total_hamur_ens.value     = "";
		form.div_total_sinwa_ens.value     = "";
		form.div_total_vvd_cnt.value     = "";
		
		form.div_total_mcf_amt.value     = "";
		form.div_total_shaas_mcf.value     = "";
		form.div_total_nycna_mcf.value     = "";
		form.div_total_hamur_mcf.value     = "";
		form.div_total_sinwa_mcf.value     = "";
		form.div_total_amd_cnt.value     = "";
	}
	
	function bkg_click(){
		switch(event.srcElement.name){	
		case "p_rhq_gb":
			if(document.form.p_rhq_gb[0].checked){
				// 초기화
				div_init();
				document.getElementById("p_pol_ofc").style.display="inline";
				document.getElementById("p_bkg_ofc").style.display="none";
			} else if(document.form.p_rhq_gb[1].checked){
				// 초기화
				div_init();
				document.getElementById("p_pol_ofc").style.display="none";
				document.getElementById("p_bkg_ofc").style.display="inline";
			}
				break;
		}
	}
	
     /**
      * 조회후 이벤트 처리 >>> 폰트 칼라변경
      */
     function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
         with (sheetObj) {
             var redColor  = RgbColor(255, 0, 0);
             for(var i= HeaderRows; i<= LastRow; i++) {
                if (CellValue(i,"rejected") != "0") {
                	CellFontColor(i,"rejected") = redColor;
                }
                if (CellValue(i,"not_received") != "0") {
                	CellFontColor(i,"not_received") = redColor;
                }
                if (CellValue(i,"unsent") != "0") {
                	CellFontColor(i,"unsent") = redColor;
                }
             }
             ColumnSort("1|2|3|4|5|6|7|8|9");
         }//end width
     }	     
     
     /**
      * 컬럼이동 전 validation 처리 >>> 이동취소
      */
     function sheet1_OnBeforeColumnMove(sheetObj, Col, NewPos) {
    	 with (sheetObj) {
    		 if(NewPos>9){
    			 MoveColumnFail = true;
    		 }
    		 if(Col>9){
    			 MoveColumnFail = true;
    		 }
    	 }
     }	     
     
     /**
      * 컬럼이동 후 이벤트 처리 >>> 재소트
      */
     function sheet1_OnAfterColumnMove(sheetObj, Col, NewPos) {
    	 with (sheetObj) {
    		 var colNo = "";
    		 
	    	 for(var i= NewPos; i< LastCol; i++) {
	    		 colNo = colNo + "|" + i;
	    	 }
	    	 ColumnSort(colNo);
    	 }
     }	     
	    
 	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 	document.onclick = processButtonClick;
 	
 	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
     	
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
 	         var sheetObject1 = sheetObjects[0];
          /*******************************************************/
          var formObject = document.form;

     	//try {
     		var srcName = window.event.srcElement.getAttribute("name");
                                            
            switch(srcName) {

 				case "btn_Retrieve":
 					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
 					break;
 				case "btn_New":
 					formObject.reset();
 					document.getElementById("p_pol_ofc").style.display="inline";
 					document.getElementById("p_bkg_ofc").style.display="none";
 					document.form.rhq.index = -1;
 					div_init();
					
 					break;
 				case "btn_DownExcel":
 					sheetObject1.SpeedDown2Excel(-1);
 					break;
 				case "btn_date":	
 					var cal = new ComCalendarFromTo();
 					cal.setEndFunction("endDateSet");
					cal.select(formObject.p_from_dt, formObject.p_to_dt,'yyyy-MM-dd');
					break;
 					
             } // end switch
     }

	 function endDateSet(){
		 if (ComIsNull(form.p_from_mt)) {
			form.p_from_mt.value ="00:00";
		 }
		 if (ComIsNull(form.p_to_mt)) {
			 form.p_to_mt.value ="23:59";
		 }
	  }

	 /**
     * Sheet관련 프로세스 처리<br>
     * 
     * @param sheetObj
     * @param formObj
     * @param sAction
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {

    	sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {
        	case IBCLEAR: // 화면 로딩시 코드 조회
        		formObj.f_cmd.value = COMMAND01;
			
        		var sXml = sheetObj.GetSearchXml("ESM_BKG_1125GS.do", FormQueryString(formObj));
        		var arrXml = sXml.split("|$$|");
        		if (arrXml.length > 0) 
        			ComXml2ComboItem(arrXml[0], formObj.rhq, "val", "name");
			
				formObj.rhq.index = -1;
				
			break;
			case IBSEARCH : // 조회
				if(!validateForm(sheetObj,formObj,sAction)) return;
				
				sheetObj.Redraw = false;    
				sheetObj.WaitImageVisible = true;
				
				formObj.f_cmd.value = SEARCH;
				sheetObj.RemoveAll();
				
				var sXml =  sheetObj.GetSearchXml("ESM_BKG_1125GS.do", FormQueryString(formObj));
					
				sheetObj.LoadSearchXml(sXml);
				
				if(ComGetEtcData(sXml,"total_bl_cnt") == undefined){
					formObj.div_total_bl_cnt.value      = "0";
					formObj.div_acc_bl_cnt.value       = "0";
					formObj.div_rej_bl_cnt.value       = "0";
					formObj.div_nrcv_bl_cnt.value       = "0";
					formObj.div_donld_bl_cnt.value     = "0";
					formObj.div_rlse_bl_cnt.value      = "0";
					formObj.div_unsent_bl_cnt.value     = "0";
					formObj.div_podirr_bl_cnt.value     = "0";
					
					formObj.div_total_cms_cnt.value     = "0";
					formObj.div_total_shaas_ens.value     = "0";
					formObj.div_total_nycna_ens.value     = "0";
					formObj.div_total_hamur_ens.value     = "0";
					formObj.div_total_sinwa_ens.value     = "0";
					formObj.div_total_vvd_cnt.value     = "0";
					
					formObj.div_total_mcf_amt.value     = "0";
					formObj.div_total_shaas_mcf.value     = "0";
					formObj.div_total_nycna_mcf.value     = "0";
					formObj.div_total_hamur_mcf.value     = "0";
					formObj.div_total_sinwa_mcf.value     = "0";
					formObj.div_total_amd_cnt.value     = "0";
				}else{
					formObj.div_total_bl_cnt.value      = ComGetEtcData(sXml,"total_bl_cnt");
					formObj.div_acc_bl_cnt.value       = ComGetEtcData(sXml,"acc_bl_cnt");
					formObj.div_rej_bl_cnt.value       = ComGetEtcData(sXml,"rej_bl_cnt");
					formObj.div_nrcv_bl_cnt.value       = ComGetEtcData(sXml,"nrcv_bl_cnt");
					formObj.div_donld_bl_cnt.value     = ComGetEtcData(sXml,"donld_bl_cnt");
					formObj.div_rlse_bl_cnt.value		= ComGetEtcData(sXml,"rlse_bl_cnt");	
					formObj.div_unsent_bl_cnt.value     = ComGetEtcData(sXml,"unsent_bl_cnt");
					formObj.div_podirr_bl_cnt.value		= ComGetEtcData(sXml,"podirr_bl_cnt");
					
					formObj.div_total_cms_cnt.value     = ComGetEtcData(sXml,"total_cms_cnt");
					formObj.div_total_shaas_ens.value     = ComGetEtcData(sXml,"total_shaas_ens");
					formObj.div_total_nycna_ens.value     = ComGetEtcData(sXml,"total_nycna_ens");
					formObj.div_total_hamur_ens.value     = ComGetEtcData(sXml,"total_hamur_ens");
					formObj.div_total_sinwa_ens.value     = ComGetEtcData(sXml,"total_sinwa_ens");
					formObj.div_total_vvd_cnt.value     = ComGetEtcData(sXml,"total_vvd_cnt");
					
					formObj.div_total_mcf_amt.value     = ComGetEtcData(sXml,"total_mcf_amt");
					formObj.div_total_shaas_mcf.value     = ComGetEtcData(sXml,"total_shaas_mcf");
					formObj.div_total_nycna_mcf.value     = ComGetEtcData(sXml,"total_nycna_mcf");
					formObj.div_total_hamur_mcf.value     = ComGetEtcData(sXml,"total_hamur_mcf");
					formObj.div_total_sinwa_mcf.value     = ComGetEtcData(sXml,"total_sinwa_mcf");
					formObj.div_total_amd_cnt.value     = ComGetEtcData(sXml,"total_amd_cnt");
					
				}
				
				sheetObj.Redraw = true;
				sheetObj.WaitImageVisible = false;
			
				break;
				
        }//end switch
    }
    

    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	
	    switch(sAction) {
	    	case IBSEARCH:
    			
	    		//기본포멧체크
    			if (ComIsNull(formObj.p_vvd)) {
		    		if (ComIsNull(formObj.p_from_dt)) {
		    			ComShowCodeMessage('BKG00104','From Date'); //"Mandatory item is missing. Please enter ({?msg1})"
		    			formObj.p_from_dt.focus();
		    			return false;    
		    		}
	    			if (ComIsNull(formObj.p_to_dt)) {
	    				ComShowCodeMessage('BKG00104','To Date'); //"Mandatory item is missing. Please enter ({?msg1})"
	 					formObj.p_to_dt.focus();
	 					return false;    
	    			}
	    			if(ComGetDaysBetween(formObj.p_from_dt, formObj.p_to_dt) < 0) {
	    				ComShowMessage(msgs['BKG00818']); //"From Date couldn't be greater than ToDate."
	    				return false;
	    			}
    			}
	    		if ( (!ComIsNull(formObj.p_from_dt) && !ComIsNull(formObj.p_to_dt)) ) {
		    		
	    			if( ComGetDaysBetween(formObj.p_from_dt.value,formObj.p_to_dt.value) +1 > 31){
		    			ComShowCodeMessage('COM132001','Send/Received Date','31 Days'); //'{?msg1} exceeds maximum duration {?msg2}.'
		    			formObj.p_from_dt.focus();
		    			return false;
		    		}
	    			return true;
	    		}

				break;
	    }
        return true;

    }
    
    /**
     * 조회조건 입력할 때 처리
     */
    function obj_KeyUp() {
    	var formObject = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
    	var srcValue = window.event.srcElement.getAttribute("value");
    	if ((srcName == "p_vvd" || srcName == "p_pol") && ComChkLen(srcValue, srcMaxLength) == "2") {
    		ComSetNextFocus();
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
						style.height = 390;
						//전체 너비 설정
						SheetWidth = mainTable.clientWidth;
						
						//Host정보 설정[필수][HostIp, Port, PagePath]
						if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
						
						//전체Merge 종류 [선택, Default msNone]
						//MergeSheet = msAll;
						MergeSheet = msPrevColumnMerge + msHeaderOnly;//msPrevColumnMerge;
						
						//전체Edit 허용 여부 [선택, Default false]
						Editable = true;
						var HeadTitle1 = "";
						var HeadTitle2 = "";
						//var HeadTitle3 = "";
						//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
						InitRowInfo(2, 1, 2, 100);

						if(document.form.p_rhq_gb[0].checked){						
							HeadTitle1 = "|VVD|LANE|RHQ|POL OFC|POL|POD|BL\nTYPE|BL Count|Sent Status|Sent Status|Sent Status|Sent Status|Sent Status|Sent Status|Sent Status|Unsent|Amend\ncount|Surcharge|Surcharge";
							HeadTitle2 = "|VVD|LANE|RHQ|POL OFC|POL|POD|BL\nTYPE|BL Count|Acpt\n(06)|Rej\n(44)|DNL\n(37)|Release\n(01)|POD\nHold\n(21)|Do not\nunload\n(48)|Not\nRcvd|Unsent|Amend\ncount|CMS+SMC|MCF";
						}else if(document.form.p_rhq_gb[1].checked){
							HeadTitle1 = "|VVD|LANE|RHQ|BKG OFC|POL|POD|BL\nTYPE|BL Count|Sent Status|Sent Status|Sent Status|Sent Status|Sent Status|Sent Status|Sent Status|Unsent|Amend\ncount|Surcharge|Surcharge";
							HeadTitle2 = "|VVD|LANE|RHQ|BKG OFC|POL|POD|BL\nTYPE|BL Count|Acpt\n(06)|Rej\n(44)|DNL\n(37)|Release\n(01)|POD\nHold\n(21)|Do not\nunload\n(48)|Not\nRcvd|Unsent|Amend\ncount|CMS+SMC|MCF";							
						}
				        var headCount = ComCountHeadTitle(HeadTitle1);
						
						headCount = ComCountHeadTitle(HeadTitle1);
						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
						InitColumnInfo(headCount, 0, 0, true);
						
						// 해더에서 처리할 수 있는 각종 기능을 설정한다
						//([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D])
						InitHeadMode(true, true, false, true, false,false);
						
						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
						InitHeadRow(0, HeadTitle1, true);
						InitHeadRow(1, HeadTitle2, true);
						
				        //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(0, cnt++,  dtHiddenStatus, 0, 	daCenter,  true, "ibflag");
						//InitDataProperty(0, cnt++ , dtData,   40,  daCenter,  true,  "dt_seq",          false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  65,  daCenter,  true,  "vvd",          false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  35,  daCenter,  true,  "lane",         false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  45,  daCenter,  true,  "rhq",          false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  55,  daCenter,  true,  "bkg_ofc",          false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  50,  daCenter,  true,  "pol",          false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  50,  daCenter,  true,  "pod",          false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  35,  daCenter,  true,  "bl_type",       false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  60,  daCenter,  true,  "bl_count",       false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  50,  daCenter,  true,  "accepted",       false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  50,  daCenter,  true,  "rejected",       false,  "",  dfNone,  0,  false,  false);
						//InitDataProperty(0, cnt++ , dtData,  60,  daCenter,  true,  "ens_snt_nrcv",       false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  50,  daCenter,  true,  "dnl",       false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  50,  daCenter,  true,  "released",       false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  50,  daCenter,  true,  "pod_hold",       false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  50,  daCenter,  true,  "do_not_unload",       false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  50,  daCenter,  true,  "not_received",       false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  50,  daCenter,  true,  "unsent",       false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  50,  daCenter,  true,  "amend_cnt",       false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  70,  daCenter,  true,  "cms_smc_amt",       false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  60,  daCenter,  true,  "mcf_amt",       false,  "",  dfNone,  0,  false,  false);
						CountPosition = 0;
						
					}
				break;
		}//end switch
 	}       
    /* 개발자 작업  끝 */