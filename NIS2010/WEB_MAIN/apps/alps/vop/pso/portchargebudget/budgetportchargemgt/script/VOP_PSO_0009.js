/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_pso_0009.js
*@FileTitle : Estimate VVD Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.07.06 김진일
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
     * @class vop_pso_0009 : vop_pso_0009 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_pso_0009() {
    	this.processButtonClick		= processButtonClick;
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
    
    var isShift = false;
    
    var gHeadRowHeight = 30;		//Head Row Height

    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){

       sheetObjects[sheetCnt++] = sheet_obj;

    }
    
    /**
     * PageLoad시 초기화 처리 
     */
    function loadPage(){
    	//initSheet(sheetObjects[0],1);
    	for(i=0;i<sheetObjects.length;i++){
    		ComConfigSheet (sheetObjects[i] );
    		initSheet(sheetObjects[i],i+1);
    		ComEndConfigSheet(sheetObjects[i]);
    	} 
    	 
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
      switch(sheetid) {

	  	case "sheet1":
			with (sheetObj) {
				// 높이 설정
				style.height = 440;
				
				MultiSelection = false;
	
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = false;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);
	
				var HeadTitle1 = "|Rev Month|Target VVD|Rev Dir|Rev Lane|Type|Estimate Creation ID|Estimate Creation Date|Estimate O/I CD";
				var headCount = ComCountHeadTitle(HeadTitle1);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, true, true, true, false,false);
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				var prefix = "sheet1_";
	
				//데이터속성    [ROW, COL,  DATATYPE,   		WIDTH, 	DATAALIGN, 	COLMERGE, 	SAVENAME,  					KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,		prefix+"ibflag" );
				InitDataProperty(0, cnt++ , dtData,			100,		daCenter,	true,		prefix+"rev_yrmon",		false,		"",			dfDateYm,			0,		true,  		true);
				InitDataProperty(0, cnt++ , dtData,			100,		daCenter,	true,		prefix+"vvd",		false,		"",			dfNone,			0,		true,  		true);
				InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,		prefix+"rev_dir_cd",		false,		"",			dfNone,			0,		true,  		true);
				InitDataProperty(0, cnt++ , dtData,			100,		daCenter,	true,		prefix+"rlane_cd",		false,		"",			dfNone,			0,		true,  		true);
				InitDataProperty(0, cnt++ , dtData,			100,		daCenter,	true,		prefix+"estm_vvd_tp_cd",		false,		"",			dfNone,			0,		true,  		true);
				InitDataProperty(0, cnt++ , dtData,			170,		daCenter,	true,		prefix+"cre_usr_id",		false,		"",			dfNone,			0,		true,  		true);
				InitDataProperty(0, cnt++ , dtData,			170,		daCenter,	true,		prefix+"cre_dt",		false,		"",			dfNone,			0,		true,  		true);
				InitDataProperty(0, cnt++ , dtData,			100,		daCenter,	true,		prefix+"estm_ioc_div_cd",		false,		"",			dfNone,			0,		true,  		true);
	
				CountPosition = 2;
				ShowButtonImage = 1;
				HeadRowHeight = gHeadRowHeight;
				
				//InitDataValid(0, prefix+"formula_no", vtNumericOnly);	//숫자만 입력
			}
			break;
        }
    }
    /**
     * 컨트롤 관련 초기화 처리 
     */
    function initControl(){
    	setToday(document.form.rev_yrmon, "ym");//이번달로 설정

    	axon_event.addListener ('keydown', 'obj_keydown', 'form');
    	axon_event.addListenerFormat('keypress',  'obj_keypress', 	form);
    	axon_event.addListenerForm('keyup', 'obj_keyup', form); //Focus이동관련
    	axon_event.addListenerFormat('beforeactivate', 	'obj_focus',    	form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
    	axon_event.addListenerFormat('beforedeactivate',  	'obj_blur',  	form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
    	//budget year필드를 올해로 설정
    	//alert(setToday("y"));
    }
     function obj_keydown(){
        	isShift = event.shiftKey ? true : false;
//        	ComKeyEnter();
        }
    /**
     * onBlur처리 
     * @return
     */
    function obj_blur(){
        ComChkObjValid(event.srcElement);
    }

    /**
     * onFocus처리 
     * @return
     */
    function obj_focus(){
        ComClearSeparator(event.srcElement);
    }
    /**
     * keypress처리 함수
     * @return
     */
    function obj_keypress(){
  	    obj = event.srcElement;
  	    if(obj.dataformat == null) return;
  	    window.defaultStatus = obj.dataformat;
  	
  	    switch(obj.dataformat) {
  	        case "ymd":
  	        case "ym":
  	        case "hms":
  	        case "hm":
  	        case "jumin":
  	        case "saupja":
  	            ComKeyOnlyNumber(obj);
  	            break;
  	        case "int":
  	            if(obj.name=="txtInt") ComKeyOnlyNumber(obj, "-")
  	            else ComKeyOnlyNumber(obj);
  	            break;
  	        case "float":
  	            ComKeyOnlyNumber(obj, "-.");
  	            break;
  	        case "eng":
  	            ComKeyOnlyAlphabet(); break;
  	        case "engup":
  	            if(obj.name=="txtEngUp2") ComKeyOnlyAlphabet('uppernum');
  	            else if(obj.name==="vndr_lgl_eng_nm") toUpper();//소문자만 대문자로.
  	            else if(obj.name==="vsl_slan_cd") ComKeyOnlyAlphabet('uppernum');	//영대문자와 숫자
  	            else ComKeyOnlyAlphabet('upper');
  	            break;
  	        case "engdn":
  	            if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
  	            else ComKeyOnlyAlphabet('lower');
  	            break;
  	    }
  	}
   /**
    * KEYUP의 경우 FOCUS이동 처리를 한다. 
    * @return
    */
	function obj_keyup() {
		var eleObj = event.srcElement;
		var formObj = document.form;
		
		//KEYTYPE이 마우스 클릭이면 리턴.
//		if (!event.keyCode) return;
		if(event.keyCode === 9 || event.keyCode === 16) return ;
		
		switch (eleObj.name) {
		case "rev_yrmon":
			if (eleObj.value.length == 6) {
				formObj.vsl_slan_cd.focus();
			}
			break;
		default:
			break;
	
		}
	}

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

             var sheetObject1 = sheetObjects[0];

             /*******************************************************/
             var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

                switch(srcName) {
	                case "btns_calendar_s":
	                	var cal = new ComCalendar();
	                	cal.setDisplayType('month');
	    	            cal.select(form.rev_yrmon, "yyyy-MM");
	                	break;
                	case "btn_creation":
    					if(!ComShowCodeConfirm("PSO00041", "create data")){
    						break;
    					}
                		ComOpenWait(true);
                		doActionIBSheet(sheetObject1,formObject,IBCREATE);
                		ComOpenWait(false);                		
    					break;
                	case "btn_retrieve":
                		ComOpenWait(true);
                		doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                		ComOpenWait(false);                		
                		break;
		            case "btns_search": //slane code button click
			        	  openLaneCode();
			            break;

		            case "btn_down_excel":
						/* SpeedDown2Excel([Mode], [UseOpenFile], [NewSheet], [SaveAsName],[ReportPageUrl],[HideExcelMsg],[WriteTreeLevel], [WorkSheetName],[FocusFirstSheet],[ColumnSkipList],[RowSkipList],[bProtect], [IncludeImageType]) 
						 * [Mode] 내려 받기 종류 옵션. Default=0  -1이면 DataType이 dtStatus, dtHiddenStatus, dtDelCheck, dtDelCehckEx, dtHidden, dtResult에 해당하는 컬럼의 데이터는 내려 받지 않는다.
						 * Down2Excel([Mode], [UseOpenFile], [NewSheet], [Merge], [SaveAsName],[ReportPageUrl],
						 */
						 
						 if(sheetObjects[0].RowCount == 0){
							 return;
						 }
						 sheetObjects[0].SpeedDown2Excel(-1, true);

						break;			            
			            
			            
		            default : break;
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
         *  Sheet관련 프로세스 처리
         */ 
        function doActionIBSheet(sheetObj,formObj,sAction) {
             sheetObj.ShowDebugMsg = false;
             sheetObj.WaitImageVisible=false;
             switch(sAction) {
             	case IBCREATE://Creation Button Click 시 처리
             		if ( sheetObj.id == "sheet1"){
						formObj.f_cmd.value = ADD;
						ComOpenWait(true);
						var sXml = sheetObj.GetSearchXml("VOP_PSO_0009GS.do", FormQueryString(formObj));
						sheetObjects[0].LoadSearchXml(sXml);
						var statusCode = ComGetEtcData(sXml, "BatchStatus" );
						ComOpenWait(false);
						switch(statusCode){
//							case "0": // H/C
							case "4":	//Completed
								ComShowCodeMessage("COM12116", "Estimate VVD Creation Excution");
								break;
							case "5":	//failed
								ComShowCodeMessage("COM12151", "Estimate VVD Creation Excution");
								break;
							case "6":	//Processing
								formObj.status.value = "Processing";
								ComShowCodeMessage("PSO00038", "Estimate VVD Creation");
								break;
							default: break;							
						}
             		}
             		break;
             	case IBSEARCH:      //조회
 					if(validateForm(sheetObj,formObj,sAction)){
 						if ( sheetObj.id == "sheet1"){
 							var aryPrefix = new Array("sheet1_");
 							formObj.f_cmd.value = SEARCH;
 			                
 			                sheetObjects[0].WaitImageVisible = false;
 			                var sXml = sheetObj.GetSearchXml("VOP_PSO_0009GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
 			                var isRunning = ComGetEtcData(sXml, "IS_RUNNING");
 			                formObj.status.value = isRunning == "true" ? "Processing" : "";
 			                sheetObjects[0].LoadSearchXml(sXml);
 						}
 					}
 					break;
 					
             	case IBSEARCH_ASYNC01:      //OPEN (Check Running Batch)
         			var aryPrefix = new Array("sheet1_");
         			formObj.f_cmd.value = COMMAND02;
         			
         			sheetObjects[0].WaitImageVisible = false;
         			var sXml = sheetObj.GetSearchXml("VOP_PSO_0009GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
         			var isRunning = ComGetEtcData(sXml, "IS_RUNNING");
         			formObj.status.value = isRunning == "true" ? "Processing" : "";
         			sheetObjects[0].LoadSearchXml(sXml);
	             	break;
             }
         }
         
		function sheet1_OnLoadFinish(sheetObj){ 
			var formObj = document.form;
			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);	//Check Running Batch
		}         
         
         
        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
            with(formObj){
            	switch(sAction){
	        		case IBSEARCH:
			        	if(rev_yrmon.value == "" || rev_yrmon.value.length != 7){
			        		ComShowCodeMessage("PSO00022", "[Working Month]");
			        		ComSetFocus(rev_yrmon);
			        		return false;
			        	}
			        	break;
            	}	
            }

            return true;
        }
            
            /**
             * VOP_VSK-0202 Lance Code Help 팝업 창 오픈 
             
             function openLaneCode(){
          	   ComOpenPopup('/hanjin/VOP_VSK_0202.do', 700, 474, 'setLaneCode', '0,0', false, false);
             }
             
             function setLaneCode(aryPopupData, row, col, sheetIdx){
          	   document.form.vsl_slan_cd.value = aryPopupData[0][1];
             }
             */
         

	/* 개발자 작업  끝 */